<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.lbl_log.Hide();\nfunction SetWidth(){\n  var val = this.value.Value();\n  this.Box0.Ctrl.style.width = (100-((val-this.pMin.Value())\u002f(this.pMax.Value()-this.pMin.Value()))*100)+\"%\";\n}\nfunction SetColor(){\n\u002f\u002f  this.Box0.Ctrl.style.width = px+\"px\";\n}\n\nfunction SetTitle(){\n  this.img_bg_gradient.Ctrl.title=this.value.Value()+'\u002f'+this.pMax.Value();\n}\n\nfunction Calculate(value){\n\u002f\u002f  this.lbl_log.Value('pMin:'+this.pMin.Value()+';pMax:'+this.pMax.Value()+';value:'+value+';');\n\n  this.value.Value(value);\n  this.SetWidth();\n  this.SetColor();\n  this.SetTitle();\n}\n\nfunction this_Loaded(){\n  this.img_bg_gradient.Ctrl.style.width='100%';\n  this.Calculate(0);\n}\n","bg_image":" ","cache_time":" ","color":"#CCCCCC","css":" ","css_class":" ","description":" ","form_action":" ","form_type":"false","h":"10","language":"false","my_library":" ","on_security_failure":"login","pages_names":" ","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"100","version":"37","w":"100%"},{"anchor":"top-right","bg_color":"#FFFFFF","border_color":"#0033FF","border_weight":"0","class_Css":"box","h":"11","name":"Box0","page":"1","sequence":" ","stretch":"false","type":"Box","w":"100","x":"0","y":"0","zindex":"2"},{"dataobj":" ","field":" ","h":"19","init_par":"attribute::0","name":"pMin","page":"1","sequence":" ","type":"Variable","typevar":"numeric","w":"49","x":"-6","y":"-27"},{"dataobj":" ","field":" ","h":"18","init_par":"attribute::100","name":"pMax","page":"1","sequence":" ","type":"Variable","typevar":"numeric","w":"45","x":"50","y":"-28"},{"dataobj":" ","field":" ","h":"20","init_par":"0","name":"value","page":"1","sequence":" ","type":"Variable","typevar":"numeric","w":"56","x":"-9","y":"14"},{"anchor":"top-left-right","dataobj":" ","field":" ","h":"11","help_tips":" ","href":" ","name":"img_bg_gradient","page":"1","path_type":" ","sequence":" ","src":"..\u002fimages\u002fspadministration_pwdmeter_gradient.png","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"100","x":"0","y":"0","zindex":"1"},{"align":"left","anchor":" ","bg_color":"transparent","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"black","font_size":"7pt","font_weight":"normal","h":"11","help_tips":" ","href":" ","name":"lbl_log","page":"1","picture":" ","sequence":" ","tabindex":" ","target":" ","type":"Label","value":" ","w":"100","x":"0","y":"0","zindex":"2"}]%>
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
window.spadministration_pwdmeter_Static=function(){
if(typeof SetWidth !='undefined')this.SetWidth=SetWidth;
if(typeof SetColor !='undefined')this.SetColor=SetColor;
if(typeof SetTitle !='undefined')this.SetTitle=SetTitle;
if(typeof Calculate !='undefined')this.Calculate=Calculate;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.lbl_log.Hide();
function SetWidth(){
  var val = this.value.Value();
  this.Box0.Ctrl.style.width = (100-((val-this.pMin.Value())/(this.pMax.Value()-this.pMin.Value()))*100)+"%";
}
function SetColor(){
//  this.Box0.Ctrl.style.width = px+"px";
}
function SetTitle(){
  this.img_bg_gradient.Ctrl.title=this.value.Value()+'/'+this.pMax.Value();
}
function Calculate(value){
//  this.lbl_log.Value('pMin:'+this.pMin.Value()+';pMax:'+this.pMax.Value()+';value:'+value+';');
  this.value.Value(value);
  this.SetWidth();
  this.SetColor();
  this.SetTitle();
}
function this_Loaded(){
  this.img_bg_gradient.Ctrl.style.width='100%';
  this.Calculate(0);
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
.spadministration_pwdmeter_container {
}
.spadministration_pwdmeter_portlet{
  position:relative;
  width:100%;
  min-width:100px;
  height:10px;
  background-color:#CCCCCC;
}
.spadministration_pwdmeter_portlet[Data-page="1"]{
  height:10px;
  width:100%;
}
.spadministration_pwdmeter_portlet > .Box0_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:0px;
  right:0px;
  width:100px;
  height:auto;
  min-height:11px;
  display:flex;
  flex-direction:column;
}
.spadministration_pwdmeter_portlet > .Box0_ctrl {
  height:11px;
}
.spadministration_pwdmeter_portlet > .Box0_ctrl > .box_content {
  height:100%;
}
.spadministration_pwdmeter_portlet > .Box0_ctrl {
  min-height:11px;
  background-color:#FFFFFF;
  border-width:0px;
  border-style:solid;
  border-color:#0033FF;
}
.spadministration_pwdmeter_portlet > .img_bg_gradient_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:11px;
}
.spadministration_pwdmeter_portlet > .img_bg_gradient_ctrl {
}
.spadministration_pwdmeter_portlet > .img_bg_gradient_ctrl > img{
  width:100%;
  vertical-align:top;
  height:11px;
}
.spadministration_pwdmeter_portlet > .lbl_log_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:100px;
  height:auto;
  min-height:11px;
}
.spadministration_pwdmeter_portlet > .lbl_log_ctrl {
  height:auto;
  min-height:11px;
}
.spadministration_pwdmeter_portlet > .lbl_log_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:black;
  text-align:left;
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
 String def="[{\"h\":\"10\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"100\",\"w\":\"100%\"},{\"anchor\":\"top-right\",\"h\":\"11\",\"page\":\"1\",\"type\":\"Box\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"2\"},{\"h\":\"19\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"49\",\"x\":\"-6\",\"y\":\"-27\"},{\"h\":\"18\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"45\",\"x\":\"50\",\"y\":\"-28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"56\",\"x\":\"-9\",\"y\":\"14\"},{\"anchor\":\"top-left-right\",\"h\":\"11\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"11\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"100\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_pwdmeter","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_pwdmeter_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_pwdmeter','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double pMin=Library.getAttribute(request,"pMin",0);
double pMax=Library.getAttribute(request,"pMax",100);
double value=0;
String lbl_log= " ";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='spadministration_pwdmeter_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_pwdmeter_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_pwdmeter','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Box0' class='Box0_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_Box0_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_img_bg_gradient'>
<img id='<%=idPortlet%>_img_bg_gradient_img' class=' img_bg_gradient_ctrl' src="../images/spadministration_pwdmeter_gradient.png" >
</div>
<span id='<%=idPortlet%>_lbl_log'  formid='<%=idPortlet%>' ps-name='lbl_log'    class='label lbl_log_ctrl'><div id='<%=idPortlet%>_lbl_logtbl' style='width:100%;'> </div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_pwdmeter');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_pwdmeter',["100"],["10"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"100","h":"10","title":" ","layer":"false","npage":"1"}]);
this.Box0=new ZtVWeb.BoxCtrl(this,{"anchor":"top-right","bg_color":"#FFFFFF","border_color":"#0033FF","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_Box0","groupName":"","h":11,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"Box0","page":1,"shrinkable":"false","stretch":"false","target":"","titled":"false","type":"Box","w":100,"x":0,"y":0,"zindex":"2"});
this.pMin=new ZtVWeb._VC(this,'pMin',null,'numeric',<%=pMin%>,false,false);
this.pMax=new ZtVWeb._VC(this,'pMax',null,'numeric',<%=pMax%>,false,false);
this.value=new ZtVWeb._VC(this,'value',null,'numeric',<%=value%>,false,false);
this.img_bg_gradient=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left-right","boundedPosition":"","class_Css":" img_bg_gradient_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_img_bg_gradient","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":11,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"img_bg_gradient","page":1,"path_type":"","server_side":"false","src":"..\u002fimages\u002fspadministration_pwdmeter_gradient.png","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":100,"x":0,"y":0,"zindex":"1"});
this.lbl_log=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lbl_log","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"black","font_size":"7pt","font_weight":"normal","fontpct":"","h":11,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":" ","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lbl_log","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":"false","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lbl_log,false,true)%>","type":"Label","w":100,"x":0,"y":0,"zindex":"2"});
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
<%if(request.getAttribute("spadministration_pwdmeter_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("spadministration_pwdmeter_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.spadministration_pwdmeter_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_pwdmeter',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_pwdmeter');
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
sp.endPage("spadministration_pwdmeter");
}%>
<%! public String getJSPUID() { return "1401892832"; } %>