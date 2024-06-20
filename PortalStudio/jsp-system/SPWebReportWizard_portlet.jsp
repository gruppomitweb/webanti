<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"PSAlert.init(window, '');\nvar campi = ['field', 'desc'];\nvar campiTotal = ['field', 'desc', 'total'];\nvar tabstrip = eval(this.formid + \"_tabstrip\");\nvar height = 400, width = 600;\nvar left = 100, top = 100;\nthis.boxImage1.Hide();\nthis.TempAllFields = null;\nthis.TempQueryFields = null;\nvar customToolbarPortlet = this.getTitlePortlet();\nif (customToolbarPortlet.title) {\n  customToolbarPortlet.title.Value(\"WebReport\" + \" \u003cspan class='SPPortalZoom_currentversion'\u003e\" + \"Wizard\" + \"\u003c\u002fspan\u003e\");\n}\nif ( customToolbarPortlet.AppendButton ) {\n  \u002f\u002fcustomToolbarPortlet.toolbar.Append({\n  customToolbarPortlet.AppendButton({\n    id: \"tbcancel\",\n    title: FormatMsg(\"ADMIN_CANCEL\"),\n    tooltip: FormatMsg(\"ADMIN_CANCEL\"),\n    action: \"javascript:window.close()\",\n    image: GetStyleVariable(\"smartReportDiscardImage\", '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fclose.png\",pageContext.getServletContext())%\u003e'),\n    target: \"\"\n  });\n}\n\nfunction AddGenerateOnToolbar(){\n  \u002f\u002fvar toolb = this.getTitlePortlet().toolbar;\n  var act = \"javascript:window.\" + this.formid + \".bSave_Click()\";\n  \u002f\u002ftoolb.Append({\n\tif ( customToolbarPortlet.AppendButton ) {\n    customToolbarPortlet.AppendButton({\n      id: \"tbgenerate\",\n      title: FormatMsg(\"ADMIN_GENERATE\"),\n      tooltip: FormatMsg(\"ADMIN_GENERATE\"),\n      action: act,\n      image: GetStyleVariable(\"smartReportGenerateImage\", '..\u002fimages\u002fcustom_toolbar\u002fok.png'),\n      target: \"\"\n    });\n  }\n}\n\nfunction RemoveGenerateOnToolbar(){\n  \u002f*var toolb = this.getTitlePortlet().toolbar;\n  toolb.Remove(\"tbgenerate\");*\u002f\n\tif ( customToolbarPortlet.RemoveButton ) {\n    customToolbarPortlet.RemoveButton(\"tbgenerate\");\n  }\n}\n\nfunction validateQueryAndSelection(){\n  var dataSelected = this.gridFields.AllChecked() || this.gridFields.GetSelectedData().Data.length \u003e 1;\n  if (dataSelected && !Empty(this.queryName.Value()) && this.TempQueryFields != null && this.TempQueryFields[0] && this.TempQueryFields[0].length \u003e 0){\n    return true;\n  }\n  return false;\n}\n\nfunction validateReport(withAlert){\n  if (Empty(Trim(this.reportName.Value()))){\n    return false;\n  } else if (!(\u002f^[a-zA-Z][A-Za-z0-9-_]*$\u002f.test(this.reportName.Value()))){\n    if (withAlert == true){\n      PSAlert.alert('Invalid report file name...');\n    }\n    return false;\n  }\n  var url = new JSURL(\"..\u002fservlet\u002fJSPReader?type=webreport&name=\" + Trim(this.reportName.Value()) + \"&check=true\", true);\n  var output = url.Response();\n  if (output == \"found\"){\n    if (withAlert == true){\n      PSAlert.alert(\"File already existing, cannot overwrite.\");\n      this.reportName.SetFocus();\n    }\n    return false;\n  }\n  return true;\n}\n\nfunction this_EnablePage1(){\n  return true;\n}\n\nfunction this_EnablePage2(){\n  if (this._enablePage2 == undefined){\n    this._enablePage2 = false;\n  }\n  return this._enablePage2;\n}\n\nfunction this_EnablePage3(){\n  if (this._enablePage3 == undefined){\n    this._enablePage3 = false;\n  }\n  return this._enablePage3;\n}\n\nfunction this_EnablePage4(){\n  if (this._enablePage4 == undefined){\n    this._enablePage4 = false;\n  }\n  return this._enablePage4;\n}\n\nfunction this_EnablePage5(){\n  if (this._enablePage5 == undefined){\n    this._enablePage5 = false;\n  }\n  return this._enablePage5;\n}\n\nfunction this_AfterPageChange(n, oldn){\n  if (n == 1){\n    this.reportName.SetFocus();\n    this.RemoveGenerateOnToolbar();\n    this._enablePage2 = this.validateReport();\n    this._enablePage3 = false;\n    this._enablePage4 = false;\n    this._enablePage5 = false;\n  } else if (n == 2){\n    this.queryName.SetFocus();\n    this.RemoveGenerateOnToolbar();\n    this._enablePage3 = this.validateQueryAndSelection();\n    this._enablePage4 = false;\n    this._enablePage5 = false;\n  } else if (n == 3){\n    this.popolateDataobj(this.MemCurGrH1, this.dataObjGrH1);\n    this.popolateDataobjWTotal(this.MemCurGrF1, this.dataObjGrF1);\n    this.hideTotalField(this.MemCurGrF1, this.gridFieldsF1);\n    this.groupDesc1.SetFocus();\n    this.RemoveGenerateOnToolbar();\n    this._enablePage4 = true;\n    this._enablePage5 = false;\n  } else if (n == 4){\n    this.popolateDataobj(this.MemCurGrH2, this.dataObjGrH2);\n    this.popolateDataobjWTotal(this.MemCurGrF2, this.dataObjGrF2);\n    this.hideTotalField(this.MemCurGrF2, this.gridFieldsF2);\n    this.groupDesc2.SetFocus();\n    this.RemoveGenerateOnToolbar();\n    this._enablePage5 = true;\n  } else if (n == 5){\n    this.popolateDataobj(this.MemCurGrH3, this.dataObjGrH3);\n    this.popolateDataobjWTotal(this.MemCurGrF3, this.dataObjGrF3);\n    this.hideTotalField(this.MemCurGrF3, this.gridFieldsF3);\n    this.groupDesc3.SetFocus();\n    this.AddGenerateOnToolbar();\n  }\n  for (var i = 1; i \u003c= this.nPages; i++){\n    this.EnablePage(i);\n  }\n}\n\nfunction getOpener(){\n  return (window.opener ? window.opener : (window.caller ? window.caller : window.parent));\n}\n\nfunction reportName_onChange(){\n  this._enablePage2 = this.validateReport(true);\n  for (var i = 2; i \u003c= this.nPages; i++){\n    this.EnablePage(i);\n  }\n}\n\nfunction queryName_onChange(){\n  this.TempQueryFields = this.GetQueryFields(this.queryName.Value(), true);\n  \u002f\u002f definisco le colonne\n  var data = \"[\";\n  for (var i = 0; i \u003c this.TempQueryFields[0].length; i++){\n    data = data + \"['\" + LRTrim(this.TempQueryFields[0][i]) + \"',\";\n    data = data + \"'\" + Strtran(LRTrim(this.TempQueryFields[1][i]), \"'\", \" \") + \"'],\";\n  }\n  data = data + \"'t,CC,-1']\";\n  this.TempAllFields = eval(data);\n  \u002f\u002f popolo il DataObj\n  this.dataObjFields.FillExtData(campi, this.TempAllFields);\n  \u002f\u002fsvuota le grid\n  this.dataObjGrH1.FillExtData(campi, this.TempAllFields);\n  this.dataObjGrF1.FillExtData(campiTotal, this.TempAllFields);\n  this.MemCurGrH1.RemoveAll();\n  this.MemCurGrF1.RemoveAll();\n  this.MemCurGrH2.RemoveAll();\n  this.MemCurGrF1.RemoveAll();\n  this.MemCurGrH3.RemoveAll();\n  this.MemCurGrF3.RemoveAll();\n  if (Trim(this.queryName.Value()) != '' && this.TempQueryFields[0].length == 0){\n    PSAlert.alert('Invalid Visual Query.');\n  }\n  this._enablePage3 = false;\n  this.gridFields.AllChecked(false);\n  for (var i = 3; i \u003c= this.nPages; i++){\n    this.EnablePage(i);\n  }\n}\n\nfunction popolateDataobj(memcurs, datasource){\n  while (memcurs.RecCount() \u003e 0){\n    memcurs.Remove(memcurs.RecCount());\n  }\n\n  for (var i = 0; i \u003c campi.length; i++){\n    memcurs.CreateFld(campi[i], \"C\");\n  }\n\n  var data, s;\n  if (this.gridFields.AllChecked()){\n    data = this.TempAllFields;\n  } else {\n    data = this.gridFields.GetSelectedData().Data;\n  }\n  for (var i = 0; i \u003c data.length - 1; i++){\n    s = data[i];\n    memcurs.AppendBlank();\n    memcurs.Set(campi[0], s[0]);\n    memcurs.Set(campi[1], s[1]);\n  }\n  memcurs.InToDatasource(datasource);\n}\n\nfunction hideTotalField(memcurs, datagrid){\n  var col = 2;\n  for (var i = 0; i \u003c memcurs.RecCount(); i++){\n    memcurs.GoTo(i + 1);\n    var pos = LibJavascript.Array.indexOf(this.TempQueryFields[0], memcurs.Get(\"field\"));\n    if (pos \u003e= 0){\n      var type = this.TempQueryFields[2][pos];\n      if (type != \"N\"){\n        var ctrl = Ctrl(datagrid.ctrlid + \"_\" + i + \"_\" + col + \"_input\");\n        if (ctrl){\n          ctrl.style.display = 'none';\n        }\n      }\n    }\n  }\n}\n\nfunction popolateDataobjWTotal(memcurs, datasource){\n  while (memcurs.RecCount() \u003e 0){\n    memcurs.Remove(memcurs.RecCount());\n  }\n\n  for (var i = 0; i \u003c campiTotal.length - 1; i++){\n    memcurs.CreateFld(campiTotal[i], \"C\");\n  }\n  memcurs.CreateFld(campiTotal[campiTotal.length - 1], \"L\");\n\n  var data;\n  if (this.gridFields.AllChecked()){\n    data = this.TempAllFields;\n  } else {\n    data = this.gridFields.GetSelectedData().Data;\n  }\n  for (var i = 0; i \u003c data.length - 1; i++){\n    s = data[i];\n    memcurs.AppendBlank();\n    memcurs.Set(campiTotal[0], s[0]);\n    memcurs.Set(campiTotal[1], s[1]);\n  }\n  memcurs.InToDatasource(datasource);\n}\n\nfunction this_Loaded(){\n  this.reportName.SetFocus();\n  var data = ['t,CC,-1'];\n\n  this.dataObjFields.FillExtData(campi, data);\n  this.dataObjGrH1.FillExtData(campi, data);\n  this.dataObjGrF1.FillExtData(campiTotal, data);\n\n  left = (screen.width) ? (screen.width - width) \u002f 2 : 100;\n  top = (screen.height) ? (screen.height - height - (height \u002f 4)) \u002f 2 : 100;\n\n  if (IsNetscape() || IsMozilla()){\n    width += 5; \u002f\u002fPer Netscape e Mozilla, il width e height sono leggermente diversi\n    height += 4;\n  }\n}\n\nfunction GetQueryFields(queryname, retDesc){\n  var res = [], types = [], len = [], dec = [];\n  if (retDesc == true)\n    var desc = [];\n  var AllField = new JSURL(\"..\u002fservlet\u002fSPVQRProxy?action=fields&filename=\" + queryname, true);\n  AllField = AllField.Response();\n\n  if (Left(AllField, 9) == \"BO_QUERY:\"){\n    AllField = Substr(AllField, 10);\n    var CSV_SEP = \"#!$\";\n    var row, rows = AllField.split(CSV_SEP);\n    for (var i = 0; i \u003c rows.length; i++){\n      row = rows[i].split(\"|\");\n      res.push(row[0]);\n      if (retDesc == true){\n        desc.push(row[2]);\n      }\n      types.push(row[1]);\n      len.push(row[3]);\n      dec.push(row[4]);\n    }\n  } else {\n    var l_oFields = new TrsJavascript();\n    l_oFields.reset();\n    l_oFields.SetRow(0);\n    l_oFields.BuildProperties(AllField);\n    var rows = GetProperty(l_oFields, 'Rows', 'N');\n    for (var i = 0; i \u003c rows; i++){\n      l_oFields.SetRow(i);\n      res.push(GetProperty(l_oFields, 'alias', 'C'));\n      if (retDesc == true){\n        desc.push(GetProperty(l_oFields, 'desc', 'C'));\n      }\n      types.push(GetProperty(l_oFields, 'type', 'C'));\n      len.push(GetProperty(l_oFields, 'len', 'N'));\n      dec.push(GetProperty(l_oFields, 'dec', 'N'));\n    }\n  }\n  return retDesc ? [res, desc, types, len, dec] : [res, types, len, dec];\n}\n\nfunction bPage1EditQuery_Click(){\n  window.open(\"..\u002fvisualquery\u002findex.jsp?filename=\" + this.queryName.Value(), \"Edit_Query\", \"width=800,height=600,scroll=no,status=no,toolbar=no\")\n}\n\nfunction bPage1NewQuery_Click(){\n  window.open(\"..\u002fvisualquery\u002findex.jsp\", \"New_Query\", \"width=800,height=600,scroll=no,status=no,toolbar=no\")\n}\n\nfunction bPage1SelectQuery_Click(){\n  var url = \"..\u002fportalstudio\u002fopen.jsp?tool=visualquery&onetool=true&ExpressionID=\" + URLenc(this.formid + \"_queryName\") + \"&callerFunction=ExpressionBuilderReturn\";\n  if (IsIE() && getInternetExplorerVersion() \u003c= 8){\n    window.open(url, \"visualquery\", \"height=\" + height + \",width=\" + width + \",left=\" + left + \",top=\" + top + \",resizable=yes\");\n  } else {\n    url += \"&visualquery&SPModalLayerId=querySPModalLayer\";\n    openSPModalLayer(url, 100, 50, width, height, true, 1, false);\n  }\n}\n\nfunction groupBuild11_Click(){\n  wizardquery = this.queryName.Value();\n  var url = \"..\u002fportalstudio\u002fexpression_builder.jsp?ExpressionID=\" + URLenc(this.formid + \"_groupBy1\") + \"&callerFunction=ExpressionBuilderReturn&tool=report\";\n  if (IsIE() && getInternetExplorerVersion() \u003c= 8){\n    window.open(url, \"Build_Expression_Group_1\", \"height=\" + height + \",width=\" + width + \",left=\" + left + \",top=\" + top + \",resizable=yes\");\n  } else {\n    url += \"&Build_Expression_Group_1&SPModalLayerId=g1ExpBuildSPModalLayer\";\n    openSPModalLayer(url, 100, 50, width, height, true, 1, false);\n  }\n}\n\nfunction groupBuild21_Click(){\n  wizardquery = this.queryName.Value();\n  var url = \"..\u002fportalstudio\u002fexpression_builder.jsp?ExpressionID=\" + URLenc(this.formid + \"_groupBy2\") + \"&callerFunction=ExpressionBuilderReturn&tool=report\";\n  if (IsIE() && getInternetExplorerVersion() \u003c= 8){\n    window.open(url, \"Build_Expression_Group_2\", \"height=\" + height + \",width=\" + width + \",left=\" + left + \",top=\" + top + \",resizable=yes\");\n  } else {\n    url += \"&Build_Expression_Group_2&SPModalLayerId=g2ExpBuildSPModalLayer\";\n    openSPModalLayer(url, 100, 50, width, height, true, 1, false);\n  }\n}\n\nfunction groupBuild31_Click(){\n  wizardquery = this.queryName.Value();\n  var url = \"..\u002fportalstudio\u002fexpression_builder.jsp?ExpressionID=\" + URLenc(this.formid + \"_groupBy3\") + \"&callerFunction=ExpressionBuilderReturn&tool=report\";\n  if (IsIE() && getInternetExplorerVersion() \u003c= 8){\n    window.open(url, \"Build_Expression_Group_3\", \"height=\" + height + \",width=\" + width + \",left=\" + left + \",top=\" + top + \",resizable=yes\");\n  } else {\n    url += \"&Build_Expression_Group_3&SPModalLayerId=g3ExpBuildSPModalLayer\";\n    openSPModalLayer(url, 100, 50, width, height, true, 1, false);\n  }\n}\n\nfunction reportmodel1_onChange(){\n  this.reportmodel2.Value(!this.reportmodel1.Value())\n}\n\nfunction reportmodel2_onChange(){\n  this.reportmodel1.Value(!this.reportmodel2.Value())\n}\n\nfunction model1img_Click(){\n  this.reportmodel1.Value(true);\n  this.reportmodel2.Value(false);\n  this.boxImage1.Show();\n  this.boxImage2.Hide();\n}\n\nfunction model2img_Click(){\n  this.reportmodel1.Value(false);\n  this.reportmodel2.Value(true);\n  this.boxImage1.Hide();\n  this.boxImage2.Show();\n}\n\nfunction gridFields_SelectionChange(state){\n  this._enablePage3 = this.validateQueryAndSelection();\n  for (var i = 3; i \u003c= this.nPages; i++){\n    this.EnablePage(i);\n  }\n}\n\nfunction gridFields_SelectAllChange(){\n  this._enablePage3 = this.validateQueryAndSelection();\n  for (var i = 3; i \u003c= this.nPages; i++){\n    this.EnablePage(i);\n  }\n}\n\nfunction gridFieldsF1_SelectionChange(state){\n  this.hideTotalField(this.MemCurGrF1, this.gridFieldsF1);\n}\n\nfunction gridFieldsF2_SelectionChange(state){\n  this.hideTotalField(this.MemCurGrF2, this.gridFieldsF2);\n}\n\nfunction gridFieldsF3_SelectionChange(state){\n  this.hideTotalField(this.MemCurGrF3, this.gridFieldsF3);\n}\n\nfunction bSave_Click(){\n  var opener = getOpener();\n  var JsonWizardReport = {\n    type: 'report-wizard'\n  };\n  var JsonGroups = [], data = [], tmpFields = {};\n  var JsonGroup1 = { 'groupName': 'group1' }, JsonGroup2 = { 'groupName': 'group2' }, JsonGroup3 = { 'groupName': 'group3' };\n\n  JsonWizardReport[\"reportTitle\"] = URLenc(Trim(this.reportTitle.Value()));\n  JsonWizardReport[\"reportQuery\"] = Trim(this.queryName.Value());\n  if (this.reportmodel1.Value() == true){\n    JsonWizardReport[\"reportModel\"] = \"modelreportwizard_2\";\n  } else {\n    JsonWizardReport[\"reportModel\"] = \"modelreportwizard_1\";\n  }\n  if (this.gridFields.AllChecked()){\n    JsonWizardReport[\"allFields\"] = \"true\";\n  } else {\n    var reportFields = \"\";\n    data = this.gridFields.mem_curs ? this.gridFields.GetSelectedData().Data : [];\n    JsonWizardReport[\"allFields\"] = \"false\";\n    for (var i = 0; i \u003c data.length - 1; i++){\n      reportFields += data[i][0] + \",\";\n    }\n    JsonWizardReport[\"reportFields\"] = reportFields;\n  }\n  JsonWizardReport[\"fieldsOutputName\"]  = this.radioFieldsOutputName.Value();\n\n  \u002f\u002f Espressioni e descrizione dei gruppi\n  JsonGroup1[\"groupBy\"] = (!Empty(Trim(this.groupBy1.Value())) ? URLenc(Trim(this.groupBy1.Value())) : '1=1');\n  JsonGroup2[\"groupBy\"] = URLenc(Trim(this.groupBy2.Value()));\n  JsonGroup3[\"groupBy\"] = URLenc(Trim(this.groupBy3.Value()));\n  JsonGroup1[\"groupDesc\"] = URLenc(Trim(this.groupDesc1.Value()));\n  JsonGroup2[\"groupDesc\"] = URLenc(Trim(this.groupDesc2.Value()));\n  JsonGroup3[\"groupDesc\"] = URLenc(Trim(this.groupDesc3.Value()));\n\n  \u002f\u002fHeaders\n  data = this.gridFieldsH1.mem_curs ? this.gridFieldsH1.GetSelectedData().Data : [];\n  for (var i = 0; i \u003c data.length - 1; i++){\n    tmpFields[data[i][0]] = \"false\";\n  }\n  JsonGroup1[\"groupHeader\"] = tmpFields;\n  data = [], tmpFields = {};\n  data = this.gridFieldsH2.mem_curs ? this.gridFieldsH2.GetSelectedData().Data : [];\n  for (var i = 0; i \u003c data.length - 1; i++){\n    tmpFields[data[i][0]] = 'false';\n  }\n  JsonGroup2[\"groupHeader\"] = tmpFields;\n  data = [], tmpFields = {};\n  data = this.gridFieldsH3.mem_curs ? this.gridFieldsH3.GetSelectedData().Data : [];\n  for (var i = 0; i \u003c data.length - 1; i++){\n    tmpFields[data[i][0]] = 'false';\n  }\n  JsonGroup3[\"groupHeader\"] = tmpFields;\n\n  \u002f\u002fFooters\n  data = [], tmpFields = {};\n  data = this.gridFieldsF1.mem_curs ? this.gridFieldsF1.GetSelectedData().Data : [];\n  for (var i = 0; i \u003c data.length - 1; i++){\n    tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));\n  }\n  JsonGroup1[\"groupFooter\"] = tmpFields;\n  data = [], tmpFields = {};\n  data = this.gridFieldsF2.mem_curs ? this.gridFieldsF2.GetSelectedData().Data : [];\n  for (var i = 0; i \u003c data.length - 1; i++){\n    tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));\n  }\n  JsonGroup2[\"groupFooter\"] = tmpFields;\n  data = [], tmpFields = {};\n  data = this.gridFieldsF3.mem_curs ? this.gridFieldsF3.GetSelectedData().Data : [];\n  for (var i = 0; i \u003c data.length - 1; i++){\n    tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));\n  }\n  JsonGroup3[\"groupFooter\"] = tmpFields;\n  JsonGroups.push(JsonGroup1);\n  JsonGroups.push(JsonGroup2);\n  JsonGroups.push(JsonGroup3);\n  JsonWizardReport[\"groups\"] = JsonGroups;\n  var serv = new JSURL('..\u002fservlet\u002fspreportwizard?reportName=' + Trim(this.reportName.Value()) + \"&JsonWizardReport=\" + URLenc(JSON.stringify(JsonWizardReport))).Response();\n  if (serv.indexOf('Function return value:true') \u003e= 0){\n    if (opener){\n      if (opener.newCurrentObj){\n        opener.newCurrentObj(Trim(this.reportName.Value()), 'report');\n        if (opener.NavForm) {\n          opener.NavForm();\n        }\n        window.close();\n      } else {\n        window.open(\"..\u002freporteditor\u002findex.jsp?id=\" + Trim(this.reportName.Value()) + \"&custom=false\", '_self');\n      }\n    } else {\n      window.open(\"..\u002freporteditor\u002findex.jsp?id=\" + Trim(this.reportName.Value()) + \"&custom=false\", '_self');\n    }\n  } else {\n    var err = 'RPT_REPORT_WIZARD_ERROR';\n    window.open(\"..\u002fjsp-system\u002fSPReportMaskMessage_portlet.jsp?msgBox=\" + err, '_self')\n  }\n}","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\",\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"image\",\"class_name\":\"image\",\"selector\":\".image\",\"id\":\"form\",\"code\":\".image {\\n  cursor: pointer;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"pad_top\":\"0px\",\"pad_bottom\":\"0px\",\"pad_left\":\"0px\",\"pad_right\":\"0px\",\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"myGridTitle\",\"selector\":\".myGridTitle\",\"id\":\"form\",\"code\":\".myGridTitle {\\n  padding-top: 0px;\\n  padding-right: 0px;\\n  padding-bottom: 0px;\\n  padding-left: 0px;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"border_width\":\"0px\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"myGridRow\",\"selector\":\".myGridRow\",\"id\":\"form\",\"code\":\".myGridRow {\\n  border: 0;\\n}\\n\"}]","description":"Web Report Wizard","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"500","hsl":"","htmlcode":"{{ @radioFieldsOutputName }}\n{{ @lradioFieldsOuptutName }}\n{{ @boxImage2 }}\n{{ @boxImage1 }}\n{{ @labelgr33 }}\n{{ @labelgr23 }}\n{{ @labelgr13 }}\n{{ @model2img }}\n{{ @model1img }}\n{{ @reportmodel2 }}\n{{ @reportmodel1 }}\n{{ @lmodel2 }}\n{{ @lmodel1 }}\n{{ @labelgr32 }}\n{{ @labelgr22 }}\n{{ @labelgr12 }}\n{{ @lreportmodel }}\n{{ @groupBuild31 }}\n{{ @groupBuild21 }}\n{{ @groupBuild11 }}\n{{ @groupBy3 }}\n{{ @groupBy2 }}\n{{ @groupBy1 }}\n{{ @labelgr31 }}\n{{ @labelgr21 }}\n{{ @labelgr11 }}\n{{ @reportTitle }}\n{{ @lgridFields }}\n{{ @lreporttitle }}\n{{ @groupDesc3 }}\n{{ @groupDesc2 }}\n{{ @groupDesc1 }}\n{{ @labelgr30 }}\n{{ @labelgr20 }}\n{{ @labelgr10 }}\n{{ @bPage1NewQuery }}\n{{ @bPage1EditQuery }}\n{{ @bPage1SelectQuery }}\n{{ @reportName }}\n{{ @queryName }}\n{{ @lreportname }}\n{{ @lquery }}\n\n\n\n\n\n\n\n\n\n\n{{ @gridFieldsF3 }}\n{{ @gridFieldsF2 }}\n{{ @gridFieldsF1 }}\n{{ @gridFieldsH3 }}\n{{ @gridFieldsH2 }}\n{{ @gridFieldsH1 }}\n{{ @gridFields }}\n{{ gridFields }}\n{{ gridFieldsH1 }}\n{{ gridFieldsH2 }}\n{{ gridFieldsH3 }}\n{{ gridFieldsF1 }}\n{{ gridFieldsF2 }}\n{{ gridFieldsF3 }}\n{{ dataObjGrH1 }}\n{{ MemCurGrH1 }}\n{{ dataObjGrF1 }}\n{{ groupBynum }}\n{{ MemCurGrF1 }}\n{{ dataObjGrH2 }}\n{{ MemCurGrH2 }}\n{{ dataObjFields }}\n{{ dataObjGrF2 }}\n{{ MemCurGrF2 }}\n{{ dataObjGrH3 }}\n{{ MemCurGrH3 }}\n{{ dataObjGrF3 }}\n{{ MemCurGrF3 }}\n{{ prev6 }}\n{{ next6 }}\n{{ prev2 }}\n{{ prev1 }}\n{{ next2 }}\n{{ prev4 }}\n{{ next1 }}\n{{ next4 }}\n{{ prev5 }}\n{{ next5 }}\n{{ lquery }}\n{{ lreportname }}\n{{ queryName }}\n{{ reportName }}\n{{ bPage1SelectQuery }}\n{{ bPage1EditQuery }}\n{{ bPage1NewQuery }}\n{{ labelgr10 }}\n{{ labelgr20 }}\n{{ labelgr30 }}\n{{ groupDesc1 }}\n{{ groupDesc2 }}\n{{ groupDesc3 }}\n{{ lreporttitle }}\n{{ lquery_Copy }}\n{{ reportTitle }}\n{{ labelgr11 }}\n{{ labelgr21 }}\n{{ labelgr31 }}\n{{ groupBy1 }}\n{{ groupBy2 }}\n{{ groupBy3 }}\n{{ groupBuild11 }}\n{{ groupBuild21 }}\n{{ groupBuild31 }}\n{{ lreportmodel }}\n{{ labelgr12 }}\n{{ labelgr22 }}\n{{ labelgr32 }}\n{{ lmodel1 }}\n{{ lmodel2 }}\n{{ reportmodel1 }}\n{{ reportmodel2 }}\n{{ model1img }}\n{{ model2img }}\n{{ labelgr13 }}\n{{ labelgr23 }}\n{{ labelgr33 }}\n{{ boxImage1 }}\n{{ boxImage2 }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"false","manifest":"","max_w":"","min_w":"","my_library":"json.js,mootools.js,mootools_more.js,controls.js,reporteditor\u002fparserXML.js,spModalLayer.js,SPReportMask.js","offline":"","on_security_failure":"empty","pages_names":"Define Report General Settings,Select Data Source and Fields,Define Group Section 1,Define Group Section 2,Define Group Section 3","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"true","title_url":"","type":"Form","v_line":"","version":"37","w":"1150","wizard":"true"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true-selectAll","checkbox_fields":"field,desc","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Field\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":\"1\",\"ColSpan\":\"1\",\"type\":\"C\",\"field\":\"field\",\"maxwidth\":\"\",\"title\":\"Field\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"200\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"hidden\":false},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\" Description\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":\"1\",\"ColSpan\":\"1\",\"type\":\"C\",\"field\":\"desc\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"grid_row","css_class_row_over":"","css_class_row_selected":"","css_class_title":"myGridTitle","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataObjFields","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"300","hide":"false","hide_default_titles":"false","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridFields","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"2","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"infinite_scroll","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"715","wireframe_props":"colProperties,checkbox,rows","x":"35","y":"179","zindex":"NaN"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true","checkbox_fields":"field","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Field\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"field\",\"maxwidth\":\"\",\"title\":\"Field\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"200\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\" Description\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"desc\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"grid_row","css_class_row_over":"","css_class_row_selected":"","css_class_title":"myGridTitle","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataObjGrH1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"150","hide":"false","hide_default_titles":"false","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridFieldsH1","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"3","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"infinite_scroll","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"659","wireframe_props":"colProperties,checkbox,rows","x":"35","y":"154","zindex":"NaN"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true","checkbox_fields":"field","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Field\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"field\",\"maxwidth\":\"\",\"title\":\"Field\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"200\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\" Description\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"desc\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"grid_row","css_class_row_over":"","css_class_row_selected":"","css_class_title":"myGridTitle","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataObjGrH2","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"150","hide":"false","hide_default_titles":"false","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridFieldsH2","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"4","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"infinite_scroll","sequence":"3","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"659","wireframe_props":"colProperties,checkbox,rows","x":"35","y":"154","zindex":"NaN"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true","checkbox_fields":"field","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Field\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"field\",\"maxwidth\":\"\",\"title\":\"Field\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"200\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\" Description\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"desc\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"grid_row","css_class_row_over":"","css_class_row_selected":"","css_class_title":"myGridTitle","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataObjGrH3","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"150","hide":"false","hide_default_titles":"false","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridFieldsH3","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"5","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"infinite_scroll","sequence":"4","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"659","wireframe_props":"colProperties,checkbox,rows","x":"35","y":"154","zindex":"NaN"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true","checkbox_fields":"field","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Field\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"field\",\"maxwidth\":\"\",\"title\":\"Field\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_weight\":\"\",\"font_family\":\"\",\"font_size\":\"\",\"fixedwidth\":\"200\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"Total\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\" Description\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"desc\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"fg_color\":\"\",\"bg_color\":\"\",\"weight\":\"\",\"link\":\"\",\"ColSpan\":\"0\",\"type\":\"C\",\"maxwidth\":\"\",\"title\":\"Total\",\"enable_HTML\":false,\"extensible\":false,\"alias\":\" Total\",\"width\":\"\",\"align\":\"\",\"layer\":\"\",\"RowSpan\":0,\"field\":\"checkbox:total\",\"picture\":\"\",\"newline\":false,\"orderby_field\":\"\",\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_weight\":\"\",\"font_family\":\"\",\"font_size\":\"11\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"Total\",\"show_extra_title\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"grid_row","css_class_row_over":"","css_class_row_selected":"","css_class_title":"myGridTitle","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataObjGrF1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":",,","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"150","hide":"false","hide_default_titles":"false","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridFieldsF1","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"3","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"infinite_scroll","sequence":"5","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"659","wireframe_props":"colProperties,checkbox,rows","x":"35","y":"340","zindex":"NaN"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true","checkbox_fields":"field","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Field\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"field\",\"maxwidth\":\"\",\"title\":\"Field\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_weight\":\"\",\"font_family\":\"\",\"font_size\":\"\",\"fixedwidth\":\"200\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"Total\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\" Description\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"desc\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"fg_color\":\"\",\"bg_color\":\"\",\"weight\":\"\",\"link\":\"\",\"ColSpan\":\"0\",\"type\":\"C\",\"maxwidth\":\"\",\"title\":\"Total\",\"enable_HTML\":false,\"extensible\":false,\"alias\":\" Total\",\"width\":\"\",\"align\":\"\",\"layer\":\"\",\"RowSpan\":0,\"field\":\"checkbox:total\",\"picture\":\"\",\"newline\":false,\"orderby_field\":\"\",\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_weight\":\"\",\"font_family\":\"\",\"font_size\":\"11\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"Total\",\"show_extra_title\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"grid_row","css_class_row_over":"","css_class_row_selected":"","css_class_title":"myGridTitle","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataObjGrF2","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":",,","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"150","hide":"false","hide_default_titles":"false","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridFieldsF2","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"4","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"infinite_scroll","sequence":"6","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"659","wireframe_props":"colProperties,checkbox,rows","x":"35","y":"340","zindex":"NaN"},{"align":"left","anchor":"","business_obj":"","cellpadding":"1","cellspacing":"1","checkbox":"true","checkbox_fields":"field","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Field\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"field\",\"maxwidth\":\"\",\"title\":\"Field\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_weight\":\"\",\"font_family\":\"\",\"font_size\":\"\",\"fixedwidth\":\"200\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"Total\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\" Description\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"desc\",\"maxwidth\":\"\",\"title\":\"Description\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"fg_color\":\"\",\"bg_color\":\"\",\"weight\":\"\",\"link\":\"\",\"ColSpan\":\"0\",\"type\":\"C\",\"maxwidth\":\"\",\"title\":\"Total\",\"enable_HTML\":false,\"extensible\":false,\"alias\":\" Total\",\"width\":\"\",\"align\":\"\",\"layer\":\"\",\"RowSpan\":0,\"field\":\"checkbox:total\",\"picture\":\"\",\"newline\":false,\"orderby_field\":\"\",\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_weight\":\"\",\"font_family\":\"\",\"font_size\":\"11\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"Total\",\"show_extra_title\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"grid_row","css_class_row_over":"","css_class_row_selected":"","css_class_title":"myGridTitle","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataObjGrF3","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":",,","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"150","hide":"false","hide_default_titles":"false","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"gridFieldsF3","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"5","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"infinite_scroll","sequence":"7","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"659","wireframe_props":"colProperties,checkbox,rows","x":"35","y":"340","zindex":"NaN"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"50","name":"dataObjGrH1","offline":"false","page":"3","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"false","sequence":"8","type":"SQLDataobj","w":"115","x":"1161","y":"-10"},{"auto_create":"","ctrlOfVariant":"","fields":"field,desc","h":"30","name":"MemCurGrH1","page":"3","sequence":"9","type":"MemoryCursor","types":"C,C","w":"115","x":"1161","y":"86"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"50","name":"dataObjGrF1","offline":"false","page":"3","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"false","sequence":"10","type":"SQLDataobj","w":"115","x":"1161","y":"22"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"groupBynum","page":"3","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"numeric","w":"125","x":"1159","y":"-59"},{"auto_create":"","ctrlOfVariant":"","fields":"field,desc,total","h":"30","name":"MemCurGrF1","page":"3","sequence":"12","type":"MemoryCursor","types":"C,C,L","w":"115","x":"1161","y":"54"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"50","name":"dataObjGrH2","offline":"false","page":"4","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"false","sequence":"13","type":"SQLDataobj","w":"109","x":"1160","y":"2"},{"auto_create":"","ctrlOfVariant":"","fields":"field,desc","h":"30","name":"MemCurGrH2","page":"4","sequence":"14","type":"MemoryCursor","types":"C,C","w":"109","x":"1160","y":"68"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"50","name":"dataObjFields","offline":"false","page":"2","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"false","sequence":"15","type":"SQLDataobj","w":"117","x":"1157","y":"1"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"50","name":"dataObjGrF2","offline":"false","page":"4","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"false","sequence":"16","type":"SQLDataobj","w":"109","x":"1160","y":"35"},{"auto_create":"","ctrlOfVariant":"","fields":"field,desc,total","h":"30","name":"MemCurGrF2","page":"4","sequence":"17","type":"MemoryCursor","types":"C,C,L","w":"109","x":"1160","y":"101"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"50","name":"dataObjGrH3","offline":"false","page":"5","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"false","sequence":"18","type":"SQLDataobj","w":"131","x":"1158","y":"2"},{"auto_create":"","ctrlOfVariant":"","fields":"field,desc","h":"30","name":"MemCurGrH3","page":"5","sequence":"19","type":"MemoryCursor","types":"C,C","w":"131","x":"1158","y":"68"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"50","name":"dataObjGrF3","offline":"false","page":"5","parms":"","parms_source":"","query":"","query_async":"false","return_fields_type":"false","sequence":"20","type":"SQLDataobj","w":"131","x":"1158","y":"35"},{"auto_create":"","ctrlOfVariant":"","fields":"field,desc,total","h":"30","name":"MemCurGrF3","page":"5","sequence":"21","type":"MemoryCursor","types":"C,C,L","w":"131","x":"1158","y":"101"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"Specify or define Query","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lquery","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify or define Query","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"18","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"Specify report name","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lreportname","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"23","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Report Name","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"18","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"queryName","page":"2","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"24","spuid":"","tabindex":"6","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"41","zerofilling":"false","zindex":"4"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"reportName","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"25","spuid":"","tabindex":"1","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"41","zerofilling":"false","zindex":"4"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"bPage1SelectQuery","page":"2","sequence":"26","spuid":"","tabindex":"7","type":"Button","type_submit":"false","type_wizard":"","value":"Select","w":"62","wireframe_props":"value","x":"555","y":"41","zindex":"3"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"Trim(this.queryName.Value()) != ''","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"bPage1EditQuery","page":"2","sequence":"27","spuid":"","tabindex":"8","type":"Button","type_submit":"false","type_wizard":"","value":"Edit","w":"62","wireframe_props":"value","x":"621","y":"41","zindex":"3"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"bPage1NewQuery","page":"2","sequence":"28","spuid":"","tabindex":"9","type":"Button","type_submit":"false","type_wizard":"","value":"New","w":"62","wireframe_props":"value","x":"687","y":"41","zindex":"3"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr10","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"29","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Group Description","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"18","zindex":"3"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr20","nowrap":"false","page":"4","picture":"","sanitize":"","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Group Description","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"18","zindex":"3"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr30","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Group Description","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"18","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Specify Group Description","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupDesc1","page":"3","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"32","spuid":"","tabindex":"17","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"42","zerofilling":"false","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Specify Group Description","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupDesc2","page":"4","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"33","spuid":"","tabindex":"17","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"42","zerofilling":"false","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Specify Group Description","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupDesc3","page":"5","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"34","spuid":"","tabindex":"17","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"42","zerofilling":"false","zindex":"3"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"Specify Report Title","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lreporttitle","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"35","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Report Title","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"82","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lgridFields","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"36","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Query Fields for Report","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"157","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"reportTitle","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"37","spuid":"","tabindex":"2","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"105","zerofilling":"false","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr11","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"38","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Group Break Expression","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"74","zindex":"3"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr21","nowrap":"false","page":"4","picture":"","sanitize":"","sanitize_tags":"","sequence":"39","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Group Break Expression","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"74","zindex":"3"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr31","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"40","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Group Break Expression","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"74","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Specify Group Break Expression","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupBy1","page":"3","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"41","spuid":"","tabindex":"18","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"98","zerofilling":"false","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Specify Group Break Expression","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupBy2","page":"4","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"42","spuid":"","tabindex":"18","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"98","zerofilling":"false","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Specify Group Break Expression","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"groupBy3","page":"5","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"43","spuid":"","tabindex":"18","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"508","wireframe_props":"name","x":"35","y":"98","zerofilling":"false","zindex":"3"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"groupBuild11","page":"3","sequence":"44","spuid":"","tabindex":"19","type":"Button","type_submit":"false","type_wizard":"","value":"Build Expression","w":"145","wireframe_props":"value","x":"553","y":"98","zindex":"3"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"groupBuild21","page":"4","sequence":"45","spuid":"","tabindex":"19","type":"Button","type_submit":"false","type_wizard":"","value":"Build Expression","w":"145","wireframe_props":"value","x":"553","y":"98","zindex":"3"},{"anchor":"","bg_color":"","border_color":"","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"groupBuild31","page":"5","sequence":"46","spuid":"","tabindex":"19","type":"Button","type_submit":"false","type_wizard":"","value":"Build Expression","w":"145","wireframe_props":"value","x":"553","y":"98","zindex":"3"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"Specify Report Model","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lreportmodel","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"47","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Specify Report Model","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"146","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr12","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"48","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Group Header Fields","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"130","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr22","nowrap":"false","page":"4","picture":"","sanitize":"","sanitize_tags":"","sequence":"49","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Group Header Fields","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"130","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr32","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"50","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Group Header Fields","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"130","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lmodel1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"51","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"List Model","w":"84","wireframe_props":"align,value,n_col","x":"69","y":"305","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lmodel2","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"52","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Table Model","w":"84","wireframe_props":"align,value,n_col","x":"366","y":"305","zindex":"4"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"13","help_tips":"","hide":"false","hide_undercond":"true","init":"","init_par":"false","label_text":"","layer":"false","layout_steps_values":"{}","name":"reportmodel1","page":"1","sequence":"53","spuid":"","style_type":"","tabindex":"3","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"18","y":"177","zindex":"3"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"13","help_tips":"","hide":"false","hide_undercond":"true","init":"","init_par":"true","label_text":"","layer":"false","layout_steps_values":"{}","name":"reportmodel2","page":"1","sequence":"54","spuid":"","style_type":"","tabindex":"4","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"305","y":"182","zindex":"3"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"100","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"","layer":"false","layout_steps_values":"{}","name":"model1img","page":"1","path_type":"","sequence":"55","server_side":"","spuid":"","src":"..\u002freporteditor\u002fimages\u002freportList.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"110","wireframe_props":"","x":"56","y":"185","zindex":"4"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"100","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"","layer":"false","layout_steps_values":"{}","name":"model2img","page":"1","path_type":"","sequence":"56","server_side":"","spuid":"","src":"..\u002freporteditor\u002fimages\u002freportTable.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"110","wireframe_props":"","x":"353","y":"185","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:alert('1'),javascript:alert('2'),javascript:alert('3')","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr13","nowrap":"false","page":"3","picture":"","sanitize":"","sanitize_tags":"","sequence":"57","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Group Footer Fields and Totals","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"316","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:alert('1'),javascript:alert('2'),javascript:alert('3')","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr23","nowrap":"false","page":"4","picture":"","sanitize":"","sanitize_tags":"","sequence":"58","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Group Footer Fields and Totals","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"316","zindex":"4"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:alert('1'),javascript:alert('2'),javascript:alert('3')","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelgr33","nowrap":"false","page":"5","picture":"","sanitize":"","sanitize_tags":"","sequence":"59","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Group Footer Fields and Totals","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"316","zindex":"4"},{"anchor":"","bg_color":"","border_color":"#555555","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"130","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"boxImage1","page":"1","sequence":"60","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"130","wireframe_props":"","x":"46","y":"173","zindex":"1"},{"anchor":"","bg_color":"","border_color":"#555555","border_weight":"","class_Css":"box","create_undercond":"","ctrlOfVariant":"","h":"130","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"boxImage2","page":"1","sequence":"61","shrinkable":"","spuid":"","stretch":"false","target":"","type":"Box","w":"130","wireframe_props":"","x":"343","y":"173","zindex":"0"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"Select Output Name","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"","name":"lradioFieldsOuptutName","nowrap":"false","page":"2","picture":"","sanitize":"","sanitize_tags":"","sequence":"62","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Select Output Name","w":"508","wireframe_props":"align,value,n_col","x":"35","y":"74","zindex":"4"},{"anchor":"","calculate":"'descr'","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","font":"","font_size":"","h":"48","helptipslist":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"radioFieldsOutputName","orientation":"vertical","page":"2","picture":"","sequence":"63","spuid":"","tabindex":"","textlist":"Use Field Description,Use Fields Alias","type":"Radio","typevar":"character","valuelist":"descr,alias","visible":"true","w":"180","wireframe_props":"","x":"35","y":"96","zindex":"5"}]%>
<%/*Description:Web Report Wizard*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.SPWebReportWizard_container .image{  cursor: pointer;
}
.SPWebReportWizard_container .myGridTitle{
  padding-top: 0px;
  padding-right: 0px;
  padding-bottom: 0px;
  padding-left: 0px;
}
.SPWebReportWizard_container .myGridRow{
  border: 0;
}
.SPWebReportWizard_container {
}
.SPWebReportWizard_portlet{
  position:relative;
  min-width:1150px;
  height:500px;
}
.SPWebReportWizard_portlet[Data-page="1"]{
  height:500px;
  width:1150px;
}
.SPWebReportWizard_portlet[Data-page="2"]{
  height:500px;
  width:1150px;
}
.SPWebReportWizard_portlet[Data-page="3"]{
  height:500px;
  width:1150px;
}
.SPWebReportWizard_portlet[Data-page="4"]{
  height:500px;
  width:1150px;
}
.SPWebReportWizard_portlet[Data-page="5"]{
  height:500px;
  width:1150px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .gridFields_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:179px;
  left:35px;
  width:715px;
  height:300px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .gridFieldsH1_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:154px;
  left:35px;
  width:659px;
  height:150px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .gridFieldsH2_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:154px;
  left:35px;
  width:659px;
  height:150px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .gridFieldsH3_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:154px;
  left:35px;
  width:659px;
  height:150px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .gridFieldsF1_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:340px;
  left:35px;
  width:659px;
  height:150px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .gridFieldsF2_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:340px;
  left:35px;
  width:659px;
  height:150px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .gridFieldsF3_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:340px;
  left:35px;
  width:659px;
  height:150px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lquery_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:18px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lquery_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lquery_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreportname_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:18px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreportname_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreportname_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .queryName_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:41px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .queryName_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .queryName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportName_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:41px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportName_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .bPage1SelectQuery_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:41px;
  left:555px;
  width:62px;
  height:22px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .bPage1SelectQuery_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .bPage1EditQuery_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:41px;
  left:621px;
  width:62px;
  height:22px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .bPage1EditQuery_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .bPage1NewQuery_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:41px;
  left:687px;
  width:62px;
  height:22px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .bPage1NewQuery_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr10_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr10_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr10_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr20_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr20_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr20_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr30_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:18px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr30_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr30_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc1_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:42px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc1_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc2_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:42px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc2_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc3_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:42px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc3_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupDesc3_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreporttitle_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:82px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreporttitle_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreporttitle_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lgridFields_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:157px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lgridFields_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lgridFields_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportTitle_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:105px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportTitle_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportTitle_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr11_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:74px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr11_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr11_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr21_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:74px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr21_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr21_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr31_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:74px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr31_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr31_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy1_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:98px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy1_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy1_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy2_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:98px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy2_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy2_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy3_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:98px;
  left:35px;
  width:508px;
  height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy3_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBy3_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBuild11_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:98px;
  left:553px;
  width:145px;
  height:22px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBuild11_ctrl {
  border-width:1px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBuild21_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:98px;
  left:553px;
  width:145px;
  height:22px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBuild21_ctrl {
  border-width:1px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBuild31_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:98px;
  left:553px;
  width:145px;
  height:22px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .groupBuild31_ctrl {
  border-width:1px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreportmodel_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:146px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreportmodel_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lreportmodel_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr12_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:130px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr12_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr12_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr22_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:130px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr22_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr22_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr32_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:130px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr32_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr32_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lmodel1_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:305px;
  left:69px;
  width:84px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lmodel1_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lmodel1_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lmodel2_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:305px;
  left:366px;
  width:84px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lmodel2_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lmodel2_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportmodel1_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:177px;
  left:18px;
  width:13px;
  height:13px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .reportmodel2_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:182px;
  left:305px;
  width:13px;
  height:13px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .model1img_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:185px;
  left:56px;
  width:110px;
  height:100px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .model1img_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .model1img_ctrl > img{
  width:100%;
  vertical-align:top;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .model2img_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:185px;
  left:353px;
  width:110px;
  height:100px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .model2img_ctrl {
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .model2img_ctrl > img{
  width:100%;
  vertical-align:top;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr13_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:316px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr13_ctrl a {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr13_ctrl a {
  overflow:hidden;
 display:block;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr13_ctrl > div > a:hover{
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr23_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:316px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr23_ctrl a {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr23_ctrl a {
  overflow:hidden;
 display:block;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr23_ctrl > div > a:hover{
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr33_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:316px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr33_ctrl a {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr33_ctrl a {
  overflow:hidden;
 display:block;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .labelgr33_ctrl > div > a:hover{
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:173px;
  left:46px;
  width:130px;
  height:auto;
  min-height:130px;
  display:flex;
  flex-direction:column;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage1_ctrl {
  height:130px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage1_ctrl > .box_content {
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage1_ctrl {
  min-height:130px;
  border-color:#555555;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage2_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:173px;
  left:343px;
  width:130px;
  height:auto;
  min-height:130px;
  display:flex;
  flex-direction:column;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage2_ctrl {
  height:130px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage2_ctrl > .box_content {
  height:100%;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .boxImage2_ctrl {
  min-height:130px;
  border-color:#555555;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lradioFieldsOuptutName_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:74px;
  left:35px;
  width:508px;
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lradioFieldsOuptutName_ctrl {
  height:auto;
  min-height:20px;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .lradioFieldsOuptutName_ctrl {
  overflow:hidden;
}
.SPWebReportWizard_portlet > .SPWebReportWizard_page > .radioFieldsOutputName_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:96px;
  left:35px;
  width:180px;
  height:48px;
  height:auto;
  min-height:48px;
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{},\"pages_names\":\"Define Report General Settings,Select Data Source and Fields,Define Group Section 1,Define Group Section 2,Define Group Section 3\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"1150\",\"wizard\":\"true\"},{\"anchor\":\"\",\"checkbox\":\"true-selectAll\",\"colProperties\":[{\"title\":\"Field\"},{\"title\":\"Description\"}],\"h\":\"300\",\"layout_steps_values\":{},\"page\":\"2\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"715\",\"x\":\"35\",\"y\":\"179\",\"zindex\":\"NaN\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field\"},{\"title\":\"Description\"}],\"h\":\"150\",\"layout_steps_values\":{},\"page\":\"3\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"659\",\"x\":\"35\",\"y\":\"154\",\"zindex\":\"NaN\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field\"},{\"title\":\"Description\"}],\"h\":\"150\",\"layout_steps_values\":{},\"page\":\"4\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"659\",\"x\":\"35\",\"y\":\"154\",\"zindex\":\"NaN\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field\"},{\"title\":\"Description\"}],\"h\":\"150\",\"layout_steps_values\":{},\"page\":\"5\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"659\",\"x\":\"35\",\"y\":\"154\",\"zindex\":\"NaN\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field\"},{\"title\":\"Description\"},{\"isEditable\":true,\"title\":\"Total\"}],\"h\":\"150\",\"layout_steps_values\":{},\"page\":\"3\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"659\",\"x\":\"35\",\"y\":\"340\",\"zindex\":\"NaN\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field\"},{\"title\":\"Description\"},{\"isEditable\":true,\"title\":\"Total\"}],\"h\":\"150\",\"layout_steps_values\":{},\"page\":\"4\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"659\",\"x\":\"35\",\"y\":\"340\",\"zindex\":\"NaN\"},{\"anchor\":\"\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"Field\"},{\"title\":\"Description\"},{\"isEditable\":true,\"title\":\"Total\"}],\"h\":\"150\",\"layout_steps_values\":{},\"page\":\"5\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"659\",\"x\":\"35\",\"y\":\"340\",\"zindex\":\"NaN\"},{\"h\":\"30\",\"page\":\"3\",\"type\":\"SQLDataobj\",\"w\":\"115\",\"x\":\"1161\",\"y\":\"-10\"},{\"h\":\"30\",\"page\":\"3\",\"type\":\"MemoryCursor\",\"w\":\"115\",\"x\":\"1161\",\"y\":\"86\"},{\"h\":\"30\",\"page\":\"3\",\"type\":\"SQLDataobj\",\"w\":\"115\",\"x\":\"1161\",\"y\":\"22\"},{\"h\":\"20\",\"page\":\"3\",\"type\":\"Variable\",\"w\":\"125\",\"x\":\"1159\",\"y\":\"-59\"},{\"h\":\"30\",\"page\":\"3\",\"type\":\"MemoryCursor\",\"w\":\"115\",\"x\":\"1161\",\"y\":\"54\"},{\"h\":\"30\",\"page\":\"4\",\"type\":\"SQLDataobj\",\"w\":\"109\",\"x\":\"1160\",\"y\":\"2\"},{\"h\":\"30\",\"page\":\"4\",\"type\":\"MemoryCursor\",\"w\":\"109\",\"x\":\"1160\",\"y\":\"68\"},{\"h\":\"30\",\"page\":\"2\",\"type\":\"SQLDataobj\",\"w\":\"117\",\"x\":\"1157\",\"y\":\"1\"},{\"h\":\"30\",\"page\":\"4\",\"type\":\"SQLDataobj\",\"w\":\"109\",\"x\":\"1160\",\"y\":\"35\"},{\"h\":\"30\",\"page\":\"4\",\"type\":\"MemoryCursor\",\"w\":\"109\",\"x\":\"1160\",\"y\":\"101\"},{\"h\":\"30\",\"page\":\"5\",\"type\":\"SQLDataobj\",\"w\":\"131\",\"x\":\"1158\",\"y\":\"2\"},{\"h\":\"30\",\"page\":\"5\",\"type\":\"MemoryCursor\",\"w\":\"131\",\"x\":\"1158\",\"y\":\"68\"},{\"h\":\"30\",\"page\":\"5\",\"type\":\"SQLDataobj\",\"w\":\"131\",\"x\":\"1158\",\"y\":\"35\"},{\"h\":\"30\",\"page\":\"5\",\"type\":\"MemoryCursor\",\"w\":\"131\",\"x\":\"1158\",\"y\":\"101\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Specify or define Query\",\"w\":\"508\",\"x\":\"35\",\"y\":\"18\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Specify Report Name\",\"w\":\"508\",\"x\":\"35\",\"y\":\"18\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"queryName\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"41\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"reportName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"41\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"bPage1SelectQuery\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"Select\",\"w\":\"62\",\"x\":\"555\",\"y\":\"41\",\"zindex\":\"3\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"bPage1EditQuery\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"Edit\",\"w\":\"62\",\"x\":\"621\",\"y\":\"41\",\"zindex\":\"3\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"bPage1NewQuery\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"New\",\"w\":\"62\",\"x\":\"687\",\"y\":\"41\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr10\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"Specify Group Description\",\"w\":\"508\",\"x\":\"35\",\"y\":\"18\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr20\",\"page\":\"4\",\"type\":\"Label\",\"value\":\"Specify Group Description\",\"w\":\"508\",\"x\":\"35\",\"y\":\"18\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr30\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"Specify Group Description\",\"w\":\"508\",\"x\":\"35\",\"y\":\"18\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupDesc1\",\"page\":\"3\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"42\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupDesc2\",\"page\":\"4\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"42\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupDesc3\",\"page\":\"5\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"42\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lreporttitle\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Specify Report Title\",\"w\":\"508\",\"x\":\"35\",\"y\":\"82\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lgridFields\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Select Query Fields for Report\",\"w\":\"508\",\"x\":\"35\",\"y\":\"157\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"reportTitle\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"105\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr11\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"Specify Group Break Expression\",\"w\":\"508\",\"x\":\"35\",\"y\":\"74\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr21\",\"page\":\"4\",\"type\":\"Label\",\"value\":\"Specify Group Break Expression\",\"w\":\"508\",\"x\":\"35\",\"y\":\"74\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr31\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"Specify Group Break Expression\",\"w\":\"508\",\"x\":\"35\",\"y\":\"74\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupBy1\",\"page\":\"3\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"98\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupBy2\",\"page\":\"4\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"98\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"groupBy3\",\"page\":\"5\",\"type\":\"Textbox\",\"w\":\"508\",\"x\":\"35\",\"y\":\"98\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"groupBuild11\",\"page\":\"3\",\"type\":\"Button\",\"value\":\"Build Expression\",\"w\":\"145\",\"x\":\"553\",\"y\":\"98\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"groupBuild21\",\"page\":\"4\",\"type\":\"Button\",\"value\":\"Build Expression\",\"w\":\"145\",\"x\":\"553\",\"y\":\"98\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"groupBuild31\",\"page\":\"5\",\"type\":\"Button\",\"value\":\"Build Expression\",\"w\":\"145\",\"x\":\"553\",\"y\":\"98\",\"zindex\":\"3\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lreportmodel\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Specify Report Model\",\"w\":\"508\",\"x\":\"35\",\"y\":\"146\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr12\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"Select Group Header Fields\",\"w\":\"508\",\"x\":\"35\",\"y\":\"130\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr22\",\"page\":\"4\",\"type\":\"Label\",\"value\":\"Select Group Header Fields\",\"w\":\"508\",\"x\":\"35\",\"y\":\"130\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr32\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"Select Group Header Fields\",\"w\":\"508\",\"x\":\"35\",\"y\":\"130\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lmodel1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"List Model\",\"w\":\"84\",\"x\":\"69\",\"y\":\"305\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lmodel2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Table Model\",\"w\":\"84\",\"x\":\"366\",\"y\":\"305\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"reportmodel1\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"18\",\"y\":\"177\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"reportmodel2\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"305\",\"y\":\"182\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"model1img\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"110\",\"x\":\"56\",\"y\":\"185\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"model2img\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"110\",\"x\":\"353\",\"y\":\"185\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr13\",\"page\":\"3\",\"type\":\"Label\",\"value\":\"Select Group Footer Fields and Totals\",\"w\":\"508\",\"x\":\"35\",\"y\":\"316\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr23\",\"page\":\"4\",\"type\":\"Label\",\"value\":\"Select Group Footer Fields and Totals\",\"w\":\"508\",\"x\":\"35\",\"y\":\"316\",\"zindex\":\"4\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelgr33\",\"page\":\"5\",\"type\":\"Label\",\"value\":\"Select Group Footer Fields and Totals\",\"w\":\"508\",\"x\":\"35\",\"y\":\"316\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"130\",\"layout_steps_values\":{},\"name\":\"boxImage1\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"130\",\"x\":\"46\",\"y\":\"173\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"130\",\"layout_steps_values\":{},\"name\":\"boxImage2\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"130\",\"x\":\"343\",\"y\":\"173\",\"zindex\":\"0\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"\",\"name\":\"lradioFieldsOuptutName\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Select Output Name\",\"w\":\"508\",\"x\":\"35\",\"y\":\"74\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"48\",\"layout_steps_values\":{},\"name\":\"radioFieldsOutputName\",\"page\":\"2\",\"type\":\"Radio\",\"w\":\"180\",\"x\":\"35\",\"y\":\"96\",\"zindex\":\"5\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPWebReportWizard","UTF-8")) {return; }
 %><%if(!sp.isLogged()){
if (true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPWebReportWizard_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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

</style>
<script src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("reporteditor/parserXML.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("SPReportMask.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPWebReportWizard','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPWebReportWizard_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%if(request.getAttribute("SPWebReportWizard_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
double groupBynum= 0;
String lquery= "Specify or define Query";
String lreportname= "Specify Report Name";
String queryName= "";
if(request.getAttribute("SPWebReportWizard_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String reportName= "";
String labelgr10= "Specify Group Description";
String labelgr20= "Specify Group Description";
String labelgr30= "Specify Group Description";
String groupDesc1= "";
String groupDesc2= "";
String groupDesc3= "";
String lreporttitle= "Specify Report Title";
String lgridFields= "Select Query Fields for Report";
String reportTitle= "";
String labelgr11= "Specify Group Break Expression";
String labelgr21= "Specify Group Break Expression";
String labelgr31= "Specify Group Break Expression";
String groupBy1= "";
String groupBy2= "";
String groupBy3= "";
String lreportmodel= "Specify Report Model";
String labelgr12= "Select Group Header Fields";
String labelgr22= "Select Group Header Fields";
String labelgr32= "Select Group Header Fields";
String lmodel1= "List Model";
String lmodel2= "Table Model";
boolean reportmodel1=false;
boolean reportmodel2=true;
String labelgr13= "Select Group Footer Fields and Totals";
String labelgr23= "Select Group Footer Fields and Totals";
String labelgr33= "Select Group Footer Fields and Totals";
String lradioFieldsOuptutName= "Select Output Name";
String radioFieldsOutputName= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPWebReportWizard_title_container' style='width:1150px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPWebReportWizard_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPWebReportWizard_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPWebReportWizard','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPWebReportWizard_page' style='display:block'>
<span id='<%=idPortlet%>_lreportname'  formid='<%=idPortlet%>' ps-name='lreportname'    class='label lreportname_ctrl'><div id='<%=idPortlet%>_lreportnametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Report Name"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_reportName_wrp'><input id='<%=idPortlet%>_reportName' name='reportName' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='reportName' /></span>
<span id='<%=idPortlet%>_lreporttitle'  formid='<%=idPortlet%>' ps-name='lreporttitle'    class='label lreporttitle_ctrl'><div id='<%=idPortlet%>_lreporttitletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Report Title"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_reportTitle_wrp'><input id='<%=idPortlet%>_reportTitle' name='reportTitle' type='text' class='textbox' tabindex='2' formid='<%=idPortlet%>' ps-name='reportTitle' /></span>
<span id='<%=idPortlet%>_lreportmodel'  formid='<%=idPortlet%>' ps-name='lreportmodel'    class='label lreportmodel_ctrl'><div id='<%=idPortlet%>_lreportmodeltbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Report Model"))%></div></span>
<span id='<%=idPortlet%>_lmodel1'  formid='<%=idPortlet%>' ps-name='lmodel1'    class='label lmodel1_ctrl'><div id='<%=idPortlet%>_lmodel1tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("List Model"))%></div></span>
<span id='<%=idPortlet%>_lmodel2'  formid='<%=idPortlet%>' ps-name='lmodel2'    class='label lmodel2_ctrl'><div id='<%=idPortlet%>_lmodel2tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Table Model"))%></div></span>
<input id='<%=idPortlet%>_reportmodel1' tabindex=3 name='reportmodel1' class='checkbox' type='checkbox' style='display:none;'/>
<input id='<%=idPortlet%>_reportmodel2' tabindex=4 name='reportmodel2' class='checkbox' type='checkbox' style='display:none;'/>
<div id='<%=idPortlet%>_model1img'>
<img id='<%=idPortlet%>_model1img_img' class='image model1img_ctrl' src="../reporteditor/images/reportList.png" >
</div>
<div id='<%=idPortlet%>_model2img'>
<img id='<%=idPortlet%>_model2img_img' class='image model2img_ctrl' src="../reporteditor/images/reportTable.png" >
</div>
<div id='<%=idPortlet%>_boxImage1' class='boxImage1_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_boxImage1_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_boxImage2' class='boxImage2_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_boxImage2_td' class='box_content'></div>
</div>
</div>
<div id='<%=idPortlet%>_page_2' class='SPWebReportWizard_page' style='display:none'>
<div id='<%=idPortlet%>_gridFields' formid='<%=idPortlet%>' ps-name='gridFields'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_lquery'  formid='<%=idPortlet%>' ps-name='lquery'    class='label lquery_ctrl'><div id='<%=idPortlet%>_lquerytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify or define Query"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_queryName_wrp'><input id='<%=idPortlet%>_queryName' name='queryName' type='text' class='textbox' tabindex='6' formid='<%=idPortlet%>' ps-name='queryName' /></span>
<input id='<%=idPortlet%>_bPage1SelectQuery' type='button' class='button bPage1SelectQuery_ctrl' tabindex='7'/>
<input id='<%=idPortlet%>_bPage1EditQuery' type='button' class='button bPage1EditQuery_ctrl' tabindex='8'/>
<input id='<%=idPortlet%>_bPage1NewQuery' type='button' class='button bPage1NewQuery_ctrl' tabindex='9'/>
<span id='<%=idPortlet%>_lgridFields'  formid='<%=idPortlet%>' ps-name='lgridFields'    class='label lgridFields_ctrl'><div id='<%=idPortlet%>_lgridFieldstbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Select Query Fields for Report"))%></div></span>
<span id='<%=idPortlet%>_lradioFieldsOuptutName'  formid='<%=idPortlet%>' ps-name='lradioFieldsOuptutName'    class='label lradioFieldsOuptutName_ctrl'><div id='<%=idPortlet%>_lradioFieldsOuptutNametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Select Output Name"))%></div></span>
<div id='<%=idPortlet%>_radioFieldsOutputName' class='radio' style='z-index:1;'></div>
</div>
<div id='<%=idPortlet%>_page_3' class='SPWebReportWizard_page' style='display:none'>
<div id='<%=idPortlet%>_gridFieldsH1' formid='<%=idPortlet%>' ps-name='gridFieldsH1'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_gridFieldsF1' formid='<%=idPortlet%>' ps-name='gridFieldsF1'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<span id='<%=idPortlet%>_labelgr10'  formid='<%=idPortlet%>' ps-name='labelgr10'    class='label labelgr10_ctrl'><div id='<%=idPortlet%>_labelgr10tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Group Description"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_groupDesc1_wrp'><input id='<%=idPortlet%>_groupDesc1' name='groupDesc1' type='text' class='textbox' tabindex='17' formid='<%=idPortlet%>' ps-name='groupDesc1' /></span>
<span id='<%=idPortlet%>_labelgr11'  formid='<%=idPortlet%>' ps-name='labelgr11'    class='label labelgr11_ctrl'><div id='<%=idPortlet%>_labelgr11tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Group Break Expression"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_groupBy1_wrp'><input id='<%=idPortlet%>_groupBy1' name='groupBy1' type='text' class='textbox' tabindex='18' formid='<%=idPortlet%>' ps-name='groupBy1' /></span>
<input id='<%=idPortlet%>_groupBuild11' type='button' class='button groupBuild11_ctrl' tabindex='19'/>
<span id='<%=idPortlet%>_labelgr12'  formid='<%=idPortlet%>' ps-name='labelgr12'    class='label labelgr12_ctrl'><div id='<%=idPortlet%>_labelgr12tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Select Group Header Fields"))%></div></span>
<span id='<%=idPortlet%>_labelgr13'  formid='<%=idPortlet%>' ps-name='labelgr13'    class='label labelgr13_ctrl'><div id='<%=idPortlet%>_labelgr13tbl' style='width:100%;'><a id='<%=idPortlet%>_labelgr13href' title='<%=JSPLib.ToHTML(sp.translate("Select Group Footer Fields and Totals"))%>' href='javascript:alert('1'),javascript:alert('2'),javascript:alert('3')'  ><%=JSPLib.ToHTML(sp.translate("Select Group Footer Fields and Totals"))%></a></div></span>
</div>
<div id='<%=idPortlet%>_page_4' class='SPWebReportWizard_page' style='display:none'>
<div id='<%=idPortlet%>_gridFieldsH2' formid='<%=idPortlet%>' ps-name='gridFieldsH2'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_gridFieldsF2' formid='<%=idPortlet%>' ps-name='gridFieldsF2'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<span id='<%=idPortlet%>_labelgr20'  formid='<%=idPortlet%>' ps-name='labelgr20'    class='label labelgr20_ctrl'><div id='<%=idPortlet%>_labelgr20tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Group Description"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_groupDesc2_wrp'><input id='<%=idPortlet%>_groupDesc2' name='groupDesc2' type='text' class='textbox' tabindex='17' formid='<%=idPortlet%>' ps-name='groupDesc2' /></span>
<span id='<%=idPortlet%>_labelgr21'  formid='<%=idPortlet%>' ps-name='labelgr21'    class='label labelgr21_ctrl'><div id='<%=idPortlet%>_labelgr21tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Group Break Expression"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_groupBy2_wrp'><input id='<%=idPortlet%>_groupBy2' name='groupBy2' type='text' class='textbox' tabindex='18' formid='<%=idPortlet%>' ps-name='groupBy2' /></span>
<input id='<%=idPortlet%>_groupBuild21' type='button' class='button groupBuild21_ctrl' tabindex='19'/>
<span id='<%=idPortlet%>_labelgr22'  formid='<%=idPortlet%>' ps-name='labelgr22'    class='label labelgr22_ctrl'><div id='<%=idPortlet%>_labelgr22tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Select Group Header Fields"))%></div></span>
<span id='<%=idPortlet%>_labelgr23'  formid='<%=idPortlet%>' ps-name='labelgr23'    class='label labelgr23_ctrl'><div id='<%=idPortlet%>_labelgr23tbl' style='width:100%;'><a id='<%=idPortlet%>_labelgr23href' title='<%=JSPLib.ToHTML(sp.translate("Select Group Footer Fields and Totals"))%>' href='javascript:alert('1'),javascript:alert('2'),javascript:alert('3')'  ><%=JSPLib.ToHTML(sp.translate("Select Group Footer Fields and Totals"))%></a></div></span>
</div>
<div id='<%=idPortlet%>_page_5' class='SPWebReportWizard_page' style='display:none'>
<div id='<%=idPortlet%>_gridFieldsH3' formid='<%=idPortlet%>' ps-name='gridFieldsH3'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_gridFieldsF3' formid='<%=idPortlet%>' ps-name='gridFieldsF3'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<span id='<%=idPortlet%>_labelgr30'  formid='<%=idPortlet%>' ps-name='labelgr30'    class='label labelgr30_ctrl'><div id='<%=idPortlet%>_labelgr30tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Group Description"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_groupDesc3_wrp'><input id='<%=idPortlet%>_groupDesc3' name='groupDesc3' type='text' class='textbox' tabindex='17' formid='<%=idPortlet%>' ps-name='groupDesc3' /></span>
<span id='<%=idPortlet%>_labelgr31'  formid='<%=idPortlet%>' ps-name='labelgr31'    class='label labelgr31_ctrl'><div id='<%=idPortlet%>_labelgr31tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Specify Group Break Expression"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_groupBy3_wrp'><input id='<%=idPortlet%>_groupBy3' name='groupBy3' type='text' class='textbox' tabindex='18' formid='<%=idPortlet%>' ps-name='groupBy3' /></span>
<input id='<%=idPortlet%>_groupBuild31' type='button' class='button groupBuild31_ctrl' tabindex='19'/>
<span id='<%=idPortlet%>_labelgr32'  formid='<%=idPortlet%>' ps-name='labelgr32'    class='label labelgr32_ctrl'><div id='<%=idPortlet%>_labelgr32tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Select Group Header Fields"))%></div></span>
<span id='<%=idPortlet%>_labelgr33'  formid='<%=idPortlet%>' ps-name='labelgr33'    class='label labelgr33_ctrl'><div id='<%=idPortlet%>_labelgr33tbl' style='width:100%;'><a id='<%=idPortlet%>_labelgr33href' title='<%=JSPLib.ToHTML(sp.translate("Select Group Footer Fields and Totals"))%>' href='javascript:alert('1'),javascript:alert('2'),javascript:alert('3')'  ><%=JSPLib.ToHTML(sp.translate("Select Group Footer Fields and Totals"))%></a></div></span>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPWebReportWizard');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_CANCEL",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_CANCEL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_GENERATE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_GENERATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CHANGE_MARK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CHANGE_MARK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_INSERT_2ND_OP",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_INSERT_2ND_OP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPWebReportWizard_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:true, tabstrip_class: ''});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Define Report General Settings"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Select Data Source and Fields"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page3', element:'<%=idPortlet%>_page_3',caption:'<%=JSPLib.ToJSValue(sp.translate("Define Group Section 1"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page4', element:'<%=idPortlet%>_page_4',caption:'<%=JSPLib.ToJSValue(sp.translate("Define Group Section 2"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page5', element:'<%=idPortlet%>_page_5',caption:'<%=JSPLib.ToJSValue(sp.translate("Define Group Section 3"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPWebReportWizard',["1150"],["500"],'portlet',<%=sp.isOfflineInstallation()%>,true,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},true,false,5,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1150","h":"500","title":"Define Report General Settings","layer":"false","npage":"1"},{"layout_steps_values":{},"w":"1150","h":"500","title":"Select Data Source and Fields","layer":"false","npage":"2"},{"layout_steps_values":{},"w":"1150","h":"500","title":"Define Group Section 1","layer":"false","npage":"3"},{"layout_steps_values":{},"w":"1150","h":"500","title":"Define Group Section 2","layer":"false","npage":"4"},{"layout_steps_values":{},"w":"1150","h":"500","title":"Define Group Section 3","layer":"false","npage":"5"}]);
this.gridFields=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true-selectAll","checkbox_fields":"field,desc","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_row","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"myGridTitle","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridFields","dataobj":"dataObjFields","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":300,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"false","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridFields","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":2,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":715,"x":35,"y":179,"zindex":"NaN"});
this.gridFields.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","hidden":false,"col_class":"","font_size":"","link":"","fixedwidth":"200","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Field"),false,true)%>","align":"","layer":"","ColSpan":"1","newline":false,"alias":"Field","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"field","droppable_name":"","fg_color":"","width":"","RowSpan":"1","font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Description"),false,true)%>","align":"","layer":"","ColSpan":"1","newline":false,"alias":" Description","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desc","droppable_name":"","fg_color":"","width":"","RowSpan":"1","font_family":""}]});
this.gridFieldsH1=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true","checkbox_fields":"field","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_row","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"myGridTitle","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridFieldsH1","dataobj":"dataObjGrH1","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridFieldsH1","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":3,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":659,"x":35,"y":154,"zindex":"NaN"});
this.gridFieldsH1.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"200","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Field"),false,true)%>","align":"","layer":"","ColSpan":0,"newline":false,"alias":"Field","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"field","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Description"),false,true)%>","align":"","layer":"","ColSpan":0,"newline":false,"alias":" Description","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desc","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.gridFieldsH2=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true","checkbox_fields":"field","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_row","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"myGridTitle","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridFieldsH2","dataobj":"dataObjGrH2","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridFieldsH2","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":4,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":659,"x":35,"y":154,"zindex":"NaN"});
this.gridFieldsH2.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"200","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Field"),false,true)%>","align":"","layer":"","ColSpan":0,"newline":false,"alias":"Field","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"field","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Description"),false,true)%>","align":"","layer":"","ColSpan":0,"newline":false,"alias":" Description","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desc","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.gridFieldsH3=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true","checkbox_fields":"field","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_row","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"myGridTitle","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridFieldsH3","dataobj":"dataObjGrH3","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridFieldsH3","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":5,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":659,"x":35,"y":154,"zindex":"NaN"});
this.gridFieldsH3.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"200","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Field"),false,true)%>","align":"","layer":"","ColSpan":0,"newline":false,"alias":"Field","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"field","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Description"),false,true)%>","align":"","layer":"","ColSpan":0,"newline":false,"alias":" Description","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desc","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.gridFieldsF1=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true","checkbox_fields":"field","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_row","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"myGridTitle","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridFieldsF1","dataobj":"dataObjGrF1","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridFieldsF1","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":3,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":659,"x":35,"y":340,"zindex":"NaN"});
this.gridFieldsF1.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"200","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Field"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"Field","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","droppable":false,"bg_color":"","field":"field","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Description"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":" Description","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desc","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"11","link":"","fixedwidth":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","align":"","ColSpan":"0","layer":"","newline":false,"isEditable":true,"alias":" Total","extensible":false,"title_align":"","show_extra_title":false,"enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","droppable":false,"bg_color":"","field":"checkbox:total","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
PrepareJsCalendar(false);
this.gridFieldsF2=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true","checkbox_fields":"field","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_row","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"myGridTitle","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridFieldsF2","dataobj":"dataObjGrF2","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridFieldsF2","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":4,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":659,"x":35,"y":340,"zindex":"NaN"});
this.gridFieldsF2.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"200","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Field"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"Field","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","droppable":false,"bg_color":"","field":"field","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Description"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":" Description","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desc","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"11","link":"","fixedwidth":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","align":"","ColSpan":"0","layer":"","newline":false,"isEditable":true,"alias":" Total","extensible":false,"title_align":"","show_extra_title":false,"enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","droppable":false,"bg_color":"","field":"checkbox:total","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
PrepareJsCalendar(false);
this.gridFieldsF3=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":1,"cellspacing":1,"checkbox":"true","checkbox_fields":"field","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_row","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"myGridTitle","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridFieldsF3","dataobj":"dataObjGrF3","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":150,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"gridFieldsF3","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":false,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":5,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":659,"x":35,"y":340,"zindex":"NaN"});
this.gridFieldsF3.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"200","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Field"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"Field","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","droppable":false,"bg_color":"","field":"field","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Description"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":" Description","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desc","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"11","link":"","fixedwidth":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","align":"","ColSpan":"0","layer":"","newline":false,"isEditable":true,"alias":" Total","extensible":false,"title_align":"","show_extra_title":false,"enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"<%=JSPLib.ToJSValue(sp.translate("Total"),false,true)%>","droppable":false,"bg_color":"","field":"checkbox:total","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
PrepareJsCalendar(false);
this.dataObjGrH1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataObjGrH1","decrypted_parms":"","encrypted_fields":"","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataObjGrH1","nrows":"50","page":3,"parms":"","parms_source":"","type":"SQLDataobj","w":115,"x":1161,"y":-10});
this.MemCurGrH1=new ZtVWeb.MemoryCursorCtrl(this,'MemCurGrH1','<%=idPortlet%>_MemCurGrH1','field,desc','C,C','','field,desc','false');
this.dataObjGrF1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataObjGrF1","decrypted_parms":"","encrypted_fields":"","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataObjGrF1","nrows":"50","page":3,"parms":"","parms_source":"","type":"SQLDataobj","w":115,"x":1161,"y":22});
this.groupBynum=new ZtVWeb._VC(this,'groupBynum',null,'numeric',<%=groupBynum%>,false,false);
this.MemCurGrF1=new ZtVWeb.MemoryCursorCtrl(this,'MemCurGrF1','<%=idPortlet%>_MemCurGrF1','field,desc,total','C,C,L','','field,desc,total','false');
this.dataObjGrH2=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataObjGrH2","decrypted_parms":"","encrypted_fields":"","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataObjGrH2","nrows":"50","page":4,"parms":"","parms_source":"","type":"SQLDataobj","w":109,"x":1160,"y":2});
this.MemCurGrH2=new ZtVWeb.MemoryCursorCtrl(this,'MemCurGrH2','<%=idPortlet%>_MemCurGrH2','field,desc','C,C','','field,desc','false');
this.dataObjFields=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataObjFields","decrypted_parms":"","encrypted_fields":"","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataObjFields","nrows":"50","page":2,"parms":"","parms_source":"","type":"SQLDataobj","w":117,"x":1157,"y":1});
this.dataObjGrF2=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataObjGrF2","decrypted_parms":"","encrypted_fields":"","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataObjGrF2","nrows":"50","page":4,"parms":"","parms_source":"","type":"SQLDataobj","w":109,"x":1160,"y":35});
this.MemCurGrF2=new ZtVWeb.MemoryCursorCtrl(this,'MemCurGrF2','<%=idPortlet%>_MemCurGrF2','field,desc,total','C,C,L','','field,desc,total','false');
this.dataObjGrH3=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataObjGrH3","decrypted_parms":"","encrypted_fields":"","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataObjGrH3","nrows":"50","page":5,"parms":"","parms_source":"","type":"SQLDataobj","w":131,"x":1158,"y":2});
this.MemCurGrH3=new ZtVWeb.MemoryCursorCtrl(this,'MemCurGrH3','<%=idPortlet%>_MemCurGrH3','field,desc','C,C','','field,desc','false');
this.dataObjGrF3=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"","cmdHash":"<%=JSPLib.cmdHash("",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataObjGrF3","decrypted_parms":"","encrypted_fields":"","fieldstype":"false","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataObjGrF3","nrows":"50","page":5,"parms":"","parms_source":"","type":"SQLDataobj","w":131,"x":1158,"y":35});
this.MemCurGrF3=new ZtVWeb.MemoryCursorCtrl(this,'MemCurGrF3','<%=idPortlet%>_MemCurGrF3','field,desc,total','C,C,L','','field,desc,total','false');
this.lquery=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lquery","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify or define Query"),false,true)%>","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lquery","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lquery),false,true)%>","type":"Label","w":508,"x":35,"y":18,"zindex":"4"});
this.lreportname=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lreportname","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify report name"),false,true)%>","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lreportname","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lreportname),false,true)%>","type":"Label","w":508,"x":35,"y":18,"zindex":"4"});
this.queryName=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_queryName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"queryName","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(queryName,false,true)%>","w":508,"x":35,"y":41,"zerofilling":false,"zindex":"4","zoom":""});
this.reportName=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_reportName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"reportName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(reportName,false,true)%>","w":508,"x":35,"y":41,"zerofilling":false,"zindex":"4","zoom":""});
this.bPage1SelectQuery=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button bPage1SelectQuery_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_bPage1SelectQuery","edit_undercond":"","font":"","font_color":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"bPage1SelectQuery","page":2,"spuid":"","tabindex":"7","text":"<%=JSPLib.ToJSValue(sp.translate("Select"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":62,"x":555,"y":41,"zindex":"3"});
this.bPage1EditQuery=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button bPage1EditQuery_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_bPage1EditQuery","edit_undercond":"Trim(this.queryName.Value()) != ''","font":"","font_color":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"bPage1EditQuery","page":2,"spuid":"","tabindex":"8","text":"<%=JSPLib.ToJSValue(sp.translate("Edit"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":62,"x":621,"y":41,"zindex":"3"});
this.bPage1NewQuery=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button bPage1NewQuery_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_bPage1NewQuery","edit_undercond":"","font":"","font_color":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"bPage1NewQuery","page":2,"spuid":"","tabindex":"9","text":"<%=JSPLib.ToJSValue(sp.translate("New"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":62,"x":687,"y":41,"zindex":"3"});
this.labelgr10=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr10","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr10","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr10),false,true)%>","type":"Label","w":508,"x":35,"y":18,"zindex":"3"});
this.labelgr20=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr20","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr20","nowrap":"false","page":4,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr20),false,true)%>","type":"Label","w":508,"x":35,"y":18,"zindex":"3"});
this.labelgr30=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr30","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr30","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr30),false,true)%>","type":"Label","w":508,"x":35,"y":18,"zindex":"3"});
this.groupDesc1=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupDesc1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Group Description"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupDesc1","page":3,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupDesc1,false,true)%>","w":508,"x":35,"y":42,"zerofilling":false,"zindex":"3","zoom":""});
this.groupDesc2=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupDesc2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Group Description"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupDesc2","page":4,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupDesc2,false,true)%>","w":508,"x":35,"y":42,"zerofilling":false,"zindex":"3","zoom":""});
this.groupDesc3=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupDesc3","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Group Description"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupDesc3","page":5,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupDesc3,false,true)%>","w":508,"x":35,"y":42,"zerofilling":false,"zindex":"3","zoom":""});
this.lreporttitle=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lreporttitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Report Title"),false,true)%>","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lreporttitle","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lreporttitle),false,true)%>","type":"Label","w":508,"x":35,"y":82,"zindex":"4"});
this.lgridFields=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lgridFields","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lgridFields","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lgridFields),false,true)%>","type":"Label","w":508,"x":35,"y":157,"zindex":"4"});
this.reportTitle=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_reportTitle","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"reportTitle","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(reportTitle,false,true)%>","w":508,"x":35,"y":105,"zerofilling":false,"zindex":"4","zoom":""});
this.labelgr11=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr11","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr11","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr11),false,true)%>","type":"Label","w":508,"x":35,"y":74,"zindex":"3"});
this.labelgr21=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr21","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr21","nowrap":"false","page":4,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr21),false,true)%>","type":"Label","w":508,"x":35,"y":74,"zindex":"3"});
this.labelgr31=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr31","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr31","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr31),false,true)%>","type":"Label","w":508,"x":35,"y":74,"zindex":"3"});
this.groupBy1=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupBy1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Group Break Expression"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupBy1","page":3,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupBy1,false,true)%>","w":508,"x":35,"y":98,"zerofilling":false,"zindex":"3","zoom":""});
this.groupBy2=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupBy2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Group Break Expression"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupBy2","page":4,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupBy2,false,true)%>","w":508,"x":35,"y":98,"zerofilling":false,"zindex":"3","zoom":""});
this.groupBy3=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_groupBy3","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Group Break Expression"),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"groupBy3","page":5,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(groupBy3,false,true)%>","w":508,"x":35,"y":98,"zerofilling":false,"zindex":"3","zoom":""});
this.groupBuild11=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button groupBuild11_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_groupBuild11","edit_undercond":"","font":"","font_color":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"groupBuild11","page":3,"spuid":"","tabindex":"19","text":"<%=JSPLib.ToJSValue(sp.translate("Build Expression"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":145,"x":553,"y":98,"zindex":"3"});
this.groupBuild21=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button groupBuild21_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_groupBuild21","edit_undercond":"","font":"","font_color":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"groupBuild21","page":4,"spuid":"","tabindex":"19","text":"<%=JSPLib.ToJSValue(sp.translate("Build Expression"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":145,"x":553,"y":98,"zindex":"3"});
this.groupBuild31=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"1","class_Css":"button groupBuild31_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_groupBuild31","edit_undercond":"","font":"","font_color":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"groupBuild31","page":5,"spuid":"","tabindex":"19","text":"<%=JSPLib.ToJSValue(sp.translate("Build Expression"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":145,"x":553,"y":98,"zindex":"3"});
this.lreportmodel=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lreportmodel","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("Specify Report Model"),false,true)%>","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lreportmodel","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lreportmodel),false,true)%>","type":"Label","w":508,"x":35,"y":146,"zindex":"4"});
this.labelgr12=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr12","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr12),false,true)%>","type":"Label","w":508,"x":35,"y":130,"zindex":"4"});
this.labelgr22=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr22","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr22","nowrap":"false","page":4,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr22),false,true)%>","type":"Label","w":508,"x":35,"y":130,"zindex":"4"});
this.labelgr32=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr32","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr32","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr32),false,true)%>","type":"Label","w":508,"x":35,"y":130,"zindex":"4"});
this.lmodel1=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lmodel1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lmodel1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lmodel1),false,true)%>","type":"Label","w":84,"x":69,"y":305,"zindex":"4"});
this.lmodel2=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lmodel2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lmodel2","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lmodel2),false,true)%>","type":"Label","w":84,"x":366,"y":305,"zindex":"4"});
this.reportmodel1=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_reportmodel1","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"reportmodel1","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"3","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":18,"y":177,"zindex":"3"});
this.reportmodel1.Value(<%=reportmodel1%>);
this.reportmodel2=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_reportmodel2","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"true","init":"","init_par":"true","label_text":"","layer":false,"layout_steps_values":{},"name":"reportmodel2","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"4","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":305,"y":182,"zindex":"3"});
this.reportmodel2.Value(<%=reportmodel2%>);
this.model1img=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image model1img_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_model1img","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":100,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"","layer":false,"layout_steps_values":{},"name":"model1img","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002freporteditor\u002fimages\u002freportList.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":110,"x":56,"y":185,"zindex":"4"});
this.model2img=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image model2img_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_model2img","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":100,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"","layer":false,"layout_steps_values":{},"name":"model2img","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002freporteditor\u002fimages\u002freportTable.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":110,"x":353,"y":185,"zindex":"4"});
this.labelgr13=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr13","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:alert('1'),javascript:alert('2'),javascript:alert('3')","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr13","nowrap":"false","page":3,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr13),false,true)%>","type":"Label","w":508,"x":35,"y":316,"zindex":"4"});
this.labelgr23=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr23","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:alert('1'),javascript:alert('2'),javascript:alert('3')","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr23","nowrap":"false","page":4,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr23),false,true)%>","type":"Label","w":508,"x":35,"y":316,"zindex":"4"});
this.labelgr33=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelgr33","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:alert('1'),javascript:alert('2'),javascript:alert('3')","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelgr33","nowrap":"false","page":5,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelgr33),false,true)%>","type":"Label","w":508,"x":35,"y":316,"zindex":"4"});
this.boxImage1=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#555555","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_boxImage1","groupName":"","h":130,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"boxImage1","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":130,"x":46,"y":173,"zindex":"1"});
this.boxImage2=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#555555","border_weight":"","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_boxImage2","groupName":"","h":130,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"boxImage2","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","titled":"false","type":"Box","w":130,"x":343,"y":173,"zindex":"0"});
this.lradioFieldsOuptutName=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lradioFieldsOuptutName","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("Select Output Name"),false,true)%>","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lradioFieldsOuptutName","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lradioFieldsOuptutName),false,true)%>","type":"Label","w":508,"x":35,"y":74,"zindex":"4"});
this.radioFieldsOutputName=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"'descr'","captionsList":"<%=JSPLib.ToJSValue(sp.translate("Use Field Description"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Use Fields Alias"),false,true)%>","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_radioFieldsOutputName","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":48,"helptipsList":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"radioFieldsOutputName","orientation":"vertical","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"descr,alias","visible":true,"w":180,"x":35,"y":96,"zindex":"5"});
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
<%request.setAttribute("SPWebReportWizard_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPWebReportWizard_Static=function(){
if(typeof AddGenerateOnToolbar !='undefined')this.AddGenerateOnToolbar=AddGenerateOnToolbar;
if(typeof RemoveGenerateOnToolbar !='undefined')this.RemoveGenerateOnToolbar=RemoveGenerateOnToolbar;
if(typeof validateQueryAndSelection !='undefined')this.validateQueryAndSelection=validateQueryAndSelection;
if(typeof validateReport !='undefined')this.validateReport=validateReport;
if(typeof this_EnablePage1 !='undefined')this.this_EnablePage1=this_EnablePage1;
if(typeof this_EnablePage2 !='undefined')this.this_EnablePage2=this_EnablePage2;
if(typeof this_EnablePage3 !='undefined')this.this_EnablePage3=this_EnablePage3;
if(typeof this_EnablePage4 !='undefined')this.this_EnablePage4=this_EnablePage4;
if(typeof this_EnablePage5 !='undefined')this.this_EnablePage5=this_EnablePage5;
if(typeof this_AfterPageChange !='undefined')this.this_AfterPageChange=this_AfterPageChange;
if(typeof getOpener !='undefined')this.getOpener=getOpener;
if(typeof reportName_onChange !='undefined')this.reportName_onChange=reportName_onChange;
if(typeof queryName_onChange !='undefined')this.queryName_onChange=queryName_onChange;
if(typeof popolateDataobj !='undefined')this.popolateDataobj=popolateDataobj;
if(typeof hideTotalField !='undefined')this.hideTotalField=hideTotalField;
if(typeof popolateDataobjWTotal !='undefined')this.popolateDataobjWTotal=popolateDataobjWTotal;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof GetQueryFields !='undefined')this.GetQueryFields=GetQueryFields;
if(typeof bPage1EditQuery_Click !='undefined')this.bPage1EditQuery_Click=bPage1EditQuery_Click;
if(typeof bPage1NewQuery_Click !='undefined')this.bPage1NewQuery_Click=bPage1NewQuery_Click;
if(typeof bPage1SelectQuery_Click !='undefined')this.bPage1SelectQuery_Click=bPage1SelectQuery_Click;
if(typeof groupBuild11_Click !='undefined')this.groupBuild11_Click=groupBuild11_Click;
if(typeof groupBuild21_Click !='undefined')this.groupBuild21_Click=groupBuild21_Click;
if(typeof groupBuild31_Click !='undefined')this.groupBuild31_Click=groupBuild31_Click;
if(typeof reportmodel1_onChange !='undefined')this.reportmodel1_onChange=reportmodel1_onChange;
if(typeof reportmodel2_onChange !='undefined')this.reportmodel2_onChange=reportmodel2_onChange;
if(typeof model1img_Click !='undefined')this.model1img_Click=model1img_Click;
if(typeof model2img_Click !='undefined')this.model2img_Click=model2img_Click;
if(typeof gridFields_SelectionChange !='undefined')this.gridFields_SelectionChange=gridFields_SelectionChange;
if(typeof gridFields_SelectAllChange !='undefined')this.gridFields_SelectAllChange=gridFields_SelectAllChange;
if(typeof gridFieldsF1_SelectionChange !='undefined')this.gridFieldsF1_SelectionChange=gridFieldsF1_SelectionChange;
if(typeof gridFieldsF2_SelectionChange !='undefined')this.gridFieldsF2_SelectionChange=gridFieldsF2_SelectionChange;
if(typeof gridFieldsF3_SelectionChange !='undefined')this.gridFieldsF3_SelectionChange=gridFieldsF3_SelectionChange;
if(typeof bSave_Click !='undefined')this.bSave_Click=bSave_Click;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
  this.EnablePage(3);
  this.EnablePage(4);
  this.EnablePage(5);
}
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(true,this.reportmodel1);
ZtVWeb.HideCtrl(true,this.reportmodel2);
}
this.this_EditUnderCondition=function(){
ZtVWeb.EditCtrl(Ne(Trim(this.queryName.Value()),''),this.bPage1EditQuery);
}
ZtVWeb.InitCtrl('descr',this.radioFieldsOutputName);
this.EnablePage(1);
this.EnablePage(2);
this.EnablePage(3);
this.EnablePage(4);
this.EnablePage(5);
this.dataObjFields.addRowConsumer(this.gridFields);
this.dataObjGrH1.addRowConsumer(this.gridFieldsH1);
this.dataObjGrH2.addRowConsumer(this.gridFieldsH2);
this.dataObjGrH3.addRowConsumer(this.gridFieldsH3);
this.dataObjGrF1.addRowConsumer(this.gridFieldsF1);
this.dataObjGrF2.addRowConsumer(this.gridFieldsF2);
this.dataObjGrF3.addRowConsumer(this.gridFieldsF3);
PSAlert.init(window, '');
var campi = ['field', 'desc'];
var campiTotal = ['field', 'desc', 'total'];
var tabstrip = eval(this.formid + "_tabstrip");
var height = 400, width = 600;
var left = 100, top = 100;
this.boxImage1.Hide();
this.TempAllFields = null;
this.TempQueryFields = null;
var customToolbarPortlet = this.getTitlePortlet();
if (customToolbarPortlet.title) {
  customToolbarPortlet.title.Value("WebReport" + " <span class='SPPortalZoom_currentversion'>" + "Wizard" + "</span>");
}
if ( customToolbarPortlet.AppendButton ) {
  //customToolbarPortlet.toolbar.Append({
  customToolbarPortlet.AppendButton({
    id: "tbcancel",
    title: FormatMsg("ADMIN_CANCEL"),
    tooltip: FormatMsg("ADMIN_CANCEL"),
    action: "javascript:window.close()",
    image: GetStyleVariable("smartReportDiscardImage", '<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>'),
    target: ""
  });
}
function AddGenerateOnToolbar(){
  //var toolb = this.getTitlePortlet().toolbar;
  var act = "javascript:window." + this.formid + ".bSave_Click()";
  //toolb.Append({
	if ( customToolbarPortlet.AppendButton ) {
    customToolbarPortlet.AppendButton({
      id: "tbgenerate",
      title: FormatMsg("ADMIN_GENERATE"),
      tooltip: FormatMsg("ADMIN_GENERATE"),
      action: act,
      image: GetStyleVariable("smartReportGenerateImage", '../images/custom_toolbar/ok.png'),
      target: ""
    });
  }
}
function RemoveGenerateOnToolbar(){
  
	if ( customToolbarPortlet.RemoveButton ) {
    customToolbarPortlet.RemoveButton("tbgenerate");
  }
}
function validateQueryAndSelection(){
  var dataSelected = this.gridFields.AllChecked() || this.gridFields.GetSelectedData().Data.length > 1;
  if (dataSelected && !Empty(this.queryName.Value()) && this.TempQueryFields != null && this.TempQueryFields[0] && this.TempQueryFields[0].length > 0){
    return true;
  }
  return false;
}
function validateReport(withAlert){
  if (Empty(Trim(this.reportName.Value()))){
    return false;
  } else if (!(/^[a-zA-Z][A-Za-z0-9-_]*$/.test(this.reportName.Value()))){
    if (withAlert == true){
      PSAlert.alert('Invalid report file name...');
    }
    return false;
  }
  var url = new JSURL("../servlet/JSPReader?type=webreport&name=" + Trim(this.reportName.Value()) + "&check=true", true);
  var output = url.Response();
  if (output == "found"){
    if (withAlert == true){
      PSAlert.alert("File already existing, cannot overwrite.");
      this.reportName.SetFocus();
    }
    return false;
  }
  return true;
}
function this_EnablePage1(){
  return true;
}
function this_EnablePage2(){
  if (this._enablePage2 == undefined){
    this._enablePage2 = false;
  }
  return this._enablePage2;
}
function this_EnablePage3(){
  if (this._enablePage3 == undefined){
    this._enablePage3 = false;
  }
  return this._enablePage3;
}
function this_EnablePage4(){
  if (this._enablePage4 == undefined){
    this._enablePage4 = false;
  }
  return this._enablePage4;
}
function this_EnablePage5(){
  if (this._enablePage5 == undefined){
    this._enablePage5 = false;
  }
  return this._enablePage5;
}
function this_AfterPageChange(n, oldn){
  if (n == 1){
    this.reportName.SetFocus();
    this.RemoveGenerateOnToolbar();
    this._enablePage2 = this.validateReport();
    this._enablePage3 = false;
    this._enablePage4 = false;
    this._enablePage5 = false;
  } else if (n == 2){
    this.queryName.SetFocus();
    this.RemoveGenerateOnToolbar();
    this._enablePage3 = this.validateQueryAndSelection();
    this._enablePage4 = false;
    this._enablePage5 = false;
  } else if (n == 3){
    this.popolateDataobj(this.MemCurGrH1, this.dataObjGrH1);
    this.popolateDataobjWTotal(this.MemCurGrF1, this.dataObjGrF1);
    this.hideTotalField(this.MemCurGrF1, this.gridFieldsF1);
    this.groupDesc1.SetFocus();
    this.RemoveGenerateOnToolbar();
    this._enablePage4 = true;
    this._enablePage5 = false;
  } else if (n == 4){
    this.popolateDataobj(this.MemCurGrH2, this.dataObjGrH2);
    this.popolateDataobjWTotal(this.MemCurGrF2, this.dataObjGrF2);
    this.hideTotalField(this.MemCurGrF2, this.gridFieldsF2);
    this.groupDesc2.SetFocus();
    this.RemoveGenerateOnToolbar();
    this._enablePage5 = true;
  } else if (n == 5){
    this.popolateDataobj(this.MemCurGrH3, this.dataObjGrH3);
    this.popolateDataobjWTotal(this.MemCurGrF3, this.dataObjGrF3);
    this.hideTotalField(this.MemCurGrF3, this.gridFieldsF3);
    this.groupDesc3.SetFocus();
    this.AddGenerateOnToolbar();
  }
  for (var i = 1; i <= this.nPages; i++){
    this.EnablePage(i);
  }
}
function getOpener(){
  return (window.opener ? window.opener : (window.caller ? window.caller : window.parent));
}
function reportName_onChange(){
  this._enablePage2 = this.validateReport(true);
  for (var i = 2; i <= this.nPages; i++){
    this.EnablePage(i);
  }
}
function queryName_onChange(){
  this.TempQueryFields = this.GetQueryFields(this.queryName.Value(), true);
  // definisco le colonne
  var data = "[";
  for (var i = 0; i < this.TempQueryFields[0].length; i++){
    data = data + "['" + LRTrim(this.TempQueryFields[0][i]) + "',";
    data = data + "'" + Strtran(LRTrim(this.TempQueryFields[1][i]), "'", " ") + "'],";
  }
  data = data + "'t,CC,-1']";
  this.TempAllFields = eval(data);
  // popolo il DataObj
  this.dataObjFields.FillExtData(campi, this.TempAllFields);
  //svuota le grid
  this.dataObjGrH1.FillExtData(campi, this.TempAllFields);
  this.dataObjGrF1.FillExtData(campiTotal, this.TempAllFields);
  this.MemCurGrH1.RemoveAll();
  this.MemCurGrF1.RemoveAll();
  this.MemCurGrH2.RemoveAll();
  this.MemCurGrF1.RemoveAll();
  this.MemCurGrH3.RemoveAll();
  this.MemCurGrF3.RemoveAll();
  if (Trim(this.queryName.Value()) != '' && this.TempQueryFields[0].length == 0){
    PSAlert.alert('Invalid Visual Query.');
  }
  this._enablePage3 = false;
  this.gridFields.AllChecked(false);
  for (var i = 3; i <= this.nPages; i++){
    this.EnablePage(i);
  }
}
function popolateDataobj(memcurs, datasource){
  while (memcurs.RecCount() > 0){
    memcurs.Remove(memcurs.RecCount());
  }
  for (var i = 0; i < campi.length; i++){
    memcurs.CreateFld(campi[i], "C");
  }
  var data, s;
  if (this.gridFields.AllChecked()){
    data = this.TempAllFields;
  } else {
    data = this.gridFields.GetSelectedData().Data;
  }
  for (var i = 0; i < data.length - 1; i++){
    s = data[i];
    memcurs.AppendBlank();
    memcurs.Set(campi[0], s[0]);
    memcurs.Set(campi[1], s[1]);
  }
  memcurs.InToDatasource(datasource);
}
function hideTotalField(memcurs, datagrid){
  var col = 2;
  for (var i = 0; i < memcurs.RecCount(); i++){
    memcurs.GoTo(i + 1);
    var pos = LibJavascript.Array.indexOf(this.TempQueryFields[0], memcurs.Get("field"));
    if (pos >= 0){
      var type = this.TempQueryFields[2][pos];
      if (type != "N"){
        var ctrl = Ctrl(datagrid.ctrlid + "_" + i + "_" + col + "_input");
        if (ctrl){
          ctrl.style.display = 'none';
        }
      }
    }
  }
}
function popolateDataobjWTotal(memcurs, datasource){
  while (memcurs.RecCount() > 0){
    memcurs.Remove(memcurs.RecCount());
  }
  for (var i = 0; i < campiTotal.length - 1; i++){
    memcurs.CreateFld(campiTotal[i], "C");
  }
  memcurs.CreateFld(campiTotal[campiTotal.length - 1], "L");
  var data;
  if (this.gridFields.AllChecked()){
    data = this.TempAllFields;
  } else {
    data = this.gridFields.GetSelectedData().Data;
  }
  for (var i = 0; i < data.length - 1; i++){
    s = data[i];
    memcurs.AppendBlank();
    memcurs.Set(campiTotal[0], s[0]);
    memcurs.Set(campiTotal[1], s[1]);
  }
  memcurs.InToDatasource(datasource);
}
function this_Loaded(){
  this.reportName.SetFocus();
  var data = ['t,CC,-1'];
  this.dataObjFields.FillExtData(campi, data);
  this.dataObjGrH1.FillExtData(campi, data);
  this.dataObjGrF1.FillExtData(campiTotal, data);
  left = (screen.width) ? (screen.width - width) / 2 : 100;
  top = (screen.height) ? (screen.height - height - (height / 4)) / 2 : 100;
  if (IsNetscape() || IsMozilla()){
    width += 5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
    height += 4;
  }
}
function GetQueryFields(queryname, retDesc){
  var res = [], types = [], len = [], dec = [];
  if (retDesc == true)
    var desc = [];
  var AllField = new JSURL("../servlet/SPVQRProxy?action=fields&filename=" + queryname, true);
  AllField = AllField.Response();
  if (Left(AllField, 9) == "BO_QUERY:"){
    AllField = Substr(AllField, 10);
    var CSV_SEP = "#!$";
    var row, rows = AllField.split(CSV_SEP);
    for (var i = 0; i < rows.length; i++){
      row = rows[i].split("|");
      res.push(row[0]);
      if (retDesc == true){
        desc.push(row[2]);
      }
      types.push(row[1]);
      len.push(row[3]);
      dec.push(row[4]);
    }
  } else {
    var l_oFields = new TrsJavascript();
    l_oFields.reset();
    l_oFields.SetRow(0);
    l_oFields.BuildProperties(AllField);
    var rows = GetProperty(l_oFields, 'Rows', 'N');
    for (var i = 0; i < rows; i++){
      l_oFields.SetRow(i);
      res.push(GetProperty(l_oFields, 'alias', 'C'));
      if (retDesc == true){
        desc.push(GetProperty(l_oFields, 'desc', 'C'));
      }
      types.push(GetProperty(l_oFields, 'type', 'C'));
      len.push(GetProperty(l_oFields, 'len', 'N'));
      dec.push(GetProperty(l_oFields, 'dec', 'N'));
    }
  }
  return retDesc ? [res, desc, types, len, dec] : [res, types, len, dec];
}
function bPage1EditQuery_Click(){
  window.open("../visualquery/index.jsp?filename=" + this.queryName.Value(), "Edit_Query", "width=800,height=600,scroll=no,status=no,toolbar=no")
}
function bPage1NewQuery_Click(){
  window.open("../visualquery/index.jsp", "New_Query", "width=800,height=600,scroll=no,status=no,toolbar=no")
}
function bPage1SelectQuery_Click(){
  var url = "../portalstudio/open.jsp?tool=visualquery&onetool=true&ExpressionID=" + URLenc(this.formid + "_queryName") + "&callerFunction=ExpressionBuilderReturn";
  if (IsIE() && getInternetExplorerVersion() <= 8){
    window.open(url, "visualquery", "height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + ",resizable=yes");
  } else {
    url += "&visualquery&SPModalLayerId=querySPModalLayer";
    openSPModalLayer(url, 100, 50, width, height, true, 1, false);
  }
}
function groupBuild11_Click(){
  wizardquery = this.queryName.Value();
  var url = "../portalstudio/expression_builder.jsp?ExpressionID=" + URLenc(this.formid + "_groupBy1") + "&callerFunction=ExpressionBuilderReturn&tool=report";
  if (IsIE() && getInternetExplorerVersion() <= 8){
    window.open(url, "Build_Expression_Group_1", "height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + ",resizable=yes");
  } else {
    url += "&Build_Expression_Group_1&SPModalLayerId=g1ExpBuildSPModalLayer";
    openSPModalLayer(url, 100, 50, width, height, true, 1, false);
  }
}
function groupBuild21_Click(){
  wizardquery = this.queryName.Value();
  var url = "../portalstudio/expression_builder.jsp?ExpressionID=" + URLenc(this.formid + "_groupBy2") + "&callerFunction=ExpressionBuilderReturn&tool=report";
  if (IsIE() && getInternetExplorerVersion() <= 8){
    window.open(url, "Build_Expression_Group_2", "height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + ",resizable=yes");
  } else {
    url += "&Build_Expression_Group_2&SPModalLayerId=g2ExpBuildSPModalLayer";
    openSPModalLayer(url, 100, 50, width, height, true, 1, false);
  }
}
function groupBuild31_Click(){
  wizardquery = this.queryName.Value();
  var url = "../portalstudio/expression_builder.jsp?ExpressionID=" + URLenc(this.formid + "_groupBy3") + "&callerFunction=ExpressionBuilderReturn&tool=report";
  if (IsIE() && getInternetExplorerVersion() <= 8){
    window.open(url, "Build_Expression_Group_3", "height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + ",resizable=yes");
  } else {
    url += "&Build_Expression_Group_3&SPModalLayerId=g3ExpBuildSPModalLayer";
    openSPModalLayer(url, 100, 50, width, height, true, 1, false);
  }
}
function reportmodel1_onChange(){
  this.reportmodel2.Value(!this.reportmodel1.Value())
}
function reportmodel2_onChange(){
  this.reportmodel1.Value(!this.reportmodel2.Value())
}
function model1img_Click(){
  this.reportmodel1.Value(true);
  this.reportmodel2.Value(false);
  this.boxImage1.Show();
  this.boxImage2.Hide();
}
function model2img_Click(){
  this.reportmodel1.Value(false);
  this.reportmodel2.Value(true);
  this.boxImage1.Hide();
  this.boxImage2.Show();
}
function gridFields_SelectionChange(state){
  this._enablePage3 = this.validateQueryAndSelection();
  for (var i = 3; i <= this.nPages; i++){
    this.EnablePage(i);
  }
}
function gridFields_SelectAllChange(){
  this._enablePage3 = this.validateQueryAndSelection();
  for (var i = 3; i <= this.nPages; i++){
    this.EnablePage(i);
  }
}
function gridFieldsF1_SelectionChange(state){
  this.hideTotalField(this.MemCurGrF1, this.gridFieldsF1);
}
function gridFieldsF2_SelectionChange(state){
  this.hideTotalField(this.MemCurGrF2, this.gridFieldsF2);
}
function gridFieldsF3_SelectionChange(state){
  this.hideTotalField(this.MemCurGrF3, this.gridFieldsF3);
}
function bSave_Click(){
  var opener = getOpener();
  var JsonWizardReport = {
    type: 'report-wizard'
  };
  var JsonGroups = [], data = [], tmpFields = {};
  var JsonGroup1 = { 'groupName': 'group1' }, JsonGroup2 = { 'groupName': 'group2' }, JsonGroup3 = { 'groupName': 'group3' };
  JsonWizardReport["reportTitle"] = URLenc(Trim(this.reportTitle.Value()));
  JsonWizardReport["reportQuery"] = Trim(this.queryName.Value());
  if (this.reportmodel1.Value() == true){
    JsonWizardReport["reportModel"] = "modelreportwizard_2";
  } else {
    JsonWizardReport["reportModel"] = "modelreportwizard_1";
  }
  if (this.gridFields.AllChecked()){
    JsonWizardReport["allFields"] = "true";
  } else {
    var reportFields = "";
    data = this.gridFields.mem_curs ? this.gridFields.GetSelectedData().Data : [];
    JsonWizardReport["allFields"] = "false";
    for (var i = 0; i < data.length - 1; i++){
      reportFields += data[i][0] + ",";
    }
    JsonWizardReport["reportFields"] = reportFields;
  }
  JsonWizardReport["fieldsOutputName"]  = this.radioFieldsOutputName.Value();
  // Espressioni e descrizione dei gruppi
  JsonGroup1["groupBy"] = (!Empty(Trim(this.groupBy1.Value())) ? URLenc(Trim(this.groupBy1.Value())) : '1=1');
  JsonGroup2["groupBy"] = URLenc(Trim(this.groupBy2.Value()));
  JsonGroup3["groupBy"] = URLenc(Trim(this.groupBy3.Value()));
  JsonGroup1["groupDesc"] = URLenc(Trim(this.groupDesc1.Value()));
  JsonGroup2["groupDesc"] = URLenc(Trim(this.groupDesc2.Value()));
  JsonGroup3["groupDesc"] = URLenc(Trim(this.groupDesc3.Value()));
  //Headers
  data = this.gridFieldsH1.mem_curs ? this.gridFieldsH1.GetSelectedData().Data : [];
  for (var i = 0; i < data.length - 1; i++){
    tmpFields[data[i][0]] = "false";
  }
  JsonGroup1["groupHeader"] = tmpFields;
  data = [], tmpFields = {};
  data = this.gridFieldsH2.mem_curs ? this.gridFieldsH2.GetSelectedData().Data : [];
  for (var i = 0; i < data.length - 1; i++){
    tmpFields[data[i][0]] = 'false';
  }
  JsonGroup2["groupHeader"] = tmpFields;
  data = [], tmpFields = {};
  data = this.gridFieldsH3.mem_curs ? this.gridFieldsH3.GetSelectedData().Data : [];
  for (var i = 0; i < data.length - 1; i++){
    tmpFields[data[i][0]] = 'false';
  }
  JsonGroup3["groupHeader"] = tmpFields;
  //Footers
  data = [], tmpFields = {};
  data = this.gridFieldsF1.mem_curs ? this.gridFieldsF1.GetSelectedData().Data : [];
  for (var i = 0; i < data.length - 1; i++){
    tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));
  }
  JsonGroup1["groupFooter"] = tmpFields;
  data = [], tmpFields = {};
  data = this.gridFieldsF2.mem_curs ? this.gridFieldsF2.GetSelectedData().Data : [];
  for (var i = 0; i < data.length - 1; i++){
    tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));
  }
  JsonGroup2["groupFooter"] = tmpFields;
  data = [], tmpFields = {};
  data = this.gridFieldsF3.mem_curs ? this.gridFieldsF3.GetSelectedData().Data : [];
  for (var i = 0; i < data.length - 1; i++){
    tmpFields[data[i][0]] = (data[i][2] == 'true' ? 'true' : (data[i][2] == '1' ? 'true' : 'false'));
  }
  JsonGroup3["groupFooter"] = tmpFields;
  JsonGroups.push(JsonGroup1);
  JsonGroups.push(JsonGroup2);
  JsonGroups.push(JsonGroup3);
  JsonWizardReport["groups"] = JsonGroups;
  var serv = new JSURL('../servlet/spreportwizard?reportName=' + Trim(this.reportName.Value()) + "&JsonWizardReport=" + URLenc(JSON.stringify(JsonWizardReport))).Response();
  if (serv.indexOf('Function return value:true') >= 0){
    if (opener){
      if (opener.newCurrentObj){
        opener.newCurrentObj(Trim(this.reportName.Value()), 'report');
        if (opener.NavForm) {
          opener.NavForm();
        }
        window.close();
      } else {
        window.open("../reporteditor/index.jsp?id=" + Trim(this.reportName.Value()) + "&custom=false", '_self');
      }
    } else {
      window.open("../reporteditor/index.jsp?id=" + Trim(this.reportName.Value()) + "&custom=false", '_self');
    }
  } else {
    var err = 'RPT_REPORT_WIZARD_ERROR';
    window.open("../jsp-system/SPReportMaskMessage_portlet.jsp?msgBox=" + err, '_self')
  }
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPWebReportWizard_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPWebReportWizard',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPWebReportWizard');
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
sp.endPage("SPWebReportWizard");
}%>
<%! public String getJSPUID() { return "2608109347"; } %>