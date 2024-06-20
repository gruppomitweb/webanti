<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"REPORT VLT\",true)\n}\n\nfunction StampaMonitor_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {  \n    this.RTStampa2.Link()\n  }  \n}\n\nfunction StampaIdentifica_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.RTStampa1.Link()\n  }    \n}\n\nfunction Uscita_Click() {\n  this.BtnUscita.Link()\n}  ","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Stampa Autocorrezioni","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"508","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"Utilities.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"#38895B","font_color_hover":"#01FB6B","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa i ticket che necessitano di identificazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"StampaIdentifica","page":"1","path_type":"","sequence":"1","server_side":"","src":"..\u002fimages\u002fpng\u002fprinter.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"903","y":"8","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la maschera","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Uscita","page":"1","path_type":"","sequence":"2","server_side":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"983","y":"8","zindex":"1"},{"async":"false","entity_type":"","h":"30","m_cAction":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"93","x":"131","y":"-68"},{"async":"false","entity_type":"report","h":"30","m_cAction":"","name":"RTStampa1","offline":"false","page":"1","parms":"ReportName=arrp_cgo_vlt_report.vrp,outputFormat=XLS,hideParameterMask=true,pDaImportoE=500,pA_ImportoE=0,pDaImportoC=400,pA_ImportoC=499.99,pDaData=daope,pA_Data=adope,pStampaE=S,pStampaC=S,pSala=CODICEAAMS","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"","target":"iPrint","type":"SPLinker","w":"147","x":"239","y":"-68"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Da Data:","w":"104","wireframe_props":"align,value,n_col","x":"13","y":"43","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblAScad_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"A Data:","w":"104","wireframe_props":"align,value,n_col","x":"215","y":"43","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Tahoma","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layout_steps_values":"{}","maxlength":"","name":"daope","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"75","wireframe_props":"name","x":"121","y":"42","zerofilling":"false","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Tahoma","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layout_steps_values":"{}","maxlength":"","name":"adope","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"75","wireframe_props":"name","x":"325","y":"42","zerofilling":"false","zindex":"1"},{"anchor":"","css_class":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layout_steps_values":"{}","name":"CalDaOpe","page":"1","popup":"true","return_input":"daope","sequence":"9","type":"Calendario","w":"20","wireframe_props":"","x":"197","y":"42","zindex":""},{"anchor":"","css_class":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layout_steps_values":"{}","name":"CalAdOpe","page":"1","popup":"true","return_input":"adope","sequence":"10","type":"Calendario","w":"20","wireframe_props":"","x":"401","y":"42","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"#0B05FD","font_color_hover":"#05C6FD","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa i ticket da monitorare","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"StampaMonitor","page":"1","path_type":"","sequence":"11","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"943","y":"8","zindex":"1"},{"anchor":"","auto_resize":"false","border":"","default_portlet":"","h":"383","hide":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"12","type":"Iframe","w":"1024","wireframe_props":"","x":"0","y":"69","zindex":"2"},{"async":"false","entity_type":"report","h":"30","m_cAction":"","name":"RTStampa2","offline":"false","page":"1","parms":"ReportName=arrp_cgo_vlt_report.vrp,outputFormat=XLS,hideParameterMask=true,pDaImportoE=0,pA_ImportoE=0,pDaImportoC=100,pA_ImportoC=399.99,pDaData=daope,pA_Data=adope,pStampaE=N,pStampaC=S,pSala=CODICEAAMS","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"","target":"iPrint","type":"SPLinker","w":"147","x":"422","y":"-68"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"global string","layout_steps_values":"{}","maxlength":"","name":"coddip","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"14","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"96","wireframe_props":"name","x":"121","y":"12","zerofilling":"false","zindex":"3"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"coddip,descage,CODICEAAMS","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"coddip","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom16","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,CODICEAAMS","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"15","servlet":"","suggest":"false","table":"anadip","type":"LinkZoom","w":"20","wireframe_props":"","x":"221","y":"12","zindex":"4","zoomtitle":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"CODICEAAMS","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"16","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"642","y":"12","zerofilling":"false","zindex":"5"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblAgenzia","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Agenzia:","w":"104","wireframe_props":"align,value,n_col","x":"15","y":"14","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"descage","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"18","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"391","wireframe_props":"name","x":"246","y":"12","zerofilling":"false","zindex":"6"}]%>
<%/*Description:Stampa Autocorrezioni*/%>
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
window.pg_cgo_vlt_report_adm_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof StampaMonitor_Click !='undefined')this.StampaMonitor_Click=StampaMonitor_Click;
if(typeof StampaIdentifica_Click !='undefined')this.StampaIdentifica_Click=StampaIdentifica_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom16.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle("REPORT VLT",true)
}
function StampaMonitor_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {  
    this.RTStampa2.Link()
  }  
}
function StampaIdentifica_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.RTStampa1.Link()
  }    
}
function Uscita_Click() {
  this.BtnUscita.Link()
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
.pg_cgo_vlt_report_adm_container {
}
.pg_cgo_vlt_report_adm_title_container {
  margin: auto;
}
.pg_cgo_vlt_report_adm_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:508px;
  background-color:#FFFFFF;
}
.pg_cgo_vlt_report_adm_portlet[Data-page="1"]{
  height:508px;
  width:100%;
}
.pg_cgo_vlt_report_adm_portlet > .StampaIdentifica_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:91px;
  width:30px;
  height:30px;
}
.pg_cgo_vlt_report_adm_portlet > .StampaIdentifica_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#38895B;
}
.pg_cgo_vlt_report_adm_portlet > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:11px;
  width:30px;
  height:30px;
}
.pg_cgo_vlt_report_adm_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_vlt_report_adm_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:43px;
  left:13px;
  width:104px;
  height:auto;
  min-height:19px;
}
.pg_cgo_vlt_report_adm_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_vlt_report_adm_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_vlt_report_adm_portlet > .lblAScad_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:43px;
  left:215px;
  width:104px;
  height:auto;
  min-height:19px;
}
.pg_cgo_vlt_report_adm_portlet > .lblAScad_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_vlt_report_adm_portlet > .lblAScad_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_vlt_report_adm_portlet > .daope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:121px;
  width:75px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .daope_ctrl {
}
.pg_cgo_vlt_report_adm_portlet > .daope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Tahoma;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_vlt_report_adm_portlet > .adope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:325px;
  width:75px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .adope_ctrl {
}
.pg_cgo_vlt_report_adm_portlet > .adope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Tahoma;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_vlt_report_adm_portlet > .CalDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:197px;
  width:20px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .CalAdOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:401px;
  width:20px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .StampaMonitor_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:51px;
  width:30px;
  height:30px;
}
.pg_cgo_vlt_report_adm_portlet > .StampaMonitor_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
  color:#0B05FD;
}
.pg_cgo_vlt_report_adm_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:69px;
  left:0px;
  width:1024px;
  height:383px;
}
.pg_cgo_vlt_report_adm_portlet > .coddip_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:12px;
  left:121px;
  width:96px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .coddip_ctrl {
}
.pg_cgo_vlt_report_adm_portlet > .coddip_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_cgo_vlt_report_adm_portlet > .LinkZoom16_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:12px;
  left:221px;
  width:20px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .CODICEAAMS_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:12px;
  left:642px;
  width:120px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .CODICEAAMS_ctrl {
}
.pg_cgo_vlt_report_adm_portlet > .CODICEAAMS_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_cgo_vlt_report_adm_portlet > .lblAgenzia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:15px;
  width:104px;
  height:auto;
  min-height:19px;
}
.pg_cgo_vlt_report_adm_portlet > .lblAgenzia_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_vlt_report_adm_portlet > .lblAgenzia_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_vlt_report_adm_portlet > .descage_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:12px;
  left:246px;
  width:391px;
  height:20px;
}
.pg_cgo_vlt_report_adm_portlet > .descage_ctrl {
}
.pg_cgo_vlt_report_adm_portlet > .descage_ctrl > input{
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
 String def="[{\"h\":\"508\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"903\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"983\",\"y\":\"8\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"93\",\"x\":\"131\",\"y\":\"-68\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"239\",\"y\":\"-68\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data:\",\"w\":\"104\",\"x\":\"13\",\"y\":\"43\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data:\",\"w\":\"104\",\"x\":\"215\",\"y\":\"43\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"75\",\"x\":\"121\",\"y\":\"42\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"adope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"75\",\"x\":\"325\",\"y\":\"42\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CalDaOpe\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"197\",\"y\":\"42\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CalAdOpe\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"401\",\"y\":\"42\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"StampaMonitor\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"943\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"383\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"69\",\"zindex\":\"2\"},{\"h\":\"30\",\"name\":\"RTStampa2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"147\",\"x\":\"422\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"coddip\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"96\",\"x\":\"121\",\"y\":\"12\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom16\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"221\",\"y\":\"12\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CODICEAAMS\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"642\",\"y\":\"12\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAgenzia\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"104\",\"x\":\"15\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"descage\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"391\",\"x\":\"246\",\"y\":\"12\",\"zindex\":\"6\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_vlt_report_adm","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_vlt_report_adm_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_vlt_report_adm','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblDaOpe= "Da Data:";
String lblAScad_Copy= "A Data:";
java.sql.Date daope= JSPLib.NullDate();
if(request.getAttribute("pg_cgo_vlt_report_adm_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
java.sql.Date adope= JSPLib.NullDate();
if(request.getAttribute("pg_cgo_vlt_report_adm_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String coddip=sp.getGlobal("coddip","");
if(request.getAttribute("pg_cgo_vlt_report_adm_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String CODICEAAMS= "";
String lblAgenzia= "Agenzia:";
String descage= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_vlt_report_adm_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_vlt_report_adm_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_vlt_report_adm_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_vlt_report_adm','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_StampaIdentifica' class='image StampaIdentifica_ctrl'   target=''>&#xea8c;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<span id='<%=idPortlet%>_lblDaOpe'  formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data:")%></div></span>
<span id='<%=idPortlet%>_lblAScad_Copy'  formid='<%=idPortlet%>' ps-name='lblAScad_Copy'    class='label lblAScad_Copy_ctrl'><div id='<%=idPortlet%>_lblAScad_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Data:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_daope_wrp'><input id='<%=idPortlet%>_daope' name='daope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daope' /></span>
<span class='textbox-container'id='<%=idPortlet%>_adope_wrp'><input id='<%=idPortlet%>_adope' name='adope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='adope' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_CalDaOpe' class='calendar' onclick='window.<%=idPortlet%>.CalDaOpe.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_CalAdOpe' class='calendar' onclick='window.<%=idPortlet%>.CalAdOpe.PopupCalendar();' style='text-decoration:none;'></a>
 <a id='<%=idPortlet%>_StampaMonitor' class='image StampaMonitor_ctrl'   target=''>&#xea8c;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_coddip_wrp'><input id='<%=idPortlet%>_coddip' name='coddip' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='coddip' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom16'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_CODICEAAMS_wrp'><input id='<%=idPortlet%>_CODICEAAMS' name='CODICEAAMS' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='CODICEAAMS' /></span>
<span id='<%=idPortlet%>_lblAgenzia'  formid='<%=idPortlet%>' ps-name='lblAgenzia'    class='label lblAgenzia_ctrl'><div id='<%=idPortlet%>_lblAgenziatbl' style='width:100%;'><%=JSPLib.ToHTML("Agenzia:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_descage_wrp'><input id='<%=idPortlet%>_descage' name='descage' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descage' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_vlt_report_adm');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_vlt_report_adm',["1024"],["508"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"508","title":"","layer":"false","npage":"1"}]);
this.StampaIdentifica=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image StampaIdentifica_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_StampaIdentifica","edit_undercond":"","field":"","font_color":"#38895B","font_color_hover":"#01FB6B","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa i ticket che necessitano di identificazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"StampaIdentifica","page":1,"path_type":"","server_side":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":903,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la maschera",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Uscita","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":983,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":93,"x":131,"y":-68});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTStampa1=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa1","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa1","offline":false,"page":1,"parms":"ReportName=arrp_cgo_vlt_report.vrp,outputFormat=XLS,hideParameterMask=true,pDaImportoE=500,pA_ImportoE=0,pDaImportoC=400,pA_ImportoC=499.99,pDaData=daope,pA_Data=adope,pStampaE=S,pStampaC=S,pSala=CODICEAAMS","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":147,"x":239,"y":-68});
this.RTStampa1.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":104,"x":13,"y":43,"zindex":"1"});
this.lblAScad_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAScad_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAScad_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblAScad_Copy,false,true)%>","type":"Label","w":104,"x":215,"y":43,"zindex":"1"});
this.daope=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=daope%>","w":75,"x":121,"y":42,"zerofilling":false,"zindex":"1","zoom":""});
this.adope=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_adope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"adope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=adope%>","w":75,"x":325,"y":42,"zerofilling":false,"zindex":"1","zoom":""});
this.CalDaOpe=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_CalDaOpe','CalDaOpe',197,42,20,20,'Verdana','10','top-left','true','daope',{});
this.CalAdOpe=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_CalAdOpe','CalAdOpe',401,42,20,20,'Verdana','10','top-left','true','adope',{});
this.StampaMonitor=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image StampaMonitor_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_StampaMonitor","edit_undercond":"","field":"","font_color":"#0B05FD","font_color_hover":"#05C6FD","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa i ticket da monitorare",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"StampaMonitor","page":1,"path_type":"","server_side":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":943,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":383,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"type":"Iframe","w":1024,"x":0,"y":69,"zindex":"2"});
this.RTStampa2=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa2","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa2","offline":false,"page":1,"parms":"ReportName=arrp_cgo_vlt_report.vrp,outputFormat=XLS,hideParameterMask=true,pDaImportoE=0,pA_ImportoE=0,pDaImportoC=100,pA_ImportoC=399.99,pDaData=daope,pA_Data=adope,pStampaE=N,pStampaC=S,pSala=CODICEAAMS","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":147,"x":422,"y":-68});
this.RTStampa2.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.coddip=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_coddip","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"global string","layer":false,"layout_steps_values":{},"maxlength":"","name":"coddip","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(coddip,false,true)%>","w":96,"x":121,"y":12,"zerofilling":false,"zindex":"3","zoom":""});
this.LinkZoom16=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom16","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_cgo_vlt_report_adm_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"coddip,descage,CODICEAAMS","intovarsType":"C,C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_cgo_vlt_report_adm_portlet.jspLinkZoom16",request.getSession())%>","linkedField":"coddip","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom16","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"CODDIP,DESCRIZ,CODICEAAMS","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,anadip,default",request.getSession())%>","suggest":false,"table":"anadip","type":"LinkZoom","w":20,"x":221,"y":12,"zindex":"4","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.CODICEAAMS=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_CODICEAAMS","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"CODICEAAMS","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(CODICEAAMS,false,true)%>","w":120,"x":642,"y":12,"zerofilling":false,"zindex":"5","zoom":""});
this.lblAgenzia=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAgenzia","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAgenzia","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblAgenzia,false,true)%>","type":"Label","w":104,"x":15,"y":14,"zindex":"1"});
this.descage=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descage","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descage,false,true)%>","w":391,"x":246,"y":12,"zerofilling":false,"zindex":"6","zoom":""});
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
<%if(request.getAttribute("pg_cgo_vlt_report_adm_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_vlt_report_adm_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_vlt_report_adm_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.StampaIdentifica.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.StampaMonitor.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_vlt_report_adm',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_vlt_report_adm');
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
sp.endPage("pg_cgo_vlt_report_adm");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom16")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anadip";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"CODDIP", "DESCRIZ", "CODICEAAMS"};
  result.m_rdTypes = new String[]{"C", "C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "798722163"; } %>