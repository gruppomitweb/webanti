/* exported
    tool
    doLoad setPropertiesID openFile resizeWindow toolbarPreview setToolbars togglerGadget
    loadChartWizard save newCurrentObj Help LoadCG SetColorGradient LoadCGb SetColorGradientB
    LoadCGs SetColorGradientS LoadTL SetTrendlines LoadGlobalFont LoadTickaxFont LoadLayoutFont
    LoadMultidimFont LoadDisplabFont LoadTitleFont LoadSubtitleFont LoadLegendFont SetPropFont
    chartPreview LoadAxislabFont LoadDomainaxFont LoadPercentaxFont LoadValuelabFont LoadWordCloudFont
    SetItemsFont getWrapperLeft LoadValueaxFont GetCurrentName getVdmParams GetRequestParams
    selectForm SaveChartConfiguration editDesc apply3D SaveChartNotes renderApi getRenderApiObjClass
    setCurrentObj LoadCGsc SetColorGradientSC isAdvMode switchConf initPropertiesDefaultValue
*/
var currentname = "", //nome della configurazione corrente
  newPropObj = null,
  tool = 'chart',
  notimooManager,
  chartName,
  m_bUpdated = false,
  canwrite = true,
  customChart = false,
  //pprev = false,
  defNotes = "",
  loadingNew = true,
  webroot = '../',
  advMode = true;

function doLoad(filename,custom) {
	appendOnlineFonts();
  document.body.onhelp = CancelHelp;
  notimooManager = new Notimoo({});
  customChart = custom;
  reset();
  loadingNew = Empty(filename);
  create_gadget_pane();
  document.getElementById('backcanvas').setStyle('display', 'block');
  document.getElementById("switchers").style.visibility = "visible";
  document.getElementById("switch-off").style.display = "none";
  windowResize();
  designToolbar();
  SetWidthHeight();
  var fnToDelayx;
	if (!Empty(filename)) {
		notimooManager.show({
			title : 'Notification message',
			message : 'loading chart ' + filename,
			visibleTime : 1000,
			width : 200
		});
		currentname = filename;
		var form = loadCHT(currentname,custom);
    form = setDefaultChart(form, webroot);
    fnToDelayx = function () {
      loadingNew = true;
      //if(form.editorSettings)
      //decodeDefEditor(form.editorSettings);
      if (form.globalSettings)
        decodeDefForm(form.globalSettings);
      if(form.graphSettings)
        decodeDefChart(form.graphSettings);
      if (Ctrl("srcform")) { Ctrl("srcform").value = currentname; }
      if (standalone) { document.title = currentname + " - Chart Editor"; }
      myChart = null;
      setgraph(form.graphSettings.chartType);
      writeHTML();
    };
	}
	else {
		notimooManager.show({
			title : 'Notification message',
			message : 'loading Chart Editor!',
			visibleTime : 1000,
			width : 200
		});
	}
	m_bUpdated = false;
	window.addEvent("keydown", function(e) {
		if (e.control && e.key=="s") { //CTRL-S
			e.stop();
			if (parent.saveTool) parent.saveTool();
		}
	});
	index = 0;
  var cPropToggler = Ctrl("common-resource-toggler");
  if (cPropToggler) {
    cPropToggler.click();
    cPropToggler.click();
  }
  if(fnToDelayx)
    fnToDelayx.delay(100);
  document.getElementById('graphtype_tab').style.display = 'none';

  if (lightmode == "edit") {
    document.getElementById("toolbar").className += " hidden";
    document.getElementById("charttypes").className += " toup";
    document.getElementById("backcanvas").className += " toup";
    document.getElementById("switchers").className += " toup";
  }
  if (lightmode == "default") {
    document.getElementById("formproperties_cApi").style.visibility = "visible";
    document.getElementById("specificproperties_cApi").style.visibility = "visible";
  }
}

function appendOnlineFonts() {
  var fts = getAllFonts().online,
    link;
  for (var i = 0; i < fts.length; i++) {
    if (!Empty(fts[i])) {
      link = document.createElement('link');
      link.href = 'https://fonts.googleapis.com/css?family=' + Strtran(fts[i], ' ', '+');
      link.rel = 'stylesheet';
      link.type = 'text/css';
      document.head.appendChild(link);
    }
  }
}

function makeDefForm() {
  m_bUpdated = true;
  var obj = {};
  obj.width = parseInt(formProp.width);
  obj.height = parseInt(formProp.height);
  obj.graphColors = {};
  obj.graphColors.color = formProp.graphcolor;
  obj.globalFont = {};
  obj.globalFont.name = setFontFamily(formProp.gfont, formProp.online_gfont);
  obj.globalFont.size = parseInt(formProp.gsize);
  obj.globalFont.color = formProp.gcolor;
  obj.globalFont.style = formProp.gstyle;
  obj.titles = [];
  //titolo
  obj.titles.push({
    text: formProp.ttitle,
    useGlobalFont: CharToBool("" + formProp.tusecfont),
    textFont: {
      name: setFontFamily(formProp.tfont, formProp.online_tfont),
      size: parseInt(formProp.tsize),
      color: formProp.tcolor,
      style: formProp.tstyle
    },
    position: formProp.ttitlepos,
    alignment: formProp.ttitleali
  });
  //legenda
  obj.titles.push({
    useGlobalFont: CharToBool("" + formProp.lusecfont),
    textFont: {
      name: setFontFamily(formProp.lfont, formProp.online_lfont),
      size: parseInt(formProp.lsize),
      color: formProp.lcolor,
      style: formProp.lstyle
    },
    position: formProp.legendpos,
    alignment: formProp.legendali,
    useGraphColors: CharToBool("" + formProp.lusebkgc),
    extendColors: { color: formProp.legendcolor },
    extendLine: { color: formProp.llinecolor, stroke: parseFloat(formProp.llinestroke) },
    icon: formProp.legendicon,
    valueInside: formProp.valueinlegend
  });
  //sottotitolo: per ora previsto uno solo
  obj.titles.push({
    text: formProp.stitle,
    useGlobalFont: CharToBool("" + formProp.susecfont),
    textFont: {
      name: setFontFamily(formProp.sfont, formProp.online_sfont),
      size: parseInt(formProp.ssize),
      color: formProp.scolor,
      style: formProp.sstyle
    },
    position: formProp.stitlepos,
    alignment: formProp.stitleali,
    useGraphColors: false,
    extendColors: { color: "", gradient: "" },
    extendLine: { color: "", stroke: 1 },
    positionOrder: formProp.stitleorder,
    icon: ""
  });

  if (advMode) {
    obj.imageType = formProp.imagetype;
    obj.description = formProp.description;
    obj.transparency = parseInt(formProp.transparency);
    obj.graphColors.gradient = formProp.graphgradient;
    obj.chartColors = {};
    obj.chartColors.color = formProp.chartcolor;
    obj.chartColors.gradient = formProp.chartgradient;
    obj.chartColors.borderColor = formProp.bordercolor;
    obj.patterns = {};
    obj.patterns.negative = {};
    obj.patterns.negative.type = formProp.negpattern;
    obj.patterns.negative.color = formProp.negpatterncolor;
    obj.patterns.outrange = {};
    obj.patterns.outrange.type = formProp.outpattern;
    obj.patterns.outrange.color = formProp.outpatterncolor;
    obj.fileVersion = defversion; //la versione da salvare dovrebbe essere l'ultima
    // titolo
    obj.titles[0].useGraphColors = false;
    obj.titles[0].extendColors = { color: "", gradient: "" };
    obj.titles[0].extendLine = { color: "", stroke: 1 };
    obj.titles[0].positionOrder = "";
    obj.titles[0].icon = "";
    // legenda
    obj.titles[1].text = formProp.ltitle;
    obj.titles[1].extendColors.gradient = formProp.legendgradient;
    obj.titles[1].positionOrder = "";
    obj.titles[1].showLegendButtonWhen = parseFloat(formProp.showLegendButtonWhen);
    obj.titles[1].limitUnitPerc = CharToBool("" + formProp.lpercbtn);
    //legenda range
    obj.titles.push({
      text: formProp.rbltitle,
      useLegendFont: CharToBool("" + formProp.rblusecfont),
      textFont: {
        name: setFontFamily(formProp.rblfont, formProp.online_rblfont),
        size: parseInt(formProp.rblsize),
        color: formProp.rblcolor,
        style: formProp.rblstyle
      },
      position: formProp.rblegendpos,
      alignment: formProp.rblegendali,
      useLegendColors: CharToBool("" + formProp.rblusebkgc),
      extendColors: { color: formProp.rblegendcolor, gradient: formProp.rblegendgradient },
      extendLine: { color: formProp.rbllinecolor, stroke: parseFloat(formProp.rbllinestroke) },
      positionOrder: "",
      showLegendButtonWhen: parseFloat(formProp.rbshowLegendButtonWhen),
      limitUnitPerc: CharToBool("" + formProp.rblpercbtn),
      icon: ""
    });
  }
  obj.advMode = advMode;
  return obj;
}

function makeDefChart() {
  m_bUpdated = true;
  var i,
  obj = {},
  prop;
  obj.chartType = setChartType(itemsHTML[0].ctype);
  obj.hoverColor = formProp.hovercolor;
  var ccolor = formProp.colourseries.split(';');
  var cgradient = formProp.gradientseries.split(';');
  obj.colorSeries = [];
  if (formProp.colourseries.length > 0) {
    for (i = 0; i < ccolor.length; i++) {
      obj.colorSeries.push({ color: ccolor[i], gradient: cgradient[i] });
    }
  }
  obj.animate = CharToBool("" + itemsHTML[0].animate);
  obj.durationAnimation = parseInt(itemsHTML[0].durationAnimation);
  obj.axisLabel = {};
  obj.axisLabel.xLabel = itemsHTML[0].xlabel;
  obj.axisLabel.yLabel = itemsHTML[0].ylabel;
  obj.axisLabel.percentLabel = itemsHTML[0].percentLabel;
  obj.axisLabel.useGlobalFont = CharToBool("" + itemsHTML[0].ausecfont);
  obj.axisLabel.axisFont = {};
  obj.axisLabel.axisFont.name = setFontFamily(itemsHTML[0].afont, itemsHTML[0].online_afont);
  obj.axisLabel.axisFont.size = parseInt(itemsHTML[0].asize);
  obj.axisLabel.axisFont.color = itemsHTML[0].acolor;
  obj.axisLabel.axisFont.style = itemsHTML[0].astyle;
  obj.valueAxis = {};
  obj.valueAxis.minValue = itemsHTML[0].vminvalue;
  obj.valueAxis.maxValue = itemsHTML[0].vmaxvalue;
  obj.valueAxis.tick = parseFloat(itemsHTML[0].vtickunit);
  obj.valueAxis.show = CharToBool("" + itemsHTML[0].vshow);
  obj.valueAxis.useGlobalFont = CharToBool("" + itemsHTML[0].vusecfont);
  obj.valueAxis.valueFont = {};
  obj.valueAxis.valueFont.name = setFontFamily(itemsHTML[0].vfont, itemsHTML[0].online_vfont);
  obj.valueAxis.valueFont.size = parseInt(itemsHTML[0].vsize);
  obj.valueAxis.valueFont.color = itemsHTML[0].vcolor;
  obj.valueAxis.valueFont.style = itemsHTML[0].vstyle;
  obj.valueAxis.valueLine = {};
  obj.valueAxis.valueLine.color = itemsHTML[0].vlinecolor;
  obj.valueAxis.valueLine.stroke = parseFloat(itemsHTML[0].vlinestroke);
  obj.valueAxis.valueGrid = {};
  obj.valueAxis.valueGrid.line = CharToBool("" + itemsHTML[0].vgridline);
  obj.valueAxis.valueGrid.color = itemsHTML[0].vgridlinecolor;
  obj.valueAxis.valueGrid.type = itemsHTML[0].vgridlinetype;
  obj.domainAxis = {};
  obj.domainAxis.labelType = isAdvMode() ? itemsHTML[0].dlabeltype : itemsHTML[0].dlabeltypealt;
  obj.domainAxis.show = CharToBool("" + itemsHTML[0].dshow);
  switch (itemsHTML[0].dusefont) {
    case "value":
      obj.domainAxis.useValueFont = true;
      obj.domainAxis.useGlobalFont = false;
      break;
    case "global":
      obj.domainAxis.useValueFont = false;
      obj.domainAxis.useGlobalFont = true;
      break;
    default:  // custom
      obj.domainAxis.useValueFont = false;
      obj.domainAxis.useGlobalFont = false;
      break;
  }
	obj.domainAxis.domainFont = {};
	obj.domainAxis.domainFont.name = setFontFamily(itemsHTML[0].dfont, itemsHTML[0].online_dfont);
	obj.domainAxis.domainFont.size = parseInt(itemsHTML[0].dsize);
	obj.domainAxis.domainFont.color = itemsHTML[0].dcolor;
	obj.domainAxis.domainFont.style = itemsHTML[0].dstyle;
	obj.domainAxis.useValueLine = CharToBool("" + itemsHTML[0].dusevaxisline);
	obj.domainAxis.domainLine = {};
	obj.domainAxis.domainLine.color = itemsHTML[0].dlinecolor;
	obj.domainAxis.domainLine.stroke = parseFloat(itemsHTML[0].dlinestroke);
  obj.domainAxis.domainGrid = {};
  switch(itemsHTML[0].dusegrid){
    case "value":
      obj.domainAxis.useValueGrid = true;
      obj.domainAxis.domainGrid.line = false;
      break;
    case "show":
      obj.domainAxis.useValueGrid = false;
      obj.domainAxis.domainGrid.line = true;
      break;
    default:  // hide
      obj.domainAxis.useValueGrid = false;
      obj.domainAxis.domainGrid.line = false;
      break;
  }
	obj.domainAxis.domainGrid.color = itemsHTML[0].dgridlinecolor;
	obj.domainAxis.domainGrid.type = itemsHTML[0].dgridlinetype;
	obj.percentAxis={};
	obj.percentAxis.maxValue = (itemsHTML[0].pmaxValue===null)?itemsHTML[0].pmaxValue:parseInt(itemsHTML[0].pmaxValue);
	obj.percentAxis.percentageReference = parseInt(itemsHTML[0].percentageReference);
	obj.percentAxis.show = CharToBool("" + itemsHTML[0].pshow);
  switch(itemsHTML[0].pusefont){
    case "value":
      obj.percentAxis.useValueFont = true;
      obj.percentAxis.useGlobalFont = false;
      break;
    case "global":
      obj.percentAxis.useValueFont = false;
      obj.percentAxis.useGlobalFont = true;
      break;
    default:  // custom
      obj.percentAxis.useValueFont = false;
      obj.percentAxis.useGlobalFont = false;
      break;
  }
  obj.percentAxis.percentFont = {};
  obj.percentAxis.percentFont.name = setFontFamily(itemsHTML[0].pfont, itemsHTML[0].online_pfont);
  obj.percentAxis.percentFont.size = parseInt(itemsHTML[0].psize);
  obj.percentAxis.percentFont.color = itemsHTML[0].pcolor;
  obj.percentAxis.percentFont.style = itemsHTML[0].pstyle;
  obj.percentAxis.useValueLine = CharToBool("" + itemsHTML[0].pusevaxisline);
  obj.percentAxis.percentLine = {};
  obj.percentAxis.percentLine.color = itemsHTML[0].plinecolor;
  obj.percentAxis.percentLine.stroke = parseFloat(itemsHTML[0].plinestroke);
  obj.valueLabel = {};
  obj.valueLabel.type = itemsHTML[0].valuetype;
  obj.valueLabel.show = itemsHTML[0].valueshow;
  setValueLabelPosition(obj.valueLabel, itemsHTML[0]);
  obj.valueLabel.useGlobalFont = CharToBool("" + itemsHTML[0].wusecfont);
  obj.valueLabel.labelFont = {};
  obj.valueLabel.labelFont.name = setFontFamily(itemsHTML[0].wfont, itemsHTML[0].online_wfont);
  obj.valueLabel.labelFont.size = parseInt(itemsHTML[0].wsize);
  obj.valueLabel.labelFont.color = itemsHTML[0].wcolor;
  obj.valueLabel.labelFont.style = itemsHTML[0].wstyle;
  obj.shape = {};
  prop = "drawshapes";
  if (!isAdvMode())
    prop = "drawshapesalt";
  switch (itemsHTML[0][prop]) {
    case "hide":
      obj.shape.draw = false;
      obj.shape.fill = false;
      break;
    case "fill":
    case "draw":
      obj.shape.draw = true;
      obj.shape.fill = true;
      break;
    default:
      obj.shape.draw = true;
      obj.shape.fill = false;
      break;
  }
  obj.shape.size = parseInt(itemsHTML[0].sizeshapes);
  obj.shape.type = itemsHTML[0].sizetypeshapes;
  obj.shape.onlyShapes = CharToBool("" + itemsHTML[0].shapeline);
  obj.shape.differSeries = CharToBool("" + itemsHTML[0].shapeserie);
  obj.slice = {};
  obj.slice.percent = parseInt(itemsHTML[0].slicepercent);
  obj.slice.type = itemsHTML[0].slicetype;
  obj.bars = {};
  obj.bars.margins = parseInt(itemsHTML[0].barmargins);
  obj.bars.shadow = {};
  obj.bars.shadow.x = itemsHTML[0].xshadow;
  obj.bars.shadow.y = itemsHTML[0].yshadow;
  obj.bars.shadow.color = itemsHTML[0].shadowcolor;
  obj.bars.barsLine = {};
  ccolor = itemsHTML[0].outlinecolour ? itemsHTML[0].outlinecolour.split(';') : [];
  cgradient = itemsHTML[0].outlinegradient ? itemsHTML[0].outlinegradient.split(';') : [];
  obj.bars.barsLine.colorSeries = [];
  if (ccolor.length > 0) {
    for (i = 0; i < ccolor.length; i++) {
      obj.bars.barsLine.colorSeries.push({ color: ccolor[i], gradient: cgradient[i] });
    }
  }
  obj.normalized = CharToBool("" + itemsHTML[0].normalized);
  obj.multiDimensional = {};
  obj.multiDimensional.multiDim = CharToBool("" + itemsHTML[0].multiDim);
  obj.multiDimensional.position = itemsHTML[0].cursorPosition;
  obj.multiDimensional.alignment = itemsHTML[0].cursorAlignment;
  obj.multiDimensional.cursorType = itemsHTML[0].cursorType;
  obj.multiDimensional.autoChange = CharToBool("" + itemsHTML[0].autoChange);
  obj.multiDimensional.axis = {};
  obj.multiDimensional.axis.color = itemsHTML[0].ccolor;
  obj.multiDimensional.axis.stroke = parseFloat(itemsHTML[0].cstroke);
  obj.multiDimensional.useGlobalFont = CharToBool("" + itemsHTML[0].cusecfont);
  obj.bars.barsLine.stroke = parseFloat(itemsHTML[0].outlinestroke);
  obj.bars.oneColor = itemsHTML[0].onecolourbar;
  obj.bars.defaultGradient = itemsHTML[0].remdefaultgradient;
  obj.line = {};
  obj.line.color = itemsHTML[0].lineColor;
  obj.line.stroke = parseFloat(itemsHTML[0].wlinestroke);
  obj.line.position = itemsHTML[0].linePosition;
  obj.time = {};
  obj.time.format = itemsHTML[0].tiformat;
  obj.time.unit = itemsHTML[0].tdomainunit;
  obj.time.value = parseInt(itemsHTML[0].tdomainvalue);
  obj.time.dateLimit = itemsHTML[0].tdatelimit;
  obj.radar = {};
  obj.radar.startAngle = parseInt(itemsHTML[0].startangle);
  obj.radar.dataOrder = itemsHTML[0].dataorder;
  obj.radar.plot = itemsHTML[0].plotdirection;
  obj.pointCap = {};
  obj.pointCap.type = itemsHTML[0].pointertype;
  obj.pointCap.radius = parseFloat(itemsHTML[0].pointerradius);
  obj.pointCap.capRadius = parseFloat(itemsHTML[0].capradius);
  obj.pointCap.baseRadius = parseFloat(itemsHTML[0].pointerbase);
  obj.scale = {};
  obj.scale.tickRadius = parseFloat(itemsHTML[0].scaletickradius);
  obj.scale.tickLabelOffset = parseFloat(itemsHTML[0].scaleticklabeloffset);
  obj.scale.majorIncrement = parseFloat(itemsHTML[0].majortickincrement);
  obj.scale.minorCount = parseFloat(itemsHTML[0].minortickcount);
  obj.line.extArea = CharToBool("" + itemsHTML[0].extarea);
  obj.radius = {};
  obj.radius.inner = parseFloat(itemsHTML[0].ringradin);
  obj.radius.outer = parseFloat(itemsHTML[0].ringradout);
  obj.pointCap.pointer = {};
  obj.pointCap.pointer.color = (obj.chartType == "GEOMAP") ? itemsHTML[0].mapundefcol : itemsHTML[0].pointfillcolor;
  obj.pointCap.pointer.extendLine = {};
  obj.pointCap.pointer.extendLine.color = (obj.chartType == "GEOMAP") ? itemsHTML[0].mapundefstr : itemsHTML[0].pointlinecolor;
  obj.pointCap.pointer.extendLine.stroke = parseFloat(itemsHTML[0].pointlinestroke);
  obj.pointCap.cap = {};
  obj.pointCap.cap.color = itemsHTML[0].capfillcolor;
  obj.pointCap.cap.extendLine = {};
  obj.pointCap.cap.extendLine.color = itemsHTML[0].caplinecolor;
  obj.pointCap.cap.extendLine.stroke = parseFloat(itemsHTML[0].caplinestroke);
  obj.tickAxis = {};
  obj.tickAxis.minValue = (itemsHTML[0].scaleminvalue == null) ? itemsHTML[0].scaleminvalue : parseFloat(itemsHTML[0].scaleminvalue);
  obj.tickAxis.maxValue = (itemsHTML[0].scalemaxvalue == null) ? itemsHTML[0].scalemaxvalue : parseFloat(itemsHTML[0].scalemaxvalue);
  obj.tickAxis.dataValue = parseFloat(itemsHTML[0].scaledatavalue);
  obj.tickAxis.extendAngle = {};
  obj.tickAxis.extendAngle.start = parseFloat(itemsHTML[0].startdeg);
  obj.tickAxis.extendAngle.end = parseFloat(itemsHTML[0].enddeg);
  obj.tickAxis.useGlobalFont = CharToBool("" + itemsHTML[0].tausecfont);
  obj.tickAxis.show = CharToBool("" + itemsHTML[0].tishow);
  obj.tickAxis.tickFont = {};
  obj.tickAxis.tickFont.name = setFontFamily(itemsHTML[0].tafont, itemsHTML[0].online_tafont);
  obj.tickAxis.tickFont.size = parseInt(itemsHTML[0].tasize);
  obj.tickAxis.tickFont.color = itemsHTML[0].tacolor;
  obj.tickAxis.tickFont.style = itemsHTML[0].tastyle;
  obj.range = getRangeBandsObj(itemsHTML[0].rangebands);
  obj.pointCap.pointer.rangeColor = CharToBool("" + itemsHTML[0].trendlinesv);
  obj.gauge = {};
  obj.gauge.extendLine = {};
  obj.gauge.extendLine.color = itemsHTML[0].gbordercolor;
  obj.gauge.extendLine.stroke = parseFloat(itemsHTML[0].gborderstroke);
  obj.gauge.extendAngle = {};
  obj.gauge.extendAngle.start = parseFloat(itemsHTML[0].gstartdeg);
  obj.gauge.extendAngle.end = parseFloat(itemsHTML[0].genddeg);
  obj.gauge.orientation = itemsHTML[0].gaugeorient;
  obj.reuseColorSeries = CharToBool("" + formProp.reusecolourseries);
  obj.bars.barsLine.reuseColorSeries = CharToBool("" + itemsHTML[0].reuseoutlineseries);
  obj.gauge.fillColor = itemsHTML[0].gfillcolor;
  obj.gauge.fanlights = CharToBool("" + itemsHTML[0].gfanlights);
  obj.gauge.type = itemsHTML[0].gaugestyle;
  obj.gauge.lightEffect = itemsHTML[0].geffect;
  obj.gauge.digits = parseInt(itemsHTML[0].digitNum);
  obj.waterfall = {};
  obj.waterfall.showTotal = CharToBool("" + itemsHTML[0].showTot);
  obj.waterfall.totalColors = {};
  obj.waterfall.totalColors.color = itemsHTML[0].totalCol;
  obj.waterfall.totalColors.gradient = itemsHTML[0].totalGrad;
  obj.waterfall.totalLabel = itemsHTML[0].totalLabel;
  obj.waterfall.startLabel = itemsHTML[0].startLabel;
  obj.waterfall.startValue = parseFloat(itemsHTML[0].startValue);
  obj.line.type = itemsHTML[0].lineType;
  obj.time.dataType = itemsHTML[0].datatype;
  obj.time.customFormat = itemsHTML[0].tcustformat;
  obj.displayLabel = {};
  obj.displayLabel.displayFont = {};
  obj.displayLabel.displayFont.name = setFontFamily(itemsHTML[0].dispfont, itemsHTML[0].online_dispfont);
  obj.displayLabel.displayFont.size = parseInt(itemsHTML[0].dispsize);
  obj.displayLabel.displayFont.color = itemsHTML[0].dispcolor;
  obj.displayLabel.displayFont.style = itemsHTML[0].dispstyle;
  obj.valueAxis.showAxis = CharToBool("" + itemsHTML[0].vshowaxis);
  obj.layout = {};
  obj.layout.useGlobalFont = CharToBool("" + itemsHTML[0].wcusecfont);
  obj.layout.wcFont = {};
  obj.layout.wcFont.name = setFontFamily(itemsHTML[0].wcfont, itemsHTML[0].online_wcfont);
  obj.layout.wcFont.minSize = parseInt(itemsHTML[0].minfont);
  obj.layout.wcFont.style = itemsHTML[0].wcstyle;
  obj.layout.minOrientation = parseInt(itemsHTML[0].minorientation);
  obj.layout.maxOrientation = parseInt(itemsHTML[0].maxorientation);
  obj.layout.anglesCount = parseInt(itemsHTML[0].anglescount);
  obj.fillTransparency = CharToBool("" + itemsHTML[0].remfilltransp);
  obj.pointCap.pointer.rangeGradient = itemsHTML[0].rangegrad;
  obj.valueAxis.precision = parseInt(itemsHTML[0].vprecision);
  obj.domainAxis.precision = parseInt(itemsHTML[0].dprecision);
	obj.map = {};
  obj.map.definition = itemsHTML[0].mapdef;
  obj.pointCap.pointer.rangeType = itemsHTML[0].rangetype;
  obj.chartTooltips = itemsHTML[0].chartTooltips;
  obj.valueLabel.totalLabel = {};
  obj.valueLabel.totalLabel.show = CharToBool("" + itemsHTML[0].showTotVL);
  obj.valueLabel.totalLabel.useGlobalFont = CharToBool("" + itemsHTML[0].wusecfonttot);
  obj.valueLabel.totalLabel.totalLabelFont = {};
  obj.valueLabel.totalLabel.totalLabelFont.name = setFontFamily(itemsHTML[0].wfonttot, itemsHTML[0].online_wfonttot);
  obj.valueLabel.totalLabel.totalLabelFont.size = itemsHTML[0].wsizetot;
  obj.valueLabel.totalLabel.totalLabelFont.color = itemsHTML[0].wcolortot;
  obj.valueLabel.totalLabel.totalLabelFont.style = itemsHTML[0].wstyletot;
  obj.valueLabel.totalLabel.precision = parseInt(itemsHTML[0].wprec);
  ccolor = itemsHTML[0].shapesseriescol ? itemsHTML[0].shapesseriescol.split(';') : [];
  obj.shape.colorSeries = [];
  if (ccolor.length > 0) {
    for (i = 0; i < ccolor.length; i++) {
      obj.shape.colorSeries.push({ color: ccolor[i], gradient: "" });
    }
  }
  obj.shape.stroke = parseInt(itemsHTML[0].shapesstroke);
  obj.valueLabel.applyPicture = CharToBool("" +itemsHTML[0].applypicture);
  obj.multiDimensional.subdivision = itemsHTML[0].multisubdivision;
  obj.multiDimensional.subdivisionHeight = parseFloat(itemsHTML[0].multisubheight);
  obj.treemap = {};
  obj.treemap.dataGroupBy = itemsHTML[0].trgroupby;
  obj.treemap.dataOrder = itemsHTML[0].trorder;
  obj.treemap.tileStyle = itemsHTML[0].trtile;
  obj.treemap.innerPadding = parseInt(itemsHTML[0].trinpadding);
  obj.treemap.outerPadding = parseInt(itemsHTML[0].troutpadding);
  obj.gauge.imageType = itemsHTML[0].imageset;
  obj.shape.figure = isAdvMode() ? itemsHTML[0].shapetype : itemsHTML[0].shapetypealt;
  obj.selectionOptions = {};
  obj.selectionOptions.opacity = itemsHTML[0].unseltr;
  obj.selectionOptions.color = itemsHTML[0].unselcol;
  obj.useColorSeriesForEach = CharToBool("" + formProp.usecseach);
  obj.valueLabel.showZero = CharToBool("" + itemsHTML[0].vlzero);
  obj.hierarchy = {};
  obj.hierarchy.breadcrumb = {};
  obj.hierarchy.breadcrumb.show = CharToBool("" + itemsHTML[0].showbc);
  obj.hierarchy.breadcrumb.layout = itemsHTML[0].layoutbc;
  obj.hierarchy.showRoot = CharToBool("" + itemsHTML[0].showroot);
  obj.hierarchy.hoverPath = itemsHTML[0].hoverpath;
  if (itemsHTML[0].ctype == "ASTER")
    obj.radius.inner = parseFloat(itemsHTML[0].innradius);
  obj.extends = {};
  obj.extends.treeLayout = itemsHTML[0].treelayout;
  obj.gauge.fitSize = CharToBool("" + itemsHTML[0].fitSize);
  obj.extends.matrix = {};
  obj.extends.matrix.emptyCell = itemsHTML[0].emptyCell;
  obj.extends.matrix.grid = {};
  obj.extends.matrix.grid.view = itemsHTML[0].mgridview;
  obj.extends.matrix.grid.stroke = parseInt(itemsHTML[0].mgridstroke);
  obj.extends.matrix.grid.color = itemsHTML[0].mgridcolor;
  obj.extends.matrix.grid.type = itemsHTML[0].mgridtype;
  obj.extends.matrix.orientationColor = itemsHTML[0].ordercol;
  obj.extends.matrix.domainAxisMatrix = itemsHTML[0].daxismatrix
  obj.extends.pyramid = {};
  obj.extends.pyramid.height = parseInt(itemsHTML[0].hfunnel);
  obj.extends.pyramid.width = parseInt(itemsHTML[0].wfunnel);
  obj.extends.pyramid.rotation = itemsHTML[0].pyramidrotation;
  obj.extends.funnel = {};
  obj.extends.funnel.type = itemsHTML[0].funneltype;
  obj.extends.voronoi = {};
  obj.extends.voronoi.links = {};
  obj.extends.voronoi.links.show = CharToBool("" + itemsHTML[0].vorolinks);
  obj.extends.voronoi.links.color = itemsHTML[0].vorolinksColor
  obj.extends.voronoi.links.stroke = parseInt(itemsHTML[0].vorolinksStroke);
  obj.extends.voronoi.links.type = itemsHTML[0].vorolinksType;
  obj.extends.sankey = {};
  obj.extends.sankey.nodes = {};
  obj.extends.sankey.order = itemsHTML[0].sandataorder;
  obj.extends.sankey.position = itemsHTML[0].layoutpos;
  obj.extends.sankey.nodes.width = itemsHTML[0].nodewidth;
  obj.extends.sankey.nodes.padding = itemsHTML[0].nodepadding;
  obj.extends.sankey.valueLabel = {};
  obj.extends.sankey.valueLabel.middlePosition = itemsHTML[0].middlabpos;
  obj.extends.sankey.valueLabel.firstlastPosition = itemsHTML[0].firstlastlabpos;
  obj.extends.quadrants = {};
  obj.extends.quadrants.labels = {};
  obj.extends.quadrants.labels.type = itemsHTML[0].qlabels;
  obj.extends.quadrants.labels.position = itemsHTML[0].qlabelspos;
  obj.extends.quadrants.labels.alignment = itemsHTML[0].qlabelsali;
  obj.extends.quadrants.labels.useGlobalFont = CharToBool("" + itemsHTML[0].qusefont);
  obj.extends.quadrants.labels.font = {};
  obj.extends.quadrants.labels.font.name = setFontFamily(itemsHTML[0].qfont, itemsHTML[0].online_qfont);
  obj.extends.quadrants.labels.font.size = itemsHTML[0].qsize;
  obj.extends.quadrants.labels.font.color = itemsHTML[0].qcolor;
  obj.extends.quadrants.labels.font.style = itemsHTML[0].qstyle;
  ccolor = itemsHTML[0].qcolors ? itemsHTML[0].qcolors.split(';') : [];
  obj.extends.quadrants.colorSeries = [];
  if (ccolor.length > 0) {
    for (i = 0; i < ccolor.length; i++) {
      obj.extends.quadrants.colorSeries.push({ color: ccolor[i], gradient: "" });
    }
  }
  obj.overlap = {};
  obj.overlap.type = itemsHTML[0].oltype;
  obj.overlap.radius = itemsHTML[0].olrad;
  obj.overlap.color = itemsHTML[0].olcolor;
  obj.extends.quadrants.labels.precision = {};
  obj.extends.quadrants.labels.precision.value = parseInt(itemsHTML[0].qvalprec);
  obj.extends.quadrants.labels.precision.percentage = parseInt(itemsHTML[0].qperprec);
  obj.extends.styles = {};
  obj.extends.styles.lights = itemsHTML[0].lights_layout;
  obj.valueLabel.valuePrecision = parseInt(itemsHTML[0].vl_vprec);
  obj.valueLabel.percPrecision = parseInt(itemsHTML[0].vl_pprec);
  obj.extends.styles.display = itemsHTML[0].display_layout;
  ccolor = itemsHTML[0].shapescols ? itemsHTML[0].shapescols.split(';') : [];
  obj.shape.fillColorSeries = [];
  if (ccolor.length > 0) {
    for (i = 0; i < ccolor.length; i++) {
      obj.shape.fillColorSeries.push({ color: ccolor[i], gradient: "" });
    }
  }
  obj.shape.customFill = CharToBool(itemsHTML[0].shpapply + "");
  obj.bars.maxWidth = parseInt(itemsHTML[0].barmaxw);
  obj.extends.styles.ring = {};
  obj.extends.styles.ring.style = itemsHTML[0].ringperc_layout;
  obj.extends.styles.ring.background = itemsHTML[0].ringperc_bck;

  return obj;
}

function decodeDefForm(obj) {
	formProp.imagetype = obj.imageType;
	formProp.transparency = obj.transparency;
	formProp.version = obj.fileVersion||0;
  formProp.description = obj.description;
	//eventuali conversioni delle versioni - confrontare con variabile defversion
	if (obj.width > 0) { formProp.width = obj.width; }
	else { formProp.width = 400; }
	if (obj.height > 0) { formProp.height = obj.height; }
	else { formProp.height = 400; }
	formProp.graphcolor = obj.graphColors.color;
	formProp.graphgradient = obj.graphColors.gradient;
	var fontobj = getFontFamily(obj.globalFont.name, formProp.font_list);
	formProp.gfont = fontobj.offline;
	formProp.online_gfont = fontobj.online;
	formProp.gsize = obj.globalFont.size;
	formProp.gcolor = obj.globalFont.color;
	formProp.gstyle = obj.globalFont.style;
	formProp.chartcolor = obj.chartColors.color;
	formProp.chartgradient = obj.chartColors.gradient;
	formProp.bordercolor = obj.chartColors.borderColor;
	formProp.ttitle = obj.titles[0].text;
	formProp.tusecfont = obj.titles[0].useGlobalFont;
	fontobj = getFontFamily(obj.titles[0].textFont.name, formProp.font_list);
	formProp.tfont = fontobj.offline;
	formProp.online_tfont = fontobj.online;
	formProp.tsize = obj.titles[0].textFont.size;
	formProp.tcolor = obj.titles[0].textFont.color;
	formProp.tstyle = obj.titles[0].textFont.style;
	formProp.ttitlepos = obj.titles[0].position;
	formProp.ttitleali = obj.titles[0].alignment;
	formProp.legendpos = obj.titles[1].position;
	formProp.ltitle = obj.titles[1].text;
	formProp.legendali = obj.titles[1].alignment;
	formProp.lusecfont = obj.titles[1].useGlobalFont;
	fontobj = getFontFamily(obj.titles[1].textFont.name, formProp.font_list);
	formProp.lfont = fontobj.offline;
	formProp.online_lfont = fontobj.online;
	formProp.lsize = obj.titles[1].textFont.size;
	formProp.lcolor = obj.titles[1].textFont.color;
	formProp.lstyle = obj.titles[1].textFont.style;
	formProp.lusebkgc = obj.titles[1].useGraphColors;
	formProp.legendcolor = obj.titles[1].extendColors.color;
	formProp.legendgradient = obj.titles[1].extendColors.gradient;
	formProp.llinecolor = obj.titles[1].extendLine.color;
	formProp.llinestroke = obj.titles[1].extendLine.stroke;
	formProp.showLegendButtonWhen = obj.titles[1].showLegendButtonWhen;
	formProp.legendicon = obj.titles[1].icon;
	formProp.lpercbtn = obj.titles[1].limitUnitPerc;
	formProp.valueinlegend = obj.titles[1].valueInside;
	if(obj.titles[2]){
		formProp.stitle = obj.titles[2].text;
		formProp.susecfont = obj.titles[2].useGlobalFont;
		fontobj = getFontFamily(obj.titles[2].textFont.name, formProp.font_list);
		formProp.sfont = fontobj.offline;
		formProp.online_sfont = fontobj.online;
		formProp.ssize = obj.titles[2].textFont.size;
		formProp.scolor = obj.titles[2].textFont.color;
		formProp.sstyle = obj.titles[2].textFont.style;
		formProp.stitlepos = obj.titles[2].position;
		formProp.stitleali = obj.titles[2].alignment;
		formProp.stitleorder = obj.titles[2].positionOrder;
  }
  if(obj.titles[3]){
    formProp.rblegendpos = obj.titles[3].position;
    formProp.rbltitle = obj.titles[3].text;
    formProp.rblegendali = obj.titles[3].alignment;
		formProp.rblusecfont = obj.titles[3].useLegendFont;
		fontobj = getFontFamily(obj.titles[3].textFont.name, formProp.font_list);
    formProp.rblfont = fontobj.offline;
    formProp.online_rblfont = fontobj.online;
    formProp.rblsize = obj.titles[3].textFont.size;
    formProp.rblcolor = obj.titles[3].textFont.color;
    formProp.rblstyle = obj.titles[3].textFont.style;
    formProp.rblusebkgc = obj.titles[3].useGraphColors;
    formProp.rblegendcolor = obj.titles[3].extendColors.color;
    formProp.rblegendgradient = obj.titles[3].extendColors.gradient;
    formProp.rbllinecolor = obj.titles[3].extendLine.color;
    formProp.rbllinestroke = obj.titles[3].extendLine.stroke;
    formProp.rbshowLegendButtonWhen = obj.titles[3].showLegendButtonWhen;
    formProp.rblpercbtn = obj.titles[3].limitUnitPerc;
  }
  formProp=updateUserGroup(formProp);
  formProp.customChart=customChart;

 /* formProp.vpicture = obj.valuepicture.picture;
  formProp.vprefix = obj.valuepicture.prefix;
  formProp.vsuffix = obj.valuepicture.suffix;	*/
  formProp.negpattern = obj.patterns.negative.type;
  formProp.negpatterncolor = obj.patterns.negative.color;
  formProp.outpattern = obj.patterns.outrange.type;
  formProp.outpatterncolor = obj.patterns.outrange.color;

  if (!("advMode" in obj))  // def già presenti
    advMode = true;
  else
    advMode = CharToBool(obj.advMode + "");

  FormProperties(true);
}

function decodeDefChart(obj) {
  itemsHTML[0].ctype = decodeChartType(obj.chartType);
  formProp.hovercolor = obj.hoverColor;
  formProp.colourseries = "";
  formProp.gradientseries = "";
  var i;
  var grad = "";
	for (i = 0; i < obj.colorSeries.length-1; i++) {
		formProp.colourseries += obj.colorSeries[i].color + ";";
    grad = ""
    if(obj.colorSeries[i].gradient)
      grad = obj.colorSeries[i].gradient;
    formProp.gradientseries += grad + ";";
	}
	if (obj.colorSeries.length > 0) {
		formProp.colourseries += obj.colorSeries[i].color;
    grad = ""
    if(obj.colorSeries[i].gradient)
      grad = obj.colorSeries[i].gradient;
    formProp.gradientseries += grad;
  }
  itemsHTML[0].animate = obj.animate;
  itemsHTML[0].durationAnimation = obj.durationAnimation;
  itemsHTML[0].xlabel = obj.axisLabel.xLabel;
  itemsHTML[0].ylabel = obj.axisLabel.yLabel;
  itemsHTML[0].percentLabel = obj.axisLabel.percentLabel;
  itemsHTML[0].ausecfont = obj.axisLabel.useGlobalFont;
  var fontobj = getFontFamily(obj.axisLabel.axisFont.name, itemsHTML[0].font_list);
  itemsHTML[0].afont = fontobj.offline;
  itemsHTML[0].online_afont = fontobj.online;
  itemsHTML[0].asize = obj.axisLabel.axisFont.size;
  itemsHTML[0].acolor = obj.axisLabel.axisFont.color;
  itemsHTML[0].astyle = obj.axisLabel.axisFont.style;
  itemsHTML[0].vminvalue = obj.valueAxis.minValue;
  itemsHTML[0].vmaxvalue = obj.valueAxis.maxValue;
  itemsHTML[0].vtickunit = obj.valueAxis.tick;
  itemsHTML[0].vusecfont = obj.valueAxis.useGlobalFont;
  fontobj = getFontFamily(obj.valueAxis.valueFont.name, itemsHTML[0].font_list);
  itemsHTML[0].vfont = fontobj.offline;
  itemsHTML[0].online_vfont = fontobj.online;
  itemsHTML[0].vsize = obj.valueAxis.valueFont.size;
  itemsHTML[0].vcolor = obj.valueAxis.valueFont.color;
  itemsHTML[0].vstyle = obj.valueAxis.valueFont.style;
  itemsHTML[0].vlinecolor = obj.valueAxis.valueLine.color;
  itemsHTML[0].vlinestroke = obj.valueAxis.valueLine.stroke;
  itemsHTML[0].vgridline = obj.valueAxis.valueGrid.line;
  itemsHTML[0].vgridlinecolor = obj.valueAxis.valueGrid.color;
  itemsHTML[0].vgridlinetype = obj.valueAxis.valueGrid.type;
  itemsHTML[0].vshow = obj.valueAxis.show;
  itemsHTML[0].dshow = obj.domainAxis.show;
  if (isAdvMode())
    itemsHTML[0].dlabeltype = obj.domainAxis.labelType;
  else
    itemsHTML[0].dlabeltypealt = obj.domainAxis.labelType;
  if (obj.domainAxis.useValueFont)
    itemsHTML[0].dusefont = "value";
  else if(obj.domainAxis.useGlobalFont)
    itemsHTML[0].dusefont = "global";
  else
		itemsHTML[0].dusefont = "custom";
	fontobj = getFontFamily(obj.domainAxis.domainFont.name, itemsHTML[0].font_list);
	itemsHTML[0].dfont = fontobj.offline;
	itemsHTML[0].online_dfont = fontobj.online;
	itemsHTML[0].dsize = obj.domainAxis.domainFont.size;
	itemsHTML[0].dcolor = obj.domainAxis.domainFont.color;
	itemsHTML[0].dstyle = obj.domainAxis.domainFont.style;
	itemsHTML[0].dusevaxisline = obj.domainAxis.useValueLine;
	itemsHTML[0].dlinecolor = obj.domainAxis.domainLine.color;
	itemsHTML[0].dlinestroke = obj.domainAxis.domainLine.stroke;
  if(obj.domainAxis.useValueGrid)
    itemsHTML[0].dusegrid = "value";
  else if(obj.domainAxis.domainGrid.line)
    itemsHTML[0].dusegrid = "show";
  else
    itemsHTML[0].dusegrid = "hide";
	itemsHTML[0].dgridlinecolor = obj.domainAxis.domainGrid.color;
	itemsHTML[0].dgridlinetype = obj.domainAxis.domainGrid.type;
	itemsHTML[0].pmaxValue=obj.percentAxis.maxValue;
	itemsHTML[0].percentageReference=obj.percentAxis.percentageReference;
	// itemsHTML[0].pminValue=obj.percentAxis.minValue;
	itemsHTML[0].pshow=obj.percentAxis.show;
  if(obj.percentAxis.useValueFont)
    itemsHTML[0].pusefont = "value";
  else if(obj.percentAxis.useGlobalFont)
    itemsHTML[0].pusefont = "global";
  else
    itemsHTML[0].pusefont = "domain";
  itemsHTML[0].pfont = obj.percentAxis.percentFont.name
  itemsHTML[0].psize = obj.percentAxis.percentFont.size
  itemsHTML[0].pcolor = obj.percentAxis.percentFont.color
  itemsHTML[0].pstyle = obj.percentAxis.percentFont.style
  itemsHTML[0].pusevaxisline = obj.percentAxis.useValueLine
  itemsHTML[0].plinecolor = obj.percentAxis.percentLine.color
  itemsHTML[0].plinestroke = obj.percentAxis.percentLine.stroke
  itemsHTML[0].valuetype = obj.valueLabel.type;
  itemsHTML[0].valuetypepos = obj.valueLabel.position;
  itemsHTML[0].wusecfont = obj.valueLabel.useGlobalFont;
  fontobj = getFontFamily(obj.valueLabel.labelFont.name, itemsHTML[0].font_list);
  itemsHTML[0].wfont = fontobj.offline;
  itemsHTML[0].online_wfont = fontobj.online;
  itemsHTML[0].wsize = obj.valueLabel.labelFont.size;
  itemsHTML[0].wcolor = obj.valueLabel.labelFont.color;
  itemsHTML[0].wstyle = obj.valueLabel.labelFont.style;
  if (isAdvMode()) {
    if (obj.shape.fill)
      itemsHTML[0].drawshapes = "fill";
    else if (!obj.shape.fill && obj.shape.draw)
      itemsHTML[0].drawshapes = "outline";
    else
      itemsHTML[0].drawshapes = "hide";
  }
  else {
    if (obj.shape.draw)
      itemsHTML[0].drawshapesalt = "draw";
    else
      itemsHTML[0].drawshapesalt = "hide";
  }

  itemsHTML[0].sizeshapes = obj.shape.size;
  itemsHTML[0].sizetypeshapes = obj.shape.type;
  itemsHTML[0].shapeline = obj.shape.onlyShapes;
  itemsHTML[0].shapeserie = obj.shape.differSeries;
  itemsHTML[0].slicepercent = obj.slice.percent;
  itemsHTML[0].slicetype = obj.slice.type;
  itemsHTML[0].barmargins = obj.bars.margins;
  itemsHTML[0].xshadow = obj.bars.shadow.x;
  itemsHTML[0].yshadow = obj.bars.shadow.y;
  itemsHTML[0].shadowcolor = obj.bars.shadow.color;
  itemsHTML[0].outlinecolour = "";
  itemsHTML[0].outlinegradient = "";
  for (i = 0; i < obj.bars.barsLine.colorSeries.length - 1; i++) {
    itemsHTML[0].outlinecolour += obj.bars.barsLine.colorSeries[i].color + ";";
    itemsHTML[0].outlinegradient += obj.bars.barsLine.colorSeries[i].gradient + ";";
  }
  if (obj.bars.barsLine.colorSeries.length > 0) {
    itemsHTML[0].outlinecolour += obj.bars.barsLine.colorSeries[i].color;
    itemsHTML[0].outlinegradient += obj.bars.barsLine.colorSeries[i].gradient;
  }
  itemsHTML[0].outlinestroke = obj.bars.barsLine.stroke;
  itemsHTML[0].onecolourbar = obj.bars.oneColor;
  itemsHTML[0].remdefaultgradient = obj.bars.defaultGradient;
  itemsHTML[0].normalized = obj.normalized;
  itemsHTML[0].multiDim = obj.multiDimensional.multiDim;
  itemsHTML[0].cursorPosition = obj.multiDimensional.position;
  itemsHTML[0].cursorAlignment = obj.multiDimensional.alignment;
  itemsHTML[0].cursorType = obj.multiDimensional.cursorType;
  itemsHTML[0].autoChange = obj.multiDimensional.autoChange;
  itemsHTML[0].cusecfont = obj.multiDimensional.useGlobalFont;
  itemsHTML[0].ccolor = obj.multiDimensional.axis.color;
  itemsHTML[0].cstroke = obj.multiDimensional.axis.stroke;
  itemsHTML[0].wlinestroke = obj.line.stroke;
  itemsHTML[0].linePosition = obj.line.position;
  itemsHTML[0].lineColor = obj.line.color;
  itemsHTML[0].tiformat = obj.time.format;
  itemsHTML[0].tdomainunit = obj.time.unit;
  itemsHTML[0].tdomainvalue = obj.time.value;
  itemsHTML[0].tdatelimit = obj.time.dateLimit;
  itemsHTML[0].startangle = obj.radar.startAngle;
  itemsHTML[0].dataorder = obj.radar.dataOrder;
  itemsHTML[0].plotdirection = obj.radar.plot;
  itemsHTML[0].pointertype = obj.pointCap.type;
  itemsHTML[0].pointerradius = obj.pointCap.radius;
  itemsHTML[0].capradius = obj.pointCap.capRadius;
  itemsHTML[0].scaletickradius = obj.scale.tickRadius;
  itemsHTML[0].scaleticklabeloffset = obj.scale.tickLabelOffset;
  itemsHTML[0].majortickincrement = obj.scale.majorIncrement;
  itemsHTML[0].minortickcount = obj.scale.minorCount;
  itemsHTML[0].valuelabelpos = obj.valueLabel.position;
  itemsHTML[0].extarea = obj.line.extArea;
  itemsHTML[0].ringradin = obj.radius.inner;
  itemsHTML[0].ringradout = obj.radius.outer;
  itemsHTML[0].scaleminvalue = obj.tickAxis.minValue;
  itemsHTML[0].scalemaxvalue = obj.tickAxis.maxValue;
  itemsHTML[0].scaledatavalue = obj.tickAxis.dataValue;
  itemsHTML[0].startdeg = obj.tickAxis.extendAngle.start;
  itemsHTML[0].enddeg = obj.tickAxis.extendAngle.end;
  itemsHTML[0].pointfillcolor = obj.pointCap.pointer.color;
  itemsHTML[0].pointlinecolor = obj.pointCap.pointer.extendLine.color;
  itemsHTML[0].pointlinestroke = obj.pointCap.pointer.extendLine.stroke;
  itemsHTML[0].capfillcolor = obj.pointCap.cap.color;
  itemsHTML[0].caplinecolor = obj.pointCap.cap.extendLine.color;
  itemsHTML[0].caplinestroke = obj.pointCap.cap.extendLine.stroke;
  itemsHTML[0].rangebands = "";
  for (i = 0; i < obj.range.length; i++) {
    if (!(Empty(obj.range[i].label) && Empty(obj.range[i].minValue) && Empty(obj.range[i].maxValue) && Empty(obj.range[i].color) && Empty(obj.range[i].imageUrl))) {
      itemsHTML[0].rangebands += obj.range[i].label + ";";
      itemsHTML[0].rangebands += obj.range[i].minValue + "_" + obj.range[i].maxValue + ";";
      itemsHTML[0].rangebands += obj.range[i].color + ";";
      itemsHTML[0].rangebands += obj.range[i].percent + ";";
      itemsHTML[0].rangebands += obj.range[i].imageUrl + "|";
    }
  }
  itemsHTML[0].rangebands = itemsHTML[0].rangebands.substring(0, itemsHTML[0].rangebands.length - 1);	// tolgo ultimo pipe
  itemsHTML[0].tausecfont = obj.tickAxis.useGlobalFont;
  itemsHTML[0].tishow = obj.tickAxis.show;
  fontobj = getFontFamily(obj.tickAxis.tickFont.name, itemsHTML[0].font_list);
  itemsHTML[0].tafont = fontobj.offline;
  itemsHTML[0].online_tafont = fontobj.online;
  itemsHTML[0].tasize = obj.tickAxis.tickFont.size;
  itemsHTML[0].tacolor = obj.tickAxis.tickFont.color;
  itemsHTML[0].tastyle = obj.tickAxis.tickFont.style;
  itemsHTML[0].gbordercolor = obj.gauge.extendLine.color;
  itemsHTML[0].gborderstroke = obj.gauge.extendLine.stroke;
  itemsHTML[0].gstartdeg = obj.gauge.extendAngle.start;
  itemsHTML[0].genddeg = obj.gauge.extendAngle.end;
  itemsHTML[0].trendlinesv = obj.pointCap.pointer.rangeColor;
  itemsHTML[0].gaugeorient = obj.gauge.orientation;
  formProp.reusecolourseries = obj.reuseColorSeries;
  itemsHTML[0].reuseoutlineseries = obj.bars.barsLine.reuseColorSeries;
  itemsHTML[0].gfillcolor = obj.gauge.fillColor;
  itemsHTML[0].gfanlights = obj.gauge.fanlights;
  itemsHTML[0].gaugestyle = obj.gauge.type;
  itemsHTML[0].geffect = obj.gauge.lightEffect;
  itemsHTML[0].digitNum = obj.gauge.digits;
  itemsHTML[0].showTot = obj.waterfall.showTotal;
  itemsHTML[0].totalCol = obj.waterfall.totalColors.color;
  itemsHTML[0].totalGrad = obj.waterfall.totalColors.gradient;
  itemsHTML[0].totalLabel = obj.waterfall.totalLabel;
  itemsHTML[0].startLabel = obj.waterfall.startLabel;
  itemsHTML[0].startValue = obj.waterfall.startValue;
  itemsHTML[0].lineType = obj.line.type;
  itemsHTML[0].datatype = obj.time.dataType;
  itemsHTML[0].tcustformat = obj.time.customFormat;
  fontobj = getFontFamily(obj.displayLabel.displayFont.name, itemsHTML[0].font_list);
  itemsHTML[0].dispfont = fontobj.offline;
  itemsHTML[0].online_dispfont = fontobj.online;
  itemsHTML[0].dispsize = obj.displayLabel.displayFont.size;
  itemsHTML[0].dispcolor = obj.displayLabel.displayFont.color;
  itemsHTML[0].dispstyle = obj.displayLabel.displayFont.style;
	itemsHTML[0].vshowaxis = obj.valueAxis.showAxis;
	itemsHTML[0].wcusecfont = obj.layout.useGlobalFont;
	fontobj = getFontFamily(obj.layout.wcFont.name, itemsHTML[0].font_list);
	itemsHTML[0].wcfont = fontobj.offline;
	itemsHTML[0].online_wcfont = fontobj.online;
  itemsHTML[0].minfont = obj.layout.wcFont.minSize;
  itemsHTML[0].wcstyle = obj.layout.wcFont.style;
  itemsHTML[0].minorientation = obj.layout.minOrientation;
  itemsHTML[0].maxorientation = obj.layout.maxOrientation;
  itemsHTML[0].anglescount = obj.layout.anglesCount;
	itemsHTML[0].remfilltransp = obj.fillTransparency;
	itemsHTML[0].rangegrad = obj.pointCap.pointer.rangeGradient;
  itemsHTML[0].vprecision = obj.valueAxis.precision;
  itemsHTML[0].dprecision = obj.domainAxis.precision;
  itemsHTML[0].mapdef = obj.map.definition;
  itemsHTML[0].rangetype = obj.pointCap.pointer.rangeType;
  itemsHTML[0].mapundefcol = obj.pointCap.pointer.color;
  itemsHTML[0].mapundefstr = obj.pointCap.pointer.extendLine.color;
  itemsHTML[0].pointerbase = obj.pointCap.baseRadius;
  itemsHTML[0].chartTooltips = obj.chartTooltips;
  itemsHTML[0].showTotVL = obj.valueLabel.totalLabel.show;
	itemsHTML[0].wusecfonttot = obj.valueLabel.totalLabel.useGlobalFont;
	fontobj = getFontFamily(obj.valueLabel.totalLabel.totalLabelFont.name, itemsHTML[0].font_list);
	itemsHTML[0].wfonttot = fontobj.offline;
	itemsHTML[0].online_wfonttot = fontobj.online;
  itemsHTML[0].wsizetot = obj.valueLabel.totalLabel.totalLabelFont.size;
  itemsHTML[0].wcolortot = obj.valueLabel.totalLabel.totalLabelFont.color;
	itemsHTML[0].wstyletot = obj.valueLabel.totalLabel.totalLabelFont.style;
	itemsHTML[0].wprec = obj.valueLabel.totalLabel.precision;
	itemsHTML[0].shapesseriescol = "";
  for (i = 0; i < obj.shape.colorSeries.length-1; i++) {
		itemsHTML[0].shapesseriescol += obj.shape.colorSeries[i].color + ";";
	}
	if (obj.shape.colorSeries.length > 0) {
		itemsHTML[0].shapesseriescol += obj.shape.colorSeries[i].color;
  }
  itemsHTML[0].shapesstroke = parseInt(obj.shape.stroke);
  itemsHTML[0].applypicture = obj.valueLabel.applyPicture;
  itemsHTML[0].multisubdivision = obj.multiDimensional.subdivision;
  itemsHTML[0].multisubheight = obj.multiDimensional.subdivisionHeight;
  itemsHTML[0].trgroupby = obj.treemap.dataGroupBy;
  itemsHTML[0].trorder = obj.treemap.dataOrder;
  itemsHTML[0].trtile = obj.treemap.tileStyle;
  itemsHTML[0].trinpadding = obj.treemap.innerPadding;
  itemsHTML[0].troutpadding = obj.treemap.outerPadding;
  itemsHTML[0].imageset = obj.gauge.imageType;
  itemsHTML[0].shapetype = obj.shape.figure;
  itemsHTML[0].unseltr = obj.selectionOptions.opacity;
  itemsHTML[0].unselcol = obj.selectionOptions.color;
  formProp.usecseach = obj.useColorSeriesForEach;
  itemsHTML[0].valueshow = obj.valueLabel.show;
  decodeValueLabelPosition(obj.valueLabel, itemsHTML[0]);
  itemsHTML[0].vlzero = obj.valueLabel.showZero;
  if (itemsHTML[0].ctype == "ASTER")
    itemsHTML[0].innradius = obj.radius.inner;
  itemsHTML[0].treelayout = obj.extends.treeLayout;
  itemsHTML[0].fitSize = obj.gauge.fitSize;
  itemsHTML[0].hfunnel = obj.extends.pyramid.height;
  itemsHTML[0].wfunnel = obj.extends.pyramid.width;
  itemsHTML[0].pyramidrotation = obj.extends.pyramid.rotation;
  itemsHTML[0].funneltype = obj.extends.funnel.type;
  itemsHTML[0].vorolinks = obj.extends.voronoi.links.show;
  itemsHTML[0].vorolinksColor = obj.extends.voronoi.links.color;
  itemsHTML[0].vorolinksStroke = obj.extends.voronoi.links.stroke;
  itemsHTML[0].vorolinksType = obj.extends.voronoi.links.type;
  itemsHTML[0].sandataorder = obj.extends.sankey.order;
  itemsHTML[0].layoutpos = obj.extends.sankey.position;
  itemsHTML[0].nodewidth = obj.extends.sankey.nodes.width;
  itemsHTML[0].nodepadding = obj.extends.sankey.nodes.padding;
  itemsHTML[0].middlabpos = obj.extends.sankey.valueLabel.middlePosition;
  itemsHTML[0].firstlastlabpos = obj.extends.sankey.valueLabel.firstlastPosition;
  itemsHTML[0].ordercol = obj.extends.matrix.orientationColor;
  itemsHTML[0].daxismatrix = obj.extends.matrix.domainAxisMatrix;
  itemsHTML[0].qlabels = obj.extends.quadrants.labels.type;
  itemsHTML[0].qlabelspos = obj.extends.quadrants.labels.position;
  itemsHTML[0].qlabelsali = obj.extends.quadrants.labels.alignment;
  itemsHTML[0].qusefont = obj.extends.quadrants.labels.useGlobalFont;
  fontobj = getFontFamily(obj.extends.quadrants.labels.font.name, itemsHTML[0].font_list);
  itemsHTML[0].qfont = fontobj.offline;
  itemsHTML[0].online_qfont = fontobj.online;
  itemsHTML[0].qsize = obj.extends.quadrants.labels.font.size;
  itemsHTML[0].qcolor = obj.extends.quadrants.labels.color;
	itemsHTML[0].qstyle = obj.extends.quadrants.labels.style;
	itemsHTML[0].qcolors = "";
	for (i = 0; i < obj.extends.quadrants.colorSeries.length-1; i++) {
		itemsHTML[0].qcolors += obj.extends.quadrants.colorSeries[i].color + ";";
	}
	if (obj.extends.quadrants.colorSeries.length > 0) {
		itemsHTML[0].qcolors += obj.extends.quadrants.colorSeries[i].color;
	}
	itemsHTML[0].oltype = obj.overlap.type;
	itemsHTML[0].olrad = obj.overlap.radius;
	itemsHTML[0].olcolor = obj.overlap.color;
	itemsHTML[0].qvalprec = obj.extends.quadrants.labels.precision.value;
	itemsHTML[0].qperprec = obj.extends.quadrants.labels.precision.percentage;
	itemsHTML[0].lights_layout = obj.extends.styles.lights;
	itemsHTML[0].vl_vprec = obj.valueLabel.valuePrecision;
	itemsHTML[0].vl_pprec = obj.valueLabel.percPrecision;
	itemsHTML[0].display_layout = obj.extends.styles.display;

  itemsHTML[0].shapescols = "";
  for (i = 0; i < obj.shape.fillColorSeries.length-1; i++) {
		itemsHTML[0].shapescols += obj.shape.fillColorSeries[i].color + ";";
	}
	if (obj.shape.fillColorSeries.length > 0) {
		itemsHTML[0].shapescols += obj.shape.fillColorSeries[i].color;
  }
  itemsHTML[0].shpapply = obj.shape.customFill;
  itemsHTML[0].barmaxw = obj.bars.maxWidth;
  itemsHTML[0].ringperc_layout = obj.extends.styles.ring.style;
  itemsHTML[0].ringperc_bck = obj.extends.styles.ring.background;

  newPropObj = null;
  Properties();
}

function setValueLabelPosition(ovLab, props) {
  switch (props.ctype) {
    case "PYRAMID":
      ovLab.position = props.pyrvlabpos;
      break;
    case "PIE":
    case "PIE3D":
    case "RING":
    case "ASTER":
      ovLab.position = props.pievlabpos;
      break;
    case "HBAR":
    case "HBAR3D":
    case "HSTACKBAR":
    case "HSTACKBAR3D":
      ovLab.position = props.horvlabpos;
      break;
    case "VBAR":
    case "VBAR3D":
    case "PARETO":
    case "WATERF":
    case "VSTACKBAR":
    case "VSTACKBAR3D":
    case "AREABAR":
    case "MARIMEKKO":
      ovLab.position = props.vervlabpos;
      break;
    case "TREEMAP":
    case "TREEMAPBAR":
    case "TREEMAPBARH":
    case "GEOMAP":
      ovLab.position = "in";
      break;
    case "LAYEREDBAR":
      ovLab.position = props.vlavlabpos;
      break;
    case "LAYEREDBARH":
      ovLab.position = props.hlavlabpos;
      break;
    case "LIGHTS":
    case "IMAGES":
      ovLab.position = props.outvlabpos;
      break;
    default:
      ovLab.position = props.defvlabpos;
      break;
  }
}

function decodeValueLabelPosition(ovLab, props) {
  switch (props.ctype) {
    case "PYRAMID":
      props.pyrvlabpos = ovLab.position;
      break;
    case "PIE":
    case "PIE3D":
    case "RING":
    case "ASTER":
      props.pievlabpos = ovLab.position;
      break;
    case "HBAR":
    case "HBAR3D":
    case "HSTACKBAR":
    case "HSTACKBAR3D":
      props.horvlabpos = ovLab.position;
      break;
    case "VBAR":
    case "VBAR3D":
    case "PARETO":
    case "WATERF":
    case "VSTACKBAR":
    case "VSTACKBAR3D":
    case "AREABAR":
    case "MARIMEKKO":
      props.vervlabpos = ovLab.position;
      break;
    case "TREEMAP":
    case "TREEMAPBAR":
    case "TREEMAPBARH":
    case "GEOMAP":
      ovLab.position = "in";
      break;
    case "LAYEREDBAR":
      props.vlavlabpos = ovLab.position;
      break;
    case "LAYEREDBARH":
      props.hlavlabpos = ovLab.position;
      break;
    case "LIGHTS":
    case "IMAGES":
      props.outvlabpos = ovLab.position;
      break;
    default:
      props.defvlabpos = ovLab.position;
      break;
  }
}

/* *** Gestione Toolbar *** */
/** 	La proprieta' storage_name e' vuota per un motivo preciso.
		L'utente puo' aprire il disegnatore in piu' modalita' (stand alone, light e all'interno di PortalStudio).
		Salvando il posizionamento delle toolbar nei cookies, se l'utente cambiava modalita' i bottoni venivano posizionati secondo il cookie, lasciando dei buchi.
		Non e' possibile creare un cookie per ogni toolbar per ogni modalita' del disegnatore perche' e' un'operazione troppo pesante.
		Mettendo il valore di storage_name a vuoto, le toolbar vengono posizionate dinamicamente ogni volta che si apre l'editor.
**/
var toolbars = {};
function designToolbar() {
if (lightmode == "edit")
		return;
if (lightmode == "default") {
	if (window.parent.location.href.indexOf("portalstudio.jsp") < 0)
		toolbars.action = new SPToolbar(ZTObjects.PSToolbarAction, 'sptoolbar_action');
	//toolbars.wizard = new SPToolbar(ZTObjects.PSToolbarWizard, 'sptoolbar_wizard', { elementToShow: 'all' });
}
	toolbars.lines_areas = new SPMultiToolbar('spmultitoolbar_lines_areas', {
    title: 'Lines-Areas'
	});
	toolbars.lines = new SPToolbar(ZTObjects.PSToolbarLines, 'sptoolbar_lines', {
    containerId: 'spmultitoolbar_lines_areas',
    inMultiToolbar: true,
    title: "Lines"
	});
	toolbars.areas = new SPToolbar(ZTObjects.PSToolbarAreas, 'sptoolbar_areas', {
    containerId: 'spmultitoolbar_lines_areas',
    inMultiToolbar: true,
    title: "Areas"
	});
	toolbars.allbars = new SPMultiToolbar('spmultitoolbar_allbars', {
    title: 'Bars'
	});
	toolbars.bars = new SPToolbar(ZTObjects.PSToolbarBars, 'spmultitoolbar_bars', {
    containerId: 'spmultitoolbar_allbars',
    inMultiToolbar: true
	});
	toolbars.part_whole = new SPMultiToolbar('spmultitoolbar_part_whole', {
		title: 'Part-Whole'
	});
	toolbars.pies = new SPToolbar(ZTObjects.PSToolbarPie, 'spmultitoolbar_pies', {
    containerId: 'spmultitoolbar_part_whole',
		inMultiToolbar: true,
		title: "Pies"
	});
	toolbars.pyramids = new SPToolbar(ZTObjects.PSToolbarPyramid, 'spmultitoolbar_pyramids', {
    containerId: 'spmultitoolbar_part_whole',
		inMultiToolbar: true,
		title: "Pyramids"
	});
	toolbars.allxyz = new SPMultiToolbar('spmultitoolbar_allxyz', {
    title: 'XYZ'
	});
	toolbars.xyz = new SPToolbar(ZTObjects.PSToolbarXYZ, 'spmultitoolbar_xyz', {
    containerId: 'spmultitoolbar_allxyz',
    inMultiToolbar: true
	});
	toolbars.measure = new SPMultiToolbar('spmultitoolbar_measure', {
    title: 'Meters'
	});
	toolbars.meter = new SPToolbar(ZTObjects.PSToolbarMeter, 'sptoolbar_meter', {
    containerId: 'spmultitoolbar_measure',
    inMultiToolbar: true,
    title: "Gauges"
	});
	toolbars.state = new SPToolbar(ZTObjects.PSToolbarState, 'sptoolbar_state', {
    containerId: 'spmultitoolbar_measure',
    inMultiToolbar: true,
    title: "State"
	});
	toolbars.counter = new SPToolbar(ZTObjects.PSToolbarCounters, 'sptoolbar_counter', {
    containerId: 'spmultitoolbar_measure',
    inMultiToolbar: true,
    title: "Counter"
	});
	toolbars.calc = new SPMultiToolbar('spmultitoolbar_calc', {
    title: 'Calculated'
	});
	toolbars.misc = new SPToolbar(ZTObjects.PSToolbarCalculated, 'sptoolbar_misc', {
    containerId: 'spmultitoolbar_calc',
    inMultiToolbar: true
	});
	toolbars.maps = new SPMultiToolbar('spmultitoolbar_maps', {
    title: 'Maps'
	});
	toolbars.gmap = new SPToolbar(ZTObjects.PSToolbarMaps, 'sptoolbar_gmap', {
		containerId: 'spmultitoolbar_maps',
    inMultiToolbar: true,
		title: "Geographical"
	});
	toolbars.allhie = new SPMultiToolbar('spmultitoolbar_allhie', {
    title: 'Hierarchies'
	});
	toolbars.hiestr = new SPToolbar(ZTObjects.PSToolbarHIEStr, 'sptoolbar_hiestr', {
		containerId: 'spmultitoolbar_allhie',
    inMultiToolbar: true,
    title: "Structure"
	});
	toolbars.hie = new SPToolbar(ZTObjects.PSToolbarHIE, 'sptoolbar_hie', {
		containerId: 'spmultitoolbar_allhie',
    inMultiToolbar: true,
    title: "Values"
	});
	toolbars.alldeps = new SPMultiToolbar('spmultitoolbar_alldeps', {
    title: 'Dependencies'
	});
	toolbars.deps = new SPToolbar(ZTObjects.PSToolbarDeps, 'spmultitoolbar_deps', {
    containerId: 'spmultitoolbar_alldeps',
    inMultiToolbar: true
	});
	/*toolbars.all3d = new SPMultiToolbar('spmultitoolbar_all3d', {
    title: '3D'
	});
	toolbars._3ds = new SPToolbar(ZTObjects.PSToolbar3D, 'spmultitoolbar_3ds', {
    containerId: 'spmultitoolbar_all3d',
    inMultiToolbar: true
	});*/
	toolbars.timings = new SPMultiToolbar('spmultitoolbar_timings', {
    title: 'Time-based'
	});
	toolbars.timeline = new SPToolbar(ZTObjects.PSToolbarTimes, 'spmultitoolbar_timeline', {
    containerId: 'spmultitoolbar_timings',
    inMultiToolbar: true,
    title: 'Lines-Areas'
  });

  var tbl = document.getElementById('toolbar');
  ZtVWeb.theme = 'portalstudio';

  window.addEvents({
    'resize': function () {
      if (timerResize) clearTimeout(timerResize);
      timerResize = resizeWindow.delay(100);
    }
  });
  var timerResize = null;
  var resizeWindow = function () {
    // document.getElementById('toolbar').setStyle('width',window.getSize().x-document.getElementById('gadgets_pane').getSize().x-document.getElementById('gadgets_panerightbar').getSize().x);
    document.getElementById('toolbar').setStyle('width', document.getElementById('backcanvas').getSize().x - document.getElementById('toolbar').offsetLeft)
    tbl.fireEvent('SPToolbarRefresh');
  }
  resizeWindow();
}
/* *** Fine della Gestione Toolbar *** */

function reset() {
  if (!m_bUpdated || (confirm("Changes have not been saved yet.\r\nContinue loosing changes?"))) {
    currentname = '';
    newPropObj = null;
    formProp = new ZTObjects.formObj();
    canwrite = false;
    FormProperties(true);
    initPropertiesDefaultValue(formProp);
    itemsHTML = [];
    itemsHTML[0] = new ZTObjects.chartObj();
    index = 0;
    last_index = null;
    canwrite = true;
    Properties();
    initPropertiesDefaultValue(itemsHTML[0]);
    canwrite = true;
    m_bUpdated = true;
    document.getElementById('general_tab').fireEvent('click');
    document.getElementById('Form_generic_tab').fireEvent('click');
  }
}

function setPropertiesID(obj) { //ricreo properties per compatibilità con il vecchio array
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    mainObject.objClass.properties = new Array();
    var tab;
    for (var i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (var ii = 0; ii < tab.length; ii++) {
        mainObject.objClass.properties.push(tab[ii].propID);
      }
    }
  }
}

// INIZIO FUNZIONI DI SALVATAGGIO
function save() {
	if (parent) { parent.is_Saving = true; }
	if (!Empty(currentname)) {
    updateUserGroup();
		var _tmpCurrentName = (!Empty(chartName) ? chartName : currentname) + ((this.formProp.user_group == 'user' && !Empty(this.formProp.user))?'_' + this.formProp.user:((this.formProp.user_group == 'group' && !Empty(this.formProp.group))?'_g' + this.formProp.group:''));
		var proceed = true;
		if (_tmpCurrentName != currentname) {
      proceed = false;
      var existConf = new JSURL("../servlet/SPCHTProxy?m_cAction=exist&m_cConfigName=" + _tmpCurrentName + "&custom="+(formProp.customChart=='true'), true).Response();
      if (existConf != '1' || confirm("You have modified customize options.\nThis custom file already exist, overwrite?")) {
        proceed = true;
      }
      currentname = _tmpCurrentName;
		}
		if (proceed) {
      notimooManager = new Notimoo({});
      notimooManager.show({
        title:'Notification message',
        message: 'saving chart...',
        sticky : true,
        width:200,
        height:40
      });
      save2.delay(100);
		}
	}
	else {
		saveAs();
	}
}

function saveAs() {
	openNewWindow("../portalstudio/saveas.jsp?&tool=chart"+"&custom="+formProp.customChart, "&save&SPModalLayerId=saveAsSPModalLayer", 600, 600, 0, 0);
}

function getCurrentObj() {
  var obj = {};
  obj.globalSettings = makeDefForm();
  obj.graphSettings = makeDefChart();
  return obj;
}

function setCurrentObj(obj_ext) {
  // metodo introdotto per IA
  var current = getCurrentObj(),
    toApply = mergeDeep(obj_ext, current);
  if (toApply.globalSettings)
    decodeDefForm(toApply.globalSettings);
  if (toApply.graphSettings)
    decodeDefChart(toApply.graphSettings);
  myChart = null;
  setgraph(toApply.graphSettings.chartType);
  writeHTML();
}

function save2() {
  var i;
	var url = new JSURL("../servlet/SPCHTProxy?m_cAction=save"+
    "&m_cConfigName=" + currentname +
    "&m_cWv=" + URLenc(JSON.encode(getCurrentObj())) +
    "&forceSave=true" +
    "&custom=" + formProp.customChart +
    "&m_cID=" + cmdhash
    , true);
	var output = url.Response();
	if (output == null) { output = ""; }
	//notimooManager.close(notimooManager.elements[0]);
	for (i = 0; i < notimooManager.elements.length; i++) {
		notimooManager.close(notimooManager.elements[i]);
	}
	if (window.parent.changeName) {
		window.parent.changeName(currentname, {
      custom:formProp.customChart
		},Strtran(window.frameElement.id,'portalstudioframe',''));
	}
	if (window.parent.AddRecentOpen) {
		window.parent.AddRecentOpen("chart", currentname, {
      custom:formProp.customChart=='true'
		});
	}
	if (output.indexOf('Saved') != -1) {
		notimooManager.show({
			title:'Notification message',
			message: 'chart saved!',
			visibleTime: 2000,
			width:200
		});
		if (arguments.length > 0 && arguments[0] == "close") { window.parent.closeCurrentObj(); }
		if (parent) { parent.is_Saving = false; }
		m_bUpdated = false;
	}
	else {
		PSAlert.alert('Error saving');
	}
}

function openFile() {
  openNewWindow("../portalstudio/open.jsp?tool=chart&onetool=true", "&open&SPModalLayerId=openSPModalLayer", 860, 600, 0, 0);
}

function newCurrentObj(text_path/*, srcmode, path_tmp*/) {
  var form;
  if (!m_bUpdated || (confirm("Changes have not been saved yet.\r\nContinue loosing changes?"))) {
		currentname = '';
		canwrite = true;
		m_bUpdated = true;
	}
  if(!Empty(text_path)) {
    currentname = text_path;
    form = loadCHT(currentname);
  }
	else {
    form = getDefaultObjChartDef();
    /*formProp = new ZTObjects.formObj();
		itemsHTML[0] = new ZTObjects.chartObj();*/
  }
  setDefaultChart(form, webroot);
	decodeDefForm(form.globalSettings);
	decodeDefChart(form.graphSettings);
	document.title = currentname + " - Chart Editor";
	if (Ctrl("srcform")) {
		Ctrl("srcform").value = currentname;
	}
	// FormProperties();
  setgraph(form.graphSettings.chartType);
	writeHTML();
}

var myChart = null;
var chartConfig = null;

function writeHTML(dontupdate) {
	if (dontupdate)
		return;

  if (!loadingNew)
    return;

  if (canwrite == true) {
    var ctrl = document.getElementById('previewMask');
    chartConfig = getCurrentObj();
    if (!Empty(document.getElementById('chteditor_pform_wrapper')))
      document.getElementById("chteditor_pform_wrapper").innerHTML = "";
    if (myChart != null)
      ctrl.innerHTML = '';
    if (isNaN(chartConfig.globalSettings.width) || chartConfig.globalSettings.width < 50)
      ctrl.style.width = "99%";
    else ctrl.style.width = chartConfig.globalSettings.width + 'px';
    if (isNaN(chartConfig.globalSettings.height) || chartConfig.globalSettings.height < 50)
      ctrl.style.height = "99%";
    else
      ctrl.style.height=chartConfig.globalSettings.height+'px';

    var opts = {};
    // inizializzo parametri opzioni
    if (advMode) {
      opts.propName = getChartPropertyName(chartConfig.graphSettings.chartType);
      opts.dataset = getChartDataset(chartConfig.graphSettings.chartType);
      opts.parent = ctrl;
      opts.functionObj = null;
      opts.linkObj = null;
      opts.chartId = "chteditor";
      opts.container = undefined;
      opts.loadLibs = undefined;
      opts.addData = getChartAddDataset(chartConfig.graphSettings.chartType);
      opts.addPName = getChartAddPropertyName(chartConfig.graphSettings.chartType);
      myChart = new ZtChart(chartConfig, getChartObjconfig(chartConfig.graphSettings.chartType), opts);
    }
    else {
      opts.drawWithECharts = true;
      opts.parent = ctrl;
      opts.render_opts = {
        width: parseInt(formProp.width),
        height: parseInt(formProp.height),
        renderer: "svg"
      }
      opts.chtConfig = getCurrentObj();
      myChart = new ZtChart(opts,
        getChartObjconfig(chartConfig.graphSettings.chartType),
        {
          propName: getChartPropertyName(chartConfig.graphSettings.chartType),
          dataset: getChartDataset(chartConfig.graphSettings.chartType)
        }
      );
    }

    myChart.setEnableClick(true);
    myChart.setEnableClickEffect(true);
    myChart.setEnableLegendClick(true);
    myChart.setEnableLegendEffect(true);
    myChart.setEnableExclude(false);
    myChart.applySpTheme = true;

    displayChartTypes(chartConfig);
    myChart.draw();
  }

  formProp.updateHTML = true;
  itemsHTML[0].updateHTML = true;

  document.getElementById('chart_notes_text').value = defNotes;
  //document.getElementById('chart_notes').setStyle('display', 'block');

  updSwitchConf(document.getElementById("switch-" + (advMode ? "off" : "on")))
}

function SetWidthHeight() {
}

function Properties() {
  index = 0;
	if (newPropObj && last_index != null && last_index == index) {
		newPropObj.updatePropertiesFromPaint(itemsHTML[index]);
	}
	else{
		newPropObj = new propertiesObj({
			psTab : true
			, afterRender : resizeGadgetsPane
			, m_obj : itemsHTML[index]
			, canExpandToColumn : false
			, tabindex : 100
			, divcontainer : 'properties'
			, moveDiv : false
		});
		last_index = index;
	}
	document.getElementById('propertiespsTopBar').hide();
	document.getElementById('propertiespSeparator1').hide();
	document.getElementById('propertiesctrlSelect').hide();
	document.getElementById('propertiespSeparator2').hide();
}

function Help(the_property) {
  var i, prop = '';
  if (typeof(anchorToFeature) != 'undefined') {
    if (typeof(the_property) != 'undefined') {
      prop = "charteditor_" + the_property.toLowerCase();
    }
    if (prop != '' && prop in anchorToFeature) {
      i = anchorToFeature[prop];
    }
    else if (index != null && "charteditor_" + itemsHTML[index].type.toLowerCase() in anchorToFeature) {
      i = anchorToFeature["charteditor_"+itemsHTML[index].type.toLowerCase()];
    }
    else if (typeof(i)=='undefined') {
      prop = "charteditor_" + the_property.substring(the_property.indexOf('_'),0).toLowerCase();
      i = anchorToFeature[prop];
    }

    if(typeof(i)=='undefined'){
      i = anchorToFeature["charteditor"];
    }
    windowOpenForeground(m_cHelpUrl + 'help/portalstudio/ps_urg_navigator.htm?' + URLenc( i + (prop != "" ? '||' + prop + "" : "") ), '', 'toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1', null, null, null, true);
  }
}

function windowResize() {
	var ctrl = document.getElementById('backcanvas');
	if (document.body.offsetWidth - document.getElementById('gadgets_pane').offsetWidth > 80) {
		ctrl.style.width = (document.body.offsetWidth - ((document.getElementById('gadgets_pane').opened ? document.getElementById('gadgets_pane').offsetWidth : 0) + 40)) + "px"; //margine di 30
	}
	//document.getElementById('navmenu_tabcontainer').style.width = ctrl.style.width;
	if (document.getSize().y - ctrl.offsetTop > 0) {
		ctrl.style.height = (document.getSize().y - (ctrl.offsetTop + 20)) + "px";
	}
	resizeGadgetsPane();
}

function loadCHT(filename,custom) {
  if (Empty(custom)){
    if (new JSURL("../servlet/SPCHTProxy?m_cAction=exist&m_cConfigName="+filename+"&custom=true", true).Response()==1)
      custom='true'
    else
      custom='false'
  }
	var projectUrl = new JSURL("../servlet/SPCHTProxy?m_cAction=load&m_cConfigName=" + filename+"&custom="+custom, true);
	var myResponse = projectUrl.Response();
	var obj = JSON.parse(myResponse);
  customChart=custom;
	return obj;
}

function updateUserGroup(_obj) {
  var obj = _obj||{};
  chartName=currentname
  currentname = currentname.split('_');
  //controllare se ho un user o group
  var user_group = '', u_g = '';
  if (currentname.length > 1) {
    user_group = currentname[currentname.length - 1];
    if (user_group.charAt(0) == 'g' && parseInt(user_group.substring(1, user_group.length), 10) == user_group.substring(1, user_group.length)) {
      u_g = 'group';
      chartName = chartName.substring(0, chartName.length-(user_group.length + 1));

    }
    else if (parseInt(user_group, 10) == user_group) {
      u_g = 'user';
      chartName = chartName.substring(0, chartName.length - (user_group.length + 1));
    }
    else {
      user_group = '';
    }
  }
  obj.user_group = u_g;
  if (!Empty(u_g)) {
    obj[u_g] = u_g == 'user'?user_group:user_group.substring(1, user_group.length);
  }
  currentname = chartName + (!Empty(u_g)?user_group:'');
  return obj;
}

function setgraph(type) {
	index = 0;
  document.getElementById('graphtype_tab').style.display = 'none';
  document.getElementById('graphtype_tab').fireEvent('click');
  Ctrl('graphtype_ctype').value = type;
  document.getElementById('graphtype_ctype').fireEvent('change');
  last_index = null;
  Properties();
  document.getElementById('general_tab').fireEvent('click');
  document.getElementById('Form_generic_tab').fireEvent('click');
  document.getElementById('graphtype_tab').style.display = 'none';
}

/**** Gestione color-gradient ****/
function LoadCG() {
	if (index != null) {
		var height = 500;
		var width = 600;
		var url = "../portalstudio/colorgradient_edit.html?colorFunc=getColors&gradFunc=getGradients&callerFunction=SetColorGradient&separator=;";
		var additionalUrl = "&Color_Gradient_Edit&SPModalLayerId=cgSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1, "Color_Gradient_Edit");
	}
}

function SetColorGradient(objindex, col, grad) {
	if (Empty(objindex) && objindex!=0) {
		formProp.colourseries = col;
		formProp.gradientseries = grad;
		FormProperties();
		writeHTML();
	}
}

function LoadCGb() {
	if (index != null) {
		var height = 500;
		var width = 600;
		var url = "../portalstudio/colorgradient_edit.html?colorFunc=getColorsB&gradFunc=getGradientsB&callerFunction=SetColorGradientB&separator=;&objIdx=0";
		var additionalUrl = "&Color_Gradient_Edit&SPModalLayerId=cgSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1, "Color_Gradient_Edit");
	}
}

function SetColorGradientB(objindex, col, grad) {
	if (objindex != null) {
		itemsHTML[objindex].outlinecolour = col;
		itemsHTML[objindex].outlinegradient = grad;
		Properties();
		writeHTML();
	}
}

function LoadCGs() {
	if (index != null) {
		var height = 500;
		var width = 600;
		var url = "../portalstudio/colorgradient_edit.html?colorFunc=getColorsS&gradFunc=getGradientS&callerFunction=SetColorGradientS&separator=;&objIdx=0";
		var additionalUrl = "&Color_Gradient_Edit&SPModalLayerId=cgSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1, "Color_Gradient_Edit");
	}
}

function SetColorGradientS(objindex, col/*, grad*/) {
	if (objindex != null) {
		itemsHTML[objindex].shapesseriescol = col;
		Properties();
		writeHTML();
	}
}

function LoadCGsc() {
	if (index != null) {
		var height = 500;
		var width = 600;
		var url = "../portalstudio/colorgradient_edit.html?colorFunc=getColorsSC&gradFunc=getGradientS&callerFunction=SetColorGradientSC&separator=;&objIdx=0";
		var additionalUrl = "&Color_Gradient_Edit&SPModalLayerId=cgSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1, "Color_Gradient_Edit");
	}
}

function SetColorGradientSC(objindex, col/*, grad*/) {
	if (objindex != null) {
		itemsHTML[objindex].shapescols = col;
		Properties();
		writeHTML();
	}
}

/*** GESTIONE TRENDLINES ***/
function LoadTL() {
	if (index != null) {
		var height = 500;
		var width = 600;
    var list = itemsHTML[0].getTrendlines();
		var url = "../portalstudio/trendlines_edit.html?tlList="+list+"&callerFunction=SetTrendlines&separatorN=_&separatorP=;&separatorTL=|&objIdx=0";
		var additionalUrl = "&Trendlines_Edit&SPModalLayerId=cgSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1, "Trendlines_Edit");
	}
}

function SetTrendlines(objindex, trendlines) {
	if (objindex != null) {
		itemsHTML[objindex].rangebands = trendlines;
		Properties();
		writeHTML();
	}
}


/*** RESIZE CON SCROLL ***/
function resizeWindow(/*event, res*/) {
	var ctrl = Ctrl("backcanvas");
	ctrl.style.height = (window.innerHeight - ctrl.offsetTop) +"px";
	ctrl.style.width = (window.innerWidth - ctrl.offsetLeft) + "px";
}

/* *** Gestione Preview *** */
var preview_opened = false;
function toolbarPreview() {
	var saveChanges = false;
	if (m_bUpdated == true && currentname != "" && !preview_opened) {
		saveChanges = confirm("Do you want to save " + currentname + "?");
	}
	Preview(saveChanges);
  document.getElementById('formproperties').morph({'opacity':1})
}

function setToolbars() {
  var tbl;
	if (preview_opened == true) {
		for (tbl in toolbars) {
			if(tbl != 'preview')
				toolbars[tbl].disable();
		}
	}
	else {
		for (tbl in toolbars) {
			toolbars[tbl].enable();
		}
	}
	document.getElementById('formproperties').morph({'opacity':1});
}

/* saveChanges: indica se si deve salvare al momento dell'anteprima. */
function Preview(saveChanges) {
  index = 0;
  var tmp_bUpdated = m_bUpdated;
  if (!saveChanges) {
    m_bUpdated = false;
  }
  togglePreview();
  if (!saveChanges) {
    m_bUpdated = tmp_bUpdated;
  }
}

/*function toggleXParameters() {
  document.getElementById('properties').setStyles({
    'display': 'block'
  });
}*/

function getWrapperLeft() {
  return 250;
}

function chartPreview(/*pUrl*/) {
  index = 0;
}

function GetCurrentName() {
  return currentname;
}

/*function GetResourceName() {
  return '../jsp-system/SPChartPreview_portlet.jsp?m_NoCache=' + LibJavascript.AlfaKeyGen(10) + "&pPrev=" + pprev;
}*/

function getVdmParams() {
  var type = "category";
  switch (itemsHTML[0].ctype) {
    case "ARCDIAL":
    case "THERMO":
    case "LIGHTS":
    case "IMAGES":
    case "DISPLAY":
    case "COUNTER":
    case "PADDLE":
      type = "measure";
      break;
    case "SCATTER":
    case "BUBBLE":
      type = "xyz";
      break;
  }
  return "w_chartType=" + type;
}

function GetRequestParams() {
  return "chartconfigparameters.vdm";
}

function selectForm() {
}

function setChartType(type) {
  var ret = "";
  switch (type) {
    case "TIMEBAR":
      ret = "VBAR";
      isTimeDemo = true;
      break;
    case "TIMESTACK":
      ret = "HSTACKBAR";
      isTimeDemo = true;
      break;
    case "TIMEPIE":
      ret = "PIE";
      isTimeDemo = true;
      break;
    case "TIMERADAR":
      ret = "RADARLINE";
      isTimeDemo = true;
      break;
    case "TIMEBUBBLE":
      ret = "BUBBLE";
      isTimeDemo = true;
      break;
    case "TIMEARCDIAL":
      ret = "ARCDIAL";
      isTimeDemo = true;
      break;
    case "TIMELIGHTS":
      ret = "LIGHTS";
      isTimeDemo = true;
      break;
    case "TIMEDISPLAY":
      ret = "DISPLAY";
      isTimeDemo = true;
      break;
    case "TIMEAREA":
      ret = "AREA";
      isTimeDemo = true;
      break;
    case "TIME":
      ret = type;
      isTimeDemo = true;
      break;
    default:
      ret = type;
      isTimeDemo = false;
      break;
  }
  return ret;
}

function decodeChartType(type) {
  var ret = type;
  if (isTimeDemo) {
    switch (type) {
      case "VBAR":
        ret = "TIMEBAR";
        break;
      case "HSTACKBAR":
        ret = "TIMESTACK";
        break;
      case "PIE":
        ret = "TIMEPIE";
        break;
      case "RADARLINE":
        ret = "TIMERADAR";
        break;
      case "BUBBLE":
        ret = "TIMEBUBBLE";
        break;
      case "ARCDIAL":
        ret = "TIMEARCDIAL";
        break;
      case "LIGHTS":
        ret = "TIMELIGHTS";
        break;
      case "DISPLAY":
        ret = "TIMEDISPLAY";
        break;
      case "AREA":
        ret = "TIMEAREA";
        break;
    }
  }
  return ret;
}

function displayChartTypes(chartObj) {
  var type = chartObj.graphSettings.chartType;
  if (type == "TIME")
    type = "LINES";

  if (document.getElementById("charttypes").offsetLeft != document.getElementById("backcanvas").offsetLeft) {
    document.getElementById("charttypes").style.left = document.getElementById("backcanvas").offsetLeft + "px";
    document.getElementById("switchers").style.left = document.getElementById("backcanvas").offsetLeft + "px";
  }

  var ctype, fnc, fam, fncString, famString;
  if (ZtChartDict && ZtChartDict.Translate) {
    var trad = ZtChartDict.Translate("ZTC_" + type);
    if (typeof trad == "object")
      ctype = trad.eng;
    else
      ctype = type;
    ctype += (isTimeDemo) ? " ( time dataset )" : "";
    // funzioni
    fnc = getChartFunctionGroup(type);
    fncString = "";
    if (!Empty(fnc))
      fncString = (fnc.map(function (f) { return ZtChartDict.Translate("ZTC_" + f.toUpperCase()).eng; })).join(", ");
    // funzioni
    fam = getChartFamilyGroup(type);
    famString = "";
    if (!Empty(fam))
      famString = (fam.map(function (f) { return ZtChartDict.Translate("ZTC_" + f.toUpperCase()).eng; })).join(", ");
  }

  document.getElementById("ccategorytype_label").textContent = ctype;
  document.getElementById("ctype_img").style.backgroundImage = "url(" + getChartImageName(decodeChartType(chartObj.graphSettings.chartType)) + ")";
  if (!Empty(fncString))
    document.getElementById("ctype_label").innerHTML = "Functions: " + fncString;
  if (!Empty(famString)) {
    if (!Empty(fncString))
      document.getElementById("ctype_label").innerHTML += "<br>";
    document.getElementById("ctype_label").innerHTML += "Families: " + famString;
  }
}

function SaveChartConfiguration(chartConfig, noprev) {
  if (chartConfig) {
    if (noprev) {
      chartConfig.globalSettings.width = parseInt(formProp.width);
      chartConfig.globalSettings.height = parseInt(formProp.height);
    }
    decodeDefForm(chartConfig.globalSettings);
    decodeDefChart(chartConfig.graphSettings);
    setgraph(chartConfig.graphSettings.chartType);
  }
  myChart = null;
  index = 0;
  if (newPropObj)
    newPropObj.ShowProperties();
  if (!noprev)
    writeHTML();
}

function morderCtrlById(a, b) {
  if (a < b) { return -1; }
  if (a > b) { return 1; }
  return 0;
}

function togglerGadget(toggler) {
  var t;
  if (toggler.hasClass("opened")) {
    var tg = document.getElementsByClassName('gadgets_pane_toggler');
    var tgid = [];
    for (t = 0; t < tg.length; t++) {
      tgid[t] = tg[t].id;
    }
    tgid = tgid.sort(morderCtrlById);
    for (t = 0; t < tgid.length; t++) {
      if (tgid[t] != toggler.id && $(tgid[t]).hasClass("opened")) {
        $(tgid[t]).click();
      }
    }
  }
}

function editDesc(id,isFormProp,propName){
  window.layerOpenForeground("../portalstudio/insert_desc.html?isFormProp="+isFormProp+"&id="+id+(!Empty(propName)?"&propName="+propName:""),propName,'',500,200,true,1);
}

function apply3D(value, propname, elemHTML, index) {
  var ctype = itemsHTML[index].ctype,
    is3D = CharToBool(value + "");
  if (is3D) {
    itemsHTML[0][propname] = value;
    setgraph(ctype + "3D");
  }
  else {
    itemsHTML[0][propname] = value;
    setgraph(Strtran(ctype, "3D", ""));
  }
  return true;
}

function SaveChartNotes(elem) {
	if (elem)
		defNotes = elem.value;
}

function setFontFamily(offline, online) {
	var font = "";
	if (!Empty(online))
		font = online;
	if (!Empty(offline)) {
		if (!Empty(font))
			font += ",";
		font += offline;
	}
	if (Empty(font))	// default
		font = "Arial";
	return font;
}

function getFontFamily(fontname, typesol) {
	var fobj = { offline : "", online : ""},
	fonts = fontname.split(","),
	first = fonts[0];
	if (!Empty(first) && typesol.indexOf(first) >= 0) {	// e' un font online
		fobj.online = first;
		fonts = fonts.slice(1);
	}
	if (!Empty(fonts)) {
		fonts = fonts.join(",");
		if (extraFont && extraFont.indexOf(fonts) < 0) { // retrocompatibilita' lo cerco
			var f = false;
			for (var i = 0; !f && i < extraFont.length; i++) {
				if (extraFont[i].indexOf(fonts) >= 0) {
					f = true;
					fonts = extraFont[i];
				}
			}
		}
		fobj.offline = fonts;
	}

	return fobj;
}

/** SPAPI **/
var currentAPITypeExpr = "ctype",
  currentAPITypeExprValue = "",
  currentAPIClass = null,
  currentAPIType = "";
function renderApi(obj /*itemsHTML object*/) { //overwrite PortalCommonJS.js
  currentAPIClass = null;
  currentAPIType = "";
  if (obj && obj.objClass) {
    if (obj.ctype) {
      currentAPIClass = obj.objClass;
      currentAPIType = obj.ctype;
      currentAPITypeExprValue = obj[currentAPITypeExpr];
    }
    else { // formObjClass
      currentAPIClass = obj.objClass;
      currentAPIType = 'chart';
      currentAPITypeExprValue = 'common'
    }
    openSPComponentAPI();
  }
}

function getRenderApiObjClass(withEvaluation) { //overwrite PortalCommonJS.js
  var myCopy;
  var myType;
  var hideObjects = [];
  hideObjects.push(currentAPITypeExpr)
  myCopy = currentAPIClass;
  myType = currentAPIType;
  if( !withEvaluation) {
    myType = currentAPITypeExprValue;
    myCopy = {};
    myCopy.helper = currentAPIClass.helper;
    if( currentAPIClass.helper && currentAPIClass.helper[currentAPITypeExprValue]) {
      myCopy.helper = currentAPIClass.helper[currentAPITypeExprValue];
    }
  }
  if( withEvaluation) {
    var itemObj = myCopy;
    var found = false;
    if (itemObj && itemObj.newProperties) {
      var tab, ii;
      var nkeys = Object.keys(itemObj.newProperties);
      for ( var i=0; !found && i<nkeys.length; i++ ) {
        tab = itemObj.newProperties[nkeys[i]];
        for (ii = 0; !found && ii < tab.length; ii++) {
          if( tab[ii].propID == currentAPITypeExpr ) {
            found = true;
            if ( tab[ii].hide_list ) {
              var tabh, iii;
              var foundh = false;
              var mkeys = Object.keys(tab[ii].hide_list);
              for ( var j=0; !foundh && j<mkeys.length; j++ ) {
                tabh = tab[ii].hide_list[mkeys[j]];
                if( mkeys[j].indexOf(currentAPITypeExprValue) >=0 ) {
                  foundh = true;
                  for (iii=0; iii < tabh.length; iii++) {
                    var l = tabh[iii];
                    var o = decodeShowHideList(l);
                    if (Empty(o.prop) && !Empty(o.tab)) {
                      var tabl = itemObj.newProperties[o.tab];
                      for (var k = 0; tabl && k < tabl.length; k++) {
                        hideObjects.push(tabl[k].propID);
                      }
                    }
                    else {
                      hideObjects.push(o.prop);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  return { apiType: myType, apiObj: myCopy, apiHidden: hideObjects };
}

function updSwitchConf(switch_elm) {
  var class_elm = switch_elm.id;
  if (document.getElementById("toolbar").children.length == 0)
    return;

  if (class_elm.indexOf("off") >= 0) {
    document.getElementById("switch-on").style.display = "block";
    document.getElementById("lib-name").textContent = "D3";
  }
  else {
    document.getElementById("switch-off").style.display = "block";
    document.getElementById("lib-name").textContent = "ECharts";
  }
  switch_elm.style.display = "none";
}

function switchConf(switch_elm) {
  var class_elm = switch_elm.id,
  all_types = GetAvailableChartTypes(),
  nadv_types = getNotAdvTypes(),
  i;
  if (document.getElementById("toolbar").children.length == 0)
    return;

  if (class_elm.indexOf("off") >= 0) {
    //document.getElementById("switch-on").style.display = "block";
    //document.getElementById("lib-name").textContent = "D3";
    advMode = true;
    for (i = 0; i < all_types.length; i++) {
      if (nadv_types.indexOf(all_types[i]) < 0) {
        if (document.getElementById(all_types[i].toLowerCase()).hasClass("disabled"))
          document.getElementById(all_types[i].toLowerCase()).removeClass("disabled")
      }
    }
  }
  else {
    //document.getElementById("switch-off").style.display = "block";
    //document.getElementById("lib-name").textContent = "ECharts";
    advMode = false;
    for (i = 0; i < all_types.length; i++) {
      if (nadv_types.indexOf(all_types[i]) < 0) {
        if (!document.getElementById(all_types[i].toLowerCase()).hasClass("disabled"))
          document.getElementById(all_types[i].toLowerCase()).addClass("disabled")
      }
    }
  }
  //switch_elm.style.display = "none";
  last_index = null;
  FormProperties(true);
  Properties();
  document.getElementById('general_tab').fireEvent('click');
  document.getElementById('Form_generic_tab').fireEvent('click');
  document.getElementById('graphtype_tab').style.display = 'none';
  writeHTML();
}

function isAdvMode() {
  return advMode;
}

function getNotAdvTypes() {
  return ["LINES", "AREA", "STACKEDAREA", "PCOORDS",
          "HBAR", "VBAR", "HSTACKBAR", "VSTACKBAR", "WATERF",
          "PIE", "RING", "RINGPERC",
          "RADARLINE", "RADARAREA",
          "SCATTER", "BUBBLE",
          "TREEMAP", "SUNB", "SUNBSTR" ];
}

function GetAvailableChartTypes() {
  return ["HBAR", "PYRAMID", "LAYEREDBARH",
    "PIE", "RING", "RINGPERC", "WORDCLOUD",
    "HSTACKBAR", "VSTACKBAR",
    "LINES", "AREA", "STACKEDAREA", "RADARLINE", "RADARAREA",
    "VBAR", "PARETO", "WATERF", "LAYEREDBAR",
    "ARCDIAL", "THERMO", "LIGHTS", "IMAGES",
    "DISPLAY", "COUNTER", "PADDLE", "CAL",
    "PYR", "NECKEDPYR", "PYRSTR", "NECKEDPYRSTR", "FUNNEL",
    "PCOORDS", "SCATTER", "BUBBLE", "ASTER", "AREABAR", "VORONOI",
    "GEOMAP", "SUNB", "SUNBSTR", "TREE", "TREESTR", "CPACK", "CPACKSTR", "FORCE", "FORCESTR",
    "TREEMAP", "TREEMAPBAR", "TREEMAPBARH", "MARIMEKKO",
    "MATRIX", "CHORD", "SANKEY", "BCMATRIX"]
}
