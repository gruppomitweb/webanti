<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function btnExit_Click(){\n  if (confirm(\"Confermi l'uscita senza salvare?\")) {\n    window.close()\n  }  \n}\n\nfunction btnSave_Click(){\n  if (confirm(\"Confermi il salvataggio dei dati?\")) {\n    this.RTSalva.Link();\n    \u002f\u002f window.close();\n  }    \n}\n\nfunction upload_file(){\n  \u002f\u002f funzione di upload file\n  this.RTUpload.Link()\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.RTSalva.Link();\n    alert(\"Elaborazione Terminata\");\n    this.impxls_Ended.Emit()\n    \u002f\u002f window.close();\n  }    \n}\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#FFFFFF","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"73","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"851"},{"anchor":" ","autofocus":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"Verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":"100","name":"nomefile","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":"1","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"750","x":"64","y":"11","zerofilling":"false","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"false","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label1","nowrap":"false","page":"1","picture":" ","sequence":"2","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"NomeFile:","w":"51","x":"8","y":"14","zindex":"1"},{"async":"false","entity_type":" ","h":"30","m_cAction":" ","m_cAltInterface":" ","name":"RTUpload","offline":"false","page":"1","parms":"Root=mRoot,Directory=mDirectory","popup":"true","popup_height":"486","popup_scroll":"false","popup_style":" ","popup_width":"300","refresh":" ","sequence":"2","servlet":"..\u002fjsp\u002fsp_upload.jsp","target":" ","type":"SPLinker","w":"30","x":"53","y":"-31"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"'\u002f'","name":"mRoot","page":"1","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"8","y":"106"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"'appo'","name":"mDirectory","page":"1","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"168","y":"106"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":" ","name":"mFileName","page":"1","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"146","x":"324","y":"106"},{"alt":" ","anchor":" ","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":" ","hide_undercond":" ","href":" ","img_type":"default","name":"btnExit","page":"1","path_type":" ","sequence":"7","server_side":" ","src":"..\u002fimages\u002fexit.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"798","y":"36","zindex":"1"},{"actObjs":"nomefile","actTypes":"var","h":"20","included":"false","name":"Refresh","objsValues":"NomeFile","page":"1","parmsNames":"NomeFile","sequence":"7","type":"EventReceiver","w":"22","x":"104","y":"-31"},{"alt":" ","anchor":" ","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":" ","hide_undercond":" ","href":" ","img_type":"default","name":"btnElab","page":"1","path_type":" ","sequence":"8","server_side":" ","src":"..\u002fimages\u002felaborazione.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"748","y":"36","zindex":"1"},{"eventsNames":" ","eventsObjs":" ","h":"20","name":"impxls_Ended","page":"1","parmsNames":" ","parmsTypes":" ","parmsValues":" ","sequence":"8","type":"EventEmitter","w":"22","x":"150","y":"-34"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"start","m_cAltInterface":" ","name":"RTSalva","offline":"false","page":"1","parms":"pNome=nomefile","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"9","servlet":"arrt_impxls_decodecomuni","target":" ","type":"SPLinker","w":"30","x":"3","y":"-33"},{"alt":" ","anchor":" ","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"20","help_tips":" ","hide_undercond":" ","href":"function:upload_file()","img_type":"default","name":"image5","page":"1","path_type":" ","sequence":"10","server_side":" ","src":"..\u002fimages\u002fGIF\u002f001.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"20","x":"820","y":"9","zindex":"1"}]%>
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
window.pg_impxls_decodecomuni_Static=function(){
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof btnSave_Click !='undefined')this.btnSave_Click=btnSave_Click;
if(typeof upload_file !='undefined')this.upload_file=upload_file;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function btnExit_Click(){
  if (confirm("Confermi l'uscita senza salvare?")) {
    window.close()
  }  
}
function btnSave_Click(){
  if (confirm("Confermi il salvataggio dei dati?")) {
    this.RTSalva.Link();
    // window.close();
  }    
}
function upload_file(){
  // funzione di upload file
  this.RTUpload.Link()
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.RTSalva.Link();
    alert("Elaborazione Terminata");
    this.impxls_Ended.Emit()
    // window.close();
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
.pg_impxls_decodecomuni_container {
}
.pg_impxls_decodecomuni_portlet{
  position:relative;
  width:851px;
  min-width:851px;
  height:73px;
  background-color:#FFFFFF;
}
.pg_impxls_decodecomuni_portlet[Data-page="1"]{
  height:73px;
  width:851px;
}
.pg_impxls_decodecomuni_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:64px;
  width:750px;
  height:20px;
}
.pg_impxls_decodecomuni_portlet > .nomefile_ctrl {
}
.pg_impxls_decodecomuni_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_impxls_decodecomuni_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:8px;
  width:51px;
  height:auto;
  min-height:19px;
}
.pg_impxls_decodecomuni_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_impxls_decodecomuni_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_impxls_decodecomuni_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  left:798px;
  width:40px;
  height:30px;
}
.pg_impxls_decodecomuni_portlet > .btnExit_ctrl {
}
.pg_impxls_decodecomuni_portlet > .btnExit_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_impxls_decodecomuni_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  left:748px;
  width:40px;
  height:30px;
}
.pg_impxls_decodecomuni_portlet > .btnElab_ctrl {
}
.pg_impxls_decodecomuni_portlet > .btnElab_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_impxls_decodecomuni_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:820px;
  width:20px;
  height:20px;
}
.pg_impxls_decodecomuni_portlet > .image5_ctrl {
}
.pg_impxls_decodecomuni_portlet > .image5_ctrl > a, .pg_impxls_decodecomuni_portlet > .image5_ctrl > a:hover{
  text-decoration:none;
}
.pg_impxls_decodecomuni_portlet > .image5_ctrl > a > img{
  width:100%;
  vertical-align:top;
  height:20px;
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
 String def="[{\"h\":\"73\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"851\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"750\",\"x\":\"64\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"51\",\"x\":\"8\",\"y\":\"14\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"53\",\"y\":\"-31\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"8\",\"y\":\"106\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"168\",\"y\":\"106\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"324\",\"y\":\"106\"},{\"anchor\":\"\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"798\",\"y\":\"36\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"104\",\"y\":\"-31\"},{\"anchor\":\"\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"748\",\"y\":\"36\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"22\",\"x\":\"150\",\"y\":\"-34\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"3\",\"y\":\"-33\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"820\",\"y\":\"9\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_impxls_decodecomuni","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_impxls_decodecomuni_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_impxls_decodecomuni','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String nomefile= "";
if(request.getAttribute("pg_impxls_decodecomuni_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label1= "NomeFile:";
String mRoot="/";
String mDirectory="appo";
String mFileName= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_impxls_decodecomuni_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_impxls_decodecomuni_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_impxls_decodecomuni','<%=idPortlet%>',false,' ');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<div id='<%=idPortlet%>_btnExit'>
<img id='<%=idPortlet%>_btnExit_img' class='image btnExit_ctrl' src="../images/exit.gif" >
</div>
<div id='<%=idPortlet%>_btnElab'>
<img id='<%=idPortlet%>_btnElab_img' class='image btnElab_ctrl' src="../images/elaborazione.gif" >
</div>
<div id='<%=idPortlet%>_image5'><a id='<%=idPortlet%>_image5href' href='function:upload_file()' target='_self'><img id='<%=idPortlet%>_image5_img' class='image image5_ctrl' src="../images/GIF/001.gif" border='0' ></a>
</div></div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_impxls_decodecomuni');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_impxls_decodecomuni',["851"],["73"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"73","title":" ","layer":"false","npage":"1"}]);
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":750,"x":64,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label1","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":51,"x":8,"y":14,"zindex":"1"});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":" ","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":" ","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RTUpload","offline":false,"page":1,"parms":"Root=mRoot,Directory=mDirectory","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":" ","popup_width":"300","progressbar":false,"refresh":" ","servlet":"..\u002fjsp\u002fsp_upload.jsp","target":" ","type":"SPLinker","w":30,"x":53,"y":-31});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/sp_upload.jsp",request.getSession())%>';
this.mRoot=new ZtVWeb._VC(this,'mRoot',null,'character','<%=JSPLib.ToJSValue(mRoot,false,true)%>',false,false);
this.mDirectory=new ZtVWeb._VC(this,'mDirectory',null,'character','<%=JSPLib.ToJSValue(mDirectory,false,true)%>',false,false);
this.mFileName=new ZtVWeb._VC(this,'mFileName',null,'character','<%=JSPLib.ToJSValue(mFileName,false,true)%>',false,false);
this.btnExit=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-left","boundedPosition":"","class_Css":"image btnExit_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":798,"y":36,"zindex":"1"});
this.Refresh=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile","actTypes":"var","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Refresh","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Refresh","objsValues":"NomeFile","page":1,"parmsNames":"NomeFile","type":"EventReceiver","w":22,"x":104,"y":-31});
this.btnElab=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-left","boundedPosition":"","class_Css":"image btnElab_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":748,"y":36,"zindex":"1"});
this.impxls_Ended=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_impxls_Ended","eventsNames":" ","eventsObjs":" ","h":20,"hide":"false","layer":false,"layout_steps_values":{},"name":"impxls_Ended","page":1,"parmsNames":" ","parmsTypes":" ","parmsValues":" ","persistent":"true","type":"EventEmitter","w":22,"x":150,"y":-34});
this.RTSalva=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSalva","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RTSalva","offline":false,"page":1,"parms":"pNome=nomefile","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arrt_impxls_decodecomuni","target":" ","type":"SPLinker","w":30,"x":3,"y":-33});
this.RTSalva.m_cID='<%=JSPLib.cmdHash("routine,arrt_impxls_decodecomuni",request.getSession())%>';
this.image5=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-left","boundedPosition":"","class_Css":"image image5_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"function:upload_file()","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fGIF\u002f001.gif","srchover":"","tabindex":" ","target":"_self","type":"Image","type_submit":"false","w":20,"x":820,"y":9,"zindex":"1"});
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
<%if(request.getAttribute("pg_impxls_decodecomuni_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_impxls_decodecomuni_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_impxls_decodecomuni_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_Refresh=function(parmsObj){<%=idPortlet%>.Refresh.receiveFnc(parmsObj);}
window.<%=idPortlet%>.impxls_Ended.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_impxls_decodecomuni',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_impxls_decodecomuni');
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
sp.endPage("pg_impxls_decodecomuni");
}%>
<%! public String getJSPUID() { return "1876200664"; } %>