<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.RTClean.Link();\n  this.getTitlePortlet().SetTitle(\"Calcolo Saldi Operazioni Extraconto\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n  this.cValuta.Value('242')\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'elaborazione dei dati?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()      \n  alert(\"Elaborazione Completata!\");\n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}\n\nfunction btnPrint_Click(){\n  this.RTPrint.Link()  \n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Calcolo Saldi Operazioni Extraconto","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"550","hsl":"false","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"arfn_finemese.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"1","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"725","y":"9","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"2","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"9","zindex":"1"},{"async":"false","entity_type":"","h":"30","m_cAction":"","m_cAltInterface":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"63","x":"3","y":"-67"},{"async":"true","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"RTExec","offline":"false","page":"1","parms":"w_annorif=anno,w_valuta=cValuta,w_flgazz=flgazzera","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"arrt_calcsaldi_opex_wu","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"anchor":"","h":"128","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"5","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"83","zindex":""},{"anchor":"","h":"63","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"6","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"212","zindex":""},{"anchor":"top-left","autocapitalize":"on","autofocus":"","calculate":"Year(Date()) - 1","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","tabindex":"","type":"Textbox","typevar":"numeric","visible":"true","w":"53","wireframe_props":"name","x":"153","y":"9","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"22","y":"10","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"RTClean","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"82","x":"154","y":"-65"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","edit_undercond":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Azzera Saldi Precedenti (Solo se operazione di ricalcolo)","layout_steps_values":"{}","name":"flgazzera","page":"1","sequence":"10","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"408","wireframe_props":"label_text","x":"22","y":"48","zindex":"4"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa gli errori rilevati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnPrint","page":"1","path_type":"","sequence":"11","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"688","y":"10","zindex":"1"},{"async":"false","entity_type":"","h":"20","m_cAction":"","m_cAltInterface":"","name":"RTSearch","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":"80","x":"245","y":"-63"},{"async":"false","entity_type":"report","h":"20","m_cAction":"start","m_cAltInterface":"","name":"RTPrint","offline":"false","page":"1","parms":"ReportName=arrp_saldi_opex_r,w_annorif=anno,rotation=LANDSCAPE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":"74","x":"334","y":"-61"},{"anchor":"top-left-right","auto_resize":"false","border":"","default_portlet":"","h":"199","hide":"false","layout_steps_values":"{}","name":"iPrint","page":"1","sequence":"14","type":"Iframe","w":"793","wireframe_props":"","x":"3","y":"279","zindex":"9"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"start","m_cAltInterface":"","name":"RTDown","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":"78","x":"412","y":"-63"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"SQLValute","disabled":"false","edit_undercond":"","empty_value":"false","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","name":"cValuta","page":"1","picture":"","sequence":"16","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":"true","w":"296","wireframe_props":"name,textlist","x":"367","y":"9","zindex":"10"},{"appendingData":"false","auto_exec":"true","count":"false","h":"20","localDBName":"","n_records":"500","name":"SQLValute","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_tbvalute","query_async":"false","return_fields_type":"true","sequence":"17","type":"SQLDataobj","w":"120","x":"554","y":"-62"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label31","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"18","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Valuta Prevalente:","w":"146","wireframe_props":"align,value,n_col","x":"217","y":"9","zindex":"12"}]%>
<%/*Description:Calcolo Saldi Operazioni Extraconto*/%>
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
window.pg_calcsaldi_opex_wu_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof btnPrint_Click !='undefined')this.btnPrint_Click=btnPrint_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(Year(SystemDate())-1,this.anno);
ZtVWeb.InitCtrl('S',this.flgazzera);
this.SQLValute.addRowConsumer(this.cValuta);
function this_Loaded(){
  this.RTClean.Link();
  this.getTitlePortlet().SetTitle("Calcolo Saldi Operazioni Extraconto",true)
  this.getTitlePortlet().SetSubTitle("",true)
  this.cValuta.Value('242')
}
function btnElab_Click(){
  if (confirm("Confermi l'elaborazione dei dati?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTExec.Link();  
  }  
}
function RTExec_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop()      
  alert("Elaborazione Completata!");
}
function btnExit_Click(){ 
  this.RTEsci.Link();
}
function btnPrint_Click(){
  this.RTPrint.Link()  
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
.pg_calcsaldi_opex_wu_container {
}
.pg_calcsaldi_opex_wu_title_container {
  margin: auto;
}
.pg_calcsaldi_opex_wu_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:550px;
}
.pg_calcsaldi_opex_wu_portlet[Data-page="1"]{
  height:550px;
  width:100%;
}
.pg_calcsaldi_opex_wu_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  right:45px;
  width:30px;
  height:30px;
}
.pg_calcsaldi_opex_wu_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_calcsaldi_opex_wu_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_calcsaldi_opex_wu_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_calcsaldi_opex_wu_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:83px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:128px;
}
.pg_calcsaldi_opex_wu_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:212px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:63px;
}
.pg_calcsaldi_opex_wu_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:153px;
  width:53px;
  height:20px;
}
.pg_calcsaldi_opex_wu_portlet > .anno_ctrl {
}
.pg_calcsaldi_opex_wu_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_calcsaldi_opex_wu_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:22px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_calcsaldi_opex_wu_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_calcsaldi_opex_wu_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-weight:normal;
  text-align:right;
  background-color:transparent;
}
.pg_calcsaldi_opex_wu_portlet > .flgazzera_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:48px;
  left:22px;
  width:408px;
  height:20px;
}
.pg_calcsaldi_opex_wu_portlet > .btnPrint_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:82px;
  width:30px;
  height:30px;
}
.pg_calcsaldi_opex_wu_portlet > .btnPrint_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_calcsaldi_opex_wu_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:279px;
  left:3px;
  right:4px;
  width:auto;
  height:199px;
}
.pg_calcsaldi_opex_wu_portlet > .cValuta_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:9px;
  left:367px;
  left:45.875%;
  right:137px;
  right:17.125%;
  width:auto;
  height:20px;
}
.pg_calcsaldi_opex_wu_portlet > .Label31_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:9px;
  left:217px;
  left:27.125%;
  right:437px;
  right:54.625%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_calcsaldi_opex_wu_portlet > .Label31_ctrl {
  height:auto;
  min-height:20px;
}
.pg_calcsaldi_opex_wu_portlet > .Label31_ctrl {
  overflow:hidden;
  text-align:right;
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
 String def="[{\"h\":\"550\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"725\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"9\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"63\",\"x\":\"3\",\"y\":\"-67\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"128\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"83\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"63\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"212\",\"zindex\":\"\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"153\",\"y\":\"9\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"22\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTClean\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"82\",\"x\":\"154\",\"y\":\"-65\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Azzera Saldi Precedenti (Solo se operazione di ricalcolo)\",\"layout_steps_values\":{},\"name\":\"flgazzera\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"408\",\"x\":\"22\",\"y\":\"48\",\"zindex\":\"4\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnPrint\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"688\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTSearch\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"80\",\"x\":\"245\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"RTPrint\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"74\",\"x\":\"334\",\"y\":\"-61\"},{\"anchor\":\"top-left-right\",\"h\":\"199\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"793\",\"x\":\"3\",\"y\":\"279\",\"zindex\":\"9\"},{\"h\":\"20\",\"name\":\"RTDown\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"78\",\"x\":\"412\",\"y\":\"-63\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cValuta\",\"page\":\"1\",\"textlist\":\"DESCRI\",\"type\":\"Combobox\",\"w\":\"296\",\"x\":\"367\",\"y\":\"9\",\"zindex\":\"10\"},{\"h\":\"20\",\"name\":\"SQLValute\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"554\",\"y\":\"-62\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label31\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Valuta Prevalente:\",\"w\":\"146\",\"x\":\"217\",\"y\":\"9\",\"zindex\":\"12\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_calcsaldi_opex_wu","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_calcsaldi_opex_wu_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("arfn_finemese.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_calcsaldi_opex_wu','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%double anno= 0;
if(request.getAttribute("pg_calcsaldi_opex_wu_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String flgazzera="N";
String cValuta= "";
String Label31= "Valuta Prevalente:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_calcsaldi_opex_wu_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_calcsaldi_opex_wu_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_calcsaldi_opex_wu_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_calcsaldi_opex_wu','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' inputmode='numeric' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<div id='<%=idPortlet%>_flgazzera_div' style=''><input id='<%=idPortlet%>_flgazzera' name='flgazzera' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_flgazzera' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Azzera Saldi Precedenti (Solo se operazione di ricalcolo)")%></label></div>
<a id='<%=idPortlet%>_btnPrint' class='image btnPrint_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
<select id='<%=idPortlet%>_cValuta' name='cValuta' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label31'  formid='<%=idPortlet%>' ps-name='Label31'    class='label Label31_ctrl'><div id='<%=idPortlet%>_Label31tbl' style='width:100%;'><%=JSPLib.ToHTML("Valuta Prevalente:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_calcsaldi_opex_wu');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_calcsaldi_opex_wu',["800"],["550"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"550","title":"","layer":"false","npage":"1"}]);
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":725,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":63,"x":3,"y":-67});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_annorif=anno,w_valuta=cValuta,w_flgazz=flgazzera","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_calcsaldi_opex_wu","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_calcsaldi_opex_wu",request.getSession())%>';
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":128,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","type":"Portlet","w":793,"x":3,"y":83,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":63,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":793,"x":3,"y":212,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"Year(SystemDate())-1","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=anno%>","w":53,"x":153,"y":9,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":22,"y":10,"zindex":"1"});
this.RTClean=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTClean","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTClean","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":82,"x":154,"y":-65});
this.RTClean.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.flgazzera=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_flgazzera","decrypt":false,"edit_undercond":"","encrypt":false,"h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"Azzera Saldi Precedenti (Solo se operazione di ricalcolo)","layer":false,"layout_steps_values":{},"name":"flgazzera","page":1,"reactive":false,"server_side":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":408,"x":22,"y":48,"zindex":"4"});
this.flgazzera.Value('<%=flgazzera%>');
this.btnPrint=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnPrint_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnPrint","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa gli errori rilevati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnPrint","page":1,"path_type":"","server_side":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":688,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTSearch=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSearch","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSearch","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":80,"x":245,"y":-63});
this.RTSearch.m_cID='<%=JSPLib.cmdHash("entity,list_filesid_portlet.jsp",request.getSession())%>';
this.RTPrint=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPrint","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPrint","offline":false,"page":1,"parms":"ReportName=arrp_saldi_opex_r,w_annorif=anno,rotation=LANDSCAPE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famprino_stp","target":"iPrint","type":"SPLinker","w":74,"x":334,"y":-61});
this.RTPrint.m_cID='<%=JSPLib.cmdHash("entity,arrt_famprino_stp",request.getSession())%>';
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left-right","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":199,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"type":"Iframe","w":793,"x":3,"y":279,"zindex":"9"});
this.RTDown=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDown","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDown","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_famgetdgn","target":"","type":"SPLinker","w":78,"x":412,"y":-63});
this.RTDown.m_cID='<%=JSPLib.cmdHash("routine,arrt_famgetdgn",request.getSession())%>';
this.cValuta=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cValuta","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cValuta%>","isdatap":true,"layer":false,"layout_steps_values":{},"name":"cValuta","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","textlist":"DESCRI","type":"Combobox","typevar":"character","valuelist":"CODVAL","visible":true,"w":296,"x":367,"y":9,"zindex":"10"});
this.SQLValute=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_tbvalute","cmdHash":"<%=JSPLib.cmdHash("qbe_tbvalute",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLValute","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLValute","nrows":"500","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":554,"y":-62});
this.Label31=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label31","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label31","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label31,false,true)%>","type":"Label","w":146,"x":217,"y":9,"zindex":"12"});
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
<%if(request.getAttribute("pg_calcsaldi_opex_wu_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_calcsaldi_opex_wu_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_calcsaldi_opex_wu_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnPrint.dispatchEvent('OnLoad');
window.<%=idPortlet%>.SQLValute.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_calcsaldi_opex_wu',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_calcsaldi_opex_wu');
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
sp.endPage("pg_calcsaldi_opex_wu");
}%>
<%! public String getJSPUID() { return "3018792718"; } %>