<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.anno.Value(this.RTInit.Link());\n  this.cartella.Value(\"export\");\n  this.RTClean.Link();\n  this.getTitlePortlet().SetTitle(\"ESTRAZIONE DATI PER SV\",true)\n  this.btnDownload.Hide()\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()      \n  if(result=='KO') {\n    alert(\"Elaborazione Abortita. Contattare l'assistenza\");\n  } else {\n    alert(\"Elaborazione Completata. Prelevare il file con il bottone\");\n    this.filename.Value(result);\n    this.btnDownload.Show()\n  }  \n}\n\n\nfunction btnDownload_Click(){\n  if (confirm(\"Confermi il prelievo del file?\")) {    \n    this.RTDownload.Link();    \n  }  \n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}\n\nfunction btnCheck_Click(){\n  if (confirm(\"Confermi l'estrazione delle operazioni errate?\")) {\n    this.RTCheck.Link()\n  }  \n}\n\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Estrazione Movimenti (Operazioni\u002fFrazionate)","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"false","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Filtri Base, Filtri Aggiuntivi","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva il file generato","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnDownload","page":"1","path_type":"","sequence":"1","server_side":"","src":"..\u002fimages\u002fsave.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"646","y":"6","zindex":"1"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"","disabled":"false","edit_undercond":"","empty_value":"false","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"2","layout_steps_values":"{}","name":"flgsegno","page":"1","picture":"","sequence":"2","tabindex":"","textlist":"Segno Avere = SEND,Segno Dare = SEND","type":"Combobox","typevar":"character","valuelist":"1,2","visible":"true","w":"212","wireframe_props":"name,textlist","x":"304","y":"34","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"3","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"725","y":"6","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"4","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"6","zindex":"1"},{"async":"false","entity_type":"","h":"30","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"233","x":"817","y":"-91"},{"async":"true","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre,pSegno=flgsegno","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"arfn_estrai_sv","target":"","type":"SPLinker","w":"228","x":"815","y":"-57"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"pFile=filename,pCartella=cartella,pTipo=ZIP,pDir=A","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":"219","x":"818","y":"-16"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"cartella","page":"1","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"499","y":"-61"},{"anchor":"","h":"128","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"9","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"62","zindex":""},{"anchor":"","h":"63","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"10","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"191","zindex":""},{"anchor":"top-left","autocapitalize":"on","autofocus":"","calculate":"Year(Date())","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layout_steps_values":"{}","maxlength":"","name":"anno","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"11","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"53","wireframe_props":"name","x":"141","y":"8","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblAnno","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Anno di riferimento:","w":"129","wireframe_props":"align,value,n_col","x":"10","y":"13","zindex":"1"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"","disabled":"false","edit_undercond":"","empty_value":"true","font":"Verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","name":"trimestre","page":"1","picture":"","sequence":"13","tabindex":"","textlist":"I Trimestre,II Trimestre,III Trimestre,IV Trimestre","type":"Combobox","typevar":"character","valuelist":"1,2,3,4","visible":"true","w":"212","wireframe_props":"name,textlist","x":"304","y":"8","zindex":"1"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblTri","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Trimestre:","w":"69","wireframe_props":"align,value,n_col","x":"236","y":"13","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"filename","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"15","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"149","wireframe_props":"name","x":"297","y":"-64","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","name":"RTClean","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"30","x":"148","y":"-67"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","name":"RTInit","offline":"false","page":"1","parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"17","servlet":"arfn_initdate","target":"","type":"SPLinker","w":"30","x":"195","y":"-67"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Effettua il controllo dei dati","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnCheck","page":"1","path_type":"","sequence":"18","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"685","y":"6","zindex":"0"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"start","name":"RTCheck","offline":"false","page":"1","parms":"pAnno=anno,pTri=trimestre","popup":"true","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":"","refresh":"","sequence":"19","servlet":"arrt_estrai_sv_check","target":"","type":"SPLinker","w":"30","x":"239","y":"-67"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label38_Copy_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Tipo Segno:","w":"111","wireframe_props":"align,value,n_col","x":"194","y":"38","zindex":"1"}]%>
<%/*Description:Estrazione Movimenti (Operazioni/Frazionate)*/%>
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
window.pg_estrai_sv_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnDownload_Click !='undefined')this.btnDownload_Click=btnDownload_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof btnCheck_Click !='undefined')this.btnCheck_Click=btnCheck_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(Year(SystemDate()),this.anno);
function this_Loaded(){
  this.anno.Value(this.RTInit.Link());
  this.cartella.Value("export");
  this.RTClean.Link();
  this.getTitlePortlet().SetTitle("ESTRAZIONE DATI PER SV",true)
  this.btnDownload.Hide()
}
function btnElab_Click(){
  if (confirm("Confermi l'estrazione dei dati?")) {
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
  if(result=='KO') {
    alert("Elaborazione Abortita. Contattare l'assistenza");
  } else {
    alert("Elaborazione Completata. Prelevare il file con il bottone");
    this.filename.Value(result);
    this.btnDownload.Show()
  }  
}
function btnDownload_Click(){
  if (confirm("Confermi il prelievo del file?")) {    
    this.RTDownload.Link();    
  }  
}
function btnExit_Click(){ 
  this.RTEsci.Link();
}
function btnCheck_Click(){
  if (confirm("Confermi l'estrazione delle operazioni errate?")) {
    this.RTCheck.Link()
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
.pg_estrai_sv_container {
}
.pg_estrai_sv_title_container {
  margin: auto;
}
.pg_estrai_sv_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:300px;
}
.pg_estrai_sv_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.pg_estrai_sv_portlet > .btnDownload_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  right:124px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_portlet > .btnDownload_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_portlet > .flgsegno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:304px;
  width:212px;
  height:20px;
}
.pg_estrai_sv_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  right:45px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:62px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:128px;
}
.pg_estrai_sv_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:191px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:63px;
}
.pg_estrai_sv_portlet > .anno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:141px;
  width:53px;
  height:20px;
}
.pg_estrai_sv_portlet > .anno_ctrl {
}
.pg_estrai_sv_portlet > .anno_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_portlet > .lblAnno_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:10px;
  width:129px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_portlet > .lblAnno_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_portlet > .lblAnno_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_portlet > .trimestre_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:8px;
  left:304px;
  width:212px;
  height:20px;
}
.pg_estrai_sv_portlet > .lblTri_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:236px;
  width:69px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_portlet > .lblTri_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_portlet > .lblTri_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_estrai_sv_portlet > .filename_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:800px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_estrai_sv_portlet > .filename_ctrl {
  display:none;
}
.pg_estrai_sv_portlet > .filename_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_estrai_sv_portlet > .btnCheck_ctrl {
  box-sizing:border-box;
  z-index:0;
  position:absolute;
  display:inline-block;
  top:6px;
  right:85px;
  width:30px;
  height:30px;
}
.pg_estrai_sv_portlet > .btnCheck_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_estrai_sv_portlet > .label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:38px;
  left:194px;
  width:111px;
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_portlet > .label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_estrai_sv_portlet > .label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"Filtri Base, Filtri Aggiuntivi\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"646\",\"y\":\"6\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"flgsegno\",\"page\":\"1\",\"textlist\":\"Segno Avere = SEND,Segno Dare = SEND\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"304\",\"y\":\"34\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"725\",\"y\":\"6\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"6\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTEsci\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"233\",\"x\":\"817\",\"y\":\"-91\"},{\"h\":\"30\",\"name\":\"RTExec\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"228\",\"x\":\"815\",\"y\":\"-57\"},{\"h\":\"30\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"219\",\"x\":\"818\",\"y\":\"-16\"},{\"h\":\"20\",\"name\":\"cartella\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"499\",\"y\":\"-61\"},{\"anchor\":\"\",\"h\":\"128\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"62\",\"zindex\":\"\"},{\"anchor\":\"\",\"h\":\"63\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"191\",\"zindex\":\"\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"anno\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"53\",\"x\":\"141\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblAnno\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anno di riferimento:\",\"w\":\"129\",\"x\":\"10\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"trimestre\",\"page\":\"1\",\"textlist\":\"I Trimestre,II Trimestre,III Trimestre,IV Trimestre\",\"type\":\"Combobox\",\"w\":\"212\",\"x\":\"304\",\"y\":\"8\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTri\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Trimestre:\",\"w\":\"69\",\"x\":\"236\",\"y\":\"13\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"filename\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"149\",\"x\":\"297\",\"y\":\"-64\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTClean\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"148\",\"y\":\"-67\"},{\"h\":\"30\",\"name\":\"RTInit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"195\",\"y\":\"-67\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnCheck\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"685\",\"y\":\"6\",\"zindex\":\"0\"},{\"h\":\"30\",\"name\":\"RTCheck\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"239\",\"y\":\"-67\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label38_Copy_Copy_Copy_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Segno:\",\"w\":\"111\",\"x\":\"194\",\"y\":\"38\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_estrai_sv","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_estrai_sv_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_estrai_sv','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String flgsegno="2";
String cartella= "";
String anno= "";
if(request.getAttribute("pg_estrai_sv_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String lblAnno= "Anno di riferimento:";
String trimestre= "";
String lblTri= "Trimestre:";
String filename= "";
String label38_Copy_Copy_Copy_Copy_Copy_Copy= "Tipo Segno:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_estrai_sv_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_estrai_sv_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_estrai_sv_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_estrai_sv','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnDownload' class='image btnDownload_ctrl'   target=''>&#xebbd;</a>
<select id='<%=idPortlet%>_flgsegno' name='flgsegno' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span class='textbox-container'id='<%=idPortlet%>_anno_wrp'><input id='<%=idPortlet%>_anno' name='anno' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='anno' /></span>
<span id='<%=idPortlet%>_lblAnno'  formid='<%=idPortlet%>' ps-name='lblAnno'    class='label lblAnno_ctrl'><div id='<%=idPortlet%>_lblAnnotbl' style='width:100%;'><%=JSPLib.ToHTML("Anno di riferimento:")%></div></span>
<select id='<%=idPortlet%>_trimestre' name='trimestre' class='combobox' style='font-family:Verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_lblTri'  formid='<%=idPortlet%>' ps-name='lblTri'    class='label lblTri_ctrl'><div id='<%=idPortlet%>_lblTritbl' style='width:100%;'><%=JSPLib.ToHTML("Trimestre:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_filename_wrp'><input id='<%=idPortlet%>_filename' name='filename' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='filename' /></span>
<a id='<%=idPortlet%>_btnCheck' class='image btnCheck_ctrl'   target=''>&#xe96e;</a>
<span id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label38_Copy_Copy_Copy_Copy_Copy_Copy'    class='label label38_Copy_Copy_Copy_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Segno:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_estrai_sv');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_estrai_sv',["800"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"300","title":"Filtri Base","layer":"false","npage":"1"}]);
this.btnDownload=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDownload_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDownload","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva il file generato",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDownload","page":1,"path_type":"","server_side":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":646,"y":6,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.flgsegno=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_flgsegno","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=flgsegno%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"flgsegno","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","textlist":"Segno Avere = SEND,Segno Dare = SEND","type":"Combobox","typevar":"character","valuelist":"1,2","visible":true,"w":212,"x":304,"y":34,"zindex":"1"});
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":725,"y":6,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":6,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":233,"x":817,"y":-91});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre,pSegno=flgsegno","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_estrai_sv","target":"","type":"SPLinker","w":228,"x":815,"y":-57});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arfn_estrai_sv",request.getSession())%>';
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"pFile=filename,pCartella=cartella,pTipo=ZIP,pDir=A","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadfile","target":"","type":"SPLinker","w":219,"x":818,"y":-16});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadfile",request.getSession())%>';
this.cartella=new ZtVWeb._VC(this,'cartella',null,'character','<%=JSPLib.ToJSValue(cartella,false,true)%>',false,false);
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":128,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","type":"Portlet","w":793,"x":3,"y":62,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":63,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":793,"x":3,"y":191,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.anno=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"Year(SystemDate())","create_undercond":"","ctrlid":"<%=idPortlet%>_anno","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"anno","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(anno,false,true)%>","w":53,"x":141,"y":8,"zerofilling":false,"zindex":"1","zoom":""});
this.lblAnno=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblAnno","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblAnno","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblAnno,false,true)%>","type":"Label","w":129,"x":10,"y":13,"zindex":"1"});
this.trimestre=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_trimestre","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"font":"Verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=trimestre%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"trimestre","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","textlist":"I Trimestre,II Trimestre,III Trimestre,IV Trimestre","type":"Combobox","typevar":"character","valuelist":"1,2,3,4","visible":true,"w":212,"x":304,"y":8,"zindex":"1"});
this.lblTri=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTri","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTri","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblTri,false,true)%>","type":"Label","w":69,"x":236,"y":13,"zindex":"1"});
this.filename=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_filename","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"filename","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(filename,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.RTClean=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTClean","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTClean","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":30,"x":148,"y":-67});
this.RTClean.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.RTInit=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTInit","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTInit","offline":false,"page":1,"parms":"pTipo=Y","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_initdate","target":"","type":"SPLinker","w":30,"x":195,"y":-67});
this.RTInit.m_cID='<%=JSPLib.cmdHash("routine,arfn_initdate",request.getSession())%>';
this.btnCheck=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnCheck_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCheck","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96e;","font_image_hover":"&#xe96f;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Effettua il controllo dei dati",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnCheck","page":1,"path_type":"","server_side":"","src":"&#xe96e;","srchover":"&#xe96f;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":685,"y":6,"zindex":"0"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTCheck=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCheck","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCheck","offline":false,"page":1,"parms":"pAnno=anno,pTri=trimestre","popup":"true","popup_height":"250","popup_maximized":"false","popup_scroll":"false","popup_style":"popup","popup_width":"900","progressbar":false,"refresh":"","servlet":"arrt_estrai_sv_check","target":"","type":"SPLinker","w":30,"x":239,"y":-67});
this.RTCheck.m_cID='<%=JSPLib.cmdHash("routine,arrt_estrai_sv_check",request.getSession())%>';
this.label38_Copy_Copy_Copy_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label38_Copy_Copy_Copy_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label38_Copy_Copy_Copy_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label38_Copy_Copy_Copy_Copy_Copy_Copy,false,true)%>","type":"Label","w":111,"x":194,"y":38,"zindex":"1"});
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
<%if(request.getAttribute("pg_estrai_sv_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_estrai_sv_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_estrai_sv_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnDownload.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnCheck.dispatchEvent('OnLoad');
window.<%=idPortlet%>.flgsegno.FillData();
window.<%=idPortlet%>.trimestre.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_estrai_sv',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_estrai_sv');
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
sp.endPage("pg_estrai_sv");
}%>
<%! public String getJSPUID() { return "807297224"; } %>