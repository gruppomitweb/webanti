<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"m_cProgName=\"spadministration_groups_list\";\n\nthis.usercode.Value(\u003c%=sp.getUserCode()%\u003e);                 \n                   \nfunction this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.SetTitle('\u003c%=sp.translate(\"CP_GROUPS\")%\u003e');\n}\n\n                    \nfunction GetNodeIcon(group_type){\n  if(group_type=='R') \n   return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_role.png\")%\u003e';\n  else if(group_type=='D')\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_descriptive.gif\")%\u003e';\n  else if(group_type=='O')\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_organizational.gif\")%\u003e';\n  else if(group_type=='S')\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_sharing.gif\")%\u003e';\n  else\n    return '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fspadministration_group.png\")%\u003e';\n}\n\nfunction newFolder(){\n  var node=this.StdTreeView_Groups.getCurrentNode();\n  node.refreshNode();\n  node.selectNode();\n}\n\nfunction deleteFolder(){\n  if (Empty(this.selected_group.Value())){\n    alert(FormatMsg('ADMIN_GROUP_EDIT_ALERT'));\n  }else{\n    var _this=this;\n    WindowConfirm(FormatMsg('ADMIN_GROUP_DELETE_FOLDER_ALERT'), function(res){\n      if(res){\n        var father=_this.StdTreeView_Groups.getCurrentNode().nodeFather;\n        if(typeof(father)=='object'){\n          _this.splinker_group_delete.Link();\n          father.refreshNode();\n          father.selectNode();\n        }\n      }\n    });\n  }\n}\n\nfunction refreshusers(){\n  var node=this.StdTreeView_Groups.getCurrentNode();\n  node.refreshNode();\n  node.selectNode();\n}\n\nfunction editGroup(){\n  if (Empty(this.selected_group.Value())){\n    alert(FormatMsg('ADMIN_GROUP_EDIT_ALERT'));  \n  }else{\n    this.splinker_group_edit.Link();\n  }  \n}\n  ","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Groups Treeview","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @folder_delete }}{{ @folder_new }}{{ @group_edit }}{{ @StdTreeView_Groups }}{{ @box_user }}{{ @label35 }}{{ @Box19 }}\u003c\u002fbody\u003e","grapesCss":"","h":"300","hsl":"","htmlcode":"{{ @lineBox }} \n{{ @folder_delete }} \n{{ usercode }}\n{{ selected_group }}\n{{ dataobj_groups }}\n{{ splinker_group_delete }}\n{{ splinker_group_new }}\n{{ splinker_group_edit }}\n{{ SPManageGroups_savedEntity }}\n{{ SPManageUsers_savedEntity }}\n{{ idfolder }}\n{{ namefolder }}\n{{ folder_delete }}\n{{ folder_new }}\n{{ group_edit }}\n{{ StdTreeView_Groups }}\n{{ SPEmitter_groups }}\n{{ box_user }}\n{{ label35 }}\n{{ Box16 }}\n{{ SPGrpDescription }}\n{{ @folder_new }} \n{{ @group_edit }} \n{{ @StdTreeView_Groups }} \n{{ @box_user }} \n{{ @label35 }} \n \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"300\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"220","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"","name":"usercode","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"numeric","w":"100","x":"549","y":"-42"},{"calculate":"","ctrlOfVariant":"","dataobj":"StdTreeView_Groups","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"code","h":"22","init":"","init_par":"","name":"selected_group","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"numeric","w":"100","x":"445","y":"-42"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","init_time":"0","localDBName":"","long_query":"false","n_records":"10000","name":"dataobj_groups","offline":"false","page":"1","parms":"code","parms_source":"StdTreeView_Groups","query":"spquery_groupstree","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"30","waiting_mgs":"","x":"323","y":"-39"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"function","name":"splinker_group_delete","offline":"false","page":"1","parms":"idfolder","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"false","sequence":"3","servlet":"spadministration_deletegroup","target":"","type":"SPLinker","w":"30","x":"143","y":"-39"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"new","name":"splinker_group_new","offline":"false","page":"1","parms":"idfolder","popup":"true","popup_height":"550","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":"","refresh":"false","sequence":"4","servlet":"SPManageGroups","target":"","type":"SPLinker","w":"30","x":"73","y":"-39"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"edit","name":"splinker_group_edit","offline":"false","page":"1","parms":"code=idfolder","popup":"true","popup_height":"550","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":"","refresh":"false","sequence":"5","servlet":"SPManageGroups","target":"","type":"SPLinker","w":"30","x":"108","y":"-39"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPManageGroups_savedEntity","objsValues":"this.newFolder()","page":"1","parmsNames":"","sequence":"6","type":"EventReceiver","w":"22","x":"14","y":"-36"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPManageUsers_savedEntity","objsValues":"this.refreshusers()","page":"1","parmsNames":"","sequence":"7","type":"EventReceiver","w":"22","x":"42","y":"-36"},{"calculate":"","ctrlOfVariant":"","dataobj":"StdTreeView_Groups","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"code","h":"22","init":"","init_par":"","name":"idfolder","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"numeric","w":"100","x":"549","y":"-19"},{"calculate":"","ctrlOfVariant":"","dataobj":"StdTreeView_Groups","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"name","h":"22","init":"","init_par":"","name":"namefolder","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"100","x":"548","y":"8"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image_button","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","help_tips":"ADMIN_GROUP_DELETE","hide":"false","hide_undercond":"","href":"function:deleteFolder()","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"folder_delete","page":"1","path_type":"themed","rapp":"","sequence":"10","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_delete.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"75","y":"14","zindex":"2","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image_button","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","help_tips":"ADMIN_GROUP_NEW","hide":"false","hide_undercond":"","href":"SPLink:splinker_group_new","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"folder_new","page":"1","path_type":"themed","rapp":"","sequence":"11","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_add.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"15","y":"14","zindex":"2","zone":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image_button","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","help_tips":"ADMIN_GROUP_EDIT","hide":"false","hide_undercond":"","href":"function:editGroup()","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"group_edit","page":"1","path_type":"themed","rapp":"","sequence":"12","server_side":"","spuid":"","src":"..\u002fimages\u002fspadministration_folder_edit.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"45","y":"14","zindex":"2","zone":""},{"anchor":"","css":"","css_class":"","ctrlOfVariant":"","dataobj":"dataobj_groups","droppable":"false","droppable_name":"","enable_html":"false","field_ChildCount":"childnum","field_NodeDescr":"name","field_NodeID":"code","field_picture":"","fixed":"","font":"","font_color":"","font_size":"","frame":"","h":"244","hidden_fields":"","hide":"false","layer":"false","layout_steps_values":"{}","name":"StdTreeView_Groups","node_link":"","page":"1","rapp":"","root_label":"CP_GROUPS","root_link":"","root_node_value":"","scroll_bars":"false","sequence":"13","set_icons":"function:GetNodeIcon(\"%grptype%\")","spuid":"","type":"StdTreeView","w":"190","wireframe_props":"","x":"15","y":"47","zindex":"","zone":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"onChange,onChange","eventsObjs":"idfolder,selected_group","h":"20","name":"SPEmitter_groups","page":"1","parmsNames":"idfolder,selected_group","parmsTypes":"var,var","parmsValues":"idfolder,selected_group","persistent":"true","sequence":"14","type":"EventEmitter","w":"22","x":"241","y":"-36"},{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"box_user_postin","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"9","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"box_user","page":"1","rapp":"","sequence":"15","shrinkable":"","spuid":"","stretch":"true","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"219","wireframe_props":"","x":"0","y":"0","zindex":"0","zone":""},{"align":"left","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"LabelTreeview","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"","font_size":"7pt","font_weight":"","fontpct":"","h":"35","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label35","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"220","wireframe_props":"align,value,n_col","x":"0","y":"9","zindex":"1","zone":""},{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"box_treeview_line","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"1","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"Box16","page":"1","rapp":"","sequence":"17","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"220","wireframe_props":"","x":"0","y":"46","zindex":"0","zone":""},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"onChange","eventsObjs":"namefolder","h":"20","name":"SPGrpDescription","page":"1","parmsNames":"desFolder","parmsTypes":"var","parmsValues":"namefolder","persistent":"true","sequence":"18","type":"EventEmitter","w":"22","x":"275","y":"-36"},{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box-border-bottom-gray","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"1","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"lineBox","page":"1","rapp":"","sequence":"19","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"220","wireframe_props":"","x":"0","y":"42","zindex":"3","zone":""}]%>
<%/*Description:Groups Treeview*/%>
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
.spadministration_group_treeview_container {
}
.spadministration_group_treeview_title_container {
  margin: auto;
}
.spadministration_group_treeview_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:220px;
  height:300px;
  background-color:transparent;
}
.spadministration_group_treeview_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.spadministration_group_treeview_portlet > .folder_delete_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:14px;
  left:75px;
  width:20px;
  height:20px;
}
.spadministration_group_treeview_portlet > .folder_delete_ctrl {
}
.spadministration_group_treeview_portlet > .folder_delete_ctrl > a, .spadministration_group_treeview_portlet > .folder_delete_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_group_treeview_portlet > .folder_delete_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.spadministration_group_treeview_portlet > .folder_new_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:14px;
  left:15px;
  width:20px;
  height:20px;
}
.spadministration_group_treeview_portlet > .folder_new_ctrl {
}
.spadministration_group_treeview_portlet > .folder_new_ctrl > a, .spadministration_group_treeview_portlet > .folder_new_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_group_treeview_portlet > .folder_new_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.spadministration_group_treeview_portlet > .group_edit_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:14px;
  left:45px;
  width:20px;
  height:20px;
}
.spadministration_group_treeview_portlet > .group_edit_ctrl {
}
.spadministration_group_treeview_portlet > .group_edit_ctrl > a, .spadministration_group_treeview_portlet > .group_edit_ctrl > a:hover{
  text-decoration:none;
}
.spadministration_group_treeview_portlet > .group_edit_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.spadministration_group_treeview_portlet > .StdTreeView_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:47px;
  left:15px;
  width:190px;
  height:244px;
}
.spadministration_group_treeview_portlet > .box_user_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:1px;
  width:auto;
  height:auto;
  min-height:9px;
  display:flex;
  flex-direction:column;
}
.spadministration_group_treeview_portlet > .box_user_ctrl {
  height:9px;
}
.spadministration_group_treeview_portlet > .box_user_ctrl > .box_content {
  height:100%;
}
.spadministration_group_treeview_portlet > .box_user_ctrl {
  min-height:9px;
}
.spadministration_group_treeview_portlet > .label35_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:35px;
}
.spadministration_group_treeview_portlet > .label35_ctrl {
  height:auto;
  min-height:35px;
}
.spadministration_group_treeview_portlet > .label35_ctrl {
  overflow:hidden;
  font-size:7pt;
  text-align:left;
}
.spadministration_group_treeview_portlet > .Box16_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:46px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:1px;
  display:flex;
  flex-direction:column;
}
.spadministration_group_treeview_portlet > .Box16_ctrl {
  height:1px;
}
.spadministration_group_treeview_portlet > .Box16_ctrl > .box_content {
  height:100%;
}
.spadministration_group_treeview_portlet > .Box16_ctrl {
  min-height:1px;
}
.spadministration_group_treeview_portlet > .lineBox_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:42px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:1px;
  display:flex;
  flex-direction:column;
}
.spadministration_group_treeview_portlet > .lineBox_ctrl {
  height:1px;
}
.spadministration_group_treeview_portlet > .lineBox_ctrl > .box_content {
  height:100%;
}
.spadministration_group_treeview_portlet > .lineBox_ctrl {
  min-height:1px;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"220\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"549\",\"y\":\"-42\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"445\",\"y\":\"-42\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"323\",\"y\":\"-39\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"143\",\"y\":\"-39\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"73\",\"y\":\"-39\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"108\",\"y\":\"-39\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"14\",\"y\":\"-36\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"42\",\"y\":\"-36\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"549\",\"y\":\"-19\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"100\",\"x\":\"548\",\"y\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"75\",\"y\":\"14\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"15\",\"y\":\"14\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"45\",\"y\":\"14\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"244\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"StdTreeView\",\"w\":\"190\",\"x\":\"15\",\"y\":\"47\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"241\",\"y\":\"-36\"},{\"anchor\":\"top-left-right\",\"h\":\"9\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"219\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"h\":\"35\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"220\",\"x\":\"0\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"1\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"220\",\"x\":\"0\",\"y\":\"46\",\"zindex\":\"0\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"275\",\"y\":\"-36\"},{\"anchor\":\"top-left(%)-right(%)\",\"h\":\"1\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"220\",\"x\":\"0\",\"y\":\"42\",\"zindex\":\"3\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_group_treeview","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_group_treeview_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_group_treeview','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double usercode= 0;
double selected_group= 0;
double idfolder= 0;
String namefolder= "";
if(request.getAttribute("spadministration_group_treeview_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("StdTreeViewObj.js")%>'></script>
<%}
String label35= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_group_treeview_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_group_treeview_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_group_treeview_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_group_treeview','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_folder_delete'><a id='<%=idPortlet%>_folder_deletehref' href='function:deleteFolder()' target='_self'><img id='<%=idPortlet%>_folder_delete_img' class='image_button folder_delete_ctrl' src="<%=sp.getThemedImage("../images/spadministration_folder_delete.png",pageContext.getServletContext())%>" border='0' ></a>
</div><div id='<%=idPortlet%>_folder_new'><a id='<%=idPortlet%>_folder_newhref' href='javascript:window.<%=idPortlet%>.splinker_group_new.Link()' target='_self'><img id='<%=idPortlet%>_folder_new_img' class='image_button folder_new_ctrl' src="<%=sp.getThemedImage("../images/spadministration_folder_add.png",pageContext.getServletContext())%>" border='0' ></a>
</div><div id='<%=idPortlet%>_group_edit'><a id='<%=idPortlet%>_group_edithref' href='function:editGroup()' target='_self'><img id='<%=idPortlet%>_group_edit_img' class='image_button group_edit_ctrl' src="<%=sp.getThemedImage("../images/spadministration_folder_edit.png",pageContext.getServletContext())%>" border='0' ></a>
</div><div id='<%=idPortlet%>_StdTreeView_Groups' formid='<%=idPortlet%>' ps-name='StdTreeView_Groups' class='stdtreeview'></div>
<div id='<%=idPortlet%>_box_user' class='box_user_ctrl SPSection_expanded box_user_postin' data-original-display='flex'><div id='<%=idPortlet%>_box_user_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_label35'  formid='<%=idPortlet%>' ps-name='label35'    class='LabelTreeview label35_ctrl'><div id='<%=idPortlet%>_label35tbl' style='width:100%;'></div></span>
<div id='<%=idPortlet%>_Box16' class='Box16_ctrl SPSection_expanded box_treeview_line' data-original-display='flex'><div id='<%=idPortlet%>_Box16_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_lineBox' class='lineBox_ctrl SPSection_expanded box-border-bottom-gray' data-original-display='flex'><div id='<%=idPortlet%>_lineBox_td' class='box_content'></div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_group_treeview');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_GROUP_DELETE_FOLDER_ALERT",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_DELETE_FOLDER_ALERT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_GROUP_EDIT_ALERT",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_EDIT_ALERT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FIELD_UNDEFINED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FIELD_UNDEFINED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_FILLING_SUBLAYER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_FILLING_SUBLAYER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_group_treeview',["220"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"220","h":"300","title":"","layer":""}]);
this.usercode=new ZtVWeb._VC(this,'usercode',null,'numeric',<%=usercode%>,false,false);
this.selected_group=new ZtVWeb._VC(this,'selected_group',null,'numeric',<%=selected_group%>,false,false);
this.dataobj_groups=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_groupstree","cmdHash":"<%=JSPLib.cmdHash("spquery_groupstree",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_groups","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_groups","nrows":"10000","page":1,"parms":"code","parms_source":"StdTreeView_Groups","type":"SQLDataobj","w":30,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":323,"y":-39});
this.splinker_group_delete=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_group_delete","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_group_delete","offline":false,"page":1,"parms":"idfolder","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"false","servlet":"spadministration_deletegroup","target":"","type":"SPLinker","w":30,"x":143,"y":-39});
this.splinker_group_delete.m_cID='<%=JSPLib.cmdHash("routine,spadministration_deletegroup",request.getSession())%>';
this.splinker_group_new=new ZtVWeb.SPLinkerCtrl(this,{"action":"new","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_group_new","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_group_new","offline":false,"page":1,"parms":"idfolder","popup":"true","popup_height":"550","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":false,"refresh":"false","servlet":"SPManageGroups","target":"","type":"SPLinker","w":30,"x":73,"y":-39});
this.splinker_group_new.m_cID='<%=JSPLib.cmdHash("entity,SPManageGroups",request.getSession())%>';
this.splinker_group_edit=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_group_edit","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_group_edit","offline":false,"page":1,"parms":"code=idfolder","popup":"true","popup_height":"550","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":false,"refresh":"false","servlet":"SPManageGroups","target":"","type":"SPLinker","w":30,"x":108,"y":-39});
this.splinker_group_edit.m_cID='<%=JSPLib.cmdHash("entity,SPManageGroups",request.getSession())%>';
this.SPManageGroups_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageGroups_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageGroups_savedEntity","objsValues":"this.newFolder()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":14,"y":-36});
this.SPManageUsers_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageUsers_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageUsers_savedEntity","objsValues":"this.refreshusers()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":42,"y":-36});
this.idfolder=new ZtVWeb._VC(this,'idfolder',null,'numeric',<%=idfolder%>,false,false);
this.namefolder=new ZtVWeb._VC(this,'namefolder',null,'character','<%=JSPLib.ToJSValue(namefolder,false,true)%>',false,false);
this.folder_delete=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image_button folder_delete_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_folder_delete","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_DELETE"),false,true)%>","hide":"false","hide_undercond":"","href":"function:deleteFolder()","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"folder_delete","page":1,"path_type":"themed","server_side":"","spuid":"","src":"<%=sp.getThemedImage("../images/spadministration_folder_delete.png",pageContext.getServletContext())%>","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":20,"x":75,"y":14,"zindex":"2"});
this.folder_new=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image_button folder_new_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_folder_new","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_NEW"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:window.<%=idPortlet%>.splinker_group_new.Link()","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"folder_new","page":1,"path_type":"themed","server_side":"","spuid":"","src":"<%=sp.getThemedImage("../images/spadministration_folder_add.png",pageContext.getServletContext())%>","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":20,"x":15,"y":14,"zindex":"2"});
this.group_edit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image_button group_edit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_group_edit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_GROUP_EDIT"),false,true)%>","hide":"false","hide_undercond":"","href":"function:editGroup()","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"group_edit","page":1,"path_type":"themed","server_side":"","spuid":"","src":"<%=sp.getThemedImage("../images/spadministration_folder_edit.png",pageContext.getServletContext())%>","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":20,"x":45,"y":14,"zindex":"2"});
this.StdTreeView_Groups=new ZtVWeb.StdTreeViewCtrl(this,{"anchor":"top-left","class_css":"stdtreeview","ctrlid":"<%=idPortlet%>_StdTreeView_Groups","droppable":false,"droppable_name":"","enable_html":false,"font":"","font_color":"","font_size":"","h":244,"hide":"false","icon":"function:GetNodeIcon(\"%grptype%\")","layer":false,"layout_steps_values":{},"name":"StdTreeView_Groups","node_link":"","page":1,"root_label":"<%=JSPLib.ToJSValue(sp.translate("CP_GROUPS"),false,true)%>","root_link":"","root_value":"","scroll_bars":"false","spuid":"","target":"","type":"StdTreeView","w":190,"x":15,"y":47,"zindex":""});
this.StdTreeView_Groups.setRowsCols({"field_ChildCount":"childnum","field_NodeID":"code","hiddenFlds":"","NodeDescr":"name","pictures":""});
this.SPEmitter_groups=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPEmitter_groups","eventsNames":"onChange,onChange","eventsObjs":"idfolder,selected_group","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"SPEmitter_groups","page":1,"parmsNames":"idfolder,selected_group","parmsTypes":"var,var","parmsValues":"idfolder,selected_group","persistent":"true","type":"EventEmitter","w":22,"x":241,"y":-36});
this.box_user=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"box_user_postin","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_box_user","groupName":"","h":9,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"box_user","page":1,"shrinkable":"","spuid":"","stretch":"true","target":"","title_caption":"","titled":"","type":"Box","w":219,"x":0,"y":0,"zindex":"0"});
this.label35=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"LabelTreeview","create_undercond":"","ctrlid":"<%=idPortlet%>_label35","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"7pt","font_weight":"","fontpct":"","h":35,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label35","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label35),false,true)%>","type":"Label","w":220,"x":0,"y":9,"zindex":"1"});
this.Box16=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"box_treeview_line","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Box16","groupName":"","h":1,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box16","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":220,"x":0,"y":46,"zindex":"0"});
this.SPGrpDescription=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPGrpDescription","eventsNames":"onChange","eventsObjs":"namefolder","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"SPGrpDescription","page":1,"parmsNames":"desFolder","parmsTypes":"var","parmsValues":"namefolder","persistent":"true","type":"EventEmitter","w":22,"x":275,"y":-36});
this.lineBox=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"box-border-bottom-gray","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_lineBox","groupName":"","h":1,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"lineBox","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":220,"x":0,"y":42,"zindex":"3"});
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
<%request.setAttribute("spadministration_group_treeview_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_group_treeview_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof GetNodeIcon !='undefined')this.GetNodeIcon=GetNodeIcon;
if(typeof newFolder !='undefined')this.newFolder=newFolder;
if(typeof deleteFolder !='undefined')this.deleteFolder=deleteFolder;
if(typeof refreshusers !='undefined')this.refreshusers=refreshusers;
if(typeof editGroup !='undefined')this.editGroup=editGroup;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.StdTreeView_Groups.addDataConsumer(this.selected_group,<%=JSPLib.ToJSValue("code",true)%>);
this.StdTreeView_Groups.addParmConsumer(this.dataobj_groups);
this.StdTreeView_Groups.addDataConsumer(this.idfolder,<%=JSPLib.ToJSValue("code",true)%>);
this.StdTreeView_Groups.addDataConsumer(this.namefolder,<%=JSPLib.ToJSValue("name",true)%>);
this.dataobj_groups.addRowConsumer(this.StdTreeView_Groups);
this.StdTreeView_Groups.SetDataObject(this.dataobj_groups);
m_cProgName="spadministration_groups_list";
this.usercode.Value(<%=sp.getUserCode()%>);                 
                   
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  customToolbar.SetTitle('<%=sp.translate("CP_GROUPS")%>');
}
                    
function GetNodeIcon(group_type){
  if(group_type=='R') 
   return '<%=sp.getThemedImage("../images/spadministration_role.png")%>';
  else if(group_type=='D')
    return '<%=sp.getThemedImage("../images/spadministration_descriptive.gif")%>';
  else if(group_type=='O')
    return '<%=sp.getThemedImage("../images/spadministration_organizational.gif")%>';
  else if(group_type=='S')
    return '<%=sp.getThemedImage("../images/spadministration_sharing.gif")%>';
  else
    return '<%=sp.getThemedImage("../images/spadministration_group.png")%>';
}
function newFolder(){
  var node=this.StdTreeView_Groups.getCurrentNode();
  node.refreshNode();
  node.selectNode();
}
function deleteFolder(){
  if (Empty(this.selected_group.Value())){
    alert(FormatMsg('ADMIN_GROUP_EDIT_ALERT'));
  }else{
    var _this=this;
    WindowConfirm(FormatMsg('ADMIN_GROUP_DELETE_FOLDER_ALERT'), function(res){
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
}
function refreshusers(){
  var node=this.StdTreeView_Groups.getCurrentNode();
  node.refreshNode();
  node.selectNode();
}
function editGroup(){
  if (Empty(this.selected_group.Value())){
    alert(FormatMsg('ADMIN_GROUP_EDIT_ALERT'));  
  }else{
    this.splinker_group_edit.Link();
  }  
}
  
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_group_treeview_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_SPManageGroups_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageGroups_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_SPManageUsers_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageUsers_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SPEmitter_groups.addObservers();
window.<%=idPortlet%>.SPGrpDescription.addObservers();
window.<%=idPortlet%>.dataobj_groups.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_group_treeview',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_group_treeview');
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
sp.endPage("spadministration_group_treeview");
}%>
<%! public String getJSPUID() { return "2306160622"; } %>