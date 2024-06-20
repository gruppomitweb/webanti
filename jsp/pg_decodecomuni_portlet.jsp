<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.Grid1.SetSPLinkerActions('-n')\n\nfunction imgExit_Click(){\n  this.RTUscita.Link()\n}\n\nfunction imgNew_Click(){\n  this.NuovaDecode.Link()\n}\n\nfunction Rinfresca(evt) {\n  this.dataobj0.Query(true)\n}  \n\nfunction imgExcel_Click(){\n  if (confirm(\"Confermi l'estrazione del file XLS?\")) {\n    this.EstraiXls.Link()\n  }  \n}\n\nfunction imgImport_Click(){\n  this.ImpXls.Link()\n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"GESTIONE DECODIFICHE COMUNI DI RESIDENZA\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n}\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"450","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"15","name":"dataobj0","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_decodecomuni","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"16","y":"-37"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"ID\",\"type\":\"N\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"ID\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"CITTA' WU\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CITTA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"CITTA' AUI\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CITTAMIT\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataobj0","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"N,C,C","filters":"true-by-example","floatRows":"","font":"Tahoma","font_color":"","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":"358","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"Grid1","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"LancioMaster","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"800","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"48","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Crea il file XLS per la correzione massiva","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"imgExcel","page":"1","path_type":"","sequence":"3","server_side":"","src":"..\u002fimages\u002fsystem\u002ficons8-ms-excel-50.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"642","y":"10","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe90a;","font_image_hover":"&#xe90b;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Inserisci una nuova decodifica","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"imgNew","page":"1","path_type":"","sequence":"4","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_blank_doc.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"721","y":"10","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Import il file per la correzione massiva","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"imgImport","page":"1","path_type":"","sequence":"5","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"682","y":"10","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"imgExit","page":"1","path_type":"","sequence":"6","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_exit.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"762","y":"10","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"impxls_Ended","objsValues":"this.Rinfresca('')","page":"1","parmsNames":"","sequence":"7","type":"EventReceiver","w":"22","x":"467","y":"-30"},{"async":"false","entity_type":"master","h":"30","m_cAction":"","m_cAltInterface":"","name":"LancioMaster","offline":"false","page":"1","parms":"ID=cId","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"armt_decodecomuni","target":"","type":"SPLinker","w":"30","x":"73","y":"-37"},{"async":"false","entity_type":"page","h":"30","m_cAction":"","m_cAltInterface":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"126","y":"-36"},{"async":"false","entity_type":"page","h":"30","m_cAction":"","m_cAltInterface":"","name":"NuovaDecode","offline":"false","page":"1","parms":"","popup":"true","popup_height":"75","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"860","progressbar":"","refresh":"","sequence":"10","servlet":"pg_newdecodec_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"348","y":"-39"},{"calculate":"","dataobj":"dataobj0","field":"ID","h":"20","init":"","init_par":"","name":"cId","page":"1","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"176","y":"-32"},{"async":"false","entity_type":"","h":"30","m_cAction":"","m_cAltInterface":"","name":"ImpXls","offline":"false","page":"1","parms":"","popup":"true","popup_height":"75","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"860","progressbar":"","refresh":"","sequence":"12","servlet":"..\u002fjsp\u002fpg_impxls_decodecomuni_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"615","y":"-40"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_decodecomuni_savedEntity","objsValues":"this.Rinfresca(evt)","page":"1","parmsNames":"evt","sequence":"13","type":"EventReceiver","w":"22","x":"429","y":"-32"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"start","m_cAltInterface":"","name":"EstraiXls","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"arrt_creaxls_decodecomuni","target":"","type":"SPLinker","w":"30","x":"515","y":"-31"}]%>
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
window.pg_decodecomuni_Static=function(){
if(typeof imgExit_Click !='undefined')this.imgExit_Click=imgExit_Click;
if(typeof imgNew_Click !='undefined')this.imgNew_Click=imgNew_Click;
if(typeof Rinfresca !='undefined')this.Rinfresca=Rinfresca;
if(typeof imgExcel_Click !='undefined')this.imgExcel_Click=imgExcel_Click;
if(typeof imgImport_Click !='undefined')this.imgImport_Click=imgImport_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj0.addRowConsumer(this.Grid1);
this.dataobj0.addDataConsumer(this.cId,<%=JSPLib.ToJSValue("ID",true)%>);
this.Grid1.SetSPLinkerActions('-n')
function imgExit_Click(){
  this.RTUscita.Link()
}
function imgNew_Click(){
  this.NuovaDecode.Link()
}
function Rinfresca(evt) {
  this.dataobj0.Query(true)
}  
function imgExcel_Click(){
  if (confirm("Confermi l'estrazione del file XLS?")) {
    this.EstraiXls.Link()
  }  
}
function imgImport_Click(){
  this.ImpXls.Link()
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle("GESTIONE DECODIFICHE COMUNI DI RESIDENZA",true)
  this.getTitlePortlet().SetSubTitle("",true)
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
.pg_decodecomuni_container {
}
.pg_decodecomuni_title_container {
  margin: auto;
}
.pg_decodecomuni_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:450px;
  background-color:#FFFFFF;
}
.pg_decodecomuni_portlet[Data-page="1"]{
  height:450px;
  width:100%;
}
.pg_decodecomuni_portlet > .Grid1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:358px;
}
.pg_decodecomuni_portlet > .imgExcel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:128px;
  width:30px;
  height:30px;
}
.pg_decodecomuni_portlet > .imgExcel_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_decodecomuni_portlet > .imgNew_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:49px;
  width:30px;
  height:30px;
}
.pg_decodecomuni_portlet > .imgNew_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_decodecomuni_portlet > .imgImport_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:88px;
  width:30px;
  height:30px;
}
.pg_decodecomuni_portlet > .imgImport_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_decodecomuni_portlet > .imgExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:8px;
  width:30px;
  height:30px;
}
.pg_decodecomuni_portlet > .imgExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
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
 String def="[{\"h\":\"450\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"16\",\"y\":\"-37\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ID\"},{\"title\":\"CITTA' WU\"},{\"title\":\"CITTA' AUI\"}],\"h\":\"358\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"800\",\"x\":\"0\",\"y\":\"48\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"642\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"721\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"682\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"762\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"467\",\"y\":\"-30\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"73\",\"y\":\"-37\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"126\",\"y\":\"-36\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"348\",\"y\":\"-39\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"176\",\"y\":\"-32\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"615\",\"y\":\"-40\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"429\",\"y\":\"-32\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"515\",\"y\":\"-31\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_decodecomuni","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_decodecomuni_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_decodecomuni','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_decodecomuni_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String cId= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_decodecomuni_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_decodecomuni_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_decodecomuni_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_decodecomuni','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid1' formid='<%=idPortlet%>' ps-name='Grid1'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_imgExcel' class='image imgExcel_ctrl'   target=''>&#xea8c;</a>
<a id='<%=idPortlet%>_imgNew' class='image imgNew_ctrl'   target=''>&#xe90a;</a>
<a id='<%=idPortlet%>_imgImport' class='image imgImport_ctrl'   target=''>&#xe9da;</a>
<a id='<%=idPortlet%>_imgExit' class='image imgExit_ctrl'   target=''>&#xe9fb;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_decodecomuni');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_decodecomuni',["800"],["450"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"450","title":"","layer":"false","npage":"1"}]);
this.dataobj0=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_decodecomuni","cmdHash":"<%=JSPLib.cmdHash("qbe_decodecomuni",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_dataobj0","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj0","nrows":"15","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":16,"y":-37});
this.Grid1=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid1","dataobj":"dataobj0","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":358,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"Grid1","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"LancioMaster","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":800,"x":0,"y":48,"zindex":""});
this.Grid1.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"ID","type":"N","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"ID","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"CITTA' WU","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CITTA","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"CITTA' AUI","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CITTAMIT","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.imgExcel=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image imgExcel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgExcel","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Crea il file XLS per la correzione massiva",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"imgExcel","page":1,"path_type":"","server_side":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":642,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.imgNew=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image imgNew_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgNew","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe90a;","font_image_hover":"&#xe90b;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Inserisci una nuova decodifica",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"imgNew","page":1,"path_type":"","server_side":"","src":"&#xe90a;","srchover":"&#xe90b;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":721,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.imgImport=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image imgImport_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgImport","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Import il file per la correzione massiva",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"imgImport","page":1,"path_type":"","server_side":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":682,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.imgExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image imgExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imgExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"imgExit","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":762,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.impxls_Ended=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_impxls_Ended","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"impxls_Ended","objsValues":"this.Rinfresca('')","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":467,"y":-30});
this.LancioMaster=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_LancioMaster","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"LancioMaster","offline":false,"page":1,"parms":"ID=cId","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_decodecomuni","target":"","type":"SPLinker","w":30,"x":73,"y":-37});
this.LancioMaster.m_cID='<%=JSPLib.cmdHash("entity,armt_decodecomuni",request.getSession())%>';
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":30,"x":126,"y":-36});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.NuovaDecode=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_NuovaDecode","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"NuovaDecode","offline":false,"page":1,"parms":"","popup":"true","popup_height":"75","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"860","progressbar":false,"refresh":"","servlet":"pg_newdecodec_portlet.jsp","target":"","type":"SPLinker","w":30,"x":348,"y":-39});
this.NuovaDecode.m_cID='<%=JSPLib.cmdHash("entity,pg_newdecodec_portlet.jsp",request.getSession())%>';
this.cId=new ZtVWeb._VC(this,'cId',null,'character','<%=JSPLib.ToJSValue(cId,false,true)%>',false,false);
this.ImpXls=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ImpXls","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ImpXls","offline":false,"page":1,"parms":"","popup":"true","popup_height":"75","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"860","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_impxls_decodecomuni_portlet.jsp","target":"","type":"SPLinker","w":30,"x":615,"y":-40});
this.ImpXls.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_impxls_decodecomuni_portlet.jsp",request.getSession())%>';
this.armt_decodecomuni_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_decodecomuni_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_decodecomuni_savedEntity","objsValues":"this.Rinfresca(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":22,"x":429,"y":-32});
this.EstraiXls=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_EstraiXls","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"EstraiXls","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_creaxls_decodecomuni","target":"","type":"SPLinker","w":30,"x":515,"y":-31});
this.EstraiXls.m_cID='<%=JSPLib.cmdHash("routine,arrt_creaxls_decodecomuni",request.getSession())%>';
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
<%if(request.getAttribute("pg_decodecomuni_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_decodecomuni_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_decodecomuni_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.imgExcel.dispatchEvent('OnLoad');
window.<%=idPortlet%>.imgNew.dispatchEvent('OnLoad');
window.<%=idPortlet%>.imgImport.dispatchEvent('OnLoad');
window.<%=idPortlet%>.imgExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_impxls_Ended=function(parmsObj){<%=idPortlet%>.impxls_Ended.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_decodecomuni_savedEntity=function(parmsObj){<%=idPortlet%>.armt_decodecomuni_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.dataobj0.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_decodecomuni',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_decodecomuni');
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
sp.endPage("pg_decodecomuni");
}%>
<%! public String getJSPUID() { return "1986899368"; } %>