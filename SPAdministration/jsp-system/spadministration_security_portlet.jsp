<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var that = this;\nm_cProgName='spsecurity';\nm_cTarget = '\u003c%= JSPLib.ToJSValue((String) (Class.forName(\"SPControlPanel\").getField(\"m_cTarget\").get(null))) %\u003e';\nthis.grid_procedure.SPLinkerActions.E.action='start';\n\nfunction nascondi_nome_entita(){\n  \u002f\u002ffunzione che viene utilizzata per nascondere la textbox per inserimento del nome dell'entit? \n  \u002f\u002fe il bottone per l'inserimento delle sicurezze\n  this.label_entity_name.Hide();\n  this.progname_input.Hide();\n  this.bt_rule.Hide();\n  this.labelSecurity.Hide();\n}\n\nfunction mostra_nome_entita(){\n  \u002f\u002ffunzione utilizzata per mostrare la textbox per inserimento del nome dell'entit? \n  \u002f\u002fe il bottone per l'inserimento delle sicurezze\n  this.label_entity_name.Show();\n  this.progname_input.Show();\n  this.bt_rule.Show();\n  this.labelSecurity.Show();\n}\n\nfunction mostra_select(){\n  \u002f\u002ffunzione utilizzata per mostrare l'immagine per inserimento delle Procedure\u002fQuery \n  this.imageSelect.Show();\n  this.labelSelect.Show();\n}\n\nfunction nascondi_select(){\n  \u002f\u002ffunzione utilizzata per nascondere l'immagine per inserimento delle Procedure\u002fQuery \n  this.imageSelect.Hide();\n  this.labelSelect.Hide();\n}\n\nfunction this_Loaded(){\n\u002f\u002fl'utente vedr? di default soltanto il combobox con i Tipi\n  that.nascondi_select();\n  that.nascondi_nome_entita();\n  var customToolbar=this.getTitlePortlet();\n  if(m_cTarget != \"_blank\") {\n    customToolbar.AppendButton({\n      image:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n      action:'..\u002fservlet\u002fSPControlPanel',\n      title:FormatMsg(\"MSG_BACK\"),\n      tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n    })\n  }\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })\n  customToolbar.SetTitle(FormatMsg(\"CP_SECURITY\"));\n  customToolbar.RearrangeAll();\n}\n\nfunction combobox_admin_type1_onChange(){\n\u002f\u002fal cambiare del valore del combobox esegue una ricerca e a seconda del caso mostra\u002fnasconde \n\u002f\u002fle immagini per la selezione delle Procedure\u002fQuery e la textbox per l'inserimento delle sicurezze\n\u002f\u002fse nel combobox non viene scelto nessun valore allora esse non verrano mostrate all'utente\n  this.sectype_combobox.Set(this.combobox_admin_type1.Value());\n  this.db_cpprgsec.Query();\n  that.nascondi_select();\n  switch (LRTrim(this.sectype_combobox.Value())){\n    case '':\n      that.nascondi_nome_entita();\n      break;\n    case 'Procedure':\n      this.imageSelect.Ctrl.className = \"selectIcon imageSelect_ctrl boname\"; \n      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_BO'));\n      that.mostra_select();\n      that.mostra_nome_entita();\n      this.progname_input.Set();\n      break;\n    case 'Query':\n      this.imageSelect.Ctrl.className = \"selectIcon imageSelect_ctrl vqr\";\n      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_QUERY'));\n      that.mostra_select();\n      that.nascondi_nome_entita();\n      this.progname_input.Set();\n      break;\n    case 'ROLE':\n      that.nascondi_nome_entita();\n      this.progname_input.Set();\n      break;\n    default:\n      that.mostra_nome_entita();\n      this.progname_input.Set();\n      break;\n  }\n}\n\nfunction combobox_admin_type2_onChange(){\n\u002f\u002fal cambiare del valore del combobox esegue una ricerca e a seconda del caso mostra\u002fnasconde \n\u002f\u002fle immagini per la selezione delle Procedure\u002fQuery e la textbox per l'inserimento delle sicurezze\n\u002f\u002fse nel combobox non viene scelto nessun valore allora esse non verrano mostrate all'utente\n  this.sectype_combobox.Set(this.combobox_admin_type2.Value());\n  this.db_cpprgsec.Query();\n  that.nascondi_select();\n  switch (LRTrim(this.sectype_combobox.Value())){\n    case '':\n      that.nascondi_nome_entita();\n      break;\n    case 'Procedure':\n      this.imageSelect.Ctrl.className = \"selectIcon imageSelect_ctrl boname\";\n      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_BO'));\n      that.mostra_select();\n      that.mostra_nome_entita();\n      this.progname_input.Set();\n      break;\n    case 'Query':\n      this.imageSelect.Ctrl.className = \"selectIcon imageSelect_ctrl vqr\";\n      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_QUERY'));\n      that.mostra_select();\n      that.nascondi_nome_entita();\n      this.progname_input.Set();\n      break;\n    case 'ROLE':\n      that.nascondi_nome_entita();\n      this.progname_input.Set();\n      break;\n    default:\n      that.mostra_nome_entita();\n      this.progname_input.Set();\n      break;\n  }\n}\n\nfunction RefreshGrid(){\n\u002f\u002fpermette di aggiornare la griglia\n  this.grid_procedure.Refresh();\n}\n\nfunction progname_onChange(){\n  this.progname.Value(this.progname.Value().trim());\n}\n\nfunction modifica_riga(){\n\u002f\u002fmodifica sicurezza\n  this.progname_insert.Set(this.progname.Value());\n  if (this.sectype.Value()=='Query' || \n      this.sectype.Value()=='Portlet & Pagelet' || \n      this.sectype.Value()=='Web Report' || \n      this.sectype.Value()=='SmartReport'){\n    this.splinker_modificaRiga1.Link();\n  }else{\n    if (this.sectype.Value()=='Role') {\n      this.splinker_viewRole.Link();\n    } else {\n      this.splinker_modificaRiga2.Link();\n    }\n  }\n}\n\nfunction reQuery(){\n  \u002f\u002fnel caso in cui si cancella dalla tabella delle sicurezze un'entit?, viene forzata l'esecuzione\n  \u002f\u002fdella Query\n  that.db_cpprgsec.Query(true);\n}\n\nfunction bt_rule_Click(){\n\u002f\u002faggiunge sicurezza; si attiva solo se ? stato selezionato un tipo e se'Nome entit?' non ? vuoto\n  if((!Empty(this.sectype_combobox.Value()))&&(!Empty(this.progname_input.Value()))){\n    switch (LRTrim(this.sectype_combobox.Value())){\n      case 'Procedure':\n        this.progname_input.Set(this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga2.Link();\n        break;\n      case 'Query':\n        this.progname_input.Set('vqr\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga1.Link();\n        break;\n      case 'Portlet & Pagelet':\n        this.progname_input.Set('ps\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga1.Link();\n        break;\n      case 'Web Report':\n        this.progname_input.Set('vrp\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga1.Link();\n        break;\n      case 'SmartReport':\n        this.progname_input.Set('svrp\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga1.Link();\n        break;\n      case 'Web Service Report':\n        this.progname_input.Set('wsrp\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga2.Link();\n        break;\n      case 'SOAP Endpoint Procedure':\n        this.progname_input.Set('soap\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga2.Link();\n        break;\n      case 'SOAP Endpoint Report':\n        this.progname_input.Set('soap\u002fvrp\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga2.Link();\n        break;\n      case 'SOAP Endpoint Query':\n        this.progname_input.Set('soap\u002fquery\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga2.Link();\n        break;\n      case 'ROLE':\n        this.progname_input.Set('r\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_viewRole.Link();\n        break;\n      case 'API':\n        this.progname_input.Set('API\u002f' + this.progname_input.Value());\n        this.progname_insert.Set(this.progname_input.Value());\n        this.splinker_modificaRiga2.Link();\n        break;\n    }\n    this.progname_input.Set('');\n  } else\n  {\n    if ((Empty(this.sectype_combobox.Value()))&&(!Empty(this.progname_input.Value()))){\n      alert(FormatMsg('ADMIN_SELECT_TYPE'));\n    } else\n    {\n      if ((!Empty(this.sectype_combobox.Value()))&&(Empty(this.progname_input.Value()))){\n        alert(FormatMsg('ADMIN_INSERT_ENTITY'));\n      }\n    }\n  }\n  if((Empty(this.sectype_combobox.Value()))&&(Empty(this.progname_input.Value()))){\n    alert(FormatMsg('ADMIN_INSERT_TYPE_AND_ENTITY'));\n  }\n}\n\nfunction cancella_riga(){\n\u002f\u002fcancella sicurezza\n  var _this=this;\n  WindowConfirm(FormatMsg('ADMIN_DELETE_SECURITY'), function(res){\n    if(res){\n      _this.splinker_removesecurity.Link();\n      \u002f\u002fsetTimeout(that.reQuery,10);\n    }\n  });\n}\n\nfunction imageSelect_Click(){\n\u002f\u002fapre un Popup che permette di scegliere la Query o il BO da mettere sotto sicurezza\n  if (this.sectype_combobox.Value()=='Query'){\n    this.splinkeSelectQuery.Link();\n  }else{\n    this.splinkeBoName.Link();\n  }\n}\n\nfunction labelSelect_Click(){\n\u002f\u002fapre un Popup che permette di scegliere la Query o il BO da mettere sotto sicurezza\n  if (this.sectype_combobox.Value()=='Query'){\n    this.splinkeSelectQuery.Link();\n  }else{\n    this.splinkeBoName.Link();\n  }\n}\n\nfunction salvaNomeQuery(){\n\u002f\u002fpassa il nome della Query selezionata dal Popup alla textbox 'Entity name' per poterla aggiungere alle sicurezze  \n  if (this.queryname.Value()){ \n    this.progname_input.Set('vqr\u002f' + this.queryname.Value());\n    this.progname_insert.Set(this.progname_input.Value());\n    this.splinker_modificaRiga1.Link();\n    this.progname_input.Set('');\n  }\n}\n\nfunction salvaNomeBo(){\n\u002f\u002fpassa il nome del BO selezionato dal Popup alla textbox 'Entity name' per poterlo aggiungere alle sicurezze\n  if(this.boname.Value()){\n    this.progname_insert.Set(this.boname.Value());\n    this.splinker_modificaRiga2.Link();\n    this.progname_input.Set('');\n  }\n}\n\nfunction splinker_removesecurity_Result(result){\n  this.db_cpprgsec.Query(true);\n}\n\nfunction getEditImage(){\n  var url=\"\u003cimg src='\";\n  url+=SPTheme.grid_img_action_edit||ZtVWeb.SPWebRootURL+\"\u002fvisualweb\u002fimages\u002fgrid_edit.png\";\n  url+=\"' alt='' title='' border='0'\u003e\";\n  return url;\n}\n\nfunction getDeleteImage(){\n  var url=\"\u003cimg src='\";\n  url+=SPTheme.grid_img_action_delete||ZtVWeb.SPWebRootURL+\"\u002fvisualweb\u002fimages\u002fgrid_delete.png\";\n  url+=\"' alt='' title='' border='0'\u003e\";\n  return url\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"portlet-white-default no-radius","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"\",\"size\":\"\",\"weight\":\"\",\"align\":\"center\",\"code\":\"\"},\"hover\":{},\":before\":{\"display\":\"inline-block\",\"content\":\"\",\"size\":\"20px\",\"weight\":\"normal\",\"font_color\":\"rgba(0, 0, 0, 0.93)\",\"code\":\"font-family: icons8_win10;\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"selectIcon\",\"selector\":\".selectIcon\",\"id\":\"form\",\"code\":\".selectIcon {\\n  text-align: center;\\n}\\n\\n.selectIcon::before {\\n  display: inline-block;\\n  font-family: icons8_win10;\\n  color: rgba(0, 0, 0, 0.93);\\n  font-weight: normal;\\n  font-size: 20px;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{\"content\":\"\\\\f037\",\"code\":\"\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"selectIcon\",\"selector\":\".selectIcon.vqr\",\"id\":\"form\",\"code\":\".selectIcon.vqr::before {\\n  content: '\\\\f037';\\n}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{\"content\":\"\\\\f0ba\",\"code\":\"\"},\":after\":{}},\"current_state\":\":before\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon.grid_edit\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{\"content\":\"\\\\f041\",\"code\":\"\",\"display\":\"\"},\":after\":{}},\"current_state\":\":before\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon.grid_delete\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"display\":\"\",\"size\":\"\",\"weight\":\"\",\"align\":\"center\",\"code\":\"\"},\"hover\":{},\":before\":{\"display\":\"inline-block\",\"content\":\"\",\"size\":\"20px\",\"weight\":\"normal\",\"font_color\":\"rgba(0, 0, 0, 0.93)\",\"code\":\"font-family: icons8_win10;\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{\"content\":\"\\\\f036\",\"code\":\"\"},\":after\":{}},\"current_state\":\":before\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"selectIcon\",\"selector\":\".selectIcon.boname\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"border_radius_tl\":\"0\",\"border_radius_tr\":\"0\",\"border_radius_bl\":\"0.5rem\",\"border_radius_br\":\"0.5rem\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"no-radius\",\"selector\":\".no-radius\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @grid_procedure }}{{ @label_admin_type }}{{ @combobox_admin_type2 }}{{ @combobox_admin_type1 }}{{ @label_entity_name }}{{ @progname_input }}{{ @bt_rule }}{{ @imageSelect }}{{ @labelSelect }}{{ @labelSecurity }}\u003c\u002fbody\u003e","grapesCss":"","h":"210","hsl":"","htmlcode":"{{ @grid_procedure }} \n{{ db_cpprgsec }}\n{{ grid_procedure }}\n{{ label_admin_type }}\n{{ combobox_admin_type2 }}\n{{ combobox_admin_type1 }}\n{{ label_entity_name }}\n{{ progname_input }}\n{{ WebServiceReportInstalled }}\n{{ progname }}\n{{ sectype_combobox }}\n{{ splinker_modificaRiga2 }}\n{{ splinker_viewRole }}\n{{ progname_insert }}\n{{ sectype }}\n{{ splinker_removesecurity }}\n{{ bt_rule }}\n{{ imageSelect }}\n{{ queryname }}\n{{ splinkeSelectQuery }}\n{{ splinkeBoName }}\n{{ EventQueryname }}\n{{ boname }}\n{{ EventBoName }}\n{{ labelSelect }}\n{{ labelSecurity }}\n{{ splinker_modificaRiga1 }}\n{{ Event_addQuery }}\n{{ @label_admin_type }} \n{{ @combobox_admin_type2 }} \n{{ @combobox_admin_type1 }} \n{{ @label_entity_name }} \n{{ @progname_input }} \n{{ @bt_rule }} \n{{ @imageSelect }} \n{{ @labelSelect }} \n{{ @labelSecurity }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"false","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"210\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"950","version":"37","w":"100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"25","name":"db_cpprgsec","offline":"false","page":"1","parms":"progname=progname_input,type=sectype_combobox,type=sectype","parms_source":"","query":"spquery_prog_security","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"170","waiting_mgs":"","x":"5","y":"236"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"progname,type","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fimages\u002fgrid\u002fedit.png\\\")%\u003e\",\"align\":\"center\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":\"\",\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"iconFont grid_icon grid_edit\\\"\u003e\u003c\u002fspan\u003e\",\"maxwidth\":\"\",\"title\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:modifica_riga()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"height\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"printable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fimages\u002fgrid\u002fdelete.png\\\")%\u003e\",\"align\":\"center\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":\"\",\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"iconFont grid_icon grid_delete\\\"\u003e\u003c\u002fspan\u003e\",\"maxwidth\":\"\",\"title\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:cancella_riga()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"height\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"printable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_TYPE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sectype\",\"maxwidth\":\"\",\"title\":\"ADMIN_TYPE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"printable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_ENTITY_NAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"progname\",\"maxwidth\":\"\",\"title\":\"ADMIN_ENTITY_NAME\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"printable\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"db_cpprgsec","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"true","empty_rows":"true","extensible":"false","fields_type":"","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"166","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grid_procedure","nav_bar":"true","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":"950","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"46","zindex":"","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_admin_type","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ADMIN_TYPE","w":"28","wireframe_props":"align,value,n_col","x":"14","y":"16","zindex":"1","zone":""},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"Verdana","font_size":"9pt","h":"20","help_tips":"","hide":"false","hide_undercond":"not(Empty(WebServiceReportInstalled))","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"combobox_admin_type2","page":"1","picture":"","rapp":"","sequence":"4","spuid":"","tabindex":"","textlist":"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,Role,API","type":"Combobox","typevar":"character","valuelist":"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,ROLE,API","visible":"true","w":"187","wireframe_props":"name,textlist","x":"49","y":"13","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"Verdana","font_size":"9pt","h":"22","help_tips":"","hide":"false","hide_undercond":"Empty(WebServiceReportInstalled)","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"combobox_admin_type1","page":"1","picture":"","rapp":"","sequence":"5","spuid":"","tabindex":"","textlist":"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,Web Service Report,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,Role,API","type":"Combobox","typevar":"character","valuelist":"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,Web Service Report,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,ROLE,API","visible":"true","w":"187","wireframe_props":"name,textlist","x":"49","y":"11","zindex":"1","zone":""},{"align":"right","anchor":"top-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_entity_name","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ADMIN_ENTITY_NAME","w":"85","wireframe_props":"align,value,n_col","x":"346","y":"16","zindex":"1","zone":""},{"anchor":"top-right","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"9pt","h":"22","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"progname_input","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"303","wireframe_props":"name","x":"433","y":"11","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"WebServiceReportInstalled","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"5","y":"418"},{"calculate":"","ctrlOfVariant":"","dataobj":"db_cpprgsec","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"progname","h":"20","init":"","init_par":"","name":"progname","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"5","y":"340"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"sectype_combobox","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"5","y":"262"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_modificaRiga2","offline":"false","page":"1","parms":"progname=progname_insert","popup":"true","popup_height":"820","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"1000","progressbar":"","refresh":"","sequence":"11","servlet":"..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp","target":"","type":"SPLinker","w":"170","x":"199","y":"283"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_viewRole","offline":"false","page":"1","parms":"progname=progname_insert","popup":"true","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"700","progressbar":"","refresh":"","sequence":"12","servlet":"..\u002fjsp-system\u002fsprolesecurity_portlet.jsp","target":"","type":"SPLinker","w":"170","x":"199","y":"309"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"progname_insert","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"5","y":"288"},{"calculate":"","ctrlOfVariant":"","dataobj":"db_cpprgsec","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"sectype","h":"20","init":"","init_par":"","name":"sectype","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"5","y":"314"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"splinker_removesecurity","offline":"false","page":"1","parms":"progname=progname","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"spremovesecurity","target":"","type":"SPLinker","w":"170","x":"199","y":"361"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xed02;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"22","help_tips":"ADMIN_RULE_OF_SECURITY","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"bt_rule","page":"1","path_type":"themed","rapp":"","sequence":"16","server_side":"","spuid":"","src":"..\u002fimages\u002fsecurity.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"22","wireframe_props":"","x":"742","y":"12","zindex":"1","zone":""},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"selectIcon","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"imageSelect","page":"1","path_type":"","rapp":"","sequence":"17","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"22","wireframe_props":"","x":"244","y":"11","zindex":"1","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"queryname","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"5","y":"366"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinkeSelectQuery","offline":"false","page":"1","parms":"","popup":"true","popup_height":"400","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"350","progressbar":"","refresh":"","sequence":"19","servlet":"..\u002fjsp-system\u002fgsso_select_vqr_portlet.jsp","target":"","type":"SPLinker","w":"170","x":"199","y":"387"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinkeBoName","offline":"false","page":"1","parms":"","popup":"true","popup_height":"400","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"700","progressbar":"","refresh":"","sequence":"20","servlet":"..\u002fjsp-system\u002fgsso_get_bo_name_portlet.jsp","target":"","type":"SPLinker","w":"170","x":"199","y":"335"},{"actObjs":"queryname,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"EventQueryname","objsValues":"queryname,this.salvaNomeQuery()","page":"1","parmsNames":"queryname","sequence":"21","type":"EventReceiver","w":"170","x":"388","y":"321"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"boname","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"5","y":"392"},{"actObjs":"boname,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"EventBoName","objsValues":"boname,this.salvaNomeBo()","page":"1","parmsNames":"boname","sequence":"23","type":"EventReceiver","w":"170","x":"388","y":"346"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelSelect","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"106","wireframe_props":"align,value,n_col","x":"270","y":"16","zindex":"1","zone":""},{"align":"left","anchor":"top-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:bt_rule_Click()","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelSecurity","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"25","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ADMIN_RULE_OF_SECURITY","w":"183","wireframe_props":"align,value,n_col","x":"767","y":"16","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_modificaRiga1","offline":"false","page":"1","parms":"progname=progname_insert","popup":"true","popup_height":"820","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"1000","progressbar":"","refresh":"","sequence":"26","servlet":"..\u002fjsp-system\u002fspquerysecurity_portlet.jsp","target":"","type":"SPLinker","w":"170","x":"199","y":"257"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"Event_addQuery","objsValues":"this.db_cpprgsec.Query(true)","page":"1","parmsNames":"","sequence":"27","type":"EventReceiver","w":"170","x":"388","y":"296"}]%>
<%/*Description:*/%>
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
.spadministration_security_container .selectIcon{  text-align: center;
}
.spadministration_security_container .selectIcon::before{
  display: inline-block;
  font-family: icons8_win10;
  color: rgba(0, 0, 0, 0.93);
  font-weight: normal;
  font-size: 20px;
}
.spadministration_security_container .selectIcon.vqr::before{
  content: '\f037';
}
.spadministration_security_container .grid_icon.grid_edit::before{
  content: '\f0ba';
}
.spadministration_security_container .grid_icon.grid_delete::before{
  content: '\f041';
}
.spadministration_security_container .grid_icon{
  text-align: center;
}
.spadministration_security_container .grid_icon::before{
  display: inline-block;
  font-family: icons8_win10;
  color: rgba(0, 0, 0, 0.93);
  font-weight: normal;
  font-size: 20px;
}
.spadministration_security_container .selectIcon.boname::before{
  content: '\f036';
}
.spadministration_security_container .no-radius{
  border-radius: 0px 0px 0.5rem 0.5rem;
}
.spadministration_security_container {
  height:100%;
  overflow:auto;
}
.spadministration_security_portlet{
  position:relative;
  width:100%;
  min-width:950px;
  height:100%;
}
.spadministration_security_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.spadministration_security_portlet > .grid_procedure_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:166px;
}
.spadministration_security_portlet > .label_admin_type_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:14px;
  width:28px;
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .label_admin_type_ctrl {
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .label_admin_type_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.spadministration_security_portlet > .combobox_admin_type2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:49px;
  width:187px;
  height:20px;
}
.spadministration_security_portlet > .combobox_admin_type1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:49px;
  width:187px;
  height:22px;
}
.spadministration_security_portlet > .label_entity_name_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  right:519px;
  width:85px;
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .label_entity_name_ctrl {
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .label_entity_name_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.spadministration_security_portlet > .progname_input_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  right:214px;
  width:303px;
  height:22px;
}
.spadministration_security_portlet > .progname_input_ctrl {
}
.spadministration_security_portlet > .progname_input_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:9pt;
  width:100%;
  height:100%;
}
.spadministration_security_portlet > .bt_rule_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  right:186px;
  width:22px;
  height:22px;
}
.spadministration_security_portlet > .bt_rule_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:22px;
  font-size:22px;
}
.spadministration_security_portlet > .imageSelect_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:244px;
  width:22px;
  height:22px;
}
.spadministration_security_portlet > .imageSelect_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:22px;
  font-size:22px;
}
.spadministration_security_portlet > .labelSelect_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:270px;
  width:106px;
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .labelSelect_ctrl a {
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .labelSelect_ctrl a {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
 display:block;
}
.spadministration_security_portlet > .labelSelect_ctrl > div > a:hover{
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
}
.spadministration_security_portlet > .labelSecurity_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  right:0px;
  width:183px;
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .labelSecurity_ctrl a {
  height:auto;
  min-height:19px;
}
.spadministration_security_portlet > .labelSecurity_ctrl a {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
 display:block;
}
.spadministration_security_portlet > .labelSecurity_ctrl > div > a:hover{
  font-family:Verdana;
  font-size:9pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
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
 String def="[{\"h\":\"210\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"950\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"170\",\"x\":\"5\",\"y\":\"236\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"\"},{\"title\":\"ADMIN_TYPE\"},{\"title\":\"ADMIN_ENTITY_NAME\"}],\"h\":\"166\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"950\",\"x\":\"0\",\"y\":\"46\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_TYPE\",\"w\":\"28\",\"x\":\"14\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"combobox_admin_type2\",\"page\":\"1\",\"textlist\":\"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,Role,API\",\"type\":\"Combobox\",\"w\":\"187\",\"x\":\"49\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"combobox_admin_type1\",\"page\":\"1\",\"textlist\":\"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,Web Service Report,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,Role,API\",\"type\":\"Combobox\",\"w\":\"187\",\"x\":\"49\",\"y\":\"11\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-right\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label_entity_name\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_ENTITY_NAME\",\"w\":\"85\",\"x\":\"346\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"progname_input\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"303\",\"x\":\"433\",\"y\":\"11\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"WebServiceReportInstalled\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"5\",\"y\":\"418\"},{\"h\":\"20\",\"name\":\"progname\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"5\",\"y\":\"340\"},{\"h\":\"20\",\"name\":\"sectype_combobox\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"5\",\"y\":\"262\"},{\"h\":\"20\",\"name\":\"splinker_modificaRiga2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"199\",\"y\":\"283\"},{\"h\":\"20\",\"name\":\"splinker_viewRole\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"199\",\"y\":\"309\"},{\"h\":\"20\",\"name\":\"progname_insert\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"5\",\"y\":\"288\"},{\"h\":\"20\",\"name\":\"sectype\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"5\",\"y\":\"314\"},{\"h\":\"20\",\"name\":\"splinker_removesecurity\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"199\",\"y\":\"361\"},{\"anchor\":\"top-right\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"bt_rule\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"22\",\"x\":\"742\",\"y\":\"12\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"imageSelect\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"22\",\"x\":\"244\",\"y\":\"11\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"queryname\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"5\",\"y\":\"366\"},{\"h\":\"20\",\"name\":\"splinkeSelectQuery\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"199\",\"y\":\"387\"},{\"h\":\"20\",\"name\":\"splinkeBoName\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"199\",\"y\":\"335\"},{\"h\":\"20\",\"name\":\"EventQueryname\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"170\",\"x\":\"388\",\"y\":\"321\"},{\"h\":\"20\",\"name\":\"boname\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"5\",\"y\":\"392\"},{\"h\":\"20\",\"name\":\"EventBoName\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"170\",\"x\":\"388\",\"y\":\"346\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelSelect\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"106\",\"x\":\"270\",\"y\":\"16\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"top-right\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"labelSecurity\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_RULE_OF_SECURITY\",\"w\":\"183\",\"x\":\"767\",\"y\":\"16\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"splinker_modificaRiga1\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"199\",\"y\":\"257\"},{\"h\":\"20\",\"name\":\"Event_addQuery\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"170\",\"x\":\"388\",\"y\":\"296\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_security","UTF-8")) {return; }
 %><%if(!sp.isAdministrator() && sp.hasAdministeredUsers()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_security_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("spadministration_help.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_security','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_security_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String label_admin_type= "ADMIN_TYPE";
String combobox_admin_type2= "";
String combobox_admin_type1= "";
String label_entity_name= "ADMIN_ENTITY_NAME";
String progname_input= "";
if(request.getAttribute("spadministration_security_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String WebServiceReportInstalled=sp.getGlobal("WebServiceReportInstalled","");
String progname= "";
String sectype_combobox= "";
String progname_insert= "";
String sectype= "";
String queryname= "";
String boname= "";
String labelSelect= "";
String labelSecurity= "ADMIN_RULE_OF_SECURITY";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_security_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_security_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_security_portlet portlet-white-default no-radius' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_security','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_grid_procedure' formid='<%=idPortlet%>' ps-name='grid_procedure'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_label_admin_type'  formid='<%=idPortlet%>' ps-name='label_admin_type'    class='label label_admin_type_ctrl'><div id='<%=idPortlet%>_label_admin_typetbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("ADMIN_TYPE"))%></div></span>
<select id='<%=idPortlet%>_combobox_admin_type2' name='combobox_admin_type2' class='combobox' style='display:none;font-family:Verdana;font-size:9pt;'></select>
<select id='<%=idPortlet%>_combobox_admin_type1' name='combobox_admin_type1' class='combobox' style='display:none;font-family:Verdana;font-size:9pt;'></select>
<span id='<%=idPortlet%>_label_entity_name'  formid='<%=idPortlet%>' ps-name='label_entity_name'    class='label label_entity_name_ctrl'><div id='<%=idPortlet%>_label_entity_nametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("ADMIN_ENTITY_NAME"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_progname_input_wrp'><input id='<%=idPortlet%>_progname_input' name='progname_input' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='progname_input' /></span>
<a id='<%=idPortlet%>_bt_rule' class='image bt_rule_ctrl'  href='javascript:void(0)' target='_self'>&#xed02;</a>
<a id='<%=idPortlet%>_imageSelect' class='selectIcon imageSelect_ctrl'  href='javascript:void(0)' target='_self'></a>
<span id='<%=idPortlet%>_labelSelect'  formid='<%=idPortlet%>' ps-name='labelSelect'    class='label labelSelect_ctrl'><div id='<%=idPortlet%>_labelSelecttbl' style='width:100%;'><a id='<%=idPortlet%>_labelSelecthref'  href='javascript:void(0)'  ></a></div></span>
<span id='<%=idPortlet%>_labelSecurity'  formid='<%=idPortlet%>' ps-name='labelSecurity'    class='label labelSecurity_ctrl'><div id='<%=idPortlet%>_labelSecuritytbl' style='width:100%;'><a id='<%=idPortlet%>_labelSecurityhref' title='<%=JSPLib.ToHTML(sp.translate("ADMIN_RULE_OF_SECURITY"))%>' href='function:bt_rule_Click()'  ><%=JSPLib.ToHTML(sp.translate("ADMIN_RULE_OF_SECURITY"))%></a></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_security');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_DELETE_SECURITY",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_DELETE_SECURITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_INSERT_ENTITY",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_INSERT_ENTITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_INSERT_TYPE_AND_ENTITY",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_INSERT_TYPE_AND_ENTITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SELECT_BO",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SELECT_BO"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SELECT_QUERY",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SELECT_QUERY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SELECT_TYPE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SELECT_TYPE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_SECURITY",true)+","+JSPLib.ToJSValue(sp.translate("CP_SECURITY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_BACK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_BACK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_security',["950"],["210"],'portlet-white-default no-radius',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"950","h":"210","title":"","layer":""}]);
this.db_cpprgsec=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_prog_security","cmdHash":"<%=JSPLib.cmdHash("spquery_prog_security",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_db_cpprgsec","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"db_cpprgsec","nrows":"25","page":1,"parms":"progname=progname_input,type=sectype_combobox,type=sectype","parms_source":"","type":"SQLDataobj","w":170,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":5,"y":236});
this.grid_procedure=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"progname,type","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grid_procedure","dataobj":"db_cpprgsec","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":166,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grid_procedure","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":950,"x":0,"y":46,"zindex":""});
this.grid_procedure.setRowsCols({"draggablecolumns":true,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"center","type":"C","title":"","layer":"","ColSpan":"","newline":false,"alias":"image:<%=sp.getThemedImage("../images/grid/edit.png")%>","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"function:modifica_riga()","weight":"","printable":true,"picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"iconFont grid_icon grid_edit\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"center","type":"C","title":"","layer":"","ColSpan":"","newline":false,"alias":"image:<%=sp.getThemedImage("../images/grid/delete.png")%>","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"function:cancella_riga()","weight":"","printable":true,"picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"iconFont grid_icon grid_delete\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_TYPE"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"ADMIN_TYPE","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","printable":true,"picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"sectype","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ENTITY_NAME"),false,true)%>","printable":true,"layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"progname","fg_color":"","width":"","alias":"ADMIN_ENTITY_NAME","RowSpan":0}]});
this.label_admin_type=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_admin_type","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_admin_type","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_admin_type),false,true)%>","type":"Label","w":28,"x":14,"y":16,"zindex":"1"});
this.combobox_admin_type2=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_combobox_admin_type2","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"Verdana","font_size":"9pt","h":20,"help_tips":"","hide":"false","hide_undercond":"not(Empty(WebServiceReportInstalled))","init":"","init_par":"<%=combobox_admin_type2%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"combobox_admin_type2","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"<%=JSPLib.ToJSValue(sp.translate("Procedure"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Portlet & Pagelet"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Query"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Web Report"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SmartReport"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SOAP Endpoint Procedure"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SOAP Endpoint Report"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SOAP Endpoint Query"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Role"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("API"),false,true)%>","type":"Combobox","typevar":"character","valuelist":"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,ROLE,API","visible":true,"w":187,"x":49,"y":13,"zindex":"1"});
this.combobox_admin_type1=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_combobox_admin_type1","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"Verdana","font_size":"9pt","h":22,"help_tips":"","hide":"false","hide_undercond":"Empty(WebServiceReportInstalled)","init":"","init_par":"<%=combobox_admin_type1%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"combobox_admin_type1","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"<%=JSPLib.ToJSValue(sp.translate("Procedure"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Portlet & Pagelet"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Query"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Web Report"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SmartReport"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Web Service Report"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SOAP Endpoint Procedure"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SOAP Endpoint Report"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("SOAP Endpoint Query"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("Role"),false,true)%>,<%=JSPLib.ToJSValue(sp.translate("API"),false,true)%>","type":"Combobox","typevar":"character","valuelist":"Procedure,Portlet & Pagelet,Query,Web Report,SmartReport,Web Service Report,SOAP Endpoint Procedure,SOAP Endpoint Report,SOAP Endpoint Query,ROLE,API","visible":true,"w":187,"x":49,"y":11,"zindex":"1"});
this.label_entity_name=new ZtVWeb._LC(this,{"align":"right","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_entity_name","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_entity_name","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_entity_name),false,true)%>","type":"Label","w":85,"x":346,"y":16,"zindex":"1"});
this.progname_input=new ZtVWeb._TC(this,{"anchor":"top-right","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_progname_input","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"progname_input","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(progname_input,false,true)%>","w":303,"x":433,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.WebServiceReportInstalled=new ZtVWeb._VC(this,'WebServiceReportInstalled',null,'character','<%=JSPLib.ToJSValue(WebServiceReportInstalled,false,true)%>',false,false);
this.progname=new ZtVWeb._VC(this,'progname',null,'character','<%=JSPLib.ToJSValue(progname,false,true)%>',false,false);
this.sectype_combobox=new ZtVWeb._VC(this,'sectype_combobox',null,'character','<%=JSPLib.ToJSValue(sectype_combobox,false,true)%>',false,false);
this.splinker_modificaRiga2=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_modificaRiga2","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_modificaRiga2","offline":false,"page":1,"parms":"progname=progname_insert","popup":"true","popup_height":"820","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"1000","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp","target":"","type":"SPLinker","w":170,"x":199,"y":283});
this.splinker_modificaRiga2.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spproceduresecurity_portlet.jsp",request.getSession())%>';
this.splinker_viewRole=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_viewRole","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_viewRole","offline":false,"page":1,"parms":"progname=progname_insert","popup":"true","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"700","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fsprolesecurity_portlet.jsp","target":"","type":"SPLinker","w":170,"x":199,"y":309});
this.splinker_viewRole.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/sprolesecurity_portlet.jsp",request.getSession())%>';
this.progname_insert=new ZtVWeb._VC(this,'progname_insert',null,'character','<%=JSPLib.ToJSValue(progname_insert,false,true)%>',false,false);
this.sectype=new ZtVWeb._VC(this,'sectype',null,'character','<%=JSPLib.ToJSValue(sectype,false,true)%>',false,false);
this.splinker_removesecurity=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_removesecurity","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_removesecurity","offline":false,"page":1,"parms":"progname=progname","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spremovesecurity","target":"","type":"SPLinker","w":170,"x":199,"y":361});
this.splinker_removesecurity.m_cID='<%=JSPLib.cmdHash("routine,spremovesecurity",request.getSession())%>';
this.bt_rule=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image bt_rule_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_bt_rule","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xed02;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_RULE_OF_SECURITY"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"bt_rule","page":1,"path_type":"themed","server_side":"","spuid":"","src":"&#xed02;","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":22,"x":742,"y":12,"zindex":"1"});
 ZtVWeb.RequireFont("icons8_win10","");
this.imageSelect=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"selectIcon imageSelect_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imageSelect","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"font icon","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"imageSelect","page":1,"path_type":"","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":22,"x":244,"y":11,"zindex":"1"});
 ZtVWeb.RequireFont("icons8_win10","");
this.queryname=new ZtVWeb._VC(this,'queryname',null,'character','<%=JSPLib.ToJSValue(queryname,false,true)%>',false,false);
this.splinkeSelectQuery=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkeSelectQuery","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkeSelectQuery","offline":false,"page":1,"parms":"","popup":"true","popup_height":"400","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"350","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fgsso_select_vqr_portlet.jsp","target":"","type":"SPLinker","w":170,"x":199,"y":387});
this.splinkeSelectQuery.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/gsso_select_vqr_portlet.jsp",request.getSession())%>';
this.splinkeBoName=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkeBoName","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkeBoName","offline":false,"page":1,"parms":"","popup":"true","popup_height":"400","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"700","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fgsso_get_bo_name_portlet.jsp","target":"","type":"SPLinker","w":170,"x":199,"y":335});
this.splinkeBoName.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/gsso_get_bo_name_portlet.jsp",request.getSession())%>';
this.EventQueryname=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"queryname,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_EventQueryname","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"EventQueryname","objsValues":"queryname,this.salvaNomeQuery()","page":1,"parmsNames":"queryname","type":"EventReceiver","w":170,"x":388,"y":321});
this.boname=new ZtVWeb._VC(this,'boname',null,'character','<%=JSPLib.ToJSValue(boname,false,true)%>',false,false);
this.EventBoName=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"boname,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_EventBoName","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"EventBoName","objsValues":"boname,this.salvaNomeBo()","page":1,"parmsNames":"boname","type":"EventReceiver","w":170,"x":388,"y":346});
this.labelSelect=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelSelect","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelSelect","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelSelect),false,true)%>","type":"Label","w":106,"x":270,"y":16,"zindex":"1"});
this.labelSecurity=new ZtVWeb._LC(this,{"align":"left","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_labelSecurity","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"function:bt_rule_Click()","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelSecurity","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(labelSecurity),false,true)%>","type":"Label","w":183,"x":767,"y":16,"zindex":"1"});
this.splinker_modificaRiga1=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_modificaRiga1","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_modificaRiga1","offline":false,"page":1,"parms":"progname=progname_insert","popup":"true","popup_height":"820","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"1000","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspquerysecurity_portlet.jsp","target":"","type":"SPLinker","w":170,"x":199,"y":257});
this.splinker_modificaRiga1.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spquerysecurity_portlet.jsp",request.getSession())%>';
this.Event_addQuery=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_addQuery","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_addQuery","objsValues":"this.db_cpprgsec.Query(true)","page":1,"parmsNames":"","type":"EventReceiver","w":170,"x":388,"y":296});
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
<%request.setAttribute("spadministration_security_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_security_Static=function(){
if(typeof nascondi_nome_entita !='undefined')this.nascondi_nome_entita=nascondi_nome_entita;
if(typeof mostra_nome_entita !='undefined')this.mostra_nome_entita=mostra_nome_entita;
if(typeof mostra_select !='undefined')this.mostra_select=mostra_select;
if(typeof nascondi_select !='undefined')this.nascondi_select=nascondi_select;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof combobox_admin_type1_onChange !='undefined')this.combobox_admin_type1_onChange=combobox_admin_type1_onChange;
if(typeof combobox_admin_type2_onChange !='undefined')this.combobox_admin_type2_onChange=combobox_admin_type2_onChange;
if(typeof RefreshGrid !='undefined')this.RefreshGrid=RefreshGrid;
if(typeof progname_onChange !='undefined')this.progname_onChange=progname_onChange;
if(typeof modifica_riga !='undefined')this.modifica_riga=modifica_riga;
if(typeof reQuery !='undefined')this.reQuery=reQuery;
if(typeof bt_rule_Click !='undefined')this.bt_rule_Click=bt_rule_Click;
if(typeof cancella_riga !='undefined')this.cancella_riga=cancella_riga;
if(typeof imageSelect_Click !='undefined')this.imageSelect_Click=imageSelect_Click;
if(typeof labelSelect_Click !='undefined')this.labelSelect_Click=labelSelect_Click;
if(typeof salvaNomeQuery !='undefined')this.salvaNomeQuery=salvaNomeQuery;
if(typeof salvaNomeBo !='undefined')this.salvaNomeBo=salvaNomeBo;
if(typeof splinker_removesecurity_Result !='undefined')this.splinker_removesecurity_Result=splinker_removesecurity_Result;
if(typeof getEditImage !='undefined')this.getEditImage=getEditImage;
if(typeof getDeleteImage !='undefined')this.getDeleteImage=getDeleteImage;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(!(Empty(this.WebServiceReportInstalled.Value())),this.combobox_admin_type2);
ZtVWeb.HideCtrl(Empty(this.WebServiceReportInstalled.Value()),this.combobox_admin_type1);
}
this.db_cpprgsec.addRowConsumer(this.grid_procedure);
this.db_cpprgsec.addDataConsumer(this.progname,<%=JSPLib.ToJSValue("progname",true)%>);
this.db_cpprgsec.addDataConsumer(this.sectype,<%=JSPLib.ToJSValue("sectype",true)%>);
var that = this;
m_cProgName='spsecurity';
m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
this.grid_procedure.SPLinkerActions.E.action='start';
function nascondi_nome_entita(){
  //funzione che viene utilizzata per nascondere la textbox per inserimento del nome dell'entit? 
  //e il bottone per l'inserimento delle sicurezze
  this.label_entity_name.Hide();
  this.progname_input.Hide();
  this.bt_rule.Hide();
  this.labelSecurity.Hide();
}
function mostra_nome_entita(){
  //funzione utilizzata per mostrare la textbox per inserimento del nome dell'entit? 
  //e il bottone per l'inserimento delle sicurezze
  this.label_entity_name.Show();
  this.progname_input.Show();
  this.bt_rule.Show();
  this.labelSecurity.Show();
}
function mostra_select(){
  //funzione utilizzata per mostrare l'immagine per inserimento delle Procedure/Query 
  this.imageSelect.Show();
  this.labelSelect.Show();
}
function nascondi_select(){
  //funzione utilizzata per nascondere l'immagine per inserimento delle Procedure/Query 
  this.imageSelect.Hide();
  this.labelSelect.Hide();
}
function this_Loaded(){
//l'utente vedr? di default soltanto il combobox con i Tipi
  that.nascondi_select();
  that.nascondi_nome_entita();
  var customToolbar=this.getTitlePortlet();
  if(m_cTarget != "_blank") {
    customToolbar.AppendButton({
      image:SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
      action:'../servlet/SPControlPanel',
      title:FormatMsg("MSG_BACK"),
      tooltip:FormatMsg("ADMIN_BACK_TO_CP")
    })
  }
  customToolbar.AppendButton({
  	image:SPTheme.controlPanelHelp || '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
    action:'javascript:Help()',
    title:FormatMsg("ADMIN_HELP_TITLE"),
    tooltip:FormatMsg("ADMIN_HELP_TITLE")
  })
  customToolbar.SetTitle(FormatMsg("CP_SECURITY"));
  customToolbar.RearrangeAll();
}
function combobox_admin_type1_onChange(){
//al cambiare del valore del combobox esegue una ricerca e a seconda del caso mostra/nasconde 
//le immagini per la selezione delle Procedure/Query e la textbox per l'inserimento delle sicurezze
//se nel combobox non viene scelto nessun valore allora esse non verrano mostrate all'utente
  this.sectype_combobox.Set(this.combobox_admin_type1.Value());
  this.db_cpprgsec.Query();
  that.nascondi_select();
  switch (LRTrim(this.sectype_combobox.Value())){
    case '':
      that.nascondi_nome_entita();
      break;
    case 'Procedure':
      this.imageSelect.Ctrl.className = "selectIcon imageSelect_ctrl boname"; 
      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_BO'));
      that.mostra_select();
      that.mostra_nome_entita();
      this.progname_input.Set();
      break;
    case 'Query':
      this.imageSelect.Ctrl.className = "selectIcon imageSelect_ctrl vqr";
      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_QUERY'));
      that.mostra_select();
      that.nascondi_nome_entita();
      this.progname_input.Set();
      break;
    case 'ROLE':
      that.nascondi_nome_entita();
      this.progname_input.Set();
      break;
    default:
      that.mostra_nome_entita();
      this.progname_input.Set();
      break;
  }
}
function combobox_admin_type2_onChange(){
//al cambiare del valore del combobox esegue una ricerca e a seconda del caso mostra/nasconde 
//le immagini per la selezione delle Procedure/Query e la textbox per l'inserimento delle sicurezze
//se nel combobox non viene scelto nessun valore allora esse non verrano mostrate all'utente
  this.sectype_combobox.Set(this.combobox_admin_type2.Value());
  this.db_cpprgsec.Query();
  that.nascondi_select();
  switch (LRTrim(this.sectype_combobox.Value())){
    case '':
      that.nascondi_nome_entita();
      break;
    case 'Procedure':
      this.imageSelect.Ctrl.className = "selectIcon imageSelect_ctrl boname";
      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_BO'));
      that.mostra_select();
      that.mostra_nome_entita();
      this.progname_input.Set();
      break;
    case 'Query':
      this.imageSelect.Ctrl.className = "selectIcon imageSelect_ctrl vqr";
      this.labelSelect.Value(FormatMsg('ADMIN_SELECT_QUERY'));
      that.mostra_select();
      that.nascondi_nome_entita();
      this.progname_input.Set();
      break;
    case 'ROLE':
      that.nascondi_nome_entita();
      this.progname_input.Set();
      break;
    default:
      that.mostra_nome_entita();
      this.progname_input.Set();
      break;
  }
}
function RefreshGrid(){
//permette di aggiornare la griglia
  this.grid_procedure.Refresh();
}
function progname_onChange(){
  this.progname.Value(this.progname.Value().trim());
}
function modifica_riga(){
//modifica sicurezza
  this.progname_insert.Set(this.progname.Value());
  if (this.sectype.Value()=='Query' || 
      this.sectype.Value()=='Portlet & Pagelet' || 
      this.sectype.Value()=='Web Report' || 
      this.sectype.Value()=='SmartReport'){
    this.splinker_modificaRiga1.Link();
  }else{
    if (this.sectype.Value()=='Role') {
      this.splinker_viewRole.Link();
    } else {
      this.splinker_modificaRiga2.Link();
    }
  }
}
function reQuery(){
  //nel caso in cui si cancella dalla tabella delle sicurezze un'entit?, viene forzata l'esecuzione
  //della Query
  that.db_cpprgsec.Query(true);
}
function bt_rule_Click(){
//aggiunge sicurezza; si attiva solo se ? stato selezionato un tipo e se'Nome entit?' non ? vuoto
  if((!Empty(this.sectype_combobox.Value()))&&(!Empty(this.progname_input.Value()))){
    switch (LRTrim(this.sectype_combobox.Value())){
      case 'Procedure':
        this.progname_input.Set(this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga2.Link();
        break;
      case 'Query':
        this.progname_input.Set('vqr/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga1.Link();
        break;
      case 'Portlet & Pagelet':
        this.progname_input.Set('ps/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga1.Link();
        break;
      case 'Web Report':
        this.progname_input.Set('vrp/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga1.Link();
        break;
      case 'SmartReport':
        this.progname_input.Set('svrp/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga1.Link();
        break;
      case 'Web Service Report':
        this.progname_input.Set('wsrp/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga2.Link();
        break;
      case 'SOAP Endpoint Procedure':
        this.progname_input.Set('soap/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga2.Link();
        break;
      case 'SOAP Endpoint Report':
        this.progname_input.Set('soap/vrp/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga2.Link();
        break;
      case 'SOAP Endpoint Query':
        this.progname_input.Set('soap/query/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga2.Link();
        break;
      case 'ROLE':
        this.progname_input.Set('r/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_viewRole.Link();
        break;
      case 'API':
        this.progname_input.Set('API/' + this.progname_input.Value());
        this.progname_insert.Set(this.progname_input.Value());
        this.splinker_modificaRiga2.Link();
        break;
    }
    this.progname_input.Set('');
  } else
  {
    if ((Empty(this.sectype_combobox.Value()))&&(!Empty(this.progname_input.Value()))){
      alert(FormatMsg('ADMIN_SELECT_TYPE'));
    } else
    {
      if ((!Empty(this.sectype_combobox.Value()))&&(Empty(this.progname_input.Value()))){
        alert(FormatMsg('ADMIN_INSERT_ENTITY'));
      }
    }
  }
  if((Empty(this.sectype_combobox.Value()))&&(Empty(this.progname_input.Value()))){
    alert(FormatMsg('ADMIN_INSERT_TYPE_AND_ENTITY'));
  }
}
function cancella_riga(){
//cancella sicurezza
  var _this=this;
  WindowConfirm(FormatMsg('ADMIN_DELETE_SECURITY'), function(res){
    if(res){
      _this.splinker_removesecurity.Link();
      //setTimeout(that.reQuery,10);
    }
  });
}
function imageSelect_Click(){
//apre un Popup che permette di scegliere la Query o il BO da mettere sotto sicurezza
  if (this.sectype_combobox.Value()=='Query'){
    this.splinkeSelectQuery.Link();
  }else{
    this.splinkeBoName.Link();
  }
}
function labelSelect_Click(){
//apre un Popup che permette di scegliere la Query o il BO da mettere sotto sicurezza
  if (this.sectype_combobox.Value()=='Query'){
    this.splinkeSelectQuery.Link();
  }else{
    this.splinkeBoName.Link();
  }
}
function salvaNomeQuery(){
//passa il nome della Query selezionata dal Popup alla textbox 'Entity name' per poterla aggiungere alle sicurezze  
  if (this.queryname.Value()){ 
    this.progname_input.Set('vqr/' + this.queryname.Value());
    this.progname_insert.Set(this.progname_input.Value());
    this.splinker_modificaRiga1.Link();
    this.progname_input.Set('');
  }
}
function salvaNomeBo(){
//passa il nome del BO selezionato dal Popup alla textbox 'Entity name' per poterlo aggiungere alle sicurezze
  if(this.boname.Value()){
    this.progname_insert.Set(this.boname.Value());
    this.splinker_modificaRiga2.Link();
    this.progname_input.Set('');
  }
}
function splinker_removesecurity_Result(result){
  this.db_cpprgsec.Query(true);
}
function getEditImage(){
  var url="<img src='";
  url+=SPTheme.grid_img_action_edit||ZtVWeb.SPWebRootURL+"/visualweb/images/grid_edit.png";
  url+="' alt='' title='' border='0'>";
  return url;
}
function getDeleteImage(){
  var url="<img src='";
  url+=SPTheme.grid_img_action_delete||ZtVWeb.SPWebRootURL+"/visualweb/images/grid_delete.png";
  url+="' alt='' title='' border='0'>";
  return url
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_security_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.bt_rule.dispatchEvent('OnLoad');
window.<%=idPortlet%>.imageSelect.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_EventQueryname=function(parmsObj){<%=idPortlet%>.EventQueryname.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_EventBoName=function(parmsObj){<%=idPortlet%>.EventBoName.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_Event_addQuery=function(parmsObj){<%=idPortlet%>.Event_addQuery.receiveFnc(parmsObj);}
window.<%=idPortlet%>.db_cpprgsec.firstQuery('true');
window.<%=idPortlet%>.combobox_admin_type2.FillData();
window.<%=idPortlet%>.combobox_admin_type1.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_security',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_security');
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
sp.endPage("spadministration_security");
}%>
<%! public String getJSPUID() { return "2049361878"; } %>