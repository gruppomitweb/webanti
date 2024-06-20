<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.RTClean.Link();\n  this.getTitlePortlet().SetTitle(\"MIGRAZIONE RAPPORTI e ANAGRAFICHE a nuova società\",true);  \n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi la migrazione dei dati?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTExec.Link();  \n  }  \n}\nfunction btnElab2_Click(){\n  if (confirm(\"Confermi l'aggiornamento dei codici di collegamento?\")) {\n    if(this.nomefile.Value()==''){\n    \talert('ATTENZIONE: File non selezionato!');\n    }\n    else{\n      this.pLog.Timer0.Start()    \n      this.pMsg.Timer0.Start()     \n      this.RTExec2.Link();\n      this.Label31_Copy.Show();\n    } \n  }  \n}\nfunction btnElab3_Click(){\n  if (confirm(\"Confermi il trasferimento delle Tabelle di Base?\")) {    \n      this.pLog.Timer0.Start()    \n      this.pMsg.Timer0.Start()     \n      this.RTExec3.Link();      \n    \n  }  \n}\nfunction RTExec_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop(); \n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}\n\nfunction image5_Click(){\n  this.dir.Value('Tmp\u002f');  \n  this.RTUpload.Parameters('dir=dir');\n  this.RTUpload.Link();\n}\nfunction Aggiorna() {\n  this.RTSaveFile.Link();\n} \n\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Migrazione rapporti e anagrafiche in nuova società","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"750","hsl":"false","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui migrazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"1","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"726","y":"6","zindex":"2"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"2","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"6","zindex":"2"},{"alt":"","anchor":"","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"image5","page":"1","path_type":"","sequence":"3","server_side":"","src":"..\u002fimages\u002fsystem\u002fsys_icon_uploud.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"20","wireframe_props":"","x":"461","y":"236","zindex":"2"},{"async":"false","entity_type":"","h":"20","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"851","y":"-43"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"pDataOpe=dataOpe,pDataReg=dataReg,pNomeDataBaseSorgente=nomeDataBaseSorgente,pNomeAziendaSogernteDati=nomeAziendaSogernteDati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_migrazione_nuova_societa","target":"","type":"SPLinker","w":"120","x":"851","y":"-22"},{"async":"false","entity_type":"","h":"20","m_cAction":"","name":"RTUpload","offline":"false","page":"1","parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":"","refresh":"","sequence":"6","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"852","y":"171"},{"anchor":"","h":"140","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"7","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"534","zindex":"NaN"},{"anchor":"","h":"63","hide":"false","isoptional":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"8","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"680","zindex":"NaN"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"dir","page":"1","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"852","y":"213"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","name":"RTClean","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"120","x":"851","y":"-64"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label20","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"11","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Data operazione:","w":"200","wireframe_props":"align,value,n_col","x":"125","y":"17","zindex":"3"},{"actObjs":"nomefile,","actTypes":"var,func","broadcast":"all","h":"20","included":"false","name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":"1","parmsNames":"nomefile","sequence":"12","type":"EventReceiver","w":"120","x":"852","y":"234"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label21","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Data registrazione:","w":"200","wireframe_props":"align,value,n_col","x":"125","y":"42","zindex":"4"},{"anchor":"","bg_color":"#F8E44F","font_color":"#232323","h":"213","hide":"","layout_steps_values":"{}","name":"Note22","page":"1","sequence":"14","type":"Note","value":"Portlet mi migrazione dei rapporti Attivi da vecchia società (alternative query) a nuova società. La routine viene lanciata da WEBANTI della nuova società e importa i Rapporti in essere, i titolari effettivi, i delegeti e le anagrafiche (con le informazioni aggiuntive).\nAgosto 2020\n\n\nAggiunta della gestione dell'aggiornamento dei connes.\nOttobre 2020\n\n\n-elia","w":"447","wireframe_props":"","x":"813","y":"534","zindex":"5"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","name":"RTSaveFile","offline":"false","page":"1","parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":"120","x":"852","y":"-1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layout_steps_values":"{}","maxlength":"","name":"dataOpe","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"16","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"120","wireframe_props":"name","x":"337","y":"17","zerofilling":"false","zindex":"7"},{"anchor":"","css_class":"","font":"","font_size":"","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario23","page":"1","popup":"true","return_input":"dataOpe","sequence":"17","type":"Calendario","w":"20","wireframe_props":"","x":"461","y":"17","zindex":"6"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"false","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layout_steps_values":"{}","maxlength":"","name":"dataReg","page":"1","password":"","picture":"","placeholder":"DEVE ESSERE LA DATA ODIERNA (per legge)","readonly":"true","scroll":"false","sequence":"18","tabindex":"","type":"Textbox","typevar":"date","visible":"true","w":"120","wireframe_props":"name","x":"337","y":"42","zerofilling":"false","zindex":"8"},{"anchor":"","css_class":"","font":"","font_size":"","h":"20","hide":"false","layout_steps_values":"{}","name":"Calendario26","page":"1","popup":"true","return_input":"dataReg","sequence":"19","type":"Calendario","w":"20","wireframe_props":"","x":"461","y":"42","zindex":"9"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label27","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"20","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Nome file:","w":"200","wireframe_props":"align,value,n_col","x":"125","y":"237","zindex":"18"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"Nome associato alla connessine altro DB","hide":"false","hide_undercond":"","init":"false","init_par":"","layout_steps_values":"{}","maxlength":"","name":"nomeDataBaseSorgente","page":"1","password":"","picture":"","placeholder":"es: SORGENTE","readonly":"false","scroll":"false","sequence":"21","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"337","y":"67","zerofilling":"false","zindex":"10"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label28","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"22","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Nome Connessione:","w":"200","wireframe_props":"align,value,n_col","x":"125","y":"67","zindex":"11"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label29","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"23","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Nome Azienda:","w":"200","wireframe_props":"align,value,n_col","x":"125","y":"92","zindex":"12"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"16pt","font_weight":"","fontpct":"","h":"32","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label30","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"24","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Aggiornamento dei codici di connessione","w":"370","wireframe_props":"align,value,n_col","x":"213","y":"166","zindex":"19"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layout_steps_values":"{}","maxlength":"","name":"nomeAziendaSogernteDati","page":"1","password":"","picture":"","placeholder":"es: afex","readonly":"false","scroll":"false","sequence":"25","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"337","y":"92","zerofilling":"false","zindex":"13"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label31","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"26","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Procedura da lanciare una volta completata la migrazione","w":"378","wireframe_props":"align,value,n_col","x":"208","y":"203","zindex":"20"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"100","name":"nomefile","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"27","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"120","wireframe_props":"name","x":"336","y":"236","zerofilling":"false","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui migrazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnElab2","page":"1","path_type":"","sequence":"28","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"721","y":"226","zindex":"2"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExec2","offline":"false","page":"1","parms":"w_nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"29","servlet":"arrt_chg_connes_xls","target":"","type":"SPLinker","w":"120","x":"852","y":"192"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label31_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"30","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Controlla il LOG di ELABORAZIONE","w":"378","wireframe_props":"align,value,n_col","x":"211","y":"274","zindex":"20"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"16pt","font_weight":"","fontpct":"","h":"32","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label30_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"31","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Importazione delle Tabelle di Base","w":"370","wireframe_props":"align,value,n_col","x":"222","y":"363","zindex":"19"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label32","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"32","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Procedura da lanciare PRIMA del trasferimento","w":"370","wireframe_props":"align,value,n_col","x":"222","y":"402","zindex":"21"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebf5;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"35","help_tips":"","hide":"true","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Image33","page":"1","path_type":"","sequence":"33","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"35","wireframe_props":"","x":"397","y":"332","zindex":"22"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui migrazione","hide":"true","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layout_steps_values":"{}","name":"btnElab3","page":"1","path_type":"","sequence":"34","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"721","y":"380","zindex":"2"},{"async":"true","entity_type":"routine","h":"20","m_cAction":"function","name":"RTExec3","offline":"false","page":"1","parms":"pNomeDataBaseSorgente=nomeDataBaseSorgente,pNomeAziendaSogernteDati=nomeAziendaSogernteDati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"35","servlet":"arrt_migrazione_tabelle_di_base","target":"","type":"SPLinker","w":"120","x":"855","y":"379"}]%>
<%/*Description:Migrazione rapporti e anagrafiche in nuova società*/%>
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
window.pg_migrazione_nuova_societa_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof btnElab2_Click !='undefined')this.btnElab2_Click=btnElab2_Click;
if(typeof btnElab3_Click !='undefined')this.btnElab3_Click=btnElab3_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof image5_Click !='undefined')this.image5_Click=image5_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
function this_Loaded(){
  this.RTClean.Link();
  this.getTitlePortlet().SetTitle("MIGRAZIONE RAPPORTI e ANAGRAFICHE a nuova società",true);  
}
function btnElab_Click(){
  if (confirm("Confermi la migrazione dei dati?")) {
    this.pLog.Timer0.Start()    
    this.pMsg.Timer0.Start()     
    this.RTExec.Link();  
  }  
}
function btnElab2_Click(){
  if (confirm("Confermi l'aggiornamento dei codici di collegamento?")) {
    if(this.nomefile.Value()==''){
    	alert('ATTENZIONE: File non selezionato!');
    }
    else{
      this.pLog.Timer0.Start()    
      this.pMsg.Timer0.Start()     
      this.RTExec2.Link();
      this.Label31_Copy.Show();
    } 
  }  
}
function btnElab3_Click(){
  if (confirm("Confermi il trasferimento delle Tabelle di Base?")) {    
      this.pLog.Timer0.Start()    
      this.pMsg.Timer0.Start()     
      this.RTExec3.Link();      
    
  }  
}
function RTExec_Result(result){
  this.pMsg.Timer0_onTimer();
  this.pMsg.Timer0.Stop()
  this.pLog.Timer0_onTimer();
  this.pLog.Timer0.Stop(); 
}
function btnExit_Click(){ 
  this.RTEsci.Link();
}
function image5_Click(){
  this.dir.Value('Tmp/');  
  this.RTUpload.Parameters('dir=dir');
  this.RTUpload.Link();
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
.pg_migrazione_nuova_societa_container {
}
.pg_migrazione_nuova_societa_title_container {
  margin: auto;
}
.pg_migrazione_nuova_societa_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:750px;
}
.pg_migrazione_nuova_societa_portlet[Data-page="1"]{
  height:750px;
  width:100%;
}
.pg_migrazione_nuova_societa_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:6px;
  right:44px;
  width:30px;
  height:30px;
}
.pg_migrazione_nuova_societa_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_migrazione_nuova_societa_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:6px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_migrazione_nuova_societa_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_migrazione_nuova_societa_portlet > .image5_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:236px;
  left:461px;
  left:57.625%;
  right:319px;
  right:39.875%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .image5_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:20px;
  font-size:20px;
}
.pg_migrazione_nuova_societa_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:534px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:140px;
}
.pg_migrazione_nuova_societa_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:NaN;
  position:absolute;
  display:inline-block;
  top:680px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:63px;
}
.pg_migrazione_nuova_societa_portlet > .Label20_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:17px;
  left:125px;
  left:15.625%;
  right:475px;
  right:59.375%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label20_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label20_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_migrazione_nuova_societa_portlet > .Label21_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:42px;
  left:125px;
  left:15.625%;
  right:475px;
  right:59.375%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label21_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label21_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_migrazione_nuova_societa_portlet > .dataOpe_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:17px;
  left:337px;
  left:42.125%;
  right:343px;
  right:42.875%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .dataOpe_ctrl {
}
.pg_migrazione_nuova_societa_portlet > .dataOpe_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_migrazione_nuova_societa_portlet > .Calendario23_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:17px;
  left:461px;
  left:57.625%;
  right:319px;
  right:39.875%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .dataReg_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:42px;
  left:337px;
  left:42.125%;
  right:343px;
  right:42.875%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .dataReg_ctrl {
}
.pg_migrazione_nuova_societa_portlet > .dataReg_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_migrazione_nuova_societa_portlet > .Calendario26_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:42px;
  left:461px;
  left:57.625%;
  right:319px;
  right:39.875%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label27_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:237px;
  left:125px;
  left:15.625%;
  right:475px;
  right:59.375%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label27_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label27_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_migrazione_nuova_societa_portlet > .nomeDataBaseSorgente_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:67px;
  left:337px;
  left:42.125%;
  right:343px;
  right:42.875%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .nomeDataBaseSorgente_ctrl {
}
.pg_migrazione_nuova_societa_portlet > .nomeDataBaseSorgente_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_migrazione_nuova_societa_portlet > .Label28_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:67px;
  left:125px;
  left:15.625%;
  right:475px;
  right:59.375%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label28_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label28_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_migrazione_nuova_societa_portlet > .Label29_ctrl {
  box-sizing:border-box;
  z-index:12;
  position:absolute;
  display:inline-block;
  top:92px;
  left:125px;
  left:15.625%;
  right:475px;
  right:59.375%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label29_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label29_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_migrazione_nuova_societa_portlet > .Label30_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:166px;
  left:213px;
  left:26.625%;
  right:217px;
  right:27.125%;
  width:auto;
  height:auto;
  min-height:32px;
}
.pg_migrazione_nuova_societa_portlet > .Label30_ctrl {
  height:auto;
  min-height:32px;
}
.pg_migrazione_nuova_societa_portlet > .Label30_ctrl {
  overflow:hidden;
  font-size:16pt;
  text-align:center;
}
.pg_migrazione_nuova_societa_portlet > .nomeAziendaSogernteDati_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:92px;
  left:337px;
  left:42.125%;
  right:343px;
  right:42.875%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .nomeAziendaSogernteDati_ctrl {
}
.pg_migrazione_nuova_societa_portlet > .nomeAziendaSogernteDati_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_migrazione_nuova_societa_portlet > .Label31_ctrl {
  box-sizing:border-box;
  z-index:20;
  position:absolute;
  display:inline-block;
  top:203px;
  left:208px;
  left:26.0%;
  right:214px;
  right:26.75%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label31_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label31_ctrl {
  overflow:hidden;
  color:#FF0000;
  text-align:center;
}
.pg_migrazione_nuova_societa_portlet > .nomefile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:236px;
  left:336px;
  left:42.0%;
  right:344px;
  right:43.0%;
  width:auto;
  height:20px;
}
.pg_migrazione_nuova_societa_portlet > .nomefile_ctrl {
}
.pg_migrazione_nuova_societa_portlet > .nomefile_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_migrazione_nuova_societa_portlet > .btnElab2_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:226px;
  right:49px;
  width:30px;
  height:30px;
}
.pg_migrazione_nuova_societa_portlet > .btnElab2_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_migrazione_nuova_societa_portlet > .Label31_Copy_ctrl {
  box-sizing:border-box;
  z-index:20;
  position:absolute;
  display:inline-block;
  top:274px;
  left:211px;
  left:26.375%;
  right:211px;
  right:26.375%;
  width:auto;
  height:auto;
  min-height:20px;
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .Label31_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label31_Copy_ctrl {
  overflow:hidden;
  color:#FF0000;
  text-align:center;
}
.pg_migrazione_nuova_societa_portlet > .Label30_Copy_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:363px;
  left:222px;
  left:27.75%;
  right:208px;
  right:26.0%;
  width:auto;
  height:auto;
  min-height:32px;
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .Label30_Copy_ctrl {
  height:auto;
  min-height:32px;
}
.pg_migrazione_nuova_societa_portlet > .Label30_Copy_ctrl {
  overflow:hidden;
  font-size:16pt;
  text-align:center;
}
.pg_migrazione_nuova_societa_portlet > .Label32_ctrl {
  box-sizing:border-box;
  z-index:21;
  position:absolute;
  display:inline-block;
  top:402px;
  left:222px;
  left:27.75%;
  right:208px;
  right:26.0%;
  width:auto;
  height:auto;
  min-height:20px;
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .Label32_ctrl {
  height:auto;
  min-height:20px;
}
.pg_migrazione_nuova_societa_portlet > .Label32_ctrl {
  overflow:hidden;
  color:#FF0000;
  text-align:center;
}
.pg_migrazione_nuova_societa_portlet > .Image33_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:332px;
  left:397px;
  left:49.625%;
  right:368px;
  right:46.0%;
  width:auto;
  height:35px;
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .Image33_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:35px;
  font-size:35px;
}
.pg_migrazione_nuova_societa_portlet > .btnElab3_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:380px;
  right:49px;
  width:30px;
  height:30px;
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .btnElab3_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
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
 String def="[{\"h\":\"750\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"726\",\"y\":\"6\",\"zindex\":\"2\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"6\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"20\",\"x\":\"461\",\"y\":\"236\",\"zindex\":\"2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"851\",\"y\":\"-43\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"851\",\"y\":\"-22\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"852\",\"y\":\"171\"},{\"anchor\":\"\",\"h\":\"140\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"534\",\"zindex\":\"NaN\"},{\"anchor\":\"\",\"h\":\"63\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"680\",\"zindex\":\"NaN\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"852\",\"y\":\"213\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"851\",\"y\":\"-64\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data operazione:\",\"w\":\"200\",\"x\":\"125\",\"y\":\"17\",\"zindex\":\"3\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"120\",\"x\":\"852\",\"y\":\"234\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Data registrazione:\",\"w\":\"200\",\"x\":\"125\",\"y\":\"42\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"213\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Note\",\"value\":\"Portlet mi migrazione dei rapporti Attivi da vecchia società (alternative query) a nuova società. La routine viene lanciata da WEBANTI della nuova società e importa i Rapporti in essere, i titolari effettivi, i delegeti e le anagrafiche (con le informazioni aggiuntive).\\nAgosto 2020\\n\\n\\nAggiunta della gestione dell'aggiornamento dei connes.\\nOttobre 2020\\n\\n\\n-elia\",\"w\":\"447\",\"x\":\"813\",\"y\":\"534\",\"zindex\":\"5\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"852\",\"y\":\"-1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dataOpe\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"337\",\"y\":\"17\",\"zindex\":\"7\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario23\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"461\",\"y\":\"17\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dataReg\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"337\",\"y\":\"42\",\"zindex\":\"8\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Calendario26\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"20\",\"x\":\"461\",\"y\":\"42\",\"zindex\":\"9\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label27\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nome file:\",\"w\":\"200\",\"x\":\"125\",\"y\":\"237\",\"zindex\":\"18\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomeDataBaseSorgente\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"337\",\"y\":\"67\",\"zindex\":\"10\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label28\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nome Connessione:\",\"w\":\"200\",\"x\":\"125\",\"y\":\"67\",\"zindex\":\"11\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label29\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Nome Azienda:\",\"w\":\"200\",\"x\":\"125\",\"y\":\"92\",\"zindex\":\"12\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"32\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label30\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Aggiornamento dei codici di connessione\",\"w\":\"370\",\"x\":\"213\",\"y\":\"166\",\"zindex\":\"19\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomeAziendaSogernteDati\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"337\",\"y\":\"92\",\"zindex\":\"13\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label31\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Procedura da lanciare una volta completata la migrazione\",\"w\":\"378\",\"x\":\"208\",\"y\":\"203\",\"zindex\":\"20\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"nomefile\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"336\",\"y\":\"236\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab2\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"721\",\"y\":\"226\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"RTExec2\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"852\",\"y\":\"192\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label31_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Controlla il LOG di ELABORAZIONE\",\"w\":\"378\",\"x\":\"211\",\"y\":\"274\",\"zindex\":\"20\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"32\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label30_Copy\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Importazione delle Tabelle di Base\",\"w\":\"370\",\"x\":\"222\",\"y\":\"363\",\"zindex\":\"19\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label32\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Procedura da lanciare PRIMA del trasferimento\",\"w\":\"370\",\"x\":\"222\",\"y\":\"402\",\"zindex\":\"21\"},{\"anchor\":\"\",\"h\":\"35\",\"layout_steps_values\":{},\"name\":\"Image33\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"35\",\"x\":\"397\",\"y\":\"332\",\"zindex\":\"22\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnElab3\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"721\",\"y\":\"380\",\"zindex\":\"2\"},{\"h\":\"20\",\"name\":\"RTExec3\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"855\",\"y\":\"379\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_migrazione_nuova_societa","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_migrazione_nuova_societa_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_migrazione_nuova_societa_portlet > .Label31_Copy_ctrl {
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .Label30_Copy_ctrl {
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .Label32_ctrl {
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .Image33_ctrl {
  display:none;
}
.pg_migrazione_nuova_societa_portlet > .btnElab3_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_migrazione_nuova_societa','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String dir= "";
String Label20= "Data operazione:";
String Label21= "Data registrazione:";
java.sql.Date dataOpe= JSPLib.NullDate();
if(request.getAttribute("pg_migrazione_nuova_societa_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
if(request.getAttribute("pg_migrazione_nuova_societa_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
java.sql.Date dataReg= JSPLib.NullDate();
String Label27= "Nome file:";
String nomeDataBaseSorgente= "";
String Label28= "Nome Connessione:";
String Label29= "Nome Azienda:";
String Label30= "Aggiornamento dei codici di connessione";
String nomeAziendaSogernteDati= "";
String Label31= "Procedura da lanciare una volta completata la migrazione";
String nomefile= "";
String Label31_Copy= "Controlla il LOG di ELABORAZIONE";
String Label30_Copy= "Importazione delle Tabelle di Base";
String Label32= "Procedura da lanciare PRIMA del trasferimento";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_migrazione_nuova_societa_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_migrazione_nuova_societa_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_migrazione_nuova_societa_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_migrazione_nuova_societa','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_image5' class='image image5_ctrl'   target=''>&#xe9da;</a>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span id='<%=idPortlet%>_Label20'  formid='<%=idPortlet%>' ps-name='Label20'    class='label Label20_ctrl'><div id='<%=idPortlet%>_Label20tbl' style='width:100%;'><%=JSPLib.ToHTML("Data operazione:")%></div></span>
<span id='<%=idPortlet%>_Label21'  formid='<%=idPortlet%>' ps-name='Label21'    class='label Label21_ctrl'><div id='<%=idPortlet%>_Label21tbl' style='width:100%;'><%=JSPLib.ToHTML("Data registrazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_dataOpe_wrp'><input id='<%=idPortlet%>_dataOpe' name='dataOpe' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='dataOpe' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario23' class='calendar' onclick='window.<%=idPortlet%>.Calendario23.PopupCalendar();' style='text-decoration:none;'></a>
 <span class='textbox-container'id='<%=idPortlet%>_dataReg_wrp'><input id='<%=idPortlet%>_dataReg' name='dataReg' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='dataReg' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("DEVE ESSERE LA DATA ODIERNA (per legge)"))%>/></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario26' class='calendar' onclick='window.<%=idPortlet%>.Calendario26.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_Label27'  formid='<%=idPortlet%>' ps-name='Label27'    class='label Label27_ctrl'><div id='<%=idPortlet%>_Label27tbl' style='width:100%;'><%=JSPLib.ToHTML("Nome file:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_nomeDataBaseSorgente_wrp'><input id='<%=idPortlet%>_nomeDataBaseSorgente' name='nomeDataBaseSorgente' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nomeDataBaseSorgente' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("es: SORGENTE"))%>/></span>
<span id='<%=idPortlet%>_Label28'  formid='<%=idPortlet%>' ps-name='Label28'    class='label Label28_ctrl'><div id='<%=idPortlet%>_Label28tbl' style='width:100%;'><%=JSPLib.ToHTML("Nome Connessione:")%></div></span>
<span id='<%=idPortlet%>_Label29'  formid='<%=idPortlet%>' ps-name='Label29'    class='label Label29_ctrl'><div id='<%=idPortlet%>_Label29tbl' style='width:100%;'><%=JSPLib.ToHTML("Nome Azienda:")%></div></span>
<span id='<%=idPortlet%>_Label30'  formid='<%=idPortlet%>' ps-name='Label30'    class='label Label30_ctrl'><div id='<%=idPortlet%>_Label30tbl' style='width:100%;'><%=JSPLib.ToHTML("Aggiornamento dei codici di connessione")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_nomeAziendaSogernteDati_wrp'><input id='<%=idPortlet%>_nomeAziendaSogernteDati' name='nomeAziendaSogernteDati' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='nomeAziendaSogernteDati' placeholder=<%=JSPLib.ToHTMLValue(sp.translate("es: afex"))%>/></span>
<span id='<%=idPortlet%>_Label31'  formid='<%=idPortlet%>' ps-name='Label31'    class='label Label31_ctrl'><div id='<%=idPortlet%>_Label31tbl' style='width:100%;'><%=JSPLib.ToHTML("Procedura da lanciare una volta completata la migrazione")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_nomefile_wrp'><input id='<%=idPortlet%>_nomefile' name='nomefile' type='text' disabled maxlength='100' class='textbox' formid='<%=idPortlet%>' ps-name='nomefile' /></span>
<a id='<%=idPortlet%>_btnElab2' class='image btnElab2_ctrl'   target=''>&#xeb47;</a>
<span id='<%=idPortlet%>_Label31_Copy'  formid='<%=idPortlet%>' ps-name='Label31_Copy'    class='label Label31_Copy_ctrl'><div id='<%=idPortlet%>_Label31_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Controlla il LOG di ELABORAZIONE")%></div></span>
<span id='<%=idPortlet%>_Label30_Copy'  formid='<%=idPortlet%>' ps-name='Label30_Copy'    class='label Label30_Copy_ctrl'><div id='<%=idPortlet%>_Label30_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Importazione delle Tabelle di Base")%></div></span>
<span id='<%=idPortlet%>_Label32'  formid='<%=idPortlet%>' ps-name='Label32'    class='label Label32_ctrl'><div id='<%=idPortlet%>_Label32tbl' style='width:100%;'><%=JSPLib.ToHTML("Procedura da lanciare PRIMA del trasferimento")%></div></span>
<a id='<%=idPortlet%>_Image33' class='image-default Image33_ctrl'   target=''>&#xebf5;</a>
<a id='<%=idPortlet%>_btnElab3' class='image btnElab3_ctrl'   target=''>&#xeb47;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_migrazione_nuova_societa');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_migrazione_nuova_societa',["800"],["750"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"750","title":"","layer":"false","npage":"1"}]);
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui migrazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":726,"y":6,"zindex":"2"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":6,"zindex":"2"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.image5=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"right","class_Css":"image image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9da;","font_image_hover":"&#xe9db;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":20,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"image5","page":1,"path_type":"","server_side":"","src":"&#xe9da;","srchover":"&#xe9db;","tabindex":"","target":"","type":"Image","type_submit":"false","w":20,"x":461,"y":236,"zindex":"2"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":851,"y":-43});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"pDataOpe=dataOpe,pDataReg=dataReg,pNomeDataBaseSorgente=nomeDataBaseSorgente,pNomeAziendaSogernteDati=nomeAziendaSogernteDati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_migrazione_nuova_societa","target":"","type":"SPLinker","w":120,"x":851,"y":-22});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_migrazione_nuova_societa",request.getSession())%>';
this.RTUpload=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUpload","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUpload","offline":false,"page":1,"parms":"","popup":"true","popup_height":"486","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"300","progressbar":false,"refresh":"","servlet":"..\u002fjsp\u002fpg_upload_portlet.jsp","target":"","type":"SPLinker","w":120,"x":852,"y":171});
this.RTUpload.m_cID='<%=JSPLib.cmdHash("entity,../jsp/pg_upload_portlet.jsp",request.getSession())%>';
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":140,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","type":"Portlet","w":793,"x":3,"y":534,"zindex":"NaN"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":63,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","type":"Portlet","w":793,"x":3,"y":680,"zindex":"NaN"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.dir=new ZtVWeb._VC(this,'dir',null,'character','<%=JSPLib.ToJSValue(dir,false,true)%>',false,false);
this.RTClean=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTClean","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTClean","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":120,"x":851,"y":-64});
this.RTClean.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.Label20=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label20","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label20","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label20,false,true)%>","type":"Label","w":200,"x":125,"y":17,"zindex":"3"});
this.Event_filename=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"nomefile,","actTypes":"var,func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_Event_filename","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"Event_filename","objsValues":"nomefile,this.Aggiorna()","page":1,"parmsNames":"nomefile","type":"EventReceiver","w":120,"x":852,"y":234});
this.Label21=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label21","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label21","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label21,false,true)%>","type":"Label","w":200,"x":125,"y":42,"zindex":"4"});
this.RTSaveFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTSaveFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTSaveFile","offline":false,"page":1,"parms":"pNomeFile=nomefile,pDirDest=appo,pFileTmp=N","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_upload_file","target":"","type":"SPLinker","w":120,"x":852,"y":-1});
this.RTSaveFile.m_cID='<%=JSPLib.cmdHash("routine,arfn_upload_file",request.getSession())%>';
this.dataOpe=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dataOpe","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dataOpe","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dataOpe%>","w":120,"x":337,"y":17,"zerofilling":false,"zindex":"7","zoom":""});
this.Calendario23=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario23','Calendario23',461,17,20,20,'','','top-left(%)-right(%)','true','dataOpe',{});
this.dataReg=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_dataReg","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dataReg","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=dataReg%>","w":120,"x":337,"y":42,"zerofilling":false,"zindex":"8","zoom":""});
this.Calendario26=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario26','Calendario26',461,42,20,20,'','','top-left(%)-right(%)','true','dataReg',{});
this.Label27=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label27","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label27","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label27,false,true)%>","type":"Label","w":200,"x":125,"y":237,"zindex":"18"});
this.nomeDataBaseSorgente=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomeDataBaseSorgente","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"Nome associato alla connessine altro DB","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nomeDataBaseSorgente","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomeDataBaseSorgente,false,true)%>","w":120,"x":337,"y":67,"zerofilling":false,"zindex":"10","zoom":""});
this.Label28=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label28","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label28","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label28,false,true)%>","type":"Label","w":200,"x":125,"y":67,"zindex":"11"});
this.Label29=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label29","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label29","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label29,false,true)%>","type":"Label","w":200,"x":125,"y":92,"zindex":"12"});
this.Label30=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label30","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"16pt","font_weight":"","fontpct":"","h":32,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label30","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label30,false,true)%>","type":"Label","w":370,"x":213,"y":166,"zindex":"19"});
this.nomeAziendaSogernteDati=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomeAziendaSogernteDati","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"false","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"nomeAziendaSogernteDati","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomeAziendaSogernteDati,false,true)%>","w":120,"x":337,"y":92,"zerofilling":false,"zindex":"13","zoom":""});
this.Label31=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label31","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label31","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label31,false,true)%>","type":"Label","w":378,"x":208,"y":203,"zindex":"20"});
this.nomefile=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_nomefile","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"100","name":"nomefile","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(nomefile,false,true)%>","w":120,"x":336,"y":236,"zerofilling":false,"zindex":"1","zoom":""});
this.btnElab2=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab2_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab2","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui migrazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab2","page":1,"path_type":"","server_side":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":721,"y":226,"zindex":"2"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTExec2=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec2","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec2","offline":false,"page":1,"parms":"w_nomefile=nomefile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_chg_connes_xls","target":"","type":"SPLinker","w":120,"x":852,"y":192});
this.RTExec2.m_cID='<%=JSPLib.cmdHash("routine,arrt_chg_connes_xls",request.getSession())%>';
this.Label31_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label31_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label31_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label31_Copy,false,true)%>","type":"Label","w":378,"x":211,"y":274,"zindex":"20"});
this.Label30_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label30_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"16pt","font_weight":"","fontpct":"","h":32,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label30_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label30_Copy,false,true)%>","type":"Label","w":370,"x":222,"y":363,"zindex":"19"});
this.Label32=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label32","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"true","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label32","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label32,false,true)%>","type":"Label","w":370,"x":222,"y":402,"zindex":"21"});
this.Image33=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image33_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image33","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebf5;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":35,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"true","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image33","page":1,"path_type":"","server_side":"","src":"&#xebf5;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":35,"x":397,"y":332,"zindex":"22"});
 ZtVWeb.RequireFont("icons8_win10","");
this.btnElab3=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab3_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab3","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui migrazione",false,true)%>","hide":"true","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab3","page":1,"path_type":"","server_side":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":721,"y":380,"zindex":"2"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTExec3=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec3","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec3","offline":false,"page":1,"parms":"pNomeDataBaseSorgente=nomeDataBaseSorgente,pNomeAziendaSogernteDati=nomeAziendaSogernteDati","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_migrazione_tabelle_di_base","target":"","type":"SPLinker","w":120,"x":855,"y":379});
this.RTExec3.m_cID='<%=JSPLib.cmdHash("routine,arrt_migrazione_tabelle_di_base",request.getSession())%>';
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
<%if(request.getAttribute("pg_migrazione_nuova_societa_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_migrazione_nuova_societa_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_migrazione_nuova_societa_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.image5.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_Event_filename=function(parmsObj){<%=idPortlet%>.Event_filename.receiveFnc(parmsObj);}
window.<%=idPortlet%>.btnElab2.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Image33.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnElab3.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_migrazione_nuova_societa',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_migrazione_nuova_societa');
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
sp.endPage("pg_migrazione_nuova_societa");
}%>
<%! public String getJSPUID() { return "576127188"; } %>