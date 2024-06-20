<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":" this.SPLinker_admin_decrypt.Link() \n\nfunction this_Loaded(){\n this.SQLDataobj_qbe_tmp_list_imprich.Query()\n}\n\nfunction Button_decripta_Click(){\n  this.SPLinker_rt_admin_decrypt.Link()\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"150","hsl":"","htmlcode":"{{ @Iframe5 }} \n{{ @w_filename }} \n{{ @Iframe_pagina{{ @w_filename{{ @Button_decripta }} \n }} \n }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"800","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"200","version":"37","w":"100%","wizard":""},{"allowedentities":"admin_decrypt","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"SPLinker_admin_decrypt","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"1","servlet":"admin_decrypt","target":"Iframe5","type":"SPLinker","w":"223","x":"219","y":"25"},{"allowedqueries":"qbe_tmp_list_imprich","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"10","name":"SQLDataobj_qbe_tmp_list_imprich","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_tmp_list_imprich","query_async":"true","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"223","x":"219","y":"3"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"SQLDataobj_qbe_tmp_list_imprich","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","name":"w_filename","page":"1","picture":"","sequence":"3","spuid":"","tabindex":"","textlist":"nomefile","type":"Combobox","typevar":"character","valuelist":"nomefile","visible":"true","w":"150","wireframe_props":"name,textlist","x":"0","y":"7","zindex":"4"},{"allowedentities":"rt_admin_decrypt","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"SPLinker_rt_admin_decrypt","offline":"false","page":"1","parms":"w_filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"rt_admin_decrypt","target":"","type":"SPLinker","w":"223","x":"219","y":"48"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"Button_decripta","page":"1","sequence":"5","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Decripta","w":"50","wireframe_props":"value","x":"150","y":"4","zindex":"6"},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","h":"1","hide":"false","layer":"false","layout_steps_values":"{}","name":"Iframe5","page":"1","sequence":"6","spuid":"","type":"Iframe","w":"1","wireframe_props":"","x":"9","y":"37","zindex":"7"}]%>
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
window.pg_admin_decrypt_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Button_decripta_Click !='undefined')this.Button_decripta_Click=Button_decripta_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLDataobj_qbe_tmp_list_imprich.addRowConsumer(this.w_filename);
 this.SPLinker_admin_decrypt.Link() 
function this_Loaded(){
 this.SQLDataobj_qbe_tmp_list_imprich.Query()
}
function Button_decripta_Click(){
  this.SPLinker_rt_admin_decrypt.Link()
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
.pg_admin_decrypt_container {
}
.pg_admin_decrypt_title_container {
  margin: auto;
}
.pg_admin_decrypt_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:800px;
  min-width:200px;
  height:150px;
  background-color:#F3F3F3;
}
.pg_admin_decrypt_portlet[Data-page="1"]{
  height:150px;
  width:100%;
}
.pg_admin_decrypt_portlet > .w_filename_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:7px;
  left:0px;
  left:0.0%;
  right:50px;
  right:25.0%;
  width:auto;
  height:20px;
}
.pg_admin_decrypt_portlet > .Button_decripta_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:4px;
  left:150px;
  left:75.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:25px;
}
.pg_admin_decrypt_portlet > .Button_decripta_ctrl {
}
.pg_admin_decrypt_portlet > .Iframe5_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:37px;
  left:9px;
  left:4.5%;
  right:190px;
  right:95.0%;
  width:auto;
  height:1px;
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
 String def="[{\"h\":\"150\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"200\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"223\",\"x\":\"219\",\"y\":\"25\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"223\",\"x\":\"219\",\"y\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"w_filename\",\"page\":\"1\",\"textlist\":\"nomefile\",\"type\":\"Combobox\",\"w\":\"150\",\"x\":\"0\",\"y\":\"7\",\"zindex\":\"4\"},{\"h\":\"20\",\"name\":\"SPLinker_rt_admin_decrypt\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"223\",\"x\":\"219\",\"y\":\"48\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"Button_decripta\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Decripta\",\"w\":\"50\",\"x\":\"150\",\"y\":\"4\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"1\",\"layout_steps_values\":{},\"name\":\"Iframe5\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"1\",\"x\":\"9\",\"y\":\"37\",\"zindex\":\"7\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_admin_decrypt","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_admin_decrypt_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_admin_decrypt','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String w_filename= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_admin_decrypt_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_admin_decrypt_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_admin_decrypt','<%=idPortlet%>',false,'');
</script><%}}%>
<select id='<%=idPortlet%>_w_filename' name='w_filename' class='combobox' style=''></select>
<input id='<%=idPortlet%>_Button_decripta' type='button' class='button Button_decripta_ctrl'/>
<div id='<%=idPortlet%>_Iframe5_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_admin_decrypt');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_admin_decrypt',["200"],["150"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"200","h":"150","title":"","layer":"false","npage":"1"}]);
this.SPLinker_admin_decrypt=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("admin_decrypt",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_admin_decrypt","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_admin_decrypt","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"admin_decrypt","target":"Iframe5","type":"SPLinker","w":223,"x":219,"y":25});
this.SPLinker_admin_decrypt.m_cID='<%=JSPLib.cmdHash("routine,admin_decrypt",request.getSession())%>';
this.SQLDataobj_qbe_tmp_list_imprich=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_tmp_list_imprich",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"true","cmd":"qbe_tmp_list_imprich","cmdHash":"<%=JSPLib.cmdHash("qbe_tmp_list_imprich",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLDataobj_qbe_tmp_list_imprich","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_qbe_tmp_list_imprich","nrows":"10","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":223,"x":219,"y":3});
this.w_filename=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_w_filename","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=w_filename%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"w_filename","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"nomefile","type":"Combobox","typevar":"character","valuelist":"nomefile","visible":true,"w":150,"x":0,"y":7,"zindex":"4"});
this.SPLinker_rt_admin_decrypt=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("rt_admin_decrypt",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_rt_admin_decrypt","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_rt_admin_decrypt","offline":false,"page":1,"parms":"w_filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"rt_admin_decrypt","target":"","type":"SPLinker","w":223,"x":219,"y":48});
this.SPLinker_rt_admin_decrypt.m_cID='<%=JSPLib.cmdHash("routine,rt_admin_decrypt",request.getSession())%>';
this.Button_decripta=new ZtVWeb._BC(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"button Button_decripta_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Button_decripta","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"Button_decripta","page":1,"spuid":"","tabindex":"","text":"Decripta","type":"Button","type_submit":"false","type_wizard":"","w":50,"x":150,"y":4,"zindex":"6"});
this.Iframe5=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_Iframe5","default_portlet":"","h":1,"hide":"false","layer":false,"layout_steps_values":{},"name":"Iframe5","name_iframe":"Iframe5","page":1,"spuid":"","type":"Iframe","w":1,"x":9,"y":37,"zindex":"7"});
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
<%if(request.getAttribute("pg_admin_decrypt_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_admin_decrypt_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_admin_decrypt_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLDataobj_qbe_tmp_list_imprich.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_admin_decrypt',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_admin_decrypt');
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
sp.endPage("pg_admin_decrypt");
}%>
<%! public String getJSPUID() { return "1280587244"; } %>