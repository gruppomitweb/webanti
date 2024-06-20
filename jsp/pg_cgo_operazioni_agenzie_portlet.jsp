<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Operazioni da completare (Agenzie)\",true)\n  this.OrderBy.Value(\"DATAOPE desc\")\n  this.Query1.Query()\n}\n\n\nfunction LanciaView() {\n  _comando=this.ComandoWorkflow.Link();\n  this.comando.Value(Left(LRTrim(_comando),1));\n  this.OpeEdit.Link()\n}  \n\nfunction RefreshView(_evt) {\n  this.q2param.Value(_evt.SNAINUMOPE)\n  this.Query2.Query();  \n  this.numope.Value(this.numopenew.Value())\n  this.PrintReg.Link()   \n  this.Query1.Query();\n  this.Grid0.Refresh();\n}  \n\nfunction BtnEsci_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.Uscita.Link();\n  }\n}  \n\nfunction PrintReg_Result(result){\n  if(result=='KO') {\n    alert(\"Impossibile stampare il modulo richiesto!\")\n  } else {  \n    this.filename.Value(result);\n    this.DownFile.Link() \n  }  \n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","htmlcode":"{{ @BtnEsci }}\n\n{{ @Grid0 }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:LanciaView()\",\"weight\":\"\",\"title\":\"N° Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CACODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRDESREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"C\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Segno\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SEGNO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"D,C,C,C,N,C","filters":"true-by-example","floatRows":"","font":"Tahoma","font_color":"","font_size":"","font_weight":"normal","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":41,\"w\":\"320\",\"h\":528,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":41,\"w\":\"480\",\"h\":528,\"anchor\":\"top-left-right\",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":41,\"w\":768,\"h\":528,\"anchor\":\"top-left-right\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"41","zindex":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"q2param","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"-35"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gStpDwn","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"154"},{"allowedqueries":"qbe_cgo_operazioni_agenzia","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","encrypted_fields_pwd":"cippa","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"w_OrderBy=OrderBy","parms_source":"","query":"qbe_cgo_operazioni_agenzia","query_async":"false","return_fields_type":"true","sequence":"4","type":"SQLDataobj","w":"120","x":"797","y":"215"},{"allowedentities":"armt_snai_oper","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"SNAINUMOPE,CAIDBIGLIETTO,CODDIPE","decrypted_parms_pwd":"cippa","entity_type":"master","h":"20","m_cAction":"edit","name":"OpeEdit","offline":"false","page":"1","parms":"SNAINUMOPE=numope,CAIDBIGLIETTO=biglietto,CODDIPE=coddip,verifica=comando,tipop=X","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":"","refresh":"false","sequence":"5","servlet":"armt_snai_oper","target":"","type":"SPLinker","w":"174","x":"969","y":"-8"},{"allowedqueries":"qbe_cgo_operazioni_agenzia_storico","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","encrypted_fields_pwd":"cippa","h":"20","localDBName":"","n_records":"20","name":"Query2","offline":"false","page":"1","parms":"pSNAINUMOPE=q2param","parms_source":"","query":"qbe_cgo_operazioni_agenzia_storico","query_async":"false","return_fields_type":"true","sequence":"6","type":"SQLDataobj","w":"120","x":"795","y":"241"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"181"},{"allowedentities":"arfn_snai_oper_load","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"ComandoWorkflow","offline":"false","page":"1","parms":"pNumOpe=snainumope,pFlgT=P,pAgenzia=gCodDip","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":"","refresh":"false","sequence":"8","servlet":"arfn_snai_oper_load","target":"","type":"SPLinker","w":"174","x":"969","y":"-35"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"100"},{"allowedentities":"arrt_cgo_moduli_storico","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"w_SNAINUMOPE","decrypted_parms_pwd":"cippa","entity_type":"routine","h":"20","m_cAction":"function","name":"PrintReg","offline":"false","page":"1","parms":"w_SNAINUMOPE=numope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"arrt_cgo_moduli_storico","target":"","type":"SPLinker","w":"174","x":"969","y":"19"},{"allowedentities":"DownloadFileServlet","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"start","name":"DownFile","offline":"false","page":"1","parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":"174","x":"969","y":"46"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"comando","page":"1","reactive":"","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"-62"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"page","h":"20","m_cAction":"","name":"Uscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"13","servlet":"start_page_logo_agenzie_portlet.jsp","target":"","type":"SPLinker","w":"174","x":"969","y":"-62"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":" &#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{\"320\":{\"x\":310,\"y\":6,\"w\":9,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":465,\"y\":6,\"w\":13,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":730,\"y\":6,\"w\":30,\"h\":30,\"anchor\":\"\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":989,\"y\":6,\"w\":\"30\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"BtnEsci","page":"1","path_type":"","sequence":"14","server_side":"","spuid":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"730","y":"6","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_snai_oper_savedEntity","objsValues":"this.RefreshView(evt)","page":"1","parmsNames":"","sequence":"15","type":"EventReceiver","w":"216","x":"794","y":"267"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"OrderBy","page":"1","reactive":"","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"19"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDCODICE","h":"20","init":"","init_par":"","name":"numope","page":"1","reactive":"","sequence":"17","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"46"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"BIGLIETTO","h":"20","init":"","init_par":"","name":"biglietto","page":"1","reactive":"","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"73"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"CODDIPE","h":"20","init":"","init_par":"","name":"coddip","page":"1","reactive":"","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"127"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query2","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDCODICE","h":"20","init":"","init_par":"","name":"numopenew","page":"1","reactive":"","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"793","y":"-8"},{"calculate":"","ctrlOfVariant":"","dataobj":"Query1","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"SNAINUMOPE","h":"20","init":"","init_par":"","name":"snainumope","page":"1","reactive":"","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"971","y":"73"}]%>
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
window.pg_cgo_operazioni_agenzie_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LanciaView !='undefined')this.LanciaView=LanciaView;
if(typeof RefreshView !='undefined')this.RefreshView=RefreshView;
if(typeof BtnEsci_Click !='undefined')this.BtnEsci_Click=BtnEsci_Click;
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
this.Query1.addDataConsumer(this.snainumope,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Operazioni da completare (Agenzie)",true)
  this.OrderBy.Value("DATAOPE desc")
  this.Query1.Query()
}
function LanciaView() {
  _comando=this.ComandoWorkflow.Link();
  this.comando.Value(Left(LRTrim(_comando),1));
  this.OpeEdit.Link()
}  
function RefreshView(_evt) {
  this.q2param.Value(_evt.SNAINUMOPE)
  this.Query2.Query();  
  this.numope.Value(this.numopenew.Value())
  this.PrintReg.Link()   
  this.Query1.Query();
  this.Grid0.Refresh();
}  
function BtnEsci_Click(){
  if (confirm('Confermi la chiusura della maschera?')) {  
    this.Uscita.Link();
  }
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
.pg_cgo_operazioni_agenzie_container {
}
.pg_cgo_operazioni_agenzie_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:41px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:41px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:41px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="320"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:310px;
  left:96.875%;
  right:1px;
  right:0.3125%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="480"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:465px;
  left:96.875%;
  right:2px;
  right:0.41666666%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="768"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:6px;
  left:730px;
  left:95.052086%;
  right:8px;
  right:1.0416666%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_agenzie_portlet > .BtnEsci_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="1024"] > .BtnEsci_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="320"] > .BtnEsci_ctrl {
  line-height:30px;
  font-size:9px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="480"] > .BtnEsci_ctrl {
  line-height:30px;
  font-size:13px;
}
.pg_cgo_operazioni_agenzie_portlet[Data-step="768"] > .BtnEsci_ctrl {
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"N° Ticket\"},{\"title\":\"Tipo Ticket\"},{\"title\":\"Descrizione\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Segno\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\"top-left-right\",\"h\":528,\"hide\":\"false\",\"w\":\"320\",\"x\":0,\"y\":41},\"480\":{\"anchor\":\"top-left-right\",\"h\":528,\"hide\":\"false\",\"w\":\"480\",\"x\":0,\"y\":41},\"768\":{\"anchor\":\"top-left-right\",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":41}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"41\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"-35\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"154\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"797\",\"y\":\"215\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"174\",\"x\":\"969\",\"y\":\"-8\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"795\",\"y\":\"241\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"181\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"174\",\"x\":\"969\",\"y\":\"-35\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"100\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"174\",\"x\":\"969\",\"y\":\"19\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"174\",\"x\":\"969\",\"y\":\"46\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"-62\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"174\",\"x\":\"969\",\"y\":\"-62\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":989,\"y\":6},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":9,\"x\":310,\"y\":6},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":13,\"x\":465,\"y\":6},\"768\":{\"anchor\":\"\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":730,\"y\":6}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"730\",\"y\":\"6\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"216\",\"x\":\"794\",\"y\":\"267\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"19\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"46\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"73\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"127\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"793\",\"y\":\"-8\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"971\",\"y\":\"73\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie","UTF-8")) {return; }
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
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String q2param= "";
String gStpDwn=sp.getGlobal("gStpDwn","");
String filename= "";
String gUrlApp=sp.getGlobal("gUrlApp","");
String comando= "";
String OrderBy= "";
String numope= "";
String biglietto= "";
String coddip= "";
String numopenew= "";
String snainumope= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_BtnEsci' class='image BtnEsci_ctrl'   target=''>&#xe9fb;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"Tahoma","font_color":"","font_size":"","font_weight":"normal","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":"top-left-right","h":528,"hide":"false","w":"320","x":0,"y":41},"480":{"anchor":"top-left-right","h":528,"hide":"false","w":"480","x":0,"y":41},"768":{"anchor":"top-left-right","h":528,"hide":"false","w":768,"x":0,"y":41}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":41,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Oper.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:LanciaView()","weight":"","title":"N° Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CACODICE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRDESREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"C","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Segno","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SEGNO","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.q2param=new ZtVWeb._VC(this,'q2param',null,'character','<%=JSPLib.ToJSValue(q2param,false,true)%>',false,false);
this.gStpDwn=new ZtVWeb._VC(this,'gStpDwn',null,'character','<%=JSPLib.ToJSValue(gStpDwn,false,true)%>',false,false);
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_cgo_operazioni_agenzia",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_cgo_operazioni_agenzia","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_agenziaIDCODICE,BIGLIETTO,CODDIPE,cippa",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"w_OrderBy=OrderBy","parms_source":"","type":"SQLDataobj","w":120,"x":797,"y":215});
this.Query1.encrypted_fields ='<%=JSPLib.encrypt("IDCODICE,BIGLIETTO,CODDIPE,cippa",request,"xxxx")%>';
this.OpeEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"<%=JSPLib.encrypt("armt_snai_oper",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeEdit","decrypted_parms":"SNAINUMOPE,CAIDBIGLIETTO,CODDIPE","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeEdit","offline":false,"page":1,"parms":"SNAINUMOPE=numope,CAIDBIGLIETTO=biglietto,CODDIPE=coddip,verifica=comando,tipop=X","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":false,"refresh":"false","servlet":"armt_snai_oper","target":"","type":"SPLinker","w":174,"x":969,"y":-8});
this.OpeEdit.decrypted_parms ='<%=JSPLib.encrypt("SNAINUMOPE,CAIDBIGLIETTO,CODDIPE,cippa",request,"xxxx")%>';
this.OpeEdit.m_cID='<%=JSPLib.cmdHash("entity,armt_snai_oper"+"SNAINUMOPE,CAIDBIGLIETTO,CODDIPE,cippa",request.getSession())%>';
this.Query2=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_cgo_operazioni_agenzia_storico",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_cgo_operazioni_agenzia_storico","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_agenzia_storicoIDCODICE,BIGLIETTO,CODDIPE,cippa",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query2","decrypted_parms":"","encrypted_fields":"IDCODICE,BIGLIETTO,CODDIPE","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query2","nrows":"20","page":1,"parms":"pSNAINUMOPE=q2param","parms_source":"","type":"SQLDataobj","w":120,"x":795,"y":241});
this.Query2.encrypted_fields ='<%=JSPLib.encrypt("IDCODICE,BIGLIETTO,CODDIPE,cippa",request,"xxxx")%>';
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.ComandoWorkflow=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_snai_oper_load",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ComandoWorkflow","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ComandoWorkflow","offline":false,"page":1,"parms":"pNumOpe=snainumope,pFlgT=P,pAgenzia=gCodDip","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":false,"refresh":"false","servlet":"arfn_snai_oper_load","target":"","type":"SPLinker","w":174,"x":969,"y":-35});
this.ComandoWorkflow.m_cID='<%=JSPLib.cmdHash("routine,arfn_snai_oper_load",request.getSession())%>';
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.PrintReg=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arrt_cgo_moduli_storico",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_PrintReg","decrypted_parms":"w_SNAINUMOPE","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"PrintReg","offline":false,"page":1,"parms":"w_SNAINUMOPE=numope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_cgo_moduli_storico","target":"","type":"SPLinker","w":174,"x":969,"y":19});
this.PrintReg.decrypted_parms ='<%=JSPLib.encrypt("w_SNAINUMOPE,cippa",request,"xxxx")%>';
this.PrintReg.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_moduli_storico"+"w_SNAINUMOPE,cippa",request.getSession())%>';
this.DownFile=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"<%=JSPLib.encrypt("DownloadFileServlet",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_DownFile","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"DownFile","offline":false,"page":1,"parms":"id=filename","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"DownloadFileServlet","target":"","type":"SPLinker","w":174,"x":969,"y":46});
this.DownFile.m_cID='<%=JSPLib.cmdHash("routine,DownloadFileServlet",request.getSession())%>';
this.comando=new ZtVWeb._VC(this,'comando',null,'character','<%=JSPLib.ToJSValue(comando,false,true)%>',false,false);
this.Uscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Uscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Uscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_agenzie_portlet.jsp","target":"","type":"SPLinker","w":174,"x":969,"y":-62});
this.Uscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_agenzie_portlet.jsp",request.getSession())%>';
this.BtnEsci=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image BtnEsci_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnEsci","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"30","x":989,"y":6},"320":{"anchor":" ","h":30,"hide":"false","w":9,"x":310,"y":6},"480":{"anchor":" ","h":30,"hide":"false","w":13,"x":465,"y":6},"768":{"anchor":"","font_size":"","h":30,"hide":"false","w":30,"x":730,"y":6}},"name":"BtnEsci","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":730,"y":6,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.armt_snai_oper_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_snai_oper_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_snai_oper_savedEntity","objsValues":"this.RefreshView(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":216,"x":794,"y":267});
this.OrderBy=new ZtVWeb._VC(this,'OrderBy',null,'character','<%=JSPLib.ToJSValue(OrderBy,false,true)%>',false,false);
this.numope=new ZtVWeb._VC(this,'numope',null,'character','<%=JSPLib.ToJSValue(numope,false,true)%>',false,false);
this.biglietto=new ZtVWeb._VC(this,'biglietto',null,'character','<%=JSPLib.ToJSValue(biglietto,false,true)%>',false,false);
this.coddip=new ZtVWeb._VC(this,'coddip',null,'character','<%=JSPLib.ToJSValue(coddip,false,true)%>',false,false);
this.numopenew=new ZtVWeb._VC(this,'numopenew',null,'character','<%=JSPLib.ToJSValue(numopenew,false,true)%>',false,false);
this.snainumope=new ZtVWeb._VC(this,'snainumope',null,'character','<%=JSPLib.ToJSValue(snainumope,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.BtnEsci.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_armt_snai_oper_savedEntity=function(parmsObj){<%=idPortlet%>.armt_snai_oper_savedEntity.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie');
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
sp.endPage("pg_cgo_operazioni_agenzie");
}%>
<%! public String getJSPUID() { return "1997769038"; } %>