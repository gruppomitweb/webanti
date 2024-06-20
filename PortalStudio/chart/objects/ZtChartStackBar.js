function ZtStackBarChart(type, isH, is3D) {
  ZtBarChart.apply(this, [type, isH, is3D]);
  this.legendHexCode = this.isH ? "e90f" : "e912";
  this.applyCalculationAfter = true;
}
ZtStackBarChart.prototype = Object.create(ZtBarChart.prototype);
ZtStackBarChart.prototype.constructor = ZtStackBarChart;

ZtStackBarChart.prototype._SetChartSettingsJSON = function () {
  ZtBarChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.normalizeValues = this.chartConfig.graphSettings.normalized;
  this.multipleScales = false;
}

ZtStackBarChart.prototype._SetCalculationDataset = function () {
  var vf = this._GetDrawingList();
  if (!this.defSettings.normalizeValues)
    this.calcDataset = getStackDataset(vf, this.propertyName, this.dataSet);
  else {
    this.dataSet = getPercentDataset(vf, this.propertyName, this.dataSet, this.totalsSeries, false);
    this.calcDataset = getStackDataset(vf, this.propertyName, this.dataSet);
  }

  this.allValues = getValues(vf, this.propertyName, this.calcDataset);
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);
  this._EvaluateAllValuesCalc();
}

ZtStackBarChart.prototype._DrawChartElements = function () {
  delete this.bandWidth;
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  bandWidth = this._GetBarWidthFromDomainEvaluation();

  var yIndex = -1,
  dSeries = this._GetDrawingList(),
  scaleS = d3.scaleBand()
    .domain(dSeries)
    .range([0, bandWidth]),
  cobj,
  index,
  _this = this,
  fdata = this.dataSet.filter( function (record) {
                          return _this._IsNotExcludedDomain(record[_this.xIndex]);
                       }
                     );

  if (this.is3D) {
    if (this.isH) {
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath2");
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath1");
    }
    else {
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath1");
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath2");
    }
  }

  for (var i = 0; i < dSeries.length; i++) {
    yIndex = this.propertyName.indexOf(dSeries[i]);
    cobj = this._GetDrawParamObject(scaleS.bandwidth(), this.calcDataset);
    cobj.scaleY = this.scaleY[dSeries[i]];
    if (this.is3D) {
      index = this.valueFields.indexOf(dSeries[i]);
      this._Draw3DElementPath1(this.svg.select("#" + this.chartId + this.type + "_3Dpath1"), fdata, index, this.xIndex, yIndex, cobj);
      this._Draw3DElementPath2(this.svg.select("#" + this.chartId + this.type + "_3Dpath2"), fdata, index, this.xIndex, yIndex, cobj);
    }
    this.DrawStackBar(group, this.dataSet, this.calcDataset, i, this.xIndex, yIndex, cobj);
  }

  this._DrawShadows();
}

ZtStackBarChart.prototype._GetVBarX = function (data, cdata, xIndex, yIndex, cobj) {
  var th_x = this.scaleX(data[xIndex]),
  th_w = cobj.th_barWidth * this._GetDrawingList().length,
  r_w = this._GetBarWidth(data, yIndex, cobj),
  x;
  if (th_w == r_w)
    x = th_x;
  else {
    x = th_x + (th_w / 2) - (r_w / 2);
  }
  return x;
}

ZtStackBarChart.prototype._GetHBarY = function (data, cdata, xIndex, yIndex, cobj) {
  var th_y = this.scaleX(data[xIndex]),
  th_h = cobj.th_barWidth * this._GetDrawingList().length,
  r_h = this._GetBarHeight(data, yIndex, cobj),
  y;
  if (th_y == r_h)
    y = th_y;
  else {
    y = th_y + (th_h / 2) - (r_h / 2);
  }
  return y;
}

ZtStackBarChart.prototype._GetVBarY = function (data, cdata, xIndex, yIndex, cobj) {
  var y = 0,
  max = this.defSettings.valueAxis.maxValue,
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  if (cdata[yIndex] < 0) {
    if (!Empty(max) && max < 0)
      y = cobj.scaleY(max);
    else if (cdata[yIndex] == data[yIndex])
      y = cobj.scaleY(sMax);
    else
      y = cobj.scaleY(cdata[yIndex] - data[yIndex]);
  }
  else {
    if (!Empty(max) && data[yIndex] > max)
      y = cobj.scaleY(max);
    else
      y = cobj.scaleY(cdata[yIndex]);
  }
  return y;
}

ZtStackBarChart.prototype._GetVBarWidth = function (data, yIndex, cobj) {
  var factor = this._GetDrawingList().length;
  if (this.defSettings.bars.maxWidth > 0)
    factor = 1;
  var w = cobj.barWidth * factor;
  return w;
}

ZtStackBarChart.prototype._GetHBarX = function (data, cdata, xIndex, yIndex, cobj) {
  var x = 0,
  prof = this.is3D ? 10 : 0,
  max = this.defSettings.valueAxis.maxValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain());
  if (cdata[yIndex] < 0) {
    if (!Empty(max) && max < 0)
      x = cobj.scaleY(max);
    else if (cdata[yIndex] == data[yIndex])
      x = cobj.scaleY(cdata[yIndex]);
    else
      x = cobj.scaleY(cdata[yIndex]);
  }
  else {
    if (!Empty(max) && data[yIndex] > max)
      x = cobj.scaleY(max);
    else if (cdata[yIndex] == data[yIndex])
      x = cobj.scaleY(sMin);
    else
      x = cobj.scaleY(cdata[yIndex] - data[yIndex]);
  }
  return x - prof;
}

ZtStackBarChart.prototype._GetHBarWidth = function (data, yIndex, cobj) {
  var w = 0,
  min = this.defSettings.valueAxis.minValue,
  max = this.defSettings.valueAxis.maxValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain()),
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  
  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;
  if ((isNaN(max) || max === undefined || Empty(max)) && max !== 0)
    max = null;

  if (data[yIndex] < 0) {
    if (Empty(max) || max >= 0) {
      if (!Empty(min) && min <= 0 && data[yIndex] < min)
        w = Math.abs(cobj.scaleY(min) - cobj.scaleY(sMax));
      else if (!Empty(min) && min >= 0)
        w = 0;
      else
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMax));
    }
    else {
      if (max <= data[yIndex])
        w = 0;
      if (!Empty(min) && min <= 0 && data[yIndex] < min)
        w = Math.abs(cobj.scaleY(min) - cobj.scaleY(max));
      else if (!Empty(min) && min >= 0)
        w = 0;
      else
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(max));
    }
  }
  else {
    if (!Empty(min) && min > 0) {
      if (min > data[yIndex])
        w = 0;
      if (!Empty(max) && data[yIndex] > max && max >= 0)
        w = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
      else if (max < 0)
        w = 0;
      else
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(min));
    }
    else {
      if (!Empty(max) && data[yIndex] > max && max >= 0)
        w = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
      else if (max < 0)
        w = 0;
      else
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
    }
  }
  return w;
}

ZtStackBarChart.prototype._Draw3DVerticalElementPath1 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this,
  cdata = cobj.cdata.filter( function (record) {
                          return _this._IsNotExcludedDomain(record[xIndex]);
                       }
                     );

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d/*, idx*/) {
        var index = _this.orgCategoryList.indexOf(d[xIndex]);
        return "barPath1 bar3D_" + dataIndex + "_" + index + " TRANSP";
      })
      .attr("d",function(d, index) {
        var xB = _this._GetBarX(d, cdata[index], xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, cdata[index], xIndex, yIndex, cobj),
        w = _this._GetBarWidth(d, yIndex, cobj),
        path = "M" + xB + "," + yB;
        path = path + "L" + (xB + prof) + "," + (yB - prof);
        path = path + "L" + (xB + w + prof) + "," + (yB - prof);
        path = path + "L" + (xB + w) + "," + yB;
        path = path + "Z";
        return path;
      });
}

ZtStackBarChart.prototype._Draw3DVerticalElementPath2 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this,
  cdata = cobj.cdata.filter( function (record) {
                          return _this._IsNotExcludedDomain(record[xIndex]);
                       }
                     );

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d/*, idx*/) {
        var index = _this.orgCategoryList.indexOf(d[xIndex]);
        return "barPath2 bar3D_" + dataIndex + "_" + index + " TRANSP";
      })
      .attr("d", function(d, index) {
        var xB = _this._GetBarX(d, cdata[index], xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, cdata[index], xIndex, yIndex, cobj),
        w = _this._GetBarWidth(d, yIndex, cobj),
        h = _this._GetBarHeight(d, yIndex, cobj),
        path = "M" + (xB + w) + "," + yB;
        path = path + "L" + (xB + w + prof) + "," + (yB - prof);
        path = path + "L" + (xB + w + prof) + "," + (yB + h - prof);
        path = path + "L" + (xB + w) + "," + (yB + h);
        path = path + "Z";
        return path;
      });
}

ZtStackBarChart.prototype._Draw3DHorizontalElementPath1 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this,
  cdata = cobj.cdata.filter( function (record) {
                          return _this._IsNotExcludedDomain(record[xIndex]);
                       }
                     );

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d/*, idx*/) {
        var index = _this.orgCategoryList.indexOf(d[xIndex]);
        return "barPath1 bar3D_" + dataIndex + "_" + index + " TRANSP";
      })
      .attr("d",function(d, index) {
        var xB = _this._GetBarX(d, cdata[index], xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, cdata[index], xIndex, yIndex, cobj),
        path = "";
        if (d[yIndex] == 0)
          path = "M" + xB + "," + yB;
        else {
          var w = _this._GetBarWidth(d, yIndex, cobj);
          path = "M" + xB + "," + yB;
          path = path + "L" + (xB + prof) + "," + (yB - prof);
          path = path + "L" + (xB + w + prof) + "," + (yB - prof);
          path = path + "L" + (xB + w) + "," + yB;
          path = path + "Z";
        }
        return path;
      });
}

ZtStackBarChart.prototype._Draw3DHorizontalElementPath2 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this,
  cdata = cobj.cdata.filter( function (record) {
                          return _this._IsNotExcludedDomain(record[xIndex]);
                       }
                     );

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d/*, idx*/) {
        var index = _this.orgCategoryList.indexOf(d[xIndex]);
        return "barPath2 bar3D_" + dataIndex + "_" + index + " TRANSP";
      })
      .attr("d", function(d, index) {
        var xB = _this._GetBarX(d, cdata[index], xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, cdata[index], xIndex, yIndex, cobj),
        w = _this._GetBarWidth(d, yIndex, cobj),
        h = _this._GetBarHeight(d, yIndex, cobj),
        path = "M" + (xB + w) + "," + yB;
        path = path + "L" + (xB + w + prof) + "," + (yB - prof);
        path = path + "L" + (xB + w + prof) + "," + (yB + h - prof);
        path = path + "L" + (xB + w) + "," + (yB + h);
        path = path + "Z";
        return path;
      });
}

ZtStackBarChart.prototype._SetElementsRangeColor = function (isFnc) {
  var styleObj,
  fill;
  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].idx >= 0) {
      if (isFnc) {
        if (this.functionObj && ("GetConditionalFormatting" in this.functionObj)) {
          var fncRet = this.functionObj.GetConditionalFormatting(this._GetItemObj(this.items[i]));
          styleObj = decodeConditionalFormatting(fncRet);
          fill = styleObj.fill;
        }
      }
      else {
        var band = this.GetObjectFromRange(this.items[i].progrValue, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.items[i], band);
        styleObj = { fill: fill };
      }
      this.items[i].colorApplied = fill;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      if (this.is3D) {
        fill = get3DColor({ color: this.items[i].colorApplied, gradient: "" });
        styleObj.fill = fill.color;
        var path3D = this.svg.selectAll(".bar3D_" + this.items[i].idx + '_' + this.items[i].sidx)._groups;
        for (var j = 0; j < path3D[0].length; j++)
          d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
      }
      this._DrawMarkerIconOnItem(this.items[i]);
    }
  }
}

ZtStackBarChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");
  for (var i = 0; i < this.items.length; i++) {
    var enableZero = this.defSettings.valueLabel.type != "value" || (this.defSettings.valueLabel.type == "value" && this.defSettings.valueLabel.showZero),
    item = this.items[i],
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, "realValue"),
    vText = (!enableZero && text == 0) ? "" : text,
    pos = this.defSettings.valueLabel.position,
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    label = group.append("text")
              .attr("x", this._GetValueLabelX(pos, item, text, font))
              .attr("y", this._GetValueLabelY(pos, item, text, font))
              .style("text-anchor", function () {
                switch (pos) {
                  case "oleft":
                  case "iright":
                    return "end";
                    break;
                  case "ileft":
                  case "oright":
                    return "start";
                    break;
                  default:
                    return "middle";
                    break;
                }
              })
              .text(vText);
    setFont(label, font, this);
  }
}

ZtStackBarChart.prototype._GetDrawParamObject = function (barWidth, cdata) {
  var barW = barWidth;
  if (this.defSettings.bars.maxWidth > 0)
    barW = Math.min(this.defSettings.bars.maxWidth, barWidth);
  return  { barWidth : barW,
            cdata : cdata,
            th_barWidth : barWidth
          }
}

ZtStackBarChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  margins = this.defSettings.bars.margins,
  cobj,
  scaleS = d3.scaleBand()
    .domain(this.valueFields)
    .range([0, this.scaleX.bandwidth()]),
  dataIndex,
  yIndex,
  cList = getList(this.xIndex, this.dataSet),
  item,
  drawPath = {};

  if (isNaN(margins) || Empty(margins))
    margins = 0;

  d3.select("#" + this.chartId + "shadows").selectAll("*").remove();
  d3.select("#" + this.chartId + "valueLabels").remove();
  if (this.is3D) {
    d3.select("#" + this.chartId + this.type + "_3Dpath1").selectAll("*").remove();
    d3.select("#" + this.chartId + this.type + "_3Dpath2").selectAll("*").remove();
  }

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm) {
      item = this.items[i];
      if (!(item.valueField in drawPath))
        drawPath[item.valueField] = false;

      dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);
      lastValues = {};
      lastValues.width = parseFloat(d3.select(item.itm).attr("width"));
      lastValues.height = parseFloat(d3.select(item.itm).attr("height"));
      lastValues.x = parseFloat(d3.select(item.itm).attr("x"));
      lastValues.y = parseFloat(d3.select(item.itm).attr("y"));

      if (dataIndex < 0) {
        item.value = null;
        item.realValue = null;
        item.progrValue = null;
        if (this.isH)
          d3.select(item.itm).attr("width", 0);
        else {
          d3.select(item.itm).attr("y", parseFloat(d3.select(item.itm).attr("y")) + parseFloat(d3.select(item.itm).attr("height")));
          d3.select(item.itm).attr("height", 0);
        }
      }
      else {
        record = this.dataSet[dataIndex];
        cobj = this._GetDrawParamObject(scaleS.bandwidth(), this.calcDataset);
        cobj.dbarIndex = item.sidx;
        cobj.scaleY = this.scaleY[item.valueField];
        yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);
        if (item.progrValue != this.calcDataset[dataIndex][yIndex]) {
          item.value = record[yIndex];
          item.realValue = record[yIndex];
          item.progrValue = this.calcDataset[dataIndex][yIndex];
          if (this.isH) {
            d3.select(item.itm).attr("x", this._GetBarX(record, this.calcDataset[dataIndex], this.xIndex, yIndex, cobj));
            d3.select(item.itm).attr("width", this._GetBarWidth(record, yIndex, cobj));
          }
          else {
            d3.select(item.itm).attr("y", this._GetBarY(record, this.calcDataset[dataIndex], this.xIndex, yIndex, cobj));
            d3.select(item.itm).attr("height", this._GetBarHeight(record, yIndex, cobj));
          }
        }

        if (this.is3D && !drawPath[item.valueField]) {
          this._Draw3DElementPath1(this.svg.select("#" + this.chartId + this.type + "_3Dpath1"), this.dataSet, item.idx, this.xIndex, yIndex, cobj);
          this._Draw3DElementPath2(this.svg.select("#" + this.chartId + this.type + "_3Dpath2"), this.dataSet, item.idx, this.xIndex, yIndex, cobj);
          drawPath[item.valueField] = true;
        }
      }

      if (!this.is3D) {
        var sX = parseFloat(this.defSettings.bars.shadow.x),
        sY = parseFloat(this.defSettings.bars.shadow.y);
        if ((!Empty(sX) && !isNaN(sX)) || (!Empty(sY) && !isNaN(sY))) {
          var color = Empty(this.defSettings.bars.shadow.color) ? "#A3A3A3" : this.defSettings.bars.shadow.color,
          group = this.svg.select("#" + this.chartId + "shadows");
          this._DrawItemShadow(group, item, sX, sY, color);
        }
      }

      this._SetItemColors(item);
      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }

  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtStackBarChart.prototype._CheckEmptyValues = function () {
  if (this.categoryList.length > this.calcDataset.length) {
    var _this = this,
    dMap = this.calcDataset.map(function (rec) { return rec[_this.xIndex]; }),
    dCat = this.orgCategoryList.filter(function (cat) { return dMap.indexOf(cat) < 0; }),
    record,
    cIdx;
    for (var i = 0; i < dCat.length; i++) {
      cIdx = this.orgCategoryList.indexOf(dCat[i]);
      record = [];
      for (var j = 0; j < this.calcDataset[0].length; j++)
        record.push(0);
      if (this.xLabelIndex)
        record[this.xLabelIndex] = this.categoryList[cIdx];
      record[this.xIndex] = dCat[i];
      this.calcDataset.push(record);
      this.dataSet.push(record);
    }
  }
}

ZtStackBarChart.prototype._EvaluateDatasetAndCalculation = function () {
  // inutile girare sulle serie se sono le stesse
  /*if (this.valueFields.length == this._GetDrawingList().length)
    return;*/
  this._SetCalculationDataset();
}

ZtStackBarChart.prototype._MapCalculation = function () {
  if (this.defSettings.multiDimensional.cursorType == "none" && this.multiDimKeepSameScale) {
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