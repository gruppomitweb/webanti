function ZtParetoChart() {
  ZtBarChart.apply(this, ["PARETO", -1, -1]);
  this.legendHexCode = "e900";
  this.multiSVG = true;
  this.percentString = "WWW%";
  this.nrDataset = [];
  this.applyCalculationAfter = true;
}
ZtParetoChart.prototype = Object.create(ZtBarChart.prototype);
ZtParetoChart.prototype.constructor = ZtParetoChart;
// questa tipologia di grafico non ammette valori negativi http://www.sifa-attuari.it/materiale/GFCorso_251012.pdf

ZtParetoChart.prototype._SetChartSettingsJSON = function () {
  ZtBarChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.line = this.chartConfig.graphSettings.line;
  this.defSettings.shape = this.chartConfig.graphSettings.shape;
  this.defSettings.shape.onlyHover = false;
  this.defSettings.shape.figureTypes = ["circle", "square", "triangle", "cross", "diamond", "star", "wye"];
  this.defSettings.percentAxis = this.chartConfig.graphSettings.percentAxis;

  if (this.defSettings.line.type.indexOf("curve") < 0) {  // compatibilita' versioni d3
    switch (this.defSettings.line.type) {
      case "linear":
        this.defSettings.line.type = "curveLinear";
        break;
      case "step-before":
        this.defSettings.line.type = "curveStepBefore";
        break;
      case "step-after":
        this.defSettings.line.type = "curveStepAfter";
        break;
      case "basis":
        this.defSettings.line.type = "curveBasis";
        break;
      case "bundle":
        this.defSettings.line.type = "curveBasis";
        break;
      case "cardinal":
        this.defSettings.line.type = "curveCardinal";
        break;
      case "monotone":
        this.defSettings.line.type = "curveMonotoneX";
        break;
    }
  }
}

ZtParetoChart.prototype._SetScales = function () {
  StdChart.prototype._SetScales.call(this);
  this.scalePerc = d3.scaleLinear();
}

ZtParetoChart.prototype._SetCalculationDataset = function (dataSet) {
  var pdata = getParetoDataset(dataSet);
  this.calcDataset = pdata.data;
  this.globalSum = pdata.sum == 0 ? 100 : pdata.sum;
}

ZtParetoChart.prototype._SetSupportDataset = function (dataSet) {
  this.supportDataset = getParetoLineDataset(dataSet);
  var _this = this;
  this.supportDatasetPerc = this.supportDataset.map( function(rec) { return [rec[0], rec[1] / _this.globalSum]; });
  if (this.defSettings.line.position == "inside")
    this.supportDataset = this.calcDataset.slice();
}

ZtParetoChart.prototype._DrawChartPlot = function () {
  ZtPieChart.prototype._DrawChartPlot.call(this);
}

ZtParetoChart.prototype._DrawChartPlotElements = function () {
  ZtPieChart.prototype._DrawChartPlotElements.call(this);
}

ZtParetoChart.prototype._GetPercentAxisPosition = function () {
  return "right";
}

ZtParetoChart.prototype._GetPercentAxisMinMax = function () {
  var min = this.rangeminmax.min,
  max;
  if (Empty(this.defSettings.percentAxis.maxValue))
    max = 1 + Math.abs(min);
  else
    max = parseFloat(this.defSettings.percentAxis.maxValue) / 100;
  this.rangeminmax.max = max;

  return { min: min, max: max };
}

ZtParetoChart.prototype._DrawAxisLabel = function () {
  ZtBarChart.prototype._DrawAxisLabel.call(this);
  var xInit, yInit;
  xInit = this.margin.top + (this.chartHeight / 2);
  yInit = this._GetPercentAxisXPosition();
  if (this.defSettings.percentAxis.show) {
    var appliedfont = appliedFont(this.defSettings, this.defSettings.percentAxis, this.defSettings.percentAxis.percentFont);
    var wlen = getOffsetWidth(this.percentString, appliedfont, this.chartId);
    yInit = this._GetPercentAxisXPosition() + wlen;
  }
  this.DrawAxisLabel("percent", this._GetPercentAxisPosition(), xInit, yInit, this.defSettings.axisLabel.percentLabel);
}

ZtParetoChart.prototype._SetPercentScaleParameters = function (min, max/*, scaleKey*/) {
  var mh = this.chartHeight;
  var start = 0;
  if (this.defSettings.valueLabel.show != "hide") {
    var txt = this.GetValueLabelMaxWord(this.dataSet);
    var lblFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont);
    var hlen = getOffsetHeight(txt, lblFont, this.chartId);
    if (this.defSettings.valueLabel.position == "bottom")
      mh = mh - hlen;
    if (this.defSettings.valueLabel.position == "top")
      start = start + hlen;
  }
  this.scalePerc.domain([max, min]).range([start, mh]);
  var evRange = this._RemapScalePercent(this.scalePerc, this.scaleYref, 10, false);
  if (!Empty(evRange)) {
    min = evRange.min;
    max = evRange.max;
  }

  return { min: min, max: max };
}

ZtParetoChart.prototype._GetPercentAxisXPosition = function () {
  return this.margin.left + this.chartWidth;
}

ZtParetoChart.prototype._GetPercentAxisYPosition = function () {
  return this.margin.top;
}

ZtParetoChart.prototype._DrawAxis = function () {
  StdChart.prototype._DrawAxis.call(this);
  var scs = Object.keys(this.scaleY),
  sckey;
  if (!d3.select("#" + this.chartId + "percentAxisGroup").node()) {
    this.svg.append("g")
      .attr("id", this.chartId + "percentAxisGroup");
  }
  var axisContainer = d3.select("#" + this.chartId + "percentAxisGroup");
  for (var i = 0; i < scs.length; i++) {
    sckey = scs[i];
    this.DrawPercentAxis(axisContainer, sckey);
  }
}

ZtParetoChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = -1,
  group,
  lgroup,
  oldChartId = this.chartId,
  mvalues = [],
  margins = this.defSettings.bars.margins,
  scaleS = d3.scaleBand(),
  dSeries = this._GetDrawingList(),
  cList = this._GetOppositeDrawingList(),
  cobj,
  _this = this,
  mleft,
  orgScaleY = this.scaleY,
  fvalues,
  oldMargins = { top : this.margin.top,
                 bottom : this.margin.bottom,
                 left : this.margin.left,
                 right : this.margin.right
               },
  oldCM = { width : this.chartWidth, height : this.chartHeight },
  indexes = [],
  howmany;

  if (isNaN(margins) || Empty(margins))
    margins = 0;

  this.MapDrawAxis(); // set this.scaleYref

  if (this.scaleYref) {
    yIndex =  this.propertyName.indexOf(this.scaleYref.__refAxis);
    mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], rec[yIndex]] });
    this._SetSupportDataset(mvalues);
    mvalues = this.supportDataset.map( function(rec) { return rec[1]; });
    var min = this.scaleYref.domain()[1];
    this.scaleYref.domain([d3.max(mvalues),min])
  }

  var orgCatList = this.orgCategoryList.slice(),
  catList = this.categoryList.slice(),
  drawingList = this.drawingCategories.slice();

  for (var i = 0; i < positions.length; i++) {
    this.scaleY = {};
    this.scaleY[dSeries[i]] = orgScaleY[dSeries[i]];
    yIndex = this.propertyName.indexOf(dSeries[i]);
    this.chartId = oldChartId + i + "_";
    mvalues = this.dataSet.map(function(rec) {
      return [rec[_this.xIndex], rec[yIndex], rec[_this.xLabelIndex]]; 
    });
    fvalues = mvalues.map( function (rec) { return rec[1]; } );
    this.allNegative = false;
    if (d3.min(fvalues) < 0) {
      howmany = fvalues.filter( function (val) { return val < 0; } );
      if (howmany.length != this.dataSet.length) {
        var toremove = [];
        for (var j = 0; j < fvalues.length; j++) {
          if (fvalues[j] < 0)
            toremove.push(j);
        }

        for (j = toremove.length - 1; j >= 0; j--) {
          if (indexes.indexOf(toremove[j]) < 0) {
            indexes.push(toremove[j]);
            this.nrDataset.push(this.dataSet[toremove[j]].slice());
          }
          mvalues.splice(toremove[j], 1);
        }
      }
      else {
        this.allNegative = true;
        mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], Math.abs(rec[yIndex])] });
      }
    }
    this._SetCalculationDataset(mvalues);
    this.rangeminmax.min = d3.min(this.calcDataset.map( function(rec) { return rec[1]; })) / this.globalSum;
    if (this.rangeminmax.min >= 0)
      this.rangeminmax.min = 0;
    this._SetSupportDataset(mvalues);

    if (this._ZtChart.StdChart.type != "MULTICURS" || !this.multiDimKeepSameScale) {
      this.allValues = this.supportDataset.map( function(rec) { return rec[1]; }).concat(mvalues.map( function(rec) { return rec[1]; }));
      this[dSeries[i] + "_values"] = this.allValues.slice();
      //check empty keyfield
      this.orgCategoryList = this.calcDataset.map(function(rec) { return rec[0]; });
      this.categoryList = this.calcDataset.map(function(rec) { return rec[2]; });
      this.drawingCategories = this.orgCategoryList.slice();
      this.scaleX.domain(this.orgCategoryList);
    }
    else
      this._MapSameScale();

    var td = this.scaleX.domain().filter( function (cat) { return cList.indexOf(cat) >= 0; });
    this.scaleX.domain(td);

    this._DrawMultiSVGPlot(this.chartId, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_elementGroup")
      .attr("transform","translate(" + [this.margin.left, this.margin.top] + ")");
    scaleS.domain([dSeries[i]]).range([0, this.scaleX.bandwidth()]);
    cobj = this._GetDrawParamObject(margins, 0, scaleS.bandwidth());
    cobj.scaleY = this.scaleY[dSeries[i]];
    cobj.transform = [this.margin.left + positions[i].x, this.margin.top + positions[i].y];

    mleft = this.margin.left;
    if (this.defSettings.line.position == "topRight")
      mleft = mleft + (cobj.barWidth / 2);

    lgroup = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_elementGroupLine")
      .attr("transform","translate(" + [mleft, this.margin.top] + ")");
    this.DrawBar(group, this.calcDataset, i, 0, 1, cobj);
    this.DrawLine(lgroup, this.supportDatasetPerc, i, 0, 1, {scaleY: this.scalePerc});
    this.DrawShapes(lgroup, this.calcDataset, i, 0, 1, {valueField : dSeries[i]});
    this._DrawPercentageReference(lgroup, i, this.items[this.items.length - 1]);

    if (this.allNegative) {
      this._DrawPattern(oldChartId);
      var itms = this.items.filter( function (item) {  return (item.itemType == "bar" && item.valueField == dSeries[i]); } )
      itms = itms.map( function (item) { item.value = -1 * item.value; return item; } )
    }
  }
  this.scaleY = orgScaleY;
  this.chartId = oldChartId;
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
  this.margin = oldMargins;
  this.chartHeight = oldCM.height;
  this.chartWidth = oldCM.width;
  this.orgCategoryList = orgCatList;
  this.categoryList = catList;
  this.drawingCategories = drawingList;
}

ZtParetoChart.prototype._GetShapeCX = function (d, dataIndex, xIndex, yIndex, recIndex) {
  return ZtLinesChart.prototype._GetShapeCX.call(this, d, dataIndex, xIndex, yIndex, recIndex);
}

ZtParetoChart.prototype._GetShapeCY = function (d, dataIndex, xIndex, yIndex, recIndex) {
  return this.scalePerc(this.supportDatasetPerc[recIndex][yIndex]);
}

ZtParetoChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
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
      var stroke = 1;
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
      if (this.items[i].itemType == "bar") {
        styleObj.stroke = "none";
        styleObj.fill = stroke;
        styleObj.stroke9width = (this.defSettings.bars.barsLine.stroke || 0) + "px";
      }
      else {
        if (!Empty(this.defSettings.line.color)) {
          var colors = this.defSettings.line.color.split(";");
          styleObj.stroke = colors[idx] || stroke;
        }
      }
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }

  for (i = 0; i < this.shapes.length; i++) {
    idx = this.valueFields.indexOf(this.shapes[i].valueField);
    if (idx >= 0) {
      this.shapes[i].idx = idx;
      this.shapes[i].sidx = this.orgCategoryList.indexOf(this.shapes[i].category);
      this.shapes[i].color = this.colorSet[idx];
      styleObj = {};
      styleObj.fill = this.GetChartBackground().color;
      styleObj.stroke9width = (this.defSettings.shape.stroke || 1) + "px";
      if (!this.defSettings.shape.onlyHover) {
        styleObj.stroke = this.shapes[i].color.color;
        if (this.defSettings.shape.colorSeries[idx])
          styleObj.stroke = this.defSettings.shape.colorSeries[idx].color;
        if (this.defSettings.shape.customFill && !Empty(this.defSettings.shape.fillColorSeries)) {
          if (this.defSettings.shape.fillColorSeries[idx])
            styleObj.fill = this.defSettings.shape.fillColorSeries[idx].color;
          else {
            if (this.defSettings.shape.fill)
              styleObj.fill = this.shapes[i].color.color;
            else
              styleObj.fill = "url(#" + this.chartId + "rendererGradient)";
          }
        }
        else {
          if (this.defSettings.shape.fill)
            styleObj.fill = this.shapes[i].color.color;
          else
            styleObj.fill = "transparent";
        }
      }
      else {
        styleObj.stroke = "transparent";
        styleObj.fill = "transparent";
      }
      this.shapes[i].colorApplied = this.shapes[i].color.color;
      d3.select(this.shapes[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.shapes[i].itm).attr("style")));
    }
  }
}

ZtParetoChart.prototype._SetAxisColor = function () {
  var oldChartId = this.chartId,
  orgScaleY = this.scaleY,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisColor.call(this);
    this.SetAxisColor("percent", "x2", 3, null, null, dList[i]);
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtParetoChart.prototype._SetAxisGridColor = function () {
  var oldChartId = this.chartId,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisGridColor.call(this);
  }
  this.chartId = oldChartId;
}

ZtParetoChart.prototype._SetAxisFont = function () {
  var oldChartId = this.chartId,
  orgScaleY = this.scaleY,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisFont.call(this);
    this.SetAxisFont("percent", replaceSpecialCharsForID("_" + dList[i]), dList[i]);
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtParetoChart.prototype._SetAxisLabelFont = function () {
  var oldChartId = this.chartId,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisLabelFont.call(this);
    this.SetAxisLabelFont("percent");
  }
  this.chartId = oldChartId;
}

ZtParetoChart.prototype._SetAxisLabelsPositions = function () { }

ZtParetoChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  var marginsObj = ZtPieChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
  if (d3.min(this.allValues) < 0) {
    var addMargin = this._GetNotRepresentedDataMarginsObject();
    marginsObj.bottom = marginsObj.bottom.concat(addMargin.bottom);
  }
  return marginsObj;
}

ZtParetoChart.prototype._GetOtherChartMarginsObject = function (chartId, onlySVG, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  if (onlySVG)
    return ret;

  var myM = {};
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
          myM.text = format(this.strToDateTime(getMaxWordLength(categoryList), datetimePict));
      }
      else
        myM.text = "Settembre";
    }
    else if (domainIsNumber)
      myM.text = getMaxWordLength(categoryList, domprec);
    else
      myM.text = getMaxWordLength(categoryList);

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
    myM.addH = 8; //TICK HEIGHT 6
    myM.addW = 8;
    myM.textorientation = 90;
    ret.bottom.push(myM);
  }

  //valori
  if (settings.valueAxis.show) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = getMaxWordLength(allValues, valprec);
    myM.textorientation = 0;
    if (Empty(settings.axisLabel.yLabel))
      myM.offset = 5;
    ret.left.push(myM);
  }

  var mfontsize = 0;
  //ticks - valueAxis
  if (settings.valueAxis.show) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = ""; //ipotesi
    myM.addH = 8; //TICK HEIGHT
    myM.addW = 8;
    myM.textorientation = 0;
    ret.left.push(myM);

    mfontsize = Math.max(mfontsize, myM.fontsize);
  }


  //valori - perc
  if (settings.percentAxis.show) {
    appliedfont = appliedFont(settings, settings.percentAxis, settings.percentAxis.percentFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = this.percentString;
    myM.textorientation = 0;
    if (Empty(settings.axisLabel.percentLabel)) {
      myM.offset = 5;
      ret.right.push(myM);
    }
    else {
      //ylabel
      ret.right.push(myM);
      myM = setMarginObject(settings.axisLabel.percentLabel, settings.axisLabel.axisFont, settings.axisLabel.useGlobalFont, settings.globalFont);
      if (myM != 0) {
        //myM.offset = 5;
        ret.right.push(myM);
      }
    }

    mfontsize = Math.max(mfontsize, myM.fontsize);
  }

  myM = {};
  myM.text = "";
  myM.offset = mfontsize/2;
  myM.textorientation = 0;
  ret.top.push(myM);

  //ticks - percentAxis
  if (settings.percentAxis.show) {
    appliedfont = appliedFont(settings, settings.percentAxis, settings.percentAxis.percentFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = ""; //ipotesi
    myM.addH = 8; //TICK HEIGHT
    myM.addW = 8;
    myM.textorientation = 0;
    ret.right.push(myM);
  }

  //range labels - no legenda, le visualizzo sull'asse
  if (!Empty(rangebandslabels) && (!chartLegends.range || (chartLegends.range && (chartLegends.range.position=="hide" || chartLegends.range.hide || chartLegends.range.tooLong)))) {
    myM = getGenericLabelConf(settings.globalFont);
    myM.text = getMaxWordLength(rangebandslabels);
    myM.offset = 10;
    myM.textorientation = 0;
    ret.right.push(myM);
  }

  if (!Empty(this.appliedKey)) {
    myM = setMarginObject(this.appliedKey, settings.chartTitle.textFont, settings.chartTitle.useGlobalFont, settings.globalFont);
    myM.offset = 3;
    if (myM != 0)
      ret[settings.chartTitle.position].push(myM);
  }

  return ret;
}

ZtParetoChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG) {
  ZtWaterfallChart.prototype._DrawMultiSVGPlot.call(this, id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG);
}

ZtParetoChart.prototype._AnimateChartElements = function () {
  var refs = [];
  if (!Empty(this.defSettings.percentAxis.percentageReference))
    refs = this.svg.selectAll(".axisRefLine")._groups[0];
  for (var i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;
    this._AnimateItem(this.items[i], null, this.defSettings.animation.duration);
    this._AnimateReferenceLine(refs, this.items[i].idx, this.defSettings.animation.duration);
  }
}

ZtParetoChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj);

  if (item.itemType == "bar") {
    var value = d3.select(elem).attr("height"),
    value2 = d3.select(elem).attr("y"),
    value3 = d3.select(elem).attr("x");
    d3.select(elem)
      .attr("height", defaultValues ? 0 : lastValueObj.height)
      .attr("y", defaultValues ? (parseFloat(value) + parseFloat(value2)) : lastValueObj.y)
      .attr("x", defaultValues ? parseFloat(value3) : lastValueObj.x)
      .transition()
        .delay(item.idx * duration / div)
        .duration(duration / div)
        .ease(d3.easeLinear)
        .attr("height", value)
        .attr("y", value2)
        .attr("x", value3);
  }
  else {
    var totLen = elem.getTotalLength();
    d3.select(elem)
      .attr("stroke-dasharray", totLen + " " + totLen)
      .attr("stroke-dashoffset", totLen)
      .transition()
        .delay(item.idx * duration / div)
        .duration(duration / div)
        .ease(d3.easeLinear)
        .attr("stroke-dashoffset", 0);
  }
}

ZtParetoChart.prototype._AnimateReferenceLine = function (refs, index, duration) {
  var div = this._GetAnimatedDivisor(),
  me,
  mi,
  val,
  val2,
  mattr;

  for (var j = 0; j < refs.length; j++) {
    me = d3.select(refs[j]);
    mi = parseInt(me.attr("data-index"));
    if (mi == index && Empty(me.attr("checked"))) {
      if (me.node().tagName.toLowerCase() == "circle") {
        val = parseFloat(me.attr("r"));
        me.attr("r", 0)
        .transition()
          .delay(index * duration / div)
          .duration(duration / div)
          .attr("r", val);
      }
      else {  // line
        val = parseFloat(me.attr("x1"));
        val2 = parseFloat(me.attr("x2"));
        mattr = "x1";
        if (val == val2) {  // e' verticale
          val = parseFloat(me.attr("y1"));
          val2 = parseFloat(me.attr("x2"));
          mattr = "y1";
        }
        me.attr(mattr, val2)
        .transition()
          .delay(index * duration / div)
          .duration(duration / div)
          .ease(d3.easeLinear)
          .attr(mattr, val);
      }
      me.attr("checked", "true");
    }
  }
}

ZtParetoChart.prototype._GetDivisor = function () {
  return ZtWaterfallChart.prototype._GetDivisor.call(this);
}

ZtParetoChart.prototype._MapSameScale = function () {
  var tmpCat = this.calcDataset.map(function(rec) { return rec[0]; });
  tmpCat = tmpCat.concat(this.categoryList.filter( function (cat) { return tmpCat.indexOf(cat) < 0; }));
  this.scaleX.domain(tmpCat);
}

ZtParetoChart.prototype._GetItems = function () {
  var ret = [];
  ret = this.items.filter(function (item) { return item.itemType == "bar"; });
  ret = ret.concat(this.shapes);
  return ret;
}

ZtParetoChart.prototype._ApplyMouseOver = function (item, itemObj) {
  mRefChart = this._ZtChart.StdChart;
  this.RemoveAllHovers();
  if (item) {
    if (item.tagName == "rect")
      ApplyBar(this, item, itemObj);
    else
      ApplyShape(this, item, itemObj);
  }

  function ApplyBar(_this, item) {
    ZtBarChart.prototype._ApplyMouseOver.call(_this, item, itemObj);
  }

  function ApplyShape(_this, item, itemObj) {
    var itemObject = itemObj || _this._GetItems()[d3.select(item).attr("item-index")],
    clone = _this._GetItemClone(item),
    refLinesGroup;
    d3.select(clone)
      .attr("item-type", "hover")
      .attr("d", d3.symbol()
        .size( function () { return 5 * Math.pow(_this.GetShapesRadius(), 2); })
        .type( function (/*d*/) {
            return d3["symbol" + _this.defSettings.shape.figure.charAt(0).toUpperCase() + _this.defSettings.shape.figure.slice(1)];
        })
      )
      .style("stroke-opacity", 1)
      .style("fill", "transparent")
      .style("stroke", itemObject.color.color)
      .style("stroke-width", 2 + "px")
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
    refLinesGroup = d3.select(item.parentNode).append("g")
                      .attr("class", "referenceLineGroup")
                      .attr("item-type", "hover");

    _this.DrawAxisReference("percent", _this._GetPercentAxisPosition(), refLinesGroup, null, itemObject.coordinates.x, itemObject.coordinates.y, itemObject.color.color);
    _this.DrawAxisReference("domain", _this._GetDomainAxisPosition(), refLinesGroup, null, itemObject.coordinates.x, itemObject.coordinates.y, itemObject.color.color);
  }
}

ZtParetoChart.prototype._GetRelatedItm = function (itemObject) {
  var ret = [],
  mitems = (itemObject.itemType == "bar") ? this.shapes : this.items,
  f = false;
  ret.push(itemObject);
  for (var i = 0; !f && i < mitems.length; i++) {
    if (this._CheckIdentityItem(itemObject, mitems[i]) && mitems[i].itemType != "line") {
      ret.push(mitems[i]);
      f = true;
    }
  }
  return ret;
}

ZtParetoChart.prototype._DrawPercentageReference = function (group, vIndex, item) {
  if (Empty(this.defSettings.percentAxis.percentageReference))
    return;

  var _this = this,
  line = group.append("line")
          .attr("class","axisRefLine")
          .attr("x1", 0)
          .attr("x2", this.chartWidth)
          .attr("y1", this.scalePerc(this.defSettings.percentAxis.percentageReference / 100) + 0.5) // stroke del tick
          .attr("y2", this.scalePerc(this.defSettings.percentAxis.percentageReference / 100) + 0.5) // stroke del tick
          .attr("data-index", vIndex)
          .style("stroke-linecap", "butt")
          .style("stroke-dasharray", "2,2")
          .style("stroke", "#212121")
          .style("shape-rendering", "crispEdges");

  var intersect = line_line_intersections(item.itm, line);
  for (var i = 0; i < intersect.length; i++) {
    var pt = intersect[i];
    group.append("circle")
      .attr("class","axisRefLine")
      .attr("cx", pt.x)
      .attr("cy", pt.y)
      .attr("r", 4)
      .attr("data-index", vIndex)
      .style("fill", "none")
      .style("stroke", "#212121");

    group.append("circle")
      .attr("class","axisRefLine")
      .attr("cx", pt.x)
      .attr("cy", pt.y)
      .attr("r", 2)
      .attr("data-index", vIndex)
      .style("fill", "#212121")
      .style("stroke", "none");

    group.append("line")
      .attr("class","axisRefLine")
      .attr("x1", pt.x)
      .attr("x2", pt.x)
      .attr("y1", pt.y)
      .attr("y2", _this.chartHeight)
      .attr("data-index", vIndex)
      .style("stroke-linecap", "butt")
      .style("stroke-dasharray", "2,2")
      .style("stroke", "#212121")
      .style("shape-rendering", "crispEdges");
  }
  
  if (intersect[0])
    line.attr("x1", intersect[0].x);

  function line_line_intersections(pathEl, line) {
    var pts = [],
    pathLength = pathEl.getTotalLength();

    var my = parseFloat(line.attr("y1")),
    line2 = {x1: line.attr('x1'), x2: line.attr('x2'),
             y1: line.attr('y1'), y2: line.attr('y2')};
    for (var i=0; i<pathLength; i++) {
      var pos1 = pathEl.getPointAtLength(i),
      pos2 = pathEl.getPointAtLength(i + 1),
      line1 = {x1: pos1.x, x2: pos2.x, y1: pos1.y, y2: pos2.y};
      if (btwn(my, pos1.y, pos2.y)) {
        var pt = line_line_intersect(line1, line2);
        if (!Empty(pt))
          pts.push(pt);
      }
    }
    return pts;
  }
}

ZtParetoChart.prototype._RemapScale = function(scaleY, scaleYref, tickUnit, remap) {
  if(remap == null || remap == undefined)
    remap = true;
  var minpos = 0;
  var maxpos = 1;
  var v;
  if(scaleY.domain()[0] > scaleY.domain()[1]) {
    minpos = 1;
    maxpos = 0;
  }
  var mmax = scaleY.domain()[maxpos];
  var mmin = scaleY.domain()[minpos];
  if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue)) {
    remap = false;
    if(scaleYref) {
      var min = parseFloat(this.defSettings.valueAxis.minValue);
      v = scaleYref(min);
      mmin = scaleY.invert(v);
    }
  }
  var maxValue;
  if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue))
    maxValue = parseFloat(this.defSettings.valueAxis.maxValue);
  else
    if (!Empty(this.defSettings.percentAxis.maxValue))
      maxValue = scaleYref.domain()[maxpos]*parseFloat(this.defSettings.percentAxis.maxValue) / 100;
  if (maxValue != undefined) {
    remap = false;
    if(scaleYref) {
      var max = maxValue;
      v = scaleYref(max);
      mmax = scaleY.invert(v);
    }
  }
  if(remap) mmin = Math.floor(mmin / tickUnit)*tickUnit;
  var d = [];
  d[minpos] = mmin;
  d[maxpos] = mmax;
  scaleY.domain(d);
  return { min: mmin, max: mmax };
}

ZtParetoChart.prototype._RemapScalePercent = function(scaleY, scaleYref, tickUnit, remap) {
  if(remap == null || remap == undefined)
    remap = true;
  var minpos = 0;
  var maxpos = 1;
  var v;
  if(scaleY.domain()[0] > scaleY.domain()[1]) {
    minpos = 1;
    maxpos = 0;
  }
  var mmax = scaleY.domain()[maxpos];
  var mmin = scaleY.domain()[minpos];
  if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue)) {
    remap = false;
    if(scaleYref) {
      var min = parseFloat(this.defSettings.valueAxis.minValue);
      v = scaleYref(min);
      mmin = scaleY.invert(v);
    }
  }
  var maxValue;
  if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue))
    maxValue = parseFloat(this.defSettings.valueAxis.maxValue);

  if (maxValue != undefined) {
    remap = false;
    if(scaleYref) {
      var max = maxValue;
      v = scaleYref(max);
      mmax = scaleY.invert(v);
    }
  }
  if(remap) mmin = Math.floor(mmin / tickUnit)*tickUnit;
  var d = [];
  d[minpos] = mmin;
  d[maxpos] = mmax;
  scaleY.domain(d);
  return { min: mmin, max: mmax };
}

ZtParetoChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  margins = this.defSettings.bars.margins,
  cobj,
  scaleS = d3.scaleBand(),
  dataIndex,
  yIndex,
  cList,
  dList = this._GetDrawingList(),
  item,
  mvalues,
  items,
  _this = this,
  oldChartId = this.chartId,
  position,
  xAxis,
  line,
  lgroup;

  if (isNaN(margins) || Empty(margins))
    margins = 0;

  for (var k = 0; k < dList.length; k++) {
    this.chartId = oldChartId + k + "_";
    lgroup = d3.select("#" + this.chartId + this.type + "_elementGroupLine");
    lgroup.selectAll(".axisRefLine").remove();
    yIndex = this.propertyName.indexOf(dList[k]);
    mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], rec[yIndex]] });
    this._SetCalculationDataset(mvalues);
    this.rangeminmax.min = d3.min(this.calcDataset.map( function(rec) { return rec[1]; })) / this.globalSum;
    if (this.rangeminmax.min >= 0)
      this.rangeminmax.min = 0;
    this._SetSupportDataset(mvalues);
    cList = getList(0, this.calcDataset);
    items = this.items.filter( function (it) { return it.idx == k; } );
    this.scaleX.domain(cList);

    position = this._GetDomainAxisPosition().charAt(0).toUpperCase() + this._GetDomainAxisPosition().slice(1);
    xAxis = d3["axis" + position](this.scaleX);
    d3.select("#" + this.chartId + "domainAxisGroup").call(xAxis);

    scaleS.domain([dList[i]]).range([0, this.scaleX.bandwidth()]);
    cobj = this._GetDrawParamObject(margins, 0, scaleS.bandwidth());

    for (var i = 0; i < items.length; i++) {
      item = items[i];
      if (items[i].itm && items[i].itemType == "bar") {
        dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);
        lastValues = {};
        lastValues.width = parseFloat(d3.select(item.itm).attr("width"));
        lastValues.height = parseFloat(d3.select(item.itm).attr("height"));
        lastValues.x = parseFloat(d3.select(item.itm).attr("x"));
        lastValues.y = parseFloat(d3.select(item.itm).attr("y"));

        if (dataIndex < 0) {
          item.value = null;
          d3.select(item.itm).attr("y", parseFloat(d3.select(item.itm).attr("y")) + parseFloat(d3.select(item.itm).attr("height")));
          d3.select(item.itm).attr("height", 0);
        }
        else {
          record = this.calcDataset[dataIndex];
          cobj.dbarIndex = item.sidx;
          cobj.scaleY = this.scaleY[item.valueField];
          item.value = record[1];
          d3.select(item.itm).attr("x", this._GetBarX(record, item.sidx, 0, 1, cobj));
          d3.select(item.itm).attr("y", this._GetBarY(record, item.sidx, 0, 1, cobj));
          d3.select(item.itm).attr("height", this._GetBarHeight(record, 1, cobj));
        }
      }
      else if (items[i].itm && items[i].itemType == "line") {
        line = d3.line()
                .x(function (d) {
                  return _this._GetDomainInScale(d, 0);
                })
                .y(function (d) {
                  return _this.scalePerc(d[1]);
                })
                .defined(function (d) {
                  return d[1] != null;
                })
                .curve(d3[this.defSettings.line.type]);

        lastValues = { };
        d3.select(item.itm).datum(this.supportDatasetPerc).attr("d", line);
        this._DrawPercentageReference(lgroup, k, item);
      }
      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
    this._AnimateReferenceLine(lgroup.selectAll(".axisRefLine")._groups[0], k, this.defSettings.animation.duration);
    d3.select("#" + this.chartId + "domainAxisGroup").select(".domain").remove(); // creato x effetto del call
    this.SetAxisFont("domain");
    StdChart.prototype.AfterDrawTimeout.call(this);
  }
  this.chartId = oldChartId;
}

ZtParetoChart.prototype._MapScalesFromChart = function (chart) {
  this.scaleX = chart.scaleX;
  this.scaleY = chart.scaleY;
  this.scalePerc = chart.scalePerc;
}

ZtParetoChart.prototype._DrawPattern = function (oldChartId) {
  var mchartid = this.chartId;
  this.chartId = oldChartId;
  this.DrawNegativePattern();
  this.chartId = mchartid;
}

ZtParetoChart.prototype._ApplyPatterns = function () {
  var items = this._GetItems().filter(function (item) { return item.itemType == "bar" && item.value < 0; });
  for (var i = 0; i < items.length; i++)
    this.ApplyPatternOnItem(items[i], "negativeValuePattern");
}

ZtParetoChart.prototype._GetValueLabelX = function (pos, item, text, font) {
  return ZtTreeMapBarChart.prototype._GetValueLabelX.call(this, pos, item, text, font);
}

ZtParetoChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  return ZtTreeMapBarChart.prototype._GetValueLabelY.call(this, pos, item, text, font);
}

ZtParetoChart.prototype._HasShapes = function () {
  return ZtLinesChart.prototype._HasShapes.call(this);
}

ZtParetoChart.prototype._GetBarWidthFromDomainEvaluation = function () { }