function ZtWaterfallChart() {
  ZtBarChart.apply(this, ["WATERF", -1, -1]);
  this.legendHexCode = "e900";
  this.multiSVG = true;
}
ZtWaterfallChart.prototype = Object.create(ZtBarChart.prototype);
ZtWaterfallChart.prototype.constructor = ZtWaterfallChart;

ZtWaterfallChart.prototype._SetChartSettingsJSON = function () {
  ZtBarChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.waterfall = this.chartConfig.graphSettings.waterfall;
}

ZtWaterfallChart.prototype._SetCategoryList = function () {
  if (!Empty(this.objConfig.keyField)) {
    //this.categoryList = getDuplicatesList(this.xLabelIndex, this.dataSet).array;
    this.categoryList = getDuplicatesListXYZ(this.xIndex, this.xLabelIndex, this.dataSet).array;
    this.orgCategoryList = getList(this.xIndex, this.dataSet);
  }
  else {
    this.categoryList = getList(this.xIndex, this.dataSet);
    this.orgCategoryList = this.categoryList.slice();
  }

  if (this.defSettings.waterfall.showTotal) {
    var tLab = this.defSettings.waterfall.totalLabel;
    if (Empty(tLab))
      tLab = "( " + this.Translate("ZTC_TOTAL") + " )";
    this.categoryList.push(tLab);
    this.orgCategoryList.push(tLab);
  }

  this.drawingCategories = this.orgCategoryList.slice();
}

ZtWaterfallChart.prototype._SetTotalsObject = function () {
  this.totalsSeries = {};
  for (var i = 0; i < this.valueFields.length; i++) {
    this.totalsSeries[this.valueFields[i]] = {};
    this.totalsSeries[this.valueFields[i]].sum = d3.sum(getList(this.propertyName.indexOf(this.valueFields[i]), this.dataSet, true));
    this.totalsSeries[this.valueFields[i]].abs = d3.sum(getAbsList(this.propertyName.indexOf(this.valueFields[i]), this.dataSet, true));
  }
  this.totalsSeries.categoriesT = {};
  var len = this.orgCategoryList.length;
  if (this.defSettings.waterfall.showTotal)
    len = len - 1;
  for (i = 0; i < len; i++) {
    var sum = 0;
    for (var j = 0; j < this.valueFields.length; j++)
      sum = sum + Math.abs(this.dataSet[i][this.propertyName.indexOf(this.valueFields[j])]);
    this.totalsSeries.categoriesT[i] = sum;
  }
}

ZtWaterfallChart.prototype.SetTotalsData = function () {
  if (this.dataSet.constructor != Array)
    return;
  if (this.defSettings.waterfall.showTotal) {
    var tmp = this.dataSet.slice(),
    aLabel = Empty(this.defSettings.waterfall.totalLabel) ? "( " + this.Translate("ZTC_TOTAL") + " )" : this.defSettings.waterfall.totalLabel;

    /** label **/
    tmp.push([]);
    tmp[tmp.length-1][this.xIndex] = aLabel;
    if (!Empty(this.objConfig.keyField))
      tmp[tmp.length-1][this.xLabelIndex] = aLabel;
    /** dati **/
    for (var j = 0; j < this.valueFields.length; j++) {
      var y_index = this.propertyName.indexOf(this.valueFields[j]);
      tmp[tmp.length - 1][y_index] = this.dataSet[this.dataSet.length - 1][y_index];
    }

    this.dataSet = tmp.slice();
    tmp = null;
  }
}

ZtWaterfallChart.prototype._SetCalculationDataset = function (dataSet) {
  this.calcDataset = getWaterfallDifferenceDataset(dataSet, this.defSettings.waterfall.showTotal);
}

ZtWaterfallChart.prototype._DrawChartPlot = function () {
  ZtPieChart.prototype._DrawChartPlot.call(this);
}

ZtWaterfallChart.prototype._DrawChartPlotElements = function () {
  ZtPieChart.prototype._DrawChartPlotElements.call(this);
}

ZtWaterfallChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = -1,
  group,
  oldChartId = this.chartId,
  mvalues = [],
  margins = this.defSettings.bars.margins,
  scaleS = d3.scaleBand(),
  dList = this._GetDrawingList(),
  cobj,
  _this = this,
  orgScaleY = this.scaleY,
  orgAllValues = this.allValues.slice(),
  oldMargins = { top : this.margin.top,
                 bottom : this.margin.bottom,
                 left : this.margin.left,
                 right : this.margin.right
               },
  oldCM = { width : this.chartWidth, height : this.chartHeight };

  if (isNaN(margins) || Empty(margins))
    margins = 0;

  this.MapDrawAxis(); // set this.scaleYref

  for (var i = 0; i < positions.length; i++) {
    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    yIndex = this.propertyName.indexOf(dList[i]);
    this.chartId = oldChartId + i + "_";
    mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], rec[yIndex]] });
    if ((this._ZtChart.StdChart.type != "MULTICURS" || !this.multiDimKeepSameScale) && !this.multipleScales)
      this.allValues = orgAllValues; //mvalues.map( function(r) { return r[1]; });
    else if (this.multipleScales) {
      if (this.objConfig.mapSeries && this.objConfig.mapSeries[dList[i]]) {
        if (this.objConfig.mapSeries[dList[i]].ownerScale)
          this.allValues = this[dList[i] + "_values"];
        else
          this.allValues = orgAllValues;
      }
    }

    this._SetCalculationDataset(mvalues);
    this._DrawMultiSVGPlot(this.chartId, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_elementGroup")
      .attr("transform","translate(" + [this.margin.left, this.margin.top] + ")");
    scaleS.domain([dList[i]]).range([0, this.scaleX.bandwidth()]);
    cobj = this._GetDrawParamObject(margins, 0, scaleS.bandwidth());
    cobj.scaleY = this.scaleY[dList[i]];
    cobj.transform = [this.margin.left + positions[i].x, this.margin.top + positions[i].y];
    this.DrawBar(group, mvalues, i, 0, 1, cobj);
  }
  this.scaleY = orgScaleY;
  this.chartId = oldChartId;
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
  this.margin = oldMargins;
  this.chartHeight = oldCM.height;
  this.chartWidth = oldCM.width;
}

ZtWaterfallChart.prototype._SetElementsColor = function () {
  ZtBarChart.prototype._SetElementsColor.call(this);

  if (this.defSettings.waterfall.showTotal) {
    var _this = this,
    items = this.items.filter( function (item) { return item.sidx == _this.dataSet.length - 1; } ),
    mycol,
    styleObj,
    gradID;

    for (var i = 0; i < items.length; i++) {
      if (Empty(this.defSettings.waterfall.totalColors.color))
        mycol = invertColor(items[i].colorApplied);
      else {
        gradID = this.chartId + this.type + "_" + items[i].idx + "Gradient";
        if (!Empty(this.defSettings.waterfall.totalColors.color) && Empty(this.defSettings.waterfall.totalColors.gradient) || this.defSettings.waterfall.totalColors.color.toLowerCase() == this.defSettings.waterfall.totalColors.gradient.toLowerCase())// eslint-disable-line max-len
          mycol = this.defSettings.waterfall.totalColors.color;
        else if (Empty(this.defSettings.waterfall.totalColors.color) && !Empty(this.defSettings.waterfall.totalColors.gradient))
          mycol = this.defSettings.waterfall.totalColors.gradient;
        else {
          this.CreateGradient(this.defSettings.waterfall.totalColors.color, this.defSettings.waterfall.totalColors.gradient, gradID, "element");
          mycol = "url(#" + gradID + ")";
        }
      }
      items[i].colorApplied = mycol;
      styleObj = { fill : mycol };
      d3.select(items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(items[i].itm).attr("style")));
    }
  }
}

ZtWaterfallChart.prototype._GetBarY = function (data, dataIndex, xIndex, yIndex, cobj) {
  if (this.defSettings.waterfall.showTotal && cobj.dbarIndex == this.dataSet.length - 1)
    return ZtBarChart.prototype._GetBarY.call(this, data, dataIndex, xIndex, yIndex, cobj);

  var y = 0,
  max = this.defSettings.valueAxis.maxValue,
  diff = data[yIndex] - this.calcDataset[cobj.dbarIndex][1];
  if (!Empty(max)) {
    if (max < 0)
      y = cobj.scaleY(max);
    else {
      if (diff < 0) {
        if (max <= this.calcDataset[cobj.dbarIndex][1])
          y = cobj.scaleY(max);
        else
          y = cobj.scaleY(this.calcDataset[cobj.dbarIndex][1]);
      }
      else {
        if (max <= data[yIndex])
          y = cobj.scaleY(max);
        else
          y = cobj.scaleY(data[yIndex]);
      }
    }
  }
  else {
    if (diff < 0)
      y = cobj.scaleY(data[yIndex] + Math.abs(diff));
    else
      y = cobj.scaleY(data[yIndex]);
  }
  return y;
}

ZtWaterfallChart.prototype._GetBarHeight = function (data, yIndex, cobj) {
  if (this.defSettings.waterfall.showTotal && cobj.dbarIndex == this.dataSet.length - 1)
    return ZtBarChart.prototype._GetBarHeight.call(this, data, yIndex, cobj);

  var h = 0,
  min = this.defSettings.valueAxis.minValue,
  max = this.defSettings.valueAxis.maxValue,
  diff = data[yIndex] - this.calcDataset[cobj.dbarIndex][1];

  if ((isNaN(min) || min === undefined || Empty(min)) && min !== 0)
    min = null;
  if ((isNaN(max) || max === undefined || Empty(max)) && max !== 0)
    max = null;

  if (diff < 0 && !this.hasNegativeValues)
    this.hasNegativeValues = true;
  if (!Empty(min)) {
    if (Empty(max) && max !== 0) {
      if (diff < 0) {
        if (min <= data[yIndex])
          h = Math.abs(cobj.scaleY(diff) - cobj.scaleY(0));
        else
          h = Math.abs(cobj.scaleY(this.calcDataset[cobj.dbarIndex][1]) - cobj.scaleY(min));
      }
      else {
        if (min <= this.calcDataset[cobj.dbarIndex][1])
          h = Math.abs(cobj.scaleY(diff) - cobj.scaleY(0));
        else
          h = Math.abs(cobj.scaleY(this.calcDataset[cobj.dbarIndex][1]) - cobj.scaleY(min));
      }
    }
    else {
      if (diff < 0) {
        if (max > this.calcDataset[cobj.dbarIndex][1]) {
          if (min <= data[yIndex])
            h = Math.abs(cobj.scaleY(diff) - cobj.scaleY(0));
          else
            h = Math.abs(cobj.scaleY(this.calcDataset[cobj.dbarIndex][1]) - cobj.scaleY(min));
        }
        else if (max >= data[yIndex] && max <= this.calcDataset[cobj.dbarIndex][1]) {
          if (min <= data[yIndex])
            h = Math.abs(cobj.scaleY(max) - cobj.scaleY(data[yIndex]));
          else
            h = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
        }
        else
          h = 0;
      }
      else {
        if (max >= data[yIndex]) {
          if (min <= this.calcDataset[cobj.dbarIndex][1])
            h = Math.abs(cobj.scaleY(diff) - cobj.scaleY(0));
          else
            h = Math.abs(cobj.scaleY(this.calcDataset[cobj.dbarIndex][1]) - cobj.scaleY(min));
        }
        else if (max >= this.calcDataset[cobj.dbarIndex][1] && max <= data[yIndex]) {
          if (min <= this.calcDataset[cobj.dbarIndex][1])
            h = Math.abs(cobj.scaleY(max) - cobj.scaleY(this.calcDataset[cobj.dbarIndex][1]));
          else
            h = Math.abs(cobj.scaleY(max) - cobj.scaleY(min));
        }
        else
          h = 0;
      }
    }
  }
  else {
    if (Empty(max) && max !== 0)
      h = Math.abs(cobj.scaleY(diff) - cobj.scaleY(0));
    else {
      if (diff < 0) {
        if (max > this.calcDataset[cobj.dbarIndex][1])
          h = Math.abs(cobj.scaleY(diff) - cobj.scaleY(0));
        else if (max >= data[yIndex] && max <= this.calcDataset[cobj.dbarIndex][1])
          h = Math.abs(cobj.scaleY(max) - cobj.scaleY(data[yIndex]));
        else
          h = 0;
      }
      else {
        if (max >= data[yIndex])
          h = Math.abs(cobj.scaleY(diff) - cobj.scaleY(0));
        else if (max >= this.calcDataset[cobj.dbarIndex][1] && max <= data[yIndex])
          h = Math.abs(cobj.scaleY(max) - cobj.scaleY(this.calcDataset[cobj.dbarIndex][1]));
        else
          h = 0;
      }
    }
  }
  return h;
}

ZtWaterfallChart.prototype._SetAxisColor = function () {
  var oldChartId = this.chartId,
  orgScaleY = this.scaleY,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisColor.call(this);
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtWaterfallChart.prototype._SetAxisGridColor = function () {
  var oldChartId = this.chartId,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisGridColor.call(this);
  }
  this.chartId = oldChartId;
}

ZtWaterfallChart.prototype._SetAxisFont = function () {
  var oldChartId = this.chartId,
  orgScaleY = this.scaleY,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisFont.call(this);
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtWaterfallChart.prototype._SetAxisLabelFont = function () {
  var oldChartId = this.chartId,
  orgScaleY = this.scaleY,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.scaleY = {};
    this.scaleY[dList[i]] = orgScaleY[dList[i]];
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisLabelFont.call(this);
  }
  this.chartId = oldChartId;
  this.scaleY = orgScaleY;
}

ZtWaterfallChart.prototype._SetAxisLabelsPositions = function () { }

ZtWaterfallChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  return ZtPieChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
}

ZtWaterfallChart.prototype._GetOtherChartMarginsObject = function (chartId, onlySVG, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
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
  var mfontsize = 0;
  if (settings.valueAxis.show) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = getMaxWordLength(allValues, valprec);
    myM.textorientation = 0;
    if (Empty(settings.axisLabel.yLabel))
      myM.offset = 5;
    ret.left.push(myM);

    mfontsize = Math.max(mfontsize, myM.fontsize);
  }

  myM = {};
  myM.text = "";
  myM.offset = mfontsize/2;
  myM.textorientation = 0;
  ret.top.push(myM);

  //ticks - valueAxis + percentAxis
  if (settings.valueAxis.show) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    myM = getGenericLabelConf(appliedfont);
    myM.text = ""; //ipotesi
    myM.addH = 8; //TICK HEIGHT
    myM.addW = 8;
    myM.textorientation = 0;
    ret.left.push(myM);
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

ZtWaterfallChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG) {
  var onlyFirst = true,
  valprec = this._GetValuesPrecision(),
  domprec = this._GetDomainPrecision();
  var marginsObj = this._GetOtherChartMarginsObject(id, onlySVG, this.defSettings, this.categoryList, this.dataOrder, this.domainIsTime, this.domainIsNumber, this.localeLangFormat, this.datetimePict, this.chartLegends, this.allValues, valprec, domprec); // eslint-disable-line max-len
  this.CalculateMargins(svgWidth, svgHeight, marginsObj);
  this.CreateSVG(id, parent, false, svgLeft, svgTop, svgWidth, svgHeight, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this.CreateRenderer(this.svg, id, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  if (this.scaleYref)
    this.scaleYref.range([0, this.chartHeight]);
  if (!onlySVG) {
    this._DrawAxis();
    if (onlyFirst)
      this._DrawAxisLabel();
    this._DrawGridLines();
  }
}

ZtWaterfallChart.prototype._GetDivisor = function () {
  return this._GetDrawingList().length;
}

ZtWaterfallChart.prototype._ApplyPatterns = function () {
  if (this.hasNegativeValues) {
    this.DrawNegativePattern();
    var items = this._GetItems().filter(function (item) { return item.difference < 0; });
    for (var i = 0; i < items.length; i++)
      this.ApplyPatternOnItem(items[i], "negativeValuePattern");
  }
}

ZtWaterfallChart.prototype._SetDifferenceInItem = function (item, index) {
  item.difference = item.value - this.calcDataset[index][1];
}

ZtWaterfallChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this.RemoveAllPatterns();
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
  item,
  cData = {},
  mvalues,
  _this = this;

  if (isNaN(margins) || Empty(margins))
    margins = 0;

  if (this.cData)
    cData = this.cData;

  this.DrawNegativePattern();

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm) {
      item = this.items[i];
      if (!cData[item.valueField]) {
        yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);
        mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], rec[yIndex]] });
        this._SetCalculationDataset(mvalues);
        cData[item.valueField] = {};
        cData[item.valueField].calc = this.calcDataset.slice();
        cData[item.valueField].data = mvalues.slice();
      }
      this.calcDataset = cData[item.valueField].calc;
      mvalues = cData[item.valueField].data;
      cList = getList(0, mvalues);
      dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);
      lastValues = {};
      lastValues.width = parseFloat(d3.select(item.itm).attr("width"));
      lastValues.height = parseFloat(d3.select(item.itm).attr("height"));
      lastValues.x = parseFloat(d3.select(item.itm).attr("x"));
      lastValues.y = parseFloat(d3.select(item.itm).attr("y"));

      record = mvalues[dataIndex];
      cobj = this._GetDrawParamObject(margins, item.idx * scaleS.bandwidth(), scaleS.bandwidth());
      item.sidx = dataIndex;
      cobj.dbarIndex = item.sidx;
      cobj.scaleY = this.scaleY[item.valueField];
      yIndex = 1;
      item.value = record[yIndex];
      if (item.value == null) {
        d3.select(item.itm).attr("y", parseFloat(d3.select(item.itm).attr("y")) + parseFloat(d3.select(item.itm).attr("height")));
        d3.select(item.itm).attr("height", 0);
      }
      else {
        d3.select(item.itm).attr("y", this._GetBarY(record, item.sidx, 0, 1, cobj));
        d3.select(item.itm).attr("height", this._GetBarHeight(record, 1, cobj));
      }

      this._SetDifferenceInItem(item, dataIndex);
      if (item.difference < 0)
        this.ApplyPatternOnItem(item, "negativeValuePattern");
      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
  this.cData = cData;
}

ZtWaterfallChart.prototype._GetValueLabelX = function (pos, item, text, font) {
  return ZtTreeMapBarChart.prototype._GetValueLabelX.call(this, pos, item, text, font);
}

ZtWaterfallChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  return ZtTreeMapBarChart.prototype._GetValueLabelY.call(this, pos, item, text, font);
}

ZtWaterfallChart.prototype._GetBarWidthFromDomainEvaluation = function () { }