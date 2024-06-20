function ZtAreaChart() {
  StdChart.apply(this, ["AREA", "f1fe"]);
  this.itemsHover = [];
  this.holesIndexList = {};
}
ZtAreaChart.prototype = Object.create(ZtLinesChart.prototype);
ZtAreaChart.prototype.constructor = ZtAreaChart;

ZtAreaChart.prototype._SetChartSettingsJSON = function () {
  ZtLinesChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.shape.onlyHover = false;
  this.defSettings.fillTransparency = this.chartConfig.graphSettings.fillTransparency;
  if (this.chartConfig.graphSettings.selectionOptions.opacity == "default")
    this.defSettings.selectionOptions.opacity = 0.25;
}

ZtAreaChart.prototype._SetDomainScaleParameters = function () {
  ZtLinesChart.prototype._SetDomainScaleParameters.call(this);
  if (this.defSettings.line.extArea) {
    if (!this.domainIsTime && !this.domainIsNumber) {
      var dlist = this._GetOppositeAxisDrawingList(true);
      this.scaleX = d3.scalePoint().domain(dlist).range([0, this.chartWidth]);  
    }
  }
}

ZtAreaChart.prototype._SetValueScaleParameters = function (scaleKey, scaleY, min, max) {
  return ZtBarChart.prototype._SetVerticalValueScaleParameters.call(this, scaleKey, scaleY, min, max);
}

ZtAreaChart.prototype._DrawChartElements = function () {
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
  cData;
  for (var i = 0; i < dSeries.length; i++) {
    yIndex = this.propertyName.indexOf(dSeries[i]);
    group.append("clipPath")
      .attr("id", this.chartId + i + "_clip")
        .append("rect")
          .attr("width", 1)
          .attr("height", this.chartHeight);
    cobj = {};
    cobj.scaleY = this.scaleY[dSeries[i]];
    cobj.valueField = dSeries[i];
    if (!this.holesIndexList[dSeries[i]])
      this.holesIndexList[dSeries[i]] = [];
    if (!this.domainIsTime || (this.domainIsTime && this.defSettings.time.dataType == "default"))
      cData = this.dataSet;
    else
      cData = this._EvaluateTimeDataset(this.dataSet, this.xIndex, yIndex, this.holesIndexList[dSeries[i]]);
    this.DrawLine(group, cData, i, this.xIndex, yIndex, cobj);
    this.DrawArea(group, cData, i, this.xIndex, yIndex, cobj);
    this.DrawShapes(sgroup, cData, i, this.xIndex, yIndex, cobj);
    cobj.line = this.items[this.items.length - 2].itm;
    cobj.item = this.items.length - 1;

    hgroup.append("clipPath")
      .attr("id", this.chartId + "clipArea_" + i)
        .append("path")
          .attr("d", d3.select(this.items[this.items.length - 1].itm).attr("d"));

    this._DrawRectHover(hgroup, this.chartId + "clipArea_" + i, cData, i, cobj.item);
  }
}

ZtAreaChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  stroke,
  gradID;
  for (var i = 0; i < this.items.length; i++) {
    idx = this.valueFields.indexOf(this.items[i].valueField);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.orgCategoryList.indexOf(this.items[i].category);
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      if (this.defSettings.shape.draw && this.defSettings.shape.onlyShapes)
        this.items[i].color = { color : "transparent", gradient : "" };
      var styleObj = {};
      styleObj.fill = "transparent";
      stroke = 1;
      if (!Empty(this.defSettings.line.stroke) && !isNaN(this.defSettings.line.stroke) && this.defSettings.line.stroke > 0)
        stroke = this.defSettings.line.stroke;
      styleObj.stroke9width = stroke + "px";
      gradID = this.chartId + this.type + "_" + idx + "Gradient";
      if (!Empty(this.items[i].color.color) && Empty(this.items[i].color.gradient) || this.items[i].color.color.toLowerCase() == this.items[i].color.gradient.toLowerCase())
        stroke = this.items[i].color.color;
      else if (Empty(this.items[i].color.color) && !Empty(this.items[i].color.gradient))
        stroke = this.items[i].color.gradient;
      else {
        this.CreateGradient(this.items[i].color.color, this.items[i].color.gradient, gradID, "element");
        stroke = "url(#" + gradID + ")";
      }
      styleObj.stroke = stroke;
      if (this.items[i].itemType == "area") {
        styleObj.stroke = "none";
        styleObj.fill = stroke;
        styleObj.fill9opacity = this.defSettings.fillTransparency ? 0.25 : 1;
      }
      else {
        if (!Empty(this.defSettings.line.color)) {
          var colors = this.defSettings.line.color.split(";");
          styleObj.stroke = colors[idx] || stroke;
        }
      }
      this.items[i].colorApplied = stroke;
      if (this.items[i].colorApplied.indexOf("Gradient") >= 0)
        this.items[i].colorApplied = this.items[i].color.color;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}
/*
ZtAreaChart.prototype.AfterDraw = function () {
  StdChart.prototype.AfterDraw.call(this); return;
  console.log(this)

  var _this = this,
  finished = false,
  interval = setInterval ( function () {
              if (finished) {
                clearInterval(interval);
                _this._AfterAreaDraw();
                return;
              }

              finished = _this._DrawHoverCount();
             }, (this.defSettings.animation.duration / this.items.length));
}
*/
ZtAreaChart.prototype._AfterAreaDraw = function () {
  StdChart.prototype.AfterDraw.call(this);
  StdChart.prototype.DrawChartMenu.call(this);
}

ZtAreaChart.prototype._AnimateChartElements = function () {
  var clips = [], i;
  for (i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;
    if (this.items[i].itemType == "area") {
      var bbox = elem.getBBox();
      d3.select("#" + this.chartId + this.items[i].idx + "_clip rect")
        .attr("x", bbox.x)
        .attr("y", 0/*bbox.y*/)
      clips.push(bbox.width);
    }
    d3.select(elem).attr("clip-path", "url(#" + this.chartId + this.items[i].idx + "_clip)");
  }

  for (i = 0; i < clips.length; i++) {
    var crect = d3.select("#" + this.chartId + i + "_clip rect");
    crect.transition()
      .delay(i * this.defSettings.animation.duration / this.items.length)
      .duration(this.defSettings.animation.duration / this.items.length)
      .ease(d3.easeLinear)
      .attr("width", clips[i]);
  }
}

ZtAreaChart.prototype._ApplyMouseOver = function (item, itemObj) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  this.RemoveAllHovers();
  if (item) {
    if (item.tagName == "circle") {
      ZtLinesChart.prototype._ApplyMouseOver.call(this, item, itemObj);
      return;
    }

    var hoverItemObject = itemObj || this.itemsHover[d3.select(item).attr("item-index")],
    itemObject = this.items[hoverItemObject.itemIndex],
    tooltipObject = {};
    d3.select(item)
      .style("opacity", 1)
      .style("fill", function () {
        var mcol = "";
        if (!Empty(_this.defSettings.hoverColor))
          mcol = _this.defSettings.hoverColor;
        else {
          mcol = itemObject.colorApplied;
          if (_this.defSettings.range.bands && _this.defSettings.range.applyColor)
            mcol = _this.defSettings.range.bands[hoverItemObject.rangeIdx].color;
          var darkCol = d3.rgb(mcol).darker().toString();
          darkCol = d3.rgb(darkCol).darker().toString();
          mcol = d3.rgb(darkCol).darker().toString();
        }
        hoverItemObject.colorApplied = mcol;
        return mcol;
      })
      .style("cursor", function() {
        if (!_this._ZtChart.enableClick)
          return "default";
        return "pointer";
      })
      .on("mousemove", function() {
        mRefChart.ClearHoverTimeout();
      })
      .on("mouseout", function() {
        var myItemsL = _this.GetSelectedItems().length;
        if (_this.defSettings.range.bands && _this.defSettings.range.applyColor) {
          this.style.fill = _this.defSettings.range.bands[hoverItemObject.rangeIdx].color;
          if (myItemsL == 0 && !_this.defSettings.fillTransparency)
            this.style.fillOpacity = 1;
          else if (!hoverItemObject.isSelected)
            this.style.fillOpacity = 0.25;
        }
        else if (myItemsL == 0 && !_this.defSettings.fillTransparency) {
          this.style.opacity = 0;
          _this.items[_this.itemsHover[d3.select(this).attr("item-index")].itemIndex].itm.style.opacity = 1;
          this.style.fill = 'transparent';
        }
        else {
          if (!hoverItemObject.isSelected)
            this.style.opacity = 0;
          else
            this.style.fill = _this.items[_this.itemsHover[d3.select(this).attr("item-index")].itemIndex].colorApplied;
        }

        mRefChart.RemoveHoverTimeout();
        delete mRefChart._hoverItem;
      })
      .on("click", function () {
        _this._ApplyClick(hoverItemObject, d3.mouse(this));
      });

    tooltipObject = this._GetItemObj(hoverItemObject);
    tooltipObject.color = { color : (itemObject.colorApplied || itemObject.color.color) };
    /*if (this.defSettings.range.bands && this.defSettings.range.applyColor)
      tooltipObject.color.color = this.defSettings.range.bands[hoverItemObject.rangeIdx].color;*/
    tooltipObject.rangeIdx = hoverItemObject.rangeIdx;

    mRefChart._hoverItem = tooltipObject;
    mRefChart._d3mouse = d3.mouse(item);
    mRefChart._d3event = d3.event;
    setTimeout(function(mRefChart, item, tooltipObject){
      if (mRefChart._hoverItem) {
        if (mRefChart._CheckIdentityItem(mRefChart._hoverItem, tooltipObject)) {
          _this.ShowTooltip(mRefChart, item, tooltipObject);
        }
      }
    }, 50, mRefChart, item, tooltipObject);
  }
}

ZtAreaChart.prototype._GetItems = function() {
  return this.itemsHover.concat(this.shapes);
}

ZtAreaChart.prototype._DrawHoverCount = function (animate) {
  var container = d3.select("#" + this.chartId + this.type + "_elementGroupH"),
  _this = this,
  xIndex = this.xIndex,
  data = this.dataSet.filter( function (record) {
                          return _this._IsNotExcludedDomain(record[xIndex]);
                       }
                     ),
  yIndex,
  cobj,
  dSeries = this._GetDrawingList(),
  items = this.items;

  for (var ii = 0; ii <= items.length - 2; ii = ii + 2) {
    cobj = {};
    cobj.scaleY = this.scaleY[items[ii].valueField];
    cobj.line = items[ii].itm;
    cobj.item = items[ii + 1];
    yIndex = this.propertyName.indexOf(items[ii].valueField);

    //----- DISEGNO -----//
    var minValue = cobj.scaleY.domain()[1],
    maxValue = cobj.scaleY.domain()[0],
    minSer = d3.min(data.map(function(record){ return record[yIndex]}));

    // line è la linea che delimita gli estremi dell'intervallo tra i due valori di coords
    // pts[0] e pts[last] sono i punti di apertura e chiusura
    for (var i = 0; i < data.length; i++) {
      var line = {},
      pts = [],
      mdata,
      mdatanext,
      mdataprec;
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

      if (data[i][yIndex] == null) { }
      else if (data.length == 1) { }
      else {
        if (i == 0) {
          line = {  x1: _this.scaleX(data[i][xIndex]),
                    x2: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2),
                    y1: cobj.scaleY(mdata),
                    y2: ((cobj.scaleY(mdata)+cobj.scaleY(mdatanext))/2)
                };

          pts.push({x: _this.scaleX(data[i][xIndex]), y: cobj.scaleY(lim)});
          pts = pts.concat(path_line_intersections(cobj.line, line));
          pts.push({x: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2), y: cobj.scaleY(lim)});
        }
        else if (i == data.length - 1) {
          line = {  x1: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2),
                    x2: _this.scaleX(data[i][xIndex]),
                    y1: ((cobj.scaleY(mdataprec)+cobj.scaleY(mdata))/2),
                    y2: cobj.scaleY(data[i][yIndex])
                };

          pts.push({x: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2), y: cobj.scaleY(lim)});
          pts = pts.concat(path_line_intersections(cobj.line, line));
          pts.push({x: _this.scaleX(data[i][xIndex]), y: cobj.scaleY(lim)});
        }
        else {
          line = {  x1: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2),
                    x2: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2),
                    y1: ((cobj.scaleY(mdataprec)+cobj.scaleY(mdata))/2),
                    y2: ((cobj.scaleY(mdata)+cobj.scaleY(mdatanext))/2)
                };
          pts.push({x: ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2), y: cobj.scaleY(lim)});
          pts = pts.concat(path_line_intersections(cobj.line, line));
          pts.push({x: ((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2), y: cobj.scaleY(lim)});
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
            value : data[i][yIndex],
            itemType : "area",
            isHover : true,
            itemIndex : ii + 1,
            idx: dSeries.indexOf(items[ii].valueField),
            sidx: _this.categoryList.indexOf(data[i][xIndex]),
            categoryCode : data[i][_this.categoryCodeIndex]
          });
          return "areahover areahover_" + i + "_" + dSeries.indexOf(items[ii].valueField);
        })
        .attr("points", pts.map(function(d){ return [d.x, d.y].join(","); }))
        .style("opacity", 0)
        .style("fill-opacity", 0.5);
    }

    if (animate) {
      this._AnimateItem(items[ii], items[ii].lastValues, this.defSettings.animation.duration);
      this._AnimateItem(items[ii + 1], items[ii + 1].lastValues, this.defSettings.animation.duration);
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

ZtAreaChart.prototype._DrawRectHover = function (container, clip, data, dataIndex, itemIndex, odata) {
  var _this = this,
  xIndex = this.xIndex,
  dSeries = this._GetDrawingList(),
  vfield = dSeries[dataIndex],
  scaleY = this.scaleY[vfield],
  yIndex = this.propertyName.indexOf(vfield),
  minValue = scaleY.domain()[1],
  //maxValue = scaleY.domain()[0],
  minSer = d3.min(data.map(function(record){ return record[yIndex]})),
  sizes = {x: 0, y: 0, w: 0, h: 0},
  record,
  lim;

  for (var i = 0; i < data.length; i++) {
    record = data[i];
    //----- DISEGNO -----//
    if (minSer < 0 && record[yIndex] >= 0)
      minValue = 0;
    if (minSer >= 0 && minValue < 0)
      minValue = 0;
    
    lim = (record[yIndex] >= 0) ? minValue : 0;

    if (data[i][yIndex] == null) { }
    else if (data.length == 1) { }
    else {
      // PRIMO VALORE
      if (i == 0) {
        sizes.w = Math.abs(((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2) - sizes.x);
      }
      else if (i == data.length - 1) {
        // ULTIMO VALORE
        sizes.x = ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2)
        sizes.w = _this.chartWidth;
      }
      else {
        sizes.x = ((_this.scaleX(data[i-1][xIndex])+_this.scaleX(data[i][xIndex]))/2)
        sizes.w = Math.abs(((_this.scaleX(data[i][xIndex])+_this.scaleX(data[i+1][xIndex]))/2) - sizes.x);
      }
    }
    sizes.h = scaleY(lim);

    container.append("rect")
      .attr("class", function () {
        _this.itemsHover.push({
          itm : this,
          series :  _this._GetLegendList()[dataIndex],
          valueField : vfield,
          keyField : !Empty(_this.objConfig.keyField) ? record[xIndex] : "",
          category : !Empty(_this.objConfig.keyField) ? _this.categoryList[i] : record[xIndex],
          value : record[yIndex],
          progrValue : (odata && odata.length > 0) ? odata[i][yIndex] : "",
          itemType : "area",
          isHover : true,
          itemIndex : itemIndex,
          idx: dataIndex,
          sidx: _this.categoryList.indexOf(record[xIndex]),
          categoryCode : record[_this.categoryCodeIndex]
        });
        return "areahover areahover_" + i + "_" + dataIndex;
      })
      .style("opacity", 0)
      .style("fill-opacity", 0.5)
      .attr("x", sizes.x)
      .attr("y", sizes.y)
      .attr("width", sizes.w)
      .attr("height", sizes.h)
      .attr("clip-path", "url(#" + clip + ")")
  }

  return true;
}

ZtAreaChart.prototype._GetRelatedItm = function (itemObject) {
  var ret = [],
  mitems = (itemObject.itemType == "area") ? this.shapes : this.itemsHover,
  f = false;
  ret.push(itemObject);
  for (var i = 0; !f && i < mitems.length; i++) {
    if (this._CheckIdentityItem(itemObject, mitems[i])) {
      ret.push(mitems[i]);
      f = true;
    }
  }
  return ret;
}

ZtAreaChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  var halfOpacity = this.defSettings.selectionOptions.opacity,
  fullOpacity = 1,
  fillColor = this.defSettings.selectionOptions.color,
  stobj;
  for (var i = 0; i < items.length; i++) {
    if (!items[i].itm)
      continue;
    if (items[i].itemType == "shape") {
      ZtLinesChart.prototype._ApplySelectEffectShape.call(this, items[i], selected);
      continue;
    }
    if (items[i].type == "legend") {
      this._ApplyLegendSelectEffect(items[i], selected);
      continue;
    }
    stobj = {};
    if (this.defSettings.range.bands && this.defSettings.range.applyColor) {
      if (selected) {
        stobj.fill9opacity = fullOpacity;
        stobj.stroke9opacity = fullOpacity;
      }
      else {
        stobj.fill9opacity = halfOpacity;
        stobj.stroke9opacity = halfOpacity;
        if (!Empty(fillColor))
          stobj.fill = fillColor;
      }
    }
    else {
      if (this.defSettings.fillTransparency) {
        if (selected) {
          if (items[i].itemType == "area" && !Empty(this.items[items[i].itemIndex].colorApplied))
            stobj.fill = this.items[items[i].itemIndex].colorApplied;
          stobj.fill9opacity = fullOpacity;
          stobj.stroke9opacity = fullOpacity;
          stobj.opacity = 1;
        }
        else {
          if (items[i].itemType == "area" && !Empty(this.items[items[i].itemIndex].colorApplied))
            stobj.fill = this.items[items[i].itemIndex].colorApplied;
          stobj.fill9opacity = halfOpacity;
          stobj.stroke9opacity = halfOpacity;
          if (!Empty(fillColor)) {
            stobj.fill = fillColor;
            stobj.opacity = 1;
          }
          else
            stobj.opacity = 0;
          if (halfOpacity == 0.1) {
            if (this.GetSelectedItems().length > 0)
              d3.select(this.items[items[i].itemIndex].itm).attr("style", 
                makeStyleHTMLString({ fill9opacity: halfOpacity }, d3.select(this.items[items[i].itemIndex].itm).attr("style"))
              );
            else
            d3.select(this.items[items[i].itemIndex].itm).attr("style", 
              makeStyleHTMLString({ fill9opacity: 0.25 }, d3.select(this.items[items[i].itemIndex].itm).attr("style"))
            );
          }
        }
      }
      else {
        if (selected) {
          if (items[i].itemType == "area" && items[i].itemIndex >= 0 && !Empty(this.items[items[i].itemIndex].colorApplied))
            stobj.fill = this.items[items[i].itemIndex].colorApplied;
          stobj.fill9opacity = fullOpacity;
          stobj.stroke9opacity = fullOpacity;
          stobj.opacity = 1;
        }
        else {
          if (items[i].itemType == "area" && items[i].itemIndex >= 0 && !Empty(this.items[items[i].itemIndex].colorApplied))
            stobj.fill = this.items[items[i].itemIndex].colorApplied;
          stobj.fill9opacity = halfOpacity;
          stobj.stroke9opacity = halfOpacity;
          if (items[i].itemIndex >= 0)
            d3.select(this.items[items[i].itemIndex].itm).attr("style", 
              makeStyleHTMLString({ fill9opacity: halfOpacity }, d3.select(this.items[items[i].itemIndex].itm).attr("style"))
            );
          if (!Empty(fillColor)) {
            stobj.fill = fillColor;
            d3.select(this.items[items[i].itemIndex].itm).attr("style", 
              makeStyleHTMLString({ fill: fillColor }, d3.select(this.items[items[i].itemIndex].itm).attr("style"))
            );
          }
          else
            stobj.opacity = 0;
        }
      }
    }
    d3.select(items[i].itm).attr("style", makeStyleHTMLString(stobj, d3.select(items[i].itm).attr("style")));
  }
}

ZtAreaChart.prototype._ApplyNoSelections = function() {
  var myItems = this.GetSelectedItems();
  if (myItems.length == 0) {
    myItems = this._GetItems();
    var myShapes = myItems.filter(function(item){ return item.itemType == "shape"; });
    this._ApplyItemSVGSelectEffect(myShapes, true);
    var myPoly = myItems.filter(function(item){ return item.itemType != "shape"; });
    this._ApplyItemSVGSelectEffect(myPoly, false);
    if ((!this.defSettings.range.bands || !this.defSettings.range.applyColor) && !this.defSettings.fillTransparency) {
      myPoly = this.items.filter(function(item){ return item.itemType == "area"; })
      this._ApplyItemSVGSelectEffect(myPoly, true);
    }
  }
  else {
    this._ApplyItemSVGSelectEffect(myItems, true);
    myItems = this.GetNotSelectedItems();
    this._ApplyItemSVGSelectEffect(myItems, false);
  }
}

ZtAreaChart.prototype._ApplyMouseOut = function (item) {
  this.RemoveAllHovers();
  var itm = d3.select(".areahover_" + item.sidx + "_" + item.idx),
  hoverItemObject = this.itemsHover[itm.attr("item-index")];
  if (!hoverItemObject.isSelected)
    hoverItemObject.itm.style.opacity = 0;
}

ZtAreaChart.prototype._OverwriteDefProperties = function () {
  this.defSettings.line.extArea = false;
}

ZtAreaChart.prototype._GetDomainInScale = function (record, index) {
  if (!this.defSettings.line.extArea)
    return StdChart.prototype._GetDomainInScale.call(this, record, index);
  return this.scaleX(record[index]);
}

ZtAreaChart.prototype._SetElementsRangeColor = function (isFnc) {
  var styleObj,
  fill, i,
  halfOpacity = 0.25,
  fullOpacity = 1;
  for (i = 0; i < this.items.length; i++) {
    if (this.items[i].itemType != "line") {
      styleObj = { fill: "transparent" };
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }

  for (i = 0; i < this.itemsHover.length; i++) {
    if (this.itemsHover[i].idx >= 0) {
      if (isFnc) {
        if (this.functionObj && ("GetConditionalFormatting" in this.functionObj)) {
          var fncRet = this.functionObj.GetConditionalFormatting(this._GetItemObj(this.items[i]));
          fill = decodeConditionalFormatting(fncRet).fill;
        }
      }
      else {
        var band = this.GetObjectFromRange(this.itemsHover[i].value, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.itemsHover[i], band);
      }
      styleObj = { fill: fill, opacity: 1, fill9opacity: this.defSettings.fillTransparency ? halfOpacity : fullOpacity };
      this.items[this.itemsHover[i].itemIndex].colorApplied = fill;
      d3.select(this.itemsHover[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.itemsHover[i].itm).attr("style")));
    }
  }
}

ZtAreaChart.prototype._DrawValueLabels = function () {
  if (this.defSettings.shape.draw)
    ZtLinesChart.prototype._DrawValueLabels.call(this);
  else
    StdChart.prototype._DrawValueLabels.call(this);
}

ZtAreaChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  return
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);

  var lastValues,
  yIndex,
  item,
  _this = this;

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
        .y0(function () {
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
      if (item.itemType == "area")
        d3.select(item.itm).datum(this.dataSet).attr("d", area);
      else
        d3.select(item.itm).datum(this.dataSet).attr("d", line);
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

  d3.selectAll("rect.areahover").remove();
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

ZtAreaChart.prototype._CreateElementGradient = function (color, gradient, gDef) {
  gDef.attr("x1", "0%")
    .attr("y1", "0%")
    .attr("x2", "0%")
    .attr("y2", "100%");
  gDef.append("stop")
      .attr("offset", "0%")
      .attr("stop-color", color)
      .attr("stop-opacity", "1");
  gDef.append("stop")
      .attr("offset","100%")
      .attr("stop-color", gradient)
      .attr("stop-opacity", "1");
}
