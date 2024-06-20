<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function btnExit_Click(){\n  if (confirm(\"Confermi l'uscita senza salvare?\")) {\n    window.close()\n  }  \n}\n\nfunction btnSave_Click(){\n  if (confirm(\"Confermi il salvataggio dei dati?\")) {\n    this.RTSalva.Link();\n    \u002f\u002f window.close();\n  }    \n}\n","adaptive":"fixed","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"73","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"851","wizard":""},{"anchor":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"100","name":"account","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"1","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"750","wireframe_props":"name","x":"90","y":"11","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Stato:","w":"69","wireframe_props":"align,value,n_col","x":"17","y":"14","zindex":"1"},{"anchor":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"3","name":"coduif","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"3","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"34","wireframe_props":"name","x":"90","y":"42","zerofilling":"false","zindex":"1"},{"anchor":"","calculateZoomTitle":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"coduif,desuif","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"coduif","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom3","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"4","servlet":"","suggest":"false","table":"tbstati","type":"LinkZoom","w":"20","wireframe_props":"","x":"126","y":"42","zindex":"","zoomtitle":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label4","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Codice UIF:","w":"69","wireframe_props":"align,value,n_col","x":"17","y":"45","zindex":"1"},{"anchor":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"50","name":"desuif","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"6","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"375","wireframe_props":"name","x":"158","y":"42","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra senza salvare","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"7","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_exit.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"807","y":"36","zindex":"1"},{"alt":"","anchor":"top-left-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":" Salva le modifiche apportate","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnSave","page":"1","path_type":"","sequence":"8","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_save.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"766","y":"36","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"start","m_cAltInterface":"","name":"RTSalva","offline":"false","page":"1","parms":"pNome=account,pCodice=coduif","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arrt_save_newdecode","target":"","type":"SPLinker","w":"30","x":"3","y":"-33"}]%>
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
window.pg_newdecode_Static=function(){
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof btnSave_Click !='undefined')this.btnSave_Click=btnSave_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom3.addObserverFixedVars();
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

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_newdecode_container {
}
.pg_newdecode_title_container {
  margin: auto;
}
.pg_newdecode_portlet{
  position:relative;
  margin: auto;
  width:851px;
  min-width:851px;
  height:73px;
  background-color:#FFFFFF;
}
.pg_newdecode_portlet[Data-page="1"]{
  height:73px;
  width:851px;
}
.pg_newdecode_portlet > .account_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:90px;
  width:750px;
  height:20px;
}
.pg_newdecode_portlet > .account_ctrl {
}
.pg_newdecode_portlet > .account_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_newdecode_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:17px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_newdecode_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_newdecode_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_newdecode_portlet > .coduif_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:90px;
  width:34px;
  height:20px;
}
.pg_newdecode_portlet > .coduif_ctrl {
}
.pg_newdecode_portlet > .coduif_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_newdecode_portlet > .LinkZoom3_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:126px;
  width:20px;
  height:20px;
}
.pg_newdecode_portlet > .label4_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:17px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_newdecode_portlet > .label4_ctrl {
  height:auto;
  min-height:19px;
}
.pg_newdecode_portlet > .label4_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_newdecode_portlet > .desuif_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:158px;
  width:375px;
  height:20px;
}
.pg_newdecode_portlet > .desuif_ctrl {
}
.pg_newdecode_portlet > .desuif_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_newdecode_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  right:14px;
  width:30px;
  height:30px;
}
.pg_newdecode_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_newdecode_portlet > .btnSave_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  left:766px;
  right:55px;
  width:30px;
  height:30px;
}
.pg_newdecode_portlet > .btnSave_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
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
 String def="[{\"h\":\"73\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"851\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"account\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"750\",\"x\":\"90\",\"y\":\"11\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Stato:\",\"w\":\"69\",\"x\":\"17\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"coduif\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"34\",\"x\":\"90\",\"y\":\"42\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom3\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"126\",\"y\":\"42\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label4\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Codice UIF:\",\"w\":\"69\",\"x\":\"17\",\"y\":\"45\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"desuif\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"158\",\"y\":\"42\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"807\",\"y\":\"36\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnSave\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"766\",\"y\":\"36\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTSalva\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"3\",\"y\":\"-33\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_newdecode","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_newdecode_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_newdecode','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String account= "";
if(request.getAttribute("pg_newdecode_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label1= "Stato:";
String coduif= "";
if(request.getAttribute("pg_newdecode_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String label4= "Codice UIF:";
String desuif= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_newdecode_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_newdecode_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_newdecode','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_account_wrp'><input id='<%=idPortlet%>_account' name='account' type='text' maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='account' /></span>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Stato:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_coduif_wrp'><input id='<%=idPortlet%>_coduif' name='coduif' type='text' maxlength='3' class='textbox' formid='<%=idPortlet%>' ps-name='coduif' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom3'" ) );%>
<span id='<%=idPortlet%>_label4'  formid='<%=idPortlet%>' ps-name='label4'    class='label label4_ctrl'><div id='<%=idPortlet%>_label4tbl' style='width:100%;'><%=JSPLib.ToHTML("Codice UIF:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_desuif_wrp'><input id='<%=idPortlet%>_desuif' name='desuif' type='text' disabled maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='desuif' /></span>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_btnSave' class='image btnSave_ctrl'   target=''>&#xeb36;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_newdecode');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_newdecode',["851"],["73"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"73","title":"","layer":"false","npage":"1"}]);
this.account=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_account","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"account","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(account,false,true)%>","w":750,"x":90,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":69,"x":17,"y":14,"zindex":"1"});
this.coduif=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_coduif","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"3","name":"coduif","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(coduif,false,true)%>","w":34,"x":90,"y":42,"zerofilling":false,"zindex":"1","zoom":""});
this.LinkZoom3=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom3","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_newdecode_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"coduif,desuif","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_newdecode_portlet.jspLinkZoom3",request.getSession())%>","linkedField":"coduif","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom3","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODSTA,DESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,tbstati,default",request.getSession())%>","suggest":false,"table":"tbstati","type":"LinkZoom","w":20,"x":126,"y":42,"zindex":"","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.label4=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label4","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label4","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label4,false,true)%>","type":"Label","w":69,"x":17,"y":45,"zindex":"1"});
this.desuif=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_desuif","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"desuif","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(desuif,false,true)%>","w":375,"x":158,"y":42,"zerofilling":false,"zindex":"1","zoom":""});
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra senza salvare",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":807,"y":36,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnSave=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left-right","boundedPosition":"right","class_Css":"image btnSave_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnSave","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb36;","font_image_hover":"&#xeb37;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" Salva le modifiche apportate",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnSave","page":1,"path_type":"","server_side":"","src":"&#xeb36;","srchover":"&#xeb37;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":766,"y":36,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTSalva=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSalva","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSalva","offline":false,"page":1,"parms":"pNome=account,pCodice=coduif","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_save_newdecode","target":"","type":"SPLinker","w":30,"x":3,"y":-33});
this.RTSalva.m_cID='<%=JSPLib.cmdHash("routine,arrt_save_newdecode",request.getSession())%>';
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
<%if(request.getAttribute("pg_newdecode_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_newdecode_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_newdecode_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnSave.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_newdecode',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_newdecode');
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
sp.endPage("pg_newdecode");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom3")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbstati";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODSTA", "DESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "2343670971"; } %>