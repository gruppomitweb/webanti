function ZtStackAreaChart() {
  StdChart.apply(this, ["STACKEDAREA", "f1fe"]);
  this.itemsHover = [];
  this.holesIndexList = {};
  this.applyCalculationAfter = true;
}
ZtStackAreaChart.prototype = Object.create(ZtAreaChart.prototype);
ZtStackAreaChart.prototype.constructor = ZtStackAreaChart;

ZtStackAreaChart.prototype._SetChartSettingsJSON = function () {
  ZtAreaChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.normalizeValues = this.chartConfig.graphSettings.normalized;
  this.multipleScales = false;
}

ZtStackAreaChart.prototype._SetCalculationDataset = function () {
  var vf = this._GetDrawingList();
  if (this.defSettings.normalizeValues)
    this.dataSet = getPercentDataset(vf, this.propertyName, this.dataSet, this.totalsSeries, false);
  this.calcDataset = getStackDataset(vf, this.propertyName, this.dataSet, true);
  this.allValues = getValues(vf, this.propertyName, this.calcDataset);
  this._EvaluateAllValuesCalc();
}

ZtStackAreaChart.prototype._DrawChartElements = function () {
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  sgroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroupS")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  hgroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroupH")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var yIndex = -1,
  dSeries = this._GetDrawingList(),
  cobj = {},
  cData,
  cdData;

  if (this.domainIsTime && (typeof this.calcDataset[0][this.xIndex] == "string")) {
    // devo trasformare la data da stringa ISO - ottimizzare
    for (var tt = 0; tt < this.calcDataset.length; tt++) {
      var record = this.calcDataset[tt];
      record[this.xIndex] = new Date(Date.parse(record[this.xIndex]));
    }
  } 
  
  for (var i = 0; i < dSeries.length; i++) {
    yIndex = this.propertyName.indexOf(dSeries[i]);
    group.append("clipPath")
      .attr("id", this.chartId + i + "_clip")
        .append("rect")
          .attr("width", 1)
          .attr("height", this.chartHeight);
    cobj = {};
    cobj.scaleY = this.scaleY[dSeries[i]];
    if (!this.holesIndexList[dSeries[i]])
      this.holesIndexList[dSeries[i]] = [];
    if (!this.domainIsTime || (this.domainIsTime && this.defSettings.time.dataType == "default")) {
      cData = this.dataSet;
      cdData = this.calcDataset;
    }
    else {
      cData = this._EvaluateTimeDataset(this.dataSet, this.xIndex, yIndex, this.holesIndexList[dSeries[i]]);
      cdData = this._EvaluateTimeDataset(this.calcDataset, this.xIndex, yIndex, this.holesIndexList[dSeries[i]]);
    }
    this.DrawLine(group, cdData, i, this.xIndex, yIndex, cobj);
    if (i == 0)
      this.DrawArea(group, cData, i, this.xIndex, yIndex, cobj);
    else {
      cobj.prevYIndex = this.propertyName.indexOf(dSeries[i - 1]);
      this.DrawStackArea(group, cData, cdData, i, this.xIndex, yIndex, cobj);
    }
    cobj.valueField = dSeries[i];
    this.DrawShapes(sgroup, cdData, i, this.xIndex, yIndex, cobj);

    hgroup.append("clipPath")
      .attr("id", this.chartId + "clipArea_" + i)
        .append("path")
          .attr("d", d3.select(this.items[this.items.length - 1].itm).attr("d"));

    this._DrawRectHover(hgroup, this.chartId + "clipArea_" + i, cdData, i, this.items.length - 1, cData);
  }
}

ZtStackAreaChart.prototype._DrawHoverCount = function (animate) {
  var container = d3.select("#" + this.chartId + this.type + "_elementGroupH"),
  xIndex = this.xIndex,
  yIndex,
  _this = this,
  cobj = {},
  maxValue,
  data = this.calcDataset.filter( function (record) {
                                      return _this._IsNotExcludedDomain(record[xIndex]);
                                  }
                                ),
  odata = this.dataSet.filter( function (record) {
                                      return _this._IsNotExcludedDomain(record[xIndex]);
                                  }
                                ),
  minSer = d3.min(data.map(function(record){ return record[yIndex]})),
  dSeries = this._GetDrawingList(),
  items = this.items,
  areaitem,
  lineitem;

  for (var ii = items.length - 1; ii >= 0; ii = ii - 2) {
    areaitem = items[ii];
    lineitem = items[ii - 1];

    cobj = {};
    cobj.scaleY = this.scaleY[lineitem.valueField];
    cobj.line = lineitem.itm;
    cobj.item = areaitem;
    if (dSeries.indexOf(lineitem.valueField) > 0) {
      cobj.prevLine = items[ii - 3].itm;
      cobj.prevIndex = this.propertyName.indexOf(this.valueFields[dSeries.indexOf(lineitem.valueField) - 1]);
    }

    yIndex = this.propertyName.indexOf(lineitem.valueField);
    maxValue = cobj.scaleY.domain()[0];

    // line è la linea che delimita gli estremi dell'intervallo tra i due valori di coords
    // pts[0] e pts[last] sono i punti di apertura e chiusura
    for (var i = 0; i < data.length; i++) {
      var line = {},
      linep = {},
      pts = [],
      mdata,
      mdatap,
      mdatanext,
      mdatanextp,
      mdataprec,
      mdataprecp,
      minValue = cobj.scaleY.domain()[1];
      if (minSer < 0 && data[i][yIndex] >= 0)
        minValue = 0;
      if (minSer >= 0 && minValue < 0)
        minValue = 0;
      var lim = (data[i][yIndex] >= 0) ? minValue : 0;

      if (i - 1 >= 0) {
        if (data[i - 1][yIndex] <= maxValue && data[i - 1][yIndex] >= minValue)
          mdataprec = data[i - 1][yIndex];
        else if (minValue <= data[i - 1][yIndex] && maxValue <= data[i - 1][yIndex])
          mdataprec = maxValue;
        else if (minValue >= data[i - 1][yIndex] && data[i - 1][yIndex] >= 0)
          mdataprec = minValue;
        else
          mdataprec = data[i - 1][yIndex];
      }

      if (data[i][yIndex] <= maxValue && data[i][yIndex] >= minValue)
        mdata = data[i][yIndex];
      else if (minValue <= data[i][yIndex] && maxValue <= data[i][yIndex])
        mdata = maxValue;
      else if (minValue >= data[i][yIndex])
        mdata = minValue;

      if (i + 1 < data.length) {
        if (data[i + 1][yIndex] <= maxValue && data[i + 1][yIndex] >= minValue)
          mdatanext = data[i + 1][yIndex];
        else if (minValue <= data[i + 1][yIndex] && maxValue <= data[i + 1][yIndex])
          mdatanext = maxValue;
        else if (minValue >= data[i + 1][yIndex] && data[i + 1][yIndex] >= 0)
          mdatanext = minValue;
        else
          mdatanext = data[i + 1][yIndex];
      }

      // valutazione del precedente - solo se c'è il precedente
      if (cobj.prevIndex && cobj.prevIndex >= 0) {
        if (minSer < 0 && data[i][cobj.prevIndex] >= 0)
          minValue = 0;
        if (minSer >= 0 && minValue < 0)
          minValue = 0;

        if (i - 1 >= 0) {
          if (data[i - 1][cobj.prevIndex] <= maxValue && data[i - 1][cobj.prevIndex] >= minValue)
            mdataprecp = data[i - 1][cobj.prevIndex];
          else if (minValue <= data[i - 1][cobj.prevIndex] && maxValue <= data[i - 1][cobj.prevIndex])
            mdataprecp = maxValue;
          else if (minValue >= data[i - 1][cobj.prevIndex] && data[i - 1][cobj.prevIndex] >= 0)
            mdataprecp = minValue;
          else
            mdataprecp = data[i - 1][cobj.prevIndex];
        }

        if (data[i][cobj.prevIndex] <= maxValue && data[i][cobj.prevIndex] >= minValue)
          mdatap = data[i][cobj.prevIndex];
        else if (minValue <= data[i][cobj.prevIndex] && maxValue <= data[i][cobj.prevIndex])
          mdatap = maxValue;
        else if (minValue >= data[i][cobj.prevIndex])
          mdatap = minValue;

        if (i + 1 < data.length) {
          if (data[i + 1][cobj.prevIndex] <= maxValue && data[i + 1][cobj.prevIndex] >= minValue)
            mdatanextp = data[i + 1][cobj.prevIndex];
          else if (minValue <= data[i + 1][cobj.prevIndex] && maxValue <= data[i + 1][cobj.prevIndex])
            mdatanextp = maxValue;
          else if (minValue >= data[i + 1][cobj.prevIndex] && data[i + 1][cobj.prevIndex] >= 0)
            mdatanextp = minValue;
          else
            mdatanextp = data[i + 1][cobj.prevIndex];
        }
      }

      if (data[i][yIndex] == null) { }
      else if (data.length == 1) { }
      else {
        if (i == 0) {
          line = {  x1: _this.scaleX(data[i][xIndex]),
                    x2: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2),
                    y1: cobj.scaleY(mdata),
                    y2: ((cobj.scaleY(mdata)+cobj.scaleY(mdatanext))/2)
                };

          if (cobj.prevLine) {
            linep = { x1: _this.scaleX(data[i][xIndex]),
                      x2: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2),
                      y1: cobj.scaleY(mdatap),
                      y2: ((cobj.scaleY(mdatap)+cobj.scaleY(mdatanextp))/2)
                  };

            pts = pts.concat(path_line_intersections(cobj.line, line));
            pts = pts.concat(path_line_intersections(cobj.prevLine, linep).reverse());
          }
          else {
            pts.push({x: _this.scaleX(data[i][xIndex]), y: cobj.scaleY(lim)});
            pts = pts.concat(path_line_intersections(cobj.line, line));
            pts.push({x: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2), y: cobj.scaleY(lim)});
          }
        }
        else if (i == data.length - 1) {
          line = {  x1: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2),
                    x2: _this.scaleX(data[i][xIndex]),
                    y1: ((cobj.scaleY(mdataprec)+cobj.scaleY(mdata))/2),
                    y2: cobj.scaleY(mdata)
                };

          if (cobj.prevLine) {
            linep = { x1: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2),
                      x2: _this.scaleX(data[i][xIndex]),
                      y1: ((cobj.scaleY(mdataprecp)+cobj.scaleY(mdatap))/2),
                      y2: cobj.scaleY(mdatap)
                  };

            pts = pts.concat(path_line_intersections(cobj.line, line));
            pts = pts.concat(path_line_intersections(cobj.prevLine, linep).reverse());
          }
          else {
            pts.push({x: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2), y: cobj.scaleY(lim)});
            pts = pts.concat(path_line_intersections(cobj.line, line));
            pts.push({x: _this.scaleX(data[i][xIndex]), y: cobj.scaleY(lim)});
          }
        }
        else {
          line = {  x1: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2),
                    x2: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2),
                    y1: ((cobj.scaleY(mdataprec)+cobj.scaleY(mdata))/2),
                    y2: ((cobj.scaleY(mdata)+cobj.scaleY(mdatanext))/2)
                };

          if (cobj.prevLine) {
            linep = { x1: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2),
                      x2: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2),
                      y1: ((cobj.scaleY(mdataprecp)+cobj.scaleY(mdatap))/2),
                      y2: ((cobj.scaleY(mdatap)+cobj.scaleY(mdatanextp))/2)
                  };

            pts = pts.concat(path_line_intersections(cobj.line, line));
            pts = pts.concat(path_line_intersections(cobj.prevLine, linep).reverse());
          }
          else {
            pts.push({x: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2), y: cobj.scaleY(lim)});
            pts = pts.concat(path_line_intersections(cobj.line, line));
            pts.push({x: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2), y: cobj.scaleY(lim)});
          }
        }
      }

      container.append("polygon")
        .attr("class", function () {
          _this.itemsHover.push({
            itm : this,
            series :  cobj.item.series,
            valueField : cobj.item.valueField,
            keyField : !Empty(_this.objConfig.keyField) ? data[i][xIndex] : "",
            category : !Empty(_this.objConfig.keyField) ? _this.categoryList[i] : data[i][xIndex],
            value : odata[i][yIndex],
            progrValue : data[i][yIndex],
            itemType : "area",
            isHover : true,
            itemIndex : ii,
            idx: dSeries.indexOf(lineitem.valueField),
            categoryCode : data[i][_this.categoryCodeIndex]
          });
          return "areahover areahover_" + i + "_" + dSeries.indexOf(lineitem.valueField);
        })
        .attr("points", pts.map(function(d){ return [d.x, d.y].join(","); }))
        .style("opacity", 0)
        .style("fill-opacity", 0.5);
    }

    if (animate) {
      this._AnimateItem(lineitem, lineitem.lastValues, this.defSettings.animation.duration);
      this._AnimateItem(areaitem, areaitem.lastValues, this.defSettings.animation.duration);
    }
  }

  return true;

  function path_line_intersections(pathEl, line) {
    var pts = [],
    pathLength = pathEl.getTotalLength();
      for (var i=0; i<pathLength; i++) {
      var pos1 = pathEl.getPointAtLength(i),
      pos2 = pathEl.getPointAtLength(i + 1),
      line1 = {x1: pos1.x, x2: pos2.x, y1: pos1.y, y2: pos2.y};
      var c1 = btwn(line1.x1, line.x1, line.x2);
      var c2 = btwn(line1.x2, line.x1, line.x2);
      if (c1 && c2) {
        pts.push(pos1)
        pts.push(pos2)
      }
    }
    return pts;
  }
}

ZtStackAreaChart.prototype._EvaluateDatasetAndCalculation = function () {
  ZtStackBarChart.prototype._EvaluateDatasetAndCalculation.call(this);
}

ZtStackAreaChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  return;
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);

  var lastValues,
  yIndex,
  item,
  _this = this,
  prevYIndex,
  dSeries = this._GetDrawingList(),
  sindex;

  for (var i = 0; i < this.items.length; i++) {
    delete this.items[i].lastValues;
    if (this.items[i].itm) {
      item = this.items[i];
      yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);
      var line = d3.line()
              .x(function (d) {
                return _this._GetDomainInScale(d, _this.xIndex);
              })
              .y(function (d) {
                return _this.scaleY[item.valueField](d[yIndex]);
              })
              .defined(function (d) {
                return d[yIndex] != null;
              })
              .curve(d3[this.defSettings.line.type]),
      minScale = d3.min(_this.scaleY[item.valueField].domain()) < 0 ? _this.scaleY[item.valueField](0) : _this.scaleY[item.valueField](d3.min(_this.scaleY[item.valueField].domain())), // eslint-disable-line max-len
      area = d3.area()
              .x(function (d) {
                return _this._GetDomainInScale(d, _this.xIndex);
              })
              .y0(function (/*d*/) {
                return minScale;
              })
              .y1(function (d) {
                return _this.scaleY[item.valueField](d[yIndex]);
              })
              .defined(function (d) {
                return d[yIndex] != null;
              })
              .curve(d3[this.defSettings.line.type]);

      lastValues = { d: d3.select(item.itm).attr("d") };
      if (item.itemType == "area") {
        sindex = dSeries.indexOf(item.valueField);
        if (sindex > 0) {
          prevYIndex = this.propertyName.indexOf(dSeries[sindex - 1]);
          var areast = d3.area()
                        .x(function (d) {
                          return _this._GetDomainInScale(d, _this.xIndex);
                        })
                        .y0(function (d) {
                          return _this.scaleY[item.valueField](d[prevYIndex]);
                        })
                        .y1(function (d) {
                          return _this.scaleY[item.valueField](d[yIndex]);
                        })
                        .defined(function (d) {
                          return d[yIndex] != null;
                        })
                        .curve(d3[this.defSettings.line.type]);
          d3.select(item.itm).datum(this.calcDataset).attr("d", areast);
        }
        else
          d3.select(item.itm).datum(this.dataSet).attr("d", area);
      }
      else
        d3.select(item.itm).datum(this.calcDataset).attr("d", line);
      item.lastValues = lastValues;
    }
  }

  for (i = 0; i < this.shapes.length; i++) {
    if (this.shapes[i].itm) {
      item = this.shapes[i];
      yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);

      lastValues = { x : item.coordinates.x,
                     y : item.coordinates.y,
                     r : item.r
                   };

      item.coordinates.x = this._GetShapeCX(this.dataSet[item.sidx], item.idx, this.xIndex, yIndex, null, {scaleY: this.scaleY[item.valueField], valueField : item.valueField});
      item.coordinates.y = this._GetShapeCY(this.dataSet[item.sidx], item.idx, this.xIndex, yIndex, null, {scaleY: this.scaleY[item.valueField], valueField : item.valueField});
      item.value = this.dataSet[item.sidx][yIndex];
      item.r = item.value == null ? 0 : this.GetShapesRadius();

      d3.select(item.itm)
        .attr("cx", item.coordinates.x)
        .attr("cy", item.coordinates.y)
        .attr("r", item.r);

      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }

  d3.selectAll("polygon.areahover").remove();
  var finished = false,
  interval = setInterval ( function () {
              if (finished) {
                clearInterval(interval);
                _this._ApplyEvents();
                StdChart.prototype.AfterDrawTimeout.call(_this);
                return;
              }

              finished = _this._DrawHoverCount(true);
             }, (this.defSettings.animation.duration / this.items.length));
}

ZtStackAreaChart.prototype._MapCalculation = function () {
  if (this.defSettings.multiDimensional.multiDim && this.multiDimKeepSameScale) {
    if (this.orgCategoryList.length > this.calcDataset.length) {
      var dlist = getList(this.xIndex, this.calcDataset),
      len = this.calcDataset[0].length;
      for (var i = 0; i < this.orgCategoryList.length; i++) {
        if (dlist.indexOf(this.orgCategoryList[i]) < 0) {
          var mrec = [];
          for (var j = 0; j < len - 1; j++)
            mrec.push(null);
          mrec.splice(this.xIndex, 0, this.orgCategoryList[i]);
          this.calcDataset.splice(i, 0, mrec);
          this.dataSet.splice(i, 0, mrec);
        }
      }
    }
  }
}
