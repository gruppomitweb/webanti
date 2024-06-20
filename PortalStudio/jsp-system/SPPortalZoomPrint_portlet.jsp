<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var self,\n    btnCreated = false,\n\t\tcValues = \"\",\n\t\tlValues = \"\",\n\t\treports = {},\n\t\tcustomFiles = [],\n\t\tprint_totals = false,\n\t\tmaximized = false,\n\t\tgroup_repeated = false;\n\nthis.myCoverObj = null;\nthis.IframePrint.Resize(1,1);\nthis._fldsTypeView = {};\nthis.__gopen = null;\n\nfunction getFields() {\n  return this.fields.Value();\n}\n\nfunction getSpFields() {\n  return this.spFields.Value();\n}\n\nfunction getFieldsTypeView() {\n  return this._fldsTypeView;\n}\n\nfunction getCoverObject() {\n  return this.myCoverObj;\n}\n\nfunction printTotals() {\n\treturn print_totals;\n}\n\nfunction isMaximized() {\n  return maximized;\n}\n\nfunction hasGroupRepeated() {\n  return group_repeated;\n}\n\nfunction this_Loaded(){\n  self = this;\n  this.IframePrint.name_iframe = this.formid + \"IframePrint\";\n  this.IframePrint.GetCtrl().innerHTML = \"\";\n  var iframe = document.createElement(\"IFRAME\");\n  iframe.id = this.IframePrint.id + \"_iframe\";\n  iframe.name = this.IframePrint.name_iframe;\n  iframe.spparentobjid = this.formid;\n  iframe.height = 1;\n  iframe.width = 1;\n  iframe.style.margin = 0 + \"px\";\n  iframe.style.border = 0 + \"px\";\n\tthis.IframePrint.GetCtrl().appendChild(iframe);\n  this.hideAllCtrls();\n  this.portletID.Value(this.formid);\n}\n\nfunction hideAllCtrls(){\n\tthis.lblReport.Hide();\n  this.ReportList.Hide();\n  this.lblOutput.Hide();\n  this.outFormat.Hide();\n  this.btnNewReport.Hide();\n  this.btnEditReport.Hide();\n  this.btnPrint.Hide();\n  this.btnCancel.Hide();\n}\n\nfunction showAllCtrls(){\n\tthis.lblReport.Show();\n  this.ReportList.Show();\n  this.lblOutput.Show();\n  this.outFormat.Show();\n  if ( this.isPortletTitled()  && !btnCreated) {\n    var imgsPath = '..\u002f' + ZtVWeb.theme + '\u002fimages\u002f'\n      , ptlTitle = this.getTitlePortlet()\n      ;\n    ptlTitle.SetTitle( \"Print\" );\n   \tptlTitle.AppendButton( {\n      \t\t\t\t\t\t\t\t\t\t\t image: SPTheme.portalZoomPrintAddImage || imgsPath + 'spadministration_folder_add.png'\n                           , action: 'javascript:' + this.formid + '.btnNewReport_Click()'\n                           , title: FormatMsg( 'NEW_REPORT' )\n                           , tooltip: FormatMsg( 'NEW_REPORT' ) \u002f\u002ftooltip\n      \t\t\t\t\t\t\t\t\t\t , id: \"btn_new\"\n    \t\t\t\t\t\t\t\t\t\t\t} \n                         );\n    ptlTitle.AppendButton( {\n      \t\t\t\t\t\t\t\t\t\t\t image: SPTheme.portalZoomPrintEditImage || imgsPath + 'spadministration_folder_edit.png'\n                           , action: 'javascript:' + this.formid + '.btnEditReport_Click()'\n                           , title: FormatMsg( 'RPT_MODIFY' )\n                           , tooltip: FormatMsg( 'RPT_MODIFY' ) \u002f\u002ftooltip\n      \t\t\t\t\t\t\t\t\t\t , id: \"btn_edit\"\n    \t\t\t\t\t\t\t\t\t\t\t} \n                         );\n    ptlTitle.AppendButton( {\n      \t\t\t\t\t\t\t\t\t\t\t image: SPTheme.portalZoomPrintImage || imgsPath + 'custom_toolbar\u002fprint.png'\n                           , action: 'javascript:' + this.formid + '.btnPrint_Click()'\n                           , title: FormatMsg( 'MSG_VZM_PRINT' )\n                           , tooltip: FormatMsg( 'MSG_VZM_PRINT' ) \u002f\u002ftooltip\n      \t\t\t\t\t\t\t\t\t\t , id: \"btn_print\"\n    \t\t\t\t\t\t\t\t\t\t\t} \n                         );\n    ptlTitle.AppendButton( {\n      \t\t\t\t\t\t\t\t\t\t\t image: SPTheme.portalZoomPrintDiscardImage || imgsPath +'custom_toolbar\u002fclose.png'\n                           , action: 'javascript:' + this.formid + '.btnCancel_Click()'\n                           , title: FormatMsg( 'ADMIN_CANCEL' )\n                           , tooltip: FormatMsg( 'ADMIN_CANCEL' ) \u002f\u002ftooltip\n      \t\t\t\t\t\t\t\t\t\t , id: \"btn_close\"\n    \t\t\t\t\t\t\t\t\t\t\t} \n                         );\n    btnCreated = true;\n  }\n  else if(!btnCreated) {\n    this.btnNewReport.Show();\n    this.btnEditReport.Show();\n    this.btnPrint.Show();\n    this.btnCancel.Show();\n  }\n}\n\nfunction RcvPrintParms(dati){\n  this._isPrinting = true;\n  this.fromGrid.Value(CharToBool(dati.fromGrid + \"\"));\n  this.printNoZoom.Value(false);\n  this.VqrName.Value(dati.VqrName);\n  this.gridName.Value(dati.gridName || '');\n  this.openerID.Value(dati.openerID || '');\n  this.parentPortletID.Value(this.openerID.Value() || ZtVWeb.getParentPortlet(this.formid).formid);\n  this.__gopen = ZtVWeb.getParentPortlet(this.formid);\n  this.printTitle.Value(dati.title || '');\n  var prnMode = (dati.printMode || 'default');\n  if (prnMode == 'preview') {\n    this.hidePrint.Value(true);\n    this.hidePreview.Value(false);\n  }\n  else if (prnMode == 'print') {\n    this.hidePrint.Value(false);\n    this.hidePreview.Value(true);\n  }\n  else {\n    this.hidePrint.Value(false);\n    this.hidePreview.Value(false);\n  }\n  \n  this.hideExport.Value(dati.printHideExport || false);\n  this.hideSettings.Value(dati.printHideSettings || false);\n  \n  if (this.fromGrid.Value())\n    this.RcvPrintParmsGrid(dati);\n  else\n    this.RcvPrintParmsZoom(dati);\n \t\n  print_totals = dati.printTotals || false;\n  maximized = dati.maximized || false;\n  group_repeated = dati.group_repeated || false;\n  \n  if (this.fromVocal.Value() == true) {\n    var directdownload = true;\n    if (this._outformat == \"PDF\" || this._outformat == \"HTML\")\n      directdownload = false;\n  \tthis.btnPrint_Click( this.ReportName.Value()\n                        , \"\"\n                        , this._outformat\n                        , LibJavascript.AlfaKeyGen(10)\n                        , false\n                        , directdownload\n                        , {objString: \"[]\", coverPrint: false, numPageCover: false, csvSeparator: \"\", csvHeader: true}\n                        , \"\"\n\t\t);\n  }\n  else {\n  \tif (!Empty(dati.outputFormat) && (dati.outputFormat.toLowerCase() != \"default\"))\n      this.btnPrint_Click( this.ReportName.Value()\n                        , (dati.title || \"\")\n                        , dati.outputFormat\n                        , LibJavascript.AlfaKeyGen(10)\n                        , false\n                        , (dati.outputFormat != \"PDF\" && dati.outputFormat != \"HTML\")\n                        , {objString: \"[]\", coverPrint: false, numPageCover: false, csvSeparator: \"\", csvHeader: true}\n                        , \"\"\n      );\n    else\n    \tthis.printSys.Link();\n  }\n}\n\nfunction RcvPrintParmsZoom(dati){\n\tthis.configName.Value(dati.configurationName);\n  this.TableName.Value(dati.tableName);\n  this.VersionName.Value(ZtVWeb.getParentPortlet(this.formid).GetCurrentVersion());\n  if (this.VersionName.Value() != \"default\" && this.configName.Value().indexOf(this.VersionName.Value()) \u003e= 0)\n    this.configName.Value(Strtran(this.configName.Value(), \"__\" + this.VersionName.Value(), \"\"));\n  else if (this.VersionName.Value() == \"default\")\n    this.VersionName.Value(\"\");\n  var cfg = this.configName.Value();\n  if (!Empty(this.VersionName.Value()))\n    cfg = cfg + \"__\" + this.VersionName.Value();\n  cfg = cfg + \".\" + this.TableName.Value();\n\tthis.cfgName.Value(cfg);\n  this.setFieldsZoom(dati.fields, ZtVWeb.getParentPortlet(this.formid).getFieldsForPrint(), dati.vzmstructure.Cols, dati.isExtended);\n  this.encFields.Value( URLenc( this.fields.Value() ) );\n  var fds = JSON.parse(this.fields.Value());\n  this.spFields.Value( JSON.stringify(fds.filter(filterField)) );\n  this.ReportName.Value(dati.ReportName);\n  if(!Empty(this.ReportName.Value())) {\n  \tthis.TableName.Value(\"\");\n    this.VersionName.Value(\"\");\n    this.cfgName.Value(\"\");\n  }\n  \n  if (dati.vzmstructure && dati.vzmstructure.Configuration) {\n  \tif (dati.vzmstructure.Configuration.PrintMode == \"SmartReport\")\n\t\t\tthis.printNoZoom.Value(true);\n\t}\n  \n  this.fromVocal.Value(dati.vocalPrint);\n  this._outformat = (dati.outformat.toUpperCase()) || \"PDF\";\n  \n  function filterField(field) {\n    if (!field.hiddenfield && !field.collayer && !field.rowlayer)\n      return true;\n    return false;\n  }\n}\n\nthis.__toRemove = [];\nfunction setFieldsZoom(gridF, vzmF, cols, isExtended) {\n\tvar gf = JSON.parse(gridF),\n      vf = JSON.parse(vzmF),\n  \t\tgridAlias = gf.map(function(field){\n    \t\t\t\t\t\t\t\t\t\t\treturn field.field_name;\n  \t\t\t\t\t\t\t\t\t\t\t}),\n      emptyFlds = (Empty(vf) && !Empty(gf)),\t\u002f\u002f configurazione zoom vuota ma la griglia ha i campi (prob. vqrpivot)\n      i;\n\t\n  if (emptyFlds) {\n    for (i = 0; i \u003c gf.length; i++) {\n\t\t\tvar field = {\n      \talias: gf[i].field_name,\n        collayer: false,\n        dec: 2,\n        desc: gf[i].field_title,\n        extfield: false,\n        hiddenfield: false,\n        len: 10,\n        rowlayer: false,\n        type: gf[i].field_type\n      };\n      vf.push(field);\n      mapFieldsInVzm(vf[i], gf[i]);\n    }\n  }\n  else {\n  \u002f\u002f hanno lo stesso indice di colonna\n    for (i = 0; i \u003c vf.length; i++) {\n      var fgi = gridAlias.indexOf(vf[i].alias);\n      if (fgi \u003c 0)\n        continue;\n      mapFieldsInVzm(vf[i], gf[fgi]);\n    }\n  }\n\n  if (!isExtended)\n  \tthis.fields.Value(JSON.stringify(vf.filter(function(f,i) { return self.__toRemove.indexOf(i) \u003c 0 })));\n  else\n    this.fields.Value(JSON.stringify(vf));\n  \n  function mapFieldsInVzm(z_elem, g_elem) {\n    if (g_elem.field_type == \"constant\" && g_elem.field_expr == \"image\") {\n      z_elem.field_image = g_elem.field_image;\n      z_elem.field_image_height = g_elem.field_image_height;\n      z_elem.field_image_width = g_elem.field_image_width;\n      z_elem.desc = \"\";\n      z_elem.alias = \"SMARTREP_GEN_\" + i;\n      z_elem.generic = true;\n      z_elem.type = \"C\";\n      if (g_elem.field_image)\n        z_elem.type = \"I\";\n    }\n    else {\n      z_elem.desc = g_elem.field_title;\n      z_elem.field_image = g_elem.field_image;\n      z_elem.field_image_height = g_elem.field_image_height;\n      z_elem.field_image_width = g_elem.field_image_width;\n      z_elem.generic = (g_elem.field_type == \"constant\");\n      if (g_elem.field_expr == \"html\") {\n        if (z_elem.generic)\n          z_elem.alias = \"SMARTREP_HTML_\" + i;\n        z_elem.type = \"C\";\n        z_elem.html = g_elem.field_name_org;\n      }\n      else if (g_elem.field_expr == \"checkbox\")\n        z_elem.generic = false;\n      if (Empty(z_elem.field_name))\n        z_elem.field_name = z_elem.alias;\n    }\n\n    if (!(z_elem.alias in self._fldsTypeView)) {\n      var f = false;\n      for (var j = 0; !f && j \u003c cols.length; j++) {\n        if (cols[j].field == z_elem.alias && !z_elem.generic) {\n          f = true;\n          if (cols[j].inExtGrid)\n            self.__toRemove.push(i);\n          if (cols[j].checkbox) {\n            self._fldsTypeView[z_elem.alias] = \"checkbox\";\n            z_elem.generic = false;\n            z_elem.field_name_org = z_elem.alias;\n            z_elem.field_image_width = 10;\n            z_elem.field_image_height = 10;\n          }\n          else if (!Empty(cols[j].enable_HTML)) {\n            z_elem.type = \"C\";\n            self._fldsTypeView[z_elem.alias] = \"html\";\n            if (Empty(g_elem.field_name_org))\n              z_elem.html = \"%\" + z_elem.alias + \"%\";\n          }\n          else if (cols[j].isImage)\n            self._fldsTypeView[z_elem.alias] = \"image\";\n          else if (Empty(cols[j].enable_HTML) && cols[j].field.indexOf(\"html:\") == 0)\t{ \u002f\u002f campo generato aggiungendolo a mano nello zoom\n            z_elem.generic = true;\n            z_elem.alias = \"SMARTREP_HTML_\" + i;\n            self._fldsTypeView[z_elem.alias] = \"html_\" + j;\n            z_elem.type = \"C\";\n            z_elem.html = cols[j].field.slice(5);\n          }\n        }\n      }\n    }\n    else {\n      switch (self._fldsTypeView[z_elem.alias]) {\n        case \"checkbox\":\n          z_elem.generic = false;\n          z_elem.field_name_org = z_elem.alias;\n          z_elem.field_image_width = 10;\n          z_elem.field_image_height = 10;\n          break;\n        case \"html\":\n          z_elem.type = \"C\";\n          if (Empty(g_elem.field_name_org))\n            z_elem.html = \"%\" + z_elem.alias + \"%\";\n          break;\n        default:\n          if (self._fldsTypeView[z_elem.alias].indexOf(\"html_\") \u003e= 0) { \u002f\u002f campo generato aggiungendolo a mano nello zoom\n            z_elem.generic = true;\n            z_elem.alias = \"SMARTREP_HTML_\" + i;\n            z_elem.type = \"C\";\n            var cidx = parseInt(Strtran(self._fldsTypeView[z_elem.alias],\"html_\",\"\"));\n            z_elem.html = cols[cidx].field.slice(5);\n          }\n          break;\n      }\n    }\n  }\n}\n\nfunction btnEditReport_Click(repname){\n  this.ReportName.Value(repname);\n  this.smartReport_edit.Link();\n}\n\nfunction btnNewReport_Click(){    \n  this.smartReport_new.Link();\n}\n\nfunction btnPrint_Click(repname,reptitle,outputformat,filename,directprint,directdown,coverObj,rpwnd_id){\n  if (!this._isPrinting)\n    this._isPrinting = true;\n  this.ReportName.Value(repname);\n  this.title.Value(reptitle);\n  this.outputFormat.Value(outputformat);\n  this.FileName.Value(filename);\n  this.directPrint.Value(directprint);\n  this.directDown.Value(directdown);\n  this.RPwindowID.Value(rpwnd_id);\n  this.myCoverObj = coverObj;\n  if (!Empty(this.outputFormat.Value())) {\n    this.smartReport_print.popup_maximized = (maximized + \"\");\n    this.smartReport_print.maximized = (maximized + \"\");\n    if (this.directPrint.Value()) {\n      this.smartReport_print.target = this.IframePrint.name_iframe;\t\u002f\u002f'IframePrint';\n      this.smartReport_print.Link();\n    }\n    else if (this.directDown.Value()) {\n      this.smartReport_print.target = this.IframePrint.name_iframe;\t\u002f\u002f'IframePrint';\n      this.smartReport_print.Link();\n    }\n    else {\n      if (this.outputFormat.Value().toLowerCase().indexOf(\"xml\") \u003e= 0)\n        this.smartReport_print.target = this.IframePrint.name_iframe;\n      else\n      \tthis.smartReport_print.target = '';\n      this.smartReport_print.Link();\n    }\n  }\n  else {\n    this.print_splinker_smart.Link();\n  }\n}\n\nfunction btnCancel_Click(){\n  this.dispatchEvent( 'CloseRequest' );\n}\n\nfunction updateFileList(reportName, custom){  \n  if(this.ReportDialog) {\n    \tthis.ReportDialog.updateFileList(reportName, custom);\n    return;\n  }\n  var label = Strtran(reportName, self.configName.Value() + \"__\", \"\");\n  if (!reports[label]) {\n    reports[label] = { value: reportName };\n    if (!Empty(cValues)) {\n      cValues += \",\";\n      lValues += \",\";\n    }\n    cValues += label;\n    lValues += label;\n    self.ReportList.FillDataStatic(cValues, lValues);\n    self.ReportList.Value(label);\n    self.showAllCtrls();\n  }\n}\n\nfunction ReportList_onChange(){\n\tif (this.ReportList.Value() == \"spgridprint\") {\n    if (this.isPortletTitled())\n    \tthis.getTitlePortlet().RemoveButton(\"btn_edit\");\n    else\n      this.btnEditReport.Hide();\n  }\n  else {\n    if (this.isPortletTitled())\n      this.getTitlePortlet().AppendButton( {\n                               image: SPTheme.portalZoomPrintEditImage || imgsPath + 'spadministration_folder_edit.png'\n                             , action: 'javascript:' + this.formid + '.btnEditReport_Click()'\n                             , title: FormatMsg( 'RPT_MODIFY' )\n                             , tooltip: FormatMsg( 'RPT_MODIFY' ) \u002f\u002ftooltip\n                             , id: \"btn_edit\"\n                            }\n                            , 1\n                           );\n    else\n      this.btnEditReport.Show();\n  }\n}\n\nfunction RcvPrintParmsGrid(dati){\n  var sqldatap =  dati.isSqlDataProvider || false;\n  sqldatap = sqldatap && (dati.VqrName.indexOf(\"rows:\") \u003c 0)\n  this.isSqlDataProvider.Value(sqldatap);\n  this.setFieldsGrid(dati.fields);\n  this.spFields.Value(this.fields.Value());\n  this.fromVocal.Value(false);\n}\n\nfunction setFieldsGrid(gridF) {\n\tvar vf = JSON.parse(gridF);\n  \n  \u002f\u002f hanno lo stesso indice di colonna\n  for (var i = 0; i \u003c vf.length; i++) {\n    if (vf[i].field_type == \"constant\" && vf[i].field_expr == \"image\") {\n    \tvf[i].desc = \"\";\n      vf[i].alias = \"SMARTREP_GEN_\" + i;\n      vf[i].generic = true;\n      vf[i].type = \"C\";\n      if (vf[i].field_image)\n      \tvf[i].type = \"I\";\n    }\n    else if (vf[i].field_image)\n    \tvf[i].type = \"I\";\n    else {\n      vf[i].generic = (vf[i].field_type == \"constant\");\n      if (vf[i].field_expr == \"html\") {\n        if (vf[i].generic)\n        \tvf[i].alias = \"SMARTREP_HTML_\" + i;\n        vf[i].type = \"C\";\n        vf[i].html = vf[i].field_name_org;\n      }\n      else if (vf[i].field_expr == \"checkbox\")\n        vf[i].generic = false;\n    }\n    \n    \u002f*if (!(vf[i].alias in this._fldsTypeView)) {\n    \tthis._fldsTypeView[vf[i].alias] = vf[i].field_expr || vf[i].field_type;\n    }*\u002f\n  }\n\n  this.fields.Value(JSON.stringify(vf));\n}","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"SPPortalZoomPrint ptlnoopacity","css_code":"[{\"type\":\"undefined_type\",\"name\":\"ptlnoopacity\",\"selector\":\".ptlnoopacity\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"opacity:0 !important;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"undefined_type\\\",\\\"class_name\\\":\\\"ptlnoopacity\\\",\\\"selector\\\":\\\".ptlnoopacity\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"id\\\":\\\"form\\\",\\\"code\\\":\\\"opacity:0 !important;\\\"}\",\"code\":\".ptlnoopacity {\\n  opacity: 0 !important;\\n}\\n\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @lblReport }}{{ @lblOutput }}{{ @lblTitle }}{{ @btnPrint }}{{ @btnNewReport }}{{ @btnEditReport }}{{ @ReportList }}{{ @outFormat }}{{ @title }}{{ @btnCancel }}{{ @IframePrint }}\u003c\u002fbody\u003e","grapesCss":"","h":"1","hsl":"","htmlcode":"{{ @lblReport }}\n{{ @lblOutput }}\n{{ @lblTitle }}\n{{ @btnPrint }}\n{{ @btnNewReport }}\n{{ @btnEditReport }}\n{{ @smartReport_print }}\n{{ @ReportList }}\n{{ @outFormat }}\n{{ @openerID }}\n{{ @parentPortletID }}\n{{ @print_splinker_smart }}\n{{ @smartReport_new }}\n{{ @encFields }}\n{{ @title }}\n{{ @smartReport_edit }}\n{{ @spFields }}\n{{ @VqrName }}\n{{ @fields }}\n{{ @gridName }}\n{{ @btnCancel }}\n{{ @configName }}\n{{ @portletID }}\n{{ @updateFnc }}\n{{ @custom }}\n{{ @ReportName }}\n{{ @printSys }}\n{{ @FileName }}\n{{ @TableName }}\n{{ @VersionName }}\n{{ @cfgName }}\n\n{{ @directPrint }}\n{{ @directDown }}\n{{ @coverObject }}\n{{ @IframePrint }}\n{{ @fromGrid }}\n{{ @isSqlDataProvider }}\n{{ @printNoZoom }}\n{{ @printTitle }}\n{{ @hidePreview }}\n{{ @hidePrint }}\n{{ @hideExport }}\n{{ @hideSettings }}\n{{ @RPwindowID }}\n{{ @fromVocal }}\n{{ @Note47 }}\n{{ lblReport }}\n{{ lblOutput }}\n{{ lblTitle }}\n{{ btnPrint }}\n{{ btnNewReport }}\n{{ btnEditReport }}\n{{ smartReport_print }}\n{{ ReportList }}\n{{ outFormat }}\n{{ openerID }}\n{{ parentPortletID }}\n{{ print_splinker_smart }}\n{{ smartReport_new }}\n{{ encFields }}\n{{ title }}\n{{ smartReport_edit }}\n{{ Note47 }}{{ spFields }}{{ fromVocal }}\n{{ VqrName }}{{ Variable47 }}\n{{ fields }}\n{{ gridName }}\n{{ btnCancel }}\n{{ configName }}\n{{ portletID }}\n{{ updateFnc }}\n{{ custom }}\n{{ ReportName }}\n{{ printSys }}\n{{ Label27 }}\n{{ FileName }}\n{{ TableName }}\n{{ VersionName }}\n{{ cfgName }}\n{{ outputFormat }}\n{{ directPrint }}\n{{ directDown }}\n{{ coverObject }}\n{{ IframePrint }}\n{{ fromGrid }}\n{{ isSqlDataProvider }}\n{{ printNoZoom }}\n{{ printTitle }}\n{{ hidePreview }}\n{{ hidePrint }}\n{{ hideExport }}\n{{ hideSettings }}\n{{ RPwindowID }}\n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"","max_w":"","min_w":"","mode":"NORMAL","my_library":"controls.js,SPReportMask.js","offline":"","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"1\",\"w\":\"1\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"none","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"1","wizard":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblReport","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Report:","w":"50","wireframe_props":"align,value,n_col","x":"5","y":"8","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOutput","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"RPT_FORMAT:","w":"115","wireframe_props":"align,value,n_col","x":"192","y":"8","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"this.ReportList.Value()!='spgridprint'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MSG_VZM_PRINT_TITLE:","w":"50","wireframe_props":"align,value,n_col","x":"5","y":"38","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"MSG_VZM_PRINT","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnPrint","page":"1","rapp":"","sequence":"3","spuid":"","tabindex":"1","type":"Button","type_submit":"false","type_wizard":"","value":"MSG_VZM_PRINT","w":"100","wireframe_props":"value","x":"227","y":"70","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"NEW_REPORT","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnNewReport","page":"1","rapp":"","sequence":"4","spuid":"","tabindex":"1","type":"Button","type_submit":"false","type_wizard":"","value":"NEW_REPORT","w":"100","wireframe_props":"value","x":"7","y":"70","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"RPT_MODIFY","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnEditReport","page":"1","rapp":"","sequence":"5","spuid":"","tabindex":"1","type":"Button","type_submit":"false","type_wizard":"","value":"RPT_MODIFY","w":"100","wireframe_props":"value","x":"117","y":"70","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"30","m_cAction":"start","name":"smartReport_print","offline":"false","page":"1","parms":"parentPortletID,gridName,outputFormat,ReportName,custom,title,FileName,portletID,directPrint,directDown,printNoZoom,RPwindowID","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"..\u002fjsp-system\u002fSPPortalZoomSmartPrint_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"617","y":"-24"},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"ReportList","page":"1","picture":"","rapp":"","sequence":"7","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"122","wireframe_props":"name,textlist","x":"60","y":"8","zindex":"3","zone":""},{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"'PDF'","layer":"false","layout_steps_values":"{}","name":"outFormat","page":"1","picture":"","rapp":"","sequence":"8","spuid":"","tabindex":"","textlist":"Csv,Standard Csv,Html,Pdf,Sdf,Xml","type":"Combobox","typevar":"character","valuelist":"CSV,CSVS,HTML,PDF,CSV2,XML,XMLS","visible":"true","w":"122","wireframe_props":"name,textlist","x":"312","y":"8","zindex":"3","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"openerID","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"16"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"parentPortletID","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"120"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"smartreport","h":"30","m_cAction":"","name":"print_splinker_smart","offline":"","page":"1","parms":"ReportName,custom=custom,gridName=gridName,parentPortletID=parentPortletID,printPortletID=portletID","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"","target":"","type":"SPLinker","w":"30","x":"582","y":"-24"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"30","m_cAction":"","name":"smartReport_new","offline":"","page":"1","parms":"datasource=VqrName,portletID=parentPortletID,gridID=gridName,configName=cfgName,ptl=portletID,updfnc=updateFnc","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"..\u002fsmartreport\u002fsmartreport.jsp","target":"","type":"SPLinker","w":"30","x":"512","y":"-24"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"encFields","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"146"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"22","help_tips":"","hide":"","hide_undercond":"this.ReportList.Value()!='spgridprint'","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"title","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"14","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"359","wireframe_props":"name","x":"60","y":"38","zerofilling":"false","zindex":"4","zone":"","zoom":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"30","m_cAction":"","name":"smartReport_edit","offline":"","page":"1","parms":"id=ReportName,datasource=VqrName,portletID=parentPortletID,gridID=gridName,cbfnc=callbackFnc,ptl=portletID,updfnc=updateFnc,configName=cfgName,custom=custom","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"..\u002fsmartreport\u002fsmartreport.jsp","target":"","type":"SPLinker","w":"30","x":"547","y":"-24"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"spFields","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"VqrName","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"42"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"fields","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"gridName","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"94"},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnCancel","page":"1","rapp":"","sequence":"20","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_CANCEL","w":"100","wireframe_props":"value","x":"337","y":"70","zindex":"2","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"configName","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"16"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"portletID","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"198"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'updateFileList'","name":"updateFnc","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"224"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"false","name":"custom","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"513","y":"250"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"ReportName","page":"1","reactive":"","sequence":"25","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"42"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"report","h":"30","m_cAction":"","name":"printSys","offline":"","page":"1","parms":"ReportName,isSmartReport=true,portletID,ConfigName=configName,TableName,VersionName,parentPortletID,printTitle,hidePreview,hidePrint,hideExport,hideSettings","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":"","refresh":"","sequence":"26","servlet":"","target":"","type":"SPLinker","w":"30","x":"652","y":"-24"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"FileName","page":"1","reactive":"","sequence":"27","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"513","y":"172"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"TableName","page":"1","reactive":"","sequence":"28","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"94"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"VersionName","page":"1","reactive":"","sequence":"29","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"120"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"cfgName","page":"1","reactive":"","sequence":"30","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"146"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"'PDF'","name":"outputFormat","page":"1","reactive":"","sequence":"31","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"172"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"directPrint","page":"1","reactive":"","sequence":"32","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"677","y":"198"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"directDown","page":"1","reactive":"","sequence":"33","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"677","y":"224"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"coverObject","page":"1","reactive":"","sequence":"34","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"677","y":"250"},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"30","hide":"false","layer":"false","layout_steps_values":"{}","name":"IframePrint","page":"1","rapp":"","sequence":"35","spuid":"","type":"Iframe","w":"30","wireframe_props":"","x":"687","y":"-24","zindex":"9","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"fromGrid","page":"1","reactive":"","sequence":"36","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"16"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"isSqlDataProvider","page":"1","reactive":"","sequence":"37","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"42"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"printNoZoom","page":"1","reactive":"","sequence":"38","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"printTitle","page":"1","reactive":"","sequence":"39","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"841","y":"94"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"hidePreview","page":"1","reactive":"","sequence":"40","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"120"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"hidePrint","page":"1","reactive":"","sequence":"41","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"146"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"hideExport","page":"1","reactive":"","sequence":"42","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"172"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"hideSettings","page":"1","reactive":"","sequence":"43","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"198"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"RPwindowID","page":"1","reactive":"","sequence":"44","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"841","y":"224"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"false","name":"fromVocal","page":"1","reactive":"","sequence":"45","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"841","y":"250"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"57","hide":"","layer":"","layout_steps_values":"{}","name":"Note47","page":"1","rapp":"","sequence":"46","spuid":"","type":"Note","value":"ATTENZIONE : il portlet ha className ptlnoopacity, con valore di opacity forzato a 0!","w":"430","wireframe_props":"","x":"6","y":"105","zindex":"10","zone":""}]%>
<%/*Description:*/%>
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
window.SPPortalZoomPrint_Static=function(){
if(typeof getFields !='undefined')this.getFields=getFields;
if(typeof getSpFields !='undefined')this.getSpFields=getSpFields;
if(typeof getFieldsTypeView !='undefined')this.getFieldsTypeView=getFieldsTypeView;
if(typeof getCoverObject !='undefined')this.getCoverObject=getCoverObject;
if(typeof printTotals !='undefined')this.printTotals=printTotals;
if(typeof isMaximized !='undefined')this.isMaximized=isMaximized;
if(typeof hasGroupRepeated !='undefined')this.hasGroupRepeated=hasGroupRepeated;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof hideAllCtrls !='undefined')this.hideAllCtrls=hideAllCtrls;
if(typeof showAllCtrls !='undefined')this.showAllCtrls=showAllCtrls;
if(typeof RcvPrintParms !='undefined')this.RcvPrintParms=RcvPrintParms;
if(typeof RcvPrintParmsZoom !='undefined')this.RcvPrintParmsZoom=RcvPrintParmsZoom;
if(typeof filterField !='undefined')this.filterField=filterField;
if(typeof setFieldsZoom !='undefined')this.setFieldsZoom=setFieldsZoom;
if(typeof mapFieldsInVzm !='undefined')this.mapFieldsInVzm=mapFieldsInVzm;
if(typeof btnEditReport_Click !='undefined')this.btnEditReport_Click=btnEditReport_Click;
if(typeof btnNewReport_Click !='undefined')this.btnNewReport_Click=btnNewReport_Click;
if(typeof btnPrint_Click !='undefined')this.btnPrint_Click=btnPrint_Click;
if(typeof btnCancel_Click !='undefined')this.btnCancel_Click=btnCancel_Click;
if(typeof updateFileList !='undefined')this.updateFileList=updateFileList;
if(typeof ReportList_onChange !='undefined')this.ReportList_onChange=ReportList_onChange;
if(typeof RcvPrintParmsGrid !='undefined')this.RcvPrintParmsGrid=RcvPrintParmsGrid;
if(typeof setFieldsGrid !='undefined')this.setFieldsGrid=setFieldsGrid;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Ne(this.ReportList.Value(),'spgridprint'),this.lblTitle);
ZtVWeb.HideCtrl(Ne(this.ReportList.Value(),'spgridprint'),this.title);
}
var self,
    btnCreated = false,
		cValues = "",
		lValues = "",
		reports = {},
		customFiles = [],
		print_totals = false,
		maximized = false,
		group_repeated = false;
this.myCoverObj = null;
this.IframePrint.Resize(1,1);
this._fldsTypeView = {};
this.__gopen = null;
function getFields() {
  return this.fields.Value();
}
function getSpFields() {
  return this.spFields.Value();
}
function getFieldsTypeView() {
  return this._fldsTypeView;
}
function getCoverObject() {
  return this.myCoverObj;
}
function printTotals() {
	return print_totals;
}
function isMaximized() {
  return maximized;
}
function hasGroupRepeated() {
  return group_repeated;
}
function this_Loaded(){
  self = this;
  this.IframePrint.name_iframe = this.formid + "IframePrint";
  this.IframePrint.GetCtrl().innerHTML = "";
  var iframe = document.createElement("IFRAME");
  iframe.id = this.IframePrint.id + "_iframe";
  iframe.name = this.IframePrint.name_iframe;
  iframe.spparentobjid = this.formid;
  iframe.height = 1;
  iframe.width = 1;
  iframe.style.margin = 0 + "px";
  iframe.style.border = 0 + "px";
	this.IframePrint.GetCtrl().appendChild(iframe);
  this.hideAllCtrls();
  this.portletID.Value(this.formid);
}
function hideAllCtrls(){
	this.lblReport.Hide();
  this.ReportList.Hide();
  this.lblOutput.Hide();
  this.outFormat.Hide();
  this.btnNewReport.Hide();
  this.btnEditReport.Hide();
  this.btnPrint.Hide();
  this.btnCancel.Hide();
}
function showAllCtrls(){
	this.lblReport.Show();
  this.ReportList.Show();
  this.lblOutput.Show();
  this.outFormat.Show();
  if ( this.isPortletTitled()  && !btnCreated) {
    var imgsPath = '../' + ZtVWeb.theme + '/images/'
      , ptlTitle = this.getTitlePortlet()
      ;
    ptlTitle.SetTitle( "Print" );
   	ptlTitle.AppendButton( {
      											 image: SPTheme.portalZoomPrintAddImage || imgsPath + 'spadministration_folder_add.png'
                           , action: 'javascript:' + this.formid + '.btnNewReport_Click()'
                           , title: FormatMsg( 'NEW_REPORT' )
                           , tooltip: FormatMsg( 'NEW_REPORT' ) //tooltip
      										 , id: "btn_new"
    											} 
                         );
    ptlTitle.AppendButton( {
      											 image: SPTheme.portalZoomPrintEditImage || imgsPath + 'spadministration_folder_edit.png'
                           , action: 'javascript:' + this.formid + '.btnEditReport_Click()'
                           , title: FormatMsg( 'RPT_MODIFY' )
                           , tooltip: FormatMsg( 'RPT_MODIFY' ) //tooltip
      										 , id: "btn_edit"
    											} 
                         );
    ptlTitle.AppendButton( {
      											 image: SPTheme.portalZoomPrintImage || imgsPath + 'custom_toolbar/print.png'
                           , action: 'javascript:' + this.formid + '.btnPrint_Click()'
                           , title: FormatMsg( 'MSG_VZM_PRINT' )
                           , tooltip: FormatMsg( 'MSG_VZM_PRINT' ) //tooltip
      										 , id: "btn_print"
    											} 
                         );
    ptlTitle.AppendButton( {
      											 image: SPTheme.portalZoomPrintDiscardImage || imgsPath +'custom_toolbar/close.png'
                           , action: 'javascript:' + this.formid + '.btnCancel_Click()'
                           , title: FormatMsg( 'ADMIN_CANCEL' )
                           , tooltip: FormatMsg( 'ADMIN_CANCEL' ) //tooltip
      										 , id: "btn_close"
    											} 
                         );
    btnCreated = true;
  }
  else if(!btnCreated) {
    this.btnNewReport.Show();
    this.btnEditReport.Show();
    this.btnPrint.Show();
    this.btnCancel.Show();
  }
}
function RcvPrintParms(dati){
  this._isPrinting = true;
  this.fromGrid.Value(CharToBool(dati.fromGrid + ""));
  this.printNoZoom.Value(false);
  this.VqrName.Value(dati.VqrName);
  this.gridName.Value(dati.gridName || '');
  this.openerID.Value(dati.openerID || '');
  this.parentPortletID.Value(this.openerID.Value() || ZtVWeb.getParentPortlet(this.formid).formid);
  this.__gopen = ZtVWeb.getParentPortlet(this.formid);
  this.printTitle.Value(dati.title || '');
  var prnMode = (dati.printMode || 'default');
  if (prnMode == 'preview') {
    this.hidePrint.Value(true);
    this.hidePreview.Value(false);
  }
  else if (prnMode == 'print') {
    this.hidePrint.Value(false);
    this.hidePreview.Value(true);
  }
  else {
    this.hidePrint.Value(false);
    this.hidePreview.Value(false);
  }
  
  this.hideExport.Value(dati.printHideExport || false);
  this.hideSettings.Value(dati.printHideSettings || false);
  
  if (this.fromGrid.Value())
    this.RcvPrintParmsGrid(dati);
  else
    this.RcvPrintParmsZoom(dati);
 	
  print_totals = dati.printTotals || false;
  maximized = dati.maximized || false;
  group_repeated = dati.group_repeated || false;
  
  if (this.fromVocal.Value() == true) {
    var directdownload = true;
    if (this._outformat == "PDF" || this._outformat == "HTML")
      directdownload = false;
  	this.btnPrint_Click( this.ReportName.Value()
                        , ""
                        , this._outformat
                        , LibJavascript.AlfaKeyGen(10)
                        , false
                        , directdownload
                        , {objString: "[]", coverPrint: false, numPageCover: false, csvSeparator: "", csvHeader: true}
                        , ""
		);
  }
  else {
  	if (!Empty(dati.outputFormat) && (dati.outputFormat.toLowerCase() != "default"))
      this.btnPrint_Click( this.ReportName.Value()
                        , (dati.title || "")
                        , dati.outputFormat
                        , LibJavascript.AlfaKeyGen(10)
                        , false
                        , (dati.outputFormat != "PDF" && dati.outputFormat != "HTML")
                        , {objString: "[]", coverPrint: false, numPageCover: false, csvSeparator: "", csvHeader: true}
                        , ""
      );
    else
    	this.printSys.Link();
  }
}
function RcvPrintParmsZoom(dati){
	this.configName.Value(dati.configurationName);
  this.TableName.Value(dati.tableName);
  this.VersionName.Value(ZtVWeb.getParentPortlet(this.formid).GetCurrentVersion());
  if (this.VersionName.Value() != "default" && this.configName.Value().indexOf(this.VersionName.Value()) >= 0)
    this.configName.Value(Strtran(this.configName.Value(), "__" + this.VersionName.Value(), ""));
  else if (this.VersionName.Value() == "default")
    this.VersionName.Value("");
  var cfg = this.configName.Value();
  if (!Empty(this.VersionName.Value()))
    cfg = cfg + "__" + this.VersionName.Value();
  cfg = cfg + "." + this.TableName.Value();
	this.cfgName.Value(cfg);
  this.setFieldsZoom(dati.fields, ZtVWeb.getParentPortlet(this.formid).getFieldsForPrint(), dati.vzmstructure.Cols, dati.isExtended);
  this.encFields.Value( URLenc( this.fields.Value() ) );
  var fds = JSON.parse(this.fields.Value());
  this.spFields.Value( JSON.stringify(fds.filter(filterField)) );
  this.ReportName.Value(dati.ReportName);
  if(!Empty(this.ReportName.Value())) {
  	this.TableName.Value("");
    this.VersionName.Value("");
    this.cfgName.Value("");
  }
  
  if (dati.vzmstructure && dati.vzmstructure.Configuration) {
  	if (dati.vzmstructure.Configuration.PrintMode == "SmartReport")
			this.printNoZoom.Value(true);
	}
  
  this.fromVocal.Value(dati.vocalPrint);
  this._outformat = (dati.outformat.toUpperCase()) || "PDF";
  
  function filterField(field) {
    if (!field.hiddenfield && !field.collayer && !field.rowlayer)
      return true;
    return false;
  }
}
this.__toRemove = [];
function setFieldsZoom(gridF, vzmF, cols, isExtended) {
	var gf = JSON.parse(gridF),
      vf = JSON.parse(vzmF),
  		gridAlias = gf.map(function(field){
    											return field.field_name;
  											}),
      emptyFlds = (Empty(vf) && !Empty(gf)),	// configurazione zoom vuota ma la griglia ha i campi (prob. vqrpivot)
      i;
	
  if (emptyFlds) {
    for (i = 0; i < gf.length; i++) {
			var field = {
      	alias: gf[i].field_name,
        collayer: false,
        dec: 2,
        desc: gf[i].field_title,
        extfield: false,
        hiddenfield: false,
        len: 10,
        rowlayer: false,
        type: gf[i].field_type
      };
      vf.push(field);
      mapFieldsInVzm(vf[i], gf[i]);
    }
  }
  else {
  // hanno lo stesso indice di colonna
    for (i = 0; i < vf.length; i++) {
      var fgi = gridAlias.indexOf(vf[i].alias);
      if (fgi < 0)
        continue;
      mapFieldsInVzm(vf[i], gf[fgi]);
    }
  }
  if (!isExtended)
  	this.fields.Value(JSON.stringify(vf.filter(function(f,i) { return self.__toRemove.indexOf(i) < 0 })));
  else
    this.fields.Value(JSON.stringify(vf));
  
  function mapFieldsInVzm(z_elem, g_elem) {
    if (g_elem.field_type == "constant" && g_elem.field_expr == "image") {
      z_elem.field_image = g_elem.field_image;
      z_elem.field_image_height = g_elem.field_image_height;
      z_elem.field_image_width = g_elem.field_image_width;
      z_elem.desc = "";
      z_elem.alias = "SMARTREP_GEN_" + i;
      z_elem.generic = true;
      z_elem.type = "C";
      if (g_elem.field_image)
        z_elem.type = "I";
    }
    else {
      z_elem.desc = g_elem.field_title;
      z_elem.field_image = g_elem.field_image;
      z_elem.field_image_height = g_elem.field_image_height;
      z_elem.field_image_width = g_elem.field_image_width;
      z_elem.generic = (g_elem.field_type == "constant");
      if (g_elem.field_expr == "html") {
        if (z_elem.generic)
          z_elem.alias = "SMARTREP_HTML_" + i;
        z_elem.type = "C";
        z_elem.html = g_elem.field_name_org;
      }
      else if (g_elem.field_expr == "checkbox")
        z_elem.generic = false;
      if (Empty(z_elem.field_name))
        z_elem.field_name = z_elem.alias;
    }
    if (!(z_elem.alias in self._fldsTypeView)) {
      var f = false;
      for (var j = 0; !f && j < cols.length; j++) {
        if (cols[j].field == z_elem.alias && !z_elem.generic) {
          f = true;
          if (cols[j].inExtGrid)
            self.__toRemove.push(i);
          if (cols[j].checkbox) {
            self._fldsTypeView[z_elem.alias] = "checkbox";
            z_elem.generic = false;
            z_elem.field_name_org = z_elem.alias;
            z_elem.field_image_width = 10;
            z_elem.field_image_height = 10;
          }
          else if (!Empty(cols[j].enable_HTML)) {
            z_elem.type = "C";
            self._fldsTypeView[z_elem.alias] = "html";
            if (Empty(g_elem.field_name_org))
              z_elem.html = "%" + z_elem.alias + "%";
          }
          else if (cols[j].isImage)
            self._fldsTypeView[z_elem.alias] = "image";
          else if (Empty(cols[j].enable_HTML) && cols[j].field.indexOf("html:") == 0)	{ // campo generato aggiungendolo a mano nello zoom
            z_elem.generic = true;
            z_elem.alias = "SMARTREP_HTML_" + i;
            self._fldsTypeView[z_elem.alias] = "html_" + j;
            z_elem.type = "C";
            z_elem.html = cols[j].field.slice(5);
          }
        }
      }
    }
    else {
      switch (self._fldsTypeView[z_elem.alias]) {
        case "checkbox":
          z_elem.generic = false;
          z_elem.field_name_org = z_elem.alias;
          z_elem.field_image_width = 10;
          z_elem.field_image_height = 10;
          break;
        case "html":
          z_elem.type = "C";
          if (Empty(g_elem.field_name_org))
            z_elem.html = "%" + z_elem.alias + "%";
          break;
        default:
          if (self._fldsTypeView[z_elem.alias].indexOf("html_") >= 0) { // campo generato aggiungendolo a mano nello zoom
            z_elem.generic = true;
            z_elem.alias = "SMARTREP_HTML_" + i;
            z_elem.type = "C";
            var cidx = parseInt(Strtran(self._fldsTypeView[z_elem.alias],"html_",""));
            z_elem.html = cols[cidx].field.slice(5);
          }
          break;
      }
    }
  }
}
function btnEditReport_Click(repname){
  this.ReportName.Value(repname);
  this.smartReport_edit.Link();
}
function btnNewReport_Click(){    
  this.smartReport_new.Link();
}
function btnPrint_Click(repname,reptitle,outputformat,filename,directprint,directdown,coverObj,rpwnd_id){
  if (!this._isPrinting)
    this._isPrinting = true;
  this.ReportName.Value(repname);
  this.title.Value(reptitle);
  this.outputFormat.Value(outputformat);
  this.FileName.Value(filename);
  this.directPrint.Value(directprint);
  this.directDown.Value(directdown);
  this.RPwindowID.Value(rpwnd_id);
  this.myCoverObj = coverObj;
  if (!Empty(this.outputFormat.Value())) {
    this.smartReport_print.popup_maximized = (maximized + "");
    this.smartReport_print.maximized = (maximized + "");
    if (this.directPrint.Value()) {
      this.smartReport_print.target = this.IframePrint.name_iframe;	//'IframePrint';
      this.smartReport_print.Link();
    }
    else if (this.directDown.Value()) {
      this.smartReport_print.target = this.IframePrint.name_iframe;	//'IframePrint';
      this.smartReport_print.Link();
    }
    else {
      if (this.outputFormat.Value().toLowerCase().indexOf("xml") >= 0)
        this.smartReport_print.target = this.IframePrint.name_iframe;
      else
      	this.smartReport_print.target = '';
      this.smartReport_print.Link();
    }
  }
  else {
    this.print_splinker_smart.Link();
  }
}
function btnCancel_Click(){
  this.dispatchEvent( 'CloseRequest' );
}
function updateFileList(reportName, custom){  
  if(this.ReportDialog) {
    	this.ReportDialog.updateFileList(reportName, custom);
    return;
  }
  var label = Strtran(reportName, self.configName.Value() + "__", "");
  if (!reports[label]) {
    reports[label] = { value: reportName };
    if (!Empty(cValues)) {
      cValues += ",";
      lValues += ",";
    }
    cValues += label;
    lValues += label;
    self.ReportList.FillDataStatic(cValues, lValues);
    self.ReportList.Value(label);
    self.showAllCtrls();
  }
}
function ReportList_onChange(){
	if (this.ReportList.Value() == "spgridprint") {
    if (this.isPortletTitled())
    	this.getTitlePortlet().RemoveButton("btn_edit");
    else
      this.btnEditReport.Hide();
  }
  else {
    if (this.isPortletTitled())
      this.getTitlePortlet().AppendButton( {
                               image: SPTheme.portalZoomPrintEditImage || imgsPath + 'spadministration_folder_edit.png'
                             , action: 'javascript:' + this.formid + '.btnEditReport_Click()'
                             , title: FormatMsg( 'RPT_MODIFY' )
                             , tooltip: FormatMsg( 'RPT_MODIFY' ) //tooltip
                             , id: "btn_edit"
                            }
                            , 1
                           );
    else
      this.btnEditReport.Show();
  }
}
function RcvPrintParmsGrid(dati){
  var sqldatap =  dati.isSqlDataProvider || false;
  sqldatap = sqldatap && (dati.VqrName.indexOf("rows:") < 0)
  this.isSqlDataProvider.Value(sqldatap);
  this.setFieldsGrid(dati.fields);
  this.spFields.Value(this.fields.Value());
  this.fromVocal.Value(false);
}
function setFieldsGrid(gridF) {
	var vf = JSON.parse(gridF);
  
  // hanno lo stesso indice di colonna
  for (var i = 0; i < vf.length; i++) {
    if (vf[i].field_type == "constant" && vf[i].field_expr == "image") {
    	vf[i].desc = "";
      vf[i].alias = "SMARTREP_GEN_" + i;
      vf[i].generic = true;
      vf[i].type = "C";
      if (vf[i].field_image)
      	vf[i].type = "I";
    }
    else if (vf[i].field_image)
    	vf[i].type = "I";
    else {
      vf[i].generic = (vf[i].field_type == "constant");
      if (vf[i].field_expr == "html") {
        if (vf[i].generic)
        	vf[i].alias = "SMARTREP_HTML_" + i;
        vf[i].type = "C";
        vf[i].html = vf[i].field_name_org;
      }
      else if (vf[i].field_expr == "checkbox")
        vf[i].generic = false;
    }
    
    
  }
  this.fields.Value(JSON.stringify(vf));
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
.SPPortalZoomPrint_container .ptlnoopacity{  opacity:0 !important;
}
.SPPortalZoomPrint_container {
}
.SPPortalZoomPrint_portlet{
  position:relative;
  width:1px;
  min-width:1px;
  height:1px;
}
.SPPortalZoomPrint_portlet[Data-page="1"]{
  height:1px;
  width:1px;
}
.SPPortalZoomPrint_portlet > .lblReport_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:5px;
  width:50px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomPrint_portlet > .lblReport_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomPrint_portlet > .lblReport_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomPrint_portlet > .lblOutput_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:192px;
  width:115px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomPrint_portlet > .lblOutput_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomPrint_portlet > .lblOutput_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomPrint_portlet > .lblTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:5px;
  width:50px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomPrint_portlet > .lblTitle_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomPrint_portlet > .lblTitle_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.SPPortalZoomPrint_portlet > .btnPrint_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  right:-326px;
  width:100px;
  height:25px;
}
.SPPortalZoomPrint_portlet > .btnPrint_ctrl {
}
.SPPortalZoomPrint_portlet > .btnNewReport_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  right:-106px;
  width:100px;
  height:25px;
}
.SPPortalZoomPrint_portlet > .btnNewReport_ctrl {
}
.SPPortalZoomPrint_portlet > .btnEditReport_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  right:-216px;
  width:100px;
  height:25px;
}
.SPPortalZoomPrint_portlet > .btnEditReport_ctrl {
}
.SPPortalZoomPrint_portlet > .ReportList_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:8px;
  left:60px;
  right:-181px;
  width:122px;
  height:22px;
}
.SPPortalZoomPrint_portlet > .outFormat_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:8px;
  left:312px;
  right:-433px;
  width:122px;
  height:22px;
}
.SPPortalZoomPrint_portlet > .title_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:38px;
  left:60px;
  width:359px;
  height:22px;
}
.SPPortalZoomPrint_portlet > .title_ctrl {
  display:none;
}
.SPPortalZoomPrint_portlet > .title_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomPrint_portlet > .btnCancel_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:70px;
  right:-436px;
  width:100px;
  height:25px;
}
.SPPortalZoomPrint_portlet > .btnCancel_ctrl {
}
.SPPortalZoomPrint_portlet > .IframePrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:-24px;
  left:687px;
  width:30px;
  height:30px;
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
 String def="[{\"h\":\"1\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"none\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"1\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Report:\",\"w\":\"50\",\"x\":\"5\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"RPT_FORMAT:\",\"w\":\"115\",\"x\":\"192\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MSG_VZM_PRINT_TITLE:\",\"w\":\"50\",\"x\":\"5\",\"y\":\"38\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"25\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"MSG_VZM_PRINT\",\"w\":\"100\",\"x\":\"227\",\"y\":\"70\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"25\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"NEW_REPORT\",\"w\":\"100\",\"x\":\"7\",\"y\":\"70\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"25\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"RPT_MODIFY\",\"w\":\"100\",\"x\":\"117\",\"y\":\"70\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"617\",\"y\":\"-24\"},{\"anchor\":\"top-left-right\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"ReportList\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"122\",\"x\":\"60\",\"y\":\"8\",\"zindex\":\"3\"},{\"anchor\":\"top-left-right\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"outFormat\",\"page\":\"1\",\"textlist\":\"Csv,Standard Csv,Html,Pdf,Sdf,Xml\",\"type\":\"Combobox\",\"w\":\"122\",\"x\":\"312\",\"y\":\"8\",\"zindex\":\"3\"},{\"h\":\"22\",\"name\":\"openerID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"16\"},{\"h\":\"22\",\"name\":\"parentPortletID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"120\"},{\"h\":\"30\",\"name\":\"print_splinker_smart\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"582\",\"y\":\"-24\"},{\"h\":\"30\",\"name\":\"smartReport_new\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"512\",\"y\":\"-24\"},{\"h\":\"22\",\"name\":\"encFields\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"146\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"title\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"359\",\"x\":\"60\",\"y\":\"38\",\"zindex\":\"4\"},{\"h\":\"30\",\"name\":\"smartReport_edit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"547\",\"y\":\"-24\"},{\"h\":\"22\",\"name\":\"spFields\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"68\"},{\"h\":\"22\",\"name\":\"VqrName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"42\"},{\"h\":\"22\",\"name\":\"fields\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"68\"},{\"h\":\"22\",\"name\":\"gridName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"94\"},{\"anchor\":\"top-right\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"btnCancel\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_CANCEL\",\"w\":\"100\",\"x\":\"337\",\"y\":\"70\",\"zindex\":\"2\"},{\"h\":\"22\",\"name\":\"configName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"16\"},{\"h\":\"22\",\"name\":\"portletID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"198\"},{\"h\":\"22\",\"name\":\"updateFnc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"224\"},{\"h\":\"22\",\"name\":\"custom\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"250\"},{\"h\":\"22\",\"name\":\"ReportName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"42\"},{\"h\":\"30\",\"name\":\"printSys\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"652\",\"y\":\"-24\"},{\"h\":\"22\",\"name\":\"FileName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"513\",\"y\":\"172\"},{\"h\":\"22\",\"name\":\"TableName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"94\"},{\"h\":\"22\",\"name\":\"VersionName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"120\"},{\"h\":\"22\",\"name\":\"cfgName\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"146\"},{\"h\":\"22\",\"name\":\"outputFormat\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"172\"},{\"h\":\"22\",\"name\":\"directPrint\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"198\"},{\"h\":\"22\",\"name\":\"directDown\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"224\"},{\"h\":\"22\",\"name\":\"coverObject\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"677\",\"y\":\"250\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"IframePrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"30\",\"x\":\"687\",\"y\":\"-24\",\"zindex\":\"9\"},{\"h\":\"22\",\"name\":\"fromGrid\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"16\"},{\"h\":\"22\",\"name\":\"isSqlDataProvider\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"42\"},{\"h\":\"22\",\"name\":\"printNoZoom\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"68\"},{\"h\":\"22\",\"name\":\"printTitle\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"94\"},{\"h\":\"22\",\"name\":\"hidePreview\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"120\"},{\"h\":\"22\",\"name\":\"hidePrint\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"146\"},{\"h\":\"22\",\"name\":\"hideExport\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"172\"},{\"h\":\"22\",\"name\":\"hideSettings\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"198\"},{\"h\":\"22\",\"name\":\"RPwindowID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"224\"},{\"h\":\"22\",\"name\":\"fromVocal\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"841\",\"y\":\"250\"},{\"anchor\":\"\",\"h\":\"57\",\"layout_steps_values\":{},\"name\":\"Note47\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"ATTENZIONE : il portlet ha className ptlnoopacity, con valore di opacity forzato a 0!\",\"w\":\"430\",\"x\":\"6\",\"y\":\"105\",\"zindex\":\"10\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomPrint","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomPrint_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("SPReportMask.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomPrint','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblReport= "Report:";
String lblOutput= "RPT_FORMAT:";
String lblTitle= "MSG_VZM_PRINT_TITLE:";
String ReportList= "";
String outFormat="PDF";
String openerID= "";
String parentPortletID= "";
String encFields= "";
String title= "";
if(request.getAttribute("SPPortalZoomPrint_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String spFields= "";
String VqrName= "";
String fields= "";
String gridName= "";
String configName= "";
String portletID= "";
String updateFnc="updateFileList";
boolean custom=false;
String ReportName= "";
String FileName= "";
String TableName= "";
String VersionName= "";
String cfgName= "";
String outputFormat="PDF";
boolean directPrint= false;
boolean directDown= false;
String coverObject= "";
boolean fromGrid= false;
boolean isSqlDataProvider= false;
boolean printNoZoom= false;
String printTitle= "";
boolean hidePreview= false;
boolean hidePrint= false;
boolean hideExport= false;
boolean hideSettings= false;
String RPwindowID= "";
boolean fromVocal=false;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomPrint_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomPrint_portlet SPPortalZoomPrint ptlnoopacity' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomPrint','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblReport'  formid='<%=idPortlet%>' ps-name='lblReport'    class='label lblReport_ctrl'><div id='<%=idPortlet%>_lblReporttbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Report:"))%></div></span>
<span id='<%=idPortlet%>_lblOutput'  formid='<%=idPortlet%>' ps-name='lblOutput'    class='label lblOutput_ctrl'><div id='<%=idPortlet%>_lblOutputtbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("RPT_FORMAT:"))%></div></span>
<span id='<%=idPortlet%>_lblTitle'  formid='<%=idPortlet%>' ps-name='lblTitle'    class='label lblTitle_ctrl'><div id='<%=idPortlet%>_lblTitletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_VZM_PRINT_TITLE:"))%></div></span>
<input id='<%=idPortlet%>_btnPrint' type='button' class='button btnPrint_ctrl' tabindex='1'/>
<input id='<%=idPortlet%>_btnNewReport' type='button' class='button btnNewReport_ctrl' tabindex='1'/>
<input id='<%=idPortlet%>_btnEditReport' type='button' class='button btnEditReport_ctrl' tabindex='1'/>
<select id='<%=idPortlet%>_ReportList' name='ReportList' class='combobox' style=''></select>
<select id='<%=idPortlet%>_outFormat' name='outFormat' class='combobox' style=''></select>
<span class='textbox-container'id='<%=idPortlet%>_title_wrp'><input id='<%=idPortlet%>_title' name='title' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='title' /></span>
<input id='<%=idPortlet%>_btnCancel' type='button' class='button btnCancel_ctrl'/>
<div id='<%=idPortlet%>_IframePrint_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomPrint');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_CANCEL",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_CANCEL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_VZM_PRINT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_VZM_PRINT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("NEW_REPORT",true)+","+JSPLib.ToJSValue(sp.translate("NEW_REPORT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("RPT_MODIFY",true)+","+JSPLib.ToJSValue(sp.translate("RPT_MODIFY"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomPrint',["1"],["1"],'SPPortalZoomPrint ptlnoopacity',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1","h":"1","title":"","layer":""}]);
this.lblReport=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblReport","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblReport","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblReport),false,true)%>","type":"Label","w":50,"x":5,"y":8,"zindex":"1"});
this.lblOutput=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOutput","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOutput","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblOutput),false,true)%>","type":"Label","w":115,"x":192,"y":8,"zindex":"1"});
this.lblTitle=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"this.ReportList.Value()!='spgridprint'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitle","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblTitle),false,true)%>","type":"Label","w":50,"x":5,"y":38,"zindex":"1"});
this.btnPrint=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnPrint_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnPrint","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("MSG_VZM_PRINT"),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnPrint","page":1,"spuid":"","tabindex":"1","text":"<%=JSPLib.ToJSValue(sp.translate("MSG_VZM_PRINT"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":100,"x":227,"y":70,"zindex":"1"});
this.btnNewReport=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnNewReport_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnNewReport","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("NEW_REPORT"),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnNewReport","page":1,"spuid":"","tabindex":"1","text":"<%=JSPLib.ToJSValue(sp.translate("NEW_REPORT"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":100,"x":7,"y":70,"zindex":"1"});
this.btnEditReport=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnEditReport_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnEditReport","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("RPT_MODIFY"),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnEditReport","page":1,"spuid":"","tabindex":"1","text":"<%=JSPLib.ToJSValue(sp.translate("RPT_MODIFY"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":100,"x":117,"y":70,"zindex":"1"});
this.smartReport_print=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_smartReport_print","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"smartReport_print","offline":false,"page":1,"parms":"parentPortletID,gridName,outputFormat,ReportName,custom,title,FileName,portletID,directPrint,directDown,printNoZoom,RPwindowID","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fSPPortalZoomSmartPrint_portlet.jsp","target":"","type":"SPLinker","w":30,"x":617,"y":-24});
this.smartReport_print.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/SPPortalZoomSmartPrint_portlet.jsp",request.getSession())%>';
this.ReportList=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_ReportList","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=ReportList%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"ReportList","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":122,"x":60,"y":8,"zindex":"3"});
this.outFormat=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left-right","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_outFormat","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=outFormat%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"outFormat","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"<%=JSPLib.ToJSValue(sp.translate("Csv"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Standard Csv"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Html"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Pdf"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Sdf"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Xml"),false,true)%>","type":"Combobox","typevar":"character","valuelist":"CSV,CSVS,HTML,PDF,CSV2,XML,XMLS","visible":true,"w":122,"x":312,"y":8,"zindex":"3"});
this.openerID=new ZtVWeb._VC(this,'openerID',null,'character','<%=JSPLib.ToJSValue(openerID,false,true)%>',false,false);
this.parentPortletID=new ZtVWeb._VC(this,'parentPortletID',null,'character','<%=JSPLib.ToJSValue(parentPortletID,false,true)%>',false,false);
this.print_splinker_smart=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_print_splinker_smart","decrypted_parms":"","entity_type":"smartreport","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"print_splinker_smart","offline":false,"page":1,"parms":"ReportName,custom=custom,gridName=gridName,parentPortletID=parentPortletID,printPortletID=portletID","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":582,"y":-24});
this.print_splinker_smart.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.smartReport_new=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_smartReport_new","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"smartReport_new","offline":false,"page":1,"parms":"datasource=VqrName,portletID=parentPortletID,gridID=gridName,configName=cfgName,ptl=portletID,updfnc=updateFnc","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fsmartreport\u002fsmartreport.jsp","target":"","type":"SPLinker","w":30,"x":512,"y":-24});
this.smartReport_new.m_cID='<%=JSPLib.cmdHash("entity,../smartreport/smartreport.jsp",request.getSession())%>';
this.encFields=new ZtVWeb._VC(this,'encFields',null,'character','<%=JSPLib.ToJSValue(encFields,false,true)%>',false,false);
this.title=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_title","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"Ne(this.ReportList.Value(),'spgridprint')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"title","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(title,false,true)%>","w":359,"x":60,"y":38,"zerofilling":false,"zindex":"4","zoom":""});
this.smartReport_edit=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_smartReport_edit","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"smartReport_edit","offline":false,"page":1,"parms":"id=ReportName,datasource=VqrName,portletID=parentPortletID,gridID=gridName,cbfnc=callbackFnc,ptl=portletID,updfnc=updateFnc,configName=cfgName,custom=custom","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"..\u002fsmartreport\u002fsmartreport.jsp","target":"","type":"SPLinker","w":30,"x":547,"y":-24});
this.smartReport_edit.m_cID='<%=JSPLib.cmdHash("entity,../smartreport/smartreport.jsp",request.getSession())%>';
this.spFields=new ZtVWeb._VC(this,'spFields',null,'character','<%=JSPLib.ToJSValue(spFields,false,true)%>',false,false);
this.VqrName=new ZtVWeb._VC(this,'VqrName',null,'character','<%=JSPLib.ToJSValue(VqrName,false,true)%>',false,false);
this.fields=new ZtVWeb._VC(this,'fields',null,'character','<%=JSPLib.ToJSValue(fields,false,true)%>',false,false);
this.gridName=new ZtVWeb._VC(this,'gridName',null,'character','<%=JSPLib.ToJSValue(gridName,false,true)%>',false,false);
this.btnCancel=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btnCancel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCancel","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnCancel","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CANCEL"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":100,"x":337,"y":70,"zindex":"2"});
this.configName=new ZtVWeb._VC(this,'configName',null,'character','<%=JSPLib.ToJSValue(configName,false,true)%>',false,false);
this.portletID=new ZtVWeb._VC(this,'portletID',null,'character','<%=JSPLib.ToJSValue(portletID,false,true)%>',false,false);
this.updateFnc=new ZtVWeb._VC(this,'updateFnc',null,'character','<%=JSPLib.ToJSValue(updateFnc,false,true)%>',false,false);
this.custom=new ZtVWeb._VC(this,'custom',null,'logic',<%=custom%>,false,false);
this.ReportName=new ZtVWeb._VC(this,'ReportName',null,'character','<%=JSPLib.ToJSValue(ReportName,false,true)%>',false,false);
this.printSys=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_printSys","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"printSys","offline":false,"page":1,"parms":"ReportName,isSmartReport=true,portletID,ConfigName=configName,TableName,VersionName,parentPortletID,printTitle,hidePreview,hidePrint,hideExport,hideSettings","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":30,"x":652,"y":-24});
this.printSys.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.FileName=new ZtVWeb._VC(this,'FileName',null,'character','<%=JSPLib.ToJSValue(FileName,false,true)%>',false,false);
this.TableName=new ZtVWeb._VC(this,'TableName',null,'character','<%=JSPLib.ToJSValue(TableName,false,true)%>',false,false);
this.VersionName=new ZtVWeb._VC(this,'VersionName',null,'character','<%=JSPLib.ToJSValue(VersionName,false,true)%>',false,false);
this.cfgName=new ZtVWeb._VC(this,'cfgName',null,'character','<%=JSPLib.ToJSValue(cfgName,false,true)%>',false,false);
this.outputFormat=new ZtVWeb._VC(this,'outputFormat',null,'character','<%=JSPLib.ToJSValue(outputFormat,false,true)%>',false,false);
this.directPrint=new ZtVWeb._VC(this,'directPrint',null,'logic',<%=directPrint%>,false,false);
this.directDown=new ZtVWeb._VC(this,'directDown',null,'logic',<%=directDown%>,false,false);
this.coverObject=new ZtVWeb._VC(this,'coverObject',null,'character','<%=JSPLib.ToJSValue(coverObject,false,true)%>',false,false);
this.IframePrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_IframePrint","default_portlet":"","h":30,"hide":"false","layer":false,"layout_steps_values":{},"name":"IframePrint","name_iframe":"IframePrint","page":1,"spuid":"","type":"Iframe","w":30,"x":687,"y":-24,"zindex":"9"});
this.fromGrid=new ZtVWeb._VC(this,'fromGrid',null,'logic',<%=fromGrid%>,false,false);
this.isSqlDataProvider=new ZtVWeb._VC(this,'isSqlDataProvider',null,'logic',<%=isSqlDataProvider%>,false,false);
this.printNoZoom=new ZtVWeb._VC(this,'printNoZoom',null,'logic',<%=printNoZoom%>,false,false);
this.printTitle=new ZtVWeb._VC(this,'printTitle',null,'character','<%=JSPLib.ToJSValue(printTitle,false,true)%>',false,false);
this.hidePreview=new ZtVWeb._VC(this,'hidePreview',null,'logic',<%=hidePreview%>,false,false);
this.hidePrint=new ZtVWeb._VC(this,'hidePrint',null,'logic',<%=hidePrint%>,false,false);
this.hideExport=new ZtVWeb._VC(this,'hideExport',null,'logic',<%=hideExport%>,false,false);
this.hideSettings=new ZtVWeb._VC(this,'hideSettings',null,'logic',<%=hideSettings%>,false,false);
this.RPwindowID=new ZtVWeb._VC(this,'RPwindowID',null,'character','<%=JSPLib.ToJSValue(RPwindowID,false,true)%>',false,false);
this.fromVocal=new ZtVWeb._VC(this,'fromVocal',null,'logic',<%=fromVocal%>,false,false);
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
<%if(request.getAttribute("SPPortalZoomPrint_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPPortalZoomPrint_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomPrint_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.ReportList.FillData();
window.<%=idPortlet%>.outFormat.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomPrint',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomPrint');
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
sp.endPage("SPPortalZoomPrint");
}%>
<%! public String getJSPUID() { return "1403344100"; } %>