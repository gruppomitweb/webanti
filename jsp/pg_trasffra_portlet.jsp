<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Elabora_Click(){\n  if (confirm(\"Confermi il traferimento delle frazionate?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTTrasferisci.Link()   \n  }  \n}\n\nfunction Uscita_Click() {\n  this.BtnUscita.Link()\n}  \n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"TRASFERIMENTO FRAZIONATE DA PROVVISORIO AD AUI\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n  this.RTAzzera.Link();\n}\n\nfunction RTTrasferisci_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()  \n  alert('Elaborazione Terminata!');  \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"TRASFERIMENTO FRAZIONATE DA PROVVISORIO AD AUI","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"250","hsl":"","htmlcode":"{{ lblDaOpe }}\n{{ daope }}\n{{ CalDaOpe }}\n{{ lblAScad_Copy }}\n{{ adope }}\n{{ CalAdOpe }}\n{{ flgforce }}\n{{ Label_INFORM }}\n{{ Textbox_INFORM }}\n{{ LinkZoom_xraziobo }}\n{{ Elabora }}\n{{ Uscita }}\n{{ pLog }}\n{{ pMsg }}\n{{ RTAzzera }}\n{{ RTTrasferisci }}\n{{ BtnUscita }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"1200","min_w":"800","my_library":"Utilities.js","offline":"false","on_security_failure":"login","pages_names":"TRASFERIMENTO FRAZIONATE DA PROVVISORIO AD AUI","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"600","version":"37","w":"100%","wizard":""},{"align":"right","anchor":"","assoc_input":"daope","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblDaOpe","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"1","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data:","w":"40","wireframe_props":"align,value,n_col","x":"1","y":"18","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"false","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"daope","page":"1","password":"","picture":"","placeholder":"Da Data","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"50","wireframe_props":"name","x":"42","y":"17","zerofilling":"false","zindex":"1"},{"anchor":"","css_class":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"CalDaOpe","page":"1","popup":"true","return_input":"daope","sequence":"3","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"93","y":"17","zindex":""},{"align":"right","anchor":"","assoc_input":"adope","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblAScad_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data:","w":"40","wireframe_props":"align,value,n_col","x":"115","y":"18","zindex":"1"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"adope","page":"1","password":"","picture":"","placeholder":"A Data","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"50","wireframe_props":"name","x":"156","y":"17","zerofilling":"false","zindex":"1"},{"anchor":"","css_class":"","font":"Verdana","font_size":"10","h":"20","hide":"false","layer":"false","layout_steps_values":"{}","name":"CalAdOpe","page":"1","popup":"true","return_input":"adope","sequence":"6","spuid":"","type":"Calendario","w":"20","wireframe_props":"","x":"207","y":"17","zindex":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"Forza il passaggio dati anche in presenza di frazionate con lo stesso riferimento d'importazione","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Forza Trasferimento","layer":"false","layout_steps_values":"{}","name":"flgforce","page":"1","sequence":"7","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"135","wireframe_props":"label_text","x":"229","y":"17","zindex":"2"},{"align":"right","anchor":"","assoc_input":"Textbox_INFORM","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_INFORM","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Riferimento 2:","w":"65","wireframe_props":"align,value,n_col","x":"367","y":"17","zindex":"6"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Indicare il riferimento 2 per filtrare i dati","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"30","name":"Textbox_INFORM","page":"1","password":"","picture":"","placeholder":"Riferimento 2","readonly":"false","scroll":"false","sequence":"9","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"75","wireframe_props":"name","x":"434","y":"17","zerofilling":"false","zindex":"4"},{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":"","advanced_suggester_width":"","anchor":"","calculateZoomTitle":"","class_Css":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"Textbox_INFORM","keyfixedfilters":"","layer":"false","layout_steps_values":"{}","linkedField":"Textbox_INFORM","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom_xraziobo","offline":"false","openZoomOnMultipleRecord":"true","page":"1","path_type":"","queryparms":"","readfields":"INFORM","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"10","servlet":"","spuid":"","suggest":"false","table":"xraziobo","type":"LinkZoom","w":"20","wireframe_props":"","x":"510","y":"17","zindex":"5","zoomtitle":"Vista frazionate provvisorie per selezione riferimento 2"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Trasferisce frazionate da provvisorio ad AUI","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Elabora","page":"1","path_type":"","sequence":"11","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fprinter.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"533","y":"8","zindex":"0"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la maschera","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Uscita","page":"1","path_type":"","sequence":"12","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"566","y":"8","zindex":"1"},{"anchor":"","h":"143","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"13","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"600","wireframe_props":"","x":"0","y":"47","zindex":"3"},{"anchor":"","h":"60","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"14","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"600","wireframe_props":"","x":"0","y":"190","zindex":""},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"88","x":"271","y":"-60"},{"allowedentities":"","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTTrasferisci","offline":"false","page":"1","parms":"pDatIni=daope,pDatFin=adope,pForza=flgforce,pInform=Textbox_INFORM","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"arrt_trasffra","target":"","type":"SPLinker","w":"104","x":"367","y":"-59"},{"allowedentities":"","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"93","x":"476","y":"-59"}]%>
<%/*Description:TRASFERIMENTO FRAZIONATE DA PROVVISORIO AD AUI*/%>
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
window.pg_trasffra_Static=function(){
if(typeof Elabora_Click !='undefined')this.Elabora_Click=Elabora_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTTrasferisci_Result !='undefined')this.RTTrasferisci_Result=RTTrasferisci_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom_xraziobo.addObserverFixedVars();
function Elabora_Click(){
  if (confirm("Confermi il traferimento delle frazionate?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTTrasferisci.Link()   
  }  
}
function Uscita_Click() {
  this.BtnUscita.Link()
}  
function this_Loaded(){
  this.getTitlePortlet().SetTitle("TRASFERIMENTO FRAZIONATE DA PROVVISORIO AD AUI",true)
  this.getTitlePortlet().SetSubTitle("",true)
  this.RTAzzera.Link();
}
function RTTrasferisci_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()  
  alert('Elaborazione Terminata!');  
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
.pg_trasffra_container {
}
.pg_trasffra_title_container {
  margin: auto;
}
.pg_trasffra_portlet{
  position:relative;
  margin: auto;
  width:100%;
max-width:1200px;
  min-width:800px;
  height:250px;
  background-color:#FFFFFF;
}
.pg_trasffra_portlet[Data-page="1"]{
  height:250px;
  width:100%;
}
.pg_trasffra_portlet > .lblDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:1px;
  left:0.16666667%;
  right:559px;
  right:93.166664%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_trasffra_portlet > .lblDaOpe_ctrl {
  height:auto;
  min-height:19px;
}
.pg_trasffra_portlet > .lblDaOpe_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_trasffra_portlet > .daope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:42px;
  left:7.0%;
  right:508px;
  right:84.666664%;
  width:auto;
  height:20px;
}
.pg_trasffra_portlet > .daope_ctrl {
}
.pg_trasffra_portlet > .daope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_trasffra_portlet > .CalDaOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:93px;
  left:15.5%;
  right:487px;
  right:81.166664%;
  width:auto;
  height:20px;
}
.pg_trasffra_portlet > .lblAScad_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:18px;
  left:115px;
  left:19.166666%;
  right:445px;
  right:74.166664%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_trasffra_portlet > .lblAScad_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_trasffra_portlet > .lblAScad_Copy_ctrl {
  overflow:hidden;
  text-align:right;
  background-color:transparent;
}
.pg_trasffra_portlet > .adope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:156px;
  left:26.0%;
  right:394px;
  right:65.666664%;
  width:auto;
  height:20px;
}
.pg_trasffra_portlet > .adope_ctrl {
}
.pg_trasffra_portlet > .adope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_trasffra_portlet > .CalAdOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:17px;
  left:207px;
  left:34.5%;
  right:373px;
  right:62.166668%;
  width:auto;
  height:20px;
}
.pg_trasffra_portlet > .flgforce_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:17px;
  left:229px;
  left:38.166668%;
  right:236px;
  right:39.333332%;
  width:auto;
  height:20px;
}
.pg_trasffra_portlet > .Label_INFORM_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:17px;
  left:367px;
  left:61.166668%;
  right:168px;
  right:28.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_trasffra_portlet > .Label_INFORM_ctrl {
  height:auto;
  min-height:20px;
}
.pg_trasffra_portlet > .Label_INFORM_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_trasffra_portlet > .Textbox_INFORM_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:17px;
  left:434px;
  left:72.333336%;
  right:91px;
  right:15.166667%;
  width:auto;
  height:20px;
}
.pg_trasffra_portlet > .Textbox_INFORM_ctrl {
}
.pg_trasffra_portlet > .Textbox_INFORM_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_trasffra_portlet > .LinkZoom_xraziobo_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:17px;
  left:510px;
  left:85.0%;
  right:70px;
  right:11.666667%;
  width:auto;
  height:20px;
}
.pg_trasffra_portlet > .Elabora_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:8px;
  right:37px;
  width:30px;
  height:30px;
}
.pg_trasffra_portlet > .Elabora_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_trasffra_portlet > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  right:4px;
  width:30px;
  height:30px;
}
.pg_trasffra_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_trasffra_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:47px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:143px;
}
.pg_trasffra_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:190px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:60px;
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
 String def="[{\"h\":\"250\",\"layout_steps_values\":{},\"pages_names\":\"TRASFERIMENTO FRAZIONATE DA PROVVISORIO AD AUI\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"600\",\"w\":\"100%\",\"wizard\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data:\",\"w\":\"40\",\"x\":\"1\",\"y\":\"18\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"daope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"50\",\"x\":\"42\",\"y\":\"17\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CalDaOpe\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"93\",\"y\":\"17\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAScad_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data:\",\"w\":\"40\",\"x\":\"115\",\"y\":\"18\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"adope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"50\",\"x\":\"156\",\"y\":\"17\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"CalAdOpe\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"207\",\"y\":\"17\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Forza Trasferimento\",\"layout_steps_values\":{},\"name\":\"flgforce\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"135\",\"x\":\"229\",\"y\":\"17\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_INFORM\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Riferimento 2:\",\"w\":\"65\",\"x\":\"367\",\"y\":\"17\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_INFORM\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"75\",\"x\":\"434\",\"y\":\"17\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom_xraziobo\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"510\",\"y\":\"17\",\"zindex\":\"5\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Elabora\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"533\",\"y\":\"8\",\"zindex\":\"0\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"Uscita\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"566\",\"y\":\"8\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"143\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"600\",\"x\":\"0\",\"y\":\"47\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"60\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"600\",\"x\":\"0\",\"y\":\"190\",\"zindex\":\"\"},{\"h\":\"20\",\"name\":\"RTAzzera\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"88\",\"x\":\"271\",\"y\":\"-60\"},{\"h\":\"20\",\"name\":\"RTTrasferisci\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"104\",\"x\":\"367\",\"y\":\"-59\"},{\"h\":\"20\",\"name\":\"BtnUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"93\",\"x\":\"476\",\"y\":\"-59\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_trasffra","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_trasffra_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_trasffra','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String lblDaOpe= "Da Data:";
java.sql.Date daope= JSPLib.NullDate();
if(request.getAttribute("pg_trasffra_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_trasffra_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String lblAScad_Copy= "A Data:";
java.sql.Date adope= JSPLib.NullDate();
String flgforce="S";
String Label_INFORM= "Riferimento 2:";
String Textbox_INFORM= "";
if(request.getAttribute("pg_trasffra_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_trasffra_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_trasffra_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_trasffra_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_trasffra','<%=idPortlet%>',false,'');
</script><%}}%>
<label id='<%=idPortlet%>_lblDaOpe' for='<%=idPortlet%>_daope' formid='<%=idPortlet%>' ps-name='lblDaOpe'    class='label lblDaOpe_ctrl'><div id='<%=idPortlet%>_lblDaOpetbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_daope_wrp'><input id='<%=idPortlet%>_daope' name='daope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='daope' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("Da Data"))%>/></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_CalDaOpe' class='calendar' onclick='window.<%=idPortlet%>.CalDaOpe.PopupCalendar();' style='text-decoration:none;'></a>
 <label id='<%=idPortlet%>_lblAScad_Copy' for='<%=idPortlet%>_adope' formid='<%=idPortlet%>' ps-name='lblAScad_Copy'    class='label lblAScad_Copy_ctrl'><div id='<%=idPortlet%>_lblAScad_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("A Data:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_adope_wrp'><input id='<%=idPortlet%>_adope' name='adope' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='adope' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("A Data"))%>/></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_CalAdOpe' class='calendar' onclick='window.<%=idPortlet%>.CalAdOpe.PopupCalendar();' style='text-decoration:none;'></a>
 <div id='<%=idPortlet%>_flgforce_div' style=''><input id='<%=idPortlet%>_flgforce' name='flgforce' class='slider checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Forza il passaggio dati anche in presenza di frazionate con lo stesso riferimento d'importazione" )%> /><label for='<%=idPortlet%>_flgforce' class='label' title=<%=JSPLib.ToHTMLValue("Forza il passaggio dati anche in presenza di frazionate con lo stesso riferimento d'importazione" )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("Forza Trasferimento")%></label></div>
<label id='<%=idPortlet%>_Label_INFORM' for='<%=idPortlet%>_Textbox_INFORM' formid='<%=idPortlet%>' ps-name='Label_INFORM'    class='label Label_INFORM_ctrl'><div id='<%=idPortlet%>_Label_INFORMtbl' style='width:100%;'><%=JSPLib.ToHTML("Riferimento 2:")%></div></label>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_INFORM_wrp'><input id='<%=idPortlet%>_Textbox_INFORM' name='Textbox_INFORM' type='text' maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_INFORM' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("Riferimento 2"))%>/></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom_xraziobo'" ) );%>
<a id='<%=idPortlet%>_Elabora' class='image Elabora_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_trasffra');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_trasffra',["600"],["250"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"600","h":"250","title":"TRASFERIMENTO FRAZIONATE DA PROVVISORIO AD AUI","layer":"false","npage":"1"}]);
this.lblDaOpe=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"daope","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblDaOpe","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblDaOpe","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblDaOpe,false,true)%>","type":"Label","w":40,"x":1,"y":18,"zindex":"1"});
this.daope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_daope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"daope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=daope%>","w":50,"x":42,"y":17,"zerofilling":false,"zindex":"1","zoom":""});
this.CalDaOpe=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_CalDaOpe','CalDaOpe',93,17,20,20,'Verdana','10','top-left(%)-right(%)','true','daope',{});
this.lblAScad_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"adope","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAScad_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAScad_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblAScad_Copy,false,true)%>","type":"Label","w":40,"x":115,"y":18,"zindex":"1"});
this.adope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_adope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"adope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=adope%>","w":50,"x":156,"y":17,"zerofilling":false,"zindex":"1","zoom":""});
this.CalAdOpe=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_CalAdOpe','CalAdOpe',207,17,20,20,'Verdana','10','top-left(%)-right(%)','true','adope',{});
this.flgforce=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"slider checkbox","ctrlid":"<%=idPortlet%>_flgforce","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Forza Trasferimento","layer":false,"layout_steps_values":{},"name":"flgforce","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"slider","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":135,"x":229,"y":17,"zindex":"2"});
this.flgforce.Value('<%=flgforce%>');
this.Label_INFORM=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"Textbox_INFORM","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_INFORM","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_INFORM","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_INFORM,false,true)%>","type":"Label","w":65,"x":367,"y":17,"zindex":"6"});
this.Textbox_INFORM=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_INFORM","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Indicare il riferimento 2 per filtrare i dati","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"30","name":"Textbox_INFORM","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(Textbox_INFORM,false,true)%>","w":75,"x":434,"y":17,"zerofilling":false,"zindex":"4","zoom":""});
this.LinkZoom_xraziobo=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom_xraziobo","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_trasffra_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"Textbox_INFORM","intovarsType":"C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_trasffra_portlet.jspLinkZoom_xraziobo",request.getSession())%>","linkedField":"Textbox_INFORM","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom_xraziobo","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"INFORM","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spuid":"","spztl":"<%=JSPLib.cmdHash("link,xraziobo,default",request.getSession())%>","suggest":false,"table":"xraziobo","type":"LinkZoom","w":20,"x":510,"y":17,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate("Vista frazionate provvisorie per selezione riferimento 2"),false,true)%>"});
this.Elabora=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Elabora_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Elabora","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Trasferisce frazionate da provvisorio ad AUI",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Elabora","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":533,"y":8,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la maschera",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Uscita","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":566,"y":8,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":600,"x":0,"y":47,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":60,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":600,"x":0,"y":190,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":88,"x":271,"y":-60});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.RTTrasferisci=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTTrasferisci","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTTrasferisci","offline":false,"page":1,"parms":"pDatIni=daope,pDatFin=adope,pForza=flgforce,pInform=Textbox_INFORM","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_trasffra","target":"","type":"SPLinker","w":104,"x":367,"y":-59});
this.RTTrasferisci.m_cID='<%=JSPLib.cmdHash("routine,arrt_trasffra",request.getSession())%>';
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":93,"x":476,"y":-59});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
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
<%if(request.getAttribute("pg_trasffra_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_trasffra_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_trasffra_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Elabora.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_trasffra',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_trasffra');
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
sp.endPage("pg_trasffra");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom_xraziobo")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "xraziobo";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"INFORM"};
  result.m_rdTypes = new String[]{"C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "9716322"; } %>