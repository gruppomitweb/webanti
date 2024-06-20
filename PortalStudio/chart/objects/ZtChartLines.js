function ZtLinesChart() {
  StdChart.apply(this, ["LINES", "e696"]);
  this.holesIndexList = {};
}
ZtLinesChart.prototype = Object.create(StdChart.prototype);
ZtLinesChart.prototype.constructor = ZtLinesChart;

ZtLinesChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.axisLabel = this.chartConfig.graphSettings.axisLabel;
  this.defSettings.domainAxis = this.chartConfig.graphSettings.domainAxis;
  this.defSettings.line = this.chartConfig.graphSettings.line;
  this.defSettings.shape = this.chartConfig.graphSettings.shape;
  this.defSettings.shape.onlyHover = false;
  this.defSettings.shape.figureTypes = ["circle", "square", "triangle", "cross", "diamond", "star", "wye"];
  this.defSettings.valueAxis = this.chartConfig.graphSettings.valueAxis;
  this.defSettings.domainAxis.precision = parseFloat(this.defSettings.domainAxis.precision);
  this.defSettings.valueAxis.precision = parseFloat(this.defSettings.valueAxis.precision);

  if (!this.defSettings.shape.draw) {
    this.defSettings.shape.onlyHover = true;
    this.defSettings.shape.size = 2;
    this.defSettings.shape.type = "percent";
  }

  if (this.defSettings.line.type.indexOf("curve") < 0) {  // compatibilita' versioni d3
    switch (this.defSettings.line.type) {
      case "linear":
        this.defSettings.line.type = "curveLinear";
        break;
      case "step-before":
        this.defSettings.line.type = "curveStepBefore";
        break;
      case "step-after":
        this.defSettings.line.type = "curveStepAfter";
        break;
      case "basis":
        this.defSettings.line.type = "curveBasis";
        break;
      case "bundle":
        this.defSettings.line.type = "curveBasis";
        break;
      case "cardinal":
        this.defSettings.line.type = "curveCardinal";
        break;
      case "monotone":
        this.defSettings.line.type = "curveMonotoneX";
        break;
    }
  }
}

ZtLinesChart.prototype._DrawChartPlot = function () {
  this.CreateSVG(this.chartId, this.parent, true, 0, 0, this.defSettings.globals.width, this.defSettings.globals.height, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top); // eslint-disable-line max-len
  this.CreateRenderer(this.svg, this.chartId, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this._DrawChartPlotTitles(this.svg);
  this._DrawChartPlotElements();
}

ZtLinesChart.prototype._DrawChartPlotElements = function () {
  this._DrawAxis();
  this._DrawAxisLabel();
  this._DrawRangeBands();
  this._DrawGridLines();
}

ZtLinesChart.prototype._GetValueAxisPosition = function () {
  return "left";
}

ZtLinesChart.prototype._GetDomainAxisPosition = function () {
  return "bottom";
}

ZtLinesChart.prototype._GetValueAxisMinMax = function (scaleKey, minValue, maxValue) {
  return ZtBarChart.prototype._GetValueAxisMinMax.call(this, scaleKey, minValue, maxValue);
}

ZtLinesChart.prototype._SetValueScaleParameters = function (scaleKey, scaleY, min, max) {
  ZtBarChart.prototype._SetVerticalValueScaleParameters.call(this, scaleKey, scaleY, min, max);

  var sRadius = 2 * this.GetShapesRadius(),
  ownScale = (scaleY.__refAxis == scaleKey),
  mmin,
  mmax,
  scale;
  if (ownScale && this.objConfig.mapSeries && this.objConfig.mapSeries[scaleKey] && this.objConfig.mapSeries[scaleKey].ownerScale) {
    mmin = Math.floor(scaleY.invert(scaleY(min) + sRadius));
    mmax = Math.round(scaleY.invert(scaleY(max) - sRadius));
    if (mmin >= 0)
      mmin = mmin - mmin % 10;
    else
      mmin = Math.round(Math.abs(mmin) / 10) * (-10);

    if (mmin > min)
      mmin = min;
    if (mmax < max)
      mmax = max;

    scaleY.__checked = true;
  }
  else {
    scale = this.scaleY[scaleY.__refAxis];
    if (ownScale)
      scale = scaleY;

    if (!scale.__checked) {
      var bval = this._GetBoundariesValues();
      if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue)) {
        mmin = bval.min;
      }
      else {
        mmin = Math.floor(scale.invert(scale(bval.min) + sRadius));
        if (mmin >= 0)
          mmin = mmin - mmin % 10;
        else
          mmin = Math.round(Math.abs(mmin) / 10) * (-10);

        if (mmin > min)
          mmin = min;
      }
      if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue)) {
        mmax = bval.max;
      }
      else {
        mmax = Math.round(scale.invert(scale(bval.max) - sRadius));
        if (mmax < max)
          mmax = max;
      }

      scale.__checked = true;
    }
    else {
      mmin = scale.domain()[1];
      mmax = scale.domain()[0];
    }
  }

  // usata solo nei contatori - imposta il minimo sull'asse y a prescindere da qualunque calcolo
  if (this.defSettings.valueAxis.applyMinValue && 
    (!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue)
  )
    mmin = this.defSettings.valueAxis.minValue;

  scaleY.domain([mmax, mmin]);

  return { min: mmin, max: mmax };
}

ZtLinesChart.prototype._SetDomainScaleParameters = function () {
  if (this.domainIsTime)
    this.scaleX.range([0, this.chartWidth]);
  else if (this.domainIsNumber)
    this.scaleX.range([0, this.chartWidth]);
  else
    this.scaleX.range([0, this.chartWidth]).padding(0.1);
}

ZtLinesChart.prototype._GetDomainAxisXPosition = function () {
  return this.margin.left;
}

ZtLinesChart.prototype._GetDomainAxisYPosition = function () {
  return this.margin.top + this.chartHeight + 3;
}

ZtLinesChart.prototype._GetValueAxisXPosition = function () {
  return this.margin.left - 3;
}

ZtLinesChart.prototype._GetValueAxisYPosition = function () {
  return this.margin.top;
}

ZtLinesChart.prototype._DrawChartElements = function () {
  d3.select("#" + this.chartId + this.type + "_elementGroup").remove();
  d3.select("#" + this.chartId + this.type + "_shapesGroup").remove();
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  groupS = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_shapesGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var yIndex = -1,
  xIndex = /*this.keyField.domain ? this.xLabelIndex :*/ this.xIndex,
  dSeries = this._GetDrawingList(),
  cData;
  
  for (var i = 0; i < dSeries.length; i++) {
    yIndex = this.propertyName.indexOf(dSeries[i]);
    if (!this.holesIndexList[dSeries[i]])
      this.holesIndexList[dSeries[i]] = [];
    if (!this.domainIsTime || (this.domainIsTime && this.defSettings.time.dataType == "default"))
      cData = this.dataSet;
    else
      cData = this._EvaluateTimeDataset(this.dataSet, xIndex, yIndex, this.holesIndexList[dSeries[i]]);

    this.DrawLine(group, cData, i, xIndex, yIndex, {scaleY: this.scaleY[dSeries[i]]});
    this.DrawShapes(groupS, cData, i, xIndex, yIndex, {scaleY: this.scaleY[dSeries[i]], valueField : dSeries[i]});
  }
}

ZtLinesChart.prototype._EvaluateTimeDataset = function (dataSet, xIndex, yIndex, holesList) {
  var i,
  isDef,
  altData = [];
  for (i = 0; i < dataSet.length; i++) {
    isDef = this._EvaluateTimeContinuity(dataSet, i, xIndex, yIndex);
    if (!isDef) {
      altData.push(dataSet[i - 1].slice());
      altData[altData.length - 1][xIndex] = dataSet[i][xIndex];
      if (holesList.indexOf(altData.length - 1) < 0)
        holesList.push(altData.length - 1);
      if (this.defSettings.time.dataType == "holes")
        altData[altData.length - 1][yIndex] = null;
    }
    altData.push(dataSet[i].slice());
  }
  return altData;
}

ZtLinesChart.prototype._CreateRendererGradient = function (color, gradient, gDef) {
  ZtBarChart.prototype._CreateRendererGradient.call(this, color, gradient, gDef);
}

ZtLinesChart.prototype._CreateElementGradient = function (color, gradient, gDef) {
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

ZtLinesChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  stroke,
  gradID,
  mapser;
  for (var i = 0; i < this.items.length; i++) {
    idx = this.valueFields.indexOf(this.items[i].valueField);
    mapser = false;
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.orgCategoryList.indexOf(this.items[i].category);
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      // gestione multi serie solo shapes
      if (this.objConfig.mapSeries) {
        if (this.items[i].valueField in this.objConfig.mapSeries) {
          if (this.objConfig.mapSeries[this.items[i].valueField].type == "SLINES") {
            this.items[i].color = { color : "transparent", gradient : "" };
            mapser = true;
          }
          else
            mapser = false;
        }
        else
          mapser = false;
      }
      if (!mapser) {
        if (this.defSettings.shape.draw && this.defSettings.shape.onlyShapes)
          this.items[i].color = { color : "transparent", gradient : "" };
      }
      var styleObj = {};
      styleObj.fill = "transparent";
      stroke = 1;
      if (!Empty(this.defSettings.line.stroke) && !isNaN(this.defSettings.line.stroke) && this.defSettings.line.stroke > 0)
        stroke = this.defSettings.line.stroke;
      styleObj.stroke9width = stroke + "px";
      gradID = this.chartId + this.type + "_" + idx + "Gradient";
      if (!Empty(this.items[i].color.color) && Empty(this.items[i].color.gradient) || this.items[i].color.color.toLowerCase() == this.items[i].color.gradient.toLowerCase())
        stroke = this.items[i].color.color;
      else if (Empty(this.items[i].color.color) && !Empty(this.items[i].color.gradient))
        stroke = this.items[i].color.gradient;
      else {
        this.CreateGradient(this.items[i].color.color, this.items[i].color.gradient, gradID, "element");
        stroke = "url(#" + gradID + ")";
      }
      styleObj.stroke = stroke;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtLinesChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  return ZtBarChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
}

ZtLinesChart.prototype.ResetItems = function () {
  this.items = [];
  this.shapes = [];
}

ZtLinesChart.prototype._AnimateChartElements = function () {
  var i, elem;
  for (i = 0; i < this.items.length; i++) {
    elem = this.items[i].itm;
    if (!elem)
      continue;
    this._AnimateItem(this.items[i], null, this.defSettings.animation.duration);
  }

  for (i = 0; i < this.shapes.length; i++) {
    elem = this.shapes[i].itm;
    if (!elem)
      continue;
    this._AnimateItem(this.shapes[i], null, this.defSettings.animation.duration);
  }
}

ZtLinesChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  defaultValues = Empty(lastValueObj),
  elem = item.itm,
  totLen,
  value,
  _this = this;

  if (item.itemType == "shape") {
    var figure = item.shapeType.charAt(0).toUpperCase() + item.shapeType.slice(1);
    if (defaultValues) {
      d3.select(elem)
        .attr("d", d3.symbol()
          .size( function () { return 0.5; })
          .type( d3["symbol" + figure] )
        )
        .transition()
          .delay((item.idx + 1) * duration / div)
          .duration(duration / div)
          .attr("d", d3.symbol()
            .size( function () { return 2 * Math.pow(_this.GetShapesRadius(), 2); })
            .type( d3["symbol" + figure] )
          );
    }
    else {
      d3.select(elem)
        .attr("transform", "translate(" + [lastValueObj.x, lastValueObj.y] + ")")
        .transition()
          .delay((item.idx + 1) * duration / div)
          .duration(duration / div)
          .attr("transform", "translate(" + [item.coordinates.x, item.coordinates.y] + ")");
    }
  }
  else {
    totLen = elem.getTotalLength(),
    value = d3.select(elem).attr("d");
    if (defaultValues) {
      d3.select(elem)
        .attr("stroke-dasharray", totLen + " " + totLen)
        .attr("stroke-dashoffset", totLen)
        .transition()
          .delay(item.idx * duration/div)
          .duration(duration/div)
          .ease(d3.easeLinear)
          .attr("stroke-dashoffset", 0);
    }
    else {
      d3.select(elem)
        .attr("stroke-dasharray", "")
        .attr("stroke-dashoffset", "")
        .attr("d", lastValueObj.d)
        .transition()
          .delay(item.idx * duration/div)
          .duration(duration/div)
          .ease(d3.easeLinear)
          .attr("d",value);
    }
  }
}

ZtLinesChart.prototype._GetShapeCX = function (d, dataIndex, xIndex/*, yIndex, recIndex, cobj*/) {
  return this._GetDomainInScale(d, xIndex);
}

ZtLinesChart.prototype._GetShapeCY = function (d, dataIndex, xIndex, yIndex, recIndex, cobj) {
  return cobj.scaleY(d[yIndex]);
}

ZtLinesChart.prototype._GetItems = function() {
  return this.shapes;
}
 
ZtLinesChart.prototype._ApplyMouseOver = function (item, itemObj) {
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
      .attr("d", d3.symbol()
        .size( function () { return 5 * Math.pow(_this.GetShapesRadius(), 2); })
        .type( function (/*d*/) {
          if (_this.defSettings.shape.differSeries) {
            var index = itemObject.idx,
            fig = _this.defSettings.shape.figureTypes[index];
            if (Empty(fig) || index > _this.defSettings.shape.figureTypes.length)
              fig = _this.defSettings.shape.figureTypes[index % _this.defSettings.shape.figureTypes.length];
            return d3["symbol" + fig.charAt(0).toUpperCase() + fig.slice(1)];
          }
          return d3["symbol" + _this.defSettings.shape.figure.charAt(0).toUpperCase() + _this.defSettings.shape.figure.slice(1)];
        })
      )
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

          var sID = replaceSpecialCharsForID(_this.scaleY[itemObject.valueField].__refAxis),
          axisRef = _this.svg.select("#" + _this._ZtChart.StdChart.chartId + "valueAxisGroup_" + sID).node();
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

ZtLinesChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  _this = this;
  for (var i = 0; i < this.shapes.length; i++) {
    var item = this.shapes[i],
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, "value"),
    pos = this.defSettings.valueLabel.position,
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    offset = 5,
    label = group.append("text")
              .attr("x", function () {
                switch (pos) {
                  case "otop":
                  case "obottom":
                  case "in":
                    return item.coordinates.x;
                    break;
                  case "oleft":
                    return item.coordinates.x - item.r - offset;
                    break;
                  case "oright":
                    return item.coordinates.x + item.r + offset;
                    break;
                }
              })
              .attr("y", function () {
                switch (pos) {
                  case "otop":
                    var ytop = item.coordinates.y - item.r - offset;
                    if (ytop < getOffsetHeight(text, font, _this.chartId) && _this.defSettings.valueLabel.show == "default")
                      ytop = item.coordinates.y + getOffsetHeight(text, font, _this.chartId) / 4;
                    return ytop;
                    break;
                  case "obottom":
                    return item.coordinates.y + item.r + getOffsetHeight(text, font, _this.chartId) / 2 + offset;
                    break;
                  case "in":
                  case "oleft":
                  case "oright":
                    return item.coordinates.y + getOffsetHeight(text, font, _this.chartId) / 4;
                    break;
                }
              })
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

ZtLinesChart.prototype._ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (!this.defSettings.range.applyColor) {
    this.SetRangeInItems();
    this._DrawRangeBandsVerticalAxis();
  }
  else
    this._SetElementsRangeColor(isFnc);
}

ZtLinesChart.prototype._SetElementsRangeColor = function (isFnc) {
  var styleObj,
  fill;
  for (var i = 0; i < this.shapes.length; i++) {
    if (this.shapes[i].idx >= 0) {
      if (isFnc) {
        if (this.functionObj && ("GetConditionalFormatting" in this.functionObj)) {
          var fncRet = this.functionObj.GetConditionalFormatting(this._GetItemObj(this.shapes[i]));
          fill = decodeConditionalFormatting(fncRet).fill;
        }
      }
      else {
        var band = this.GetObjectFromRange(this.shapes[i].value, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.shapes[i], band);
      }
      if (!this.defSettings.shape.draw)
        styleObj = { fill: fill, stroke: fill, fill9opacity: 1, stroke9opacity: 1 };
      else {
        if (this.defSettings.shape.fill)
          styleObj = { fill: fill, stroke: fill };
        else
          styleObj = { fill: 'transparent', stroke: fill };
      }
      this.shapes[i].colorApplied = fill;
      d3.select(this.shapes[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.shapes[i].itm).attr("style")));
    }
  }
}

ZtLinesChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  for (var i = 0; i < items.length; i++) {
    if (items[i].type == "legend") {
      this._ApplyLegendSelectEffect(items[i], selected);
      continue;
    }
    if (items[i].itemType == "shape")
      this._ApplySelectEffectShape(items[i], selected);
    else {
      StdChart.prototype._ApplyItemSVGSelectEffect.call(this, [items[i]], selected);
    }
  }
}

ZtLinesChart.prototype._ApplySelectEffectShape = function (item, selected) {
  if (!item.itm)
    return;

  var halfOpacity = this.defSettings.selectionOptions.opacity,
  fullOpacity = 1,
  fillColor = this.defSettings.selectionOptions.color,
  rangeTest = !Empty(this.defSettings.range.bands),
  strokeW = this.defSettings.shape.stroke || 1,
  globalDesel = this.GetSelectedItems().length == 0,
  stobj = {};

  if ((this.defSettings.shape.fill || this.defSettings.shape.onlyHover || rangeTest) && !Empty(item.colorApplied))
    stobj.fill = item.colorApplied;
  else
    stobj.fill = "url(#" + this.chartId + "rendererGradient)";
  if (selected) {
    stobj.fill9opacity = fullOpacity;
    stobj.stroke9opacity = fullOpacity;
    if (!globalDesel && !this.defSettings.shape.fill && !this.defSettings.shape.onlyHover)
      stobj.stroke9width = (2 * strokeW) + "px";
    else if (globalDesel)
      stobj.stroke9width = strokeW + "px";
  }
  else {
    if (this.defSettings.shape.onlyHover) {
      stobj.fill9opacity = 0;
      stobj.stroke9opacity = 0;
    }
    else {
      stobj.fill9opacity = halfOpacity;
      stobj.stroke9opacity = halfOpacity;
      if (!this.defSettings.shape.fill)
        stobj.stroke9width = strokeW + "px";
      if (!Empty(fillColor)) {
        if (!this.defSettings.shape.fill)
          stobj.stroke = fillColor;
        else
          stobj.fill = fillColor;
      }
    }
  }
  d3.select(item.itm).attr("style", makeStyleHTMLString(stobj, d3.select(item.itm).attr("style")));
}

ZtLinesChart.prototype._ApplyNoSelections = function () {
  var myItems = this.GetSelectedItems();
  if (myItems.length == 0) {
    myItems = this._GetItems();
    if (this.defSettings.shape.onlyHover)
      this._ApplyItemSVGSelectEffect(myItems, false);
    else
      this._ApplyItemSVGSelectEffect(myItems, true);
  }
  else {
    this._ApplyItemSVGSelectEffect(myItems, true);
    myItems = this.GetNotSelectedItems();
    this._ApplyItemSVGSelectEffect(myItems, false);
  }
}

ZtLinesChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this._SetItems(lastChart);
  this._MapScalesFromChart(lastChart);
  this._ApplyEvents();

  var lastValues,
  yIndex,
  item, i,
  _this = this;

  for (i = 0; i < this.items.length; i++) {
    if (this.items[i].itm) {
      item = this.items[i];
      yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);
      var line = d3.line()
              .x(function (d) {
                return _this._GetDomainInScale(d, _this.xIndex);
              })
              .y(function (d) {
                return _this.scaleY[item.valueField](d[yIndex]);
              })
              .defined(function (d) {
                return d[yIndex] != null;
              })
              .curve(d3[this.defSettings.line.type]);

      lastValues = { d: d3.select(item.itm).attr("d") }
      d3.select(item.itm).datum(this.dataSet).attr("d", line);
      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }

  for (i = 0; i < this.shapes.length; i++) {
    if (this.shapes[i].itm) {
      item = this.shapes[i];
      yIndex = this.propertyName.indexOf(this.valueFields[item.idx]);

      lastValues = { x : item.coordinates.x,
                     y : item.coordinates.y,
                     r : item.r
                   };

      item.coordinates.x = this._GetShapeCX(this.dataSet[item.sidx], item.idx, this.xIndex, yIndex, null, {scaleY: this.scaleY[item.valueField], valueField : item.valueField});
      item.coordinates.y = this._GetShapeCY(this.dataSet[item.sidx], item.idx, this.xIndex, yIndex, null, {scaleY: this.scaleY[item.valueField], valueField : item.valueField});
      item.value = this.dataSet[item.sidx][yIndex];
      item.r = item.value == null ? 0 : this.GetShapesRadius();

      d3.select(item.itm).attr("transform", "translate(" + [item.coordinates.x, item.coordinates.y] + ")");

      this._AnimateItem(item, lastValues, this.defSettings.animation.duration);
    }
  }

  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtLinesChart.prototype._SetItems = function (chart) {
  this.items = chart.items.slice();
  this.shapes = chart.shapes.slice();
}

ZtLinesChart.prototype._HasShapes = function () {
  return this.defSettings.shape.draw;
}

ZtLinesChart.prototype._GetDomainAxisMinMax = function () {
  if (!this.domainIsNumber)
    return;
  return { min: d3.min(this.orgCategoryList), max: d3.max(this.orgCategoryList) };
}
