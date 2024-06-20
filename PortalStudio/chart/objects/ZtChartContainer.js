function ZtContainerChart() {
  StdChart.apply(this, ["CONTAINER"]);
  this.mapCharts = {};
  this.shapeRefChart;
  this.legendIcons = [];
  this.legendIconsHex = [];
}
ZtContainerChart.prototype = Object.create(StdChart.prototype);
ZtContainerChart.prototype.constructor = ZtContainerChart;

ZtContainerChart.prototype.InitChart = function (options) {
  this._ZtChart = options.ztChart;
  this.Init({
    _ZtChart: options.ztChart,
    chartConfig: options.chartConfig,
    objConfig: options.objConfig,
    propertyName: options.propertyName,
    propertyValue: options.dataset,
    parent: options.parent, 
    functionObj: options.fncObj,
    linkObj: options.lnkObj, 
    mychartid: options.chartId, 
    chartContainer: options.container,
    datetimePict: options.ztChart.datetimePict
  });
  this.SetJsonDef();
  StdChart.prototype._SetFieldsIndexes.call(this);
  StdChart.prototype._SetLists.call(this);
  this.SetDomainType(this._ZtChart.datetimePict);
  this._CreateCharts();
  this.SetColorSet();
}

ZtContainerChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.axisLabel = this.chartConfig.graphSettings.axisLabel;
  this.defSettings.domainAxis = this.chartConfig.graphSettings.domainAxis;
  this.defSettings.valueAxis = this.chartConfig.graphSettings.valueAxis;
  this.defSettings.domainAxis.precision = parseFloat(this.defSettings.domainAxis.precision);
  this.defSettings.valueAxis.precision = parseFloat(this.defSettings.valueAxis.precision);
}

ZtContainerChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels) { // eslint-disable-line max-len
  return ZtBarChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels); // eslint-disable-line max-len
}

ZtContainerChart.prototype._CreateCharts = function () {
  if (!this._ZtChart.StdChart)
    this._ZtChart.StdChart = this;
  var typesToDraw = {},
  objConfig = JSON.stringify(this.objConfig),
  chartConfig = JSON.stringify(this.chartConfig);
  objConfig = JSON.parse(objConfig);
  for (var i = 0; i < this.valueFields.length; i++) {
    var type = this.chartConfig.graphSettings.chartType,
    cdraw = false;
    if (this.valueFields[i] in this.objConfig.mapSeries) {
      if (this.objConfig.mapSeries[this.valueFields[i]].type != "default")
        type = this.objConfig.mapSeries[this.valueFields[i]].type;
    }
    cdraw = canDrawInContainer(type);
    if (!cdraw)
      type = getAlternativeChartType(type);
    if (!(type in typesToDraw))
      typesToDraw[type] = [];
    typesToDraw[type].push(this.valueFields[i]);
  }

  var ttd = Object.keys(typesToDraw),
  chid;
  this.allValues = [];
  for (i = 0; i < ttd.length; i++) {
    chid = typesToDraw[ttd[i]].join(this.splitSequence);
    objConfig.valueFields = typesToDraw[ttd[i]].toString();
    this.mapCharts[chid] = this.GetChart(ttd[i]);
    this.mapCharts[chid]._containerChart = this;
    this.mapCharts[chid].MapDomainType(this);
    this.mapCharts[chid].InitChart({
      ztChart: this._ZtChart,
      chartConfig: JSON.parse(chartConfig),
      objConfig: objConfig,
      propertyName: this.propertyName,
      dataset: this.dataSet,
      parent: this.parent,
      fncObj: this.functionObj,
      lnkObj: this.linkObj,
      chartId: this.chartId + chid,
      container: this.chartContainer
    });
    this.mapCharts[chid].SetDataDraw();
    this.mapCharts[chid].SetChartDraw();
    this._OverwriteDefProperties(this.mapCharts[chid]);
    this.mapCharts[chid]._OverwriteDefProperties();
    this.allValues = this.allValues.concat(this.mapCharts[chid].allValues.slice());
    this._SetLegendIcons(typesToDraw[ttd[i]], this.mapCharts[chid].GetLegendIcon(), this.mapCharts[chid]._GetLegendIconHexCode());
    if (this.mapCharts[chid].defSettings && this.mapCharts[chid].defSettings.shape)
      this.shapeRefChart = this.mapCharts[chid];
  }
}

ZtContainerChart.prototype._OverwriteDefProperties = function (chart) {
  if (chart.chartLegends.series)
    chart.chartLegends.series.position = "hide";
  if (chart.chartLegends.range)
    chart.chartLegends.range.position = "hide";
  chart.chartSubtitle = "";
  chart.chartTitle = "";
  chart.legendList = [];
  chart.defSettings.domainAxis.show = false;
  chart.defSettings.valueAxis.show = false;
}

ZtContainerChart.prototype.DrawCallback = function () {
  try {
    this.ResetAllTimeouts();
    this.ResetItems();
    this.ShowMaskDivAnimation();
    if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
      this._ZtChart.parentCtrl.dispatchEvent("Drawing", d3.event);

    if (this.chartWidth <= 0 || this.chartHeight <= 0) {
      if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
        this._ZtChart.parentCtrl.dispatchEvent("OnError", d3.event);
      return;
    }

    if (Empty(this.dataSet)) {
      this.HideMaskDivAnimation();
      this.RemoveLoadingDiv();
      this.DrawNotAvailableDiv(this.Translate("ZTC_NODATA"));
      if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
        this._ZtChart.parentCtrl.dispatchEvent("OnError", d3.event);
      return;
    }

    this.SetMenuItems();
    this.RemoveElements();

    // ipotizzo come riferimento la prima serie - il primo def
    this.EvaluateDrawingSpace();
    this._DrawChartPlot();
    this._DrawChartElements();
    this.AfterDraw();

    if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
      this._ZtChart.parentCtrl.dispatchEvent("Rendered", d3.event);
  }
  catch (error) {
    this.ResetAllTimeouts();
    this.HideMaskDivAnimation();
    this.DrawNotAvailableDiv(this.Translate("ZTC_ERROR"));
    if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
      this._ZtChart.parentCtrl.dispatchEvent("OnError", d3.event);
    console.log(error.stack);
    throw error;
  }
}

ZtContainerChart.prototype._DrawChartPlot = function () {
  if (!this.svg)
    this.CreateSVG(this.chartId, this.parent, true, 0, 0, this.defSettings.globals.width, this.defSettings.globals.height, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top); // eslint-disable-line max-len
  if (!this.renderer)
    this.CreateRenderer(this.svg, this.chartId, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this._MapSVGToCharts(this.svg, this.renderer);
  this._DrawChartPlotTitles(this.svg);
  this._DrawChartPlotElements();
}

ZtContainerChart.prototype._MapSVGToCharts = function (svg, renderer) {
  var mcharts = Object.keys(this.mapCharts);
  for (var i = 0; i < mcharts.length; i++) {
    this.mapCharts[mcharts[i]].svg = svg;
    this.mapCharts[mcharts[i]].renderer = renderer;
    this.mapCharts[mcharts[i]].margin = this.margin;
  }
}

ZtContainerChart.prototype.AdjustMaskAndRenderer = function () {
  StdChart.prototype.AdjustMaskAndRenderer.call(this);
  this._MapSVGToCharts(this.svg, this.renderer);
}

ZtContainerChart.prototype._DrawChartPlotElements = function () {
  ZtLinesChart.prototype._DrawChartPlotElements.call(this);
}

ZtContainerChart.prototype._GetValueAxisMinMax = function (scaleKey, minValue, maxValue) {
  return ZtLinesChart.prototype._GetValueAxisMinMax.call(this, scaleKey, minValue, maxValue);
}

ZtContainerChart.prototype._GetValueAxisPosition = function () {
  return ZtLinesChart.prototype._GetValueAxisPosition.call(this);
}

ZtContainerChart.prototype._GetDomainAxisPosition = function () {
  return ZtLinesChart.prototype._GetDomainAxisPosition.call(this);
}

ZtContainerChart.prototype._SetValueScaleParameters = function (scaleKey, scaleY, min, max) {
  if (!Empty(this.shapeRefChart) && this.shapeRefChart.valueFields.indexOf(scaleKey) >= 0)
    return ZtLinesChart.prototype._SetValueScaleParameters.call(this, scaleKey, scaleY, min, max);
  return ZtBarChart.prototype._SetVerticalValueScaleParameters.call(this, scaleKey, scaleY, min, max);
}

ZtContainerChart.prototype._SetDomainScaleParameters = function () {
  ZtLinesChart.prototype._SetDomainScaleParameters.call(this);
}

ZtContainerChart.prototype._GetDomainAxisXPosition = function () {
  return ZtLinesChart.prototype._GetDomainAxisXPosition.call(this);
}

ZtContainerChart.prototype._GetDomainAxisYPosition = function () {
  return ZtLinesChart.prototype._GetDomainAxisYPosition.call(this);
}

ZtContainerChart.prototype._GetValueAxisXPosition = function () {
  return ZtLinesChart.prototype._GetValueAxisXPosition.call(this);
}

ZtContainerChart.prototype._GetValueAxisYPosition = function () {
  return ZtLinesChart.prototype._GetValueAxisYPosition.call(this);
}

ZtContainerChart.prototype._DrawChartElements = function () {
  var mcharts = Object.keys(this.mapCharts),
  okeys;
  for (var i = 0; i < mcharts.length; i++) {
    this.mapCharts[mcharts[i]].scaleX = this.scaleX;
    okeys = Object.keys(this.mapCharts[mcharts[i]].scaleY);
    for (var j = 0; j < okeys.length; j++) {
      this.mapCharts[mcharts[i]].scaleY[okeys[j]] = this.scaleY[okeys[j]];
    }
    this.mapCharts[mcharts[i]]._DrawChartElements();
    this.items = this.items.concat(this.mapCharts[mcharts[i]]._GetItems());
  }
}

ZtContainerChart.prototype._SetElementsColor = function () {
  var mcharts = Object.keys(this.mapCharts),
  colors,
  nc,
  idx = -1;
  for (var i = 0; i < mcharts.length; i++) {
    nc = mcharts[i].split(this.splitSequence);
    colors = [];
    for (var j = 0; j < nc.length; j++) {
      idx = this.valueFields.indexOf(nc[j]);
      colors.push(this.colorSet[idx]);
    }
    this.mapCharts[mcharts[i]].defSettings.colorSeries = colors;
    this.mapCharts[mcharts[i]]._SetElementsColor();
    this.mapCharts[mcharts[i]]._SetShapesColor();
  }
}

ZtContainerChart.prototype._SetLegendIcons = function (toDraw, icon, iconHex) {
  for (var i = 0; i < toDraw.length; i++) {
    this.legendIcons[this.valueFields.indexOf(toDraw[i])] = icon;
    this.legendIconsHex[this.valueFields.indexOf(toDraw[i])] = iconHex;
  }
}

ZtContainerChart.prototype.GetLegendIcon = function () {
  return this.legendIcons;
}

ZtContainerChart.prototype._GetLegendIconHexCode = function () {
  return this.legendIconsHex;
}

ZtContainerChart.prototype._MapWithAnother = function (/*chart*/) { }

ZtContainerChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.scaleX = lastChart.scaleX;
  this.scaleY = lastChart.scaleY;
  var mcharts = Object.keys(this.mapCharts);
  for (var i = 0; i < mcharts.length; i++)
    this.mapCharts[mcharts[i]]._ApplyRedrawAnimationEffect(lastChart.mapCharts[mcharts[i]]);
}

ZtContainerChart.prototype._SupportChangeOrder = function () {
  return false;
}

ZtContainerChart.prototype._ApplyLegendMouseOver = function (item) {
  var range = CharToBool(item.getAttribute("data-range") + ""),
  iidx = parseInt(d3.select(item).attr("data-index")),
  mcharts = Object.keys(this.mapCharts);
  if (range) {
    for (var i = 0; i < mcharts.length; i++)
      this.mapCharts[mcharts[i]]._ApplyLegendMouseOver(item);
  }
  else {
    var mvf = this.valueFields[iidx],
    cid = "",
    items,
    index;
    for (i = 0; i < mcharts.length; i++) {
      if (mcharts[i].indexOf(mvf) >= 0) {
        cid = mcharts[i];
        index = this.mapCharts[cid].valueFields.indexOf(mvf);
        items = this.mapCharts[cid]._GetItemsByLegendIndex(index);
        this.mapCharts[cid]._ApplyItemSVGSelectEffect(items.lItems, true);
        this.mapCharts[cid]._ApplyItemSVGSelectEffect(items.nItems, false);
      }
      else {
        items = this.mapCharts[mcharts[i]]._GetItems();
        this.mapCharts[mcharts[i]]._ApplyItemSVGSelectEffect(items, false);
      }
    }
  }
}

ZtContainerChart.prototype._ApplyLegendMouseOut = function (item) {
  var mcharts = Object.keys(this.mapCharts);
  for (var i = 0; i < mcharts.length; i++)
    this.mapCharts[mcharts[i]]._ApplyLegendMouseOut(item);
}

ZtContainerChart.prototype._ApplyLegendClick = function (item) {
  var range = CharToBool(item.getAttribute("data-range") + ""),
  iidx = parseInt(d3.select(item).attr("data-index")),
  mcharts = Object.keys(this.mapCharts),
  legendObj,
  text = item.getAttribute("data-text"),
  inMenu = CharToBool("" + item.getAttribute("data-menu")),
  mouse = !inMenu ? d3.mouse(item) : null;
  if (range) {
    for (var i = 0; i < mcharts.length; i++)
      this.mapCharts[mcharts[i]]._ApplyLegendMouseOver(item);
  }
  else {
    var mvf = this.valueFields[iidx],
    cid = "",
    items,
    index;
    for (i = 0; Empty(legendObj) && i < mcharts.length; i++) {
      if (mcharts[i].indexOf(mvf) >= 0) {
        cid = mcharts[i];
        index = this.mapCharts[cid].valueFields.indexOf(mvf);
        items = this.mapCharts[cid]._GetItemsByLegendIndex(index);
        for (i = 0; i < items.lItems.length; i++)
          items.lItems[i].isSelected = !items.allSelected;

        legendObj = {
          current: item.textContent,
          txt: text,
          idx: iidx,
          mouse: mouse,
          isSelected : !items.allSelected
        };

        this.mapCharts[cid]._ApplyNoSelections();
        this._ApplyLegendNoSelections();
      }
    }

    if (window[this.chartId + "onLegendClick"])
      window[this.chartId + "onLegendClick"](legendObj);
    else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
      this._ZtChart.parentCtrl.dispatchEvent('onLegendClick', mouse, legendObj);
  }
}

ZtContainerChart.prototype._ApplyLegendNoSelections = function (stop) {
  if (!this._ZtChart.enableLegendEffect)
    return;
  var myItems = this.GetSelectedItems(),
  lgitems = this.svg.selectAll(".legendItem")._groups[0],
  sl = [],
  nl = [],
  lg,
  found;
  for (var i = 0; i < lgitems.length; i++) {
    lg = lgitems[i];
    found = false;
    for (var j=0; !found && j<myItems.length; j++) {
      if (myItems[j].valueField == this.valueFields[parseInt(lg.getAttribute("data-index"))]) {
        found = true;
      }
    }
    if (found)
      sl.push( { itm: lg } );
    else
      nl.push( { itm: lg } );
  }

  if (sl.length > 0) {
    this._ApplyItemSVGSelectEffect(sl, true);
    this._ApplyItemSVGSelectEffect(nl, false);
  }
  else
    this._ApplyItemSVGSelectEffect(nl, true);

  if (!stop)
    this._ApplyOtherLegendsSelection();
}

ZtContainerChart.prototype.GetSelectedItems = function () {
  var ret = [],
  mcharts = Object.keys(this.mapCharts);
  for (var i = 0; i < mcharts.length; i++) {
    if (this.mapCharts[mcharts[i]])
      ret = ret.concat(this.mapCharts[mcharts[i]].GetSelectedItems());
  }
  return ret;
}

ZtContainerChart.prototype.GetNotSelectedItems = function () {
  var ret = [],
  mcharts = Object.keys(this.mapCharts);
  for (var i = 0; i < mcharts.length; i++) {
    if (this.mapCharts[mcharts[i]])
      ret = ret.concat(this.mapCharts[mcharts[i]].GetNotSelectedItems());
  }
  return ret;
}

ZtContainerChart.prototype._ApplyLegendExcludeNoItem = function (exclude, index, text/*, upd*/) {
  var mcharts = Object.keys(this.mapCharts),
  found = false,
  mvf = this.valueFields[this.orgSeriesList.indexOf(text)],
  cid,
  iidx;
  for (var i = 0; !found && i < mcharts.length; i++) {
    if (mcharts[i].indexOf(mvf) >= 0) {
      cid = mcharts[i];
      iidx = this.mapCharts[cid].valueFields.indexOf(mvf);
      this.mapCharts[cid]._ApplyLegendExcludeNoItem(exclude, iidx, text, false);
      found = true;
    }

    if (found)
      this._RedrawDataChart(cid);
  }
}

ZtContainerChart.prototype._RedrawDataChart = function (/*cid*/) {
  // segue StdChart.RedrawData
  this.RedrawData();
}

ZtContainerChart.prototype._AnimateChartElements = function () {
  var mcharts = Object.keys(this.mapCharts),
  chart;
  for (var i = 0; i < mcharts.length; i++) {
    chart = this.mapCharts[mcharts[i]];
    if (!chart)
      continue;
    chart._AnimateChartElements();
  }
}

ZtContainerChart.prototype.GetShapesRadius = function () {
  if (!Empty(this.shapeRefChart))
    return this.shapeRefChart.GetShapesRadius();
  return 0;
}

ZtContainerChart.prototype._ApplyMouseOver = function (item/*, itemObj*/) {
  this.RemoveAllHovers();
  if (item) {
    var itemObject = this._GetItems()[d3.select(item).attr("item-index")];
    if (this.mapCharts) {
      if (this.mapCharts[itemObject.valueField])
        this.mapCharts[itemObject.valueField]._ApplyMouseOver(item, itemObject);
      else {
        var mcharts = Object.keys(this.mapCharts),
        found = false;
        for (var i = 0; !found && i < mcharts.length; i++) {
          if (mcharts[i].indexOf(itemObject.valueField) >= 0) {
            this.mapCharts[mcharts[i]]._ApplyMouseOver(item, itemObject);
            found = true;
          }
        }
      }
    }
  }
}