<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"bg_image":" ","cache_time":" ","color":"#FFFFFF","css":" ","css_class":"SiteMap","description":" ","form_action":" ","form_type":"false","h":"400","language":"true","my_library":" ","on_security_failure":"login","pages_names":" ","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"800","version":"37","w":"100%"},{"Root_node_value":"-1","anchor":"top-left","arrow_image":" ","bg_color":" ","bg_color_smenu":" ","btn_image":" ","btn_imageWidth":"0","btnover_image":" ","className":" ","close_level":"1","css":" ","dataobj":"xmlobj0","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","field_ChildCount":"elements","field_Css_Class":" ","field_Expr":" ","field_ExprNot":" ","field_Frame":"target","field_Icons":" ","field_NodeDescr":"caption","field_NodeID":"uid","field_NodeLink":"link","field_NodeParent":" ","field_NodeSeq":" ","font":" ","font_color":" ","font_color_smenu":" ","font_size":"0","font_weight":" ","h":"41","link_secondary":" ","max_level":"-1","menu_type":"flat","name":"MenuView","over_color":" ","over_color_smenu":" ","page":"1","separator":" ","separator_vert":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"MenuItem","target_default":"main","textover_color":" ","textover_color_smenu":" ","type":"MenuView","w":"752","x":"37","y":"72","z_index":"3"},{"async":"true","auto_exec":"true","name":"xmlobj0","page":"1","parms":" ","parms_source":" ","root":"\u002fSPVMNMenu","sequence":" ","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","x":"82","xmldataobj":" ","y":"244"},{"align":"center","anchor":"top-left","bg_color":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":"Tahoma","font_color":"#FFFFFF","font_size":"12pt","font_weight":"normal","h":"20","help_tips":" ","href":" ","name":"label2","page":"1","picture":" ","sequence":" ","tabindex":" ","target":" ","type":"Label","value":"MSG_MAP","w":"77","x":"9","y":"12","zindex":"1"},{"anchor":"top-right","dataobj":" ","field":" ","h":"256","help_tips":" ","href":" ","name":"image70_Copy","page":"1","path_type":"skin","sequence":" ","src":"..\u002fmenu\u002fworld.png","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"256","x":"538","y":"59","zindex":"1"},{"anchor":"top-left","dataobj":" ","field":" ","h":"400","help_tips":" ","href":" ","name":"spaceball","page":"1","path_type":" ","sequence":" ","src":"..\u002fvisualweb\u002fimages\u002fspaceball.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"2","x":"0","y":"0","zindex":"1"}]%>
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
window.sitemap_Static=function(){
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.xmlobj0.addRowConsumer(this.MenuView);

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.sitemap_container {
}
.sitemap_portlet{
  position:relative;
  width:100%;
  min-width:800px;
  height:400px;
  background-color:#FFFFFF;
}
.sitemap_portlet[Data-page="1"]{
  height:400px;
  width:100%;
}
.sitemap_portlet > .MenuView_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:72px;
  left:37px;
  width:752px;
  height:41px;
}
.sitemap_portlet .MenuView_ctrl,
.sitemap_portlet .MenuView_ctrl a{
}
.sitemap_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:9px;
  width:77px;
  height:auto;
  min-height:20px;
}
.sitemap_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.sitemap_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Tahoma;
  font-size:12pt;
  font-weight:normal;
  color:#FFFFFF;
  text-align:center;
}
.sitemap_portlet > .image70_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:59px;
  right:6px;
  width:256px;
  height:256px;
}
.sitemap_portlet > .image70_Copy_ctrl {
}
.sitemap_portlet > .image70_Copy_ctrl > img{
  width:100%;
  vertical-align:top;
  height:256px;
}
.sitemap_portlet > .spaceball_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:2px;
  height:400px;
}
.sitemap_portlet > .spaceball_ctrl {
}
.sitemap_portlet > .spaceball_ctrl > img{
  width:100%;
  vertical-align:top;
  height:400px;
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
 String def="[{\"h\":\"400\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\"},{\"anchor\":\"top-left\",\"h\":\"41\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"752\",\"x\":\"37\",\"y\":\"72\"},{\"page\":\"1\",\"type\":\"XMLDataobj\",\"x\":\"82\",\"y\":\"244\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"77\",\"x\":\"9\",\"y\":\"12\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"256\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"256\",\"x\":\"538\",\"y\":\"59\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"400\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"2\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"sitemap","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/sitemap_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','sitemap','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("sitemap_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewObj.js")%>'></script>
<%}
if(request.getAttribute("sitemap_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
String label2= "MSG_MAP";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='sitemap_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='sitemap_portlet SiteMap' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('sitemap','<%=idPortlet%>',false,'');
</script><%}}%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewFlatObj.js")%>'></script>
<div id='<%=idPortlet%>_MenuView' class='menuview_flat'></div>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("MSG_MAP"))%></div></span>
<div id='<%=idPortlet%>_image70_Copy'>
<img id='<%=idPortlet%>_image70_Copy_img' class=' image70_Copy_ctrl' src="../<%=sp.getSkin()%>/menu/world.png" >
</div>
<div id='<%=idPortlet%>_spaceball'>
<img id='<%=idPortlet%>_spaceball_img' class=' spaceball_ctrl' src="../visualweb/images/spaceball.gif" >
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','sitemap');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','sitemap',["800"],["400"],'SiteMap',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"400","title":" ","layer":"false","npage":"1"}]);
this.MenuView=new ZtVWeb.MenuViewFlatCtrl(this,{"anchor":"top-left","arrow_image":" ","bg_color":" ","bg_color_smenu":" ","bg_over_color":"","bg_over_color_smenu":"","btn_image":" ","btn_imageWidth":"0","btnover_image":" ","class_Css":" ","close_level":"1","ctrlid":"<%=idPortlet%>_MenuView","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","folder_path":"","font":" ","font_color":" ","font_color_smenu":" ","font_over_color":"","font_over_color_smenu":"","font_size":"0","font_weight":" ","h":41,"hide":"false","layer":false,"layout_steps_values":{},"link_secondary":" ","max_level":-1,"menu_type":"flat","name":"MenuView","page":1,"root_value":"-1","separator":" ","separator_vert":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"MenuItem","target_default":"main","type":"MenuView","w":752,"x":37,"y":72});
this.MenuView.setRowsCols('uid','elements','caption',' ',' ',' ',' ',' ','target','link',' ','', '','');
this.xmlobj0=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":true,"auto_exec":"true","ctrlid":"<%=idPortlet%>_xmlobj0","field":"","h":0,"hide":"false","layer":false,"layout_steps_values":{},"name":"xmlobj0","page":1,"parms":" ","parms_source":" ","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":0,"x":82,"xmldataobj":" ","y":244});
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Tahoma","font_color":"#FFFFFF","font_size":"12pt","font_weight":"normal","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":" ","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":"false","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(sp.translate(label2),false,true)%>","type":"Label","w":77,"x":9,"y":12,"zindex":"1"});
this.image70_Copy=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":" image70_Copy_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image70_Copy","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":256,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(" "),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image70_Copy","page":1,"path_type":"skin","server_side":"false","src":"..\u002f<%=sp.getSkin()%>\u002fmenu\u002fworld.png","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":256,"x":538,"y":59,"zindex":"1"});
this.spaceball=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":" spaceball_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_spaceball","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":400,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(" "),false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"spaceball","page":1,"path_type":"","server_side":"false","src":"..\u002fvisualweb\u002fimages\u002fspaceball.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":2,"x":0,"y":0,"zindex":"1"});
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
<%if(request.getAttribute("sitemap_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("sitemap_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.sitemap_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.xmlobj0.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','sitemap',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'sitemap');
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
sp.endPage("sitemap");
}%>
<%! public String getJSPUID() { return "562697133"; } %>