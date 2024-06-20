function ZtMultiDimCursorChart() {
  ZtPieChart.apply(this, ["MULTICURS"]);
  this.selectedObjects;
  this.confObj;
  this.allDataIndex = [];
}
ZtMultiDimCursorChart.prototype = Object.create(ZtPieChart.prototype);
ZtMultiDimCursorChart.prototype.constructor = ZtMultiDimCursorChart;

ZtMultiDimCursorChart.prototype._SetChartSettingsJSON = function () {
  this.mchartModel = this.GetChart(this.chartConfig.graphSettings.chartType, true);
}

ZtMultiDimCursorChart.prototype._SetTitles = function () {
  if (this.dataOrder == "column") {
    if (!Empty(this.objConfig.titleSeries))
      this.defSettings.chartLegend.text = this.objConfig.titleSeries;
  }
}

ZtMultiDimCursorChart.prototype.SetDomainType = function () { }

ZtMultiDimCursorChart.prototype.SetData = function () {
  this.mchartModel.SetData();
}

ZtMultiDimCursorChart.prototype.SetDataDraw = function () {
  this.SetData();
  this.mchartModel.CheckDataSet();
}

ZtMultiDimCursorChart.prototype.CheckDataSet = function () { }

ZtMultiDimCursorChart.prototype._SetLists = function () {
  this.categoryList = [];
  this.seriesList = [];
  this.orgCategoryList = [];
  this.valueFields = [];
  this.orgValueFields = [];
  this.allValues = [];
  this.keysList = this.objConfig.multiDimensionalKeyList.split(",");
  this.labelsList = this.objConfig.multiDimensionalLabelList.split(",");
  if(Empty(this.labelsList))
    this.labelsList = this.keysList.slice();
  this.keyStart = this.objConfig.multiDimensionalKeyStart;
  if(Empty(this.keyStart))
    this.keyStart = this.keysList[0];
  this.keyIndex = this.keysList.indexOf(this.keyStart);
  this.mapCharts = [];

  var alldata = []; 
  for (var i = 0; i < this.keysList.length; i++) {
    this.allDataIndex[this.keysList[i]] = this.GetData(this.keysList[i]);
    alldata = alldata.concat(this.allDataIndex[this.keysList[i]]);
  }
  this.mchartModel.appliedKey = this.chartId + "MULTI_" +this.mchartModel.type + "_model";
  this.mchartModel._mdim = this;
  this.mchartModel.InitChart({
    ztChart: this._ZtChart,
    chartConfig: this.chartConfig,
    objConfig: this.objConfig,
    propertyName: this.propertyName,
    dataset: alldata,
    parent: this.parent, 
    fncObj: this.functionObj,
    lnkObj: this.linkObj,
    chartId: this.chartId + "MULTI_" + this.mchartModel.type,
    container: null,
    noCalc: true,
    addData : this.additionalDataset ? this.additionalDataset.slice() : null,
    addPName : this.additionalPropertyName ? this.additionalPropertyName.slice() : null
  });

  if( Empty(this.dataOrder) || (this.mchartModel._GetDefaultDataOrder() == this.dataOrder) ) {
    this.orgSeriesList = this.mchartModel.orgSeriesList.slice();
    this.legendList = this.mchartModel.legendList.slice();
    this.rowLegendList = this.mchartModel.rowLegendList.slice();
    this.drawingCategories = this.mchartModel.drawingCategories.slice();
    this.drawingSeries = this.mchartModel.drawingSeries.slice();
  }
  else {
    this.orgSeriesList = this.mchartModel.orgSeriesList.slice();
    this.legendList = this.mchartModel.rowLegendList.slice();
    this.rowLegendList = this.mchartModel.legendList.slice();
    this.drawingCategories = this.mchartModel.drawingCategories.slice();
    this.drawingSeries = this.mchartModel.drawingSeries.slice();
  }
  this._UpdateDrawingList();
  this.mchartModel._SetScales();
  this.scaleX = this.mchartModel.scaleX;
}

ZtMultiDimCursorChart.prototype.GetLegendIcon = function () {
  return this.mchartModel.GetLegendIcon();
}

ZtMultiDimCursorChart.prototype._GetLegendIconHexCode = function () {
  return this.mchartModel._GetLegendIconHexCode();
}

ZtMultiDimCursorChart.prototype._DrawChartElements = function () {
  this.beginCursorIdx;
  this.runningMultiDim = false;
  this.userChange = false;
  this.confObj = {};
  this.confObj.x = this.margin.left;
  this.confObj.y = this.margin.top;
  this.confObj.width = this.chartWidth;
  this.confObj.height = this.chartHeight;

  if (this.defSettings.multiDimensional.cursorType == "none") {
    var parentGroup = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_svgGroup")
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
    positions = this.GetRendererSubdivisionsSizes(this.keysList.length, null, null, this.defSettings.multiDimensional.subdivision, this.defSettings.multiDimensional.subdivisionHeight), // eslint-disable-line max-len
    id, i,
    confObj;
    for (i = 0; i < positions.length; i++) {
      id = this.chartId + i;
      confObj = positions[i];
      confObj.text = this.labelsList[i];
      if (this.multiDimKeepSameScale) {
        this.mchartModel._SetLists();
        this.mchartModel._SetScales();
        if (!this.mapCharts[this.keysList[i]])
          this._CreateKeyChart(this.allDataIndex[this.keysList[i]], this.keysList[i], id, parentGroup, confObj);
        this.mapCharts[this.keysList[i]].defSettings.chartTitle.textFont = this.mapCharts[this.keysList[i]].defSettings./*multiDimensional.cursorFont;*/globalFont
        this.mapCharts[this.keysList[i]].defSettings.chartTitle.useGlobalFont = false;
        this.mapCharts[this.keysList[i]].defSettings.chartTitle.useLegendFont = false;
        this.mapCharts[this.keysList[i]]._MapWithAnother(this.mchartModel);
      }
      else {
        if (!this.mapCharts[this.keysList[i]])
          this._CreateKeyChart(this.allDataIndex[this.keysList[i]], this.keysList[i], id, parentGroup, confObj);
        this.mapCharts[this.keysList[i]].defSettings.chartTitle.textFont = this.mapCharts[this.keysList[i]].defSettings./*multiDimensional.cursorFont;*/globalFont
        this.mapCharts[this.keysList[i]].defSettings.chartTitle.useGlobalFont = false;
        this.mapCharts[this.keysList[i]].defSettings.chartTitle.useLegendFont = false;
        this.mapCharts[this.keysList[i]].seriesList = this.mchartModel.seriesList;
      }
      this._DrawKeyChart(this.mapCharts[this.keysList[i]], parentGroup, confObj);

      

    }
    return;
  }

  this._DrawCursor();
 
  if (this.multiDimKeepSameScale) {
    for (i = 0; i < this.keysList.length; i++) {
      if (!this.mapCharts[this.keysList[i]])
        this._CreateKeyChart(this.allDataIndex[this.keysList[i]], this.keysList[i], this.chartId + "MULTI_" + this.mchartModel.type, this.renderer, this.confObj);
      this.mapCharts[this.keysList[i]]._MapWithAnother(this.mchartModel);
      this.mapCharts[this.keysList[i]].SetAggregateData();
      this.mapCharts[this.keysList[i]]._CheckEmptyValues();
      if (this.mapCharts[this.keysList[i]].applyCalculationAfter) {
        this.mapCharts[this.keysList[i]]._SetCalculationDataset();
        this.mapCharts[this.keysList[i]]._AfterCalculation(this.mchartModel);
      }
      this.mapCharts[this.keysList[i]]._MapAllValues(this.mchartModel);
    }
    this._DrawKeyChart(this.mapCharts[this.keysList[this.keyIndex]],this.renderer, this.confObj);
  }
  else {
    if(!this.mapCharts[this.keysList[this.keyIndex]])
      this._CreateKeyChart(this.allDataIndex[this.keysList[this.keyIndex]], this.keysList[this.keyIndex], this.chartId + "MULTI_" + this.mchartModel.type, this.renderer, this.confObj);
    this._DrawKeyChart(this.mapCharts[this.keysList[this.keyIndex]], this.renderer, this.confObj);
  }

  if (this.objConfig.multiDimensionalStartAnimation)
    this._PlayCursor();
}

ZtMultiDimCursorChart.prototype.ShowMaskDivAnimation = function () {}

ZtMultiDimCursorChart.prototype.HideMaskDivAnimation = function () {}

ZtMultiDimCursorChart.prototype.SetIsStaticChart = function (value) {
  for (var i=0; i<this.keysList.length; i++) {
    if (this.mapCharts[this.keysList[i]])
      this.mapCharts[this.keysList[i]].SetIsStaticChart(value);
  }
}

ZtMultiDimCursorChart.prototype._InterruptAnimateChartElements = function () {
  for (var i=0; i<this.keysList.length; i++) {
    if (this.mapCharts[this.keysList[i]])
      this.mapCharts[this.keysList[i]]._InterruptAnimateChartElements();
  }
}

ZtMultiDimCursorChart.prototype._CreateKeyChart = function (dataset, key, id, renderer, confObj) {
  var mchart = this.GetChart(this.chartConfig.graphSettings.chartType, true);
  this.mapCharts[key] = mchart;
  var objConfig = JSON.stringify(this.objConfig),
  myObjConfig = JSON.parse(objConfig),
  chartConfig = JSON.stringify(this.chartConfig),
  myChartConfig = JSON.parse(chartConfig);
  mchart.InitChart({
    ztChart : this._ZtChart,
    chartConfig : myChartConfig,
    objConfig : myObjConfig,
    propertyName : this.propertyName,
    dataset : dataset,
    parent : this.parent,
    fncObj : this.functionObj,
    lnkObj : this.linkObj,
    chartId : id,
    container : renderer,
    noCalc : true,
    addData : this.additionalDataset ? this.additionalDataset.slice() : null,
    addPName : this.additionalPropertyName ? this.additionalPropertyName.slice() : null
  });
  mchart.appliedKey = key;
  /** overw **/
  mchart.defSettings.globals.width = confObj.width;
  mchart.defSettings.globals.height = confObj.height;
  mchart.chartSubtitle = "";
  mchart.chartTitle = "";
  /** fine overw**/
  if (mchart.type != "CONTAINER")
    mchart.SetDataDraw();
}

ZtMultiDimCursorChart.prototype._DrawKeyChart = function (mchart, renderer, confObj) {
  if (!Empty(d3.select("#" + mchart.chartId + "d3ChartPlot").node()))
    d3.select("#" + mchart.chartId + "d3ChartPlot").remove();
  mchart.ResetItems();

  mchart.legendList = [];
  mchart.chartSubtitle = "";
  mchart.chartTitle = confObj.text ? confObj.text : "";
  mchart.defSettings.chartTitle.alignment = mchart.defSettings.multiDimensional.alignment;
  mchart.defSettings.chartTitle.position = mchart.defSettings.multiDimensional.position;
  mchart.defSettings.chartTitle.useGlobalFont = mchart.defSettings.multiDimensional.useGlobalFont;

  mchart.SetChartDraw();
  if (mchart.chartLegends.series)
    mchart.chartLegends.series.position = "hide";
  if (mchart.chartLegends.range)
    mchart.chartLegends.range.position = "hide";

  mchart._DrawMultiSVGPlot(mchart.chartId, renderer, confObj.x, confObj.y, confObj.width, confObj.height, true);

  if (mchart.type == "CONTAINER")
    mchart.DrawCallback();
  else {
    if (this.multiDimKeepSameScale)
      mchart._MapAllValues(this.mchartModel); // messo x sicurezza
    if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none")
      mchart.ShowMaskDivAnimation(confObj);
    else
      mchart.ShowMaskDivAnimation();

    mchart._DrawChartPlotTitles(mchart.svg)
    mchart._DrawChartPlotElements();
    mchart._DrawChartElements();
    mchart.AfterDraw();
  }

  if (this.selectedObjects)
    mchart.ApplySelectionsObjects(this.selectedObjects);
}

ZtMultiDimCursorChart.prototype._PlayCursor = function () {
  if (!this.defSettings.multiDimensional.multiDim)
    return;
  if (this.runningMultiDim){
    this._StopCursor();
    return;
  }
  this.runningMultiDim = true;
  this.defSettings.multiDimensional.autoChange = true;
  this.userChange = false;
  var _this = this;

  function svgCycle(idx){
    var delayT = 500;
    if (Empty(idx))
      idx = 0;
    _this.beginCursorIdx = idx;
    _this.svg.transition().duration(0);
    var dtransition = _this.defSettings.animation.duration;
    if (dtransition < 500)
      dtransition = 500;

    _this.svg.transition()
      .delay(delayT + (dtransition / 2)/* + (getCategoryType(_this.type)=='pareto'?_this.defSettings.animation.duration:0)*/)
      .duration(delayT + (_this.defSettings.animation.duration + (/*getCategoryType(_this.type)=='pareto'?dtransition:*/dtransition / 2)) * (_this.keysList.length - idx))
      .ease(d3.easeLinear)
      .tween("cursor", function () {
        return function(t) {
          if (!_this.userChange)
            _this._ChangeDataset(Math.floor((t) * _this.keysList.length) + _this.beginCursorIdx);
          };
      })
      .on("end", function () {
        if (!_this.defSettings.multiDimensional.autoChange)
          _this._StopCursor();
        else if (!_this.userChange)
          svgCycle();
        else
          _this._StopCursor();
      })
      .on("start", function () {
        d3.select("#" + _this.chartId + "playMultiDimensional")
          .text(function () {
            return _this.GetMultiDimensionalIcon("pause");
          });
        var c = document.getElementById(_this.chartId+"menuBar");
        if (c)
          c.style.display = 'block';
      });
  }

  svgCycle(this.keyIndex);
}

ZtMultiDimCursorChart.prototype._StopCursor = function () {
  var _this = this;
  this.userChange = true;
  this.svg.transition().duration(0);
  d3.select("#"+_this.chartId+"playMultiDimensional")
  .text(function () {
    return _this.GetMultiDimensionalIcon("play");
  });
  this.runningMultiDim = false;
  var c = document.getElementById(this.chartId+"chartDownloadMenu");
  if(c) c.style.display='block';
  c = document.getElementById(this.chartId+"chartContextMenu");
  if(c) c.style.display='block';
}

ZtMultiDimCursorChart.prototype._ChangeDataset = function (idx) {
  var t_opacity=0.5;
  var t_line0="1px";
  var t_line1="2px";
  var i, j, itemObject, ticks;

  var appFont = this.defSettings.globalFont//appliedFont(this.defSettings, this.defSettings.multiDimensional, this.defSettings.multiDimensional.cursorFont);
  if (idx >= this.keysList.length || idx == this.keyIndex)
    return;

  if (this.mapCharts[this.keysList[this.keyIndex]]) {
    this.mapCharts[this.keysList[this.keyIndex]].ResetAllTimeouts();
    this.mapCharts[this.keysList[this.keyIndex]]._InterruptAnimateChartElements();
    var itemObjects = this.mapCharts[this.keysList[this.keyIndex]].GetSelectedItems();
    var nitemObjects = this.mapCharts[this.keysList[this.keyIndex]].GetNotSelectedItems();
    if (!this.selectedObjects)
      this.selectedObjects = itemObjects;
    else {
      for (i = 0; i < nitemObjects.length; i++) {
        for(j = this.selectedObjects.length - 1; j >= 0; j--) {
          itemObject = this.selectedObjects[j];
          if (this.mapCharts[this.keysList[this.keyIndex]]._CheckIdentityItem(itemObject, nitemObjects[i]))
            this.selectedObjects.splice(j, 1);
        }
      }
      for (i = 0; i < itemObjects.length; i++) {
        var find = false;
        for (j = this.selectedObjects.length - 1; !find && j >= 0; j--) {
          itemObject = this.selectedObjects[j];
          if (this.mapCharts[this.keysList[this.keyIndex]]._CheckIdentityItem(itemObject, itemObjects[i]))
            find = true;
        }
        if (!find)
          this.selectedObjects.push(itemObjects[i]);
      }
    }
  }

  if (this.keyIndex >=0) {
    if (this.defSettings.multiDimensional.cursorType == 'axis') {
      d3.select("#"+this.chartId + "cursorAxisGroup").selectAll("text")._groups[0][this.keyIndex].style.fontSize = appFont.size+"px";
      if(appFont.style=="B" || appFont.style=="BI")
        d3.select("#"+this.chartId + "cursorAxisGroup").selectAll("text")._groups[0][this.keyIndex].style.fontWeight = "bold";
      else
        d3.select("#"+this.chartId + "cursorAxisGroup").selectAll("text")._groups[0][this.keyIndex].style.fontWeight = "normal";
    }
    else if (this.defSettings.multiDimensional.cursorType == 'value') {
      ticks = d3.select("#" + this.chartId + "cursorAxisGroup").selectAll("line")._groups[0];
      ticks[this.keyIndex].style.opacity = t_opacity;
      ticks[this.keyIndex].style.strokeWidth = t_line0;
    }
  }

  var lastChart = this.mapCharts[this.keysList[this.keyIndex]];
  this.keyIndex = idx;

  if (this.defSettings.multiDimensional.cursorType == 'axis') {
    d3.select("#"+this.chartId + "cursorAxisGroup").selectAll("text")._groups[0][this.keyIndex].style.fontSize = appFont.size+"pt";
    d3.select("#"+this.chartId + "cursorAxisGroup").selectAll("text")._groups[0][this.keyIndex].style.fontWeight = "bold";
  }
  else if (this.defSettings.multiDimensional.cursorType == 'value') {
    ticks = d3.select("#"+this.chartId + "cursorAxisGroup").selectAll("line")._groups[0];
    ticks[this.keyIndex].style.opacity="1";
    ticks[this.keyIndex].style.strokeWidth=t_line1;
    d3.select("#"+this.chartId+"cursorLabel").text( this.labelsList[this.keyIndex]);
  }
  else if (this.defSettings.multiDimensional.cursorType == 'combo') {
    if(!Empty(document.getElementById(this.chartId+'comboCursor')))
      document.getElementById(this.chartId+'comboCursor').selectedIndex = this.keyIndex;
  }

  if (this.multiDimKeepSameScale) {
    if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none")
      this.mapCharts[this.keysList[this.keyIndex]].ShowMaskDivAnimation(this.confObj);
    else
      this.mapCharts[this.keysList[this.keyIndex]].ShowMaskDivAnimation();

    this.mapCharts[this.keysList[this.keyIndex]].chartLegends = {};
    this.mapCharts[this.keysList[this.keyIndex]]._SetScales(this._ZtChart.datetimePict);
    this.mapCharts[this.keysList[this.keyIndex]].SetMargins(this._ZtChart.datetimePict);
    this.mapCharts[this.keysList[this.keyIndex]].svg = lastChart.svg;
    this.mapCharts[this.keysList[this.keyIndex]].renderer = lastChart.renderer;
    this.mapCharts[this.keysList[this.keyIndex]].colorSet = lastChart.colorSet;
    this.mapCharts[this.keysList[this.keyIndex]]._ApplyRedrawAnimationEffect(lastChart);
    this.mapCharts[this.keysList[this.keyIndex]].AfterDrawRenderer();
  }
  else {
    if (!this.mapCharts[this.keysList[this.keyIndex]]) {
      this._CreateKeyChart(this.allDataIndex[this.keysList[this.keyIndex]], this.keysList[this.keyIndex], this.chartId + "MULTI_" + this.mchartModel.type, this.renderer, this.confObj);
      this._DrawKeyChart(this.mapCharts[this.keysList[this.keyIndex]], this.renderer, this.confObj);
    }
    else {
      this._DrawKeyChart(this.mapCharts[this.keysList[this.keyIndex]], this.renderer, this.confObj);
    }
    this.DrawZoomCursor();
  }
  if (window[this.chartId + "onChangeMultiDimensional"])
    window[this.chartId + "onChangeMultiDimensional"](this.keysList[this.keyIndex]);
  else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent) {
    this._ZtChart.parentCtrl.dispatchEvent("onChangeMultiDimensional", d3.event, this.keysList[this.keyIndex]);
  }
}

ZtMultiDimCursorChart.prototype._DrawCursor = function () {
  var t_opacity=0.5;
  var t_line1="2px";
  var t_height=5;
  var _this = this;
  var y, alignment, divScale, axis, cursor;
  if (!Empty(this.svg.select("#" + this.chartId + "cursorAxisGroup").node()))
    return;
  if (this.labelsList.length == 0)
    return;
  var appFont = this.defSettings.globalFont,//appliedFont(this.defSettings, this.defSettings.multiDimensional, this.defSettings.multiDimensional.cursorFont),
  fontSize = parseInt(appFont.size);
  if (!Empty(d3.select(this.chartId + 'comboCursor').node()))
    d3.select(this.chartId + 'comboCursor').remove();

  if (this.defSettings.multiDimensional.cursorType == "axis") {
    y = getCursorPosition(this.defSettings.multiDimensional.position);
    var curScale = d3.scaleBand()
                .domain(this.keysList)
                .range([0, this.chartWidth]);
    divScale = d3.scaleLinear()
                .domain([0, this.keysList.length])
                .range([0, this.chartWidth])
                .clamp(true);
    axis = d3.axisBottom(curScale);
    cursor = this.svg.append("g")
          .attr("id", this.chartId + "cursorAxisGroup")
          .attr("transform", "translate(" + this.margin.left + "," + y + ")")
          .call(axis)
          .on("mousemove", function () {
            _this.svg.transition().duration(0);
            var idx=parseInt(divScale.invert(d3.mouse(this)[0]));
            _this.userChange=true;
            _this._ChangeDataset(idx);
          })
          .style("cursor", "pointer");

    cursor.select('path').attr('class', "cursorAx");

    this.SetAxisColor("cursor", "y2", 3);
    this.SetAxisFont("cursor");

    cursor.selectAll("text")
      .text(function(d, i) {
        return _this.labelsList[i];
      })
      .style("font-weight", function(d, i) {
        if (i == _this.keyIndex)
          return "bold";
      })
      .style("font-size", function(d, i) {
        if (i == _this.keyIndex)
          return fontSize + "pt";
      });
  }
  else if (this.defSettings.multiDimensional.cursorType == "combo"){
    y = getCursorPosition(this.defSettings.multiDimensional.position);
    alignment = this.defSettings.multiDimensional.alignment;
    var parY = this.parent.offsetTop || 0,
    parX = this.parent.offsetLeft || 0;
    var combo;
    if (Empty(this._ZtChart._vpvMenu) || !this._ZtChart._vpvMenu) {
      combo = d3.select("#" + this.chartId + "divchartcontainer")
      .append("select")
      .attr('id', this.chartId + 'comboCursor')
      .attr("class", "multidimcursor")
      .style("position", "absolute")
      .on("change", function () {
        _this.svg.transition().duration(0);
        this.userChange = true;
        if (this.selectedIndex != _this.keyIndex)
          _this._ChangeDataset(this.selectedIndex);
      });
    }
    else {
      var div = d3.select("#" + this.chartId + "divchartcontainer")
      .insert("div", "svg")
      combo = div.append("select")
      .attr('id', this.chartId + 'comboCursor')
      .attr("class", "multidimcursor")
      .style("position", "relative")
      .on("change", function () {
        _this.svg.transition().duration(0);
        this.userChange = true;
        if (this.selectedIndex != _this.keyIndex)
          _this._ChangeDataset(this.selectedIndex);
      });
    }
    

    for (var i = 0; i < this.labelsList.length; i++) {
      var option = combo.append("option")
                    .attr("value", this.keysList[i])
                    .text(this.labelsList[i]);
      if (this.keyIndex == i)
        option.attr("selected", true);
    }
    setFont(combo, appFont, this);
    if (Empty(this._ZtChart._vpvMenu) || !this._ZtChart._vpvMenu) {
      combo.style("color", appFont.color)
      .style("top", (y + parY) +'px')
      .style("left", (this.margin.left + parX + (alignment == "right" ? (this.chartWidth - combo.node().offsetWidth) : 0)) + 'px')
      .style("background-color", "transparent");
    }
    else {
      combo.style("color", appFont.color)
      .style("top", 5 +'px')
      .style("left", (this.margin.left + 5 + (alignment == "right" ? (this.chartWidth - combo.node().offsetWidth) : 0)) + 'px')
      .style("background-color", "transparent");
    }
  }
  else if(this.defSettings.multiDimensional.cursorType == "value") {
    y = getCursorPosition(this.defSettings.multiDimensional.position);
    alignment=this.defSettings.multiDimensional.alignment;
    var label = this.svg.append("text")
          .attr("id", this.chartId + "cursorLabel")
          .attr("class", "multidimcursor")
          .attr("text-anchor", alignment == 'right' ? "end" : 'start')
          .attr("y", y+appFont.size/2)
          .attr("x", this.margin.left + (alignment=='right'?this.chartWidth:5))
          .text(function(){
            var l = 0;
            for(var i=1; i<_this.labelsList.length; i++){
              if(_this.labelsList[i]<_this.labelsList[l])
                l=i;
            }
            return _this.labelsList[l];
          });

    setFont(label, appFont, this);
    var box = label.node().getBBox();
    label.text(this.labelsList[this.keyIndex]);
    function mousemove() {
      _this.svg.transition().duration(0);
      var idx = parseInt(divScale.invert(d3.mouse(this)[0]));
      _this.userChange=true;
      _this._ChangeDataset(idx)
    }
    this.svg.append("rect")
            .attr("class", "multidimcursor")
            .style("fill", "none")
            .style("pointer-events", "all")
            .style("cursor", "ew-resize")
            .attr("x", box.x)
            .attr("y", box.y)
            .attr("width", box.width)
            .attr("height", box.height)
            .attr("stroke",appFont.color)
            .attr("stroke-width","0px")
            .attr("stroke-opacity",t_opacity)
            .on("mousemove", mousemove)
            .on("touchmove", mousemove);

    divScale = d3.scaleLinear()
      .domain([0, _this.labelsList.length - 1])
      .range([box.x+10, box.x + box.width-10])
      .clamp(true);

    var ticksArrayValue=[];
    for(var k=0; k<_this.labelsList.length; k++)
      ticksArrayValue.push(k);

    axis = d3.axisTop(divScale).tickValues(ticksArrayValue);
    cursor = this.svg.append("g")
          .attr("id", this.chartId + "cursorAxisGroup")
          .attr("class", "multidimcursor")
          .attr("transform", "translate(" + 0 + "," + (y + appFont.size/2+t_height) +")")
          .call(axis);

    cursor.select('path').attr('id', this.chartId + "cursorAx");
    this.SetAxisColor("cursor", "y2", 3);
    cursor.select("path").remove();
    cursor.selectAll("text").remove();

    var ticks = cursor.selectAll("line")._groups[0];
    ticks[this.keyIndex].style.strokeWidth = t_line1;
  }

  function getCursorPosition(position) {
    var y = _this.marginOffsetY,
    ch = 0;
    for (var i = 0; i < _this.genLabels[position].length; i++) {
      var toAdd = true;
      switch (_this.genLabels[position][i].type) {
        case "title":
          toAdd = !Empty(_this.chartTitle);
          break;
        case "subtitle":
          toAdd = !Empty(_this.chartSubtitle);
          break;
        case "legend_series":
          toAdd = _this.chartLegends.series && !_this.chartLegends.series.hide;
          break;
        case "legend_range":
          toAdd = _this.chartLegends.range && !_this.chartLegends.range.hide;
          break;
        default :
          ch = _this.genLabels[position][i].height;
          toAdd = false;
          break;
      }
      if (toAdd)
        y += _this.genLabels[position][i].height;
    }

    if (position == 'top')
      return y;
    y = _this.defSettings.globals.height - y - ch;
    return y;
  }
}

ZtMultiDimCursorChart.prototype._GetChartMarginsObject = function (chartId, settings/*, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  //cursore multidimensional
  if (settings.multiDimensional && settings.multiDimensional.multiDim && (settings.multiDimensional.cursorType != "none" && settings.multiDimensional.cursorType != "nodraw")){
    var appliedfont = settings.globalFont//appliedFont(settings, settings.multiDimensional, settings.multiDimensional.cursorFont);
    var myM = getGenericLabelConf(appliedfont);
    myM.text = getMaxWordLength(this.labelsList);
    myM.textorientation = 90;
    myM.offset = 10;
    myM.type = 'cursor';
    ret[settings.multiDimensional.position].push(myM);
  }
  return ret;
}

ZtMultiDimCursorChart.prototype._AnimateChartElements = function () {}

ZtMultiDimCursorChart.prototype._ApplyMouseOver = function () {}

ZtMultiDimCursorChart.prototype._SetElementsRangeColor = function (/*isFnc*/) {}

ZtMultiDimCursorChart.prototype._DrawValueLabels = function () {}

ZtMultiDimCursorChart.prototype._ApplyLegendMouseOver = function(item) {
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    this.mapCharts[key]._ApplyLegendMouseOver(item);
  }
  else {
    for(var i=0; i<this.keysList.length; i++)
      this.mapCharts[this.keysList[i]]._ApplyLegendMouseOver(item);
  }
}

ZtMultiDimCursorChart.prototype._ApplyLegendMouseOut = function(item) {
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    this.mapCharts[key]._ApplyLegendMouseOut(item);
  }
  else {
    for(var i=0; i<this.keysList.length; i++)
      this.mapCharts[this.keysList[i]]._ApplyLegendMouseOut(item);
  }
}

ZtMultiDimCursorChart.prototype._ApplyLegendClick = function(item) {
  var i;
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    this.mapCharts[key]._ApplyLegendClick(item);
  }
  else {
    for(i=0; i<this.keysList.length; i++)
      this.mapCharts[this.keysList[i]]._ApplyLegendClick(item);
  }
  var index = parseInt(item.getAttribute("data-index"));
  var txt = parseInt(item.getAttribute("data-text"));
  var ret = this._GetItemsByLegendIndex(index);
  for(i=0; i<ret.lItems.length; i++)
    ret.lItems[i].isSelected = !ret.allSelected;
  var legendObj = {
    //current: item.textContent,
    text: txt,
    idx: index,
    mouse: d3.mouse(item),
    isSelected : !ret.allSelected
  };
  this._ApplyLegendNoSelections();

  if (window[this.chartId + "onLegendClick"])
    window[this._ZtChart.chartId + "onLegendClick"](legendObj);
  else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
    this._ZtChart.parentCtrl.dispatchEvent('onLegendClick', d3.mouse(item), legendObj);
}

ZtMultiDimCursorChart.prototype._ApplyLegendNoSelections = function() {
  var lgitems = this.svg.selectAll(".legendItem")._groups[0];
  var sl = [], nl = [];
  var myItems = this.GetSelectedItems();
  var nlfilter;
  for(var k=0; k<lgitems.length; k++) {
    var lg = lgitems[k];
    var slfilter = sl.filter(function (item) {
      return item.itm === lg;
    });
    if(slfilter.length == 0) {
      var found = false;
      for(var j=0; !found && j<myItems.length; j++) {
        var mi = myItems[j];
        if(mi.idx == parseInt(lg.getAttribute("data-index"))) {
          found = true;
        }
      }
      if(found) {
        sl.push({itm: lg});
        nlfilter = nl.filter(function (item) {
        return item.itm !== lg;
        });
        nl = nlfilter;
      }
      else {
        nlfilter = nl.filter(function (item) {
          return item.itm === lg;
        });
        if(nlfilter.length == 0)
          nl.push({itm: lg});
      }
    }
  }
  if(sl.length > 0) {
    StdChart.prototype._ApplyItemSVGSelectEffect.call(this, sl, true);
    StdChart.prototype._ApplyItemSVGSelectEffect.call(this, nl, false);
  }
  else {
    StdChart.prototype._ApplyItemSVGSelectEffect.call(this, nl, true);
  }
}

ZtMultiDimCursorChart.prototype._ApplyLegendExclude = function(item, upd) {
  var exclude = CharToBool(d3.select(item).attr("data-check") + ""),
  index = parseInt(d3.select(item).attr("data-index")),
  text = d3.select(item).attr("data-text");
  this._UpdateLegendExcludeItem(item);
  this.mchartModel._ApplyLegendExcludeNoItem(exclude, index, text, false);
  this.drawingCategories = this.mchartModel.drawingCategories.slice();
  this.drawingSeries = this.mchartModel.drawingSeries.slice();
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    this.mapCharts[key]._ApplyLegendExcludeNoItem(exclude, index, text, upd);
    for(var i=0; i<this.keysList.length; i++) {
      if (i != this.keyIndex) {
        if (this.mapCharts[this.keysList[i]]) {
          this.mapCharts[this.keysList[i]]._ApplyLegendExcludeNoItem(exclude, index, text, false);
        }
        else {
          this._CreateKeyChart(this.allDataIndex[this.keysList[i]], this.keysList[i], this.chartId + "MULTI_" + this.mchartModel.type, this.renderer, this.confObj);
          this.mapCharts[this.keysList[i]]._ApplyLegendExcludeNoItem(exclude, index, text, false);
        }
      }
    }
  }
  else {
    for(i=0; i<this.keysList.length; i++)
      this.mapCharts[this.keysList[i]]._ApplyLegendExcludeNoItem(exclude, index, text, upd);
  }

  var legendObj = {
    //current: item.textContent,
    text: text,
    idx: index,
    exclude: exclude
  };
  if (window[this.chartId + "onExclusionFilter"])
    window[this.chartId + "onExclusionFilter"](legendObj);
  else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
    this._ZtChart.parentCtrl.dispatchEvent('onExclusionFilter', null, legendObj);
}

ZtMultiDimCursorChart.prototype.GetSelectedItems = function () {
  var ret = [];
  for(var i=0; i<this.keysList.length; i++) {
    if(this.mapCharts[this.keysList[i]]) {
      ret = ret.concat(this.mapCharts[this.keysList[i]].GetSelectedItems());
    }
  }
  return ret;
}

ZtMultiDimCursorChart.prototype.GetNotSelectedItems = function () {
  var ret = [];
  for(var i=0; i<this.keysList.length; i++) {
    if(this.mapCharts[this.keysList[i]]) {
      ret = ret.concat(this.mapCharts[this.keysList[i]].GetNotSelectedItems());
    }
  }
  return ret;
}

ZtMultiDimCursorChart.prototype._SupportChangeOrder = function () {
  return this.mchartModel._SupportChangeOrder();
}

ZtMultiDimCursorChart.prototype.ChangeDataOrder = function () {
  this.mchartModel.ChangeDataOrder();
  this.orgSeriesList = this.mchartModel.orgSeriesList.slice();
  this.legendList = this.mchartModel.legendList.slice();
  this.rowLegendList = this.mchartModel.rowLegendList.slice();
  this.drawingCategories = this.mchartModel.drawingCategories.slice();
  this.drawingSeries = this.mchartModel.drawingSeries.slice();
  for(var i=0; i<this.keysList.length; i++) {
    if (this.mapCharts[this.keysList[i]]) {
      this.mapCharts[this.keysList[i]].ChangeDataOrder();
    }
    else {
      this._CreateKeyChart(this.allDataIndex[this.keysList[i]], this.keysList[i], this.chartId + "MULTI_" + this.mchartModel.type, this.renderer, this.confObj);
      this.mapCharts[this.keysList[i]].ChangeDataOrder();
    }
  }
}

ZtMultiDimCursorChart.prototype.ApplySelectionsObjects = function (itemObjects) { 
  for(var i=0; i<itemObjects.length; i++) {
    if(itemObjects[i].multidimCurrentKey) {
      if(this.mapCharts[itemObjects[i].multidimCurrentKey]) {
        this.mapCharts[itemObjects[i].multidimCurrentKey].ApplySelectionsObjects([itemObjects[i]]);
      }
    }
  }
}

ZtMultiDimCursorChart.prototype.ApplyFocusKey = function () {
  if(this.focusKey && this.applyFocusKey) {
    if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
      var key = this.keysList[this.keyIndex];
      this.mapCharts[key].ApplyFocusKey();
    }
    else {
      for(var i=0; i<this.keysList.length; i++) {
        if (this.mapCharts[this.keysList[i]])
          this.mapCharts[this.keysList[i]].ApplyFocusKey();
      }
    }
  }
  this.applyFocusKey = false
}

ZtMultiDimCursorChart.prototype.RemoveAllSelections = function () {
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    this.mapCharts[key].RemoveAllSelections();
  }
  else {
    for(var i=0; i<this.keysList.length; i++) {
      if (this.mapCharts[this.keysList[i]])
        this.mapCharts[this.keysList[i]].RemoveAllSelections();
    }
  }
}

ZtMultiDimCursorChart.prototype.IsMultiDim = function() {
  return true;
}

ZtMultiDimCursorChart.prototype.SelectAllValues = function (type) {
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    this.mapCharts[key].SelectAllValues(type);
  }
  else {
    for(var i=0; i<this.keysList.length; i++) {
      if (this.mapCharts[this.keysList[i]])
        this.mapCharts[this.keysList[i]].SelectAllValues(type);
    }
  }
}

ZtMultiDimCursorChart.prototype._GetExportData = function(type,optReturn,stringData,withHeader) {
  var refString = "";
  var newLineWin="\n";
  var tmp = [];
  var i;
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    refString = this.mapCharts[key]._GetExportData(type,optReturn,true,withHeader);
  }
  else {
    if(type == 'csv') {
      refString = this.mapCharts[this.keysList[0]]._GetExportData(type,optReturn,true,withHeader);
      for(i=1; i<this.keysList.length; i++) {
        tmp[i-1] = this.mapCharts[this.keysList[i]]._GetExportData(type,optReturn,true,false);
      }
      for(i=0; i<tmp.length; i++) {
        if(tmp[i].length > 0) {
          var arr = tmp[i].split(newLineWin);
          for(var k=0; k<arr.length; k++)
            refString = refString + newLineWin + arr[k];
        }
      }
    }
    else if(type == 'xml') {
      for(i=0; i<this.keysList.length; i++) {
        tmp[i] = this.mapCharts[this.keysList[i]]._GetExportData(type,optReturn,true,false);
      }
      refString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+newLineWin;
      refString = refString + "<CHARTEXPORT>";
      for(i=0; i<tmp.length; i++) {
        if(tmp[i].length > 0)
          refString = refString + newLineWin + tmp[i];
      }
      refString = refString + newLineWin + "</CHARTEXPORT>"
    }
  }
  if(stringData)
    return refString;
  this.GetDownload(type,refString);
}

ZtMultiDimCursorChart.prototype._HasOthersData = function() {
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    return this.mapCharts[key]._HasOthersData();
  }
  else {
    var ret = false;
    for(var i=0; !ret && i<this.keysList.length; i++) {
      ret = this.mapCharts[this.keysList[i]]._HasOthersData();
    }
    return ret;
  }
}

ZtMultiDimCursorChart.prototype._GetOthersData = function(vfields) {
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    return this.mapCharts[key]._GetOthersData(vfields);
  }
  else {
    var ret = [];
    for(var i=0; !ret && i<this.keysList.length; i++) {
      ret = ret.concat(this.mapCharts[this.keysList[i]]._GetOthersData(vfields)); // da provare
    }
    return ret;
  }
}

ZtMultiDimCursorChart.prototype.ShowAggregateDetail = function() {
  if (this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim && this.defSettings.multiDimensional.cursorType != "none"){
    var key = this.keysList[this.keyIndex];
    return this.mapCharts[key].ShowAggregateDetail();
  }
  else {
    for(var i=0; i<this.keysList.length; i++) {
      this.mapCharts[this.keysList[i]].ShowAggregateDetail( i==0 ? true : false );
    }
  }
}

ZtMultiDimCursorChart.prototype._GetDrawingList = function () {
  if (this.mchartModel.dataOrder == "column")
    return this.mchartModel.drawingSeries;
  return this.mchartModel.drawingCategories;
}

ZtMultiDimCursorChart.prototype._GetOppositeDrawingList = function () {
  if (this.mchartModel.dataOrder == "column")
    return this.mchartModel.drawingCategories;
  return this.mchartModel.drawingSeries;
}

ZtMultiDimCursorChart.prototype._GetAxisDrawingList = function () {
  if (this.mchartModel.dataOrder == "row")
    return this.mchartModel.drawingCategories;
  var sf = JSON.parse(this.mchartModel.columnOrderData.orgSeriesList),
  vf = JSON.parse(this.mchartModel.columnOrderData.valueFields),
  ds = this.mchartModel.drawingSeries;
  return sf.filter( function (s, idx) { return ds.indexOf(vf[idx]) >= 0 } );
}

ZtMultiDimCursorChart.prototype._GetOppositeAxisDrawingList = function () {
  if (this.mchartModel.dataOrder == "column")
    return this.mchartModel.drawingCategories;
  var sf = JSON.parse(this.mchartModel.columnOrderData.orgSeriesList),
  vf = JSON.parse(this.mchartModel.columnOrderData.valueFields),
  ds = this.mchartModel.drawingSeries;
  return sf.filter( function (s, idx) { return ds.indexOf(vf[idx]) >= 0 } );
}

ZtMultiDimCursorChart.prototype._GetReferredList = function () {
  return this.mchartModel._GetReferredList();
}

ZtMultiDimCursorChart.prototype._IsNotExcluded = function (index) {
  if (this._ZtChart.enableExclude)
    return this.mchartModel._GetDrawingList().indexOf(this._GetReferredList()[index]) >= 0;
  return true;
}

ZtMultiDimCursorChart.prototype._IsNotExcludedDomain = function (text) {
  // giro column - row piu' diffuso
  if (this.mchartModel.dataOrder == "column")
    return this.mchartModel._GetOppositeDrawingList().indexOf(text) >= 0;
  var mvf = JSON.parse(this.mchartModel.columnOrderData.orgSeriesList).indexOf(text);
  return this.mchartModel._GetOppositeDrawingList().indexOf(JSON.parse(this.mchartModel.columnOrderData.valueFields)[mvf]) >= 0
}

ZtMultiDimCursorChart.prototype.DrawZoomCursor = function() {
  this._DrawZoomCursor();
}

ZtMultiDimCursorChart.prototype._DrawZoomCursor = function() {
  if (!this.asZoomCursor)
    return;
  var container = d3.select("#" +this.chartId + "divchartcontainer").node();
  var offsetObj = null;
  if(d3.select("#"+this.chartId + this.type + "_svgGroup")._groups[0][0] != null) {
    var xdom = d3.select("#"+this.chartId + this.type + "_svgGroup")._groups[0][0].transform.baseVal.getItem(0).matrix.e;
    var ydom = d3.select("#"+this.chartId + this.type + "_svgGroup")._groups[0][0].transform.baseVal.getItem(0).matrix.f;
    offsetObj = {};
    offsetObj.x = xdom;
    offsetObj.y = ydom;
  }

  if (this.defSettings.multiDimensional.cursorType == "none") {
    for (var i = 0; i < this.keysList.length; i++) {
      this.mapCharts[this.keysList[i]]._DrawZoomCursor(container, offsetObj, this);
    }
  }
  else {
    var key = this.keysList[this.keyIndex];
    this.mapCharts[key]._DrawZoomCursor(container, offsetObj, this);
  }
}

ZtMultiDimCursorChart.prototype._SetCursorDrawingList = function (start, end) {
  /*
  this.drawingCategories = newArray.slice();
  this.mchartModel.drawingCategories = newArray.slice();*/
  for (var i = 0; i < this.keysList.length; i++) {
    if(!this.mapCharts[this.keysList[i]])
      this._CreateKeyChart(this.allDataIndex[this.keysList[i]], this.keysList[i], this.chartId + "MULTI_" + this.mchartModel.type, this.renderer, this.confObj);
    this.mapCharts[this.keysList[i]]._SetCursorDrawingList(start, end);
  }
}

ZtMultiDimCursorChart.prototype.ResetZoomCursor = function() {
  for (var i = 0; i < this.keysList.length; i++) {
    if(!this.mapCharts[this.keysList[i]])
      this._CreateKeyChart(this.allDataIndex[this.keysList[i]], this.keysList[i], this.chartId + "MULTI_" + this.mchartModel.type, this.renderer, this.confObj);
    this.mapCharts[this.keysList[i]].ResetZoomCursor();
  }
  
}
