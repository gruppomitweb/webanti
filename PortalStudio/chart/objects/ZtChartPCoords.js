function ZtPCoordsChart() {
  StdChart.apply(this, ["PCOORDS", "e696"]);
  this.isH = true;
}
ZtPCoordsChart.prototype = Object.create(ZtPieChart.prototype);
ZtPCoordsChart.prototype.constructor = ZtPCoordsChart;

ZtPCoordsChart.prototype._SetChartSettingsJSON = function () {
  //
  this._ZtChart.enableExclude = false;
  //

  this.defSettings.valueAxis = this.chartConfig.graphSettings.valueAxis;
  this.defSettings.line = this.chartConfig.graphSettings.line;
  this.defSettings.valueAxis.precision = parseFloat(this.defSettings.valueAxis.precision);
  this.defSettings.shape = this.chartConfig.graphSettings.shape;
  this.defSettings.shape.onlyHover = false;
  this.defSettings.shape.figureTypes = ["circle", "square", "triangle", "cross", "diamond", "star", "wye"];

  if (!this.defSettings.shape.draw) {
    this.defSettings.shape.onlyHover = true;
    this.defSettings.shape.size = 2;
    this.defSettings.shape.type = "percent";
  }
}

ZtPCoordsChart.prototype._SetCalculationDataset = function () {
  var cdata = {},
  fdata,
  yIndex;
  for (var i = 0; i < this.orgCategoryList.length; i++) {
    if (!(this.orgCategoryList[i] in cdata))
      cdata[this.orgCategoryList[i]] = [];
    fdata = cdata[this.orgCategoryList[i]];
    for (var j = 0; j < this.valueFields.length; j++) {
      yIndex = this.propertyName.indexOf(this.valueFields[j]);
      fdata.push([this.orgCategoryList[i], this.categoryList[i], this.dataSet[i][yIndex]])
    }
  }

  this.calcDataset = cdata;
}

ZtPCoordsChart.prototype.CheckDataSet = function () { }

ZtPCoordsChart.prototype._SetScales = function () {
  this._GetChartInnerMargins();

  this.scaleY = {};
  var vf = this.valueFields.slice(),
  min,
  max,
  values,
  thHeight = this.chartHeight - (this.innerMargins.top + this.innerMargins.bottom);

  for (var i = 0; i < vf.length; i++) {
    this.scaleY[vf[i]] = d3.scaleLinear();
    this.scaleY[vf[i]].__fieldType = "N";
    this.scaleY[vf[i]].__scaleType = "N";
    values = this[vf[i] + "_values"];
    min = d3.min(values);
    max = d3.max(values);
    this.scaleY[vf[i]].range([0, thHeight])
                      .domain([max, min]);
  }

  if (this.margin) {
    this.scaleX = d3.scaleBand().domain(this.valueFields).range([0/*this.margin.left*/, this.chartWidth])
  }
}

ZtPCoordsChart.prototype._SetFieldsIndexes = function () {
  this.xLabelIndex = this.propertyName.indexOf(this.objConfig.labelField);
  this.xIndex = this.propertyName.indexOf(this.objConfig.keyField);
}

ZtPCoordsChart.prototype._SetLists = function () {
  this.categoryList = getDuplicatesListCAT(this.xIndex, this.xLabelIndex, this.dataSet).array;
  this.orgCategoryList = getList(this.xIndex, this.dataSet);
  this.drawingCategories = this.orgCategoryList.slice();
  this.valueFields = this.objConfig.valueFields.split(',');
  this.seriesList = this.objConfig.labelSeries.split(",");
  this.orgSeriesList = this.seriesList.slice();
  this.drawingSeries = this.orgSeriesList.slice();
  this.allValues = [];
  for (var i = 0; i < this.valueFields.length; i++) {
    this[this.valueFields[i] + "_values"] = getValues([this.valueFields[i]], this.propertyName, this.dataSet).unique();
    this.allValues = this.allValues.concat(this[this.valueFields[i] + "_values"]).unique();
  }
  this.legendList = this.categoryList.slice().unique();
}

ZtPCoordsChart.prototype._DrawAxis = function () {
  var opts = {};
  for (var i = 0; i < this.valueFields.length; i++) {
    // y axis
    opts.type = "value";
    opts.position = "Left";
    opts.x = this.scaleX(this.valueFields[i]) + this.scaleX.bandwidth() / 2;
    opts.y = this.margin.top + this.innerMargins.top;
    opts.scale = this.scaleY[this.valueFields[i]];
    opts.defSettings = this.defSettings.valueAxis;
    opts.font = this.defSettings.valueAxis.valueFont;
    opts.progr = "_" + i;
    opts.field = this.valueFields[i];
    this._DrawGenericAxis(opts);
  }
}

ZtPCoordsChart.prototype._DrawGenericAxis = function (options) {
  var position = options.position,
  xPos = options.x,
  yPos = options.y,
  id = options.progr || "",
  appFont = appliedFont(this.defSettings, options.defSettings, options.font),
  scale = options.scale,
  vRange = { min: d3.min(scale.domain()), max: d3.max(scale.domain()) },
  axis = d3["axis" + position](scale),
  precision = 0;
  
  if (!((Empty(options.defSettings.precision) || isNaN(options.defSettings.precision)) && options.defSettings.precision != 0))
    precision = options.defSettings.precision;
  else if (isNaN(options.defSettings.precision))
    precision = this._GetPrecisionFromValues(options.field);

  if (precision < 0)
    precision = 0;
  if (precision > 20)
    precision = 20;

  this._SelectAutoTickUnit(scale, vRange.min, vRange.max, appFont, false, precision);
  var ticks = setTicks(vRange.min, vRange.max, this.tickUnit, precision);
  axis.tickValues(ticks);
  axis.tickFormat(this.localeLangFormat.numberFormat(",." + precision + "f"));

  this.svg.append("g")
    .attr("id", this.chartId + options.type + "AxisGroup" + id)
    .attr("transform", "translate(" + [xPos, yPos] + ")")
    .call(axis);
  
  this.svg.select("#" + this.chartId + options.type + "AxisGroup" + id)
    .select("path")
      .attr("class", options.type + "Ax TRANSP");
}

ZtPCoordsChart.prototype._SetAxisColor = function () {
  // top y2 -3 | btm y2 3 | lft x2 -3 | rgt x2 3
  for (var i = 0; i < this.valueFields.length; i++) {
    this.SetAxisColor("value", "x2", -3, false, "_" + i);
  }
}

ZtPCoordsChart.prototype._SetAxisFont = function () {
  for (var i = 0; i < this.valueFields.length; i++) {
    this.SetAxisFont("value", "_" + i);
  }
}

ZtPCoordsChart.prototype._DrawChartPlot = function () {
  this.CreateSVG(this.chartId, this.parent, true, 0, 0, this.defSettings.globals.width, this.defSettings.globals.height, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top); // eslint-disable-line max-len
  this.CreateRenderer(this.svg, this.chartId, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this._DrawChartPlotTitles(this.svg);
  this._DrawChartPlotElements();
}

ZtPCoordsChart.prototype._DrawChartPlotElements = function () {
  this._DrawAxis();
  this._DrawAxisLabel();
}

ZtPCoordsChart.prototype._DrawAxisLabel = function () {
  var group,
  telem,
  offset = 5;
  for (var i = 0; i < this.valueFields.length; i++) {
    group = d3.select("#" + this.chartId + "valueAxisGroup_" + i);
    if (group.node()) {
      telem = group.append("text")
        .attr("x", 0)
        .attr("y", - (offset + getOffsetHeight(this.seriesList[i], this.defSettings.globalFont, this.chartId) / 2))
        .style("text-anchor", "middle")
        .text(this.seriesList[i]);
      
      setFont(telem, this.defSettings.globalFont, this);
    }
  }
}

ZtPCoordsChart.prototype._DrawChartElements = function () {
  console.log(this)
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [0, this.margin.top + this.innerMargins.top] + ")"),
  groupS = this.svg.append("g")
    .attr("id", this.chartId + this.type + "_shapesGroup")
    .attr("transform", "translate(" + [0, this.margin.top + this.innerMargins.top] + ")");

  for (var i = 0; i < this.orgCategoryList.length; i++) {
    this.DrawParallelLines(parentGroup, this.calcDataset[this.orgCategoryList[i]], this.valueFields);
    this.DrawShapes(groupS, this.calcDataset[this.orgCategoryList[i]], i, 0, 2, { });
  }
}

ZtPCoordsChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1;
  for (var i = 0; i < this.items.length; i++) {
    var styleObj = {},
    stroke = 1;
    if (!Empty(this.defSettings.line.stroke) && !isNaN(this.defSettings.line.stroke) && this.defSettings.line.stroke > 0)
      stroke = this.defSettings.line.stroke;
    idx = this.legendList.indexOf(this.items[i].category);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      if (this.defSettings.shape.draw && this.defSettings.shape.onlyShapes)
        this.items[i].color = { color : "transparent", gradient : "" };
      styleObj.stroke9width = stroke + "px";
      styleObj.stroke = this.items[i].color.color;
      styleObj.fill9opacity = 0;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtPCoordsChart.prototype._GetDivisor = function () {
  return this._GetOppositeDrawingList().length;
}

ZtPCoordsChart.prototype._IsNotExcludedDomain = function () {
  return true;
}

ZtPCoordsChart.prototype._GetChartInnerMargins = function () {
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];
  
  var myM = {};
  // etichette assi
  myM = setMarginObject("W", null, true, this.defSettings.globalFont);
  if (myM != 0) {
    myM.offset = 10;
    ret.top.push(myM);
  }

  myM = setMarginObject("W", null, true, this.defSettings.globalFont);
  if (myM != 0)
    ret.bottom.push(myM);

/*  var appliedfont = appliedFont(this.defSettings, this.defSettings.valueAxis, this.defSettings.valueAxis.valueFont);
  myM = getGenericLabelConf(appliedfont);
  myM.text = "";
  myM.addH = 5;
  myM.addW = 5;
  myM.textorientation = 90;
  ret.top.push(myM);
  ret.bottom.push(myM);
*/
  /*myM = setMarginObject("W", this.defSettings.valueAxis.valueFont, this.defSettings.valueAxis.useGlobalFont, this.defSettings.globalFont);
  if (myM != 0) {
    ret.top.push(myM);
    ret.bottom.push(myM);
  }
  */

  var span = getSpanTag(this.chartId);
  this.innerMargins = {
    top : getMargin(ret.top, span),
    right : getMargin(ret.right, span),
    bottom : getMargin(ret.bottom, span),
    left : getMargin(ret.left, span)
  };

}

ZtPCoordsChart.prototype._GetPrecisionFromValues = function (type) {
  var prec = 0,
  myVal = this[type + "_values"];
  for (var i = 0; i < myVal.length; i++)
    prec = Math.max(prec, decimalPlaces(myVal[i]));
  return prec;
}

ZtPCoordsChart.prototype._IsNotExcludedDomainShapes = function () {
  return true;
}

ZtPCoordsChart.prototype._GetShapeCX = function (d, dataIndex, xIndex, yIndex, recIndex/*, cobj*/) {
  return this.scaleX(this.valueFields[recIndex]) + this.scaleX.bandwidth() / 2 ;
}

ZtPCoordsChart.prototype._GetShapeCY = function (d, dataIndex, xIndex, yIndex, recIndex/*, cobj*/) {
  return this.scaleY[this.valueFields[recIndex]](d[yIndex]);
}

ZtPCoordsChart.prototype._SetShapesColor = function () { 
  for (var i = 0; i < this.shapes.length; i++) {
    this.shapes[i].category = this.categoryList[this.orgCategoryList.indexOf(this.shapes[i].keyField)];
    var idx = this.legendList.indexOf(this.shapes[i].category);
    if (idx >= 0) {
      this.shapes[i].idx = idx;
    //  this.shapes[i].sidx = this.orgCategoryList.indexOf(this.shapes[i].category);
    //  if (!Empty(this.objConfig.keyField))
      //  this.shapes[i].sidx = this.orgCategoryList.indexOf(this.shapes[i].keyField);
      this.shapes[i].color = { color: this.colorSet[idx].color, gradient: this.colorSet[idx].gradient };
      if (this.defSettings.useColorSeriesForEach)
        this.shapes[i].color = { color: this.colorSet[i].color, gradient: this.colorSet[i].gradient };
      if (this.shapes[i].isHole)
        this.shapes[i].color.color = invertColor(this.shapes[i].color.color);
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

ZtPCoordsChart.prototype._ApplyMouseOver = function (item, itemObj) {
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
          _this.ShowTooltip(mRefChart, item, itemObject);
        }
      }
    }, 50, mRefChart, item, itemObject, clone);
  }
}

ZtPCoordsChart.prototype._GetItems = function() {
  return ZtLinesChart.prototype._GetItems.call(this);
}

ZtPCoordsChart.prototype._AnimateChartElements = function () {
  ZtLinesChart.prototype._AnimateChartElements.call(this);
}

ZtPCoordsChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  ZtLinesChart.prototype._GetDefaultAnimateFunction.call(this, item, lastValueObj, duration);
}

ZtPCoordsChart.prototype._GetGridColumnName = function (field) {
  var label = "",
  idx;
  if (field == this.objConfig.labelField || field == this.objConfig.keyField)
    label = ""; // dominio
  else {
    idx = this.valueFields.indexOf(field);
    label = this.seriesList[idx];
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

ZtPCoordsChart.prototype._SetGridColumnStyle = function (/*innerdiv, field*/) {
  return;
}