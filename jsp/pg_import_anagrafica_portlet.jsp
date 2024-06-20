<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Importazione ANAGRAFICA\",true);\n  this.SQLDataobj_grid.Query();  \n}\nfunction Image_zoom_Click(){ \u002f\u002fapplica i filtri settati\n   this.SQLDataobj_grid.Query();\n}\nfunction Image_rm_filter_Click(){\t\u002f\u002frimuove i filtri (tutti)\n  this.likecodfisc.Value('');\n  this.likeconnes.Value('');\n  this.likeragsoc.Value('');\n  this.likecitta.Value('');\n  this.SQLDataobj_grid.Query();\n}\nfunction Btn_import_Click(){\n  this.pConnes.Value(this.Grid10.RowValue('CONNES',this.Grid10.CurrRow()));\n  if(confirm('Trasferire la seguente anagrafica?\\nCONNES:   '+ this.Grid10.RowValue('CONNES',this.Grid10.CurrRow())+'\\nRAGSOC:   '+ this.Grid10.RowValue('RAGSOC',this.Grid10.CurrRow()))){\n    \u002f\u002falert(this.pConnes.Value());  \n    this.SPLinker_insert_personbo.Link();\n  }\n}\nfunction SPLinker_insert_personbo_Result(result){\n  alert(result);  \n}","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"Importazione Anagrafica","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"700","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb3d;","font_image_hover":"&#xeb3e;","font_name":"ZucchettiDevelopement","font_size":"","h":"23","help_tips":"Applica filtri","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Image_zoom","page":"1","path_type":"","sequence":"1","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"25","wireframe_props":"","x":"494","y":"42","zindex":"2"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"likeragsoc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"2","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"83","wireframe_props":"name","x":"221","y":"43","zerofilling":"false","zindex":"13"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label17","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Filtro su RAGSOC:","w":"83","wireframe_props":"align,value,n_col","x":"221","y":"19","zindex":"14"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label19","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Filtro su CONNES:","w":"83","wireframe_props":"align,value,n_col","x":"135","y":"19","zindex":"16"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"likeconnes","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"5","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"83","wireframe_props":"name","x":"136","y":"43","zerofilling":"false","zindex":"17"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe918;","font_image_hover":"&#xe919;","font_name":"ZucchettiDevelopement","font_size":"","h":"23","help_tips":"Importa anagrafica","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Btn_import","page":"1","path_type":"","sequence":"6","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"25","wireframe_props":"","x":"544","y":"41","zindex":"8"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label21","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"7","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Filtro su CODFISC:","w":"83","wireframe_props":"align,value,n_col","x":"306","y":"19","zindex":"18"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"likecodfisc","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"83","wireframe_props":"name","x":"306","y":"43","zerofilling":"false","zindex":"19"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"title\":\"CONNES\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"title_align\":\"\",\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"field\":\"CONNES\",\"type\":\"C\"},{\"title\":\"RAGSOC\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"title_align\":\"\",\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"field\":\"RAGSOC\",\"type\":\"C\"},{\"field\":\"CODFISC\",\"title\":\"Codice Fiscale\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"DESCCIT\",\"title\":\"Città\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"PROVINCIA\",\"title\":\"Provincia\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CAP\",\"title\":\"CAP\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLDataobj_grid","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"200","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid10","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"false","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"9","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"442","wireframe_props":"colProperties,checkbox,rows","x":"131","y":"69","zindex":"9"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe962;","font_image_hover":"&#xe963;","font_name":"ZucchettiDevelopement","font_size":"","h":"23","help_tips":"Rimuovi Filtri","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"Image_rm_filter","page":"1","path_type":"","sequence":"10","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"25","wireframe_props":"","x":"519","y":"41","zindex":"20"},{"appendingData":"false","auto_exec":"false","count":"true","h":"20","localDBName":"","n_records":"500000","name":"SQLDataobj_grid","offline":"false","page":"1","parms":"likeragsoc=likeragsoc,likecodfisc=likecodfisc,likeconnes=likeconnes,likecitta=likecitta","parms_source":"","query":"rows:arfn_mcpersonbo_altrodb","query_async":"false","return_fields_type":"true","sequence":"11","type":"SQLDataobj","w":"282","x":"815","y":"-14"},{"align":"left","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Label25","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"12","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Filtro su CITTA:","w":"83","wireframe_props":"align,value,n_col","x":"392","y":"19","zindex":"21"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"likecitta","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"13","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"83","wireframe_props":"name","x":"392","y":"43","zerofilling":"false","zindex":"22"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"pConnes","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"14","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"282","wireframe_props":"name","x":"815","y":"9","zerofilling":"false","zindex":"24"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"function","name":"SPLinker_insert_personbo","offline":"false","page":"1","parms":"pconnes=pConnes","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"15","servlet":"arfn_migrazione_anagrafica_da_altro_db","target":"","type":"SPLinker","w":"282","x":"815","y":"32"},{"anchor":"","bg_color":"#F8E44F","font_color":"#232323","h":"68","hide":"","layout_steps_values":"{}","name":"Note40","page":"1","sequence":"16","type":"Note","value":"Il campo ServerName in cptsrvr deve essere valorizzato a: \"SORGENTE\" e viene letto direttamente nella functuion.","w":"282","wireframe_props":"","x":"815","y":"-87","zindex":"32"}]%>
<%/*Description:Importazione Anagrafica*/%>
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
window.pg_import_anagrafica_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image_zoom_Click !='undefined')this.Image_zoom_Click=Image_zoom_Click;
if(typeof Image_rm_filter_Click !='undefined')this.Image_rm_filter_Click=Image_rm_filter_Click;
if(typeof Btn_import_Click !='undefined')this.Btn_import_Click=Btn_import_Click;
if(typeof SPLinker_insert_personbo_Result !='undefined')this.SPLinker_insert_personbo_Result=SPLinker_insert_personbo_Result;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLDataobj_grid.addRowConsumer(this.Grid10);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Importazione ANAGRAFICA",true);
  this.SQLDataobj_grid.Query();  
}
function Image_zoom_Click(){ //applica i filtri settati
   this.SQLDataobj_grid.Query();
}
function Image_rm_filter_Click(){	//rimuove i filtri (tutti)
  this.likecodfisc.Value('');
  this.likeconnes.Value('');
  this.likeragsoc.Value('');
  this.likecitta.Value('');
  this.SQLDataobj_grid.Query();
}
function Btn_import_Click(){
  this.pConnes.Value(this.Grid10.RowValue('CONNES',this.Grid10.CurrRow()));
  if(confirm('Trasferire la seguente anagrafica?\nCONNES:   '+ this.Grid10.RowValue('CONNES',this.Grid10.CurrRow())+'\nRAGSOC:   '+ this.Grid10.RowValue('RAGSOC',this.Grid10.CurrRow()))){
    //alert(this.pConnes.Value());  
    this.SPLinker_insert_personbo.Link();
  }
}
function SPLinker_insert_personbo_Result(result){
  alert(result);  
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
.pg_import_anagrafica_container {
}
.pg_import_anagrafica_title_container {
  margin: auto;
}
.pg_import_anagrafica_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:700px;
  height:300px;
  background-color:#F3F3F3;
}
.pg_import_anagrafica_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.pg_import_anagrafica_portlet > .Image_zoom_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:42px;
  left:494px;
  left:70.57143%;
  right:181px;
  right:25.857143%;
  width:auto;
  height:23px;
}
.pg_import_anagrafica_portlet > .Image_zoom_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:23px;
  font-size:23px;
}
.pg_import_anagrafica_portlet > .likeragsoc_ctrl {
  box-sizing:border-box;
  z-index:13;
  position:absolute;
  display:inline-block;
  top:43px;
  left:221px;
  left:31.571428%;
  right:396px;
  right:56.57143%;
  width:auto;
  height:20px;
}
.pg_import_anagrafica_portlet > .likeragsoc_ctrl {
}
.pg_import_anagrafica_portlet > .likeragsoc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_anagrafica_portlet > .Label17_ctrl {
  box-sizing:border-box;
  z-index:14;
  position:absolute;
  display:inline-block;
  top:19px;
  left:221px;
  left:31.571428%;
  right:396px;
  right:56.57143%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label17_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label17_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_import_anagrafica_portlet > .Label19_ctrl {
  box-sizing:border-box;
  z-index:16;
  position:absolute;
  display:inline-block;
  top:19px;
  left:135px;
  left:19.285715%;
  right:482px;
  right:68.85714%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label19_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label19_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_import_anagrafica_portlet > .likeconnes_ctrl {
  box-sizing:border-box;
  z-index:17;
  position:absolute;
  display:inline-block;
  top:43px;
  left:136px;
  left:19.428572%;
  right:481px;
  right:68.71429%;
  width:auto;
  height:20px;
}
.pg_import_anagrafica_portlet > .likeconnes_ctrl {
}
.pg_import_anagrafica_portlet > .likeconnes_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_anagrafica_portlet > .Btn_import_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:41px;
  left:544px;
  left:77.71429%;
  right:131px;
  right:18.714285%;
  width:auto;
  height:23px;
}
.pg_import_anagrafica_portlet > .Btn_import_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:23px;
  font-size:23px;
}
.pg_import_anagrafica_portlet > .Label21_ctrl {
  box-sizing:border-box;
  z-index:18;
  position:absolute;
  display:inline-block;
  top:19px;
  left:306px;
  left:43.714287%;
  right:311px;
  right:44.42857%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label21_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label21_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_import_anagrafica_portlet > .likecodfisc_ctrl {
  box-sizing:border-box;
  z-index:19;
  position:absolute;
  display:inline-block;
  top:43px;
  left:306px;
  left:43.714287%;
  right:311px;
  right:44.42857%;
  width:auto;
  height:20px;
}
.pg_import_anagrafica_portlet > .likecodfisc_ctrl {
}
.pg_import_anagrafica_portlet > .likecodfisc_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_anagrafica_portlet > .Grid10_ctrl {
  box-sizing:border-box;
  z-index:9;
  position:absolute;
  display:inline-block;
  top:69px;
  left:131px;
  left:18.714285%;
  right:127px;
  right:18.142857%;
  width:auto;
  height:auto;
  min-height:200px;
}
.pg_import_anagrafica_portlet > .Image_rm_filter_ctrl {
  box-sizing:border-box;
  z-index:20;
  position:absolute;
  display:inline-block;
  top:41px;
  left:519px;
  left:74.14286%;
  right:156px;
  right:22.285715%;
  width:auto;
  height:23px;
}
.pg_import_anagrafica_portlet > .Image_rm_filter_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:23px;
  font-size:23px;
}
.pg_import_anagrafica_portlet > .Label25_ctrl {
  box-sizing:border-box;
  z-index:21;
  position:absolute;
  display:inline-block;
  top:19px;
  left:392px;
  left:56.0%;
  right:225px;
  right:32.142857%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label25_ctrl {
  height:auto;
  min-height:20px;
}
.pg_import_anagrafica_portlet > .Label25_ctrl {
  overflow:hidden;
  text-align:left;
}
.pg_import_anagrafica_portlet > .likecitta_ctrl {
  box-sizing:border-box;
  z-index:22;
  position:absolute;
  display:inline-block;
  top:43px;
  left:392px;
  left:56.0%;
  right:225px;
  right:32.142857%;
  width:auto;
  height:20px;
}
.pg_import_anagrafica_portlet > .likecitta_ctrl {
}
.pg_import_anagrafica_portlet > .likecitta_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_import_anagrafica_portlet > .pConnes_ctrl {
  box-sizing:border-box;
  z-index:24;
  position:absolute;
  display:inline-block;
  top:9px;
  left:815px;
  left:116.42857%;
  right:-397px;
  right:-56.714287%;
  width:auto;
  height:20px;
  display:none;
}
.pg_import_anagrafica_portlet > .pConnes_ctrl {
}
.pg_import_anagrafica_portlet > .pConnes_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"700\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"25\",\"x\":\"494\",\"y\":\"42\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"likeragsoc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"221\",\"y\":\"43\",\"zindex\":\"13\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label17\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Filtro su RAGSOC:\",\"w\":\"83\",\"x\":\"221\",\"y\":\"19\",\"zindex\":\"14\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label19\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Filtro su CONNES:\",\"w\":\"83\",\"x\":\"135\",\"y\":\"19\",\"zindex\":\"16\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"likeconnes\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"136\",\"y\":\"43\",\"zindex\":\"17\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"Btn_import\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"25\",\"x\":\"544\",\"y\":\"41\",\"zindex\":\"8\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label21\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Filtro su CODFISC:\",\"w\":\"83\",\"x\":\"306\",\"y\":\"19\",\"zindex\":\"18\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"likecodfisc\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"306\",\"y\":\"43\",\"zindex\":\"19\"},{\"align\":\"left\",\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"CONNES\"},{\"title\":\"RAGSOC\"},{\"title\":\"Codice Fiscale\"},{\"title\":\"Città\"},{\"title\":\"Provincia\"},{\"title\":\"CAP\"}],\"h\":\"200\",\"layout_steps_values\":{},\"name\":\"Grid10\",\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"442\",\"x\":\"131\",\"y\":\"69\",\"zindex\":\"9\"},{\"anchor\":\"\",\"h\":\"23\",\"layout_steps_values\":{},\"name\":\"Image_rm_filter\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"25\",\"x\":\"519\",\"y\":\"41\",\"zindex\":\"20\"},{\"h\":\"20\",\"name\":\"SQLDataobj_grid\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"282\",\"x\":\"815\",\"y\":\"-14\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label25\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Filtro su CITTA:\",\"w\":\"83\",\"x\":\"392\",\"y\":\"19\",\"zindex\":\"21\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"likecitta\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"83\",\"x\":\"392\",\"y\":\"43\",\"zindex\":\"22\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"pConnes\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"282\",\"x\":\"815\",\"y\":\"9\",\"zindex\":\"24\"},{\"h\":\"20\",\"name\":\"SPLinker_insert_personbo\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"282\",\"x\":\"815\",\"y\":\"32\"},{\"anchor\":\"\",\"h\":\"68\",\"layout_steps_values\":{},\"name\":\"Note40\",\"page\":\"1\",\"type\":\"Note\",\"value\":\"Il campo ServerName in cptsrvr deve essere valorizzato a: \\\"SORGENTE\\\" e viene letto direttamente nella functuion.\",\"w\":\"282\",\"x\":\"815\",\"y\":\"-87\",\"zindex\":\"32\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_import_anagrafica","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_import_anagrafica_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
.pg_import_anagrafica_portlet > .pConnes_ctrl {
  display:none;
}

</style>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_import_anagrafica','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String likeragsoc= "";
if(request.getAttribute("pg_import_anagrafica_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label17= "Filtro su RAGSOC:";
String Label19= "Filtro su CONNES:";
String likeconnes= "";
String Label21= "Filtro su CODFISC:";
String likecodfisc= "";
if(request.getAttribute("pg_import_anagrafica_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String Label25= "Filtro su CITTA:";
String likecitta= "";
String pConnes= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_import_anagrafica_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_import_anagrafica_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_import_anagrafica_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_import_anagrafica','<%=idPortlet%>',false,'');
</script><%}}%>
<a id='<%=idPortlet%>_Image_zoom' class='image-default Image_zoom_ctrl'   target=''>&#xeb3d;</a>
<span class='textbox-container'id='<%=idPortlet%>_likeragsoc_wrp'><input id='<%=idPortlet%>_likeragsoc' name='likeragsoc' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='likeragsoc' /></span>
<span id='<%=idPortlet%>_Label17'  formid='<%=idPortlet%>' ps-name='Label17'    class='label Label17_ctrl'><div id='<%=idPortlet%>_Label17tbl' style='width:100%;'><%=JSPLib.ToHTML("Filtro su RAGSOC:")%></div></span>
<span id='<%=idPortlet%>_Label19'  formid='<%=idPortlet%>' ps-name='Label19'    class='label Label19_ctrl'><div id='<%=idPortlet%>_Label19tbl' style='width:100%;'><%=JSPLib.ToHTML("Filtro su CONNES:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_likeconnes_wrp'><input id='<%=idPortlet%>_likeconnes' name='likeconnes' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='likeconnes' /></span>
<a id='<%=idPortlet%>_Btn_import' class='image-default Btn_import_ctrl'   target=''>&#xe918;</a>
<span id='<%=idPortlet%>_Label21'  formid='<%=idPortlet%>' ps-name='Label21'    class='label Label21_ctrl'><div id='<%=idPortlet%>_Label21tbl' style='width:100%;'><%=JSPLib.ToHTML("Filtro su CODFISC:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_likecodfisc_wrp'><input id='<%=idPortlet%>_likecodfisc' name='likecodfisc' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='likecodfisc' /></span>
<div id='<%=idPortlet%>_Grid10' formid='<%=idPortlet%>' ps-name='Grid10'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_Image_rm_filter' class='image-default Image_rm_filter_ctrl'   target=''>&#xe962;</a>
<span id='<%=idPortlet%>_Label25'  formid='<%=idPortlet%>' ps-name='Label25'    class='label Label25_ctrl'><div id='<%=idPortlet%>_Label25tbl' style='width:100%;'><%=JSPLib.ToHTML("Filtro su CITTA:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_likecitta_wrp'><input id='<%=idPortlet%>_likecitta' name='likecitta' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='likecitta' /></span>
<span class='textbox-container'id='<%=idPortlet%>_pConnes_wrp'><input id='<%=idPortlet%>_pConnes' name='pConnes' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='pConnes' /></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_import_anagrafica');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_import_anagrafica',["700"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"700","h":"300","title":"","layer":"false","npage":"1"}]);
this.Image_zoom=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image_zoom_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_zoom","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb3d;","font_image_hover":"&#xeb3e;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":23,"help_tips":"<%=JSPLib.ToJSValue("Applica filtri",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_zoom","page":1,"path_type":"","server_side":"","src":"&#xeb3d;","srchover":"&#xeb3e;","tabindex":"","target":"","type":"Image","type_submit":"false","w":25,"x":494,"y":42,"zindex":"2"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.likeragsoc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_likeragsoc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"likeragsoc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(likeragsoc,false,true)%>","w":83,"x":221,"y":43,"zerofilling":false,"zindex":"13","zoom":""});
this.Label17=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label17","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label17","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label17,false,true)%>","type":"Label","w":83,"x":221,"y":19,"zindex":"14"});
this.Label19=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label19","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label19","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label19,false,true)%>","type":"Label","w":83,"x":135,"y":19,"zindex":"16"});
this.likeconnes=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_likeconnes","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"likeconnes","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(likeconnes,false,true)%>","w":83,"x":136,"y":43,"zerofilling":false,"zindex":"17","zoom":""});
this.Btn_import=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Btn_import_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Btn_import","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe918;","font_image_hover":"&#xe919;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":23,"help_tips":"<%=JSPLib.ToJSValue("Importa anagrafica",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Btn_import","page":1,"path_type":"","server_side":"","src":"&#xe918;","srchover":"&#xe919;","tabindex":"","target":"","type":"Image","type_submit":"false","w":25,"x":544,"y":41,"zindex":"8"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Label21=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label21","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label21","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label21,false,true)%>","type":"Label","w":83,"x":306,"y":19,"zindex":"18"});
this.likecodfisc=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_likecodfisc","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"likecodfisc","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(likecodfisc,false,true)%>","w":83,"x":306,"y":43,"zerofilling":false,"zindex":"19","zoom":""});
this.Grid10=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid10","dataobj":"SQLDataobj_grid","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":200,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"false","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid10","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":442,"x":131,"y":69,"zindex":"9"});
this.Grid10.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"CONNES","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","droppable_name":"","field":"CONNES","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"RAGSOC","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","droppable_name":"","field":"RAGSOC","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Codice Fiscale","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CODFISC","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Città","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DESCCIT","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Provincia","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"PROVINCIA","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"CAP","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CAP","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Image_rm_filter=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left(%)-right(%)","boundedPosition":"","class_Css":"image-default Image_rm_filter_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image_rm_filter","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe962;","font_image_hover":"&#xe963;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":23,"help_tips":"<%=JSPLib.ToJSValue("Rimuovi Filtri",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image_rm_filter","page":1,"path_type":"","server_side":"","src":"&#xe962;","srchover":"&#xe963;","tabindex":"","target":"","type":"Image","type_submit":"false","w":25,"x":519,"y":41,"zindex":"20"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.SQLDataobj_grid=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"rows:arfn_mcpersonbo_altrodb","cmdHash":"<%=JSPLib.cmdHash("rows:arfn_mcpersonbo_altrodb",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLDataobj_grid","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_grid","nrows":"500000","page":1,"parms":"likeragsoc=likeragsoc,likecodfisc=likecodfisc,likeconnes=likeconnes,likecitta=likecitta","parms_source":"","type":"SQLDataobj","w":282,"x":815,"y":-14});
this.Label25=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label25","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label25","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(Label25,false,true)%>","type":"Label","w":83,"x":392,"y":19,"zindex":"21"});
this.likecitta=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_likecitta","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"likecitta","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(likecitta,false,true)%>","w":83,"x":392,"y":43,"zerofilling":false,"zindex":"22","zoom":""});
this.pConnes=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_pConnes","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"true","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"pConnes","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(pConnes,false,true)%>","w":282,"x":815,"y":9,"zerofilling":false,"zindex":"24","zoom":""});
this.SPLinker_insert_personbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPLinker_insert_personbo","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPLinker_insert_personbo","offline":false,"page":1,"parms":"pconnes=pConnes","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_migrazione_anagrafica_da_altro_db","target":"","type":"SPLinker","w":282,"x":815,"y":32});
this.SPLinker_insert_personbo.m_cID='<%=JSPLib.cmdHash("routine,arfn_migrazione_anagrafica_da_altro_db",request.getSession())%>';
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
<%if(request.getAttribute("pg_import_anagrafica_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_import_anagrafica_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_import_anagrafica_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image_zoom.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Btn_import.dispatchEvent('OnLoad');
window.<%=idPortlet%>.Image_rm_filter.dispatchEvent('OnLoad');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_import_anagrafica',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_import_anagrafica');
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
sp.endPage("pg_import_anagrafica");
}%>
<%! public String getJSPUID() { return "2905343762"; } %>