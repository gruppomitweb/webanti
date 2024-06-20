/* global myZtCharts  */
/* exported applyChartMenuFnc getZFChartMacroType setFont drawLegendItems getPathBetweenXCoord
    optimizeFontSize setDefaultChart getList getListBySeries getDuplicatesList getDuplicatesListXYZ
    getAbsList getValues getGeneralMarginsObject getMargin notifyDraw getTreemapDataset
    getWaterfallDifferenceDataset getRadarDataset getParetoLineDataset getWordMinMaxIndex
    getMeasureMinMax howManyDigits isNumberFloat estimateMaximumTickLabel getLargerTickUnit
    getCeilingTickUnit getStandardTickUnits setTicks setColorSeriesArray getWizardPlotColors
    getDomNodeSizes recursivediv getStackDataset accumulateValuesOnColumn getMaxValueStack
    get3DColor setOtherChartsArray getImgSrc getY getX replaceSpecialCharsForFileName
    replaceSpecialCharsForID replaceIconFontWithUnicode replaceIconFontWithCharCode
    trasposeMatrix getDefaultRangeBands getRangeContOrDisc getIntervalRange getRangeBandsWithValues
    getListFromObjectArray getColorsArrayDarker getRangeColor getPercentDataset btwn
    line_line_intersect zeroFilledArray getTreemapLayout convertCsv convertXml
    getFilterType recursiveNodePattern getTimeTickFormat calcTimeOffset getTimingDivisor
    calcTimeOffsetBtw2Date calcDistanceDifferentTimeUnit setTimeTicks numRoundTo
    getMagnitudeOrder fileExists invertColor makeParameterStringFromLinkObj canDrawInContainer
    getAlternativeChartType wrapspace getD3TimeObject getMaxWordLengthForWrap
    getTimeFormatSeparator isNumeric getHieDataset getForceDataset getMatrixLinksDataset
    getMatrixDependencies getAllFonts getDuplicatesListCAT getSankeyNodesDataset getChartFunctionGroup
    getChartFamilyGroup mergeDeep getScrollTop makeParameterStringFromOverlapLinkObj arrayCompare
    decodeConditionalFormatting getMultichromaticRangeColorPV getAllDefaultColors
  */
function getAllCharts(subdivide) {
  // riportata in PortalCommonsJS
  if (subdivide) {
    return {
            category: {
              vbars: ["VBAR","VBAR3D","PARETO","WATERF","LAYEREDBAR"],
              pies: ["PIE","PIE3D","RING","RINGPERC"],
              line: ["LINES","AREA","STACKEDAREA","RADARLINE","RADARAREA"],
              stackedbars: ["HSTACKBAR","HSTACKBAR3D","VSTACKBAR","VSTACKBAR3D"],
              hbars: ["HBAR","HBAR3D","PYRAMID","LAYEREDBARH"],
              maps: ["TREEMAP","TREEMAPBAR","TREEMAPBARH","WORDCLOUD"],
              meter: ["ARCDIAL","THERMO"],
              state: ["LIGHTS","IMAGES"],
              counters: ["DISPLAY","COUNTER","PADDLE"]
            },
            xyz: {
              xy: ["SCATTER","ASTER","AREABAR","VORONOI"],
              yz: ["BUBBLE"]
            },
            geo: {
              gmap: ["GEOMAP"]
            },
            hie: {
              structure: ["SUNBSTR", "TREESTR", "CPACKSTR", "FORCESTR"],
              values: ["SUNB", "TREE", "CPACK", "FORCE", "MARIMEKKO"]
            },
            dep: {
              rel: ["MATRIX", "CHORD", "SANKEY"]
            },
            classif: {
              map: ["BCMATRIX"]
            }
          };
  }
  return { category: [ "HBAR","HBAR3D","PYRAMID","LAYEREDBARH",
                      "PIE","PIE3D","RING","RINGPERC",
                      "WORDCLOUD",
                      "HSTACKBAR","HSTACKBAR3D","VSTACKBAR","VSTACKBAR3D",
                      "LINES","AREA","STACKEDAREA","RADARLINE","RADARAREA",
                      "VBAR","VBAR3D","PARETO","WATERF","LAYEREDBAR",
                      "ARCDIAL","THERMO",
                      "LIGHTS","IMAGES",
                      "DISPLAY","COUNTER","PADDLE",
                      "CAL",
                      "PYR", "NECKEDPYR", "PYRSTR", "NECKEDPYRSTR", "FUNNEL",
                      "PCOORDS"
                    ],
           xyz: ["SCATTER", "BUBBLE", "ASTER", "AREABAR","VORONOI"],
           geo: ["GEOMAP"],
           hie: ["SUNB", "SUNBSTR", "TREE", "TREESTR", "CPACK", "CPACKSTR", "FORCE", "FORCESTR",
                  "TREEMAP","TREEMAPBAR","TREEMAPBARH", "MARIMEKKO"
                ],
           dep: ["MATRIX", "CHORD", "SANKEY"],
           classif: ["BCMATRIX"]
         };
}

function getZFChartMacroType(type) {
  // riportata in PortalCommonsJS
  var mtypes = getAllCharts(),
      mkeys = Object.keys(mtypes),
      found = false,
      rt = "";
  for (var t = 0; !found && t < mkeys.length; t++) {
    if (mtypes[mkeys[t]].indexOf(type) >= 0) {
      rt = mkeys[t];
      found = true;
    }
  }
  return rt;
}

function getChartFunctionGroup(type) {
  var fncs = {
    comp: ["LINES","RADARLINE","RADARAREA","AREA","STACKEDAREA",
                  "PCOORDS","VBAR","HBAR","VSTACKBAR","HSTACKBAR",
                  "LAYEREDBAR","LAYEREDBARH","TREEMAPBAR","TREEMAPBARH",
                  "PYRAMID","ARCDIAL","THERMO","DISPLAY","COUNTER","PADDLE",
                  "LIGHTS","IMAGES"],
    distr: ["LINES","AREA","STACKEDAREA","VBAR","HBAR","WATERF",
                    "PYRAMID","AREABAR","SCATTER","BUBBLE","PARETO",
                    "FUNNEL","ASTER","VORONOI"],
    rel: ["RADARLINE","RADARAREA","PCOORDS","SCATTER","BUBBLE",
                    "SUNB","SUNBSTR","TREE","TREESTR","CPACK","CPACKSTR",
                    "FORCE","FORCESTR","TREEMAP","TREEMAPBAR","TREEMAPBARH",
                    "CHORD","MATRIX","BCMATRIX","VORONOI"],
    ovtime: ["LINES","RADARLINE","RADARAREA","AREA","STACKEDAREA",
                       "VBAR","HBAR","WATERF","CAL"],
    fhie: ["MARIMEKKO","SUNB","SUNBSTR","TREE","TREESTR","CPACK","CPACKSTR",
                "FORCE","FORCESTR","TREEMAP","TREEMAPBAR","TREEMAPBARH"],
    ptw: ["MARIMEKKO","PIE","RING","ASTER","PYR","PYRSTR",
                      "WORDCLOUD","SUNB","SUNBSTR","TREE","TREESTR",
                      "CPACK","CPACKSTR","FORCE","FORCESTR","TREEMAP",
                      "TREEMAPBAR","TREEMAPBARH", "RINGPERC"],
    con: ["WORDCLOUD","TREE","TREESTR","FORCE","FORCESTR"],
    loc: ["GEOMAP"]
  };

  var kfnc = Object.keys(fncs),
  rets = [];
  for (var i = 0; i < kfnc.length; i++) {
    if (fncs[kfnc[i]].indexOf(type) >= 0)
      rets.push(kfnc[i]);
  }

  return rets;
}

function getChartFamilyGroup(type) {
  var fams = {
    car: ["LINES","RADARLINE","RADARAREA","AREA","STACKEDAREA",
          "PCOORDS","VBAR","HBAR","VSTACKBAR","HSTACKBAR",
          "LAYEREDBAR","LAYEREDBARH","TREEMAPBAR","TREEMAPBARH",
          "WATERF","PYRAMID","AREABAR","SCATTER","BUBBLE","ARCDIAL",
          "THERMO","PARETO","MARIMEKKO","FUNNEL","BCMATRIX"],
    ind: ["ARCDIAL","THERMO","LIGHTS","IMAGES","DISPLAY","COUNTER","PADDLE","BCMATRIX"],
    aer: ["MARIMEKKO","PIE","RING","ASTER","PYR","PYRSTR","WORDCLOUD",
          "SUNB","SUNBSTR","CPACK","CPACKSTR","TREEMAP","CHORD","RINGPERC"],
    gra: ["TREE","TREESTR","FORCE","FORCESTR","CHORD","VORONOI"],
    tab: ["MATRIX","CAL"],
    gsp: ["GEOMAP"]
  };

  var kfam = Object.keys(fams),
  rets = [];
  for (var i = 0; i < kfam.length; i++) {
    if (fams[kfam[i]].indexOf(type) >= 0)
      rets.push(kfam[i]);
  }

  return rets;
}

function setFont(item, itemFont, chart) {
  if (!(item))
    return;
  if (item._groups.length == 0)
    return;
  if (item._groups[0][0] == null)
    return;

  var stObj = {
    font9family : itemFont.name,
    font9size : itemFont.size + "px"
  }

  if (Empty(itemFont.color))
    stObj.fill = "#000000";
  else
    stObj.fill = itemFont.color;

  if (itemFont.style == "B")
    stObj.font9weight = "bold";
  else if (itemFont.style == "I")
    stObj.font9style = "italic";
  else if (itemFont.style == "BI") {
    stObj.font9style = "italic";
    stObj.font9weight = "bold";
  }
  else
    stObj.font9style = "normal";

  item.attr("style", makeStyleHTMLString(stObj, item.attr("style")));

  if (chart)
    chart.SetUsedFont(itemFont);
}

function drawLegendItems(container, icon, list, idicon, idtext, hexCode, stdChart, isRange) {
  var legendGroup,
  legendItem,
  isNeg,
  isAgg;
  for (var i = 0; i < list.length; i++) {
    isNeg = list[i] == stdChart.Translate("ZTC_NEGVAL");
    isAgg = (stdChart.aggregateData && list[i] == stdChart.aggregateData.label);
    legendGroup = container.append("g");
    var check = isRange ? true : stdChart._IsNotExcluded(i);

    if (!isNeg && !isRange) {
      if (stdChart._ZtChart.enableExclude) {
        legendItem = legendGroup.append("text")
        .attr("id", idtext + 'filter_' + i)
        .attr("class", "ztchart_legend_icon_small")
        .attr("data-font", check ? stdChart.GetCheckIconCode() : stdChart.GetUncheckIconCode())
        .attr("data-index", i)
        .attr("data-check", check)
        .attr("data-text", list[i])
        .style("cursor", "pointer")
        .style("font-family", stdChart.GetDefaultIconFont().name)
        .style("font-size", stdChart.GetDefaultIconFont().size)
        .style("fill", stdChart.GetDefaultIconFont().color)
        .text(getIconFromCode(check ? stdChart.GetCheckIconCode() : stdChart.GetUncheckIconCode()))
        .on("click", function () {
          stdChart._ApplyLegendExclude(this);
        });
      }
    }

    legendItem = legendGroup.append("text")
      .attr("id", idicon + i)
      .attr("class", "ztchartfonticon legendItem" + (isRange ? "range" : ""))
      .attr("data-font", (hexCode.constructor != Array) ? hexCode : hexCode[i])
      .attr("data-index", i)
      .attr("data-text", list[i])
      .attr("data-negative", isNeg)
      .attr("data-aggregate", isAgg)
      .attr("data-range", isRange || false)
      .style("font-family", stdChart.GetDefaultIconFont().name)
      .style("font-size", stdChart.GetLegendIconSize())
      .text((icon.constructor != Array) ? icon : icon[i]);

    if (!isNeg) {
      legendItem.style("cursor",function(){
        if (!stdChart._ZtChart.enableLegendClick)
          return "default";
        return "pointer"
      })
      .on("mouseover", function() {
        if (!stdChart._ZtChart.enableLegendEffect)
          return;
        stdChart._ApplyLegendMouseOver(this);
      })
      .on("mouseout", function() {
        if (!stdChart._ZtChart.enableLegendEffect)
          return;
        stdChart._ApplyLegendMouseOut(this);
      })
      .on("click", function() {
        if (!stdChart._ZtChart.enableLegendClick)
          return;
        stdChart._ApplyLegendClick(this);
      })
    }
    else
      legendItem.style("cursor", "default");

    legendItem = legendGroup.append("text")
      .attr("id", idtext + i)
      .attr("class", "legendItem" + (isRange ? "range" : ""))
      .attr("data-index", i)
      .attr("data-range", isRange || false)
      .attr("data-text", list[i])
      .style("cursor", "default")
      .text(list[i]);

    if (!isNeg) {
      legendItem.style("cursor",function(){
        if(!stdChart._ZtChart.enableLegendClick)
          return "default";
        return "pointer"
      })
      .on("mouseover", function() {
        if(!stdChart._ZtChart.enableLegendEffect)
          return;
        stdChart._ApplyLegendMouseOver(this);
      })
      .on("mouseout", function() {
        if(!stdChart._ZtChart.enableLegendEffect)
          return;
        stdChart._ApplyLegendMouseOut(this);
      })
      .on("click", function() {
        if(!stdChart._ZtChart.enableLegendClick)
          return;
        stdChart._ApplyLegendClick(this);
      })
    }
    else
      legendItem.style("cursor", "default");
  }
}

function getPathBetweenXCoord(x1, x2, line, lastLen, reverse) {
  var tmppts = [];
  var f = false;
  var i = lastLen;
  while (!f) {
    var point = line.getPointAtLength(i);
    if (point.x >= x1)
      tmppts.push(point.x + "," + point.y);
    f = point.x >= x2;
    i++;
  }
  if (reverse)
    return {path: "L" + tmppts.reverse().join("L"), lastLen: i-2, lastY: point.y};
  return {path: "L" + tmppts.join("L"), lastLen: i-2, lastY: point.y};
}

function optimizeFontSize(pos, txt, initFont, item, fontRed, chartId) {
  var retobj = {},
  orgsize = initFont.size,
  txtW = getOffsetWidth(txt, initFont, chartId),
  txtH = getOffsetHeight(txt, initFont, chartId),
  mbox,
  mmb,
  isOK;
  retobj.txt = txt;
  if (item.r) {
    mmb = item.itm.getBBox();
    mbox = { x : mmb.x,
             y : mmb.y,
             width : 2 * item.r,
             height : 2 * item.r
           };
  }
  else if (Empty(item.x + "") || Empty(item.y + "") || Empty(item.width + "") || Empty(item.height + ""))
    mbox = item.itm.getBBox();
  else
    mbox = { x: item.x,
             y: item.y,
             width: item.width,
             height: item.height
           };
  if (pos == "in") {
    // ci provo in H
    isOK = false;
    if (txtW < mbox.width && txtH < mbox.height) {
      isOK = true;
    }
    else {
      initFont.size = initFont.size - initFont.size * fontRed;
      txtW = getOffsetWidth(retobj.txt, initFont, chartId);
      txtH = getOffsetHeight(retobj.txt, initFont, chartId);
      if (txtW < mbox.width && txtH < mbox.height) {
        isOK = true;
      }
    }
    // ora in V
    if (!isOK) {
      initFont.size = orgsize;
      txtW = getOffsetWidth(retobj.txt, initFont, chartId);
      txtH = getOffsetHeight(retobj.txt, initFont, chartId);
      if (txtW < mbox.height && txtH < mbox.width) {
        retobj.isV = true;
        isOK = true;
      }
      else {
        initFont.size = initFont.size - initFont.size * fontRed;
        txtW = getOffsetWidth(retobj.txt, initFont, chartId);
        txtH = getOffsetHeight(retobj.txt, initFont, chartId);
        if(txtW < mbox.height && txtH < mbox.width) {
          retobj.isV = true;
          isOK = true;
        }
      }
    }
    if (!isOK)
      retobj.txt = "";
  }
  else {
    if (txtW > mbox.width) {
      initFont.size = initFont.size - initFont.size * fontRed;
      txtW = getOffsetWidth(retobj.txt, initFont, chartId);
      if (txtW > mbox.width)
        retobj.txt = "";
    }
    if (txtH > mbox.height && !Empty(retobj.txt)) {
      initFont.size = initFont.size - initFont.size * fontRed;
      txtH = getOffsetHeight(retobj.txt, initFont, chartId);
      if (txtH > mbox.height)
        retobj.txt = "";
    }
  }
  retobj.font = JSON.stringify(initFont);
  retobj.txtH = getOffsetHeight(retobj.txt, initFont, chartId);
  retobj.txtW = getOffsetWidth(retobj.txt, initFont, chartId);
  return retobj;
}

function getChartMacroCategoryType(type) {
  switch (type) {
    case "SCATTER":
    case "BUBBLE":
    case "ASTER":
    case "AREABAR":
      return "xyz";
      break;
    case "GEOMAP":
      return "geo";
      break;
    case "SUNB":
    case "SUNBSTR":
    case "TREE":
    case "TREESTR":
    case "CPACK":
    case "CPACKSTR":
    case "FORCE":
    case "MARIMEKKO":
      return "hie";
      break;
    case "FORCESTR":
    case "MATRIX":
      return "dep";
    default:
      return "category";
      break;
  }
}

function setDefaultChart(o1, webroot) {
  var o2 = getDefaultObjChartDef(webroot);
  var ret = mergeDeep (o1, o2);
  if (o2 && o2.globalSettings)
    ret.globalSettings.fileVersion = o2.globalSettings.fileVersion;
  return ret;
}

function getDefaultObjChartDef(webroot) {
  if (Empty(webroot)) {
    if (ZtVWeb && !Empty(ZtVWeb.SPWebRootURL))
      webroot = ZtVWeb.SPWebRootURL;
    else 
      webroot = '..';
  }
  var def = new JSURL(webroot + "/servlet/SPChartServlet?action=getDefault", true);
  def = def.Response();
  if (def.charAt(0) != "{" || def == "ACCESS DENIED")
    return {};
  return JSON.parse(def);
}

function mergeDeep (o1, o2) {
    var tempNewObj = o1;
    if(o1==null) return o2;
    //if o1 is an object - {}
    if(o1.length === undefined && typeof o1 !== "number" && typeof o1 != "function") {
      for(var key in o2){
        if(typeof o2[key]=="function")
          continue;
        var value = o2[key];
        if(o1[key] === undefined) {
          tempNewObj[key] = value;
        } else {
          tempNewObj[key] = mergeDeep(o1[key], o2[key]);
        }
      }
    }
    //else if o1 is an array - []
    else if(o1.length > 0 && typeof o1 !== "string" && typeof o1 != "function") {
      for(var indexc in o2){
        if(typeof o2[indexc] == "function")
          continue;
        if(o1[indexc] === undefined){
          tempNewObj.push(o2[indexc]);
        }
        else{
          var tmp = mergeDeep(o1[indexc], o2[indexc]);
          tempNewObj[indexc] = tmp;
        }
      };
    }
    //handling other types like string or number
    else if(typeof o1 != "function"){
      //taking value from the second object o2
      //could be modified to keep o1 value with tempNewObj = o1;
      //if(typeof o1 !== "undefined") -- corretto EG
      if(/*(Empty(o2+"") && !Empty(o1+"")) || (!Empty(o2+"") && !Empty(o1+"") && */o1!==o2)
        tempNewObj = o1;
      else
        tempNewObj = o2;
    }
    return tempNewObj;
}

function getList(index, dataSet, dup) {
	var array = [];
	if (index >= 0) {
		dataSet.forEach(function (record) {
      if( record != null ) {
        if (dup)
          array.push(record[index]);
        else if (array.indexOf(record[index]) < 0)
          array.push(record[index]);
      }
		});
	}
	return array;
}

function getListBySeries(index, dataSet, seriesIndex, dup) {
  var array = [],
  value;
	if (index >= 0 && seriesIndex >= 0) {
		dataSet.forEach(function (record) {
      if( record != null ) {
        if(!array[record[seriesIndex]])
          array[record[seriesIndex]] = [];
        value = parseFloat(record[index]);
        if (dup)
          array[record[seriesIndex]].push(value);
        else if (array[record[seriesIndex]].indexOf(value) < 0)
          array[record[seriesIndex]].push(value);
      }
		});
	}
	return array;
}

function getDuplicatesList(index, dataSet, mcounter) {
	var array = [];
	var count = [];
  var setCount = false;
	if(index!=-1){
		dataSet.forEach(function(record){
      if( record !=null ) {
        if((Empty(mcounter) || (mcounter && !mcounter[record[index].toString()])) && array.indexOf(record[index])<0 && array.indexOf(record[index].toString() + " ("+count[record[index].toString()]+")")<0){
          array.push(record[index].toString());
          count[record[index].toString()] = 1;
        }
        else {
          if (mcounter && mcounter[record[index].toString()] && !setCount) {
            count[record[index].toString()] = mcounter[record[index].toString()];
            setCount = true;
          }
          if (count[record[index].toString()]==1)
            array[array.indexOf(record[index].toString())] = record[index].toString() + " ("+count[record[index].toString()]+")";
          count[record[index].toString()]++;
          array.push(record[index].toString() + " ("+count[record[index].toString()]+")");
        }
     }
		});
	}
	return {array:array, countobj:count};
}

function getDuplicatesListXYZ(keyidx, dupidx, dataSet, mcounter) {
	var array = [];
	var karray = [];
	var count = [];
  var setCount = false;
	if (keyidx != -1) {
		dataSet.forEach(function(record) {
      if( record !=null ) {
        if (karray.indexOf(record[keyidx]) < 0) {
          karray.push(record[keyidx].toString());
          if ((Empty(mcounter) || (mcounter && !mcounter[record[dupidx].toString()])) && !count[record[dupidx].toString()]) {
            count[record[dupidx].toString()] = 1;
            array.push(record[dupidx].toString());
          }
          else {
            if (mcounter && mcounter[record[dupidx].toString()] && !setCount) {
              count[record[dupidx].toString()] = mcounter[record[dupidx].toString()];
              setCount = true;
            }
            if(count[record[dupidx].toString()]==1)
              array[array.indexOf(record[dupidx].toString())] = record[dupidx].toString() + " ("+count[record[dupidx].toString()]+")";
            count[record[dupidx].toString()] ++;
            array.push(record[dupidx].toString() + " (" + count[record[dupidx].toString()] + ")");
          }
        }
      }
		});
	}
	return {array:array, countobj:count};
}

function getAbsList(index, dataSet, dup) {
	var array = [];
	if (index >= 0) {
		dataSet.forEach(function (record) {
      if( record != null ) {
        if (dup)
          array.push(Math.abs(record[index]));
        else if (array.indexOf(record[index]) < 0)
          array.push(Math.abs(record[index]));
      }
		});
	}
	return array;
}

function getValues(valueFields, propertyName, dataSet) {
	var ret = [];
	valueFields.forEach(function (values) {
    if (!Empty(values)) {
      var indexVal = propertyName.indexOf(values);
      dataSet.forEach(function(record) {
        if( record!= null )
        ret.push(parseFloat(record[indexVal]));
      });
    }
	});
	return ret;
}

function decimalPlaces(num) {
  var match = ('' + num).match(/(?:\.(\d+))?(?:[eE]([+-]?\d+))?$/);
  if (!match) { return 0; }
  return Math.max(
          0,
          // Number of digits right of decimal point.
          (match[1] ? match[1].length : 0)
          // Adjust for scientific notation.
          - (match[2] ? +match[2] : 0)
        );
}

function getLegendSize(chartId, list, settings, chartLegendObj, gradient, isrange) {
	var h = 0,
  w = 0,
	offset = 5,
	check = false,
  icon = isrange ? 0 : 14,
  font = appliedFont(settings, chartLegendObj.obj, chartLegendObj.obj.textFont),
  sum = 0;

  if (!isrange || gradient == "none" || Empty(gradient)) {
    var i;
    switch (chartLegendObj.position) {
      case "top":
      case "bottom":
        for (i = 0; i < list.length; i++) {
          h = Math.max(14, getOffsetHeight(list[i], font, chartId));
          w += icon + 16 + getOffsetWidth(list[i], font, chartId);
          sum += w;
        }
        h = h + offset;
        if (sum >= settings.globals.width)
          check = true;
        break;
      case "left":
      case "right":
        w = (4 * offset) + icon + 16 + getOffsetWidth(getMaxWordLengthString(list), font, chartId);
        h = 5;
        for (i = 0; i < list.length; i++) {
          h += getOffsetHeight(list[i], font, chartId) + offset;
        }
        break;
      case "hide":
        break;
    }
  }
  else if (isrange) {
    switch (chartLegendObj.position) {
      case "top":
      case "bottom":
        w = settings.globals.width * 0.75;
        h = 14 + 15 + getOffsetHeight(getMaxWordLengthString(list), font, chartId);
        break;
      case "left":
      case "right":
        h = settings.globals.height * 0.75;
        w = 14 + 15 + getOffsetWidth(getMaxWordLength(list), font, chartId);
        break;
      case "hide":
        break;
    }
  }
	return {width: Math.round(w), height: Math.round(h), tooLong: check};
}

function appliedFont(chartSettings, labelObj, objFont) {
	var ret = objFont;
  if (labelObj.useLegendFont)
    ret = appliedFont(chartSettings, chartSettings.chartLegend, chartSettings.chartLegend.textFont);
	else if (labelObj.useValueFont)
    ret = appliedFont(chartSettings, chartSettings.valueAxis, chartSettings.valueAxis.valueFont);
  else if (labelObj.useGlobalFont)
    ret = chartSettings.globalFont;
	return ret;
}

function getOffsetHeight(labelText, labelFont, chartId) {
	var mySpan = getSpanTag(chartId);
	if (labelText != "") {
		mySpan.innerHTML = labelText;
		mySpan.style.fontFamily = labelFont.name;
		mySpan.style.fontStyle = labelFont.style;
		mySpan.style.fontWeight = labelFont.weight;
		mySpan.style.fontSize = labelFont.size+'px';
		return mySpan.offsetHeight;
	}
	else
		return 0;
}

function getOffsetWidth(labelText, labelFont, chartId) {
	var mySpan = getSpanTag(chartId);
	if (labelText != "") {
		mySpan.innerHTML = labelText;
		mySpan.style.fontFamily = labelFont.name;
		mySpan.style.fontStyle = labelFont.style;
		mySpan.style.fontWeight = labelFont.weight;
		mySpan.style.fontSize = labelFont.size+'px';
		return mySpan.offsetWidth;
	}
	else
		return 0;
}

function getSpanTag(chartId) {
	var spanId = chartId+"myspan";
	var mySpan = document.getElementById(spanId);
	if(Empty(mySpan)){
		mySpan = document.createElement("span");
		mySpan.id = spanId;
		mySpan.className = "ztchart_span";
		document.body.appendChild(mySpan);
		mySpan.style.visibility='hidden';
		mySpan.style.display='inline-block';
	}
	return mySpan;
}

function getGeneralMarginsObject(chartId, settings, chartLegends, title, legendList) {
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  var myM={};

  //titolo
  myM = setMarginObject(title, settings.chartTitle.textFont, settings.chartTitle.useGlobalFont, settings.globalFont);
  if (myM != 0) {
    myM.type = "title";
    ret[settings.chartTitle.position].push(myM);
  }

  //legenda
  var ml, stroke;
  if (chartLegends.series && chartLegends.series.position != 'hide' && !chartLegends.series.hide) {
    myM = setMarginObject(getMaxWordLength(legendList), chartLegends.series.obj.textFont, chartLegends.series.obj.useGlobalFont, settings.globalFont);
    ml = getLegendSize(chartId, legendList, settings, chartLegends.series);
    myM.addH = ml.height;
    myM.addW = ml.width;
    stroke = chartLegends.series.obj.extendLine.stroke?chartLegends.series.obj.extendLine.stroke:1;
    if (myM != 0) {
      myM.type = "legend_series";
      myM.offset = 5;
      if (chartLegends.series.position == 'left') {
        myM.textorientation = 0;
        myM.offset = 10;
        myM.addW = myM.addW + 2 * stroke;
        ret.left.push(myM);
      }
      else if (chartLegends.series.position == 'right') {
        myM.textorientation = 0;
        myM.offset = 10;
        myM.addW = myM.addW + 2 * stroke;
        ret.right.push(myM);
      }
      else if (chartLegends.series.position == 'bottom')
        ret.bottom.push(myM);
      else
        ret.top.push(myM);
    }
  }

  //sottotitolo
  if(settings.chartSubtitle){
    myM = setMarginObject(settings.chartSubtitle.text, settings.chartSubtitle.textFont, settings.chartSubtitle.useGlobalFont, settings.globalFont);
    if (myM != 0) {
      myM.type = "subtitle";
      myM.offset = 5;
      ret[settings.chartSubtitle.position].push(myM);
    }
  }

  //legenda range
  if (chartLegends.range && chartLegends.range.position != 'hide' && !chartLegends.range.hide) {
    myM = setMarginObject(getMaxWordLengthString(settings.range.labels), chartLegends.range.obj.textFont, chartLegends.range.obj.useGlobalFont, settings.globalFont);
    ml = getLegendSize(chartId, settings.range.labels, settings, chartLegends.range, settings.range.gradient, true);
    myM.addH = ml.height;
    myM.addW = ml.width;

    stroke = chartLegends.range.obj.extendLine.stroke ? chartLegends.range.obj.extendLine.stroke : 1;
    if (myM != 0) {
      myM.type = "legend_range";
      if (chartLegends.range.position == 'left') {
        myM.textorientation = 0;
        myM.addW = myM.addW + 2 * stroke;
        ret.left.push(myM);
      }
      else if (chartLegends.range.position == 'right') {
        myM.textorientation = 0;
        myM.addW = myM.addW + 2 * stroke;
        ret.right.push(myM);
      }
      else if (chartLegends.range.position == 'bottom')
        ret.bottom.push(myM);
      else
        ret.top.push(myM);
    }
  }

  return ret;
}

function setMarginObject(item, itemFont, useGlobalFont, globalFont) {
	var obj;
	if(item && item.length>0){
		if(useGlobalFont == true)
			obj = getGenericLabelConf(itemFont, globalFont);
		else
			obj = getGenericLabelConf(itemFont);
		obj.textorientation = 90;
		obj.text = item;
		return obj;
	}
	else
		return 0;
}

function getMaxWordLength(myList, precision, fnc) {
  if (precision == undefined)
    precision = 0;
	var myMax = LRTrim(setPrecision(myList[0]));
	for(var i=1; i<myList.length; i++){
    var m = LRTrim(setPrecision(myList[i]));
		if(m.length > myMax.length)
			myMax = m;
	}
	return myMax;

  function setPrecision(mval){
    var msval = mval + "";
    if (Empty(msval))
      return "";
    var mm = msval.toString();
    var isNumber = !isNaN(parseFloat(msval));
    if(isNumber){
      mm = parseFloat(mm).toFixed(precision);
    }
    if(fnc) {
      mm = fnc(mm);
    }
    if(isNumber) mm = mm + "W"; //spacing per i numeri
    return mm;
  }
}

function getMaxWordLengthString(myList/*, fnc*/) {
	var myMax = LRTrim(myList[0] + "");
	for(var i=1; i<myList.length; i++){
		var m = LRTrim(myList[i] + "");
		if(m.length >= myMax.length)
			myMax = m;
	}
	return myMax;
}

function getGenericLabelConf(labeljson, globalfont) {
	var myM={};
	if(Empty(globalfont)){
		myM.fontname = labeljson.name;
		myM.fontsize = labeljson.size;
		myM.fontstyle = labeljson.style;
	}
	else{
		myM.fontname = globalfont.name;
		myM.fontsize = globalfont.size;
		myM.fontstyle = globalfont.style;
	}

	// selezione per id
	if(myM.fontstyle=="B"){
		myM.fontstyle = 'normal';
		myM.fontweight = 'bold';
	}
	else if(myM.fontstyle=="I"){
		myM.fontstyle = 'italic';
		myM.fontweight = '';
	}
	else if(myM.fontstyle=="BI"){
		myM.fontstyle = 'italic';
		myM.fontweight = 'bold';
	}
	else{
		myM.fontstyle = 'normal';
		myM.fontweight = '';
	}

	return myM;
}

function getMargin(myMzone, spanTag) {
	var ret = 0;
	var h=0;
	for(var i=0; i<myMzone.length; i++){
		h=0;
		spanTag.innerHTML = myMzone[i].text;
		spanTag.style.fontFamily = myMzone[i].fontname;
		spanTag.style.fontStyle = myMzone[i].fontstyle;
		spanTag.style.fontWeight = myMzone[i].fontweight;
		spanTag.style.fontSize = myMzone[i].fontsize+'px';
		if(myMzone[i].textorientation == 90) { //top + bottom
			if(myMzone[i].offset)
				h+=myMzone[i].offset;
			if(myMzone[i].addH)
				h+=myMzone[i].addH;
			else
				h+=spanTag.offsetHeight;
		}
		else if(myMzone[i].textorientation == 45 || myMzone[i].textorientation == -45) {
			if(myMzone[i].offset)
				h+=myMzone[i].offset;
			if(myMzone[i].addW)
				h+=myMzone[i].addW;
			else
				 //h+=(spanTag.offsetWidth*Math.cos(45*Math.PI/180));
				//h += Math.sqrt(Math.pow(spanTag.offsetHeight, 2) + Math.pow(spanTag.offsetWidth, 2));
				h += Math.max(spanTag.offsetWidth, spanTag.offsetHeight) - Math.min(spanTag.offsetWidth, spanTag.offsetHeight);
		}
		else { //left + right
			if(myMzone[i].offset)
				h+=myMzone[i].offset;
			if(myMzone[i].addW)
				h+=myMzone[i].addW;
			else
				h+=spanTag.offsetWidth;
		}
		ret+=h;
		myMzone[i].height=h
	}
	return ret;
}

var notifyDraw = function(obj, fn) {
	if (obj.drawingState) {
		obj.lastDrawFnc = fn;
		obj.lastDrawArgs = arguments;
		obj.lastDrawCounters ++;
	}
	else {
		obj.drawingState = true;
		var _arguments = arguments;
		if (obj.lastDrawTimer) clearTimeout(obj.lastDrawTimer);
		obj.lastDrawTimer = setTimeout(function (_arguments) {
            var args=[], i, l;
			obj.drawingState = false;
			if (obj.lastDrawFnc) {
				for(i=2,l=obj.lastDrawArgs.length; i<l; args.push(obj.lastDrawArgs[i++]));
					obj[obj.lastDrawFnc].apply(obj,args);
			}
			else {
				for(i=2,l=_arguments.length; i<l; args.push(_arguments[i++]));
					obj[fn].apply(obj,args);
			}
			obj.lastDrawCounters=0
			obj.lastDrawFnc=null;
			obj.lastDrawArgs=null;
		}, (!obj.drawStatic || obj.lastDrawCounters == 0) ? 0 : (obj.defSettings.animation.animate ? 2 * obj.defSettings.animation.duration : 500), _arguments);
	}
}

function getIconFromCode(hexcode) {
  return String.fromCharCode(parseInt(hexcode, 16));
}

function getTreemapDataset(data, indexCat, valueFields, propertyName, seriesList, keyF, categoryCodeIndex, byCategory, noGroup) {
  var treeMapData = { children : [], name : "root" },
  key = !Empty(keyF) ? propertyName.indexOf(keyF) : -1,
  catLab,
  serLab,
  i, j,
  //keyList,
  arrayData,
  idx;

  if (byCategory) {
    for (i = 0; i < data.length; i++) {
      arrayData = [];
      catLab = data[i][indexCat];
      for (j = 0; j < valueFields.length; j++) {
        idx = propertyName.indexOf(valueFields[j]);
        serLab = seriesList[j];
        arrayData.push({
          name : catLab,
          size : Math.abs(data[i][idx]),
          realValue : data[i][idx],
          serie : serLab,
          keyF : data[i][key],
          categoryCode : data[i][categoryCodeIndex],
          index : i,
          vIndex : j
        });
      }
      treeMapData.children.push({
        name : catLab,
        keyF : data[i][key],
        categoryCode : data[i][categoryCodeIndex],
        children : arrayData
      });
    }
  }
  else if (noGroup) {
    arrayData = [];
    for (i = 0; i < data.length; i++) {
      catLab = data[i][indexCat];
      for (j = 0; j < valueFields.length; j++) {
        idx = propertyName.indexOf(valueFields[j]);
        serLab = seriesList[j];
        arrayData.push({
          name : catLab,
          size : Math.abs(data[i][idx]),
          realValue : data[i][idx],
          serie : serLab,
          keyF : data[i][key],
          categoryCode : data[i][categoryCodeIndex],
          index : i,
          vIndex : j
        });
      }
    }
    treeMapData.children = arrayData;
  }
  else {
    for (j = 0; j < valueFields.length; j++) {
      arrayData = [];
      idx = propertyName.indexOf(valueFields[j]);
      for (i = 0; i < data.length; i++) {
        catLab = data[i][indexCat];
        serLab = seriesList[j];
        arrayData.push({
          name : catLab,
          size : Math.abs(data[i][idx]),
          realValue : data[i][idx],
          serie : serLab,
          keyF : data[i][key],
          categoryCode : data[i][categoryCodeIndex],
          index : i,
          vIndex : j
        });
      }
      treeMapData.children.push({
        name : valueFields[j],
        children : arrayData
      });
    }
  }

  return treeMapData;
}

function getWaterfallDifferenceDataset(dataset, withTotal) {
  if (Empty(dataset))
    return [];
  var ret = [];
  dataset.forEach(function (data, index) {
    ret.push(data.slice());
    if (!withTotal || index <= dataset.length - 2) {
      if (index == 0)
        ret[index][1] = 0;
      else
        ret[index][1] = dataset[index - 1][1];
    }
  });
  return ret;
}

function getRadarDataset(dataset, scaleY, width, height, angleRange, valueFields, propertyName) {
  if (Empty(dataset) || !scaleY)
    return [];
  var ret = [],
  obj = {},
  yIndex = -1,
  scale;
  dataset.forEach(function (data/*, index*/) {
    ret.push([]);
    for (var i = 0; i < valueFields.length; i++) {
      yIndex = propertyName.indexOf(valueFields[i]);
      scale = scaleY[valueFields[i]];
      obj = {};
      obj.x = width / 2 - (((height / 2 - scale(data[yIndex])) - height / 2) * Math.sin(angleRange[i] * Math.PI / 180));
      obj.y = height / 2 + (((height / 2 - scale(data[yIndex])) - height / 2) * Math.cos(angleRange[i] * Math.PI / 180));
      obj.yIndex = yIndex;
      ret[ret.length-1].push(obj);
    }
  });
  return ret;
}

function getParetoDataset(dataset) {
  if (Empty(dataset))
    return {data: [], sum: 0};
  var ret = [],
  sum = 0,
  val;
  dataset.forEach(
    function (record) {
      val = record.slice();
      val[1] = Math.abs(val[1]);
      ret.push(val.slice());
      sum = sum + val[1];
    }
  );
  ret.sort(
    function (a, b) {
      return d3.descending(a[1], b[1]);
    }
  );
  return {data: ret, sum: sum};
}

function getParetoLineDataset(dataset) {
  if (Empty(dataset))
    return [];
  var ret = [],
  pdata = getParetoDataset(dataset),
  sup = pdata.data,
  tmp = 0;
  sup.forEach( function (record/*, index*/) {
    ret.push(record.slice());
    tmp = tmp + record[1];
    ret[ret.length-1][1] = tmp;
  });
  return ret;
}

function getWordMinMaxIndex(valueFields, propertyName, dataSet, indexCat){
  var mval = 0,
  ret = {min: 0, max: 0, index: -1},
  y_index;
  for (var i = 0; i < valueFields.length; i++) {
    y_index = propertyName.indexOf(valueFields[i]);
    for (var j = 0; j < dataSet.length; j++) {
      ret.min = Math.min(ret.min, Math.abs(dataSet[j][y_index]));
      ret.max = Math.max(ret.max, Math.abs(dataSet[j][y_index]));
      if (mval < (dataSet[j][indexCat].length * Math.abs(dataSet[j][y_index]))){   // replace with W*len
        /** siccome la parola piu' lunga potrebbe non essere quella con valore dato maggiore
          * valuto la massima parola rapportando la sua lunghezza con il suo valore
         **/
        mval = dataSet[j][indexCat].length * Math.abs(dataSet[j][y_index]);
        ret.index = j;
      }
    }
  }
  return ret;
}

function getMeasureMinMax(valueFields, dataSet, propertyName) {
  // suppongo siano gli stessi per ogni categoria - se fossero diversi, avrei piu' assi
	var ret = [],
  indexVal;
	valueFields.forEach( function (values) {
		indexVal = propertyName.indexOf(values);
    if (indexVal >= 0 && indexVal < dataSet[0].length)
      ret.push(dataSet[0][indexVal]);
	});
	return ret;
}

function howManyDigits(num) {
  if (typeof num != "number")
    return num.length;
	var i=-1;
	var tmp=10;
	while(tmp>=1){
		i++;
		tmp=Math.abs(num)/Math.pow(10,i);
	}
	return i;
}

function isNumberFloat(n) {
  return n===Number(n) && n%1!==0;
}

function estimateMaximumTickLabel(type, minR, maxR, chartId, font, precision) {
	precision = Empty(precision) ? 0 : precision;
  var result = 8.0,
  min = minR.toFixed(precision),
  max = maxR.toFixed(precision);

	switch (type) {
		case "width":
			result += Math.max(getOffsetWidth(min, font, chartId), getOffsetWidth(max, font, chartId));
			break;
		case "height":
			result += getOffsetHeight(min, font, chartId);
			break;
	}
  result += 1;  // aggiungo +1 offset per non avere le etichette dell'asse appiccicate tra loro
	return result;
}

Array.prototype.binarySearch=function(searchElement) {
	var minIndex = 0;
	var maxIndex = this.length - 1;
	var currentIndex;
	var currentElement;

	while (minIndex <= maxIndex) {
		currentIndex = (minIndex + maxIndex) / 2 | 0;
		currentElement = this[currentIndex];

		if(currentElement < searchElement) {
			minIndex = currentIndex + 1;
		}
		else if(currentElement > searchElement) {
			maxIndex = currentIndex - 1;
		}
		else {
			return currentIndex;
		}
	}

	return -1;
}

function getLargerTickUnit(tickUts,unit){	// ritorna l'indice del valore maggiore rispetto all'unita'  passata
	var index = tickUts.binarySearch(unit);
	if(index >= 0) {
		index = index + 1;
	}
	else {
		index = -index;
	}

	return Math.min(index,tickUts.length-1);
}

function getCeilingTickUnit(tickUts, unit) {	// ritorna l'indice del valore maggiore o uguale dell'unita' passata per parametro
	for(var i=0; i<tickUts.length; i++){
		if(tickUts[i]>=unit)
			return i;
	}
	return tickUts.length-1;
}

function getStandardTickUnits(maxLen, isFloat, isPerc) {
	if (isFloat)
		return getFloatStandardTickUnits(maxLen,isPerc);
	else
		return getIntStandardTickUnits(maxLen,isPerc);
}

function getFloatStandardTickUnits(maxLen, isPerc) {	//unità di misura tick di deafult
	var ret=[], pow=0, i;
	for(i=-1; i<maxLen; i++){
		pow=Math.pow(10,i);
		ret.push(1*pow);
    if(i>=0)
      ret[ret.length-1]+=0.5;
		ret.push(2*pow);
		if(i>=0)
      ret[ret.length-1]+=0.5;
		ret.push(5*pow);
	}
	ret.push(1*Math.pow(10,maxLen));
	if(isPerc){
		for(i=0; i<ret.length; i++)
			ret[i]=ret[i]/100;
	}
	return ret;
}

function getIntStandardTickUnits(maxLen, isPerc) {	//unita' di misura tick di deafult
	var ret=[], pow=0, i;
	for(i=0; i<maxLen; i++){
		pow=Math.pow(10,i);
		ret.push(1*pow);
		ret.push(2*pow);
		ret.push(5*pow);
	}
	ret.push(1*Math.pow(10,maxLen));
	if(isPerc){
		for(i=0; i<ret.length; i++)
			ret[i]=ret[i]/100;
	}
	return ret;
}

function setTicks(min, max, tUnit, precision, bypassPrecision) {
  var tickCount = [],
  tmp = min;
  var tmp2;
  while (tmp <= max) {
    if (!bypassPrecision && (precision || precision == 0))
      tmp2 = parseFloat(tmp.toFixed(precision));
    else
      tmp2 = tmp;
    if (Empty(tmp2))
      tmp2 = Math.abs(tmp2);
    if (tickCount.indexOf(tmp2) < 0)
      tickCount.push(tmp2);
    tmp = parseFloat(tmp) + parseFloat(tUnit);
  }
  return tickCount;
}

function makeStyleHTMLString(stObj, orgStyle) {
	var ret = "",
  rret = "";
	for (var key in stObj) {
    ret = "";
    var prop = key,
    value = stObj[key];
		if (key.indexOf("ms") == 0 || key.indexOf("moz") == 0 || key.indexOf("webkit") == 0)
      prop = ("-" + key);
		if (key.indexOf("9") >= 0)
      prop = prop.replace(/9/g, "-");
		if (stObj[key] == 'transparent' || (Empty(stObj[key]) && (key == 'fill' || key == 'stroke'))) {
      prop += "-opacity";
      value = 0;
    }
    else if ((stObj[key] + "").indexOf("rgba") >= 0) {
      var tmpcol = "";
      value = Strtran(value, "rgba(", "");
      value = Strtran(value, ")", "");
      value = Strtran(value, " ", "");
      value = value.split(",");
      tmpcol = (prop + "-opacity:" + value[value.length - 1] + ";");
      ret += tmpcol;
      value.pop();
      value = "rgb(" + value.toString() + ")";
    }

    ret += (prop + ":" + value + ";");

    if (orgStyle) {
      orgStyle = Strtran(orgStyle, "; ", ";");
      orgStyle = Strtran(orgStyle, ": ", ":");
      ret = Strtran(ret, "; ", ";");
      ret = Strtran(ret, ": ", ":");
      if (orgStyle.indexOf(ret) >= 0)
        orgStyle = Strtran(orgStyle, ret, "");
    }

    rret += ret;
	}
	if (!orgStyle)
		return rret;
	else
		return orgStyle + rret;
}

function setColorSeriesArray(colors, list, reuseColor, onlyOrg) {
	var ret = [], i;
  if (colors && (!Empty(colors) || colors.length > 0))
    ret = ret.concat(colors);
  if (reuseColor && ret.length > 0) {
    var diff = Math.abs(ret.length - list.length);
    var coln = ret.length;
    var k = Math.ceil(diff / coln);
    for (i = 0; i < k; i++) {
      for (var j = 0; j < coln; j++)
        ret.push(ret[j]);
    }
  }
  else if (!onlyOrg) {
    ret = ret.concat(getAllDefaultColors());
		var listColor = [];
    var d3Color = d3.scaleOrdinal(d3.schemeCategory20);
    for (i = 0; i < 20; i++) {
      listColor[i] = {color:d3Color(i), gradient:""};
		}
		d3Color = d3.scaleOrdinal(d3.schemeCategory20b);
		for (i = 0; i < 20; i++) {
      listColor[i + 20] = {color:d3Color(i), gradient:""};
		}
		d3Color = d3.scaleOrdinal(d3.schemeCategory20c);
		for (i = 0; i < 20; i++) {
      listColor[i + 40] = {color:d3Color(i), gradient:""};
		}
    ret = ret.concat(listColor);
    var dupes = getDupColors(ret).sort(function(a, b){ return b-a; });
    for(i = 0; i < dupes.length; i++)
      ret.splice(dupes[i], 1);
    if (list && ret.length < list.length) {
      var coldiff = list.length - ret.length;
      for (i = 0; i < coldiff; i++)
        ret.push( {color:getRandomColor(), gradient:""} );
    }
  }
	return ret;
}

function getAllDefaultColors(onlyColor) {
  var ret = [],
  oColors = getWizardSeriesColor(),
  key;
  for (key in oColors) {
    ret = ret.concat(oColors[key].graphSettings.colorSeries.map(function(c_obj){
      if (onlyColor)
        return c_obj.color;
      return c_obj;
    }));
  }
  oColors = getZSeriesColor();
  for (key in oColors) {
    ret = ret.concat(oColors[key].graphSettings.colorSeries.map(function(c_obj){
      if (onlyColor)
        return c_obj.color;
      return c_obj;
    }));
  }
  return ret;
}

function getWizardSeriesColor() {
  var wizardSeriesColor = {
    simple: {
      graphSettings:{
        colorSeries:[
          {color:'#1BA1E2',gradient:''},
          {color:'#E51400',gradient:''},
          {color:'#FA6800',gradient:''},
          {color:'#F0A30A',gradient:''},
          {color:'#A4C400',gradient:''},
          {color:'#60A917',gradient:''},
          {color:'#008A00',gradient:''},
          {color:'#647687',gradient:''}
        ]
      }
    },
    deep: {
      graphSettings:{
        colorSeries:[
          {color:'#2196F3',gradient:''},
          {color:'#A20021',gradient:''},
          {color:'#FB5607',gradient:''},
          {color:'#FBBE0b',gradient:''},
          {color:'#99C24D',gradient:''},
          {color:'#53A548',gradient:''},
          {color:'#28502E',gradient:''},
          {color:'#706F6F',gradient:''}
        ]
      }
    },
    flat: {
      graphSettings:{
        colorSeries:[
          {color:'#2980B9',gradient:''},
          {color:'#E74C3C',gradient:''},
          {color:'#E67E22',gradient:''},
          {color:'#F1C40F',gradient:''},
          {color:'#2ECC71',gradient:''},
          {color:'#1ABC9C',gradient:''},
          {color:'#7F8C8D',gradient:''},
          {color:'#2C3E50',gradient:''}
        ]
      }
    }
    /*google: {
      graphSettings:{
        colorSeries:[
          {color:'#3284FF',gradient:''},
          {color:'#FF3424',gradient:''},
          {color:'#FF8200',gradient:''},
          {color:'#FFBB00',gradient:''},
          {color:'#26B14C',gradient:''},
          {color:'#656565',gradient:''},
          {color:'#E6E6E6',gradient:''},
          {color:'#1A1A1A',gradient:''}
        ]
      }
    },
    evidence: {
      graphSettings:{
        colorSeries:[
          {color:'#09DDBC',gradient:''},
          {color:'#6BA5C1',gradient:''},
          {color:'#1C31E8',gradient:''},
          {color:'#360F35',gradient:''},
          {color:'#A20025',gradient:''},
          {color:'#FF4900',gradient:''},
          {color:'#FE8A62',gradient:''},
          {color:'#FFDE00',gradient:''}
        ]
      }
    },
    precision: {
      graphSettings:{
        colorSeries:[
          {color:'#00ABA9',gradient:''},
          {color:'#004387',gradient:''},
          {color:'#E3C300',gradient:''},
          {color:'#46CF00',gradient:''},
          {color:'#7DA7D9',gradient:''},
          {color:'#6DCFF6',gradient:''},
          {color:'#D4547B',gradient:''},
          {color:'#34495E',gradient:''}
        ]
      }
    },
    original: {
      graphSettings:{
        colorSeries:[
          {color:'#0050EF',gradient:''},
          {color:'#F2477F',gradient:''},
          {color:'#F472D0',gradient:''},
          {color:'#BD8CBF',gradient:''},
          {color:'#AA00FF',gradient:''},
          {color:'#D80073',gradient:''},
          {color:'#6A00FF',gradient:''},
          {color:'#76608A',gradient:''}
        ]
      }
    }*/
  };
  return wizardSeriesColor;
}

function getWizardPlotColors() {
  var wizardPlotColors = {
    simple: { text:"#0D0F12", background:"transparent" },
    snow: { text:"#95A5A6", background:"#FFFFFF" },
    deep: { text:"#F5F5F5", background:"#2E393E" }
  };
  return wizardPlotColors;
}

function getZSeriesColor() {
  var zSeriesColor = {
    blue: { graphSettings:{
              colorSeries:[
                {color:'#003D81',gradient:''},
                {color:'#005FCC',gradient:''},
                {color:'#001E5A',gradient:''},
                {color:'#1F87FF',gradient:''},
                {color:'#70B3FF',gradient:''},
                {color:'#C2DEFF',gradient:''},
                {color:'#9EB5CF',gradient:''},
                {color:'#5981AD',gradient:''}
              ]
            }
          },
    red: { graphSettings:{
              colorSeries:[
                {color:'#72000F',gradient:''},
                {color:'#F40020',gradient:''},
                {color:'#F48449',gradient:''},
                {color:'#720600',gradient:''},
                {color:'#F25300',gradient:''},
                {color:'#F20D00',gradient:''},
                {color:'#722700',gradient:''},
                {color:'#F46C64',gradient:''}
              ]
            }
          },
    yellow: { graphSettings:{
              colorSeries:[
                {color:'#D98B0B',gradient:''},
                {color:'#E3E10B',gradient:''},
                {color:'#4C4A00',gradient:''},
                {color:'#B58C00',gradient:''},
                {color:'#FFF800',gradient:''},
                {color:'#D9A50A',gradient:''},
                {color:'#4C3B00',gradient:''},
                {color:'#CCB64A',gradient:''}
              ]
            }
          },
    green: { graphSettings:{
              colorSeries:[
                {color:'#004C1D',gradient:''},
                {color:'#43B200',gradient:''},
                {color:'#364C40',gradient:''},
                {color:'#31952D',gradient:''},
                {color:'#A6CC52',gradient:''},
                {color:'#51D900',gradient:''},
                {color:'#008C36',gradient:''},
                {color:'#63D496',gradient:''}
              ]
            }
          },
    grey: { graphSettings:{
        colorSeries:[
          {color:'#D8D1D6',gradient:''},
          {color:'#7D7D7D',gradient:''},
          {color:'#2A303C',gradient:''},
          {color:'#BBBBBB',gradient:''},
          {color:'#726068',gradient:''},
          {color:'#CACECF',gradient:''},
          {color:'#D8B5C4',gradient:''},
          {color:'#595959',gradient:''}
        ]
      }
    }
  };
  return zSeriesColor;
}

Array.prototype.unique = function () {
  var a = this.concat();
  for(var i=0; i<a.length; ++i) {
      for(var j=i+1; j<a.length; ++j) {
          if(a[i] === a[j])
              a.splice(j--, 1);
      }
  }
  return a;
}

function getDupColors(colors) {
  var idxs = [];
  for(var i=0; i<colors.length; i++) {
    for(var j=i+1; j<colors.length; j++) {
      if(colors[i].color.toLowerCase() === colors[j].color.toLowerCase()){
        if(colors[i].gradient && colors[j].gradient){
          if(colors[i].gradient.toLowerCase() === colors[j].gradient.toLowerCase())
            idxs.push(j);
        }
        else
          idxs.push(j);
      }
    }
  }
  return idxs.unique();
}

function getDomNodeWidth(node) {
  var w = 0;
  if (node.width && node.width.baseVal && node.width.baseVal[0])
    w = node.width.baseVal[0].value;
  else if (node.offsetWidth)
    w = node.offsetWidth;
  else if (node.getAttribute("width"))
    w = node.getAttribute("width");
  else if (node.getBBox)
    w = node.getBBox().width;
  return parseFloat(w);
}

function getDomNodeHeight(node) {
  var h = 0;
  if (node.height && node.height.baseVal && node.height.baseVal[0])
    h = node.height.baseVal[0].value;
  else if (node.offsetHeight)
    h = node.offsetHeight;
  else if (node.getAttribute("height"))
    h = node.getAttribute("height");
  else if (node.getBBox)
    h = node.getBBox().height;
  return parseFloat(h);
}

function getDomNodeTop(node) {
  var y = 0;
  if (node.y && node.y.baseVal && node.y.baseVal[0])
    y = node.y.baseVal[0].value;
  else if (node.offsetTop)
    y = node.offsetTop;
  else if (node.getAttribute("y"))
    y = node.getAttribute("y");
  else if (node.getBBox)
    y = node.getBBox().y;
  return parseFloat(y);
}

function getDomNodeLeft(node) {
  var x = 0;
  if (node.x && node.x.baseVal && node.x.baseVal[0])
    x = node.x.baseVal[0].value;
  else if (node.offsetLeft)
    x = node.offsetLeft;
  else if (node.getAttribute("x"))
    x = node.getAttribute("x");
  else if (node.getBBox)
    x = node.getBBox().x;
  return parseFloat(x);
}

function getDomNodeSizes(node) {
  return  { x : getDomNodeLeft(node),
            y : getDomNodeTop(node),
            width : getDomNodeWidth(node),
            height : getDomNodeHeight(node)
          };
}

function recursivediv(min, max, divmax, divmin, olddivmax) {
	if((max/divmax)>=(min/divmin)) return divmax;
	olddivmax = divmax;
	var t = divmax*divmin;
	divmin++;
	divmax=Math.ceil(t/divmin);
	if(olddivmax<=divmax) return olddivmax;
	return recursivediv(min, max, divmax, divmin, olddivmax);
}

function getStackDataset(valueFields, propertyName, dataSet, accumulate) {
  // accumulate indica se scindere le parti negative da positive (false) es. barre e non area
  var ret = [],
  tmp = 0,
  totP = 0,
  totN = 0,
  prec = 0;

  dataSet.forEach( function (record) {
    tmp = 0;
    totP = 0;
    totN = 0;
    ret.push(record.slice());
    var value;
    valueFields.forEach( function (values/*, index*/) {
      var indexVal = propertyName.indexOf(values);
      value = parseFloat(record[indexVal]);
      if (isNaN(value))
        value = 0;
      prec = Math.max(prec, decimalPlaces(value));
      if (!accumulate) {
        if (value >= 0) {
          totP = totP + value;
          ret[ret.length-1][indexVal] = totP;
        }
        else {
          totN = totN + value;
          ret[ret.length-1][indexVal] = totN;
        }
      }
      else {
        tmp = tmp + value;
        ret[ret.length-1][indexVal] = tmp;
      }
    });
  });

  ret.forEach( function (record) {
    valueFields.forEach( function (values/*, index*/) {
      var indexVal = propertyName.indexOf(values);
      record[indexVal] = parseFloat(record[indexVal]);
      record[indexVal] = parseFloat(record[indexVal].toFixed(prec));
    });
  });

  return ret;
}

function accumulateValuesOnColumn(dataSet, index) {
  var ret = [],
  tmp = 0;
  dataSet.forEach( function (record) {
    tmp = tmp + parseFloat(record[index]);
    ret.push(record.slice());
    ret[ret.length - 1][index] = tmp;
  });

  return ret;
}

function getMaxValueStack(indexCat, valueFields, dataSet, propertyName, abs) {
	var ret=[];
	var tmpCat=[];
  var va = valueFields;
  if( !Array.isArray(va)) va = va.split(',');
	va.forEach( function(values){
		var indexVal = propertyName.indexOf(values);
		dataSet.forEach( function(record){
			if (record[indexVal]>0 || abs) {
				if(tmpCat.indexOf(record[indexCat])>=0){
					ret[tmpCat.indexOf(record[indexCat])] += Math.abs(record[indexVal]);
				}
				else {
					tmpCat.push(record[indexCat]);
					ret.push(Math.abs(record[indexVal]));
				}
			}
		});
	});
	return ret;
}

function get3DColor(color) {
	return {  color: Empty(color.color) ? '' : d3.rgb(color.color).darker().toString(),
            gradient: Empty(color.gradient) ? '' : d3.rgb(color.gradient).darker().toString()
         }
}

function setOtherChartsArray(otherChart, mtype) {
  var ret = [];
  if (!Empty(otherChart)) {
    otherChart.split(",").forEach(function(type) {
      if (ret.indexOf(type) < 0 && (getChartMacroCategoryType(mtype) == getChartMacroCategoryType(type)))
        ret.push(type);
    });
  }
  return ret;
}

function getImgSrc(imgname, webRoot, applySpTheme) {
  var rootUrl;
	if (Empty(webRoot))
		rootUrl = ZtVWeb.SPWebRootURL;
	else
		rootUrl = webRoot;
	var ret;
	if (applySpTheme)
		ret = "url(" + rootUrl + "/" + ZtVWeb.theme + "/formPage/";
	else
		ret = "url(" + rootUrl + "/portalstudio/formPage/";
	ret += imgname;
	return ret + ")";
}

function getScrollTop(oElement) {
  var iReturnValue = 0;
  while (oElement != null && iReturnValue == 0 && oElement.tagName.toLowerCase() != "body") {
    iReturnValue += oElement.scrollTop;
    oElement = oElement.parentElement;
  }
  return iReturnValue;
}

function getY(oElement) {
  var iReturnValue = 0;
  while (oElement != null) {
    iReturnValue += oElement.offsetTop;
    oElement = oElement.offsetParent;
  }
  return iReturnValue;
}

function getX(oElement) {
  var iReturnValue = 0;
  while (oElement != null) {
    iReturnValue += oElement.offsetLeft;
    oElement = oElement.offsetParent;
  }
  return iReturnValue;
}

function applyChartMenuFnc(type, chartId, isdownload) {
	if (myZtCharts[chartId]) {
		if (CharToBool(isdownload))
			myZtCharts[chartId].downloadChart(type, chartId);
		else
      myZtCharts[chartId].changeChartType(type, chartId);

    if (window[myZtCharts[chartId].chartId + "onMenuClick"])
        window[myZtCharts[chartId].chartId + "onMenuClick"]({ action : CharToBool(isdownload) ? "downloadChart" : "changeChartType" });
    else if (myZtCharts[chartId].parentCtrl && myZtCharts[chartId].parentCtrl.dispatchEvent)
      myZtCharts[chartId].parentCtrl.dispatchEvent("onMenuClick", d3.event, { action : CharToBool(isdownload) ? "downloadChart" : "changeChartType" });

	}
}

function replaceSpecialCharsForFileName(mtext) {
  var ret = mtext + "";
  ret = Strtran(ret, "\\", "");
  ret = Strtran(ret, "/", "");
  ret = Strtran(ret, ":", "");
  ret = Strtran(ret, "*", "");
  ret = Strtran(ret, "?", "");
  ret = Strtran(ret, "\"", "");
  ret = Strtran(ret, "<", "");
  ret = Strtran(ret, ">", "");
  ret = Strtran(ret, "|", "");
  return ret;
}

function replaceSpecialCharsForID(mtext) {
  var ret = encodeURIComponent(mtext) + "";
  ret = Strtran(ret, " ", "_");
  ret = Strtran(ret, "\\", "_");
  ret = Strtran(ret, "/", "_");
  ret = Strtran(ret, ":", "_");
  ret = Strtran(ret, "*", "_");
  ret = Strtran(ret, "?", "_");
  ret = Strtran(ret, "\"", "_");
  ret = Strtran(ret, "<", "_");
  ret = Strtran(ret, ">", "_");
  ret = Strtran(ret, ".", "_");
  ret = Strtran(ret, "+", "_");
  ret = Strtran(ret, ")", "_");
  ret = Strtran(ret, "(", "_");
  ret = Strtran(ret, "%", "_");
  ret = Strtran(ret, "'", "_");
  ret = Strtran(ret, "\"", "_");
  return ret;
}

function replaceIconFontWithUnicode(imgType, printmode) {
  if (imgType == "svg" && !printmode)
    return;
  var ifonts = d3.selectAll(".ztchartfonticon")._groups[0];
  for (var i = 0; i < ifonts.length; i++)
    ifonts[i].textContent = "'" + ifonts[i].getAttribute("data-font") + "'";
}

function replaceIconFontWithCharCode(imgType, printmode) {
  if (imgType == "svg" && !printmode)
    return;
  var ifonts = d3.selectAll(".ztchartfonticon")._groups[0];
  for (var i = 0; i < ifonts.length; i++)
    ifonts[i].textContent = getIconFromCode(ifonts[i].getAttribute("data-font"));
}

function trasposeMatrix(array) {
	var trasposeArray = array[0].map(function(col, i) {
		return array.map(function(row) {
			return row[i];
		})
	});
	return trasposeArray;
}

function getDefaultRangeBands() {
  var rb =  [  
              {minValue: 0, maxValue: 33, color: "#E51400", label: "0-33%", percent: true, imageUrl: "images/chart_red.svg", iconCode: "eca2"},
              {minValue: 33, maxValue: 66, color: "#E3C800", label: "33-66%", percent: true, imageUrl: "images/chart_yellow.svg", iconCode: "edb2"},
              {minValue: 66, maxValue: 100, color: "#60A917", label: "66-100%", percent: true, imageUrl: "images/chart_green.svg", iconCode: "eee5"}
            ];
  return rb;
}

function getRangeOrd(range){  // ritorna range bands ordinate
  var ret = [];
  var mmax = [];
  var found = false;
  var i;
  for(i=0; i<range.length; i++){
    mmax.push(range[i].maxValue);
  }
  mmax.sort(function(a,b){ return a-b;});
  for(var k=0; k<mmax.length; k++){
    found = false;
    for(i=0; i<range.length && !found; i++){
      if(mmax[k]==range[i].maxValue){
        ret.push(range[i]);
        found = true;
      }
    }
  }
  return ret;
}

function getRangeContOrDisc(range) { // ritorna un booleano: se range bands sono discontinue o no
  var ret = getRangeCalc(range);
  return (ret.length > range.length);
}

function getRangeCalc(range) { // calcolo delle range bands discontinue solo con min e max
  var minunit = 0, i;
  for (i = 0; i < range.length; i++) {
    minunit = Math.max(minunit, decimalPlaces(range[i].minValue));
    minunit = Math.max(minunit, decimalPlaces(range[i].maxValue));
  }
  var unit = (minunit>0)?(1/Math.pow(10,minunit)):(1/Math.pow(10,minunit));
  var mrange = getRangeOrd(range);
  var ret = [];
  ret.push(mrange[0]);
  if(mrange.length>1){
    for(i=1; i<mrange.length; i++){
      if(mrange[i-1].maxValue==(mrange[i].minValue-unit) || mrange[i-1].maxValue==mrange[i].minValue){ // continuo
      }
      else{ // non e' piu' continuo
        ret.push({  minValue: mrange[i-1].maxValue+unit,
                    maxValue: mrange[i].minValue-unit,
                    isDisc: true
                });
      }
      ret.push(mrange[i]);
    }
  }
  return ret;
}

function getIntervalRange(range){ // ritorno range bands complete discontinue o no
  if (Empty(range) || range.length == 0)
    return [];
  var irange = getRangeCalc(range);
  var retrange = [];
  var mcolors = [];
  mcolors.push(irange[0].color);
  for(var i=0; i<irange.length; i++){
    if(irange[i].isDisc){
      retrange.push({ minValue: irange[i].minValue,
                      maxValue: irange[i].maxValue,
                      percent: true,
                      color: "#FFFFFF",
                      label: "",
                      discontinue: true
                    });
    }
    else
      retrange.push(irange[i]);
  }
  return retrange;
}

function getRangeBandsWithValues(range, minv, maxv) {
  var rret = [];
  var mmin,mmax;
  var tdiff = Math.abs(minv - maxv);
  var mymin = minv;
  if(tdiff==0){
    tdiff = maxv;
    mymin = 0;
  }

  for(var i=0; i<range.length; i++){
    if (range[i].percent) {
      mmin = tdiff*(range[i].minValue/100)+mymin;
      mmax = tdiff*(range[i].maxValue/100)+mymin;
    }
    else {
      mmin = range[i].minValue;
      mmax = range[i].maxValue;
    }

    rret.push(
      { minValue: mmin,
        maxValue: mmax,
        percent: false,
        color: range[i].color,
        label: range[i].label,
        imageUrl: range[i].imageUrl,
        iconCode: range[i].iconCode
      }
    );
  }
  return rret;
}

function getListFromObjectArray(mobjarray, prop) {
  var ret = [],
  props = prop.split(".");
  for(var i=0; i<mobjarray.length; i++) {
    if (props.length > 1)
      ret.push(props.reduce(function index(obj,i) { return obj[i]}, mobjarray[i]));
    else
      ret.push(mobjarray[i][prop]);
  }
  return ret;
}

function getColorsArrayLighter(colorstring, mlength) {
  var mton = 20,
  rgbcolor = colorstring;
  if (colorstring.indexOf(",") < 0)
		rgbcolor = d3.rgb(colorstring);
  var rl = Math.round((255 - rgbcolor.r) / mton),
  gl = Math.round((255 - rgbcolor.g) / mton),
  bl = Math.round((255 - rgbcolor.b) / mton),
  ret = [];

  ret.push({ color: colorstring, gradient: ""});
  for (var i = 0; i < mlength - 1; i++) {
    rgbcolor = d3.rgb(rgbcolor.r + rl, rgbcolor.g + gl, rgbcolor.b + bl);
    ret.push({ color: rgbcolor.toString(), gradient: "" });
  }
  return ret;
}

function getColorsArrayDarker(colorstring,mlength){
  var mton = 20;
  var rgbcolor = colorstring;
  if(colorstring.indexOf(",")<0)
		rgbcolor = d3.rgb(colorstring);
  var rl = Math.round((0-rgbcolor.r)/mton);
  var gl = Math.round((0-rgbcolor.g)/mton);
  var bl = Math.round((0-rgbcolor.b)/mton);
  var ret = [];
  ret.push({color:colorstring,gradient:""});
  for(var i=0; i<mlength-1; i++){
    rgbcolor = d3.rgb(rgbcolor.r+rl,rgbcolor.g+gl,rgbcolor.b+bl);
    ret.push({color:rgbcolor.toString(),gradient:""});
  }
  return ret;
}

function getRangeColor(type, bands, color, rbMin, rbMax, value) {
  if (type == "mono")
    return getMonochromaticRangeColor(color, rbMin, rbMax, value);
  else if (type == "multi") {
    if ((rbMax - rbMin) == 0)
      return color;
    var col = getMultichromaticRangeColor(bands, rbMin, rbMax, value);
    return d3.rgb(col[0], col[1], col[2]).toString();
  }
  else
    return color;
}

function getMonochromaticRangeColor(color, minv, maxv, val) {
  if ((maxv - minv) == 0)
    return color;
  var monoc = getColorsArrayLighter(color, 8).reverse();
  var qcol = d3.scaleQuantize()
              .domain([minv, maxv])
              .range(monoc);
  return qcol(val).color;
}

function getMultichromaticRangeColor(ranges, minv, maxv, val) {
  var multic = [];
  for (var i = 0; i < ranges.length; i++)
    multic.push({ stop: ((100 / ranges.length) * i) / 100,
                  color: ranges[i].color
                });

  var gr = new GradientReader(multic);
  return gr.getColor(((val - minv) * 100) / Math.abs(minv - maxv));
}

function getMultichromaticRangeColorPV(ranges, val) {
  var multic = [];
  if( ranges.length == 1 )
    return getMonochromaticRangeColor(ranges[0].color, 0, ranges[0].value, val);
  var minv = ranges[0].value;
  var maxv = ranges[ranges.length-1].value;
  var prop = 0;
  for (var i = 0; i < ranges.length; i++) {
    var z = 1;
    if( maxv - minv != 0) {
      if( i > 0 ) {
        z = ranges[i].value - ranges[i-1].value;
        z = z/(maxv - minv);
        prop += z;
      }
    }
    else {
      prop = 1;
    }
    multic.push({ stop: ((100 / (ranges.length-1)) * i * prop) / 100,
                  color: ranges[i].color 
                });
    }
  var gr = new GradientReader(multic);
  return gr.getColor(((val - minv) * 100) / Math.abs(minv - maxv));
}

function GradientReader(colorStops) {
  var canvas = document.createElement('canvas'),
      ctx = canvas.getContext('2d'),
      gr = ctx.createLinearGradient(0, 0, 101, 0),
      i = 0, cs;

  canvas.width = 101;
  canvas.height = 1;
  // eslint-disable-next-line no-cond-assign
  for (; cs = colorStops[i++];)
      gr.addColorStop(cs.stop, cs.color);

  ctx.fillStyle = gr;
  ctx.fillRect(0, 0, 101, 1);

  this.getColor = function(pst) {
    return ctx.getImageData(pst|0, 0, 1, 1).data;
  };
}

function getPercentDataset(valueFields, propertyName, dataSet, totalsobj, isSeries) {
  // totalsobj deve contenere la chiave in base a record[indexVal] se serie, altrimenti posizione in dataset
  var ret = [],
  indexVal = -1;

  dataSet.forEach ( function (record, index) {
    ret.push(record.slice());
    valueFields.forEach( function (values) {
      indexVal = propertyName.indexOf(values);
      if (!isSeries)
        ret[ret.length-1][indexVal] = ret[ret.length-1][indexVal] / totalsobj.categoriesT[index];
      else
        ret[ret.length-1][indexVal] = ret[ret.length-1][indexVal] / totalsobj[values];
      ret[ret.length-1][indexVal] = parseFloat(ret[ret.length-1][indexVal].toFixed(2));
    });
  });

  return ret;
}

function btwn(a, b1, b2) {
  if ((a >= b1) && (a <= b2)) { return true; }
  if ((a >= b2) && (a <= b1)) { return true; }
  return false;
}

function line_line_intersect(line1, line2) {
  var x1 = line1.x1, x2 = line1.x2, x3 = line2.x1, x4 = line2.x2;
  var y1 = line1.y1, y2 = line1.y2, y3 = line2.y1, y4 = line2.y2,
  pt_denom = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4),
  pt_x_num = (x1*y2 - y1*x2) * (x3 - x4) - (x1 - x2) * (x3*y4 - y3*x4),
  pt_y_num = (x1*y2 - y1*x2) * (y3 - y4) - (y1 - y2) * (x3*y4 - y3*x4);
  if (pt_denom == 0)
    return [];
  return { x : pt_x_num / pt_denom, y : pt_y_num / pt_denom };
}

function zeroFilledArray(element/*, index, array*/) {
  return element == 0;
}

function getTreemapLayout(tileStyle) {
  var d3treemap = d3.treemap();
  switch (tileStyle) {
    case 'binary':
      d3treemap.tile(d3.treemapBinary);
      break;
    case 'squarify':
      d3treemap.tile(d3.treemapSquarify);
      break;
    case 'squarifyV1':
      d3treemap.tile(d3.treemapSquarify.ratio(1));
      break;
    case 'squarifyV2':
      d3treemap.tile(d3.treemapSquarify.ratio(2));
      break;
    case 'resquarify':
      d3treemap.tile(d3.treemapResquarify);
      break;
    case 'resquarifyV1':
      d3treemap.tile(d3.treemapResquarify.ratio(1));
      break;
    case 'resquarifyV2':
      d3treemap.tile(d3.treemapResquarify.ratio(2));
      break;
    case 'dice':
      d3treemap.tile(d3.treemapDice);
      break;
    case 'slice':
      d3treemap.tile(d3.treemapSlice);
      break;
    case 'slicedice':
      d3treemap.tile(d3.treemapSliceDice);
      break;
  }
  return d3treemap;
}

function encodeSpecialCharsXML(myString){
  var ret = myString;
  ret = Strtran(ret, " ", "");
  ret = Strtran(ret, "&", "");
  ret = Strtran(ret, "<", "");
  ret = Strtran(ret, ">", "");
  ret = Strtran(ret, "\"", "");
  ret = Strtran(ret, "'", "");
  ret = Strtran(ret, "\\r", "");
  ret = Strtran(ret, "(", "");
  ret = Strtran(ret, ")", "");
  ret = Strtran(ret, "=", "");
  ret = Strtran(ret, ",", "");
  ret = Strtran(ret, ":", "");
  ret = Strtran(ret, "*", "");
  ret = Strtran(ret, "%", "");
  ret = Strtran(ret, "_", "");
  ret = Strtran(ret, "+", "");
  ret = Strtran(ret, "/", "");
  ret = Strtran(ret, "\\", "");
  return ret.toUpperCase();
}

function convertCsv(tmp,separator){
	var newLineWin="\n";
	var newLineLin="\r";
	if(tmp.indexOf(newLineWin)>=0)
		tmp=tmp.replace(newLineWin,"");
	if(tmp.indexOf(newLineLin)>=0)
		tmp=tmp.replace(newLineLin,"");
	if(tmp.indexOf(separator)>=0)
		tmp=JSON.stringify(tmp);
	return tmp;
}

function convertXml(tag, value){
  var txt = "";
  var ttag = encodeSpecialCharsXML(tag);
  txt+="<"+ttag+">";
  txt+=value;
  txt+="</"+ttag+">";
  return txt;
}

function getFilterType(type){
  type = type.toLowerCase();
	if(type.indexOf("area")>=0)
		 return "AREA";
	else if(type.indexOf("bar")>=0 || type=="pareto")
		return "VBAR";
	else if(type=='scatter' || type=='bubble')
		return "SCATTER";
	else
		return "LINES";
}

function recursiveNodePattern(node, fcolor) {
  for (var j = 0; node.attributes && j < node.attributes.length; j++) {
    if(node.attributes[j].value.indexOf('varPatternColor') > -1)
      node.attributes[j].value = Strtran(node.attributes[j].value, "varPatternColor", fcolor);
  }
  if (!node.children || node.children.length == 0)
    return;
  for (var i = 0; node.children && i < node.children.length; i++)
    recursiveNodePattern(node.children[i], fcolor);
}

Array.prototype.hasElement=function(searchElement){
	for(var i=0; i<this.length; i++){
		if(this[i].valueOf()==searchElement.valueOf())
			return i;
	}
	return -1;
}

Array.prototype.hasObject=function(searchElement){
  //var objectConstructor = {}.constructor;
	for(var i=0; i<this.length; i++){
    if(isEquivalent(this[i],searchElement))
      return i;
	}
	return -1;
}

function isEquivalent(a, b) {
  // Create arrays of property names
  var aProps = Object.getOwnPropertyNames(a);
  var bProps = Object.getOwnPropertyNames(b);

  // If number of properties is different,
  // objects are not equivalent
  if (aProps.length != bProps.length) {
    return false;
  }

  for (var i = 0; i < aProps.length; i++) {
    var propName = aProps[i];
    if (typeof a[propName] !== typeof b[propName])
      return false;
    var check_obj = false;
    if ((typeof a[propName]).toLowerCase() === "object") {
      var eq_obj = isEquivalent(a[propName], b[propName]);
      check_obj = true;
      if (!eq_obj)
        return false;
      if (i == aProps.length - 1)
        return eq_obj;
    }
    // If values of same property are not equal,
    // objects are not equivalent
    if (!check_obj && (a[propName] !== b[propName])) {
      return false;
    }
  }

  // If we made it this far, objects
  // are considered equivalent
  return true;
}

function getTimeTickFormat(localeLangFormat, format) {
  var rformat;
	switch (format) {
		case "":
			break;
		case "yyyy-mm-dd":
			rformat = localeLangFormat.timeFormat("%Y-%m-%d");
			break;
		case "dd-mm-yyyy":
		case "dd-MM-yyyy":
			rformat = localeLangFormat.timeFormat("%d-%m-%Y");
			break;
		case "dd-MMM-yyyy":
			rformat = localeLangFormat.timeFormat("%d-%b-%Y");
			break;
		case "MMM-yyyy":
			rformat =  localeLangFormat.timeFormat("%b-%Y");
			break;
		case "yyyy":
			rformat = localeLangFormat.timeFormat("%Y");
			break;
		case "yyyy-mm-dd hh:mm:ss":
			rformat = localeLangFormat.timeFormat("%Y-%m-%d %X");
			break;
		case "yyyy-mm-dd hh:mm":
			rformat = localeLangFormat.timeFormat("%Y-%m-%d %H:%M");
			break;
		case "hh:mm:ss":
			rformat = localeLangFormat.timeFormat("%X");
			break;
		case "hh:mm":
			rformat = localeLangFormat.timeFormat("%H:%M");
			break;
		default:
			rformat = localeLangFormat.timeFormat(format);
			break;
	}
  return rformat;
}

function calcTimeOffset(list) {
	var timeIntervals = {
		s: [1, 59],
		m: [60, 3599],
		h: [3600, 86399],
		d: [86400, 2591999],
		M: [2592000, 31103999],	// media di 30days
		y: [31104000, 1.7976931348623157E+10308]
	},
	timeIntervTicks = {
		s: [1, 15, 30, 45],
		m: [1, 15, 30, 45],
		h: [1, 6, 12, 18],
		d: [1, 7, 15, 21],
		M: [1, 3, 6, 9],
		y: [1, 5, 10, 15]
	},
  keys = ["s", "m", "h", "d", "M", "y"];

	if (list.length > 1) {
		var maxL = (list.length >= 200) ? 200 : list.length,
		dstart = new Date(list[0]),
		offset = 0,
    diff = timeIntervals.y[1],
    check = false,
    unit = "",
    step = 0,
    i;

		for (i = 1; i < maxL; i++) {
      if (dstart.getTimezoneOffset() == list[i].getTimezoneOffset()) {
        offset = (list[i].getTime() - dstart.getTime()) / 1000;
        if (diff != 0)
          diff = Math.min(diff, offset);
      }
      dstart = list[i];
		}

    for (i = 0; i < keys.length && !check; i++) {
			if (diff >= timeIntervals[keys[i]][0] && diff <= timeIntervals[keys[i]][1]){
				unit = keys[i];
				check = true;
			}
		}

    if (Empty(unit) || diff == 0) {
      // imposto il default
      return { unit : "d", step : 1 };
    }

    check = false;
    diff = diff / timeIntervals[unit][0];
    for (i = 0; i < timeIntervTicks[unit].length && !check; i++) {
			if (diff < timeIntervTicks[unit][i]) {
				step = timeIntervTicks[unit][i - 1];
				check = true;
			}
		}

    if (step == 0)
      step = timeIntervTicks[unit][timeIntervTicks[unit].length - 1];

		return { unit : unit, step : step };
	}
	else
		return { unit : "d", step : 1 };
}

function getTimingDivisor(unit) {
  var timeIntervals = {
		s: 30,
		m: 30,
		h: 12,
		d: 14,
		M: 6,	// media di 30days
		y: 1
  }

  var keys = Object.keys(timeIntervals),
  midx = keys.indexOf(unit);
  if (midx > 0)
    return { unit : keys[midx - 1], step : timeIntervals[keys[midx - 1]] }
  return { unit : unit, step : 1 };
}

function calcTimeOffsetBtw2Date(date1, date2) {
	var timeIntervals = {
		s: [1, 59],
		m: [60, 3599],
		h: [3600, 86399],
		d: [86400, 2591999],
		M: [2592000, 31103999],	// media di 30days
		y: [31104000, 1.7976931348623157E+10308]
  },
  keys = ["s", "m", "h", "d", "M", "y"],
  offset = (date2.getTime() - date1.getTime()) / 1000,
  f = false,
  unit = "d",
  step = 1;

  for (var i = 0; !f && i < keys.length; i++) {
    if (offset >= timeIntervals[keys[i]][0] && offset <= timeIntervals[keys[i]][1]) {
      f = true;
      unit = keys[i];
      step = Math.floor(offset / timeIntervals[keys[i]][0]);
    }
  }

  return { unit : unit, step : step };
}

function calcDistanceDifferentTimeUnit(tu1, tu2) {
	var timeIntervals = {
		s: [1, 59],
		m: [60, 3599],
		h: [3600, 86399],
		d: [86400, 2591999],
		M: [2592000, 31103999],	// media di 30days
		y: [31104000, 1.7976931348623157E+10308]
  },
  keys = ["s", "m", "h", "d", "M", "y"],
  dist = 0,
  tk1 = keys.indexOf(tu1.unit),
  tk2 = keys.indexOf(tu2.unit);

  if (tk1 > tk2)
    dist = (timeIntervals[tu1.unit][0] * tu1.step) / (timeIntervals[tu2.unit][0] * tu2.step);
  else
    dist = (timeIntervals[tu2.unit][0] * tu2.step) / (timeIntervals[tu1.unit][0] * tu1.step);
  return dist;
}

function setTimeTicks(start, end, unit, step) {
  var timeUnits = {
		s: 1000,
		m: 60 * 1000,
		h: 3600 * 1000,
		d: 86400 * 1000,
		M: 2592000 * 1000,
		y: 31104000 * 1000
	},
  ret = [];

  for (var i = start; i <= end; i = i + (timeUnits[unit] * step))
    ret.push(new Date(i));

  return ret;
}

function numRoundTo(num, mult) {
  var resto = num%mult;
  if (resto <= (mult/2)) {
      return num-resto;
  } else {
      return num+mult-resto;
  }
}

function getMagnitudeOrder(n) {
  if (n == undefined || n == null || Empty(n))
    n = 1;
  n = Math.abs(parseFloat(n));
  var order = Math.floor(Math.log(n) / Math.LN10 + 0.000000001);
  return order;
}

function fileExists(url) {
  var http = new XMLHttpRequest();
  http.open('HEAD', url, false);
  http.send();
  return http.status != 404;
}

function invertColor(hexTripletColor) {
	var color = hexTripletColor;
	if (Empty(color))
    return "";
	color = color.substring(1); // remove #
	color = parseInt(color, 16); // convert to integer
	color = 0xFFFFFF ^ color; // invert three bytes
	color = color.toString(16); // convert to hex
	color = ("000000" + color).slice(-6); // pad with leading zeros
	color = "#" + color; // prepend #
	return color;
}

function makeParameterStringFromLinkObj(url, type, linkObj, itemObj, chart) {
  var murl = url,
  mcp,
  seriesName = Empty(linkObj.seriesname) ? "series" : linkObj.seriesname,
  categoryName = Empty(linkObj.categoryname) ? "category" : linkObj.categoryname,
  categoryKeyName = Empty(linkObj.categoryKeyName) ? "categoryKey" : linkObj.categoryKeyName,
  valueName = Empty(linkObj.valuename) ? "value" : linkObj.valuename,
  valueZName = Empty(linkObj.valuezname) ? "valuez" : linkObj.valuezname,
  multidimKeyName = Empty(linkObj.multidimKeyName) ? "multidimKeyName" : linkObj.multidimKeyName,
  geocountryName = Empty(linkObj.geocountryName) ? "geocountryName" : linkObj.geocountryName,
  geosubdivisionName = Empty(linkObj.geosubdivisionName) ? "geosubdivisionName" : linkObj.geosubdivisionName;
  if (type == "link") {
    murl += (murl.indexOf("?") < 0 ? "?" : "&");
    murl += chart._GetParametersStringForLink(itemObj);
    murl += "&" + multidimKeyName + "=" + itemObj.multidimCurrentKey;
    if (!Empty(linkObj.genericParam))
      murl += "&" + linkObj.genericParam;
  }
  else {  // func
    if (itemObj.cname) {
      mcp = itemObj.cname.split("_");
      murl = Strtran(murl, geocountryName, "'" + mcp[0] + "'");
      murl = Strtran(murl, geosubdivisionName, "'" + mcp[1] + "'");
      murl = Strtran(murl, seriesName, "'" + itemObj.series + "'");
      murl = Strtran(murl, multidimKeyName, "'" + itemObj.multidimCurrentKey + "'");
    }
    else if (itemObj.x) {
      murl = Strtran(murl, categoryKeyName, "'" + itemObj.keyF + "'");
      murl = Strtran(murl, seriesName, "'" + itemObj.series + "'");
      murl = Strtran(murl, categoryName, "'" + itemObj.x + "'");
      murl = Strtran(murl, valueName, "'" + itemObj.y + "'");
      murl = Strtran(murl, valueZName, "'" + itemObj.z + "'");
      murl = Strtran(murl, multidimKeyName, "'" + itemObj.multidimCurrentKey + "'");
    }
    else {
      murl = Strtran(murl, categoryKeyName, "'" + itemObj.keyF + "'");
      murl = Strtran(murl, categoryName, "'" + itemObj.category + "'");
      murl = Strtran(murl, seriesName, "'" + itemObj.series + "'");
      murl = Strtran(murl, valueName, "'" + itemObj.value + "'");
      murl = Strtran(murl, multidimKeyName, "'" + itemObj.multidimCurrentKey + "'");
    }
  }

  return murl;
}

function makeParameterStringFromOverlapLinkObj(url, type, linkObj, itemObj, chart) {
  var murl = url,
  itms_i = chart._GetOverlapObject(itemObj),
  all_itms = chart._GetItems(),
  ser = "",
  cols = "";

  if (type == "link") {
    murl += (murl.indexOf("?") < 0 ? "?" : "&");
    for (var i = 0; i < itms_i.length; i++) {
      ser += ("::" + all_itms[itms_i[i]].category);
      cols += ("::" + all_itms[itms_i[i]].color.color)
    }
    murl += "&category=" + URLenc(ser.slice(2));
    murl += "&colors=" + URLenc(Strtran(cols.slice(2), "#", ""));
    murl += "&serie=" + URLenc(itemObj.quadrant);
    murl += "&x=" + URLenc(itemObj.x);
    murl += "&y=" + URLenc(itemObj.y);
    if ("sub_x" in itemObj)
      murl += "&sub_x=" + URLenc(itemObj.sub_x);
    if ("sub_y" in itemObj)
      murl += "&sub_y=" + URLenc(itemObj.sub_y);
    murl += "&num=" + URLenc(itms_i.length);

    if (!Empty(linkObj.genericParam))
      murl += "&" + linkObj.genericParam;
  }
  else {  // func
    // category serie x y num
  }

  return murl;
}

function canDrawInContainer(type) {
  var draw = false;
  switch (type) {
    case "LINES":
    case "VBAR":
    case "VBAR3D":
    case "VSTACKBAR":
    case "VSTACKBAR3D":
    case "LAYEREDBAR":
    case "TREEMAPBAR":
    case "AREA":
    case "STACKEDAREA":
      draw = true;
      break;
    default:
      draw = false;
      break;
  }
  return draw;
}

function getAlternativeChartType(type) {
  // tutela per disegno dei grafici con serie diversa
  var rtype = "";
  switch (type) {
    case "HBAR":
    case "PYRAMID":
    case "PIE":
    case "PIE3D":
    case "RING":
    case "RINGPERC":
    case "PARETO":
    case "WATERF":
    case "WORDCLOUD":
    case "GEOMAP":
    case "ARCDIAL":
    case "COUNTER":
    case "DISPLAY":
    case "PADDLE":
    case "LIGHTS":
    case "IMAGES":
      rtype = "VBAR";
      break;
    case "HBAR3D":
      rtype = "VBAR3D";
      break;
    case "HSTACKBAR":
      rtype = "VSTACKBAR";
      break;
    case "HSTACKBAR3D":
      rtype = "VSTACKBAR3D";
      break;
    case "THERMO":
    case "LAYEREDBARH":
      rtype = "LAYEREDBAR";
      break;
    case "TREEMAP":
    case "TREEMAPBARH":
      rtype = "TREEMAPBAR";
      break;
    case "RADARAREA":
      rtype = "AREA";
      break;
    case "RADARLINE":
    case "SCATTER":
    case "BUBBLE":
    default:
      rtype = "LINES";  // default quando apro editor
      break;
  }
  return rtype;
}

function wrapspace(elem, configObj) {
  elem = d3.select(elem);

  var text = configObj.text,
  textSplit = configObj.textSplit,
  width = configObj.width,
  nlines = configObj.nlines,
  font = configObj.font,
  chartId = configObj.chartId,
  keyapplied = configObj.keyapplied,
  keyText = configObj.keyText,
  axisPos = configObj.axisPos,
  sep = configObj.separator,
  words = (textSplit || text.split(sep)).reverse(),
  word,
  lineHeight,
  line = [],
  x = elem.attr("x"),
  y = axisPos == "left" ? parseFloat(elem.attr("y")) : elem.attr("y"),
  dy = axisPos == "left" ? elem.attr("dy") : parseFloat(elem.attr("dy")),
  tspan,
  plusLine = false,
  progrLine = 1,
  underwrap = false,
  ljoin = "";

  elem.text(null);
  // eslint-disable-next-line no-cond-assign
  while (word = words.pop()) {
    line.push(word);
    if (getOffsetWidth(line.join(configObj.cjoin), font, chartId) > width) {
      line.pop();
      line = [word];
      ljoin = line.join(configObj.cjoin);
      if (getOffsetWidth(ljoin, font, chartId) > width) {
        underwrap = true;
        nlines = Math.max(nlines, Math.round(getOffsetWidth(ljoin, font, chartId) / width));
      }
      lineHeight = axisPos == "left" ? getOffsetHeight(ljoin, font, chartId) : 1.1;
      tspan = elem.append("tspan")
                .attr("x", 0)//x)
                .attr("y", axisPos == "left" ? (y + (progrLine - 1) * lineHeight) : y)
                .attr("dy", axisPos == "left" ? dy : ((progrLine - 1) * lineHeight + dy + "em"))
                .text(word);
      progrLine++;
      plusLine = true;
    }
    else {
      if (Empty(tspan)) {
        tspan = elem.append("tspan").attr("x", x).attr("y", axisPos == "left" ? 0 : y).attr("dy", axisPos == "left" ? 0 : (dy + "em"));
        progrLine++;
      }
      tspan.text(line.join(configObj.cjoin));
    }
  }

  if (keyapplied)
    elem.append("desc").text("key_field:" + keyText);

  return { wrap : plusLine, underwrap : underwrap, lines : nlines };
}

function getD3TimeObject(timing) {
  var obj;
  switch (timing) {
    case "s" :
      obj = d3.timeSecond;
      break;
    case "m" :
      obj = d3.timeMinute;
      break;
    case "h" :
      obj = d3.timeHour;
      break;
    case "d" :
      obj = d3.timeDay;
      break;
    case "M" :
    case "month" :
      obj = d3.timeMonth;
      break;
    case "y" :
    case "year" :
      obj = d3.timeYear;
      break;
    default :
      obj = d3.timeDay;
      break;
  }
  return obj;
}

function getMaxWordLengthForWrap(list, precision, fnc) {
  var tmplist = [],
  tmpsplit = [],
  splitobj = {};
  for (var i = 0; i < list.length; i++) {
    if ((list[i]+"").indexOf(" ") < 0)
      tmplist.push(list[i]);
    else if (Object.prototype.toString.call(list[i]) !== "[object Date]") {
      var ssplit = list[i].split(/\s+/);
      splitobj["_" + i] = ssplit.slice();
      tmpsplit = tmpsplit.concat(ssplit);
    }
  }

  if (!Empty(tmplist))
    return { obj : null, word : getMaxWordLength(tmplist, precision, fnc) };
  return { obj : splitobj, word : getMaxWordLength(tmpsplit, precision, fnc) };
}

function getTimeFormatSeparator(format) {
  var ret = {};
  if (format.indexOf(" ") >= 0) {
    ret.separator = /\s+/;
    ret.cjoin = " ";
    return ret;
  }
  if (format.indexOf("-") >= 0){
    ret.separator = /\-+/;
    ret.cjoin = "-";
    return ret;
  }
  if (format.indexOf("/") >= 0){
    ret.separator = /\/+/;
    ret.cjoin = "/";
    return ret;
  }
  if (format.indexOf(":") >= 0) {
    ret.separator = /\:+/;
    ret.cjoin = ":";
    return ret;
  }
  ret.separator = /\s+/;
  ret.cjoin = " ";
  return ret;
}
/* da rivalutare - implementazione tipologia
function isNumeric(num){
  return !isNaN(+num)
}
*/
function getHieDataset(data, hFields, valueFields, labelSeries, propertyName, addfields, singleRoot, noGroup, kFields) {
  var mapData = { children: [], name: "" },
  startIndex = singleRoot ? 1 : 0,
  pname,
  fidx;

  if (startIndex != 0)
    mapData.name = data[0][propertyName.indexOf(hFields[0])];

  // costruisco la gerarchia con oggetti come chiavi
  /*for (var i = 0; i < data.length; i++) {
    fidx = propertyName.indexOf(hFields[1]);
    if (!levelsList[data[i][fidx]])
      levelsList[data[i][fidx]] = { };
    obj = levelsList[data[i][fidx]];
    for (var j = 2; j < hFields.length; j++) {
      fidx = propertyName.indexOf(hFields[j]);
      if (!obj[data[i][fidx]])
        obj[data[i][fidx]] = { };
      obj = obj[data[i][fidx]];
      if (j == hFields.length - 1 && yidx >= 0)
        obj.value = data[i][yidx];
    }
  }*/

  if (noGroup) {
    for (var i = 0; i < data.length; i++) {
      var f = false;
      for (var j = hFields.length - 1; !f && j >= startIndex; j--) {
        fidx = propertyName.indexOf(hFields[j]);
        pname = "";
        if (j >= 1)
          pname = data[i][propertyName.indexOf(hFields[j - 1])];
        if (Empty(data[i][fidx]))
          continue;
        mapData.children.push({ name : data[i][fidx],
                                size : data[i][propertyName.indexOf(valueFields)],
                                parentName : pname,
                                data_idx : i });
        if (!Empty(addfields)) {
          for (var ff = 0; ff < addfields.length; ff++) {
            mapData.children[mapData.children.length - 1][addfields[ff].prop] = data[i][addfields[ff].index];
          }
        }
        f = true;
      }
    }
  }
  else
    mapData = recursiveTree(mapData, hFields, startIndex, propertyName, valueFields, labelSeries, data, addfields, kFields);

  return mapData;
}

function getForceDataset(data, hFields, valueFields, propertyName, cFields, lFields, addfields) {
  var nodesNames = [],
  nodesObj = [],
  nodesLabels = [],
  links = [],
  obj,
  fidx,
  cfidx,
  lidx,
  val,
  lab,
  ff;

  for (var i = 0; i < data.length; i++) {
    fidx = propertyName.indexOf(hFields[0]);
    cfidx = -1;
    if (cFields && !Empty(cFields[0]))
      cfidx = propertyName.indexOf(cFields[0]);
    lidx = -1;
    if (lFields && !Empty(lFields[0]))
      lidx = propertyName.indexOf(lFields[0]);
    val = data[i][propertyName.indexOf(valueFields)];

    if (!Empty(data[i][fidx]) && nodesNames.indexOf(data[i][fidx]) < 0) {
      nodesNames.push(data[i][fidx]);
      lab = lidx < 0 ? "" : data[i][lidx];
      nodesLabels.push(lab);
      nodesObj.push( { name: data[i][fidx], class: cfidx < 0 ? "" : data[i][cfidx], desc: lab } );
      if (!Empty(addfields)) {
        for (ff = 0; ff < addfields.length; ff++) {
          nodesObj[nodesObj.length - 1][addfields[ff].prop] = data[i][addfields[ff].index];
        }
      }
    }
    obj = {};
    obj.source = nodesNames.indexOf(data[i][fidx]);

    for (var j = 1; j < hFields.length; j++) {
      fidx = propertyName.indexOf(hFields[j]);
      cfidx = -1;
      if (cFields && !Empty(cFields[j]))
        cfidx = propertyName.indexOf(cFields[j]);
      lidx = -1;
      if (lFields && !Empty(lFields[j]))
        lidx = propertyName.indexOf(lFields[j]);
      if (!Empty(data[i][fidx])) {  // percorso a catena - non singolo
        if (j > 1) {
          obj = {};
          obj.source = nodesNames.indexOf(data[i][propertyName.indexOf(hFields[j - 1])])
        }
        if (nodesNames.indexOf(data[i][fidx]) < 0) {
          nodesNames.push(data[i][fidx]);
          lab = lidx < 0 ? "" : data[i][lidx];
          nodesLabels.push(lab);
          nodesObj.push( { name: data[i][fidx], value: val, class: cfidx < 0 ? "" : data[i][cfidx], desc: lab } );
          if (!Empty(addfields)) {
            for (ff = 0; ff < addfields.length; ff++) {
              nodesObj[nodesObj.length - 1][addfields[ff].prop] = data[i][addfields[ff].index];
            }
          }
        }
        if (obj) {
          obj.target = nodesNames.indexOf(data[i][fidx]);
          links.push(obj);
        }
      }
    }
  }

  var dupes = getDupLinks(links).sort(function(a, b){ return b-a; });
  for(i = 0; i < dupes.length; i++)
    links.splice(dupes[i], 1);

  return {nodes: nodesObj, links: links, array: nodesNames, labels: nodesLabels };

  function getDupLinks(lnks) {
    var idxs = [];
    for(var i=0; i<lnks.length; i++) {
      for(var j=i+1; j<lnks.length; j++) {
        if(lnks[i].source === lnks[j].source){
          if(lnks[i].target === lnks[j].target)
            idxs.push(j);
        }
      }
    }
    return idxs.unique();
  }
}

function recursiveTree(mapData, hFields, idx, propertyName, valueFields, labelSeries, data, addfields, kFields) {
  var fidx = propertyName.indexOf(hFields[idx]),
  list = getList(fidx, data),
  datatmp,
  obj,
    value,
  serie,
  kidx,
  klist,
  keyf;
  if (!Empty(kFields)) {
    kidx = propertyName.indexOf(kFields[idx]);
    klist = getList(kidx, data);
  }
  else {
    kidx = fidx;
    klist = list;
  }
  
  for (var i = 0; i < klist.length; i++) {
    datatmp = data.filter( function (record) { if (record[kidx] == klist[i]) return record; } );
    value = datatmp[0][propertyName.indexOf(valueFields)];
    serie = datatmp[0][propertyName.indexOf(labelSeries)];
    keyf = Empty(kFields) ? "" : klist[i];
    obj = { name: list[i], serie: serie, keyF: keyf };
    if (!Empty(addfields)) {
      for (var ff = 0; ff < addfields.length; ff++) {
        obj[addfields[ff].prop] = datatmp[0][addfields[ff].index];
      }
    }
    if (idx < hFields.length - 1) {
      obj.children = []; 
      recursiveTree(obj, hFields, idx + 1, propertyName, valueFields, labelSeries, datatmp, addfields, kFields);
    }
    else if (!Empty(list[i]) || list[i] === 0) {
      // è un solo livello -> se ci sono più record devo aggregare i valori
      if (datatmp.length > 1) {
        value = d3.sum(datatmp.map(function(record){ return record[propertyName.indexOf(valueFields)] }))
      }
      obj.size = value;
      obj.value = value;
    }

    if (Empty(obj.children)) {
      delete obj.children;
      obj.size = value;
      obj.value = value;
    }

    if (!Empty(list[i]) || list[i] === 0)
      mapData.children.push(obj);
  }
  return mapData;
}

function getMatrixLinksDataset(data, hFields, valueFields, propertyName, identity, addfields) {
  var list_1 = getList(propertyName.indexOf(hFields[0]), data),
  list_2 = getList(propertyName.indexOf(hFields[1]), data),
  el_1,
  el_2,
  links = [],
  obj,
  val,
  ff;

  if (identity) { // devo uniformare le liste
    list_1 = list_1.concat(list_2);
    list_1 = list_1.unique();
    list_2 = list_1.slice();
  }

  for (var i = 0; i < data.length; i++) {
    val = data[i][propertyName.indexOf(valueFields)];
    el_1 = data[i][propertyName.indexOf(hFields[0])];
    el_2 = data[i][propertyName.indexOf(hFields[1])];
    obj = {};
    obj.source = list_1.indexOf(el_1);
    obj.target = list_2.indexOf(el_2);
    obj.value = val;
    obj.data_index = i;
    if (!Empty(addfields)) {
      for (ff = 0; ff < addfields.length; ff++) {
        obj[addfields[ff].prop] = data[i][addfields[ff].index];
      }
    }
    links.push(obj);
  }

  var dupes = getDupLinks(links).sort(function(a, b){ return b-a; });
  for (i = 0; i < dupes.length; i++)
    links.splice(dupes[i], 1);

  if (identity) {
    // aggiungo i rovesci
    var len = links.length;
    for (i = 0; i < len; i++) {
      links.push( { source: links[i].target, target: links[i].source, value: links[i].value, data_index: links[i].data_index } );
      if (!Empty(addfields)) {
        for (ff = 0; ff < addfields.length; ff++) {
          links[links.length - 1][addfields[ff].prop] = links[i][addfields[ff].prop];
        }
      }
    }

    // aggiungo la diagonale
    for (i = 0; i < list_1.length; i++) {
      obj = {};
      obj.source = i;
      obj.target = i;
      links.push(obj);
    }
  }

  return { links: links, array: list_1, array_2: list_2 };

  function getDupLinks(lnks) {
    var idxs = [];
    for (var i=0; i<lnks.length; i++) {
      for (var j=i+1; j<lnks.length; j++) {
        if (lnks[i].source === lnks[j].source){
          if (lnks[i].target === lnks[j].target)
            idxs.push(j);
        }
      }
    }
    return idxs.unique();
  }
}

function getMatrixDependencies(data, hFields, valueFields, propertyName, lFields) {
  // ragiona per righe
  var list_1 = getList(propertyName.indexOf(hFields[0]), data),
  list_2 = getList(propertyName.indexOf(hFields[1]), data),
  allList = [],
  labList = [],
  i,
  j,
  el_1,
  el_2,
  value,
  mat = [];

  var matobj = {},
  countobj = {};
  for (i = 0; i < data.length; i++) {
    el_1 = data[i][propertyName.indexOf(hFields[0])];
    el_2 = data[i][propertyName.indexOf(hFields[1])];
    if (!(el_1 in matobj))
      matobj[el_1] = [];
    if (matobj[el_1].indexOf(el_2) < 0)
      matobj[el_1].push(el_2);
    if (!(el_1 in countobj))
      countobj[el_1] = 0;
    countobj[el_1] ++;
    if (!(el_2 in countobj))
      countobj[el_2] = 0;
    countobj[el_2] ++;
  }

  var aa = matobj[Object.keys(matobj)[0]];
  aa.sort(function (a, b) {
    return countobj[b] - countobj[a];
  })

  var tl = [],
  keys = Object.keys(matobj);
  for (i = 0; i < keys.length; i++) {
    var ka = matobj[keys[i]];
    ka.sort(function (a, b) {
      return countobj[b] - countobj[a];
    });
    if (tl.indexOf(keys[i]) < 0)
      tl.push(keys[i]);
    for (j = 0; j < ka.length; j++) {
      if (tl.indexOf(ka[j]) < 0)
        tl.push(ka[j]);
    }
  }

  var tkey = Object.keys(countobj);
  tkey.sort(function (a, b) {
    return countobj[b] - countobj[a];
  });

  allList = list_1.concat(list_2);
  allList = allList.unique();

  allList = tl.slice();

  if (!Empty(lFields)) {
    labList = getList(propertyName.indexOf(lFields[0]), data).concat(getList(propertyName.indexOf(lFields[1]), data));
    labList = labList.unique();
  }

  for (i = 0; i < allList.length; i++) {
    mat.push([]);
    for (j = 0; j < allList.length; j++) {
      mat[i][j] = 0;
    }
  }

  for (i = 0; i < data.length; i++) {
    el_1 = data[i][propertyName.indexOf(hFields[0])];
    el_2 = data[i][propertyName.indexOf(hFields[1])];
    if (Empty(valueFields)) {
      value = 1;  // valore simbolico
      if (Empty(mat[allList.indexOf(el_2)]))
        mat[allList.indexOf(el_2)] = [];
      mat[allList.indexOf(el_2)][allList.indexOf(el_1)] = value;
      if (Empty(mat[allList.indexOf(el_1)]))
        mat[allList.indexOf(el_1)] = [];
      mat[allList.indexOf(el_1)][allList.indexOf(el_2)] = value;
    }
    else {
      value = data[i][propertyName.indexOf(valueFields)];
      if (Empty(mat[allList.indexOf(el_2)]))
        mat[allList.indexOf(el_2)] = [];
      mat[allList.indexOf(el_2)][allList.indexOf(el_1)] = value;
    }
  }

  return { matrix: mat, array: allList, arrayLabels: labList };
}

function getAllFonts() {
  return {
    websafe : [
      "Arial", "Arial Black", "Comic Sans MS", "Courier New",
      "Georgia", "Impact", "Lucida Console", "Lucida Sans Unicode",
      "Palatino Linotype", "Tahoma", "Times New Roman", "Trebuchet MS", "Verdana"
    ],
    offline: [
      "Open Sans", "Roboto", "Raleway", "Fira Sans", "Liquid Crystal",
      "JD LCD Rounded", "DejaVu Sans", "DejaVu Sans Condensed",
      "DejaVu Sans Mono", "DejaVu Serif", "DejaVu Serif Condensed",
      "Lets Go Digital", "Digital System", "Electronic Highway Sign"
    ],
    online: ['',
      'Coustard', 'Antic Slab', 'Quattrocento',
      'Cinzel', 'Josefin Slab', 'Merriweather', 'Lora',
      'Nunito', 'Abel', 'Fjalla One', 'Dosis', 'Economica',
      'Montserrat', 'Roboto Condensed', 'Oswald',
      'Special Elite', 'Fredoka One', 'Comfortaa', 'Bangers',
      'Righteous', 'Sigmar One', 'Patua One', 'Poiret One', 'Lobster',
      'Nova Mono', 'Inconsolata', 'Source Code Pro', 'Anonymous Pro', 'Roboto Mono',
      'Amatic SC', 'Shadows Into Light', 'Dancing Script', 'Pacifico', 'Indie Flower',
      'Share Tech Mono', 'Ubuntu Mono', 'VT323'
    ]
  };
}

function getRandomColor(){
  var letters = '0123456789ABCDEF'.split('');
  var color = '#';
  for (var i = 0; i < 6; i++ ) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

function getDuplicatesListCAT(keyidx, dupidx, dataSet, mcounter) {
	var array = [];
	var karray = [];
	var count = [];
  var setCount = false;
	if (keyidx != -1) {
		dataSet.forEach(function(record) {
      if( record != null ) {
        if (karray.indexOf(record[keyidx]) < 0) {
          if(record[keyidx]!=null) karray.push(record[keyidx].toString());
		  else karray.push(record[keyidx]);
          if ((Empty(mcounter) || (mcounter && !mcounter[record[dupidx].toString()])) && !count[record[dupidx].toString()]) {
            count[record[dupidx].toString()] = 1;
            array.push(record[dupidx].toString());
          }
          else {
            if (mcounter && mcounter[record[dupidx].toString()] && !setCount) {
              count[record[dupidx].toString()] = mcounter[record[dupidx].toString()];
              setCount = true;
            }
            if(count[record[dupidx].toString()]==1)
              array[array.indexOf(record[dupidx].toString())] = record[dupidx].toString() /*+ " ("+count[record[dupidx].toString()]+")";*/
            count[record[dupidx].toString()] ++;
            array.push(record[dupidx].toString()/* + " (" + count[record[dupidx].toString()] + ")"*/);
          }
        }
      }
		});
	}
	return {array:array, countobj:count};
}

// workaround x IE
Math.trunc = Math.trunc || function(x) {
  if (isNaN(x)) {
    return NaN;
  }
  if (x > 0) {
    return Math.floor(x);
  }
  return Math.ceil(x);
};

function getSankeyNodesDataset(data, hFields, valueFields, propertyName, addfields) {
  var list_1 = getList(propertyName.indexOf(hFields[0]), data),
  list_2 = getList(propertyName.indexOf(hFields[1]), data),
  el_1,
  el_2,
  links = [],
  tmp_n = [],
  nodes = [],
  obj,
  val;

//la lista e' una sola
  list_1 = list_1.concat(list_2);
  list_1 = list_1.unique();
  list_2 = list_1.slice();

  for (var i = 0; i < data.length; i++) {
    val = data[i][propertyName.indexOf(valueFields)];
    el_1 = data[i][propertyName.indexOf(hFields[0])];
    el_2 = data[i][propertyName.indexOf(hFields[1])];
    obj = {};
    obj.source = list_1.indexOf(el_1);
    obj.target = list_2.indexOf(el_2);
    obj.value = val;
    if (!Empty(addfields)) {
      for (var ff = 0; ff < addfields.length; ff++) {
        obj[addfields[ff].prop] = data[i][addfields[ff].index];
      }
    }
    links.push(obj);

    if (tmp_n.indexOf(el_1) < 0 && list_1.indexOf(el_1) >= 0) {
      tmp_n.push(el_1);
      nodes.push({ name: el_1/*, index: list_1.indexOf(el_1) */});
    }

    if (tmp_n.indexOf(el_2) < 0 && list_1.indexOf(el_2) >= 0) {
      tmp_n.push(el_2);
      nodes.push({ name: el_2/*, index: list_1.indexOf(el_2)*/ });
    }
  }

  var dupes = getDupLinks(links).sort(function(a, b){ return b-a; });
  for (i = 0; i < dupes.length; i++)
    links.splice(dupes[i], 1);

  nodes.sort(function(a, b) { return list_1.indexOf(a.name) - list_1.indexOf(b.name) })

  return { links: links, nodes: nodes };

  function getDupLinks(lnks) {
    var idxs = [];
    for (var i=0; i<lnks.length; i++) {
      for (var j=i+1; j<lnks.length; j++) {
        if (lnks[i].source === lnks[j].source){
          if (lnks[i].target === lnks[j].target)
            idxs.push(j);
        }
      }
    }
    return idxs.unique();
  }
}

function arrayCompare(org, newarr) {
  if(!newarr)
      return false;

  if(org.length != newarr.length)
      return false;

  for (var i = 0, l=org.length; i < l; i++) {
      if(org[i] instanceof Array && newarr[i] instanceof Array) {
          if(!arrayCompare(org[i], newarr[i]))
              return false;
      }
      else if(org[i] != newarr[i]) {
          return false;
      }
  }
  return true;
}

function decodeConditionalFormatting(fncRet) {
  if (Empty(fncRet))
    return null;
  var todec = fncRet,
  ret = {};
  if (typeof todec == "string")
    todec = JSON.parse(fncRet);
  // fill
  if (todec.background) ret.fill = todec.background;
  if (todec.backgroundColor) ret.fill = todec.backgroundColor;
  if (todec["background-color"]) ret.fill = todec["background-color"];
  if (todec.fill) ret.fill = todec.fill;
  if (todec.fillColor) ret.fill = todec.fillColor;
  if (todec["fill-color"]) ret.fill = todec["fill-color"];

  return ret;
}