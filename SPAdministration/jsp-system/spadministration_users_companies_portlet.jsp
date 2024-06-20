<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var l_status = window.EntityStatus();\nfunction RecordLoaded(){\n\tthis.fillCompanies();\n  this.UpdateComboDefaultCompany();\n  this.dbAzi.Query(true);\n  if (l_status == 'Q' || l_status == 'V') {\n    this.cmbDefaultCompany.Disabled();\n  }\n}\nfunction Calculate(visible) {\n  if (visible) {\n    this.fillCompanies();\n    this.UpdateComboDefaultCompany();\n    this.gridAzi.Refresh(true);\n  }\n}\nvar l_companies = [];\nvar local_initMemCurs = this.gridAzi._initMemCurs;\nthis.gridAzi._initMemCurs = function () {\n  local_initMemCurs.call(this);\n  for (var i = 0; i\u003cl_companies.length; i++) {\n    this.mem_curs.AppendBlank();\n    this.mem_curs.set('codazi', l_companies[i]);\n    this.mem_curs.set('ps_rowstatus', 'S');\n  }\n}\nvar local_isDisabled = this.gridAzi.isDisabled;\nthis.gridAzi.isDisabled = function (recIdx, cond) {\n  if (l_status == 'Q' || l_status == 'V') {\n    return true;\n  } else {\n    return local_isDisabled.call(this,recIdx,cond);\n  }\n}\nfunction fillCompanies(){\n  if(Empty(w_companies)){\n    l_companies = [];\n    this.cmbDefaultCompany.FillDataStatic('','');\n  } else {\n    l_companies = w_companies.trim().split(\u002f\\s*,\\s*\u002f);\n  }\n}\nfunction UpdateComboDefaultCompany() {\n  this.cmbDefaultCompany.FillDataStatic(l_companies.toString(),l_companies.toString());\n\tif (l_companies.length\u003e0) {\n\t\tthis.cmbDefaultCompany.Init(l_companies[0]);\n  }\n}\nfunction gridAzi_SelectionChange(state){\n  if (state) {\n  \tl_companies.push(LRTrim(this.dbAzi.rs.codazi));\n  } else {\n    var index = l_companies.indexOf(LRTrim(this.dbAzi.rs.codazi));\n    if ( index\u003e-1 ) {\n      l_companies.splice(index,1);\n    }\n  }\n  this.UpdateComboDefaultCompany();\n  Set_companies(l_companies.toString());\n}\n\nfunction cmbDefaultCompany_onChange(){\n  var defCmp = this.cmbDefaultCompany.Value();\n  var index = l_companies.indexOf(defCmp);\n  if (index\u003e-1 ) {\n    l_companies.splice(index,1);\n  }\n  l_companies.unshift(defCmp);\n  Set_companies(l_companies.toString());\n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Seleziono le aziede su cui l'utente ? abilitato.","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","grapesCode":"{{ @lblDefaultCompany }}{{ @cmbDefaultCompany }}{{ @gridAzi }}","grapesCss":"","h":"200","hsl":"","htmlcode":"{{ @lblDefaultCompany }}\n{{ @cmbDefaultCompany }}\n{{ @gridAzi }}\n{{ gridAzi }}\n{{ dbAzi }}\n{{ pCompanies }}\n{{ spl_azi }}\n{{ initCompanies }}\n{{ spadministration_users_Record_Loaded }}\n{{ cmbDefaultCompany }}{{ SQLDataobj7 }}{{ dataOut }}{{ lblDefaultCompany }}{{ pCompanies }}","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"pagelet","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"570","version":"37","w":"100%","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"30","localDBName":"","n_records":"5","name":"dbAzi","offline":"false","page":"1","parms":"","parms_source":"","query":"spquery_user_companies","query_async":"true","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"30","x":"581","y":"36"},{"actObjs":"","actTypes":"func","broadcast":"internal","h":"20","included":"false","name":"spadministration_users_Record_Loaded","objsValues":"this.RecordLoaded()","page":"1","parmsNames":"","sequence":"1","type":"EventReceiver","w":"22","x":"581","y":"72"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"SPLabel","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDefaultCompany","nowrap":"true","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ADMIN_DEFAULT_COMPANY","w":"180","wireframe_props":"align,value,n_col","x":"0","y":"2","zindex":"3","zone":""},{"anchor":"","calculate":"","class_Css":"Combobox","create_undercond":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"cmbDefaultCompany","page":"1","picture":"","sequence":"3","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":"true","w":"162","wireframe_props":"name,textlist","x":"190","y":"2","zindex":"2","zone":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"0","cellspacing":"0","checkbox":"true","checkbox_fields":"codazi","colProperties":"[{\"field\":\"codazi\",\"title\":\"\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"desazi\",\"align\":\"left\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"desazi\",\"maxwidth\":\"\",\"title\":\"\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_weight\":\"normal\",\"font_family\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"picture\":\"\",\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dbAzi","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"C","filters":"false","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"170","hide":"false","hide_default_titles":"","hide_empty_lines":"true","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"gridAzi","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"dataOut","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"5","scroll_bars":"infinite_scroll","sequence":"4","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":"570","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"30","zindex":"","zone":""}]%>
<%/*Description:Seleziono le aziede su cui l'utente ? abilitato.*/%>
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
window.spadministration_users_companies_Static=function(){
if(typeof RecordLoaded !='undefined')this.RecordLoaded=RecordLoaded;
if(typeof Calculate !='undefined')this.Calculate=Calculate;
if(typeof fillCompanies !='undefined')this.fillCompanies=fillCompanies;
if(typeof UpdateComboDefaultCompany !='undefined')this.UpdateComboDefaultCompany=UpdateComboDefaultCompany;
if(typeof gridAzi_SelectionChange !='undefined')this.gridAzi_SelectionChange=gridAzi_SelectionChange;
if(typeof cmbDefaultCompany_onChange !='undefined')this.cmbDefaultCompany_onChange=cmbDefaultCompany_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dbAzi.addRowConsumer(this.gridAzi);
var l_status = window.EntityStatus();
function RecordLoaded(){
	this.fillCompanies();
  this.UpdateComboDefaultCompany();
  this.dbAzi.Query(true);
  if (l_status == 'Q' || l_status == 'V') {
    this.cmbDefaultCompany.Disabled();
  }
}
function Calculate(visible) {
  if (visible) {
    this.fillCompanies();
    this.UpdateComboDefaultCompany();
    this.gridAzi.Refresh(true);
  }
}
var l_companies = [];
var local_initMemCurs = this.gridAzi._initMemCurs;
this.gridAzi._initMemCurs = function () {
  local_initMemCurs.call(this);
  for (var i = 0; i<l_companies.length; i++) {
    this.mem_curs.AppendBlank();
    this.mem_curs.set('codazi', l_companies[i]);
    this.mem_curs.set('ps_rowstatus', 'S');
  }
}
var local_isDisabled = this.gridAzi.isDisabled;
this.gridAzi.isDisabled = function (recIdx, cond) {
  if (l_status == 'Q' || l_status == 'V') {
    return true;
  } else {
    return local_isDisabled.call(this,recIdx,cond);
  }
}
function fillCompanies(){
  if(Empty(w_companies)){
    l_companies = [];
    this.cmbDefaultCompany.FillDataStatic('','');
  } else {
    l_companies = w_companies.trim().split(/\s*,\s*/);
  }
}
function UpdateComboDefaultCompany() {
  this.cmbDefaultCompany.FillDataStatic(l_companies.toString(),l_companies.toString());
	if (l_companies.length>0) {
		this.cmbDefaultCompany.Init(l_companies[0]);
  }
}
function gridAzi_SelectionChange(state){
  if (state) {
  	l_companies.push(LRTrim(this.dbAzi.rs.codazi));
  } else {
    var index = l_companies.indexOf(LRTrim(this.dbAzi.rs.codazi));
    if ( index>-1 ) {
      l_companies.splice(index,1);
    }
  }
  this.UpdateComboDefaultCompany();
  Set_companies(l_companies.toString());
}
function cmbDefaultCompany_onChange(){
  var defCmp = this.cmbDefaultCompany.Value();
  var index = l_companies.indexOf(defCmp);
  if (index>-1 ) {
    l_companies.splice(index,1);
  }
  l_companies.unshift(defCmp);
  Set_companies(l_companies.toString());
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
.spadministration_users_companies_container {
}
.spadministration_users_companies_portlet{
  position:relative;
  width:100%;
  min-width:570px;
  height:200px;
  background-color:transparent;
}
.spadministration_users_companies_portlet[Data-page="1"]{
  height:200px;
  width:100%;
}
.spadministration_users_companies_portlet > .lblDefaultCompany_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:2px;
  left:0px;
  width:180px;
  height:auto;
  min-height:20px;
}
.spadministration_users_companies_portlet > .lblDefaultCompany_ctrl {
  height:auto;
  min-height:20px;
}
.spadministration_users_companies_portlet > .lblDefaultCompany_ctrl {
  overflow:hidden;
  white-space:nowrap;
  text-overflow:ellipsis;
  text-align:right;
}
.spadministration_users_companies_portlet > .cmbDefaultCompany_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:2px;
  left:190px;
  width:162px;
  height:25px;
}
.spadministration_users_companies_portlet > .gridAzi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:30px;
  left:0px;
  right:0px;
  width:auto;
  height:170px;
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
 String def="[{\"h\":\"200\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"570\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"581\",\"y\":\"36\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"581\",\"y\":\"72\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_DEFAULT_COMPANY\",\"w\":\"180\",\"x\":\"0\",\"y\":\"2\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"cmbDefaultCompany\",\"page\":\"1\",\"textlist\":\"\",\"type\":\"Combobox\",\"w\":\"162\",\"x\":\"190\",\"y\":\"2\",\"zindex\":\"2\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"true\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"\"}],\"h\":\"170\",\"layout_steps_values\":{},\"name\":\"gridAzi\",\"page\":\"1\",\"rows\":\"5\",\"type\":\"Grid\",\"w\":\"570\",\"x\":\"0\",\"y\":\"30\",\"zindex\":\"\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_users_companies","UTF-8")) {return; }
 %><%if(request.getAttribute("javax.servlet.include.request_uri")==null && request.getParameter("clientsideinclusion")==null){
response.setHeader("Cache-Control","max-age = 0");
response.setDateHeader("Expires",1);
pageContext.forward("notlogged.htm");
  if (true)  return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_users_companies_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_users_companies','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblDefaultCompany= "ADMIN_DEFAULT_COMPANY";
String cmbDefaultCompany= "";
if(request.getAttribute("spadministration_users_companies_firstinclusion")==null){
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
<div id='<%=idPortlet%>_container' class='spadministration_users_companies_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_users_companies_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_users_companies','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblDefaultCompany'  formid='<%=idPortlet%>' ps-name='lblDefaultCompany'    class='SPLabel lblDefaultCompany_ctrl'><div id='<%=idPortlet%>_lblDefaultCompanytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("ADMIN_DEFAULT_COMPANY"))%></div></span>
<select id='<%=idPortlet%>_cmbDefaultCompany' name='cmbDefaultCompany' class='Combobox' style=''></select>
<div id='<%=idPortlet%>_gridAzi' formid='<%=idPortlet%>' ps-name='gridAzi'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_users_companies');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_users_companies',["570"],["200"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"570","h":"200","title":"","layer":"false","npage":"1"}]);
this.dbAzi=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"spquery_user_companies","cmdHash":"<%=JSPLib.cmdHash("spquery_user_companies",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dbAzi","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dbAzi","nrows":"5","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":30,"x":581,"y":36});
this.spadministration_users_Record_Loaded=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"internal","ctrlid":"<%=idPortlet%>_spadministration_users_Record_Loaded","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"spadministration_users_Record_Loaded","objsValues":"this.RecordLoaded()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":581,"y":72});
this.lblDefaultCompany=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"SPLabel","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDefaultCompany","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDefaultCompany","nowrap":"true","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblDefaultCompany),false,true)%>","type":"Label","w":180,"x":0,"y":2,"zindex":"3"});
this.cmbDefaultCompany=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"Combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbDefaultCompany","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":25,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbDefaultCompany%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbDefaultCompany","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"","type":"Combobox","typevar":"character","valuelist":"","visible":true,"w":162,"x":190,"y":2,"zindex":"2"});
this.gridAzi=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":0,"cellspacing":0,"checkbox":"true","checkbox_fields":"codazi","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridAzi","dataobj":"dbAzi","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":170,"hide":"false","hide_empty_lines":"true","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"false","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"gridAzi","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":false,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"dataOut","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"infinite_scroll","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":570,"x":0,"y":30,"zindex":""});
this.gridAzi.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"codazi","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","font_weight":"normal","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"left","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"desazi","extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"desazi","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
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
<%if(request.getAttribute("spadministration_users_companies_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("spadministration_users_companies_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.spadministration_users_companies_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_spadministration_users_Record_Loaded=function(parmsObj){<%=idPortlet%>.spadministration_users_Record_Loaded.receiveFnc(parmsObj);}
window.<%=idPortlet%>.cmbDefaultCompany.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_users_companies',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_users_companies');
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
sp.endPage("spadministration_users_companies");
}%>
<%! public String getJSPUID() { return "3793154261"; } %>