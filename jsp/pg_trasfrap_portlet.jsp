<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Elabora_Click(){\n  if (confirm(\"Confermi il traferimento delle operazioni?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTTrasferisci.Link()   \n  }  \n}\n\nfunction Uscita_Click() {\n  this.BtnUscita.Link()\n}  \n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"TRASFERIMENTO RAPPORTI DA PROVVISORIO AD AUI\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n  this.RTAzzera.Link();\n}\n\nfunction RTTrasferisci_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop();\n  alert('Elaborazione Terminata!');  \n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Controllo di Gestione","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"260","hsl":"","htmlcode":"{{ pMsg }}\n{{ Elabora }}\n{{ Uscita }}\n{{ BtnUscita }}\n{{ RTTrasferisci }}\n{{ pLog }}\n{{ RTAzzera }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"Utilities.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"90","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","h":"58","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"1","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"90","wireframe_props":"","x":"0","y":"194","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Trasferisce rapporti da provvisorio ad AUI","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Elabora","page":"1","path_type":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fprinter.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"2","y":"8","zindex":"0"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la maschera","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Uscita","page":"1","path_type":"","sequence":"3","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"46","y":"8","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"93","x":"134","y":"-60"},{"allowedentities":"","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTTrasferisci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_trasfrap","target":"","type":"SPLinker","w":"147","x":"238","y":"-60"},{"anchor":"top-left-right","h":"143","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"6","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"90","wireframe_props":"","x":"0","y":"48","zindex":"3"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"4","y":"-60"}]%>
<%/*Description:Controllo di Gestione*/%>
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
window.pg_trasfrap_Static=function(){
if(typeof Elabora_Click !='undefined')this.Elabora_Click=Elabora_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTTrasferisci_Result !='undefined')this.RTTrasferisci_Result=RTTrasferisci_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function Elabora_Click(){
  if (confirm("Confermi il traferimento delle operazioni?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTTrasferisci.Link()   
  }  
}
function Uscita_Click() {
  this.BtnUscita.Link()
}  
function this_Loaded(){
  this.getTitlePortlet().SetTitle("TRASFERIMENTO RAPPORTI DA PROVVISORIO AD AUI",true)
  this.getTitlePortlet().SetSubTitle("",true)
  this.RTAzzera.Link();
}
function RTTrasferisci_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop();
  alert('Elaborazione Terminata!');  
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
.pg_trasfrap_container {
}
.pg_trasfrap_title_container {
  margin: auto;
}
.pg_trasfrap_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:90px;
  height:260px;
  background-color:#FFFFFF;
}
.pg_trasfrap_portlet[Data-page="1"]{
  height:260px;
  width:100%;
}
.pg_trasfrap_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:194px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:58px;
}
.pg_trasfrap_portlet > .Elabora_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:8px;
  right:58px;
  width:30px;
  height:30px;
}
.pg_trasfrap_portlet > .Elabora_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_trasfrap_portlet > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:14px;
  width:30px;
  height:30px;
}
.pg_trasfrap_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_trasfrap_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:48px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:143px;
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
 String def="[{\"h\":\"260\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"90\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"58\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"90\",\"x\":\"0\",\"y\":\"194\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"2\",\"y\":\"8\",\"zindex\":\"0\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"46\",\"y\":\"8\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"93\",\"x\":\"134\",\"y\":\"-60\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"238\",\"y\":\"-60\"},{\"anchor\":\"top-left-right\",\"h\":\"143\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"90\",\"x\":\"0\",\"y\":\"48\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"4\",\"y\":\"-60\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_trasfrap","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_trasfrap_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("Utilities.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_trasfrap','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_trasfrap_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_trasfrap_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_trasfrap_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_trasfrap','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<a id='<%=idPortlet%>_Elabora' class='image Elabora_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_trasfrap');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_trasfrap',["90"],["260"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"90","h":"260","title":"","layer":"false","npage":"1"}]);
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_pMsg","h":58,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":90,"x":0,"y":194,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.Elabora=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Elabora_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Elabora","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Trasferisce rapporti da provvisorio ad AUI",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Elabora","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":2,"y":8,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la maschera",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Uscita","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":46,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":93,"x":134,"y":-60});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTTrasferisci=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTTrasferisci","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTTrasferisci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_trasfrap","target":"","type":"SPLinker","w":147,"x":238,"y":-60});
this.RTTrasferisci.m_cID='<%=JSPLib.cmdHash("routine,arrt_trasfrap",request.getSession())%>';
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":90,"x":0,"y":48,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":4,"y":-60});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
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
<%if(request.getAttribute("pg_trasfrap_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_trasfrap_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_trasfrap_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Elabora.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_trasfrap',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_trasfrap');
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
sp.endPage("pg_trasfrap");
}%>
<%! public String getJSPUID() { return "188462454"; } %>