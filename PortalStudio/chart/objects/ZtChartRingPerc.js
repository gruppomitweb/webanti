function ZtRingPChart() {
  StdChart.apply(this, ["RINGPERC", "e902"]);
  this.multiSVG = true;
  this.radius = 0;
  this.multiMargins = {};
  this.pieData = [];
  this.applyCalculationAfter = true;
}
ZtRingPChart.prototype = Object.create(ZtPieChart.prototype);
ZtRingPChart.prototype.constructor = ZtRingPChart;

ZtRingPChart.prototype._SetChartSettingsJSON = function () {
  ZtPieChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.style = this.chartConfig.graphSettings.extends.styles.ring;
}

ZtRingPChart.prototype._SetLists = function () {
  this._SetCategoryList();

  /*this.seriesList = this.objConfig.labelSeries.split(",")[0];
  this.orgSeriesList = this.seriesList.slice();*/
  // 1 solo campo valore + evt campo max
  this.valueFields = this.objConfig.valueFields;
  this.maxFields = this.objConfig.maxFields;
  this.drawingSeries = this.valueFields.slice();

  this._EvaluateAllValues();
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);

  this.legendList = this.orgCategoryList.slice();
  if (!Empty(this.objConfig.keyField))
    this.legendList = this.categoryList.slice();
  this.seriesList = this.orgSeriesList = this.legendList;
  this.rowLegendList = [];
}

ZtRingPChart.prototype._SetCalculationDataset = function (dataSet) {
  if (Empty(dataSet))
    return;
  var rec = JSON.stringify(dataSet[0]);
  this.calcDataset = [];
  this.calcDataset.push(JSON.parse(rec));
  this.calcDataset.push(JSON.parse(rec));
  var last = this.calcDataset[this.calcDataset.length - 1],
  val = this.dataSet[0][this.propertyName.indexOf(this.valueFields)];
  if (Empty(this.maxFields)) {
    last[this.propertyName.indexOf(this.valueFields)] = 100 - val;
  }
  else {
    var max = this.dataSet[0][this.propertyName.indexOf(this.maxFields)];
    last[this.propertyName.indexOf(this.valueFields)] = ((max - val) * 100) / max;
    this.calcDataset[0][this.propertyName.indexOf(this.valueFields)] = (val * 100) / max;
  }
}

ZtRingPChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var dList = this._GetDrawingList(),
  positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = this.propertyName.indexOf(this.valueFields),
  id = "",
  group,
  radius,
  innerRadius,
  arc,
  mvalues,
  maxLenVL = this._EvaluateRadiusWithValueLabels(),
  totArc = d3.arc().startAngle(0).endAngle(2 * Math.PI);

  this._DrawPatterns();

  this.totalValueLabel = {};
  for (var i = 0; i < positions.length; i++) {
    radius = Math.min(positions[i].width, positions[i].height) / 2;
    radius = radius - radius * 0.05;  // tolgo il 5% per dare un po' di spazio al disegno
    //-no slice- radius = radius - ((radius * slice / 100) / 4);
    radius = radius - maxLenVL;
    this.radius = radius;
    innerRadius = this._GetInnerRadius();

    arc = d3.arc().innerRadius(innerRadius).outerRadius(this.radius);
    if (this.defSettings.style.style == "round")
      arc.cornerRadius((this.radius - innerRadius) / 2);
    totArc.innerRadius(innerRadius + 1).outerRadius(this.radius - 1);

    id = this.chartId + i + "_";
    var xIndex = Empty(this.objConfig.keyField) ? this.xIndex : this.xLabelIndex;
    mvalues = this.dataSet.filter( function(record) { return record[xIndex] == dList[i]; } );
    this._SetCalculationDataset(mvalues);

    this.totalValueLabel[dList[i]] = { value: this.calcDataset[0][yIndex] };
    this._SetTotalValueLabelObject(this.totalValueLabel[dList[i]]);

    this.multiMargins[dList[i]] = { x : this.margin.left + positions[i].x, 
                                    y : this.margin.top + positions[i].y,
                                    w : positions[i].width,
                                    h : positions[i].height
                                  };
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      .attr("transform","translate(" + [positions[i].width / 2, positions[i].height / 2] + ")");
    
    group.append("path").attr("class", "TRANSP tot_pie").attr("d", totArc);
    
    this.DrawRingPerc(group, this.calcDataset, i, xIndex, yIndex, id, arc);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtRingPChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
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
    }
  }
  this.svg.selectAll(".tot_pie").style("fill", this.defSettings.style.background || "#E0E0E0");
}

ZtRingPChart.prototype._GetInnerRadius = function (radius) {
  radius = radius || this._GetRadius();
  if (Empty(this.defSettings.radius) || isNaN(this.defSettings.radius.inner))
    return radius * 0.25;
  else
    return radius * (this.defSettings.radius.inner / 100);
}

ZtRingPChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration, noOpacity) {
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

ZtRingPChart.prototype._GetDivisor = function () {
  return this._GetDrawingList().length;
}

ZtRingPChart.prototype.DrawValueLabels = function () {
  if (this.defSettings.valueLabel.totalLabel && this.defSettings.valueLabel.totalLabel.show)
    this._DrawValueLabels();
}

ZtRingPChart.prototype._DrawValueLabels = function () {
  var oldChartId = this.chartId;
  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
    var group = d3.select("#" + this.chartId + "d3Renderer").append("g")
                  .attr("id", this.chartId + "valueLabels")
                  .attr("transform", d3.select("#" + this.chartId + this.type + "_elementGroup").attr("transform")),
    font = appliedFont(this.defSettings, this.defSettings.valueLabel.totalLabel, this.defSettings.valueLabel.totalLabel.totalLabelFont),
    label;
    if (this.totalValueLabel[this.categoryList[i]]) {
      label = group.append("text")
        .attr("x", 0)
        .attr("y", this.totalValueLabel[this.categoryList[i]].height / 4)
        .style("text-anchor", "middle")
        .text(this.totalValueLabel[this.categoryList[i]].text || "");
      setFont(label, font, this);
    }
  }
  this.chartId = oldChartId;
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
}

ZtRingPChart.prototype._SetTotalValueLabelObject = function (tobj) {
  if (!this.defSettings.valueLabel.totalLabel.show)
    return;

  var innerRadius = this._GetInnerRadius(),
  lblFont = appliedFont(this.defSettings, this.defSettings.valueLabel.totalLabel, this.defSettings.valueLabel.totalLabel.totalLabelFont),
  fontRed = 0.25,
  text = "";

  if (isNaN(this.defSettings.valueLabel.totalLabel.precision) || (Empty(this.defSettings.valueLabel.totalLabel.precision) && this.defSettings.valueLabel.totalLabel.precision != 0))
    text = this.localeLangFormat.numberFormat(",." + decimalPlaces(tobj.value) + "f")(tobj.value);
  else
    text = this.localeLangFormat.numberFormat(",." + this.defSettings.valueLabel.totalLabel.precision + "f")(tobj.value);

  var oh = getOffsetHeight(text, lblFont, this.chartId),
  ow = getOffsetWidth(text, lblFont, this.chartId),
  isOK;
  if (this._GetInnerRadius() > 0) {
    isOK = false;
    if (ow < (innerRadius + 2) && oh < (innerRadius + 2)) {
      isOK = true;
    }
    else {
      lblFont.size = lblFont.size - lblFont.size * fontRed;
      oh = getOffsetHeight(text, lblFont, this.chartId);
      ow = getOffsetWidth(text, lblFont, this.chartId);
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
      tobj.text = "";
    else
      tobj.text = text + " %";
  }
  tobj.width = ow;
  tobj.height = oh;
  tobj.font = lblFont;
}

ZtRingPChart.prototype._SupportChangeOrder = function () {
  return false;
}
