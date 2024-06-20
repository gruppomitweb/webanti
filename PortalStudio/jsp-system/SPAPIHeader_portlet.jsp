<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var opener = GetOpener();\nif(!( opener && opener.getRenderApiObjClass) ) {\n  return;\n}\n\nthis.appSamplesUrl = this.SPApiGetUrl.Link();\nthis.tool = opener.tool ? opener.tool : 'portlet';\n\nvar itemAPI = opener.getRenderApiObjClass();\nthis.apiType = itemAPI.apiType;\nif ( this.apiType ) {\n\tthis.apiType = this.apiType.charAt(0).toUpperCase() + this.apiType.slice(1);\n}\nif (opener.getChartName) {\n  this.getTitlePortlet().SetTitle(opener.getChartName(this.apiType), true);\n}\nelse {\n\tthis.getTitlePortlet().SetTitle(this.apiType, true);\n}\n\nvar itemObj = itemAPI.apiObj;\nvar lbhelper = '';\nif (itemObj && itemObj.helper) {\n  if( itemObj.helper.description ) {\n    var html = FromHTML(itemObj.helper.description);\n    if( itemObj.helper.drawing && itemObj.helper.drawing.src) {\n      if (!itemObj.helper.drawing.width) itemObj.helper.drawing.width = '100%'\n      html += '\u003cbr\u003e\u003cdiv style=\"margin:10px; text-align:center\"\u003e\u003cimg src=\\'' + itemObj.helper.drawing.src + '\\' width=\\'' + itemObj.helper.drawing.width + '\\'\u003e'; \n    }\n    this.getTitlePortlet().SetSubTitle(html, true);\n  }\n  if( itemObj.helper.usage ) {\n    lbhelper += '\u003cb\u003eUsage:\u003c\u002fb\u003e\u003cbr\u003e';\n    lbhelper += itemObj.helper.usage;\n  }\n}\nif(!Empty(lbhelper)) {\n  this.LabelHelper.Value(lbhelper);\n}\n\nvar toolb = this.getTitlePortlet().toolbar;\nif ( this.tool == 'chart' && Lower(this.apiType) != 'common') {\n  toolb.Append({\n    id: \"tbtaginfo\",\n    title: \"Info\",\n    tooltip: \"Info\",\n    action: \"javascript:window.\" + this.formid + \".openInfoView()\",\n    image: GetStyleVariable(\"psysInfo\", {\"Char\":\"61254\",\"FontName\":\"icons8_win10\"}),\n    target: \"\"\n  });\n}\ntoolb.Append({\n  id: \"tbtagview\",\n  title: \"View Samples by tags\",\n  tooltip: \"View Samples by tags\",\n  action: \"javascript:window.\" + this.formid + \".openTagView()\",\n  image: GetStyleVariable(\"psysTags\", {\"Char\":\"60138\",\"FontName\":\"icons8_win10\"}),\n  target: \"\"\n});\n\nfunction openTagView() {\n  var pws = window.GetWindowSize();\n  window.layerOpenForeground(this.appSamplesUrl + \"\u002fjsp\u002fspapiptl_wsitemap_portlet.jsp?tool=\" + this.tool + \"&component=\" + Lower(this.apiType), \"\", \"\", pws.w, pws.h, true, 1);\n}\n\nfunction openInfoView() {\n  var htmlname = this.tool + \"_\" + Lower(this.apiType);\n  var pws = window.GetWindowSize();\n  if ( this.tool == 'chart') {\n  \twindow.layerOpenForeground(this.appSamplesUrl + \"\u002fdoc\u002f\" + htmlname + \".html\", \"\", \"\", pws.w, pws.h, true, 1);\n\t}\n}\n\n  ","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"portalstudio\u002fportalstudioTheme.css","css_class":"","css_code":"[{\"version\":2,\"specific_states_value\":{\"normal\":{\"code\":\"margin: 5px\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"ul\",\"selector\":\"ul\",\"id\":\"form\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"32","hsl":"","htmlcode":"{{ LabelHelper }}\n{{ SPApiGetUrl }}\n{{ Image2 }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"false","sp_uid":"false","steps":"","stretch_height":"false","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"806","version":"37","w":"100%","wizard":""},{"align":"justify","anchor":"top-left-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"29","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"LabelHelper","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"787","wireframe_props":"align,value,n_col","x":"10","y":"2","zindex":"2"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPApiGetUrl","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"false","refresh":"","sequence":"2","servlet":"spgetapihelpurl","target":"","type":"SPLinker","w":"97","x":"810","y":"6"}]%>
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
window.SPAPIHeader_Static=function(){
if(typeof openTagView !='undefined')this.openTagView=openTagView;
if(typeof openInfoView !='undefined')this.openInfoView=openInfoView;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var opener = GetOpener();
if(!( opener && opener.getRenderApiObjClass) ) {
  return;
}
this.appSamplesUrl = this.SPApiGetUrl.Link();
this.tool = opener.tool ? opener.tool : 'portlet';
var itemAPI = opener.getRenderApiObjClass();
this.apiType = itemAPI.apiType;
if ( this.apiType ) {
	this.apiType = this.apiType.charAt(0).toUpperCase() + this.apiType.slice(1);
}
if (opener.getChartName) {
  this.getTitlePortlet().SetTitle(opener.getChartName(this.apiType), true);
}
else {
	this.getTitlePortlet().SetTitle(this.apiType, true);
}
var itemObj = itemAPI.apiObj;
var lbhelper = '';
if (itemObj && itemObj.helper) {
  if( itemObj.helper.description ) {
    var html = FromHTML(itemObj.helper.description);
    if( itemObj.helper.drawing && itemObj.helper.drawing.src) {
      if (!itemObj.helper.drawing.width) itemObj.helper.drawing.width = '100%'
      html += '<br><div style="margin:10px; text-align:center"><img src=\'' + itemObj.helper.drawing.src + '\' width=\'' + itemObj.helper.drawing.width + '\'>'; 
    }
    this.getTitlePortlet().SetSubTitle(html, true);
  }
  if( itemObj.helper.usage ) {
    lbhelper += '<b>Usage:</b><br>';
    lbhelper += itemObj.helper.usage;
  }
}
if(!Empty(lbhelper)) {
  this.LabelHelper.Value(lbhelper);
}
var toolb = this.getTitlePortlet().toolbar;
if ( this.tool == 'chart' && Lower(this.apiType) != 'common') {
  toolb.Append({
    id: "tbtaginfo",
    title: "Info",
    tooltip: "Info",
    action: "javascript:window." + this.formid + ".openInfoView()",
    image: GetStyleVariable("psysInfo", {"Char":"61254","FontName":"icons8_win10"}),
    target: ""
  });
}
toolb.Append({
  id: "tbtagview",
  title: "View Samples by tags",
  tooltip: "View Samples by tags",
  action: "javascript:window." + this.formid + ".openTagView()",
  image: GetStyleVariable("psysTags", {"Char":"60138","FontName":"icons8_win10"}),
  target: ""
});
function openTagView() {
  var pws = window.GetWindowSize();
  window.layerOpenForeground(this.appSamplesUrl + "/jsp/spapiptl_wsitemap_portlet.jsp?tool=" + this.tool + "&component=" + Lower(this.apiType), "", "", pws.w, pws.h, true, 1);
}
function openInfoView() {
  var htmlname = this.tool + "_" + Lower(this.apiType);
  var pws = window.GetWindowSize();
  if ( this.tool == 'chart') {
  	window.layerOpenForeground(this.appSamplesUrl + "/doc/" + htmlname + ".html", "", "", pws.w, pws.h, true, 1);
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
.SPAPIHeader_container ul{  margin: 5px
}
.SPAPIHeader_container {
}
.SPAPIHeader_title_container {
  margin: auto;
}
.SPAPIHeader_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:806px;
  height:32px;
}
.SPAPIHeader_portlet[Data-page="1"]{
  height:32px;
  width:100%;
}
.SPAPIHeader_portlet > .LabelHelper_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:2px;
  left:10px;
  right:9px;
  right:1.1166253%;
  width:auto;
  height:auto;
  min-height:29px;
}
.SPAPIHeader_portlet > .LabelHelper_ctrl {
  height:auto;
  min-height:29px;
}
.SPAPIHeader_portlet > .LabelHelper_ctrl {
  overflow:hidden;
  text-align:justify;
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
 String def="[{\"h\":\"32\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"806\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"justify\",\"anchor\":\"top-left-right(%)\",\"h\":\"29\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"787\",\"x\":\"10\",\"y\":\"2\",\"zindex\":\"2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"97\",\"x\":\"810\",\"y\":\"6\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPAPIHeader","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPAPIHeader_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
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
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("portalstudio/portalstudioTheme.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPAPIHeader','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String LabelHelper= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='SPAPIHeader_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='SPAPIHeader_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPAPIHeader_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPAPIHeader','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_LabelHelper'  formid='<%=idPortlet%>' ps-name='LabelHelper'    class='label LabelHelper_ctrl'><div id='<%=idPortlet%>_LabelHelpertbl' style='width:100%;'></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPAPIHeader');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','SPAPIHeader',["806"],["32"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"806","h":"32","title":"","layer":"false","npage":"1"}]);
this.LabelHelper=new ZtVWeb._LC(this,{"align":"justify","anchor":"top-left-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_LabelHelper","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":29,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"LabelHelper","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(LabelHelper,false,true)%>","type":"Label","w":787,"x":10,"y":2,"zindex":"2"});
this.SPApiGetUrl=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPApiGetUrl","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPApiGetUrl","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spgetapihelpurl","target":"","type":"SPLinker","w":97,"x":810,"y":6});
this.SPApiGetUrl.m_cID='<%=JSPLib.cmdHash("routine,spgetapihelpurl",request.getSession())%>';
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
<%if(request.getAttribute("SPAPIHeader_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPAPIHeader_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPAPIHeader_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPAPIHeader',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPAPIHeader');
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
sp.endPage("SPAPIHeader");
}%>
<%! public String getJSPUID() { return "861882214"; } %>