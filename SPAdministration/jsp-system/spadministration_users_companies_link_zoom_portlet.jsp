<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u002f\u002f Variabile che mi determina se e' attivo il check \"seleziona tutti\"\nvar bAllChecked = false;\n\n\u002f\u002f Ridefinisco la funzione SetCheckBoxAll della grid\nthis.gridAzi.SetCheckBoxAll = function(checked){\n  bAllChecked = !bAllChecked;\n  var oGrid = this;\n  var nCurRec = oGrid.curRec;\n  for(var i=0; i \u003c oGrid.RowCount(); i++){\n    oGrid.curRec = i + 1;\n    var ctrl=document.getElementById(oGrid.ctrlid + '_checkbox_row_' + i);\n    ctrl.checked = bAllChecked;\n    oGrid.SetCheckBox(bAllChecked);\n  }\n  oGrid.curRec = nCurRec;\n}\n\n\u002f\u002fConferma\nfunction btnOk_Click(){\n  var aData=this.gridAzi.GetSelectedData().Data;\n  var sCompanies='';\n  for(var i=0;i\u003caData.length-1;i++){\n    sCompanies+=LRTrim(aData[i][0])+',';\n  }\n  \u002f\u002fElimino virgola in fondo\n  sCompanies=Substr(sCompanies,1,Len(sCompanies)-1);\n  \u002f\u002fSetto le companies nel profilo\n  GetOpener().Set_companies(sCompanies);\n\n  WindowClose();\n}\n\n\u002f\u002fAnnulla\nfunction btnCancel_Click(){\n  WindowClose();\n}\n\nfunction this_Loaded(){\n  \u002f\u002fEseguo la query\n  this.dbAzi.Query();\n\n  \u002f\u002fsetto companies\n  if(!Empty(this.UID.Value())){\n    this.pCompanies.Value(GetOpener().Ctrl(this.UID.Value()).value);\n  }\n\n  \u002f\u002fChecko le righe passate come parametro\n  if(!Empty(this.pCompanies.Value())){\n    var aCompanies=this.pCompanies.Value().split(',');\n    for(var i=0;i\u003caCompanies.length;i++){\n      this.dbAzi.curRec=1;\n      for(var j=0;j\u003cthis.dbAzi.GetQueryCount();j++){\n        if(LRTrim(this.dbAzi.rs.codazi)==LRTrim(aCompanies[i])){\n          this.gridAzi.CurrRow(j);\n          this.gridAzi.RowChecked(true);\n        }\n        this.dbAzi.Next();\n      }\n    }\n  }\n\n\tthis.spl_azi.Action('N');\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Seleziono le aziede su cui l'utente ? abilitato.","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"180","hsl":"","htmlcode":"{{ gridAzi }}\n{{ dbAzi }}\n{{ btnOk }}\n{{ pCompanies }}\n{{ btnCancel }}\n{{ UID }}\n{{ spl_azi }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"controls.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"administrator","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"0","cellspacing":"0","checkbox":"true-selectAll","checkbox_fields":"codazi","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Azienda\",\"align\":\"left\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"desazi\",\"maxwidth\":\"\",\"title\":\"Azienda\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"font_weight\":\"normal\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dbAzi","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"145","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"gridAzi","nav_bar":"true","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"100","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"spl_azi","splinker_pos":"right","title_color":"","type":"Grid","valign":"top","w":"399","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":""},{"appendingData":"false","auto_exec":"false","clientDB":"false","count":"true","h":"30","localDBName":"","n_records":"100","name":"dbAzi","offline":"false","page":"1","parms":"","parms_source":"","query":"spquery_user_companies","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"30","x":"418","y":"35"},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"24","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btnOk","page":"1","sequence":"3","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Ok","w":"55","wireframe_props":"value","x":"5","y":"148","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"request","layout_steps_values":"{}","maxlength":"","name":"pCompanies","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"146","wireframe_props":"name","x":"421","y":"-3","zerofilling":"false","zindex":"1"},{"anchor":"","bg_color":"","border_color":"","border_weight":"0","class_Css":"button","create_undercond":"","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":"24","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btnCancel","page":"1","sequence":"5","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Annulla","w":"55","wireframe_props":"value","x":"63","y":"148","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"UID","page":"1","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"421","y":"-31"},{"async":"false","entity_type":"master","h":"30","m_cAction":"","name":"spl_azi","offline":"false","page":"1","parms":"codazi","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"400","progressbar":"","refresh":"true","sequence":"7","servlet":"SPManageCompanies","target":"","type":"SPLinker","w":"30","x":"0","y":"-37"}]%>
<%/*Description:Seleziono le aziede su cui l'utente ? abilitato.*/%>
<%/*ParamsRequest:pCompanies,UID*/%>
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
window.spadministration_users_companies_link_zoom_Static=function(){
if(typeof btnOk_Click !='undefined')this.btnOk_Click=btnOk_Click;
if(typeof btnCancel_Click !='undefined')this.btnCancel_Click=btnCancel_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dbAzi.addRowConsumer(this.gridAzi);
// Variabile che mi determina se e' attivo il check "seleziona tutti"
var bAllChecked = false;
// Ridefinisco la funzione SetCheckBoxAll della grid
this.gridAzi.SetCheckBoxAll = function(checked){
  bAllChecked = !bAllChecked;
  var oGrid = this;
  var nCurRec = oGrid.curRec;
  for(var i=0; i < oGrid.RowCount(); i++){
    oGrid.curRec = i + 1;
    var ctrl=document.getElementById(oGrid.ctrlid + '_checkbox_row_' + i);
    ctrl.checked = bAllChecked;
    oGrid.SetCheckBox(bAllChecked);
  }
  oGrid.curRec = nCurRec;
}
//Conferma
function btnOk_Click(){
  var aData=this.gridAzi.GetSelectedData().Data;
  var sCompanies='';
  for(var i=0;i<aData.length-1;i++){
    sCompanies+=LRTrim(aData[i][0])+',';
  }
  //Elimino virgola in fondo
  sCompanies=Substr(sCompanies,1,Len(sCompanies)-1);
  //Setto le companies nel profilo
  GetOpener().Set_companies(sCompanies);
  WindowClose();
}
//Annulla
function btnCancel_Click(){
  WindowClose();
}
function this_Loaded(){
  //Eseguo la query
  this.dbAzi.Query();
  //setto companies
  if(!Empty(this.UID.Value())){
    this.pCompanies.Value(GetOpener().Ctrl(this.UID.Value()).value);
  }
  //Checko le righe passate come parametro
  if(!Empty(this.pCompanies.Value())){
    var aCompanies=this.pCompanies.Value().split(',');
    for(var i=0;i<aCompanies.length;i++){
      this.dbAzi.curRec=1;
      for(var j=0;j<this.dbAzi.GetQueryCount();j++){
        if(LRTrim(this.dbAzi.rs.codazi)==LRTrim(aCompanies[i])){
          this.gridAzi.CurrRow(j);
          this.gridAzi.RowChecked(true);
        }
        this.dbAzi.Next();
      }
    }
  }
	this.spl_azi.Action('N');
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
.spadministration_users_companies_link_zoom_container {
}
.spadministration_users_companies_link_zoom_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:180px;
  background-color:transparent;
}
.spadministration_users_companies_link_zoom_portlet[Data-page="1"]{
  height:180px;
  width:100%;
}
.spadministration_users_companies_link_zoom_portlet > .gridAzi_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:1px;
  width:auto;
  height:auto;
  min-height:145px;
}
.spadministration_users_companies_link_zoom_portlet > .btnOk_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:148px;
  left:5px;
  width:55px;
  height:24px;
}
.spadministration_users_companies_link_zoom_portlet > .btnOk_ctrl {
  border-width:0px;
}
.spadministration_users_companies_link_zoom_portlet > .pCompanies_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.spadministration_users_companies_link_zoom_portlet > .pCompanies_ctrl {
  display:none;
}
.spadministration_users_companies_link_zoom_portlet > .pCompanies_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.spadministration_users_companies_link_zoom_portlet > .btnCancel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:148px;
  left:63px;
  width:55px;
  height:24px;
}
.spadministration_users_companies_link_zoom_portlet > .btnCancel_ctrl {
  font-family:Verdana;
  border-width:0px;
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
 String def="[{\"h\":\"180\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"true-selectAll\",\"colProperties\":[{\"title\":\"Azienda\"}],\"h\":\"145\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"100\",\"type\":\"Grid\",\"w\":\"399\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"418\",\"y\":\"35\"},{\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"Ok\",\"w\":\"55\",\"x\":\"5\",\"y\":\"148\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"pCompanies\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"146\",\"x\":\"421\",\"y\":\"-3\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"24\",\"layout_steps_values\":{},\"name\":\"btnCancel\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Annulla\",\"w\":\"55\",\"x\":\"63\",\"y\":\"148\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"UID\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"421\",\"y\":\"-31\"},{\"h\":\"30\",\"name\":\"spl_azi\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"0\",\"y\":\"-37\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_users_companies_link_zoom","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_users_companies_link_zoom_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_users_companies_link_zoom','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_users_companies_link_zoom_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String pCompanies=JSPLib.translateXSS(sp.getParameter("pCompanies",""));
if(request.getAttribute("spadministration_users_companies_link_zoom_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String UID=JSPLib.translateXSS(sp.getParameter("UID",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spadministration_users_companies_link_zoom_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_users_companies_link_zoom_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_users_companies_link_zoom','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_gridAzi' formid='<%=idPortlet%>' ps-name='gridAzi'   class='grid' style=''>&nbsp;</div>
<input id='<%=idPortlet%>_btnOk' type='button' class='button btnOk_ctrl'/>
<span class='textbox-container'id='<%=idPortlet%>_pCompanies_wrp'><input id='<%=idPortlet%>_pCompanies' name='pCompanies' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='pCompanies' /></span>
<input id='<%=idPortlet%>_btnCancel' type='button' class='button btnCancel_ctrl'/>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_users_companies_link_zoom');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_users_companies_link_zoom',["400"],["180"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"180","title":"","layer":"false","npage":"1"}]);
this.gridAzi=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":0,"cellspacing":0,"checkbox":"true-selectAll","checkbox_fields":"codazi","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_gridAzi","dataobj":"dbAzi","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":145,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"gridAzi","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"spl_azi","splinker_pos":"right","title_color":"","type":"Grid","valign":"top","w":399,"x":0,"y":0,"zindex":""});
this.gridAzi.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":100,"colProperties":[{"disable_fields_conditions":"","font_weight":"normal","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"weight":"","align":"left","type":"C","title":"Azienda","layer":"","ColSpan":0,"bg_color":"","newline":false,"field":"desazi","fg_color":"","width":"","alias":"Azienda","RowSpan":0,"extensible":false}]});
this.dbAzi=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"spquery_user_companies","cmdHash":"<%=JSPLib.cmdHash("spquery_user_companies",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dbAzi","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dbAzi","nrows":"100","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":30,"x":418,"y":35});
this.btnOk=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"button btnOk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnOk","edit_undercond":"","font":"","font_color":"","font_size":"","h":24,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnOk","page":1,"tabindex":"","text":"Ok","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":5,"y":148,"zindex":"1"});
this.pCompanies=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_pCompanies","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"pCompanies","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(pCompanies,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.btnCancel=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"","border_color":"","border_weight":"0","class_Css":"button btnCancel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCancel","edit_undercond":"","font":"Verdana","font_color":"","font_size":"","h":24,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnCancel","page":1,"tabindex":"","text":"Annulla","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":63,"y":148,"zindex":"1"});
this.UID=new ZtVWeb._VC(this,'UID',null,'character','<%=JSPLib.ToJSValue(UID,false,true)%>',false,false);
this.spl_azi=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_spl_azi","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"spl_azi","offline":false,"page":1,"parms":"codazi","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"400","progressbar":false,"refresh":"true","servlet":"SPManageCompanies","target":"","type":"SPLinker","w":30,"x":0,"y":-37});
this.spl_azi.m_cID='<%=JSPLib.cmdHash("entity,SPManageCompanies",request.getSession())%>';
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
<%if(request.getAttribute("spadministration_users_companies_link_zoom_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("spadministration_users_companies_link_zoom_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.spadministration_users_companies_link_zoom_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_users_companies_link_zoom',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_users_companies_link_zoom');
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
sp.endPage("spadministration_users_companies_link_zoom");
}%>
<%! public String getJSPUID() { return "671653949"; } %>