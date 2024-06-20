<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var date_today;\nvar date_10;\nvar da_data; \nvar a_data;\n\nfunction this_Loaded(){\n  this.Variable_today.Init(new Date());\n  this.Radio.Value('C');\n  if(this.chi_chiama_il_portlet.Value()==='AUI'){\n  \tthis.getTitlePortlet().SetTitle(\"Trasferimento a Storico\u002fCancellazione\",true);\n    this.Label_desci.Value(\"Trasferimento dall'archivio unico a storico \u002f Cancellazione da archivio unico\")\n  }else if(this.chi_chiama_il_portlet.Value()==='STO'){\n  \tthis.getTitlePortlet().SetTitle(\"Cancellazione da Storico\",true);    \n    this.Radio.Disabled();\n  }else{this.getTitlePortlet().SetTitle(\"Chiamata senza parametro\",true)}\n  this.set_date();\n  this.getTitlePortlet().AppendButton({\n    id:\"Elabora\",\n    title:FormatMsg('Elabora'),\n    tooltip:FormatMsg('Cancella i record del periodo selezionato'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n    action:'javascript:' + this.formid +'.Image_elab_Click()'\n  },1);       \n  this.getTitlePortlet().AppendButton({\n    id:\"Anteprima\",\n    title:FormatMsg('Anteprima'),\n    tooltip:FormatMsg('Anteprima dei dati che verranno elaborati'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe9b5;\"},\n    action:'javascript:' + this.formid +'.Image_prev_Click()'\n  },2);   \n}\n\n\n\u002f\u002f BUTTON di elaborazione\nfunction Image_elab_Click(){   \n  if(this.check_dates()){\n    if(confirm(\"Eseguire l'elaborazione?\")){\n      this.disable_input();\n      this.getTitlePortlet().RemoveButtons()\n      this.PortletLogs.Start();\n     \tthis.SPLinker_elab.Link();\n    }\n  }else{\n  \t alert(\"ATTENZIONE:\\nLe date inserite non sono valide\\nVerificare le date inserite\");\n  }\n}\n\nfunction Image_prev_Click(){\n  \u002f\u002f BUTTON di preview\n  this.SPLinker_prev.Link();  \n}\n\nfunction Image_download_Click(){\n  this.RTDownload.Link();\n}\n\nfunction SPLinker_elab_Result(result){\n  \u002f\u002falert(result);\n  if(this.cmbStampa.Value()==\"S\" || this.cmbStampa.Value()==\"R\"){\n  \tthis.nomeFile.Value(result);\n    this.getTitlePortlet().AppendButton({\n      id:\"Download\",\n      title:FormatMsg('Download'),\n      tooltip:FormatMsg(''),\n      image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xebbd;\"},\n      action:'javascript:' + this.formid +'.Image_download_Click()'\n    },3);\n  }\n  this.enable_input();\n  this.PortletLogs.Stop();\n  alert(\"Elaborazione Terminata\");\n}\n\nfunction Radio_onChange(){\n  if(this.Radio.Value()==='T'){\n  \tthis.Checkbox_elim_anag.Value('false');\n    this.Checkbox_elim_anag.Disabled();\n  }else{\n    this.Checkbox_elim_anag.Enabled();\n  } \n}\n\u002f\u002f disabita imput del portlet\nfunction disable_input(){\n  this.getTitlePortlet().RemoveButtons()\n}\n\u002f\u002f abilita input del portlet\nfunction enable_input(){\n  this.getTitlePortlet().AppendButton({\n    id:\"Elabora\",\n    title:FormatMsg('Elabora'),\n    tooltip:FormatMsg('Cancella i record del periodo selezionato'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xeb4a;\"},\n    action:'javascript:' + this.formid +'.Image_elab_Click()'\n  },1);       \n  this.getTitlePortlet().AppendButton({\n    id:\"Anteprima\",\n    title:FormatMsg('Anteprima'),\n    tooltip:FormatMsg('Anteprima dei dati che verranno elaborati'),\n    image:{ fontFamily:'ZucchettiDevelopement', value: \"&#xe9b5;\"},\n    action:'javascript:' + this.formid +'.Image_prev_Click()'\n  },2);\n}\n\n\u002f\u002f inizializza le date nel portlet\nfunction set_date(){\n\tdate_10 = new Date();\n  date_10.setDate(date_10.getDate() - 1); \u002f\u002f vado a ieri\n  date_10.setYear(date_10.getUTCFullYear()-10); \u002f\u002f vado a ieri 10 anni fa\n  this.Textbox_a_data.Value(date_10.getUTCDate()+'-'+(date_10.getUTCMonth()+1)+'-'+date_10.getUTCFullYear());  \n}\n\u002f\u002f controlla le date nelle check box\nfunction check_dates(){\n  da_data = this.Textbox_da_data.Value(); \n  a_data = this.Textbox_a_data.Value();\n  if(a_data === null || (da_data != null && a_data === null)){return false;}\n  if(da_data === null && a_data != null){return a_data.getTime()\u003c=date_10.getTime()}  \n  if(da_data != null && a_data != null){return da_data.getTime()\u003ea_data.getTime()?false:a_data.getTime()\u003c=date_10.getTime()}\n}\n\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @pMsg }}{{ @pLog }}{{ @Radio }}{{ @Label_da_data }}{{ @Textbox_da_data }}{{ @Label_a_data }}{{ @Textbox_a_data }}{{ @Calendario12 }}{{ @Calendario13 }}{{ @Label_nota }}{{ @Checkbox_elim_anag }}{{ @Label_desci }}{{ @cmbStampa }}{{ @Label23 }}{{ @Radio }}{{ @Label_da_data }}{{ @Textbox_da_data }}{{ @Label_a_data }}{{ @Textbox_a_data }}{{ @Calendario12 }}{{ @Calendario13 }}{{ @Label_nota }}{{ @Image_elab }}{{ @Checkbox_elim_anag }}{{ @Image_prev }}{{ @Label_desci }}{{ @Image_download }}{{ @cmbStampa }}{{ @Label23 }}{{ @PortletLogs }}{{ @PortletLogs }}{{ @chkAUI }}{{ @chkAUI_Copy }}{{ @chkAGE }}\u003c\u002fbody\u003e","grapesCss":"","h":"410","hsl":"","htmlcode":"{{ @chkAUI }} \n \n \n{{ @PortletLogs }} \n{{ @Label23 }} \n{{ @cmbStampa }} \n\n{{ @Label_desci }}\n\n{{ @Checkbox_elim_anag }}\n\n\n{{ @Label_nota }}\n{{ @Calendario13 }}\n{{ @Calendario12 }}\n{{ @Textbox_a_data }}\n{{ @Label_a_data }}\n{{ @Textbox_da_data }}\n{{ @Label_da_data }}\n{{ @Radio }}\n\n\n{{ Image_prev }}{{ chi_chiama_il_portlet }}{{ Note19 }}\n{{ Image_p_fra }}\n{{ pLog }}\n{{ Image_fraz }}\n{{ Image_rap }}{{ $entity$_zoomSetFilter }}\n{{ SPLinker_rap }}{{ Label_desci }}\n{{ SPLinker_fraz }}\n{{ pMsg }}{{ SPLinker_prev }}\n{{ pLog_Copy }{{ Box19 }}}\n{{ @chkAUI{{ @chkAGE }} \n }} \n{{ pLog }}{{ p{{ Box20 }}Msg }}{{ Radio }}{{ Radio_Fraz }}{{ Radio_Rapp }}{{ Label_da_data }}{{ Calendario_da_data }}{{ Textbox_da_data }}{{ Variable8 }}{{ Label_a_data }}{{ Textbox_a_data }}{{ Calendario12 }}{{ Calendario13 }}{{ Label_nota }}{{ Label15 }}{{ Checkbox_download }}{{ Image_elab }}{{ SPLinker_elab }}{{ Box20_Copy }}{{ Image_p_rap }}{{ Checkbox_elim_anag }}{{ Variable_today }}{{ RTDownload }}{{ nomeFile }}{{ Image_download }}","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"410\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"anchor":"top-left(%)-right(%)-bottom","ctrlOfVariant":"","fixed":"","h":"90","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"PortletLogs","page":"1","rapp":"","sequence":"1","spuid":"","src":"pg_logs_portlet.jsp","themed":"false","type":"Portlet","w":"800","wireframe_props":"","x":"0","y":"321","zindex":"6","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Agenzia Entrate","layer":"false","layout_steps_values":"{}","name":"chkAGE","page":"1","rapp":"","sequence":"2","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"146","wireframe_props":"label_text","x":"425","y":"225","zindex":"31","zone":""},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","font":"","font_size":"","h":"20","helptipslist":"","hide":"false","hide_undercond":"","init":"false","init_par":"'D'","layer":"false","layout_steps_values":"{}","name":"Radio","orientation":"horizontal","page":"1","picture":"","rapp":"","sequence":"3","spuid":"","tabindex":"1","textlist":"Trasferimento a Storico,Cancellazione","type":"Radio","typevar":"character","valuelist":"T,C","visible":"true","w":"438","wireframe_props":"","x":"162","y":"73","zindex":"8","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_da_data","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Da Data Registrazione:","w":"179","wireframe_props":"align,value,n_col","x":"211","y":"160","zindex":"11","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_da_data","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"81","wireframe_props":"name","x":"394","y":"160","zerofilling":"false","zindex":"13","zone":"","zoom":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_a_data","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"A Data Registrazione:","w":"179","wireframe_props":"align,value,n_col","x":"211","y":"185","zindex":"14","zone":""},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","fixed":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"La data può essere al massimo la data di ieri di dieci anni fa","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"Textbox_a_data","page":"1","password":"","picker":"","picture":"","placeholder":"","rapp":"","readonly":"false","scroll":"false","sequence":"7","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"date","visible":"true","w":"81","wireframe_props":"name","x":"394","y":"185","zerofilling":"false","zindex":"15","zone":"","zoom":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"19","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario12","page":"1","popup":"true","rapp":"","return_input":"Textbox_da_data","sequence":"8","spuid":"","type":"Calendario","w":"31","wireframe_props":"","x":"479","y":"160","zindex":"16","zone":""},{"anchor":"","css_class":"","ctrlOfVariant":"","fixed":"","font":"","font_size":"","h":"19","hide":"false","layer":"false","layout_steps_values":"{}","name":"Calendario13","page":"1","popup":"true","rapp":"","return_input":"Textbox_a_data","sequence":"9","spuid":"","type":"Calendario","w":"31","wireframe_props":"","x":"479","y":"185","zindex":"17","zone":""},{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_nota","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ATTENZIONE\\n si possono cancellare solo le Operazioni\u002fFrazionate che hanno Data Registrazione di almeno 10 Anni precedente la Data Odierna","w":"799","wireframe_props":"align,value,n_col","x":"2","y":"292","zindex":"18","zone":""},{"allowedentities":"arrt_stor_trasf","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPLinker_elab","offline":"false","page":"1","parms":"w_chi_chiama_la_routine=chi_chiama_il_portlet,w_tipoope=Radio,w_DaDatOpe=Textbox_da_data,w_ADatOpe=Textbox_a_data,w_anag_colleg=Checkbox_elim_anag,w_stampa=cmbStampa,w_today_caller=Variable_today,w_chkAUI=chkAUI,w_chkAGE=chkAGE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"arrt_stor_trasf","target":"","type":"SPLinker","w":"120","x":"832","y":"60"},{"anchor":"","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"Elimina le anagrafiche dopo la cancellazione delle operazioni che non sono più collegate a niente.","hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Elimina anagrafiche collegate","layer":"false","layout_steps_values":"{}","name":"Checkbox_elim_anag","page":"1","rapp":"","sequence":"12","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":"398","wireframe_props":"label_text","x":"159","y":"111","zindex":"23","zone":""},{"allowedentities":"pg_storico_preview_portlet.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"view","name":"SPLinker_prev","offline":"false","page":"1","parms":"da_data=Textbox_da_data,a_data=Textbox_a_data","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"true","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"pg_storico_preview_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"973","y":"60"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"chi_chiama_il_portlet","page":"1","reactive":"","sequence":"14","server_side":"false","type":"Variable","typevar":"character","w":"148","x":"828","y":"21"},{"anchor":"","bg_color":"#F8E44F","ctrlOfVariant":"","fixed":"","font_color":"#232323","h":"100","hide":"","layer":"","layout_steps_values":"{}","name":"Note19","page":"1","rapp":"","sequence":"15","spuid":"","type":"Note","value":"Portlet parametrizzato, se chiamato da AUI ti fa storicizzare e eliminare, se chiamato da Storico ti fa solamente eliminare","w":"258","wireframe_props":"","x":"829","y":"-95","zindex":"24","zone":""},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label_desci","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"16","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"440","wireframe_props":"align,value,n_col","x":"159","y":"21","zindex":"25","zone":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"Variable_today","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"date","w":"120","x":"991","y":"19"},{"allowedentities":"arrt_downloadxlsx","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"RTDownload","offline":"false","page":"1","parms":"pFile=nomeFile,pCartella=appo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"arrt_downloadxlsx","target":"","type":"SPLinker","w":"120","x":"831","y":"93"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"nomeFile","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"976","y":"91"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","fixed":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"R","layer":"false","layout_steps_values":"{}","name":"cmbStampa","page":"1","picture":"","rapp":"","sequence":"20","spuid":"","tabindex":"","textlist":"Elaborazione trasferimenti\u002fcancellazioni senza stampa riepilogo,Elaborazione con Stampa elenco trasferimenti\u002fcancellazioni finale,Stampa solo elenco trasferimenti\u002fcancellazioni","type":"Combobox","typevar":"character","valuelist":"E,S,R","visible":"true","w":"435","wireframe_props":"name,textlist","x":"226","y":"257","zindex":"29","zone":""},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label23","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"21","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Tipo Elaborazione:","w":"200","wireframe_props":"align,value,n_col","x":"22","y":"258","zindex":"30","zone":""},{"anchor":"","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","fixed":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"A.U.I.","layer":"false","layout_steps_values":"{}","name":"chkAUI","page":"1","rapp":"","sequence":"22","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"109","wireframe_props":"label_text","x":"258","y":"225","zindex":"31","zone":""}]%>
<%/*Description:*/%>
<%/*ParamsRequest:chi_chiama_il_portlet*/%>
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
window.pg_storico_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image_elab_Click !='undefined')this.Image_elab_Click=Image_elab_Click;
if(typeof Image_prev_Click !='undefined')this.Image_prev_Click=Image_prev_Click;
if(typeof Image_download_Click !='undefined')this.Image_download_Click=Image_download_Click;
if(typeof SPLinker_elab_Result !='undefined')this.SPLinker_elab_Result=SPLinker_elab_Result;
if(typeof Radio_onChange !='undefined')this.Radio_onChange=Radio_onChange;
if(typeof disable_input !='undefined')this.disable_input=disable_input;
if(typeof enable_input !='undefined')this.enable_input=enable_input;
if(typeof set_date !='undefined')this.set_date=set_date;
if(typeof check_dates !='undefined')this.check_dates=check_dates;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
var date_today;
var date_10;
var da_data; 
var a_data;
function this_Loaded(){
  this.Variable_today.Init(new Date());
  this.Radio.Value('C');
  if(this.chi_chiama_il_portlet.Value()==='AUI'){
  	this.getTitlePortlet().SetTitle("Trasferimento a Storico/Cancellazione",true);
    this.Label_desci.Value("Trasferimento dall'archivio unico a storico / Cancellazione da archivio unico")
  }else if(this.chi_chiama_il_portlet.Value()==='STO'){
  	this.getTitlePortlet().SetTitle("Cancellazione da Storico",true);    
    this.Radio.Disabled();
  }else{this.getTitlePortlet().SetTitle("Chiamata senza parametro",true)}
  this.set_date();
  this.getTitlePortlet().AppendButton({
    id:"Elabora",
    title:FormatMsg('Elabora'),
    tooltip:FormatMsg('Cancella i record del periodo selezionato'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
    action:'javascript:' + this.formid +'.Image_elab_Click()'
  },1);       
  this.getTitlePortlet().AppendButton({
    id:"Anteprima",
    title:FormatMsg('Anteprima'),
    tooltip:FormatMsg('Anteprima dei dati che verranno elaborati'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe9b5;"},
    action:'javascript:' + this.formid +'.Image_prev_Click()'
  },2);   
}
// BUTTON di elaborazione
function Image_elab_Click(){   
  if(this.check_dates()){
    if(confirm("Eseguire l'elaborazione?")){
      this.disable_input();
      this.getTitlePortlet().RemoveButtons()
      this.PortletLogs.Start();
     	this.SPLinker_elab.Link();
    }
  }else{
  	 alert("ATTENZIONE:\nLe date inserite non sono valide\nVerificare le date inserite");
  }
}
function Image_prev_Click(){
  // BUTTON di preview
  this.SPLinker_prev.Link();  
}
function Image_download_Click(){
  this.RTDownload.Link();
}
function SPLinker_elab_Result(result){
  //alert(result);
  if(this.cmbStampa.Value()=="S" || this.cmbStampa.Value()=="R"){
  	this.nomeFile.Value(result);
    this.getTitlePortlet().AppendButton({
      id:"Download",
      title:FormatMsg('Download'),
      tooltip:FormatMsg(''),
      image:{ fontFamily:'ZucchettiDevelopement', value: "&#xebbd;"},
      action:'javascript:' + this.formid +'.Image_download_Click()'
    },3);
  }
  this.enable_input();
  this.PortletLogs.Stop();
  alert("Elaborazione Terminata");
}
function Radio_onChange(){
  if(this.Radio.Value()==='T'){
  	this.Checkbox_elim_anag.Value('false');
    this.Checkbox_elim_anag.Disabled();
  }else{
    this.Checkbox_elim_anag.Enabled();
  } 
}
// disabita imput del portlet
function disable_input(){
  this.getTitlePortlet().RemoveButtons()
}
// abilita input del portlet
function enable_input(){
  this.getTitlePortlet().AppendButton({
    id:"Elabora",
    title:FormatMsg('Elabora'),
    tooltip:FormatMsg('Cancella i record del periodo selezionato'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xeb4a;"},
    action:'javascript:' + this.formid +'.Image_elab_Click()'
  },1);       
  this.getTitlePortlet().AppendButton({
    id:"Anteprima",
    title:FormatMsg('Anteprima'),
    tooltip:FormatMsg('Anteprima dei dati che verranno elaborati'),
    image:{ fontFamily:'ZucchettiDevelopement', value: "&#xe9b5;"},
    action:'javascript:' + this.formid +'.Image_prev_Click()'
  },2);
}
// inizializza le date nel portlet
function set_date(){
	date_10 = new Date();
  date_10.setDate(date_10.getDate() - 1); // vado a ieri
  date_10.setYear(date_10.getUTCFullYear()-10); // vado a ieri 10 anni fa
  this.Textbox_a_data.Value(date_10.getUTCDate()+'-'+(date_10.getUTCMonth()+1)+'-'+date_10.getUTCFullYear());  
}
// controlla le date nelle check box
function check_dates(){
  da_data = this.Textbox_da_data.Value(); 
  a_data = this.Textbox_a_data.Value();
  if(a_data === null || (da_data != null && a_data === null)){return false;}
  if(da_data === null && a_data != null){return a_data.getTime()<=date_10.getTime()}  
  if(da_data != null && a_data != null){return da_data.getTime()>a_data.getTime()?false:a_data.getTime()<=date_10.getTime()}
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
.pg_storico_container {
  height:100%;
  overflow:auto;
}
.pg_storico_title_container {
  margin: auto;
}
.pg_storico_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:100%;
}
.pg_storico_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.pg_storico_portlet > .PortletLogs_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:321px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  bottom:-1px;
  width:auto;
}
.pg_storico_portlet > .chkAGE_ctrl {
  box-sizing:border-box;
  z-index:31;
  position:absolute;
  display:inline-block;
  top:225px;
  left:425px;
  left:53.125%;
  right:229px;
  right:28.625%;
  width:auto;
  height:20px;
}
.pg_storico_portlet > .Radio_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:73px;
  left:162px;
  left:20.25%;
  right:200px;
  right:25.0%;
  width:auto;
  height:20px;
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_da_data_ctrl {
  box-sizing:border-box;
  z-index:11;
  position:absolute;
  display:inline-block;
  top:160px;
  left:211px;
  left:26.375%;
  right:410px;
  right:51.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_da_data_ctrl {
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_da_data_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_storico_portlet > .Textbox_da_data_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:160px;
  left:394px;
  left:49.25%;
  right:325px;
  right:40.625%;
  width:auto;
  height:20px;
}
.pg_storico_portlet > .Textbox_da_data_ctrl {
}
.pg_storico_portlet > .Textbox_da_data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_storico_portlet > .Label_a_data_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:185px;
  left:211px;
  left:26.375%;
  right:410px;
  right:51.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_a_data_ctrl {
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_a_data_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_storico_portlet > .Textbox_a_data_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:185px;
  left:394px;
  left:49.25%;
  right:325px;
  right:40.625%;
  width:auto;
  height:20px;
}
.pg_storico_portlet > .Textbox_a_data_ctrl {
}
.pg_storico_portlet > .Textbox_a_data_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_storico_portlet > .Calendario12_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:160px;
  left:479px;
  left:59.875%;
  right:290px;
  right:36.25%;
  width:auto;
  height:19px;
}
.pg_storico_portlet > .Calendario13_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:185px;
  left:479px;
  left:59.875%;
  right:290px;
  right:36.25%;
  width:auto;
  height:19px;
}
.pg_storico_portlet > .Label_nota_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:292px;
  left:2px;
  left:0.25%;
  right:-1px;
  right:-0.125%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_nota_ctrl {
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_nota_ctrl {
  overflow:hidden;
  color:#FF0000;
  text-align:center;
}
.pg_storico_portlet > .Checkbox_elim_anag_ctrl {
  box-sizing:border-box;
  z-index:23;
  position:absolute;
  display:inline-block;
  top:111px;
  left:159px;
  left:19.875%;
  right:243px;
  right:30.375%;
  width:auto;
  height:20px;
}
.pg_storico_portlet > .Label_desci_ctrl {
  box-sizing:border-box;
  z-index:25;
  position:absolute;
  display:inline-block;
  top:21px;
  left:159px;
  left:19.875%;
  right:201px;
  right:25.125%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_desci_ctrl {
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label_desci_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_storico_portlet > .cmbStampa_ctrl {
  box-sizing:border-box;
  z-index:29;
  position:absolute;
  display:inline-block;
  top:257px;
  left:226px;
  left:28.25%;
  right:139px;
  right:17.375%;
  width:auto;
  height:22px;
}
.pg_storico_portlet > .Label23_ctrl {
  box-sizing:border-box;
  z-index:30;
  position:absolute;
  display:inline-block;
  top:258px;
  left:22px;
  left:2.75%;
  right:578px;
  right:72.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label23_ctrl {
  height:auto;
  min-height:20px;
}
.pg_storico_portlet > .Label23_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_storico_portlet > .chkAUI_ctrl {
  box-sizing:border-box;
  z-index:31;
  position:absolute;
  display:inline-block;
  top:225px;
  left:258px;
  left:32.25%;
  right:433px;
  right:54.125%;
  width:auto;
  height:20px;
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
 String def="[{\"h\":\"410\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)-bottom\",\"h\":\"90\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"800\",\"x\":\"0\",\"y\":\"321\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Agenzia Entrate\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"146\",\"x\":\"425\",\"y\":\"225\",\"zindex\":\"31\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Radio\",\"w\":\"438\",\"x\":\"162\",\"y\":\"73\",\"zindex\":\"8\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Da Data Registrazione:\",\"w\":\"179\",\"x\":\"211\",\"y\":\"160\",\"zindex\":\"11\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_da_data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"81\",\"x\":\"394\",\"y\":\"160\",\"zindex\":\"13\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_a_data\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"A Data Registrazione:\",\"w\":\"179\",\"x\":\"211\",\"y\":\"185\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"Textbox_a_data\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"81\",\"x\":\"394\",\"y\":\"185\",\"zindex\":\"15\"},{\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"name\":\"Calendario12\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"31\",\"x\":\"479\",\"y\":\"160\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"name\":\"Calendario13\",\"page\":\"1\",\"type\":\"Calendario\",\"w\":\"31\",\"x\":\"479\",\"y\":\"185\",\"zindex\":\"17\"},{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_nota\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ATTENZIONE\\\\n si possono cancellare solo le Operazioni\\u002fFrazionate che hanno Data Registrazione di almeno 10 Anni precedente la Data Odierna\",\"w\":\"799\",\"x\":\"2\",\"y\":\"292\",\"zindex\":\"18\"},{\"h\":\"20\",\"name\":\"SPLinker_elab\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"832\",\"y\":\"60\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"Elimina anagrafiche collegate\",\"layout_steps_values\":{},\"name\":\"Checkbox_elim_anag\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"398\",\"x\":\"159\",\"y\":\"111\",\"zindex\":\"23\"},{\"h\":\"20\",\"name\":\"SPLinker_prev\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"973\",\"y\":\"60\"},{\"h\":\"20\",\"name\":\"chi_chiama_il_portlet\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"148\",\"x\":\"828\",\"y\":\"21\"},{\"anchor\":\"\",\"h\":\"100\",\"layout_steps_values\":{},\"name\":\"Note19\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"Portlet parametrizzato, se chiamato da AUI ti fa storicizzare e eliminare, se chiamato da Storico ti fa solamente eliminare\",\"w\":\"258\",\"x\":\"829\",\"y\":\"-95\",\"zindex\":\"24\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label_desci\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"440\",\"x\":\"159\",\"y\":\"21\",\"zindex\":\"25\"},{\"h\":\"20\",\"name\":\"Variable_today\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"991\",\"y\":\"19\"},{\"h\":\"20\",\"name\":\"RTDownload\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"831\",\"y\":\"93\"},{\"h\":\"20\",\"name\":\"nomeFile\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"976\",\"y\":\"91\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"cmbStampa\",\"page\":\"1\",\"textlist\":\"Elaborazione trasferimenti\\u002fcancellazioni senza stampa riepilogo,Elaborazione con Stampa elenco trasferimenti\\u002fcancellazioni finale,Stampa solo elenco trasferimenti\\u002fcancellazioni\",\"type\":\"Combobox\",\"w\":\"435\",\"x\":\"226\",\"y\":\"257\",\"zindex\":\"29\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label23\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Elaborazione:\",\"w\":\"200\",\"x\":\"22\",\"y\":\"258\",\"zindex\":\"30\"},{\"anchor\":\"\",\"h\":\"20\",\"label_text\":\"A.U.I.\",\"layout_steps_values\":{},\"name\":\"chkAUI\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"109\",\"x\":\"258\",\"y\":\"225\",\"zindex\":\"31\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_storico","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_storico_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_storico','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String chkAGE="N";
String Radio="D";
String Label_da_data= "Da Data Registrazione:";
java.sql.Date Textbox_da_data= JSPLib.NullDate();
if(request.getAttribute("pg_storico_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label_a_data= "A Data Registrazione:";
java.sql.Date Textbox_a_data= JSPLib.NullDate();
if(request.getAttribute("pg_storico_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>'></script>
<%}
String Label_nota= "ATTENZIONE\n si possono cancellare solo le Operazioni/Frazionate che hanno Data Registrazione di almeno 10 Anni precedente la Data Odierna";
boolean Checkbox_elim_anag= false;
String chi_chiama_il_portlet=JSPLib.translateXSS(sp.getParameter("chi_chiama_il_portlet",""));
String Label_desci= "";
java.sql.Date Variable_today= JSPLib.NullDate();
String nomeFile= "";
String cmbStampa="R";
String Label23= "Tipo Elaborazione:";
String chkAUI="S";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_storico_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_storico_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_storico_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_storico','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_PortletLogs'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/pg_logs_portlet.jsp?ForcedPortletUID="+idPortlet+"_13wmc2x",false);%></div>
<div id='<%=idPortlet%>_chkAGE_div' style=''><input id='<%=idPortlet%>_chkAGE' name='chkAGE' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkAGE' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("Agenzia Entrate")%></label></div>
<div id='<%=idPortlet%>_Radio' class='radio' style='z-index:1;'></div>
<span id='<%=idPortlet%>_Label_da_data'  formid='<%=idPortlet%>' ps-name='Label_da_data'    class='label Label_da_data_ctrl'><div id='<%=idPortlet%>_Label_da_datatbl' style='width:100%;'><%=JSPLib.ToHTML("Da Data Registrazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_da_data_wrp'><input id='<%=idPortlet%>_Textbox_da_data' name='Textbox_da_data' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_da_data' /></span>
<span id='<%=idPortlet%>_Label_a_data'  formid='<%=idPortlet%>' ps-name='Label_a_data'    class='label Label_a_data_ctrl'><div id='<%=idPortlet%>_Label_a_datatbl' style='width:100%;'><%=JSPLib.ToHTML("A Data Registrazione:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_Textbox_a_data_wrp'><input id='<%=idPortlet%>_Textbox_a_data' name='Textbox_a_data' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='Textbox_a_data' /></span>
<a href='javascript:void(0)' id='<%=idPortlet%>_Calendario12' class='calendar' onclick='window.<%=idPortlet%>.Calendario12.PopupCalendar();' style='text-decoration:none;'></a>
 <a href='javascript:void(0)' id='<%=idPortlet%>_Calendario13' class='calendar' onclick='window.<%=idPortlet%>.Calendario13.PopupCalendar();' style='text-decoration:none;'></a>
 <span id='<%=idPortlet%>_Label_nota'  formid='<%=idPortlet%>' ps-name='Label_nota'    class='label Label_nota_ctrl'><div id='<%=idPortlet%>_Label_notatbl' style='width:100%;'><%=JSPLib.ToHTML("ATTENZIONE\n si possono cancellare solo le Operazioni/Frazionate che hanno Data Registrazione di almeno 10 Anni precedente la Data Odierna")%></div></span>
<div id='<%=idPortlet%>_Checkbox_elim_anag_div' style=''><input id='<%=idPortlet%>_Checkbox_elim_anag' name='Checkbox_elim_anag' class='checkbox' style='vertical-align:middle' type='checkbox' title=<%=JSPLib.ToHTMLValue("Elimina le anagrafiche dopo la cancellazione delle operazioni che non sono più collegate a niente." )%> /><label for='<%=idPortlet%>_Checkbox_elim_anag' class='label' title=<%=JSPLib.ToHTMLValue("Elimina le anagrafiche dopo la cancellazione delle operazioni che non sono più collegate a niente." )%> style:'vertical-align:middle;'><%=JSPLib.ToHTML("Elimina anagrafiche collegate")%></label></div>
<span id='<%=idPortlet%>_Label_desci'  formid='<%=idPortlet%>' ps-name='Label_desci'    class='label Label_desci_ctrl'><div id='<%=idPortlet%>_Label_descitbl' style='width:100%;'></div></span>
<select id='<%=idPortlet%>_cmbStampa' name='cmbStampa' class='combobox' style=''></select>
<span id='<%=idPortlet%>_Label23'  formid='<%=idPortlet%>' ps-name='Label23'    class='label Label23_ctrl'><div id='<%=idPortlet%>_Label23tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Elaborazione:")%></div></span>
<div id='<%=idPortlet%>_chkAUI_div' style=''><input id='<%=idPortlet%>_chkAUI' name='chkAUI' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_chkAUI' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("A.U.I.")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_storico');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("",true)+","+JSPLib.ToJSValue(sp.translate(""),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Anteprima",true)+","+JSPLib.ToJSValue(sp.translate("Anteprima"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Anteprima dei dati che verranno elaborati",true)+","+JSPLib.ToJSValue(sp.translate("Anteprima dei dati che verranno elaborati"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Cancella i record del periodo selezionato",true)+","+JSPLib.ToJSValue(sp.translate("Cancella i record del periodo selezionato"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Download",true)+","+JSPLib.ToJSValue(sp.translate("Download"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("Elabora",true)+","+JSPLib.ToJSValue(sp.translate("Elabora"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_storico',["800"],["410"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"410","title":"","layer":""}]);
if(this.PortletLogs=ZtVWeb.getPortletInc('<%=idPortlet%>_PortletLogs')){
this.PortletLogs.setContainer(this,'PortletLogs')
this.PortletLogs_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)-bottom","ctrlid":"<%=idPortlet%>_PortletLogs","h":90,"hide":"false","layer":false,"layout_steps_values":{},"name":"PortletLogs","page":1,"portlet_id":"<%=idPortlet%>_13wmc2x","spuid":"","type":"Portlet","w":800,"x":0,"y":321,"zindex":"6"});
} else {
document.getElementById('<%=idPortlet%>_PortletLogs').style.display='none';
}
this.chkAGE=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkAGE","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"N","label_text":"Agenzia Entrate","layer":false,"layout_steps_values":{},"name":"chkAGE","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":146,"x":425,"y":225,"zindex":"31"});
this.chkAGE.Value('<%=chkAGE%>');
this.Radio=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Trasferimento a Storico,Cancellazione","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_Radio","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":20,"helptipsList":"","hide":"false","hide_undercond":"","init":"false","init_par":"'D'","layer":false,"layout_steps_values":{},"name":"Radio","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"1","type":"Radio","typevar":"character","valuesList":"T,C","visible":true,"w":438,"x":162,"y":73,"zindex":"8"});
this.Radio.Value('<%=JSPLib.ToJSValue(Radio,false,true)%>');
this.Label_da_data=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_da_data","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_da_data","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_da_data,false,true)%>","type":"Label","w":179,"x":211,"y":160,"zindex":"11"});
this.Textbox_da_data=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_da_data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_da_data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_da_data%>","w":81,"x":394,"y":160,"zerofilling":false,"zindex":"13","zoom":""});
this.Label_a_data=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_a_data","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_a_data","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_a_data,false,true)%>","type":"Label","w":179,"x":211,"y":185,"zindex":"14"});
this.Textbox_a_data=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_Textbox_a_data","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"","floating_placeholder":false,"h":20,"help_tips":"La data può essere al massimo la data di ieri di dieci anni fa","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"Textbox_a_data","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"date","value":"<%=Textbox_a_data%>","w":81,"x":394,"y":185,"zerofilling":false,"zindex":"15","zoom":""});
this.Calendario12=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario12','Calendario12',479,160,31,19,'','','top-left(%)-right(%)','true','Textbox_da_data',{});
this.Calendario13=new ZtVWeb.CalendarioCtrl(this,'<%=idPortlet%>_Calendario13','Calendario13',479,185,31,19,'','','top-left(%)-right(%)','true','Textbox_a_data',{});
this.Label_nota=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_nota","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"#FF0000","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_nota","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_nota,false,true)%>","type":"Label","w":799,"x":2,"y":292,"zindex":"18"});
this.SPLinker_elab=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_stor_trasf",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_elab","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_elab","offline":false,"page":1,"parms":"w_chi_chiama_la_routine=chi_chiama_il_portlet,w_tipoope=Radio,w_DaDatOpe=Textbox_da_data,w_ADatOpe=Textbox_a_data,w_anag_colleg=Checkbox_elim_anag,w_stampa=cmbStampa,w_today_caller=Variable_today,w_chkAUI=chkAUI,w_chkAGE=chkAGE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_stor_trasf","target":"","type":"SPLinker","w":120,"x":832,"y":60});
this.SPLinker_elab.m_cID='<%=JSPLib.cmdHash("routine,arrt_stor_trasf",request.getSession())%>';
this.Checkbox_elim_anag=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"true","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_Checkbox_elim_anag","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"","label_text":"Elimina anagrafiche collegate","layer":false,"layout_steps_values":{},"name":"Checkbox_elim_anag","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"logic","unchecked_value":"false","w":398,"x":159,"y":111,"zindex":"23"});
this.SPLinker_prev=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"<%=JSPLib.encrypt("pg_storico_preview_portlet.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_prev","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_prev","offline":false,"page":1,"parms":"da_data=Textbox_da_data,a_data=Textbox_a_data","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"true","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"pg_storico_preview_portlet.jsp","target":"","type":"SPLinker","w":120,"x":973,"y":60});
this.SPLinker_prev.m_cID='<%=JSPLib.cmdHash("entity,pg_storico_preview_portlet.jsp",request.getSession())%>';
this.chi_chiama_il_portlet=new ZtVWeb._VC(this,'chi_chiama_il_portlet',null,'character','<%=JSPLib.ToJSValue(chi_chiama_il_portlet,false,true)%>',false,false);
this.Label_desci=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label_desci","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label_desci","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label_desci,false,true)%>","type":"Label","w":440,"x":159,"y":21,"zindex":"25"});
this.Variable_today=new ZtVWeb._VC(this,'Variable_today',null,'date','<%=Variable_today%>',false,false);
this.RTDownload=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("arrt_downloadxlsx",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDownload","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDownload","offline":false,"page":1,"parms":"pFile=nomeFile,pCartella=appo","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_downloadxlsx","target":"","type":"SPLinker","w":120,"x":831,"y":93});
this.RTDownload.m_cID='<%=JSPLib.cmdHash("routine,arrt_downloadxlsx",request.getSession())%>';
this.nomeFile=new ZtVWeb._VC(this,'nomeFile',null,'character','<%=JSPLib.ToJSValue(nomeFile,false,true)%>',false,false);
this.cmbStampa=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbStampa","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbStampa%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbStampa","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Elaborazione trasferimenti\u002fcancellazioni senza stampa riepilogo,Elaborazione con Stampa elenco trasferimenti\u002fcancellazioni finale,Stampa solo elenco trasferimenti\u002fcancellazioni","type":"Combobox","typevar":"character","valuelist":"E,S,R","visible":true,"w":435,"x":226,"y":257,"zindex":"29"});
this.Label23=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label23","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label23","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label23,false,true)%>","type":"Label","w":200,"x":22,"y":258,"zindex":"30"});
this.chkAUI=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkAUI","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"","init_par":"S","label_text":"A.U.I.","layer":false,"layout_steps_values":{},"name":"chkAUI","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":109,"x":258,"y":225,"zindex":"31"});
this.chkAUI.Value('<%=chkAUI%>');
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
<%if(request.getAttribute("pg_storico_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_storico_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_storico_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.cmbStampa.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_storico',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_storico');
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
sp.endPage("pg_storico");
}%>
<%! public String getJSPUID() { return "344002387"; } %>