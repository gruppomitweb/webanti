function ZtFunnelChart() {
  StdChart.apply(this, ["FUNNEL", "f071"]);
  this.multiSVG = true;
  this.multiMargins = {};
  this.borderItem = [];
  this.byCount = (this.type == "FUNNEL");
}
ZtFunnelChart.prototype = Object.create(ZtPieChart.prototype);
ZtFunnelChart.prototype.constructor = ZtFunnelChart;

ZtFunnelChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.funnel = this.chartConfig.graphSettings.extends.funnel;
  this.defSettings.shape = this.chartConfig.graphSettings.shape;
  this.defSettings.shape.onlyHover = false;
  this.defSettings.shape.figureTypes = ["circle", "square", "triangle", "cross", "diamond", "star", "wye"];

  if (!this.defSettings.shape.draw) {
    this.defSettings.shape.onlyHover = true;
    this.defSettings.shape.size = 2;
    this.defSettings.shape.type = "percent";
  }
  
  this.funnelColor = Empty(this.chartConfig.graphSettings.gauge.fillColor) ? "#A3A3A3" : this.chartConfig.graphSettings.gauge.fillColor;
  this.defSettings.fillTransparency = this.chartConfig.graphSettings.fillTransparency;
}

ZtFunnelChart.prototype._SetScales = function () {
  this.scaleY = {};
  for (var i = 0; i < this.valueFields.length; i++) {
    this.scaleY[this.valueFields[i]] = {};
    this.scaleY[this.valueFields[i]].left = d3.scaleLinear();
    this.scaleY[this.valueFields[i]].right = d3.scaleLinear();
  }
}

ZtFunnelChart.prototype._SetScaleParameters = function (scaleY, type, min, max, width, hrel) {
  var offset = 4,
  sRadius = 2 * this.GetShapesRadius();

  scaleY[type].domain([min, max]);
  if (type == "left")
    scaleY[type].range([width/2, 0]);
  else
    scaleY[type].range([width/2, width]);

  var newmin = min,
      newmax = max;

  if(this.defSettings.funnel.type != 'shapes'){ //blocks, bottom, middle
      newmin = scaleY.left.invert(scaleY.left(min) + offset);
    if(this.defSettings.funnel.type =='middle'){
      newmax = scaleY.left.invert(scaleY.left(max) - (hrel/2));
    }
  }
  else{ //shapes
    newmax = scaleY.left.invert(scaleY.left(newmax) - sRadius);
  }

  scaleY[type].domain([newmin, newmax]);
}

ZtFunnelChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  yIndex = -1,
  id = "",
  group,
  groupS,
  dList = this._GetOppositeDrawingList(),
  _this = this,
  mvalues = [],
  scaleY,
  min,
  max;

  for (var i = 0; i < positions.length; i++) {
    yIndex = this.propertyName.indexOf(dList[i]);
    scaleY = this.scaleY[dList[i]];
    
    id = this.chartId + i + "_";
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);

    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
    groupS = this.renderer.append("g")
      .attr("id", id + this.type + "_shapesGroup")
    
    mvalues = this.dataSet.map( function(rec) { return [rec[_this.xIndex], rec[yIndex]] });
    min = d3.min(mvalues.map(function(record) { return record[1]; }));
    max = d3.max(mvalues.map(function(record) { return record[1]; }));
    this._SetScaleParameters(scaleY, "left", min, max, positions[i].width, positions[i].height/mvalues.length);
    this._SetScaleParameters(scaleY, "right", min, max, positions[i].width, positions[i].height/mvalues.length);

    this.DrawFunnel(group, mvalues, i, 1, scaleY, positions[i].height);
    if (this.defSettings.funnel.type == "shapes")
      this.DrawShapes(groupS, mvalues, i, this.xIndex, 1, {scaleY: scaleY, dataLen: mvalues.length, gHeight: positions[i].height, valueField: dList[i]});
    
    if (this.seriesList.length > 1)
      this.DrawDomainLabel(i, positions[i], this.seriesList[this.valueFields.indexOf(dList[i])]);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtFunnelChart.prototype._GetShapeCX = function (d, dataIndex, xIndex, yIndex, recIndex, cobj) {
  return cobj.scaleY.right(d[yIndex]);
}

ZtFunnelChart.prototype._GetShapeCY = function (d, dataIndex, xIndex, yIndex, recIndex, cobj) {
  return recIndex * (cobj.gHeight / cobj.dataLen) + (2 * this.GetShapesRadius());
}

ZtFunnelChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  colD,
  i;

  for (i = 0; i < this.items.length; i++) {
    if (this.defSettings.funnel.type == "shapes") {
      d3.select(this.items[i].itm)
        .style("fill", this.funnelColor);
      if (this.defSettings.fillTransparency)
        d3.select(this.items[i].itm).style("fill-opacity", 0.6);
    }
    else {
      idx = this.categoryList.indexOf(this.items[i].category);
      if (idx >= 0) {
        this.items[i].idx = idx;
        this.items[i].sidx = this.valueFields.indexOf(this.items[i].valueField);
        this.items[i].color = this.colorSet[idx];
        if (this.defSettings.useColorSeriesForEach)
          this.items[i].color = this.colorSet[i];
        if (this.defSettings.reuseColorSeries)
          this.items[i].color = this.colorSet[i % this.colorSet.length];
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
        styleObj.stroke = colD;
        d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      }
    }
  }

  for (i = 0; i < this.borderItem.length; i++) {
    this.borderItem[i].style("stroke", "none"); 
  }

}

ZtFunnelChart.prototype._IsNotExcludedDomainShapes = function (text) {
  return this.categoryList.hasElement(text) >= 0;
}

ZtFunnelChart.prototype._GetItems = function () {
  if (this.defSettings.funnel.type == "shapes")
    return this.shapes;
  return this.items;
}

ZtFunnelChart.prototype._SetShapesColor = function () { 
  for (var i = 0; i < this.shapes.length; i++) {
    var idx = this.categoryList.indexOf(this.shapes[i].category);
    if (idx >= 0) {
      this.shapes[i].idx = idx;
      this.shapes[i].sidx = this.orgCategoryList.indexOf(this.shapes[i].category);
      if (!Empty(this.objConfig.keyField))
        this.shapes[i].sidx = this.orgCategoryList.indexOf(this.shapes[i].keyField);
      this.shapes[i].color = { color: this.colorSet[idx].color, gradient: this.colorSet[idx].gradient };
      if (this.defSettings.useColorSeriesForEach)
        this.shapes[i].color = { color: this.colorSet[i].color, gradient: this.colorSet[i].gradient };
      var styleObj = {};
      styleObj.fill = this.GetChartBackground().color;
      styleObj.stroke9width = (this.defSettings.shape.stroke || 1) + "px";
      if (!this.defSettings.shape.onlyHover) {
        styleObj.stroke = this.shapes[i].color.color;
        if (this.defSettings.shape.colorSeries[idx])
          styleObj.stroke = this.defSettings.shape.colorSeries[idx].color;
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

ZtFunnelChart.prototype._ApplyMouseOver = function (item, itemObj) {
  if (this.defSettings.funnel.type == "shapes") {
    var _this = this,
    mRefChart = this._ZtChart.StdChart;
    this.RemoveAllHovers();
    if (item) {
      var itemObject = itemObj || this._GetItems()[d3.select(item).attr("item-index")],
      clone = this._GetItemClone(item);
      mRefChart._hoverItem = itemObject;
      d3.select(clone)
        .attr("item-type", "hover")
        .attr("d", d3.symbol()
          .size( function () { return 5 * Math.pow(_this.GetShapesRadius(), 2); })
          .type( function () {
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
            _this.ShowTooltip(mRefChart, item, itemObject);
          }
        }
      }, 50, mRefChart, item, itemObject, clone);
    }
  }
  else
    ZtPieChart.prototype._ApplyMouseOver.call(this, item, itemObj);
}

ZtFunnelChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  ZtLinesChart.prototype._GetDefaultAnimateFunction.call(this, item, lastValueObj, duration);
}