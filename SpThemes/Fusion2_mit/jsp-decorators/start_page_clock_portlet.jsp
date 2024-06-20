<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _this = this;\nfunction clock() {\n\t\u002f\u002f creiamo l'oggetto data\n  var data = new Date();\n  \u002f\u002f recuperiamo l'ora corrente\n  var ora = data.getHours();\n  \u002f\u002f recuperiamo i minuti attuali\n  var min = data.getMinutes();\n  \u002f\u002f recuperiamo i secondi attuali\n  var sec = data.getSeconds();\n  \u002f\u002f formattiamo i minuti\n  if (min \u003c 10) {\n    min = \"0\" + min;\n  }\n  if (sec \u003c 10) {\n    sec = \"0\" + sec;\n  }\n  \u002f\u002f prepariamo l'output\n  var output = ora + \":\" + min+\":\"+sec;\n  \u002f\u002f scriviamo l'ora nell'elemento\n  this.lblClock.Value(output);\n  \u002f\u002f richiamiamo la funione tra un secondo\n  setTimeout( function() {_this.clock()},1000 );\n}\nfunction diary(){\n  \u002f\u002f creiamo l'oggetto data\n  var data = new Date();\n  var dayname = ['\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_SUNDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_MONDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_TUESDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_WEDNESDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_THURSDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_FRIDAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_SATURDAY\"))%\u003e'][data.getDay()];\n  var day = data.getDate();\n  var month = ['\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_JANUARY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_FEBRUARY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_MARCH\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_APRIL\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_MAY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_JUNE\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_JULY\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_AUGUST\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_SEPTEMBER\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_OCTOBER\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_NOVEMBER\"))%\u003e','\u003c%=JSPLib.ToJSValue(sp.translate(\"MSG_CALENDAR_DECEMBER\"))%\u003e'][data.getMonth()];\n  var year = data.getFullYear();\n  \n  var output = dayname + \" \" + day +\" \"+ month + \" \"+year ;\n  this.lblDay.Value(output);\n}\nfunction this_Loaded(){\n\tthis.clock();   \n  this.diary();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"color: rgb(29 33 39\u002f30%);\\npadding: 0px;\\ncursor: default;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label-small-bold-uppercase\",\"selector\":\".label-small-bold-uppercase.title-gadget\",\"value\":\"CALENDARIO\",\"class_Css\":\"label\",\"id\":\"form\"}]","custom":"","description":"Calendario sidebar","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @bg }}{{ @lblDay }}{{ @lblClock }}{{ @Label3 }}{{ @lblTitleGadget }}\u003c\u002fbody\u003e","grapesCss":"","h":"110","hsl":"","htmlcode":"{{ @bg }} \n{{ bg }}\n{{ lblDay }}\n{{ lblClock }}\n{{ @lblDay }} \n{{ @lblClock }} \n{{ @lblTitleGadget }} \n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"empty","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"110\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"pagelet","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"230","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"box-border-bottom-gray","collapsible":"","create_undercond":"","ctrlOfVariant":"","fixed":"","groupName":"","h":"110","hide":"false","hide_undercond":"","href":"","layer":"false","layout_steps_values":"{}","name":"bg","page":"1","rapp":"","sequence":"1","shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","title_portlet":"","titled":"","type":"Box","w":"230","wireframe_props":"","x":"0","y":"0","zindex":"0","zone":""},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label-medium-bold","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDay","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Lunedì 12 Settembre 2015","w":"190","wireframe_props":"align,value,n_col","x":"20","y":"50","zindex":"1","zone":""},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label-medium-bold","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblClock","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"12:30:45","w":"190","wireframe_props":"align,value,n_col","x":"20","y":"66","zindex":"1","zone":""},{"align":"","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label-title-gadget","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTitleGadget","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"DATA E ORA","w":"190","wireframe_props":"align,value,n_col","x":"20","y":"20","zindex":"2","zone":""}]%>
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
.start_page_clock_container .label-small-bold-uppercase.title-gadget{  color: rgb(29 33 39/30%);
  padding: 0px;
  cursor: default;
}
.start_page_clock_container {
}
.start_page_clock_portlet{
  position:relative;
  width:100%;
  min-width:230px;
  height:110px;
}
.start_page_clock_portlet[Data-page="1"]{
  height:110px;
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
  min-height:110px;
  display:flex;
  flex-direction:column;
}
.start_page_clock_portlet > .bg_ctrl {
  height:110px;
}
.start_page_clock_portlet > .bg_ctrl > .box_content {
  height:100%;
}
.start_page_clock_portlet > .bg_ctrl {
  min-height:110px;
}
.start_page_clock_portlet > .lblDay_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:50px;
  left:20px;
  right:20px;
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
  text-align:center;
  background-color:transparent;
}
.start_page_clock_portlet > .lblClock_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:66px;
  left:20px;
  right:20px;
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
  text-align:center;
  background-color:transparent;
}
.start_page_clock_portlet > .lblTitleGadget_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:20px;
  left:20px;
  width:190px;
  height:auto;
  min-height:25px;
}
.start_page_clock_portlet > .lblTitleGadget_ctrl {
  height:auto;
  min-height:25px;
}
.start_page_clock_portlet > .lblTitleGadget_ctrl {
  overflow:hidden;
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
 String def="[{\"h\":\"110\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"230\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"110\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"230\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"0\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Lunedì 12 Settembre 2015\",\"w\":\"190\",\"x\":\"20\",\"y\":\"50\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"12:30:45\",\"w\":\"190\",\"x\":\"20\",\"y\":\"66\",\"zindex\":\"1\"},{\"align\":\"\",\"anchor\":\"top-left\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"DATA E ORA\",\"w\":\"190\",\"x\":\"20\",\"y\":\"20\",\"zindex\":\"2\"}]";
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
String lblTitleGadget= "DATA E ORA";
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
<div id='<%=idPortlet%>_bg' class='bg_ctrl SPSection_expanded box-border-bottom-gray' data-original-display='flex'><div id='<%=idPortlet%>_bg_td' class='box_content'></div>
</div>
<span id='<%=idPortlet%>_lblDay'  formid='<%=idPortlet%>' ps-name='lblDay'    class='label-medium-bold lblDay_ctrl'><div id='<%=idPortlet%>_lblDaytbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Lunedì 12 Settembre 2015"))%></div></span>
<span id='<%=idPortlet%>_lblClock'  formid='<%=idPortlet%>' ps-name='lblClock'    class='label-medium-bold lblClock_ctrl'><div id='<%=idPortlet%>_lblClocktbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("12:30:45"))%></div></span>
<span id='<%=idPortlet%>_lblTitleGadget'  formid='<%=idPortlet%>' ps-name='lblTitleGadget'    class='label-title-gadget lblTitleGadget_ctrl'><div id='<%=idPortlet%>_lblTitleGadgettbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("DATA E ORA"))%></div></span>
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
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_clock',["230"],["110"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"230","h":"110","title":"","layer":""}]);
this.bg=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left-right","bg_color":"","border_color":"","border_weight":"","class_Css":"box-border-bottom-gray","collapsible":"","create_undercond":"","ctrlid":"<%=idPortlet%>_bg","groupName":"","h":110,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"bg","page":1,"shrinkable":"","spuid":"","stretch":"false","target":"","title_caption":"","titled":"","type":"Box","w":230,"x":0,"y":0,"zindex":"0"});
this.lblDay=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label-medium-bold","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDay","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDay","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblDay),false,true)%>","type":"Label","w":190,"x":20,"y":50,"zindex":"1"});
this.lblClock=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label-medium-bold","create_undercond":"","ctrlid":"<%=idPortlet%>_lblClock","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblClock","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblClock),false,true)%>","type":"Label","w":190,"x":20,"y":66,"zindex":"1"});
this.lblTitleGadget=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label-title-gadget","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTitleGadget","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitleGadget","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(lblTitleGadget),false,true)%>","type":"Label","w":190,"x":20,"y":20,"zindex":"2"});
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
<%! public String getJSPUID() { return "1568600158"; } %>