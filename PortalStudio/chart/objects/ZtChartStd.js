// definizione StdChart
if (typeof (StdChart) == "undefined") {
  function StdChart(type, legendCode) {
    this.applyFocusKey = true;
    this.type = type;
    this.legendHexCode = legendCode;
    this.customColorsSeries = {};
    this.customColors = {};
    this.urlReference = null;
  };
}


function fillChartMenu(_this) {
  if (typeof ZtVWeb == 'undefined')
    return;
  
  if (Empty(_this._ZtChart._vpvMenu) || !_this._ZtChart._vpvMenu) {
    var chartssub = getAllCharts(true);
    /** PRIMO MENU - AZIONI **/
    var actions = [];
    if (_this.menu.dataOrder && _this._SupportChangeOrder()) {
      actions.push({
        id: "DATAORDER",
        title: _this.Translate("ZTC_DATAORDER"),
        action: function () {
          _this._ZtChart.changeDataOrder();
          _this.menu.ctrl.CloseMenu();
          if (window[_this.chartId + "onMenuClick"])
            window[_this.chartId + "onMenuClick"]({ action: "changeDataOrder" });
          else if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
            _this._ZtChart.parentCtrl.dispatchEvent("onMenuClick", d3.event, { action: "changeDataOrder" });
        }
      }
      );
    }
  
    if (_this.menu.selection) {
      var selchd = [];
      selchd.push({
        id: "SELMIN",
        title: _this.Translate("ZTC_SELMIN"),
        action: function () {
          _this.SelectAllValues("min");
          _this.menu.ctrl.CloseMenu();
          if (window[_this.chartId + "onMenuClick"])
            window[_this.chartId + "onMenuClick"]({ action: "selectMinValueElements" });
          else if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
            _this._ZtChart.parentCtrl.dispatchEvent("onMenuClick", d3.event, { action: "selectMinValueElements" });
        }
      }
      );
      selchd.push({
        id: "SELMAX",
        title: _this.Translate("ZTC_SELMAX"),
        action: function () {
          _this.SelectAllValues("max");
          _this.menu.ctrl.CloseMenu();
          if (window[_this.chartId + "onMenuClick"])
            window[_this.chartId + "onMenuClick"]({ action: "selectMaxValueElements" });
          else if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
            _this._ZtChart.parentCtrl.dispatchEvent("onMenuClick", d3.event, { action: "selectMaxValueElements" });
        }
      }
      );
      selchd.push({
        id: "SELALL",
        title: _this.Translate("ZTC_SELALL"),
        action: function () {
          _this.SelectAllValues("all");
          _this.menu.ctrl.CloseMenu();
          if (window[_this.chartId + "onMenuClick"])
            window[_this.chartId + "onMenuClick"]({ action: "selectAllElements" });
          else if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
            _this._ZtChart.parentCtrl.dispatchEvent("onMenuClick", d3.event, { action: "selectAllElements" });
        }
      }
      );
      selchd.push({
        id: "SELREM",
        title: _this.Translate("ZTC_SELREM"),
        action: function () {
          _this.RemoveAllSelections();
          _this.menu.ctrl.CloseMenu();
          if (window[_this.chartId + "onMenuClick"])
            window[_this.chartId + "onMenuClick"]({ action: "removeAllSelections" });
          else if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
            _this._ZtChart.parentCtrl.dispatchEvent("onMenuClick", d3.event, { action: "removeAllSelections" });
        }
      }
      );
      actions.push({ id: "SELECTITEM", title: _this.Translate("ZTC_SELECTITEM"), children: selchd.slice() });
    }
  
    if (_this.menu.aggregateData) {
      actions.push({
        id: "SHOWOTH",
        title: _this.Translate("ZTC_SHOWOTH"),
        action: function () {
          _this.ShowAggregateDetail();
          _this.menu.ctrl.CloseMenu();
          if (window[_this.chartId + "onMenuClick"])
            window[_this.chartId + "onMenuClick"]({ action: "viewAggregateDetail" });
          else if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
            _this._ZtChart.parentCtrl.dispatchEvent("onMenuClick", d3.event, { action: "viewAggregateDetail" });
        }
      }
      );
    }
  
    if (_this.menu.enableGrid) {
      actions.push({
        id: "DATAGRID",
        title: _this.Translate("ZTC_DATAGRID"),
        action: function () {
          _this._ViewGridData();
          _this.menu.ctrl.CloseMenu();
        }
      }
      );
    }
  
    var i, name;
    if (_this.menu.download) {
      var exp = [];
      for (i = 0; i < _this.downloadFormats.length; i++) {
        name = _this.downloadFormats[i].toUpperCase();
        if (!Empty(name)) {
          exp.push({
            id: name,
            title: _this.Translate("ZTC_" + name),
            action: "javascript:window.applyChartMenuFnc('" + name + "','" + _this.chartId + "','true')"
          }
          );
        }
      }
      if (!Empty(exp))
        actions.push({ id: "MENUEXPORT", title: _this.Translate("ZTC_MENUEXPORT"), children: exp });
    }
    /** SECONDO MENU - TIPI DI GRAFICO **/
    var initialType = _this._ZtChart.initialType;
    if (_this.menu.otherCharts) {
      var tarr = [],
        ttyp = [],
        mcat = getChartMacroCategoryType(_this.type),
        mkeys = Object.keys(chartssub[mcat]);
      tarr.push({
        id: "CURRENTCHART",
        title: _this.Translate("ZTC_CURRENTCHART") + " (" + _this.Translate("ZTC_" + initialType) + ")",
        action: "javascript:applyChartMenuFnc('" + initialType + "','" + _this.chartId + "')"
      }
      );
  
      for (i = 0; i < mkeys.length; i++) {
        ttyp = [];
        for (var j = 0; j < chartssub[mcat][mkeys[i]].length; j++) {
          name = chartssub[mcat][mkeys[i]][j];
          if (!Empty(name) && _this.otherCharts.indexOf(name) >= 0 && name != initialType) {
            ttyp.push({
              id: name,
              title: _this.Translate("ZTC_" + name),
              action: "javascript:window.applyChartMenuFnc('" + name + "','" + _this.chartId + "')"
            }
            );
          }
        }
        if (!Empty(ttyp))
          tarr.push({ id: mkeys[i].toUpperCase(), title: _this.Translate("ZTC_" + mkeys[i].toUpperCase()), children: ttyp });
      }
    }
  
    /** TERZO MENU - OPT LEGENDA **/
    if (_this.chartLegends.series && _this.chartLegends.series.hide) {
      var leg = [],
        icons = [],
        check = true;
      for (i = 0; i < _this.legendList.length; i++) {
        icons = [];
        if (_this._ZtChart.enableExclude) {
          check = _this._IsNotExcluded(i);
          icons.push({
            fontFamily: _this.GetDefaultIconFont().name,
            fontSize: _this.GetDefaultIconFont().size,
            color: "",
            fontWeight: "normal",
            value: getIconFromCode(check ? _this.GetCheckIconCode() : _this.GetUncheckIconCode()),
            attrs: { "data-index": i, "data-text": _this.legendList[i], "data-menu": true, "data-font": check ? _this.GetCheckIconCode() : _this.GetUncheckIconCode(), "data-check": check },
            style: { cursor: !_this._ZtChart.enableLegendClick ? "default" : "pointer" },
            action: function (item) {
              _this._ApplyLegendExclude(item);
            }
          }
          );
        }
  
        icons.push({
          fontFamily: _this.GetDefaultIconFont().name,
          fontSize: _this.GetDefaultIconFont().size,
          color: _this.colorSet[i].color,
          fontWeight: "normal",
          value: _this.GetLegendIcon(),
          attrs: { "data-index": i, "data-text": _this.legendList[i], "data-menu": true },
          style: { cursor: !_this._ZtChart.enableLegendClick ? "default" : "pointer" },
          action: function (item) {
            if (!_this._ZtChart.enableLegendClick)
              return;
            _this._ApplyLegendClick(item);
          },
          mouse: {
            over: function (item) {
              if (!_this._ZtChart.enableLegendEffect)
                return;
              _this._ApplyLegendMouseOver(item);
            },
            out: function (item) {
              if (!_this._ZtChart.enableLegendEffect)
                return;
              _this._ApplyLegendMouseOut(item);
            }
          }
        }
        );
        leg.push({
          id: "LEGEND_" + i,
          title: _this.legendList[i],
          attrs: { "data-index": i, "data-text": _this.legendList[i], "data-menu": true },
          style: { cursor: !_this._ZtChart.enableLegendClick ? "default" : "pointer" },
          icons: icons.slice(),
          action: function (item) {
            if (!_this._ZtChart.enableLegendClick)
              return;
            _this._ApplyLegendClick(item);
          },
          mouse: {
            over: function (item) {
              if (!_this._ZtChart.enableLegendEffect)
                return;
              _this._ApplyLegendMouseOver(item);
            },
            out: function (item) {
              if (!_this._ZtChart.enableLegendEffect)
                return;
              _this._ApplyLegendMouseOut(item);
            }
          }
        }
        );
      }
    }    
  }
    
  _this.form = null;
  if (_this._ZtChart.parentCtrl)
    _this.form = _this._ZtChart.parentCtrl.form;
  else
    _this.form = {
      width: _this.defSettings.globals.width,
      height: _this.defSettings.globals.height,
      ctrls: [],
      formid: _this.chartId + "pform",
      class_name: "portlet",
      portletname: "ztchart",
      Ctrl: _this.parent
    };

  var menuHeight = 24,
    hmenu;

  if (Empty(_this._ZtChart._vpvMenu) || !_this._ZtChart._vpvMenu) {
    hmenu = new ZtVWeb.HamburgerMenuCtrl(_this.form, _this.chartId + 'menu', 'hmenu', 0, 0, menuHeight, menuHeight, 'top-' + _this.objConfig.menuPosition, 'SPPortalZoomBaseMenu', 10);
    hmenu.Clean();
    if (actions && actions.length > 0)
      hmenu.Append({ id: "MENUCTX", title: _this.Translate("ZTC_MENUCTX"), children: actions });
    if (tarr && tarr.length > 0)
      hmenu.Append({ id: "MENUTYPES", title: _this.Translate("ZTC_MENUTYPES"), children: tarr });
    if (leg && leg.length > 0)
      hmenu.Append({ id: "MENULEGEND", title: _this.chartLegends.series.obj.text || _this.Translate("ZTC_MENULEGEND"), children: leg });
  }
  else {
    if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.fillMenuCtrl)
    hmenu = _this._ZtChart.parentCtrl.fillMenuCtrl(hmenu, _this.chartId + 'menu');
  }
  if(!hmenu) return;
  hmenu.Ctrl.style.right = "";
  hmenu.Ctrl.style.left = "";
  hmenu.Ctrl.style.padding = "";
  _this.menu.ctrl = hmenu;

  if (Empty(_this._ZtChart._vpvMenu) || !_this._ZtChart._vpvMenu) {
    _this.form.hmenu_AfterMenuOpen = function () {
      _this.menu.ctrl.CtrlWrapper.firstChild.style.padding = "0px";
      _this.menu.ctrl.CtrlWrapper.firstChild.style.textAlign = "center";
      _this.menu.ctrl.CtrlWrapper.firstChild.style.lineHeight = menuHeight + "px";
      _this._ZtChart.menuWrapper = _this.menu.ctrl.CtrlWrapper;
    }
  }
}

function fillFilterMenu(_this) {
  if (typeof ZtVWeb == 'undefined')
    return;

  if (!_this._ZtChart.enableExclude)
    return;

  /** MENU - FILTRI DOMINIO **/
  var leg = [],
    icons = [],
    check = true;
  for (var i = 0; i < _this.rowLegendList.length; i++) {
    icons = [];
    check = _this._IsNotExcludedDomain(_this.rowLegendList[i]);
    icons.push({
      fontFamily: _this.GetDefaultIconFont().name,
      fontSize: _this.GetDefaultIconFont().size,
      color: "",
      fontWeight: "normal",
      value: getIconFromCode(check ? _this.GetCheckIconCode() : _this.GetUncheckIconCode()),
      attrs: { "data-index": i, "data-text": _this.rowLegendList[i], "data-menu": true, "data-font": check ? _this.GetCheckIconCode() : _this.GetUncheckIconCode(), "data-check": check },
      style: { cursor: "pointer" },
      action: function (item) {
        _this._ApplyLegendExclude(item);
      }
    });
    leg.push({
      id: "DOMAINTEXT_" + i,
      title: _this.rowLegendList[i],
      attrs: { "data-index": i, "data-text": _this.rowLegendList[i], "data-menu": true },
      style: { cursor: "default" },
      icons: icons.slice(),
      action: function (item) {
        if (item.parentNode && item.parentNode.firstChild)
          _this._ApplyLegendExclude(item.parentNode.firstChild);
      }
    }
    );
  }

  if (!_this.form) {
    if (_this._ZtChart.parentCtrl)
      _this.form = _this._ZtChart.parentCtrl.form;
    else
      _this.form = {
        width: _this.defSettings.globals.width,
        height: _this.defSettings.globals.height,
        ctrls: [],
        formid: _this.chartId + "pfform",
        class_name: "portlet",
        portletname: "ztchartf",
        Ctrl: _this.parent
      };
  }

  var menuHeight = 24,
    fmenu = new ZtVWeb.HamburgerMenuCtrl(_this.form, _this.chartId + 'fmenu', 'fmenu', 0, 0, menuHeight, menuHeight, 'top-' + _this.fmenu.position, 'SPPortalZoomBaseMenuFilter', 10);

  fmenu.Clean();
  fmenu.Append({ id: "MENUFILTER", title: _this.Translate("ZTC_MENUFILTER"), children: leg });

  fmenu.Ctrl.style.right = "";
  fmenu.Ctrl.style.left = "";
  fmenu.Ctrl.style.padding = "";
  _this.fmenu.ctrl = fmenu;

  _this.form.fmenu_AfterMenuOpen = function () {
    _this.fmenu.ctrl.CtrlWrapper.firstChild.style.padding = "0px";
    _this.fmenu.ctrl.CtrlWrapper.firstChild.style.textAlign = "center";
    _this.fmenu.ctrl.CtrlWrapper.firstChild.style.lineHeight = menuHeight + "px";
    _this._ZtChart.fmenuWrapper = _this.fmenu.ctrl.CtrlWrapper;
  }
}


/** prototipi ex-ZtChart */
StdChart.prototype.DrawCallback = function () {
  var itemObjects;
  var _this = this;
  try {
    itemObjects = arguments[1];
  }
  catch (e) { }

  try {
    if (!Empty(d3.select("#" + this.parent.id + "_svgChartLoading").node())) {
      if (this._ZtChart.parentCtrl && !isNaN(parseInt(this._ZtChart.parentCtrl.zindex)))
        d3.select("#" + this.parent.id + "_svgChartLoading").style("z-index", parseInt(this._ZtChart.parentCtrl.zindex));
    }

    this.ResetAllTimeouts();
    this.ResetItems();
    this.ShowMaskDivAnimation();
    if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
      this._ZtChart.parentCtrl.dispatchEvent("Drawing", d3.event);

    if (this.chartWidth <= 0 || this.chartHeight <= 0) {
      this.RemoveLoadingDiv();
      this.DrawNotAvailableDiv(this.Translate("ZTC_ERRSIZE"));
      if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
        this._ZtChart.parentCtrl.dispatchEvent("OnError", d3.event);
      return;
    }

    if (Empty(this.dataSet)) {
      this.HideMaskDivAnimation();
      this.RemoveLoadingDiv();
      this.DrawNotAvailableDiv(this.Translate("ZTC_NODATA"));
      if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
        this._ZtChart.parentCtrl.dispatchEvent("OnError", d3.event);
      return;
    }

    this.SetMenuItems();
    this.RemoveElements();
    this._UpdateDrawingList();
    if (!this.applyCalculationAfter)
      this._SetCalculationDataset();
    this._SetScales(this._ZtChart.datetimePict);
    this.EvaluateDrawingSpace();
    this._DrawChartPlot();
    this.DrawProgressDrawingBar();
    this._DrawPatterns();
    this._DrawChartElements();
    this.DrawNotRepresentedDataIcon();
    this.AfterDraw();

    var parentW = this.parent.offsetWidth;
    var parentH = this.parent.offsetHeight;
    if ((this.defSettings.globals.width > parentW || this.defSettings.globals.height > parentH) && this.objConfig.scrollView)
      this.parent.style.overflow = "auto";
    else
      this.parent.style.overflow = "initial";

    var delay = this.animationDelay;
    if (delay > 0)
      delay += 100;
    else
      delay += 200;
    if (this.forPJS)
      timeoutSequence();
    else {
      var timeout = setTimeout ( function () { timeoutSequence(); }, delay);
      this.allTimeouts.push(timeout);
    }
  }
  catch (error) {
    this.ResetAllTimeouts();
    this.HideMaskDivAnimation();
    this.RemoveLoadingDiv();
    this.DrawNotAvailableDiv(this.Translate("ZTC_ERROR"));
    if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
      this._ZtChart.parentCtrl.dispatchEvent("OnError", d3.event);
    console.log(error.stack);
    throw error;
  }

  function timeoutSequence() {
    if (itemObjects)
      _this.ApplySelectionsObjects(itemObjects);
    _this.ApplyFocusKey();
    var spanels = d3.selectAll(".ztchart_span");
    spanels.remove();
    if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
      _this._ZtChart.parentCtrl.dispatchEvent("Rendered", d3.event);
  }
}
StdChart.prototype.RedrawCallback = function (newData, newObjConfig/*, isFilter /*zf*/) {
  var jn = JSON.stringify(newData),
  pn = JSON.stringify(this.dataSet);
  if (jn === null || jn === undefined)
    newData = [];
  if ((jn == pn) /*&& !this.filterCategory*/)
    return;
  this._EvaluateRedraw(newData, newObjConfig);
}
StdChart.prototype.RedrawData = function () {
  var _this = this,
  itemObjects = this.GetSelectedItems();
  this._UpdateDrawingList();
  this._EvaluateDatasetAndCalculation();
  this._SetScales(this._ZtChart.datetimePict);
  this.SetMargins();
  this.ResetAllTimeouts();
  this.ShowMaskDivAnimation();
  if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
    this._ZtChart.parentCtrl.dispatchEvent("Drawing", d3.event);
  this.ResetItems();
  this.AdjustMaskAndRenderer();
  this._DrawChartPlotElements();
  this.DrawProgressDrawingBar();
  this._DrawPatterns();
  this._DrawChartElements();
  this.AfterDrawRenderer();

  var delay = this.animationDelay;
  if (delay > 0)
    delay += 100;
  else
    delay += 200;
  var timeout = setTimeout ( function () {
    if (itemObjects) {
      _this.ApplySelectionsObjects(itemObjects);
      _this.ApplyFocusKey();
    }
    if (_this._ZtChart.parentCtrl && _this._ZtChart.parentCtrl.dispatchEvent)
      _this._ZtChart.parentCtrl.dispatchEvent("Rendered", d3.event);
  }, delay);
  this.allTimeouts.push(timeout);
}
StdChart.prototype.AppendData = function (data) {
  if (Empty(data))
    return;
 // checkNewData(this.xIndex, this.dataSet, data);
  this._UpdateDrawingList();
//  this._EvaluateDatasetAndCalculation();
  this._SetLists();
  this._SetScales(this._ZtChart.datetimePict);
  this.SetMargins();
  this.ResetAllTimeouts();
  this.ShowMaskDivAnimation();
  if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent)
    this._ZtChart.parentCtrl.dispatchEvent("Drawing", d3.event);
  this.ResetItems();
  this.AdjustMaskAndRenderer();
  this._DrawChartPlotElements();
  this.DrawProgressDrawingBar();
  this._DrawPatterns();
  this._DrawChartElements();
  this.AfterDrawRenderer();

  this.UpdateBrush();

  /*function checkNewData (xIndex, dataSet, data) {
    
  }*/
}
StdChart.prototype.DrawNotAvailableDiv = function(text) {
  var _this = this;
  if (_this.parent && d3.select("#" + _this.chartId + "divchartcontainer").node())
    d3.select("#" + this.chartId + "divchartcontainer").remove();//_this.parent.removeChild(d3.select("#" + _this.chartId + "divchartcontainer").node());
  var txtNAv = d3.select("#" + _this.chartId + "notAv").node();
  if (Empty(txtNAv)) {
    txtNAv = document.createElement("div");
    txtNAv.id = _this.chartId + "notAv";
    txtNAv.className = "label";
    txtNAv.style.textAlign = "center";
    txtNAv.style.width = "100%";
    txtNAv.style.position = "absolute";
    txtNAv.style.top = "45%";
    _this.parent.appendChild(txtNAv);
  }
  txtNAv.textContent = text;
}
StdChart.prototype.RemoveElements = function () {
  if (!Empty(d3.select("#" + this.chartId + "divchartcontainer").node()))
    d3.select("#" + this.chartId + "divchartcontainer").remove();
  if (!Empty(d3.select("#" + this.chartId + "menuBar").node()))
    d3.select("#" + this.chartId + "menuBar").remove();
  if (!Empty(d3.select("#" + this.chartId + "notAv").node()))
    d3.select("#" + this.chartId + "notAv").remove();
  if (this._ZtChart.menuWrapper && this._ZtChart.menuWrapper.parentNode) {
    this._ZtChart.menuWrapper.parentNode.removeChild(this._ZtChart.menuWrapper);
    this._ZtChart.menuWrapper = null;
  }
  if (this._ZtChart.fmenuWrapper && this._ZtChart.fmenuWrapper.parentNode) {
    this._ZtChart.fmenuWrapper.parentNode.removeChild(this._ZtChart.fmenuWrapper);
    this._ZtChart.fmenuWrapper = null;
  }
  if (!Empty(d3.select("#" + this.chartId + "maskFrame").node()))
    d3.select("#" + this.chartId + "maskFrame").remove();
  if (!Empty(d3.select("#" + this.chartId + "tooltipDiv").node()))
    d3.select("#" + this.chartId + "tooltipDiv").remove();
  if (!Empty(d3.select("#" + this.chartId + "grid").node()))
    d3.select("#" + this.chartId + "grid").remove();
}
StdChart.prototype.DrawChartMenu = function () {
  //console.log("DrawChartMenu", this._ZtChart._vpvMenu)
  if (this.forPJS)
    return;
  var drawBar = true,
  evalMenu = this.menu && this.menu.show,
  evalFMenu = this.fmenu && this.fmenu.show,
  evalMDim = this.defSettings.multiDimensional && this.defSettings.multiDimensional.multiDim;
  if (!evalMenu && !evalFMenu && !evalMDim)
    drawBar = false;
  if (!drawBar)
    return;
  var _this = this._ZtChart.StdChart,
  menu,
  menuHeight = 24,
  hideCondition;

  if (this.asZoomCursor && this._ZtChart.StdChartCursor) {
    _this = this;
    //_this.menu = null;
  }

  if (Empty(document.getElementById(_this.chartId + "menuBar"))) {
    if (Empty(_this._ZtChart._vpvMenu) || !_this._ZtChart._vpvMenu) {
      menu = d3.select("#" + _this.chartId + "divchartcontainer")
            .append("div")
              .attr("id", _this.chartId + "menuBar")
              .style("position", "absolute")
              .style("top", getDomNodeTop(d3.select("#" + _this.chartId + "divchartcontainer").node()) + 2 + "px")
              .style("left", 3 + "px")
              .style("height", menuHeight + "px")
              .style("z-index", 1200)
              .style("display", function () {
                if (_this.runningMultiDim || _this._ZtChart._vpvMenu)
                  return "block";
                return "none";
              });
    }
    else {
      menu = d3.select("#" + _this.chartId + "divchartcontainer")
      .insert("div", "svg")
        .attr("id", _this.chartId + "menuBar")
        .style("position", "relative")
        .style("top",  5 + "px")
        .style("left", 5 + "px")
        .style("height", menuHeight + "px")
        .style("z-index", 1200)
        .style("display", function () {
          if (_this.runningMultiDim || _this._ZtChart._vpvMenu)
            return "block";
          return "none";
        });
    }
    

    if (_this.menu && _this.menu.show) {
      hideCondition = !_this.menu.show;
      hideCondition = hideCondition || (!_this.menu.selection && !_this.menu.dataOrder && !_this.menu.otherCharts && !_this.menu.download && !_this.menu.aggregateData && !_this.menu.enableGrid); // eslint-disable-line max-len
      hideCondition = hideCondition && (_this.chartLegends && _this.chartLegends.series && (_this.chartLegends.series.hide && _this.chartLegends.series.position != "hide"));
      hideCondition = hideCondition && (_this.chartLegends && _this.chartLegends.range && (_this.chartLegends.range.hide && _this.chartLegends.range.position != "hide"));
      if (!hideCondition && !_this.asZoomCursor) {
        menu.append("div")
          .attr("id", _this.chartId + "menu")
          .attr("class", "SPPortalZoomBaseMenu global_handler closed menu_ctrl")
        fillChartMenu(_this);
        if (!this._ZtChart._vpvMenu) {
          d3.select("#" + _this.chartId + "menu")
            .style("left", function () {
              if (_this.menu.position == "right")
                return (_this.defSettings.globals.width - menuHeight - 3) + "px";
              return 3 + "px";
            });
        }
      }
    }

    if (_this.menu && _this.menu.ctrl && !_this._ZtChart._vpvMenu) {
      _this.menu.ctrl.Ctrl.style.padding = 0 + "px";
      _this.menu.ctrl.Ctrl.style.textAlign = "center";
      _this.menu.ctrl.Ctrl.style.lineHeight = menuHeight + "px";
    }

    var Moffset = 0;
    var MoffsetW = 0;
    if (_this.asZoomCursor) {
      Moffset = 3;
      MoffsetW = menuHeight;
      menu.append("div")
          .attr("id", _this.chartId + "resetZoomCursor")
          .attr("title", _this.Translate("ZTC_RESETZOOM"))
          .text(function () {
            return getIconFromCode("eae2");
          })
          .style("position", "absolute")
          .style("left", function () {
            var menu = d3.select("#" + _this.chartId + "menu");
            if (menu.node()) {
              var left = parseFloat(menu.style("left"));
              if (_this.menu.position == "right")
                return (left - menuHeight) + "px";
              return (left + menuHeight) + "px";
            }
            if (_this.menu.position == "right")
              return (_this.defSettings.globals.width - menuHeight - Moffset) + "px";
            return Moffset + "px";
          })
          .style("width", menuHeight + "px")
          .style("height", menuHeight + "px")
          .style("line-height", menuHeight + "px")
          .style("cursor", "pointer")
          .style("font-family", _this.GetDefaultIconFont().name)
          .style("color", _this.defSettings.globalFont.color)
          .style("font-size", "20px")
          .on("click", function () {
            _this.ResetZoomCursor();
          });
    }

    if (_this.defSettings.multiDimensional && _this.defSettings.multiDimensional.multiDim) {
      if(_this.defSettings.multiDimensional.cursorType == "axis" || _this.defSettings.multiDimensional.cursorType == "value" || _this.defSettings.multiDimensional.cursorType == "combo") {
        menu.append("div")
          .attr("id", _this.chartId + "playMultiDimensional")
          .attr("title", _this.Translate("ZTC_PLAPAU"))
          .text(function () {
            return _this.GetMultiDimensionalIcon("play");
          })
          .style("position", "absolute")
          .style("left", function () {
            var menu = d3.select("#" + _this.chartId + "menu");
            if (menu.node()) {
              var left = parseFloat(menu.style("left"));
              if (_this.menu.position == "right")
                return (left - menuHeight - MoffsetW) + "px";
              return (left + menuHeight + MoffsetW) + "px";
            }
            if (_this.menu.position == "right")
              return (_this.defSettings.globals.width - menuHeight - 3 - Moffset - MoffsetW) + "px";
            return (3 + Moffset + MoffsetW) + "px";
          })
          .style("width", menuHeight + "px")
          .style("height", menuHeight + "px")
          .style("line-height", menuHeight + "px")
          .style("cursor", "pointer")
          .style("font-family", _this.GetDefaultIconFont().name)
          .style("color", _this.defSettings.globalFont.color)
          .style("font-size", "20px")
          .on("click", function () {
            _this._PlayCursor();
          });
      }
    }

    if (_this.fmenu && _this.fmenu.show) {
      menu.append("div")
        .attr("id", _this.chartId + "fmenu")
        .attr("class", "SPPortalZoomBaseMenuFilter global_handler closed fmenu_ctrl");
      fillFilterMenu(_this);
      d3.select("#" + _this.chartId + "fmenu")
          .style("left", function () {
            if (_this.fmenu.position == "right")
              return (_this.defSettings.globals.width - menuHeight - 3) + "px";
            return 3 + "px";
          });
    }

    if (_this.fmenu && _this.fmenu.ctrl) {
      _this.fmenu.ctrl.Ctrl.style.padding = 0 + "px";
      _this.fmenu.ctrl.Ctrl.style.textAlign = "center";
      _this.fmenu.ctrl.Ctrl.style.lineHeight = menuHeight + "px";
    }

    if (!_this._ZtChart._vpvMenu) {
      d3.select("#" + _this.chartId + "d3ChartPlot").node().onmouseover = function () {
        if (d3.select("#" + _this.chartId + "menuBar").node())
          d3.select("#" + _this.chartId + "menuBar").node().style.display = "block";
      }

      d3.select("#" + _this.chartId + "d3ChartPlot").node().onmouseleave = function (e) {
        if (d3.select("#" + _this.chartId + "menuBar").node()) {
          var divX = getX(d3.select("#" + _this.chartId + "menuBar").node()),
          divY = getY(d3.select("#" + _this.chartId + "menuBar").node()),
          nMenu = _this.defSettings.globals.width,
          scTop = getScrollTop(d3.select("#" + _this.chartId + "menuBar").node());

          if ((e.pageX >= divX && e.pageX <= (divX + nMenu)) && ((e.pageY + scTop) >= divY && (e.pageY + scTop) <= (divY + menuHeight)) || _this.runningMultiDim)
            d3.select("#" + _this.chartId + "menuBar").node().style.display = "block";
          else {
            d3.select("#" + _this.chartId + "menuBar").node().style.display = "none";
            if (_this.menu && _this.menu.ctrl)
              _this.menu.ctrl.CloseMenu();
            if (_this.fmenu && _this.fmenu.ctrl)
              _this.fmenu.ctrl.CloseMenu();
          }
        }
      }
    }
  }
}
StdChart.prototype.GetChart = function (type, evalCont) {
  if (this._ZtChart)
    return this._ZtChart._getChartCType(type, evalCont);
  return null;
}
StdChart.prototype.InitChart = function (options) {
  /* opts params
    ztChart, chartConfig, objConfig, propertyName, dataset, parent, fncObj, lnkObj
    chartId, container, noCalc
  */
  this._ZtChart = options.ztChart;
  this.Init({
    _ZtChart: options.ztChart,
    chartConfig: options.chartConfig,
    objConfig: options.objConfig,
    propertyName: options.propertyName,
    propertyValue: options.dataset,
    parent: options.parent, 
    functionObj: options.fncObj,
    linkObj: options.lnkObj, 
    mychartid: options.chartId, 
    chartContainer: options.container,
    datetimePict: options.ztChart.datetimePict,
    addData: options.addData,
    addPName: options.addPName
  });
  this.SetJsonDef();
  this._SetFieldsIndexes();
  this._SetLists();

  this.SetDomainType(options.ztChart.datetimePict);
  if (!options.noCalc) {
    this.SetTotalsData();
    this.SetAggregateData();
  }
  var stdChart = this;
  if (this._ZtChart.StdChart)
    stdChart = this._ZtChart.StdChart;
  if (!(this.multiDimKeepSameScale && stdChart.IsMultiDim()) || !this.applyCalculationAfter)
    this._SetCalculationDataset();
  this.__initDone = true;
  if (this._AfterSettingMap)
    this._AfterSettingMap();
}
StdChart.prototype.SetChartDraw = function () {
  this._SetTitles();
  this.SetRangeList();
  this.SetChartLegends();
  this._SetScales(this._ZtChart.datetimePict);
  this.SetMargins(this._ZtChart.datetimePict);
}
StdChart.prototype.SetDataDraw = function () {
  this.CheckConcatKeys();

  this.SetData();
  this.CheckDataSet();
}
StdChart.prototype.SetIsStaticChart = function (value) {
  this.drawStatic = value;
}
StdChart.prototype.RemoveLoadingDiv = function () {
  d3.select("#" + this.parent.id + "_svgChartLoading").remove();
}
StdChart.prototype.SetPhantomJS = function (value) {
  this.forPJS = value;
}
StdChart.prototype.SetWebRootURL = function (value) {
  this.urlReference = value;
}
StdChart.prototype.CheckConcatKeys = function () { //MG VPV
  if (!this.objConfig.concatKey && !this.objConfig.concatDomain)
    return;  
  var kfields,yfields,
  afields,bfields,
  i, j, idx,
  new_data,
  new_value, lnew_value;
  if (this.objConfig.concatKey) {
    kfields = Strtran(this.objConfig.keyField, ",", "__");
    afields = this.objConfig.keyField.split(",");
    this.propertyName.push(kfields);
    this.objConfig.keyFieldConcat = this.objConfig.keyField;
    this.objConfig.keyField = kfields;
    yfields = Strtran(this.objConfig.labelField, ",", "__");
    bfields = this.objConfig.labelField.split(",");
    this.propertyName.push(yfields);
    this.objConfig.labelFieldConcat = this.objConfig.labelField;
    this.objConfig.labelField = yfields;

    new_data = this.dataSet.slice();
    new_value = "";
    lnew_value = "";
    for (i = 0; i < this.dataSet.length; i++) {
      new_value = "";
      lnew_value = "";
      for (j = 0; j < afields.length; j++) {
        idx = this.propertyName.indexOf(afields[j]);
        new_value += this.dataSet[i][idx];
        idx = this.propertyName.indexOf(bfields[j]);
        lnew_value += this.dataSet[i][idx];
      }
      new_data[i].push(new_value);
      new_data[i].push(lnew_value);
    }
    this.dataSet = new_data.slice();
    this._SetFieldsIndexes();
    this._SetCategoryList();
  }
  else {
    kfields = Strtran(this.objConfig.labelField, ",", "__");
    afields = this.objConfig.labelField.split(",");
    this.propertyName.push(kfields);
    this.objConfig.labelFieldConcat = this.objConfig.labelField;
    this.objConfig.labelField = kfields;
    new_data = this.dataSet.slice();
    new_value = "";
    for (i = 0; i < this.dataSet.length; i++) {
      new_value = "";
      for (j = 0; j < afields.length; j++) {
        idx = this.propertyName.indexOf(afields[j]);
        new_value += this.dataSet[i][idx];
      }
      new_data[i].push(new_value);
    }
    this.dataSet = new_data.slice();
    this._SetFieldsIndexes();
    this._SetCategoryList();
  }
}
/*** RIPRESE DA ZTVWEB */
StdChart.prototype.strToDate = function (str, pict) {
  var date = null;
  var p = str.indexOf(' ');  // toglie l' eventuale time
  if (p > -1) {
    str = str.substr(0, p);
  }
  var datearray;
  // divido le varie componenti
  if (str.indexOf('/') > -1 || str.indexOf('-') > -1) {
    if (str.indexOf('/') > -1) {
      datearray = str.split('/');
    }
    if (str.indexOf('-') > -1) {
      datearray = str.split('-');
    }
  } else if (str.length == 6) {
    datearray = [str.substr(0, 2), str.substr(2, 2), str.substr(4, 2)];
  } else if (str.length == 8 && pict != null) {
    if (pict.substr(0, 2) == 'YY') {// l' anno e' davanti
      datearray = [str.substr(0, 4), str.substr(4, 2), str.substr(6, 2)];
    } else {
      datearray = [str.substr(0, 2), str.substr(2, 2), str.substr(4, 4)];
    }
  }
  // se sono riuscito a dividere la data, ora cerco di attribuire il significato corretto
  if (datearray != null && datearray.length == 3) {
    var d0 = datearray[0] - 0;
    var d1 = datearray[1] - 0;
    var d2 = datearray[2] - 0;
    if (!isNaN(d0) && !isNaN(d1) && !isNaN(d2)) {
      if (d0 >= 100) { // anno in testa il formato e' sempre YYYY-MM-DD
        if (d0 < 9999 && d1 > 0 && d1 < 13 && d2 > 0 && d2 < 32) {
          if (LibJavascript.Date.CheckDate(d2, d1, d0 < 100 ? 2000 + d0 : d0)) {
            date = new Date(d0 < 100 ? 2000 + d0 : d0, d1 - 1, d2);
          }
        }
      } else /* l'anno e' sicuramente in coda, dobbiamo capire se in testa ho il mese o il giorno*/ /* if (EmptyString(pict)) { pict=this.defaultDatePict;}*/ if (pict != null && pict.substr(0, 2) == 'DD' || pict == null && d2 <= 9999 && d1 > 0 && d1 < 13 && d0 > 0 && d0 < 32) {
        if (d2 <= 9999 && d1 > 0 && d1 < 13 && d0 > 0 && d0 < 32) {
          if (LibJavascript.Date.CheckDate(d0, d1, d2 < 100 ? 2000 + d2 : d2)) {
            date = new Date(d2 < 100 ? 2000 + d2 : d2, d1 - 1, d0);
          }
        }
      } else if (pict != null && pict.substr(0, 2) == 'MM' || pict == null && d2 <= 9999 && d0 > 0 && d0 < 13 && d1 > 0 && d1 < 32) {
        if (d2 <= 9999 && d0 > 0 && d0 < 13 && d1 > 0 && d1 < 32) {
          if (LibJavascript.Date.CheckDate(d1, d0, d2 < 100 ? 2000 + d2 : d2)) {
            date = new Date(d2 < 100 ? 2000 + d2 : d2, d0 - 1, d1);
          }
        }
      }
    }
  }
  return date;
};
StdChart.prototype.strToDateTime = function (str, pict) {
  // if val is datetime => return date with hh:mm:ss
  // if val is date => return date with 00:00:00
  var date = null;
  var adate = Strtran(str,'T',' ').split(' ');//input html5 mette YYYY-MM-DDTHH:MM:SS
  if (adate.length == 1 && adate[0].length == 14) {
    // return CharToDateTime(adate[0]);//accetta DDMMYYYYHHMMSS
    date = this.strToDate(adate[0].substr(0, 8), pict);
    if (date == null) {
      return str;
    }
    date.setHours(adate[0].substr(8, 2));
    date.setMinutes(adate[0].substr(10, 2));
    date.setSeconds(adate[0].substr(12, 2));
    return date;
  }
  date = this.strToDate(adate[0], pict);
  if (date != null && adate.length > 1) {
    try {
      var atime = adate[1].split(':');
      if (atime.length == 1) {
        return null;
      }// ci devono essere i :
      date.setHours(atime.length < 1 ? 0 : atime[0]);
      date.setMinutes(atime.length < 2 ? 0 : atime[1]);
      date.setSeconds(atime.length < 3 ? 0 : atime[2]);
    } catch (e) {}
  }
  return date;
};
StdChart.prototype.GetWebRootURL = function () {
  if (typeof ZtVWeb == 'undefined')
    return '..';
  if (Empty(this.urlReference)) {
    if (ZtVWeb && ZtVWeb.SPWebRootURL)
      return ZtVWeb.SPWebRootURL;
    return "..";
  }
  return this.urlReference;
}
StdChart.prototype.SetElemExpandCollapse = function (value) {
  this.expcoll = value;
}
/** */
StdChart.prototype.Init = function (opts) {
  /* opts params
    _ZtChart, chartConfig, objConfig, propertyName, propertyValue, parent, functionObj, linkObj
    mychartid, chartContainer, datetimePict, addData, addPName
  */

  /**** parametri costruttore ZtChart ****/
  this.chartConfig = setDefaultChart(opts.chartConfig, this.GetWebRootURL());
  this.objConfig = opts.objConfig;
  this.propertyName = opts.propertyName;
  this.parent = opts.parent;
  this.functionObj = opts.functionObj || {};
  this.linkObj = opts.linkObj;
  if (Empty(opts.mychartid))
    this.chartId = LibJavascript.AlfaKeyGen(5) + '_';
  else
    this.chartId = opts.mychartid + "_";
  this.__cID = this.chartId;
  this.chartContainer = opts.chartContainer;

  myZtCharts[this.chartId] = opts._ZtChart;

  /**** dataset ****/
  
  var pv = JSON.stringify(opts.propertyValue)
  this.dataSet = JSON.parse(pv);
  if (Empty(this.dataSet) || Empty(Object.keys(this.dataSet)))
    this.dataSet = [];
  
  this.SetDomainType(opts.datetimePict, this.dataSet/*opts.propertyValue*/, this._GetDomainIndex());

  /** focusKey **/
  if (this.objConfig && !Empty(this.objConfig.focusKey)) {
    this.focusKey = opts.objConfig.focusKey;
  }

  /**** lingua ****/
  if (Empty(this.localeLangFormat)) {
    this.language = "ita";
    opts._ZtChart.setLanguage(this.language, this);
  }
  this.stdFormat = this.localeLangFormat.timeFormat("%Y-%m-%d %X");
  this.hoverFormat = this.localeLangFormat.timeFormat("%Y%m%d%H%M%S");

  /**** ordine disegno dati ****/
  this._SetInitialDataOrder();

  /**** vettori items per selezione ****/
  this.items = [];
  this.shapes = [];

  /**** titolo e sottotitolo ****/
  this.chartTitle = this.chartConfig.globalSettings.titles[0].text;
  if (!Empty(this.objConfig.title))
    this.chartTitle = this.objConfig.title;
  this.chartSubtitle = this.chartConfig.globalSettings.titles[2].text;

  /**** colori ****/
  this.colorSet = [];

  /**** campi aggiuntivi + campo chiave ****/
  this.additionalFields = this.objConfig.additionalFields;
  this.keyField = {};
  this.SetKeyField(!Empty(this.objConfig.keyField));

  /** gestione IA **/
  this.categoryCodeIndex = -1;
  if (!Empty(this.objConfig.nameField))
    this.categoryCodeIndex = this.propertyName.indexOf(this.objConfig.nameField);

  /**** variabili di lavoro ****/
  this.pxFactor = 0.75;
  this.datetimePict = opts.datetimePict;
  this.rangeminmax = { min: 0, max: 0, precision: 0 };
  this.isOLD = false; // compatibilita'
  this.drawStatic = false;  // animazione
  this.SetOtherCharts();
  this.SetDownloadFormats();
  this.applySPTheme = true;
  this.usedFonts = [];
  this.exportFileName = replaceSpecialCharsForFileName(this.objConfig.exportFileName || "");
  this.animationDelay = 0;
  this.plusDelay = 0;
  this.allTimeouts = [];
  this.multiDimKeepSameScale = this.objConfig.multidimFixedScale;
  this.subdivisionPlotMode = this.objConfig.subdivisionPlotMode;
  this.subdivisionPlotValue = parseInt(this.objConfig.subdivisionPlotValue);
  this.enableTooltips = (this.chartConfig.graphSettings.chartTooltips == "show" || this.chartConfig.graphSettings.chartTooltips == "default");
  this.excludedData = { series: [], categories: [] };
  this.fontLoaded = false;
  this.forPJS = false;
  this.splitSequence = "-___-";
  this.compactChart = this.objConfig.compactChart || "none";
  this.tickUnit = 1.0;
  this._status = "chart";

  /**** scale valori multiple ****/
  this.multipleScales = false;
  this._EvaluateAutomaticScales();
  if (this.objConfig.mapSeries && !this.objConfig.manualScale) {
    var kl = Object.keys(this.objConfig.mapSeries);
    for (var i = 0; i < kl.length && !this.multipleScales; i++) {
      if (this.objConfig.mapSeries[kl[i]].ownerScale)
        this.multipleScales = true;
    }
  }

  /**** dati aggiuntivi ****/
  this.additionalDataset = opts.addData;
  this.additionalPropertyName = opts.addPName;

  if (!Empty(this.objConfig.fieldsGrid) && (typeof this.objConfig.fieldsGrid == "string"))
    this.objConfig.fieldsGrid = this.objConfig.fieldsGrid.split(",");
}
StdChart.prototype.AppendFonts = function () {
  if (this._fontsChecked || this.forPJS)
    return;

  var svgFonts = getAllFontsInSVG(this.chartConfig),
    allFonts = getAllFonts();

  // non uso d3 perche' si tratta di linguaggio html ma punto un oggetto svg defs
  var defs = document.getElementById(this.__cID + "d3ChartDefs");
  if (!Empty(defs)) {
    var link,
      i,
      webroot = this.GetWebRootURL();
    for (i = 0; i < svgFonts.length; i++) {
      if (!Empty(svgFonts[i])) {
        if (allFonts.offline.indexOf(svgFonts[i]) >= 0) {
          link = document.createElement('link');
          link.href = webroot + "/fonts/" + Strtran(svgFonts[i], " ", "") + ".css";
          link.rel = 'stylesheet';
          link.type = 'text/css';
          defs.appendChild(link);
        }
        if (allFonts.online.indexOf(svgFonts[i]) >= 0) {
          link = document.createElement('link');
          link.href = 'https://fonts.googleapis.com/css?family=' + Strtran(svgFonts[i], " ", "+");
          link.rel = 'stylesheet';
          link.type = 'text/css';
          defs.appendChild(link);
        }
      }
    }
  }
  this._fontsChecked = true;

  function getAllFontsInSVG(def) {
    var fonts = [];
    if (def.globalSettings) {
      pushToArray(fonts, def.globalSettings.globalFont, "name");
      for (var i = 0; i < def.globalSettings.titles.length; i++)
        pushToArray(fonts, def.globalSettings.titles[i].textFont, "name");
    }
    if (def.graphSettings) {
      pushToArray(fonts, def.graphSettings.axisLabel.axisFont, "name");
      pushToArray(fonts, def.graphSettings.displayLabel.displayFont, "name");
      pushToArray(fonts, def.graphSettings.domainAxis.domainFont, "name");
      pushToArray(fonts, def.graphSettings.layout.wcFont, "name");
      pushToArray(fonts, def.graphSettings.percentAxis.percentFont, "name");
      pushToArray(fonts, def.graphSettings.tickAxis.tickFont, "name");
      pushToArray(fonts, def.graphSettings.valueAxis.valueFont, "name");
      pushToArray(fonts, def.graphSettings.valueLabel.labelFont, "name");
    }
    return fonts;

    function pushToArray(array, object, prop) {
      var fidx,
        fname;
      if (object && !Empty(object[prop]) && array.indexOf(object[prop]) < 0) {
        fname = object[prop];
        fidx = fname.indexOf(",");
        if (fidx < 0)
          array.push(fname);
        else
          array.push(fname.slice(0, fidx));
      }
    }
  }
}
/*
StdChart.prototype.SetFontsAndLoad = function () {
  var fontLoader = new FontLoader(allFonts, {
                      "complete": function(error) {
                        console.log(error)
                          if (error !== null) {
                              // Reached the timeout but not all fonts were loaded
                          } else {
                              // All fonts were loaded
                             // _this.fontLoaded = true;
                             // _this._AdjustDisplayText();
                          }
                      }
                  }, 500);
  fontLoader.loadFonts();
}
*/
StdChart.prototype.ChangeDataOrder = function () {
  if (this.dataOrder == "column")
    this.dataOrder = "row";
  else
    this.dataOrder = "column";
  this.SetDataDraw();
  this.SetChartLegends();
  this._EvaluateAllValues();
  this._SetScales(this._ZtChart.datetimePict);
  this.SetMargins();
  this.ResetItems();
  this._SetCalculationDataset();
  this.applyFocusKey = true;
}
StdChart.prototype.SetJsonDef = function () {
  this.defSettings = {};
  this.defSettings.chartTitle = this.chartConfig.globalSettings.titles[0];
  this.defSettings.chartTitle.useLegendFont = false;
  this.defSettings.chartTitle.useLegendColors = false;
  this.defSettings.chartLegend = this.chartConfig.globalSettings.titles[1];
  this.defSettings.chartSubtitle = this.chartConfig.globalSettings.titles[2];
  this.defSettings.chartSubtitle.useLegendFont = false;
  this.defSettings.chartSubtitle.useLegendColors = false;
  this.defSettings.chartRangeLegend = this.chartConfig.globalSettings.titles[3];
  this.defSettings.globalFont = this.chartConfig.globalSettings.globalFont;
  this.defSettings.globals = {};
  this.defSettings.globals.width = this.chartConfig.globalSettings.width;
  this.defSettings.globals.height = this.chartConfig.globalSettings.height;
  this.defSettings.globals.transparency = this.chartConfig.globalSettings.transparency;
  this.defSettings.globals.chartColors = this.chartConfig.globalSettings.chartColors;
  this.defSettings.globals.graphColors = this.chartConfig.globalSettings.graphColors;
  // compatibilita' con IA quando passano valori vuoti in dashboard
  var size = 0;
  if (isNaN(this.defSettings.globals.width) || Empty(this.defSettings.globals.width)) {
    if (this.parent) {
      if (this.parent.offsetWidth == 0) {
        if (this.parent.offsetParent)
          size = this.parent.offsetParent.offsetWidth - 2; // bordi
      }
      else
        size = this.parent.offsetWidth - 2; // bordi
    }
    this.defSettings.globals.width = size;
  }
  size = 0;
  if (isNaN(this.defSettings.globals.height) || Empty(this.defSettings.globals.height)) {
    if (this.parent) {
      if (this.parent.offsetHeight == 0) {
        if (this.parent.offsetParent)
          size = this.parent.offsetParent.offsetHeight - 2; // bordi
      }
      else
        size = this.parent.offsetHeight - 2; // bordi
    }
    this.defSettings.globals.height = size;
  }

  // parti specifiche ma comuni
  this.defSettings.animation = {};
  this.defSettings.animation.animate = this.chartConfig.graphSettings.animate;
  this.defSettings.animation.duration = this.chartConfig.graphSettings.durationAnimation;
  if (!this.defSettings.animation.animate)
    this.defSettings.animation.duration = 0;
  this.defSettings.colorSeries = this.chartConfig.graphSettings.colorSeries;
  this.defSettings.reuseColorSeries = this.chartConfig.graphSettings.reuseColorSeries;
  this.defSettings.hoverColor = this.chartConfig.graphSettings.hoverColor;
  this.defSettings.range = {};
  this.defSettings.range.custom = this.chartConfig.graphSettings.range;
  this.defSettings.range.type = this.chartConfig.graphSettings.pointCap.pointer.rangeType;
  this.defSettings.range.gradient = this.chartConfig.graphSettings.pointCap.pointer.rangeGradient;
  this.defSettings.range.applyColor = this.chartConfig.graphSettings.pointCap.pointer.rangeColor;
  this.defSettings.range.default = getDefaultRangeBands();
  if (Empty(this.defSettings.range.type))
    this.defSettings.range.type = "none";
  this.defSettings.time = this.chartConfig.graphSettings.time;
  this.defSettings.normalizeValues = false;
  this.defSettings.valueLabel = this.chartConfig.graphSettings.valueLabel;
  if (this.defSettings.valueLabel.type == "hide")  // retrocompatibilita'
    this.defSettings.valueLabel.show = "hide";
  if (this.defSettings.valueLabel.show == "hide" && this.objConfig.valueLabels == true)
    this.defSettings.valueLabel.show = "default";
  this.defSettings.valueLabel.position = EvaluateValueLabelsPosition(this.defSettings.valueLabel.position);
  this.defSettings.valueLabel.valuePrecision = parseInt(this.chartConfig.graphSettings.valueLabel.valuePrecision);
  this.defSettings.valueLabel.percPrecision = parseInt(this.chartConfig.graphSettings.valueLabel.percPrecision);
  // multidimensional
  this.defSettings.multiDimensional = this.chartConfig.graphSettings.multiDimensional;
  this.defSettings.cursorAxis = {};
  this.defSettings.cursorAxis.show = true;
  this.defSettings.cursorAxis.useGlobalFont = this.chartConfig.graphSettings.multiDimensional.useGlobalFont;
  this.defSettings.cursorAxis.cursorFont = this.chartConfig.globalSettings.globalFont//this.chartConfig.graphSettings.multiDimensional.cursorFont;
  this.defSettings.cursorAxis.cursorLine = this.chartConfig.graphSettings.multiDimensional.axis;

  this.defSettings.valuePicture = this.chartConfig.globalSettings.valuepicture;
  this.defSettings.patterns = this.chartConfig.globalSettings.patterns;
  this.defSettings.useColorSeriesForEach = this.chartConfig.graphSettings.useColorSeriesForEach;
  this.defSettings.selectionOptions = {};
  if (this.chartConfig.graphSettings.selectionOptions.opacity == "default")
    this.defSettings.selectionOptions.opacity = 0.33;
  else if (this.chartConfig.graphSettings.selectionOptions.opacity == "lighter")
    this.defSettings.selectionOptions.opacity = 0.1;
  else
    this.defSettings.selectionOptions.opacity = 1;
  this.defSettings.selectionOptions.color = this.chartConfig.graphSettings.selectionOptions.color;

  this._SetChartSettingsJSON();

  if (!this.defSettings.normalizeValues)  // evito di tenere in memoria i dati
    this.orgData = null;

  function EvaluateValueLabelsPosition(pos) {
    var tpos = "";
    switch (pos) {
      case "top":
      case "bottom":
      case "left":
      case "right":
        tpos = "o" + pos;
        break;
      default:
        tpos = pos;
        break;
    }
    return tpos;
  }
}
StdChart.prototype.SetDomainType = function (datetimePict, dataSet, xIndex) {
  if (this.checkDomain)
    return;
  dataSet = dataSet || this.dataSet;
  xIndex = isNaN(xIndex) ? this.xIndex : xIndex;

  if (Empty(dataSet))
    return;

  if (this.objConfig.domainAsString) {
    this.domainIsTime = false;
    this.domainIsNumber = false;
  }
  else {
    if (IsA(dataSet[0][xIndex], 'N')) {
      this.domainIsTime = false;
      this.domainIsNumber = true;
    }
    else if (IsA(dataSet[0][xIndex], 'D') || IsA(this.strToDateTime(dataSet[0][xIndex] + "", datetimePict), 'D')) {
      this.domainIsTime = true;
      this.domainIsNumber = false;
    }
    else {
      this.domainIsTime = false;
      this.domainIsNumber = false;
    }
  }

  this.checkDomain = true;
}
StdChart.prototype.MapDomainType = function (cmap) {
  this.checkDomain = cmap.checkDomain;
  this.domainIsNumber = cmap.domainIsNumber;
  this.domainIsTime = cmap.domainIsTime;
}
StdChart.prototype.SetChartLegends = function () {
  this.chartLegends = {};

  if (!Empty(this.orgSeriesList))
    this.chartLegends.series = {
      hide: false,
      position: this.defSettings.chartLegend.position,
      obj: this.defSettings.chartLegend
    };

  if (!Empty(this.defSettings.range.bands))
    this.chartLegends.range = {
      hide: false,
      position: this.defSettings.chartRangeLegend.position,
      obj: this.defSettings.chartRangeLegend
    };

  if (this.chartLegends.range) {
    if (!this.chartLegends.series && this.chartLegends.range.position == "default")
      this.chartLegends.range.position = this.defSettings.chartLegend.position;
    else if (this.chartLegends.range.position == "default") {
      if (this.defSettings.chartLegend.position == "top" || this.defSettings.chartLegend.position == "bottom")
        this.chartLegends.range.position = "right";
      else if (this.defSettings.chartLegend.position == "hide")
        this.chartLegends.range.position = "top";
      else
        this.chartLegends.range.position = "bottom";
    }
  }

  if ((this.chartLegends.series && this.chartLegends.series.position == "hide") && (this.chartLegends.range && this.chartLegends.range.position == "hide"))
    return;

  var legSize;
  if (this.chartLegends.series) {
    legSize = getLegendSize(this.chartId, this.legendList, this.defSettings, this.chartLegends.series);
    setHideLegend(this, this.chartLegends.series, legSize, true);
  }

  if (this.chartLegends.range) {
    legSize = getLegendSize(this.chartId, this.defSettings.range.labels, this.defSettings, this.chartLegends.range, this.defSettings.range.gradient, true);
    setHideLegend(this, this.chartLegends.range, legSize, this.defSettings.range.gradient != "none");
  }

  function setHideLegend(_this, mleg, legSize, nograd) {
    var mymeasure = "";
    var mymeasureAlt = "";
    mleg.tooLong = false;
    if (mleg.position == "top" || mleg.position == "bottom") {
      mymeasure = "height";
      mymeasureAlt = "width";
    }
    else {
      mymeasure = "width";
      mymeasureAlt = "height";
    }
    var limit = 0;
    var limitAlt = 0;
    if (Empty(mleg.obj.showLegendButtonWhen) || isNaN(mleg.obj.showLegendButtonWhen)) {
      //metto io default - 35%
      limit = _this.chartConfig.globalSettings[mymeasure] - (0.35 * _this.chartConfig.globalSettings[mymeasure]);
      if (legSize[mymeasure] > limit)
        mleg.hide = true;
    }
    else {
      // il valore a -1 visualizza la legenda sempre
      if (mleg.obj.showLegendButtonWhen == -1) {
      }
      else {
        limit = mleg.obj.showLegendButtonWhen;
        if (mleg.obj.limitUnitPerc) {
          limit = (mleg.obj.showLegendButtonWhen / 100) * _this.chartConfig.globalSettings[mymeasure];
        }
        if (legSize[mymeasure] > limit)
          mleg.hide = true;
      }
    }

    if (!mleg.hide && nograd && mleg.obj.showLegendButtonWhen != -1) {
      limitAlt = _this.chartConfig.globalSettings[mymeasureAlt];
      if (legSize[mymeasureAlt] > limitAlt) {
        mleg.hide = true;
        mleg.tooLong = true;
      }
    }
  }
}
StdChart.prototype.SetMargins = function (datetimePict) {
  this.genLabels = getGeneralMarginsObject(this.chartId, this.defSettings, this.chartLegends, this.chartTitle, this._GetLegendList());
  this.CalculateChartMargins(datetimePict);
  this.CalculateMargins(this.defSettings.globals.width, this.defSettings.globals.height, this.genLabels);
};
StdChart.prototype.CalculateMargins = function (width, height, marginsObj) {
  this.marginOffsetX = width * 0.01;
  this.marginOffsetY = height * 0.01;
  var span = getSpanTag(this.chartId);
  this.margin = {
    top: this.marginOffsetY + getMargin(marginsObj.top, span),
    right: this.marginOffsetX + getMargin(marginsObj.right, span) + (!this.asZoomCursor ? 0 : 8),
    bottom: this.marginOffsetY + getMargin(marginsObj.bottom, span),
    left: this.marginOffsetX + getMargin(marginsObj.left, span) + (!this.asZoomCursor ? 0 : 8)
  };

  this.chartWidth = width - this.margin.left - this.margin.right;
  this.chartHeight = height - this.margin.top - this.margin.bottom;
}
StdChart.prototype.SetData = function () {
  if (Empty(this.dataSet))
    return;

  var i;
  if (Empty(this.columnOrderData) && Empty(this.rowOrderData)) {
    this.columnOrderData = {};
    this.columnOrderData.data = JSON.stringify(this.dataSet);
    this.columnOrderData.valueFields = JSON.stringify(this.valueFields);
    this.columnOrderData.propertyName = JSON.stringify(this.propertyName);
    this.columnOrderData.orgCategoryList = JSON.stringify(this.orgCategoryList);
    this.columnOrderData.categoryList = JSON.stringify(this.categoryList);
    this.columnOrderData.legendList = JSON.stringify(this.legendList);
    this.columnOrderData.rowLegendList = JSON.stringify(this.rowLegendList);
    this.columnOrderData.seriesList = JSON.stringify(this.seriesList);
    this.columnOrderData.orgSeriesList = JSON.stringify(this.orgSeriesList);

    if (this._SupportChangeOrder()) {
      this.rowOrderData = {};
      this.rowOrderData.data = "";
      this.rowOrderData.valueFields = JSON.stringify(this.orgCategoryList);
      this.rowOrderData.propertyName = "";
      this.rowOrderData.orgCategoryList = JSON.stringify(this.orgSeriesList);
      this.rowOrderData.categoryList = JSON.stringify(this.seriesList);
      this.rowOrderData.legendList = JSON.stringify(this.rowLegendList);
      this.rowOrderData.rowLegendList = JSON.stringify(this.legendList);
      this.rowOrderData.seriesList = JSON.stringify(this.categoryList);
      this.rowOrderData.orgSeriesList = JSON.stringify(this.orgCategoryList);

      var tmp = [],
        index = -1,
        ttmp; 
      for (i = 0; i < this.dataSet.length; i++) {
        tmp.push([]);
        for (var j = 0; j < this.valueFields.length; j++) {
          index = this.propertyName.indexOf(this.valueFields[j]);
          if( this.dataSet[i] != null )
          tmp[tmp.length - 1].push(this.dataSet[i][index]);
        }
      }
      ttmp = trasposeMatrix(tmp);

      for (i = 0; i < ttmp.length; i++) {
        ttmp[i].splice(this.propertyName.indexOf(this.objConfig.labelField), 0, this.orgSeriesList[i]);
        if (!Empty(this.objConfig.keyField))
          ttmp[i].splice(this.propertyName.indexOf(this.objConfig.keyField), 0, this.orgSeriesList[i]);
      }
        
      this.rowOrderData.data = JSON.stringify(ttmp);
      this.rowOrderData.propertyName = this.orgCategoryList.slice()
      this.rowOrderData.propertyName.splice(this.propertyName.indexOf(this.objConfig.labelField), 0, this.objConfig.labelField);
      if (!Empty(this.objConfig.keyField))
        this.rowOrderData.propertyName.splice(this.propertyName.indexOf(this.objConfig.keyField), 0, this.objConfig.keyField);
      this.rowOrderData.propertyName = JSON.stringify(this.rowOrderData.propertyName);
      tmp = null;
      ttmp = null;
    }
  }

  if (this.dataOrder == this._GetDefaultDataOrder() || !this._SupportChangeOrder()) {
    this.dataSet = JSON.parse(this.columnOrderData.data);
    this.valueFields = JSON.parse(this.columnOrderData.valueFields);
    this.propertyName = JSON.parse(this.columnOrderData.propertyName);
    if (!Empty(this.columnOrderData.orgCategoryList))
      this.orgCategoryList = JSON.parse(this.columnOrderData.orgCategoryList);
    else
      this.orgCategoryList = [];
    if (!Empty(this.columnOrderData.categoryList))
      this.categoryList = JSON.parse(this.columnOrderData.categoryList);
    else
      this.categoryList = [];
    if (!Empty(this.columnOrderData.legendList))
      this.legendList = JSON.parse(this.columnOrderData.legendList);
    else
      this.legendList = [];
    if (!Empty(this.columnOrderData.rowLegendList))
      this.rowLegendList = JSON.parse(this.columnOrderData.rowLegendList);
    else
      this.rowLegendList = [];
    if (!Empty(this.columnOrderData.seriesList))
      this.seriesList = JSON.parse(this.columnOrderData.seriesList);
    else
      this.seriesList = [];
    if (!Empty(this.columnOrderData.orgSeriesList))
      this.orgSeriesList = JSON.parse(this.columnOrderData.orgSeriesList);
    else
      this.orgSeriesList = [];
  }
  else {
    this.dataSet = JSON.parse(this.rowOrderData.data);
    this.valueFields = JSON.parse(this.rowOrderData.valueFields);
    this.propertyName = JSON.parse(this.rowOrderData.propertyName);
    if (!Empty(this.rowOrderData.orgCategoryList))
      this.orgCategoryList = JSON.parse(this.rowOrderData.orgCategoryList);
    else
      this.orgCategoryList = [];
    if (!Empty(this.rowOrderData.categoryList))
      this.categoryList = JSON.parse(this.rowOrderData.categoryList);
    else
      this.categoryList = [];
    if (!Empty(this.rowOrderData.legendList))
      this.legendList = JSON.parse(this.rowOrderData.legendList);
    else
      this.legendList = [];
    if (!Empty(this.rowOrderData.rowLegendList))
      this.rowLegendList = JSON.parse(this.rowOrderData.rowLegendList);
    else
      this.rowLegendList = [];
    if (!Empty(this.rowOrderData.seriesList))
      this.seriesList = JSON.parse(this.rowOrderData.seriesList);
    else
      this.seriesList = [];
    if (!Empty(this.rowOrderData.orgSeriesList))
      this.orgSeriesList = JSON.parse(this.rowOrderData.orgSeriesList);
    else
      this.orgSeriesList = [];

    this._SetTotalsObject();
  }

  this._SetFieldsIndexes();

  var _this = this,
    record;
  if (this.domainIsTime && (typeof this.dataSet[0][this.xIndex] == "string")) {
    // JSON.stringify ha trasformato la data in stringa ISO
    for (i = 0; i < this.dataSet.length; i++) {
      record = this.dataSet[i];
      record[_this.xIndex] = new Date(Date.parse(record[_this.xIndex]));
    }

    this._SetCategoryList();
  }

  if (this.seriesIsTime && this.seriesIndex >= 0 && (typeof this.dataSet[0][this.seriesIndex] == "string")) {
    // JSON.stringify ha trasformato la data in stringa ISO
    for (i = 0; i < this.dataSet.length; i++) {
      record = this.dataSet[i];
      record[_this.seriesIndex] = new Date(Date.parse(record[_this.seriesIndex]));
    }

    this._SetSeriesList();
  }
}
StdChart.prototype.CheckDataSet = function () {
  var y_index,
    tmpv,
    upd = false;

  for (var j = 0; j < this.valueFields.length; j++) {
    y_index = this.propertyName.indexOf(this.valueFields[j]);
    if (y_index >= 0) {
      for (var i = 0; i < this.dataSet.length; i++) {
        if( this.dataSet[i] == null ) continue;
        if (typeof this.dataSet[i][y_index] != "number" && this.dataSet[i][y_index] !== null) {
          if (this.dataSet[i][y_index].indexOf(".") >= 0) // float
            tmpv = parseFloat(this.dataSet[i][y_index]);
          else
            tmpv = parseInt(this.dataSet[i][y_index]);
          this.dataSet[i][y_index] = tmpv;
        }

        if (!this._EnableNullValues()) {
          if ((isNaN(this.dataSet[i][y_index]) && typeof this.dataSet[i][y_index] == "number") || this.dataSet[i][y_index] === null)
            this.dataSet[i][y_index] = 0;
        }

        this.rangeminmax.precision = Math.max(this.rangeminmax.precision, decimalPlaces(this.dataSet[i][y_index]));

        if (this.domainIsTime) {
          if (!IsA(this.dataSet[i][this.xIndex], 'D')) {
            if (Object.prototype.toString.call(this.dataSet[i][this.xIndex]) !== '[object Date]') {
              this.dataSet[i][this.xIndex] = this.strToDateTime(this.dataSet[i][this.xIndex] + "", this._ZtChart.datetimePict);
              upd = true;
            }
          }
          /*if (this.xLabelIndex && !IsA(this.dataSet[i][this.xLabelIndex], 'D')) {
            if (Object.prototype.toString.call(this.dataSet[i][this.xLabelIndex]) !== '[object Date]') {
              this.dataSet[i][this.xLabelIndex] = this.strToDateTime(this.dataSet[i][this.xLabelIndex] + "", this._ZtChart.datetimePict);
              upd = true;
            }
          }*/
        }
        else if (this.domainIsNumber) {
          if (typeof this.dataSet[i][this.xIndex] != "number" && this.dataSet[i][this.xIndex] !== null) {
            if (this.dataSet[i][this.xIndex].indexOf(".") >= 0) // float
              tmpv = parseFloat(this.dataSet[i][this.xIndex]);
            else
              tmpv = parseInt(this.dataSet[i][this.xIndex]);
            this.dataSet[i][this.xIndex] = tmpv;
            upd = true;
          }

          if ((isNaN(this.dataSet[i][this.xIndex]) && typeof this.dataSet[i][this.xIndex] == "number") || this.dataSet[i][this.xIndex] === null) {
            this.dataSet[i][this.xIndex] = 0;
            upd = true;
          }
        }
      }
    }
  }

  if (upd)
    this._SetCategoryList();
}
StdChart.prototype.SetKeyField = function (hasKF) {
  if (!hasKF) {
    this.keyField.series = false;
    this.keyField.domain = false;
    return;
  }

  if (this.dataOrder == this._GetDefaultDataOrder()) {
    this.keyField.series = false;
    this.keyField.domain = true;
  }
  else {
    this.keyField.series = true;
    this.keyField.domain = false;
  }
}
StdChart.prototype.ResetAllTimeouts = function () {
  if (!Empty(this.allTimeouts)) {
    for (var i = 0; i < this.allTimeouts.length; i++) {
      if (this.allTimeouts[i])
        clearTimeout(this.allTimeouts[i]);
    }
    this.allTimeouts = [];
  }
}
StdChart.prototype.DrawValueAxis = function (axisContainer, scaleY, scaleKey/*, draw*/) {
  var position = this._GetValueAxisPosition().charAt(0).toUpperCase() + this._GetValueAxisPosition().slice(1),
    xPos = this._GetValueAxisXPosition(scaleKey),
    yPos = this._GetValueAxisYPosition(),
    appFont = appliedFont(this.defSettings, this.defSettings.valueAxis, this.defSettings.valueAxis.valueFont),
    vRange = this._GetValueAxisMinMax(scaleKey),
    evRange;

  if (vRange.min == vRange.max) {
    if (isNumberFloat(vRange.min)) {
      vRange.min -= 0.1;
      vRange.max += 0.1;
    }
    else {
      vRange.min -= 1;
      vRange.max += 1;
    }
  }

  evRange = this._SetValueScaleParameters(scaleKey, scaleY, vRange.min, vRange.max);
  if (!Empty(evRange))
    vRange = evRange;
  var yAxis = d3["axis" + position](scaleY);

  var precision = 0,
    hasTickUnit = false;
  if (!isNaN(this.defSettings.valueAxis.tick) && !Empty(this.defSettings.valueAxis.tick) && this.defSettings.valueAxis.tick > 0) {
    if (isNumberFloat(this.defSettings.valueAxis.tick))
      precision = decimalPlaces(this.defSettings.valueAxis.tick);
    hasTickUnit = true;
  }
  else {
    precision = this.rangeminmax.precision;
  }

  if (!((Empty(this.defSettings.valueAxis.precision) || isNaN(this.defSettings.valueAxis.precision)) && this.defSettings.valueAxis.precision != 0)) {
    precision = this.defSettings.valueAxis.precision;
  }

  if (precision < 0)
    precision = 0;
  else if (precision > 20)
    precision = 20;

  var fmt = null;
  if (this.defSettings.normalizeValues) {
    yAxis.tickFormat(this.localeLangFormat.numberFormat(".0%"));
    fmt = d3.format(".0%");
  }
  else {
    yAxis.tickFormat(this.localeLangFormat.numberFormat(",." + precision + "f"));
    fmt = d3.format(",." + precision + "f");
  }

  yAxis.tickSizeOuter(0); // estremi asse
  // gridline
  /*if (this.defSettings.valueAxis.valueGrid.line) {
    var hasOwnAxis = false;
    if (this.objConfig.mapSeries && this.objConfig.mapSeries[scaleKey])
      hasOwnAxis = this.objConfig.mapSeries[scaleKey].ownerScale;
    if (!this.multipleScales || !hasOwnAxis) {
      //console.log("### TICKS", scaleKey, scaleY.__noDraw, -(this.chartWidth + 2 * 6))
      var tickOffset = 6;
      if (this.isH)
        yAxis.tickSizeInner(-(this.chartHeight + 2 * tickOffset));
      else
        yAxis.tickSizeInner(-(this.chartWidth + 2 * tickOffset));
    }
  }
  */

  if (hasTickUnit) {
    // calcolo i tick in base alla t.u.
    var min,
      max;
    if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue))
      min = vRange.min;
    else {
      min = Math.floor(Math.abs(vRange.min) / this.defSettings.valueAxis.tick) * this.defSettings.valueAxis.tick;
      if (vRange.min < 0) // ripristino il segno
        min = min * -1;
    }

    if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue))
      max = vRange.max;
    else
      max = Math.ceil(Math.abs(vRange.max) / this.defSettings.valueAxis.tick) * this.defSettings.valueAxis.tick;

    // ripristino la scala
    var minpos = 0,
      maxpos = 1,
      d = [];
    if (scaleY.domain()[0] > scaleY.domain()[1]) {
      minpos = 1;
      maxpos = 0;
    }
    d[minpos] = min;
    d[maxpos] = max;
    scaleY.domain(d);

    yAxis.tickValues(setTicks(min, max, this.defSettings.valueAxis.tick, precision));
  }
  else {
    // imposto il numero di ticks anche in funzione del font applicato
    var tLen = scaleY.ticks().length,
      sizeH = getOffsetHeight("W", appFont, this.chartId);
    if (this._GetValueAxisPosition() != "left") {
      var tks = scaleY.ticks().map(fmt);
      sizeH = getOffsetWidth(getMaxWordLengthString(tks), appFont, this.chartId);
    }
    var range = d3.max(scaleY.range()) - d3.min(scaleY.range()),
      howMany = Math.floor(range / sizeH);
    if (howMany < tLen) {
      if (howMany <= 1)
        yAxis.ticks(1);
      else
        yAxis.ticks(howMany / 2);
    }
    else {
      // check precision sui ticks di default in modo da evitare valori ripetuti eg. 0 1 1 2 2...
      if (precision == 0) {
        var ttks = scaleY.ticks().slice(),
          norm_ttks = [];
        for (var i = 0; i < ttks.length; i++) {
          if (!isNumberFloat(ttks[i]) || (decimalPlaces(ttks[i]) <= precision))
            norm_ttks.push(ttks[i]);
        }
        if (!Empty(norm_ttks))
          yAxis.tickValues(norm_ttks);
      }
    }
  }

  var idscaleKey = replaceSpecialCharsForID(scaleKey);
  if (!scaleY.__noDraw && !d3.select("#" + this.chartId + "valueAxisGroup_" + idscaleKey).node()) {
    axisContainer.append("g")
      .attr("id", this.chartId + "valueAxisGroup_" + idscaleKey)
      .attr("transform", "translate(" + [xPos, yPos] + ")")
      .attr("data-scale", scaleKey)
      .call(yAxis);

    d3.select("#" + this.chartId + "valueAxisGroup_" + idscaleKey).selectAll("text").attr("class", "valueAxLabel");
    d3.select("#" + this.chartId + "valueAxisGroup_" + idscaleKey).select("path").attr("class", "valueAx TRANSP");
  }
}
StdChart.prototype.DrawPercentAxis = function (axisContainer, scaleKey) {
  var position = this._GetPercentAxisPosition().charAt(0).toUpperCase() + this._GetPercentAxisPosition().slice(1),
    xPos = this._GetPercentAxisXPosition(),
    yPos = this._GetPercentAxisYPosition(),
    vRange = this._GetPercentAxisMinMax(),
    evRange;
  if (vRange.min == vRange.max) {
    if (isNumberFloat(vRange.min)) {
      vRange.min -= 0.1;
      vRange.max += 0.1;
    }
    else {
      vRange.min -= 1;
      vRange.max += 1;
    }
  }
  evRange = this._SetPercentScaleParameters(vRange.min, vRange.max, scaleKey);
  if (!Empty(evRange))
    vRange = evRange;

  var yAxis = d3["axis" + position](this.scalePerc);

  yAxis.tickFormat(this.localeLangFormat.numberFormat(".0%")).ticks(10);

  var idscaleKey = replaceSpecialCharsForID(scaleKey);
  if (!d3.select("#" + this.chartId + "percentAxisGroup_" + idscaleKey).node()) {
    axisContainer.append("g")
      .attr("id", this.chartId + "percentAxisGroup_" + idscaleKey)
      .attr("transform", "translate(" + [xPos, yPos] + ")")
      .call(yAxis);

    d3.select("#" + this.chartId + "percentAxisGroup_" + idscaleKey).selectAll("text")
      .attr("class", "percentAxLabel");

    d3.select("#" + this.chartId + "percentAxisGroup_" + idscaleKey).select("path")
      .attr("class", "percentAx TRANSP");
  }
}
StdChart.prototype.DrawAndEvaluateDomainAxis = function () {
  this.DrawDomainAxis();
  this.SetAxisFont("domain");

  if (!this.defSettings.domainAxis.show)
    return;

  var maxWordObj = this._GetMaxDomainAxisWordObject(),
    daxis = this.svg.select("#" + this.chartId + "domainAxisGroup"),
    gbb,
    meval = (this._GetDomainAxisPosition() == "bottom") ? "height" : "width",
    wrap,
    appFont = appliedFont(this.defSettings, this.defSettings.domainAxis, this.defSettings.domainAxis.domainFont),
    _this = this,
    nlines = 1,
    lastText = "",
    blank = false;

  daxis.selectAll("text")
    .attr("class", "domainAxLabel")
    .each(function () {
      var tt = this.textContent,
        ctick_i = parseFloat(this.parentNode.className.baseVal.replace("tick _", "")) + 1,
        textSplit = maxWordObj.obj ? maxWordObj.obj["_" + (ctick_i - 1)] : null;
      if (_this.domainIsTime)
        textSplit = null;
      if (_this.keyField.domain && !_this.domainIsNumber)
        tt = _this.categoryList[_this.orgCategoryList.indexOf(this.textContent)];
      if (Empty(tt))  // potrebbe essere null o undef
        tt = this.textContent;
      if (_this.forPJS || _this.defSettings.domainAxis.labelType != "H" || _this.domainIsNumber || _this.isH || _this.domainIsTime) {
        this.textContent = tt;
        return;
      }
      if (_this.domainIsTime && lastText == tt) {
        this.textContent = "";
        blank = true;
      }
      else {
        var bandwidth = _this._EvaluateWrapSpace(this, ctick_i, maxWordObj),
          cobj = {};
        cobj.text = tt;
        cobj.textSplit = textSplit;
        cobj.width = bandwidth;
        cobj.nlines = nlines;
        cobj.font = appFont;
        cobj.chartId = _this.chartId;
        cobj.keyapplied = _this.keyField.domain;
        cobj.keyText = _this.orgCategoryList.indexOf(this.textContent);
        cobj.axisPos = _this._GetDomainAxisPosition();
        cobj.separator = /\s+/;
        cobj.cjoin = " ";
        if (_this.domainIsTime) {
          var format = _this.defSettings.time.format;
          if (!Empty(_this.defSettings.time.customFormat))
            format = _this.defSettings.time.customFormat;
          var tsep = getTimeFormatSeparator(format);
          cobj.separator = tsep.separator;
          cobj.cjoin = tsep.cjoin;
        }

        var wrapobj = wrapspace(this, cobj);
        nlines = wrapobj.lines;
        if (wrapobj.wrap && !_this.wrapLabelAxis)
          _this.wrapLabelAxis = true;
        if (wrapobj.underwrap && !_this.wrapLabelUnder)
          _this.wrapLabelUnder = true;

        if (_this._GetDomainAxisPosition() == "left") { // alzo la y e centro il testo
          var mh = getOffsetHeight(tt, appFont, _this.chartId),
            tspan = d3.select(this).selectAll("tspan")._groups[0],
            my = Math.round(tspan.length / 2) * mh;
          if (tspan.length > 1) {
            for (var i = 0; i < tspan.length; i++)
              d3.select(tspan[i]).attr("y", parseFloat(d3.select(tspan[i]).attr("y")) - my);
          }
        }
      }
      lastText = tt;
      if (nlines === Infinity)
        nlines = 1;
    })
    .style("cursor", "default")
    .style("-ms-user-select", "none")
    .style("-webkit-user-select", "none")
    .style("-moz-user-select", "none");

  this._SetAxisLabelOrientation("domain", this.defSettings.domainAxis.labelType);
  gbb = daxis.node().getBBox();
  wrap = gbb[meval];

  if (this.wrapLabelUnder && nlines > 1 && !blank && this._GetDomainAxisPosition() != "left") {  // pettine - ne basta uno per attivare l'automatismo
    nlines++;
    var mgrp = daxis.selectAll(".tick")._groups[0],
      grp,
      y;

    for (var i = 0; i < mgrp.length; i = i + nlines) { // alternati
      grp = d3.select(mgrp[i]);
      y = parseFloat(grp.select("text").attr("y"));
      for (var j = 0; j < nlines; j++) { // in giu'
        grp = d3.select(mgrp[i + j]);
        if (!Empty(grp.node())) {
          if (!Empty(grp.select("text").text())) {
            var factor = wrap * j;
            grp.select("text").attr("y", y + factor);
            grp.selectAll("tspan").attr("y", y + factor);
            grp.select("line").attr("y2", parseFloat(grp.select("line").attr("y2")) + factor);
          }
        }
      }
    }

    gbb = daxis.node().getBBox();
    wrap = gbb[meval];
  }

  if (this.wrapLabelAxis || this.wrapLabelUnder) {
    var bmarg, oldMargin;
    // se wrap, aumento margine e diminuisco altezza/larghezza grafico
    if (this._GetDomainAxisPosition() == "bottom") {
      // valutazione orientamento etichette
      bmarg = this.genLabels.bottom.filter(function (o) { return o.type != "domainAxis"; });
      oldMargin = this.margin.bottom;
      this.margin.bottom = this.marginOffsetY + getMargin(bmarg, getSpanTag(this.chartId)) + wrap;
      this.chartHeight = this.chartHeight + oldMargin - this.margin.bottom;
    }
    else {
      // valutazione orientamento etichette
      bmarg = this.genLabels.left.filter(function (o) { return o.type != "domainAxis"; });
      oldMargin = this.margin.left;
      this.margin.left = this.marginOffsetX + getMargin(bmarg, getSpanTag(this.chartId)) + wrap;
      this.chartWidth = this.chartWidth + oldMargin - this.margin.left;
    }
    daxis.attr("transform", "translate(" + [this._GetDomainAxisXPosition(), this._GetDomainAxisYPosition()] + ")");
  }

  this._AdjustMaskAndRendererPositioning();
}
StdChart.prototype.DrawDomainAxis = function (id, scale, pos) {
  var position = pos || (this._GetDomainAxisPosition().charAt(0).toUpperCase() + this._GetDomainAxisPosition().slice(1)),
    xPos = this._GetDomainAxisXPosition(),
    yPos = this._GetDomainAxisYPosition(),
    xAxis,
    appFont = appliedFont(this.defSettings, this.defSettings.domainAxis, this.defSettings.domainAxis.domainFont),
    dupd = false,
    ticks,
    _this = this,
    dRange = undefined,
    offsetR,
    fixed = false;

  id = id || "";
  scale = scale || this.scaleX;

  this._SetDomainScaleParameters(scale, position);
  xAxis = d3["axis" + position](scale);

  if (!this.defSettings.domainAxis.noRound && this._CalculateOffsetAxis() && (this.domainIsNumber || this.domainIsTime)) {
    dRange = this._GetDomainAxisMinMax();
    fixed = (dRange.fixed.min && dRange.fixed.max);
    if (!fixed) {
      offsetR = dRange.offsetRadius + 5;  // offset dell'hover

      if (dRange.min == dRange.max && dRange.min != 0) {
        dRange.min = dRange.min - dRange.min * 0.1;
        dRange.max = dRange.max + dRange.max * 0.1;
      }
      else if (dRange.min == dRange.max) {
        dRange.min = dRange.min - 1;
        dRange.max = 1;
      }
    }

    this.scaleX.domain([dRange.min, dRange.max]);

    if (this.domainIsTime) {
      offsetR = this.scaleX.invert(offsetR).getTime();  // data

      var oneDay = 24 * 60 * 60 * 1000, // hours*minutes*seconds*milliseconds
        diffDays = Math.round(Math.abs((dRange.min.getTime() - offsetR) / oneDay)) * 2;

      dRange.min = new Date(dRange.min.getTime() - (oneDay * diffDays));
      dRange.min = new Date(dRange.min.getFullYear(), dRange.min.getMonth(), 1);
      dRange.max = new Date(dRange.max.getTime() + (oneDay * diffDays));
      dRange.max = new Date(dRange.max.getFullYear(), dRange.max.getMonth() + 1, 0);

      this.scaleX.domain([dRange.min, dRange.max]);
      dupd = true;
    }
    else {
      var precision = this._GetDomainPrecision(),
        hasTickUnit = false;
      if (!isNaN(this.defSettings.domainAxis.tick) && !Empty(this.defSettings.domainAxis.tick) && this.defSettings.domainAxis.tick > 0) {
        if (isNumberFloat(this.defSettings.domainAxis.tick))
          precision = decimalPlaces(this.defSettings.domainAxis.tick);
        hasTickUnit = true;
      }

      offsetR = Math.abs(this.scaleX.invert(offsetR));
      if (!fixed && !dRange.fixed.min) {
        dRange.min = parseFloat((dRange.min - offsetR).toFixed(precision));
        if (Empty(dRange.min))
          dRange.min = Math.abs(dRange.min);
      }
      if (!fixed && !dRange.fixed.max)
        dRange.max = parseFloat((dRange.max + offsetR).toFixed(precision));

      this.scaleX.domain([dRange.min, dRange.max]);

      this._SelectAutoTickUnit(null, dRange.min, dRange.max, appFont, true);
      xAxis.tickFormat(this.localeLangFormat.numberFormat(",." + precision + "f"));
    }
  }

  if (this.domainIsTime) {
    if (Empty(this.defSettings.time.customFormat) && !Empty(this.defSettings.time.format))
      xAxis.tickFormat(getTimeTickFormat(this.localeLangFormat, this.defSettings.time.format));
    else if (!Empty(this.defSettings.time.customFormat))
      xAxis.tickFormat(getTimeTickFormat(this.localeLangFormat, this.defSettings.time.customFormat));
    else
      xAxis.tickFormat(multiFormat);

    if (!dupd) {
      var start = this.scaleX.domain()[0],
        end = this.scaleX.domain()[1];

      this.scaleX.domain([start, end]);
    }

    // usata solo nei contatori - imposta una data-ora di inizio sull'asse x (come se fosse un minValue)
    if (!Empty(this.defSettings.time.startDatetime)) {
      var dti = new Date(Date.parse(this.defSettings.time.startDatetime));
      end = this.scaleX.domain()[1];
      if (dti) {
        this.scaleX.domain([dti, end]);
      }
    }

    start = this.scaleX.domain()[0];
    end = this.scaleX.domain()[1];
    ticks = this.scaleX.ticks();
    var dList = this._GetOppositeAxisDrawingList().sort(function (a, b) { return a - b; }),
      cobj = calcTimeOffset(dList);

    this.tickTime = { default: { unit: cobj.unit, step: cobj.step } };
    this.tickTime.applied = this.tickTime.default;

    var d3Time;
    if (!Empty(this.defSettings.time.maxTickCount) && !isNaN(this.defSettings.time.maxTickCount)) {
      var mtc = this.defSettings.time.maxTickCount;
      if (mtc <= 0)
        mtc = 3;
      var tmpt = d3.ticks(start.getTime(), end.getTime(), mtc);
      if (tmpt.length != mtc) {
        // calcolo io
        var ost = calcTimeOffsetBtw2Date(start, end),
          mul = numRoundTo(ost.step / mtc, 5);
        if (mul == 0) {
          if (ost.step == 1)
            ost = getTimingDivisor(ost.unit);
          else
            ost.step = 1;
        }
        var tmpcalc = setTimeTicks(start.getTime(), end.getTime(), ost.unit, ost.step);
        if (tmpcalc.length > tmpt.length)
          tmpt = tmpcalc.slice();
      }
      var tmpd = tmpt.map(function (date) { return new Date(date); });
      if (tmpd.length > 1) {
        xAxis.tickValues(tmpd);
        tobj = calcTimeOffsetBtw2Date(tmpd[0], tmpd[1]);
        this.tickTime.applied = { unit: tobj.unit, step: tobj.step };
      }
    }
    else if (!Empty(this.defSettings.time.value) && !isNaN(this.defSettings.time.value)) {
      cobj.unit = this.defSettings.time.unit;
      cobj.step = this.defSettings.time.value;
      d3Time = getD3TimeObject(cobj.unit);
      xAxis.tickValues(d3Time.range(start, end, cobj.step));
      this.tickTime.applied = { unit: cobj.unit, step: cobj.step };
    }
    else {
      if (ticks.length > 1) {
        var tobj = calcTimeOffsetBtw2Date(ticks[0], ticks[1]);
        this.tickTime.applied = { unit: tobj.unit, step: tobj.step };
      }
    }

    if (this._HasShapes()) {  // con le shape metto un offset in modo che l'ultima e la prima siano comprese nell'intervallo
      this.scaleX.domain([
        this.scaleX.invert(this.scaleX(d3.min(this.scaleX.domain())) - this.GetShapesRadius()),
        this.scaleX.invert(this.scaleX(d3.max(this.scaleX.domain())) + this.GetShapesRadius())
      ]);
    }

    //qui
    if (this.objConfig.appendingData) {
      d3Time = getD3TimeObject(this.tickTime.applied.unit);
      this.scaleX.domain([d3Time.offset(start, this.tickTime.applied.step), end]);
      if (this.chartBrush && this.chartBrush.obj) {
        this.chartBrush.dAxis = xAxis;
        this.chartBrush.idAxis = this.chartId + "domainAxisGroup" + id;
      }
    }
  }
  else if (this.domainIsNumber && this._CalculateOffsetAxis()) {
    if (typeof dRange == "undefined")
      dRange = this._GetDomainAxisMinMax();
    if (hasTickUnit) {
      // calcolo i tick in base alla t.u.
      var min,
        max;
      if ((!Empty(this.defSettings.domainAxis.minValue) || parseInt(this.defSettings.domainAxis.minValue) == 0) && !isNaN(this.defSettings.domainAxis.minValue))
        min = dRange.min;
      else {
        min = Math.floor(Math.abs(dRange.min) / this.defSettings.domainAxis.tick) * this.defSettings.domainAxis.tick;
        if (dRange.min < 0) // ripristino il segno
          min = min * -1;
      }

      if ((!Empty(this.defSettings.domainAxis.maxValue) || parseInt(this.defSettings.domainAxis.maxValue) == 0) && !isNaN(this.defSettings.domainAxis.maxValue))
        max = dRange.max;
      else
        max = Math.ceil(Math.abs(dRange.max) / this.defSettings.domainAxis.tick) * this.defSettings.domainAxis.tick;

      // ripristino la scala
      var minpos = 0,
        maxpos = 1,
        d = [];
      if (this.scaleX.domain()[0] > this.scaleX.domain()[1]) {
        minpos = 1;
        maxpos = 0;
      }
      d[minpos] = min;
      d[maxpos] = max;
      this.scaleX.domain(d);
      xAxis.tickValues(setTicks(min, max, this.defSettings.domainAxis.tick, precision));
    }
    else {
      ticks = this.scaleX.ticks();
      this.tickUnitApplied = ticks[1] - ticks[0];
      if (this.tickUnitApplied != this.tickUnit) {
        var tiunit = Math.max(this.tickUnit, this.tickUnitApplied),
          m_max = Math.max(d3.max(this.allValuesX), dRange.max);
        ticks = setTicks(dRange.min, m_max, tiunit, precision);
        this.tickUnitApplied = this.tickUnit = tiunit;
        this.scaleX.domain([ticks[0], ticks[ticks.length - 1] + this.tickUnitApplied]);
        xAxis.tickValues(ticks)
      }
    }
  }

  this._GetBarWidthFromDomainEvaluation();

  if ((this.domainIsTime || this.domainIsNumber) && this._HasShapes() && !fixed) {
    // con le shape metto un offset in modo che l'ultima e la prima siano comprese nell'intervallo
    this.scaleX.domain([
      this.scaleX.invert(this.scaleX(d3.min(this.scaleX.domain())) - this.GetShapesRadius()),
      this.scaleX.invert(this.scaleX(d3.max(this.scaleX.domain())) + this.GetShapesRadius())
    ]);
  }

  this.svg.append("g")
    .attr("id", this.chartId + "domainAxisGroup" + id)
    .attr("transform", "translate(" + [xPos, yPos] + ")")
    .call(xAxis);

  var gTicks = this.svg.select("#" + this.chartId + "domainAxisGroup" + id).selectAll("g");
  gTicks.attr("class", function (d, idx) {
    return this.className.baseVal + " _" + idx;
  });

  var g,
    tit,
    tic;
  for (var i = 0; i < gTicks._groups[0].length; i++) {
    g = gTicks._groups[0][i];
    tit = gTicks._groups[0][i].lastChild;
    tic = gTicks._groups[0][i].firstChild;
    g.insertBefore(tit, tic);
  }

  this.svg.select("#" + this.chartId + "domainAxisGroup" + id).select("path")
    .attr("class", "domainAx TRANSP");

  function multiFormat(date) {
    return (d3.timeSecond(date) < date ? _this.localeLangFormat.timeFormat(".%L")
      : d3.timeMinute(date) < date ? _this.localeLangFormat.timeFormat(":%S")
        : d3.timeHour(date) < date ? _this.localeLangFormat.timeFormat("%I:%M")
          : d3.timeDay(date) < date ? _this.localeLangFormat.timeFormat("%I %p")
            : d3.timeMonth(date) < date ? (d3.timeWeek(date) < date ? _this.localeLangFormat.timeFormat("%a %d") : _this.localeLangFormat.timeFormat("%b %d"))
              : d3.timeYear(date) < date ? _this.localeLangFormat.timeFormat("%B")
                : _this.localeLangFormat.timeFormat("%Y"))(date);
  }
}
StdChart.prototype.DrawAxisLabel = function (type, position, xInit, yInit, text) {
  if (Empty(text))
    return;
  var id = this.chartId + type + "AxisLabel",
    offset = 5,
    x,
    y,
    font = appliedFont(this.defSettings, this.defSettings.axisLabel, this.defSettings.axisLabel.axisFont);

  if (position == "top" || position == 'bottom') {
    x = xInit - (getOffsetWidth(text, font, this.chartId) / 2);
    y = yInit + getOffsetHeight(text, font, this.chartId) + (offset / 2);
    this.svg.append("text")
      .attr("id", id)
      .attr("x", x)
      .attr("y", y)
      .text(text);
  }
  else if (position == 'right') {
    x = xInit + (getOffsetWidth(text, font, this.chartId) / 2);
    y = yInit + getOffsetHeight(text, font, this.chartId);
    this.svg.append("text")
      .attr("id", id)
      .attr("x", -x)
      .attr("y", y)
      .attr("transform", "rotate(-90)")
      .text(text);
  }
  else {
    x = xInit + (getOffsetWidth(text, font, this.chartId) / 2);
    y = getOffsetHeight(text, font, this.chartId);
    this.svg.append("text")
      .attr("id", id)
      .attr("x", -x)
      .attr("y", y)
      .attr("transform", "rotate(-90)")
      .text(text);
  }
}
StdChart.prototype.GetData = function (key) {
  var data = [];
  if (this.dataSet[key])
    data = this.dataSet[key].slice();
  else if (this.functionObj.GetData) {
    data = this.functionObj.GetData(key);
    if (data)
      this.dataSet[key] = data;
  }
  return data;
}
StdChart.prototype.CreateSVG = function (id, parent, isParentSVG, svgleft, svgtop, svgwidth, svgheight, mask, maskwidth, maskheight, maskx, masky) {
  if (Empty(d3.select("#" + id + "d3ChartPlot").node())) {
    if (isParentSVG) {
      /*if(!this.asZoomCursor) {
        var divv = d3.select(parent).insert("div", ":first-child")
        .attr("id", id + "divchartcontainer")
      }
      else {
        var divv = d3.select(parent).append("div")
          .attr("id", id + "divchartcontainer")
      }*/
      var wWidth = 0, wHeight = 0;
      var divv;
      if( this._ZtChart._vpvPivotUI && this._ZtChart._vpvPivotUI._initOpts.uiDragDrop) {
        if( this._ZtChart.parentCtrl.ztVPivotUI == null ) {
          if (d3.select("#" + id + "divPivot").node()) {
            d3.select("#" + id + "divPivot").remove();
          }
        }
        if( !document.getElementById(id + "divPivot") ) {
          var divb = d3.select(parent).append("div")
          .attr("id", id + "divPivot")
         .attr("class", "drillboxer");
          divb = divb._groups[0][0];
          this._ZtChart.parentCtrl.ztVPivotUI = new ZtVPivotUI(this._ZtChart._vpvPivotUI._initOpts, this._ZtChart._vpvPivotUI.opts, 
            divb, this._ZtChart.parentCtrl, this._ZtChart._vpvPivotUI._wKey);
          parent = this._ZtChart.parentCtrl.ztVPivotUI.draw();
          parent.classList.add('drillbox')
          parent.classList.add('inner')
          wWidth =  document.getElementById(id + "divPivot").getElementsByClassName('rows')[0].offsetWidth;
          wHeight = document.getElementById(id + "divPivot").offsetHeight;
          this._ZtChart.parentCtrl.vpvUIWidth = wWidth;
          this._ZtChart.parentCtrl.vpvUIHeight = wHeight;
          this._ZtChart.parentCtrl.ShowHideFields();
        }
        else {
          var divInner = document.getElementById(id + "divPivot").getElementsByClassName('inner');
          parent = divInner[0];
          this._ZtChart.parentCtrl.ztVPivotUI.setEvents();
        }

        divv = d3.select(parent).append("div")
        .attr("id", id + "divchartcontainer");
      }
      else {
        if (d3.select("#" + id + "divPivot").node()) {
          d3.select("#" + id + "divPivot").remove();
        }
        divv = d3.select(parent).append("div")
        .attr("id", id + "divchartcontainer");
      }

      this.svg = divv.append("svg")
        .attr("id", id + "d3ChartPlot")
        .attr("transform", "translate(" + [svgleft, svgtop] + ")");
      if (this.compactChart == "right")
        this.svg.attr("transform", "translate(" + (divv.node().offsetWidth - svgwidth) + ",0)");
    }
    else {
      this.svg = parent.append("svg")
        .attr("id", id + "d3ChartPlot")
        .attr("x", svgleft)
        .attr("y", svgtop);
    }

    if (IsIE() || this.objConfig.scrollView || !isParentSVG || this.compactChart != "none") {
      //if(this._ZtChart.parentCtrl.vpvDivTabs) svgheight -= this._ZtChart.parentCtrl.vpvDivTabsHeight;
      this.svg
        .attr("width", svgwidth + "px")
        .attr("height", svgheight + "px");
    }
    else if ( isParentSVG && this._ZtChart.parentCtrl && (this._ZtChart.parentCtrl.ztVPivotUI) ){
      var _svgwidth = svgwidth - this._ZtChart.parentCtrl.vpvUIWidth;
      var _svgheight = svgheight - this._ZtChart.parentCtrl.vpvUIHeight;
      if(this._ZtChart.parentCtrl.vpvDivTabs) _svgheight -= this._ZtChart.parentCtrl.vpvDivTabsHeight;
      this.svg
      .attr("width", _svgwidth +'px')
      .attr("height", _svgheight+'px')
      .attr("viewBox", "0 0 " + svgwidth + " " + svgheight)
      .attr("preserveAspectRatio", "xMinYMax");
    }
    /*else if(isParentSVG && this._ZtChart.parentCtrl.vpvDivTabs) {
      svgheight -= this._ZtChart.parentCtrl.vpvDivTabsHeight;
      this.svg
        .attr("width", "100%")
        .attr("height", "100%")
        .attr("viewBox", "0 0 " + svgwidth + " " + svgheight)
        .attr("preserveAspectRatio", "xMinYMax");
    }*/
    else {
      this.svg
        .attr("width", "100%")
        .attr("height", "100%")
        .attr("viewBox", "0 0 " + svgwidth + " " + svgheight)
        .attr("preserveAspectRatio", "xMinYMax");
    }

    if (mask) {
      this.svg.append("defs").append("mask")
        .attr("id", id + "mask")
        .attr("width", maskwidth)
        .attr("height", maskheight)
        .attr("x", 0)
        .attr("y", 0)
        .append("rect")
        //.attr("id", id + "rectmask")
        .attr("width", maskwidth + 1)
        .attr("height", maskheight + 1)
        .attr("x", maskx)
        .attr("y", masky)
        .attr("style", "fill:#FFFFFF;");
    }

    this.svg.append("rect")
      .attr("id", id + "d3ChartPlotRect")
      .attr("width", svgwidth + "px")
      .attr("height", svgheight + "px");
  }
}
StdChart.prototype.CreateRenderer = function (svg, id, chartwidth, chartheight, chartx, charty) {
  this.renderer = svg.append("g")
    .attr("id", id + "d3Renderer");

  if (!Empty(d3.select("#" + id + "mask").node()))
    this.renderer.attr("mask", "url(#" + id + "mask)");

  this.renderer.append("defs")
    .attr("id", this.__cID + "d3ChartDefs");

  this.AppendFonts();

  this.renderer.append("rect")
    .attr("id", id + "d3ChartRenderer")
    .attr("width", chartwidth - 1)
    .attr("height", chartheight - 1)
    .attr("x", chartx + 1)
    .attr("y", charty + 1);
}
StdChart.prototype.DrawRenderer3D = function (container) {
  var prof = 10;

  var path = "M" + (this.margin.left + prof) + "," + this.margin.top;
  path = path + "H" + (this.defSettings.globals.width - this.margin.right);
  path = path + "V" + (this.defSettings.globals.height - this.margin.bottom - prof);
  path = path + "L" + (this.defSettings.globals.width - this.margin.right - prof) + "," + (this.defSettings.globals.height - this.margin.bottom);
  path = path + "H" + this.margin.left;
  path = path + "V" + (this.margin.top + prof);
  path = path + "Z";
  container.append("path")
    .attr("id", this.chartId + "d3ChartRendererPath3D")
    .attr("d", path);

  var path2 = "M" + (this.margin.left + prof) + "," + this.margin.top;
  path2 = path2 + "L" + this.margin.left + "," + (this.margin.top + prof);
  path2 = path2 + "V" + (this.defSettings.globals.height - this.margin.bottom);
  path2 = path2 + "H" + (this.defSettings.globals.width - this.margin.right - prof);
  path2 = path2 + "L" + (this.defSettings.globals.width - this.margin.right) + "," + (this.defSettings.globals.height - this.margin.bottom - prof);
  path2 = path2 + "H" + (this.margin.left + prof);
  path2 = path2 + "Z";
  container.append("path")
    .attr("id", this.chartId + "d3ChartRendererPath3DBands")
    .attr("d", path2)
    .attr("style", makeStyleHTMLString({
      stroke: "none",
      fill: "#DDDDDD",
      shape9rendering: "crispEdges"
    }));

  path2 = "M" + (this.margin.left + prof) + "," + this.margin.top;
  path2 = path2 + "V" + (this.defSettings.globals.height - this.margin.bottom - prof);
  path2 = path2 + "M" + (this.margin.left + prof) + "," + (this.defSettings.globals.height - this.margin.bottom - prof);
  path2 = path2 + "L" + this.margin.left + "," + (this.defSettings.globals.height - this.margin.bottom);
  path2 = path2 + "M" + (this.margin.left + prof) + "," + (this.defSettings.globals.height - this.margin.bottom - prof);
  path2 = path2 + "H" + (this.defSettings.globals.width - this.margin.right);
  container.append("path")
    .attr("id", this.chartId + "d3ChartRendererPath3DBandsLine")
    .attr("d", path2)
    .attr("style", makeStyleHTMLString({
      stroke: "#C0C0C0",
      fill: "none",
      shape9rendering: "crispEdges"
    }));

  var lines = [];
  path2 = "M" + this.margin.left + "," + (this.margin.top + prof);
  path2 = path2 + "V" + (this.defSettings.globals.height - this.margin.bottom);
  lines.push(path2);
  path2 = "M" + (this.defSettings.globals.width - this.margin.right) + "," + (this.defSettings.globals.height - this.margin.bottom - prof);
  path2 = path2 + "L" + (this.defSettings.globals.width - this.margin.right - prof) + "," + (this.defSettings.globals.height - this.margin.bottom);
  lines.push(path2);

  if (Empty(this.defSettings.globals.chartColors.borderColor)) {
    container.selectAll(".outLine")
      .data(lines)
      .enter()
      .append("path")
      .attr("class", "outLine3DPath")
      .attr("d", function (d) {
        return d;
      })
      .attr("style", makeStyleHTMLString({
        stroke: "#C0C0C0",
        fill: "none",
        shape9rendering: "crispEdges"
      }));
  }
  else {
    container.selectAll(".outLine")
      .data(lines)
      .enter()
      .append("path")
      .attr("class", "outLine3DPath")
      .attr("d", function (d) {
        return d;
      });
  }
}
StdChart.prototype.ApplyColors = function () {
  var gradID,
    id, i,
    styleObj = {};

  /**** svg ****/
  gradID = this.chartId + "svgGradient";
  this.CreateGradient(this.defSettings.globals.graphColors.color, this.defSettings.globals.graphColors.gradient, gradID, "svg");
  styleObj.fill = "url(#" + gradID + ")";
  if (!Empty(this.defSettings.globals.graphColors.borderColor))
    styleObj.stroke = this.defSettings.globals.graphColors.borderColor;
  this.svg.select("#" + this.chartId + "d3ChartPlotRect").attr("style", makeStyleHTMLString(styleObj, this.svg.select("#" + this.chartId + "d3ChartPlotRect").attr("style")));

  if (this.multiSVG) {
    id = "";
    for (i = 0; i < this._GetDivisor(); i++) {
      id = this.chartId + i + "_";
      if (!Empty(d3.select("#" + id + "d3ChartPlotRect").node())) d3.select("#" + id + "d3ChartPlotRect").attr("style", makeStyleHTMLString(styleObj, d3.select("#" + id + "d3ChartPlotRect").attr("style")));
    }
  }

  /**** renderer + 3D ****/
  gradID = this.chartId + "rendererGradient";
  var colObj = this.GetChartBackground();
  this.CreateGradient(colObj.color, colObj.gradient, gradID, "renderer");
  styleObj.fill = "url(#" + gradID + ")";
  styleObj.shape9rendering = "crispEdges";
  this.svg.select("#" + this.chartId + "d3ChartRenderer").attr("style", makeStyleHTMLString(styleObj, this.svg.select("#" + this.chartId + "d3ChartRenderer").attr("style")));
  if (this.multiSVG) {
    if (!Empty(this.defSettings.globals.chartColors.borderColor))
      styleObj.stroke = this.defSettings.globals.chartColors.borderColor;
    id = "";
    for (i = 0; i < this._GetDivisor(); i++) {
      id = this.chartId + i + "_";
      if (!Empty(d3.select("#" + id + "d3ChartRenderer").node())) d3.select("#" + id + "d3ChartRenderer").attr("style", makeStyleHTMLString(styleObj, d3.select("#" + id + "d3ChartRenderer").attr("style")));
    }
  }
  else {
    if (!Empty(this.defSettings.globals.chartColors.borderColor))
      styleObj.stroke = this.defSettings.globals.chartColors.borderColor;
    this.svg.select("#" + this.chartId + "d3ChartRenderer").attr("style", makeStyleHTMLString(styleObj, this.svg.select("#" + this.chartId + "d3ChartRenderer").attr("style")));
  }

  /**** renderer3D ****/
  if (this.is3D) {
    if (!Empty(d3.select("#" + this.chartId + "d3ChartRendererPath3D").node())) {
      this.svg.select("#" + this.chartId + "d3ChartRenderer").attr("style", makeStyleHTMLString({ opacity: 0 }, this.svg.select("#" + this.chartId + "d3ChartRenderer").attr("style")));
      if (Empty(this.defSettings.globals.chartColors.borderColor))
        styleObj.stroke = "#C0C0C0";
      this.svg.select("#" + this.chartId + "d3ChartRendererPath3D").attr("style", makeStyleHTMLString(styleObj, this.svg.select("#" + this.chartId + "d3ChartRendererPath3D").attr("style")));
    }
  }

  /**** elementi ****/
  this._SetElementsColor();
  this._SetShapesColor();
  this.ApplyTransparency();

  /**** assi e griglie ****/
  this._SetAxisColor();
  this._SetAxisGridColor();

  /**** legenda ****/
  if (!Empty(this.legendList))
    this.SetLegendColors(this.svg, this.chartLegends.series, this.defSettings.chartLegend, this._GetSeriesColors(), "legendGroup");

  if (this.defSettings.range && !Empty(this.defSettings.range.labels)) {
    if (this.defSettings.range.gradient == "none")
      this.SetLegendColors(this.svg, this.chartLegends.range, this.defSettings.chartRangeLegend, this.defSettings.range.bands, "legendGrouprange", true);
    else
      this.SetGradientLegendColors(this.svg, this.chartLegends.range, this.defSettings.chartRangeLegend, this.defSettings.range.bands, "legendGrouprange", this.defSettings.range.gradient);
  }
}
StdChart.prototype.SetLegendColors = function (svgContainer, legendObj, legendRef, colorList, grpID, isRange) {
  if (!legendObj || legendObj.position == "hide" || legendObj.hide)
    return;
  var color = "",
    gradID = "",
    styleObj = {},
    legend = svgContainer.select("#" + this.chartId + grpID),
    rectID = legend.node().firstChild.id;
  if (legendObj.obj.useGraphColors)
    gradID = this.chartId + "svgGradient";
  else if (legendObj.obj.useLegendColors) {
    if (isRange) {
      if (this.chartLegends.series && !this.chartLegends.series.position == "hide" && !this.chartLegends.series.hide) {
        if (this.chartLegends.series.obj.useGraphColors)
          gradID = this.chartId + "svgGradient";
        else if (this.chartLegends.series.obj.useLegendColors)
          gradID = this.chartId + "legendGradient";
      }
    }
    else
      gradID = this.chartId + "legendGradient";
  }
  else {
    gradID = this.chartId + "legendGradient" + (isRange ? "range" : "");
    this.CreateGradient(legendRef.extendColors.color, legendRef.extendColors.gradient, gradID, "legend");
  }
  if (Empty(gradID))
    styleObj.fill = "#FFFFFF";
  else
    styleObj.fill = "url(#" + gradID + ")";
  styleObj.shape9rendering = "crispEdges";
  styleObj.stroke9width = (legendRef.extendLine.stroke || 0) + "px";
  if (!Empty(legendRef.extendLine.color))
    styleObj.stroke = legendRef.extendLine.color;
  svgContainer.select("#" + rectID).attr("style", makeStyleHTMLString(styleObj, svgContainer.select("#" + rectID).attr("style")));

  var chd = legend.node().childNodes,
    pos;
  for (var i = 1; i < chd.length; i++) {
    if (this.defSettings.reuseColorSeries && !colorList[i - 1]) {
      var l = colorList.length;
      var idx = i - 1;
      idx = idx % l;
      color = colorList[idx].color;
    }
    else
      color = colorList[i - 1].color;
    if (chd[i].childNodes.length > 2)
      pos = 1;
    else
      pos = 0;
    if (CharToBool(d3.select(chd[i].childNodes[pos]).attr("data-negative") + "") == true)
      color = "url(#" + this.chartId + "negativeValuePattern)";
    svgContainer.select("#" + chd[i].childNodes[pos].id).attr("fill", color);
  }
}
StdChart.prototype.SetGradientLegendColors = function (svgContainer, legendObj, legendRef, bands, grpID, gradient) {
  if (!legendObj || legendObj.position == "hide" || legendObj.hide)
    return;

  var color = "",
    gradID = "",
    styleObj = {},
    legend = svgContainer.select("#" + this.chartId + grpID),
    rectID = legend.node().firstChild.id,
    chd = legend.node().childNodes,
    mcol = [],
    vertical = (legendObj.position == "top" || legendObj.position == "bottom");

  if (legendObj.obj.useGraphColors)
    gradID = this.chartId + "svgGradient";
  else if (legendObj.obj.useLegendColors)
    gradID = this.chartId + "legendGradient";
  else {
    gradID = this.chartId + "legendGradient"/* + (isRange ? "range" : "")*/;
    this.CreateGradient(legendRef.extendColors.color, legendRef.extendColors.gradient, gradID, "legend");
  }
  styleObj.fill = "url(#" + gradID + ")";
  styleObj.shape9rendering = "crispEdges";
  styleObj.stroke9width = (this.defSettings.chartLegend.extendLine.stroke || 0) + "px";
  if (!Empty(this.defSettings.chartLegend.extendLine.color))
    styleObj.stroke = this.defSettings.chartLegend.extendLine.color;
  svgContainer.select("#" + rectID).attr("style", makeStyleHTMLString(styleObj, svgContainer.select("#" + rectID).attr("style")));

  if (gradient == "mono") {
    for (var i = bands.length - 1; i >= 0; i--) {
      color = bands[i].color;
      mcol = getListFromObjectArray(getColorsArrayLighter(color, 8).reverse(), "color");
      gradID = "rangeGradient_" + i;
      this.CreateGradient(mcol, vertical, gradID, "range");
      svgContainer.select("#" + chd[bands.length - i].id).attr("fill", "url(#" + gradID + ")");
    }
  }
  else {  // multi
    mcol = getListFromObjectArray(bands, "color");
    gradID = "rangeGradient_multi";
    this.CreateGradient(mcol, vertical, gradID, "range");
    svgContainer.select("#" + chd[1].id).attr("fill", "url(#" + gradID + ")");
  }
}
StdChart.prototype.CreateGradient = function (color, gradient, gradID, elemToApply) {
  if (Empty(this.svg.select("#" + gradID).node())) {
    var gDef = this.svg.select("#" + this.__cID + "d3ChartDefs")
      .append("linearGradient")
      .attr("id", gradID)
      .attr("gradientUnits", "objectBoundingBox");

    var col = color,
      grad = gradient;
    if (!Empty(col) && Empty(grad))
      grad = col;
    else if (Empty(col) && !Empty(grad))
      col = grad;
    else if (Empty(col) && Empty(grad)) {
      col = grad = "transparent";
      if (this.forPJS)
        col = grad = "#FFFFFF";
    }

    switch (elemToApply) {
      case "svg":
      case "legend":
        this.CreateSVGGradient(col, grad, gDef);
        break;
      case "renderer":
        this._CreateRendererGradient(col, grad, gDef);
        break;
      case "element":
        this._CreateElementGradient(col, grad, gDef);
        break;
      case "range":
        this.CreateRangeGradient(col, gDef, gradient);
        break;
    }
  }
}
StdChart.prototype.CreateSVGGradient = function (color, gradient, gDef) {
  var transpC = (color == "transparent" || Empty(color)),
    transpG = (gradient == "transparent" || Empty(gradient));

  gDef.attr("x1", "0%")
    .attr("y1", "100%")
    .attr("x2", "0%")
    .attr("y2", "0%");
  gDef.append("stop")
    .attr("offset", "0%")
    .attr("stop-color", transpC ? "#FFFFFF" : color)
    .attr("stop-opacity", (transpC && transpG) ? "0" : "1");
  gDef.append("stop")
    .attr("offset", "100%")
    .attr("stop-color", transpG ? "#FFFFFF" : gradient)
    .attr("stop-opacity", transpG ? "0" : "1");
}
StdChart.prototype.CreateRangeGradient = function (colorsArray, gDef, vertical) {
  if (vertical) {
    gDef.attr("x1", "100%")
      .attr("y1", "0%")
  }
  else {
    gDef.attr("x1", "0%")
      .attr("y1", "100%")
  }

  gDef.attr("x2", "0%")
    .attr("y2", "0%");

  for (var i = 0; i < colorsArray.length; i++) {
    gDef.append("stop")
      .attr("offset", Math.floor((100 / colorsArray.length) * i) + "%")
      .attr("stop-color", colorsArray[i])
      .attr("stop-opacity", "1");
  }
}
StdChart.prototype.SetAxisColor = function (type, coord, value, noArc, axId, scaleRef) {
  axId = axId || "";
  var defaultStrokeColor = "#C0C0C0",
    defaultStrokeWidth = 1,
    styleObj = {},
    axisID,
    ticks,
    line,
    axisProp = type + "Axis",
    axisLine = type + "Line";

  if (!this.defSettings[axisProp].show) {
    styleObj.visibility = "hidden";
    styleObj.display = "none";
    axisID = this.chartId + type + "AxisGroup" + axId;
    d3.select("#" + axisID).attr("style", makeStyleHTMLString(styleObj, d3.select("#" + axisID).attr("style")));
    return;
  }

  styleObj.fill = "transparent";
  styleObj.shape9rendering = "crispEdges";
  styleObj.stroke = defaultStrokeColor;
  styleObj.stroke9width = defaultStrokeWidth + "px";

  if (type == "tick" && !noArc) {
    styleObj.stroke = "transparent";
    styleObj.shape9rendering = "auto";
    styleObj.fill = defaultStrokeColor;
    styleObj.stroke9width = 0 + "px";
  }

  if (!Empty(this.defSettings[axisProp][axisLine].color)) {
    if (type == "tick" && !noArc)
      styleObj.fill = this.defSettings[axisProp][axisLine].color;
    else
      styleObj.stroke = this.defSettings[axisProp][axisLine].color;
  }

  // asse
  if (this.multipleScales && type != "percent" && !this.__1axisY) {
    if (this.objConfig.mapSeries && (scaleRef in this.objConfig.mapSeries)) {
      if (this.objConfig.mapSeries[scaleRef].ownerScale) {
        if (type == "tick" && !noArc)
          styleObj.fill = this.colorSet[this./*valueFields*/_GetReferredList().indexOf(scaleRef)].color;
        else
          styleObj.stroke = this.colorSet[this./*valueFields*/_GetReferredList().indexOf(scaleRef)].color;
      }
    }
  }

  if (!Empty(this.defSettings[axisProp][axisLine].stroke) && !isNaN(this.defSettings[axisProp][axisLine].stroke) && this.defSettings[axisProp][axisLine].stroke > 0)
    styleObj.stroke9width = this.defSettings[axisProp][axisLine].stroke + "px";

  if ("showAxis" in this.defSettings[axisProp]) {
    if (!this.defSettings[axisProp].showAxis) {
      if (type == "tick" && !noArc)
        styleObj.fill = "transparent";
      else
        styleObj.stroke = "transparent";
    }
  }

  axisID = this.chartId + type + "AxisGroup" + axId;
  if (d3.select("#" + axisID).select("." + type + "Ax").node())
    d3.select("#" + axisID).select("." + type + "Ax")
      .attr("d", function () {
        if (type == "tick")
          return d3.select(this).attr("d");
        var val = d3.select(this).attr("d"),
          tickv = d3.select("#" + axisID).select(".tick line").node();
        if (Empty(tickv))
          return val;
        tickv = tickv[coord].baseVal.value;
        if (coord.indexOf("x") >= 0) {  // orizzontale
          val = val.replace("M" + tickv, "M0");
          val = val.replace("H" + tickv, "H0");
        }
        else {
          val = val.replace("," + tickv, ",0");
          val = val.replace("V" + tickv, "V0");
        }
        return val;
      })
      .attr("style", makeStyleHTMLString(styleObj, d3.select("#" + axisID).select("." + type + "Ax").attr("style")));

  if (type == "tick" && !noArc) {
    styleObj.stroke = styleObj.fill;
    styleObj.fill = "transparent";
  }

  ticks = d3.select("#" + axisID).selectAll(".tick")._groups[0];
  for (var i = 0; ticks && i < ticks.length; i++) {
    line = d3.select(ticks[i]).select("line");
    /*if (coord && value) {
      if (this.wrapLabelUnder)
        line.node().attributes[coord].value = line.node().attributes[coord].value - value;
      else
        line.node().attributes[coord].value = value;
    }*/
    if (type == "tick" && !noArc) {
      styleObj.shape9rendering = "auto";
      styleObj.stroke9width = defaultStrokeWidth + "px";
      var rot = parseInt(line.attr("data-rotation"));
      if (rot == 0 || rot == 90 || rot == -90 || rot == -180 || rot == 180)
        styleObj.shape9rendering = "crispEdges";
      if (!Empty(d3.select(ticks[i]).attr("data-major")))
        styleObj.stroke9width = 2 + "px";
    }
    line.attr("style", makeStyleHTMLString(styleObj, line.attr("style")));
  }
}
StdChart.prototype.SetAxisFont = function (type, axId, scaleRef, applyColor) {
  axId = axId || "";
  var axisID = this.chartId + type + "AxisGroup" + axId,
    axisProp = type + "Axis",
    axisFont = type + "Font",
    ticks,
    text,
    font = JSON.stringify(appliedFont(this.defSettings, this.defSettings[axisProp], this.defSettings[axisProp][axisFont]));
  font = JSON.parse(font);  // evito reference
  if ((this.multipleScales && !applyColor && type == "value") || (this.multipleScales && applyColor)) {
    if (this.objConfig.mapSeries && (scaleRef in this.objConfig.mapSeries)) {
      if (this.objConfig.mapSeries[scaleRef].ownerScale && !this.defSettings[type + "Axis"].showAxis)
        font.color = this.colorSet[this.valueFields.indexOf(scaleRef)].color;
    }
  }

  if (this.scaleY && this.scaleY[scaleRef] && this.scaleY[scaleRef].__fPerc)
    font.size = font.size - (font.size * this.scaleY[scaleRef].__fPerc);

  setFont(d3.select("#" + axisID), font, this);
  ticks = d3.select("#" + axisID).selectAll(".tick")._groups[0];
  for (var i = 0; ticks && i < ticks.length; i++) {
    text = d3.select(ticks[i]).select("text");
    if (this._GetValueAxisPosition() == "bottom")
      text.node().attributes.dy.value = font.size + "px";
    text.attr("fill", null);
    text.attr("stroke", null);
    d3.select(ticks[i]).select("line").attr("fill", null);
    d3.select(ticks[i]).select("line").attr("stroke", null);
  }
}
StdChart.prototype.SetAxisGroupFont = function (type, group, scaleRef) {
  var axisProp = type + "Axis",
    axisFont = type + "Font",
    font = JSON.stringify(appliedFont(this.defSettings, this.defSettings[axisProp], this.defSettings[axisProp][axisFont]));
  font = JSON.parse(font);  // evito reference
  if (this.multipleScales) {
    if (this.objConfig.mapSeries && (scaleRef in this.objConfig.mapSeries)) {
      if (this.objConfig.mapSeries[scaleRef].ownerScale && !this.defSettings[type + "Axis"].showAxis)
        font.color = this.colorSet[this.valueFields.indexOf(scaleRef)].color;
    }
  }
  setFont(group, font, this);
}
StdChart.prototype.SetAxisLabelFont = function (type) {
  var labelID = this.chartId + type + "AxisLabel";
  if (!Empty(this.svg.select("#" + labelID).node())) {
    var font = appliedFont(this.defSettings, this.defSettings.axisLabel, this.defSettings.axisLabel.axisFont);
    setFont(d3.select("#" + labelID), font, this);
  }
}
StdChart.prototype.SetAxisLabelGroupFont = function (group) {
  var font = appliedFont(this.defSettings, this.defSettings.axisLabel, this.defSettings.axisLabel.axisFont);
  setFont(group, font, this);
}
StdChart.prototype.ApplyFonts = function () {
  /**** assi ****/
  this._SetAxisFont();

  /**** titoli assi ****/
  this._SetAxisLabelFont();

  /**** titolo - legenda - sottotitolo - legenda range ****/
  var font;
  if (!Empty(this.chartTitle)) {
    font = appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont);
    setFont(d3.select("#" + this.chartId + "title"), font, this);
  }

  if (!Empty(this.legendList) && this.chartLegends.series && this.chartLegends.series.position != "hide" && !this.chartLegends.series.hide) {
    font = appliedFont(this.defSettings, this.defSettings.chartLegend, this.defSettings.chartLegend.textFont);
    setFont(d3.select("#" + this.chartId + "legendGroup"), font, this);
  }

  if (this.defSettings.range && (!Empty(this.defSettings.range.labels) && this.chartLegends.range && this.chartLegends.range.position != "hide" && !this.chartLegends.range.hide)) {
    font = appliedFont(this.defSettings, this.defSettings.chartRangeLegend, this.defSettings.chartRangeLegend.textFont);
    setFont(d3.select("#" + this.chartId + "legendGrouprange"), font, this);
  }

  if (!Empty(this.chartSubtitle)) {
    font = appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont);
    setFont(d3.select("#" + this.chartId + "subtitle"), font, this);
  }
}
StdChart.prototype.DrawTitle = function () {
  var mRefChart = this._ZtChart.StdChart;
  if (Empty(this.chartTitle))
    return;
  var id = this.chartId + "title";
  this.SetTitlesPositions(id, this.chartTitle, this.defSettings.chartTitle);
  this.svg.select("#" + id)
    .on("click", function () {
      var titleObj = {};
      titleObj.type = 'title';
      titleObj.text = mRefChart.chartTitle;
      if (window[mRefChart.chartId + "onTitleClick"])
        window[mRefChart.chartId + "onTitleClick"](titleObj);
      else if (mRefChart._ZtChart.parentCtrl && mRefChart._ZtChart.parentCtrl.dispatchEvent) {
        var on_evt = mRefChart._ZtChart.parentCtrl.dispatchEvent('onTitleClick', d3.event, titleObj);
        if (!on_evt) {
          if (window[mRefChart.chartId + "TitleClick"])
            window[mRefChart.chartId + "TitleClick"](titleObj);
          else
            mRefChart._ZtChart.parentCtrl.dispatchEvent('TitleClick', d3.event, titleObj);
        }
      }
    })
    .style("cursor", function () {
      if (window[mRefChart.chartId + "onTitleClick"])
        return "pointer";
      else if (mRefChart._ZtChart.parentCtrl && mRefChart._ZtChart.parentCtrl.dispatchEvent) {
        if (mRefChart._ZtChart.parentCtrl.form && mRefChart._ZtChart.parentCtrl.form[mRefChart._ZtChart.parentCtrl.name + "_onTitleClick"])
          return "pointer";
      }
      return "default";
    });
}
StdChart.prototype.DrawSubtitle = function () {
  if (Empty(this.chartSubtitle))
    return;
  var _this = this,
    id = this.chartId + "subtitle",
    mRefChart = this._ZtChart.StdChart;
  this.SetTitlesPositions(id, this.chartSubtitle, this.defSettings.chartSubtitle);
  this.svg.select("#" + id)
    .on("click", function () {
      var titleObj = {};
      titleObj.type = 'subtitle';
      titleObj.text = _this.chartSubtitle;
      if (window[mRefChart.chartId + "onTitleClick"])
        window[mRefChart.chartId + "onTitleClick"](titleObj);
      else if (mRefChart._ZtChart.parentCtrl && mRefChart._ZtChart.parentCtrl.dispatchEvent) {
        var on_evt = mRefChart._ZtChart.parentCtrl.dispatchEvent('onTitleClick', d3.event, titleObj);
        if (!on_evt) {
          if (window[mRefChart.chartId + "TitleClick"])
            window[mRefChart.chartId + "TitleClick"](titleObj);
          else
            mRefChart._ZtChart.parentCtrl.dispatchEvent('TitleClick', d3.event, titleObj);
        }
      }
    })
    .style("cursor", function () {
      if (window[mRefChart.chartId + "onTitleClick"])
        return "pointer";
      else if (mRefChart._ZtChart.parentCtrl && mRefChart._ZtChart.parentCtrl.dispatchEvent) {
        if (mRefChart._ZtChart.parentCtrl.form && mRefChart._ZtChart.parentCtrl.form[mRefChart._ZtChart.parentCtrl.name + "_onTitleClick"])
          return "pointer";
      }
      return "default";
    });
}
StdChart.prototype.GetLegendIcon = function () {
  var icons = this._GetLegendIconHexCode();
  if (icons.constructor != Array)
    return getIconFromCode(icons);
  var rhex = [];
  for (var i = 0; i < icons.length; i++)
    rhex.push(getIconFromCode(icons[i]));
  return rhex;
}
StdChart.prototype.GetRangeLegendIcon = function () {
  return getIconFromCode(this._GetRangeLegendIconHexCode());
}
StdChart.prototype.GetMarkerLegendIcon = function () {
  return getIconFromCode(this._GetMarkerLegendIconHexCode());
}
StdChart.prototype.DrawLegendItems = function (svgContainer) {
  var _this = this;
  if (this.chartLegends.series)
    drawLegend(this.chartLegends.series, this.GetLegendAlternativeIcon(), this.GetLegendAlternativeIconHexCode(), this._GetLegendList(), this.hasNegativeValues, false)

  if (this.chartLegends.range && this.chartLegends.range.position != "hide") {
    if (this.defSettings.range.gradient == "none")
      drawLegend(this.chartLegends.range, this.GetLegendAlternativeIcon(true), this.GetLegendAlternativeIconHexCode(true), this.defSettings.range.labels, false, true);
    else
      this.DrawGradientLegend(svgContainer);
  }

  function drawLegend(legendObj, icon, hexCode, list, hasNegativeValues, isRange) {
    if (legendObj.position == "hide" || legendObj.hide)
      return;

    if (Empty(list))
      return;

    var lid = "legendGroup" + (isRange ? "range" : ""),
      legend = svgContainer.append("g")
        .attr("id", _this.chartId + lid);

    if (hasNegativeValues)
      list.push(_this.Translate("ZTC_NEGVAL"));

    legend.append("rect")
      .attr("id", _this.chartId + "legend_container_rect" + (isRange ? "range" : ""))
      .attr("x", 0)
      .attr("y", 0);

    var legendid = "legend" + (isRange ? "range" : "") + "_",
      legendtext = "legendText" + (isRange ? "range" : "") + "_";
    drawLegendItems(legend, icon, list, _this.chartId + legendid, _this.chartId + legendtext, hexCode, _this, isRange);
  }
}
StdChart.prototype.AdjustPositions = function () {
  var legend;
  if (this.chartLegends.series && this.chartLegends.series.position != "hide" && !this.chartLegends.series.hide) {
    legend = this.svg.select("#" + this.chartId + "legendGroup");
    this.SetLegendPosition(this.svg, legend, this.chartLegends.series, this.legendList);
  }

  if (this.chartLegends.range && this.chartLegends.range.position != "hide" && !this.chartLegends.range.hide) {
    legend = this.svg.select("#" + this.chartId + "legendGrouprange");
    if (this.defSettings.range.gradient == "none")
      this.SetLegendPosition(this.svg, legend, this.chartLegends.range, this.defSettings.range.labels, true);
    else
      this.SetGradientLegendPosition(this.svg, legend, this.chartLegends.range, this.defSettings.range.bands);
  }

  this.SetSubtitlePosition();
  this._SetAxisLabelsPositions();
  this._SetValueAxisPositions();
  this._SetBreadcrumbPosition();
}
StdChart.prototype.SetLegendPosition = function (svgContainer, legend, legendObj, list, isRange) {
  if (!legendObj)
    return;
  var upOffset = 5,
    legendFont = appliedFont(this.defSettings, legendObj.obj, legendObj.obj.textFont),
    iconWH = legendFont.size,
    iconFH = 14,
    startX = 0,
    startY = 0,
    offset = Math.round(5 * this.pxFactor),
    maxW = 0,
    maxH = 0,
    x = 0,
    y = 0,
    font,
    upd = false,
    i, j, mH,
    lchd = legend.node().childNodes;
  if (legendObj.tooLong) {
  }
  else if (legendObj.position == "top" || legendObj.position == "bottom") {
    var inGrp;
    startX = offset;
    startY = offset;
    for (i = 0; lchd && i < list.length; i++) {
      inGrp = lchd[i + 1];
      for (j = 0; j < inGrp.childNodes.length; j++) {
        svgContainer.select("#" + inGrp.childNodes[j].id)
          .attr("x", startX)
        //.attr("dy", - 0.1 * getDomNodeHeight(inGrp.childNodes[j]) + "px");
        startX = startX + parseFloat(getDomNodeWidth(inGrp.childNodes[j])) + offset;
        maxH = Math.max(iconWH, getOffsetHeight(list[i], legendFont, this.chartId));
        maxH = Math.max(iconFH, maxH);
      }
    }
    //maxH = maxH + offset;
    for (i = 0; lchd && i < list.length; i++) {
      inGrp = lchd[i + 1];
      for (j = 0; j < inGrp.childNodes.length; j++) {
        mH = getOffsetHeight(list[i], legendFont, this.chartId);
        if (!Empty(inGrp.childNodes[j].getAttribute("data-font")))
          mH = iconFH;
        svgContainer.select("#" + inGrp.childNodes[j].id)
          .attr("y", maxH /*- ((maxH - mH) / 2)*/);
      }
    }
    maxH = maxH + offset;
    svgContainer.select("#" + legend.node().firstChild.id)
      .attr("width", startX)
      .attr("height", maxH);

    if (legendObj.obj.alignment == "left")
      x = this.marginOffsetX;
    else if (legendObj.obj.alignment == "right")
      x = this.defSettings.globals.width - startX - this.marginOffsetX;
    else
      x = (this.defSettings.globals.width / 2) - (startX / 2);
    y = this.marginOffsetY;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == legendObj.position) {
      font = appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont);
      y = y + getOffsetHeight(this.chartTitle, font, this.chartId) + upOffset;
      upd = true;
    }

    if (isRange) {
      if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.position == legendObj.position) {
        font = appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont);
        y = y + getOffsetHeight(this.chartSubtitle, font, this.chartId) + upOffset;
        upd = true;
      }

      if (this.chartLegends.series && this.chartLegends.series.position == legendObj.position) {
        y = y + getDomNodeHeight(d3.select("#" + this.chartId + "legendGroup").node());
        upd = true;
      }
    }
    else {
      if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.positionOrder == "before" && this.defSettings.chartSubtitle.position == legendObj.position) {
        font = appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont);
        y = y + getOffsetHeight(this.chartSubtitle, font, this.chartId) + upOffset;
        upd = true;
      }
    }
    if (upd)
      y = y //+ upOffset /*+ upOffset / 2*/;
    if (legendObj.position == "bottom") {
      y = this.defSettings.globals.height - y - maxH;
      if (upd)
        y = y + upOffset;
    }
    legend.attr("transform", "translate(" + [x, y] + ")");
  }
  else if (legendObj.position == "left" || legendObj.position == "right") {
    startX = offset;
    startY = offset / 2;
    for (i = 0; lchd && i < list.length; i++) {
      inGrp = lchd[i + 1];
      startX = offset;
      for (j = 0; j < inGrp.childNodes.length; j++) {
        svgContainer.select("#" + inGrp.childNodes[j].id)
          .attr("x", startX)
        // .attr("dy", - 0.1 * getDomNodeHeight(inGrp.childNodes[j]) + "px");
        startX = startX + parseFloat(getDomNodeWidth(inGrp.childNodes[j])) + offset;
        maxW = Math.max(maxW, startX);
        maxH = Math.max(iconWH, getOffsetHeight(list[i], legendFont, this.chartId));
        maxH = Math.max(iconFH, maxH);
      }
      startY = startY + maxH + offset;
      mH = getOffsetHeight(list[i], legendFont, this.chartId);
      for (j = 0; j < inGrp.childNodes.length; j++) {
        svgContainer.select("#" + inGrp.childNodes[j].id)
          .attr("y", startY - ((((3 * offset) / 2 + maxH) - mH) / 2));
      }
    }
    startY = startY + offset;
    svgContainer.select("#" + legend.node().firstChild.id)
      .attr("width", maxW)
      .attr("height", startY);

    if (legendObj.obj.alignment == "left")
      y = this.defSettings.globals.height - startY - this.marginOffsetY;
    else if (legendObj.obj.alignment == "right")
      y = this.marginOffsetY;
    else
      y = (this.defSettings.globals.height / 2) - (startY / 2);
    x = this.marginOffsetX;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == legendObj.position) {
      font = appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont);
      x = x + getOffsetHeight(this.chartTitle, font, this.chartId);
      upd = true;
    }

    if (isRange) {
      if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.position == legendObj.position) {
        font = appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont);
        x = x + getOffsetHeight(this.chartSubtitle, font, this.chartId);
        upd = true;
      }

      if (this.chartLegends.series && this.chartLegends.series.position == legendObj.position) {
        x = x + getDomNodeWidth(d3.select("#" + this.chartId + "legendGroup").node());
        upd = true;
      }
    }
    else {
      if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.positionOrder == "before" && this.defSettings.chartSubtitle.position == legendObj.position) {
        font = appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont);
        x = x + getOffsetHeight(this.chartSubtitle, font, this.chartId);
        upd = true;
      }
    }

    if (upd)
      x = x + upOffset;
    if (legendObj.position == "right")
      x = this.defSettings.globals.width - x - maxW;
    legend.attr("transform", "translate(" + [x, y] + ")");
  }
}
StdChart.prototype.SetGradientLegendPosition = function (svgContainer, legend, legendObj, list) {
  if (!legendObj)
    return;
  var upOffset = 5,
    startX = 0,
    startY = 0,
    offset = 0,
    maxW = 0,
    maxH = 0,
    x = 0,
    y = 0,
    font, band, i, length,
    upd = false;
  appliedFont(this.defSettings, legendObj.obj, legendObj.obj.textFont);
  if (legendObj.position == "top" || legendObj.position == "bottom") {
    length = list.length;
    startX = 1;
    startY = offset + this.GetDefaultIconFont().size;
    maxH = getDomNodeHeight(legend.node());

    if (this.defSettings.range.gradient == "multi")
      length = 1;

    for (i = 0; i < length; i++) {
      band = legend.node().childNodes[i + 1];
      d3.select(band)
        .attr("x", startX)
        .attr("y", startY);

      startX = startX + getDomNodeWidth(band);
    }

    startX = startX + offset;
    svgContainer.select("#" + legend.node().firstChild.id)
      .attr("width", startX)
      .attr("height", maxH);

    if (legendObj.obj.alignment == "left")
      x = this.marginOffsetX;
    else if (legendObj.obj.alignment == "right")
      x = this.defSettings.globals.width - startX - this.marginOffsetX;
    else
      x = (this.defSettings.globals.width / 2) - (startX / 2);

    y = this.marginOffsetY;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == legendObj.position) {
      font = appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont);
      y = y + getOffsetHeight(this.chartTitle, font, this.chartId);
      upd = true;
    }

    if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.position == legendObj.position) {
      font = appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont);
      y = y + getOffsetHeight(this.chartSubtitle, font, this.chartId) + upOffset;
      upd = true;
    }

    if (this.chartLegends.series && this.chartLegends.series.position == legendObj.position) {
      y = y + getDomNodeHeight(d3.select("#" + this.chartId + "legendGroup").node());
      upd = true;
    }

    if (upd)
      y = y + upOffset + upOffset / 2;
    if (legendObj.position == "bottom") {
      y = this.defSettings.globals.height - y - maxH;
      if (upd)
        y = y + upOffset;
    }

    legend.attr("transform", "translate(" + [x, y] + ")");
  }
  else if (legendObj.position == "left" || legendObj.position == "right") {
    length = list.length;
    startX = offset + this.GetDefaultIconFont().size;
    startY = 1;
    maxW = getDomNodeWidth(legend.node());

    if (this.defSettings.range.gradient == "multi")
      length = 1;

    for (i = 0; i < length; i++) {
      band = legend.node().childNodes[i + 1];
      d3.select(band)
        .attr("x", startX)
        .attr("y", startY);

      startY = startY + getDomNodeHeight(band);
    }

    startY = startY + offset;
    svgContainer.select("#" + legend.node().firstChild.id)
      .attr("width", maxW)
      .attr("height", startY);

    if (legendObj.obj.alignment == "left")
      y = this.defSettings.globals.height - startY - this.marginOffsetY;
    else if (legendObj.obj.alignment == "right")
      y = this.marginOffsetY;
    else
      y = (this.defSettings.globals.height / 2) - (startY / 2);

    x = this.marginOffsetX;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == legendObj.position) {
      font = appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont);
      x = x + getOffsetHeight(this.chartTitle, font, this.chartId);
      upd = true;
    }

    if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.position == legendObj.position) {
      font = appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont);
      x = x + getOffsetHeight(this.chartSubtitle, font, this.chartId);
      upd = true;
    }

    if (this.chartLegends.series && this.chartLegends.series.position == legendObj.position) {
      x = x + getDomNodeWidth(d3.select("#" + this.chartId + "legendGroup").node());
      upd = true;
    }

    if (upd)
      x = x + (3 * upOffset) / 2;
    if (legendObj.position == "right")
      x = this.defSettings.globals.width - x - maxW;
    legend.attr("transform", "translate(" + [x, y] + ")");
  }
}
StdChart.prototype.SetSubtitlePosition = function () {
  if (Empty(this.chartSubtitle))
    return;
  var y = parseFloat(this.svg.select("#" + this.chartId + "subtitle").attr("y")),
    offset = 5,
    upd = false,
    factor = (this.defSettings.chartSubtitle.position == "bottom" || this.defSettings.chartSubtitle.position == "right") ? -1 : 1;

  if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == this.defSettings.chartSubtitle.position) {
    y = y + factor * getOffsetHeight(this.chartTitle, appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont), this.chartId);
    upd = true;
  }

  if (!Empty(this.legendList) && this.chartLegends.series.position == this.defSettings.chartSubtitle.position && this.defSettings.chartSubtitle.positionOrder == "after" && !this.chartLegends.series.hide) {
    var attr = "height";
    if (this.defSettings.chartSubtitle.position == "left" || this.defSettings.chartSubtitle.position == "right")
      attr = "width";
    var legend = parseFloat(d3.select("#" + this.chartId + "legend_container_rect").attr(attr));
    y = y + factor * legend;
    if (upd) {
      y = y + factor * offset;
      upd = false;
    }
  }

  if (this.defSettings.chartSubtitle.position == "bottom")
    y = y + factor * offset;

  if (upd)
    y = y + factor * offset;
  this.svg.select("#" + this.chartId + "subtitle").attr("y", y);
}
StdChart.prototype.SetAxisGridColor = function (type, circular) {
  var gridGrp = this.svg.select("#" + this.chartId + type + "AxisGridline").node();
  if (Empty(gridGrp) || Empty(gridGrp.childNodes))
    return;
  var chd = gridGrp.childNodes,
    stObj,
    gridObj = type + "Grid",
    axisObj = type + "Axis",
    gobj = this.defSettings[axisObj][gridObj];
  if (this.defSettings[axisObj].useValueGrid)
    gobj = this.defSettings.valueAxis.valueGrid;
  switch (gobj.type.toLowerCase()) {
    case "long_dashed":
      stObj = {
        stroke9linecap: "butt",
        stroke9dasharray: "10,6",
        shape9rendering: "crispEdges"
      };
      break;
    case "dotted":
      stObj = {
        stroke9linecap: "round",
        stroke9dasharray: "0.01,4",
        stroke9linejoin: "round",
        stroke9width: "1.5px",
        shape9rendering: "auto"
      };
      break;
    case "plain":
      stObj = {};
      stObj.shape9rendering = "crispEdges";
      break;
    default: // small_dashed
      stObj = {
        stroke9linecap: "butt",
        stroke9dasharray: "2,2",
        shape9rendering: "crispEdges"
      };
      break;
  }
  stObj.stroke = gobj.color;
  if (this.is3D || circular)
    stObj.fill = "none";
  if (circular)
    delete stObj.shape9rendering;
  for (var i = 0; i < chd.length; i++)
    this.svg.select("#" + chd[i].id).attr("style", makeStyleHTMLString(stObj, this.svg.select("#" + chd[i].id).attr("style")));
}
StdChart.prototype.SetValueAxisGridColor = function () {
  if (!this.defSettings.valueAxis.valueGrid.line)
    return;
  var _this = this,
    gridGrp = this.svg.select("#" + this.chartId + "valueAxisGroup").selectAll("g.tick line"),
    ticks = this.svg.select("#" + this.chartId + "valueAxisGroup").selectAll("g.tick")//._groups[0];
  switch (this.defSettings.valueAxis.valueGrid.type.toLowerCase()) {
    case "long_dashed":
      gridGrp
        .style("stroke-linecap", "butt")
        .style("stroke-dasharray", "10,6")
        .style("shape-rendering", "crispEdges");
      break;
    case "dotted":
      gridGrp
        .style("stroke-linecap", "round")
        .style("stroke-dasharray", "0.01,4")
        .style("stroke-linejoin", "round")
        .style("stroke-width", "1.5px")
        .style("shape-rendering", "auto");
      break;
    case "plain":
      gridGrp
        .style("shape-rendering", "crispEdges");
      break;
    default: // small_dashed
      gridGrp
        .style("stroke-linecap", "butt")
        .style("stroke-dasharray", "2,2")
        .style("shape-rendering", "crispEdges");
      break;
  }
  gridGrp.style("stroke", this.defSettings.valueAxis.valueGrid.color);
  ticks.each(function () {
    if (!_this.isH) {
      d3.select(this)
        .attr("transform", "translate(-6," + this.transform.baseVal.getItem(0).matrix.f + ")");
    }
    else {
      d3.select(this)
        .attr("transform", "translate(" + this.transform.baseVal.getItem(0).matrix.e + ",-6)");
    }
  })
}
StdChart.prototype.GetRendererSubdivisionsSizes = function (nDiv, width, height, subdivisionPlotMode, subdivisionPlotValue) {
  width = !width ? this.chartWidth : width;
  height = !height ? this.chartHeight : height;
  this.subdivisionPlotMode = subdivisionPlotMode || this.subdivisionPlotMode;
  this.subdivisionPlotValue = subdivisionPlotValue || this.subdivisionPlotValue;
  switch (this.subdivisionPlotMode) {
    case "vscrollprop":
    case "vscrollfirst":
    case "vscrollcust":
      return this.GetVerticalSubdivisionsSizes(nDiv, width, height);
      break;
    case "hscrollprop":
      return this.GetHorizontalSubdivisionsSizes(nDiv, width, height);
      break;
    default:
      return this.GetSubdivisionsSizes(nDiv, width, height);
      break;
  }
}
StdChart.prototype.GetSubdivisionsSizes = function (nDiv, width, height) {
  var sizes = this.GetGridSubdivisionsSizes(nDiv, width, height),
    svgLeft = - sizes.width,
    svgTop = 0,
    retMargins = [];
  for (var i = 0; i < nDiv; i++) {
    if (i % sizes.widthFactor == 0 && i != 0) {
      svgTop = svgTop + sizes.height;
      svgLeft = 0;
    }
    else
      svgLeft = svgLeft + sizes.width;
    retMargins.push({
      x: svgLeft,
      y: svgTop,
      width: sizes.width,
      height: sizes.height
    });
  }
  return retMargins;
}
StdChart.prototype.GetVerticalSubdivisionsSizes = function (nDiv, width, height) {
  var sizes;
  switch (this.subdivisionPlotMode) {
    case "vscrollprop":
      sizes = this.GetScrollSubdivisionsSizes(nDiv, width, height, true);
      break;
    case "vscrollfirst":
    case "vscrollcust":
      sizes = this.GetScrollSubdivisionsSizes(nDiv, width, height, false);
  }

  var svgLeft = 0,
    svgTop = 0,
    svgHeight = 0,
    retMargins = [];
  for (var i = 0; i < nDiv; i++) {
    if (i == 0 && sizes.firstFactor >= 1)
      svgHeight = sizes.height * sizes.firstFactor;
    else if (i == 0)
      svgHeight = height * sizes.firstFactor;
    else {
      svgTop = svgTop + svgHeight;
      svgHeight = sizes.height;
    }

    retMargins.push({
      x: svgLeft,
      y: svgTop,
      width: sizes.width,
      height: svgHeight
    });
  }

  return retMargins;
}
StdChart.prototype.GetHorizontalSubdivisionsSizes = function (nDiv, width, height) {
  var sizes = this.GetScrollSubdivisionsSizes(nDiv, width, height, true, true),
    svgLeft = 0,
    svgTop = 0,
    svgWidth = sizes.width,
    retMargins = [];
  for (var i = 0; i < nDiv; i++) {
    if (i > 0)
      svgLeft = svgLeft + svgWidth;

    retMargins.push({
      x: svgLeft,
      y: svgTop,
      width: svgWidth,
      height: sizes.height
    });
  }

  return retMargins;
}
StdChart.prototype.GetScrollSubdivisionsSizes = function (nDiv, width, height, isProp, isH) {
  var w = width,
    hh,
    firstFactor;
  if (isProp) {
    if (isH) {
      w = width / nDiv;
      hh = height;
      firstFactor = 1;
    }
    else {
      hh = height / nDiv;
      firstFactor = 1;
    }
  }
  else if (Empty(this.subdivisionPlotValue) || isNaN(this.subdivisionPlotValue)) {
    hh = height / (nDiv + 1);
    firstFactor = 2;
  }
  else {
    hh = ((height * (100 - this.subdivisionPlotValue)) / 100) / (nDiv - 1);
    firstFactor = this.subdivisionPlotValue / 100;
  }

  return { width: w, height: hh, firstFactor: firstFactor };
}
StdChart.prototype.GetGridSubdivisionsSizes = function (nDiv, width, height) {
  var halfw,
    w,
    halfh,
    hh;
  if (width > height) {
    halfw = recursivediv(height, width, nDiv, 1, -1);
    w = width / halfw;
    halfh = (Math.ceil(nDiv / halfw));
    hh = height / halfh;
  }
  else {
    halfh = recursivediv(width, height, nDiv, 1, -1);
    hh = height / halfh;
    halfw = Math.ceil(nDiv / halfh);
    w = width / halfw;
  }
  return { width: w, height: hh, widthFactor: halfw };
}
StdChart.prototype.DrawCustomAxis = function (container, index, arc, id, onlyTicks, scaleKey) {
  var vRange = this._GetCustomAxisMinMax(scaleKey, index, this.defSettings.tickAxis.minValue, this.defSettings.tickAxis.maxValue),
    majorUnit = 1,
    minorUnit = 5,
    precision = 0,
    majorTicks,
    minorTicks,
    group;

  this._SetCustomScaleParameters(scaleKey, this.scaleY[scaleKey], vRange.min, vRange.max);

  if (!this.scaleY[scaleKey].__noDraw) {
    if (Empty(this.defSettings.scale.majorIncrement) || isNaN(this.defSettings.scale.majorIncrement)) {
      if (Math.abs(vRange.max - vRange.min) > 10)
        majorUnit = Math.ceil(Math.abs(vRange.max - vRange.min) / 100) * 10;
    }
    else
      majorUnit = this.defSettings.scale.majorIncrement;

    precision = decimalPlaces(majorUnit);
    if (!((Empty(this.defSettings.tickAxis.precision) || isNaN(this.defSettings.tickAxis.precision)) && this.defSettings.tickAxis.precision != 0))
      precision = this.defSettings.tickAxis.precision;

    if (precision < 0)
      precision = 0;
    if (precision > 20)
      precision = 20;

    if ((!Empty(this.defSettings.scale.minorCount) || this.defSettings.scale.minorCount == 0) && !isNaN(this.defSettings.scale.minorCount))
      minorUnit = this.defSettings.scale.minorCount + 1;  // aggiungo 1 per step finale

    majorTicks = setTicks(vRange.min, vRange.max, majorUnit, precision);
    minorTicks = setTicks(vRange.min, vRange.max, majorUnit / minorUnit, precision, true);

    group = container.append("g")
      .attr("id", id + "tickAxisGroup_" + replaceSpecialCharsForID(scaleKey));

    if (!onlyTicks && arc) {
      group.append("path")
        .attr("class", "tickAx TRANSP")
        .attr("d", arc);
    }

    if (minorTicks[minorTicks.length - 1] >= majorTicks[majorTicks.length - 1]) {
      if (minorTicks[minorTicks.length - 1] < vRange.max)
        majorTicks.push(vRange.max);
      else if (minorTicks[minorTicks.length - 1] > majorTicks[majorTicks.length - 1])
        majorTicks.push(minorTicks[minorTicks.length - 1]);
      minorTicks.pop();
    }

    this._DrawTicks(group, majorTicks, true, this.scaleY[scaleKey]);
    this._DrawTicks(group, minorTicks, false, this.scaleY[scaleKey]);
  }
}
StdChart.prototype.ApplyTransparency = function () {
  if (this.defSettings.globals.transparency <= 0)
    return;
  var trsp = 1 - (this.defSettings.globals.transparency / 100);
  this.svg.selectAll(".TRANSP").style("opacity", trsp);
}
StdChart.prototype.SetOtherCharts = function () {
  this.otherCharts = [];
  if (Empty(this.objConfig.otherChart) || this.objConfig.otherChart.length == 0)
    return;
  var allCharts = getAllCharts();
  if (this.objConfig.otherChart.toLowerCase() == "all") {
    if (getChartMacroCategoryType(this.type) == "xyz")
      this.otherCharts = allCharts.xyz;
    else if (getChartMacroCategoryType(this.type) == "geo")
      this.otherCharts = allCharts.geo;
    else
      this.otherCharts = allCharts.category;
  }
  else
    this.otherCharts = setOtherChartsArray(this.objConfig.otherChart, this.type);
}
StdChart.prototype.SetDownloadFormats = function () {
  this.downloadFormats = [];
  if (Empty(this.objConfig.downloadFormat) || this.objConfig.downloadFormat.length == 0)
    return;
  var allFormats = ["SVG", "SVGF", "PNG", "JPEG", "PDF", "CSV", "XML"];
  if (this.objConfig.downloadFormat.toLowerCase() == "all")
    this.downloadFormats = allFormats;
  else
    this.downloadFormats = this.objConfig.downloadFormat.split(",");
}
StdChart.prototype.DownloadChart = function (type) {
  if (Empty(type))
    type = 'svg';
  type = type.toLowerCase();
  if (type == 'csv' || type == 'xml') {
    if (this.CheckSelection())
      this.OpenExportDiv(type);
    else
      this._GetExportData(type, "EXPALL");
  }
  else {
    if (myZtCharts[this.chartId]) {
      var svgString = myZtCharts[this.chartId].getSVGString(type);
      this.GetDownload(type, svgString);
    }
  }
}
StdChart.prototype.GetDownload = function (type, svgString) {
  function b64toBlob(b64Data, contentType, isB64, sliceSize) {
    contentType = contentType || '';
    sliceSize = sliceSize || 512;
    var byteCharacters = isB64 ? atob(b64Data) : b64Data;
    var byteArrays = [];
    for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
      var slice = byteCharacters.slice(offset, offset + sliceSize);
      var byteNumbers = new Array(slice.length);
      for (var i = 0; i < slice.length; i++) {
        byteNumbers[i] = slice.charCodeAt(i);
      }
      var byteArray = new Uint8Array(byteNumbers);
      byteArrays.push(byteArray);
    }
    var blob = new Blob(byteArrays, { type: contentType });
    return blob;
  }

  var ifrm = document.getElementById(this.chartId + "dFrame");
  if (Empty(ifrm)) {
    ifrm = document.createElement('iframe');
    ifrm.setAttribute("name", this.chartId + "dFrame");
    ifrm.setAttribute("id", this.chartId + "dFrame");
    ifrm.style.width = "1px";
    ifrm.style.height = "1px";
    ifrm.frameborder = 0;
    ifrm.style.border = 0;
    document.body.appendChild(ifrm);
  }

  var webroot = this.GetWebRootURL();
  if (this.usedFonts.indexOf("svgcharts") < 0)
    this.usedFonts.push("svgcharts");

  var akey = LibJavascript.AlfaKeyGen(10);

  var url = webroot + '/servlet/SPBatikServlet?svgStr=' + URLenc(svgString);
  url += "&uri=" + URLenc(document.baseURI);
  url += "&chartId=" + URLenc(this.chartId);
  url += "&type=" + URLenc(type);
  url += "&fonts=" + URLenc(this.usedFonts.toString());
  url += "&fileName=" + URLenc(Empty(this.exportFileName) ? akey : this.exportFileName);

  if (type == 'png' || type == 'pdf' || type == 'jpeg' || type == 'jpg' || type == 'svgf')
    windowOpenForeground(url, this.chartId + "dFrame", 'left=0,top=0,toolbar=0,resizable=0');
  else { //csv//svg//xml
    var a = document.createElement('a'),
      ext = ".",
      typeApp = 'text/';

    a.setAttribute("id", akey);
    document.body.appendChild(a);
    if (type == "csv" || type == "svg" || type == "xml") {
      ext += type;
      typeApp += type;
    }
    else {
      ext += "txt";
      typeApp += "plain";
    }

    if (typeof a.download == "undefined") {
      if (navigator.msSaveBlob) {
        var csvData = new Blob([svgString], { type: typeApp + ';charset=utf-8;' });
        //navigator.msSaveBlob(csvData, (Empty(this.exportFileName) ? akey : this.exportFileName) + ext);
        navigator.msSaveOrOpenBlob(csvData, (Empty(this.exportFileName) ? akey : this.exportFileName) + ext);
      }
      else
        (window.PSAlert || window).alert('Browser Not Implemented Client Side Download!!!');
    }
    else {
      var mData = b64toBlob(svgString, typeApp),
        mUrl = URL.createObjectURL(mData);
      a.href = mUrl;
      a.download = (Empty(this.exportFileName) ? akey : this.exportFileName) + ext;
      a.click();
      document.body.removeChild(a);
    }
  }
}
StdChart.prototype.SetMenuItems = function () {
  if (this._ZtChart._vpvMenu) {
    this.SetMenuVPV();
    return;
  }
  this.menu = {};
  this.menu.show = true;
  this.menu.position = "left";
  this.menu.selection = true;
  this.menu.dataOrder = true;
  this.menu.otherCharts = true;
  this.menu.download = true;
  this.menu.aggregateData = true;
  this.menu.enableGrid = true;
  this.menu.ctrl = null;

  if (this.objConfig.menuPosition && !Empty(this.objConfig.menuPosition) && this.objConfig.menuPosition == "hide")
    this.menu.show = false;

  var inLegend = false;
  if (this.chartLegends && this.chartLegends.series && (this.chartLegends.series.hide && this.chartLegends.series.position != "hide"))
    /*this.menu.show*/inLegend = true;

  var inLegendR = false;
  if (this.chartLegends && this.chartLegends.range && (this.chartLegends.range.hide && this.chartLegends.range.position != "hide"))
    /*this.menu.show*/inLegendR = true;

  if (this.objConfig.menuPosition && !Empty(this.objConfig.menuPosition) && this.objConfig.menuPosition != "hide")
    this.menu.position = this.objConfig.menuPosition;

  this.menu.selection = this.objConfig.enableMenuSelections;
  this.menu.dataOrder = this.objConfig.enableChangeOrder;
  this.menu.otherCharts = this.otherCharts.length > 0;
  this.menu.download = this.downloadFormats.length > 0;
  this.menu.aggregateData = !Empty(this.objConfig.dataOthers) && this.objConfig.dataOthers.menu;
  this.menu.enableGrid = this.objConfig.enableGrid;

  var emptyMenu = (!this.menu.selection &&
    !this.menu.dataOrder &&
    !this.menu.otherCharts &&
    !this.menu.download &&
    !this.menu.aggregateData &&
    !this.menu.enableGrid &&
    !inLegend &&
    !inLegendR
  );
  if (emptyMenu)
    this.menu.show = false;

  this.fmenu = {};
  var enableExclude = this._ZtChart.enableExclude;
  if (this.objConfig.zoomFilter && this.objConfig.zoomFilter.show == 'chartzoom')
    enableExclude = false;
  this.fmenu.show = enableExclude;
  if (!this._SupportFilter())
    this.fmenu.show = false;
  this.fmenu.position = "left";
  this.fmenu.ctrl = null;
  if (this.menu.show && !Empty(this.menu.position) && this.menu.position == "left")
    this.fmenu.position = "right";
  if (!this.menu.show && this.objConfig.zoomFilter && this.objConfig.zoomFilter.show != 'default')
    this.fmenu.position = "right";
}
StdChart.prototype.SetMenuVPV = function () {
  this.menu = {};
  this.menu.show = true;
  this.menu.position = this.objConfig.menuPosition;
  this.menu.selection = false;
  this.menu.dataOrder = false;
  this.menu.otherCharts = false;
  this.menu.download = false;
  this.menu.aggregateData = false;
  this.menu.enableGrid = false;
  this.menu.ctrl = null;

  this.fmenu = {};
  this.fmenu.show = false;
  this.fmenu.position = "left";
  this.fmenu.ctrl = null;
}
StdChart.prototype.GetMultiDimensionalIcon = function (type) {
  var icon = "";
  switch (type) {
    case "play":
      icon = "ebe1";
      break;
    case "pause":
      icon = "ebaf";
      break;
  }
  return getIconFromCode(icon);
}
StdChart.prototype.ResetItems = function () {
  this.items = [];
}
StdChart.prototype.GetShapesRadius = function () {
  if (!this.shapesRadius) {
    this.shapesRadius = this.defSettings.shape.size || 0;
    if (this.defSettings.shape.type == 'percent')
      this.shapesRadius = this.chartWidth * this.shapesRadius / 100;
    this.shapesRadius = this.shapesRadius / 2;
  }
  return this.shapesRadius;
}
StdChart.prototype.GetChartBackground = function () {
  var colObj = { color: "", gradient: "" };
  if (Empty(this.defSettings.globals.chartColors.color)) {
    if (Empty(this.defSettings.globals.chartColors.gradient)) {
      if (Empty(this.defSettings.globals.graphColors.gradient))
        colObj.color = this.defSettings.globals.graphColors.color;
      else {
        colObj.color = this.defSettings.globals.graphColors.color;
        colObj.gradient = this.defSettings.globals.graphColors.gradient;
      }
    }
    else
      colObj.gradient = this.defSettings.globals.chartColors.gradient;
  }
  else {
    colObj.color = this.defSettings.globals.chartColors.color;
    colObj.gradient = this.defSettings.globals.chartColors.gradient;
  }
  return colObj;
}
StdChart.prototype.RemoveAllHovers = function () {
  var _this = this._ZtChart.StdChart;
  _this.ClearHoverTimeout();
  d3.selectAll("[item-type=hover]").remove();
  d3.select("#" + _this.chartId + "tooltipDiv").style("display", "none");
  d3.selectAll(".ztc_tooltipDiv").style("display", "none");
  if( !_this.defSettings.hierarchy || !_this.defSettings.hierarchy.breadcrumb  || !_this.defSettings.hierarchy.breadcrumb.fixed )
    d3.select("#" + _this.chartId + "breadcrumb").selectAll("*").remove();
}
StdChart.prototype.ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (this.defSettings.range.type == "none" && !isFnc)
    return;
  this._ApplyRangeBands();
}
StdChart.prototype.CreateGradientFromColors = function (colors, gradID, vert, reverse) {
  if (Empty(this.svg.select("#" + gradID).node())) {
    var gDef = this.svg.select("#" + this.__cID + "d3ChartDefs")
      .append("linearGradient")
      .attr("id", gradID)
      .attr("spreadMethod", "pad");

    gDef.attr("x1", "0%")
      .attr("y1", function () {
        if (reverse)
          return "100%";
        return "0%"
      })
      .attr("x2", function () {
        if (vert)
          return "0%";
        return "100%";
      })
      .attr("y2", function () {
        if (vert && !reverse)
          return "100%";
        return "0%";
      });

    if (colors.length > 1) {
      for (var i = 0; i < colors.length; i++) {
        d3.select("#" + gradID).append("stop")
          .attr("offset", Math.floor((100 / colors.length) * i) + "%")
          .attr("stop-color", colors[i])
          .attr("stop-opacity", "1");
      }
    }
    else {
      d3.select("#" + gradID).append("stop")
        .attr("offset", "0%")
        .attr("stop-color", colors[0])
        .attr("stop-opacity", "1");
    }
  }
}
StdChart.prototype.GetColorFromRange = function (value, bands) {
  var rbMin = bands[0].minValue,
    rbMax = bands[bands.length - 1].maxValue;
  var fcolor = "";
  for (var i = 0; i < bands.length && Empty(fcolor); i++) {
    if (this.defSettings.range.gradient != "multi") {
      rbMin = bands[i].minValue;
      rbMax = bands[i].maxValue;
    }
    if (!bands[i].discontinue) {
      if ((rbMin != rbMax && value >= rbMin && value < rbMax) || (rbMin == rbMax && value == rbMin))
        fcolor = getRangeColor(this.defSettings.range.gradient, bands, bands[i].color, rbMin, rbMax, value);
      if (Empty(fcolor) && i == bands.length - 1 && rbMin != rbMax && value >= rbMin && value <= rbMax)  // ultima fascia max potrebbe coincidere con estremo sup
        fcolor = getRangeColor(this.defSettings.range.gradient, bands, bands[i].color, rbMin, rbMax, value);
    }
  }
  return fcolor; 
}
StdChart.prototype.GetObjectFromRange = function (value, bands) {
  var rbMin = bands[0].minValue,
    rbMax = bands[bands.length - 1].maxValue;
  var fcolor = "",
    idx = -1;
  for (var i = 0; i < bands.length && Empty(fcolor); i++) {
    if (this.defSettings.range.gradient != "multi") {
      rbMin = bands[i].minValue;
      rbMax = bands[i].maxValue;
    }
    if (!bands[i].discontinue) {
      if ((rbMin != rbMax && value >= rbMin && value < rbMax) || (rbMin == rbMax && value == rbMin)) {
        fcolor = getRangeColor(this.defSettings.range.gradient, bands, bands[i].color, rbMin, rbMax, value);
        if (!Empty(fcolor))
          idx = i;
      }
      if (Empty(fcolor) && i == bands.length - 1 && rbMin != rbMax && value >= rbMin && value <= rbMax) {  // ultima fascia max potrebbe coincidere con estremo sup
        fcolor = getRangeColor(this.defSettings.range.gradient, bands, bands[i].color, rbMin, rbMax, value);
        if (!Empty(fcolor))
          idx = i;
      }
    }
  }
  if (Empty(fcolor))
    idx = -1;
  return { color: fcolor, indexBand: idx };
}
StdChart.prototype.GetImageAndIconFromRange = function (value, bands) {
  var rbMin = bands[0].minValue,
    rbMax = bands[bands.length - 1].maxValue;
  var fcolor = "",
    image = "",
    icon = "";
  for (var i = 0; i < bands.length && Empty(fcolor); i++) {
    if (this.defSettings.range.gradient != "multi") {
      rbMin = bands[i].minValue;
      rbMax = bands[i].maxValue;
    }
    if (!bands[i].discontinue) {
      if ((rbMin != rbMax && value >= rbMin && value < rbMax) || (rbMin == rbMax && value == rbMin)) {
        fcolor = getRangeColor(this.defSettings.range.gradient, bands, bands[i].color, rbMin, rbMax, value);
        if (!Empty(fcolor)) {
          image = bands[i].imageUrl;
          icon = bands[i].iconCode;
        }
      }
      if (Empty(fcolor) && i == bands.length - 1 && rbMin != rbMax && value >= rbMin && value <= rbMax) {  // ultima fascia max potrebbe coincidere con estremo sup
        fcolor = getRangeColor(this.defSettings.range.gradient, bands, bands[i].color, rbMin, rbMax, value);
        if (!Empty(fcolor)) {
          image = bands[i].imageUrl;
          icon = bands[i].iconCode;
        }
      }
    }
  }
  if (Empty(fcolor)) {
    image = "";
    icon = "";
  }
  return { color: fcolor, imageUrl: image, iconCode: icon };
}
StdChart.prototype.DrawValueLabels = function () {
  if (this.defSettings.valueLabel.show != "hide")
    this._DrawValueLabels();
  if (this.defSettings.valueLabel.totalLabel && this.defSettings.valueLabel.totalLabel.show)
    this._DrawTotalValueLabel();
}
StdChart.prototype.GetValueLabelMaxWord = function (/*dataset*/) {
  var txt = "";
  switch (this.defSettings.valueLabel.type) {
    case "label":
      txt = getMaxWordLength(this.orgCategoryList);
      break;
    case "value":
      txt = getMaxWordLength(this.allValues, this.rangeminmax.precision);
      break;
    case "perc":
    case "dperc":
      txt = "100%";
      break;
    case "ser":
      txt = getMaxWordLength(this.orgSeriesList);
      break;
    case "labelperc":
    case "dlabelperc":
      txt = getMaxWordLength(this.orgCategoryList) + " 100%";
      break;
    case "labelvalue":
      txt = getMaxWordLength(this.orgCategoryList) + " " + getMaxWordLength(this.allValues, this.rangeminmax.precision);
      break;
    case "valueperc":
    case "dvalueperc":
      txt = getMaxWordLength(this.allValues) + " (100%)";
      break;
    case "servalue":
      txt = getMaxWordLength(this.orgSeriesList) + " " + getMaxWordLength(this.allValues, this.rangeminmax.precision);
      break;
    case "serperc":
    case "dserperc":
      txt = getMaxWordLength(this.orgSeriesList) + " 100%";
      break;
    case "serlabel":
      txt = getMaxWordLength(this.orgSeriesList) + " " + getMaxWordLength(this.orgCategoryList);
      break;
    case "totperc":
      txt = "100% -- 100%";
      break;
  }
  return txt;
}
StdChart.prototype.SetRangeList = function () {
  var _this = this;

  if (this.defSettings.range.type == "none")
    return;

  if (this.defSettings.globals.width <= 0 || this.defSettings.globals.height <= 0)
    return;

  var mrange = [],
    userRange = [];
  if (this.objConfig.rangeBands)
    userRange = this.objConfig.rangeBands;
  else
    userRange = this.defSettings.range.custom;

  if (this.defSettings.range.type == "default")
    mrange = this.defSettings.range.default.slice();
  else if (!Empty(userRange) && userRange.length > 0) {
    if (this.defSettings.range.type != "none")
      mrange = userRange.slice();
  }

  var isDisc = getRangeContOrDisc(mrange),
    min = this.rangeminmax.min,
    max = this.rangeminmax.max;
  if (this.multipleScales) {
    min = 0;
    max = 0;
    for (var i = 0; i < this.valueFields.length; i++) {
      min = Math.min(min, d3.min(this[this.valueFields[i] + "_values"]));
      max = Math.max(max, d3.max(this[this.valueFields[i] + "_values"]));
    }
  }

  this.defSettings.range.discontinue = isDisc;
  mrange = getRangeBandsWithValues(mrange, min, max);
  mrange = getRangeOrd(mrange);
  if (this.defSettings.range.gradient != "none" && isDisc)
    this.defSettings.range.bands = getIntervalRange(mrange); // cosi' tutelo la discontinuita'
  else
    this.defSettings.range.bands = mrange;

  // a seconda del gradiente, sono le label o i ticks
  if (this.defSettings.range.gradient != "none") {
    var t = calcRangeTicks(min, max);
    this.defSettings.range.labels = t.values;
    this.defSettings.range.precision = t.prec;
  }
  else
    this.defSettings.range.labels = getListFromObjectArray(this.defSettings.range.bands, "label");

  if (this.defSettings.range.type != "none" && Empty(this.defSettings.range.bands)) // tutela mancata impostazione range
    this.defSettings.range.type = "none";

  function calcRangeTicks(min, max) {
    var precision = _this.rangeminmax.precision;
    if ((max - min) == 0)
      return { values: [_this.rangeminmax.max], precision: precision };
    var position = _this.defSettings.chartRangeLegend.position;
    if (Empty(_this.seriesList) && !Empty(_this.defSettings.range.bands) && position == "default")
      position = _this.defSettings.chartLegend.position;
    var appfont = appliedFont(_this.defSettings, _this.defSettings.chartRangeLegend, _this.defSettings.chartRangeLegend.textFont);
    var ticktextoffset = 2;
    var mis, tH;
    if (position == "top" || position == "bottom") {
      mis = _this.defSettings.globals.width * 0.75;
      tH = getOffsetWidth(getMaxWordLength([min, max], precision), appfont, _this.chartId) + ticktextoffset;
    }
    else {
      mis = _this.defSettings.globals.height * 0.75;
      tH = getOffsetHeight("W", appfont, _this.chartId) + ticktextoffset;
    }

    var mtick = parseFloat(((max - min) / (Math.round(mis / tH) - 2)).toFixed(precision)),  // 2 sono min e max
      ticks = setTicks(min, max, mtick, precision, true);

    if (ticks[ticks.length - 1] < max)
      ticks.push(max);

    return { values: ticks, prec: precision };
  }
}
StdChart.prototype.GetPrecisionFromDataSet = function (type) {
  var prec = 0;
  var myVal;
  if (type == "values")
    myVal = this.allValues;
  else if (type == "domain")
    myVal = this.categoryList;
  for (var i = 0; i < myVal.length; i++)
    prec = Math.max(prec, decimalPlaces(myVal[i]));
  return prec;
}
StdChart.prototype.CalculateChartMargins = function (datetimePict) {
  var valprec = this._GetValuesPrecision(),
    domprec = this._GetDomainPrecision();
  var chartM = this._GetChartMarginsObject(this.chartId, this.defSettings, this.categoryList, this.dataOrder, this.domainIsTime, this.domainIsNumber, this.localeLangFormat, datetimePict, this.chartLegends, this.allValues, valprec, domprec/*, excludedC, excludedS, defaultExcludedFont, rangebandslabels*/); // eslint-disable-line max-len
  this.genLabels.top = this.genLabels.top.concat(chartM.top);
  this.genLabels.bottom = this.genLabels.bottom.concat(chartM.bottom);
  this.genLabels.left = this.genLabels.left.concat(chartM.left);
  this.genLabels.right = this.genLabels.right.concat(chartM.right);
}
StdChart.prototype.GetItemClone = function (item) {
  return item.cloneNode();
}
StdChart.prototype.AppendHoverItem = function (item) {
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
        delete mRefChart._hoverItem;
      })
      .on("click", function () {
        _this._ApplyClick(itemObject, d3.mouse(this));
      });

    mRefChart._d3mouse = d3.mouse(item);
    mRefChart._d3event = d3.event;
    setTimeout(function (mRefChart, item, itemObject, clone) {
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
StdChart.prototype.ShowTooltip = function (chart, item, itemObject, isOther) {
  var itemObj;
  if (!isOther)
    itemObj = this._GetItemObj(itemObject);
  else
    itemObj = this._GetOtherItemObj(itemObject);
  itemObj.mouse = this._d3mouse ? this._d3mouse : undefined;
  if (Empty(itemObj.mouse)) {
    if (this._containerChart) {
      itemObj.mouse = this._containerChart._d3mouse ? this._containerChart._d3mouse : undefined;
    }
    else {
      itemObj.mouse = chart._d3mouse ? chart._d3mouse : undefined;
      if (Empty(itemObj.mouse))
        itemObj.mouse = d3.mouse(item);
    }
  }

  if (this.enableTooltips) {
    if (!Empty(d3.select("#" + this.chartId + "tooltipDiv").node())) {
      d3.select("#" + this.chartId + "tooltipDiv").style("display", "block")
      d3.select("#" + this.chartId + "tooltipI").attr("src", "")
        .style("overflow", "hidden")
        .style("visibility", "hidden")

    }
    else {
      d3.select(this.parent)
        .append("div")
        .attr("id", this.chartId + "tooltipDiv")
        .attr("class", "ztc_tooltipDiv")
        .style("position", "absolute")
        .style("z-index", "9999")
        .style("background-color", "transparent")
        .style("overflow", "hidden")
    }

    if (this._HasOverlap(itemObject) || this._ovrlap) {
      if (!Empty(this.linkObj) && this.linkObj.tooltipObj && !Empty(this.linkObj.tooltipObj.url))
        this.DrawCustomOverlapTooltip(itemObj, itemObject);
      else
        this.DrawDefaultOverlapTooltip(itemObj, itemObject);
    }
    else {
      var ttip_obj = this.GetTooltipObject(isOther);
      if (ttip_obj && !Empty(ttip_obj.url))
        this.DrawCustomTooltip(ttip_obj, itemObj);
      else
        this.DrawDefaultTooltip(itemObj, itemObject, isOther);
    }
  }

  if (window[this.chartId + "onElementMouseOver"])
    window[this.chartId + "onElementMouseOver"](itemObj);
  else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent) {
    var on_evt = this._ZtChart.parentCtrl.dispatchEvent('onElementMouseOver', d3.event, itemObj);
    if (!on_evt) {
      if (window[this.chartId + "ElementMouseOver"])
        window[this.chartId + "ElementMouseOver"](itemObj);
      else
        this._ZtChart.parentCtrl.dispatchEvent('ElementMouseOver', d3.event, itemObj);
    }
  }
}
StdChart.prototype.GetValuePicture = function (value) {
  var txt;
  if (this.defSettings.valueLabel.applyPicture) {
    txt = "";
    if (this.defSettings.valuePicture.prefix)
      txt = this.defSettings.valuePicture.prefix;
    if (!Empty(this.defSettings.valuePicture.picture))
      txt += Format(value, this.defSettings.valuePicture.picture);
    else
      txt += value;
    if (this.defSettings.valuePicture.suffix)
      txt += this.defSettings.valuePicture.suffix;
  }
  else
    txt = value;
  return txt;
}
StdChart.prototype.GetTotalValuePicture = function (value) {
  var txt;
  if (this.defSettings.valueLabel.applyPicture) {
    txt = "";
    /*if (this.defSettings.valuePicture.prefix)
      txt = this.defSettings.valuePicture.prefix;*/
    if (!Empty(this.defSettings.valuePicture.picture))
      txt += Format(value, this.defSettings.valuePicture.picture);
    else
      txt += value;
    /*if (this.defSettings.valuePicture.suffix)
      txt += this.defSettings.valuePicture.suffix;*/
  }
  else
    txt = value;
  return txt;
}
StdChart.prototype.GetValueLabelText = function (type, item, valueProp) {
  var txt = "", tot,
    value = item[valueProp],
    infinity = unescape("\u221E"),
    toPrint = this._EvaluatePrintValueLabel(type, item),
    format,
    val_txt = "";
  if (!toPrint)
    return txt;
  switch (type) {
    case "label":
      txt = item.category;
      if (this.domainIsTime) {
        format = this.stdFormat;
        if (!Empty(this.defSettings.time.customFormat) || !Empty(this.defSettings.time.format))
          format = getTimeTickFormat(this.localeLangFormat, this.defSettings.time.customFormat || this.defSettings.time.format);
        txt = format(txt);
      }
      break;
    case "ser":
      txt = item.series;
      break;
    case "value":
      // apply picture + funzione
      if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
        if (this.functionObj.GetValuePicture) {
          txt = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
        }
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.valuePrecision))
          value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
        txt = this.GetValuePicture(value);
      }
      break;
    case "perc":
      tot = this.totalsSeries[item.valueField].sum;
      if (tot == 0) {
        if (value < 0)
          txt = "-" + infinity + "%";
        else if (value > 0)
          txt = infinity + "%";
        else
          txt = this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt = this.GetValuePicture(value) + "%";
      }
      break;
    case "dperc":
      tot = this.totalsSeries.categoriesT[item.sidx];
      if (tot == 0) {
        if (value < 0)
          txt = "-" + infinity + "%";
        else if (value > 0)
          txt = infinity + "%";
        else
          txt = this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt = this.GetValuePicture(value) + "%";
      }
      break;
    case "labelvalue":
      //if (!isNaN(this.defSettings.valueLabel.valuePrecision))
      //value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
      txt = item.category + " "/* + this.GetValuePicture(value)*/;
      if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
        if (this.functionObj.GetValuePicture) {
          txt += this.functionObj.GetValuePicture(this._GetItemForGrid(item));
        }
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.valuePrecision))
          value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
        txt += this.GetValuePicture(value);
      }
      break;
    case "servalue":
      //if (!isNaN(this.defSettings.valueLabel.valuePrecision))
      //value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
      txt = item.series + " "/* + this.GetValuePicture(value)*/;
      if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
        if (this.functionObj.GetValuePicture) {
          txt += this.functionObj.GetValuePicture(this._GetItemForGrid(item));
        }
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.valuePrecision))
          value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
        txt += this.GetValuePicture(value);
      }
      break;
    case "serlabel":
      txt = item.series + " " + item.category;
      break;
    case "labelperc":
      tot = this.totalsSeries[item.valueField].sum;
      txt = item.category + " ";
      if (tot == 0) {
        if (value < 0)
          txt += "-" + infinity + "%";
        else if (value > 0)
          txt += infinity + "%";
        else
          txt += this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt += this.GetValuePicture(value) + "%";
      }
      break;
    case "dlabelperc":
      tot = this.totalsSeries.categoriesT[item.sidx];
      txt = item.category + " "; 
      if (tot == 0) {
        if (value < 0)
          txt += "-" + infinity + "%";
        else if (value > 0)
          txt += infinity + "%";
        else
          txt += this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt += this.GetValuePicture(value) + "%";
      }
      break;
    case "valueperc":
      /*if (!isNaN(this.defSettings.valueLabel.valuePrecision)) {
        val_txt = value;
        val_txt = val_txt.toFixed(this.defSettings.valueLabel.valuePrecision);
      }*/
      if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
        if (this.functionObj.GetValuePicture) {
          txt = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
        }
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.valuePrecision))
          value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
        txt = this.GetValuePicture(value);
      }

      txt += " (";
      tot = this.totalsSeries[item.valueField].sum;
      if (tot == 0) {
        if (value < 0)
          txt += "-" + infinity + "%";
        else if (value > 0)
          txt += infinity + "%";
        else // =0
          txt += /*this.GetValuePicture(val_txt) +*/ "0%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt += this.GetValuePicture(value) + "%";
      }
      txt += ")";
      break;
    case "dvalueperc":
      tot = this.totalsSeries.categoriesT[item.sidx];
      /*if (!isNaN(this.defSettings.valueLabel.valuePrecision)) {
        val_txt = value;
        val_txt = val_txt.toFixed(this.defSettings.valueLabel.valuePrecision);
      }*/
      if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
        if (this.functionObj.GetValuePicture) {
          txt = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
        }
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.valuePrecision))
          value = value.toFixed(this.defSettings.valueLabel.valuePrecision);
        txt = this.GetValuePicture(value);
      }
      txt += /*this.GetValuePicture(val_txt) + */" (";
      if (tot == 0) {
        if (value < 0)
          txt += "-" + infinity + "%";
        else if (value > 0)
          txt += infinity + "%";
        else // =0
          txt += /*this.GetValuePicture(val_txt) +*/ "0%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt += this.GetValuePicture(value) + "%";
      }
      txt += ")";
      break;
    case "serperc":
      tot = this.totalsSeries[item.valueField].sum;
      txt = item.series + " ";
      if (tot == 0) {
        if (value < 0)
          txt += "-" + infinity + "%";
        else if (value > 0)
          txt += infinity + "%";
        else
          txt += this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt += this.GetValuePicture(value) + "%";
      }
      break;
    case "dserperc":
      tot = this.totalsSeries.categoriesT[item.sidx];
      txt = item.series + " ";
      if (tot == 0) {
        if (value < 0)
          txt += "-" + infinity + "%";
        else if (value > 0)
          txt += infinity + "%";
        else
          txt += this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          value = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          value = Math.round((value * 100) / tot);

        txt += this.GetValuePicture(value) + "%";
      }
      break;
    case "totperc":
      tot = this.totalsSeries[item.valueField].sum;
      var tot2 = this.totalsSeries.categoriesT[item.sidx];
      if (tot == 0) {
        if (value < 0)
          txt = "-" + infinity + "%";
        else if (value > 0)
          txt = infinity + "%";
        else
          txt = this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          val_txt = ((value * 100) / tot).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          val_txt = Math.round((value * 100) / tot);

        txt += this.GetValuePicture(val_txt) + "%";
      }
      txt += " -- ";
      if (tot2 == 0) {
        if (value < 0)
          txt += "-" + infinity + "%";
        else if (value > 0)
          txt += infinity + "%";
        else
          txt += this.GetValuePicture(value) + "%";
      }
      else {
        if (!isNaN(this.defSettings.valueLabel.percPrecision))
          val_txt = ((value * 100) / tot2).toFixed(this.defSettings.valueLabel.percPrecision);
        else
          val_txt = Math.round((value * 100) / tot2);

        txt += this.GetValuePicture(val_txt) + "%";
      }
      break;
  }
  return txt;
}
StdChart.prototype.SetAggregateData = function () {
  if (this.dataSet.constructor != Array)
    return;
  if (Empty(this.functionObj.GetAggregateData) && !this.objConfig.dataOthers)
    return;

  this.aggregateData = {};
  var tmp = this.dataSet.slice(),
    aLabel = Empty(this.objConfig.dataOthers.desc) ? "( " + this.Translate("ZTC_OTHERS") + " )" : this.objConfig.dataOthers.desc,
    totseries = 0,
    mobja,
    mapremoved = [];

  /** label **/
  tmp.push([]);
  tmp[tmp.length - 1][this.xIndex] = aLabel;
  if (!Empty(this.objConfig.keyField))
    tmp[tmp.length - 1][this.xLabelIndex] = aLabel;

  if (this.functionObj.GetAggregateData) {
    var item, i, j;

    /** dati **/
    for (j = 0; j < this.valueFields.length; j++) {
      y_index = this.propertyName.indexOf(this.valueFields[j]);
      if (y_index >= 0) {
        totseries++;
        this.aggregateData[this.valueFields[j]] = {};
        this.aggregateData[this.valueFields[j]].perc = pcalc;
        this.aggregateData[this.valueFields[j]].val = [];
        this.aggregateData[this.valueFields[j]].recs = [];
        mobja = this.aggregateData[this.valueFields[j]].val;
        tmp[tmp.length - 1][y_index] = 0;

        for (i = 0; i < this.dataSet.length; i++) {
          if (!mapremoved[i])
            mapremoved[i] = 0;
          item = {};
          item.category = this.dataSet[i][this.xIndex];
          if (!Empty(this.objConfig.keyField)) {
            item.category = this.dataSet[i][this.xLabelIndex];
            item.keyField = this.dataSet[i][this.xIndex];
          }
          item.value = this.dataSet[i][y_index];
          item.columnIndex = y_index;
          item.rowIndex = i;
          item.column = this.valueFields[j];

          if (this.functionObj.GetAggregateData(item)) {
            mobja.push({});
            this.aggregateData[this.valueFields[j]].recs.push(this.dataSet[i].slice());
            mobja[mobja.length - 1].category = this.dataSet[i][this.xIndex];
            if (!Empty(this.objConfig.keyField)) {
              mobja[mobja.length - 1].category = this.dataSet[i][this.xLabelIndex];
              mobja[mobja.length - 1].keyField = this.dataSet[i][this.xIndex];
            }
            mobja[mobja.length - 1].value = this.dataSet[i][y_index];
            tmp[tmp.length - 1][y_index] += this.dataSet[i][y_index];
            tmp[i][y_index] = null;
            mapremoved[i]++;
          }
        }
      }

      if (j == this.valueFields.length - 1) {
        for (i = mapremoved.length - 1; i >= 0; i--) {
          if (mapremoved[i] == totseries)
            tmp.splice(i, 1);
        }
      }
    }
  }
  else if (!Empty(this.objConfig.dataOthers.value)) {
    var mperc = 0,
      y_index = -1,
      pcalc,
      lcalc;

    /** dati **/
    for (j = 0; j < this.valueFields.length; j++) {
      y_index = this.propertyName.indexOf(this.valueFields[j]);
      if (Empty(this.objConfig.dataOthers.value[j]) && this.objConfig.dataOthers.value[j] != 0)
        this.objConfig.dataOthers.value[j] = this.objConfig.dataOthers.value[j - 1];
      lcalc = this.objConfig.dataOthers.value[j];
      if (Empty(this.objConfig.dataOthers.isPerc[j]) && this.objConfig.dataOthers.isPerc[j] != false)
        this.objConfig.dataOthers.isPerc[j] = this.objConfig.dataOthers.isPerc[j - 1];
      pcalc = this.objConfig.dataOthers.isPerc[j];

      if (y_index >= 0) {
        totseries++;
        this.aggregateData[this.valueFields[j]] = {};
        this.aggregateData[this.valueFields[j]].perc = pcalc;
        this.aggregateData[this.valueFields[j]].val = [];
        this.aggregateData[this.valueFields[j]].recs = [];
        mobja = this.aggregateData[this.valueFields[j]].val;
        tmp[tmp.length - 1][y_index] = 0;

        for (i = 0; i < this.dataSet.length; i++) {
          if (!mapremoved[i])
            mapremoved[i] = 0;
          if (pcalc)
            mperc = (this.dataSet[i][y_index] * 100) / this.totalsSeries[this.valueFields[j]].abs;
          else
            mperc = this.dataSet[i][y_index];
          if (mperc < lcalc) {
            mobja.push({});
            this.aggregateData[this.valueFields[j]].recs.push(this.dataSet[i].slice());
            mobja[mobja.length - 1].category = this.dataSet[i][this.xIndex];
            if (!Empty(this.objConfig.keyField)) {
              mobja[mobja.length - 1].category = this.dataSet[i][this.xLabelIndex];
              mobja[mobja.length - 1].keyField = this.dataSet[i][this.xIndex];
            }
            mobja[mobja.length - 1].value = this.dataSet[i][y_index];
            if (pcalc)
              mobja[mobja.length - 1].percentage = mperc.toFixed(2) + "%";
            tmp[tmp.length - 1][y_index] += this.dataSet[i][y_index];
            tmp[i][y_index] = null;
            mapremoved[i]++;
          }
        }
      }

      if (j == this.valueFields.length - 1) {
        for (i = mapremoved.length - 1; i >= 0; i--) {
          if (mapremoved[i] == totseries)
            tmp.splice(i, 1);
        }
      }
    }
  }

  this.dataSet = tmp.slice();

  if (mapremoved.every(zeroFilledArray)) {
    this.dataSet.splice(this.dataSet.length - 1, 1);
    delete this.aggregateData;
  }
  else {
    this._SetInReferredList(aLabel);
    this._ResetLists();
    this.aggregateData.label = aLabel;
  }

  mapremoved = null;
  tmp = null;

  this._SetCategoryList();
}
StdChart.prototype.SetTotalsData = function () { }
StdChart.prototype.DrawNegativePattern = function () {
  if (!Empty(d3.select("#" + this.chartId + "negativeValuePattern").node()))
    return;
  var _this = this;
  d3.select("#" + this.__cID + "d3ChartDefs")
    .append('pattern')
    .attr("id", this.chartId + "negativeValuePattern")
    .attr('patternUnits', 'userSpaceOnUse');
  if (!this.defSettings.patterns)
    return this.DrawDefaultNegativePattern();
  if (!this.defSettings.patterns.negative)
    return this.DrawDefaultNegativePattern();
  var filename = Strtran(this.defSettings.patterns.negative.type, " ", "-") + ".pattern";
  if (Empty(this.defSettings.patterns.negative.color))
    this.defSettings.patterns.negative.color = "#000000";

  d3.xml(this.GetWebRootURL() + "/chart/patterns/" + filename).mimeType("image/svg+xml").get(function (error, xml) {
    if (error)
      return _this.DrawDefaultNegativePattern();
    d3.select("#" + _this.chartId + "negativeValuePattern")
      .attr('width', d3.select(xml.documentElement).attr("width"))
      .attr('height', d3.select(xml.documentElement).attr("height"));
    var m = d3.select("#" + _this.chartId + "negativeValuePattern"),
      node;
    for (var i = 0; i < xml.documentElement.childNodes.length; i++) {
      node = xml.documentElement.childNodes[i];
      recursiveNodePattern(node, _this.defSettings.patterns.negative.color);
    }
    m.node().appendChild(m.node().ownerDocument.importNode(xml.documentElement, true));
  });
}
StdChart.prototype.DrawDefaultNegativePattern = function () {
  var _this = this;
  if (Empty(d3.select("#" + _this.chartId + "negativeValuePattern").node())) {
    d3.select("#" + _this.__cID + "d3ChartDefs")
      .append('pattern')
      .attr("id", _this.chartId + "negativeValuePattern")
      .attr('patternUnits', 'userSpaceOnUse');
  }
  if (Empty(_this.defSettings.patterns.negative.color))
    _this.defSettings.patterns.negative.color = "#000000";
  d3.select("#" + this.chartId + "negativeValuePattern")
    .attr('width', 9/*4*/)
    .attr('height', 9/*4*/)
    .append('circle')
    .attr('cx', 5)
    .attr('cy', 5)
    .attr('r', 5)
    //.style('fill', "transparent")
    .style('fill-opacity', 0)
    .style('stroke', _this.defSettings.patterns.negative.color)
    .style('stroke-width', "1px");
  /*.append('path')
    .attr('d', 'M-1,1 l2,-2 M0,4 l4,-4 M3,5 l2,-2')
    .attr('stroke', '#0D0F12')
    .attr('stroke-width', 1);*/
  //}
}
StdChart.prototype.DrawOutRangePattern = function (fillColor /*hex*/) {
  var fcolor = fillColor.slice(1);
  if (!Empty(this.defSettings.patterns.outrange.color))
    fcolor = this.defSettings.patterns.outrange.color;
  if (Empty(d3.select("#" + this.chartId + "outRangePattern_" + fcolor).node())) {
    d3.select("#" + this.__cID + "d3ChartDefs")
      .append('pattern')
      .attr("id", this.__cID + "outRangePattern_" + fcolor)
      .attr('patternUnits', 'userSpaceOnUse')

    if (!this.defSettings.patterns)
      return this.DrawDefaultOutRangePattern(fillColor);
    if (!this.defSettings.patterns.outrange)
      return this.DrawDefaultOutRangePattern(fillColor);

    var filename = Strtran(this.defSettings.patterns.outrange.type, " ", "-") + ".pattern";
    if (Empty(fcolor))
      fcolor = "#000000";

    var _this = this;
    d3.xml("../chart/patterns/" + filename).mimeType("image/svg+xml").get(function (error, xml) {
      if (error)
        return _this.DrawDefaultOutRangePattern(fillColor);
      d3.select("#" + _this.chartId + "outRangePattern_" + fcolor)
        .attr('width', xml.documentElement.width.baseVal.value)
        .attr('height', xml.documentElement.height.baseVal.value);
      var m = d3.select("#" + _this.chartId + "outRangePattern_" + fcolor),
        node;
      for (var i = 0; i < xml.documentElement.childNodes.length; i++) {
        node = xml.documentElement.childNodes[i];
        recursiveNodePattern(node, fcolor);
      }
      m._groups[0][0].appendChild(m._groups[0][0].ownerDocument.importNode(xml.documentElement, true));
    });
  }
}
StdChart.prototype.DrawDefaultOutRangePattern = function (fillColor /*hex*/) {
  var fcolor = fillColor.slice(1);
  if (!Empty(this.defSettings.patterns.outrange.color))
    fcolor = this.defSettings.patterns.outrange.color;
  d3.select("#" + this.chartId + "outRangePattern_" + fcolor)
    .attr('width', 4)
    .attr('height', 4)
    .append('path')
    .attr('d', 'M 0,0 6,0')
    .style('stroke', fcolor)
    .style('stroke-width', 4);
}
StdChart.prototype.ApplyPatternOnItem = function (itemObject, patternType) {
  if (Empty(d3.select("#" + this.chartId + patternType).node()))
    return;

  if (itemObject.itm) {
    var clone = this.GetItemClone(itemObject.itm),
      _this = this;
    d3.select(clone)
      .attr("item-type", "pattern")
      .attr("item-index", d3.select(itemObject.itm).attr("item-index"))
      .style("fill", "url(#" + this.chartId + patternType + ")")
      .on("mouseenter", function () {
        _this._ApplyMouseOver(this);
      });
    itemObject.itm.parentNode.appendChild(clone);
  }
}
StdChart.prototype.ClearHoverTimeout = function () {
  if (this.toolTipTimeout) {
    clearTimeout(this.toolTipTimeout);
    delete this.toolTipTimeout;
  }
}
StdChart.prototype.RemoveHoverTimeout = function () {
  var _this = this;
  this.ClearHoverTimeout();
  if (Empty(this.hoverTimeout))
    this.hoverTimeout = 500;
  this.toolTipTimeout = setTimeout(function () {
    _this.RemoveAllHovers();
    _this.MoveRangeCursor(null, true);
  }, this.hoverTimeout);
}
StdChart.prototype.ShowUrlTooltip = function (x, y, w, h, url, timeout) {
  if (Empty(w))
    w = 'auto';
  else
    w = w + "px";
  if (Empty(h))
    h = 'auto';
  else
    h = h + "px";

  var _this = this, //._ZtChart.StdChart;
    pleft = getX(_this.parent);
  _this.hoverTimeout = timeout;

  d3.select("#" + _this.chartId + "tooltipDiv")
    .attr("par-left", pleft)
    .style("left", (x /*- getX(_this.parent)*/) + 'px')
    .style("top", (y /*- getY(_this.parent)*/) + 'px')
    .style("width", w)
    .style("height", h)
    .on("mouseenter", function () {
      _this.ClearHoverTimeout();
    })
    .on("mouseleave", function () {
      _this.RemoveHoverTimeout();
    })

  var tContainer = null;
  if (!Empty(d3.select("#" + _this.chartId + "tooltipI").node())) {
    tContainer = d3.select("#" + _this.chartId + "tooltipI")
  }
  else {
    tContainer = d3.select("#" + _this.chartId + "tooltipDiv")
      .append("IFRAME")
      .attr("id", _this.chartId + "tooltipI")
      .attr("name", _this.chartId + "tooltipI")
      .attr("border", 1)
      .attr("frameborder", 0)
      .attr("width", 100 + "%")
      .attr("height", 100 + "%")
      .style("overflow", "hidden")
      .style("visibility", "hidden")
  }

  tContainer.attr("src", url)
    .on("load", function () {
      this.style.visibility = "visible";
      this.contentDocument.body.onmouseleave = function () {
        _this.RemoveHoverTimeout();
      }
    });
}
StdChart.prototype.DrawDefaultTooltip = function (item, itemObject, isOther) {
  var evt = this._d3event ? this._d3event : undefined,
    chart = this._ZtChart.StdChart;
  if (Empty(evt)) {
    if (this._containerChart) {
      evt = this._containerChart._d3event ? this._containerChart._d3event : undefined;
    }
    else {
      evt = chart._d3event ? chart._d3event : undefined;
      if (Empty(evt))
        evt = d3.event;
    }
  }
  var evtpos = { x: evt.offsetX, y: evt.offsetY },
    //evtpos = { x : evt.pageX, y : evt.pageY },
    _this = this._ZtChart.StdChart,
    portlet = "/jsp-system/SPChartTooltips_portlet.jsp",
    webroot = _this.GetWebRootURL(),
    purl = "",
    col;

  var epos = eventPos(evt);
  evtpos.x = epos.x - getX(_this.parent);
  evtpos.y = epos.y - getY(_this.parent) + getScrollTop(_this.parent);

  if (!isOther) {
    // prop base (categorie, serie e valori) differenziate x tipo chart
    purl = this._GetParametersStringForTooltip(item, itemObject);
    // keyfield
    if (!Empty(itemObject.keyField)) {
      var kval = itemObject.keyField,
        key_time = _this.domainIsTime && IsA(kval, 'D');
      if (key_time) {
        var format = _this.stdFormat;
        if (!Empty(_this.defSettings.time.customFormat) || !Empty(_this.defSettings.time.format))
          format = getTimeTickFormat(_this.localeLangFormat, _this.defSettings.time.customFormat || _this.defSettings.time.format);
        kval = format(kval);
      }

      purl += "&key=" + URLenc(kval);
    }
    // range band + colore
    if (!Empty(itemObject.range))
      purl += "&range=" + URLenc(_this.defSettings.range.bands[itemObject.rangeIdx].label);
    if (this.defSettings.range && !Empty(this.defSettings.range.bands) && this.defSettings.range.applyColor && !itemObject.isNull) {
      if (!Empty(itemObject.color) && !Empty(itemObject.color.color) && !Empty(itemObject.series))
        purl += "&cseries=" + URLenc(itemObject.color.color.slice(1));
    }
    // colore elemento
    if (!Empty(itemObject.color) && !Empty(itemObject.color.color)) {
      col = "";
      if (!Empty(itemObject.colorApplied))
        col = itemObject.colorApplied;
      else
        col = itemObject.color.color;
      if (col.charAt(0) == "#")
        col = col.slice(1);
      purl += "&color=" + URLenc(col);
    }
    else if (!Empty(itemObject.colorApplied)) {
      col = itemObject.colorApplied;
      if (col.charAt(0) == "#")
        col = col.slice(1);
      purl += "&color=" + URLenc(col);
    }
    // multidim chiave
    if (!Empty(this.appliedKey)) {
      purl += "&multikey=" + URLenc(this.appliedKey);
      //purl += "&multikeyvalue=" + URLenc(this.chartTitle);
    }
  }
  else
    purl = this._GetParametersOtherForTooltip(item);

  // id + tipo
  purl += "&id=" + URLenc(this.chartId);
  purl += "&type=" + URLenc(this.type);

  if (purl.charAt(0) == "&")
    purl = "?" + purl.slice(1);

  try {
    this.ShowUrlTooltip(evtpos.x, evtpos.y, null, null, webroot + portlet + purl);
  }
  catch (e) { }
}
StdChart.prototype.DrawCustomTooltip = function (tooltipObj, itemObj) {
  var evt = this._d3event ? this._d3event : undefined,
    chart = this._ZtChart.StdChart;
  if (Empty(evt)) {
    if (this._containerChart) {
      evt = this._containerChart._d3event ? this._containerChart._d3event : undefined;
    }
    else {
      evt = chart._d3event ? chart._d3event : undefined;
      if (Empty(evt))
        evt = d3.event;
    }
  }
  var evtpos = { x: evt.offsetX, y: evt.offsetY },
    _this = this._ZtChart.StdChart,
    webroot = _this.GetWebRootURL(),
    portlet = "/jsp/" + tooltipObj.url,
    murl;

  var epos = eventPos(evt);
  evtpos.x = epos.x - getX(_this.parent);
  evtpos.y = epos.y - getY(_this.parent) + getScrollTop(_this.parent);

  murl = webroot + portlet;

  if (tooltipObj.url.indexOf("http://") >= 0 || tooltipObj.url.indexOf("https://") >= 0 || tooltipObj.url.indexOf(webroot) >= 0)
    murl = tooltipObj.url;

  var purl = makeParameterStringFromLinkObj(murl, "link", this.linkObj, itemObj, _this);
  try {
    var tx = tooltipObj.x || evtpos.x,
      ty = tooltipObj.y || evtpos.y;
    this.ShowUrlTooltip(tx, ty, tooltipObj.width, tooltipObj.height, purl);
  }
  catch (e) { }
}
StdChart.prototype.DrawDefaultOverlapTooltip = function (item, itemObject) {
  var evt = this._d3event ? this._d3event : undefined,
    chart = this._ZtChart.StdChart;
  if (Empty(evt)) {
    if (this._containerChart) {
      evt = this._containerChart._d3event ? this._containerChart._d3event : undefined;
    }
    else {
      evt = chart._d3event ? chart._d3event : undefined;
      if (Empty(evt))
        evt = d3.event;
    }
  }
  var evtpos = { x: evt.offsetX, y: evt.offsetY },
    //evtpos = { x : evt.pageX, y : evt.pageY },
    _this = this._ZtChart.StdChart,
    portlet = "/jsp-system/SPChartOverlayTooltips_portlet.jsp",
    webroot = _this.GetWebRootURL(),
    purl = "";

  var epos = eventPos(evt);
  evtpos.x = epos.x - getX(_this.parent);
  evtpos.y = epos.y - getY(_this.parent) + getScrollTop(_this.parent);

  // prop differenziate x tipo chart
  purl = this._GetParametersStringForOverlapTooltip(item, itemObject);

  // multidim chiave
  if (!Empty(this.appliedKey)) {
    purl += "&multikey=" + URLenc(this.appliedKey);
    //purl += "&multikeyvalue=" + URLenc(this.chartTitle);
  }

  // id + tipo
  purl += "&id=" + URLenc(this.chartId);
  purl += "&type=" + URLenc(this.type);

  if (purl.charAt(0) == "&")
    purl = "?" + purl.slice(1);

  try {
    this.ShowUrlTooltip(evtpos.x, evtpos.y, null, null, webroot + portlet + purl);
  }
  catch (e) { }
}
StdChart.prototype.DrawDefaultOverlapClick = function (itemObject) {
  var evt = this._d3event ? this._d3event : undefined,
    chart = this._ZtChart.StdChart;
  if (Empty(evt)) {
    if (this._containerChart) {
      evt = this._containerChart._d3event ? this._containerChart._d3event : undefined;
    }
    else {
      evt = chart._d3event ? chart._d3event : undefined;
      if (Empty(evt))
        evt = d3.event;
    }
  }
  var evtpos = { x: evt.offsetX, y: evt.offsetY },
    //evtpos = { x : evt.pageX, y : evt.pageY },
    _this = this._ZtChart.StdChart,
    portlet = "/jsp-system/SPChartOverlayClick_portlet.jsp",
    webroot = _this.GetWebRootURL(),
    purl = "";

  var epos = eventPos(evt);
  evtpos.x = epos.x - getX(_this.parent);
  evtpos.y = epos.y - getY(_this.parent) + getScrollTop(_this.parent);

  // prop differenziate x tipo chart
  purl = this._GetParametersStringForOverlapClick(itemObject);

  // id + tipo
  purl += "&id=" + URLenc(this.chartId);
  purl += "&type=" + URLenc(this.type);

  if (purl.charAt(0) == "&")
    purl = "?" + purl.slice(1);

  try {
    this.ShowUrlTooltip(evtpos.x, evtpos.y, null, null, webroot + portlet + purl);
  }
  catch (e) { }
}
StdChart.prototype.DrawCustomOverlapTooltip = function (item, itemObject) {
  var evt = this._d3event ? this._d3event : undefined,
    chart = this._ZtChart.StdChart;
  if (Empty(evt)) {
    if (this._containerChart) {
      evt = this._containerChart._d3event ? this._containerChart._d3event : undefined;
    }
    else {
      evt = chart._d3event ? chart._d3event : undefined;
      if (Empty(evt))
        evt = d3.event;
    }
  }

  var evtpos = { x: evt.offsetX, y: evt.offsetY },
    //evtpos = { x : evt.pageX, y : evt.pageY },
    _this = this._ZtChart.StdChart,
    webroot = _this.GetWebRootURL(),
    portlet = "/jsp/" + this.linkObj.tooltipObj.url,
    murl;

  var epos = eventPos(evt);
  evtpos.x = epos.x - getX(_this.parent);
  evtpos.y = epos.y - getY(_this.parent) + getScrollTop(_this.parent);

  murl = webroot + portlet;

  if (this.linkObj.tooltipObj.url.indexOf("http://") >= 0 || this.linkObj.tooltipObj.url.indexOf("https://") >= 0 || this.linkObj.tooltipObj.url.indexOf(webroot) >= 0)
    murl = this.linkObj.tooltipObj.url;

  var purl = makeParameterStringFromOverlapLinkObj(murl, "link", this.linkObj, itemObject, _this);
  try {
    var tx = this.linkObj.tooltipObj.x || evtpos.x,
      ty = this.linkObj.tooltipObj.y || evtpos.y;
    this.ShowUrlTooltip(tx, ty, this.linkObj.tooltipObj.width, this.linkObj.tooltipObj.height, purl);
  }
  catch (e) { }
}
StdChart.prototype.Animate = function (lastValueObj) {
  this.animationDelay = 0;
  if (this.drawStatic || !this.defSettings.animation || !this.defSettings.animation.animate) {
    this._NotAnimatedChartElements();
    return;
  }
  this.animationDelay = this.defSettings.animation.duration + this.plusDelay;
  this._AnimateChartElements(lastValueObj);
}
StdChart.prototype.DrawAxisReference = function (axisType, axisPosition, container, axisX, coordX, coordY, color) {
  if (!this./*_ZtChart.StdChart.*/defSettings[axisType + "Axis"].show)
    return;

  coordY = coordY + 0.5;  // dovuto allo stroke del tick

  if (axisPosition == "left") {
    container.append("line")
      .attr("class", "axisRefLine")
      .attr("x1", coordX)
      .attr("x2", coordX)
      .attr("y1", coordY)
      .attr("y2", coordY)
      .style("stroke-linecap", "butt")
      .style("stroke-dasharray", "2,2")
      .style("stroke", color)
      .style("shape-rendering", "crispEdges")
      .transition()
      .duration(this.defSettings.animation.duration)
      .attr("x1", axisX);
  }
  else if (axisPosition == "bottom") {
    container.append("line")
      .attr("class", "axisRefLine")
      .attr("x1", coordX)
      .attr("x2", coordX)
      .attr("y1", coordY)
      .attr("y2", coordY)
      .style("stroke-linecap", "butt")
      .style("stroke-dasharray", "2,2")
      .style("stroke", color)
      .style("shape-rendering", "crispEdges")
      .transition()
      .duration(this.defSettings.animation.duration)
      .attr("y2", this.chartHeight);
  }
  else if (axisPosition == "right") {
    container.append("line")
      .attr("class", "axisRefLine")
      .attr("x1", coordX)
      .attr("x2", coordX)
      .attr("y1", coordY)
      .attr("y2", coordY)
      .style("stroke-linecap", "butt")
      .style("stroke-dasharray", "2,2")
      .style("stroke", color)
      .style("shape-rendering", "crispEdges")
      .transition()
      .duration(this.defSettings.animation.duration)
      .attr("x1", this.chartWidth);
  }
}
StdChart.prototype.SetTitlesPositions = function (id, text, item) {
  var x, y,
    font = appliedFont(this.defSettings, item, item.textFont),
    textAnch = "middle",
    oheight = getOffsetHeight(text, font, this.chartId);

  this.svg.append("text").attr("id", id);
  if (item.position == "left") {
    if (item.alignment == "left") {
      x = - this.defSettings.globals.height + this.marginOffsetY / 2;
      textAnch = "start";
    }
    else if (item.alignment == "right") {
      x = - this.marginOffsetY / 2;
      textAnch = "end";
    }
    else
      x = - (this.defSettings.globals.height / 2);
    y = oheight + this.marginOffsetX / 2;
    this.svg.select("#" + id)
      .attr("transform", "rotate(-90)");
  }
  else if (item.position == "right") {
    if (item.alignment == "left") {
      x = - this.defSettings.globals.height + this.marginOffsetY / 2;
      textAnch = "start";
    }
    else if (item.alignment == "right") {
      x = - this.marginOffsetY / 2;
      textAnch = "end";
    }
    else
      x = - (this.defSettings.globals.height / 2);
    y = this.defSettings.globals.width - this.marginOffsetX / 2;
    this.svg.select("#" + id)
      .attr("transform", "rotate(-90)");
  }
  else if (item.position == "bottom") {
    if (item.alignment == "left") {
      x = this.marginOffsetX / 2;
      textAnch = "start";
    }
    else if (item.alignment == "right") {
      x = this.defSettings.globals.width - this.marginOffsetX / 2;
      textAnch = "end";
    }
    else
      x = (this.defSettings.globals.width / 2);
    y = this.defSettings.globals.height - this.marginOffsetY / 2;
  }
  else {  // top
    if (item.alignment == "left") {
      x = this.marginOffsetX / 2;
      textAnch = "start";
    }
    else if (item.alignment == "right") {
      x = this.defSettings.globals.width - this.marginOffsetX / 2;
      textAnch = "end";
    }
    else
      x = (this.defSettings.globals.width / 2);
    y = oheight + this.marginOffsetY / 2;
  }
  this.svg.select("#" + id)
    .attr("x", x)
    .attr("y", y)
    .style("text-anchor", textAnch)
    .text(text);
}
StdChart.prototype.OpenLink = function (itemObj) {
  if (this.drawStatic)
    return;
  var _this = this._ZtChart.StdChart;
  if (!Empty(this.linkObj) && !Empty(this.linkObj.url)) {
    var url = "";
    if (this.linkObj.urlType == "link") {
      url = this.GetWebRootURL();
      if (this.linkObj.url.indexOf("http://") >= 0 || this.linkObj.url.indexOf("https://") >= 0 || this.linkObj.url.indexOf(url) >= 0)
        url = "";
      else
        url += "/jsp/";
    }
    url += makeParameterStringFromLinkObj(this.linkObj.url, this.linkObj.urlType, this.linkObj, itemObj, _this);
    if (this.linkObj.urlType == 'link') {
      if (CharToBool(this.linkObj.popup + "")) {
        if (this.linkObj.popup_type == "popup") {
          windowOpenForeground(url, this.linkObj.target, 'height=' + this.linkObj.popup_height + ',width=' + this.linkObj.popup_width, null, null, null, 2);
        }
        else {
          var wtype,
            add = 'left=50,top=50' + (Empty(this.linkObj.popup_height) ? '' : ',height=' + this.linkObj.popup_height)
              + (Empty(this.linkObj.popup_width) ? '' : ',width=' + this.linkObj.popup_width)
              + ',status=no,toolbar=no,menubar=no,location=no,resizable=yes',
            name = (Empty(this.linkObj.target) || this.linkObj.target == '_blank') ? ('' + new Date().getTime()) : this.linkObj.target;
          if (this.linkObj.popup_type == "layer")
            wtype = 1;
          layerOpenForeground(url, name, add, this.linkObj.popup_width, this.linkObj.popup_height, null, wtype);
        }
      }
      else {
        window.location.href = url;
      }
    }
    else if (this.linkObj.urlType == 'script') {
      try {
        eval(url);
      }
      catch (e) { }
    }
  }
}
StdChart.prototype.GetSelectedItems = function () {
  var _this = this;
  var myItems = this._GetItems().filter(function (item) {
    item.multidimCurrentKey = _this.appliedKey;
    var fkval = (_this.applyFocusKey && item.focus) || (!_this.applyFocusKey && !item.focus)
    return item.isSelected && fkval;
  });
  return myItems;
}
StdChart.prototype.GetNotSelectedItems = function () {
  var _this = this;
  var myItems = this._GetItems().filter(function (item) {
    item.multidimCurrentKey = _this.appliedKey;
    return !item.isSelected;
  });
  return myItems;
}
StdChart.prototype.ApplySelectionsObjects = function (itemObjects) {
  for (var i = 0; i < itemObjects.length; i++) {
    delete itemObjects[i].itm;
    this._SelectItem(itemObjects[i], itemObjects[i].isSelected)
  }
}
StdChart.prototype.AfterDraw = function () {
  this.ApplyColors();
  this.ApplyFonts();
  this.SetFontsInSVG();
  this.AdjustPositions();
  this._ApplyEvents();
  this.ApplyRangeBands();
  this.Animate();
  this.AfterDrawTimeout();
  this.DrawChartMenu();
  if (this.forPJS)
    this.svg.select("#" + this.chartId + "valueAxisGroup").raise();
}
StdChart.prototype.AfterDrawRenderer = function () {
  this.ApplyFonts();
  this._SetAxisLabelsPositions();
  this._SetValueAxisPositions();
  this.ApplyColors();
  this._ApplyEvents();
  this.ApplyRangeBands();
  this.Animate();
  this.AfterDrawTimeout();
}
StdChart.prototype.AfterDrawTimeout = function () {
  var _this = this;
  this.RemoveLoadingDiv();
  if (this.forPJS)
    timeoutSequence();
  else {
    var timeout = setTimeout(function () { timeoutSequence(); }, this.animationDelay);
    this.allTimeouts.push(timeout);
  }

  function timeoutSequence() {
    _this._ApplyPatterns();
    _this.DrawValueLabels();
    _this._ExecScale();
    _this.DrawZoomCursor();
    _this.HideMaskDivAnimation();
    _this.RemoveProgressBar();
    if (_this.old_drawStatic !== undefined) {
      _this.drawStatic = _this.SetIsStaticChart(_this.old_drawStatic);
      delete _this.old_drawStatic;
    }
    _this._AdjustDisplayText();
  }
}
StdChart.prototype.RemoveElementsSeries = function () {
  d3.select("#" + this.chartId + "valueAxisGroup").remove();
  d3.select("#" + this.chartId + "valueAxisGridline").remove();
  d3.select("#" + this.chartId + "horizontalGridline").remove();
  d3.select("#" + this.chartId + "verticalGridline").remove();
  d3.select("#" + this.chartId + "legendGroup").remove();
  d3.select("#" + this.chartId + "rangeBands").remove();
  d3.select("#" + this.chartId + this.type + "_elementGroup").remove();
  this.RemovePatterns();
}
StdChart.prototype.ResetData = function () {
  this.columnOrderData = null;
  this.rowOrderData = null;
}
StdChart.prototype.RemovePatterns = function () {
  d3.select("#" + this.__cID + "d3ChartDefs").selectAll("pattern").remove();
}
StdChart.prototype.CheckSelection = function () {
  return (this.GetSelectedItems().length > 0);
}
StdChart.prototype.CreateChartMaskFrame = function (classname) {
  classname = classname || "maskFrame";
  d3.select(this.parent)
    .append("div")
    .attr("id", this.chartId + "maskFrame")
    .attr("class", classname)
    .style("width", this.parent.offsetWidth + "px")
    .style("height", this.parent.offsetHeight + "px");
}
StdChart.prototype.ShowMaskDivAnimation = function (posObj) {
  // metto return perche' i riscontri sono negativi - da' fastidio
  return;

  // posObj passato in ZtChartMultiDimCursor
  var mRefChart = this._ZtChart.StdChart;
  if (!mRefChart.defSettings.animation.animate || Empty(mRefChart.defSettings.animation.duration))
    return;

  var divY = "";
  if (this.asZoomCursor && this._ZtChart.StdChartCursor) {
    mRefChart = this._ZtChart.StdChartCursor;
    divY = this._ZtChart.StdChart.defSettings.globals.height;
  }

  if (Empty(d3.select("#" + mRefChart.chartId + "maskFrame").node()))
    mRefChart.CreateChartMaskFrame("maskFrameTransparent");
  else {
    d3.select("#" + mRefChart.chartId + "maskFrame").html("");
    d3.select("#" + mRefChart.chartId + "maskFrame").style("display", "block");
  }

  if (posObj && posObj.x)
    d3.select("#" + mRefChart.chartId + "maskFrame").style("left", posObj.x + "px");
  else
    d3.select("#" + mRefChart.chartId + "maskFrame").style("top", divY + "px");

  if (posObj && posObj.y)
    d3.select("#" + mRefChart.chartId + "maskFrame").style("top", posObj.y + "px");
  else
    d3.select("#" + mRefChart.chartId + "maskFrame").style("left", "");

  if (posObj && posObj.width)
    d3.select("#" + mRefChart.chartId + "maskFrame").style("width", posObj.width + "px");
  else
    d3.select("#" + mRefChart.chartId + "maskFrame").style("width", mRefChart.defSettings.globals.width + "px");

  if (posObj && posObj.height)
    d3.select("#" + mRefChart.chartId + "maskFrame").style("height", posObj.height + "px");
  else
    d3.select("#" + mRefChart.chartId + "maskFrame").style("height", mRefChart.defSettings.globals.height + "px");

  var divW = mRefChart.defSettings.globals.width / 2,
    divH = mRefChart.defSettings.globals.height / 2,
    msize = Math.max(8, Math.min(divW, divH) / 5);

  d3.select("#" + mRefChart.chartId + "maskFrame")
    .style("position", "absolute")
    .style("z-index", 2500)
    .on("mouseover", function () {
      if (d3.select("#" + mRefChart.chartId + "_resumeAnimation").node()) {
        d3.select("#" + mRefChart.chartId + "_resumeAnimation").style("display", "block");
        this.setAttribute("class", "maskFrame");
      }
    })
    .on("mouseout", function () {
      if (d3.select("#" + mRefChart.chartId + "_resumeAnimation").node()) {
        d3.select("#" + mRefChart.chartId + "_resumeAnimation").style("display", "none");
        this.setAttribute("class", "maskFrameTransparent");
      }
    })
    .append("div")
    .attr("id", mRefChart.chartId + "_resumeAnimation")
    .style("margin-left", (divW - msize / 2) + "px")
    .style("margin-top", (divH - msize / 2) + "px")
    .style("font-family", "svgCharts")
    .style("font-size", msize + "px")
    .style("color", mRefChart.defSettings.globalFont.color)
    .style("width", msize + "px")
    .style("cursor", "pointer")
    .style("display", "none")
    .style("vertical-align", "middle")
    .style("opacity", "0.5")
    .text(getIconFromCode("f4cd"))
    .on("click", function () {
      mRefChart._InterruptAnimateChartElements();
      var tmp = mRefChart.drawStatic;
      mRefChart.SetIsStaticChart(true);
      mRefChart.old_drawStatic = tmp;
      mRefChart.HideMaskDivAnimation();
      mRefChart.chartHeight = mRefChart.defSettings.globals.height;
      mRefChart.chartWidth = mRefChart.defSettings.globals.width;
      mRefChart.RedrawData();
    });
}
StdChart.prototype.HideMaskDivAnimation = function () {
  var mRefChart = this._ZtChart.StdChart;
  if (this.asZoomCursor && this._ZtChart.StdChartCursor)
    mRefChart = this._ZtChart.StdChartCursor;
  if (document.getElementById(mRefChart.chartId + "maskFrame"))
    document.getElementById(mRefChart.chartId + "maskFrame").style.display = "none";
}
StdChart.prototype.OpenExportDiv = function (elem) {
  var _this = this;
  if (!document.getElementById(this.chartId + "maskFrame"))
    this.CreateChartMaskFrame();
  else {
    d3.select("#" + this.chartId + "maskFrame").node().innerHTML = "";
    d3.select("#" + this.chartId + "maskFrame").node().style.display = "block";
    d3.select("#" + this.chartId + "maskFrame").node().setAttribute("class", "maskFrame");
  }

  var divY = getY(d3.select("#" + this.chartId + "divchartcontainer").node()) - getY(d3.select("#" + this.chartId + "divchartcontainer").node().parentNode);
  d3.select("#" + this.chartId + "maskFrame").style("top", divY + "px");
  d3.select("#" + this.chartId + "maskFrame").style("left", "");
  d3.select("#" + this.chartId + "maskFrame").style("width", this.defSettings.globals.width + "px");
  d3.select("#" + this.chartId + "maskFrame").style("height", this.defSettings.globals.height + "px");

  var exportChoice = [
    ["EXPALL", "Export entire dataset"],
    ["EXPSEL", "Export only selected datas"]
  ];

  var maxLengthW = getOffsetWidth(getMaxWordLength(getList(1, exportChoice)), { style: "N", size: 15, name: "Open Sans,DejaVu Sans" }, this.chartId) + 20;
  var maxLengthH = exportChoice.length * (getOffsetHeight(getMaxWordLength(getList(1, exportChoice)), { style: "N", size: 15, name: "Open Sans,DejaVu Sans" }, this.chartId) + 20);

  var divW = (this.defSettings.globals.width - maxLengthW) / 2;
  var divH = (this.defSettings.globals.height - maxLengthH) / 2;

  var divFormat = d3.select("#" + this.chartId + "maskFrame")
    .append("div")
    .attr("id", this.chartId + "expList")
    .style("margin-left", divW + "px")
    .style("margin-top", divH + "px");

  var formFormat = divFormat.append("form")
    .attr("id", this.chartId + "form");

  for (var i = 0; i < exportChoice.length; i++) {
    formFormat.append("input")
      .attr("type", "radio")
      .attr("id", this.chartId + "output_" + exportChoice[i][0])
      .attr("name", "output")
      .attr("class", "radio")
      .attr("value", exportChoice[i][0]);

    formFormat.append("span")
      .text(exportChoice[i][1])
      .attr("title", exportChoice[i][1])
      .attr("class", "radio");

    formFormat.append("br");
  }

  divFormat.append("input")
    .attr("type", "button")
    .attr("id", this.chartId + "btn_Export")
    .attr("value", "Export")
    .attr("class", "button")
    .style("margin-left", "30px")
    .style("margin-top", "30px");

  divFormat.append("input")
    .attr("type", "button")
    .attr("id", this.chartId + "btn_Cancel")
    .attr("value", "Cancel")
    .attr("class", "button")
    .on("click", function () {
      _this.HideMaskDivAnimation();
    });

  document.getElementById(this.chartId + "output_EXPSEL").checked = true; //default

  document.getElementById(this.chartId + "btn_Export").onclick = function () {
    _this.HideMaskDivAnimation();
    var selectedOutput = document.getElementById(_this.chartId + "expList").childNodes[0];
    var output = null, valueObject = null;
    for (var i = 0; i < selectedOutput.childNodes.length && Empty(valueObject); i++) {
      output = selectedOutput.childNodes[i];
      if (output.tagName.toLowerCase() == "input" && output.checked)
        valueObject = output.value;
    }
    _this._GetExportData(elem, valueObject);
  }
}
StdChart.prototype.GetCheckIconCode = function () {
  return "ef87";
}
StdChart.prototype.GetUncheckIconCode = function () {
  return "e92a";
}
StdChart.prototype.GetDefaultIconFont = function () {
  return { name: "svgCharts", size: 14, color: "#0D0F12", style: "N" };
}
StdChart.prototype.DrawGradientLegend = function (svgContainer) {
  if (Empty(this.defSettings.range.bands))
    return;

  if (this.chartLegends.range.position == "hide" || this.chartLegends.range.hide)
    return;

  var legend = svgContainer.append("g")
    .attr("id", this.chartId + "legendGrouprange"),
    bands = this.defSettings.range.bands,
    ticks = this.defSettings.range.labels,
    grad = this.defSettings.range.gradient,
    precision = this.defSettings.range.precision,
    position = this.chartLegends.range.position,
    _this = this,
    sizePerc = 0.75,
    sizeVal = 10,
    diffVals = Math.abs(ticks[0] - ticks[ticks.length - 1]);

  legend.append("rect")
    .attr("id", this.chartId + "legend_container_rectrange")
    .attr("x", 0)
    .attr("y", 0);

  if ((grad == "mono" && bands.length > 1) || (grad == "multi" && this.defSettings.range.discontinue)) {
    for (var i = bands.length - 1; i >= 0; i--) {
      legend.append("rect")
        .attr("id", this.chartId + "legendItemrange_" + i)
        .attr("class", "legendGrad")
        .attr("width", function () {
          if (position == "top" || position == "bottom") {
            var size = _this.defSettings.globals.width * sizePerc,
              diffBand = Math.abs(bands[i].minValue - bands[i].maxValue);
            return (diffBand * size) / diffVals;
          }
          return sizeVal;
        })
        .attr("height", function () {
          if (position == "left" || position == "right") {
            var size = _this.defSettings.globals.height * sizePerc,
              diffBand = Math.abs(bands[i].minValue - bands[i].maxValue);
            return (diffBand * size) / diffVals;
          }
          return sizeVal;
        })
        .attr("data-index", i);
    }
  }
  else {
    legend.append("rect")
      .attr("id", this.chartId + "legendItemrange_multi")
      .attr("class", "legendGrad")
      .attr("width", function () {
        if (position == "top" || position == "bottom")
          return _this.defSettings.globals.width * sizePerc;
        return sizeVal;
      })
      .attr("height", function () {
        if (position == "left" || position == "right")
          return _this.defSettings.globals.height * sizePerc;
        return sizeVal;
      })
      .attr("data-index", i);
  }

  addReferenceLegendValues(legend, position, ticks, precision, bands);
  legend.append("text")
    .attr("id", this.chartId + "legendCursorrange")
    .style("font-family", this.GetDefaultIconFont().name)
    .style("fill", this.GetDefaultIconFont().color)
    .style("visibility", "hidden")
    .text(function () {
      if (position == "top" || position == "bottom")
        return _this.GetCursorIcon();
      return _this.GetCursorIcon("left");
    })
    .attr("x", 0)
    .attr("y", function () {
      if (position == "top" || position == "bottom")
        return _this.GetDefaultIconFont().size;
      return 0;
    });

  function addReferenceLegendValues(legend, position, ticks, precision/*, bands*/) {
    var lobj = getDomNodeSizes(legend.node()),
      tH = 0,
      mx = 0,
      my = 0,
      maxTickWordLen = getMaxWordLength(ticks, precision),
      font = appliedFont(_this.defSettings, _this.defSettings.chartRangeLegend, _this.defSettings.chartRangeLegend.textFont),
      offset = 4;

    if (position == "top" || position == "bottom") {
      lobj.width = _this.defSettings.globals.width * sizePerc;
      tH = getOffsetWidth(maxTickWordLen, font, _this.chartId) + offset / 2;
      if ((ticks.length * tH) < lobj.width)
        //tH = tH + (lobj.width - (ticks.length * tH)) / (ticks.length - 1);
        tH = lobj.width / ticks.length + 1//offset / 2;
      mx = lobj.x - tH;
      my = lobj.y + _this.GetDefaultIconFont().size;
    }
    else {
      lobj.height = _this.defSettings.globals.height * sizePerc;
      tH = lobj.height / (ticks.length - 1); // stroke
    /*  tH = getOffsetHeight(maxTickWordLen, font, _this.chartId) + offset / 2;
      if ((ticks.length * tH) < lobj.height)
        tH = lobj.height / ticks.length + 1;
    */  mx = lobj.x + _this.GetDefaultIconFont().size;
      my = lobj.y - tH;
    }

    var mcond,
      nform,
      tticks = ticks.reverse();
    for (var i = 0; i < tticks.length; i++) {
      nform = _this.localeLangFormat.numberFormat(",." + precision + "f");
      if (position == "top" || position == "bottom") {
        mx += tH;
        mcond = mx <= (lobj.x + lobj.width);
      }
      else {
        my += tH;
        mcond = my <= (lobj.y + lobj.height);
      }

      if (mcond)
        drawLegendTick(legend, i, mx, my, nform(tticks[i]), position, font);
    }

    function drawLegendTick(legend, i, x, y, txt, position, font) {
      var loffset = 15,
        toffset = 20,
        textH = getOffsetHeight(txt, font, _this.chartId);

      legend.append("line")
        .attr("x1", x)
        .attr("x2", function () {
          if (position == "top" || position == "bottom")
            return x;
          return x + loffset;
        })
        .attr("y1", y)
        .attr("y2", function () {
          if (position == "top" || position == "bottom")
            return y + loffset;
          return y;
        })
        .style("stroke", function () {
          var ccol = _this.svg.node().style.fill;
          if (Empty(ccol) || ccol == "transparent" || (ccol.indexOf("rgba") >= 0 && ccol.indexOf(",0)") >= 0))
            return "#FFFFFF";
          return ccol;
        })
        .style("shape-rendering", "crispEdges");

      legend.append("text")
        .attr("id", _this.chartId + "legendTextrange_" + i)
        .text(txt)
        .attr("x", function () {
          if (position == "top" || position == "bottom")
            return x;
          return x + toffset;
        })
        .attr("y", function () {
          if (position == "top" || position == "bottom")
            return y + toffset + (textH / 2);
          return y;
        })
        .attr("dy", function () {
          if (position == "top" || position == "bottom")
            return "";
          return ".32em";
        })
        .style("text-anchor", function () {
          if (position == "top" || position == "bottom")
            return "middle";
          return "";
        });
    }
  }
}
StdChart.prototype.GetCursorIcon = function (align) {
  if (align == "left")
    return getIconFromCode("e7c4");
  return getIconFromCode("e905");  // top
}
StdChart.prototype.GetMoreDataIcon = function (ismore) {
  if (ismore)
    return getIconFromCode("ef92");
  return getIconFromCode("ef94");  // top
}
StdChart.prototype.MoveRangeCursor = function (value, hideCursor) {
  if (!this.chartLegends.range)
    return;
  if (this.chartLegends.range.hide || this.chartLegends.position == "hide")
    return;
  if (this.defSettings.range && Empty(this.defSettings.range.bands))
    return;
  if (this.defSettings.range && this.defSettings.range.gradient == "none")
    return;

  var chartId = this._ZtChart.StdChart.chartId,
    cursor = d3.select("#" + chartId + "legendCursorrange"),
    _this = this;

  if (Empty(cursor.node()))
    return;

  if (hideCursor || (!hideCursor && isNaN(parseFloat(value)))) {
    cursor.style("visibility", "hidden");
    return;
  }

  var mis, refm, mfact;
  if (this.chartLegends.range.position == "top" || this.chartLegends.range.position == "bottom") {
    mis = _this.chartConfig.globalSettings.width * 0.75;
    refm = "x";
    mfact = -1;
  }
  else {
    mis = this.defSettings.globals.height * 0.75;
    refm = "y";
    mfact = 1;
  }

  var initpos = 0,
    initcur = cursor.attr(refm),
    unit = mis / (this.rangeminmax.max - this.rangeminmax.min);
  cursor
    .style("visibility", "visible")
    .attr(refm, initcur)
    .transition()
    .duration(1000)
    .attr(refm, function () {
      return ((_this.rangeminmax.max - value) * unit) + initpos + mfact * (_this.GetDefaultIconFont().size / 2)// - 1;
    });
}
StdChart.prototype.GetLegendAlternativeIcon = function (isRange) {
  if (isRange) {
    if (this.defSettings.range.applyColor)
      return this.GetLegendIcon();
    return this.GetRangeLegendIcon();
  }

  if (this.defSettings.range && !Empty(this.defSettings.range.bands) && this.defSettings.range.applyColor)
    return this.GetMarkerLegendIcon();
  return this.GetLegendIcon();
}
StdChart.prototype.GetLegendAlternativeIconHexCode = function (isRange) {
  if (isRange) {
    if (this.defSettings.range.applyColor)
      return this._GetLegendIconHexCode();
    return this._GetRangeLegendIconHexCode();
  }

  if (this.defSettings.range && !Empty(this.defSettings.range.bands) && this.defSettings.range.applyColor)
    return this._GetMarkerLegendIconHexCode();
  return this._GetLegendIconHexCode();
}
StdChart.prototype.AdjustMaskAndRenderer = function () {
  this._AdjustMaskAndRendererPositioning();

  if (d3.select("#" + this.chartId + "valueAxisGroup").node())
    d3.select("#" + this.chartId + "valueAxisGroup").remove();
  if (d3.select("#" + this.chartId + "domainAxisGroup").node())
    d3.select("#" + this.chartId + "domainAxisGroup").remove();
  if (d3.select("#" + this.chartId + "valueAxisLabel").node())
    d3.select("#" + this.chartId + "valueAxisLabel").remove();
  if (d3.select("#" + this.chartId + "domainAxisLabel").node())
    d3.select("#" + this.chartId + "domainAxisLabel").remove();
}
StdChart.prototype.SetColorSet = function () {
  var colors = this.defSettings.colorSeries.slice();
  if (!Empty(this.customColors.array)) {
    colors = this.customColors.array.slice();
    this.defSettings.useColorSeriesForEach = this.customColors.useForEach;
  }
  if (colors.length == 0 || (colors.length == 1 && Empty(colors[0].color) && Empty(colors[0].gradient)))
    colors = [];
  this.colorSet = setColorSeriesArray(colors, this._GetListForColors(), this.defSettings.reuseColorSeries);
  var indexes = Object.keys(this._ZtChart.StdChart.customColorsSeries);
  for (var i = 0; i < indexes.length; i++) {
    var idx = parseInt(Strtran(indexes[i], "_", ""));
    this.colorSet[idx] = this._ZtChart.StdChart.customColorsSeries[indexes[i]];
  }
}
StdChart.prototype.SetRangeInItems = function (item, band) {
  var items;

  if (item) {
    if (Empty(band))
      band = this.GetObjectFromRange(item.value, this.defSettings.range.bands);
    item.range = this.defSettings.range.labels[band.indexBand];
    item.rangeIdx = band.indexBand;
    return;
  }

  items = this._GetItems();
  for (var i = 0; i < items.length; i++) {
    item = items[i];
    band = this.GetObjectFromRange(item.value, this.defSettings.range.bands);
    item.range = this.defSettings.range.labels[band.indexBand];
    item.rangeIdx = band.indexBand;
  }
}
StdChart.prototype.GetDefaultExcludedFont = function () {
  return { name: "Open Sans", size: 12, color: "#647687", style: "N" };
}
StdChart.prototype.ApplyFocusKey = function () {
  if (this.focusKey && this.applyFocusKey) {
    var tmpFK = this.focusKey.split(",");
    var type = "";
    for (var i = 0; i < tmpFK.length; i++) {
      type = tmpFK[i];
      if (!type && type != 0)
        continue;
      type = type + "";
      if (type.toLowerCase() == "negative value")
        continue;

      var itemObjects = this.GetAllItems(type, true);
      this.ApplySelectionsObjects(itemObjects.items);
    }
  }
  this.applyFocusKey = false;
}
StdChart.prototype.GetAllItems = function (type, excludeOrgItems) {
  var _this = this;
  var items = [];
  var ret = [];
  var max, i, l, tmp, litems, item;
  switch (type) {
    case "first":
      items = this._GetItems().filter(function (item) { return item.idx == 0; });
      break;
    case "last":
      if (this._GetDefaultDataOrder() == "row")
        max = this.categoryList.length - 1;
      else
        max = this.seriesList.length - 1;
      items = this._GetItems().filter(function (item) { return item.idx == max; });
      break;
    case "min":
      tmp = [];
      litems = this._GetItems();
      for (i = 0; i < litems.length; i++) {
        item = litems[i];
        if (tmp[item.sidx]) {
          if (tmp[item.sidx].value > item.value)
            tmp[item.sidx] = item;
        }
        else
          tmp[item.sidx] = item;
      }
      l = Object.keys(tmp);
      for (i = 0; i < l.length; i++)
        items.push(tmp[l[i]]);
      break;
    case "max":
      tmp = [];
      litems = this._GetItems();
      for (i = 0; i < litems.length; i++) {
        item = litems[i];
        if (tmp[item.sidx]) {
          if (tmp[item.sidx].value < item.value)
            tmp[item.sidx] = item;
        }
        else
          tmp[item.sidx] = item;
      }
      l = Object.keys(tmp);
      for (i = 0; i < l.length; i++)
        items.push(tmp[l[i]]);
      break;
    case "all":
      items = this._GetItems().slice();
      break;
    default:
      items = this._GetItems().filter(function (item) { return _this._CheckIdentityItemValue(item, type); });
      break;
  }

  for (i = 0; i < items.length; i++) {
    ret[i] = this._GetItemObj(items[i]);
    ret[i].isSelected = true;
    ret[i].focus = true;
  }

  var robj = { items: ret };
  if (!excludeOrgItems)
    robj.orgItems = items;
  return robj;
}
StdChart.prototype.SelectAllValues = function (type) {
  var itemObjects = this.GetAllItems(type, true);
  this.ApplySelectionsObjects(itemObjects.items);
}
StdChart.prototype.RemoveAllSelections = function (/*type*/) {
  var items = this._GetItems();
  var ret = [];
  for (var i = 0; i < items.length; i++) {
    ret[i] = this._GetItemObj(items[i]);
    ret[i].isSelected = false;
  }
  this.ApplySelectionsObjects(ret);
}
StdChart.prototype.DrawDomainLabel = function (idx, posObject, text) {
  if (Empty(text))
    return;
  var type = "domain";
  var id = this.chartId + type + "_" + idx,
    offset = 5,
    x,
    y,
    font = this.defSettings.globalFont;

  x = posObject.width / 2;
  y = posObject.height - offset;// - getOffsetHeight(text, font, this.chartId) + (offset / 2);
  var label = this.svg.append("text")
    .attr("id", id)
    .attr("x", x)
    .attr("y", y)
    .style("text-anchor", "middle")
    .style("cursor", "default")
    .text(text);
  setFont(label, font, this);
}
StdChart.prototype.IsMultiDim = function () {
  return false;
}
StdChart.prototype.ShowAggregateDetail = function (create) {
  if (Empty(create) && create != false)
    create = true;
  var _this = this._ZtChart.StdChart,
    frame = d3.select("#" + this.chartId + "maskFrame").node(),
    divCont;

  if (Empty(frame)) {
    this.CreateChartMaskFrame();
    frame = d3.select("#" + this.chartId + "maskFrame").node()
  }

  if (create) {
    frame.innerHTML = "";
    frame.style.display = "block";
    frame.setAttribute("class", "maskFrame");

    var divY = getY(d3.select("#" + _this.chartId + "divchartcontainer").node());
    d3.select("#" + _this.chartId + "maskFrame").style("top", divY + "px");
    d3.select("#" + _this.chartId + "maskFrame").style("left", "");
    d3.select("#" + _this.chartId + "maskFrame").style("width", _this.defSettings.globals.width + "px");
    d3.select("#" + _this.chartId + "maskFrame").style("height", _this.defSettings.globals.height + "px");
    d3.select("#" + _this.chartId + "maskFrame").style("position", "fixed");


    divCont = document.createElement("div");
    divCont.id = _this.chartId + "maskFrameInner";
    divCont.className = "maskFrameInner label";
    divCont.style.top = "0px";
    divCont.style.left = "0px";
    divCont.style.width = "100%";
    divCont.style.height = "99%";
    divCont.style.overflowY = "auto";
    divCont.style.backgroundColor = "rgba(255, 255, 255, 0.9)";
    frame.appendChild(divCont);

    var cbtn = document.createElement("div");
    cbtn.className = "maskFrameCancelBtn";
    divCont.appendChild(cbtn);
    cbtn.onclick = function () {
      document.getElementById(_this.chartId + "maskFrame").style.display = "none";
    };

    var dtit = document.createElement("span");
    dtit.className = "maskFrameTitle";
    dtit.textContent = _this.Translate("ZTC_OTHERDATA");
    divCont.appendChild(dtit);
  }
  else {
    divCont = d3.select("#" + _this.chartId + "maskFrameInner").node()
  }

  if (!Empty(d3.select("#" + _this.chartId + "menuBar").node()))
    d3.select("#" + _this.chartId + "menuBar").node().style.display = "none";
  if (!divCont)
    return;

  var listvf = this.objConfig.valueFields.split(",");
  var listvl = this.orgSeriesList;
  if (this.dataOrder != this._GetDefaultDataOrder())
    listvl = this.orgCategoryList;

  var stitle, stable, srow, sthead, stcol;
  var thead = ["category", "value", "percentage"];
  var theadLab = ["ZTC_CATLAB", "ZTC_VALLAB", "ZTC_PERCLAB"];
  var cols = 2, txt;
  if (this.keyField.domain || this.keyField.series) {
    thead.splice(0, 0, "ZTC_CKEYLAB");
    theadLab.splice(0, 0, "ZTC_CKEYLAB");
    cols++;
  }

  var initCols = cols;
  for (var mkey in this.aggregateData) {
    cols = initCols;
    if (!Empty(this.aggregateData[mkey].val)) {
      txt = listvl[listvf.indexOf(mkey)] + ": ";
      if (this.appliedKey)
        txt = this.appliedKey + " / " + txt;
      if (!Empty(this.objConfig.dataOthers.value)) {
        txt += this.Translate("ZTC_VALSLAB").toLowerCase() + " < "
        txt += this.objConfig.dataOthers.value[listvf.indexOf(mkey)];
        if (this.aggregateData[mkey].perc)
          txt += "%";
      }
      stitle = document.createElement("span");
      stitle.textContent = txt;
      stitle.style.fontSize = "15px";
      stitle.style.paddingLeft = "5px";
      stitle.style.marginTop = "15px";
      stitle.style.float = "left";
      stitle.style.width = "99%";
      divCont.appendChild(stitle);

      stable = document.createElement("TABLE");
      stable.className = "maskFrameTable";
      if (this.aggregateData[mkey].perc)
        cols++;
      for (var i = 0; i <= this.aggregateData[mkey].val.length; i++) {
        srow = document.createElement("TR");
        for (var j = 0; j < cols; j++) {
          if (i == 0) {
            sthead = document.createElement("TH");
            sthead.style.width = (100 / cols) + "%";
            sthead.textContent = this.Translate(theadLab[j]);
            srow.appendChild(sthead);
          }
          else {
            stcol = document.createElement("TD");
            if (j == 0 && (this.keyField.domain || this.keyField.series))
              stcol.textContent = this.aggregateData[mkey].val[i - 1].keyField;
            else
              stcol.textContent = this.aggregateData[mkey].val[i - 1][thead[j].toLowerCase()];
            stcol.style.textAlign = "center";
            srow.appendChild(stcol);
          }
        }
        stable.appendChild(srow);
      }
      divCont.appendChild(stable);
    }
  }
}
StdChart.prototype.ZoomFilterData = function (start_pos, end_pos) {
  if (this.objConfig.zoomFilter.show == 'chartzoom') {
    var chartToDraw = this._ZtChart.StdChart;
    chartToDraw._SetCursorDrawingList(start_pos, end_pos);
    chartToDraw.RedrawData();
  }
}
StdChart.prototype.ZoomDispatchEvent = function (event, name) {
  if (Empty(this.filterStart) && this.filterStart != 0)
    return;
  if (Empty(this.filterEnd) && this.filterEnd != 0)
    return;

  var start_value, end_value;
  if (this.domainIsNumber || this.domainIsTime) {
    start_value = this.scaleCursor.invert(this.filterStart);
    end_value = this.scaleCursor.invert(this.filterEnd);
  }
  else {
    var start_idx = Math.round(this.scaleCursor.invert(this.filterStart)),
      end_idx = Math.round(this.scaleCursor.invert(this.filterEnd));
    end_value = this.scaleX.domain()[end_idx];
    start_value = this.scaleX.domain()[start_idx];
  }

  this.ZoomFilterData(start_value, end_value);

  if (window[this.chartId + "onFilterAction"])
    window[this.chartId + "onFilterAction"](name, start_value, end_value, this.appliedKey);
  else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent) {
    var on_evt = this._ZtChart.parentCtrl.dispatchEvent("onFilterAction", event, name, start_value, end_value, this.appliedKey);
    if (!on_evt) {
      if (window[this.chartId + "FilterAction"])
        window[this.chartId + "FilterAction"](name, start_value, end_value, this.appliedKey);
      else
        this._ZtChart.parentCtrl.dispatchEvent("FilterAction", event, name, start_value, end_value, this.appliedKey);
    }
  }
}
StdChart.prototype.DrawZoomCursor = function () {
  if (this._ZtChart.StdChart.IsMultiDim())
    return;
  this._DrawZoomCursor();
}
StdChart.prototype.ResetZoomCursor = function () {
  if (!this.zoomCursorBrush)
    return;
  if (!this.zoomCursorBrush.area || !this.zoomCursorBrush.brush)
    return;

  this.zoomCursorBrush.area.call(this.zoomCursorBrush.brush.move, this.scaleCursor.range());
  this.ZoomDispatchEvent(d3.event, "onreset");
}
StdChart.prototype.RemoveAllPatterns = function () {
  d3.selectAll("[item-type=pattern]").remove();
}
StdChart.prototype.GetNotRepresentedIconHexCode = function () {
  return "e6c2"//"f174";
}
StdChart.prototype.GetNotRepresentedIcon = function () {
  return getIconFromCode(this.GetNotRepresentedIconHexCode());
}
StdChart.prototype.DrawNotRepresentedDataIcon = function () {
  if (Empty(this.nrDataset))
    return;

  var group = this.svg.append("g")
    .attr("id", this.chartId + this.type + "_nrGroup")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top + this.chartHeight] + ")"),
    h1 = getOffsetHeight(this.GetMoreDataIcon(), this.GetDefaultIconFont(), this.chartId),
    h2 = getOffsetHeight(this.GetNotRepresentedIcon(), this.GetDefaultIconFont(), this.chartId),
    h3 = getOffsetHeight("W", this.defSettings.globalFont, this.chartId),
    totH = Math.max(Math.max(h1, h2), h3),
    progr = 0,
    _this = this;

  group.append("text")
    .attr("x", progr)
    .attr("y", totH)
    .attr("data-type", "more")
    .text(this.GetMoreDataIcon())
    .style("font-family", this.GetDefaultIconFont().name)
    .style("font-size", this.GetDefaultIconFont().size + "px")
    .style("fill", this.GetDefaultIconFont().color)
    .style("cursor", "pointer")
    .on("click", function () { _this.ShowNotRepresentedDataDetail() });

  progr = getOffsetWidth(this.GetMoreDataIcon(), this.GetDefaultIconFont(), this.chartId) + 3;

  group.append("text")
    .attr("x", progr)
    .attr("y", 18)
    .text(this.GetNotRepresentedIcon())
    .style("font-family", this.GetDefaultIconFont().name)
    .style("font-size", 18 + "px")
    .style("fill", this.GetDefaultIconFont().color)
    .style("cursor", "pointer")
    .on("click", function () { _this.ShowNotRepresentedDataDetail() });

  progr = getOffsetWidth(this.GetLegendIcon(), this.GetDefaultIconFont(), this.chartId) + 3;

  group.append("text")
    .attr("x", progr)
    .attr("y", totH)
    .text("")
    .style("font-family", this.defSettings.globalFont.name)
    .style("font-size", this.defSettings.globalFont.size + "px")
    .style("fill", this.defSettings.globalFont.color)
    .style("cursor", "pointer")
    .on("click", function () { _this.ShowNotRepresentedDataDetail() });
}
StdChart.prototype.ShowNotRepresentedDataDetail = function (create) {
  if (Empty(create) && create != false)
    create = true;
  var _this = this._ZtChart.StdChart,
    frame = d3.select("#" + this.chartId + "maskFrame").node(),
    divCont;

  if (Empty(frame)) {
    this.CreateChartMaskFrame();
    frame = d3.select("#" + this.chartId + "maskFrame").node()
  }

  if (create) {
    frame.innerHTML = "";
    frame.style.display = "block";
    frame.setAttribute("class", "maskFrame");

    var divY = getY(d3.select("#" + _this.chartId + "divchartcontainer").node());
    d3.select("#" + _this.chartId + "maskFrame").style("top", divY + "px");
    d3.select("#" + _this.chartId + "maskFrame").style("left", "");
    d3.select("#" + _this.chartId + "maskFrame").style("width", _this.defSettings.globals.width + "px");
    d3.select("#" + _this.chartId + "maskFrame").style("height", _this.defSettings.globals.height + "px");
    d3.select("#" + _this.chartId + "maskFrame").style("position", "fixed");


    divCont = document.createElement("div");
    divCont.id = _this.chartId + "maskFrameInner";
    divCont.className = "maskFrameInner label";
    divCont.style.top = "0px";
    divCont.style.left = "0px";
    divCont.style.width = "100%";
    divCont.style.height = "99%";
    divCont.style.overflowY = "auto";
    divCont.style.backgroundColor = "rgba(255, 255, 255, 0.9)";
    frame.appendChild(divCont);

    var cbtn = document.createElement("div");
    cbtn.className = "maskFrameCancelBtn";
    divCont.appendChild(cbtn);
    cbtn.onclick = function () {
      document.getElementById(_this.chartId + "maskFrame").style.display = "none";
    };

    var dtit = document.createElement("span");
    dtit.className = "maskFrameTitle";
    dtit.textContent = _this.Translate("ZTC_NOTREPDATA");
    divCont.appendChild(dtit);
  }
  else {
    divCont = d3.select("#" + _this.chartId + "maskFrameInner").node()
  }

  if (d3.select("#" + _this.chartId + "menuBar").node())
    d3.select("#" + _this.chartId + "menuBar").node().style.display = "none";
  if (!divCont)
    return;

  var listvf = this.valueFields;
  var listvl = this.orgSeriesList;
  if (this.dataOrder == "row") {
    listvl = this.orgCategoryList;
  }

  var stable, srow, sthead/*, stcol*/;
  var thead = ["category", "value"];
  var theadLab = ["ZTC_CATLAB", "ZTC_VALLAB"];
  var cols = 2;
  if (this.keyField.domain || this.keyField.series) {
    thead.splice(0, 0, "ZTC_CKEYLAB");
    cols++;
  }

  var stitle = document.createElement("span");
  stitle.textContent = "";
  stitle.style.fontSize = "15px";
  stitle.style.paddingLeft = "5px";
  stitle.style.marginTop = "15px";
  stitle.style.float = "left";
  stitle.style.width = "99%";
  divCont.appendChild(stitle);

  //var yIndex;
  stable = document.createElement("TABLE");
  stable.className = "maskFrameTable";
  stable.style.float = "left";
  srow = document.createElement("TR");
  for (var k = 0; k < cols; k++) {
    sthead = document.createElement("TH");
    sthead.style.width = (100 / cols) + "%";
    sthead.textContent = this.Translate(theadLab[k]);
    srow.appendChild(sthead);
  }
  stable.appendChild(srow);

  var record;
  for (var i = 0; i < this.nrDataset.length; i++) {
    record = this.nrDataset[i];
    for (var j = 0; j < listvf.length; j++) {
      //      if (record[yIndex] >= 0)  -- ???
      //      continue;
      srow = this._MakeNotRepresentedDataRow(cols, record, listvf[j], listvl[j]);
      stable.appendChild(srow);
    }
  }
  divCont.appendChild(stable);
}
StdChart.prototype.GetLegendIconSize = function () {
  var fsize = appliedFont(this.defSettings, this.defSettings.chartLegend, this.defSettings.chartLegend.textFont).size;
  if (fsize < 10)
    fsize = 10;
  else if (fsize > 25)
    fsize = 25;
  return fsize;
}
StdChart.prototype.MapDrawAxis = function () {
  var scs = Object.keys(this.scaleY),
    sckey,
    axisContainer = this.svg.select("#" + this.chartId + "valueAxisGroup"),
    axisReferenceId = "",
    scaleRefKey = "",
    draw = true,
    _this = this,
    axisRefs = [];

  if (Empty(axisContainer.node()))
    axisContainer = this.svg.append("g").attr("id", this.chartId + "valueAxisGroup")

  // precalcolo la scala - in base anche ai filtri - se abilitati
  if (this._ZtChart && this._ZtChart.enableExclude) {
    var filteredScales = scs.filter(function (s) { return _this._GetParseDrawingList().indexOf(s) >= 0; });
    for (var i = 0; (Empty(axisReferenceId) && Empty(scaleRefKey)) && i < filteredScales.length; i++) {
      sckey = filteredScales[i];
      if (filteredScales.length == 1) {
        axisReferenceId = filteredScales[i];
        scaleRefKey = filteredScales[i];
      }
      else {
        // qui
        if (!this.multipleScales || (this.objConfig.mapSeries && this.objConfig.mapSeries[sckey] && !this.objConfig.mapSeries[sckey].ownerScale)) {
          axisReferenceId = filteredScales[i];
          scaleRefKey = filteredScales[i];
        }
      }
    }
  }

  var magOrdScales = {};
  for (i = 0; i < scs.length; i++) {
    sckey = scs[i];
    if (this.multipleScales && this.objConfig.mapSeries) {
      if (this.objConfig.mapSeries[sckey]) {
        if (this.objConfig.mapSeries[sckey].ownerScale) {
          this.scaleY[sckey].__refAxis = sckey;
          if (axisRefs.indexOf(sckey) < 0)
            axisRefs.push(sckey);
          draw = true;
          if (this[sckey + "_values"])
            magOrdScales[sckey] = getMagnitudeOrder(d3.max(this[sckey + "_values"]));
        }
        /*else if (!Empty(axisReferenceId)) {
            this.scaleY[sckey].__refAxis = axisReferenceId;
            draw = false;
        }*/
        else {  // non ha scala propria, non e' referenziato, lo disegno
          // valuto se potrebbe essere referenziato a uno gia' disegnato
          var ssk = Object.keys(magOrdScales);
          if (ssk.length > 0) {
            var cur_mag = -1;
            if (this[sckey + "_values"])
              cur_mag = getMagnitudeOrder(d3.max(this[sckey + "_values"]));
            var ok = false;
            for (var j = 0; cur_mag >= 0 && !ok && j < ssk.length; j++) {
              var s_mag = magOrdScales[ssk[j]],
                diff = Math.abs(cur_mag - s_mag);
              if (diff <= 2) {
                axisReferenceId = ssk[j];
                ok = true;
              }
            }
            if (!ok)
              axisReferenceId = sckey;
          }
          else
            axisReferenceId = sckey;
          this.scaleY[sckey].__refAxis = axisReferenceId;
          if (axisRefs.indexOf(axisReferenceId) < 0)
            axisRefs.push(axisReferenceId);
          if (Empty(scaleRefKey)) {
            scaleRefKey = sckey;
          }
          draw = false;
          if (axisReferenceId == sckey) {
            if (this[sckey + "_values"])
              magOrdScales[sckey] = getMagnitudeOrder(d3.max(this[sckey + "_values"]));
            draw = true;
          }
        }
      }
      else {
        if (!Empty(axisReferenceId)) {
          this.scaleY[sckey].__refAxis = axisReferenceId;
          draw = false;
        }
        else {  // non ha scala propria, non e' referenziato, lo disegno
          // valutare algoritmo ordini mag
          axisReferenceId = sckey;
          this.scaleY[sckey].__refAxis = axisReferenceId;
          if (axisRefs.indexOf(axisReferenceId) < 0)
            axisRefs.push(axisReferenceId);
          draw = true;
          if (Empty(scaleRefKey)) {
            scaleRefKey = sckey;
          }
        }
      }
    }
    else {
      if (Empty(axisReferenceId) && i == 0) {
        axisReferenceId = sckey;
        draw = true;
        if (Empty(scaleRefKey))
          scaleRefKey = sckey;
      }
      else if (axisReferenceId == sckey) {
        draw = true;
      }
      else
        draw = false;

      // basta il primo
      this.scaleY[sckey].__refAxis = axisReferenceId;
    }

    this.scaleY[sckey].__noDraw = !draw;
    var _axisReferenceId = this.scaleY[sckey].__refAxis;
    if (_axisReferenceId != sckey && this.scaleY[_axisReferenceId]) {
      if (this.scaleY[_axisReferenceId].__noDraw == undefined)
        this.scaleY[_axisReferenceId].__noDraw = true;
      else if (this.scaleY[_axisReferenceId].__noDraw && !draw) {
        draw = true;
        this.scaleY[sckey].__noDraw = !draw;
      }
      else if (this.scaleY[_axisReferenceId].__noDraw) {
        this.scaleY[sckey].__refAxis = sckey;
        if (!Empty(axisReferenceId))
          axisReferenceId = sckey;
      }
      var refVals = this[this.scaleY[sckey].__refAxis + "_values"],
        curVals = this[sckey + "_values"];
      if (curVals && refVals && curVals.length > 0 && refVals.length > 0)
        this[this.scaleY[sckey].__refAxis + "_values"] = refVals.concat(curVals);
    }

    if (this._GetParseDrawingList().indexOf(replaceSpecialCharsForID(sckey)) < 0)
      this.scaleY[sckey].__noDraw = true;
  }

  if (Empty(scaleRefKey))
    //valutare gli ordini di grandezza ma sembra troppo costoso
    scaleRefKey = scs[0];

  if (!this.scaleYref) {
    this.scaleYref = this.scaleY[scaleRefKey].copy();
    this.scaleYref.__refAxis = this.scaleY[scaleRefKey].__refAxis;
    this.scaleYref.__fieldType = this.scaleY[scaleRefKey].__fieldType;
    var vRange = this._GetValueAxisMinMax(scaleRefKey);
    if (vRange.min == vRange.max) {
      if (isNumberFloat(vRange.min)) {
        vRange.min -= 0.1;
        vRange.max += 0.1;
      }
      else {
        vRange.min -= 1;
        vRange.max += 1;
      }
    }

    this._SetValueScaleParameters(scaleRefKey, this.scaleYref, vRange.min, vRange.max);
  }

  if (axisRefs.length == 1) // 1 solo asse
    this.__1axisY = true;
}
StdChart.prototype.EvaluateDrawingSpace = function () {
  if (this.compactChart == "none")
    return;
  var topMax = this.margin.top > this.margin.bottom &&
    this.margin.top > this.margin.left &&
    this.margin.top > this.margin.right,
    bottomMax = this.margin.bottom > this.margin.top &&
      this.margin.bottom > this.margin.left &&
      this.margin.bottom > this.margin.right;
  if (topMax || bottomMax) {
    var legWidth = 0,
      titleWidth = getOffsetWidth(this.chartTitle,
        appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont),
        this.chartId
      ),
      subtitleWidth = getOffsetWidth(this.chartSubtitle,
        appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont),
        this.chartId
      );
    if (this.chartLegends.series) {
      legWidth = getLegendSize(this.chartId, this.legendList, this.defSettings, this.chartLegends.series).width;
      if (this._ZtChart.enableExclude)
        legWidth = legWidth + (this.legendList.length * 14);  // 14 size del check filtro
    }

    var totalWidth = Math.max(titleWidth, subtitleWidth, legWidth);
    totalWidth = Math.max(totalWidth, this.defSettings.globals.height);
    this.chartWidth = totalWidth - this.margin.left - this.margin.right;
    this.defSettings.globals.width = totalWidth;
  }
  else {
    this.chartWidth = Math.min(this.chartWidth, this.chartHeight);
    this.chartHeight = this.chartWidth;
    this.defSettings.globals.width = this.chartWidth + this.margin.left + this.margin.right;
    this.defSettings.globals.height = this.chartHeight + this.margin.top + this.margin.bottom;
  }
}
StdChart.prototype.DrawBreadcrumb = function (container) {
  var chart = this._ZtChart.StdChart;
  if (chart.defSettings.hierarchy && chart.defSettings.hierarchy.breadcrumb) {
    if (!chart.defSettings.hierarchy.breadcrumb.show)
      return;
  }
  if( !container.select("#" + chart.chartId + "breadcrumb").node() ) {
    chart._SetBreadcrumbPosition();
    container.append("g")
      .attr("id", chart.chartId + "breadcrumb");
    chart._SetBreadcrumbPosition();
  }
}
StdChart.prototype.FillBreadcrumb = function (pathArray, confObj) {
  var chart = this._ZtChart.StdChart;
  d3.select("#" + chart.chartId + "breadcrumb").selectAll("*").remove();
  if (chart.defSettings.hierarchy && chart.defSettings.hierarchy.breadcrumb) {
    if (!chart.defSettings.hierarchy.breadcrumb.show)
      return;
  }
  if( !confObj ) {
    confObj = {};
  }
  if( !confObj.font ) confObj.font = chart.defSettings.globalFont;
  if( !confObj.color) confObj.color = "#f3f3f3";
  //console.log(chart.defSettings.globalFont)
  chart.DrawBreadcrumb(chart.svg);
  var container = chart.svg.select("#" + chart.chartId + "breadcrumb"),
    progrW = 0,
    offset = 10,
    halfoffset = offset / 2;
    for (var i = 0; i < pathArray.length; i++) {
      var elem = pathArray[i].split(chart.splitSequence),
        string = elem[0],
        string2 = elem[1],
        stringW = getOffsetWidth(string, confObj.font, chart.chartId),
        stringH = getOffsetHeight(string, confObj.font, chart.chartId);
        var color;
        if( string2 ) {
          var index = parseInt(elem[1]),
          itemObj = chart.items[index];
          color = itemObj.color.color;
        }
        else {
          color = confObj.color;
        }
      var rect = null;
      switch (chart.defSettings.hierarchy.breadcrumb.layout) {
        case "rectangle":
          rect = container.append("rect")
            .attr("index", i)
            .attr("x", progrW)
            .attr("y", 0)
            .attr("width", stringW + offset)
            .attr("height", stringH + halfoffset)
          break;
        case "underline":
          break;
        default:
          rect = container.append("polygon")
            .attr("index", i)
            .attr("points", breadcrumbPoints(stringW, stringH, i))
            .attr("transform", "translate(" + progrW + ", 0)")
      }
      if( rect ) {
        if( confObj.css_class) rect.attr("class", confObj.css_class)
        else if( color ) rect.attr("fill", color)
        if( confObj.fnc ) {
          rect.style("cursor", "pointer")
          .on("click", function () {
            confObj.fnc(this, this.getAttribute("index"));
          });
        }
      }
      var text = container.append("text")
        .attr("x", i == 0 ? halfoffset : offset + 1)
        .attr("y", stringH)
        .attr("dy", - halfoffset / 2)
        .attr("index", i)
        .text(string)
        .attr("transform", "translate(" + progrW + ", 0)");
        setFont(text, confObj.font, chart);
        progrW = progrW + stringW + 2 * offset;
        if( confObj.fnc ) {
          text.style("cursor", "pointer")
          .on("click", function () {
            confObj.fnc(this, this.getAttribute("index"));
          });
        }
    }

    function breadcrumbPoints(width, height, i) {
      var offset = 10,
        h = height + offset / 2,
        points = [];
      points.push("0,0");
      points.push(width + offset + ",0");
      points.push(width + 2 * offset + "," + (h / 2));
      points.push(width + offset + "," + h);
      points.push("0," + h);
      if (i > 0) {
        points.push(offset + "," + (h / 2));
      }
      return points.join(" ");
    }
}
StdChart.prototype.DrawProgressDrawingBar = function () {
  return;

  if (this.drawStatic || !this.defSettings.animation || !this.defSettings.animation.animate)
    return;
  var grp = this.svg.append("g")
    .attr("id", this.chartId + "progressBar");
  grp.append("rect")
    .attr("x", 0)
    .attr("y", 0)
    .attr("width", this.defSettings.globals.width)
    .attr("height", 3)
    .style("fill", "#E0E0E0");
  grp.append("rect")
    .attr("class", "pbar")
    .attr("x", 0)
    .attr("y", 0)
    .attr("width", this.defSettings.globals.width)
    .attr("height", 3)
    .style("fill", "#F3F3F3");
}
StdChart.prototype.AnimateProgressBar = function () {
  d3.select("#" + this.chartId + "progressBar")
    .select(".pbar")
    .attr("width", 0)
    .transition()
    .duration(this.defSettings.animation.duration)
    .ease(d3.easeLinear)
    .attr("width", this.defSettings.globals.width);
}
StdChart.prototype.RemoveProgressBar = function () {
  d3.select("#" + this.chartId + "progressBar").remove();
}
StdChart.prototype.SetUsedFont = function (font) {
  var family = font.name,
    style = font.style,
    fontName,
    applyStyle = true;

  if (this.usedFonts.indexOf(family) < 0)
    this.usedFonts.push(family);

  return;

  switch (family) {
    case "Electronic Highway Sign":
      fontName = "electronic";
      break;
    case "JD LCD Rounded Regular":
      fontName = "jd_lcd_rounded";
      break;
    case "Ubuntu":
      fontName = "ubuntumono";
      break;
    default:
      fontName = family.toLowerCase();
      break;
  }

  fontName = Strtran(fontName, " ", "");

  switch (family) {
    case "Digital System":
    case "Electronic Highway Sign":
    case "JD LCD Rounded Regular":
    case "Lets go Digital":
    case "NovaMono":
    case "Arial":
    case "Arial Black":
    case "Comic Sans MS":
    case "Courier":
    case "Georgia":
    case "Lucida Sans":
    case "Tahoma":
    case "Times New Roman":
    case "Verdana":
      applyStyle = false;
      break;
    case "Share Tech Mono":
    case "VT323":
      fontName += "-regular";
      applyStyle = false;
      break;
  }

  if (applyStyle) {
    if (style == "B")
      fontName += "-bold";
    else if (style == "I") {
      if (fontName == "dejavusans")
        fontName += "-oblique";
      else if (fontName == "liquidcrystal")
        fontName += "-normalitalic";
      else if (fontName != "sourcecodepro")
        fontName += "-italic";
    }
    else if (style == "BI") {
      if (fontName == "dejavusans")
        fontName += "-boldoblique";
      else if (fontName != "sourcecodepro")
        fontName += "-bolditalic";
    }
    else {
      if (fontName == "liquidcrystal")
        fontName += "-normal";
      else if (fontName.indexOf("dejavu") < 0)
        fontName += "-regular";
    }
  }

  if (this.usedFonts.indexOf(fontName) < 0)
    this.usedFonts.push(fontName);
}
StdChart.prototype.SetFontsInSVG = function () {
  var defs = this.svg.select("defs"),
    prevHTML = defs.html(),
    styleString = ""; //"<style type='text/css'><![CDATA[" + getFontFace(this._ZtChart.fontsMap, this.usedFonts) + "]]></style>";

  defs.html(prevHTML + styleString);

  /*function getFontFace(fonts, usedFonts) {
    var fontFaceString = "";
    for (var i = 0; i < usedFonts.length; i++) {
      if (fonts[usedFonts[i]]) {
        fontFaceString += "@font-face {";
        fontFaceString += "font-family: '" + usedFonts[i] + "';";
          //font-style: italic;
          //font-weight: 400;
          fontFaceString += "src: url('" + fonts[usedFonts[i]] + "') format('truetype');";
          fontFaceString += "}";
      }
    }
    return fontFaceString;
  }*/
}
/******* */
StdChart.prototype.AppendBrush = function () {
  var parent = this.svg.node().parentNode,
    _this = this,
    scrollSize = 10;
  if (parent) {
    this.chartBrush = { obj: null, scale: null };
    this.chartBrush.scale = d3.scaleTime()
      .domain(this.scaleX.domain().slice())
      .range([0, this.defSettings.globals.width]);
    this.chartBrush.obj = d3.brushX()
      .extent([[0, 0], [this.defSettings.globals.width, scrollSize]])
      .handleSize(0)
      .on("brush", function () {
        if (Empty(d3.event.sourceEvent))
          return;
        var selection = d3.event.selection,
          domain = [_this.chartBrush.scale.invert(selection[0]), _this.chartBrush.scale.invert(selection[1])];
        _this.scaleX.domain(domain);
        d3.select("#" + _this.chartBrush.idAxis).call(_this.chartBrush.dAxis);
        d3.select("#" + _this.chartBrush.idAxis).select(".domain").remove();
        _this.ResetItems();
        _this._DrawChartElements();
        _this.AfterDrawRenderer();
      });

    d3.select(parent)
      .append("svg")
      .attr("id", this.chartId + "brushSVG")
      .attr("width", this.defSettings.globals.width)
      .attr("height", scrollSize)
      .append("g")
      .attr("class", "brush")
      .call(this.chartBrush.obj)
      .call(this.chartBrush.obj.move, this.chartBrush.scale.range());

    d3.select("#" + this.chartId + "brushSVG").select("g").selectAll(".overlay").remove();
    d3.select("#" + this.chartId + "brushSVG").select("g").selectAll(".selection").attr("cursor", "default");
  }
}
StdChart.prototype.UpdateBrush = function () {
  this.chartBrush.scale.domain([this.chartBrush.scale.domain()[0], this.scaleX.domain()[1]]);
  var group = d3.select("#" + this.chartId + "brushSVG").select("g");
  this.chartBrush.obj.move(group, [this.chartBrush.scale(this.scaleX.domain()[0]), this.defSettings.globals.width]);
}
StdChart.prototype.GetZoomIcon = function (type) {
  if (type == "plus")
    return getIconFromCode("ebec");
  return getIconFromCode("ed61");  // minus
}
StdChart.prototype.GetMarkerIcon = function (type) {
  var code = "ef9f";  // circle
  switch (type) {
    case 1:
      code = "ed2e";  // mrk
      break;
    case 2:
      code = "ed2b";  // map pin
      break;
    case 3:
      code = "edb0";  // neuter pin
      break;
    case 4:
      code = "eea2";  // geo fence
      break;
  }
  return getIconFromCode(code);
}
StdChart.prototype.GetIconFont = function () {
  return { name: "icons8_win10", size: 25, color: "#0D0F12", style: "N" };
}
StdChart.prototype.GetTooltipObject = function (isOther) {
  if (Empty(this.linkObj))
    return null;
  if (!isOther)
    return this.linkObj.tooltipObj;
  else
    return this._GetOtherTooltipObject();
}

/**** ELEMENTI ****/
StdChart.prototype.DrawLine = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var _this = this,
    fdata = data.filter(function (record) {
      return _this._IsNotExcludedDomain(record[xIndex]);
    }
    ),
    line = d3.line()
      .x(function (d, idx) {
        return _this._GetDomainInScale(d, xIndex, idx);
      })
      .y(function (d) {
        return cobj.scaleY(d[yIndex]);
      })
      .defined(function (d) {
        return d[yIndex] != null;
      })
      .curve(d3[this.defSettings.line.type]);

  container.append("path")
    .datum(fdata)
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        series: _this.seriesList[_this.valueFields.indexOf(_this._GetDrawingList()[dataIndex])],
        valueField: _this._GetDrawingList()[dataIndex],
        keyField: !Empty(_this.objConfig.keyField) ? d[xIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[idx] : d[xIndex],
        value: d[yIndex],
        itemType: "line"
      });
      return "line line_" + dataIndex + " TRANSP";
    })
    .attr("d", line);
}
StdChart.prototype.DrawBar = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var _this = this,
    fdata = data.filter(function (record) {
      return _this._IsNotExcludedDomain(record[xIndex]);
    }
    );

  container.selectAll(".bar_" + dataIndex)
    .data(fdata)
    .enter()
    .append("rect")
    .attr("class", function (d, index) {
      var mindex = cobj.index ? cobj.index : index;
      _this.items.push({
        itm: this,
        series: _this.seriesList[_this.valueFields.indexOf(_this._GetDrawingList()[dataIndex])],
        valueField: _this._GetDrawingList()[dataIndex],
        keyField: !Empty(_this.objConfig.keyField) ? d[xIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[mindex] : d[xIndex],
        value: d[yIndex],
        itemType: "bar",
        categoryCode: d[_this.categoryCodeIndex],
        transform: cobj.transform
      });
      _this._SetDifferenceInItem(_this.items[_this.items.length - 1], index);
      return "bar bar_" + mindex + "_" + dataIndex + " TRANSP";
    })
    .attr("x", function (d, index) {
      cobj.dbarIndex = index;
      return _this._GetBarX(d, dataIndex, xIndex, yIndex, cobj);
    })
    .attr("y", function (d, index) {
      cobj.dbarIndex = index;
      return _this._GetBarY(d, dataIndex, xIndex, yIndex, cobj);
    })
    .attr("width", function (d, index) {
      cobj.dbarIndex = index;
      return _this._GetBarWidth(d, yIndex, cobj);
    })
    .attr("height", function (d, index) {
      cobj.dbarIndex = index;
      return _this._GetBarHeight(d, yIndex, cobj);
    });
}
StdChart.prototype.DrawStackBar = function (container, data, cdata, dataIndex, xIndex, yIndex, cobj) {
  var _this = this,
    index,
    fdata = data.filter(function (record) {
      return _this._IsNotExcludedDomain(record[xIndex]);
    }
    );

  container.selectAll(".bar_" + dataIndex)
    .data(fdata)
    .enter()
    .append("rect")
    .attr("class", function (d) {
      index = _this.orgCategoryList.indexOf(d[xIndex]);
      _this.items.push({
        itm: this,
        series: _this.seriesList[_this.valueFields.indexOf(_this._GetDrawingList()[dataIndex])],
        valueField: _this._GetDrawingList()[dataIndex],
        keyField: !Empty(_this.objConfig.keyField) ? d[xIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[index] : d[xIndex],
        value: d[yIndex],
        realValue: !_this.defSettings.normalizeValues ? d[yIndex] : _this._ZtChart.orgData[index][yIndex],
        progrValue: cdata[index][yIndex],
        itemType: "bar",
        categoryCode: d[_this.categoryCodeIndex]
      });
      return "bar bar_" + index + "_" + dataIndex + " TRANSP";
    })
    .attr("x", function (d) {
      index = _this.orgCategoryList.indexOf(d[xIndex]);
      return _this._GetBarX(d, cdata[index], xIndex, yIndex, cobj);
    })
    .attr("y", function (d) {
      index = _this.orgCategoryList.indexOf(d[xIndex]);
      return _this._GetBarY(d, cdata[index], xIndex, yIndex, cobj);
    })
    .attr("width", function (d) {
      return _this._GetBarWidth(d, yIndex, cobj);
    })
    .attr("height", function (d) {
      return _this._GetBarHeight(d, yIndex, cobj);
    });
}
StdChart.prototype.DrawPie = function (container, data, dataIndex, xIndex, yIndex, id, arc) {
  var _this = this,
    pie,
    pieData,
    stAngle,
    angleCos,
    dList = this._GetAxisDrawingList(),
    fdata = data.filter(function (record) {
      if (typeof dList[0] != "number" && _this.domainIsNumber)
        return dList.indexOf(record[xIndex] + "") >= 0;
      /*else if( _this.dataOrder == 'column')
        return dList.indexOf(record[0]) >= 0;
      else */
        return dList.indexOf(record[xIndex]) >= 0;
    });

  pie = d3.pie()
    .value(function (d) {
      return Math.abs(d[yIndex]);
    })
    .sort(null);  // aggiunto altrimenti disegna le fette in ordine decrescente di valore nella torta

  if (isNaN(this.defSettings.orientation.startAngle))
    stAngle = 0;
  else
    stAngle = this.defSettings.orientation.startAngle - 90;
  angleCos = stAngle * (Math.PI / 180);
  pie.startAngle(angleCos).endAngle((2 * Math.PI) + angleCos);

  pieData = pie(fdata);
  this.pieData[dataIndex] = pieData;

  container.selectAll(".pie_")
    .data(pieData)
    .enter()
    .append("path")
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        series: _this.seriesList[dataIndex],
        valueField: _this.valueFields[dataIndex] ? _this.valueFields[dataIndex] : _this.seriesList[dataIndex], //MG VPV
        keyField: !Empty(_this.objConfig.keyField) ? d.data[_this.xIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[idx] : d.data[_this.xIndex],
        value: (yIndex>=0) ? d.data[yIndex] : 0, //MG VPV
        dataIndex: dataIndex,
        //startAngle: angleCos,
        startAngle: d.startAngle,
        endAngle: d.endAngle,
        itemType: "pie",
        categoryCode: d.data[_this.categoryCodeIndex],
        radius: _this._GetRadius(),
        _3dFactor: 1,
        centroid: arc.centroid(d)
      });
      return "pie pie_" + idx + "_" + dataIndex + " TRANSP";
    })
    .attr("d", function (d) {
      return arc(d);
    })
    .each(function (/*d*/) { this._arc = arc; });
}
StdChart.prototype.DrawPie3D = function (container, data, dataIndex, xIndex, yIndex, id, arc, radius, innerRadius) {
  var _this = this,
    pie,
    pieData,
    h = radius / 4,  // variabile portata nella dichiarazione "generale" del calcolo, e rappresenta altezza totale dello spessore 3D
    _3dFactor = 0.5,
    _3d = container.append("g")
      .attr("id", id + "3dGroup"),
    dList = this._GetAxisDrawingList(),
    fdata = data.filter(function (record) { return dList.indexOf(record[xIndex]) >= 0; }),
    stAngle,
    angleCos;

  pie = d3.pie()
    .value(function (d) {
      return Math.abs(d[yIndex]);
    })
    .sort(null);  // aggiunto altrimenti disegna le fette in ordine decrescente di valore nella torta

  if (isNaN(this.defSettings.orientation.startAngle))
    stAngle = 0;
  else
    stAngle = this.defSettings.orientation.startAngle - 90;
  angleCos = stAngle * (Math.PI / 180);
  pie.startAngle(angleCos).endAngle((2 * Math.PI) + angleCos);

  pieData = pie(fdata);
  this.pieData[dataIndex] = pieData;

  var rightHalf = Math.floor(pieData.length / 2);
  if (Empty(rightHalf))
    rightHalf = 1;
  for (var j = 0; j < rightHalf - 1; j++)
    draw3DPaths(pieData, pieData.length - (j + 1), _3d, dataIndex, true);

  for (j = 0; j <= (pieData.length - rightHalf); j++)
    draw3DPaths(pieData, j, _3d, dataIndex, true);

  for (j = 0; j < rightHalf - 1; j++)
    draw3DPaths(pieData, pieData.length - (j + 1), _3d, dataIndex);

  for (j = 0; j <= (pieData.length - rightHalf); j++)
    draw3DPaths(pieData, j, _3d, dataIndex);

  container.selectAll(".pie_")
    .data(pieData)
    .enter()
    .append("path")
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        series: _this.seriesList[dataIndex],
        valueField: _this.valueFields[dataIndex],
        keyField: !Empty(_this.objConfig.keyField) ? d.data[xIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[idx] : d.data[xIndex],
        value: d.data[yIndex],
        dataIndex: dataIndex,
        itemType: "pie",
        startAngle: d.startAngle,
        endAngle: d.endAngle,
        categoryCode: d.data[_this.categoryCodeIndex],
        radius: radius,
        _3dFactor: _3dFactor,
        centroid: arc.centroid(d)
      });
      return "pie pie_" + dataIndex + "_" + idx + " TRANSP";
    })
    .attr("d", function (d) {
      return pieTop(d, radius, radius * _3dFactor, innerRadius);
    })
    .each(function (/*d*/) { this._arc = arc; this._pieTop = pieTop; this._radius = radius; this._draw3DPaths = draw3DPaths; this._pieOuter = pieOuter; });

  function pieTop(d, rx, ry, ir) {
    if (pieData.length == 1)
      d.endAngle = d.endAngle - 0.0000001;
    var initAngle = Math.PI / 2;
    if (d.endAngle - d.startAngle == 2 * Math.PI)
      initAngle = 0;
    if (d.startAngle == 0)
      d.startAngle = d.startAngle + 0.0000001;
    var sx = rx * Math.cos(d.startAngle - initAngle),
      sy = ry * Math.sin(d.startAngle - initAngle),
      ex = rx * Math.cos(d.endAngle - initAngle),
      ey = ry * Math.sin(d.endAngle - initAngle);
    var ret = [];
    ret.push("M", sx, sy, "A", rx, ry, "0", (d.endAngle - d.startAngle > Math.PI ? 1 : 0), "1", ex, ey, "L", ir * ex, ir * ey);
    ret.push("A", ir * rx, ir * ry, "0", (d.endAngle - d.startAngle > Math.PI ? 1 : 0), "0", ir * sx, ir * sy, "z");
    return ret.join(" ");
  }

  function pieOuter(d, rx, ry, h) {
    var startAngle = ((d.startAngle <= Math.PI / 2) ? 0 : d.startAngle >= 1.5 * Math.PI ? Math.PI : d.startAngle - (Math.PI / 2)),
      endAngle = (d.endAngle <= Math.PI / 2 ? 0 : d.endAngle >= 1.5 * Math.PI ? Math.PI : d.endAngle - (Math.PI / 2)),
      sx = rx * Math.cos(startAngle),
      sy = ry * Math.sin(startAngle),
      ex = rx * Math.cos(endAngle),
      ey = ry * Math.sin(endAngle);
    var ret = [];
    ret.push("M", sx, h + sy, "A", rx, ry, "0 0 1", ex, h + ey, "L", ex, ey, "A", rx, ry, "0 0 0", sx, sy, "z");
    return ret.join(" ");
  }

  function draw3DPaths(pieD, index, grp, i, isV, __this) {
    pieOuter = __this ? __this._pieOuter : pieOuter;
    if (pieD.length == 1)
      pieD[index].endAngle = 2 * Math.PI;
    var myCat = _this.orgCategoryList.indexOf(pieD[index].data[_this.xIndex]);
    if (isV) {
      var appendPath = [],
        arc_x_end = (radius * Math.sin(pieD[index].endAngle)),
        arc_y_end = - (radius * _3dFactor * Math.cos(pieD[index].endAngle)),
        arc_x_start = (radius * Math.sin(pieD[index].startAngle)),
        arc_y_start = - (radius * _3dFactor * Math.cos(pieD[index].startAngle));
      appendPath[1] = 'M' + arc_x_start + ',' + arc_y_start + 'V' + (arc_y_start + h) + 'L0,' + h + 'V0Z';
      appendPath[2] = 'M' + arc_x_end + ',' + arc_y_end + 'V' + (arc_y_end + h) + 'L0,' + h + 'V0Z';
      if (arc_x_start <= 0) {
        var idx = index + 1;
        if (idx == pieD.length)
          idx = 0;

        arc_x_start = (radius * Math.sin(pieD[idx].startAngle));
        arc_y_start = - (radius * _3dFactor * Math.cos(pieD[idx].startAngle));

        grp.append('path')
          .attr("class", "piePath0 pie_" + i + " pie3D_" + i + '_' + myCat)
          .attr('d', 'M' + arc_x_start + ',' + arc_y_start + 'V' + (arc_y_start + h) + 'L0,' + h + 'V0Z');

        grp.append('path')
          .attr("class", "piePath1 pie_" + i + " pie3D_" + i + '_' + myCat)
          .attr('d', appendPath[1]);

        grp.append('path')
          .attr("class", "piePath2 pie_" + i + " pie3D_" + i + '_' + myCat)
          .attr('d', appendPath[2]);

        appendPath[1] = '';
        appendPath[2] = '';
      }

      if (!Empty(appendPath[1]) && !Empty(appendPath[2])) {
        grp.append('path')
          .attr("class", "piePath1 pie_" + i + " pie3D_" + i + '_' + myCat)
          .attr('d', appendPath[1]);

        grp.append('path')
          .attr("class", "piePath2 pie_" + i + " pie3D_" + i + '_' + myCat)
          .attr('d', appendPath[2]);
      }
    }
    else {
      grp.append("path")
        .attr("class", "piePathOUT pie_" + i + " p3D_" + i + '_' + myCat)
        .attr("d", pieOuter(pieD[index], radius, radius * _3dFactor, h, i));
    }
  }
}
StdChart.prototype.DrawArea = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var _this = this,
    fdata = data.filter(function (record) {
      return _this._IsNotExcludedDomain(record[xIndex]);
    }
    );
  var minScale = d3.min(cobj.scaleY.domain()) < 0 ? cobj.scaleY(0) : cobj.scaleY(d3.min(cobj.scaleY.domain())),
    area = d3.area()
      .x(function (d) {
        return _this._GetDomainInScale(d, xIndex);
      })
      .y0(function (/*d*/) {
        return minScale;
      })
      .y1(function (d) {
        return cobj.scaleY(d[yIndex]);
      })
      .defined(function (d) {
        return d[yIndex] != null;
      })
      .curve(d3[this.defSettings.line.type]);

  container.append("path")
    .datum(fdata)
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        series: _this.seriesList[dataIndex],
        valueField: _this._GetDrawingList()[dataIndex],
        itemType: "area"
      });
      return "area area_" + idx + "_" + dataIndex + " TRANSP";
    })
    .attr("d", area);
}
StdChart.prototype.DrawStackArea = function (container, data, cdata, dataIndex, xIndex, yIndex, cobj) {
  var _this = this,
    fdata = cdata.filter(function (record) {
      return _this._IsNotExcludedDomain(record[xIndex]);
    }
    );

  var area = d3.area()
    .x(function (d) {
      return _this._GetDomainInScale(d, xIndex);
    })
    .y0(function (d) {
      return cobj.scaleY(d[cobj.prevYIndex]);
    })
    .y1(function (d) {
      return cobj.scaleY(d[yIndex]);
    })
    .defined(function (d) {
      return d[yIndex] != null;
    })
    .curve(d3[this.defSettings.line.type]);

  container.append("path")
    .datum(fdata)
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        series: _this.seriesList[dataIndex],
        valueField: _this._GetDrawingList()[dataIndex],
        itemType: "area"
      });
      return "area area_" + idx + "_" + dataIndex + " TRANSP";
    })
    .attr("d", area);
}
StdChart.prototype.DrawTreeMap = function (container, data, posobj, containerLabels) {
  var _this = this,
    gFont,
    initSize,
    treemap,
    fdata,
    hie,
    root;

  fdata = this._GetFilteredDataTreemap(data);

  hie = d3.hierarchy(fdata);

  if (this.defSettings.treemap.dataOrder == 'descendent')
    root = hie.sum(function (d) { return d.size; }).sort(function (a, b) { return b.value - a.value; });
  else if (this.defSettings.treemap.dataOrder == 'none')
    root = hie.sum(function (d) { return d.size; });
  else
    root = hie.sum(function (d) { return d.size; }).sort(function (a, b) { return a.value - b.value; });

  treemap = getTreemapLayout(this.defSettings.treemap.tileStyle)
    .paddingInner(this.defSettings.treemap.innerPadding)
    .paddingOuter(this.defSettings.treemap.outerPadding)
    .size([posobj.width, posobj.height]);
  treemap(root);

  var leaves = hie.leaves(),
    idx,
    appFont = { name: this.defSettings.globalFont.name, color: this.defSettings.globalFont.color };
  for (var i = 0; i < leaves.length; i++) {
    var d = leaves[i];
    container.append("rect")
      .attr("class", function () {
        d.index = i;
        _this.items.push({
          itm: this,
          series: d.data.serie || d.data.name,
          valueField: _this.valueFields[d.data.vIndex],
          keyField: d.data.keyF,
          category: d.parent ? (d.parent.data.name + " - " + d.data.name) : d.data.name,
          value: d.size || d.value,//d.data.realValue,
          categoryCode: d.data.categoryCode,
          x: d.x0,
          y: d.y0,
          width: d.x1 - d.x0,
          height: d.y1 - d.y0,
          itemType: "treemap",
          transform: [posobj.x, posobj.y],
          parent: d.parent,
          depth: d.depth,
          parentName: d.data.parentName,
          index: i,
          name: d.data.name
        });
        if (d.data.realValue < 0 && !_this.hasNegativeValues)
          _this.hasNegativeValues = true;
        return "treemap treemap_" + d.data.index + "_" + d.data.vIndex + " node TRANSP";
      })
      .attr("x", d.x0)
      .attr("y", d.y0)
      .attr("width", (d.x1 - d.x0))
      .attr("height", (d.y1 - d.y0));

    if (containerLabels) {
      gFont = JSON.stringify(this.defSettings.globalFont);
      gFont = JSON.parse(gFont);
      initSize = gFont.size;
      var label = containerLabels.append("text")
        .attr("class", "treemapText")
        .text(function () {
          if (i == 0)
            idx = -1;
          if (d.data.name) {
            idx++;
            gFont.size = initSize;
            var name = d.data.name,
              opt = optimizeFontSize("in", name, gFont, _this.items[idx], 0.25, _this.chartId);
            _this.items[idx].isV = opt.isV;
            _this.items[idx].font = JSON.parse(opt.font);
            _this.items[idx].textWidth = opt.txtW;
            _this.items[idx].textHeight = opt.txtH;
            _this.items[idx].textItm = this;
            return opt.txt;
          }
        })
        .attr("x", function () {
          //if (i == 0)
          //idx = -1;
          if (d.data.name) {
            // idx ++;
            if (_this.items[idx].isV)
              return - d.y0 - _this.items[idx].height;
            return d.x0 + 1;
          }
        })
        .attr("y", function () {
          // if (i == 0)
          // idx = -1;
          if (d.data.name) {
            //idx ++;
            if (_this.items[idx].isV)
              return d.x0 + _this.items[idx].textHeight - 2; // 2 di stroke
            return d.y0 + _this.defSettings.globalFont.size;
          }
        })
        .attr("transform", function () {
          //    if (i == 0)
          //    idx = -1;
          if (d.data.name) {
            //  idx ++;
            if (_this.items[idx].isV)
              return "rotate(-90)";
            return "";
          }
        })
      appFont.size = (d.data.name) ? _this.items[idx].font.size : this.defSettings.globalFont.size;
      setFont(label, appFont, this);
    }
  }
}
StdChart.prototype.DrawRadar = function (container, data, cdata/*, xIndex*/) {
  var _this = this,
    dlist = this._GetAxisDrawingList(),
    fdata = cdata.filter(function (record, index) {
      return dlist.indexOf(data[index][_this.xIndex]) >= 0;
    }
    ),
    flist = _this.orgCategoryList.filter(function (record) {
      return dlist.indexOf(record) >= 0;
    }
    );

  container.selectAll(".radar")
    .data(fdata)
    .enter()
    .append("path")
    .attr("class", function (d, index) {
      _this.items.push({
        itm: this,
        series: _this.seriesList[index],
        keyField: !Empty(_this.objConfig.keyField) ? flist[index] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.orgCategoryList[index] : flist[index],
        itemType: "radar"
      });
      return "radar radar_" + index + " TRANSP";
    })
    .attr(/*"points"*/"d", function (d) {
      var points = "";
      for (var pti = 0; pti < d.length; pti++)
        points = points + d[pti].x + "," + d[pti].y + " ";
      return "M" + points + "Z";
    });
}
StdChart.prototype.DrawXYZ = function (container, data, xIndex, yIndex, seriesIndex, zIndex, bypassSerie) {
  var _this = this,
    progr = {},
    ser,
    serKey,
    fdata = data.filter(function (record) {
      var ser = record[seriesIndex];
      if (_this.seriesIsTime)
        ser = _this.stdFormat(ser);
      return _this._IsNotExcludedSeries(ser);
    }
    );

  container.selectAll(".xyz")
    .data(fdata)
    .enter()
    .append("circle")
    .attr("class", function (d/*, idx*/) {
      if (!bypassSerie) {
        ser = !Empty(_this.objConfig.keyField) ? _this.seriesList[_this.orgSeriesList.indexOf(d[seriesIndex])] : d[seriesIndex];
        if (_this.seriesIsTime)
          ser = _this.stdFormat(ser);
        serKey = d[seriesIndex];
        if (_this.seriesIsTime)
          serKey = _this.stdFormat(serKey);
      }
      else {
        ser = d[seriesIndex];
        serKey = d[seriesIndex];
      }
      serKey = replaceSpecialCharsForID(serKey);
      if (!(ser in progr))
        progr[ser] = 0;
      progr[ser]++;
      _this.items.push({
        itm: this,
        keyField: !Empty(_this.objConfig.keyField) ? d[seriesIndex] : "",
        series: ser,
        progrSeries: progr[ser],
        x: d[xIndex],
        y: d[yIndex],
        z: d[zIndex],
        itemType: "xyz",
        categoryCode: d[_this.categoryCodeIndex],
        coordinates: {
          x: _this._GetXCoordinate(d, xIndex),
          y: _this._GetYCoordinate(d, yIndex, serKey),
          z: _this._GetZCoordinate(d, zIndex, -1) // metto -1 perche' non ho ancora valutato
        }
      });
      _this.items[_this.items.length - 1].position = _this.items.length - 1;
      _this._CheckOverlap(_this.items[_this.items.length - 1], _this.items.length - 1);

      return "xyz xyz TRANSP";
    })
    .attr("cx", function (d) {
      return _this._GetXCoordinate(d, xIndex);
    })
    .attr("cy", function (d) {
      var series = /*!Empty(_this.objConfig.keyField) ? _this.seriesList[_this.orgSeriesList.indexOf(d[seriesIndex])] :*/ d[seriesIndex];
      if (_this.seriesIsTime)
        series = _this.stdFormat(series);
      series = replaceSpecialCharsForID(series);
      return _this._GetYCoordinate(d, yIndex, series);
    })
    .attr("r", function (d, idx) {
      var r = _this._GetZCoordinate(d, zIndex, idx);
      if (r < 0)
        r = 0;
      _this.items[idx].r = r;
      return r;
    });
}
StdChart.prototype.DrawWordCloud = function (container, data, dataIndex, xIndex, yIndex, gWidth, gHeight/*, id*/) {
  var _this = this,
    appFont = appliedFont(this.defSettings, this.defSettings.layout, this.defSettings.layout.wcFont),
    fontStyle = "normal",
    fontWeight = "normal",
    scaleRotate = d3.scaleLinear()
      .domain([0, this.defSettings.layout.anglesCount - 1])
      .range([this.defSettings.layout.minOrientation, this.defSettings.layout.maxOrientation]),
    //mwidth = getOffsetWidth(this.categoryList[this.allValues.index], {size: 100, name: appFont.name, style: appFont.style}, id),
    wordsArray = [],
    fontString = "",
    mfontsize = 100, //(100 * Math.min(gWidth, gHeight)) / mwidth
    scale = d3.scaleLinear()
      .range([10, mfontsize]) // 2px minimo font - 65% del max calcolato
      .domain([this.allValues.min, this.allValues.max]),
    dList = this._GetAxisDrawingList(),
    fdata = data.filter(function (record) { return dList.indexOf(record[xIndex]) >= 0; });

  if (appFont.style == "B")
    fontWeight = "bold";
  else if (appFont.style == "I")
    fontStyle = "italic";
  else if (appFont.style == "BI") {
    fontStyle = "italic";
    fontWeight = "bold";
  }

  for (var k = 0; k < fdata.length; k++) {
    wordsArray.push({
      text: !Empty(_this.objConfig.keyField) ? fdata[k][_this.xLabelIndex] : fdata[k][xIndex],
      size: scale(Math.abs(fdata[k][yIndex])),
      index: k,
      t_key: fdata[k][xIndex]
    }
    );
  }

  d3.layout.cloud()
    .size([gWidth, gHeight])
    .words(wordsArray)
    .rotate(function (/*d*/) {
      return scaleRotate(~~(Math.random() * _this.defSettings.layout.anglesCount));
    })
    .font(appFont.name)
    .fontSize(function (d) {
      return d.size;
    })
    .on("end", draw)
    .start();

  function draw(words) {
    container.selectAll("text")
      .data(words)
      .enter()
      .append("text")
      .each(function (d/*, idx*/) {
        fontString = fontStyle + " " + fontWeight + " " + d.size + "px " + appFont.name;
        _this.items.push({
          itm: this,
          value: fdata[d.index][yIndex],
          keyField: d.t_key,
          category: d.text,
          texthover: d.text,
          series: _this.seriesList[dataIndex],
          valueField: _this.valueFields[dataIndex],
          transform: [d.x, d.y],
          rotate: d.rotate,
          font: fontString,
          dataIndex: dataIndex,
          categoryCode: fdata[d.index][_this.categoryCodeIndex]
        }
        )
      })
      .attr("transform", function (d) {
        return "translate(" + [d.x, d.y] + ") rotate(" + d.rotate + ")";
      })
      .text(function (d/*, idx*/) {
        return !Empty(_this.objConfig.keyField) ? _this.labelCategoryList[d.index] : d.text;
      })
      .attr("style", function (d) {
        var stObj = {
          font9size: d.size + "px",
          font9family: appFont.name,
          font9style: fontStyle,
          font9weight: fontWeight,
          text9anchor: "middle"
        };
        return makeStyleHTMLString(stObj, d3.select(this).attr("style"))
      })
      .attr("class", function (d/*, idx*/) {
        return "word word_" + d.index + "_" + dataIndex + " TRANSP";
      });
  }
}
StdChart.prototype.DrawPointer = function (container, data, dataIndex, xIndex, id) {
  var _this = this,
    type = this.defSettings.pointCap.type.toLowerCase(),
    group,
    scaleKey,
    scaleY,
    radius,
    pointOs = this.defSettings.pointCap.radius,
    base = this.defSettings.pointCap.baseRadius,
    dataValue,
    isOut,
    vRange,
    rot,
    rstart,
    dList = this._GetDrawingList(),
    fdata = data[0],
    yIndex;

  group = container.append("g")
    .attr("id", id + "pointerGroup");

  for (var i = 0; i < dList.length; i++) {
    scaleKey = dList[i];
    scaleY = this.scaleY[this.scaleY[scaleKey].__refAxis];
    radius = scaleY.__radius
    vRange = this._GetCustomAxisMinMax(scaleKey, dataIndex, this.defSettings.tickAxis.minValue, this.defSettings.tickAxis.maxValue);
    rstart = 180 / Math.PI * scaleY(vRange.min);

    yIndex = this.propertyName.indexOf(dList[i]);
    isOut = false;
    dataValue = fdata[yIndex];
    rot = 180 / Math.PI * scaleY(dataValue);
    if (dataValue < vRange.min || dataValue > vRange.max) {
      isOut = true;
      if (Math.abs(vRange.min - dataValue) < Math.abs(vRange.max - dataValue))
        rot = 180 / Math.PI * scaleY(vRange.min);
      else
        rot = 180 / Math.PI * scaleY(vRange.max);
    }

    switch (type) {
      case "pointer":
        group.append("path")
          .attr("class", function () {
            _this.items.push({
              itm: this,
              rotate: rot,
              startRotate: rstart,
              dataIndex: dataIndex,
              series: _this._GetAxisDrawingList()[i],
              valueField: dList[i],
              keyField: !Empty(_this.objConfig.keyField) ? fdata[xIndex] : "",
              category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : fdata[xIndex],
              value: dataValue,
              isOut: isOut,
              itemType: "pointer",
              categoryCode: fdata[_this.categoryCodeIndex]
            });
            return "pointer pointer_" + i + "_" + dataIndex + " TRANSP";
          })
          .attr("d", function () {
            var str = "M -" + (radius * base) + ",0 ";
            str += "L 0," + (- radius * pointOs);
            str += "L " + (radius * base) + ",0 Z";
            return str;
          })
        break;
      case "pin":
        group.append("line")
          .attr("class", function () {
            _this.items.push({
              itm: this,
              rotate: rot,
              startRotate: rstart,
              dataIndex: dataIndex,
              series: _this._GetAxisDrawingList()[i],
              valueField: dList[i],
              keyField: !Empty(_this.objConfig.keyField) ? fdata[xIndex] : "",
              category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : fdata[xIndex],
              value: dataValue,
              isOut: isOut,
              itemType: "pointer",
              categoryCode: fdata[_this.categoryCodeIndex]
            });
            return "pointer pointer_" + i + "_" + dataIndex + " TRANSP";
          })
          .attr("x1", 0)
          .attr("x2", 0.5)
          .attr("y1", 0)
          .attr("y2", - ((radius * pointOs) + scaleY(dataValue)))
        break;
      case "needle":
        group.append("path")
          .attr("class", function () {
            _this.items.push({
              itm: this,
              rotate: rot,
              startRotate: rstart,
              dataIndex: dataIndex,
              series: _this._GetAxisDrawingList()[i],
              valueField: dList[i],
              keyField: !Empty(_this.objConfig.keyField) ? fdata[xIndex] : "",
              category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : fdata[xIndex],
              value: dataValue,
              isOut: isOut,
              itemType: "pointer",
              categoryCode: fdata[_this.categoryCodeIndex]
            });
            return "pointer pointer_" + i + "_" + dataIndex + " TRANSP";
          })
          .attr("d", function () {
            var str = "M -4,25 ";
            str += "L 0," + (- radius * pointOs);
            str += "L 4,25 Z";
            return str;
          })
        break;
      case "reverse":
        group.append("path")
          .attr("class", function () {
            _this.items.push({
              itm: this,
              rotate: rot,
              startRotate: rstart,
              dataIndex: dataIndex,
              series: _this._GetAxisDrawingList()[i],
              valueField: dList[i],
              keyField: !Empty(_this.objConfig.keyField) ? fdata[xIndex] : "",
              category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : fdata[xIndex],
              value: dataValue,
              isOut: isOut,
              itemType: "pointer",
              categoryCode: fdata[_this.categoryCodeIndex]
            });
            return "pointer pointer_" + i + "_" + dataIndex + " TRANSP";
          })
          .attr("d", function () {
            var str = "M 0,0 ";
            str += "L -4," + (- radius * pointOs);
            str += "L 4," + (- radius * pointOs) + " Z";
            return str;
          })
        break;
      case "arrow":
        group.append("path")
          .attr("class", function () {
            _this.items.push({
              itm: this,
              rotate: rot,
              startRotate: rstart,
              dataIndex: dataIndex,
              series: _this._GetAxisDrawingList()[i],
              valueField: dList[i],
              keyField: !Empty(_this.objConfig.keyField) ? fdata[xIndex] : "",
              category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : fdata[xIndex],
              value: dataValue,
              isOut: isOut,
              itemType: "pointer",
              categoryCode: fdata[_this.categoryCodeIndex]
            });
            return "pointer pointer_" + i + "_" + dataIndex + " TRANSP";
          })
          .attr("d", function () {
            var str = "M 0,0 ";
            str += "L 0," + (- radius * pointOs);
            str += "L -4," + (- radius * pointOs);
            str += "L 0," + ((- radius * pointOs) - 5);
            str += "L 4," + (- radius * pointOs);
            str += "L 0," + (- radius * pointOs) + " Z";
            return str;
          })
        break;
    }
  }

  if (type != "reverse") {
    group.append("circle")
      .attr("class", function () {
        _this.items.push({
          itm: this,
          rotate: 0,
          startRotate: 0,
          dataIndex: dataIndex,
          series: _this.seriesList[dataIndex],
          valueField: _this.valueFields[dataIndex],
          itemType: "pointerCap"
        });
        return "cap cap_" + dataIndex + " TRANSP";
      })
      .attr("cx", 0)
      .attr("cy", 0)
      .attr("r", radius * this.defSettings.pointCap.capRadius);
  }
}
StdChart.prototype.DrawThermometer = function (container, data, dataIndex, cobj) {
  var _this = this,
    radius = this._GetRadius(),
    measure = this.hElement,
    radFactor = radius * 1.1,
    group,
    scaleKey,
    vRange,
    bitem,
    gHeight = this.pHeight,
    barWidth = cobj.barWidth,
    id = cobj.id,
    ccobj,
    yIndex,
    dList = this._GetDrawingList();

  container.append("path")
    .attr("id", id + "border")
    .attr("d", function () {
      var str;
      if (!_this.isH) {
        str = "M" + (radFactor / 2) + "," + (gHeight - 2 * radFactor);
        str += "l" + 0 + "," + (- measure);
        str += "A" + (radFactor / 2) + "," + (radFactor / 2) + " 0 0,1 " + 3 * (radFactor / 2) + "," + (gHeight - measure - 2 * radFactor);
        str += "l" + 0 + "," + measure;
        str += "A" + radFactor + "," + radFactor + " 0 1,1 " + (radFactor / 2) + "," + (gHeight - 2 * radFactor);
      }
      else {
        str = "M" + (2 * radFactor) + "," + (radFactor / 2);
        str += "l" + measure + "," + 0;
        str += "A" + (radFactor / 2) + "," + (radFactor / 2) + " 0 0,1 " + (measure + 2 * radFactor) + "," + 3 * (radFactor / 2);
        str += "l" + (- measure) + "," + 0;
        str += "A" + radFactor + "," + radFactor + " 0 1,1 " + (2 * radFactor) + "," + (radFactor / 2);
      }
      return str;
    });

  for (var i = 0; i < dList.length; i++) {
    yIndex = this.propertyName.indexOf(dList[i]);
    scaleKey = dList[i];
    group = container.append("g")
      .attr("id", id + "barsGroup_" + i);
    barWidth = barWidth - i * (barWidth / dList.length);
    ccobj = ZtLayeredBarChart.prototype._GetDrawParamObject.call(this, barWidth);
    ccobj.index = i;
    ccobj.scaleY = this.scaleY[scaleKey];
    ccobj.transform = cobj.transform;
    this.DrawBar(group, data, i, this.xIndex, yIndex, ccobj);
    bitem = this.items[this.items.length - 1];
    bitem.barWidth = barWidth;
    bitem.groupTransform = cobj.groupTransform;

    bitem.isOut = false;
    vRange = this._GetCustomAxisMinMax(scaleKey, dataIndex);
    if (bitem.value < vRange.min || bitem.value > vRange.max)
      bitem.isOut = true;
    bitem.radius = (radius - i * (radius / dList.length)) / 2;

    var bb = d3.select("#" + id + "border").node().getBBox();
    group.selectAll(".circle_" + dataIndex)
      .data(data)
      .enter()
      .append("circle")
      .attr("class", function (d/*, idx*/) {
        _this.items.push({
          itm: this,
          series: _this.seriesList[i],
          valueField: dList[i],
          keyField: !Empty(_this.objConfig.keyField) ? d[_this.xIndex] : "",
          category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : d[_this.xIndex],
          value: d[yIndex],
          itemType: "circle",
          categoryCode: d[_this.categoryCodeIndex],
          isOut: bitem.isOut
        });
        return "circle circle_" + dataIndex + "_" + i + " TRANSP";
      })
      .attr("cx", function () {
        if (!_this.isH)
          return radFactor;
        return bb.x + radFactor;
      })
      .attr("cy", function () {
        if (!_this.isH)
          return (gHeight - radFactor) - ((gHeight - bb.height) - bb.y);
        return radFactor;
      })
      .attr("r", function (/*d, idx*/) {
        var tbw = radius - i * (radius / dList.length);
        return tbw;
      });
  }
}
StdChart.prototype.DrawImages = function (container, data, dataIndex, id, gWidth, gHeight) {
  var _this = this,
    dList = this._GetDrawingList(),
    positions = this.GetRendererSubdivisionsSizes(dList.length, gWidth, gHeight),
    xIndex = this.xIndex,
    yIndex,
    pw,
    vlhos = 0,
    vlwos = 0,
    offset = 7.5;

  if (this.defSettings.valueLabel.show != "hide") {
    var appFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
      vlt = this.GetValueLabelMaxWord(this.dataSet),
      vlw = getOffsetWidth(vlt, appFont, this.chartId),
      vlh = getOffsetHeight(vlt, appFont, this.chartId);
    if (this.defSettings.valueLabel.position == "otop" || this.defSettings.valueLabel.position == "obottom")
      vlhos = vlh + offset;
    else
      vlwos = vlw + offset;
  }

  for (var i = 0; i < positions.length; i++) {
    positions[i].width = positions[i].width - vlwos;
    positions[i].height = positions[i].height - vlhos;
    if (this.defSettings.valueLabel.show != "hide") {
      if (this.defSettings.valueLabel.position == "otop")
        positions[i].y = positions[i].y + vlhos;
      else if (this.defSettings.valueLabel.position == "oleft")
        positions[i].x = positions[i].x + vlwos;
    }

    pw = positions[i].width;
    if (!this.noRange && this.defSettings.range.applyColor && (!this.chartLegends.series.hide || this.chartLegends.series.position != "hide"))
      pw = pw - this.GetDefaultIconFont().size;
    else if (!this.noRange && this.isIcon && !this.defSettings.range.applyColor && (!this.chartLegends.range.hide || this.chartLegends.range.position != "hide"))
      pw = pw - this.GetDefaultIconFont().size;

    yIndex = this.propertyName.indexOf(dList[i]);
    if (!this.isIcon) {
      container
        .datum(data)
        .append("image")
        .attr("class", function () {
          _this.items.push({
            itm: this,
            series: _this.seriesList[i],
            valueField: dList[i],
            keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
            category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
            value: data[0][yIndex],
            itemType: "image",
            categoryCode: data[0][_this.categoryCodeIndex],
            coordinates: positions[i]
          });

          return "image image_" + dataIndex + "_" + i + " TRANSP";
        })
        .attr("transform", function () {
          return "translate(" + [positions[i].x, positions[i].y] + ")";
        })
        .attr("width", function () {
          return pw + "px";
        })
        .attr("height", function () {
          return positions[i].height + "px";
        })
        .attr("xlink:href", function () {
          var rootUrl = _this.GetWebRootURL();
          var ret;
          if (_this.applySPTheme)
            ret = rootUrl + "/" + ZtVWeb.theme + "/";
          else
            ret = rootUrl + "/";
          var rangeO = _this.GetImageAndIconFromRange(data[0][yIndex], _this.defSettings.range.bands);
          if (!Empty(rangeO.imageUrl)) {
            if (rangeO.imageUrl.indexOf("http://") >= 0 || rangeO.imageUrl.indexOf("https://") >= 0 || rangeO.imageUrl.indexOf(rootUrl) >= 0)
              ret = rangeO.imageUrl;
            else
              ret += rangeO.imageUrl;
          }
          else
            ret += _this.notAvailable;
          return ret;
        });
    }
    else {
      container
        .datum(data)
        .append("text")
        .attr("class", function () {
          var rangeO = _this.GetImageAndIconFromRange(data[0][yIndex], _this.defSettings.range.bands);
          _this.items.push({
            itm: this,
            series: _this.seriesList[i],
            valueField: dList[i],
            keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
            category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
            value: data[0][yIndex],
            itemType: "image",
            categoryCode: data[0][_this.categoryCodeIndex],
            iconCode: rangeO.iconCode || _this.notAvailable,
            rangeColor: rangeO.color,
            coordinates: positions[i],
            fontFamily: rangeO.fontFamily || "svgCharts"
          });
          return "icon icon_" + dataIndex + "_" + i + " TRANSP";
        })
        .attr("x", function () {
          var msize = Math.min(positions[i].width, positions[i].height),
            marea = Math.max(positions[i].width, positions[i].height);
          return positions[i].x + ((marea - msize) / 2);
        })
        .attr("y", function () {
          return positions[i].y + Math.min(positions[i].width, positions[i].height);
        })
        .style("font-size", function () {
          return Math.min(pw, positions[i].height) + "px";
        })
        .style("font-family", function () {
          return _this.items[_this.items.length - 1].fontFamily;
        })
        .text(function () {
          return getIconFromCode(_this.items[_this.items.length - 1].iconCode);
        })
    }
  }
}
StdChart.prototype.DrawLights = function (container, data, dataIndex, id, gWidth, gHeight) {
  var _this = this,
    dList = this._GetDrawingList(),
    positions = this.GetRendererSubdivisionsSizes(dList.length, gWidth, gHeight),
    shapeType = this.defSettings.gauge.type.toLowerCase(),
    shapeLen = this.defSettings.range.bands.length,
    radius,
    group,
    xIndex = this.xIndex,
    yIndex,
    hS,
    vlhos = 0,
    vlwos = 0,
    offset = 7.5;

  if (this.defSettings.valueLabel.show != "hide") {
    var appFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
      vlt = this.GetValueLabelMaxWord(this.dataSet),
      vlw = getOffsetWidth(vlt, appFont, this.chartId),
      vlh = getOffsetHeight(vlt, appFont, this.chartId);
    if (this.defSettings.valueLabel.position == "otop" || this.defSettings.valueLabel.position == "obottom")
      vlhos = vlh + offset;
    else
      vlwos = vlw + offset;
  }

  for (var i = 0; i < positions.length; i++) {
    positions[i].width = positions[i].width - vlwos;
    positions[i].height = positions[i].height - vlhos;
    if (this.defSettings.valueLabel.show != "hide") {
      if (this.defSettings.valueLabel.position == "otop")
        positions[i].y = positions[i].y + vlhos;
      else if (this.defSettings.valueLabel.position == "oleft")
        positions[i].x = positions[i].x + vlwos;
    }

    if (!this.isH)
      radius = positions[i].height / ((2 * shapeLen) + (shapeLen + 1) / 2);
    else
      radius = positions[i].width / ((2 * shapeLen) + (shapeLen + 1) / 2);

    yIndex = this.propertyName.indexOf(dList[i]);
    if (!this.isH)
      hS = (positions[i].height * 0.9) / 10;
    else
      hS = (positions[i].width * 0.9) / 10;

    group = container.append("g")
      .attr("id", id + "shapesGroup_" + i)
      .attr("transform", "translate(" + [positions[i].x, positions[i].y] + ")")

    group.selectAll(".bar")
      .data(data)
      .enter()
      .append("rect")
      .attr("class", function (d) {
        _this.items.push({
          itm: this,
          series: _this.seriesList[i],
          valueField: dList[i],
          keyField: !Empty(_this.objConfig.keyField) ? d[xIndex] : "",
          category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : d[xIndex],
          value: d[yIndex],
          itemType: "bar",
          categoryCode: d[_this.categoryCodeIndex],
          coordinates: positions[i],
          r: radius,
          groupID: id + "shapesGroup_" + i
        });
        return "bar bar_" + i + "_" + dataIndex + " TRANSP";
      })
      .attr("height", function () {
        if (!_this.isH)
          return positions[i].height * 0.9;
        return 3 * radius;
      })
      .attr("width", function () {
        if (!_this.isH)
          return 3 * radius;
        return positions[i].width * 0.9;
      })
      .attr("x", function () {
        if (!_this.isH)
          return positions[i].width / 2 - 1.5 * radius;
        return positions[i].width * 0.05;
      })
      .attr("y", function () {
        if (!_this.isH)
          return positions[i].height * 0.05;
        return positions[i].height / 2 - 1.5 * radius;
      })
      .attr("rx", function () {
        if (shapeType == "square")
          return hS;
        return 2 * hS;
      })
      .attr("ry", function () {
        if (shapeType == "square")
          return hS;
        if (_this.isH)
          return 4 * hS;
        else
          return 2 * hS;
      });

    var blur_itm = null;
    for (var j = 0; j < shapeLen; j++) {
      if (this.defSettings.chartStyle.indexOf("flat") >= 0) {
        blur_itm = group.append("circle")
          .attr("r", radius)
          .attr("cx", function () {
            if (!_this.isH)
              return positions[i].width / 2;
            return positions[i].width * 0.05 + radius / 3 + radius + (j * (2 * radius + (radius / 4)));
          })
          .attr("cy", function () {
            if (!_this.isH)
              return positions[i].height * 0.05 + radius / 3 + radius + (j * (2 * radius + (radius / 4)));
            return positions[i].height / 2;
          })
          .attr("filter", "url(#" + this.chartId + "blur)");
      }
      group.append("circle")
        .attr("class", function () {
          _this.lights.push({
            itm: this,
            itemType: "light",
            series: _this.seriesList[i],
            valueField: dList[i],
            keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
            category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
            value: data[0][yIndex],
            band: j,
            itemIndex: (dataIndex * dList.length) + i,
            idx: i,
            r: _this.defSettings.chartStyle.indexOf("flat") >= 0 ? radius - 3 : radius,
            coordinates: {
              x: (!_this.isH ? positions[i].width / 2 : positions[i].width * 0.05 + radius / 3 + radius + (j * (2 * radius + (radius / 4)))),
              y: (!_this.isH ? positions[i].height * 0.05 + radius / 3 + radius + (j * (2 * radius + (radius / 4))) : positions[i].height / 2)
            }
          });
          if (!Empty(blur_itm)) {
            _this.lights[_this.lights.length - 1].blur_itm = blur_itm.node();
          }
          return "";
        })
        .attr("r", this.defSettings.chartStyle.indexOf("flat") >= 0 ? radius - 3 : radius)
        .attr("cx", function () {
          if (!_this.isH)
            return positions[i].width / 2;
          return positions[i].width * 0.05 + radius / 3 + radius + (j * (2 * radius + (radius / 4)));
        })
        .attr("cy", function () {
          if (!_this.isH)
            return positions[i].height * 0.05 + radius / 3 + radius + (j * (2 * radius + (radius / 4)));
          return positions[i].height / 2;
        })

      blur_itm = null;
    }
  }
}
StdChart.prototype.DrawDisplay = function (container, data, dataIndex, id, gWidth, gHeight) {
  if (this.type == "PADDLE") {
    this.DrawPaddle(container, data, dataIndex, id, gWidth, gHeight);
    return;
  }

  var _this = this,
    dList = this._GetDrawingList(),
    positions = this.GetRendererSubdivisionsSizes(dList.length, gWidth, gHeight),
    group,
    xIndex = this.xIndex,
    yIndex,
    vlhos = 0,
    vlwos = 0,
    offset = 7.5;

  if (this.defSettings.valueLabel.show != "hide") {
    var appFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
      vlt = this.GetValueLabelMaxWord(this.dataSet),
      vlw = getOffsetWidth(vlt, appFont, this.chartId),
      vlh = getOffsetHeight(vlt, appFont, this.chartId);
    if (this.defSettings.valueLabel.position == "otop" || this.defSettings.valueLabel.position == "obottom")
      vlhos = vlh + offset;
    else
      vlwos = vlw + offset;
  }

  for (var i = 0; i < positions.length; i++) {
    positions[i].width = positions[i].width - vlwos;
    positions[i].height = positions[i].height - vlhos;
    if (this.defSettings.valueLabel.show != "hide") {
      if (this.defSettings.valueLabel.position == "otop")
        positions[i].y = positions[i].y + vlhos;
      else if (this.defSettings.valueLabel.position == "oleft")
        positions[i].x = positions[i].x + vlwos;
    }

    yIndex = this.propertyName.indexOf(dList[i]);
    group = container.append("g")
      .attr("id", id + "counterGroup_" + i)
      .attr("transform", "translate(" + [positions[i].x, positions[i].y] + ")");

    group.append("rect")
      .attr("class", function () {
        _this.items.push({
          itm: this,
          series: _this.seriesList[i],
          valueField: dList[i],
          keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
          category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
          value: data[0][yIndex],
          itemType: "counter",
          categoryCode: data[0][_this.categoryCodeIndex],
          coordinates: positions[i]
        });
        return "bar bar_" + i + "_" + dataIndex + " TRANSP";
      })
      .attr("height", positions[i].height * 0.96)
      .attr("width", positions[i].width * 0.96)
      .attr("x", positions[i].width * 0.02)
      .attr("y", positions[i].height * 0.02);

    var mtext = this._GetDisplayText(data[0][yIndex]);
    mtext = mtext + "";
    var dgts = howManyDigits(mtext),
      dcount = Math.max(dgts, this.defSettings.gauge.digits),
      diff = (dgts < this.defSettings.gauge.digits) ? (this.defSettings.gauge.digits - dgts) : 0,
      progrX = positions[i].width * 0.02,
      wDiff = (positions[i].width * 0.96) / dcount;

    var j;
    if (this.defSettings.chartStyle == "minimal") {
      var tot_w = positions[i].width * 0.96,
        tot_h = positions[i].height * 0.96;
      group.append("rect")
        .attr("x", (tot_w * 0.1) + progrX)
        .attr("y", (tot_h * 0.2) + (positions[i].height * 0.02))
        .attr("height", tot_h * 0.6)
        .attr("width", tot_w * 0.8)
        .style("fill", "#FAFAFA")
        .attr("rx", "8px")
        .attr("ry", "8px");

      var letter_w = (tot_w * 0.8) / dcount,
        letter_h = tot_h * 0.6,
        letter_x = (tot_w * 0.1) + progrX,
        letter_y = (tot_h * 0.2) + (positions[i].height * 0.02),
        f_size = 0,
        offset_w = 0,
        from_h = false;

      if (letter_w <= (letter_h / 2))
        f_size = 2 * letter_w;
      else {
        f_size = letter_h;
        from_h = true;
      }

      var t_group = group.append("g").attr("id", this.chartId + "textGroup");
      for (j = 0; j < dcount; j++) {
        var zitm = t_group.append("text")
          .attr("x", letter_x)
          .attr("y", letter_y + (from_h ? f_size * 0.75 : f_size))
          .text(8)
          .style("font-family", this._GetDisplayTextFont())
          .style("font-size", f_size * 0.75)
          .style("fill", "#000000")
          .style("fill-opacity", 0.1)

        if (offset_w == 0) {
          offset_w = getDomNodeSizes(zitm.node()).width;
        }

        t_group.append("text")
          .attr("x", letter_x)
          .attr("y", letter_y + (from_h ? f_size * 0.75 : f_size))
          .text(function () {
            var tt;
            if (diff == 0)
              tt = mtext.charAt(j);
            else if (j < diff)
              tt = "";
            else
              tt = mtext.charAt(j - diff);

            if (!Empty(tt)) {
              _this.itemsText.push({
                text: mtext,
                digit: tt,
                itm: this,
                width: positions[i].width * 0.96,
                height: positions[i].height * 0.96,
                series: _this.seriesList[i],
                valueField: dList[i],
                keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
                category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
                value: data[0][yIndex],
                relatedItem: i
              })
            }
            // else
            // tt = 0;
            return tt;
          })
          .style("font-family", this._GetDisplayTextFont())
          .style("font-size", f_size * 0.75)
        //   .attr("text-org", tt)

        letter_x += offset_w;
      }
      var g_width = getDomNodeWidth(t_group.node());
      t_group.attr("transform", "translate(" + (((tot_w * 0.8) - g_width) / 2) + ",0)");
    }
    else {
      for (j = 0; j < dcount; j++) {
        group.append("text")
          .attr("x", progrX)
          .attr("y", positions[i].height * 0.96)
          .text(function () {
            var tt;
            if (diff == 0)
              tt = mtext.charAt(j);
            else if (j < diff)
              tt = "";
            else
              tt = mtext.charAt(j - diff);

            if (!Empty(tt)) {
              _this.itemsText.push({
                text: tt,
                itm: this,
                width: wDiff,
                height: positions[i].height * 0.96,
                series: _this.seriesList[i],
                valueField: dList[i],
                keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
                category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
                value: data[0][yIndex],
                relatedItem: i
              })
            }
            // else
            // tt = 0;
            return tt;
          })
          .style("font-family", this._GetDisplayTextFont())
          .style("font-size", this._GetFontSize(positions[i].height /*Math.min(wDiff, positions[i].height * 0.96)*/))
        //.style("fill-opacity", 0);

        this._DrawDisplayLines(group, j, dcount, progrX, wDiff, positions[i].height);

        progrX = progrX + wDiff;
      }
    }
  }
}
StdChart.prototype.DrawDisplayText = function (container, data, dataIndex, id, gWidth, gHeight) {
  var _this = this,
    dList = this._GetDrawingList(),
    positions = this.GetRendererSubdivisionsSizes(dList.length, gWidth, gHeight),
    group,
    xIndex = this.xIndex,
    yIndex,
    vlhos = 0,
    vlwos = 0,
    offset = 7.5;

  if (this.defSettings.valueLabel.show != "hide") {
    var appFont = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
      vlt = this.GetValueLabelMaxWord(this.dataSet),
      vlw = getOffsetWidth(vlt, appFont, this.chartId),
      vlh = getOffsetHeight(vlt, appFont, this.chartId);
    if (this.defSettings.valueLabel.position == "otop" || this.defSettings.valueLabel.position == "obottom")
      vlhos = vlh + offset;
    else
      vlwos = vlw + offset;
  }

  for (var i = 0; i < positions.length; i++) {
    positions[i].width = positions[i].width - vlwos;
    positions[i].height = positions[i].height - vlhos;
    if (this.defSettings.valueLabel.show != "hide") {
      if (this.defSettings.valueLabel.position == "otop")
        positions[i].y = positions[i].y + vlhos;
      else if (this.defSettings.valueLabel.position == "oleft")
        positions[i].x = positions[i].x + vlwos;
    }

    yIndex = this.propertyName.indexOf(dList[i]);
    group = container.append("g")
      .attr("id", id + "counterGroup_" + i)
      .attr("transform", "translate(" + [positions[i].x, positions[i].y] + ")");

    var tot_h = positions[i].height * 0.96,
      tot_w = positions[i].width * 0.96,
      tot_x = positions[i].width * 0.02,
      tot_y = positions[i].height * 0.02;

    group.append("rect")
      .attr("class", function () {
        _this.items.push({
          itm: this,
          series: _this.seriesList[i],
          valueField: dList[i],
          keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
          category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
          value: data[0][yIndex],
          itemType: "counter",
          categoryCode: data[0][_this.categoryCodeIndex],
          coordinates: positions[i]
        });
        return "bar bar_" + i + "_" + dataIndex + " TRANSP";
      })
      .attr("height", tot_h)
      .attr("width", tot_w)
      .attr("x", tot_x)
      .attr("y", tot_y)
      .style("fill-opacity", "0");

    var mtext = this._GetDisplayTextFromItem(this.items[this.items.length - 1]),
      f_size = Math.min(tot_h, tot_w);
    mtext = mtext + "";

    var text = group.append("text")
      .attr("x", (tot_x + tot_w) / 2)
      .attr("y", tot_y + tot_h)
      .text(function () {
        if (!Empty(mtext)) {
          _this.itemsText.push({
            text: mtext,
            digit: mtext,
            itm: this,
            width: tot_w,
            height: tot_h,
            series: _this.seriesList[i],
            valueField: dList[i],
            keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
            category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
            value: data[0][yIndex],
            relatedItem: i
          })
        }
        return mtext;
      })
      .style("font-family", this._GetDisplayTextFont())
      .style("font-size", f_size + "px")
      .style("font-weight", function () {
        if (_this.defSettings.displayFont.style == "B" || _this.defSettings.displayFont.style == "BI")
          return "bold";
        return "normal";
      })
      .style("font-style", function () {
        if (_this.defSettings.displayFont.style == "I" || _this.defSettings.displayFont.style == "BI")
          return "italic";
        return "normal";
      })
      .style("text-anchor", "middle");

    var bbox = getDomNodeSizes(text.node()),
      newf_size = 0;
    if (bbox.width > tot_w) {
      newf_size = (tot_w * f_size) / bbox.width;
      text.style("font-size", newf_size + "px");
      bbox = getDomNodeSizes(text.node());
      f_size = newf_size;
    }

    if (bbox.height > tot_h) {
      newf_size = (tot_h * f_size) / bbox.height;
      bbox = getDomNodeSizes(text.node());
    }

    text
      .attr("y", tot_x + (tot_h / 2) + (bbox.height / 4))
      .style("font-size", newf_size + "px")
      .style("font-family", "");
  }
}
StdChart.prototype.DrawPaddle = function (container, data, dataIndex, id, gWidth, gHeight) {
  var _this = this,
    dList = this._GetDrawingList(),
    positions = this.GetRendererSubdivisionsSizes(dList.length, gWidth, gHeight),
    group,
    xIndex = this.xIndex,
    yIndex,
    width,
    left,
    colD;

  for (var i = 0; i < positions.length; i++) {
    yIndex = this.propertyName.indexOf(dList[i]);
    group = container.append("g")
      .attr("id", id + "counterGroup_" + i)
      .attr("transform", "translate(" + [positions[i].x, positions[i].y] + ")");

    width = positions[i].width * 0.96;
    left = positions[i].width * 0.02;

    var dcount = Math.max(howManyDigits(data[0][yIndex]), this.defSettings.gauge.digits),
      diff = (howManyDigits(data[0][yIndex]) < this.defSettings.gauge.digits) ? (this.defSettings.gauge.digits - howManyDigits(data[0][yIndex])) : 0,
      mtext = (data[0][yIndex] + ""),
      progrX = left,
      wDiff = width / dcount;

    for (var j = 0; j < dcount; j++) {
      group.append("rect")
        .attr("class", function () {
          _this.items.push({
            itm: this,
            series: _this.seriesList[i],
            valueField: dList[i],
            keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
            category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
            value: data[0][yIndex],
            itemType: "counter",
            categoryCode: data[0][_this.categoryCodeIndex],
            relatedItem: i
          });
          return "bar bar_" + i + "_" + dataIndex + " TRANSP";
        })
        .attr("height", positions[i].height * 0.96)
        .attr("width", wDiff * 0.9)
        .attr("x", progrX + (wDiff * 0.05))
        .attr("y", positions[i].height * 0.02);

      group.append("text")
        .attr("x", progrX + (wDiff * 0.05))
        .attr("y", positions[i].height * 0.96)
        .text(function () {
          var tt;
          if (diff == 0)
            tt = mtext.charAt(j);
          else if (j < diff)
            tt = "";
          else
            tt = mtext.charAt(j - diff);

          if (!Empty(tt)) {
            _this.itemsText.push({
              text: tt,
              itm: this,
              width: wDiff * 0.9,
              height: positions[i].height * 0.96,
              series: _this.seriesList[i],
              valueField: dList[i],
              keyField: !Empty(_this.objConfig.keyField) ? data[0][xIndex] : "",
              category: !Empty(_this.objConfig.keyField) ? _this.categoryList[dataIndex] : data[0][xIndex],
              value: data[0][yIndex],
              relatedItem: i
            })
          }
          return tt;
        })
        .style("font-family", this._GetDisplayTextFont())
        .style("font-size", this._GetFontSize(Math.min(wDiff * 0.9, positions[i].height * 0.96)))
        .style("fill", Empty(this.defSettings.displayFont.name) ? "#000000" : this.defSettings.displayFont.name)

      colD = this._CreateDisplayGradient({ color: "#A8A8A8" }, 0, "COUNTER");
      this._DrawDisplayLines(group, j, dcount, progrX, wDiff, positions[i].height, colD);

      progrX = progrX + wDiff;
    }
  }
}
StdChart.prototype.DrawShapes = function (container, data, dataIndex, xIndex, yIndex, cobj) {
  var _this = this,
    fdata = data.filter(function (record) {
      return _this._IsNotExcludedDomainShapes(record[xIndex]);
    }
    );

  if ((!this.defSettings.shape || !this.defSettings.shape.draw) && !this.defSettings.shape.onlyHover)
    return;

  var shapeSize = this.GetShapesRadius();
  if (shapeSize == 0)
    return;

  container.selectAll(".shape_" + dataIndex)
    .data(fdata)
    .enter()
    .append("path")
    .attr("class", function (d, idx) {
      var hole = false;
      if (_this.domainIsTime && _this.defSettings.time.dataType != "default") {
        if (_this.holesIndexList[cobj.valueField])
          hole = _this.holesIndexList[cobj.valueField].indexOf(idx) >= 0;
      }
      if (!hole || (hole && _this.defSettings.time.missingData != "hide")) {
        var vf = cobj.valueField || _this.valueFields[idx];
        _this.shapes.push({
          itm: this,
          series: _this.seriesList[_this.valueFields.indexOf(vf)],
          valueField: vf,
          keyField: !Empty(_this.objConfig.keyField) ? d[xIndex] : "",
          category: !Empty(_this.objConfig.keyField) ? _this.categoryList[idx] : d[xIndex],
          value: d[yIndex],
          r: d[yIndex] == null ? 0 : shapeSize,
          coordinates: {
            x: _this._GetShapeCX(d, dataIndex, xIndex, yIndex, idx, cobj),
            y: _this._GetShapeCY(d, dataIndex, xIndex, yIndex, idx, cobj)
          },
          itemType: "shape",
          categoryCode: d[_this.categoryCodeIndex],
          shapeType: _this.defSettings.shape.differSeries ? _this.defSettings.shape.figureTypes[_this.valueFields.indexOf(cobj.valueField)] : _this.defSettings.shape.figure,
          isHole: hole
        });
      }
      return "shape shape_" + idx + "_" + dataIndex + " TRANSP";
    })
    .attr("transform", function (d, idx) {
      var cx = _this._GetShapeCX(d, dataIndex, xIndex, yIndex, idx, cobj),
        cy = _this._GetShapeCY(d, dataIndex, xIndex, yIndex, idx, cobj);
      return "translate(" + [cx, cy] + ")";
    })
    .attr("d", d3.symbol()
      .size(function () { return 2 * Math.pow(shapeSize, 2); })
      .type(function () {
        if (_this.defSettings.shape.differSeries) {
          var index = _this.valueFields.indexOf(cobj.valueField),
            fig = _this.defSettings.shape.figureTypes[index];
          if (Empty(fig) || index > _this.defSettings.shape.figureTypes.length)
            fig = _this.defSettings.shape.figureTypes[index % _this.defSettings.shape.figureTypes.length];
          return d3["symbol" + fig.charAt(0).toUpperCase() + fig.slice(1)];
        }
        return d3["symbol" + _this.defSettings.shape.figure.charAt(0).toUpperCase() + _this.defSettings.shape.figure.slice(1)];
      })
    );
}
StdChart.prototype.DrawMap = function (container) {
  var _this = this;
  // zoom
  if (this.objConfig.zooming && this.objConfig.zooming.enabled) {
    this.__zoom = d3.zoom().scaleExtent([1, 10]).on("zoom", zoomed);
    this.svg.call(this.__zoom);

    function zoomed() {
      var event = d3.event.transform;
      container.attr("transform", event);
      _this.svg.selectAll(".geopath").style("stroke-width", (1 / event.k) + "px");
      //console.log((12 / event.k) + "px")
      //  _this.svg.selectAll(".geomarker").style("font-size", (12 / event.k) + "px");
      // d3.selectAll("circle").attr("r", 5 / event.k)
      //console.log(event.k)
    }
  }

  var newJSON, newTOPOJ;
  // ragionamento geoview es. IT,25
  if (!this.objConfig.geoOpts.onlyData && !Empty(this._geoFocus)) {
    var indexRef = this._geoFocus.length - 1,
      fieldRef;
    if (this._geoFocus.length > 1) {
      fieldRef = this.mapDefinition.mapDef.mapLevels["_" + this.geoSubLevel];
    }
    else {
      if (this.objConfig.geoOpts.typeView <= 2)
        fieldRef = this.mapDefinition.mapDef.mapLevels._con;
      else
        fieldRef = this.mapDefinition.mapDef.mapLevels._0;
    }
    //   console.log("fieldRef", fieldRef)
    if (this.mapDefinition.mapDef) {
      if (!Empty(fieldRef)) {
        // filtro il geojson
        var tmp = JSON.stringify(this.mapDefinition.geojson);
        newJSON = JSON.parse(tmp);
        var newFeatures = newJSON.features.filter(function (obj) {
          if (obj.properties) {
            if (obj.properties[fieldRef] == _this._geoFocus[indexRef]) {
              return true;
            }
          }
          return false;
        });
        if (newFeatures.length > 0) {
          newJSON.features = newFeatures.slice();
          var geo2topo = { tmp: JSON.stringify(newJSON) };
          geo2topo[this.mapDefinition.mapCode] = JSON.parse(geo2topo.tmp);
          delete geo2topo.tmp;
          newTOPOJ = topojson.topology(geo2topo);
        }
      }
    }
  }

  this.mapDefinition.proj = d3.geoEquirectangular()
    .fitSize([this.chartWidth - 2, this.chartHeight - 2], !Empty(newJSON) ? newJSON : this.mapDefinition.geojson)
  //console.log("center",  this.mapDefinition.proj.center(), this.objConfig.zooming.center)
  if (!Empty(this.objConfig.zooming.center))
    this.mapDefinition.proj.center(this.objConfig.zooming.center.slice().reverse()).translate([this.chartWidth / 2, this.chartHeight / 2]);
  //console.log("2center",  this.mapDefinition.proj.center(), this.objConfig.zooming.center)
  var path = d3.geoPath().projection(this.mapDefinition.proj);
  this.__path = path;

  var topomap = !Empty(newTOPOJ) ? newTOPOJ : this.mapDefinition.topojson,
    levels = Object.keys(this.mapDefinition.mapDef.mapLevels);
  //  console.log("mapLevels", levels)
  //  console.log("geoSubLevel", this.geoSubLevel)
  if (!Empty(this._toDraw)) {
    var subIndex = levels.indexOf("_" + this.geoSubLevel);
    for (var kk = 0; kk < this._toDraw.length; kk++) {
      var cnames = "",
        it_idx = -1;
      container.append("path")
        .datum(
          topojson.merge(topomap, topomap.objects[this.mapDefinition.mapCode].geometries.filter(function (d) {
            var cValid = (_this._toDraw.indexOf(d.properties[_this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel]]) >= 0
              &&
              d.properties[_this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel]] == _this._toDraw[kk]
            )

            if (cValid) {
              var item = {
                color: { color: _this.defSettings.map.undefined.color, gradient: "" },
                colorApplied: _this.defSettings.map.undefined.color,
                isNull: true,
                _0: _this.geo0Level,
                _0desc: _this.geo0Level
              }
              cnames = "";
              for (var i = 0; i < levels.length; i++) {
                var level = levels[i],
                  levelField = _this.mapDefinition.mapDef.mapLevels[level],
                  levelDescField = _this.mapDefinition.mapDef.descs[_this.mapDefinition.mapDef.codes.indexOf(levelField)];
                if (i <= subIndex) {
                  item[level] = d.properties[levelField];
                  item[level + "desc"] = d.properties[levelDescField];
                }
              }
              cnames = Empty(_this.geoSubField) ? _this._toDraw[kk] : (item._0 + "-" + _this._toDraw[kk]);
              if (_this.items.hasObject(item) < 0) {
                _this.items.push(item);
                it_idx = _this.items.length - 1;
              }
            }
            return cValid;
          }))
        )
        .attr("class", function () {
          if (it_idx >= 0) {
            _this.items[it_idx].itm = this;
            _this.items[it_idx].idx = it_idx;
          }
          return "geopath " + cnames + " TRANSP";
        })
        .attr("d", path)
        .attr("item-index", it_idx)
        .style("fill", _this.defSettings.map.undefined.color)
        .style("stroke", _this.defSettings.map.undefined.stroke)
        .style("stroke-width", "1px")
        .on("mouseover", applyMouseOver)
    }

    if (this.objConfig.geoOpts.onlyData) {
      container
        .datum(
          topojson.merge(topomap, topomap.objects[this.mapDefinition.mapCode].geometries.filter(function (d) {
            var cValid = (_this._toDraw.indexOf(d.properties[_this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel]]) < 0);
            return cValid;
          })))
        .append("path")
        .attr("class", "merged TRANSP")
        .attr("d", path)
        .style("fill", _this.defSettings.map.undefined.color)
        .style("stroke", _this.defSettings.map.undefined.stroke)
        .style("stroke-width", 1);

      var borderObj = {
        geometries: [],
        type: topomap.objects[this.mapDefinition.mapCode].type
      };
      borderObj.geometries = topomap.objects[this.mapDefinition.mapCode].geometries.filter(function (d) {
        var cValid = (_this._toDraw.indexOf(d.properties[_this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel]]) < 0);
        return cValid;
      });

      container
        .datum(topojson.mesh(topomap, borderObj, function (tf, tf2) {
          var v1 = tf.properties[_this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel]],
            v2 = tf2.properties[_this.mapDefinition.mapDef.mapLevels["_" + _this.geoSubLevel]];
          return v1 != v2;
        }))
        .append("path")
        .attr("class", "merged_border TRANSP")
        .attr("d", path)
        .style("stroke", _this.defSettings.map.undefined.stroke)
        .style("stroke-width", 1)
        .style("fill-opacity", 0);
    }
  }
  else {
    // ho selezionato un livello che non e' presente in mappa - disegno la mappa come da file
    container.append("g")
      .selectAll("path")
      .data(topojson.feature(topomap, topomap.objects[this.mapDefinition.mapCode]).features)
      .enter()
      .append("path")
      .attr("class", function (d) {
        var item = {
          color: { color: _this.defSettings.map.undefined.color, gradient: "" },
          colorApplied: _this.defSettings.map.undefined.color,
          isNull: true,
          itm: this
        }
        for (var i = 0; i < levels.length; i++) {
          var level = levels[i],
            levelField = _this.mapDefinition.mapDef.mapLevels[level],
            levelDescField = _this.mapDefinition.mapDef.descs[_this.mapDefinition.mapDef.codes.indexOf(levelField)];
          item[level] = d.properties[levelField];
          item[level + "desc"] = d.properties[levelDescField];
        }
        _this.items.push(item);
        return "geopath " + item[level] + " TRANSP";
      })
      .attr("d", path)
      .style("fill", _this.defSettings.map.undefined.color)
      .style("stroke", _this.defSettings.map.undefined.stroke)
      .style("stroke-width", "1px")
      .on("mouseover", applyMouseOver)
  }
  /* -wip
    if (!Empty(this.mapDefinition.mapLayers)) {
      for (var i = 0; i < this.mapDefinition.mapLayers.length; i++) {
        this._AddMapLayers(this.mapDefinition.mapLayers[i], parentGroup, path);
      }
    }
  */
  function applyMouseOver() {
    _this._ApplyMouseOver(this);
  }
}
StdChart.prototype.DrawAsterPie = function (container, data, dataIndex, xIndex, yIndex, id, arc) {
  var _this = this,
    pie,
    pieData,
    stAngle,
    angleCos,
    dList = this._GetAxisDrawingList(),
    fdata = data.filter(function (record) {
      return dList.indexOf(record[_this.seriesIndex]) >= 0;
    });

  pie = d3.pie()
    .value(function (d) {
      return Math.abs(d[yIndex]);
    })
    .sort(null);  // aggiunto altrimenti disegna le fette in ordine decrescente di valore nella torta

  if (isNaN(this.defSettings.orientation.startAngle))
    stAngle = 0;
  else
    stAngle = this.defSettings.orientation.startAngle - 90;
  angleCos = stAngle * (Math.PI / 180);
  pie.startAngle(angleCos).endAngle((2 * Math.PI) + angleCos);

  pieData = pie(fdata);
  this.pieData[dataIndex] = pieData;

  container.selectAll(".pie_")
    .data(pieData)
    .enter()
    .append("path")
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        series: !Empty(_this.objConfig.keyField) ? d.data[_this.seriesLabelIndex] : d.data[_this.seriesIndex],
        valueField: _this.valueFields[dataIndex],
        keyField: !Empty(_this.objConfig.keyField) ? d.data[_this.seriesIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[idx] : d.data[xIndex],
        value: d.data[yIndex],
        dataIndex: dataIndex,
        startAngle: d.startAngle,
        endAngle: d.endAngle,
        itemType: "pie",
        categoryCode: d.data[_this.categoryCodeIndex],
        radius: _this.scaleX(d.data[_this.xIndex])/*_this._GetRadius()*/,
        _3dFactor: 1,
        centroid: arc.centroid(d)
      });
      return "pie pie_" + idx + "_" + dataIndex + " TRANSP";
    })
    .attr("d", function (d) {
      return arc(d);
    })
    .each(function (/*d*/) { this._arc = arc; });
}
StdChart.prototype.DrawAreaBar = function (container, data, cdata, xIndex, yIndex, cobj) {
  var _this = this,
    index,
    dataIndex = 0,
    dList = this._GetAxisDrawingList(),
    fdata = data.filter(function (record) {
      return dList.indexOf(record[_this.seriesIndex]) >= 0;
    });

  container.selectAll(".bar_" + dataIndex)
    .data(fdata)
    .enter()
    .append("rect")
    .attr("class", function (d) {
      index = _this.orgCategoryList.indexOf(d[xIndex]/* + ""*/);
      //index = _this.matchList.indexOf(d[_this.seriesIndex] + "_" + d[xIndex]);
      _this.items.push({
        itm: this,
        series: !Empty(_this.objConfig.keyField) ? d[_this.seriesLabelIndex] : d[_this.seriesIndex],
        valueField: _this._GetDrawingList()[dataIndex],
        keyField: !Empty(_this.objConfig.keyField) ? d[_this.seriesIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[index] : d[xIndex],
        value: d[yIndex],
        realValue: !_this.defSettings.normalizeValues ? d[yIndex] : _this._ZtChart.orgData[index][yIndex],
        progrValue: cdata[index][yIndex],
        itemType: "bar",
        categoryCode: d[_this.categoryCodeIndex]
      });
      return "bar bar_" + dataIndex + "_" + index + " TRANSP";
    })
    .attr("x", function (d) {
      index = _this.orgSeriesList.indexOf(d[_this.seriesIndex]);
      return _this._GetVBarX(d, cdata[index], xIndex, yIndex, cobj);
    })
    .attr("y", function (d) {
      cobj.scaleY = _this.scaleY[replaceSpecialCharsForID(d[_this.seriesIndex])];
      return _this._GetVBarY(d, -1, xIndex, yIndex, cobj);
    })
    .attr("width", function (d) {
      return _this._GetVBarWidth(d, xIndex, cobj);
    })
    .attr("height", function (d) {
      cobj.scaleY = _this.scaleY[replaceSpecialCharsForID(d[_this.seriesIndex])];
      return _this._GetVBarHeight(d, yIndex, cobj);
    });
}
StdChart.prototype.DrawSunburst = function (container, data, dataIndex/*, id*/) {
  var _this = this,
    partition = d3.partition()
      .size([2 * Math.PI, this.radius]),
    root = d3.hierarchy(data),
    root_size = d3.hierarchy(data)
      .sum(function (d) { return d.size; }),
    arc = d3.arc()
      .startAngle(function (d) { return d.x0; })
      .endAngle(function (d) { return d.x1; })
      .innerRadius(function (d) { return d.y0; })
      .outerRadius(function (d) { return d.y1; });

  partition(root);
  partition(root_size);
  var fdata = root.descendants(),
    sdata = root_size.descendants();

  var data_alt = sdata;
  if (this.byCount)
    data_alt = fdata;

  container.selectAll('path')
    .data(data_alt)
    .enter()
    .append("path")
    .attr("class", function (d, idx) {
      d.index = idx;
      _this.items.push({
        itm: this,
        valueField: _this.valueFields[dataIndex],
        category: d.data.name,
        value: _this.byCount ? sdata[idx].value : d.value,
        index: idx,
        itemType: "sunburst",
        parent: d.parent,
        depth: d.depth,
        coords: { startAngle: d.x0, endAngle: d.x1, innerRadius: d.y0, outerRadius: d.y1 },
        categoryCode: d.data.categoryCode,
        hasChild: d.children ? d.children.length > 0 : false
      });
      return "pie pie_" + idx + "_" + dataIndex + " TRANSP";
    })
    .attr("id", function (d, idx) {
      return _this.chartId + "pie_" + idx + "_" + dataIndex + "_" + d.depth;
    })
    .attr("d", arc)
  //.each(function(/*d*/) { this._arc = arcToDraw; });
}
StdChart.prototype.DrawTree = function (container, data, id, width, height) {
  var _this = this,
    offset = 5,
    ow = getOffsetWidth(this.maxWord, this.defSettings.globalFont, this.chartId),
    oh = getOffsetHeight(this.maxWord, this.defSettings.globalFont, this.chartId),
    sizeLinear = [height - 2 * oh - offset, width - 2 * ow - offset],
    sizeRadial = [2 * Math.PI, Math.min(height, width) / 2 - 2 * oh],
    tree = d3.tree()
      .size(this.defSettings.layout == "radial" ? sizeRadial : (this.defSettings.layout == "horizontal" ? sizeLinear : sizeLinear.reverse())),
    root = d3.hierarchy(data),
    root_size = d3.hierarchy(data)
      .sum(function (d) { return d.size; });

  if (!this.byCount) {
    var rscale = d3.scaleLinear().domain([0, 1]).range([1, d3.max(this.scaleZ.range()) / 2]);
    tree.separation(function (a, b) { return rscale(Math.max(a.data.value, b.data.value)); });
  }

  var treeData = tree(root),
    treeData_size = tree(root_size);
  var fdata = treeData.descendants(),
    sdata = treeData_size.descendants();

  var data_alt = sdata;
  if (this.byCount)
    data_alt = fdata;

  var linkConnection;
  switch (this.defSettings.layout) {
    case "horizontal":
      linkConnection = d3.linkHorizontal()
        .x(function (d) { return d.y; })
        .y(function (d) { return d.x; })
      break;
    case "vertical":
      linkConnection = d3.linkVertical()
        .x(function (d) { return d.x; })
        .y(function (d) { return d.y; })
      break;
    case "radial":
      linkConnection = d3.linkRadial()
        .angle(function (d) { return d.x; })
        .radius(function (d) { return d.y; })
      break;
  }

  var lcont = container.append("g").attr("id", this.chartId + "linkContainer"),
    ncont = container.append("g").attr("id", this.chartId + "nodesContainer");

  var node = ncont.selectAll(".node")
    .data(data_alt)
    .enter()
    .append("g")
    .attr("class", function (d, idx) {
      d.index = idx;
      _this.items.push({
        itm: this,
        category: d.data.name,
        value: d.value,
        index: idx,
        parent: d.parent,
        depth: d.depth,
        parentName: d.data.parentName,
        hasChild: d.children ? d.children.length > 0 : false,
        collapsed: _this.closedItems.indexOf(d.data.name) >= 0,
        categoryCode: d.data.categoryCode,
        valueField: _this.levelsFields[d.depth]
      });
      return "node TRANSP";
    })
    .attr("transform", function (d, idx) {
      var translate;
      if (_this.defSettings.layout == "radial")
        translate = [(d.y = +d.y) * Math.cos(d.x -= Math.PI / 2), d.y * Math.sin(d.x)];
      else if (_this.defSettings.layout == "horizontal")
        translate = [d.y + "," + d.x];
      else
        translate = [d.x + "," + d.y];
      _this.items[idx].translate = translate.toString();
      return "translate(" + translate + ")";
    })

  lcont.selectAll(".link")
    .data(treeData.links())
    .enter()
    .append("path")
    .attr("class", function (d) { return "link _" + d.source.index + "_" + d.target.index; })
    .attr("d", linkConnection)
    .style("fill", "none")
    .style("stroke", "#D0D0D0")

  node.append("circle").attr("r", function (d) {
    if (_this.scaleZ && d.depth != 0)
      return _this.scaleZ(d.value);
    return offset;
  });

  node.append("text")
    .attr("x", function (d) {
      var rsize = offset,
        value;
      if (_this.scaleZ && d.depth != 0)
        rsize = _this.scaleZ(d.value);
      value = rsize + offset / 2;
      if (_this.defSettings.layout == "horizontal")
        return d.children ? - value : value;
      if (_this.defSettings.layout == "radial")
        return d.x < Math.PI === !d.children ? offset : - offset;
      return 0;
    })
    .attr("y", function (d) {
      var rsize = offset;
      if (_this.scaleZ && d.depth != 0)
        rsize = _this.scaleZ(d.value);
      if (_this.defSettings.layout == "vertical")
        return d.children ? - (rsize + offset / 2) : (offset / 2 + oh);
      if (_this.defSettings.layout == "horizontal")
        return 2.5;
      return 0;
    })
    .style("text-anchor", function (d) {
      if (_this.defSettings.layout == "horizontal")
        return d.children ? "end" : "start";
      if (_this.defSettings.layout == "radial")
        return d.x < Math.PI === !d.children ? "start" : "end";
      return "middle";
    })
    .text(function (d) { return d.data.name; });
}
StdChart.prototype.DrawCirclePack = function (container, data, dataIndex, width, height) {
  var _this = this,
    pack = d3.pack()
      .size([width, height]),
    root = d3.hierarchy(data)
      .sum(function (d) { return d.size; });

  var data_alt = this.isPack ? pack(root).descendants() : pack(root).leaves();
  container.selectAll(".node")
    .data(data_alt)
    .enter()
    .append("g")
    .attr("class", "node TRANSP")
    .attr("transform", function (d) { return "translate(" + d.x + "," + d.y + ")"; })
    .append("circle")
    .attr("class", function (d, idx) {
      d.index = idx;
      _this.items.push({
        itm: this,
        category: d.data.name,
        value: d.value,
        index: idx,
        valueField: _this.valueFields[dataIndex],
        parent: d.parent,
        depth: d.depth,
        parentName: d.data.parentName,
        categoryCode: d.data.categoryCode,
        data_idx: d.data.data_idx
      });
      return "";
    })
    .attr("r", function (d) { return d.r; });
}
StdChart.prototype.DrawForceLayout = function (container, data) {
  var i = 0,
    _this = this,
    radius,
    nodes = this.byCount ? data : flatten(data).sort(function (a, b) { return a.depth - b.depth; }),
    links = this.byCount ? this.calcLinks : data.links(),
    linkSvg = container.selectAll(".link")
      .data(links, function (d) { return d.target.id; })

  linkSvg.exit().remove();

  var linkEnter = linkSvg.enter()
    .append("line")
    .attr("class", "link");

  linkSvg = linkEnter.merge(linkSvg);

  var nodeSvg = container.selectAll(".node")
    .data(nodes, function (d) { return d.id; })

  nodeSvg.exit().remove();

  var nodeEnter = nodeSvg.enter()
    .append("g")
    .attr("class", "node TRANSP")
    .call(d3.drag()
      .on("start", dragstarted)
      .on("drag", dragged)
      .on("end", dragended)
    );

  nodeEnter
  /*.append("circle")
    .attr("class", function (d, idx) {
      d.index = idx;
      _this.items.push({
        itm: this,
        category: (d.name || d.data.name),
        value: d.value,
        index: idx,
        parent: d.parent,
        depth: d.depth,
        parentName: _this.byCount ? "" : d.data.parentName,
        hasChild: _this.byCount ? false : (d.data.children ? d.data.children.length > 0 : false)
      });
      return "node_" + idx;
    })
    .attr("r", function (d) {
      if (_this.scaleZ && d.data.size)
        return _this.scaleZ(d.data.size);
      return radius;
    })*/

  if (this.byCount) {
    nodeEnter.append("path")
      .attr("class", function (d, idx) {
        d.index = idx;
        _this.items.push({
          itm: this,
          key: (d.name || d.data.name),
          class: d.class,
          desc: d.desc || (d.name || d.data.name),
          value: d.value,
          index: idx,
          parent: d.parent,
          depth: d.depth,
          parentName: _this.byCount ? "" : d.data.parentName,
          hasChild: _this.byCount ? false : (d.data.children ? d.data.children.length > 0 : false),
          categoryCode: d.categoryCode
        });
        return "node_" + idx;
      })
      .attr("d", d3.symbol()
        .size(function () { return 2 * Math.pow(7, 2); })
        .type(function (d) {
          var symbol = "Circle";
          if (_this.objConfig.mapSeries) {
            if (!Empty(d.class) && (d.class in _this.objConfig.mapSeries)) {
              var type = _this.objConfig.mapSeries[d.class].type;
              if (type != "default")
                symbol = type.charAt(0).toUpperCase() + type.slice(1);
            }
          }
          return d3["symbol" + symbol];
        })
      )
  }
  else {
    radius = 7;
    nodeEnter.append("circle")
      .attr("class", function (d, idx) {
        d.index = idx;
        _this.items.push({
          itm: this,
          category: (d.name || d.data.name),
          value: d.data.size,
          index: idx,
          parent: d.parent,
          depth: d.depth,
          parentName: d.parent ? d.parent.data.name : "",
          hasChild: d.data.children ? d.data.children.length > 0 : false,
          categoryCode: d.data.categoryCode
        });
        return "node_" + idx;
      })
      .attr("r", function (d) {
        if (_this.scaleZ && d.data.size)
          return _this.scaleZ(d.data.size);
        return radius;
      })
  }

  nodeEnter.style("stroke", "#C0C0C0")
    .style("fill", "transparent");

  nodeSvg = nodeEnter.merge(nodeSvg);

  this.svgDraw = {};
  this.svgDraw.link = linkSvg;
  this.svgDraw.node = nodeSvg;

  this.forceSimulation.nodes(nodes);
  this.forceSimulation.force("link").links(links);

  function flatten(root) {
    // hierarchical data to flat data for force layout
    var nodes = [];
    function recurse(node) {
      if (node.children) node.children.forEach(recurse);
      if (!node.id) node.id = ++i;
      else ++i;
      nodes.push(node);
    }
    recurse(root);
    return nodes;
  }

  function dragstarted(/*d*/) {
    if (!d3.event.active)
      _this.forceSimulation.alphaTarget(0.3).restart()
  }

  function dragged(d) {
    d.fx = d3.event.x;
    d.fy = d3.event.y;
  }

  function dragended(d) {
    if (!d3.event.active) _this.forceSimulation.alphaTarget(0);
    d.fx = null;
    d.fy = null;
  }
}
StdChart.prototype.DrawMatrix = function (container, data) {
  var _this = this,
    rectSize = {};

  rectSize.width = this.scaleX2.bandwidth();
  rectSize.height = this.scaleX.bandwidth();

  container.selectAll(".cell")
    .data(data)
    .enter()
    .append("rect")
    .attr("class", function (d, index) {
      _this.items.push({
        itm: this,
        source: d.source,
        sourceDesc: _this.categoryList[d.source],
        value: d.value,
        target: d.target,
        targetDesc: _this.categoryList_2[d.target],
        itemType: "cellbar",
        categoryCode: d.categoryCode,
        data_index: d.data_index
      });
      return "cell cell_" + index + " TRANSP";
    })
    .attr("x", function (d) {
      return _this.scaleX2(_this.categoryList_2[d.target]);
    })
    .attr("y", function (d) {
      return _this.scaleX(_this.categoryList[d.source]);
    })
    .attr("width", rectSize.width)
    .attr("height", rectSize.height);
}
StdChart.prototype.DrawChord = function (container, data, radius, innerRadius) {
  var arc = d3.arc()
    .innerRadius(innerRadius)
    .outerRadius(radius),
    ribbon = d3.ribbon().radius(innerRadius),
    chord = d3.chord().padAngle(0.05),
    _this = this;

  container.datum(chord(data));
  container.append("g")
    .attr("class", "groups")
    .selectAll("g")
    .data(function (chords) { return chords.groups; })
    .enter()
    .append("path")
    .attr("class", function (d) {
      _this.arcs.push(this);
      return "arc arc_" + d.index + " TRANSP";
    })
    .attr("d", arc);

  container.append("g")
    .attr("class", "ribbons")
    .selectAll("path")
    .data(function (chords) { return chords; })
    .enter()
    .append("path")
    .each(function (d, index) {
      var record = _this.dataSet.filter(function (rec) {
        var s = _this.propertyName.indexOf(_this.levelsFields[0]),
          t = _this.propertyName.indexOf(_this.levelsFields[1]);
        if (rec[s] == _this.categoryList[d.source.index] && rec[t] == _this.categoryList[d.target.index])
          return true;
        if (rec[t] == _this.categoryList[d.source.index] && rec[s] == _this.categoryList[d.target.index])
          return true;
        return false;
      })
      _this.items.push({
        itm: this,
        source: d.source.index,
        value: d.source.value,
        target: d.target.index,
        category: _this.categoryList[d.source.index],
        series: _this.categoryList[d.target.index],
        itemType: "cellbar",
        categoryCode: record[0][_this.categoryCodeIndex]
      });
      return "ribbon ribbon_" + index + " TRANSP";
    })
    .attr("d", ribbon);
}
StdChart.prototype.DrawCalendar = function (container, start, end, width, height, cellSize) {
  var _this = this;
  container.selectAll(".cellborder")
    .data(d3.timeDays(start, end))
    .enter()
    .append("rect")
    .attr("class", function (d, index) {
      return "cellborder cell_" + index + " TRANSP";
    })
    .attr("x", function (d, index) {
      switch (_this.defSettings.time.dataView) {
        case "year":
          return d3.timeWeek.count(d3.timeYear(d), d) * cellSize;
          break;
        case "month":
          return index * cellSize;
          break;
      }
    })
    .attr("y", function (d) {
      switch (_this.defSettings.time.dataView) {
        case "year":
          return d.getDay() * cellSize;
          break;
        case "month":
          return 0;
          break;
      }
    })
    .attr("width", cellSize)
    .attr("height", cellSize);

  if (this.defSettings.time.dataView == "year") {
    container.selectAll(".cellcont")
      .data(d3.timeMonths(start, end))
      .enter()
      .append("path")
      .attr("class", function () {
        _this.shapes.push({
          itm: this
        });
        return "cellcont";
      })
      .attr("d", pathMonth)
      .style("stroke", "#909090")
      .style("fill", "transparent")
  }

  container.selectAll(".cell")
    .data(d3.timeDays(start, end))
    .enter()
    .append("rect")
    .attr("class", function (d, index) {
      var idx = _this.categoryList.hasElement(d);
      //if (idx >= 0) {
      _this.items.push({
        itm: this,
        category: d,
        value: idx >= 0 ? _this.dataSet[idx][1] : null,
        itemType: "cellcal"
      });
      //}
      return "cell cell_" + index + " TRANSP";
    })
    .attr("x", function (d, index) {
      switch (_this.defSettings.time.dataView) {
        case "year":
          return d3.timeWeek.count(d3.timeYear(d), d) * cellSize;
          break;
        case "month":
          return index * cellSize;
          break;
      }
    })
    .attr("y", function (d) {
      switch (_this.defSettings.time.dataView) {
        case "year":
          return d.getDay() * cellSize;
          break;
        case "month":
          return 0;
          break;
      }
    })
    .attr("width", cellSize)
    .attr("height", cellSize);

  function pathMonth(t0) {
    var t1 = new Date(t0.getFullYear(), t0.getMonth() + 1, 0),
      d0 = t0.getDay(),
      w0 = d3.timeWeek.count(d3.timeYear(t0), t0),
      d1 = t1.getDay(),
      w1 = d3.timeWeek.count(d3.timeYear(t1), t1);

    return "M" + (w0 + 1) * cellSize + "," + d0 * cellSize
      + "H" + w0 * cellSize + "V" + 7 * cellSize
      + "H" + w1 * cellSize + "V" + (d1 + 1) * cellSize
      + "H" + (w1 + 1) * cellSize + "V" + 0
      + "H" + (w0 + 1) * cellSize + "Z";
  }
}
StdChart.prototype.DrawPyramid = function (container, data, dataIndex, yIndex, gWidth, gHeight) {
  var dList = this._GetOppositeDrawingList(),
    _this = this,
    j,
    linecurrent,
    line2,
    hneck = 0,
    wneck = 0,
    condition = (this.defSettings.pyramid.rotation == 90 || this.defSettings.pyramid.rotation == 270),
    pts;

  this.borderItem[dataIndex] = container.append("path")
    .style("fill", "none")
    .style("stroke", "#000000");

  if (this.hasNeck) {
    hneck = (this.defSettings.pyramid.height * (condition ? gWidth : gHeight)) / 100;
    wneck = (this.defSettings.pyramid.width * (condition ? gHeight : gWidth)) / 100;

    if (hneck > 0 && wneck == 0)
      wneck = 7;
  }

  switch (this.defSettings.pyramid.rotation) {
    case 0:
      this.borderItem[dataIndex]
        .attr("d", "M" + ((gWidth - wneck) / 2) + "," + 0
          + "L" + (((gWidth - wneck) / 2) + wneck) + "," + 0
          + "L" + (((gWidth - wneck) / 2) + wneck) + "," + hneck
          + "L" + gWidth + "," + gHeight
          + "L" + 0 + "," + gHeight
          + "L" + ((gWidth - wneck) / 2) + "," + hneck + "Z")
      break;
    case 90:
      this.borderItem[dataIndex]
        .attr("d", "M" + 0 + "," + 0
          + "L" + (gWidth - hneck) + "," + ((gHeight - wneck) / 2)
          + "L" + gWidth + "," + ((gHeight - wneck) / 2)
          + "L" + gWidth + "," + (((gHeight - wneck) / 2) + wneck)
          + "L" + (gWidth - hneck) + "," + (((gHeight - wneck) / 2) + wneck)
          + "L" + 0 + "," + gHeight + "Z")
      break;
    case 180:
      this.borderItem[dataIndex]
        .attr("d", "M" + 0 + "," + 0
          + "L" + ((gWidth - wneck) / 2) + "," + (gHeight - hneck)
          + "L" + ((gWidth - wneck) / 2) + "," + gHeight
          + "L" + (((gWidth - wneck) / 2) + wneck) + "," + gHeight
          + "L" + (((gWidth - wneck) / 2) + wneck) + "," + (gHeight - hneck)
          + "L" + gWidth + "," + 0 + "Z")
      break;
    case 270:
      this.borderItem[dataIndex]
        .attr("d", "M" + 0 + "," + ((gHeight - wneck) / 2)
          + "L" + hneck + "," + ((gHeight - wneck) / 2)
          + "L" + gWidth + "," + 0
          + "L" + gWidth + "," + gHeight
          + "L" + hneck + "," + (((gHeight - wneck) / 2) + wneck)
          + "L" + 0 + "," + (((gHeight - wneck) / 2) + wneck) + "Z")
      break;
  }

  if (!this.byCount) { //PYR altezza percentuali
    linecurrent = {
      x1: 0,
      y1: 0,
      x2: (condition) ? 0 : gWidth,
      y2: (condition) ? gHeight : 0
    };
    var progrH = 0,
      progrW = 0;

    for (j = 0; j < data.length; j++) {
      progrH = progrH + ((data[j][yIndex] * gHeight) / this.totalsSeries[dList[dataIndex]].sum);
      progrW = progrW + ((data[j][yIndex] * gWidth) / this.totalsSeries[dList[dataIndex]].sum);

      line2 = {
        x1: (condition) ? progrW : 0,
        y1: (condition) ? 0 : progrH,
        x2: (condition) ? progrW : gWidth,
        y2: (condition) ? gHeight : progrH
      }

      pts = path_line_intersections(this.borderItem[dataIndex].node(), linecurrent, line2, condition ? "x" : "y");

      container.append("polygon")
        .attr("class", function () {
          _this.items.push({
            itm: this,
            category: data[j][0],
            value: data[j][yIndex],
            categoryCode: data[j][2],
            itemType: "polygon"
          });
          return "polygon polygon_" + j + "_" + dataIndex + " TRANSP";
        })
        .attr("points", pts.map(function (d) { return [d.x, d.y].join(","); }))

      // cambio la linea corrente nel caso di PYR
      linecurrent = {
        x1: (condition) ? progrW : 0,
        y1: (condition) ? 0 : progrH,
        x2: (condition) ? progrW : gWidth,
        y2: (condition) ? gHeight : progrH
      }
    }
  }
  else { //PYRSTR altezze uguali
    for (j = 0; j < data.length; j++) {
      linecurrent = {
        x1: (condition) ? j * (gWidth / data.length) : 0,
        y1: (condition) ? 0 : j * (gHeight / data.length),
        x2: (condition) ? j * (gWidth / data.length) : gWidth,
        y2: (condition) ? gHeight : j * (gHeight / data.length)
      };
      line2 = {
        x1: (condition) ? (j + 1) * (gWidth / data.length) : 0,
        y1: (condition) ? 0 : (j + 1) * (gHeight / data.length),
        x2: (condition) ? (j + 1) * (gWidth / data.length) : gWidth,
        y2: (condition) ? gHeight : (j + 1) * (gHeight / data.length)
      };

      pts = path_line_intersections(this.borderItem[dataIndex].node(), linecurrent, line2, condition ? "x" : "y");

      container.append("polygon")
        .attr("class", function () {
          _this.items.push({
            itm: this,
            category: data[j][0],
            value: data[j][yIndex],
            itemType: "polygon",
            categoryCode: data[j][2]
          });
          return "polygon polygon_" + j + "_" + dataIndex + " TRANSP";
        })
        .attr("points", pts.map(function (d) { return [d.x, d.y].join(","); }));
    }
  }

  function path_line_intersections(pathEl, lineA, lineB, criterio) {
    var pts = [],
      pathLength = pathEl.getTotalLength();
    for (var i = 0; i < pathLength; i++) {
      var pos1 = pathEl.getPointAtLength(i),
        pos2 = pathEl.getPointAtLength(i + 1),
        line = { x1: pos1.x, x2: pos2.x, y1: pos1.y, y2: pos2.y };
      var c1 = btwn(line[criterio + "1"], lineA[criterio + "1"], lineB[criterio + "1"]);
      var c2 = btwn(line[criterio + "2"], lineA[criterio + "1"], lineB[criterio + "1"]);
      if (c1 && c2) {
        pts.push(pos1)
        pts.push(pos2)
      }
    }
    return pts;

    function btwn(a, b1, b2) {
      if ((a >= b1) && (a <= b2)) { return true; }
      if ((a >= b2) && (a <= b1)) { return true; }
      return false;
    }
  }
}
StdChart.prototype.DrawFunnel = function (container, data, dataIndex, yIndex, scaleY, gHeight) {
  var p1t, p1b, p1c,
    p2t, p2b, p2c,
    _this = this,
    pleft = [],
    pright = [],
    elem,
    sRadius = 2 * this.GetShapesRadius();

  for (var i = 0; i < data.length; i++) {
    if (this.defSettings.funnel.type != "shapes") {
      elem = container.append("path")
        .attr("class", function () {
          _this.items.push({
            itm: this,
            series: _this.seriesList[dataIndex],
            valueField: _this._GetOppositeDrawingList()[dataIndex],
            category: data[i][0],
            value: data[i][yIndex],
            itemType: "path"
          });
          return "path path_" + i + "_" + dataIndex + " TRANSP";
        })
    }

    switch (this.defSettings.funnel.type) {
      case 'middle':
        p1t = {
          //eslint-disable-next-line max-len
          x: (i == 0) ? scaleY.left(d3.max(scaleY.left.domain())) : scaleY.left(data[i - 1][yIndex]) + Math.abs(scaleY.left(data[i][yIndex]) - scaleY.left(data[i - 1][yIndex])) / 2,
          y: (i == 0) ? 0 : i * (gHeight / data.length) //- (gHeight/data.length)/2
        }
        p1c = {
          x: scaleY.left(data[i][yIndex]),
          y: i * (gHeight / data.length) + (gHeight / data.length) / 2
        }
        p1b = {
          x: (i == data.length - 1) ? scaleY.left(data[i][yIndex]) : scaleY.left(data[i][yIndex]) + Math.abs(scaleY.left(data[i + 1][yIndex]) - scaleY.left(data[i][yIndex])) / 2,
          y: (i + 1) * (gHeight / data.length)
        }
        p2t = {
          x: (i == 0) ? scaleY.right(d3.max(scaleY.left.domain())) : scaleY.right(data[i - 1][yIndex]) - (Math.abs(scaleY.right(data[i][yIndex]) - scaleY.right(data[i - 1][yIndex])) / 2), // eslint-disable-line max-len
          y: (i == 0) ? 0 : i * (gHeight / data.length) //- (gHeight/data.length)/2
        }
        p2c = {
          x: scaleY.right(data[i][yIndex]),
          y: i * (gHeight / data.length) + (gHeight / data.length) / 2
        }
        p2b = {
          x: (i == data.length - 1) ? scaleY.right(data[i][yIndex]) : scaleY.right(data[i][yIndex]) - (Math.abs(scaleY.right(data[i + 1][yIndex]) - scaleY.right(data[i][yIndex])) / 2), // eslint-disable-line max-len
          y: (i + 1) * (gHeight / data.length)
        }

        elem.attr("d", "M" + p1t.x + "," + p1t.y
          + "L" + p1c.x + "," + p1c.y
          + "L" + p1b.x + "," + p1b.y
          + "L" + p2b.x + "," + p2b.y
          + "L" + p2c.x + "," + p2c.y
          + "L" + p2t.x + "," + p2t.y + "Z")

        break;
      case 'blocks':
        p1t = {
          x: scaleY.left(data[i][yIndex]),
          y: i * (gHeight / data.length)
        }
        p1b = {
          x: scaleY.left(data[i][yIndex]),
          y: (i + 1) * (gHeight / data.length)
        }
        p2t = {
          x: scaleY.right(data[i][yIndex]),
          y: i * (gHeight / data.length)
        }
        p2b = {
          x: scaleY.right(data[i][yIndex]),
          y: (i + 1) * (gHeight / data.length)
        }
        elem.attr("d", "M" + p1t.x + "," + p1t.y
          + "L" + p1b.x + "," + p1b.y
          + "L" + p2b.x + "," + p2b.y
          + "L" + p2t.x + "," + p2t.y + "Z")

        break;
      case 'shapes':
        pleft.push({ x: scaleY.left(data[i][yIndex]), y: i * (gHeight / data.length) + sRadius })
        pright.push({ x: scaleY.right(data[i][yIndex]), y: i * (gHeight / data.length) + sRadius })
        break;
      case 'bottom':
        p1t = {
          x: (i == 0) ? scaleY.left(data[i][yIndex]) : scaleY.left(data[i - 1][yIndex]),
          y: i * (gHeight / data.length)
        }
        p1b = {
          x: scaleY.left(data[i][yIndex]),
          y: (i + 1) * (gHeight / data.length)
        }
        p2t = {
          x: (i == 0) ? scaleY.right(data[i][yIndex]) : scaleY.right(data[i - 1][yIndex]),
          y: i * (gHeight / data.length)
        }
        p2b = {
          x: scaleY.right(data[i][yIndex]),
          y: (i + 1) * (gHeight / data.length)
        }
        elem.attr("d", "M" + p1t.x + "," + p1t.y
          + "L" + p1b.x + "," + p1b.y
          + "L" + p2b.x + "," + p2b.y
          + "L" + p2t.x + "," + p2t.y + "Z")
        break;
    }
  }

  if (this.defSettings.funnel.type == "shapes") {
    container.append("polygon")
      .attr("class", function () {
        _this.items.push({
          itm: this,
          //  series :  _this.seriesList[_this.valueFields.indexOf(_this._GetDrawingList()[dataIndex])],
          valueField: _this._GetOppositeDrawingList()[dataIndex],
          //  keyField : !Empty(_this.objConfig.keyField) ? d[xIndex] : "",
          category: "",
          value: null,
          itemType: "path"
          //categoryCode : d[_this.categoryCodeIndex],
        });
        return "polygon polygon_" + 0 + "_" + dataIndex + " TRANSP";
      })
      .attr("points", function () {
        var puntiL = pleft.map(function (obj) { return [obj.x, obj.y].join(",") }),
          puntiR = pright.reverse().map(function (obj) { return [obj.x, obj.y].join(",") })
        return puntiL + "," + puntiR;
      })
  }
}
StdChart.prototype.DrawMekko = function (container, data, dataIndex, xIndex, yIndex) {
  var _this = this,
    fdata = data/*.filter( function (record) {
                          return _this._IsNotExcludedDomain(record[xIndex]);
                       }
                     );*/

  container.selectAll(".bar_" + dataIndex)
    .data(fdata)
    .enter()
    .append("rect")
    .attr("class", function (d, index) {
      _this.items.push({
        itm: this,
        series: d[_this.seriesIndex],
        valueField: _this.valueFields[dataIndex],
        //keyField : !Empty(_this.objConfig.keyField) ? d[xIndex] : "",
        category: /*!Empty(_this.objConfig.keyField) ? _this.categoryList[mindex] :*/ d[xIndex],
        value: d[yIndex],
        itemType: "bar",
        categoryCode: d[_this.categoryCodeIndex]
      });
      return "bar bar_" + index + "_" + dataIndex + " TRANSP";
    })
    .attr("x", function (d, index) {
      return _this._GetX(d, index, xIndex);
    })
    .attr("y", function (d, index) {
      return _this._GetY(d, index, yIndex);
    })
    .attr("width", function (d, index) {
      return _this._GetWidth(d, index, xIndex);
    })
    .attr("height", function (d, index) {
      return _this._GetHeight(d, index, yIndex);
    });
}
StdChart.prototype.DrawParallelLines = function (container, data, valList) {
  var _this = this,
    line = d3.line()
      .x(function (d, idx) {
        return _this.scaleX(valList[idx]) + _this.scaleX.bandwidth() / 2;
      })
      .y(function (d, idx) {
        return _this.scaleY[valList[idx]](d[2]);
      })
      .defined(function (d) {
        return d[2] != null;
      })
      .curve(d3[this.defSettings.line.type]);

  container.append("path")
    .datum(data)
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        keyField: d[idx][0],
        category: d[idx][1],
        itemType: "line"
      });
      return "line line_" + idx + " TRANSP";
    })
    .attr("d", line);
}
StdChart.prototype.DrawVoronoi = function (container, data, points) {
  var sidx = this.propertyName.indexOf(this.objConfig.labelSeries),
    del = d3.Delaunay.from(points),
    vor = del.voronoi([0, 0, this.chartWidth, this.chartHeight]),
    _this = this,
    voronoi = d3.voronoi().extent([[0, 0], [this.chartWidth, this.chartHeight]]),
    diagram = voronoi(points),
    links = diagram.links();

  if (this.defSettings.voronoi.links.show) {
    if (this.defSettings.voronoi.links.type == "voronoi") {
      container.selectAll(".link")
        .data(links)
        .enter()
        .append("path")
        .attr("class", "link")
        .attr("d", function (d) {
          return "M" + d.source + "L" + d.target;
        })
        .style("fill", "none")
        .style("stroke", this.defSettings.voronoi.links.color || "#34495e")
        .style("stroke-width", this.defSettings.voronoi.links.stroke || 1);
    }
    else {
      for (var i = 0; i < del.triangles.length / 3; i++) {
        container.append("path")
          .attr("class", "link")
          .attr("d", del.renderTriangle(i))
          .style("fill", "none")
          .style("stroke", this.defSettings.voronoi.links.color || "#34495e")
          .style("stroke-width", this.defSettings.voronoi.links.stroke || 1);
      }
    }
  }

  container.selectAll("circle")
    .data(data)
    .enter()
    .append("circle")
    .attr("class", function (d, idx) {
      _this.items.push({
        series: d[sidx],
        itm: this,
        category: d[_this.categoryIndex],
        coords: { x: d[_this.xValues], y: d[_this.yValues] },
        points: { x: points[idx][0], y: points[idx][1] },
        categoryCode: d[_this.categoryCodeIndex]
      });

      return "item item_" + idx + " TRANSP";
    })
    .attr("cx", function (d, idx) { return points[idx][0] })
    .attr("cy", function (d, idx) { return points[idx][1] })
    .attr("r", this._GetRadius())

  container.append("path")
    .attr("d", vor.render())
    .style("fill", "none")
    .style("stroke", this.defSettings.line.color || "#34495e")
    .style("stroke-width", this.defSettings.line.stroke || 1);
}
StdChart.prototype.DrawSankey = function (container, nodes, links) {
  var pos = this.defSettings.sankey.position.charAt(0).toUpperCase() + this.defSettings.sankey.position.slice(1),
    sankey = d3.sankey()
      .nodeAlign(d3["sankey" + pos])
      .nodeSort(this.defSettings.sankey.order ? null : undefined) // undefined x ordine default
      .nodeWidth(this.defSettings.sankey.nodes.width)
      .nodePadding(this.defSettings.sankey.nodes.padding)
      .extent([[this.margin.left, this.margin.top], [this.chartWidth, this.chartHeight]]),
    sdata = sankey({ nodes: nodes, links: links }),
    _this = this;

  container.selectAll(".node")
    .data(sdata.nodes)
    .enter()
    .append("rect")
    .attr("class", function (d) {
      _this.arcs.push({
        itm: this,
        index: d.index,
        depth: d.depth,
        name: d.name,
        sources: d.sourceLinks.slice(),
        targets: d.targetLinks.slice(),
        value: d.value
      });
      return "node node_" + d.depth + " TRANSP";
    })
    .attr("x", function (d) { return d.x0 })
    .attr("y", function (d) { return d.y0 })
    .attr("height", function (d) { return d.y1 - d.y0 })
    .attr("width", function (d) { return d.x1 - d.x0 })

  container.selectAll(".link")
    .data(sdata.links)
    .enter()
    .append("path")
    .attr("class", function (d, ii) {
      _this._totDepths = Math.max(_this._totDepths, d.source.depth + 1);
      _this.items.push({
        itm: this,
        depth: d.source.depth,
        sourceDesc: d.source.name,
        targetDesc: d.target.name,
        source: { name: d.source.name, value: d.source.value, index: d.source.index },
        target: { name: d.target.name, value: d.target.value, index: d.target.index },
        value: d.value,
        categoryCode: d.categoryCode,
        data_idx: ii
      });
      return "link link_" + d.index + " TRANSP";
    })
    .attr("d", d3.sankeyLinkHorizontal())
    .attr("stroke-width", function (d) { return Math.max(1, d.width) });
}
StdChart.prototype.DrawRingPerc = function (container, data, dataIndex, xIndex, yIndex, id, arc) {
  var _this = this,
    pie,
    pieData,
    stAngle,
    angleCos;

  pie = d3.pie()
    .value(function (d) {
      return Math.abs(d[yIndex]);
    })
    .sort(null);  // aggiunto altrimenti disegna le fette in ordine decrescente di valore nella torta

  if (isNaN(this.defSettings.orientation.startAngle))
    stAngle = 0;
  else
    stAngle = this.defSettings.orientation.startAngle - 90;
  angleCos = stAngle * (Math.PI / 180);
  pie.startAngle(angleCos).endAngle((2 * Math.PI) + angleCos);

  pieData = pie(data);
  this.pieData[dataIndex] = pieData;

  container.selectAll(".pie_")
    .data([pieData[0]])
    .enter()
    .append("path")
    .attr("class", function (d, idx) {
      _this.items.push({
        itm: this,
        series: _this.seriesList,
        valueField: _this.valueFields,
        keyField: !Empty(_this.objConfig.keyField) ? d.data[_this.xIndex] : "",
        category: !Empty(_this.objConfig.keyField) ? _this.categoryList[idx] : d.data[_this.xIndex],
        value: d.data[yIndex],
        dataIndex: dataIndex,
        //startAngle: angleCos,
        startAngle: d.startAngle,
        endAngle: d.endAngle,
        itemType: "arc",
        categoryCode: d.data[_this.categoryCodeIndex],
        radius: _this._GetRadius(),
        _3dFactor: 1,
        centroid: arc.centroid(d)
      });
      return "pie pie_" + idx + "_" + dataIndex + " TRANSP";
    })
    .attr("d", arc)
    .each(function (/*d*/) { this._arc = arc; });
}
/**** TRANSLATE ****/
StdChart.prototype.Translate = function (msg) {
  var languageMap = this._ZtChart.ZtChartTransDict,
  lang = (this.language.toLowerCase() == "usa") ? "eng" : this.language.toLowerCase();
  if (!(msg in languageMap) || !(lang in languageMap[msg])) {
    var trad = ZtChartDict.Translate(msg);
    if (typeof trad != "object")
      return trad;
    if (!(lang in trad)) {
      if (ZtVWeb && ZtVWeb.ChartTranslations) {
        var s_trad = ZtVWeb.ChartTranslations[msg];
        if (s_trad != msg)
          return s_trad;
      }
      if ("eng" in trad)
        return trad.eng;
      return msg;
    }
    return trad[lang];
  }
  return languageMap[msg][lang];
}

/*** METODI CHE POTREBBERO ESSERE SOVRASCRITTI -> COMPORTAMENTO DEFAULT E MAGGIORMENTE DIFFUSO RESO PROTOTIPALE ***/
StdChart.prototype._SetChartSettingsJSON = function () { };
StdChart.prototype._SetTitles = function () {
  if (this.dataOrder == "column") {
    if (!Empty(this.objConfig.titleSeries))
      this.defSettings.chartLegend.text = this.objConfig.titleSeries;
  }
  else
    this.legTitle = this.defSettings.axisLabel.xLabel;
}
StdChart.prototype._SetFieldsIndexes = function () {
  this.xIndex = this.xLabelIndex = this.propertyName.indexOf(this.objConfig.labelField);
  if (!Empty(this.objConfig.keyField)) {
    this.xLabelIndex = this.propertyName.indexOf(this.objConfig.labelField);
    this.xIndex = this.propertyName.indexOf(this.objConfig.keyField);
  }
}
StdChart.prototype._SetLists = function () {
  this._SetCategoryList();

  this.seriesList = this.objConfig.labelSeries.split(",");
  this.orgSeriesList = this.seriesList.slice();

  this.valueFields = this.objConfig.valueFields.split(',');
  this.drawingSeries = this.valueFields.slice();
  if (this.asZoomCursor && (this._ZtChart.StdChart && !this._ZtChart.StdChart.asZoomCursor)) {
    if (this._ZtChart.ZFObjConfig && !Empty(this._ZtChart.ZFObjConfig.valueFields))
      this.valueFields = this.valueFields.concat(this._ZtChart.ZFObjConfig.valueFields);
    this.valueFields.unique();
  }

  this._EvaluateAllValues();
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);

  this.legendList = this.orgSeriesList.slice();
  this.rowLegendList = this.orgCategoryList.slice();

  this._SetTotalsObject();
  this._SetNegativeValue();
}
StdChart.prototype._SetCategoryList = function () {
  if (!Empty(this.objConfig.keyField) && (this.xIndex != null)) { //MG VPV
    //-this.categoryList = getDuplicatesListXYZ(this.xIndex, this.xLabelIndex, this.dataSet).array;
    this.categoryList = getDuplicatesListCAT(this.xIndex, this.xLabelIndex, this.dataSet).array;
    this.orgCategoryList = getList(this.xIndex, this.dataSet);
  }
  else {
    this.categoryList = getList(this.xIndex, this.dataSet);
    this.orgCategoryList = this.categoryList.slice();
  }
  this.drawingCategories = this.orgCategoryList.slice();
}
StdChart.prototype._EvaluateAllValues = function () {
  this.allValues = [];
  var vf = this.valueFields.slice();
  if (this.asZoomCursor && (this._ZtChart.StdChart && !this._ZtChart.StdChart.asZoomCursor)) {
    vf = this._ZtChart.ZFObjConfig.valueFields.slice();
    if (Empty(vf))
      vf = this.valueFields.slice();
  }
  for (var i = 0; i < vf.length; i++) {
    this[vf[i] + "_values"] = getValues([vf[i]], this.propertyName, this.dataSet);
    if (!this.multipleScales)
      this.allValues = this.allValues.concat(this[vf[i] + "_values"]);
    else if (this.objConfig.mapSeries) {
      if (this.objConfig.mapSeries[vf[i]] && !this.objConfig.mapSeries[vf[i]].ownerScale)
        this.allValues = this.allValues.concat(this[vf[i] + "_values"]);
      else if (!(vf[i] in this.objConfig.mapSeries))
        this.allValues = this.allValues.concat(this[vf[i] + "_values"]);
    }
  }
}
StdChart.prototype._SetNegativeValue = function () {
  this.hasNegativeValues = false;
}
StdChart.prototype._SetTotalsObject = function () {
  this.totalsSeries = {};
  for (var i = 0; i < this.valueFields.length; i++) {
    this.totalsSeries[this.valueFields[i]] = {};
    this.totalsSeries[this.valueFields[i]].sum = d3.sum(getList(this.propertyName.indexOf(this.valueFields[i]), this.dataSet, true));
    this.totalsSeries[this.valueFields[i]].abs = d3.sum(getAbsList(this.propertyName.indexOf(this.valueFields[i]), this.dataSet, true));
  }
  this.totalsSeries.categoriesT = {};
  for (i = 0; i < this.orgCategoryList.length; i++) {
    var sum = 0;
    for (var j = 0; j < this.valueFields.length; j++)
      sum = sum + Math.abs(this.dataSet[i][this.propertyName.indexOf(this.valueFields[j])]);
    this.totalsSeries.categoriesT[i] = sum;
  }
}
StdChart.prototype._SetCalculationDataset = function () {
  this.calcDataset = [];
}
StdChart.prototype._AfterCalculation = function (/*mchart*/) { }
StdChart.prototype._SetScales = function () {
  this.scaleY = {};
  var vf = this.valueFields.slice();
  if (this.asZoomCursor && (this._ZtChart.StdChart && !this._ZtChart.StdChart.asZoomCursor)) {
    vf = this._ZtChart.ZFObjConfig.valueFields.slice();
    if (Empty(vf))
      vf = this.valueFields.slice();
  }
  for (var i = 0; i < vf.length; i++) {
    this.scaleY[vf[i]] = d3.scaleLinear();
  }

  var dlist = this._GetOppositeAxisDrawingList(true);
  if (this.domainIsTime)
    this.scaleX = d3.scaleTime().domain([d3.min(dlist), d3.max(dlist)]);
  else if (this.domainIsNumber)
    this.scaleX = d3.scaleLinear().domain([d3.min(dlist), d3.max(dlist)]);
  else
    this.scaleX = d3.scaleBand().domain(dlist);
}
StdChart.prototype._GetValuesPrecision = function () {
  var prec = 0;
  if (!Empty(this.rangeBandsGlobal))
    prec = this.rangeminmax.precision;
  else {
    if (isNaN(this.defSettings.valueAxis.precision) || (Empty(this.defSettings.valueAxis.precision) && this.defSettings.valueAxis.precision != 0)) {
      if (isNaN(this.defSettings.valueAxis.tick) || (Empty(this.defSettings.valueAxis.tick) && this.defSettings.valueAxis.tick != 0))
        prec = this.GetPrecisionFromDataSet("values");
      else if (!Empty(this.rangeminmax.precision))
        prec = this.rangeminmax.precision;
      else
        prec = decimalPlaces(this.defSettings.valueAxis.tick);
    }
    else
      prec = this.defSettings.valueAxis.precision;
  }
  if (prec < 0)
    prec = 0;
  if (prec > 20)
    prec = 20;
  return prec;
}
StdChart.prototype._GetDomainPrecision = function () {
  if (!this.domainIsNumber)
    return 0;
  var prec = 0;
  if (isNaN(this.defSettings.domainAxis.precision) || (Empty(this.defSettings.domainAxis.precision) && this.defSettings.domainAxis.precision != 0))
    prec = this.GetPrecisionFromDataSet("domain");
  else
    prec = this.defSettings.domainAxis.precision;
  if (prec < 0)
    prec = 0;
  if (prec > 20)
    prec = 20;
  return prec;
}
StdChart.prototype._DrawChartPlot = function () { }
StdChart.prototype._DrawChartPlotTitles = function (container) {
  this.DrawTitle();
  this.DrawLegendItems(container);
  this.DrawSubtitle();
}
StdChart.prototype._DrawAxis = function () {
  var scs = Object.keys(this.scaleY),
    sc,
    sckey,
    axisContainer = this.svg.select("#" + this.chartId + "valueAxisGroup");

  if (Empty(axisContainer.node()))
    axisContainer = this.svg.append("g").attr("id", this.chartId + "valueAxisGroup")

  this.MapDrawAxis();
  this.DrawAndEvaluateDomainAxis();
  for (var i = 0; i < scs.length; i++) {
    sc = this.scaleY[scs[i]];
    sckey = scs[i];

    this.DrawValueAxis(axisContainer, sc, sckey);
  }

  this._DrawAxisReferenceLines();
}
StdChart.prototype._DrawGridLines = function () {
  this._DrawValueAxisGrid();
  this._DrawDomainAxisGrid();
}
StdChart.prototype._DrawValueAxisGrid = function () {
  var ticksArray = d3.select(this.svg.select("#" + this.chartId + "valueAxisGroup").node().firstChild).selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;
  var pos = [],
    xR = this.margin.left,
    yR = this.margin.top,
    w = this.chartWidth,
    grid,
    axisTickY = 0.5,
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
      .append("line")
      .attr("class", "valueGridline TRANSP")
      .attr("id", function (d, i) {
        return _this.chartId + "valueGLine_" + i;
      })
      .attr("x1", xR)
      .attr("y1", function (d) {
        return yR + d + axisTickY;
      })
      .attr("x2", xR + w)
      .attr("y2", function (d) {
        return yR + d + axisTickY;
      });
  }
}
StdChart.prototype._DrawDomainAxisGrid = function () {
  var ticksArray = this.svg.select("#" + this.chartId + "domainAxisGroup").selectAll(".tick")._groups[0];
  if (Empty(ticksArray))
    return;

  var _this = this,
    pos = [],
    xR = this.margin.left,
    yR = this.margin.top,
    h = this.chartHeight,
    grid,
    axisTickX = 0.5;

  if (Empty(this.svg.select("#" + this.chartId + "domainAxisGridline").node()))
    grid = this.renderer.append("g")
      .attr("id", this.chartId + "domainAxisGridline");

  if ((this.chartConfig.graphSettings.domainAxis.useValueGrid && this.defSettings.valueAxis.valueGrid.line) || this.defSettings.domainAxis.domainGrid.line) {
    for (var i = 0; i < ticksArray.length; i++) {
      var tick = ticksArray[i];
      if (tick.transform.baseVal.length > 0 || tick.transform.baseVal.numberOfItems > 0)
        pos.push(tick.transform.baseVal.getItem(0).matrix.e);
    }

    grid.selectAll(".domainGridline")
      .data(pos)
      .enter()
      .append("line")
      .attr("class", "domainGridline TRANSP")
      .attr("id", function (d, i) {
        return _this.chartId + "domainGLine_" + i;
      })
      .attr("x1", function (d) {
        return xR + d + axisTickX;
      })
      .attr("y1", yR)
      .attr("x2", function (d) {
        return xR + d + axisTickX;
      })
      .attr("y2", yR + h);
  }
}
StdChart.prototype._DrawAxisLabel = function () {
  var xInit, yInit, groupSize;
  xInit = this.margin.top + (this.chartHeight / 2);
  yInit = this.margin.left;
  if (this.defSettings.valueAxis.show) {
    groupSize = d3.select("#" + this.chartId + "valueAxisGroup").node().getBBox();
    yInit = Math.abs(groupSize.x);
  }
  this.DrawAxisLabel("value", this._GetValueAxisPosition(), xInit, yInit, this.defSettings.axisLabel.yLabel);
  xInit = this.margin.left + (this.chartWidth / 2);
  yInit = this.margin.top + this.chartHeight;
  if (this.defSettings.domainAxis.show) {
    groupSize = d3.select("#" + this.chartId + "domainAxisGroup").node().getBBox();
    yInit = this.margin.top + this.chartHeight + groupSize.height;
  }
  this.DrawAxisLabel("domain", this._GetDomainAxisPosition(), xInit, yInit, this.defSettings.axisLabel.xLabel);
}
StdChart.prototype._GetValueAxisPosition = function () { }
StdChart.prototype._GetDomainAxisPosition = function () { }
StdChart.prototype._GetPercentAxisPosition = function () { }
StdChart.prototype._GetValueAxisMinMax = function () { }
StdChart.prototype._GetPercentAxisMinMax = function () { }
StdChart.prototype._SetValueScaleParameters = function (/*min, max*/) { }
StdChart.prototype._SetPercentScaleParameters = function (/*min, max, scaleKey*/) { }
StdChart.prototype._SelectAutoTickUnit = function (scaleY, min, max, font, isDomain, precision) {
  if (Empty(this.tickUnit))
    this.tickUnit = 1.0;
  var isFloat = precision > 0,
    unit1, unit2, guess,
    maxDigits = Math.max(howManyDigits(min), howManyDigits(max));

  if (isFloat && maxDigits > (precision + 1))
    isFloat = false;

  if (isDomain) {
    var tickLabelWidth = estimateMaximumTickLabel("width", Math.round(min), Math.round(max), this.chartId, font, precision);
    unit1 = this.tickUnit;
    var unit1Width = Math.abs(this.scaleX(unit1) - this.scaleX(0));
    guess = (tickLabelWidth / unit1Width) * unit1;
    unit2 = getCeilingTickUnit(getStandardTickUnits(maxDigits, isFloat), guess);
    var unit2Width = Math.abs(this.scaleX(getStandardTickUnits(maxDigits, isFloat)[unit2]) - this.scaleX(0));
    if (tickLabelWidth > unit2Width) {
      unit2 = getLargerTickUnit(getStandardTickUnits(maxDigits, isFloat), getStandardTickUnits(maxDigits, isFloat)[unit2]);
    }
    this.tickUnit = getStandardTickUnits(maxDigits, isFloat)[unit2];
  }
  else {
    var tickLabelHeight = estimateMaximumTickLabel("height", Math.round(min), Math.round(max), this.chartId, font, precision);
    unit1 = this.tickUnit;
    var unit1Height = Math.abs(scaleY(unit1) - scaleY(0));
    guess = (tickLabelHeight / unit1Height) * unit1;
    unit2 = getCeilingTickUnit(getStandardTickUnits(maxDigits, isFloat), guess);
    var unit2Height = Math.abs(scaleY(getStandardTickUnits(maxDigits, isFloat)[unit2]) - scaleY(0));
    if (tickLabelHeight > unit2Height) {
      unit2 = getLargerTickUnit(getStandardTickUnits(maxDigits, isFloat), getStandardTickUnits(maxDigits, isFloat)[unit2]);
    }
    this.tickUnit = getStandardTickUnits(maxDigits, isFloat)[unit2];
  }
}
StdChart.prototype._SetDomainScaleParameters = function () { }
StdChart.prototype._GetDomainAxisXPosition = function () { }
StdChart.prototype._GetDomainAxisYPosition = function () { }
StdChart.prototype._GetValueAxisXPosition = function () { }
StdChart.prototype._GetValueAxisYPosition = function () { }
StdChart.prototype._GetPercentAxisXPosition = function () { }
StdChart.prototype._GetPercentAxisYPosition = function () { }
StdChart.prototype._DrawChartElements = function () { }
StdChart.prototype._CreateRendererGradient = function () { }
StdChart.prototype._CreateElementGradient = function () { }
StdChart.prototype._SetAxisColor = function () {
  // top y2 -3 | btm y2 3 | lft x2 -3 | rgt x2 3
  var scs = Object.keys(this.scaleY);
  for (var i = 0; i < scs.length; i++) {
    if (!this.scaleY[scs[i]].__noDraw)
      this.SetAxisColor("value", "x2", -3, false, replaceSpecialCharsForID("_" + this.scaleY[scs[i]].__refAxis), this.scaleY[scs[i]].__refAxis);
  }
  this.SetAxisColor("domain", "y2", 3);
}
StdChart.prototype._SetAxisGridColor = function () {
  //this.SetValueAxisGridColor();
  this.SetAxisGridColor("value");
  this.SetAxisGridColor("domain");
}
StdChart.prototype._SetAxisFont = function () {
  var scs = Object.keys(this.scaleY);
  for (var i = 0; i < scs.length; i++)
    this.SetAxisFont("value", replaceSpecialCharsForID("_" + this.scaleY[scs[i]].__refAxis), this.scaleY[scs[i]].__refAxis);
}
StdChart.prototype._SetAxisLabelFont = function () {
  this.SetAxisLabelFont("value");
  this.SetAxisLabelFont("domain");
}
StdChart.prototype._SetElementsColor = function () { }
StdChart.prototype._SetShapesColor = function () {
  var mapser;
  for (var i = 0; i < this.shapes.length; i++) {
    var idx = this.valueFields.indexOf(this.shapes[i].valueField);
    mapser = false;
    if (idx >= 0) {
      this.shapes[i].idx = idx;
      this.shapes[i].sidx = this.orgCategoryList.indexOf(this.shapes[i].category);
      if (!Empty(this.objConfig.keyField))
        this.shapes[i].sidx = this.orgCategoryList.indexOf(this.shapes[i].keyField);
      this.shapes[i].color = { color: this.colorSet[idx].color, gradient: this.colorSet[idx].gradient };
      if (this.defSettings.useColorSeriesForEach)
        this.shapes[i].color = { color: this.colorSet[i].color, gradient: this.colorSet[i].gradient };
      if (this.shapes[i].isHole)
        this.shapes[i].color.color = invertColor(this.shapes[i].color.color);
      var styleObj = {};
      styleObj.fill = this.GetChartBackground().color;
      styleObj.stroke9width = (this.defSettings.shape.stroke || 1) + "px";
      // gestione multi serie solo shapes
      if (this.objConfig.mapSeries) {
        if (this.shapes[i].valueField in this.objConfig.mapSeries) {
          if (this.objConfig.mapSeries[this.shapes[i].valueField].type == "SLINES") {
            styleObj.stroke = this.shapes[i].color.color;
            if (this.defSettings.shape.colorSeries[idx])
              styleObj.stroke = this.defSettings.shape.colorSeries[idx].color;
            if (this.defSettings.shape.fill)
              styleObj.fill = this.shapes[i].color.color;
            else
              styleObj.fill = "url(#" + this.chartId + "rendererGradient)";
            mapser = true;
          }
          else
            mapser = false;
        }
        else
          mapser = false;
      }
      if (!mapser) {
        if (!this.defSettings.shape.onlyHover) {
          styleObj.stroke = this.shapes[i].color.color;
          if (this.defSettings.shape.colorSeries[idx])
            styleObj.stroke = this.defSettings.shape.colorSeries[idx].color;
          if (this.defSettings.shape.customFill && !Empty(this.defSettings.shape.fillColorSeries)) {
            if (this.defSettings.shape.fillColorSeries[idx])
              styleObj.fill = this.defSettings.shape.fillColorSeries[idx].color;
            else {
              if (this.defSettings.shape.fill)
                styleObj.fill = this.shapes[i].color.color;
              else
                styleObj.fill = "url(#" + this.chartId + "rendererGradient)";
            }
          }
          else {
            if (this.defSettings.shape.fill)
              styleObj.fill = this.shapes[i].color.color;
            else
              styleObj.fill = "url(#" + this.chartId + "rendererGradient)";
          }
        }
        else {
          styleObj.stroke = "transparent";
          styleObj.fill = "transparent";
        }
      }
      this.shapes[i].colorApplied = this.shapes[i].color.color;
      d3.select(this.shapes[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.shapes[i].itm).attr("style")));
    }
  }
}
StdChart.prototype._GetLegendIconHexCode = function () {
  var cleg = this.chartLegends ? this.chartLegends : this._ZtChart.StdChart.chartLegends,
    iconHexCode = evalIcon(cleg.series.obj.icon);
  if (Empty(iconHexCode)) {
    if (this._HasShapes()) {
      if (this.defSettings.shape.differSeries) {
        iconHexCode = [];
        for (var i = 0; i < this.legendList.length; i++) {
          var index = i,
            fig = this.defSettings.shape.figureTypes[index];
          if (Empty(fig) || index > this.defSettings.shape.figureTypes.length)
            fig = this.defSettings.shape.figureTypes[index % this.defSettings.shape.figureTypes.length];
          iconHexCode.push(evalIcon(fig));
        }
      }
      else
        iconHexCode = evalIcon(this.defSettings.shape.figure);
    }
  }
  if (Empty(iconHexCode))
    iconHexCode = this.legendHexCode;

  return iconHexCode;

  function evalIcon(type) {
    var icon = "";
    switch (type) {
      case "cross":
        icon = "f067";
        break;
      case "square":
        icon = "f0c8";
        break;
      case "star":
        icon = "f005";
        break;
      case "diamond":
        icon = "e919";
        break;
      case "wye":
        icon = "f00d";
        break;
      case "triangle":
        icon = "f071";
        break;
      case "circle":
        icon = "f111";
        break;
      default:
        icon = "";
        break;
    }
    return icon;
  }
}
StdChart.prototype._GetRangeLegendIconHexCode = function () {
  return "ec46";
}
StdChart.prototype._GetMarkerLegendIconHexCode = function () {
  return "f02e";
}
StdChart.prototype._SetAxisLabelsPositions = function () {
  var axisLabelV = this.svg.select("#" + this.chartId + "valueAxisLabel"),
    axisLabelD = this.svg.select("#" + this.chartId + "domainAxisLabel"),
    y,
    offset = 5;
  if (Empty(axisLabelV.node()) && Empty(axisLabelD.node()))
    return;
  if (!Empty(axisLabelV.node())) {
    y = parseFloat(axisLabelV.attr("y"));
    var upd = false;
    if (!Empty(this.chartTitle) && this.defSettings.chartTitle.position == "left") {
      y = y + getOffsetHeight(this.chartTitle, appliedFont(this.defSettings, this.defSettings.chartTitle, this.defSettings.chartTitle.textFont), this.chartId);
      upd = true;
    }
    var legend;
    if (!Empty(this.legendList) && this.chartLegends.series.position == "left" && !this.chartLegends.series.hide) {
      legend = parseFloat(d3.select("#" + this.chartId + "legend_container_rect").attr("width"));
      y = y + legend + offset;
      upd = true;
    }

    if (!Empty(this.chartSubtitle) && this.defSettings.chartSubtitle.position == "left") {
      y = y + getOffsetHeight(this.chartSubtitle, appliedFont(this.defSettings, this.defSettings.chartSubtitle, this.defSettings.chartSubtitle.textFont), this.chartId) + offset;
      upd = true;
    }

    if (this.chartLegends.range && !Empty(this.defSettings.range.bands) && this.chartLegends.range.position == "left") {
      legend = parseFloat(d3.select("#" + this.chartId + "legend_container_rectrange").attr("width"));
      y = y + legend + offset;
      upd = true;
    }

    if (upd)
      y = y + offset;

    axisLabelV.attr("y", y);
  }

  if (!Empty(axisLabelD.node())) {
    y = this.margin.top + this.chartHeight;
    if (this.defSettings.domainAxis.show) {
      var groupSize = d3.select("#" + this.chartId + "domainAxisGroup").node().getBBox();
      y = this.margin.top + this.chartHeight + groupSize.height;
    }
    axisLabelD.attr("y", y + axisLabelD.node().getBBox().height + (offset / 2));
  }
}
StdChart.prototype._GetChartMarginsObject = function () { }
StdChart.prototype._GetInnerRadius = function () { }
StdChart.prototype._GetRadius = function () { }
StdChart.prototype._DrawMultiSVGPlot = function (id, parent, svgLeft, svgTop, svgWidth, svgHeight/*, onlySVG*/) {
  this.CalculateMargins(svgWidth, svgHeight, this.genLabels);
  this.CreateSVG(id, parent, false, svgLeft, svgTop, svgWidth, svgHeight, true, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  this.CreateRenderer(this.svg, id, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
}
StdChart.prototype._InterruptAnimateChartElements = function () {
  var i, elem;
  for (i = 0; i < this.items.length; i++) {
    elem = this.items[i].itm;
    if (!elem)
      continue;
    d3.select(elem).interrupt();
  }
  if (!Empty(this.shapes))
    for (i = 0; i < this.shapes.length; i++) {
      elem = this.shapes[i].itm;
      if (!elem)
        continue;
      d3.select(elem).interrupt();
    }
}
StdChart.prototype._NotAnimatedChartElements = function () { }
StdChart.prototype._GetDivisor = function () { }
StdChart.prototype._SupportChangeOrder = function () {
  return true;
}
StdChart.prototype._ApplyMouseOver = function (item, itemObj) {
  this.RemoveAllHovers();
  this.AppendHoverItem(item, itemObj);
}
StdChart.prototype._ApplyEvents = function () {
  var _this = this,
    items = this._GetItems();
  for (var i = 0; i < items.length; i++) {
    d3.select(items[i].itm)
      .attr("item-type", "element")
      .attr("item-index", i)
      .on("mouseover", function () {
        _this._ApplyMouseOver(this);
      });
  }
}
StdChart.prototype._ApplyRangeBands = function () {
  var isFnc = (this.objConfig.rangeBands == "function");
  if (this.defSettings.range.applyColor)
    this._SetElementsRangeColor(isFnc);
  else
    this.SetRangeInItems();
}
StdChart.prototype._DrawRangeBands = function (id) {
  if (Empty(this.svg.select("#" + (id || this.chartId) + "rangeBands").node()))
    this.renderer.append("g").attr("id", (id || this.chartId) + "rangeBands");
}
StdChart.prototype._SetElementsRangeColor = function (isFnc) {
  var styleObj,
    fill, band;
  for (var i = 0; i < this.items.length; i++) {
    if (this.items[i].idx >= 0) {
      if (isFnc) {
        if (this.functionObj && ("GetConditionalFormatting" in this.functionObj)) {
          var fncRet = this.functionObj.GetConditionalFormatting(this._GetItemObj(this.items[i]));
          styleObj = decodeConditionalFormatting(fncRet);
          fill = styleObj.fill;
        }
      }
      else {
        band = this.GetObjectFromRange(this.items[i].value, this.defSettings.range.bands);
        fill = band.color;
        this.SetRangeInItems(this.items[i], band);
        styleObj = { fill: fill };
      }
      this.items[i].colorApplied = fill;
      d3.select(this.items[i].itm).attr("style", makeStyleHTMLString(styleObj, d3.select(this.items[i].itm).attr("style")));
    }
  }
}
StdChart.prototype._SetAxisLabelOrientation = function (axisType, orientation, axId) {
  axId = axId || "";
  var ticks = this.svg.select("#" + this.chartId + axisType + "AxisGroup" + axId).selectAll("text")._groups[0],
    textTick,
    textRect,
    offsetTick = 6;
  for (var i = 0; i < ticks.length; i++) {
    textTick = d3.select(ticks[i]);
    textTick.attr("y", 1.5 * offsetTick);
    textRect = textTick.node().getBBox();
    switch (orientation) {
      case "V":
        textTick.attr("transform", "rotate(-90) translate(" + [(textRect.x - offsetTick), - (textRect.y + textRect.height / 2)] + ")");
        break;
      case "VD":
        textTick.attr("transform", "rotate(90) translate(" + [(- textRect.x + offsetTick), - (textRect.y + textRect.height / 2)] + ")");
        break;
      case "45U":
        textTick.attr("transform", "rotate(-45) translate(" + [textRect.x, 0] + ")");
        break;
      case "45D":
        textTick.attr("transform", "rotate(45) translate(" + [- textRect.x, 0] + ")");
        break;
      default:
        break;
    }
  }
}
StdChart.prototype._GetItemClone = function (item/*, itemObject*/) {
  return this.GetItemClone(item);
}
StdChart.prototype._ApplyClick = function (itemObject, evt) {
  if (!this._ZtChart.enableClick)
    return;
  this._SelectItem(itemObject, null);
  var mRefChart = this._ZtChart.StdChart,
    itemObj = this._GetItemObj(itemObject);
  itemObj.mouse = evt;
  if (mRefChart._ZtChart.parentCtrl && mRefChart._ZtChart.parentCtrl.SetCurRec) {
    if (itemObj.rowIdx >= 0)  // -1 non punta nessuna riga cursore
      mRefChart._ZtChart.parentCtrl.SetCurRec(itemObj.rowIdx + 1, true);
  }
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
  this.OpenLink(itemObj);
}
StdChart.prototype._FindItemObject = function (itemObject) {
  var myItems = this._GetItems().slice(),
    ret = itemObject;
  if (!itemObject.itm) {
    for (var i = 0; i < myItems.length; i++) {
      if (this._CheckIdentityItem(itemObject, myItems[i])) {
        ret = myItems[i];
        i = myItems.length;
      }
    }
  }
  return ret;
}
StdChart.prototype._GetItemObj = function (itemObject) {
  var ret = {
    category: itemObject.category,
    series: itemObject.series,
    range: itemObject.range,
    value: itemObject.value,
    progrValue: itemObject.progrValue,
    selIdx: itemObject.idx,
    rowIdx: (this.dataOrder == "column" ? itemObject.sidx : itemObject.idx),
    categoryCode: itemObject.categoryCode,
    keyF: itemObject.keyField,
    valueField: itemObject.valueField,
    geo_name: itemObject._0desc + (!Empty(itemObject._subdesc + "") ? " - " + itemObject._subdesc : ""),
    cname: Empty(itemObject._0) ? "" : (itemObject._0 + (!Empty(itemObject._sub + "") ? "_" + itemObject._sub : "")),
    x: itemObject.x,
    y: itemObject.y,
    z: itemObject.z,
    isSelected: itemObject.isSelected,
    focus: itemObject.focus,
    isChangeDataOrder: this.dataOrder != this._GetDefaultDataOrder(),
    color: itemObject.color
  };
  if( this.appliedKey  ) { //GM
    ret.multidimCurrentKey = this.appliedKey;
  }
  return ret;
}
StdChart.prototype._GetItems = function () {
  return this.items;
}
StdChart.prototype._ApplyItemSVGSelectEffect = function (items, selected) {
  if (!this._ZtChart.enableClickEffect)
    return;
  var halfOpacity = this.defSettings.selectionOptions.opacity,
    fullOpacity = 1,
    fillColor = this.defSettings.selectionOptions.color,
    stobj;
  for (var i = 0; i < items.length; i++) {
    if (!items[i].itm)
      continue;
    if (items[i].type == "legend") {
      this._ApplyLegendSelectEffect(items[i], selected);
      continue;
    }

    stobj = {};
    if (selected) {
      stobj.fill9opacity = fullOpacity;
      stobj.stroke9opacity = fullOpacity;
      if (!Empty(items[i].colorApplied))
        stobj.fill = items[i].colorApplied;
    }
    else {
      stobj.fill9opacity = halfOpacity;
      stobj.stroke9opacity = halfOpacity;
      if (!Empty(fillColor) && this.GetSelectedItems().length > 0)
        stobj.fill = fillColor;
    }
    d3.select(items[i].itm).attr("style", makeStyleHTMLString(stobj, d3.select(items[i].itm).attr("style")));
  }
}
StdChart.prototype._ApplyLegendSelectEffect = function (item, selected) {
  var halfOpacity = this.defSettings.selectionOptions.opacity,
    othOpacity = 0.33,
    fullOpacity = 1,
    fillColor = this.defSettings.selectionOptions.color,
    stobj = {};
  if (selected) {
    stobj.fill9opacity = fullOpacity;
    if (!Empty(item.itm.getAttribute("data-font")))
      stobj.fill = item.itm.getAttribute("fill");
  }
  else {
    if (!Empty(item.itm.getAttribute("data-font"))) {
      stobj.fill9opacity = halfOpacity;
      if (!Empty(fillColor) && this.GetSelectedItems().length > 0)
        stobj.fill = fillColor;
    }
    else
      stobj.fill9opacity = othOpacity;
  }
  d3.select(item.itm).attr("style", makeStyleHTMLString(stobj, d3.select(item.itm).attr("style")));
}
StdChart.prototype._GetRelatedItm = function (itemObject) {
  var ret = [];
  ret.push(itemObject);
  return ret;
}
StdChart.prototype._SelectItem = function (itemObject, select) {
  if (this.drawStatic)
    return;
  itemObject = this._FindItemObject(itemObject);
  if (!itemObject.itm)
    return;
  var relItems = this._GetRelatedItm(itemObject);
  for (var i = 0; i < relItems.length; i++) {
    if (select == null) {  // SELEZIONE NON PASSATA
      if (!relItems[i].isSelected)
        relItems[i].isSelected = true;
      else
        relItems[i].isSelected = false;
    }
    else
      relItems[i].isSelected = select;

    if (relItems[i].isSelected && this.applyFocusKey)
      relItems[i].focus = true;
  }
  this._ApplyItemSVGSelectEffect(relItems, itemObject.isSelected);
  this._ApplyNoSelections();
  this._ZtChart.StdChart._ApplyLegendNoSelections();
}
StdChart.prototype._ApplyNoSelections = function () {
  if (!this._ZtChart.enableClickEffect)
    return;
  var myItems = this.GetSelectedItems();
  if (myItems.length == 0) {
    myItems = this._GetItems();
    this._ApplyItemSVGSelectEffect(myItems, true);
  }
  else {
    this._ApplyItemSVGSelectEffect(myItems, true);
    var nmyItems = this.GetNotSelectedItems();
    this._ApplyItemSVGSelectEffect(nmyItems, false);
  }
}
StdChart.prototype._ApplyLegendNoSelections = function (stop) {
  if (!this._ZtChart.enableLegendEffect)
    return;
  var mRefChart = this._ZtChart.StdChart;
  var myItems = mRefChart.GetSelectedItems();
  var lgitems = mRefChart.svg.selectAll(".legendItem")._groups[0];
  var sl = [], nl = [];
  for (var i = 0; i < lgitems.length; i++) {
    var lg = lgitems[i];
    var found = false;
    for (var j = 0; !found && j < myItems.length; j++) {
      var mi = myItems[j];
      if (mi.idx == parseInt(lg.getAttribute("data-index"))) {
        found = true;
      }
    }
    if (found)
      sl.push({ itm: lg, type: "legend" });
    else
      nl.push({ itm: lg, type: "legend" });
  }
  if (sl.length > 0) {
    this._ApplyItemSVGSelectEffect(sl, true);
    this._ApplyItemSVGSelectEffect(nl, false);
  }
  else {
    this._ApplyItemSVGSelectEffect(nl, true);
  }

  if (!stop)
    this._ApplyOtherLegendsSelection();
}
StdChart.prototype._ApplyRangeLegendNoSelections = function (stop) {
  if (!this._ZtChart.enableLegendEffect)
    return;
  var elemItems = this._ZtChart.StdChart.GetSelectedItems(),
    legendItems = this._ZtChart.StdChart.svg.selectAll(".legendItemrange")._groups[0],
    item,
    sl = [],
    nl = [],
    lg,
    found;
  for (var i = 0; i < legendItems.length; i++) {
    lg = legendItems[i];
    found = false;
    for (var j = 0; !found && j < elemItems.length; j++) {
      item = elemItems[j];
      if (item.rangeIdx == lg.getAttribute("data-index"))
        found = true;
    }

    if (found)
      sl.push({ itm: lg });
    else
      nl.push({ itm: lg });
  }

  if (sl.length > 0) {
    this._ApplyItemSVGSelectEffect(sl, true);
    this._ApplyItemSVGSelectEffect(nl, false);
  }
  else
    this._ApplyItemSVGSelectEffect(nl, true);

  if (!stop)
    this._ApplyOtherLegendsSelection(true);
}
StdChart.prototype._ApplyOtherLegendsSelection = function (fromRange) {
  if (fromRange)  // check su legenda delle serie
    this._ApplyLegendNoSelections(true);
  else
    this._ApplyRangeLegendNoSelections(true);
}
StdChart.prototype._DrawRangeBandsHorizontalAxis = function () {
  var bands = this.defSettings.range.bands,
    _this = this,
    group = this.svg.select("#" + this.chartId + "rangeBands"),
    prof = 10,
    scaleKey;

  if (d3.select("#" + this.chartId + "valueAxisGroup").node())  // considero primo asse disegnato
    scaleKey = d3.select(d3.select("#" + this.chartId + "valueAxisGroup").node().firstChild).attr("data-scale");

  // costante - x ora
  if (this.defSettings.range.gradient == "multi") {
    group.append("rect")
      .attr("class", "rangeband")
      .attr("x", 0)
      .attr("width", this.chartWidth)
      .attr("y", 0)
      .attr("height", this.is3D ? this.chartHeight - prof : this.chartHeight)
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")")
      .style("fill", function (/*d*/) {
        var cls = getListFromObjectArray(bands, "color"),
          gradID = _this.chartId + "multi_range";
        _this.CreateGradientFromColors(cls, gradID);
        return "url(#" + gradID + ")";
      });
  }
  else {
    group.selectAll(".rangeband")
      .data(bands)
      .enter()
      .append("rect")
      .attr("class", "rangeband")
      .attr("x", function (d) {
        return _this.scaleY[scaleKey](d.minValue);
      })
      .attr("width", function (d) {
        return Math.abs(_this.scaleY[scaleKey](d.maxValue) - _this.scaleY[scaleKey](d.minValue));
      })
      .attr("y", 0)
      .attr("height", this.is3D ? this.chartHeight - prof : this.chartHeight)
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")")
      .style("fill", function (d, idx) {
        if (_this.defSettings.range.gradient == "mono") {
          var cls = getListFromObjectArray(getColorsArrayLighter(d.color, 8).reverse(), "color"),
            gradID = _this.chartId + "mono_range_" + idx;
          _this.CreateGradientFromColors(cls, gradID);
          return "url(#" + gradID + ")";

        }
        return d.color;
      });
  }
}
StdChart.prototype._DrawRangeBandsVerticalAxis = function () {
  var bands = this.defSettings.range.bands,
    _this = this,
    group = this.svg.select("#" + this.chartId + "rangeBands"),
    prof = 10,
    scaleKey;

  if (d3.select("#" + this.chartId + "valueAxisGroup").node())  // considero primo asse disegnato
    scaleKey = d3.select(d3.select("#" + this.chartId + "valueAxisGroup").node().firstChild).attr("data-scale");

  // costante - x ora
  if (this.defSettings.range.gradient == "multi") {
    group.append("rect")
      .attr("class", "rangeband")
      .attr("x", this.is3D ? prof : 0)
      .attr("width", this.is3D ? this.chartWidth - prof : this.chartWidth)
      .attr("y", 0)
      .attr("height", this.is3D ? this.chartHeight - prof : this.chartHeight)
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")")
      .style("fill", function (/*d*/) {
        var cls = getListFromObjectArray(bands, "color"),
          gradID = _this.chartId + "multi_range";
        _this.CreateGradientFromColors(cls, gradID, true, true);
        return "url(#" + gradID + ")";
      });
  }
  else {
    group.selectAll(".rangeband")
      .data(bands)
      .enter()
      .append("rect")
      .attr("class", "rangeband")
      .attr("y", function (d) {
        if (_this.is3D)
          return _this.scaleY[scaleKey](d.maxValue) - prof;
        return _this.scaleY[scaleKey](d.maxValue);
      })
      .attr("height", function (d) {
        return Math.abs(_this.scaleY[scaleKey](d.maxValue) - _this.scaleY[scaleKey](d.minValue));
      })
      .attr("x", this.is3D ? prof : 0)
      .attr("width", this.is3D ? this.chartWidth - prof : this.chartWidth)
      .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")")
      .style("fill", function (d, idx) {
        if (_this.defSettings.range.gradient == "mono") {
          var cls = getListFromObjectArray(getColorsArrayLighter(d.color, 8).reverse(), "color").reverse(),
            gradID = _this.chartId + "mono_range_" + idx;
          _this.CreateGradientFromColors(cls, gradID, true);
          return "url(#" + gradID + ")";

        }
        return d.color;
      });
  }
}
StdChart.prototype._MapAllValues = function (anotherStd) {
  this.allValues = anotherStd.allValues;
  this.rangeminmax.min = anotherStd.rangeminmax.min;
  this.rangeminmax.max = anotherStd.rangeminmax.max;
  this.rangeminmax.precision = anotherStd.rangeminmax.precision;
  for (var i = 0; i < anotherStd.valueFields.length; i++) {
    this[anotherStd.valueFields[i] + "_values"] = anotherStd[anotherStd.valueFields[i] + "_values"];
  }
  this.scaleY = anotherStd.scaleY;
  this.scaleX = anotherStd.scaleX;
}
StdChart.prototype._MapWithAnother = function (anotherStd) {
  this.categoryList = anotherStd.categoryList.slice();
  this.seriesList = anotherStd.seriesList.slice();
  this.orgCategoryList = anotherStd.orgCategoryList.slice();
  this.orgSeriesList = anotherStd.orgSeriesList.slice();
  this.drawingCategories = anotherStd.drawingCategories.slice();
  this.drawingSeries = anotherStd.drawingSeries.slice();
  if( anotherStd.calcDataset ) { //MG VPV
    if( Array.isArray (anotherStd.calcDataset) )
      this.calcDataset = anotherStd.calcDataset.slice();
    else
      this.calcDataset = JSON.parse(JSON.stringify(anotherStd.calcDataset))
  }
  this._MapAllValues(anotherStd);
  this._MapCalculation();
}
StdChart.prototype._CheckIdentityItem = function (itemOrg, itemOth) {
  if (this.domainIsTime) {
    var serie1 = itemOrg.series;
    if (serie1.getTime)
      serie1 = serie1.getTime();
    var serie2 = itemOth.series;
    if (serie2.getTime)
      serie2 = serie2.getTime();
    var category1 = itemOrg.category;
    if (category1.getTime)
      category1 = category1.getTime();
    var category2 = itemOth.category;
    if (category2.getTime)
      category2 = category2.getTime();
    return (serie1 == serie2 && category1 == category2) || (serie1 == category2 && category1 == serie2);
  }

  return ((itemOrg.series == itemOth.series && itemOrg.category == itemOth.category) ||
    (itemOrg.series == itemOth.category && itemOrg.category == itemOth.series))
    &&
    (itemOrg.keyField == itemOth.keyField ||
      itemOrg.keyF == itemOth.keyField);
}
StdChart.prototype._CheckIdentityItemValue = function (item, value) {
  if (this.domainIsTime) {
    var serie = item.series;
    if (serie.getTime) serie = serie.getTime();
    var category = item.category;
    if (category.getTime) category = category.getTime();
    if (value.getTime) value = value.getTime();
    return serie == value || category == value;
  }
  return item.series == value || item.category == value;
}
StdChart.prototype._ApplyLegendMouseOver = function (item) {
  var index = parseInt(item.getAttribute("data-index")),
    range = CharToBool(item.getAttribute("data-range") + ""),
    text = item.getAttribute("data-text"),
    ret;
  if (range)
    ret = this._GetItemsByLegendRange(text);
  else
    ret = this._GetItemsByLegendIndex(index);
  this._ApplyItemSVGSelectEffect(ret.lItems, true);
  this._ApplyItemSVGSelectEffect(ret.nItems, false);
}
StdChart.prototype._ApplyLegendMouseOut = function (/*item*/) {
  if (!Empty(d3.select("#" + this.chartId + "generic_tooltipsGrp").node()))
    d3.select("#" + this.chartId + "generic_tooltipsGrp").node().parentNode.removeChild(d3.select("#" + this.chartId + "generic_tooltipsGrp").node());
  this._ApplyNoSelections();
}
StdChart.prototype._ApplyLegendClick = function (item) {
  var index = parseInt(item.getAttribute("data-index")),
    text = item.getAttribute("data-text"),
    inMenu = CharToBool("" + item.getAttribute("data-menu")),
    range = CharToBool(item.getAttribute("data-range") + ""),
    ret,
    mouse = !inMenu ? d3.mouse(item) : null;
  if (range)
    ret = this._GetItemsByLegendRange(text);
  else
    ret = this._GetItemsByLegendIndex(index);
  for (var i = 0; i < ret.lItems.length; i++)
    ret.lItems[i].isSelected = !ret.allSelected;

  var legendObj = {
    current: item.textContent,
    txt: text,
    idx: index,
    mouse: mouse,
    isSelected: !ret.allSelected
  };

  this._ApplyNoSelections();
  if (range)
    this._ApplyRangeLegendNoSelections();
  else
    this._ApplyLegendNoSelections();

  if (window[this.chartId + "onLegendClick"])
    window[this.chartId + "onLegendClick"](legendObj);
  else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent) {
    var on_evt = this._ZtChart.parentCtrl.dispatchEvent('onLegendClick', mouse, legendObj);
    if (!on_evt) {
      if (window[this.chartId + "LegendClick"])
        window[this.chartId + "LegendClick"](legendObj);
      else
        this._ZtChart.parentCtrl.dispatchEvent("LegendClick", mouse, legendObj);
    }
  }
}
StdChart.prototype._UpdateLegendExcludeItem = function (item) {
  var exclude = CharToBool(d3.select(item).attr("data-check") + "");
  if (exclude) {
    d3.select(item)
      .attr("data-check", false)
      .attr("data-font", this.GetUncheckIconCode())
      .text(getIconFromCode(this.GetUncheckIconCode()));
  }
  else {
    d3.select(item)
      .attr("data-check", true)
      .attr("data-font", this.GetCheckIconCode())
      .text(getIconFromCode(this.GetCheckIconCode()));
  }
}
StdChart.prototype._ApplyLegendExcludeNoItem = function (exclude, index, text, upd) {
  if (exclude == undefined)
    return;
  if (upd == undefined)
    upd = true;
  var ser = JSON.parse(this.columnOrderData.orgSeriesList),
    cat = JSON.parse(this.columnOrderData.orgCategoryList),
    update = false,
    vf,
    evf;

  // colonne
  if (ser.indexOf(text) >= 0) {
    vf = this._GetReferredExcludedList();
    evf = vf[index];

    if (exclude) {
      if (this.excludedData.series.indexOf(evf) < 0)
        this.excludedData.series.push(evf);
      this.drawingSeries.splice(this.drawingSeries.indexOf(evf), 1);
    }
    else {
      this.excludedData.series.splice(this.excludedData.series.indexOf(evf), 1);
      this.drawingSeries.splice(vf.indexOf(evf), 0, evf);
    }
    update = true;
  }
  // righe
  else if (cat.indexOf(text) >= 0) {
    vf = JSON.parse(this.rowOrderData.valueFields);
    evf = vf[index];

    if (exclude) {
      if (this.excludedData.categories.indexOf(evf) < 0)
        this.excludedData.categories.push(evf);
      this.drawingCategories.splice(this.drawingCategories.indexOf(evf), 1);
    }
    else {
      this.excludedData.categories.splice(this.excludedData.categories.indexOf(evf), 1);
      this.drawingCategories.splice(vf.indexOf(evf), 0, evf);
    }
    update = true;
  }
  if (update && upd)
    this.RedrawData();
}
StdChart.prototype._ApplyLegendExclude = function (item, upd) {
  var exclude = CharToBool(d3.select(item).attr("data-check") + ""),
    index = parseInt(d3.select(item).attr("data-index")),
    text = d3.select(item).attr("data-text");
  this._UpdateLegendExcludeItem(item);
  this._ApplyLegendExcludeNoItem(exclude, index, text, upd);

  var filterObj = {
    //current: item.textContent,
    txt: text,
    idx: index,
    excluded: exclude
  };

  if (window[this.chartId + "onExclusionFilter"])
    window[this.chartId + "onExclusionFilter"](filterObj);
  else if (this._ZtChart.parentCtrl && this._ZtChart.parentCtrl.dispatchEvent) {
    var on_evt = this._ZtChart.parentCtrl.dispatchEvent('onExclusionFilter', null, filterObj);
    if (!on_evt) {
      if (window[this.chartId + "ExclusionFilter"])
        window[this.chartId + "ExclusionFilter"](filterObj);
      else
        this._ZtChart.parentCtrl.dispatchEvent("ExclusionFilter", null, filterObj);
    }
  }
}
StdChart.prototype._GetItemsByLegendIndex = function (index) {
  var ret = {};
  ret.lItems = [];
  ret.nItems = [];
  ret.allSelected = true;
  var itms = this._GetItems();
  for (var i = 0; i < itms.length; i++) {
    if (index == itms[i].idx) {
      ret.lItems.push(itms[i]);
      ret.allSelected = ret.allSelected && itms[i].isSelected;
    }
    else {
      ret.nItems.push(itms[i]);
    }
  }
  return ret;
}
StdChart.prototype._GetItemsByLegendRange = function (text) {
  var ret = {};
  ret.lItems = [];
  ret.nItems = [];
  ret.allSelected = true;
  var itms = this._GetItems();
  for (var i = 0; i < itms.length; i++) {
    if (text == itms[i].range) {
      ret.lItems.push(itms[i]);
      ret.allSelected = ret.allSelected && itms[i].isSelected;
    }
    else {
      ret.nItems.push(itms[i]);
    }
  }
  return ret;
}
StdChart.prototype._GetAnimatedDivisor = function () {
  var div = this.valueFields/*legendList*/.length;
  if (div == 0)
    div = 1;
  return div;
}
StdChart.prototype._SetInitialDataOrder = function () {
  if (Empty(this.objConfig.dataOrder))
    this.dataOrder = this._GetDefaultDataOrder();
  else
    this.dataOrder = this.objConfig.dataOrder;
}
StdChart.prototype._GetDefaultDataOrder = function () {
  return "column";
}
StdChart.prototype._SetInReferredList = function () { }
StdChart.prototype._DrawPatterns = function () {
  if (this.hasNegativeValues)
    this.DrawNegativePattern();
}
StdChart.prototype._ApplyPatterns = function () {
  var items, i;
  if (this.hasNegativeValues) {
    items = this._GetItems().filter(function (item) { return item.value < 0; });
    for (i = 0; i < items.length; i++)
      this.ApplyPatternOnItem(items[i], "negativeValuePattern");
  }

  if (this.aggregateData) {
    var _this = this,
      color;
    items = this._GetItems().filter(function (item) { return _this._CheckIdentityItemValue(item, _this.aggregateData.label); });
    for (i = 0; i < items.length; i++) {
      color = items[i].color.color;
      //this.DrawAggregatePattern(color);
      this.ApplyPatternOnItem(items[i], "aggregateDataPattern_" + color.slice(1));
    }
  }
}
StdChart.prototype._ResetLists = function () {
  if (!Empty(this.objConfig.keyField)) {
    this.categoryList = getDuplicatesList(this.xLabelIndex, this.dataSet).array;
    this.orgCategoryList = getList(this.xIndex, this.dataSet);
  }
  else {
    this.categoryList = getList(this.xIndex, this.dataSet);
    this.orgCategoryList = this.categoryList.slice();
  }

  this.rowLegendList = this.orgCategoryList.slice();

  this.allValues = getValues(this.valueFields, this.propertyName, this.dataSet);
  this.rangeminmax.min = d3.min(this.allValues);
  this.rangeminmax.max = d3.max(this.allValues);
  this._SetTotalsObject();
}
StdChart.prototype._EvaluateRedraw = function (newData, newObjConfig) {
  this.dataSet = newData;
  if (!Empty(newObjConfig))
    this.objConfig = newObjConfig;
  var vf_org = this.objConfig.valueFields.split(","),
    vf_new = JSON.parse(this.columnOrderData.valueFields);
  if (!arrayCompare(vf_org, vf_new)) {
    this.propertyName = vf_org.slice();
    if (!Empty(this.objConfig.keyField)) {
      this.propertyName.splice(this.xLabelIndex, 0, this.objConfig.labelField);
      this.propertyName.splice(this.xIndex, 0, this.objConfig.keyField);
    }
    else
      this.propertyName.splice(this.xIndex, 0, this.objConfig.labelField);
  }

  var newCategoryList = getList(this.xIndex, this.dataSet),
    sameCategory = arrayCompare(JSON.parse(this.columnOrderData.orgCategoryList), newCategoryList),
    newSeriesList = this.objConfig.labelSeries.split(","),
    sameSeries = arrayCompare(JSON.parse(this.columnOrderData.orgSeriesList), newSeriesList);

  /* potrei avere un redraw asc-desc
  if (!sameCategory) { // le categorie potrebbero essere le stesse ma in ordine diverso
    var _categoryList = JSON.parse(this.columnOrderData.orgCategoryList),
    _newCategoryList = newCategoryList.slice();
    _categoryList.sort();
    _newCategoryList.sort();
    sameCategory = arrayCompare(_categoryList, _newCategoryList);
    if (sameCategory) { // devo riordinare il dataset
      this.dataSet = [];
      for (var i = 0; i < _categoryList.length; i++)
        this.dataSet[i] = newData[newCategoryList.indexOf(_categoryList[i])];
      newCategoryList = _categoryList;
    }
  }*/

  if (!sameSeries || !sameCategory) {
    delete this.columnOrderData;
    delete this.rowOrderData;
    this._SetLists();
    this.SetData();
  }
  else { } // sono uguali -> update con valore precedente solo con scala uguale

  this.RedrawData();
}
StdChart.prototype._ApplyRedrawAnimationEffect = function () { }
StdChart.prototype._AnimateChartElements = function () {
  this.AnimateProgressBar();
  for (var i = 0; i < this.items.length; i++) {
    var elem = this.items[i].itm;
    if (!elem)
      continue;
    this._AnimateItem(this.items[i], null, this.defSettings.animation.duration);
  }
}
StdChart.prototype._AnimateItem = function (item, lastValueObj, duration) {
  var aFnc = this._GetDefaultAnimateFunction;
  if (aFnc)
    aFnc.call(this, item, lastValueObj, duration);
}
StdChart.prototype._MapScalesFromChart = function (chart) {
  this.scaleX = chart.scaleX;
  this.scaleY = chart.scaleY;
}
StdChart.prototype._MapMarginsFromChart = function (chart) {
  this.chartWidth = chart.chartWidth;
  this.chartHeight = chart.chartHeight;
  this.margin = chart.margin;
}
StdChart.prototype._GetExportData = function (type, optReturn, stringData, withHeader) {
  var refString;
  if (optReturn.toLowerCase() == "expsel")
    refString = this._MakeExportDataString(type, this.GetSelectedItems(), withHeader);
  else
    refString = this._MakeExportDataString(type, null, withHeader);
  if (stringData)
    return refString;
  this.GetDownload(type, refString);
}
StdChart.prototype._MakeExportDataString = function (type, items, withHeader) {
  if (!type) return "";
  if (type.toLowerCase() == 'csv')
    return this._MakeExportCSV(items, withHeader);
  if (type.toLowerCase() == 'xml')
    return this._MakeExportXML(items, withHeader);
  return "";
}
StdChart.prototype._MakeExportCSV = function (items, withHeader) {
  var _this = this,
    txt = "",
    tmp = "",
    separator = this.localeLangFormat.csvSeparator,
    newLineWin = "\n",
    pval = "category",
    i;

  if (withHeader === undefined)
    withHeader = true;
  if (withHeader) {
    if (this.keyField.domain) {
      pval = "keyF";
      tmp = "Category key";
      txt += convertCsv(tmp, separator) + separator;
    }
    if (this._GetDefaultDataOrder() == "column")
      tmp = this.defSettings.chartLegend.text;
    else if (this.defSettings.axisLabel)
      tmp = this.defSettings.axisLabel.xLabel;
    if (Empty(tmp))
      tmp = "Category";
    txt += convertCsv(tmp, separator) + separator;

    for (i = 0; i < this.valueFields.length; i++) {
      //var str = this.valueFields[i];
      tmp = "" + _this.seriesList[i];
      txt += convertCsv(tmp, separator) + separator;
    }
    if (this.appliedKey)
      txt += convertCsv("MultidimKey", separator) + separator;
    txt += newLineWin;
  }
  var row, index, j;
  if (!items || items == null) { // all
    for (i = 0; i < this.dataSet.length; i++) {
      if (i > 0)
        txt += newLineWin;
      row = this.dataSet[i];
      tmp = "" + row[this.xIndex];
      txt += convertCsv(tmp, separator) + separator;
      if (this.keyField.domain) {
        tmp = "" + row[this.xLabelIndex];
        txt += convertCsv(tmp, separator) + separator;
      }
      for (j = 0; j < this.valueFields.length; j++) {
        index = this.propertyName.indexOf(this.valueFields[j]);
        if (row[index])
          tmp = "" + Strtran(row[index] + "", ".", this.localeLangFormat.formatLocale.decimal);
        else
          tmp = "";
        txt += convertCsv(tmp, separator) + separator;
      }
      if (this.appliedKey) {
        txt += convertCsv(this.appliedKey, separator) + separator;
      }
    }
  }
  else {
    var vwrite = false;
    for (i = 0; i < this.dataSet.length; i++) {
      row = this.dataSet[i];
      for (var k = 0; k < items.length; k++) {
        if (row[this.xIndex] != items[k][pval])
          continue;
        if (vwrite)
          txt += newLineWin;
        tmp = "" + row[this.xIndex];
        txt += convertCsv(tmp, separator) + separator;
        if (this.keyField.domain) {
          tmp = "" + row[this.xLabelIndex];
          txt += convertCsv(tmp, separator) + separator;
        }
        for (j = 0; j < this.valueFields.length; j++) {
          index = this.propertyName.indexOf(this.valueFields[j]);
          if (row[index])
            tmp = "" + Strtran(row[index] + "", ".", this.localeLangFormat.formatLocale.decimal);
          else
            tmp = "";
          txt += convertCsv(tmp, separator) + separator;
        }
        vwrite = true;
        k = items.length;
      }
    }
  }
  return txt;
}
StdChart.prototype._MakeExportXML = function (items, withHeader) {
  var tagDataOpen = "<DATASET";
  var tagDataClosed = "</DATASET>";
  var tagRowOpen = "<RECORD>";
  var tagRowClosed = "</RECORD>";
  var newLineWin = "\n";
  var txt = "";
  if (withHeader === undefined)
    withHeader = true;
  if (withHeader) {
    txt += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + newLineWin;
    txt += "<CHARTEXPORT>" + newLineWin;
  }
  var pval = "category";
  var tagCat = "";
  if (this.keyField.domain) {
    pval = "keyF";
  }
  if (this._GetDefaultDataOrder() == "column")
    tagCat = this.defSettings.chartLegend.text;
  else if (this.defSettings.axisLabel)
    tagCat = this.defSettings.axisLabel.xLabel;

  if (Empty(tagCat))
    tagCat = "CATEGORY";

  var mutidimkey = "";
  if (this.appliedKey) {
    mutidimkey = " MULTIDIMKEY='" + this.appliedKey + "'"
  }
  txt += tagDataOpen + mutidimkey + ">" + newLineWin;
  var row, index, i, j;
  if (!items || items == null) { // all
    for (i = 0; i < this.dataSet.length; i++) {
      txt += tagRowOpen + newLineWin;
      row = this.dataSet[i];
      if (this.keyField.domain) {
        txt += convertXml("CATEGORY_KEY", row[this.xIndex]) + newLineWin;
        txt += convertXml(tagCat, row[this.xLabelIndex]) + newLineWin;
      }
      else
        txt += convertXml(tagCat, row[this.xIndex]) + newLineWin;
      for (j = 0; j < this.valueFields.length; j++) {
        index = this.propertyName.indexOf(this.valueFields[j]);
        if (row[index])
          txt += convertXml(this.seriesList[j], Strtran(row[index] + "", ".", this.localeLangFormat.formatLocale.decimal)) + newLineWin;
        else
          txt += convertXml(this.seriesList[j], "") + newLineWin;
      }
      txt += tagRowClosed + newLineWin;
    }
    txt += tagDataClosed;
  }
  else {
    for (i = 0; i < this.dataSet.length; i++) {
      for (var k = 0; k < items.length; k++) {
        row = this.dataSet[i];
        if (row[this.xIndex] != items[k][pval])
          continue;
        txt += tagRowOpen + newLineWin;
        if (this.keyField.domain) {
          txt += convertXml("CATEGORY_KEY", row[this.xIndex]) + newLineWin;
          txt += convertXml(tagCat, row[this.xLabelIndex]) + newLineWin;
        }
        else
          txt += convertXml(tagCat, row[this.xIndex]) + newLineWin;
        for (j = 0; j < this.valueFields.length; j++) {
          index = this.propertyName.indexOf(this.valueFields[j]);
          if (row[index])
            txt += convertXml(this.seriesList[j], Strtran(row[index] + "", ".", this.localeLangFormat.formatLocale.decimal)) + newLineWin;
          else
            txt += convertXml(this.seriesList[j], "") + newLineWin;
        }
        txt += tagRowClosed + newLineWin;
        k = items.length;
      }
    }
    txt += tagDataClosed;
  }
  if (withHeader)
    txt += newLineWin + "</CHARTEXPORT>"
  return txt;
}
StdChart.prototype._CheckEmptyValues = function () {
  if (this.categoryList.length > this.dataSet.length) {
    var _this = this,
      dMap = this.dataSet.map(function (rec) { return rec[_this.xIndex]; }),
      dCat = this.orgCategoryList.filter(function (cat) { return dMap.indexOf(cat) < 0; }),
      record,
      cIdx;
    for (var i = 0; i < dCat.length; i++) {
      cIdx = this.orgCategoryList.indexOf(dCat[i]);
      record = [];
      for (var j = 0; j < this.dataSet[0].length; j++)
        record.push(null);
      if (this.xLabelIndex)
        record[this.xLabelIndex] = this.categoryList[cIdx];
      record[this.xIndex] = dCat[i];
      this.dataSet.push(record);
    }
  }
}
StdChart.prototype._HasAggregateData = function () {
  return !Empty(this.aggregateData);
}
StdChart.prototype._GetAggregateData = function (vFields) {
  if (Empty(this.aggregateData))
    return [];
  var mval = vFields;
  if (!Empty(mval))
    mval = vFields.split(",");
  else
    mval = this.valueFields;

  var ret = [],
    mkey;
  for (mkey in this.aggregateData) {
    if (mval.indexOf(mkey) >= 0 && !Empty(this.aggregateData[mkey]) && !Empty(this.aggregateData[mkey].val)) {
      var mrec = this.aggregateData[mkey].val;
      for (var i = 0; i < mrec.length; i++) {
        var arec = [];
        arec.push(mkey);
        if (mrec[i].keyField)
          arec.push(mrec[i].keyField);
        else
          arec.push(null);
        arec.push(mrec[i].category);
        arec.push(mrec[i].value)
        if (mrec[i].percentage)
          arec.push(mrec[i].percentage);
        else
          arec.push(null);
        if (this.appliedKey)
          arec.push(this.appliedKey);
        else
          arec.push(null);
        ret.push(arec);
      }
    }
  }
  return ret;
}
StdChart.prototype._DrawMarkerIconOnItem = function (item) {
  if (!this.chartLegends.series)
    return;
  if (this.chartLegends.series.position == "hide" || this.chartLegends.series.hide)
    return;

  d3.select(item.itm.parentNode)
    .append("text")
    .attr("class", "ztchartfonticon markerItem")
    .attr("x", getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) - this.GetDefaultIconFont().size)
    .attr("y", getDomNodeTop(item.itm) + this.GetDefaultIconFont().size)
    .style("font-family", this.GetDefaultIconFont().name)
    .style("font-size", this.GetDefaultIconFont().size)
    .style("cursor", "default")
    .style("fill", item.color.color)
    .style("stroke", get3DColor(item.color).color)
    .style("stroke-width", 0.5)
    .text(this.GetMarkerLegendIcon());
}
StdChart.prototype._GetDrawingList = function () {
  if (this.dataOrder == "column")
    return this.drawingSeries;
  return this.drawingCategories;
}
StdChart.prototype._GetOppositeDrawingList = function () {
  if (this.dataOrder == "column")
    return this.drawingCategories;
  return this.drawingSeries;
}
StdChart.prototype._GetAxisDrawingList = function () {
  if (this.dataOrder == "row")
    return this.drawingCategories;
  var sf = JSON.parse(this.columnOrderData.orgSeriesList),
    vf = JSON.parse(this.columnOrderData.valueFields),
    ds = this.drawingSeries;
  return sf.filter(function (s, idx) { return ds.indexOf(vf[idx]) >= 0 });
}
StdChart.prototype._GetOppositeAxisDrawingList = function (excludeKey) {
  if (this.dataOrder == "column") {
    if (this.keyField.domain && this.domainIsTime)
      return this.orgCategoryList;
    if (this.keyField.domain && !excludeKey)
      return this.categoryList;
    return this.drawingCategories;
  }
  if (!this.columnOrderData)
    return [];
  var sf = JSON.parse(this.columnOrderData.orgSeriesList),
    vf = JSON.parse(this.columnOrderData.valueFields),
    ds = this.drawingSeries;
  return sf.filter(function (s, idx) { return ds.indexOf(vf[idx]) >= 0 });
}
StdChart.prototype._GetReferredList = function () {
  if (this.dataOrder == "column")
    return JSON.parse(this.columnOrderData.valueFields);
  return JSON.parse(this.rowOrderData.valueFields);
}
StdChart.prototype._GetReferredExcludedList = function () {
  //if (this.dataOrder == "column")
  return JSON.parse(this.columnOrderData.valueFields);
  //return JSON.parse(this.rowOrderData.valueFields);
}
StdChart.prototype._DrawChartPlotElements = function () { }
StdChart.prototype._IsNotExcluded = function (index) {
  if (this._ZtChart.enableExclude)
    return this._GetDrawingList().hasElement(this._GetReferredList()[index]) >= 0;
  return true;
}
StdChart.prototype._IsNotExcludedSeries = function (text) {
  if (this._ZtChart.enableExclude)
    return this._GetDrawingList().hasElement(text) >= 0;
  return true;
}
StdChart.prototype._IsNotExcludedDomain = function (text) {
  // giro column - row piu' diffuso
  if (this.dataOrder == "column")
    return this._GetOppositeDrawingList().hasElement(text) >= 0;
  var mvf = JSON.parse(this.columnOrderData.orgSeriesList).hasElement(text);
  return this._GetOppositeDrawingList().hasElement(JSON.parse(this.columnOrderData.valueFields)[mvf]) >= 0;
}
StdChart.prototype._DrawZoomCursor = function (container, offsetObj, StdChart) {
  StdChart = StdChart || this._ZtChart.StdChart;
  if (!(this.asZoomCursor || (StdChart.IsMultiDim() && StdChart.asZoomCursor)))
    return;
  this.drawCursor = true;
  container = container || d3.select("#" + this.chartId + "divchartcontainer").node();
  if (Empty(container))
    return;
  var _this = this;

  var width = _this.chartWidth,
    height = _this.chartHeight,
    left = _this.margin.left;

  if (offsetObj) {
    left += offsetObj.x;
    top += offsetObj.y;
  }

  this.filterStart = null, this.filterEnd = null;
  this.leftHandle = false; this.rightHandle = false;
  _this.refWidth = width - 1;
  _this.filterStart = 0, _this.filterEnd = _this.refWidth;
  _this.leftHandle = false; _this.rightHandle = false;

  /** DISEGNO DIV E SVG **/
  if (!Empty(d3.select("#" + _this.chartId + "cursorDiv").node()))
    d3.select("#" + _this.chartId + "cursorDiv").remove();

  var zoomDiv = d3.select(container)
    .append("div")
    .attr("id", _this.chartId + "cursorDiv")
    .style("position", "relative")
    .style("top", - (height + _this.margin.bottom) + "px")
    .style("left", left + "px")
    .style("width", width + "px")
    .style("height", height + "px");

  if (this.domainIsTime)
    this.scaleCursor = d3.scaleTime().domain(this.scaleX.domain());
  else {
    this.scaleCursor = d3.scaleLinear();
    if (this.domainIsNumber)
      this.scaleCursor.domain(this.scaleX.domain());
    else
      this.scaleCursor.domain([0, this.scaleX.domain().length - 1]);
  }
  this.scaleCursor.range([0, width])/*.clamp(true);*/

  var zbrush = d3.brushX()
    .extent([[0, 0], [width, height]])
    .handleSize(10)
    .on("brush start", function () {
      if (Empty(d3.event.sourceEvent))
        return;
      var selection = d3.event.selection;
      _this.filterStart = selection[0];
      _this.filterEnd = selection[1];
      _this.ZoomDispatchEvent(d3.event, "onmousedown");
    })
    .on("brush end", function () {
      if (Empty(d3.event.sourceEvent))
        return;
      var selection = d3.event.selection;
      _this.filterStart = selection[0];
      _this.filterEnd = selection[1];
      _this.ZoomDispatchEvent(d3.event, "onmouseup");

    })
    .on("brush", function () {
      if (Empty(d3.event.sourceEvent))
        return;
      var selection = d3.event.selection;
      _this.filterStart = selection[0];
      _this.filterEnd = selection[1];
      _this.ZoomDispatchEvent(d3.event, "onmousemove");
    });

  zoomDiv
    .append("svg")
    .attr("id", _this.chartId + "filterbrushSVG")
    .attr("width", width)
    .attr("height", height)
    .append("g")
    .attr("class", "brush")
    .call(zbrush)
    .call(zbrush.move, this.scaleCursor.range());

  d3.select("#" + _this.chartId + "filterbrushSVG").select("g").selectAll(".selection")
    .attr("fill", "#1E88E5")
    .attr("fill-opacity", "0.2")
    .attr("stroke", "none");

  this.zoomCursorBrush = {};
  this.zoomCursorBrush.area = d3.select("#" + this.chartId + "filterbrushSVG").select(".brush");
  this.zoomCursorBrush.brush = zbrush;
}
StdChart.prototype._SetCursorDrawingList = function (start, end) {
  var dc = [];
  for (var i = 0; i < this.orgCategoryList.length; i++) {
    if (this.orgCategoryList[i] >= start && this.orgCategoryList[i] <= end)
      dc.push(this.orgCategoryList[i]);
  }
  this.drawingCategories = dc.slice();
}
StdChart.prototype._UpdateDrawingList = function () {
  if (this.asZoomCursor && this.objConfig.zoomFilter.show == 'chartzoom') {
    if (this._ZtChart.ZFObjConfig.valueFields.length == 0) {
      this.drawingSeries = [this.drawingSeries[0]];
    }
    else {
      this.drawingSeries = this._ZtChart.ZFObjConfig.valueFields;
    }
  }
  else if (this.excludedList) {
    var exl = this.excludedList.split(",");
    for (var i = 0; i < exl.length; i++) {
      var idx = this.drawingCategories.indexOf(exl[i]);
      if (idx >= 0) {
        this.drawingCategories.splice(idx, 1);
        if (this.excludedData.categories.indexOf(exl[i]) < 0)
          this.excludedData.categories.push(exl[i]);
      }
      idx = this.drawingSeries.indexOf(exl[i]);
      if (idx >= 0) {
        this.drawingSeries.splice(idx, 1);
        if (this.excludedData.series.indexOf(exl[i]) < 0)
          this.excludedData.series.push(exl[i]);
      }
    }
  }
  delete this.excludedList;
}
StdChart.prototype._OverwriteDefProperties = function () { }
StdChart.prototype._SupportFilter = function () {
  if (this.domainIsNumber || this.domainIsTime)
    return false;
  return true;
}
StdChart.prototype._CalculateOffsetAxis = function () {
  return false;
}
StdChart.prototype._GetDomainInScale = function (record, index) {
  if (this.domainIsNumber || this.domainIsTime)
    return this.scaleX(record[index]);
  return this.scaleX(record[index]) + this.scaleX.bandwidth() / 2;
}
StdChart.prototype._SetValueAxisPositions = function () {
  if (!this.scaleY)
    return;
  var scs = Object.keys(this.scaleY),
    progrX = this._GetValueAxisXPosition(),
    mwidth = 0,
    maxis,
    offset = 10,
    sID;
  for (var i = 0; i < scs.length; i++) {
    sID = replaceSpecialCharsForID(scs[i]);
    maxis = d3.select("#" + this.chartId + "valueAxisGroup_" + sID).node();
    if (maxis) {
      mwidth = getDomNodeWidth(maxis) + offset;
      if (i > 0)
        d3.select(maxis).attr("transform", "translate(" + [progrX, this._GetValueAxisYPosition()] + ")");
      progrX = progrX - mwidth;
    }
  }
}
StdChart.prototype._EvaluateAllValuesCalc = function () {
  for (var i = 0; i < this.valueFields.length; i++) {
    this[this.valueFields[i] + "_values"] = getValues([this.valueFields[i]], this.propertyName, this.calcDataset);
  }
}
StdChart.prototype._SetDifferenceInItem = function (/*item, index*/) { }
StdChart.prototype._EvaluateDatasetAndCalculation = function () { }
StdChart.prototype._IsNotExcludedDomainShapes = function (text) {
  return this._IsNotExcludedDomain(text);
}
StdChart.prototype._DrawHover = function () { }
StdChart.prototype._AdjustDisplayText = function () { }
StdChart.prototype._GetNotRepresentedDataMarginsObject = function () {
  var ret = {};
  ret.top = [];
  ret.bottom = [];
  ret.left = [];
  ret.right = [];

  var myM = {},
    appFont,
    mtext,
    h1 = getOffsetHeight(this.GetMoreDataIcon(), this.GetDefaultIconFont(), this.chartId),
    h2 = getOffsetHeight(this.GetNotRepresentedIcon(), this.GetDefaultIconFont(), this.chartId),
    h3 = getOffsetHeight("W", this.defSettings.globalFont, this.chartId);

  if ((h1 > h2 && h1 > h3) || (h2 > h1 && h2 > h3)) {
    appFont = this.GetDefaultIconFont();
    mtext = this.GetNotRepresentedIcon();
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

  return ret;
}
StdChart.prototype._GetValueLabelX = function (pos, item/*, text, font*/) {
  var offset = 5;
  switch (pos) {
    case "otop":
    case "obottom":
    case "itop":
    case "ibottom":
    case "in":
      return getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) / 2;
      break;
    case "oleft":
      return getDomNodeLeft(item.itm) - offset;
      break;
    case "oright":
      return getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) + offset;
      break;
    case "ileft":
      return getDomNodeLeft(item.itm) + offset;
      break;
    case "iright":
      return getDomNodeLeft(item.itm) + getDomNodeWidth(item.itm) - offset;
      break;
  }
}
StdChart.prototype._GetValueLabelY = function (pos, item, text, font) {
  var offset = 5;
  switch (pos) {
    case "otop":
      var mY = getDomNodeTop(item.itm) - offset,
        mH = getOffsetHeight(text, font, this.chartId) + (offset / 2);
      if (mY < mH && this.defSettings.valueLabel.show == "default")
        mY = mH;
      return mY;
      break;
    case "obottom":
      return getDomNodeTop(item.itm) + getDomNodeHeight(item.itm) + getOffsetHeight(text, font, this.chartId);
      break;
    case "in":
    case "oleft":
    case "oright":
    case "ileft":
    case "iright":
      return getDomNodeTop(item.itm) + getDomNodeHeight(item.itm) / 2 + getOffsetHeight(text, font, this.chartId) / 4;
      break;
    case "itop":
      return getDomNodeTop(item.itm) + getOffsetHeight(text, font, this.chartId);
      break;
    case "ibottom":
      return getDomNodeTop(item.itm) + getDomNodeHeight(item.itm);
      break;
  }
}
StdChart.prototype._DrawValueLabels = function () {
  var group = this.renderer.append("g")
    .attr("id", this.chartId + "valueLabels")
    .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")"),
    items = this._GetItems(),
    item;
  for (var i = 0; i < items.length; i++) {
    item = items[i];
    var text = this.GetValueLabelText(this.defSettings.valueLabel.type, item, this._GetValueLabelValueProp()),
      pos = this.defSettings.valueLabel.position,
      font = appliedFont(this.defSettings, this.defSettings.valueLabel, this.defSettings.valueLabel.labelFont),
      label = group.append("text")
        .attr("x", this._GetValueLabelX(pos, item, text, font))
        .attr("y", this._GetValueLabelY(pos, item, text, font))
        .style("text-anchor", function () {
          switch (pos) {
            case "otop":
            case "obottom":
            case "in":
              return "middle";
              break;
            case "oleft":
              return "end";
              break;
            case "oright":
              return "start";
              break;
          }
        })
        .text(text);
    setFont(label, font, this);
  }
}
StdChart.prototype._EvaluatePrintValueLabel = function (type, item) {
  var ev = true;
  switch (type) {
    case "label":
      ev = item.idx == 0;
      break;
    case "ser":
      ev = item.sidx == 0;
      break;
    case "value":

      break;
    case "perc":

      break;
    case "dperc":

      break;
    case "labelvalue":

      break;
    case "servalue":

      break;
    case "serlabel":

      break;
    case "labelperc":

      break;
    case "dlabelperc":

      break;
    case "valueperc":

      break;
    case "dvalueperc":

      break;
    case "serperc":

      break;
    case "dserperc":

      break;
    case "totperc":
      break;
    default:
      ev = true;
      break;
  }
  return ev;
}
StdChart.prototype._GetValueLabelValueProp = function () {
  return "value";
}
StdChart.prototype._DrawTotalValueLabel = function () { }
StdChart.prototype._SetItems = function (chart) {
  this.items = chart.items.slice();
}
StdChart.prototype._MapCalculation = function () { }
StdChart.prototype._GetMaxDomainAxisWordObject = function () {
  var mlist = this._GetOppositeAxisDrawingList(),
    maxWordO;

  if (this.domainIsTime) {
    if (Empty(this.defSettings.time.customFormat) && !Empty(this.defSettings.time.format)) {
      maxWordO = getMaxWordLengthForWrap([this.defSettings.time.format], null, format);
    }
    else if (!Empty(this.defSettings.time.customFormat) && Empty(this.defSettings.time.format)) {
      var format = getTimeTickFormat(this.localeLangFormat, this.defSettings.time.customFormat);
      maxWordO = getMaxWordLengthForWrap(mlist, null, format);
    }
    else {
      var tts = Array.prototype.slice.call(this.svg.select("#" + this.chartId + "domainAxisGroup").selectAll(".tick text")._groups[0]);
      mlist = tts.map(function (t) { return t.textContent; });
      maxWordO = getMaxWordLengthForWrap(mlist);
    }
  }
  else
    maxWordO = getMaxWordLengthForWrap(mlist);

  return maxWordO;
}
StdChart.prototype._EvaluateWrapSpace = function (textNode, ctick_i, maxWordObj) {
  var bandwidth = 0,
    appFont = appliedFont(this.defSettings, this.defSettings.domainAxis, this.defSettings.domainAxis.domainFont);
  if (this.defSettings.domainAxis.labelType != "H")
    bandwidth = getOffsetWidth(maxWordObj.word, appFont, this.chartId);
  else {
    if (this.scaleX.bandwidth && this.scaleX.bandwidth() != 0)
      bandwidth = this.scaleX.bandwidth();
    else {
      var ctick = textNode.parentNode.transform.baseVal.getItem(0).matrix.e,
        ntick,
        ptick,
        daxis = this.svg.select("#" + this.chartId + "domainAxisGroup").node();

      // valuto precedente
      if (ctick_i == 1) {
        if (ctick == 0)
          ptick = this.margin.left;
        else
          ptick = ctick;
        ptick = ptick / 2;
      }
      else if (ctick_i <= (daxis.childNodes.length - 1)) {
        ptick = ctick - daxis.childNodes[ctick_i - 1].transform.baseVal.getItem(0).matrix.e;
        if (Empty(daxis.childNodes[ctick_i - 1].textContent))
          ptick = 3 * ptick / 2;
        else
          ptick = ptick / 2;
      }

      // successivo
      if (ctick_i < (daxis.childNodes.length - 1))
        ntick = daxis.childNodes[ctick_i + 1].transform.baseVal.getItem(0).matrix.e - ctick;
      else {
        if (ctick == this.scaleX.range()[1])
          ntick = this.margin.right;
        else
          ntick = this.scaleX.range()[1] - ctick;
      }
      ntick = ntick / 2;
      bandwidth = ptick + ntick;
    }
  }

  if (this._GetDomainAxisPosition() == "left")
    bandwidth = bandwidth * 2;

  return bandwidth;
}
StdChart.prototype._MapSVGToCharts = function () { }
StdChart.prototype._MakeItemFromRS = function (rs, fieldsArray) {
  var ret = [], i, it;
  if (fieldsArray) {
    /*if(fieldsArray.indexOf(this.objConfig.labelField) < 0)
      fieldsArray.push(this.objConfig.labelField);*/
    if (rs[this.objConfig.labelField]) {
      for (i = 0; i < fieldsArray.length; i++) {
        if (fieldsArray[i] == this.objConfig.labelField)
          continue;
        if (rs[fieldsArray[i]] && this.objConfig.valueFields.indexOf(fieldsArray[i]) > -1) {
          it = {};
          it.category = rs[this.objConfig.labelField];
          if (this.seriesIsTime)
            it.series = this.stdFormat(this.seriesList[this.objConfig.valueFields.indexOf(fieldsArray[i])]);
          else
            it.series = this.seriesList[this.objConfig.valueFields.indexOf(fieldsArray[i])];
          ret.push(it);
        }
      }
    }
  }
  else {
    if (rs[this.objConfig.labelField]) {
      for (i = 0; i < this.seriesList.length; i++) {
        it = {};
        it.category = rs[this.objConfig.labelField];
        if (this.seriesIsTime)
          it.series = this.stdFormat(this.seriesList[i]);
        else
          it.series = this.seriesList[i];
        ret.push(it);
      }
    }
  }
  return ret;
}
StdChart.prototype._ExecScale = function () { }
StdChart.prototype._GetBarWidthFromDomainEvaluation = function () { }
StdChart.prototype._HasShapes = function () {
  return false;
}
StdChart.prototype._EvaluateAutomaticScales = function () {
  if (this.chartConfig.graphSettings.multiDimensional && this.chartConfig.graphSettings.multiDimensional.multiDim)
    return;
  if (Empty(this.objConfig.labelSeries))
    return;
  if (this.objConfig.manualScale)
    return;
  if (!this.objConfig.mapSeries)
    this.objConfig.mapSeries = {};
  // precarico eventuale valutazione scala automatica
  var map = {},
    maxs = [],
    mser = this.objConfig.valueFields.split(",");
  for (var i = 0; i < mser.length; i++) {
    var idx = this.propertyName.indexOf(mser[i]);
    if (Empty(mser[i]) || idx < 0)
      continue;
    var values = getList(idx, this.dataSet);
    map[mser[i]] = { max: d3.max(values), auto: false };
    maxs.push(map[mser[i]].max);
    if (i > 0) {
      var mo1,
        mo2 = getMagnitudeOrder(maxs[i]),
        auto = true;
      for (var j = 0; auto && j < maxs.length; j++) {
        if (i == j)
          continue;
        mo1 = getMagnitudeOrder(maxs[j]);
        if (Math.abs(mo1 - mo2) < 2) {
          auto = false;
        }
      }
      map[mser[i]].auto = auto;
    }

    if (!(mser[i] in this.objConfig.mapSeries)) {
      this.objConfig.mapSeries[mser[i]] = {};
      this.objConfig.mapSeries[mser[i]].type = "default";
      this.objConfig.mapSeries[mser[i]].ownerScale = map[mser[i]].auto;
    }
    else if (!this.objConfig.mapSeries[mser[i]].ownerScale) // potrebbe averla, se invece e' true lascio cosi'
      this.objConfig.mapSeries[mser[i]].ownerScale = map[mser[i]].auto;
  }
}
StdChart.prototype._GetItemIndex = function (item) {
  return item.idx;
}
StdChart.prototype._GetItemSeriesIndex = function (item) {
  return item.sidx;
}
StdChart.prototype._RemapScale = function (scaleY, scaleYref, tickUnit, remap, identityCheck) {
  if (remap == null || remap == undefined)
    remap = true;

  var minpos = 0,
    maxpos = 1;
  if (scaleY.domain()[0] > scaleY.domain()[1]) {
    minpos = 1;
    maxpos = 0;
  }

  var mmax = scaleY.domain()[maxpos],
    mmin = scaleY.domain()[minpos],
    min,
    max,
    v;
  if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue)) {
    remap = false;
    if (scaleYref) {
      min = parseFloat(this.defSettings.valueAxis.minValue);
      v = scaleYref(min);
      mmin = scaleY.invert(v);
    }
  }

  if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue)) {
    remap = false;
    if (scaleYref) {
      max = parseFloat(this.defSettings.valueAxis.maxValue);
      v = scaleYref(max);
      mmax = scaleY.invert(v);
    }
  }

  if (remap) {
    if (identityCheck) {
      var dmin = mmin / tickUnit,
        dmax = mmax / tickUnit;
      if (dmin > 1)
        mmin = Math.floor(dmin) * tickUnit;
      else
        mmin = mmin * (tickUnit / 2);

      if (dmax > 1)
        mmax = Math.round(dmax) * tickUnit;
      else
        mmax = mmax * (tickUnit / 2);
    }
    else {
      if (mmin < 0) {
        // se il mio valore minimo non e' inferiore a 0, non faccio il remap
        if (d3.min(this.allValues) <= 0) {
          // se e' minore di 0, cerco di capire se arrotondare per tutta l'unita' oppure fino alla sua meta'
          var absMin = Math.abs(mmin),
            tround = Math.trunc(absMin / tickUnit) * tickUnit,
            delta = Math.abs(tround - absMin);
          if (delta > (tickUnit / 2))
            mmin = Math.floor(mmin / tickUnit) * tickUnit;
          else
            mmin = - (tround + (tickUnit / 2));
        }
        else
          // arrotondo alla decina piu' grande - caso offset shape
          mmin = Math.round(mmin / 10) * 10;
      }
      else
        mmin = Math.floor(mmin / tickUnit) * tickUnit;
    }
  }

  // usata solo nei contatori - imposta il minimo sull'asse y a prescindere da qualunque calcolo
  if (this.defSettings.valueAxis.applyMinValue &&
    (!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue)
  )
    mmin = this.defSettings.valueAxis.minValue;

  var d = [];
  d[minpos] = mmin;
  d[maxpos] = mmax;
  scaleY.domain(d);

  return { min: mmin, max: mmax };
}
StdChart.prototype._AdjustMaskAndRendererPositioning = function () {
  d3.select("#" + this.chartId + "mask")
    .attr("width", this.chartWidth)
    .attr("height", this.chartHeight)
    .select("rect")
    .attr("x", this.margin.left)
    .attr("width", this.chartWidth + 1)
    .attr("height", this.chartHeight + 1);

  d3.select("#" + this.chartId + "d3Renderer").remove();
  this._fontsChecked = false;
  this.CreateRenderer(this.svg, this.chartId, this.chartWidth, this.chartHeight, this.margin.left, this.margin.top);
  if (this.is3D)
    this.DrawRenderer3D(this.renderer);
  this._MapSVGToCharts(this.svg, this.renderer);
}
StdChart.prototype._EnableNullValues = function () {
  return false;
}
StdChart.prototype._EvaluateTimeContinuity = function (data, index, xIndex, yIndex) {
  if (this.domainIsTime && index > 0 && this.defSettings.time.dataType != "default") {
    var step = this.defSettings.time.holesStep || this.tickTime.default.unit,
      stepval = this.defSettings.time.holesStepValue || this.tickTime.default.step,
      timeObj = getD3TimeObject(step);
    // thDate = timeObj.offset(data[index - 1][xIndex], stepval)
    // return (data[index][xIndex].getTime() <= thDate.getTime());
    return (timeObj.count(data[index - 1][xIndex], data[index][xIndex]) <= stepval);
  }
  return (data[index][yIndex] != null);
}
StdChart.prototype._GetParseDrawingList = function () {
  var list = this._GetDrawingList().map(function (el) { return replaceSpecialCharsForID(el); });
  return list;
}
StdChart.prototype._GetParametersStringForTooltip = function (item, itemObject) {
  var purl = "",
    _this = this._ZtChart.StdChart,
    mcat,
    format,
    val,
    key_time = _this.domainIsTime && IsA(item.keyF, 'D');

  mcat = itemObject.category;
  if (!Empty(mcat + "")) {
    if (_this.domainIsTime && !key_time) {
      format = _this.stdFormat;
      if (!Empty(_this.defSettings.time.customFormat) || !Empty(_this.defSettings.time.format))
        format = getTimeTickFormat(_this.localeLangFormat, _this.defSettings.time.customFormat || _this.defSettings.time.format);
      mcat = format(mcat);
    }
    purl += "&category=" + URLenc(mcat);
  }

  if (!Empty(itemObject.series))
    purl += "&serie=" + URLenc(itemObject.series);

  val = parseFloat(itemObject.value);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(itemObject));
      }
    }
    else {
      val = this.GetValuePicture(val);
      if (!Empty(itemObject.progrValue + "") && !Empty(itemObject.progrValue)) {
        val = this.GetValuePicture(itemObject.realValue);
        val += " (stack " + itemObject.progrValue + ")";
        purl += "&progrvalue=" + URLenc(itemObject.progrValue);
      }
    }
    purl += "&value=" + URLenc(val);
  }

  return purl;
}
StdChart.prototype._GetLegendList = function () {
  var chart = this._ZtChart.StdChart || this;
  var valueInside = chart.defSettings.chartLegend.valueInside;
  if (Empty(valueInside) || valueInside == "default" || valueInside == "none")
    return chart.legendList;
  var sum = d3.sum(this.allValues),
    val,
    perc,
    dList = this._GetDrawingList(),
    lList = [],
    tsum = 0;
  for (var i = 0; i < dList.length; i++) {
    val = "";
    perc = "";
    if (this.totalsSeries) {
      if (this._GetDefaultDataOrder()/*this.dataOrder*/ == "column") {
        if (this.totalsSeries[dList[i]])
          val = this.totalsSeries[dList[i]].sum;
      }
      else {
        if (this.totalsSeries.categoriesT)
          val = this.totalsSeries.categoriesT[i];
      }
      perc = Math.round((val * 100) / sum);
      if ((i == dList.length - 1) && sum != (tsum + perc))
        perc = (100 - tsum);
      tsum += perc;    
      val = this.GetValuePicture(val);
      if (valueInside == "val")
        lList.push(this.legendList[i] + (": " + val));
      else if (valueInside == "perc")
        lList.push(this.legendList[i] + (": " + perc + "%"));
      else
        lList.push(this.legendList[i] + (": " + val + " (" + perc + "%)"));
    }
  }
  return lList;
}
StdChart.prototype._GetDomainIndex = function () {
  return this.propertyName.indexOf(this.objConfig.keyField || this.objConfig.labelField);
}
StdChart.prototype._SetBreadcrumbPosition = function () {
  var chart = this._ZtChart.StdChart;
  if (chart.defSettings.hierarchy && chart.defSettings.hierarchy.breadcrumb) {
    if (!chart.defSettings.hierarchy.breadcrumb.show)
      return;
  }
  else if (!chart.defSettings.hierarchy)
    return;

  var bcrumb = d3.select("#" + chart.chartId + "breadcrumb"),
    x = chart.marginOffsetX,
    y = chart.marginOffsetY,
    offset = 5,
    upd = false;

  if (!Empty(chart.chartTitle) && chart.defSettings.chartTitle.position == "top") {
    y = y + getOffsetHeight(chart.chartTitle, appliedFont(chart.defSettings, chart.defSettings.chartTitle, chart.defSettings.chartTitle.textFont), chart.chartId);
    upd = true;
  }

  if (!Empty(chart.legendList) && chart.chartLegends.series.position == "top" && !chart.chartLegends.series.hide) {
    var legend = parseFloat("0" + d3.select("#" + chart.chartId + "legend_container_rect").attr("height"));
    y = y + legend;
    if (upd) {
      y = y + offset;
      upd = false;
    }
  }
  if (upd)
    y = y + offset;

  bcrumb.attr("transform", "translate(" + [x, y] + ")");
}
StdChart.prototype._GetListForColors = function () {
  return this._GetLegendList();
}
StdChart.prototype._GetSeriesColors = function () {
  return this.colorSet;
}
StdChart.prototype._CheckOverlap = function (/*coords, vfield*/) { }
StdChart.prototype._HasOverlap = function (/*itemObject*/) {
  return false;
}
StdChart.prototype._ViewGridData = function () {
  if (!Empty(document.getElementById(this.chartId + "grid")) && this._status == "chart") {
    var order = document.getElementById(this.chartId + "grid").getAttribute("data-order");
    if (this.dataOrder != order)
      d3.select("#" + this.chartId + "grid").remove();
  }

  if (this._status == "chart")
    this.RemoveAllHovers();

  if (Empty(document.getElementById(this.chartId + "grid"))) {
    //l'innesto di div e' stato fatto in questo modo per replicare la struttura della griglia di portal studio
    var menuBar = 24,
      div1 = document.createElement("div");
    if (!this.menu.show && !this.fmenu.show)
      menuBar = 0;
    this.svg.node().style.display = "none";
    this._status = "grid";

    var div2 = document.createElement("div"),
      div_scroll = document.createElement("div"),
      th_table = document.createElement("TABLE");
    div1.id = this.chartId + "grid";
    div1.className = "grid";
    div2.className = "grid_table";
    this.parent.appendChild(div1);
    div1.appendChild(div2);

    // creo griglia titoli (grid fixed)
    th_table.style.width = "100%";
    var thead = document.createElement("thead"),
      th_row = document.createElement("tr");
    th_row.className = "grid_title grid_row_title";
    thead.appendChild(th_row);
    th_table.appendChild(thead);
    var div_th = document.createElement("div");
    div_th.style.overflow = "hidden";
    div_th.id = this.chartId + "grid_th_cont";
    div_th.appendChild(th_table);
    div2.appendChild(div_th);

    div_scroll.style.marginTop = menuBar + "px";
    div_scroll.style.overflow = "auto";
    div_scroll.setAttribute("_cid", this.chartId);
    div_scroll.onscroll = function () {
      var g_id = this.getAttribute("_cid") + "grid_th_cont";
      document.getElementById(g_id).scrollLeft = this.scrollLeft;
    }
    div2.appendChild(div_scroll);

    // creo griglia contenuto
    var grid = document.createElement("TABLE"),
      tbody1 = document.createElement("tbody");
    grid.style.width = "100%";
    grid.appendChild(tbody1);
    this._CreateGrid(th_row, tbody1);
    if (this.aggregateData && !Empty(this.__gfields)) {
      for (var mkey in this.aggregateData) {
        if (mkey != "label" && this.__gfields.indexOf(mkey) >= 0) {
          var i,
            detail = this.aggregateData[mkey].recs,
            start_row_i = this.dataSet.length - 1;
          tbody1.removeChild(tbody1.childNodes[tbody1.childNodes.length - 1]);
          for (i = 0; i < detail.length; i++) {
            var row = document.createElement("tr");
            row.style.height = "42px";
            if ((i + start_row_i) % 2 == 0) {
              row.className = "grid_rowodd";
            }
            else {
              row.className = "grid_row";
            }
            for (var b = 0; b < this.__gfields.length; b++) {
              if (this.__gfields[b] == this.objConfig.nameField) // escluso cat.code
                continue;
              var record = detail[i],
                pn_idx = this.propertyName.indexOf(this.__gfields[b]),  // potrebbe coincidere con b
                rcd_val = record[pn_idx],
                cell = document.createElement("td"),
                div3 = document.createElement("div");
              div3.textContent = this._GetGridCellValue(rcd_val, pn_idx, record);
              cell.appendChild(div3);
              row.appendChild(cell);
            }
            tbody1.appendChild(row);
          }
        }
      }
    }

    div_scroll.appendChild(grid);
    div1.setAttribute("data-order", this.dataOrder);

    div_scroll.style.height = (this.defSettings.globals.height - menuBar - th_table.offsetHeight - 2) + "px";
    var ref_tds = tbody1.rows[0].cells;
    for (i = 0; i < ref_tds.length; i++) {
      th_row.cells[i].style.width = ref_tds[i].offsetWidth + "px";
      th_row.cells[i].style.textOverflow = "ellipsis";
      th_row.cells[i].style.overflow = "hidden";
      th_row.cells[i].style.whiteSpace = "nowrap";
    }
    th_table.style.tableLayout = "fixed";
  }
  else {
    switch (this._status) {
      case "grid":
        this._status = "chart";
        document.getElementById(this.chartId + "grid").style.display = "none";
        this.svg.node().style.display = "block";
        break;
      case "chart":
        this._status = "grid";
        document.getElementById(this.chartId + "grid").style.display = "block";
        this.svg.node().style.display = "none";
        break;
    }
  }
}
StdChart.prototype._CreateGrid = function (thead, tbody1) {
  //table header
  var td, innerdiv, i,
    fields = this.propertyName.slice();
  if (!Empty(this.objConfig.fieldsGrid))
    fields = this.objConfig.fieldsGrid.slice();
  for (i = 0; i < fields.length; i++) {
    if (fields[i] == this.objConfig.nameField)
      continue;
    td = document.createElement("td");
    td.className = "grid_title grid_cell_title grid_cell_title_table";
    innerdiv = document.createElement("div");
    // testo colonne campi
    innerdiv.textContent = this._GetGridColumnName(fields[i]);
    this._SetGridColumnStyle(innerdiv, fields[i]);
    td.appendChild(innerdiv);
    thead.appendChild(td);
  }

  //table content
  this.__gfields = fields.slice();
  for (i = 0; i < this.dataSet.length; i++) {
    var record = this.dataSet[i],
      row = document.createElement("tr");
    row.style.height = "42px";
    if (i == 0 || i % 2 == 0) {
      row.className = "grid_rowodd";
    }
    else {
      row.className = "grid_row";
    }
    for (var b = 0; b < fields.length; b++) {
      if (fields[b] == this.objConfig.nameField) // escluso cat.code
        continue;
      var pn_idx = this.propertyName.indexOf(fields[b]),  // potrebbe coincidere con b
        rcd_val = record[pn_idx],
        cell = document.createElement("td"),
        div3 = document.createElement("div");
      div3.textContent = this._GetGridCellValue(rcd_val, pn_idx, record);
      this._SetGridCellStyleAndEvents(cell, div3, rcd_val, pn_idx);
      cell.appendChild(div3);
      row.appendChild(cell);
    }
    tbody1.appendChild(row);
  }
}
StdChart.prototype._GetGridColumnName = function (field) {
  var label = "", idx;
  if (field == this.objConfig.labelField || field == this.objConfig.keyField)
    label = ""; // dominio
  else {
    idx = this.valueFields.indexOf(field);
    label = this.legendList[idx];
  }

  if (!Empty(this.objConfig.labelsGrid)) {
    if (field == this.objConfig.keyField) {
      if (!Empty(this.objConfig.labelsGrid.key))
        label = this.objConfig.labelsGrid.key;
    }
    else if (field == this.objConfig.labelField) {
      if (!Empty(this.objConfig.labelsGrid.domain))
        label = this.objConfig.labelsGrid.domain;
    }
    else {
      if (!Empty(this.objConfig.labelsGrid.values)) {
        idx = this.valueFields.indexOf(field);
        var vals = this.objConfig.labelsGrid.values.split(",");
        if (!Empty(vals[idx]))
          label = vals[idx];
      }
    }
  }
  return label;
}
StdChart.prototype._SetGridColumnStyle = function (innerdiv, field) {
  if (field == this.objConfig.labelField ||
    field == this.objConfig.keyField ||
    field == this.objConfig.nameField)
    return;
  var idx = this.valueFields.indexOf(field);
  innerdiv.style.color = this.colorSet[idx].color;
}
StdChart.prototype._GetGridCellValue = function (value, dataidx, record) {
  if (this.propertyName[dataidx] == this.objConfig.labelField || this.propertyName[dataidx] == this.objConfig.keyField)
    return value;
  // apply picture + funzione
  if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
    if (this.functionObj.GetValuePicture)
      return this.functionObj.GetValuePicture(this._FindItemForGrid(record, dataidx));
  }
  else
    return this.GetValuePicture(value);
}
StdChart.prototype._SetGridCellStyleAndEvents = function (/*td, div, value, dataidx*/) {
  return;
  /*
  if (this.propertyName[dataidx] == this.objConfig.labelField)
    return;
  var _this = this;
  td.setAttribute("item-index", -1);
  td.style.cursor = "pointer";
  td.onclick = function () {
    _this._ApplyGridClick();
  }
  */
}
StdChart.prototype._ReturnStatus = function (type) {
  return this._status == type;
}
StdChart.prototype._MakeNotRepresentedDataRow = function (cols, record, v_fld, l_fld) {
  var yIndex = this.propertyName.indexOf(v_fld),
    srow = document.createElement("TR"),
    stcol;
  for (var k = 0; k < cols; k++) {
    stcol = document.createElement("TD");
    if (k == 0)
      stcol.textContent = record[this.xIndex];
    else
      stcol.textContent = l_fld + ": " + record[yIndex];
    stcol.style.textAlign = "center";
    srow.appendChild(stcol);
  }
  return srow;
}
StdChart.prototype._GetItemForGrid = function (item) {
  var itm = {
    key: item.keyField || item.keyF,
    serie: item.series,
    category: item.category,
    value: item.value,
    field: item.valueField
  };
  if ("realValue" in item)
    itm.value = item.realValue;
  return itm;
}
StdChart.prototype._FindItemForGrid = function (record, validx) {
  var itm = {};
  if (!Empty(this.objConfig.keyField))
    itm.keyField = record[this.propertyName.indexOf(this.objConfig.keyField)];
  itm.value = record[validx];
  itm.valueField = this.propertyName[validx];
  itm.series = this.orgSeriesList[this.valueFields.indexOf(itm.valueField)];
  itm.category = record[this.propertyName.indexOf(this.objConfig.labelField)];
  return this._GetItemForGrid(itm);
}
StdChart.prototype._GetBoundariesValues = function () {
  if (!this._boundaries)
    this._boundaries = {};
  if (!this._boundaries.min && this._boundaries.min != 0)
    this._boundaries.min = d3.min(this.allValues);
  if (!this._boundaries.max && this._boundaries.max != 0)
    this._boundaries.max = d3.max(this.allValues);
  if ((!Empty(this.defSettings.valueAxis.minValue) || parseInt(this.defSettings.valueAxis.minValue) == 0) && !isNaN(this.defSettings.valueAxis.minValue))
    this._boundaries.min = this.defSettings.valueAxis.minValue;
  if ((!Empty(this.defSettings.valueAxis.maxValue) || parseInt(this.defSettings.valueAxis.maxValue) == 0) && !isNaN(this.defSettings.valueAxis.maxValue))
    this._boundaries.max = this.defSettings.valueAxis.maxValue;
  return this._boundaries;
}
StdChart.prototype._GetParametersStringForLink = function (item) {
  var purl = "",
    _this = this._ZtChart.StdChart,
    mcat,
    format,
    val,
    key_time = _this.domainIsTime && IsA(item.keyF, 'D'),
    linkObj = _this.linkObj,
    seriesName = Empty(linkObj.seriesname) ? "series" : linkObj.seriesname,
    categoryName = Empty(linkObj.categoryname) ? "category" : linkObj.categoryname,
    categoryKeyName = Empty(linkObj.categoryKeyName) ? "categoryKey" : linkObj.categoryKeyName,
    valueName = Empty(linkObj.valuename) ? "value" : linkObj.valuename;


  mcat = item.category;
  if (!Empty(mcat + "")) {
    if (_this.domainIsTime && !key_time) {
      format = _this.stdFormat;
      if (!Empty(_this.defSettings.time.customFormat) || !Empty(_this.defSettings.time.format))
        format = getTimeTickFormat(_this.localeLangFormat, _this.defSettings.time.customFormat || _this.defSettings.time.format);
      mcat = format(mcat);
    }
    purl += categoryName + "=" + URLenc(mcat);
  }

  if (!Empty(item.series))
    purl += "&" + seriesName + "=" + URLenc(item.series);

  if (!Empty(item.keyF))
    purl += "&" + categoryKeyName + "=" + URLenc(item.keyF);

  val = parseFloat(item.value);
  if (!isNaN(val)) {
    // apply picture + funzione
    if (this.defSettings.valueLabel.applyPicture && this.defSettings.valuePicture.applyFunction) {
      if (this.functionObj.GetValuePicture) {
        val = this.functionObj.GetValuePicture(this._GetItemForGrid(item));
      }
    }
    else {
      val = this.GetValuePicture(val);
      if (!Empty(item.progrValue + "") && !Empty(item.progrValue))
        purl += "&progrvalue=" + URLenc(item.progrValue);
    }
    purl += "&" + valueName + "=" + URLenc(val);
  }

  return purl;
}
StdChart.prototype._GetExcludedElements = function (/*filters*/) {
  if (!this.excludedData)
    return [];
  if (Empty(this.excludedData.series) && Empty(this.excludedData.categories))
    return [];

  var ex_elms = [],
    checked = [],
    i, j, idx, pn_idx,
    record,
    serList = JSON.parse(this.columnOrderData.seriesList),
    data = JSON.parse(this.columnOrderData.data),
    pname = JSON.parse(this.columnOrderData.propertyName),
    vflds = JSON.parse(this.columnOrderData.valueFields);

  for (i = 0; i < data.length; i++) {
    checked = []; // x evitare di inserire il record 2 volte
    record = data[i];
    idx = -1;
    pn_idx = -1;
    if (!Empty(this.excludedData.series)) {
      for (j = 0; j < this.excludedData.series.length; j++) {
        idx = serList.indexOf(this.excludedData.series[j]);
        if (idx >= 0) {
          pn_idx = pname.indexOf(vflds[idx]);
          if (pn_idx >= 0) {
            ex_elms.push({
              serie: this.excludedData.series[j],
              category: !Empty(this.objConfig.keyField) ? record[this.xLabelIndex] : record[this.xIndex],
              key: !Empty(this.objConfig.keyField) ? record[this.xIndex] : null,
              value: record[pn_idx]
            });
            checked.push(vflds[idx]);
          }
        }
      }
    }

    if (!Empty(this.excludedData.categories)) {
      var cat = !Empty(this.objConfig.keyField) ? record[this.xLabelIndex] : record[this.xIndex];
      idx = this.excludedData.categories.indexOf(cat);
      if (idx >= 0) {
        for (j = 0; j < vflds.length; j++) {
          if (checked.indexOf(vflds[j]) >= 0)
            continue;
          pn_idx = pname.indexOf(vflds[j]);
          ex_elms.push({
            serie: serList[j],
            category: cat,
            key: !Empty(this.objConfig.keyField) ? record[this.xIndex] : null,
            value: record[pn_idx]
          });
        }
      }
    }
  }
  return ex_elms;
}
StdChart.prototype._DrawAxisReferenceLines = function () {
  var line;
  if (this.domainIsNumber && this.defSettings.domainAxis.referenceLine) {
    if (!isNaN(this.defSettings.domainAxis.referenceLine.value)) {
      line = this.renderer.append("line")
        .attr("class", "domainAxRL")
        .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")")
        .style("fill", "none")
        .style("stroke-width", "1px")
        .style("stroke", Empty(this.defSettings.domainAxis.referenceLine.color)
          ? "#C3C3C3"
          : this.defSettings.domainAxis.referenceLine.color)
        .style("shape-rendering", "crispedges");
      if (this._GetDomainAxisPosition() == "bottom") {
        line.attr("x1", this.scaleX(this.defSettings.domainAxis.referenceLine.value))
          .attr("x2", this.scaleX(this.defSettings.domainAxis.referenceLine.value))
          .attr("y1", 0)
          .attr("y2", this.chartHeight);
      }
      else {  // left
        line.attr("y1", this.scaleX(this.defSettings.domainAxis.referenceLine.value))
          .attr("y2", this.scaleX(this.defSettings.domainAxis.referenceLine.value))
          .attr("x1", 0)
          .attr("x2", this.chartWidth);
      }
    }
  }

  if (this.defSettings.valueAxis.referenceLine) {
    if (!isNaN(this.defSettings.valueAxis.referenceLine.value)) {
      line = this.renderer.append("line")
        .attr("class", "valueAxRL")
        .attr("transform", "translate(" + [this.margin.left, this.margin.top] + ")")
        .style("fill", "none")
        .style("stroke-width", "1px")
        .style("stroke", Empty(this.defSettings.valueAxis.referenceLine.color)
          ? "#C3C3C3"
          : this.defSettings.valueAxis.referenceLine.color)
        .style("shape-rendering", "crispedges");
      var firstRefAxis = Object.keys(this.scaleY)[0],
        scaleY = this.scaleY[this.scaleY[firstRefAxis].__refAxis];
      if (this._GetValueAxisPosition() == "bottom") {
        line.attr("x1", scaleY(this.defSettings.valueAxis.referenceLine.value))
          .attr("x2", scaleY(this.defSettings.valueAxis.referenceLine.value))
          .attr("y1", 0)
          .attr("y2", this.chartHeight);
      }
      else {  // left
        line.attr("y1", scaleY(this.defSettings.valueAxis.referenceLine.value))
          .attr("y2", scaleY(this.defSettings.valueAxis.referenceLine.value))
          .attr("x1", 0)
          .attr("x2", this.chartWidth);
      }
    }
  }
}
StdChart.prototype._GetOtherTooltipObject = function () {
  return null;
}