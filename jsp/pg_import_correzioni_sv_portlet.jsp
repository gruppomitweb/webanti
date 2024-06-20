<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function image_upload_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');  \n  this.RTUpload.Link();\n}\n\nfunction image_esegui_Click(){\n  this.Portlet_showlog.Timer0.Start();\n  this.Portlet_showmsg.Timer0.Start();\n  this.splinker_arrt_import_correzioni_sv.Link();\n}\n\nfunction splinker_arrt_import_correzioni_sv_Response(cMsg){\n  alert(cMsg)\n  this.Portlet_showlog.Timer0_onTimer();\n  this.Portlet_showmsg.Timer0_onTimer();\n  this.Portlet_showlog.Timer0.Stop();\n  this.Portlet_showmsg.Timer0.Stop();\n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n}  ","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"300\",\"w\":\"100%\"},\"480\":{\"h\":\"300\",\"w\":\"100%\"},\"768\":{\"h\":\"300\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"796","y":"26"},{"async":"true","entity_type":"routine","h":"30","m_cAction":"start","m_cAltInterface":"","name":"splinker_arrt_import_correzioni_sv","offline":"false","page":"1","parms":"nomefile=nomefile","popup":"true","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":"","refresh":"","sequence":"2","servlet":"arrt_import_correzioni_sv","target":"","type":"SPLinker","w":"261","x":"800","y":"56"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","m_cAltInterface":"","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":"120","x":"947","y":"-32"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":7,\"y\":14,\"w\":260,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":10,\"y\":14,\"w\":390,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":16,\"y\":14,\"w\":624,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"}}","maxlength":"","name":"nomefile","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"624","wireframe_props":"name","x":"16","y":"14","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"","h":"20","m_cAction":"","m_cAltInterface":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"5","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"419","y":"-11"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{\"320\":{\"x\":230,\"y\":44,\"w\":37,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"340\":{\"x\":244,\"y\":44,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":345,\"y\":44,\"w\":55,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":692,\"y\":11,\"w\":33,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"image_esegui","page":"1","path_type":"","sequence":"6","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"33","wireframe_props":"","x":"692","y":"11","zindex":"1"},{"anchor":"top-left-right","h":"150","hide":"false","isoptional":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":76,\"w\":\"318\",\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"340\":{\"x\":1,\"y\":76,\"w\":\"338\",\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":76,\"w\":\"478\",\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"768\":{\"x\":1,\"y\":76,\"w\":766,\"h\":150,\"anchor\":\"top-left-right\",\"hide\":\"false\"}}","name":"Portlet_showlog","page":"1","sequence":"7","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"766","wireframe_props":"","x":"1","y":"76","zindex":""},{"anchor":"top-left-right","h":"70","hide":"false","isoptional":"false","layout_steps_values":"{\"320\":{\"x\":1,\"y\":227,\"w\":\"318\",\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"340\":{\"x\":1,\"y\":227,\"w\":\"338\",\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"480\":{\"x\":1,\"y\":227,\"w\":\"478\",\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"768\":{\"x\":1,\"y\":227,\"w\":766,\"h\":70,\"anchor\":\"top-left-right\",\"hide\":\"false\"}}","name":"Portlet_showmsg","page":"1","sequence":"8","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"766","wireframe_props":"","x":"1","y":"227","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"30","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"default","keep_proportions":"true","layout_steps_values":"{\"320\":{\"x\":271,\"y\":12,\"w\":28,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"340\":{\"x\":287,\"y\":12,\"w\":\"30\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":406,\"y\":12,\"w\":42,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":650,\"y\":12,\"w\":33,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"}}","name":"image_upload","page":"1","path_type":"","sequence":"9","server_side":"","src":"..\u002fimages\u002fupload_ico.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"33","wireframe_props":"","x":"650","y":"12","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"183","y":"-27"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"11","type":"EventReceiver","w":"111","x":"797","y":"-12"}]%>
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
window.pg_import_correzioni_sv_Static=function(){
if(typeof image_upload_Click !='undefined')this.image_upload_Click=image_upload_Click;
if(typeof image_esegui_Click !='undefined')this.image_esegui_Click=image_esegui_Click;
if(typeof splinker_arrt_import_correzioni_sv_Response !='undefined')this.splinker_arrt_import_correzioni_sv_Response=splinker_arrt_import_correzioni_sv_Response;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function image_upload_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');  
  this.RTUpload.Link();
}
function image_esegui_Click(){
  this.Portlet_showlog.Timer0.Start();
  this.Portlet_showmsg.Timer0.Start();
  this.splinker_arrt_import_correzioni_sv.Link();
}
function splinker_arrt_import_correzioni_sv_Response(cMsg){
  alert(cMsg)
  this.Portlet_showlog.Timer0_onTimer();
  this.Portlet_showmsg.Timer0_onTimer();
  this.Portlet_showlog.Timer0.Stop();
  this.Portlet_showmsg.Timer0.Stop();
}
function Aggiorna() {
  this.RTSaveFile.Link();
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
.pg_import_correzioni_sv_container {
}
.pg_import_correzioni_sv_title_container {
  margin: auto;
}
.pg_import_correzioni_sv_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:300px;
  background-color:#FFFFFF;
}
.pg_import_correzioni_sv_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.pg_import_correzioni_sv_portlet[Data-step="320"] {
  height:300px;
  width:100%;
}
.pg_import_correzioni_sv_portlet[Data-step="480"] {
  height:300px;
  width:100%;
}
.pg_import_correzioni_sv_portlet[Data-step="768"] {
  height:300px;
  width:100%;
}
.pg_import_correzioni_sv_portlet[Data-step="320"] > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:7px;
  left:2.1875%;
  right:53px;
  right:16.5625%;
  width:auto;
  height:20px;
}
.pg_import_correzioni_sv_portlet[Data-step="480"] > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:10px;
  left:2.0833333%;
  right:80px;
  right:16.666666%;
  width:auto;
  height:20px;
}
.pg_import_correzioni_sv_portlet[Data-step="768"] > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:14px;
  left:16px;
  left:2.0833333%;
  right:128px;
  right:16.666666%;
  width:auto;
  height:20px;
}
.pg_import_correzioni_sv_portlet > .nomefile_ctrl {
}
.pg_import_correzioni_sv_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_import_correzioni_sv_portlet[Data-step="320"] > .image_esegui_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:230px;
  left:71.875%;
  right:53px;
  right:16.5625%;
  width:auto;
  height:30px;
}
.pg_import_correzioni_sv_portlet[Data-step="480"] > .image_esegui_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:44px;
  left:345px;
  left:71.875%;
  right:80px;
  right:16.666666%;
  width:auto;
  height:30px;
}
.pg_import_correzioni_sv_portlet[Data-step="768"] > .image_esegui_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:11px;
  right:43px;
  width:33px;
  height:30px;
}
.pg_import_correzioni_sv_portlet > .image_esegui_ctrl {
}
.pg_import_correzioni_sv_portlet > .image_esegui_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
}
.pg_import_correzioni_sv_portlet[Data-step="320"] > .Portlet_showlog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:76px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_import_correzioni_sv_portlet[Data-step="480"] > .Portlet_showlog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:76px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_import_correzioni_sv_portlet[Data-step="768"] > .Portlet_showlog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:76px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:150px;
}
.pg_import_correzioni_sv_portlet[Data-step="320"] > .Portlet_showmsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:227px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:70px;
}
.pg_import_correzioni_sv_portlet[Data-step="480"] > .Portlet_showmsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:227px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:70px;
}
.pg_import_correzioni_sv_portlet[Data-step="768"] > .Portlet_showmsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:227px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:70px;
}
.pg_import_correzioni_sv_portlet[Data-step="320"] > .image_upload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:271px;
  left:84.6875%;
  right:21px;
  right:6.5625%;
  width:auto;
  height:30px;
}
.pg_import_correzioni_sv_portlet[Data-step="480"] > .image_upload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:406px;
  left:84.583336%;
  right:32px;
  right:6.6666665%;
  width:auto;
  height:30px;
}
.pg_import_correzioni_sv_portlet[Data-step="768"] > .image_upload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  right:85px;
  width:33px;
  height:30px;
}
.pg_import_correzioni_sv_portlet > .image_upload_ctrl {
}
.pg_import_correzioni_sv_portlet > .image_upload_ctrl > img{
  width:100%;
  vertical-align:top;
  height:auto;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{\"320\":{\"h\":\"300\",\"w\":\"100%\"},\"480\":{\"h\":\"300\",\"w\":\"100%\"},\"768\":{\"h\":\"300\",\"w\":\"100%\"}},\"pages_names\":\"\",\"steps\":\"320,480,768\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"796\",\"y\":\"26\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"261\",\"x\":\"800\",\"y\":\"56\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"947\",\"y\":\"-32\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":260,\"x\":7,\"y\":14},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":390,\"x\":10,\"y\":14},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":624,\"x\":16,\"y\":14}},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"624\",\"x\":\"16\",\"y\":\"14\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"419\",\"y\":\"-11\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":37,\"x\":230,\"y\":44},\"340\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":244,\"y\":44},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":55,\"x\":345,\"y\":44},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":33,\"x\":692,\"y\":11}},\"name\":\"image_esegui\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"33\",\"x\":\"692\",\"y\":\"11\",\"zindex\":\"1\"},{\"anchor\":\"top-left-right\",\"h\":\"150\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":\"318\",\"x\":1,\"y\":76},\"340\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":\"338\",\"x\":1,\"y\":76},\"480\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":\"478\",\"x\":1,\"y\":76},\"768\":{\"anchor\":\"top-left-right\",\"h\":150,\"hide\":\"false\",\"w\":766,\"x\":1,\"y\":76}},\"name\":\"Portlet_showlog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"766\",\"x\":\"1\",\"y\":\"76\",\"zindex\":\"\"},{\"anchor\":\"top-left-right\",\"h\":\"70\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":\"318\",\"x\":1,\"y\":227},\"340\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":\"338\",\"x\":1,\"y\":227},\"480\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":\"478\",\"x\":1,\"y\":227},\"768\":{\"anchor\":\"top-left-right\",\"h\":70,\"hide\":\"false\",\"w\":766,\"x\":1,\"y\":227}},\"name\":\"Portlet_showmsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"766\",\"x\":\"1\",\"y\":\"227\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":28,\"x\":271,\"y\":12},\"340\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":287,\"y\":12},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":42,\"x\":406,\"y\":12},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":33,\"x\":650,\"y\":12}},\"name\":\"image_upload\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"33\",\"x\":\"650\",\"y\":\"12\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"gAzienda\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"183\",\"y\":\"-27\"},{\"h\":\"30\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"797\",\"y\":\"-12\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_import_correzioni_sv","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_import_correzioni_sv_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_import_correzioni_sv','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String dir= "";
String nomefile= "";
if(request.getAttribute("pg_import_correzioni_sv_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String gAzienda=sp.getGlobal("gAzienda","");
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_import_correzioni_sv_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_import_correzioni_sv_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_import_correzioni_sv','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<div id='<%=idPortlet%>_image_esegui'>
<img id='<%=idPortlet%>_image_esegui_img' class='image image_esegui_ctrl' src="../images/elaborazione.gif" >
</div>
<div id='<%=idPortlet%>_Portlet_showlog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_8jw6v6",false);%></div>
<div id='<%=idPortlet%>_Portlet_showmsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_8jw7pb",false);%></div>
<div id='<%=idPortlet%>_image_upload'>
<img id='<%=idPortlet%>_image_upload_img' class='image image_upload_ctrl' src="../images/upload_ico.gif" >
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_import_correzioni_sv');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_import_correzioni_sv',["768"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','','',{"320":{"h":"300","w":"100%"},"480":{"h":"300","w":"100%"},"768":{"h":"300","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"300"},"768":{"w":"100%","h":"300"},"480":{"w":"100%","h":"300"}},"w":"768","h":"300","title":"","layer":"false","npage":"1"}]);
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.splinker_arrt_import_correzioni_sv=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_arrt_import_correzioni_sv","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_arrt_import_correzioni_sv","offline":false,"page":1,"parms":"nomefile=nomefile","popup":"true","popup_height":"300","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"400","progressbar":false,"refresh":"","servlet":"arrt_import_correzioni_sv","target":"","type":"SPLinker","w":261,"x":800,"y":56});
this.splinker_arrt_import_correzioni_sv.m_cID='<%=JSPLib.cmdHash("routine,arrt_import_correzioni_sv",request.getSession())%>';
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=S","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":120,"x":947,"y":-32});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file",request.getSession())%>';
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":20,"hide":"false","w":260,"x":7,"y":14},"480":{"anchor":" ","h":20,"hide":"false","w":390,"x":10,"y":14},"768":{"anchor":"","h":20,"hide":"false","w":624,"x":16,"y":14}},"maxlength":"","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":624,"x":16,"y":14,"zerofilling":false,"zindex":"1","zoom":""});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":120,"x":419,"y":-11});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.image_esegui=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_esegui_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_esegui","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":30,"hide":"false","w":37,"x":230,"y":44},"340":{"anchor":" ","h":30,"hide":"false","w":"40","x":244,"y":44},"480":{"anchor":" ","h":30,"hide":"false","w":55,"x":345,"y":44},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":33,"x":692,"y":11}},"name":"image_esegui","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":33,"x":692,"y":11,"zindex":"1"});
if(this.Portlet_showlog=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet_showlog')){
this.Portlet_showlog.setContainer(this,'Portlet_showlog')
this.Portlet_showlog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet_showlog","h":150,"hide":"false","layer":false,"layout_steps_values":{"320":{"anchor":"top-left-right","h":150,"hide":"false","w":"318","x":1,"y":76},"340":{"anchor":"top-left-right","h":150,"hide":"false","w":"338","x":1,"y":76},"480":{"anchor":"top-left-right","h":150,"hide":"false","w":"478","x":1,"y":76},"768":{"anchor":"top-left-right","h":150,"hide":"false","w":766,"x":1,"y":76}},"name":"Portlet_showlog","page":1,"portlet_id":"<%=idPortlet%>_8jw6v6","type":"Portlet","w":766,"x":1,"y":76,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_Portlet_showlog').style.display='none';
}
if(this.Portlet_showmsg=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet_showmsg')){
this.Portlet_showmsg.setContainer(this,'Portlet_showmsg')
this.Portlet_showmsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_Portlet_showmsg","h":70,"hide":"false","layer":false,"layout_steps_values":{"320":{"anchor":"top-left-right","h":70,"hide":"false","w":"318","x":1,"y":227},"340":{"anchor":"top-left-right","h":70,"hide":"false","w":"338","x":1,"y":227},"480":{"anchor":"top-left-right","h":70,"hide":"false","w":"478","x":1,"y":227},"768":{"anchor":"top-left-right","h":70,"hide":"false","w":766,"x":1,"y":227}},"name":"Portlet_showmsg","page":1,"portlet_id":"<%=idPortlet%>_8jw7pb","type":"Portlet","w":766,"x":1,"y":227,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_Portlet_showmsg').style.display='none';
}
this.image_upload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image image_upload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image_upload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":30,"hide":"false","w":28,"x":271,"y":12},"340":{"anchor":" ","h":30,"hide":"false","w":"30","x":287,"y":12},"480":{"anchor":" ","h":30,"hide":"false","w":42,"x":406,"y":12},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":33,"x":650,"y":12}},"name":"image_upload","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fupload_ico.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":33,"x":650,"y":12,"zindex":"1"});
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":797,"y":-12});
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
<%if(request.getAttribute("pg_import_correzioni_sv_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_import_correzioni_sv_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_import_correzioni_sv_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_import_correzioni_sv',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_import_correzioni_sv');
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
sp.endPage("pg_import_correzioni_sv");
}%>
<%! public String getJSPUID() { return "2832363696"; } %>