<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link()  \n  }  \n}\n\nfunction image5_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link()\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.pMsg.Timer0.Start()\n    this.pLog.Timer0.Start()\n    this.RTSalva.Link();\n  }    \n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link()\n}  \n\nfunction this_Loaded(){\n  this.getTitlePortlet().SetTitle('Import Rapporti (UNICREDIT)',true)\n  this.getTitlePortlet().SetSubTitle('',true)\n  this.RTAzzera.Link();\n}\n\nfunction RTSalva_Result(result){\n  this.pLog.Timer0_onTimer()\n  this.pMsg.Timer0_onTimer()\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0.Stop()\n  alert(\"Elaborazione Terminata\");\n}\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"350","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"851","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"1","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"750","wireframe_props":"name","x":"64","y":"11","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"2","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_execute.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"769","y":"36","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"NomeFile:","w":"51","wireframe_props":"align,value,n_col","x":"8","y":"14","zindex":"1"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"image5","page":"1","path_type":"","sequence":"4","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"822","y":"9","zindex":"1"},{"async":"false","entity_type":"","h":"30","m_cAction":"","m_cAltInterface":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"5","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"57","y":"-67"},{"async":"true","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"RTSalva","offline":"false","page":"1","parms":"w_tipodest=rDest,w_nomefile=nomefile,w_codmage=codmage","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"arrt_import_unicredit","target":"","type":"SPLinker","w":"30","x":"3","y":"-67"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","disabled":"false","edit_undercond":"","font":"","font_size":"","h":"23","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"D","layout_steps_values":"{}","name":"rDest","orientation":"horizontal","page":"1","picture":"","sequence":"7","tabindex":"","textlist":"Definitivo,Provvisorio","type":"Radio","typevar":"character","valuelist":"D,P","visible":"true","w":"188","wireframe_props":"","x":"146","y":"44","zindex":"2"},{"anchor":"","h":"143","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"8","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"846","wireframe_props":"","x":"2","y":"110","zindex":"3"},{"anchor":"","h":"67","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"9","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"846","wireframe_props":"","x":"2","y":"255","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label18","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Destinazione Dati:","w":"129","wireframe_props":"align,value,n_col","x":"15","y":"46","zindex":"7"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"11","type":"EventReceiver","w":"111","x":"109","y":"-70"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"244","y":"-59"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","m_cAltInterface":"","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":"120","x":"502","y":"-57"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"14","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_exit.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"812","y":"36","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"5","name":"codmage","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"47","wireframe_props":"name","x":"149","y":"75","zerofilling":"false","zindex":"8"},{"anchor":"","calculateZoomTitle":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"codmage,descmage","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"codmage","linkedUsing":"","looselylinked":"false","n_criteria":"1","name":"LinkZoom16","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"MACODICE,MADESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"16","servlet":"","suggest":"false","table":"tbmacage","type":"LinkZoom","w":"20","wireframe_props":"","x":"199","y":"75","zindex":"9","zoomtitle":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label18_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Macro Agente:","w":"129","wireframe_props":"align,value,n_col","x":"18","y":"77","zindex":"7"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"descmage","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"18","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"436","wireframe_props":"name","x":"233","y":"75","zerofilling":"false","zindex":"10"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","m_cAltInterface":"","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"19","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"673","y":"-54"},{"async":"false","entity_type":"","h":"30","m_cAction":"","m_cAltInterface":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"20","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"91","x":"380","y":"-68"}]%>
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
window.pg_import_unicredit_Static=function(){
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof image5_Click !='undefined')this.image5_Click=image5_Click;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTSalva_Result !='undefined')this.RTSalva_Result=RTSalva_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.LinkZoom16.addObserverFixedVars();
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link()  
  }  
}
function image5_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link()
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.pMsg.Timer0.Start()
    this.pLog.Timer0.Start()
    this.RTSalva.Link();
  }    
}
function Aggiorna() {
  this.RTSaveFile.Link()
}  
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Import Rapporti (UNICREDIT)',true)
  this.getTitlePortlet().SetSubTitle('',true)
  this.RTAzzera.Link();
}
function RTSalva_Result(result){
  this.pLog.Timer0_onTimer()
  this.pMsg.Timer0_onTimer()
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0.Stop()
  alert("Elaborazione Terminata");
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
.pg_import_unicredit_container {
}
.pg_import_unicredit_title_container {
  margin: auto;
}
.pg_import_unicredit_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:851px;
  height:350px;
  background-color:#FFFFFF;
}
.pg_import_unicredit_portlet[Data-page="1"]{
  height:350px;
  width:100%;
}
.pg_import_unicredit_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  left:64px;
  left:7.520564%;
  right:37px;
  right:4.347826%;
  width:auto;
  height:20px;
}
.pg_import_unicredit_portlet > .nomefile_ctrl {
}
.pg_import_unicredit_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_import_unicredit_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  right:52px;
  width:30px;
  height:30px;
}
.pg_import_unicredit_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_unicredit_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:8px;
  left:0.9400705%;
  right:792px;
  right:93.06698%;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_import_unicredit_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_import_unicredit_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_import_unicredit_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:822px;
  left:96.59225%;
  right:9px;
  right:1.0575793%;
  width:auto;
  height:20px;
}
.pg_import_unicredit_portlet > .image5_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_import_unicredit_portlet > .rDest_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:44px;
  left:146px;
  left:17.156286%;
  right:517px;
  right:60.752056%;
  width:auto;
  height:23px;
  height:auto;
  min-height:23px;
}
.pg_import_unicredit_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:110px;
  left:2px;
  left:0.23501763%;
  right:3px;
  right:0.35252643%;
  width:auto;
  height:auto;
  min-height:143px;
}
.pg_import_unicredit_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:255px;
  left:2px;
  left:0.23501763%;
  right:3px;
  right:0.35252643%;
  width:auto;
  height:auto;
  min-height:67px;
}
.pg_import_unicredit_portlet > .Label18_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:46px;
  left:15px;
  left:1.7626323%;
  right:707px;
  right:83.07873%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_unicredit_portlet > .Label18_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_unicredit_portlet > .Label18_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_unicredit_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  right:9px;
  width:30px;
  height:30px;
}
.pg_import_unicredit_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_unicredit_portlet > .codmage_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:75px;
  left:149px;
  left:17.508814%;
  right:655px;
  right:76.96827%;
  width:auto;
  height:20px;
}
.pg_import_unicredit_portlet > .codmage_ctrl {
}
.pg_import_unicredit_portlet > .codmage_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_unicredit_portlet > .LinkZoom16_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:75px;
  left:199px;
  left:23.384254%;
  right:632px;
  right:74.26557%;
  width:auto;
  height:20px;
}
.pg_import_unicredit_portlet > .Label18_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:77px;
  left:18px;
  left:2.1151586%;
  right:704px;
  right:82.726204%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_unicredit_portlet > .Label18_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_unicredit_portlet > .Label18_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_unicredit_portlet > .descmage_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:75px;
  left:233px;
  left:27.379553%;
  right:182px;
  right:21.386604%;
  width:auto;
  height:22px;
}
.pg_import_unicredit_portlet > .descmage_ctrl {
}
.pg_import_unicredit_portlet > .descmage_ctrl > input{
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
 String def="[{\"h\":\"350\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"851\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"750\",\"x\":\"64\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"769\",\"y\":\"36\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"51\",\"x\":\"8\",\"y\":\"14\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image5\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"822\",\"y\":\"9\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"57\",\"y\":\"-67\"},{\"h\":\"30\",\"name\":\"RTSalva\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"3\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"rDest\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"188\",\"x\":\"146\",\"y\":\"44\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"143\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"846\",\"x\":\"2\",\"y\":\"110\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"67\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"846\",\"x\":\"2\",\"y\":\"255\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Destinazione Dati:\",\"w\":\"129\",\"x\":\"15\",\"y\":\"46\",\"zindex\":\"7\"},{\"h\":\"30\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"109\",\"y\":\"-70\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"244\",\"y\":\"-59\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"502\",\"y\":\"-57\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"812\",\"y\":\"36\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codmage\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"47\",\"x\":\"149\",\"y\":\"75\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom16\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"199\",\"y\":\"75\",\"zindex\":\"9\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Macro Agente:\",\"w\":\"129\",\"x\":\"18\",\"y\":\"77\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"descmage\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"436\",\"x\":\"233\",\"y\":\"75\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"RTAzzera\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"673\",\"y\":\"-54\"},{\"h\":\"30\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"91\",\"x\":\"380\",\"y\":\"-68\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_import_unicredit","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_import_unicredit_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_import_unicredit','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String nomefile= "";
if(request.getAttribute("pg_import_unicredit_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label1= "NomeFile:";
String rDest="D";
String Label18= "Destinazione Dati:";
String dir= "";
String codmage= "";
if(request.getAttribute("pg_import_unicredit_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String Label18_Copy= "Macro Agente:";
String descmage= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_import_unicredit_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_import_unicredit_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_import_unicredit_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_import_unicredit','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<a id='<%=idPortlet%>_image5' class='image image5_ctrl'   target=''>&#xe9da;</a>
<div id='<%=idPortlet%>_rDest' class='radio' style='z-index:1;'></div>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span id='<%=idPortlet%>_Label18'  formid='<%=idPortlet%>' ps-name='Label18'    class='label Label18_ctrl'><div id='<%=idPortlet%>_Label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Destinazione Dati:")%></div></span>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xea01;</a>
<span class='textbox-container'id='<%=idPortlet%>_codmage_wrp'><input id='<%=idPortlet%>_codmage' name='codmage' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='codmage' /></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom16'" ) );%>
<span id='<%=idPortlet%>_Label18_Copy'  formid='<%=idPortlet%>' ps-name='Label18_Copy'    class='label Label18_Copy_ctrl'><div id='<%=idPortlet%>_Label18_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Macro Agente:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_descmage_wrp'><input id='<%=idPortlet%>_descmage' name='descmage' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='descmage' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_import_unicredit');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_import_unicredit',["851"],["350"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"350","title":"","layer":"false","npage":"1"}]);
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":750,"x":64,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":769,"y":36,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":51,"x":8,"y":14,"zindex":"1"});
this.image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":822,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":30,"x":57,"y":-67});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.RTSalva=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSalva","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSalva","offline":false,"page":1,"parms":"w_tipodest=rDest,w_nomefile=nomefile,w_codmage=codmage","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_import_unicredit","target":"","type":"SPLinker","w":30,"x":3,"y":-67});
this.RTSalva.m_cID='<%=JSPLib.cmdHash("routine,arrt_import_unicredit",request.getSession())%>';
this.rDest=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Definitivo,Provvisorio","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_rDest","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"font":"","font_size":"","h":23,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"D","layer":false,"layout_steps_values":{},"name":"rDest","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,P","visible":true,"w":188,"x":146,"y":44,"zindex":"2"});
this.rDest.Value('<%=JSPLib.ToJSValue(rDest,false,true)%>');
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","type":"Portlet","w":846,"x":2,"y":110,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":67,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":846,"x":2,"y":255,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.Label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label18,false,true)%>","type":"Label","w":129,"x":15,"y":46,"zindex":"7"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":109,"y":-70});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":120,"x":502,"y":-57});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file",request.getSession())%>';
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":812,"y":36,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.codmage=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codmage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"codmage","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codmage,false,true)%>","w":47,"x":149,"y":75,"zerofilling":false,"zindex":"8","zoom":""});
this.LinkZoom16=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left(%)-right(%)","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom16","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_import_unicredit_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"codmage,descmage","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_import_unicredit_portlet.jspLinkZoom16",request.getSession())%>","linkedField":"codmage","linkedUsing":"","looselylinked":false,"n_criteria":"1","name":"LinkZoom16","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"MACODICE,MADESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,tbmacage,default",request.getSession())%>","suggest":false,"table":"tbmacage","type":"LinkZoom","w":20,"x":199,"y":75,"zindex":"9","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.Label18_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label18_Copy,false,true)%>","type":"Label","w":129,"x":18,"y":77,"zindex":"7"});
this.descmage=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_descmage","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"descmage","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(descmage,false,true)%>","w":436,"x":233,"y":75,"zerofilling":false,"zindex":"10","zoom":""});
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":673,"y":-54});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":91,"x":380,"y":-68});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
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
<%if(request.getAttribute("pg_import_unicredit_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_import_unicredit_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_import_unicredit_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.image5.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_import_unicredit',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_import_unicredit');
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
sp.endPage("pg_import_unicredit");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom16")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbmacage";
  result.n_KMode = 1;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_rdField = new String[]{"MACODICE", "MADESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "3287654451"; } %>