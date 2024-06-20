function ZtGeographicChart() {
  StdChart.apply(this, ["GEOMAP", "e6c2"]);
  this.isGeneric = true;
  this.mapDefinition = null;
  this.hasMoreData = false;
}
ZtGeographicChart.prototype = Object.create(StdChart.prototype);
ZtGeographicChart.prototype.constructor = ZtGeographicChart;

ZtGeographicChart.prototype.DrawCallback = function () { }

ZtGeographicChart.prototype._DrawCallback = function () {
  StdChart.prototype.DrawCallback.call(this);
}

ZtGeographicChart.prototype.Init = function (options) {
  StdChart.prototype.Init.call(this, options)

  this._markers = { data: options.addData, pname: options.addPName };

  var gflds = this.objConfig.geoFields.split(",");
  this.geoCountryField = gflds[0];
  this.geoSubField = gflds[1];
  this.seriesField = this.objConfig.labelField;
  this.geoSubLevel = this.objConfig.geoLevel || "0";
  this.geoMapView = !Empty(this.objConfig.geoViews) ? this.objConfig.geoViews : ""; // retrocomp
  this.geo0Level = "world";

  if (this.objConfig.geoOpts) {
    this.geoSubLevel = (this.objConfig.geoOpts.level || this.geoSubLevel) + "";
    if (Empty(this.geoMapView))
      this.geoMapView = !Empty(this.objConfig.geoOpts.view) ? this.objConfig.geoOpts.view : "";
    if (!Empty(this.geoMapView)) {
      if (this.geoMapView.split(",").length > 1) { // livello view profondita'
        var views = this.geoMapView.split(",");
        this.geoMapView = views[0];
        this._geoFocus = views.slice();
      }
      else
        this._geoFocus = [this.geoMapView];
      //-wip this.hasMoreData = true;
    }

    this._SetMapView();
  }
  // else { /* obj old */ }

  this._SetMapAndMapFile();
}

ZtGeographicChart.prototype._SetMapView = function () {
  var mapName = "";
  this.objConfig.geoOpts.typeView = parseInt(this.objConfig.geoOpts.typeView);
  switch (this.objConfig.geoOpts.typeView) {
    case 2: // continent
      mapName = "worant_";
      if (this.geoSubLevel == "con")
        mapName += "con";
      else {
        mapName += "cou"; // stati
        /*if (this.geoSubLevel != "0") {
          var add_maps = Object.keys(getCountries());
        }*/
      }
      if (!Empty(this.geoMapView)) {
        if (fileExists(this.GetWebRootURL() + "/chart/maps/" + this.geoMapView.toUpperCase() + ".json")) {
          mapName = this.geoMapView.toUpperCase();
          this.geo0Level = mapName;
        }
      }
      break;
    case 3: // country
      if (!Empty(this.geoMapView)) {
        mapName = this.geoMapView.toUpperCase();
        this.geo0Level = mapName;
      }
      if ((this.geoSubLevel + "") == "0")
        this.geoSubLevel = "";
      if (Empty(mapName)) // tutela non specifica stato
        mapName = "wor_cou";
      break;
    default:  // world - 0
      mapName += "wor";
      if (this.objConfig.geoOpts.typeView == 1) // world + ant
        mapName += "ant";
      mapName += "_";
      if (this.geoSubLevel == "con")
        mapName += "con";
      else {
        mapName += "cou"; // stati
        if (this.geoSubLevel != "0") {
          var add_maps = Object.keys(getCountries());
          console.log(add_maps)
        }
      }
    //--if (!Empty(this._geoFocus))  // includo solo stati indicati
  }
  this.geoMapView = mapName;

  /*
  if (parseInt(this.objConfig.geoOpts.typeView) == 3) { // country
    this.geoMapView = !Empty(this.objConfig.geoViews) ? this.objConfig.geoViews.split(",") : ""; // retrocomp
    if (Empty(this.geoMapView))
      this.geoMapView = !Empty(this.objConfig.geoOpts.view) ? this.objConfig.geoOpts.view.split(",") : "";
    if (this.geoMapView.length > 0)
      this.geoMapView = this.geoMapView.map(function(mv){ return mv.toLowerCase(); });
  }
  else if (parseInt(this.objConfig.geoOpts.typeView) == 0)
    this.geoMapView = "world";
    */
}

ZtGeographicChart.prototype._SetChartSettingsJSON = function () {
  this.defSettings.map = this.chartConfig.graphSettings.map;
  this.defSettings.map.undefined = {};
  this.defSettings.map.undefined.color = this.chartConfig.graphSettings.pointCap.pointer.color || "#E3E3E3";
  this.defSettings.map.undefined.stroke = this.chartConfig.graphSettings.pointCap.pointer.extendLine.color || "#A3A3A3";

  if (this.defSettings.range.type == "none" && Empty(this.seriesField)) {
    this.defSettings.range.type = "default";
    this.defSettings.range.applyColor = true;
  }

  this.multipleScales = false;
}

ZtGeographicChart.prototype._SetFieldsIndexes = function () {
  this.seriesIndex = this.propertyName.indexOf(this.seriesField);
  /* verificare */
  if (!Empty(this.objConfig.keyField)) {
    this.seriesLabelIndex = this.propertyName.indexOf(this.seriesField);
    this.seriesIndex = this.propertyName.indexOf(this.objConfig.keyField);
  }
  this.countryIndex = this.propertyName.indexOf(this.geoCountryField);
  if (!Empty(this.geoSubField))
    this.subIndex = this.propertyName.indexOf(this.geoSubField);
}

ZtGeographicChart.prototype._SetLists = function () {
  this.drawingSeries = [];
  this.orgSeriesList = [];
  this.seriesList = [];
  this.orgCategoryList = [];
  this.categoryList = [];

  if (this.seriesIndex >= 0) {
    if (!Empty(this.objConfig.keyField)) {
      this.seriesList = getDuplicatesListXYZ(this.seriesIndex, this.seriesLabelIndex, this.dataSet).array;
      this.orgSeriesList = getList(this.seriesIndex, this.dataSet);
    }
    else {
      this.seriesList = getList(this.seriesIndex, this.dataSet);
      this.orgSeriesList = this.seriesList.slice();
    }
    this.drawingSeries = this.orgSeriesList.slice();
  }

  this.valueFields = this.objConfig.valueFields/*.split(',')*/;

  this.legendList = this.orgSeriesList.slice();
  this.rowLegendList = [];
  this.drawingCategories = [];
}

ZtGeographicChart.prototype._EvaluateAllValues = function () {
  this.allValues = getList(this.propertyName.indexOf(this.valueFields), this.dataSet);
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);
  this._SetNegativeValue();
}

ZtGeographicChart.prototype._SetNegativeValue = function () {
  ZtPieChart.prototype._SetNegativeValue.call(this);
}

ZtGeographicChart.prototype.SetRangeList = function () { }

ZtGeographicChart.prototype._SetRangeList = function () {
  StdChart.prototype.SetRangeList.call(this);
  this.SetChartLegends();
  this.SetMargins();
}

ZtGeographicChart.prototype._SetScales = function () { }

ZtGeographicChart.prototype._AfterSettingMap = function () {
  if ((!this.__initDone && this.__setupDone) || (this.__initDone && !this.__setupDone))
    return;
  this._EvaluateAllValues();
  this._SetRangeList();
  if (this.drawingMoreLess) {
    d3.select("#" + this.chartId + this.type + "_svgGroup").remove();
    this._DrawChartElements();
    this.DrawNotRepresentedDataIcon();
    this.AfterDraw();
  }
  else
    this._DrawCallback();
}

ZtGeographicChart.prototype._ApplyEvents = function () { }

ZtGeographicChart.prototype._AddMapLayers = function (map, parentGroup, path) {
  var _this = this;
  d3.json(this.mapDefinition.mapWRoot + map + ".json", function (error, json) {
    if (!error) {
      var topoJ,
        tmpjson = JSON.stringify(json),
        geoJ;
      if (json.type.toLowerCase() != "topology") {
        var map_t = {};
        map_t[map] = JSON.parse(tmpjson);
        topoJ = topojson.topology(map_t);
        geoJ = JSON.parse(tmpjson);
      }
      else {
        topoJ = JSON.parse(tmpjson);
        geoJ = topojson.feature(topoJ, topoJ.objects[map])
      }
    }
    else {
      topoJ = "error";
      console.debug(error);
    }

    /*cp*/
    if (Empty(window[map + "mapdef"])) {
      ZtVWeb.RequireLibrary(_this.mapDefinition.mapWRoot + map + "config.js");
    }
    var toDraw = [];
    if (window[map + "mapdef"].mapLevels["_" + _this.geoSubLevel]) {
      var fieldRef = window[map + "mapdef"].mapLevels["_" + _this.geoSubLevel],
        geoms = geoJ.features;
      for (var i = 0; i < geoms.length; i++) {
        var props = geoms[i].properties;
        if (props[fieldRef]) {
          if (toDraw.indexOf(props[fieldRef]) < 0)
            toDraw.push(props[fieldRef]);
        }
      }
    }

    var levels = Object.keys(window[map + "mapdef"].mapLevels),
      subIndex = levels.indexOf("_" + this.geoSubLevel);
    for (var kk = 0; kk < toDraw.length; kk++) {
      var cnames = "";
      parentGroup
        .append("path")
        .attr("fill", "white")
        .attr("stroke", "blue")
        .datum(
          topojson.merge(topoJ, topoJ.objects[map].geometries.filter(function (d) {
            var cValid = (toDraw.indexOf(d.properties[window[map + "mapdef"].mapLevels["_" + _this.geoSubLevel]]) >= 0
              &&
              d.properties[window[map + "mapdef"].mapLevels["_" + _this.geoSubLevel]] == toDraw[kk]
            )

            if (cValid) {
              var item = { //itm: this,
                color: { color: _this.defSettings.map.undefined.color, gradient: "" }
              }
              cnames = "";
              for (var i = 0; i < levels.length; i++) {
                var level = levels[i],
                  levelField = window[map + "mapdef"].mapLevels[level],
                  levelDescField = window[map + "mapdef"].descs[window[map + "mapdef"].codes.indexOf(levelField)];
                if (i <= subIndex) {
                  item[level] = d.properties[levelField];
                  item[level + "desc"] = d.properties[levelDescField];
                  cnames += (item[level] + "-");
                }
              }
              //console.log(cnames)
              if (_this.items.hasObject(item) < 0) { }
              // _this.items.push(item);
            }

            return cValid;
          }))
        )
        .attr("class", function (/*d*/) {
          console.log("class", cnames)
          /*var item = { itm: this,
            color: { color: _this.defSettings.map.undefined.color, gradient: "" }
          }
          _this.items.push(item);*/
          return "geopath "// + cnames.slice(0, cnames.length - 1) +  " TRANSP";
        })
        .attr("d", path);
    }

    /*  parentGroup.append("path")
      .attr("fill", "none")
      .attr("stroke", "#f00")
      .attr("stroke-linejoin", "round")
      .attr("d", path(topojson.mesh(topoJ, topoJ.objects[map], function(a, b) { return a !== b; })));*/
  });
}

ZtGeographicChart.prototype._DrawMarkers = function () {
  if (Empty(this._markers) || Empty(this._markers.data))
    return;
  this.items_markers = [];
  var _this = this,
    parentGroup = this.svg.select("#" + this.chartId + this.type + "_svgGroup"),
    icon = isNaN(this.objConfig.geoOpts.markers.type) ? 0 : this.objConfig.geoOpts.markers.type;

  var grp = parentGroup.append("g").attr("class", "geomarker_grp"),
    bounds = this.__path.bounds(this.mapDefinition.geojson);

  for (var i = 0; i < this._markers.data.length; i++) {
    var record = this._markers.data[i],
      coords = [record[this._markers.pname.indexOf(this.objConfig.geoOpts.markers.lng)],
      record[this._markers.pname.indexOf(this.objConfig.geoOpts.markers.lat)]],
      proj_coords = this.mapDefinition.proj(coords),
      icon_y = proj_coords[1];
    if (icon == 0)
      icon_y += (12 / 2)
    else if (icon == 4)
      icon_y += (12 / 4)
    var check_x = (proj_coords[0] < bounds[0][0] || proj_coords[0] > bounds[1][0]),
      check_y = (proj_coords[1] < bounds[0][1] || proj_coords[1] > bounds[1][1]);
    if (check_x || check_y)
      continue;
    var mRefChart,
      itemObject,
      mrk = grp.append("text")
        .attr("class", "geomarker")
        .attr("item-index", i)
        .attr("x", proj_coords[0])
        .attr("y", icon_y)  // cerchio + r/2, geo fence r/4, pins +2px
        .text(this.GetMarkerIcon(icon))
        .style("font-family", this.GetIconFont().name)
        .style("font-size", 12 + "px")
        .style("fill", this.GetIconFont().color)
        .style("text-anchor", "middle")
        .style("cursor", "pointer")
        .on("mouseover", function () {
          _this.RemoveAllHovers();
          mRefChart = _this._ZtChart.StdChart;
          itemObject = _this.items_markers[d3.select(this).attr("item-index")];
          mRefChart._hoverItem = itemObject;
          mRefChart._d3mouse = d3.mouse(this);
          mRefChart._d3event = d3.event;
          setTimeout(function (mRefChart, item, itemObject) {
            if (mRefChart._hoverItem && mRefChart._CheckIdentityItem(mRefChart._hoverItem, itemObject))
              _this.ShowTooltip(mRefChart, item, itemObject, true);
          }, 50, mRefChart, this, itemObject);

          _this.MoveRangeCursor(itemObject.value, itemObject.isNull);
        })
        .on("mouseout", function () {
          mRefChart.RemoveAllHovers();
        })
        .on("click", function () {
          itemObject = _this.items_markers[d3.select(this).attr("item-index")];
          _this._ApplyOtherClick(itemObject, d3.mouse(this));
        })

    this.items_markers.push({
      itm: mrk.node(),
      desc: record[this._markers.pname.indexOf(this.objConfig.geoOpts.markers.desc)],
      coords: coords,
      idx: i,
      key: !Empty(this.objConfig.geoOpts.markers.key) ? record[this._markers.pname.indexOf(this.objConfig.geoOpts.markers.key)] : "",
      geoMarker: true
    });

  }
}

ZtGeographicChart.prototype._ApplyOtherClick = function (itemObject, evt) {
  if (!this._ZtChart.enableClick)
    return;
  this._SelectItem(itemObject, null);
  var mRefChart = this._ZtChart.StdChart,
    itemObj = this._GetOtherItemObj(itemObject);
  itemObj.mouse = evt;
  if (window[mRefChart.chartId + "onClick"])
    window[mRefChart.chartId + "onClick"](itemObj);
  else if (mRefChart._ZtChart.parentCtrl && mRefChart._ZtChart.parentCtrl.dispatchEvent) {
    var on_evt = mRefChart._ZtChart.parentCtrl.dispatchEvent('onClick', d3.event, itemObj);
    if (!on_evt) {
      if (window[mRefChart.chartId + "Click"])
        window[mRefChart.chartId + "Click"](itemObj);
      else
        mRefChart._ZtChart.parentCtrl.dispatchEvent("Click", d3.event, itemObj);
    }
  }
  // - valutare this.OpenLink(itemObj);
}

ZtGeographicChart.prototype._ApplyValuesInItems = function () {
  this.__seriesObj = {};
  for (var i = 0; i < this.dataSet.length; i++) {
    var _0idx = this.propertyName.indexOf(this.geoCountryField),
      _subidx = this.propertyName.indexOf(this.geoSubField),
      validx = this.propertyName.indexOf(this.valueFields),
      record = this.dataSet[i],
      itmidx = -1,
      itm;
    if (this.seriesIndex >= 0) {
      var code = "";
      if (Empty(this.geoSubField)) {
        // ho l'itm
        if (this._toDraw.indexOf(record[_0idx]) >= 0)
          code = record[_0idx];
      }
      else {  // suddivsione
        code = record[_0idx] + "-" + record[_subidx];
      }
      if (!(code in this.__seriesObj)) {
        this.__seriesObj[code] = { index: -1, series: {}, total: 0 };
        itm = this.svg.select(".geopath." + code);
        if (!Empty(itm.node()))
          itmidx = itm.attr("item-index");
        this.__seriesObj[code].index = parseInt(itmidx);
      }
      if (!(record[this.seriesIndex] in this.__seriesObj[code].series))
        this.__seriesObj[code].series[record[this.seriesIndex]] = { value: null, index: -1 };
      this.__seriesObj[code].series[record[this.seriesIndex]].value = record[validx];
      this.__seriesObj[code].series[record[this.seriesIndex]].index = i;
      this.__seriesObj[code].series[record[this.seriesIndex]].categoryCode = record[this.categoryCodeIndex];
      this.__seriesObj[code].total += record[validx];
    }
    else {
      if (Empty(this.geoSubField)) {
        // ho l'itm
        if (this._toDraw.indexOf(record[_0idx]) >= 0) {
          itm = this.svg.select(".geopath." + record[_0idx]);
          if (!Empty(itm.node())) {
            itmidx = itm.attr("item-index");
            if (itmidx >= 0) {
              this.items[itmidx].rowIdx = i;
              this.items[itmidx].value = record[validx];
              this.items[itmidx].isNull = false;
              this.items[itmidx].categoryCode = record[this.categoryCodeIndex];
            }
          }
        }
      }
      else {  // suddivsione
        itm = this.svg.select(".geopath." + record[_0idx] + "-" + record[_subidx]);
        if (!Empty(itm.node())) {
          itmidx = itm.attr("item-index");
          if (itmidx >= 0) {
            this.items[itmidx].rowIdx = i;
            this.items[itmidx].value = record[validx];
            this.items[itmidx].isNull = false;
            this.items[itmidx].categoryCode = record[this.categoryCodeIndex];
          }
        }
      }
    }
  }
}

ZtGeographicChart.prototype._GetValuesPrecision = function () {
  return ZtPieChart.prototype._GetValuesPrecision.call(this);
}

ZtGeographicChart.prototype._GetDomainPrecision = function () {
  return ZtPieChart.prototype._GetDomainPrecision.call(this);
}

ZtGeographicChart.prototype._GetChartMarginsObject = function (/*chartId, settings, categoryList, dataOrder, domainIsTime, domainIsNumber, localeLangFormat, datetimePict, chartLegends, allValues, valprec, domprec, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/) { // eslint-disable-line max-len
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  if (this.hasMoreData) {
    var myM = {},
      appFont,
      mtext,
      h1 = getOffsetHeight(this.GetMoreDataIcon(), this.GetDefaultIconFont(), this.chartId),
      h2 = getOffsetHeight(this.GetLegendIcon(), this.GetDefaultIconFont(), this.chartId),
      h3 = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

    if ((h1 > h2 && h1 > h3) || (h2 > h1 && h2 > h3)) {
      appFont = this.GetDefaultIconFont();
      mtext = this.GetLegendIcon();
      if (h2 > h1)
        mtext = this.GetMoreDataIcon();
    }
    else {
      mtext = "W";
      appFont = this.defSettings.globalFont;
    }

    myM = setMarginObject(mtext, appFont, false, this.defSettings.globalFont);
    if (myM != 0) {
      myM.offset = 5;
      ret.bottom.push(myM);
    }
  }

  return ret;
}

ZtGeographicChart.prototype._DrawChartPlot = function () {
  ZtPieChart.prototype._DrawChartPlot.call(this);
}

ZtGeographicChart.prototype._DrawChartElements = function () {
  var parentGroup = this.renderer.append("g")
    .attr("id", this.chartId + this.type + "_svgGroup")
    .attr("transform", "translate(" + [this.margin.left + 2, this.margin.top + 2] + ")");

  this.DrawMap(parentGroup);
  this.AddCtrlsZoom();  //wip
  this._ApplyValuesInItems();
  this.AfterGeoDraw();  // recheck
}

ZtGeographicChart.prototype._SetMapAndMapFile = function (add_maps) {
  var webroot = this.GetWebRootURL(),
    _this = this,
    mapName = this.geoMapView;
  var checkOK = false;
    //w_map = null;
  if (!Empty(window["_ztc_" + mapName])) {
    checkOK = true;
   // w_map = window["_ztc_" + mapName];
  }
  else
    checkOK = fileExists(webroot + "/chart/maps/" + mapName + ".json");

  if (checkOK) {
    this.mapDefinition = {};
    this.mapDefinition.mapWRoot = webroot + "/chart/maps/";
    this.mapDefinition.mapCode = mapName;
    this.mapDefinition.mapFile = webroot + "/chart/maps/" + mapName + ".json";
    var defName = mapName;
    if (Empty(window[defName + "mapdef"])) {
      if (mapName.indexOf("worant_") >= 0)
        defName = Strtran(defName, "worant_", "wor_");
      ZtVWeb.RequireLibrary(webroot + "/chart/maps/" + defName + "config.js");
    }
    // aggiungo nell'oggetto il riferimento di eventuali mappe da disegnare dopo la principale - layers
    // wip
    if (!Empty(add_maps)) {
      this.mapDefinition.mapLayers = [];
      for (var i = 0; i < add_maps.length; i++) {
        if (fileExists(webroot + "/chart/maps/" + add_maps[i] + ".json")) {
          this.mapDefinition.mapLayers.push(add_maps[i]);
        }
      }
    }
    this.mapDefinition.mapDef = window[defName + "mapdef"];
    this.mapDefinition.codes = [];
 /*   if (!Empty(w_map)) {
      var jtype = JSON.parse(w_map).type;
      _this._SetupMap(w_map, jtype);
    }
    else {*/
  //    var initDate = new Date()
      d3.json(this.mapDefinition.mapFile, function (error, json) {
        if (!error) {
          window["_ztc_" + mapName] = JSON.stringify(json);
          _this._SetupMap(window["_ztc_" + mapName], json.type);
   //       console.log(new Date().getTime() - initDate.getTime())
        }
        else {
          _this.mapDefinition.topojson = "error";
          // console.debug(error);
          throw error;
        }
      });
   // }
  }
  else
    throw "Error: map file not found";  // metterlo nel div

 /* console.log("objC", this.objConfig)
  console.log(this.mapDefinition)*/
}

ZtGeographicChart.prototype._SetupMap = function (tmpjson, jtype) {
  var _this = this,
    tjson;
//  console.log(jtype)
//  console.trace()
 // var initDate0 = new Date()
  if (jtype.toLowerCase() != "topology") {
    var map_t = {};
    map_t[_this.mapDefinition.mapCode] = JSON.parse(tmpjson);
    tjson = topojson.topology(map_t);
    _this.mapDefinition.geojson = JSON.parse(tmpjson);
  }
  else {
    tjson = JSON.parse(tmpjson);
    _this.mapDefinition.geojson = topojson.feature(tjson, tjson.objects[_this.mapDefinition.mapCode])
  }
  _this.mapDefinition.topojson = tjson;
 // console.log("@1", new Date().getTime() - initDate0.getTime())
 // var initDate = new Date()
  _this._toDraw = [];
  if (_this.objConfig.geoOpts.onlyData) {
    var field = !Empty(this.geoSubField) ? this.geoSubField : this.geoCountryField;
    this._toDraw = getList(this.propertyName.indexOf(field), this.dataSet);
  }
  else if (_this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel]) {
    var fieldRef = _this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel],
      geoms = _this.mapDefinition.geojson.features;
    //console.log(fieldRef)
    for (var i = 0; i < geoms.length; i++) {
      var props = geoms[i].properties;
      if (props[fieldRef]) {
        if (_this._toDraw.indexOf(props[fieldRef]) < 0)
          _this._toDraw.push(props[fieldRef]);
      }
    }
  }
  /*console.log("@toDraw", _this._toDraw)
  console.log("@2", new Date().getTime() - initDate.getTime())
  console.log("defSettings", this.defSettings)*/

  this.__setupDone = true;

  _this._AfterSettingMap();
}

ZtGeographicChart.prototype._SetAxisColor = function () {
  ZtPieChart.prototype._SetAxisColor.call(this);
}

ZtGeographicChart.prototype._SetAxisGridColor = function () {
  ZtPieChart.prototype._SetAxisGridColor.call(this);
}

ZtGeographicChart.prototype._SetAxisFont = function () {
  ZtPieChart.prototype._SetAxisFont.call(this);
}

ZtGeographicChart.prototype._SetAxisLabelFont = function () {
  ZtPieChart.prototype._SetAxisLabelFont.call(this);
}

ZtGeographicChart.prototype._SupportChangeOrder = function () {
  return false;
}

ZtGeographicChart.prototype._SupportFilter = function () {
  return false;
}

ZtGeographicChart.prototype.AfterDraw = function () { }

ZtGeographicChart.prototype.AfterGeoDraw = function () {
  StdChart.prototype.AfterDraw.call(this);
  StdChart.prototype.DrawChartMenu.call(this);
}

ZtGeographicChart.prototype.AfterDrawTimeout = function () {
  var _this = this;
  if (this.forPJS)
    timeoutSequence();
  else {
    var timeout = setTimeout(function () { timeoutSequence(); }, this.animationDelay);
    this.allTimeouts.push(timeout);
  }

  function timeoutSequence() {
    _this._ApplyPatterns();
    _this._DrawMarkers();
    _this.DrawValueLabels();
    _this.RemoveLoadingDiv();
    _this.HideMaskDivAnimation();
    if (_this.old_drawStatic !== undefined) {
      _this.drawStatic = _this.SetIsStaticChart(_this.old_drawStatic);
      delete _this.old_drawStatic;
    }
    _this._ScaleMap();
    _this._AppendMoreIcon();
    delete _this.drawingMoreLess;
  }
}

ZtGeographicChart.prototype._DrawSeriesAndSetItem = function (s_obj, key) {
  var item = this.items[s_obj.index];
  if (Empty(item.itm))
    return;
  var _this = this,
    s_idx = -1,
    sKeys = Object.keys(s_obj.series),
    bbox,
    todivide,
    tomaintain,
    pdivide,
    pmantain,
    pfactor,
    progr = 0,
    cdivide,
    cmantain,
    group = d3.select(item.itm.parentNode).append("g"),
    new_item,
    new_itm;

  group.append("clipPath")
    .attr("id", key + "_clip")
    .append("path")
    .attr("d", d3.select(item.itm).attr("d"));

  for (var i = 0; i < sKeys.length; i++) {
    s_idx = this.orgSeriesList.indexOf(sKeys[i]);
    bbox = getDomNodeSizes(item.itm);
    if (bbox.width > bbox.height) {
      todivide = bbox.width;
      pdivide = "width";
      tomaintain = bbox.height;
      pmantain = "height";
      cdivide = "x";
      cmantain = "y";
    }
    else {
      todivide = bbox.height;
      pdivide = "height";
      tomaintain = bbox.width;
      pmantain = "width";
      cdivide = "y";
      cmantain = "x";
    }

    pfactor = (Math.abs(s_obj.series[sKeys[i]].value) * todivide) / s_obj.total;

    new_itm = group.append("rect")
      .attr("class", "geopath geoserie " + key + "_" + s_idx + " TRANSP")
      .attr(cmantain, bbox[cmantain])
      .attr(cdivide, bbox[cdivide] + progr)
      .attr(pmantain, tomaintain + "px")
      .attr(pdivide, pfactor + "px")
      .attr("item-index", this.tmpItems.length)
      .on("mouseover", applyMouseOver);

    progr = progr + pfactor;

    new_item = Object.assign({}, item);
    new_item.itm = new_itm.node();
    new_item.series = sKeys[i];
    new_item.value = s_obj.series[sKeys[i]].value;
    new_item.isNull = false;
    new_item.categoryCode = s_obj.series[sKeys[i]].categoryCode;
    this.tmpItems.push(new_item);

    var idx = this.orgSeriesList.indexOf(new_item.series),
      gradID, colD;
    new_item.idx = idx;
    new_item.sidx = i;
    var styleObj = {};
    if (idx >= 0) {
      new_item.color = this.colorSet[idx];
      if (this.defSettings.useColorSeriesForEach)
        new_item.color = this.colorSet[i];
      gradID = this.chartId + this.type + "_" + idx + "Gradient";
      if (!Empty(new_item.color.color) && Empty(new_item.color.gradient) || new_item.color.color.toLowerCase() == new_item.color.gradient.toLowerCase())
        colD = new_item.color.color;
      else if (Empty(new_item.color.color) && !Empty(new_item.color.gradient))
        colD = new_item.color.gradient;
      else {
        this.CreateGradient(new_item.color.color, new_item.color.gradient, gradID, "element");
        colD = "url(#" + gradID + ")";
      }
      styleObj.fill = colD;
    }
    else
      styleObj.fill = new_item.colorApplied;
    new_item.colorApplied = styleObj.fill;
    d3.select(new_item.itm).attr("style", makeStyleHTMLString(styleObj, d3.select(new_item.itm).attr("style")));
  }

  group.attr("clip-path", "url(#" + key + "_clip)");
  d3.select(item.itm).remove();

  function applyMouseOver() {
    _this._ApplyMouseOver(this);
  }
}

ZtGeographicChart.prototype._SetElementsColor = function () {
  /* valutare
    var customCols = Object.keys(this.customColorsSeries);
    if (!Empty(customCols)) {
      for (i = 0; i < customCols.length; i++) {
        var keycode = customCols[i].slice(1);
        if (this.mapDefinition.codes.indexOf(keycode) >= 0) {
          this.svg.selectAll(".geopath." + keycode).style("fill", this.customColorsSeries[customCols[i]].color).style("stroke", "none");
          // applicare colore + item
        }
      }
    }
  */
  if (Empty(this.seriesField))
    return;

  this.SetColorSet();
  var i,
    ckeys = Object.keys(this.__seriesObj),
    _this = this;
  ckeys.sort(function (a, b) {
    return _this.__seriesObj[b].index - _this.__seriesObj[a].index;
  });

  this.tmpItems = [];
  for (i = 0; i < ckeys.length; i++) {
    this._DrawSeriesAndSetItem(this.__seriesObj[ckeys[i]], ckeys[i]);
    this.items.splice(this.__seriesObj[ckeys[i]].index, 1);
  }
  this.items = this.items.concat(this.tmpItems);
  delete this.tmpItems;
}

ZtGeographicChart.prototype._SetElementsRangeColor = function (isFnc) {
  var styleObj,
    fill,
    band;

  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm && !this.items[i].isNull) {
      if (isFnc) {
        if (this.functionObj && ("GetConditionalFormatting" in this.functionObj)) {
          var fncRet = this.functionObj.GetConditionalFormatting(this._GetItemObj(this.items[i]));
          fill = decodeConditionalFormatting(fncRet).fill;
        }
      }
      else {
        band = this.GetObjectFromRange(this.items[i].value, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.items[i], band);
      }

      styleObj = { fill: fill, stroke: fill };
      this.items[i].colorApplied = fill;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}

ZtGeographicChart.prototype._GetReferredList = function () {
  return this.orgSeriesList;
}

ZtGeographicChart.prototype._GetReferredExcludedList = function () {
  return this._GetReferredList();
}

ZtGeographicChart.prototype._AppendMoreIcon = function () {
  if (!this.hasMoreData || (this.hasMoreData && this.drawingMoreLess))
    return;

  var group = this.svg.append("g")
    .attr("id", this.chartId + this.type + "_moreGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top + this.chartHeight] + ")"),
    h1 = getOffsetHeight(this.GetMoreDataIcon(), this.GetDefaultIconFont(), this.chartId),
    h2 = getOffsetHeight(this.GetLegendIcon(), this.GetDefaultIconFont(), this.chartId),
    h3 = getOffsetHeight("W", this.defSettings.globalFont, this.chartId),
    totH = Math.max(Math.max(h1, h2), h3),
    progr = 0,
    _this = this;

  group.append("text")
    .attr("x", progr)
    .attr("y", totH)
    .attr("data-type", "less")
    .text(this.GetMoreDataIcon(true))
    .style("font-family", this.GetDefaultIconFont().name)
    .style("font-size", this.GetDefaultIconFont().size + "px")
    .style("fill", this.GetDefaultIconFont().color)
    .style("cursor", "pointer")
    .on("click", function () { _this._DrawMoreLess() });

  progr = getOffsetWidth(this.GetMoreDataIcon(), this.GetDefaultIconFont(), this.chartId) + 3;

  group.append("text")
    .attr("x", progr)
    .attr("y", totH)
    .text(this.GetLegendIcon())
    .style("font-family", this.GetDefaultIconFont().name)
    .style("font-size", this.GetDefaultIconFont().size + "px")
    .style("fill", this.GetDefaultIconFont().color)
    .style("cursor", "pointer")
    .on("click", function () { _this._DrawMoreLess() });

  progr = getOffsetWidth(this.GetLegendIcon(), this.GetDefaultIconFont(), this.chartId) + 3;

  group.append("text")
    .attr("x", progr)
    .attr("y", totH)
    .text("")
    .style("font-family", this.defSettings.globalFont.name)
    .style("font-size", this.defSettings.globalFont.size + "px")
    .style("fill", this.defSettings.globalFont.color)
    .style("cursor", "pointer")
    .on("click", function () { _this._DrawMoreLess() });
}

ZtGeographicChart.prototype._DrawMoreLess = function () {
  if (!Empty(this._orgGeoFocus) || !Empty(this._orgGeoMapView)) {
    this._geoFocus = JSON.parse(this._orgGeoFocus);
    this._orgGeoFocus = null;
    this.geoMapView = JSON.parse(this._orgGeoMapView);
    this._orgGeoMapView = null;
    delete this.drawingMoreLess;
  }
  else {
    this._orgGeoFocus = JSON.stringify(this._geoFocus);
    this._geoFocus = [];
    this._orgGeoMapView = JSON.stringify(this.geoMapView);
    this.geoMapView = "";
    this.drawingMoreLess = true;
  }

  this.ResetItems();
  this._SetMapView();
  this._SetMapAndMapFile();

  var icon = d3.select("#" + this.chartId + this.type + "_moreGroup").node().firstChild;
  if (icon) {
    if (d3.select(icon).attr("data-type") == "more") {
      d3.select(icon)
        .attr("data-type", "less")
        .text(this.GetMoreDataIcon(true));
    }
    else {
      d3.select(icon)
        .attr("data-type", "more")
        .text(this.GetMoreDataIcon());
    }
  }
}

ZtGeographicChart.prototype._ScaleMap = function () {
  if (this.objConfig.zooming && this.objConfig.zooming.enabled) {
    //const [[x0, y0], [x1, y1]] = this.__path.bounds(d);
    /*this.svg.transition().duration(750).call(
      this.__zoom.transform,
      d3.zoomIdentity
        .translate(this.chartWidth / 2, this.chartHeight / 2)
        .scale(10)//Math.min(8, 0.9 / Math.max((x1 - x0) / this.chartWidth, (y1 - y0) / this.chartHeight)))
        //.translate(-(x0 + x1) / 2, -(y0 + y1) / 2)
    );*/
    // this.__zoom.scaleBy(this.svg/*.transition().duration(750)*/, parseFloat(this.objConfig.zooming.level));
  }

  return
  var geoMapGrp = d3.select("#" + this.chartId + this.type + "_svgGroup"),
    vlabGrp = d3.select("#" + this.chartId + "valueLabels"),
    json = this.mapDefinition.topojson,
    mapsize;
  if (!this.isGeneric) {
    mapsize = geoMapGrp.node().getBoundingClientRect();
    var offsetY = Math.abs(json.transform.translate[1] - mapsize.height);
    var scaleAttrX = this.chartWidth / mapsize.width;
    var scaleAttrY = this.chartHeight / mapsize.height;
    if (scaleAttrX > scaleAttrY)
      scaleAttrX = scaleAttrY;
    offsetY = offsetY / scaleAttrY;
    var mx = mapsize.left;
    var my = mapsize.top;
    var trsf = "scale(" + [scaleAttrX, scaleAttrY] + ")";
    geoMapGrp.attr("transform", trsf);
    mapsize = geoMapGrp.node().getBoundingClientRect();
    var tx = (this.chartWidth - mapsize.width) / 2 + (mx - mapsize.left);
    var ty = (this.chartHeight - mapsize.height) / 2 + (my - mapsize.top) - offsetY / 2;
    trsf = "translate(" + [tx, ty] + ") " + trsf;
    geoMapGrp.attr("transform", trsf);
    if (!Empty(vlabGrp.node()))
      vlabGrp.attr("transform", trsf);
  }
  else {
    mapsize = geoMapGrp.node().getBBox();
    var offsw = (this.chartWidth - mapsize.width) / 2;
    var offsh = (this.chartHeight - this.margin.top - mapsize.height) / 2;
    var translate = [(-(mapsize.x - this.margin.left) + offsw), (-(mapsize.y - this.margin.top) + offsh)];
    geoMapGrp.attr("transform", "translate(" + translate + ")");
    if (!Empty(vlabGrp.node()))
      vlabGrp.attr("transform", "translate(" + translate + ")");
  }
}

ZtGeographicChart.prototype._ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (this.defSettings.range.applyColor)
    this._SetElementsRangeColor(isFnc);
  else
    this._AppendRangeMarker();
}

ZtGeographicChart.prototype._AppendRangeMarker = function () {
  if (Empty(this.seriesField))
    return;

  var fill,
    group;
  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].itm && !this.items[i].isNull) {
      group = d3.select(this.items[i].itm.parentNode);
      var band = this.GetObjectFromRange(this.items[i].value, this.defSettings.range.bands);
      fill = band.color;
      this.SetRangeInItems(this.items[i], band);
      group.append("text")
        .attr("class", "ztchartfonticon markerItem")
        .attr("x", getDomNodeLeft(this.items[i].itm) + getDomNodeWidth(this.items[i].itm) / 2 - 2)
        .attr("y", getDomNodeTop(this.items[i].itm) + getDomNodeHeight(this.items[i].itm) / 2 + 2)
        .style("font-family", this.GetDefaultIconFont().name)
        .style("font-size", "5px")
        .style("cursor", "default")
        .style("fill", fill)
        .style("stroke", get3DColor({ color: fill, gradient: "" }).color)
        .style("stroke-width", 0.5)
        .text(this.GetMarkerLegendIcon());
    }
  }
}

ZtGeographicChart.prototype._GetValueLabelX = function (pos, item/*, text, font*/) {
  return getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) / 2;
}

ZtGeographicChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  return getDomNodeTop(item.itm) + getDomNodeHeight(item.itm) / 2 + getOffsetHeight(text, font, this.chartId) / 4;
}

ZtGeographicChart.prototype._GetLegendIconHexCode = function () {
  return this.legendHexCode;
}

ZtGeographicChart.prototype._EnableNullValues = function () {
  return true;
}

ZtGeographicChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "",
    val,
    continent = false;

  if (this.objConfig.geoOpts.typeView <= 2) {
    if (!Empty(itemObject._con) && !Empty(itemObject._condesc)) {
      purl += "&name=" + URLenc(itemObject._condesc);
      continent = true;
    }
  }

  if (!continent && !Empty(itemObject._0) && !Empty(itemObject._0desc))
    purl += "&name=" + URLenc(itemObject._0desc);

  var sub = !Empty(this.geoSubLevel) ? "_" + this.geoSubLevel : "";
  if (!Empty(sub) && (!Empty(itemObject[sub]) && !Empty(itemObject[sub + "desc"])))
    purl += "&namesub=" + URLenc(itemObject[sub + "desc"]);

  if (!Empty(itemObject.series))
    purl += "&serie=" + URLenc(itemObject.series);

  val = parseFloat(itemObject.value);
  if (!Empty(val) && !isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject));
      }
    }
    else {
      val = this.GetValuePicture(val);
    }
    purl += "&value=" + URLenc(val);
  }
  purl += "&isNull=" + URLenc(itemObject.isNull);

  return purl;
}

ZtGeographicChart.prototype._GetParametersOtherForTooltip = function (item) {
  var purl = "";

  // marker
  if (item.geoMarker) {
    purl += "&isMarker=true";
    purl += "&category=" + URLenc(item.desc);
    var coords = item.coords.slice();
    purl += "&value=" + URLenc(coords.reverse().toString());
    purl += "&color=" + URLenc("E3E3E3");
    if (!Empty(item.key))
      purl += "&key=" + URLenc(item.key);
  }

  return purl;
}

ZtGeographicChart.prototype._GetParametersStringForLink = function (item) {
  var purl = "",
    val,
    mcp,
    linkObj = this.linkObj,
    seriesName = Empty(linkObj.seriesname) ? "series" : linkObj.seriesname,
    valueName = Empty(linkObj.valuename) ? "value" : linkObj.valuename,
    geocountryName = Empty(linkObj.geocountryName) ? "geocountryName" : linkObj.geocountryName,
    geosubdivisionName = Empty(linkObj.geosubdivisionName) ? "geosubdivisionName" : linkObj.geosubdivisionName;

  // marker
  if (item.geoMarker) {
    purl += "&desc=" + URLenc(item.desc);
    purl += "&lng=" + URLenc(item.coords[0]);
    purl += "&lat=" + URLenc(item.coords[1]);
    if (!Empty(item.key))
      purl += "&key=" + URLenc(item.key);
  }
  else {
    mcp = item.cname.split("_");
    if (!Empty(mcp[0]))
      purl += geocountryName + "=" + URLenc(mcp[0]);

    if (!Empty(mcp[1]))
      purl += "&" + geosubdivisionName + "=" + URLenc(mcp[1]);

    if (!Empty(item.series))
      purl += "&" + seriesName + "=" + URLenc(item.series);

    val = parseFloat(item.value);
    if (!Empty(val) && !isNaN(val)) {
      // apply picture + funzione
      if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
        if (this.functionObj.GetValuePicture) {
          val = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
        }
      }
      else {
        val = this.GetValuePicture(val);
      }
      purl += "&" + valueName + "=" + URLenc(val);
    }
    purl += "&isNull=" + URLenc(item.isNull);
  }
  return purl;
}

ZtGeographicChart.prototype._CheckIdentityItem = function (itemOrg, itemOth) {
  return (itemOrg.idx == itemOth.idx && itemOrg.idx == itemOth.idx);
}

ZtGeographicChart.prototype._MakeNotRepresentedDataRow = function (cols, record, v_fld/*, l_fld*/) {
  var yIndex = this.propertyName.indexOf(v_fld),
    srow = document.createElement("TR"),
    stcol;
  for (var k = 0; k < cols; k++) {
    stcol = document.createElement("TD");
    if (k == 0)
      stcol.textContent = record[this.countryIndex] + (this.subIndex ? (" - " + record[this.subIndex]) : "");
    else
      stcol.textContent = record[yIndex];
    stcol.style.textAlign = "center";
    srow.appendChild(stcol);
  }
  return srow;
}

ZtGeographicChart.prototype._CreateGrid = function (thead, tbody1) {
  var fields = [],
    props = [];
  // country
  fields.push(this.geoCountryField);
  props.push("_0desc");
  // sub
  if (!Empty(this.geoSubField)) {
    fields.push(this.geoSubField);
    props.push("_subdesc");
  }
  // serie
  if (!Empty(this.seriesField)) {
    fields.push(this.seriesField);
    props.push("series");
  }
  // valore
  fields.push(this.valueFields);
  props.push("value");

  if (!Empty(this.objConfig.labelsGrid)) {
    var progrIndex = 0;
    if (!Empty(this.objConfig.labelsGrid.key)) {
      var labval = this.objConfig.labelsGrid.key.split(",");
      if (!Empty(labval[0]))
        fields[progrIndex] = labval[0];
      progrIndex++;
      if (!Empty(this.geoSubField)) {
        if (!Empty(labval[1]))
          fields[progrIndex] = labval[1];
        progrIndex++;
      }
    }

    if (!Empty(this.seriesField)) {
      if (!Empty(this.objConfig.labelsGrid.serie))
        fields[progrIndex] = this.objConfig.labelsGrid.serie;
      progrIndex++;
    }

    if (!Empty(this.objConfig.labelsGrid.values))
      fields[progrIndex] = this.objConfig.labelsGrid.values;
  }

  //table header
  var td, innerdiv,
    i;
  for (i = 0; i < fields.length; i++) {
    td = document.createElement("td");
    td.className = "grid_title grid_cell_title grid_cell_title_table";
    innerdiv = document.createElement("div");
    // testo colonne campi
    innerdiv.textContent = fields[i] //this._GetGridColumnName(this.propertyName[i]);
    // this._SetGridColumnStyle(innerdiv, this.propertyName[i]);
    td.appendChild(innerdiv);
    thead.appendChild(td);
  }

  this.__gfields = fields.slice();
  for (i = 0; i < this.items.length; i++) {
    var vals = this.items[i],
      row = document.createElement("tr");
    row.style.height = "42px";
    if (i == 0 || i % 2 == 0) {
      row.className = "grid_rowodd";
    }
    else {
      row.className = "grid_row";
    }
    for (var b = 0; b < props.length; b++) {
      var cell = document.createElement("td"),
        div3 = document.createElement("div");
      div3.textContent = this._GetGridCellValue(vals[props[b]], (props[b] == "value"), vals);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}

ZtGeographicChart.prototype._GetGridCellValue = function (value, isValue, item) {
  if (!isValue)
    return value;
  // apply picture + funzione
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture) {
      return this.functionObj.GetValuePicture(this._GetItemForGrid(item));
    }
  }
  else
    return this.GetValuePicture(value);
}

ZtGeographicChart.prototype._GetItemForGrid = function (item) {
  var itm = { path_depths: [] };
  itm.path_depths.push({
    field: this.geoCountryField,
    value: item._0desc,
    key: item._0
  });

  if (!Empty(item._sub)) {
    itm.path_depths.push({
      field: this.geoSubField,
      value: item._subdesc,
      key: item._sub
    });
  }

  if (item.series)
    itm.series = item.series;
  itm.value = item.value;
  itm.field = this.valueFields[0];
  return itm;
}

ZtGeographicChart.prototype._GetItemObj = function (itemObject) {
  var sub = !Empty(this.geoSubLevel) ? "_" + this.geoSubLevel : "",
    ret = {
      series: itemObject.series,
      range: itemObject.range,
      value: itemObject.value,
      selIdx: itemObject.idx,
      rowIdx: itemObject.sidx,
      categoryCode: itemObject.categoryCode,
      geo_name: itemObject._0desc + (!Empty(sub) ? (" - " + itemObject[sub + "desc"]) : ""),
      cname: Empty(itemObject._0) ? "" : (itemObject._0 + (!Empty(sub) ? ("_" + itemObject[sub]) : "")),
      sub_name: !Empty(sub) ? ("_" + itemObject[sub]) : "",
      isSelected: itemObject.isSelected,
      focus: itemObject.focus,
      multidimCurrentKey: this.appliedKey,
      isNull: itemObject.isNull,
	  color: itemObject.color
    };
  return ret;
}

ZtGeographicChart.prototype._GetDrawingList = function () {
  return this.mapDefinition.codes || [];
}

ZtGeographicChart.prototype.AddCtrlsZoom = function () {
  if (this.objConfig.zooming && this.objConfig.zooming.enabled && this.objConfig.zooming.controls) {
    var _this = this,
      zoomGroup = this.renderer.append("g")
        .attr("class", "ztchart_zoom")
        .attr("transform", "translate(" + [this.margin.left + 2, this.margin.top + 2] + ")"),
      h_p = getOffsetHeight(this.GetZoomIcon("plus"), this.GetDefaultIconFont(), this.chartId),
      h_m = getOffsetHeight(this.GetZoomIcon(), this.GetDefaultIconFont(), this.chartId),
      offset = 5;

    zoomGroup.append("text")
      .attr("x", 0)
      .attr("y", h_p)
      .attr("zoom-type", "plus")
      .text(this.GetZoomIcon("plus"))
      .style("font-family", this.GetIconFont().name)
      .style("font-size", this.GetIconFont().size + "px")
      .style("fill", this.GetIconFont().color)
      .style("cursor", "pointer")
      .on("click", function () { _this.__zoom.scaleBy(_this.svg/*.transition().duration(750)*/, 1.3); });

    zoomGroup.append("text")
      .attr("x", 0)
      .attr("y", h_p + h_m + offset)
      .attr("zoom-type", "minus")
      .text(this.GetZoomIcon())
      .style("font-family", this.GetIconFont().name)
      .style("font-size", this.GetIconFont().size + "px")
      .style("fill", this.GetIconFont().color)
      .style("cursor", "pointer")
      .on("click", function () { _this.__zoom.scaleBy(_this.svg, 1 / 1.3); });
  }
}

ZtGeographicChart.prototype._GetOtherItemObj = function (item) {
  var str_item = JSON.stringify(item),
    tmp_item = JSON.parse(str_item);
  delete tmp_item.itm;
  return tmp_item;
}

ZtGeographicChart.prototype._ApplyMouseOver = function (elm) {
  var _this = this,
    mRefChart = this._ZtChart.StdChart,
    itemObject = this._GetItems()[d3.select(elm).attr("item-index")];
  mRefChart._hoverItem = itemObject;
  d3.select(elm)
    .style("fill", function () {
      if (!Empty(_this.defSettings.hoverColor))
        return _this.defSettings.hoverColor;
      return d3.rgb(itemObject.colorApplied).darker().toString();
    })
    .style("cursor", function () {
      if (!_this._ZtChart.enableClick)
        return "default";
      return "pointer";
    })
    .on("mousemove", function () {
      mRefChart.ClearHoverTimeout();
    })
    .on("mouseout", function () {
      mRefChart.RemoveHoverTimeout();
      d3.select(elm).style("fill", itemObject.colorApplied);
    })
    .on("click", function () {
      _this._ApplyClick(itemObject, d3.mouse(elm));
    });

  mRefChart._d3mouse = d3.mouse(elm);
  mRefChart._d3event = d3.event;
  setTimeout(function (mRefChart, item, itemObject) {
    if (mRefChart._hoverItem && mRefChart._CheckIdentityItem(mRefChart._hoverItem, itemObject))
      _this.ShowTooltip(mRefChart, item, itemObject);
  }, 50, mRefChart, elm, itemObject);

  _this.MoveRangeCursor(itemObject.value, itemObject.isNull);
}

ZtGeographicChart.prototype._GetOtherTooltipObject = function () {
  return this.linkObj.tooltipObj.geomarkers;
}