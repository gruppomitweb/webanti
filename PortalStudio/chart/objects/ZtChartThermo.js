function ZtThermoChart() {
  ZtDialChart.apply(this);
  this.type = "THERMO";
  this.legendHexCode = "f055";
  this.isH = false;
}
ZtThermoChart.prototype = Object.create(ZtDialChart.prototype);
ZtThermoChart.prototype.constructor = ZtThermoChart;

ZtThermoChart.prototype._SetChartSettingsJSON = function () {
  ZtDialChart.prototype._SetChartSettingsJSON.call(this);
  this.isH = this.chartConfig.graphSettings.gauge.orientation != "vertical";
}

ZtThermoChart.prototype._SetCustomScaleParameters = function (scaleKey, scaleY, min, max) {
  if (!this.isH) {
    scaleY.domain([max, min])
      .range([this.pHeight - 2 * (this.radius * 1.1) - this.hElement, this.pHeight - 2 * (this.radius * 1.1)]);
  }
  else {
    scaleY.domain([min, max])
      .range([2 * (this.radius * 1.1), this.hElement + 2 * (this.radius * 1.1)]);
  }
}

ZtThermoChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  id = "",
  group,
  radius,
  hElement,
  mvalues,
  progressWidth,
  //_this = this,
  oList = this._GetOppositeAxisDrawingList(),
  cobj = {},
  aCont,
  trsf;

  var domainLabelH = 0;
  if (oList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  for (var i = 0; i < positions.length; i++) {
    var ph = positions[i].height - domainLabelH;
    radius = ph * 0.2
    radius = radius / 2;
    hElement = !this.isH ? (ph * 0.9 - 2 * (radius * 1.1)) : (positions[i].width * 0.8) - 3 * radius;
    this.radius = radius;
    this.hElement = hElement;
    progressWidth = (radius * 1.1) * 0.8;
    id = this.chartId + i + "_";
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup");
    if (!this.isH)
      trsf = [positions[i].width / 2 - (radius * 1.1), 0];
    else
      trsf = [0, positions[i].height / 2 - (radius * 1.1)];

    group.attr("transform", "translate(" + trsf + ")");

    this.pHeight = ph;
    cobj.barWidth = progressWidth;
    cobj.id = id;
    cobj.transform = [positions[i].x + trsf[0], positions[i].y];
    cobj.groupTransform = trsf.slice();
    var xIndex = Empty(this.objConfig.keyField) ? this.xIndex : this.xLabelIndex;
    mvalues = this.dataSet.filter( function(record) { return record[xIndex] == oList[i]; } );
    aCont = group.append("g").attr("id", id + "tickAxisGroup");

    this._DrawCustomAxis(aCont, id);
    this.DrawThermometer(group, mvalues, i, cobj);

    if (oList.length > 1)
      this.DrawDomainLabel(i, positions[i], oList[i]);

    group.node().insertBefore(aCont.node(), group.node().lastChild);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtThermoChart.prototype._SetAxisColor = function () {
  var oldChartId = this.chartId,
  scs = Object.keys(this.scaleY);
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    for (var j = 0; j < scs.length; j++) {
      if (!this.scaleY[scs[j]].__noDraw)
        this.SetAxisColor("tick", null, null, true, replaceSpecialCharsForID("_" + scs[j]), this.scaleY[scs[j]]);
    }
  }
  this.chartId = oldChartId;
}

ZtThermoChart.prototype._SetAxisFont = function () {
  var oldChartId = this.chartId,
  scs = Object.keys(this.scaleY);
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    for (var j = 0; j < scs.length; j++) {
      if (!this.scaleY[scs[j]].__noDraw)
        this.SetAxisFont("tick", replaceSpecialCharsForID("_" + this.scaleY[scs[j]].__refAxis), this.scaleY[scs[j]].__refAxis, true);
    }
  }
  this.chartId = oldChartId;
}

ZtThermoChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  colD;

  // bordo
  var oldChartId = this.chartId;
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    d3.select("#" + this.chartId + "border")
      .attr("style", makeStyleHTMLString({ stroke: this.defSettings.gauge.extendLine.color,
                                           stroke9width: this.defSettings.gauge.extendLine.stroke,
                                           fill: "transparent" }, d3.select("#" + this.chartId + "border").attr("style")));
  }
  this.chartId = oldChartId;

  for (i = 0; i < this.items.length; i++) {
    idx = this.valueFields.indexOf(this.items[i].valueField);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      this.items[i].sidx = this._GetOppositeDrawingList().indexOf(this.items[i].category);
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
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      if (this.items[i].itemType == "bar") {
        d3.select(this.items[i].itm)
          .attr("rx", this.items[i].radius)
          .attr("ry", this.items[i].radius);
      }
    }
  }
}

ZtThermoChart.prototype._GetElementHeight = function () {
  return this.hElement;
}

ZtThermoChart.prototype._GetPositionHeight = function () {
  return this.pHeight;
}

ZtThermoChart.prototype._GetAnimatedDivisor = function() {
  return ZtRadarChart.prototype._GetAnimatedDivisor.call(this);
}

ZtThermoChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var value,
  div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj);

  if (item.itemType == "bar") {
    if (!this.isH) {
      value = d3.select(elem).attr("height");
      var value2 = d3.select(elem).attr("y");
      d3.select(elem)
        .attr("height", defaultValues ? 0 : lastValueObj.height)
        .attr("y", defaultValues ? (parseFloat(value) + parseFloat(value2)) : lastValueObj.y)
        .transition()
          .delay(item.idx * duration / div)
          .duration(duration / div)
          .ease(d3.easeLinear)
          .attr("height", value)
          .attr("y", value2);
    }
    else {
      value = d3.select(elem).attr("width");
      d3.select(elem)
        .attr("width", defaultValues ? 0 : lastValueObj.width)
        .transition()
          .delay(item.idx * duration / div)
          .duration(duration / div)
          .ease(d3.easeLinear)
          .attr("width", value);
    }
  }
  else {
    value = d3.select(elem).attr("r");
    d3.select(elem)
      .attr("r", 0)
      .transition()
        .delay(item.idx * duration / div)
        .duration(duration / div)
        .ease(d3.easeLinear)
        .attr("r", value);
  }
}

ZtThermoChart.prototype._NotAnimatedChartElements = function () { }

ZtThermoChart.prototype._DrawTicks = function (container, ticksValues, isMajor, scaleY) {
  var offset = this._GetRadius() / 2,
  tickLen = isMajor ? offset * 0.75 : offset / 2,
  tGroup,
  _this = this;

  for (var i = 0; i < ticksValues.length; i++) {
    var tick = ticksValues[i];
    tGroup = container.append("g")
      .attr("class", "tick");

    if (typeof tick != "number")
      tick = parseFloat(tick);

    tGroup.append("line")
      .attr("y1", function () {
        if (!_this.isH)
          return scaleY(tick);
        return offset * 0.2 + offset;
      })
      .attr("y2", function () {
        if (!_this.isH)
          return scaleY(tick);
        return offset * 0.2 + offset + tickLen;
      })
      .attr("x1", function () {
        if (!_this.isH)
          return offset * 0.2 + offset;
        return scaleY(tick);
      })
      .attr("x2", function () {
        if (!_this.isH)
          return offset * 0.2 + offset + tickLen;
        return scaleY(tick);
      })
      .style("shape-rendering", "crispEdges");

    if (isMajor) {
      tGroup.attr("data-major", "majorTick")
        .append("text")
        .attr("class", "tickAxLabel")
        .attr("x", function () {
          if (!_this.isH)
            return offset / 2;
          return scaleY(tick) + 1;
        })
        .attr("y", function () {
          if (!_this.isH)
            return scaleY(tick) + 1;
          return offset / 2;
        })
        .attr("dy", "2px")
        .style("text-anchor", function () {
          if (_this.isH)
            return "middle";
          return "end";
        })
        .text(tick);
    }
  }
}

ZtThermoChart.prototype._GetBarX = function (d, dataIndex, xIndex, yIndex, cobj) {
  if (!this.isH) {
    var calc = (this._GetRadius() * 1.1) / 2;
    return calc + (((this._GetRadius() * 1.1) - cobj.barWidth) / 2);
  }

  return cobj.scaleY.range()[0] - (this._GetRadius() * 1.1);
}

ZtThermoChart.prototype._GetBarY = function (d, dataIndex, xIndex, yIndex, cobj) {
  if (this.isH) {
    var calc = (this._GetRadius() * 1.1) / 2;
    return calc + (((this._GetRadius() * 1.1) - cobj.barWidth) / 2);
  }

  var vRange = cobj.scaleY.domain(),
  min = vRange[1],
  max = vRange[0];
  if (d[yIndex] < min || d[yIndex] > max) {
    if (Math.abs(min - d[yIndex]) < Math.abs(max - d[yIndex]))
      return cobj.scaleY(min);
    return cobj.scaleY(max);
  }
  return cobj.scaleY(d[yIndex]);
}

ZtThermoChart.prototype._GetBarWidth = function (d, yIndex, cobj) {
  if (!this.isH)
    return cobj.barWidth;

  var vRange = cobj.scaleY.domain(),
  min = vRange[0],
  max = vRange[1];
  if (d[yIndex] < min || d[yIndex] > max) {
    if (Math.abs(min - d[yIndex]) < Math.abs(max - d[yIndex]))
      return Math.abs(cobj.scaleY(min) - (cobj.scaleY.range()[0] + this._GetRadius() * 1.1));
    return Math.abs(cobj.scaleY(max) - (cobj.scaleY.range()[0] + this._GetRadius() * 1.1));
  }
  return Math.abs(cobj.scaleY(d[yIndex]) - cobj.scaleY.range()[0] + this._GetRadius() * 1.1);
}

ZtThermoChart.prototype._GetBarHeight = function (d, yIndex, cobj) {
  if (this.isH)
    return cobj.barWidth;

  var vRange = cobj.scaleY.domain(),
  min = vRange[1],
  max = vRange[0];
  if (d[yIndex] < min || d[yIndex] > max) {
    if (Math.abs(min - d[yIndex]) < Math.abs(max - d[yIndex]))
      return Math.abs(cobj.scaleY(min) - (cobj.scaleY.range()[1] + this._GetRadius() * 1.1));
    return Math.abs(cobj.scaleY(max) - (cobj.scaleY.range()[1] + this._GetRadius() * 1.1));
  }
  return Math.abs(cobj.scaleY(d[yIndex]) - (cobj.scaleY.range()[1] + this._GetRadius() * 1.1));
}

ZtThermoChart.prototype._ApplyMouseOver = function (item, itemObj) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  this.RemoveAllHovers();
  if (item) {
    var itemObject = itemObj || this._GetItems()[d3.select(item).attr("item-index")],
    bothItems = this._GetRelatedItm(itemObject),
    clone;

    for (var i = 0; i < bothItems.length; i++) {
      clone = this._GetItemClone(bothItems[i].itm, bothItems[i]);
      d3.select(clone)
        .attr("item-type", "hover")
        .style("opacity", 0.5)
        .style("fill", function () {
          if (!Empty(_this.defSettings.hoverColor))
            return _this.defSettings.hoverColor;
          var darkCol = d3.rgb(itemObject.colorApplied).darker().toString();
          darkCol = d3.rgb(darkCol).darker().toString();
          return d3.rgb(darkCol).darker().toString();
        })
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
    }

    this.ShowTooltip(mRefChart, item, itemObject);
  }
}

ZtThermoChart.prototype._GetRelatedItm = function (itemObject) {
  var ret = [],
  mitems = this.items,
  f = false;
  ret.push(itemObject);
  for (var i = 0; !f && i < mitems.length; i++) {
    if (this._CheckIdentityItem(itemObject, mitems[i]) && itemObject.itemType != mitems[i].itemType) {
      ret.push(mitems[i]);
      f = true;
    }
  }
  return ret;
}

ZtThermoChart.prototype._AdjustCap = function () { }

ZtThermoChart.prototype._SetValueAxisPositions = function () {
  if (!this.scaleY)
    return;
  var scs = Object.keys(this.scaleY),
  progrX = 0,
  mwidth = 0,
  maxis,
  offset = 10,
  oldChartId = this.chartId;

  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    progrX = 0;
    for (var j = 0; j < scs.length; j++) {
      maxis = d3.select("#" + this.chartId + "tickAxisGroup_" + replaceSpecialCharsForID(scs[j])).node();
      if (maxis) {
        mwidth = getDomNodeWidth(maxis) + offset;
        if (j > 0)
          d3.select(maxis).attr("transform", "translate(" + [progrX, 0] + ")");
        progrX = progrX - mwidth;
      }
    }
  }
  this.chartId = oldChartId;
}

ZtThermoChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  cobj,
  dataIndex,
  yIndex,
  cList = getList(this.xIndex, this.dataSet),
  item;

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm && this.items[i].itemType != "circle") {
      item = this.items[i];
      dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);
      lastValues = {};
      lastValues.width = parseFloat(d3.select(item.itm).attr("width"));
      lastValues.height = parseFloat(d3.select(item.itm).attr("height"));
      lastValues.x = parseFloat(d3.select(item.itm).attr("x"));
      lastValues.y = parseFloat(d3.select(item.itm).attr("y"));

      if (dataIndex < 0) {
        item.value = null;
        if (!this.isH)
          d3.select(item.itm).attr("width", 0);
        else {
          d3.select(item.itm).attr("y", parseFloat(d3.select(item.itm).attr("y")) + parseFloat(d3.select(item.itm).attr("height")));
          d3.select(item.itm).attr("height", 0);
        }
      }
      else {
        record = this.dataSet[dataIndex];
        cobj = ZtLayeredBarChart.prototype._GetDrawParamObject.call(this, item.barWidth);
        cobj.scaleY = this.scaleY[item.valueField];
        yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);
        item.value = record[yIndex];
        if (!this.isH) {
          d3.select(item.itm).attr("x", this._GetBarX(record, item.sidx, this.xIndex, yIndex, cobj));
          d3.select(item.itm).attr("width", this._GetBarWidth(record, yIndex, cobj));
        }
        else {
          d3.select(item.itm).attr("y", this._GetBarY(record, item.sidx, this.xIndex, yIndex, cobj));
          d3.select(item.itm).attr("height", this._GetBarHeight(record, yIndex, cobj));
        }
      }

      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtThermoChart.prototype._MapScalesFromChart = function (chart) {
  this.scaleY = chart.scaleY;
  this.radius = chart.radius;
  this.hElement = chart.hElement;
  this.pHeight = chart.pHeight;
}

ZtThermoChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  items = this._GetItems().filter( function (item) { return item.itemType == "bar" } ),
  item,
  _this = this;

  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
    pos = this.isH ? "otop" : "oright",
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    label = group.append("text")
              .attr("x", this._GetValueLabelX(pos, item, text, font))
              .attr("y", this._GetValueLabelY(pos, item, text, font))
              .text(text);
    setFont(label, font, this);

    if (this._EvaluatePrintValueLabel(this.defSettings.valueLabel.type, item)) {
      group.append("path")
        .attr("d", function () {
          var path = "",
          offset = 2;
          if (_this.isH) {
            path = "M" + _this._GetValueLabelX(pos, item, text, font) + "," + (_this._GetValueLabelY(pos, item, text, font) + offset);
            path += "V" + (item.transform[1] + item.groupTransform[1] + getDomNodeTop(item.itm) + (getDomNodeHeight(item.itm) / 2))
          }
          else {
            path = "M" + (_this._GetValueLabelX(pos, item, text, font) - offset) + "," + (_this._GetValueLabelY(pos, item, text, font) - offset);
            path += "H" + (item.transform[0] + getDomNodeLeft(item.itm) + (getDomNodeWidth(item.itm) / 2))
          }
          return path;
        })
        .style("stroke", "#000000")
        .style("shape-rendering", "crispEdges");
    }
  }
}
ZtThermoChart.prototype._GetValueLabelX = function (pos, item/*, text, font*/) {
  if (!this.isH && pos != "oright")
    return "";
  if (this.isH && pos != "otop")
    return "";
  var offset = 5,
  scaleY;
  if (this.isH) {
    scaleY = this.scaleY[item.valueField];
    return item.transform[0] + scaleY(item.value);
  }
  return item.transform[0] + (2 * this._GetRadius() * 1.1) + offset;
}
ZtThermoChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  if (!this.isH && pos != "oright")
    return "";
  var offset = 2;
  if (this.isH)
    return item.transform[1] + item.groupTransform[1] - (getOffsetHeight(text, font, this.chartId) + offset);
  return getDomNodeTop(item.itm) + item.transform[1] + offset;
}
ZtThermoChart.prototype._ExecScale = function () { }
