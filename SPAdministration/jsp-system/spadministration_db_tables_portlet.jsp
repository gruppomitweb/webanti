<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"m_cTarget = '\u003c%= JSPLib.ToJSValue((String) (Class.forName(\"SPControlPanel\").getField(\"m_cTarget\").get(null))) %\u003e';\nfunction this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AppendButton({\n  \timage: SPTheme.controlPanelDatabaseAccess || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fdbserver.png\",pageContext.getServletContext())%\u003e',\n    action: this.splinker_dbserver.Link.bind(this.splinker_dbserver),\n    title:FormatMsg(\"ADMIN_DATABASE_SERVER\"),\n    tooltip:FormatMsg(\"ADMIN_DATABASE_SERVER\")\n  })   \n  if(m_cTarget != \"_blank\") {\n    customToolbar.AppendButton({\n      image:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n      action:'..\u002fservlet\u002fSPControlPanel',\n      title:FormatMsg(\"MSG_BACK\"),\n      tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n    })\n  }\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })                        \n  customToolbar.SetTitle(FormatMsg(\"CP_TABLES\"));\n  customToolbar.RearrangeAll();\n}\nm_cProgName=\"sptables\";\n\nfunction myFormat(str){\n\t\u002f\u002ffunzione per la formattazione della data\n  if (str.length !== 0){\n\t\tyear = Substr(str,1,4);\n  \tmonth = Substr(str,5,2);\n  \tday = Substr(str,7,2);\n  \thour = Substr(str,9,2);\n  \tminutes = Substr(str,11,2);\n  \tseconds = Substr(str,13,2);\n  \tstr = day + \"-\" + month + \"-\" + year + \" \" + hour + \":\" + minutes + \":\" + seconds;\n\t}\n\treturn str;\n}\nfunction view_tables_list_Rendered(){\n  this.view_tables_list.TopToolsbar.RemoveItem(\"expandoreduce_itm\");\n  \n}\n\nfunction view_tables_list_DataChange(){\n\t\u002f\u002fthis.tables_view_query.Query();\n}\n\nfunction imageExtender_Click(){\n\tthis.splinker_spextender.Link();\n}\n\nfunction label_TableExtender_Click(){\n\tthis.splinker_spextender.Link();\n}\n\nfunction imageRunDBAdmin_Click(){\n\tthis.splinkerDBAdmin.Link();\n}\n\nfunction label_DBAdmin_Click(){\n\tthis.splinkerDBAdmin.Link();\n}\n\nfunction img_database_server_Click(){\n\tthis.splinker_dbserver.Link();\n}\n\nfunction label_database_server_Click(){\n\tthis.splinker_dbserver.Link();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"portlet-white-default","css_code":"[]","custom":"","description":"Tabelle database","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @view_tables_list }}{{ @_dummy_target_ }}\u003c\u002fbody\u003e","grapesCss":"","h":"175","hsl":"","htmlcode":"{{ @view_tables_list }} \n{{ dataobj_server }}\n{{ tables_view_query }}\n{{ view_tables_list }}\n{{ img_database_server }}\n{{ SPManageServers_savedEntity }}\n{{ imageRunDBAdmin }}\n{{ imageExtender }}\n{{ _dummy_target_ }}\n{{ label_DBAdmin }}\n{{ label_TableExtender }}\n{{ splinker_spextender }}\n{{ label_database_server }}\n{{ splinkerDBAdmin }}\n{{ splinker_dbserver }}\n{{ action }}\n \n \n \n{{ @_dummy_target_ }} \n \n \n \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"175\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"900","version":"37","w":"100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"100","name":"dataobj_server","offline":"false","page":"1","parms":"","parms_source":"","query":"spquery_server","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"160","waiting_mgs":"","x":"4","y":"206"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"12","name":"tables_view_query","offline":"false","page":"1","parms":"","parms_source":"","query":"spquery_view_tables","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"160","waiting_mgs":"","x":"4","y":"181"},{"align":"left","anchor":"top-left-right","business_obj":"SPManageTables","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"FileName","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_DATA_NAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"FileName\",\"maxwidth\":\"\",\"title\":\"ADMIN_DATA_NAME\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_PHYSICAL_NAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"PhName\",\"maxwidth\":\"\",\"title\":\"ADMIN_PHYSICAL_NAME\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_LAST_MODIFIED\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"function:myFormat('%DateMod%')\",\"maxwidth\":\"\",\"title\":\"ADMIN_LAST_MODIFIED\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"field\":\"ServerName\",\"title\":\"ADMIN_DATABASE_SERVER\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":true,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"height\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"hidden\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_DATABASE_SERVER\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:ServerName:dataobj_server:Name:Description:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_DATABASE_SERVER\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true,\"disable_fields_conditions\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"tables_view_query","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,C,,","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"175","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"view_tables_list","nav_bar":"true","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"13","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"false","show_btn_update":"true","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"900","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":"","zone":""},{"actObjs":"tables_view_query,dataobj_server","actTypes":"dataobj,dataobj","broadcast":"all","ctrlOfVariant":"","h":"20","included":"true","name":"SPManageServers_savedEntity","objsValues":",","page":"1","parmsNames":"","sequence":"3","type":"EventReceiver","w":"160","x":"4","y":"306"},{"anchor":"","auto_resize":"false","border":"false","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"0","hide":"false","layer":"false","layout_steps_values":"{}","name":"_dummy_target_","page":"1","rapp":"","sequence":"4","spuid":"","type":"Iframe","w":"0","wireframe_props":"","x":"22","y":"214","zindex":"","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_spextender","offline":"false","page":"1","parms":"","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"900","progressbar":"","refresh":"","sequence":"5","servlet":"..\u002fspextender","target":"","type":"SPLinker","w":"160","x":"4","y":"231"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinkerDBAdmin","offline":"false","page":"1","parms":"action","popup":"true","popup_height":"580","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"780","progressbar":"","refresh":"","sequence":"6","servlet":"SPDBAdministration","target":"","type":"SPLinker","w":"160","x":"4","y":"281"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_dbserver","offline":"false","page":"1","parms":"","popup":"true","popup_height":"350","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":"","refresh":"","sequence":"7","servlet":"..\u002fjsp-system\u002fspadministration_servers_portlet.jsp","target":"","type":"SPLinker","w":"160","x":"4","y":"256"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"'dbadmin_preview'","name":"action","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"160","x":"4","y":"331"},{"cachelevel":"","cachelevel2":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":"20","measures":"","name":"MLevelDataProvider9","page":"1","parms":"","parms_source":"","queries":"","sequence":"9","type":"MLevelDataProvider","uptolevels":"","w":"120","x":"1285","y":"605"}]%>
<%/*Description:Tabelle database*/%>
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
.spadministration_db_tables_container {
  height:100%;
  overflow:auto;
}
.spadministration_db_tables_portlet{
  position:relative;
  width:100%;
  min-width:900px;
  height:100%;
}
.spadministration_db_tables_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.spadministration_db_tables_portlet > .view_tables_list_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:175px;
}
.spadministration_db_tables_portlet > ._dummy_target__ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:214px;
  left:22px;
  width:0px;
  height:0px;
}
.spadministration_db_tables_portlet > .MLevelDataProvider9_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:605px;
  left:1285px;
  width:120px;
  height:20px;
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
 String def="[{\"h\":\"175\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"900\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"160\",\"x\":\"4\",\"y\":\"206\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"160\",\"x\":\"4\",\"y\":\"181\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ADMIN_DATA_NAME\"},{\"title\":\"ADMIN_PHYSICAL_NAME\"},{\"title\":\"ADMIN_LAST_MODIFIED\"},{\"title\":\"ADMIN_DATABASE_SERVER\"},{\"isEditable\":true,\"title\":\"ADMIN_DATABASE_SERVER\"}],\"h\":\"175\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"13\",\"type\":\"Grid\",\"w\":\"900\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"160\",\"x\":\"4\",\"y\":\"306\"},{\"anchor\":\"\",\"h\":\"0\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"0\",\"x\":\"22\",\"y\":\"214\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"4\",\"y\":\"231\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"4\",\"y\":\"281\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"4\",\"y\":\"256\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"160\",\"x\":\"4\",\"y\":\"331\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"MLevelDataProvider\",\"w\":\"120\",\"x\":\"1285\",\"y\":\"605\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_db_tables","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_db_tables_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_db_tables','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_db_tables_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String action="dbadmin_preview";
if(request.getAttribute("spadministration_db_tables_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("MLevelDataProviderObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_db_tables_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_db_tables_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_db_tables_portlet portlet-white-default' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_db_tables','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_view_tables_list' formid='<%=idPortlet%>' ps-name='view_tables_list'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<div id='<%=idPortlet%>__dummy_target__DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_MLevelDataProvider9' style='position:absolute;top:605px;left:1285px;width:120px;height:20px;'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_db_tables');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_DATABASE_SERVER",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_SERVER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_TABLES",true)+","+JSPLib.ToJSValue(sp.translate("CP_TABLES"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_BACK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_BACK"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_db_tables',["900"],["175"],'portlet-white-default',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"900","h":"175","title":"","layer":""}]);
this.dataobj_server=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_server","cmdHash":"<%=JSPLib.cmdHash("spquery_server",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_server","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_server","nrows":"100","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":160,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":4,"y":206});
this.tables_view_query=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_view_tables","cmdHash":"<%=JSPLib.cmdHash("spquery_view_tables",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_tables_view_query","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"tables_view_query","nrows":"12","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":160,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":4,"y":181});
this.view_tables_list=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"SPManageTables","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"FileName","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_view_tables_list","dataobj":"tables_view_query","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":175,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"view_tables_list","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"false","show_btn_update":"true","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":900,"x":0,"y":0,"zindex":""});
this.view_tables_list.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":13,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATA_NAME"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"ADMIN_DATA_NAME","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"FileName","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_PHYSICAL_NAME"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"PhName","fg_color":"","width":"","alias":"ADMIN_PHYSICAL_NAME","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_LAST_MODIFIED"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"function:myFormat('%DateMod%')","fg_color":"","width":"","alias":"ADMIN_LAST_MODIFIED","RowSpan":0},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_SERVER"),false,true)%>","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":true,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"ServerName","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_SERVER"),false,true)%>","layer":"","ColSpan":0,"newline":false,"isEditable":true,"alias":"ADMIN_DATABASE_SERVER","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"combobox:ServerName:dataobj_server:Name:Description:false","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.view_tables_list.m_cID='<%=JSPLib.cmdHash("routine,spgridoperation",request.getSession())%>';
PrepareJsCalendar(false);
this.SPManageServers_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"tables_view_query,dataobj_server","actTypes":"dataobj,dataobj","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageServers_savedEntity","h":20,"hide":"false","included":"true","layer":false,"layout_steps_values":{},"name":"SPManageServers_savedEntity","objsValues":",","page":1,"parmsNames":"","type":"EventReceiver","w":160,"x":4,"y":306});
this._dummy_target_=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>__dummy_target_","default_portlet":"","h":0,"hide":"false","layer":false,"layout_steps_values":{},"name":"_dummy_target_","name_iframe":"_dummy_target_","page":1,"spuid":"","type":"Iframe","w":0,"x":22,"y":214,"zindex":""});
this.splinker_spextender=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_spextender","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_spextender","offline":false,"page":1,"parms":"","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"900","progressbar":false,"refresh":"","servlet":"..\u002fspextender","target":"","type":"SPLinker","w":160,"x":4,"y":231});
this.splinker_spextender.m_cID='<%=JSPLib.cmdHash("entity,../spextender",request.getSession())%>';
this.splinkerDBAdmin=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkerDBAdmin","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkerDBAdmin","offline":false,"page":1,"parms":"action","popup":"true","popup_height":"580","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"780","progressbar":false,"refresh":"","servlet":"SPDBAdministration","target":"","type":"SPLinker","w":160,"x":4,"y":281});
this.splinkerDBAdmin.m_cID='<%=JSPLib.cmdHash("entity,SPDBAdministration",request.getSession())%>';
this.splinker_dbserver=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_dbserver","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_dbserver","offline":false,"page":1,"parms":"","popup":"true","popup_height":"350","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspadministration_servers_portlet.jsp","target":"","type":"SPLinker","w":160,"x":4,"y":256});
this.splinker_dbserver.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spadministration_servers_portlet.jsp",request.getSession())%>';
this.action=new ZtVWeb._VC(this,'action',null,'character','<%=JSPLib.ToJSValue(action,false,true)%>',false,false);
this.MLevelDataProvider9=new ZtVWeb.MLevelDataProvider(this,{"anchor":"top-left","async":false,"cachelevel":0,"cachelevel2":0,"cmdHash":["<%=JSPLib.cmdHash("",request.getSession())%>"],"ctrlid":"<%=idPortlet%>_MLevelDataProvider9","decrypted_parms":"","encrypted_fields":"","fields":"","fieldskeys":"","filterfields":"","filterfieldskeys":"","h":20,"hide":"false","layer":false,"layout_steps_values":{},"measures":"","name":"MLevelDataProvider9","page":1,"parms":"","parms_source":"","queries":"","type":"MLevelDataProvider","uptolevels":"","w":120,"x":1285,"y":605});
this.MLevelDataProvider9._FTranslations = {In_Progress:'<%=JSPLib.ToJSValue(sp.translate("MSG_ELABORATION_INPROGRESS"))%>'}
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
<%request.setAttribute("spadministration_db_tables_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_db_tables_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof myFormat !='undefined')this.myFormat=myFormat;
if(typeof view_tables_list_Rendered !='undefined')this.view_tables_list_Rendered=view_tables_list_Rendered;
if(typeof view_tables_list_DataChange !='undefined')this.view_tables_list_DataChange=view_tables_list_DataChange;
if(typeof imageExtender_Click !='undefined')this.imageExtender_Click=imageExtender_Click;
if(typeof label_TableExtender_Click !='undefined')this.label_TableExtender_Click=label_TableExtender_Click;
if(typeof imageRunDBAdmin_Click !='undefined')this.imageRunDBAdmin_Click=imageRunDBAdmin_Click;
if(typeof label_DBAdmin_Click !='undefined')this.label_DBAdmin_Click=label_DBAdmin_Click;
if(typeof img_database_server_Click !='undefined')this.img_database_server_Click=img_database_server_Click;
if(typeof label_database_server_Click !='undefined')this.label_database_server_Click=label_database_server_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.tables_view_query.addRowConsumer(this.view_tables_list);
m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  customToolbar.AppendButton({
  	image: SPTheme.controlPanelDatabaseAccess || '<%=sp.getThemedImage("../images/dbserver.png",pageContext.getServletContext())%>',
    action: this.splinker_dbserver.Link.bind(this.splinker_dbserver),
    title:FormatMsg("ADMIN_DATABASE_SERVER"),
    tooltip:FormatMsg("ADMIN_DATABASE_SERVER")
  })   
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
  customToolbar.SetTitle(FormatMsg("CP_TABLES"));
  customToolbar.RearrangeAll();
}
m_cProgName="sptables";
function myFormat(str){
	//funzione per la formattazione della data
  if (str.length !== 0){
		year = Substr(str,1,4);
  	month = Substr(str,5,2);
  	day = Substr(str,7,2);
  	hour = Substr(str,9,2);
  	minutes = Substr(str,11,2);
  	seconds = Substr(str,13,2);
  	str = day + "-" + month + "-" + year + " " + hour + ":" + minutes + ":" + seconds;
	}
	return str;
}
function view_tables_list_Rendered(){
  this.view_tables_list.TopToolsbar.RemoveItem("expandoreduce_itm");
  
}
function view_tables_list_DataChange(){
	//this.tables_view_query.Query();
}
function imageExtender_Click(){
	this.splinker_spextender.Link();
}
function label_TableExtender_Click(){
	this.splinker_spextender.Link();
}
function imageRunDBAdmin_Click(){
	this.splinkerDBAdmin.Link();
}
function label_DBAdmin_Click(){
	this.splinkerDBAdmin.Link();
}
function img_database_server_Click(){
	this.splinker_dbserver.Link();
}
function label_database_server_Click(){
	this.splinker_dbserver.Link();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_db_tables_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_<%=(!"".equals(Library.getAttribute(request,"m_cInclusionEntityName",""))?Library.getAttribute(request,"m_cInclusionEntityName","")+"_":"")%>SPManageServers_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageServers_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.dataobj_server.firstQuery('true');
window.<%=idPortlet%>.tables_view_query.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_db_tables',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_db_tables');
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
sp.endPage("spadministration_db_tables");
}%>
<%! public String getJSPUID() { return "3602736095"; } %>