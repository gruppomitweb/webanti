<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Verifica Criticità CGO\",true)\n}\n\nfunction Ricerca_Click(){\n  this.Query1.Query();\n  this.Grid0.Refresh();\n}\n\nfunction Uscita_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.BtnUscita.Link();\n  }\n}  \n\nfunction Excel_Click(){\n  this.EstrazioneExcel.Link()\n}\n\nfunction CrtcColor(_flag) {\n  _ritorno=''\n  if (_flag=='R') {\n    _ritorno=\"\u003cimg src='\"+LRTrim(this.gUrlApp.Value())+\"\u002fimages\u002fstato2.gif'\"+' alt=\"ok\" \u002f\u003e'\n  } else {\n    _ritorno=\"\u003cimg src='\"+LRTrim(this.gUrlApp.Value())+\"\u002fimages\u002fstato3.gif'\"+' alt=\"ok\" \u002f\u003e'    \n  }    \n  return _ritorno \n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Agenzie da Completare","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"ID Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"IDBASE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DESCDIP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Città\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CITDIP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Oper.\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"N° Giorni\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NUMDAYS\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":true,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"function:CrtcColor('%FLGCRTC%')\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"C,C,C,D,N,","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"528","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":63,\"w\":320,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":63,\"w\":480,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":41,\"w\":768,\"h\":528,\"anchor\":\" \",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"41","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":" &#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":61,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":61,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":734,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":982,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\" \"}}","name":"Uscita","page":"1","path_type":"","sequence":"1","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"734","y":"7","zindex":"1"},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"pTipo=tipogioco","parms_source":"","query":"rows:arfn_cgo_criticita","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"0","y":"-30"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":" &#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il tasto per produrre il file excel","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":291,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":436,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":664,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":912,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\" \"}}","name":"Excel","page":"1","path_type":"","sequence":"2","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"664","y":"7","zindex":"1"},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"20","name":"TbTipGio","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_tbtipgio","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"120","x":"145","y":"-30"},{"align":"right","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{\"320\":{\"x\":16,\"y\":37,\"w\":21,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"480\":{\"x\":24,\"y\":37,\"w\":31,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"768\":{\"x\":38,\"y\":13,\"w\":50,\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"},\"1024\":{\"x\":51,\"y\":37,\"w\":\"69\",\"h\":19,\"anchor\":\" \",\"hide\":\"false\",\"align\":\"right\",\"n_col\":1,\"fontpct\":\"\"}}","n_col":"1","name":"label12","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Tipo Gioco:","w":"50","wireframe_props":"align,value,n_col","x":"38","y":"13","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"start","m_cAltInterface":"","name":"EstrazioneExcel","offline":"false","page":"1","parms":"pTipo=tipogioco","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":"","refresh":"false","sequence":"5","servlet":"arrt_cgo_criticita_xls","target":"","type":"SPLinker","w":"30","x":"97","y":"-35"},{"anchor":"","calculate":"","class_Css":"combobox","create_undercond":"","dataobj":"TbTipGio","disabled":"false","edit_undercond":"","empty_value":"true","font":"verdana","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":39,\"y\":34,\"w\":154,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":58,\"y\":34,\"w\":231,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":93,\"y\":10,\"w\":369,\"h\":20,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":124,\"y\":34,\"w\":\"495\",\"h\":20,\"anchor\":\" \",\"hide\":\"false\"}}","name":"tipogioco","page":"1","picture":"","sequence":"10","tabindex":"","textlist":"DESTPGIO","type":"Combobox","typevar":"character","valuelist":"CODTPGIO","visible":"true","w":"369","wireframe_props":"name,textlist","x":"93","y":"10","zindex":"1"},{"async":"false","entity_type":"page","h":"30","m_cAction":"","m_cAltInterface":"","name":"BtnUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"953","y":"-40"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","sequence":"12","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"727","y":"-26"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il tasto per effettuare la ricerca","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":306,\"y\":27,\"w\":12,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":459,\"y\":27,\"w\":18,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":699,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\"\"},\"1024\":{\"x\":947,\"y\":29,\"w\":\"30\",\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\",\"font_size\":\" \"}}","name":"Ricerca","page":"1","path_type":"","sequence":"14","server_side":"","src":"..\u002fimages\u002fsearch.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"699","y":"7","zindex":"1"}]%>
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
window.pg_cgo_criticita_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Ricerca_Click !='undefined')this.Ricerca_Click=Ricerca_Click;
if(typeof Uscita_Click !='undefined')this.Uscita_Click=Uscita_Click;
if(typeof Excel_Click !='undefined')this.Excel_Click=Excel_Click;
if(typeof CrtcColor !='undefined')this.CrtcColor=CrtcColor;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.TbTipGio.addRowConsumer(this.tipogioco);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Verifica Criticità CGO",true)
}
function Ricerca_Click(){
  this.Query1.Query();
  this.Grid0.Refresh();
}
function Uscita_Click(){
  if (confirm('Confermi la chiusura della maschera?')) {  
    this.BtnUscita.Link();
  }
}  
function Excel_Click(){
  this.EstrazioneExcel.Link()
}
function CrtcColor(_flag) {
  _ritorno=''
  if (_flag=='R') {
    _ritorno="<img src='"+LRTrim(this.gUrlApp.Value())+"/images/stato2.gif'"+' alt="ok" />'
  } else {
    _ritorno="<img src='"+LRTrim(this.gUrlApp.Value())+"/images/stato3.gif'"+' alt="ok" />'    
  }    
  return _ritorno 
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
.pg_cgo_criticita_container {
}
.pg_cgo_criticita_title_container {
  margin: auto;
}
.pg_cgo_criticita_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_criticita_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_criticita_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_criticita_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_criticita_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:63px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:63px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:528px;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .Grid0_ctrl {
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
.pg_cgo_criticita_portlet[Data-step="320"] > .Uscita_ctrl {
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
.pg_cgo_criticita_portlet[Data-step="480"] > .Uscita_ctrl {
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
.pg_cgo_criticita_portlet[Data-step="768"] > .Uscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:4px;
  width:30px;
  height:30px;
}
.pg_cgo_criticita_portlet > .Uscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="1024"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .Uscita_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .Uscita_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .Uscita_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:291px;
  left:90.9375%;
  right:17px;
  right:5.3125%;
  width:auto;
  height:30px;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:27px;
  left:436px;
  left:90.833336%;
  right:26px;
  right:5.4166665%;
  width:auto;
  height:30px;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .Excel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:74px;
  width:30px;
  height:30px;
}
.pg_cgo_criticita_portlet > .Excel_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="1024"] > .Excel_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .Excel_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .Excel_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .Excel_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .label12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:16px;
  left:5.0%;
  right:283px;
  right:88.4375%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_criticita_portlet[Data-step="320"] > .label12_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .label12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:24px;
  left:5.0%;
  right:425px;
  right:88.541664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_criticita_portlet[Data-step="480"] > .label12_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .label12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:13px;
  left:38px;
  left:4.9479165%;
  right:680px;
  right:88.541664%;
  width:auto;
  height:auto;
  min-height:19px;
}.pg_cgo_criticita_portlet[Data-step="768"] > .label12_ctrl {
  height:auto;
  min-height:19px;
}
.pg_cgo_criticita_portlet > .label12_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_cgo_criticita_portlet[Data-step="1024"] > .label12_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .label12_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .label12_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .label12_ctrl > div{
  text-align:right;
  -webkit-column-count:1;
  -moz-column-count:1;
  column-count:1;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .tipogioco_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:39px;
  left:12.1875%;
  right:127px;
  right:39.6875%;
  width:auto;
  height:20px;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .tipogioco_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:34px;
  left:58px;
  left:12.083333%;
  right:191px;
  right:39.791668%;
  width:auto;
  height:20px;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .tipogioco_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:93px;
  left:12.109375%;
  right:306px;
  right:39.84375%;
  width:auto;
  height:20px;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .Ricerca_ctrl {
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
.pg_cgo_criticita_portlet[Data-step="480"] > .Ricerca_ctrl {
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
.pg_cgo_criticita_portlet[Data-step="768"] > .Ricerca_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:39px;
  width:30px;
  height:30px;
}
.pg_cgo_criticita_portlet > .Ricerca_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="1024"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_criticita_portlet[Data-step="320"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:12px;
}
.pg_cgo_criticita_portlet[Data-step="480"] > .Ricerca_ctrl {
  line-height:30px;
  font-size:18px;
}
.pg_cgo_criticita_portlet[Data-step="768"] > .Ricerca_ctrl {
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Operazioni Agenzie da Completare\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ID Agenzia\"},{\"title\":\"Descrizione\"},{\"title\":\"Città\"},{\"title\":\"Data Oper.\"},{\"title\":\"N° Giorni\"},{\"title\":\"\"}],\"h\":\"528\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":63},\"480\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":480,\"x\":0,\"y\":63},\"768\":{\"anchor\":\" \",\"h\":528,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":41}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"41\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-right\",\"font_size\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":982,\"y\":29},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":61},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":61},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":734,\"y\":7}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"734\",\"y\":\"7\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"0\",\"y\":\"-30\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-right\",\"font_size\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":912,\"y\":29},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":291,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":436,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":664,\"y\":7}},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"664\",\"y\":\"7\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"145\",\"y\":\"-30\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{\"1024\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":\"69\",\"x\":51,\"y\":37},\"320\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":21,\"x\":16,\"y\":37},\"480\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":31,\"x\":24,\"y\":37},\"768\":{\"align\":\"right\",\"anchor\":\" \",\"fontpct\":\"\",\"h\":19,\"hide\":\"false\",\"n_col\":1,\"w\":50,\"x\":38,\"y\":13}},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":\"50\",\"x\":\"38\",\"y\":\"13\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"97\",\"y\":\"-35\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":\"495\",\"x\":124,\"y\":34},\"320\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":154,\"x\":39,\"y\":34},\"480\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":231,\"x\":58,\"y\":34},\"768\":{\"anchor\":\" \",\"h\":20,\"hide\":\"false\",\"w\":369,\"x\":93,\"y\":10}},\"name\":\"tipogioco\",\"page\":\"1\",\"textlist\":\"DESTPGIO\",\"type\":\"Combobox\",\"w\":\"369\",\"x\":\"93\",\"y\":\"10\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"BtnUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"953\",\"y\":\"-40\"},{\"h\":\"20\",\"name\":\"gUrlApp\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"727\",\"y\":\"-26\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\"top-right\",\"font_size\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":947,\"y\":29},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":12,\"x\":306,\"y\":27},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":18,\"x\":459,\"y\":27},\"768\":{\"anchor\":\"top-right\",\"font_size\":\"\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":699,\"y\":7}},\"name\":\"Ricerca\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"699\",\"y\":\"7\",\"zindex\":\"1\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_criticita","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_criticita_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_criticita','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_criticita_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String label12= "Tipo Gioco:";
String tipogioco= "";
String gUrlApp=sp.getGlobal("gUrlApp","");
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_criticita_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_criticita_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_criticita_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_criticita','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_Uscita' class='image Uscita_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_Excel' class='image Excel_ctrl'   target=''>&#xea8c;</a>
<span id='<%=idPortlet%>_label12'  formid='<%=idPortlet%>' ps-name='label12'    class='label label12_ctrl'><div id='<%=idPortlet%>_label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Tipo Gioco:")%></div></span>
<select id='<%=idPortlet%>_tipogioco' name='tipogioco' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<a id='<%=idPortlet%>_Ricerca' class='image Ricerca_ctrl'   target=''>&#xea19;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_criticita');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_criticita',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Operazioni Agenzie da Completare","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":528,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":528,"hide":"false","w":320,"x":0,"y":63},"480":{"anchor":" ","h":528,"hide":"false","w":480,"x":0,"y":63},"768":{"anchor":" ","h":528,"hide":"false","w":768,"x":0,"y":41}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":41,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"ID Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"IDBASE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DESCDIP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Città","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CITDIP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Oper.","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"N° Giorni","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NUMDAYS","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":true,"onclick":"","link":"","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"function:CrtcColor('%FLGCRTC%')","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.Uscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Uscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Uscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-right","font_size":" ","h":30,"hide":"false","w":"30","x":982,"y":29},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":61},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":61},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":734,"y":7}},"name":"Uscita","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":734,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"rows:arfn_cgo_criticita","cmdHash":"<%=JSPLib.cmdHash("rows:arfn_cgo_criticita",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"pTipo=tipogioco","parms_source":"","type":"SQLDataobj","w":120,"x":0,"y":-30});
this.Excel=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Excel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Excel","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il tasto per produrre il file excel",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-right","font_size":" ","h":30,"hide":"false","w":"30","x":912,"y":29},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":291,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":436,"y":27},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":664,"y":7}},"name":"Excel","page":1,"path_type":"","server_side":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":664,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.TbTipGio=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_tbtipgio","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_tbtipgio",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_TbTipGio","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"TbTipGio","nrows":"20","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":145,"y":-30});
this.label12=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{"1024":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":"69","x":51,"y":37},"320":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":21,"x":16,"y":37},"480":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":31,"x":24,"y":37},"768":{"align":"right","anchor":" ","fontpct":"","h":19,"hide":"false","n_col":1,"w":50,"x":38,"y":13}},"n_col":1,"name":"label12","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(label12,false,true)%>","type":"Label","w":50,"x":38,"y":13,"zindex":"1"});
this.EstrazioneExcel=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_EstrazioneExcel","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"EstrazioneExcel","offline":false,"page":1,"parms":"pTipo=tipogioco","popup":"false","popup_height":"1024","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":false,"refresh":"false","servlet":"arrt_cgo_criticita_xls","target":"","type":"SPLinker","w":30,"x":97,"y":-35});
this.EstrazioneExcel.m_cID='<%=JSPLib.cmdHash("routine,arrt_cgo_criticita_xls",request.getSession())%>';
this.tipogioco=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_tipogioco","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":true,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"<%=tipogioco%>","isdatap":true,"layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":20,"hide":"false","w":"495","x":124,"y":34},"320":{"anchor":" ","h":20,"hide":"false","w":154,"x":39,"y":34},"480":{"anchor":" ","h":20,"hide":"false","w":231,"x":58,"y":34},"768":{"anchor":" ","h":20,"hide":"false","w":369,"x":93,"y":10}},"name":"tipogioco","page":1,"picture":"","reactive":false,"server_side":"","tabindex":"","textlist":"DESTPGIO","type":"Combobox","typevar":"character","valuelist":"CODTPGIO","visible":true,"w":369,"x":93,"y":10,"zindex":"1"});
this.BtnUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_BtnUscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"BtnUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":30,"x":953,"y":-40});
this.BtnUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.Ricerca=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image Ricerca_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Ricerca","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea19;","font_image_hover":"&#xea1a;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il tasto per effettuare la ricerca",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":"top-right","font_size":" ","h":30,"hide":"false","w":"30","x":947,"y":29},"320":{"anchor":" ","h":30,"hide":"false","w":12,"x":306,"y":27},"480":{"anchor":" ","h":30,"hide":"false","w":18,"x":459,"y":27},"768":{"anchor":"top-right","font_size":"","h":30,"hide":"false","w":30,"x":699,"y":7}},"name":"Ricerca","page":1,"path_type":"","server_side":"","src":"&#xea19;","srchover":"&#xea1a;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":699,"y":7,"zindex":"1"});
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
<%if(request.getAttribute("pg_cgo_criticita_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_criticita_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_criticita_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Uscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Excel.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Ricerca.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Query1.firstQuery('true');
window.<%=idPortlet%>.TbTipGio.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_criticita',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_criticita');
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
sp.endPage("pg_cgo_criticita");
}%>
<%! public String getJSPUID() { return "2606608024"; } %>