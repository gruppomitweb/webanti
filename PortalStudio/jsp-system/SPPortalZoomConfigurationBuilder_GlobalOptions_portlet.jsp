<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function GetDataSave(conf){\n  \u002f\u002fvar vqrName=this.txtQueryName.Value();\n\u002f\u002f  if(!EmptyString(vqrName))\n    \u002f\u002fconf.vqr=vqrName;\n}","bg_image":" ","cache_time":" ","color":" ","css":" ","css_class":" ","description":" ","form_action":" ","form_type":"false","h":"100","language":"true","my_library":" ","on_security_failure":"login","pages_names":" ","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"400","version":"37","w":"100%"},{"align":" ","anchor":" ","bg_color":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","help_tips":" ","href":" ","name":"lblQueryName","page":"1","picture":" ","sequence":" ","tabindex":" ","target":" ","type":"Label","value":"VQR:","w":"60","x":"0","y":"0","zindex":"1"},{"anchor":" ","class_Css":"textbox","dataobj":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"22","help_tips":" ","init_par":" ","maxlength":" ","name":"txtQueryName","page":"1","password":"false","picture":" ","readonly":"true","scroll":"false","sequence":" ","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"146","x":"66","y":"0","zindex":"1"}]%>
<%/*Description: */%>
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
window.SPPortalZoomConfigurationBuilder_GlobalOptions_Static=function(){
if(typeof GetDataSave !='undefined')this.GetDataSave=GetDataSave;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function GetDataSave(conf){
  //var vqrName=this.txtQueryName.Value();
//  if(!EmptyString(vqrName))
    //conf.vqr=vqrName;
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
.SPPortalZoomConfigurationBuilder_GlobalOptions_container {
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:100px;
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet[Data-page="1"]{
  height:100px;
  width:100%;
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet > .lblQueryName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:60px;
  height:auto;
  min-height:19px;
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet > .lblQueryName_ctrl {
  height:auto;
  min-height:19px;
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet > .lblQueryName_ctrl {
  overflow:hidden;
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet > .txtQueryName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:66px;
  width:146px;
  height:22px;
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet > .txtQueryName_ctrl {
}
.SPPortalZoomConfigurationBuilder_GlobalOptions_portlet > .txtQueryName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
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
 String def="[{\"h\":\"100\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"60\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"22\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"146\",\"x\":\"66\",\"y\":\"0\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomConfigurationBuilder_GlobalOptions","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomConfigurationBuilder_GlobalOptions_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomConfigurationBuilder_GlobalOptions','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblQueryName= "VQR:";
String txtQueryName= "";
if(request.getAttribute("SPPortalZoomConfigurationBuilder_GlobalOptions_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomConfigurationBuilder_GlobalOptions_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomConfigurationBuilder_GlobalOptions_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomConfigurationBuilder_GlobalOptions','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblQueryName'  formid='<%=idPortlet%>' ps-name='lblQueryName'    class='label lblQueryName_ctrl'><div id='<%=idPortlet%>_lblQueryNametbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("VQR:"))%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_txtQueryName_wrp'><input id='<%=idPortlet%>_txtQueryName' name='txtQueryName' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='txtQueryName' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomConfigurationBuilder_GlobalOptions');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomConfigurationBuilder_GlobalOptions',["400"],["100"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"100","title":" ","layer":"false","npage":"1"}]);
this.lblQueryName=new ZtVWeb._LC(this,{"align":"","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblQueryName","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":" ","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblQueryName","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":"false","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(lblQueryName),false,true)%>","type":"Label","w":60,"x":0,"y":0,"zindex":"1"});
this.txtQueryName=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_txtQueryName","decrypt":false,"edit_undercond":"","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"txtQueryName","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(txtQueryName,false,true)%>","w":146,"x":66,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
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
<%if(request.getAttribute("SPPortalZoomConfigurationBuilder_GlobalOptions_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPPortalZoomConfigurationBuilder_GlobalOptions_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomConfigurationBuilder_GlobalOptions_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomConfigurationBuilder_GlobalOptions',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomConfigurationBuilder_GlobalOptions');
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
sp.endPage("SPPortalZoomConfigurationBuilder_GlobalOptions");
}%>
<%! public String getJSPUID() { return "3415114689"; } %>