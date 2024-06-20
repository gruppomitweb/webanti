<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.openerID.Value(this.formid);\n\nfunction btnLoad_Click(){\n  if(this.container){\n    this.container.RowsParamValid=false;\n    this.container.dispatchEvent(\"LoadConfiguration\", this.ConfigName.Value());\n  }\n}\n\nfunction btnVzm_Query_Click(){\n  this.splkVZMSelect.Link();\n}\n\nthis['on_'+this.formid+'_ChangeVZMName']=function(name){\n  this.ConfigName.Value(name);\n}","bg_image":" ","cache_time":" ","color":" ","css":" ","css_class":" ","description":" ","form_action":" ","form_type":"false","h":"30","language":"false","my_library":" ","on_security_failure":"login","pages_names":" ","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"200","version":"37","w":"100%"},{"align":"right","anchor":"top-left","bg_color":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"21","help_tips":" ","href":" ","name":"lblConfiguration","page":"1","picture":" ","sequence":"1","tabindex":" ","target":" ","type":"Label","value":"Configuration:","w":"82","x":"0","y":"7","zindex":"1"},{"anchor":"top-left-right","class_Css":"textbox","dataobj":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"20","help_tips":" ","init_par":" ","maxlength":" ","name":"ConfigName","page":"1","password":" ","picture":" ","readonly":"false","scroll":"false","sequence":"2","tabindex":"1","type":"Textbox","typevar":"character","visible":"true","w":"49","x":"82","y":"5","zindex":"1"},{"anchor":"top-right","bg_color":" ","class_Css":"button","font":" ","font_color":" ","font_size":" ","h":"20","help_tips":" ","name":"btnVzm_Query","page":"1","sequence":"3","tabindex":"1","type":"Button","type_submit":"false","value":"...","w":"20","x":"133","y":"6"},{"anchor":"top-right","bg_color":" ","class_Css":"button","font":" ","font_color":" ","font_size":" ","h":"20","help_tips":" ","name":"btnLoad","page":"1","sequence":"4","tabindex":"1","type":"Button","type_submit":"false","value":"Load","w":"40","x":"155","y":"6"},{"entity_type":" ","h":"20","m_cAction":" ","m_cAltInterface":" ","name":"splkVZMSelect","page":"1","parms":"openerID,Table,ConfigName","popup":"true","popup_height":"440","popup_scroll":"true","popup_width":"300","refresh":" ","sequence":" ","servlet":"..\u002fjsp-system\u002fSPPortalZoomLoad_VZMSelect_portlet.jsp","target":" ","type":"SPLinker","w":"20","x":"121","y":"31"},{"dataobj":" ","field":" ","h":"22","init_par":" ","name":"openerID","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"0","y":"-25"},{"dataobj":" ","field":" ","h":"22","init_par":" ","name":"Table","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"150","y":"-25"}]%>
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
window.SPPortalZoomLoad_Static=function(){
if(typeof btnLoad_Click !='undefined')this.btnLoad_Click=btnLoad_Click;
if(typeof btnVzm_Query_Click !='undefined')this.btnVzm_Query_Click=btnVzm_Query_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.openerID.Value(this.formid);
function btnLoad_Click(){
  if(this.container){
    this.container.RowsParamValid=false;
    this.container.dispatchEvent("LoadConfiguration", this.ConfigName.Value());
  }
}
function btnVzm_Query_Click(){
  this.splkVZMSelect.Link();
}
this['on_'+this.formid+'_ChangeVZMName']=function(name){
  this.ConfigName.Value(name);
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
.SPPortalZoomLoad_container {
}
.SPPortalZoomLoad_portlet{
  position:relative;
  width:100%;
  min-width:200px;
  height:30px;
}
.SPPortalZoomLoad_portlet[Data-page="1"]{
  height:30px;
  width:100%;
}
.SPPortalZoomLoad_portlet > .lblConfiguration_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  left:0px;
  width:82px;
  height:auto;
  min-height:21px;
}
.SPPortalZoomLoad_portlet > .lblConfiguration_ctrl {
  height:auto;
  min-height:21px;
}
.SPPortalZoomLoad_portlet > .lblConfiguration_ctrl {
  overflow:hidden;
  text-align:right;
}
.SPPortalZoomLoad_portlet > .ConfigName_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:82px;
  right:69px;
  width:auto;
  height:20px;
}
.SPPortalZoomLoad_portlet > .ConfigName_ctrl {
}
.SPPortalZoomLoad_portlet > .ConfigName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomLoad_portlet > .btnVzm_Query_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  right:47px;
  width:20px;
  height:20px;
}
.SPPortalZoomLoad_portlet > .btnVzm_Query_ctrl {
  border-width:nullpx;
}
.SPPortalZoomLoad_portlet > .btnLoad_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  right:5px;
  width:40px;
  height:20px;
}
.SPPortalZoomLoad_portlet > .btnLoad_ctrl {
  border-width:nullpx;
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
 String def="[{\"h\":\"30\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"200\",\"w\":\"100%\"},{\"anchor\":\"top-left\",\"h\":\"21\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"82\",\"x\":\"0\",\"y\":\"7\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"49\",\"x\":\"82\",\"y\":\"5\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"20\",\"x\":\"133\",\"y\":\"6\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"40\",\"x\":\"155\",\"y\":\"6\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"20\",\"x\":\"121\",\"y\":\"31\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"0\",\"y\":\"-25\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"150\",\"y\":\"-25\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomLoad","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomLoad_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomLoad','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblConfiguration= "Configuration:";
String ConfigName= "";
if(request.getAttribute("SPPortalZoomLoad_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String openerID= "";
String Table= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomLoad_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomLoad_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomLoad','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_lblConfiguration'  formid='<%=idPortlet%>' ps-name='lblConfiguration'    class='label lblConfiguration_ctrl'><div id='<%=idPortlet%>_lblConfigurationtbl' style='width:100%;'><%=JSPLib.ToHTML("Configuration:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_ConfigName_wrp'><input id='<%=idPortlet%>_ConfigName' name='ConfigName' type='text' class='textbox' tabindex='1' formid='<%=idPortlet%>' ps-name='ConfigName' /></span>
<input id='<%=idPortlet%>_btnVzm_Query' type='button' class='button btnVzm_Query_ctrl' tabindex='1'/>
<input id='<%=idPortlet%>_btnLoad' type='button' class='button btnLoad_ctrl' tabindex='1'/>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomLoad');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomLoad',["200"],["30"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"200","h":"30","title":" ","layer":"false","npage":"1"}]);
this.lblConfiguration=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblConfiguration","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":21,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":" ","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblConfiguration","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":"false","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblConfiguration,false,true)%>","type":"Label","w":82,"x":0,"y":7,"zindex":"1"});
this.ConfigName=new ZtVWeb._TC(this,{"anchor":"top-left-right","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ConfigName","decrypt":false,"edit_undercond":"","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ConfigName","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ConfigName,false,true)%>","w":49,"x":82,"y":5,"zerofilling":false,"zindex":"1","zoom":""});
this.btnVzm_Query=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","class_Css":"button btnVzm_Query_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnVzm_Query","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":" ","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnVzm_Query","page":1,"tabindex":"1","text":"...","type":"Button","type_submit":"false","type_wizard":"","w":20,"x":133,"y":6});
this.btnLoad=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"","class_Css":"button btnLoad_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnLoad","edit_undercond":"","font":"","font_color":"","font_size":"","h":20,"help_tips":" ","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btnLoad","page":1,"tabindex":"1","text":"Load","type":"Button","type_submit":"false","type_wizard":"","w":40,"x":155,"y":6});
this.splkVZMSelect=new ZtVWeb.SPLinkerCtrl(this,{"action":" ","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splkVZMSelect","decrypted_parms":"","entity_type":" ","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"splkVZMSelect","offline":false,"page":1,"parms":"openerID,Table,ConfigName","popup":"true","popup_height":"440","popup_maximized":"false","popup_scroll":"true","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":" ","servlet":"..\u002fjsp-system\u002fSPPortalZoomLoad_VZMSelect_portlet.jsp","target":" ","type":"SPLinker","w":20,"x":121,"y":31});
this.splkVZMSelect.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/SPPortalZoomLoad_VZMSelect_portlet.jsp",request.getSession())%>';
this.openerID=new ZtVWeb._VC(this,'openerID',null,'character','<%=JSPLib.ToJSValue(openerID,false,true)%>',false,false);
this.Table=new ZtVWeb._VC(this,'Table',null,'character','<%=JSPLib.ToJSValue(Table,false,true)%>',false,false);
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
<%if(request.getAttribute("SPPortalZoomLoad_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPPortalZoomLoad_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomLoad_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomLoad',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomLoad');
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
sp.endPage("SPPortalZoomLoad");
}%>
<%! public String getJSPUID() { return "264281279"; } %>