function ZtBarChart(type, isH, is3D) {
  StdChart.apply(this, [type, (isH >= 0 ? "e90e" : "e900")]);
  this.isH = isH < 0 ? false : true;
  this.is3D = is3D < 0 ? false : true;
};
ZtBarChart.prototype = Object.create(StdChart.prototype);
ZtBarChart.prototype.constructor = ZtBarChart;

ZtBarChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.axisLabel = this.chartConfig.graphSettings.axisLabel;
  this.defSettings.bars = this.chartConfig.graphSettings.bars;
  this.defSettings.domainAxis = this.chartConfig.graphSettings.domainAxis;
  this.defSettings.valueAxis = this.chartConfig.graphSettings.valueAxis;
  this.defSettings.domainAxis.precision = parseFloat(this.defSettings.domainAxis.precision);
  this.defSettings.valueAxis.precision = parseFloat(this.defSettings.valueAxis.precision);
}

ZtBarChart.prototype._DrawChartPlot = function () {
  this.CreateSVG(this.chartId, this.parent, true, 0, 0, this.defSettings.globals.width, this.defSettings.globals.height, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top); // eslint-disable-line max-len
  this.CreateRenderer(this.svg, this.chartId, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  if (this.is3D)
    this.DrawRenderer3D(this.renderer);
  this._DrawChartPlotTitles(this.svg);
  this._DrawChartPlotElements();
}

ZtBarChart.prototype._DrawChartPlotElements = function () {
  this._DrawAxis();
  this._DrawAxisLabel();
  this._DrawRangeBands();
  this._DrawShadowsGroup();
  this._DrawGridLines();
}

ZtBarChart.prototype._DrawValueAxisGrid = function () {
  if (this.isH)
    this._DrawHorizontalValueAxisGrid();
  else
    this._DrawVerticalValueAxisGrid();
}

ZtBarChart.prototype._DrawVerticalValueAxisGrid = function () {
  var ticksArray = d3.select(this.svg.select("#" + this.chartId + "valueAxisGroup").node().firstChild).selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;
  var pos = [],
  xR = this.margin.left,
  yR = this.margin.top,
  w = this.chartWidth,
  grid,
  prof,
  elemType = "line",
  gelem,
  _this = this;

  if (Empty(this.svg.select("#" + this.chartId + "valueAxisGridline").node()))
    grid = this.renderer.append("g").attr("id", this.chartId + "valueAxisGridline");

  if (this.defSettings.valueAxis.valueGrid.line) {
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      if (tick.transform.baseVal.length > 0 || tick.transform.baseVal.numberOfItems > 0)
        pos.push(tick.transform.baseVal.getItem(0).matrix.f);
    }
    
    if (this.is3D) {
      prof = 10;
      elemType = "path";
    }

    gelem = grid.selectAll(".valueGridline")
      .data(pos)
      .enter()
      .append(elemType)
        .attr("class", "valueGridline TRANSP")
        .attr("id", function (d, i) {
          return _this.chartId + "valueGLine_" + i;
        });

    if (this.is3D) {
      gelem .attr("d", function(d) {
        var path = "M" + xR + "," + (yR + d);
        path = path + "L" + (xR + prof) + "," + (yR + d - prof);
        path = path + "H" + (xR + w);
        return path;
      });
    }
    else {
        gelem.attr("x1", xR)
        .attr("y1", function (d) {
          return yR + d;
        })
        .attr("x2", xR + w)
        .attr("y2", function (d) {
          return yR + d;
        });
    }
  }
}

ZtBarChart.prototype._DrawHorizontalValueAxisGrid = function () {
  var ticksArray = d3.select(this.svg.select("#" + this.chartId + "valueAxisGroup").node().firstChild).selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;
  var pos = [],
  xR = this.margin.left,
  yR = this.margin.top,
  h = this.chartHeight,
  grid,
  prof,
  elemType = "line",
  gelem,
  _this = this;

  if (Empty(this.svg.select("#" + this.chartId + "valueAxisGridline").node()))
    grid = this.renderer.append("g").attr("id", this.chartId + "valueAxisGridline");

  if (this.defSettings.valueAxis.valueGrid.line) {
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      if (tick.transform.baseVal.length > 0 || tick.transform.baseVal.numberOfItems > 0)
        pos.push(tick.transform.baseVal.getItem(0).matrix.e);
    }
    
    if (this.is3D) {
      prof = 10;
      elemType = "path";
    }

    gelem = grid.selectAll(".valueGridline")
      .data(pos)
      .enter()
      .append(elemType)
        .attr("class", "valueGridline TRANSP")
        .attr("id", function (d, i) {
          return _this.chartId + "valueGLine_" + i;
        });

    if (this.is3D) {
      gelem .attr("d", function(d) {
        var path = "M" + (xR + d) + "," + yR;
        path = path + "V" + (yR + h - prof);
        path = path + "L" + (xR + d - prof) + "," + (yR + h);
        return path;
      });
    }
    else {
      gelem.attr("x1", function(d) {
        return xR + d;
      })
      .attr("y1", yR)
      .attr("x2", function(d) {
        return xR + d;
      })
      .attr("y2", yR + h);
    }
  }
}

ZtBarChart.prototype._DrawDomainAxisGrid = function () {
  if (this.isH)
    this._DrawHorizontalDomainAxisGrid();
  else
    this._DrawVerticalDomainAxisGrid();
}

ZtBarChart.prototype._DrawVerticalDomainAxisGrid = function () {
  var ticksArray = this.svg.select("#" + this.chartId + "domainAxisGroup").selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;

  var pos = [],
  xR = this.margin.left,
  yR = this.margin.top,
  h = this.chartHeight,
  grid,
  prof,
  elemType = "line",
  gelem,
  _this = this;

  if (Empty(this.svg.select("#" + this.chartId + "domainAxisGridline").node()))
    grid = this.renderer.append("g")
      .attr("id", this.chartId + "domainAxisGridline");
  
  if ((this.chartConfig.graphSettings.domainAxis.useValueGrid && this.chartConfig.graphSettings.valueAxis.valueGrid.line) || this.chartConfig.graphSettings.domainAxis.domainGrid.line) { // eslint-disable-line max-len
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      if (tick.transform.baseVal.length > 0 || tick.transform.baseVal.numberOfItems > 0)
        pos.push(tick.transform.baseVal.getItem(0).matrix.e);
    }
    
    if (this.is3D) {
      prof = 10;
      elemType = "path";
    }

    gelem = grid.selectAll(".domainGridline")
      .data(pos)
      .enter()
      .append(elemType)
        .attr("class", "domainGridline TRANSP")
        .attr("id", function (d, i) {
          return _this.chartId + "domainGLine_" + i;
        });

    if (this.is3D) {
      gelem.attr("d", function(d) {
        var path = "M" + (xR + d) + "," + (yR + h);
        path = path + "L" + (xR + d + prof) + "," + (yR + h - prof);
        path = path + "V" + (- h);
        return path;
      });
    }
    else {
      gelem.attr("x1", function (d) {
        return xR + d;
      })
      .attr("y1", yR)
      .attr("x2", function (d) {
        return xR + d;
      })
      .attr("y2", yR + h);
    }
  }
}

ZtBarChart.prototype._DrawHorizontalDomainAxisGrid = function () {
  var ticksArray = this.svg.select("#" + this.chartId + "domainAxisGroup").selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;

  var pos = [],
  xR = this.margin.left,
  yR = this.margin.top,
  w = this.chartWidth,
  grid,
  prof,
  elemType = "line",
  gelem,
  _this = this;

  if (Empty(this.svg.select("#" + this.chartId + "domainAxisGridline").node()))
    grid = this.renderer.append("g")
      .attr("id", this.chartId + "domainAxisGridline");
  
  if ((this.chartConfig.graphSettings.domainAxis.useValueGrid && this.chartConfig.graphSettings.valueAxis.valueGrid.line) || this.chartConfig.graphSettings.domainAxis.domainGrid.line) { // eslint-disable-line max-len
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      if (tick.transform.baseVal.length > 0 || tick.transform.baseVal.numberOfItems > 0)
        pos.push(tick.transform.baseVal.getItem(0).matrix.f);
    }

    if (this.is3D) {
      prof = 10;
      elemType = "path";
    }

    gelem = grid.selectAll(".domainGridline")
      .data(pos)
      .enter()
      .append(elemType)
        .attr("class", "domainGridline TRANSP")
        .attr("id", function (d, i) {
          return _this.chartId + "domainGLine_" + i;
        });

    if (this.is3D) {
      gelem.attr("d", function(d) {
        var path = "M" + xR + "," + (yR + d);
        path = path + "L" + (xR + prof) + "," + (yR + d - prof);
        path = path + "H" + (xR + w);
        return path;
      });
    }
    else {
      gelem.attr("x1", xR)
        .attr("y1", function(d) {
          return yR + d;
        })
        .attr("x2", xR + w)
        .attr("y2", function(d) {
          return yR + d;
        });
    }
  }
}

ZtBarChart.prototype._DrawAxisLabel = function () {
  if (this.isH)
    this._DrawHorizontalAxisLabel();
  else
    StdChart.prototype._DrawAxisLabel.call(this);
}

ZtBarChart.prototype._DrawHorizontalAxisLabel = function () {
  var xInit, yInit;
  xInit = this.margin.left + (this.chartWidth / 2);
  yInit = 0;
  this.DrawAxisLabel("value", this._GetValueAxisPosition(), xInit, yInit, this.defSettings.axisLabel.yLabel);
  xInit = this.margin.top + (this.chartHeight / 2);
  yInit = 0;
  this.DrawAxisLabel("domain", this._GetDomainAxisPosition(), xInit, yInit, this.defSettings.axisLabel.xLabel);
}

ZtBarChart.prototype._GetValueAxisPosition = function () {
  if (this.isH)
    return "top";
  return "left";
}

ZtBarChart.prototype._GetDomainAxisPosition = function () {
  if (this.isH)
    return "left";
  return "bottom";
}

ZtBarChart.prototype._GetValueAxisMinMax = function (scaleKey, minValue, maxValue) {
  var min,
  max,
  list = this.allValues;
  if (this.multipleScales && this.objConfig.mapSeries && this.objConfig.mapSeries[scaleKey] && this.objConfig.mapSeries[scaleKey].ownerScale)
    list = this[scaleKey + "_values"];
  if (Empty(minValue) && parseInt(minValue) != 0)
    min = d3.min(list);
  else
    min = parseFloat(minValue);
  if (Empty(maxValue) && parseInt(maxValue) != 0)
    max = d3.max(list);
  else
    max = parseFloat(maxValue);

  return { min: min, max: max };
}

ZtBarChart.prototype._SetValueScaleParameters = function (scaleKey, scaleY, min, max) {
  if (this.isH)
    return this._SetHorizontalValueScaleParameters(scaleKey, scaleY, min, max);
  else
    return this._SetVerticalValueScaleParameters(scaleKey, scaleY, min, max);
}

ZtBarChart.prototype._SetVerticalValueScaleParameters = function (scaleKey, scaleY, min, max) {
  var mh = this.chartHeight,
  start = this.is3D ? 10 : 0;

  if (this.defSettings.valueLabel.show == "horizontal" && (this.defSettings.valueLabel.position == "otop" || this.defSettings.valueLabel.position == "obottom")) {
    var txt = this.GetValueLabelMaxWord(this.dataSet),
    lblFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    hlen = getOffsetHeight(txt, lblFont, this.chartId);
    if (this.defSettings.valueLabel.position == "obottom")
      mh = mh - hlen;
    if (this.defSettings.valueLabel.position == "otop")
      start = start + hlen;
  }

  if (min >= 0)
    min = 0;
  
  if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue))
    min = this.defSettings.valueAxis.minValue;
  if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue))
    max = this.defSettings.valueAxis.maxValue;
  
  scaleY.domain([max, min]).range([start, mh]);

  return { min: min, max: max };
}

ZtBarChart.prototype._SetHorizontalValueScaleParameters = function (scaleKey, scaleY, min, max) {
  var mw = this.chartWidth,
  start = this.is3D ? 10 : 0;
  if (this.defSettings.valueLabel.show != "hide" && (this.defSettings.valueLabel.position == "left" || this.defSettings.valueLabel.position == "right")) {
    var txt = this.GetValueLabelMaxWord(this.dataSet),
    lblFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    wlen = getOffsetWidth(txt, lblFont, this.chartId),
    offset = 5;
    if (this.defSettings.valueLabel.position == "right")
      mw = mw - wlen - offset;
    if (this.defSettings.valueLabel.position == "left")
      start = start + wlen;
  }
  if (min >= 0)
    min = 0;
  
  if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue))
    min = this.defSettings.valueAxis.minValue;
  if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue))
    max = this.defSettings.valueAxis.maxValue;

  scaleY.domain([min, max]).range([start, mw]);

  return { min: min, max: max };
}

ZtBarChart.prototype._SelectAutoTickUnit = function (scaleY, min, max, font, isDomain, precision) {
  if (this.isH)
    this._HSelectAutoTickUnit(scaleY, min, max, font, isDomain, precision);
  else
    StdChart.prototype._SelectAutoTickUnit.call(this, scaleY, min, max, font, isDomain, precision);
}

ZtBarChart.prototype._HSelectAutoTickUnit = function (scaleY, min, max, font, isDomain, precision) {
  if (Empty(this.tickUnit))
    this.tickUnit = 1.0;
  var isFloat = precision > 0,
  unit1, unit2, guess,
  maxDigits = Math.max(howManyDigits(min), howManyDigits(max));
  this.allValues.concat([min, max]);

  var stdTU = getStandardTickUnits(maxDigits, isFloat);
  if (!isDomain) {
    var tickLabelWidth = estimateMaximumTickLabel("width", Math.round(min), Math.round(max), this.chartId, font, precision);
    unit1 = this.tickUnit;
    var unit1Width = Math.abs(scaleY(unit1) - scaleY(0));
    guess = (tickLabelWidth / unit1Width) * unit1;
    unit2 = getCeilingTickUnit(stdTU, guess);
    var unit2Width = Math.abs(scaleY(stdTU[unit2]) - scaleY(0));
    if (tickLabelWidth > unit2Width) {
      unit2 = getLargerTickUnit(stdTU, stdTU[unit2]);
    }
    this.tickUnit = stdTU[unit2];
  }
  else {
    var tickLabelHeight = estimateMaximumTickLabel("height", Math.round(min), Math.round(max), this.chartId, font, precision);
    unit1 = this.tickUnit;
    var unit1Height = Math.abs(this.scaleX(unit1) - this.scaleX(0));
    guess = (tickLabelHeight / unit1Height) * unit1;
    unit2 = getCeilingTickUnit(stdTU, guess);
    var unit2Height = Math.abs(this.scaleX(stdTU[unit2]) - this.scaleX(0));
    if (tickLabelHeight > unit2Height) {
      unit2 = getLargerTickUnit(stdTU, stdTU[unit2]);
    }
    this.tickUnit = stdTU[unit2];
  }
}

ZtBarChart.prototype._SetDomainScaleParameters = function () {
  var offset = (this.is3D && !this.isH) ? 10 : 0,
  offsetStart = (this.is3D && this.isH) ? 10 : 0,
  prop = this.isH ? "chartHeight" : "chartWidth";

  if ((this.domainIsTime && this.dataOrder == "column") || this.domainIsNumber)
    this.scaleX.range([offsetStart, this[prop] - offset]);
  else
    this.scaleX.range([offsetStart, this[prop] - offset]).padding(0.1);
}

ZtBarChart.prototype._GetDomainAxisXPosition = function () {
  var offset = this.isH ? - 3 : 0;
  return this.margin.left + offset;
}

ZtBarChart.prototype._GetDomainAxisYPosition = function () {
  var offset = this.isH ? 0 : this.chartHeight + 3;
  return this.margin.top + offset;
}

ZtBarChart.prototype._GetValueAxisXPosition = function () {
  var offset = this.isH ? 0 : - 3;
  return this.margin.left + offset;
}

ZtBarChart.prototype._GetValueAxisYPosition = function () {
  var offset = this.isH ? - 3 : 0;
  return this.margin.top + offset;
}

ZtBarChart.prototype._DrawChartElements = function () {
  delete this.bandWidth;
  var renderer = this.renderer,
  group = renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  bandWidth = this._GetBarWidthFromDomainEvaluation();

  var yIndex = -1,
  margins = this.defSettings.bars.margins,
  seriesOffset = 0,
  cobj;
  if (isNaN(margins) || Empty(margins))
    margins = 0;
  var dSeries = this._GetDrawingList(),
  scaleS = d3.scaleBand()
    .domain(dSeries)
    .range([0, bandWidth]);

  if (this.is3D) {
    if (this.isH) {
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath1");
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath2");
    }
    else {
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath2");
      group.append("g")
        .attr("id", this.chartId + this.type + "_3Dpath1");
    }
  }

  for (var i = 0; i < dSeries.length; i++) {
    yIndex = this.propertyName.indexOf(dSeries[i]);
    cobj = this._GetDrawParamObject(margins, seriesOffset, scaleS.bandwidth());
    cobj.scaleY = this.scaleY[dSeries[i]];
    if (this.is3D) {
      var index = this.valueFields.indexOf(dSeries[i]);
      this._Draw3DElementPath1(this.svg.select("#" + this.chartId + this.type + "_3Dpath1"), this.dataSet, index, this.xIndex, yIndex, cobj);
      this._Draw3DElementPath2(this.svg.select("#" + this.chartId + this.type + "_3Dpath2"), this.dataSet, index, this.xIndex, yIndex, cobj);
    }
    this.DrawBar(group, this.dataSet, i, this.xIndex, yIndex, cobj);
    seriesOffset = seriesOffset + scaleS.bandwidth();
  }

  this._DrawShadows();
}

ZtBarChart.prototype._GetBarX = function (data, dataIndex, xIndex, yIndex, cobj) {
  if (this.isH)
    return this._GetHBarX(data, dataIndex, xIndex, yIndex, cobj);
  else
    return this._GetVBarX(data, dataIndex, xIndex, yIndex, cobj);
}

ZtBarChart.prototype._GetBarY = function (data, dataIndex, xIndex, yIndex, cobj) {
  if (this.isH)
    return this._GetHBarY(data, dataIndex, xIndex, yIndex, cobj);
  else
    return this._GetVBarY(data, dataIndex, xIndex, yIndex, cobj);
}

ZtBarChart.prototype._GetBarWidth = function (data, yIndex, cobj) {
  if (this.isH)
    return this._GetHBarWidth(data, yIndex, cobj);
  else
    return this._GetVBarWidth(data, yIndex, cobj);
}

ZtBarChart.prototype._GetBarHeight = function (data, yIndex, cobj) {
  if (this.isH)
    return this._GetHBarHeight(data, yIndex, cobj);
  else
    return this._GetVBarHeight(data, yIndex, cobj);
}

ZtBarChart.prototype._GetVBarX = function (data, dataIndex, xIndex, yIndex, cobj) {
  var x = 0;
  if (dataIndex == 0)
    x = this.scaleX(data[xIndex]) + cobj.seriesOffset;
  else if (dataIndex > 0 && dataIndex != this.valueFields.length-1)
    x = this.scaleX(data[xIndex]) + cobj.seriesOffset + (cobj.margins / 8);
  else
    x = this.scaleX(data[xIndex]) + cobj.seriesOffset + (cobj.margins / 4);
  x = x + (cobj.bandOffset / 2) - (cobj.barWidth / 2);
  return x;
}

ZtBarChart.prototype._GetVBarY = function (data, dataIndex, xIndex, yIndex, cobj) {
  var y = 0,
  max = this.defSettings.valueAxis.maxValue,
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  if (data[yIndex] < 0) {
    if (!Empty(max) && max < 0)
      y = cobj.scaleY(max);
    else
      y = cobj.scaleY(sMax);
  }
  else {
    if (!Empty(max) && data[yIndex] > max)
      y = cobj.scaleY(max);
    else
      y = cobj.scaleY(data[yIndex]);
  }
  return y;
}

ZtBarChart.prototype._GetVBarWidth = function (data, yIndex, cobj) {
  var w = cobj.barWidth - (cobj.barWidth * (cobj.margins / 100));
  return w;
}

ZtBarChart.prototype._GetVBarHeight = function (data, yIndex, cobj) {
  var h = 0,
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
        h = Math.abs(cobj.scaleY(min) - cobj.scaleY(sMax));
      else if (!Empty(min) && min >= 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMax));
    }
    else {
      if (max <= data[yIndex])
        h = 0;
      if (!Empty(min) && min <= 0 && data[yIndex] < min)
        h = Math.abs(cobj.scaleY(min) - cobj.scaleY(max));
      else if (!Empty(min) && min >= 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(max));
    }
  }
  else {
    if (!Empty(min) && min > 0) {
      if (min > data[yIndex])
        h = 0;
      if (!Empty(max) && data[yIndex] > max && max >= 0)
        h = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
      else if (max < 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(min));
    }
    else {
      if (!Empty(max) && data[yIndex] > max && max >= 0)
        h = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
      else if (max < 0)
        h = 0;
      else
        h = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
    }
  }
  return h;
}

ZtBarChart.prototype._GetHBarX = function (data, dataIndex, xIndex, yIndex, cobj) {
  var x = 0,
  prof = this.is3D ? 10 : 0,
  min = this.defSettings.valueAxis.minValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain()),
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  
  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;

  if (data[yIndex] < 0) {
    if (!Empty(min) && min <= 0 && data[yIndex] < min)
      x = cobj.scaleY(Math.min(sMax, min));
    else
      x = cobj.scaleY(Math.min(sMax, data[yIndex]));
  }
  else {
    if (!Empty(min) && min > 0)
      x = cobj.scaleY(Math.min(min, data[yIndex]));
    else
      x = cobj.scaleY(Math.min(sMin, data[yIndex]));
  }
  return x - prof;
}

ZtBarChart.prototype._GetHBarY = function (data, dataIndex, xIndex, yIndex, cobj) {
  return this._GetVBarX(data, dataIndex, xIndex, yIndex, cobj);
}

ZtBarChart.prototype._GetHBarWidth = function (data, yIndex, cobj) {
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
    if (!Empty(max)) {
      if (max < 0 && max > data[yIndex]) {
        if (!Empty(min) && min < 0 && data[yIndex] <= min)
          w = Math.abs(cobj.scaleY(min) - cobj.scaleY(max));
        else if ((!Empty(min) && min < 0 && data[yIndex] > min) || Empty(min))
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(max));
        else
          w = 0;
      }
      else if (max >= 0) {
        if (!Empty(min) && min < 0 && data[yIndex] <= min) {
          w = Math.abs(cobj.scaleY(min) - cobj.scaleY(sMax));
        }
        else if ((!Empty(min) && min < 0 && data[yIndex] > min) || Empty(min)) {
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMax));
        }
        else
          w = 0;
      }
      else
        w = 0;
    }
    else{
      if (!Empty(min) && min < 0 && data[yIndex] <= min) {
        w = Math.abs(cobj.scaleY(min) - cobj.scaleY(sMax));
      }
      else if ((!Empty(min) && min < 0 && data[yIndex] > min) || Empty(min)) {
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMax));
      }
      else
        w = 0;
    }
  }
  else{
    if (!Empty(min)) {
      if (min < data[yIndex] && min >= 0) {
        if (!Empty(max)) {
          if (max > 0 && max <= data[yIndex])
            w = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
          else if (max > 0 && max > data[yIndex])
            w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(min));
          else
            w = 0;
        }
        else{
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(min));
        }
      }
      else if (min < 0) {
        if (!Empty(max)) {
          if (max > 0 && max <= data[yIndex])
            w = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
          else if (max > 0 && max > data[yIndex])
            w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
          else
            w = 0;
        }
        else{
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
        }
      }
      else
        w = 0;
    }
    else{
      if (!Empty(max)) {
        if (max >  0 && max <= data[yIndex])
          w = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
        else if (max > 0 && max > data[yIndex])
          w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
        else
          w = 0;
      }
      else{
        w = Math.abs(cobj.scaleY(data[yIndex]) - cobj.scaleY(sMin));
      }
    }
  }
  return w;
}

ZtBarChart.prototype._GetHBarHeight = function (data, yIndex, cobj) {
  return this._GetVBarWidth(data, yIndex, cobj);
}

ZtBarChart.prototype._CreateRendererGradient = function (color, gradient, gDef) {
  var transpC = (color == "transparent" || Empty(color)),
  transpG = (gradient == "transparent" || Empty(gradient));

  gDef.attr("x1", "0%")
    .attr("y1", "100%")
    .attr("x2", "0%")
    .attr("y2", "0%");
  gDef.append("stop")
      .attr("offset", "0%")
      .attr("stop-color", transpC ? "#FFFFFF" : color)
      .attr("stop-opacity", transpC ? "0" : "1");
  gDef.append("stop")
      .attr("offset","100%")
      .attr("stop-color", transpG ? "#FFFFFF" : gradient)
      .attr("stop-opacity", transpG ? "0" : "1");
}

ZtBarChart.prototype._CreateElementGradient = function (color, gradient, gDef) {
  gDef.attr("x1", "0%")
    .attr("y1", "0%")
    .attr("x2", "100%")
    .attr("y2", "0%");
  gDef.append("stop")
      .attr("offset", "0%")
      .attr("stop-color", color)
      .attr("stop-opacity", "1");
  gDef.append("stop")
      .attr("offset","100%")
      .attr("stop-color", gradient)
      .attr("stop-opacity", "1");
}

ZtBarChart.prototype._SetAxisColor = function () {
  // top y2 -3 | btm y2 3 | lft x2 -3 | rgt x2 3
  if (this.isH) {
    var scs = Object.keys(this.scaleY);
    for (var i = 0; i < scs.length; i++) {
      if (!this.scaleY[scs[i]].__noDraw)
        this.SetAxisColor("value", "y2", -3, false, replaceSpecialCharsForID("_" + this.scaleY[scs[i]].__refAxis), this.scaleY[scs[i]].__refAxis);
    }
    this.SetAxisColor("domain", "x2", -3);
  }
  else
    StdChart.prototype._SetAxisColor.call(this);
}

ZtBarChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1;
  for (var i = 0; i < this.items.length; i++) {
    idx = this.valueFields.indexOf(this.items[i].valueField);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.categoryList.indexOf(this.items[i].category);
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      this._SetItemColors(this.items[i]);
    }
  }
}

ZtBarChart.prototype._SetItemColors = function (item) {
  var borderColors = setColorSeriesArray(this.defSettings.bars.barsLine.colorSeries, this.valueFields, this.defSettings.bars.barsLine.reuseColorSeries, true),
  styleObj = {},
  fill,
  idx = item.idx,
  sidx = item.sidx,
  gradID = this.chartId + this.type + "_" + idx + "Gradient";
  if (!Empty(item.color.color) && Empty(item.color.gradient) || item.color.color.toLowerCase() == item.color.gradient.toLowerCase())
    fill = item.color.color;
  else if (Empty(item.color.color) && !Empty(item.color.gradient))
    fill = item.color.gradient;
  else {
    this.CreateGradient(item.color.color, item.color.gradient, gradID, "element");
    fill = "url(#" + gradID + ")";
  }
  styleObj.fill = fill;
  item.colorApplied = fill;
  styleObj.shape9rendering = "crispEdges";
  if (this.defSettings.bars.barsLine.stroke > 0) {
    styleObj.stroke9width = this.defSettings.bars.barsLine.stroke;
    var stroke;
    if (!borderColors[idx])
      stroke = "#A3A3A3";
    else {
      if (!Empty(borderColors[idx].color) && Empty(borderColors[idx].gradient) || borderColors[idx].color.toLowerCase() == borderColors[idx].gradient.toLowerCase())
        stroke = borderColors[idx].color;
      else if (Empty(borderColors[idx].color) && !Empty(borderColors[idx].gradient))
        stroke = borderColors[idx].gradient;
      else {
        gradID = this.chartId + this.type + "_" + idx + "BorderGradient";
        this.CreateGradient(borderColors[idx].color, borderColors[idx].gradient, gradID, "element");
        stroke = "url(#" + gradID + ")";
      }
    }
    styleObj.stroke = stroke;
  }
  d3.select(item.itm).attr("style", makeStyleHTMLString(styleObj, d3.select(item.itm).attr("style")));
  var path3D;
  if (this.is3D) {
    sidx = item.sidx;
    fill = get3DColor(item.color);
    styleObj.fill = fill.color;
    path3D = d3.selectAll(".bar3D_" + idx + '_' + sidx)._groups;
    for (var j = 0; j < path3D[0].length; j++)
      d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
  }
}

ZtBarChart.prototype._SetAxisLabelsPositions = function () {
  if (this.isH)
    this._SetHorizontalAxisLabelsPositions();
  else
    this._SetVerticalAxisLabelsPositions();
}

ZtBarChart.prototype._SetVerticalAxisLabelsPositions = function () {
  StdChart.prototype._SetAxisLabelsPositions.call(this);
}

ZtBarChart.prototype._SetHorizontalAxisLabelsPositions = function () {
  var axisLabel = this.svg.select("#" + this.chartId + "valueAxisLabel"),
  axisLabelD = this.svg.select("#" + this.chartId + "domainAxisLabel"),
  y, offset, upd, legend;
  if (Empty(axisLabel.node()) && Empty(axisLabelD.node()))
    return;
  if (!Empty(axisLabel.node())) {
    y = parseFloat(axisLabel.attr("y")),
    offset = 5;
    upd = false;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == "top") {
      y = y + getOffsetHeight(this.chartTitle, appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont), this.chartId);
      upd = true;
    }
    if (!Empty(this.legendList) && this.chartLegends.series.position == "top" && !this.chartLegends.series.hide) {
      legend = parseFloat(d3.select("#" + this.chartId + "legend_container_rect").attr("height"));
      y = y + legend;
      if (upd)
        y = y + offset;
      upd = true;
    }
    if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.position == "top") {
      y = y + getOffsetHeight(this.chartSubtitle, appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont), this.chartId);
      if (upd)
        y = y + offset;
      upd = true;
    }
    axisLabel.attr("y", y);
  }
  if (!Empty(axisLabelD.node())) {
    y = parseFloat(axisLabelD.attr("y")),
    offset = 5;
    upd = false;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == "left") {
      y = y + getOffsetHeight(this.chartTitle, appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont), this.chartId);
      upd = true;
    }
    if (!Empty(this.legendList) && this.chartLegends.series.position == "left") {
      legend = parseFloat(d3.select("#" + this.chartId + "legend_container_rect").attr("width"));
      y = y + legend + offset;
      upd = true;
    }
    if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.position == "left") {
      y = y + getOffsetHeight(this.chartSubtitle, appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont), this.chartId);
      upd = true;
    }
    if (upd)
      y = y + offset;
    axisLabelD.attr("y", y);
  }
}

ZtBarChart.prototype._Draw3DElementPath1 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  if (this.isH)
    this._Draw3DHorizontalElementPath1(container, data, dataIndex, xIndex, yIndex, cobj);
  else
    this._Draw3DVerticalElementPath1(container, data, dataIndex, xIndex, yIndex, cobj);
}

ZtBarChart.prototype._Draw3DElementPath2 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  if (this.isH)
    this._Draw3DHorizontalElementPath2(container, data, dataIndex, xIndex, yIndex, cobj);
  else
    this._Draw3DVerticalElementPath2(container, data, dataIndex, xIndex, yIndex, cobj);
}

ZtBarChart.prototype._Draw3DVerticalElementPath1 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this;

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d, idx) {
        return "barPath1 bar3D_" + dataIndex + "_" + idx + " TRANSP";
      })
      .attr("d",function(d){
        if (!_this._IsNotExcludedDomain(d[xIndex]))
          return "";
        var xB = _this._GetBarX(d, dataIndex, xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, dataIndex, xIndex, yIndex, cobj),
        min = _this.defSettings.valueAxis.minValue,
        max = _this.defSettings.valueAxis.maxValue,
        path = "";
        if (!Empty(min) && min > 0 && (d[yIndex] < 0 || min > d[yIndex]))
          path = "M" + xB + "," + yB;
        else if (!Empty(max) && max < 0 && max == d[yIndex])
          path = "M" + xB + "," + yB;
        else {
          path = "M" + xB + "," + yB;
          path = path + "L" + (xB + prof) + "," + (yB - prof);
          path = path + "L" + (xB +  cobj.barWidth - (cobj.barWidth * (cobj.margins / 100)) + prof) + "," + (yB - prof);
          path = path + "L" + (xB +  cobj.barWidth - (cobj.barWidth * (cobj.margins / 100))) + "," + yB;
          path = path + "Z";
        }
        return path;
      });
}

ZtBarChart.prototype._Draw3DVerticalElementPath2 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this;

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d, idx) {
        return "barPath2 bar3D_" + dataIndex + "_" + idx + " TRANSP";
      })
      .attr("d", function(d) {
        if (!_this._IsNotExcludedDomain(d[xIndex]))
          return "";
        var xB = _this._GetBarX(d, dataIndex, xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, dataIndex, xIndex, yIndex, cobj),
        min = _this.defSettings.valueAxis.minValue,
        path = "";
        if (!Empty(min) && min >= 0 && (d[yIndex] < 0 || min > d[yIndex]))
          path = "M" + xB + "," + yB;
        else {
          var he = _this._GetBarHeight(d, yIndex, cobj);
          path = "M" + (xB + cobj.barWidth - (cobj.barWidth * (cobj.margins / 100))) + "," + yB;
          path = path + "L" + (xB + cobj.barWidth - (cobj.barWidth * (cobj.margins / 100)) + prof) + "," + (yB - prof);
          path = path + "L" + (xB + cobj.barWidth - (cobj.barWidth * (cobj.margins / 100)) + prof) + "," + (yB + he - prof);
          path = path + "L" + (xB + cobj.barWidth - (cobj.barWidth * (cobj.margins / 100))) + "," + (yB + he);
          path = path + "Z";
        }
        return path;
      });
}

ZtBarChart.prototype._Draw3DHorizontalElementPath1 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this;

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d, idx) {
        return "barPath1 bar3D_" + dataIndex + "_" + idx + " TRANSP";
      })
      .attr("d",function(d){
        if (!_this._IsNotExcludedDomain(d[xIndex]))
          return "";
        var xB = _this._GetBarX(d, dataIndex, xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, dataIndex, xIndex, yIndex, cobj),
        min = _this.defSettings.valueAxis.minValue,
        max = _this.defSettings.valueAxis.maxValue,
        path = "";
        if ((!Empty(min) && min > 0 && d[yIndex] < 0) || (!Empty(min) && min > 0 && min > d[yIndex]))
          path = "M" + xB + "," + yB;
        else if (!Empty(max) && max <= 0 && d[yIndex] > 0)
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

ZtBarChart.prototype._Draw3DHorizontalElementPath2 = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var prof = 10,
  _this = this;

  container.selectAll(".bar3D_" + dataIndex)
    .data(data)
    .enter()
      .append("path")
      .attr("class", function(d, idx) {
        return "barPath2 bar3D_" + dataIndex + "_" + idx + " TRANSP";
      })
      .attr("d", function(d) {
        if (!_this._IsNotExcludedDomain(d[xIndex]))
          return "";
        var xB = _this._GetBarX(d, dataIndex, xIndex, yIndex, cobj),
        yB = _this._GetBarY(d, dataIndex, xIndex, yIndex, cobj),
        min = _this.defSettings.valueAxis.minValue,
        max = _this.defSettings.valueAxis.maxValue,
        path = "";
        if ((!Empty(min) && min > 0 && d[yIndex] < 0) || (!Empty(min) && min > 0 && min > d[yIndex]))
          path = "M" + xB + "," + yB;
        else if (!Empty(max) && max <= 0 && d[yIndex] > 0)
          path = "M" + xB + "," + yB;
        else {
          var w = _this._GetBarWidth(d, yIndex, cobj);
          path = "M" + (xB + w) + "," + yB;
          path = path + "L" + (xB + w + prof) + "," + (yB - prof);
          path = path + "L" + (xB + w + prof) + "," + (yB + cobj.barWidth - (cobj.barWidth * (cobj.margins / 100)) - prof);
          path = path + "L" + (xB + w)+ "," + (yB + cobj.barWidth - (cobj.barWidth * (cobj.margins / 100)));
          path = path + "Z";


        }
        return path;
      });
}

ZtBarChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, rangebandslabels) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  var myM = {};
  if (this.isH) {
    //xlabel
    myM = setMarginObject(settings.axisLabel.xLabel, settings.axisLabel.axisFont, settings.axisLabel.useGlobalFont, settings.globalFont);
    if (myM != 0) {
      myM.offset = 5;
      ret.left.push(myM);
    }

    //ylabel
    myM = setMarginObject(settings.axisLabel.yLabel, settings.axisLabel.axisFont, settings.axisLabel.useGlobalFont, settings.globalFont);
    if (myM != 0) {
      myM.offset = 5;
      ret.top.push(myM);
    }

    //categorie
    var appliedfont, format;
    if (!Empty(categoryList) && settings.domainAxis.show) {
      if (settings.domainAxis.useValueFont)
        appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
      else
        appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);
      if (domainIsTime && dataOrder=="column") {
        if (Empty(settings.time.customFormat) && !Empty(settings.time.format))
          myM.text = settings.time.format;
        else if (!Empty(settings.time.customFormat) && Empty(settings.time.format)) {
          format = getTimeTickFormat(localeLangFormat, settings.time.customFormat);
          if (Object.prototype.toString.call(categoryList[0]) === '[object Date]') {
            var myTa = [];
            for (var k = 0; k < categoryList.length; k++)
              myTa.push(format(categoryList[k]));
            myM.text = getMaxWordLength(myTa);
          }
          else
            myM.text = format(this.strToDateTime(getMaxWordLength(categoryList), datetimePict));
        }
        else
          myM.text = "Settembre";
      }
      else if (domainIsNumber)
        myM.text = getMaxWordLength(categoryList, domprec);
      else
        myM.text = getMaxWordLengthString(categoryList);

      if (settings.domainAxis.labelType == 'V' || settings.domainAxis.labelType == 'VD')
        myM.textorientation = 90;
      else
        myM.textorientation = 0;
      myM.type = "domainAxis";
      myM.offset = 6;
      ret.left.push(myM);
    }

    //ticks - domainAxis
    if (settings.domainAxis.show) {
      appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);
      myM.text = ""; //ipotesi
      myM.addH = 6; //TICK HEIGHT 6
      myM.addW = 6;
      myM.offset = 0;
      myM.textorientation = 0;
      ret.left.push(myM);
    }

    //valori
    var i, mfontsize = 0;
    if (settings.valueAxis.show) {
      appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont),
      add = false,
      vfields = this.valueFields,
      _this = this;
      if (this._ZtChart.StdChart && !this._ZtChart.StdChart.IsMultiDim()) {
        vfields = this._ZtChart.StdChart.valueFields;
        _this = this._ZtChart.StdChart;
      }
      for (i = 0; i < vfields.length; i++) {
        myM = getGenericLabelConf(appliedfont);
        myM.textorientation = 90;
        myM.offset = 0;
        if (Empty(settings.axisLabel.yLabel))
          myM.offset = 5;
        if (this.multipleScales) {
          myM.offset = myM.offset + 10;
          if (this.objConfig.mapSeries && this.objConfig.mapSeries[vfields[i]] && this.objConfig.mapSeries[vfields[i]].ownerScale)
            myM.text = getMaxWordLength(this[vfields[i] + "_values"], valprec, this.localeLangFormat.numberFormat(",." + valprec + "f"));
          else if (!add) {
            myM.text = getMaxWordLength(allValues, valprec, this.localeLangFormat.numberFormat(",." + valprec + "f"));
            add = true;
          }
        }
        else {
          myM.text = getMaxWordLength(allValues, valprec, this.localeLangFormat.numberFormat(",." + valprec + "f"));
          i = vfields.length;
        }

        if (!Empty(myM.text)) {
          mfontsize = Math.max(mfontsize, myM.fontsize);
          ret.top.push(myM);
        }
      }
    }

    myM = {};
    myM.text = "";
    myM.offset = mfontsize;
    myM.textorientation = 0;
    ret.right.push(myM);

    //range labels - no legenda, le visualizzo sull'asse
    if (!Empty(rangebandslabels) && (!chartLegends.range || (chartLegends.range && (chartLegends.range.position=="hide" || chartLegends.range.hide || chartLegends.range.tooLong)))) {
      myM = getGenericLabelConf(settings.globalFont);
      myM.text = getMaxWordLength(rangebandslabels);
      myM.offset = 10;
      myM.textorientation = 0;
      ret.right.push(myM);
    }
  }
  else {
    //xlabel
    myM = setMarginObject(settings.axisLabel.xLabel, settings.axisLabel.axisFont, settings.axisLabel.useGlobalFont, settings.globalFont);
    if (myM != 0) {
      myM.offset = 5;
      ret.bottom.push(myM);
    }

    //ylabel
    myM = setMarginObject(settings.axisLabel.yLabel, settings.axisLabel.axisFont, settings.axisLabel.useGlobalFont, settings.globalFont);
    if (myM != 0) {
      myM.offset = 5;
      ret.left.push(myM);
    }

    //categorie
    if (!Empty(categoryList) && settings.domainAxis.show) {
      appliedfont;
      if (settings.domainAxis.useValueFont)
        appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
      else
        appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);

      if (domainIsTime && dataOrder == "column") {
        if (Empty(settings.time.customFormat) && !Empty(settings.time.format))
          myM.text = settings.time.format;
        else if (!Empty(settings.time.customFormat) && Empty(settings.time.format)) {
          format = getTimeTickFormat(localeLangFormat, settings.time.customFormat);
          myM.text = getMaxWordLength(categoryList, null, format);
        }
      }
      else if (domainIsNumber)
        myM.text = getMaxWordLength(categoryList, domprec);
      else 
        myM.text = getMaxWordLengthString(categoryList);

      if (settings.domainAxis.labelType == 'H')
        myM.textorientation = 90;
      else
        myM.textorientation = 0;
      myM.type = "domainAxis";
      ret.bottom.push(myM);
    }

    //ticks - domainAxis
    if (settings.domainAxis.show) {
      appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);
      myM.text = ""; //ipotesi
      myM.addH = 6; //TICK HEIGHT 6
      myM.addW = 6;
      myM.textorientation = 90;
      ret.bottom.push(myM);
    }

    //valori
    if (settings.valueAxis.show) {
      appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
      mfontsize = 0;
      var add = false,
      vfields = this.valueFields,
      _this = this;
      if (this._ZtChart.StdChart && !this._ZtChart.StdChart.IsMultiDim()) {
        vfields = this._ZtChart.StdChart.valueFields;
        _this = this._ZtChart.StdChart;
      }
      for (i = 0; i < vfields.length; i++) {
        myM = getGenericLabelConf(appliedfont);
        myM.textorientation = 0;
        myM.offset = 0;
        if (Empty(settings.axisLabel.yLabel))
          myM.offset = 5;
        if (_this.multipleScales) {
          myM.offset = myM.offset + 10;
          if (_this.objConfig.mapSeries && _this.objConfig.mapSeries[vfields[i]] && _this.objConfig.mapSeries[vfields[i]].ownerScale)
            myM.text = getMaxWordLength(_this[vfields[i] + "_values"], valprec, _this.localeLangFormat.numberFormat(",." + valprec + "f"));
          else if (!add) {
            myM.text = getMaxWordLength(allValues, valprec, _this.localeLangFormat.numberFormat(",." + valprec + "f"));
            add = true;
          }
        }
        else {
          myM.text = getMaxWordLength(allValues, valprec, _this.localeLangFormat.numberFormat(",." + valprec + "f"));
          i = vfields.length;
        }
        if (!Empty(myM.text)) {
          mfontsize = Math.max(mfontsize, myM.fontsize);
          ret.left.push(myM);
        }
      }
    }

    myM = {};
    myM.text = "";
    myM.offset = mfontsize;
    myM.textorientation = 0;
    ret.top.push(myM);

    //range labels - no legenda, le visualizzo sull'asse
    if (!Empty(rangebandslabels) && (!chartLegends.range || (chartLegends.range && (chartLegends.range.position=="hide" || chartLegends.range.hide || chartLegends.range.tooLong)))) {
      myM = getGenericLabelConf(settings.globalFont);
      myM.text = getMaxWordLength(rangebandslabels);
      myM.offset = 10;
      myM.textorientation = 0;
      ret.right.push(myM);
    }
  }

  return ret;
}

ZtBarChart.prototype._AnimateChartElements = function () {
  StdChart.prototype._AnimateChartElements.call(this);

  var div = this._GetAnimatedDivisor();
  if (this.is3D) {
    d3.select("#" + this.chartId + this.type + "_3Dpath1")
      .style("fill-opacity", 0)
    .transition()
      .delay(this.valueFields.length * this.defSettings.animation.duration/div)
      .duration(this.defSettings.animation.duration/div)
      .style("fill-opacity", 1);

    d3.select("#" + this.chartId + this.type + "_3Dpath2")
      .style("fill-opacity", 0)
    .transition()
      .delay(this.valueFields.length * this.defSettings.animation.duration/div)
      .duration(this.defSettings.animation.duration/div)
      .style("fill-opacity", 1);
  }
}

ZtBarChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  value, value2,
  defaultValues = Empty(lastValueObj);
  if (this.isH) {
    value = d3.select(elem).attr("width");
    value2 = d3.select(elem).attr("x");
    d3.select(elem)
      .attr("width", defaultValues ? 0 : lastValueObj.width);
    if ((item.progrValue && item.progrValue < 0) || item.value < 0)
      d3.select(elem)
        .attr("x", (defaultValues ? parseFloat(value2) : lastValueObj.x) + (defaultValues ? parseFloat(value) : lastValueObj.width))
    else
      d3.select(elem)
        .attr("x", defaultValues ? parseFloat(value2) : lastValueObj.x)
    d3.select(elem)
      .transition()
        .delay(item.idx * (duration / div))
        .duration(duration / div)
        .ease(d3.easeLinear)
        .attr("width", value)
        .attr("x", value2);
  }
  else {
    value = d3.select(elem).attr("height");
    value2 = d3.select(elem).attr("y");
    d3.select(elem)
      .attr("height", defaultValues ? 0 : lastValueObj.height);

    if ((item.progrValue && item.progrValue < 0) || item.value < 0)
      d3.select(elem)
        .attr("y", defaultValues ? parseFloat(value2) : lastValueObj.y)
    else
      d3.select(elem)
        .attr("y", defaultValues ? (parseFloat(value) + parseFloat(value2)) : lastValueObj.y)

    d3.select(elem)
      .transition()
        .delay(item.idx * (duration / div))
        .duration(duration / div)
        .ease(d3.easeLinear)
        .attr("height", value)
        .attr("y", value2);
  }
}

ZtBarChart.prototype._ApplyMouseOver = function (item, itemObj) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  this.RemoveAllHovers();
  this.AppendHoverItem(item); //GM //mRefChart.AppendHoverItem(item);
  if (item) {
    // 3D
    var itemObject = itemObj || this.items[d3.select(item).attr("item-index")];
    if (this.is3D && itemObject.sidx >= 0) {
      var path3D = this.svg.selectAll(".bar3D_" + itemObject.idx + "_" + itemObject.sidx)._groups;
      for (var j = 0; j < path3D[0].length; j++) {
        var clone = path3D[0][j].cloneNode();
        d3.select(clone)
          .attr("item-type", "hover")
          .style("opacity", 0.5)
          .style("fill", function () {
            if (!Empty(_this.defSettings.hoverColor))
              return _this.defSettings.hoverColor;
            var darkCol = d3.rgb(itemObject.colorApplied).darker().toString();
            darkCol = d3.rgb(darkCol).darker().toString();
            return d3.rgb(darkCol).darker().toString();
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
            mRefChart.RemoveHoverTimeout();
          })
          .on("click", function () {
            _this._ApplyClick(itemObject, d3.mouse(this));
          });

        item.parentNode.appendChild(clone);
      }
    }
  }
}

ZtBarChart.prototype._ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (!this.defSettings.range.applyColor && !isFnc) {
    this.SetRangeInItems();
    if (this.isH)
      this._DrawRangeBandsHorizontalAxis();
    else
      this._DrawRangeBandsVerticalAxis();
  }
  else
    this._SetElementsRangeColor(isFnc);
}

ZtBarChart.prototype._SetElementsRangeColor = function (isFnc) {
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
        var band = this.GetObjectFromRange(this.items[i].value, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.items[i], band);
        styleObj = { fill: fill };
      }
      this.items[i].colorApplied = fill;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      if (this.is3D) {
        fill = get3DColor({ color: this.items[i].colorApplied, gradient: "" });
        styleObj.fill = fill.color;
        var path3D = d3.selectAll(".bar3D_" + this.items[i].idx + '_' + this.items[i].sidx)._groups;
        for (var j = 0; j < path3D[0].length; j++)
          d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
      }
      this._DrawMarkerIconOnItem(this.items[i]);
    }
  }
}

ZtBarChart.prototype._SetAxisLabelOrientation = function (axisType, orientation, axId) {
  axId = axId || "";
  var ticks = this.svg.select("#" + this.chartId + axisType + "AxisGroup" + axId).selectAll("text")._groups[0],
  textTick,
  textRect,
  offsetTick = 6;
  for (var i = 0; i < ticks.length; i++) {
    textTick = d3.select(ticks[i]);
    textTick.attr("y", 1.5 * offsetTick);
    if (this.isH)
      textTick.attr("y", 0);
    textRect = textTick.node().getBBox();
    switch (orientation) {
      case "V" :
        if (this.isH)
          textTick.attr("transform", "rotate(-90) translate(" + [Math.abs(textRect.x) - textRect.width / 2, - textRect.height] + ")");
        else
          textTick.attr("transform", "rotate(-90) translate(" + [(textRect.x - offsetTick), - (textRect.y + textRect.height / 2)] + ")");
        break;
      case "VD" :
        if (this.isH)
          textTick.attr("transform", "rotate(90) translate(" + [textRect.width / 2 + offsetTick, textRect.height] + ")");
        else
          textTick.attr("transform", "rotate(90) translate("+ [(- textRect.x + offsetTick), - (textRect.y + textRect.height / 2)] + ")");
        break;
      case "45U" :
        if (this.isH)
          textTick.attr("transform", "rotate(-45) translate(" + [0, textRect.y - textRect.height / 2] + ")");
        else
          textTick.attr("transform", "rotate(-45) translate(" + [textRect.x, 0] + ")");
        break;
      case "45D" :
        if (this.isH)
          textTick.attr("transform", "rotate(45) translate(" + [0, Math.abs(textRect.y)] + ")");
        else
          textTick.attr("transform", "rotate(45) translate(" + [Math.abs(textRect.x), 0] + ")");
        break;
      default:
        break;
    }
  }
}

ZtBarChart.prototype._DrawShadowsGroup = function () {
  if (this.is3D)
    return;
  if (Empty(this.svg.select("#" + this.chartId + "shadows").node()))
    this.renderer.append("g").attr("id", this.chartId + "shadows")
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");
}

ZtBarChart.prototype._DrawShadows = function () {
  if (this.is3D)
    return;
  var sX = parseFloat(this.defSettings.bars.shadow.x),
  sY = parseFloat(this.defSettings.bars.shadow.y);
  if ((Empty(sX) || isNaN(sX)) && (Empty(sY) || isNaN(sY)))
    return;
  var color = Empty(this.defSettings.bars.shadow.color) ? "#A3A3A3" : this.defSettings.bars.shadow.color,
  group = this.svg.select("#" + this.chartId + "shadows");
  for (var i = 0; i < this.items.length; i++) {
    var item = this.items[i];
    this._DrawItemShadow(group, item, sX, sY, color);
  }
}

ZtBarChart.prototype._DrawItemShadow = function (group, item, sX, sY, color) {
  group.append("rect")
    .attr("x", function () {
      if (Empty(sY) || isNaN(sY))
        return getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm);
      return getDomNodeLeft(item.itm);
    })
    .attr("y", function () {
      if (Empty(sX) || isNaN(sX))
        return getDomNodeTop(item.itm) + getDomNodeHeight(item.itm);
      return getDomNodeTop(item.itm) + sY;
    })
    .attr("width", function () {
      if (Empty(sY) || isNaN(sY))
        return Math.abs(sX);
      return getDomNodeWidth(item.itm) + Math.abs(sX);
    })
    .attr("height", function () {
      if (Empty(sX) || isNaN(sX))
        return Math.abs(sY);
      return getDomNodeHeight(item.itm);
    })
    .style("fill", color)
    .style("shape-rendering", "crispEdges");
}

ZtBarChart.prototype._GetDrawParamObject = function (margins, seriesOffset, barWidth) {
  var barW = barWidth;
  if (this.defSettings.bars.maxWidth > 0)
    barW = Math.min(this.defSettings.bars.maxWidth, barWidth);
  return  { barWidth : barW,
            margins : margins,
            seriesOffset : seriesOffset,
            bandOffset : barWidth
          }
}

ZtBarChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this.RemoveAllPatterns();
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

  this._DrawPatterns();
  d3.select("#" + this.chartId + "shadows").selectAll("*").remove();
  d3.select("#" + this.chartId + "valueLabels").remove();
  if (this.is3D) {
    d3.select("#" + this.chartId + this.type + "_3Dpath1").selectAll("*").remove();
    d3.select("#" + this.chartId + this.type + "_3Dpath2").selectAll("*").remove();
  }

  if (isNaN(margins) || Empty(margins))
    margins = 0;

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
        if (this.isH)
          d3.select(item.itm).attr("width", 0);
        else {
          d3.select(item.itm).attr("y", parseFloat(d3.select(item.itm).attr("y")) + parseFloat(d3.select(item.itm).attr("height")));
          d3.select(item.itm).attr("height", 0);
        }
      }
      else {
        record = this.dataSet[dataIndex];
        cobj = this._GetDrawParamObject(margins, item.idx * scaleS.bandwidth(), scaleS.bandwidth());
        cobj.dbarIndex = item.sidx;
        cobj.scaleY = this.scaleY[item.valueField];
        yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);
        item.value = record[yIndex];
        if (this.isH) {
          d3.select(item.itm).attr("x", this._GetBarX(record, item.sidx, this.xIndex, yIndex, cobj));
          d3.select(item.itm).attr("width", this._GetBarWidth(record, yIndex, cobj));
        }
        else {
          d3.select(item.itm).attr("y", this._GetBarY(record, item.sidx, this.xIndex, yIndex, cobj));
          d3.select(item.itm).attr("height", this._GetBarHeight(record, yIndex, cobj));
        }

        if (this.is3D && !drawPath[item.valueField]) {
          this._Draw3DElementPath1(this.svg.select("#" + this.chartId + this.type + "_3Dpath1"), this.dataSet, item.idx, this.xIndex, yIndex, cobj);
          this._Draw3DElementPath2(this.svg.select("#" + this.chartId + this.type + "_3Dpath2"), this.dataSet, item.idx, this.xIndex, yIndex, cobj);
          drawPath[item.valueField] = true;
        }
      }

      if (item.value < 0 && this.hasNegativeValues)
        this.ApplyPatternOnItem(item, "negativeValuePattern");
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

ZtBarChart.prototype._SetValueAxisPositions = function () {
  if (this.isH)
    this._SetHorizontalValueAxisPositions();
  else
    StdChart.prototype._SetValueAxisPositions.call(this);
}

ZtBarChart.prototype._SetHorizontalValueAxisPositions = function () {
  if (!this.scaleY)
    return;
  var scs = Object.keys(this.scaleY),
  progrY = this._GetValueAxisYPosition(),
  mheight = 0,
  maxis,
  offset = 10,
  sID;
  for (var i = 0; i < scs.length; i++) {
    sID = replaceSpecialCharsForID(scs[i]);
    maxis = d3.select("#" + this.chartId + "valueAxisGroup_" + sID).node();
    if (maxis) {
      mheight = getDomNodeHeight(maxis) + offset;
      if (i > 0)
        d3.select(maxis).attr("transform", "translate(" + [this._GetValueAxisXPosition(), progrY] + ")");
      progrY = progrY - mheight;
    }
  }
}

ZtBarChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  items = this._GetItems(),
  item;
  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var enableZero = this.defSettings.valueLabel.type != "value" || (this.defSettings.valueLabel.type == "value" && this.defSettings.valueLabel.showZero),
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
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

ZtBarChart.prototype._GetBarWidthFromDomainEvaluation = function () {
  if (!Empty(this.bandWidth))
    return this.bandWidth;
  var bandWidth = 0,
  minS = d3.min(this.scaleX.domain()),
  maxS = d3.max(this.scaleX.domain());
  if (this.domainIsTime && this._ZtChart.StdChart.tickTime) {
    var def = this._ZtChart.StdChart.tickTime.default,
    d3Time = getD3TimeObject(def.unit),
    dti = d3Time.offset(this.scaleX.domain()[0], /*def.step*/ 1), // divido per l'unita' tra i dati (default) unitaria
    tmpw = this.scaleX(dti);
    this.scaleX.domain([minS, this.scaleX.invert(this.scaleX(maxS) + tmpw + 5)]);
    tmpw = this.scaleX(dti);
    bandWidth = tmpw;
  }
  else if (this.domainIsNumber) {
    var next = minS + 1; // la scala numerica e' sempre unitaria - wip
    bandWidth = this.scaleX(next);
    this.scaleX.domain([minS, this.scaleX.invert(this.scaleX(maxS) + bandWidth + 5)]);
    bandWidth = this.scaleX(next);
  }
  else
    bandWidth = this.scaleX.bandwidth();
  bandWidth = bandWidth <= 1 ? 1 : bandWidth;
  this.bandWidth = bandWidth;
  return this.bandWidth;
}
