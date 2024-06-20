/* exported getQueryParams expressionReturn languageConfigurations getObjConfigFromChartCtrl
    getChartConfigFromChartCtrl xPhantomMakeMySvg VQRNameReturn
  */
function getFieldDescription(queryName,valueFields){
	var l_oFields = getQueryFields(queryName);
	var myArray=[];
  if (l_oFields){
    for (var i = 0; i < l_oFields.length; i++) {
      var alias = l_oFields[i].alias;
      var desc = l_oFields[i].desc;
      if(Empty(desc))
        desc=alias;
      if(valueFields.indexOf(alias)>=0){
        myArray[valueFields.indexOf(alias)]=desc;
      }
    }
  }
	return myArray.toString();
}
function getQueryFields(queryName){
  if (Empty(queryName))
    return [];
	var AllField = new JSURL("../servlet/SPVZMProxy?action=vqr_fields&vqr=" + queryName + "&offlineMode=false+&table=" + queryName, true);
	AllField = AllField.Response();
  if (!Empty(AllField)) {
    try {
      return eval(AllField);
    }
    catch (e) {
      return [];
    }
  }
  else
    return [];
}
function getQueryParams(pvals){
  var retp = "";
  if (Empty(pvals))
    return retp;
	var pobj = JSON.parse(pvals);
  for (var key in pobj) {
  	retp += (key + "=" + pobj[key] + ",");
  }
  return retp.substring(0, retp.length - 1);
}
function expressionReturn(id,value/*,pars,toolList*/){
  if (id) {
    var el = document.getElementById(id);
    if (el) {
      el.value = value;
      el.blur();
      el.focus();
    }
  }
}

// polyfill per phantomjs o codice non supportato - ripresa da stdFunc
if (typeof window.Object.assign != 'function') {
  window.Object.assign = function (target) {
    'use strict';
    if (target == null) {
      throw new TypeError('Cannot convert undefined or null to object');
    }

    target = Object(target);
    for (var index = 1; index < arguments.length; index++) {
      var source = arguments[index];
      if (source != null) {
        for (var key in source) {
          if (Object.prototype.hasOwnProperty.call(source, key)) {
            target[key] = source[key];
          }
        }
      }
    }
    return target;
  };
}

var languageConfigurations = function (lang) {
  var vocal_i_gr = String.fromCharCode(0xec),
  vocal_e_ac = String.fromCharCode(0xe9),
  vocal_u_ci = String.fromCharCode(0xfb),
  vocal_a_ac = String.fromCharCode(0xe1),
  vocal_a_di = String.fromCharCode(0xe4),
  euro = String.fromCharCode(0x20ac),
  dollar = String.fromCharCode(0x24),
  pound = String.fromCharCode(0xa3),
  englishFormatLocale = {
    formatLocale: {
      decimal: ".",
      thousands: ",",
      grouping: [3]
    },
    timeFormatLocale: {
      periods: ["AM", "PM"],
      days: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
      shortDays: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
      months: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
      shortMonths: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    },
    csvSeparator: ","
  },
  europeFormatLocale = {
    formatLocale: {
      decimal: ",",
      thousands: ".",
      grouping: [3]
    },
    timeFormatLocale: {
      date: "%d/%m/%Y",
      time: "%H:%M:%S",
      periods: ["", ""]
    },
    csvSeparator: ";"
  },
  configs = {};

  configs.usa = {};
  configs.usa.formatLocale = Object.assign({ currency: [dollar, ""] }, englishFormatLocale.formatLocale);
  configs.usa.timeFormatLocale = Object.assign({
    dateTime: "%x, %X",
    date: "%-m/%-d/%Y",
    time: "%-I:%M:%S %p"
  }, englishFormatLocale.timeFormatLocale);
  configs.usa.csvSeparator = englishFormatLocale.csvSeparator;

  configs.eng =	{};
  configs.eng.formatLocale = Object.assign({ currency: [pound, ""] }, englishFormatLocale.formatLocale);
  configs.eng.timeFormatLocale = Object.assign({
    dateTime: "%a %e %b %X %Y",
    date: "%d/%m/%Y",
    time: "%H:%M:%S"
  }, englishFormatLocale.timeFormatLocale);
  configs.eng.csvSeparator = englishFormatLocale.csvSeparator;

  configs.ita =	{};
  configs.ita.formatLocale = Object.assign({ currency: [euro, ""] }, europeFormatLocale.formatLocale);
  configs.ita.timeFormatLocale = Object.assign({
    dateTime: "%A %e %B %Y, %X",
    days: ["Domenica", "Luned" + vocal_i_gr, "Marted" + vocal_i_gr, "Mercoled" + vocal_i_gr, "Gioved" + vocal_i_gr, "Venerd" + vocal_i_gr, "Sabato"],
    shortDays: ["Dom", "Lun", "Mar", "Mer", "Gio", "Ven", "Sab"],
    months: ["Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"],
    shortMonths: ["Gen", "Feb", "Mar", "Apr", "Mag", "Giu", "Lug", "Ago", "Set", "Ott", "Nov", "Dic"]
  }, europeFormatLocale.timeFormatLocale);
  configs.ita.csvSeparator = europeFormatLocale.csvSeparator;

  configs.fra =	{}
  configs.fra.formatLocale = Object.assign({ currency: ["", euro] }, europeFormatLocale.formatLocale);
  configs.fra.timeFormatLocale =	Object.assign({
    dateTime: "%A, le %e %B %Y, %X",
    days: ["dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi"],
    shortDays: ["dim.", "lun.", "mar.", "mer.", "jeu.", "ven.", "sam."],
    months: ["janvier", "f"+vocal_e_ac+"vrier", "mars", "avril", "mai", "juin", "juillet", "ao"+vocal_u_ci+"t", "septembre", "octobre", "novembre", "d"+vocal_e_ac+"cembre"],
    shortMonths: ["janv.", "f"+vocal_e_ac+"vr.", "mars", "avr.", "mai", "juin", "juil.", "ao"+vocal_u_ci+"t", "sept.", "oct.", "nov.", "d"+vocal_e_ac+"c."]
  }, europeFormatLocale.timeFormatLocale);
  configs.fra.formatLocale.thousands = " ";
  configs.fra.csvSeparator = europeFormatLocale.csvSeparator;

  configs.spa =	{}
  configs.spa.formatLocale = Object.assign({ currency: ["", euro] }, europeFormatLocale.formatLocale);
  configs.spa.timeFormatLocale =	Object.assign({
    dateTime: "%A, %e de %B de %Y, %X",
    days: ["domingo", "lunes", "martes", "mi"+vocal_e_ac+"rcoles", "jueves", "viernes", "s"+vocal_a_ac+"bado"],
    shortDays: ["dom", "lun", "mar", "mi"+vocal_e_ac, "jue", "vie", "s"+vocal_a_ac+"b"],
    months: ["enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"],
    shortMonths: ["ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"]
  }, europeFormatLocale.timeFormatLocale);
  configs.spa.csvSeparator = europeFormatLocale.csvSeparator;

  configs.deu =	{}
  configs.deu.formatLocale = Object.assign({ currency: ["", euro] }, europeFormatLocale.formatLocale);
  configs.deu.timeFormatLocale =	Object.assign({
    dateTime: "%A, der %e. %B %Y, %X",
    days: ["Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"],
    shortDays: ["So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"],
    months: ["Januar", "Februar", "M"+vocal_a_di+"rz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"],
    shortMonths: ["Jan", "Feb", "Mrz", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"]
  }, europeFormatLocale.timeFormatLocale);
  configs.deu.timeFormatLocale.date = "%d.%m.%Y";
  configs.deu.csvSeparator = europeFormatLocale.csvSeparator;

  configs.ned =	{}
  configs.ned.formatLocale = Object.assign({ currency: [euro, ""] }, europeFormatLocale.formatLocale);
  configs.ned.timeFormatLocale =	Object.assign({
    dateTime: "%a %e %B %Y %T",
    days: ["zondag", "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag"],
    shortDays: ["zo", "ma", "di", "wo", "do", "vr", "za"],
    months: ["januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december"],
    shortMonths: ["jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"]
  }, europeFormatLocale.timeFormatLocale);
  configs.ned.timeFormatLocale.date = "%d-%m-%Y";
  configs.ned.csvSeparator = europeFormatLocale.csvSeparator;

	return configs[lang];
}

function getObjConfigFromChartCtrl(chctrl, usectrl) {
  var i, retObjConfig,
  myQuery;
  if (usectrl)
    retObjConfig = chctrl.objConfig;
  else
    retObjConfig = {};

  if (chctrl.gendataset)
    myQuery = chctrl.query;
  else
    myQuery = chctrl.datasource.cmd;

  var updfields = false;
  if (!Empty(chctrl.ctype)) {
    switch (chctrl.ctype) {
      case "VORONOI":
        retObjConfig.labelField = chctrl.voro_cat;
        retObjConfig.valueFields = chctrl.voro_coords;
        retObjConfig.labelSeries = chctrl.voro_class;
        updfields = true;
        break;
      case "PCOORDS":
        retObjConfig.keyField = chctrl.sfield;
        retObjConfig.labelField = chctrl.sfieldlabel;
        retObjConfig.valueFields = chctrl.value_fields;
        retObjConfig.labelSeries = chctrl.label_series;
        updfields = true;
        break;
      case "RINGPERC":
        retObjConfig.keyField = chctrl.labelKey_field;
        retObjConfig.labelField = chctrl.label_field;
        retObjConfig.valueFields = chctrl.val_field;
        retObjConfig.maxFields = chctrl.max_field;
        updfields = true;
        break;
      case "ASTER":
        retObjConfig.labelSeries = chctrl.xyz_series_field;
        retObjConfig.valueFields = chctrl.y_field;
        retObjConfig.labelField = chctrl.x_field;
        if (!Empty(chctrl.xKey_field))
          retObjConfig.keyField = chctrl.xKey_field;
        retObjConfig.minFields = chctrl.min_field;
        retObjConfig.maxFields = chctrl.max_field;
        updfields = true;
        break;
    }
  }

  if (!updfields) {
    var ctype = chctrl.chartType || chctrl.chart_type;
    switch (ctype) {
      case 'xyz' :
        retObjConfig.labelSeries = chctrl.xyz_series_field;
        retObjConfig.valueFields = chctrl.y_field + (Empty(chctrl.z_field) ? "" : "," + chctrl.z_field);
        retObjConfig.labelField = chctrl.x_field;
        if (!Empty(chctrl.xKey_field))
          retObjConfig.keyField = chctrl.xKey_field;
        break;
      case 'geo':
        retObjConfig.geoFields = chctrl.geo_0_field + (Empty(chctrl.geo_1_field) ? "" : "," + chctrl.geo_1_field);
        retObjConfig.labelField = chctrl.geo_dom_field;
        retObjConfig.valueFields = chctrl.geo_value_field;
        retObjConfig.geoOpts = {};
        retObjConfig.geoOpts.typeView = chctrl.geo_view_select;
        retObjConfig.geoOpts.view = chctrl.geo_view;
        if (chctrl.geo_view_select == "2")
          retObjConfig.geoOpts.level = chctrl.geo_level_2;
        else if (chctrl.geo_view_select == "3")
          retObjConfig.geoOpts.level = chctrl.geo_level_3;
        else
          retObjConfig.geoOpts.level = chctrl.geo_level;
        retObjConfig.geoOpts.onlyData = CharToBool("" + chctrl.geo_onlydata);
        if (!Empty(chctrl.markers_dataobj)) {
          retObjConfig.geoOpts.markers = {};
          retObjConfig.geoOpts.markers.lat = chctrl.markers_lat;
          retObjConfig.geoOpts.markers.lng = chctrl.markers_lng;
          retObjConfig.geoOpts.markers.desc = chctrl.markers_desc;
          retObjConfig.geoOpts.markers.key = chctrl.markers_key;
          retObjConfig.geoOpts.markers.type = parseInt(chctrl.markers_type);
        }
        retObjConfig.zooming = {};
        break;
      case 'hie' :
        retObjConfig.labelField = chctrl.fieldpath;
        retObjConfig.valueFields = chctrl.fieldvalue;
        retObjConfig.keyField = chctrl.keyfieldpath;
        /*retObjConfig.labelSeries = chctrl.sfield;
        if (!Empty(chctrl.sfieldlabel))
          retObjConfig.labelSeries = chctrl.sfieldlabel;*/
        break;
      case 'dep' :
        retObjConfig.labelField = chctrl.depfield_1 + "," + chctrl.depfield_2;
        retObjConfig.valueFields = chctrl.depvalue;
        retObjConfig.labelSeries = "";
        if (!Empty(chctrl.depfield_1label) && !Empty(chctrl.depfield_2label))
          retObjConfig.labelSeries = chctrl.depfield_1label + "," + chctrl.depfield_2label;
        retObjConfig.fieldClass = "";
        if (!Empty(chctrl.depfield_1class) && !Empty(chctrl.depfield_2class))
          retObjConfig.fieldClass = chctrl.depfield_1class + "," + chctrl.depfield_2class;
        break;
      case "classif" :
        retObjConfig.labelSeries = chctrl.class_label;
        retObjConfig.keyField = chctrl.class_key;
        retObjConfig.xValues = "";
        if (!Empty(chctrl.class_xfrom))
          retObjConfig.xValues += chctrl.class_xfrom;
        if (!Empty(chctrl.class_xto)) {
          if (!Empty(retObjConfig.xValues))
            retObjConfig.xValues += ",";
          retObjConfig.xValues += chctrl.class_xto;
        }
        retObjConfig.yValues = "";
        if (!Empty(chctrl.class_yfrom))
          retObjConfig.yValues += chctrl.class_yfrom;
        if (!Empty(chctrl.class_yto)) {
          if (!Empty(retObjConfig.yValues))
            retObjConfig.yValues += ",";
          retObjConfig.yValues += chctrl.class_yto;
        }
        retObjConfig.labelField = chctrl.class_cat;
        retObjConfig.valueFields = chctrl.class_xval;
        retObjConfig.valueFields += ";";
        retObjConfig.valueFields += chctrl.class_yval;
        /*if (!Empty(chctrl.class_zval)) {
          if (!Empty(retObjConfig.valueFields))
            retObjConfig.valueFields += ",";
          retObjConfig.valueFields += chctrl.class_zval;
        }*/
        retObjConfig.labelFieldKey = chctrl.class_keycat;
        retObjConfig.classField = chctrl.class_cfield;
        break;
      default :
        retObjConfig.labelField = chctrl.label_field;
        retObjConfig.valueFields = chctrl.value_fields;
        retObjConfig.labelSeries = chctrl.label_series;
        if (Empty(retObjConfig.labelSeries))
          retObjConfig.labelSeries = getFieldDescription(myQuery, retObjConfig.valueFields.split(","));
        if (!Empty(chctrl.labelKey_field))
          retObjConfig.keyField = chctrl.labelKey_field;

        if (ctype == 'measure') {
          retObjConfig.minFields = chctrl.min_field;
          retObjConfig.maxFields = chctrl.max_field;
        }

        if (chctrl.label_field.split(",").length > 1)
          retObjConfig.concatDomain = true;
        
        if (!Empty(chctrl.labelKey_field) && chctrl.labelKey_field.split(",").length > 1)
          retObjConfig.concatKey = true;

        if (!Empty(chctrl.sfield)) {
          retObjConfig.valueFields = chctrl.dynSeries;
          retObjConfig.labelSeries = chctrl.dynSeries;
          if (!Empty(chctrl.sfieldlabel))
            retObjConfig.labelSeries = chctrl.labeldynSeries;
        }
        break;
    }
  }

  retObjConfig.title = chctrl.title;
  if (chctrl.value_labels == "0" || !chctrl.value_labels || chctrl.value_labels == "hide")
    retObjConfig.valueLabels = false;
  else if (chctrl.value_labels != "default" && !Empty(chctrl.value_labels))
    retObjConfig.valueLabels = true;
  if (chctrl.data_order != 'default')
    retObjConfig.dataOrder = chctrl.data_order;
  retObjConfig.multiDimensionalKeyStart = chctrl.key_start;
  retObjConfig.enableChangeOrder = chctrl.enable_change_order;
  retObjConfig.otherChart = chctrl.other_chart;
  retObjConfig.downloadFormat = chctrl.downloadlist;
  retObjConfig.multiDimensionalStartAnimation = chctrl.multi_autochange;
  retObjConfig.titleSeries = chctrl.titleSeries;
  if (!Empty(chctrl.focuskey))
    retObjConfig.focusKey = chctrl.focuskey;
  retObjConfig.menuPosition = chctrl.menuPosition;
  if (!Empty(chctrl.othlimits) || !Empty(chctrl.othfunc)) {
    retObjConfig.dataOthers = {};
    if (!Empty(chctrl.othmenu))
      retObjConfig.dataOthers.menu = CharToBool("" + chctrl.othmenu);
    else
      retObjConfig.dataOthers.menu = true;
    retObjConfig.dataOthers.desc = chctrl.othlabel;
    retObjConfig.dataOthers.value = [];
    retObjConfig.dataOthers.isPerc = [];
    if (!Empty(chctrl.othlimits)) {
      var mval = chctrl.othlimits.split(",");
      for(i = 0; i < mval.length; i++) {
        if (mval[i].indexOf("%") >= 0)
          retObjConfig.dataOthers.isPerc.push(true);
        else
          retObjConfig.dataOthers.isPerc.push(false);
        retObjConfig.dataOthers.value.push(parseFloat(mval[i]));
      }
    }
  }
  retObjConfig.multidimFixedScale = chctrl.multi_scale;
  if (!Empty(chctrl.chartW) || !Empty(chctrl.chartH))
    retObjConfig.scrollView = true;
  else
    retObjConfig.scrollView = false;
  if (chctrl.typecondform == "default") {
    if (!Empty(chctrl.rangebands))
      retObjConfig.rangeBands = getRangeBandsObj(chctrl.rangebands);
  }
  else if (!Empty(chctrl.rangefunc))
    retObjConfig.rangeBands = "function";

  retObjConfig.enableMenuSelections = chctrl.enable_menu_sel;
  retObjConfig.exportFileName = chctrl.exportFileName;
  var mprop, mobj, mp;
  
  if (ctype == "dep") {
    if (!Empty(chctrl.depclass)) {
      mprop = chctrl.depclass.split("|");
      mobj = {};
      for (i = 0; i < mprop.length; i++) {
        mp = mprop[i].split(";");
        mobj[mp[0]] = {};
        mobj[mp[0]].type = mp[1];
        mobj[mp[0]].color = mp[2] || "";
      }
      retObjConfig.mapSeries = mobj;
    }
  }
  else {
    if (!Empty(chctrl.mapSeries)) {
      mprop = chctrl.mapSeries.split("|");
      mobj = {};
      for (i = 0; i < mprop.length; i++) {
        mp = mprop[i].split(";");
        mobj[mp[0]] = {};
        mobj[mp[0]].type = mp[1];
        mobj[mp[0]].ownerScale = CharToBool(mp[2] + "") || false;
      }
      retObjConfig.mapSeries = mobj;
    }
  }
  
  retObjConfig.zoomFilter = chctrl.zoomFilter;
  retObjConfig.manualScale = CharToBool(chctrl.manualScale + "");
  retObjConfig.compactChart = chctrl.compactChart;
  retObjConfig.domainAsString = CharToBool(chctrl.domain_type + "");
  retObjConfig.subAxis = CharToBool(chctrl.class_subaxis + "");
  retObjConfig.enableGrid = CharToBool(chctrl.grid_chart + "");
  retObjConfig.fieldsGrid = chctrl.grch_fields;
  // titoli colonne griglia
  retObjConfig.labelsGrid = {};
  switch (chctrl.chart_type) {
    case "xyz":
    case "geo":
      if (!Empty(chctrl.grch_key))
        retObjConfig.labelsGrid.key = chctrl.grch_key;
      if (!Empty(chctrl.grch_serie))
        retObjConfig.labelsGrid.serie = chctrl.grch_serie;
      if (!Empty(chctrl.grch_values))
        retObjConfig.labelsGrid.values = chctrl.grch_values;
      break;
    case "hie":
    case "dep":
      if (!Empty(chctrl.grch_key))
        retObjConfig.labelsGrid.key = chctrl.grch_key;
      if (!Empty(chctrl.grch_values))
        retObjConfig.labelsGrid.values = chctrl.grch_values;
      break;
    case "classif":
      if (!Empty(chctrl.grch_key))
        retObjConfig.labelsGrid.key = chctrl.grch_key;
      if (!Empty(chctrl.grch_domain))
        retObjConfig.labelsGrid.domain = chctrl.grch_domain;
      if (!Empty(chctrl.grch_serie))
        retObjConfig.labelsGrid.serie = chctrl.grch_serie;
      if (!Empty(chctrl.grch_values))
        retObjConfig.labelsGrid.values = chctrl.grch_values;
      break;
    default:
      if (!Empty(chctrl.grch_key))
        retObjConfig.labelsGrid.key = chctrl.grch_key;
      if (!Empty(chctrl.grch_domain))
        retObjConfig.labelsGrid.domain = chctrl.grch_domain;
      if (!Empty(chctrl.grch_values))
        retObjConfig.labelsGrid.values = chctrl.grch_values;
      break;
  }

  return retObjConfig;
}

function getChartConfigFromChartCtrl(chctrl, chconfig) {
  var retChartConfig = Empty(chconfig) ? {} : chconfig,
  chartType = chctrl.chart_type || chctrl.chartType;
  if (!retChartConfig.globalSettings.titles[2])
    retChartConfig.globalSettings.titles[2] = {};
  if (!chctrl.dontOverwrite) {
    retChartConfig.globalSettings.titles[0].text = chctrl.title;
    retChartConfig.globalSettings.titles[1].text = chctrl.titleSeries;
    retChartConfig.globalSettings.titles[2].text = chctrl.subtitle;
    if (chctrl.legend != "a" && chctrl.legend != "default" && !Empty(chctrl.legend))
      retChartConfig.globalSettings.titles[1].position = chctrl.legend;
    retChartConfig.graphSettings.axisLabel.xLabel = chctrl.x_label;
    retChartConfig.graphSettings.axisLabel.yLabel = chctrl.y_label;
    retChartConfig.graphSettings.axisLabel.percentLabel = chctrl.percent_label;
  }

  if (parseFloat(chctrl.min_value) != null && !isNaN(parseFloat(chctrl.min_value))) {
    if (chartType == "measure")
      retChartConfig.graphSettings.tickAxis.minValue = parseFloat(chctrl.min_value);
    else
      retChartConfig.graphSettings.valueAxis.minValue = parseFloat(chctrl.min_value);
  }
  if (parseFloat(chctrl.max_value) != null && !isNaN(parseFloat(chctrl.max_value))) {
    if(chartType == "measure")
      retChartConfig.graphSettings.tickAxis.maxValue = parseFloat(chctrl.max_value);
    else
      retChartConfig.graphSettings.valueAxis.maxValue = parseFloat(chctrl.max_value);
  }
  if (parseFloat(chctrl.tick_unit) != null)
    retChartConfig.graphSettings.valueAxis.tick = parseFloat(chctrl.tick_unit);
  if (!Empty(chctrl.chartW))
    retChartConfig.globalSettings.width = parseFloat(chctrl.chartW);
  if (!Empty(chctrl.chartH))
    retChartConfig.globalSettings.height = parseFloat(chctrl.chartH);
  if (!Empty(chctrl.legendlimit)){
    if (chctrl.legendlimit.indexOf("%") >= 0)
      retChartConfig.globalSettings.titles[1].limitUnitPerc = true;
    else
      retChartConfig.globalSettings.titles[1].limitUnitPerc = false;
    retChartConfig.globalSettings.titles[1].showLegendButtonWhen = parseFloat(chctrl.legendlimit);
  }
  if (chctrl.elanimate != "default")
    retChartConfig.graphSettings.animate = chctrl.elanimate == "enable" ? true : false;
  if (parseFloat(chctrl.danimation) != null && !isNaN(parseFloat(chctrl.danimation)))
    retChartConfig.graphSettings.durationAnimation = parseFloat(chctrl.danimation);
  if (chctrl.ctooltip != "default" && !Empty(chctrl.ctooltip))
    retChartConfig.graphSettings.chartTooltips = chctrl.ctooltip;
  // time
  if (!Empty(chctrl.dateformat))
    retChartConfig.graphSettings.time.format = chctrl.dateformat;
  if (!Empty(chctrl.tcustformat))
    retChartConfig.graphSettings.time.customFormat = chctrl.tcustformat;
  if (!Empty(chctrl.tdomainunit))
    retChartConfig.graphSettings.time.unit = chctrl.tdomainunit;
  if (!Empty(chctrl.tdomainvalue))
    retChartConfig.graphSettings.time.value = chctrl.tdomainvalue;
  if (!Empty(chctrl.dataload_datelimit))
    retChartConfig.graphSettings.time.dateLimit = chctrl.dataload_datelimit;
  retChartConfig.graphSettings.time.dataType = chctrl.datatype;
  retChartConfig.graphSettings.time.missingData = chctrl.missval;
  retChartConfig.graphSettings.time.holesStep = chctrl.discunit;
  retChartConfig.graphSettings.time.holesStepValue = parseFloat(chctrl.discval);
  // multidimensional
  if (retChartConfig.graphSettings.multiDimensional) {
    retChartConfig.graphSettings.multiDimensional.multiDim = /*chctrl.ismulti*/ chctrl.vmode == "mdim";
    retChartConfig.graphSettings.multiDimensional.cursorType = chctrl.cursorType;
    retChartConfig.graphSettings.multiDimensional.position = chctrl.cursorPosition;
    retChartConfig.graphSettings.multiDimensional.alignment = chctrl.cursorAlignment;
    retChartConfig.graphSettings.multiDimensional.subdivision = chctrl.multisubdivision;
    retChartConfig.graphSettings.multiDimensional.subdivisionHeight = chctrl.multisubheight;
    retChartConfig.graphSettings.multiDimensional.axis.color = chctrl.ccolor;
    retChartConfig.graphSettings.multiDimensional.axis.stroke = chctrl.cstroke;
  }
  if (parseFloat(chctrl.vaxis_precision) != null && !isNaN(parseFloat(chctrl.vaxis_precision)))
    retChartConfig.graphSettings.valueAxis.precision = chctrl.vaxis_precision;

  // retro-compatibilita' pictures su editor
  if (!CharToBool("" + retChartConfig.graphSettings.valueLabel.applyPicture)) {
    if (!Empty(chctrl.pic_prefix) || !Empty(chctrl.pic_suffix) || !Empty(chctrl.pic_cust)) {
      if (Empty(retChartConfig.globalSettings.valuepicture))
        retChartConfig.globalSettings.valuepicture = {};
      retChartConfig.graphSettings.valueLabel.applyPicture = true;
    }
  }
  if (!retChartConfig.globalSettings.valuepicture)
    retChartConfig.globalSettings.valuepicture = {};
  if (!Empty(chctrl.pic_prefix))
    retChartConfig.globalSettings.valuepicture.prefix = chctrl.pic_prefix;
  if (!Empty(chctrl.pic_suffix))
    retChartConfig.globalSettings.valuepicture.suffix = chctrl.pic_suffix;
  if (!Empty(chctrl.pic_cust)) {
    if (!CharToBool("" + chctrl.pic_type))
      retChartConfig.globalSettings.valuepicture.applyFunction = true;
    retChartConfig.globalSettings.valuepicture.picture = chctrl.pic_cust;
  }
  // min max tick d.axis
  if (parseFloat(chctrl.xmin_value) != null && !isNaN(parseFloat(chctrl.xmin_value)))
    retChartConfig.graphSettings.domainAxis.minValue = parseFloat(chctrl.xmin_value);
  if (parseFloat(chctrl.xmax_value) != null && !isNaN(parseFloat(chctrl.xmax_value)))
    retChartConfig.graphSettings.domainAxis.maxValue = parseFloat(chctrl.xmax_value);
  if (parseFloat(chctrl.xtick_unit) != null)
    retChartConfig.graphSettings.domainAxis.tick = parseFloat(chctrl.xtick_unit);
  // reflines
  if (!retChartConfig.graphSettings.domainAxis.referenceLine)
    retChartConfig.graphSettings.domainAxis.referenceLine = {};
  if (parseFloat(chctrl.xrefline) != null && !isNaN(parseFloat(chctrl.xrefline)))
    retChartConfig.graphSettings.domainAxis.referenceLine.value = parseFloat(chctrl.xrefline);
  retChartConfig.graphSettings.domainAxis.referenceLine.color = chctrl.xreflinecol;
  if (!retChartConfig.graphSettings.valueAxis.referenceLine)
    retChartConfig.graphSettings.valueAxis.referenceLine = {};
  if (parseFloat(chctrl.refline) != null && !isNaN(parseFloat(chctrl.refline)))
    retChartConfig.graphSettings.valueAxis.referenceLine.value = parseFloat(chctrl.refline);
  retChartConfig.graphSettings.valueAxis.referenceLine.color = chctrl.reflinecol;

  return retChartConfig;
}

function xPhantomMakeMySvg(cconfig, oconfig, propName, propValue, divctrl){
  var ret = {};
  var chart = new ZtChart(cconfig,oconfig,propName,propValue,divctrl,"","","serverchart",null,true);
  chart.setIsStaticChart(true);
  chart.setIsPhantomJS(true);
  chart.setEnableClick(false);
  chart.setEnableClickEffect(false);
  chart.setEnableLegendClick(false);
  chart.setEnableLegendEffect(false);
  chart.setEnableExclude(false);
  chart.StdChart.DrawCallback();
  ret.svg = chart.getSVGString('svg');
  ret.chartId = chart.getChartId();
  if (chart.StdChart.usedFonts.indexOf("svgcharts") < 0)
    chart.StdChart.usedFonts.push("svgcharts");
  ret.fonts = chart.StdChart.usedFonts.toString();
  return JSON.stringify(ret);
}

function VQRNameReturn(id,value){
  var mtext = document.getElementsByName(id)[0];
  if(mtext){
    mtext.value = value;
    mtext.focus();
    mtext.blur();
  }
}

function getRangeBandsObj(rbstr){
  var tBand,minV,maxV;
  var ret = [];
	if(!Empty(rbstr)){
		var tmp = rbstr.split("|");
		for(var i=0; i<tmp.length; i++){
			tBand=tmp[i].split(";");
			minV = parseFloat(tBand[1].substring(0,tBand[1].indexOf("_")));
			maxV = parseFloat(tBand[1].substring(tBand[1].indexOf("_")+1,tBand[1].length));
			ret.push({label:tBand[0], minValue:minV, maxValue:maxV, color:tBand[2], percent:CharToBool("" + tBand[3]), imageUrl:tBand[4], iconCode:tBand[5]});
		}
	}
  return ret;
}
