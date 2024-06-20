function ZtVoronoiChart() {
  StdChart.apply(this, ["VORONOI", "f111"]);
}
ZtVoronoiChart.prototype = Object.create(ZtPieChart.prototype);
ZtVoronoiChart.prototype.constructor = ZtVoronoiChart;

ZtVoronoiChart.prototype._SetChartSettingsJSON = function () {
  this._ZtChart.enableExclude = false;

  this.defSettings.line = this.chartConfig.graphSettings.line;
  this.defSettings.voronoi = this.chartConfig.graphSettings.extends.voronoi;
}

ZtVoronoiChart.prototype._SetFieldsIndexes = function () { }

ZtVoronoiChart.prototype._SetLists = function () {
  this.valueFields = this.objConfig.valueFields.split(',');
  this.xValues = this.propertyName.indexOf(this.valueFields[0]);
  this.yValues = this.propertyName.indexOf(this.valueFields[1]);
  this.categoryIndex = this.propertyName.indexOf(this.objConfig.labelField);
  this.seriesList = getList(this.propertyName.indexOf(this.objConfig.labelSeries), this.dataSet);
  this.orgSeriesList = this.seriesList.slice();
  this.categoryList = this.orgCategoryList = [];
  this.legendList = this.seriesList.slice().unique();
}

ZtVoronoiChart.prototype._SetScales = function () { 
  // opzione sui punti ?
  var _this = this,
  dpoints = this.dataSet.map(function(d){ return [d[_this.xValues], d[_this.yValues]]; }),
  dpointsX = dpoints.map(function(d){ return d[0]; }),
  dpointsY = dpoints.map(function(d){ return d[1]; });

  this.scaleX = d3.scaleLinear()
                .domain([d3.min(dpointsX), d3.max(dpointsX)])
                .range([2 * this._GetRadius(), this.chartWidth - (2 * this._GetRadius())]);
  this.scaleY = d3.scaleLinear()
            .domain([d3.min(dpointsY), d3.max(dpointsY)])
            .range([2 * this._GetRadius(), this.chartHeight - (2 * this._GetRadius())]);
  this.points = dpoints.map(function(d){ return [_this.scaleX(d[0]), _this.scaleY(d[1])]; });
}

ZtVoronoiChart.prototype._GetRadius = function () {
  return 4;
}

ZtVoronoiChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");
  this.DrawVoronoi(parentGroup, this.dataSet, this.points);
}

ZtVoronoiChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1;
  for (var i = 0; i < this.items.length; i++) {
    idx = this.orgSeriesList.indexOf(this.items[i].series);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = i;
      this.items[i].color = this.colorSet[idx];
      var styleObj = {};
      styleObj.fill = this.colorSet[idx].color;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtVoronoiChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  ZtXYZChart.prototype._GetDefaultAnimateFunction.call(this, item, lastValueObj, duration);
}

ZtVoronoiChart.prototype._GetDrawingList = function () {
  return this.orgSeriesList;
}

ZtVoronoiChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "",
  val;

  if (!Empty(itemObject.series))
    purl += "&serie=" + URLenc(itemObject.series);

  val = parseFloat(itemObject.coords.x);
  if (!Empty(val) && !isNaN(val))
    purl += "&x=" + URLenc(val);
  
  val = parseFloat(itemObject.coords.y);
  if (!Empty(val) && !isNaN(val))
    purl += "&y=" + URLenc(val);
  
  return purl;
}

ZtVoronoiChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv, i,
  coords = [],
  fields = [];
  if (!Empty(this.objConfig.labelField)) {
    coords.push("");
    fields.push(this.objConfig.labelField);
  }
  coords.push("");
  fields.push(this.objConfig.labelSeries);
  coords.push("x");
  fields.push(this.valueFields[0]);
  coords.push("y");
  fields.push(this.valueFields[1]);

  if (!Empty(this.objConfig.labelsGrid)) {
    var progrIndex = 0;
    if (!Empty(this.objConfig.labelField)) {
      if (!Empty(this.objConfig.labelsGrid.key))
        coords[progrIndex] = this.objConfig.labelsGrid.key;
      progrIndex++;
    }
    if (!Empty(this.objConfig.labelsGrid.serie))
      coords[progrIndex] = this.objConfig.labelsGrid.serie;
    progrIndex++;
    if (!Empty(this.objConfig.labelsGrid.values)) {
      var labval = this.objConfig.labelsGrid.values.split(",");
      if (!Empty(labval[0]))
        coords[progrIndex] = labval[0];
      progrIndex++;
      if (!Empty(labval[1]))
        coords[progrIndex] = labval[1];
    }
  }
  
  for (i = 0; i < coords.length; i++) {
    td = document.createElement("td");
    td.className = "grid_title grid_cell_title grid_cell_title_table";
    innerdiv = document.createElement("div");
    // testo colonne campi
    innerdiv.textContent = coords[i];
    td.appendChild(innerdiv);
    thead.appendChild(td);
  }

  //table content
  this.__gfields = fields.slice();
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
    for (var b = 0; b < fields.length; b++) {
      var cell = document.createElement("td"),
      div3 = document.createElement("div"),
      idx = this.propertyName.indexOf(fields[b]);
      div3.textContent = vals[idx];
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}

ZtVoronoiChart.prototype._GetItemObj = function (itemObject) {
  var ret = {
    category: itemObject.category,
    series: itemObject.series,
    range: itemObject.range,
    selIdx: itemObject.idx,
    rowIdx: itemObject.sidx,
    categoryCode: itemObject.categoryCode,
    x: itemObject.coords.x,
    y: itemObject.coords.y,
    isSelected : itemObject.isSelected,
    focus : itemObject.focus,
    multidimCurrentKey : this.appliedKey
  };
  return ret;
}