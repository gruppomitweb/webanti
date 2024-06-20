function ZtPyramidChart(type) {
  StdChart.apply(this, [type, "f071"]);
  this.multiSVG = true;
  this.multiMargins = {};
  this.borderItem = [];
  this.byCount = (this.type.indexOf("STR") >= 0);
  this.hasNeck = (this.type.indexOf("NECK") >= 0);
}
ZtPyramidChart.prototype = Object.create(ZtPieChart.prototype);
ZtPyramidChart.prototype.constructor = ZtPyramidChart;

ZtPyramidChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.pyramid = this.chartConfig.graphSettings.extends.pyramid;
  this.defSettings.pyramid.rotation = parseInt(this.defSettings.pyramid.rotation);
}

ZtPyramidChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = -1,
  id = "",
  group,
 // domainLabelH = 0,
  dList = this._GetOppositeDrawingList(),
  _this = this,
  mvalues = [];

  this._DrawPatterns();
/*
  this.totalValueLabel = {};
  if (this.seriesList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);
*/
  for (var i = 0; i < positions.length; i++) {
    yIndex = this.propertyName.indexOf(dList[i]);

    id = this.chartId + i + "_";
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);

    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      //.attr("transform","translate(" + [positions[i].width / 2, positions[i].height / 2] + ")");
    
    mvalues = this.dataSet.map( function(rec) { 
      if (_this.categoryCodeIndex >= 0)
        return [rec[_this.xIndex], rec[yIndex], rec[_this.categoryCodeIndex]]
      return [rec[_this.xIndex], rec[yIndex]];
    });
    if (this.byCount)
      mvalues.sort(function(a, b){ return a[1] - b[1]; });

    this.DrawPyramid(group, mvalues, i, 1, positions[i].width, positions[i].height);
    
    if (this.seriesList.length > 1)
      this.DrawDomainLabel(i, positions[i], this.seriesList[this.valueFields.indexOf(dList[i])]);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtPyramidChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  i,
  colD;

  for (i = 0; i < this.items.length; i++) {
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
        colD = "url(" + document.URL + "#" + gradID + ")";
      }
      styleObj.fill = colD;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }

  for (i = 0; i < this.borderItem.length; i++) {
    this.borderItem[i].style("stroke", "none"); 
  }

}

ZtPyramidChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration/*, noOpacity*/) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm;
  
  d3.select(elem)
    .style("fill-opacity", 0)
    .transition()
      .delay(item.idx * (duration / div))
      .duration(duration / div)
      .ease(d3.easeLinear)
      .style("fill-opacity", 1)
}

ZtPyramidChart.prototype._GetAnimatedDivisor = function() {
  var div = this.legendList.length;
  if (div == 0)
    div = 1;
  return div;
}