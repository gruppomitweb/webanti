function ZtImageChart(type) {
  ZtLightsChart.apply(this, ["IMAGES", "e913"]);
  this.type = type;
  this.isIcon = false;
  this.legendHexCode = "e901";
  this.isH = false;
  this.notAvailable = "";
  this.itemsHover = [];
  this.noRange = false;
}
ZtImageChart.prototype = Object.create(ZtLightsChart.prototype);
ZtImageChart.prototype.constructor = ZtImageChart;

ZtImageChart.prototype._SetChartSettingsJSON = function () {
  ZtLightsChart.prototype._SetChartSettingsJSON.call(this);

  this.isIcon = (this.defSettings.gauge.imageType != "default");
  this.notAvailable = !this.isIcon ? "portalstudio/images/chart_notavailable.png" : "e91b";
}

ZtImageChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  id = "",
  group,
  mvalues,
  //_this = this,
  dList = this._GetDrawingList(),
  oList = this._GetOppositeAxisDrawingList(),
  domainLabelH = 0,
  ph;

  if (oList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  for (var i = 0; i < positions.length; i++) {
    ph = positions[i].height - domainLabelH;
    id = this.chartId + i + "_";
    var xIndex = Empty(this.objConfig.keyField) ? this.xIndex : this.xLabelIndex;
    mvalues = this.dataSet.filter( function(record) { return record[xIndex] == oList[i]; } );
    this._SetCalculationDataset(mvalues);
    //this.allValues = this.calcDataset.map( function(rec) { return rec[1]; });
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup");
    var hgroup = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroupH");

    this.DrawImages(group, this.calcDataset, i, this.chartId, positions[i].width, ph);
    this._DrawHover(hgroup, i, dList);

    if (oList.length > 1)
      this.DrawDomainLabel(i, positions[i], oList[i]);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");

  if (this.noRange)
    this.defSettings.range.type = this.chartConfig.graphSettings.pointCap.pointer.rangeType;
}

ZtImageChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  colD;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.valueFields.indexOf(this.items[i].valueField);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        this.items[i].color = this.colorSet[i];
      this.items[i].sidx = this.categoryList.indexOf(this.items[i].category);
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

      if (!this.defSettings.range.applyColor)
        this._DrawMarkerIconOnItem(this.items[i]);
    }
  }
}

ZtImageChart.prototype._GetAnimatedDivisor = function() {
  return ZtRadarChart.prototype._GetAnimatedDivisor.call(this);
}

ZtImageChart.prototype._AnimateChartElements = function () {
  for (var i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;
  }
}

ZtImageChart.prototype._ApplyMouseOver = function (item, itemObj) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  if (item) {
    var hoverItemObject = itemObj || this.itemsHover[d3.select(item).attr("item-index")],
    itemObject = this.items[hoverItemObject.itemIndex],
    tooltipObject = {};
    d3.select(item)
      .style("opacity", 1)
      .style("fill", function () {
        var mcol = "";
        if (!Empty(_this.defSettings.hoverColor))
          mcol = _this.defSettings.hoverColor;
        else {
          var darkCol = d3.rgb(itemObject.colorApplied).darker().toString();
          darkCol = d3.rgb(darkCol).darker().toString();
          mcol = d3.rgb(darkCol).darker().toString();
        }
        hoverItemObject.colorApplied = mcol;
        return mcol;
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
        if (!hoverItemObject.isSelected)
          this.style.opacity = 0;
        else
          this.style.fill = _this.items[_this.itemsHover[d3.select(this).attr("item-index")].itemIndex].colorApplied;
        mRefChart.RemoveHoverTimeout();
        delete mRefChart._hoverItem;
      })
      .on("click", function () {
        _this._ApplyClick(itemObject, d3.mouse(this));
      });
    tooltipObject = this._GetItemObj(hoverItemObject);
    tooltipObject.color = { color : (itemObject.colorApplied || itemObject.color.color) };
    
    mRefChart._hoverItem = tooltipObject;
    mRefChart._d3mouse = d3.mouse(item);
    mRefChart._d3event = d3.event;
    setTimeout(function(mRefChart, item, tooltipObject){
      if (mRefChart._hoverItem) {
        if (mRefChart._CheckIdentityItem(mRefChart._hoverItem, tooltipObject)) {
          _this.ShowTooltip(mRefChart, item, tooltipObject);
        }
      }
    }, 50, mRefChart, item, tooltipObject);
  }
}

ZtImageChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  for (var i = 0; i < items.length; i++) {
    if (!items[i].itm)
      continue;
    if (items[i].type == "legend") {
      this._ApplyLegendSelectEffect(items[i], selected);
      continue;
    }
  }
}

ZtImageChart.prototype._GetItems = function() {
  if (!("sidx" in this.itemsHover[0])) {
    var _this = this;
    for (var i = 0; i < this.itemsHover.length; i++) {
      var item = this.itemsHover[i];
      item.idx = _this.items[item.itemIndex].idx;
      item.sidx = _this.items[item.itemIndex].sidx;
      item.coordinates = _this.items[item.itemIndex].coordinates;
    }
  }
  return this.itemsHover;
}

ZtImageChart.prototype._DrawHover = function (container, dataIndex/*, dList*/) {
  var _this = this,
  items = this.items.filter( function (item, index) { 
    item.currentIndex = index;
    var prop = "category";
    if (!Empty(_this.objConfig.keyField))
      prop = "keyField";
    return item[prop] == _this.orgCategoryList[dataIndex];
  } ),
  sizes;

  for (var i = 0; i < items.length; i++) {
    sizes = getDomNodeSizes(items[i].itm);
    container.append("rect")
      .attr("item-type", function () {
        _this.itemsHover.push({
          itm : this,
          series :  items[i].series,
          valueField : items[i].valuefield,
          category : items[i].category,
          value : items[i].value,
          itemType : "image",
          isHover : true,
          itemIndex : items[i].currentIndex
        });
        return "hover";
      })
      .attr("x", this.isIcon ? items[i].coordinates.x : sizes.x)
      .attr("y", this.isIcon ? items[i].coordinates.y : sizes.y)
      .attr("width", this.isIcon ? items[i].coordinates.width : sizes.width)
      .attr("height", this.isIcon ? items[i].coordinates.height : sizes.height)
      .attr("transform", d3.select(items[i].itm).attr("transform"))
      .style("opacity", 0)
      .style("fill-opacity", 0.5);
  }
}

ZtImageChart.prototype._ApplyRangeBands = function () {
  if (this.defSettings.range.applyColor)
    ZtBarChart.prototype._SetElementsRangeColor.call(this);
  else
    this.SetRangeInItems();
}

ZtImageChart.prototype._DrawMarkerIconOnItem = function (item) {
  if (this.defSettings.range.applyColor) {
    if (!this.chartLegends.series)
      return;
    if (this.chartLegends.series.position == "hide" || this.chartLegends.series.hide)
      return;
  }
  else {
    if (!this.isIcon)
      return;
    if (!this.chartLegends.range)
      return;
    if (this.chartLegends.range.position == "hide" || this.chartLegends.range.hide)
      return;
  }

  var color = item.color.color;
  if (!this.defSettings.range.applyColor)
    color = item.rangeColor;
  this._DrawMarkerIcon(item, color);
}

ZtImageChart.prototype._DrawMarkerIcon = function (item, color) {
  d3.select(item.itm.parentNode)
    .append("text")
      .attr("class", "ztchartfonticon markerItem")
      .attr("x", item.coordinates.x + item.coordinates.width - this.GetDefaultIconFont().size)
      .attr("y", item.coordinates.y + this.GetDefaultIconFont().size)
      .style("font-family", this.GetDefaultIconFont().name)
      .style("font-size", this.GetDefaultIconFont().size)
      .style("cursor", "default")
      .style("fill", color)
      .style("stroke", get3DColor( { color: color, gradient : "" } ).color)
      .style("stroke-width", 0.5)
      .text(this.GetMarkerLegendIcon());
}

ZtImageChart.prototype.GetLegendAlternativeIcon = function (isRange) {
  if (isRange) {
    if (this.defSettings.range.applyColor) {
      if (this.isIcon) {
        var icons = getListFromObjectArray(this.defSettings.range.bands, "iconCode");
        for (var i = 0; i < icons.length; i++)
          icons[i] = getIconFromCode(icons[i]);
        return icons;
      }
      return this.GetLegendIcon();
    }
    return this.GetMarkerLegendIcon();
  }

  if (!this.noRange) {
    if (this.defSettings.range && !Empty(this.defSettings.range.bands) && this.defSettings.range.applyColor)
      return this.GetMarkerLegendIcon();
  }
  return this.GetLegendIcon();
}

ZtImageChart.prototype.GetLegendAlternativeIconHexCode = function (isRange) {
  if (isRange) {
    if (this.defSettings.range.applyColor) {
      if (this.isIcon)
        return getListFromObjectArray(this.defSettings.range.bands, "iconCode");
      return this._GetLegendIconHexCode();
    }
    return this._GetMarkerLegendIconHexCode();
  }

  if (!this.noRange) {
    if (this.defSettings.range && !Empty(this.defSettings.range.bands) && this.defSettings.range.applyColor)
      return this._GetMarkerLegendIconHexCode();
  }
  return this._GetLegendIconHexCode();
}

ZtImageChart.prototype.SetChartDraw = function () {
  this._SetTitles();
  this.SetRangeList();
  this.SetChartLegends();
  if (this.isIcon && this.defSettings.range.type != this.chartConfig.graphSettings.pointCap.pointer.rangeType) {
    this.chartLegends.range.hide = true;
    this.noRange = true;
  }
  this.SetMargins(this._ZtChart.datetimePict);
}
