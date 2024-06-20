/* global
  languageConfigurations
*/

function ZtCalendarChart() {
  StdChart.apply(this, ["CAL", "e902"]);
  this.multiSVG = true;
}
ZtCalendarChart.prototype = Object.create(ZtPieChart.prototype);
ZtCalendarChart.prototype.constructor = ZtCalendarChart;

ZtCalendarChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.axisLabel = this.chartConfig.graphSettings.axisLabel;
  this.defSettings.domainAxis = this.chartConfig.graphSettings.domainAxis;
  this.defSettings.domainAxis.useValueFont = false;

  if (Empty(this.defSettings.time.dataView))
    this.defSettings.time.dataView = "year";

 //   this.defSettings.time.dataView = "day";
}

ZtCalendarChart.prototype._DrawChartElements = function () {
  this.rangeDates = { min : d3.min(this.categoryList), max : d3.max(this.categoryList) };

  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  divisor = this._GetDivisor();

/*  if (this.defSettings.time.dataView == "day") {
    var hrs = 24,
    divW = this.chartWidth / divisor,
    divH = this.chartHeight / hrs,
    size = Math.min(divW, divH),
    min_size = 10;

    if (divW < min_size || divH < min_size) {
      var thW = this.chartWidth / min_size,
      thH = this.chartHeight / min_size;
      console.log(">DIV", divW, divH)
      console.log(">THEO", thW, thH)

    }
  }
  */

  var positions = this.GetScrollSubdivisionsSizes(divisor, this.chartWidth, this.chartHeight, true),
  group,
  progrY = 0,
  start,
  end,
  d3Time = getD3TimeObject(this.defSettings.time.dataView),
  cellWidth,
  cellHeight,
  cellSize,
  oldChartId = this.chartId,
  oldChartHeight = this.chartHeight,
  drawW,
  drawH;

  for (var i = 0; i < divisor; i++) {
    this.chartId = oldChartId + i + "_";
    this._DrawMultiSVGPlot(this.chartId, parentGroup, 0, progrY, positions.width, positions.height);
    group = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_elementGroup")
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")")

    if (i == 0)
      start = d3Time(this.rangeDates.min);
    end = d3Time.offset(start, 1);
//    end = d3.timeDay.offset(end, -1);
    drawW = positions.width - this.margin.left - this.margin.right;
    drawH = positions.height - this.margin.top - this.margin.bottom;
    cellWidth = drawW / this._GetWidthDivisor();
    cellHeight = drawH / this._GetHeightDivisor();
    cellSize = Math.min(cellWidth, cellHeight);
    this.shapes = [];
    this.DrawCalendar(group, start, end, drawW, drawH, cellSize);
    this.chartHeight = /*Math.min((cellSize * (this._GetHeightDivisor() + 1)),*/ positions.height//);
    progrY = progrY + this.chartHeight;
    this._DrawAxisLabel(start);
    start = end//d3.timeDay.offset(end, 1);
  }
  
  this.chartHeight = oldChartHeight;
  this.chartId = oldChartId;
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtCalendarChart.prototype._GetDivisor = function () {
  var d3Time = getD3TimeObject(this.defSettings.time.dataView),
  count = d3Time.count(this.rangeDates.min, this.rangeDates.max);
  // intervallo direbbe 1 (es. 2017-2018 passa 1 solo anno) ma ne devo disegnare 2
  count ++;
  return count;
}

ZtCalendarChart.prototype._GetWidthDivisor = function () {
  // divido in giorni - poi raggruppo in unit (es settimane)
  var dayObj = { year : 53, month : 31, week : 7 };
  return dayObj[this.defSettings.time.dataView];
}

ZtCalendarChart.prototype._GetHeightDivisor = function () {
  // divido in giorni - poi raggruppo in unit (es settimane)
  var dayObj = { year : 7, month : 1, week : 1 };
  return dayObj[this.defSettings.time.dataView];
}

ZtCalendarChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var styleObj = {};

  styleObj.fill = "transparent";
  styleObj.stroke = "#D3D3D3";
  d3.selectAll(".cellborder").attr("style", makeStyleHTMLString(styleObj, d3.selectAll(".cellborder").attr("style")));
  for (var i = 0; i < this.items.length; i++) {
    styleObj.stroke = "none";
    styleObj.fill = "transparent";
    if (this.items[i].value !== null) {
      styleObj.stroke = "#D3D3D3";
      styleObj.fill = this.colorSet[0].color;
    }
    this.items[i].color = { color : styleObj.fill };
    if (this.items[i].value === null)
      this.items[i].color = { color : "#FAFAFA" };
    d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
  }
}

ZtCalendarChart.prototype._GetOtherChartMarginsObject = function (chartId, onlySVG, settings/*, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  var myM = {};
  //xlabel
  myM = setMarginObject("W", settings.axisLabel.axisFont, settings.axisLabel.useGlobalFont, settings.globalFont);
  if (myM != 0) {
    myM.offset = 5;
    ret.left.push(myM);
    ret.top.push(myM);
  }

  return ret;
}

ZtCalendarChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight, onlySVG) {
  var marginsObj = this._GetOtherChartMarginsObject(id, onlySVG, this.defSettings);
  this.CalculateMargins(svgWidth, svgHeight, marginsObj);
  this.CreateSVG(id, parent, false, svgLeft, svgTop, svgWidth, svgHeight, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this.CreateRenderer(this.svg, id, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
}

ZtCalendarChart.prototype._GetDomainAxisPosition = function () {
  return "bottom";
}

ZtCalendarChart.prototype._DrawAxisLabel = function (label) {
  var xInit = this.margin.left / 2,//this.margin.top + (this.chartHeight / 2),
  yInit = 0,
  format = getTimeTickFormat(this.localeLangFormat, getTimeFormatLabel(this.defSettings.time.dataView)),
  tLabel = format(label);
  this.DrawAxisLabel("domain", this._GetDomainAxisPosition(), xInit, yInit, tLabel);

  if (this.defSettings.time.dataView == "year") {
    var months = languageConfigurations(this.language).timeFormatLocale.months,
    shortMonths = languageConfigurations(this.language).timeFormatLocale.shortMonths,
    mwidth = getOffsetWidth(getMaxWordLength(months), this.defSettings.domainAxis.domainFont, this.chartId),
    smwidth = getOffsetWidth(getMaxWordLength(shortMonths), this.defSettings.domainAxis.domainFont, this.chartId),
    cont = this.shapes[0].itm.getBBox(),
    refarray = shortMonths,
    text;

    if (mwidth >= cont.width) {
      if (smwidth < cont.width)
        refarray = shortMonths;
    }

    var x, y, offset = 5,
    font = appliedFont(this.defSettings, this.defSettings.domainAxis, this.defSettings.domainAxis.domainFont),
    item;
    for (var i = 0; i < this.shapes.length; i++) {
      cont = this.shapes[i].itm.getBBox();
      text = refarray[i % refarray.length];
      xInit = this.margin.left + cont.x + (cont.width / 2);
      yInit = this.margin.top + cont.y;
      x = xInit - (getOffsetWidth(text, font, this.chartId) / 2);
      y = yInit - offset;
      item = this.svg.append("text")
        .attr("x", x)
        .attr("y", y)
       // .style("text-anchor", "middle")
        .text(text);
      setFont(item, font, this);
    }

    
    
  }

  function getTimeFormatLabel(dataView) {
    switch (dataView) {
      case "year" :
        return "yyyy";
      case "month" :
        return "MMM-yyyy";
    }    
  }
}

ZtCalendarChart.prototype._SetAxisLabelsPositions = function () {
  var axisLabelD = this.svg.select("#" + this.chartId + "domainAxisLabel"),
  offset = 5,
  y = 0;
  
  if (!Empty(axisLabelD.node())) {
    y = this.margin.top// + this.chartHeight;
    axisLabelD.attr("y", y + (offset / 2));
  }
}

ZtCalendarChart.prototype._SetAxisLabelFont = function () {
  var oldChartId = this.chartId,
  dList = this._GetDrawingList();
  for(var i = 0; i < dList.length; i++) {
    this.chartId = oldChartId + i + "_";
    StdChart.prototype._SetAxisLabelFont.call(this);
  }
  this.chartId = oldChartId;
}

ZtCalendarChart.prototype._ApplyMouseOver = function (item, itemObj) {
  ZtBarChart.prototype._ApplyMouseOver.call(this, item, itemObj);
}

ZtCalendarChart.prototype._SetElementsRangeColor = function (isFnc) {
  ZtMatrixChart.prototype._SetElementsRangeColor.call(this, isFnc);
}

ZtCalendarChart.prototype.Animate = function () {
}