function ZtLightsChart() {
  StdChart.apply(this, ["LIGHTS", "e913"]);
  this.multiSVG = true;
  this.isV = true;
  this.lights = [];
}
ZtLightsChart.prototype = Object.create(StdChart.prototype);
ZtLightsChart.prototype.constructor = ZtLightsChart;

ZtLightsChart.prototype._SetChartSettingsJSON = function () {
  ZtDialChart.prototype._SetChartSettingsJSON.call(this);

  if (this.defSettings.range.type == "none")
    this.defSettings.range.type = "default";

  this.multipleScales = false;
  this.isH = this.chartConfig.graphSettings.gauge.orientation != "vertical";

  this.defSettings.chartStyle = this.chartConfig.graphSettings.extends.styles.lights;
  if (this.defSettings.chartStyle == "rflatbord")
    this.defSettings.gauge.type = "round";
}

ZtLightsChart.prototype._SetTitles = function () {
  ZtPieChart.prototype._SetTitles.call(this);
}

ZtLightsChart.prototype._SetLists = function () {
  ZtDialChart.prototype._SetLists.call(this);

  this.isV = this.defSettings.gauge.orientation == "vertical";
}

ZtLightsChart.prototype._SetCalculationDataset = function (dataSet) {
  ZtDialChart.prototype._SetCalculationDataset.call(this, dataSet);
}

ZtLightsChart.prototype._SetScales = function () { }

ZtLightsChart.prototype._GetValuesPrecision = function () {
  return ZtPieChart.prototype._GetValuesPrecision.call(this);
}

ZtLightsChart.prototype._GetDomainPrecision = function () {
  return ZtPieChart.prototype._GetDomainPrecision.call(this);
}

ZtLightsChart.prototype._SetAxisColor = function () {
  ZtPieChart.prototype._SetAxisColor.call(this);
}

ZtLightsChart.prototype._SetAxisGridColor = function () {
  ZtPieChart.prototype._SetAxisGridColor.call(this);
}

ZtLightsChart.prototype._SetAxisFont = function () {
  ZtPieChart.prototype._SetAxisFont.call(this);
}

ZtLightsChart.prototype._SetAxisLabelFont = function () {
  ZtPieChart.prototype._SetAxisLabelFont.call(this);
}

ZtLightsChart.prototype._DrawChartPlot = function () {
  ZtPieChart.prototype._DrawChartPlot.call(this);
}

ZtLightsChart.prototype._DrawChartPlotElements = function () {
  ZtPieChart.prototype._DrawChartPlotElements.call(this);
}

ZtLightsChart.prototype._GetValueAxisMinMax = function (index, minValue, maxValue) {
  return ZtDialChart.prototype._GetValueAxisMinMax.call(this, index, minValue, maxValue);
}

ZtLightsChart.prototype._CreateRendererGradient = function (color, gradient, gDef) {
  ZtBarChart.prototype._CreateRendererGradient.call(this, color, gradient, gDef);
}

ZtLightsChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  id = "",
  group,
  mvalues,
  //_this = this,
  oList = this._GetOppositeAxisDrawingList(),
  domainLabelH = 0;

  if (oList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  if (this.defSettings.chartStyle.indexOf("flat") >= 0) {
    if (Empty(this.svg.select("#" + this.chartId + "blur").node())) {
      this.svg.select("#" + this.__cID + "d3ChartDefs")
        .append("filter")
        .attr("id", this.chartId + "blur")
        .attr("x", "-20%")
        .attr("y", "-20%")
        .attr("width", "140%")
        .attr("height", "140%")
        .attr("filterUnits", "objectBoundingBox")
        .attr("primitiveUnits", "userSpaceOnUse")
        .attr("color-interpolation-filters", "linearRGB")
        .append("feGaussianBlur")
          .attr("stdDeviation", "5");
    }
  }

  for (var i = 0; i < positions.length; i++) {
    var ph = positions[i].height - domainLabelH;
    id = this.chartId + i + "_";
    var xIndex = Empty(this.objConfig.keyField) ? this.xIndex : this.xLabelIndex;
    mvalues = this.dataSet.filter( function(record) { return record[xIndex] == oList[i]; } );
    this._SetCalculationDataset(mvalues);
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup");
    this.DrawLights(group, this.calcDataset, i, id, positions[i].width, ph);

    if (oList.length > 1)
      this.DrawDomainLabel(i, positions[i], oList[i]);
  }

  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtLightsChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  colD;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.valueFields.indexOf(this.items[i].valueField);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.categoryList.indexOf(this.items[i].category);
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
      if (this.defSettings.chartStyle == "default")
        styleObj.fill = colD;
      else {
        styleObj.fill = "transparent";
        styleObj.stroke = "transparent";
        if (this.defSettings.chartStyle == "rflatbord") {
          styleObj.stroke = colD;
          styleObj.stroke9width = 5;
          if (this.items[i].r)
            styleObj.stroke9width = this.items[i].r / 8;  // 8 valore arbitrario preso su 40 di raggio e 5 di stroke 40:5=8
        }
        styleObj.stroke9width += "px";
      }
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtLightsChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  return ZtPieChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
}

ZtLightsChart.prototype._GetAnimatedDivisor = function() {
  return ZtRadarChart.prototype._GetAnimatedDivisor.call(this);
}

ZtLightsChart.prototype._AnimateChartElements = function () {
  for (var i = 0; i < this.lights.length; i++) {
    var elem = this.lights[i].itm;
    if (!elem)
      continue;
    this._AnimateItem(this.lights[i], null, this.defSettings.animation.duration);
  }
}

ZtLightsChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  return;
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj),
  cfill = this.chartId + item.bandColor.slice(1);

  if (item.on) {
    d3.select(elem)
      .style("fill", defaultValues ? "url(#" + cfill + "_off)" : "url(#" + cfill + "_" + lastValueObj.status + ")")
      .transition()
        .delay(item.idx * duration / div)
        .duration(duration / div)
        .ease(d3.easeLinear)
        .style("fill", "url(#" + cfill + "_on)");
  }
  else {
    d3.select(elem)
      .style("fill", defaultValues ? "url(#" + cfill + "_off)" : "url(#" + cfill + "_" + lastValueObj.status + ")")
      .transition()
        .delay(item.idx * duration / div)
        .duration(duration / div)
        .ease(d3.easeLinear)
        .style("fill", "url(#" + cfill + "_off)");
  }
}

ZtLightsChart.prototype._GetDivisor = function () {
  return ZtPieChart.prototype._GetDivisor.call(this);
}

ZtLightsChart.prototype._ApplyRangeBands = function () {
  var lastCategory = "";

  // costruisco gli effetti
  this._CreateRangeColorsEffect();

  for (var i = 0; i < this.lights.length; i++) {
    this._EvaluateValueInRange(this.lights[i], lastCategory);
    if (this.lights[i].on)
      lastCategory = this.lights[i].valueField + "_" + this.lights[i].category;
  }
}

ZtLightsChart.prototype._EvaluateValueInRange = function (item, lastCategory) {
  var band = this.GetObjectFromRange(item.value, this.defSettings.range.bands);
  this.SetRangeInItems(item, band);
  var fill, dark, styleObj;
  if (band.indexBand >= 0 && band.indexBand == item.band && lastCategory != (item.valueField + "_" + item.category)) {
    item.on = true;
    fill = this._ApplyEffectLight(band.color, item.on);
    if (this.defSettings.chartStyle.indexOf("flat") >= 0) {
      styleObj = { fill: fill, stroke: fill };
      if (this.defSettings.chartStyle == "flat") {
        styleObj.stroke = this.items[item.itemIndex].color.color;
        styleObj.stroke9width = "3px";
      }

      if (item.blur_itm) {
        d3.select(item.blur_itm).attr("style", makeStyleHTMLString({ fill: fill }, d3.select(item.blur_itm).attr("style")));
      }
    }
    else {
      dark = d3.color(band.color).darker().toString();
      dark = d3.color(dark).darker().toString();
      styleObj = { fill: fill, stroke: dark, stroke9width: 0.2 + "px" };
    }
    item.colorApplied = band.color;
    item.bandColor = band.color;
    this.items[item.itemIndex].range = this.defSettings.range.bands[item.band].label;
    this.items[item.itemIndex].rangeIdx = band.indexBand;
  }
  else {
    item.on = false;
    if (this.defSettings.chartStyle.indexOf("flat") >= 0) {
      fill = this._ApplyEffectLight(this.defSettings.range.bands[item.band].color, true);
      styleObj = { fill: fill, fill9opacity: 0.2 };
      if (this.defSettings.chartStyle == "flat") {
        styleObj.stroke = this.items[item.itemIndex].color.color;
        styleObj.stroke9width = "3px";
      }

      if (item.blur_itm) {
        d3.select(item.blur_itm).attr("style", makeStyleHTMLString({ fill: "transparent" }, d3.select(item.blur_itm).attr("style")));
      }
    }
    else {
      fill = this._ApplyEffectLight(this.defSettings.range.bands[item.band].color, item.on);
      dark = d3.color(this.defSettings.range.bands[item.band].color).darker().toString();
      dark = d3.color(dark).darker().toString();
      styleObj = { fill: fill, stroke: dark, stroke9width: 0.2 + "px" };
    }
    item.bandColor = this.defSettings.range.bands[item.band].color;
  }

  d3.select(item.itm).attr("style", makeStyleHTMLString(styleObj, d3.select(item.itm).attr("style")));
  item.range = this.defSettings.range.bands[item.band].label;

  if (this.defSettings.chartStyle == "default" && this.defSettings.gauge.lightEffect == "concentric")
    this._CreateConcentricPath(item);
}

ZtLightsChart.prototype._SetInReferredList = function (label) {
  ZtPieChart.prototype._SetInReferredList.call(this, label);
}

ZtLightsChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG) {
  ZtPieChart.prototype._DrawMultiSVGPlot.call(this, id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG);
}

ZtLightsChart.prototype._CreateRangeColorsEffect = function () {
  var bands = this.defSettings.range.bands;
  for (var i = 0; i < bands.length; i++) {
    switch (this.defSettings.gauge.lightEffect) {
      case "bubble" :
        this._DrawEffectBubble(bands[i].color);
        break;
      case "concentric" :
        this._DrawEffectConcentric(bands[i].color);
        break;
      default :
        this._DrawEffectPlain(bands[i].color);
        break;
    }
  }
}

ZtLightsChart.prototype._DrawEffectPlain = function (color) {
  // effetto "on"
  var grad_on = this.chartId + color.slice(1) + "_on",
  grad_off = this.chartId + color.slice(1) + "_off",
  grad;
  if (Empty(this.svg.select("#" + grad_on).node())) {
    grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
      .append("radialGradient")
      .attr("id", grad_on)
      .attr("r", "75%")
      .attr("fx", "50%")
      .attr("fy", "85%");
    grad.append("stop")
      .attr("offset", "0%")
      .attr("stop-color", color)
      .attr("stop-opacity", "1");
  }
  else
    grad = this.svg.select("#" + grad_on);

  if (this.defSettings.chartStyle.indexOf("flat") < 0) {
    if (this.defSettings.gauge.lightEffect != "flat") {
      grad.append("stop")
        .attr("offset", "50%")
        .attr("stop-color", color)
        .attr("stop-opacity", "1");
      grad.append("stop")
        .attr("offset", "100%")
        .attr("stop-color", "#000000")
        .attr("stop-opacity", "1");
    }
  
    // effetto "off"
    if (Empty(this.svg.select("#" + grad_off).node())) {
      grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
        .append("radialGradient")
        .attr("id", this.chartId + color.slice(1) + "_off")
        .attr("r", "75%")
        .attr("fx", "50%")
        .attr("fy", "85%");
    }
    else
      grad = this.svg.select("#" + grad_off);

    var dark = d3.color(color).darker().toString(),
    dark1 = d3.color(dark).darker().toString();
    grad.append("stop")
      .attr("offset", "0%")
      .attr("stop-color", dark1)
      .attr("stop-opacity", "1");

    if (this.defSettings.gauge.lightEffect != "flat") {
      grad.append("stop")
        .attr("offset", "50%")
        .attr("stop-color", dark1)
        .attr("stop-opacity", "1");
      grad.append("stop")
        .attr("offset", "100%")
        .attr("stop-color", "#000000")
        .attr("stop-opacity", "1");
    }
  }
}

ZtLightsChart.prototype._DrawEffectBubble = function (color) {
  // effetto "on"
  var grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
    .append("radialGradient")
    .attr("id", this.chartId + color.slice(1) + "_on")
    .attr("r", "75%")
    .attr("fx", "50%")
    .attr("fy", "15%");
  grad.append("stop")
    .attr("offset", "0%")
    .attr("stop-color", color/*"#F0F0F0"*/)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "50%")
    .attr("stop-color", color)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "100%")
    .attr("stop-color", "#000000")
    .attr("stop-opacity", "1");

  // effetto "off"
  grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
    .append("radialGradient")
    .attr("id", this.chartId + color.slice(1) + "_off")
    .attr("r", "75%")
    .attr("fx", "50%")
    .attr("fy", "15%");

  var dark = d3.color(color).darker().toString(),
  dark1 = d3.color(dark).darker().toString(),
  darker = d3.color(dark1).darker().toString();

  grad.append("stop")
    .attr("offset", "0%")
    .attr("stop-color", dark1)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "50%")
    .attr("stop-color", darker)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "100%")
    .attr("stop-color", "#000000")
    .attr("stop-opacity", "1");
}

ZtLightsChart.prototype._DrawEffectConcentric = function (color) {
  var dark = d3.color(color).darker().toString(),
  dark1 = d3.color(dark).darker().toString(),
  darker = d3.color(dark1).darker().toString();

  // effetto "on"
  var grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
    .append("radialGradient")
    .attr("id", this.chartId + color.slice(1) + "_on")
    .attr("r", "80%")
    .attr("fx", "75%")
    .attr("fy", "80%");
  grad.append("stop")
    .attr("offset", "0%")
    .attr("stop-color", color)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "60%")
    .attr("stop-color", dark)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "100%")
    .attr("stop-color", "#000000")
    .attr("stop-opacity", "1");

  // effetto "off"
  grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
    .append("radialGradient")
    .attr("id", this.chartId + color.slice(1) + "_off")
    .attr("r", "75%")
    .attr("fx", "50%")
    .attr("fy", "15%");

  grad.append("stop")
    .attr("offset", "0%")
    .attr("stop-color", dark1)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "60%")
    .attr("stop-color", darker)
    .attr("stop-opacity", "1");
  grad.append("stop")
    .attr("offset", "100%")
    .attr("stop-color", "#000000")
    .attr("stop-opacity", "1");
}

ZtLightsChart.prototype._CreateConcentricPath = function (item) {
  var color = item.bandColor,
  dark = d3.color(color).darker().toString(),
  dark1 = d3.color(dark).darker().toString(),
  darker = d3.color(dark1).darker().toString(),
  pgroup = d3.select(item.itm.parentNode),
  radius = item.r / 8;

  for (var i = 0; i * radius < item.r; i++) {
    pgroup.append("circle")
      .attr("class", "TRANSP cPath_" + color.slice(1) + "_on")
      .attr("cx", item.coordinates.x)
      .attr("cy", item.coordinates.y)
      .attr("r", i * radius)
      .style("fill", "transparent")
      .style("stroke", item.on ? color : darker)
      .style("stroke-width", 1 + "px")
      .style("stroke-linecap", "butt")
      .style("stroke-dasharray", "2,2");
  }
}

ZtLightsChart.prototype._ApplyEffectLight = function (color, isON) {
  var gradID = this.chartId + color.slice(1);
  if (isON)
    gradID += "_on";
  else
    gradID += "_off";
  return "url(#" + gradID + ")";
}

ZtLightsChart.prototype.ResetItems = function () {
  StdChart.prototype.ResetItems.call(this);
  this.lights = [];
}

ZtLightsChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this.defSettings.range = lastChart.defSettings.range;
  this._ApplyEvents();

  var record,
  lastValues,
  dataIndex,
  yIndex,
  cList = getList(this.xIndex, this.dataSet),
  item,
  lastCategory = "";

  for (var i = 0; i < this.lights.length; i++) {
    if (this.lights[i].itm) {
      item = this.lights[i];

      dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);
      record = this.dataSet[dataIndex];
      yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);
      item.value = record[yIndex];

      lastValues = {};
      lastValues.status = item.on ? "on" : "off";

      this._EvaluateValueInRange(item, lastCategory);
      if (item.on)
        lastCategory = item.valueField;

      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtLightsChart.prototype._SetItems = function (chart) {
  this.items = chart.items.slice();
  this.lights = chart.lights.slice();
}

ZtLightsChart.prototype._GetValueLabelX = function (pos, item/*, text, font*/) {
  var offset = 3.5,
  x = item.coordinates.x;
  switch (pos) {
    case "otop":
    case "obottom":
      x += getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) / 2;
      break;
    case "oleft":
      x += getDomNodeLeft(item.itm) - offset;
      break;
    case "oright":
      x += getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) + offset;
      break;
  }
  return x;
}

ZtLightsChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  var offset = 3.5,
  y = item.coordinates.y;
  switch (pos) {
    case "otop":
      y += getDomNodeTop(item.itm) - offset;
      break;
    case "obottom":
      y += getDomNodeTop(item.itm) + getDomNodeHeight(item.itm) + getOffsetHeight(text, font, this.chartId) + offset;
      break;
    case "oleft":
    case "oright":
      y += getDomNodeTop(item.itm) + getDomNodeHeight(item.itm) / 2 + getOffsetHeight(text, font, this.chartId) / 4;
      break;
  }
  return y;
}

ZtLightsChart.prototype._DrawValueLabels = function () {
  ZtDialChart.prototype._DrawValueLabels.call(this);
}

ZtLightsChart.prototype._AppendValueLabels = function (index) {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels"),
  items = this._GetItems().filter( function (item) { return item.sidx == index; }),
  item;
  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
    pos = this.defSettings.valueLabel.position,
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    label = group.append("text")
              .attr("x", this._GetValueLabelX(pos, item, text, font))
              .attr("y", this._GetValueLabelY(pos, item, text, font))
              .style("text-anchor", function () {
                switch (pos) {
                  case "otop":
                  case "obottom":
                  case "in":
                    return "middle";
                    break;
                  case "oleft":
                    return "end";
                    break;
                  case "oright":
                    return "start";
                    break;
                }
              })
              .text(text);
    setFont(label, font, this);
  }
}

ZtLightsChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  if (this.defSettings.chartStyle == "default") {
    StdChart.prototype._ApplyItemSVGSelectEffect.call(this, items, selected);
    return;
  }

  if (!this._ZtChart.enableClickEffect)
    return;
  var halfOpacity = this.defSettings.selectionOptions.opacity,
  fullOpacity = 1,
  stobj;
  for (var i = 0; i < items.length; i++) {
    if (!items[i].itm)
      continue;
    stobj = {};
    if (selected) {
      stobj.fill9opacity = fullOpacity;
      stobj.stroke9opacity = fullOpacity;
    }
    else {
      stobj.fill9opacity = halfOpacity;
      stobj.stroke9opacity = halfOpacity;
    }
    this.svg.select("#" + items[i].groupID).attr("style", makeStyleHTMLString(stobj, this.svg.select("#" + items[i].groupID).attr("style")));
  }
}