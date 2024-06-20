function ZtXYZChart(type, isZ) {
  StdChart.apply(this, [type, "e914"]);
  this.isZ = isZ;
}
ZtXYZChart.prototype = Object.create(StdChart.prototype);
ZtXYZChart.prototype.constructor = ZtXYZChart;

ZtXYZChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.axisLabel = this.chartConfig.graphSettings.axisLabel;
  this.defSettings.domainAxis = this.chartConfig.graphSettings.domainAxis;
  this.defSettings.valueAxis = this.chartConfig.graphSettings.valueAxis;
  this.defSettings.fillTransparency = this.chartConfig.graphSettings.fillTransparency;
  if (this.chartConfig.graphSettings.selectionOptions.opacity == "default")
    this.defSettings.selectionOptions.opacity = 0.25;
  
  this.defSettings.domainAxis.precision = parseFloat(this.defSettings.domainAxis.precision);
  this.defSettings.valueAxis.precision = parseFloat(this.defSettings.valueAxis.precision);
}

ZtXYZChart.prototype._SetCalculationDataset = function (/*dataSet*/) {
  var _this = this;
  if (this.isZ) {
    this.dataSet.sort(function (a, b) {
      var xord = b[_this.xIndex] - a[_this.xIndex],
      yord = b[_this.yIndex] - a[_this.yIndex],
      zord = b[_this.zIndex] - a[_this.zIndex];
      return xord && yord && zord; 
    });
    this._SetSeriesList();
  }
}

ZtXYZChart.prototype._SetFieldsIndexes = function () {
  this.xIndex = this.propertyName.indexOf(this.objConfig.labelField);
  this.yIndex = this.propertyName.indexOf(this.objConfig.valueFields.split(",")[0]);
  if (this.isZ && this.objConfig.valueFields.split(",").length > 1)
    this.zIndex = this.propertyName.indexOf(this.objConfig.valueFields.split(",")[1]);
  this.seriesIndex = this.propertyName.indexOf(this.objConfig.labelSeries);
  if (!Empty(this.objConfig.keyField)) {
    this.seriesLabelIndex = this.propertyName.indexOf(this.objConfig.labelSeries);
    this.seriesIndex = this.propertyName.indexOf(this.objConfig.keyField);
  }
}

ZtXYZChart.prototype.SetDomainType = function (datetimePict, dataSet, xIndex) {
  if (this.checkDomain)
    return;
  
  dataSet = dataSet || this.dataSet;
  if (Empty(dataSet))
    return;
  xIndex = this.propertyName.indexOf(this.objConfig.labelField);
  if (xIndex < 0)
    return;

  StdChart.prototype.SetDomainType.call(this, datetimePict, dataSet, xIndex);

  var seriesIndex = this.propertyName.indexOf(this.objConfig.keyField || this.objConfig.labelSeries);
  if (IsA(dataSet[0][seriesIndex], 'D') || IsA(this.strToDateTime(dataSet[0][seriesIndex] + "", datetimePict), 'D'))
    this.seriesIsTime = true;
  else
    this.seriesIsTime = false;
}

ZtXYZChart.prototype._SetSeriesList = function () {
  if (!Empty(this.objConfig.keyField)) {
    this.seriesList = getDuplicatesListXYZ(this.seriesIndex, this.seriesLabelIndex, this.dataSet).array;
    this.orgSeriesList = getList(this.seriesIndex, this.dataSet);
  }
  else {
    this.seriesList = getList(this.seriesIndex, this.dataSet);
    this.orgSeriesList = this.seriesList.slice();
  }
  this.drawingSeries = this.seriesList.slice();
  this.legendList = this._GetDrawingList().slice();
}

ZtXYZChart.prototype._SetLists = function () {
  this._SetSeriesList();
  this._SetCategoryList();

  this.valueFields = this.objConfig.valueFields.split(',');
  this.orgValueFields = this.objConfig.valueFields.split(',');

  this._EvaluateAllValues();
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);

  if (this.isZ)
    this.allValuesZ = getList(this.zIndex, this.dataSet);

 // this.legendList = this._GetDrawingList().slice();
  this.rowLegendList = [];

  this.seriesCount = {};
  for (var i = 0; i < this.dataSet.length; i++) {
    if (!this.seriesCount[this.dataSet[i][this.seriesIndex]] && this.seriesCount[this.dataSet[i][this.seriesIndex]] != 0)
      this.seriesCount[this.dataSet[i][this.seriesIndex]] = 1;
    else
      this.seriesCount[this.dataSet[i][this.seriesIndex]] ++;
  }
  this.sCount = this.seriesCount;
}

ZtXYZChart.prototype._EvaluateAllValues = function () {
  this.allValues = [];
  var valuesSeries = getListBySeries(this.yIndex, this.dataSet, this.seriesIndex);
  for (var i = 0; i < this.orgSeriesList.length; i++) {
    var sckey = replaceSpecialCharsForID(this.orgSeriesList[i]);
    this[sckey + "_values"] = [];
    if (valuesSeries[this.orgSeriesList[i]])
      this[sckey + "_values"] = valuesSeries[this.orgSeriesList[i]];
    if (!this.multipleScales)
      this.allValues = this.allValues.concat(this[sckey + "_values"]);
    else if (this.objConfig.mapSeries) {
      if (this.objConfig.mapSeries[sckey] && !this.objConfig.mapSeries[sckey].ownerScale)
        this.allValues = this.allValues.concat(this[sckey + "_values"]);
      else if (!(sckey in this.objConfig.mapSeries))
        this.allValues = this.allValues.concat(this[sckey + "_values"]);
    }
  }
  this.allValuesY = this.allValues;
}

ZtXYZChart.prototype._SetCategoryList = function () {
  if (this.domainIsNumber) {
    this.categoryList = getValues([this.objConfig.labelField], this.propertyName, this.dataSet);
    this.allValuesX = getValues([this.objConfig.labelField], this.propertyName, this.dataSet);
  }
  else {
    this.categoryList = getList(this.xIndex, this.dataSet);
    this.allValuesX = getList(this.xIndex, this.dataSet);
  }
  this.orgCategoryList = this.categoryList.slice();
  this.drawingCategories = this.orgCategoryList.slice();
}

ZtXYZChart.prototype._SetScales = function () {
  if (this.isZ) {
    var minWH = Math.min(this.defSettings.globals.width, this.defSettings.globals.height),
    radiusOffset = 0.125,
    minRad = (minWH * radiusOffset) / 10;
    minRad = minRad <= 5 ? 5 : minRad;
    this.scaleZ = d3.scaleLinear()
      .range([minRad, minWH * radiusOffset])
      .domain([d3.min(this.allValuesZ), d3.max(this.allValuesZ)]);
  }

  StdChart.prototype._SetScales.call(this);
  this.scaleY = {};
  var seriesList = [];
  if (this.objConfig.mapSeries)
    seriesList = Object.keys(this.objConfig.mapSeries);
  if (seriesList.length < this.seriesList.length)
    seriesList = this.seriesList;
  for (var i = 0; i < seriesList.length; i++) {
    var skey = /*this.orgSeriesList*/seriesList[i];
    if (this.seriesIsTime && (typeof skey != "string"))
      skey = this.stdFormat(/*this.orgSeriesList*/seriesList[i]);
    skey = replaceSpecialCharsForID(skey);
    this.scaleY[skey] = d3.scaleLinear();
  }
}

ZtXYZChart.prototype._DrawChartPlot = function () {
  ZtLinesChart.prototype._DrawChartPlot.call(this);
}

ZtXYZChart.prototype._DrawChartPlotElements = function () {
  ZtLinesChart.prototype._DrawChartPlotElements.call(this);
}

ZtXYZChart.prototype._GetValueAxisPosition = function () {
  return ZtLinesChart.prototype._GetValueAxisPosition.call(this);
}

ZtXYZChart.prototype._GetDomainAxisPosition = function () {
  return ZtLinesChart.prototype._GetDomainAxisPosition.call(this);
}

ZtXYZChart.prototype._GetValueAxisMinMax = function (scaleKey, min, max) {
  return ZtLinesChart.prototype._GetValueAxisMinMax.call(this, scaleKey, min, max);
}

ZtXYZChart.prototype._GetDomainAxisMinMax = function () {
  var min, max, fixedmin = false, fixedmax = false,
  offsetRadius = this._GetXYZRadius();
  if (!Empty(this.defSettings.domainAxis.minValue) || parseInt(this.defSettings.domainAxis.minValue) == 0) {
    min = this.defSettings.domainAxis.minValue;
    fixedmin = true;
  }
  else
    min = d3.min(this.allValuesX);
  if (!Empty(this.defSettings.domainAxis.maxValue) || parseInt(this.defSettings.domainAxis.maxValue) == 0) {
    max = this.defSettings.domainAxis.maxValue;
    fixedmax = true;
  }
  else
    max = d3.max(this.allValuesX);
  return  { min: min, 
            max: max,
            offsetRadius : offsetRadius,
            fixed : { min : fixedmin, max : fixedmax }
          };
}

ZtXYZChart.prototype._SetValueScaleParameters = function (scaleKey, scaleY, min, max) {
  var mh = this.chartHeight,
  start = 0,
  mmin = min,
  mmax = max;

  if (this.defSettings.valueLabel.show != "hide") {
    var txt = this.GetValueLabelMaxWord(this.dataSet);
    var lblFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont);
    var hlen = getOffsetHeight(txt, lblFont, this.chartId);
    if (this.defSettings.valueLabel.position == "bottom")
      mh = mh - hlen;
    if (this.defSettings.valueLabel.position == "top")
      start = start + hlen;
  }
  
  scaleY.domain([max, min]).range([start, mh]);
  var parms = this._SetRadiusOnScales(min, max, scaleY);
  mmin = parms.min;
  mmax = parms.max;
  if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue))
    mmin = this.defSettings.valueAxis.minValue;
  if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue))
    mmax = this.defSettings.valueAxis.maxValue;

  scaleY.domain([mmax, mmin])//.range([start, mh]);
  return { min: mmin, max: mmax };
}

ZtXYZChart.prototype._SetDomainScaleParameters = function () {
  ZtLinesChart.prototype._SetDomainScaleParameters.call(this);
}

ZtXYZChart.prototype._SetRadiusOnScales = function (min, max, scale) {
  var radius = (this._GetXYZRadius() + 5) * 1.5,
//  (this.GetShapesRadius() + 5) * 1.5
  mmin = scale.invert(scale(min) + radius),
  mmax = scale.invert(scale(max) - radius);
  return { min : mmin, max : mmax };
}

ZtXYZChart.prototype._GetDomainAxisXPosition = function () {
  return ZtLinesChart.prototype._GetDomainAxisXPosition.call(this);
}

ZtXYZChart.prototype._GetDomainAxisYPosition = function () {
  return ZtLinesChart.prototype._GetDomainAxisYPosition.call(this);
}

ZtXYZChart.prototype._GetValueAxisXPosition = function () {
  return ZtLinesChart.prototype._GetValueAxisXPosition.call(this);
}

ZtXYZChart.prototype._GetValueAxisYPosition = function () {
  return ZtLinesChart.prototype._GetValueAxisYPosition.call(this);
}

ZtXYZChart.prototype._DrawChartElements = function () {
  var domainAxisOffset = 3;
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left + domainAxisOffset, this.margin.top] + ")");

  this.DrawXYZ(group, this.dataSet, this.xIndex, this.yIndex, this.seriesIndex, this.zIndex);
}

ZtXYZChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  stroke,
  gradID,
  ser;

  for (var i = 0; i < this.items.length; i++) {
    ser = this.items[i].series;
    if (!Empty(this.items[i].keyField))
      ser = this.items[i].keyField;
    if (this.seriesIsTime)
      idx = this.orgSeriesList.hasElement(new Date(ser));
    else
      idx = this.orgSeriesList.indexOf(ser);
    
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].color = this.colorSet[idx];
      this.items[i].sidx = this._SetSeriesIndex(idx);
      var styleObj = {};
      gradID = this.chartId + this.type + "_" + idx + "Gradient";
      if (this.defSettings.reuseColorSeries && !this.colorSet[idx]) {
        var l = this.colorSet.length;
        idx = idx % l;
      }
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      if (!Empty(this.items[i].color.color) && Empty(this.items[i].color.gradient) || this.items[i].color.color.toLowerCase() == this.items[i].color.gradient.toLowerCase())
        stroke = this.items[i].color.color;
      else if (Empty(this.items[i].color.color) && !Empty(this.items[i].color.gradient))
        stroke = this.items[i].color.gradient;
      else {
        this.CreateGradient(this.items[i].color.color, this.items[i].color.gradient, gradID, "element");
        stroke = "url(#" + gradID + ")";
      }
      styleObj.stroke = stroke;
      styleObj.fill = stroke;
      if (this.isZ)
        styleObj.fill9opacity = this.defSettings.fillTransparency ? 0.75 : 1;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtXYZChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec/*, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  var myM = {},
  min = d3.min(allValues),
  max = d3.max(allValues),
  tickY = parseFloat(settings.valueAxis.tick);

  if (!isNaN(tickY) && !Empty(tickY)) {
    if (min == max) {
      min = min - 1;
      max = max + 1;
      // calcolo ripreso in _RemapScale
      var dmin = min / tickY,
      dmax = max / tickY;
      if (dmin > 1)
        min = Math.floor(dmin) * tickY;
      else
        min = min * (tickY / 2);
      if (dmax > 1)
        max = Math.round(dmax) * tickY;
      else
        max = max * (tickY / 2);
      allValues.push(min);
      allValues.push(max);
    }
  }

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

    if (domainIsTime && dataOrder == "column") {
      if (Empty(settings.time.customFormat) && !Empty(settings.time.format))
        myM.text = settings.time.format;
      else if (!Empty(settings.time.customFormat) && Empty(settings.time.format)) {
        var format = getTimeTickFormat(localeLangFormat, settings.time.customFormat);
        myM.text = format(getMaxWordLength(categoryList));
      }
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
    myM.addH = 6; //TICK HEIGHT 6
    myM.addW = 6;
    myM.textorientation = 90;
    ret.bottom.push(myM);
  }

  //valori
  if (settings.valueAxis.show) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    
    myM = getGenericLabelConf(appliedfont);
    myM.text = ""; //ipotesi
    myM.addH = 6; //TICK HEIGHT 6
    myM.addW = 6;
    myM.textorientation = 90;
    ret.top.push(myM);

    var add = false;
    for (var i = 0; i < this.orgSeriesList.length; i++) {
      myM = getGenericLabelConf(appliedfont);
      myM.textorientation = 0;
      myM.offset = 0;
      if (Empty(settings.axisLabel.yLabel))
        myM.offset = 5;
      if (this.multipleScales) {
        myM.offset = myM.offset + 10;
        if (this.objConfig.mapSeries && this.objConfig.mapSeries[this.orgSeriesList[i]] && this.objConfig.mapSeries[this.orgSeriesList[i]].ownerScale) {
          myM.text = getMaxWordLength(this[this.orgSeriesList[i] + "_values"], valprec, this.localeLangFormat.numberFormat(",." + valprec + "f"));
          add = true;
        }
        /*else if (!add) {
          myM.text = getMaxWordLength(allValues, valprec, this.localeLangFormat.numberFormat(",." + valprec + "f"));
          add = true;
        }*/
      }
      else {
        myM.text = getMaxWordLength(allValues, valprec, this.localeLangFormat.numberFormat(",." + valprec + "f"));
        i = this.orgSeriesList.length;
      }
      if (!Empty(myM.text))
        ret.left.push(myM);
    }
  }

  if (this.multipleScales && !add) {
    myM.text = getMaxWordLength(allValues, valprec, this.localeLangFormat.numberFormat(",." + valprec + "f"));
    ret.left.push(myM);
  }

  return ret;
}

ZtXYZChart.prototype._GetXYZRadius = function () {
  if (this.isZ)
    return this.scaleZ(d3.max(this.allValuesZ));
  return 4.5;
}

ZtXYZChart.prototype._GetXCoordinate = function(data, index) {
  if (this.domainIsNumber || this.domainIsTime)
    return this.scaleX(data[index]);
  return this.scaleX(data[index]) + this.scaleX.bandwidth() / 2;
}

ZtXYZChart.prototype._GetYCoordinate = function(data, index, scaleKey) {
  scaleKey = replaceSpecialCharsForID(scaleKey);
  if (this.scaleY[scaleKey].__refAxis != scaleKey)
    scaleKey = replaceSpecialCharsForID(this.scaleY[scaleKey].__refAxis);
  return this.scaleY[scaleKey](data[index]);
}

ZtXYZChart.prototype._GetZCoordinate = function(data, index/*, idx*/) {
  if (this.isZ)
    return this.scaleZ(data[index]);
  return this._GetXYZRadius();
}

ZtXYZChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj),
  cx = d3.select(elem).attr("cx"),
  cy = d3.select(elem).attr("cy"),
  r = d3.select(elem).attr("r");
  d3.select(elem)
    .attr("cx", defaultValues ? cx : lastValueObj.cx)
    .attr("cy", defaultValues ? cy : lastValueObj.cy)
    .attr("r", defaultValues ? 0 : lastValueObj.r)
    .transition()
      .delay(item.idx * duration/div)
      .duration(duration/div)
      .ease(d3.easeLinear)
      .attr("cx", cx)
      .attr("cy", cy)
      .attr("r", r);
}

ZtXYZChart.prototype._GetAnimatedDivisor = function() {
  var div = this._ZtChart.StdChart.orgSeriesList.length;
  if (div == 0)
    div = 1;
  return div;
}

ZtXYZChart.prototype._SupportChangeOrder = function () {
  return false;
}

ZtXYZChart.prototype._MapWithAnother = function (anotherStd) {
  this.categoryList = this.allValuesX = anotherStd.categoryList.slice();
  this.seriesList = anotherStd.seriesList.slice();
  this.orgSeriesList = anotherStd.orgSeriesList.slice();
  this.seriesCount = anotherStd.seriesCount;
  this._MapAllValues(anotherStd);
}

ZtXYZChart.prototype._MapAllValues = function (anotherStd) {
  this.allValues = this.allValuesY = anotherStd.allValues;
  this.allValuesZ = anotherStd.allValuesZ;
  this.rangeminmax.min = anotherStd.rangeminmax.min;
  this.rangeminmax.max = anotherStd.rangeminmax.max;
  this.rangeminmax.precision = anotherStd.rangeminmax.precision;
  for (var i = 0; i < anotherStd.orgSeriesList.length; i++) {
    this[anotherStd.orgSeriesList[i] + "_values"] = anotherStd[anotherStd.orgSeriesList[i] + "_values"];
  }
}

ZtXYZChart.prototype.SetKeyField = function (hasKF) {
  if (!hasKF) {
    this.keyField.series = false;
    this.keyField.domain = false;
    return;
  }

  this.keyField.series = true;
  this.keyField.domain = false;
}

ZtXYZChart.prototype._MapScalesFromChart = function (chart) {
  StdChart.prototype._MapScalesFromChart.call(this, chart);
  this.scaleZ = chart.scaleZ;
}

ZtXYZChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this.items = lastChart.items.slice();
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  item,
  progr = {},
  _this = this;

  for (var i = 0; i < this.dataSet.length; i++) {
    record = this.dataSet[i];
    if (!(record[this.seriesIndex] in progr))
      progr[record[this.seriesIndex]] = 0;
    progr[record[this.seriesIndex]] ++;
    item = this.items.filter( function (it) {
      if (it.progrSeries == progr[record[_this.seriesIndex]]) {
        if (!Empty(it.keyField) && it.keyField == record[_this.seriesIndex])
          return true;
        if (it.series == record[_this.seriesIndex])
          return true;
        return false;
      }
      return false;
    })[0];

    if (item && item.itm) {
      lastValues = {};
      lastValues.cx = d3.select(item.itm).attr("cx");
      lastValues.cy = d3.select(item.itm).attr("cy");
      lastValues.r = d3.select(item.itm).attr("r");
      item.x = record[this.xIndex];
      item.y = record[this.yIndex];
      if (this.isZ)
        item.z = record[this.zIndex];

      item.coordinates.x = this._GetXCoordinate(record, this.xIndex);
      item.coordinates.y = this._GetYCoordinate(record, this.yIndex, item.series);
      item.coordinates.z = this._GetZCoordinate(record, this.zIndex);

      d3.select(item.itm)
        .attr("cx", item.coordinates.x)
        .attr("cy", item.coordinates.y)
        .attr("r", function () {
          var r = item.coordinates.z;
          if (r < 0)
            r = 0;
          return r;
        });

      this._GetDefaultAnimateFunction(item, lastValues, this.defSettings.animation.duration);
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtXYZChart.prototype._CheckEmptyValues = function () {
  var morg = Object.keys(this.seriesCount),
  count = 0,
  key,
  record;

  for (var i = 0; i < morg.length; i++) {
    key = morg[i];
    if (key in this.sCount)
      count = Math.abs(this.seriesCount[key] - this.sCount[key]);
    else
      count = this.seriesCount[key];

    for (var j = 0; j < count; j++) {
      record = [];
      for (var k = 0; k < this.dataSet[0].length; k++)
        record.push(null);
      if (this.seriesLabelIndex)
        record[this.seriesLabelIndex] = this.seriesList[i];
      record[this.seriesIndex] = key;
      this.dataSet.push(record);
    }
  }
}

ZtXYZChart.prototype._GetReferredList = function () {
  return JSON.parse(this.columnOrderData.orgSeriesList).map(
    function (el) {
      return replaceSpecialCharsForID(el);
    }
  );
}

ZtXYZChart.prototype._SupportFilter = function () {
  return false;
}

ZtXYZChart.prototype._CalculateOffsetAxis = function () {
  return true;
}
/*
ZtXYZChart.prototype.SetAxisColor = function (type, coord, value, noArc, axId, scaleRef) {
  axId = axId || "";
  var defaultStrokeColor = "#C0C0C0",
  defaultStrokeWidth = 1,
  styleObj = {},
  axisID,
  ticks,
  line,
  axisProp = type + "Axis",
  axisLine = type + "Line";

  if (!this.defSettings[axisProp].show) {
    styleObj.visibility = "hidden";
    axisID = this.chartId + type + "AxisGroup" + axId;
    d3.select("#" + axisID).attr("style", makeStyleHTMLString(styleObj, d3.select("#" + axisID).attr("style")));
    return;
  }

  styleObj.fill = "transparent";
  styleObj.shape9rendering = "crispEdges";
  styleObj.stroke = defaultStrokeColor;
  styleObj.stroke9width = defaultStrokeWidth + "px";

  if (type == "tick" && !noArc) {
    styleObj.stroke = "transparent";
    styleObj.shape9rendering = "auto";
    styleObj.fill = defaultStrokeColor;
    styleObj.stroke9width = 0 + "px";
  }

  if (!Empty(this.defSettings[axisProp][axisLine].color)) {
    if (type == "tick" && !noArc)
      styleObj.fill = this.defSettings[axisProp][axisLine].color;
    else
      styleObj.stroke = this.defSettings[axisProp][axisLine].color;
  }

  // asse
  if (this.multipleScales && type != "percent") {
    if (this.objConfig.mapSeries && (scaleRef in this.objConfig.mapSeries)) {
      if (this.objConfig.mapSeries[scaleRef].ownerScale) {
        if (type == "tick" && !noArc)
          styleObj.fill = this.colorSet[this.orgSeriesList.indexOf(scaleRef)].color;
        else
          styleObj.stroke = this.colorSet[this.orgSeriesList.indexOf(scaleRef)].color;
      }
    }
  }

  if (!Empty(this.defSettings[axisProp][axisLine].stroke) && !isNaN(this.defSettings[axisProp][axisLine].stroke) && this.defSettings[axisProp][axisLine].stroke > 0)
    styleObj.stroke9width = this.defSettings[axisProp][axisLine].stroke + "px";

  if ("showAxis" in this.defSettings[axisProp]) {
    if (!this.defSettings[axisProp].showAxis) {
      if (type == "tick" && !noArc)
        styleObj.fill = "transparent";
      else
        styleObj.stroke = "transparent";
    }
  }

  axisID = this.chartId + type + "AxisGroup" + axId;
  if (d3.select("#" + axisID).select("." + type + "Ax").node())
    d3.select("#" + axisID).select("." + type + "Ax")
      .attr("style", makeStyleHTMLString(styleObj,d3.select("#" + axisID).select("." + type + "Ax").attr("style")));

  if (type == "tick" && !noArc) {
    styleObj.stroke = styleObj.fill;
    styleObj.fill = "transparent";
  }

  ticks = d3.select("#" + axisID).selectAll(".tick")._groups[0];
  for (var i = 0; i < ticks.length; i++) {
    line = d3.select(ticks[i]).select("line");
    if (coord && value)
      line.node().attributes[coord].value = value;
    if (type == "tick" && !noArc) {
      styleObj.shape9rendering = "auto";
      styleObj.stroke9width = defaultStrokeWidth + "px";
      var rot = parseInt(line.attr("data-rotation"));
      if (rot == 0 || rot == 90 || rot == -90 || rot == -180 || rot == 180)
        styleObj.shape9rendering = "crispEdges";
      if (!Empty(d3.select(ticks[i]).attr("data-major")))
        styleObj.stroke9width = 2 + "px";
    }
    line.attr("style", makeStyleHTMLString(styleObj, line.attr("style")));
  }
}
*/
ZtXYZChart.prototype._ApplyMouseOver = function (item, itemObj) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  this.RemoveAllHovers();
  if (item) {
    var itemObject = itemObj || this._GetItems()[d3.select(item).attr("item-index")],
    clone = this._GetItemClone(item),
    refLinesGroup;
    mRefChart._hoverItem = itemObject;
    d3.select(clone)
      .attr("item-type", "hover")
      .attr("r", itemObject.r + 5)
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
        delete mRefChart._hoverItem;
      })
      .on("click", function () {
        _this._ApplyClick(itemObject, d3.mouse(this));
      });

    mRefChart._d3mouse = d3.mouse(item);
    mRefChart._d3event = d3.event;
    setTimeout(function(mRefChart, item, itemObject, clone){
      if (mRefChart._hoverItem) {
        if (mRefChart._CheckIdentityItem(mRefChart._hoverItem, itemObject)) {
          item.parentNode.appendChild(clone);
          refLinesGroup = _this.svg.append("g")
                      .attr("class", "referenceLineGroup")
                      .attr("item-type", "hover")
                      .attr("transform", "translate(" + [_this.margin.left, _this.margin.top] + ")");

          var skey = !Empty(itemObject.keyField) ? itemObject.keyField : itemObject.series,
          sID = _this.scaleY[replaceSpecialCharsForID(skey)].__refAxis,
          axisRef = _this.svg.select("#" + _this.chartId + "valueAxisGroup_" + sID).node();
          if (axisRef && (axisRef.transform.baseVal.length > 0 || axisRef.transform.baseVal.numberOfItems > 0))
            axisRef = - Math.abs(_this._GetValueAxisXPosition() - axisRef.transform.baseVal.getItem(0).matrix.e);
          _this.DrawAxisReference("value", _this._GetValueAxisPosition(), refLinesGroup, axisRef, itemObject.coordinates.x, itemObject.coordinates.y, itemObject.color.color);
          _this.DrawAxisReference("domain", _this._GetDomainAxisPosition(), refLinesGroup, axisRef, itemObject.coordinates.x, itemObject.coordinates.y, itemObject.color.color);

          _this.ShowTooltip(mRefChart, item, itemObject);
        }
      }
    }, 50, mRefChart, item, itemObject, clone);
  }
}

ZtXYZChart.prototype._GetReferredExcludedList = function () {
  return JSON.parse(this.columnOrderData.orgSeriesList);
}

ZtXYZChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  var halfOpacity = this.defSettings.selectionOptions.opacity,
  fullOpacity = 1,
  fillColor = this.defSettings.selectionOptions.color,
  stobj;
  if (this.isZ)
    fullOpacity = this.defSettings.fillTransparency ? 0.75 : 1;
  for (var i = 0; i < items.length; i++) {
    if (!items[i].itm)
      continue;
    if (items[i].type == "legend") {
      this._ApplyLegendSelectEffect(items[i], selected);
      continue;
    }
    stobj = {};
    if (selected) {
      stobj.fill9opacity = fullOpacity;
      stobj.stroke9opacity = 1;
      stobj.opacity = 1;
    }
    else {
      stobj.fill9opacity = halfOpacity;
      stobj.stroke9opacity = halfOpacity;
      if (!Empty(fillColor))
        stobj.fill = fillColor;
    }
    d3.select(items[i].itm).attr("style", makeStyleHTMLString(stobj, d3.select(items[i].itm).attr("style")));
  }
}

ZtXYZChart.prototype._SetElementsRangeColor = function (isFnc) {
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
        var band = this.GetObjectFromRange(this.items[i].y, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.items[i], band);
        styleObj = { fill: fill };
      }
      this.items[i].colorApplied = fill;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtXYZChart.prototype.GetValueLabelText = function (type, item, valueProp) {
  var txt = "",
  value = item[valueProp],
  toPrint = this._EvaluatePrintValueLabel(type, item);
  if (!toPrint)
    return txt;
  if (type == "ser")
    txt = item.series;
  else if (type == "value") {
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        txt = "(";
        txt += this.functionObj.GetValuePicture(this./*_GetItemObj*/_GetItemForGrid(item, "x"));
        txt += ", ";
        txt += this.functionObj.GetValuePicture(this._GetItemForGrid(item, "y"));
        if (this.isZ) {
          txt += ", ";
          txt += this.functionObj.GetValuePicture(this._GetItemForGrid(item, "z"));
        }
        txt += ")";
      }
    }
    else {
      txt = "(" + item.x + ", " + this.GetValuePicture(value);
      if (this.isZ)
        txt += ", " + item.z;
      txt += ")";
    }
  }
  return txt;
}

ZtXYZChart.prototype._GetValueLabelValueProp = function () {
  return "y";
}

ZtXYZChart.prototype._EvaluatePrintValueLabel = function (type, item) {
  var el = true;
  if (type == "ser")
    el = item.progrSeries == 1;
  return el;
}

ZtXYZChart.prototype._GetDrawingList = function () {
  if (this.seriesIsTime) {
    var _this = this;
    return this.drawingSeries.map(function (ser) { return _this.stdFormat(ser); });
  }
  return this.drawingSeries;
}

ZtXYZChart.prototype._CheckIdentityItem = function (itemOrg, itemOth) {
  if (this.domainIsTime) {
    var serie1 = itemOrg.series;
    if (serie1.getTime)
      serie1 = serie1.getTime();
    var serie2 = itemOth.series;
    if (serie2.getTime)
      serie2 = serie2.getTime();
    var category1 = itemOrg.x;
    if (category1.getTime)
      category1 = category1.getTime();
    var category2 = itemOth.x;
    if (category2.getTime)
      category2 = category2.getTime();
    return (serie1 == serie2 && category1 == category2) || (serie1 == category2 && category1 == serie2);
  }
  return  itemOrg.series == itemOth.series &&
          (itemOrg.x == itemOth.x && itemOrg.y == itemOth.y && itemOrg.z == itemOth.z) && 
          (itemOrg.keyField == itemOth.keyField || itemOrg.keyF == itemOth.keyField );
}

ZtXYZChart.prototype._EvaluateAutomaticScales = function () {
  if (this.chartConfig.graphSettings.multiDimensional && this.chartConfig.graphSettings.multiDimensional.multiDim)
    return;
  if (Empty(this.objConfig.labelSeries))
    return;

  if (!this.objConfig.mapSeries)
    this.objConfig.mapSeries = {};
  // precarico eventuale valutazione scala automatica
  var map = {},
  maxs = [],
  yidx = this.propertyName.indexOf(this.objConfig.valueFields.split(",")[0]),
  sidx = this.propertyName.indexOf(this.objConfig.labelSeries);
  if (!Empty(this.objConfig.keyField)) {
    sidx = this.propertyName.indexOf(this.objConfig.keyField)
  }
  var mser = getList(sidx, this.dataSet),
    vals = getListBySeries(yidx, this.dataSet, sidx);
  for (var i = 0; i < mser.length; i++) {
    var i_ser = mser[i];
    if (this.seriesIsTime && (typeof i_ser == "string")) {
      i_ser = new Date(Date.parse(mser[i]));
      i_ser = this.stdFormat(i_ser);
    }
    var serkey = replaceSpecialCharsForID(i_ser),
      values = vals[mser[i]];
    map[serkey] = { max: d3.max(values), auto: true };
    maxs.push(map[serkey].max)
    if (i > 0) {
      var mo1,
      mo2 = getMagnitudeOrder(maxs[i]),
      auto = true;
      for (var j = 0; auto && j < maxs.length; j++) {
        if (i == j)
          continue;
        mo1 = getMagnitudeOrder(maxs[j]);
        if (Math.abs(mo1 - mo2) <= 2) {
          auto = false;
        }
      }
      map[serkey].auto = auto;
    }

    if (!(mser[i] in this.objConfig.mapSeries) && !(serkey in this.objConfig.mapSeries)) {
      this.objConfig.mapSeries[serkey] = {};
      this.objConfig.mapSeries[serkey].type = "default";
      this.objConfig.mapSeries[serkey].ownerScale = map[serkey].auto;
    }
    else {
      if ((mser[i] in this.objConfig.mapSeries) && !(serkey in this.objConfig.mapSeries)) {
        var tmp = JSON.stringify(this.objConfig.mapSeries[mser[i]]);
        this.objConfig.mapSeries[serkey] = JSON.parse(tmp);
        delete this.objConfig.mapSeries[mser[i]];
      }
      if (!this.objConfig.mapSeries[serkey].ownerScale) // potrebbe averla, se invece è true lascio cosi'
        this.objConfig.mapSeries[serkey].ownerScale = map[serkey].auto;
    }
  }
}

ZtXYZChart.prototype._SetSeriesIndex = function (val) {
  return val;
}

ZtXYZChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "",
  _this = this, //._ZtChart.StdChart,
  format,
  val;

  if (!Empty(itemObject.series))
    purl += "&serie=" + URLenc(itemObject.series);

  val = itemObject.x;
  if (!Empty(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject, "x"));
      }
    }
    else {
      if (_this.domainIsTime) {
        format = _this.stdFormat;
        if (!Empty(_this.defSettings.time.customFormat) || !Empty(_this.defSettings.time.format))
          format = getTimeTickFormat(_this.localeLangFormat, _this.defSettings.time.customFormat || _this.defSettings.time.format);
        val = format(val);
      }
      else if (_this.domainIsNumber)
        val = parseFloat(itemObject.x);
    }
    purl += "&x=" + URLenc(val);
  }
  
  val = parseFloat(itemObject.y);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject, "y"));
      }
    }
    purl += "&y=" + URLenc(val);
  }
  
  val = parseFloat(itemObject.z);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject, "z"));
      }
    }
    purl += "&z=" + URLenc(val);
  }
  
  if (!Empty(_this.defSettings.axisLabel.xLabel))
    purl += "&xlabel=" + URLenc(_this.defSettings.axisLabel.xLabel);
  
  if (!Empty(_this.defSettings.axisLabel.yLabel))
    purl += "&ylabel=" + URLenc(_this.defSettings.axisLabel.yLabel);

  return purl;
}

ZtXYZChart.prototype._GetParametersStringForLink = function (item) {
  var purl = "",
  _this = this,
  format,
  val,
  linkObj = this.linkObj,
  seriesName = Empty(linkObj.seriesname) ? "series" : linkObj.seriesname,
  categoryName = Empty(linkObj.categoryname) ? "category" : linkObj.categoryname,
  categoryKeyName = Empty(linkObj.categoryKeyName) ? "categoryKey" : linkObj.categoryKeyName,
  valueName = Empty(linkObj.valuename) ? "value" : linkObj.valuename,
  valueZName = Empty(linkObj.valuezname) ? "valuez" : linkObj.valuezname;

  if (this.seriesIsTime) {
    var ser = item.keyF;
    if (typeof item.keyF == "object" && !Empty(item.keyF))
      ser = _this.stdFormat(item.keyF);
    purl += categoryKeyName + "=" + ser;
    ser = item.series;
    if (typeof item.series == "object" && !Empty(item.series))
      ser = _this.stdFormat(item.series);
    purl += "&" + seriesName + "=" + ser;
  }
  else {
    purl += categoryKeyName + "=" + item.keyF;
    purl += "&" + seriesName + "=" + item.series;
  }
 
  val = item.x;
  if (!Empty(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item, "x"));
      }
    }
    else {
      if (_this.domainIsTime) {
        format = _this.stdFormat;
        if (!Empty(_this.defSettings.time.customFormat) || !Empty(_this.defSettings.time.format))
          format = getTimeTickFormat(_this.localeLangFormat, _this.defSettings.time.customFormat || _this.defSettings.time.format);
        val = format(val);
      }
      else if (_this.domainIsNumber)
        val = parseFloat(item.x);
    }
    purl += "&" + categoryName + "=" + URLenc(val);
  }
  
  val = parseFloat(item.y);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item, "y"));
      }
    }
    purl += "&" + valueName + "=" + URLenc(val);
  }
  
  val = parseFloat(item.z);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item, "z"));
      }
    }
    purl += "&" + valueZName + "=" + URLenc(val);
  }

  return purl;
}

ZtXYZChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv, i,
  coords = [],
  fields = [],
  labval = [];
  if (!Empty(this.objConfig.fieldsGrid)) {
    fields = this.objConfig.fieldsGrid.slice();
    for (i = 0; i < fields.length; i++) {
      var coltitle = "";
      if (fields[i] == this.objConfig.keyField) {
        if (!Empty(this.objConfig.labelsGrid) && !Empty(this.objConfig.labelsGrid.key))
          coltitle = this.objConfig.labelsGrid.key;
      }
      else if (fields[i] == this.objConfig.labelSeries) {
        if (!Empty(this.objConfig.labelsGrid) && !Empty(this.objConfig.labelsGrid.serie))
          coltitle = this.objConfig.labelsGrid.serie;
      }
      else {
        labval = [];
        if (!Empty(this.objConfig.labelsGrid.values))
          labval = this.objConfig.labelsGrid.values.split(",");
        if (fields[i] == this.objConfig.labelField) {
          coltitle = "x";
          if (!Empty(labval[0]))
            coltitle = labval[0];
        }
        else if (fields[i] == this.valueFields[0]) {
          coltitle = "y";
          if (!Empty(labval[1]))
            coltitle = labval[1];
        }
        if (this.isZ) {
          if (fields[i] == this.valueFields[1]) {
            coltitle = "z";
            if (!Empty(labval[2]))
              coltitle = labval[2];
          }
        }
      }
      coords.push(coltitle);
    }
  }
  else {
    if (!Empty(this.objConfig.keyField)) {
      coords.push("");
      fields.push(this.objConfig.keyField);
    }
    coords.push("");
    fields.push(this.objConfig.labelSeries);
    coords.push("x");
    fields.push(this.objConfig.labelField);
    coords.push("y");
    fields.push(this.valueFields[0]);
    if (this.isZ) {
      coords.push("z");
      fields.push(this.valueFields[1]);
    }  
    if (!Empty(this.objConfig.labelsGrid)) {
      var progrIndex = 0;
      if (this.keyField.series) {
        if (!Empty(this.objConfig.labelsGrid.key))
          coords[progrIndex] = this.objConfig.labelsGrid.key;
        progrIndex++;
      }
      if (!Empty(this.objConfig.labelsGrid.serie))
        coords[progrIndex] = this.objConfig.labelsGrid.serie;
      progrIndex++;
      if (!Empty(this.objConfig.labelsGrid.values)) {
        labval = this.objConfig.labelsGrid.values.split(",");
        if (!Empty(labval[0]))
          coords[progrIndex] = labval[0];
        progrIndex++;
        if (!Empty(labval[1]))
          coords[progrIndex] = labval[1];
        progrIndex++;
        if (this.isZ) {
          if (!Empty(labval[2]))
            coords[progrIndex] = labval[2];
        }
      }
    }
  }

  for (i = 0; i < coords.length; i++) {
    td = document.createElement("td");
    td.className = "grid_title grid_cell_title grid_cell_title_table";
    innerdiv = document.createElement("div");
    // testo colonne campi
    innerdiv.textContent = coords[i];
    td.appendChild(innerdiv);
    thead.appendChild(td);
  }

  //table content
  this.__gfields = fields.slice();
  for (i = 0; i < this.dataSet.length; i++) {
    var vals = this.dataSet[i],
    row = document.createElement("tr");
    row.style.height = "42px";
    if (i == 0 || i % 2 == 0) {
      row.className = "grid_rowodd";
    }
    else {
      row.className = "grid_row";
    }
    for (var b = 0; b < fields.length; b++) {
      var cell = document.createElement("td"),
      div3 = document.createElement("div"),
      idx = this.propertyName.indexOf(fields[b]);
      div3.textContent = this._GetGridCellValue(vals[idx], idx, vals);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}

ZtXYZChart.prototype._GetParseDrawingList = function () {
  var _this = this;
  return this.orgSeriesList
    .slice()
    .map(function (el) {
      var t_el = el;
      if (_this.seriesIsTime)
        t_el = _this.stdFormat(el);
      return replaceSpecialCharsForID(t_el);
    });
}

ZtXYZChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  if (this.propertyName[dataidx] == this.objConfig.labelSeries)
    return value;
  if (this.propertyName[dataidx] == this.objConfig.keyField)
    return value;
  // apply picture + funzione
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture) {
      var item = this._FindItemForGrid(record),
      field = "";
      if (dataidx == this.xIndex)
        field = "x";
      else if (dataidx == this.yIndex)
        field = "y";
      else if (dataidx == this.zIndex)
        field = "z";
      return this.functionObj.GetValuePicture(this._GetItemForGrid(item, field));
    }
  }
  else
    return this.GetValuePicture(value);
}

ZtXYZChart.prototype._FindItemForGrid = function (record) {
  var _this = this,
  all_itms = this._GetItems(),
  filter = all_itms.filter(function (item) {
    var found = ( item.x == record[_this.xIndex] &&
                  item.y == record[_this.yIndex] );
    if (!Empty(_this.objConfig.keyField))
      found = found && (item.keyField == record[_this.seriesIndex]);
    else
      found = found && (item.series == record[_this.seriesIndex]);
    return found;
  });
  return filter[0];
}

ZtXYZChart.prototype._GetItemForGrid = function (item, field) {
  var itm = {
    key: item.keyField || item.keyF,
    serie: item.series
  };
  itm.value = item[field];
  switch (field) {
    case "x":
      itm.field = this.propertyName[this.xIndex];
      break;
    case "y":
      itm.field = this.propertyName[this.yIndex];
      break;
    case "z":
      itm.field = this.propertyName[this.zIndex];
      break;
  }
  return itm;
}

ZtXYZChart.prototype._GetItemObj = function (itemObject) {
  var row = -1,
  _this = this;
  this._ZtChart.orgData.filter(function (rec, index) {
    if (rec[_this.xIndex] == itemObject.x &&
        rec[_this.yIndex] == itemObject.y &&
        rec[_this.seriesIndex] == itemObject.series) {
          row = index;
          if (_this.isZ && rec[_this.zIndex] == itemObject.z)
            return true;
          return true;
        }
    return false;
  });
  
  var ret = {
    series: itemObject.series,
    range: itemObject.range,
    selIdx: itemObject.idx,
    rowIdx: row,
    categoryCode: itemObject.categoryCode,
    keyF: itemObject.keyField,
    x: itemObject.x,
    y: itemObject.y,
    z: itemObject.z,
    isSelected: itemObject.isSelected,
    focus: itemObject.focus,
    multidimCurrentKey: this.appliedKey,
    color: itemObject.color
  };
  return ret;
}