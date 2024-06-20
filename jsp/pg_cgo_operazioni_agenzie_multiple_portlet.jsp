<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  \u002f\u002fsetto il titolo della maschera\n  this.getTitlePortlet().SetTitle('Operazioni Multiple Agenzia',true)\n  this.opedata.Value(Right(this.datope.Value(),2)+\"-\"+Substr(this.datope.Value(),5,2)+\"-\"+Left(this.datope.Value(),4));\n  this.SQL_Testate_Multiple.Query();\n}\n\n\u002f\u002fapro il dettaglio di uno specifico master\n\u002f\u002fassociato al tipo di operazione\nfunction Apri(_SNAINUMOPE,_TIPOSM){\n  if( _TIPOSM == 'S'){\n\u002f\u002f apro il master delle operazioni singole\n    this.SPLinker_mt.Servlet('armt_snai_oper' )\n  }\n  if (_TIPOSM == 'DC'){\n\u002f\u002f apro il master delle operazioni multiple\n \t\tthis.SPLinker_mt.Servlet('armt_cgo_oper_multi_dc' )\n  }\n  if (_TIPOSM == 'C'){\n\u002f\u002f apro il master delle operazioni multiple\n \t\tthis.SPLinker_mt.Servlet('armt_cgo_oper_multi' )\n  }\n  this.SPLinker_mt.Parameters('SNAINUMOPE = '+_SNAINUMOPE)\n  this.SPLinker_mt.Link()\n}\n\nfunction RecuperaDL(_SNAINUMOPE) {\n  var cprownumber_selezionato, snainumope_selezionato;\n  if (confirm('Confermi la selezione della registrazione?')) {\n    cprownumber_selezionato=this.cprownumber_selezionato.Value();\n    snainumope_selezionato=this.snainumope_selezionato.Value();\n    caller.WriteRowM(_SNAINUMOPE);\n    window.close();\n  }\n}\n\nfunction snainumope_selezionato_onChange(){\n\u002f\u002f   debugger;\n\u002f\u002f   alert(this.snainumope_selezionato.Value());\n\u002f\u002f   this.SQL_Dettaglio_Multipla.parms='pSNAINUMOPE='+this.snainumope_selezionato.Value();\n  this.SQL_Dettaglio_Multipla.parms='pSNAINUMOPE='+this.SQL_Testate_Multiple.rs.SNAINUMOPE;\n  this.SQL_Dettaglio_Multipla.Query();\n}\n","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Operazioni Multiple Agenzia","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"400","hsl":"","htmlcode":"{{ @Label12_Copy }} \n{{ @Label12 }} \n{{ @Grid_Dettaglio_Multipla }} \n{{ @Grid_Testate_Multiple }} \n \n \n \n \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Operazioni Multiple Agenzia","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"datope","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"178","x":"714","y":"-68"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"numope","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"178","x":"714","y":"-46"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"segno","page":"1","reactive":"","sequence":"3","server_side":"false","type":"Variable","typevar":"character","w":"178","x":"714","y":"-24"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"dc","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"178","x":"714","y":"-2"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"10","name":"SQL_Testate_Multiple","offline":"false","page":"1","parms":"w_datope=opedata, w_numope=numope, w_segno=segno, w_dc=dc","parms_source":"","query":"qbe_ cgo_operazioni_dl_multi_dc_testate","query_async":"true","return_fields_type":"true","sequence":"6","type":"SQLDataobj","w":"180","x":"717","y":"48"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"opedata","page":"1","reactive":"","sequence":"6","server_side":"false","type":"Variable","typevar":"date","w":"178","x":"714","y":"22"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQL_Testate_Multiple","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"CPROWNUM","h":"20","init":"","init_par":"","name":"cprownumber_selezionato","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"180","x":"720","y":"166"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"view","name":"SPLinker_mt","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"8","servlet":"","target":"","type":"SPLinker","w":"180","x":"720","y":"220"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"DATAOPE\",\"title\":\"Data Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"function:RecuperaDL('%SNAINUMOPE%')\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"D\",\"title_align\":\"\"},{\"field\":\"SNAINUMOPE\",\"title\":\"N° Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"TIPOGIOCO\",\"title\":\"Tipo gioco\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CACODICE\",\"title\":\"Codice Causale\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQL_Testate_Multiple","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"162","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Testate_Multiple","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"9","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":"399","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"23","zindex":"8"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQL_Testate_Multiple","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"SNAINUMOPE","h":"20","init":"","init_par":"","name":"snainumope_selezionato","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"180","x":"716","y":"73"},{"allowedqueries":"","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"10","name":"SQL_Dettaglio_Multipla","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_operazioni_dl_multi_dt_dc_bgltt","query_async":"false","return_fields_type":"true","sequence":"11","type":"SQLDataobj","w":"180","x":"721","y":"143"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"DATOPE\",\"title\":\"Data Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"D\",\"title_align\":\"\"},{\"field\":\"CAIDBIGLIETTO\",\"title\":\"ID BIGLIETTO\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"SNAINUMOPE\",\"title\":\"N° Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CGOTIPOPE\",\"title\":\"Tipo Gioco\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CACODICE\",\"title\":\"Codice Causale\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"},{\"field\":\"TOTLIRE\",\"title\":\"Importo\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQL_Dettaglio_Multipla","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"162","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Dettaglio_Multipla","nav_bar":"","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"12","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"399","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"229","zindex":"1"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label12","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"13","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Operazione Multipla:","w":"399","wireframe_props":"align,value,n_col","x":"0","y":"3","zindex":"9"},{"align":"center","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label12_Copy","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"14","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"Dettaglio Multipla:","w":"399","wireframe_props":"align,value,n_col","x":"0","y":"208","zindex":"9"}]%>
<%/*Description:Operazioni Multiple Agenzia*/%>
<%/*ParamsRequest:datope,numope,segno,dc*/%>
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
window.pg_cgo_operazioni_agenzie_multiple_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Apri !='undefined')this.Apri=Apri;
if(typeof RecuperaDL !='undefined')this.RecuperaDL=RecuperaDL;
if(typeof snainumope_selezionato_onChange !='undefined')this.snainumope_selezionato_onChange=snainumope_selezionato_onChange;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQL_Testate_Multiple.addDataConsumer(this.cprownumber_selezionato,<%=JSPLib.ToJSValue("CPROWNUM",true)%>);
this.SQL_Testate_Multiple.addRowConsumer(this.Grid_Testate_Multiple);
this.SQL_Testate_Multiple.addDataConsumer(this.snainumope_selezionato,<%=JSPLib.ToJSValue("SNAINUMOPE",true)%>);
this.SQL_Dettaglio_Multipla.addRowConsumer(this.Grid_Dettaglio_Multipla);
function this_Loaded(){
  //setto il titolo della maschera
  this.getTitlePortlet().SetTitle('Operazioni Multiple Agenzia',true)
  this.opedata.Value(Right(this.datope.Value(),2)+"-"+Substr(this.datope.Value(),5,2)+"-"+Left(this.datope.Value(),4));
  this.SQL_Testate_Multiple.Query();
}
//apro il dettaglio di uno specifico master
//associato al tipo di operazione
function Apri(_SNAINUMOPE,_TIPOSM){
  if( _TIPOSM == 'S'){
// apro il master delle operazioni singole
    this.SPLinker_mt.Servlet('armt_snai_oper' )
  }
  if (_TIPOSM == 'DC'){
// apro il master delle operazioni multiple
 		this.SPLinker_mt.Servlet('armt_cgo_oper_multi_dc' )
  }
  if (_TIPOSM == 'C'){
// apro il master delle operazioni multiple
 		this.SPLinker_mt.Servlet('armt_cgo_oper_multi' )
  }
  this.SPLinker_mt.Parameters('SNAINUMOPE = '+_SNAINUMOPE)
  this.SPLinker_mt.Link()
}
function RecuperaDL(_SNAINUMOPE) {
  var cprownumber_selezionato, snainumope_selezionato;
  if (confirm('Confermi la selezione della registrazione?')) {
    cprownumber_selezionato=this.cprownumber_selezionato.Value();
    snainumope_selezionato=this.snainumope_selezionato.Value();
    caller.WriteRowM(_SNAINUMOPE);
    window.close();
  }
}
function snainumope_selezionato_onChange(){
//   debugger;
//   alert(this.snainumope_selezionato.Value());
//   this.SQL_Dettaglio_Multipla.parms='pSNAINUMOPE='+this.snainumope_selezionato.Value();
  this.SQL_Dettaglio_Multipla.parms='pSNAINUMOPE='+this.SQL_Testate_Multiple.rs.SNAINUMOPE;
  this.SQL_Dettaglio_Multipla.Query();
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
.pg_cgo_operazioni_agenzie_multiple_container {
}
.pg_cgo_operazioni_agenzie_multiple_title_container {
  margin: auto;
}
.pg_cgo_operazioni_agenzie_multiple_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:400px;
  height:400px;
  background-color:#F3F3F3;
}
.pg_cgo_operazioni_agenzie_multiple_portlet[Data-page="1"]{
  height:400px;
  width:100%;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Grid_Testate_Multiple_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:23px;
  left:0px;
  left:0.0%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:162px;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Grid_Dettaglio_Multipla_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:229px;
  left:0px;
  left:0.0%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:162px;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Label12_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:3px;
  left:0px;
  left:0.0%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Label12_ctrl {
  height:auto;
  min-height:20px;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Label12_ctrl {
  overflow:hidden;
  text-align:center;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Label12_Copy_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:208px;
  left:0px;
  left:0.0%;
  right:1px;
  right:0.25%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Label12_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_cgo_operazioni_agenzie_multiple_portlet > .Label12_Copy_ctrl {
  overflow:hidden;
  text-align:center;
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
 String def="[{\"h\":\"400\",\"layout_steps_values\":{},\"pages_names\":\"Operazioni Multiple Agenzia\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"714\",\"y\":\"-68\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"714\",\"y\":\"-46\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"714\",\"y\":\"-24\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"714\",\"y\":\"-2\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"180\",\"x\":\"717\",\"y\":\"48\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"178\",\"x\":\"714\",\"y\":\"22\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"720\",\"y\":\"166\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"180\",\"x\":\"720\",\"y\":\"220\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Operazione\"},{\"title\":\"N° Operazione\"},{\"title\":\"Tipo gioco\"},{\"title\":\"Codice Causale\"}],\"h\":\"162\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"399\",\"x\":\"0\",\"y\":\"23\",\"zindex\":\"8\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"180\",\"x\":\"716\",\"y\":\"73\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"180\",\"x\":\"721\",\"y\":\"143\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data Operazione\"},{\"title\":\"ID BIGLIETTO\"},{\"title\":\"N° Operazione\"},{\"title\":\"Tipo Gioco\"},{\"title\":\"Codice Causale\"},{\"title\":\"Importo\"}],\"h\":\"162\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"399\",\"x\":\"0\",\"y\":\"229\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Operazione Multipla:\",\"w\":\"399\",\"x\":\"0\",\"y\":\"3\",\"zindex\":\"9\"},{\"align\":\"center\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Dettaglio Multipla:\",\"w\":\"399\",\"x\":\"0\",\"y\":\"208\",\"zindex\":\"9\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_operazioni_agenzie_multiple","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_operazioni_agenzie_multiple_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_multiple','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String datope=JSPLib.translateXSS(sp.getParameter("datope",""));
String numope=JSPLib.translateXSS(sp.getParameter("numope",""));
String segno=JSPLib.translateXSS(sp.getParameter("segno",""));
String dc=JSPLib.translateXSS(sp.getParameter("dc",""));
java.sql.Date opedata= JSPLib.NullDate();
String cprownumber_selezionato= "";
if(request.getAttribute("pg_cgo_operazioni_agenzie_multiple_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String snainumope_selezionato= "";
String Label12= "Operazione Multipla:";
String Label12_Copy= "Dettaglio Multipla:";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_operazioni_agenzie_multiple_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_operazioni_agenzie_multiple_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_operazioni_agenzie_multiple_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_operazioni_agenzie_multiple','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid_Testate_Multiple' formid='<%=idPortlet%>' ps-name='Grid_Testate_Multiple'   class='grid' style=''>&nbsp;</div>
<div id='<%=idPortlet%>_Grid_Dettaglio_Multipla' formid='<%=idPortlet%>' ps-name='Grid_Dettaglio_Multipla'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_Label12'  formid='<%=idPortlet%>' ps-name='Label12'    class='label Label12_ctrl'><div id='<%=idPortlet%>_Label12tbl' style='width:100%;'><%=JSPLib.ToHTML("Operazione Multipla:")%></div></span>
<span id='<%=idPortlet%>_Label12_Copy'  formid='<%=idPortlet%>' ps-name='Label12_Copy'    class='label Label12_Copy_ctrl'><div id='<%=idPortlet%>_Label12_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Dettaglio Multipla:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_operazioni_agenzie_multiple');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_operazioni_agenzie_multiple',["400"],["400"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"400","title":"Operazioni Multiple Agenzia","layer":"false","npage":"1"}]);
this.datope=new ZtVWeb._VC(this,'datope',null,'character','<%=JSPLib.ToJSValue(datope,false,true)%>',false,false);
this.numope=new ZtVWeb._VC(this,'numope',null,'character','<%=JSPLib.ToJSValue(numope,false,true)%>',false,false);
this.segno=new ZtVWeb._VC(this,'segno',null,'character','<%=JSPLib.ToJSValue(segno,false,true)%>',false,false);
this.dc=new ZtVWeb._VC(this,'dc',null,'character','<%=JSPLib.ToJSValue(dc,false,true)%>',false,false);
this.SQL_Testate_Multiple=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"qbe_ cgo_operazioni_dl_multi_dc_testate","cmdHash":"<%=JSPLib.cmdHash("qbe_ cgo_operazioni_dl_multi_dc_testate",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQL_Testate_Multiple","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQL_Testate_Multiple","nrows":"10","page":1,"parms":"w_datope=opedata, w_numope=numope, w_segno=segno, w_dc=dc","parms_source":"","type":"SQLDataobj","w":180,"x":717,"y":48});
this.opedata=new ZtVWeb._VC(this,'opedata',null,'date','<%=opedata%>',false,false);
this.cprownumber_selezionato=new ZtVWeb._VC(this,'cprownumber_selezionato',null,'character','<%=JSPLib.ToJSValue(cprownumber_selezionato,false,true)%>',false,false);
this.SPLinker_mt=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_mt","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_mt","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":180,"x":720,"y":220});
this.SPLinker_mt.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.Grid_Testate_Multiple=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Testate_Multiple","dataobj":"SQL_Testate_Multiple","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":162,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Testate_Multiple","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":399,"x":0,"y":23,"zindex":"8"});
this.Grid_Testate_Multiple.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"function:RecuperaDL('%SNAINUMOPE%')","fixedwidth":"","title":"Data Operazione","align":"","type":"D","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATAOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"N° Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"SNAINUMOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo gioco","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TIPOGIOCO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Causale","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CACODICE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.snainumope_selezionato=new ZtVWeb._VC(this,'snainumope_selezionato',null,'character','<%=JSPLib.ToJSValue(snainumope_selezionato,false,true)%>',false,false);
this.SQL_Dettaglio_Multipla=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_cgo_operazioni_dl_multi_dt_dc_bgltt","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_operazioni_dl_multi_dt_dc_bgltt",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQL_Dettaglio_Multipla","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQL_Dettaglio_Multipla","nrows":"10","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":180,"x":721,"y":143});
this.Grid_Dettaglio_Multipla=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Dettaglio_Multipla","dataobj":"SQL_Dettaglio_Multipla","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":162,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Dettaglio_Multipla","nav_bar":"","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":true,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":399,"x":0,"y":229,"zindex":"1"});
this.Grid_Dettaglio_Multipla.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Operazione","align":"","type":"D","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"ID BIGLIETTO","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CAIDBIGLIETTO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"N° Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"SNAINUMOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo Gioco","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CGOTIPOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Causale","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CACODICE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Importo","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TOTLIRE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.Label12=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label12","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label12,false,true)%>","type":"Label","w":399,"x":0,"y":3,"zindex":"9"});
this.Label12_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label12_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label12_Copy","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label12_Copy,false,true)%>","type":"Label","w":399,"x":0,"y":208,"zindex":"9"});
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
<%if(request.getAttribute("pg_cgo_operazioni_agenzie_multiple_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_operazioni_agenzie_multiple_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_operazioni_agenzie_multiple_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_operazioni_agenzie_multiple',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_operazioni_agenzie_multiple');
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
sp.endPage("pg_cgo_operazioni_agenzie_multiple");
}%>
<%! public String getJSPUID() { return "3994998567"; } %>