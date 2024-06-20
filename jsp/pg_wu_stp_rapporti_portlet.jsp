<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Stampa_Click(){\n  if (confirm(\"Confermi la stampa dei dati?\")) {  \n    this.RTReport.Link()\n  }  \n}\n\nfunction Uscita_Click() {\n  this.BtnUscita.Link()\n}  \n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"ESTRAZIONE RAPPORTI CONTINUATIVI\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n}\n\nfunction Excel_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.pMsg.Timer0.Start()    \n    this.RTExcel.Link()\n  }    \n}\n\nfunction RTExcel_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.filename.Value(result)\n  this.RTDownload.Link()\n  alert('Elaborazione competata')\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Estrazione Rapporti","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"370","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"Utilities.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"anchor":"top-left-right","h":"58","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"1","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"80","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Estrae l'elenco dei rapporti in formato excel","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Excel","page":"1","path_type":"","sequence":"2","server_side":"","src":"..\u002fimages\u002fpng\u002fprinter.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"939","y":"28","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la maschera","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Uscita","page":"1","path_type":"","sequence":"3","server_side":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"983","y":"28","zindex":"1"},{"async":"false","entity_type":"","h":"30","m_cAction":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"93","x":"683","y":"-68"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExcel","offline":"false","page":"1","parms":"w_codrap=codrap,w_WUCODMAGE=WUCODMAGE,w_xDESCRAP=xdesrap,w_xMADESCRI=xWUDESCRI","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_wu_stp_rapporti","target":"","type":"SPLinker","w":"120","x":"503","y":"-58"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa l'elenco dei rapporti continuativi","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Stampa","page":"1","path_type":"","sequence":"6","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"895","y":"28","zindex":"1"},{"anchor":"top-left-right","auto_resize":"false","border":"false","default_portlet":"","h":"199","hide":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"7","type":"Iframe","w":"1024","wireframe_props":"","x":"0","y":"147","zindex":"9"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"5","name":"WUCODMAGE","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"73","wireframe_props":"name","x":"166","y":"17","zerofilling":"false","zindex":"10"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblMacAge","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MacroAgente:","w":"118","wireframe_props":"align,value,n_col","x":"45","y":"19","zindex":"11"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"WUCODMAGE,xWUDESCRI","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"WUCODMAGE","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom13","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"MACODICE,MADESCRI","row_suggest":"5","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"10","servlet":"","suggest":"true","table":"tbmacage","type":"LinkZoom","w":"20","wireframe_props":"","x":"242","y":"17","zindex":"12","zoomtitle":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"50","name":"xWUDESCRI","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"11","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"375","wireframe_props":"name","x":"268","y":"17","zerofilling":"false","zindex":"13"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"25","name":"codrap","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"12","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"187","wireframe_props":"name","x":"166","y":"49","zerofilling":"false","zindex":"14"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblRapporto","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Rapporto:","w":"118","wireframe_props":"align,value,n_col","x":"45","y":"52","zindex":"11"},{"anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","defaultsfunction":"","fillemptykeys":"","fixedvars":"WUCODMAGE","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"codrap,xdesrap","keyfixedfilters":"MACODICE","layout_steps_values":"{}","linkedField":"codrap","linkedUsing":"","looselylinked":"","n_criteria":"2","name":"LinkZoom13_Copy","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"5","searchingfunction":"","sendkeystozoomonzoom":"","sequence":"14","servlet":"","suggest":"true","table":"anarapbo","type":"LinkZoom","w":"20","wireframe_props":"","x":"357","y":"49","zindex":"12","zoomtitle":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"50","name":"xdesrap","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"15","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"375","wireframe_props":"name","x":"387","y":"49","zerofilling":"false","zindex":"15"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global string","name":"gDescAzi","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"128","y":"-64"},{"async":"false","entity_type":"report","h":"20","m_cAction":"","name":"RTReport","offline":"false","page":"1","parms":"ReportName=arrp_wu_stp_rapporti.vrp,w_WUCODMAGE=WUCODMAGE,w_xMADESCRI=xWUDESCRI,w_codrap=codrap,w_descazi=gDescAzi,hideParameterMask=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"","target":"iPrint","type":"SPLinker","w":"120","x":"-8","y":"-62"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"pFile=filename,pCartella=export","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"arrt_downloadxlsx","target":"","type":"SPLinker","w":"120","x":"353","y":"-54"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"841","y":"-50"}]%>
<%/*Description:Estrazione Rapporti*/%>
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
window.pg_wu_stp_rapporti_Static=function(){
if(typeof Stampa_Click !='undefined')this.Stampa_Click=Stampa_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Excel_Click !='undefined')this.Excel_Click=Excel_Click;
if(typeof RTExcel_Result !='undefined')this.RTExcel_Result=RTExcel_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom13.addObserverFixedVars();
this.LinkZoom13_Copy.addObserverFixedVars();
function Stampa_Click(){
  if (confirm("Confermi la stampa dei dati?")) {  
    this.RTReport.Link()
  }  
}
function Uscita_Click() {
  this.BtnUscita.Link()
}  
function this_Loaded(){
  this.getTitlePortlet().SetTitle("ESTRAZIONE RAPPORTI CONTINUATIVI",true)
  this.getTitlePortlet().SetSubTitle("",true)
}
function Excel_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {
    this.pMsg.Timer0.Start()    
    this.RTExcel.Link()
  }    
}
function RTExcel_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.filename.Value(result)
  this.RTDownload.Link()
  alert('Elaborazione competata')
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
.pg_wu_stp_rapporti_container {
}
.pg_wu_stp_rapporti_title_container {
  margin: auto;
}
.pg_wu_stp_rapporti_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:370px;
  background-color:#FFFFFF;
}
.pg_wu_stp_rapporti_portlet[Data-page="1"]{
  height:370px;
  width:100%;
}
.pg_wu_stp_rapporti_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:80px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:58px;
}
.pg_wu_stp_rapporti_portlet > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:28px;
  right:55px;
  width:30px;
  height:30px;
}
.pg_wu_stp_rapporti_portlet > .Excel_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_wu_stp_rapporti_portlet > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:28px;
  right:11px;
  width:30px;
  height:30px;
}
.pg_wu_stp_rapporti_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_wu_stp_rapporti_portlet > .Stampa_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:28px;
  right:99px;
  width:30px;
  height:30px;
}
.pg_wu_stp_rapporti_portlet > .Stampa_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_wu_stp_rapporti_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:147px;
  left:0px;
  right:0px;
  width:auto;
  height:199px;
}
.pg_wu_stp_rapporti_portlet > .WUCODMAGE_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:17px;
  left:166px;
  width:73px;
  height:20px;
}
.pg_wu_stp_rapporti_portlet > .WUCODMAGE_ctrl {
}
.pg_wu_stp_rapporti_portlet > .WUCODMAGE_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wu_stp_rapporti_portlet > .lblMacAge_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:19px;
  left:45px;
  width:118px;
  height:auto;
  min-height:20px;
}
.pg_wu_stp_rapporti_portlet > .lblMacAge_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wu_stp_rapporti_portlet > .lblMacAge_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wu_stp_rapporti_portlet > .LinkZoom13_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:17px;
  left:242px;
  width:20px;
  height:20px;
}
.pg_wu_stp_rapporti_portlet > .xWUDESCRI_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:17px;
  left:268px;
  width:375px;
  height:20px;
}
.pg_wu_stp_rapporti_portlet > .xWUDESCRI_ctrl {
}
.pg_wu_stp_rapporti_portlet > .xWUDESCRI_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wu_stp_rapporti_portlet > .codrap_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:49px;
  left:166px;
  width:187px;
  height:20px;
}
.pg_wu_stp_rapporti_portlet > .codrap_ctrl {
}
.pg_wu_stp_rapporti_portlet > .codrap_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wu_stp_rapporti_portlet > .lblRapporto_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:52px;
  left:45px;
  width:118px;
  height:auto;
  min-height:20px;
}
.pg_wu_stp_rapporti_portlet > .lblRapporto_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wu_stp_rapporti_portlet > .lblRapporto_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wu_stp_rapporti_portlet > .LinkZoom13_Copy_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:49px;
  left:357px;
  width:20px;
  height:20px;
}
.pg_wu_stp_rapporti_portlet > .xdesrap_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:49px;
  left:387px;
  width:375px;
  height:20px;
}
.pg_wu_stp_rapporti_portlet > .xdesrap_ctrl {
}
.pg_wu_stp_rapporti_portlet > .xdesrap_ctrl > input{
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
 String def="[{\"h\":\"370\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"58\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"80\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"939\",\"y\":\"28\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"983\",\"y\":\"28\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"93\",\"x\":\"683\",\"y\":\"-68\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"503\",\"y\":\"-58\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"895\",\"y\":\"28\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"199\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"147\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"WUCODMAGE\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"73\",\"x\":\"166\",\"y\":\"17\",\"zindex\":\"10\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMacAge\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MacroAgente:\",\"w\":\"118\",\"x\":\"45\",\"y\":\"19\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom13\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"242\",\"y\":\"17\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"xWUDESCRI\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"268\",\"y\":\"17\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codrap\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"187\",\"x\":\"166\",\"y\":\"49\",\"zindex\":\"14\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblRapporto\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Rapporto:\",\"w\":\"118\",\"x\":\"45\",\"y\":\"52\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom13_Copy\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"357\",\"y\":\"49\",\"zindex\":\"12\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"xdesrap\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"375\",\"x\":\"387\",\"y\":\"49\",\"zindex\":\"15\"},{\"h\":\"20\",\"name\":\"gDescAzi\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"128\",\"y\":\"-64\"},{\"h\":\"20\",\"name\":\"RTReport\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"-8\",\"y\":\"-62\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"353\",\"y\":\"-54\"},{\"h\":\"20\",\"name\":\"filename\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"841\",\"y\":\"-50\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_wu_stp_rapporti","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_wu_stp_rapporti_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_wu_stp_rapporti','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String WUCODMAGE= "";
if(request.getAttribute("pg_wu_stp_rapporti_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblMacAge= "MacroAgente:";
if(request.getAttribute("pg_wu_stp_rapporti_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String xWUDESCRI= "";
String codrap= "";
String lblRapporto= "Rapporto:";
String xdesrap= "";
String gDescAzi=sp.getGlobal("gDescAzi","");
String filename= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_wu_stp_rapporti_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_wu_stp_rapporti_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_wu_stp_rapporti_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_wu_stp_rapporti','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<a id='<%=idPortlet%>_Excel' class='image Excel_ctrl'   target=''>&#xea8c;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_Stampa' class='image Stampa_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_WUCODMAGE_wrp'><input id='<%=idPortlet%>_WUCODMAGE' name='WUCODMAGE' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='WUCODMAGE' /></span>
<span id='<%=idPortlet%>_lblMacAge'  formid='<%=idPortlet%>' ps-name='lblMacAge'    class='label lblMacAge_ctrl'><div id='<%=idPortlet%>_lblMacAgetbl' style='width:100%;'><%=JSPLib.ToHTML("MacroAgente:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom13'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_xWUDESCRI_wrp'><input id='<%=idPortlet%>_xWUDESCRI' name='xWUDESCRI' type='text' disabled maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='xWUDESCRI' /></span>
<span class='textbox-container'id='<%=idPortlet%>_codrap_wrp'><input id='<%=idPortlet%>_codrap' name='codrap' type='text' maxlength='25' class='textbox' formid='<%=idPortlet%>' ps-name='codrap' /></span>
<span id='<%=idPortlet%>_lblRapporto'  formid='<%=idPortlet%>' ps-name='lblRapporto'    class='label lblRapporto_ctrl'><div id='<%=idPortlet%>_lblRapportotbl' style='width:100%;'><%=JSPLib.ToHTML("Rapporto:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom13_Copy'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_xdesrap_wrp'><input id='<%=idPortlet%>_xdesrap' name='xdesrap' type='text' disabled maxlength='50' class='textbox' formid='<%=idPortlet%>' ps-name='xdesrap' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_wu_stp_rapporti');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_wu_stp_rapporti',["1024"],["370"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"370","title":"","layer":"false","npage":"1"}]);
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_pMsg","h":58,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":1024,"x":0,"y":80,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.Excel=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Excel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Excel","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Estrae l'elenco dei rapporti in formato excel",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Excel","page":1,"path_type":"","server_side":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":939,"y":28,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la maschera",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Uscita","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":983,"y":28,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":93,"x":683,"y":-68});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTExcel=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExcel","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExcel","offline":false,"page":1,"parms":"w_codrap=codrap,w_WUCODMAGE=WUCODMAGE,w_xDESCRAP=xdesrap,w_xMADESCRI=xWUDESCRI","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_wu_stp_rapporti","target":"","type":"SPLinker","w":120,"x":503,"y":-58});
this.RTExcel.m_cID='<%=JSPLib.cmdHash("routine,arrt_wu_stp_rapporti",request.getSession())%>';
this.Stampa=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Stampa_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Stampa","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa l'elenco dei rapporti continuativi",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Stampa","page":1,"path_type":"","server_side":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":895,"y":28,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"false","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":199,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"type":"Iframe","w":1024,"x":0,"y":147,"zindex":"9"});
this.WUCODMAGE=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_WUCODMAGE","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"WUCODMAGE","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(WUCODMAGE,false,true)%>","w":73,"x":166,"y":17,"zerofilling":false,"zindex":"10","zoom":""});
this.lblMacAge=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMacAge","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMacAge","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblMacAge,false,true)%>","type":"Label","w":118,"x":45,"y":19,"zindex":"11"});
this.LinkZoom13=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom13","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_wu_stp_rapporti_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"WUCODMAGE,xWUDESCRI","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_wu_stp_rapporti_portlet.jspLinkZoom13",request.getSession())%>","linkedField":"WUCODMAGE","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom13","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"MACODICE,MADESCRI","row_suggest":"5","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,tbmacage,default",request.getSession())%>","suggest":true,"table":"tbmacage","type":"LinkZoom","w":20,"x":242,"y":17,"zindex":"12","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.xWUDESCRI=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xWUDESCRI","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"xWUDESCRI","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xWUDESCRI,false,true)%>","w":375,"x":268,"y":17,"zerofilling":false,"zindex":"13","zoom":""});
this.codrap=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codrap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"25","name":"codrap","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codrap,false,true)%>","w":187,"x":166,"y":49,"zerofilling":false,"zindex":"14","zoom":""});
this.lblRapporto=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblRapporto","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblRapporto","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblRapporto,false,true)%>","type":"Label","w":118,"x":45,"y":52,"zindex":"11"});
this.LinkZoom13_Copy=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom13_Copy","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_wu_stp_rapporti_portlet.jsp","fillemptykeys":false,"fixedvars":"WUCODMAGE","h":20,"hide":"false","image":"","intovars":"codrap,xdesrap","intovarsType":"C,C","keyfixedfilters":"MACODICE","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_wu_stp_rapporti_portlet.jspLinkZoom13_Copy",request.getSession())%>","linkedField":"codrap","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom13_Copy","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"RAPPORTO,DESCRAP","row_suggest":"5","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,anarapbo,default",request.getSession())%>","suggest":true,"table":"anarapbo","type":"LinkZoom","w":20,"x":357,"y":49,"zindex":"12","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.xdesrap=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xdesrap","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"50","name":"xdesrap","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xdesrap,false,true)%>","w":375,"x":387,"y":49,"zerofilling":false,"zindex":"15","zoom":""});
this.gDescAzi=new ZtVWeb._VC(this,'gDescAzi',null,'character','<%=JSPLib.ToJSValue(gDescAzi,false,true)%>',false,false);
this.RTReport=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTReport","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTReport","offline":false,"page":1,"parms":"ReportName=arrp_wu_stp_rapporti.vrp,w_WUCODMAGE=WUCODMAGE,w_xMADESCRI=xWUDESCRI,w_codrap=codrap,w_descazi=gDescAzi,hideParameterMask=true","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"iPrint","type":"SPLinker","w":120,"x":-8,"y":-62});
this.RTReport.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"pFile=filename,pCartella=export","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadxlsx","target":"","type":"SPLinker","w":120,"x":353,"y":-54});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadxlsx",request.getSession())%>';
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
<%if(request.getAttribute("pg_wu_stp_rapporti_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_wu_stp_rapporti_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_wu_stp_rapporti_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Excel.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Stampa.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_wu_stp_rapporti',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_wu_stp_rapporti');
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
sp.endPage("pg_wu_stp_rapporti");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom13")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbmacage";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 5;
  result.m_rdField = new String[]{"MACODICE", "MADESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
if (Library.eq(p_cControlName,"LinkZoom13_Copy")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "anarapbo";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 5;
  result.m_rdField = new String[]{"RAPPORTO", "DESCRAP"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{"MACODICE"};
  result.m_kTypes = new String[]{"C"};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3082152566"; } %>