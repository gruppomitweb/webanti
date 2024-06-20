function ZtDialChart() {
  StdChart.apply(this, ["ARCDIAL", "f0e4"]);
  this.multiSVG = true;
  this.scaleTransform = {};
}
ZtDialChart.prototype = Object.create(StdChart.prototype);
ZtDialChart.prototype.constructor = ZtDialChart;

ZtDialChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.gauge = this.chartConfig.graphSettings.gauge;
  this.defSettings.pointCap = this.chartConfig.graphSettings.pointCap;
  this.defSettings.scale = this.chartConfig.graphSettings.scale;
  this.defSettings.tickAxis = this.chartConfig.graphSettings.tickAxis;
  this.defSettings.tickAxis.tickLine = this.chartConfig.graphSettings.gauge.extendLine;
  this.defSettings.radius = this.chartConfig.graphSettings.radius;

  if (!("minFields" in this.objConfig) && !("maxFields" in this.objConfig))
    this.isOLD = true;
}

ZtDialChart.prototype._SetTitles = function () {
  ZtPieChart.prototype._SetTitles.call(this);
}

ZtDialChart.prototype._SetLists = function () {
  if (this.isOLD) {
    var vf = this.objConfig.valueFields.split(",");
    this.minValueFields = !Empty(vf[0]) ? [vf[0]] : [];
    this.maxValueFields = !Empty(vf[1]) ? [vf[1]] : [];
    this.valueFields = [vf[2]];
    this.objConfig.valueFields = vf[2];
  }
  else {
    this.minValueFields = [];
    this.maxValueFields = [];
    if (this.objConfig.minFields)
      this.minValueFields = this.objConfig.minFields.split(",");
    if (this.objConfig.maxFields)
      this.maxValueFields = this.objConfig.maxFields.split(",");
  }

  this.minValues = getMeasureMinMax(this.minValueFields, this.dataSet, this.propertyName);
  this.maxValues = getMeasureMinMax(this.maxValueFields, this.dataSet, this.propertyName);

  StdChart.prototype._SetLists.call(this);

  if (!Empty(this.minValues))
    this.rangeminmax.min = this.minValues[0];
  if (!Empty(this.maxValues))
    this.rangeminmax.max = this.maxValues[0];
}

ZtDialChart.prototype._SetScales = function () {
  this.scaleY = {};
  var dList = this._GetDrawingList();
  for (var i = 0; i < dList.length; i++) {
    this.scaleY[dList[i]] = d3.scaleLinear();
  }
}

ZtDialChart.prototype._SetCalculationDataset = function (dataSet) {
  this.calcDataset = dataSet;
}

ZtDialChart.prototype._GetValuesPrecision = function () {
  return ZtPieChart.prototype._GetValuesPrecision.call(this);
}

ZtDialChart.prototype._GetDomainPrecision = function () {
  return ZtPieChart.prototype._GetDomainPrecision.call(this);
}

ZtDialChart.prototype._DrawChartPlot = function () {
  ZtPieChart.prototype._DrawChartPlot.call(this);
}

ZtDialChart.prototype._GetCustomAxisMinMax = function (scaleKey, index, minValue, maxValue) {
  var min,
  max,
  list = this.allValues;

  if (this.multipleScales) {
    if (this.objConfig.mapSeries && this.objConfig.mapSeries[scaleKey]) {
      if (this.objConfig.mapSeries[scaleKey].ownerScale)
        list = this[scaleKey + "_values"];
    }
  }

  if (Empty(this.minValues) || (this.minValues.length == 1 && Empty(this.minValues[0]) && this.minValues[0] != 0)) {
    if (!isNaN(parseFloat(minValue)) && minValue != null)
      min = minValue;
    else
      min = d3.min(list);
  }
  else {
    if (!isNaN(parseFloat(minValue)) && minValue != null)
      min = minValue;
    else {
      if (!Empty(this.minValues[index]) || this.minValues[index] == 0)
        min = this.minValues[index];
      else if (this.minValues.length == 1 && this.valueFields.length > 1)
        min = this.minValues[0];
      else
        min = d3.min(list);
    }
  }

  if (Empty(this.maxValues) || (this.maxValues.length == 1 && Empty(this.maxValues[0]) && this.maxValues[0] != 0)) {
    if (!isNaN(parseFloat(maxValue)) && maxValue != null)
      max = maxValue;
    else
      max = d3.max(list);
  }
  else {
    if (!isNaN(parseFloat(maxValue)) && maxValue != null)
      max = maxValue;
    else {
      if (!Empty(this.maxValues[index]) || this.maxValues[index] == 0)
        max = this.maxValues[index];
      else if (this.maxValues.length == 1 && this.valueFields.length > 1)
        max = this.maxValues[0];
      else
        max = d3.max(list);
    }
  }

  return { min: min, max: max };
}

ZtDialChart.prototype._SetCustomScaleParameters = function (scaleKey, scaleY, min, max) {
  var rmin = (this.defSettings.tickAxis.extendAngle.start - 90) * Math.PI / 180,
  rmax = (this.defSettings.tickAxis.extendAngle.end - 90) * Math.PI / 180;
  scaleY.domain([min, max]).range([rmin, rmax]);
}

ZtDialChart.prototype._SelectAutoTickUnit = function (/*min, max, font, isDomain*/) { }

ZtDialChart.prototype._SetDomainScaleParameters = function () { }

ZtDialChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  id = "",
  group,
  radius,
  arc,
  mvalues,
  _this = this,
  oList = this._GetOppositeAxisDrawingList(),
  aCont,
  oRadius,
  u180 = (this.defSettings.gauge.extendAngle.end - this.defSettings.gauge.extendAngle.start) <= 180;

  arc = d3.arc()
    .startAngle((this.defSettings.gauge.extendAngle.start - 90) * Math.PI / 180)
    .endAngle((this.defSettings.gauge.extendAngle.end - 90) * Math.PI / 180);

  var domainLabelH = 0;
  if (oList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  for (var i = 0; i < positions.length; i++) {
    radius = positions[i].width > positions[i].height ? positions[i].height : positions[i].width;
    if (!u180)
      radius = radius / 2;
    radius = radius - (getOffsetHeight("W", this.defSettings.globalFont, this.chartId) + 5);
    if (!u180)
      radius = radius - radius * 0.05;  // tolgo il 5% per dare un po' di spazio al disegno
    else
      radius = radius - radius * 0.1;
    this.radius = radius;

    if (this.defSettings.valueLabel.show != "hide") {
      var font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
      tmpw = getOffsetHeight(this.GetValueLabelMaxWord(this.dataSet), font, this.chartId);
      this.radius = this.radius - (tmpw + 5);
    }

    if (isNaN(this.defSettings.tickAxis.tickLine.stroke))
      oRadius = this.radius;
    else
      oRadius = this.radius + this.defSettings.tickAxis.tickLine.stroke;

    arc.innerRadius(function () {
      if (_this.defSettings.tickAxis.openLine)
        return 0;
      return _this.radius;
    })
    .outerRadius(oRadius)

    id = this.chartId + i + "_";
    var xIndex = Empty(this.objConfig.keyField) ? this.xIndex : this.xLabelIndex;
    mvalues = this.dataSet.filter( function(record) { return record[xIndex] == oList[i]; } );
    this._SetCalculationDataset(mvalues);
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      .attr("transform", "translate(" + [positions[i].width / 2, u180 ? this.radius + 2 : positions[i].height / 2] + ")")
      .attr("pos-width", positions[i].width)
      .attr("pos-height", positions[i].height - domainLabelH),
    aCont;
    // range bands
    if (Empty(d3.select("#" + id + "rangeBands").node()))
      group.append("g").attr("id", id + "rangeBands");

    aCont = group.append("g").attr("id", id + "tickAxisGroup");

    this._DrawCustomAxis(aCont, id, arc, oRadius);
    this.DrawPointer(group, this.calcDataset, i, this.xIndex, id);
    if (oList.length > 1)
      this.DrawDomainLabel(i, positions[i], oList[i]);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtDialChart.prototype._CreateRendererGradient = function (color, gradient, gDef) {
  ZtBarChart.prototype._CreateRendererGradient.call(this, color, gradient, gDef);
}

ZtDialChart.prototype._CreateElementGradient = function (color, gradient, gDef) {
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

ZtDialChart.prototype._SetAxisColor = function () {
  var oldChartId = this.chartId,
  scs = Object.keys(this.scaleY);
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    for (var j = 0; j < scs.length; j++) {
      if (!this.scaleY[scs[j]].__noDraw)
        this.SetAxisColor("tick", null, null, false, replaceSpecialCharsForID("_" + scs[j]), this.scaleY[scs[j]]);
    }
  }
  this.chartId = oldChartId;
}

ZtDialChart.prototype._SetAxisGridColor = function () {
  ZtPieChart.prototype._SetAxisGridColor.call(this);
}

ZtDialChart.prototype._SetAxisFont = function () {
  var oldChartId = this.chartId,
  scs = Object.keys(this.scaleY);
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    for (var j = 0; j < scs.length; j++) {
      if (!this.scaleY[scs[j]].__noDraw)
        this.SetAxisFont("tick", replaceSpecialCharsForID("_" + this.scaleY[scs[j]].__refAxis), this.scaleY[scs[j]].__refAxis);
    }
  }
  this.chartId = oldChartId;
}

ZtDialChart.prototype._SetAxisLabelFont = function () {
  ZtPieChart.prototype._SetAxisLabelFont.call(this);
}

ZtDialChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  colD,
  sidx;

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itemType != "pointerCap") {
      idx = this.valueFields.indexOf(this.items[i].valueField);
      sidx = this.categoryList.indexOf(this.items[i].category);
      if (idx >= 0) {
        this.items[i].idx = idx;
        this.items[i].sidx = sidx;
        this.items[i].color = this.colorSet[idx];
        if (this.defSettings.useColorSeriesForEach)
          this.items[i].color = this.colorSet[i];
        var styleObj = {};
        gradID = this.chartId + this.type + "_" + idx + "Gradient";
        if (!Empty(this.items[i].color.color) && Empty(this.items[i].color.gradient) || this.items[i].color.color.toLowerCase() == this.items[i].color.gradient.toLowerCase())
          colD = this.items[i].color.color;
        else if (Empty(this.items[i].color.color) && !Empty(this.items[i].color.gradient))
          colD = this.items[i].color.gradient;
        else {
          this.CreateGradient(this.items[i].color.color, this.items[i].color.gradient, gradID, "element");
          colD = "url(#" + gradID + ")";
        }
        styleObj.fill = colD;
        if (this.defSettings.pointCap.type.toLowerCase() == "pin" || this.defSettings.pointCap.type.toLowerCase() == "arrow") {
          styleObj.stroke = styleObj.fill;
          styleObj.fill = "transparent";
        }

        if (!Empty(this.defSettings.pointCap.pointer.extendLine.color))
          styleObj.stroke = this.defSettings.pointCap.pointer.extendLine.color;

        styleObj.stroke9width = this.defSettings.pointCap.pointer.extendLine.stroke;

        d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      }
    }
    else {
      styleObj = {};
      styleObj.fill = "#000000";
      if (!Empty(this.defSettings.pointCap.cap.color))
        styleObj.fill = this.defSettings.pointCap.cap.color;
      styleObj.stroke = "#000000";
      if (!Empty(this.defSettings.pointCap.cap.extendLine.color))
        styleObj.stroke = this.defSettings.pointCap.cap.extendLine.color;

      styleObj.stroke9width = this.defSettings.pointCap.cap.extendLine.stroke;

      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtDialChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  return ZtPieChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
}

ZtDialChart.prototype._GetRadius = function () {
  return ZtPieChart.prototype._GetRadius.call(this);
}

ZtDialChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj),
  start = defaultValues ? item.startRotate : lastValueObj.startRotate;

  d3.select(elem)
    .attr("transform", "rotate(" + start + ",0,0)")
    .transition()
      .delay(item.idx * duration / div)
      .duration(duration / div)
      .attr("transform", "rotate(" + item.rotate + ",0,0)");
}

ZtDialChart.prototype._NotAnimatedChartElements = function () {
  for (var i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;

    d3.select(elem)
      .attr("transform", "rotate(" + this.items[i].rotate + ",0,0)")
  }
}

ZtDialChart.prototype._GetDivisor = function () {
  return ZtPieChart.prototype._GetDivisor.call(this);
}

ZtDialChart.prototype._DrawTicks = function (container, ticksValues, isMajor, scaleY) {
  var tickLen = isMajor ? 10 : 5,
  labelOs = this.defSettings.scale.tickLabelOffset,
  appFont = appliedFont(this.defSettings, this.defSettings.tickAxis, this.defSettings.tickAxis.tickFont),
  tGroup,
  _this = this;

  if (this.multipleScales)
    labelOs = 0.2;

  var rad = scaleY.__radius - (scaleY.__radius * labelOs);

  for (var i = 0; i < ticksValues.length; i++) {
    var tick = ticksValues[i];
    tGroup = container.append("g")
      .attr("class", "tick");

    if (typeof tick != "number")
      tick = parseFloat(tick);

    var rot = 180 / Math.PI * scaleY(tick);
    tGroup.append("line")
      .attr("y1", scaleY(tick))
      .attr("y2", tickLen + scaleY(tick))
      .attr("transform", function() {
          var cSin = scaleY.__radius * Math.sin(scaleY(tick)),
          cCos = - scaleY.__radius * Math.cos(scaleY(tick));
          return "translate(" + cSin + "," + cCos + ") rotate(" + rot + ")";
      })
      .attr("data-rotation", rot);

    if (isMajor) {
      tGroup.attr("data-major", "majorTick")
        .append("text")
        .attr("class", "tickAxLabel")
        .attr("x", scaleY(tick))
        .attr("y", function () {
          if (rot == -90 || rot == 270 || rot == 90)
            return scaleY(tick);
          return tickLen + scaleY(tick);
        })
        .attr("transform", function() {
          var tw = getOffsetWidth(tick, appFont, _this.chartId),
          rSin = rad * Math.sin(scaleY(tick)),
          rCos = - rad * Math.cos(scaleY(tick));
          rSin = rSin - (tw / 2);
          rCos = rCos - 3;
          return "translate(" + rSin + "," + rCos + ")";
        })
        .text(tick);
    }
  }
}

ZtDialChart.prototype._GetItems = function () {
  return this.items.filter(function (item) { return item.itemType != "pointerCap"; });
}

ZtDialChart.prototype._SetInReferredList = function (label) {
  ZtPieChart.prototype._SetInReferredList.call(this, label);
}

ZtDialChart.prototype._ApplyPatterns = function () {
  var items = this._GetItems().filter(function (item) { return item.isOut; }),
  color;
  for (var i = 0; i < items.length; i++) {
    color = items[i].color.color;
    this.DrawOutRangePattern(color);
    this.ApplyPatternOnItem(items[i], "outRangePattern_" + color.slice(1));
  }

  this._AdjustCap();
}

ZtDialChart.prototype._AdjustCap = function () {
  var items = this.items.filter(function (item) { return item.itemType == "pointerCap"; }),
  cap;
  for (var i = 0; i < items.length; i++) {
    cap = items[i].itm;
    cap.parentNode.insertBefore(cap.parentNode.lastChild, cap);
  }
}

ZtDialChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG) {
  ZtPieChart.prototype._DrawMultiSVGPlot.call(this, id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG);
}

ZtDialChart.prototype._EvaluateAllValues = function () {
  this.allValues = [];
  var dList = this._GetDrawingList();
  for (var i = 0; i < dList.length; i++) {
    this[dList[i] + "_values"] = getValues([dList[i]], this.propertyName, this.dataSet);
    if (!this.multipleScales)
      this.allValues = this.allValues.concat(this[dList[i] + "_values"]);
    else if (this.objConfig.mapSeries) {
      if (this.objConfig.mapSeries[dList[i]] && !this.objConfig.mapSeries[dList[i]].ownerScale)
        this.allValues = this.allValues.concat(this[dList[i] + "_values"]);
      else if (!(dList[i] in this.objConfig.mapSeries))
        this.allValues = this.allValues.concat(this[dList[i] + "_values"]);
    }
  }
}

ZtDialChart.prototype._DrawCustomAxis = function (axisContainer, id, arc, oRadius) {
  var scs = Object.keys(this.scaleY),
  sckey,
  axisReferenceId = "",
  draw = true,
  appFont = appliedFont(this.defSettings, this.defSettings.tickAxis, this.defSettings.tickAxis.tickFont),
  vRange,
  len = 0,
  mword,
  _this = this,
  stroke = isNaN(this.defSettings.tickAxis.tickLine.stroke) ? 0 : this.defSettings.tickAxis.tickLine.stroke,
  fPerc = 0;

  oRadius = oRadius - stroke;

  for (var i = 0; i < scs.length; i++) {
    sckey = scs[i];

    if (this.multipleScales && this.objConfig.mapSeries) {
      if (this.objConfig.mapSeries[scs[i]]) {
        if (this.objConfig.mapSeries[scs[i]].ownerScale) {
          this.scaleY[scs[i]].__refAxis = sckey;
          draw = true;
        }
        else if (!Empty(axisReferenceId)) {
          this.scaleY[scs[i]].__refAxis = axisReferenceId;
          draw = false;
        }
        else {  // non ha scala propria, non e' referenziato, lo disegno
          axisReferenceId = sckey;
          this.scaleY[scs[i]].__refAxis = axisReferenceId;
          draw = true;
        }
      }
      else {
        if (!Empty(axisReferenceId)) {
          this.scaleY[scs[i]].__refAxis = axisReferenceId;
          draw = false;
        }
        else {  // non ha scala propria, non e' referenziato, lo disegno
          axisReferenceId = sckey;
          this.scaleY[scs[i]].__refAxis = axisReferenceId;
          draw = true;
        }
      }
    }
    else {
      if (i == 0) {
        axisReferenceId = sckey;
        draw = true;
      }
      else
        draw = false; // basta il primo
      this.scaleY[scs[i]].__refAxis = axisReferenceId;
    }

    this.scaleY[scs[i]].__noDraw = !draw;
    this.scaleY[scs[i]].__refArc = arc;
    this.scaleY[scs[i]].__radius = oRadius;
    this.scaleY[scs[i]].__fPerc = fPerc;
    this.DrawCustomAxis(axisContainer, i, arc, id, false, scs[i]);

    if (!this.scaleY[scs[i]].__noDraw && arc) {
      vRange = this._GetCustomAxisMinMax(scs[i], i, this.defSettings.tickAxis.minValue, this.defSettings.tickAxis.maxValue);
      mword = getMaxWordLength([vRange.min, vRange.max]);
      len = Math.max(getOffsetWidth(mword, appFont, this.chartId), len);
      len = Math.max(getOffsetHeight(mword, appFont, this.chartId), len);

      oRadius = oRadius - (len + 5);
      arc.innerRadius(function () {
      if (_this.defSettings.tickAxis.openLine)
          return 0;
        return oRadius;
      })
      .outerRadius(oRadius + stroke);

      fPerc = 0.2;
    }
  }
}

ZtDialChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this.RemoveAllPatterns();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var lastValues,
  dataIndex,
  yIndex,
  cList = getList(this.xIndex, this.dataSet),
  item,
  isOut,
  dataValue,
  rot,
  vRange,
  scaleKey,
  scaleY;

  this._DrawPatterns();

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm && this.items[i].itemType != "pointerCap") {
      item = this.items[i];
      dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);
      lastValues = {};
      lastValues.startRotate = item.rotate;

      scaleKey = item.valueField;
      scaleY = this.scaleY[this.scaleY[scaleKey].__refAxis];
      yIndex = this.propertyName.indexOf(item.valueField);
      vRange = this._GetCustomAxisMinMax(scaleKey, dataIndex, this.defSettings.tickAxis.minValue, this.defSettings.tickAxis.maxValue);

      isOut = false;
      dataValue = this.dataSet[dataIndex][yIndex];
      rot = 180 / Math.PI * scaleY(dataValue);
      if (dataValue < vRange.min || dataValue > vRange.max) {
        isOut = true;
        if (Math.abs(vRange.min - dataValue) < Math.abs(vRange.max - dataValue))
          rot = 180 / Math.PI * scaleY(vRange.min);
        else
          rot = 180 / Math.PI * scaleY(vRange.max);
      }

      item.rotate = rot;
      item.value = dataValue;
      item.isOut = isOut;

      d3.select(item.itm)
        .attr("transform", "rotate(" + item.rotate + ",0,0)")
        .style("fill", item.color.color);

      if (item.isOut)
        this.ApplyPatternOnItem(item, "outRangePattern_" + item.color.color.slice(1));

      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtDialChart.prototype.ApplyPatternOnItem = function (itemObject, patternType) {
  if (Empty(d3.select("#" + this.chartId + patternType).node()))
    return;

  if (itemObject.itm)
    d3.select(itemObject.itm).style("fill", "url(#" + this.chartId + patternType + ")");
}

ZtDialChart.prototype._DrawValueLabels = function () {
  var oldChartId = this.chartId,
  oldRenderer = this.renderer;
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    this.renderer = d3.select("#" + this.chartId + "d3Renderer");
    this._AppendValueLabels(i);
  }
  this.chartId = oldChartId;
  this.renderer = oldRenderer;
}

ZtDialChart.prototype._AppendValueLabels = function (index) {
  var container = d3.select("#" + this.chartId + this.type + "_elementGroup"),
  group = container.append("g")
                .attr("id", this.chartId + "valueLabels"),
  _this = this,
  items = this._GetItems().filter( function (item) { return item.sidx == index; }),
  item,
  labelOs = this.multipleScales ? 0.2 : this.defSettings.scale.tickLabelOffset,
  rad,
  rot,
  offset = 5;

  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var scaleY = this.scaleY[this.scaleY[item.valueField].__refAxis],
    tick = item.value,
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    tw = getOffsetWidth(tick, font, this.chartId),
    th = getOffsetHeight(tick, font, this.chartId);
    rot = 180 / Math.PI * scaleY(tick);
    rad = scaleY.__radius - (scaleY.__radius * labelOs);
    var label = group.append("text")
              .attr("x", function () {
                if (_this.defSettings.valueLabel.type.indexOf("val") < 0)
                  return 0;
                if (rot > 0)
                  return scaleY(tick) + th + offset;
                if (rot < 0)
                  return scaleY(tick) - th - offset;
                return scaleY(tick);
              })
              .attr("y", this.defSettings.valueLabel.type.indexOf("val") < 0 ? 0 : scaleY(tick))
              .attr("transform", function() {
                if (_this.defSettings.valueLabel.type.indexOf("val") < 0)
                  return "translate(" + 0 + "," + (- (rad + th)) + ")";
                var rSin = rad * Math.sin(scaleY(tick)),
                rCos = - rad * Math.cos(scaleY(tick));
                rSin = rSin - (tw / 2);
                rCos = rCos - 3;
                return "translate(" + rSin + "," + rCos + ")";
              })
              .style("text-anchor", this.defSettings.valueLabel.type.indexOf("val") < 0 ? "middle" : "")
              .text(text);
    setFont(label, font, this);
  }
}

ZtDialChart.prototype._ExecScale = function () {
  if (!this.defSettings.gauge.fitSize)
    return;
  var _this = this;
  if ((this.defSettings.gauge.extendAngle.end - this.defSettings.gauge.extendAngle.start) <= 180) {
    var oldChartId = this.chartId,
    group;
    for (var i = 0; i < this._GetDivisor(); i++) {
      this.chartId = oldChartId + i + "_";
      group = d3.select("#" + this.chartId + this.type + "_elementGroup");
      execScale(group, parseFloat(group.attr("pos-width")), parseFloat(group.attr("pos-height")));
    }
  }
  this.chartId = oldChartId;

  function execScale(group, gWidth, gHeight) {
    var bbox = group.node().getBBox(),
    translate = "",
    scalex = (gWidth * 0.98) / bbox.width,
    scaley = (gHeight * 0.98) / bbox.height;
    translate = "scale(" + [scalex, scaley] + ") ";
    translate += "translate(" + [Math.abs(bbox.x) + 2, Math.abs(bbox.y) + 2] + ")";
    _this.scaleTransform.x = scalex;
    _this.scaleTransform.y = scaley;
    group.attr("transform", translate);
  }
}

ZtDialChart.prototype._AnimateChartElements = function () { }

ZtDialChart.prototype.AfterDrawTimeout = function () {
  var _this = this;
  if (this.forPJS)
    timeoutSequence();
  else {
    var timeout = setTimeout ( function () { timeoutSequence(); }, this.animationDelay);
    this.allTimeouts.push(timeout);
  }

  function timeoutSequence() {
    _this._ApplyPatterns();
    _this.DrawValueLabels();
    _this._ExecScale();
    _this.DrawZoomCursor();
    _this.RemoveLoadingDiv();
    _this._AnimateChartElementsAfter();
    _this.HideMaskDivAnimation();
    if (_this.old_drawStatic !== undefined) {
      _this.drawStatic = _this.SetIsStaticChart(_this.old_drawStatic);
      delete _this.old_drawStatic;
    }
    _this._AdjustDisplayText();
  }
}

ZtDialChart.prototype._AnimateChartElementsAfter = function () {
  this.animationDelay = 0;
  if (this.drawStatic || !this.defSettings.animation || !this.defSettings.animation.animate) {
    this._NotAnimatedChartElements();
    return;
  }
  this.animationDelay = this.defSettings.animation.duration + this.plusDelay;
  for (var i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;
    this._AnimateItem(this.items[i], null, this.defSettings.animation.duration);
  }
}

ZtDialChart.prototype._ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (!this.defSettings.range.applyColor) {
    this.SetRangeInItems();
    this._DrawRangeBandsRadialAxis();
  }
  else
    this._SetElementsRangeColor(isFnc);
}

ZtDialChart.prototype._DrawRangeBandsRadialAxis = function () {
  var scs = Object.keys(this.scaleY),
  id,
  group,
  _this = this,
  arc = d3.arc()
    .innerRadius(this._GetInnerRadius())
    .outerRadius(this._GetOuterRadius());

  for (var i = 0; i < this._GetDivisor(); i++) {
    id = this.chartId + i + "_";
    group = d3.select("#" + id + "rangeBands");
    if (group.node()) {
      for (var j = 0; j < scs.length; j++) {
        var scaleY = this.scaleY[scs[j]];
        if (this.defSettings.range.gradient == "multi") {
          group.append("path")
            .attr("class","rangeband")
            .attr("d", arc);
        }
        else {
          arc
            .startAngle( function (d) { return scaleY(d.minValue); } )
            .endAngle( function (d) { return scaleY(d.maxValue); } );
          group.selectAll(".rangeband")
            .data(this.defSettings.range.bands)
            .enter()
            .append("path")
              .attr("class", "rangeband")
              .attr("d", arc)
              .style("fill", function (d, idx) {
                if (_this.defSettings.range.gradient == "mono") {
                  var cls = getListFromObjectArray(getColorsArrayLighter(d.color, 8).reverse(), "color"),
                  gradID = id + "mono_range_" + idx;
                  _this.CreateGradientFromColors(cls, gradID);
                  return "url(#" + gradID + ")";
                }
                return d.color;
              });
        }
      }
    }
  }
}

ZtDialChart.prototype._GetInnerRadius = function (radius) {
  radius = radius || this._GetRadius();
  if (Empty(this.defSettings.radius) || isNaN(this.defSettings.radius.inner))
    return radius * 0.25;
  return radius * (this.defSettings.radius.inner / 100);
}

ZtDialChart.prototype._GetOuterRadius = function (radius) {
  radius = radius || this._GetRadius();
  if (Empty(this.defSettings.radius) || isNaN(this.defSettings.radius.outer))
    return radius * 0.75;
  return radius * (this.defSettings.radius.outer / 100);
}
