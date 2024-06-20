<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  document.getElementById(this.formid).style.overflow = 'hidden';\n  document.getElementById(this.formid).style.position = 'absolute';\n  document.getElementById(this.formid).style.top = '0px';\n  document.getElementById(this.formid).style.bottom = '0px';\n  document.getElementById(this.formid).style.height = 'auto';\n  var cpup = document.getElementById('uploader_filelist');\n  if(cpup==null){\n    cpup = document.getElementById('uploader');\n    if(cpup) cpup.style.display='none';\n  }\n  else{\n    \u002f\u002fdocument.getElementById(this.formid+'_imgUploadhref').style.display='none';\n  }\n}\n\nfunction SpUpload_UploadCompleted(){\n  var wind = (window.opener?window.opener:(window.caller?window.caller:window.parent));\n  if(wind && wind.LoadPdf) {\n    \u003c%\n      String appLocation = \"'\" + JSPLib.ToJSValue(Library.GetWebRootPath()) + \"'\";\n    %\u003e\n    wind.LoadPdf(\u003c%=appLocation%\u003e + this.SpUpload.GetFileUploaded(),true);\n  }\n}\n\n\nthis.SpUpload.Ctrl.addEventListener(\"click\", function() {\n  this.SpUpload.SelectFile();\n}.bind(this));","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\",\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"SpUploadPdf\",\"selector\":\".SpUploadPdf\",\"id\":\"form\",\"code\":\".SpUploadPdf {\\n  cursor: pointer;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\",\"cursor\":\"pointer\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"SpUploadPdf\",\"selector\":\".drag \u003e .SpUploadPdf .message_holder, .SpUploadPdf .drag \u003e .SpUploadPdf .message_holder_uploading\",\"id\":\"form\",\"code\":\".drag \u003e .SpUploadPdf .message_holder, .SpUploadPdf .drag \u003e .SpUploadPdf .message_holder_uploading {\\n  cursor: pointer;\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"200","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"true","tabstrip_class":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"200","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","css_class":"SpUploadPdf","custom_file_prefix":"","extallowed":"pdf","file_prefix":"contextId_cpccchk","h":"200","hide":"false","layout_steps_values":"{}","my_max_file_size":"100","name":"SpUpload","page":"1","sequence":"1","style_mode":"drag","submiturl":"","type":"SpUpload","uploaddir":"Tmp\u002f","w":"200","wireframe_props":"","x":"0","y":"0","zindex":""}]%>
<%/*Description:*/%>
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
.SPZviewer_upload_container .SpUploadPdf{  cursor: pointer;
}
.SPZviewer_upload_container .drag > .SpUploadPdf .message_holder, .SpUploadPdf .drag > .SpUploadPdf .message_holder_uploading{
  cursor: pointer;
}
.SPZviewer_upload_container {
  height:100%;
  overflow:auto;
}
.SPZviewer_upload_portlet{
  position:relative;
  width:100%;
  min-width:200px;
  height:100%;
}
.SPZviewer_upload_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.SPZviewer_upload_portlet > .SpUpload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
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
 String def="[{\"h\":\"200\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"200\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"200\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"SpUpload\",\"w\":\"200\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPZviewer_upload","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPZviewer_upload_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPZviewer_upload','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("SPZviewer_upload_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("SpUploadObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPZviewer_upload_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPZviewer_upload_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPZviewer_upload','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_SpUpload' class='drag'><div id='uploader_<%=idPortlet%>_SpUpload' class='SpUpload SpUploadPdf'><div id='uploader_holder_<%=idPortlet%>_SpUpload' class='uploader_holder'></div><label id='uploader_button_<%=idPortlet%>_SpUpload' class='button' for='uploader_input_file_<%=idPortlet%>_SpUpload' style='display: none'><%=Library.ToHTML(sp.translate("SPUPLOAD_MSG_CHOOSE_FILE"),"C",0,0)%>…</label><input id='uploader_input_file_<%=idPortlet%>_SpUpload' class='uploader_input_file' type='file' name='file' style='display: none' multiple></div></div></div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPZviewer_upload');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_ABORT",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_ABORT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_CANCEL_UPLOAD",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_CANCEL_UPLOAD"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_CHOOSE_FILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_CHOOSE_FILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_DRAG_FILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_DRAG_FILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_FILE_SELECTED",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_FILE_SELECTED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_MAX_FILE_SIZE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_MAX_FILE_SIZE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_MULTI_UPLOAD_ERROR",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_MULTI_UPLOAD_ERROR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_NOFILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_NOFILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_UNSUPPORTED_FILE",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_UNSUPPORTED_FILE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_UNSUPPORTED_HTML5",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_UNSUPPORTED_HTML5"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("SPUPLOAD_MSG_UPLOADING",true)+","+JSPLib.ToJSValue(sp.translate("SPUPLOAD_MSG_UPLOADING"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','SPZviewer_upload',["200"],["200"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"200","h":"200","title":"","layer":"false","npage":"1"}]);
this.SpUpload=new ZtVWeb.SpUploadCtrl(this,{"allow_live_abort":"","allow_multiple_files":"","anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_SpUpload","custom_file_prefix":"","extallowed":"pdf","file_prefix":"contextId_cpccchk","h":200,"hide":"false","layer":false,"layout_steps_values":{},"manual_upload":"","my_max_file_size":"100","name":"SpUpload","page":1,"show_selected_files":"","show_selected_files_name":"","style_mode":"drag","submiturl":"","type":"SpUpload","uploaddir":"Tmp\u002f","w":200,"x":0,"y":0,"zindex":""});
this.SpUpload.initUploader();
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
<%request.setAttribute("SPZviewer_upload_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPZviewer_upload_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof SpUpload_UploadCompleted !='undefined')this.SpUpload_UploadCompleted=SpUpload_UploadCompleted;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
  document.getElementById(this.formid).style.overflow = 'hidden';
  document.getElementById(this.formid).style.position = 'absolute';
  document.getElementById(this.formid).style.top = '0px';
  document.getElementById(this.formid).style.bottom = '0px';
  document.getElementById(this.formid).style.height = 'auto';
  var cpup = document.getElementById('uploader_filelist');
  if(cpup==null){
    cpup = document.getElementById('uploader');
    if(cpup) cpup.style.display='none';
  }
  else{
    //document.getElementById(this.formid+'_imgUploadhref').style.display='none';
  }
}
function SpUpload_UploadCompleted(){
  var wind = (window.opener?window.opener:(window.caller?window.caller:window.parent));
  if(wind && wind.LoadPdf) {
    <%
      String appLocation = "'" + JSPLib.ToJSValue(Library.GetWebRootPath()) + "'";
    %>
    wind.LoadPdf(<%=appLocation%> + this.SpUpload.GetFileUploaded(),true);
  }
}
this.SpUpload.Ctrl.addEventListener("click", function() {
  this.SpUpload.SelectFile();
}.bind(this));
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPZviewer_upload_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPZviewer_upload',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPZviewer_upload');
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
sp.endPage("SPZviewer_upload");
}%>
<%! public String getJSPUID() { return "2160313655"; } %>