<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n\u002f\u002f   this.getTitlePortlet().SetTitle('(trascinare direttamente o selezionare il percorso del file)');\n  this.getTitlePortlet().SetTitle('');\n  this.getTitlePortlet().SetSubTitle('(trascinare direttamente o selezionare il percorso del file)');\n  this.SpUpload0.SetUploadDir(this.dir.Value());\n}\n\nfunction SpUpload0_UploadCompleted(){\n  this.filename.Value(this.SpUpload0.GetFileName());\n  this.Event_filename.Emit();\n  close();\n}\n\nfunction SpUpload0_UploadFailed(){\n  alert('Attenzione tipo di file non supportato per l\\'upload.\\n Caricare un\\'altra tipologia di file.');\n}\n\nfunction SpUpload0_UploadAborted(){\n  if(confirm('Operazione annullata.\\nChiudere la maschera per l\\'upload?')){\n    close();\n  }\n}\n\nfunction SpUpload0_ServerNotRespond(){\n  if(confirm('Il server non risponde. Riprovare più tardi.\\nChiudere maschera per l\\'upload?')){\n    close();\n  }\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"200","hsl":"","htmlcode":"{{ @SpUpload0 }} \n","htmlmode":"false","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"true","title_url":"","type":"Form","v_line":"250","version":"37","w":"100%","wizard":""},{"anchor":"top-center","css_class":"","ctrlOfVariant":"","custom_file_prefix":"","extallowed":"","file_prefix":"none","h":"198","hide":"false","layer":"false","layout_steps_values":"{}","my_max_file_size":"300","name":"SpUpload0","page":"1","sequence":"1","spuid":"","style_mode":"mixed","submiturl":"","type":"SpUpload","uploaddir":"Tmp\u002f","w":"248","wireframe_props":"","x":"1","y":"1","zindex":"1"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"dir","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"4","y":"211"},{"broadcast":"all","ctrlOfVariant":"","eventsNames":"","eventsObjs":"","h":"30","name":"Event_filename","page":"1","parmsNames":"nomefile","parmsTypes":"var","parmsValues":"filename","persistent":"true","sequence":"3","type":"EventEmitter","w":"115","x":"112","y":"-66"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"129","y":"210"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:dir*/%>
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
window.pg_upload_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof SpUpload0_UploadCompleted !='undefined')this.SpUpload0_UploadCompleted=SpUpload0_UploadCompleted;
if(typeof SpUpload0_UploadFailed !='undefined')this.SpUpload0_UploadFailed=SpUpload0_UploadFailed;
if(typeof SpUpload0_UploadAborted !='undefined')this.SpUpload0_UploadAborted=SpUpload0_UploadAborted;
if(typeof SpUpload0_ServerNotRespond !='undefined')this.SpUpload0_ServerNotRespond=SpUpload0_ServerNotRespond;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
//   this.getTitlePortlet().SetTitle('(trascinare direttamente o selezionare il percorso del file)');
  this.getTitlePortlet().SetTitle('');
  this.getTitlePortlet().SetSubTitle('(trascinare direttamente o selezionare il percorso del file)');
  this.SpUpload0.SetUploadDir(this.dir.Value());
}
function SpUpload0_UploadCompleted(){
  this.filename.Value(this.SpUpload0.GetFileName());
  this.Event_filename.Emit();
  close();
}
function SpUpload0_UploadFailed(){
  alert('Attenzione tipo di file non supportato per l\'upload.\n Caricare un\'altra tipologia di file.');
}
function SpUpload0_UploadAborted(){
  if(confirm('Operazione annullata.\nChiudere la maschera per l\'upload?')){
    close();
  }
}
function SpUpload0_ServerNotRespond(){
  if(confirm('Il server non risponde. Riprovare più tardi.\nChiudere maschera per l\'upload?')){
    close();
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
.pg_upload_container {
}
.pg_upload_title_container {
  margin: auto;
}
.pg_upload_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:250px;
  height:200px;
  background-color:#F3F3F3;
}
.pg_upload_portlet[Data-page="1"]{
  height:200px;
  width:100%;
}
.pg_upload_portlet > .SpUpload0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  width:248px;
  height:198px;
  margin-left:-124px;
  left:50%;
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
 String def="[{\"h\":\"200\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"250\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-center\",\"h\":\"198\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"SpUpload\",\"w\":\"248\",\"x\":\"1\",\"y\":\"1\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"4\",\"y\":\"211\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"115\",\"x\":\"112\",\"y\":\"-66\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"129\",\"y\":\"210\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_upload","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_upload_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_upload','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_upload_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("SpUploadObj.js")%>'></script>
<%}
String dir=JSPLib.translateXSS(sp.getParameter("dir",""));
String filename= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_upload_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_upload_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_upload_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_upload','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_SpUpload0' class='drag'><div id='uploader_<%=idPortlet%>_SpUpload0' class='SpUpload '><div id='uploader_holder_<%=idPortlet%>_SpUpload0' class='uploader_holder'></div><label id='uploader_button_<%=idPortlet%>_SpUpload0' class='button' for='uploader_input_file_<%=idPortlet%>_SpUpload0' style='display: none'><%=Library.ToHTML(sp.translate("SPUPLOAD_MSG_CHOOSE_FILE"),"C",0,0)%>…</label><input id='uploader_input_file_<%=idPortlet%>_SpUpload0' class='uploader_input_file' type='file' name='file' style='display: none' multiple></div></div></div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_upload');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_upload',["250"],["200"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},true,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"250","h":"200","title":"","layer":"false","npage":"1"}]);
this.SpUpload0=new ZtVWeb.SpUploadCtrl(this,{"allow_live_abort":"","allow_multiple_files":"","anchor":"top-center","ctrlid":"<%=idPortlet%>_SpUpload0","custom_file_prefix":"","extallowed":"","file_prefix":"none","h":198,"hide":"false","layer":false,"layout_steps_values":{},"manual_upload":"","my_max_file_size":"300","name":"SpUpload0","page":1,"show_selected_files":"","show_selected_files_name":"","spuid":"","style_mode":"mixed","submiturl":"","type":"SpUpload","uploaddir":"Tmp\u002f","w":248,"x":1,"y":1,"zindex":"1"});
this.SpUpload0.initUploader();
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.Event_filename=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","eventsNames":"","eventsObjs":"","h":30,"hide":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","page":1,"parmsNames":"nomefile","parmsTypes":"var","parmsValues":"filename","persistent":"true","type":"EventEmitter","w":115,"x":112,"y":-66});
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_upload_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_upload_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_upload_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Event_filename.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_upload',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_upload');
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
sp.endPage("pg_upload");
}%>
<%! public String getJSPUID() { return "3471672897"; } %>