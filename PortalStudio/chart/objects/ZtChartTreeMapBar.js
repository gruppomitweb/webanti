function ZtTreeMapBarChart(type, isH) {
  StdChart.apply(this, [type, "e911"]);
  this.isH = isH < 0 ? false : true;
  this.applyCalculationAfter = false;
}
ZtTreeMapBarChart.prototype = Object.create(ZtBarChart.prototype);
ZtTreeMapBarChart.prototype.constructor = ZtTreeMapBarChart;

ZtTreeMapBarChart.prototype._SetLists = function () {
  ZtTreeMapChart.prototype._SetLists.call(this);
  this.drawingCategories = this.categoryList = getList(this.propertyName.indexOf(this.levelsFields[0]), this.dataSet);
  this.orgSeriesList = this.legendList = getList(this.propertyName.indexOf(this.levelsFields[0]), this.dataSet);
}

ZtTreeMapBarChart.prototype._SetFieldsIndexes = function () {
  this.xIndex = this.propertyName.indexOf(this.objConfig.labelField.split(",")[0]);
  if (!Empty(this.objConfig.keyField)) { //MG VPV
    this.xLabelIndex = this.propertyName.indexOf(this.objConfig.labelField.split(",")[0]);
    this.xIndex = this.propertyName.indexOf(this.objConfig.keyField.split(",")[0]);//this.propertyName.indexOf(this.objConfig.keyField); //MG VPV
  }
}

ZtTreeMapBarChart.prototype._GetDomainIndex = function () {
  return this.propertyName.indexOf(this.objConfig.labelField.split(",")[0]);
}

ZtTreeMapBarChart.prototype._SetCalculationDataset = function () {
  //this.calcDataset = getTreemapDataset(this.dataSet, catIndex, this.valueFields, this.propertyName, this.seriesList, this.objConfig.keyField, groupbyCat, true);
  ZtTreeMapChart.prototype._SetCalculationDataset.call(this);

  if (this.appliedKey == this.chartId + "model") {  // multidim
    var scm = this._mdim,
    tmp = [];
    this.allValues = [];
    for (var i = 0; i < scm.keysList.length; i++) {
      tmp = getMaxValueStack(this.xIndex, this.valueFields, scm.allDataIndex[scm.keysList[i]], this.propertyName, true);
      this.allValues = this.allValues.concat(tmp);
    }
  }
  else
   // this.allValues = getMaxValueStack(this.xIndex, this.valueFields, this.dataSet, this.propertyName, true);
    this.allValues = getMaxValueStack(this.propertyName.indexOf(this.levelsFields[0]), this.valueFields, this.dataSet, this.propertyName, true); //MG VPV
  this.rangeminmax.max = d3.max(this.allValues);
}

ZtTreeMapBarChart.prototype._GetSingleRoot = function () {
  return false;
}

ZtTreeMapBarChart.prototype._SetChartSettingsJSON = function () {
  ZtBarChart.prototype._SetChartSettingsJSON.call(this);
  ZtTreeMapChart.prototype._SetChartSettingsJSON.call(this);
}

ZtTreeMapBarChart.prototype._GetValuesPrecision = function () {
  return 0;
}

ZtTreeMapBarChart.prototype._DrawAxis = function () {
  this.DrawDomainAxis();
}

ZtTreeMapBarChart.prototype._DrawGridLines = function () {
  this._DrawDomainAxisGrid();
}

ZtTreeMapBarChart.prototype._DrawValueAxisGrid = function () { }

ZtTreeMapBarChart.prototype._DrawAxisLabel = function () {
  var xInit, yInit, groupSize;
  if (this.isH) {
    xInit = this.margin.top + (this.chartHeight / 2);
    yInit = 0;
  }
  else {
    xInit = this.margin.left + (this.chartWidth / 2);
    yInit = this.margin.top + this.chartHeight;
    if (this.chartConfig.graphSettings.domainAxis.show) {
      groupSize = d3.select("#" + this.chartId + "domainAxisGroup").node().getBBox();
      yInit = this.margin.top + this.chartHeight + groupSize.height;
    }
  }
  this.DrawAxisLabel("domain", this._GetDomainAxisPosition(), xInit, yInit, this.defSettings.axisLabel.xLabel);
}

ZtTreeMapBarChart.prototype._SetDomainScaleParameters = function () {
  ZtBarChart.prototype._SetDomainScaleParameters.call(this);

  // valori simbolici - non ho un value axis
  var maxLength = this.isH ? this.chartWidth : this.chartHeight,
  maxValue = this.rangeminmax.max;
  this.scaleY = d3.scaleLinear().domain([0, maxValue]).range([0, maxLength]);
}

ZtTreeMapBarChart.prototype._DrawChartElements = function () {
  delete this.bandWidth;
  var barGrp,
  sizeW,
  sizeH,
  sizeL,
  sizeT,
  group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  pobj;

  for (var i = 0; this.calcDataset.children && i < this.calcDataset.children.length; i++) {
    /*if (!this._IsNotExcludedDomain(this.calcDataset.children[i].name))
      continue;*/
    if (this.isH) {
      sizeW = this.scaleY(this.allValues[i]);
      sizeH = this._GetBarWidthFromDomainEvaluation()//this.scaleX.bandwidth();
      sizeL = 0;
      sizeT = this.scaleX(this.calcDataset.children[i].name); //this.scaleX(this.dataSet[i][this.xIndex]);
    }
    else {
      sizeW = this._GetBarWidthFromDomainEvaluation()//this.scaleX.bandwidth();
      sizeH = this.scaleY(this.allValues[i]);
      sizeL = this.scaleX(this.calcDataset.children[i].name); //this.scaleX(this.dataSet[i][this.xIndex]);
      sizeT = this.scaleY(d3.max(this.scaleY.domain())) - this.scaleY(this.allValues[i]);
    }
    pobj = { x: sizeL,
             y: sizeT,
             width: sizeW,
             height: sizeH };
    barGrp = group.append("g")
      .attr("transform", "translate(" + [sizeL, sizeT] + ")");
    this.DrawTreeMap(barGrp, this.calcDataset.children[i], pobj);
  }
}

ZtTreeMapBarChart.prototype._SetAxisColor = function () {
  if (this.isH)
    this.SetAxisColor("domain", "x2", -3);
  else
    this.SetAxisColor("domain", "y2", 3);
}

ZtTreeMapBarChart.prototype._SetAxisGridColor = function () {
  this.SetAxisGridColor("domain");
}

ZtTreeMapBarChart.prototype._SetAxisFont = function () {
  this.SetAxisFont("domain");
  this._SetAxisLabelOrientation("domain", this.defSettings.domainAxis.labelType);
}

ZtTreeMapBarChart.prototype._SetAxisLabelFont = function () {
  this.SetAxisLabelFont("domain");
}

ZtTreeMapBarChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  stroke,
  gradID;
  for (var i = 0; i < this.items.length; i++) {
    //idx = this.valueFields.indexOf(this.items[i].valueField);
    idx = this.orgSeriesList.indexOf(this.items[i].series);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.orgCategoryList.indexOf(this.items[i].name);
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      var styleObj = {};
      gradID = this.chartId + this.type + "_" + idx + "Gradient";
      if (!Empty(this.items[i].color.color) && Empty(this.items[i].color.gradient) || this.items[i].color.color.toLowerCase() == this.items[i].color.gradient.toLowerCase())
        stroke = this.items[i].color.color;
      else if (Empty(this.items[i].color.color) && !Empty(this.items[i].color.gradient))
        stroke = this.items[i].color.gradient;
      else {
        this.CreateGradient(this.items[i].color.color, this.items[i].color.gradient, gradID, "element");
        stroke = "url(#" + gradID + ")";
      }
      styleObj.fill = stroke;
      styleObj.stroke9width = 1 + "px";
      styleObj.stroke = "#F3F3F3";
      styleObj.shape9rendering = "crispEdges";
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtTreeMapBarChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont/*, rangebandslabels*/) { // eslint-disable-line max-len
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

    //categorie
    var appliedfont, format, myTa, k;
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
            myTa = [];
            for (k = 0; k < categoryList.length; k++)
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
  }
  else {
    //xlabel
    myM = setMarginObject(settings.axisLabel.xLabel, settings.axisLabel.axisFont, settings.axisLabel.useGlobalFont, settings.globalFont);
    if (myM != 0) {
      myM.offset = 5;
      ret.bottom.push(myM);
    }

    //categorie
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
            myTa = [];
            for (k = 0; k < categoryList.length; k++)
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
  }

  //categorie escluse
  if (!Empty(excludedC)) {
    myM = setMarginObject(getMaxWordLength(excludedC), defaultExcludedFont);
    if (myM !=0 )
      ret.bottom.push(myM);
  }

  //serie escluse
  if (chartLegends.series && (chartLegends.series.position=="hide" || chartLegends.series.hide)) {
    if (!Empty(excludedS))
      myM = setMarginObject(getMaxWordLength(excludedS), defaultExcludedFont);
    if (myM != 0)
      ret.top.push(myM);
  }

  return ret;
}

ZtTreeMapBarChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  ZtTreeMapChart.prototype._GetDefaultAnimateFunction.call(this, item, lastValueObj, duration);
}

ZtTreeMapBarChart.prototype._GetOtherAnimateFunction = function (item, lastValueObj) {
  ZtTreeMapChart.prototype._GetOtherAnimateFunction.call(this, item, lastValueObj);
}

ZtTreeMapBarChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this.RemoveAllPatterns();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  treemap,
  hie,
  item,
  sizeH,
  sizeW,
  data;

  this._DrawPatterns();

  for (var i = 0; i < this.calcDataset.children.length; i++) {
    if (this.isH) {
      sizeW = this.scaleY(this.allValues[i]);
      sizeH = this.scaleX.bandwidth();
      var sizeL = 0;
      var sizeT = this.scaleX(this.dataSet[i][this.xIndex]);
    }
    else {
      sizeW = this.scaleX.bandwidth();
      sizeH = this.scaleY(this.allValues[i]);
      sizeL = this.scaleX(this.dataSet[i][this.xIndex]);
      sizeT = this.scaleY(d3.max(this.scaleY.domain())) - this.scaleY(this.allValues[i]);
    }

    treemap = d3.treemap().size([sizeW, sizeH]),
    hie = d3.hierarchy(this.calcDataset.children[i]),
    treemap( hie.sum( function(d) { return d.size; } ) );
    data = hie.leaves();

    for (var j = 0; j < data.length; j++) {
      record = data[j];
      var found = false;
      for (var k = 0; !found && k < this.items.length; k++) {
        item = this.items[k];

        if (this._CheckIdentityItemFromData(item, record.data) && item.itm) {
          found = true;

          lastValues = {};
          lastValues.width = item.width;
          lastValues.height = item.height;
          lastValues.x = item.x;
          lastValues.y = item.y;

          item.value = record.data.realValue;
          item.x = record.x0;
          item.y = record.y0;
          item.width = record.x1 - record.x0;
          item.height = record.y1 - record.y0;

          d3.select(item.itm).attr("x", item.x);
          d3.select(item.itm).attr("width", item.width);
          d3.select(item.itm).attr("y", item.y);
          d3.select(item.itm).attr("height", item.height);

          d3.select(item.itm.parentNode).attr("transform", "translate(" + [sizeL, sizeT] + ")");

          if (item.value < 0)
            this.ApplyPatternOnItem(item, "negativeValuePattern");
          this._GetOtherAnimateFunction(item, lastValues);
        }
      }
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtTreeMapBarChart.prototype._CheckIdentityItemFromData = function (itemOrg, itemOth) {
  return ZtTreeMapChart.prototype._CheckIdentityItemFromData.call(this, itemOrg, itemOth);
}

ZtTreeMapBarChart.prototype._SetAxisLabelsPositions = function () {
  if (!this.isH)
    return;
  var axisLabelD = this.svg.select("#" + this.chartId + "domainAxisLabel"),
  y;
  if (!Empty(axisLabelD.node())) {
    y = parseFloat(axisLabelD.attr("y"));
    var offset = 5;
    var upd = false;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == "left") {
      y = y + getOffsetHeight(this.chartTitle, appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont), this.chartId);
      upd = true;
    }
    if (!Empty(this.legendList) && this.chartLegends.series.position == "left") {
      var legend = parseFloat(d3.select("#" + this.chartId + "legend_container_rect").attr("width"));
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

ZtTreeMapBarChart.prototype._AfterCalculation = function (mchart) {
  mchart.rangeminmax.max = Math.max(mchart.rangeminmax.max, d3.max(this.allValues));
}

ZtTreeMapBarChart.prototype._MapAllValues = function (anotherStd) {
  this.rangeminmax.max = anotherStd.rangeminmax.max;
}

ZtTreeMapBarChart.prototype._GetFilteredDataTreemap = function (data) {
  return data;

  var fdata = {},
  aList = this._GetAxisDrawingList();

  fdata.name = data.name;
  fdata.children = data.children.filter( function (child) {
                                    return aList.indexOf(child.serie) >= 0;
                                  }
                                );

  return fdata;
}

ZtTreeMapBarChart.prototype._ApplyPatterns = function () {
  ZtTreeMapChart.prototype._ApplyPatterns.call(this);
}

ZtTreeMapBarChart.prototype._GetValueLabelX = function (pos, item, text, font) {
  var tmp = StdChart.prototype._GetValueLabelX.call(this, pos, item, text, font);
  tmp = tmp + item.transform[0];
  return tmp;
}

ZtTreeMapBarChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  var tmp = StdChart.prototype._GetValueLabelY.call(this, pos, item, text, font);
  tmp = tmp + item.transform[1];
  return tmp;
}

ZtTreeMapBarChart.prototype._DrawValueLabels = function () {
  ZtTreeMapChart.prototype._DrawValueLabels.call(this);
}

ZtTreeMapBarChart.prototype._CreateGrid = function (thead, tbody1) {
  ZtTreeMapChart.prototype._CreateGrid.call(this, thead, tbody1);
}

ZtTreeMapBarChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  return ZtTreeMapChart.prototype._GetGridCellValue.call(this, value, dataidx, record);
}

ZtTreeMapBarChart.prototype._FindItemForGrid = function (record) {
  return ZtTreeMapChart.prototype._FindItemForGrid.call(this, record);
}

ZtTreeMapBarChart.prototype._GetParentPath = function (item) {
  return ZtTreeMapChart.prototype._GetParentPath.call(this, item);
}

ZtTreeMapBarChart.prototype._GetItemForGrid = function (item) {
  return ZtTreeMapChart.prototype._GetItemForGrid.call(this, item);
}

ZtTreeMapBarChart.prototype._GetItemObj = function (itemObject) {
  return ZtTreeMapChart.prototype._GetItemObj.call(this, itemObject);
}