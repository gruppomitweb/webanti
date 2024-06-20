<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Timer0_onTimer(){this.fnlog.Link();}\n\nfunction Calculate(param){this.Timer0.Start();}\n\nfunction lancia(){this.Timer0.Start();}\n\nfunction Image_zoom_Click(event){this.SPLinker_showlog_zoom.Link();}\n\nfunction Image_Print_Click(event){this.SPLinker_fn_save_file_log.Link();}\n\nfunction SPLinker_fn_save_file_log_Result(result){\n  if(Empty(result)){\n    alert('Riscontrata anomalia nel generare il file');\n  }else{\n    this.SPLinker_scarica.Servlet(result.replace(this.gPathApp.Value(),\"..\"));\n    this.SPLinker_scarica.Link();\n  }\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"1","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"Mostra il log dell'applicativo","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @label2 }}{{ @Messaggio }}{{ @Image6 }}{{ @Image9 }}{{ @label_messaggio }}{{ @Image_Print }}{{ @Image_zoom }}\u003c\u002fbody\u003e","grapesCss":"","h":"44","hsl":"","htmlcode":"{{ @label_messaggio }} \n{{ @Image_zoom }} \n{{ @Messaggio }}\n{{ @label_messaggio{{ @Image_Print }} \n }}\n{{ label2 }}\n{{ fnlog }}\n{{ Messaggio }}\n{{ Timer0 }}\n \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"Mostra il log dell'applicativo\",\"layer\":\"\",\"h\":\"44\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"Mostra il log dell'applicativo","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"1","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"100","version":"37","w":"100%","wizard":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"rgba(3, 53, 255, 0.5)","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","fixed":"","font":"","font_color":"#F2F202","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_messaggio","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"LOG ELABORAZIONE","w":"100","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1","zone":""},{"anchor":"top-left(%)-right(%)-bottom","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Messaggio","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"true","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"100","wireframe_props":"name","x":"0","y":"20","zerofilling":"false","zindex":"2","zone":"","zoom":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#F2F202","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"Salva il log in un file txt","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_Print","page":"1","path_type":"fixed","rapp":"","sequence":"3","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"56","y":"0","zindex":"3","zone":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"#F2F202","font_color_hover":"","font_image":"&#xebee;","font_image_hover":"&#xebef;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"Apri uno zoom del log","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image_zoom","page":"1","path_type":"fixed","rapp":"","sequence":"4","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"78","y":"0","zindex":"4","zone":""},{"allowedentities":"arfn_msg_alllog","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"24","m_cAction":"function","name":"fnlog","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arfn_msg_alllog","target":"Messaggio","type":"SPLinker","w":"63","x":"2","y":"62"},{"allowedentities":"showlog_zoom_portlet.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"SPLinker_showlog_zoom","offline":"false","page":"1","parms":"Messaggio","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"showlog_zoom_portlet.jsp","target":"","type":"SPLinker","w":"170","x":"121","y":"-2"},{"allowedentities":"fn_save_file_log","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPLinker_fn_save_file_log","offline":"false","page":"1","parms":"Messaggio","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"fn_save_file_log","target":"","type":"SPLinker","w":"170","x":"121","y":"19"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gPathApp","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"170","x":"121","y":"40"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"SPLinker_scarica","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"","target":"","type":"SPLinker","w":"170","x":"121","y":"61"},{"delay":"","duration":"","h":"24","interval":"800","name":"Timer0","page":"1","repeated":"true","rounds":"","start_activated":"false","type":"Timer","w":"66","x":"2","y":"91"}]%>
<%/*Description:Mostra il log dell'applicativo*/%>
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
window.showlog_Static=function(){
if(typeof Timer0_onTimer !='undefined')this.Timer0_onTimer=Timer0_onTimer;
if(typeof Calculate !='undefined')this.Calculate=Calculate;
if(typeof lancia !='undefined')this.lancia=lancia;
if(typeof Image_zoom_Click !='undefined')this.Image_zoom_Click=Image_zoom_Click;
if(typeof Image_Print_Click !='undefined')this.Image_Print_Click=Image_Print_Click;
if(typeof SPLinker_fn_save_file_log_Result !='undefined')this.SPLinker_fn_save_file_log_Result=SPLinker_fn_save_file_log_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function Timer0_onTimer(){this.fnlog.Link();}
function Calculate(param){this.Timer0.Start();}
function lancia(){this.Timer0.Start();}
function Image_zoom_Click(event){this.SPLinker_showlog_zoom.Link();}
function Image_Print_Click(event){this.SPLinker_fn_save_file_log.Link();}
function SPLinker_fn_save_file_log_Result(result){
  if(Empty(result)){
    alert('Riscontrata anomalia nel generare il file');
  }else{
    this.SPLinker_scarica.Servlet(result.replace(this.gPathApp.Value(),".."));
    this.SPLinker_scarica.Link();
  }
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
.showlog_container {
  height:100%;
  overflow:auto;
}
.showlog_title_container {
  margin: auto;
}
.showlog_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:100px;
  height:100%;
  background-color:#F3F3F3;
}
.showlog_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.showlog_portlet > .label_messaggio_ctrl {
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
.showlog_portlet > .label_messaggio_ctrl {
  height:auto;
  min-height:20px;
}
.showlog_portlet > .label_messaggio_ctrl {
  overflow:hidden;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:rgba(3, 53, 255, 0.5);
}
.showlog_portlet > .Messaggio_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:4px;
  width:auto;
}
.showlog_portlet > .Messaggio_ctrl {
}
.showlog_portlet > .Messaggio_ctrl > textarea{
  z-index:1;
  box-sizing:border-box;
  font-size:7pt;
  width:100%;
  height:100%;
}
.showlog_portlet > .Image_Print_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:0px;
  right:24px;
  width:20px;
  height:20px;
}
.showlog_portlet > .Image_Print_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#F2F202;
}
.showlog_portlet > .Image_zoom_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:0px;
  right:2px;
  width:20px;
  height:20px;
}
.showlog_portlet > .Image_zoom_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
  color:#F2F202;
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
 String def="[{\"h\":\"44\",\"layout_steps_values\":{},\"pages_names\":\"Mostra il log dell'applicativo\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"100\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"LOG ELABORAZIONE\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Messaggio\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"100\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Image_Print\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"56\",\"y\":\"0\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Image_zoom\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"78\",\"y\":\"0\",\"zindex\":\"4\"},{\"h\":\"24\",\"name\":\"fnlog\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"63\",\"x\":\"2\",\"y\":\"62\"},{\"h\":\"20\",\"name\":\"SPLinker_showlog_zoom\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"121\",\"y\":\"-2\"},{\"h\":\"20\",\"name\":\"SPLinker_fn_save_file_log\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"121\",\"y\":\"19\"},{\"h\":\"20\",\"name\":\"gPathApp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"170\",\"x\":\"121\",\"y\":\"40\"},{\"h\":\"20\",\"name\":\"SPLinker_scarica\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"170\",\"x\":\"121\",\"y\":\"61\"},{\"h\":\"24\",\"name\":\"Timer0\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"66\",\"x\":\"2\",\"y\":\"91\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"showlog","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;

String cache_content=null;
String cache_key=null;
if(!request.getMethod().equals("POST")) {
cache_key=sp.getCacheKey(request, m_cJSPUID);
for(int i=50;cache_content==null && i>0;i--){
  cache_content=Library.GetCachedJSPContent(cache_key);
  if("*rendering*".equals(cache_content)) {
    cache_content=null;
    Thread.currentThread().sleep(100);
  } else {
    i=0;
  }
}
}
if(cache_content!=null){
  out.print(cache_content);
}else{
  javax.servlet.jsp.tagext.BodyContent bc=null;
  if(cache_key!=null){
    bc=pageContext.pushBody();
    Library.PutCachedJSPContent(cache_key,"*rendering*",1);
    out = bc;
  }

if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/showlog_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','showlog','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label_messaggio= "LOG ELABORAZIONE";
String Messaggio= "";
if(request.getAttribute("showlog_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String gPathApp=sp.getGlobal("gPathApp","");
if(request.getAttribute("showlog_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("TimerObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}
response.setHeader("Cache-Control","max-age = 1");
response.setDateHeader("Expires",System.currentTimeMillis() + 1*1000);%>
<div id='<%=idPortlet%>_container' class='showlog_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='showlog_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('showlog','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_label_messaggio'  formid='<%=idPortlet%>' ps-name='label_messaggio'    class='label label_messaggio_ctrl'><div id='<%=idPortlet%>_label_messaggiotbl' style='width:100%;'><%=JSPLib.ToHTML("LOG ELABORAZIONE")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_Messaggio_wrp'><textarea id='<%=idPortlet%>_Messaggio' name='Messaggio' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='Messaggio'    ></textarea></span>
<a id='<%=idPortlet%>_Image_Print' class='image-default Image_Print_ctrl'   target=''>&#xeb36;</a>
<a id='<%=idPortlet%>_Image_zoom' class='image-default Image_zoom_ctrl'   target=''>&#xebee;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','showlog');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','showlog',["100"],["44"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"100","h":"44","title":"Mostra il log dell'applicativo","layer":""}]);
this.label_messaggio=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_messaggio","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"#F2F202","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_messaggio","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label_messaggio,false,true)%>","type":"Label","w":100,"x":0,"y":0,"zindex":"1"});
this.Messaggio=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)-bottom","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Messaggio","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Messaggio","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Messaggio,false,true)%>","w":100,"x":0,"y":20,"zerofilling":false,"zindex":"2","zoom":""});
this.Image_Print=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image-default Image_Print_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_Print","edit_undercond":"","field":"","font_color":"#F2F202","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("Salva il log in un file txt",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_Print","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"&#xeb36;","srchover":"&#xeb37;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":56,"y":0,"zindex":"3"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Image_zoom=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image-default Image_zoom_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_zoom","edit_undercond":"","field":"","font_color":"#F2F202","font_color_hover":"","font_image":"&#xebee;","font_image_hover":"&#xebef;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("Apri uno zoom del log",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_zoom","page":1,"path_type":"fixed","server_side":"","spuid":"","src":"&#xebee;","srchover":"&#xebef;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":78,"y":0,"zindex":"4"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.fnlog=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_msg_alllog",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_fnlog","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":24,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"fnlog","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_msg_alllog","target":"Messaggio","type":"SPLinker","w":63,"x":2,"y":62});
this.fnlog.m_cID='<%=JSPLib.cmdHash("routine,arfn_msg_alllog",request.getSession())%>';
this.SPLinker_showlog_zoom=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("showlog_zoom_portlet.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_showlog_zoom","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_showlog_zoom","offline":false,"page":1,"parms":"Messaggio","popup":"true","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"showlog_zoom_portlet.jsp","target":"","type":"SPLinker","w":170,"x":121,"y":-2});
this.SPLinker_showlog_zoom.m_cID='<%=JSPLib.cmdHash("entity,showlog_zoom_portlet.jsp",request.getSession())%>';
this.SPLinker_fn_save_file_log=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("fn_save_file_log",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_fn_save_file_log","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_fn_save_file_log","offline":false,"page":1,"parms":"Messaggio","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"","progressbar":false,"refresh":"","servlet":"fn_save_file_log","target":"","type":"SPLinker","w":170,"x":121,"y":19});
this.SPLinker_fn_save_file_log.m_cID='<%=JSPLib.cmdHash("routine,fn_save_file_log",request.getSession())%>';
this.gPathApp=new ZtVWeb._VC(this,'gPathApp',null,'character','<%=JSPLib.ToJSValue(gPathApp,false,true)%>',false,false);
this.SPLinker_scarica=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_scarica","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_scarica","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":170,"x":121,"y":61});
this.SPLinker_scarica.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Timer0=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_Timer0","delay":"","duration":"","h":24,"hide":"false","interval":"800","layer":false,"layout_steps_values":{},"name":"Timer0","page":1,"repeated":"true","rounds":"","start_activated":"false","type":"Timer","w":66,"x":2,"y":91});
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
<%if(request.getAttribute("showlog_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("showlog_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.showlog_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image_Print.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Image_zoom.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','showlog',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'showlog');
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
sp.endPage("showlog");

  if(cache_key!=null){
    cache_content = bc.getString();
    Library.PutCachedJSPContent(cache_key,cache_content,1);
    out = pageContext.popBody();
    out.print(cache_content);
  }
}

}%>
<%! public String getJSPUID() { return "1984121493"; } %>