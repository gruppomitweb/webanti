<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var props = [\"field\", \"type\", \"descrs\", \"keys\", \"pictures\", \"sorts\", \"sortsfields\"],\n    propsc = ['condType', 'vCompareType', 'vCompare1', 'vCompare2', 'vFontColor', 'vBckColor', 'vFontName', 'vFontStyle', 'vFontSize', \n  \t\t\t\t\t 'sCompare1', 'sCompare2', 'sCompare3', 'sBckColor1', 'sBckColor2', 'sBckColor3'\n            ],\n    startidx = 2;\n\nvar emptyData = {},\n    localData = {};\nfor (var i = 0; i \u003c props.length; i++)\n  emptyData[props[i]] = \"\";\n\nthis.jsCondFormats = [];\n\nfunction Modified(){\n  var now=this.getData();\n  if(now==emptyData)\n    return false;\n  for(var p in now){\n    if(localData[p]!=now[p]){\n      return true;\n    }\n  }\n  return false;\n}\n\nfunction setData(dati){\n  if (Empty(dati))\n    return;\n  if(!EmptyString(localData.field) && this.Modified()){\n    if(!window.confirm(\"Changes have not been saved yet.\\r\\nContinue loosing changes?\")){\n      return;\n    }\n  }\n  \u002f\u002fclono dati e poi imposto i default\n  localData = LibJavascript.JSONUtils.adjust(JSON.parse(JSON.stringify(dati)), emptyData);\n  this.SetControlsValue();\n}\n\nfunction SetControlsValue(){\n  this.alias.Value(localData.field)\n  if(localData.type == 'odimension' ) \n  \tthis.labelTitle.Value(\"Field settings: \" + localData.field + \" (\" + 'other dimension' + \")\");\n  else if(localData.type == 'omeasure' ) \n  \tthis.labelTitle.Value(\"Field settings: \" + localData.field + \" (\" + 'other measure' + \")\");\n  else \n  \tthis.labelTitle.Value(\"Field settings: \" + localData.field + \" (\" + localData.type + \")\");\n\tfor (var i = startidx; i \u003c props.length; i++) {\n    if (this[props[i]])\n\t\t\tthis[props[i]].Value(localData[props[i]]);\n  }\n  if( !Empty(localData.condformats) ) {\n    this.condformats.Value(JSON.stringify(localData.condformats));\n  }\n}\n\nfunction getData(){\n  var obj = {};\n  obj.field = localData.field;\n  obj.type = localData.type;\n  for (var i = startidx; i \u003c props.length; i++) {\n    if (this[props[i]])\n  \t\tobj[props[i]] = this[props[i]].Value();\n  }\n  obj.condformats = this.jsCondFormats;\n  return obj;\n}\n\nfunction btnOk_Click(){\n  localData=this.getData();\n  if (GetOpener() && GetOpener().SetFieldDetail)\n  \tGetOpener().SetFieldDetail(this.fname.Value(), localData);\n  WindowClose();\n}\n\nfunction btnClose_Click(){\n  if(!EmptyString(localData.field) && this.Modified()){\n    if(window.confirm(\"Changes have not been saved yet.\\r\\nContinue loosing changes?\")){\n      WindowClose();\n    }\n  } else {\n    WindowClose();\n  }\n}\n\n\nfunction this_Loaded(){\n  if (GetOpener() && GetOpener().GetFieldDetail)\n  \tthis.setData(GetOpener().GetFieldDetail(this.fname.Value()));  \n  this.BoxMeasC.Collapse();\n  this.BoxDim.Collapse();\n  \n  if(this.isMeasure.Value() == true ) {\n    this.BoxMeasC.Expand();\n\t\tvar vc = this.condformats.Value();\n    if( !Empty( vc ) ) {\n       this.jsCondFormats = JSON.parse(vc);\n    }\n    if( this.jsCondFormats.length == 0 ) this.TempCFormatting.Hide();\n   \tthis.StDataCFormatting.FillData(this.jsCondFormats)\n  }\n  else {\n    this.BoxDim.Expand(); \n  }\n}\n\nfunction SetCFormatting(jsO) {\n  this.TempCFormatting.Show();\n  if( jsO.index == -1 ) {\n    jsO.stopApply = false;\n  \tthis.jsCondFormats.push(jsO) \n  }\n  else {\n    jsO.stopApply = this.jsCondFormats[jsO.index].stopApply;\n    this.jsCondFormats[jsO.index] = jsO;\n  }\n  this.StDataCFormatting.FillData(this.jsCondFormats)\n}\n\nfunction BAddCFormatting_Click(){\n  this.NewCFormatting();\n}\n\nfunction NewCFormatting(index) {\n  this.SPLinkCFormatting.Parameters('index=-1,parentID='+ this.formid)\n  this.SPLinkCFormatting.Link()\n}\n\nfunction EditCFormatting(index) {\n  var p = 'index='+index;\n  p+=\",\" + 'parentID='+ this.formid\n  var o = this.jsCondFormats[index];\n  var i;\n  for( i=0; i\u003cpropsc.length; i++ ) {\n    p+=','+propsc[i]+'='+o[propsc[i]]\n  }\n  this.SPLinkCFormatting.Parameters(p)\n  this.SPLinkCFormatting.Link()\n}\n\nfunction DeleteCFormatting(index) {\n  this.jsCondFormats.splice(index, 1);\n  if( this.jsCondFormats.length == 0 ) this.TempCFormatting.Hide();\n  this.StDataCFormatting.FillData(this.jsCondFormats)\n}\n\nfunction TypeCFormatting(index) {\n  return this.getStr(this.jsCondFormats[index].condType);\n}\n\nfunction CheckCFormatting(index) {\n  if( this.jsCondFormats[index].stopApply == undefined )\n    this.jsCondFormats[index].stopApply = true;\n  else\n    this.jsCondFormats[index].stopApply =!this.jsCondFormats[index].stopApply;\n}\n\nfunction CheckedCFormatting(index) {\n  if( this.jsCondFormats[index].stopApply == undefined )\n    return \"\";\n  if( !this.jsCondFormats[index].stopApply )\n    return \"\";\n  return \"checked\"\n}\n\nfunction UpCFormatting(index) {\n  if( index \u003e 0 ) {\n  \tvar tmp = this.jsCondFormats[index];\n    this.jsCondFormats[index] = this.jsCondFormats[index-1]\n    this.jsCondFormats[index-1] = tmp;\n    this.StDataCFormatting.FillData(this.jsCondFormats)\n  }\n}\n\nfunction DownCFormatting(index) {\n  if( index \u003e= 0  && index \u003c this.jsCondFormats.length) {\n  \tvar tmp = this.jsCondFormats[index];\n    this.jsCondFormats[index] = this.jsCondFormats[index+1]\n    this.jsCondFormats[index+1] = tmp;\n    this.StDataCFormatting.FillData(this.jsCondFormats)\n  }\n}\n\nfunction getStr(desc) {\n  if( desc == '2scale') return '2 scale';\n  if( desc == '3scale') return '3 scale';\n  if( desc == 'notbetween') return 'not between';\n  if( desc == 'not equals') return 'not equals';\n  if( desc == 'more') return 'more than';\n  if( desc == 'less') return 'more than';\n  if( desc == 'moreequals') return 'more than or equals';\n  if( desc == 'lessequals') return 'less than or equals';\n  \treturn desc;\n}\n\nfunction FColorCFormatting(index) {\n  if (this.jsCondFormats[index].condType == 'compare') {\n    if (!Empty(this.jsCondFormats[index].vFontColor)) {\n      return this.jsCondFormats[index].vFontColor;\n    }\n  }\n  return '#000000';\n}\n\nfunction BColorCFormatting(index) {\n  if (this.jsCondFormats[index].condType == 'compare') {\n    if (!Empty(this.jsCondFormats[index].vBckColor)) {\n      return this.jsCondFormats[index].vBckColor;\n    }\n  }\n  else if (this.jsCondFormats[index].condType == '2scale') {\n    var c1 = this.jsCondFormats[index].sBckColor1;\n    if( Empty(c1) ) c1 = '#ffffff';\n    var c2 = this.jsCondFormats[index].sBckColor2;\n    if( Empty(c2) ) c2 = '#ffffff';\n    \n    return \"linear-gradient(to right,\" + c1 + \",\" + c2 + \")\";\n  }\n  else if (this.jsCondFormats[index].condType == '3scale') {\n    var c1 = this.jsCondFormats[index].sBckColor1;\n    if( Empty(c1) ) c1 = '#ffffff';\n    var c2 = this.jsCondFormats[index].sBckColor2;\n    if( Empty(c2) ) c2 = '#ffffff';\n    var c3 = this.jsCondFormats[index].sBckColor3;\n    if( Empty(c3) ) c3 = '#ffffff';\n    var v1 = this.jsCondFormats[index].sCompare1;\n    var v2 = this.jsCondFormats[index].sCompare2;\n    var v3 = this.jsCondFormats[index].sCompare3;\n    if( v3 - v1 != 0 ) {\n      var p2 = (v2-v1)\u002f(v3-v1);\n      var p3 = (v3-v2)\u002f(v3-v1);\n      var p1 = 1 -(p2+p3);\n      return \"linear-gradient(to right,\" + c1 + \" \" + (p1*100) + \"%,\" + c2 + \" \" + (p1+p2)*100  + \"%,\" + c3 + \" \" + (p1+p2+p3)*100 + \"%)\";\n    }\n    else\n    \treturn \"linear-gradient(to right,\" + c1 + \",\" + c2 + \",\" + c3 + \")\";\n  }\n  return '#ffffff';\n}\n\nfunction TextCFormatting(index) {\n  if (this.jsCondFormats[index].condType == 'compare')\n    return \" AaBbCcYyZz \";\n  return \"\";\n}\n\nfunction FFamilyCFormatting(index) {\n  if (this.jsCondFormats[index].condType == 'compare') {\n    if(!Empty(this.jsCondFormats[index].vFontName))\n    \treturn this.jsCondFormats[index].vFontName;\n    else\n      return \"\";\n  }\n  return \"\";\n}\n\nfunction FStyleCFormatting(index) {\n  if (this.jsCondFormats[index].condType == 'compare')\n     if(!Empty(this.jsCondFormats[index].vFontStyle)) {\n    \t\tif( this.jsCondFormats[index].vFontStyle.indexOf('italic') \u003e=0)  return 'italic';\n     }\n  return \"normal\";\n}\n\nfunction FSizeCFormatting(index) {\n  if (this.jsCondFormats[index].condType == 'compare')\n    if(!Empty(this.jsCondFormats[index].vFontSize))\n    \treturn this.jsCondFormats[index].vFontSize + 'px';\n  return \"14px\";\n}\n\nfunction FWeightCFormatting(index) {\n  if (this.jsCondFormats[index].condType == 'compare')\n     if(!Empty(this.jsCondFormats[index].vFontStyle)) {\n    \t\tif( this.jsCondFormats[index].vFontStyle.indexOf('bold') \u003e=0 ) return 'bold';\n     }\n  return \"normal\";\n}\n\nfunction DescCFormatting(index) {\n  if( this.jsCondFormats[index].condType == 'compare' ) {\n    if(this.jsCondFormats[index].vCompareType == 'between' || this.jsCondFormats[index].vCompareType == 'notbetween' ) {\n    \treturn this.getStr(this.jsCondFormats[index].vCompareType) + \" [\" + this.jsCondFormats[index].vCompare1 + \"] and \" + \"[\" + this.jsCondFormats[index].vCompare2 + \"]\";\n    }\n    else {\n      return this.getStr(this.jsCondFormats[index].vCompareType) + \" [\" + this.jsCondFormats[index].vCompare1 + \"]\";\n    }\n  }\n  else if( this.jsCondFormats[index].condType == '2scale' ) {\n    return \"Min. [\" + this.jsCondFormats[index].sCompare1 + \"] and \" + \"Max. [\" + this.jsCondFormats[index].sCompare2 + \"]\";\n  }\n  else if( this.jsCondFormats[index].condType == '3scale' ) {\n    return \"Min. [\" + this.jsCondFormats[index].sCompare1 + \"], \" + \"Int. [\" + this.jsCondFormats[index].sCompare2 + \"] and \" + \"Max. [\" + this.jsCondFormats[index].sCompare3 + \"]\";\n  }\n  return \"\"; \n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"classeditor\u002ffontList.css,portalstudio\u002fportalstudioTheme.css,properties.css","css_class":"","css_code":"[{\"type\":\"textbox\",\"name\":\"portalstudio_textbox\",\"selector\":\".portalstudio_textbox\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"resize: none;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"textbox\\\",\\\"class_name\\\":\\\"portalstudio_textbox\\\",\\\"selector\\\":\\\".portalstudio_textbox\\\",\\\"value\\\":\\\"Textbox text\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"code\\\":\\\"resize: none;\\\"}\",\"code\":\".portalstudio_textbox {\\n  resize: none;\\n}\\n\"},{\"type\":\"textbox\",\"name\":\"hyperlink_expanded\",\"selector\":\".hyperlink_expanded, .hyperlink_expanded textarea\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"height: 60px !important;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"textbox\\\",\\\"class_name\\\":\\\"hyperlink_expanded\\\",\\\"selector\\\":\\\".hyperlink_expanded, .hyperlink_expanded textarea\\\",\\\"value\\\":\\\"Textbox text\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"code\\\":\\\"height: 60px !important;\\\"}\",\"code\":\".hyperlink_expanded, .hyperlink_expanded textarea {\\n  background-color: #f3f3f3;\\n  height: 60px !important;\\n}\\n\"},{\"type\":\"textbox\",\"name\":\"tooltip_expanded\",\"selector\":\".tooltip_expanded, .tooltip_expanded textarea\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"height: 60px !important;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"textbox\\\",\\\"class_name\\\":\\\"tooltip_expanded\\\",\\\"selector\\\":\\\".tooltip_expanded, .tooltip_expanded textarea\\\",\\\"value\\\":\\\"Textbox text\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"code\\\":\\\"height: 60px !important;\\\"}\",\"code\":\".tooltip_expanded, .tooltip_expanded textarea {\\n  background-color: #f3f3f3;\\n  height: 60px !important;\\n}\\n\"},{\"type\":\"image\",\"name\":\"cursor_icon\",\"selector\":\".cursor_icon\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"cursor\\\":\\\"pointer\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"src\\\"],\\\"type\\\":\\\"image\\\",\\\"class_name\\\":\\\"cursor_icon\\\",\\\"selector\\\":\\\".cursor_icon\\\",\\\"h\\\":\\\"240\\\",\\\"w\\\":\\\"480\\\",\\\"src\\\":\\\".\u002fimages\u002fdefault.jpg\\\",\\\"id\\\":\\\"form\\\",\\\"cursor\\\":\\\"pointer\\\"}\",\"code\":\".cursor_icon {\\n  cursor: pointer;\\n}\\n\"},{\"type\":\"box\",\"name\":\"box_colorpicker\",\"selector\":\".box_colorpicker\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"cursor\\\":\\\"pointer\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"box\\\",\\\"class_name\\\":\\\"box_colorpicker\\\",\\\"selector\\\":\\\".box_colorpicker\\\",\\\"h\\\":\\\"120\\\",\\\"w\\\":\\\"240\\\",\\\"id\\\":\\\"form\\\",\\\"cursor\\\":\\\"pointer\\\"}\",\"code\":\".box_colorpicker {\\n  cursor: pointer;\\n}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"bg_color\":\"#f3f3f3\",\"code\":\"height: 60px !important;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"synonyms_expanded\",\"selector\":\".synonyms_expandedsynonyms_expanded, .synonyms_expanded textarea\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"border_type\":\"solid\",\"shadow_type\":\"outline\",\"code\":\"resize: none;\\nopacity: 0.7\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"textbox\",\"class_name\":\"portalstudio_opacity\",\"selector\":\".portalstudio_opacity\",\"value\":\"Textbox text\",\"class_Css\":\"label\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @descrs }}{{ @txtBckColor_btn }}{{ @lblTitle }}{{ @lblHyperlink }}{{ @lblOnClick }}{{ @lblTarget }}{{ @pictures }}{{ @cssClass }}{{ @align }}{{ @lblPicture }}{{ @title_align }}{{ @lblOrderbyStatus }}{{ @txtFontSize }}{{ @txtFontW }}{{ @txtFontColor }}{{ @btnOk }}{{ @txtLink }}{{ @txtOnClick }}{{ @txtTarget }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fs }}{{ @label_fw }}{{ @label_css }}{{ @lblAlign }}{{ @lblTitleAlign }}{{ @txtFontColor_btn }}{{ @txtCssClassEdit }}{{ @txtCssClassPicker }}{{ @txtCssClassAdd }}{{ @txtBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @descrs }}{{ @label_bc }}{{ @txtBckColor_btn }}{{ @lblTitle }}{{ @lblHyperlink }}{{ @lblOnClick }}{{ @lblTarget }}{{ @pictures }}{{ @cssClass }}{{ @align }}{{ @lblPicture }}{{ @title_align }}{{ @lblOrderbyStatus }}{{ @txtFontSize }}{{ @txtFontW }}{{ @txtFontColor }}{{ @btnOk }}{{ @txtLink }}{{ @txtOnClick }}{{ @txtTarget }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fs }}{{ @label_fw }}{{ @label_fc }}{{ @label_css }}{{ @lblAlign }}{{ @lblTitleAlign }}{{ @txtFontColor_btn }}{{ @txtCssClassEdit }}{{ @txtCssClassPicker }}{{ @txtCssClassAdd }}{{ @txtBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @descrs }}{{ @label_bc }}{{ @txtBckColor_btn }}{{ @lblTitle }}{{ @lblHyperlink }}{{ @lblOnClick }}{{ @lblTarget }}{{ @pictures }}{{ @cssClass }}{{ @align }}{{ @lblPicture }}{{ @title_align }}{{ @lblOrderbyStatus }}{{ @txtFontSize }}{{ @txtFontW }}{{ @txtFontColor }}{{ @btnOk }}{{ @txtLink }}{{ @txtOnClick }}{{ @txtTarget }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fs }}{{ @label_fw }}{{ @label_fc }}{{ @label_css }}{{ @lblAlign }}{{ @lblTitleAlign }}{{ @txtFontColor_btn }}{{ @txtCssClassEdit }}{{ @txtCssClassPicker }}{{ @txtCssClassAdd }}{{ @txtBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @BoxDim }}{{ @BoxDim_Copy }}{{ @BoxMeas }}{{ @BoxDim }}{{ @BoxMeas }}{{ @lblTitle_Copy }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @lblTitle_Copy }}{{ @formuleType }}{{ @lblTitle_Copy_Copy }}{{ @descrs }}{{ @label_bc }}{{ @lblTitle }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyStatus }}{{ @btnOk }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fc }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @cFormatting }}{{ @BoxMeasC_Copy }}{{ @descrs }}{{ @label_bc }}{{ @vBckColor_btn }}{{ @lblTitle }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyStatus }}{{ @vFontColor }}{{ @btnOk }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @cFormatting }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @lblValue_Copy }}{{ @descrs }}{{ @label_bc }}{{ @vBckColor_btn }}{{ @lblTitle }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyStatus }}{{ @vFontColor }}{{ @btnOk }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @cFormatting }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @BoxMeasS }}{{ @lblMin_Copy }}{{ @descrs }}{{ @label_bc }}{{ @vBckColor_btn }}{{ @lblTitle }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyStatus }}{{ @vFontColor }}{{ @btnOk }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @cFormatting }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @BoxMeasS }}{{ @lblMin }}{{ @lblMin_Copy }}{{ @lblMin_Copy_Copy }}{{ @labelTitle }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @BoxMeasS }}{{ @lblValue }}{{ @vCompareType }}{{ @lblMin }}{{ @descrs }}{{ @lblTitle }}{{ @vFontColor }}{{ @label_fc }}{{ @keys }}{{ @lblFormatting }}{{ @cFormatting }}{{ @lblKey }}{{ @vFontColor_btn }}{{ @vCompare1 }}{{ @vBckColor }}{{ @label_bc }}{{ @keysPicker }}{{ @vBckColor_btn }}{{ @vCompare2 }}{{ @lblOrderbyStatus }}{{ @sorts }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @btnOk }}{{ @btnClose }}{{ @image_help }}{{ @vCompare1_Copy }}{{ @labelTitle }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @BoxMeasS }}{{ @lblValue }}{{ @vCompareType }}{{ @lblMin }}{{ @descrs }}{{ @lblTitle }}{{ @vFontColor }}{{ @label_fc }}{{ @keys }}{{ @lblFormatting }}{{ @cFormatting }}{{ @lblKey }}{{ @vFontColor_btn }}{{ @vCompare1 }}{{ @vBckColor }}{{ @label_bc }}{{ @lblMid }}{{ @keysPicker }}{{ @vBckColor_btn }}{{ @vCompare2 }}{{ @lblOrderbyStatus }}{{ @sorts }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @btnOk }}{{ @lblMax }}{{ @btnClose }}{{ @image_help }}{{ @vBckColor_Copy }}{{ @label_bc_Copy }}{{ @vBckColor_btn_Copy }}{{ @descrs }}{{ @label_bc }}{{ @vBckColor_btn }}{{ @vBckColor_btn_Copy }}{{ @lblTitle }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyStatus }}{{ @vFontColor }}{{ @btnOk }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @cFormatting }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @BoxMeasS }}{{ @lblMin }}{{ @lblMid }}{{ @lblMax }}{{ @sCompare1 }}{{ @label_bc1_Copy }}{{ @vBckColor_btn_Copy_Copy }}{{ @sCompare1_Copy }}{{ @sBckColor1_Copy }}{{ @descrs }}{{ @label_bc }}{{ @label_bc1 }}{{ @vBckColor_btn }}{{ @vBckColor1_btn }}{{ @lblTitle }}{{ @pictures }}{{ @lblPicture }}{{ @lblOrderbyStatus }}{{ @vFontColor }}{{ @btnOk }}{{ @btnClose }}{{ @sorts }}{{ @labelTitle }}{{ @image_help }}{{ @lblKey }}{{ @label_fc }}{{ @vFontColor_btn }}{{ @vBckColor }}{{ @keys }}{{ @lblOrderbyField }}{{ @sortsfields }}{{ @keysPicker }}{{ @BoxDim }}{{ @BoxMeasC }}{{ @lblFormatting }}{{ @cFormatting }}{{ @lblValue }}{{ @vCompareType }}{{ @vCompare1 }}{{ @vCompare2 }}{{ @BoxMeasS }}{{ @lblMin }}{{ @lblMid }}{{ @lblMax }}{{ @sCompare1 }}{{ @sBckColor1 }}{{ @vBckColor2_btn }}{{ @label_bc2_Copy }}{{ @vBckColor2_btn_Copy }}{{ @sCompare2_Copy }}{{ @sBckColor2_Copy }}{{ @Grid49 }}{{ @Button50 }}{{ @Button51 }}{{ @Template52 }}{{ @BAddCFormatting }}{{ @TemCFormatting }}{{ @BAddCFormatting }}{{ @TemCFormatting }}{{ @TempCFormatting }}{{ @lblCFormatting }}{{ @TempCFormatting }}{{ @lblCFormatting }}{{ @descrs_Copy }}{{ @lblAlias }}{{ @alias }}\u003c\u002fbody\u003e","grapesCss":"","h":"500","hsl":"","htmlcode":" \n{{ @GridCFormatting{{ @BDelCFormatting{{ @TempCFormatting }} \n }} \n{{ @BAddCFormatting }} \n }} \n \n \n \n \n \n \n{{ @BoxMeasC }} \n \n \n{{ @BoxMeasS{{ @lblMin{{ @lblMax{{ @sCompare1 \n{{ @label_bc1 \n \n{{ @vBckColor2_btn \n \n \n \n }} \n \n }} \n \n }} \n }} \n \n }} \n }} \n{{ @BoxDim }} \n{{ @keysPicker }} \n \n \n{{ @sortsfields }}\n{{ @lblOrderbyField }}\n{{ @keys }}\n{{ @descrs }}\n\n\n\n\n\n\n\n{{ @lblTitle }}\n\n\n\n\n{{ @pictures }}\n\n\n\n\n{{ @lblTotExp }}\n{{ @lblTotDesc }}\n{{ @lblTotPict }}\n{{ @lblPicture }}\n\n{{ @lblTile }}\n\n\n{{ @lblOrderbyStatus }}\n\n\n\n\n\n{{ @chkTotGroupby }}\n\n\n{{ @txtTotalExp }}\n\n{{ @txtTotalDescr }}\n{{ @txtTotalPicture }}\n\n\n\n{{ @btnOk }}\n\n\n\n\n{{ @btnClose }}\n{{ @btnClose2 }}\n{{ @btnOk_2 }}\n{{ @sorts }}\n{{ @btnReset_2 }}\n{{ @fname }}\n\n{{ @labelTitle }}\n{{ @image_help }}\n{{ @labelTitle_2 }}\n{{ @image_help_2 }}\n\n\n{{ @lblKey }}\n\n\n\n\n\n\n\n\n\n\n{{ @TileMode_Groupby }}\n{{ @label67 }}\n{{ @TileBackground }}\n{{ @button69 }}\n{{ @label72 }}\n{{ @labelTileVisibility }}\n{{ @TileVersion }}\n{{ @TileVisibility }}\n\n\n\n\n\n\n\n\n{{ lblSanitizeTags }}\n{{ sanitize_tags }}\n{{ sanitize }}\n{{ lblSanitize }}\n{{ lblSynonyms }}\n{{ txtSynonyms }}\n{{ image_help }}\n{{ label_bc }}\n{{ txtBckColor_btn }}\n{{ txtBckColor }}\n{{ lblHid }}\n{{ txtHid }}\n{{ txtTitle }}\n{{ lblTitle }}\n{{ txtTooltip }}\n{{ lblHyperlink }}\n{{ lblOnClick }}\n{{ lblTarget }}\n{{ txtPicture }}\n{{ txtCssClass }}\n{{ lblTooltip }}\n{{ align }}\n{{ txtTitle_Tooltip }}\n{{ lblTotExp }}\n{{ lblTotDesc }}\n{{ lblTotPict }}\n{{ lblPicture }}\n{{ lblTitle_Tooltip }}\n{{ lblTile }}\n{{ title_align }}\n{{ lblOrderByIdx }}\n{{ lblOrderbyStatus }}\n{{ lblEditable }}\n{{ lblSecondaryBar }}\n{{ txtFontSize }}\n{{ txtFontW }}\n{{ txtFontColor }}\n{{ chkTotGroupby }}\n{{ mode }}\n{{ txtWid }}\n{{ txtTotalExp }}\n{{ txtFixedWidth }}\n{{ txtTotalDescr }}\n{{ txtTotalPicture }}\n{{ chkExtraTitle }}\n{{ chkEditable }}\n{{ columnVisibility }}\n{{ btnOk }}\n{{ btnReset }}\n{{ txtLink }}\n{{ txtOnClick }}\n{{ txtTarget }}\n{{ btnClose }}\n{{ btnClose2 }}\n{{ btnOk_2 }}\n{{ orderbystatus }}\n{{ btnReset_2 }}\n{{ columnid }}\n{{ type }}\n{{ labelTitle }}\n{{ txtFontColor_help }}\n{{ labelTitle_2 }}\n{{ image_help_2 }}\n{{ orderbyidx }}\n{{ contId }}\n{{ label40 }}\n{{ label_fs }}\n{{ label_fw }}\n{{ label_fc }}\n{{ label_css }}\n{{ lblWid }}\n{{ lblFixedWidth }}\n{{ lblAlign }}\n{{ lblTitleAlign }}\n{{ txtFontColor_btn }}\n{{ txtField }}\n{{ TileMode_Groupby }}\n{{ label67 }}\n{{ TileBackground }}\n{{ button69 }}\n{{ label72 }}\n{{ labelTileVisibility }}\n{{ TileVersion }}\n{{ TileVisibility }}\n{{ labelVisibility }}\n{{ txtCssClassEdit }}\n{{ txtCssClassPicker }}\n{{ txtCssClassAdd }}\n{{ @BoxDim{{ @BoxMeasC{{ @lblValue \n }} \n \n }} \n }} \n{{ @coFormatting \n \n }} \n \n{{ @lblCFormatting }} \n{{ @lblAlias }} \n{{ @alias }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"","max_w":"","min_w":"","mode":"NORMAL","my_library":"portalstudio\u002fstyleVariables.js","offline":"","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"500\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align left","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"661","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Set field title","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"descrs","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"1","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"45","y":"104","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Description","w":"90","wireframe_props":"align,value,n_col","x":"45","y":"84","zindex":"2","zone":""},{"align":"right","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAlias","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Field alias","w":"90","wireframe_props":"align,value,n_col","x":"55","y":"41","zindex":"2","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Picture of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"pictures","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"5","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"350","y":"104","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtPicture","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblPicture","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Picture","w":"85","wireframe_props":"align,value,n_col","x":"350","y":"84","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"orderbystatus","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOrderbyStatus","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Order by","w":"125","wireframe_props":"align,value,n_col","x":"326","y":"131","zindex":"2","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Confirm column and apply settings","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnOk","page":"1","rapp":"","sequence":"6","spuid":"","tabindex":"30","type":"Button","type_submit":"false","type_wizard":"","value":"Ok","w":"69","wireframe_props":"value","x":"500","y":"464","zindex":"2","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnClose","page":"1","rapp":"","sequence":"7","spuid":"","tabindex":"32","type":"Button","type_submit":"false","type_wizard":"","value":"Close","w":"69","wireframe_props":"value","x":"579","y":"464","zindex":"2","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"verdana","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"sorts","page":"1","picture":"","rapp":"","sequence":"8","spuid":"","tabindex":"27","textlist":"asc,desc","type":"Combobox","typevar":"character","valuelist":"asc,desc","visible":"true","w":"125","wireframe_props":"name,textlist","x":"326","y":"151","zindex":"2","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"fname","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"-2","y":"-33"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"30","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Field settings:","w":"660","wireframe_props":"align,value,n_col","x":"0","y":"1","zindex":"2","zone":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f7;","font_image_hover":"","font_name":"iMobileIcon","font_size":"","h":"18","help_tips":"Help","hide":"true","hide_undercond":"","href":"javascript:Help('portalzoom_interfaccia_base_toolbar_config_col_main')","img_type":"font icon","keep_proportions":"","layer":"false","layout_steps_values":"{}","name":"image_help","page":"1","path_type":"","rapp":"","sequence":"11","server_side":"","spuid":"","src":"..\u002fportalstudio\u002fimages\u002fhelp.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"630","y":"4","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"mode","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblKey","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Key field","w":"125","wireframe_props":"align,value,n_col","x":"50","y":"131","zindex":"2","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Use if there are duplicates values in field","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"keys","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"1","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"244","wireframe_props":"name","x":"45","y":"151","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"50","hide":"","layer":"","layout_steps_values":"{}","name":"Note47","page":"1","rapp":"","sequence":"14","spuid":"","type":"Note","value":"cols: ['descrs', 'keys', 'pictures', 'sorts', 'sortsfields'],\nmeas: ['descrs', 'condformats', 'pictures', ....];","w":"673","wireframe_props":"","x":"742","y":"120","zindex":"13","zone":""},{"align":"left","anchor":"","assoc_input":"orderbystatus","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOrderbyField","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Order by field","w":"125","wireframe_props":"align,value,n_col","x":"491","y":"131","zindex":"2","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Specify field to use for sorting","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sortsfields","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"16","spuid":"","tabindex":"5","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"125","wireframe_props":"name","x":"491","y":"151","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"cursor_icon","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":" #00A0BD","font_color_hover":"","font_image":"&#xe6f6;","font_image_hover":"","font_name":"iMobileIcon","font_size":"16","h":"16","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"keysPicker","page":"1","path_type":"","rapp":"","sequence":"17","server_side":"","spuid":"","src":"","srchover":"","tabindex":"7","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"292","y":"152","zindex":"12","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"isMeasure","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"logic","w":"146","x":"158","y":"-34"},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"true","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"60","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"BoxDim","page":"1","rapp":"","sequence":"19","shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"646","wireframe_props":"","x":"3","y":"126","zindex":"0","zone":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"","collapsible":"true","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"258","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"BoxMeasC","page":"1","rapp":"","sequence":"20","shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"Conditional Formatting","title_portlet":"","titled":"false","type":"Box","w":"646","wireframe_props":"","x":"3","y":"196","zindex":"0","zone":""},{"alias":"condType,vCompareType,,vCompare2,vFontColor,vBckColor,sCompare1,sCompare2,sCompare3,sBckColor1,sBckColor2,sBckColor3,sBckColor3","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,N,N,C,C,N,N,N,C,C,C","h":"20","man_query":"","name":"StDataCFormatting","page":"1","parms":"","parms_source":"","sequence":"21","type":"StaticDataProvider","w":"120","x":"685","y":"60"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"BAddCFormatting","page":"1","rapp":"","sequence":"22","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"New","w":"50","wireframe_props":"value","x":"45","y":"220","zindex":"16","zone":""},{"anchor":"","class_Css":"","code":"\u003ctable class='portalstudio_grid grid_table'\u003e\n  \u003ctr class='grid_row'\u003e\n    \t\u003ctd\u003e\u003c\u002ftd\u003e\n    \t\u003ctd\u003eType\u003c\u002ftd\u003e\n    \t\u003ctd\u003eDescription\u003c\u002ftd\u003e\n    \t\u003ctd\u003eSample preview\u003c\u002ftd\u003e\n    \t\u003ctd\u003eStop on apply\u003c\u002ftd\u003e\n    \t\u003ctd\u003e\u003c\u002ftd\u003e\n    \t\u003ctd\u003e\u003c\u002ftd\u003e\n    \t\u003ctd\u003e\u003c\u002ftd\u003e\n    \t\u003ctd\u003e\u003c\u002ftd\u003e\n  \u003c\u002ftr\u003e\n  {{ #each a,index in StDataCFormatting }}\n  \u003ctr class='grid_row' \u003e\n    \u003ctd\u003e{{ index }}\u003c\u002ftd\u003e\n    \u003ctd\u003e\u003cdiv style='width:100px'\u003e{{ function:TypeCFormatting( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd\u003e\u003cdiv style='width:200px'\u003e{{ function:DescCFormatting( %index% ) }}\u003c\u002fdiv\u003e\u003c\u002ftd\u003e\n    \u003ctd\u003e\n      \u003cdiv style='padding:5px;min-width:150px;height:25px;border: 1px solid #f3f3f3;text-align:center;\n                  font-family:{{ function:FFamilyCFormatting( %index% ) }};\n                  font-style:{{ function:FStyleCFormatting( %index% ) }};\n                  font-weight:{{ function:FWeightCFormatting( %index% ) }};\n                  font-size:{{ function:FSizeCFormatting( %index% ) }};\n                  color:{{ function:FColorCFormatting( %index% ) }};\n                  background-color:{{ function:BColorCFormatting( %index% ) }};\n                  background-image:{{ function:BColorCFormatting( %index% ) }}'\u003e\n        {{ function:TextCFormatting( %index% ) }}\n      \u003c\u002fdiv\u003e\n    \u003c\u002ftd\u003e\n    \u003ctd\u003e\n      \u003cinput class='portalstudio_button' type=\"checkbox\" onclick='{{ idPortlet }}.CheckCFormatting({{ index }})' {{ function:CheckedCFormatting( %index% ) }}\u003e\n    \u003c\u002ftd\u003e\n    \u003ctd\u003e\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\"button\" onclick='{{ idPortlet }}.EditCFormatting({{ index }})'\u003eEdit\u003c\u002fbutton\u003e\u003c\u002ftd\u003e\n    \u003ctd\u003e\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\"button\" onclick='{{ idPortlet }}.DeleteCFormatting({{ index }})'\u003eDelete\u003c\u002fbutton\u003e\u003c\u002ftd\u003e\n    \u003ctd\u003e\u003cbutton class='portalstudio_button' style='width:65px;height:25px' type=\"button\" onclick='{{ idPortlet }}.UpCFormatting({{ index }})'\u003eMove Up\u003c\u002fbutton\u003e\u003c\u002ftd\u003e\n    \u003ctd\u003e\u003cbutton class='portalstudio_button' style='width:75px;height:25px' type=\"button\" onclick='{{ idPortlet }}.DownCFormatting({{ index }})'\u003eMove Down\u003c\u002fbutton\u003e\u003c\u002ftd\u003e\n  \u003c\u002ftr\u003e\n  {{ #endeach }}\n\u003c\u002ftable\u003e","ctrlOfVariant":"","dataobjs":"","fixed":"","h":"202","hide":"false","layer":"false","layout_steps_values":"{}","name":"TempCFormatting","page":"1","rapp":"","sequence":"23","spuid":"","type":"Template","w":"567","wireframe_props":"","x":"45","y":"249","zindex":"18","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"condformats","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"690","y":"88"},{"allowedentities":"SPVisualPivotCFormatting_portlet.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"SPLinkCFormatting","offline":"","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":"","refresh":"","sequence":"25","servlet":"SPVisualPivotCFormatting_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"685","y":"39"},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblCFormatting","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Conditional Formatting","w":"299","wireframe_props":"align,value,n_col","x":"45","y":"198","zindex":"2","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox portalstudio_opacity","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"alias","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"27","spuid":"","tabindex":"1","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"157","y":"41","zerofilling":"false","zindex":"2","zone":"","zoom":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:fname,isMeasure*/%>
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
window.SPVisualPivotColumns_Static=function(){
if(typeof Modified !='undefined')this.Modified=Modified;
if(typeof setData !='undefined')this.setData=setData;
if(typeof SetControlsValue !='undefined')this.SetControlsValue=SetControlsValue;
if(typeof getData !='undefined')this.getData=getData;
if(typeof btnOk_Click !='undefined')this.btnOk_Click=btnOk_Click;
if(typeof btnClose_Click !='undefined')this.btnClose_Click=btnClose_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof SetCFormatting !='undefined')this.SetCFormatting=SetCFormatting;
if(typeof BAddCFormatting_Click !='undefined')this.BAddCFormatting_Click=BAddCFormatting_Click;
if(typeof NewCFormatting !='undefined')this.NewCFormatting=NewCFormatting;
if(typeof EditCFormatting !='undefined')this.EditCFormatting=EditCFormatting;
if(typeof DeleteCFormatting !='undefined')this.DeleteCFormatting=DeleteCFormatting;
if(typeof TypeCFormatting !='undefined')this.TypeCFormatting=TypeCFormatting;
if(typeof CheckCFormatting !='undefined')this.CheckCFormatting=CheckCFormatting;
if(typeof CheckedCFormatting !='undefined')this.CheckedCFormatting=CheckedCFormatting;
if(typeof UpCFormatting !='undefined')this.UpCFormatting=UpCFormatting;
if(typeof DownCFormatting !='undefined')this.DownCFormatting=DownCFormatting;
if(typeof getStr !='undefined')this.getStr=getStr;
if(typeof FColorCFormatting !='undefined')this.FColorCFormatting=FColorCFormatting;
if(typeof BColorCFormatting !='undefined')this.BColorCFormatting=BColorCFormatting;
if(typeof TextCFormatting !='undefined')this.TextCFormatting=TextCFormatting;
if(typeof FFamilyCFormatting !='undefined')this.FFamilyCFormatting=FFamilyCFormatting;
if(typeof FStyleCFormatting !='undefined')this.FStyleCFormatting=FStyleCFormatting;
if(typeof FSizeCFormatting !='undefined')this.FSizeCFormatting=FSizeCFormatting;
if(typeof FWeightCFormatting !='undefined')this.FWeightCFormatting=FWeightCFormatting;
if(typeof DescCFormatting !='undefined')this.DescCFormatting=DescCFormatting;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.StDataCFormatting.addTemplateConsumer(this.TempCFormatting);
var props = ["field", "type", "descrs", "keys", "pictures", "sorts", "sortsfields"],
    propsc = ['condType', 'vCompareType', 'vCompare1', 'vCompare2', 'vFontColor', 'vBckColor', 'vFontName', 'vFontStyle', 'vFontSize', 
  					 'sCompare1', 'sCompare2', 'sCompare3', 'sBckColor1', 'sBckColor2', 'sBckColor3'
            ],
    startidx = 2;
var emptyData = {},
    localData = {};
for (var i = 0; i < props.length; i++)
  emptyData[props[i]] = "";
this.jsCondFormats = [];
function Modified(){
  var now=this.getData();
  if(now==emptyData)
    return false;
  for(var p in now){
    if(localData[p]!=now[p]){
      return true;
    }
  }
  return false;
}
function setData(dati){
  if (Empty(dati))
    return;
  if(!EmptyString(localData.field) && this.Modified()){
    if(!window.confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
      return;
    }
  }
  //clono dati e poi imposto i default
  localData = LibJavascript.JSONUtils.adjust(JSON.parse(JSON.stringify(dati)), emptyData);
  this.SetControlsValue();
}
function SetControlsValue(){
  this.alias.Value(localData.field)
  if(localData.type == 'odimension' ) 
  	this.labelTitle.Value("Field settings: " + localData.field + " (" + 'other dimension' + ")");
  else if(localData.type == 'omeasure' ) 
  	this.labelTitle.Value("Field settings: " + localData.field + " (" + 'other measure' + ")");
  else 
  	this.labelTitle.Value("Field settings: " + localData.field + " (" + localData.type + ")");
	for (var i = startidx; i < props.length; i++) {
    if (this[props[i]])
			this[props[i]].Value(localData[props[i]]);
  }
  if( !Empty(localData.condformats) ) {
    this.condformats.Value(JSON.stringify(localData.condformats));
  }
}
function getData(){
  var obj = {};
  obj.field = localData.field;
  obj.type = localData.type;
  for (var i = startidx; i < props.length; i++) {
    if (this[props[i]])
  		obj[props[i]] = this[props[i]].Value();
  }
  obj.condformats = this.jsCondFormats;
  return obj;
}
function btnOk_Click(){
  localData=this.getData();
  if (GetOpener() && GetOpener().SetFieldDetail)
  	GetOpener().SetFieldDetail(this.fname.Value(), localData);
  WindowClose();
}
function btnClose_Click(){
  if(!EmptyString(localData.field) && this.Modified()){
    if(window.confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
      WindowClose();
    }
  } else {
    WindowClose();
  }
}
function this_Loaded(){
  if (GetOpener() && GetOpener().GetFieldDetail)
  	this.setData(GetOpener().GetFieldDetail(this.fname.Value()));  
  this.BoxMeasC.Collapse();
  this.BoxDim.Collapse();
  
  if(this.isMeasure.Value() == true ) {
    this.BoxMeasC.Expand();
		var vc = this.condformats.Value();
    if( !Empty( vc ) ) {
       this.jsCondFormats = JSON.parse(vc);
    }
    if( this.jsCondFormats.length == 0 ) this.TempCFormatting.Hide();
   	this.StDataCFormatting.FillData(this.jsCondFormats)
  }
  else {
    this.BoxDim.Expand(); 
  }
}
function SetCFormatting(jsO) {
  this.TempCFormatting.Show();
  if( jsO.index == -1 ) {
    jsO.stopApply = false;
  	this.jsCondFormats.push(jsO) 
  }
  else {
    jsO.stopApply = this.jsCondFormats[jsO.index].stopApply;
    this.jsCondFormats[jsO.index] = jsO;
  }
  this.StDataCFormatting.FillData(this.jsCondFormats)
}
function BAddCFormatting_Click(){
  this.NewCFormatting();
}
function NewCFormatting(index) {
  this.SPLinkCFormatting.Parameters('index=-1,parentID='+ this.formid)
  this.SPLinkCFormatting.Link()
}
function EditCFormatting(index) {
  var p = 'index='+index;
  p+="," + 'parentID='+ this.formid
  var o = this.jsCondFormats[index];
  var i;
  for( i=0; i<propsc.length; i++ ) {
    p+=','+propsc[i]+'='+o[propsc[i]]
  }
  this.SPLinkCFormatting.Parameters(p)
  this.SPLinkCFormatting.Link()
}
function DeleteCFormatting(index) {
  this.jsCondFormats.splice(index, 1);
  if( this.jsCondFormats.length == 0 ) this.TempCFormatting.Hide();
  this.StDataCFormatting.FillData(this.jsCondFormats)
}
function TypeCFormatting(index) {
  return this.getStr(this.jsCondFormats[index].condType);
}
function CheckCFormatting(index) {
  if( this.jsCondFormats[index].stopApply == undefined )
    this.jsCondFormats[index].stopApply = true;
  else
    this.jsCondFormats[index].stopApply =!this.jsCondFormats[index].stopApply;
}
function CheckedCFormatting(index) {
  if( this.jsCondFormats[index].stopApply == undefined )
    return "";
  if( !this.jsCondFormats[index].stopApply )
    return "";
  return "checked"
}
function UpCFormatting(index) {
  if( index > 0 ) {
  	var tmp = this.jsCondFormats[index];
    this.jsCondFormats[index] = this.jsCondFormats[index-1]
    this.jsCondFormats[index-1] = tmp;
    this.StDataCFormatting.FillData(this.jsCondFormats)
  }
}
function DownCFormatting(index) {
  if( index >= 0  && index < this.jsCondFormats.length) {
  	var tmp = this.jsCondFormats[index];
    this.jsCondFormats[index] = this.jsCondFormats[index+1]
    this.jsCondFormats[index+1] = tmp;
    this.StDataCFormatting.FillData(this.jsCondFormats)
  }
}
function getStr(desc) {
  if( desc == '2scale') return '2 scale';
  if( desc == '3scale') return '3 scale';
  if( desc == 'notbetween') return 'not between';
  if( desc == 'not equals') return 'not equals';
  if( desc == 'more') return 'more than';
  if( desc == 'less') return 'more than';
  if( desc == 'moreequals') return 'more than or equals';
  if( desc == 'lessequals') return 'less than or equals';
  	return desc;
}
function FColorCFormatting(index) {
  if (this.jsCondFormats[index].condType == 'compare') {
    if (!Empty(this.jsCondFormats[index].vFontColor)) {
      return this.jsCondFormats[index].vFontColor;
    }
  }
  return '#000000';
}
function BColorCFormatting(index) {
  if (this.jsCondFormats[index].condType == 'compare') {
    if (!Empty(this.jsCondFormats[index].vBckColor)) {
      return this.jsCondFormats[index].vBckColor;
    }
  }
  else if (this.jsCondFormats[index].condType == '2scale') {
    var c1 = this.jsCondFormats[index].sBckColor1;
    if( Empty(c1) ) c1 = '#ffffff';
    var c2 = this.jsCondFormats[index].sBckColor2;
    if( Empty(c2) ) c2 = '#ffffff';
    
    return "linear-gradient(to right," + c1 + "," + c2 + ")";
  }
  else if (this.jsCondFormats[index].condType == '3scale') {
    var c1 = this.jsCondFormats[index].sBckColor1;
    if( Empty(c1) ) c1 = '#ffffff';
    var c2 = this.jsCondFormats[index].sBckColor2;
    if( Empty(c2) ) c2 = '#ffffff';
    var c3 = this.jsCondFormats[index].sBckColor3;
    if( Empty(c3) ) c3 = '#ffffff';
    var v1 = this.jsCondFormats[index].sCompare1;
    var v2 = this.jsCondFormats[index].sCompare2;
    var v3 = this.jsCondFormats[index].sCompare3;
    if( v3 - v1 != 0 ) {
      var p2 = (v2-v1)/(v3-v1);
      var p3 = (v3-v2)/(v3-v1);
      var p1 = 1 -(p2+p3);
      return "linear-gradient(to right," + c1 + " " + (p1*100) + "%," + c2 + " " + (p1+p2)*100  + "%," + c3 + " " + (p1+p2+p3)*100 + "%)";
    }
    else
    	return "linear-gradient(to right," + c1 + "," + c2 + "," + c3 + ")";
  }
  return '#ffffff';
}
function TextCFormatting(index) {
  if (this.jsCondFormats[index].condType == 'compare')
    return " AaBbCcYyZz ";
  return "";
}
function FFamilyCFormatting(index) {
  if (this.jsCondFormats[index].condType == 'compare') {
    if(!Empty(this.jsCondFormats[index].vFontName))
    	return this.jsCondFormats[index].vFontName;
    else
      return "";
  }
  return "";
}
function FStyleCFormatting(index) {
  if (this.jsCondFormats[index].condType == 'compare')
     if(!Empty(this.jsCondFormats[index].vFontStyle)) {
    		if( this.jsCondFormats[index].vFontStyle.indexOf('italic') >=0)  return 'italic';
     }
  return "normal";
}
function FSizeCFormatting(index) {
  if (this.jsCondFormats[index].condType == 'compare')
    if(!Empty(this.jsCondFormats[index].vFontSize))
    	return this.jsCondFormats[index].vFontSize + 'px';
  return "14px";
}
function FWeightCFormatting(index) {
  if (this.jsCondFormats[index].condType == 'compare')
     if(!Empty(this.jsCondFormats[index].vFontStyle)) {
    		if( this.jsCondFormats[index].vFontStyle.indexOf('bold') >=0 ) return 'bold';
     }
  return "normal";
}
function DescCFormatting(index) {
  if( this.jsCondFormats[index].condType == 'compare' ) {
    if(this.jsCondFormats[index].vCompareType == 'between' || this.jsCondFormats[index].vCompareType == 'notbetween' ) {
    	return this.getStr(this.jsCondFormats[index].vCompareType) + " [" + this.jsCondFormats[index].vCompare1 + "] and " + "[" + this.jsCondFormats[index].vCompare2 + "]";
    }
    else {
      return this.getStr(this.jsCondFormats[index].vCompareType) + " [" + this.jsCondFormats[index].vCompare1 + "]";
    }
  }
  else if( this.jsCondFormats[index].condType == '2scale' ) {
    return "Min. [" + this.jsCondFormats[index].sCompare1 + "] and " + "Max. [" + this.jsCondFormats[index].sCompare2 + "]";
  }
  else if( this.jsCondFormats[index].condType == '3scale' ) {
    return "Min. [" + this.jsCondFormats[index].sCompare1 + "], " + "Int. [" + this.jsCondFormats[index].sCompare2 + "] and " + "Max. [" + this.jsCondFormats[index].sCompare3 + "]";
  }
  return ""; 
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
.SPVisualPivotColumns_container .portalstudio_textbox{  resize: none;
}
.SPVisualPivotColumns_container .hyperlink_expanded, .hyperlink_expanded textarea{
  background-color: #f3f3f3;
  height: 60px !important;
}
.SPVisualPivotColumns_container .tooltip_expanded, .tooltip_expanded textarea{
  background-color: #f3f3f3;
  height: 60px !important;
}
.SPVisualPivotColumns_container .cursor_icon{
  cursor: pointer;
}
.SPVisualPivotColumns_container .box_colorpicker{
  cursor: pointer;
}
.SPVisualPivotColumns_container .synonyms_expandedsynonyms_expanded, .synonyms_expanded textarea{
  background-color: #f3f3f3;
  height: 60px !important;
}
.SPVisualPivotColumns_container .portalstudio_opacity{
  resize: none;
  opacity: 0.7
}
.SPVisualPivotColumns_container {
}
.SPVisualPivotColumns_portlet{
  position:relative;
  width:100%;
  min-width:661px;
  height:500px;
}
.SPVisualPivotColumns_portlet[Data-page="1"]{
  height:500px;
  width:100%;
}
.SPVisualPivotColumns_portlet > .descrs_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:104px;
  left:45px;
  right:351px;
  width:auto;
  height:20px;
}
.SPVisualPivotColumns_portlet > .descrs_ctrl {
}
.SPVisualPivotColumns_portlet > .descrs_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotColumns_portlet > .lblTitle_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:84px;
  left:45px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblTitle_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblTitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotColumns_portlet > .lblAlias_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:41px;
  left:55px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblAlias_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblAlias_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPVisualPivotColumns_portlet > .pictures_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:104px;
  left:350px;
  right:46px;
  width:auto;
  height:20px;
}
.SPVisualPivotColumns_portlet > .pictures_ctrl {
}
.SPVisualPivotColumns_portlet > .pictures_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotColumns_portlet > .lblPicture_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:84px;
  left:350px;
  width:85px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblPicture_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblPicture_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotColumns_portlet > .lblOrderbyStatus_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:131px;
  left:326px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblOrderbyStatus_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblOrderbyStatus_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotColumns_portlet > .btnOk_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:464px;
  right:92px;
  width:69px;
  height:24px;
}
.SPVisualPivotColumns_portlet > .btnOk_ctrl {
}
.SPVisualPivotColumns_portlet > .btnClose_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:464px;
  right:13px;
  width:69px;
  height:24px;
}
.SPVisualPivotColumns_portlet > .btnClose_ctrl {
}
.SPVisualPivotColumns_portlet > .sorts_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:151px;
  left:326px;
  width:125px;
  height:20px;
}
.SPVisualPivotColumns_portlet > .labelTitle_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:1px;
  left:0px;
  right:1px;
  width:auto;
  height:auto;
  min-height:30px;
}
.SPVisualPivotColumns_portlet > .labelTitle_ctrl {
  height:auto;
  min-height:30px;
}
.SPVisualPivotColumns_portlet > .labelTitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotColumns_portlet > .image_help_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:4px;
  right:13px;
  width:18px;
  height:18px;
  display:none;
}
.SPVisualPivotColumns_portlet > .image_help_ctrl {
  text-decoration:none;
  font-family:iMobileIcon;
  text-align:center;
  line-height:18px;
  font-size:18px;
  color:#00A0BD;
}
.SPVisualPivotColumns_portlet > .lblKey_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:131px;
  left:50px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblKey_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblKey_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotColumns_portlet > .keys_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:151px;
  left:45px;
  right:372px;
  width:auto;
  height:20px;
}
.SPVisualPivotColumns_portlet > .keys_ctrl {
}
.SPVisualPivotColumns_portlet > .keys_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotColumns_portlet > .lblOrderbyField_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:131px;
  left:491px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblOrderbyField_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblOrderbyField_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotColumns_portlet > .sortsfields_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:151px;
  left:491px;
  right:45px;
  width:auto;
  height:20px;
}
.SPVisualPivotColumns_portlet > .sortsfields_ctrl {
}
.SPVisualPivotColumns_portlet > .sortsfields_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPVisualPivotColumns_portlet > .keysPicker_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:152px;
  left:292px;
  width:16px;
  height:16px;
}
.SPVisualPivotColumns_portlet > .keysPicker_ctrl {
  text-decoration:none;
  font-family:iMobileIcon;
  text-align:center;
  line-height:16px;
  font-size:16px;
  color:#00A0BD;
}
.SPVisualPivotColumns_portlet > .BoxDim_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:126px;
  left:3px;
  width:646px;
  height:auto;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotColumns_portlet > .BoxDim_ctrl {
  height:60px;
}
.SPVisualPivotColumns_portlet > .BoxDim_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotColumns_portlet > .BoxDim_ctrl {
  border-width:0px;
  border-style:solid;
}
.SPVisualPivotColumns_portlet > .BoxMeasC_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:196px;
  left:3px;
  width:646px;
  height:auto;
  display:flex;
  flex-direction:column;
}
.SPVisualPivotColumns_portlet > .BoxMeasC_ctrl {
  height:258px;
}
.SPVisualPivotColumns_portlet > .BoxMeasC_ctrl > .box_content {
  height:100%;
}
.SPVisualPivotColumns_portlet > .BoxMeasC_ctrl {
  border-width:0px;
  border-style:solid;
}
.SPVisualPivotColumns_portlet > .BAddCFormatting_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:220px;
  left:45px;
  width:50px;
  height:25px;
}
.SPVisualPivotColumns_portlet > .BAddCFormatting_ctrl {
}
.SPVisualPivotColumns_portlet > .TempCFormatting_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:249px;
  left:45px;
  width:567px;
  height:auto;
  min-height:202px;
}
.SPVisualPivotColumns_portlet > .lblCFormatting_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:198px;
  left:45px;
  width:299px;
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblCFormatting_ctrl {
  height:auto;
  min-height:20px;
}
.SPVisualPivotColumns_portlet > .lblCFormatting_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPVisualPivotColumns_portlet > .alias_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:41px;
  left:157px;
  right:239px;
  width:auto;
  height:20px;
}
.SPVisualPivotColumns_portlet > .alias_ctrl {
}
.SPVisualPivotColumns_portlet > .alias_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"661\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descrs\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"45\",\"y\":\"104\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTitle\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Description\",\"w\":\"90\",\"x\":\"45\",\"y\":\"84\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAlias\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Field alias\",\"w\":\"90\",\"x\":\"55\",\"y\":\"41\",\"zindex\":\"2\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"pictures\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"350\",\"y\":\"104\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblPicture\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Picture\",\"w\":\"85\",\"x\":\"350\",\"y\":\"84\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOrderbyStatus\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Order by\",\"w\":\"125\",\"x\":\"326\",\"y\":\"131\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnOk\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Ok\",\"w\":\"69\",\"x\":\"500\",\"y\":\"464\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnClose\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Close\",\"w\":\"69\",\"x\":\"579\",\"y\":\"464\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sorts\",\"page\":\"1\",\"textlist\":\"asc,desc\",\"type\":\"Combobox\",\"w\":\"125\",\"x\":\"326\",\"y\":\"151\",\"zindex\":\"2\"},{\"h\":\"22\",\"name\":\"fname\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"-2\",\"y\":\"-33\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"30\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelTitle\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Field settings:\",\"w\":\"660\",\"x\":\"0\",\"y\":\"1\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"image_help\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"630\",\"y\":\"4\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblKey\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Key field\",\"w\":\"125\",\"x\":\"50\",\"y\":\"131\",\"zindex\":\"2\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"keys\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"244\",\"x\":\"45\",\"y\":\"151\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"50\",\"layout_steps_values\":{},\"name\":\"Note47\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"cols: ['descrs', 'keys', 'pictures', 'sorts', 'sortsfields'],\\nmeas: ['descrs', 'condformats', 'pictures', ....];\",\"w\":\"673\",\"x\":\"742\",\"y\":\"120\",\"zindex\":\"13\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOrderbyField\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Order by field\",\"w\":\"125\",\"x\":\"491\",\"y\":\"131\",\"zindex\":\"2\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sortsfields\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"491\",\"y\":\"151\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"16\",\"layout_steps_values\":{},\"name\":\"keysPicker\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"292\",\"y\":\"152\",\"zindex\":\"12\"},{\"h\":\"22\",\"name\":\"isMeasure\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"158\",\"y\":\"-34\"},{\"anchor\":\"\",\"h\":\"60\",\"layout_steps_values\":{},\"name\":\"BoxDim\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"646\",\"x\":\"3\",\"y\":\"126\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"258\",\"layout_steps_values\":{},\"name\":\"BoxMeasC\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"646\",\"x\":\"3\",\"y\":\"196\",\"zindex\":\"0\"},{\"h\":\"20\",\"name\":\"StDataCFormatting\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"685\",\"y\":\"60\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"BAddCFormatting\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"New\",\"w\":\"50\",\"x\":\"45\",\"y\":\"220\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"202\",\"layout_steps_values\":{},\"name\":\"TempCFormatting\",\"page\":\"1\",\"type\":\"Template\",\"w\":\"567\",\"x\":\"45\",\"y\":\"249\",\"zindex\":\"18\"},{\"h\":\"20\",\"name\":\"condformats\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"690\",\"y\":\"88\"},{\"h\":\"20\",\"name\":\"SPLinkCFormatting\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"685\",\"y\":\"39\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblCFormatting\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Conditional Formatting\",\"w\":\"299\",\"x\":\"45\",\"y\":\"198\",\"zindex\":\"2\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"alias\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"157\",\"y\":\"41\",\"zindex\":\"2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPVisualPivotColumns","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPVisualPivotColumns_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>
.SPVisualPivotColumns_portlet > .image_help_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("classeditor/fontList.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("classeditor/fontList.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("portalstudio/portalstudioTheme.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("properties.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("properties.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPVisualPivotColumns','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String descrs= "";
if(request.getAttribute("SPVisualPivotColumns_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblTitle= "Description";
String lblAlias= "Field alias";
String pictures= "";
String lblPicture= "Picture";
String lblOrderbyStatus= "Order by";
String sorts= "";
String fname=JSPLib.translateXSS(sp.getParameter("fname",""));
String labelTitle= "Field settings:";
String lblKey= "Key field";
String keys= "";
String lblOrderbyField= "Order by field";
String sortsfields= "";
boolean isMeasure=sp.getParameter("isMeasure",false);
if(request.getAttribute("SPVisualPivotColumns_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
if(request.getAttribute("SPVisualPivotColumns_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateParser.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateObj.js")%>'></script>
<%}
String condformats= "";
String lblCFormatting= "Conditional Formatting";
String alias= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPVisualPivotColumns_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPVisualPivotColumns_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPVisualPivotColumns','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_descrs_wrp'><input id='<%=idPortlet%>_descrs' name='descrs' type='text' class='portalstudio_textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='descrs' /></span>
<label id='<%=idPortlet%>_lblTitle'  formid='<%=idPortlet%>' ps-name='lblTitle'    class='portalstudio_label lblTitle_ctrl'><div id='<%=idPortlet%>_lblTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Description")%></div></label>
<label id='<%=idPortlet%>_lblAlias'  formid='<%=idPortlet%>' ps-name='lblAlias'    class='portalstudio_label lblAlias_ctrl'><div id='<%=idPortlet%>_lblAliastbl' style='width:100%;'><%=JSPLib.ToHTML("Field alias")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_pictures_wrp'><input id='<%=idPortlet%>_pictures' name='pictures' type='text' class='portalstudio_textbox' tabindex='5' formid='<%=idPortlet%>' ps-name='pictures' /></span>
<label id='<%=idPortlet%>_lblPicture'  formid='<%=idPortlet%>' ps-name='lblPicture'    class='portalstudio_label lblPicture_ctrl'><div id='<%=idPortlet%>_lblPicturetbl' style='width:100%;'><%=JSPLib.ToHTML("Picture")%></div></label>
<label id='<%=idPortlet%>_lblOrderbyStatus'  formid='<%=idPortlet%>' ps-name='lblOrderbyStatus'    class='portalstudio_label lblOrderbyStatus_ctrl'><div id='<%=idPortlet%>_lblOrderbyStatustbl' style='width:100%;'><%=JSPLib.ToHTML("Order by")%></div></label>
<input id='<%=idPortlet%>_btnOk' type='button' class='portalstudio_button btnOk_ctrl' tabindex='30'/>
<input id='<%=idPortlet%>_btnClose' type='button' class='portalstudio_button black btnClose_ctrl' tabindex='32'/>
<select id='<%=idPortlet%>_sorts' name='sorts' class='combobox' style='font-family:verdana;' tabindex='27'></select>
<span id='<%=idPortlet%>_labelTitle'  formid='<%=idPortlet%>' ps-name='labelTitle'    class='portalstudio_title labelTitle_ctrl'><div id='<%=idPortlet%>_labelTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Field settings:")%></div></span>
<a id='<%=idPortlet%>_image_help' class='image image_help_ctrl'  href='javascript:Help('portalzoom_interfaccia_base_toolbar_config_col_main')' target='_self'>&#xe6f7;</a>
<label id='<%=idPortlet%>_lblKey'  formid='<%=idPortlet%>' ps-name='lblKey'    class='portalstudio_label lblKey_ctrl'><div id='<%=idPortlet%>_lblKeytbl' style='width:100%;'><%=JSPLib.ToHTML("Key field")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_keys_wrp'><input id='<%=idPortlet%>_keys' name='keys' type='text' class='portalstudio_textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='keys' /></span>
<label id='<%=idPortlet%>_lblOrderbyField'  formid='<%=idPortlet%>' ps-name='lblOrderbyField'    class='portalstudio_label lblOrderbyField_ctrl'><div id='<%=idPortlet%>_lblOrderbyFieldtbl' style='width:100%;'><%=JSPLib.ToHTML("Order by field")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_sortsfields_wrp'><input id='<%=idPortlet%>_sortsfields' name='sortsfields' type='text' class='portalstudio_textbox' tabindex='5' formid='<%=idPortlet%>' ps-name='sortsfields' /></span>
<a id='<%=idPortlet%>_keysPicker' class='cursor_icon keysPicker_ctrl'   target=''>&#xe6f6;</a>
<div id='<%=idPortlet%>_BoxDim' class='BoxDim_ctrl SPSection_expanded box' data-original-display='flex' status='open'><div id='<%=idPortlet%>_BoxDim_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_BoxMeasC' class='BoxMeasC_ctrl SPSection_expanded box' data-original-display='flex' status='open'><div id='<%=idPortlet%>_BoxMeasC_td' class='box_content'></div>
</div>
<input id='<%=idPortlet%>_BAddCFormatting' type='button' class='portalstudio_button BAddCFormatting_ctrl'/>
<div id='<%=idPortlet%>_TempCFormatting' class=' TempCFormatting_ctrl'></div>
<label id='<%=idPortlet%>_lblCFormatting'  formid='<%=idPortlet%>' ps-name='lblCFormatting'    class='portalstudio_label lblCFormatting_ctrl'><div id='<%=idPortlet%>_lblCFormattingtbl' style='width:100%;'><%=JSPLib.ToHTML("Conditional Formatting")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_alias_wrp'><input id='<%=idPortlet%>_alias' name='alias' type='text' disabled class='portalstudio_textbox portalstudio_opacity' tabindex='1' formid='<%=idPortlet%>' ps-name='alias' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPVisualPivotColumns');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','SPVisualPivotColumns',["661"],["500"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"661","h":"500","title":"","layer":""}]);
this.descrs=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descrs","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Set field title","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descrs","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descrs,false,true)%>","w":265,"x":45,"y":104,"zerofilling":false,"zindex":"2","zoom":""});
this.lblTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitle","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTitle,false,true)%>","type":"Label","w":90,"x":45,"y":84,"zindex":"2"});
this.lblAlias=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAlias","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAlias","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAlias,false,true)%>","type":"Label","w":90,"x":55,"y":41,"zindex":"2"});
this.pictures=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_pictures","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Picture of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"pictures","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(pictures,false,true)%>","w":265,"x":350,"y":104,"zerofilling":false,"zindex":"2","zoom":""});
this.lblPicture=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtPicture","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblPicture","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblPicture","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblPicture,false,true)%>","type":"Label","w":85,"x":350,"y":84,"zindex":"2"});
this.lblOrderbyStatus=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"orderbystatus","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOrderbyStatus","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOrderbyStatus","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblOrderbyStatus,false,true)%>","type":"Label","w":125,"x":326,"y":131,"zindex":"2"});
this.btnOk=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button btnOk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnOk","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Confirm column and apply settings","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnOk","page":1,"spuid":"","tabindex":"30","text":"Ok","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":500,"y":464,"zindex":"2"});
this.btnClose=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black btnClose_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnClose","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnClose","page":1,"spuid":"","tabindex":"32","text":"Close","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":579,"y":464,"zindex":"2"});
this.sorts=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_sorts","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=sorts%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"sorts","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"27","textlist":"asc,desc","type":"Combobox","typevar":"character","valuelist":"asc,desc","visible":true,"w":125,"x":326,"y":151,"zindex":"2"});
this.fname=new ZtVWeb._VC(this,'fname',null,'character','<%=JSPLib.ToJSValue(fname,false,true)%>',false,false);
this.labelTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":30,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTitle","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelTitle,false,true)%>","type":"Label","w":660,"x":0,"y":1,"zindex":"2"});
this.image_help=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_help_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_help","edit_undercond":"","field":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f7;","font_image_hover":"","font_name":"iMobileIcon","font_path":"","font_size":"","h":18,"help_tips":"<%=JSPLib.ToJSValue("Help",false,true)%>","hide":"true","hide_undercond":"","href":"javascript:Help('portalzoom_interfaccia_base_toolbar_config_col_main')","img_type":"font icon","keepProportions":"","layer":false,"layout_steps_values":{},"name":"image_help","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe6f7;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":18,"x":630,"y":4,"zindex":"2"});
 ZtVWeb.RequireFont("iMobileIcon","");
this.lblKey=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"mode","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblKey","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblKey","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblKey,false,true)%>","type":"Label","w":125,"x":50,"y":131,"zindex":"2"});
this.keys=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_keys","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Use if there are duplicates values in field","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"keys","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(keys,false,true)%>","w":244,"x":45,"y":151,"zerofilling":false,"zindex":"2","zoom":""});
this.lblOrderbyField=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"orderbystatus","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOrderbyField","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOrderbyField","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblOrderbyField,false,true)%>","type":"Label","w":125,"x":491,"y":131,"zindex":"2"});
this.sortsfields=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sortsfields","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Specify field to use for sorting","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"sortsfields","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sortsfields,false,true)%>","w":125,"x":491,"y":151,"zerofilling":false,"zindex":"2","zoom":""});
this.keysPicker=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"cursor_icon keysPicker_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_keysPicker","edit_undercond":"","field":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f6;","font_image_hover":"","font_name":"iMobileIcon","font_path":"","font_size":"16","h":16,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"keysPicker","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe6f6;","srchover":"","tabindex":"7","target":"","type":"Image","type_submit":"false","w":16,"x":292,"y":152,"zindex":"12"});
 ZtVWeb.RequireFont("iMobileIcon","");
this.isMeasure=new ZtVWeb._VC(this,'isMeasure',null,'logic',<%=isMeasure%>,false,false);
this.BoxDim=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"true","create_undercond":"","ctrlid":"<%=idPortlet%>_BoxDim","groupName":"","h":60,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"BoxDim","page":1,"shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"","titled":"","type":"Box","w":646,"x":3,"y":126,"zindex":"0"});
this.BoxDim.containedCtrls = ['lblOrderbyStatus','keys','sortsfields','sorts','keysPicker','lblKey','lblOrderbyField'];
this.BoxMeasC=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"box","collapsible":"true","create_undercond":"","ctrlid":"<%=idPortlet%>_BoxMeasC","groupName":"","h":258,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"BoxMeasC","page":1,"shrinkable":"true","spuid":"","stretch":"true","target":"","title_caption":"Conditional Formatting","titled":"false","type":"Box","w":646,"x":3,"y":196,"zindex":"0"});
this.BoxMeasC.containedCtrls = ['BAddCFormatting','TempCFormatting','lblCFormatting'];
this.StDataCFormatting=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_StDataCFormatting","dataproviders":"","fieldsString":"condType,vCompareType,,vCompare2,vFontColor,vBckColor,sCompare1,sCompare2,sCompare3,sBckColor1,sBckColor2,sBckColor3,sBckColor3","fieldstypeString":"C,C,N,N,C,C,N,N,N,C,C,C","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"StDataCFormatting","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":685,"y":60});
this.BAddCFormatting=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button BAddCFormatting_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BAddCFormatting","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"BAddCFormatting","page":1,"spuid":"","tabindex":"","text":"New","type":"Button","type_submit":"false","type_wizard":"","w":50,"x":45,"y":220,"zindex":"16"});
this.TempCFormatting=new ZtVWeb.TemplateCtrl(this,{"anchor":"top-left","call_stack":"{\"iterator\":\"\",\"key\":\"\",\"data\":\"\",\"from\":\"\",\"to\":\"\",\"step\":\"\",\"subscopes\":[{\"iterator\":\"a\",\"key\":\"index\",\"data\":\"stdatacformatting\",\"from\":\"\",\"to\":\"\",\"step\":\"\",\"subscopes\":[]}]}","class_Css":"","ctrlid":"<%=idPortlet%>_TempCFormatting","h":202,"hide":"false","layer":false,"layout_steps_values":{},"name":"TempCFormatting","page":1,"spuid":"","template":"{\"exp\":\"\",\"prefix\":\"\\u003ctable class='portalstudio_grid grid_table'\\u003e\\n  \\u003ctr class='grid_row'\\u003e\\n    \\t\\u003ctd\\u003e\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003eType\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003eDescription\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003eSample preview\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003eStop on apply\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003e\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003e\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003e\\u003c\\u002ftd\\u003e\\n    \\t\\u003ctd\\u003e\\u003c\\u002ftd\\u003e\\n  \\u003c\\u002ftr\\u003e\\n  \",\"post\":\"\",\"type\":\"ROOT\",\"attrs\":{},\"nodes\":[{\"exp\":\"%StDataCFormatting%\",\"prefix\":null,\"post\":\"\\n  \\u003ctr class='grid_row' \\u003e\\n    \\u003ctd\\u003e\",\"type\":\"EACH\",\"attrs\":{\"iterator\":\"a\",\"key\":\"index\"},\"nodes\":[{\"exp\":\"%index%\",\"prefix\":null,\"post\":\"\\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\u003cdiv style='width:100px'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:TypeCFormatting(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\u003cdiv style='width:200px'\\u003e\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:DescCFormatting(%index%)\",\"prefix\":null,\"post\":\"\\u003c\\u002fdiv\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\n      \\u003cdiv style='padding:5px;min-width:150px;height:25px;border: 1px solid #f3f3f3;text-align:center;\\n                  font-family:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:FFamilyCFormatting(%index%)\",\"prefix\":null,\"post\":\";\\n                  font-style:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:FStyleCFormatting(%index%)\",\"prefix\":null,\"post\":\";\\n                  font-weight:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:FWeightCFormatting(%index%)\",\"prefix\":null,\"post\":\";\\n                  font-size:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:FSizeCFormatting(%index%)\",\"prefix\":null,\"post\":\";\\n                  color:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:FColorCFormatting(%index%)\",\"prefix\":null,\"post\":\";\\n                  background-color:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:BColorCFormatting(%index%)\",\"prefix\":null,\"post\":\";\\n                  background-image:\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:BColorCFormatting(%index%)\",\"prefix\":null,\"post\":\"'\\u003e\\n        \",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:TextCFormatting(%index%)\",\"prefix\":null,\"post\":\"\\n      \\u003c\\u002fdiv\\u003e\\n    \\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\n      \\u003cinput class='portalstudio_button' type=\\\"checkbox\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".CheckCFormatting(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")' \",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"function:CheckedCFormatting(%index%)\",\"prefix\":null,\"post\":\"\\u003e\\n    \\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\\\"button\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".EditCFormatting(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003eEdit\\u003c\\u002fbutton\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\u003cbutton class='portalstudio_button' style='width:50px;height:25px' type=\\\"button\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".DeleteCFormatting(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003eDelete\\u003c\\u002fbutton\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\u003cbutton class='portalstudio_button' style='width:65px;height:25px' type=\\\"button\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".UpCFormatting(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003eMove Up\\u003c\\u002fbutton\\u003e\\u003c\\u002ftd\\u003e\\n    \\u003ctd\\u003e\\u003cbutton class='portalstudio_button' style='width:75px;height:25px' type=\\\"button\\\" onclick='\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"form.formid\",\"prefix\":null,\"post\":\".DownCFormatting(\",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]},{\"exp\":\"%index%\",\"prefix\":null,\"post\":\")'\\u003eMove Down\\u003c\\u002fbutton\\u003e\\u003c\\u002ftd\\u003e\\n  \\u003c\\u002ftr\\u003e\\n  \",\"type\":\"EXP\",\"attrs\":{},\"nodes\":[]}]},{\"exp\":\"\",\"prefix\":null,\"post\":\"\\n\\u003c\\u002ftable\\u003e\",\"type\":\"END_EACH\",\"attrs\":{},\"nodes\":[]}]}","type":"Template","w":567,"x":45,"y":249,"zindex":"18"});
this.condformats=new ZtVWeb._VC(this,'condformats',null,'character','<%=JSPLib.ToJSValue(condformats,false,true)%>',false,false);
this.SPLinkCFormatting=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("SPVisualPivotCFormatting_portlet.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinkCFormatting","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinkCFormatting","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":false,"refresh":"","servlet":"SPVisualPivotCFormatting_portlet.jsp","target":"","type":"SPLinker","w":120,"x":685,"y":39});
this.SPLinkCFormatting.m_cID='<%=JSPLib.cmdHash("entity,SPVisualPivotCFormatting_portlet.jsp",request.getSession())%>';
this.lblCFormatting=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblCFormatting","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblCFormatting","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblCFormatting,false,true)%>","type":"Label","w":299,"x":45,"y":198,"zindex":"2"});
this.alias=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_alias","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"alias","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(alias,false,true)%>","w":265,"x":157,"y":41,"zerofilling":false,"zindex":"2","zoom":""});
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
<%if(request.getAttribute("SPVisualPivotColumns_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPVisualPivotColumns_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPVisualPivotColumns_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.image_help.dispatchEvent('OnLoad');
window.<%=idPortlet%>.keysPicker.dispatchEvent('OnLoad');
window.<%=idPortlet%>.sorts.FillData();
window.<%=idPortlet%>.TempCFormatting.Render( {"start_on_load":true} );
ZtVWeb.addPortletObj('<%=idPortlet%>','SPVisualPivotColumns',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPVisualPivotColumns');
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
sp.endPage("SPVisualPivotColumns");
}%>
<%! public String getJSPUID() { return "2815909569"; } %>