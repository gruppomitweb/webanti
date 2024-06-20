<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function addTreeItem(name, typef) {\n  if (window.addTreeItem) {\n    window.addTreeItem(name, typef);\n  }\n\n  if (window.opener != null) {\n    if (window.opener.addTreeItem) {\n      window.opener.addTreeItem(name, typef);\n    }\n  }\n}\n\nfunction this_Loaded() {\n  this.xmlobj1.source = this.file.Value();\n  this.xmlobj1.firstQuery('true');\n}\n\n\u002f\u002fRidefinito il metodo per l'apertura e la chiusura dei sottomenu per poter implementare la\n\u002f\u002fchiamata per ridimensionare il div contenitore del portlet.\nthis.MenuViewObj.view=function(nodeView) {\n  var ctrl = this.getCtrlElementSubMenu(nodeView.index);\n  var parentCtrl = this.getCtrlElementMenu(nodeView.index);\n  \u002f\u002f sotto voci menu da disegnare su questo menu (inline)\n  if (nodeView.children.length \u003e 0) {\n    if (nodeView.opened) {\n      if (ctrl.innerHTML.indexOf(\"__LOADING__\") != -1) {\n        ctrl.innerHTML = this.drawSlideItems(nodeView);\n        ctrl.style.display = \"block\";\n      } else {\n        ctrl.style.display = \"block\";\n      }\n      parentCtrl.className = \"opened\";\n    } else {\n      ctrl.style.display = \"none\";\n      parentCtrl.className = \"closed\";\n    }\n    this.adjustFormHeight();\n    if (window.resizeDivContainer) { window.resizeDivContainer(); }\n  } else {\n    ctrl.innerHTML = \"\";\n  }\n}","bg_image":" ","cache_in_post":"false","cache_time":" ","color":" ","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":" ","form_target":" ","form_type":"false","h":"50","hsl":" ","language":"false","lock_items":"false","manifest":" ","my_library":" ","offline":" ","on_security_failure":"empty","pages_names":" ","positioning":"absolute","roles":" ","security":"logged","server_cache_time":" ","shared_manifest":"false","sp_theme":"false","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"230","version":"37","w":"100%"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"request","name":"file","page":"1","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"56","y":"-37"},{"async":"false","auto_exec":"false","name":"xmlobj1","page":"1","parms":" ","parms_source":" ","root":"\u002fSPVMNMenu","sequence":"2","source":" ","type":"XMLDataobj","x":"0","xmldataobj":" ","y":"-41"},{"Root_node_value":" ","anchor":" ","arrow_image":" ","bg_color":" ","bg_color_smenu":" ","btn_image":" ","btnimage_Width":" ","btnover_image":" ","className":"fieldstreeview","close_level":" ","css":" ","dataobj":"xmlobj1","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","field_ChildCount":"elements","field_Css_Class":" ","field_Expr":" ","field_ExprNot":" ","field_Frame":" ","field_Icons":"icon","field_NodeDescr":"SPDescription","field_NodeID":" ","field_NodeLink":"link","field_NodeParent":" ","field_NodeSeq":" ","field_NodeTooltip":"SPName","field_level":" ","font":"Verdana","font_color":" ","font_color_smenu":" ","font_size":"10","font_weight":"Normal","h":"24","link_secondary":" ","max_level":"-1","menu_type":"slide","name":"MenuViewObj","over_color":" ","over_color_smenu":" ","page":"1","separator":" ","separator_vert":" ","server_side":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"Item","target_default":" ","textover_color":" ","textover_color_smenu":" ","type":"MenuView","w":"230","x":"0","y":"5","z_index":"1"}]%>
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
window.SPModFields_Static=function(){
if(typeof addTreeItem !='undefined')this.addTreeItem=addTreeItem;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.xmlobj1.addRowConsumer(this.MenuViewObj);
function addTreeItem(name, typef) {
  if (window.addTreeItem) {
    window.addTreeItem(name, typef);
  }
  if (window.opener != null) {
    if (window.opener.addTreeItem) {
      window.opener.addTreeItem(name, typef);
    }
  }
}
function this_Loaded() {
  this.xmlobj1.source = this.file.Value();
  this.xmlobj1.firstQuery('true');
}
//Ridefinito il metodo per l'apertura e la chiusura dei sottomenu per poter implementare la
//chiamata per ridimensionare il div contenitore del portlet.
this.MenuViewObj.view=function(nodeView) {
  var ctrl = this.getCtrlElementSubMenu(nodeView.index);
  var parentCtrl = this.getCtrlElementMenu(nodeView.index);
  // sotto voci menu da disegnare su questo menu (inline)
  if (nodeView.children.length > 0) {
    if (nodeView.opened) {
      if (ctrl.innerHTML.indexOf("__LOADING__") != -1) {
        ctrl.innerHTML = this.drawSlideItems(nodeView);
        ctrl.style.display = "block";
      } else {
        ctrl.style.display = "block";
      }
      parentCtrl.className = "opened";
    } else {
      ctrl.style.display = "none";
      parentCtrl.className = "closed";
    }
    this.adjustFormHeight();
    if (window.resizeDivContainer) { window.resizeDivContainer(); }
  } else {
    ctrl.innerHTML = "";
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
.SPModFields_container {
}
.SPModFields_portlet{
  position:relative;
  width:100%;
  min-width:230px;
  height:50px;
}
.SPModFields_portlet[Data-page="1"]{
  height:50px;
  width:100%;
}
.SPModFields_portlet > .MenuViewObj_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:5px;
  left:0px;
  width:230px;
  height:24px;
}
.SPModFields_portlet .MenuViewObj_ctrl,
.SPModFields_portlet .MenuViewObj_ctrl a{
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
 String def="[{\"h\":\"50\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"230\",\"w\":\"100%\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"56\",\"y\":\"-37\"},{\"page\":\"1\",\"type\":\"XMLDataobj\",\"x\":\"0\",\"y\":\"-41\"},{\"anchor\":\"\",\"h\":\"24\",\"page\":\"1\",\"type\":\"MenuView\",\"w\":\"230\",\"x\":\"0\",\"y\":\"5\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPModFields","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPModFields_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPModFields','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String file=JSPLib.translateXSS(sp.getParameter("file",""));
if(request.getAttribute("SPModFields_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
<%}
if(request.getAttribute("SPModFields_firstinclusion")==null){%>
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
<div id='<%=idPortlet%>_container' class='SPModFields_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPModFields_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPModFields','<%=idPortlet%>',false,' ');
</script><%}}%>
<script src='../<%=SPPrxycizer.proxycizedPath("MenuViewSlideObj.js")%>'></script>
<div id='<%=idPortlet%>_MenuViewObj' class='fieldstreeview'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPModFields');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("XML_RESOURCE_NOT_AVAILABLE",true)+","+JSPLib.ToJSValue(sp.translate("XML_RESOURCE_NOT_AVAILABLE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPModFields',["230"],["50"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"230","h":"50","title":" ","layer":"false","npage":"1"}]);
this.file=new ZtVWeb._VC(this,'file',null,'character','<%=JSPLib.ToJSValue(file,false,true)%>',false,false);
this.xmlobj1=new ZtVWeb.XMLDataProvider(this,{"anchor":"","async":false,"auto_exec":"false","ctrlid":"<%=idPortlet%>_xmlobj1","field":"","h":0,"hide":"false","layer":false,"layout_steps_values":{},"name":"xmlobj1","page":1,"parms":" ","parms_source":" ","root":"\u002fSPVMNMenu","source":" ","type":"XMLDataobj","w":0,"x":0,"xmldataobj":" ","y":-41});
this.MenuViewObj=new ZtVWeb.MenuViewSlideCtrl(this,{"anchor":" ","arrow_image":" ","bg_color":" ","bg_color_smenu":" ","bg_over_color":"","bg_over_color_smenu":"","btn_image":" ","btn_imageWidth":"","btnover_image":" ","class_Css":"fieldstreeview","close_level":" ","ctrlid":"<%=idPortlet%>_MenuViewObj","dx_btn_image":" ","dx_btnover_image":" ","emitter_name":" ","folder_path":"","font":"Verdana","font_color":" ","font_color_smenu":" ","font_over_color":"","font_over_color_smenu":"","font_size":"10","font_weight":"Normal","h":24,"hide":"false","layer":false,"layout_steps_values":{},"link_secondary":" ","max_level":-1,"menu_type":"slide","name":"MenuViewObj","page":1,"root_value":" ","separator":" ","separator_vert":" ","sx_btn_image":" ","sx_btnover_image":" ","tag_node":"Item","target_default":" ","type":"MenuView","w":230,"x":0,"y":5});
this.MenuViewObj.setRowsCols(' ','elements','SPDescription',' ',' ','icon',' ',' ',' ','link',' ','SPName', '','');
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
<%if(request.getAttribute("SPModFields_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("SPModFields_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.SPModFields_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPModFields',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPModFields');
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
sp.endPage("SPModFields");
}%>
<%! public String getJSPUID() { return "410144866"; } %>