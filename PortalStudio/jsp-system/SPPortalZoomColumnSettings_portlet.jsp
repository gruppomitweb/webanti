<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function chkTotGroupby_onChange(){\n  if (this.chkTotGroupby.Value()==true){\n    this.txtTotalExp.Disabled()\n    this.txtTotalDescr.Disabled()\n  } else {\n    this.txtTotalDescr.Enabled()\n    this.txtTotalExp.Enabled()\n  }\n}\n\nfunction orderbystatus_onChange(){\n  if (this.orderbystatus.Value()=='')\n\tthis.orderbyidx.Disabled()\n  else\n    this.orderbyidx.Enabled()\n\n}\nfunction image_help_Click(event){\n  let pnr = GetOpener();\n  if (pnr && pnr.Help) {\n   pnr.Help('portalzoom_interfaccia_base_toolbar_config_col_main');\n  }\n}\n\n\nvar emptyData={\n  field:'',\n  title:'',\n  isImage:false,\n  isInitLetter:false,\n  isInitLetter2:false,\n  link:'',\n  target:'',\n  tooltip:'',\n  title_tooltip:'',\n  picture:'',\n  width:'',\n  maxwidth:'',\n  fixedwidth:'',\n  height:'',\n  groupby:false,\n  exp:'',\n  descr:'',\n  enable_HTML:false,\n  pict_total:'',\n  checkbox:false,\n  inExtGrid:false,\n  orderbystatus:'',\n  orderbyidx:0,\n  align:'',\n  font_size:'',\n  font_weight:'',\n  font_color:'',\n  bg_color:'',\n  col_class:'',\n  hidden:false,\n  editable:false,\n  title_align:'',\n  tileModeGroupBy:'',\n  tileBackgroundColor:'',\n  tileVersion:'',\n  tileVisibility:'base',\n  onclick:'',\n  printable:true\n};\nvar localData=emptyData;\nfunction Modified(){\n  var now=this.getData();\n  if(now==emptyData)\n    return false;\n  for(var p in now){\n    if(localData[p]!=now[p]){\n      return true;\n    }\n  }\n  return false;\n}\nfunction setData(dati){\n  if(!EmptyString(localData.field) && this.Modified()){\n    if(!window.confirm(\"Changes have not been saved yet.\\r\\nContinue loosing changes?\")){\n      return;\n    }\n  }\n  \u002f\u002fclono dati e poi imposto i default\n  localData=LibJavascript.JSONUtils.adjust(JSON.parse(JSON.stringify(dati)),emptyData);\n  localData.orderbyidx=(dati.orderbystatus && dati.orderbyidx\u003e0?dati.orderbyidx:dati.maxorderbyidx||0);\n  if(!Empty(localData.maxwidth) && localData.maxwidth==localData.width)\n    localData.fixedwidth=localData.width;\n\u002f\u002f   localData={\n\u002f\u002f     field: dati.field,\n\u002f\u002f     title: dati.title,\n\u002f\u002f     isImage: dati.isImage,\n\u002f\u002f     link: dati.link,\n\u002f\u002f     target: dati.target,\n\u002f\u002f     tooltip: dati.tooltip,\n\u002f\u002f     title_tooltip: dati.title_tooltip,\n\u002f\u002f     picture: dati.picture,\n\u002f\u002f     groupby: dati.groupby,\n\u002f\u002f     exp: dati.exp,\n\u002f\u002f     descr: dati.descr,\n\u002f\u002f     enable_HTML: dati.enable_HTML,\n\u002f\u002f     pict_total: dati.pict_total,\n\u002f\u002f     checkbox: dati.checkbox,\n\u002f\u002f     inExtGrid: dati.inExtGrid,\n\u002f\u002f     orderbyidx: (dati.orderbystatus && dati.orderbyidx\u003e0?dati.orderbyidx:dati.maxorderbyidx||0),\n\u002f\u002f     orderbystatus: dati.orderbystatus,\n\u002f\u002f     width: dati.width,\n\u002f\u002f     maxwidth: dati.maxwidth,\n\u002f\u002f     align: dati.align,\n\u002f\u002f     font_size:dati.font_size,\n\u002f\u002f     font_weight:dati.font_weight,\n\u002f\u002f     font_color:dati.font_color,\n\u002f\u002f     col_class:dati.col_class,\n\u002f\u002f     hidden:dati.hidden,\n\u002f\u002f \t  tileMode:dati.tileMode,\n\u002f\u002f   \ttileModeGroupBy:dati.tileModeGroupBy,\n\u002f\u002f   \ttileBackgroundColor:dati.tileBackgroundColor\n\u002f\u002f   }\n  this.SetControlsValue();\n}\nfunction SetControlsValue(){\n  if (Left(localData.field,5)=='html:') {\n  \tthis.txtField.Value(Substr(localData.field,6));\n    this.txtField.Show();\n  } else {\n  \tthis.labelTitle.Value(\"Column settings: \"+localData.field);\n  \tthis.labelTitle_2.Value(\"Column settings: \"+localData.field);\n  }\n  this.txtTitle.Value(localData.title);\n  \u002f\u002fthis.chkImage.Value(localData.image);\n  this.txtLink.Value(localData.link);\n  this.txtTarget.Value(localData.target);\n  this.txtTooltip.Value(localData.tooltip);\n  this.txtTitle_Tooltip.Value(localData.title_tooltip);\n  this.txtPicture.Value(localData.picture);\n  this.chkTotGroupby.Value(localData.groupby);\n  this.txtTotalExp.Value(localData.exp);\n  this.txtTotalDescr.Value(localData.descr);\n  \u002f\u002fthis.chkIsHTML.Value(localData.enableHTML);\n  this.txtTotalPicture.Value(localData.pict_total);\n  this.txtSynonyms.Value(localData.synonyms);\n  \u002f\u002fthis.chkCheckbox.Value(localData.checkbox);\n\n  if (localData.isImage)\n    this.mode.Value(2);\n  else if (localData.checkbox)\n    this.mode.Value(3);\n  else if (localData.enable_HTML)\n    this.mode.Value(1);\n  else if (localData.isInitLetter)\n    this.mode.Value(4);\n   else if (localData.isInitLetter2)\n     this.mode.Value(5);\n  else\n    this.mode.Value(0);\n  this.sanitize.Value(localData.sanitize);\n  this.sanitize_tags.Value(localData.sanitize_tags);\n  if (this.type.Value()==\"Column\" && Empty(this.contId.Value()) && !(localData.checkbox || localData.type=='M')) {\n    this.orderbystatus.Value(localData.orderbystatus);\n    this.orderbyidx.Value(localData.orderbyidx);\n    this.orderbystatus_onChange();\n  } else {\n    this.HideOrderby();\n    this.HideWid();\n  }\n  if (this.type.Value()!=\"Column\") {\n\u002f\u002f     this.HideHiddenColumn()\n    this.ZtTabs.Hide(2,true)\n  }\n  this.txtWid.Value(localData.width);\n  this.txtHid.Value(localData.height);\n  this.txtFixedWidth.Value(localData.fixedwidth);\n  this.align.Value(localData.align);\n  this.title_align.Value(localData.title_align)\n  if (Left(localData.field,5) == 'html:') {\n  \tthis.mode.Disabled();\n  }\n  this.txtFontSize.Value(localData.font_size);\n  this.txtFontW.Value(localData.font_weight);\n  this.txtFontColor.Value(localData.font_color);\n  this.txtBckColor.Value(localData.bg_color);\n  this.txtCssClass.Value(localData.col_class);\n  this.columnVisibility.Value( localData.hidden ? 'hidden' : ( localData.inExtGrid ? 'extended': 'base' ) );\n  this.chkEditable.Value(localData.editable);\n  this.TileMode_Groupby.Value(localData.tileModeGroupBy||'initial');\n  this.TileBackground.Value(localData.tileBackgroundColor);\n  this.TileVersion.Value(localData.tileVersion);\n  this.TileVisibility.Value(localData.tileVisibility);\n  this.chkExtraTitle.Value(localData.show_extra_title);\n  this.txtOnClick.Value(localData.onclick);\n\tthis.chkPrintable.Value(localData.printable);\n}\n\nfunction getData(){\n  if (Left(localData.field,5) == 'html:') {\n    localData.field = 'html:' + this.txtField.Value();\n  }\n  return {\n    field: localData.field,\n    title: this.txtTitle.Value(),\n    isImage: (this.mode.Value()==2),\n    isInitLetter: (this.mode.Value()==4),\n    isInitLetter2: (this.mode.Value()==5),\n    link: this.txtLink.Value(),\n    target: this.txtTarget.Value(),\n    tooltip: this.txtTooltip.Value(),\n    title_tooltip: this.txtTitle_Tooltip.Value(),\n    picture: this.txtPicture.Value(),\n    groupby: this.chkTotGroupby.Value(),\n    exp: this.txtTotalExp.Value(),\n    descr: this.txtTotalDescr.Value(),\n    enable_HTML: (this.mode.Value()==1),\n    pict_total: this.txtTotalPicture.Value(),\n    checkbox: (this.mode.Value()==3),\n    inExtGrid: this.columnVisibility.Value()=='extended',\n    orderbystatus: (Empty(this.contId.Value())?this.orderbystatus.Value():''),\n    orderbyidx: (!Empty(this.orderbystatus.Value())?this.orderbyidx.Value():0),\n    width: this.txtWid.Value(),\n    height: this.txtHid.Value(),\n    fixedwidth: this.txtFixedWidth.Value(),\n    align: this.align.Value(),\n    title_align: this.title_align.Value(),\n    font_size:this.txtFontSize.Value(),\n    font_weight:this.txtFontW.Value(),\n    font_color:this.txtFontColor.Value(),\n    bg_color:this.txtBckColor.Value(),\n    col_class:this.txtCssClass.Value(),\n    hidden:this.columnVisibility.Value()=='hidden',\n    editable:this.chkEditable.Value(),\n    tileModeGroupBy:(this.TileMode_Groupby.Value()=='initial' ? '' : this.TileMode_Groupby.Value() ),\n    tileBackgroundColor:this.TileBackground.Value(),\n    tileVersion:this.TileVersion.Value(),\n    tileVisibility:this.TileVisibility.Value(),\n    show_extra_title:this.chkExtraTitle.Value(),\n    onclick:this.txtOnClick.Value(),\n    synonyms:this.txtSynonyms.Value(),\n    sanitize:this.sanitize.Value(),\n    sanitize_tags:this.sanitize_tags.Value(),\n    printable:this.chkPrintable.Value()\n  };\n}\n\nfunction btnReset_2_Click(){\n  this.btnReset_Click();\n}\n\nfunction btnReset_Click(){\n  this.SetControlsValue();\n}\n\nfunction btnOk_Click(){\n  localData=this.getData();\n  GetOpener()[\"Set\"+this.type.Value()](this.columnid.Value(),this.getData(),this.contId.Value());\n  WindowClose();\n}\n\nfunction btnOk_2_Click(){\n  this.btnOk_Click();\n}\n\nfunction btnClose2_Click(){\n  this.btnClose_Click()\n}\n\nfunction btnClose_Click(){\n  \n  if(!EmptyString(localData.field) && this.Modified()){\n    if(window.confirm(\"Changes have not been saved yet.\\r\\nContinue loosing changes?\")){\n      WindowClose();\n    }\n  } else {\n    WindowClose();\n  }\n  \n}\n\nfunction HideHiddenColumn() {\n  this.columnVisibility.Hide();\n  this.labelVisibility.Hide();\n}\nfunction HideOrderby() {\n  this.orderbyidx.Hide();\n  this.orderbystatus.Hide();\n  this.lblOrderByIdx.Hide();\n  this.lblOrderbyStatus.Hide();\n}\n\nfunction HideWid() {\n  this.txtWid.Hide();\n  this.lblWid.Hide();\n  this.txtFixedWidth.Hide();\n  this.lblFixedWidth.Hide();  \n}\n\n\nfunction this_Loaded(){\n  this.txtField.Hide();\n  this.setData(GetOpener()[\"Get\"+this.type.Value()+\"ById\"](this.columnid.Value(),this.contId.Value()));\n  var col_font = jsColorPicker(\"#\"+this.txtFontColor.Ctrl_input.id, this.txtFontColor_btn.Ctrl.id, {\n      size: 1,\n      expires: 365, \n      noResize: true,\n      init: function(elm, val) {\n        Ctrl(elm).style.backgroundColor = val;\n      }.bind(this, this.txtFontColor_btn.Ctrl.id, this.txtFontColor.Ctrl_input.value)\n    });\n  var col_bck = jsColorPicker(\"#\"+this.txtBckColor.Ctrl_input.id, this.txtBckColor_btn.Ctrl.id, {\n      size: 1,\n      expires: 365, \n      noResize: true,\n      init: function(elm, val) {\n        Ctrl(elm).style.backgroundColor = val;\n      }.bind(this, this.txtBckColor_btn.Ctrl.id, this.txtBckColor.Ctrl_input.value)\n    });\n}\nthis.ZtTabs.showSlider(false);\n\n\nfunction txtLink_Gotfocus(){\n  this.txtLink.GetCtrl().classList.add(\"hyperlink_expanded\");\n}\n\nfunction txtLink_Lostfocus(){\n\tthis.txtLink.GetCtrl().classList.remove(\"hyperlink_expanded\");\n  if(this.txtLink.Value().search(\u002f\\n\u002fg) \u003e -1) {\n    alert(\"Line breaks are not allowed.\")\n    this.txtLink.SetFocus();\n  }\n}\n\nfunction txtTooltip_Gotfocus(){\n  this.txtTooltip.GetCtrl().classList.add(\"tooltip_expanded\");\n}\n\nfunction txtTooltip_Lostfocus(){\n\tthis.txtTooltip.GetCtrl().classList.remove(\"tooltip_expanded\");\n  if(this.txtTooltip.Value().search(\u002f\\n\u002fg) \u003e -1) {\n    alert(\"Line breaks are not allowed.\")\n    this.txtTooltip.SetFocus();\n  }\n}\n\nfunction txtSynonyms_Gotfocus(){\n  this.txtSynonyms.GetCtrl().classList.add(\"synonyms_expanded\");\n}\n\nfunction txtSynonyms_Lostfocus(){\n  this.txtSynonyms.GetCtrl().classList.remove(\"synonyms_expanded\");\n  if(this.txtSynonyms.Value().search(\u002f\\n\u002fg) \u003e -1) {\n    alert(\"Line breaks are not allowed.\")\n    this.txtSynonyms.SetFocus();\n  }\n}\n\n\n\nfunction txtCssClassPicker_Click(){\n GetOpener().openSPModalLayer(\"..\u002fclasseditor\u002fclassPicker.jsp?for=\"+this.txtCssClass.Ctrl_input.id+\"&mode=insert\", 0, 0, 300, 500, true, 1, false,false, window); \n}\n\nfunction txtCssClassEdit_Click(){\n GetOpener().openSPModalLayer(\"..\u002fclasseditor\u002fclassPicker.jsp?for=\"+this.txtCssClass.Ctrl_input.id+\"&mode=edit\", 0, 0, 300, 500, true, 1, false,false, window); \n}\n\nfunction txtCssClassAdd_Click(){\n  var mar_left = 50, width = ((GetOpener().frameElement && GetOpener().frameElement.clientWidth) ? (GetOpener().frameElement.clientWidth - mar_left*2) : 1124);\n  var mar_top = 25, height = ((GetOpener().frameElement && GetOpener().frameElement.clientHeight) ? (GetOpener().frameElement.clientHeight - mar_top*2) : 720);\n  var valto = this.txtCssClass.Ctrl_input.value.split(\" \");\n  var url = \"..\u002fclasseditor\u002feditor.jsp?name=\" + ((valto.length == 1) ? encodeURIComponent(valto[0]) : \"\");\n  GetOpener().openSPModalLayer(url, mar_top, mar_left, width, height, true, 1, false, false, window);\n}\n\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"portalstudio\u002fportalstudioTheme.css,properties.css","css_class":"","css_code":"[{\"type\":\"textbox\",\"name\":\"portalstudio_textbox\",\"selector\":\".portalstudio_textbox\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"resize: none;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"textbox\\\",\\\"class_name\\\":\\\"portalstudio_textbox\\\",\\\"selector\\\":\\\".portalstudio_textbox\\\",\\\"value\\\":\\\"Textbox text\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"code\\\":\\\"resize: none;\\\"}\",\"code\":\".portalstudio_textbox {\\n  resize: none;\\n}\\n\"},{\"type\":\"textbox\",\"name\":\"hyperlink_expanded\",\"selector\":\".hyperlink_expanded, .hyperlink_expanded textarea\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"height: 60px !important;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"textbox\\\",\\\"class_name\\\":\\\"hyperlink_expanded\\\",\\\"selector\\\":\\\".hyperlink_expanded, .hyperlink_expanded textarea\\\",\\\"value\\\":\\\"Textbox text\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"code\\\":\\\"height: 60px !important;\\\"}\",\"code\":\".hyperlink_expanded, .hyperlink_expanded textarea {\\n  background-color: #f3f3f3;\\n  height: 60px !important;\\n}\\n\"},{\"type\":\"textbox\",\"name\":\"tooltip_expanded\",\"selector\":\".tooltip_expanded, .tooltip_expanded textarea\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"code\\\":\\\"height: 60px !important;\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"value\\\"],\\\"type\\\":\\\"textbox\\\",\\\"class_name\\\":\\\"tooltip_expanded\\\",\\\"selector\\\":\\\".tooltip_expanded, .tooltip_expanded textarea\\\",\\\"value\\\":\\\"Textbox text\\\",\\\"h\\\":\\\"300\\\",\\\"w\\\":\\\"400\\\",\\\"class_Css\\\":\\\"label\\\",\\\"id\\\":\\\"form\\\",\\\"bg_color\\\":\\\"#f3f3f3\\\",\\\"code\\\":\\\"height: 60px !important;\\\"}\",\"code\":\".tooltip_expanded, .tooltip_expanded textarea {\\n  background-color: #f3f3f3;\\n  height: 60px !important;\\n}\\n\"},{\"type\":\"image\",\"name\":\"cursor_icon\",\"selector\":\".cursor_icon\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"cursor\\\":\\\"pointer\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\",\\\"src\\\"],\\\"type\\\":\\\"image\\\",\\\"class_name\\\":\\\"cursor_icon\\\",\\\"selector\\\":\\\".cursor_icon\\\",\\\"h\\\":\\\"240\\\",\\\"w\\\":\\\"480\\\",\\\"src\\\":\\\".\u002fimages\u002fdefault.jpg\\\",\\\"id\\\":\\\"form\\\",\\\"cursor\\\":\\\"pointer\\\"}\",\"code\":\".cursor_icon {\\n  cursor: pointer;\\n}\\n\"},{\"type\":\"box\",\"name\":\"box_colorpicker\",\"selector\":\".box_colorpicker\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"cursor\\\":\\\"pointer\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\",\\\"selector\\\"],\\\"type\\\":\\\"box\\\",\\\"class_name\\\":\\\"box_colorpicker\\\",\\\"selector\\\":\\\".box_colorpicker\\\",\\\"h\\\":\\\"120\\\",\\\"w\\\":\\\"240\\\",\\\"id\\\":\\\"form\\\",\\\"cursor\\\":\\\"pointer\\\"}\",\"code\":\".box_colorpicker {\\n  cursor: pointer;\\n}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"bg_color\":\"#f3f3f3\",\"code\":\"height: 60px !important;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"synonyms_expanded\",\"selector\":\".synonyms_expandedsynonyms_expanded, .synonyms_expanded textarea\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ txtTitle }}{{ lblSanitizeTags }}{{ lblSynonyms }}{{ label_bc }}{{ sanitize_tags }}{{ lblHid }}{{ txtBckColor_btn }}{{ sanitize }}{{ lblTitle }}{{ txtTooltip }}{{ lblHyperlink }}{{ lblOnClick }}{{ lblTarget }}{{ txtPicture }}{{ txtCssClass }}{{ lblTooltip }}{{ align }}{{ txtTitle_Tooltip }}{{ lblTotExp }}{{ lblTotDesc }}{{ lblTotPict }}{{ lblPicture }}{{ lblTitle_Tooltip }}{{ lblTile }}{{ title_align }}{{ lblOrderByIdx }}{{ lblOrderbyStatus }}{{ lblEditable }}{{ lblSecondaryBar }}{{ txtFontSize }}{{ txtFontW }}{{ txtFontColor }}{{ chkTotGroupby }}{{ mode }}{{ txtWid }}{{ txtTotalExp }}{{ txtFixedWidth }}{{ txtTotalDescr }}{{ txtTotalPicture }}{{ chkExtraTitle }}{{ chkEditable }}{{ columnVisibility }}{{ btnOk }}{{ btnReset }}{{ txtLink }}{{ txtOnClick }}{{ txtTarget }}{{ btnClose }}{{ btnClose2 }}{{ btnOk_2 }}{{ orderbystatus }}{{ btnReset_2 }}{{ labelTitle }}{{ image_help }}{{ labelTitle_2 }}{{ image_help_2 }}{{ orderbyidx }}{{ label40 }}{{ label_fs }}{{ label_fw }}{{ label_fc }}{{ label_css }}{{ lblWid }}{{ lblFixedWidth }}{{ lblAlign }}{{ lblTitleAlign }}{{ txtFontColor_btn }}{{ txtField }}{{ TileMode_Groupby }}{{ label67 }}{{ TileBackground }}{{ button69 }}{{ label72 }}{{ labelTileVisibility }}{{ TileVersion }}{{ TileVisibility }}{{ labelVisibility }}{{ txtCssClassEdit }}{{ txtCssClassPicker }}{{ txtCssClassAdd }}{{ txtHid }}{{ txtBckColor }}{{ txtSynonyms }}{{ lblSanitize }}{{ txtTitle }}{{ lblSanitizeTags }}{{ lblSynonyms }}{{ label_bc }}{{ sanitize_tags }}{{ lblHid }}{{ txtBckColor_btn }}{{ sanitize }}{{ lblTitle }}{{ txtTooltip }}{{ lblHyperlink }}{{ lblOnClick }}{{ lblTarget }}{{ txtPicture }}{{ txtCssClass }}{{ lblTooltip }}{{ align }}{{ txtTitle_Tooltip }}{{ lblTotExp }}{{ lblTotDesc }}{{ lblTotPict }}{{ lblPicture }}{{ lblTitle_Tooltip }}{{ lblTile }}{{ title_align }}{{ lblOrderByIdx }}{{ lblOrderbyStatus }}{{ lblEditable }}{{ lblSecondaryBar }}{{ txtFontSize }}{{ txtFontW }}{{ txtFontColor }}{{ chkTotGroupby }}{{ mode }}{{ txtWid }}{{ txtTotalExp }}{{ txtFixedWidth }}{{ txtTotalDescr }}{{ txtTotalPicture }}{{ chkExtraTitle }}{{ chkEditable }}{{ columnVisibility }}{{ btnOk }}{{ btnReset }}{{ txtLink }}{{ txtOnClick }}{{ txtTarget }}{{ btnClose }}{{ btnClose2 }}{{ btnOk_2 }}{{ orderbystatus }}{{ btnReset_2 }}{{ labelTitle }}{{ image_help }}{{ labelTitle_2 }}{{ image_help_2 }}{{ orderbyidx }}{{ label40 }}{{ label_fs }}{{ label_fw }}{{ label_fc }}{{ label_css }}{{ lblWid }}{{ lblFixedWidth }}{{ lblAlign }}{{ lblTitleAlign }}{{ txtFontColor_btn }}{{ txtField }}{{ TileMode_Groupby }}{{ label67 }}{{ TileBackground }}{{ button69 }}{{ label72 }}{{ labelTileVisibility }}{{ TileVersion }}{{ TileVisibility }}{{ labelVisibility }}{{ txtCssClassEdit }}{{ txtCssClassPicker }}{{ txtCssClassAdd }}{{ txtHid }}{{ txtBckColor }}{{ txtSynonyms }}{{ lblSanitize }}{{ lblEditable_Copy }}{{ txtTitle }}{{ lblSanitizeTags }}{{ lblSynonyms }}{{ label_bc }}{{ sanitize_tags }}{{ lblHid }}{{ txtBckColor_btn }}{{ sanitize }}{{ lblTitle }}{{ txtTooltip }}{{ lblHyperlink }}{{ lblOnClick }}{{ lblTarget }}{{ txtPicture }}{{ txtCssClass }}{{ lblTooltip }}{{ align }}{{ txtTitle_Tooltip }}{{ lblTotExp }}{{ lblTotDesc }}{{ lblTotPict }}{{ lblPicture }}{{ lblTitle_Tooltip }}{{ lblTile }}{{ title_align }}{{ lblOrderByIdx }}{{ lblOrderbyStatus }}{{ lblEditable }}{{ lblSecondaryBar }}{{ txtFontSize }}{{ txtFontW }}{{ txtFontColor }}{{ chkTotGroupby }}{{ mode }}{{ txtWid }}{{ txtTotalExp }}{{ txtFixedWidth }}{{ txtTotalDescr }}{{ txtTotalPicture }}{{ chkExtraTitle }}{{ chkEditable }}{{ columnVisibility }}{{ btnOk }}{{ btnReset }}{{ txtLink }}{{ txtOnClick }}{{ txtTarget }}{{ btnClose }}{{ btnClose2 }}{{ btnOk_2 }}{{ orderbystatus }}{{ btnReset_2 }}{{ labelTitle }}{{ image_help }}{{ labelTitle_2 }}{{ image_help_2 }}{{ orderbyidx }}{{ label40 }}{{ label_fs }}{{ label_fw }}{{ label_fc }}{{ label_css }}{{ lblWid }}{{ lblFixedWidth }}{{ lblAlign }}{{ lblTitleAlign }}{{ txtFontColor_btn }}{{ txtField }}{{ TileMode_Groupby }}{{ label67 }}{{ TileBackground }}{{ button69 }}{{ label72 }}{{ labelTileVisibility }}{{ TileVersion }}{{ TileVisibility }}{{ labelVisibility }}{{ txtCssClassEdit }}{{ txtCssClassPicker }}{{ txtCssClassAdd }}{{ txtHid }}{{ txtBckColor }}{{ txtSynonyms }}{{ lblSanitize }}{{ lblPrintable }}{{ chkEditable_Copy }}{{ @txtTitle }}{{ @lblSanitizeTags }}{{ @lblSynonyms }}{{ @label_bc }}{{ @sanitize_tags }}{{ @lblHid }}{{ @txtBckColor_btn }}{{ @sanitize }}{{ @lblTitle }}{{ @txtTooltip }}{{ @lblHyperlink }}{{ @lblOnClick }}{{ @lblTarget }}{{ @txtPicture }}{{ @txtCssClass }}{{ @lblTooltip }}{{ @align }}{{ @txtTitle_Tooltip }}{{ @lblTotExp }}{{ @lblTotDesc }}{{ @lblTotPict }}{{ @lblPicture }}{{ @lblTitle_Tooltip }}{{ @lblTile }}{{ @title_align }}{{ @lblOrderByIdx }}{{ @lblOrderbyStatus }}{{ @lblEditable }}{{ @lblSecondaryBar }}{{ @txtFontSize }}{{ @txtFontW }}{{ @txtFontColor }}{{ @chkTotGroupby }}{{ @mode }}{{ @txtWid }}{{ @txtTotalExp }}{{ @txtFixedWidth }}{{ @txtTotalDescr }}{{ @txtTotalPicture }}{{ @chkExtraTitle }}{{ @chkEditable }}{{ @columnVisibility }}{{ @btnOk }}{{ @btnReset }}{{ @txtLink }}{{ @txtOnClick }}{{ @txtTarget }}{{ @btnClose }}{{ @btnClose2 }}{{ @btnOk_2 }}{{ @orderbystatus }}{{ @btnReset_2 }}{{ @labelTitle }}{{ @image_help }}{{ @labelTitle_2 }}{{ @image_help_2 }}{{ @orderbyidx }}{{ @label40 }}{{ @label_fs }}{{ @label_fw }}{{ @label_fc }}{{ @label_css }}{{ @lblWid }}{{ @lblFixedWidth }}{{ @lblAlign }}{{ @lblTitleAlign }}{{ @txtFontColor_btn }}{{ @txtField }}{{ @TileMode_Groupby }}{{ @label67 }}{{ @TileBackground }}{{ @button69 }}{{ @label72 }}{{ @labelTileVisibility }}{{ @TileVersion }}{{ @TileVisibility }}{{ @labelVisibility }}{{ @txtCssClassEdit }}{{ @txtCssClassPicker }}{{ @txtCssClassAdd }}{{ @txtHid }}{{ @txtBckColor }}{{ @txtSynonyms }}{{ @lblSanitize }}{{ @lblPrintable }}{{ @chkPrintable }}\u003c\u002fbody\u003e","grapesCss":"","h":"560,560","hsl":"","htmlcode":"{{ @txtTitle }} \n{{ chkPrintable }}\n{{ lblPrintable }}\n{{ lblSanitizeTags }}\n{{ sanitize_tags }}\n{{ sanitize }}\n{{ lblSanitize }}\n{{ lblSynonyms }}\n{{ txtSynonyms }}\n{{ image_help }}\n{{ label_bc }}\n{{ txtBckColor_btn }}\n{{ txtBckColor }}\n{{ lblHid }}\n{{ txtHid }}\n{{ txtTitle }}\n{{ lblTitle }}\n{{ txtTooltip }}\n{{ lblHyperlink }}\n{{ lblOnClick }}\n{{ lblTarget }}\n{{ txtPicture }}\n{{ txtCssClass }}\n{{ lblTooltip }}\n{{ align }}\n{{ txtTitle_Tooltip }}\n{{ lblTotExp }}\n{{ lblTotDesc }}\n{{ lblTotPict }}\n{{ lblPicture }}\n{{ lblTitle_Tooltip }}\n{{ lblTile }}\n{{ title_align }}\n{{ lblOrderByIdx }}\n{{ lblOrderbyStatus }}\n{{ lblEditable }}\n{{ lblSecondaryBar }}\n{{ txtFontSize }}\n{{ txtFontW }}\n{{ txtFontColor }}\n{{ chkTotGroupby }}\n{{ mode }}\n{{ txtWid }}\n{{ txtTotalExp }}\n{{ txtFixedWidth }}\n{{ txtTotalDescr }}\n{{ txtTotalPicture }}\n{{ chkExtraTitle }}\n{{ chkEditable }}\n{{ columnVisibility }}\n{{ btnOk }}\n{{ btnReset }}\n{{ txtLink }}\n{{ txtOnClick }}\n{{ txtTarget }}\n{{ btnClose }}\n{{ btnClose2 }}\n{{ btnOk_2 }}\n{{ orderbystatus }}\n{{ btnReset_2 }}\n{{ columnid }}\n{{ type }}\n{{ labelTitle }}\n{{ txtFontColor_help }}\n{{ labelTitle_2 }}\n{{ image_help_2 }}\n{{ orderbyidx }}\n{{ contId }}\n{{ label40 }}\n{{ label_fs }}\n{{ label_fw }}\n{{ label_fc }}\n{{ label_css }}\n{{ lblWid }}\n{{ lblFixedWidth }}\n{{ lblAlign }}\n{{ lblTitleAlign }}\n{{ txtFontColor_btn }}\n{{ txtField }}\n{{ TileMode_Groupby }}\n{{ label67 }}\n{{ TileBackground }}\n{{ button69 }}\n{{ label72 }}\n{{ labelTileVisibility }}\n{{ TileVersion }}\n{{ TileVisibility }}\n{{ labelVisibility }}\n{{ txtCssClassEdit }}\n{{ txtCssClassPicker }}\n{{ txtCssClassAdd }}\n{{ @lblSanitizeTags }} \n{{ @lblSynonyms }} \n{{ @label_bc }} \n{{ @sanitize_tags }} \n{{ @lblHid }} \n{{ @txtBckColor_btn }} \n{{ @sanitize }} \n{{ @lblTitle }} \n{{ @txtTooltip }} \n{{ @lblHyperlink }} \n{{ @lblOnClick }} \n{{ @lblTarget }} \n{{ @txtPicture }} \n{{ @txtCssClass }} \n{{ @lblTooltip }} \n{{ @align }} \n{{ @txtTitle_Tooltip }} \n{{ @lblTotExp }} \n{{ @lblTotDesc }} \n{{ @lblTotPict }} \n{{ @lblPicture }} \n{{ @lblTitle_Tooltip }} \n{{ @lblTile }} \n{{ @title_align }} \n{{ @lblOrderByIdx }} \n{{ @lblOrderbyStatus }} \n{{ @lblEditable }} \n{{ @lblSecondaryBar }} \n{{ @txtFontSize }} \n{{ @txtFontW }} \n{{ @txtFontColor }} \n{{ @chkTotGroupby }} \n{{ @mode }} \n{{ @txtWid }} \n{{ @txtTotalExp }} \n{{ @txtFixedWidth }} \n{{ @txtTotalDescr }} \n{{ @txtTotalPicture }} \n{{ @chkExtraTitle }} \n{{ @chkEditable }} \n{{ @columnVisibility }} \n{{ @btnOk }} \n{{ @btnReset }} \n{{ @txtLink }} \n{{ @txtOnClick }} \n{{ @txtTarget }} \n{{ @btnClose }} \n{{ @btnClose2 }} \n{{ @btnOk_2 }} \n{{ @orderbystatus }} \n{{ @btnReset_2 }} \n{{ @labelTitle }} \n{{ @image_help }} \n{{ @labelTitle_2 }} \n{{ @image_help_2 }} \n{{ @orderbyidx }} \n{{ @label40 }} \n{{ @label_fs }} \n{{ @label_fw }} \n{{ @label_fc }} \n{{ @label_css }} \n{{ @lblWid }} \n{{ @lblFixedWidth }} \n{{ @lblAlign }} \n{{ @lblTitleAlign }} \n{{ @txtFontColor_btn }} \n{{ @txtField }} \n{{ @TileMode_Groupby }} \n{{ @label67 }} \n{{ @TileBackground }} \n{{ @button69 }} \n{{ @label72 }} \n{{ @labelTileVisibility }} \n{{ @TileVersion }} \n{{ @TileVisibility }} \n{{ @labelVisibility }} \n{{ @txtCssClassEdit }} \n{{ @txtCssClassPicker }} \n{{ @txtCssClassAdd }} \n{{ @txtHid }} \n{{ @txtBckColor }} \n{{ @txtSynonyms }} \n{{ @lblSanitize }} \n{{ @lblPrintable }} \n{{ @chkPrintable }} \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"","max_w":"","min_w":"","mode":"NORMAL","my_library":"portalstudio\u002fstyleVariables.js,portalstudio\u002fjscolor\u002fjscolor.js,portalstudio\u002fpsHelp.js","offline":"","on_security_failure":"login","page_layer":"","pages":"1,2","pagesProp":"[{\"title\":\"Main\",\"layer\":\"\",\"h\":\"560\",\"w\":\"100%\",\"layout_steps_values\":{}},{\"title\":\"Totalizer\",\"layer\":\"\",\"h\":\"560\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Main,Totalizer","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"portalstudioTabstrip","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"660","version":"37","w":"100%,100%","wizard":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Title of column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtTitle","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"1","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"45","y":"60","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"sanitize_tags","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblSanitizeTags","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Custom tags allowed:","w":"125","wireframe_props":"align,value,n_col","x":"490","y":"95","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtSynonyms","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblSynonyms","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Synonyms","w":"85","wireframe_props":"align,value,n_col","x":"45","y":"95","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_bc","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Background Color:","w":"108","wireframe_props":"align,value,n_col","x":"189","y":"480","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Custom tags allowed","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"sanitize_tags","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"18","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"125","wireframe_props":"name","x":"490","y":"115","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtWid","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblHid","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Height:","w":"125","wireframe_props":"align,value,n_col","x":"350","y":"205","zindex":"1","zone":""},{"anchor":"","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"txtBckColor_btn","page":"1","rapp":"","sequence":"6","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"302","y":"500","zindex":"0","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"Define sanitize mode of text (in HTML mode)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"sanitize","page":"1","picture":"","rapp":"","sequence":"7","spuid":"","tabindex":"17","textlist":"xssPrevent,none,custom","type":"Combobox","typevar":"character","valuelist":"xssPrevent,none,custom","visible":"true","w":"126","wireframe_props":"name,textlist","x":"350","y":"115","zindex":"10","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Title:","w":"90","wireframe_props":"align,value,n_col","x":"45","y":"40","zindex":"1","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Tooltip of column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtTooltip","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"true","sequence":"9","spuid":"","tabindex":"3","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"45","y":"170","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtLink","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblHyperlink","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Hyperlink:","w":"85","wireframe_props":"align,value,n_col","x":"350","y":"315","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtLink","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOnClick","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Onclick:","w":"85","wireframe_props":"align,value,n_col","x":"350","y":"480","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtTarget","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTarget","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Target:","w":"90","wireframe_props":"align,value,n_col","x":"350","y":"370","zindex":"1","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Picture of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtPicture","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"13","spuid":"","tabindex":"5","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"45","y":"280","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Css class to assign to column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtCssClass","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"14","spuid":"","tabindex":"6","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"190","wireframe_props":"name","x":"45","y":"335","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtTooltip","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTooltip","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tooltip:","w":"85","wireframe_props":"align,value,n_col","x":"45","y":"150","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"verdana","font_size":"","h":"20","help_tips":"Horizontal alignment of text","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"align","page":"1","picture":"","rapp":"","sequence":"16","spuid":"","tabindex":"10","textlist":"left,center,right","type":"Combobox","typevar":"character","valuelist":"left,center,right","visible":"true","w":"125","wireframe_props":"name,textlist","x":"45","y":"390","zindex":"1","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Tooltip of title","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtTitle_Tooltip","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"17","spuid":"","tabindex":"4","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"45","y":"225","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"txtTotalExp","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTotExp","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Total Exp:","w":"125","wireframe_props":"align,value,n_col","x":"35","y":"71","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtTotalDescr","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTotDesc","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"19","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Total title:","w":"125","wireframe_props":"align,value,n_col","x":"35","y":"125","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtTotalPicture","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTotPict","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Total pict:","w":"125","wireframe_props":"align,value,n_col","x":"340","y":"125","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtPicture","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblPicture","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Picture:","w":"85","wireframe_props":"align,value,n_col","x":"45","y":"260","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtTitle_Tooltip","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTitle_Tooltip","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Column Title Tooltip:","w":"133","wireframe_props":"align,value,n_col","x":"45","y":"205","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTile","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"23","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tile options:","w":"125","wireframe_props":"align,value,n_col","x":"35","y":"179","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"Horizontal alignment of title","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"title_align","page":"1","picture":"","rapp":"","sequence":"24","spuid":"","tabindex":"11","textlist":"left,center,right","type":"Combobox","typevar":"character","valuelist":"left,center,right","visible":"true","w":"125","wireframe_props":"name,textlist","x":"185","y":"390","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"orderbyidx","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOrderByIdx","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"25","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Sequence:","w":"125","wireframe_props":"align,value,n_col","x":"490","y":"425","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"orderbystatus","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblOrderbyStatus","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Orderby:","w":"125","wireframe_props":"align,value,n_col","x":"350","y":"425","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"chkEditable","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblEditable","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"27","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Editable:","w":"60","wireframe_props":"align,value,n_col","x":"490","y":"205","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"chkExtraTitle","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblSecondaryBar","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"28","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Secondary bar:","w":"125","wireframe_props":"align,value,n_col","x":"350","y":"260","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Size of text","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtFontSize","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"29","spuid":"","tabindex":"12","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"125","wireframe_props":"name","x":"45","y":"445","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"verdana","font_size":"","h":"20","help_tips":"Set the weight of text","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"txtFontW","page":"1","picture":"","rapp":"","sequence":"30","spuid":"","tabindex":"13","textlist":"normal,bold,italic","type":"Combobox","typevar":"character","valuelist":"normal,bold,italic","visible":"true","w":"125","wireframe_props":"name,textlist","x":"185","y":"445","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Set the color of text","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtFontColor","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"31","spuid":"","tabindex":"14","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"113","wireframe_props":"name","x":"45","y":"500","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"portalstudio_label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"check it if is a field to do groupby","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"Total groupby","layer":"false","layout_steps_values":"{}","name":"chkTotGroupby","page":"2","rapp":"","sequence":"32","spuid":"","style_type":"","tabindex":"33","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"222","wireframe_props":"label_text","x":"35","y":"42","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"verdana","font_size":"","h":"20","help_tips":"Set the type of content and his visualization mode (text, image, checkbox, text with first uppercase letters)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"mode","page":"1","picture":"","rapp":"","sequence":"33","spuid":"","tabindex":"16","textlist":"HTML,Image,Checkbox,InitLetter,initLetter2","type":"Combobox","typevar":"numeric","valuelist":"1,2,3,4,5","visible":"true","w":"265","wireframe_props":"name,textlist","x":"350","y":"60","zindex":"1","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Min width of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtWid","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"34","spuid":"","tabindex":"19","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"125","wireframe_props":"name","x":"350","y":"170","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Expression to do totalizer","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtTotalExp","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"35","spuid":"","tabindex":"34","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"570","wireframe_props":"name","x":"35","y":"91","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Max width of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtFixedWidth","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"36","spuid":"","tabindex":"20","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"125","wireframe_props":"name","x":"490","y":"170","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Title of Totalizer subgrid","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtTotalDescr","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"37","spuid":"","tabindex":"35","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"35","y":"146","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Title of Totalizer subgrid","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtTotalPicture","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"38","spuid":"","tabindex":"36","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"340","y":"146","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":"false","layout_steps_values":"{}","name":"chkExtraTitle","page":"1","rapp":"","sequence":"39","spuid":"","style_type":"","tabindex":"23","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"350","y":"280","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"check it if you want to edit field","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":"false","layout_steps_values":"{}","name":"chkEditable","page":"1","rapp":"","sequence":"40","spuid":"","style_type":"","tabindex":"22","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"490","y":"225","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"Set the importance of column (always visible, extended mode only or never)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"columnVisibility","page":"1","picture":"","rapp":"","sequence":"41","spuid":"","tabindex":"24","textlist":"Base,Extended,Hidden","type":"Combobox","typevar":"character","valuelist":"base,extended,hidden","visible":"true","w":"126","wireframe_props":"name,textlist","x":"490","y":"280","zindex":"10","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Confirm column and apply settings","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnOk","page":"1","rapp":"","sequence":"42","spuid":"","tabindex":"30","type":"Button","type_submit":"false","type_wizard":"","value":"Ok","w":"69","wireframe_props":"value","x":"405","y":"526","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Clear modified data","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnReset","page":"1","rapp":"","sequence":"43","spuid":"","tabindex":"31","type":"Button","type_submit":"false","type_wizard":"","value":"Reset","w":"69","wireframe_props":"value","x":"489","y":"526","zindex":"1","zone":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Hyperlink of column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtLink","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"true","sequence":"44","spuid":"","tabindex":"25","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"350","y":"335","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"OnClick function to call","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtOnClick","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"true","sequence":"45","spuid":"","tabindex":"29","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"350","y":"500","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Target of the column hyperlink","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtTarget","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"46","spuid":"","tabindex":"26","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"350","y":"390","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnClose","page":"1","rapp":"","sequence":"47","spuid":"","tabindex":"32","type":"Button","type_submit":"false","type_wizard":"","value":"Close","w":"69","wireframe_props":"value","x":"572","y":"526","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnClose2","page":"2","rapp":"","sequence":"48","spuid":"","tabindex":"38","type":"Button","type_submit":"false","type_wizard":"","value":"Close","w":"69","wireframe_props":"value","x":"573","y":"526","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Confirm column and apply settings on the grid","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnOk_2","page":"2","rapp":"","sequence":"49","spuid":"","tabindex":"36","type":"Button","type_submit":"false","type_wizard":"","value":"Ok","w":"69","wireframe_props":"value","x":"405","y":"526","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"verdana","font_size":"","h":"20","help_tips":"Set the orderby direction","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"orderbystatus","page":"1","picture":"","rapp":"","sequence":"50","spuid":"","tabindex":"27","textlist":"asc,desc","type":"Combobox","typevar":"character","valuelist":"asc,desc","visible":"true","w":"125","wireframe_props":"name,textlist","x":"350","y":"445","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"Clear modified data","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btnReset_2","page":"2","rapp":"","sequence":"51","spuid":"","tabindex":"37","type":"Button","type_submit":"false","type_wizard":"","value":"Reset","w":"69","wireframe_props":"value","x":"489","y":"526","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"columnid","page":"1","reactive":"","sequence":"52","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"-3","y":"-55"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"type","page":"1","reactive":"","sequence":"53","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"147","y":"-55"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"30","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"54","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Column settings:","w":"660","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f7;","font_image_hover":"","font_name":"iMobileIcon","font_size":"","h":"18","help_tips":"Help","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"","layer":"false","layout_steps_values":"{}","name":"image_help","page":"1","path_type":"fixed","rapp":"","sequence":"55","server_side":"","spuid":"","src":"..\u002fportalstudio\u002fimages\u002fhelp.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"630","y":"4","zindex":"1","zone":""},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"30","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelTitle_2","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"56","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Column settings:","w":"660","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f7;","font_image_hover":"","font_name":"iMobileIcon","font_size":"","h":"18","help_tips":"Help","hide":"false","hide_undercond":"","href":"javascript:Help('portalzoom_interfaccia_base_toolbar_config_col_totalizer')","img_type":"font icon","keep_proportions":"","layer":"false","layout_steps_values":"{}","name":"image_help_2","page":"2","path_type":"","rapp":"","sequence":"57","server_side":"","spuid":"","src":"..\u002fportalstudio\u002fimages\u002fhelp.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"18","wireframe_props":"","x":"630","y":"4","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"verdana","font_size":"","h":"20","help_tips":"Set the orderby position of column","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"orderbyidx","page":"1","picture":"","rapp":"","sequence":"58","spuid":"","tabindex":"28","textlist":"1,2,3,4,5","type":"Combobox","typevar":"numeric","valuelist":"1,2,3,4,5","visible":"true","w":"125","wireframe_props":"name,textlist","x":"490","y":"445","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"contId","page":"1","reactive":"","sequence":"59","server_side":"false","type":"Variable","typevar":"character","w":"133","x":"297","y":"-55"},{"align":"left","anchor":"","assoc_input":"mode","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label40","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"60","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"View mode:","w":"125","wireframe_props":"align,value,n_col","x":"350","y":"40","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontSize","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_fs","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"61","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Font Size:","w":"125","wireframe_props":"align,value,n_col","x":"45","y":"425","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontW","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_fw","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"62","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Font Weight:","w":"125","wireframe_props":"align,value,n_col","x":"185","y":"425","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtFontColor","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_fc","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"63","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Font Color:","w":"78","wireframe_props":"align,value,n_col","x":"45","y":"480","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtCssClass","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_css","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"64","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Css Class:","w":"85","wireframe_props":"align,value,n_col","x":"45","y":"315","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtWid","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblWid","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"65","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Min width:","w":"125","wireframe_props":"align,value,n_col","x":"350","y":"150","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"txtMaxWidth","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblFixedWidth","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"66","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Width:","w":"125","wireframe_props":"align,value,n_col","x":"490","y":"150","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"align","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAlign","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"67","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Align:","w":"125","wireframe_props":"align,value,n_col","x":"45","y":"370","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"align","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTitleAlign","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"68","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Title align:","w":"125","wireframe_props":"align,value,n_col","x":"185","y":"370","zindex":"1","zone":""},{"anchor":"","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"20","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"txtFontColor_btn","page":"1","rapp":"","sequence":"69","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"20","wireframe_props":"","x":"161","y":"500","zindex":"0","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtField","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"70","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"145","wireframe_props":"name","x":"475","y":"3","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","calculate":"","checked_value":"initial","create_undercond":"","css_class":"portalstudio_label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"Check to group all fields that depends on it","hide":"false","hide_undercond":"","init":"false","init_par":"'initial'","label_text":"View Group by Fields","layer":"false","layout_steps_values":"{}","name":"TileMode_Groupby","page":"2","rapp":"","sequence":"71","spuid":"","style_type":"","tabindex":"37","type":"Checkbox","typevar":"character","unchecked_value":"none","w":"210","wireframe_props":"label_text","x":"55","y":"205","zindex":"2","zone":""},{"align":"left","anchor":"","assoc_input":"TileBackground","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label67","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"72","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Background expr:","w":"127","wireframe_props":"align,value,n_col","x":"55","y":"240","zindex":"4","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Set a background color for tile","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"TileBackground","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"73","spuid":"","tabindex":"38","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"210","wireframe_props":"name","x":"55","y":"260","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"button69","page":"2","rapp":"","sequence":"74","spuid":"","tabindex":"-1","type":"Button","type_submit":"false","type_wizard":"","value":"?","w":"20","wireframe_props":"value","x":"269","y":"260","zindex":"6","zone":""},{"align":"left","anchor":"","assoc_input":"TileVersion","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label72","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"75","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Css class:","w":"125","wireframe_props":"align,value,n_col","x":"55","y":"287","zindex":"8","zone":""},{"align":"left","anchor":"","assoc_input":"TileVisibility","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelTileVisibility","nowrap":"false","page":"2","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"76","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Visibility:","w":"125","wireframe_props":"align,value,n_col","x":"55","y":"342","zindex":"8","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Set a custom css class of tile","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"TileVersion","page":"2","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"77","spuid":"","tabindex":"39","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"210","wireframe_props":"name","x":"55","y":"307","zerofilling":"false","zindex":"9","zone":"","zoom":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"22","help_tips":"Set the importance of groupby tile (always visible, extended mode only or never)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"TileVisibility","page":"2","picture":"","rapp":"","sequence":"78","spuid":"","tabindex":"40","textlist":"Base,Extended,Hidden","type":"Combobox","typevar":"character","valuelist":"base,extended,hidden","visible":"true","w":"210","wireframe_props":"name,textlist","x":"55","y":"363","zindex":"10","zone":""},{"align":"left","anchor":"","assoc_input":"columnVisibility","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"21","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelVisibility","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"79","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Visibility:","w":"125","wireframe_props":"align,value,n_col","x":"490","y":"260","zindex":"8","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"cursor_icon","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe603;","font_image_hover":"","font_name":"iMobileIcon","font_size":"16","h":"16","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"txtCssClassEdit","page":"1","path_type":"","rapp":"","sequence":"80","server_side":"","spuid":"","src":"","srchover":"","tabindex":"9","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"290","y":"335","zindex":"11","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"cursor_icon","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":" #00A0BD","font_color_hover":"","font_image":"&#xe6f6;","font_image_hover":"","font_name":"iMobileIcon","font_size":"16","h":"16","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"txtCssClassPicker","page":"1","path_type":"","rapp":"","sequence":"81","server_side":"","spuid":"","src":"","srchover":"","tabindex":"7","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"243","y":"335","zindex":"11","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"cursor_icon","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":" #00A0BD","font_color_hover":"","font_image":"&#xe605;","font_image_hover":"","font_name":"iMobileIcon","font_size":"16","h":"16","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"txtCssClassAdd","page":"1","path_type":"","rapp":"","sequence":"82","server_side":"","spuid":"","src":"","srchover":"","tabindex":"8","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"267","y":"335","zindex":"11","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Height of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtHid","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"83","spuid":"","tabindex":"21","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"125","wireframe_props":"name","x":"350","y":"225","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"Set background color of cell","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtBckColor","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"84","spuid":"","tabindex":"15","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"113","wireframe_props":"name","x":"185","y":"500","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"portalstudio_textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"","h":"20","help_tips":"List, comma separated, of synonyms","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"txtSynonyms","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"true","sequence":"85","spuid":"","tabindex":"2","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"265","wireframe_props":"name","x":"45","y":"115","zerofilling":"false","zindex":"5","zone":"","zoom":""},{"align":"left","anchor":"","assoc_input":"sanitize","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblSanitize","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"86","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Secure HTML:","w":"125","wireframe_props":"align,value,n_col","x":"350","y":"95","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"chkEditable","bg_color":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"18","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblPrintable","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"87","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Printable:","w":"60","wireframe_props":"align,value,n_col","x":"560","y":"205","zindex":"1","zone":""},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"13","help_tips":"check it if you want to print field","hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":"false","layout_steps_values":"{}","name":"chkPrintable","page":"1","rapp":"","sequence":"88","spuid":"","style_type":"","tabindex":"22","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"13","wireframe_props":"label_text","x":"560","y":"225","zindex":"1","zone":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:columnid,type,contId*/%>
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
window.SPPortalZoomColumnSettings_Static=function(){
if(typeof chkTotGroupby_onChange !='undefined')this.chkTotGroupby_onChange=chkTotGroupby_onChange;
if(typeof orderbystatus_onChange !='undefined')this.orderbystatus_onChange=orderbystatus_onChange;
if(typeof image_help_Click !='undefined')this.image_help_Click=image_help_Click;
if(typeof Modified !='undefined')this.Modified=Modified;
if(typeof setData !='undefined')this.setData=setData;
if(typeof SetControlsValue !='undefined')this.SetControlsValue=SetControlsValue;
if(typeof getData !='undefined')this.getData=getData;
if(typeof btnReset_2_Click !='undefined')this.btnReset_2_Click=btnReset_2_Click;
if(typeof btnReset_Click !='undefined')this.btnReset_Click=btnReset_Click;
if(typeof btnOk_Click !='undefined')this.btnOk_Click=btnOk_Click;
if(typeof btnOk_2_Click !='undefined')this.btnOk_2_Click=btnOk_2_Click;
if(typeof btnClose2_Click !='undefined')this.btnClose2_Click=btnClose2_Click;
if(typeof btnClose_Click !='undefined')this.btnClose_Click=btnClose_Click;
if(typeof HideHiddenColumn !='undefined')this.HideHiddenColumn=HideHiddenColumn;
if(typeof HideOrderby !='undefined')this.HideOrderby=HideOrderby;
if(typeof HideWid !='undefined')this.HideWid=HideWid;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof txtLink_Gotfocus !='undefined')this.txtLink_Gotfocus=txtLink_Gotfocus;
if(typeof txtLink_Lostfocus !='undefined')this.txtLink_Lostfocus=txtLink_Lostfocus;
if(typeof txtTooltip_Gotfocus !='undefined')this.txtTooltip_Gotfocus=txtTooltip_Gotfocus;
if(typeof txtTooltip_Lostfocus !='undefined')this.txtTooltip_Lostfocus=txtTooltip_Lostfocus;
if(typeof txtSynonyms_Gotfocus !='undefined')this.txtSynonyms_Gotfocus=txtSynonyms_Gotfocus;
if(typeof txtSynonyms_Lostfocus !='undefined')this.txtSynonyms_Lostfocus=txtSynonyms_Lostfocus;
if(typeof txtCssClassPicker_Click !='undefined')this.txtCssClassPicker_Click=txtCssClassPicker_Click;
if(typeof txtCssClassEdit_Click !='undefined')this.txtCssClassEdit_Click=txtCssClassEdit_Click;
if(typeof txtCssClassAdd_Click !='undefined')this.txtCssClassAdd_Click=txtCssClassAdd_Click;
this.this_Calc=function(){
<%if(!Library.Empty(PageletId) ){%>
  this.PageletCalc();
<%}%>
  this.EnablePage(1);
  this.EnablePage(2);
}
this.EnablePage(1);
this.EnablePage(2);
function chkTotGroupby_onChange(){
  if (this.chkTotGroupby.Value()==true){
    this.txtTotalExp.Disabled()
    this.txtTotalDescr.Disabled()
  } else {
    this.txtTotalDescr.Enabled()
    this.txtTotalExp.Enabled()
  }
}
function orderbystatus_onChange(){
  if (this.orderbystatus.Value()=='')
	this.orderbyidx.Disabled()
  else
    this.orderbyidx.Enabled()
}
function image_help_Click(event){
  let pnr = GetOpener();
  if (pnr && pnr.Help) {
   pnr.Help('portalzoom_interfaccia_base_toolbar_config_col_main');
  }
}
var emptyData={
  field:'',
  title:'',
  isImage:false,
  isInitLetter:false,
  isInitLetter2:false,
  link:'',
  target:'',
  tooltip:'',
  title_tooltip:'',
  picture:'',
  width:'',
  maxwidth:'',
  fixedwidth:'',
  height:'',
  groupby:false,
  exp:'',
  descr:'',
  enable_HTML:false,
  pict_total:'',
  checkbox:false,
  inExtGrid:false,
  orderbystatus:'',
  orderbyidx:0,
  align:'',
  font_size:'',
  font_weight:'',
  font_color:'',
  bg_color:'',
  col_class:'',
  hidden:false,
  editable:false,
  title_align:'',
  tileModeGroupBy:'',
  tileBackgroundColor:'',
  tileVersion:'',
  tileVisibility:'base',
  onclick:'',
  printable:true
};
var localData=emptyData;
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
  if(!EmptyString(localData.field) && this.Modified()){
    if(!window.confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
      return;
    }
  }
  //clono dati e poi imposto i default
  localData=LibJavascript.JSONUtils.adjust(JSON.parse(JSON.stringify(dati)),emptyData);
  localData.orderbyidx=(dati.orderbystatus && dati.orderbyidx>0?dati.orderbyidx:dati.maxorderbyidx||0);
  if(!Empty(localData.maxwidth) && localData.maxwidth==localData.width)
    localData.fixedwidth=localData.width;
//   localData={
//     field: dati.field,
//     title: dati.title,
//     isImage: dati.isImage,
//     link: dati.link,
//     target: dati.target,
//     tooltip: dati.tooltip,
//     title_tooltip: dati.title_tooltip,
//     picture: dati.picture,
//     groupby: dati.groupby,
//     exp: dati.exp,
//     descr: dati.descr,
//     enable_HTML: dati.enable_HTML,
//     pict_total: dati.pict_total,
//     checkbox: dati.checkbox,
//     inExtGrid: dati.inExtGrid,
//     orderbyidx: (dati.orderbystatus && dati.orderbyidx>0?dati.orderbyidx:dati.maxorderbyidx||0),
//     orderbystatus: dati.orderbystatus,
//     width: dati.width,
//     maxwidth: dati.maxwidth,
//     align: dati.align,
//     font_size:dati.font_size,
//     font_weight:dati.font_weight,
//     font_color:dati.font_color,
//     col_class:dati.col_class,
//     hidden:dati.hidden,
// 	  tileMode:dati.tileMode,
//   	tileModeGroupBy:dati.tileModeGroupBy,
//   	tileBackgroundColor:dati.tileBackgroundColor
//   }
  this.SetControlsValue();
}
function SetControlsValue(){
  if (Left(localData.field,5)=='html:') {
  	this.txtField.Value(Substr(localData.field,6));
    this.txtField.Show();
  } else {
  	this.labelTitle.Value("Column settings: "+localData.field);
  	this.labelTitle_2.Value("Column settings: "+localData.field);
  }
  this.txtTitle.Value(localData.title);
  //this.chkImage.Value(localData.image);
  this.txtLink.Value(localData.link);
  this.txtTarget.Value(localData.target);
  this.txtTooltip.Value(localData.tooltip);
  this.txtTitle_Tooltip.Value(localData.title_tooltip);
  this.txtPicture.Value(localData.picture);
  this.chkTotGroupby.Value(localData.groupby);
  this.txtTotalExp.Value(localData.exp);
  this.txtTotalDescr.Value(localData.descr);
  //this.chkIsHTML.Value(localData.enableHTML);
  this.txtTotalPicture.Value(localData.pict_total);
  this.txtSynonyms.Value(localData.synonyms);
  //this.chkCheckbox.Value(localData.checkbox);
  if (localData.isImage)
    this.mode.Value(2);
  else if (localData.checkbox)
    this.mode.Value(3);
  else if (localData.enable_HTML)
    this.mode.Value(1);
  else if (localData.isInitLetter)
    this.mode.Value(4);
   else if (localData.isInitLetter2)
     this.mode.Value(5);
  else
    this.mode.Value(0);
  this.sanitize.Value(localData.sanitize);
  this.sanitize_tags.Value(localData.sanitize_tags);
  if (this.type.Value()=="Column" && Empty(this.contId.Value()) && !(localData.checkbox || localData.type=='M')) {
    this.orderbystatus.Value(localData.orderbystatus);
    this.orderbyidx.Value(localData.orderbyidx);
    this.orderbystatus_onChange();
  } else {
    this.HideOrderby();
    this.HideWid();
  }
  if (this.type.Value()!="Column") {
//     this.HideHiddenColumn()
    this.ZtTabs.Hide(2,true)
  }
  this.txtWid.Value(localData.width);
  this.txtHid.Value(localData.height);
  this.txtFixedWidth.Value(localData.fixedwidth);
  this.align.Value(localData.align);
  this.title_align.Value(localData.title_align)
  if (Left(localData.field,5) == 'html:') {
  	this.mode.Disabled();
  }
  this.txtFontSize.Value(localData.font_size);
  this.txtFontW.Value(localData.font_weight);
  this.txtFontColor.Value(localData.font_color);
  this.txtBckColor.Value(localData.bg_color);
  this.txtCssClass.Value(localData.col_class);
  this.columnVisibility.Value( localData.hidden ? 'hidden' : ( localData.inExtGrid ? 'extended': 'base' ) );
  this.chkEditable.Value(localData.editable);
  this.TileMode_Groupby.Value(localData.tileModeGroupBy||'initial');
  this.TileBackground.Value(localData.tileBackgroundColor);
  this.TileVersion.Value(localData.tileVersion);
  this.TileVisibility.Value(localData.tileVisibility);
  this.chkExtraTitle.Value(localData.show_extra_title);
  this.txtOnClick.Value(localData.onclick);
	this.chkPrintable.Value(localData.printable);
}
function getData(){
  if (Left(localData.field,5) == 'html:') {
    localData.field = 'html:' + this.txtField.Value();
  }
  return {
    field: localData.field,
    title: this.txtTitle.Value(),
    isImage: (this.mode.Value()==2),
    isInitLetter: (this.mode.Value()==4),
    isInitLetter2: (this.mode.Value()==5),
    link: this.txtLink.Value(),
    target: this.txtTarget.Value(),
    tooltip: this.txtTooltip.Value(),
    title_tooltip: this.txtTitle_Tooltip.Value(),
    picture: this.txtPicture.Value(),
    groupby: this.chkTotGroupby.Value(),
    exp: this.txtTotalExp.Value(),
    descr: this.txtTotalDescr.Value(),
    enable_HTML: (this.mode.Value()==1),
    pict_total: this.txtTotalPicture.Value(),
    checkbox: (this.mode.Value()==3),
    inExtGrid: this.columnVisibility.Value()=='extended',
    orderbystatus: (Empty(this.contId.Value())?this.orderbystatus.Value():''),
    orderbyidx: (!Empty(this.orderbystatus.Value())?this.orderbyidx.Value():0),
    width: this.txtWid.Value(),
    height: this.txtHid.Value(),
    fixedwidth: this.txtFixedWidth.Value(),
    align: this.align.Value(),
    title_align: this.title_align.Value(),
    font_size:this.txtFontSize.Value(),
    font_weight:this.txtFontW.Value(),
    font_color:this.txtFontColor.Value(),
    bg_color:this.txtBckColor.Value(),
    col_class:this.txtCssClass.Value(),
    hidden:this.columnVisibility.Value()=='hidden',
    editable:this.chkEditable.Value(),
    tileModeGroupBy:(this.TileMode_Groupby.Value()=='initial' ? '' : this.TileMode_Groupby.Value() ),
    tileBackgroundColor:this.TileBackground.Value(),
    tileVersion:this.TileVersion.Value(),
    tileVisibility:this.TileVisibility.Value(),
    show_extra_title:this.chkExtraTitle.Value(),
    onclick:this.txtOnClick.Value(),
    synonyms:this.txtSynonyms.Value(),
    sanitize:this.sanitize.Value(),
    sanitize_tags:this.sanitize_tags.Value(),
    printable:this.chkPrintable.Value()
  };
}
function btnReset_2_Click(){
  this.btnReset_Click();
}
function btnReset_Click(){
  this.SetControlsValue();
}
function btnOk_Click(){
  localData=this.getData();
  GetOpener()["Set"+this.type.Value()](this.columnid.Value(),this.getData(),this.contId.Value());
  WindowClose();
}
function btnOk_2_Click(){
  this.btnOk_Click();
}
function btnClose2_Click(){
  this.btnClose_Click()
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
function HideHiddenColumn() {
  this.columnVisibility.Hide();
  this.labelVisibility.Hide();
}
function HideOrderby() {
  this.orderbyidx.Hide();
  this.orderbystatus.Hide();
  this.lblOrderByIdx.Hide();
  this.lblOrderbyStatus.Hide();
}
function HideWid() {
  this.txtWid.Hide();
  this.lblWid.Hide();
  this.txtFixedWidth.Hide();
  this.lblFixedWidth.Hide();  
}
function this_Loaded(){
  this.txtField.Hide();
  this.setData(GetOpener()["Get"+this.type.Value()+"ById"](this.columnid.Value(),this.contId.Value()));
  var col_font = jsColorPicker("#"+this.txtFontColor.Ctrl_input.id, this.txtFontColor_btn.Ctrl.id, {
      size: 1,
      expires: 365, 
      noResize: true,
      init: function(elm, val) {
        Ctrl(elm).style.backgroundColor = val;
      }.bind(this, this.txtFontColor_btn.Ctrl.id, this.txtFontColor.Ctrl_input.value)
    });
  var col_bck = jsColorPicker("#"+this.txtBckColor.Ctrl_input.id, this.txtBckColor_btn.Ctrl.id, {
      size: 1,
      expires: 365, 
      noResize: true,
      init: function(elm, val) {
        Ctrl(elm).style.backgroundColor = val;
      }.bind(this, this.txtBckColor_btn.Ctrl.id, this.txtBckColor.Ctrl_input.value)
    });
}
this.ZtTabs.showSlider(false);
function txtLink_Gotfocus(){
  this.txtLink.GetCtrl().classList.add("hyperlink_expanded");
}
function txtLink_Lostfocus(){
	this.txtLink.GetCtrl().classList.remove("hyperlink_expanded");
  if(this.txtLink.Value().search(/\n/g) > -1) {
    alert("Line breaks are not allowed.")
    this.txtLink.SetFocus();
  }
}
function txtTooltip_Gotfocus(){
  this.txtTooltip.GetCtrl().classList.add("tooltip_expanded");
}
function txtTooltip_Lostfocus(){
	this.txtTooltip.GetCtrl().classList.remove("tooltip_expanded");
  if(this.txtTooltip.Value().search(/\n/g) > -1) {
    alert("Line breaks are not allowed.")
    this.txtTooltip.SetFocus();
  }
}
function txtSynonyms_Gotfocus(){
  this.txtSynonyms.GetCtrl().classList.add("synonyms_expanded");
}
function txtSynonyms_Lostfocus(){
  this.txtSynonyms.GetCtrl().classList.remove("synonyms_expanded");
  if(this.txtSynonyms.Value().search(/\n/g) > -1) {
    alert("Line breaks are not allowed.")
    this.txtSynonyms.SetFocus();
  }
}
function txtCssClassPicker_Click(){
 GetOpener().openSPModalLayer("../classeditor/classPicker.jsp?for="+this.txtCssClass.Ctrl_input.id+"&mode=insert", 0, 0, 300, 500, true, 1, false,false, window); 
}
function txtCssClassEdit_Click(){
 GetOpener().openSPModalLayer("../classeditor/classPicker.jsp?for="+this.txtCssClass.Ctrl_input.id+"&mode=edit", 0, 0, 300, 500, true, 1, false,false, window); 
}
function txtCssClassAdd_Click(){
  var mar_left = 50, width = ((GetOpener().frameElement && GetOpener().frameElement.clientWidth) ? (GetOpener().frameElement.clientWidth - mar_left*2) : 1124);
  var mar_top = 25, height = ((GetOpener().frameElement && GetOpener().frameElement.clientHeight) ? (GetOpener().frameElement.clientHeight - mar_top*2) : 720);
  var valto = this.txtCssClass.Ctrl_input.value.split(" ");
  var url = "../classeditor/editor.jsp?name=" + ((valto.length == 1) ? encodeURIComponent(valto[0]) : "");
  GetOpener().openSPModalLayer(url, mar_top, mar_left, width, height, true, 1, false, false, window);
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
.SPPortalZoomColumnSettings_container .portalstudio_textbox{  resize: none;
}
.SPPortalZoomColumnSettings_container .hyperlink_expanded, .hyperlink_expanded textarea{
  background-color: #f3f3f3;
  height: 60px !important;
}
.SPPortalZoomColumnSettings_container .tooltip_expanded, .tooltip_expanded textarea{
  background-color: #f3f3f3;
  height: 60px !important;
}
.SPPortalZoomColumnSettings_container .cursor_icon{
  cursor: pointer;
}
.SPPortalZoomColumnSettings_container .box_colorpicker{
  cursor: pointer;
}
.SPPortalZoomColumnSettings_container .synonyms_expandedsynonyms_expanded, .synonyms_expanded textarea{
  background-color: #f3f3f3;
  height: 60px !important;
}
.SPPortalZoomColumnSettings_container {
}
.SPPortalZoomColumnSettings_portlet{
  position:relative;
  min-width:660px;
  height:560px;
  background-color:#F3F3F3;
}
.SPPortalZoomColumnSettings_portlet[Data-page="1"]{
  height:560px;
  width:100%;
}
.SPPortalZoomColumnSettings_portlet[Data-page="2"]{
  height:560px;
  width:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:45px;
  right:350px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTitle_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTitle_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSanitizeTags_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:95px;
  left:490px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSanitizeTags_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSanitizeTags_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSynonyms_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:95px;
  left:45px;
  width:85px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSynonyms_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSynonyms_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_bc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:480px;
  left:189px;
  width:108px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_bc_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_bc_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .sanitize_tags_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:115px;
  left:490px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .sanitize_tags_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .sanitize_tags_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblHid_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:205px;
  left:350px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblHid_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblHid_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtBckColor_btn_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:500px;
  left:302px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtBckColor_btn_ctrl {
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtBckColor_btn_ctrl > .box_content {
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtBckColor_btn_ctrl {
  min-height:20px;
  border-width:1px;
  border-style:solid;
  border-color:#00A0BD;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .sanitize_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:115px;
  left:350px;
  width:126px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:45px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitle_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTooltip_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:170px;
  left:45px;
  right:350px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTooltip_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTooltip_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblHyperlink_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:315px;
  left:350px;
  width:85px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblHyperlink_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblHyperlink_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOnClick_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:480px;
  left:350px;
  width:85px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOnClick_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOnClick_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTarget_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:370px;
  left:350px;
  width:90px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTarget_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTarget_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtPicture_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:280px;
  left:45px;
  right:350px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtPicture_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtPicture_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClass_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:335px;
  left:45px;
  width:190px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClass_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClass_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTooltip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:150px;
  left:45px;
  width:85px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTooltip_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTooltip_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .align_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:390px;
  left:45px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTitle_Tooltip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:225px;
  left:45px;
  right:350px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTitle_Tooltip_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTitle_Tooltip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotExp_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:71px;
  left:35px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotExp_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotExp_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotDesc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:125px;
  left:35px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotDesc_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotDesc_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotPict_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:125px;
  left:340px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotPict_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTotPict_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblPicture_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:260px;
  left:45px;
  width:85px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblPicture_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblPicture_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitle_Tooltip_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:205px;
  left:45px;
  width:133px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitle_Tooltip_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitle_Tooltip_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:179px;
  left:35px;
  width:125px;
  height:auto;
  min-height:19px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTile_ctrl {
  height:auto;
  min-height:19px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTile_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .title_align_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:390px;
  left:185px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOrderByIdx_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:425px;
  left:490px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOrderByIdx_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOrderByIdx_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOrderbyStatus_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:425px;
  left:350px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOrderbyStatus_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblOrderbyStatus_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblEditable_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:205px;
  left:490px;
  width:60px;
  height:auto;
  min-height:18px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblEditable_ctrl {
  height:auto;
  min-height:18px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblEditable_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSecondaryBar_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:260px;
  left:350px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSecondaryBar_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSecondaryBar_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontSize_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:445px;
  left:45px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontSize_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontSize_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontW_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:445px;
  left:185px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontColor_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:500px;
  left:45px;
  width:113px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontColor_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontColor_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .chkTotGroupby_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:35px;
  width:222px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .mode_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:350px;
  width:265px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtWid_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:170px;
  left:350px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtWid_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtWid_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalExp_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:91px;
  left:35px;
  right:55px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalExp_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalExp_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFixedWidth_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:170px;
  left:490px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFixedWidth_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFixedWidth_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalDescr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:146px;
  left:35px;
  right:360px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalDescr_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalDescr_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalPicture_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:146px;
  left:340px;
  right:55px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalPicture_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTotalPicture_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .chkExtraTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:280px;
  left:350px;
  width:13px;
  height:13px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .chkEditable_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:225px;
  left:490px;
  width:13px;
  height:13px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .columnVisibility_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:280px;
  left:490px;
  width:126px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnOk_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  right:186px;
  width:69px;
  height:24px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnOk_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnReset_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  right:102px;
  width:69px;
  height:24px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnReset_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtLink_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:335px;
  left:350px;
  right:45px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtLink_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtLink_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtOnClick_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:500px;
  left:350px;
  right:45px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtOnClick_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtOnClick_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTarget_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:390px;
  left:350px;
  right:45px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTarget_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtTarget_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnClose_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  right:19px;
  width:69px;
  height:24px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnClose_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnClose2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  right:18px;
  width:69px;
  height:24px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnClose2_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnOk_2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  right:186px;
  width:69px;
  height:24px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnOk_2_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .orderbystatus_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:445px;
  left:350px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnReset_2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:526px;
  right:102px;
  width:69px;
  height:24px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .btnReset_2_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTitle_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:30px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTitle_ctrl {
  height:auto;
  min-height:30px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTitle_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .image_help_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  right:12px;
  width:18px;
  height:18px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .image_help_ctrl {
  text-decoration:none;
  font-family:iMobileIcon;
  text-align:center;
  line-height:18px;
  font-size:18px;
  color:#00A0BD;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTitle_2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:30px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTitle_2_ctrl {
  height:auto;
  min-height:30px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTitle_2_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .image_help_2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:4px;
  right:12px;
  width:18px;
  height:18px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .image_help_2_ctrl {
  text-decoration:none;
  font-family:iMobileIcon;
  text-align:center;
  line-height:18px;
  font-size:18px;
  color:#00A0BD;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .orderbyidx_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:445px;
  left:490px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label40_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:350px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label40_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label40_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fs_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:425px;
  left:45px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fs_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fs_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fw_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:425px;
  left:185px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fw_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fw_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:480px;
  left:45px;
  width:78px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fc_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_fc_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_css_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:315px;
  left:45px;
  width:85px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_css_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label_css_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblWid_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:150px;
  left:350px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblWid_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblWid_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblFixedWidth_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:150px;
  left:490px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblFixedWidth_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblFixedWidth_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblAlign_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:370px;
  left:45px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblAlign_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblAlign_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitleAlign_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:370px;
  left:185px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitleAlign_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblTitleAlign_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontColor_btn_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:500px;
  left:161px;
  width:20px;
  height:auto;
  min-height:20px;
  display:flex;
  flex-direction:column;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontColor_btn_ctrl {
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontColor_btn_ctrl > .box_content {
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtFontColor_btn_ctrl {
  min-height:20px;
  border-width:1px;
  border-style:solid;
  border-color:#00A0BD;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtField_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:3px;
  left:475px;
  width:145px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtField_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtField_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileMode_Groupby_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:205px;
  left:55px;
  width:210px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label67_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:240px;
  left:55px;
  width:127px;
  height:auto;
  min-height:21px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label67_ctrl {
  height:auto;
  min-height:21px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label67_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileBackground_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:260px;
  left:55px;
  width:210px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileBackground_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileBackground_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .button69_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:260px;
  left:269px;
  width:20px;
  height:20px;
  display:none;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .button69_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label72_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:287px;
  left:55px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label72_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .label72_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTileVisibility_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:342px;
  left:55px;
  width:125px;
  height:auto;
  min-height:21px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTileVisibility_ctrl {
  height:auto;
  min-height:21px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelTileVisibility_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileVersion_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:307px;
  left:55px;
  width:210px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileVersion_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileVersion_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .TileVisibility_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:363px;
  left:55px;
  width:210px;
  height:22px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelVisibility_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:260px;
  left:490px;
  width:125px;
  height:auto;
  min-height:21px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelVisibility_ctrl {
  height:auto;
  min-height:21px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .labelVisibility_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClassEdit_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:335px;
  left:290px;
  width:16px;
  height:16px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClassEdit_ctrl {
  text-decoration:none;
  font-family:iMobileIcon;
  text-align:center;
  line-height:16px;
  font-size:16px;
  color:#00A0BD;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClassPicker_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:335px;
  left:243px;
  width:16px;
  height:16px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClassPicker_ctrl {
  text-decoration:none;
  font-family:iMobileIcon;
  text-align:center;
  line-height:16px;
  font-size:16px;
  color:#00A0BD;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClassAdd_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:335px;
  left:267px;
  width:16px;
  height:16px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtCssClassAdd_ctrl {
  text-decoration:none;
  font-family:iMobileIcon;
  text-align:center;
  line-height:16px;
  font-size:16px;
  color:#00A0BD;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtHid_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:225px;
  left:350px;
  width:125px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtHid_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtHid_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtBckColor_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:500px;
  left:185px;
  width:113px;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtBckColor_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtBckColor_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtSynonyms_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:115px;
  left:45px;
  right:350px;
  width:auto;
  height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtSynonyms_ctrl {
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .txtSynonyms_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSanitize_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:95px;
  left:350px;
  width:125px;
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSanitize_ctrl {
  height:auto;
  min-height:20px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblSanitize_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblPrintable_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:205px;
  left:560px;
  width:60px;
  height:auto;
  min-height:18px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblPrintable_ctrl {
  height:auto;
  min-height:18px;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .lblPrintable_ctrl {
  overflow:hidden;
  text-align:left;
}
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .chkPrintable_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:225px;
  left:560px;
  width:13px;
  height:13px;
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
 String def="[{\"h\":\"560,560\",\"layout_steps_values\":{},\"pages_names\":\"Main,Totalizer\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"660\",\"w\":\"100%,100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTitle\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"45\",\"y\":\"60\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblSanitizeTags\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Custom tags allowed:\",\"w\":\"125\",\"x\":\"490\",\"y\":\"95\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblSynonyms\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Synonyms\",\"w\":\"85\",\"x\":\"45\",\"y\":\"95\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_bc\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Background Color:\",\"w\":\"108\",\"x\":\"189\",\"y\":\"480\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sanitize_tags\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"490\",\"y\":\"115\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblHid\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Height:\",\"w\":\"125\",\"x\":\"350\",\"y\":\"205\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtBckColor_btn\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"302\",\"y\":\"500\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"sanitize\",\"page\":\"1\",\"textlist\":\"xssPrevent,none,custom\",\"type\":\"Combobox\",\"w\":\"126\",\"x\":\"350\",\"y\":\"115\",\"zindex\":\"10\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTitle\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Title:\",\"w\":\"90\",\"x\":\"45\",\"y\":\"40\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTooltip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"45\",\"y\":\"170\",\"zindex\":\"5\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblHyperlink\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Hyperlink:\",\"w\":\"85\",\"x\":\"350\",\"y\":\"315\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOnClick\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Onclick:\",\"w\":\"85\",\"x\":\"350\",\"y\":\"480\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTarget\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Target:\",\"w\":\"90\",\"x\":\"350\",\"y\":\"370\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtPicture\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"45\",\"y\":\"280\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtCssClass\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"190\",\"x\":\"45\",\"y\":\"335\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTooltip\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tooltip:\",\"w\":\"85\",\"x\":\"45\",\"y\":\"150\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"align\",\"page\":\"1\",\"textlist\":\"left,center,right\",\"type\":\"Combobox\",\"w\":\"125\",\"x\":\"45\",\"y\":\"390\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTitle_Tooltip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"45\",\"y\":\"225\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTotExp\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Total Exp:\",\"w\":\"125\",\"x\":\"35\",\"y\":\"71\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTotDesc\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Total title:\",\"w\":\"125\",\"x\":\"35\",\"y\":\"125\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTotPict\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Total pict:\",\"w\":\"125\",\"x\":\"340\",\"y\":\"125\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblPicture\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Picture:\",\"w\":\"85\",\"x\":\"45\",\"y\":\"260\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTitle_Tooltip\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Column Title Tooltip:\",\"w\":\"133\",\"x\":\"45\",\"y\":\"205\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTile\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Tile options:\",\"w\":\"125\",\"x\":\"35\",\"y\":\"179\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"title_align\",\"page\":\"1\",\"textlist\":\"left,center,right\",\"type\":\"Combobox\",\"w\":\"125\",\"x\":\"185\",\"y\":\"390\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOrderByIdx\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Sequence:\",\"w\":\"125\",\"x\":\"490\",\"y\":\"425\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblOrderbyStatus\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Orderby:\",\"w\":\"125\",\"x\":\"350\",\"y\":\"425\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblEditable\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Editable:\",\"w\":\"60\",\"x\":\"490\",\"y\":\"205\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblSecondaryBar\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Secondary bar:\",\"w\":\"125\",\"x\":\"350\",\"y\":\"260\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtFontSize\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"45\",\"y\":\"445\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtFontW\",\"page\":\"1\",\"textlist\":\"normal,bold,italic\",\"type\":\"Combobox\",\"w\":\"125\",\"x\":\"185\",\"y\":\"445\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtFontColor\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"45\",\"y\":\"500\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Total groupby\",\"layout_steps_values\":{},\"name\":\"chkTotGroupby\",\"page\":\"2\",\"type\":\"Checkbox\",\"w\":\"222\",\"x\":\"35\",\"y\":\"42\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"mode\",\"page\":\"1\",\"textlist\":\"HTML,Image,Checkbox,InitLetter,initLetter2\",\"type\":\"Combobox\",\"w\":\"265\",\"x\":\"350\",\"y\":\"60\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtWid\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"350\",\"y\":\"170\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTotalExp\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"570\",\"x\":\"35\",\"y\":\"91\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtFixedWidth\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"490\",\"y\":\"170\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTotalDescr\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"35\",\"y\":\"146\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTotalPicture\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"340\",\"y\":\"146\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkExtraTitle\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"350\",\"y\":\"280\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkEditable\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"490\",\"y\":\"225\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"columnVisibility\",\"page\":\"1\",\"textlist\":\"Base,Extended,Hidden\",\"type\":\"Combobox\",\"w\":\"126\",\"x\":\"490\",\"y\":\"280\",\"zindex\":\"10\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnOk\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Ok\",\"w\":\"69\",\"x\":\"405\",\"y\":\"526\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnReset\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Reset\",\"w\":\"69\",\"x\":\"489\",\"y\":\"526\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtLink\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"350\",\"y\":\"335\",\"zindex\":\"5\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtOnClick\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"350\",\"y\":\"500\",\"zindex\":\"5\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtTarget\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"350\",\"y\":\"390\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnClose\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Close\",\"w\":\"69\",\"x\":\"572\",\"y\":\"526\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnClose2\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"Close\",\"w\":\"69\",\"x\":\"573\",\"y\":\"526\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnOk_2\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"Ok\",\"w\":\"69\",\"x\":\"405\",\"y\":\"526\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"orderbystatus\",\"page\":\"1\",\"textlist\":\"asc,desc\",\"type\":\"Combobox\",\"w\":\"125\",\"x\":\"350\",\"y\":\"445\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnReset_2\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"Reset\",\"w\":\"69\",\"x\":\"489\",\"y\":\"526\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"columnid\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"-3\",\"y\":\"-55\"},{\"h\":\"22\",\"name\":\"type\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"147\",\"y\":\"-55\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"30\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelTitle\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Column settings:\",\"w\":\"660\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"image_help\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"630\",\"y\":\"4\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"30\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelTitle_2\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Column settings:\",\"w\":\"660\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"18\",\"layout_steps_values\":{},\"name\":\"image_help_2\",\"page\":\"2\",\"type\":\"Image\",\"w\":\"18\",\"x\":\"630\",\"y\":\"4\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"orderbyidx\",\"page\":\"1\",\"textlist\":\"1,2,3,4,5\",\"type\":\"Combobox\",\"w\":\"125\",\"x\":\"490\",\"y\":\"445\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"contId\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"133\",\"x\":\"297\",\"y\":\"-55\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label40\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"View mode:\",\"w\":\"125\",\"x\":\"350\",\"y\":\"40\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_fs\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Font Size:\",\"w\":\"125\",\"x\":\"45\",\"y\":\"425\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_fw\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Font Weight:\",\"w\":\"125\",\"x\":\"185\",\"y\":\"425\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_fc\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Font Color:\",\"w\":\"78\",\"x\":\"45\",\"y\":\"480\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_css\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Css Class:\",\"w\":\"85\",\"x\":\"45\",\"y\":\"315\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblWid\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Min width:\",\"w\":\"125\",\"x\":\"350\",\"y\":\"150\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblFixedWidth\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Width:\",\"w\":\"125\",\"x\":\"490\",\"y\":\"150\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAlign\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Align:\",\"w\":\"125\",\"x\":\"45\",\"y\":\"370\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTitleAlign\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Title align:\",\"w\":\"125\",\"x\":\"185\",\"y\":\"370\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtFontColor_btn\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"20\",\"x\":\"161\",\"y\":\"500\",\"zindex\":\"0\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtField\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"145\",\"x\":\"475\",\"y\":\"3\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"View Group by Fields\",\"layout_steps_values\":{},\"name\":\"TileMode_Groupby\",\"page\":\"2\",\"type\":\"Checkbox\",\"w\":\"210\",\"x\":\"55\",\"y\":\"205\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label67\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Background expr:\",\"w\":\"127\",\"x\":\"55\",\"y\":\"240\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"TileBackground\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"210\",\"x\":\"55\",\"y\":\"260\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"button69\",\"page\":\"2\",\"type\":\"Button\",\"value\":\"?\",\"w\":\"20\",\"x\":\"269\",\"y\":\"260\",\"zindex\":\"6\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label72\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Css class:\",\"w\":\"125\",\"x\":\"55\",\"y\":\"287\",\"zindex\":\"8\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelTileVisibility\",\"page\":\"2\",\"type\":\"Label\",\"value\":\"Visibility:\",\"w\":\"125\",\"x\":\"55\",\"y\":\"342\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"TileVersion\",\"page\":\"2\",\"type\":\"Textbox\",\"w\":\"210\",\"x\":\"55\",\"y\":\"307\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"TileVisibility\",\"page\":\"2\",\"textlist\":\"Base,Extended,Hidden\",\"type\":\"Combobox\",\"w\":\"210\",\"x\":\"55\",\"y\":\"363\",\"zindex\":\"10\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"21\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelVisibility\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Visibility:\",\"w\":\"125\",\"x\":\"490\",\"y\":\"260\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"16\",\"layout_steps_values\":{},\"name\":\"txtCssClassEdit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"290\",\"y\":\"335\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"16\",\"layout_steps_values\":{},\"name\":\"txtCssClassPicker\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"243\",\"y\":\"335\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"16\",\"layout_steps_values\":{},\"name\":\"txtCssClassAdd\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"267\",\"y\":\"335\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtHid\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"125\",\"x\":\"350\",\"y\":\"225\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtBckColor\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"113\",\"x\":\"185\",\"y\":\"500\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"txtSynonyms\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"265\",\"x\":\"45\",\"y\":\"115\",\"zindex\":\"5\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblSanitize\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Secure HTML:\",\"w\":\"125\",\"x\":\"350\",\"y\":\"95\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"18\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblPrintable\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Printable:\",\"w\":\"60\",\"x\":\"560\",\"y\":\"205\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"label_text\":\"\",\"layout_steps_values\":{},\"name\":\"chkPrintable\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"560\",\"y\":\"225\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomColumnSettings","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomColumnSettings_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>
.SPPortalZoomColumnSettings_portlet > .SPPortalZoomColumnSettings_page > .button69_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("portalstudio/portalstudioTheme.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("properties.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("properties.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomColumnSettings','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String txtTitle= "";
if(request.getAttribute("SPPortalZoomColumnSettings_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblSanitizeTags= "Custom tags allowed:";
String lblSynonyms= "Synonyms";
String label_bc= "Background Color:";
String sanitize_tags= "";
String lblHid= "Height:";
String sanitize= "";
String lblTitle= "Title:";
String txtTooltip= "";
String lblHyperlink= "Hyperlink:";
String lblOnClick= "Onclick:";
String lblTarget= "Target:";
String txtPicture= "";
String txtCssClass= "";
String lblTooltip= "Tooltip:";
String align= "";
String txtTitle_Tooltip= "";
String lblTotExp= "Total Exp:";
String lblTotDesc= "Total title:";
String lblTotPict= "Total pict:";
String lblPicture= "Picture:";
String lblTitle_Tooltip= "Column Title Tooltip:";
String lblTile= "Tile options:";
String title_align= "";
String lblOrderByIdx= "Sequence:";
String lblOrderbyStatus= "Orderby:";
String lblEditable= "Editable:";
String lblSecondaryBar= "Secondary bar:";
String txtFontSize= "";
String txtFontW= "";
String txtFontColor= "";
boolean chkTotGroupby=false;
double mode= 0;
String txtWid= "";
String txtTotalExp= "";
String txtFixedWidth= "";
String txtTotalDescr= "";
String txtTotalPicture= "";
boolean chkExtraTitle=false;
boolean chkEditable=false;
String columnVisibility= "";
String txtLink= "";
String txtOnClick= "";
String txtTarget= "";
String orderbystatus= "";
String columnid=JSPLib.translateXSS(sp.getParameter("columnid",""));
String type=JSPLib.translateXSS(sp.getParameter("type",""));
String labelTitle= "Column settings:";
String labelTitle_2= "Column settings:";
double orderbyidx= 0;
String contId=JSPLib.translateXSS(sp.getParameter("contId",""));
String label40= "View mode:";
String label_fs= "Font Size:";
String label_fw= "Font Weight:";
String label_fc= "Font Color:";
String label_css= "Css Class:";
String lblWid= "Min width:";
String lblFixedWidth= "Width:";
String lblAlign= "Align:";
String lblTitleAlign= "Title align:";
String txtField= "";
String TileMode_Groupby="initial";
String label67= "Background expr:";
String TileBackground= "";
String label72= "Css class:";
String labelTileVisibility= "Visibility:";
String TileVersion= "";
String TileVisibility= "";
String labelVisibility= "Visibility:";
String txtHid= "";
String txtBckColor= "";
String txtSynonyms= "";
String lblSanitize= "Secure HTML:";
String lblPrintable= "Printable:";
boolean chkPrintable=false;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_tabcontainer' style='position:relative;'></div>
<div id='<%=idPortlet%>_container' class='SPPortalZoomColumnSettings_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomColumnSettings_portlet portlet'Data-page='1' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomColumnSettings','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_page_1' class='SPPortalZoomColumnSettings_page' style='display:block'>
<span class='textbox-container'id='<%=idPortlet%>_txtTitle_wrp'><input id='<%=idPortlet%>_txtTitle' name='txtTitle' type='text' class='portalstudio_textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='txtTitle' /></span>
<label id='<%=idPortlet%>_lblSanitizeTags' for='<%=idPortlet%>_sanitize_tags' formid='<%=idPortlet%>' ps-name='lblSanitizeTags'    class='portalstudio_label lblSanitizeTags_ctrl'><div id='<%=idPortlet%>_lblSanitizeTagstbl' style='width:100%;'><%=JSPLib.ToHTML("Custom tags allowed:")%></div></label>
<label id='<%=idPortlet%>_lblSynonyms' for='<%=idPortlet%>_txtSynonyms' formid='<%=idPortlet%>' ps-name='lblSynonyms'    class='portalstudio_label lblSynonyms_ctrl'><div id='<%=idPortlet%>_lblSynonymstbl' style='width:100%;'><%=JSPLib.ToHTML("Synonyms")%></div></label>
<label id='<%=idPortlet%>_label_bc' for='<%=idPortlet%>_txtFontColor' formid='<%=idPortlet%>' ps-name='label_bc'    class='portalstudio_label label_bc_ctrl'><div id='<%=idPortlet%>_label_bctbl' style='width:100%;'><%=JSPLib.ToHTML("Background Color:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_sanitize_tags_wrp'><input id='<%=idPortlet%>_sanitize_tags' name='sanitize_tags' type='text' class='portalstudio_textbox' tabindex='18' formid='<%=idPortlet%>' ps-name='sanitize_tags' /></span>
<label id='<%=idPortlet%>_lblHid' for='<%=idPortlet%>_txtWid' formid='<%=idPortlet%>' ps-name='lblHid'    class='portalstudio_label lblHid_ctrl'><div id='<%=idPortlet%>_lblHidtbl' style='width:100%;'><%=JSPLib.ToHTML("Height:")%></div></label>
<div id='<%=idPortlet%>_txtBckColor_btn' class='txtBckColor_btn_ctrl SPSection_expanded box_colorpicker' data-original-display='flex'><div id='<%=idPortlet%>_txtBckColor_btn_td' class='box_content'></div>
</div>
<select id='<%=idPortlet%>_sanitize' name='sanitize' class='combobox' title=<%=JSPLib.ToHTMLValue("Define sanitize mode of text (in HTML mode)" )%> style='' tabindex='17'></select>
<label id='<%=idPortlet%>_lblTitle' for='<%=idPortlet%>_txtTitle' formid='<%=idPortlet%>' ps-name='lblTitle'    class='portalstudio_label lblTitle_ctrl'><div id='<%=idPortlet%>_lblTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Title:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_txtTooltip_wrp'><textarea id='<%=idPortlet%>_txtTooltip' name='txtTooltip' type='text' class='portalstudio_textbox' tabindex='3' formid='<%=idPortlet%>' ps-name='txtTooltip'    ></textarea></span>
<label id='<%=idPortlet%>_lblHyperlink' for='<%=idPortlet%>_txtLink' formid='<%=idPortlet%>' ps-name='lblHyperlink'    class='portalstudio_label lblHyperlink_ctrl'><div id='<%=idPortlet%>_lblHyperlinktbl' style='width:100%;'><%=JSPLib.ToHTML("Hyperlink:")%></div></label>
<label id='<%=idPortlet%>_lblOnClick' for='<%=idPortlet%>_txtLink' formid='<%=idPortlet%>' ps-name='lblOnClick'    class='portalstudio_label lblOnClick_ctrl'><div id='<%=idPortlet%>_lblOnClicktbl' style='width:100%;'><%=JSPLib.ToHTML("Onclick:")%></div></label>
<label id='<%=idPortlet%>_lblTarget' for='<%=idPortlet%>_txtTarget' formid='<%=idPortlet%>' ps-name='lblTarget'    class='portalstudio_label lblTarget_ctrl'><div id='<%=idPortlet%>_lblTargettbl' style='width:100%;'><%=JSPLib.ToHTML("Target:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_txtPicture_wrp'><input id='<%=idPortlet%>_txtPicture' name='txtPicture' type='text' class='portalstudio_textbox' tabindex='5' formid='<%=idPortlet%>' ps-name='txtPicture' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtCssClass_wrp'><input id='<%=idPortlet%>_txtCssClass' name='txtCssClass' type='text' class='portalstudio_textbox' tabindex='6' formid='<%=idPortlet%>' ps-name='txtCssClass' /></span>
<label id='<%=idPortlet%>_lblTooltip' for='<%=idPortlet%>_txtTooltip' formid='<%=idPortlet%>' ps-name='lblTooltip'    class='portalstudio_label lblTooltip_ctrl'><div id='<%=idPortlet%>_lblTooltiptbl' style='width:100%;'><%=JSPLib.ToHTML("Tooltip:")%></div></label>
<select id='<%=idPortlet%>_align' name='align' class='portalstudio_combobox' title=<%=JSPLib.ToHTMLValue("Horizontal alignment of text" )%> style='font-family:verdana;' tabindex='10'></select>
<span class='textbox-container'id='<%=idPortlet%>_txtTitle_Tooltip_wrp'><input id='<%=idPortlet%>_txtTitle_Tooltip' name='txtTitle_Tooltip' type='text' class='portalstudio_textbox' tabindex='4' formid='<%=idPortlet%>' ps-name='txtTitle_Tooltip' /></span>
<label id='<%=idPortlet%>_lblPicture' for='<%=idPortlet%>_txtPicture' formid='<%=idPortlet%>' ps-name='lblPicture'    class='portalstudio_label lblPicture_ctrl'><div id='<%=idPortlet%>_lblPicturetbl' style='width:100%;'><%=JSPLib.ToHTML("Picture:")%></div></label>
<label id='<%=idPortlet%>_lblTitle_Tooltip' for='<%=idPortlet%>_txtTitle_Tooltip' formid='<%=idPortlet%>' ps-name='lblTitle_Tooltip'    class='portalstudio_label lblTitle_Tooltip_ctrl'><div id='<%=idPortlet%>_lblTitle_Tooltiptbl' style='width:100%;'><%=JSPLib.ToHTML("Column Title Tooltip:")%></div></label>
<select id='<%=idPortlet%>_title_align' name='title_align' class='portalstudio_combobox' title=<%=JSPLib.ToHTMLValue("Horizontal alignment of title" )%> style='' tabindex='11'></select>
<label id='<%=idPortlet%>_lblOrderByIdx' for='<%=idPortlet%>_orderbyidx' formid='<%=idPortlet%>' ps-name='lblOrderByIdx'    class='portalstudio_label lblOrderByIdx_ctrl'><div id='<%=idPortlet%>_lblOrderByIdxtbl' style='width:100%;'><%=JSPLib.ToHTML("Sequence:")%></div></label>
<label id='<%=idPortlet%>_lblOrderbyStatus' for='<%=idPortlet%>_orderbystatus' formid='<%=idPortlet%>' ps-name='lblOrderbyStatus'    class='portalstudio_label lblOrderbyStatus_ctrl'><div id='<%=idPortlet%>_lblOrderbyStatustbl' style='width:100%;'><%=JSPLib.ToHTML("Orderby:")%></div></label>
<label id='<%=idPortlet%>_lblEditable' for='<%=idPortlet%>_chkEditable' formid='<%=idPortlet%>' ps-name='lblEditable'    class='portalstudio_label lblEditable_ctrl'><div id='<%=idPortlet%>_lblEditabletbl' style='width:100%;'><%=JSPLib.ToHTML("Editable:")%></div></label>
<label id='<%=idPortlet%>_lblSecondaryBar' for='<%=idPortlet%>_chkExtraTitle' formid='<%=idPortlet%>' ps-name='lblSecondaryBar'    class='portalstudio_label lblSecondaryBar_ctrl'><div id='<%=idPortlet%>_lblSecondaryBartbl' style='width:100%;'><%=JSPLib.ToHTML("Secondary bar:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_txtFontSize_wrp'><input id='<%=idPortlet%>_txtFontSize' name='txtFontSize' type='text' class='portalstudio_textbox' tabindex='12' formid='<%=idPortlet%>' ps-name='txtFontSize' /></span>
<select id='<%=idPortlet%>_txtFontW' name='txtFontW' class='portalstudio_combobox' title=<%=JSPLib.ToHTMLValue("Set the weight of text" )%> style='font-family:verdana;' tabindex='13'></select>
<span class='textbox-container'id='<%=idPortlet%>_txtFontColor_wrp'><input id='<%=idPortlet%>_txtFontColor' name='txtFontColor' type='text' class='portalstudio_textbox' tabindex='14' formid='<%=idPortlet%>' ps-name='txtFontColor' /></span>
<select id='<%=idPortlet%>_mode' name='mode' class='portalstudio_combobox' title=<%=JSPLib.ToHTMLValue("Set the type of content and his visualization mode (text, image, checkbox, text with first uppercase letters)" )%> style='font-family:verdana;' tabindex='16'></select>
<span class='textbox-container'id='<%=idPortlet%>_txtWid_wrp'><input id='<%=idPortlet%>_txtWid' name='txtWid' type='text' class='portalstudio_textbox' tabindex='19' formid='<%=idPortlet%>' ps-name='txtWid' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtFixedWidth_wrp'><input id='<%=idPortlet%>_txtFixedWidth' name='txtFixedWidth' type='text' class='portalstudio_textbox' tabindex='20' formid='<%=idPortlet%>' ps-name='txtFixedWidth' /></span>
<input id='<%=idPortlet%>_chkExtraTitle' tabindex=23 name='chkExtraTitle' class='checkbox' type='checkbox' style=''/>
<input id='<%=idPortlet%>_chkEditable' tabindex=22 name='chkEditable' class='checkbox' title=<%=JSPLib.ToHTMLValue("check it if you want to edit field" )%> type='checkbox' style=''/>
<select id='<%=idPortlet%>_columnVisibility' name='columnVisibility' class='combobox' title=<%=JSPLib.ToHTMLValue("Set the importance of column (always visible, extended mode only or never)" )%> style='' tabindex='24'></select>
<input id='<%=idPortlet%>_btnOk' type='button' class='portalstudio_button btnOk_ctrl' tabindex='30'/>
<input id='<%=idPortlet%>_btnReset' type='button' class='portalstudio_button black btnReset_ctrl' tabindex='31'/>
<span class='textbox-container'id='<%=idPortlet%>_txtLink_wrp'><textarea id='<%=idPortlet%>_txtLink' name='txtLink' type='text' class='portalstudio_textbox' tabindex='25' formid='<%=idPortlet%>' ps-name='txtLink'    ></textarea></span>
<span class='textbox-container'id='<%=idPortlet%>_txtOnClick_wrp'><textarea id='<%=idPortlet%>_txtOnClick' name='txtOnClick' type='text' class='portalstudio_textbox' tabindex='29' formid='<%=idPortlet%>' ps-name='txtOnClick'    ></textarea></span>
<span class='textbox-container'id='<%=idPortlet%>_txtTarget_wrp'><input id='<%=idPortlet%>_txtTarget' name='txtTarget' type='text' class='portalstudio_textbox' tabindex='26' formid='<%=idPortlet%>' ps-name='txtTarget' /></span>
<input id='<%=idPortlet%>_btnClose' type='button' class='portalstudio_button black btnClose_ctrl' tabindex='32'/>
<select id='<%=idPortlet%>_orderbystatus' name='orderbystatus' class='combobox' title=<%=JSPLib.ToHTMLValue("Set the orderby direction" )%> style='font-family:verdana;' tabindex='27'></select>
<span id='<%=idPortlet%>_labelTitle'  formid='<%=idPortlet%>' ps-name='labelTitle'    class='portalstudio_title labelTitle_ctrl'><div id='<%=idPortlet%>_labelTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Column settings:")%></div></span>
<a id='<%=idPortlet%>_image_help' class='image image_help_ctrl'  href='javascript:void(0)' target='_self'>&#xe6f7;</a>
<select id='<%=idPortlet%>_orderbyidx' name='orderbyidx' class='combobox' title=<%=JSPLib.ToHTMLValue("Set the orderby position of column" )%> style='font-family:verdana;' tabindex='28'></select>
<label id='<%=idPortlet%>_label40' for='<%=idPortlet%>_mode' formid='<%=idPortlet%>' ps-name='label40'    class='portalstudio_label label40_ctrl'><div id='<%=idPortlet%>_label40tbl' style='width:100%;'><%=JSPLib.ToHTML("View mode:")%></div></label>
<label id='<%=idPortlet%>_label_fs' for='<%=idPortlet%>_txtFontSize' formid='<%=idPortlet%>' ps-name='label_fs'    class='portalstudio_label label_fs_ctrl'><div id='<%=idPortlet%>_label_fstbl' style='width:100%;'><%=JSPLib.ToHTML("Font Size:")%></div></label>
<label id='<%=idPortlet%>_label_fw' for='<%=idPortlet%>_txtFontW' formid='<%=idPortlet%>' ps-name='label_fw'    class='portalstudio_label label_fw_ctrl'><div id='<%=idPortlet%>_label_fwtbl' style='width:100%;'><%=JSPLib.ToHTML("Font Weight:")%></div></label>
<label id='<%=idPortlet%>_label_fc' for='<%=idPortlet%>_txtFontColor' formid='<%=idPortlet%>' ps-name='label_fc'    class='portalstudio_label label_fc_ctrl'><div id='<%=idPortlet%>_label_fctbl' style='width:100%;'><%=JSPLib.ToHTML("Font Color:")%></div></label>
<label id='<%=idPortlet%>_label_css' for='<%=idPortlet%>_txtCssClass' formid='<%=idPortlet%>' ps-name='label_css'    class='portalstudio_label label_css_ctrl'><div id='<%=idPortlet%>_label_csstbl' style='width:100%;'><%=JSPLib.ToHTML("Css Class:")%></div></label>
<label id='<%=idPortlet%>_lblWid' for='<%=idPortlet%>_txtWid' formid='<%=idPortlet%>' ps-name='lblWid'    class='portalstudio_label lblWid_ctrl'><div id='<%=idPortlet%>_lblWidtbl' style='width:100%;'><%=JSPLib.ToHTML("Min width:")%></div></label>
<label id='<%=idPortlet%>_lblFixedWidth'  formid='<%=idPortlet%>' ps-name='lblFixedWidth'    class='portalstudio_label lblFixedWidth_ctrl'><div id='<%=idPortlet%>_lblFixedWidthtbl' style='width:100%;'><%=JSPLib.ToHTML("Width:")%></div></label>
<label id='<%=idPortlet%>_lblAlign' for='<%=idPortlet%>_align' formid='<%=idPortlet%>' ps-name='lblAlign'    class='portalstudio_label lblAlign_ctrl'><div id='<%=idPortlet%>_lblAligntbl' style='width:100%;'><%=JSPLib.ToHTML("Align:")%></div></label>
<label id='<%=idPortlet%>_lblTitleAlign' for='<%=idPortlet%>_align' formid='<%=idPortlet%>' ps-name='lblTitleAlign'    class='portalstudio_label lblTitleAlign_ctrl'><div id='<%=idPortlet%>_lblTitleAligntbl' style='width:100%;'><%=JSPLib.ToHTML("Title align:")%></div></label>
<div id='<%=idPortlet%>_txtFontColor_btn' class='txtFontColor_btn_ctrl SPSection_expanded box_colorpicker' data-original-display='flex'><div id='<%=idPortlet%>_txtFontColor_btn_td' class='box_content'></div>
</div>
<span class='textbox-container'id='<%=idPortlet%>_txtField_wrp'><input id='<%=idPortlet%>_txtField' name='txtField' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='txtField' /></span>
<label id='<%=idPortlet%>_labelVisibility' for='<%=idPortlet%>_columnVisibility' formid='<%=idPortlet%>' ps-name='labelVisibility'    class='portalstudio_label labelVisibility_ctrl'><div id='<%=idPortlet%>_labelVisibilitytbl' style='width:100%;'><%=JSPLib.ToHTML("Visibility:")%></div></label>
<a id='<%=idPortlet%>_txtCssClassEdit' class='cursor_icon txtCssClassEdit_ctrl'   target=''>&#xe603;</a>
<a id='<%=idPortlet%>_txtCssClassPicker' class='cursor_icon txtCssClassPicker_ctrl'   target=''>&#xe6f6;</a>
<a id='<%=idPortlet%>_txtCssClassAdd' class='cursor_icon txtCssClassAdd_ctrl'   target=''>&#xe605;</a>
<span class='textbox-container'id='<%=idPortlet%>_txtHid_wrp'><input id='<%=idPortlet%>_txtHid' name='txtHid' type='text' class='portalstudio_textbox' tabindex='21' formid='<%=idPortlet%>' ps-name='txtHid' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtBckColor_wrp'><input id='<%=idPortlet%>_txtBckColor' name='txtBckColor' type='text' class='portalstudio_textbox' tabindex='15' formid='<%=idPortlet%>' ps-name='txtBckColor' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtSynonyms_wrp'><textarea id='<%=idPortlet%>_txtSynonyms' name='txtSynonyms' type='text' class='portalstudio_textbox' tabindex='2' formid='<%=idPortlet%>' ps-name='txtSynonyms'    ></textarea></span>
<label id='<%=idPortlet%>_lblSanitize' for='<%=idPortlet%>_sanitize' formid='<%=idPortlet%>' ps-name='lblSanitize'    class='portalstudio_label lblSanitize_ctrl'><div id='<%=idPortlet%>_lblSanitizetbl' style='width:100%;'><%=JSPLib.ToHTML("Secure HTML:")%></div></label>
<label id='<%=idPortlet%>_lblPrintable' for='<%=idPortlet%>_chkEditable' formid='<%=idPortlet%>' ps-name='lblPrintable'    class='portalstudio_label lblPrintable_ctrl'><div id='<%=idPortlet%>_lblPrintabletbl' style='width:100%;'><%=JSPLib.ToHTML("Printable:")%></div></label>
<input id='<%=idPortlet%>_chkPrintable' tabindex=22 name='chkPrintable' class='checkbox' title=<%=JSPLib.ToHTMLValue("check it if you want to print field" )%> type='checkbox' style=''/>
</div>
<div id='<%=idPortlet%>_page_2' class='SPPortalZoomColumnSettings_page' style='display:none'>
<label id='<%=idPortlet%>_lblTotExp' for='<%=idPortlet%>_txtTotalExp' formid='<%=idPortlet%>' ps-name='lblTotExp'    class='portalstudio_label lblTotExp_ctrl'><div id='<%=idPortlet%>_lblTotExptbl' style='width:100%;'><%=JSPLib.ToHTML("Total Exp:")%></div></label>
<label id='<%=idPortlet%>_lblTotDesc' for='<%=idPortlet%>_txtTotalDescr' formid='<%=idPortlet%>' ps-name='lblTotDesc'    class='portalstudio_label lblTotDesc_ctrl'><div id='<%=idPortlet%>_lblTotDesctbl' style='width:100%;'><%=JSPLib.ToHTML("Total title:")%></div></label>
<label id='<%=idPortlet%>_lblTotPict' for='<%=idPortlet%>_txtTotalPicture' formid='<%=idPortlet%>' ps-name='lblTotPict'    class='portalstudio_label lblTotPict_ctrl'><div id='<%=idPortlet%>_lblTotPicttbl' style='width:100%;'><%=JSPLib.ToHTML("Total pict:")%></div></label>
<span id='<%=idPortlet%>_lblTile'  formid='<%=idPortlet%>' ps-name='lblTile'    class='portalstudio_label lblTile_ctrl'><div id='<%=idPortlet%>_lblTiletbl' style='width:100%;'><%=JSPLib.ToHTML("Tile options:")%></div></span>
<div id='<%=idPortlet%>_chkTotGroupby_div' style=''><input id='<%=idPortlet%>_chkTotGroupby' tabindex=33 name='chkTotGroupby' class='checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("check it if is a field to do groupby" )%> /><label for='<%=idPortlet%>_chkTotGroupby' class='portalstudio_label' title=<%=JSPLib.ToHTMLValue("check it if is a field to do groupby" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("Total groupby")%></label></div>
<span class='textbox-container'id='<%=idPortlet%>_txtTotalExp_wrp'><input id='<%=idPortlet%>_txtTotalExp' name='txtTotalExp' type='text' class='portalstudio_textbox' tabindex='34' formid='<%=idPortlet%>' ps-name='txtTotalExp' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtTotalDescr_wrp'><input id='<%=idPortlet%>_txtTotalDescr' name='txtTotalDescr' type='text' class='portalstudio_textbox' tabindex='35' formid='<%=idPortlet%>' ps-name='txtTotalDescr' /></span>
<span class='textbox-container'id='<%=idPortlet%>_txtTotalPicture_wrp'><input id='<%=idPortlet%>_txtTotalPicture' name='txtTotalPicture' type='text' class='portalstudio_textbox' tabindex='36' formid='<%=idPortlet%>' ps-name='txtTotalPicture' /></span>
<input id='<%=idPortlet%>_btnClose2' type='button' class='portalstudio_button black btnClose2_ctrl' tabindex='38'/>
<input id='<%=idPortlet%>_btnOk_2' type='button' class='portalstudio_button btnOk_2_ctrl' tabindex='36'/>
<input id='<%=idPortlet%>_btnReset_2' type='button' class='portalstudio_button black btnReset_2_ctrl' tabindex='37'/>
<span id='<%=idPortlet%>_labelTitle_2'  formid='<%=idPortlet%>' ps-name='labelTitle_2'    class='portalstudio_title labelTitle_2_ctrl'><div id='<%=idPortlet%>_labelTitle_2tbl' style='width:100%;'><%=JSPLib.ToHTML("Column settings:")%></div></span>
<a id='<%=idPortlet%>_image_help_2' class='image image_help_2_ctrl'  href='javascript:Help('portalzoom_interfaccia_base_toolbar_config_col_totalizer')' target='_self'>&#xe6f7;</a>
<div id='<%=idPortlet%>_TileMode_Groupby_div' style=''><input id='<%=idPortlet%>_TileMode_Groupby' tabindex=37 name='TileMode_Groupby' class='checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Check to group all fields that depends on it" )%> /><label for='<%=idPortlet%>_TileMode_Groupby' class='portalstudio_label' title=<%=JSPLib.ToHTMLValue("Check to group all fields that depends on it" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("View Group by Fields")%></label></div>
<label id='<%=idPortlet%>_label67' for='<%=idPortlet%>_TileBackground' formid='<%=idPortlet%>' ps-name='label67'    class='portalstudio_label label67_ctrl'><div id='<%=idPortlet%>_label67tbl' style='width:100%;'><%=JSPLib.ToHTML("Background expr:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_TileBackground_wrp'><input id='<%=idPortlet%>_TileBackground' name='TileBackground' type='text' class='portalstudio_textbox' tabindex='38' formid='<%=idPortlet%>' ps-name='TileBackground' /></span>
<input id='<%=idPortlet%>_button69' type='button' class='portalstudio_button button69_ctrl' tabindex='-1'/>
<label id='<%=idPortlet%>_label72' for='<%=idPortlet%>_TileVersion' formid='<%=idPortlet%>' ps-name='label72'    class='portalstudio_label label72_ctrl'><div id='<%=idPortlet%>_label72tbl' style='width:100%;'><%=JSPLib.ToHTML("Css class:")%></div></label>
<label id='<%=idPortlet%>_labelTileVisibility' for='<%=idPortlet%>_TileVisibility' formid='<%=idPortlet%>' ps-name='labelTileVisibility'    class='portalstudio_label labelTileVisibility_ctrl'><div id='<%=idPortlet%>_labelTileVisibilitytbl' style='width:100%;'><%=JSPLib.ToHTML("Visibility:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_TileVersion_wrp'><input id='<%=idPortlet%>_TileVersion' name='TileVersion' type='text' class='portalstudio_textbox' tabindex='39' formid='<%=idPortlet%>' ps-name='TileVersion' /></span>
<select id='<%=idPortlet%>_TileVisibility' name='TileVisibility' class='combobox' title=<%=JSPLib.ToHTMLValue("Set the importance of groupby tile (always visible, extended mode only or never)" )%> style='' tabindex='40'></select>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomColumnSettings');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_COLLAPSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_COLLAPSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_EXPAND",true)+","+JSPLib.ToJSValue(sp.translate("MSG_EXPAND"),true)+");\n");
}/**/%>
<%
final String com__zucchetti__sitepainter__altinterface__url = (String)request.getAttribute("com__zucchetti__sitepainter__altinterface__url");
final boolean isMainTabsForAltUI = com__zucchetti__sitepainter__altinterface__url != null && com__zucchetti__sitepainter__altinterface__url.contains("/SPPortalZoomColumnSettings_portlet.jsp");
%>
window.<%=idPortlet%>_tabstrip=new Z.Tabs({container:'<%=idPortlet%>_tabcontainer',useGlobals:<%=isMainTabsForAltUI%>, wizard:false, tabstrip_class: 'portalstudioTabstrip'});
<%
if (isMainTabsForAltUI) {
%>
Z.Tabs.Set('tabs',window.<%=idPortlet%>_tabstrip);
<%
}
%>
<%=idPortlet%>_tabstrip.AddTab({name:'page1', element:'<%=idPortlet%>_page_1',caption:'<%=JSPLib.ToJSValue(sp.translate("Main"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
<%=idPortlet%>_tabstrip.AddTab({name:'page2', element:'<%=idPortlet%>_page_2',caption:'<%=JSPLib.ToJSValue(sp.translate("Totalizer"))%>',onExpand:function(){return ZtVWeb.AdjustPortletHeight('<%=idPortlet%>')}});
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomColumnSettings',["660","660"],["560","560"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,2,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"660","h":"560","title":"Main","layer":""},{"layout_steps_values":{},"w":"660","h":"560","title":"Totalizer","layer":""}]);
this.txtTitle=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTitle","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Title of column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTitle","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTitle,false,true)%>","w":265,"x":45,"y":60,"zerofilling":false,"zindex":"1","zoom":""});
this.lblSanitizeTags=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"sanitize_tags","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSanitizeTags","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSanitizeTags","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblSanitizeTags,false,true)%>","type":"Label","w":125,"x":490,"y":95,"zindex":"1"});
this.lblSynonyms=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtSynonyms","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSynonyms","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSynonyms","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblSynonyms,false,true)%>","type":"Label","w":85,"x":45,"y":95,"zindex":"1"});
this.label_bc=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_bc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_bc","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_bc,false,true)%>","type":"Label","w":108,"x":189,"y":480,"zindex":"1"});
this.sanitize_tags=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_sanitize_tags","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Custom tags allowed","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"sanitize_tags","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(sanitize_tags,false,true)%>","w":125,"x":490,"y":115,"zerofilling":false,"zindex":"1","zoom":""});
this.lblHid=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtWid","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHid","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHid","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblHid,false,true)%>","type":"Label","w":125,"x":350,"y":205,"zindex":"1"});
this.txtBckColor_btn=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtBckColor_btn","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"txtBckColor_btn","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":302,"y":500,"zindex":"0"});
this.sanitize=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_sanitize","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"Define sanitize mode of text (in HTML mode)","hide":"false","hide_undercond":"","init":"","init_par":"<%=sanitize%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"sanitize","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"17","textlist":"xssPrevent,none,custom","type":"Combobox","typevar":"character","valuelist":"xssPrevent,none,custom","visible":true,"w":126,"x":350,"y":115,"zindex":"10"});
this.lblTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitle","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTitle,false,true)%>","type":"Label","w":90,"x":45,"y":40,"zindex":"1"});
this.txtTooltip=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTooltip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Tooltip of column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTooltip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTooltip,false,true)%>","w":265,"x":45,"y":170,"zerofilling":false,"zindex":"5","zoom":""});
this.lblHyperlink=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtLink","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblHyperlink","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblHyperlink","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblHyperlink,false,true)%>","type":"Label","w":85,"x":350,"y":315,"zindex":"1"});
this.lblOnClick=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtLink","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOnClick","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOnClick","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblOnClick,false,true)%>","type":"Label","w":85,"x":350,"y":480,"zindex":"1"});
this.lblTarget=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTarget","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTarget","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTarget","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTarget,false,true)%>","type":"Label","w":90,"x":350,"y":370,"zindex":"1"});
this.txtPicture=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtPicture","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Picture of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtPicture","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtPicture,false,true)%>","w":265,"x":45,"y":280,"zerofilling":false,"zindex":"1","zoom":""});
this.txtCssClass=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtCssClass","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Css class to assign to column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtCssClass","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtCssClass,false,true)%>","w":190,"x":45,"y":335,"zerofilling":false,"zindex":"1","zoom":""});
this.lblTooltip=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTooltip","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTooltip","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTooltip","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTooltip,false,true)%>","type":"Label","w":85,"x":45,"y":150,"zindex":"1"});
this.align=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_align","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"Horizontal alignment of text","hide":"false","hide_undercond":"","init":"","init_par":"<%=align%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"align","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"10","textlist":"left,center,right","type":"Combobox","typevar":"character","valuelist":"left,center,right","visible":true,"w":125,"x":45,"y":390,"zindex":"1"});
this.txtTitle_Tooltip=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTitle_Tooltip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Tooltip of title","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTitle_Tooltip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTitle_Tooltip,false,true)%>","w":265,"x":45,"y":225,"zerofilling":false,"zindex":"1","zoom":""});
this.lblTotExp=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTotalExp","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTotExp","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTotExp","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTotExp,false,true)%>","type":"Label","w":125,"x":35,"y":71,"zindex":"1"});
this.lblTotDesc=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTotalDescr","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTotDesc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTotDesc","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTotDesc,false,true)%>","type":"Label","w":125,"x":35,"y":125,"zindex":"1"});
this.lblTotPict=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTotalPicture","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTotPict","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTotPict","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTotPict,false,true)%>","type":"Label","w":125,"x":340,"y":125,"zindex":"1"});
this.lblPicture=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtPicture","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblPicture","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblPicture","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblPicture,false,true)%>","type":"Label","w":85,"x":45,"y":260,"zindex":"1"});
this.lblTitle_Tooltip=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtTitle_Tooltip","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitle_Tooltip","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitle_Tooltip","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTitle_Tooltip,false,true)%>","type":"Label","w":133,"x":45,"y":205,"zindex":"1"});
this.lblTile=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTile","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTile","nowrap":"false","page":2,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTile,false,true)%>","type":"Label","w":125,"x":35,"y":179,"zindex":"1"});
this.title_align=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_title_align","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"Horizontal alignment of title","hide":"false","hide_undercond":"","init":"","init_par":"<%=title_align%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"title_align","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"11","textlist":"left,center,right","type":"Combobox","typevar":"character","valuelist":"left,center,right","visible":true,"w":125,"x":185,"y":390,"zindex":"1"});
this.lblOrderByIdx=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"orderbyidx","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOrderByIdx","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOrderByIdx","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblOrderByIdx,false,true)%>","type":"Label","w":125,"x":490,"y":425,"zindex":"1"});
this.lblOrderbyStatus=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"orderbystatus","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblOrderbyStatus","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOrderbyStatus","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblOrderbyStatus,false,true)%>","type":"Label","w":125,"x":350,"y":425,"zindex":"1"});
this.lblEditable=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"chkEditable","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblEditable","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblEditable","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblEditable,false,true)%>","type":"Label","w":60,"x":490,"y":205,"zindex":"1"});
this.lblSecondaryBar=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"chkExtraTitle","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSecondaryBar","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSecondaryBar","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblSecondaryBar,false,true)%>","type":"Label","w":125,"x":350,"y":260,"zindex":"1"});
this.txtFontSize=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtFontSize","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Size of text","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtFontSize","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtFontSize,false,true)%>","w":125,"x":45,"y":445,"zerofilling":false,"zindex":"1","zoom":""});
this.txtFontW=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_txtFontW","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"Set the weight of text","hide":"false","hide_undercond":"","init":"","init_par":"<%=txtFontW%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"txtFontW","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"13","textlist":"normal,bold,italic","type":"Combobox","typevar":"character","valuelist":"normal,bold,italic","visible":true,"w":125,"x":185,"y":445,"zindex":"1"});
this.txtFontColor=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtFontColor","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Set the color of text","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtFontColor","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtFontColor,false,true)%>","w":113,"x":45,"y":500,"zerofilling":false,"zindex":"1","zoom":""});
this.chkTotGroupby=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"portalstudio_label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkTotGroupby","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"Total groupby","layer":false,"layout_steps_values":{},"name":"chkTotGroupby","page":2,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"33","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":222,"x":35,"y":42,"zindex":"1"});
this.chkTotGroupby.Value(<%=chkTotGroupby%>);
this.mode=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"portalstudio_combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_mode","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"Set the type of content and his visualization mode (text, image, checkbox, text with first uppercase letters)","hide":"false","hide_undercond":"","init":"","init_par":"<%=mode%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"mode","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"16","textlist":"HTML,Image,Checkbox,InitLetter,initLetter2","type":"Combobox","typevar":"numeric","valuelist":"1,2,3,4,5","visible":true,"w":265,"x":350,"y":60,"zindex":"1"});
this.txtWid=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtWid","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Min width of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtWid","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtWid,false,true)%>","w":125,"x":350,"y":170,"zerofilling":false,"zindex":"1","zoom":""});
this.txtTotalExp=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTotalExp","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Expression to do totalizer","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTotalExp","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTotalExp,false,true)%>","w":570,"x":35,"y":91,"zerofilling":false,"zindex":"1","zoom":""});
this.txtFixedWidth=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtFixedWidth","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Max width of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtFixedWidth","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtFixedWidth,false,true)%>","w":125,"x":490,"y":170,"zerofilling":false,"zindex":"1","zoom":""});
this.txtTotalDescr=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTotalDescr","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Title of Totalizer subgrid","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTotalDescr","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTotalDescr,false,true)%>","w":265,"x":35,"y":146,"zerofilling":false,"zindex":"1","zoom":""});
this.txtTotalPicture=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTotalPicture","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Title of Totalizer subgrid","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTotalPicture","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTotalPicture,false,true)%>","w":265,"x":340,"y":146,"zerofilling":false,"zindex":"1","zoom":""});
this.chkExtraTitle=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkExtraTitle","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkExtraTitle","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"23","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":350,"y":280,"zindex":"1"});
this.chkExtraTitle.Value(<%=chkExtraTitle%>);
this.chkEditable=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkEditable","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkEditable","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"22","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":490,"y":225,"zindex":"1"});
this.chkEditable.Value(<%=chkEditable%>);
this.columnVisibility=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_columnVisibility","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"Set the importance of column (always visible, extended mode only or never)","hide":"false","hide_undercond":"","init":"","init_par":"<%=columnVisibility%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"columnVisibility","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"24","textlist":"Base,Extended,Hidden","type":"Combobox","typevar":"character","valuelist":"base,extended,hidden","visible":true,"w":126,"x":490,"y":280,"zindex":"10"});
this.btnOk=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button btnOk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnOk","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Confirm column and apply settings","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnOk","page":1,"spuid":"","tabindex":"30","text":"Ok","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":405,"y":526,"zindex":"1"});
this.btnReset=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black btnReset_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnReset","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Clear modified data","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnReset","page":1,"spuid":"","tabindex":"31","text":"Reset","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":489,"y":526,"zindex":"1"});
this.txtLink=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtLink","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Hyperlink of column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtLink","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtLink,false,true)%>","w":265,"x":350,"y":335,"zerofilling":false,"zindex":"5","zoom":""});
this.txtOnClick=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtOnClick","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"OnClick function to call","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtOnClick","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtOnClick,false,true)%>","w":265,"x":350,"y":500,"zerofilling":false,"zindex":"5","zoom":""});
this.txtTarget=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtTarget","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Target of the column hyperlink","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtTarget","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtTarget,false,true)%>","w":265,"x":350,"y":390,"zerofilling":false,"zindex":"1","zoom":""});
this.btnClose=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black btnClose_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnClose","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnClose","page":1,"spuid":"","tabindex":"32","text":"Close","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":572,"y":526,"zindex":"1"});
this.btnClose2=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black btnClose2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnClose2","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Close without saving","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnClose2","page":2,"spuid":"","tabindex":"38","text":"Close","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":573,"y":526,"zindex":"1"});
this.btnOk_2=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button btnOk_2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnOk_2","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Confirm column and apply settings on the grid","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnOk_2","page":2,"spuid":"","tabindex":"36","text":"Ok","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":405,"y":526,"zindex":"1"});
this.orderbystatus=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_orderbystatus","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"Set the orderby direction","hide":"false","hide_undercond":"","init":"","init_par":"<%=orderbystatus%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"orderbystatus","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"27","textlist":"asc,desc","type":"Combobox","typevar":"character","valuelist":"asc,desc","visible":true,"w":125,"x":350,"y":445,"zindex":"1"});
this.btnReset_2=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button black btnReset_2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnReset_2","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"Clear modified data","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnReset_2","page":2,"spuid":"","tabindex":"37","text":"Reset","type":"Button","type_submit":"false","type_wizard":"","w":69,"x":489,"y":526,"zindex":"1"});
this.columnid=new ZtVWeb._VC(this,'columnid',null,'character','<%=JSPLib.ToJSValue(columnid,false,true)%>',false,false);
this.type=new ZtVWeb._VC(this,'type',null,'character','<%=JSPLib.ToJSValue(type,false,true)%>',false,false);
this.labelTitle=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":30,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTitle","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelTitle,false,true)%>","type":"Label","w":660,"x":0,"y":0,"zindex":"1"});
this.image_help=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_help_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_help","edit_undercond":"","field":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f7;","font_image_hover":"","font_name":"iMobileIcon","font_path":"","font_size":"","h":18,"help_tips":"<%=JSPLib.ToJSValue("Help",false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keepProportions":"","layer":false,"layout_steps_values":{},"name":"image_help","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"&#xe6f7;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":18,"x":630,"y":4,"zindex":"1"});
 ZtVWeb.RequireFont("iMobileIcon","");
this.labelTitle_2=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"portalstudio_title","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTitle_2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":30,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTitle_2","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelTitle_2,false,true)%>","type":"Label","w":660,"x":0,"y":0,"zindex":"1"});
this.image_help_2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_help_2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_help_2","edit_undercond":"","field":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f7;","font_image_hover":"","font_name":"iMobileIcon","font_path":"","font_size":"","h":18,"help_tips":"<%=JSPLib.ToJSValue("Help",false,true)%>","hide":"false","hide_undercond":"","href":"javascript:Help('portalzoom_interfaccia_base_toolbar_config_col_totalizer')","img_type":"font icon","keepProportions":"","layer":false,"layout_steps_values":{},"name":"image_help_2","page":2,"path_type":"","server_side":"","spuid":"","src":"&#xe6f7;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":18,"x":630,"y":4,"zindex":"1"});
 ZtVWeb.RequireFont("iMobileIcon","");
this.orderbyidx=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_orderbyidx","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"verdana","font_size":"","h":20,"help_tips":"Set the orderby position of column","hide":"false","hide_undercond":"","init":"","init_par":"<%=orderbyidx%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"orderbyidx","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"28","textlist":"1,2,3,4,5","type":"Combobox","typevar":"numeric","valuelist":"1,2,3,4,5","visible":true,"w":125,"x":490,"y":445,"zindex":"1"});
this.contId=new ZtVWeb._VC(this,'contId',null,'character','<%=JSPLib.ToJSValue(contId,false,true)%>',false,false);
this.label40=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"mode","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label40","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label40","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label40,false,true)%>","type":"Label","w":125,"x":350,"y":40,"zindex":"1"});
this.label_fs=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontSize","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_fs","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_fs","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_fs,false,true)%>","type":"Label","w":125,"x":45,"y":425,"zindex":"1"});
this.label_fw=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontW","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_fw","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_fw","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_fw,false,true)%>","type":"Label","w":125,"x":185,"y":425,"zindex":"1"});
this.label_fc=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtFontColor","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_fc","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_fc","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_fc,false,true)%>","type":"Label","w":78,"x":45,"y":480,"zindex":"1"});
this.label_css=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtCssClass","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_css","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_css","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_css,false,true)%>","type":"Label","w":85,"x":45,"y":315,"zindex":"1"});
this.lblWid=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtWid","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblWid","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblWid","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblWid,false,true)%>","type":"Label","w":125,"x":350,"y":150,"zindex":"1"});
this.lblFixedWidth=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"txtMaxWidth","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblFixedWidth","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblFixedWidth","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblFixedWidth,false,true)%>","type":"Label","w":125,"x":490,"y":150,"zindex":"1"});
this.lblAlign=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"align","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAlign","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAlign","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAlign,false,true)%>","type":"Label","w":125,"x":45,"y":370,"zindex":"1"});
this.lblTitleAlign=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"align","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitleAlign","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitleAlign","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTitleAlign,false,true)%>","type":"Label","w":125,"x":185,"y":370,"zindex":"1"});
this.txtFontColor_btn=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"","border_color":"#00A0BD","border_weight":"1","class_Css":"box_colorpicker","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtFontColor_btn","groupName":"","h":20,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"txtFontColor_btn","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":20,"x":161,"y":500,"zindex":"0"});
this.txtField=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtField","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtField","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtField,false,true)%>","w":145,"x":475,"y":3,"zerofilling":false,"zindex":"1","zoom":""});
this.TileMode_Groupby=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"initial","create_undercond":"","css_class":"portalstudio_label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_TileMode_Groupby","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"false","init_par":"'initial'","label_text":"View Group by Fields","layer":false,"layout_steps_values":{},"name":"TileMode_Groupby","page":2,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"37","type":"Checkbox","typevar":"character","unchecked_value":"none","w":210,"x":55,"y":205,"zindex":"2"});
this.TileMode_Groupby.Value('<%=TileMode_Groupby%>');
this.label67=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"TileBackground","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label67","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label67","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label67,false,true)%>","type":"Label","w":127,"x":55,"y":240,"zindex":"4"});
this.TileBackground=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_TileBackground","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Set a background color for tile","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"TileBackground","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(TileBackground,false,true)%>","w":210,"x":55,"y":260,"zerofilling":false,"zindex":"5","zoom":""});
this.button69=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"portalstudio_button button69_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_button69","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":"","hide":"true","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"button69","page":2,"spuid":"","tabindex":"-1","text":"?","type":"Button","type_submit":"false","type_wizard":"","w":20,"x":269,"y":260,"zindex":"6"});
this.label72=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"TileVersion","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_label72","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label72","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label72,false,true)%>","type":"Label","w":125,"x":55,"y":287,"zindex":"8"});
this.labelTileVisibility=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"TileVisibility","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTileVisibility","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTileVisibility","nowrap":"false","page":2,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelTileVisibility,false,true)%>","type":"Label","w":125,"x":55,"y":342,"zindex":"8"});
this.TileVersion=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_TileVersion","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Set a custom css class of tile","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"TileVersion","page":2,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(TileVersion,false,true)%>","w":210,"x":55,"y":307,"zerofilling":false,"zindex":"9","zoom":""});
this.TileVisibility=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_TileVisibility","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"Set the importance of groupby tile (always visible, extended mode only or never)","hide":"false","hide_undercond":"","init":"","init_par":"<%=TileVisibility%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"TileVisibility","page":2,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"40","textlist":"Base,Extended,Hidden","type":"Combobox","typevar":"character","valuelist":"base,extended,hidden","visible":true,"w":210,"x":55,"y":363,"zindex":"10"});
this.labelVisibility=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"columnVisibility","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelVisibility","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelVisibility","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelVisibility,false,true)%>","type":"Label","w":125,"x":490,"y":260,"zindex":"8"});
this.txtCssClassEdit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"cursor_icon txtCssClassEdit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_txtCssClassEdit","edit_undercond":"","field":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe603;","font_image_hover":"","font_name":"iMobileIcon","font_path":"","font_size":"16","h":16,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"txtCssClassEdit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe603;","srchover":"","tabindex":"9","target":"","type":"Image","type_submit":"false","w":16,"x":290,"y":335,"zindex":"11"});
 ZtVWeb.RequireFont("iMobileIcon","");
this.txtCssClassPicker=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"cursor_icon txtCssClassPicker_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_txtCssClassPicker","edit_undercond":"","field":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe6f6;","font_image_hover":"","font_name":"iMobileIcon","font_path":"","font_size":"16","h":16,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"txtCssClassPicker","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe6f6;","srchover":"","tabindex":"7","target":"","type":"Image","type_submit":"false","w":16,"x":243,"y":335,"zindex":"11"});
 ZtVWeb.RequireFont("iMobileIcon","");
this.txtCssClassAdd=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"cursor_icon txtCssClassAdd_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_txtCssClassAdd","edit_undercond":"","field":"","font_color":"#00A0BD","font_color_hover":"","font_image":"&#xe605;","font_image_hover":"","font_name":"iMobileIcon","font_path":"","font_size":"16","h":16,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"txtCssClassAdd","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe605;","srchover":"","tabindex":"8","target":"","type":"Image","type_submit":"false","w":16,"x":267,"y":335,"zindex":"11"});
 ZtVWeb.RequireFont("iMobileIcon","");
this.txtHid=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtHid","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Height of the column","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtHid","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtHid,false,true)%>","w":125,"x":350,"y":225,"zerofilling":false,"zindex":"1","zoom":""});
this.txtBckColor=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtBckColor","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"Set background color of cell","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtBckColor","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtBckColor,false,true)%>","w":113,"x":185,"y":500,"zerofilling":false,"zindex":"1","zoom":""});
this.txtSynonyms=new ZtVWeb._TC(this,{"anchor":"top-left-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtSynonyms","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"List, comma separated, of synonyms","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtSynonyms","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtSynonyms,false,true)%>","w":265,"x":45,"y":115,"zerofilling":false,"zindex":"5","zoom":""});
this.lblSanitize=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"sanitize","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSanitize","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSanitize","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblSanitize,false,true)%>","type":"Label","w":125,"x":350,"y":95,"zindex":"1"});
this.lblPrintable=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"chkEditable","calculate":"","class_Css":"portalstudio_label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblPrintable","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":18,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblPrintable","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblPrintable,false,true)%>","type":"Label","w":60,"x":560,"y":205,"zindex":"1"});
this.chkPrintable=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkPrintable","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":13,"hide":"false","hide_undercond":"","init":"","init_par":"false","label_text":"","layer":false,"layout_steps_values":{},"name":"chkPrintable","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"22","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":13,"x":560,"y":225,"zindex":"1"});
this.chkPrintable.Value(<%=chkPrintable%>);
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
<%if(request.getAttribute("SPPortalZoomColumnSettings_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPPortalZoomColumnSettings_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomColumnSettings_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.image_help.dispatchEvent('OnLoad');
window.<%=idPortlet%>.image_help_2.dispatchEvent('OnLoad');
window.<%=idPortlet%>.txtCssClassEdit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.txtCssClassPicker.dispatchEvent('OnLoad');
window.<%=idPortlet%>.txtCssClassAdd.dispatchEvent('OnLoad');
window.<%=idPortlet%>.sanitize.FillData();
window.<%=idPortlet%>.align.FillData();
window.<%=idPortlet%>.title_align.FillData();
window.<%=idPortlet%>.txtFontW.FillData();
window.<%=idPortlet%>.mode.FillData();
window.<%=idPortlet%>.columnVisibility.FillData();
window.<%=idPortlet%>.orderbystatus.FillData();
window.<%=idPortlet%>.orderbyidx.FillData();
window.<%=idPortlet%>.TileVisibility.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomColumnSettings',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomColumnSettings');
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
sp.endPage("SPPortalZoomColumnSettings");
}%>
<%! public String getJSPUID() { return "33920868"; } %>