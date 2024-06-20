<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\nm_cLanguage='\u003c%=sp.getLanguage()%\u003e';\n\nvar par_val=this.UseImages.Value();\nthis.UseImages.typevar='logic';\nthis.UseImages.type='L';\nif(EmptyString(par_val) || par_val==\"true\"){\n  this.UseImages.Value(true);\n}\npar_val=this.DynamicFilters.Value();\nthis.DynamicFilters.typevar='logic';\nthis.DynamicFilters.type='L';\nif(EmptyString(par_val) || par_val=='true'){\n  this.DynamicFilters.Value(true);\n}\npar_val=this.ResetButton.Value();\nthis.ResetButton.typevar='logic';\nthis.ResetButton.type='L';\nif(EmptyString(par_val) || par_val=='true'){\n  this.ResetButton.Value(true);\n}\npar_val=this.EnableEdit.Value();\nthis.EnableEdit.typevar='logic';\nthis.EnableEdit.type='L';\nif(typeof(this.cfgBuilder_ctrl)!='undefined' && (EmptyString(par_val) || par_val=='true')){\n  this.EnableEdit.Value(true);\n}\n\nif(!ZtVWeb.SPPortalZoomParameters_staticJS)\n  ZtVWeb.SPPortalZoomParameters_staticJS=new ZtVWeb.JSURL(\"..\u002fSPPortalZoomParameters.js\").Response();\neval(ZtVWeb.SPPortalZoomParameters_staticJS);\n\nfunction this_SaveOk(){\n  this.DrawPortlet();\n  this.btn_filter_Click();\n}","bg_image":" ","cache_time":" ","color":" ","css":" ","css_class":" ","description":"Portlet che legge i filtri presenti in una configurazione di zoom VZM e la rappresenta in un portlet.","form_action":" ","form_type":"true","h":"30","language":"true","my_library":"controls.js,\u003c%=sp.getTheme()%\u003e\u002fcalendar.js,\u003c%=sp.getTheme()%\u003e\u002fstyleVariables.js","on_security_failure":"login","pages_names":" ","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"100","version":"37","w":"100%"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"Table","page":"1","sequence":"1","type":"Variable","typevar":"character","w":"107","x":"120","y":"-2"},{"anchor":"top-left","h":"28","name":"cfgBuilder","page":"1","sequence":"1","src":"..\u002fjsp-system\u002fSPPortalZoomConfigurationBuilder_portlet.jsp","type":"Portlet","w":"28","x":"0","y":"0"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"ConfigName","page":"1","sequence":"2","type":"Variable","typevar":"character","w":"107","x":"231","y":"-2"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"VQRName","page":"1","sequence":"2","type":"Variable","typevar":"character","w":"107","x":"341","y":"-2"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"EmitterName","page":"1","sequence":"3","type":"Variable","typevar":"character","w":"107","x":"120","y":"25"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"ReceiverName","page":"1","sequence":"3","type":"Variable","typevar":"character","w":"107","x":"231","y":"25"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"Mode","page":"1","sequence":"4","type":"Variable","typevar":"character","w":"107","x":"120","y":"52"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"Columns","page":"1","sequence":"5","type":"Variable","typevar":"numeric","w":"107","x":"231","y":"52"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"Width","page":"1","sequence":"6","type":"Variable","typevar":"numeric","w":"107","x":"120","y":"79"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"MaxFieldWidth","page":"1","sequence":"7","type":"Variable","typevar":"numeric","w":"107","x":"231","y":"79"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"OffsetTop","page":"1","sequence":"7","type":"Variable","typevar":"numeric","w":"107","x":"121","y":"252"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"OperationSelect","page":"1","sequence":"9","type":"Variable","typevar":"logic","w":"107","x":"231","y":"186"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"DynamicFilters","page":"1","sequence":"10","type":"Variable","typevar":"character","w":"107","x":"120","y":"133"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"AddAutoZoom","page":"1","sequence":"11","type":"Variable","typevar":"character","w":"107","x":"231","y":"133"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"FilterButtonCaption","page":"1","sequence":"12","type":"Variable","typevar":"character","w":"107","x":"120","y":"160"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"FilterAddButtonCaption","page":"1","sequence":"13","type":"Variable","typevar":"character","w":"107","x":"231","y":"160"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"FilterRefreshButtonCaption","page":"1","sequence":"13","type":"Variable","typevar":"character","w":"107","x":"341","y":"160"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"ResetButton","page":"1","sequence":"14","type":"Variable","typevar":"character","w":"107","x":"120","y":"187"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"ReportName","page":"1","sequence":"15","type":"Variable","typevar":"character","w":"107","x":"120","y":"224"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"PrintFormat","page":"1","sequence":"15","type":"Variable","typevar":"character","w":"107","x":"231","y":"224"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"PrintOrientation","page":"1","sequence":"15","type":"Variable","typevar":"character","w":"107","x":"341","y":"224"},{"eventsNames":" ","eventsObjs":" ","h":"20","name":"$entity$_zoomSetFilter","page":"1","parmsNames":"row","parmsTypes":"func","parmsValues":"this.GetFilters()","sequence":"19","type":"EventEmitter","w":"22","x":"120","y":"-34"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"UseImages","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"107","x":"120","y":"106"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"EnableEdit","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"107","x":"121","y":"280"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"ToolbarLabels","page":"1","sequence":" ","type":"Variable","typevar":"logic","w":"107","x":"231","y":"106"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"ToolbarAlign","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"107","x":"341","y":"106"},{"dataobj":" ","field":" ","h":"22","init_par":"request","name":"ReadFieldNewLine","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"107","x":"231","y":"252"},{"actObjs":" ","actTypes":"func","h":"20","included":"false","name":"$entity$_updateFilters","objsValues":"this.UpdateTempFilters(evt.Filters)","page":"1","parmsNames":"Filters","sequence":" ","type":"EventReceiver","w":"22","x":"169","y":"-34"},{"actObjs":" ","actTypes":"func","h":"20","included":"false","name":"$entity$_updateConfiguration","objsValues":"this.SetConfiguration(evt)","page":"1","parmsNames":"Config,reload","sequence":" ","type":"EventReceiver","w":"22","x":"230","y":"-37"}]%>
<%/*Description:Portlet che legge i filtri presenti in una configurazione di zoom VZM e la rappresenta in un portlet.*/%>
<%/*ParamsRequest:Table,ConfigName,VQRName,EmitterName,ReceiverName,Mode,Columns,Width,MaxFieldWidth,OffsetTop,OperationSelect,DynamicFilters,AddAutoZoom,FilterButtonCaption,FilterAddButtonCaption,FilterRefreshButtonCaption,ResetButton,ReportName,PrintFormat,PrintOrientation,UseImages,EnableEdit,ToolbarLabels,ToolbarAlign,ReadFieldNewLine*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
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
.SPPortalZoomParameters_container {
}
.SPPortalZoomParameters_portlet{
  position:relative;
  width:100%;
  min-width:100px;
  height:30px;
}
.SPPortalZoomParameters_portlet[Data-page="1"]{
  height:30px;
  width:100%;
}
.SPPortalZoomParameters_portlet > .cfgBuilder_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:28px;
  height:auto;
  min-height:28px;
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
 String def="[{\"h\":\"30\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"100\",\"w\":\"100%\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"-2\"},{\"anchor\":\"top-left\",\"h\":\"28\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"28\",\"x\":\"0\",\"y\":\"0\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"-2\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"341\",\"y\":\"-2\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"25\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"25\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"52\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"52\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"79\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"79\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"121\",\"y\":\"252\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"186\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"133\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"133\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"160\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"160\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"341\",\"y\":\"160\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"187\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"224\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"224\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"341\",\"y\":\"224\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"120\",\"y\":\"-34\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"120\",\"y\":\"106\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"121\",\"y\":\"280\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"106\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"341\",\"y\":\"106\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"107\",\"x\":\"231\",\"y\":\"252\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"169\",\"y\":\"-34\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"230\",\"y\":\"-37\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomParameters","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPPortalZoomParameters_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath(""+sp.getTheme()+"/calendar.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath(""+sp.getTheme()+"/styleVariables.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomParameters','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Table=JSPLib.translateXSS(sp.getParameter("Table",""));
String ConfigName=JSPLib.translateXSS(sp.getParameter("ConfigName",""));
String VQRName=JSPLib.translateXSS(sp.getParameter("VQRName",""));
String EmitterName=JSPLib.translateXSS(sp.getParameter("EmitterName",""));
String ReceiverName=JSPLib.translateXSS(sp.getParameter("ReceiverName",""));
String Mode=JSPLib.translateXSS(sp.getParameter("Mode",""));
double Columns=sp.getParameter("Columns",0);
double Width=sp.getParameter("Width",0);
double MaxFieldWidth=sp.getParameter("MaxFieldWidth",0);
double OffsetTop=sp.getParameter("OffsetTop",0);
boolean OperationSelect=sp.getParameter("OperationSelect",false);
String DynamicFilters=JSPLib.translateXSS(sp.getParameter("DynamicFilters",""));
String AddAutoZoom=JSPLib.translateXSS(sp.getParameter("AddAutoZoom",""));
String FilterButtonCaption=JSPLib.translateXSS(sp.getParameter("FilterButtonCaption",""));
String FilterAddButtonCaption=JSPLib.translateXSS(sp.getParameter("FilterAddButtonCaption",""));
String FilterRefreshButtonCaption=JSPLib.translateXSS(sp.getParameter("FilterRefreshButtonCaption",""));
String ResetButton=JSPLib.translateXSS(sp.getParameter("ResetButton",""));
String ReportName=JSPLib.translateXSS(sp.getParameter("ReportName",""));
String PrintFormat=JSPLib.translateXSS(sp.getParameter("PrintFormat",""));
String PrintOrientation=JSPLib.translateXSS(sp.getParameter("PrintOrientation",""));
String UseImages=JSPLib.translateXSS(sp.getParameter("UseImages",""));
String EnableEdit=JSPLib.translateXSS(sp.getParameter("EnableEdit",""));
boolean ToolbarLabels=sp.getParameter("ToolbarLabels",false);
String ToolbarAlign=JSPLib.translateXSS(sp.getParameter("ToolbarAlign",""));
String ReadFieldNewLine=JSPLib.translateXSS(sp.getParameter("ReadFieldNewLine",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomParameters_container'>
<form id='<%=idPortlet%>_form' name='<%=idPortlet%>_form' METHOD='POST' style='MARGIN:0' onsubmit='if(window.<%=idPortlet%>.this_OnSubmit)return window.<%=idPortlet%>.this_OnSubmit();'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomParameters_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomParameters','<%=idPortlet%>',false,'');
</script><%}}%>
<input id='<%=idPortlet%>_Table' name='Table' type='hidden'/>
<div id='<%=idPortlet%>_cfgBuilder'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp-system/SPPortalZoomConfigurationBuilder_portlet.jsp?ForcedPortletUID="+idPortlet+"_1jk9h1z",false);%></div>
<input id='<%=idPortlet%>_ConfigName' name='ConfigName' type='hidden'/>
<input id='<%=idPortlet%>_VQRName' name='VQRName' type='hidden'/>
<input id='<%=idPortlet%>_EmitterName' name='EmitterName' type='hidden'/>
<input id='<%=idPortlet%>_ReceiverName' name='ReceiverName' type='hidden'/>
<input id='<%=idPortlet%>_Mode' name='Mode' type='hidden'/>
<input id='<%=idPortlet%>_Columns' name='Columns' type='hidden'/>
<input id='<%=idPortlet%>_Width' name='Width' type='hidden'/>
<input id='<%=idPortlet%>_MaxFieldWidth' name='MaxFieldWidth' type='hidden'/>
<input id='<%=idPortlet%>_OffsetTop' name='OffsetTop' type='hidden'/>
<input id='<%=idPortlet%>_OperationSelect' name='OperationSelect' type='hidden'/>
<input id='<%=idPortlet%>_DynamicFilters' name='DynamicFilters' type='hidden'/>
<input id='<%=idPortlet%>_AddAutoZoom' name='AddAutoZoom' type='hidden'/>
<input id='<%=idPortlet%>_FilterButtonCaption' name='FilterButtonCaption' type='hidden'/>
<input id='<%=idPortlet%>_FilterAddButtonCaption' name='FilterAddButtonCaption' type='hidden'/>
<input id='<%=idPortlet%>_FilterRefreshButtonCaption' name='FilterRefreshButtonCaption' type='hidden'/>
<input id='<%=idPortlet%>_ResetButton' name='ResetButton' type='hidden'/>
<input id='<%=idPortlet%>_ReportName' name='ReportName' type='hidden'/>
<input id='<%=idPortlet%>_PrintFormat' name='PrintFormat' type='hidden'/>
<input id='<%=idPortlet%>_PrintOrientation' name='PrintOrientation' type='hidden'/>
<input id='<%=idPortlet%>_UseImages' name='UseImages' type='hidden'/>
<input id='<%=idPortlet%>_EnableEdit' name='EnableEdit' type='hidden'/>
<input id='<%=idPortlet%>_ToolbarLabels' name='ToolbarLabels' type='hidden'/>
<input id='<%=idPortlet%>_ToolbarAlign' name='ToolbarAlign' type='hidden'/>
<input id='<%=idPortlet%>_ReadFieldNewLine' name='ReadFieldNewLine' type='hidden'/>
</div>
</form>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomParameters');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomParameters',["100"],["30"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"100","h":"30","title":" ","layer":"false","npage":"1"}]);
this.Table=new ZtVWeb._VC(this,'Table','<%=idPortlet%>_Table','character','<%=JSPLib.ToJSValue(Table,false,true)%>',false,false);
if(this.cfgBuilder=ZtVWeb.getPortletInc('<%=idPortlet%>_cfgBuilder')){
this.cfgBuilder.setContainer(this,'cfgBuilder')
this.cfgBuilder_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left","ctrlid":"<%=idPortlet%>_cfgBuilder","h":28,"hide":"false","layer":false,"layout_steps_values":{},"name":"cfgBuilder","page":1,"portlet_id":"<%=idPortlet%>_1jk9h1z","type":"Portlet","w":28,"x":0,"y":0});
} else {
document.getElementById('<%=idPortlet%>_cfgBuilder').style.display='none';
}
this.ConfigName=new ZtVWeb._VC(this,'ConfigName','<%=idPortlet%>_ConfigName','character','<%=JSPLib.ToJSValue(ConfigName,false,true)%>',false,false);
this.VQRName=new ZtVWeb._VC(this,'VQRName','<%=idPortlet%>_VQRName','character','<%=JSPLib.ToJSValue(VQRName,false,true)%>',false,false);
this.EmitterName=new ZtVWeb._VC(this,'EmitterName','<%=idPortlet%>_EmitterName','character','<%=JSPLib.ToJSValue(EmitterName,false,true)%>',false,false);
this.ReceiverName=new ZtVWeb._VC(this,'ReceiverName','<%=idPortlet%>_ReceiverName','character','<%=JSPLib.ToJSValue(ReceiverName,false,true)%>',false,false);
this.Mode=new ZtVWeb._VC(this,'Mode','<%=idPortlet%>_Mode','character','<%=JSPLib.ToJSValue(Mode,false,true)%>',false,false);
this.Columns=new ZtVWeb._VC(this,'Columns','<%=idPortlet%>_Columns','numeric',<%=Columns%>,false,false);
this.Width=new ZtVWeb._VC(this,'Width','<%=idPortlet%>_Width','numeric',<%=Width%>,false,false);
this.MaxFieldWidth=new ZtVWeb._VC(this,'MaxFieldWidth','<%=idPortlet%>_MaxFieldWidth','numeric',<%=MaxFieldWidth%>,false,false);
this.OffsetTop=new ZtVWeb._VC(this,'OffsetTop','<%=idPortlet%>_OffsetTop','numeric',<%=OffsetTop%>,false,false);
this.OperationSelect=new ZtVWeb._VC(this,'OperationSelect','<%=idPortlet%>_OperationSelect','logic',<%=OperationSelect%>,false,false);
this.DynamicFilters=new ZtVWeb._VC(this,'DynamicFilters','<%=idPortlet%>_DynamicFilters','character','<%=JSPLib.ToJSValue(DynamicFilters,false,true)%>',false,false);
this.AddAutoZoom=new ZtVWeb._VC(this,'AddAutoZoom','<%=idPortlet%>_AddAutoZoom','character','<%=JSPLib.ToJSValue(AddAutoZoom,false,true)%>',false,false);
this.FilterButtonCaption=new ZtVWeb._VC(this,'FilterButtonCaption','<%=idPortlet%>_FilterButtonCaption','character','<%=JSPLib.ToJSValue(FilterButtonCaption,false,true)%>',false,false);
this.FilterAddButtonCaption=new ZtVWeb._VC(this,'FilterAddButtonCaption','<%=idPortlet%>_FilterAddButtonCaption','character','<%=JSPLib.ToJSValue(FilterAddButtonCaption,false,true)%>',false,false);
this.FilterRefreshButtonCaption=new ZtVWeb._VC(this,'FilterRefreshButtonCaption','<%=idPortlet%>_FilterRefreshButtonCaption','character','<%=JSPLib.ToJSValue(FilterRefreshButtonCaption,false,true)%>',false,false);
this.ResetButton=new ZtVWeb._VC(this,'ResetButton','<%=idPortlet%>_ResetButton','character','<%=JSPLib.ToJSValue(ResetButton,false,true)%>',false,false);
this.ReportName=new ZtVWeb._VC(this,'ReportName','<%=idPortlet%>_ReportName','character','<%=JSPLib.ToJSValue(ReportName,false,true)%>',false,false);
this.PrintFormat=new ZtVWeb._VC(this,'PrintFormat','<%=idPortlet%>_PrintFormat','character','<%=JSPLib.ToJSValue(PrintFormat,false,true)%>',false,false);
this.PrintOrientation=new ZtVWeb._VC(this,'PrintOrientation','<%=idPortlet%>_PrintOrientation','character','<%=JSPLib.ToJSValue(PrintOrientation,false,true)%>',false,false);
this.$entity$_zoomSetFilter=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_zoomSetFilter","eventsNames":" ","eventsObjs":" ","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"$entity$_zoomSetFilter","page":1,"parmsNames":"row","parmsTypes":"func","parmsValues":"this.GetFilters()","persistent":"true","type":"EventEmitter","w":22,"x":120,"y":-34});
this.UseImages=new ZtVWeb._VC(this,'UseImages','<%=idPortlet%>_UseImages','character','<%=JSPLib.ToJSValue(UseImages,false,true)%>',false,false);
this.EnableEdit=new ZtVWeb._VC(this,'EnableEdit','<%=idPortlet%>_EnableEdit','character','<%=JSPLib.ToJSValue(EnableEdit,false,true)%>',false,false);
this.ToolbarLabels=new ZtVWeb._VC(this,'ToolbarLabels','<%=idPortlet%>_ToolbarLabels','logic',<%=ToolbarLabels%>,false,false);
this.ToolbarAlign=new ZtVWeb._VC(this,'ToolbarAlign','<%=idPortlet%>_ToolbarAlign','character','<%=JSPLib.ToJSValue(ToolbarAlign,false,true)%>',false,false);
this.ReadFieldNewLine=new ZtVWeb._VC(this,'ReadFieldNewLine','<%=idPortlet%>_ReadFieldNewLine','character','<%=JSPLib.ToJSValue(ReadFieldNewLine,false,true)%>',false,false);
this.$entity$_updateFilters=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":" ","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_updateFilters","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateFilters","objsValues":"this.UpdateTempFilters(evt.Filters)","page":1,"parmsNames":"Filters","type":"EventReceiver","w":22,"x":169,"y":-34});
this.$entity$_updateConfiguration=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":" ","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_$entity$_updateConfiguration","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"$entity$_updateConfiguration","objsValues":"this.SetConfiguration(evt)","page":1,"parmsNames":"Config,reload","type":"EventReceiver","w":22,"x":230,"y":-37});
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
<%request.setAttribute("SPPortalZoomParameters_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomParameters_Static=function(){
if(typeof this_SaveOk !='undefined')this.this_SaveOk=this_SaveOk;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>

m_cLanguage='<%=sp.getLanguage()%>';
var par_val=this.UseImages.Value();
this.UseImages.typevar='logic';
this.UseImages.type='L';
if(EmptyString(par_val) || par_val=="true"){
  this.UseImages.Value(true);
}
par_val=this.DynamicFilters.Value();
this.DynamicFilters.typevar='logic';
this.DynamicFilters.type='L';
if(EmptyString(par_val) || par_val=='true'){
  this.DynamicFilters.Value(true);
}
par_val=this.ResetButton.Value();
this.ResetButton.typevar='logic';
this.ResetButton.type='L';
if(EmptyString(par_val) || par_val=='true'){
  this.ResetButton.Value(true);
}
par_val=this.EnableEdit.Value();
this.EnableEdit.typevar='logic';
this.EnableEdit.type='L';
if(typeof(this.cfgBuilder_ctrl)!='undefined' && (EmptyString(par_val) || par_val=='true')){
  this.EnableEdit.Value(true);
}
if(!ZtVWeb.SPPortalZoomParameters_staticJS)
  ZtVWeb.SPPortalZoomParameters_staticJS=new ZtVWeb.JSURL("../SPPortalZoomParameters.js").Response();
eval(ZtVWeb.SPPortalZoomParameters_staticJS);
function this_SaveOk(){
  this.DrawPortlet();
  this.btn_filter_Click();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomParameters_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.$entity$_zoomSetFilter.setParms();
window.<%=idPortlet%>.on_$entity$_updateFilters=function(parmsObj){<%=idPortlet%>.$entity$_updateFilters.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_$entity$_updateConfiguration=function(parmsObj){<%=idPortlet%>.$entity$_updateConfiguration.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomParameters',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomParameters');
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
sp.endPage("SPPortalZoomParameters");
}%>
<%! public String getJSPUID() { return "152092459"; } %>