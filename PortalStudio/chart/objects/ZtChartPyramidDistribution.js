function ZtPyramidDistributionChart() {
  ZtBarChart.apply(this, ["PYRAMID", 1, -1]);
  this.legendHexCode = "e90e";
  this.multiSVG = true;
}
ZtPyramidDistributionChart.prototype = Object.create(ZtBarChart.prototype);
ZtPyramidDistributionChart.prototype.constructor = ZtPyramidDistributionChart;

ZtPyramidDistributionChart.prototype._SetChartSettingsJSON = function () {
  ZtBarChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.valueLeftAxis = this.chartConfig.graphSettings.valueAxis;
  this.defSettings.valueLeftAxis.valueLeftFont = this.chartConfig.graphSettings.valueAxis.valueFont;
  this.defSettings.valueLeftAxis.valueLeftGrid = this.chartConfig.graphSettings.valueAxis.valueGrid;
  this.defSettings.valueLeftAxis.valueLeftLine = this.chartConfig.graphSettings.valueAxis.valueLine;
}

ZtPyramidDistributionChart.prototype._DrawChartPlot = function () {
  ZtWaterfallChart.prototype._DrawChartPlot.call(this);
}

ZtPyramidDistributionChart.prototype._DrawChartPlotElements = function () {
  ZtWaterfallChart.prototype._DrawChartPlotElements.call(this);
}

ZtPyramidDistributionChart.prototype._GetValueAxisPosition = function () {
  return "bottom";
}

ZtPyramidDistributionChart.prototype._GetValueAxisYPosition = function () {
  return this.margin.top + this.chartHeight + 3;
}

ZtPyramidDistributionChart.prototype._DrawValueAxisGrid = function () {
  this._DrawLRValueAxisGrid("value");
  this._DrawLRValueAxisGrid("valueLeft");
}

ZtPyramidDistributionChart.prototype._DrawLRValueAxisGrid = function (vatype) {
  var ticksArray = this.svg.select("#" + this.chartId + vatype + "AxisGroup").selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;
  var pos = [],
  xR = this.margin.left,
  yR = this.margin.top,
  h = this.chartHeight,
  grid,
  elemType = "line",
  _this = this;

  if (Empty(this.svg.select("#" + this.chartId + vatype + "AxisGridline").node()))
    grid = this.renderer.append("g").attr("id", this.chartId + vatype + "AxisGridline");

  if (this.defSettings.valueAxis.valueGrid.line) {
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      if (tick.transform.baseVal.length > 0 || tick.transform.baseVal.numberOfItems > 0)
        pos.push(tick.transform.baseVal.getItem(0).matrix.e);
    }

    grid.selectAll("." + vatype + "Gridline")
      .data(pos)
      .enter()
      .append(elemType)
        .attr("class", vatype + "Gridline TRANSP")
        .attr("id", function (d, i) {
          return _this.chartId + vatype + "GLine_" + i;
        })
        .attr("x1", function(d) {
          return xR + d;
        })
        .attr("y1", yR)
        .attr("x2", function(d) {
          return xR + d;
        })
        .attr("y2", yR + h);
  }
}

ZtPyramidDistributionChart.prototype._SetHorizontalValueScaleParameters = function (scaleKey, scaleY, min, max) {
  var mw = this.chartWidth,
  mw2 = this.chartWidth / 2,
  start = 0;
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

  if (min != 0)
    min = 0;

  if (scaleY.__isLeft)
    scaleY.domain([max, min]).range([start, mw2]);
  else
    scaleY.domain([min, max]).range([mw2, mw]);
  scaleY.__noDraw = false;
}

ZtPyramidDistributionChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = -1,
  yIndex2 = -1,
  group,
  oldChartId = this.chartId,
  mvalues = [],
  margins = this.defSettings.bars.margins,
  scaleS = d3.scaleBand(),
  dList = this._GetDrawingList(),
  count = 0,
  cobj,
  _this = this,
  pidx = -1,
  orgScaleY = this.scaleY,
  cList = this._GetOppositeDrawingList(),
  oldMargins = { top : this.margin.top,
                 bottom : this.margin.bottom,
                 left : this.margin.left,
                 right : this.margin.right
               },
  oldCM = { width : this.chartWidth, height : this.chartHeight };

  if (isNaN(margins) || Empty(margins))
    margins = 0;

  this.MapDrawAxis(); // set this.scaleYref

  for (var i = 0; i < dList.length; i = i + 2) {
    yIndex = this.propertyName.indexOf(dList[i]);
    yIndex2 = this.propertyName.indexOf(dList[i + 1]);

    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    this.scaleY[dList[i]].__isLeft = true;
    if (yIndex2 > 0)
      this.scaleY[dList[i + 1]] = orgScaleY[dList[i + 1]];

    pidx = (i > 0) ? i / 2 : i;
    this.chartId = oldChartId + count + "_";
    if (yIndex2 > 0) {
      mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], rec[yIndex], rec[yIndex2]] });
      //if (this._ZtChart.StdChart.type != "MULTICURS" || !this.multiDimKeepSameScale)
       // this.allValues = getValues(["m" + yIndex, "m" + yIndex2], ["cat", "m" + yIndex, "m" + yIndex2], mvalues);
    }
    else {
      mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], rec[yIndex]] });
     // if (this._ZtChart.StdChart.type != "MULTICURS" || !this.multiDimKeepSameScale)
       // this.allValues = mvalues.map( function(rec) { return rec[1]; });
    }
   // this.allValues = this.allValues.map( function(rec) { return Math.abs(rec); });

    if (this._ZtChart.StdChart.type != "MULTICURS" || !this.multiDimKeepSameScale)
      this.scaleX.domain(mvalues.map(function(rec) { return rec[0]; }));
    else
      this.scaleX.domain(this.categoryList);
    var td = this.scaleX.domain().filter( function (cat) { return cList.indexOf(cat) >= 0; });
    this.scaleX.domain(td);
    this._DrawMultiSVGPlot(this.chartId, parentGroup, positions[pidx].x, positions[pidx].y, positions[pidx].width, positions[pidx].height);

    group = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_elementGroup")
      .attr("transform","translate(" + [this.margin.left, this.margin.top] + ")");
    scaleS.domain([this.valueFields[i]]).range([0, this.scaleX.bandwidth()]);
    cobj = this._GetDrawParamObject(margins, 0, scaleS.bandwidth());

    cobj.scaleY = this.scaleY[dList[i]];
    cobj.scaleY.__noDraw = false;
    cobj.transform = [this.margin.left + positions[pidx].x, this.margin.top + positions[pidx].y];

    this.DrawBar(group, mvalues, i, 0, 1, cobj);
    if (yIndex2 > 0) {
      cobj.scaleY = this.scaleY[dList[i + 1]];
      cobj.scaleY.__noDraw = false;
      this.DrawBar(group, mvalues, i + 1, 0, 2, cobj);
    }
    count ++ ;
  }
  this.scaleY = orgScaleY;
  this.chartId = oldChartId;
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
  this.margin = oldMargins;
  this.chartHeight = oldCM.height;
  this.chartWidth = oldCM.width;
}

ZtPyramidDistributionChart.prototype._GetBarX = function (data, dataIndex, xIndex, yIndex, cobj) {
  var x = 0,
  min = this.defSettings.valueAxis.minValue,
  max = this.defSettings.valueAxis.maxValue,
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
  
  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;
  if ((isNaN(max) || max === undefined || Empty(max)) && max !== 0)
    max = null;

  if (cobj.scaleY.__isLeft) {
    if (!Empty(max) && max > 0)
      x = cobj.scaleY(Math.max(max, Math.abs(data[yIndex])));
    else
      x = cobj.scaleY(Math.max(sMax, Math.abs(data[yIndex])));
  }
  else {
    if (!Empty(min) && min >= 0)
      x = cobj.scaleY(min);
    else
      x = cobj.scaleY(0);
  }
  return x;
}

ZtPyramidDistributionChart.prototype._GetBarWidth = function (data, yIndex, cobj) {
  if (data[yIndex] < 0 && !this.hasNegativeValues)
    this.hasNegativeValues = true;
  var w = 0,
  min = this.defSettings.valueAxis.minValue,
  max = this.defSettings.valueAxis.maxValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain()),
  mvalue = Math.abs(data[yIndex]);
  
  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;
  if ((isNaN(max) || max === undefined || Empty(max)) && max !== 0)
    max = null;

  if (!Empty(min)) {
    if (min < mvalue && min >= 0) {
      if (!Empty(max)) {
        if (max > 0 && max <= mvalue)
          w = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
        else if (max > 0 && max > mvalue)
          w = Math.abs(cobj.scaleY(mvalue) - cobj.scaleY(min));
        else
          w = 0;
      }
      else{
        w = Math.abs(cobj.scaleY(mvalue) - cobj.scaleY(min));
      }
    }
    else if (min < 0) {
      if (!Empty(max)) {
        if (max > 0 && max <= mvalue)
          w = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
        else if (max > 0 && max > mvalue)
          w = Math.abs(cobj.scaleY(mvalue) - cobj.scaleY(sMin));
        else
          w = 0;
      }
      else{
        w = Math.abs(cobj.scaleY(mvalue) - cobj.scaleY(sMin));
      }
    }
    else
      w = 0;
  }
  else {
    if (!Empty(max)) {
      if (max >  0 && max <= mvalue)
        w = Math.abs(cobj.scaleY(max) - cobj.scaleY(sMin));
      else if (max > 0 && max > mvalue)
        w = Math.abs(cobj.scaleY(mvalue) - cobj.scaleY(sMin));
      else
        w = 0;
    }
    else{
      w = Math.abs(cobj.scaleY(mvalue) - cobj.scaleY(sMin));
    }
  }
  return w;
}

ZtPyramidDistributionChart.prototype._SetAxisColor = function () {
  var oldChartId = this.chartId,
  dList = this._GetDrawingList(),
  orgScaleY = this.scaleY,
  count = 0,
  scs;
  for (var i = 0; i < dList.length; i = i + 2) {
    var yIndex2 = this.propertyName.indexOf(dList[i + 1]);

    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    if (yIndex2 > 0)
      this.scaleY[dList[i + 1]] = orgScaleY[dList[i + 1]];

    this.chartId = oldChartId + count + "_";
    scs = Object.keys(this.scaleY);
    for (var j = 0; j < scs.length; j++) {
      this.SetAxisColor("value", "y2", 3, false, replaceSpecialCharsForID("_" + scs[j]), scs[j]);
      if (j % 2 == 1)
        this._RemoveFirstTickText("value", replaceSpecialCharsForID("_" + scs[j]));
    }
    this.SetAxisColor("domain", "x2", -3);
    count ++;
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtPyramidDistributionChart.prototype._SetAxisGridColor = function () {
  var oldChartId = this.chartId,
  dList = this._GetDrawingList(),
  orgScaleY = this.scaleY,
  cid = 0;
  for (var i = 0; i < dList.length; i = i + 2) {
    var yIndex2 = this.propertyName.indexOf(dList[i + 1]);

    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    if (yIndex2 > 0)
      this.scaleY[dList[i + 1]] = orgScaleY[dList[i + 1]];

    this.chartId = oldChartId + cid + "_";
    StdChart.prototype._SetAxisGridColor.call(this);
    cid ++;
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtPyramidDistributionChart.prototype._SetAxisFont = function () {
  var oldChartId = this.chartId,
  dList = this._GetDrawingList(),
  orgScaleY = this.scaleY,
  count = 0,
  scs;
  for (var i = 0; i < dList.length; i = i + 2) {
    var yIndex2 = this.propertyName.indexOf(dList[i + 1]);

    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    if (yIndex2 > 0)
      this.scaleY[dList[i + 1]] = orgScaleY[dList[i + 1]];

    this.chartId = oldChartId + count + "_";
    scs = Object.keys(this.scaleY);
    for (var j = 0; j < scs.length; j++)
      this.SetAxisFont("value", replaceSpecialCharsForID("_" + scs[j]), scs[j]);

    this.SetAxisFont("domain");
    this._SetAxisLabelOrientation("domain", this.defSettings.domainAxis.labelType);
    count ++;
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtPyramidDistributionChart.prototype._SetAxisLabelFont = function () {
  var oldChartId = this.chartId;
  for(var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    this.SetAxisLabelFont("value");
    this.SetAxisLabelFont("domain");
  }
  this.chartId = oldChartId;
}

ZtPyramidDistributionChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  return ZtPieChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
}

ZtPyramidDistributionChart.prototype._GetOtherChartMarginsObject = function (chartId, onlySVG, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec/*, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  var myM = {};
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
  var appliedfont;
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
        var format = getTimeTickFormat(localeLangFormat, settings.time.customFormat);
        if (Object.prototype.toString.call(categoryList[0]) === '[object Date]') {
          var myTa = [];
          for (var k = 0; k < categoryList.length; k++)
            myTa.push(format(categoryList[k]));
          myM.text = getMaxWordLength(myTa);
        }
        else
          myM.text = format(this.strToDateTime(getMaxWordLengthString(categoryList), datetimePict));
      }
      else
        myM.text = "Settembre";
    }
    else if (domainIsNumber)
      myM.text = getMaxWordLength(categoryList, domprec);
    else
      myM.text = getMaxWordLengthString(categoryList);

    if(settings.domainAxis.labelType == 'H')
      myM.textorientation = 0;
    else
      myM.textorientation = 90;
    myM.type = "domainAxis";
    ret.left.push(myM);
  }

  //ticks - domainAxis
  if (settings.domainAxis.show) {
    appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = ""; //ipotesi
    myM.addH = 8; //TICK HEIGHT 6
    myM.addW = 8;
    myM.offset = 5;
    myM.textorientation = 0;
    ret.left.push(myM);
  }

  //valori
  if (settings.valueAxis.show) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = getMaxWordLength(allValues, valprec);
    myM.textorientation = 90;
    if (Empty(settings.axisLabel.yLabel))
      myM.offset = 5;
    ret.bottom.push(myM);
  }

  //ticks
  if (settings.valueAxis.show) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = ""; //ipotesi
    myM.addH = 8; //TICK HEIGHT
    myM.addW = 8;
    myM.textorientation = 90;
    ret.bottom.push(myM);
  }

  if (!Empty(this.appliedKey)) {
    myM = setMarginObject(this.appliedKey, settings.chartTitle.textFont, settings.chartTitle.useGlobalFont, settings.globalFont);
    myM.offset = 3;
    if (myM != 0)
      ret[settings.chartTitle.position].push(myM);
  }

  return ret;
}

ZtPyramidDistributionChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG) {
  ZtWaterfallChart.prototype._DrawMultiSVGPlot.call(this, id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG);
}

ZtPyramidDistributionChart.prototype._AnimateChartElements = function () {
  var div = this._GetAnimatedDivisor();
  for (var i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;
    var value = d3.select(elem).attr("width");
    if (this.items[i].idx % 2 == 0) { // left
      var value2 = d3.select(elem).attr("x");
      d3.select(elem)
        .attr("width", 0)
        .attr("x", parseFloat(value2) + parseFloat(value))
        .transition()
          .delay((this.items[i].idx / 2) * this.defSettings.animation.duration/div)
          .duration(this.defSettings.animation.duration/div)
          .ease(d3.easeLinear)
          .attr("width", value)
          .attr("x", value2);
    }
    else {
      d3.select(elem)
        .attr("width", 0)
        .transition()
          .delay(Math.floor(this.items[i].idx / 2) * this.defSettings.animation.duration/div)
          .duration(this.defSettings.animation.duration/div)
          .ease(d3.easeLinear)
          .attr("width", value);
    }
  }
}

ZtPyramidDistributionChart.prototype._GetDivisor = function () {
  return Math.round(this.valueFields.length / 2);
}

ZtPyramidDistributionChart.prototype._RemoveFirstTickText = function (type, axId) {
  var axisID,
  ticks,
  axisProp = type + "Axis";
  axId = axId || "";

  if (!this.defSettings[axisProp].show)
    return;

  axisID = this.chartId + type + "AxisGroup" + axId;
  ticks = d3.select("#" + axisID).selectAll(".tick")._groups[0];
  d3.select(ticks[0]).select("text").node().textContent = "";
  d3.select(ticks[0]).select("text").node().innerHTML = "";
}

ZtPyramidDistributionChart.prototype._ApplyPatterns = function () {
  if (this.hasNegativeValues) {
    this.DrawNegativePattern();
    var items = this._GetItems().filter(function (item) { return item.value < 0; });
    for (var i = 0; i < items.length; i++)
      this.ApplyPatternOnItem(items[i], "negativeValuePattern");
  }
}

ZtPyramidDistributionChart.prototype._GetValueLabelX = function (pos, item, text, font) {
  return ZtTreeMapBarChart.prototype._GetValueLabelX.call(this, pos, item, text, font);
}

ZtPyramidDistributionChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  return ZtTreeMapBarChart.prototype._GetValueLabelY.call(this, pos, item, text, font);
}

ZtPyramidDistributionChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  items = this._GetItems(),
  item;
  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
    pos2 = (item.idx % 2 == 0) ? "oleft" : "oright",
    pos3 = (item.idx % 2 == 0) ? "ileft" : "iright",
    pos = this.defSettings.valueLabel.position == "iborder" ? pos3 : (this.defSettings.valueLabel.position == "out" ? pos2 : this.defSettings.valueLabel.position),
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    label = group.append("text")
              .attr("x", this._GetValueLabelX(pos, item, text, font))
              .attr("y", this._GetValueLabelY(pos, item, text, font))
              .style("text-anchor", function () {
                switch (pos) {
                  case "in":
                    return "middle";
                    break;
                  case "oleft":
                  case "iright":
                    return "end";
                    break;
                  case "oright":
                  case "ileft":
                    return "start";
                    break;
                }
              })
              .text(text);
    setFont(label, font, this);
  }
}

ZtPyramidDistributionChart.prototype._GetBarWidthFromDomainEvaluation = function () { }
