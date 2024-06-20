<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _this = this;\nfunction clock() {\n\t\u002f\u002f creiamo l'oggetto data\n  var data = new Date();\n  \u002f\u002f recuperiamo l'ora corrente\n  var ora = data.getHours();\n  \u002f\u002f recuperiamo i minuti attuali\n  var min = data.getMinutes();\n  \u002f\u002f recuperiamo i secondi attuali\n  var sec = data.getSeconds();\n  \u002f\u002f formattiamo i minuti\n  if (min \u003c 10) {\n    min = \"0\" + min;\n  }\n  if (sec \u003c 10) {\n    sec = \"0\" + sec;\n  }\n  \u002f\u002f prepariamo l'output\n  var output = ora + \":\" + min+\":\"+sec;\n  \u002f\u002f scriviamo l'ora nell'elemento\n  this.lblClock.Value(output);\n  \u002f\u002f richiamiamo la funione tra un secondo\n  setTimeout( function() {_this.clock()},1000 );\n}\nfunction diary(){\n  \u002f\u002f creiamo l'oggetto data\n  var data = new Date();\n  var dayname = ['\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_SUNDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_MONDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_TUESDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_WEDNESDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_THURSDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_FRIDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_SATURDAY\"))%\u003e'][data.getDay()];\n  var day = data.getDate();\n  var month = ['\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_JANUARY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_FEBRUARY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_MARCH\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_APRIL\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_MAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_JUNE\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_JULY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_AUGUST\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_SEPTEMBER\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_OCTOBER\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_NOVEMBER\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_DECEMBER\"))%\u003e'][data.getMonth()];\n  var year = data.getFullYear();\n  \n  var output = dayname + \" \" + day +\" \"+ month + \" \"+year ;\n  this.lblDay.Value(output);\n}\nfunction this_Loaded(){\n\tthis.clock();   \n  this.diary();\n}","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"type\":\"box\",\"name\":\"bg_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"#000000\\\",\\\"bg_opacity\\\":\\\"12\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Coustard\\\",\\\"Antic Slab\\\",\\\"Quattrocento\\\",\\\"Cinzel\\\",\\\"Josefin Slab\\\",\\\"Merriweather\\\",\\\"Lora\\\",\\\"Nunito\\\",\\\"Abel\\\",\\\"Fjalla One\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Raleway\\\",\\\"Montserrat\\\",\\\"Roboto Condensed\\\",\\\"Oswald\\\",\\\"Special Elite\\\",\\\"Fredoka One\\\",\\\"Comfortaa\\\",\\\"Bangers\\\",\\\"Righteous\\\",\\\"Sigmar One\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Lobster\\\",\\\"Nova Mono\\\",\\\"Inconsolata\\\",\\\"Source Code Pro\\\",\\\"Anonymous Pro\\\",\\\"Roboto Mono\\\",\\\"Amatic SC\\\",\\\"Shadows Into Light\\\",\\\"Dancing Script\\\",\\\"Pacifico\\\",\\\"Indie Flower\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"Box0\\\",\\\"type\\\":\\\"Box\\\",\\\"class_name\\\":\\\"bg_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:250px; height:60px;\\\\\\\" \u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"page\\\":1,\\\"bg_color\\\":\\\"#000000\\\",\\\"bg_opacity\\\":\\\"12\\\"}\",\"code\":\".bg_class{background-color: rgba(0, 0, 0, 0.12) ;background-size: cover;}\\n\",\"selector\":\"bg_class\"},{\"type\":\"Box\",\"name\":\"bg_class\",\"selector\":\".bg_class\",\"obj\":\"{\\\"shadow_type\\\":\\\"outline\\\",\\\"border_type\\\":\\\"solid\\\",\\\"states\\\":\\\"normal,hover,:before,:after\\\",\\\"current_state\\\":\\\"normal\\\",\\\"specific_states_value\\\":{\\\"normal\\\":{\\\"bg_color\\\":\\\"rgb(40, 70, 120)\\\",\\\"bg_opacity\\\":\\\"12\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"border_type\\\":\\\"solid\\\",\\\"shadow_type\\\":\\\"outline\\\",\\\"selector\\\":\\\".bg_class\\\",\\\"code\\\":\\\"\\\"},\\\"hover\\\":{},\\\":before\\\":{},\\\":after\\\":{}},\\\"font_list\\\":[\\\"\\\",\\\"Coustard\\\",\\\"Antic Slab\\\",\\\"Quattrocento\\\",\\\"Cinzel\\\",\\\"Josefin Slab\\\",\\\"Merriweather\\\",\\\"Lora\\\",\\\"Nunito\\\",\\\"Abel\\\",\\\"Fjalla One\\\",\\\"Dosis\\\",\\\"Economica\\\",\\\"Raleway\\\",\\\"Montserrat\\\",\\\"Roboto Condensed\\\",\\\"Oswald\\\",\\\"Special Elite\\\",\\\"Fredoka One\\\",\\\"Comfortaa\\\",\\\"Bangers\\\",\\\"Righteous\\\",\\\"Sigmar One\\\",\\\"Patua One\\\",\\\"Poiret One\\\",\\\"Lobster\\\",\\\"Nova Mono\\\",\\\"Inconsolata\\\",\\\"Source Code Pro\\\",\\\"Anonymous Pro\\\",\\\"Roboto Mono\\\",\\\"Amatic SC\\\",\\\"Shadows Into Light\\\",\\\"Dancing Script\\\",\\\"Pacifico\\\",\\\"Indie Flower\\\"],\\\"common_properties\\\":[\\\"current_state\\\",\\\"class_name\\\",\\\"h\\\",\\\"w\\\",\\\"id\\\",\\\"html\\\",\\\"name\\\",\\\"type\\\",\\\"states\\\",\\\"specific_states_value\\\",\\\"common_properties\\\"],\\\"id\\\":\\\"item0\\\",\\\"name\\\":\\\"Box0\\\",\\\"type\\\":\\\"Box\\\",\\\"class_name\\\":\\\"bg_class\\\",\\\"html\\\":\\\"\u003cdiv id=\\\\\\\"item0\\\\\\\" style=\\\\\\\"width:250px; height:60px;\\\\\\\" \u003e\u003c\u002fdiv\u003e\\\",\\\"h\\\":\\\"120px\\\",\\\"w\\\":\\\"240px\\\",\\\"bg_size_pr\\\":\\\"cover\\\",\\\"page\\\":1,\\\"bg_color\\\":\\\"rgb(40, 70, 120)\\\",\\\"bg_opacity\\\":\\\"12\\\",\\\"selector\\\":\\\".bg_class\\\",\\\"code\\\":\\\"\\\"}\",\"code\":\".bg_class {\\n  background-color: rgb(40, 70, 120);\\n  background-size: cover;\\n}\\n\"}]","description":"Calendario sidebar","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"100","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"empty","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"pagelet","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"230","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","bg_color":"#064984","border_color":"","border_weight":"","class_Css":"bg_class","create_undercond":"","h":"101","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"bg","page":"1","sequence":"7","shrinkable":"","stretch":"false","type":"Box","w":"230","wireframe_props":"","x":"0","y":"0","zindex":"0"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#fff","font_size":"","font_weight":"","fontpct":"120","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblDay","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Lunedì 12 Settembre 2015","w":"224","wireframe_props":"align,value,n_col","x":"2","y":"24","zindex":"1"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#fff","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblClock","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"12:30:45","w":"224","wireframe_props":"align,value,n_col","x":"2","y":"53","zindex":"1"}]%>
<%/*Description:Calendario sidebar*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
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
.start_page_clock_container .bg_class{  background-color: #000000;
  background-size: cover;
}
.start_page_clock_container .bg_class{
  background-color: rgb(40, 70, 120);
  background-size: cover;
}
.start_page_clock_container {
}
.start_page_clock_portlet{
  position:relative;
  width:100%;
  min-width:230px;
  height:100px;
}
.start_page_clock_portlet[Data-page="1"]{
  height:100px;
  width:100%;
}
.start_page_clock_portlet > .bg_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:101px;
  display:flex;
  flex-direction:column;
}
.start_page_clock_portlet > .bg_ctrl {
  height:101px;
}
.start_page_clock_portlet > .bg_ctrl > .box_content {
  height:100%;
}
.start_page_clock_portlet > .bg_ctrl {
  min-height:101px;
  background-color:#064984;
}
.start_page_clock_portlet > .lblDay_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:24px;
  left:2px;
  right:4px;
  width:auto;
  height:auto;
  min-height:25px;
}
.start_page_clock_portlet > .lblDay_ctrl {
  height:auto;
  min-height:25px;
}
.start_page_clock_portlet > .lblDay_ctrl {
  overflow:hidden;
  color:#fff;
  text-align:center;
  background-color:transparent;
}
.start_page_clock_portlet > .lblDay_ctrl > div{
  font-size:120%;
}
.start_page_clock_portlet > .lblClock_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  left:2px;
  right:4px;
  width:auto;
  height:auto;
  min-height:25px;
}
.start_page_clock_portlet > .lblClock_ctrl {
  height:auto;
  min-height:25px;
}
.start_page_clock_portlet > .lblClock_ctrl {
  overflow:hidden;
  color:#fff;
  text-align:center;
  background-color:transparent;
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
 String def="[{\"h\":\"100\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"230\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"101\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"230\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Lunedì 12 Settembre 2015\",\"w\":\"224\",\"x\":\"2\",\"y\":\"24\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"12:30:45\",\"w\":\"224\",\"x\":\"2\",\"y\":\"53\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_clock","UTF-8")) {return; }
 %><%if(request.getAttribute("javax.servlet.include.request_uri")==null && request.getParameter("clientsideinclusion")==null){
if (true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_clock_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_clock','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblDay= "Lunedì 12 Settembre 2015";
String lblClock= "12:30:45";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_clock_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_clock_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_clock','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_bg' class='bg_ctrl SPSection_expanded bg_class' data-original-display='flex'><div id='<%=idPortlet%>_bg_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_lblDay'  formid='<%=idPortlet%>' ps-name='lblDay'    class='label lblDay_ctrl'><div id='<%=idPortlet%>_lblDaytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Lunedì 12 Settembre 2015"))%></div></span>
<span id='<%=idPortlet%>_lblClock'  formid='<%=idPortlet%>' ps-name='lblClock'    class='label lblClock_ctrl'><div id='<%=idPortlet%>_lblClocktbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("12:30:45"))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_clock');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_clock',["230"],["100"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"230","h":"100","title":"","layer":"false","npage":"1"}]);
this.bg=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"#064984","border_color":"","border_weight":"","class_Css":"bg_class","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_bg","groupName":"","h":101,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"bg","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":230,"x":0,"y":0,"zindex":"0"});
this.lblDay=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDay","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#fff","font_size":"","font_weight":"","fontpct":"120","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDay","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblDay),false,true)%>","type":"Label","w":224,"x":2,"y":24,"zindex":"1"});
this.lblClock=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblClock","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#fff","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblClock","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblClock),false,true)%>","type":"Label","w":224,"x":2,"y":53,"zindex":"1"});
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
<%request.setAttribute("start_page_clock_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.start_page_clock_Static=function(){
if(typeof clock !='undefined')this.clock=clock;
if(typeof diary !='undefined')this.diary=diary;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var _this = this;
function clock() {
	// creiamo l'oggetto data
  var data = new Date();
  // recuperiamo l'ora corrente
  var ora = data.getHours();
  // recuperiamo i minuti attuali
  var min = data.getMinutes();
  // recuperiamo i secondi attuali
  var sec = data.getSeconds();
  // formattiamo i minuti
  if (min < 10) {
    min = "0" + min;
  }
  if (sec < 10) {
    sec = "0" + sec;
  }
  // prepariamo l'output
  var output = ora + ":" + min+":"+sec;
  // scriviamo l'ora nell'elemento
  this.lblClock.Value(output);
  // richiamiamo la funione tra un secondo
  setTimeout( function() {_this.clock()},1000 );
}
function diary(){
  // creiamo l'oggetto data
  var data = new Date();
  var dayname = ['<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUNDAY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MONDAY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUESDAY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEDNESDAY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THURSDAY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRIDAY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SATURDAY"))%>'][data.getDay()];
  var day = data.getDate();
  var month = ['<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"))%>','<%=JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"))%>'][data.getMonth()];
  var year = data.getFullYear();
  
  var output = dayname + " " + day +" "+ month + " "+year ;
  this.lblDay.Value(output);
}
function this_Loaded(){
	this.clock();   
  this.diary();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.start_page_clock_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_clock',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_clock');
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
sp.endPage("start_page_clock");
}%>
<%! public String getJSPUID() { return "1267600575"; } %>