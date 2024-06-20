<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Import dati da Scarico OFF-Line',true);\n  this.RTAzzera.Link();\n\u002f\u002f   this.getTitlePortlet().AppendButton({\n\u002f\u002f     id:\"Esegui\",\n\u002f\u002f     title:FormatMsg('Import File'),\n\u002f\u002f     tooltip:FormatMsg('Importa il file 380'),\n\u002f\u002f     image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n\u002f\u002f     action:'javascript:' + this.formid +'.Import()'\n\u002f\u002f   },1); \n  this.getTitlePortlet().AppendButton({\n    id:\"EseguiFN\",\n    title:FormatMsg('Import File'),\n    tooltip:FormatMsg('Importa il file 380'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb47;\"},\n    action:'javascript:' + this.formid +'.ImportFN()'\n  },2); \n}\nfunction image5_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction ImportFN(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.PortletLogs.Start();\n    this.RTEseguiFN.Link();\n  }    \n}\n\nfunction Import(){\n  if (confirm(\"Confermi l'elaborazione del file?\")) {\n    this.PortletLogs.Start();\n    this.RTEsegui.Link();\n  }    \n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n}  \n\nfunction RTEsegui_Result(result){\n  this.PortletLogs.Stop();\n  alert(\"Elaborazione Terminata\");\n}\n\nfunction RTEseguiFN_Result(result){\n  this.PortletLogs.Stop();\n  alert(\"Elaborazione Terminata\");\n}\n\nfunction btnDown_Click(){\n  this.RTDownload.Link();\n}\n","adaptive":"fixed","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @nomefile }}{{ @label1 }}{{ @image5 }}{{ @pLog }}{{ @pMsg }}{{ @Label14 }}{{ @Label14_Copy }}{{ @cmbDest }}{{ @label1_Copy }}{{ @chkAzzera }}{{ @chkAnag }}{{ @iPrint }}{{ @nomefile }}{{ @label1 }}{{ @image5 }}{{ @Label14 }}{{ @Label14_Copy }}{{ @cmbDest }}{{ @label1_Copy }}{{ @chkAzzera }}{{ @chkAnag }}{{ @iPrint }}{{ @PortletLogs }}\u003c\u002fbody\u003e","grapesCss":"","h":"200","hsl":"","htmlcode":"{{ @PortletLogs }} \n{{ @iPrint }}\n{{ @chkAnag }}\n\n\n{{ @chkAzzera }}\n{{ @label1_Copy }}\n{{ @cmbDest }}\n{{ @Label14_Copy }}\n{{ @Label14 }}\n\n\n{{ @image5 }}\n\n\n{{ @label1 }}\n{{ @nomefile }}\n","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"200\",\"w\":\"850\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"850","wizard":""},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"true","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"737","wireframe_props":"name","x":"84","y":"48","zerofilling":"false","zindex":"1","zone":"","zoom":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"80","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"850","wireframe_props":"","x":"0","y":"115","zindex":"3","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Nome File:","w":"72","wireframe_props":"align,value,n_col","x":"8","y":"49","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"3","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"115","x":"110","y":"-70"},{"allowedentities":"arrt_imp_offline","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"RTEsegui","offline":"false","page":"1","parms":"w_nomefile=nomefile,w_tipodest=cmbDest,w_azzera=chkAzzera,w_tipoimp=cmbTipo,w_flgrae=A,w_soloanag=chkAnag","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"arrt_imp_offline","target":"iPrint","type":"SPLinker","w":"83","x":"2","y":"-62"},{"alt":"","anchor":"top-left","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"image5","page":"1","path_type":"","rapp":"","sequence":"5","server_side":"","spuid":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"827","y":"48","zindex":"1","zone":""},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","ctrlOfVariant":"","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"8","type":"EventReceiver","w":"111","x":"240","y":"-68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"772","y":"-60"},{"allowedentities":"arfn_upload_file","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":"120","x":"502","y":"-57"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"11","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"121","x":"636","y":"-60"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"363","y":"-59"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Questa procedura è in grado di ricostruire l'Archivio Unico Informatico importando i dati","w":"851","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"4","zone":""},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label14_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"dallo Scarico Sequenziale (Off-line) nel formato definito dall'Ufficio Indagini Finanziarie (UIF ex UIC).","w":"851","wireframe_props":"align,value,n_col","x":"0","y":"21","zindex":"4","zone":""},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"true","field":"","fixed":"","font":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"D","layer":"false","layout_steps_values":"{}","name":"cmbDest","page":"1","picture":"","rapp":"","sequence":"15","spuid":"","tabindex":"","textlist":"Definitivo,Provvisorio","type":"Combobox","typevar":"character","valuelist":"D,P","visible":"true","w":"129","wireframe_props":"name,textlist","x":"84","y":"81","zindex":"5","zone":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label1_Copy","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Destinazione:","w":"72","wireframe_props":"align,value,n_col","x":"8","y":"83","zindex":"1","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Importazione ripartendo da Archivi MIT Vuoti","layer":"false","layout_steps_values":"{}","name":"chkAzzera","page":"1","rapp":"","sequence":"17","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"329","wireframe_props":"label_text","x":"246","y":"81","zindex":"6","zone":""},{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Importa solo dati anagrafici","layer":"false","layout_steps_values":"{}","name":"chkAnag","page":"1","rapp":"","sequence":"18","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"236","wireframe_props":"label_text","x":"611","y":"81","zindex":"7","zone":""},{"anchor":"","auto_resize":"false","border":"","ctrlOfVariant":"","default_portlet":"","fixed":"","h":"1","hide":"false","layer":"false","layout_steps_values":"{}","name":"iPrint","page":"1","rapp":"","sequence":"19","spuid":"","type":"Iframe","w":"1","wireframe_props":"","x":"671","y":"116","zindex":"8","zone":""},{"allowedentities":"arfn_imp_offline","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTEseguiFN","offline":"false","page":"1","parms":"w_nomefile=nomefile,w_tipodest=cmbDest,w_azzera=chkAzzera,w_soloanag=chkAnag","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"20","servlet":"arfn_imp_offline","target":"iPrint","type":"SPLinker","w":"83","x":"954","y":"-76"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"S","name":"cmbTipo","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"926","y":"-12"}]%>
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
window.pg_imp_offline_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof image5_Click !='undefined')this.image5_Click=image5_Click;
if(typeof ImportFN !='undefined')this.ImportFN=ImportFN;
if(typeof Import !='undefined')this.Import=Import;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof RTEsegui_Result !='undefined')this.RTEsegui_Result=RTEsegui_Result;
if(typeof RTEseguiFN_Result !='undefined')this.RTEseguiFN_Result=RTEseguiFN_Result;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Import dati da Scarico OFF-Line',true);
  this.RTAzzera.Link();
//   this.getTitlePortlet().AppendButton({
//     id:"Esegui",
//     title:FormatMsg('Import File'),
//     tooltip:FormatMsg('Importa il file 380'),
//     image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47;"},
//     action:'javascript:' + this.formid +'.Import()'
//   },1); 
  this.getTitlePortlet().AppendButton({
    id:"EseguiFN",
    title:FormatMsg('Import File'),
    tooltip:FormatMsg('Importa il file 380'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb47;"},
    action:'javascript:' + this.formid +'.ImportFN()'
  },2); 
}
function image5_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function ImportFN(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.PortletLogs.Start();
    this.RTEseguiFN.Link();
  }    
}
function Import(){
  if (confirm("Confermi l'elaborazione del file?")) {
    this.PortletLogs.Start();
    this.RTEsegui.Link();
  }    
}
function Aggiorna() {
  this.RTSaveFile.Link();
}  
function RTEsegui_Result(result){
  this.PortletLogs.Stop();
  alert("Elaborazione Terminata");
}
function RTEseguiFN_Result(result){
  this.PortletLogs.Stop();
  alert("Elaborazione Terminata");
}
function btnDown_Click(){
  this.RTDownload.Link();
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
.pg_imp_offline_container {
  height:100%;
  overflow:auto;
}
.pg_imp_offline_title_container {
  margin: auto;
}
.pg_imp_offline_portlet{
  position:relative;
  margin: auto;
  width:850px;
  min-width:850px;
  height:100%;
}
.pg_imp_offline_portlet[Data-page="1"]{
  height:100%;
  width:850px;
}
.pg_imp_offline_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:84px;
  width:737px;
  height:20px;
}
.pg_imp_offline_portlet > .nomefile_ctrl {
}
.pg_imp_offline_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_imp_offline_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:115px;
  left:0px;
  right:0px;
  bottom:5px;
  width:850px;
}
.pg_imp_offline_portlet > .label1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:8px;
  width:72px;
  height:auto;
  min-height:19px;
}
.pg_imp_offline_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_imp_offline_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_imp_offline_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:827px;
  width:20px;
  height:20px;
}
.pg_imp_offline_portlet > .image5_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_imp_offline_portlet > .Label14_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:851px;
  height:auto;
  min-height:20px;
}
.pg_imp_offline_portlet > .Label14_ctrl {
  height:auto;
  min-height:20px;
}
.pg_imp_offline_portlet > .Label14_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.pg_imp_offline_portlet > .Label14_Copy_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:21px;
  left:0px;
  width:851px;
  height:auto;
  min-height:20px;
}
.pg_imp_offline_portlet > .Label14_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_imp_offline_portlet > .Label14_Copy_ctrl {
  overflow:hidden;
  font-weight:bold;
  text-align:center;
}
.pg_imp_offline_portlet > .cmbDest_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:81px;
  left:84px;
  width:129px;
  height:20px;
}
.pg_imp_offline_portlet > .label1_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:83px;
  left:8px;
  width:72px;
  height:auto;
  min-height:19px;
}
.pg_imp_offline_portlet > .label1_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_imp_offline_portlet > .label1_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_imp_offline_portlet > .chkAzzera_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:81px;
  left:246px;
  width:329px;
  height:20px;
}
.pg_imp_offline_portlet > .chkAnag_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:81px;
  left:611px;
  width:236px;
  height:20px;
}
.pg_imp_offline_portlet > .iPrint_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:116px;
  left:671px;
  width:1px;
  height:1px;
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
 String def="[{\"h\":\"200\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"850\",\"wizard\":\"\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"737\",\"x\":\"84\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"80\",\"layout_steps_values\":{},\"name\":\"PortletLogs\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"850\",\"x\":\"0\",\"y\":\"115\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nome File:\",\"w\":\"72\",\"x\":\"8\",\"y\":\"49\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"115\",\"x\":\"110\",\"y\":\"-70\"},{\"h\":\"30\",\"name\":\"RTEsegui\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"83\",\"x\":\"2\",\"y\":\"-62\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image5\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"827\",\"y\":\"48\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"240\",\"y\":\"-68\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"772\",\"y\":\"-60\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"502\",\"y\":\"-57\"},{\"h\":\"30\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"121\",\"x\":\"636\",\"y\":\"-60\"},{\"h\":\"20\",\"name\":\"RTAzzera\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"363\",\"y\":\"-59\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Questa procedura è in grado di ricostruire l'Archivio Unico Informatico importando i dati\",\"w\":\"851\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"4\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label14_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"dallo Scarico Sequenziale (Off-line) nel formato definito dall'Ufficio Indagini Finanziarie (UIF ex UIC).\",\"w\":\"851\",\"x\":\"0\",\"y\":\"21\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"cmbDest\",\"page\":\"1\",\"textlist\":\"Definitivo,Provvisorio\",\"type\":\"Combobox\",\"w\":\"129\",\"x\":\"84\",\"y\":\"81\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Destinazione:\",\"w\":\"72\",\"x\":\"8\",\"y\":\"83\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Importazione ripartendo da Archivi MIT Vuoti\",\"layout_steps_values\":{},\"name\":\"chkAzzera\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"329\",\"x\":\"246\",\"y\":\"81\",\"zindex\":\"6\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"Importa solo dati anagrafici\",\"layout_steps_values\":{},\"name\":\"chkAnag\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"236\",\"x\":\"611\",\"y\":\"81\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"1\",\"layout_steps_values\":{},\"name\":\"iPrint\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"1\",\"x\":\"671\",\"y\":\"116\",\"zindex\":\"8\"},{\"h\":\"30\",\"name\":\"RTEseguiFN\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"83\",\"x\":\"954\",\"y\":\"-76\"},{\"h\":\"20\",\"name\":\"cmbTipo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"926\",\"y\":\"-12\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_imp_offline","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_imp_offline_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_imp_offline','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String nomefile= "";
if(request.getAttribute("pg_imp_offline_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label1= "Nome File:";
String dir= "";
String Label14= "Questa procedura è in grado di ricostruire l'Archivio Unico Informatico importando i dati";
String Label14_Copy= "dallo Scarico Sequenziale (Off-line) nel formato definito dall'Ufficio Indagini Finanziarie (UIF ex UIC).";
String cmbDest="D";
String label1_Copy= "Destinazione:";
String chkAzzera="S";
String chkAnag="N";
String cmbTipo="S";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_imp_offline_title_container' style='width:850px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_imp_offline_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_imp_offline_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_imp_offline','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("Nome File:")%></div></span>
<a id='<%=idPortlet%>_image5' class='image image5_ctrl'   target=''>&#xe9da;</a>
<span id='<%=idPortlet%>_Label14'  formid='<%=idPortlet%>' ps-name='Label14'    class='label Label14_ctrl'><div id='<%=idPortlet%>_Label14tbl' style='width:100%;'><%=JSPLib.ToHTML("Questa procedura è in grado di ricostruire l'Archivio Unico Informatico importando i dati")%></div></span>
<span id='<%=idPortlet%>_Label14_Copy'  formid='<%=idPortlet%>' ps-name='Label14_Copy'    class='label Label14_Copy_ctrl'><div id='<%=idPortlet%>_Label14_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("dallo Scarico Sequenziale (Off-line) nel formato definito dall'Ufficio Indagini Finanziarie (UIF ex UIC).")%></div></span>
<select id='<%=idPortlet%>_cmbDest' name='cmbDest' class='combobox' style=''></select>
<span id='<%=idPortlet%>_label1_Copy'  formid='<%=idPortlet%>' ps-name='label1_Copy'    class='label label1_Copy_ctrl'><div id='<%=idPortlet%>_label1_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Destinazione:")%></div></span>
<div id='<%=idPortlet%>_chkAzzera_div' style=''><input id='<%=idPortlet%>_chkAzzera' name='chkAzzera' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkAzzera' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Importazione ripartendo da Archivi MIT Vuoti")%></label></div>
<div id='<%=idPortlet%>_chkAnag_div' style=''><input id='<%=idPortlet%>_chkAnag' name='chkAnag' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkAnag' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Importa solo dati anagrafici")%></label></div>
<div id='<%=idPortlet%>_iPrint_DIV'>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_imp_offline');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Import File",true)+","+JSPLib.ToJSValue(sp.translate("Import File"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Importa il file 380",true)+","+JSPLib.ToJSValue(sp.translate("Importa il file 380"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_imp_offline',["850"],["200"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'fixed','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"850","h":"200","title":"","layer":""}]);
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":737,"x":84,"y":48,"zerofilling":false,"zindex":"1","zoom":""});
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":80,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":850,"x":0,"y":115,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":72,"x":8,"y":49,"zindex":"1"});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":115,"x":110,"y":-70});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
this.RTEsegui=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_imp_offline",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsegui","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsegui","offline":false,"page":1,"parms":"w_nomefile=nomefile,w_tipodest=cmbDest,w_azzera=chkAzzera,w_tipoimp=cmbTipo,w_flgrae=A,w_soloanag=chkAnag","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_imp_offline","target":"iPrint","type":"SPLinker","w":83,"x":2,"y":-62});
this.RTEsegui.m_cID='<%=JSPLib.cmdHash("routine,arrt_imp_offline",request.getSession())%>';
this.image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"right","class_Css":"image image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":827,"y":48,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":240,"y":-68});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_upload_file",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":120,"x":502,"y":-57});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file",request.getSession())%>';
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":121,"x":636,"y":-60});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":363,"y":-59});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.Label14=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14,false,true)%>","type":"Label","w":851,"x":0,"y":0,"zindex":"4"});
this.Label14_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label14_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label14_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label14_Copy,false,true)%>","type":"Label","w":851,"x":0,"y":21,"zindex":"4"});
this.cmbDest=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbDest","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbDest%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbDest","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Definitivo,Provvisorio","type":"Combobox","typevar":"character","valuelist":"D,P","visible":true,"w":129,"x":84,"y":81,"zindex":"5"});
this.label1_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label1_Copy,false,true)%>","type":"Label","w":72,"x":8,"y":83,"zindex":"1"});
this.chkAzzera=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkAzzera","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"Importazione ripartendo da Archivi MIT Vuoti","layer":false,"layout_steps_values":{},"name":"chkAzzera","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":329,"x":246,"y":81,"zindex":"6"});
this.chkAzzera.Value('<%=chkAzzera%>');
this.chkAnag=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkAnag","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Importa solo dati anagrafici","layer":false,"layout_steps_values":{},"name":"chkAnag","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":236,"x":611,"y":81,"zindex":"7"});
this.chkAnag.Value('<%=chkAnag%>');
this.iPrint=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iPrint","default_portlet":"","h":1,"hide":"false","layer":false,"layout_steps_values":{},"name":"iPrint","name_iframe":"iPrint","page":1,"spuid":"","type":"Iframe","w":1,"x":671,"y":116,"zindex":"8"});
this.RTEseguiFN=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_imp_offline",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEseguiFN","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEseguiFN","offline":false,"page":1,"parms":"w_nomefile=nomefile,w_tipodest=cmbDest,w_azzera=chkAzzera,w_soloanag=chkAnag","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_imp_offline","target":"iPrint","type":"SPLinker","w":83,"x":954,"y":-76});
this.RTEseguiFN.m_cID='<%=JSPLib.cmdHash("routine,arfn_imp_offline",request.getSession())%>';
this.cmbTipo=new ZtVWeb._VC(this,'cmbTipo',null,'character','<%=JSPLib.ToJSValue(cmbTipo,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_imp_offline_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_imp_offline_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_imp_offline_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.image5.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.cmbDest.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_imp_offline',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_imp_offline');
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
sp.endPage("pg_imp_offline");
}%>
<%! public String getJSPUID() { return "4283205876"; } %>