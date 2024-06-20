function ZtDisplayChart(type) {
  ZtLightsChart.apply(this);
  this.type = type;
  this.legendHexCode = "f76a";
  this.itemsText = [];
}
ZtDisplayChart.prototype = Object.create(ZtLightsChart.prototype);
ZtDisplayChart.prototype.constructor = ZtDisplayChart;

ZtDisplayChart.prototype._SetChartSettingsJSON = function () {
  ZtDialChart.prototype._SetChartSettingsJSON.call(this);

  this.multipleScales = false;
  this.defSettings.displayFont = this.chartConfig.graphSettings.displayLabel.displayFont;

  if (this.type == "DISPLAY") {
    this.defSettings.chartStyle = this.chartConfig.graphSettings.extends.styles.display;
    if (this.defSettings.chartStyle == "minimal") {
      this.defSettings.displayFont.name = "Lets go Digital";
    }
  }
}

ZtDisplayChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  id = "",
  group,
  mvalues,
  oList = this._GetOppositeAxisDrawingList(),
  domainLabelH = 0;

  if (oList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  for (var i = 0; i < positions.length; i++) {
    var ph = positions[i].height - domainLabelH;
    id = this.chartId + i + "_";
    var xIndex = Empty(this.objConfig.keyField) ? this.xIndex : this.xLabelIndex;
    mvalues = this.dataSet.filter( function(record) { return record[xIndex] == oList[i]; } );
    this._SetCalculationDataset(mvalues);
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup");
    if (this.defSettings.chartStyle == "simple" && this.type == "DISPLAY")
      this.DrawDisplayText(group, this.calcDataset, i, id, positions[i].width, ph);
    else
      this.DrawDisplay(group, this.calcDataset, i, id, positions[i].width, ph);

    if (oList.length > 1)
      this.DrawDomainLabel(i, positions[i], oList[i]);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtDisplayChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  colD,
  i,
  styleObj;

  if (this.defSettings.chartStyle == "simple") {
    for (i = 0; i < this.itemsText.length; i++) {
      var item = this.items[this.itemsText[i].relatedItem];
      idx = this.valueFields.indexOf(item.valueField);
      if (idx >= 0) {
        item.idx = idx;
        item.sidx = this.categoryList.indexOf(item.category);
        item.color = this.colorSet[idx];
        if (this.valueFields.length == 1) {
          if (!Empty(this.defSettings.displayFont.color)) {
            item.color = { color: this.defSettings.displayFont.color, gradient: "" };
          }
        }
        styleObj = {};
        styleObj.fill = item.color.color;
        styleObj.font9family = this._GetDisplayTextFont();
        d3.select(this.itemsText[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.itemsText[i].itm).attr("style")));
      }
    }
  }
  else {
    for (i = 0; i < this.items.length; i++) {
      idx = this.valueFields.indexOf(this.items[i].valueField);
      if (idx >= 0) {
        this.items[i].idx = idx;
        this.items[i].sidx = this.categoryList.indexOf(this.items[i].category);
        this.items[i].color = this.colorSet[idx];
        if (this.defSettings.useColorSeriesForEach)
          this.items[i].color = this.colorSet[i];
        styleObj = {};
        colD = this._CreateDisplayGradient(this.items[i].color, idx, this.type);
        styleObj.fill = colD;
        d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      }
    }
  }
}

ZtDisplayChart.prototype._GetAnimatedDivisor = function() {
  return ZtRadarChart.prototype._GetAnimatedDivisor.call(this);
}

ZtDisplayChart.prototype._AnimateChartElements = function () {
  var div = this._GetAnimatedDivisor();
  for (var i = 0; i < this.itemsText.length; i++) {
    var elem = this.itemsText[i].itm;
    if (!elem)
      continue;

    if (!isNaN(parseInt(this.itemsText[i].digit))) {
      d3.select(elem)
        .attr("text-org", this.itemsText[i].digit)
        .attr("text-end", parseInt(this.itemsText[i].digit))
        .text(0)
        .transition()
        .style("fill-opacity", 1)
          .tween("text", function() {
            var selection = d3.select(this);
            var start = d3.select(this).text();
            var end = d3.select(this).attr("text-end");
            var interpolator = d3.interpolate(start, end); // d3 interpolator
            return function(t) {
              if (t == 1)
                selection.text(selection.attr("text-org"));
              else
                selection.text(Math.round(interpolator(t)));
            };  // return value
          })
          .duration(this.defSettings.animation.duration/div)
      }
      else {
        d3.select(elem)
        //.style("fill-opacity", 0)
        .attr("style", makeStyleHTMLString({fill9opacity:0}, d3.select(elem).attr("style")))
        .transition()
          //.style("fill-opacity", 1)
          .attr("style", makeStyleHTMLString({fill9opacity:1}, d3.select(elem).attr("style")))
          .duration(this.defSettings.animation.duration/div)
      }
  }
}

ZtDisplayChart.prototype._GetDisplayTextFont = function () {
  if (!Empty(this.defSettings.displayFont.name))
    return this.defSettings.displayFont.name;
  if (this.type == "DISPLAY")
    return "Lets go Digital";
  if (this.type == "COUNTER")
    return "Source Code Pro"
  if (this.type == "PADDLE")
    return "Open Sans";
}

ZtDisplayChart.prototype._GetFontSize = function (fsize) {
  if (this.type == "COUNTER")
    return fsize * 0.6;
  if (this.type == "PADDLE")
    return fsize * 0.8;
  return fsize;
}

ZtDisplayChart.prototype._AdjustDisplayText = function () {
  if (this.defSettings.chartStyle != "default")
    return;

  var sizes,
  item,
  mysize;
  for (var i = 0; i < this.itemsText.length; i++) {
    item = this.itemsText[i];
    sizes = getDomNodeSizes(item.itm);

    if (this.type == "DISPLAY") {
      d3.select(item.itm)
        .attr("x", parseFloat(d3.select(item.itm).attr("x")) + item.width - 2)
        .attr("y", sizes.height)
        .style("text-anchor", "end");
   }
    else /*if (this.type == "COUNTER")*/ {
      mysize = (Math.max(item.width, sizes.width) - Math.min(item.width, sizes.width)) / 2;
      d3.select(item.itm)
        .attr("x", parseFloat(d3.select(item.itm).attr("x")) + mysize)
      mysize = (Math.max(item.height, sizes.height) - Math.min(item.height, sizes.height)) / 2;
      if (this.type == "COUNTER")
        d3.select(item.itm)
          .attr("y", (item.height / 2) + (sizes.height / 4))
      else
        d3.select(item.itm)
          .attr("y", (item.height / 2) + (sizes.height / 3))
    }
  }
}

ZtDisplayChart.prototype._CreateDisplayGradient = function (colorobj, index, type) {
  var fill = "url(#" + this.chartId,
  gradID, grad, dark, dark1, darker,
  color = colorobj.color,
  cgrad = colorobj.gradient;
  if (type == "DISPLAY") {
    if (Empty(cgrad))
      return color;
    gradID = "dispgrad_" + index;
    if (Empty(d3.select("#" + this.chartId + gradID).node())) {
      grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
        .append("linearGradient")
        .attr("id", this.chartId + gradID)
        .attr("spreadMethod", "pad")
        .attr("x1", "0%")
        .attr("x2", "100%")
        .attr("y1", "100%")
        .attr("y2", "0%");

      grad.append("stop")
        .attr("offset", "0%")
        .attr("stop-color", color)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "100%")
        .attr("stop-color", cgrad)
        .attr("stop-opacity", "1");
    }
  }
  else if (type == "COUNTER") {
    gradID = "counterg_" + index;
    if (Empty(d3.select("#" + this.chartId + gradID).node())) {
      grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
        .append("linearGradient")
        .attr("id", this.chartId + gradID)
        .attr("spreadMethod", "pad")
        .attr("x1", "0%")
        .attr("x2", "0%")
        .attr("y1", "0%")
        .attr("y2", "100%");

      dark = d3.color(color).darker().toString();
      dark1 = d3.color(dark).darker().toString();
      darker = d3.color(dark1).darker().toString();

      grad.append("stop")
        .attr("offset", "0%")
        .attr("stop-color", dark1)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "45%")
        .attr("stop-color", color)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "55%")
        .attr("stop-color", color)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "100%")
        .attr("stop-color", dark1)
        .attr("stop-opacity", "1");
    }
  }
  else {  // PADDLE
    gradID = "paddleg_" + index;
    if (Empty(d3.select("#" + this.chartId + gradID).node())) {
      grad = this.svg.select("#" + this.__cID + "d3ChartDefs")
        .append("linearGradient")
        .attr("id", this.chartId + gradID)
        .attr("spreadMethod", "pad")
        .attr("x1", "0%")
        .attr("x2", "0%")
        .attr("y1", "0%")
        .attr("y2", "100%");

      dark = d3.color(color).darker().toString();
      dark1 = d3.color(dark).darker().toString();
      darker = d3.color(dark1).darker().toString();

      grad.append("stop")
        .attr("offset", "0%")
        .attr("stop-color", color)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "5%")
        .attr("stop-color", dark)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "35%")
        .attr("stop-color",dark1)
        .attr("stop-opacity","1");

      grad.append("stop")
        .attr("offset", "50%")
        .attr("stop-color", darker)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "65%")
        .attr("stop-color",dark1)
        .attr("stop-opacity","1");

      grad.append("stop")
        .attr("offset", "75%")
        .attr("stop-color", dark)
        .attr("stop-opacity", "1");

      grad.append("stop")
        .attr("offset", "100%")
        .attr("stop-color", color)
        .attr("stop-opacity", "1");
    }
  }

  fill += (gradID + ")");
  return fill;
}

ZtDisplayChart.prototype._DrawDisplayLines = function (cont, idx, dcount, progrX, wDiff, height, color) {
  switch (this.type) {
    case "COUNTER" :
      if (idx < dcount - 1) {
        cont.append("path")
          .attr("class", "TRANSP divisorline")
          .attr("d", "M" + (progrX + wDiff - (wDiff * 0.05)) + "," + ((height * 0.02) + ((height * 0.96) / 3)) + " v" + ((height * 0.96) / 3))
          .style("shape-rendering", "crispEdges")
          .style("stroke", "#454545")

        cont.append("path")
          .attr("class", "TRANSP divisorline")
          .attr("d", "M" + (progrX + wDiff + (wDiff * 0.05)) + "," + ((height * 0.02) + ((height * 0.96) / 3)) + " v" + ((height * 0.96) / 3))
          .style("shape-rendering", "crispEdges")
          .style("stroke", "#454545")
      }
      break;
    case "PADDLE" :
      cont.append("rect")
        .attr("class", "TRANSP divisorline")
        .attr("x", progrX + ((wDiff * 0.9) * 0.05))
        .attr("y", (height * 0.02) + (height / 2))
        .attr("width", wDiff * 0.9)
        .attr("height", 1)
        .style("fill", "url(#" + this.chartId + "rendererGradient)")

      cont.append("rect")
        .attr("x", progrX + (wDiff * 0.05) + (wDiff * 0.9 * 0.1))
        .attr("y", (height * 0.02) + (height / 2) - (height * 0.075))
        .attr("rx", "2px")
        .attr("ry", "2px")
        .attr("height", height * 0.15)
        .attr("width", "3px")
        .style("fill", color)

      cont.append("rect")
        .attr("x", progrX + (wDiff * 0.05) + (wDiff * 0.9) - (wDiff * 0.9 * 0.1) - 3)
        .attr("y", (height * 0.02) + (height / 2) - (height * 0.075))
        .attr("rx", "2px")
        .attr("ry", "2px")
        .attr("height", height * 0.15)
        .attr("width", "3px")
        .style("fill", color)
      break;
    default :
      if (idx < dcount - 1) {
        cont.append("path")
          .attr("class", "TRANSP divisorline")
          .attr("d", "M" + (progrX + wDiff) + "," + (height * 0.02) + " v" + (height * 0.96))
          .style("shape-rendering", "crispEdges")
          .style("stroke", "#454545")
      }
      break;
  }
}

ZtDisplayChart.prototype._ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (this.defSettings.range.applyColor)
    this._SetElementsRangeColor(isFnc);
  else
    this._SetDisplayRangeColor(this.items, isFnc);
}

ZtDisplayChart.prototype._SetElementsRangeColor = function (isFnc) {
  this._SetDisplayRangeColor(this.itemsText, isFnc);
}

ZtDisplayChart.prototype._SetDisplayRangeColor = function (items, isFnc) {
  var fill;
  for (var i = 0; i < items.length; i++) {
    if (isFnc) {
      if (this.functionObj && ("GetConditionalFormatting" in this.functionObj)) {
        var fncRet = this.functionObj.GetConditionalFormatting(this._GetItemObj(this.items[i]));
        fill = decodeConditionalFormatting(fncRet).fill;
      }
    }
    else {
      var band = this.GetObjectFromRange(items[i].value, this.defSettings.range.bands);
      fill = band.color;
      this.SetRangeInItems(items[i], band);
    }
    items[i].colorApplied = fill;
    d3.select(items[i].itm).style("fill", fill);
  }
}

ZtDisplayChart.prototype._GetDisplayText = function (value) {
  if (this.defSettings.valueLabel.type == "hide")
    return value;
  if (this.defSettings.valueLabel.position != "in")
    return value;
  return this.GetValuePicture(value);
}

ZtDisplayChart.prototype._GetDisplayTextFromItem = function (item) {
  // apply picture + funzione
  var value = item.value,
  txt = "";
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture) {
      txt = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
    }
  }
  else {
    if (!isNaN(this.defSettings.valueLabel.valuePrecision))
      value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
    txt = this.GetValuePicture(value);
  }
  return txt;
}

ZtDisplayChart.prototype._DrawValueLabels = function () {
  if (this.defSettings.valueLabel.position != "in")
    ZtLightsChart.prototype._DrawValueLabels.call(this);
}
