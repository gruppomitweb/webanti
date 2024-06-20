function ZtTreeMapChart() {
  ZtPieChart.apply(this, ["TREEMAP", false]);
  this.legendHexCode = "e911";
  this.multiSVG = false;
  this.applyCalculationAfter = true;
}
ZtTreeMapChart.prototype = Object.create(ZtPieChart.prototype);
ZtTreeMapChart.prototype.constructor = ZtTreeMapChart;

ZtTreeMapChart.prototype._SetChartSettingsJSON = function () {
  this._ZtChart.enableExclude = false;
  this.defSettings.treemap = this.chartConfig.graphSettings.treemap;
}

ZtTreeMapChart.prototype._SetLists = function () {
  this.levelsFields = this.objConfig.labelField.split(",");
  this.valueFields = this.objConfig.valueFields;
  this.orgCategoryList = this.categoryList = this.legendList = this.rowLegendList = this.orgSeriesList = this.seriesList = [];
  this.drawingSeries = this.drawingCategories = [];
  if (!Empty(this.objConfig.labelSeries))
    this.orgSeriesList = this.legendList = getList(this.propertyName.indexOf(this.objConfig.labelSeries), this.dataSet);
  else
    this.orgSeriesList = this.legendList = getList(this.propertyName.indexOf(this.levelsFields[0]), this.dataSet);
  this.orgCategoryList = this.categoryList = getList(this.propertyName.indexOf(this.levelsFields[this.levelsFields.length - 1]), this.dataSet);
  this.keyLevelsFields = [];
  if (!Empty(this.objConfig.keyField))
    this.keyLevelsFields = this.objConfig.keyField.split(",");
}

ZtTreeMapChart.prototype._SetCalculationDataset = function () {
  /*var groupbyCat = false,
  groupNo = false;

  if (this.defSettings.treemap.dataGroupBy == 'none')
    groupNo = true;
  else if (this.defSettings.treemap.dataGroupBy == 'row')
    groupbyCat = true;
  */

  this.levelsIndex = {};
  var lev = this.levelsFields.concat(this.keyLevelsFields);//this.objConfig.labelField.split(",");
  for (var i = 0; i < lev.length; i++) {
    this.levelsIndex[lev[i]] = this.propertyName.indexOf(lev[i]);
  }

  var singleRoot = false,//this._GetSingleRoot(),
  lSeries = !Empty(this.objConfig.labelSeries) ? this.objConfig.labelSeries : this.levelsFields[0],
  addFields = [];
  if (this.categoryCodeIndex >= 0)
    addFields.push( { prop: "categoryCode", index: this.categoryCodeIndex } );
  this.calcDataset = getHieDataset(this.dataSet, this.levelsFields, this.valueFields, lSeries, this.propertyName, addFields, singleRoot, null, this.keyLevelsFields);
}

ZtTreeMapChart.prototype._GetSingleRoot = function () {
  return getList(this.levelsIndex[this.levelsFields[0]], this.dataSet).length == 1;
}

ZtTreeMapChart.prototype._DrawChartElements = function () {
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");
  var groupText = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroupLabels")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");
  this.DrawTreeMap(group, this.calcDataset, { width: this.chartWidth, height: this.chartHeight }, groupText);
}

ZtTreeMapChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  stroke,
  colorsObj = [],
  gradID;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.orgSeriesList.indexOf(this.items[i].series);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = this.valueFields.indexOf(this.items[i].valueField);

      if (this.items[i].depth <= 1) {
        this.items[i].color = this.colorSet[idx];
        colorsObj[idx] = this.items[i].color;
      }
      else {
        var parent = this._GetParent(this.items[i]);
        if (parent) {
          if (parent.index < 0 || !("index" in parent)) {
            parent.index = colorsObj.length;
            colorsObj[parent.index] = this.colorSet[parent.idx || idx];
          }
          this.items[i].color = colorsObj[parent.index]
        }
      }

      var styleObj = {};
      gradID = this.chartId + this.type + "_" + idx + "Gradient";
      if (!Empty(this.items[i].color.color) && Empty(this.items[i].color.gradient) || this.items[i].color.color.toLowerCase() == this.items[i].color.gradient.toLowerCase())
        stroke = this.items[i].color.color;
      else if (Empty(this.items[i].color.color) && !Empty(this.items[i].color.gradient))
        stroke = this.items[i].color.gradient;
      else {
        this.CreateGradient(this.items[i].color.color, this.items[i].color.gradient, gradID, "element");
        stroke = "url(#" + gradID + ")";
      }
      styleObj.fill = stroke;
      styleObj.stroke9width = 1 + "px";
      styleObj.stroke = "#F3F3F3";
      styleObj.shape9rendering = "crispEdges";
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtTreeMapChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm;
  d3.select(elem)
    .style("opacity", 0)
    .transition()
      .delay((item.idx * duration) / div)
      .duration(duration / div)
      .ease(d3.easeLinear)
      .style("opacity", 1);

  var text = item.textItm;
  if (!text)
    return;
  d3.select(text)
    //.style("opacity", 0)
    .attr("style", makeStyleHTMLString({opacity:0}, d3.select(text).attr("style")))
    .transition()
      .delay((item.idx * duration) / div)
      .duration(duration / div)
      .ease(d3.easeLinear)
      //.style("opacity", 1);
      .attr("style", makeStyleHTMLString({opacity:1}, d3.select(text).attr("style")))
}

ZtTreeMapChart.prototype._GetOtherAnimateFunction = function (item, lastValueObj) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm;
  d3.select(elem)
    .attr("x", lastValueObj.x)
    .attr("y", lastValueObj.y)
    .attr("width", lastValueObj.width)
    .attr("height", lastValueObj.height)
    .transition()
      .delay((item.idx * this.defSettings.animation.duration) / div)
      .duration(this.defSettings.animation.duration / div)
      .ease(d3.easeLinear)
      .attr("x", item.x)
      .attr("y", item.y)
      .attr("width", item.width)
      .attr("height", item.height);

  var text = item.textItm;
  if (!text)
    return;
  d3.select(text)
    .style("opacity", 0)
    .transition()
      .delay((item.idx * this.defSettings.animation.duration) / div)
      .duration(this.defSettings.animation.duration / div)
      .ease(d3.easeLinear)
      .style("opacity", function () {
        if (item.width == 0)
          return 0;
        return 1;
      });
}

ZtTreeMapChart.prototype._GetValueLabelX = function (pos, item/*, text, font*/) {
  return getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) / 2;
}

ZtTreeMapChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  return getDomNodeTop(item.itm) + getDomNodeHeight(item.itm) / 2 + getOffsetHeight(text, font, this.chartId) / 4;
}

ZtTreeMapChart.prototype._SetInReferredList = function (label) {
  StdChart.prototype._SetInReferredList.call(this, label);
}

ZtTreeMapChart.prototype._ApplyRedrawAnimationEffect = function (lastChart) {
  this.RemoveAllHovers();
  this.RemoveAllPatterns();
  this._SetItems(lastChart);
  this._MapMarginsFromChart(lastChart);
  this._ApplyEvents();

  var record,
  lastValues,
  treemap = getTreemapLayout(this.defSettings.treemap.tileStyle)
            .paddingInner(this.defSettings.treemap.innerPadding)
            .paddingOuter(this.defSettings.treemap.outerPadding)
            .size([this.chartWidth, this.chartHeight]),
  hie = d3.hierarchy(this.calcDataset),
  item,
  found,
  _this = this,
  gFont = JSON.stringify(this.defSettings.globalFont),
  initSize;

  gFont = JSON.parse(gFont);
  initSize = gFont.size;

  treemap( hie.sum( function(d) { return d.size; } ) );
  var data = hie.leaves();

  this._DrawPatterns();

  for (var i = 0; i < data.length; i++) {
    record = data[i];
    found = false;
    for (var j = 0; !found && j < this.items.length; j++) {
      item = this.items[j];
      if (this._CheckIdentityItemFromData(item, record.data) && item.itm) {
        found = true;
        lastValues = {};
        lastValues.width = item.width;
        lastValues.height = item.height;
        lastValues.x = item.x;
        lastValues.y = item.y;

        item.value = record.data.realValue;
        item.x = record.x0;
        item.y = record.y0;
        item.width = record.x1 - record.x0;
        item.height = record.y1 - record.y0;

        d3.select(item.itm).attr("x", item.x);
        d3.select(item.itm).attr("width", item.width);
        d3.select(item.itm).attr("y", item.y);
        d3.select(item.itm).attr("height", item.height);

        if (item.textItm) {
          d3.select(item.textItm)
            .text(function () {
              gFont.size = initSize;
              var name = !Empty(record.data.keyF) ? _this.categoryList[record.data.index] : record.data.name,
              opt = optimizeFontSize("in", name, gFont, item, 0.25, _this.chartId);
              item.isV = opt.isV;
              item.font = JSON.parse(opt.font);
              item.textWidth = opt.txtW;
              item.textHeight = opt.txtH;
              item.textItm = this;
              return opt.txt;
            })
            .attr("x", function () {
              if (item.isV)
                return - item.y - item.height;
              return item.x + 1;
            })
            .attr("y", function () {
              if (item.isV)
                return item.x + item.textHeight - 2; // 2 di stroke
              return item.y + _this.defSettings.globalFont.size;
            })
            .attr("transform", function () {
              if (item.isV)
                return "rotate(-90)";
              return "";
            })
            .style("font-size", function () {
              return item.font.size + "px";
            })
        }

        if (item.value < 0)
          this.ApplyPatternOnItem(item, "negativeValuePattern");
        this._GetOtherAnimateFunction(item, lastValues);
      }
    }
  }
  StdChart.prototype.AfterDrawTimeout.call(this);
}

ZtTreeMapChart.prototype._CheckIdentityItemFromData = function (itemOrg, itemOth) {
  return (itemOrg.series == itemOth.serie && itemOrg.category == itemOth.name) && (itemOrg.series == itemOth.serie && itemOrg.keyField == itemOth.keyF);
}

ZtTreeMapChart.prototype._GetDefaultDataOrder = function () {
  return StdChart.prototype._GetDefaultDataOrder.call(this);
}

ZtTreeMapChart.prototype._GetFilteredDataTreemap = function (data) {
  return data;

  var _this = this,
  fdata = {},
  tmpc = [],
  tmpcc = [],
  dList = this._GetDrawingList(),
  oList = this._GetOppositeDrawingList(),
  aList = this._GetAxisDrawingList(),
  i;

  if (this.dataOrder != this._GetDefaultDataOrder())
    oList = this._GetOppositeAxisDrawingList();
  
  fdata.name = data.name;
  if (this.defSettings.treemap.dataGroupBy == 'none') {
    tmpc = data.children.filter( function (child) {
                                    if (!Empty(_this.objConfig.keyField))
                                      return oList.indexOf(child.keyF) >= 0;
                                    return oList.indexOf(child.name) >= 0;
                                  }
                                );
    fdata.children = tmpc.filter( function (child) { return aList.indexOf(child.serie) >= 0; } );
  }
  else if (this.defSettings.treemap.dataGroupBy == this._GetDefaultDataOrder() || this.defSettings.treemap.dataGroupBy == "default") {
    tmpc = data.children.filter( function (child) { return dList.indexOf(child.name) >= 0; } );
    for (i = 0; i < tmpc.length; i++) {
      tmpcc = tmpc[i].children.filter( function (child) {
                                          if (!Empty(_this.objConfig.keyField))
                                            return oList.indexOf(child.keyF) >= 0;
                                          return oList.indexOf(child.name) >= 0;
                                       }
                                     );
      tmpc[i].children = tmpcc.slice();
    }
    fdata.children = tmpc.slice();
  }
  else {
    tmpc = data.children.filter( function (child) {
                                    if (!Empty(_this.objConfig.keyField))
                                      return oList.indexOf(child.keyF) >= 0;
                                    return oList.indexOf(child.name) >= 0;
                                  } 
                                );
    for (i = 0; i < tmpc.length; i++) {
      tmpcc = tmpc[i].children.filter( function (child) { return aList.indexOf(child.serie) >= 0; } );
      tmpc[i].children = tmpcc.slice();
    }
    fdata.children = tmpc.slice();
  }

  return fdata;
}

ZtTreeMapChart.prototype._ApplyPatterns = function () {
  if (!this.hasNegativeValues)
    return;
  this._DrawPatterns();
  StdChart.prototype._ApplyPatterns.call(this);
}

ZtTreeMapChart.prototype._DrawMarkerIconOnItem = function (item) {
  StdChart.prototype._DrawMarkerIconOnItem.call(this, item);
}

ZtTreeMapChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
                .attr("id", this.chartId + "valueLabels")
                .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  items = this._GetItems(),
  item;
  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
    pos = "in",
    font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
    label = group.append("text")
              .attr("x", this._GetValueLabelX(pos, item, text, font))
              .attr("y", this._GetValueLabelY(pos, item, text, font))
              .style("text-anchor", "middle")
              .text(text);
    setFont(label, font, this);
  }
}

ZtTreeMapChart.prototype._GetParent = function (item) {
  var parent = item.parent;
  if (parent) {
    var tpar = parent;
    while (!Empty(parent.parent)) {
      tpar = parent;
      parent = parent.parent;
    }
    parent = tpar;
  }
  return parent;
}

ZtTreeMapChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv,
  _this = this,
  coords = this.levelsFields.concat(this.valueFields),
  i;

  if (!Empty(this.objConfig.labelsGrid)) {
    var progrIndex = 0;
    if (!Empty(this.objConfig.labelsGrid.key)) {
      var labval = this.objConfig.labelsGrid.key.split(",");
      for (i = 0; i < coords.length - 1; i++) {
        if (!Empty(labval[i]))
          coords[progrIndex] = labval[i];
        progrIndex++;
      }
    }

    if (!Empty(this.objConfig.labelsGrid.values))
      coords[progrIndex] = this.objConfig.labelsGrid.values;
  }

  for (i = 0; i < coords.length; i++){
    td = document.createElement("td");
    td.className = "grid_title grid_cell_title grid_cell_title_table";
    innerdiv = document.createElement("div");
    // testo colonne campi
    innerdiv.textContent = coords[i];
    td.appendChild(innerdiv);
    thead.appendChild(td);
  }

  var pathValues = [],
  chds,
  root = (this.calcDataset.name == "ztc_root");

  //table content
  for (i = 0; i < this.calcDataset.children.length; i++) {
    pathValues = [];
    if (!root)
      pathValues.push(this.calcDataset.name);
    chds = this.calcDataset.children[i];
    pathValues.push(chds.name);
    fillRow(chds, pathValues, tbody1);
  }

  function fillRow(chds, path, tbody1) {
    var i;
    if (Empty(chds.children)) {
      // terminale
      path.push(chds.size);
      var row = document.createElement("tr");
      row.style.height = "42px";
      row.className = "grid_row";
      for (i = 0; i < path.length; i++) {
        var cell = document.createElement("td"),
        div3 = document.createElement("div");
        div3.textContent = _this._GetGridCellValue(path[i], i, path);
        cell.appendChild(div3);
        row.appendChild(cell);
      }
      tbody1.appendChild(row);
      path.pop();
      return;
    }
    
    for (i = 0; i < chds.children.length; i++) {
      var chd = chds.children[i];
      path.push(chd.name);
      fillRow(chd, path, tbody1);
      path.pop();
    }
  }
}

ZtTreeMapChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  var isLast = (dataidx == record.length - 1);
  if (!isLast)
    return value;
  // apply picture + funzione
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture) {
      var item = this._FindItemForGrid(record);
      return this.functionObj.GetValuePicture(item);
    }
  }
  else
    return this.GetValuePicture(value);
}

ZtTreeMapChart.prototype._FindItemForGrid = function (record) {
  var itm = { path_depths: [] },
  i;
  for (i = 0; i < this.levelsFields.length; i++) {
    itm.path_depths.push({
      field: this.levelsFields[i],
      value: record[i]
    });
  }

  itm.value = record[record.length - 1];
  itm.field = this.valueFields;
  return itm;
}

ZtTreeMapChart.prototype._GetParentPath = function (item) {
  var parent_depth = [],
  parent = item.parent;
  parent_depth.push({ name: item.name, keyF: !Empty(item.keyField) ? item.keyField : null });
  if (parent) {
    var tpar = parent;
    while (!Empty(parent)/*.parent)*/) {
      tpar = parent;
      parent_depth.push({ name: tpar.data.name, keyF: !Empty(tpar.data.keyF) ? tpar.data.keyF : null });
      parent = parent.parent;
    }
    parent = tpar;
  }

  return parent_depth.reverse();
}

ZtTreeMapChart.prototype._GetItemForGrid = function (item) {
  var rec_path = this._GetParentPath(item),
  itm = { path_depths: [] },
  i;
  for (i = 0; i < this.levelsFields.length; i++) {
    itm.path_depths.push({
      field: this.levelsFields[i],
      value: rec_path[i].name
    });

    if (!Empty(rec_path[i].keyF) && !Empty(this.keyLevelsFields)) {
      itm.path_depths[itm.path_depths.length - 1].keyField = this.keyLevelsFields[i];
      itm.path_depths[itm.path_depths.length - 1].keyValue = rec_path[i].keyF;
    }
  }

  itm.value = item.value;
  itm.field = this.valueFields;
  return itm;
}

ZtTreeMapChart.prototype._GetItemObj = function (itemObject) {
  var ret = {
    category: itemObject.category,
    series: itemObject.series,
    range: itemObject.range,
    value: itemObject.value,
    selIdx: itemObject.idx,
    rowIdx: (this.dataOrder=="column"?itemObject.sidx:itemObject.idx),
    categoryCode: itemObject.categoryCode,
    valueField: this.valueFields,
    isSelected : itemObject.isSelected,
    focus : itemObject.focus,
    multidimCurrentKey : this.appliedKey,
    color: itemObject.color,
    keyF: itemObject.keyField,
    color: itemObject.color
  };

  var path = this._GetParentPath(itemObject),
  path_detail = [],
  i;
  if (path.length > this.levelsFields.length) {
    if (path[0].name == "ztc_root")
      path.splice(0,1)
  }
  for (i = 0; i < this.levelsFields.length; i++) {
    path_detail.push({
      field: this.levelsFields[i],
      value: path[i].name
    });

    if (!Empty(path[i].keyF) && !Empty(this.keyLevelsFields)) {
      path_detail[path_detail.length - 1].keyField = this.keyLevelsFields[i];
      path_detail[path_detail.length - 1].keyValue = path[i].keyF;
    }
  }
  ret.path_detail = path_detail;
  return ret;
}