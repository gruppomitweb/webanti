function ZtPieChart(type, is3D) {
  StdChart.apply(this, [type, (this.type == "RING" ? "e902" : "e695")]);
  this.multiSVG = true;
  this.is3D = is3D;
  this.radius = 0;
  this.multiMargins = {};
  this.pieData = [];
}
ZtPieChart.prototype = Object.create(StdChart.prototype);
ZtPieChart.prototype.constructor = ZtPieChart;

ZtPieChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.radius = this.chartConfig.graphSettings.radius;
  this.defSettings.orientation = {};
  this.defSettings.orientation.startAngle = parseFloat(this.chartConfig.graphSettings.radar.startAngle);
  this.defSettings.valueLabel.totalLabel.precision = parseFloat(this.chartConfig.graphSettings.valueLabel.totalLabel.precision);
  if (this.defSettings.valueLabel.totalLabel.precision < 0)
    this.defSettings.valueLabel.totalLabel.precision = 0;
  this.defSettings.slice = this.chartConfig.graphSettings.slice;
  this.multipleScales = false;
}

ZtPieChart.prototype._SetTitles = function () {
  if (!Empty(this.objConfig.title))
    this.defSettings.chartTitle.text = this.objConfig.title

    if (this.dataOrder == "column") {
      if (!Empty(this.objConfig.titleSeries))
        this.defSettings.chartLegend.text = this.objConfig.titleSeries;
    }
}

ZtPieChart.prototype._SetLists = function () {
  StdChart.prototype._SetLists.call(this);
  this.legendList = this.orgCategoryList.slice();
  if (!Empty(this.objConfig.keyField))
    this.legendList = this.categoryList.slice();
  this.rowLegendList = this.orgSeriesList.slice();
}

ZtPieChart.prototype._GetValuesPrecision = function () {
  return 0;
}

ZtPieChart.prototype._GetDomainPrecision = function () {
  return 0;
}

ZtPieChart.prototype._SetAxisColor = function () { }

ZtPieChart.prototype._SetAxisGridColor = function () { }

ZtPieChart.prototype._SetAxisFont = function () { }

ZtPieChart.prototype._SetAxisLabelFont = function () { }

ZtPieChart.prototype._DrawChartPlot = function () {
  this.CreateSVG(this.chartId, this.parent, true, 0, 0, this.defSettings.globals.width, this.defSettings.globals.height, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top); // eslint-disable-line max-len
  this.CreateRenderer(this.svg, this.chartId, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this._DrawChartPlotTitles(this.svg);
}

ZtPieChart.prototype._DrawChartElements = function () {
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
  dList = this._GetOppositeDrawingList(),
  slice = 7,
  maxLenVL = this._EvaluateRadiusWithValueLabels();

  if (!Empty(this.defSettings.slice.percent + "") && !isNaN(this.defSettings.slice.percent))
    slice = this.defSettings.slice.percent;

  this._DrawPatterns();

  this.totalValueLabel = {};
  if (this.seriesList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  for (var i = 0; i < positions.length; i++) {
    radius = Math.min(positions[i].width, positions[i].height) / 2;
    radius = radius - domainLabelH;
    radius = radius - radius * 0.05;  // tolgo il 5% per dare un po' di spazio al disegno
    radius = radius - ((radius * slice / 100) / 4);
    radius = radius - maxLenVL;
    this.radius = radius;
    innerRadius = this._GetInnerRadius();
    arc = d3.arc().innerRadius(innerRadius);
    
    yIndex = this.propertyName.indexOf(dList[i]);
    this._SetTotalValueLabelObject(this.dataSet, positions[i].width, positions[i].height, dList[i], yIndex, this.totalValueLabel);
    if (this.totalValueLabel[dList[i]] && !Empty(this.totalValueLabel[dList[i]].text)) {
      if (this.defSettings.valueLabel.position == "top" || this.defSettings.valueLabel.position == "bottom")
        this.radius = this.radius - (this.totalValueLabel[dList[i]].height + radiusOffset);
    }
    arc.outerRadius(this.radius);

    id = this.chartId + i + "_";
    this.multiMargins[dList[i]] = { x : this.margin.left + positions[i].x, 
                                    y : this.margin.top + positions[i].y,
                                    w : positions[i].width,
                                    h : positions[i].height
                                  };
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      .attr("transform","translate(" + [positions[i].width / 2, positions[i].height / 2] + ")");
    if (this.is3D)
      this.DrawPie3D(group, this.dataSet, i, this.xIndex, yIndex, id, arc, radius, innerRadius);
    else
      this.DrawPie(group, this.dataSet, i, this.xIndex, yIndex, id, arc);
    if (this.seriesList.length > 1) {
      if( (this.valueFields.indexOf(dList[i]) < 0 ) && (positions.length == this.seriesList.length) ) //MG VPV
        this.DrawDomainLabel(i, positions[i], this.seriesList[i]);
      else
        this.DrawDomainLabel(i, positions[i], this.seriesList[this.valueFields.indexOf(dList[i])]);
    }
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtPieChart.prototype._CreateRendererGradient = function (color, gradient, gDef) {
  ZtBarChart.prototype._CreateRendererGradient.call(this, color, gradient, gDef);
}

ZtPieChart.prototype._CreateElementGradient = function (color, gradient, gDef) {
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

ZtPieChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  path3D,
  colD;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.categoryList.indexOf(this.items[i].category);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.valueFields.indexOf(this.items[i].valueField);
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
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      if (this.is3D) {
        colD = get3DColor(this.items[i].color);
        styleObj.fill = colD.color;
        path3D = this.svg.selectAll(".pie3D_" + this.items[i].sidx + '_' + idx).filter(".pie_" + this.items[i].dataIndex)._groups;
        for (var j = 0; j < path3D[0].length; j++)
          d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
        path3D = this.svg.selectAll(".p3D_" + this.items[i].sidx + '_' + idx).filter(".pie_" + this.items[i].dataIndex)._groups;
        for (j = 0; j < path3D[0].length; j++)
          d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
      }
    }
  }
}

ZtPieChart.prototype._GetChartMarginsObject = function (/*chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];
  return ret;
}

ZtPieChart.prototype._GetInnerRadius = function (radius) {
  radius = radius || this._GetRadius();
  if (this.type == "RING") {
    if (Empty(this.defSettings.radius) || isNaN(this.defSettings.radius.inner))
      return radius * 0.25;
    else
      return radius * (this.defSettings.radius.inner / 100);
  }
  return 0;
}

ZtPieChart.prototype._GetRadius = function () {
  return this.radius;
}

ZtPieChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration, noOpacity) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj),
  defaultObj = { startAngle: 0, endAngle: 0 },
  _this = this;

  if (!noOpacity) {
    d3.select(elem)
      .style("fill-opacity", 0)
    .transition()
      .delay(item.dataIndex * duration / div)
      .duration(duration / div)
      .attrTween("d", arcTween)
      .style("fill-opacity", 1);
  }
  else {
    d3.select(elem)
    .transition()
      .delay(item.dataIndex * duration / div)
      .duration(duration / div)
      .attrTween("d", arcTween);
  }

  if (this.is3D) {
    d3.select("#" + this.chartId + item.dataIndex + "_3dGroup")
      .style("fill-opacity", 0)
    .transition()
      .delay((item.dataIndex * duration/div) + duration / 2)
      .duration(duration/div)
      .style("fill-opacity", 1);
  }

  function arcTween(a) {
    var i = d3.interpolate(defaultValues ? defaultObj : this._lastValueObj, a),
    arc = this._arc,
    pieTop = this._pieTop,
    radius = this._radius;
    this._current = i(0);
    return function(t) {
      if (_this.is3D)
        return pieTop(i(t), radius, radius * 0.5, _this._GetInnerRadius());
      return arc(i(t));
    };
  }
}

ZtPieChart.prototype._GetOtherAnimateFunction = function (item, lastValueObj) {
  this._GetDefaultAnimateFunction(item, lastValueObj, this.defSettings.animation.duration, true);
}

ZtPieChart.prototype._GetDivisor = function () {
  return this._GetOppositeDrawingList().length;
}

ZtPieChart.prototype._ApplyMouseOver = function (item, itemObj) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  this.RemoveAllHovers();
  this.AppendHoverItem(item);
  if (item) {
    // 3D
    var itemObject = itemObj || this.items[d3.select(item).attr("item-index")];
    if (this.is3D && itemObject.sidx >= 0) {
      var path3D = this.svg.selectAll(".pie3D_" + itemObject.sidx + "_" + itemObject.idx).filter(".pie_" + itemObject.dataIndex)._groups;
      for (var j = 0; j < path3D[0].length; j++) {
        var clone = path3D[0][j].cloneNode();
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

      path3D = this.svg.selectAll(".p3D_" + itemObject.sidx + "_" + itemObject.idx).filter(".pie_" + itemObject.dataIndex)._groups;
      for (j = 0; j < path3D[0].length; j++) {
        clone = path3D[0][j].cloneNode();
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
    }
  }
}

ZtPieChart.prototype._SetElementsRangeColor = function (isFnc) {
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
        var band = this.GetObjectFromRange(this.items[i].value, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.items[i], band);
        styleObj = { fill: fill };
      }
      this.items[i].colorApplied = fill;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      if (this.is3D) {
        fill = get3DColor({ color: this.items[i].colorApplied, gradient: "" });
        styleObj.fill = fill.color;
        var path3D = this.svg.selectAll(".pie3D_" + this.items[i].sidx + '_' + this.items[i].idx).filter(".pie_" + this.items[i].dataIndex)._groups;
        for (var j = 0; j < path3D[0].length; j++)
          d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
        path3D = this.svg.selectAll(".p3D_" + this.items[i].sidx + '_' + this.items[i].idx).filter(".pie_" + this.items[i].dataIndex)._groups;
        for (j = 0; j < path3D[0].length; j++)
          d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
      }
      this._DrawMarkerIconOnItem(this.items[i]);
    }
  }
}

ZtPieChart.prototype._DrawValueLabels = function () {
  var oldChartId = this.chartId,
  _this = this;
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
    var group = d3.select("#" + this.chartId + "d3Renderer").append("g")
                  .attr("id", this.chartId + "valueLabels"),
    items = this.items.filter(function (item) { return item.valueField == _this.valueFields[i]; }),
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    pos = this.defSettings.valueLabel.position;

    if (!this.is3D)
      group.attr("transform", d3.select("#" + this.chartId + this.type + "_elementGroup").attr("transform"));

    if (pos == "out")
      this._DrawVLabelOutside(group, items, font, this.valueFields[i]);
    else
      this._DrawVLabelInside(group, items, font, this.valueFields[i]);
  }
  this.chartId = oldChartId;
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot")
}

ZtPieChart.prototype._DrawTotalValueLabel = function () {
  var oldChartId = this.chartId;
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    var group = d3.select("#" + this.chartId + "valueLabels"),
    gelem = d3.select("#" + this.chartId + this.type + "_elementGroup"),
    label;
    appliedFont(this.defSettings, this.defSettings.valueLabel.totalLabel, this.defSettings.valueLabel.totalLabel.totalLabelFont);

    if (Empty(group.node())) {
      group = d3.select("#" + this.chartId + "d3Renderer").append("g")
                  .attr("id", this.chartId + "valueLabels")
                  .attr("transform", gelem.attr("transform"));
    }

    if (this.totalValueLabel[this.valueFields[i]]) {
      label = group.append("text")
        .attr("x", 0)
        .attr("y", this.totalValueLabel[this.valueFields[i]].height / 4)
        .style("text-anchor", "middle")
        .text(this.totalValueLabel[this.valueFields[i]].text || "");
      setFont(label, this.totalValueLabel.font, this);
    }
  }
  this.chartId = oldChartId;
}

ZtPieChart.prototype._DrawVLabelInside = function (group, items, font, valueField) {
  var offset = 5,
  progrGrad,
  text,
  angleRad,
  angleGrad,
  radiusRot,
  label,
  outsideLabels = {
    _090 : [],
    _90180 : [],
    _180270 : [],
    _270360 : [],
  },
  radius,
  maxH,
  _this = this,
  idx,
  sidx;

  for (var i = 0; i < items.length; i++) {
    var item = items[i];
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, "value");
    idx = i; //this._GetItemIndex(item);
    sidx = this._GetItemSeriesIndex(item);
    if (idx == 0)
      progrGrad = (180 * item.startAngle) / Math.PI;
    if (progrGrad >= 360)
      progrGrad = progrGrad - 360;
    angleRad = this.pieData[sidx][idx].endAngle - this.pieData[sidx][idx].startAngle;
    angleGrad = (180 * angleRad) / Math.PI;
    radiusRot = -90 + (angleGrad / 2) + progrGrad;
    if (progrGrad + (angleGrad / 2) >= 180)
      radiusRot = radiusRot - 180;
    if (this.is3D)
      radiusRot = 0;

    // valutazione
    radius = this._GetRadius(),
    maxH = 2 * radius * Math.sin(angleRad / 2);
    if (this.is3D) {
      var xm = 95 * item.centroid[0] / 50,
      ym = 95 * item.centroid[1] / 50;
      radius = Math.sqrt(Math.pow(xm, 2) + Math.pow(ym, 2));
    }

    var evalVL = evaluateFontVL(text, font, radius, maxH);
    if (evalVL.print) {
      label = group.append("text")
              .attr("x", function () {
                if (_this.is3D)
                  return 95 * item.centroid[0] / 50;
                var factor = 1;
                if (progrGrad + (angleGrad / 2) >= 180)
                  factor = -1;
                return factor * (item.radius/*_this._GetRadius()*/ - offset);
              })
              .attr("y", function () {
                if (_this.is3D)
                  return - item.centroid[1] + (95 * item.centroid[1] / 50);
                return 0;
              })
              .attr("transform", "rotate(" + radiusRot + ")")
              .style("text-anchor", function () {
                if (progrGrad + (angleGrad / 2) >= 180)
                  return "start";
                return "end";
              })
              .text(text);
      setFont(label, evalVL.font, this);
    }
    else {
      if (progrGrad >= 0 && progrGrad <= 90)
        outsideLabels._090.push(item);
      else if (progrGrad > 90 && progrGrad <= 180)
        outsideLabels._90180.push(item);
      else if (progrGrad > 180 && progrGrad <= 270)
        outsideLabels._180270.push(item);
      else
        outsideLabels._270360.push(item);
    }
    progrGrad = progrGrad + angleGrad;
  }
  
  var margins = this.multiMargins[valueField];
  if (!Empty(outsideLabels._090)) {
    outsideLabels._090.reverse();
    this._DrawPathValueLabels(group, outsideLabels._090, font, -1, margins);
  }

  if (!Empty(outsideLabels._90180))
    this._DrawPathValueLabels(group, outsideLabels._90180, font, 1, margins);

  if (!Empty(outsideLabels._180270)) {
    outsideLabels._180270.reverse();
    this._DrawPathValueLabels(group, outsideLabels._180270, font, 1, margins);
  }

  if (!Empty(outsideLabels._270360))
    this._DrawPathValueLabels(group, outsideLabels._270360, font, -1, margins);
  
  function evaluateFontVL(text, font, radius, maxH) {
    var isOK = true,
    mfont = JSON.stringify(font);
    mfont = JSON.parse(mfont);
    var txtW = getOffsetWidth(text, mfont, _this.chartId),
    txtH = getOffsetHeight(text, mfont, _this.chartId),
    fontRed = 0.25;

    if (txtW > radius){
      mfont.size = mfont.size - mfont.size * fontRed;
      if (txtW > radius)
        isOK = false;
    }
    if (txtH > maxH && isOK) {
      mfont.size = mfont.size - mfont.size * fontRed;
      txtH = getOffsetHeight(text, mfont, _this.chartId);
      if (txtH > maxH)
        isOK = false;
    }

    return { print : isOK, font : mfont };
  }
}

ZtPieChart.prototype._DrawVLabelOutside = function (group, items, font, valueField) {
  var margins = this.multiMargins[valueField],
  tmpItems = [],
  _this = this;

  tmpItems = reorderByAngles(items, 0, 90).reverse();
  this._DrawPathValueLabels(group, tmpItems, font, -1, margins);
  tmpItems = reorderByAngles(items, 90, 180);
  this._DrawPathValueLabels(group, tmpItems, font, 1, margins);
  tmpItems = reorderByAngles(items, 180, 270).reverse();
  this._DrawPathValueLabels(group, tmpItems, font, 1, margins);
  tmpItems = reorderByAngles(items, 270, 360);
  this._DrawPathValueLabels(group, tmpItems, font, -1, margins);

  function reorderByAngles(items, anglestart, angleend) {
    var mitems = [];
    var angleCount = 0, angleRad, angleGrad;
    for (var i = 0; i < items.length; i++) {
      angleRad = _this.pieData[items[i].sidx][i].endAngle - _this.pieData[items[i].sidx][i].startAngle;
      angleGrad = (180 * angleRad) / Math.PI;
      angleCount += (angleGrad / 2);
      if (angleCount < angleend && angleCount >= anglestart)
        mitems.push(items[i]);
      angleCount += (angleGrad / 2);
    }
    return mitems;
  }
}

ZtPieChart.prototype._DrawPathValueLabels = function(group, items, font, angleFactor, margins) {
  var text,
  draw,
  orgSize = font.size,
  item,
  radius = this._GetRadius(),
  innerRadius = this._GetInnerRadius(),
  div = ((((radius - innerRadius) / 2) + innerRadius) * 50) / (radius / 2),
  x_y1,
  x_y2,
  factor,
  lrFactor,
  prevX = 0,
  dX,
  end_x = 0,
  txtW = 0,
  txtWc = 0,
  txtH = 0,
  defaultMinLength = 7,
  defaultOffset = 3,
  postProgr = false,
  orgY = 0,
  fontRed = 0.25,
  piePos = true,  // true vuol dire che scrivo a destra, false a sinistra
  pprogY = 0,
  progrLen = 0,
  prevY = 0,
  label,
  _this = this,
  printAlways = this.defSettings.valueLabel.show == "horizontal",
  yPrec,
  yhPrec,
  xPrec,
  xwPrec,
  delta,
  lastDraw = true,
  lastPet = false,
  svgX = parseFloat(this.svg.attr("x")),
  isFirst = false;

  for (var i = 0; i < items.length; i++) {
    isFirst = (i == 0);
    draw = true;
    item = items[i];
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, "value");
    font.size = orgSize;
    end_x = 0;
    x_y1 = [];
    x_y2 = [];
    factor = 97;
    x_y1[0] = (margins.w / 2) + factor * item.centroid[0] / div;
    x_y1[1] = (margins.h / 2) + factor * item.centroid[1] / div;
    factor = 102;
    x_y2[0] = (margins.w / 2) + factor * item.centroid[0] / div;
    x_y2[1] = (margins.h / 2) + factor * item.centroid[1] / div;
    lrFactor = 1;
    // left - right
    if (x_y1[0] >= x_y2[0])
      lrFactor = - 1;

    txtH = getOffsetHeight(text, font, this.chartId);
    txtWc = getOffsetWidth(text, font, this.chartId);

    var a90_180 = (0 <= item.startAngle && item.startAngle < Math.PI/2),
    a180_270 = (Math.PI/2 <= item.startAngle && item.startAngle < Math.PI),
    a270_360 = (Math.PI <= item.startAngle && item.startAngle < Math.PI*(3/2)),
    a0_90 = item.startAngle < 0 || (Math.PI*(3/2) <= item.startAngle && item.startAngle < 2*Math.PI);
        
    // valutazione se ci sta in orizzontale senza pettine e senza valutazione
    dX = Math.abs(Math.max(x_y1[0], x_y2[0]) - prevX);
    if (x_y1[0] >= x_y2[0])
      dX = Math.abs(Math.min(x_y1[0], x_y2[0]) - prevX);

    var upd = false;
    // ci sta in orizzontale
    if ((txtWc + defaultOffset + defaultMinLength) <= dX) {
      // test se ci sta anche in verticale, altrimenti nulla
      if (lrFactor > 0 || ((x_y2[1] + (txtH / 4) - 1) >= txtH)) {
        end_x = x_y2[0] + lrFactor * defaultMinLength;
        prevX = Math.max(x_y1[0], x_y2[0]);
        if (x_y1[0] >= x_y2[0])
          prevX = Math.min(x_y1[0], x_y2[0]);
        postProgr = false;
        orgY = x_y2[1];
      }
      else
        upd = true; // valutare riduzione
    }

    var pet = false;
    if (!upd && lastDraw == true) {
      var thx = x_y2[0] + defaultOffset + txtWc;
      if (lrFactor > 0) { // parte dx
        if (((x_y2[1] + (txtH / 4) - 1)) >= yhPrec) { // dipende rotazione          
          if (a90_180) {
            if (x_y2[0] + defaultOffset <= xPrec && thx >= xPrec && thx <= xwPrec) {
              end_x = xwPrec;
              pet = (true && !isFirst);
            }
          }
          else if (a180_270) {
            if (x_y2[0] + defaultOffset >= xPrec || thx >= xPrec && thx <= xwPrec) {
              end_x = xwPrec;
              pet = (true && !isFirst);
            }
          }
        }
      }
      else {
        if (a270_360) {
          if ((x_y2[1] + (txtH / 4) - 1) >= yhPrec) {
            end_x = xPrec - (xwPrec - xPrec);
            pet = (true && !isFirst);
          }
        }
        else if ((x_y2[1] + (txtH / 4) - 1 - txtH) <= yPrec) { // dipende rotazione          
          if (a0_90) {
            end_x = xPrec - (xwPrec - xPrec);
            pet = (true && !isFirst);
          }
          else {
            end_x = xwPrec;
            pet = (true && !isFirst);
          }
        }
      }
    }

    if (!upd && !pet && end_x == 0)
      end_x = x_y2[0];

    // il test di prima non e' andato a buon fine
    if (upd || pet) {
      upd = false;
      // ci riprovo in x riducendo il font
      font.size = font.size - font.size * fontRed;
      txtWc = getOffsetWidth(text, font, this.chartId);
      var txtHr = getOffsetHeight(text, font, this.chartId);
      if (!printAlways && ((txtWc + defaultOffset + defaultMinLength) <= dX)) {
        // test se ci sta anche in verticale, altrimenti nulla
        if (lrFactor > 0 || ((x_y2[1] + (txtHr / 4) - 1) >= txtHr)) {
          end_x = x_y2[0] + lrFactor * defaultMinLength;
          prevX = Math.max(x_y1[0],x_y2[0]);
          if (x_y1[0] >= x_y2[0])
            prevX = Math.min(x_y1[0],x_y2[0]);
          postProgr = false;
          orgY = x_y2[1];
        }
        else
          upd = true;
      }

      if (upd) {
        // non ci sta nemmeno con riduzione
        prevX = Math.max(x_y1[0],x_y2[0]);
        if(x_y1[0] >= x_y2[0])
          prevX = Math.min(x_y1[0],x_y2[0]);
      
        // valutazione della y (eventuale pettine solo se non ci sta in orizzontale)
        font.size = orgSize;
        txtWc = getOffsetWidth(text, font, this.chartId);
        // y prec
        if (prevY == 0)
          end_x = x_y2[0] + lrFactor * defaultMinLength;
        else {
          var dY = Math.abs(x_y2[1] - prevY);
          if (txtH >= dY || ((txtH >= Math.abs(x_y2[1] - orgY) || txtH >= Math.abs(x_y2[1] - pprogY)) &&
             ((x_y2[1] >= prevY && angleFactor < 0) || (x_y2[1] <= prevY && angleFactor > 0)))) {
            if ((x_y1[0] < x_y2[0]) === piePos) {
              end_x = progrLen;
              if (postProgr) {
                end_x -= lrFactor * (txtW + txtWc);
                postProgr = false;
              }
              else
                postProgr = true;
              orgY = x_y2[1];
              x_y2[1] = prevY + (angleFactor * txtH);
              if (txtH >= Math.abs(x_y2[1] - pprogY))
                x_y2[1] = pprogY + (angleFactor * txtH);
            }
            else {
              end_x = x_y2[0] + lrFactor * defaultMinLength;
              postProgr = false;
              orgY = x_y2[1];
            }

            upd = false;
          }
          else {
            end_x = x_y2[0] + lrFactor * defaultMinLength;
            postProgr = false;
            orgY = x_y2[1];
          }
        }
      }
      else if (pet) {
        // potrebbe essere giusto in orizzontale ma non starci in verticale
        if (a90_180 || a0_90) {
          // basso verso alto
          if (((x_y2[1] + (txtH / 4) - 1)) >= yhPrec) {
            x_y2[1] = yhPrec;
          }
        }
        else if (a180_270 || a270_360) {
          // basso alto
          if (Math.abs((x_y2[1] + (txtH / 4) - 1) - yPrec) <= txtHr || Math.abs((x_y2[1] + (txtH / 4) - 1) - yPrec) <= (txtHr + defaultOffset)) {
            delta = (txtH / 4) - 1;
            x_y2[1] = yPrec + delta + defaultOffset;
          }
        }
      }
    }

    if (lastPet && !upd && !pet && printAlways) {
      // caso in cui non rientri nei casi precedenti pero' deve seguire il pettine
      // solo in printAlways
      if (a90_180 || a180_270) {
        // test se in orizz ci sta
        if (x_y2[0] + defaultOffset + txtWc >= xPrec)
          end_x = xwPrec;
        // test su y
        if (a90_180 && (x_y2[1] + (txtH / 4) - 1) >= yhPrec)
          x_y2[1] = yhPrec;
        else if (a180_270 && (x_y2[1] + (txtH / 4) - 1 - txtH) <= yPrec)
          x_y2[1] = yPrec + (txtH / 4) - 1 + defaultOffset;       
      }
      else if (a0_90) {
        // test se in orizz ci sta
        if (x_y2[0] - defaultOffset - txtWc <= xPrec)
          end_x = xPrec;
        // test su y
        if ((x_y2[1] + (txtH / 4) - 1) >= yhPrec)
          x_y2[1] = yhPrec;
      }

      pet = true;
    }

    // in x
    if (lrFactor > 0) {
      if ((end_x + txtWc) > (margins.x - svgX) + margins.w)
        draw = false;
    }
    else {
      if ((end_x - txtWc) < (margins.x - svgX))
        draw = false;
    }

    if (upd && !printAlways)
      draw = false;

    if (printAlways || draw) {
      if (end_x == 0) // non e' entrato in nessun caso prec.
        end_x = x_y2[0];

      // prima linea che esce dalla fetta
      group.append("line")
        .attr("x1", x_y1[0])
        .attr("y1", x_y1[1])
        .attr("x2", x_y2[0])
        .attr("y2", x_y2[1])
        .attr("transform", function () {
          if (_this.is3D)
            return "translate(0," + (- item.centroid[1]) + ")";
          return "translate(" + [- (margins.w / 2), - (margins.h / 2)] + ")";
        })
        .attr("style", "stroke:#000000;stroke-width:1px");
      
      var reverse = false;
      if (lrFactor > 0)
        reverse = (end_x < x_y2[0]);
      else
        reverse = (end_x > x_y2[0]);

      if (reverse) {
        delta = 0;
        if (lrFactor < 0) {
          delta = end_x - x_y2[0];
          end_x = x_y2[0] - delta;
        }
        else {
          delta = x_y2[0] - end_x;
          end_x = x_y2[0] + delta;
        }
      }

      // seconda linea calcolata in base alle valutazioni
      group.append("line")
        .attr("x1", x_y2[0])
        .attr("y1", x_y2[1])
        .attr("x2", end_x)
        .attr("y2", x_y2[1])
        .attr("transform", function () {
          if (_this.is3D)
            return "translate(0," + (- item.centroid[1]) + ")";
          return "translate(" + [- (margins.w / 2), - (margins.h / 2)] + ")";
        })
        .attr("style", "stroke:#000000;stroke-width:1px");

      if (draw) {
        if (x_y1[0] < x_y2[0])
          end_x += defaultOffset;
        else
          end_x -= defaultOffset;
      }

      label = group.append("text")
        .attr("x", end_x)
        .attr("y", x_y2[1] + (txtH / 4) - 1)  // 1px lo tolgo per l'eventuale bordo del renderer a margine
        .text(text)
        .attr("transform", function () {
          if (_this.is3D)
            return "translate(0," + (- item.centroid[1]) + ")";
          return "translate(" + [- (margins.w / 2), - (margins.h / 2)] + ")";
        })
        .attr("style", lrFactor > 0 ? 'text-anchor:start;' : 'text-anchor:end;');
      setFont(label, font, this);

      txtW = getOffsetWidth(text, font, this.chartId);
      progrLen = (end_x + lrFactor * txtW);
      pprogY = prevY;
      prevY = x_y2[1];
      piePos = x_y1[0] < x_y2[0];
      yhPrec = (x_y2[1] + (txtH / 4) - 1) - txtH;
      yPrec = (x_y2[1] + (txtH / 4) - 1);
      xwPrec = end_x + txtWc;
      xPrec = end_x;
      lastPet = pet;
    }

    lastDraw = draw;
  }
  font.size = orgSize;
}

ZtPieChart.prototype._SetTotalValueLabelObject = function (dataSet, limitw, limith, vField, index, tobj) {
  if (!this.defSettings.valueLabel.totalLabel.show)
    return;

  var radius = this._GetRadius(),
  innerRadius = this._GetInnerRadius(),
  mlimitw = (this.defSettings.valueLabel.position == "left" || this.defSettings.valueLabel.position == "right") ? (limitw / 2) - radius : limitw,
  lblFont = appliedFont(this.defSettings, this.defSettings.valueLabel.totalLabel, this.defSettings.valueLabel.totalLabel.totalLabelFont),
  orgsize = lblFont.size,
  fontRed = 0.25,
  calc = 0,
  txt = "";

  tobj[vField] = {};
  for (var i = 0; index >= 0 && i < dataSet.length; i++)
    calc = calc + dataSet[i][index];
  tobj[vField].value = calc;
  
  var pictItem = { value: tobj[vField].value, type: "totalValueLabel", field: vField },
  text = pictItem.value;
  // apply picture + funzione
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture) {
      txt = this.functionObj.GetValuePicture(pictItem);
    }
  }
  else {
    if (!isNaN(this.defSettings.valueLabel.totalLabel.precision))
      text = text.toFixed(this.defSettings.valueLabel.totalLabel.precision);
    txt = this.GetTotalValuePicture(text);
  }

  var oh = getOffsetHeight(txt, lblFont, this.chartId),
  ow = getOffsetWidth(txt, lblFont, this.chartId);
  var isOK;
  if (this.defSettings.valueLabel.position != "in") {
    isOK = false;
    if (ow < (mlimitw + 2) && oh < (limith + 2))
      isOK = true;
    else {
      lblFont.size = lblFont.size - lblFont.size * fontRed;
      oh = getOffsetHeight(txt, lblFont, this.chartId);
      ow = getOffsetWidth(txt, lblFont, this.chartId);
      if (ow < (mlimitw + 2) && oh < (limith + 2))
        isOK = true;
    }

    // ora in V
    if (!isOK && (this.defSettings.valueLabel.position == "left" || this.defSettings.valueLabel.position == "right")) {
      lblFont.size = orgsize;
      oh = getOffsetHeight(txt, lblFont, this.chartId);
      ow = getOffsetWidth(txt, lblFont, this.chartId);
      if (ow < (limith + 2) && oh < (mlimitw + 2)) {
        tobj[vField].isV = true;
        isOK = true;
      }
      else {
        lblFont.size = lblFont.size - lblFont.size * fontRed;
        oh = getOffsetHeight(txt, lblFont, this.chartId);
        ow = getOffsetWidth(txt, lblFont, this.chartId);
        if (ow < (limith + 2) && oh < (mlimitw + 2)) {
          tobj[vField].isV = true;
          isOK = true;
        }
      }
    }

    if (!isOK)
      tobj[vField].text = "";
    else
      tobj[vField].text = txt;
  }
  else if (this._GetInnerRadius() > 0) {
    isOK = false;
    if (ow < (innerRadius + 2) && oh < (innerRadius + 2)) {
      isOK = true;
    }
    else {
      lblFont.size = lblFont.size - lblFont.size * fontRed;
      oh = getOffsetHeight(txt, lblFont, this.chartId);
      ow = getOffsetWidth(txt, lblFont, this.chartId);
      if (ow < (innerRadius + 2) && oh < (innerRadius + 2)) {
        isOK = true;
      }
    }

    // riduco ancora
    if (!isOK) {
      lblFont.size = lblFont.size - lblFont.size * fontRed;
      oh = getOffsetHeight(text, lblFont, this.chartId);
      ow = getOffsetWidth(text, lblFont, this.chartId);
      if (ow < (innerRadius + 2) && oh < (innerRadius + 2)) {
        isOK = true;
      }
    }

    if (!isOK)
      tobj[vField].text = "";
    else
      tobj[vField].text = txt;
  }
  tobj[vField].width = ow;
  tobj[vField].height = oh;

  tobj.font = lblFont;
}

ZtPieChart.prototype._GetDefaultDataOrder = function () {
  return "row";
}

ZtPieChart.prototype._SetInReferredList = function (label) {
  this.categoryList.push(label);
  this.orgCategoryList.push(label);
  this.legendList.push(label);
}

ZtPieChart.prototype._SetNegativeValue = function () {
  this.hasNegativeValues = d3.min(this.allValues) < 0;
}

ZtPieChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this.RemoveAllPatterns();
  this._SetItems(lastChart);
  this._MapMarginsFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  cList = getList(this.xIndex, this.dataSet),
  oList = this.orgCategoryList,
  item,
  pie,
  stAngle,
  angleCos,
  pieDSet = {},
  _this = this;
  pie = d3.pie().sort(null);

  this._DrawPatterns();

  if (isNaN(this.defSettings.orientation.startAngle))
    stAngle = 0;
  else
    stAngle = this.defSettings.orientation.startAngle - 90;
  angleCos = stAngle * (Math.PI / 180);
  pie.startAngle(angleCos).endAngle((2 * Math.PI) + angleCos);

  var dList = this._GetOppositeDrawingList();
  var i, j;
  item = this.items[0]; // x le fnc basta il primo
  for (i = 0; /*this.is3D &&*/ i < dList.length; i++) {
    if (!pieDSet[dList[i]]) {
      var yIndex = this.propertyName.indexOf(dList[i]);
      pie.value(function(d) {
        return Math.abs(d[yIndex]);
      })
      pieDSet[dList[i]] = pie(this.dataSet);
    }

    if (this.is3D) {
      var cid = this.chartId + i + "_3dGroup",
      _3d = d3.select("#" + cid);
      _3d.selectAll("path").remove();

      var rightHalf = Math.floor(pieDSet[dList[i]].length / 2);
      if (Empty(rightHalf))
        rightHalf = 1;
      for (j = 0; j < rightHalf - 1; j++)
        item.itm._draw3DPaths(pieDSet[dList[i]], pieDSet[dList[i]].length - (j + 1), _3d, i, true, item.itm);

      for(j = 0; j <= (pieDSet[dList[i]].length - rightHalf); j++)
        item.itm._draw3DPaths(pieDSet[dList[i]], j, _3d, i, true, item.itm);

      for(j = 0; j < rightHalf - 1; j++)
        item.itm._draw3DPaths(pieDSet[dList[i]], pieDSet[dList[i]].length - (j + 1), _3d, i, false, item.itm);

      for(j = 0; j <= (pieDSet[dList[i]].length - rightHalf); j++)
        item.itm._draw3DPaths(pieDSet[dList[i]], j, _3d, i, false, item.itm);
    }
  }

  for (i = 0; i < this.items.length; i++) {
    if (this.items[i].itm) {
      item = this.items[i];
      var dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);
      record = this.dataSet[dataIndex];
      //MG VPV
      var zi = this.valueFields.indexOf(item.series);
      if( zi < 0 ) {
        d3.select(item.itm)
          .datum(item.value)
          .attr("d", function (d) {
            if (_this.is3D)
              return this._pieTop(d, this._radius, this._radius * 0.5, _this._GetInnerRadius());
            return "";
          });
      }
      else {
        yIndex = this.propertyName.indexOf(this.valueFields[zi]);
        item.value = record[yIndex];
        item.idx = !Empty(item.keyField) ? oList.indexOf(item.keyField) : oList.indexOf(item.category);

        d3.select(item.itm)
          .datum(pieDSet[_this.valueFields[zi]][dataIndex])
          .attr("d", function (d) {
            if (_this.is3D)
              return this._pieTop(d, this._radius, this._radius * 0.5, _this._GetInnerRadius());
            return this._arc(d);
          });

        lastValues = {};
        lastValues.startAngle = item.startAngle;
        lastValues.endAngle = item.endAngle;

        item.itm._lastValueObj = lastValues;

        if (item.value < 0)
          this.ApplyPatternOnItem(item, "negativeValuePattern");

        if (this.is3D) {
          var colD = get3DColor(item.color),
          styleObj = {};
          styleObj.fill = colD.color;
          var path3D = this.svg.selectAll(".pie3D_" + item.sidx + '_' + item.idx).filter(".pie_" + item.dataIndex)._groups;
          for (j = 0; j < path3D[0].length; j++)
            d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
          path3D = this.svg.selectAll(".p3D_" + item.sidx + '_' + item.idx).filter(".pie_" + item.dataIndex)._groups;
          for (j = 0; j < path3D[0].length; j++)
            d3.select(path3D[0][j]).attr("style", makeStyleHTMLString(styleObj, d3.select(path3D[0][j]).attr("style")));
        }

        this._GetOtherAnimateFunction(item, lastValues);
      }
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtPieChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight/*, onlySVG*/) {
  this.CreateSVG(id, parent, false, svgLeft, svgTop, svgWidth, svgHeight, false, 0, 0, 0, 0);
  this.CreateRenderer(this.svg, id, svgWidth - 1, svgHeight - 1, 0, 0);
}

ZtPieChart.prototype._SetScales = function () { }

ZtPieChart.prototype._ApplyClick = function (itemObject, evt) {
  StdChart.prototype._ApplyClick.call(this, itemObject, evt);
  this._SetSlice(itemObject);
}

ZtPieChart.prototype._SetSlice = function (item) {
  if (item.itemType != "pie")
    return;

  if (!item.isSelected) {
    d3.select(item.itm).attr("transform", "");
    if (!Empty(d3.select("[item-type=hover]").node()))
      d3.select("[item-type=hover]").attr("transform", "");
    return;
  }

  var slice = 7;
  if (!Empty(this.defSettings.slice.percent + "") && !isNaN(this.defSettings.slice.percent))
    slice = this.defSettings.slice.percent;

  /* vecchio calcolo
  var x_y = [ item.radius * Math.cos(0.5 * (item.startAngle + item.endAngle - Math.PI)) ,
              item.radius * item._3dFactor * (Math.sin(0.5 * (item.startAngle + item.endAngle - Math.PI)))
            ],
  */
  var x_y = item.centroid.slice(),
  div = ((((item.radius - this._GetInnerRadius()) / 2) + this._GetInnerRadius()) * 50) / (item.radius / 2);

  x_y[0] = (0.5 * slice * x_y[0]) / div;
  x_y[1] = (0.5 * slice * x_y[1]) / div;

  d3.select(item.itm).attr("transform", "translate(" + x_y + ")");
  d3.selectAll("[item-type=hover]").attr("transform", "translate(" + x_y + ")");

  if (this.is3D) {
    this.svg.selectAll(".pie3D_" + item.sidx + "_" + item.idx).filter(".pie_" + item.dataIndex).attr("transform", "translate(" + x_y + ")");
    this.svg.selectAll(".p3D_" + item.sidx + "_" + item.idx).filter(".pie_" + item.dataIndex).attr("transform", "translate(" + x_y + ")");
  }
}

ZtPieChart.prototype._DrawMarkerIconOnItem = function (item) {
  if (!this.chartLegends.series)
    return;
  if (this.chartLegends.series.position == "hide" || this.chartLegends.series.hide)
    return;

  if( !item.centroid ) return; //MG VPV

  d3.select(item.itm.parentNode)
    .append("text")
      .attr("class", "ztchartfonticon markerItem")
      .attr("x", item.centroid[0])
      .attr("y", item.centroid[1])
      .style("font-family", this.GetDefaultIconFont().name)
      .style("font-size", this.GetDefaultIconFont().size)
      .style("cursor", "default")
      .style("fill", item.color.color)
      .style("stroke", get3DColor(item.color).color)
      .style("stroke-width", 0.5)
      .text(this.GetMarkerLegendIcon());
}

ZtPieChart.prototype._EvaluatePrintValueLabel = function (/*type, item*/) {
  var ev = true;
 /* switch (type) {
    case "label":
      ev = item.sidx == 0;
      break;
    case "ser":
      ev = item.idx == 0;
      break;
    case "value":

      break;
    case "perc":

      break;
    case "dperc":

      break;
    case "labelvalue":

      break;
    case "servalue":

      break;
    case "serlabel":

      break;
    case "labelperc":

      break;
    case "dlabelperc":

      break;
    case "valueperc":

      break;
    case "dvalueperc":

      break;
    case "serperc":

      break;
    case "dserperc":

      break;
    case "totperc":
      break;
    default:
      ev = true;
      break;
  }*/
  return ev;
}

ZtPieChart.prototype.ApplyFocusKey = function () {
  if (this.focusKey && this.applyFocusKey) {
    var tmpFK = this.focusKey.split(","),
    type = "";
    for (var i = 0; i < tmpFK.length; i++) {
      type = tmpFK[i];
      if (!type && type != 0)
        continue;
      type = type + "";
      if (type.toLowerCase() == "negative value")
        continue;

      var itemObjects = this.GetAllItems(type);
      this.ApplySelectionsObjects(itemObjects.items);
      for (var j = 0; j < itemObjects.orgItems.length; j++)
        this._SetSlice(itemObjects.orgItems[j]);
    }
  }
  this.applyFocusKey = false;
}

ZtPieChart.prototype._ResetLists = function () {
  if (!Empty(this.objConfig.keyField)) {
    this.categoryList = getDuplicatesList(this.xLabelIndex, this.dataSet).array;
    this.orgCategoryList = getList(this.xIndex, this.dataSet);
  }
  else {
    this.categoryList = getList(this.xIndex, this.dataSet);
    this.orgCategoryList = this.categoryList.slice();
  }
  
  this.legendList = this.orgCategoryList.slice();
  if (!Empty(this.objConfig.keyField))
    this.legendList = this.categoryList.slice();

  this.allValues = getValues(this.valueFields, this.propertyName, this.dataSet);
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);
  this._SetTotalsObject();
}

ZtPieChart.prototype._EvaluateRadiusWithValueLabels = function () {
  var maxLen = 0;
  if (this.defSettings.valueLabel && this.defSettings.valueLabel.show == "horizontal") {  // niente automatismo di riduzione
    var font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    maxWordLabel = getOffsetWidth(getMaxWordLengthString(this.categoryList), font, this.chartId),
    maxWordSerie = getOffsetWidth(getMaxWordLengthString(this.seriesList), font, this.chartId),
    maxWordValue = getOffsetWidth(this.GetValuePicture(getMaxWordLengthString(this.allValues)), font, this.chartId),
    maxWordPerc = getOffsetWidth(this.GetValuePicture(100) + "%", font, this.chartId);

    switch (this.defSettings.valueLabel.type) {
      case "label":
        maxLen = maxWordLabel;
        break;
      case "ser":
        maxLen = maxWordSerie;
        break;
      case "value":
        maxLen = maxWordValue;
        break;
      case "perc":
      case "dperc":
        maxLen = maxWordPerc;
        break;
      case "labelvalue":
        maxLen = maxWordLabel + maxWordValue;
        break;
      case "servalue":
        maxLen = maxWordSerie + maxWordValue;
        break;
      case "serlabel":
        maxLen = maxWordSerie + maxWordLabel;
        break;
      case "labelperc":
      case "dlabelperc":
        maxLen = maxWordLabel + maxWordPerc;
        break;
      case "valueperc":
      case "dvalueperc":
        maxLen = maxWordValue + maxWordPerc;
        break;
      case "serperc":
      case "dserperc":
        maxLen = maxWordSerie + maxWordPerc;
        break;
      case "totperc":
        maxLen = maxWordPerc + maxWordPerc;
        break;
    }
  }
  return maxLen;
}

ZtPieChart.prototype._GetListForColors = function () {
  return this.categoryList;
}

ZtPieChart.prototype._GetGridColumnName = function (field) {
  var label = "",
  idx;
  if (field == this.objConfig.labelField || field == this.objConfig.keyField)
    label = ""; // dominio
  else {
    idx = this.valueFields.indexOf(field);
    label = this.rowLegendList[idx];
  }
  if (!Empty(this.objConfig.labelsGrid)) {
    if (field == this.objConfig.keyField) {
      if (!Empty(this.objConfig.labelsGrid.key))
        label = this.objConfig.labelsGrid.key;
    }
    else if (field == this.objConfig.labelField) {
      if (!Empty(this.objConfig.labelsGrid.domain))
        label = this.objConfig.labelsGrid.domain;
    }
    else {
      if (!Empty(this.objConfig.labelsGrid.values)) {
        idx = this.valueFields.indexOf(field);
        var vals = this.objConfig.labelsGrid.values.split(",");
        if (!Empty(vals[idx]))
          label = vals[idx];
      }
    }
  }
  return label;
}