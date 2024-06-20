function ZtChordChart() {
  StdChart.apply(this, ["CHORD", "e902"]);
  this.multiSVG = true;
  this.arcs = [];
}
ZtChordChart.prototype = Object.create(ZtPieChart.prototype);
ZtChordChart.prototype.constructor = ZtChordChart;

ZtChordChart.prototype._SetFieldsIndexes = function () {
  ZtMatrixChart.prototype._SetFieldsIndexes.call(this);
}

ZtChordChart.prototype._SetLists = function () {
  ZtMatrixChart.prototype._SetLists.call(this);
}

ZtChordChart.prototype._SetCalculationDataset = function () {
  var fobj = getMatrixDependencies(this.dataSet, this.levelsFields, this.valueFields, this.propertyName, this.levelsLabelFields);
  this.calcDataset = fobj.matrix;
  if (fobj.array)
    this.orgCategoryList = this.categoryList = fobj.array;
  if (!Empty(fobj.arrayLabels)) {
    this.categoryList = fobj.arrayLabels;
    this.orgCategoryList = fobj.array;
  }

  this.orgSeriesList = this.legendList = this.categoryList.slice();
}

ZtChordChart.prototype._DrawChartElements = function () {
  var group = this.renderer.append("g")
      .attr("id", this.chartId + this.type + "_elementGroup")
      .attr("transform","translate(" + [this.margin.left + this.chartWidth / 2, this.margin.top + this.chartHeight / 2] + ")"),
  radius,
  innerRadius;

  radius = Math.min(this.chartWidth, this.chartHeight) / 2;
  radius = radius - radius * 0.05;  // tolgo il 5% per dare un po' di spazio al disegno
  this.radius = radius;
  innerRadius = this._GetInnerRadius();

  this.DrawChord(group, this.calcDataset, radius, innerRadius);
}

ZtChordChart.prototype._SetElementsColor = function () {
  this.SetColorSet();
  var styleObj,
  i;
  for (i = 0; i < this.items.length; i++) {
    styleObj = {};
    styleObj.fill = this.colorSet[this.items[i].source].color;
    styleObj.stroke = this.colorSet[this.items[i].source].color;
    styleObj.fill9opacity = 0.6;
    styleObj.stroke9width = 0.5 + "px";
    d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    this.items[i].color = { color: this.colorSet[this.items[i].source].color, gradient: "" };
  }

  for (i = 0; i < this.orgCategoryList.length; i++)
    d3.select(".arc_" + i).attr("style", makeStyleHTMLString({ fill: this.colorSet[i].color }, d3.select(".arc_" + i).attr("style")));
}

ZtChordChart.prototype._GetRadius = function () {
  return this.radius;
}

ZtChordChart.prototype._GetDivisor = function () {
  return 1;
}

ZtChordChart.prototype._GetInnerRadius = function (radius) {
  radius = radius || this._GetRadius();
  if (Empty(this.defSettings.radius) || isNaN(this.defSettings.radius.inner))
    return radius * 0.25;
  else
    return radius * (this.defSettings.radius.inner / 100);
}

ZtChordChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration) {
  var div = this._GetAnimatedDivisor(),
  elem = item.itm,
  _this = this,
  totLen;
  
  if (item.isArc) {
    d3.select(elem)
    .style("opacity", 0)
    .transition()
      .delay(item.idx * (duration / div))
      .duration(duration / div)
      .ease(d3.easeLinear)
      .style("opacity", 1)
      .attrTween("d", arcTween)
      .on("end", function (d) {
        _this._lastValueObj = { startAngle: d.endAngle, endAngle: d.endAngle };
      })
  }
  else {
    totLen = elem.getTotalLength();
    d3.select(elem)
      .attr("stroke-dasharray", totLen + " " + totLen)
      .attr("stroke-dashoffset", totLen)
      .style("fill-opacity", 0)
      .transition()
        .delay((duration / div) + (item.source * duration / div))
        .duration(duration / div)
        .ease(d3.easeLinear)
        .attr("stroke-dashoffset", 0)
        .style("fill-opacity", 0.6);
  }

  function arcTween(a) {
    var i = d3.interpolate(_this._lastValueObj, a),
    arc = d3.arc()
      .innerRadius(_this._GetInnerRadius())
      .outerRadius(_this._GetRadius());

    return function(t) {
      return arc(i(t));
    };
  }
}

ZtChordChart.prototype._GetAnimatedDivisor = function () {
  return this.categoryList.length * 2;
}

ZtChordChart.prototype._AnimateChartElements = function () {
  var i,
  item;
  this._lastValueObj = { startAngle: 0, endAngle: 0 };
  for (i = 0; i < this.arcs.length; i++) {
    item = {
      isArc : true,
      itm : this.arcs[i],
      idx : i
    };
    this._AnimateItem(item, null, this.defSettings.animation.duration);
  }

  for (i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;
    this._AnimateItem(this.items[i], null, this.defSettings.animation.duration);
  }
}

ZtChordChart.prototype._GetParametersStringForTooltip = function (item/*, itemObject*/) {
  var purl = "";
  purl += "&source=" + URLenc(item.sourceDesc);
  purl += "&target=" + URLenc(item.targetDesc);
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

ZtChordChart.prototype._GetParametersStringForLink = function (item) {
  var purl = "",
  linkObj = this.linkObj,
  valueName = Empty(linkObj.valuename) ? "value" : linkObj.valuename;

  purl += "source=" + URLenc(item.sourceDesc);
  purl += "&target=" + URLenc(item.targetDesc);
  if (!Empty(item.value)) {
    var val = item.value;
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
      }
    }
    purl += "&" + valueName + "=" + URLenc(val);
  }
  return purl;
}

ZtChordChart.prototype._GetItemObj = function (itemObject) {
  var row = -1,
  _this = this;
  this._ZtChart.orgData.filter(function (rec, index) {
    if (rec[_this.levelsIndex[_this.levelsFields[0]]] == _this.categoryList[itemObject.source] &&
        rec[_this.levelsIndex[_this.levelsFields[1]]] == _this.categoryList[itemObject.target] ) {
          row = index;
          return true;
        }
    // rovescio
    else if (rec[_this.levelsIndex[_this.levelsFields[1]]] == _this.categoryList[itemObject.source] &&
        rec[_this.levelsIndex[_this.levelsFields[0]]] == _this.categoryList[itemObject.target] ) {
        row = index;
        return true;
      }
    return false;
  });

  var ret = {
    source: this.orgCategoryList[itemObject.source],
    target: this.orgCategoryList[itemObject.target],
    sourceDesc: this.categoryList[itemObject.source],
    targetDesc: this.categoryList[itemObject.target],
    value: Empty(this.valueFields) ? null : itemObject.value,
    rowIdx: row,
    categoryCode: itemObject.categoryCode,
    isSelected : itemObject.isSelected,
    multidimCurrentKey : this.appliedKey,
    color: itemObject.color
  };
  return ret;
}

ZtChordChart.prototype._GetReferredList = function () {
  return this.legendList;
}

ZtChordChart.prototype._GetDrawingList = function () {
  return this.legendList;
}

ZtChordChart.prototype._GetLegendList = function () {
  return this.legendList;
}

ZtChordChart.prototype._CreateGrid = function (thead, tbody1) {
  return ZtMatrixChart.prototype._CreateGrid.call(this, thead, tbody1);
}

ZtChordChart.prototype._GetGridCellValue = function (value, isValue, record) {
  return ZtMatrixChart.prototype._GetGridCellValue.call(this, value, isValue, record);
}

ZtChordChart.prototype._FindItemForGrid = function (record) {
  return ZtMatrixChart.prototype._FindItemForGrid.call(this, record);
}

ZtChordChart.prototype._GetItemForGrid = function (item) {
  return ZtMatrixChart.prototype._GetItemForGrid.call(this, item);
}