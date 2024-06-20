<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Nuove Operazioni (Agenzie)\",true)\n  this.OrderBy.Value(\"DATAOPE desc\")\n  this.Query1.Query()\n}\n\nfunction LanciaView() {\n  this.OpeEdit.Link()\n}  \n\nfunction newOpe_Click(){\n  this.numope.Value(\"\");\n  this.OpeNew.Link()\n}  \n\nfunction CancReg() {\n  if (confirm('Confermi la cancellazione della registrazione?')) {\n    _esito=this.DelReg.Link()\n    if (_esito=='OK') {\n      alert('Registrazione cancellata correttamente')\n    } \n    if (_esito=='KO') {\n      alert('Operazione non riuscita. Contattare Assistenza')\n    }  \n    if (_esito=='DE') {\n      alert('Presenza di documentazione. Operazione non consentita.\\nContattare Assistenza')\n    }      \n    this.Query1.Query()\n  }  \n}  \n\nfunction StampaModulo() {\n  if (confirm('Confermi la stampa del modulo?')) {\n    this.PrintReg.Link()      \n  }  \n}  \n\nfunction BtnEsci_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.Uscita.Link();\n  }\n}  \n\nfunction RefreshView(_evt) {\n  this.q2param.Value(_evt.SNAINUMOPE)\n  this.Query2.Query();  \n  this.numope.Value(this.numopenew.Value())\n  this.PrintReg.Link() \n  this.Query1.Query();\n  this.Grid0.Refresh();\n}  \n\nfunction PrintReg_Result(result){\n  if(result=='KO') {\n    alert(\"Impossibile stampare il modulo richiesto!\")\n  } else {  \n    this.filename.Value(result);\n    this.DownFile.Link() \n  }  \n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"{{ @BtnEsci }}\n{{ @newOpe }}\n\n{{ @Grid0 }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:LanciaView()\",\"weight\":\"\",\"title\":\"N° Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Cognome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"COGNOME\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NOME\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CACODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRDESREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"C\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Segno\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SEGNO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:StampaModulo()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fprinter_ico.gif:Stampa il modulo di adeguata verifica\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:CancReg()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fgrid_delete.gif:Cancella l'operazione\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"D,C,C,C,N,C,N,C,,","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":25,\"w\":320,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":25,\"w\":480,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":41,\"w\":768,\"h\":528,\"anchor\":\"\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"41","zindex":""},{"allowedentities":"DownloadFileServlet","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"DownFile","offline":"false","page":"1","parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":"120","x":"1071","y":"263"},{"allowedqueries":"qbe_cgo_operazioni_agenzia_dl","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","encrypted_fields_pwd":"cippa","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"w_OrderBy=OrderBy","parms_source":"","query":"qbe_cgo_operazioni_agenzia_dl","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"120","x":"1089","y":"170"},{"allowedentities":"armt_cgo_oper","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"SNAINUMOPE,CAIDBIGLIETTO,CODDIPE","decrypted_parms_pwd":"cippa","entity_type":"master","h":"30","m_cAction":"edit","name":"OpeEdit","offline":"false","page":"1","parms":"SNAINUMOPE=numope,CAIDBIGLIETTO=biglietto,CODDIPE=coddip","popup":"true","popup_height":"900","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":"","refresh":"false","sequence":"4","servlet":"armt_cgo_oper","target":"","type":"SPLinker","w":"178","x":"1064","y":"-23"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"30","m_cAction":"new","name":"OpeNew","offline":"false","page":"1","parms":"","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":"","refresh":"false","sequence":"5","servlet":"armt_cgo_oper","target":"","type":"SPLinker","w":"227","x":"811","y":"75"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"949","y":"200"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gStpDwn","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"787","y":"177"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"tipoedit","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"85","x":"808","y":"144"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe90e;","font_image_hover":"&#xe90f;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il bottone per inserire una nuova operazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":303,\"y\":0,\"w\":7,\"h\":25,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":454,\"y\":0,\"w\":10,\"h\":25,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":690,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":968,\"y\":0,\"w\":\"25\",\"h\":25,\"anchor\":\" \",\"hide\":\"false\"}}","name":"newOpe","page":"1","path_type":"","sequence":"9","server_side":"","spuid":"","src":"..\u002fimages\u002fminiadd.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"690","y":"7","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"DelReg","offline":"false","page":"1","parms":"pSNAINUMOPE=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"arfn_cgo_delreg","target":"","type":"SPLinker","w":"183","x":"1064","y":"15"},{"allowedentities":"arrt_cgo_moduli_new","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"w_SNAINUMOPE","decrypted_parms_pwd":"cippa","entity_type":"routine","h":"30","m_cAction":"function","name":"PrintReg","offline":"false","page":"1","parms":"w_SNAINUMOPE=numope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"arrt_cgo_moduli_new","target":"","type":"SPLinker","w":"181","x":"1061","y":"-68"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"30","m_cAction":"","name":"Uscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"start_page_logo_agenzie_portlet.jsp","target":"","type":"SPLinker","w":"207","x":"810","y":"39"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":312,\"y\":0,\"w\":7,\"h\":25,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":468,\"y\":0,\"w\":10,\"h\":25,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":731,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":997,\"y\":0,\"w\":\"25\",\"h\":25,\"anchor\":\" \",\"hide\":\"false\"}}","name":"BtnEsci","page":"1","path_type":"","sequence":"13","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"731","y":"7","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_cgo_oper_savedEntity","objsValues":"this.RefreshView(evt)","page":"1","parmsNames":"","sequence":"14","type":"EventReceiver","w":"183","x":"812","y":"14"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"OrderBy","page":"1","reactive":"","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"812","y":"-9"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDCODICE","h":"20","init":"","init_par":"","name":"numope","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"938","y":"121"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"BIGLIETTO","h":"20","init":"","init_par":"","name":"biglietto","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"944","y":"151"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"CODDIPE","h":"20","init":"","init_par":"","name":"coddip","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"949","y":"178"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"StampaPop","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"19","servlet":"","target":"","type":"SPLinker","w":"120","x":"1079","y":"53"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1074","y":"80"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1060","y":"237"},{"allowedqueries":"qbe_cgo_operazioni_agenzia_dl","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","encrypted_fields_pwd":"cippa","h":"20","localDBName":"","n_records":"20","name":"Query2","offline":"false","page":"1","parms":"pSNAINUMOPE=q2param","parms_source":"","query":"qbe_cgo_operazioni_agenzia_dl","query_async":"false","return_fields_type":"true","sequence":"22","type":"SQLDataobj","w":"120","x":"1091","y":"147"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query2","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDCODICE","h":"20","init":"","init_par":"","name":"numopenew","page":"1","reactive":"","sequence":"23","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1076","y":"120"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"q2param","page":"1","reactive":"","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"822","y":"-45"}]%>
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
window.pg_cgo_operazioni_agenzie_dl_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LanciaView !='undefined')this.LanciaView=LanciaView;
if(typeof newOpe_Click !='undefined')this.newOpe_Click=newOpe_Click;
if(typeof CancReg !='undefined')this.CancReg=CancReg;
if(typeof StampaModulo !='undefined')this.StampaModulo=StampaModulo;
if(typeof BtnEsci_Click !='undefined')this.BtnEsci_Click=BtnEsci_Click;
if(typeof RefreshView !='undefined')this.RefreshView=RefreshView;
if(typeof PrintReg_Result !='undefined')this.PrintReg_Result=PrintReg_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.numope,<%=JSPLib.ToJSValue("IDCODICE",true)%>);
this.Query1.addDataConsumer(this.biglietto,<%=JSPLib.ToJSValue("BIGLIETTO",true)%>);
this.Query1.addDataConsumer(this.coddip,<%=JSPLib.ToJSValue("CODDIPE",true)%>);
this.Query2.addDataConsumer(this.numopenew,<%=JSPLib.ToJSValue("IDCODICE",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Nuove Operazioni (Agenzie)",true)
  this.OrderBy.Value("DATAOPE desc")
  this.Query1.Query()
}
function LanciaView() {
  this.OpeEdit.Link()
}  
function newOpe_Click(){
  this.numope.Value("");
  this.OpeNew.Link()
}  
function CancReg() {
  if (confirm('Confermi la cancellazione della registrazione?')) {
    _esito=this.DelReg.Link()
    if (_esito=='OK') {
      alert('Registrazione cancellata correttamente')
    } 
    if (_esito=='KO') {
      alert('Operazione non riuscita. Contattare Assistenza')
    }  
    if (_esito=='DE') {
      alert('Presenza di documentazione. Operazione non consentita.\nContattare Assistenza')
    }      
    this.Query1.Query()
  }  
}  
function StampaModulo() {
  if (confirm('Confermi la stampa del modulo?')) {
    this.PrintReg.Link()      
  }  
}  
function BtnEsci_Click(){
  if (confirm('Confermi la chiusura della maschera?')) {  
    this.Uscita.Link();
  }
}  
function RefreshView(_evt) {
  this.q2param.Value(_evt.SNAINUMOPE)
  this.Query2.Query();  
  this.numope.Value(this.numopenew.Value())
  this.PrintReg.Link() 
  this.Query1.Query();
  this.Grid0.Refresh();
}  
function PrintReg_Result(result){
  if(result=='KO') {
    alert("Impossibile stampare il modulo richiesto!")
  } else {  
    this.filename.Value(result);
    this.DownFile.Link() 
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
.pg_cgo_operazioni_agenzie_dl_container {
}
.pg_cgo_operazioni_agenzie_dl_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_dl_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:25px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:25px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:41px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="320"] > .newOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:303px;
  left:94.6875%;
  right:10px;
  right:3.125%;
  width:auto;
  height:25px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="480"] > .newOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:454px;
  left:94.583336%;
  right:16px;
  right:3.3333333%;
  width:auto;
  height:25px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="768"] > .newOpe_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:48px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_dl_portlet > .newOpe_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="1024"] > .newOpe_ctrl {
  line-height:25px;
  font-size:25px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="320"] > .newOpe_ctrl {
  line-height:25px;
  font-size:7px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="480"] > .newOpe_ctrl {
  line-height:25px;
  font-size:10px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="768"] > .newOpe_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="320"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:312px;
  left:97.5%;
  right:1px;
  right:0.3125%;
  width:auto;
  height:25px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="480"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:468px;
  left:97.5%;
  right:2px;
  right:0.41666666%;
  width:auto;
  height:25px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="768"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:7px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_agenzie_dl_portlet > .BtnEsci_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="1024"] > .BtnEsci_ctrl {
  line-height:25px;
  font-size:25px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="320"] > .BtnEsci_ctrl {
  line-height:25px;
  font-size:7px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="480"] > .BtnEsci_ctrl {
  line-height:25px;
  font-size:10px;
}
.pg_cgo_operazioni_agenzie_dl_portlet[Data-step="768"] > .BtnEsci_ctrl {
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"N° Ticket\"},{\"title\":\"Cognome\"},{\"title\":\"Nome\"},{\"title\":\"Tipo Ticket\"},{\"title\":\"Descrizione\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Segno\"},{\"title\":\"\"},{\"title\":\"\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":25},\"480\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":480,\"x\":0,\"y\":25},\"768\":{\"anchor\":\"\",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":41}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"41\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1071\",\"y\":\"263\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1089\",\"y\":\"170\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"178\",\"x\":\"1064\",\"y\":\"-23\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"227\",\"x\":\"811\",\"y\":\"75\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"949\",\"y\":\"200\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"787\",\"y\":\"177\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"85\",\"x\":\"808\",\"y\":\"144\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":25,\"hide\":\"false\",\"w\":\"25\",\"x\":968,\"y\":0},\"320\":{\"anchor\":\" \",\"h\":25,\"hide\":\"false\",\"w\":7,\"x\":303,\"y\":0},\"480\":{\"anchor\":\" \",\"h\":25,\"hide\":\"false\",\"w\":10,\"x\":454,\"y\":0},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":690,\"y\":7}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"690\",\"y\":\"7\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"183\",\"x\":\"1064\",\"y\":\"15\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"181\",\"x\":\"1061\",\"y\":\"-68\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"207\",\"x\":\"810\",\"y\":\"39\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":25,\"hide\":\"false\",\"w\":\"25\",\"x\":997,\"y\":0},\"320\":{\"anchor\":\" \",\"h\":25,\"hide\":\"false\",\"w\":7,\"x\":312,\"y\":0},\"480\":{\"anchor\":\" \",\"h\":25,\"hide\":\"false\",\"w\":10,\"x\":468,\"y\":0},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":731,\"y\":7}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"731\",\"y\":\"7\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"183\",\"x\":\"812\",\"y\":\"14\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"812\",\"y\":\"-9\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"938\",\"y\":\"121\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"944\",\"y\":\"151\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"949\",\"y\":\"178\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1079\",\"y\":\"53\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1074\",\"y\":\"80\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1060\",\"y\":\"237\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1091\",\"y\":\"147\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1076\",\"y\":\"120\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"822\",\"y\":\"-45\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie_dl","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_dl_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_dl','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_dl_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String gUrlApp=sp.getGlobal("gUrlApp","");
String gStpDwn=sp.getGlobal("gStpDwn","");
String tipoedit= "";
String OrderBy= "";
String numope= "";
String biglietto= "";
String coddip= "";
String gAzienda=sp.getGlobal("gAzienda","");
String filename= "";
String numopenew= "";
String q2param= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_dl_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_dl_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_dl_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie_dl','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_newOpe' class='image newOpe_ctrl'   target=''>&#xe90e;</a>
<a id='<%=idPortlet%>_BtnEsci' class='image BtnEsci_ctrl'   target=''>&#xe9fb;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie_dl');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie_dl',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":528,"hide":"false","w":320,"x":0,"y":25},"480":{"anchor":" ","h":528,"hide":"false","w":480,"x":0,"y":25},"768":{"anchor":"","h":528,"hide":"false","w":768,"x":0,"y":41}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":41,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Oper.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:LanciaView()","weight":"","title":"N° Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Cognome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"COGNOME","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NOME","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CACODICE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRDESREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"C","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Segno","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SEGNO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:StampaModulo()","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fprinter_ico.gif:Stampa il modulo di adeguata verifica","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:CancReg()","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fgrid_delete.gif:Cancella l'operazione","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.DownFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("DownloadFileServlet",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_DownFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"DownFile","offline":false,"page":1,"parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":120,"x":1071,"y":263});
this.DownFile.m_cID='<%=JSPLib.cmdHash("routine,DownloadFileServlet",request.getSession())%>';
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_cgo_operazioni_agenzia_dl",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_cgo_operazioni_agenzia_dl","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_agenzia_dlIDCODICE,BIGLIETTO,CODDIPE,cippa",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"w_OrderBy=OrderBy","parms_source":"","type":"SQLDataobj","w":120,"x":1089,"y":170});
this.Query1.encrypted_fields ='<%=JSPLib.encrypt("IDCODICE,BIGLIETTO,CODDIPE,cippa",request,"xxxx")%>';
this.OpeEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"<%=JSPLib.encrypt("armt_cgo_oper",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeEdit","decrypted_parms":"SNAINUMOPE,CAIDBIGLIETTO,CODDIPE","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeEdit","offline":false,"page":1,"parms":"SNAINUMOPE=numope,CAIDBIGLIETTO=biglietto,CODDIPE=coddip","popup":"true","popup_height":"900","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":false,"refresh":"false","servlet":"armt_cgo_oper","target":"","type":"SPLinker","w":178,"x":1064,"y":-23});
this.OpeEdit.decrypted_parms ='<%=JSPLib.encrypt("SNAINUMOPE,CAIDBIGLIETTO,CODDIPE,cippa",request,"xxxx")%>';
this.OpeEdit.m_cID='<%=JSPLib.cmdHash("entity,armt_cgo_oper"+"SNAINUMOPE,CAIDBIGLIETTO,CODDIPE,cippa",request.getSession())%>';
this.OpeNew=new ZtVWeb.SPLinkerCtrl(this,{"action":"new","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeNew","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeNew","offline":false,"page":1,"parms":"","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":false,"refresh":"false","servlet":"armt_cgo_oper","target":"","type":"SPLinker","w":227,"x":811,"y":75});
this.OpeNew.m_cID='<%=JSPLib.cmdHash("entity,armt_cgo_oper",request.getSession())%>';
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.gStpDwn=new ZtVWeb._VC(this,'gStpDwn',null,'character','<%=JSPLib.ToJSValue(gStpDwn,false,true)%>',false,false);
this.tipoedit=new ZtVWeb._VC(this,'tipoedit',null,'character','<%=JSPLib.ToJSValue(tipoedit,false,true)%>',false,false);
this.newOpe=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image newOpe_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_newOpe","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe90e;","font_image_hover":"&#xe90f;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il bottone per inserire una nuova operazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":25,"hide":"false","w":"25","x":968,"y":0},"320":{"anchor":" ","h":25,"hide":"false","w":7,"x":303,"y":0},"480":{"anchor":" ","h":25,"hide":"false","w":10,"x":454,"y":0},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":690,"y":7}},"name":"newOpe","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe90e;","srchover":"&#xe90f;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":690,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.DelReg=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_DelReg","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"DelReg","offline":false,"page":1,"parms":"pSNAINUMOPE=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_cgo_delreg","target":"","type":"SPLinker","w":183,"x":1064,"y":15});
this.DelReg.m_cID='<%=JSPLib.cmdHash("routine,arfn_cgo_delreg",request.getSession())%>';
this.PrintReg=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_cgo_moduli_new",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_PrintReg","decrypted_parms":"w_SNAINUMOPE","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"PrintReg","offline":false,"page":1,"parms":"w_SNAINUMOPE=numope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_cgo_moduli_new","target":"","type":"SPLinker","w":181,"x":1061,"y":-68});
this.PrintReg.decrypted_parms ='<%=JSPLib.encrypt("w_SNAINUMOPE,cippa",request,"xxxx")%>';
this.PrintReg.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_moduli_new"+"w_SNAINUMOPE,cippa",request.getSession())%>';
this.Uscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Uscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Uscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_agenzie_portlet.jsp","target":"","type":"SPLinker","w":207,"x":810,"y":39});
this.Uscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_agenzie_portlet.jsp",request.getSession())%>';
this.BtnEsci=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnEsci_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnEsci","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":25,"hide":"false","w":"25","x":997,"y":0},"320":{"anchor":" ","h":25,"hide":"false","w":7,"x":312,"y":0},"480":{"anchor":" ","h":25,"hide":"false","w":10,"x":468,"y":0},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":731,"y":7}},"name":"BtnEsci","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":731,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.armt_cgo_oper_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_cgo_oper_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_cgo_oper_savedEntity","objsValues":"this.RefreshView(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":183,"x":812,"y":14});
this.OrderBy=new ZtVWeb._VC(this,'OrderBy',null,'character','<%=JSPLib.ToJSValue(OrderBy,false,true)%>',false,false);
this.numope=new ZtVWeb._VC(this,'numope',null,'character','<%=JSPLib.ToJSValue(numope,false,true)%>',false,false);
this.biglietto=new ZtVWeb._VC(this,'biglietto',null,'character','<%=JSPLib.ToJSValue(biglietto,false,true)%>',false,false);
this.coddip=new ZtVWeb._VC(this,'coddip',null,'character','<%=JSPLib.ToJSValue(coddip,false,true)%>',false,false);
this.StampaPop=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_StampaPop","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"StampaPop","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"true","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":120,"x":1079,"y":53});
this.StampaPop.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.Query2=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_cgo_operazioni_agenzia_dl",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_cgo_operazioni_agenzia_dl","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_agenzia_dlIDCODICE,BIGLIETTO,CODDIPE,cippa",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query2","decrypted_parms":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query2","nrows":"20","page":1,"parms":"pSNAINUMOPE=q2param","parms_source":"","type":"SQLDataobj","w":120,"x":1091,"y":147});
this.Query2.encrypted_fields ='<%=JSPLib.encrypt("IDCODICE,BIGLIETTO,CODDIPE,cippa",request,"xxxx")%>';
this.numopenew=new ZtVWeb._VC(this,'numopenew',null,'character','<%=JSPLib.ToJSValue(numopenew,false,true)%>',false,false);
this.q2param=new ZtVWeb._VC(this,'q2param',null,'character','<%=JSPLib.ToJSValue(q2param,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_dl_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_dl_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_dl_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.newOpe.dispatchEvent('OnLoad');
window.<%=idPortlet%>.BtnEsci.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_armt_cgo_oper_savedEntity=function(parmsObj){<%=idPortlet%>.armt_cgo_oper_savedEntity.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_dl',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie_dl');
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
sp.endPage("pg_cgo_operazioni_agenzie_dl");
}%>
<%! public String getJSPUID() { return "1211131038"; } %>