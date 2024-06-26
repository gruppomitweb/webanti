<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function RefreshDati(_evt) {\n  this.Query1.Query()\n  this.Grid0.Refresh()\n}\n\nfunction ColoraRiga(_stato) {\n  switch (_stato) {\n    case '2':\n      _colore='#FF0000';\n      break;\n    case '3':  \n      _colore='#FFFF99'\n      break;\n    default:\n      _colore=''\n  }    \n  return _colore;\n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#C0C0C0","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"120","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"300","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"3","name":"Query1","offline":"false","page":"1","parms":"w_rapporto","parms_source":"","query":"qbe_statorapprv","query_async":"true","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"0","y":"-40"},{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Intestatario\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"CODINTER\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Ragione Sociale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"RAGSOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Inizio\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"DATAINI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"field\":\"NUMPROG1\",\"title\":\"NUM.PROG.\",\"font_family\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Fine\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"newline\":false,\"field\":\"DATAFINE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"field\":\"NUMPROG2\",\"title\":\"NUM.PROG.\",\"font_family\":\"\",\"bg_color\":\"function:ColoraRiga('%STATOREG%')\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CONNES\",\"title\":\"CONNES\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,C,D,D","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"100","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"false","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"false","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"3","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"personbo","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":"300","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"20","zindex":""},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_provinformazioni_deletedEntity","objsValues":"this.RefreshDati(evt)","page":"1","parmsNames":"evt","sequence":"3","type":"EventReceiver","w":"237","x":"681","y":"-38"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_personbo_savedEntity","objsValues":"this.RefreshDati(evt)","page":"1","parmsNames":"evt","sequence":"4","type":"EventReceiver","w":"227","x":"441","y":"-9"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"attribute","layout_steps_values":"{}","maxlength":"","name":"w_rapporto","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"5","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"85","wireframe_props":"name","x":"135","y":"-40","zerofilling":"false","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_personbo_deletedEntity","objsValues":"this.RefreshDati(evt)","page":"1","parmsNames":"evt","sequence":"6","type":"EventReceiver","w":"237","x":"681","y":"-11"},{"async":"false","entity_type":"master","h":"20","m_cAction":"","m_cAltInterface":"","name":"personbo","offline":"false","page":"1","parms":"CONNES=CONNES","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"false","sequence":"7","servlet":"armt_personbo","target":"_new","type":"SPLinker","w":"83","x":"232","y":"-40"},{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","bg_color":"#829BC6","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label2","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"INTESTATARI (PROVVISORI)","w":"300","wireframe_props":"align,value,n_col","x":"0","y":"1","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_provinformazioni_savedEntity","objsValues":"this.RefreshDati(evt)","page":"1","parmsNames":"evt","sequence":"9","type":"EventReceiver","w":"227","x":"441","y":"-38"}]%>
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
window.pg_xntestbo_Static=function(){
if(typeof RefreshDati !='undefined')this.RefreshDati=RefreshDati;
if(typeof ColoraRiga !='undefined')this.ColoraRiga=ColoraRiga;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
function RefreshDati(_evt) {
  this.Query1.Query()
  this.Grid0.Refresh()
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
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_xntestbo_container {
}
.pg_xntestbo_title_container {
  margin: auto;
}
.pg_xntestbo_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:300px;
  height:120px;
  background-color:#C0C0C0;
}
.pg_xntestbo_portlet[Data-page="1"]{
  height:120px;
  width:100%;
}
.pg_xntestbo_portlet > .Grid0_ctrl {
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
.pg_xntestbo_portlet > .w_rapporto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:300px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_xntestbo_portlet > .w_rapporto_ctrl {
  display:none;
}
.pg_xntestbo_portlet > .w_rapporto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_xntestbo_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_xntestbo_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_xntestbo_portlet > .label2_ctrl {
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
 String def="[{\"h\":\"120\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"300\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"0\",\"y\":\"-40\"},{\"anchor\":\"top-left(%)-right(%)\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Intestatario\"},{\"title\":\"Ragione Sociale\"},{\"title\":\"Data Inizio\"},{\"title\":\"NUM.PROG.\"},{\"title\":\"Data Fine\"},{\"title\":\"NUM.PROG.\"},{\"title\":\"CONNES\"}],\"h\":\"100\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"3\",\"type\":\"Grid\",\"w\":\"300\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"237\",\"x\":\"681\",\"y\":\"-38\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"227\",\"x\":\"441\",\"y\":\"-9\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_rapporto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"85\",\"x\":\"135\",\"y\":\"-40\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"armt_personbo_deletedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"237\",\"x\":\"681\",\"y\":\"-11\"},{\"h\":\"20\",\"name\":\"personbo\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"83\",\"x\":\"232\",\"y\":\"-40\"},{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"INTESTATARI (PROVVISORI)\",\"w\":\"300\",\"x\":\"0\",\"y\":\"1\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"armt_provinformazioni_savedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"227\",\"x\":\"441\",\"y\":\"-38\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_xntestbo","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_xntestbo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_xntestbo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_xntestbo_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_rapporto=JSPLib.translateXSS(Library.getAttribute(request,"w_rapporto",""));
if(request.getAttribute("pg_xntestbo_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label2= "INTESTATARI (PROVVISORI)";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_xntestbo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_xntestbo_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_xntestbo','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_w_rapporto_wrp'><input id='<%=idPortlet%>_w_rapporto' name='w_rapporto' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_rapporto' /></span>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("INTESTATARI (PROVVISORI)")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_xntestbo');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_xntestbo',["300"],["120"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"300","h":"120","title":"","layer":"false","npage":"1"}]);
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_statorapprv","cmdHash":"<%=JSPLib.cmdHash("qbe_statorapprv",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"3","page":1,"parms":"w_rapporto","parms_source":"","type":"SQLDataobj","w":120,"x":0,"y":-40});
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":100,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"false","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"none","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"personbo","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":300,"x":0,"y":20,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":3,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Intestatario","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%STATOREG%')","field":"CODINTER","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Ragione Sociale","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%STATOREG%')","field":"RAGSOC","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Inizio","type":"D","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%STATOREG%')","field":"DATAINI","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"NUM.PROG.","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%STATOREG%')","field":"NUMPROG1","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Fine","type":"D","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%STATOREG%')","field":"DATAFINE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"NUM.PROG.","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"function:ColoraRiga('%STATOREG%')","field":"NUMPROG2","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"CONNES","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CONNES","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.armt_provinformazioni_deletedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_provinformazioni_deletedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_provinformazioni_deletedEntity","objsValues":"this.RefreshDati(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":237,"x":681,"y":-38});
this.armt_personbo_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_personbo_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_personbo_savedEntity","objsValues":"this.RefreshDati(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":227,"x":441,"y":-9});
this.w_rapporto=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_rapporto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"attribute","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_rapporto","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_rapporto,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.armt_personbo_deletedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_personbo_deletedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_personbo_deletedEntity","objsValues":"this.RefreshDati(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":237,"x":681,"y":-11});
this.personbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_personbo","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"personbo","offline":false,"page":1,"parms":"CONNES=CONNES","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"false","servlet":"armt_personbo","target":"_new","type":"SPLinker","w":83,"x":232,"y":-40});
this.personbo.m_cID='<%=JSPLib.cmdHash("entity,armt_personbo",request.getSession())%>';
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":300,"x":0,"y":1,"zindex":"1"});
this.armt_provinformazioni_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_provinformazioni_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_provinformazioni_savedEntity","objsValues":"this.RefreshDati(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":227,"x":441,"y":-38});
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
<%if(request.getAttribute("pg_xntestbo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_xntestbo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_xntestbo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_armt_provinformazioni_deletedEntity=function(parmsObj){<%=idPortlet%>.armt_provinformazioni_deletedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_personbo_savedEntity=function(parmsObj){<%=idPortlet%>.armt_personbo_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_personbo_deletedEntity=function(parmsObj){<%=idPortlet%>.armt_personbo_deletedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_provinformazioni_savedEntity=function(parmsObj){<%=idPortlet%>.armt_provinformazioni_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_xntestbo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_xntestbo');
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
sp.endPage("pg_xntestbo");
}%>
<%! public String getJSPUID() { return "1974945185"; } %>