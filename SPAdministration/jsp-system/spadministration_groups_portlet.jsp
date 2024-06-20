<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nm_cProgName=\"spadministration_groups_list\";\nthis.usercode.Value(\u003c%=sp.getUserCode()%\u003e);\n\nfunction GetNodeIcon(group_type){\n  if(group_type=='R')\n    return '..\u002fimages\u002fspadministration_role.gif';\n  else if(group_type=='D')\n    return '..\u002fimages\u002fspadministration_descriptive.gif';\n  else if(group_type=='O')\n    return '..\u002fimages\u002fspadministration_organizational.gif';\n  else if(group_type=='S')\n    return '..\u002fimages\u002fspadministration_sharing.gif';\n  else\n    return '..\u002fimages\u002fspadministration_group.gif';\n}\n\nfunction newFolder(){\n  var node=this.StdTreeView_Groups.getCurrentNode();\n  node.refreshNode();\n  node.selectNode();\n}\n\nfunction deleteFolder(){\n  var _this=this;\n  WindowConfirm('Are you sure to delete this folder?', function(res){\n    if(res){\n      var father=_this.StdTreeView_Groups.getCurrentNode().nodeFather;\n      if(typeof(father)=='object'){\n        _this.splinker_group_delete.Link();\n        father.refreshNode();\n        father.selectNode();\n      }\n    }\n  });\n}\n\nfunction refreshusers(){\n  var node=this.StdTreeView_Groups.getCurrentNode();\n  node.refreshNode();\n  node.selectNode();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @lbl_groups }}{{ @image_back }}{{ @image_help }}{{ @user_list }}{{ @folder_delete }}{{ @folder_new }}{{ @folder_edit }}{{ @StdTreeView_Groups }}{{ @lbl_users }}{{ @security_list }}{{ @lbl_security }}\u003c\u002fbody\u003e","grapesCss":"","h":"300","hsl":"","htmlcode":"{{ @lbl_groups }} \n{{ usercode }}\n{{ selected_group }}\n{{ dataobj_groups }}\n{{ splinker_group_delete }}\n{{ splinker_group_new }}\n{{ dataobj_users_of_group }}\n{{ splinker_group_edit }}\n{{ manage_users }}\n{{ manage_users_new }}\n{{ SPManageGroups_savedEntity }}\n{{ SPManageUsers_savedEntity }}\n{{ idfolder }}\n{{ lbl_groups }}\n{{ image_back }}\n{{ image_help }}\n{{ user_list }}\n{{ folder_delete }}\n{{ folder_new }}\n{{ folder_edit }}\n{{ StdTreeView_Groups }}\n{{ lbl_users }}\n{{ security_list }}\n{{ lbl_security }}\n{{ dataobj_security_of_group }}\n{{ @image_back }} \n{{ @image_help }} \n{{ @user_list }} \n{{ @folder_delete }} \n{{ @folder_new }} \n{{ @folder_edit }} \n{{ @StdTreeView_Groups }} \n{{ @lbl_users }} \n{{ @security_list }} \n{{ @lbl_security }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"300\",\"w\":\"750\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"750","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"usercode","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"numeric","w":"100","x":"539","y":"-52"},{"calculate":"","ctrlOfVariant":"","dataobj":"StdTreeView_Groups","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"code","h":"22","init":"","init_par":"","name":"selected_group","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"numeric","w":"100","x":"435","y":"-52"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"10000","name":"dataobj_groups","offline":"false","page":"1","parms":"code","parms_source":"StdTreeView_Groups","query":"spquery_groupstree","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"316","y":"-49"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"function","name":"splinker_group_delete","offline":"false","page":"1","parms":"idfolder","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"3","servlet":"spadministration_deletegroup","target":"","type":"SPLinker","w":"30","x":"131","y":"-49"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"new","name":"splinker_group_new","offline":"false","page":"1","parms":"idfolder","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"4","servlet":"SPManageGroups","target":"","type":"SPLinker","w":"30","x":"98","y":"-49"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"15","name":"dataobj_users_of_group","offline":"false","page":"1","parms":"groupcode=code","parms_source":"StdTreeView_Groups","query":"spquery_users_of_group","query_async":"false","return_fields_type":"true","sequence":"5","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"352","y":"-49"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"edit","name":"splinker_group_edit","offline":"false","page":"1","parms":"code=idfolder","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"6","servlet":"SPManageGroups","target":"","type":"SPLinker","w":"30","x":"64","y":"-49"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"manage_users","offline":"false","page":"1","parms":"code","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"7","servlet":"SPManageUsers","target":"","type":"SPLinker","w":"30","x":"189","y":"-49"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"new","name":"manage_users_new","offline":"false","page":"1","parms":"selected_group","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"8","servlet":"SPManageUsers","target":"","type":"SPLinker","w":"30","x":"221","y":"-49"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPManageGroups_savedEntity","objsValues":"this.newFolder()","page":"1","parmsNames":"","sequence":"9","type":"EventReceiver","w":"22","x":"4","y":"-46"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPManageUsers_savedEntity","objsValues":"this.refreshusers()","page":"1","parmsNames":"","sequence":"10","type":"EventReceiver","w":"22","x":"32","y":"-46"},{"calculate":"","ctrlOfVariant":"","dataobj":"StdTreeView_Groups","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"code","h":"22","init":"","init_par":"","name":"idfolder","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"numeric","w":"100","x":"539","y":"-29"},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"11pt","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl_groups","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CP_GROUPS","w":"175","wireframe_props":"align,value,n_col","x":"12","y":"6","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"16","help_tips":"ADMIN_BACK_TO_CP","hide":"false","hide_undercond":"","href":"..\u002fservlet\u002fSPControlPanel","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image_back","page":"1","path_type":"false","rapp":"","sequence":"13","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_back.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"706","y":"8","zindex":"1","zone":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"16","help_tips":"ADMIN_HELP","hide":"false","hide_undercond":"","href":"javascript:Help()","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"image_help","page":"1","path_type":"false","rapp":"","sequence":"14","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_help.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"726","y":"8","zindex":"1","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"0","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_CODE\",\"align\":\"\",\"link\":\"\",\"width\":\"50\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"code\",\"maxwidth\":\"\",\"title\":\"ADMIN_CODE\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_NAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"name\",\"maxwidth\":\"\",\"title\":\"ADMIN_NAME\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_FULLNAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"fullname\",\"maxwidth\":\"\",\"title\":\"ADMIN_FULLNAME\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataobj_users_of_group","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"","fields_type":"","filters":"true-by-example","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"112","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"user_list","nav_bar":"true","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"15","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"manage_users,manage_users_new","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"522","wireframe_props":"colProperties,checkbox,rows","x":"221","y":"30","zindex":"","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"16","help_tips":"ADMIN_GROUP_DELETE","hide":"false","hide_undercond":"","href":"function:deleteFolder()","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"folder_delete","page":"1","path_type":"","rapp":"","sequence":"16","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_delete.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"54","y":"38","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"16","help_tips":"ADMIN_GROUP_NEW","hide":"false","hide_undercond":"","href":"SPLink:splinker_group_new","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"folder_new","page":"1","path_type":"","rapp":"","sequence":"17","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_add.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"10","y":"38","zindex":"1","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"16","help_tips":"ADMIN_GROUP_EDIT","hide":"false","hide_undercond":"","href":"SPLink:splinker_group_edit","img_type":"default","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"folder_edit","page":"1","path_type":"","rapp":"","sequence":"18","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_edit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"16","wireframe_props":"","x":"32","y":"38","zindex":"1","zone":""},{"anchor":"","css":"","css_class":"","ctrlOfVariant":"","dataobj":"dataobj_groups","droppable":"false","droppable_name":"","enable_html":"false","field_ChildCount":"childnum","field_NodeDescr":"name","field_NodeID":"code","field_picture":"","fixed":"","font":"","font_color":"","font_size":"","frame":"","h":"232","hidden_fields":"","hide":"false","layer":"false","layout_steps_values":"{}","name":"StdTreeView_Groups","node_link":"","page":"1","rapp":"","root_label":"CP_GROUPS","root_link":"","root_node_value":"","scroll_bars":"false","sequence":"19","set_icons":"function:GetNodeIcon(\"%grptype%\")","spuid":"","type":"StdTreeView","w":"203","wireframe_props":"","x":"9","y":"58","zindex":"","zone":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"11pt","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl_users","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CP_USERS","w":"175","wireframe_props":"align,value,n_col","x":"221","y":"6","zindex":"1","zone":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"0","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Entity name\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"progname\",\"maxwidth\":\"\",\"title\":\"Entity name\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_ACCESS\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec1\",\"maxwidth\":\"\",\"title\":\"ADMIN_ACCESS\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_INSERT\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec2\",\"maxwidth\":\"\",\"title\":\"ADMIN_INSERT\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_MODIFY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec3\",\"maxwidth\":\"\",\"title\":\"ADMIN_MODIFY\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_DELETE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"sec4\",\"maxwidth\":\"\",\"title\":\"ADMIN_DELETE\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataobj_security_of_group","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"","fields_type":"","filters":"true-by-example","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"112","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"security_list","nav_bar":"true","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"21","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"522","wireframe_props":"colProperties,checkbox,rows","x":"221","y":"179","zindex":"","zone":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"11pt","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lbl_security","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"CP_SECURITY","w":"175","wireframe_props":"align,value,n_col","x":"221","y":"155","zindex":"1","zone":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"15","name":"dataobj_security_of_group","offline":"false","page":"1","parms":"groupcode=code","parms_source":"StdTreeView_Groups","query":"spquery_security_of_group","query_async":"false","return_fields_type":"true","sequence":"23","type":"SQLDataobj","w":"120","waiting_mgs":"","x":"391","y":"-49"}]%>
<%/*Description:*/%>
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
.spadministration_groups_container {
}
.spadministration_groups_title_container {
  margin: auto;
}
.spadministration_groups_portlet{
  position:relative;
  margin: auto;
  width:750px;
  min-width:750px;
  height:300px;
  background-color:transparent;
}
.spadministration_groups_portlet[Data-page="1"]{
  height:300px;
  width:750px;
}
.spadministration_groups_portlet > .lbl_groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:12px;
  width:175px;
  height:auto;
  min-height:20px;
}
.spadministration_groups_portlet > .lbl_groups_ctrl {
  height:auto;
  min-height:20px;
}
.spadministration_groups_portlet > .lbl_groups_ctrl {
  overflow:hidden;
  font-size:11pt;
  text-align:left;
}
.spadministration_groups_portlet > .image_back_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:28px;
  width:16px;
  height:16px;
}
.spadministration_groups_portlet > .image_back_ctrl {
}
.spadministration_groups_portlet > .image_back_ctrl > a, .spadministration_groups_portlet > .image_back_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_groups_portlet > .image_back_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:16px;
}
.spadministration_groups_portlet > .image_help_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:8px;
  width:16px;
  height:16px;
}
.spadministration_groups_portlet > .image_help_ctrl {
}
.spadministration_groups_portlet > .image_help_ctrl > a, .spadministration_groups_portlet > .image_help_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_groups_portlet > .image_help_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:16px;
}
.spadministration_groups_portlet > .user_list_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:30px;
  left:221px;
  width:522px;
  height:auto;
  min-height:112px;
}
.spadministration_groups_portlet > .folder_delete_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:54px;
  width:16px;
  height:16px;
}
.spadministration_groups_portlet > .folder_delete_ctrl {
}
.spadministration_groups_portlet > .folder_delete_ctrl > a, .spadministration_groups_portlet > .folder_delete_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_groups_portlet > .folder_delete_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:16px;
}
.spadministration_groups_portlet > .folder_new_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:10px;
  width:16px;
  height:16px;
}
.spadministration_groups_portlet > .folder_new_ctrl {
}
.spadministration_groups_portlet > .folder_new_ctrl > a, .spadministration_groups_portlet > .folder_new_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_groups_portlet > .folder_new_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:16px;
}
.spadministration_groups_portlet > .folder_edit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:32px;
  width:16px;
  height:16px;
}
.spadministration_groups_portlet > .folder_edit_ctrl {
}
.spadministration_groups_portlet > .folder_edit_ctrl > a, .spadministration_groups_portlet > .folder_edit_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_groups_portlet > .folder_edit_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:16px;
}
.spadministration_groups_portlet > .StdTreeView_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:58px;
  left:9px;
  width:203px;
  height:232px;
}
.spadministration_groups_portlet > .lbl_users_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:221px;
  width:175px;
  height:auto;
  min-height:20px;
}
.spadministration_groups_portlet > .lbl_users_ctrl {
  height:auto;
  min-height:20px;
}
.spadministration_groups_portlet > .lbl_users_ctrl {
  overflow:hidden;
  font-size:11pt;
  text-align:left;
}
.spadministration_groups_portlet > .security_list_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:179px;
  left:221px;
  width:522px;
  height:auto;
  min-height:112px;
}
.spadministration_groups_portlet > .lbl_security_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:155px;
  left:221px;
  width:175px;
  height:auto;
  min-height:20px;
}
.spadministration_groups_portlet > .lbl_security_ctrl {
  height:auto;
  min-height:20px;
}
.spadministration_groups_portlet > .lbl_security_ctrl {
  overflow:hidden;
  font-size:11pt;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"750\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"539\",\"y\":\"-52\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"435\",\"y\":\"-52\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"316\",\"y\":\"-49\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"131\",\"y\":\"-49\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"98\",\"y\":\"-49\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"352\",\"y\":\"-49\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"64\",\"y\":\"-49\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"189\",\"y\":\"-49\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"221\",\"y\":\"-49\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"4\",\"y\":\"-46\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"32\",\"y\":\"-46\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"539\",\"y\":\"-29\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CP_GROUPS\",\"w\":\"175\",\"x\":\"12\",\"y\":\"6\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"16\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"706\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"16\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"726\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ADMIN_CODE\"},{\"title\":\"ADMIN_NAME\"},{\"title\":\"ADMIN_FULLNAME\"}],\"h\":\"112\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"522\",\"x\":\"221\",\"y\":\"30\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"16\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"54\",\"y\":\"38\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"16\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"10\",\"y\":\"38\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"16\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"16\",\"x\":\"32\",\"y\":\"38\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"232\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"StdTreeView\",\"w\":\"203\",\"x\":\"9\",\"y\":\"58\",\"zindex\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CP_USERS\",\"w\":\"175\",\"x\":\"221\",\"y\":\"6\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Entity name\"},{\"title\":\"ADMIN_ACCESS\"},{\"title\":\"ADMIN_INSERT\"},{\"title\":\"ADMIN_MODIFY\"},{\"title\":\"ADMIN_DELETE\"}],\"h\":\"112\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"522\",\"x\":\"221\",\"y\":\"179\",\"zindex\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"CP_SECURITY\",\"w\":\"175\",\"x\":\"221\",\"y\":\"155\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"391\",\"y\":\"-49\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_groups","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_groups_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_groups','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double usercode= 0;
double selected_group= 0;
double idfolder= 0;
String lbl_groups= "CP_GROUPS";
if(request.getAttribute("spadministration_groups_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%if(request.getAttribute("spadministration_groups_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("StdTreeViewObj.js")%>'></script>
<%}
String lbl_users= "CP_USERS";
String lbl_security= "CP_SECURITY";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spadministration_groups_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_groups_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_groups','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lbl_groups'  formid='<%=idPortlet%>' ps-name='lbl_groups'    class='label lbl_groups_ctrl'><div id='<%=idPortlet%>_lbl_groupstbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CP_GROUPS"))%></div></span>
<div id='<%=idPortlet%>_image_back'><a id='<%=idPortlet%>_image_backhref' href='../servlet/SPControlPanel' target='_self'><img id='<%=idPortlet%>_image_back_img' class='image image_back_ctrl' src="../images/spadministration_back.png" border='0' ></a>
</div><div id='<%=idPortlet%>_image_help'><a id='<%=idPortlet%>_image_helphref' href='javascript:Help()' target='_self'><img id='<%=idPortlet%>_image_help_img' class='image image_help_ctrl' src="../images/spadministration_help.gif" border='0' ></a>
</div><div id='<%=idPortlet%>_user_list' formid='<%=idPortlet%>' ps-name='user_list'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_folder_delete'><a id='<%=idPortlet%>_folder_deletehref' href='function:deleteFolder()' target='_self'><img id='<%=idPortlet%>_folder_delete_img' class='image folder_delete_ctrl' src="../images/spadministration_folder_delete.gif" border='0' ></a>
</div><div id='<%=idPortlet%>_folder_new'><a id='<%=idPortlet%>_folder_newhref' href='javascript:window.<%=idPortlet%>.splinker_group_new.Link()' target='_self'><img id='<%=idPortlet%>_folder_new_img' class='image folder_new_ctrl' src="../images/spadministration_folder_add.gif" border='0' ></a>
</div><div id='<%=idPortlet%>_folder_edit'><a id='<%=idPortlet%>_folder_edithref' href='javascript:window.<%=idPortlet%>.splinker_group_edit.Link()' target='_self'><img id='<%=idPortlet%>_folder_edit_img' class='image folder_edit_ctrl' src="../images/spadministration_folder_edit.gif" border='0' ></a>
</div><div id='<%=idPortlet%>_StdTreeView_Groups' formid='<%=idPortlet%>' ps-name='StdTreeView_Groups' class='stdtreeview'></div>
<span id='<%=idPortlet%>_lbl_users'  formid='<%=idPortlet%>' ps-name='lbl_users'    class='label lbl_users_ctrl'><div id='<%=idPortlet%>_lbl_userstbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CP_USERS"))%></div></span>
<div id='<%=idPortlet%>_security_list' formid='<%=idPortlet%>' ps-name='security_list'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_lbl_security'  formid='<%=idPortlet%>' ps-name='lbl_security'    class='label lbl_security_ctrl'><div id='<%=idPortlet%>_lbl_securitytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("CP_SECURITY"))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_groups');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FIELD_UNDEFINED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FIELD_UNDEFINED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FILLING_SUBLAYER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FILLING_SUBLAYER"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_groups',["750"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"750","h":"300","title":"","layer":""}]);
this.usercode=new ZtVWeb._VC(this,'usercode',null,'numeric',<%=usercode%>,false,false);
this.selected_group=new ZtVWeb._VC(this,'selected_group',null,'numeric',<%=selected_group%>,false,false);
this.dataobj_groups=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_groupstree","cmdHash":"<%=JSPLib.cmdHash("spquery_groupstree",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_groups","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_groups","nrows":"10000","page":1,"parms":"code","parms_source":"StdTreeView_Groups","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":316,"y":-49});
this.splinker_group_delete=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_group_delete","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_group_delete","offline":false,"page":1,"parms":"idfolder","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"spadministration_deletegroup","target":"","type":"SPLinker","w":30,"x":131,"y":-49});
this.splinker_group_delete.m_cID='<%=JSPLib.cmdHash("routine,spadministration_deletegroup",request.getSession())%>';
this.splinker_group_new=new ZtVWeb.SPLinkerCtrl(this,{"action":"new","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_group_new","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_group_new","offline":false,"page":1,"parms":"idfolder","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"SPManageGroups","target":"","type":"SPLinker","w":30,"x":98,"y":-49});
this.splinker_group_new.m_cID='<%=JSPLib.cmdHash("entity,SPManageGroups",request.getSession())%>';
this.dataobj_users_of_group=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_users_of_group","cmdHash":"<%=JSPLib.cmdHash("spquery_users_of_group",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_users_of_group","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_users_of_group","nrows":"15","page":1,"parms":"groupcode=code","parms_source":"StdTreeView_Groups","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":352,"y":-49});
this.splinker_group_edit=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_group_edit","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_group_edit","offline":false,"page":1,"parms":"code=idfolder","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"SPManageGroups","target":"","type":"SPLinker","w":30,"x":64,"y":-49});
this.splinker_group_edit.m_cID='<%=JSPLib.cmdHash("entity,SPManageGroups",request.getSession())%>';
this.manage_users=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_manage_users","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"manage_users","offline":false,"page":1,"parms":"code","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"SPManageUsers","target":"","type":"SPLinker","w":30,"x":189,"y":-49});
this.manage_users.m_cID='<%=JSPLib.cmdHash("entity,SPManageUsers",request.getSession())%>';
this.manage_users_new=new ZtVWeb.SPLinkerCtrl(this,{"action":"new","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_manage_users_new","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"manage_users_new","offline":false,"page":1,"parms":"selected_group","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"SPManageUsers","target":"","type":"SPLinker","w":30,"x":221,"y":-49});
this.manage_users_new.m_cID='<%=JSPLib.cmdHash("entity,SPManageUsers",request.getSession())%>';
this.SPManageGroups_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageGroups_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageGroups_savedEntity","objsValues":"this.newFolder()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":4,"y":-46});
this.SPManageUsers_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageUsers_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageUsers_savedEntity","objsValues":"this.refreshusers()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":32,"y":-46});
this.idfolder=new ZtVWeb._VC(this,'idfolder',null,'numeric',<%=idfolder%>,false,false);
this.lbl_groups=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_groups","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"11pt","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_groups","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_groups),false,true)%>","type":"Label","w":175,"x":12,"y":6,"zindex":"1"});
this.image_back=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_back_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_back","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),false,true)%>","hide":"false","hide_undercond":"","href":"..\u002fservlet\u002fSPControlPanel","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image_back","page":1,"path_type":"false","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_back.png","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":16,"x":706,"y":8,"zindex":"1"});
this.image_help=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_help_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_help","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_HELP"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:Help()","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image_help","page":1,"path_type":"false","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_help.gif","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":16,"x":726,"y":8,"zindex":"1"});
this.user_list=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":0,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_user_list","dataobj":"dataobj_users_of_group","disabled_fld":"","empty_rows":"false","extensible":"","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":112,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"user_list","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"manage_users,manage_users_new","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":522,"x":221,"y":30,"zindex":""});
this.user_list.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CODE"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"code","fg_color":"","width":"50","alias":"ADMIN_CODE","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_NAME"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"name","fg_color":"","width":"","alias":"ADMIN_NAME","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_FULLNAME"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"fullname","fg_color":"","width":"","alias":"ADMIN_FULLNAME","RowSpan":0,"extensible":false}]});
this.folder_delete=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image folder_delete_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_folder_delete","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_DELETE"),false,true)%>","hide":"false","hide_undercond":"","href":"function:deleteFolder()","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"folder_delete","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_delete.gif","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":16,"x":54,"y":38,"zindex":"1"});
this.folder_new=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image folder_new_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_folder_new","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_NEW"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:window.<%=idPortlet%>.splinker_group_new.Link()","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"folder_new","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_add.gif","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":16,"x":10,"y":38,"zindex":"1"});
this.folder_edit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image folder_edit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_folder_edit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":16,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_EDIT"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:window.<%=idPortlet%>.splinker_group_edit.Link()","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"folder_edit","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_edit.gif","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":16,"x":32,"y":38,"zindex":"1"});
this.StdTreeView_Groups=new ZtVWeb.StdTreeViewCtrl(this,{"anchor":"top-left","class_css":"stdtreeview","ctrlid":"<%=idPortlet%>_StdTreeView_Groups","droppable":false,"droppable_name":"","enable_html":false,"font":"","font_color":"","font_size":"","h":232,"hide":"false","icon":"function:GetNodeIcon(\"%grptype%\")","layer":false,"layout_steps_values":{},"name":"StdTreeView_Groups","node_link":"","page":1,"root_label":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>","root_link":"","root_value":"","scroll_bars":"false","spuid":"","target":"","type":"StdTreeView","w":203,"x":9,"y":58,"zindex":""});
this.StdTreeView_Groups.setRowsCols({"field_ChildCount":"childnum","field_NodeID":"code","hiddenFlds":"","NodeDescr":"name","pictures":""});
this.lbl_users=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_users","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"11pt","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_users","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_users),false,true)%>","type":"Label","w":175,"x":221,"y":6,"zindex":"1"});
this.security_list=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":0,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_security_list","dataobj":"dataobj_security_of_group","disabled_fld":"","empty_rows":"false","extensible":"","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":112,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"security_list","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":522,"x":221,"y":179,"zindex":""});
this.security_list.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Entity name"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"progname","fg_color":"","width":"","alias":"Entity name","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec1","fg_color":"","width":"","alias":"ADMIN_ACCESS","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_INSERT"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec2","fg_color":"","width":"","alias":"ADMIN_INSERT","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_MODIFY"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec3","fg_color":"","width":"","alias":"ADMIN_MODIFY","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DELETE"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"sec4","fg_color":"","width":"","alias":"ADMIN_DELETE","RowSpan":0,"extensible":false}]});
this.lbl_security=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_security","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"11pt","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_security","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lbl_security),false,true)%>","type":"Label","w":175,"x":221,"y":155,"zindex":"1"});
this.dataobj_security_of_group=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_security_of_group","cmdHash":"<%=JSPLib.cmdHash("spquery_security_of_group",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_security_of_group","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_security_of_group","nrows":"15","page":1,"parms":"groupcode=code","parms_source":"StdTreeView_Groups","type":"SQLDataobj","w":120,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":391,"y":-49});
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
<%request.setAttribute("spadministration_groups_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_groups_Static=function(){
if(typeof GetNodeIcon !='undefined')this.GetNodeIcon=GetNodeIcon;
if(typeof newFolder !='undefined')this.newFolder=newFolder;
if(typeof deleteFolder !='undefined')this.deleteFolder=deleteFolder;
if(typeof refreshusers !='undefined')this.refreshusers=refreshusers;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.StdTreeView_Groups.addDataConsumer(this.selected_group,<%=JSPLib.ToJSValue("code",true)%>);
this.StdTreeView_Groups.addParmConsumer(this.dataobj_groups);
this.StdTreeView_Groups.addParmConsumer(this.dataobj_users_of_group);
this.StdTreeView_Groups.addDataConsumer(this.idfolder,<%=JSPLib.ToJSValue("code",true)%>);
this.dataobj_users_of_group.addRowConsumer(this.user_list);
this.dataobj_groups.addRowConsumer(this.StdTreeView_Groups);
this.StdTreeView_Groups.SetDataObject(this.dataobj_groups);
this.dataobj_security_of_group.addRowConsumer(this.security_list);
this.StdTreeView_Groups.addParmConsumer(this.dataobj_security_of_group);

m_cProgName="spadministration_groups_list";
this.usercode.Value(<%=sp.getUserCode()%>);
function GetNodeIcon(group_type){
  if(group_type=='R')
    return '../images/spadministration_role.gif';
  else if(group_type=='D')
    return '../images/spadministration_descriptive.gif';
  else if(group_type=='O')
    return '../images/spadministration_organizational.gif';
  else if(group_type=='S')
    return '../images/spadministration_sharing.gif';
  else
    return '../images/spadministration_group.gif';
}
function newFolder(){
  var node=this.StdTreeView_Groups.getCurrentNode();
  node.refreshNode();
  node.selectNode();
}
function deleteFolder(){
  var _this=this;
  WindowConfirm('Are you sure to delete this folder?', function(res){
    if(res){
      var father=_this.StdTreeView_Groups.getCurrentNode().nodeFather;
      if(typeof(father)=='object'){
        _this.splinker_group_delete.Link();
        father.refreshNode();
        father.selectNode();
      }
    }
  });
}
function refreshusers(){
  var node=this.StdTreeView_Groups.getCurrentNode();
  node.refreshNode();
  node.selectNode();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_groups_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_SPManageGroups_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageGroups_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_SPManageUsers_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageUsers_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.dataobj_groups.firstQuery('true');
window.<%=idPortlet%>.dataobj_users_of_group.firstQuery('true');
window.<%=idPortlet%>.dataobj_security_of_group.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_groups',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_groups');
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
sp.endPage("spadministration_groups");
}%>
<%! public String getJSPUID() { return "3595591228"; } %>