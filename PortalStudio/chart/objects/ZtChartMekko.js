function ZtMekkoChart() {
  StdChart.apply(this, ["MARIMEKKO", "e900"]);
  // per ora solo L-B
  this.applyCalculationAfter = true;
}
ZtMekkoChart.prototype = Object.create(ZtBarChart.prototype);
ZtMekkoChart.prototype.constructor = ZtMekkoChart;

ZtMekkoChart.prototype._SetChartSettingsJSON = function () {
  //
  this._ZtChart.enableExclude = false;
  //

  this.multipleScales = false;
  ZtBarChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.normalizeValues = this.chartConfig.graphSettings.normalized;
}

ZtMekkoChart.prototype.CheckDataSet = function () { }

ZtMekkoChart.prototype._SetScales = function () {
  this.scaleX = d3.scaleLinear();
  this.scaleX.__fieldType = "N";
  this.scaleY = d3.scaleLinear();
  this.scaleY.__fieldType = "N";
  this._SetScalesParameters();
}

// da spostare poi in Std ?
ZtMekkoChart.prototype.GetScaleType = function (field) {
  var scale,
  fld_i = this.propertyName.indexOf(field);
  if (fld_i >= 0) {
    switch (this.objConfig.fieldsType[fld_i]) {
      case "D":
      case "T":
        scale = d3.scaleTime();
        break;
      case "N":
        scale = d3.scaleLinear();
        break;
      default:  // C M L
        scale = d3.scaleBand();
        break;
    }
    scale.__fieldType = this.objConfig.fieldsType[fld_i];
  }
  return scale;
}

ZtMekkoChart.prototype._SetLists = function () {
  this.levels = this.objConfig.labelField.split(",");
  this.xIndex = this.propertyName.indexOf(this.levels[0]);
  this.categoryList = getList(this.xIndex, this.dataSet);
  this.orgCategoryList = this.categoryList.slice();
  this.drawingCategories = this.orgCategoryList.slice();
  this.valueFields = this.objConfig.valueFields.split(',');
  /*var spSer = this.objConfig.labelSeries.split(","),
  spIdx = this.propertyName.indexOf(this.objConfig.labelSeries);
  if (this.valueFields.length == 1) {
    if (spIdx >= 0)
      this.seriesList = getList(spIdx, this.dataSet);
    else
      this.seriesList = this.objConfig.labelSeries;
  }
  else {  // mi aspetto una ipotetica lista di serie associata ai campi alias inseriti in valuefields
    if (spSer.length > 1)
      this.seriesList = spSer.slice();
    else
      this.seriesList = getList(spIdx, this.dataSet);
  }*/
  var spIdx = this.propertyName.indexOf(this.levels.length == 1 ? this.levels[0] : this.levels[1]);
  this.seriesIndex = spIdx;
  this.seriesList = getList(spIdx, this.dataSet);
  this.orgSeriesList = this.seriesList.slice();
  this.drawingSeries = this.orgSeriesList.slice();
  this.allValues = [];
  //var f_idx = this.propertyName.indexOf(this.objConfig.labelField);
  /*if (f_idx >= 0 && this.objConfig.fieldsType[f_idx] == "N")
    this[this.objConfig.labelField + "_values"] = getValues([this.objConfig.labelField], this.propertyName, this.dataSet).unique();*/
  for (var i = 0; i < this.valueFields.length; i++) {
   // f_idx = this.propertyName.indexOf(this.valueFields[i]);
    //if (f_idx >= 0 && this.objConfig.fieldsType[f_idx] == "N") {
      this[this.valueFields[i] + "_values"] = getValues([this.valueFields[i]], this.propertyName, this.dataSet).unique();
      this.allValues = this.allValues.concat(this[this.valueFields[i] + "_values"]).unique();
    //}
  }
  this._SetTotalsObject();
  this.legendList = this.orgSeriesList.slice();
}

ZtMekkoChart.prototype._SetTotalsObject = function () {
  var _this = this,
  fdata,
  sum,
  index,
  i,
  j,
  all_sum = 0;
  this.allValues_stack = [];
  this.totalsSeries = {};
  for (i = 0; i < this.seriesList.length; i++) {
    sum = 0;
    fdata = this.dataSet.filter(function(rec) { if (rec.indexOf(_this.seriesList[i]) >= 0) return rec; });
    this.totalsSeries[this.seriesList[i]] = 0;
    for (j = 0; j < this.valueFields.length; j++) {
      index = this.propertyName.indexOf(this.valueFields[j]);
      sum = sum + d3.sum(fdata.map(function(rec){ return rec[index]; }));
    }
    this.totalsSeries[this.seriesList[i]] = sum;
  }
  this.totalsSeries.categoriesT = {};
  for (i = 0; i < this.orgCategoryList.length; i++) {
    index = this.propertyName.indexOf(/*this.objConfig.labelField*/this.levels[0]);
    sum = 0;
    fdata = this.dataSet.filter(function(rec) { if (rec[index] == _this.orgCategoryList[i]) return rec; });
    for (j = 0; j < this.valueFields.length; j++) {
      index = this.propertyName.indexOf(this.valueFields[j]);
      sum = sum + d3.sum(fdata.map(function(rec){ return rec[index]; }));
    }
    this.totalsSeries.categoriesT[i] = sum;
    all_sum += sum;
    this.allValues_stack.push(sum);
  }
  this.totalsSeries.categoriesTotal = all_sum;
}

ZtMekkoChart.prototype._SetScalesParameters = function () {
  var min, max;
  if (this.defSettings.normalizeValues) {
    this.scaleX.domain([0, 1]);
    this.scaleY.domain([1, 0]);
  }
  else {
    min = 0;
    max = d3.sum(this.allValues_stack);
    this.scaleX.domain([min, max]);
    max = d3.max(this.allValues_stack);
    this.scaleY.domain([max, min]);
  }

  this.scaleX.range([0, this.chartWidth]);
  this.scaleY.range([0, this.chartHeight]);
  this.scaleX.__scaleType = "N";
  this.scaleY.__scaleType = "N";
}

ZtMekkoChart.prototype._SetCalculationDataset = function () {
  this.calcDataset = [];  // contiene i valori di dataset - stack_x - perc_x - stack_y - perc_y
  var xidx = this.xIndex,//this.propertyName.indexOf(this.objConfig.labelField),
  yidx,
  fdata,
  ndata,
  sum,
  _this = this,
  xstack = 0,
  ystack;

  this.calcPName = this.propertyName.concat(["ztcstack_x", "ztcperc_x", "ztcpercst_x", "ztcstack_y", "ztcperc_y", "ztcpercst_y"]);
  for (var i = 0; i < this.orgCategoryList.length; i++) {
    fdata = this.dataSet.filter(function(rec) { if (rec[xidx] == _this.orgCategoryList[i]) return rec; });
    sum = this.totalsSeries.categoriesT[i];
    ndata = [];
    ystack = 0;
    for (var j = 0; j < this.valueFields.length; j++) {
      // metto in stack i valori delle serie
      yidx = this.propertyName.indexOf(this.valueFields[j]);
      if (yidx >= 0) {
        fdata.forEach(function(rec) {
          ndata.push(rec.slice());
          // x 
          ndata[ndata.length - 1].push(xstack + sum);
          ndata[ndata.length - 1].push(parseFloat((sum / _this.totalsSeries.categoriesTotal)/*.toFixed(2)*/));
          ndata[ndata.length - 1].push(parseFloat(((xstack + sum) / _this.totalsSeries.categoriesTotal)/*.toFixed(2)*/));
          // y
          ndata[ndata.length - 1].push(ystack + rec[yidx]);
          ndata[ndata.length - 1].push(parseFloat((rec[yidx] / sum)/*.toFixed(2)*/));
          ndata[ndata.length - 1].push(parseFloat(((ystack + rec[yidx]) / sum)/*.toFixed(2)*/));
          ystack += rec[yidx];
        });
      }
    }
    xstack += sum;
    this.calcDataset = this.calcDataset.concat(ndata);
  }

  
  console.log(this)
}

ZtMekkoChart.prototype._DrawAxis = function () {
  var opts = {};
  // x axis
  opts.type = "domain";
  opts.position = "Bottom";
  opts.x = this._GetDomainAxisXPosition();
  opts.y = this._GetDomainAxisYPosition();
  opts.scale = this.scaleX;
  opts.defSettings = this.defSettings.domainAxis;
  opts.font = this.defSettings.domainAxis.domainFont;
  this._DrawGenericAxis(opts);

  // y axis
  opts.type = "value";
  opts.position = "Left";
  opts.x = this._GetValueAxisXPosition();
  opts.y = this._GetValueAxisYPosition();
  opts.scale = this.scaleY;
  opts.defSettings = this.defSettings.valueAxis;
  opts.font = this.defSettings.valueAxis.valueFont;
  this._DrawGenericAxis(opts);
}

ZtMekkoChart.prototype._DrawGenericAxis = function (options) {
  var position = options.position,
  xPos = options.x,
  yPos = options.y,
  appFont = appliedFont(this.defSettings, options.defSettings, options.font),
  scale = options.scale,
  vRange = { min: d3.min(scale.domain()), max: d3.max(scale.domain()) },
  axis = d3["axis" + position](scale),
  id = options.id || "";

  if (scale.__scaleType == "N") {
    var precision = 0;
    if (!((Empty(options.defSettings.precision) || isNaN(options.defSettings.precision)) && options.defSettings.precision != 0))
      precision = options.defSettings.precision;
    else if (isNaN(options.defSettings.precision))
      precision = this._GetPrecisionFromValues(options.type);
    
    if (precision < 0)
      precision = 0;
    if (precision > 20)
      precision = 20;
    
    if (this.defSettings.normalizeValues)
      axis.tickFormat(this.localeLangFormat.numberFormat(".0%"));
    else {
      if (!options.ticks) {
        this._SelectAutoTickUnit(scale, vRange.min, vRange.max, appFont, true, precision);
        axis.tickValues(setTicks(vRange.min, vRange.max, this.tickUnit, precision));
      }
      else
        axis.tickValues(options.ticks);
      axis.tickFormat(this.localeLangFormat.numberFormat(",." + precision + "f"));
    }
  }
  else {
  }

  this.svg.append("g")
    .attr("id", this.chartId + options.type + "AxisGroup" + id)
    .attr("transform", "translate(" + [xPos, yPos] + ")")
    .call(axis);
  
  this.svg.select("#" + this.chartId + options.type + "AxisGroup" + id)
    .select("path")
      .attr("class", options.type + "Ax TRANSP");
}

ZtMekkoChart.prototype._SetAxisColor = function () {
  // top y2 -3 | btm y2 3 | lft x2 -3 | rgt x2 3
  this.SetAxisColor("domain", "y2", 3);
  this.SetAxisColor("value", "x2", -3);
}

ZtMekkoChart.prototype._SetAxisFont = function () {
  this.SetAxisFont("domain");
  this.SetAxisFont("value");
}

ZtMekkoChart.prototype._DrawChartPlotElements = function () {
  this._DrawAxis();
  this._DrawAxisLabel();
  this._DrawValueAxisGrid();
}

ZtMekkoChart.prototype._DrawVerticalValueAxisGrid = function () {
  var ticksArray = d3.select(this.svg.select("#" + this.chartId + "valueAxisGroup").node()).selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;
  var pos = [],
  xR = this.margin.left,
  yR = this.margin.top,
  w = this.chartWidth,
  grid,
  elemType = "line",
  _this = this;

  if (Empty(this.svg.select("#" + this.chartId + "valueAxisGridline").node()))
    grid = this.renderer.append("g").attr("id", this.chartId + "valueAxisGridline");

  if (this.defSettings.valueAxis.valueGrid.line) {
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      if (tick.transform.baseVal.length > 0 || tick.transform.baseVal.numberOfItems > 0)
        pos.push(tick.transform.baseVal.getItem(0).matrix.f);
    }

    grid.selectAll(".valueGridline")
      .data(pos)
      .enter()
      .append(elemType)
        .attr("class", "valueGridline TRANSP")
        .attr("id", function (d, i) {
          return _this.chartId + "valueGLine_" + i;
        })
        .attr("x1", xR)
        .attr("y1", function (d) {
          return yR + d;
        })
        .attr("x2", xR + w)
        .attr("y2", function (d) {
          return yR + d;
        });
  }
}

ZtMekkoChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  xIndex = this.xIndex,
  yIndex;

  for (var i = 0; i < this.valueFields.length; i++) {
    yIndex = this.propertyName.indexOf(this.valueFields[i]);
    this.DrawMekko(parentGroup, this.dataSet, i, xIndex, yIndex);
  }
}

ZtMekkoChart.prototype._GetX = function (d, index, xidx) {
  if (this.defSettings.normalizeValues) {
    var p_idx = this.calcPName.indexOf("ztcperc_x"),
    ps_idx = this.calcPName.indexOf("ztcpercst_x");
    return this.scaleX(this.calcDataset[index][ps_idx] - this.calcDataset[index][p_idx]);
  }
  var cx_idx = this.orgCategoryList.indexOf(this.calcDataset[index][xidx]),
  x_sum = this.totalsSeries.categoriesT[cx_idx],
  x_idx = this.calcPName.indexOf("ztcstack_x");
  return this.scaleX(this.calcDataset[index][x_idx] - x_sum);
}

ZtMekkoChart.prototype._GetY = function (d, index/*, yidx*/) {
  if (this.defSettings.normalizeValues) {
    var ps_idx = this.calcPName.indexOf("ztcpercst_y");
    return this.scaleY(this.calcDataset[index][ps_idx]);
  }
  var y_idx = this.calcPName.indexOf("ztcstack_y");
  return this.scaleY(this.calcDataset[index][y_idx]);
}

ZtMekkoChart.prototype._GetWidth = function (d, index, xidx) {
  if (this.defSettings.normalizeValues) {
    var p_idx = this.calcPName.indexOf("ztcperc_x");
    return this.scaleX(this.calcDataset[index][p_idx]);
  }
  var cx_idx = this.orgCategoryList.indexOf(this.calcDataset[index][xidx]),
  x_sum = this.totalsSeries.categoriesT[cx_idx];
  return this.scaleX(x_sum) - this.scaleX(0);
}

ZtMekkoChart.prototype._GetHeight = function (d, index, yidx) {
  if (this.defSettings.normalizeValues) {
    var p_idx = this.calcPName.indexOf("ztcperc_y");
    return Math.abs(this.scaleY(this.calcDataset[index][p_idx]) - this.scaleY(0));
  }
  return Math.abs(this.scaleY(this.calcDataset[index][yidx]) - this.scaleY(0));
}

ZtMekkoChart.prototype._SetElementsColor = function () {
  //var colors = ["#f5ae95", "#cca4bf", "#fbdf9f", "#a6dcbc", "#a7dad5"];
  //var colors = ["#3CA0E8", "#D8361A", "#FFC300", "#FF9D00", "#3B9B95", "#D4DCFF", "#7D83FF", "#007FFF", "#55C1FF", "#102E4A", "#A682FF"];
  this.SetColorSet();
  var idx = -1;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.seriesList.indexOf(this.items[i].series);
    this.items[i].idx = idx;
    this.items[i].sidx = i;
    this.items[i].color = this.colorSet[idx];
    var styleObj = {};
    styleObj.fill = this.colorSet[idx].color;
    d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
  }
}

ZtMekkoChart.prototype._GetValuesPrecision = function () {
  // dip dai valori
  return 0;
}

ZtMekkoChart.prototype._GetDomainPrecision = function () {
  // dip dai valori
  return 0;
}

ZtMekkoChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  items = this._GetItems(),
  item;
  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var /*enableZero = this.defSettings.valueLabel.type != "value" || (this.defSettings.valueLabel.type == "value" && this.defSettings.valueLabel.showZero),
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
    vText = (!enableZero && text == 0) ? "" : text,*/
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
    pos = this.defSettings.valueLabel.position,
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    label = group.append("text")
              .attr("x", this._GetValueLabelX(pos, item, text, font))
              .attr("y", this._GetValueLabelY(pos, item, text, font))
              .style("text-anchor", function () {
                switch (pos) {
                  case "oleft":
                  case "iright":
                    return "end";
                    break;
                  case "ileft":
                  case "oright":
                    return "start";
                    break;
                  default:
                    return "middle";
                    break;
                }
              })
              .text(text);
    setFont(label, font, this);
  }
}

ZtMekkoChart.prototype._DrawTotalValueLabel = function () {
}

ZtMekkoChart.prototype._GetAnimatedDivisor = function() {
  var div = this.legendList.length;
  if (div == 0)
    div = 1;
  return div;
}

ZtMekkoChart.prototype._GetPrecisionFromValues = function (/*type*/) {
  var prec = 0,
  myVal = this.allValues;
  for (var i = 0; i < myVal.length; i++)
    prec = Math.max(prec, decimalPlaces(myVal[i]));
  return prec;
}

ZtMekkoChart.prototype._GetValuesPrecision = function () {
  return this._GetPrecisionFromValues();
}

ZtMekkoChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv,
  fields = this.levels.concat(this.valueFields),
  cols = fields.slice();

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

  for (var i = 0; i < cols.length; i++){
    td = document.createElement("td");
    td.className = "grid_title grid_cell_title grid_cell_title_table";
    innerdiv = document.createElement("div");
    // testo colonne campi
    innerdiv.textContent = cols[i];
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
      div3.textContent = this._GetGridCellValue(vals[idx], b, fields);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}

ZtMekkoChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  var isValue = (dataidx == record.length - 1);
  if (!isValue)
    return value;
  // apply picture + funzione
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture)
      return this.functionObj.GetValuePicture(this._FindItemForGrid(record, dataidx));
  }
  else
    return this.GetValuePicture(value);
}

ZtMekkoChart.prototype._FindItemForGrid = function (record, validx) {
  var itm = {};
  itm.value = record[validx];
  itm.valueField = this.valueFields[0];
  itm.series = record[this.propertyName.indexOf(this.levels[1])];
  itm.category = record[this.propertyName.indexOf(this.levels[0])];
  return this._GetItemForGrid(itm);
}

ZtMekkoChart.prototype._GetItemForGrid = function (item) {
  var itm = {
    serie: item.series,
    category: item.category,
    value: item.value,
    field: item.valueField
  };
  return itm;
}