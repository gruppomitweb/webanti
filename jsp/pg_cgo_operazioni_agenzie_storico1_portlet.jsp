<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Storico Operazioni (Agenzie)\",true)  \n}\n\nfunction LanciaView() {\n  this.OpeEdit.Link()\n}  \n\nfunction Uscita_Click(){\n this.BtnUscita.Link()\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"{{ @Uscita }} \n \n{{ @Grid0 }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:LanciaView()\",\"weight\":\"\",\"title\":\"N° Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Completamento Agenzia\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CGODATDIPCOM\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Causale\",\"type\":\"N\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CACODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CADESCRI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"N\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Segno\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SEGNO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"field\":\"CODFISC\",\"title\":\"Codice Fiscale\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"D,C,D,N,C,N,C","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":25,\"w\":320,\"h\":528,\"anchor\":\"\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":25,\"w\":480,\"h\":528,\"anchor\":\"\",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":40,\"w\":768,\"h\":528,\"anchor\":\"\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"40","zindex":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_operazioni_agenzia_storico","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"799","y":"26"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"view","name":"OpeEdit","offline":"false","page":"1","parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"4","servlet":"..\u002fservlet\u002farmt_snai_oper_storico","target":"","type":"SPLinker","w":"106","x":"799","y":"49"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"794","y":"0"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":61,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":61,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":731,\"y\":6,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":979,\"y\":61,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Uscita","page":"1","path_type":"","sequence":"6","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"731","y":"6","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"start","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":"","refresh":"","sequence":"7","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"172","x":"789","y":"-70"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"SNAINUMOPE","h":"20","init":"","init_par":"","name":"w_snainumope","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"792","y":"-24"}]%>
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
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));
if(sp.getParameter("SpStaticCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/javascript");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
window.pg_cgo_operazioni_agenzie_storico1_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LanciaView !='undefined')this.LanciaView=LanciaView;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.w_snainumope,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Storico Operazioni (Agenzie)",true)  
}
function LanciaView() {
  this.OpeEdit.Link()
}  
function Uscita_Click(){
 this.BtnUscita.Link()
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
.pg_cgo_operazioni_agenzie_storico1_container {
}
.pg_cgo_operazioni_agenzie_storico1_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_storico1_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:25px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:25px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="320"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:306px;
  left:95.625%;
  right:2px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="480"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:459px;
  left:95.625%;
  right:3px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="768"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  right:7px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="1024"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="320"] > .Uscita_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="480"] > .Uscita_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_agenzie_storico1_portlet[Data-step="768"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"N° Ticket\"},{\"title\":\"Data Completamento Agenzia\"},{\"title\":\"Codice Causale\"},{\"title\":\"Descrizione\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Segno\"},{\"title\":\"Codice Fiscale\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\"\",\"h\":528,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":25},\"480\":{\"anchor\":\"\",\"h\":528,\"hide\":\"false\",\"w\":480,\"x\":0,\"y\":25},\"768\":{\"anchor\":\"\",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":40}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"40\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"799\",\"y\":\"26\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"106\",\"x\":\"799\",\"y\":\"49\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"794\",\"y\":\"0\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":61},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":61},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":61},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":731,\"y\":6}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"731\",\"y\":\"6\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"172\",\"x\":\"789\",\"y\":\"-70\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"792\",\"y\":\"-24\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie_storico1","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_storico1_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_storico1','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_storico1_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String gUrlApp=sp.getGlobal("gUrlApp","");
String w_snainumope= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_storico1_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_storico1_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_storico1_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie_storico1','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie_storico1');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie_storico1',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":"","h":528,"hide":"false","w":320,"x":0,"y":25},"480":{"anchor":"","h":528,"hide":"false","w":480,"x":0,"y":25},"768":{"anchor":"","h":528,"hide":"false","w":768,"x":0,"y":40}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":40,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Oper.","type":"D","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATAOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:LanciaView()","weight":"","title":"N° Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Completamento Agenzia","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CGODATDIPCOM","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Causale","type":"N","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CACODICE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CADESCRI","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"N","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Segno","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"SEGNO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Fiscale","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CODFISC","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_operazioni_agenzia_storico","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_agenzia_storico",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":799,"y":26});
this.OpeEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeEdit","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeEdit","offline":false,"page":1,"parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"..\u002fservlet\u002farmt_snai_oper_storico","target":"","type":"SPLinker","w":106,"x":799,"y":49});
this.OpeEdit.m_cID='<%=JSPLib.cmdHash("entity,../servlet/armt_snai_oper_storico",request.getSession())%>';
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":61},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":61},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":61},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":731,"y":6}},"name":"Uscita","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":731,"y":6,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"210","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"760","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":172,"x":789,"y":-70});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.w_snainumope=new ZtVWeb._VC(this,'w_snainumope',null,'character','<%=JSPLib.ToJSValue(w_snainumope,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_storico1_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_storico1_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_storico1_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_storico1',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie_storico1');
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
sp.endPage("pg_cgo_operazioni_agenzie_storico1");
}%>
<%! public String getJSPUID() { return "3925427303"; } %>