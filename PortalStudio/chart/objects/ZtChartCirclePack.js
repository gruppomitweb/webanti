function ZtCirclePackChart(type) {
  ZtSunburstChart.apply(this, [type]);
  this.isPack = (this.type == "CPACKSTR");
  this.viewBreadcrumb = this.isPack;
  this.legendHexCode = "e914";
}
ZtCirclePackChart.prototype = Object.create(ZtSunburstChart.prototype);
ZtCirclePackChart.prototype.constructor = ZtCirclePackChart;

ZtCirclePackChart.prototype._SetCalculationDataset = function () {
  if (typeof this.valueFields != "string")
    this.valueFields = this.objConfig.valueFields;
  var singleRoot = getList(this.levelsIndex[this.levelsFields[0]], this.dataSet).length == 1,
  lSeries = !Empty(this.objConfig.labelSeries) ? this.objConfig.labelSeries : this.levelsFields[0],
  addFields = [];
  if (this.categoryCodeIndex >= 0)
    addFields.push( { prop: "categoryCode", index: this.categoryCodeIndex } );
  this.calcDataset = getHieDataset(this.dataSet, this.levelsFields, this.valueFields, lSeries, this.propertyName, addFields, singleRoot, !this.isPack);
  if (Empty(this.drawingSeries) || this.isPack) {
    this._SetLists();
    return;
  }
  var chd = this.calcDataset.children;
  for (var i = chd.length - 1; i >= 0; i--) {
    if (this.excludedData.series.indexOf(chd[i].parentName) >= 0)
      chd.splice(i, 1);
  }
}

ZtCirclePackChart.prototype._SetLists = function () {
  ZtSunburstChart.prototype._SetLists.call(this);
  this.legendList = [];
  this.rowLegendList = [];
  if (this.isPack || Empty(this.calcDataset))
    return;
  this.orgSeriesList = getListFromObjectArray(this.calcDataset.children, "parentName").unique();
  this.legendList = this.orgSeriesList.slice(); //MG VPV
  this.drawingSeries = this.orgSeriesList.slice();
}

ZtCirclePackChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  id = "",
  group;

  for (var i = 0; i < positions.length; i++) {
    id = this.chartId + i + "_";
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      .attr("transform","translate(" + [0, 0] + ")");
    this.DrawCirclePack(group, this.calcDataset, i, positions[i].width, positions[i].height);
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtCirclePackChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  pidx = -1,
  gradID,
  colD,
  colorsObj = [],
  styleObj;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.items[i].index;
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.valueFields.indexOf(this.items[i].valueField);
      if (this.isPack) {
        if (this.items[i].depth <= 1) {
          this.items[i].color = this.colorSet[idx];
          colorsObj["_" + idx] = { 
            lighter : getColorsArrayLighter(this.items[i].color.color, 7).reverse()
            //darker : getColorsArrayDarker(this.items[i].color.color, 8)
          }
        }
        else {
          var parent = this._GetParent(this.items[i]);
          if (parent) {
            this.items[i].color = colorsObj["_" + parent.index].lighter[this.items[i].depth - 1]
          }
        }
      }
      else {
        pidx = this.orgSeriesList.indexOf(this.items[i].parentName);
        this.items[i].color = this.colorSet[pidx];
        this.items[i].parentIndex = this.orgSeriesList.indexOf(this.items[i].parentName);
      }
      styleObj = {};
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
      styleObj.stroke = "#FAFAFA";
      styleObj.stroke9width = "0.5px";
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtCirclePackChart.prototype._GetDefaultDataOrder = function () {
  return "column";
}

ZtCirclePackChart.prototype._GetReferredList = function () {
  return this.orgSeriesList;
}

ZtCirclePackChart.prototype._GetItemsByLegendIndex = function (index) {
  var ret = {};
  ret.lItems = [];
  ret.nItems = [];
  ret.allSelected = true;
  var itms = this._GetItems();
  for (var i = 0; i < itms.length; i++) {
    if (index == itms[i].parentIndex) {
      ret.lItems.push(itms[i]);
      ret.allSelected = ret.allSelected && itms[i].isSelected;
    }
    else {
      ret.nItems.push(itms[i]);
    }
  }
  return ret;
}

ZtCirclePackChart.prototype._EvaluateDatasetAndCalculation = function () {
  ZtStackBarChart.prototype._EvaluateDatasetAndCalculation.call(this);
}

ZtCirclePackChart.prototype._GetReferredExcludedList = function () {
  return this.orgSeriesList;
}

ZtCirclePackChart.prototype._GetDivisor = function () {
  return 1;
}

ZtCirclePackChart.prototype._ApplyMouseOver = function (item, itemObj, keepH) {
  var idx = d3.select(item).attr("item-index"),
  mRefChart = this._ZtChart.StdChart,
  itemObject = itemObj || this.items[idx];
  if (!keepH) {
    if (!keepH)
    this.RemoveAllHovers();
    this.AppendHoverItem(item);
    this.ShowTooltip(mRefChart, item, itemObject);
  }
  if (!this.isPack)
    return;
  if (itemObject.depth > 0) {
    var parent = itemObject.parent;
    if (parent)
      var parItem = this.items[parent.index];
    if (this.breadcrumbPath.indexOf(itemObject.category + this.splitSequence + idx) < 0)
      this.breadcrumbPath.push(itemObject.category + this.splitSequence + idx);
    this._ApplyMouseOver(parItem.itm, null, true);
  }
  else if (this.viewBreadcrumb) {
    // breadcrumb
    if (this.breadcrumbPath.indexOf(itemObject.category + this.splitSequence + idx) < 0)
      this.breadcrumbPath.push(itemObject.category + this.splitSequence + idx);
    this.breadcrumbPath.reverse();
    this.FillBreadcrumb(this.breadcrumbPath);
    this.breadcrumbPath = [];
  }
}

ZtCirclePackChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj),
  cx = d3.select(elem).attr("cx"),
  cy = d3.select(elem).attr("cy"),
  r = d3.select(elem).attr("r");
  d3.select(elem)
    .attr("cx", defaultValues ? cx : lastValueObj.cx)
    .attr("cy", defaultValues ? cy : lastValueObj.cy)
    .attr("r", defaultValues ? 0 : lastValueObj.r)
    .transition()
      .delay((this.isPack ? item.depth : item.parentIndex) * duration/div)
      .duration(duration/div)
      .ease(d3.easeLinear)
      .attr("cx", cx)
      .attr("cy", cy)
      .attr("r", r);
}

ZtCirclePackChart.prototype._GetAnimatedDivisor = function () {
  if (this.isPack)
    return ZtSunburstChart.prototype._GetAnimatedDivisor.call(this);
  return this.orgSeriesList.length;
}

ZtCirclePackChart.prototype._CreateGrid = function (thead, tbody1) {
  if (this.isPack) {
    ZtSunburstChart.prototype._CreateGrid.call(this, thead, tbody1);
    return;
  }

  //table header
  var td, innerdiv,
  coords = this.levelsFields.concat(this.valueFields),
  cols = this.levelsFields.concat(this.valueFields),
  i;

  if (!Empty(this.objConfig.labelsGrid)) {
    var progrIndex = 0;
    if (!Empty(this.objConfig.labelsGrid.key)) {
      var labval = this.objConfig.labelsGrid.key.split(",");
      for (i = 0; i < cols.length - 1; i++) {
        if (!Empty(labval[i]))
        cols[progrIndex] = labval[i];
        progrIndex++;
      }
    }

    if (!Empty(this.objConfig.labelsGrid.values))
      cols[progrIndex] = this.objConfig.labelsGrid.values;
  }

  for (i = 0; i < cols.length; i++){
    td = document.createElement("td");
    td.className = "grid_title grid_cell_title grid_cell_title_table";
    innerdiv = document.createElement("div");
    // testo colonne campi
    innerdiv.textContent = cols[i] //this._GetGridColumnName(this.propertyName[i]);
   // this._SetGridColumnStyle(innerdiv, this.propertyName[i]);
    td.appendChild(innerdiv);
    thead.appendChild(td);
  }

  //table content
  this.__gfields = coords.slice();
  for (i = 0; i < this.dataSet.length; i++) {
    var vals = this.dataSet[i],
    row = document.createElement("tr");
    row.style.height = "42px";
    if (i == 0 || i % 2 == 0) {
      row.className = "grid_rowodd";
    }
    else {
      row.className = "grid_row";
    }
    for (var b = 0; b < coords.length; b++) {
      var vidx = this.propertyName.indexOf(coords[b]),
      cell_val = vals[vidx],
      cell = document.createElement("td"),
      div3 = document.createElement("div");
      div3.textContent = this._GetGridCellValue(cell_val, b, vals);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}

ZtCirclePackChart.prototype._FindItemForGrid = function (record) {
  if (this.isPack) {
    return ZtSunburstChart.prototype._FindItemForGrid.call(this, record);
  }
  else {
    return {
      serie: record[this.propertyName.indexOf(this.levelsFields[this.levelsFields.length - 2])],
      category: record[this.propertyName.indexOf(this.levelsFields[this.levelsFields.length - 1])],
      value: record[record.length - 1],
      field: this.valueFields
    }
  }
}

ZtCirclePackChart.prototype._GetItemForGrid = function (item) {
  if (this.isPack) {
    return ZtSunburstChart.prototype._GetItemForGrid.call(this, item);
  }
  else {
    return {
      serie: item.parentName,
      category: item.category,
      value: item.value,
      field: this.valueFields
    }
  }
}

ZtCirclePackChart.prototype._GetItemObj = function (itemObject) {
  if (this.isPack) {
    return ZtSunburstChart.prototype._GetItemObj.call(this, itemObject);
  }

  var ret = {
    category: itemObject.category,
    range: itemObject.range,
    value: itemObject.value,
    rowIdx: itemObject.data_idx,
    categoryCode: itemObject.categoryCode,
    isSelected : itemObject.isSelected,
    focus : itemObject.focus,
    multidimCurrentKey : this.appliedKey,
    color: itemObject.color
  };
  return ret;
}