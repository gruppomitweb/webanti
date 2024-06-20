function ZtTreeChart(type) {
  ZtSunburstChart.apply(this, [type]);
  this.viewBreadcrumb = false;
  this.byCount = (this.type == "TREESTR");
  this.closedItems = [];
  this.expcoll = true;
}
ZtTreeChart.prototype = Object.create(ZtSunburstChart.prototype);
ZtTreeChart.prototype.constructor = ZtTreeChart;

ZtTreeChart.prototype._SetChartSettingsJSON = function () {
  ZtSunburstChart.prototype._SetChartSettingsJSON.call(this);
  this.defSettings.layout = this.chartConfig.graphSettings.extends.treeLayout;
  this.defSettings.line = this.chartConfig.graphSettings.line;
}

ZtTreeChart.prototype._SetLists = function () {
  ZtSunburstChart.prototype._SetLists.call(this);
  var myList = [];
  for (var i = 0; i < this.levelsFields.length; i++)
    myList = myList.concat(getList(this.propertyName.indexOf(this.levelsFields[i]), this.dataSet));
  this.maxWord = getMaxWordLengthString(myList);
}

ZtTreeChart.prototype._SetScales = function () {
  if (this.byCount)
    return;
  this.allValuesZ = getList(this.propertyName.indexOf(this.valueFields), this.dataSet);
  var minWH = Math.min(this.defSettings.globals.width, this.defSettings.globals.height),
  radiusOffset = 0.125;
  this.scaleZ = d3.scaleLinear()
    .range([5, minWH * radiusOffset])       
    .domain([d3.min(this.allValuesZ), d3.sum(this.allValuesZ)]);
}

ZtTreeChart.prototype._DrawChartElements = function () {
  var group,
  offset = 5,
  ow = getOffsetWidth(this.maxWord, this.defSettings.globalFont, this.chartId),
  oh = getOffsetHeight(this.maxWord, this.defSettings.globalFont, this.chartId),
  translate = [ow + offset / 2, oh + offset / 2];

  if (this.defSettings.layout == "radial")
    translate = [this.chartWidth / 2, this.chartHeight / 2];
  else if (this.defSettings.layout == "vertical")
    translate = [ow, oh + offset / 2];
  group = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_elementGroup")
    .attr("transform","translate(" + translate + ")");
  this.DrawTree(group, this.calcDataset, this.chartId, this.chartWidth, this.chartHeight);
}

ZtTreeChart.prototype._SetElementsColor = function () {
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
        this.items[i].color = this.colorSet[idx];
        colorsObj["_" + idx] = { 
          lighter : getColorsArrayLighter(this.items[i].color.color, 7).reverse()
        }
      }
      else {
        var parent = this._GetParent(this.items[i]);
        if (parent) {
          this.items[i].color = colorsObj["_" + parent.index].lighter[this.items[i].depth - 1]
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
      d3.select(this.items[i].itm).select("circle").attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
      setFont(d3.select(this.items[i].itm).select("text"), this.defSettings.globalFont, this);
    }
  }

  styleObj.fill = "none";
  styleObj.stroke = this.defSettings.line.color || "#D0D0D0";
  styleObj.stroke9width = (this.defSettings.line.stroke || 0.5) + "px";

  if (this.items.length > 1) {
    d3.select("#" + this.chartId + "linkContainer")
      .selectAll(".link")
      .attr("style", makeStyleHTMLString(styleObj, d3.select("#" + this.chartId + "linkContainer").selectAll(".link").attr("style")));
  }
}

ZtTreeChart.prototype._ApplyMouseOver = function (item, itemObj, keepH) {
  var idx = d3.select(item).attr("item-index"),
  mRefChart = this._ZtChart.StdChart;
  if (!keepH)
    this.RemoveAllHovers();
  this.AppendHoverItem(item);
  var itemObject = itemObj || this.items[idx];
  if (!keepH)
    this.ShowTooltip(mRefChart, item, itemObject);
  if (this.defSettings.hierarchy.hoverPath == "element")
    return;
  if (itemObject.depth > 0) {
    var parent = itemObject.parent;
    if (parent)
      var parItem = this.items[parent.index];
    if (this.breadcrumbPath.indexOf(itemObject.category + this.splitSequence + idx) < 0)
      this.breadcrumbPath.push(itemObject.category + this.splitSequence + idx);
    this._ApplyMouseOver(parItem.itm, null, true);
  }
}

ZtTreeChart.prototype.AppendHoverItem = function (item) {
  var _this = this,
  mRefChart = this._ZtChart.StdChart;
  if (item) {
    var itemObject = this._GetItems()[d3.select(item).attr("item-index")],
    clone = this._GetItemClone(d3.select(item).select("circle").node(), itemObject);
    d3.select(clone)
      .attr("item-type", "hover")
      .attr("transform", "translate(" + itemObject.translate + ")")
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
      })
      .on("click", function () {
        _this._ApplyClick(itemObject, d3.mouse(this));
      });
    item.parentNode.appendChild(clone);

    this.MoveRangeCursor(itemObject.value);
  }
}

ZtTreeChart.prototype._SelectItem = function (itemObject, select) {
  var item = this._FindItemObject(itemObject);
  this._SelectItemObject(item, select);
  var mdata = this.calcDataset,
  data_temp = JSON.parse(JSON.stringify(mdata));
  if (this.expcoll) {
    //var mod_data = false;
    if (this.closedItems.indexOf(item.category) < 0) {  // lo chiudo
      this.closedItems.push(item.category);
      if (item.category == data_temp.name) {   // root
        delete data_temp.children;
      //  mod_data = true;
      }
    }
    else {  // lo apro
      this.closedItems.splice(this.closedItems.indexOf(item.category), 1);
      if (item.category == data_temp.name) {   // root
        data_temp.children = JSON.parse(JSON.stringify(this.calcDataset.children));
        //mod_data = true;
      }
      else {
        this._SetNodeOpenClose(item.category, "open", data_temp, mdata);
      }
    }

    for (var i = 0; i < this.closedItems.length; i++) {
      this._SetNodeOpenClose(this.closedItems[i], "close", data_temp, mdata);
    }

   // if (mod_data)
      this._UpdateElements(data_temp);
  }
}

ZtTreeChart.prototype._SelectItemObject = function (itemObject, select) {
  if (this.drawStatic)
    return;
  
    if (!itemObject.itm)
    return;

  if (select == null) {  // SELEZIONE NON PASSATA
    if (!itemObject.isSelected)
      itemObject.isSelected = true;
    else
      itemObject.isSelected = false;
  }
  else
    itemObject.isSelected = select;

  if (itemObject.isSelected && this.applyFocusKey)
    itemObject.focus = true;

  this._ApplyItemSVGSelectEffect([itemObject], itemObject.isSelected);
  this._ApplyNoSelections();
  this._ZtChart.StdChart._ApplyLegendNoSelections();
}

ZtTreeChart.prototype._SetNodeOpenClose = function (nodeName, status, allData, data) {
  var i,
  robj,
  pathIndex,
  current;

  if (status == "close") {
    robj = this._FindNode(data.children, nodeName, []);
    pathIndex = robj.progr;
    current = allData.children[pathIndex[0]];
    for (i = 1; i < pathIndex.length; i++)
      current = current.children[pathIndex[i]];
    current.size = this._GetNodeSize(current, 0);
    if (current.children)
      delete current.children;
  }
  else {
    robj = this._FindNode(data.children, nodeName, []);
    pathIndex = robj.progr;
    current = allData.children[pathIndex[0]];
    var currentOrg = this.calcDataset.children[pathIndex[0]];
    for (i = 1; i < pathIndex.length; i++) {
      current = current.children[pathIndex[i]];
      currentOrg = currentOrg.children[pathIndex[i]];
    }

    if (current && currentOrg) {
      if (currentOrg.children) {
        current.children = JSON.parse(JSON.stringify(currentOrg.children));
        delete current.size;
      }
    }
  }
}

ZtTreeChart.prototype._FindNode = function (chd, key, progr) {
  var found = false,
  obj = {};
  for (var i = 0; !found && i < chd.length; i++) {
    if (chd[i].name == key) {
      found = true;
      progr.push(i);
    }
    else if (chd[i].children) {
      obj = this._FindNode(chd[i].children, key, progr);
      found = obj.found;
      progr = obj.progr;
      if (found)
        progr.splice(0, 0, i);
    }
  }
  return { found : found, progr : progr};
}

ZtTreeChart.prototype._GetNodeSize = function (node, size) {
  if (node.size)
    return node.size;
  for (var i = 0; i < node.children.length; i++) {
    if ("size" in node.children[i])
      size += node.children[i].size;
    else
      size = this._GetNodeSize(node.children[i], size);
  }
  return size;
}

ZtTreeChart.prototype._UpdateElements = function (data) {
  this.alternativeData = data;
  var group = this.svg.select("#" + this.chartId + this.type + "_elementGroup");
  group.selectAll("g").remove();
  this.ResetItems();
  this.DrawTree(group, this.alternativeData, this.chartId, this.chartWidth, this.chartHeight);
  this.AfterDraw();
}

ZtTreeChart.prototype._GetDefaultAnimateFunction = function (item, lastValueObj, duration/*, noOpacity*/) {
  var div = this._GetAnimatedDivisor(),
  elem = d3.select(item.itm).select("circle").node(),
  defaultValues = Empty(lastValueObj),
  cx = d3.select(elem).attr("cx"),
  cy = d3.select(elem).attr("cy"),
  r = d3.select(elem).attr("r");
  d3.select(elem)
    .attr("cx", defaultValues ? cx : lastValueObj.cx)
    .attr("cy", defaultValues ? cy : lastValueObj.cy)
    .attr("r", defaultValues ? 0 : lastValueObj.r)
    .transition()
      .delay(item.depth * duration/div)
      .duration(duration/div)
      .ease(d3.easeLinear)
      .attr("cx", cx)
      .attr("cy", cy)
      .attr("r", r);
}

ZtTreeChart.prototype._FindItemObject = function (itemObject) {
  var myItems = this._GetItems().slice(),
  ret = itemObject;
  if (!itemObject.itm) {
    var found = false;
    for (var i = 0; !found && i < myItems.length; i++) {
      if (itemObject.category == myItems[i].category && itemObject.valueField == myItems[i].valueField) {
        ret = myItems[i];
        found = true;
      }
    }
  }
  return ret;
}