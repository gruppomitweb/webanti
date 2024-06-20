function ZtAsterChart() {
  ZtPieChart.apply(this);
  this.type = "ASTER";
  this.legendHexCode = "e902";
}
ZtAsterChart.prototype = Object.create(ZtPieChart.prototype);
ZtAsterChart.prototype.constructor = ZtAsterChart;

ZtAsterChart.prototype._SetFieldsIndexes = function () {
  ZtXYZChart.prototype._SetFieldsIndexes.call(this);
}

ZtAsterChart.prototype.SetDomainType = function () {
  ZtXYZChart.prototype.SetDomainType.call(this);
}

ZtAsterChart.prototype._SetSeriesList = function () {
  ZtXYZChart.prototype._SetSeriesList.call(this);
}

ZtAsterChart.prototype._SetLists = function () {
  ZtXYZChart.prototype._SetLists.call(this);
}

ZtAsterChart.prototype._EvaluateAllValues = function () {
  ZtXYZChart.prototype._EvaluateAllValues.call(this);
  this._xRange = {};
  var upd = false;
  if (!Empty(this.objConfig.minFields)) {
    upd = true;
    this._xRange.min = d3.min(getList(this.propertyName.indexOf(this.objConfig.minFields), this.dataSet));
  }
  if (!Empty(this.objConfig.maxFields)) {
    upd = true;
    this._xRange.max = d3.max(getList(this.propertyName.indexOf(this.objConfig.maxFields), this.dataSet));
  }
  if (!upd)
    delete this._xRange;
}

ZtAsterChart.prototype._SetCategoryList = function () {
  ZtXYZChart.prototype._SetCategoryList.call(this);
}

ZtAsterChart.prototype._SetScales = function () {
  if (this.domainIsNumber) {
    this.allValuesX = this.allValuesX.map( function (val) { return parseFloat(val); });
    var min = d3.min(this.allValuesX),
    max = d3.max(this.allValuesX);
    if (this._xRange) {
      if (!Empty(this._xRange.min) || this._xRange.min == 0)
        min = this._xRange.min;
      if (!Empty(this._xRange.max) || this._xRange.max == 0)
        max = this._xRange.max;
    }    
    this.scaleX = d3.scaleLinear().domain([min, max]);
  }
}

ZtAsterChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = -1,
  id = "",
  group,
  radius,
  innerRadius,
  arc,
  radiusOffset = 4,
  domainLabelH = 0,
  slice = 7,
  _this = this;

  if (!Empty(this.defSettings.slice.percent + "") && !isNaN(this.defSettings.slice.percent))
    slice = this.defSettings.slice.percent;

  this._DrawPatterns();

  this.totalValueLabel = {};
  //if (this.seriesList.length > 1)
    //domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId); -> in xy non faccio multi-torta

  for (var i = 0; i < positions.length; i++) {
    radius = Math.min(positions[i].width, positions[i].height) / 2;
    radius = radius - domainLabelH;
    radius = radius - radius * 0.05;  // tolgo il 5% per dare un po' di spazio al disegno
    radius = radius - ((radius * slice / 100) / 4);
    this.radius = radius;
    innerRadius = this._GetInnerRadius();
    arc = d3.arc()
      .innerRadius(innerRadius);
    this.scaleX.range([innerRadius, this.radius]);
    yIndex = this.yIndex;

    this._SetTotalValueLabelObject(this.dataSet, positions[i].width, positions[i].height, this.valueFields[i], yIndex, this.totalValueLabel);
    if (this.totalValueLabel[this.valueFields[i]] && !Empty(this.totalValueLabel[this.valueFields[i]].text)) {
      if (this.defSettings.valueLabel.position == "top" || this.defSettings.valueLabel.position == "bottom")
        this.radius = this.radius - (this.totalValueLabel[this.valueFields[i]].height + radiusOffset);
    }
    arc.outerRadius(function (d) {
      return _this.scaleX(d.data[_this.xIndex]);
    });

    id = this.chartId + i + "_";
    this.multiMargins[this.valueFields[i]] = {   x : this.margin.left + positions[i].x,
                                      y : this.margin.top + positions[i].y,
                                      w : positions[i].width,
                                      h : positions[i].height
                                  };
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      .attr("transform","translate(" + [positions[i].width / 2, positions[i].height / 2] + ")");
    this.DrawAsterPie(group, this.dataSet, i, this.xIndex, yIndex, id, arc);
    if (this.seriesList.length > 1)
      this.DrawDomainLabel(i, positions[i], this.seriesList[this.valueFields[i]]);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtAsterChart.prototype._GetInnerRadius = function (radius) {
  radius = radius || this._GetRadius();
  if (Empty(this.defSettings.radius) || isNaN(this.defSettings.radius.inner))
    return radius * 0.25;
  else
    return radius * (this.defSettings.radius.inner / 100);
}

ZtAsterChart.prototype._GetDivisor = function () {
  return this.valueFields.length;
}

ZtAsterChart.prototype._GetDrawingList = function () {
  return this.drawingSeries;
}

ZtAsterChart.prototype._GetReferredList = function () {
  return ZtXYZChart.prototype._GetReferredList.call(this);
}

ZtAsterChart.prototype._GetReferredExcludedList = function () {
  return ZtXYZChart.prototype._GetReferredExcludedList.call(this);
}

ZtAsterChart.prototype._SupportFilter = function () {
  return ZtXYZChart.prototype._SupportFilter.call(this);
}

ZtAsterChart.prototype._SetElementsColor = function () {
  ZtXYZChart.prototype._SetElementsColor.call(this);
}

ZtAsterChart.prototype._SetSeriesIndex = function (/*val*/) {
  return 0;
}

ZtAsterChart.prototype._SupportChangeOrder = function () {
  return ZtXYZChart.prototype._SupportChangeOrder.call(this);
}

ZtAsterChart.prototype._GetAxisDrawingList = function () {
  return this.orgSeriesList;
}

ZtAsterChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "",
  _this = this, //._ZtChart.StdChart,
  val;

  if (!Empty(itemObject.series))
    purl += "&serie=" + URLenc(itemObject.series);

  val = itemObject.category;
  if (!Empty(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject, "x"));
      }
    }
    else {
      if (_this.domainIsNumber)
        val = parseFloat(itemObject.category);
    }
    purl += "&x=" + URLenc(val);
  }
  
  val = parseFloat(itemObject.value);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject, "y"));
      }
    }
    purl += "&y=" + URLenc(val);
  }
  
  return purl;
}

ZtAsterChart.prototype._GetParametersStringForLink = function (item) {
  var purl = "",
  _this = this,
  format,
  val,
  linkObj = this.linkObj,
  seriesName = Empty(linkObj.seriesname) ? "series" : linkObj.seriesname,
  categoryName = Empty(linkObj.categoryname) ? "category" : linkObj.categoryname,
  categoryKeyName = Empty(linkObj.categoryKeyName) ? "categoryKey" : linkObj.categoryKeyName,
  valueName = Empty(linkObj.valuename) ? "value" : linkObj.valuename;

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
 
  val = item.category;
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
  
  val = parseFloat(item.value);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item, "y"));
      }
    }
    purl += "&" + valueName + "=" + URLenc(val);
  }
  
  return purl;
}

ZtAsterChart.prototype._CreateGrid = function (thead, tbody1) {
  ZtXYZChart.prototype._CreateGrid.call(this, thead, tbody1);
}

ZtAsterChart.prototype._GetParseDrawingList = function () {
  return ZtXYZChart.prototype._GetParseDrawingList.call(this);
}

ZtAsterChart.prototype._GetItemObj = function (itemObject) {
  var row = -1,
  _this = this;
  this.dataSet.filter(function (rec, index) {
    if (rec[_this.xIndex] == itemObject.category &&
        rec[_this.yIndex] == itemObject.value ) {
          row = index;
          return true;
        }
    return false;
  });

  var ret = {
    category: itemObject.category,
    series: itemObject.series,
    range: itemObject.range,
    value: itemObject.value,
    selIdx: itemObject.idx,
    rowIdx: row,
    categoryCode: itemObject.categoryCode,
    keyF: itemObject.keyField,
    isSelected: itemObject.isSelected,
    focus: itemObject.focus,
    multidimCurrentKey: this.appliedKey,
    color: itemObject.color
  };
  return ret;
}

ZtAsterChart.prototype.GetValueLabelText = function (type, item, valueProp) {
  return ZtXYZChart.prototype.GetValueLabelText.call(this, type, item, valueProp);
}

ZtAsterChart.prototype._GetItemForGrid = function (item, field) {
  var itm = {
    key: item.keyField || item.keyF,
    serie: item.series
  };
  switch (field) {
    case "x":
      itm.field = this.propertyName[this.xIndex];
      itm.value = item.category;
      break;
    case "y":
      itm.field = this.propertyName[this.yIndex];
      itm.value = item.value;
      break;
  }
  return itm;
}

ZtAsterChart.prototype._FindItemForGrid = function (record) {
  var _this = this,
  all_itms = this._GetItems(),
  filter = all_itms.filter(function (item) {
    var found = ( item.category == record[_this.xIndex] &&
                  item.value == record[_this.yIndex] );
    if (!Empty(_this.objConfig.keyField))
      found = found && (item.keyField == record[_this.seriesIndex]);
    else
      found = found && (item.series == record[_this.seriesIndex]);
    return found;
  });
  return filter[0];
}

ZtAsterChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  return ZtXYZChart.prototype._GetGridCellValue.call(this, value, dataidx, record);
}