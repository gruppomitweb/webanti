<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.svrp_SetWTitle();\n  this.svrp_DrawWizardTabs();\n  this.svrp_AdjustPortletHeight();\n  this.svrp_InjectWizard();\n}\n\nfunction svrp_AdjustPortletHeight(){\n\tvar totH = window.innerHeight,\n      boxH = this.navi_container.GetCtrl().offsetHeight,\n      ttlH = this.getTitlePortlet().Ctrl.offsetHeight,\n      offH = 24;\n  this.wiz_container.GetCtrl().style.height = (totH - boxH - ttlH - offH - 1) + \"px\";\n  this.Ctrl.style.height = (totH - ttlH) + \"px\";\n}\n\nfunction AddGenerateOnToolbar() {\n  var toolb = this.getTitlePortlet().toolbar;\n  toolb.Append( { image: GetStyleVariable(\"smartReportGenerateImage\", '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fok.png\",pageContext.getServletContext())%\u003e')\n                   , action: \"javascript:generateReport()\"\n                   , target: ''\n                   , title: '\u003c%=sp.translate(\"ADMIN_GENERATE\")%\u003e'\n                   , tooltip: '\u003c%=sp.translate(\"ADMIN_GENERATE\")%\u003e'\n                   , id: \"generateSVRP\"\n                  }\n                 , 0\n                );\n}\n\nfunction RemoveGenerateOnToolbar() {\n  var toolb = this.getTitlePortlet().toolbar;\n  toolb.Remove(\"generateSVRP\");\n}\n\nfunction svrp_SetWTitle(){\n  var ptlTitle = this.getTitlePortlet();\n  ptlTitle.title.Value(\t\"SmartReport\" + \" \u003cspan class='SPPortalZoom_currentversion'\u003e\" + \"Wizard\" + \"\u003c\u002fspan\u003e\"\t);\n  \u002f*ptlTitle.toolbar.Append( { image: GetStyleVariable(\"smartReportGenerateImage\", '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fok.png\",pageContext.getServletContext())%\u003e')\n                            , action: \"javascript:generateReport()\"\n                     \t\t\t\t, target: ''\n                     \t\t\t\t, title: '\u003c%=sp.translate(\"ADMIN_GENERATE\")%\u003e'\n                     \t\t\t\t, tooltip: '\u003c%=sp.translate(\"ADMIN_GENERATE\")%\u003e'\n                            , id: \"generateSVRP\"\n                           }\n                          , 0\n                         );*\u002f\n  ptlTitle.toolbar.Append( { image: GetStyleVariable(\"smartReportDiscardImage\", '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fclose.png\",pageContext.getServletContext())%\u003e')\n                            , action: \"javascript:CloseWindow(true)\"\n                     \t\t\t\t, target: ''\n                     \t\t\t\t, title: '\u003c%=sp.translate(\"ADMIN_CANCEL\")%\u003e'\n                     \t\t\t\t, tooltip: '\u003c%=sp.translate(\"ADMIN_CANCEL\")%\u003e'\n                            , id: \"discardSVRP\"\n                           }\n                         );\n}\n\nfunction svrp_DrawWizardTabs(){\n  if (!Empty(this.fields.Value()))\n\t\tfields = JSON.parse(this.fields.Value());\n  \n  var mcont = this.navi_container.GetCtrl();\n  mcont.innerHTML = \"\";\n  drawBreadcrumb(this.ds.Value(), mcont);\n}\n\nfunction svrp_InjectWizard(){  \n  mWizardBody = this.wiz_container.GetCtrl();\n  mWizardBody.innerHTML = \"\";\n  page1(this);\n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"smartreport\u002feditor.css,smartreport\u002fsmartreport.css,smartreport\u002fwizard.css,tabstrip.css","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"500","hsl":"","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"controls.js,mootools.js,mootools_more.js,SPReportMask.js,smartreport\u002fitemsObj.js,smartreport\u002fproperties.js,smartreport\u002fwizard.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"true","title_url":"","type":"Form","v_line":"1150","version":"37","w":"100%","wizard":"true"},{"anchor":"top-left(%)-right(%)","bg_color":"transparent","border_color":"transparent","border_weight":"0","class_Css":"","create_undercond":"","h":"50","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"navi_container","page":"1","sequence":"1","shrinkable":"","stretch":"true","target":"","type":"Box","w":"1149","wireframe_props":"","x":"0","y":"2","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"ds","page":"1","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1204","y":"-15"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"fields","page":"1","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1204","y":"11"},{"anchor":"top-left","bg_color":"transparent","border_color":"transparent","border_weight":"0","class_Css":"","create_undercond":"","h":"437","hide":"false","hide_undercond":"","href":"","layout_steps_values":"{}","name":"wiz_container","page":"1","sequence":"4","shrinkable":"","stretch":"false","target":"","type":"Box","w":"1129","wireframe_props":"","x":"20","y":"62","zindex":"2"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:ds,fields*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.SPSmartReportWizard_container {
}
.SPSmartReportWizard_portlet{
  position:relative;
  width:100%;
  min-width:1150px;
  height:500px;
  background-color:#FFFFFF;
}
.SPSmartReportWizard_portlet[Data-page="1"]{
  height:500px;
  width:100%;
}
.SPSmartReportWizard_portlet > .navi_container_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:2px;
  left:0px;
  left:0.0%;
  right:1px;
  right:0.08695652%;
  width:auto;
  height:auto;
  min-height:50px;
  display:flex;
  flex-direction:column;
}
.SPSmartReportWizard_portlet > .navi_container_ctrl {
  height:50px;
}
.SPSmartReportWizard_portlet > .navi_container_ctrl > .box_content {
  height:100%;
}
.SPSmartReportWizard_portlet > .navi_container_ctrl {
  min-height:50px;
  background-color:transparent;
  border-width:0px;
  border-style:solid;
  border-color:transparent;
}
.SPSmartReportWizard_portlet > .wiz_container_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:62px;
  left:20px;
  width:1129px;
  height:auto;
  min-height:437px;
  display:flex;
  flex-direction:column;
}
.SPSmartReportWizard_portlet > .wiz_container_ctrl {
  height:437px;
}
.SPSmartReportWizard_portlet > .wiz_container_ctrl > .box_content {
  height:100%;
}
.SPSmartReportWizard_portlet > .wiz_container_ctrl {
  min-height:437px;
  background-color:transparent;
  border-width:0px;
  border-style:solid;
  border-color:transparent;
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
 String def="[{\"h\":\"500\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1150\",\"w\":\"100%\",\"wizard\":\"true\"},{\"anchor\":\"top-left(%)-right(%)\",\"h\":\"50\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"1149\",\"x\":\"0\",\"y\":\"2\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1204\",\"y\":\"-15\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1204\",\"y\":\"11\"},{\"anchor\":\"top-left\",\"h\":\"437\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Box\",\"w\":\"1129\",\"x\":\"20\",\"y\":\"62\",\"zindex\":\"2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPSmartReportWizard","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPSmartReportWizard_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("smartreport/editor.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("smartreport/editor.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("smartreport/editor.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/smartreport/editor.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("smartreport/smartreport.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("smartreport/smartreport.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("smartreport/smartreport.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/smartreport/smartreport.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("smartreport/wizard.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("smartreport/wizard.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("smartreport/wizard.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/smartreport/wizard.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variant=SPPrxycizer.getVariant("tabstrip.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("tabstrip.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("SPReportMask.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("smartreport/itemsObj.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("smartreport/properties.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("smartreport/wizard.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPSmartReportWizard','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String ds=JSPLib.translateXSS(sp.getParameter("ds",""));
String fields=JSPLib.translateXSS(sp.getParameter("fields",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPSmartReportWizard_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='SPSmartReportWizard_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPSmartReportWizard_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPSmartReportWizard','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_navi_container' class='navi_container_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_navi_container_td' class='box_content'></div>
</div>
<div id='<%=idPortlet%>_wiz_container' class='wiz_container_ctrl SPSection_expanded box' data-original-display='flex'><div id='<%=idPortlet%>_wiz_container_td' class='box_content'></div>
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPSmartReportWizard');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPSmartReportWizard',["1150"],["500"],'portlet',<%=sp.isOfflineInstallation()%>,true,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},true,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1150","h":"500","title":"","layer":"false","npage":"1"}]);
this.navi_container=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left(%)-right(%)","bg_color":"transparent","border_color":"transparent","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_navi_container","groupName":"","h":50,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"navi_container","page":1,"shrinkable":"","stretch":"true","target":"","titled":"false","type":"Box","w":1149,"x":0,"y":2,"zindex":"1"});
this.ds=new ZtVWeb._VC(this,'ds',null,'character','<%=JSPLib.ToJSValue(ds,false,true)%>',false,false);
this.fields=new ZtVWeb._VC(this,'fields',null,'character','<%=JSPLib.ToJSValue(fields,false,true)%>',false,false);
this.wiz_container=new ZtVWeb.BoxCtrl(this,{"anchor":"top-left","bg_color":"transparent","border_color":"transparent","border_weight":"0","class_Css":"box","collapsible":"false","create_undercond":"","ctrlid":"<%=idPortlet%>_wiz_container","groupName":"","h":437,"hide":"false","hide_undercond":"","href":"","isGroupNameHead":false,"layer":false,"layout_steps_values":{},"name":"wiz_container","page":1,"shrinkable":"","stretch":"false","target":"","titled":"false","type":"Box","w":1129,"x":20,"y":62,"zindex":"2"});
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
<%request.setAttribute("SPSmartReportWizard_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPSmartReportWizard_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof svrp_AdjustPortletHeight !='undefined')this.svrp_AdjustPortletHeight=svrp_AdjustPortletHeight;
if(typeof AddGenerateOnToolbar !='undefined')this.AddGenerateOnToolbar=AddGenerateOnToolbar;
if(typeof RemoveGenerateOnToolbar !='undefined')this.RemoveGenerateOnToolbar=RemoveGenerateOnToolbar;
if(typeof svrp_SetWTitle !='undefined')this.svrp_SetWTitle=svrp_SetWTitle;
if(typeof svrp_DrawWizardTabs !='undefined')this.svrp_DrawWizardTabs=svrp_DrawWizardTabs;
if(typeof svrp_InjectWizard !='undefined')this.svrp_InjectWizard=svrp_InjectWizard;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
  this.svrp_SetWTitle();
  this.svrp_DrawWizardTabs();
  this.svrp_AdjustPortletHeight();
  this.svrp_InjectWizard();
}
function svrp_AdjustPortletHeight(){
	var totH = window.innerHeight,
      boxH = this.navi_container.GetCtrl().offsetHeight,
      ttlH = this.getTitlePortlet().Ctrl.offsetHeight,
      offH = 24;
  this.wiz_container.GetCtrl().style.height = (totH - boxH - ttlH - offH - 1) + "px";
  this.Ctrl.style.height = (totH - ttlH) + "px";
}
function AddGenerateOnToolbar() {
  var toolb = this.getTitlePortlet().toolbar;
  toolb.Append( { image: GetStyleVariable("smartReportGenerateImage", '<%=sp.getThemedImage("../images/custom_toolbar/ok.png",pageContext.getServletContext())%>')
                   , action: "javascript:generateReport()"
                   , target: ''
                   , title: '<%=sp.translate("ADMIN_GENERATE")%>'
                   , tooltip: '<%=sp.translate("ADMIN_GENERATE")%>'
                   , id: "generateSVRP"
                  }
                 , 0
                );
}
function RemoveGenerateOnToolbar() {
  var toolb = this.getTitlePortlet().toolbar;
  toolb.Remove("generateSVRP");
}
function svrp_SetWTitle(){
  var ptlTitle = this.getTitlePortlet();
  ptlTitle.title.Value(	"SmartReport" + " <span class='SPPortalZoom_currentversion'>" + "Wizard" + "</span>"	);
  
  ptlTitle.toolbar.Append( { image: GetStyleVariable("smartReportDiscardImage", '<%=sp.getThemedImage("../images/custom_toolbar/close.png",pageContext.getServletContext())%>')
                            , action: "javascript:CloseWindow(true)"
                     				, target: ''
                     				, title: '<%=sp.translate("ADMIN_CANCEL")%>'
                     				, tooltip: '<%=sp.translate("ADMIN_CANCEL")%>'
                            , id: "discardSVRP"
                           }
                         );
}
function svrp_DrawWizardTabs(){
  if (!Empty(this.fields.Value()))
		fields = JSON.parse(this.fields.Value());
  
  var mcont = this.navi_container.GetCtrl();
  mcont.innerHTML = "";
  drawBreadcrumb(this.ds.Value(), mcont);
}
function svrp_InjectWizard(){  
  mWizardBody = this.wiz_container.GetCtrl();
  mWizardBody.innerHTML = "";
  page1(this);
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPSmartReportWizard_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPSmartReportWizard',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPSmartReportWizard');
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
sp.endPage("SPSmartReportWizard");
}%>
<%! public String getJSPUID() { return "725452129"; } %>