<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":2,\"specific_states_value\":{\"normal\":{\"shadow_size\":\"\",\"size\":\"20pt\",\"weight\":\" 300\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"label\",\"class_name\":\"label\",\"selector\":\".label.title-login\",\"value\":\"Il software gestionale in cloud connesso con il tuo business\",\"class_Css\":\"label\",\"id\":\"form\"},{\"version\":2,\"specific_states_value\":{\"normal\":{\"bg_img\":\"..\u002fimages\u002fdefault_background_login.svg\",\"bg_repeat\":\"no-repeat\",\"bg_size_pr\":\"\",\"bg_size\":\"\",\"code\":\"background-size: auto;\\n    background-position: bottom left;\\n\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"img-login\",\"selector\":\".img-login\",\"id\":\"form\"}]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @Box0 }}{{ @Label1 }}{{ @labelTitle }}{{ @Image2 }}{{ @Image3 }}{{ @Template4 }}\u003c\u002fbody\u003e","grapesCss":"","h":"300","hsl":"","htmlcode":"{{ @img-login{{ @Template4 }} \n }} \n \n{{ @boxImg{{ @labelTitle }} \n }} \n \n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"empty","page_layer":"","pages":"1","pagesProp":"[{\"h\":\"300\",\"w\":\"100%\",\"title\":\"\",\"layer\":\"\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label title-login","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"50","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"labelTitle","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Il software per la gestione del rischio legato al tuo business","w":"180","wireframe_props":"align,value,n_col","x":"110","y":"10","zindex":"2","zone":""},{"anchor":"top-left(%)-right(%)-bottom","class_Css":"img-login","code":"\u003cimg src=\"..\u002fimages\u002frisk.jpg\" class=\"image imgLogo_ctrl\" width=\"100%\" height=\"80%\"\u003e","ctrlOfVariant":"","dataobjs":"","fixed":"","h":"240","hide":"false","layer":"false","layout_steps_values":"{}","name":"Template4","page":"1","rapp":"","sequence":"2","spuid":"","type":"Template","w":"400","wireframe_props":"","x":"0","y":"60","zindex":"1","zone":""}]%>
<%/*Description:*/%>
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
window.start_page_images_login_Static=function(){
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.start_page_images_login_container .label.title-login{  font-weight:  300;
  font-size: 20pt;
}
.start_page_images_login_container .img-login{
  background-image: url(../images/default_background_login.svg);
  background-repeat: no-repeat;
  background-size: auto;
      background-position: bottom left;
  
}
.start_page_images_login_container {
  height:100%;
  overflow:auto;
}
.start_page_images_login_title_container {
  margin: auto;
}
.start_page_images_login_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:400px;
  height:100%;
}
.start_page_images_login_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.start_page_images_login_portlet > .labelTitle_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:10px;
  left:110px;
  left:27.5%;
  right:110px;
  right:27.5%;
  width:auto;
  height:auto;
  min-height:50px;
}
.start_page_images_login_portlet > .labelTitle_ctrl {
  height:auto;
  min-height:50px;
}
.start_page_images_login_portlet > .labelTitle_ctrl {
  overflow:hidden;
  text-align:center;
}
.start_page_images_login_portlet > .Template4_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:60px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:0px;
  width:auto;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"h\":\"50\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Il software per la gestione del rischio legato al tuo business\",\"w\":\"180\",\"x\":\"110\",\"y\":\"10\",\"zindex\":\"2\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"240\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Template\",\"w\":\"400\",\"x\":\"0\",\"y\":\"60\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"start_page_images_login","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/start_page_images_login_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','start_page_images_login','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String labelTitle= "Il software per la gestione del rischio legato al tuo business";
if(request.getAttribute("start_page_images_login_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateParser.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("TemplateObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='start_page_images_login_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='start_page_images_login_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('start_page_images_login','<%=idPortlet%>',false,'');
</script><%}}%>
<span id='<%=idPortlet%>_labelTitle'  formid='<%=idPortlet%>' ps-name='labelTitle'    class='label title-login labelTitle_ctrl'><div id='<%=idPortlet%>_labelTitletbl' style='width:100%;'><%=JSPLib.ToHTML("Il software per la gestione del rischio legato al tuo business")%></div></span>
<div id='<%=idPortlet%>_Template4' class='img-login Template4_ctrl'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','start_page_images_login');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','start_page_images_login',["400"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"300","title":"","layer":""}]);
this.labelTitle=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label title-login","create_undercond":"","ctrlid":"<%=idPortlet%>_labelTitle","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":50,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"labelTitle","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(labelTitle,false,true)%>","type":"Label","w":180,"x":110,"y":10,"zindex":"2"});
this.Template4=new ZtVWeb.TemplateCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","call_stack":"{\"iterator\":\"\",\"key\":\"\",\"data\":\"\",\"from\":\"\",\"to\":\"\",\"step\":\"\",\"subscopes\":[]}","class_Css":"img-login","ctrlid":"<%=idPortlet%>_Template4","h":240,"hide":"false","layer":false,"layout_steps_values":{},"name":"Template4","page":1,"spuid":"","template":"{\"exp\":\"\",\"prefix\":\"\\u003cimg src=\\\"..\\u002fimages\\u002frisk.jpg\\\" class=\\\"image imgLogo_ctrl\\\" width=\\\"100%\\\" height=\\\"80%\\\"\\u003e\",\"post\":\"\",\"type\":\"ROOT\",\"attrs\":{},\"nodes\":[]}","type":"Template","w":400,"x":0,"y":60,"zindex":"1"});
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
<%if(request.getAttribute("start_page_images_login_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("start_page_images_login_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.start_page_images_login_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Template4.Render( {"start_on_load":true} );
ZtVWeb.addPortletObj('<%=idPortlet%>','start_page_images_login',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'start_page_images_login');
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
sp.endPage("start_page_images_login");
}%>
<%! public String getJSPUID() { return "2540224151"; } %>