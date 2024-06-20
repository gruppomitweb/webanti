<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Calculate(){\n  \n}\nFormatMsg('ADMIN_SECURITY_ALLOW');\nFormatMsg('ADMIN_SECURITY_DENY');\nFormatMsg('ADMIN_SECURITY_NO_VALUE');\nFormatMsg('ADMIN_ACCESS_PWD');\nFormatMsg('ADMIN_ACCESS_OTP');\n\nvar cSkin='\u003c%=sp.getSkin()%\u003e'\nm_cProgName='spproceduresecurity'\n\nfunction this_Loaded(){\n  this.label_title.Value(\"\u003cb\u003e\"+FormatMsg('ADMIN_ENTITY_NAME')+\": \u003c\u002fb\u003e\"+this.progname.Value());\n  this.splinker_getEntityRoles.Link();\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AddButton(SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n                          'javascript:Help()','','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e');\n  customToolbar.SetTitle('\u003c%=sp.translate(\"ADMIN_MANAGE_SECURITY\")%\u003e');\n  var added = customToolbar.AddButton(SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n                                      'javascript:'+this.formid+'.btn_apply_Click();','','\u003c%=sp.translate(\"MSG_BACK\")%\u003e','\u003c%=sp.translate(\"ADMIN_BACK_TO_CP\")%\u003e');\n  if(added) {\n    \u002f\u002f se l'aggiunta del bottone alla Custom Toolbar avviene con successo nascondo il tasto \"manuale\"\n    this.btn_apply.Hide();\n  }\n  customToolbar.RearrangeAll();\n  this.Grid_Users.SetOrderBy('usrname','asc');\n  this.dataobj_security_for_procedure_users.Query();\n  this.Grid_Groups.SetOrderBy('grpname','asc');\n  this.dataobj_security_for_procedure_groups.Query();\n}\n\nfunction btn_addgroup_Click(){\n\tthis.splinker_selectgroup.Link();\n}\n\nfunction btn_adduser_Click(){\n  this.splinker_selectuser.Link();\n}\n\nfunction splinker_deletesecurityuser_Result(result){\n\tthis.dataobj_security_for_procedure_users.Query(true);\n}\n\nfunction splinker_deletesecuritygroup_Result(result){\n\tthis.dataobj_security_for_procedure_groups.Query(true);\n }\n\nfunction splinker_changesecurityaccess_user_Result(result){\n\tthis.dataobj_security_for_procedure_users.Query(true);\n}\n\nfunction splinker_changesecurityaccess_group_Result(result){\n\tthis.dataobj_security_for_procedure_groups.Query(true);\n}\n\nfunction btn_apply_Click(){\n  this.Event_addQuery.Emit();\n\tWindowClose();\n}\n\nfunction splinker_getEntityRoles_Result(result){\n\tif(!Empty(LRTrim(result))){\n  \tthis.label_roles.Value(\"\u003cb\u003e\"+FormatMsg('ADMIN_ROLES')+\": \u003c\u002fb\u003e\"+result);\n  \tthis.filter_roles.Value(\"'\"+Strtran(result, \", \", \"','\")+\"'\");\n    \u002f\u002falert(this.filter_roles.Value());\n  } else {\n  \tthis.label_roles.Value(\"\u003cb\u003e\"+FormatMsg('ADMIN_ROLES')+\": \u003c\u002fb\u003e\"+FormatMsg('ADMIN_NO_ROLES'));\n  \tthis.filter_roles.Value(\"\");\n  }\n}\n\nfunction getDeleteImg(){  \n\tvar img=SPTheme.grid_img_action_delete||ZtVWeb.SPWebRootURL+\"\u002fvisualweb\u002fimages\u002fgrid_delete.png\";\n  return \"\u003cimg src='\"+img+\"' border='0' \u002f\u003e\"\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"styles\u002fspadministration_skin.ce.css","css_class":"portlet-white-noradius","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"\",\"size\":\"\",\"weight\":\"\",\"align\":\"center\",\"code\":\"\"},\"hover\":{},\":before\":{\"display\":\"inline-block\",\"content\":\"\",\"size\":\"20px\",\"weight\":\"normal\",\"font_color\":\"rgba(0, 0, 0, 0.93)\",\"code\":\"font-family: icons8_win10;\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon\",\"id\":\"form\",\"code\":\".grid_icon {\\n  text-align: center;\\n}\\n\\n.grid_icon::before {\\n  display: inline-block;\\n  font-family: icons8_win10;\\n  color: rgba(0, 0, 0, 0.93);\\n  font-weight: normal;\\n  font-size: 20px;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{\"content\":\"\\\\f041\",\"code\":\"\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon.grid_delete\",\"id\":\"form\",\"code\":\".grid_icon.grid_delete::before {\\n  content: '\\\\f041';\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\",\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"button\",\"class_name\":\"cursor\",\"selector\":\".cursor\",\"value\":\"ADMIN_CLOSE\",\"class_Css\":\"label\",\"id\":\"form\",\"code\":\".cursor {\\n  cursor: pointer;\\n}\\n\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @label_title }}{{ @Grid_Users }}{{ @Grid_Groups }}{{ @btn_adduser }}{{ @btn_addgroup }}{{ @btn_apply }}{{ @Lbl_Users }}{{ @Lbl_Groups }}{{ @label_roles }}\u003c\u002fbody\u003e","grapesCss":"","h":"610","hsl":"","htmlcode":"{{ @label_title }}\n{{ @Grid_Users }}\n{{ @Grid_Groups }}\n{{ @btn_adduser }}\n{{ @btn_addgroup }}\n{{ @btn_apply }}\n{{ @Lbl_Users }}\n{{ @Lbl_Groups }}\n{{ @label_roles }}\n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"false","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"610\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"700","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_title","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"MANAGE SECURITY","w":"674","wireframe_props":"align,value,n_col","x":"15","y":"10","zindex":"2","zone":""},{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"progname,usrcode","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fimages\u002fgrid\u002fdelete.png\\\")%\u003e\",\"align\":\"center\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"iconFont grid_icon grid_delete\\\"\u003e\u003c\u002fspan\u003e\",\"maxwidth\":\"\",\"title\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:splinker_deletesecurityuser.Link()\",\"disable_fields_conditions\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"height\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_USERNAME_SECURITY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"usrname\",\"maxwidth\":\"\",\"title\":\"ADMIN_USERNAME_SECURITY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_ACCESS\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_ACCESS\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_INSERT\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec2:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_INSERT\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_MODIFY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec3:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_MODIFY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_DELETE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec4:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_DELETE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"}]","css_class_card_container":"","css_class_grid":"grid Admin-border-grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataobj_security_for_procedure_users","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"190","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Users","nav_bar":"true","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"5","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"true","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"675","wireframe_props":"colProperties,checkbox,rows","x":"15","y":"90","zindex":"","zone":""},{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"progname,grpcode","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fimages\u002fgrid\u002fdelete.png\\\")%\u003e\",\"align\":\"center\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"iconFont grid_icon grid_delete\\\"\u003e\u003c\u002fspan\u003e\",\"maxwidth\":\"\",\"title\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:splinker_deletesecuritygroup.Link()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"height\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_GROUPNAME_SECURITY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"grpname\",\"maxwidth\":\"\",\"title\":\"ADMIN_GROUPNAME_SECURITY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_ACCESS\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_ACCESS\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_INSERT\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec2:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_INSERT\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_MODIFY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec3:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_MODIFY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_DELETE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec4:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_DELETE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"}]","css_class_card_container":"","css_class_grid":"grid Admin-border-grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataobj_security_for_procedure_groups","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"190","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Groups","nav_bar":"true","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"5","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"true","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"675","wireframe_props":"colProperties,checkbox,rows","x":"15","y":"360","zindex":"","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_selectuser","offline":"false","page":"1","parms":"progname,backto","popup":"false","popup_height":"370","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":"","refresh":"","sequence":"3","servlet":"..\u002fjsp-system\u002fspselectsecurityuser_portlet.jsp","target":"","type":"SPLinker","w":"254","x":"916","y":"120"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_selectgroup","offline":"false","page":"1","parms":"progname,filter_roles,backto","popup":"false","popup_height":"320","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":"","refresh":"","sequence":"4","servlet":"..\u002fjsp-system\u002fspselectsecuritygroup_portlet.jsp","target":"","type":"SPLinker","w":"254","x":"916","y":"143"},{"calculate":"","ctrlOfVariant":"","dataobj":"dataobj_security_for_procedure_groups","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"grpcode","h":"20","init":"","init_par":"","name":"c_grpcode","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"254","x":"916","y":"51"},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button cursor","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btn_adduser","page":"1","rapp":"","sequence":"6","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_ADD_USER","w":"150","wireframe_props":"value","x":"540","y":"294","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button cursor","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btn_addgroup","page":"1","rapp":"","sequence":"7","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_ADD_GROUP","w":"148","wireframe_props":"value","x":"540","y":"564","zindex":"1","zone":""},{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button cursor","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","fixed":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"btn_apply","page":"1","rapp":"","sequence":"8","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_CLOSE","w":"148","wireframe_props":"value","x":"385","y":"564","zindex":"1","zone":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"20","name":"Event_addQuery","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"9","type":"EventEmitter","w":"254","x":"916","y":"235"},{"calculate":"","ctrlOfVariant":"","dataobj":"dataobj_security_for_procedure_users","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"usrcode","h":"20","init":"","init_par":"","name":"c_usrcode","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"254","x":"916","y":"28"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Lbl_Users","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CP_USERS","w":"674","wireframe_props":"align,value,n_col","x":"15","y":"60","zindex":"1","zone":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Lbl_Groups","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CP_GROUPS","w":"674","wireframe_props":"align,value,n_col","x":"15","y":"331","zindex":"1","zone":""},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"5","name":"dataobj_security_for_procedure_users","offline":"false","page":"1","parms":"progname","parms_source":"","query":"spquery_security_for_procedure_users","query_async":"false","return_fields_type":"true","sequence":"13","type":"SQLDataobj","w":"254","waiting_mgs":"","x":"916","y":"281"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"5","name":"dataobj_security_for_procedure_groups","offline":"false","page":"1","parms":"progname,filter_roles","parms_source":"","query":"spquery_security_for_procedure_groups","query_async":"false","return_fields_type":"true","sequence":"14","type":"SQLDataobj","w":"254","waiting_mgs":"","x":"916","y":"258"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"hasStates","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"logic","w":"254","x":"916","y":"-41"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"splinker_deletesecurityuser","offline":"false","page":"1","parms":"progname,usrcode=c_usrcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":"254","x":"916","y":"212"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"splinker_deletesecuritygroup","offline":"false","page":"1","parms":"progname,grpcode=c_grpcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":"254","x":"916","y":"189"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"roles_for_entity","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"254","x":"916","y":"-18"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"progname","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"254","x":"916","y":"5"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_roles","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Role","w":"674","wireframe_props":"align,value,n_col","x":"15","y":"35","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"splinker_getEntityRoles","offline":"false","page":"1","parms":"progname","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"21","servlet":"spgetentityroles","target":"","type":"SPLinker","w":"254","x":"916","y":"166"},{"calculate":"'..\u002fjsp-system\u002fspadministration_pg_procedure_security.jsp'","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"true","init_par":"","name":"backto","page":"1","reactive":"","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"254","x":"916","y":"97"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filter_roles","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"254","x":"916","y":"74"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:progname*/%>
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
.spproceduresecurity_container .grid_icon{  text-align: center;
}
.spproceduresecurity_container .grid_icon::before{
  display: inline-block;
  font-family: icons8_win10;
  color: rgba(0, 0, 0, 0.93);
  font-weight: normal;
  font-size: 20px;
}
.spproceduresecurity_container .grid_icon.grid_delete::before{
  content: '\f041';
}
.spproceduresecurity_container .cursor{
  cursor: pointer;
}
.spproceduresecurity_container {
}
.spproceduresecurity_portlet{
  position:relative;
  width:100%;
  min-width:700px;
  height:610px;
}
.spproceduresecurity_portlet[Data-page="1"]{
  height:610px;
  width:100%;
}
.spproceduresecurity_portlet > .label_title_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:10px;
  left:15px;
  right:11px;
  width:auto;
  height:auto;
  min-height:20px;
}
.spproceduresecurity_portlet > .label_title_ctrl {
  height:auto;
  min-height:20px;
}
.spproceduresecurity_portlet > .label_title_ctrl {
  overflow:hidden;
  text-align:left;
}
.spproceduresecurity_portlet > .Grid_Users_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:90px;
  left:15px;
  right:10px;
  width:auto;
  height:auto;
  min-height:190px;
}
.spproceduresecurity_portlet > .Grid_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:360px;
  left:15px;
  right:10px;
  width:auto;
  height:auto;
  min-height:190px;
}
.spproceduresecurity_portlet > .btn_adduser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:294px;
  right:10px;
  width:150px;
  height:28px;
}
.spproceduresecurity_portlet > .btn_adduser_ctrl {
}
.spproceduresecurity_portlet > .btn_addgroup_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:564px;
  right:12px;
  width:148px;
  height:28px;
}
.spproceduresecurity_portlet > .btn_addgroup_ctrl {
}
.spproceduresecurity_portlet > .btn_apply_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:564px;
  right:167px;
  width:148px;
  height:28px;
}
.spproceduresecurity_portlet > .btn_apply_ctrl {
}
.spproceduresecurity_portlet > .Lbl_Users_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:15px;
  width:674px;
  height:auto;
  min-height:20px;
}
.spproceduresecurity_portlet > .Lbl_Users_ctrl {
  height:auto;
  min-height:20px;
}
.spproceduresecurity_portlet > .Lbl_Users_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:left;
  background-color:transparent;
}
.spproceduresecurity_portlet > .Lbl_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:331px;
  left:15px;
  width:674px;
  height:auto;
  min-height:19px;
}
.spproceduresecurity_portlet > .Lbl_Groups_ctrl {
  height:auto;
  min-height:19px;
}
.spproceduresecurity_portlet > .Lbl_Groups_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:left;
  background-color:transparent;
}
.spproceduresecurity_portlet > .label_roles_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:35px;
  left:15px;
  right:11px;
  width:auto;
  height:auto;
  min-height:20px;
}
.spproceduresecurity_portlet > .label_roles_ctrl {
  height:auto;
  min-height:20px;
}
.spproceduresecurity_portlet > .label_roles_ctrl {
  overflow:hidden;
  text-align:left;
  background-color:transparent;
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
 String def="[{\"h\":\"610\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"700\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MANAGE SECURITY\",\"w\":\"674\",\"x\":\"15\",\"y\":\"10\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"ADMIN_USERNAME_SECURITY\"},{\"isEditable\":true,\"title\":\"ADMIN_ACCESS\"},{\"isEditable\":true,\"title\":\"ADMIN_INSERT\"},{\"isEditable\":true,\"title\":\"ADMIN_MODIFY\"},{\"isEditable\":true,\"title\":\"ADMIN_DELETE\"}],\"h\":\"190\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"5\",\"type\":\"Grid\",\"w\":\"675\",\"x\":\"15\",\"y\":\"90\",\"zindex\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"ADMIN_GROUPNAME_SECURITY\"},{\"isEditable\":true,\"title\":\"ADMIN_ACCESS\"},{\"isEditable\":true,\"title\":\"ADMIN_INSERT\"},{\"isEditable\":true,\"title\":\"ADMIN_MODIFY\"},{\"isEditable\":true,\"title\":\"ADMIN_DELETE\"}],\"h\":\"190\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"5\",\"type\":\"Grid\",\"w\":\"675\",\"x\":\"15\",\"y\":\"360\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"254\",\"x\":\"916\",\"y\":\"120\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"254\",\"x\":\"916\",\"y\":\"143\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"254\",\"x\":\"916\",\"y\":\"51\"},{\"anchor\":\"top-right\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_ADD_USER\",\"w\":\"150\",\"x\":\"540\",\"y\":\"294\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_ADD_GROUP\",\"w\":\"148\",\"x\":\"540\",\"y\":\"564\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_CLOSE\",\"w\":\"148\",\"x\":\"385\",\"y\":\"564\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"254\",\"x\":\"916\",\"y\":\"235\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"254\",\"x\":\"916\",\"y\":\"28\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CP_USERS\",\"w\":\"674\",\"x\":\"15\",\"y\":\"60\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CP_GROUPS\",\"w\":\"674\",\"x\":\"15\",\"y\":\"331\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"254\",\"x\":\"916\",\"y\":\"281\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"254\",\"x\":\"916\",\"y\":\"258\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"254\",\"x\":\"916\",\"y\":\"-41\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"254\",\"x\":\"916\",\"y\":\"212\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"254\",\"x\":\"916\",\"y\":\"189\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"254\",\"x\":\"916\",\"y\":\"-18\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"254\",\"x\":\"916\",\"y\":\"5\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Role\",\"w\":\"674\",\"x\":\"15\",\"y\":\"35\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"254\",\"x\":\"916\",\"y\":\"166\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"254\",\"x\":\"916\",\"y\":\"97\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"254\",\"x\":\"916\",\"y\":\"74\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spproceduresecurity","UTF-8")) {return; }
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
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spproceduresecurity_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script>
/*JS_MARKER_START*/
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("styles/spadministration_skin.ce.min.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("styles/spadministration_skin.ce.min.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("styles/spadministration_skin.ce.min.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/styles/spadministration_skin.ce.min.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("spadministration_help.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spproceduresecurity','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label_title= "MANAGE SECURITY";
if(request.getAttribute("spproceduresecurity_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String c_grpcode= "";
String c_usrcode= "";
String Lbl_Users= "CP_USERS";
String Lbl_Groups= "CP_GROUPS";
boolean hasStates= false;
String roles_for_entity= "";
String progname=JSPLib.translateXSS(sp.getParameter("progname",""));
String label_roles= "Role";
String backto= "";
String filter_roles= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spproceduresecurity_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spproceduresecurity_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spproceduresecurity_portlet portlet-white-noradius' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spproceduresecurity','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_label_title'  formid='<%=idPortlet%>' ps-name='label_title'    class='label label_title_ctrl'><div id='<%=idPortlet%>_label_titletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MANAGE SECURITY"))%></div></span>
<div id='<%=idPortlet%>_Grid_Users' formid='<%=idPortlet%>' ps-name='Grid_Users'   class='grid Admin-border-grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<div id='<%=idPortlet%>_Grid_Groups' formid='<%=idPortlet%>' ps-name='Grid_Groups'   class='grid Admin-border-grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<input id='<%=idPortlet%>_btn_adduser' type='button' class='button cursor btn_adduser_ctrl'/>
<input id='<%=idPortlet%>_btn_addgroup' type='button' class='button cursor btn_addgroup_ctrl'/>
<input id='<%=idPortlet%>_btn_apply' type='button' class='button cursor btn_apply_ctrl'/>
<span id='<%=idPortlet%>_Lbl_Users'  formid='<%=idPortlet%>' ps-name='Lbl_Users'    class='label Lbl_Users_ctrl'><div id='<%=idPortlet%>_Lbl_Userstbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CP_USERS"))%></div></span>
<span id='<%=idPortlet%>_Lbl_Groups'  formid='<%=idPortlet%>' ps-name='Lbl_Groups'    class='label Lbl_Groups_ctrl'><div id='<%=idPortlet%>_Lbl_Groupstbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CP_GROUPS"))%></div></span>
<span id='<%=idPortlet%>_label_roles'  formid='<%=idPortlet%>' ps-name='label_roles'    class='label label_roles_ctrl'><div id='<%=idPortlet%>_label_rolestbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Role"))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spproceduresecurity');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ACCESS_OTP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS_OTP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ACCESS_PWD",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS_PWD"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ENTITY_NAME",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ENTITY_NAME"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_NO_ROLES",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_NO_ROLES"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ROLES",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ROLES"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SECURITY_ALLOW",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SECURITY_ALLOW"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SECURITY_DENY",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SECURITY_DENY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SECURITY_NO_VALUE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SECURITY_NO_VALUE"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spproceduresecurity',["700"],["610"],'portlet-white-noradius',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"700","h":"610","title":"","layer":""}]);
this.label_title=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_title","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_title","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_title),false,true)%>","type":"Label","w":674,"x":15,"y":10,"zindex":"2"});
this.Grid_Users=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"progname,usrcode","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid Admin-border-grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Users","dataobj":"dataobj_security_for_procedure_users","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":190,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Users","nav_bar":"true","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"true","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":675,"x":15,"y":90,"zindex":""});
this.Grid_Users.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"center","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"image:<%=sp.getThemedImage("../images/grid/delete.png")%>","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"function:splinker_deletesecurityuser.Link()","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"iconFont grid_icon grid_delete\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_USERNAME_SECURITY"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"ADMIN_USERNAME_SECURITY","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"usrname","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_ACCESS","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_INSERT"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_INSERT","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec2:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_MODIFY"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_MODIFY","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec3:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DELETE"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_DELETE","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec4:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_Users.m_cID='<%=JSPLib.cmdHash("routine,spgridoperation",request.getSession())%>';
PrepareJsCalendar(false);
this.Grid_Groups=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"progname,grpcode","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid Admin-border-grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Groups","dataobj":"dataobj_security_for_procedure_groups","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":190,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Groups","nav_bar":"true","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"true","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":675,"x":15,"y":360,"zindex":""});
this.Grid_Groups.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"center","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"image:<%=sp.getThemedImage("../images/grid/delete.png")%>","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"function:splinker_deletesecuritygroup.Link()","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"iconFont grid_icon grid_delete\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUPNAME_SECURITY"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"grpname","fg_color":"","width":"","alias":"ADMIN_GROUPNAME_SECURITY","RowSpan":0},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_ACCESS","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_INSERT"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_INSERT","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec2:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_MODIFY"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_MODIFY","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec3:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DELETE"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_DELETE","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:sec4:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY'];[2;'ADMIN_ACCESS_PWD'];[3;'ADMIN_ACCESS_OTP']]:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Grid_Groups.m_cID='<%=JSPLib.cmdHash("routine,spgridoperation",request.getSession())%>';
PrepareJsCalendar(false);
this.splinker_selectuser=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_selectuser","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_selectuser","offline":false,"page":1,"parms":"progname,backto","popup":"false","popup_height":"370","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspselectsecurityuser_portlet.jsp","target":"","type":"SPLinker","w":254,"x":916,"y":120});
this.splinker_selectuser.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spselectsecurityuser_portlet.jsp",request.getSession())%>';
this.splinker_selectgroup=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_selectgroup","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_selectgroup","offline":false,"page":1,"parms":"progname,filter_roles,backto","popup":"false","popup_height":"320","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspselectsecuritygroup_portlet.jsp","target":"","type":"SPLinker","w":254,"x":916,"y":143});
this.splinker_selectgroup.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spselectsecuritygroup_portlet.jsp",request.getSession())%>';
this.c_grpcode=new ZtVWeb._VC(this,'c_grpcode',null,'character','<%=JSPLib.ToJSValue(c_grpcode,false,true)%>',false,false);
this.btn_adduser=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button cursor btn_adduser_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn_adduser","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn_adduser","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ADD_USER"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":150,"x":540,"y":294,"zindex":"1"});
this.btn_addgroup=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button cursor btn_addgroup_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn_addgroup","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn_addgroup","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ADD_GROUP"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":148,"x":540,"y":564,"zindex":"1"});
this.btn_apply=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button cursor btn_apply_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn_apply","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn_apply","page":1,"spuid":"","tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CLOSE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":148,"x":385,"y":564,"zindex":"1"});
this.Event_addQuery=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_addQuery","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"Event_addQuery","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":254,"x":916,"y":235});
this.c_usrcode=new ZtVWeb._VC(this,'c_usrcode',null,'character','<%=JSPLib.ToJSValue(c_usrcode,false,true)%>',false,false);
this.Lbl_Users=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Lbl_Users","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Lbl_Users","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(Lbl_Users),false,true)%>","type":"Label","w":674,"x":15,"y":60,"zindex":"1"});
this.Lbl_Groups=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Lbl_Groups","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Lbl_Groups","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(Lbl_Groups),false,true)%>","type":"Label","w":674,"x":15,"y":331,"zindex":"1"});
this.dataobj_security_for_procedure_users=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"spquery_security_for_procedure_users","cmdHash":"<%=JSPLib.cmdHash("spquery_security_for_procedure_users",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_security_for_procedure_users","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_security_for_procedure_users","nrows":"5","page":1,"parms":"progname","parms_source":"","type":"SQLDataobj","w":254,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":916,"y":281});
this.dataobj_security_for_procedure_groups=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"spquery_security_for_procedure_groups","cmdHash":"<%=JSPLib.cmdHash("spquery_security_for_procedure_groups",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_security_for_procedure_groups","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_security_for_procedure_groups","nrows":"5","page":1,"parms":"progname,filter_roles","parms_source":"","type":"SQLDataobj","w":254,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":916,"y":258});
this.hasStates=new ZtVWeb._VC(this,'hasStates',null,'logic',<%=hasStates%>,false,false);
this.splinker_deletesecurityuser=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_deletesecurityuser","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_deletesecurityuser","offline":false,"page":1,"parms":"progname,usrcode=c_usrcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":254,"x":916,"y":212});
this.splinker_deletesecurityuser.m_cID='<%=JSPLib.cmdHash("routine,spremovesecurityrow",request.getSession())%>';
this.splinker_deletesecuritygroup=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_deletesecuritygroup","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_deletesecuritygroup","offline":false,"page":1,"parms":"progname,grpcode=c_grpcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":254,"x":916,"y":189});
this.splinker_deletesecuritygroup.m_cID='<%=JSPLib.cmdHash("routine,spremovesecurityrow",request.getSession())%>';
this.roles_for_entity=new ZtVWeb._VC(this,'roles_for_entity',null,'character','<%=JSPLib.ToJSValue(roles_for_entity,false,true)%>',false,false);
this.progname=new ZtVWeb._VC(this,'progname',null,'character','<%=JSPLib.ToJSValue(progname,false,true)%>',false,false);
this.label_roles=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_roles","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_roles","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_roles),false,true)%>","type":"Label","w":674,"x":15,"y":35,"zindex":"1"});
this.splinker_getEntityRoles=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_getEntityRoles","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_getEntityRoles","offline":false,"page":1,"parms":"progname","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spgetentityroles","target":"","type":"SPLinker","w":254,"x":916,"y":166});
this.splinker_getEntityRoles.m_cID='<%=JSPLib.cmdHash("routine,spgetentityroles",request.getSession())%>';
this.backto=new ZtVWeb._VC(this,'backto',null,'character','<%=JSPLib.ToJSValue(backto,false,true)%>',false,false);
this.filter_roles=new ZtVWeb._VC(this,'filter_roles',null,'character','<%=JSPLib.ToJSValue(filter_roles,false,true)%>',false,false);
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
<%request.setAttribute("spproceduresecurity_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spproceduresecurity_Static=function(){
if(typeof this_Calculate !='undefined')this.this_Calculate=this_Calculate;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btn_addgroup_Click !='undefined')this.btn_addgroup_Click=btn_addgroup_Click;
if(typeof btn_adduser_Click !='undefined')this.btn_adduser_Click=btn_adduser_Click;
if(typeof splinker_deletesecurityuser_Result !='undefined')this.splinker_deletesecurityuser_Result=splinker_deletesecurityuser_Result;
if(typeof splinker_deletesecuritygroup_Result !='undefined')this.splinker_deletesecuritygroup_Result=splinker_deletesecuritygroup_Result;
if(typeof splinker_changesecurityaccess_user_Result !='undefined')this.splinker_changesecurityaccess_user_Result=splinker_changesecurityaccess_user_Result;
if(typeof splinker_changesecurityaccess_group_Result !='undefined')this.splinker_changesecurityaccess_group_Result=splinker_changesecurityaccess_group_Result;
if(typeof btn_apply_Click !='undefined')this.btn_apply_Click=btn_apply_Click;
if(typeof splinker_getEntityRoles_Result !='undefined')this.splinker_getEntityRoles_Result=splinker_getEntityRoles_Result;
if(typeof getDeleteImg !='undefined')this.getDeleteImg=getDeleteImg;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('../jsp-system/spadministration_pg_procedure_security.jsp',this.backto);
this.dataobj_security_for_procedure_users.addRowConsumer(this.Grid_Users);
this.dataobj_security_for_procedure_groups.addRowConsumer(this.Grid_Groups);
this.dataobj_security_for_procedure_groups.addDataConsumer(this.c_grpcode,<%=JSPLib.ToJSValue("grpcode",true)%>);
this.dataobj_security_for_procedure_users.addDataConsumer(this.c_usrcode,<%=JSPLib.ToJSValue("usrcode",true)%>);
function this_Calculate(){
  
}
FormatMsg('ADMIN_SECURITY_ALLOW');
FormatMsg('ADMIN_SECURITY_DENY');
FormatMsg('ADMIN_SECURITY_NO_VALUE');
FormatMsg('ADMIN_ACCESS_PWD');
FormatMsg('ADMIN_ACCESS_OTP');
var cSkin='<%=sp.getSkin()%>'
m_cProgName='spproceduresecurity'
function this_Loaded(){
  this.label_title.Value("<b>"+FormatMsg('ADMIN_ENTITY_NAME')+": </b>"+this.progname.Value());
  this.splinker_getEntityRoles.Link();
  var customToolbar=this.getTitlePortlet();
  customToolbar.AddButton(SPTheme.controlPanelHelp || '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
                          'javascript:Help()','','<%=sp.translate("ADMIN_HELP")%>','<%=sp.translate("ADMIN_HELP")%>');
  customToolbar.SetTitle('<%=sp.translate("ADMIN_MANAGE_SECURITY")%>');
  var added = customToolbar.AddButton(SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
                                      'javascript:'+this.formid+'.btn_apply_Click();','','<%=sp.translate("MSG_BACK")%>','<%=sp.translate("ADMIN_BACK_TO_CP")%>');
  if(added) {
    // se l'aggiunta del bottone alla Custom Toolbar avviene con successo nascondo il tasto "manuale"
    this.btn_apply.Hide();
  }
  customToolbar.RearrangeAll();
  this.Grid_Users.SetOrderBy('usrname','asc');
  this.dataobj_security_for_procedure_users.Query();
  this.Grid_Groups.SetOrderBy('grpname','asc');
  this.dataobj_security_for_procedure_groups.Query();
}
function btn_addgroup_Click(){
	this.splinker_selectgroup.Link();
}
function btn_adduser_Click(){
  this.splinker_selectuser.Link();
}
function splinker_deletesecurityuser_Result(result){
	this.dataobj_security_for_procedure_users.Query(true);
}
function splinker_deletesecuritygroup_Result(result){
	this.dataobj_security_for_procedure_groups.Query(true);
 }
function splinker_changesecurityaccess_user_Result(result){
	this.dataobj_security_for_procedure_users.Query(true);
}
function splinker_changesecurityaccess_group_Result(result){
	this.dataobj_security_for_procedure_groups.Query(true);
}
function btn_apply_Click(){
  this.Event_addQuery.Emit();
	WindowClose();
}
function splinker_getEntityRoles_Result(result){
	if(!Empty(LRTrim(result))){
  	this.label_roles.Value("<b>"+FormatMsg('ADMIN_ROLES')+": </b>"+result);
  	this.filter_roles.Value("'"+Strtran(result, ", ", "','")+"'");
    //alert(this.filter_roles.Value());
  } else {
  	this.label_roles.Value("<b>"+FormatMsg('ADMIN_ROLES')+": </b>"+FormatMsg('ADMIN_NO_ROLES'));
  	this.filter_roles.Value("");
  }
}
function getDeleteImg(){  
	var img=SPTheme.grid_img_action_delete||ZtVWeb.SPWebRootURL+"/visualweb/images/grid_delete.png";
  return "<img src='"+img+"' border='0' />"
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spproceduresecurity_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Event_addQuery.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','spproceduresecurity',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spproceduresecurity');
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
sp.endPage("spproceduresecurity");
}%>
<%! public String getJSPUID() { return "1152165565"; } %>