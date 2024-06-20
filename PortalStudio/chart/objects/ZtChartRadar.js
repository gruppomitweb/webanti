function ZtRadarChart(type, isArea) {
  StdChart.apply(this, [type, (isArea >= 0 ? "f1fe" : "e696")]);
  this.isArea = isArea >= 0 ? true : false;
  this.angRange = null;
  this.factor = 0.85;
}
ZtRadarChart.prototype = Object.create(StdChart.prototype);
ZtRadarChart.prototype.constructor = ZtRadarChart;

ZtRadarChart.prototype._SetChartSettingsJSON = function () {
  ZtLinesChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.radar = this.chartConfig.graphSettings.radar;
  this.defSettings.fillTransparency = this.chartConfig.graphSettings.fillTransparency;
}

ZtRadarChart.prototype._SetTitles = function () {
  ZtPieChart.prototype._SetTitles.call(this);
}

ZtRadarChart.prototype._SetLists = function () {
  ZtPieChart.prototype._SetLists.call(this);
}

ZtRadarChart.prototype._SetCalculationDataset = function (dataset) {
  this.calcDataset = getRadarDataset(dataset, this.scaleY, this.chartWidth, this.chartHeight, this.angRange, this._GetOppositeDrawingList(), this.propertyName);
}

ZtRadarChart.prototype._DrawChartPlot = function () {
  ZtLinesChart.prototype._DrawChartPlot.call(this);
}

ZtRadarChart.prototype._DrawChartPlotElements = function () {
  ZtLinesChart.prototype._DrawChartPlotElements.call(this);
}

ZtRadarChart.prototype._SetAnglesAxis = function () {
  var dSeries = this._GetOppositeDrawingList(),
  ang = 360 / dSeries.length;  //ampiezza angolo tra un asse e l'altro
  this.angRange = d3.range(0, 360, ang); // genera gli angoli (deg) in cui posizionare gli assi (rotazione del principale)
}

ZtRadarChart.prototype._DrawAxis = function () {
  var dSeries = this._GetOppositeDrawingList(),
  stAngle,
  factor = this.factor,
  ticksV = [],
  appFont = appliedFont(this.defSettings, this.defSettings.valueAxis, this.defSettings.valueAxis.valueFont),
  vRange,
  gTick,
  _this = this,
  scale,
  scaleKey,
  gAxis,
  angle,
  tstAngle;

  this.MapDrawAxis();
  this._SetAnglesAxis();

   if (isNaN(this.defSettings.radar.startAngle))
    stAngle = 90;
  else
    stAngle = 180 - this.defSettings.radar.startAngle;

  for (var i = 0; i < dSeries.length; i++) {
    angle = this.angRange[i];
    scale = this.scaleY[dSeries[i]];
    scaleKey = dSeries[i];
    vRange = this._GetValueAxisMinMax(scaleKey);
    this._SetValueScaleParameters(scaleKey, scale, vRange.min, vRange.max);

    gAxis = this.renderer.append("g")
              .attr("class", "valueAxisGroup_" + i)
              .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

    gAxis.append("line")
      .attr("id", this.chartId + "valueAx_" + i)
      .attr("class", "valueAxis TRANSP")
      .attr("x1", this.chartWidth / 2)
      .attr("y1", this.chartHeight / 2)
      .attr("x2", this.chartWidth / 2 - (this.chartHeight / 2 * factor))
      .attr("y2", this.chartHeight / 2)
      .attr("style", function () {
        var stObj = {
                  stroke : "#000000",
                  shape9rendering : (angle == 0 || angle == 90 || angle == 180 || angle == 270 || angle == 360) ? "crispEdges" : ""
                };
        return makeStyleHTMLString(stObj, d3.select(this).attr("style"));
      })
      .attr("transform", function () {
        return "rotate(" + (angle + stAngle) + "," + _this.chartWidth / 2 + "," + _this.chartHeight / 2 + ")";  //il fatto di aver messo +90 incide sullo startangle
      });

    if (isNaN(this.defSettings.valueAxis.tick) || Empty(this.defSettings.valueAxis.tick) || this.defSettings.valueAxis.tick < 0) {
      this._SelectAutoTickUnit(scale, vRange.min, vRange.max, appFont, false);
      ticksV = setTicks(vRange.min, vRange.max, this.tickUnit);
    }
    else
      ticksV = setTicks(vRange.min, vRange.max, parseInt(this.defSettings.valueAxis.tick));

    this._RemapScale(scale, this.scaleYref, this.tickUnit);

    tstAngle = stAngle - 90;
    gTick = _this.svg.select(".valueAxisGroup_" + i).selectAll(".tick")
      .data(ticksV)
      .enter()
        .append("g")
        .attr("class", "tick");
    gTick.append("line")
      .attr("class", "tLine")
      .attr("x1", _this.chartWidth / 2 - 3)
      .attr("x2", _this.chartWidth / 2 + 3)
      .attr("y1", function (tick) {
        return _this.chartHeight / 2 - scale(tick);
      })
      .attr("y2", function (tick) {
        return _this.chartHeight / 2 - scale(tick);
      })
      .attr("transform", "rotate(" + (angle + tstAngle) + "," + _this.chartWidth / 2 + "," + _this.chartHeight / 2 + ")");

    if (i == 0 || this.multipleScales) {
      this.svg.select(".valueAxisGroup_" + i).selectAll(".tick")
        .append("text")
          .attr("class", "valueAxTickLabel")
          .attr("x", function (tick) {
            var px = _this.chartWidth / 2 + 10,
            cx = _this.chartWidth / 2,
            py = _this.chartHeight / 2 - scale(tick),
            cy = _this.chartHeight / 2;
            return cx + ((px - cx) * Math.cos((angle + tstAngle) * Math.PI / 180)) - ((py - cy) * Math.sin((angle + tstAngle) * Math.PI / 180));
          })
          .attr("y", function (tick) {
            var px = _this.chartWidth / 2 + 10,
            cx = _this.chartWidth / 2,
            py = _this.chartHeight / 2 - scale(tick),
            cy = _this.chartHeight / 2;
            return cy + ((px - cx) * Math.sin((angle + tstAngle) * Math.PI / 180)) + ((py - cy) * Math.cos((angle + tstAngle) * Math.PI / 180));
          })
          .text(function (tick, idx) {
            if (idx == 0 && i > 0)
              return "";
            return tick;
          })
          .style("text-anchor", function () {
            var a = angle + tstAngle;
            if (a == 90 || a == 270)
              return "middle";
            if (a > 90 && a < 270)
              return "end";
            return "start";
          });
    }
  }
}

ZtRadarChart.prototype._DrawGridLines = function () {
  this._DrawValueAxisGrid();
}

ZtRadarChart.prototype._DrawValueAxisGrid = function () {
  var ticksArray = this.svg.select(".valueAxisGroup_0").selectAll(".tick")._groups[0];
  var pos = [],
  tmp,
  grid,
  _this = this;

  if (Empty(this.svg.select("#" + this.chartId + "valueAxisGridline").node()))
    grid = this.renderer.append("g")
      .attr("id", this.chartId + "valueAxisGridline")
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  if (this.defSettings.valueAxis.valueGrid.line) {
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      tmp = parseFloat(tick.firstChild.attributes.y1.value);
      pos.push(tmp);
    }

    grid.selectAll(".grid")
      .data(pos)
      .enter()
        .append("circle")
        .attr("class", "valueGridline TRANSP")
        .attr("id", function (d, i) {
          return _this.chartId + "valueGLine_" + i;
        })
        .attr("cx", this.chartWidth / 2)
        .attr("cy", this.chartHeight / 2)
        .attr("r", function (d) {
          return _this.chartHeight / 2 - d;
        });
  }
}

ZtRadarChart.prototype._DrawDomainAxisGrid = function () { }

ZtRadarChart.prototype._DrawAxisLabel = function () {
  var factor = this.factor,
  length = (this.chartWidth / 2 - (this.chartWidth / 2 - (this.chartHeight / 2 * factor))),
  appFont = appliedFont(this.defSettings, this.defSettings.axisLabel, this.defSettings.axisLabel.axisFont),
  stAngle,
  textHeight,
  _this = this,
  dSeries = this._GetOppositeDrawingList(),
  index;

  if (isNaN(this.defSettings.radar.startAngle))
    stAngle = 0;
  else
    stAngle = 90 - this.defSettings.radar.startAngle;

  for (var i = 0; i < dSeries.length; i++) {
    index = this.valueFields.indexOf(dSeries[i]);
    textHeight = getOffsetHeight(this.seriesList[index], appFont, this.chartId);
    this.svg.select(".valueAxisGroup_" + i)
      .append("text")
        .attr("class", "valueAxisLabel")
        .text(this.seriesList[index])
        .attr("x", function () {
          var cx = _this.chartWidth / 2,
          cy = _this.chartHeight / 2,
          px = _this.chartWidth / 2,
          py = (_this.chartHeight / 2) - length - textHeight;
          return cx + ((px - cx) * Math.cos((_this.angRange[i] + stAngle) * Math.PI / 180)) - ((py - cy) * Math.sin((_this.angRange[i] + stAngle) * Math.PI / 180));
        })
        .attr("y", function () {
          var cx = _this.chartWidth / 2,
          cy = _this.chartHeight / 2,
          px = _this.chartWidth / 2,
          py = (_this.chartHeight / 2) - length - textHeight;
          return cy + ((px - cx) * Math.sin((_this.angRange[i] + stAngle) * Math.PI / 180)) + ((py - cy) * Math.cos((_this.angRange[i] + stAngle) * Math.PI / 180));
        })
        .attr("style", function () {
          if (_this.angRange[i] == 0 || _this.angRange[i] == 180 || _this.angRange[i] == 360)
            return "text-anchor:middle;";
          else if (_this.angRange[i] > 0 && _this.angRange[i] < 180)
            return "text-anchor:start;";
          else
            return "text-anchor:end;";
        });
  }
}

ZtRadarChart.prototype._GetValueAxisMinMax = function (scaleKey, minValue, maxValue) {
  var min,
  max,
  list = this.allValues;
  if (this.multipleScales && this.objConfig.mapSeries && this.objConfig.mapSeries[scaleKey] && this.objConfig.mapSeries[scaleKey].ownerScale)
    list = this[scaleKey + "_values"];
  if (Empty(minValue) && parseInt(minValue) != 0) {
    min = d3.min(list);
    if (min >= 0)
      min = 0;
  }
  else
    min = parseFloat(minValue);

  if (Empty(maxValue) && parseInt(maxValue) != 0)
    max = d3.max(list);
  else
    max = parseFloat(maxValue);
  return { min: min, max: max };
}

ZtRadarChart.prototype._SetValueScaleParameters = function (scaleRefKey, scaleY, min, max) {
  var factor = this.factor;
  // percentuale di grandezza del grafico rispetto all'area plot in cui e' contenuto
  scaleY.domain([min, max])
    .range([0, this.chartHeight / 2 * factor]);
}

ZtRadarChart.prototype._DrawChartElements = function () {
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  dSeries = this._GetOppositeDrawingList(),
  stAngle;

  this._SetCalculationDataset(this.dataSet);
  this.DrawRadar(group, this.dataSet, this.calcDataset, !Empty(this.objConfig.keyField) ? this.xLabelIndex : this.xIndex);

  if (isNaN(this.defSettings.radar.startAngle))
    stAngle = 0;
  else
    stAngle = 90 - this.defSettings.radar.startAngle;
  group.attr("transform", group.attr("transform") + " rotate(" + stAngle + "," + this.chartWidth / 2 + "," + this.chartHeight / 2 + ")");

  for (var i = 0; i < dSeries.length; i++) {
    var yIndex = this.propertyName.indexOf(dSeries[i]);
    this.DrawShapes(group, this.dataSet, i, this.xIndex, yIndex, {valueField : dSeries[i]});
  }
}

ZtRadarChart.prototype._GetShapeCX = function (d, dataIndex, xIndex, yIndex, recIndex) {
  return this.calcDataset[recIndex][dataIndex].x;
}

ZtRadarChart.prototype._GetShapeCY = function (d, dataIndex, xIndex, yIndex, recIndex) {
  return this.calcDataset[recIndex][dataIndex].y;
}

ZtRadarChart.prototype._SetAxisColor = function () {
  var dSeries = this._GetOppositeDrawingList(),
  defaultStrokeColor = "#C0C0C0",
  defaultStrokeWidth = 1,
  styleObj = {},
  ticks,
  axisID,
  scaleRef;

  for (var i = 0; i < dSeries.length; i++) {
    axisID = this.chartId + "valueAx_" + i;
    scaleRef = dSeries[i];
    if (!this.defSettings.valueAxis.show) {
      axisID = "valueAxisGroup_" + i;
      this.svg.select("." + axisID).selectAll("*").style("visibility", "hidden");
      continue;
    }

    styleObj.fill = "transparent";
    styleObj.stroke = defaultStrokeColor;
    styleObj.stroke9width = defaultStrokeWidth + "px";

    if (!Empty(this.defSettings.valueAxis.valueLine.color))
      styleObj.stroke = this.defSettings.valueAxis.valueLine.color;
    if (!Empty(this.defSettings.valueAxis.valueLine.stroke) && !isNaN(this.defSettings.valueAxis.valueLine.stroke) && this.defSettings.valueAxis.valueLine.stroke > 0)
      styleObj.stroke9width = this.defSettings.valueAxis.valueLine.stroke + "px";

    // asse
    if (this.multipleScales) {
      if (this.objConfig.mapSeries && (scaleRef in this.objConfig.mapSeries)) {
        if (this.objConfig.mapSeries[scaleRef].ownerScale)
          styleObj.stroke = this.colorSet[i].color;
      }
    }

    if (!this.defSettings.valueAxis.showAxis)
      styleObj.stroke = "transparent";
    ticks = this.svg.select(".valueAxisGroup_" + i).selectAll(".tick")._groups[0];
    for (var j = 0; j < ticks.length; j++) {
      var line = d3.select(ticks[j]).select("line");
      line.attr("style", makeStyleHTMLString(styleObj, line.attr("style")));
    }
    d3.select("#" + axisID).attr("style", makeStyleHTMLString(styleObj, d3.select("#" + axisID).attr("style")));
  }
}

ZtRadarChart.prototype._SetAxisGridColor = function () {
  this.SetAxisGridColor("value", true);
}

ZtRadarChart.prototype._SetAxisFont = function () {
  if (!this.defSettings.valueAxis.show)
    return;
  var axisGrp,
  scaleRef;
  for (var i = 0; i < this.valueFields.length; i++) {
    axisGrp = "valueAxisGroup_" + i;
    scaleRef = this.valueFields[i];
    this.SetAxisGroupFont("value", this.svg.select("." + axisGrp).selectAll(".tick"), scaleRef);
  }
}

ZtRadarChart.prototype._SetAxisLabelFont = function () {
  var axisGrp;
  for (var i = 0; i < this.valueFields.length; i++) {
    axisGrp = "valueAxisGroup_" + i;
    this.SetAxisLabelGroupFont(this.svg.select("." + axisGrp).select(".valueAxisLabel"));
  }
}

ZtRadarChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  sidx = -1,
  gradID,
  colD;
  for (var i = 0; i < this.items.length; i++) {
    idx = this.categoryList.indexOf(this.items[i].category);
    sidx = this.orgCategoryList.indexOf(this.items[i].category);
    if (!Empty(this.items[i].keyField))
      sidx = this.orgCategoryList.indexOf(this.items[i].keyField);
    if (sidx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = sidx;
      this.items[i].color = this.colorSet[sidx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      if (this.defSettings.shape.draw && this.defSettings.shape.onlyShapes)
        this.items[i].color = { color : "transparent", gradient : "" };
      var styleObj = {};
      gradID = this.chartId + this.type + "_" + sidx + "Gradient";
      if (!Empty(this.items[i].color.color) && Empty(this.items[i].color.gradient) || this.items[i].color.color.toLowerCase() == this.items[i].color.gradient.toLowerCase())
        colD = this.items[i].color.color;
      else if (Empty(this.items[i].color.color) && !Empty(this.items[i].color.gradient))
        colD = this.items[i].color.gradient;
      else {
        this.CreateGradient(this.items[i].color.color, this.items[i].color.gradient, gradID, "element");
        colD = "url(#" + gradID + ")";
      }
      styleObj.stroke = colD;
      styleObj.fill = "transparent";
      if (this.isArea) {
        styleObj.fill = colD;
        if (this.defSettings.fillTransparency)
          styleObj.fill9opacity = 0.25;
      }
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtRadarChart.prototype._SetShapesColor = function () {
  for (var i = 0; i < this.shapes.length; i++) {
    var idx = this.valueFields.indexOf(this.shapes[i].valueField);
    if (idx >= 0) {
      this.shapes[i].sidx = idx;
      this.shapes[i].idx = this.orgCategoryList.indexOf(this.shapes[i].category);
      if (!Empty(this.shapes[i].keyField))
       this.shapes[i].idx = this.orgCategoryList.indexOf(this.shapes[i].keyField);
      this.shapes[i].color = this.colorSet[this.shapes[i].idx];
      var styleObj = {};
      styleObj.fill = this.GetChartBackground().color;
      styleObj.stroke9width = (this.defSettings.shape.stroke || 1) + "px";
      if (!this.defSettings.shape.onlyHover) {
        styleObj.stroke = this.shapes[i].color.color;
        if (this.defSettings.shape.colorSeries[this.shapes[i].idx])
          styleObj.stroke = this.defSettings.shape.colorSeries[this.shapes[i].idx].color;
        if (this.defSettings.shape.customFill && !Empty(this.defSettings.shape.fillColorSeries)) {
          if (this.defSettings.shape.fillColorSeries[idx])
            styleObj.fill = this.defSettings.shape.fillColorSeries[idx].color;
          else {
            if (this.defSettings.shape.fill)
              styleObj.fill = this.shapes[i].color.color;
            else
              styleObj.fill = "url(#" + this.chartId + "rendererGradient)";
          }
        }
        else {
          if (this.defSettings.shape.fill)
            styleObj.fill = this.shapes[i].color.color;
          else
            styleObj.fill = "url(#" + this.chartId + "rendererGradient)";
        }
      }
      else {
        styleObj.stroke = "transparent";
        styleObj.fill = "transparent";
      }
      this.shapes[i].colorApplied = this.shapes[i].color.color;
      d3.select(this.shapes[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.shapes[i].itm).attr("style")));
    }
  }
}

ZtRadarChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  return ZtPieChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
}

ZtRadarChart.prototype._GetAnimatedDivisor = function() {
  var div = this.categoryList.length;
  if( div == 0) div = 1;
  return div;
}

ZtRadarChart.prototype._AnimateChartElements = function () {
  ZtLinesChart.prototype._AnimateChartElements.call(this);
}

ZtRadarChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  defaultValues = Empty(lastValueObj),
  elem = item.itm,
  totLen,
  value,
  value2;

  if (elem.tagName.toLowerCase() == "circle") {
    if (defaultValues) {
      d3.select(elem)
        .attr("r", 0)
        .transition()
          .delay((item.idx + 1) * duration / div/*this.shapes.length*/)
          .duration(duration / div/*this.shapes.length*/)
          .attr("r", item.r);
    }
    else {
      value = d3.select(elem).attr("r");
      d3.select(elem)
        .attr("cx", lastValueObj.x)
        .attr("cy", lastValueObj.y)
        .attr("r", lastValueObj.r)
        .transition()
          .delay((item.idx + 1) * duration / div/*this.shapes.length*/)
          .duration(duration / div/*this.shapes.length*/)
          .attr("cx", item.coordinates.x)
          .attr("cy", item.coordinates.y)
          .attr("r", value)
    }
  }
  else {
    totLen = elem.getTotalLength(),
    value = d3.select(elem).attr("d");
    value2 = d3.select(elem).style("fill-opacity");
    if (defaultValues) {
      d3.select(elem)
        .attr("stroke-dasharray", totLen + " " + totLen)
        .attr("stroke-dashoffset", totLen)
        .style("fill-opacity", 0)
        .transition()
          .delay(item.idx * duration/div)
          .duration(duration/div)
          .ease(d3.easeLinear)
          .attr("stroke-dashoffset", 0)
          .style("fill-opacity", value2);
    }
    else {
      d3.select(elem)
        .attr("stroke-dasharray", "")
        .attr("stroke-dashoffset", "")
        .attr("d", lastValueObj.d)
        .style("fill-opacity", 0)
        .transition()
          .delay(item.idx * duration/div)
          .duration(duration/div)
          .ease(d3.easeLinear)
          .attr("d", value)
          .style("fill-opacity", value2);
    }
  }
}

ZtRadarChart.prototype._GetItems = function() {
  return ZtLinesChart.prototype._GetItems.call(this);
}

ZtRadarChart.prototype._ApplyMouseOver = function (item, itemObj) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  this.RemoveAllHovers();
  if (item) {
    var itemObject = itemObj || this._GetItems()[d3.select(item).attr("item-index")],
    clone = this._GetItemClone(item);
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
          _this.ShowTooltip(mRefChart, item, itemObject);
        }
      }
    }, 50, mRefChart, item, itemObject, clone);
  }
}

ZtRadarChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  ZtLinesChart.prototype._ApplyItemSVGSelectEffect.call(this, items, selected);
}

ZtRadarChart.prototype._ApplySelectEffectShape = function (item, selected) {
  ZtLinesChart.prototype._ApplySelectEffectShape.call(this, item, selected);
}

ZtRadarChart.prototype._ApplyNoSelections = function () {
  ZtLinesChart.prototype._ApplyNoSelections.call(this);
}

ZtRadarChart.prototype._GetDefaultDataOrder = function () {
  return ZtPieChart.prototype._GetDefaultDataOrder.call(this);
}

ZtRadarChart.prototype._SetInReferredList = function (label) {
  ZtPieChart.prototype._SetInReferredList.call(this, label);
}

ZtRadarChart.prototype._IsNotExcludedDomainShapes = function (text) {
  return this._GetAxisDrawingList().indexOf(text) >= 0;
}

ZtRadarChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  dataIndex,
  cList = getList(this.xIndex, this.dataSet),
  item;

  if (Empty(this.calcDataset)) {
    this._SetAnglesAxis();
    this._SetCalculationDataset(this.dataSet);
  }

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm) {
      item = this.items[i];
      dataIndex = cList.indexOf(item.category);
      if (dataIndex >= 0) {
        record = this.calcDataset[dataIndex];
        lastValues = { d: d3.select(item.itm).attr("d") }
        d3.select(item.itm)
          .attr("d", function () {
            var points = "";
            for (var pti = 0; pti < record.length; pti++)
              points = points + record[pti].x + "," + record[pti].y + " ";
            return "M" + points + "Z";
          });

        this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
      }
    }
  }

  for (i = 0; i < this.shapes.length; i++) {
    if (this.shapes[i].itm) {
      item = this.shapes[i];
      var yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);

      lastValues = { x : item.coordinates.x,
                     y : item.coordinates.y,
                     r : item.r
                   };

      item.coordinates.x = this._GetShapeCX(this.dataSet[item.sidx], item.idx, this.xIndex, yIndex, null, {scaleY: this.scaleY[item.valueField], valueField : item.valueField});
      item.coordinates.y = this._GetShapeCY(this.dataSet[item.sidx], item.idx, this.xIndex, yIndex, null, {scaleY: this.scaleY[item.valueField], valueField : item.valueField});
      item.value = this.dataSet[item.sidx][yIndex];
      item.r = item.value == null ? 0 : this.GetShapesRadius();

      d3.select(item.itm)
        .attr("cx", item.coordinates.x)
        .attr("cy", item.coordinates.y)
        .attr("r", item.r);

      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }

  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtRadarChart.prototype._ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (!this.defSettings.range.applyColor) {
    this.SetRangeInItems();
  }
  else
    this._SetElementsRangeColor(isFnc);
}

ZtRadarChart.prototype._SetElementsRangeColor = function (isFnc) {
  ZtLinesChart.prototype._SetElementsRangeColor.call(this, isFnc);
}

ZtRadarChart.prototype._HasShapes = function () {
  return ZtLinesChart.prototype._HasShapes.call(this);
}

ZtRadarChart.prototype._GetGridColumnName = function (field) {
  return ZtPieChart.prototype._GetGridColumnName.call(this, field);
}