<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var _conta=0;\nvar _tipo=\"\"\n\nfunction this_Loaded() {\n  this.getTitlePortlet().SetTitle(\"Ricerca Soggetti PEP\",true)\n  this.lblTries.Hide()\n  if(!Empty(this.idticket.Value())) {\n    _tipo='R';\n    _conta=0; \n    this.StartSeek() \n  } else {   \n    _tipo='P';\n    this.RTPepTicket.Link()\n  }  \n}\n\nfunction RTPepTicket_Result(result){\n  if(!Empty(result)) {\n    this.lblTries.Show()    \n    this.idticket.Value(result);\n    _conta=0;\n    this.Timer_Verifica.Start()\n  } else {\n    alert(\"La richiesta non è andata a buon fine. Contattare l'assistenza\")\n  }  \n}\n\nfunction Timer_Verifica_onTimer(){\n  _conta=_conta+1;\n  if(_tipo=='P') {\n    this.lblTries.Value(\"Tentativo n. \"+_conta+\" di recuperare i dati per la verifica...\")\n  } else {\n    this.lblTries.Value(\"Preparazione report e visualizzazione dati in corso...\")    \n  }  \n  this.RTPepTicket_Verify.Link() \n}\n\nfunction RTPepTicket_Verify_Result(result){\n  if(result==99 || result==-9) {\n    this.lblTries.Hide()\n    alert(\"Dati pronti. Procedere con la visualizzazione dati\")\n    this.Timer_Verifica.Stop()      \n    this.RTPepTicket_RP.Link()\n    this.Query1.Query();\n    this.Grid3.Refresh()\n  }  \n}\n\nfunction StartSeek() {\n  _conta=0;\n  this.lblTries.Value(\"Preparazione visualizzazione dati in corso...\") \n  this.Timer_Verifica.Start()  \n}  \n\nfunction btnPEP_Click(){  \n  caller.Set_PEP(1)\n  caller.Set_PEPDATE(DateTime())\n  caller.w_TIPORIC='P'\n  caller.AggiornaRichieste(\"P\")\n  window.close()\n}\n\nfunction btnExit_Click(){\n  caller.Set_PEPDATE(DateTime())  \n  window.close()\n}\n\nfunction RTPepTicket_RP_Result(result){\n  this.nomedoc.Value(result)\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"372","hsl":"","htmlcode":"{{ w_ragsoc }}\n{{ Query1 }}\n{{ Grid3 }}\n{{ btnExit }}\n{{ btnPEP }}\n{{ w_codfisc }}\n{{ nomedoc }}\n{{ w_cognome }}\n{{ w_nome }}\n{{ w_tipo }}\n{{ idticket }}\n{{ Label12 }}\n{{ RTPepTicket }}\n{{ RTPepTicket_Verify }}\n{{ RTPepTicket_RP }}\n{{ w_pepdate }}\n{{ lblTries }}\n{{ Timer_Verifica }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_ragsoc","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"1","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"58","wireframe_props":"name","x":"17","y":"303","zerofilling":"false","zindex":"1"},{"allowedqueries":"rows:arrt_seekpep_rs_mc","appendingData":"false","auto_exec":"false","clientDB":"","count":"false","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"10","name":"Query1","offline":"false","page":"1","parms":"pTicket=idticket,pCodFisc=w_codfisc","parms_source":"","query":"rows:arrt_seekpep_rs_mc","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"417","y":"-67"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"TIPOLOGIA\",\"title\":\"Tipo Ricerca\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"STATUS\",\"title\":\"(Negativa o positiva)\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WARNING\",\"title\":\"Messaggi\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"true-by-example","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"250","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid3","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"3","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"39","zindex":"2"},{"alt":"","anchor":"","bounded_position":"","class_Css":"btnStart","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"35","help_tips":"Chiudere la finestra senza confermare il soggetto come PEP","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"4","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"35","wireframe_props":"","x":"975","y":"301","zindex":"14"},{"alt":"","anchor":"","bounded_position":"","class_Css":"btnStart","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96a;","font_image_hover":"&#xe96b;","font_name":"ZucchettiDevelopement","font_size":"","h":"35","help_tips":" Chiudere la finestra confermando il soggetto come PEP","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnPEP","page":"1","path_type":"","sequence":"5","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"35","wireframe_props":"","x":"927","y":"301","zindex":"14"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"w_codfisc","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"118","y":"303"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"nomedoc","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"790","y":"306"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"w_cognome","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"257","y":"305"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"w_nome","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"408","y":"309"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"w_tipo","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"544","y":"305"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":"false","layout_steps_values":"{}","maxlength":"","name":"idticket","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"301","wireframe_props":"name","x":"200","y":"10","zerofilling":"false","zindex":"15"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label12","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Ticket Richiesta:","w":"149","wireframe_props":"align,value,n_col","x":"49","y":"10","zindex":"16"},{"allowedentities":"arrt_seekpep_rs","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTPepTicket","offline":"false","page":"1","parms":"pRagSoc=w_ragsoc,pCognome=w_cognome,pNome=w_nome,pCodFisc=w_codfisc,pTipo=w_tipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"arrt_seekpep_rs","target":"","type":"SPLinker","w":"120","x":"569","y":"-64"},{"allowedentities":"arrt_seekpep_rs_ver","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTPepTicket_Verify","offline":"false","page":"1","parms":"pTicket=idticket,pDataTic=w_pepdate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"arrt_seekpep_rs_ver","target":"","type":"SPLinker","w":"120","x":"702","y":"-64"},{"allowedentities":"arrt_seekpep_rs_rp","async":"true","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTPepTicket_RP","offline":"false","page":"1","parms":"pTicket=idticket,pCodFis=w_codfisc","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arrt_seekpep_rs_rp","target":"","type":"SPLinker","w":"120","x":"836","y":"-63"},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"w_pepdate","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"20","y":"337"},{"align":"","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"lblTries","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"17","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"482","wireframe_props":"align,value,n_col","x":"535","y":"10","zindex":"18"},{"delay":"0","duration":"","h":"20","interval":"5000","name":"Timer_Verifica","page":"1","repeated":"true","rounds":"10","start_activated":"","type":"Timer","w":"120","x":"2","y":"390"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:w_ragsoc,w_codfisc,w_cognome,w_nome,w_tipo,idticket*/%>
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
window.pg_soggettipep_rs_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RTPepTicket_Result !='undefined')this.RTPepTicket_Result=RTPepTicket_Result;
if(typeof Timer_Verifica_onTimer !='undefined')this.Timer_Verifica_onTimer=Timer_Verifica_onTimer;
if(typeof RTPepTicket_Verify_Result !='undefined')this.RTPepTicket_Verify_Result=RTPepTicket_Verify_Result;
if(typeof StartSeek !='undefined')this.StartSeek=StartSeek;
if(typeof btnPEP_Click !='undefined')this.btnPEP_Click=btnPEP_Click;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof RTPepTicket_RP_Result !='undefined')this.RTPepTicket_RP_Result=RTPepTicket_RP_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid3);
var _conta=0;
var _tipo=""
function this_Loaded() {
  this.getTitlePortlet().SetTitle("Ricerca Soggetti PEP",true)
  this.lblTries.Hide()
  if(!Empty(this.idticket.Value())) {
    _tipo='R';
    _conta=0; 
    this.StartSeek() 
  } else {   
    _tipo='P';
    this.RTPepTicket.Link()
  }  
}
function RTPepTicket_Result(result){
  if(!Empty(result)) {
    this.lblTries.Show()    
    this.idticket.Value(result);
    _conta=0;
    this.Timer_Verifica.Start()
  } else {
    alert("La richiesta non è andata a buon fine. Contattare l'assistenza")
  }  
}
function Timer_Verifica_onTimer(){
  _conta=_conta+1;
  if(_tipo=='P') {
    this.lblTries.Value("Tentativo n. "+_conta+" di recuperare i dati per la verifica...")
  } else {
    this.lblTries.Value("Preparazione report e visualizzazione dati in corso...")    
  }  
  this.RTPepTicket_Verify.Link() 
}
function RTPepTicket_Verify_Result(result){
  if(result==99 || result==-9) {
    this.lblTries.Hide()
    alert("Dati pronti. Procedere con la visualizzazione dati")
    this.Timer_Verifica.Stop()      
    this.RTPepTicket_RP.Link()
    this.Query1.Query();
    this.Grid3.Refresh()
  }  
}
function StartSeek() {
  _conta=0;
  this.lblTries.Value("Preparazione visualizzazione dati in corso...") 
  this.Timer_Verifica.Start()  
}  
function btnPEP_Click(){  
  caller.Set_PEP(1)
  caller.Set_PEPDATE(DateTime())
  caller.w_TIPORIC='P'
  caller.AggiornaRichieste("P")
  window.close()
}
function btnExit_Click(){
  caller.Set_PEPDATE(DateTime())  
  window.close()
}
function RTPepTicket_RP_Result(result){
  this.nomedoc.Value(result)
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
.pg_soggettipep_rs_container {
}
.pg_soggettipep_rs_title_container {
  margin: auto;
}
.pg_soggettipep_rs_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:372px;
}
.pg_soggettipep_rs_portlet[Data-page="1"]{
  height:372px;
  width:100%;
}
.pg_soggettipep_rs_portlet > .w_ragsoc_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:1024px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_soggettipep_rs_portlet > .w_ragsoc_ctrl {
  display:none;
}
.pg_soggettipep_rs_portlet > .w_ragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_soggettipep_rs_portlet > .Grid3_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:39px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:250px;
}
.pg_soggettipep_rs_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:301px;
  left:975px;
  left:95.21484%;
  right:14px;
  right:1.3671875%;
  width:auto;
  height:35px;
}
.pg_soggettipep_rs_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:35px;
  font-size:35px;
}
.pg_soggettipep_rs_portlet > .btnPEP_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:301px;
  left:927px;
  left:90.52734%;
  right:62px;
  right:6.0546875%;
  width:auto;
  height:35px;
}
.pg_soggettipep_rs_portlet > .btnPEP_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:35px;
  font-size:35px;
}
.pg_soggettipep_rs_portlet > .idticket_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:10px;
  left:200px;
  left:19.53125%;
  right:523px;
  right:51.07422%;
  width:auto;
  height:20px;
}
.pg_soggettipep_rs_portlet > .idticket_ctrl {
}
.pg_soggettipep_rs_portlet > .idticket_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_soggettipep_rs_portlet > .Label12_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:10px;
  left:49px;
  left:4.7851562%;
  right:826px;
  right:80.66406%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_soggettipep_rs_portlet > .Label12_ctrl {
  height:auto;
  min-height:20px;
}
.pg_soggettipep_rs_portlet > .Label12_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_soggettipep_rs_portlet > .lblTries_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:10px;
  left:535px;
  left:52.246094%;
  right:7px;
  right:0.68359375%;
  width:auto;
  height:auto;
  min-height:22px;
}
.pg_soggettipep_rs_portlet > .lblTries_ctrl {
  height:auto;
  min-height:22px;
}
.pg_soggettipep_rs_portlet > .lblTries_ctrl {
  overflow:hidden;
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
 String def="[{\"h\":\"372\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_ragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"58\",\"x\":\"17\",\"y\":\"303\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"Query1\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"417\",\"y\":\"-67\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Tipo Ricerca\"},{\"title\":\"(Negativa o positiva)\"},{\"title\":\"Messaggi\"}],\"h\":\"250\",\"layout_steps_values\":{},\"name\":\"Grid3\",\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"39\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"35\",\"layout_steps_values\":{},\"name\":\"btnExit\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"35\",\"x\":\"975\",\"y\":\"301\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"35\",\"layout_steps_values\":{},\"name\":\"btnPEP\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"35\",\"x\":\"927\",\"y\":\"301\",\"zindex\":\"14\"},{\"h\":\"20\",\"name\":\"w_codfisc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"118\",\"y\":\"303\"},{\"h\":\"20\",\"name\":\"nomedoc\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"790\",\"y\":\"306\"},{\"h\":\"20\",\"name\":\"w_cognome\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"257\",\"y\":\"305\"},{\"h\":\"20\",\"name\":\"w_nome\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"408\",\"y\":\"309\"},{\"h\":\"20\",\"name\":\"w_tipo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"544\",\"y\":\"305\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"idticket\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"301\",\"x\":\"200\",\"y\":\"10\",\"zindex\":\"15\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label12\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Ticket Richiesta:\",\"w\":\"149\",\"x\":\"49\",\"y\":\"10\",\"zindex\":\"16\"},{\"h\":\"20\",\"name\":\"RTPepTicket\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"569\",\"y\":\"-64\"},{\"h\":\"20\",\"name\":\"RTPepTicket_Verify\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"702\",\"y\":\"-64\"},{\"h\":\"20\",\"name\":\"RTPepTicket_RP\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"836\",\"y\":\"-63\"},{\"h\":\"20\",\"name\":\"w_pepdate\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"20\",\"y\":\"337\"},{\"align\":\"\",\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblTries\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"482\",\"x\":\"535\",\"y\":\"10\",\"zindex\":\"18\"},{\"h\":\"20\",\"name\":\"Timer_Verifica\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"120\",\"x\":\"2\",\"y\":\"390\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_soggettipep_rs","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_soggettipep_rs_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_soggettipep_rs','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String w_ragsoc=JSPLib.translateXSS(sp.getParameter("w_ragsoc",""));
if(request.getAttribute("pg_soggettipep_rs_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_soggettipep_rs_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_codfisc=JSPLib.translateXSS(sp.getParameter("w_codfisc",""));
String nomedoc= "";
String w_cognome=JSPLib.translateXSS(sp.getParameter("w_cognome",""));
String w_nome=JSPLib.translateXSS(sp.getParameter("w_nome",""));
String w_tipo=JSPLib.translateXSS(sp.getParameter("w_tipo",""));
String idticket=JSPLib.translateXSS(sp.getParameter("idticket",""));
String Label12= "Ticket Richiesta:";
String w_pepdate= "";
String lblTries= "";
if(request.getAttribute("pg_soggettipep_rs_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("TimerObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_soggettipep_rs_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_soggettipep_rs_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_soggettipep_rs_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_soggettipep_rs','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_w_ragsoc_wrp'><input id='<%=idPortlet%>_w_ragsoc' name='w_ragsoc' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_ragsoc' /></span>
<div id='<%=idPortlet%>_Grid3' formid='<%=idPortlet%>' ps-name='Grid3'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_btnExit' class='btnStart btnExit_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_btnPEP' class='btnStart btnPEP_ctrl'   target=''>&#xe96a;</a>
<span class='textbox-container'id='<%=idPortlet%>_idticket_wrp'><input id='<%=idPortlet%>_idticket' name='idticket' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='idticket' /></span>
<span id='<%=idPortlet%>_Label12'  formid='<%=idPortlet%>' ps-name='Label12'    class='label Label12_ctrl'><div id='<%=idPortlet%>_Label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Ticket Richiesta:")%></div></span>
<span id='<%=idPortlet%>_lblTries'  formid='<%=idPortlet%>' ps-name='lblTries'    class='label lblTries_ctrl'><div id='<%=idPortlet%>_lblTriestbl' style='width:100%;'></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_soggettipep_rs');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_soggettipep_rs',["1024"],["372"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"372","title":"","layer":"false","npage":"1"}]);
this.w_ragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_ragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_ragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_ragsoc,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("rows:arrt_seekpep_rs_mc",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"rows:arrt_seekpep_rs_mc","cmdHash":"<%=JSPLib.cmdHash("rows:arrt_seekpep_rs_mc",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"10","page":1,"parms":"pTicket=idticket,pCodFisc=w_codfisc","parms_source":"","type":"SQLDataobj","w":120,"x":417,"y":-67});
this.Grid3=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid3","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":250,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid3","nav_bar":"always","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":39,"zindex":"2"});
this.Grid3.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo Ricerca","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TIPOLOGIA","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"(Negativa o positiva)","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"STATUS","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Messaggi","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WARNING","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"btnStart btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":35,"help_tips":"<%=JSPLib.ToJSValue("Chiudere la finestra senza confermare il soggetto come PEP",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":35,"x":975,"y":301,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnPEP=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"btnStart btnPEP_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnPEP","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe96a;","font_image_hover":"&#xe96b;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":35,"help_tips":"<%=JSPLib.ToJSValue(" Chiudere la finestra confermando il soggetto come PEP",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnPEP","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe96a;","srchover":"&#xe96b;","tabindex":"","target":"","type":"Image","type_submit":"false","w":35,"x":927,"y":301,"zindex":"14"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.w_codfisc=new ZtVWeb._VC(this,'w_codfisc',null,'character','<%=JSPLib.ToJSValue(w_codfisc,false,true)%>',false,false);
this.nomedoc=new ZtVWeb._VC(this,'nomedoc',null,'character','<%=JSPLib.ToJSValue(nomedoc,false,true)%>',false,false);
this.w_cognome=new ZtVWeb._VC(this,'w_cognome',null,'character','<%=JSPLib.ToJSValue(w_cognome,false,true)%>',false,false);
this.w_nome=new ZtVWeb._VC(this,'w_nome',null,'character','<%=JSPLib.ToJSValue(w_nome,false,true)%>',false,false);
this.w_tipo=new ZtVWeb._VC(this,'w_tipo',null,'character','<%=JSPLib.ToJSValue(w_tipo,false,true)%>',false,false);
this.idticket=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_idticket","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"request","layer":false,"layout_steps_values":{},"maxlength":"","name":"idticket","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(idticket,false,true)%>","w":301,"x":200,"y":10,"zerofilling":false,"zindex":"15","zoom":""});
this.Label12=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label12","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label12,false,true)%>","type":"Label","w":149,"x":49,"y":10,"zindex":"16"});
this.RTPepTicket=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_seekpep_rs",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPepTicket","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPepTicket","offline":false,"page":1,"parms":"pRagSoc=w_ragsoc,pCognome=w_cognome,pNome=w_nome,pCodFisc=w_codfisc,pTipo=w_tipo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_seekpep_rs","target":"","type":"SPLinker","w":120,"x":569,"y":-64});
this.RTPepTicket.m_cID='<%=JSPLib.cmdHash("routine,arrt_seekpep_rs",request.getSession())%>';
this.RTPepTicket_Verify=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_seekpep_rs_ver",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPepTicket_Verify","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPepTicket_Verify","offline":false,"page":1,"parms":"pTicket=idticket,pDataTic=w_pepdate","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_seekpep_rs_ver","target":"","type":"SPLinker","w":120,"x":702,"y":-64});
this.RTPepTicket_Verify.m_cID='<%=JSPLib.cmdHash("routine,arrt_seekpep_rs_ver",request.getSession())%>';
this.RTPepTicket_RP=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_seekpep_rs_rp",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTPepTicket_RP","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTPepTicket_RP","offline":false,"page":1,"parms":"pTicket=idticket,pCodFis=w_codfisc","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_seekpep_rs_rp","target":"","type":"SPLinker","w":120,"x":836,"y":-63});
this.RTPepTicket_RP.m_cID='<%=JSPLib.cmdHash("routine,arrt_seekpep_rs_rp",request.getSession())%>';
this.w_pepdate=new ZtVWeb._VC(this,'w_pepdate',null,'character','<%=JSPLib.ToJSValue(w_pepdate,false,true)%>',false,false);
this.lblTries=new ZtVWeb._LC(this,{"align":"","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblTries","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTries","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(lblTries,false,true)%>","type":"Label","w":482,"x":535,"y":10,"zindex":"18"});
this.Timer_Verifica=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_Timer_Verifica","delay":"0","duration":"","h":20,"hide":"false","interval":"5000","layer":false,"layout_steps_values":{},"name":"Timer_Verifica","page":1,"repeated":"true","rounds":"10","start_activated":"","type":"Timer","w":120,"x":2,"y":390});
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
<%if(request.getAttribute("pg_soggettipep_rs_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_soggettipep_rs_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_soggettipep_rs_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnPEP.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_soggettipep_rs',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_soggettipep_rs');
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
sp.endPage("pg_soggettipep_rs");
}%>
<%! public String getJSPUID() { return "704738110"; } %>