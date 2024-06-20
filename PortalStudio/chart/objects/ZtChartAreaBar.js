function ZtAreaBarChart(type/*, isH, is3D*/) {
  ZtStackBarChart.apply(this, [type, false, false]);
  this.type = "AREABAR";
  this.is3D = false;
  this.isH = false;
}
ZtAreaBarChart.prototype = Object.create(ZtStackBarChart.prototype);
ZtAreaBarChart.prototype.constructor = ZtAreaBarChart;

ZtAreaBarChart.prototype._SetChartSettingsJSON = function () {
  ZtStackBarChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.fillTransparency = this.chartConfig.graphSettings.fillTransparency;
  if (this.chartConfig.graphSettings.selectionOptions.opacity == "default")
    this.defSettings.selectionOptions.opacity = 0.25;
}

ZtAreaBarChart.prototype._SetFieldsIndexes = function () {
  ZtXYZChart.prototype._SetFieldsIndexes.call(this);
}

ZtAreaBarChart.prototype.SetDomainType = function () {
  ZtXYZChart.prototype.SetDomainType.call(this);
}

ZtAreaBarChart.prototype._SetSeriesList = function () {
  ZtXYZChart.prototype._SetSeriesList.call(this);
}

ZtAreaBarChart.prototype._SetLists = function () {
  ZtXYZChart.prototype._SetLists.call(this);
}

ZtAreaBarChart.prototype._SetCategoryList = function () {
  this.categoryList = getList(this.xIndex, this.dataSet);
  this.allValuesX = this.categoryList.slice();
  this.orgCategoryList = this.categoryList.slice();
  this.drawingCategories = this.orgCategoryList.slice();
}

ZtAreaBarChart.prototype._EvaluateAllValues = function () {
  ZtXYZChart.prototype._EvaluateAllValues.call(this);
}

ZtAreaBarChart.prototype._SetScales = function () {
  ZtXYZChart.prototype._SetScales.call(this);
  var min = d3.min(this.allValuesX);
  this.scaleX = d3.scaleLinear().domain([min >= 0 ? 0 : min, d3.max(this.allValuesX)]);
}

ZtAreaBarChart.prototype._SetCalculationDataset = function () {
  var vf = this.valueFields;
  if (!this.defSettings.normalizeValues) {
    this.calcDataset = getStackDataset(vf, this.propertyName, this.dataSet);
    this.calcDataset = accumulateValuesOnColumn(this.calcDataset, this.xIndex);
    this.allValuesX = getList(this.xIndex, this.calcDataset);
  }
  else {
    this.dataSet = getPercentDataset(vf, this.propertyName, this.dataSet, this.totalsSeries, false);
    this.calcDataset = getStackDataset(vf, this.propertyName, this.dataSet);
  }

  this.allValues = getValues(vf, this.propertyName, this.calcDataset);
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);
  this._EvaluateAllValuesCalc();
}

ZtAreaBarChart.prototype._DrawChartElements = function () {
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  bandWidth;

  if (this.domainIsNumber || this.domainIsTime) {
    var dax = this.svg.select("#" + this.chartId + "domainAxisGroup");
    if (dax.node()) {
      var t1 = dax.select(".tick._1");
      if (t1.node())
        bandWidth = t1.node().transform.baseVal[0].matrix.e;
    }
  }
  else
    bandWidth = this.scaleX.bandwidth();

  var dSeries = this._GetDrawingList(),
  scaleS = d3.scaleBand()
    .domain(dSeries)
    .range([0, bandWidth]),
  cobj;

  cobj = this._GetDrawParamObject(scaleS.bandwidth(), this.calcDataset);
  this.DrawAreaBar(group, this.dataSet, this.calcDataset, this.xIndex, this.yIndex, cobj);
  
  this._DrawShadows();
}

ZtAreaBarChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  stroke,
  gradID,
  styleObj;
  for (var i = 0; i < this.items.length; i++) {
    idx = this.orgSeriesList.indexOf(this.items[i].series);
    if (!Empty(this.items[i].keyField))
      idx = this.orgSeriesList.indexOf(this.items[i].keyField);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].color = this.colorSet[idx];
      this.items[i].sidx = idx;
      styleObj = {};
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
        stroke = "url(" + document.URL + "#" + gradID + ")";
      }
      styleObj.stroke = stroke;
      styleObj.fill = stroke;
      styleObj.fill9opacity = this.defSettings.fillTransparency ? 0.75 : 1;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtAreaBarChart.prototype._GetVBarX = function (data, cdata, xIndex/*, yIndex, cobj*/) {
  var x = this.scaleX(cdata[xIndex] - data[xIndex]);
  return x;
}

ZtAreaBarChart.prototype._GetVBarY = function (data, dataIndex, xIndex, yIndex, cobj) {
  return ZtBarChart.prototype._GetVBarY.call(this, data, dataIndex, xIndex, yIndex, cobj);
}

ZtAreaBarChart.prototype._GetVBarWidth = function (data, yIndex/*, cobj*/) {
  var w = this.scaleX(data[yIndex]);
  return w;
}

ZtAreaBarChart.prototype._GetVBarHeight = function (data, yIndex, cobj) {
  var w = 0,
  min = this.defSettings.valueAxis.minValue,
  max = this.defSettings.valueAxis.maxValue,
  sMin = d3.min(cobj.scaleY.domain()) < 0 ? 0 : d3.min(cobj.scaleY.domain()),
  sMax = d3.max(cobj.scaleY.domain()) > 0 ? 0 : d3.max(cobj.scaleY.domain());
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

ZtAreaBarChart.prototype._SetElementsRangeColor = function (isFnc) {
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
      }
      this._DrawMarkerIconOnItem(this.items[i]);
    }
  }
}

ZtAreaBarChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");
  for (var i = 0; i < this.items.length; i++) {
    var item = this.items[i],
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, "realValue"),
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
              .text(text);
    setFont(label, font);
  }
}

ZtAreaBarChart.prototype._GetDrawParamObject = function (barWidth, cdata) {
  return  { barWidth : barWidth,
            cdata : cdata
          }
}

ZtAreaBarChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
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

ZtAreaBarChart.prototype._CheckEmptyValues = function () {
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

ZtAreaBarChart.prototype._EvaluateDatasetAndCalculation = function () {
  // inutile girare sulle serie se sono le stesse
  this._SetCalculationDataset();
}

ZtAreaBarChart.prototype._MapCalculation = function () {
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

ZtAreaBarChart.prototype._GetDrawingList = function () {
  return this.drawingSeries;
}

ZtAreaBarChart.prototype._GetReferredList = function () {
  return ZtXYZChart.prototype._GetReferredList.call(this);
}

ZtAreaBarChart.prototype._GetReferredExcludedList = function () {
  return ZtXYZChart.prototype._GetReferredExcludedList.call(this);
}

ZtAreaBarChart.prototype._SupportFilter = function () {
  return ZtXYZChart.prototype._SupportFilter.call(this);
}

ZtAreaBarChart.prototype._SetSeriesIndex = function (/*val*/) {
  return 0;
}

ZtAreaBarChart.prototype._SupportChangeOrder = function () {
  return ZtXYZChart.prototype._SupportChangeOrder.call(this);
}

ZtAreaBarChart.prototype._GetAxisDrawingList = function () {
  return this.orgSeriesList;
}

ZtAreaBarChart.prototype._GetAnimatedDivisor = function() {
  return this.drawingSeries.length;
}

ZtAreaBarChart.prototype._DrawValueLabels = function () {
  ZtBarChart.prototype._DrawValueLabels.call(this);
}

ZtAreaBarChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
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
  
  if (!Empty(_this.defSettings.axisLabel.xLabel))
    purl += "&xlabel=" + URLenc(_this.defSettings.axisLabel.xLabel);
  
  if (!Empty(_this.defSettings.axisLabel.yLabel))
    purl += "&ylabel=" + URLenc(_this.defSettings.axisLabel.yLabel);

  return purl;
}

ZtAreaBarChart.prototype._GetParametersStringForLink = function (item) {
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

ZtAreaBarChart.prototype._CreateGrid = function (thead, tbody1) {
  ZtXYZChart.prototype._CreateGrid.call(this, thead, tbody1);
}

ZtAreaBarChart.prototype._GetParseDrawingList = function () {
  return ZtXYZChart.prototype._GetParseDrawingList.call(this);
}

ZtAreaBarChart.prototype._GetItemObj = function (itemObject) {
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

ZtAreaBarChart.prototype.GetValueLabelText = function (type, item, valueProp) {
  return ZtXYZChart.prototype.GetValueLabelText.call(this, type, item, valueProp);
}

ZtAreaBarChart.prototype._GetItemForGrid = function (item, field) {
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

ZtAreaBarChart.prototype._FindItemForGrid = function (record) {
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

ZtAreaBarChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  return ZtXYZChart.prototype._GetGridCellValue.call(this, value, dataidx, record);
}