function ZtBCMatrixChart() {
  StdChart.apply(this, ["BCMATRIX", "e914"]);
  this.applyCalculationAfter = true;
}
ZtBCMatrixChart.prototype = Object.create(ZtBarChart.prototype);
ZtBCMatrixChart.prototype.constructor = ZtBCMatrixChart;

ZtBCMatrixChart.prototype.CheckDataSet = function () { }

ZtBCMatrixChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.axisLabel = this.chartConfig.graphSettings.axisLabel;
  this.defSettings.domainAxis = this.chartConfig.graphSettings.domainAxis;
  this.defSettings.valueAxis = this.chartConfig.graphSettings.valueAxis;
  this.defSettings.domainAxis.precision = parseFloat(this.defSettings.domainAxis.precision);
  this.defSettings.valueAxis.precision = parseFloat(this.defSettings.valueAxis.precision);
  this.defSettings.quadrants = this.chartConfig.graphSettings.extends.quadrants;
  this.defSettings.overlap = this.chartConfig.graphSettings.overlap;
}

ZtBCMatrixChart.prototype._SetFieldsIndexes = function () {
  this.seriesIndex = this.propertyName.indexOf(this.objConfig.labelField);
  var vf = this.objConfig.valueFields.split(';');
  this.xIndex = this.propertyName.indexOf(vf[0].split(",")[0]);
  this.yIndex = this.propertyName.indexOf(vf[1].split(",")[0]);
  /*if (vf[2]) {
    this.isZ = true;
    this.zIndex = this.propertyName.indexOf(vf[2]);
  }*/
}

ZtBCMatrixChart.prototype._SetCalculationDataset = function () {
  var i,
  s_idx = -1,
  k_idx = -1,
  x_from = -1,
  x_to = -1,
  y_from = -1,
  y_to = -1,
  index;
  s_idx = this.additionalPropertyName.indexOf(this.objConfig.labelSeries);
  if (!Empty(this.objConfig.keyField))
    k_idx = this.additionalPropertyName.indexOf(this.objConfig.keyField);
  x_from = this.additionalPropertyName.indexOf(this.xFields[0]);
  if (this.xFields[1])
    x_to = this.additionalPropertyName.indexOf(this.xFields[1]);
  y_from = this.additionalPropertyName.indexOf(this.yFields[0]);
  if (this.yFields[1])
    y_to = this.additionalPropertyName.indexOf(this.yFields[1]);
  index = k_idx >= 0 ? k_idx : s_idx;

  this.quadrants = {};
  for (i = 0; i < this.additionalDataset.length; i++) {
    if (!(this.additionalDataset[i][index] in this.quadrants)) {
      this.quadrants[this.additionalDataset[i][index]] = {};
      this.quadrants[this.additionalDataset[i][index]].label = this.additionalDataset[i][s_idx];
      if (k_idx >= 0)
        this.quadrants[this.additionalDataset[i][index]].key = this.additionalDataset[i][k_idx];
      if (x_from >= 0)
        this.quadrants[this.additionalDataset[i][index]].x1 = this.additionalDataset[i][x_from];
      if (x_to >= 0)
        this.quadrants[this.additionalDataset[i][index]].x2 = this.additionalDataset[i][x_to];
      if (y_from >= 0)
        this.quadrants[this.additionalDataset[i][index]].y1 = this.additionalDataset[i][y_from];
      if (y_to >= 0)
        this.quadrants[this.additionalDataset[i][index]].y2 = this.additionalDataset[i][y_to];
    }
  }
}

ZtBCMatrixChart.prototype._SetLists = function () {
  // quadranti - colori e coordinate
  var idx = this.additionalPropertyName.indexOf(this.objConfig.labelSeries);
  this.seriesList = getList(idx, this.additionalDataset);
  if (!Empty(this.objConfig.keyField)) {
    idx = this.additionalPropertyName.indexOf(this.objConfig.keyField);
    this.orgSeriesList = getList(idx, this.additionalDataset);
  }
  else
    this.orgSeriesList = this.seriesList.slice();
  this.drawingSeries = this.orgSeriesList.slice()
  this.xFields = this.objConfig.xValues.split(",");
  this.yFields = this.objConfig.yValues.split(",");
  var i;
  this.xValues = [];
  for (i = 0; i < this.xFields.length; i++) {
    idx = this.additionalPropertyName.indexOf(this.xFields[i]);
    this.xValues = this.xValues.concat(getList(idx, this.additionalDataset));
  }
  this.xValues = this.xValues.unique();
  this.yValues = [];
  for (i = 0; i < this.yFields.length; i++) {
    idx = this.additionalPropertyName.indexOf(this.yFields[i]);
    this.yValues = this.yValues.concat(getList(idx, this.additionalDataset));
  }
  this.yValues = this.yValues.unique();  

  // elementi (categorie) da disegnare
  this.categoryList = getList(this.seriesIndex, this.dataSet);
  this.orgCategoryList = this.categoryList.slice();
  this.drawingCategories = this.orgCategoryList.slice();
  this.valueFields = this.objConfig.valueFields.split(';'); // path_x path_y
  this.allV_x = this.valueFields[0].split(",");
  this.allV_y = this.valueFields[1].split(",");
  this.allValues = [];
  /*for (i = 0; i < this.valueFields.length; i++) {
    this[this.valueFields[i] + "_values"] = getValues([this.valueFields[i]], this.propertyName, this.dataSet).unique();
    this.allValues = this.allValues.concat(this[this.valueFields[i] + "_values"]).unique();
  }*/
  this.classificationField = this.objConfig.classField;
  this.legendList = this.orgCategoryList.slice();
  this.rowLegendList = [];
}

ZtBCMatrixChart.prototype._SetScales = function () {
  var xtype = this.objConfig.additionalFieldsType[this.additionalPropertyName.indexOf(this.xFields[0])],
  ytype = this.objConfig.additionalFieldsType[this.additionalPropertyName.indexOf(this.yFields[0])];

  if (xtype == "N") {
    this.scaleX = d3.scaleLinear()
                    .domain([d3.min(this.xValues), d3.max(this.xValues)]);
    this.xValues.sort();
  }
  else
    this.scaleX = d3.scaleBand()
                    .domain(this.xValues)
                   // .padding(0.1);

  if (ytype == "N") {
    this.scaleY = d3.scaleLinear()
                    .domain([d3.max(this.yValues), d3.min(this.yValues)]);
    this.yValues.sort();
  }
  else
    this.scaleY = d3.scaleBand()
                    .domain(this.yValues)
                   // .padding(0.1);
  this.scaleX.__scaleType = xtype;
  this.scaleX.range([0, this.chartWidth]);
  this.scaleY.__scaleType = ytype;
  this.scaleY.range([0, this.chartHeight]);

  // sub-scales
  var x_sub = this.allV_x.length > 1 && xtype != "N",
  y_sub = this.allV_y.length > 1 && ytype != "N",
  i,
  //c_type,
  values;
  if (x_sub || y_sub) { // ho delle sottodivisioni di valori
    var subobj = {};
    for (i = 0; i < this.dataSet.length; i++) {
      var rec = this.dataSet[i],
      val_x_0 = rec[this.propertyName.indexOf(this.allV_x[0])],
      val_x_1 = rec[this.propertyName.indexOf(this.allV_x[1])],
      val_y_0 = rec[this.propertyName.indexOf(this.allV_y[0])],
      val_y_1 = rec[this.propertyName.indexOf(this.allV_y[1])];

      if (x_sub) {
        if (!("val_x" in subobj)) {
          subobj.val_x = {};
        }
        if (!(val_x_0 in subobj.val_x))
          subobj.val_x[val_x_0] = { scale: null, values: [] };
        if (subobj.val_x[val_x_0].values.indexOf(val_x_1) < 0)
          subobj.val_x[val_x_0].values.push(val_x_1);
      }

      if (y_sub) {
        if (!("val_y" in subobj)) {
          subobj.val_y = {};
        }
        if (!(val_y_0 in subobj.val_y))
          subobj.val_y[val_y_0] = { scale: null, values: [] };
        if (subobj.val_y[val_y_0].values.indexOf(val_y_1) < 0)
          subobj.val_y[val_y_0].values.push(val_y_1);
      } 
    }

    if (x_sub) {
      //c_type = this.objConfig.fieldsType[this.propertyName.indexOf(this.allV_x[1])];
      for (i = 0; i < this.xValues.length; i++) {
        if (this.xValues[i] in subobj.val_x) {  // potrebbe esserci un filtro
          values = subobj.val_x[this.xValues[i]].values;
          subobj.val_x[this.xValues[i]].scale = d3.scaleBand().domain(values);
          subobj.val_x[this.xValues[i]].scale.__scaleType = "C"//c_type;
          subobj.val_x[this.xValues[i]].scale.range([this._GetXYZRadius() + (i * this.scaleX.bandwidth()),
                                                    ((i + 1) * this.scaleX.bandwidth()) - this._GetXYZRadius()]);
        }
      }
    }

    if (y_sub) {
      //c_type = this.objConfig.fieldsType[this.propertyName.indexOf(this.allV_y[1])];
      for (i = 0; i < this.yValues.length; i++) {
        if (this.yValues[i] in subobj.val_y) {  // potrebbe esserci un filtro
          values = subobj.val_y[this.yValues[i]].values;
          /*if (c_type == "N") {
            subobj.val_y[this.yValues[i]].scale = d3.scaleLinear().domain([d3.max(values), d3.min(values)]);
            values.sort();
          }
          else*/
            subobj.val_y[this.yValues[i]].scale = d3.scaleBand().domain(values);
          subobj.val_y[this.yValues[i]].scale.__scaleType = "C"//c_type;
          subobj.val_y[this.yValues[i]].scale.range([this._GetXYZRadius() + (i * this.scaleY.bandwidth()),
                                                    ((i + 1) * this.scaleY.bandwidth()) - this._GetXYZRadius()]);
        }
      }
    }
    this.subScales = subobj;
  }
}

ZtBCMatrixChart.prototype._DrawChartPlotElements = function () {
  this._DrawAxis();
}

ZtBCMatrixChart.prototype._DrawAxis = function () {
  var opts = {};
  // x axis
  opts.type = "domain";
  opts.position = "Bottom";
  opts.x = this._GetDomainAxisXPosition();
  opts.y = this._GetDomainAxisYPosition();
  opts.scale = this.scaleX;
  opts.defSettings = this.defSettings.domainAxis;
  opts.font = this.defSettings.domainAxis.domainFont;
  opts.ticks = this.xValues;
  ZtMekkoChart.prototype._DrawGenericAxis.call(this, opts);

  // y axis
  opts.type = "value";
  opts.position = "Left";
  opts.x = this._GetValueAxisXPosition();
  opts.y = this._GetValueAxisYPosition();
  opts.scale = this.scaleY;
  opts.defSettings = this.defSettings.valueAxis;
  opts.font = this.defSettings.valueAxis.valueFont;
  opts.ticks = this.yValues;
  ZtMekkoChart.prototype._DrawGenericAxis.call(this, opts);

  var i;

  // valori sub
  if (this.objConfig.subAxis && this.subScales) {
    var vfields;
    if (this.subScales.val_x) {
      vfields = this.xValues;
      for (i = 0; i < vfields.length; i++) {
        if (vfields[i] in this.subScales.val_x) {
          opts.type = "domain";
          opts.position = "Bottom";
          opts.x = this._GetDomainAxisXPosition();
          opts.y = this._GetDomainAxisYPosition();
          opts.scale = this.subScales.val_x[vfields[i]].scale;
          opts.defSettings = this.defSettings.domainAxis;
          opts.font = this.defSettings.domainAxis.domainFont;
          opts.ticks = this.subScales.val_x[vfields[i]].values;
          opts.id = "_sub" + i;
          ZtMekkoChart.prototype._DrawGenericAxis.call(this, opts);
        }
      }
    }

    if (this.subScales.val_y) {
      vfields = this.yValues;
      for (i = 0; i < vfields.length; i++) {
        if (vfields[i] in this.subScales.val_y) {
          opts.type = "value";
          opts.position = "Left";
          opts.x = this._GetValueAxisXPosition();
          opts.y = this._GetValueAxisYPosition();
          opts.scale = this.subScales.val_y[vfields[i]].scale;
          opts.defSettings = this.defSettings.valueAxis;
          opts.font = this.defSettings.valueAxis.valueFont;
          opts.ticks = this.subScales.val_y[vfields[i]].values;
          opts.id = "_sub" + i;
          ZtMekkoChart.prototype._DrawGenericAxis.call(this, opts);
        }
      }
    }
  }
}

ZtBCMatrixChart.prototype._SetAxisColor = function () {
  ZtMekkoChart.prototype._SetAxisColor.call(this);
  // valori sub
  if (this.objConfig.subAxis && this.subScales) {
    var vfields,
    i;
    if (this.subScales.val_x) {
      vfields = this.xValues;
      for (i = 0; i < vfields.length; i++)
      this.SetAxisColor("domain", "y2", 3, null, "_sub" + i);
    }
    if (this.subScales.val_y) {
      vfields = this.yValues;
      for (i = 0; i < vfields.length; i++)
        this.SetAxisColor("value", "x2", -3, null, "_sub" + i);
    }
  }
}

ZtBCMatrixChart.prototype._SetAxisFont = function () {
  ZtMekkoChart.prototype._SetAxisFont.call(this);
  // valori sub
  if (this.objConfig.subAxis && this.subScales) {
    var vfields,
    i;
    if (this.subScales.val_x) {
      vfields = this.xValues;
      for (i = 0; i < vfields.length; i++)
        this.SetAxisFont("domain", "_sub" + i);
    }
    if (this.subScales.val_y) {
      vfields = this.yValues;
      for (i = 0; i < vfields.length; i++)
        this.SetAxisFont("value", "_sub" + i);
    }
  }
}

ZtBCMatrixChart.prototype._DrawChartElements = function () {
  // disegno i quadranti
  this._DrawQuadrants();

  // posiziono gli elementi
  var group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")");
  this.DrawXYZ(group, this.dataSet, this.xIndex, this.yIndex, this.seriesIndex, this.zIndex, true);
}

ZtBCMatrixChart.prototype._GetXCoordinate = function (record, xIndex) {
  var scaleX = this.scaleX,
  value = record[xIndex];
  if (this.subScales && this.subScales.val_x && (record[xIndex] in this.subScales.val_x)) {
    scaleX = this.subScales.val_x[record[xIndex]].scale;
    value = record[this.propertyName.indexOf(this.allV_x[1])];
  }

  if (scaleX.__scaleType == "N")
    return scaleX(value);
  return scaleX(value) + scaleX.bandwidth() / 2;
}

ZtBCMatrixChart.prototype._GetYCoordinate = function (record, yIndex/*, serKey*/) {
  var scaleY = this.scaleY,
  value = record[yIndex];
  if (this.subScales && this.subScales.val_y && (record[yIndex] in this.subScales.val_y)) {
    scaleY = this.subScales.val_y[record[yIndex]].scale;
    value = record[this.propertyName.indexOf(this.allV_y[1])];
  }

  if (scaleY.__scaleType == "N")
    return scaleY(value);
  return scaleY(value) + scaleY.bandwidth() / 2;
}

ZtBCMatrixChart.prototype._GetZCoordinate = function(data, zIndex, idx) {
  // faccio check overlap perche' il raggio può essere dimensionale
  if (idx >= 0) {
    var item = this.items[idx];
    if (this._HasOverlap(item) && this.defSettings.overlap.radius != "default") {
      if (this.defSettings.overlap.radius == "bigger")  // non serve un calcolo proporzionale, fisso raggio
        return Math.floor(this._GetXYZRadius()) * 2;
      if (Empty(this._ovrlap._oLen))
        this._SetMinMaxOverlap();
      return this._ovrlap._oLen.scale(this._GetOverlapObject(item).length);
    }
  }
  return this._GetXYZRadius();
}

ZtBCMatrixChart.prototype._GetXYZRadius = function () {
  return 4.5;
}

ZtBCMatrixChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var idx = -1,
  i,
  styleObj,
  progrColor,
  _this = this,
  xtype = this.objConfig.additionalFieldsType[this.additionalPropertyName.indexOf(this.xFields[0])],
  ytype = this.objConfig.additionalFieldsType[this.additionalPropertyName.indexOf(this.yFields[0])],
  item,
  classif;

  // quadranti
  for (i = 0; i < this.orgSeriesList.length; i++) {
    item = this.quadrants[this.orgSeriesList[i]];
    idx = this.seriesList.indexOf(item.label);
    styleObj = {};
    styleObj.fill = this.colorSet[idx].color;
    styleObj.fill9opacity = 0.75;
    d3.select(item.itm).attr("style", makeStyleHTMLString(styleObj, d3.select(item.itm).attr("style")));
  }

  progrColor = this.orgSeriesList.length;

  for (i = 0; i < this.items.length; i++) {
    idx = this.orgCategoryList.indexOf(this.items[i].series);
    if (idx >= 0) {
      this.items[i].idx = idx;
      this.items[i].sidx = i;
      this.items[i].category = this.items[i].series;
      this.items[i].keyField = "";
      classif = this.orgSeriesList.filter(function (d) { 
        var classf = _this.quadrants[d],
        found = false;
        if (xtype == "N") {
          if ("x1" in classf) {
            if ("x2" in classf) {
              found = (_this.items[i].x >= classf.x1 && _this.items[i].x < classf.x2);
            }
          }
        }
        else
          found = (_this.items[i].x == classf.x1 || _this.items[i].x == classf.x2);
        
        if (!found)
          return false;
        
        if (ytype == "N") {
          if ("y1" in classf) {
            if ("y2" in classf) {
              found = (_this.items[i].y >= classf.y1 && _this.items[i].y < classf.y2);
            }
          }
        }
        else
          found = (_this.items[i].y == classf.y1 || _this.items[i].y == classf.y2);

        return found;
      });
      if (classif.length == 1 && !Empty(classif[0]))
        this.items[i].quadrant = this.quadrants[classif[0]].label;
      this.items[i].color = this.colorSet[progrColor + idx];
      styleObj = {};
      styleObj.fill = this.colorSet[progrColor + idx].color;
      styleObj.stroke = this.colorSet[progrColor + idx].color;
      if (this._HasOverlap(this.items[i])) {
        var ovr_array = this._GetOverlapObject(this.items[i]);
        if (ovr_array.indexOf(this.items[i].position) < (ovr_array.length - 1)) {
          styleObj.fill9opacity = 0;
          styleObj.stroke9opacity = 0;
        }
        else {
          if (this.defSettings.overlap.type == "contrast") {
            styleObj.fill = this.defSettings.overlap.color || "#FAFAFA";
            styleObj.stroke9width = "2px";
          }
          else if (this.defSettings.overlap.type == "border") {
            var clone = this.items[i].itm.cloneNode();
            d3.select(clone)
              .attr("r", this.items[i].r * 1.5)
              .style("fill-opacity", 0)
              .style("fill", "none")
              .style("stroke", this.colorSet[progrColor + idx].color)
            this.items[i].itm.parentNode.appendChild(clone);
          }
        }
      }
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));

      // memorizzo info sub-xy
      if (this.subScales) {
        // x
        if (this.subScales.val_x && (this.items[i].x in this.subScales.val_x))
          this.items[i].sub_x = this.dataSet[this.items[i].idx][this.propertyName.indexOf(this.allV_x[1])];
        // y
        if (this.subScales.val_y && (this.items[i].y in this.subScales.val_y))
          this.items[i].sub_y = this.dataSet[this.items[i].idx][this.propertyName.indexOf(this.allV_y[1])];
      }

    }
  }
}

ZtBCMatrixChart.prototype._GetSeriesColors = function () {
  return this.colorSet.slice(this.orgSeriesList.length);
}

ZtBCMatrixChart.prototype._DrawQuadrants = function () {
  var container = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_quad_svgGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
  _this = this,
  sList = this.orgSeriesList;

  for (var i = 0; i < sList.length; i++) {
    if (sList[i] in this.quadrants) {
      var quad = this.quadrants[sList[i]],
      qid = this.chartId + "grpQuads_" + replaceSpecialCharsForID(quad.label),
      grp,
      itm;
      if (Empty(this.svg.select("#" + qid).node())) {
        grp = container.append("g")
              .attr("id", qid);
      }
      else
        grp = this.svg.select("#" + qid);

      itm = grp.append("rect")
        .attr("class", "quad quad_ " + i + "TRANSP")
        .attr("x", this.scaleX(quad.x1))
        .attr("y", this.scaleY(quad.y2 || quad.y1))
        .attr("width", function () {
          if (_this.scaleX.__scaleType == "N")
            quad.width = Math.abs(_this.scaleX(quad.x2) - _this.scaleX(quad.x1));
          else if (quad.x2 && quad.x1 != quad.x2)
            quad.width = _this.scaleX(quad.x1) + _this.scaleX.bandwidth();
          else 
            quad.width = _this.scaleX.bandwidth();
          return quad.width;
        })
        .attr("height", function () {
          if (_this.scaleY.__scaleType == "N")
            quad.height = Math.abs(_this.scaleY(quad.y2) - _this.scaleY(quad.y1));
          else if (quad.y2 && quad.y1 != quad.y2)
            quad.height = _this.scaleY(quad.y1) + _this.scaleY.bandwidth();
          else 
            quad.height = _this.scaleY.bandwidth();
          return quad.height;
        });
      quad.itm = itm.node();
    }
  }
}

ZtBCMatrixChart.prototype._DrawQuadrantLabels = function () {
  if (Empty(this.defSettings.quadrants.labels.type) || this.defSettings.quadrants.labels.type == "hide")
    return;
  
  var type = this.defSettings.quadrants.labels.type,
  total = this.items.length,
  font = appliedFont(this.defSettings, this.defSettings.quadrants.labels, this.defSettings.quadrants.labels.font),
  _this = this,
  gelem,
  gnode,
  gbbox,
  offset = 5,
  th,
  vh,
  ph,
  label,
  value,
  itms,
  count = { val: 0, perc: 0 },
  v_prec = this.defSettings.quadrants.labels.precision.value || 0,
  p_prec = 2;
  if (!isNaN(this.defSettings.quadrants.labels.precision.percentage) && 
    (!Empty(this.defSettings.quadrants.labels.precision.percentage) || this.defSettings.quadrants.labels.precision.percentage == 0)
  )
    p_prec = this.defSettings.quadrants.labels.precision.percentage;

  for (var i = 0; i < this.seriesList.length; i++) {
    gelem = this.svg.select("#" + this.chartId + "grpQuads_" + replaceSpecialCharsForID(this.seriesList[i]));
    gnode = gelem.node();
    itms = 0;
    count.val = 0;
    count.perc = 0;
    if (!Empty(gnode)) {
      gbbox = getDomNodeSizes(gnode);
      th = (type == "val" || type == "perc") ? 0 : getOffsetHeight(this.seriesList[i], font, this.chartId);
      if (type == "laball" || type.indexOf("val") >= 0 || type.indexOf("perc") >= 0) {
        itms = this.items.filter(function(d){ if (d.quadrant == _this.seriesList[i]) return d; });
        count.val = (itms.length).toFixed(v_prec);
        count.perc = ((count.val * 100) / total).toFixed(p_prec);
        vh = getOffsetHeight(count.val, font, this.chartId);
        ph = getOffsetHeight(count.perc + "%", font, this.chartId);
        value = gelem.append("text")
          .attr("x", function () {
            if (_this.defSettings.quadrants.labels.alignment == "left")
              return gbbox.x + offset;
            if (_this.defSettings.quadrants.labels.alignment == "right")
              return gbbox.x + gbbox.width - offset;
            return gbbox.x + (gbbox.width / 2); // center
          })
          .attr("y", function () {
            if (_this.defSettings.quadrants.labels.position == "top") {
              return gbbox.y + th + Math.max(vh, ph);
            }
            return gbbox.y + gbbox.height - offset; // bottom
          })
          .text(function () {
            if (type == "laball")
              return count.val + " (" + count.perc + "%)";
            if (type.indexOf("val") >= 0)
              return count.val;
            return count.perc + "%";
          })
          .style("text-anchor", function () {
            if (_this.defSettings.quadrants.labels.alignment == "left")
              return "start";
            if (_this.defSettings.quadrants.labels.alignment == "right")
              return "end";
            return "middle";
          })
        setFont(value, font, this);
      }

      if (type != "val" && type != "perc") {
        label = gelem.append("text")
          .attr("x", function () {
            if (_this.defSettings.quadrants.labels.alignment == "left")
              return gbbox.x + offset;
            if (_this.defSettings.quadrants.labels.alignment == "right")
              return gbbox.x + gbbox.width - offset;
            return gbbox.x + (gbbox.width / 2); // center
          })
          .attr("y", function () {
            if (_this.defSettings.quadrants.labels.position == "top")
              return gbbox.y + th;
            return gbbox.y + gbbox.height - offset - Math.max(vh, ph); // bottom
          })
          .text(this.seriesList[i])
          .style("text-anchor", function () {
            if (_this.defSettings.quadrants.labels.alignment == "left")
              return "start";
            if (_this.defSettings.quadrants.labels.alignment == "right")
              return "end";
            return "middle";
          })
        setFont(label, font, this);
      }
    }
  }
}

ZtBCMatrixChart.prototype._SupportChangeOrder = function () {
  return false;
}

ZtBCMatrixChart.prototype._SupportFilter = function () {
  return false;
}

ZtBCMatrixChart.prototype._GetPrecisionFromValues = function (type) {
  var prec = 0,
  myVal;
  if (type == "value")
    myVal = this.yValues;
  else if (type == "domain")
    myVal = this.xValues;
  for (var i = 0; i < myVal.length; i++)
    prec = Math.max(prec, decimalPlaces(myVal[i]));
  return prec;
}

ZtBCMatrixChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
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
      .delay(item.idx * duration/div)
      .duration(duration/div)
      .ease(d3.easeLinear)
      .attr("cx", cx)
      .attr("cy", cy)
      .attr("r", r);
}

ZtBCMatrixChart.prototype._GetAnimatedDivisor = function () {
  return this.orgSeriesList.length;
}

ZtBCMatrixChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "",
  _this = this,
  val,
  xtype = this.objConfig.additionalFieldsType[this.additionalPropertyName.indexOf(this.xFields[0])],
  ytype = this.objConfig.additionalFieldsType[this.additionalPropertyName.indexOf(this.yFields[0])];

  purl += "&category=" + URLenc(itemObject.category);
  purl += "&serie=" + URLenc(itemObject.quadrant);

  val = itemObject.x;
  if (!Empty(val)) {
    if (xtype == "N")
      val = parseFloat(itemObject.x);
    purl += "&x=" + URLenc(val);
  }
  
  val = itemObject.y;
  if (!Empty(val)) {
    if (ytype == "N")
      val = parseFloat(itemObject.y);
    purl += "&y=" + URLenc(val);
  }
  
  val = parseFloat(itemObject.z);
  if (!isNaN(val))
    purl += "&z=" + URLenc(val);

  if (!Empty(_this.defSettings.axisLabel.xLabel))
    purl += "&xlabel=" + URLenc(_this.defSettings.axisLabel.xLabel);
  
  if (!Empty(_this.defSettings.axisLabel.yLabel))
    purl += "&ylabel=" + URLenc(_this.defSettings.axisLabel.yLabel);
  return purl;
}

ZtBCMatrixChart.prototype._CheckOverlap = function (item, itempos) {
  if (Empty(this._ovrlap))
    this._ovrlap = {};

  var coords = item.coordinates,
  crdstr = "c_" + coords.x + "_" + coords.y;
  if (!(crdstr in this._ovrlap))
    this._ovrlap[crdstr] = [];
  this._ovrlap[crdstr].push(itempos);
}

ZtBCMatrixChart.prototype._GetOverlapObject = function (item) {
  if (this._ovrlap) {
    var coords = item.coordinates,
    cstr = "c_" + coords.x + "_" + coords.y;
    if (cstr in this._ovrlap) {
      return this._ovrlap[cstr];
    }
  }
  return null;
}

ZtBCMatrixChart.prototype._CheckIdentityItem = function (itemOrg, itemOth) {
  return (itemOrg.quadrant == itemOth.quadrant && 
          itemOrg.x == itemOth.x && 
          itemOrg.y == itemOth.y &&
          itemOrg.category == itemOth.category);
}

ZtBCMatrixChart.prototype.AppendHoverItem = function (item) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  if (item) {
    var itemObject = this._GetItems()[d3.select(item).attr("item-index")],
    clone = this._GetItemClone(item, itemObject);
    mRefChart._hoverItem = itemObject;
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
        mRefChart.RemoveHoverTimeout();
        delete mRefChart._hoverItem;
      })
      .on("click", function () {
        _this._ApplyClick(itemObject, d3.mouse(this));
      });

    mRefChart._d3mouse = d3.mouse(item);
    mRefChart._d3event = d3.event;
    setTimeout(function(mRefChart, item, itemObject, clone){
      if (mRefChart._hoverItem) {
        if (mRefChart._CheckIdentityItem(mRefChart._hoverItem, itemObject)) {
          item.parentNode.appendChild(clone);
          _this.ShowTooltip(mRefChart, item, itemObject);
        }
      }
    }, 50, mRefChart, item, itemObject, clone);
    
    this.MoveRangeCursor(itemObject.value);
  }
}

ZtBCMatrixChart.prototype._HasOverlap = function (itemObject) {
  var ovr = this._GetOverlapObject(itemObject);
  if (!Empty(ovr))
    return ovr.length > 1;
  return false;
}

ZtBCMatrixChart.prototype._GetParametersStringForOverlapTooltip = function (item, itemObject) {
  var coords = itemObject.coordinates,
  cstr = "c_" + coords.x + "_" + coords.y,
  itms_i = this._ovrlap[cstr],
  allItems = this._GetItems(),
  ser = "",
  cols = "",
  purl = "";

  for (var i = 0; i < itms_i.length; i++) {
    ser += ("::" + allItems[itms_i[i]].category);
    cols += ("::" + allItems[itms_i[i]].color.color);
  }

  purl += "&category=" + URLenc(ser.slice(2));
  purl += "&colors=" + URLenc(Strtran(cols.slice(2), "#", ""));
  purl += "&serie=" + URLenc(itemObject.quadrant);
  purl += "&x=" + URLenc(itemObject.x);
  purl += "&y=" + URLenc(itemObject.y);
  purl += "&num=" + URLenc(itms_i.length);

  return purl;
}

ZtBCMatrixChart.prototype._GetParametersStringForOverlapClick = function (itemObject) {
  var itms_i = this._GetOverlapObject(itemObject),
  allItems = this._GetItems(),
  ser = "",
  cols = "",
  purl = "";

  for (var i = 0; i < itms_i.length; i++) {
    ser += ("::" + allItems[itms_i[i]].category);
    cols += ("::" + allItems[itms_i[i]].color.color);
  }

  purl += "&category=" + URLenc(ser.slice(2));
  purl += "&colors=" + URLenc(Strtran(cols.slice(2), "#", ""));
  purl += "&idxs=" + URLenc(itms_i.join("::"));
  purl += "&num=" + URLenc(itms_i.length);

  return purl;
}

ZtBCMatrixChart.prototype._ApplyClick = function (itemObject, evt) {
  if (!this._ZtChart.enableClick)
    return;
  if (this._HasOverlap(itemObject))
    this.DrawDefaultOverlapClick(itemObject);
  else 
    StdChart.prototype._ApplyClick.call(this, itemObject, evt)
}

ZtBCMatrixChart.prototype._ApplyClickOverlap = function (itemObject, evt) {
  StdChart.prototype._ApplyClick.call(this, itemObject, evt);
  this.RemoveHoverTimeout();
  delete this._hoverItem;
}

ZtBCMatrixChart.prototype._SetMinMaxOverlap = function () {
  var ov_key = Object.keys(this._ovrlap),
  min_len = 0,
  max_len = 0,
  i;
  for (i = 0; i < ov_key.length; i++) {
    if (this._ovrlap[ov_key[i]].length == 1)
      continue;
    if (Empty(min_len) && Empty(max_len)) {
      min_len = this._ovrlap[ov_key[i]].length;
      max_len = this._ovrlap[ov_key[i]].length;
    }
    min_len = Math.min(min_len, this._ovrlap[ov_key[i]].length);
    max_len = Math.max(max_len, this._ovrlap[ov_key[i]].length);
  }

  var scaleRadius = d3.scaleLinear()
    .domain([min_len, max_len])
    .range([7, 20])

  this._ovrlap._oLen = { min: min_len, max: max_len, scale: scaleRadius }
}

ZtBCMatrixChart.prototype.DrawValueLabels = function () {
  // ev. labels sui quadranti
  this._DrawQuadrantLabels();

  StdChart.prototype.DrawValueLabels.call(this);
}

ZtBCMatrixChart.prototype._GetChartMarginsObject = function (chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber
  , localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, rangebandslabels) {
  var ret = ZtBarChart.prototype._GetChartMarginsObject.call(this, chartId, settings, categoryList, dataOrder
            , domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, rangebandslabels),
  myM,
  i,
  appliedfont,
  vfields,
  _this = this,
  tmptext;

  // valori sub
  if (settings.domainAxis.show && this.objConfig.subAxis && this.subScales && this.subScales.val_x) {
    appliedfont = appliedFont(settings, settings.domainAxis, settings.domainAxis.domainFont);
    vfields = this.xValues;
    tmptext = [];
    for (i = 0; i < vfields.length; i++) {
      if (vfields[i] in this.subScales.val_x)
        tmptext.push(getMaxWordLength(this.subScales.val_x[vfields[i]].values, domprec, _this.localeLangFormat.numberFormat(",." + domprec + "f")));
    }
    myM = getGenericLabelConf(appliedfont);
    myM.textorientation = 90;
    myM.offset = 5;
    myM.text = getMaxWordLength(tmptext, domprec, _this.localeLangFormat.numberFormat(",." + domprec + "f"));
    if (!Empty(myM.text))
      ret.bottom.push(myM);
  }

  if (settings.valueAxis.show && this.objConfig.subAxis && this.subScales && this.subScales.val_y) {
    appliedfont = appliedFont(settings, settings.valueAxis, settings.valueAxis.valueFont);
    vfields = this.yValues;
    tmptext = [];
    for (i = 0; i < vfields.length; i++) {
      if (vfields[i] in this.subScales.val_y)
        tmptext.push(getMaxWordLength(this.subScales.val_y[vfields[i]].values, valprec, _this.localeLangFormat.numberFormat(",." + valprec + "f")));
    }
    myM = getGenericLabelConf(appliedfont);
    myM.textorientation = 0;
    myM.offset = 5;
    myM.text = getMaxWordLength(tmptext, valprec, _this.localeLangFormat.numberFormat(",." + valprec + "f"));
    if (!Empty(myM.text))
      ret.left.push(myM);
  }

  return ret;
}

ZtBCMatrixChart.prototype._SetValueAxisPositions = function () {
  // gestisco le sub scale
  if (this.objConfig.subAxis && this.subScales) {
    var scs,
    progr,
    msize,
    maxis,
    offset,
    sID,
    maxsize,
    i;

    if (this.subScales.val_x) {
      scs = this.xValues;
      progr = this._GetDomainAxisYPosition();
      msize = 0;
      maxis;
      offset = 5;
      sID;
      maxsize = 0;

      for (i = 0; i < scs.length; i++) {
        sID = "sub" + i;
        maxis = d3.select("#" + this.chartId + "domainAxisGroup_" + sID).node();
        if (maxis) {
          msize = getDomNodeHeight(maxis) + offset;
          maxsize = Math.max(maxsize, msize);
        }
      }

      maxis = d3.select("#" + this.chartId + "domainAxisGroup").node();
      if (maxis)
        d3.select(maxis).attr("transform", "translate(" + [this._GetDomainAxisXPosition(), progr + maxsize] + ")");
    }

    if (this.subScales.val_y) {
      scs = this.yValues;
      progr = this._GetValueAxisXPosition();
      msize = 0;
      maxis;
      offset = 15;
      sID;
      maxsize = 0;

      for (i = 0; i < scs.length; i++) {
        sID = "sub" + i;
        maxis = d3.select("#" + this.chartId + "valueAxisGroup_" + sID).node();
        if (maxis) {
          msize = getDomNodeWidth(maxis) + offset;
          maxsize = Math.max(maxsize, msize);
        }
      }

      maxis = d3.select("#" + this.chartId + "valueAxisGroup").node();
      if (maxis)
        d3.select(maxis).attr("transform", "translate(" + [progr - maxsize, this._GetValueAxisYPosition()] + ")");
    }
  }
}

ZtBCMatrixChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv, i,
  coords = [],
  fields = [],
  labval = [];
  if (!Empty(this.objConfig.fieldsGrid)) {
    fields = this.objConfig.fieldsGrid.slice();
    for (i = 0; i < fields.length; i++) {
      var coltitle = "";
      if (fields[i] == this.objConfig.labelFieldKey) {
        if (!Empty(this.objConfig.labelsGrid) && !Empty(this.objConfig.labelsGrid.key))
          coltitle = this.objConfig.labelsGrid.key;
      }
      else if (fields[i] == this.objConfig.labelField) {
        if (!Empty(this.objConfig.labelsGrid) && !Empty(this.objConfig.labelsGrid.domain))
          coltitle = this.objConfig.labelsGrid.domain;
      }
      else if (fields[i] == this.objConfig.classField) {
        coltitle = "class";
        if (!Empty(this.objConfig.labelsGrid) && !Empty(this.objConfig.labelsGrid.serie))
          coltitle = this.objConfig.labelsGrid.serie;
      }
      else {
        labval = [];
        if (!Empty(this.objConfig.labelsGrid.values))
          labval = this.objConfig.labelsGrid.values.split(",");
        if (fields[i] == this.valueFields[0]) {
          coltitle = "x";
          if (!Empty(labval[0]))
            coltitle = labval[0];
        }
        else if (fields[i] == this.valueFields[1]) {
          coltitle = "y";
          if (!Empty(labval[1]))
            coltitle = labval[1];
        }
      }
      coords.push(coltitle);
    }
  }
  else {
    if (!Empty(this.objConfig.labelFieldKey)) {
      coords.push("");
      fields.push(this.objConfig.labelFieldKey);
    }
    coords.push("");
    fields.push(this.objConfig.labelField);
    coords.push("class");
    fields.push(this.objConfig.classField);
    coords.push("x");
    fields.push(this.valueFields[0]);
    coords.push("y");
    fields.push(this.valueFields[1]);

    if (!Empty(this.objConfig.labelsGrid)) {
      var progrIndex = 0;
      if (!Empty(this.objConfig.labelFieldKey)) {
        if (!Empty(this.objConfig.labelsGrid.key))
          coords[progrIndex] = this.objConfig.labelsGrid.key;
        progrIndex++;
      }
      if (!Empty(this.objConfig.labelsGrid.domain))
        coords[progrIndex] = this.objConfig.labelsGrid.domain;
      progrIndex++;
      if (!Empty(this.objConfig.labelsGrid.serie))
        coords[progrIndex] = this.objConfig.labelsGrid.serie;
      progrIndex++;
      if (!Empty(this.objConfig.labelsGrid.values)) {
        labval = this.objConfig.labelsGrid.values.split(",");
        if (!Empty(labval[0]))
          coords[progrIndex] = labval[0];
        progrIndex++;
        if (!Empty(labval[1]))
          coords[progrIndex] = labval[1];
      }
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
      //this._SetGridCellStyleAndEvents(cell, div3, vals[b], b);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}