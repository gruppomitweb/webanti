function ZtSunburstChart(type) {
  StdChart.apply(this, [type, "e902"]);
  this.multiSVG = true;
  this.viewBreadcrumb = true;
  this.breadcrumbPath = [];
  this.byCount = (this.type == "SUNBSTR");
}
ZtSunburstChart.prototype = Object.create(ZtPieChart.prototype);
ZtSunburstChart.prototype.constructor = ZtSunburstChart;

ZtSunburstChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.hierarchy = this.chartConfig.graphSettings.hierarchy;
  this.defSettings.line = this.chartConfig.graphSettings.line;
  this.viewBreadcrumb = this.defSettings.hierarchy.breadcrumb.show;
}

ZtSunburstChart.prototype._SetFieldsIndexes = function () {
  this.yIndex = this.propertyName.indexOf(this.objConfig.valueFields);
  this.levelsIndex = {};
  var lev = this.objConfig.labelField.split(",");
  for (var i = 0; i < lev.length; i++) {
    this.levelsIndex[lev[i]] = this.propertyName.indexOf(lev[i]);
  }
  if (!Empty(this.objConfig.labelSeries))
    this.levelsLabelFields = this.objConfig.labelSeries.split(",");
}

ZtSunburstChart.prototype._SetLists = function () {
  this.levelsFields = this.objConfig.labelField.split(",");
  this.valueFields = this.objConfig.valueFields;
  this.orgCategoryList = this.categoryList = this.legendList = this.rowLegendList = this.orgSeriesList = this.seriesList = [];
  this.drawingSeries = this.drawingCategories = [];
  this.orgCategoryList = this.categoryList = getList(this.propertyName.indexOf(this.levelsFields[this.levelsFields.length - 1]), this.dataSet);
  if(!Empty(this.calcDataset)) { //MG VPV //legendlist =[] implica che non disegna la legenda
	  this.orgSeriesList = getListFromObjectArray(this.calcDataset.children, "name").unique();
	  this.legendList = this.orgSeriesList.slice(); 
	  this.drawingSeries = this.orgSeriesList.slice();
  }
}

ZtSunburstChart.prototype._SetCalculationDataset = function () {
  var singleRoot = getList(this.levelsIndex[this.levelsFields[0]], this.dataSet).length == 1,
  lSeries = !Empty(this.objConfig.labelSeries) ? this.objConfig.labelSeries : this.levelsFields[0],
  addFields = [];
  if (this.categoryCodeIndex >= 0)
    addFields.push( { prop: "categoryCode", index: this.categoryCodeIndex } );
  this.calcDataset = getHieDataset(this.dataSet, this.levelsFields, this.valueFields, lSeries, this.propertyName, addFields, singleRoot);
  this._SetLists();
}

ZtSunburstChart.prototype._DrawChartPlot = function () {
  this.CreateSVG(this.chartId, this.parent, true, 0, 0, this.defSettings.globals.width, this.defSettings.globals.height, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);// eslint-disable-line max-len
  this.CreateRenderer(this.svg, this.chartId, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this._DrawChartPlotTitles(this.svg);
  this.DrawBreadcrumb(this.svg);
}

ZtSunburstChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");

  var positions = this.GetRendererSubdivisionsSizes(this._GetDivisor()),
  id = "",
  group,
  radius,
  domainLabelH = 0,
  slice = 7;

  this._DrawPatterns();
  
  this.totalValueLabel = {};
  if (this.seriesList.length > 1)
    domainLabelH = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  for (var i = 0; i < positions.length; i++) {
    radius = Math.min(positions[i].width, positions[i].height) / 2;
    radius = radius - domainLabelH;
    radius = radius - radius * 0.05;  // tolgo il 5% per dare un po' di spazio al disegno
    radius = radius - ((radius * slice / 100) / 4);
    this.radius = radius;

    id = this.chartId + i + "_";
    /*this.multiMargins[dList[i]] = { x : this.margin.left + positions[i].x, 
                                    y : this.margin.top + positions[i].y,
                                    w : positions[i].width,
                                    h : positions[i].height
                                  };*/
    this._DrawMultiSVGPlot(id, parentGroup, positions[i].x, positions[i].y, positions[i].width, positions[i].height);
    group = this.renderer.append("g")
      .attr("id", id + this.type + "_elementGroup")
      .attr("transform","translate(" + [positions[i].width / 2, positions[i].height / 2] + ")");
    this.DrawSunburst(group, this.calcDataset, i, id);
   /* if (this.seriesList.length > 1) 
      this.DrawDomainLabel(i, positions[i], this.seriesList[this.valueFields.indexOf(dList[i])]);*/
  }
  this.svg = d3.select("#" + this.chartId + "d3ChartPlot");
  this.renderer = d3.select("#" + this.chartId + "d3Renderer");
}

ZtSunburstChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  gradID,
  colD,
  colorsObj = [],
  styleObj;

  for (var i = 0; i < this.items.length; i++) {
    idx = this.items[i].index;
    if (idx >= 0) {
      this.items[i].idx = idx;
      if (this.items[i].depth <= 1) {
        if( this.legendList && this.legendList.length > 0 ) {
          if( idx == 0 ) {
            this.items[i].color = this.colorSet[this.legendList.length];
          }
          else {
            this.items[i].color = this.colorSet[idx-1];
          }
        }
        else {
        this.items[i].color = this.colorSet[idx];
        }
        colorsObj["_" + idx] = { 
          //lighter : getColorsArrayLighter(this.items[i].color.color, 7).reverse()
          lighter : d3.interpolateRgb(d3.rgb(this.items[i].color.color), d3.rgb("#FFFFFF")),
        }
      }
      else {
        var parent = this._GetParent(this.items[i]);
        if (parent) {
          //this.items[i].color = colorsObj["_" + parent.index].lighter[this.items[i].depth - 1]
          this.items[i].color = { color: colorsObj["_" + parent.index].lighter(this.items[i].depth / this._GetAnimatedDivisor()), gradient: "" }
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
      if (this.items[i].depth == 0) {
        if (!this.defSettings.hierarchy.showRoot)
          styleObj.display = "none";
      }
      styleObj.stroke = this.defSettings.line.color || "";
      styleObj.stroke9width = this.defSettings.line.stroke || 0;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtSunburstChart.prototype._GetDivisor = function () {
  return this.valueFields.split(",").length;
}

ZtSunburstChart.prototype._GetParent = function (item) {
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

ZtSunburstChart.prototype._GetChartMarginsObject = function (chartId, settings/*, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {},
  myM;
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  if (this.viewBreadcrumb) {
    myM = setMarginObject("W", settings.globalFont, true, settings.globalFont);	
    if (myM != 0) {
      myM.offset = 15;  // 10 margine sopra e sotto altezza + 5 offset
      ret.top.push(myM);
    }
  }
  return ret;
}

ZtSunburstChart.prototype._ApplyMouseOver = function (item, itemObj, keepH) {
  if (this.defSettings.hierarchy.hoverPath == "element" && !this.defSettings.hierarchy.breadcrumb.show)
    return ZtPieChart.prototype._ApplyMouseOver.call(this, item, itemObj);

  var idx = d3.select(item).attr("item-index"),
  mRefChart = this._ZtChart.StdChart;
  if (!keepH)
    this.RemoveAllHovers();
  var applyH = this.defSettings.hierarchy.hoverPath == "path" && keepH && !Empty(this.breadcrumbPath);
  if (applyH || !keepH)
    this.AppendHoverItem(item);
  var itemObject = itemObj || this.items[idx];
  if (!keepH)
    this.ShowTooltip(mRefChart, item, itemObject);
  var depthL = this.defSettings.hierarchy.showRoot ? 0 : 1;
  if (itemObject.depth > depthL) {
    var parent = itemObject.parent;
    if (parent)
      var parItem = this.items[parent.index];
    if (this.breadcrumbPath.indexOf(itemObject.category + this.splitSequence + idx) < 0)
      this.breadcrumbPath.push(itemObject.category + this.splitSequence + idx);
    this._ApplyMouseOver(parItem.itm, null, true);
  }
  else if (item && this.viewBreadcrumb) {
    // breadcrumb
    if (this.breadcrumbPath.indexOf(itemObject.category + this.splitSequence + idx) < 0)
      this.breadcrumbPath.push(itemObject.category + this.splitSequence + idx);
    this.breadcrumbPath.reverse();
    this.FillBreadcrumb(this.breadcrumbPath);
    this.breadcrumbPath = [];
  }
}

ZtSunburstChart.prototype.AppendHoverItem = function (item) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  if (item) {
    var itemObject = this._GetItems()[d3.select(item).attr("item-index")],
    clone = this._GetItemClone(item, itemObject);
    d3.select(clone)
      .attr("item-type", "hover")
      .style("opacity", 0.5)
      .style("fill", function () {
        if (!Empty(_this.defSettings.hoverColor))
          return _this.defSettings.hoverColor;
        var darkCol = d3.rgb(itemObject.colorApplied).darker().toString();
        darkCol = d3.rgb(darkCol).darker().toString();
        return d3.rgb(darkCol).darker().toString();
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
        _this.RemoveAllHovers();
      //  mRefChart.RemoveHoverTimeout();
      })
      .on("click", function () {
        _this._ApplyClick(itemObject, d3.mouse(this));
      });
    item.parentNode.appendChild(clone);

    this.MoveRangeCursor(itemObject.value);
  }
}

ZtSunburstChart.prototype._DrawVLabelInside = function (group, items, font/*, valueField*/) {
  var progrGrad,
  text,
  angleRad,
  angleGrad,
  radiusRot,
  label,
  radius,
  maxH,
  _this = this,
  item;

  var x = d3.scaleLinear().range([0, 2 * Math.PI]),
  sy = d3.scaleSqrt().range([0, this.radius]);

  for (var i = 0; i < items.length; i++) {
    item = items[i];
    text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, "value");
    if (item.coords.startAngle == 0.01)
      progrGrad = (180 * item.coords.startAngle) / Math.PI;
    if (progrGrad >= 360)
      progrGrad = progrGrad - 360;
    angleRad = item.coords.endAngle - item.coords.startAngle;
    angleGrad = (180 * angleRad) / Math.PI;
    radiusRot = -90 + (angleGrad / 2) + progrGrad;
    if (progrGrad + (angleGrad / 2) >= 180)
      radiusRot = radiusRot - 180;

    // valutazione
    radius = item.coords.outerRadius - item.coords.innerRadius,
    maxH = 2 * radius * Math.sin(angleRad / 2);

    var evalVL = evaluateFontVL(text, font, radius, maxH);

    label = group.append("text")
            .attr("x", function () {
              sy(item.coords.innerRadius);
              /*var factor = 1;
              if (progrGrad + (angleGrad / 2) >= 180)
                factor = -1;
              return factor * (radius - offset);*/
            })
       /*     .attr("y", 0)*/
            .attr("transform", function () {
              var angle = x(item.coords.startAngle + item.coords.endAngle / 2) - Math.PI / 2;
              return "rotate(" + (angle / Math.PI * 180) + ")";
            /*  var y = item.coords.innerRadius;
              if (progrGrad + (angleGrad / 2) >= 180)
                y = - 1 * y;
              return "rotate(" + radiusRot + ") translate(" + y + ")";*/
            })
         /*   .style("text-anchor", function () {
              if (progrGrad + (angleGrad / 2) >= 180)
                return "start";
              return "end";
            })*/
            .text(text);
      setFont(label, evalVL.font, this);
 
    progrGrad = progrGrad + angleGrad;
  }

  function evaluateFontVL(text, font, radius, maxH) {
    var isOK = true,
    mfont = JSON.stringify(font);
    mfont = JSON.parse(mfont);
    var txtW = getOffsetWidth(text, mfont, _this.chartId),
    txtH = getOffsetHeight(text, mfont, _this.chartId),
    fontRed = 0.25;

    if (txtW > radius){
      mfont.size = mfont.size - mfont.size * fontRed;
      if (txtW > radius)
        isOK = false;
    }
    if (txtH > maxH && isOK) {
      mfont.size = mfont.size - mfont.size * fontRed;
      txtH = getOffsetHeight(text, mfont, _this.chartId);
      if (txtH > maxH)
        isOK = false;
    }

    return { print : isOK, font : mfont };
  }
}

ZtSunburstChart.prototype._SupportChangeOrder = function () {
  return false;
}

ZtSunburstChart.prototype._SupportFilter = function () {
  return false;
}

ZtSunburstChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration, noOpacity) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  defaultValues = Empty(lastValueObj),
  defaultObj = { x0: 0, x1: 0, y0: 0, y1: 0 };

  if (!noOpacity) {
    d3.select(elem)
      .style("fill-opacity", 0)
      .style("stroke-opacity", 0)
    .transition()
      .delay(item.depth * duration / div)
      .duration(duration / div)
      .attrTween("d", arcTween)
      .style("fill-opacity", 1)
      .style("stroke-opacity", 1)
  }
/*  else {
    d3.select(elem)
    .transition()
      .delay(item.index * duration / div)
      .duration(duration / div)
      .attrTween("d", arcTween);
  }
*/
  function arcTween(a) {
    var i = d3.interpolate(defaultValues ? defaultObj : this._lastValueObj, a),
    arc = d3.arc()
      .startAngle(function(d) { return d.x0; })
      .endAngle(function(d) { return d.x1; })
      .innerRadius(function(d) { return d.y0; })
      .outerRadius(function(d) { return d.y1; });
    return function(t) {
      return arc(i(t));
    };
  }
}

ZtSunburstChart.prototype._GetAnimatedDivisor = function () {
  if (!Empty(this.maxDepth) && this.maxDepth >= 0)
    return this.maxDepth;
  var max = 0;
  this.items.map(function(d){ max = Math.max(d.depth, max); return d;})
  this.maxDepth = max + 1;
  return this.maxDepth;
}

ZtSunburstChart.prototype._GetItemObj = function (itemObject) {
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

  var ret = {
    category: itemObject.category,
    range: itemObject.range,
    value: itemObject.value,
    rowIdx: itemObject.hasChild ? -1 : row,
    categoryCode: itemObject.categoryCode,
    valueField: this.levelsFields[itemObject.depth],
    isSelected : itemObject.isSelected,
    focus : itemObject.focus,
    multidimCurrentKey : this.appliedKey,
    color: itemObject.color
  };
  return ret;
}

ZtSunburstChart.prototype._DrawValueLabels = function () {
  var oldChartId = this.chartId,
  _this = this,
  font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont);

  for (var i = 0; i < this._GetDivisor(); i++) {
    this.chartId = oldChartId + i + "_";
    var group = d3.select("#" + this.chartId + "d3Renderer").append("g")
                  .attr("id", this.chartId + "valueLabels")
                  .attr("transform", d3.select("#" + this.chartId + this.type + "_elementGroup").attr("transform")),
    items = this.items.filter(function (item) { return item.valueField == _this.valueFields[i]; });

    for (var j = 0; j < items.length; j++) {
      var text = this.GetValueLabelText(this.defSettings.valueLabel.type, items[j], "value"),
      oh = getOffsetHeight(text, font, this.chartId);

      var label = group.append("text")
        .attr("dy", oh + 5)
        .append("textPath")
          .attr("xlink:href", "#" + oldChartId + "pie_" + items[j].index + "_" + i + "_" + items[j].depth)
          .attr("startOffset", "5px")
          .text(text);
      setFont(label, font, this);
    }
  }

  this.chartId = oldChartId;
}

ZtSunburstChart.prototype._CreateGrid = function (thead, tbody1) {
  // no prototipo treemap per mancanza di inclusione js
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
    innerdiv.textContent = coords[i] //this._GetGridColumnName(this.propertyName[i]);
   // this._SetGridColumnStyle(innerdiv, this.propertyName[i]);
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

ZtSunburstChart.prototype._GetGridCellValue = function (value, dataidx, record) {
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

ZtSunburstChart.prototype._FindItemForGrid = function (record) {
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

ZtSunburstChart.prototype._GetParentPath = function (item) {
  var parent_depth = [],
  parent = item.parent;
  parent_depth.push(item.name || item.category);
  if (parent) {
    var tpar = parent;
    while (!Empty(parent.parent)) {
      tpar = parent;
      parent_depth.push(tpar.data.name);
      parent = tpar.parent;
    }
    if (parent.data.name != "root")
      parent_depth.push(parent.data.name);
  }

  return parent_depth.reverse();
}

ZtSunburstChart.prototype._GetItemForGrid = function (item) {
  var rec_path = this._GetParentPath(item),
  itm = { path_depths: [] },
  i;
  for (i = 0; i < this.levelsFields.length; i++) {
    itm.path_depths.push({
      field: this.levelsFields[i],
      value: rec_path[i]
    });
  }

  itm.value = item.value;
  itm.field = this.valueFields;
  return itm;
}
