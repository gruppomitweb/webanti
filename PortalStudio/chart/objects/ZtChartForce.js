function ZtForceChart(type) {
  ZtTreeChart.apply(this, [type]);
  this.viewBreadcrumb = false;
  this.byCount = (this.type == "FORCESTR");
  this.colorsTree = {};
}
ZtForceChart.prototype = Object.create(ZtTreeChart.prototype);
ZtForceChart.prototype.constructor = ZtForceChart;

ZtForceChart.prototype._SetChartSettingsJSON = function () {
  ZtTreeChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.shape = this.chartConfig.graphSettings.shape;
  //this.defSettings.shape.figureTypes = ["circle", "square", "triangle", "cross", "diamond", "star", "wye"];
  this.defSettings.shape.figure = "circle"; // default
  if (this.objConfig.mapSeries && !Empty(Object.keys(this.objConfig.mapSeries))) {
    this.defSettings.shape.differSeries = true;
    this.defSettings.shape.figureTypes = [];
    this.defSettings.colorSeries = [];
    var okys = Object.keys(this.objConfig.mapSeries);
    for (var i = 0; i < okys.length; i++) {
      this.defSettings.shape.figureTypes.push(this.objConfig.mapSeries[okys[i]].type);
      this.defSettings.colorSeries.push({ color: this.objConfig.mapSeries[okys[i]].color, gradient: ""});
    }
  }
  this.defSettings.animation.animate = true;
  if (Empty(this.defSettings.animation.duration))
    this.defSettings.animation.duration = 1000;
}

ZtForceChart.prototype._SetFieldsIndexes = function () {
  ZtTreeChart.prototype._SetFieldsIndexes.call(this);
  this.levelsClassIndex = {};
  var lev = this.objConfig.labelSeries.split(",");
  for (var i = 0; i < lev.length; i++) {
    this.levelsClassIndex[lev[i]] = this.propertyName.indexOf(lev[i]);
  }
}

ZtForceChart.prototype._SetLists = function () {
  ZtTreeChart.prototype._SetLists.call(this);
  if (!Empty(this.objConfig.labelSeries))
    this.levelsLabelFields = this.objConfig.labelSeries.split(",");
  if (!Empty(this.objConfig.fieldClass))
    this.levelsClassFields = this.objConfig.fieldClass.split(",");
  if (this.objConfig.mapSeries)
    this.orgSeriesList = this.legendList = Object.keys(this.objConfig.mapSeries);
}

ZtForceChart.prototype._SetCalculationDataset = function () {
  var addFields;
  if (!this.byCount) {
    var lSeries = !Empty(this.objConfig.labelSeries) ? this.objConfig.labelSeries : this.levelsFields[0];
    addFields = [];
    if (this.categoryCodeIndex >= 0)
      addFields.push( { prop: "categoryCode", index: this.categoryCodeIndex } );
    var hie = getHieDataset(this.dataSet, this.levelsFields, this.valueFields, lSeries, this.propertyName, addFields, true);
    this.calcDataset = d3.hierarchy(hie);
    this.categoryList = getListFromObjectArray(this.calcDataset.children, "data.name")
  }
  else {
    addFields = [];
    if (this.categoryCodeIndex >= 0)
      addFields.push( { prop: "categoryCode", index: this.categoryCodeIndex } );
    var robj = getForceDataset(this.dataSet, this.levelsFields, this.valueFields, this.propertyName, this.levelsClassFields, this.levelsLabelFields, addFields);
    this.calcDataset = robj.nodes;
    this.calcLinks = robj.links;
    this.categoryList = robj.array.unique();
    if (!Empty(this.levelsLabelFields)) {
      this.orgCategoryList = robj.array;
      this.categoryList = robj.labels.unique();
    }
    if (!this.objConfig.mapSeries || Empty(Object.keys(this.objConfig.mapSeries)))
      this.orgSeriesList = this.legendList = this.categoryList.slice();
    else
      this.orgSeriesList = this.legendList = Object.keys(this.objConfig.mapSeries);
  }
  this.SetChartLegends();
}

ZtForceChart.prototype._DrawChartElements = function () {
  var group = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_elementGroup")
      .attr("transform","translate(" + [0,0] + ")"),
  radius = 5,
  minlen = Math.min((this.chartWidth / 2 - this.marginOffsetX), (this.chartHeight / 2 - this.marginOffsetY)),
  _this = this;

  this.forceSimulationFnc = function () {
    _this.svgDraw.link
        .attr("x1", function (d) { return d.source.x; })
        .attr("y1", function (d) { return d.source.y; })
        .attr("x2", function (d) { return d.target.x; })
        .attr("y2", function (d) { return d.target.y; });
  
    _this.svgDraw.node.attr("transform", function(d) { return "translate(" + d.x + ", " + d.y + ")"; });
  }

  this.forceSimulation = d3.forceSimulation()
    .force("center", d3.forceCenter(this.chartWidth / 2, this.chartHeight / 2))
    .force("charge", d3.forceManyBody().strength(- Math.min(this.chartWidth / 2, this.chartHeight / 2) / 2))
    .force("link", d3.forceLink().distance(minlen / 4))
    .force("collide", d3.forceCollide()
      .radius(function(d) {
        if (_this.scaleZ && d.data.size)
          return _this.scaleZ(d.data.size);
        return radius; 
      })
    )
    .force("x", d3.forceX())
    .force("y", d3.forceY())
    .on("tick", this.forceSimulationFnc);

  if (!this.drawStatic) {
    /* parto dal presupposto che ?log(alphaMin) / log(1 - alphaDecay)?; by default, this is 300 (rif. API d3js)
      e tengo fissata la parte log(alphaMin)
      l'equazione da risolvere e' log(alphaMin) / log(1 - alphaDecay) = prevIterations
    */
    var seconds = this.defSettings.animation.duration / 1000,
    defaultIterations = 300,
    defaultSeconds = 5,
    prevIterations = (defaultIterations * seconds) / defaultSeconds,
    alphaDecay = 1 - Math.exp(Math.log(this.forceSimulation.alphaMin()) / prevIterations);
    if (alphaDecay < 0)
      alphaDecay = 0;
    if (alphaDecay > 1)
      alphaDecay = 1;
    this.forceSimulation.alphaDecay(alphaDecay);
  }

  this.DrawForceLayout(group, this.calcDataset);
}

ZtForceChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = 0,
  gradID,
  colD,
  styleObj;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.categoryList.indexOf(this.items[i].desc);
    if (!this.byCount)
      idx = i;
    if (idx >= 0) {
      this.items[i].idx = this.items[i].index;
      if (!this.byCount) {
        if (this.items[i].hasChild) {
          if (!(this.items[i].category in this.colorsTree)) {
            this.colorsTree[this.items[i].category] = this.colorSet[idx];
            idx ++;
          }
          this.items[i].color = this.colorsTree[this.items[i].category];
        }
        else {
          var parent = this.items[i].parent;
          if (parent && parent.data) {
            if (!(parent.data.name in this.colorsTree)) { // tutela
              this.colorsTree[parent.data.name] = this.colorSet[idx];
              idx ++;
            }
            this.items[i].color = this.colorsTree[parent.data.name];
          }
        }
      }
      else {
        this.items[i].color = this.colorSet[idx];
        if (this.objConfig.mapSeries) {
          if (!Empty(this.items[i].class) && (this.items[i].class in this.objConfig.mapSeries)) {
            if (this.objConfig.mapSeries[this.items[i].class].color)
              this.items[i].color = { color: this.objConfig.mapSeries[this.items[i].class].color, gradient: "" };
          }
        }
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

  styleObj.fill = "none";
  styleObj.stroke = this.defSettings.line.color || "#D0D0D0";
  styleObj.stroke9width = (this.defSettings.line.stroke || 0.5) + "px";

  if (this.items.length > 1) {
    this.svg
      .selectAll(".link")
      .attr("style", makeStyleHTMLString(styleObj, this.svg.selectAll(".link").attr("style")));
  }
}

ZtForceChart.prototype._ApplyMouseOver = function (item, itemObj) {
  StdChart.prototype._ApplyMouseOver.call(this, item, itemObj);
}

ZtForceChart.prototype.AppendHoverItem = function (item, itemObj) {
  StdChart.prototype.AppendHoverItem.call(this, item, itemObj);
}

ZtForceChart.prototype._SelectItem = function (itemObject, select) {
  StdChart.prototype._SelectItem.call(this, itemObject, select);
  if (this.byCount)
    return;
  if (!itemObject.hasChild || !this.scaleZ)
    return;
  var fobj = this._FindNode(this.calcDataset.children, itemObject.category, []),
  current;

  if (fobj.found && fobj.progr.length >= 1) {
    current = this.calcDataset.children[fobj.progr[0]];
    for (var i = 1; i < fobj.progr.length; i++) {
      current = current.children[fobj.progr[i]];
    }
    if (current.children && current.children.length >= 1) {
      current.data._size = current.data.size;
      current.data.size = d3.max(this.allValuesZ) * 2;
      current._children = current.children;
      current.children = null;
    }
    else {
      current.data.size = current.data._size;
      current.data._size = null;
      current.children = current._children;
      current._children = null;
    }
  }
  this._UpdateElements();
}

ZtForceChart.prototype._UpdateElements = function () {
  var group = this.svg.select("#" + this.chartId + this.type + "_elementGroup");
  group.selectAll("g").remove();
  this.RemoveAllHovers();
  this.ResetItems();
  this.DrawForceLayout(group, this.calcDataset);
  this.AfterDraw();
  this.forceSimulation.restart();
  this.forceSimulation.alphaTarget(0);
}

ZtForceChart.prototype._GetItem = function (prop, value) {
  return this._GetItems().filter(function (it) { return it[prop] == value; })[0];
}

ZtForceChart.prototype._FindNode = function (chd, key, progr) {
  var found = false,
  obj = {};
  for (var i = 0; !found && i < chd.length; i++) {
    if (chd[i].data && chd[i].data.name == key) {
      found = true;
      progr.push(i);
    }
    else if (chd[i].children) {
      obj = this._FindNode(chd[i].children, key, progr);
      found = obj.found;
      progr = obj.progr;
      if (found)
        progr.splice(progr.length - 1, 0, i);
    }
  }
  return { found : found, progr : progr};
}

ZtForceChart.prototype._GetNodeSize = function (node, size) {
  for (var i = 0; i < node.children.length; i++) {
    if (node.children[i].data && ("size" in node.children[i].data))
      size += node.children[i].data.size;
    else
      size = this._GetNodeSize(node.children[i], size);
  }
  return size;
}

ZtForceChart.prototype._GetDefaultAnimateFunction = function (/*item, lastValueObj, duration*/) { }

ZtForceChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "";
  if (this.byCount) {
    // dep
  if (!Empty(itemObject.key))
    purl += "&key=" + URLenc(itemObject.key);
  
  if (!Empty(itemObject.desc))
    purl += "&category=" + URLenc(itemObject.desc);
  
  if (!Empty(itemObject.class))
    purl += "&serie=" + URLenc(itemObject.class);
  }
  else {
    if (!Empty(itemObject.category))
      purl += "&category=" + URLenc(itemObject.category);
  }

  if (!Empty(itemObject.value)) {
    var val = itemObject.value;
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject));
      }
    }
    purl += "&value=" + URLenc(val);
  } 

  return purl;
}

ZtForceChart.prototype._GetParametersStringForLink = function (item) {
  var purl = "";
  if (this.byCount) {
    // dep
  if (!Empty(item.keyF))
    purl += "&key=" + URLenc(item.keyF);
  
  if (!Empty(item.category))
    purl += "&category=" + URLenc(item.category);
  
  if (!Empty(item.series))
    purl += "&serie=" + URLenc(item.series);
  }
  else {
    if (!Empty(item.category))
      purl += "&category=" + URLenc(item.category);
  }

  if (!Empty(item.value)) {
    var val = item.value;
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
      }
    }
    purl += "&value=" + URLenc(val);
  } 

  return purl;
}

ZtForceChart.prototype._GetItemObj = function (itemObject) {
  var ret;
  if (this.byCount) {
    // dep
    ret = {
      category: itemObject.desc,
      series: itemObject.class,
      value: itemObject.value,
      categoryCode: itemObject.categoryCode,
      keyF: itemObject.key,
      rowIdx: -1,
      isSelected : itemObject.isSelected,
      multidimCurrentKey : this.appliedKey,
      color: itemObject.color
    }
  }
  else {
    // hie
    var row = -1,
    depth = itemObject.depth,
    fidx = this.levelsIndex[this.levelsFields[depth]],
    vidx = this.yIndex;
    this._ZtChart.orgData.filter(function (rec, index) {
      if (rec[fidx] == itemObject.category && 
          rec[vidx] == itemObject.value ) {
            row = index;
            return true;
          }
      return false;
    });

    ret = {
      category: itemObject.category,
      parent: itemObject.parentName,
      value: itemObject.value,
      rowIdx: itemObject.hasChild ? -1 : row,
      categoryCode: itemObject.categoryCode,
      depth: itemObject.depth,
      isSelected : itemObject.isSelected,
      multidimCurrentKey : this.appliedKey
    }
  }
  return ret;
}

ZtForceChart.prototype._HasShapes = function () {
  return true;
}

ZtForceChart.prototype._EvaluateAutomaticScales = function () {
  if (this.objConfig.mapSeries && !Empty(Object.keys(this.objConfig.mapSeries)))
    this.objConfig.manualScale = true;
}

ZtForceChart.prototype._GetReferredList = function () {
  return this.legendList;
}

ZtForceChart.prototype._GetDrawingList = function () {
  return this.legendList;
}

ZtForceChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv,
  i,
  fields = this.levelsFields.slice(),
  coords;

  if (!Empty(this.valueFields))
    fields.push(this.valueFields);
  coords = fields.slice();

  if (!Empty(this.objConfig.labelsGrid)) {
    var progrIndex = 0;
    if (!Empty(this.objConfig.labelsGrid.key)) {
      var labval = this.objConfig.labelsGrid.key.split(","),
      end = !Empty(this.valueFields) ? coords.length - 1 : coords.length;
      for (i = 0; i < end; i++) {
        if (!Empty(labval[i]))
          coords[progrIndex] = labval[i];
        progrIndex++;
      }
    }

    if (!Empty(this.valueFields) && !Empty(this.objConfig.labelsGrid.values))
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
      div3.textContent = this._GetGridCellValue(vals[idx], b, vals);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}

ZtForceChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  return ZtSunburstChart.prototype._GetGridCellValue.call(this, value, dataidx, record);
}

ZtForceChart.prototype._FindItemForGrid = function (record) {
  if (this.byCount) {
    var itm = {},
    idx;
    idx = this.propertyName.indexOf(this.valueFields);
    itm.value = record[idx];
    idx = this.propertyName.indexOf(this.levelsFields[1]);
    itm.desc = record[idx];
    itm.index = this.orgSeriesList.indexOf(itm.desc);
    return this._GetItemForGrid(itm);
  }
  else
    return ZtSunburstChart.prototype._FindItemForGrid.call(this, record);
}

ZtForceChart.prototype._GetParentPath = function (item) {
  return ZtSunburstChart.prototype._GetParentPath.call(this, item);
}

ZtForceChart.prototype._GetItemForGrid = function (item) {
  if (this.byCount) {
    var itm = {},
    i;
    itm.node = item.desc;
    itm.value = item.value;
    itm.field = this.valueFields;
    itm.source = {};
    itm.source.field = this.levelsFields[0];
    itm.source.values = [];
    itm.target = {};
    itm.target.field = this.levelsFields[1];
    itm.target.values = [];
    for (i = 0; i < this.calcLinks.length; i++) {
      var link = this.calcLinks[i];
      // item come target
      if (link.target.index == item.index) {
        if (itm.source.values.indexOf(link.source.name) < 0)
          itm.source.values.push(link.source.name);
      }
      // item come source
      if (link.source.index == item.index) {
        if (itm.target.values.indexOf(link.target.name) < 0)
          itm.target.values.push(link.target.name);
      }
    }
    // class
    // labels
    return itm;
  }
  else
    return ZtSunburstChart.prototype._GetItemForGrid.call(this, item);
}
