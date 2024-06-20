<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var notifications, nmess_read, nmess_noread, esegui;\n\u002f\u002f var letti, noletti;\n\nfunction splinker_fn_mess_status_Result(_testo){\n    \n  this.LblMenu.Value('')\n  this.LblMenu.Value('\u003cul class=\"ttw-notification-menu\"\u003e\u003cli id=\"Da_Completare\" class=\"notification-menu-item first-item\"\u003e\u003ca href=\"..\u002fjsp\u002fpg_cgo_operazioni_agenzie_portlet.jsp?m_cWindowName=main\" target=\"main\"\u003eOperazioni Da Completare\u003c\u002fa\u003e\u003c\u002fli\u003e\u003cli id=\"Nuove_Operazioni\" class=\"notification-menu-item\"\u003e\u003ca href=\"..\u002fjsp\u002fpg_cgo_operazioni_agenzie_dl_portlet.jsp?m_cWindowName=main\" target=\"main\"\u003eNuove Operazioni da Ultimare\u003c\u002fa\u003e\u003c\u002fli\u003e\u003cli id=\"Operazioni_Multiple\" class=\"notification-menu-item last-item\"\u003e\u003ca href=\"..\u002fjsp\u002fpg_cgo_operazioni_agenzie_dl_multipli_portlet.jsp?m_cWindowName=main\" target=\"main\"\u003eOperazioni Multiple da ultimare\u003c\u002fa\u003e\u003c\u002fli\u003e\u003c\u002ful\u003e');\n  notifications.initMenu({ mdc:'#Da_Completare', mno:'#Nuove_Operazioni', mom:'#Operazioni_Multiple'});\n  this.mRitorno.Value(_testo);\n  if (this.mRitorno.RecCount() \u003e 0) {\n    this.mRitorno.GoTo(1);\n    while (!(this.mRitorno.Eof())) {\n      if (this.mRitorno.Get(\"tipo\")==\"dc\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        for (i = 0; i \u003c _conta; i++) { \n         notifications.createNotification({ message:\"Da completare\", category:'mdc'});\n        }\n      }\n      if (this.mRitorno.Get(\"tipo\")==\"no\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        for (i = 0; i \u003c _conta; i++) { \n         notifications.createNotification({ message:\"Nuove operazioni\", category:'mno'});\n        }\n      }\n      if (this.mRitorno.Get(\"tipo\")==\"om\"){\n        _conta=this.mRitorno.Get(\"numero\")\n        for (i = 0; i \u003c _conta; i++) { \n         notifications.createNotification({ message:\"Operazioni Multiple\", category:'mom'});\n        }\n      }       \n      this.mRitorno.Next();\n    }\n  }\n}\n\n\nfunction Timer0_onTimer(){\n\u003c%\nif(sp.isInGroup(6)){\n%\u003e\n  notifications = new $.ttwNotificationMenu();\n  this.splinker_fn_mess_status.Link();\n\u003c%\n}\n%\u003e  \n}\n\nfunction Timer4_onTimer(){\n  esegui=true;\n}\n  \nfunction this_Loaded(){\n\u003c%\nif(sp.isInGroup(6)){\n%\u003e  \n  esegui=true;\n  this.Timer0.Start();\n  this.Timer0_onTimer();  \n\u003c%\n}\n%\u003e  \n}\n\nfunction LblMenu_Click(){ \n\u003c%\nif(sp.isInGroup(6)){\n%\u003e  \n   this.Timer0_onTimer(); \n\u003c%\n}\n%\u003e  \n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"jquery.toast.css,style_light.css","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"20","hsl":"","htmlcode":"{{ @LblMenu }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"notifit\u002fjquery.js,notifit\u002fjquery-ui.js,notifit\u002fjs\u002fnotify.js,jquery.toast.js,ttw-notification-menu.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"675","version":"37","w":"100%","wizard":""},{"align":"","anchor":"top-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"15","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LblMenu","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"675","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"6"},{"auto_create":"","ctrlOfVariant":"","fields":"","h":"30","name":"mRitorno","page":"1","sequence":"2","type":"MemoryCursor","types":"","w":"30","x":"49","y":"-36"},{"allowedentities":"","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"splinker_fn_mess_status","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"arfn_nuovi_alert","target":"","type":"SPLinker","w":"30","x":"129","y":"-36"},{"delay":"0","duration":"","h":"30","interval":"5000","name":"Timer4","page":"1","repeated":"true","rounds":"","start_activated":"","type":"Timer","w":"74","x":"172","y":"-38"},{"delay":"","duration":"","h":"30","interval":"30000","name":"Timer0","page":"1","repeated":"true","rounds":"","start_activated":"true","type":"Timer","w":"30","x":"89","y":"-36"}]%>
<%/*Description:*/%>
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
.pg_operaz_msg_container {
}
.pg_operaz_msg_title_container {
  margin: auto;
}
.pg_operaz_msg_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:675px;
  height:20px;
}
.pg_operaz_msg_portlet[Data-page="1"]{
  height:20px;
  width:100%;
}
.pg_operaz_msg_portlet > .LblMenu_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:0px;
  right:0px;
  width:675px;
  height:auto;
  min-height:15px;
}
.pg_operaz_msg_portlet > .LblMenu_ctrl {
  height:auto;
  min-height:15px;
}
.pg_operaz_msg_portlet > .LblMenu_ctrl {
  overflow:hidden;
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
 String def="[{\"h\":\"20\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"675\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"\",\"anchor\":\"top-right\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"675\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"6\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"MemoryCursor\",\"w\":\"30\",\"x\":\"49\",\"y\":\"-36\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"129\",\"y\":\"-36\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"74\",\"x\":\"172\",\"y\":\"-38\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"30\",\"x\":\"89\",\"y\":\"-36\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_operaz_msg","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_operaz_msg_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("jquery.toast.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("jquery.toast.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("jquery.toast.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/jquery.toast.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("style_light.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("style_light.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("style_light.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/style_light.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("notifit/jquery.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("notifit/jquery-ui.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("notifit/js/notify.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("jquery.toast.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("ttw-notification-menu.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_operaz_msg','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String LblMenu= "";
if(request.getAttribute("pg_operaz_msg_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
if(request.getAttribute("pg_operaz_msg_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("TimerObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_operaz_msg_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_operaz_msg_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_operaz_msg','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_LblMenu'  formid='<%=idPortlet%>' ps-name='LblMenu'    class='label LblMenu_ctrl'><div id='<%=idPortlet%>_LblMenutbl' style='width:100%;'></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_operaz_msg');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_operaz_msg',["675"],["20"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"675","h":"20","title":"","layer":"false","npage":"1"}]);
this.LblMenu=new ZtVWeb._LC(this,{"align":"","anchor":"top-right","assoc_input":"","calculate":"","class_Css":"","create_undercond":"","ctrlid":"<%=idPortlet%>_LblMenu","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":15,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LblMenu","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LblMenu,false,true)%>","type":"Label","w":675,"x":0,"y":0,"zindex":"6"});
this.mRitorno=new ZtVWeb.MemoryCursorCtrl(this,'mRitorno','<%=idPortlet%>_mRitorno','','','','','false');
this.splinker_fn_mess_status=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_fn_mess_status","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_fn_mess_status","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_nuovi_alert","target":"","type":"SPLinker","w":30,"x":129,"y":-36});
this.splinker_fn_mess_status.m_cID='<%=JSPLib.cmdHash("routine,arfn_nuovi_alert",request.getSession())%>';
this.Timer4=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_Timer4","delay":"0","duration":"","h":30,"hide":"false","interval":"5000","layer":false,"layout_steps_values":{},"name":"Timer4","page":1,"repeated":"true","rounds":"","start_activated":"","type":"Timer","w":74,"x":172,"y":-38});
this.Timer0=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_Timer0","delay":"","duration":"","h":30,"hide":"false","interval":"30000","layer":false,"layout_steps_values":{},"name":"Timer0","page":1,"repeated":"true","rounds":"","start_activated":"true","type":"Timer","w":30,"x":89,"y":-36});
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
<%request.setAttribute("pg_operaz_msg_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.pg_operaz_msg_Static=function(){
if(typeof splinker_fn_mess_status_Result !='undefined')this.splinker_fn_mess_status_Result=splinker_fn_mess_status_Result;
if(typeof Timer0_onTimer !='undefined')this.Timer0_onTimer=Timer0_onTimer;
if(typeof Timer4_onTimer !='undefined')this.Timer4_onTimer=Timer4_onTimer;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LblMenu_Click !='undefined')this.LblMenu_Click=LblMenu_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var notifications, nmess_read, nmess_noread, esegui;
// var letti, noletti;
function splinker_fn_mess_status_Result(_testo){
    
  this.LblMenu.Value('')
  this.LblMenu.Value('<ul class="ttw-notification-menu"><li id="Da_Completare" class="notification-menu-item first-item"><a href="../jsp/pg_cgo_operazioni_agenzie_portlet.jsp?m_cWindowName=main" target="main">Operazioni Da Completare</a></li><li id="Nuove_Operazioni" class="notification-menu-item"><a href="../jsp/pg_cgo_operazioni_agenzie_dl_portlet.jsp?m_cWindowName=main" target="main">Nuove Operazioni da Ultimare</a></li><li id="Operazioni_Multiple" class="notification-menu-item last-item"><a href="../jsp/pg_cgo_operazioni_agenzie_dl_multipli_portlet.jsp?m_cWindowName=main" target="main">Operazioni Multiple da ultimare</a></li></ul>');
  notifications.initMenu({ mdc:'#Da_Completare', mno:'#Nuove_Operazioni', mom:'#Operazioni_Multiple'});
  this.mRitorno.Value(_testo);
  if (this.mRitorno.RecCount() > 0) {
    this.mRitorno.GoTo(1);
    while (!(this.mRitorno.Eof())) {
      if (this.mRitorno.Get("tipo")=="dc"){
        _conta=this.mRitorno.Get("numero")
        for (i = 0; i < _conta; i++) { 
         notifications.createNotification({ message:"Da completare", category:'mdc'});
        }
      }
      if (this.mRitorno.Get("tipo")=="no"){
        _conta=this.mRitorno.Get("numero")
        for (i = 0; i < _conta; i++) { 
         notifications.createNotification({ message:"Nuove operazioni", category:'mno'});
        }
      }
      if (this.mRitorno.Get("tipo")=="om"){
        _conta=this.mRitorno.Get("numero")
        for (i = 0; i < _conta; i++) { 
         notifications.createNotification({ message:"Operazioni Multiple", category:'mom'});
        }
      }       
      this.mRitorno.Next();
    }
  }
}
function Timer0_onTimer(){
<%
if(sp.isInGroup(6)){
%>
  notifications = new $.ttwNotificationMenu();
  this.splinker_fn_mess_status.Link();
<%
}
%>  
}
function Timer4_onTimer(){
  esegui=true;
}
  
function this_Loaded(){
<%
if(sp.isInGroup(6)){
%>  
  esegui=true;
  this.Timer0.Start();
  this.Timer0_onTimer();  
<%
}
%>  
}
function LblMenu_Click(){ 
<%
if(sp.isInGroup(6)){
%>  
   this.Timer0_onTimer(); 
<%
}
%>  
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.pg_operaz_msg_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_operaz_msg',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_operaz_msg');
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
sp.endPage("pg_operaz_msg");
}%>
<%! public String getJSPUID() { return "2625320771"; } %>