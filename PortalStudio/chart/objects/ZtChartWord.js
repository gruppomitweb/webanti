function ZtWordChart() {
  ZtPieChart.apply(this);
  this.type = "WORDCLOUD";
  this.legendHexCode = "e91a";
}
ZtWordChart.prototype = Object.create(ZtPieChart.prototype);
ZtWordChart.prototype.constructor = ZtWordChart;

ZtWordChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.layout = this.chartConfig.graphSettings.layout;
}

ZtWordChart.prototype._SetLists = function () {
  StdChart.prototype._SetLists.call(this);
  this.allValues = getWordMinMaxIndex(this.valueFields, this.propertyName, this.dataSet, this.xIndex);
  this.legendList = this.categoryList.slice();
  if (!Empty(this.objConfig.keyField)) {
    this.labelCategoryList = getDuplicatesList(this.xLabelIndex, this.dataSet).array;
    this.legendList = this.labelCategoryList.slice();
  }
  this.rowLegendList = this.orgSeriesList.slice();
}

ZtWordChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = -1,
  id = "",
  group;

  for (var i = 0; i < positions.length; i++) {
    yIndex = this.propertyName.indexOf(this.valueFields[i]);
    id = this.chartId + i + "_";
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      .attr("transform","translate(" + [positions[i].width / 2, positions[i].height / 2] + ")");
    this.DrawWordCloud(group, this.dataSet, i, this.xIndex, yIndex, positions[i].width, positions[i].height, id);
    execScale(group, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");

  function execScale(group, svgLeft, svgTop, gWidth, gHeight) {
    var bbox = group.node().getBBox(),
    translate = "";
    if (bbox.width > 0 && bbox.height > 0) {
      var neww = gWidth / bbox.width,
      newh = gHeight / bbox.height,
      mscalerapp = Math.max(neww, newh) / Math.min(neww, newh);

      // rapporto max/min <1.5
      if (mscalerapp < 1.5)
        translate = "scale(" + [neww, newh] + ")";
      else
        translate = "scale(" + Math.min(neww, newh) + ")";
      group.attr("transform", translate);
      bbox = group.node().getBBox();
      translate += "translate(" + [Math.abs(bbox.x), Math.abs(bbox.y)] + ")";

      group.attr("transform", translate);
    }
  }
}

ZtWordChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  colD;
  for (var i = 0; i < this.items.length; i++) {
    idx = this.categoryList.indexOf(this.items[i].category);
    if (!Empty(this.objConfig.keyField))
      idx = this.orgCategoryList.indexOf(this.items[i].keyField);
    if (idx >= 0) {
      this.items[i].idx = idx;
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
}

ZtWordChart.prototype._AnimateChartElements = function () {
  var div = this._GetAnimatedDivisor();
  for (var i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;

    d3.select(elem)
      //.style("fill-opacity", 0)
      .attr("style", makeStyleHTMLString({fill9opacity:0}, d3.select(elem).attr("style")))
      .transition()
        .delay(this.items[i].dataIndex * this.defSettings.animation.duration/div)
        .duration(this.defSettings.animation.duration/div)
        //.style("fill-opacity", 1)
        .attr("style", makeStyleHTMLString({fill9opacity:1}, d3.select(elem).attr("style")))
  }
}

ZtWordChart.prototype._GetItemClone = function (item, itemObject) {
  var clone = this.GetItemClone(item);
  d3.select(clone).text(itemObject.texthover);
  return clone;
}

ZtWordChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  return;
  this.items = lastChart.items.slice();
  this._MapMarginsFromChart(lastChart);
  this._ApplyEvents();

  var record,
  cList = getList(this.xIndex, this.dataSet),
  oList = this.orgCategoryList,
  item;
  d3.pie().sort(null);

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm) {
      item = this.items[i];
      var dataIndex = !Empty(item.keyField) ? cList.indexOf(item.keyField) : cList.indexOf(item.category);

      record = this.dataSet[dataIndex];

      var yIndex = this.propertyName.indexOf(this.valueFields[item.sidx]);
      item.value = record[yIndex];
      item.idx = !Empty(item.keyField) ? oList.indexOf(item.keyField) : oList.indexOf(item.category);

      //this._GetOtherAnimateFunction(item, lastValues);
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtWordChart.prototype._DrawValueLabels = function () { }
