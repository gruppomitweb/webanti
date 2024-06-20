function ZtMatrixChart() {
  ZtTreeChart.apply(this, ["MATRIX"]);
  this.isH = true;
}
ZtMatrixChart.prototype = Object.create(ZtBarChart.prototype);
ZtMatrixChart.prototype.constructor = StdChart;

ZtMatrixChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.domainAxis = this.chartConfig.graphSettings.domainAxis;
  this.defSettings.domainAxis.domainLine.color = "transparent";
  this.defSettings.domainAxis.useValueFont = false;
  this.defSettings.domainAxis.useGlobalFont = true;
  this.defSettings.matrix = this.chartConfig.graphSettings.extends.matrix;
}

ZtMatrixChart.prototype._SetCalculationDataset = function () {
  var addFields = [];
  if (this.categoryCodeIndex >= 0)
    addFields.push( { prop: "categoryCode", index: this.categoryCodeIndex } );
  var fobj = getMatrixLinksDataset(this.dataSet, this.levelsFields, this.valueFields, this.propertyName, this.objConfig.oneDomain, addFields);
  if (fobj.links)
    this.calcDataset = fobj.links;
  if (fobj.array)
    this.categoryList = fobj.array;
  if (fobj.array_2)
    this.categoryList_2 = fobj.array_2;
}

ZtMatrixChart.prototype._SetFieldsIndexes = function () {
  ZtSunburstChart.prototype._SetFieldsIndexes.call(this);
}

ZtMatrixChart.prototype._SetLists = function () {
  ZtSunburstChart.prototype._SetLists.call(this);
  this.allValues = getList(this.yIndex, this.dataSet);
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);
}

ZtMatrixChart.prototype._SetScales = function () {
  this.scaleX = d3.scaleBand().domain(this.categoryList);
  this.scaleX2 = d3.scaleBand().domain(this.categoryList_2);
}

ZtMatrixChart.prototype._SetDomainScaleParameters = function (scale, position) {
  //scale.padding(0.1);
  if (position == "Left")
    scale.range([0, this.scaleSize]);
  else
    scale.range([0, this.scale2Size]);
}

ZtMatrixChart.prototype._DrawAxis = function () {
  this.scaleSize = this.chartHeight;
  this.scale2Size = this.chartWidth;
  this._SetDomainScaleParameters(this.scaleX, "Left");
  this._SetDomainScaleParameters(this.scaleX2, "Top");
  var scale_1band = this.scaleX.bandwidth(),  // height
  scale_2band = this.scaleX2.bandwidth(), // width
  theoricalBand,
  newSize;

  if (scale_1band > scale_2band) {
    theoricalBand = this.chartWidth / this.categoryList_2.length;
    newSize = theoricalBand * this.categoryList.length;
    this.scaleSize = newSize;
  }
  else {
    theoricalBand = this.chartHeight / this.categoryList.length;
    newSize = theoricalBand * this.categoryList_2.length;
    this.scale2Size = newSize;
  }

  // se e' hide non disegno, altrimenti valuto la proprieta'
  if(this.defSettings.matrix.domainAxisMatrix == "both"){
    this.DrawDomainAxis("_axis1", this.scaleX, "Left");
    this.DrawDomainAxis("_axis2", this.scaleX2, "Top");
  } 
  else if(this.defSettings.matrix.domainAxisMatrix == "left"){
      this.DrawDomainAxis("_axis1", this.scaleX, "Left");
  } 
  else if(this.defSettings.matrix.domainAxisMatrix == "top"){
      this.DrawDomainAxis("_axis2", this.scaleX2, "Top");
  } 
}

ZtMatrixChart.prototype._SetAxisColor = function () {
  // se e' hide non disegno, altrimenti valuto la proprieta'
  if(this.defSettings.matrix.domainAxisMatrix == "both"){
    this.SetAxisColor("domain", "x2", -3, false, "_axis1");
    this.SetAxisColor("domain", "y2", -3, false, "_axis2");
  } 
  else if(this.defSettings.matrix.domainAxisMatrix == "left"){
    this.SetAxisColor("domain", "x2", -3, false, "_axis1");
  } 
  else if(this.defSettings.matrix.domainAxisMatrix == "top"){
    this.SetAxisColor("domain", "y2", -3, false, "_axis2");
  } 
}

ZtMatrixChart.prototype._SetAxisFont = function () {
  // se e' hide non disegno, altrimenti valuto la proprieta'
  if(this.defSettings.matrix.domainAxisMatrix == "both"){
    this.SetAxisFont("domain", "_axis1");
    this.SetAxisFont("domain", "_axis2");
    this._SetAxisLabelOrientation("domain", "V", "_axis2");
  } 
  else if(this.defSettings.matrix.domainAxisMatrix == "left"){
    this.SetAxisFont("domain", "_axis1");
  } 
  else if(this.defSettings.matrix.domainAxisMatrix == "top"){
    this.SetAxisFont("domain", "_axis2");
    this._SetAxisLabelOrientation("domain", "V", "_axis2");
  } 
}

ZtMatrixChart.prototype._DrawChartPlotElements = function () {
  this._DrawAxis();
}

ZtMatrixChart.prototype._DrawChartElements = function () {
  this.renderer.append("rect")
    .attr("id", this.chartId + "matrixBase")
    .attr("x", this.margin.left)
    .attr("y", this.margin.top)
    .attr("width", this.scale2Size - 3)
    .attr("height", this.scaleSize);

  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform","translate(" + [this.margin.left - 3, this.margin.top] + ")");
  this.DrawMatrix(group, this.calcDataset);

  this._DrawGridLines();
}

ZtMatrixChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var colorsObj = {},
  filter,
  light,
  dark,
  _this = this;

  for (var i = 0; i < this.items.length; i++) {
    var list_1,
    list_2;
        if (this.defSettings.matrix.orientationColor == "horizontally"){
          list_1 = this.items[i].source;
          list_2 = _this.items[i].target;
        }
        else {
          list_1 = this.items[i].target;
          list_2 = _this.items[i].source;          
        }
      if (Empty(colorsObj[list_1])) {
        filter = this.items.filter(function(d) { if(d.source == list_2) return true; });
        filter = filter.map(function(d) { return d.value; });
        colorsObj[list_1] = {};
        colorsObj[list_1].array = filter.unique().sort(function(a, b) { return a-b; });
        light = getColorsArrayLighter(this.colorSet[list_1].color, 11).reverse()[0].color;
        dark = getColorsArrayDarker(this.colorSet[list_1].color, 11).reverse()[0].color;
        colorsObj[list_1].scale = d3.scaleLinear()
                                              .domain([0, colorsObj[list_1].array.length / 2, colorsObj[list_1].array.length])
                                              .range([light, this.colorSet[list_1].color, dark])
                                              .interpolate(d3.interpolateRgb);
      }
      //value = colorsObj[list_1].array.indexOf(this.items[i].value);
      this.items[i].color = this.colorSet[list_1];
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString({ fill : this.items[i].color.color }, d3.select(this.items[i].itm).attr("style")));
    }

  var fillECell = "transparent";
  if (!Empty(this.defSettings.matrix.emptyCell))
    fillECell = this.defSettings.matrix.emptyCell;
  d3.select("#" + this.chartId + "matrixBase").attr("style", makeStyleHTMLString({ fill : fillECell }, d3.select("#" + this.chartId + "matrixBase").attr("style")));
}

ZtMatrixChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec/*, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  var myM = {};

  myM = setMarginObject("W", settings.globalFont, true, settings.globalFont);
  if (myM != 0) {
    myM.offset = 5;
    ret.left.push(myM);
  }
  myM = setMarginObject("W", settings.globalFont, true, settings.globalFont);
  if (myM != 0) {
    myM.offset = 5;
    ret.top.push(myM);
  }
  // if both + left
  if(this.defSettings.matrix.domainAxisMatrix == "both" || this.defSettings.matrix.domainAxisMatrix == "left"){
    //categorie
    var appliedfont, format;
    if (!Empty(categoryList) && settings.domainAxis.show) {
      appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);
      if (domainIsTime) {
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
        myM.text = getMaxWordLength(categoryList);

      myM.textorientation = 0;
      myM.type = "domainAxis_axis1";
      ret.left.push(myM);
    }

    //ticks - domainAxis
    if (settings.domainAxis.show) {
      appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);
      myM.text = ""; //ipotesi
      myM.addH = 6; //TICK HEIGHT 6
      myM.addW = 6;
      myM.textorientation = 0;
      ret.left.push(myM);
    }
  }
  //end if

  // if both + top
  if(this.defSettings.matrix.domainAxisMatrix == "both" || this.defSettings.matrix.domainAxisMatrix == "top"){
    //categorie
    if (!Empty(this.categoryList_2) && settings.domainAxis.show) {
      appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);
      if (domainIsTime) {
        if (Empty(settings.time.customFormat) && !Empty(settings.time.format))
          myM.text = settings.time.format;
        else if (!Empty(settings.time.customFormat) && Empty(settings.time.format)) {
          format = getTimeTickFormat(localeLangFormat, settings.time.customFormat);
          myM.text = getMaxWordLength(this.categoryList_2, null, format);
        }
      }
      else if (domainIsNumber)
        myM.text = getMaxWordLength(this.categoryList_2, domprec);
      else
        myM.text = getMaxWordLength(this.categoryList_2);

      myM.textorientation = 0;
      myM.type = "domainAxis_axis2";
      ret.top.push(myM);
    }

    //ticks - domainAxis
    if (settings.domainAxis.show) {
      appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
      myM = getGenericLabelConf(appliedfont);
      myM.text = ""; //ipotesi
      myM.addH = 6; //TICK HEIGHT 6
      myM.addW = 6;
      myM.textorientation = 90;
      ret.top.push(myM);
    }
  }
  //end if
  return ret;
}

ZtMatrixChart.prototype._SupportFilter = function () {
  return false;
}

ZtMatrixChart.prototype._SupportChangeOrder = function () {
  return false;
}

ZtMatrixChart.prototype._GetDrawingList = function () {
  return this.categoryList;
}

ZtMatrixChart.prototype._GetOppositeAxisDrawingList = function () {
  return this.categoryList;
}

ZtMatrixChart.prototype._SetAxisLabelOrientation = function (axisType, orientation, axId) {
  axId = axId || "";
  var ticks = this.svg.select("#" + this.chartId + axisType + "AxisGroup" + axId).selectAll("text")._groups[0],
  textTick,
  textRect,
  offsetTick = 6;
  for (var i = 0; i < ticks.length; i++) {
    textTick = d3.select(ticks[i]);
    textTick.attr("y", 1.5 * offsetTick);
    textRect = textTick.node().getBBox();
    textTick.attr("transform", "rotate(-90) translate(" + [-(textRect.x - offsetTick), - (textRect.y + textRect.height / 2)] + ")");
  }
}

ZtMatrixChart.prototype._GetValuesPrecision = function () {
  return 0;
}

ZtMatrixChart.prototype._GetDomainPrecision = function () {
  return 0;
}

ZtMatrixChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  value = d3.select(elem).attr("width");

  d3.select(elem)
    .attr("width", 0)
    .transition()
      .delay(item.source * (duration / div))
      .duration(duration / div)
      .ease(d3.easeLinear)
      .attr("width", value);
}

ZtMatrixChart.prototype._GetAnimatedDivisor = function () {
  return Math.max(this.categoryList.length, this.categoryList_2.length);
}

ZtMatrixChart.prototype._DrawGridLines = function () {
  this._DrawHorizontalGrid();
  this._DrawVerticalGrid();
}

ZtMatrixChart.prototype._DrawHorizontalGrid = function () {
  if (this.defSettings.matrix.grid.view == "none" || this.defSettings.matrix.grid.view == "vertical")
    return;

  var cellHeight = this.scaleX.bandwidth(),
  w = this.scaleX2.bandwidth() * this.categoryList_2.length,
  grid,
  len = this.categoryList.length;

  if (Empty(this.svg.select("#" + this.chartId + "horizontalGridline").node()))
    grid = this.renderer.append("g")
            .attr("id", this.chartId + "horizontalGridline")
            .attr("transform", "translate(" + [this.margin.left - 3, this.margin.top] + ")");

  for (var i = 0; i <= len; i++) {
    grid.append("line")
      .attr("class", "domainGridline TRANSP")
      .attr("x1", 0)
      .attr("y1", i * cellHeight)
      .attr("x2", w)
      .attr("y2", i * cellHeight);
    }
}

ZtMatrixChart.prototype._DrawVerticalGrid = function () {
  if (this.defSettings.matrix.grid.view == "none" || this.defSettings.matrix.grid.view == "horizontal")
    return;

  var cellWidth = this.scaleX2.bandwidth(),
  h = this.scaleX.bandwidth() * this.categoryList.length,
  grid,
  len = this.categoryList_2.length;

  if (Empty(this.svg.select("#" + this.chartId + "verticalGridline").node()))
    grid = this.renderer.append("g")
            .attr("id", this.chartId + "verticalGridline")
            .attr("transform", "translate(" + [this.margin.left - 3, this.margin.top] + ")");

  for (var i = 0; i <= len; i++) {
    grid.append("line")
      .attr("class", "domainGridline TRANSP")
      .attr("x1", i * cellWidth)
      .attr("y1", 0)
      .attr("x2", i * cellWidth)
      .attr("y2", h);
    }
}

ZtMatrixChart.prototype._SetAxisGridColor = function () {
  this.SetAxisGridColor("horizontal");
  this.SetAxisGridColor("vertical");
}

ZtMatrixChart.prototype.SetAxisGridColor = function (type/*, circular*/) {
  var gridGrp = this.svg.select("#" + this.chartId + type + "Gridline");
  if (Empty(gridGrp.node()) ||  Empty(gridGrp.node().childNodes))
    return;
  var chd = gridGrp.selectAll("line"),
  stObj = {},
  gobj = this.defSettings.matrix.grid;

  if (gobj.type) {
    switch (gobj.type.toLowerCase()) {
      case "long_dashed":
        stObj = {
          stroke9linecap : "butt",
          stroke9dasharray : "10,6",
          shape9rendering : "crispEdges",
          stroke9width : gobj.stroke
        };
        break;
      case "dotted":
        stObj = {
          stroke9linecap : "round",
          stroke9dasharray : "0.01,4",
          stroke9linejoin : "round",
          stroke9width : "1.5px",
          shape9rendering : "auto"
        };
        break;
      case "plain":
        stObj = {};
        stObj.shape9rendering = "crispEdges";
        stObj.stroke9width = gobj.stroke;
        break;
      default : // small_dashed
        stObj = {
          stroke9linecap : "butt",
          stroke9dasharray : "2,2",
          shape9rendering : "crispEdges",
          stroke9width : gobj.stroke
        };
        break;
    }
  }
  stObj.stroke = gobj.color;
  chd.attr("style", makeStyleHTMLString(stObj, chd.attr("style")));
}

ZtMatrixChart.prototype._SetElementsRangeColor = function (isFnc) {
  var styleObj,
  fill;
  for (var i = 0; i < this.items.length; i++) {
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
  }
}

ZtMatrixChart.prototype._GetBarWidthFromDomainEvaluation = function () { }

ZtMatrixChart.prototype._GetListForColors = function () {
  return this.categoryList_2;
}

ZtMatrixChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "";
  purl += "&source=" + URLenc(itemObject.sourceDesc);
  purl += "&target=" + URLenc(itemObject.targetDesc);
  if (!Empty(itemObject.value)) {
    var val = itemObject.value;
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject));
      }
    }
    purl += "&value=" + URLenc(val);
  }
  return purl;
}

ZtMatrixChart.prototype._GetParametersStringForLink = function (item) {
  var purl = "",
  linkObj = this.linkObj,
  valueName = Empty(linkObj.valuename) ? "value" : linkObj.valuename;

  purl += "source=" + URLenc(item.sourceDesc);
  purl += "&target=" + URLenc(item.targetDesc);
  if (!Empty(item.value)) {
    var val = item.value;
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
      }
    }
    purl += "&" + valueName + "=" + URLenc(val);
  }
  return purl;
}

ZtMatrixChart.prototype._GetItemObj = function (itemObject) {
  var ret = {
    sourceDesc: itemObject.sourceDesc,
    targetDesc: itemObject.targetDesc,
    value: Empty(this.valueFields) ? null : itemObject.value,
    rowIdx: itemObject.data_index,
    categoryCode: itemObject.categoryCode,
    isSelected : itemObject.isSelected,
    multidimCurrentKey : this.appliedKey,
    color: itemObject.color
  };
  return ret;
}

ZtMatrixChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv,
  i,
  fields = this.levelsFields.slice(),
  coords;

  if (!Empty(this.valueFields))
    fields.push(this.valueFields);
  coords = fields.slice();

  if (!Empty(this.objConfig.labelsGrid)) {
    var progrIndex = 0;
    if (!Empty(this.objConfig.labelsGrid.key)) {
      var labval = this.objConfig.labelsGrid.key.split(","),
      end = !Empty(this.valueFields) ? coords.length - 1 : coords.length;
      for (i = 0; i < end; i++) {
        if (!Empty(labval[i]))
          coords[progrIndex] = labval[i];
        progrIndex++;
      }
    }

    if (!Empty(this.valueFields) && !Empty(this.objConfig.labelsGrid.values))
      coords[progrIndex] = this.objConfig.labelsGrid.values;
  }

  for (i = 0; i < coords.length; i++){
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
      div3.textContent = this._GetGridCellValue(vals[idx], (fields[b] == this.valueFields), vals);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}

ZtMatrixChart.prototype._GetGridCellValue = function (value, isValue, record) {
  if (!isValue)
    return value;
  // apply picture + funzione
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture) {
      var item = this._FindItemForGrid(record);
      return this.functionObj.GetValuePicture(item);
    }
  }
  else
    return this.GetValuePicture(value);
}

ZtMatrixChart.prototype._FindItemForGrid = function (record) {
  var itm = {},
  idx;

  // source
  idx = this.propertyName.indexOf(this.levelsFields[0]);
  itm.sourceDesc = record[idx];
  // target
  idx = this.propertyName.indexOf(this.levelsFields[1]);
  itm.targetDesc = record[idx];
  // value
  if (!Empty(this.valueFields)) {
    idx = this.propertyName.indexOf(this.valueFields);
    itm.value = record[idx];
  }

  return this._GetItemForGrid(itm);
}

ZtMatrixChart.prototype._GetItemForGrid = function (item) {
  var itm = {};
  itm.source = {};
  itm.source.value = item.sourceDesc;
  itm.source.field = this.levelsFields[0];
  itm.target = {};
  itm.target.value = item.targetDesc;
  itm.target.field = this.levelsFields[1];
  
  if (!Empty(this.valueFields)) {
    itm.value = item.value;
    itm.field = this.valueFields;
  }
  return itm;
}