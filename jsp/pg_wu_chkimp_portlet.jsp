<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Verifica Record Scartati\",true)\n  this.getTitlePortlet().SetSubTitle(\"\",true)\n}\n\nfunction BtnUscita_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link()\n  }    \n}\n\nfunction BtnSearch_Click(){\n  this.SQLErrori.Query()\n}\n\nfunction BtnStp_Click(){\n  if(confirm(\"Confermi la stampa dell'elenco?\")){\n    this.RTStampa.Link()\n  }  \n}\n\nfunction BtnXLS_Click(){\n  if(confirm(\"Confermi l'estrazine della lista in excel?\")){\n    this.RTExcel.Link()\n  }  \n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"650","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"10000","name":"SQLErrori","offline":"false","page":"1","parms":"w_WUCODMAGE=WUCODMAGE,w","parms_source":"","query":"qbe_wu_chkimp","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"3","y":"-59"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"WUCODMAGE\",\"title\":\"MacroAgente\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WURIFMTCN\",\"title\":\"MTCN\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"SPLink:RTCHKIMP\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WUTIPOPE\",\"title\":\"Tipo Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"130\",\"fixedwidth\":\"130\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WUDATOPE\",\"title\":\"Data Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"130\",\"fixedwidth\":\"130\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WUCOGCLI\",\"title\":\"Cognome Cliente\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WUNOMCLI\",\"title\":\"Nome Cliente\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WUNOMEFILE\",\"title\":\"Nome File\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"WUCODICE\",\"title\":\"WUCODICE\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\",\"hidden\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLErrori","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,C,C,C,D,C,C,C,D,C,,,","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"479","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grdOperazioni","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"RecordSelezionato","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_result":"false","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"2","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"46","zindex":""},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il bottone per chiudere la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"BtnUscita","page":"1","path_type":"","sequence":"3","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"987","y":"9","zindex":"1"},{"async":"false","entity_type":"master","h":"30","m_cAction":"view","m_cAltInterface":"","name":"RTCHKIMP","offline":"false","page":"1","parms":"WUCODICE=codice","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"4","servlet":"armt_wu_chkerr","target":"","type":"SPLinker","w":"112","x":"150","y":"-62"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il bottone per chiudere la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"BtnStp","page":"1","path_type":"","sequence":"5","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"906","y":"9","zindex":"1"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Estrae i movimenti errati su un file excel","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"BtnXLS","page":"1","path_type":"","sequence":"6","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"948","y":"9","zindex":"1"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"SQLErrori","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"WUCODICE","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"","name":"codice","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"7","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"120","wireframe_props":"name","x":"910","y":"623","zerofilling":"false","zindex":"2"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"5","name":"WUCODMAGE","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"60","wireframe_props":"name","x":"104","y":"14","zerofilling":"false","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"lblMacro","nowrap":"false","page":"1","picture":"","sanitize":"","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"MacroAgente:","w":"95","wireframe_props":"align,value,n_col","x":"5","y":"15","zindex":"4"},{"anchor":"","calculateZoomTitle":"","configname":"","defaultsfunction":"","fillemptykeys":"false","fixedvars":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"20","hide":"false","image":"","img_type":"default","intovars":"WUCODMAGE,xMADESCRI","keyfixedfilters":"","layout_steps_values":"{}","linkedField":"WUCODMAGE","linkedUsing":"","looselylinked":"false","n_criteria":"2","name":"LinkZoom9","offline":"false","page":"1","path_type":"","queryparms":"","readfields":"MACODICE,MADESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":"false","sequence":"10","servlet":"","suggest":"true","table":"tbmacage","type":"LinkZoom","w":"20","wireframe_props":"","x":"166","y":"15","zindex":"5","zoomtitle":""},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{}","maxlength":"60","name":"xMADESCRI","page":"1","password":"","picture":"","placeholder":"","readonly":"true","scroll":"false","sequence":"11","tabindex":"","type":"Textbox","typevar":"character","visible":"true","w":"450","wireframe_props":"name","x":"193","y":"14","zerofilling":"false","zindex":"6"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb3d;","font_image_hover":"&#xeb3e;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premere il bottone per chiudere la finestra","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{}","name":"BtnSearch","page":"1","path_type":"","sequence":"13","server_side":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"864","y":"9","zindex":"1"},{"async":"false","entity_type":"report","h":"20","m_cAction":"","m_cAltInterface":"","name":"RTStampa","offline":"false","page":"1","parms":"ReportName=arrp_wu_chkimp,outputFormat=PDF,rotation=LANDSCAPE,w_WUCODMAGE=WUCODMAGE,w_xMADESCRI=xMADESCRI","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"14","servlet":"","target":"","type":"SPLinker","w":"120","x":"283","y":"-60"},{"async":"false","entity_type":"routine","h":"20","m_cAction":"start","m_cAltInterface":"","name":"RTExcel","offline":"false","page":"1","parms":"w_WUCODMAGE=WUCODMAGE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"16","servlet":"arrt_wu_chkimp","target":"","type":"SPLinker","w":"120","x":"416","y":"-57"},{"async":"false","entity_type":"","h":"20","m_cAction":"","m_cAltInterface":"","name":"RTUscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"18","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"120","x":"550","y":"-55"}]%>
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
window.pg_wu_chkimp_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof BtnUscita_Click !='undefined')this.BtnUscita_Click=BtnUscita_Click;
if(typeof BtnSearch_Click !='undefined')this.BtnSearch_Click=BtnSearch_Click;
if(typeof BtnStp_Click !='undefined')this.BtnStp_Click=BtnStp_Click;
if(typeof BtnXLS_Click !='undefined')this.BtnXLS_Click=BtnXLS_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLErrori.addRowConsumer(this.grdOperazioni);
this.SQLErrori.addDataConsumer(this.codice,<%=JSPLib.ToJSValue("WUCODICE",true)%>);
this.LinkZoom9.addObserverFixedVars();
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Verifica Record Scartati",true)
  this.getTitlePortlet().SetSubTitle("",true)
}
function BtnUscita_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link()
  }    
}
function BtnSearch_Click(){
  this.SQLErrori.Query()
}
function BtnStp_Click(){
  if(confirm("Confermi la stampa dell'elenco?")){
    this.RTStampa.Link()
  }  
}
function BtnXLS_Click(){
  if(confirm("Confermi l'estrazine della lista in excel?")){
    this.RTExcel.Link()
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
.pg_wu_chkimp_container {
}
.pg_wu_chkimp_title_container {
  margin: auto;
}
.pg_wu_chkimp_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:650px;
  background-color:#FFFFFF;
}
.pg_wu_chkimp_portlet[Data-page="1"]{
  height:650px;
  width:100%;
}
.pg_wu_chkimp_portlet > .grdOperazioni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:46px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:479px;
}
.pg_wu_chkimp_portlet > .BtnUscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  right:7px;
  width:30px;
  height:30px;
}
.pg_wu_chkimp_portlet > .BtnUscita_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_wu_chkimp_portlet > .BtnStp_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  right:88px;
  width:30px;
  height:30px;
}
.pg_wu_chkimp_portlet > .BtnStp_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_wu_chkimp_portlet > .BtnXLS_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  right:46px;
  width:30px;
  height:30px;
}
.pg_wu_chkimp_portlet > .BtnXLS_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_wu_chkimp_portlet > .codice_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:0px;
  height:0px;
}
.pg_wu_chkimp_portlet > .codice_ctrl {
  display:none;
}
.pg_wu_chkimp_portlet > .codice_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wu_chkimp_portlet > .WUCODMAGE_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:14px;
  left:104px;
  width:60px;
  height:20px;
}
.pg_wu_chkimp_portlet > .WUCODMAGE_ctrl {
}
.pg_wu_chkimp_portlet > .WUCODMAGE_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wu_chkimp_portlet > .lblMacro_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:15px;
  left:5px;
  width:95px;
  height:auto;
  min-height:20px;
}
.pg_wu_chkimp_portlet > .lblMacro_ctrl {
  height:auto;
  min-height:20px;
}
.pg_wu_chkimp_portlet > .lblMacro_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_wu_chkimp_portlet > .LinkZoom9_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:15px;
  left:166px;
  width:20px;
  height:20px;
}
.pg_wu_chkimp_portlet > .xMADESCRI_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:14px;
  left:193px;
  width:450px;
  height:20px;
}
.pg_wu_chkimp_portlet > .xMADESCRI_ctrl {
}
.pg_wu_chkimp_portlet > .xMADESCRI_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_wu_chkimp_portlet > .BtnSearch_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:9px;
  right:130px;
  width:30px;
  height:30px;
}
.pg_wu_chkimp_portlet > .BtnSearch_ctrl {
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
 String def="[{\"h\":\"650\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"3\",\"y\":\"-59\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"MacroAgente\"},{\"title\":\"MTCN\"},{\"title\":\"Tipo Operazione\"},{\"title\":\"Data Operazione\"},{\"title\":\"Cognome Cliente\"},{\"title\":\"Nome Cliente\"},{\"title\":\"Nome File\"},{\"title\":\"WUCODICE\"}],\"h\":\"479\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"46\",\"zindex\":\"\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"987\",\"y\":\"9\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"112\",\"x\":\"150\",\"y\":\"-62\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"906\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"948\",\"y\":\"9\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"codice\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"120\",\"x\":\"910\",\"y\":\"623\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"WUCODMAGE\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"60\",\"x\":\"104\",\"y\":\"14\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"lblMacro\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"MacroAgente:\",\"w\":\"95\",\"x\":\"5\",\"y\":\"15\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"LinkZoom9\",\"page\":\"1\",\"type\":\"LinkZoom\",\"w\":\"20\",\"x\":\"166\",\"y\":\"15\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"xMADESCRI\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"450\",\"x\":\"193\",\"y\":\"14\",\"zindex\":\"6\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{},\"name\":\"BtnSearch\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"864\",\"y\":\"9\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"RTStampa\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"283\",\"y\":\"-60\"},{\"h\":\"20\",\"name\":\"RTExcel\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"416\",\"y\":\"-57\"},{\"h\":\"20\",\"name\":\"RTUscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"550\",\"y\":\"-55\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_wu_chkimp","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_wu_chkimp_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_wu_chkimp','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_wu_chkimp_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String codice= "";
if(request.getAttribute("pg_wu_chkimp_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String WUCODMAGE= "";
String lblMacro= "MacroAgente:";
if(request.getAttribute("pg_wu_chkimp_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>'></script>
<%}
String xMADESCRI= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_wu_chkimp_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_wu_chkimp_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_wu_chkimp_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_wu_chkimp','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_grdOperazioni' formid='<%=idPortlet%>' ps-name='grdOperazioni'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_BtnUscita' class='image BtnUscita_ctrl'   target=''>&#xe9fb;</a>
<a id='<%=idPortlet%>_BtnStp' class='image BtnStp_ctrl'   target=''>&#xeb05;</a>
<a id='<%=idPortlet%>_BtnXLS' class='image BtnXLS_ctrl'   target=''>&#xea8c;</a>
<span class='textbox-container'id='<%=idPortlet%>_codice_wrp'><input id='<%=idPortlet%>_codice' name='codice' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='codice' /></span>
<span class='textbox-container'id='<%=idPortlet%>_WUCODMAGE_wrp'><input id='<%=idPortlet%>_WUCODMAGE' name='WUCODMAGE' type='text' maxlength='5' class='textbox' formid='<%=idPortlet%>' ps-name='WUCODMAGE' /></span>
<span id='<%=idPortlet%>_lblMacro'  formid='<%=idPortlet%>' ps-name='lblMacro'    class='label lblMacro_ctrl'><div id='<%=idPortlet%>_lblMacrotbl' style='width:100%;'><%=JSPLib.ToHTML("MacroAgente:")%></div></span>
<%out.print(Library.GenerateIcon(Library.GetStyleVariable(sp.getSkin(), "formLinkedFieldEnabledImage", "../"+sp.getSkin()+"/formPage/zoom_enabled.gif"), "border:0;", null, "href='javascript:void(0);' class='' id='"+idPortlet+"_LinkZoom9'" ) );%>
<span class='textbox-container'id='<%=idPortlet%>_xMADESCRI_wrp'><input id='<%=idPortlet%>_xMADESCRI' name='xMADESCRI' type='text' disabled maxlength='60' class='textbox' formid='<%=idPortlet%>' ps-name='xMADESCRI' /></span>
<a id='<%=idPortlet%>_BtnSearch' class='image BtnSearch_ctrl'   target=''>&#xeb3d;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_wu_chkimp');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_wu_chkimp',["1024"],["650"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"650","title":"","layer":"false","npage":"1"}]);
this.SQLErrori=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_wu_chkimp","cmdHash":"<%=JSPLib.cmdHash("qbe_wu_chkimp",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLErrori","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLErrori","nrows":"10000","page":1,"parms":"w_WUCODMAGE=WUCODMAGE,w","parms_source":"","type":"SQLDataobj","w":120,"x":3,"y":-59});
this.grdOperazioni=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdOperazioni","dataobj":"SQLErrori","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":479,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grdOperazioni","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"RecordSelezionato","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":46,"zindex":""});
this.grdOperazioni.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"MacroAgente","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WUCODMAGE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"SPLink:RTCHKIMP","fixedwidth":"","title":"MTCN","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WURIFMTCN","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"130","title":"Tipo Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WUTIPOPE","droppable_name":"","fg_color":"","width":"130","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"130","title":"Data Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WUDATOPE","droppable_name":"","fg_color":"","width":"130","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Cognome Cliente","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WUCOGCLI","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Nome Cliente","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WUNOMCLI","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Nome File","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WUNOMEFILE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"WUCODICE","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"WUCODICE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.BtnUscita=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnUscita_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnUscita","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il bottone per chiudere la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnUscita","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":987,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTCHKIMP=new ZtVWeb.SPLinkerCtrl(this,{"action":"view","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCHKIMP","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCHKIMP","offline":false,"page":1,"parms":"WUCODICE=codice","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"armt_wu_chkerr","target":"","type":"SPLinker","w":112,"x":150,"y":-62});
this.RTCHKIMP.m_cID='<%=JSPLib.cmdHash("entity,armt_wu_chkerr",request.getSession())%>';
this.BtnStp=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnStp_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnStp","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb05;","font_image_hover":"&#xeb06;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il bottone per chiudere la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnStp","page":1,"path_type":"","server_side":"","src":"&#xeb05;","srchover":"&#xeb06;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":906,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.BtnXLS=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnXLS_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnXLS","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xea8c;","font_image_hover":"&#xea8d;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Estrae i movimenti errati su un file excel",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnXLS","page":1,"path_type":"","server_side":"","src":"&#xea8c;","srchover":"&#xea8d;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":948,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.codice=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_codice","decrypt":false,"edit_undercond":"","encrypt":false,"field":"WUCODICE","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"codice","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(codice,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"2","zoom":""});
this.WUCODMAGE=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_WUCODMAGE","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"5","name":"WUCODMAGE","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(WUCODMAGE,false,true)%>","w":60,"x":104,"y":14,"zerofilling":false,"zindex":"3","zoom":""});
this.lblMacro=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblMacro","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblMacro","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(lblMacro,false,true)%>","type":"Label","w":95,"x":5,"y":15,"zindex":"4"});
this.LinkZoom9=new ZtVWeb.LinkZoomCtrl(this,{"advanced_suggester":"","advanced_suggester_height":"","advanced_suggester_modal":false,"advanced_suggester_width":"","anchor":"top-left","class_Css":"","configname":"","ctrlid":"<%=idPortlet%>_LinkZoom9","defaultsfunction":"","defaultsfunction_zoom":false,"entityName":"\u002fjsp\u002fpg_wu_chkimp_portlet.jsp","fillemptykeys":false,"fixedvars":"","h":20,"hide":"false","image":"","intovars":"WUCODMAGE,xMADESCRI","intovarsType":"C,C","keyfixedfilters":"","layer":false,"layout_steps_values":{},"link_id_hash":"<%=JSPLib.cmdHash("/jsp/pg_wu_chkimp_portlet.jspLinkZoom9",request.getSession())%>","linkedField":"WUCODMAGE","linkedUsing":"","looselylinked":false,"n_criteria":"2","name":"LinkZoom9","offline":false,"openZoomOnMultipleRecord":true,"page":1,"path_type":"","queryparms":"","readfields":"MACODICE,MADESCRI","row_suggest":"10","searchingfunction":"","sendkeystozoomonzoom":false,"servlet":"","spztl":"<%=JSPLib.cmdHash("link,tbmacage,default",request.getSession())%>","suggest":true,"table":"tbmacage","type":"LinkZoom","w":20,"x":166,"y":15,"zindex":"5","zoomtitle":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>"});
this.xMADESCRI=new ZtVWeb._TC(this,{"anchor":"top-left","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_xMADESCRI","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"60","name":"xMADESCRI","page":1,"picker":"","picture":"","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(xMADESCRI,false,true)%>","w":450,"x":193,"y":14,"zerofilling":false,"zindex":"6","zoom":""});
this.BtnSearch=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnSearch_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnSearch","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xeb3d;","font_image_hover":"&#xeb3e;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premere il bottone per chiudere la finestra",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnSearch","page":1,"path_type":"","server_side":"","src":"&#xeb3d;","srchover":"&#xeb3e;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":864,"y":9,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.RTStampa=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTStampa","decrypted_parms":"","entity_type":"report","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTStampa","offline":false,"page":1,"parms":"ReportName=arrp_wu_chkimp,outputFormat=PDF,rotation=LANDSCAPE,w_WUCODMAGE=WUCODMAGE,w_xMADESCRI=xMADESCRI","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"","target":"","type":"SPLinker","w":120,"x":283,"y":-60});
this.RTStampa.m_cID='<%=JSPLib.cmdHash("entity,empty",request.getSession())%>';
this.RTExcel=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTExcel","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTExcel","offline":false,"page":1,"parms":"w_WUCODMAGE=WUCODMAGE","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_wu_chkimp","target":"","type":"SPLinker","w":120,"x":416,"y":-57});
this.RTExcel.m_cID='<%=JSPLib.cmdHash("routine,arrt_wu_chkimp",request.getSession())%>';
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTUscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":120,"x":550,"y":-55});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
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
<%if(request.getAttribute("pg_wu_chkimp_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_wu_chkimp_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_wu_chkimp_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.BtnUscita.dispatchEvent('OnLoad');
window.<%=idPortlet%>.BtnStp.dispatchEvent('OnLoad');
window.<%=idPortlet%>.BtnXLS.dispatchEvent('OnLoad');
window.<%=idPortlet%>.BtnSearch.dispatchEvent('OnLoad');
window.<%=idPortlet%>.SQLErrori.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_wu_chkimp',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_wu_chkimp');
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
sp.endPage("pg_wu_chkimp");
}%>
<%! public Library.SPLinkProperties getLinkProperties(String p_cControlName) {
if (Library.eq(p_cControlName,"LinkZoom9")) {
  Library.SPLinkProperties result = Library.GetSPLinkerProperties();
  result.m_TableName = "tbmacage";
  result.n_KMode = 2;
  result.m_FillEmpty = false;
  result.m_LooselyLinked = false;
  result.m_dynamicprgzoom = false;
  result.m_SearchingFunction = "";
  result.m_PrgZoom = "";
  result.m_SuggestRows = 10;
  result.m_rdField = new String[]{"MACODICE", "MADESCRI"};
  result.m_rdTypes = new String[]{"C", "C"};
  result.m_kField = new String[]{};
  result.m_kTypes = new String[]{};
  return result;
}
return null;
}/**/%>
<%! public String getJSPUID() { return "1152578696"; } %>