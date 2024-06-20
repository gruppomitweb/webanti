<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nm_cProgName=\"spadministration_ssomap_list\";\nfunction RefreshGrid(){\n  this.ssomap_list.Refresh();\n}","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"transparent","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":" ","form_target":" ","form_type":"false","h":"140","hsl":" ","language":"true","lock_items":" ","manifest":"Custom manifest","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"administrator","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"400","version":"37","w":"100%"},{"auto_exec":"true","count":"false","localDBName":" ","n_records":"30","name":"dataobj_ssomap","offline":"false","page":"1","parms":" ","parms_source":" ","query":"spquery_view_ssomap","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","x":"38","y":"-38"},{"align":"left","anchor":"top-left-right","business_obj":" ","cellpadding":"3","cellspacing":"0","checkbox":"false","checkbox_fields":" ","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"SSOID\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"ssoid\",\"maxwidth\":\"\",\"title\":\"SSOID\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"UserID\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"userid\",\"maxwidth\":\"\",\"title\":\"UserID\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"dataobj_ssomap","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C,N","filters":"true-by-example","font":" ","font_color":" ","font_size":" ","font_weight":" ","group_repeated":"false","h":"139","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":" ","line_color":" ","link_underlined":" ","name":"ssomap_list","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":" ","recMark":"true","render_totals":" ","resizablecolumns":"false","row_color":" ","row_color_odd":" ","rows":"30","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":"manage_ssomap","splinker_pos":"left","title_color":" ","type":"Grid","valign":"top","w":"399","x":"0","y":"0"},{"async":"false","entity_type":" ","h":"30","m_cAction":" ","m_cAltInterface":" ","name":"manage_ssomap","offline":"false","page":"1","parms":"ssoid","popup":"true","popup_height":"700","popup_scroll":"false","popup_style":" ","popup_width":"400","refresh":"false","sequence":"3","servlet":"SPManageSSOMap","target":" ","type":"SPLinker","w":"30","x":"80","y":"-38"},{"actObjs":" ","actTypes":"func","h":"20","included":"false","name":"SPManageSSOMap_savedEntity","objsValues":"this.RefreshGrid()","page":"1","parmsNames":" ","sequence":"4","type":"EventReceiver","w":"22","x":"1","y":"-35"}]%>
<%/*Description: */%>
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
window.spadministration_ssomap_Static=function(){
if(typeof RefreshGrid !='undefined')this.RefreshGrid=RefreshGrid;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj_ssomap.addRowConsumer(this.ssomap_list);

m_cProgName="spadministration_ssomap_list";
function RefreshGrid(){
  this.ssomap_list.Refresh();
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
.spadministration_ssomap_container {
}
.spadministration_ssomap_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:140px;
  background-color:transparent;
}
.spadministration_ssomap_portlet[Data-page="1"]{
  height:140px;
  width:100%;
}
.spadministration_ssomap_portlet > .ssomap_list_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:1px;
  width:auto;
  height:auto;
  min-height:139px;
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
 String def="[{\"h\":\"140\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"38\",\"y\":\"-38\"},{\"anchor\":\"top-left-right\",\"h\":\"139\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"399\",\"x\":\"0\",\"y\":\"0\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"80\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"1\",\"y\":\"-35\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_ssomap","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_ssomap_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_ssomap','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_ssomap_firstinclusion")==null){
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
<div id='<%=idPortlet%>_container' class='spadministration_ssomap_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_ssomap_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_ssomap','<%=idPortlet%>',false,' ');
</script><%}}%>
<div id='<%=idPortlet%>_ssomap_list' formid='<%=idPortlet%>' ps-name='ssomap_list'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_ssomap');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_ssomap',["400"],["140"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"140","title":" ","layer":"false","npage":"1"}]);
this.dataobj_ssomap=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_view_ssomap","cmdHash":"<%=JSPLib.cmdHash("spquery_view_ssomap",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_ssomap","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_ssomap","nrows":"30","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":38,"y":-38});
this.ssomap_list=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":" ","cellpadding":3,"cellspacing":0,"checkbox":"false","checkbox_fields":" ","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_ssomap_list","dataobj":"dataobj_ssomap","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":139,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":"true","keepMemCurs":" ","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":" ","name":"ssomap_list","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"true","render_totals":" ","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"true-by-example","shrinkable":"false","splinker":"manage_ssomap","splinker_pos":"left","title_color":"","type":"Grid","valign":"top","w":399,"x":0,"y":0});
this.ssomap_list.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":30,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("SSOID"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"ssoid","fg_color":"","width":"","alias":"SSOID","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("UserID"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"userid","fg_color":"","width":"","alias":"UserID","RowSpan":0,"extensible":false}]});
this.manage_ssomap=new ZtVWeb.SPLinkerCtrl(this,{"action":" ","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_manage_ssomap","decrypted_parms":"","entity_type":" ","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"manage_ssomap","offline":false,"page":1,"parms":"ssoid","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":" ","popup_width":"400","progressbar":false,"refresh":"false","servlet":"SPManageSSOMap","target":" ","type":"SPLinker","w":30,"x":80,"y":-38});
this.manage_ssomap.m_cID='<%=JSPLib.cmdHash("entity,SPManageSSOMap",request.getSession())%>';
this.SPManageSSOMap_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":" ","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageSSOMap_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageSSOMap_savedEntity","objsValues":"this.RefreshGrid()","page":1,"parmsNames":" ","type":"EventReceiver","w":22,"x":1,"y":-35});
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
<%if(request.getAttribute("spadministration_ssomap_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("spadministration_ssomap_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.spadministration_ssomap_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_SPManageSSOMap_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageSSOMap_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.dataobj_ssomap.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_ssomap',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_ssomap');
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
sp.endPage("spadministration_ssomap");
}%>
<%! public String getJSPUID() { return "418643151"; } %>