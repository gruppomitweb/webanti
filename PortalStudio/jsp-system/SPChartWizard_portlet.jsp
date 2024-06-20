<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _this = this;\n\nthis.btn1.Value(FormatMsg('RPT_APPLY'))\nthis.btn2.Value(FormatMsg('RPT_APPLY'))\n\nfunction btn1_Click(){\n  this.returnConfiguration()\n}\n\nfunction btn2_Click(){\n  this.btn1_Click()\n}\n\nvar initConf = null;\nvar gtype = null;\nfunction this_Loaded(){\n  this.boxtypes.Ctrl.innerHTML = \"\";\n  \n  this.boxfam.Ctrl.innerHTML = \"\";\n  this.boxfam.Ctrl.style.border = \"none\"\n  this.label_desc.Hide()\n  \n  this.boxtypes.Hide()\n  this.defname.Hide()\n  this.defpick.Hide()\n  this.Radio10_onChange()\n  if (this.tool.Value() == \"portlet\")\n  \tthis.initDataProviderCombo()\n  \n  if (GetOpener() && GetOpener().GetChartWizardInitConf)\n    initConf = GetOpener().GetChartWizardInitConf();\n\n  if (!Empty(initConf)) {\n    if (!Empty(initConf.def)) {\n      if (initConf.def.indexOf(\"type:\") \u003e= 0) {\n        this.Radio10.Value(\"new\")\n        this.drawChartBoxes(Strtran(initConf.def,\"type:\",\"\"));\n      }\n      else {\n        \u002f\u002fthis.Radio10.Value(\"def\")\n        this.Radio10.Value(\"new\")\n\t\t\t\tthis.defname.Value(initConf.def)\n        this.drawChartBoxes(sel_type)\n      }\n    }\n      else {\t\u002f\u002f pre-seleziono il primo grafico\n        this.drawChartBoxes(\"LINES\");\n      }\n    \n    if (!Empty(initConf.dataobj)) {\n      this.combodata.Value(initConf.dataobj)\n      \u002f\u002f campi\n      if (!Empty(initConf.fields)) {\n        gtype = getTypeInMap(sel_type);\n      \tvar gflds = Object.keys(initConf.fields),\n            datafieldsA = this.datafields.Data.map(function (field) { return field[0].toLowerCase(); }),\n            numfieldsA = this.numfields.Data.map(function (field) { return field[0].toLowerCase(); });\n        for (var i = 0; i \u003c gflds.length; i++) {\n          if (!Empty(initConf.fields[gflds[i]])) {\n            var sel = initConf.fields[gflds[i]].split(\",\");\n            for (var j = 0; j \u003c sel.length; j++) {\n              if (!Empty(sel[j])) {\n                var refArray = eval(this[\"Grid_\" + gflds[i]].dataobj + \"A\"),\n                    idxRow = refArray.indexOf(sel[j].toLowerCase());\n                if (idxRow \u003e= 0) {\n                  this[\"Grid_\" + gflds[i]].CurrRow(idxRow)\n                  this[\"Grid_\" + gflds[i]].RowChecked(true)\n                }\n              }\n            }\n          }\n        }\n      }\n    }\n  }\n  \n  if (this.tool.Value() != \"portlet\")\n    this.ZtTabs.Hide(2, true);\n}\n\nfunction drawChartBoxes(type) {\n  sel_type = type;\n  chartfam = getTypeInMap(sel_type);\n  if (!Empty(chartfam)) {\n    LibJavascript.CssClassNameUtils.addClass(document.getElementById(chartfam), \"sel_cont\");\n    this.drawBoxTypes(chartfam)\n    this.label_desc.Show()\n    LibJavascript.CssClassNameUtils.addClass(document.getElementById(sel_type), \"sel_cont\");\n    \u002f\u002fdocument.getElementById(sel_type).checked = true;\n    this.__ctype.Value(sel_type);\n  }\n  else\n    this.drawChartBoxes(\"LINES\");\n}\n\nfunction Radio10_onChange(){\n  this.__ctype.Value(\"\")\n  if (this.Radio10.Value() == \"new\") {\n    this.defname.Hide()\n    this.defname.Value(\"\")\n    this.defpick.Hide()\n    \n    this.drawBoxFams()\n    \n    if (Empty(this.boxtypes.Ctrl.innerHTML))\n    \tthis.drawBoxTypes()\n    this.boxtypes.Show()\n    if (!Empty(sel_type)) {\n    \t\u002f\u002fdocument.getElementById(sel_type).checked = false;\n      LibJavascript.CssClassNameUtils.removeClass(document.getElementById(sel_type), \"sel_cont\");\n      sel_type = \"\";\n    }\n  }\n  else {\n    this.defname.Show()\n    this.defpick.Show()\n    this.boxtypes.Hide()\n  }\n}\n\nfunction defpick_Click(){\n  var ctrlname = this.formid + \"_defname\",\n  \t\turl = \"..\u002fportalstudio\u002fopen.jsp?tool=chart&onetool=true&ExpressionID=\" + URLenc(ctrlname) + \"&callerFunction=expressionReturn\",\n      width = 930,\n      height = 600,\n      l = (screen.width) ? (screen.width - width) \u002f 2 : 100,\n      t = (screen.height) ? (screen.height - height) \u002f 2 : 100,\n      offlinemode = '';\n  \n\tlayerOpenForeground(url + \"&SPModalLayerId=chartSPModalLayer\" + offlinemode, \"Select chart\", \"\", width, height, true, 1);\n}\n\nvar typesMap = {\n      linearea: [\"LINES\",\"AREA\",\"STACKEDAREA\",\"PCOORDS\",\"AREABAR\"],\n  \t\tradars:[\"RADARLINE\",\"RADARAREA\"],\n      bars: [\"VBAR\",\"VSTACKBAR\",\"LAYEREDBAR\",\"TREEMAPBAR\",\"HBAR\",\"HSTACKBAR\",\"LAYEREDBARH\",\"TREEMAPBARH\",\"AREABAR\"],\n      pies: [\"PIE\",\"RING\",\"RINGPERC\",\"ASTER\"],\n      yz: [\"SCATTER\",\"BUBBLE\",\"ASTER\"],\n      maps: [\"GEOMAP\"],\n      hie: [\"TREEMAP\",\"SUNB\", \"CPACKSTR\",\"CPACK\", \"MARIMEKKO\",\"TREEMAPBAR\",\"TREEMAPBARH\"],\n      rel: [\"MATRIX\", \"CHORD\", \"SANKEY\"]\n    },\n    sel_type = \"\";\n\nfunction getTypeInMap(ctype) {\n\tvar f = false,\n      types = Object.keys(typesMap),\n      key = \"\";\n  for (var i = 0; Empty(key) && !f && i \u003c types.length; i++) {\n  \tif (typesMap[types[i]].indexOf(ctype) \u003e= 0) {\n    \tf = true;\n      key = types[i];\n    }\n  }\n  return key;\n}\n\nfunction drawBoxTypes(tkey){\n  if (Empty(tkey)) return\n  \n  this.boxtypes.Ctrl.innerHTML = \"\";  \n  \n  this.boxtypes.Ctrl.style.display = \"flex\";\n  this.boxtypes.Ctrl.style.flexWrap = \"wrap\";\n  this.boxtypes.Ctrl.style.flexDirection = \"row\";\n  \n  var t_keys = Object.keys(typesMap);\n\u002f\u002f   for (var i = 0; i \u003c t_keys.length; i++) {\n\u002f\u002f   \tvar div_c = document.createElement(\"div\");\n\u002f\u002f     div_c.className = \"c_cont\";\n    \u002f**\u002f\n\u002f\u002f     div_c.style.fontFamily = \"Open Sans\";\n\u002f\u002f     div_c.style.fontSize = \"13px\";\n\u002f\u002f     div_c.style.color = \"rgba(0,0,0,.85)\";\n\u002f\u002f     div_c.style.float = \"left\";\n\u002f\u002f     div_c.style.width = \"90%\";\n\u002f\u002f     \u002f\u002fdiv_c.style.marginLeft = \"3%\";\n\u002f\u002f     div_c.style.marginTop = \"10px\";\n    \u002f**\u002f\n\u002f\u002f     var div_t = document.createElement(\"div\");\n\u002f\u002f     div_t.className = \"t_cont\";\n\u002f\u002f     div_t.textContent = this.getTranslation(t_keys[i].toUpperCase());\n    \u002f**\u002f\n\u002f\u002f     div_t.style.fontWeight = 600;\n\u002f\u002f     div_t.style.fontSize = \"15px\";\n    \u002f**\u002f\n\u002f\u002f     div_c.appendChild(div_t);\n\u002f\u002f     var div_det = document.createElement(\"div\");\n\u002f\u002f     div_det.className = \"det_cont\";\n    \u002f**\u002f\n\u002f\u002f     div_det.style.float = \"left\";\n\u002f\u002f     div_det.style.margin = \"5px\";\n    \u002f**\u002f\n\u002f\u002f     div_c.appendChild(div_det);\n    for (var j = 0; j \u003c typesMap[tkey\u002f*t_keys[i]*\u002f].length; j++) {\n      var type = typesMap[tkey\u002f*t_keys[i]*\u002f][j];\n    \tvar div_dc = document.createElement(\"div\");\n      div_dc.id = type;\n    \tdiv_dc.className = \"cf_cont dtc_cont\";\n      \u002f**\u002f\n      \u002f\u002fdiv_dc.style.float = \"left\";\n      \u002f\u002fdiv_dc.style.padding = \"5px\";\n      \u002f\u002fdiv_dc.style.width = \"200px\";\n      div_dc.style.flex = \"0 0 25%\";\n    \tdiv_dc.style.margin = \"6px 12px\"\n    \tdiv_dc.style.border = \"thin solid #c0c0c0\"\n    \tdiv_dc.style.borderRadius = \"10px\"\n      div_dc.style.fontFamily = \"Open Sans\";\n    \tdiv_dc.style.fontSize = \"13px\";\n     \tdiv_dc.style.color = \"rgba(0,0,0,.85)\";\n      div_dc.style.maxWidth = \"160px\"\n      div_dc.style.maxHeight = \"160px\"\n      div_dc.style.display = \"flex\"\n      div_dc.style.flexDirection = \"column\"\n      div_dc.style.cursor = \"pointer\"\n      div_dc.style.position = \"relative\"\n\n      var div50 = document.createElement(\"div\")\n      div50.style.top = \"50%\"\n    \tdiv50.style.left = \"50%\"\n      div50.style.position = \"absolute\"\n    \tdiv50.style.transform = \"translate(-50%, -50%)\"\n      div_dc.appendChild(div50);\n      \n      var div_btn = document.createElement(\"div\");\n      div_btn.className = \"btn_cont\";\n      div_btn.style.backgroundImage = \"url('\" + this.getChartImageName(type) + \"')\";\n      div_btn.style.backgroundSize = \"48px 48px\";\n      \u002f**\u002f\n      div_btn.style.width = \"48px\";\n      div_btn.style.height = \"48px\";\n    \tdiv_btn.style.marginLeft = \"50%\"\n    \tdiv_btn.style.transform = \"translate(-50%, 0%)\"\n      \n\u002f\u002f       div_btn.style.alignSelf = \"center\"\n\n      \u002f**\u002f\n      div50.appendChild(div_btn);\n      var div_lbl = document.createElement(\"div\");\n      div_lbl.className = \"txt_cont\";\n      var string_type = this.getTranslation(type);\n      if (availableInECharts(type))\n        string_type += \" *\";\n      div_lbl.textContent = string_type;\n      div_lbl.style.textAlign = \"center\"\n      div_lbl.style.textTransform = \"uppercase\"\n      div_lbl.style.fontWeight = \"600\"\n      div_lbl.style.paddingTop = \"5px\"\n      \u002f**\u002f\n      div50.appendChild(div_lbl);\n\n      this.boxtypes.Ctrl.appendChild(div_dc);\n      div_dc.onclick = selectChart;\n    }\n    \u002f\u002fthis.boxtypes.Ctrl.appendChild(div_c);\n\u002f\u002f   }\n}\n\nfunction getTranslation(type) {\n  if (ZtChartDict && ZtChartDict.Translate) {\n\t\tvar trad = ZtChartDict.Translate(\"ZTC_\" + type);\n\t\tif (typeof trad != \"object\")\n      return trad;\n\t\treturn trad.eng;\n\t}\n}\n\nfunction getChartImageName(type){\n\tvar ret = \"..\u002fportalstudio\u002fimages\u002ficon\u002fbtn_\";\n\tswitch(type){\n\t\tcase \"HBAR\":\n\t\t\tret+=\"hbars\";\n\t\t\tbreak;\n\t\tcase \"VBAR\":\n\t\t\tret+=\"bars\";\n\t\t\tbreak;\n\t\tcase \"HSTACKBAR\":\n\t\t\tret+=\"hstackbars\";\n\t\t\tbreak;\n\t\tcase \"VSTACKBAR\":\n\t\t\tret+=\"stackbars\";\n\t\t\tbreak;\n\t\tcase \"PIE\":\n\t\t\tret+=\"pies\";\n\t\t\tbreak;\n\t\tcase \"AREA\":\n\t\t\tret+=\"areas\";\n\t\t\tbreak;\n\t\tcase \"STACKEDAREA\":\n\t\t\tret+=\"stacked_areas\";\n\t\t\tbreak;\n\t\tdefault:\n      ret += type.toLowerCase()\n\t\t\tbreak;\n\t}\n\tret+=\".png\";\n\treturn ret;\n}\n\nfunction selectChart() {\n  if (!Empty(sel_type)) {\n  \t\u002f\u002fif (sel_type != this.id) {\n    \t\u002f\u002fdocument.getElementById(sel_type).checked = false;\n    \u002f\u002f}\n    \n      if (!Empty(sel_type)) {\n  \t\t\tLibJavascript.CssClassNameUtils.removeClass(document.getElementById(sel_type), \"sel_cont\");\n  \t\t}\n  }\n  sel_type = \u002f*this.checked ? *\u002fthis.id \u002f\u002f: \"\";\n  LibJavascript.CssClassNameUtils.addClass(this.id, \"sel_cont\");\n  _this.__ctype.Value(sel_type);\n}\n\nfunction initDataProviderCombo() {\n\tvar itms = GetOpener().itemsHTML,\n      val = \"\",\n      lab = \"\",\n    \tdpl = [];\n  for (var mm = 0; mm \u003c itms.length; mm++) {\n    if (itms[mm].type == 'SQLDataobj' || itms[mm].type == 'XMLDataobj' || itms[mm].derivType == 'SQLDataobj') {\n      val += itms[mm].name + \",\";\n      lab += itms[mm].name + \",\";\n      dpl.push(itms[mm]);\n    }\n  }\n  this.combodata.FillDataStatic(val.slice(0, val.length - 1), lab.slice(0, lab.length - 1));\n  this._dpList = dpl.slice();\n}\n\nfunction combodata_onChange(){\n  if (Empty(this.combodata.Value())) {\n    this.hideAllGrids()\n    return\n  }\n  var dpobj = this._dpList.filter(function(dp){ return dp.name == _this.combodata.Value(); })[0],\n      qflds;\n  \u002f\u002f preso da visualweb\u002fproperties.js\n  if (dpobj.GetQueryFields)\n  \tqflds = dpobj.GetQueryFields(dpobj.query, true);\n  else if (dpobj.query)\n    qflds = getQueryFields(dpobj.query);\n  \u002f\u002f fine\n  var data_grid = [],\n      num_grid = [];\n  for (var i = 0; i \u003c qflds[0].length; i++) {\n    data_grid.push([qflds[0][i], qflds[1][i], qflds[2][i]])\n    if (qflds[2][i] == \"N\")\n      num_grid.push([qflds[0][i], qflds[1][i], qflds[2][i]])\n  }\n  this.datafields.FillData(data_grid)\n  this.numfields.FillData(num_grid)\n  this.manageGrids()\n}\n\nfunction defname_onChange(){\n  var projectUrl = new JSURL(\"..\u002fservlet\u002fSPCHTProxy?m_cAction=load&m_cConfigName=\" + this.defname.Value(), true),\n    myResponse = projectUrl.Response(),\n    obj = JSON.parse(myResponse);\n    if (obj.graphSettings) {\n      \u002f\u002fthis.__ctype.Value(obj.graphSettings.chartType);\n      sel_type = obj.graphSettings.chartType;\n    }\n}\n\nfunction getChartFunctionGroup(type) {\n  var fncs = {\n    comp: [\"LINES\",\"RADARLINE\",\"RADARAREA\",\"AREA\",\"STACKEDAREA\",\n                  \"PCOORDS\",\"VBAR\",\"HBAR\",\"VSTACKBAR\",\"HSTACKBAR\",\n                  \"LAYEREDBAR\",\"LAYEREDBARH\",\"TREEMAPBAR\",\"TREEMAPBARH\",\n                  \"PYRAMID\",\"ARCDIAL\",\"THERMO\",\"DISPLAY\",\"COUNTER\",\"PADDLE\",\n                  \"LIGHTS\",\"IMAGES\"],\n    distr: [\"LINES\",\"AREA\",\"STACKEDAREA\",\"VBAR\",\"HBAR\",\"WATERF\",\n                    \"PYRAMID\",\"AREABAR\",\"SCATTER\",\"BUBBLE\",\"PARETO\",\n                    \"FUNNEL\",\"ASTER\",\"VORONOI\"],\n    rel: [\"RADARLINE\",\"RADARAREA\",\"PCOORDS\",\"SCATTER\",\"BUBBLE\",\n                    \"SUNB\",\"SUNBSTR\",\"TREE\",\"TREESTR\",\"CPACK\",\"CPACKSTR\",\n                    \"FORCE\",\"FORCESTR\",\"TREEMAP\",\"TREEMAPBAR\",\"TREEMAPBARH\",\n                    \"CHORD\",\"MATRIX\",\"BCMATRIX\",\"VORONOI\"],\n    ovtime: [\"LINES\",\"RADARLINE\",\"RADARAREA\",\"AREA\",\"STACKEDAREA\",\n                       \"VBAR\",\"HBAR\",\"WATERF\",\"CAL\"],\n    fhie: [\"MARIMEKKO\",\"SUNB\",\"SUNBSTR\",\"TREE\",\"TREESTR\",\"CPACK\",\"CPACKSTR\",\n                \"FORCE\",\"FORCESTR\",\"TREEMAP\",\"TREEMAPBAR\",\"TREEMAPBARH\"],\n    ptw: [\"MARIMEKKO\",\"PIE\",\"RING\",\"ASTER\",\"PYR\",\"PYRSTR\",\n                      \"WORDCLOUD\",\"SUNB\",\"SUNBSTR\",\"TREE\",\"TREESTR\",\n                      \"CPACK\",\"CPACKSTR\",\"FORCE\",\"FORCESTR\",\"TREEMAP\",\n                      \"TREEMAPBAR\",\"TREEMAPBARH\", \"RINGPERC\"],\n    con: [\"WORDCLOUD\",\"TREE\",\"TREESTR\",\"FORCE\",\"FORCESTR\"],\n    loc: [\"GEOMAP\"]\n  };\n\n  var kfnc = Object.keys(fncs),\n  rets = [];\n  for (var i = 0; i \u003c kfnc.length; i++) {\n    if (fncs[kfnc[i]].indexOf(type) \u003e= 0)\n      rets.push(kfnc[i]);\n  }\n\n  return rets;\n}\n\nfunction getChartFamilyGroup(type) {\n  var fams = {\n    car: [\"LINES\",\"RADARLINE\",\"RADARAREA\",\"AREA\",\"STACKEDAREA\",\n          \"PCOORDS\",\"VBAR\",\"HBAR\",\"VSTACKBAR\",\"HSTACKBAR\",\n          \"LAYEREDBAR\",\"LAYEREDBARH\",\"TREEMAPBAR\",\"TREEMAPBARH\",\n          \"WATERF\",\"PYRAMID\",\"AREABAR\",\"SCATTER\",\"BUBBLE\",\"ARCDIAL\",\n          \"THERMO\",\"PARETO\",\"MARIMEKKO\",\"FUNNEL\",\"BCMATRIX\"],\n    ind: [\"ARCDIAL\",\"THERMO\",\"LIGHTS\",\"IMAGES\",\"DISPLAY\",\"COUNTER\",\"PADDLE\",\"BCMATRIX\"],\n    aer: [\"MARIMEKKO\",\"PIE\",\"RING\",\"ASTER\",\"PYR\",\"PYRSTR\",\"WORDCLOUD\",\n          \"SUNB\",\"SUNBSTR\",\"CPACK\",\"CPACKSTR\",\"TREEMAP\",\"CHORD\",\"RINGPERC\"],\n    gra: [\"TREE\",\"TREESTR\",\"FORCE\",\"FORCESTR\",\"CHORD\",\"VORONOI\"],\n    tab: [\"MATRIX\",\"CAL\"],\n    gsp: [\"GEOMAP\"]\n  };\n\n  var kfam = Object.keys(fams),\n  rets = [];\n  for (var i = 0; i \u003c kfam.length; i++) {\n    if (fams[kfam[i]].indexOf(type) \u003e= 0)\n      rets.push(kfam[i]);\n  }\n\n  return rets;\n}\n\nfunction fillInfoBox() {\n\tvar type = this.__ctype.Value(),\n\t\t\tfams = getChartFamilyGroup(type),\n      fncs = getChartFunctionGroup(type);\n  this.infochart.Ctrl.innerHTML = \"\";\n  this.infochart.Ctrl.style.borderLeft = \"solid thin #888888\"\n  this.infochart.Ctrl.style.paddingLeft = \"5px\"\n  var div_c = document.createElement(\"div\");\n  div_c.className = \"c_cont\";\n  \u002f**\u002f\n  div_c.style.fontFamily = \"Open Sans\";\n  div_c.style.fontSize = \"13px\";\n  div_c.style.color = \"rgba(0,0,0,.85)\";\n  div_c.style.float = \"left\";\n  div_c.style.width = \"90%\";\n  \u002f\u002fdiv_c.style.marginLeft = \"3%\";\n  div_c.style.marginTop = \"10px\";\n  \u002f**\u002f\n  var div_btn = document.createElement(\"div\");\n  div_btn.className = \"btn_cont\";\n  div_btn.style.backgroundImage = \"url('\" + this.getChartImageName(type) + \"')\";\n  \u002f**\u002f\n  div_btn.style.width = \"24px\";\n  div_btn.style.height = \"24px\";\n  div_btn.style.float = \"left\";\n  div_btn.style.marginLeft = \"5px\";\n  \u002f**\u002f\n  div_c.appendChild(div_btn);\n  var div_t = document.createElement(\"div\");\n  div_t.className = \"t_cont\";\n  div_t.textContent = this.getTranslation(type);\n  \u002f**\u002f\n  div_t.style.fontWeight = 600;\n  div_t.style.fontSize = \"15px\";\n  div_t.style.marginLeft = \"5px\";\n  div_t.style.lineHeight = \"24px\";\n  div_t.style.float = \"left\";\n  \u002f**\u002f\n  div_c.appendChild(div_t);\n  this.infochart.Ctrl.appendChild(div_c);\n  \n  var txt_cont = document.createElement(\"div\");\n  txt_cont.className = \"label\";\n  txt_cont.style.padding = \"5px\";\n  txt_cont.style.float = \"left\";\n  var fam_div = document.createElement(\"div\");\n  fam_div.innerText = \"Functions\";\n  fam_div.style.fontWeight = 600\n  for (var i = 0; i \u003c fncs.length; i++) {\n    var inner = document.createElement(\"div\")\n    inner.textContent = this.getTranslation(fncs[i].toUpperCase())\n    inner.style.paddingLeft = \"5px\";\n    inner.style.fontWeight = 400\n    fam_div.appendChild(inner)\n  }\n  txt_cont.appendChild(fam_div);\n  fam_div = document.createElement(\"div\");\n  fam_div.innerText = \"Families\";\n  fam_div.style.marginTop = \"10px\";\n  fam_div.style.fontWeight = 600\n  for (var i = 0; i \u003c fams.length; i++) {\n    var inner = document.createElement(\"div\")\n    inner.textContent = this.getTranslation(fams[i].toUpperCase())\n    inner.style.paddingLeft = \"5px\";\n    inner.style.fontWeight = 400\n    fam_div.appendChild(inner)\n  }\n  txt_cont.appendChild(fam_div);\n  this.infochart.Ctrl.appendChild(txt_cont);\n  \n  \u002f*if (descMap_obj) {\n    if (descMap_obj[this.__ctype.Value()]) {\n      if (!Empty(descMap_obj[this.__ctype.Value()].sect_1)) {\n        fam_div = document.createElement(\"div\");\n        fam_div.innerText = \"How to read\";\n        fam_div.style.marginTop = \"10px\";\n        fam_div.style.fontWeight = 600\n        var inner = document.createElement(\"div\")\n        inner.textContent = descMap_obj[this.__ctype.Value()].sect_1\n        inner.style.padding = \"0px 5px\";\n        inner.style.textAlign = \"justify\"\n        inner.style.fontWeight = 400\n        fam_div.appendChild(inner)\n        txt_cont.appendChild(fam_div);\n      }\n      if (!Empty(descMap_obj[this.__ctype.Value()].sect_2)) {\n        fam_div = document.createElement(\"div\");\n        fam_div.innerText = \"Use cases\";\n        fam_div.style.marginTop = \"10px\";\n        fam_div.style.fontWeight = 600\n        var inner = document.createElement(\"div\")\n        inner.textContent = descMap_obj[this.__ctype.Value()].sect_2\n        inner.style.padding = \"0px 5px\";\n        inner.style.textAlign = \"justify\"\n        inner.style.fontWeight = 400\n        fam_div.appendChild(inner)\n        txt_cont.appendChild(fam_div);\n      }\n    }\n  }*\u002f\n}\n\nfunction __ctype_onChange(){\n  this.fillInfoBox()\n  this.manageGrids()\n}\n\nvar fldsGrid_Map = {\n\tcategory : { grids : [\"X\", \"Y\", \"S\"], positions : \"default\" },\n  xyz :  { grids : [\"X\", \"Y\", \"S\", \"Z\"], positions : \"default\" },\n  hie :  { grids : [\"allfields\", \"V\", \"hiepath\"], positions : \"default\" },\n  dep :  { grids : [\"src\", \"trg\", \"V\"], positions : [\"default\", \"default\", [27, 442]], titles : [\"Field for Source elements\", \"Field for Target elements\"] },\n  PIE :  { grids : [\"V\", \"S\"], positions : [\"default\", [27, 87]] },\n  geo :  { grids : [\"src\", \"trg\", \"V\"], positions : [\"default\", \"default\", [27, 442]], titles : [\"Main view field\", \"Subdivision view field\"] }\n}\nfldsGrid_Map.RING = fldsGrid_Map.RINGP = fldsGrid_Map.RADARLINE = fldsGrid_Map.RADARAREA = fldsGrid_Map.PIE;\n\nvar fldsGrid_def = {\n\tS: [27, 442],\n  V: [545, 87]\n}\n\nfunction makeRowGrid(alias,desc,type) {\n\tvar str = \"\";\n  str += \"\u003cdiv\u003e\";\n  str += desc;\n  str += \"\u003cdiv\u003e\";\n  str += (alias + \" (\" + type + \")\");\n  str += \"\u003c\u002fdiv\u003e\";\n  str += \"\u003c\u002fdiv\u003e\";\n  return str;\n}\n\nfunction manageGrids() {\n  if (Empty(this.__ctype.Value())) {\n    this.hideAllGrids()\n  \treturn;\n\t}\n  var g_fields = this.getGridFields()\n  \n  this.hideAllGrids()\n  var default_p = true;\n  for (var i = 0; i \u003c g_fields.grids.length; i++) {\n    default_p = true;\n    if (g_fields.positions && g_fields.positions != \"default\") {\n      if (g_fields.positions[i] && g_fields.positions[i] != \"default\") {\n        default_p = false;\n      \tthis[\"Grid_\" + g_fields.grids[i]].x = g_fields.positions[i][0]\n        this[\"Grid_\" + g_fields.grids[i]].y = g_fields.positions[i][1]\n        this[\"Grid_\" + g_fields.grids[i]]._setCtrlPos()\n      }\n    }\n    if (default_p && fldsGrid_def[g_fields.grids[i]]) {\n    \tthis[\"Grid_\" + g_fields.grids[i]].x = fldsGrid_def[g_fields.grids[i]][0]\n      this[\"Grid_\" + g_fields.grids[i]].y = fldsGrid_def[g_fields.grids[i]][1]\n      this[\"Grid_\" + g_fields.grids[i]]._setCtrlPos()\n    }\n    if (!Empty(g_fields.titles) && !Empty(g_fields.titles[i])) {\n      this[\"Grid_\" + g_fields.grids[i]].ColumnTitles(g_fields.titles[i])\n    }\n    this[\"Grid_\" + g_fields.grids[i]].Show()\n  }\n}\n\nfunction hideAllGrids() {\n\tthis.Grid_allfields.Hide()\n  this.Grid_hiepath.Hide()\n  this.Grid_S.Hide()\n  this.Grid_src.Hide()\n  this.Grid_trg.Hide()\n  this.Grid_V.Hide()\n  this.Grid_X.Hide()\n  this.Grid_Y.Hide()\n  this.Grid_Z.Hide()\n  if (!Empty(this.combodata.Value())) {\n    this.Grid_allfields.AllChecked(false)\n    this.Grid_hiepath.AllChecked(false)\n    this.Grid_S.AllChecked(false)\n    this.Grid_src.AllChecked(false)\n    this.Grid_trg.AllChecked(false)\n    this.Grid_V.AllChecked(false)\n    this.Grid_X.AllChecked(false)\n    this.Grid_Y.AllChecked(false)\n    this.Grid_Z.AllChecked(false)\n  }\n}\n\nfunction getGridFields() {\n  var macroType = GetOpener().getChartMacroType(this.__ctype.Value());\n  if (!(this.__ctype.Value() in fldsGrid_Map))\n    return fldsGrid_Map[macroType];\n  return fldsGrid_Map[this.__ctype.Value()];\n}\n\nfunction this_AfterPageChange(n,oldn){\n  if (n == 2 && oldn == 1) {\n    if (Empty(this.__ctype.Value()) || Empty(this.combodata.Value()))\n    \tthis.hideAllGrids()\n  }\n}\n\nfunction returnConfiguration() {\n\tvar confs = {};\n  confs.type = _this.__ctype.Value();\n  confs.def = (_this.Radio10.Value() == \"def\") ? _this.defname.Value() : null;\n  confs.dataobj = _this.combodata.Value();\n  confs.fields = {};\n  if (!Empty(confs.dataobj)) {\n    var grids = _this.getGridFields().grids;\n    for (var i = 0; i \u003c grids.length; i++) {\n      var data = _this[\"Grid_\" + grids[i]].GetSelectedData(),\n          dataTrs = _this[\"Grid_\" + grids[i]].GetSelectedDataAsTrsString(),\n          aliasIdx = data.Fields.indexOf(\"alias\");\n      if (Empty(dataTrs))\t\u002f\u002f nessuna riga selezionata\n        confs.fields[grids[i]] = [\"\"];\n      else {\n        confs.fields[grids[i]] = data.Data.reduce(function(filtered, elm) {\n          if (elm.indexOf('tf,') \u003c 0 && aliasIdx \u003e= 0)\n            filtered.push(elm[aliasIdx]);\n          return filtered;\n        }, []);\n      }\n    }\n  }\n\n  if (GetOpener() && GetOpener().SetChartWizardConfiguration) {\n  \tGetOpener().SetChartWizardConfiguration(confs);\n    GetOpener().closeSPModalLayer();\n  }\n  else\n    window.closeSPModalLayer();\n}\n\nvar chartfam = \"\";\nfunction drawBoxFams(){\n  this.boxfam.Ctrl.innerHTML = \"\";\n  this.boxfam.Ctrl.style.display = \"flex\";\n  this.boxfam.Ctrl.style.flexWrap = \"wrap\";\n  this.boxfam.Ctrl.style.flexDirection = \"row\";\n  var t_keys = Object.keys(typesMap);\n  for (var i = 0; i \u003c t_keys.length; i++) {\n  \tvar div_c = document.createElement(\"div\");\n    div_c.id = t_keys[i];\n    div_c.className = \"cf_cont\";\n    div_c.style.flex = \"0 0 25%\";\n    div_c.style.margin = \"6px 12px\"\n    div_c.style.border = \"thin solid #c0c0c0\"\n    div_c.style.borderRadius = \"10px\"\n    div_c.style.cursor = \"pointer\"\n    div_c.style.maxWidth = \"270px\";\n    div_c.style.maxHeight = \"30px\";\n    \n  \u002f*  [dir] .iYnYRTU.G7O-2Ch._2qM4tqZ, [dir] .iYnYRTU.G7O-2Ch:hover {\n    box-shadow: 0 2px 12px rgba(53,71,90,.2),0 0 0 1px rgba(68,92,116,.02);\n    -webkit-transform: translateY(-2px);\n    transform: translateY(-2px);\n}*\u002f\n    \n    \u002f**\u002f\n    div_c.style.fontFamily = \"Open Sans\";\n    div_c.style.fontSize = \"13px\";\n    div_c.style.color = \"rgba(0,0,0,.85)\";\n    \u002f**\u002f\n    var div_t = document.createElement(\"div\");\n    div_t.textContent = this.getTranslation(t_keys[i].toUpperCase());\n    div_t.style.fontWeight = 600;\n    div_t.style.fontSize = \"15px\";\n    div_t.style.textAlign = \"center\"\n\u002f\u002f     div_t.style.paddingTop = \"3%\"\n    \n    div_c.appendChild(div_t);\n    \n    this.boxfam.Ctrl.appendChild(div_c);\n    div_c.onclick = selectChartFam;\n  }\n}\n\nfunction selectChartFam() {\n  if (!Empty(chartfam)) {\n  \tLibJavascript.CssClassNameUtils.removeClass(document.getElementById(chartfam), \"sel_cont\");\n   \u002f** if (chartfam == this.id) {\n    \tchartfam = \"\";\n      return\n    }*\u002f\n  }\n  chartfam = this.id;\n  LibJavascript.CssClassNameUtils.addClass(this.id, \"sel_cont\");\n  _this.drawBoxTypes(chartfam)\n  _this.label_desc.Show()\n  \u002f\u002f pre-seleziono il primo\n  sel_type = typesMap[chartfam][0];\n  LibJavascript.CssClassNameUtils.addClass(document.getElementById(sel_type), \"sel_cont\");\n  _this.__ctype.Value(sel_type);\n}\n\nfunction availableInECharts(type) {\n\tvar typesAdv = [\"LAYEREDBAR\", \"LAYEREDBARH\", \"RINGPERC\", \"BUBBLE\", \"ASTER\", \"GEOMAP\", \"CPACK\", \"CPACKSTR\", \"MARIMEKKO\", \"MATRIX\", \"CHORD\", \"SANKEY\"];\n  return (typesAdv.indexOf(type) \u003c 0);\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"cursor: pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"image\",\"class_name\":\"image-default\",\"selector\":\".image-default\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"bg_color\":\"transparent\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"nobck\",\"selector\":\".nobck\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{},\"hover\":{\"code\":\"box-shadow: 0 2px 12px rgba(53,71,90,.2), 0 0 0 1px rgba(68,92,116,.02);\\ntransition: box-shadow .3s,border-color .3s,transform .3s,-webkit-transform .3s;\"},\":before\":{},\":after\":{}},\"current_state\":\"hover\",\"font_list\":[],\"type\":\"box\",\"class_name\":\"cf_cont\",\"selector\":\".cf_cont\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"border-width: 2px !important;\\nborder-color: #1ba1e2 !important;\\nbackground-color: rgb(27 161 226 \u002f 10%);\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"box\",\"class_name\":\"sel_cont\",\"selector\":\".sel_cont\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @ldatalist }}{{ @defname }}{{ @boxtypes }}{{ @Radio10 }}{{ @defpick }}{{ @combodata }}{{ @Grid_X }}{{ @infochart }}{{ @Grid_Y }}{{ @Grid_S }}{{ @Grid_Z }}{{ @Grid_allfields }}{{ @Grid_V }}{{ @Grid_hiepath }}{{ @Grid_src }}{{ @Grid_trg }}{{ @ldatalist }}{{ @defname }}{{ @boxtypes }}{{ @Radio10 }}{{ @defpick }}{{ @combodata }}{{ @Grid_X }}{{ @infochart }}{{ @Grid_Y }}{{ @Grid_S }}{{ @Grid_Z }}{{ @Grid_allfields }}{{ @Grid_V }}{{ @Grid_hiepath }}{{ @Grid_src }}{{ @Grid_trg }}{{ @Label21 }}{{ @boxfam }}{{ @toolbar_p1 }}{{ @Label21_Copy }}{{ @ldatalist }}{{ @defname }}{{ @boxtypes }}{{ @Radio10 }}{{ @defpick }}{{ @combodata }}{{ @Grid_X }}{{ @infochart }}{{ @Grid_Y }}{{ @Grid_S }}{{ @Grid_Z }}{{ @Grid_allfields }}{{ @Grid_V }}{{ @Grid_hiepath }}{{ @Grid_src }}{{ @Grid_trg }}{{ @Label21 }}{{ @boxfam }}{{ @toolbar_p1 }}{{ @label_desc }}{{ @btn1 }}{{ @btn1_Copy }}{{ @btn2 }}{{ @Label27 }}\u003c\u002fbody\u003e","grapesCss":"","h":"795,795","hsl":"","htmlcode":"{{ @toolbar_p1 }} \n{{ @toolbar_p1{{ @label_desc{{ @btn1{{ @btn2 }} \n }} \n }} \n }} \n\n\n{{ @Grid_trg }}\n{{ @Grid_src }}\n{{ @Grid_hiepath }}\n{{ @Grid_V }}\n{{ @Grid_allfields }}\n{{ @Grid_Z }}\n{{ @Grid_S }}\n{{ @Grid_Y }}\n\n\n{{ @infochart }}\n{{ @Grid_X }}\n\n\n\n{{ @ldatalist }}\n{{ @combodata }}\n{{ @boxtypes }}\n{{ @defname }}\n{{ @defpick }}\n{{ @Radio10 }}\n\n\n\n\n\n\n\n\n{{ @Label21 }} \n{{ @boxfam \n }} \n{{ @label_desc }} \n{{ @btn1 }} \n{{ @Label27 }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"ChartObj.js,ZtChartTransDict.js,ZtChartFunctions.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1,2","pagesProp":"[{\"title\":\"Select Chart\",\"layer\":\"\",\"h\":\"795\",\"w\":\"1400\",\"layout_steps_values\":{}},{\"title\":\"Select Data\",\"layer\":\"\",\"h\":\"795\",\"w\":\"1400\",\"layout_steps_values\":{}}]","pages_names":"Select Chart,Select Data","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"none","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"1400,1400","wizard":"true"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label floatlab","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"ldatalist","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Available data providers on portlet","w":"250","wireframe_props":"align,value,n_col","x":"26","y":"26","zindex":"9007","zone":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"true","font":"verdana","font_color":"","font_size":"","h":"25","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"defname","page":"1","password":"","picker":"","picture":"","placeholder":"Configuration (def) name *","rapp":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"180","wireframe_props":"name","x":"1430","y":"33","zerofilling":"false","zindex":"3","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"363","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"boxtypes","page":"1","rapp":"","sequence":"2","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"1353","wireframe_props":"","x":"29","y":"194","zindex":"16","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"chartType","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1279","y":"-29"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"49","helptipslist":"","hide":"true","hide_undercond":"","init":"","init_par":"'new'","layer":"false","layout_steps_values":"{}","name":"Radio10","orientation":"vertical","page":"1","picture":"","rapp":"","sequence":"4","spuid":"","tabindex":"","textlist":"New chart,Existing chartdef","type":"Radio","typevar":"character","valuelist":"new,def","visible":"true","w":"95","wireframe_props":"","x":"1443","y":"131","zindex":"15","zone":""},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"26","help_tips":"","hide":"true","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"defpick","page":"1","path_type":"","rapp":"","sequence":"5","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"26","wireframe_props":"","x":"1453","y":"74","zindex":"5","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox combodata","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"combodata","page":"2","picture":"","rapp":"","sequence":"6","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"214","wireframe_props":"name,textlist","x":"26","y":"43","zindex":"15","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Field for X\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"datafields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_X","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"7","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"249","wireframe_props":"colProperties,checkbox,rows","x":"27","y":"87","zindex":"9008","zone":""},{"alias":"alias,desc,type","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,C","h":"20","man_query":"","name":"datafields","page":"2","parms":"","parms_source":"","sequence":"8","type":"StaticDataProvider","w":"120","x":"1450","y":"112"},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"740","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"infochart","page":"2","rapp":"","sequence":"9","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"491","wireframe_props":"","x":"900","y":"9","zindex":"9010","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"__ctype","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1423","y":"-5"},{"alias":"alias,desc,type","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,C","h":"20","man_query":"","name":"numfields","page":"2","parms":"","parms_source":"","sequence":"11","type":"StaticDataProvider","w":"120","x":"1450","y":"137"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Field for Y\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"numfields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Y","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"12","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"249","wireframe_props":"colProperties,checkbox,rows","x":"545","y":"87","zindex":"9008","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Field for Serie\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"datafields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_S","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"13","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"249","wireframe_props":"colProperties,checkbox,rows","x":"27","y":"442","zindex":"9008","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Field for Z\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"numfields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Z","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"14","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"249","wireframe_props":"colProperties,checkbox,rows","x":"545","y":"442","zindex":"9008","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias,desc,type","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Select fields in order to represent Hierarchy path\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"datafields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_allfields","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"hiefields","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"15","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"418","wireframe_props":"colProperties,checkbox,rows","x":"27","y":"87","zindex":"9008","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Field for Values\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"numfields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_V","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"16","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"249","wireframe_props":"colProperties,checkbox,rows","x":"545","y":"87","zindex":"9008","zone":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10","name":"hiefields","offline":"false","page":"2","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"true","sequence":"17","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"1450","y":"162"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Hierarchy path\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"hiefields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"200","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_hiepath","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"18","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"418","wireframe_props":"colProperties,checkbox,rows","x":"27","y":"442","zindex":"9015","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Field for Source elements\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"datafields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_src","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"19","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"249","wireframe_props":"colProperties,checkbox,rows","x":"27","y":"87","zindex":"9008","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"alias","colProperties":"[{\"field\":\"function:makeRowGrid('%alias%','%desc%','%type%')\",\"title\":\"Field for Target elements\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":\"2\",\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"nobck","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"datafields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"340","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_trg","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"20","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"249","wireframe_props":"colProperties,checkbox,rows","x":"545","y":"87","zindex":"9008","zone":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label21","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select chart family","w":"200","wireframe_props":"align,value,n_col","x":"29","y":"17","zindex":"9016","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"84","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"boxfam","page":"1","rapp":"","sequence":"22","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"1353","wireframe_props":"","x":"29","y":"37","zindex":"9017","zone":""},{"FAB":"false","anchor":"","bg_color":"","css_class":"sptoolbar","ctrlOfVariant":"","fixed":"","h":"33","hide":"true","iconWidth":"30","layer":"false","layout_steps_values":"{}","maxToolbarItem":"","menu_bg_color":"","name":"toolbar_p1","page":"1","rapp":"","sequence":"23","spuid":"","toolbarAlign":"","type":"SPToolbar","w":"247","wireframe_props":"","x":"1440","y":"231","zindex":"9018","zone":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_desc","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select chart type","w":"200","wireframe_props":"align,value,n_col","x":"29","y":"174","zindex":"9016","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"36","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btn1","page":"1","rapp":"","sequence":"25","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"","w":"64","wireframe_props":"value","x":"1327","y":"749","zindex":"9019","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"36","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btn2","page":"2","rapp":"","sequence":"26","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"","w":"64","wireframe_props":"value","x":"1327","y":"749","zindex":"9019","zone":""},{"align":"right","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label27","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"27","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"* draw with alternative library","w":"200","wireframe_props":"align,value,n_col","x":"1178","y":"1","zindex":"9020","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"tool","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1591","y":"-6"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:tool*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));
if(sp.getParameter("SpStaticCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/javascript");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
window.SPChartWizard_Static=function(){
if(typeof btn1_Click !='undefined')this.btn1_Click=btn1_Click;
if(typeof btn2_Click !='undefined')this.btn2_Click=btn2_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof drawChartBoxes !='undefined')this.drawChartBoxes=drawChartBoxes;
if(typeof Radio10_onChange !='undefined')this.Radio10_onChange=Radio10_onChange;
if(typeof defpick_Click !='undefined')this.defpick_Click=defpick_Click;
if(typeof getTypeInMap !='undefined')this.getTypeInMap=getTypeInMap;
if(typeof drawBoxTypes !='undefined')this.drawBoxTypes=drawBoxTypes;
if(typeof getTranslation !='undefined')this.getTranslation=getTranslation;
if(typeof getChartImageName !='undefined')this.getChartImageName=getChartImageName;
if(typeof selectChart !='undefined')this.selectChart=selectChart;
if(typeof initDataProviderCombo !='undefined')this.initDataProviderCombo=initDataProviderCombo;
if(typeof combodata_onChange !='undefined')this.combodata_onChange=combodata_onChange;
if(typeof defname_onChange !='undefined')this.defname_onChange=defname_onChange;
if(typeof getChartFunctionGroup !='undefined')this.getChartFunctionGroup=getChartFunctionGroup;
if(typeof getChartFamilyGroup !='undefined')this.getChartFamilyGroup=getChartFamilyGroup;
if(typeof fillInfoBox !='undefined')this.fillInfoBox=fillInfoBox;
if(typeof __ctype_onChange !='undefined')this.__ctype_onChange=__ctype_onChange;
if(typeof makeRowGrid !='undefined')this.makeRowGrid=makeRowGrid;
if(typeof manageGrids !='undefined')this.manageGrids=manageGrids;
if(typeof hideAllGrids !='undefined')this.hideAllGrids=hideAllGrids;
if(typeof getGridFields !='undefined')this.getGridFields=getGridFields;
if(typeof this_AfterPageChange !='undefined')this.this_AfterPageChange=this_AfterPageChange;
if(typeof returnConfiguration !='undefined')this.returnConfiguration=returnConfiguration;
if(typeof drawBoxFams !='undefined')this.drawBoxFams=drawBoxFams;
if(typeof selectChartFam !='undefined')this.selectChartFam=selectChartFam;
if(typeof availableInECharts !='undefined')this.availableInECharts=availableInECharts;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
this.datafields.addRowConsumer(this.Grid_X);
this.numfields.addRowConsumer(this.Grid_Y);
this.datafields.addRowConsumer(this.Grid_S);
this.numfields.addRowConsumer(this.Grid_Z);
this.datafields.addRowConsumer(this.Grid_allfields);
this.numfields.addRowConsumer(this.Grid_V);
this.hiefields.addRowConsumer(this.Grid_hiepath);
this.datafields.addRowConsumer(this.Grid_src);
this.datafields.addRowConsumer(this.Grid_trg);
var _this = this;
this.btn1.Value(FormatMsg('RPT_APPLY'))
this.btn2.Value(FormatMsg('RPT_APPLY'))
function btn1_Click(){
  this.returnConfiguration()
}
function btn2_Click(){
  this.btn1_Click()
}
var initConf = null;
var gtype = null;
function this_Loaded(){
  this.boxtypes.Ctrl.innerHTML = "";
  
  this.boxfam.Ctrl.innerHTML = "";
  this.boxfam.Ctrl.style.border = "none"
  this.label_desc.Hide()
  
  this.boxtypes.Hide()
  this.defname.Hide()
  this.defpick.Hide()
  this.Radio10_onChange()
  if (this.tool.Value() == "portlet")
  	this.initDataProviderCombo()
  
  if (GetOpener() && GetOpener().GetChartWizardInitConf)
    initConf = GetOpener().GetChartWizardInitConf();
  if (!Empty(initConf)) {
    if (!Empty(initConf.def)) {
      if (initConf.def.indexOf("type:") >= 0) {
        this.Radio10.Value("new")
        this.drawChartBoxes(Strtran(initConf.def,"type:",""));
      }
      else {
        //this.Radio10.Value("def")
        this.Radio10.Value("new")
				this.defname.Value(initConf.def)
        this.drawChartBoxes(sel_type)
      }
    }
      else {	// pre-seleziono il primo grafico
        this.drawChartBoxes("LINES");
      }
    
    if (!Empty(initConf.dataobj)) {
      this.combodata.Value(initConf.dataobj)
      // campi
      if (!Empty(initConf.fields)) {
        gtype = getTypeInMap(sel_type);
      	var gflds = Object.keys(initConf.fields),
            datafieldsA = this.datafields.Data.map(function (field) { return field[0].toLowerCase(); }),
            numfieldsA = this.numfields.Data.map(function (field) { return field[0].toLowerCase(); });
        for (var i = 0; i < gflds.length; i++) {
          if (!Empty(initConf.fields[gflds[i]])) {
            var sel = initConf.fields[gflds[i]].split(",");
            for (var j = 0; j < sel.length; j++) {
              if (!Empty(sel[j])) {
                var refArray = eval(this["Grid_" + gflds[i]].dataobj + "A"),
                    idxRow = refArray.indexOf(sel[j].toLowerCase());
                if (idxRow >= 0) {
                  this["Grid_" + gflds[i]].CurrRow(idxRow)
                  this["Grid_" + gflds[i]].RowChecked(true)
                }
              }
            }
          }
        }
      }
    }
  }
  
  if (this.tool.Value() != "portlet")
    this.ZtTabs.Hide(2, true);
}
function drawChartBoxes(type) {
  sel_type = type;
  chartfam = getTypeInMap(sel_type);
  if (!Empty(chartfam)) {
    LibJavascript.CssClassNameUtils.addClass(document.getElementById(chartfam), "sel_cont");
    this.drawBoxTypes(chartfam)
    this.label_desc.Show()
    LibJavascript.CssClassNameUtils.addClass(document.getElementById(sel_type), "sel_cont");
    //document.getElementById(sel_type).checked = true;
    this.__ctype.Value(sel_type);
  }
  else
    this.drawChartBoxes("LINES");
}
function Radio10_onChange(){
  this.__ctype.Value("")
  if (this.Radio10.Value() == "new") {
    this.defname.Hide()
    this.defname.Value("")
    this.defpick.Hide()
    
    this.drawBoxFams()
    
    if (Empty(this.boxtypes.Ctrl.innerHTML))
    	this.drawBoxTypes()
    this.boxtypes.Show()
    if (!Empty(sel_type)) {
    	//document.getElementById(sel_type).checked = false;
      LibJavascript.CssClassNameUtils.removeClass(document.getElementById(sel_type), "sel_cont");
      sel_type = "";
    }
  }
  else {
    this.defname.Show()
    this.defpick.Show()
    this.boxtypes.Hide()
  }
}
function defpick_Click(){
  var ctrlname = this.formid + "_defname",
  		url = "../portalstudio/open.jsp?tool=chart&onetool=true&ExpressionID=" + URLenc(ctrlname) + "&callerFunction=expressionReturn",
      width = 930,
      height = 600,
      l = (screen.width) ? (screen.width - width) / 2 : 100,
      t = (screen.height) ? (screen.height - height) / 2 : 100,
      offlinemode = '';
  
	layerOpenForeground(url + "&SPModalLayerId=chartSPModalLayer" + offlinemode, "Select chart", "", width, height, true, 1);
}
var typesMap = {
      linearea: ["LINES","AREA","STACKEDAREA","PCOORDS","AREABAR"],
  		radars:["RADARLINE","RADARAREA"],
      bars: ["VBAR","VSTACKBAR","LAYEREDBAR","TREEMAPBAR","HBAR","HSTACKBAR","LAYEREDBARH","TREEMAPBARH","AREABAR"],
      pies: ["PIE","RING","RINGPERC","ASTER"],
      yz: ["SCATTER","BUBBLE","ASTER"],
      maps: ["GEOMAP"],
      hie: ["TREEMAP","SUNB", "CPACKSTR","CPACK", "MARIMEKKO","TREEMAPBAR","TREEMAPBARH"],
      rel: ["MATRIX", "CHORD", "SANKEY"]
    },
    sel_type = "";
function getTypeInMap(ctype) {
	var f = false,
      types = Object.keys(typesMap),
      key = "";
  for (var i = 0; Empty(key) && !f && i < types.length; i++) {
  	if (typesMap[types[i]].indexOf(ctype) >= 0) {
    	f = true;
      key = types[i];
    }
  }
  return key;
}
function drawBoxTypes(tkey){
  if (Empty(tkey)) return
  
  this.boxtypes.Ctrl.innerHTML = "";  
  
  this.boxtypes.Ctrl.style.display = "flex";
  this.boxtypes.Ctrl.style.flexWrap = "wrap";
  this.boxtypes.Ctrl.style.flexDirection = "row";
  
  var t_keys = Object.keys(typesMap);
//   for (var i = 0; i < t_keys.length; i++) {
//   	var div_c = document.createElement("div");
//     div_c.className = "c_cont";
    
//     div_c.style.fontFamily = "Open Sans";
//     div_c.style.fontSize = "13px";
//     div_c.style.color = "rgba(0,0,0,.85)";
//     div_c.style.float = "left";
//     div_c.style.width = "90%";
//     //div_c.style.marginLeft = "3%";
//     div_c.style.marginTop = "10px";
    
//     var div_t = document.createElement("div");
//     div_t.className = "t_cont";
//     div_t.textContent = this.getTranslation(t_keys[i].toUpperCase());
    
//     div_t.style.fontWeight = 600;
//     div_t.style.fontSize = "15px";
    
//     div_c.appendChild(div_t);
//     var div_det = document.createElement("div");
//     div_det.className = "det_cont";
    
//     div_det.style.float = "left";
//     div_det.style.margin = "5px";
    
//     div_c.appendChild(div_det);
    for (var j = 0; j < typesMap[tkey].length; j++) {
      var type = typesMap[tkey][j];
    	var div_dc = document.createElement("div");
      div_dc.id = type;
    	div_dc.className = "cf_cont dtc_cont";
      
      //div_dc.style.float = "left";
      //div_dc.style.padding = "5px";
      //div_dc.style.width = "200px";
      div_dc.style.flex = "0 0 25%";
    	div_dc.style.margin = "6px 12px"
    	div_dc.style.border = "thin solid #c0c0c0"
    	div_dc.style.borderRadius = "10px"
      div_dc.style.fontFamily = "Open Sans";
    	div_dc.style.fontSize = "13px";
     	div_dc.style.color = "rgba(0,0,0,.85)";
      div_dc.style.maxWidth = "160px"
      div_dc.style.maxHeight = "160px"
      div_dc.style.display = "flex"
      div_dc.style.flexDirection = "column"
      div_dc.style.cursor = "pointer"
      div_dc.style.position = "relative"
      var div50 = document.createElement("div")
      div50.style.top = "50%"
    	div50.style.left = "50%"
      div50.style.position = "absolute"
    	div50.style.transform = "translate(-50%, -50%)"
      div_dc.appendChild(div50);
      
      var div_btn = document.createElement("div");
      div_btn.className = "btn_cont";
      div_btn.style.backgroundImage = "url('" + this.getChartImageName(type) + "')";
      div_btn.style.backgroundSize = "48px 48px";
      
      div_btn.style.width = "48px";
      div_btn.style.height = "48px";
    	div_btn.style.marginLeft = "50%"
    	div_btn.style.transform = "translate(-50%, 0%)"
      
//       div_btn.style.alignSelf = "center"
      
      div50.appendChild(div_btn);
      var div_lbl = document.createElement("div");
      div_lbl.className = "txt_cont";
      var string_type = this.getTranslation(type);
      if (availableInECharts(type))
        string_type += " *";
      div_lbl.textContent = string_type;
      div_lbl.style.textAlign = "center"
      div_lbl.style.textTransform = "uppercase"
      div_lbl.style.fontWeight = "600"
      div_lbl.style.paddingTop = "5px"
      
      div50.appendChild(div_lbl);
      this.boxtypes.Ctrl.appendChild(div_dc);
      div_dc.onclick = selectChart;
    }
    //this.boxtypes.Ctrl.appendChild(div_c);
//   }
}
function getTranslation(type) {
  if (ZtChartDict && ZtChartDict.Translate) {
		var trad = ZtChartDict.Translate("ZTC_" + type);
		if (typeof trad != "object")
      return trad;
		return trad.eng;
	}
}
function getChartImageName(type){
	var ret = "../portalstudio/images/icon/btn_";
	switch(type){
		case "HBAR":
			ret+="hbars";
			break;
		case "VBAR":
			ret+="bars";
			break;
		case "HSTACKBAR":
			ret+="hstackbars";
			break;
		case "VSTACKBAR":
			ret+="stackbars";
			break;
		case "PIE":
			ret+="pies";
			break;
		case "AREA":
			ret+="areas";
			break;
		case "STACKEDAREA":
			ret+="stacked_areas";
			break;
		default:
      ret += type.toLowerCase()
			break;
	}
	ret+=".png";
	return ret;
}
function selectChart() {
  if (!Empty(sel_type)) {
  	//if (sel_type != this.id) {
    	//document.getElementById(sel_type).checked = false;
    //}
    
      if (!Empty(sel_type)) {
  			LibJavascript.CssClassNameUtils.removeClass(document.getElementById(sel_type), "sel_cont");
  		}
  }
  sel_type = this.id //: "";
  LibJavascript.CssClassNameUtils.addClass(this.id, "sel_cont");
  _this.__ctype.Value(sel_type);
}
function initDataProviderCombo() {
	var itms = GetOpener().itemsHTML,
      val = "",
      lab = "",
    	dpl = [];
  for (var mm = 0; mm < itms.length; mm++) {
    if (itms[mm].type == 'SQLDataobj' || itms[mm].type == 'XMLDataobj' || itms[mm].derivType == 'SQLDataobj') {
      val += itms[mm].name + ",";
      lab += itms[mm].name + ",";
      dpl.push(itms[mm]);
    }
  }
  this.combodata.FillDataStatic(val.slice(0, val.length - 1), lab.slice(0, lab.length - 1));
  this._dpList = dpl.slice();
}
function combodata_onChange(){
  if (Empty(this.combodata.Value())) {
    this.hideAllGrids()
    return
  }
  var dpobj = this._dpList.filter(function(dp){ return dp.name == _this.combodata.Value(); })[0],
      qflds;
  // preso da visualweb/properties.js
  if (dpobj.GetQueryFields)
  	qflds = dpobj.GetQueryFields(dpobj.query, true);
  else if (dpobj.query)
    qflds = getQueryFields(dpobj.query);
  // fine
  var data_grid = [],
      num_grid = [];
  for (var i = 0; i < qflds[0].length; i++) {
    data_grid.push([qflds[0][i], qflds[1][i], qflds[2][i]])
    if (qflds[2][i] == "N")
      num_grid.push([qflds[0][i], qflds[1][i], qflds[2][i]])
  }
  this.datafields.FillData(data_grid)
  this.numfields.FillData(num_grid)
  this.manageGrids()
}
function defname_onChange(){
  var projectUrl = new JSURL("../servlet/SPCHTProxy?m_cAction=load&m_cConfigName=" + this.defname.Value(), true),
    myResponse = projectUrl.Response(),
    obj = JSON.parse(myResponse);
    if (obj.graphSettings) {
      //this.__ctype.Value(obj.graphSettings.chartType);
      sel_type = obj.graphSettings.chartType;
    }
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
function fillInfoBox() {
	var type = this.__ctype.Value(),
			fams = getChartFamilyGroup(type),
      fncs = getChartFunctionGroup(type);
  this.infochart.Ctrl.innerHTML = "";
  this.infochart.Ctrl.style.borderLeft = "solid thin #888888"
  this.infochart.Ctrl.style.paddingLeft = "5px"
  var div_c = document.createElement("div");
  div_c.className = "c_cont";
  
  div_c.style.fontFamily = "Open Sans";
  div_c.style.fontSize = "13px";
  div_c.style.color = "rgba(0,0,0,.85)";
  div_c.style.float = "left";
  div_c.style.width = "90%";
  //div_c.style.marginLeft = "3%";
  div_c.style.marginTop = "10px";
  
  var div_btn = document.createElement("div");
  div_btn.className = "btn_cont";
  div_btn.style.backgroundImage = "url('" + this.getChartImageName(type) + "')";
  
  div_btn.style.width = "24px";
  div_btn.style.height = "24px";
  div_btn.style.float = "left";
  div_btn.style.marginLeft = "5px";
  
  div_c.appendChild(div_btn);
  var div_t = document.createElement("div");
  div_t.className = "t_cont";
  div_t.textContent = this.getTranslation(type);
  
  div_t.style.fontWeight = 600;
  div_t.style.fontSize = "15px";
  div_t.style.marginLeft = "5px";
  div_t.style.lineHeight = "24px";
  div_t.style.float = "left";
  
  div_c.appendChild(div_t);
  this.infochart.Ctrl.appendChild(div_c);
  
  var txt_cont = document.createElement("div");
  txt_cont.className = "label";
  txt_cont.style.padding = "5px";
  txt_cont.style.float = "left";
  var fam_div = document.createElement("div");
  fam_div.innerText = "Functions";
  fam_div.style.fontWeight = 600
  for (var i = 0; i < fncs.length; i++) {
    var inner = document.createElement("div")
    inner.textContent = this.getTranslation(fncs[i].toUpperCase())
    inner.style.paddingLeft = "5px";
    inner.style.fontWeight = 400
    fam_div.appendChild(inner)
  }
  txt_cont.appendChild(fam_div);
  fam_div = document.createElement("div");
  fam_div.innerText = "Families";
  fam_div.style.marginTop = "10px";
  fam_div.style.fontWeight = 600
  for (var i = 0; i < fams.length; i++) {
    var inner = document.createElement("div")
    inner.textContent = this.getTranslation(fams[i].toUpperCase())
    inner.style.paddingLeft = "5px";
    inner.style.fontWeight = 400
    fam_div.appendChild(inner)
  }
  txt_cont.appendChild(fam_div);
  this.infochart.Ctrl.appendChild(txt_cont);
  
  
}
function __ctype_onChange(){
  this.fillInfoBox()
  this.manageGrids()
}
var fldsGrid_Map = {
	category : { grids : ["X", "Y", "S"], positions : "default" },
  xyz :  { grids : ["X", "Y", "S", "Z"], positions : "default" },
  hie :  { grids : ["allfields", "V", "hiepath"], positions : "default" },
  dep :  { grids : ["src", "trg", "V"], positions : ["default", "default", [27, 442]], titles : ["Field for Source elements", "Field for Target elements"] },
  PIE :  { grids : ["V", "S"], positions : ["default", [27, 87]] },
  geo :  { grids : ["src", "trg", "V"], positions : ["default", "default", [27, 442]], titles : ["Main view field", "Subdivision view field"] }
}
fldsGrid_Map.RING = fldsGrid_Map.RINGP = fldsGrid_Map.RADARLINE = fldsGrid_Map.RADARAREA = fldsGrid_Map.PIE;
var fldsGrid_def = {
	S: [27, 442],
  V: [545, 87]
}
function makeRowGrid(alias,desc,type) {
	var str = "";
  str += "<div>";
  str += desc;
  str += "<div>";
  str += (alias + " (" + type + ")");
  str += "</div>";
  str += "</div>";
  return str;
}
function manageGrids() {
  if (Empty(this.__ctype.Value())) {
    this.hideAllGrids()
  	return;
	}
  var g_fields = this.getGridFields()
  
  this.hideAllGrids()
  var default_p = true;
  for (var i = 0; i < g_fields.grids.length; i++) {
    default_p = true;
    if (g_fields.positions && g_fields.positions != "default") {
      if (g_fields.positions[i] && g_fields.positions[i] != "default") {
        default_p = false;
      	this["Grid_" + g_fields.grids[i]].x = g_fields.positions[i][0]
        this["Grid_" + g_fields.grids[i]].y = g_fields.positions[i][1]
        this["Grid_" + g_fields.grids[i]]._setCtrlPos()
      }
    }
    if (default_p && fldsGrid_def[g_fields.grids[i]]) {
    	this["Grid_" + g_fields.grids[i]].x = fldsGrid_def[g_fields.grids[i]][0]
      this["Grid_" + g_fields.grids[i]].y = fldsGrid_def[g_fields.grids[i]][1]
      this["Grid_" + g_fields.grids[i]]._setCtrlPos()
    }
    if (!Empty(g_fields.titles) && !Empty(g_fields.titles[i])) {
      this["Grid_" + g_fields.grids[i]].ColumnTitles(g_fields.titles[i])
    }
    this["Grid_" + g_fields.grids[i]].Show()
  }
}
function hideAllGrids() {
	this.Grid_allfields.Hide()
  this.Grid_hiepath.Hide()
  this.Grid_S.Hide()
  this.Grid_src.Hide()
  this.Grid_trg.Hide()
  this.Grid_V.Hide()
  this.Grid_X.Hide()
  this.Grid_Y.Hide()
  this.Grid_Z.Hide()
  if (!Empty(this.combodata.Value())) {
    this.Grid_allfields.AllChecked(false)
    this.Grid_hiepath.AllChecked(false)
    this.Grid_S.AllChecked(false)
    this.Grid_src.AllChecked(false)
    this.Grid_trg.AllChecked(false)
    this.Grid_V.AllChecked(false)
    this.Grid_X.AllChecked(false)
    this.Grid_Y.AllChecked(false)
    this.Grid_Z.AllChecked(false)
  }
}
function getGridFields() {
  var macroType = GetOpener().getChartMacroType(this.__ctype.Value());
  if (!(this.__ctype.Value() in fldsGrid_Map))
    return fldsGrid_Map[macroType];
  return fldsGrid_Map[this.__ctype.Value()];
}
function this_AfterPageChange(n,oldn){
  if (n == 2 && oldn == 1) {
    if (Empty(this.__ctype.Value()) || Empty(this.combodata.Value()))
    	this.hideAllGrids()
  }
}
function returnConfiguration() {
	var confs = {};
  confs.type = _this.__ctype.Value();
  confs.def = (_this.Radio10.Value() == "def") ? _this.defname.Value() : null;
  confs.dataobj = _this.combodata.Value();
  confs.fields = {};
  if (!Empty(confs.dataobj)) {
    var grids = _this.getGridFields().grids;
    for (var i = 0; i < grids.length; i++) {
      var data = _this["Grid_" + grids[i]].GetSelectedData(),
          dataTrs = _this["Grid_" + grids[i]].GetSelectedDataAsTrsString(),
          aliasIdx = data.Fields.indexOf("alias");
      if (Empty(dataTrs))	// nessuna riga selezionata
        confs.fields[grids[i]] = [""];
      else {
        confs.fields[grids[i]] = data.Data.reduce(function(filtered, elm) {
          if (elm.indexOf('tf,') < 0 && aliasIdx >= 0)
            filtered.push(elm[aliasIdx]);
          return filtered;
        }, []);
      }
    }
  }
  if (GetOpener() && GetOpener().SetChartWizardConfiguration) {
  	GetOpener().SetChartWizardConfiguration(confs);
    GetOpener().closeSPModalLayer();
  }
  else
    window.closeSPModalLayer();
}
var chartfam = "";
function drawBoxFams(){
  this.boxfam.Ctrl.innerHTML = "";
  this.boxfam.Ctrl.style.display = "flex";
  this.boxfam.Ctrl.style.flexWrap = "wrap";
  this.boxfam.Ctrl.style.flexDirection = "row";
  var t_keys = Object.keys(typesMap);
  for (var i = 0; i < t_keys.length; i++) {
  	var div_c = document.createElement("div");
    div_c.id = t_keys[i];
    div_c.className = "cf_cont";
    div_c.style.flex = "0 0 25%";
    div_c.style.margin = "6px 12px"
    div_c.style.border = "thin solid #c0c0c0"
    div_c.style.borderRadius = "10px"
    div_c.style.cursor = "pointer"
    div_c.style.maxWidth = "270px";
    div_c.style.maxHeight = "30px";
    
  
    
    
    div_c.style.fontFamily = "Open Sans";
    div_c.style.fontSize = "13px";
    div_c.style.color = "rgba(0,0,0,.85)";
    
    var div_t = document.createElement("div");
    div_t.textContent = this.getTranslation(t_keys[i].toUpperCase());
    div_t.style.fontWeight = 600;
    div_t.style.fontSize = "15px";
    div_t.style.textAlign = "center"
//     div_t.style.paddingTop = "3%"
    
    div_c.appendChild(div_t);
    
    this.boxfam.Ctrl.appendChild(div_c);
    div_c.onclick = selectChartFam;
  }
}
function selectChartFam() {
  if (!Empty(chartfam)) {
  	LibJavascript.CssClassNameUtils.removeClass(document.getElementById(chartfam), "sel_cont");
   
  }
  chartfam = this.id;
  LibJavascript.CssClassNameUtils.addClass(this.id, "sel_cont");
  _this.drawBoxTypes(chartfam)
  _this.label_desc.Show()
  // pre-seleziono il primo
  sel_type = typesMap[chartfam][0];
  LibJavascript.CssClassNameUtils.addClass(document.getElementById(sel_type), "sel_cont");
  _this.__ctype.Value(sel_type);
}
function availableInECharts(type) {
	var typesAdv = ["LAYEREDBAR", "LAYEREDBARH", "RINGPERC", "BUBBLE", "ASTER", "GEOMAP", "CPACK", "CPACKSTR", "MARIMEKKO", "MATRIX", "CHORD", "SANKEY"];
  return (typesAdv.indexOf(type) < 0);
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.SPChartWizard_container .image-default{  cursor: pointer
}
.SPChartWizard_container .nobck{
  background-color: transparent;
}
.SPChartWizard_container .cf_cont:hover{
  box-shadow: 0 2px 12px rgba(53,71,90,.2), 0 0 0 1px rgba(68,92,116,.02);
  transition: box-shadow .3s,border-color .3s,transform .3s,-webkit-transform .3s;
}
.SPChartWizard_container .sel_cont{
  border-width: 2px !important;
  border-color: #1ba1e2 !important;
  background-color: rgb(27 161 226 / 10%);
}
.SPChartWizard_container {
}
.SPChartWizard_portlet{
  position:relative;
  min-width:1400px;
  height:795px;
}
.SPChartWizard_portlet[Data-page="1"]{
  height:795px;
  width:1400px;
}
.SPChartWizard_portlet[Data-page="2"]{
  height:795px;
  width:1400px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .ldatalist_ctrl {
  box-sizing:border-box;
  z-index:9007;
  position:absolute;
  display:inline-block;
  top:26px;
  left:26px;
  width:250px;
  height:auto;
  min-height:18px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .ldatalist_ctrl {
  height:auto;
  min-height:18px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .ldatalist_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartWizard_portlet > .SPChartWizard_page > .defname_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:33px;
  left:1430px;
  width:180px;
  height:25px;
  display:none;
}
.SPChartWizard_portlet > .SPChartWizard_page > .defname_ctrl {
}
.SPChartWizard_portlet > .SPChartWizard_page > .defname_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxtypes_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:194px;
  left:29px;
  width:1353px;
  height:auto;
  min-height:363px;
  display:flex;
  flex-direction:column;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxtypes_ctrl {
  height:363px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxtypes_ctrl > .box_content {
  height:100%;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxtypes_ctrl {
  min-height:363px;
  border-width:0px;
  border-style:solid;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Radio10_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:131px;
  left:1443px;
  width:95px;
  height:49px;
  display:none;
  height:auto;
  min-height:49px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .defpick_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:74px;
  left:1453px;
  width:26px;
  height:26px;
  display:none;
}
.SPChartWizard_portlet > .SPChartWizard_page > .defpick_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:26px;
  font-size:26px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .combodata_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:43px;
  left:26px;
  width:214px;
  height:25px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_X_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:87px;
  left:27px;
  width:249px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .infochart_ctrl {
  box-sizing:border-box;
  z-index:9010;
  position:absolute;
  display:inline-block;
  top:9px;
  left:900px;
  width:491px;
  height:auto;
  min-height:740px;
  display:flex;
  flex-direction:column;
}
.SPChartWizard_portlet > .SPChartWizard_page > .infochart_ctrl {
  height:740px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .infochart_ctrl > .box_content {
  height:100%;
}
.SPChartWizard_portlet > .SPChartWizard_page > .infochart_ctrl {
  min-height:740px;
  border-width:0px;
  border-style:solid;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_Y_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:87px;
  left:545px;
  width:249px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_S_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:442px;
  left:27px;
  width:249px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_Z_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:442px;
  left:545px;
  width:249px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_allfields_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:87px;
  left:27px;
  width:418px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_V_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:87px;
  left:545px;
  width:249px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_hiepath_ctrl {
  box-sizing:border-box;
  z-index:9015;
  position:absolute;
  display:inline-block;
  top:442px;
  left:27px;
  width:418px;
  height:auto;
  min-height:200px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_src_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:87px;
  left:27px;
  width:249px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Grid_trg_ctrl {
  box-sizing:border-box;
  z-index:9008;
  position:absolute;
  display:inline-block;
  top:87px;
  left:545px;
  width:249px;
  height:340px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Label21_ctrl {
  box-sizing:border-box;
  z-index:9016;
  position:absolute;
  display:inline-block;
  top:17px;
  left:29px;
  width:200px;
  height:auto;
  min-height:20px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Label21_ctrl {
  height:auto;
  min-height:20px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Label21_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxfam_ctrl {
  box-sizing:border-box;
  z-index:9017;
  position:absolute;
  display:inline-block;
  top:37px;
  left:29px;
  width:1353px;
  height:auto;
  min-height:84px;
  display:flex;
  flex-direction:column;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxfam_ctrl {
  height:84px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxfam_ctrl > .box_content {
  height:100%;
}
.SPChartWizard_portlet > .SPChartWizard_page > .boxfam_ctrl {
  min-height:84px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .toolbar_p1_ctrl {
  box-sizing:border-box;
  z-index:9018;
  position:absolute;
  display:inline-block;
  top:231px;
  left:1440px;
  width:247px;
  height:33px;
  display:none;
}
.SPChartWizard_portlet > .SPChartWizard_page > .label_desc_ctrl {
  box-sizing:border-box;
  z-index:9016;
  position:absolute;
  display:inline-block;
  top:174px;
  left:29px;
  width:200px;
  height:auto;
  min-height:20px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .label_desc_ctrl {
  height:auto;
  min-height:20px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .label_desc_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPChartWizard_portlet > .SPChartWizard_page > .btn1_ctrl {
  box-sizing:border-box;
  z-index:9019;
  position:absolute;
  display:inline-block;
  top:749px;
  left:1327px;
  width:64px;
  height:36px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .btn1_ctrl {
}
.SPChartWizard_portlet > .SPChartWizard_page > .btn2_ctrl {
  box-sizing:border-box;
  z-index:9019;
  position:absolute;
  display:inline-block;
  top:749px;
  left:1327px;
  width:64px;
  height:36px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .btn2_ctrl {
}
.SPChartWizard_portlet > .SPChartWizard_page > .Label27_ctrl {
  box-sizing:border-box;
  z-index:9020;
  position:absolute;
  display:inline-block;
  top:1px;
  left:1178px;
  right:22px;
  width:200px;
  height:auto;
  min-height:20px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Label27_ctrl {
  height:auto;
  min-height:20px;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Label27_ctrl {
  overflow:hidden;
  text-align:right;
}
<%}else if(sp.getParameter("SpWireframe","").equals("true")){
String containerId=sp.getParameter("containerID",idPortlet);
Library.SetMimeType(response,"text/html");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
PrintWireFrame(containerId,out);
%>
<%!
void PrintWireFrame(String containerId, java.io.Writer out) throws java.lang.Throwable {
 String def="[{\"h\":\"795,795\",\"layout_steps_values\":{},\"pages_names\":\"Select Chart,Select Data\",\"steps\":\"\",\"title\":\"none\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"1400,1400\",\"wizard\":\"true\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Available data providers on portlet\",\"w\":\"250\",\"x\":\"26\",\"y\":\"26\",\"zindex\":\"9007\"},{\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"defname\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"180\",\"x\":\"1430\",\"y\":\"33\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"363\",\"layout_steps_values\":{},\"name\":\"boxtypes\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"1353\",\"x\":\"29\",\"y\":\"194\",\"zindex\":\"16\"},{\"h\":\"20\",\"name\":\"chartType\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1279\",\"y\":\"-29\"},{\"anchor\":\"\",\"h\":\"49\",\"layout_steps_values\":{},\"name\":\"Radio10\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"95\",\"x\":\"1443\",\"y\":\"131\",\"zindex\":\"15\"},{\"anchor\":\"top-left\",\"h\":\"26\",\"layout_steps_values\":{},\"name\":\"defpick\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"26\",\"x\":\"1453\",\"y\":\"74\",\"zindex\":\"5\"},{\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"combodata\",\"page\":\"2\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"214\",\"x\":\"26\",\"y\":\"43\",\"zindex\":\"15\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field for X\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_X\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"249\",\"x\":\"27\",\"y\":\"87\",\"zindex\":\"9008\"},{\"h\":\"20\",\"name\":\"datafields\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"1450\",\"y\":\"112\"},{\"anchor\":\"\",\"h\":\"740\",\"layout_steps_values\":{},\"name\":\"infochart\",\"page\":\"2\",\"type\":\"Box\",\"w\":\"491\",\"x\":\"900\",\"y\":\"9\",\"zindex\":\"9010\"},{\"h\":\"20\",\"name\":\"__ctype\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1423\",\"y\":\"-5\"},{\"h\":\"20\",\"name\":\"numfields\",\"page\":\"2\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"1450\",\"y\":\"137\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field for Y\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_Y\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"249\",\"x\":\"545\",\"y\":\"87\",\"zindex\":\"9008\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field for Serie\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_S\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"249\",\"x\":\"27\",\"y\":\"442\",\"zindex\":\"9008\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field for Z\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_Z\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"249\",\"x\":\"545\",\"y\":\"442\",\"zindex\":\"9008\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Select fields in order to represent Hierarchy path\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_allfields\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"418\",\"x\":\"27\",\"y\":\"87\",\"zindex\":\"9008\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field for Values\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_V\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"249\",\"x\":\"545\",\"y\":\"87\",\"zindex\":\"9008\"},{\"h\":\"20\",\"name\":\"hiefields\",\"page\":\"2\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1450\",\"y\":\"162\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Hierarchy path\"}],\"h\":\"200\",\"layout_steps_values\":{},\"name\":\"Grid_hiepath\",\"page\":\"2\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"418\",\"x\":\"27\",\"y\":\"442\",\"zindex\":\"9015\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field for Source elements\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_src\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"249\",\"x\":\"27\",\"y\":\"87\",\"zindex\":\"9008\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field for Target elements\"}],\"h\":\"340\",\"layout_steps_values\":{},\"name\":\"Grid_trg\",\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"249\",\"x\":\"545\",\"y\":\"87\",\"zindex\":\"9008\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label21\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Select chart family\",\"w\":\"200\",\"x\":\"29\",\"y\":\"17\",\"zindex\":\"9016\"},{\"anchor\":\"\",\"h\":\"84\",\"layout_steps_values\":{},\"name\":\"boxfam\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"1353\",\"x\":\"29\",\"y\":\"37\",\"zindex\":\"9017\"},{\"anchor\":\"\",\"h\":\"33\",\"layout_steps_values\":{},\"name\":\"toolbar_p1\",\"page\":\"1\",\"type\":\"SPToolbar\",\"w\":\"247\",\"x\":\"1440\",\"y\":\"231\",\"zindex\":\"9018\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_desc\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Select chart type\",\"w\":\"200\",\"x\":\"29\",\"y\":\"174\",\"zindex\":\"9016\"},{\"anchor\":\"\",\"h\":\"36\",\"layout_steps_values\":{},\"name\":\"btn1\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"\",\"w\":\"64\",\"x\":\"1327\",\"y\":\"749\",\"zindex\":\"9019\"},{\"anchor\":\"\",\"h\":\"36\",\"layout_steps_values\":{},\"name\":\"btn2\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"\",\"w\":\"64\",\"x\":\"1327\",\"y\":\"749\",\"zindex\":\"9019\"},{\"align\":\"right\",\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label27\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"* draw with alternative library\",\"w\":\"200\",\"x\":\"1178\",\"y\":\"1\",\"zindex\":\"9020\"},{\"h\":\"20\",\"name\":\"tool\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1591\",\"y\":\"-6\"}]";
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("stdFunctions.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("portalstudio/renderDef.js")+"'></script>\n");
 out.write("<script src='../"+SPPrxycizer.proxycizedPath("visualweb/itemsObj.js")+"'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../visualweb/itemsObj.css'></script>\n");
 out.write("<link type='text/css' rel='STYLESHEET' href='../portalstudio/renderDef.css'></script>\n");
 out.write("<div id="+JSPLib.ToHTMLValue(containerId)+"></div>\n");
 out.write("<script> /*JS_MARKER_START*/\n");
 out.write("new renderDef({\n");
 out.write("def: "+def+",\n");
 out.write("container: '"+JSPLib.ToJSValue(containerId)+"',\n");
 out.write("replaceContainer: true\n");
 out.write("})\n");
 out.write("/*JS_MARKER_END*/ </script>\n");
}/**/%>
<%}else{
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPChartWizard","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPChartWizard_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
ZtVWeb.RequireLibrary('<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>');
<%String variantTabstrip=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantTabstrip != null) { %> ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');<%}%>
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<% sp.WritePortalStudioCSS(request, out); 
if(Library.IsMobile(request)){%><%}%>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>
.SPChartWizard_portlet > .SPChartWizard_page > .defname_ctrl {
  display:none;
}
.SPChartWizard_portlet > .SPChartWizard_page > .Radio10_ctrl {
  display:none;
}
.SPChartWizard_portlet > .SPChartWizard_page > .defpick_ctrl {
  display:none;
}
.SPChartWizard_portlet > .SPChartWizard_page > .toolbar_p1_ctrl {
  display:none;
}

</style>
<script src="../<%=SPPrxycizer.proxycizedPath("ChartObj.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("ZtChartTransDict.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("ZtChartFunctions.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPChartWizard','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String ldatalist= "Available data providers on portlet";
String defname= "";
if(request.getAttribute("SPChartWizard_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String chartType= "";
String Radio10="new";
String combodata= "";
if(request.getAttribute("SPChartWizard_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%if(request.getAttribute("SPChartWizard_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
String __ctype= "";
String Label21= "Select chart family";
String label_desc= "Select chart type";
String Label27= "* draw with alternative library";
String tool=JSPLib.translateXSS(sp.getParameter("tool",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPChartWizard_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPChartWizard_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPChartWizard','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPChartWizard_page' style='display:block'>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_defname_wrp'><input id='<%=idPortlet%>_defname' name='defname' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='defname' placeholder=' '/>
<label for=<%=idPortlet%>_defname>Configuration (def) name *</label></span>
<div id='<%=idPortlet%>_boxtypes' class='boxtypes_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_boxtypes_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_Radio10' class='radio' style='z-index:1;'></div>
<a id='<%=idPortlet%>_defpick' class='image-default defpick_ctrl'   target=''>&#xe9fb;</a>
<span id='<%=idPortlet%>_Label21'  formid='<%=idPortlet%>' ps-name='Label21'    class='label Label21_ctrl'><div id='<%=idPortlet%>_Label21tbl' style='width:100%;'><%=JSPLib.ToHTML("Select chart family")%></div></span>
<div id='<%=idPortlet%>_boxfam' class='boxfam_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_boxfam_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_toolbar_p1' class='disable-selection ctrl_sptoolbar_container sptoolbar' >
<div id='<%=idPortlet%>_toolbar_p1_openMenuHandlerDiv' class='sptoolbar_openMenuHandlerDiv'>
<a id='<%=idPortlet%>_toolbar_p1_openMenuHandlerImg' class='sptoolbar_3dots_handler'></a>
</div>
<div id='<%=idPortlet%>_toolbar_p1_listButtons' class='sptoolbar_listButtons'></div>
</div>
<span id='<%=idPortlet%>_label_desc'  formid='<%=idPortlet%>' ps-name='label_desc'    class='label label_desc_ctrl'><div id='<%=idPortlet%>_label_desctbl' style='width:100%;'><%=JSPLib.ToHTML("Select chart type")%></div></span>
<input id='<%=idPortlet%>_btn1' type='button' class='button btn1_ctrl'/>
<span id='<%=idPortlet%>_Label27'  formid='<%=idPortlet%>' ps-name='Label27'    class='label Label27_ctrl'><div id='<%=idPortlet%>_Label27tbl' style='width:100%;'><%=JSPLib.ToHTML("* draw with alternative library")%></div></span>
</div>
<div id='<%=idPortlet%>_page_2' class='SPChartWizard_page' style='display:none'>
<span id='<%=idPortlet%>_ldatalist'  formid='<%=idPortlet%>' ps-name='ldatalist'    class='label floatlab ldatalist_ctrl'><div id='<%=idPortlet%>_ldatalisttbl' style='width:100%;'><%=JSPLib.ToHTML("Available data providers on portlet")%></div></span>
<select id='<%=idPortlet%>_combodata' name='combodata' class='combobox combodata' style=''></select>
<div id='<%=idPortlet%>_Grid_X' formid='<%=idPortlet%>' ps-name='Grid_X'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_infochart' class='infochart_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_infochart_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_Grid_Y' formid='<%=idPortlet%>' ps-name='Grid_Y'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_S' formid='<%=idPortlet%>' ps-name='Grid_S'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_Z' formid='<%=idPortlet%>' ps-name='Grid_Z'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_allfields' formid='<%=idPortlet%>' ps-name='Grid_allfields'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_V' formid='<%=idPortlet%>' ps-name='Grid_V'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_hiepath' formid='<%=idPortlet%>' ps-name='Grid_hiepath'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_src' formid='<%=idPortlet%>' ps-name='Grid_src'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_trg' formid='<%=idPortlet%>' ps-name='Grid_trg'   class='grid' style=''>&nbsp;</div>
<input id='<%=idPortlet%>_btn2' type='button' class='button btn2_ctrl'/>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPChartWizard');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("RPT_APPLY",true)+","+JSPLib.ToJSValue(sp.translate("RPT_APPLY"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPChartWizard_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:true, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Select Chart"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Select Data"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPChartWizard',["1400","1400"],["795","795"],'portlet',<%=sp.isOfflineInstallation()%>,true,m_cSPPageletId,'', '','','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1400","h":"795","title":"Select Chart","layer":""},{"layout_steps_values":{},"w":"1400","h":"795","title":"Select Data","layer":""}]);
this.ldatalist=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label floatlab","create_undercond":"","ctrlid":"<%=idPortlet%>_ldatalist","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"ldatalist","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(ldatalist,false,true)%>","type":"Label","w":250,"x":26,"y":26,"zindex":"9007"});
this.defname=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_defname","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":true,"h":25,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"defname","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(defname,false,true)%>","w":180,"x":1430,"y":33,"zerofilling":false,"zindex":"3","zoom":""});
this.boxtypes=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_boxtypes","groupName":"","h":363,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"boxtypes","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":1353,"x":29,"y":194,"zindex":"16"});
this.chartType=new ZtVWeb._VC(this,'chartType',null,'character','<%=JSPLib.ToJSValue(chartType,false,true)%>',false,false);
this.Radio10=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"","captionsList":"New chart,Existing chartdef","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio10","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":49,"helptipsList":"","hide":"true","hide_undercond":"","init":"","init_par":"'new'","layer":false,"layout_steps_values":{},"name":"Radio10","orientation":"vertical","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"new,def","visible":true,"w":95,"x":1443,"y":131,"zindex":"15"});
this.Radio10.Value('<%=JSPLib.ToJSValue(Radio10,false,true)%>');
this.defpick=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default defpick_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_defpick","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":26,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"true","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"defpick","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":26,"x":1453,"y":74,"zindex":"5"});
 ZtVWeb.RequireFont("icons8_win10","");
this.combodata=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox combodata","create_undercond":"","ctrlid":"<%=idPortlet%>_combodata","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":25,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=combodata%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"combodata","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":214,"x":26,"y":43,"zindex":"15"});
this.Grid_X=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_X","dataobj":"datafields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_X","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":249,"x":27,"y":87,"zindex":"9008"});
this.Grid_X.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Field for X","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.datafields=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_datafields","dataproviders":"","fieldsString":"alias,desc,type","fieldstypeString":"C,C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"datafields","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":1450,"y":112});
this.infochart=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_infochart","groupName":"","h":740,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"infochart","page":2,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":491,"x":900,"y":9,"zindex":"9010"});
this.__ctype=new ZtVWeb._VC(this,'__ctype',null,'character','<%=JSPLib.ToJSValue(__ctype,false,true)%>',false,false);
this.numfields=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_numfields","dataproviders":"","fieldsString":"alias,desc,type","fieldstypeString":"C,C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"numfields","page":2,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":1450,"y":137});
this.Grid_Y=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Y","dataobj":"numfields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Y","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":249,"x":545,"y":87,"zindex":"9008"});
this.Grid_Y.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Field for Y","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_S=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_S","dataobj":"datafields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_S","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":249,"x":27,"y":442,"zindex":"9008"});
this.Grid_S.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Field for Serie","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_Z=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Z","dataobj":"numfields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Z","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":249,"x":545,"y":442,"zindex":"9008"});
this.Grid_Z.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Field for Z","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_allfields=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias,desc,type","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_allfields","dataobj":"datafields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_allfields","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"hiefields","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":418,"x":27,"y":87,"zindex":"9008"});
this.Grid_allfields.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Select fields in order to represent Hierarchy path","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_V=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_V","dataobj":"numfields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_V","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":249,"x":545,"y":87,"zindex":"9008"});
this.Grid_V.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Field for Values","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.hiefields=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_hiefields","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"hiefields","nrows":"10","page":2,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":1450,"y":162});
this.Grid_hiepath=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_hiepath","dataobj":"hiefields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":200,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_hiepath","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":418,"x":27,"y":442,"zindex":"9015"});
this.Grid_hiepath.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Hierarchy path","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_src=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_src","dataobj":"datafields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_src","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":249,"x":27,"y":87,"zindex":"9008"});
this.Grid_src.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Field for Source elements","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_trg=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"alias","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"nobck","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_trg","dataobj":"datafields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":340,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_trg","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":249,"x":545,"y":87,"zindex":"9008"});
this.Grid_trg.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Field for Target elements","align":"","type":"C","ColSpan":"2","layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:makeRowGrid('%alias%','%desc%','%type%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Label21=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label21","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label21","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label21,false,true)%>","type":"Label","w":200,"x":29,"y":17,"zindex":"9016"});
this.boxfam=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"box","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_boxfam","groupName":"","h":84,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"boxfam","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":1353,"x":29,"y":37,"zindex":"9017"});
this.toolbar_p1=new ZtVWeb.SPToolbarCtrl(this,{"FAB":"false","anchor":"top-left","bg_color":"","cssClass":"sptoolbar","ctrlid":"<%=idPortlet%>_toolbar_p1","h":33,"hide":"true","iconWidth":30,"layer":false,"layout_steps_values":{},"maxToolbarItem":0,"menu_bg_color":"","name":"toolbar_p1","page":1,"spuid":"","toolbarAlign":"","type":"SPToolbar","w":247,"x":1440,"y":231,"zindex":"9018"});
this.label_desc=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_desc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_desc","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_desc,false,true)%>","type":"Label","w":200,"x":29,"y":174,"zindex":"9016"});
this.btn1=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btn1_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn1","edit_undercond":"","font":"","font_color":"","font_size":"","h":36,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn1","page":1,"spuid":"","tabindex":"","text":"","type":"Button","type_submit":"false","type_wizard":"","w":64,"x":1327,"y":749,"zindex":"9019"});
this.btn2=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btn2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn2","edit_undercond":"","font":"","font_color":"","font_size":"","h":36,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn2","page":2,"spuid":"","tabindex":"","text":"","type":"Button","type_submit":"false","type_wizard":"","w":64,"x":1327,"y":749,"zindex":"9019"});
this.Label27=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label27","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label27","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label27,false,true)%>","type":"Label","w":200,"x":1178,"y":1,"zindex":"9020"});
this.tool=new ZtVWeb._VC(this,'tool',null,'character','<%=JSPLib.ToJSValue(tool,false,true)%>',false,false);
<%if(!Library.Empty(PageletId) ){%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
<%}%>

}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
<%=idPortlet%>_tabstrip.Select('page1');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPChartWizard_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPChartWizard_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPChartWizard_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.defpick.dispatchEvent('OnLoad');
window.<%=idPortlet%>.hiefields.firstQuery('true');
window.<%=idPortlet%>.combodata.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPChartWizard',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPChartWizard');
/*JS_MARKER_END*/
</script>
<%if(!included){%>
</body>
<%}
}finally{
}%>
<%if(!included){%>
</html>
<%}
sp.endPage("SPChartWizard");
}%>
<%! public String getJSPUID() { return "1080903765"; } %>