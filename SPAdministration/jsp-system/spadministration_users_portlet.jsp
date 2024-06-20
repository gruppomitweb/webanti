<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"m_cProgName=\"spadministration_groups_list\";\n\n\nfunction RefreshGrid(){\n  this.dataobj_manage_users.Query();\n}\n\nfunction valCaption(evt){\n var customToolbar=this.getTitlePortlet();\n customToolbar.SetTitle('\u003c%=sp.translate(\"CP_USERS\")%\u003e'+ \" - \" + LRTrim(evt.desFolder),true)\n}\n \nfunction this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n    action:'..\u002fservlet\u002fSPControlPanel',\n    title:FormatMsg(\"MSG_BACK\"),\n    tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n  })\n  customToolbar.SetTitle(FormatMsg(\"CP_USERS\"))\n  customToolbar.HideBackgroundImage();  \n  customToolbar.RearrangeAll();\n}\n\n\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Grid_user_list }}\u003c\u002fbody\u003e","grapesCss":"","h":"140","hsl":"","htmlcode":"{{ @Grid_user_list }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"140\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","init_time":"0","localDBName":"","long_query":"false","n_records":"30","name":"dataobj_manage_users","offline":"false","page":"1","parms":"groupcode=idfolder","parms_source":"","query":"spquery_users_of_group","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"30","waiting_mgs":"","x":"410","y":"46"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_CODE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\\\"999$|$999\\\"\",\"field\":\"code\",\"maxwidth\":\"\",\"title\":\"ADMIN_CODE\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_NAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"name\",\"maxwidth\":\"\",\"title\":\"ADMIN_NAME\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_FULLNAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"fullname\",\"maxwidth\":\"\",\"title\":\"ADMIN_FULLNAME\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_LANGUAGE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"language\",\"maxwidth\":\"\",\"title\":\"ADMIN_LANGUAGE\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_SSOID\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"ssoid\",\"maxwidth\":\"\",\"title\":\"ADMIN_SSOID\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataobj_manage_users","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"N,C,C,C,C","filters":"true-by-example","fixed":"","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"140","hide":"false","hide_default_titles":"","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_user_list","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"manage_users_new","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":"","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"editload","name":"manage_users_new","offline":"false","page":"1","parms":"code,selected_group","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"760","progressbar":"","refresh":"","sequence":"3","servlet":"SPManageUsers","target":"","type":"SPLinker","w":"30","x":"420","y":"-38"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPManageUsers_savedEntity","objsValues":"this.RefreshGrid()","page":"1","parmsNames":"","sequence":"4","type":"EventReceiver","w":"22","x":"457","y":"-31"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPGrpDescription","objsValues":"this.valCaption(evt)","page":"1","parmsNames":"desFolder","sequence":"5","type":"EventReceiver","w":"22","x":"508","y":"-30"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"idfolder","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"562","y":"67"},{"actObjs":"idfolder,selected_group,","actTypes":"var,var,func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPEmitter_groups","objsValues":"idfolder,selected_group,this.RefreshGrid()","page":"1","parmsNames":"idfolder,selected_group","sequence":"7","type":"EventReceiver","w":"22","x":"523","y":"67"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"selected_group","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"562","y":"97"},{"actObjs":"idfolder","actTypes":"var","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPManageUsers_lodedEntity","objsValues":"code","page":"1","parmsNames":"code","sequence":"9","type":"EventReceiver","w":"22","x":"483","y":"-30"}]%>
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
.spadministration_users_container {
}
.spadministration_users_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:140px;
  background-color:transparent;
}
.spadministration_users_portlet[Data-page="1"]{
  height:140px;
  width:100%;
}
.spadministration_users_portlet > .Grid_user_list_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:140px;
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
 String def="[{\"h\":\"140\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"410\",\"y\":\"46\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ADMIN_CODE\"},{\"title\":\"ADMIN_NAME\"},{\"title\":\"ADMIN_FULLNAME\"},{\"title\":\"ADMIN_LANGUAGE\"},{\"title\":\"ADMIN_SSOID\"}],\"h\":\"140\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"420\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"457\",\"y\":\"-31\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"508\",\"y\":\"-30\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"562\",\"y\":\"67\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"523\",\"y\":\"67\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"562\",\"y\":\"97\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"483\",\"y\":\"-30\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_users","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_users_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_users','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_users_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String idfolder= "";
String selected_group= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_users_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_users_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_users_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_users','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid_user_list' formid='<%=idPortlet%>' ps-name='Grid_user_list'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_users');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_USERS",true)+","+JSPLib.ToJSValue(sp.translate("CP_USERS"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_users',["400"],["140"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"140","title":"","layer":""}]);
this.dataobj_manage_users=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_users_of_group","cmdHash":"<%=JSPLib.cmdHash("spquery_users_of_group",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataobj_manage_users","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_manage_users","nrows":"30","page":1,"parms":"groupcode=idfolder","parms_source":"","type":"SQLDataobj","w":30,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":410,"y":46});
this.Grid_user_list=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_user_list","dataobj":"dataobj_manage_users","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":140,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_user_list","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"manage_users_new","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":400,"x":0,"y":0,"zindex":""});
this.Grid_user_list.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CODE"),false,true)%>","layer":"","ColSpan":0,"picture":"\"999|999\"","target":"","bg_color":"","newline":false,"field":"code","fg_color":"","width":"","alias":"ADMIN_CODE","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_NAME"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"name","fg_color":"","width":"","alias":"ADMIN_NAME","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_FULLNAME"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"fullname","fg_color":"","width":"","alias":"ADMIN_FULLNAME","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_LANGUAGE"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"language","fg_color":"","width":"","alias":"ADMIN_LANGUAGE","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_SSOID"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"ssoid","fg_color":"","width":"","alias":"ADMIN_SSOID","RowSpan":0,"extensible":false}]});
this.manage_users_new=new ZtVWeb.SPLinkerCtrl(this,{"action":"editload","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_manage_users_new","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"manage_users_new","offline":false,"page":1,"parms":"code,selected_group","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"760","progressbar":false,"refresh":"","servlet":"SPManageUsers","target":"","type":"SPLinker","w":30,"x":420,"y":-38});
this.manage_users_new.m_cID='<%=JSPLib.cmdHash("entity,SPManageUsers",request.getSession())%>';
this.SPManageUsers_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageUsers_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageUsers_savedEntity","objsValues":"this.RefreshGrid()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":457,"y":-31});
this.SPGrpDescription=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPGrpDescription","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPGrpDescription","objsValues":"this.valCaption(evt)","page":1,"parmsNames":"desFolder","type":"EventReceiver","w":22,"x":508,"y":-30});
this.idfolder=new ZtVWeb._VC(this,'idfolder',null,'character','<%=JSPLib.ToJSValue(idfolder,false,true)%>',false,false);
this.SPEmitter_groups=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"idfolder,selected_group,","actTypes":"var,var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPEmitter_groups","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPEmitter_groups","objsValues":"idfolder,selected_group,this.RefreshGrid()","page":1,"parmsNames":"idfolder,selected_group","type":"EventReceiver","w":22,"x":523,"y":67});
this.selected_group=new ZtVWeb._VC(this,'selected_group',null,'character','<%=JSPLib.ToJSValue(selected_group,false,true)%>',false,false);
this.SPManageUsers_lodedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"idfolder","actTypes":"var","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageUsers_lodedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageUsers_lodedEntity","objsValues":"code","page":1,"parmsNames":"code","type":"EventReceiver","w":22,"x":483,"y":-30});
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
<%request.setAttribute("spadministration_users_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_users_Static=function(){
if(typeof RefreshGrid !='undefined')this.RefreshGrid=RefreshGrid;
if(typeof valCaption !='undefined')this.valCaption=valCaption;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj_manage_users.addRowConsumer(this.Grid_user_list);
m_cProgName="spadministration_groups_list";
function RefreshGrid(){
  this.dataobj_manage_users.Query();
}
function valCaption(evt){
 var customToolbar=this.getTitlePortlet();
 customToolbar.SetTitle('<%=sp.translate("CP_USERS")%>'+ " - " + LRTrim(evt.desFolder),true)
}
 
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  customToolbar.AppendButton({
  	image:SPTheme.controlPanelHelp || '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
    action:'javascript:Help()',
    title:FormatMsg("ADMIN_HELP_TITLE"),
    tooltip:FormatMsg("ADMIN_HELP_TITLE")
  })
  customToolbar.AppendButton({
  	image:SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
    action:'../servlet/SPControlPanel',
    title:FormatMsg("MSG_BACK"),
    tooltip:FormatMsg("ADMIN_BACK_TO_CP")
  })
  customToolbar.SetTitle(FormatMsg("CP_USERS"))
  customToolbar.HideBackgroundImage();  
  customToolbar.RearrangeAll();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_users_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_SPManageUsers_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageUsers_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_SPGrpDescription=function(parmsObj){<%=idPortlet%>.SPGrpDescription.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_SPEmitter_groups=function(parmsObj){<%=idPortlet%>.SPEmitter_groups.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_SPManageUsers_lodedEntity=function(parmsObj){<%=idPortlet%>.SPManageUsers_lodedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.dataobj_manage_users.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_users',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_users');
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
sp.endPage("spadministration_users");
}%>
<%! public String getJSPUID() { return "4249482711"; } %>