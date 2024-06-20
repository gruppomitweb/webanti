<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"600","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"300\",\"w\":\"100%\"},\"480\":{\"h\":\"300\",\"w\":\"100%\"},\"768\":{\"h\":\"600\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-left-right","bounded_position":"center","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"463","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"bounded","layout_steps_values":"{\"320\":{\"x\":67,\"y\":1,\"w\":372,\"h\":321,\"anchor\":\"top-left(%)\",\"hide\":\"false\",\"font_size\":\"\"},\"480\":{\"x\":100,\"y\":1,\"w\":372,\"h\":321,\"anchor\":\"top-left(%)\",\"hide\":\"false\",\"font_size\":\"\"},\"768\":{\"x\":137,\"y\":10,\"w\":482,\"h\":463,\"anchor\":\"top-left-right\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"image2","page":"1","path_type":"","sequence":"2","server_side":"","src":"..\u002fimages\u002faml.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"482","wireframe_props":"","x":"137","y":"10","zindex":"1"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"320\":{\"x\":0,\"y\":498,\"w\":\"315\",\"h\":20,\"anchor\":\"top-left-right\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":0,\"y\":498,\"w\":\"475\",\"h\":20,\"anchor\":\"top-left-right\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":0,\"y\":498,\"w\":763,\"h\":20,\"anchor\":\"top-left-right\",\"hide\":\"false\",\"align\":\"center\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"Label5","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"SISTEMA DI E-LEARNING NON ANCORA ATTIVO","w":"763","wireframe_props":"align,value,n_col","x":"0","y":"498","zindex":"2"}]%>
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
window.pg_cgo_elearning_empty_Static=function(){
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
.pg_cgo_elearning_empty_container {
}
.pg_cgo_elearning_empty_title_container {
  margin: auto;
}
.pg_cgo_elearning_empty_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:600px;
  background-color:#F3F3F3;
}
.pg_cgo_elearning_empty_portlet[Data-page="1"]{
  height:600px;
  width:100%;
}
.pg_cgo_elearning_empty_portlet[Data-step="320"] {
  height:300px;
  width:100%;
}
.pg_cgo_elearning_empty_portlet[Data-step="480"] {
  height:300px;
  width:100%;
}
.pg_cgo_elearning_empty_portlet[Data-step="768"] {
  height:600px;
  width:100%;
}
.pg_cgo_elearning_empty_portlet[Data-step="320"] > .image2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  left:67px;
  left:20.9375%;
  width:372px;
  height:321px;
}
.pg_cgo_elearning_empty_portlet[Data-step="480"] > .image2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  left:100px;
  left:20.833334%;
  width:372px;
  height:321px;
}
.pg_cgo_elearning_empty_portlet[Data-step="768"] > .image2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:137px;
  right:149px;
  width:auto;
  height:463px;
}
.pg_cgo_elearning_empty_portlet > .image2_ctrl {
}
.pg_cgo_elearning_empty_portlet > .image2_ctrl > img{
  width:100%;
  vertical-align:top;
}
.pg_cgo_elearning_empty_portlet[Data-step="320"] > .image2_ctrl > img {
  height:321px;
}
.pg_cgo_elearning_empty_portlet[Data-step="480"] > .image2_ctrl > img {
  height:321px;
}
.pg_cgo_elearning_empty_portlet[Data-step="768"] > .image2_ctrl > img {
  height:463px;
}
.pg_cgo_elearning_empty_portlet[Data-step="320"] > .Label5_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:498px;
  left:0px;
  right:5px;
  width:auto;
  height:auto;
  min-height:20px;
}.pg_cgo_elearning_empty_portlet[Data-step="320"] > .Label5_ctrl {
  height:auto;
  min-height:20px;
}
.pg_cgo_elearning_empty_portlet[Data-step="480"] > .Label5_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:498px;
  left:0px;
  right:5px;
  width:auto;
  height:auto;
  min-height:20px;
}.pg_cgo_elearning_empty_portlet[Data-step="480"] > .Label5_ctrl {
  height:auto;
  min-height:20px;
}
.pg_cgo_elearning_empty_portlet[Data-step="768"] > .Label5_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:498px;
  left:0px;
  right:5px;
  width:auto;
  height:auto;
  min-height:20px;
}.pg_cgo_elearning_empty_portlet[Data-step="768"] > .Label5_ctrl {
  height:auto;
  min-height:20px;
}
.pg_cgo_elearning_empty_portlet > .Label5_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.pg_cgo_elearning_empty_portlet[Data-step="320"] > .Label5_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_elearning_empty_portlet[Data-step="480"] > .Label5_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_elearning_empty_portlet[Data-step="768"] > .Label5_ctrl > div{
  text-align:center;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
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
 String def="[{\"h\":\"600\",\"layout_steps_values\":{\"320\":{\"h\":\"300\",\"w\":\"100%\"},\"480\":{\"h\":\"300\",\"w\":\"100%\"},\"768\":{\"h\":\"600\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,768\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"463\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left(%)\",\"font_size\":\"\",\"h\":321,\"hide\":\"false\",\"w\":372,\"x\":67,\"y\":1},\"480\":{\"anchor\":\"top-left(%)\",\"font_size\":\"\",\"h\":321,\"hide\":\"false\",\"w\":372,\"x\":100,\"y\":1},\"768\":{\"anchor\":\"top-left-right\",\"font_size\":\"\",\"h\":463,\"hide\":\"false\",\"w\":482,\"x\":137,\"y\":10}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"482\",\"x\":\"137\",\"y\":\"10\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"20\",\"layout_steps_values\":{\"320\":{\"align\":\"center\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":\"315\",\"x\":0,\"y\":498},\"480\":{\"align\":\"center\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":\"475\",\"x\":0,\"y\":498},\"768\":{\"align\":\"center\",\"anchor\":\"top-left-right\",\"fontpct\":\"\",\"h\":20,\"hide\":\"false\",\"n_col\":1,\"w\":763,\"x\":0,\"y\":498}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"SISTEMA DI E-LEARNING NON ANCORA ATTIVO\",\"w\":\"763\",\"x\":\"0\",\"y\":\"498\",\"zindex\":\"2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_elearning_empty","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_elearning_empty_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_elearning_empty','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label5= "SISTEMA DI E-LEARNING NON ANCORA ATTIVO";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_cgo_elearning_empty_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_elearning_empty_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_elearning_empty','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_image2'>
<img id='<%=idPortlet%>_image2_img' class='image image2_ctrl' src="../images/aml.jpg" >
</div>
<span id='<%=idPortlet%>_Label5'  formid='<%=idPortlet%>' ps-name='Label5'    class='label Label5_ctrl'><div id='<%=idPortlet%>_Label5tbl' style='width:100%;'><%=JSPLib.ToHTML("SISTEMA DI E-LEARNING NON ANCORA ATTIVO")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_elearning_empty');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_elearning_empty',["768"],["600"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','','',{"320":{"h":"300","w":"100%"},"480":{"h":"300","w":"100%"},"768":{"h":"600","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"300"},"768":{"w":"100%","h":"600"},"480":{"w":"100%","h":"300"}},"w":"768","h":"600","title":"","layer":"false","npage":"1"}]);
this.image2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left-right","boundedPosition":"center","class_Css":"image image2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image2","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":463,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"bounded","layer":false,"layout_steps_values":{"320":{"anchor":"top-left(%)","font_size":"","h":321,"hide":"false","w":372,"x":67,"y":1},"480":{"anchor":"top-left(%)","font_size":"","h":321,"hide":"false","w":372,"x":100,"y":1},"768":{"anchor":"top-left-right","font_size":"","h":463,"hide":"false","w":482,"x":137,"y":10}},"name":"image2","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002faml.jpg","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":482,"x":137,"y":10,"zindex":"1"});
this.Label5=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label5","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"320":{"align":"center","anchor":"top-left-right","fontpct":"","h":20,"hide":"false","n_col":1,"w":"315","x":0,"y":498},"480":{"align":"center","anchor":"top-left-right","fontpct":"","h":20,"hide":"false","n_col":1,"w":"475","x":0,"y":498},"768":{"align":"center","anchor":"top-left-right","fontpct":"","h":20,"hide":"false","n_col":1,"w":763,"x":0,"y":498}},"n_col":1,"name":"Label5","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label5,false,true)%>","type":"Label","w":763,"x":0,"y":498,"zindex":"2"});
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
<%if(request.getAttribute("pg_cgo_elearning_empty_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_elearning_empty_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_elearning_empty_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_elearning_empty',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_elearning_empty');
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
sp.endPage("pg_cgo_elearning_empty");
}%>
<%! public String getJSPUID() { return "3051920324"; } %>