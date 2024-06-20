<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"FormatMsg('ADMIN_SECURITY_ALLOW');\nFormatMsg('ADMIN_SECURITY_DENY');\nFormatMsg('ADMIN_SECURITY_NO_VALUE');\n\nvar cSkin='\u003c%=sp.getSkin()%\u003e'\nm_cProgName='spquerysecurity'\n\nfunction this_Loaded(){\n  this.label_title.Value(\"\u003cb\u003e\"+FormatMsg('ADMIN_ENTITY_NAME')+\": \u003c\u002fb\u003e\"+this.progname.Value());\n  this.label_roles.Value(\"\u003cb\u003e\"+FormatMsg('ADMIN_ROLES')+\": \u003c\u002fb\u003e\"+FormatMsg('ADMIN_NOT_SUPPORTED'));\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AddButton('\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n                             'javascript:Help()','','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e');\n  customToolbar.SetTitle('\u003c%=sp.translate(\"ADMIN_MANAGE_SECURITY\")%\u003e');\n  customToolbar.SetTitle('\u003c%=sp.translate(\"ADMIN_MANAGE_SECURITY\")%\u003e');\n  var added = customToolbar.AddButton('\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fclose.png\",pageContext.getServletContext())%\u003e',\n                             'javascript:'+this.formid+'.btn_close_Click();','','\u003c%=sp.translate(\"ADMIN_CLOSE\")%\u003e','\u003c%=sp.translate(\"ADMIN_CLOSE\")%\u003e');\n  if(added) {\n    \u002f\u002f se l'aggiunta del bottone alla Custom Toolbar avviene con successo nascondo il tasto \"manuale\"\n    this.btn_close.Hide();\n  }\n  customToolbar.RearrangeAll();\n  this.Grid_Users.SetOrderBy('usrname','asc');\n  this.dataobj_security_for_query_users.Query()\n  this.Grid_Groups.SetOrderBy('grpname','asc');\n  this.dataobj_security_for_query_groups.Query()\n}\n\nfunction btn_adduser_Click(){\n\tthis.splinker_selectuser.Link()\n}\n\nfunction btn_addgroup_Click(){\n\tthis.splinker_selectgroup.Link()\n}\n\nfunction splinker_deletesecurityuser_Result(result){\n\tthis.dataobj_security_for_query_users.Query(true);\n}\n\nfunction splinker_deletesecuritygroup_Result(result){\n\tthis.dataobj_security_for_query_groups.Query(true);\n}\n\nfunction splinker_changesecurityaccess_user_Result(result){\n\tthis.dataobj_security_for_query_users.Query(true);\n}\n\nfunction splinker_changesecurityaccess_group_Result(result){\n\tthis.dataobj_security_for_query_groups.Query(true);\n}\n\nfunction btn_close_Click(){\n  this.Event_addQuery.Emit();\n  WindowClose();\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"\",\"size\":\"\",\"weight\":\"\",\"align\":\"center\",\"code\":\"\"},\"hover\":{},\":before\":{\"display\":\"inline-block\",\"content\":\"\",\"size\":\"20px\",\"weight\":\"normal\",\"font_color\":\"rgba(0, 0, 0, 0.93)\",\"code\":\"font-family: icons8_win10;\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon\",\"id\":\"form\",\"code\":\".grid_icon {\\n  text-align: center;\\n}\\n\\n.grid_icon::before {\\n  display: inline-block;\\n  font-family: icons8_win10;\\n  color: rgba(0, 0, 0, 0.93);\\n  font-weight: normal;\\n  font-size: 20px;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{\"content\":\"\\\\f041\",\"code\":\"\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon.grid_delete\",\"id\":\"form\",\"code\":\".grid_icon.grid_delete::before {\\n  content: '\\\\f041';\\n}\\n\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{\"content\":\"\\\\f0ba\",\"code\":\"\"},\":after\":{}},\"current_state\":\":before\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_icon\",\"selector\":\".grid_icon.grid_edit\",\"id\":\"form\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"610","hsl":"","htmlcode":"{{ label_title }}\n{{ dataobj_security_for_query_users }}\n{{ dataobj_security_for_query_groups }}\n{{ Grid_Users }}\n{{ Grid_Groups }}\n{{ splinker_selectuser }}\n{{ splinker_selectgroup }}\n{{ c_grpcode }}\n{{ btn_adduser }}\n{{ btn_addgroup }}\n{{ btn_close }}\n{{ Event_addQuery }}\n{{ c_usrcode }}\n{{ Lbl_Users }}\n{{ Lbl_Groups }}\n{{ splinker_deletesecurityuser }}\n{{ splinker_deletesecuritygroup }}\n{{ progname }}\n{{ label_roles }}\n{{ backto }}\n{{ filter_roles }}\n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"administrator","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label_title","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MANAGE SECURITY","w":"374","wireframe_props":"align,value,n_col","x":"18","y":"12","zindex":"2"},{"appendingData":"false","auto_exec":"false","count":"false","h":"20","localDBName":"","n_records":"5","name":"dataobj_security_for_query_users","offline":"false","page":"1","parms":"progname=progname","parms_source":"","query":"spquery_security_for_query_users","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"230","x":"428","y":"141"},{"appendingData":"false","auto_exec":"false","count":"false","h":"20","localDBName":"","n_records":"5","name":"dataobj_security_for_query_groups","offline":"false","page":"1","parms":"progname=progname","parms_source":"","query":"spquery_security_for_query_groups","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"230","x":"428","y":"119"},{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"progname,usrcode","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fimages\u002fgrid\u002fdelete.png\\\")%\u003e\",\"align\":\"center\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"iconFont grid_icon grid_delete\\\"\u003e\u003c\u002fspan\u003e\",\"maxwidth\":\"\",\"title\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:splinker_deletesecurityuser.Link()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_USERNAME_SECURITY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"usrname\",\"maxwidth\":\"\",\"title\":\"ADMIN_USERNAME_SECURITY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_ACCESS\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_ACCESS\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_INSERT\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec2\",\"maxwidth\":\"\",\"title\":\"ADMIN_INSERT\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":false},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_MODIFY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec3\",\"maxwidth\":\"\",\"title\":\"ADMIN_MODIFY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":false},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_DELETE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec4\",\"maxwidth\":\"\",\"title\":\"ADMIN_DELETE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataobj_security_for_query_users","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":",C,,C,C,C","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"190","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Users","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"5","scroll_bars":"false","sequence":"4","server_side":"false","show_btn_delete":"","show_btn_update":"true","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"388","wireframe_props":"colProperties,checkbox,rows","x":"6","y":"106","zindex":""},{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"progname,grpcode","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fimages\u002fgrid\u002fdelete.png\\\")%\u003e\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"iconFont grid_icon grid_delete\\\"\u003e\u003c\u002fspan\u003e\",\"maxwidth\":\"\",\"title\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:splinker_deletesecuritygroup.Link()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_GROUPNAME_SECURITY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"grpname\",\"maxwidth\":\"\",\"title\":\"ADMIN_GROUPNAME_SECURITY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_ACCESS\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_ACCESS\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_INSERT\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec2\",\"maxwidth\":\"\",\"title\":\"ADMIN_INSERT\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_MODIFY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec3\",\"maxwidth\":\"\",\"title\":\"ADMIN_MODIFY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_DELETE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec4\",\"maxwidth\":\"\",\"title\":\"ADMIN_DELETE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataobj_security_for_query_groups","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":",C,,C,C,C","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"190","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Groups","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"5","scroll_bars":"false","sequence":"5","server_side":"false","show_btn_delete":"","show_btn_update":"true","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"388","wireframe_props":"colProperties,checkbox,rows","x":"6","y":"376","zindex":""},{"async":"false","entity_type":"","h":"20","m_cAction":"","name":"splinker_selectuser","offline":"false","page":"1","parms":"progname,backto","popup":"false","popup_height":"370","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":"","refresh":"","sequence":"6","servlet":"..\u002fjsp-system\u002fspselectsecurityuser_portlet.jsp","target":"","type":"SPLinker","w":"230","x":"428","y":"75"},{"async":"false","entity_type":"","h":"20","m_cAction":"","name":"splinker_selectgroup","offline":"false","page":"1","parms":"progname,filter_roles,backto","popup":"false","popup_height":"320","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":"","refresh":"","sequence":"7","servlet":"..\u002fjsp-system\u002fspselectsecuritygroup_portlet.jsp","target":"","type":"SPLinker","w":"230","x":"428","y":"53"},{"calculate":"","dataobj":"dataobj_security_for_query_groups","field":"grpcode","h":"20","init":"","init_par":"","name":"c_grpcode","page":"1","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"230","x":"428","y":"207"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btn_adduser","page":"1","sequence":"9","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_ADD_USER","w":"148","wireframe_props":"value","x":"10","y":"305","zindex":"1"},{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btn_addgroup","page":"1","sequence":"10","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_ADD_GROUP","w":"148","wireframe_props":"value","x":"10","y":"575","zindex":"1"},{"anchor":"bottom-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btn_close","page":"1","sequence":"11","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_CLOSE","w":"148","wireframe_props":"value","x":"242","y":"575","zindex":"1"},{"broadcast":"all","eventsNames":"","eventsObjs":"","h":"20","name":"Event_addQuery","page":"1","parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","sequence":"12","type":"EventEmitter","w":"230","x":"428","y":"185"},{"calculate":"","dataobj":"dataobj_security_for_query_users","field":"usrcode","h":"20","init":"","init_par":"","name":"c_usrcode","page":"1","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"230","x":"428","y":"163"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Lbl_Users","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"CP_USERS","w":"374","wireframe_props":"align,value,n_col","x":"18","y":"82","zindex":"1"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Lbl_Groups","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"15","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"CP_GROUPS","w":"374","wireframe_props":"align,value,n_col","x":"16","y":"352","zindex":"1"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","name":"splinker_deletesecurityuser","offline":"false","page":"1","parms":"progname,usrcode=c_usrcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":"230","x":"428","y":"31"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","name":"splinker_deletesecuritygroup","offline":"false","page":"1","parms":"progname,grpcode=c_grpcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":"230","x":"428","y":"97"},{"calculate":"","dataobj":"","field":"","h":"20","init":"false","init_par":"request","name":"progname","page":"1","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"230","x":"428","y":"229"},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Arial","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label_roles","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"19","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Role","w":"374","wireframe_props":"align,value,n_col","x":"18","y":"47","zindex":"1"},{"calculate":"'..\u002fjsp-system\u002fspadministration_pg_query_security.jsp'","dataobj":"","field":"","h":"20","init":"true","init_par":"","name":"backto","page":"1","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"230","x":"428","y":"273"},{"calculate":"\"\"","dataobj":"","field":"","h":"20","init":"true","init_par":"","name":"filter_roles","page":"1","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"230","x":"428","y":"251"}]%>
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
.spquerysecurity_container .grid_icon{  text-align: center;
}
.spquerysecurity_container .grid_icon::before{
  display: inline-block;
  font-family: icons8_win10;
  color: rgba(0, 0, 0, 0.93);
  font-weight: normal;
  font-size: 20px;
}
.spquerysecurity_container .grid_icon.grid_delete::before{
  content: '\f041';
}
.spquerysecurity_container .grid_icon.grid_edit::before{
  content: '\f0ba';
}
.spquerysecurity_container {
}
.spquerysecurity_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:610px;
  background-color:transparent;
}
.spquerysecurity_portlet[Data-page="1"]{
  height:610px;
  width:100%;
}
.spquerysecurity_portlet > .label_title_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:12px;
  left:18px;
  width:374px;
  height:auto;
  min-height:20px;
}
.spquerysecurity_portlet > .label_title_ctrl {
  height:auto;
  min-height:20px;
}
.spquerysecurity_portlet > .label_title_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:left;
}
.spquerysecurity_portlet > .Grid_Users_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:106px;
  left:6px;
  right:6px;
  width:auto;
  height:auto;
  min-height:190px;
}
.spquerysecurity_portlet > .Grid_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:376px;
  left:6px;
  right:6px;
  width:auto;
  height:auto;
  min-height:190px;
}
.spquerysecurity_portlet > .btn_adduser_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:305px;
  left:10px;
  width:148px;
  height:28px;
}
.spquerysecurity_portlet > .btn_adduser_ctrl {
}
.spquerysecurity_portlet > .btn_addgroup_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:575px;
  left:10px;
  width:148px;
  height:28px;
}
.spquerysecurity_portlet > .btn_addgroup_ctrl {
}
.spquerysecurity_portlet > .btn_close_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  right:10px;
  bottom:7px;
  width:148px;
  height:28px;
}
.spquerysecurity_portlet > .btn_close_ctrl {
}
.spquerysecurity_portlet > .Lbl_Users_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:82px;
  left:18px;
  width:374px;
  height:auto;
  min-height:19px;
}
.spquerysecurity_portlet > .Lbl_Users_ctrl {
  height:auto;
  min-height:19px;
}
.spquerysecurity_portlet > .Lbl_Users_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:left;
  background-color:transparent;
}
.spquerysecurity_portlet > .Lbl_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:352px;
  left:16px;
  width:374px;
  height:auto;
  min-height:19px;
}
.spquerysecurity_portlet > .Lbl_Groups_ctrl {
  height:auto;
  min-height:19px;
}
.spquerysecurity_portlet > .Lbl_Groups_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:left;
  background-color:transparent;
}
.spquerysecurity_portlet > .label_roles_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  left:18px;
  right:8px;
  width:auto;
  height:auto;
  min-height:19px;
}
.spquerysecurity_portlet > .label_roles_ctrl {
  height:auto;
  min-height:19px;
}
.spquerysecurity_portlet > .label_roles_ctrl {
  overflow:hidden;
  font-family:Arial;
  font-weight:bold;
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
 String def="[{\"h\":\"610\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MANAGE SECURITY\",\"w\":\"374\",\"x\":\"18\",\"y\":\"12\",\"zindex\":\"2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"230\",\"x\":\"428\",\"y\":\"141\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"230\",\"x\":\"428\",\"y\":\"119\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"ADMIN_USERNAME_SECURITY\"},{\"isEditable\":true,\"title\":\"ADMIN_ACCESS\"},{\"isEditable\":false,\"title\":\"ADMIN_INSERT\"},{\"isEditable\":false,\"title\":\"ADMIN_MODIFY\"},{\"isEditable\":false,\"title\":\"ADMIN_DELETE\"}],\"h\":\"190\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"5\",\"type\":\"Grid\",\"w\":\"388\",\"x\":\"6\",\"y\":\"106\",\"zindex\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"ADMIN_GROUPNAME_SECURITY\"},{\"isEditable\":true,\"title\":\"ADMIN_ACCESS\"},{\"title\":\"ADMIN_INSERT\"},{\"title\":\"ADMIN_MODIFY\"},{\"title\":\"ADMIN_DELETE\"}],\"h\":\"190\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"5\",\"type\":\"Grid\",\"w\":\"388\",\"x\":\"6\",\"y\":\"376\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"230\",\"x\":\"428\",\"y\":\"75\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"230\",\"x\":\"428\",\"y\":\"53\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"230\",\"x\":\"428\",\"y\":\"207\"},{\"anchor\":\"top-left\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_ADD_USER\",\"w\":\"148\",\"x\":\"10\",\"y\":\"305\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_ADD_GROUP\",\"w\":\"148\",\"x\":\"10\",\"y\":\"575\",\"zindex\":\"1\"},{\"anchor\":\"bottom-right\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_CLOSE\",\"w\":\"148\",\"x\":\"242\",\"y\":\"575\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"230\",\"x\":\"428\",\"y\":\"185\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"230\",\"x\":\"428\",\"y\":\"163\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CP_USERS\",\"w\":\"374\",\"x\":\"18\",\"y\":\"82\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CP_GROUPS\",\"w\":\"374\",\"x\":\"16\",\"y\":\"352\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"230\",\"x\":\"428\",\"y\":\"31\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"230\",\"x\":\"428\",\"y\":\"97\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"230\",\"x\":\"428\",\"y\":\"229\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Role\",\"w\":\"374\",\"x\":\"18\",\"y\":\"47\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"230\",\"x\":\"428\",\"y\":\"273\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"230\",\"x\":\"428\",\"y\":\"251\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spquerysecurity","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spquerysecurity_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spquerysecurity','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label_title= "MANAGE SECURITY";
if(request.getAttribute("spquerysecurity_firstinclusion")==null){
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
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spquerysecurity_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spquerysecurity_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spquerysecurity_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spquerysecurity','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_label_title'  formid='<%=idPortlet%>' ps-name='label_title'    class='label label_title_ctrl'><div id='<%=idPortlet%>_label_titletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MANAGE SECURITY"))%></div></span>
<div id='<%=idPortlet%>_Grid_Users' formid='<%=idPortlet%>' ps-name='Grid_Users'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<div id='<%=idPortlet%>_Grid_Groups' formid='<%=idPortlet%>' ps-name='Grid_Groups'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<input id='<%=idPortlet%>_btn_adduser' type='button' class='button btn_adduser_ctrl'/>
<input id='<%=idPortlet%>_btn_addgroup' type='button' class='button btn_addgroup_ctrl'/>
<input id='<%=idPortlet%>_btn_close' type='button' class='button btn_close_ctrl'/>
<span id='<%=idPortlet%>_Lbl_Users'  formid='<%=idPortlet%>' ps-name='Lbl_Users'    class='label Lbl_Users_ctrl'><div id='<%=idPortlet%>_Lbl_Userstbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CP_USERS"))%></div></span>
<span id='<%=idPortlet%>_Lbl_Groups'  formid='<%=idPortlet%>' ps-name='Lbl_Groups'    class='label Lbl_Groups_ctrl'><div id='<%=idPortlet%>_Lbl_Groupstbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CP_GROUPS"))%></div></span>
<span id='<%=idPortlet%>_label_roles'  formid='<%=idPortlet%>' ps-name='label_roles'    class='label label_roles_ctrl'><div id='<%=idPortlet%>_label_rolestbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Role"))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spquerysecurity');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ENTITY_NAME",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ENTITY_NAME"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_NOT_SUPPORTED",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_NOT_SUPPORTED"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spquerysecurity',["400"],["610"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"610","title":"","layer":"false","npage":"1"}]);
this.label_title=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_title","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_title","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_title),false,true)%>","type":"Label","w":374,"x":18,"y":12,"zindex":"2"});
this.dataobj_security_for_query_users=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"spquery_security_for_query_users","cmdHash":"<%=JSPLib.cmdHash("spquery_security_for_query_users",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_security_for_query_users","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_security_for_query_users","nrows":"5","page":1,"parms":"progname=progname","parms_source":"","type":"SQLDataobj","w":230,"x":428,"y":141});
this.dataobj_security_for_query_groups=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"spquery_security_for_query_groups","cmdHash":"<%=JSPLib.cmdHash("spquery_security_for_query_groups",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_security_for_query_groups","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_security_for_query_groups","nrows":"5","page":1,"parms":"progname=progname","parms_source":"","type":"SQLDataobj","w":230,"x":428,"y":119});
this.Grid_Users=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"progname,usrcode","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Users","dataobj":"dataobj_security_for_query_users","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":190,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Users","nav_bar":"always","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"true","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":388,"x":6,"y":106,"zindex":""});
this.Grid_Users.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"center","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"image:<%=sp.getThemedImage("../images/grid/delete.png")%>","extensible":false,"title_align":"","enable_HTML":false,"onclick":"function:splinker_deletesecurityuser.Link()","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"iconFont grid_icon grid_delete\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_USERNAME_SECURITY"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"usrname","fg_color":"","width":"","alias":"ADMIN_USERNAME_SECURITY","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false","isEditable":true,"fg_color":"","width":"","alias":"ADMIN_ACCESS","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_INSERT"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec2","isEditable":false,"fg_color":"","width":"","alias":"ADMIN_INSERT","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_MODIFY"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec3","isEditable":false,"fg_color":"","width":"","alias":"ADMIN_MODIFY","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DELETE"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec4","isEditable":false,"fg_color":"","width":"","alias":"ADMIN_DELETE","RowSpan":0}]});
this.Grid_Users.m_cID='<%=JSPLib.cmdHash("routine,spgridoperation",request.getSession())%>';
PrepareJsCalendar(false);
this.Grid_Groups=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"progname,grpcode","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Groups","dataobj":"dataobj_security_for_query_groups","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":190,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Groups","nav_bar":"always","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"true","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":388,"x":6,"y":376,"zindex":""});
this.Grid_Groups.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"image:<%=sp.getThemedImage("../images/grid/delete.png")%>","extensible":false,"title_align":"","enable_HTML":false,"onclick":"function:splinker_deletesecuritygroup.Link()","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"iconFont grid_icon grid_delete\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUPNAME_SECURITY"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"grpname","fg_color":"","width":"","alias":"ADMIN_GROUPNAME_SECURITY","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false","isEditable":true,"fg_color":"","width":"","alias":"ADMIN_ACCESS","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_INSERT"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec2","fg_color":"","width":"","alias":"ADMIN_INSERT","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_MODIFY"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec3","fg_color":"","width":"","alias":"ADMIN_MODIFY","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DELETE"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec4","fg_color":"","width":"","alias":"ADMIN_DELETE","RowSpan":0}]});
this.Grid_Groups.m_cID='<%=JSPLib.cmdHash("routine,spgridoperation",request.getSession())%>';
PrepareJsCalendar(false);
this.splinker_selectuser=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_selectuser","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_selectuser","offline":false,"page":1,"parms":"progname,backto","popup":"false","popup_height":"370","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspselectsecurityuser_portlet.jsp","target":"","type":"SPLinker","w":230,"x":428,"y":75});
this.splinker_selectuser.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spselectsecurityuser_portlet.jsp",request.getSession())%>';
this.splinker_selectgroup=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_selectgroup","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_selectgroup","offline":false,"page":1,"parms":"progname,filter_roles,backto","popup":"false","popup_height":"320","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspselectsecuritygroup_portlet.jsp","target":"","type":"SPLinker","w":230,"x":428,"y":53});
this.splinker_selectgroup.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spselectsecuritygroup_portlet.jsp",request.getSession())%>';
this.c_grpcode=new ZtVWeb._VC(this,'c_grpcode',null,'character','<%=JSPLib.ToJSValue(c_grpcode,false,true)%>',false,false);
this.btn_adduser=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btn_adduser_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn_adduser","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn_adduser","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ADD_USER"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":148,"x":10,"y":305,"zindex":"1"});
this.btn_addgroup=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"","class_Css":"button btn_addgroup_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn_addgroup","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn_addgroup","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ADD_GROUP"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":148,"x":10,"y":575,"zindex":"1"});
this.btn_close=new ZtVWeb._BC(this,{"anchor":"bottom-right","bg_color":"","border_color":"","border_weight":"","class_Css":"button btn_close_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn_close","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn_close","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CLOSE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":148,"x":242,"y":575,"zindex":"1"});
this.Event_addQuery=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_addQuery","eventsNames":"","eventsObjs":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"Event_addQuery","page":1,"parmsNames":"","parmsTypes":"","parmsValues":"","persistent":"true","type":"EventEmitter","w":230,"x":428,"y":185});
this.c_usrcode=new ZtVWeb._VC(this,'c_usrcode',null,'character','<%=JSPLib.ToJSValue(c_usrcode,false,true)%>',false,false);
this.Lbl_Users=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Lbl_Users","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Lbl_Users","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(Lbl_Users),false,true)%>","type":"Label","w":374,"x":18,"y":82,"zindex":"1"});
this.Lbl_Groups=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Lbl_Groups","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Lbl_Groups","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(Lbl_Groups),false,true)%>","type":"Label","w":374,"x":16,"y":352,"zindex":"1"});
this.splinker_deletesecurityuser=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_deletesecurityuser","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_deletesecurityuser","offline":false,"page":1,"parms":"progname,usrcode=c_usrcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":230,"x":428,"y":31});
this.splinker_deletesecurityuser.m_cID='<%=JSPLib.cmdHash("routine,spremovesecurityrow",request.getSession())%>';
this.splinker_deletesecuritygroup=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_deletesecuritygroup","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_deletesecuritygroup","offline":false,"page":1,"parms":"progname,grpcode=c_grpcode","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spremovesecurityrow","target":"","type":"SPLinker","w":230,"x":428,"y":97});
this.splinker_deletesecuritygroup.m_cID='<%=JSPLib.cmdHash("routine,spremovesecurityrow",request.getSession())%>';
this.progname=new ZtVWeb._VC(this,'progname',null,'character','<%=JSPLib.ToJSValue(progname,false,true)%>',false,false);
this.label_roles=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_roles","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Arial","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_roles","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_roles),false,true)%>","type":"Label","w":374,"x":18,"y":47,"zindex":"1"});
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
<%request.setAttribute("spquerysecurity_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spquerysecurity_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btn_adduser_Click !='undefined')this.btn_adduser_Click=btn_adduser_Click;
if(typeof btn_addgroup_Click !='undefined')this.btn_addgroup_Click=btn_addgroup_Click;
if(typeof splinker_deletesecurityuser_Result !='undefined')this.splinker_deletesecurityuser_Result=splinker_deletesecurityuser_Result;
if(typeof splinker_deletesecuritygroup_Result !='undefined')this.splinker_deletesecuritygroup_Result=splinker_deletesecuritygroup_Result;
if(typeof splinker_changesecurityaccess_user_Result !='undefined')this.splinker_changesecurityaccess_user_Result=splinker_changesecurityaccess_user_Result;
if(typeof splinker_changesecurityaccess_group_Result !='undefined')this.splinker_changesecurityaccess_group_Result=splinker_changesecurityaccess_group_Result;
if(typeof btn_close_Click !='undefined')this.btn_close_Click=btn_close_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('../jsp-system/spadministration_pg_query_security.jsp',this.backto);
ZtVWeb.InitCtrl("",this.filter_roles);
this.dataobj_security_for_query_users.addRowConsumer(this.Grid_Users);
this.dataobj_security_for_query_groups.addRowConsumer(this.Grid_Groups);
this.dataobj_security_for_query_groups.addDataConsumer(this.c_grpcode,<%=JSPLib.ToJSValue("grpcode",true)%>);
this.dataobj_security_for_query_users.addDataConsumer(this.c_usrcode,<%=JSPLib.ToJSValue("usrcode",true)%>);
FormatMsg('ADMIN_SECURITY_ALLOW');
FormatMsg('ADMIN_SECURITY_DENY');
FormatMsg('ADMIN_SECURITY_NO_VALUE');
var cSkin='<%=sp.getSkin()%>'
m_cProgName='spquerysecurity'
function this_Loaded(){
  this.label_title.Value("<b>"+FormatMsg('ADMIN_ENTITY_NAME')+": </b>"+this.progname.Value());
  this.label_roles.Value("<b>"+FormatMsg('ADMIN_ROLES')+": </b>"+FormatMsg('ADMIN_NOT_SUPPORTED'));
  var customToolbar=this.getTitlePortlet();
  customToolbar.AddButton('<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
                             'javascript:Help()','','<%=sp.translate("ADMIN_HELP")%>','<%=sp.translate("ADMIN_HELP")%>');
  customToolbar.SetTitle('<%=sp.translate("ADMIN_MANAGE_SECURITY")%>');
  customToolbar.SetTitle('<%=sp.translate("ADMIN_MANAGE_SECURITY")%>');
  var added = customToolbar.AddButton('<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>',
                             'javascript:'+this.formid+'.btn_close_Click();','','<%=sp.translate("ADMIN_CLOSE")%>','<%=sp.translate("ADMIN_CLOSE")%>');
  if(added) {
    // se l'aggiunta del bottone alla Custom Toolbar avviene con successo nascondo il tasto "manuale"
    this.btn_close.Hide();
  }
  customToolbar.RearrangeAll();
  this.Grid_Users.SetOrderBy('usrname','asc');
  this.dataobj_security_for_query_users.Query()
  this.Grid_Groups.SetOrderBy('grpname','asc');
  this.dataobj_security_for_query_groups.Query()
}
function btn_adduser_Click(){
	this.splinker_selectuser.Link()
}
function btn_addgroup_Click(){
	this.splinker_selectgroup.Link()
}
function splinker_deletesecurityuser_Result(result){
	this.dataobj_security_for_query_users.Query(true);
}
function splinker_deletesecuritygroup_Result(result){
	this.dataobj_security_for_query_groups.Query(true);
}
function splinker_changesecurityaccess_user_Result(result){
	this.dataobj_security_for_query_users.Query(true);
}
function splinker_changesecurityaccess_group_Result(result){
	this.dataobj_security_for_query_groups.Query(true);
}
function btn_close_Click(){
  this.Event_addQuery.Emit();
  WindowClose();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spquerysecurity_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Event_addQuery.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','spquerysecurity',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spquerysecurity');
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
sp.endPage("spquerysecurity");
}%>
<%! public String getJSPUID() { return "433499256"; } %>