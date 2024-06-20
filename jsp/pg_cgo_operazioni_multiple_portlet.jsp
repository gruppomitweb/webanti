<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Operazioni Multiple\",true)\n}\n\nfunction LanciaView() {\n  if (this.tipo.Value()=='Da Completare') {\n    this.OpeEdit.Link()\n  } else {\n    this.OpeEditSto.Link()\n  }  \n}  \n\nfunction BtnEsci_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.Uscita.Link();\n  }\n}  \n\nfunction RefreshView() {\n  this.Query1.Query();\n  this.Grid0.Refresh();\n}  \n\nfunction Search_Click(){\n  this.RefreshView();\n}\n","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Locale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODLOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:LanciaView()\",\"weight\":\"\",\"title\":\"N° Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CAIDBIGLIETTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Cognome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"COGNOME\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NOME\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Ticket\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CACODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TRDESREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Totale Operazione\",\"type\":\"C\",\"align\":\"right\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"999,999,999.99\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TOTLIRE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Segno\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"SEGNO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"D,C,C,C,C,C,C,N,C,C","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":70,\"w\":320,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":70,\"w\":480,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":43,\"w\":768,\"h\":528,\"anchor\":\"\",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"43","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":61,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":61,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":732,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":979,\"y\":61,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Uscita_Copy","page":"1","path_type":"","sequence":"2","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"732","y":"7","zindex":"1"},{"appendingData":"false","auto_exec":"true","count":"false","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"ticket=ticket","parms_source":"","query":"qbe_cgo_operazioni_dl_multi","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"120","x":"2","y":"-58"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"SNAINUMOPE","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":83,\"y\":-32,\"w\":45,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":124,\"y\":-32,\"w\":67,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":201,\"y\":-60,\"w\":107,\"h\":22,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":263,\"y\":-32,\"w\":\"146\",\"h\":22,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"w_snainumope","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"107","wireframe_props":"name","x":"201","y":"-60","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","name":"OpeEdit","offline":"false","page":"1","parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":"","refresh":"false","sequence":"5","servlet":"armt_cgo_oper_multi","target":"","type":"SPLinker","w":"30","x":"52","y":"-58"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","name":"OpeEditSto","offline":"false","page":"1","parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":"","refresh":"false","sequence":"6","servlet":"armt_snai_oper_storico","target":"","type":"SPLinker","w":"30","x":"95","y":"-58"},{"calculate":"","dataobj":"Query1","field":"TIPOPE","h":"20","init":"","init_par":"","name":"tipo","page":"1","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"1072","y":"-17"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"421","y":"-58"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global string","name":"gStpDwn","page":"1","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"577","y":"-58"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"","name":"tipoedit","page":"1","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"85","x":"170","y":"-59"},{"async":"false","entity_type":"page","h":"30","m_cAction":"","name":"Uscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"794","y":"-68"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"Verdana","font_color":"","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":49,\"y\":29,\"w\":70,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":73,\"y\":29,\"w\":105,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":117,\"y\":12,\"w\":168,\"h\":20,\"anchor\":\"\",\"hide\":\"false\"},\"1024\":{\"x\":155,\"y\":29,\"w\":\"225\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"30","name":"ticket","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"12","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"168","wireframe_props":"name","x":"117","y":"12","zerofilling":"false","zindex":"1"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"320\":{\"x\":3,\"y\":33,\"w\":45,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":4,\"y\":33,\"w\":67,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":7,\"y\":16,\"w\":107,\"h\":19,\"anchor\":\"\",\"hide\":\"false\",\"align\":\"right\",\"n_col\":\"1\",\"fontpct\":\"\"},\"1024\":{\"x\":9,\"y\":33,\"w\":\"145\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"label17","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Ticket da ricercare:","w":"107","wireframe_props":"align,value,n_col","x":"7","y":"16","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il tasto per effettuare la ricerca","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":696,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":979,\"y\":27,\"w\":\"40\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"Ricerca","page":"1","path_type":"","sequence":"14","server_side":"","src":"..\u002fimages\u002fsearch.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"696","y":"7","zindex":"1"}]%>
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
window.pg_cgo_operazioni_multiple_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof LanciaView !='undefined')this.LanciaView=LanciaView;
if(typeof BtnEsci_Click !='undefined')this.BtnEsci_Click=BtnEsci_Click;
if(typeof RefreshView !='undefined')this.RefreshView=RefreshView;
if(typeof Search_Click !='undefined')this.Search_Click=Search_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.w_snainumope,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
this.Query1.addDataConsumer(this.tipo,<%=JSPLib.ToJSValue("TIPOPE",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Operazioni Multiple",true)
}
function LanciaView() {
  if (this.tipo.Value()=='Da Completare') {
    this.OpeEdit.Link()
  } else {
    this.OpeEditSto.Link()
  }  
}  
function BtnEsci_Click(){
  if (confirm('Confermi la chiusura della maschera?')) {  
    this.Uscita.Link();
  }
}  
function RefreshView() {
  this.Query1.Query();
  this.Grid0.Refresh();
}  
function Search_Click(){
  this.RefreshView();
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
.pg_cgo_operazioni_multiple_container {
}
.pg_cgo_operazioni_multiple_title_container {
  margin: auto;
}
.pg_cgo_operazioni_multiple_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_operazioni_multiple_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:70px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:43px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .Uscita_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:306px;
  left:95.625%;
  right:2px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .Uscita_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:61px;
  left:459px;
  left:95.625%;
  right:3px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .Uscita_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:6px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_multiple_portlet > .Uscita_Copy_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="1024"] > .Uscita_Copy_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .Uscita_Copy_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .Uscita_Copy_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .Uscita_Copy_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-32px;
  left:83px;
  left:25.9375%;
  right:192px;
  right:60.0%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-32px;
  left:124px;
  left:25.833334%;
  right:289px;
  right:60.208332%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .w_snainumope_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-60px;
  left:201px;
  left:26.171875%;
  right:460px;
  right:59.895832%;
  width:auto;
  height:22px;
}
.pg_cgo_operazioni_multiple_portlet > .w_snainumope_ctrl {
  display:none;
}
.pg_cgo_operazioni_multiple_portlet > .w_snainumope_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .ticket_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:49px;
  left:15.3125%;
  right:201px;
  right:62.8125%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .ticket_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:29px;
  left:73px;
  left:15.208333%;
  right:302px;
  right:62.916668%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .ticket_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:117px;
  left:15.234375%;
  right:483px;
  right:62.890625%;
  width:auto;
  height:20px;
}
.pg_cgo_operazioni_multiple_portlet > .ticket_ctrl {
}
.pg_cgo_operazioni_multiple_portlet > .ticket_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:Verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .label17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:3px;
  left:0.9375%;
  right:272px;
  right:85.0%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .label17_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .label17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:33px;
  left:4px;
  left:0.8333333%;
  right:409px;
  right:85.208336%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .label17_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .label17_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:16px;
  left:7px;
  left:0.9114583%;
  right:654px;
  right:85.15625%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .label17_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_operazioni_multiple_portlet > .label17_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="1024"] > .label17_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .label17_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .label17_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .label17_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:306px;
  left:95.625%;
  right:2px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:459px;
  left:95.625%;
  right:3px;
  right:0.625%;
  width:auto;
  height:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:42px;
  width:30px;
  height:30px;
}
.pg_cgo_operazioni_multiple_portlet > .Ricerca_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="1024"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="320"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="480"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_operazioni_multiple_portlet[Data-step="768"] > .Ricerca_ctrl {
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Oper.\"},{\"title\":\"Locale\"},{\"title\":\"N° Ticket\"},{\"title\":\"Cognome\"},{\"title\":\"Nome\"},{\"title\":\"Tipo Ticket\"},{\"title\":\"Descrizione\"},{\"title\":\"Totale Operazione\"},{\"title\":\"Segno\"},{\"title\":\"Tipo\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":70},\"480\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":480,\"x\":0,\"y\":70},\"768\":{\"anchor\":\"\",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":43}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"43\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":61},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":61},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":61},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":732,\"y\":7}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"732\",\"y\":\"7\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"2\",\"y\":\"-58\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":\"146\",\"x\":263,\"y\":-32},\"320\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":45,\"x\":83,\"y\":-32},\"480\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":67,\"x\":124,\"y\":-32},\"768\":{\"anchor\":\"\",\"h\":22,\"hide\":\"false\",\"w\":107,\"x\":201,\"y\":-60}},\"name\":\"w_snainumope\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"107\",\"x\":\"201\",\"y\":\"-60\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"OpeEdit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"52\",\"y\":\"-58\"},{\"h\":\"30\",\"name\":\"OpeEditSto\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"95\",\"y\":\"-58\"},{\"h\":\"20\",\"name\":\"tipo\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"1072\",\"y\":\"-17\"},{\"h\":\"20\",\"name\":\"gUrlApp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"421\",\"y\":\"-58\"},{\"h\":\"20\",\"name\":\"gStpDwn\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"577\",\"y\":\"-58\"},{\"h\":\"20\",\"name\":\"tipoedit\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"85\",\"x\":\"170\",\"y\":\"-59\"},{\"h\":\"30\",\"name\":\"Uscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"794\",\"y\":\"-68\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"225\",\"x\":155,\"y\":29},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":70,\"x\":49,\"y\":29},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":105,\"x\":73,\"y\":29},\"768\":{\"anchor\":\"\",\"h\":20,\"hide\":\"false\",\"w\":168,\"x\":117,\"y\":12}},\"name\":\"ticket\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"168\",\"x\":\"117\",\"y\":\"12\",\"zindex\":\"1\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"145\",\"x\":9,\"y\":33},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":45,\"x\":3,\"y\":33},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":67,\"x\":4,\"y\":33},\"768\":{\"align\":\"right\",\"anchor\":\"\",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":\"1\",\"w\":107,\"x\":7,\"y\":16}},\"n_col\":\"1\",\"name\":\"label17\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Ticket da ricercare:\",\"w\":\"107\",\"x\":\"7\",\"y\":\"16\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"40\",\"x\":979,\"y\":27},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":696,\"y\":7}},\"name\":\"Ricerca\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"696\",\"y\":\"7\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_multiple","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_multiple_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_multiple','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_operazioni_multiple_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_snainumope= "";
if(request.getAttribute("pg_cgo_operazioni_multiple_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String tipo= "";
String gUrlApp=sp.getGlobal("gUrlApp","");
String gStpDwn=sp.getGlobal("gStpDwn","");
String tipoedit= "";
String ticket= "";
String label17= "Ticket da ricercare:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_multiple_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_multiple_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_multiple_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_multiple','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_Uscita_Copy' class='image Uscita_Copy_ctrl'   target=''>&#xe9fb;</a>
<span class='textbox-container'id='<%=idPortlet%>_w_snainumope_wrp'><input id='<%=idPortlet%>_w_snainumope' name='w_snainumope' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_snainumope' /></span>
<span class='textbox-container'id='<%=idPortlet%>_ticket_wrp'><input id='<%=idPortlet%>_ticket' name='ticket' type='text' maxlength='30' class='textbox' formid='<%=idPortlet%>' ps-name='ticket' /></span>
<span id='<%=idPortlet%>_label17'  formid='<%=idPortlet%>' ps-name='label17'    class='label label17_ctrl'><div id='<%=idPortlet%>_label17tbl' style='width:100%;'><%=JSPLib.ToHTML("Ticket da ricercare:")%></div></span>
<a id='<%=idPortlet%>_Ricerca' class='image Ricerca_ctrl'   target=''>&#xea19;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_multiple');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_multiple',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":528,"hide":"false","w":320,"x":0,"y":70},"480":{"anchor":" ","h":528,"hide":"false","w":480,"x":0,"y":70},"768":{"anchor":"","h":528,"hide":"false","w":768,"x":0,"y":43}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":43,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Oper.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Locale","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODLOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:LanciaView()","weight":"","title":"N° Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CAIDBIGLIETTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Cognome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"COGNOME","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NOME","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Ticket","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CACODICE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TRDESREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Totale Operazione","type":"C","align":"right","ColSpan":0,"layer":"","picture":"999,999,999.99","target":"","bg_color":"","newline":false,"field":"TOTLIRE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Segno","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"SEGNO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPOPE","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.Uscita_Copy=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_Copy_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita_Copy","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":61},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":61},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":61},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":732,"y":7}},"name":"Uscita_Copy","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":732,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_operazioni_dl_multi","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_dl_multi",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_Query1","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"ticket=ticket","parms_source":"","type":"SQLDataobj","w":120,"x":2,"y":-58});
this.w_snainumope=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_snainumope","decrypt":false,"edit_undercond":"","encrypt":false,"field":"SNAINUMOPE","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":22,"hide":"false","w":"146","x":263,"y":-32},"320":{"anchor":" ","h":22,"hide":"false","w":45,"x":83,"y":-32},"480":{"anchor":" ","h":22,"hide":"false","w":67,"x":124,"y":-32},"768":{"anchor":"","h":22,"hide":"false","w":107,"x":201,"y":-60}},"maxlength":"","name":"w_snainumope","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_snainumope,false,true)%>","w":107,"x":201,"y":-60,"zerofilling":false,"zindex":"1","zoom":""});
this.OpeEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeEdit","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeEdit","offline":false,"page":1,"parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":false,"refresh":"false","servlet":"armt_cgo_oper_multi","target":"","type":"SPLinker","w":30,"x":52,"y":-58});
this.OpeEdit.m_cID='<%=JSPLib.cmdHash("entity,armt_cgo_oper_multi",request.getSession())%>';
this.OpeEditSto=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_OpeEditSto","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"OpeEditSto","offline":false,"page":1,"parms":"SNAINUMOPE=w_snainumope","popup":"true","popup_height":"980","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"850","progressbar":false,"refresh":"false","servlet":"armt_snai_oper_storico","target":"","type":"SPLinker","w":30,"x":95,"y":-58});
this.OpeEditSto.m_cID='<%=JSPLib.cmdHash("entity,armt_snai_oper_storico",request.getSession())%>';
this.tipo=new ZtVWeb._VC(this,'tipo',null,'character','<%=JSPLib.ToJSValue(tipo,false,true)%>',false,false);
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.gStpDwn=new ZtVWeb._VC(this,'gStpDwn',null,'character','<%=JSPLib.ToJSValue(gStpDwn,false,true)%>',false,false);
this.tipoedit=new ZtVWeb._VC(this,'tipoedit',null,'character','<%=JSPLib.ToJSValue(tipoedit,false,true)%>',false,false);
this.Uscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Uscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Uscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":30,"x":794,"y":-68});
this.Uscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.ticket=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_ticket","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"225","x":155,"y":29},"320":{"anchor":" ","h":20,"hide":"false","w":70,"x":49,"y":29},"480":{"anchor":" ","h":20,"hide":"false","w":105,"x":73,"y":29},"768":{"anchor":"","h":20,"hide":"false","w":168,"x":117,"y":12}},"maxlength":"30","name":"ticket","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ticket,false,true)%>","w":168,"x":117,"y":12,"zerofilling":false,"zindex":"1","zoom":""});
this.label17=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label17","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"145","x":9,"y":33},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":45,"x":3,"y":33},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":67,"x":4,"y":33},"768":{"align":"right","anchor":"","fontpct":"","h":19,"hide":"false","n_col":"1","w":107,"x":7,"y":16}},"n_col":1,"name":"label17","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label17,false,true)%>","type":"Label","w":107,"x":7,"y":16,"zindex":"1"});
this.Ricerca=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Ricerca_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Ricerca","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il tasto per effettuare la ricerca",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"40","x":979,"y":27},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":27},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":696,"y":7}},"name":"Ricerca","page":1,"path_type":"","server_side":"","src":"&#xea19;","srchover":"&#xea1a;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":696,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
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
<%if(request.getAttribute("pg_cgo_operazioni_multiple_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_multiple_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_multiple_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Uscita_Copy.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Ricerca.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_multiple',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_multiple');
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
sp.endPage("pg_cgo_operazioni_multiple");
}%>
<%! public String getJSPUID() { return "2349510788"; } %>