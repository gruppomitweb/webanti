<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var self = this,\n    mcontainer,\n    isMaximized = false,\n    allFieldsSQL = null;\n\nfunction this_Loaded(){\n  try {\n    if (this.printNoZoom.Value()) {  \u002f\u002f SPReportMaskParameter.directSmartReportPrint\n      if (!Empty(this.ReportName.Value())) {\n        var url = new JSURL(\"..\u002fservlet\u002fSPSVRPProxy?action=load&name=\" + this.ReportName.Value() + \"&custom=\" + this.custom.Value(), true);\n        var reportDefObj = JSON.parse(url.Response());\n        var params = \"\";\n        var pplet = GetOpener().ZtVWeb.getPortletById(this.portletID.Value());\t\u002f\u002f portlet z.print\n        if (!Empty(this.RPwindowID.Value())) {\n          var ids = this.RPwindowID.Value().split(\"#\");\n          pplet = GetOpener().ZtVWeb.getPortletById(ids[0]); \u002f\u002f portlet masch. stampa\n          \u002f\u002f se e' empty cerco nel parent window, dove dovrebbe essere inserito nel pom\n          if (Empty(pplet) && !Empty(ids[1])) {\n            var pwin = window.parent.document.getElementById(ids[1]);\n            \u002f\u002f provo con opener\n            if (Empty(pwin))\n              pwin = GetOpener().parent.document.getElementById(ids[1]);\n            \u002f\u002f provo con window.top\n            if (Empty(pwin))\n              pwin = window.top.document.getElementById(ids[1]);\n            if (!Empty(pwin)) {\n          \t\tpplet = pwin.contentWindow.ZtVWeb.getPortletById(ids[0]);\n            }\n          }\n        }\n        if (pplet && pplet.getSubmitData) {\n          params = pplet.getSubmitData(false);\n          params = Strtran(params,'&',',');\n        }\n        var coverObj = null;\n        if (pplet && pplet.getCoverObject) {\n          coverObj = pplet.getCoverObject();\n        }\n        var mdatasource = reportDefObj.datasource;\n        var clonedataobj;\n        this.SdataProvider.ChangeQuery(mdatasource)\n        if(mdatasource.indexOf(\"BO:\")\u003e=0){\n          this.SdataProvider.queryfilter=params;\n        }\n        else {\u002f\u002f vqr\n          this.SdataProvider.parms=params;\n        }\n        clonedataobj = this.SdataProvider._getCloneForPrint();\n\n        if(window.tool) {\n          window.tool = \"\";\n        }\n \n        var act = {};\n        act.autoprint = this.directPrint.Value();\n        act.autodownload = this.directDown.Value();\n        act.coverobj = coverObj;\n        act.theme = ZtVWeb.theme;\n\n        mcontainer = document.createElement(\"div\");\n        mcontainer.id = this.formid+\"_div\";\n        mcontainer.style.width = \"99%\";\n        mcontainer.style.height = (window.innerHeight - 2) + \"px\";  \u002f\u002f\"99%\";\n        this.Ctrl.appendChild(mcontainer); \n        \n        JSRepDrawDocumentViewProvider( reportDefObj \u002f\u002fsmartreport def\n                                      , this.outputFormat.Value().toLowerCase()\n                                      , clonedataobj \u002f\u002f datasource\n                                      , mcontainer \u002f\u002f preview container\n                                      , this.FileName.Value() \u002f\u002f FileName. ReportName when empty\n                                      , act\n                                      , false  \u002f\u002f parametro che dice se i dati sono simulati\n                                      , this._resizeAtEnd  \u002f\u002f end callback\n                                      , this.bPreview.Value()\n                                      , false\n                                     );\n      }\n    }\n    else {\n      var parentPortlet = GetOpener().ZtVWeb.getPortletById(this.parentPortletID.Value());\n      var gridCtrl = parentPortlet[this.gridName.Value()];\n\n      var dataobj, clonedataobj;\n      if( gridCtrl.GetPrintDataObj ){\n        clonedataobj = gridCtrl.GetPrintDataObj();\n      }\n      else {\n        dataobj = parentPortlet[gridCtrl.dataobj];\n        clonedataobj = dataobj._getCloneForPrint();\n      }\n\n      var pplet = GetOpener().ZtVWeb.getPortletById(this.portletID.Value());\n      if (pplet && pplet.getSpFields)\n        this.fields.Value(pplet.getSpFields());\n\n      var coverObj = null;\n      if (pplet && pplet.getCoverObject)\n        coverObj = pplet.getCoverObject();\n\n      clonedataobj.dataconsumers = [];\n      clonedataobj.rowsconsumers = [];\n      clonedataobj.paramconsumers = [];\n      clonedataobj.nRows = 5000;\u002f\u002fdataobjnRows * 100;\n\n      var page = {};\n      page.format = \"A4\";\n      page.orientation = \"portrait\";\n\n      var margins = {};\n      margins.top = 18;\n      margins.bottom = 18;\n      margins.left = 18;\n      margins.right = 0;\n      margins.unit = \"px\";\n\n      var lfields = JSON.parse(this.fields.Value());\n      var gfields = JSON.parse(gridCtrl.GetFields());\n      var lo, ff;\n      for(var m=0; m\u003clfields.length; m++) {\n        lo = lfields[m];\n        ff = false;\n        for (var n = 0; !ff && n \u003c gfields.length; n++) {\n          if (lo.alias == gfields[n].field_name) {  \u002f\u002f capita solo se e' zoom\n            ff = true;\n            lo.desc = gfields[n].field_title;\n            lo.align = gfields[n].align;\n            if (Empty(lo.field_picture))\n              lo.field_picture = gfields[n].field_picture;\n            if (Empty(lo.total_picture))\n              lo.total_picture = gfields[n].total_picture;\n            lo.column_width = gfields[n].column_width;\n          }\n        }\n      }\n      this.fields.Value(JSON.stringify(lfields));\n      if (Empty(this.ReportName.Value())) {\n        var pprops = new JSURL(\"..\u002fservlet\u002fSPReportGet?action=getPrintProperty&filename=printproperties\", true);\n        pprops = JSON.parse(pprops.Response());\n        pprops.userName = \"\u003c%=sp.getUserName()%\u003e\";\n        pprops.userLanguage = \"\u003c%=sp.getLanguage()%\u003e\";\n        var fvztypeobj = null;\n        if (pplet && pplet.getFieldsTypeView) {\n          fvztypeobj = pplet.getFieldsTypeView();\n        }\n        var allFields = this.getAllFieldsObj(pprops, lfields, clonedataobj, fvztypeobj);\n        var outf = this.outputFormat.Value().toLowerCase();\n        if (outf != 'pdf' && outf != 'html') {\n          pprops.m_bStretchGridPage = true;\n        }\n        \n        var totals = false,\n            totalsA = [];\n        if (pplet && pplet.printTotals) {\n          totals = pplet.printTotals();\n          if (totals)\n          \ttotalsA = this.getTotalsArray(allFields.fields, clonedataobj._Totals);\n        }\n\t\t\t\tvar opts_obj = {};\n        opts_obj.datasource = \"\";\n        opts_obj.title = this.title.Value();\n        opts_obj.reportmodel = \"table\";\n        opts_obj.allFields = allFields.fields;\n        opts_obj.reportflds = allFields.indexes;\n        opts_obj.breakflds = [];\n        opts_obj.headerflds = [];\n        opts_obj.footerflds = [];\n        opts_obj.filterfooter = [];\n        opts_obj.page = page;\n        opts_obj.margins = margins;\n        opts_obj.pageswitch = null;\n        opts_obj.offline = false;\n        opts_obj.fromprint = true;\n        opts_obj.printprops = pprops;\n        opts_obj.totalsA = JSON.stringify(totalsA);\n        opts_obj.output = this.outputFormat.Value().toLowerCase();\n        if( gridCtrl.GetPrintHeaders ) opts_obj.printHeaders = gridCtrl.GetPrintHeaders();\n          \n        var reportDefObj = generateReport(opts_obj);\n      }\n      else {\n        var url = new JSURL(\"..\u002fservlet\u002fSPSVRPProxy?action=load&name=\" + this.ReportName.Value() + \"&custom=\" + this.custom.Value(), true);\n        var reportDefObj = JSON.parse(url.Response());\n        this.normalizeReportDefObj(reportDefObj, JSON.parse(this.fields.Value()));\n      }\n\n      this.setPictures(reportDefObj);\n      this.setImagesSize(reportDefObj);\n      if (window.tool)\n        window.tool = \"\";\n      \n    \tif (pplet && pplet.isMaximized)\n        isMaximized = pplet.isMaximized();\n\n      var act = {};\n      act.autoprint = this.directPrint.Value();\n      act.autodownload = this.directDown.Value();\n      act.coverobj = coverObj;\n      act.theme = ZtVWeb.theme;\n      \n      if (pplet && pplet.hasGroupRepeated) {\n        act.group_repeated = pplet.hasGroupRepeated();\n        act.pictureMap = pictureMap;\n      }\n\n      mcontainer = document.createElement(\"div\");\n      mcontainer.id = this.formid+\"_div\";\n      mcontainer.style.width = \"99%\";\n      mcontainer.style.height = (window.innerHeight - 2) + \"px\";  \u002f\u002f\"99%\";\n      this.Ctrl.appendChild(mcontainer); \n\n      JSRepDrawDocumentViewProvider( reportDefObj \u002f\u002fsmartreport def\n                                    , this.outputFormat.Value().toLowerCase()\n                                    , clonedataobj \u002f\u002f datasource\n                                    , mcontainer \u002f\u002f preview container\n                                    , this.FileName.Value() \u002f\u002f FileName. ReportName when empty\n                                    , act\n                                    , false  \u002f\u002f parametro che dice se i dati sono simulati\n                                    , this._resizeAtEnd  \u002f\u002f end callback\n                                    , this.bPreview.Value()\n                                    , false\n                                   );\n    }\n  }\n  catch(e) {\n    console.error(e)\n    if(this.directDown.Value() || this.directPrint.Value()) {\n      var msg = '\u003c%=JSPLib.ToJSValue(sp.translate(\"RPT_ERROR_GENERIC\"))%\u003e';\n      alert(msg);\n    }\n    else {\n      ZtVWeb.Include(\"..\u002fjsp-system\u002fSPReportMaskMessage_portlet.jsp?title=RPT_ERROR&msgBox=RPT_ERROR_GENERIC\", Ctrl(\"\" + this.formid), true);\n    }\n  }\n}\n\nfunction getAllFieldsObj(pprops, lfields, dpobj, fvztypeobj){\n  var mfields = lfields,\n      \u002f\u002f riporto valori di len e dec di default secondo il metodo SPBridge.GetRowsRoutineFieldsAsProps\n      lenObj = {C:25, M:10, N:12, L:1, D:8, T:14, I:25, html:25, checkbox:1},\n      decObj = {C:0, M:0, N:0, L:0, D:0, T:0, I:0},  \u002f\u002f i valori decimali di default per N sono 0 -\u003e al limite passano picture\n      ret = {fields:[], indexes:[]},\n      mobj = {},\n      fields_alias = [];\n\n  for(var i=0; i\u003cmfields.length; i++){\n    mobj = {};\n    mobj.collayer = mfields[i].collayer || false;\n    mobj.extfield = mfields[i].extfield || false;\n    mobj.hiddenfield = mfields[i].hiddenfield || false;\n    mobj.rowlayer = mfields[i].rowlayer || false;\n    mobj.alias = mfields[i].alias || mfields[i].field_name_org || mfields[i].field_name;\n    mobj._alias = mfields[i].field_name;\n    if (Empty(mfields[i].field_expr) && fields_alias.indexOf(mfields[i].field_name) \u003c 0 && !Empty(mfields[i].field_name))\n      fields_alias.push(mfields[i].field_name);\n    mobj.desc = mfields[i].desc || mfields[i].field_title;\n    if (pprops.m_bPrintGridImages && mfields[i].field_image) {\n      mobj.type = \"I\";\n    }\n    else {\n      var ischeckb = (mfields[i].field_expr == \"checkbox\" || mfields[i].type == \"checkbox\"),\n          ishtml = (mfields[i].field_expr == \"html\" || mfields[i].type == \"html\");\n      if (ischeckb) {\n        mobj.type = mfields[i].field_expr;\n      }\n      else {\n        mobj.type = mfields[i].type || mfields[i].field_type;\n      }\n    }\n\n    if (!Empty(fvztypeobj) && fvztypeobj[mobj.alias]) {\n      if (fvztypeobj[mobj.alias] == \"checkbox\") {\n        mobj.type = fvztypeobj[mobj.alias];\n      }\n      else if (fvztypeobj[mobj.alias] == \"image\") {\n        if (pprops.m_bPrintGridImages) {\n          mobj.type = \"I\";\n        }\n      }\n    }\n\n    if (Empty(mobj.len) && typeof(mfields[i].len) == \"undefined\") {\n      mobj.len = lenObj[mobj.type];\n      mobj.dec = decObj[mobj.type] || 0;\n    }\n    else {\n      mobj.len = mfields[i].len;\n      mobj.dec = mfields[i].dec || (decObj[mobj.type] || 0);\n      mobj._checkLenDec = true;\n    }\n    mobj.value = mfields[i].field_name_org || mfields[i].field_name;\n    mobj.generic = mfields[i].generic;\n    mobj.html = mfields[i].html;\n    mobj.align = mfields[i].align;\n    mobj.column_width = mfields[i].column_width || 0;\n    ret.fields.push(mobj);\n    ret.indexes.push(i);\n  }\n  \n  \u002f\u002f inserisco la prop len e dec\n  if (dpobj._dpType == \"SQLDataProvider\") {\n    this.mflds.Value(fields_alias.toString());\n    this.spl_fields.Parameters(\"action=typefield,filename=\" + dpobj.cmd + \",offlinemode=false,fields=mflds\");\n    this.spl_fields.Link();\n\t\tif (!Empty(allFieldsSQL)) {\n    \tret.fields.forEach(function(f_obj) {\n        if (\"_checkLenDec\" in f_obj) {\n          delete f_obj._checkLenDec;\n          return;\n        }\n        var fidx = fields_alias.indexOf(f_obj._alias);\n        if (fidx \u003c 0)\n        \treturn;\n        f_obj.len = allFieldsSQL[fidx][1];\n      \tf_obj.dec = allFieldsSQL[fidx][2];\n      });\n    }\n  }\n  return ret;\n}\n\nfunction spl_fields_Result(result){\n  allFieldsSQL = JSON.parse(result);\n}\n\nvar pictureMap = null;\nfunction setPictures(repobj){\n  pictureMap = {};\n  var flds = JSON.parse(this.fields.Value()),\n      items = repobj.groupbody.items,\n      f_items = repobj.groupfooter.items,\n\t\t\tevalName,\n      j,\n      totuid = \"tot_tgroupfooter\";\n  for (var i=0; i\u003cflds.length; i++) {\n    evalName = flds[i].field_name_org || flds[i].field_name;\n    for (j = 0; j \u003c items.length; j++) {\n      if (items[j].fieldDetail && (evalName == items[j].fieldDetail.alias || flds[i].alias == items[j].fieldDetail.alias)) {\n        items[j].stdPicture = flds[i].field_picture;\n        if (!(items[j].fieldDetail.alias in pictureMap))\n          pictureMap[items[j].fieldDetail.alias] = items[j].stdPicture;\n      }\n    }\n    for (j = 0; j \u003c f_items.length; j++) {\n      if (f_items[j].uid.indexOf(totuid) \u003c 0)\n        continue;\n      if (f_items[j].uid.indexOf(evalName) \u003e= 0 || f_items[j].uid.indexOf(flds[i].alias) \u003e= 0) {\n        if (!Empty(flds[i].total_picture))\n        \tf_items[j].stdPicture = flds[i].total_picture;\n        else\n          f_items[j].stdPicture = flds[i].field_picture;\n      }\n    }\n  }\n}\n\nfunction setImagesSize(repobj){\n  if (!Empty(this.ReportName.Value())) {\n    return;\n  }\n  var flds = JSON.parse(this.fields.Value());\n  var items = repobj.groupbody.items;\n  var h = repobj.groupbody.height;\n  var wDiff = {};\n  var evalName;\n  for(var i=0; i\u003cflds.length; i++){\n    for(var j=0; j\u003citems.length; j++){\n      evalName = flds[i].field_name_org || flds[i].field_name;\n      if(items[j].fieldDetail && (evalName == items[j].fieldDetail.alias || flds[i].alias == items[j].fieldDetail.alias) && items[j].fieldDetail.type == \"I\") {\n        if (repobj.groupheader.items && repobj.groupheader.items[j]) {\n          if (repobj.groupheader.items[j].position.width \u003c= items[j].position.width) {\n            if (!wDiff[items[j].fieldDetail.alias]) {\n              wDiff[items[j].fieldDetail.alias] = { position: j, diff: 0 };\n            }\n            wDiff[items[j].fieldDetail.alias].diff = flds[i].field_image_width - items[j].position.width;\n          }\n        }\n\n        items[j].position.width = flds[i].field_image_width;\n        items[j].position.height = flds[i].field_image_height;\n        if(h\u003cflds[i].field_image_height) {\n          h+=flds[i].field_image_height;\n        }\n      }\n      else if(items[j].type == \"field\" && items[j].isGeneric && items[j].typeView == \"image\" && evalName == items[j].style.imageSrc) {\n        if (repobj.groupheader.items && repobj.groupheader.items[j]) {\n          if (repobj.groupheader.items[j].position.width \u003c= items[j].position.width) {\n            if (!wDiff[flds[i].alias]) {\n              wDiff[flds[i].alias] = { position: j, diff: 0 };\n            }\n            wDiff[flds[i].alias].diff = flds[i].field_image_width - items[j].position.width;\n          }\n        }\n\n        items[j].position.width = flds[i].field_image_width;\n        items[j].position.height = flds[i].field_image_height;\n        if(h\u003cflds[i].field_image_height) {\n          h+=flds[i].field_image_height;\n        }\n      }\n      else if (items[j].type == \"field\" && items[j].typeView == \"html\" && evalName == items[j].style.htmlSrc) {\n        if (repobj.groupheader.items && repobj.groupheader.items[j]) {\n          if (repobj.groupheader.items[j].position.width \u003c= items[j].position.width) {\n            if (!wDiff[flds[i].alias]) {\n              wDiff[flds[i].alias] = { position: j, diff: 0 };\n            }\n            wDiff[flds[i].alias].diff = flds[i].field_image_width - items[j].position.width;\n          }\n        }\n\n        items[j].position.width = flds[i].field_image_width;\n        items[j].position.height = flds[i].field_image_height;\n        if(h\u003cflds[i].field_image_height) {\n          h+=flds[i].field_image_height;\n        }\n      }\n    }\n  }\n\n  var mdiff = Object.keys(wDiff);\n  var diffObj;\n  for (var i = 0; i \u003c mdiff.length; i++) {\n    diffObj = wDiff[mdiff[i]];\n    if (diffObj.diff != 0) {\n      for (var j = 0; j \u003c items.length; j++) {\n        if (j \u003e diffObj.position) {\n          items[j].position.x = items[j].position.x + diffObj.diff;\n          if (repobj.groupheader.items && repobj.groupheader.items[j]) {\n            repobj.groupheader.items[j].position.x = repobj.groupheader.items[j].position.x + diffObj.diff;\n          }\n        }\n      }\n    }\n  }\n\n  repobj.groupbody.height = h;\n}\n\nfunction normalizeReportDefObj(repobj, fields) {\n  \u002f\u002f ciclo sulle zone per sistemare allFields\n\tvar zones = ['reportheader', 'pageheader', 'groupheader', 'groupbody', 'groupfooter', 'pagefooter', 'reportfooter'],\n      all_alias = fields.map(function(f) { return f.alias; }),\n      progrX = -1,\n      offset = 20;\n  for (var i = 0; i \u003c zones.length; i++) {\n    var items = repobj[zones[i]].items,\n        toremove = [];\n    progrX = -1;\n    for (var j = 0; j \u003c items.length; j++) {\n    \tif (items[j].isAllFields) {\n        var alias_idx = all_alias.indexOf(items[j].ref_alias);\n        if (alias_idx \u003e= 0) {\n          if (progrX == -1) \u002f\u002f primo campo\n            progrX = items[j].position.x;\n          items[j].position.x = progrX;\n          var calc_w = calculateMaxWidth(fields[alias_idx]);\n          items[j].position.width = calc_w;\n          progrX = progrX + offset + items[j].position.width;\n        }\n        else\n          toremove.push(j);\n      }\n    }\n    if (!Empty(toremove)) {\n      var tmp_itms = items.filter(function(itm, idx) { return toremove.indexOf(idx) \u003c 0; });\n      repobj[zones[i]].items = tmp_itms;\n    }\n  }\n}\n\nfunction getTotalsArray(fields, totobj) {\n  if (Empty(totobj))\n    return [];\n  var Totals = JSON.parse(totobj.obj),\n      totalizeDescr = JSON.parse(totobj.descr),\n  \t\ttotalizeExpr = JSON.parse(totobj.expr),\n  \t\tarray_Totals = [],\n      j;\n  for (j = 0; j \u003c Totals.Data.length; j++) {\n    array_Totals[j] = {};\n  }\n  for (j = 0; j \u003c fields.length; j++) {\n    var col = fields[j],\n        idx = LibJavascript.Array.indexOf(Totals.Fields, col.alias);\n    if (idx == -1)\n      idx = LibJavascript.Array.indexOf(Totals.Fields, Lower(col.alias));\n    if (idx != -1) {\n      if (totalizeDescr.length) {\n        if (totalizeDescr[idx]) {\n          var descr = '';\n          if (Left(totalizeDescr[idx], 1) == '%')\n            descr = col.desc;\n          else\n            descr = totalizeDescr[idx];\n          array_Totals[Totals.Data.length - 1][col.alias] = descr;\n        }\n        else\n          array_Totals[Totals.Data.length - 1][col.alias] = totalizeExpr[idx];\n      }\n      for (var k = 0; k \u003c Totals.Data.length - 1; k++) {\n        array_Totals[k][col.alias] = Totals.Data[k][idx];\n      }\n    }\n  }\n  return array_Totals;\n}\n\nfunction _resizeAtEnd() {\n  if (!(CharToBool(isMaximized + \"\")))\n    return;\n  var wsize = window.GetWindowSize();\n  if (mcontainer)\n    mcontainer.style.height = \"99%\";\n  self.height = wsize.h - 2;\n  self.Ctrl.style.height = self.height + \"px\";\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"false","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"500","hsl":"","htmlcode":"{{ @parentPortletID }}\n{{ @ReportName }}\n{{ @portletID }}\n{{ @FileName }}\n{{ @fields }}\n{{ @outputFormat }}\n{{ @gridName }}\n{{ @title }}\n{{ @custom }}\n{{ @directPrint }}\n{{ @directDown }}\n{{ @printNoZoom }}\n{{ @SdataProvider }}\n{{ @bPreview }}\n{{ @RPwindowID }}\n{{ parentPortletID }}\n{{ ReportName }}\n{{ portletID }}\n{{ FileName }}\n{{ fields }}\n{{ outputFormat }}\n{{ gridName }}\n{{ title }}\n{{ custom }}\n{{ directPrint }}\n{{ directDown }}\n{{ printNoZoom }}\n{{ SdataProvider }}\n{{ bPreview }}\n{{ RPwindowID }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"","max_w":"","min_w":"","my_library":"controls.js,smartreport\u002fproperties.js,visualweb\u002fjszip.js,visualweb\u002fxlsx.js,visualweb\u002fbcmath-min.js,visualweb\u002fpdf417.js,visualweb\u002fJsBarcode.all.js,visualweb\u002fqrcode2.js,visualweb\u002fhtml2canvas.js,smartreport\u002ffonts.js,JSReportDocumentRuntime.js,JSReportDocumentHtml.js,JSReportDocumentPdf.js,JSReportDocumentText.js,JSReportDocumentXlsx.js","offline":"","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"500","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"parentPortletID","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"119"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"ReportName","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"147"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"portletID","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"203"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FileName","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"231"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"fields","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"7"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"outputFormat","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"63"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"gridName","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"91"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"title","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"35"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"custom","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"175"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"directPrint","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"536","y":"259"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"directDown","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"536","y":"287"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"printNoZoom","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"536","y":"315"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"5000","name":"SdataProvider","offline":"false","page":"1","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"true","sequence":"13","type":"SQLDataobj","w":"30","x":"709","y":"5"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"bPreview","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"536","y":"342"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"RPwindowID","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"369"},{"allowedentities":"SPVQRProxy","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"22","m_cAction":"function","name":"spl_fields","offline":"","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"SPVQRProxy","target":"","type":"SPLinker","w":"146","x":"536","y":"396"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"mflds","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"536","y":"423"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:parentPortletID,ReportName,portletID,FileName,fields,outputFormat,gridName,title,custom,directPrint,directDown,printNoZoom,bPreview,RPwindowID*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.SPPortalZoomSmartPrint_container {
}
.SPPortalZoomSmartPrint_portlet{
  position:relative;
  width:100%;
  min-width:500px;
  height:500px;
}
.SPPortalZoomSmartPrint_portlet[Data-page="1"]{
  height:500px;
  width:100%;
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"500\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"119\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"147\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"203\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"231\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"7\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"63\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"91\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"35\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"175\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"259\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"287\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"315\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"709\",\"y\":\"5\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"342\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"369\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"146\",\"x\":\"536\",\"y\":\"396\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"536\",\"y\":\"423\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomSmartPrint","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomSmartPrint_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
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

</style>
<script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("smartreport/properties.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/jszip.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/xlsx.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/bcmath-min.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/pdf417.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/JsBarcode.all.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/qrcode2.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("visualweb/html2canvas.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("smartreport/fonts.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("JSReportDocumentRuntime.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("JSReportDocumentHtml.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("JSReportDocumentPdf.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("JSReportDocumentText.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("JSReportDocumentXlsx.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomSmartPrint','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String parentPortletID=JSPLib.translateXSS(sp.getParameter("parentPortletID",""));
String ReportName=JSPLib.translateXSS(sp.getParameter("ReportName",""));
String portletID=JSPLib.translateXSS(sp.getParameter("portletID",""));
String FileName=JSPLib.translateXSS(sp.getParameter("FileName",""));
String fields=JSPLib.translateXSS(sp.getParameter("fields",""));
String outputFormat=JSPLib.translateXSS(sp.getParameter("outputFormat",""));
String gridName=JSPLib.translateXSS(sp.getParameter("gridName",""));
String title=JSPLib.translateXSS(sp.getParameter("title",""));
String custom=JSPLib.translateXSS(sp.getParameter("custom",""));
boolean directPrint=sp.getParameter("directPrint",false);
boolean directDown=sp.getParameter("directDown",false);
boolean printNoZoom=sp.getParameter("printNoZoom",false);
boolean bPreview=sp.getParameter("bPreview",false);
String RPwindowID=JSPLib.translateXSS(sp.getParameter("RPwindowID",""));
String mflds= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomSmartPrint_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomSmartPrint_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomSmartPrint','<%=idPortlet%>',false,'');
</script><%}}%>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomSmartPrint');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomSmartPrint',["500"],["500"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"500","h":"500","title":"","layer":"false","npage":"1"}]);
this.parentPortletID=new ZtVWeb._VC(this,'parentPortletID',null,'character','<%=JSPLib.ToJSValue(parentPortletID,false,true)%>',false,false);
this.ReportName=new ZtVWeb._VC(this,'ReportName',null,'character','<%=JSPLib.ToJSValue(ReportName,false,true)%>',false,false);
this.portletID=new ZtVWeb._VC(this,'portletID',null,'character','<%=JSPLib.ToJSValue(portletID,false,true)%>',false,false);
this.FileName=new ZtVWeb._VC(this,'FileName',null,'character','<%=JSPLib.ToJSValue(FileName,false,true)%>',false,false);
this.fields=new ZtVWeb._VC(this,'fields',null,'character','<%=JSPLib.ToJSValue(fields,false,true)%>',false,false);
this.outputFormat=new ZtVWeb._VC(this,'outputFormat',null,'character','<%=JSPLib.ToJSValue(outputFormat,false,true)%>',false,false);
this.gridName=new ZtVWeb._VC(this,'gridName',null,'character','<%=JSPLib.ToJSValue(gridName,false,true)%>',false,false);
this.title=new ZtVWeb._VC(this,'title',null,'character','<%=JSPLib.ToJSValue(title,false,true)%>',false,false);
this.custom=new ZtVWeb._VC(this,'custom',null,'character','<%=JSPLib.ToJSValue(custom,false,true)%>',false,false);
this.directPrint=new ZtVWeb._VC(this,'directPrint',null,'logic',<%=directPrint%>,false,false);
this.directDown=new ZtVWeb._VC(this,'directDown',null,'logic',<%=directDown%>,false,false);
this.printNoZoom=new ZtVWeb._VC(this,'printNoZoom',null,'logic',<%=printNoZoom%>,false,false);
this.SdataProvider=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SdataProvider","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SdataProvider","nrows":"5000","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":30,"x":709,"y":5});
this.bPreview=new ZtVWeb._VC(this,'bPreview',null,'logic',<%=bPreview%>,false,false);
this.RPwindowID=new ZtVWeb._VC(this,'RPwindowID',null,'character','<%=JSPLib.ToJSValue(RPwindowID,false,true)%>',false,false);
this.spl_fields=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("SPVQRProxy",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_spl_fields","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"spl_fields","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"SPVQRProxy","target":"","type":"SPLinker","w":146,"x":536,"y":396});
this.spl_fields.m_cID='<%=JSPLib.cmdHash("routine,SPVQRProxy",request.getSession())%>';
this.mflds=new ZtVWeb._VC(this,'mflds',null,'character','<%=JSPLib.ToJSValue(mflds,false,true)%>',false,false);
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
<%request.setAttribute("SPPortalZoomSmartPrint_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomSmartPrint_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof getAllFieldsObj !='undefined')this.getAllFieldsObj=getAllFieldsObj;
if(typeof spl_fields_Result !='undefined')this.spl_fields_Result=spl_fields_Result;
if(typeof setPictures !='undefined')this.setPictures=setPictures;
if(typeof setImagesSize !='undefined')this.setImagesSize=setImagesSize;
if(typeof normalizeReportDefObj !='undefined')this.normalizeReportDefObj=normalizeReportDefObj;
if(typeof getTotalsArray !='undefined')this.getTotalsArray=getTotalsArray;
if(typeof _resizeAtEnd !='undefined')this._resizeAtEnd=_resizeAtEnd;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var self = this,
    mcontainer,
    isMaximized = false,
    allFieldsSQL = null;
function this_Loaded(){
  try {
    if (this.printNoZoom.Value()) {  // SPReportMaskParameter.directSmartReportPrint
      if (!Empty(this.ReportName.Value())) {
        var url = new JSURL("../servlet/SPSVRPProxy?action=load&name=" + this.ReportName.Value() + "&custom=" + this.custom.Value(), true);
        var reportDefObj = JSON.parse(url.Response());
        var params = "";
        var pplet = GetOpener().ZtVWeb.getPortletById(this.portletID.Value());	// portlet z.print
        if (!Empty(this.RPwindowID.Value())) {
          var ids = this.RPwindowID.Value().split("#");
          pplet = GetOpener().ZtVWeb.getPortletById(ids[0]); // portlet masch. stampa
          // se e' empty cerco nel parent window, dove dovrebbe essere inserito nel pom
          if (Empty(pplet) && !Empty(ids[1])) {
            var pwin = window.parent.document.getElementById(ids[1]);
            // provo con opener
            if (Empty(pwin))
              pwin = GetOpener().parent.document.getElementById(ids[1]);
            // provo con window.top
            if (Empty(pwin))
              pwin = window.top.document.getElementById(ids[1]);
            if (!Empty(pwin)) {
          		pplet = pwin.contentWindow.ZtVWeb.getPortletById(ids[0]);
            }
          }
        }
        if (pplet && pplet.getSubmitData) {
          params = pplet.getSubmitData(false);
          params = Strtran(params,'&',',');
        }
        var coverObj = null;
        if (pplet && pplet.getCoverObject) {
          coverObj = pplet.getCoverObject();
        }
        var mdatasource = reportDefObj.datasource;
        var clonedataobj;
        this.SdataProvider.ChangeQuery(mdatasource)
        if(mdatasource.indexOf("BO:")>=0){
          this.SdataProvider.queryfilter=params;
        }
        else {// vqr
          this.SdataProvider.parms=params;
        }
        clonedataobj = this.SdataProvider._getCloneForPrint();
        if(window.tool) {
          window.tool = "";
        }
 
        var act = {};
        act.autoprint = this.directPrint.Value();
        act.autodownload = this.directDown.Value();
        act.coverobj = coverObj;
        act.theme = ZtVWeb.theme;
        mcontainer = document.createElement("div");
        mcontainer.id = this.formid+"_div";
        mcontainer.style.width = "99%";
        mcontainer.style.height = (window.innerHeight - 2) + "px";  //"99%";
        this.Ctrl.appendChild(mcontainer); 
        
        JSRepDrawDocumentViewProvider( reportDefObj //smartreport def
                                      , this.outputFormat.Value().toLowerCase()
                                      , clonedataobj // datasource
                                      , mcontainer // preview container
                                      , this.FileName.Value() // FileName. ReportName when empty
                                      , act
                                      , false  // parametro che dice se i dati sono simulati
                                      , this._resizeAtEnd  // end callback
                                      , this.bPreview.Value()
                                      , false
                                     );
      }
    }
    else {
      var parentPortlet = GetOpener().ZtVWeb.getPortletById(this.parentPortletID.Value());
      var gridCtrl = parentPortlet[this.gridName.Value()];
      var dataobj, clonedataobj;
      if( gridCtrl.GetPrintDataObj ){
        clonedataobj = gridCtrl.GetPrintDataObj();
      }
      else {
        dataobj = parentPortlet[gridCtrl.dataobj];
        clonedataobj = dataobj._getCloneForPrint();
      }
      var pplet = GetOpener().ZtVWeb.getPortletById(this.portletID.Value());
      if (pplet && pplet.getSpFields)
        this.fields.Value(pplet.getSpFields());
      var coverObj = null;
      if (pplet && pplet.getCoverObject)
        coverObj = pplet.getCoverObject();
      clonedataobj.dataconsumers = [];
      clonedataobj.rowsconsumers = [];
      clonedataobj.paramconsumers = [];
      clonedataobj.nRows = 5000;//dataobjnRows * 100;
      var page = {};
      page.format = "A4";
      page.orientation = "portrait";
      var margins = {};
      margins.top = 18;
      margins.bottom = 18;
      margins.left = 18;
      margins.right = 0;
      margins.unit = "px";
      var lfields = JSON.parse(this.fields.Value());
      var gfields = JSON.parse(gridCtrl.GetFields());
      var lo, ff;
      for(var m=0; m<lfields.length; m++) {
        lo = lfields[m];
        ff = false;
        for (var n = 0; !ff && n < gfields.length; n++) {
          if (lo.alias == gfields[n].field_name) {  // capita solo se e' zoom
            ff = true;
            lo.desc = gfields[n].field_title;
            lo.align = gfields[n].align;
            if (Empty(lo.field_picture))
              lo.field_picture = gfields[n].field_picture;
            if (Empty(lo.total_picture))
              lo.total_picture = gfields[n].total_picture;
            lo.column_width = gfields[n].column_width;
          }
        }
      }
      this.fields.Value(JSON.stringify(lfields));
      if (Empty(this.ReportName.Value())) {
        var pprops = new JSURL("../servlet/SPReportGet?action=getPrintProperty&filename=printproperties", true);
        pprops = JSON.parse(pprops.Response());
        pprops.userName = "<%=sp.getUserName()%>";
        pprops.userLanguage = "<%=sp.getLanguage()%>";
        var fvztypeobj = null;
        if (pplet && pplet.getFieldsTypeView) {
          fvztypeobj = pplet.getFieldsTypeView();
        }
        var allFields = this.getAllFieldsObj(pprops, lfields, clonedataobj, fvztypeobj);
        var outf = this.outputFormat.Value().toLowerCase();
        if (outf != 'pdf' && outf != 'html') {
          pprops.m_bStretchGridPage = true;
        }
        
        var totals = false,
            totalsA = [];
        if (pplet && pplet.printTotals) {
          totals = pplet.printTotals();
          if (totals)
          	totalsA = this.getTotalsArray(allFields.fields, clonedataobj._Totals);
        }
				var opts_obj = {};
        opts_obj.datasource = "";
        opts_obj.title = this.title.Value();
        opts_obj.reportmodel = "table";
        opts_obj.allFields = allFields.fields;
        opts_obj.reportflds = allFields.indexes;
        opts_obj.breakflds = [];
        opts_obj.headerflds = [];
        opts_obj.footerflds = [];
        opts_obj.filterfooter = [];
        opts_obj.page = page;
        opts_obj.margins = margins;
        opts_obj.pageswitch = null;
        opts_obj.offline = false;
        opts_obj.fromprint = true;
        opts_obj.printprops = pprops;
        opts_obj.totalsA = JSON.stringify(totalsA);
        opts_obj.output = this.outputFormat.Value().toLowerCase();
        if( gridCtrl.GetPrintHeaders ) opts_obj.printHeaders = gridCtrl.GetPrintHeaders();
          
        var reportDefObj = generateReport(opts_obj);
      }
      else {
        var url = new JSURL("../servlet/SPSVRPProxy?action=load&name=" + this.ReportName.Value() + "&custom=" + this.custom.Value(), true);
        var reportDefObj = JSON.parse(url.Response());
        this.normalizeReportDefObj(reportDefObj, JSON.parse(this.fields.Value()));
      }
      this.setPictures(reportDefObj);
      this.setImagesSize(reportDefObj);
      if (window.tool)
        window.tool = "";
      
    	if (pplet && pplet.isMaximized)
        isMaximized = pplet.isMaximized();
      var act = {};
      act.autoprint = this.directPrint.Value();
      act.autodownload = this.directDown.Value();
      act.coverobj = coverObj;
      act.theme = ZtVWeb.theme;
      
      if (pplet && pplet.hasGroupRepeated) {
        act.group_repeated = pplet.hasGroupRepeated();
        act.pictureMap = pictureMap;
      }
      mcontainer = document.createElement("div");
      mcontainer.id = this.formid+"_div";
      mcontainer.style.width = "99%";
      mcontainer.style.height = (window.innerHeight - 2) + "px";  //"99%";
      this.Ctrl.appendChild(mcontainer); 
      JSRepDrawDocumentViewProvider( reportDefObj //smartreport def
                                    , this.outputFormat.Value().toLowerCase()
                                    , clonedataobj // datasource
                                    , mcontainer // preview container
                                    , this.FileName.Value() // FileName. ReportName when empty
                                    , act
                                    , false  // parametro che dice se i dati sono simulati
                                    , this._resizeAtEnd  // end callback
                                    , this.bPreview.Value()
                                    , false
                                   );
    }
  }
  catch(e) {
    console.error(e)
    if(this.directDown.Value() || this.directPrint.Value()) {
      var msg = '<%=JSPLib.ToJSValue(sp.translate("RPT_ERROR_GENERIC"))%>';
      alert(msg);
    }
    else {
      ZtVWeb.Include("../jsp-system/SPReportMaskMessage_portlet.jsp?title=RPT_ERROR&msgBox=RPT_ERROR_GENERIC", Ctrl("" + this.formid), true);
    }
  }
}
function getAllFieldsObj(pprops, lfields, dpobj, fvztypeobj){
  var mfields = lfields,
      // riporto valori di len e dec di default secondo il metodo SPBridge.GetRowsRoutineFieldsAsProps
      lenObj = {C:25, M:10, N:12, L:1, D:8, T:14, I:25, html:25, checkbox:1},
      decObj = {C:0, M:0, N:0, L:0, D:0, T:0, I:0},  // i valori decimali di default per N sono 0 -> al limite passano picture
      ret = {fields:[], indexes:[]},
      mobj = {},
      fields_alias = [];
  for(var i=0; i<mfields.length; i++){
    mobj = {};
    mobj.collayer = mfields[i].collayer || false;
    mobj.extfield = mfields[i].extfield || false;
    mobj.hiddenfield = mfields[i].hiddenfield || false;
    mobj.rowlayer = mfields[i].rowlayer || false;
    mobj.alias = mfields[i].alias || mfields[i].field_name_org || mfields[i].field_name;
    mobj._alias = mfields[i].field_name;
    if (Empty(mfields[i].field_expr) && fields_alias.indexOf(mfields[i].field_name) < 0 && !Empty(mfields[i].field_name))
      fields_alias.push(mfields[i].field_name);
    mobj.desc = mfields[i].desc || mfields[i].field_title;
    if (pprops.m_bPrintGridImages && mfields[i].field_image) {
      mobj.type = "I";
    }
    else {
      var ischeckb = (mfields[i].field_expr == "checkbox" || mfields[i].type == "checkbox"),
          ishtml = (mfields[i].field_expr == "html" || mfields[i].type == "html");
      if (ischeckb) {
        mobj.type = mfields[i].field_expr;
      }
      else {
        mobj.type = mfields[i].type || mfields[i].field_type;
      }
    }
    if (!Empty(fvztypeobj) && fvztypeobj[mobj.alias]) {
      if (fvztypeobj[mobj.alias] == "checkbox") {
        mobj.type = fvztypeobj[mobj.alias];
      }
      else if (fvztypeobj[mobj.alias] == "image") {
        if (pprops.m_bPrintGridImages) {
          mobj.type = "I";
        }
      }
    }
    if (Empty(mobj.len) && typeof(mfields[i].len) == "undefined") {
      mobj.len = lenObj[mobj.type];
      mobj.dec = decObj[mobj.type] || 0;
    }
    else {
      mobj.len = mfields[i].len;
      mobj.dec = mfields[i].dec || (decObj[mobj.type] || 0);
      mobj._checkLenDec = true;
    }
    mobj.value = mfields[i].field_name_org || mfields[i].field_name;
    mobj.generic = mfields[i].generic;
    mobj.html = mfields[i].html;
    mobj.align = mfields[i].align;
    mobj.column_width = mfields[i].column_width || 0;
    ret.fields.push(mobj);
    ret.indexes.push(i);
  }
  
  // inserisco la prop len e dec
  if (dpobj._dpType == "SQLDataProvider") {
    this.mflds.Value(fields_alias.toString());
    this.spl_fields.Parameters("action=typefield,filename=" + dpobj.cmd + ",offlinemode=false,fields=mflds");
    this.spl_fields.Link();
		if (!Empty(allFieldsSQL)) {
    	ret.fields.forEach(function(f_obj) {
        if ("_checkLenDec" in f_obj) {
          delete f_obj._checkLenDec;
          return;
        }
        var fidx = fields_alias.indexOf(f_obj._alias);
        if (fidx < 0)
        	return;
        f_obj.len = allFieldsSQL[fidx][1];
      	f_obj.dec = allFieldsSQL[fidx][2];
      });
    }
  }
  return ret;
}
function spl_fields_Result(result){
  allFieldsSQL = JSON.parse(result);
}
var pictureMap = null;
function setPictures(repobj){
  pictureMap = {};
  var flds = JSON.parse(this.fields.Value()),
      items = repobj.groupbody.items,
      f_items = repobj.groupfooter.items,
			evalName,
      j,
      totuid = "tot_tgroupfooter";
  for (var i=0; i<flds.length; i++) {
    evalName = flds[i].field_name_org || flds[i].field_name;
    for (j = 0; j < items.length; j++) {
      if (items[j].fieldDetail && (evalName == items[j].fieldDetail.alias || flds[i].alias == items[j].fieldDetail.alias)) {
        items[j].stdPicture = flds[i].field_picture;
        if (!(items[j].fieldDetail.alias in pictureMap))
          pictureMap[items[j].fieldDetail.alias] = items[j].stdPicture;
      }
    }
    for (j = 0; j < f_items.length; j++) {
      if (f_items[j].uid.indexOf(totuid) < 0)
        continue;
      if (f_items[j].uid.indexOf(evalName) >= 0 || f_items[j].uid.indexOf(flds[i].alias) >= 0) {
        if (!Empty(flds[i].total_picture))
        	f_items[j].stdPicture = flds[i].total_picture;
        else
          f_items[j].stdPicture = flds[i].field_picture;
      }
    }
  }
}
function setImagesSize(repobj){
  if (!Empty(this.ReportName.Value())) {
    return;
  }
  var flds = JSON.parse(this.fields.Value());
  var items = repobj.groupbody.items;
  var h = repobj.groupbody.height;
  var wDiff = {};
  var evalName;
  for(var i=0; i<flds.length; i++){
    for(var j=0; j<items.length; j++){
      evalName = flds[i].field_name_org || flds[i].field_name;
      if(items[j].fieldDetail && (evalName == items[j].fieldDetail.alias || flds[i].alias == items[j].fieldDetail.alias) && items[j].fieldDetail.type == "I") {
        if (repobj.groupheader.items && repobj.groupheader.items[j]) {
          if (repobj.groupheader.items[j].position.width <= items[j].position.width) {
            if (!wDiff[items[j].fieldDetail.alias]) {
              wDiff[items[j].fieldDetail.alias] = { position: j, diff: 0 };
            }
            wDiff[items[j].fieldDetail.alias].diff = flds[i].field_image_width - items[j].position.width;
          }
        }
        items[j].position.width = flds[i].field_image_width;
        items[j].position.height = flds[i].field_image_height;
        if(h<flds[i].field_image_height) {
          h+=flds[i].field_image_height;
        }
      }
      else if(items[j].type == "field" && items[j].isGeneric && items[j].typeView == "image" && evalName == items[j].style.imageSrc) {
        if (repobj.groupheader.items && repobj.groupheader.items[j]) {
          if (repobj.groupheader.items[j].position.width <= items[j].position.width) {
            if (!wDiff[flds[i].alias]) {
              wDiff[flds[i].alias] = { position: j, diff: 0 };
            }
            wDiff[flds[i].alias].diff = flds[i].field_image_width - items[j].position.width;
          }
        }
        items[j].position.width = flds[i].field_image_width;
        items[j].position.height = flds[i].field_image_height;
        if(h<flds[i].field_image_height) {
          h+=flds[i].field_image_height;
        }
      }
      else if (items[j].type == "field" && items[j].typeView == "html" && evalName == items[j].style.htmlSrc) {
        if (repobj.groupheader.items && repobj.groupheader.items[j]) {
          if (repobj.groupheader.items[j].position.width <= items[j].position.width) {
            if (!wDiff[flds[i].alias]) {
              wDiff[flds[i].alias] = { position: j, diff: 0 };
            }
            wDiff[flds[i].alias].diff = flds[i].field_image_width - items[j].position.width;
          }
        }
        items[j].position.width = flds[i].field_image_width;
        items[j].position.height = flds[i].field_image_height;
        if(h<flds[i].field_image_height) {
          h+=flds[i].field_image_height;
        }
      }
    }
  }
  var mdiff = Object.keys(wDiff);
  var diffObj;
  for (var i = 0; i < mdiff.length; i++) {
    diffObj = wDiff[mdiff[i]];
    if (diffObj.diff != 0) {
      for (var j = 0; j < items.length; j++) {
        if (j > diffObj.position) {
          items[j].position.x = items[j].position.x + diffObj.diff;
          if (repobj.groupheader.items && repobj.groupheader.items[j]) {
            repobj.groupheader.items[j].position.x = repobj.groupheader.items[j].position.x + diffObj.diff;
          }
        }
      }
    }
  }
  repobj.groupbody.height = h;
}
function normalizeReportDefObj(repobj, fields) {
  // ciclo sulle zone per sistemare allFields
	var zones = ['reportheader', 'pageheader', 'groupheader', 'groupbody', 'groupfooter', 'pagefooter', 'reportfooter'],
      all_alias = fields.map(function(f) { return f.alias; }),
      progrX = -1,
      offset = 20;
  for (var i = 0; i < zones.length; i++) {
    var items = repobj[zones[i]].items,
        toremove = [];
    progrX = -1;
    for (var j = 0; j < items.length; j++) {
    	if (items[j].isAllFields) {
        var alias_idx = all_alias.indexOf(items[j].ref_alias);
        if (alias_idx >= 0) {
          if (progrX == -1) // primo campo
            progrX = items[j].position.x;
          items[j].position.x = progrX;
          var calc_w = calculateMaxWidth(fields[alias_idx]);
          items[j].position.width = calc_w;
          progrX = progrX + offset + items[j].position.width;
        }
        else
          toremove.push(j);
      }
    }
    if (!Empty(toremove)) {
      var tmp_itms = items.filter(function(itm, idx) { return toremove.indexOf(idx) < 0; });
      repobj[zones[i]].items = tmp_itms;
    }
  }
}
function getTotalsArray(fields, totobj) {
  if (Empty(totobj))
    return [];
  var Totals = JSON.parse(totobj.obj),
      totalizeDescr = JSON.parse(totobj.descr),
  		totalizeExpr = JSON.parse(totobj.expr),
  		array_Totals = [],
      j;
  for (j = 0; j < Totals.Data.length; j++) {
    array_Totals[j] = {};
  }
  for (j = 0; j < fields.length; j++) {
    var col = fields[j],
        idx = LibJavascript.Array.indexOf(Totals.Fields, col.alias);
    if (idx == -1)
      idx = LibJavascript.Array.indexOf(Totals.Fields, Lower(col.alias));
    if (idx != -1) {
      if (totalizeDescr.length) {
        if (totalizeDescr[idx]) {
          var descr = '';
          if (Left(totalizeDescr[idx], 1) == '%')
            descr = col.desc;
          else
            descr = totalizeDescr[idx];
          array_Totals[Totals.Data.length - 1][col.alias] = descr;
        }
        else
          array_Totals[Totals.Data.length - 1][col.alias] = totalizeExpr[idx];
      }
      for (var k = 0; k < Totals.Data.length - 1; k++) {
        array_Totals[k][col.alias] = Totals.Data[k][idx];
      }
    }
  }
  return array_Totals;
}
function _resizeAtEnd() {
  if (!(CharToBool(isMaximized + "")))
    return;
  var wsize = window.GetWindowSize();
  if (mcontainer)
    mcontainer.style.height = "99%";
  self.height = wsize.h - 2;
  self.Ctrl.style.height = self.height + "px";
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomSmartPrint_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomSmartPrint',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomSmartPrint');
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
sp.endPage("SPPortalZoomSmartPrint");
}%>
<%! public String getJSPUID() { return "3950310115"; } %>