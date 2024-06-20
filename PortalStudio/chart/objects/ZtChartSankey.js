function ZtSankeyChart() {
  StdChart.apply(this, ["SANKEY", "f0c8"]);
  this.multiSVG = true;
  this.arcs = [];
  this._totDepths = 1;
}
ZtSankeyChart.prototype = Object.create(ZtPieChart.prototype);
ZtSankeyChart.prototype.constructor = ZtSankeyChart;

ZtSankeyChart.prototype._SetChartSettingsJSON = function () {
  this._ZtChart.enableExclude = false;

  this.defSettings.sankey = this.chartConfig.graphSettings.extends.sankey;
  if (!("order" in this.defSettings.sankey)) {
    this.defSettings.sankey.order = true;
  }
  else
    this.defSettings.sankey.order = CharToBool("" + this.defSettings.sankey.order);
  
}

ZtSankeyChart.prototype._SetFieldsIndexes = function () {
  ZtMatrixChart.prototype._SetFieldsIndexes.call(this);
}

ZtSankeyChart.prototype._SetLists = function () {
  ZtMatrixChart.prototype._SetLists.call(this);
}

ZtSankeyChart.prototype._SetCalculationDataset = function () {
  var addFields = [];
  if (this.categoryCodeIndex >= 0)
    addFields.push( { prop: "categoryCode", index: this.categoryCodeIndex } );
  var fobj = getSankeyNodesDataset(this.dataSet, this.levelsFields, this.valueFields, this.propertyName, addFields);
  this.nodes = fobj.nodes;
  this.links = fobj.links;
  this.legendList = this.nodes.map(function(elem) { return elem.name; });
  this.orgSeriesList = this.seriesList = this.legendList;
}

ZtSankeyChart.prototype._DrawChartElements = function () {
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup");
  
  this.DrawSankey(group, this.nodes, this.links)
}

ZtSankeyChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var styleObj,
  i;

  // links
  for (i = 0; i < this.items.length; i++) {
    styleObj = {};
    styleObj.stroke = this.colorSet[this.items[i].source.index].color;
    styleObj.fill9opacity = 0;
    styleObj.stroke9opacity = 0.6;
    d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    this.items[i].color = { color: this.colorSet[this.items[i].source.index].color, gradient: "" };
    this.items[i].idx = this.items[i].source.index;
  }

  for (i = 0; i < this.arcs.length; i++)
    d3.select(this.arcs[i].itm).attr("style", makeStyleHTMLString({ fill: this.colorSet[this.arcs[i].index].color }, d3.select(this.arcs[i].itm).attr("style")));
}

ZtSankeyChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  return ZtMatrixChart.prototype._GetParametersStringForTooltip.call(this, item, itemObject);
}

ZtSankeyChart.prototype._GetParametersStringForLink = function (item) {
  return ZtMatrixChart.prototype._GetParametersStringForLink.call(this, item);
}

ZtSankeyChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  defaultValues = Empty(lastValueObj),
  elem = item.itm,
  totLen,
  value;

  totLen = elem.getTotalLength(),
  value = d3.select(elem).attr("d");
  if (defaultValues) {
    d3.select(elem)
      .attr("stroke-dasharray", totLen + " " + totLen)
      .attr("stroke-dashoffset", totLen)
      .transition()
        .delay(item.depth * duration/div)
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

ZtSankeyChart.prototype._GetAnimatedDivisor = function () {
  return this._totDepths;
}

ZtSankeyChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  if (!this._ZtChart.enableClickEffect)
    return;
  var halfOpacity = this.defSettings.selectionOptions.opacity,
  fullOpacity = 1,
  semiOpacity = 0.6,
  fillColor = this.defSettings.selectionOptions.color,
  stobj;
  for (var i = 0; i < items.length; i++) {
    if (!items[i].itm)
      continue;
    if (items[i].type == "legend") {
      this._ApplyLegendSelectEffect(items[i], selected);
      continue;
    }
    stobj = {};
    if (selected) {
      stobj.stroke9opacity = fullOpacity;
      if (!Empty(items[i].colorApplied))
        stobj.fill = items[i].colorApplied;
      if(this.GetNotSelectedItems().length == items.length){
        stobj.stroke9opacity = semiOpacity;
      }
    }
    else {
      stobj.stroke9opacity = halfOpacity;
      if (!Empty(fillColor) && this.GetSelectedItems().length > 0)
        stobj.fill = fillColor;
    }
    d3.select(items[i].itm).attr("style", makeStyleHTMLString(stobj, d3.select(items[i].itm).attr("style")));
  }
}

ZtSankeyChart.prototype._DrawValueLabels = function () {
  var group = this.svg.append("g")
                .attr("id", this.chartId + "valueLabels"),
  items = this.arcs,
  item,
  _this = this;

  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var //text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp());
    text = item.name,
    pos = "",
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont);

    if (item.depth == 0 || item.depth == this._totDepths) { // estremi
      pos = this.defSettings.sankey.valueLabel.firstlastPosition || "outside";
    }
    else {
      pos = this.defSettings.sankey.valueLabel.middlePosition || "left";
    }

    var label = group.append("text")
              .attr("x", this._GetValueLabelX(pos, item))
              .attr("y", this._GetValueLabelY(pos, item, text, font))
              .style("text-anchor", function () {
                if ((pos == "left" && item.depth > 0 && item.depth < _this._totDepths) || 
                    (pos == "inside" && item.depth == _this._totDepths) ||
                    (pos == "outside" && item.depth == 0))
                  return "end";
                return "start";
              })
              .text(text);
    setFont(label, font, this);
  }
}

ZtSankeyChart.prototype._GetValueLabelX = function (pos, item/*, text, font*/) {
  var offset = 5,
  size = 0;
  switch (pos) {
    case "outside":
      if (item.depth == this._totDepths)  // è come right
        size = getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) + offset;
      if (item.depth == 0)  // è come left
        size = getDomNodeLeft(item.itm) - offset;
      break;
    case "inside":
      if (item.depth == 0)  // è come right
        size = getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) + offset;
      if (item.depth == this._totDepths)  // è come left
        size = getDomNodeLeft(item.itm) - offset;
      break;
    case "left":
      if (item.depth > 0 && item.depth < this._totDepths)
        size = getDomNodeLeft(item.itm) - offset;
      break;
    case "right":
      if (item.depth > 0 && item.depth < this._totDepths)
        size = getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) + offset;
      break;
  }
  return size;
}

ZtSankeyChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  return getDomNodeTop(item.itm) + getDomNodeHeight(item.itm) / 2 + getOffsetHeight(text, font, this.chartId) / 4;
}

ZtSankeyChart.prototype._GetChartMarginsObject = function (/*chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  if (this.defSettings.valueLabel.show != "hide") {
    if (Empty(this.defSettings.sankey.valueLabel.firstlastPosition) || this.defSettings.sankey.valueLabel.firstlastPosition == "outside") {
      var appliedfont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
      maxtext = getMaxWordLength(this.legendList),
      myM = getGenericLabelConf(appliedfont);
      myM.text = maxtext;
      myM.offset = 0;
      myM.textorientation = 0;
      ret.left.push(myM);
      myM = getGenericLabelConf(appliedfont);
      myM.text = maxtext;
      myM.offset = 0;
      myM.textorientation = 0;
      ret.right.push(myM);
    }
  }
  
  return ret;
}

ZtSankeyChart.prototype._GetItemObj = function (itemObject) {
  var ret = {
    sourceElement : itemObject.source.name,
    targetElement : itemObject.target.name,
    rowIdx : itemObject.data_idx,
    isSelected : itemObject.isSelected,
    focus : itemObject.focus,
    multidimCurrentKey : this.appliedKey,
    color: itemObject.color
  };
  return ret;
}

ZtSankeyChart.prototype._CheckIdentityItem = function (itemOrg, itemOth) {
  return (itemOrg.sourceElement == itemOth.sourceDesc && itemOrg.targetElement == itemOth.targetDesc) 
      || (itemOrg.sourceElement == itemOth.targetDesc && itemOrg.targetElement == itemOth.sourceDesc)
      || (itemOrg.sourceDesc == itemOth.sourceDesc && itemOrg.targetDesc == itemOth.targetDesc)
      || (itemOrg.sourceDesc == itemOth.targetDesc && itemOrg.targetDesc == itemOth.sourceDesc);
}

ZtSankeyChart.prototype._CreateGrid = function (thead, tbody1) {
  return ZtMatrixChart.prototype._CreateGrid.call(this, thead, tbody1);
}

ZtSankeyChart.prototype._GetGridCellValue = function (value, isLast) {
  return ZtMatrixChart.prototype._GetGridCellValue.call(this, value, isLast);
}

ZtSankeyChart.prototype._GetGridCellValue = function (value, isValue, record) {
  return ZtMatrixChart.prototype._GetGridCellValue.call(this, value, isValue, record);
}

ZtSankeyChart.prototype._FindItemForGrid = function (record) {
  return ZtMatrixChart.prototype._FindItemForGrid.call(this, record);
}

ZtSankeyChart.prototype._GetItemForGrid = function (item) {
  return ZtMatrixChart.prototype._GetItemForGrid.call(this, item);
}
