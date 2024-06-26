<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var m_cTarget = '\u003c%= JSPLib.ToJSValue((String) (Class.forName(\"SPControlPanel\").getField(\"m_cTarget\").get(null))) %\u003e';\nfunction this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })\n  if(m_cTarget != \"_blank\") {\n  \tcustomToolbar.AppendButton({\n\t  \timage:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n\t    action:'..\u002fservlet\u002fSPControlPanel',\n  \t  title:FormatMsg(\"MSG_BACK\"),\n\t    tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n\t  })   \n  }\n  customToolbar.SetTitle(FormatMsg(\"CP_PRINTERS\"));\n  customToolbar.RearrangeAll();\n}\n\nm_cProgName=\"spadministration_printers_list\";\n\nfunction RefreshGrid(){\n  this.printer_query.Query();\n}\n\nfunction queueopen(prnconnection) {\n  var param = 'prnconnection='+prnconnection\n  this.manage_queues.Parameters(param);\n  this.manage_queues.Link();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"portlet-white-default","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @printer_list }}\u003c\u002fbody\u003e","grapesCss":"","h":"140","hsl":"","htmlcode":"{{ @printer_list }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"140\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","init_time":"0","localDBName":"","long_query":"false","n_records":"30","name":"printer_query","offline":"false","page":"1","parms":"","parms_source":"","query":"SPQUERY_VIEW_PRINTERS","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"200","waiting_mgs":"","x":"415","y":"103"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"1","cellspacing":"0","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"code\",\"title\":\"ADMIN_CODE\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"prndescription\",\"title\":\"ADMIN_DESCRIPTION\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"prnconnection\",\"title\":\"PRN_NAME\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"printer_query","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,C,N,C,C","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"140","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"printer_list","nav_bar":"true","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"true","render_totals":"false","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"manage_printers","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":"399","wireframe_props":"colProperties,checkbox,rows","x":"-1","y":"0","zindex":"","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"manage_printers","offline":"false","page":"1","parms":"code","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"650","progressbar":"","refresh":"false","sequence":"2","servlet":"SPManagePrinters","target":"","type":"SPLinker","w":"200","x":"415","y":"8"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"manage_queues","offline":"false","page":"1","parms":"","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"650","progressbar":"","refresh":"false","sequence":"3","servlet":"..\u002fjsp-system\u002fSPReportQueues_portlet.jsp","target":"","type":"SPLinker","w":"200","x":"415","y":"64"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"SPManagePrinters_savedEntity","objsValues":"this.RefreshGrid()","page":"1","parmsNames":"","sequence":"4","type":"EventReceiver","w":"200","x":"415","y":"37"}]%>
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
.spadministration_printers_container {
  height:100%;
  overflow:auto;
}
.spadministration_printers_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:100%;
}
.spadministration_printers_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.spadministration_printers_portlet > .printer_list_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:-1px;
  right:2px;
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
 String def="[{\"h\":\"140\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"200\",\"x\":\"415\",\"y\":\"103\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ADMIN_CODE\"},{\"title\":\"ADMIN_DESCRIPTION\"},{\"title\":\"PRN_NAME\"}],\"h\":\"140\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"399\",\"x\":\"-1\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"200\",\"x\":\"415\",\"y\":\"8\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"200\",\"x\":\"415\",\"y\":\"64\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"200\",\"x\":\"415\",\"y\":\"37\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_printers","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_printers_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_printers','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_printers_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_printers_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_printers_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_printers_portlet portlet-white-default' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_printers','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_printer_list' formid='<%=idPortlet%>' ps-name='printer_list'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_printers');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_PRINTERS",true)+","+JSPLib.ToJSValue(sp.translate("CP_PRINTERS"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_printers',["400"],["140"],'portlet-white-default',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"140","title":"","layer":""}]);
this.printer_query=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"SPQUERY_VIEW_PRINTERS","cmdHash":"<%=JSPLib.cmdHash("SPQUERY_VIEW_PRINTERS",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_printer_query","decrypted_parms":"","dialog_css_class":"sqldataprovider","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"printer_query","nrows":"30","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":200,"waiting_mgs":"<%=JSPLib.ToJSValue(sp.translate(""))%>","x":415,"y":103});
this.printer_list=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":1,"cellspacing":0,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_printer_list","dataobj":"printer_query","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":140,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"printer_list","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"true","render_totals":"false","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"manage_printers","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":399,"x":-1,"y":0,"zindex":""});
this.printer_list.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CODE"),false,true)%>","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"code","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DESCRIPTION"),false,true)%>","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"prndescription","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"<%=JSPLib.ToJSValue(sp.translate("PRN_NAME"),false,true)%>","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"prnconnection","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.manage_printers=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_manage_printers","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"manage_printers","offline":false,"page":1,"parms":"code","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"650","progressbar":false,"refresh":"false","servlet":"SPManagePrinters","target":"","type":"SPLinker","w":200,"x":415,"y":8});
this.manage_printers.m_cID='<%=JSPLib.cmdHash("entity,SPManagePrinters",request.getSession())%>';
this.manage_queues=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_manage_queues","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"manage_queues","offline":false,"page":1,"parms":"","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"650","progressbar":false,"refresh":"false","servlet":"..\u002fjsp-system\u002fSPReportQueues_portlet.jsp","target":"","type":"SPLinker","w":200,"x":415,"y":64});
this.manage_queues.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/SPReportQueues_portlet.jsp",request.getSession())%>';
this.SPManagePrinters_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManagePrinters_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManagePrinters_savedEntity","objsValues":"this.RefreshGrid()","page":1,"parmsNames":"","type":"EventReceiver","w":200,"x":415,"y":37});
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
<%request.setAttribute("spadministration_printers_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_printers_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RefreshGrid !='undefined')this.RefreshGrid=RefreshGrid;
if(typeof queueopen !='undefined')this.queueopen=queueopen;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.printer_query.addRowConsumer(this.printer_list);
var m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  customToolbar.AppendButton({
  	image:SPTheme.controlPanelHelp || '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
    action:'javascript:Help()',
    title:FormatMsg("ADMIN_HELP_TITLE"),
    tooltip:FormatMsg("ADMIN_HELP_TITLE")
  })
  if(m_cTarget != "_blank") {
  	customToolbar.AppendButton({
	  	image:SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
	    action:'../servlet/SPControlPanel',
  	  title:FormatMsg("MSG_BACK"),
	    tooltip:FormatMsg("ADMIN_BACK_TO_CP")
	  })   
  }
  customToolbar.SetTitle(FormatMsg("CP_PRINTERS"));
  customToolbar.RearrangeAll();
}
m_cProgName="spadministration_printers_list";
function RefreshGrid(){
  this.printer_query.Query();
}
function queueopen(prnconnection) {
  var param = 'prnconnection='+prnconnection
  this.manage_queues.Parameters(param);
  this.manage_queues.Link();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_printers_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_SPManagePrinters_savedEntity=function(parmsObj){<%=idPortlet%>.SPManagePrinters_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.printer_query.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_printers',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_printers');
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
sp.endPage("spadministration_printers");
}%>
<%! public String getJSPUID() { return "1922727676"; } %>