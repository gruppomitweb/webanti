<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u002f\u002f this.Grid0.SetSPLinkerActions('-d-e-n')\n\nfunction this_Loaded(){\n  ((Empty(this.w_rapporto.Value())))?this.w_falso.Value(0):this.w_falso.Value(1);\n  this.Query1.Query()\n}\n\nfunction ColoraRiga(_stato) {\n  switch (_stato) {\n    case '2':\n      _colore='#FF0000';\n      break;\n    case '3':  \n      _colore='#FFFF99'\n      break;\n    default:\n      _colore=''\n  }    \n  return _colore;\n}\n\nfunction Aggiorna(_evt) {\n  this.Query1.Query()\n  this.Grid0.Refresh()\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"120","hsl":"","htmlcode":"{{ armt_operazioni_deletedEntity }}\n{{ Query1 }}\n{{ Grid0 }}\n{{ w_rapporto }}{{ w_rapporto }}\n{{ operazbo_edt }}\n{{ label2 }}\n{{ operazbo_del }}\n{{ operazbo_view }}\n{{ w_falso }}{{ armt_operazioni_savedEntity }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"attribute","name":"w_rapporto","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"198","x":"427","y":"5"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"5","name":"Query1","offline":"false","page":"1","parms":"w_rapporto=w_rapporto,w_falso=w_falso","parms_source":"","query":"qbe_operazrappo","query_async":"true","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"198","x":"427","y":"49"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"w_falso","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"numeric","w":"198","x":"427","y":"27"},{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"N° Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"NUMPROG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data registrazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"DATAREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Valuta\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"VALUTA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Causale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"CODANA+\\\" \\\"+CODVOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"C\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,D,,C,,N","filters":"false","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"100","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"5","scroll_bars":"false","sequence":"4","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"operazbo_view","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"20","zindex":""},{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","bg_color":"#829BC6","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"OPERAZIONI (A.U.I.)","w":"400","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1"},{"allowedentities":"armt_operazioni","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"edit","name":"operazbo_edt","offline":"false","page":"1","parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":"","refresh":"false","sequence":"7","servlet":"armt_operazioni","target":"","type":"SPLinker","w":"198","x":"427","y":"93"},{"allowedentities":"armt_operazioni","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"","name":"operazbo_view","offline":"false","page":"1","parms":"IDBASE=IDBASE,RAPPORTO=w_rapporto","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":"","refresh":"false","sequence":"7","servlet":"armt_operazioni","target":"","type":"SPLinker","w":"198","x":"427","y":"71"},{"allowedentities":"armt_operazioni","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"delete","name":"operazbo_del","offline":"false","page":"1","parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":"","refresh":"false","sequence":"9","servlet":"armt_operazioni","target":"","type":"SPLinker","w":"198","x":"427","y":"115"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_operazioni_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"10","type":"EventReceiver","w":"198","x":"427","y":"136"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_operazioni_deletedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"10","type":"EventReceiver","w":"198","x":"427","y":"157"}]%>
<%/*Description:*/%>
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
window.pg_operazbo_rap_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof ColoraRiga !='undefined')this.ColoraRiga=ColoraRiga;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
// this.Grid0.SetSPLinkerActions('-d-e-n')
function this_Loaded(){
  ((Empty(this.w_rapporto.Value())))?this.w_falso.Value(0):this.w_falso.Value(1);
  this.Query1.Query()
}
function ColoraRiga(_stato) {
  switch (_stato) {
    case '2':
      _colore='#FF0000';
      break;
    case '3':  
      _colore='#FFFF99'
      break;
    default:
      _colore=''
  }    
  return _colore;
}
function Aggiorna(_evt) {
  this.Query1.Query()
  this.Grid0.Refresh()
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
.pg_operazbo_rap_container {
}
.pg_operazbo_rap_title_container {
  margin: auto;
}
.pg_operazbo_rap_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:400px;
  height:120px;
}
.pg_operazbo_rap_portlet[Data-page="1"]{
  height:120px;
  width:100%;
}
.pg_operazbo_rap_portlet > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:100px;
}
.pg_operazbo_rap_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_operazbo_rap_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_operazbo_rap_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
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
 String def="[{\"h\":\"120\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"198\",\"x\":\"427\",\"y\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"198\",\"x\":\"427\",\"y\":\"49\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"198\",\"x\":\"427\",\"y\":\"27\"},{\"anchor\":\"top-left(%)-right(%)\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"N° Progressivo\"},{\"title\":\"Data Operazione\"},{\"title\":\"Data registrazione\"},{\"title\":\"Valuta\"},{\"title\":\"Causale\"},{\"title\":\"Totale Operazione\"}],\"h\":\"100\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"5\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"\"},{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"OPERAZIONI (A.U.I.)\",\"w\":\"400\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"198\",\"x\":\"427\",\"y\":\"93\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"198\",\"x\":\"427\",\"y\":\"71\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"198\",\"x\":\"427\",\"y\":\"115\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"198\",\"x\":\"427\",\"y\":\"136\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"198\",\"x\":\"427\",\"y\":\"157\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_operazbo_rap","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_operazbo_rap_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_operazbo_rap','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String w_rapporto=JSPLib.translateXSS(Library.getAttribute(request,"w_rapporto",""));
double w_falso= 0;
if(request.getAttribute("pg_operazbo_rap_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String label2= "OPERAZIONI (A.U.I.)";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_operazbo_rap_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_operazbo_rap_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_operazbo_rap','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("OPERAZIONI (A.U.I.)")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_operazbo_rap');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_operazbo_rap',["400"],["120"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"120","title":"","layer":"false","npage":"1"}]);
this.w_rapporto=new ZtVWeb._VC(this,'w_rapporto',null,'character','<%=JSPLib.ToJSValue(w_rapporto,false,true)%>',false,false);
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"qbe_operazrappo","cmdHash":"<%=JSPLib.cmdHash("qbe_operazrappo",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"5","page":1,"parms":"w_rapporto=w_rapporto,w_falso=w_falso","parms_source":"","type":"SQLDataobj","w":198,"x":427,"y":49});
this.w_falso=new ZtVWeb._VC(this,'w_falso',null,'numeric',<%=w_falso%>,false,false);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":100,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"operazbo_view","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":400,"x":0,"y":20,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"N° Progressivo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATOREG%')","newline":false,"field":"NUMPROG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATOREG%')","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data registrazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATOREG%')","newline":false,"field":"DATAREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Valuta","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATOREG%')","newline":false,"field":"VALUTA","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Causale","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"function:ColoraRiga('%STATOREG%')","newline":false,"field":"CODANA+\" \"+CODVOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"C","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"function:ColoraRiga('%STATOREG%')","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":400,"x":0,"y":0,"zindex":"1"});
this.operazbo_edt=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"<%=JSPLib.encrypt("armt_operazioni",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_operazbo_edt","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"operazbo_edt","offline":false,"page":1,"parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_operazioni","target":"","type":"SPLinker","w":198,"x":427,"y":93});
this.operazbo_edt.m_cID='<%=JSPLib.cmdHash("entity,armt_operazioni",request.getSession())%>';
this.operazbo_view=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("armt_operazioni",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_operazbo_view","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"operazbo_view","offline":false,"page":1,"parms":"IDBASE=IDBASE,RAPPORTO=w_rapporto","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_operazioni","target":"","type":"SPLinker","w":198,"x":427,"y":71});
this.operazbo_view.m_cID='<%=JSPLib.cmdHash("entity,armt_operazioni",request.getSession())%>';
this.operazbo_del=new ZtVWeb.SPLinkerCtrl(this,{"action":"delete","allowedEntities":"<%=JSPLib.encrypt("armt_operazioni",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_operazbo_del","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"operazbo_del","offline":false,"page":1,"parms":"IDBASE","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_operazioni","target":"","type":"SPLinker","w":198,"x":427,"y":115});
this.operazbo_del.m_cID='<%=JSPLib.cmdHash("entity,armt_operazioni",request.getSession())%>';
this.armt_operazioni_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_operazioni_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_operazioni_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":198,"x":427,"y":136});
this.armt_operazioni_deletedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_operazioni_deletedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_operazioni_deletedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":198,"x":427,"y":157});
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
<%if(request.getAttribute("pg_operazbo_rap_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_operazbo_rap_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_operazbo_rap_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_armt_operazioni_savedEntity=function(parmsObj){<%=idPortlet%>.armt_operazioni_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_operazioni_deletedEntity=function(parmsObj){<%=idPortlet%>.armt_operazioni_deletedEntity.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_operazbo_rap',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_operazbo_rap');
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
sp.endPage("pg_operazbo_rap");
}%>
<%! public String getJSPUID() { return "3751745666"; } %>