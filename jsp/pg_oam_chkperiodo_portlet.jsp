<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Controlli Periodali\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi la stampa?\")) {\n    this.PortletLogs.Start();      \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.PortletLogs.Stop();        \n  alert(\"Elaborazione Completata!\");\n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Controlli Periodali","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @btnElab }}{{ @btnExit }}{{ @pLog }}{{ @pMsg }}{{ @DaDatOpe }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @flgncf }}{{ @iPrint }}{{ @btnElab }}{{ @btnExit }}{{ @DaDatOpe }}{{ @ADatOpe }}{{ @lblDaOpe }}{{ @lblAOpe }}{{ @flgncf }}{{ @iPrint }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"310","hsl":"false","htmlcode":"{{ @PortletLogs }} \n{{ @iPrint }} \n{{ @flgncf }} \n{{ @lblAOpe }} \n{{ @lblDaOpe }} \n{{ @ADatOpe }} \n{{ @DaDatOpe }} \n \n \n{{ @btnExit }} \n{{ @btnElab }} \n{{ btnElab }}\n{{ btnExit }}\n{{ RTEsci }}\n{{ RTExec }}\n{{ pLog }}\n{{ pMsg }}\n{{ RTClean }}\n{{ DaDatOpe }}\n{{ ADatOpe }}\n{{ lblDaOpe }}\n{{ lblAOpe }}\n{{ flgncf }}\n{{ iPrint }}\n{{ daCal }}\n{{ ACal }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"310\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","rapp":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"725","y":"16","zindex":"1","zone":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"230","zindex":"3","zone":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","rapp":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"16","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"63","x":"3","y":"-67"},{"allowedentities":"arrt_oam_chkperiodo","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"RTExec","offline":"false","page":"1","parms":"w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_flgncf=flgncf","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"arrt_oam_chkperiodo","target":"iPrint","type":"SPLinker","w":"75","x":"73","y":"-67"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"DaDatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"123","wireframe_props":"name","x":"135","y":"21","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"ADatOpe","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"date","typevar":"date","visible":"true","w":"123","wireframe_props":"name","x":"426","y":"21","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Informazione:","w":"129","wireframe_props":"align,value,n_col","x":"4","y":"24","zindex":"1","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"295","y":"24","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Escludi possibili C.F. Errati (non bloccante)","layer":"false","layout_steps_values":"{}","name":"flgncf","page":"1","rapp":"","sequence":"12","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"314","wireframe_props":"label_text","x":"135","y":"53","zindex":"4","zone":""},{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"150","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"13","spuid":"","type":"Iframe","w":"800","wireframe_props":"","x":"0","y":"79","zindex":"9","zone":""}]%>
<%/*Description:Controlli Periodali*/%>
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
window.pg_oam_chkperiodo_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Controlli Periodali",true)
  this.getTitlePortlet().SetSubTitle("",true)
}
function btnElab_Click(){
  if (confirm("Confermi la stampa?")) {
    this.PortletLogs.Start();      
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.PortletLogs.Stop();        
  alert("Elaborazione Completata!");
}
function btnExit_Click(){ 
  this.RTEsci.Link();
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
.pg_oam_chkperiodo_container {
}
.pg_oam_chkperiodo_title_container {
  margin: auto;
}
.pg_oam_chkperiodo_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:310px;
}
.pg_oam_chkperiodo_portlet[Data-page="1"]{
  height:310px;
  width:100%;
}
.pg_oam_chkperiodo_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  right:45px;
  width:30px;
  height:30px;
}
.pg_oam_chkperiodo_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_oam_chkperiodo_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:230px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
}
.pg_oam_chkperiodo_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_oam_chkperiodo_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_oam_chkperiodo_portlet > .DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:21px;
  left:135px;
  width:123px;
  height:20px;
}
.pg_oam_chkperiodo_portlet > .DaDatOpe_ctrl {
}
.pg_oam_chkperiodo_portlet > .DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oam_chkperiodo_portlet > .ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:21px;
  left:426px;
  width:123px;
  height:20px;
}
.pg_oam_chkperiodo_portlet > .ADatOpe_ctrl {
}
.pg_oam_chkperiodo_portlet > .ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_oam_chkperiodo_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:24px;
  left:4px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_oam_chkperiodo_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_oam_chkperiodo_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_oam_chkperiodo_portlet > .lblAOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:24px;
  left:295px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_oam_chkperiodo_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_oam_chkperiodo_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_oam_chkperiodo_portlet > .flgncf_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:53px;
  left:135px;
  width:314px;
  height:20px;
}
.pg_oam_chkperiodo_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:79px;
  left:0px;
  right:0px;
  width:auto;
  height:150px;
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
 String def="[{\"h\":\"310\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"725\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"230\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"16\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"63\",\"x\":\"3\",\"y\":\"-67\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"123\",\"x\":\"135\",\"y\":\"21\",\"zindex\":\"2\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"123\",\"x\":\"426\",\"y\":\"21\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Informazione:\",\"w\":\"129\",\"x\":\"4\",\"y\":\"24\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"129\",\"x\":\"295\",\"y\":\"24\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Escludi possibili C.F. Errati (non bloccante)\",\"layout_steps_values\":{},\"name\":\"flgncf\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"314\",\"x\":\"135\",\"y\":\"53\",\"zindex\":\"4\"},{\"anchor\":\"top-left-right\",\"h\":\"150\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"800\",\"x\":\"0\",\"y\":\"79\",\"zindex\":\"9\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_oam_chkperiodo","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_oam_chkperiodo_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_oam_chkperiodo','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date DaDatOpe= JSPLib.NullDate();
if(request.getAttribute("pg_oam_chkperiodo_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date ADatOpe= JSPLib.NullDate();
String lblDaOpe= "Da Data Informazione:";
String lblAOpe= "A Data Operazione:";
String flgncf="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_oam_chkperiodo_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_oam_chkperiodo_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_oam_chkperiodo_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_oam_chkperiodo','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<span class='textbox-container'id='<%=idPortlet%>_DaDatOpe_wrp'><input id='<%=idPortlet%>_DaDatOpe' name='DaDatOpe' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='DaDatOpe' /></span>
<span class='textbox-container'id='<%=idPortlet%>_ADatOpe_wrp'><input id='<%=idPortlet%>_ADatOpe' name='ADatOpe' type='date' class='textbox' formid='<%=idPortlet%>' ps-name='ADatOpe' /></span>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Informazione:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe'  formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<div id='<%=idPortlet%>_flgncf_div' style=''><input id='<%=idPortlet%>_flgncf' name='flgncf' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgncf' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Escludi possibili C.F. Errati (non bloccante)")%></label></div>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_oam_chkperiodo');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_oam_chkperiodo',["800"],["310"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"310","title":"","layer":""}]);
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":725,"y":16,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":230,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":16,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":63,"x":3,"y":-67});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_oam_chkperiodo",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_DaDatOpe=DaDatOpe,w_ADatOpe=ADatOpe,w_flgncf=flgncf","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_oam_chkperiodo","target":"iPrint","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_oam_chkperiodo",request.getSession())%>';
this.DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=DaDatOpe%>","w":123,"x":135,"y":21,"zerofilling":false,"zindex":"2","zoom":""});
this.ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"date","typevar":"date","value":"<%=ADatOpe%>","w":123,"x":426,"y":21,"zerofilling":false,"zindex":"2","zoom":""});
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":129,"x":4,"y":24,"zindex":"1"});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":129,"x":295,"y":24,"zindex":"1"});
this.flgncf=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgncf","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Escludi possibili C.F. Errati (non bloccante)","layer":false,"layout_steps_values":{},"name":"flgncf","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":314,"x":135,"y":53,"zindex":"4"});
this.flgncf.Value('<%=flgncf%>');
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":150,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":800,"x":0,"y":79,"zindex":"9"});
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
<%if(request.getAttribute("pg_oam_chkperiodo_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_oam_chkperiodo_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_oam_chkperiodo_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_oam_chkperiodo',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_oam_chkperiodo');
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
sp.endPage("pg_oam_chkperiodo");
}%>
<%! public String getJSPUID() { return "2550190864"; } %>