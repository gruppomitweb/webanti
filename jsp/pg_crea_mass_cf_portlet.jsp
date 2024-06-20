<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.RTClean.Link();\n  this.getTitlePortlet().SetTitle(\"CREAZIONE FILE CONTROLLO MASSIVO CODICI FISCALI\",true)\n  this.btnDown.Hide()\n}\n\nfunction btnElab_Click(){\n  if (confirm(\"Confermi l'estrazione dei dati?\")) {\n    this.pLog.Timer0.Start()    \n    this.pMsg.Timer0.Start()     \n    this.RTExec.Link();  \n  }  \n}\n\nfunction RTExec_Result(result){\n  this.pMsg.Timer0_onTimer();\n  this.pMsg.Timer0.Stop()\n  this.pLog.Timer0_onTimer();\n  this.pLog.Timer0.Stop()        \n  if (result=='OK') {\n    this.btnDown.Show()\n    alert(\"Creazione file completata con successo!\");\n  } else { \n    alert(result)\n  }\n  alert(\"Elaborazione Completata!\");\n}\n\nfunction btnExit_Click(){ \n  this.RTEsci.Link();\n}\n\nfunction btnCalcola_Click(){\n  if (this.rTipoinv.Value()!='G') {\n    if (confirm(\"Vuoi calcolare il numero di record massimo?\")){\n      this.maxinvii.Value(this.RTCalcola.Link())\n    }  \n  }  \n}\n\nfunction btnDown_Click(){\n  this.RTDown.Link()  \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Creazione Operazioni ExtraConto da AUI\u002fAGE","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"380","hsl":"false","htmlcode":"{{ @a2022 }}\n{{ @btnDown }}\n{{ @rTipoinv }}\n{{ @a2021 }}\n{{ @a2020 }}\n{{ @a2019 }}\n{{ @a2018 }}\n{{ @a2017 }}\n{{ @a2016 }}\n{{ @a2015 }}\n{{ @a2014 }}\n{{ @a2013 }}\n{{ @btnCalcola }}\n{{ @Label44 }}\n{{ @maxinvii }}\n{{ @Label42 }}\n{{ @pMsg }}\n{{ @Label41 }}\n{{ @pLog }}\n{{ @cmbTipoSog }}\n{{ @btnExit }}\n{{ @btnElab }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"arfn_finemese.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Esegui l'elaborazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnElab","page":"1","path_type":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"725","y":"10","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Chiudi la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnExit","page":"1","path_type":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"764","y":"10","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"30","m_cAction":"","name":"RTEsci","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"63","x":"3","y":"-67"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"RTDown","offline":"false","page":"1","parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":"80","x":"251","y":"-66"},{"allowedentities":"arrt_crea_mass_cf","async":"true","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTExec","offline":"false","page":"1","parms":"w_tiposog=cmbTipoSog,w_tipoinv=rTipoinv,w_maxinvii=maxinvii,w_a2013=a2013,w_a2014=a2014,w_a2015=a2015,w_a2016=a2016,w_a2017=a2017,w_a2018=a2018,w_a2019=a2019,w_a2020=a2020,w_a2021=a2021,w_a2022=a2022","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_crea_mass_cf","target":"","type":"SPLinker","w":"75","x":"73","y":"-67"},{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlOfVariant":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"T","layer":"false","layout_steps_values":"{}","name":"cmbTipoSog","page":"1","picture":"","sequence":"6","spuid":"","tabindex":"","textlist":"Solo Soggetti con Codice Fiscale,Solo Soggetti senza Codice Fiscale,Tutti i Soggetti,Tutti i soggetti (Prima quelli senza e poi quelli con codice fiscale),Tutti i soggetti (Prima quelli con e poi quelli senza codice fiscale)","type":"Combobox","typevar":"character","valuelist":"C,E,T,1,2","visible":"true","w":"641","wireframe_props":"name,textlist","x":"145","y":"69","zindex":"13"},{"anchor":"","ctrlOfVariant":"","h":"128","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"7","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"155","zindex":""},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"22","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label41","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"8","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Selezione Soggetti:","w":"141","wireframe_props":"align,value,n_col","x":"4","y":"70","zindex":"14"},{"anchor":"","ctrlOfVariant":"","h":"63","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"9","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"793","wireframe_props":"","x":"3","y":"284","zindex":""},{"align":"left","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label42","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"10","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Anni di riferimento per la selezione dei soggetti da cui inviare i dati","w":"636","wireframe_props":"align,value,n_col","x":"4","y":"102","zindex":"15"},{"anchor":"top-left","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"22","help_tips":"","hide":"false","hide_undercond":"rTipoinv='G'","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"maxinvii","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"11","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"95","wireframe_props":"name","x":"209","y":"41","zerofilling":"false","zindex":"16"},{"align":"right","anchor":"top-left","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"rTipoinv='G'","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label44","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"N. Massimo Invii Effettuabili:","w":"200","wireframe_props":"align,value,n_col","x":"6","y":"42","zindex":"17"},{"alt":"","anchor":"top-left","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea9e;","font_image_hover":"&#xea9f;","font_name":"ZucchettiDevelopement","font_size":"","h":"22","help_tips":"Calcola il numero massimo di invii","hide":"false","hide_undercond":"rTipoinv='G'","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnCalcola","page":"1","path_type":"","sequence":"13","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"22","wireframe_props":"","x":"309","y":"41","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTClean","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":"82","x":"154","y":"-65"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTCalcola","offline":"false","page":"1","parms":"w_tipoinv=rTipoinv","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arrt_mass_cf_calcola_max","target":"","type":"SPLinker","w":"80","x":"357","y":"-59"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2013","layer":"false","layout_steps_values":"{}","name":"a2013","page":"1","sequence":"16","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"9","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2014","layer":"false","layout_steps_values":"{}","name":"a2014","page":"1","sequence":"17","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"80","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2015","layer":"false","layout_steps_values":"{}","name":"a2015","page":"1","sequence":"18","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"151","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2016","layer":"false","layout_steps_values":"{}","name":"a2016","page":"1","sequence":"19","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"222","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2017","layer":"false","layout_steps_values":"{}","name":"a2017","page":"1","sequence":"20","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"293","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2018","layer":"false","layout_steps_values":"{}","name":"a2018","page":"1","sequence":"21","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"364","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2019","layer":"false","layout_steps_values":"{}","name":"a2019","page":"1","sequence":"22","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"435","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2020","layer":"false","layout_steps_values":"{}","name":"a2020","page":"1","sequence":"23","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"506","y":"128","zindex":"4"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2021","layer":"false","layout_steps_values":"{}","name":"a2021","page":"1","sequence":"24","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"577","y":"128","zindex":"4"},{"anchor":"","calculate":"","class_Css":"radio","create_undercond":"","ctrlOfVariant":"","dataobj":"","disabled":"false","edit_undercond":"","field":"","font":"","font_size":"","h":"28","helptipslist":"","hide":"false","hide_undercond":"","init":"","init_par":"S","layer":"false","layout_steps_values":"{}","name":"rTipoinv","orientation":"horizontal","page":"1","picture":"","sequence":"25","spuid":"","tabindex":"","textlist":"Invio Globale,Primo Invio (Limitato),Invii Successivi","type":"Radio","typevar":"character","valuelist":"G,P,S","visible":"true","w":"408","wireframe_props":"","x":"6","y":"9","zindex":"10"},{"alt":"","anchor":"top-right","bounded_position":"right","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Preleva il file da inviare","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"bounded","layer":"false","layout_steps_values":"{}","name":"btnDown","page":"1","path_type":"","sequence":"26","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"685","y":"10","zindex":"1"},{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2022","layer":"false","layout_steps_values":"{}","name":"a2022","page":"1","sequence":"28","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"63","wireframe_props":"label_text","x":"648","y":"128","zindex":"4"}]%>
<%/*Description:Creazione Operazioni ExtraConto da AUI/AGE*/%>
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
window.pg_crea_mass_cf_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnElab_Click !='undefined')this.btnElab_Click=btnElab_Click;
if(typeof RTExec_Result !='undefined')this.RTExec_Result=RTExec_Result;
if(typeof btnExit_Click !='undefined')this.btnExit_Click=btnExit_Click;
if(typeof btnCalcola_Click !='undefined')this.btnCalcola_Click=btnCalcola_Click;
if(typeof btnDown_Click !='undefined')this.btnDown_Click=btnDown_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_HideUnderCondition=function(){
ZtVWeb.HideCtrl(Eq(this.rTipoinv.Value(),'G'),this.maxinvii);
ZtVWeb.HideCtrl(Eq(this.rTipoinv.Value(),'G'),this.Label44);
ZtVWeb.HideCtrl(Eq(this.rTipoinv.Value(),'G'),this.btnCalcola);
}
ZtVWeb.InitCtrl('S',this.a2013);
ZtVWeb.InitCtrl('S',this.a2014);
ZtVWeb.InitCtrl('S',this.a2015);
ZtVWeb.InitCtrl('S',this.a2016);
ZtVWeb.InitCtrl('S',this.a2017);
ZtVWeb.InitCtrl('S',this.a2018);
ZtVWeb.InitCtrl('S',this.a2019);
ZtVWeb.InitCtrl('S',this.a2020);
ZtVWeb.InitCtrl('S',this.a2021);
ZtVWeb.InitCtrl('S',this.a2022);
function this_Loaded(){
  this.RTClean.Link();
  this.getTitlePortlet().SetTitle("CREAZIONE FILE CONTROLLO MASSIVO CODICI FISCALI",true)
  this.btnDown.Hide()
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
  if (result=='OK') {
    this.btnDown.Show()
    alert("Creazione file completata con successo!");
  } else { 
    alert(result)
  }
  alert("Elaborazione Completata!");
}
function btnExit_Click(){ 
  this.RTEsci.Link();
}
function btnCalcola_Click(){
  if (this.rTipoinv.Value()!='G') {
    if (confirm("Vuoi calcolare il numero di record massimo?")){
      this.maxinvii.Value(this.RTCalcola.Link())
    }  
  }  
}
function btnDown_Click(){
  this.RTDown.Link()  
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
.pg_crea_mass_cf_container {
}
.pg_crea_mass_cf_title_container {
  margin: auto;
}
.pg_crea_mass_cf_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:800px;
  height:380px;
}
.pg_crea_mass_cf_portlet[Data-page="1"]{
  height:380px;
  width:100%;
}
.pg_crea_mass_cf_portlet > .btnElab_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:45px;
  width:30px;
  height:30px;
}
.pg_crea_mass_cf_portlet > .btnElab_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_crea_mass_cf_portlet > .btnExit_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_crea_mass_cf_portlet > .btnExit_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_crea_mass_cf_portlet > .cmbTipoSog_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:69px;
  left:145px;
  width:641px;
  height:22px;
}
.pg_crea_mass_cf_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:155px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:128px;
}
.pg_crea_mass_cf_portlet > .Label41_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:70px;
  left:4px;
  width:141px;
  height:auto;
  min-height:22px;
}
.pg_crea_mass_cf_portlet > .Label41_ctrl {
  height:auto;
  min-height:22px;
}
.pg_crea_mass_cf_portlet > .Label41_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_crea_mass_cf_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:284px;
  left:3px;
  left:0.375%;
  right:4px;
  right:0.5%;
  width:auto;
  height:auto;
  min-height:63px;
}
.pg_crea_mass_cf_portlet > .Label42_ctrl {
  box-sizing:border-box;
  z-index:15;
  position:absolute;
  display:inline-block;
  top:102px;
  left:4px;
  width:636px;
  height:auto;
  min-height:20px;
}
.pg_crea_mass_cf_portlet > .Label42_ctrl {
  height:auto;
  min-height:20px;
}
.pg_crea_mass_cf_portlet > .Label42_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_crea_mass_cf_portlet > .maxinvii_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:41px;
  left:209px;
  width:95px;
  height:22px;
}
.pg_crea_mass_cf_portlet > .maxinvii_ctrl {
  display:none;
}
.pg_crea_mass_cf_portlet > .maxinvii_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_crea_mass_cf_portlet > .Label44_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:42px;
  left:6px;
  width:200px;
  height:auto;
  min-height:20px;
}
.pg_crea_mass_cf_portlet > .Label44_ctrl {
  height:auto;
  min-height:20px;
}
.pg_crea_mass_cf_portlet > .Label44_ctrl {
  overflow:hidden;
  display:none;
  text-align:right;
}
.pg_crea_mass_cf_portlet > .btnCalcola_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:41px;
  left:309px;
  width:22px;
  height:22px;
}
.pg_crea_mass_cf_portlet > .btnCalcola_ctrl {
  display:none;
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:22px;
  font-size:22px;
}
.pg_crea_mass_cf_portlet > .a2013_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:9px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2014_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:80px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2015_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:151px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2016_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:222px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2017_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:293px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2018_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:364px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2019_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:435px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2020_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:506px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .a2021_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:577px;
  width:63px;
  height:20px;
}
.pg_crea_mass_cf_portlet > .rTipoinv_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:9px;
  left:6px;
  left:0.75%;
  right:386px;
  right:48.25%;
  width:auto;
  height:28px;
  height:auto;
  min-height:28px;
}
.pg_crea_mass_cf_portlet > .btnDown_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  right:85px;
  width:30px;
  height:30px;
}
.pg_crea_mass_cf_portlet > .btnDown_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_crea_mass_cf_portlet > .a2022_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:128px;
  left:648px;
  width:63px;
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
 String def="[{\"h\":\"380\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"725\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"764\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"63\",\"x\":\"3\",\"y\":\"-67\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"80\",\"x\":\"251\",\"y\":\"-66\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"75\",\"x\":\"73\",\"y\":\"-67\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"cmbTipoSog\",\"page\":\"1\",\"textlist\":\"Solo Soggetti con Codice Fiscale,Solo Soggetti senza Codice Fiscale,Tutti i Soggetti,Tutti i soggetti (Prima quelli senza e poi quelli con codice fiscale),Tutti i soggetti (Prima quelli con e poi quelli senza codice fiscale)\",\"type\":\"Combobox\",\"w\":\"641\",\"x\":\"145\",\"y\":\"69\",\"zindex\":\"13\"},{\"anchor\":\"\",\"h\":\"128\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"155\",\"zindex\":\"\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label41\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Selezione Soggetti:\",\"w\":\"141\",\"x\":\"4\",\"y\":\"70\",\"zindex\":\"14\"},{\"anchor\":\"\",\"h\":\"63\",\"layout_steps_values\":{},\"name\":\"pMsg\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"793\",\"x\":\"3\",\"y\":\"284\",\"zindex\":\"\"},{\"align\":\"left\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label42\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Anni di riferimento per la selezione dei soggetti da cui inviare i dati\",\"w\":\"636\",\"x\":\"4\",\"y\":\"102\",\"zindex\":\"15\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"maxinvii\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"95\",\"x\":\"209\",\"y\":\"41\",\"zindex\":\"16\"},{\"align\":\"right\",\"anchor\":\"top-left\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label44\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"N. Massimo Invii Effettuabili:\",\"w\":\"200\",\"x\":\"6\",\"y\":\"42\",\"zindex\":\"17\"},{\"anchor\":\"top-left\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"btnCalcola\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"22\",\"x\":\"309\",\"y\":\"41\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RTClean\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"82\",\"x\":\"154\",\"y\":\"-65\"},{\"h\":\"20\",\"name\":\"RTCalcola\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"80\",\"x\":\"357\",\"y\":\"-59\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2013\",\"layout_steps_values\":{},\"name\":\"a2013\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"9\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2014\",\"layout_steps_values\":{},\"name\":\"a2014\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"80\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2015\",\"layout_steps_values\":{},\"name\":\"a2015\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"151\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2016\",\"layout_steps_values\":{},\"name\":\"a2016\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"222\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2017\",\"layout_steps_values\":{},\"name\":\"a2017\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"293\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2018\",\"layout_steps_values\":{},\"name\":\"a2018\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"364\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2019\",\"layout_steps_values\":{},\"name\":\"a2019\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"435\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2020\",\"layout_steps_values\":{},\"name\":\"a2020\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"506\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2021\",\"layout_steps_values\":{},\"name\":\"a2021\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"577\",\"y\":\"128\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"28\",\"layout_steps_values\":{},\"name\":\"rTipoinv\",\"page\":\"1\",\"textlist\":\"Invio Globale,Primo Invio (Limitato),Invii Successivi\",\"type\":\"Radio\",\"w\":\"408\",\"x\":\"6\",\"y\":\"9\",\"zindex\":\"10\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"btnDown\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"685\",\"y\":\"10\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"20\",\"label_text\":\"2022\",\"layout_steps_values\":{},\"name\":\"a2022\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"63\",\"x\":\"648\",\"y\":\"128\",\"zindex\":\"4\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_crea_mass_cf","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_crea_mass_cf_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_crea_mass_cf','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String cmbTipoSog="T";
String Label41= "Selezione Soggetti:";
String Label42= "Anni di riferimento per la selezione dei soggetti da cui inviare i dati";
String maxinvii= "";
if(request.getAttribute("pg_crea_mass_cf_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label44= "N. Massimo Invii Effettuabili:";
String a2013="N";
String a2014="N";
String a2015="N";
String a2016="N";
String a2017="N";
String a2018="N";
String a2019="N";
String a2020="N";
String a2021="N";
String rTipoinv="S";
String a2022="N";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_crea_mass_cf_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_crea_mass_cf_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_crea_mass_cf_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_crea_mass_cf','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_btnElab' class='image btnElab_ctrl'   target=''>&#xeb47;</a>
<a id='<%=idPortlet%>_btnExit' class='image btnExit_ctrl'   target=''>&#xe9fb;</a>
<select id='<%=idPortlet%>_cmbTipoSog' name='cmbTipoSog' class='combobox' style=''></select>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
<span id='<%=idPortlet%>_Label41'  formid='<%=idPortlet%>' ps-name='Label41'    class='label Label41_ctrl'><div id='<%=idPortlet%>_Label41tbl' style='width:100%;'><%=JSPLib.ToHTML("Selezione Soggetti:")%></div></span>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span id='<%=idPortlet%>_Label42'  formid='<%=idPortlet%>' ps-name='Label42'    class='label Label42_ctrl'><div id='<%=idPortlet%>_Label42tbl' style='width:100%;'><%=JSPLib.ToHTML("Anni di riferimento per la selezione dei soggetti da cui inviare i dati")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_maxinvii_wrp'><input id='<%=idPortlet%>_maxinvii' name='maxinvii' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='maxinvii' /></span>
<span id='<%=idPortlet%>_Label44'  formid='<%=idPortlet%>' ps-name='Label44'    class='label Label44_ctrl'><div id='<%=idPortlet%>_Label44tbl' style='width:100%;'><%=JSPLib.ToHTML("N. Massimo Invii Effettuabili:")%></div></span>
<a id='<%=idPortlet%>_btnCalcola' class='image btnCalcola_ctrl'   target=''>&#xea9e;</a>
<div id='<%=idPortlet%>_a2013_div' style=''><input id='<%=idPortlet%>_a2013' name='a2013' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2013' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2013")%></label></div>
<div id='<%=idPortlet%>_a2014_div' style=''><input id='<%=idPortlet%>_a2014' name='a2014' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2014' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2014")%></label></div>
<div id='<%=idPortlet%>_a2015_div' style=''><input id='<%=idPortlet%>_a2015' name='a2015' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2015' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2015")%></label></div>
<div id='<%=idPortlet%>_a2016_div' style=''><input id='<%=idPortlet%>_a2016' name='a2016' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2016' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2016")%></label></div>
<div id='<%=idPortlet%>_a2017_div' style=''><input id='<%=idPortlet%>_a2017' name='a2017' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2017' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2017")%></label></div>
<div id='<%=idPortlet%>_a2018_div' style=''><input id='<%=idPortlet%>_a2018' name='a2018' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2018' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2018")%></label></div>
<div id='<%=idPortlet%>_a2019_div' style=''><input id='<%=idPortlet%>_a2019' name='a2019' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2019' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2019")%></label></div>
<div id='<%=idPortlet%>_a2020_div' style=''><input id='<%=idPortlet%>_a2020' name='a2020' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2020' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2020")%></label></div>
<div id='<%=idPortlet%>_a2021_div' style=''><input id='<%=idPortlet%>_a2021' name='a2021' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2021' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2021")%></label></div>
<div id='<%=idPortlet%>_rTipoinv' class='radio' style='z-index:1;'></div>
<a id='<%=idPortlet%>_btnDown' class='image btnDown_ctrl'   target=''>&#xebbd;</a>
<div id='<%=idPortlet%>_a2022_div' style=''><input id='<%=idPortlet%>_a2022' name='a2022' class='checkbox' style='vertical-align:middle' type='checkbox' /><label for='<%=idPortlet%>_a2022' class='label' style:'vertical-align:middle;'><%=JSPLib.ToHTML("2022")%></label></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_crea_mass_cf');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_crea_mass_cf',["800"],["380"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"800","h":"380","title":"","layer":"false","npage":"1"}]);
this.btnElab=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnElab_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnElab","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb47;","font_image_hover":"&#xeb48;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Esegui l'elaborazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnElab","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeb47;","srchover":"&#xeb48;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":725,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.btnExit=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnExit_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnExit","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Chiudi la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnExit","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":764,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTEsci=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTEsci","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTEsci","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":63,"x":3,"y":-67});
this.RTEsci.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.RTDown=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTDown","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTDown","offline":false,"page":1,"parms":"cartella=flussi,tipo=ZIP","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"list_filesid_portlet.jsp","target":"","type":"SPLinker","w":80,"x":251,"y":-66});
this.RTDown.m_cID='<%=JSPLib.cmdHash("entity,list_filesid_portlet.jsp",request.getSession())%>';
this.RTExec=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_crea_mass_cf",request,"xxxx")%>","anchor":"","async":true,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExec","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExec","offline":false,"page":1,"parms":"w_tiposog=cmbTipoSog,w_tipoinv=rTipoinv,w_maxinvii=maxinvii,w_a2013=a2013,w_a2014=a2014,w_a2015=a2015,w_a2016=a2016,w_a2017=a2017,w_a2018=a2018,w_a2019=a2019,w_a2020=a2020,w_a2021=a2021,w_a2022=a2022","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_crea_mass_cf","target":"","type":"SPLinker","w":75,"x":73,"y":-67});
this.RTExec.m_cID='<%=JSPLib.cmdHash("routine,arrt_crea_mass_cf",request.getSession())%>';
this.cmbTipoSog=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_cmbTipoSog","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=cmbTipoSog%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"cmbTipoSog","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Solo Soggetti con Codice Fiscale,Solo Soggetti senza Codice Fiscale,Tutti i Soggetti,Tutti i soggetti (Prima quelli senza e poi quelli con codice fiscale),Tutti i soggetti (Prima quelli con e poi quelli senza codice fiscale)","type":"Combobox","typevar":"character","valuelist":"C,E,T,1,2","visible":true,"w":641,"x":145,"y":69,"zindex":"13"});
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pLog","h":128,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":793,"x":3,"y":155,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.Label41=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label41","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":22,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label41","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label41,false,true)%>","type":"Label","w":141,"x":4,"y":70,"zindex":"14"});
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left(%)-right(%)","ctrlid":"<%=idPortlet%>_pMsg","h":63,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":793,"x":3,"y":284,"zindex":""});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.Label42=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label42","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label42","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label42,false,true)%>","type":"Label","w":636,"x":4,"y":102,"zindex":"15"});
this.maxinvii=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_maxinvii","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"Eq(this.rTipoinv.Value(),'G')","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"maxinvii","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(maxinvii,false,true)%>","w":95,"x":209,"y":41,"zerofilling":false,"zindex":"16","zoom":""});
this.Label44=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label44","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"rTipoinv='G'","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label44","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label44,false,true)%>","type":"Label","w":200,"x":6,"y":42,"zindex":"17"});
this.btnCalcola=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"right","class_Css":"image btnCalcola_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCalcola","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea9e;","font_image_hover":"&#xea9f;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":22,"help_tips":"<%=JSPLib.ToJSValue("Calcola il numero massimo di invii",false,true)%>","hide":"false","hide_undercond":"Eq(this.rTipoinv.Value(),'G')","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnCalcola","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xea9e;","srchover":"&#xea9f;","tabindex":"","target":"","type":"Image","type_submit":"false","w":22,"x":309,"y":41,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTClean=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTClean","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTClean","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_azzera_messaggi","target":"","type":"SPLinker","w":82,"x":154,"y":-65});
this.RTClean.m_cID='<%=JSPLib.cmdHash("routine,arfn_azzera_messaggi",request.getSession())%>';
this.RTCalcola=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCalcola","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCalcola","offline":false,"page":1,"parms":"w_tipoinv=rTipoinv","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_mass_cf_calcola_max","target":"","type":"SPLinker","w":80,"x":357,"y":-59});
this.RTCalcola.m_cID='<%=JSPLib.cmdHash("routine,arrt_mass_cf_calcola_max",request.getSession())%>';
this.a2013=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2013","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2013","layer":false,"layout_steps_values":{},"name":"a2013","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":9,"y":128,"zindex":"4"});
this.a2013.Value('<%=a2013%>');
this.a2014=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2014","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2014","layer":false,"layout_steps_values":{},"name":"a2014","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":80,"y":128,"zindex":"4"});
this.a2014.Value('<%=a2014%>');
this.a2015=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2015","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2015","layer":false,"layout_steps_values":{},"name":"a2015","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":151,"y":128,"zindex":"4"});
this.a2015.Value('<%=a2015%>');
this.a2016=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2016","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2016","layer":false,"layout_steps_values":{},"name":"a2016","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":222,"y":128,"zindex":"4"});
this.a2016.Value('<%=a2016%>');
this.a2017=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2017","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2017","layer":false,"layout_steps_values":{},"name":"a2017","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":293,"y":128,"zindex":"4"});
this.a2017.Value('<%=a2017%>');
this.a2018=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2018","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2018","layer":false,"layout_steps_values":{},"name":"a2018","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":364,"y":128,"zindex":"4"});
this.a2018.Value('<%=a2018%>');
this.a2019=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2019","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2019","layer":false,"layout_steps_values":{},"name":"a2019","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":435,"y":128,"zindex":"4"});
this.a2019.Value('<%=a2019%>');
this.a2020=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2020","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2020","layer":false,"layout_steps_values":{},"name":"a2020","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":506,"y":128,"zindex":"4"});
this.a2020.Value('<%=a2020%>');
this.a2021=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2021","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2021","layer":false,"layout_steps_values":{},"name":"a2021","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":577,"y":128,"zindex":"4"});
this.a2021.Value('<%=a2021%>');
this.rTipoinv=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","captionsList":"Invio Globale,Primo Invio (Limitato),Invii Successivi","class_Css":"radio","create_undercond":"","ctrlid":"<%=idPortlet%>_rTipoinv","decrypt":false,"disabled":false,"edit_undercond":"","encrypt":false,"field":"","font":"","font_size":"","h":28,"helptipsList":"","hide":"false","hide_undercond":"","init":"","init_par":"S","layer":false,"layout_steps_values":{},"name":"rTipoinv","orientation":"horizontal","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","type":"Radio","typevar":"character","valuesList":"G,P,S","visible":true,"w":408,"x":6,"y":9,"zindex":"10"});
this.rTipoinv.Value('<%=JSPLib.ToJSValue(rTipoinv,false,true)%>');
this.btnDown=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"right","class_Css":"image btnDown_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnDown","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xebbd;","font_image_hover":"&#xebbe;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Preleva il file da inviare",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"bounded","layer":false,"layout_steps_values":{},"name":"btnDown","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xebbd;","srchover":"&#xebbe;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":685,"y":10,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.a2022=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'S'","checked_value":"S","create_undercond":"","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_a2022","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","h":20,"hide":"false","hide_undercond":"","init":"true","init_par":"N","label_text":"2022","layer":false,"layout_steps_values":{},"name":"a2022","page":1,"reactive":false,"server_side":"","spuid":"","style_type":"","tabindex":"","type":"Checkbox","typevar":"character","unchecked_value":"N","w":63,"x":648,"y":128,"zindex":"4"});
this.a2022.Value('<%=a2022%>');
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
<%if(request.getAttribute("pg_crea_mass_cf_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_crea_mass_cf_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_crea_mass_cf_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnElab.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnExit.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnCalcola.dispatchEvent('OnLoad');
window.<%=idPortlet%>.btnDown.dispatchEvent('OnLoad');
window.<%=idPortlet%>.cmbTipoSog.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_crea_mass_cf',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_crea_mass_cf');
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
sp.endPage("pg_crea_mass_cf");
}%>
<%! public String getJSPUID() { return "1041038934"; } %>