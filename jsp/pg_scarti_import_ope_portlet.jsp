<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Gestione Scarti Import\",true)\n}\n\nfunction btnCHG_Click(){\n  if(confirm(\"Confermi il cambio di partita IVA?\")) {\n    this.pLog.Timer0.Start()\n    this.pMsg.Timer0.Start()\n    this.SPChgPIVA.Link()\n  }  \n}\n\nfunction SPChgPIVA_Executed(result,cError){\n  this.pLog.Timer0_onTimer()\n  this.pMsg.Timer0_onTimer()\n  this.pLog.Timer0.Stop()\n  this.pMsg.Timer0.Stop()\n  this.Grid1.Refresh()\n}\n\nfunction Aggiorna(_evt){\n  this.SQLScarti.Query()\n  this.Grid1.Refresh() \n}  ","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"650","hsl":"","htmlcode":"{{ @pMsg }}\n{{ @pLog }}\n{{ @iExec }}\n{{ @btnCHG }}\n{{ @SPChgPIVA }}\n{{ @Label5_Copy }}\n{{ @partiva_right }}\n{{ @Label5 }}\n{{ @partiva_err }}\n{{ @Grid1 }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"1024","version":"37","w":"100%","wizard":""},{"allowedqueries":"qbe_scarti_import","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"15","name":"SQLScarti","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_scarti_import","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"1040","y":"-83"},{"anchor":"top-left-right","h":"67","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pMsg","page":"1","sequence":"2","spuid":"","src":"showmsg_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"577","zindex":"3"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label5_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"3","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"P. IVA Corretta:","w":"140","wireframe_props":"align,value,n_col","x":"309","y":"14","zindex":"6"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"IMPPROG\",\"title\":\"ID SCarto\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"},{\"field\":\"TIPOOPER\",\"title\":\"Tipo Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"NUMPROG\",\"title\":\"ID Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"DATAOPE\",\"title\":\"Data Operazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CONNESCLI\",\"title\":\"CLiente\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CONNESREAL\",\"title\":\"Esecutore\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CONNESBEN\",\"title\":\"Soggetto Servito\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CONNALTRO\",\"title\":\"Controparte\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"IMPORTO\",\"title\":\"Importo\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"right\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"999,999,999.99\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"N\",\"title_align\":\"\"},{\"field\":\"TXTERR\",\"title\":\"Errori Rilevati\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"center\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"M\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLScarti","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"true-by-example","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"373","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid1","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"4","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"SPEditScarti -n -v","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":"1024","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"46","zindex":"2"},{"alt":"","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"#F5182D","font_image":"&#xeae2;","font_image_hover":"","font_name":"icons8_win10","font_size":"","h":"26","help_tips":"","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"btnCHG","page":"1","path_type":"","sequence":"5","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"29","wireframe_props":"","x":"587","y":"12","zindex":"7"},{"allowedentities":"opemt_scarti_import","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"20","m_cAction":"","name":"SPEditScarti","offline":"false","page":"1","parms":"IMPPROG=idimport","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"opemt_scarti_import","target":"","type":"SPLinker","w":"120","x":"1047","y":"-53"},{"calculate":"","dataobj":"SQLScarti","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IMPPROG","h":"20","init":"","init_par":"","name":"idimport","page":"1","reactive":"","sequence":"7","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"1194","y":"-80"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"11","name":"partiva_err","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"8","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"114","wireframe_props":"name","x":"161","y":"14","zerofilling":"false","zindex":"5"},{"align":"right","anchor":"","assoc_input":"","bg_color":"","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"Label5","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"9","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"P. IVA Errata:","w":"140","wireframe_props":"align,value,n_col","x":"11","y":"14","zindex":"6"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"","font_color":"","font_size":"","h":"20","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"11","name":"partiva_right","page":"1","password":"","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"10","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"114","wireframe_props":"name","x":"459","y":"14","zerofilling":"false","zindex":"5"},{"allowedentities":"opert_chgpiva","async":"false","check_exp":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"SPChgPIVA","offline":"false","page":"1","parms":"pIVA1=partiva_err,pIVA2=partiva_right","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"11","servlet":"opert_chgpiva","target":"","type":"SPLinker","w":"120","x":"1053","y":"-25"},{"anchor":"","auto_resize":"false","border":"","default_portlet":"","h":"1","hide":"false","layer":"false","layout_steps_values":"{}","name":"iExec","page":"1","sequence":"12","spuid":"","type":"Iframe","w":"1","wireframe_props":"","x":"7","y":"578","zindex":"8"},{"anchor":"top-left-right","h":"143","hide":"false","isoptional":"false","layer":"false","layout_steps_values":"{}","name":"pLog","page":"1","sequence":"13","spuid":"","src":"showlog_portlet.jsp","themed":"false","type":"Portlet","w":"1024","wireframe_props":"","x":"0","y":"432","zindex":"3"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"opemt_scarti_import_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"14","type":"EventReceiver","w":"120","x":"1066","y":"47"}]%>
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
window.pg_scarti_import_ope_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btnCHG_Click !='undefined')this.btnCHG_Click=btnCHG_Click;
if(typeof SPChgPIVA_Executed !='undefined')this.SPChgPIVA_Executed=SPChgPIVA_Executed;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLScarti.addRowConsumer(this.Grid1);
this.SQLScarti.addDataConsumer(this.idimport,<%=JSPLib.ToJSValue("IMPPROG",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Gestione Scarti Import",true)
}
function btnCHG_Click(){
  if(confirm("Confermi il cambio di partita IVA?")) {
    this.pLog.Timer0.Start()
    this.pMsg.Timer0.Start()
    this.SPChgPIVA.Link()
  }  
}
function SPChgPIVA_Executed(result,cError){
  this.pLog.Timer0_onTimer()
  this.pMsg.Timer0_onTimer()
  this.pLog.Timer0.Stop()
  this.pMsg.Timer0.Stop()
  this.Grid1.Refresh()
}
function Aggiorna(_evt){
  this.SQLScarti.Query()
  this.Grid1.Refresh() 
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
.pg_scarti_import_ope_container {
}
.pg_scarti_import_ope_title_container {
  margin: auto;
}
.pg_scarti_import_ope_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:1024px;
  height:650px;
  background-color:#F3F3F3;
}
.pg_scarti_import_ope_portlet[Data-page="1"]{
  height:650px;
  width:100%;
}
.pg_scarti_import_ope_portlet > .pMsg_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:577px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:67px;
}
.pg_scarti_import_ope_portlet > .Label5_Copy_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:14px;
  left:309px;
  width:140px;
  height:auto;
  min-height:20px;
}
.pg_scarti_import_ope_portlet > .Label5_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_scarti_import_ope_portlet > .Label5_Copy_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_scarti_import_ope_portlet > .Grid1_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:46px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:373px;
}
.pg_scarti_import_ope_portlet > .btnCHG_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:12px;
  left:587px;
  width:29px;
  height:26px;
}
.pg_scarti_import_ope_portlet > .btnCHG_ctrl {
  text-decoration:none;
  font-family:icons8_win10;
  text-align:center;
  line-height:26px;
  font-size:26px;
}
.pg_scarti_import_ope_portlet > .partiva_err_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:14px;
  left:161px;
  width:114px;
  height:20px;
}
.pg_scarti_import_ope_portlet > .partiva_err_ctrl {
}
.pg_scarti_import_ope_portlet > .partiva_err_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_scarti_import_ope_portlet > .Label5_ctrl {
  box-sizing:border-box;
  z-index:6;
  position:absolute;
  display:inline-block;
  top:14px;
  left:11px;
  width:140px;
  height:auto;
  min-height:20px;
}
.pg_scarti_import_ope_portlet > .Label5_ctrl {
  height:auto;
  min-height:20px;
}
.pg_scarti_import_ope_portlet > .Label5_ctrl {
  overflow:hidden;
  text-align:right;
}
.pg_scarti_import_ope_portlet > .partiva_right_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:14px;
  left:459px;
  width:114px;
  height:20px;
}
.pg_scarti_import_ope_portlet > .partiva_right_ctrl {
}
.pg_scarti_import_ope_portlet > .partiva_right_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_scarti_import_ope_portlet > .iExec_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:578px;
  left:7px;
  width:1px;
  height:1px;
}
.pg_scarti_import_ope_portlet > .pLog_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:432px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:143px;
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
 String def="[{\"h\":\"650\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"1040\",\"y\":\"-83\"},{\"anchor\":\"top-left-right\",\"h\":\"67\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"577\",\"zindex\":\"3\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"P. IVA Corretta:\",\"w\":\"140\",\"x\":\"309\",\"y\":\"14\",\"zindex\":\"6\"},{\"align\":\"left\",\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ID SCarto\"},{\"title\":\"Tipo Operazione\"},{\"title\":\"ID Operazione\"},{\"title\":\"Data Operazione\"},{\"title\":\"CLiente\"},{\"title\":\"Esecutore\"},{\"title\":\"Soggetto Servito\"},{\"title\":\"Controparte\"},{\"title\":\"Importo\"},{\"title\":\"Errori Rilevati\"}],\"h\":\"373\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"46\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"26\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"29\",\"x\":\"587\",\"y\":\"12\",\"zindex\":\"7\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1047\",\"y\":\"-53\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"1194\",\"y\":\"-80\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"partiva_err\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"114\",\"x\":\"161\",\"y\":\"14\",\"zindex\":\"5\"},{\"align\":\"right\",\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"Label5\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"P. IVA Errata:\",\"w\":\"140\",\"x\":\"11\",\"y\":\"14\",\"zindex\":\"6\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"partiva_right\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"114\",\"x\":\"459\",\"y\":\"14\",\"zindex\":\"5\"},{\"h\":\"20\",\"name\":\"SPChgPIVA\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"1053\",\"y\":\"-25\"},{\"anchor\":\"\",\"h\":\"1\",\"layout_steps_values\":{},\"name\":\"iExec\",\"page\":\"1\",\"type\":\"Iframe\",\"w\":\"1\",\"x\":\"7\",\"y\":\"578\",\"zindex\":\"8\"},{\"anchor\":\"top-left-right\",\"h\":\"143\",\"layout_steps_values\":{},\"name\":\"pLog\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"432\",\"zindex\":\"3\"},{\"h\":\"20\",\"name\":\"opemt_scarti_import_savedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"120\",\"x\":\"1066\",\"y\":\"47\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_scarti_import_ope","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_scarti_import_ope_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_scarti_import_ope','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String Label5_Copy= "P. IVA Corretta:";
if(request.getAttribute("pg_scarti_import_ope_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String idimport= "";
String partiva_err= "";
if(request.getAttribute("pg_scarti_import_ope_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Label5= "P. IVA Errata:";
String partiva_right= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_scarti_import_ope_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_scarti_import_ope_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_scarti_import_ope_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_scarti_import_ope','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_pMsg'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+idPortlet+"_216gh",false);%></div>
<span id='<%=idPortlet%>_Label5_Copy'  formid='<%=idPortlet%>' ps-name='Label5_Copy'    class='label Label5_Copy_ctrl'><div id='<%=idPortlet%>_Label5_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("P. IVA Corretta:")%></div></span>
<div id='<%=idPortlet%>_Grid1' formid='<%=idPortlet%>' ps-name='Grid1'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_btnCHG' class='image-default btnCHG_ctrl'   target=''>&#xeae2;</a>
<span class='textbox-container'id='<%=idPortlet%>_partiva_err_wrp'><input id='<%=idPortlet%>_partiva_err' name='partiva_err' type='text' maxlength='11' class='textbox' formid='<%=idPortlet%>' ps-name='partiva_err' /></span>
<span id='<%=idPortlet%>_Label5'  formid='<%=idPortlet%>' ps-name='Label5'    class='label Label5_ctrl'><div id='<%=idPortlet%>_Label5tbl' style='width:100%;'><%=JSPLib.ToHTML("P. IVA Errata:")%></div></span>
<span class='textbox-container'id='<%=idPortlet%>_partiva_right_wrp'><input id='<%=idPortlet%>_partiva_right' name='partiva_right' type='text' maxlength='11' class='textbox' formid='<%=idPortlet%>' ps-name='partiva_right' /></span>
<div id='<%=idPortlet%>_iExec_DIV'>&nbsp;</div>
<div id='<%=idPortlet%>_pLog'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_215mc",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_scarti_import_ope');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_scarti_import_ope',["1024"],["650"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"650","title":"","layer":"false","npage":"1"}]);
this.SQLScarti=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_scarti_import",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_scarti_import","cmdHash":"<%=JSPLib.cmdHash("qbe_scarti_import",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLScarti","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLScarti","nrows":"15","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":1040,"y":-83});
if(this.pMsg=ZtVWeb.getPortletInc('<%=idPortlet%>_pMsg')){
this.pMsg.setContainer(this,'pMsg')
this.pMsg_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_pMsg","h":67,"hide":"false","layer":false,"layout_steps_values":{},"name":"pMsg","page":1,"portlet_id":"<%=idPortlet%>_216gh","spuid":"","type":"Portlet","w":1024,"x":0,"y":577,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pMsg').style.display='none';
}
this.Label5_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label5_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label5_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label5_Copy,false,true)%>","type":"Label","w":140,"x":309,"y":14,"zindex":"6"});
this.Grid1=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid1","dataobj":"SQLScarti","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":373,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid1","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"SPEditScarti -n -v","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"top","w":1024,"x":0,"y":46,"zindex":"2"});
this.Grid1.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"ID SCarto","align":"","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"IMPPROG","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Tipo Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TIPOOPER","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"ID Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"NUMPROG","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Data Operazione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DATAOPE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"CLiente","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CONNESCLI","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Esecutore","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CONNESREAL","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Soggetto Servito","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CONNESBEN","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Controparte","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CONNALTRO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Importo","align":"right","type":"N","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"999,999,999.99","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"IMPORTO","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Errori Rilevati","align":"center","type":"M","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"TXTERR","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.btnCHG=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image-default btnCHG_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCHG","edit_undercond":"","field":"","font_color":"","font_color_hover":"#F5182D","font_image":"&#xeae2;","font_image_hover":"","font_name":"icons8_win10","font_path":"","font_size":"","h":26,"help_tips":"<%=JSPLib.ToJSValue("",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"btnCHG","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xeae2;","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":29,"x":587,"y":12,"zindex":"7"});
 ZtVWeb.RequireFont("icons8_win10","");
this.SPEditScarti=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("opemt_scarti_import",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPEditScarti","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPEditScarti","offline":false,"page":1,"parms":"IMPPROG=idimport","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opemt_scarti_import","target":"","type":"SPLinker","w":120,"x":1047,"y":-53});
this.SPEditScarti.m_cID='<%=JSPLib.cmdHash("entity,opemt_scarti_import",request.getSession())%>';
this.idimport=new ZtVWeb._VC(this,'idimport',null,'character','<%=JSPLib.ToJSValue(idimport,false,true)%>',false,false);
this.partiva_err=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_partiva_err","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"11","name":"partiva_err","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(partiva_err,false,true)%>","w":114,"x":161,"y":14,"zerofilling":false,"zindex":"5","zoom":""});
this.Label5=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Label5","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"","font_color":"","font_size":"","font_weight":"","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Label5","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(Label5,false,true)%>","type":"Label","w":140,"x":11,"y":14,"zindex":"6"});
this.partiva_right=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_partiva_right","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"11","name":"partiva_right","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(partiva_right,false,true)%>","w":114,"x":459,"y":14,"zerofilling":false,"zindex":"5","zoom":""});
this.SPChgPIVA=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("opert_chgpiva",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPChgPIVA","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPChgPIVA","offline":false,"page":1,"parms":"pIVA1=partiva_err,pIVA2=partiva_right","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"opert_chgpiva","target":"","type":"SPLinker","w":120,"x":1053,"y":-25});
this.SPChgPIVA.m_cID='<%=JSPLib.cmdHash("routine,opert_chgpiva",request.getSession())%>';
this.iExec=new ZtVWeb.IframeCtrl(this,{"anchor":"top-left","auto_resize":"false","border":"","ctrlid":"<%=idPortlet%>_iExec","default_portlet":"","h":1,"hide":"false","layer":false,"layout_steps_values":{},"name":"iExec","name_iframe":"iExec","page":1,"spuid":"","type":"Iframe","w":1,"x":7,"y":578,"zindex":"8"});
if(this.pLog=ZtVWeb.getPortletInc('<%=idPortlet%>_pLog')){
this.pLog.setContainer(this,'pLog')
this.pLog_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left-right","ctrlid":"<%=idPortlet%>_pLog","h":143,"hide":"false","layer":false,"layout_steps_values":{},"name":"pLog","page":1,"portlet_id":"<%=idPortlet%>_215mc","spuid":"","type":"Portlet","w":1024,"x":0,"y":432,"zindex":"3"});
} else {
document.getElementById('<%=idPortlet%>_pLog').style.display='none';
}
this.opemt_scarti_import_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_opemt_scarti_import_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"opemt_scarti_import_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":120,"x":1066,"y":47});
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
<%if(request.getAttribute("pg_scarti_import_ope_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_scarti_import_ope_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_scarti_import_ope_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.btnCHG.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_opemt_scarti_import_savedEntity=function(parmsObj){<%=idPortlet%>.opemt_scarti_import_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SQLScarti.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_scarti_import_ope',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_scarti_import_ope');
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
sp.endPage("pg_scarti_import_ope");
}%>
<%! public String getJSPUID() { return "2239065843"; } %>