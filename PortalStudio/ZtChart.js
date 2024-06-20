/* exported myZtCharts */
/* global ZtStackBarChart ZtBarChart ZtPieChart ZtLinesChart ZtAreaChart
    ZtContainerChart ZtMultiDimCursorChart
    ZtGeographicChart ZtDialChart ZtDisplayChart ZtImageChart ZtLightsChart ZtThermoChart
    ZtPyramidDistributionChart ZtWordChart ZtXYZChart ZtParetoChart ZtWaterfallChart ZtRadarChart ZtLayeredBarChart
    ZtTreeMapChart ZtTreeMapBarChart ZtStackAreaChart getFilterType
    languageConfigurations replaceIconFontWithUnicode replaceIconFontWithCharCode
    notifyDraw ZtAsterChart ZtAreaBarChart ZtSunburstChart ZtTreeChart ZtCirclePackChart ZtForceChart
    ZtMatrixChart ZtChordChart ZtCalendarChart ZtPyramidChart ZtFunnelChart ZtMekkoChart ZtBCMatrixChart
    ZtPCoordsChart ZtVoronoiChart ZtSankeyChart ZtRingPChart ZtECharts
  */

if (typeof myZtCharts == "undefined")
  var myZtCharts = {};
// definizione ZtChart
if (typeof(ZtChart) == "undefined") {
  function ZtChart(chartConfig, objConfig, propertyName, propertyValue, parent, functionObj, linkObj, mychartid, chartContainer, loadextlibs) {
    var oldZTC = (Object.prototype.toString.call(propertyName) === '[object Array]'),
    pName,
    addData,
    addPName,
    weburl,
    drawWithECharts = false,
    render_opts,
    draw_opts,
    _orgChtConfig;

    if (!oldZTC) {
      if (chartConfig.drawWithECharts) {
        drawWithECharts = chartConfig.drawWithECharts;
        weburl = chartConfig.urlReference;
        if (!Empty(weburl) && weburl.substr(-1) == '/')
          weburl = weburl.slice(0, -1);
        if (!loadextlibs) {
          initGlobalLibraries(weburl);
          loadextlibs = true;
        }
        parent = chartConfig.parent;
        render_opts = chartConfig.render_opts;
        draw_opts = chartConfig.draw_opts;
        _orgChtConfig = chartConfig.chtConfig;
        if (Empty(draw_opts) && !Empty(_orgChtConfig)) {
          draw_opts = convertChartConfigInOptions(chartConfig.noDef, _orgChtConfig, propertyName, objConfig);
        }
      }
      else {
        this.initialType = chartConfig.graphSettings.chartType;
        pName = propertyName.propName;
        propertyValue = propertyName.dataset;
        parent = propertyName.parent;
        functionObj = propertyName.functionObj;
        linkObj = propertyName.linkObj;
        mychartid = propertyName.chartId;
        chartContainer = propertyName.container;
        loadextlibs = propertyName.loadLibs;
        addData = propertyName.addData;
        addPName = propertyName.addPName;
        weburl = propertyName.urlReference;
        if (!Empty(weburl) && weburl.substr(-1) == '/')
          weburl = weburl.slice(0, -1);
      }
    }
    else {
      this.initialType = chartConfig.graphSettings.chartType;
      pName = propertyName;
    }

    this.StdChart = null;
    this.StdChartCursor = null;
    this.stdFormat = null;
    this.hoverFormat = null;
    this.datetimePict = "YYYY-MM-DD hh:mm:ss";
    this.hDatetimePict = "YYYYMMDDhhmmss";
    this.menuWrapper = null;
    this.fmenuWrapper = null;
    this.orgData = propertyValue;
    this.enableClick = true;
    this.enableLegendClick = true;
    this.enableClickEffect = true;
    this.enableLegendEffect = true;
    this.enableExclude = true;
    this.fontsMap = { };
    this.ZtChartTransDict = {};

    /**** inizializzazione librerie del grafico ****/
    if (!loadextlibs)
      initGlobalLibraries(weburl);

    /**** METODI ESPOSTI DA ZTCHART ****/
    this.draw = function (redrawChart, selectedItems) {
      if (drawWithECharts) {
        // this.StdChart istanza di echart
        if (!chartConfig.noDef)
          ZtECharts.SetColors(_orgChtConfig, draw_opts);
        this.StdChart.setOption(draw_opts);
      }
      else {
        notifyDraw(this.StdChart, 'DrawCallback', redrawChart, selectedItems);
        if(this.StdChartCursor && !this.StdChartCursor.drawCursor)
          notifyDraw(this.StdChartCursor, 'DrawCallback', redrawChart);
      }
    }

    this.redraw = function (newData, newObjConfig, isFilter) {
      notifyDraw(this.StdChart, 'RedrawCallback', newData, newObjConfig, isFilter);
    }

    this.appendData = function (record) {
      notifyDraw(this.StdChart, 'AppendData', record);
    }

    this.setLanguage = function (lang, m_this) {
      if (!lang || languageConfigurations(lang.toLowerCase()) === undefined)
        return false;
      else {
        if (Empty(m_this))
          m_this = this.StdChart;
        if(m_this) {
          m_this.language = lang.toLowerCase();
          var mlangobj = languageConfigurations(m_this.language);
          m_this.language = lang.toLowerCase();
          m_this.localeLangFormat = {};
          m_this.localeLangFormat.numberFormat = d3.formatLocale(mlangobj.formatLocale).format;
          m_this.localeLangFormat.timeFormat = d3.timeFormatLocale(mlangobj.timeFormatLocale).format;
          m_this.localeLangFormat.timeParse = d3.timeParse(mlangobj.timeFormatLocale.dateTime);
          m_this.localeLangFormat.csvSeparator = mlangobj.csvSeparator;
          m_this.localeLangFormat.formatLocale = mlangobj.formatLocale;
          return true;
        }
        return false;
      }
    };

    this.setLanguageObj = function (objLang) {
      var _this = this.StdChart;
      _this.localeLangFormat = {};
      _this.localeLangFormat.numberFormat = d3.formatLocale(objLang.formatLocale).format;
      _this.localeLangFormat.timeFormat = d3.timeFormatLocale(objLang.timeFormatLocale).format;
      _this.localeLangFormat.csvSeparator = objLang.csvSeparator;
    };

    this.setIsOldVersion = function (value) {
      var _this = this.StdChart;
      _this.isOLD = value;
    }

    this.setIsStaticChart = function (value) {
      var _this = this.StdChart;
      _this.SetIsStaticChart(value);
    }

    this.getChartId = function () {
      var _this = this.StdChart;
      return _this.chartId;
    }

    this.getSVGString = function (imgType, html) {
      var _this = this.StdChart;
      var plot;
      var elms = d3.select("#" + _this.chartId + "d3ChartPlot").selectAll("[item-type=pattern]")._groups[0];
      if (!Empty(elms)) {
        for (var i = 0; i < elms.length; i++)
          d3.select(elms[i]).attr("style", d3.select(elms[i]).attr("style").replace(/"/gi, ""));
      }
      var links = d3.select("#" + _this.__cID + "d3ChartDefs").html();
      if (!Empty(links)) {
        var links_arr = links.split("type=\"text/css\">");
        d3.select("#" + _this.__cID + "d3ChartDefs").html(links_arr[links_arr.length - 1]);
      }

      var patterns = d3.select("#" + _this.__cID + "negativeValuePattern");
      if (!Empty(patterns.node())) {
        var patsvg = patterns.select("svg").node();
        if (!Empty(patsvg)) {
          if (!Empty(patsvg.getAttribute("xmlns")))
            patsvg.removeAttribute("xmlns");
          if (!Empty(patsvg.getAttribute("xmlns:xlink")))
            patsvg.removeAttribute("xmlns:xlink");
        }
      }

      if (Empty(html)) {
        html = '<svg id="' + _this.chartId + 'tChart" width="' + _this.defSettings.globals.width + '" height="' + _this.defSettings.globals.height + '">';
        html += '<defs></defs>';
        replaceIconFontWithUnicode(imgType, _this.forPJS);
        plot = d3.select("#" + _this.chartId + "d3ChartPlot").node();
        if (plot && plot.parentNode)
          html += plot.parentNode.innerHTML;
        replaceIconFontWithCharCode(imgType, _this.forPJS);
        html += "</svg>";
      }

      html = html.replace(/&amp;/g, '&');

      if (!IsIE()) {
        var p0 = html.indexOf("<svg "),
        p1 = html.lastIndexOf("</svg>");
        if (p0 >= 0 && p1 >= 0)
          html = html.substring(p0, p1 + "</svg>".length);
        html = html.replace(/<svg /g, '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" ');
      }

      if (html.indexOf("progid:") >= 0) {
        var v1 = "progid:DXImageTransform.Microsoft.gradient(startColorstr=" + _this.defSettings.globals.graphColors.color + ", endColorstr=" + _this.defSettings.globals.graphColors.gradient,
        v2 = "-webkit-gradient(linear, 0 0, " + _this.defSettings.globals.width + " " + _this.defSettings.globals.height + ", from(" + _this.defSettings.globals.graphColors.color + "), to(" + _this.defSettings.globals.graphColors.gradient + "))";
        html = Strtran(html, "filter:", "background:");
        html = Strtran(html, v1, v2);
      }

      html = removeURLreference(html);

      // ripristino links
      if (!Empty(links))
        d3.select("#" + _this.__cID + "d3ChartDefs").html(/*links*/links_arr.join("type=\"text/css\"/>"));
      return html;

      function removeURLreference(html) {
        var toremove = document.URL.toString(),
        mhtml = html,
        idx = mhtml.indexOf(toremove);
        while (!Empty(toremove) && idx >= 0) {
          mhtml = mhtml.replace(toremove, "");
          idx = mhtml.indexOf(toremove);
        }
        return mhtml;
      }
    }

    this.getBase64Image = function (elem) {
      var html = this.getSVGString(elem),
      chart = this.StdChart,
      webroot = chart.GetWebRootURL(),
      url = webroot + "/servlet/SPBatikServlet?";
      if (chart.usedFonts.indexOf("svgcharts") < 0)
        chart.usedFonts.push("svgcharts");
      // scrivo la chiamata
      url += 'asB64String=true';
      url += '&svgStr=' + URLenc(html);
      url += "&uri=" + URLenc(document.baseURI);
      url += "&chartId=" + URLenc(chart.chartId);
      url += "&type=" + URLenc(elem);
      url += "&fonts=" + URLenc(chart.usedFonts.toString());
      url += "&fileName=" + URLenc(chart.exportFileName);
      var jurl = new JSURL(url, true);
      var output = jurl.Response();
      return output;
    }

    this.getPngB64 = function () {
      return this.getBase64Image('png');
    }

    this.getJpegB64 = function () {
      return this.getBase64Image('jpeg');
    }

    this.getPdfB64 = function () {
      return this.getBase64Image('pdf');
    }

    this.getSVGStringWF = function () {
      return this.getBase64Image('svgf');
    }

    this.downloadChart = this.chartDownload /* retrocompatibilita' */ = function (type, chartid) {
      var _this = this.StdChart;
      if (this.StdChartCursor && chartid && this.StdChartCursor.chartId == chartid)
        _this = this.StdChartCursor;
      if (_this.menu && _this.menu.show && _this.menu.ctrl)
        _this.menu.ctrl.CloseMenu();
      if (_this.fmenu && _this.fmenu.show && _this.fmenu.ctrl)
        _this.fmenu.ctrl.CloseMenu();
      if (_this.objConfig.enableGrid && _this._status == "grid")
        _this._ViewGridData();
      _this.DownloadChart(type);
    }

    this.changeChartType = function (type) {
      var _this = this.StdChart,
      itemObjects = _this.GetSelectedItems();
      if (_this.menu && _this.menu.ctrl)
        _this.menu.ctrl.CloseMenu();
      if (_this.fmenu && _this.fmenu.ctrl)
        _this.fmenu.ctrl.CloseMenu();
      if (_this.objConfig.enableGrid && _this._status == "grid")
        _this._ViewGridData();
      var new_this;
      if (_this.IsMultiDim()) {
        new_this = _this;
        _this.chartConfig.graphSettings.chartType = type;
      }
      else
        new_this = getChartCtrl(type);
      var propertyName = _this.propertyName,
      data = _this.dataSet;
      if (!Empty(_this.columnOrderData)) {
        propertyName = JSON.parse(_this.columnOrderData.propertyName);
        data = JSON.parse(_this.columnOrderData.data);
        if (_this.domainIsTime && (typeof data[0][_this.xIndex] == "string")) {
          // JSON.stringify ha trasformato la data in stringa ISO
          for (var i = 0; i < data.length; i++) {
            var record = data[i];
            record[_this.xIndex] = new Date(Date.parse(record[_this.xIndex]));
          }
        }
      }
      new_this.SetWebRootURL(_this.GetWebRootURL());
      new_this.InitChart({
        ztChart: this,
        chartConfig: _this.chartConfig,
        objConfig: _this.objConfig,
        propertyName: propertyName,
        dataset: data,
        parent: _this.parent,
        fncObj: _this.functionObj,
        lnkObj: _this.linkObj,
        chartId: _this.chartId.slice(0, _this.chartId.length - 1),
        container: _this.chartContainer
      });
      if (new_this._SupportChangeOrder())
        new_this.dataOrder = _this.dataOrder;
      new_this.customColorsSeries = _this.customColorsSeries;
      new_this.customColors = _this.customColors;
      new_this._ZtChart.setLanguage(_this.language, new_this);
      new_this.aggregateData = _this.aggregateData;
      this.StdChart = new_this;
      this.StdChart.SetData();
      this.StdChart.SetChartDraw();
      this.draw(true, itemObjects);
    }

    this.updateDraw = function (mchartConfig, otherChart, noCallback) {
      var _this = this.StdChart;
      var itemObjects = _this.GetSelectedItems();
      if (_this.menu && _this.menu.ctrl)
        _this.menu.ctrl.CloseMenu();
      if (_this.fmenu && _this.fmenu.ctrl)
        _this.fmenu.ctrl.CloseMenu();
      if (!Empty(otherChart))
        _this.objConfig.otherChart = otherChart;

      var new_this = _this.GetChart(mchartConfig.graphSettings.chartType, true),
      propertyName = _this.propertyName,
      data = _this.dataSet;
      if (!Empty(_this.columnOrderData)) {
        propertyName = JSON.parse(_this.columnOrderData.propertyName);
        data = JSON.parse(_this.columnOrderData.data);
        if (_this.domainIsTime && (typeof data[0][_this.xIndex] == "string")) {
          // JSON.stringify ha trasformato la data in stringa ISO
          for (var i = 0; i < data.length; i++) {
            var record = data[i];
            record[_this.xIndex] = new Date(Date.parse(record[_this.xIndex]));
          }
        }
      }
      new_this.SetWebRootURL(_this.GetWebRootURL());
      new_this.InitChart({
        ztChart: this,
        chartConfig: mchartConfig,
        objConfig: _this.objConfig,
        propertyName: propertyName,
        dataset: data,
        parent: _this.parent,
        fncObj: _this.functionObj,
        lnkObj: _this.linkObj,
        chartId: _this.chartId.slice(0, _this.chartId.length - 1),
        container: _this.chartContainer
      });
      new_this.customColorsSeries = _this.customColorsSeries;
      new_this.customColors = _this.customColors;
      new_this._ZtChart.setLanguage(_this.language, new_this);
      new_this.aggregateData = _this.aggregateData;
      this.StdChart = new_this;
      this.StdChart.SetData();
      this.StdChart.SetChartDraw();
      if (!noCallback)
        this.draw(true, itemObjects);
      else
        this.StdChart.DrawCallback();
    }

    this.changeDataOrder = function () {
      var _this = this.StdChart;
      var itemObjects = _this.GetSelectedItems();
      if (_this.objConfig.enableGrid && _this._status == "grid")
        _this._ViewGridData();
      _this.ChangeDataOrder();
      this.draw(true, itemObjects);
    }

    this.setZFObject = function(zfObj, type) {
      delete this.ZFObjConfig;
      if(!zfObj)
        return;
      this.ZFObjConfig = {};
      this.ZFObjConfig.chartType = type;

      if(!Empty(zfObj)){
        if(!Empty(zfObj.show))
          this.ZFObjConfig.show = zfObj.show;
        else
          this.ZFObjConfig.show = "default";
        this.ZFObjConfig.filterType = getFilterType(zfObj.type);
        if(!Empty(zfObj.series))
          this.ZFObjConfig.valueFields = zfObj.series.split(",");
        else
          this.ZFObjConfig.valueFields = [];
        this.ZFObjConfig.color = zfObj.color;
      }
      else{
        if(Empty(this.ZFObjConfig.show))
          this.ZFObjConfig.show = "default";
        this.ZFObjConfig.filterType = getFilterType(zfObj.type);
        this.ZFObjConfig.valueFields = [];
      }
    }

    this.setExcludedSeries = function (list) {
      var _this = this.StdChart;
      _this.excludedList = list;
      _this = this.StdChartCursor;
      if (_this)
        _this.excludedList = list
    }

    this.getCSVdata = function (selectedItems) {
      if (selectedItems)
        return this._GetExportData("csv","EXPSEL",true);
      return this._GetExportData("csv","EXPALL",true);
    }

    this.getXMLdata = function (selectedItems) {
      if (selectedItems)
        return this._GetExportData("xml","EXPSEL",true);
      return this._GetExportData("xml","EXPALL",true);
    }

    this.hasAggregateData = function () {
      var _this = this.StdChart;
      return _this._HasAggregateData();
    }

    this.getAggregateData = function (vfields) {
      var _this = this.StdChart;
      return _this._GetAggregateData(vfields);
    }
    
    this.addRangeBand = function (label, min, max, color, isPercent, imgpath) {
      var _this = this.StdChart;
      if (!_this.objConfig.rangeBands || Empty(_this.objConfig.rangeBands))
        _this.objConfig.rangeBands = [];
      var rb = {
        label: label || '',
        minValue: min || null,
        maxValue: max || null,
        color: color || '',
        percent: isPercent || false,
        imageUrl: imgpath || ''
      };
      _this.objConfig.rangeBands.push(rb);
    }

    this.removeRangeBands = function () {
      var _this = this.StdChart;
      delete _this.objConfig.rangeBands;
    }

    this.clearRangeBands = function () {
      var _this = this.StdChart;
      _this.objConfig.rangeBands = [];
    }

    this.getSelectedItems = function () {
      var _this = this.StdChart,
      ret = [],
      itemObjects = _this.GetSelectedItems();
      for (var i = 0; i < itemObjects.length; i++) {
        var obj = _this._GetItemObj(itemObjects[i]);
        if (ret.hasElement(obj) < 0)
          ret.push(obj);
      }
      return ret;
    }

    this.getNotSelectedItems = function () {
      var _this = this.StdChart,
      ret = [],
      itemObjects = _this.GetNotSelectedItems();
      for (var i = 0; i < itemObjects.length; i++) {
        var obj = _this._GetItemObj(itemObjects[i]);
        if (ret.hasElement(obj) < 0)
          ret.push(obj);
      }
      return ret;
    }

    this.makeItemsFromRS = function (rsArray, fieldsArray) {
      var _this = this.StdChart;
      var retA = [];
      for(var i=0; i<rsArray.length; i++) {
        var ret = _this._MakeItemFromRS(rsArray[i], fieldsArray);
        for(var j=0; j<ret.length; j++)
          retA.push(ret[j]);
      }
      return retA;
    }

    this.setSelectedItems = function (itemArray) {
      this.selectItems(itemArray);
    }

    this.selectItem = function (item) {
      var _this = this.StdChart;
      item.isSelected = true;
      _this.ApplySelectionsObjects([item]);
    }

    this.selectItems = function (itemArray) {
      var _this = this.StdChart;
      for (var i = 0; i < itemArray.length; i++)
        itemArray[i].isSelected = true;
      _this.ApplySelectionsObjects(itemArray);
    }

    this.unselectItem = function (item) {
      var _this = this.StdChart;
      item.isSelected = false;
      _this.ApplySelectionsObjects([item]);
    }

    this.unselectItems = function (itemArray) {
      var _this = this.StdChart;
      for(var i=0; i<itemArray.length; i++)
        itemArray[i].isSelected = false;
      _this.ApplySelectionsObjects(itemArray);
    }

    this.setEnableClick = function (bool) {
      this.enableClick = bool;
    }

    this.setEnableClickEffect = function (bool) {
      this.enableClickEffect = bool;
    }

    this.setEnableLegendClick = function (bool) {
      this.enableLegendClick = bool;
    }

    this.setEnableLegendEffect = function (bool) {
      this.enableLegendEffect = bool;
    }

    this.setEnableExclude = function (bool) {
      this.enableExclude = bool;
    }

    this.setIsPhantomJS = function (bool) {
      this.StdChart.SetPhantomJS(bool);
    }

    this.setUrlReference = function (bool) {
      this.StdChart.SetWebRootURL(bool);
    }

    this.removeAllSelections = function () {
      this.StdChart.RemoveAllSelections();
    }

    this.showAggregateDetail = function () {
      var _this = this.StdChart;
      _this.ShowAggregateDetail();
    }

    this.isLegendHide = function () {
      var _this = this.StdChart;
      if (_this.chartLegends && _this.chartLegends.series)
        return _this.chartLegends.series.hide;
      return false;
    }

    this.isRangeLegendHide = function () {
      var _this = this.StdChart;
      if (_this.chartLegends && _this.chartLegends.range)
        return _this.chartLegends.range.hide;
      return false;
    }

    this.setColorForSerie = function (vfield, color, gradient) {
      var _this = this.StdChart,
      index = _this._GetDrawingList().indexOf(vfield);
      if (index >= 0)
        _this.customColorsSeries["_" + index] = { color : color, gradient : gradient };
    }

    this.getSeriesColors = function () {
      var _this = this.StdChart;
      return _this.colorSet;
    }

    this.setEnableExpandCollapse = function (bool) {
      this.StdChart.SetElemExpandCollapse(bool);
    }

    this.viewGridData = function () {
      var _this = this.StdChart;
      if (_this.objConfig.enableGrid)
        _this._ViewGridData();
    }

    this.getViewIsChart = function () {
      return this.StdChart._ReturnStatus("chart");
    }

    this.getViewIsGrid = function () {
      return this.StdChart._ReturnStatus("grid");
    }

    this.setSeriesColors = function (array_colors, applyeach) {
      var _this = this.StdChart;
      if (!Empty(array_colors)) {
        var tmp_cols = [];
        for (var i = 0; i < array_colors.length; i++) {
          if (array_colors[i].color) {
            tmp_cols.push({ color: array_colors[i].color, 
                            gradient: array_colors[i].gradient || ""
                          })
          }
          else
            tmp_cols.push({ color: array_colors[i],
                            gradient: ""
                          });
        }
        _this.customColors.array = tmp_cols.slice();
      }
      _this.customColors.useForEach = applyeach;
    }

    this.getExcludedItems = function () {
      return this.StdChart._GetExcludedElements();
    }

    this._GetInstance = function () {
      if (drawWithECharts)
        return this.StdChart;
      return null;
    }

    this._getChartCType = function (type, evalCont) {
      var ttype = type;
      if (evalCont && this.StdChart) //GM
        ttype = evaluateChartType(type, this.StdChart.objConfig);
      return getChartCtrl(ttype);
    }

    this.GetMenuCtrl = function () {
      if (this.StdChart.menu && this.StdChart.menu.ctrl)
        return this.StdChart.menu.ctrl;
      return null;
    }

    /**** FUNZIONI COMUNI ****/
    function convertChartConfigInOptions(noDef, cconfig, objData, objConfig) {
      var opts;
      if (noDef) {
        opts = cconfig.opts;
        makeOptsSeries(opts, cconfig.chartType, objData, objConfig);
        ZtECharts.SetAxisTypes(cconfig.chartType, opts);
      }
      else {
        var globals = cconfig.globalSettings,
          graphs = cconfig.graphSettings;
        opts = {
          series: [
            {
              colorBy: "data",
              /* props */
              emphasis: {
                itemStyle: {
                  color: Empty(graphs.hoverColor) ? "auto" : graphs.hoverColor
                }
              }
            }
          ]
        }

        opts.backgroundColor = globals.graphColors.color;
        opts.textStyle = {
          fontFamily: globals.globalFont.name,
          fontSize: globals.globalFont.size,
          color: globals.globalFont.color
        }
        opts.title = {
          show: true, // da valutare con presenza o meno di testo
          top: globals.titles[0].position,
          left: globals.titles[0].alignment,
          /** titolo */
          text: globals.titles[0].text,
          textStyle: {
            fontFamily: globals.titles[0].useGlobalFont ? null : globals.titles[0].textFont.name,
            fontSize: globals.titles[0].useGlobalFont ? null : globals.titles[0].textFont.size,
            color: globals.titles[0].useGlobalFont ? null : globals.titles[0].textFont.color
          },
          /** sottotitolo */
          subtext: globals.titles[2].text,
          subtextStyle: {
            fontFamily: globals.titles[2].useGlobalFont ? null : globals.titles[2].textFont.name,
            fontSize: globals.titles[2].useGlobalFont ? null : globals.titles[2].textFont.size,
            color: globals.titles[2].useGlobalFont ? null : globals.titles[2].textFont.color
          }
        }
        opts.legend = {
          show: globals.titles[1].position == "hide" ? false : true,
          top: globals.titles[1].position,
          left: globals.titles[1].alignment,
          icon: globals.titles[1].icon == "default" ? "" : globals.titles[1].icon,
          backgroundColor: globals.titles[1].extendColors.color,
          borderColor: globals.titles[1].extendLine.color,
          borderWidth: globals.titles[1].extendLine.stroke,
          textStyle: {
            fontFamily: globals.titles[1].useGlobalFont ? null : globals.titles[1].textFont.name,
            fontSize: globals.titles[1].useGlobalFont ? null : globals.titles[1].textFont.size,
            color: globals.titles[1].useGlobalFont ? null : globals.titles[1].textFont.color
          },
          type: "scroll"
        }
        opts.xAxis = {
          show: graphs.domainAxis.show,
          axisLine: {
            onZero: false,	// per ora non esiste un'opzione in merito
            onZeroAxisIndex: false,
            lineStyle: {
              color: Empty(graphs.domainAxis.domainLine.color) ? "#000" : graphs.domainAxis.domainLine.color,
              width: Empty(graphs.domainAxis.domainLine.stroke) ? 1 : graphs.domainAxis.domainLine.stroke
            }
          },
          fontFamily: (graphs.domainAxis.useValueFont
                      ? graphs.valueAxis.valueFont.name 
                      : (graphs.domainAxis.useGlobalFont
                        ? globals.globalFont.name
                        : graphs.domainAxis.domainFont.name)
                      ),
          fontSize: (graphs.domainAxis.useValueFont
                    ? graphs.valueAxis.valueFont.size 
                    : (graphs.domainAxis.useGlobalFont
                      ? globals.globalFont.size
                      : graphs.domainAxis.domainFont.size)
                    ),
          color: (graphs.domainAxis.useValueFont
                  ? graphs.valueAxis.valueFont.color 
                  : (graphs.domainAxis.useGlobalFont
                    ? globals.globalFont.color
                    : graphs.domainAxis.domainFont.color)
                  ),
          /** ticks */
          axisLabel: {
            rotate: graphs.domainAxis.labelType
          },
          /** label */
          name: graphs.axisLabel.xLabel,
          //nameLocation: "middle",
          nameTextStyle: {
            fontFamily: graphs.axisLabel.useGlobalFont ? null : graphs.axisLabel.axisFont.name,
            fontSize: graphs.axisLabel.useGlobalFont ? null : graphs.axisLabel.axisFont.size,
            color: graphs.axisLabel.useGlobalFont ? null : graphs.axisLabel.axisFont.color
          },
          /** grid */
          splitLine:{
            show: (graphs.domainAxis.useValueGrid
                  ? graphs.valueAxis.valueGrid.line
                  : graphs.domainAxis.domainGrid.line),
            lineStyle: {
              color: (graphs.domainAxis.useValueGrid
                    ? graphs.valueAxis.valueGrid.color
                    : graphs.domainAxis.domainGrid.color),
              type: (graphs.domainAxis.useValueGrid
                    ? getAxisGridType(graphs.valueAxis.valueGrid.type)
                    : getAxisGridType(graphs.domainAxis.domainGrid.type)),
              width: (graphs.domainAxis.useValueGrid
                    ? (graphs.valueAxis.valueGrid.type == "dotted" ? 1.5 : 1)
                    : (graphs.domainAxis.domainGrid.type == "dotted" ? 1.5 : 1)),
              cap: (graphs.domainAxis.useValueGrid
                    ? (graphs.valueAxis.valueGrid.type == "dotted" ? "round" : "butt")
                    : (graphs.domainAxis.domainGrid.type == "dotted" ? "round" : "butt"))
            }
          }
        }
        opts.yAxis = {
          show: graphs.valueAxis.show,
          axisLine: {
            onZero: false,	// per ora non esiste un'opzione in merito
            onZeroAxisIndex: false,
            lineStyle: {
              color: Empty(graphs.valueAxis.valueLine.color) ? "#000" : graphs.valueAxis.valueLine.color,
              width: Empty(graphs.valueAxis.valueLine.stroke) ? 1 : graphs.valueAxis.valueLine.stroke
            }
          },
          fontFamily: (graphs.valueAxis.useGlobalFont
                      ? globals.globalFont.name
                      : graphs.valueAxis.valueFont.name
                      ),
          fontSize: (graphs.valueAxis.useGlobalFont
                    ? globals.globalFont.size
                    : graphs.valueAxis.valueFont.size
                    ),
          color: (graphs.valueAxis.useGlobalFont
                  ? globals.globalFont.color
                  : graphs.valueAxis.valueFont.color
                  ),
          /** label */
          name: graphs.axisLabel.yLabel,
          //nameLocation: "middle",
          nameTextStyle: {
            fontFamily: graphs.axisLabel.useGlobalFont ? null : graphs.axisLabel.axisFont.name,
            fontSize: graphs.axisLabel.useGlobalFont ? null : graphs.axisLabel.axisFont.size,
            color: graphs.axisLabel.useGlobalFont ? null : graphs.axisLabel.axisFont.color
          },
          /** grid */
          splitLine:{
            show: graphs.valueAxis.valueGrid.line,
            lineStyle: {
              color: graphs.valueAxis.valueGrid.color,
              type: getAxisGridType(graphs.valueAxis.valueGrid.type),
              width: graphs.valueAxis.valueGrid.type == "dotted" ? 1.5 : 1,
              cap: graphs.valueAxis.valueGrid.type == "dotted" ? "round" : "butt"
            }
          }
        } 

        makeOptsSeries(opts, graphs.chartType, objData, objConfig, graphs);
        ZtECharts.SetAxisTypes(graphs.chartType, opts);
      }
      return opts;

      function getAxisGridType(gtype) {
        var ret_val;
        switch (gtype) {
          case "long_dashed":
            ret_val = [10, 6];
            break;
          case "dotted":
            ret_val = [0.01, 4];
            break;
          case "plain":
            ret_val = "solid";
            break;
          default: // small_dashed
            ret_val = "dashed";
            break;
        }
        return ret_val;
      }

      function makeOptsSeries(opts, type, objData, objConfig, graphs) {
        var allFields = objData.propName,
        dataset = objData.dataset;
        if (!Empty(objData)) {
          opts.dataset = {
            dimensions: ZtECharts.GetDimensions(type, objConfig, dataset), // intestazione riga
            source : ZtECharts.GetDataset(type, objConfig, dataset)
          }
        }
        opts.series = ZtECharts.GetSeries(type, objConfig, allFields, dataset, noDef, graphs);
        ZtECharts.SetGraphicOptions(type, opts, objConfig, allFields, dataset);
      }
    }

    function getChartLibraries(type) {
      var lib_map = { };
      lib_map.VBAR = ["Bar"];
      lib_map.LINES = lib_map.VBAR.concat(["Lines"]);
      lib_map.SCATTER = lib_map.LINES.concat(["XYZ"]);
      lib_map.AREA = lib_map.LINES.concat(["Area"]);
      lib_map.VSTACKBAR = lib_map.VBAR.concat(["StackBar"]);
      lib_map.STACKEDAREA = lib_map.AREA.concat(lib_map.VSTACKBAR).concat(["StackArea"]);
      lib_map.PIE = lib_map.VBAR.concat(["Pie"]);
      lib_map.TREEMAP = lib_map.PIE.concat(["TreeMap"]);
      lib_map.TREEMAPBAR = lib_map.TREEMAP.concat(["TreeMapBar"]);
      lib_map.LAYEREDBAR = lib_map.VBAR.concat(["LayeredBar"]);
      lib_map.WATERF = lib_map.LINES.concat(lib_map.TREEMAPBAR).concat(["Waterfall"]);
      lib_map.RADARLINE = lib_map.LINES.concat(lib_map.PIE).concat(["Radar"]);
      lib_map.PARETO = lib_map.WATERF.concat(["Pareto"]);
      lib_map.WORDCLOUD = lib_map.PIE.concat(["Word"]);
      lib_map.PYRAMID = lib_map.WATERF.concat(["PyramidDistribution"]);
      lib_map.ARCDIAL = lib_map.LINES.concat(lib_map.PIE).concat(["Dial"]);
      lib_map.THERMO = lib_map.RADARLINE.concat(lib_map.ARCDIAL).concat(lib_map.LAYEREDBAR).concat(["Thermo"]);
      lib_map.LIGHTS = lib_map.RADARLINE.concat(lib_map.ARCDIAL).concat(["Lights"]);
      lib_map.IMAGES = lib_map.LIGHTS.concat(["Image"]);
      lib_map.DISPLAY = lib_map.LIGHTS.concat(["Display"]);
      lib_map.GEOMAP = lib_map.LINES.concat(lib_map.PIE).concat(["Geographic"]);
      lib_map.ASTER = lib_map.SCATTER.concat(lib_map.PIE).concat(["Aster"]);
      lib_map.AREABAR = lib_map.SCATTER.concat(lib_map.VSTACKBAR).concat(["AreaBar"]);
      lib_map.SUNB = lib_map.LINES.concat(lib_map.PIE).concat(["Sunburst"]);
      lib_map.TREE = lib_map.SUNB.concat(["Tree"]);
      lib_map.CPACK = lib_map.SUNB.concat(lib_map.VSTACKBAR).concat(["CirclePack"]);
      lib_map.FORCE = lib_map.TREE.concat(["Force"]);
      lib_map.MATRIX = lib_map.TREE.concat(["Matrix"]);
      lib_map.CHORD = lib_map.MATRIX.concat(["Chord"]);
      lib_map.CAL = lib_map.MATRIX.concat(["Calendar"]);
      lib_map.PYR = lib_map.LINES.concat(lib_map.PIE).concat(["Pyramid"]);
      lib_map.FUNNEL = lib_map.LINES.concat(lib_map.PIE).concat(["Funnel"]);
      lib_map.MARIMEKKO = lib_map.VBAR.concat(["Mekko"]);
      lib_map.BCMATRIX = lib_map.MARIMEKKO.concat(["BCMatrix"]);
      lib_map.PCOORDS = lib_map.LINES.concat(lib_map.PIE).concat(["PCoords"]);
      lib_map.VORONOI = lib_map.PIE.concat(lib_map.SCATTER).concat(["Voronoi"]);
      lib_map.SANKEY = lib_map.MATRIX.concat(["Sankey"]);
      lib_map.TIME = lib_map.LINES;
      lib_map.HBAR = lib_map.HBAR3D = lib_map.VBAR3D = lib_map.VBAR;
      lib_map.HSTACKBAR = lib_map.VSTACKBAR;
      lib_map.RING = lib_map.PIE3D = lib_map.PIE;
      lib_map.BUBBLE = lib_map.SCATTER;
      lib_map.TREEMAPBARH = lib_map.TREEMAPBAR;
      lib_map.LAYEREDBARH = lib_map.LAYEREDBAR;
      lib_map.RADARAREA = lib_map.RADARLINE;
      lib_map.PADDLE = lib_map.COUNTER = lib_map.DISPLAY;
      lib_map.SUNBSTR = lib_map.SUNB;
      lib_map.TREESTR = lib_map.TREE;
      lib_map.CPACKSTR = lib_map.CPACK;
      lib_map.FORCESTR = lib_map.FORCE;
      lib_map.NECKEDPYR = lib_map.PYRSTR = lib_map.NECKEDPYRSTR = lib_map.PYR;
      lib_map.RINGPERC = lib_map.RING.concat(["RingPerc"]);

      lib_map._ALL = [ // Std c'e' gia'
        "Lines", "Bar", "StackBar", "Pie",
        "Area", "StackArea", "TreeMap", "TreeMapBar",
        "LayeredBar", "Waterfall", "Radar", "XYZ",
        "Pareto", "PyramidDistribution", "Word", "Dial",
        "Thermo", "Lights", "Image", "Display",
        "MultiDimCursor", "Container", "Geographic",
        "Aster", "AreaBar", "Sunburst", "Tree", "CirclePack",
        "Force", "Matrix", "Chord", "Calendar", "Pyramid",
        "Funnel", "Mekko", "BCMatrix", "PCoords", "Voronoi", "Sankey",
        "RingPerc"
      ];
      
      return lib_map[type] || lib_map._ALL;
    }

    function initSupportLibraries(weburl, chart_type, other_charts) {
      if (ZtVWeb) {
        var url = !Empty(weburl) ? weburl: ZtVWeb.SPWebRootURL,
        i,
        chartLibs = getChartLibraries(chart_type);
        if (!Empty(other_charts))
          chartLibs = getChartLibraries("_ALL");
        ZtVWeb.RequireCSS('ChartObj.css');
        //ZtVWeb.RequireCSS('AdditionalFonts.css');
        for (i = 0; i < chartLibs.length; i++) {
          if (window.ZtChartLibs) {
            if (!Empty(ZtChartLibs[chartLibs[i]]))
              ZtVWeb.RequireLibrary(url + "/" + ZtChartLibs[chartLibs[i]]);
          }
          else
            ZtVWeb.RequireLibrary(url + "/chart/objects/ZtChart" + chartLibs[i] + ".js");
        }
      }
    }

    function initGlobalLibraries(weburl) {
      var d3_libs =  ["d3", "d3.layout.cloud", "d3-delaunay", "d3-sankey", "topojson"],
      echarts = ["echarts.min", "ZtChartFunctions", "ZtChartTransDict", "ChartObj"],
      libs =  [
        "ZtChartFunctions", "ZtChartGeoFunctions", "ZtChartTransDict",
        "HamburgerMenuObj", "ChartObj"
      ];
      if (ZtVWeb) {
        var url = !Empty(weburl) ? weburl: ZtVWeb.SPWebRootURL,
        i;
        if (drawWithECharts) {
          for (i = 0; i < echarts.length; i++) {
            ZtVWeb.RequireLibrary(url + "/" + echarts[i] + ".js");
          }
          // ZtVWeb.RequireLibrary(url + "/echarts.js.map");
          if (window.ZtChartLibs)
            ZtVWeb.RequireLibrary(url + "/" + ZtChartLibs.ECharts);
          else
            ZtVWeb.RequireLibrary(url + "/chart/objects/ZtECharts.js");
        }
        else {
          // d3 libraries
          for (i = 0; i < d3_libs.length; i++) {
            ZtVWeb.RequireLibrary(url + "/" + d3_libs[i] + ".js");
          }
          // ZtChart libraries
          for (i = 0; i < libs.length; i++) {
            if (window.ZtChartLibs) {
              if (!Empty(ZtChartLibs[libs[i]]))
              ZtVWeb.RequireLibrary(url + "/" + ZtChartLibs[libs[i]]);
            }
            else
              ZtVWeb.RequireLibrary(url + "/" + libs[i] + ".js");
          }
          if (window.ZtChartLibs) {
            if (!Empty(ZtChartLibs.Std))
            ZtVWeb.RequireLibrary(url + "/" + ZtChartLibs.Std);
          }
          else
            ZtVWeb.RequireLibrary(url + "/chart/objects/ZtChartStd.js");
        }
      }
    }

    function createChart(type, _ZtChart, chartUID) {
      if (drawWithECharts) {
        if (!Empty(echarts.getInstanceByDom(parent)))
          echarts.dispose(parent);
        return echarts.init(parent, null, render_opts);
      }
      else {
        drawLoadingDiv(parent);
        var myChartConfig = JSON.stringify(chartConfig);
        myChartConfig = JSON.parse(myChartConfig);
        if (objConfig.zoomFilter && objConfig.zoomFilter.show == 'zoom') {
          _ZtChart.setZFObject(objConfig.zoomFilter, type);
          myChartConfig.graphSettings.chartType = _ZtChart.ZFObjConfig.filterType;
          type = myChartConfig.graphSettings.chartType;
        }
        type = evaluateChartType(type, objConfig);
        if (myChartConfig.graphSettings.multiDimensional && myChartConfig.graphSettings.multiDimensional.multiDim)
          type = "MULTICURS";
        
        /**** inizializzazione librerie del grafico ****/
        if (!loadextlibs)
          initSupportLibraries(weburl, type, objConfig.otherChart);

        var _this = getChartCtrl(type);
        if (objConfig.zoomFilter && objConfig.zoomFilter.show == 'zoom') {
          _this.asZoomCursor = true;
          myChartConfig.graphSettings.domainAxis.show = true;
        }
        else if(objConfig.zoomFilter && objConfig.zoomFilter.show == 'chartzoom')
          myChartConfig.globalSettings.height = 2*myChartConfig.globalSettings.height/3;
        _this.UID = chartUID;
        _this.SetWebRootURL(weburl);
        _this.InitChart({
          ztChart: _ZtChart,
          chartConfig: myChartConfig,
          objConfig: objConfig,
          propertyName: pName,
          dataset: propertyValue,
          parent: parent,
          fncObj: functionObj,
          lnkObj: linkObj,
          chartId: mychartid,
          container: chartContainer,
          noCalc: type == "MULTICURS",
          addData: addData,
          addPName: addPName
        });
        _this.SetDataDraw();
        _this.SetChartDraw();
        return _this;
      }
    }

    function createChartCursor(type, _ZtChart, chartUID) {
      if(!objConfig.zoomFilter ||(objConfig.zoomFilter.show != 'chartzoom'))
        return;
      var ss = JSON.stringify(chartConfig);
      var myChartConfig = JSON.parse(ss);

      _ZtChart.setZFObject(objConfig.zoomFilter, type);
      myChartConfig.graphSettings.chartType = _ZtChart.ZFObjConfig.filterType;
      type = myChartConfig.graphSettings.chartType;

      var myObjConfig = JSON.stringify(objConfig);
      myObjConfig = JSON.parse(myObjConfig);
      myObjConfig.enableMenuSelections = false;
      myObjConfig.enableChangeOrder = false;
      myObjConfig.otherChart = "";
      myObjConfig.title = "";
      myObjConfig.titleSeries = "";

      myChartConfig.graphSettings.axisLabel.xLabel = "";
      myChartConfig.graphSettings.axisLabel.yLabel = "";
      myChartConfig.graphSettings.domainAxis.show = true;
      for(var i=0; i<myChartConfig.globalSettings.titles.length; i++)
        myChartConfig.globalSettings.titles[i].text = "";
      myChartConfig.globalSettings.titles[1].position = 'hide';
      myChartConfig.graphSettings.domainAxis.domainGrid.useValueGrid = false;
      myChartConfig.graphSettings.domainAxis.domainGrid.line = true;
      if (myChartConfig.graphSettings.multiDimensional && myChartConfig.graphSettings.multiDimensional.multiDim) {
        type = "MULTICURS";
        myObjConfig.multidimFixedScale = true;
        myChartConfig.graphSettings.multiDimensional.cursorType = "nodraw";
      }
      myChartConfig.globalSettings.height = myChartConfig.globalSettings.height/3;
      if (!loadextlibs)
        initSupportLibraries(weburl, type);
      var _this = getChartCtrl(type);
      _this.asZoomCursor = true;
      _this.UID = chartUID;
      _this.SetWebRootURL(weburl);
      _this.InitChart({
        ztChart: _ZtChart,
        chartConfig: myChartConfig,
        objConfig: myObjConfig,
        propertyName: pName,
        dataset: propertyValue,
        parent: parent, 
        fncObj: functionObj,
        lnkObj: linkObj, 
        chartId: mychartid + "_cursor", 
        container: chartContainer,
        noCalc: type == "MULTICURS"
      });
      _this.SetDataDraw();
      _this.SetChartDraw();
      return _this;
    }

    function getChartCtrl(type) {
      var cctrl = null;
      switch (type) {
        case "LINES":
        case "TIME":
          cctrl = new ZtLinesChart();
          break;
        case "HBAR":
        case "HBAR3D":
        case "VBAR":
        case "VBAR3D":
          cctrl = new ZtBarChart(type, type.indexOf("HBAR"), type.indexOf("BAR3D"));
          break;
        case "HSTACKBAR":
        case "HSTACKBAR3D":
        case "VSTACKBAR":
        case "VSTACKBAR3D":
          cctrl = new ZtStackBarChart(type, type.indexOf("HSTACK"), type.indexOf("BAR3D"));
          break;
        case "PIE":
        case "RING":
        case "PIE3D":
          cctrl = new ZtPieChart(type, type == "PIE3D");
          break;
        case "AREA":
          cctrl = new ZtAreaChart();
          break;
        case "STACKEDAREA":
          cctrl = new ZtStackAreaChart();
          break;
        case "TREEMAP":
          cctrl = new ZtTreeMapChart();
          break;
        case "TREEMAPBAR":
        case "TREEMAPBARH":
          cctrl = new ZtTreeMapBarChart(type, type.indexOf("BARH"));
          break;
        case "LAYEREDBAR":
        case "LAYEREDBARH":
          cctrl = new ZtLayeredBarChart(type, type.indexOf("BARH"));
          break;
        case "WATERF":
          cctrl = new ZtWaterfallChart();
          break;
        case "RADARLINE":
        case "RADARAREA":
          cctrl = new ZtRadarChart(type, type.indexOf("AREA"));
          break;
        case "SCATTER":
        case "BUBBLE":
          cctrl = new ZtXYZChart(type, type == "BUBBLE");
          break;
        case "PARETO":
          cctrl = new ZtParetoChart();
          break;
        case "WORDCLOUD":
          cctrl = new ZtWordChart();
          break;
        case "PYRAMID":
          cctrl = new ZtPyramidDistributionChart();
          break;
        case "ARCDIAL":
          cctrl = new ZtDialChart();
          break;
        case "THERMO":
          cctrl = new ZtThermoChart();
          break;
        case "LIGHTS":
          cctrl = new ZtLightsChart();
          break;
        case "IMAGES":
          cctrl = new ZtImageChart(type, type == "ICONS");
          break;
        case "DISPLAY":
        case "COUNTER":
        case "PADDLE":
          cctrl = new ZtDisplayChart(type);
          break;
        case "GEOMAP":
          cctrl = new ZtGeographicChart();
          break;
        case "MULTICURS":
          cctrl = new ZtMultiDimCursorChart();
          break;
        case "CONTAINER":
          cctrl = new ZtContainerChart();
          break;
        case "ASTER":
          cctrl = new ZtAsterChart();
          break;
        case "AREABAR":
          cctrl = new ZtAreaBarChart();
          break;
        case "SUNB":
        case "SUNBSTR":
          cctrl = new ZtSunburstChart(type);
          break;
        case "TREE":
        case "TREESTR":
          cctrl = new ZtTreeChart(type);
          break;
        case "CPACK":
        case "CPACKSTR":
          cctrl = new ZtCirclePackChart(type);
          break;
        case "FORCE":
        case "FORCESTR":
          cctrl = new ZtForceChart(type);
          break;
        case "MATRIX":
          cctrl = new ZtMatrixChart();
          break;
        case "CHORD":
          cctrl = new ZtChordChart();
          break;
        case "CAL":
          cctrl = new ZtCalendarChart();
          break;
        case "PYR":
        case "NECKEDPYR":
        case "PYRSTR":
        case "NECKEDPYRSTR":
          cctrl = new ZtPyramidChart(type);
          break;
        case "FUNNEL":
          cctrl = new ZtFunnelChart();
          break;
        case "MARIMEKKO":
          cctrl = new ZtMekkoChart();
          break;
        case "BCMATRIX":
          cctrl = new ZtBCMatrixChart();
          break;
        case "PCOORDS":
          cctrl = new ZtPCoordsChart();
          break;
        case "VORONOI":
          cctrl = new ZtVoronoiChart();
          break;
        case "SANKEY":
          cctrl = new ZtSankeyChart();
          break;
        case "RINGPERC":
          cctrl = new ZtRingPChart();
          break;
      }
      return cctrl;
    }

    function drawLoadingDiv(pdiv) {
	  var ldiv = document.getElementById(pdiv.id + "_svgChartLoading");
      if (Empty(ldiv)) {
        ldiv = document.createElement("DIV");
        ldiv.id = pdiv.id + "_svgChartLoading";
        ldiv.style.width = pdiv.offsetWidth + "px";
        ldiv.style.height = "100%";
        ldiv.style.position = "absolute";
        ldiv.style.zIndex = 2000;
        ldiv.style.backgroundColor = "#FFFFFF";
        ldiv.style.opacity = 1;
        ldiv.className = "spModalLayer loading no-backdrop";
        pdiv.appendChild(ldiv);
      }
      ldiv.style.display = "block";     
    }

    function evaluateChartType(type, objConfig) {
      var ttype = type;
      // tipologia CONTAINER
      if (type == "FORCESTR")
        return type;
      if (objConfig.mapSeries && !Empty(Object.keys(objConfig.mapSeries))) {
        var kl = Object.keys(objConfig.mapSeries),
        check = false;
        for (var i = 0; i < kl.length && !check; i++) {
          if (!Empty(objConfig.mapSeries[kl[i]].type) && objConfig.mapSeries[kl[i]].type != "default" && objConfig.mapSeries[kl[i]].type != type)
            check = true;
        }
        if (check)  // almeno una diversa dal tipo "base"
          ttype = "CONTAINER";
      }
      return ttype;
    }

    /**** creazione oggetto grafico ****/
    var uid = LibJavascript.AlfaKeyGen(5);
    this.StdChart = createChart(this.initialType, this, uid);
    if (!this.StdChart.asZoomCursor && !drawWithECharts) {
      uid = LibJavascript.AlfaKeyGen(5);
      this.StdChartCursor = createChartCursor(this.initialType, this, uid);
    }
  }
  /**** end ZtChart ****/
}