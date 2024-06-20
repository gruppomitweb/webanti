<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"bg_image":" ","cache_time":" ","color":"transparent","css":" ","css_class":" ","description":" ","form_action":" ","form_type":"false","h":"20","language":"false","my_library":" ","on_security_failure":"login","pages_names":" ","positioning":"absolute","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"170"},{"Root_node_value":"-1","anchor":" ","arrow_image":" ","bg_color":"transparent","bg_color_smenu":" ","btn_image":" ","btnimage_Width":" ","btnover_image":" ","className":" ","close_level":" ","css":" ","dataobj":"xmlobj0","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","field_ChildCount":"elements","field_Css_Class":" ","field_Expr":" ","field_ExprNot":" ","field_Frame":" ","field_Icons":" ","field_NodeDescr":"caption","field_NodeID":"uid","field_NodeLink":"link","field_NodeParent":" ","field_NodeSeq":" ","field_NodeTooltip":" ","field_level":" ","font":"Tahoma","font_color":"#0000FF","font_color_smenu":"#0000FF","font_size":"9","font_weight":"Bold","h":"20","link_secondary":" ","max_level":"-1","menu_type":"vertical","name":"MenuView0","over_color":"transparent","over_color_smenu":"#0000CC","page":"1","separator":" ","separator_vert":" ","server_side":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"MenuItem","target_default":"main","textover_color":"#0000FF","textover_color_smenu":"#000000","type":"MenuView","w":"170","x":"-1","y":"-1","z_index":"1"},{"async":"true","auto_exec":"true","name":"xmlobj0","page":"1","parms":"add_login=gUtility","parms_source":" ","root":"\u002fSPVMNMenu","sequence":" ","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","x":"144","xmldataobj":" ","y":"-41"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"global string","name":"gUtility","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"143","x":"1","y":"29"}]%>
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
window.menu_verti_Static=function(){
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.xmlobj0.addRowConsumer(this.MenuView0);

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.menu_verti_container {
}
.menu_verti_portlet{
  position:relative;
  width:170px;
  min-width:170px;
  height:20px;
  background-color:transparent;
}
.menu_verti_portlet[Data-page="1"]{
  height:20px;
  width:170px;
}
.menu_verti_portlet > .MenuView0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-1px;
  left:-1px;
  width:170px;
  height:20px;
}
.menu_verti_portlet .MenuView0_ctrl,
.menu_verti_portlet .MenuView0_ctrl a{
  font-family:Tahoma;
  font-size:9px;
  font-weight:Bold;
  color:#0000FF;
}
.menu_verti_portlet .MenuView0_ctrl .menuview_font{
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
 String def="[{\"h\":\"20\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"170\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"170\",\"x\":\"-1\",\"y\":\"-1\"},{\"page\":\"1\",\"type\":\"XMLDataobj\",\"x\":\"144\",\"y\":\"-41\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"143\",\"x\":\"1\",\"y\":\"29\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"menu_verti","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/menu_verti_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','menu_verti','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("menu_verti_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewObj.js")%>'></script>
<%}
if(request.getAttribute("menu_verti_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
String gUtility=sp.getGlobal("gUtility","");
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='menu_verti_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='menu_verti_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('menu_verti','<%=idPortlet%>',false,'');
</script><%}}%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewVerObj.js")%>'></script>
<div id='<%=idPortlet%>_MenuView0' class='menuview_vertical'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','menu_verti');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','menu_verti',["170"],["20"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"170","h":"20","title":" ","layer":"false","npage":"1"}]);
this.MenuView0=new ZtVWeb.MenuViewVerCtrl(this,{"anchor":" ","arrow_image":" ","bg_color":"transparent","bg_color_smenu":" ","bg_over_color":"","bg_over_color_smenu":"","btn_image":" ","btn_imageWidth":"","btnover_image":" ","class_Css":" ","close_level":" ","ctrlid":"<%=idPortlet%>_MenuView0","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","folder_path":"","font":"Tahoma","font_color":"#0000FF","font_color_smenu":"#0000FF","font_over_color":"","font_over_color_smenu":"","font_size":"9","font_weight":"Bold","h":20,"hide":"false","layer":false,"layout_steps_values":{},"link_secondary":" ","max_level":-1,"menu_type":"vertical","name":"MenuView0","page":1,"root_value":"-1","separator":" ","separator_vert":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"MenuItem","target_default":"main","type":"MenuView","w":170,"x":-1,"y":-1});
this.MenuView0.setRowsCols('uid','elements','caption',' ',' ',' ',' ',' ',' ','link',' ',' ', '','');
this.xmlobj0=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":true,"auto_exec":"true","ctrlid":"<%=idPortlet%>_xmlobj0","field":"","h":0,"hide":"false","layer":false,"layout_steps_values":{},"name":"xmlobj0","page":1,"parms":"add_login=gUtility","parms_source":" ","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fSPXMLMenuProvider","type":"XMLDataobj","w":0,"x":144,"xmldataobj":" ","y":-41});
this.gUtility=new ZtVWeb._VC(this,'gUtility',null,'character','<%=JSPLib.ToJSValue(gUtility,false,true)%>',false,false);
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
<%if(request.getAttribute("menu_verti_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("menu_verti_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.menu_verti_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.xmlobj0.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','menu_verti',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'menu_verti');
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
sp.endPage("menu_verti");
}%>
<%! public String getJSPUID() { return "535185008"; } %>