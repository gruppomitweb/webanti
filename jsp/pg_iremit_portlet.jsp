<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Allinea Causali IRemit\",true)  \n}\n\nfunction image_esegui_Click(){\n  this.Portlet_showlog.Timer0.Start();\n  this.Portlet_showmsg.Timer0.Start();\n  this.RTIRemit.Link();\n}\n\nfunction RTIRemit_Response(cMsg){\n  alert(cError)  \n\u002f\u002f  this.Portlet_showlog.Timer0_onTimer();\n\u002f\u002f  this.Portlet_showmsg.Timer0_onTimer();\n\u002f\u002f  this.Portlet_showlog.Timer0.Stop();\n\u002f\u002f  this.Portlet_showmsg.Timer0.Stop();  \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"","htmlcode":"{{ dir }}\n{{ RTIRemit }}\n{{ RTSaveFile }}\n{{ nomefile }}\n{{ RTUpload }}\n{{ image_esegui }}\n{{ Portlet_showlog }}\n{{ Portlet_showmsg }}\n{{ image_upload }}\n{{ gAzienda }}\n{{ Event_filename }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"300\",\"w\":\"100%\"},\"480\":{\"h\":\"300\",\"w\":\"100%\"},\"768\":{\"h\":\"300\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"allowedentities":"allinea_iremit","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"async routine","name":"RTIRemit","offline":"false","page":"1","parms":"","popup":"false","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":"","refresh":"","sequence":"1","servlet":"allinea_iremit","target":"","type":"SPLinker","w":"261","x":"800","y":"56"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{\"320\":{\"x\":230,\"y\":44,\"w\":37,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"340\":{\"x\":244,\"y\":44,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":345,\"y\":44,\"w\":55,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":727,\"y\":5,\"w\":33,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"image_esegui","page":"1","path_type":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"33","wireframe_props":"","x":"727","y":"5","zindex":"1"},{"anchor":"top-left-right","h":"150","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":76,\"w\":\"318\",\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"340\":{\"x\":1,\"y\":76,\"w\":\"338\",\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":76,\"w\":\"478\",\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"768\":{\"x\":1,\"y\":45,\"w\":766,\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"}}","name":"Portlet_showlog","page":"1","sequence":"3","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"766","wireframe_props":"","x":"1","y":"45","zindex":""},{"anchor":"top-left-right","h":"70","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":227,\"w\":\"318\",\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"340\":{\"x\":1,\"y\":227,\"w\":\"338\",\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":227,\"w\":\"478\",\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"768\":{\"x\":1,\"y\":196,\"w\":766,\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"}}","name":"Portlet_showmsg","page":"1","sequence":"4","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"766","wireframe_props":"","x":"1","y":"196","zindex":""}]%>
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
window.pg_iremit_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof image_esegui_Click !='undefined')this.image_esegui_Click=image_esegui_Click;
if(typeof RTIRemit_Response !='undefined')this.RTIRemit_Response=RTIRemit_Response;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Allinea Causali IRemit",true)  
}
function image_esegui_Click(){
  this.Portlet_showlog.Timer0.Start();
  this.Portlet_showmsg.Timer0.Start();
  this.RTIRemit.Link();
}
function RTIRemit_Response(cMsg){
  alert(cError)  
//  this.Portlet_showlog.Timer0_onTimer();
//  this.Portlet_showmsg.Timer0_onTimer();
//  this.Portlet_showlog.Timer0.Stop();
//  this.Portlet_showmsg.Timer0.Stop();  
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
.pg_iremit_container {
}
.pg_iremit_title_container {
  margin: auto;
}
.pg_iremit_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:300px;
  background-color:#FFFFFF;
}
.pg_iremit_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.pg_iremit_portlet[Data-step="320"] {
  height:300px;
  width:100%;
}
.pg_iremit_portlet[Data-step="480"] {
  height:300px;
  width:100%;
}
.pg_iremit_portlet[Data-step="768"] {
  height:300px;
  width:100%;
}
.pg_iremit_portlet[Data-step="320"] > .image_esegui_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:230px;
  left:71.875%;
  right:53px;
  right:16.5625%;
  width:auto;
  height:30px;
}
.pg_iremit_portlet[Data-step="480"] > .image_esegui_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:345px;
  left:71.875%;
  right:80px;
  right:16.666666%;
  width:auto;
  height:30px;
}
.pg_iremit_portlet[Data-step="768"] > .image_esegui_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  right:8px;
  width:33px;
  height:30px;
}
.pg_iremit_portlet > .image_esegui_ctrl {
}
.pg_iremit_portlet > .image_esegui_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.pg_iremit_portlet[Data-step="320"] > .Portlet_showlog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:76px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_iremit_portlet[Data-step="480"] > .Portlet_showlog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:76px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_iremit_portlet[Data-step="768"] > .Portlet_showlog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_iremit_portlet[Data-step="320"] > .Portlet_showmsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:227px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:70px;
}
.pg_iremit_portlet[Data-step="480"] > .Portlet_showmsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:227px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:70px;
}
.pg_iremit_portlet[Data-step="768"] > .Portlet_showmsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:196px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:70px;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{\"320\":{\"h\":\"300\",\"w\":\"100%\"},\"480\":{\"h\":\"300\",\"w\":\"100%\"},\"768\":{\"h\":\"300\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"261\",\"x\":\"800\",\"y\":\"56\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":37,\"x\":230,\"y\":44},\"340\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":244,\"y\":44},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":55,\"x\":345,\"y\":44},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":33,\"x\":727,\"y\":5}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"33\",\"x\":\"727\",\"y\":\"5\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"150\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":\"318\",\"x\":1,\"y\":76},\"340\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":\"338\",\"x\":1,\"y\":76},\"480\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":\"478\",\"x\":1,\"y\":76},\"768\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":766,\"x\":1,\"y\":45}},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"766\",\"x\":\"1\",\"y\":\"45\",\"zindex\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"70\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":\"318\",\"x\":1,\"y\":227},\"340\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":\"338\",\"x\":1,\"y\":227},\"480\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":\"478\",\"x\":1,\"y\":227},\"768\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":766,\"x\":1,\"y\":196}},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"766\",\"x\":\"1\",\"y\":\"196\",\"zindex\":\"\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_iremit","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_iremit_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_iremit','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
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
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_iremit_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_iremit_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_iremit_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_iremit','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_image_esegui'>
<img id='<%=idPortlet%>_image_esegui_img' class='image image_esegui_ctrl' src="../images/elaborazione.gif" >
</div>
<div id='<%=idPortlet%>_Portlet_showlog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_8jw6v6",false);%></div>
<div id='<%=idPortlet%>_Portlet_showmsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_8jw7pb",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_iremit');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_iremit',["768"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"300","w":"100%"},"480":{"h":"300","w":"100%"},"768":{"h":"300","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"300"},"768":{"w":"100%","h":"300"},"480":{"w":"100%","h":"300"}},"w":"768","h":"300","title":"","layer":"false","npage":"1"}]);
this.RTIRemit=new ZtVWeb.SPLinkerCtrl(this,{"action":"async routine","allowedEntities":"<%=JSPLib.encrypt("allinea_iremit",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTIRemit","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTIRemit","offline":false,"page":1,"parms":"","popup":"false","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":false,"refresh":"","servlet":"allinea_iremit","target":"","type":"SPLinker","w":261,"x":800,"y":56});
this.RTIRemit.m_cID='<%=JSPLib.cmdHash("routine,allinea_iremit",request.getSession())%>';
this.image_esegui=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_esegui_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_esegui","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":30,"hide":"false","w":37,"x":230,"y":44},"340":{"anchor":" ","h":30,"hide":"false","w":"40","x":244,"y":44},"480":{"anchor":" ","h":30,"hide":"false","w":55,"x":345,"y":44},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":33,"x":727,"y":5}},"name":"image_esegui","page":1,"path_type":"","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":33,"x":727,"y":5,"zindex":"1"});
if(this.Portlet_showlog=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet_showlog')){
this.Portlet_showlog.setContainer(this,'Portlet_showlog')
this.Portlet_showlog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet_showlog","h":150,"hide":"false","layer":false,"layout_steps_values":{"320":{"anchor":"top-left-right","h":150,"hide":"false","w":"318","x":1,"y":76},"340":{"anchor":"top-left-right","h":150,"hide":"false","w":"338","x":1,"y":76},"480":{"anchor":"top-left-right","h":150,"hide":"false","w":"478","x":1,"y":76},"768":{"anchor":"top-left-right","h":150,"hide":"false","w":766,"x":1,"y":45}},"name":"Portlet_showlog","page":1,"portlet_id":"<%=idPortlet%>_8jw6v6","spuid":"","type":"Portlet","w":766,"x":1,"y":45,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_Portlet_showlog').style.display='none';
}
if(this.Portlet_showmsg=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet_showmsg')){
this.Portlet_showmsg.setContainer(this,'Portlet_showmsg')
this.Portlet_showmsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet_showmsg","h":70,"hide":"false","layer":false,"layout_steps_values":{"320":{"anchor":"top-left-right","h":70,"hide":"false","w":"318","x":1,"y":227},"340":{"anchor":"top-left-right","h":70,"hide":"false","w":"338","x":1,"y":227},"480":{"anchor":"top-left-right","h":70,"hide":"false","w":"478","x":1,"y":227},"768":{"anchor":"top-left-right","h":70,"hide":"false","w":766,"x":1,"y":196}},"name":"Portlet_showmsg","page":1,"portlet_id":"<%=idPortlet%>_8jw7pb","spuid":"","type":"Portlet","w":766,"x":1,"y":196,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_Portlet_showmsg').style.display='none';
}
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
<%if(request.getAttribute("pg_iremit_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_iremit_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_iremit_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_iremit',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_iremit');
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
sp.endPage("pg_iremit");
}%>
<%! public String getJSPUID() { return "3227238689"; } %>