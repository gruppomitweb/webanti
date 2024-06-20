<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function linkPage(page){\n  if(window.opener!=null){\n     if(window.opener.GotoPage){\n        window.opener.GotoPage(page);\n    }\n    else if(window.GotoPage){\n        window.GotoPage(page);\n    }\n  }\n  else if(window.GotoPage){\n     window.GotoPage(page);\n  }\n}","bg_image":" ","cache_time":" ","color":" ","css":" ","css_class":" ","description":" ","form_action":" ","form_type":"false","h":"50","language":"false","my_library":" ","on_security_failure":"empty","pages_names":" ","positioning":"absolute","security":"logged","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"230","version":"37","w":"100%"},{"async":"false","auto_exec":"true","name":"xmlobj1","page":"1","parms":"file","parms_source":" ","root":"\u002fSPVMNMenu","sequence":" ","source":"..\u002fservlet\u002fIcePdfCatalog","type":"XMLDataobj","x":"0","xmldataobj":" ","y":"-41"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"request","name":"file","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"56","y":"-37"},{"Root_node_value":" ","anchor":" ","arrow_image":" ","bg_color":" ","bg_color_smenu":" ","btn_image":" ","btnimage_Width":" ","btnover_image":" ","className":"icepdftreeview","close_level":" ","css":" ","dataobj":"xmlobj1","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","field_ChildCount":"elements","field_Css_Class":" ","field_Expr":" ","field_ExprNot":" ","field_Frame":" ","field_Icons":" ","field_NodeDescr":"Caption","field_NodeID":" ","field_NodeLink":"link","field_NodeParent":" ","field_NodeSeq":" ","field_NodeTooltip":" ","field_level":" ","font":"Verdana","font_color":" ","font_color_smenu":" ","font_size":"10","font_weight":"Normal","h":"24","link_secondary":" ","max_level":"-1","menu_type":"slide","name":"MenuView3","over_color":" ","over_color_smenu":" ","page":"1","separator":" ","separator_vert":" ","server_side":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"Item","target_default":" ","textover_color":" ","textover_color_smenu":" ","type":"MenuView","w":"230","x":"0","y":"15","z_index":"1"}]%>
<%/*Description: */%>
<%/*ParamsRequest:file*/%>
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
window.SPIceCatalog_Static=function(){
if(typeof linkPage !='undefined')this.linkPage=linkPage;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.xmlobj1.addRowConsumer(this.MenuView3);
function linkPage(page){
  if(window.opener!=null){
     if(window.opener.GotoPage){
        window.opener.GotoPage(page);
    }
    else if(window.GotoPage){
        window.GotoPage(page);
    }
  }
  else if(window.GotoPage){
     window.GotoPage(page);
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
.SPIceCatalog_container {
}
.SPIceCatalog_portlet{
  position:relative;
  width:100%;
  min-width:230px;
  height:50px;
}
.SPIceCatalog_portlet[Data-page="1"]{
  height:50px;
  width:100%;
}
.SPIceCatalog_portlet > .MenuView3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:15px;
  left:0px;
  width:230px;
  height:24px;
}
.SPIceCatalog_portlet .MenuView3_ctrl,
.SPIceCatalog_portlet .MenuView3_ctrl a{
  font-family:Verdana;
  font-size:10px;
  font-weight:Normal;
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
 String def="[{\"h\":\"50\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"230\",\"w\":\"100%\"},{\"page\":\"1\",\"type\":\"XMLDataobj\",\"x\":\"0\",\"y\":\"-41\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"56\",\"y\":\"-37\"},{\"anchor\":\"\",\"h\":\"24\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"230\",\"x\":\"0\",\"y\":\"15\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPIceCatalog","UTF-8")) {return; }
 %><%if(!sp.isLogged()){
if (true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPIceCatalog_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPIceCatalog','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPIceCatalog_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
String file=JSPLib.translateXSS(sp.getParameter("file",""));
if(request.getAttribute("SPIceCatalog_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPIceCatalog_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPIceCatalog_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPIceCatalog','<%=idPortlet%>',false,'');
</script><%}}%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewSlideObj.js")%>'></script>
<div id='<%=idPortlet%>_MenuView3' class='icepdftreeview'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPIceCatalog');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPIceCatalog',["230"],["50"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"230","h":"50","title":" ","layer":"false","npage":"1"}]);
this.xmlobj1=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_xmlobj1","field":"","h":0,"hide":"false","layer":false,"layout_steps_values":{},"name":"xmlobj1","page":1,"parms":"file","parms_source":" ","root":"\u002fSPVMNMenu","source":"..\u002fservlet\u002fIcePdfCatalog","type":"XMLDataobj","w":0,"x":0,"xmldataobj":" ","y":-41});
this.file=new ZtVWeb._VC(this,'file',null,'character','<%=JSPLib.ToJSValue(file,false,true)%>',false,false);
this.MenuView3=new ZtVWeb.MenuViewSlideCtrl(this,{"anchor":" ","arrow_image":" ","bg_color":" ","bg_color_smenu":" ","bg_over_color":"","bg_over_color_smenu":"","btn_image":" ","btn_imageWidth":"","btnover_image":" ","class_Css":"icepdftreeview","close_level":" ","ctrlid":"<%=idPortlet%>_MenuView3","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","folder_path":"","font":"Verdana","font_color":" ","font_color_smenu":" ","font_over_color":"","font_over_color_smenu":"","font_size":"10","font_weight":"Normal","h":24,"hide":"false","layer":false,"layout_steps_values":{},"link_secondary":" ","max_level":-1,"menu_type":"slide","name":"MenuView3","page":1,"root_value":" ","separator":" ","separator_vert":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"Item","target_default":" ","type":"MenuView","w":230,"x":0,"y":15});
this.MenuView3.setRowsCols(' ','elements','Caption',' ',' ',' ',' ',' ',' ','link',' ',' ', '','');
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
<%if(request.getAttribute("SPIceCatalog_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPIceCatalog_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPIceCatalog_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.xmlobj1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','SPIceCatalog',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPIceCatalog');
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
sp.endPage("SPIceCatalog");
}%>
<%! public String getJSPUID() { return "469864700"; } %>