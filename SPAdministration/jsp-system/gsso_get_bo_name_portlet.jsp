<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var FilesList\nfunction this_Loaded(){\n  this.Grid.LinkValueUid = this.UID.Value();\n  this.Grid.LinkValueField = this.LinkedField.Value();\n  this.Grid.LinkFillEmptyKey = this.FillEmptyKey.Value();\n  this.Grid.LinkPKFields = this.PKFields.Value();\n  var result = new JSURL(\"..\u002fservlet\u002fSPXDCProxy?action=procedures_and_tables\").Response();\n  FilesList = JSON.parse(result, true);\n  this.dataobj.FillData(FilesList);\n}\n\nfunction SelectBOName(){\n  this.EventBoName.Emit();\n  window.close();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"block\",\"size\":\"\",\"weight\":\"normal\",\"align\":\"center\",\"code\":\"\"},\"hover\":{},\":before\":{\"display\":\"inline-block\",\"content\":\"\\\\ec69\",\"size\":\"20px\",\"weight\":\"normal\",\"font_color\":\"rgba(0, 0, 0, 0.93)\",\"code\":\"font-family: icons8_win10;\"},\":after\":{}},\"current_state\":\":before\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_report_link\",\"selector\":\".grid_report_link\",\"id\":\"form\",\"code\":\".grid_report_link {\\n  display: block;\\n  font-weight: normal;\\n  text-align: center;\\n}\\n\\n.grid_report_link::before {\\n  display: inline-block;\\n  font-family: icons8_win10;\\n  color: rgba(0, 0, 0, 0.93);\\n  font-weight: normal;\\n  font-size: 20px;\\n  content: '\\\\ec69';\\n}\\n\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Grid }}\u003c\u002fbody\u003e","grapesCss":"","h":"300","hsl":"","htmlcode":"{{ @Grid }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"300\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"alias":"boname,comment,module,type,table,table_m","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,C,C,C,C","h":"22","man_query":"","name":"dataobj","page":"1","parms":"","parms_source":"","sequence":"1","type":"StaticDataProvider","w":"120","x":"435","y":"145"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fvisualweb\u002fimages\u002fgrid_report_link.png\\\")%\u003e\",\"align\":\"\",\"link\":\"\",\"width\":\"5%\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"grid_report_link\\\"\u003e\u003c\u002fspan\u003e\",\"title\":\"\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:SelectBOName()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"5%\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_BONAME\",\"align\":\"left\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"boname\",\"maxwidth\":\"\",\"title\":\"ADMIN_BONAME\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_weight\":\"normal\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_BO_DESCRIPTION\",\"align\":\"left\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"comment\",\"maxwidth\":\"\",\"title\":\"ADMIN_BO_DESCRIPTION\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_weight\":\"normal\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"dataobj","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":",C,C","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"300","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid","nav_bar":"true","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"false","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":"","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"PKFields","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"435","y":"99"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"UID","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"435","y":"30"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"FillEmptyKey","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"435","y":"53"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"22","init":"","init_par":"request","name":"LinkedField","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"435","y":"76"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"22","name":"EventBoName","page":"1","parmsNames":"boname","parmsTypes":"var","parmsValues":"boname","persistent":"true","sequence":"6","type":"EventEmitter","w":"120","x":"435","y":"168"},{"calculate":"","ctrlOfVariant":"","dataobj":"dataobj","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"boname","h":"22","init":"","init_par":"","name":"boname","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"435","y":"122"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:PKFields,UID,FillEmptyKey,LinkedField*/%>
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
window.gsso_get_bo_name_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof SelectBOName !='undefined')this.SelectBOName=SelectBOName;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj.addRowConsumer(this.Grid);
this.dataobj.addDataConsumer(this.boname,<%=JSPLib.ToJSValue("boname",true)%>);
var FilesList
function this_Loaded(){
  this.Grid.LinkValueUid = this.UID.Value();
  this.Grid.LinkValueField = this.LinkedField.Value();
  this.Grid.LinkFillEmptyKey = this.FillEmptyKey.Value();
  this.Grid.LinkPKFields = this.PKFields.Value();
  var result = new JSURL("../servlet/SPXDCProxy?action=procedures_and_tables").Response();
  FilesList = JSON.parse(result, true);
  this.dataobj.FillData(FilesList);
}
function SelectBOName(){
  this.EventBoName.Emit();
  window.close();
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
.gsso_get_bo_name_container .grid_report_link{  display: block;
  font-weight: normal;
  text-align: center;
}
.gsso_get_bo_name_container .grid_report_link::before{
  display: inline-block;
  font-family: icons8_win10;
  color: rgba(0, 0, 0, 0.93);
  font-weight: normal;
  font-size: 20px;
  content: '\ec69';
}
.gsso_get_bo_name_container {
}
.gsso_get_bo_name_title_container {
  margin: auto;
}
.gsso_get_bo_name_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:400px;
  height:300px;
  background-color:#FFFFFF;
}
.gsso_get_bo_name_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.gsso_get_bo_name_portlet > .Grid_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:300px;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"435\",\"y\":\"145\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"ADMIN_BONAME\"},{\"title\":\"ADMIN_BO_DESCRIPTION\"}],\"h\":\"300\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"99\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"30\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"53\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"76\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"120\",\"x\":\"435\",\"y\":\"168\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"435\",\"y\":\"122\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"gsso_get_bo_name","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/gsso_get_bo_name_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','gsso_get_bo_name','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("gsso_get_bo_name_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
if(request.getAttribute("gsso_get_bo_name_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String PKFields=JSPLib.translateXSS(sp.getParameter("PKFields",""));
String UID=JSPLib.translateXSS(sp.getParameter("UID",""));
boolean FillEmptyKey=sp.getParameter("FillEmptyKey",false);
String LinkedField=JSPLib.translateXSS(sp.getParameter("LinkedField",""));
String boname= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='gsso_get_bo_name_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='gsso_get_bo_name_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('gsso_get_bo_name','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid' formid='<%=idPortlet%>' ps-name='Grid'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','gsso_get_bo_name');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','gsso_get_bo_name',["400"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"300","title":"","layer":""}]);
this.dataobj=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_dataobj","dataproviders":"","fieldsString":"boname,comment,module,type,table,table_m","fieldstypeString":"C,C,C,C,C,C","h":22,"hide":"false","layer":false,"layout_steps_values":{},"name":"dataobj","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":120,"x":435,"y":145});
this.Grid=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid","dataobj":"dataobj","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":300,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":false,\"addremove\":false,\"lastpage\":true,\"firstlast\":false}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":400,"x":0,"y":0,"zindex":""});
this.Grid.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"5%","align":"","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"image:<%=sp.getThemedImage("../visualweb/images/grid_report_link.png")%>","extensible":false,"title_align":"","enable_HTML":false,"onclick":"function:SelectBOName()","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"grid_report_link\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"5%","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"normal","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"left","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_BONAME"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"boname","fg_color":"","width":"","alias":"ADMIN_BONAME","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"normal","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"left","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_BO_DESCRIPTION"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"comment","fg_color":"","width":"","alias":"ADMIN_BO_DESCRIPTION","RowSpan":0,"extensible":false}]});
this.PKFields=new ZtVWeb._VC(this,'PKFields',null,'character','<%=JSPLib.ToJSValue(PKFields,false,true)%>',false,false);
this.UID=new ZtVWeb._VC(this,'UID',null,'character','<%=JSPLib.ToJSValue(UID,false,true)%>',false,false);
this.FillEmptyKey=new ZtVWeb._VC(this,'FillEmptyKey',null,'logic',<%=FillEmptyKey%>,false,false);
this.LinkedField=new ZtVWeb._VC(this,'LinkedField',null,'character','<%=JSPLib.ToJSValue(LinkedField,false,true)%>',false,false);
this.EventBoName=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_EventBoName","eventsNames":"","eventsObjs":"","h":22,"hide":"false","layer":false,"layout_steps_values":{},"name":"EventBoName","page":1,"parmsNames":"boname","parmsTypes":"var","parmsValues":"boname","persistent":"true","type":"EventEmitter","w":120,"x":435,"y":168});
this.boname=new ZtVWeb._VC(this,'boname',null,'character','<%=JSPLib.ToJSValue(boname,false,true)%>',false,false);
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
<%if(request.getAttribute("gsso_get_bo_name_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("gsso_get_bo_name_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.gsso_get_bo_name_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.EventBoName.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','gsso_get_bo_name',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'gsso_get_bo_name');
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
sp.endPage("gsso_get_bo_name");
}%>
<%! public String getJSPUID() { return "1031096031"; } %>