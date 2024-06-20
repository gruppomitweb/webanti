<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Elabora_Click(){\n  if (confirm(\"Confermi l'elaborazione?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTCheck.Link()   \n  }  \n}\n\nfunction Uscita_Click() {\n  this.BtnUscita.Link()\n}  \n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Allinea Cancellazioni \u002f Operazioni Extraconto\",true)\n  this.Elabora.Hide();\n  this.RTAzzera.Link();\n}\n\nfunction RTCheck_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()  \n  alert('Elaborazione Terminata!');  \n}\n\nfunction annorif_onChange(){\n  if (this.annorif.Value() != 0) {\n    this.Elabora.Show()\n  }  \n}\n","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Controllo di Gestione","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"260","hsl":"","htmlcode":"{{ @saldi }}\n{{ @lblAnnoRif }}\n{{ @annorif }}\n{{ @pLog }}\n{{ @Uscita }}\n{{ @Elabora }}\n{{ @pMsg }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"Utilities.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","h":"58","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"1","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"194","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Verifica operazioni extraconto per l'anno indicato","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Elabora","page":"1","path_type":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fprinter.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"939","y":"8","zindex":"0"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la maschera","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Uscita","page":"1","path_type":"","sequence":"3","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"983","y":"8","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"93","x":"683","y":"-68"},{"allowedentities":"arrt_extrope_varia","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTCheck","offline":"false","page":"1","parms":"w_annorif=annorif,pSaldi=saldi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_extrope_varia","target":"","type":"SPLinker","w":"147","x":"807","y":"-66"},{"anchor":"top-left-right","h":"143","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"6","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"48","zindex":"3"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"4","name":"annorif","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"45","wireframe_props":"name","x":"168","y":"14","zerofilling":"false","zindex":"4"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAnnoRif","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anno di riferimento:","w":"150","wireframe_props":"align,value,n_col","x":"11","y":"17","zindex":"5"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"486","y":"-67"},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Calcola i saldi e il totale operazioni","layer":"false","layout_steps_values":"{}","name":"saldi","page":"1","sequence":"10","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"350","wireframe_props":"label_text","x":"338","y":"14","zindex":"6"}]%>
<%/*Description:Controllo di Gestione*/%>
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
window.pg_extrope_varia_Static=function(){
if(typeof Elabora_Click !='undefined')this.Elabora_Click=Elabora_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTCheck_Result !='undefined')this.RTCheck_Result=RTCheck_Result;
if(typeof annorif_onChange !='undefined')this.annorif_onChange=annorif_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function Elabora_Click(){
  if (confirm("Confermi l'elaborazione?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTCheck.Link()   
  }  
}
function Uscita_Click() {
  this.BtnUscita.Link()
}  
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Allinea Cancellazioni / Operazioni Extraconto",true)
  this.Elabora.Hide();
  this.RTAzzera.Link();
}
function RTCheck_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()  
  alert('Elaborazione Terminata!');  
}
function annorif_onChange(){
  if (this.annorif.Value() != 0) {
    this.Elabora.Show()
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
.pg_extrope_varia_container {
}
.pg_extrope_varia_title_container {
  margin: auto;
}
.pg_extrope_varia_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:260px;
  background-color:#FFFFFF;
}
.pg_extrope_varia_portlet[Data-page="1"]{
  height:260px;
  width:100%;
}
.pg_extrope_varia_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:194px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:58px;
}
.pg_extrope_varia_portlet > .Elabora_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:8px;
  right:55px;
  width:30px;
  height:30px;
}
.pg_extrope_varia_portlet > .Elabora_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_extrope_varia_portlet > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:11px;
  width:30px;
  height:30px;
}
.pg_extrope_varia_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_extrope_varia_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:48px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:143px;
}
.pg_extrope_varia_portlet > .annorif_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:14px;
  left:168px;
  width:45px;
  height:20px;
}
.pg_extrope_varia_portlet > .annorif_ctrl {
}
.pg_extrope_varia_portlet > .annorif_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_extrope_varia_portlet > .lblAnnoRif_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:17px;
  left:11px;
  width:150px;
  height:auto;
  min-height:20px;
}
.pg_extrope_varia_portlet > .lblAnnoRif_ctrl {
  height:auto;
  min-height:20px;
}
.pg_extrope_varia_portlet > .lblAnnoRif_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_extrope_varia_portlet > .saldi_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:14px;
  left:338px;
  width:350px;
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
 String def="[{\"h\":\"260\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"58\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"194\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"939\",\"y\":\"8\",\"zindex\":\"0\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"983\",\"y\":\"8\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"93\",\"x\":\"683\",\"y\":\"-68\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"807\",\"y\":\"-66\"},{\"anchor\":\"top-left-right\",\"h\":\"143\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"48\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"annorif\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"45\",\"x\":\"168\",\"y\":\"14\",\"zindex\":\"4\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnnoRif\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"150\",\"x\":\"11\",\"y\":\"17\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"RTAzzera\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"486\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Calcola i saldi e il totale operazioni\",\"layout_steps_values\":{},\"name\":\"saldi\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"350\",\"x\":\"338\",\"y\":\"14\",\"zindex\":\"6\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_extrope_varia","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_extrope_varia_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("Utilities.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_extrope_varia','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double annorif= 0;
if(request.getAttribute("pg_extrope_varia_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnnoRif= "Anno di riferimento:";
String saldi="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_extrope_varia_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_extrope_varia_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_extrope_varia_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_extrope_varia','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<a id='<%=idPortlet%>_Elabora' class='image Elabora_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_annorif_wrp'><input id='<%=idPortlet%>_annorif' name='annorif' type='text' maxlength='4' class='textbox' formid='<%=idPortlet%>' ps-name='annorif' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblAnnoRif'  formid='<%=idPortlet%>' ps-name='lblAnnoRif'    class='label lblAnnoRif_ctrl'><div id='<%=idPortlet%>_lblAnnoRiftbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<div id='<%=idPortlet%>_saldi_div' style=''><input id='<%=idPortlet%>_saldi' name='saldi' class='slider checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_saldi' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Calcola i saldi e il totale operazioni")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_extrope_varia');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_extrope_varia',["1024"],["260"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"260","title":"","layer":"false","npage":"1"}]);
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_pMsg","h":58,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":1024,"x":0,"y":194,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.Elabora=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Elabora_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Elabora","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Verifica operazioni extraconto per l'anno indicato",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Elabora","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":939,"y":8,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la maschera",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Uscita","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":983,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":93,"x":683,"y":-68});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTCheck=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_extrope_varia",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCheck","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCheck","offline":false,"page":1,"parms":"w_annorif=annorif,pSaldi=saldi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_extrope_varia","target":"","type":"SPLinker","w":147,"x":807,"y":-66});
this.RTCheck.m_cID='<%=JSPLib.cmdHash("routine,arrt_extrope_varia",request.getSession())%>';
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":1024,"x":0,"y":48,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.annorif=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_annorif","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"4","name":"annorif","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=annorif%>","w":45,"x":168,"y":14,"zerofilling":false,"zindex":"4","zoom":""});
this.lblAnnoRif=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnnoRif","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnnoRif","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAnnoRif,false,true)%>","type":"Label","w":150,"x":11,"y":17,"zindex":"5"});
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":486,"y":-67});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.saldi=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_saldi","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Calcola i saldi e il totale operazioni","layer":false,"layout_steps_values":{},"name":"saldi","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":350,"x":338,"y":14,"zindex":"6"});
this.saldi.Value('<%=saldi%>');
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
<%if(request.getAttribute("pg_extrope_varia_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_extrope_varia_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_extrope_varia_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Elabora.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_extrope_varia',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_extrope_varia');
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
sp.endPage("pg_extrope_varia");
}%>
<%! public String getJSPUID() { return "2418940173"; } %>