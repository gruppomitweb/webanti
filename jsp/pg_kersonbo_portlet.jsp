<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.Grid0.SetSPLinkerActions('-d-e-n')\n","bg_image":" ","cache_time":" ","color":"#C0C0C0","css":" ","css_class":"undefined","description":" ","form_action":" ","form_type":"false","h":"175","language":"false","my_library":" ","on_security_failure":"login","pages_names":" ","positioning":"absolute","security":"none","sp_theme":"false","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"740"},{"align":"left","anchor":" ","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":" ","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Modifica\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"datamodi\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Collegamento\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CONNES\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Ragione Sociale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"RAGSOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"Query1","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"D,C,C","filters":"false","font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","h":"120","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"true","line_color":"#FFFFFF","link_underlined":"true","name":"Grid0","nav_bar":"always","orderby":"false","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","recMark":"false","render_totals":" ","resizablecolumns":"false","row_color":"#CCCCCC","row_color_odd":"#999999","rows":"5","scroll_bars":"false","sequence":" ","server_side":"false","splinker":"kersonbo","splinker_pos":" ","title_color":" ","type":"Grid","valign":" ","w":"740","x":"0","y":"20"},{"auto_exec":"true","count":"true","n_records":"100","name":"Query1","page":"1","parms":"w_CONNES","parms_source":" ","query":"qbe_kersonbo","query_async":"false","return_fields_type":"true","sequence":" ","type":"SQLDataobj","x":"0","y":"-40"},{"anchor":" ","calculate":" ","class_Css":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"22","help_tips":" ","hide_undercond":" ","init":" ","init_par":"attribute","maxlength":" ","name":"w_CONNES","page":"1","password":"false","picture":" ","readonly":"false","scroll":"false","sequence":" ","tabindex":" ","type":"Textbox","typevar":"character","visible":"false","w":"146","x":"96","y":"-32","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"master","h":"30","m_cAction":" ","m_cAltInterface":" ","name":"kersonbo","page":"1","parms":"CONNES","popup":"true","popup_height":"600","popup_scroll":"false","popup_width":"800","refresh":"false","sequence":" ","servlet":"armt_kersonbo","target":" _new","type":"SPLinker","w":"30","x":"40","y":"-40"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#829BC6","calculate":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2","page":"1","picture":" ","sequence":" ","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"STORICO VARIAZIONI SOGGETTO","w":"740","x":"0","y":"0","zindex":"1"}]%>
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
window.pg_kersonbo_Static=function(){
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Grid0.SetSPLinkerActions('-d-e-n')

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_kersonbo_container {
}
.pg_kersonbo_portlet{
  position:relative;
  width:740px;
  min-width:740px;
  height:175px;
  background-color:#C0C0C0;
}
.pg_kersonbo_portlet[Data-page="1"]{
  height:175px;
  width:740px;
}
.pg_kersonbo_portlet > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  width:740px;
  height:auto;
  min-height:120px;
}
.pg_kersonbo_portlet > .w_CONNES_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_kersonbo_portlet > .w_CONNES_ctrl {
  display:none;
}
.pg_kersonbo_portlet > .w_CONNES_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_kersonbo_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:740px;
  height:auto;
  min-height:20px;
}
.pg_kersonbo_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_kersonbo_portlet > .label2_ctrl {
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
 String def="[{\"h\":\"175\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"740\"},{\"anchor\":\"\",\"h\":\"120\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"740\",\"x\":\"0\",\"y\":\"20\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"0\",\"y\":\"-40\"},{\"anchor\":\"\",\"h\":\"22\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"146\",\"x\":\"96\",\"y\":\"-32\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"40\",\"y\":\"-40\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"740\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_kersonbo","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_kersonbo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_kersonbo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_kersonbo_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_CONNES=JSPLib.translateXSS(Library.getAttribute(request,"w_CONNES",""));
if(request.getAttribute("pg_kersonbo_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label2= "STORICO VARIAZIONI SOGGETTO";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_kersonbo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_kersonbo_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_kersonbo','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_w_CONNES_wrp'><input id='<%=idPortlet%>_w_CONNES' name='w_CONNES' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_CONNES' /></span>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("STORICO VARIAZIONI SOGGETTO")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_kersonbo');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_kersonbo',["740"],["175"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"740","h":"175","title":" ","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":" ","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":120,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":"false","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"#FFFFFF","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"black","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":" ","row_color":"#CCCCCC","row_color_odd":"#999999","scroll_bars":"false","show_btn_delete":"false","show_btn_update":"false","show_filters":"false","shrinkable":"false","splinker":"kersonbo","splinker_pos":" ","title_color":"","type":"Grid","valign":" ","w":740,"x":0,"y":20});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":5,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Modifica","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"datamodi","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Collegamento","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CONNES","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Ragione Sociale","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"RAGSOC","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_kersonbo","cmdHash":"<%=JSPLib.cmdHash("qbe_kersonbo",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"100","page":1,"parms":"w_CONNES","parms_source":" ","type":"SQLDataobj","w":0,"x":0,"y":-40});
this.w_CONNES=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_w_CONNES","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"attribute","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_CONNES","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_CONNES,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.kersonbo=new ZtVWeb.SPLinkerCtrl(this,{"action":" ","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_kersonbo","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"kersonbo","offline":false,"page":1,"parms":"CONNES","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_kersonbo","target":" _new","type":"SPLinker","w":30,"x":40,"y":-40});
this.kersonbo.m_cID='<%=JSPLib.cmdHash("entity,armt_kersonbo",request.getSession())%>';
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":740,"x":0,"y":0,"zindex":"1"});
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
<%if(request.getAttribute("pg_kersonbo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_kersonbo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_kersonbo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_kersonbo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_kersonbo');
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
sp.endPage("pg_kersonbo");
}%>
<%! public String getJSPUID() { return "2350686510"; } %>