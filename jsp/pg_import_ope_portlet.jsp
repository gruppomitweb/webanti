<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle('Import dati da procedure esterne (Strutture Standard)',true);\n  this.getTitlePortlet().SetSubTitle('',true);\n  this.RTAzzera.Link();\n}\n\nfunction btnExit_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link();\n  }  \n}\n\nfunction image5_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\n\nfunction btnStep_Click(){\n  if (confirm(\"Confermi l'importazione dei dati del file?\")) {\n    this.pMsg.Timer0.Start();\n    this.pLog.Timer0.Start();\n    this.RTStep.Parameters(\"pStep=2,w_nomefile=\"+this.nomefile.Value()+\",w_tipodest=\"+this.rDest.Value()+\",w_tipofile=\"+this.rTipoFile.Value()+\",w_tipoform=\"+this.rTipoForm.Value()+\",w_PAGMEZ=\"+this.PAGMEZ.Value())\n    this.RTStep.Link();\n  }    \n}\n\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n}  \n\nfunction RTStep_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pLog.Timer0_onTimer();\n  this.pMsg.Timer0.Stop();\n  this.pLog.Timer0.Stop();\n  if (result=='OK') {\n    alert(\"Elaborazione Terminata con successo!\");\n  } else {\n    alert(\"Elaborazione Terminata con errori.\\nPrelevare i file con gli errori\");    \n  }  \n  }\n\nfunction btnStp_Click(){\n  this.RTStampa.Link()\n}\n\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"380","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"851","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"1","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"750","wireframe_props":"name","x":"64","y":"11","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label18_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Contenuto file:","w":"129","wireframe_props":"align,value,n_col","x":"33","y":"74","zindex":"7"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"label1","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"NomeFile:","w":"51","wireframe_props":"align,value,n_col","x":"8","y":"14","zindex":"1"},{"async":"false","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"4","servlet":"pg_upload_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"379","y":"-67"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","disabled":"false","edit_undercond":"","font":"","font_size":"","h":"23","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"C","layout_steps_values":"{}","name":"rTipoForm","orientation":"horizontal","page":"1","picture":"","sequence":"5","tabindex":"","textlist":"CSV,Campi a lunghezza FISSA","type":"Radio","typevar":"character","valuelist":"C,F","visible":"true","w":"351","wireframe_props":"","x":"164","y":"100","zindex":"2"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"6","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_exit.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"813","y":"119","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label18_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Formato file:","w":"129","wireframe_props":"align,value,n_col","x":"33","y":"102","zindex":"7"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","name":"RTStep","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"9","servlet":"opert_imp_dati","target":"","type":"SPLinker","w":"120","x":"867","y":"52"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"30","name":"PAGMEZ","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"10","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"225","wireframe_props":"name","x":"164","y":"128","zerofilling":"false","zindex":"8"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"image5","page":"1","path_type":"","sequence":"11","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"820","y":"9","zindex":"1"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","disabled":"false","edit_undercond":"","font":"","font_size":"","h":"23","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"D","layout_steps_values":"{}","name":"rDest","orientation":"horizontal","page":"1","picture":"","sequence":"12","tabindex":"","textlist":"Definitivo,Provvisorio","type":"Radio","typevar":"character","valuelist":"D,P","visible":"true","w":"188","wireframe_props":"","x":"164","y":"44","zindex":"2"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label18_Copy_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Mezzo di Pagamento:","w":"154","wireframe_props":"align,value,n_col","x":"8","y":"130","zindex":"7"},{"anchor":"","h":"143","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"14","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"851","wireframe_props":"","x":"0","y":"157","zindex":"3"},{"anchor":"","h":"67","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"15","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"851","wireframe_props":"","x":"0","y":"302","zindex":"3"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe91c;","font_image_hover":"&#xe91d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui lo Step 2 dell'import","hide":"false","hide_undercond":"errimp=1","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnStep","page":"1","path_type":"","sequence":"16","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"737","y":"119","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label18","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Destinazione Dati:","w":"129","wireframe_props":"align,value,n_col","x":"33","y":"46","zindex":"7"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","name":"RTStampa","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"opert_imp_dati_report","target":"","type":"SPLinker","w":"120","x":"865","y":"81"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","h":"30","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"19","type":"EventReceiver","w":"111","x":"861","y":"-90"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"861","y":"-47"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"21","servlet":"opefn_upload_file_single","target":"","type":"SPLinker","w":"120","x":"505","y":"-67"},{"async":"false","entity_type":"","h":"20","m_cAction":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":"","refresh":"","sequence":"22","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"255","y":"-66"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","name":"RTAzzera","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"23","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"131","y":"-68"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"0","name":"fscarti","page":"1","sequence":"24","server_side":"false","type":"Variable","typevar":"numeric","w":"120","x":"869","y":"-16"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Stampa Errori Controllo File","hide":"false","hide_undercond":"errimp=0","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnStp","page":"1","path_type":"","sequence":"25","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"775","y":"119","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"errimp","page":"1","sequence":"26","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"867","y":"17"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","disabled":"false","edit_undercond":"","font":"","font_size":"","h":"23","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"P","layout_steps_values":"{}","name":"rTipoFile","orientation":"horizontal","page":"1","picture":"","sequence":"27","tabindex":"","textlist":"Soggetti,Operazioni,Frazionate,Contante","type":"Radio","typevar":"character","valuelist":"P,O,F,C","visible":"true","w":"351","wireframe_props":"","x":"164","y":"72","zindex":"2"}]%>
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
window.pg_import_ope_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof image5_Click !='undefined')this.image5_Click=image5_Click;
if(typeof btnStep_Click !='undefined')this.btnStep_Click=btnStep_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof RTStep_Result !='undefined')this.RTStep_Result=RTStep_Result;
if(typeof btnStp_Click !='undefined')this.btnStp_Click=btnStp_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.errimp.Value(),1),this.btnStep);
ZtVWeb.HideCtrl(Eq(this.errimp.Value(),0),this.btnStp);
}
function this_Loaded(){
  this.getTitlePortlet().SetTitle('Import dati da procedure esterne (Strutture Standard)',true);
  this.getTitlePortlet().SetSubTitle('',true);
  this.RTAzzera.Link();
}
function btnExit_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link();
  }  
}
function image5_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
}
function btnStep_Click(){
  if (confirm("Confermi l'importazione dei dati del file?")) {
    this.pMsg.Timer0.Start();
    this.pLog.Timer0.Start();
    this.RTStep.Parameters("pStep=2,w_nomefile="+this.nomefile.Value()+",w_tipodest="+this.rDest.Value()+",w_tipofile="+this.rTipoFile.Value()+",w_tipoform="+this.rTipoForm.Value()+",w_PAGMEZ="+this.PAGMEZ.Value())
    this.RTStep.Link();
  }    
}
function Aggiorna() {
  this.RTSaveFile.Link();
}  
function RTStep_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pLog.Timer0_onTimer();
  this.pMsg.Timer0.Stop();
  this.pLog.Timer0.Stop();
  if (result=='OK') {
    alert("Elaborazione Terminata con successo!");
  } else {
    alert("Elaborazione Terminata con errori.\nPrelevare i file con gli errori");    
  }  
  }
function btnStp_Click(){
  this.RTStampa.Link()
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
.pg_import_ope_container {
}
.pg_import_ope_title_container {
  margin: auto;
}
.pg_import_ope_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:851px;
  height:380px;
  background-color:#FFFFFF;
}
.pg_import_ope_portlet[Data-page="1"]{
  height:380px;
  width:100%;
}
.pg_import_ope_portlet > .nomefile_ctrl {
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
.pg_import_ope_portlet > .nomefile_ctrl {
}
.pg_import_ope_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_import_ope_portlet > .Label18_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:74px;
  left:33px;
  left:3.877791%;
  right:689px;
  right:80.96357%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_ope_portlet > .label1_ctrl {
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
.pg_import_ope_portlet > .label1_ctrl {
  height:auto;
  min-height:19px;
}
.pg_import_ope_portlet > .label1_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_import_ope_portlet > .rTipoForm_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:100px;
  left:164px;
  left:19.271446%;
  right:336px;
  right:39.48296%;
  width:auto;
  height:23px;
  height:auto;
  min-height:23px;
}
.pg_import_ope_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:119px;
  right:8px;
  width:30px;
  height:30px;
}
.pg_import_ope_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_ope_portlet > .Label18_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:102px;
  left:33px;
  left:3.877791%;
  right:689px;
  right:80.96357%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_ope_portlet > .PAGMEZ_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:128px;
  left:164px;
  left:19.271446%;
  right:462px;
  right:54.28907%;
  width:auto;
  height:20px;
}
.pg_import_ope_portlet > .PAGMEZ_ctrl {
}
.pg_import_ope_portlet > .PAGMEZ_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_ope_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  left:820px;
  left:96.35722%;
  right:11px;
  right:1.2925969%;
  width:auto;
  height:20px;
}
.pg_import_ope_portlet > .image5_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_import_ope_portlet > .rDest_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:44px;
  left:164px;
  left:19.271446%;
  right:499px;
  right:58.636898%;
  width:auto;
  height:23px;
  height:auto;
  min-height:23px;
}
.pg_import_ope_portlet > .Label18_Copy_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:130px;
  left:8px;
  left:0.9400705%;
  right:689px;
  right:80.96357%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_Copy_Copy_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_Copy_Copy_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_ope_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:157px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:143px;
}
.pg_import_ope_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:302px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:67px;
}
.pg_import_ope_portlet > .btnStep_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:119px;
  right:84px;
  width:30px;
  height:30px;
}
.pg_import_ope_portlet > .btnStep_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_ope_portlet > .Label18_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:46px;
  left:33px;
  left:3.877791%;
  right:689px;
  right:80.96357%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_ope_portlet > .Label18_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_import_ope_portlet > .btnStp_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:119px;
  right:46px;
  width:30px;
  height:30px;
}
.pg_import_ope_portlet > .btnStp_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_import_ope_portlet > .rTipoFile_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:72px;
  left:164px;
  left:19.271446%;
  right:336px;
  right:39.48296%;
  width:auto;
  height:23px;
  height:auto;
  min-height:23px;
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
 String def="[{\"h\":\"380\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"851\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"750\",\"x\":\"64\",\"y\":\"11\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Contenuto file:\",\"w\":\"129\",\"x\":\"33\",\"y\":\"74\",\"zindex\":\"7\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"NomeFile:\",\"w\":\"51\",\"x\":\"8\",\"y\":\"14\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTUpload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"379\",\"y\":\"-67\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"rTipoForm\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"351\",\"x\":\"164\",\"y\":\"100\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"813\",\"y\":\"119\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Formato file:\",\"w\":\"129\",\"x\":\"33\",\"y\":\"102\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"RTStep\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"867\",\"y\":\"52\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"PAGMEZ\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"225\",\"x\":\"164\",\"y\":\"128\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"image5\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"820\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"rDest\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"188\",\"x\":\"164\",\"y\":\"44\",\"zindex\":\"2\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18_Copy_Copy_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Mezzo di Pagamento:\",\"w\":\"154\",\"x\":\"8\",\"y\":\"130\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"143\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"851\",\"x\":\"0\",\"y\":\"157\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"67\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"851\",\"x\":\"0\",\"y\":\"302\",\"zindex\":\"3\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnStep\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"737\",\"y\":\"119\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label18\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Destinazione Dati:\",\"w\":\"129\",\"x\":\"33\",\"y\":\"46\",\"zindex\":\"7\"},{\"h\":\"20\",\"name\":\"RTStampa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"865\",\"y\":\"81\"},{\"h\":\"30\",\"name\":\"Event_filename\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"111\",\"x\":\"861\",\"y\":\"-90\"},{\"h\":\"20\",\"name\":\"dir\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"861\",\"y\":\"-47\"},{\"h\":\"20\",\"name\":\"RTSaveFile\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"505\",\"y\":\"-67\"},{\"h\":\"20\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"255\",\"y\":\"-66\"},{\"h\":\"20\",\"name\":\"RTAzzera\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"131\",\"y\":\"-68\"},{\"h\":\"20\",\"name\":\"fscarti\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"869\",\"y\":\"-16\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnStp\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"775\",\"y\":\"119\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"errimp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"867\",\"y\":\"17\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"rTipoFile\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"351\",\"x\":\"164\",\"y\":\"72\",\"zindex\":\"2\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_import_ope","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_import_ope_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_import_ope','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String nomefile= "";
if(request.getAttribute("pg_import_ope_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label18_Copy= "Contenuto file:";
String label1= "NomeFile:";
String rTipoForm="C";
String Label18_Copy_Copy= "Formato file:";
String PAGMEZ= "";
String rDest="D";
String Label18_Copy_Copy_Copy= "Mezzo di Pagamento:";
String Label18= "Destinazione Dati:";
String dir= "";
double fscarti=0;
String errimp= "";
String rTipoFile="P";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_import_ope_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_import_ope_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_import_ope_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_import_ope','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<span id='<%=idPortlet%>_Label18_Copy'  formid='<%=idPortlet%>' ps-name='Label18_Copy'    class='label Label18_Copy_ctrl'><div id='<%=idPortlet%>_Label18_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Contenuto file:")%></div></span>
<span id='<%=idPortlet%>_label1'  formid='<%=idPortlet%>' ps-name='label1'    class='label label1_ctrl'><div id='<%=idPortlet%>_label1tbl' style='width:100%;'><%=JSPLib.ToHTML("NomeFile:")%></div></span>
<div id='<%=idPortlet%>_rTipoForm' class='radio' style='z-index:1;'></div>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xea01;</a>
<span id='<%=idPortlet%>_Label18_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label18_Copy_Copy'    class='label Label18_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label18_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Formato file:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_PAGMEZ_wrp'><input id='<%=idPortlet%>_PAGMEZ' name='PAGMEZ' type='text' maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='PAGMEZ' /></span>
<a id='<%=idPortlet%>_image5' class='image image5_ctrl'   target=''>&#xe9da;</a>
<div id='<%=idPortlet%>_rDest' class='radio' style='z-index:1;'></div>
<span id='<%=idPortlet%>_Label18_Copy_Copy_Copy'  formid='<%=idPortlet%>' ps-name='Label18_Copy_Copy_Copy'    class='label Label18_Copy_Copy_Copy_ctrl'><div id='<%=idPortlet%>_Label18_Copy_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Mezzo di Pagamento:")%></div></span>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<a id='<%=idPortlet%>_btnStep' class='image btnStep_ctrl'   target=''>&#xe91c;</a>
<span id='<%=idPortlet%>_Label18'  formid='<%=idPortlet%>' ps-name='Label18'    class='label Label18_ctrl'><div id='<%=idPortlet%>_Label18tbl' style='width:100%;'><%=JSPLib.ToHTML("Destinazione Dati:")%></div></span>
<a id='<%=idPortlet%>_btnStp' class='image btnStp_ctrl'   target=''>&#xeb05;</a>
<div id='<%=idPortlet%>_rTipoFile' class='radio' style='z-index:1;'></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_import_ope');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_import_ope',["851"],["380"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"851","h":"380","title":"","layer":"false","npage":"1"}]);
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":750,"x":64,"y":11,"zerofilling":false,"zindex":"1","zoom":""});
this.Label18_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label18_Copy,false,true)%>","type":"Label","w":129,"x":33,"y":74,"zindex":"7"});
this.label1=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label1","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label1,false,true)%>","type":"Label","w":51,"x":8,"y":14,"zindex":"1"});
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"pg_upload_portlet.jsp","target":"","type":"SPLinker","w":120,"x":379,"y":-67});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,pg_upload_portlet.jsp",request.getSession())%>';
this.rTipoForm=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"CSV,Campi a lunghezza FISSA","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_rTipoForm","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"font":"","font_size":"","h":23,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"C","layer":false,"layout_steps_values":{},"name":"rTipoForm","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"C,F","visible":true,"w":351,"x":164,"y":100,"zindex":"2"});
this.rTipoForm.Value('<%=JSPLib.ToJSValue(rTipoForm,false,true)%>');
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea01;","font_image_hover":"&#xea02;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xea01;","srchover":"&#xea02;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":813,"y":119,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label18_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label18_Copy_Copy,false,true)%>","type":"Label","w":129,"x":33,"y":102,"zindex":"7"});
this.RTStep=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStep","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStep","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opert_imp_dati","target":"","type":"SPLinker","w":120,"x":867,"y":52});
this.RTStep.m_cID='<%=JSPLib.cmdHash("routine,opert_imp_dati",request.getSession())%>';
this.PAGMEZ=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_PAGMEZ","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"30","name":"PAGMEZ","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(PAGMEZ,false,true)%>","w":225,"x":164,"y":128,"zerofilling":false,"zindex":"8","zoom":""});
this.image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":820,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.rDest=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Definitivo,Provvisorio","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_rDest","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"font":"","font_size":"","h":23,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"D","layer":false,"layout_steps_values":{},"name":"rDest","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"D,P","visible":true,"w":188,"x":164,"y":44,"zindex":"2"});
this.rDest.Value('<%=JSPLib.ToJSValue(rDest,false,true)%>');
this.Label18_Copy_Copy_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18_Copy_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18_Copy_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label18_Copy_Copy_Copy,false,true)%>","type":"Label","w":154,"x":8,"y":130,"zindex":"7"});
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","type":"Portlet","w":851,"x":0,"y":157,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":67,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":851,"x":0,"y":302,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.btnStep=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnStep_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnStep","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe91c;","font_image_hover":"&#xe91d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui lo Step 2 dell'import",false,true)%>","hide":"false","hide_undercond":"Eq(this.errimp.Value(),1)","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnStep","page":1,"path_type":"","server_side":"","src":"&#xe91c;","srchover":"&#xe91d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":737,"y":119,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label18=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label18","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label18","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label18,false,true)%>","type":"Label","w":129,"x":33,"y":46,"zindex":"7"});
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opert_imp_dati_report","target":"","type":"SPLinker","w":120,"x":865,"y":81});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("routine,opert_imp_dati_report",request.getSession())%>';
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":30,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":111,"x":861,"y":-90});
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opefn_upload_file_single","target":"","type":"SPLinker","w":120,"x":505,"y":-67});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,opefn_upload_file_single",request.getSession())%>';
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"300","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":255,"y":-66});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTAzzera=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTAzzera","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTAzzera","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opefn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":131,"y":-68});
this.RTAzzera.m_cID='<%=JSPLib.cmdHash("routine,opefn_azzera_messaggi",request.getSession())%>';
this.fscarti=new ZtVWeb._VC(this,'fscarti',null,'numeric',<%=fscarti%>,false,false);
this.btnStp=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnStp_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnStp","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Stampa Errori Controllo File",false,true)%>","hide":"false","hide_undercond":"Eq(this.errimp.Value(),0)","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnStp","page":1,"path_type":"","server_side":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":775,"y":119,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.errimp=new ZtVWeb._VC(this,'errimp',null,'character','<%=JSPLib.ToJSValue(errimp,false,true)%>',false,false);
this.rTipoFile=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Soggetti,Operazioni,Frazionate,Contante","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_rTipoFile","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"font":"","font_size":"","h":23,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"P","layer":false,"layout_steps_values":{},"name":"rTipoFile","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"P,O,F,C","visible":true,"w":351,"x":164,"y":72,"zindex":"2"});
this.rTipoFile.Value('<%=JSPLib.ToJSValue(rTipoFile,false,true)%>');
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
<%if(request.getAttribute("pg_import_ope_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_import_ope_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_import_ope_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.image5.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnStep.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.btnStp.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_import_ope',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_import_ope');
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
sp.endPage("pg_import_ope");
}%>
<%! public String getJSPUID() { return "1664415812"; } %>