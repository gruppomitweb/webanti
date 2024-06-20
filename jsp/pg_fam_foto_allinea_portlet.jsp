<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.pMsg.Timer0.Start();\n    this.pLog.Timer0.Start();\n    this.RTElabora.Link();\n  }    \n}\n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle('Allinea Fotografia Anagrafe Rapporti',true);\n  this.RTAzzera.Link();\n}\n\nfunction RTElabora_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pLog.Timer0_onTimer();\n  this.pMsg.Timer0.Stop();\n  this.pLog.Timer0.Stop();\n  alert(\"Elaborazione Terminata con successo!\");\n}\n\nfunction RTSaveFile_Result(result){\n  this.listaFile.ListaFile.Refresh()\n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"700","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"851","version":"37","w":"100%","wizard":""},{"anchor":"top-left","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"ADatOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"2","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"394","y":"14","zerofilling":"false","zindex":"2"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Da Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"14","y":"17","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblAOpe","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"A Data Operazione:","w":"129","wireframe_props":"align,value,n_col","x":"263","y":"17","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"7","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_exit.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"809","y":"10","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Elabora i file selezionati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"8","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_execute.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"765","y":"10","zindex":"1"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","m_cAltInterface":"","name":"RTElabora","offline":"false","page":"1","parms":"w_dadata=DaDatOpe,w_a_data=ADatOpe","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arrt_fammigra_allinea","target":"","type":"SPLinker","w":"120","x":"1","y":"-67"},{"anchor":"","auto_resize":"false","border":"","default_portlet":"","h":"188","hide":"false","layout_steps_values":"{}","name":"elaborazione","page":"1","sequence":"10","type":"Iframe","w":"846","wireframe_props":"","x":"3","y":"508","zindex":"11"},{"anchor":"","h":"143","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"13","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"846","wireframe_props":"","x":"3","y":"48","zindex":"3"},{"anchor":"","h":"67","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"15","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"846","wireframe_props":"","x":"3","y":"193","zindex":"3"},{"async":"false","entity_type":"","h":"20","m_cAction":"","m_cAltInterface":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"20","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"255","y":"-66"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","m_cAltInterface":"","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"22","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"131","y":"-68"},{"anchor":"top-left","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"DaDatOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"26","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"86","wireframe_props":"name","x":"145","y":"14","zerofilling":"false","zindex":"2"}]%>
<%/*Description:*/%>
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
window.pg_fam_foto_allinea_Static=function(){
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTElabora_Result !='undefined')this.RTElabora_Result=RTElabora_Result;
if(typeof RTSaveFile_Result !='undefined')this.RTSaveFile_Result=RTSaveFile_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
  }  
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.pMsg.Timer0.Start();
    this.pLog.Timer0.Start();
    this.RTElabora.Link();
  }    
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Allinea Fotografia Anagrafe Rapporti',true);
  this.RTAzzera.Link();
}
function RTElabora_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pLog.Timer0_onTimer();
  this.pMsg.Timer0.Stop();
  this.pLog.Timer0.Stop();
  alert("Elaborazione Terminata con successo!");
}
function RTSaveFile_Result(result){
  this.listaFile.ListaFile.Refresh()
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
.pg_fam_foto_allinea_container {
}
.pg_fam_foto_allinea_title_container {
  margin: auto;
}
.pg_fam_foto_allinea_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:851px;
  height:700px;
  background-color:#FFFFFF;
}
.pg_fam_foto_allinea_portlet[Data-page="1"]{
  height:700px;
  width:100%;
}
.pg_fam_foto_allinea_portlet > .ADatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:14px;
  left:394px;
  width:86px;
  height:20px;
}
.pg_fam_foto_allinea_portlet > .ADatOpe_ctrl {
}
.pg_fam_foto_allinea_portlet > .ADatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_fam_foto_allinea_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:14px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_fam_foto_allinea_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_fam_foto_allinea_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_fam_foto_allinea_portlet > .lblAOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:263px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_fam_foto_allinea_portlet > .lblAOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_fam_foto_allinea_portlet > .lblAOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_fam_foto_allinea_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:12px;
  width:30px;
  height:30px;
}
.pg_fam_foto_allinea_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_fam_foto_allinea_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:56px;
  width:30px;
  height:30px;
}
.pg_fam_foto_allinea_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_fam_foto_allinea_portlet > .elaborazione_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:508px;
  left:3px;
  left:0.35252643%;
  right:2px;
  right:0.23501763%;
  width:auto;
  height:188px;
}
.pg_fam_foto_allinea_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:48px;
  left:3px;
  left:0.35252643%;
  right:2px;
  right:0.23501763%;
  width:auto;
  height:auto;
  min-height:143px;
}
.pg_fam_foto_allinea_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:193px;
  left:3px;
  left:0.35252643%;
  right:2px;
  right:0.23501763%;
  width:auto;
  height:auto;
  min-height:67px;
}
.pg_fam_foto_allinea_portlet > .DaDatOpe_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:14px;
  left:145px;
  width:86px;
  height:20px;
}
.pg_fam_foto_allinea_portlet > .DaDatOpe_ctrl {
}
.pg_fam_foto_allinea_portlet > .DaDatOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
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
 String def="[{\"h\":\"700\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"851\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"ADatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"394\",\"y\":\"14\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblDaOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"129\",\"x\":\"14\",\"y\":\"17\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAOpe\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"129\",\"x\":\"263\",\"y\":\"17\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"809\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"765\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTElabora\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"188\",\"layout_steps_values\":{},\"name\":\"elaborazione\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"846\",\"x\":\"3\",\"y\":\"508\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"143\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"846\",\"x\":\"3\",\"y\":\"48\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"67\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"846\",\"x\":\"3\",\"y\":\"193\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"255\",\"y\":\"-66\"},{\"h\":\"20\",\"name\":\"RTAzzera\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"131\",\"y\":\"-68\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"DaDatOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"86\",\"x\":\"145\",\"y\":\"14\",\"zindex\":\"2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_fam_foto_allinea","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_fam_foto_allinea_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_fam_foto_allinea','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%java.sql.Date ADatOpe= JSPLib.NullDate();
if(request.getAttribute("pg_fam_foto_allinea_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblDaOpe= "Da Data Operazione:";
String lblAOpe= "A Data Operazione:";
java.sql.Date DaDatOpe= JSPLib.NullDate();
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_fam_foto_allinea_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_fam_foto_allinea_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_fam_foto_allinea_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_fam_foto_allinea','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_ADatOpe_wrp'><input id='<%=idPortlet%>_ADatOpe' name='ADatOpe' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='ADatOpe' /></span>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Operazione:")%></div></span>
<span id='<%=idPortlet%>_lblAOpe'  formid='<%=idPortlet%>' ps-name='lblAOpe'    class='label lblAOpe_ctrl'><div id='<%=idPortlet%>_lblAOpetbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Operazione:")%></div></span>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xea01;</a>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<div id='<%=idPortlet%>_elaborazione_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_DaDatOpe_wrp'><input id='<%=idPortlet%>_DaDatOpe' name='DaDatOpe' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='DaDatOpe' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_fam_foto_allinea');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_fam_foto_allinea',["851"],["700"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"700","title":"","layer":"false","npage":"1"}]);
this.ADatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ADatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ADatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=ADatOpe%>","w":86,"x":394,"y":14,"zerofilling":false,"zindex":"2","zoom":""});
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":129,"x":14,"y":17,"zindex":"1"});
this.lblAOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAOpe","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblAOpe,false,true)%>","type":"Label","w":129,"x":263,"y":17,"zindex":"1"});
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":809,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Elabora i file selezionati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":765,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTElabora=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTElabora","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTElabora","offline":false,"page":1,"parms":"w_dadata=DaDatOpe,w_a_data=ADatOpe","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_fammigra_allinea","target":"","type":"SPLinker","w":120,"x":1,"y":-67});
this.RTElabora.m_cID='<%=JSPLib.cmdHash("routine,arrt_fammigra_allinea",request.getSession())%>';
this.elaborazione=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left(%)-right(%)","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_elaborazione","default_portlet":"","h":188,"hide":"false","layer":false,"layout_steps_values":{},"name":"elaborazione","name_iframe":"elaborazione","page":1,"type":"Iframe","w":846,"x":3,"y":508,"zindex":"11"});
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","type":"Portlet","w":846,"x":3,"y":48,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":67,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":846,"x":3,"y":193,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":255,"y":-66});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":131,"y":-68});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.DaDatOpe=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_DaDatOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"DaDatOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=DaDatOpe%>","w":86,"x":145,"y":14,"zerofilling":false,"zindex":"2","zoom":""});
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
<%if(request.getAttribute("pg_fam_foto_allinea_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_fam_foto_allinea_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_fam_foto_allinea_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_fam_foto_allinea',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_fam_foto_allinea');
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
sp.endPage("pg_fam_foto_allinea");
}%>
<%! public String getJSPUID() { return "738814841"; } %>