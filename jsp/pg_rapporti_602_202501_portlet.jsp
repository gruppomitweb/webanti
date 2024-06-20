<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function button12_Click(){\n var _msg=this.splinker10.Link();\n this.Query1.Query(); \n}\n\nfunction Conferma_Click(){\n  this.selectedValues.Value(this.Grid0.GetSelectedDataAsTrsString());\n  if (confirm('Confermi associazione rapporti ?')) {\n    var _esito=this.RTConferma.Link();\n    this.Query1.Query();  \n  }  \n}\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":" ","css":" ","css_class":"undefined","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"700","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":"Abbina Rapporti 6.02 con Rapporti 2.02\u002f5.01","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"951"},{"align":"left","anchor":" ","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"true","checkbox_fields":"NUMRIGA,FLGSEL","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"175\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#CCCCFF\",\"newline\":false,\"field\":\"AGERAPPORTO\",\"isEditable\":true,\"fg_color\":\"\",\"width\":\"175\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"70\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Inizio\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#CCCCFF\",\"newline\":false,\"field\":\"AGEDATAOPE\",\"fg_color\":\"\",\"width\":\"70\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"70\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Fine\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#CCCCFF\",\"newline\":false,\"field\":\"AGEDATACHIU\",\"fg_color\":\"\",\"width\":\"70\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"112\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Intestatario\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#CCCCFF\",\"newline\":false,\"field\":\"AGECONNESCLI\",\"fg_color\":\"\",\"width\":\"112\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"175\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#66CCCC\",\"newline\":false,\"field\":\"AUIRAPPORTO\",\"fg_color\":\"\",\"width\":\"175\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"70\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Inizio\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#66CCCC\",\"newline\":false,\"field\":\"AUIDATAOPE\",\"fg_color\":\"\",\"width\":\"70\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"70\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Fine\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#66CCCC\",\"newline\":false,\"field\":\"AUIDATACHIU\",\"fg_color\":\"\",\"width\":\"70\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"112\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Intestatario\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"#66CCCC\",\"newline\":false,\"field\":\"AUICONNESCLI\",\"fg_color\":\"\",\"width\":\"112\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"Query1","disabled_fld":" ","draggablecolumns":"false","editable_fields":"AGERAPPORTO","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C,D,D,C,C,D,D,C","filters":"false","font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":"422","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"false","line_color":"#FFFFFF","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":" ","recMark":"false","render_totals":" ","resizablecolumns":"false","row_color":"#CCCCCC","row_color_odd":"#999999","rows":"17","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":" ","show_btn_update":"false","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":" ","w":"951","x":"0","y":"246"},{"auto_exec":"true","count":"true","localDBName":" ","n_records":"1000","name":"Query1","offline":"false","page":"1","parms":" ","parms_source":" ","query":"qbe_rapporti_202501","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","x":"3","y":"93"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#C67B7B","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2","page":"1","picture":" ","sequence":"5","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Rapporti 2.02 \u002f 5.01","w":"469","x":"482","y":"226","zindex":"1"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#829BC6","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2_Copy","page":"1","picture":" ","sequence":"5","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Rapporti 6.02","w":"464","x":"18","y":"226","zindex":"1"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#1306C6","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","h":"25","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2_Copy_Copy","page":"1","picture":" ","sequence":"5","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Abbina Rapporti 6.02 con Rapporti 2.02\u002f5.01","w":"953","x":"-1","y":"-1","zindex":"1"},{"anchor":" ","calculate":" ","class_Css":"combobox","create_undercond":" ","dataobj":" ","disabled":"false","edit_undercond":" ","empty_value":"true","font":"verdana","font_size":"7pt","h":"20","hide_undercond":" ","init":" ","init_par":" ","name":"accuratezza","page":"1","picture":" ","sequence":"9","tabindex":" ","textlist":"Uguali: Intestatario + Data inizio + Data fine + Tipo Rapporto,Uguali: Intestatario + Data inizio + Data fine,Uguali: Intestatario + Data inizio","type":"Combobox","typevar":"character","valuelist":"'A','B','C'","visible":"true","w":"329","x":"86","y":"45"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label7","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Accuratezza:","w":"73","x":"3","y":"48","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label7_Copy","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Password:","w":"73","x":"454","y":"49","zindex":"1"},{"anchor":" ","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":" ","edit_undercond":"Upper(LRTrim(passwd)) = 'ABBINAMIT'","font":"Verdana","font_color":"#000000","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","name":"button12","page":"1","sequence":"11","tabindex":" ","type":"Button","type_submit":"false","value":"Recupera","w":"65","x":"669","y":"45"},{"anchor":" ","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":" ","edit_undercond":"Upper(LRTrim(passwd)) = 'ABBINAMIT'","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","name":"Conferma","page":"1","sequence":"11","tabindex":" ","type":"Button","type_submit":"false","value":"Conferma","w":"75","x":"870","y":"45"},{"anchor":" ","calculate":" ","class_Css":"TxtObl","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"passwd","page":"1","password":"true","picture":" ","readonly":"false","scroll":"false","sequence":"12","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"130","x":"529","y":"45","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"splinker10","offline":"false","page":"1","parms":"pOper=accuratezza","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":"false","sequence":"13","servlet":"arrt_abbina_602_202501","target":" ","type":"SPLinker","w":"30","x":"908","y":"186"},{"anchor":" ","h":"128","name":"Portlet13","page":"1","sequence":"14","src":"showlog_portlet.jsp","type":"Portlet","w":"810","x":"70","y":"88"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"RTConferma","offline":"false","page":"1","parms":"mcValues=selectedValues","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"15","servlet":"arrt_abbina_602_202501_save","target":" ","type":"SPLinker","w":"30","x":"906","y":"137"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":" ","name":"selectedValues","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"3","y":"678"}]%>
<%/*Description: */%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
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
window.pg_rapporti_602_202501_Static=function(){
if(typeof button12_Click !='undefined')this.button12_Click=button12_Click;
if(typeof Conferma_Click !='undefined')this.Conferma_Click=Conferma_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.this_EditUnderCondition=function(){
ZtVWeb.EditCtrl(Eq(Upper(LRTrim(this.passwd.Value())),'ABBINAMIT'),this.button12);
ZtVWeb.EditCtrl(Eq(Upper(LRTrim(this.passwd.Value())),'ABBINAMIT'),this.Conferma);
}
this.Query1.addRowConsumer(this.Grid0);
function button12_Click(){
 var _msg=this.splinker10.Link();
 this.Query1.Query(); 
}
function Conferma_Click(){
  this.selectedValues.Value(this.Grid0.GetSelectedDataAsTrsString());
  if (confirm('Confermi associazione rapporti ?')) {
    var _esito=this.RTConferma.Link();
    this.Query1.Query();  
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
.pg_rapporti_602_202501_container {
}
.pg_rapporti_602_202501_portlet{
  position:relative;
  width:951px;
  min-width:951px;
  height:700px;
}
.pg_rapporti_602_202501_portlet[Data-page="1"]{
  height:700px;
  width:951px;
}
.pg_rapporti_602_202501_portlet > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:246px;
  left:0px;
  width:951px;
  height:auto;
  min-height:422px;
}
.pg_rapporti_602_202501_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:226px;
  left:482px;
  width:469px;
  height:auto;
  min-height:20px;
}
.pg_rapporti_602_202501_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_rapporti_602_202501_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#C67B7B;
}
.pg_rapporti_602_202501_portlet > .label2_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:226px;
  left:18px;
  width:464px;
  height:auto;
  min-height:20px;
}
.pg_rapporti_602_202501_portlet > .label2_Copy_ctrl {
  height:auto;
  min-height:20px;
}
.pg_rapporti_602_202501_portlet > .label2_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
}
.pg_rapporti_602_202501_portlet > .label2_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-1px;
  left:-1px;
  width:953px;
  height:auto;
  min-height:25px;
}
.pg_rapporti_602_202501_portlet > .label2_Copy_Copy_ctrl {
  height:auto;
  min-height:25px;
}
.pg_rapporti_602_202501_portlet > .label2_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:13pt;
  font-weight:bold;
  color:#FCFCFC;
  text-align:center;
  background-color:#1306C6;
}
.pg_rapporti_602_202501_portlet > .accuratezza_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:86px;
  width:329px;
  height:20px;
}
.pg_rapporti_602_202501_portlet > .label7_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:48px;
  left:3px;
  width:73px;
  height:auto;
  min-height:19px;
}
.pg_rapporti_602_202501_portlet > .label7_ctrl {
  height:auto;
  min-height:19px;
}
.pg_rapporti_602_202501_portlet > .label7_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_rapporti_602_202501_portlet > .label7_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:49px;
  left:454px;
  width:73px;
  height:auto;
  min-height:19px;
}
.pg_rapporti_602_202501_portlet > .label7_Copy_ctrl {
  height:auto;
  min-height:19px;
}
.pg_rapporti_602_202501_portlet > .label7_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_rapporti_602_202501_portlet > .button12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:669px;
  width:65px;
  height:20px;
}
.pg_rapporti_602_202501_portlet > .button12_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#000000;
  background-color:buttonface;
  border-width:1px;
  border-color:#000000;
}
.pg_rapporti_602_202501_portlet > .Conferma_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:870px;
  width:75px;
  height:20px;
}
.pg_rapporti_602_202501_portlet > .Conferma_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#FFFFFF;
  background-color:#10CE1D;
  border-width:1px;
  border-color:#000000;
}
.pg_rapporti_602_202501_portlet > .passwd_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:529px;
  width:130px;
  height:20px;
}
.pg_rapporti_602_202501_portlet > .passwd_ctrl {
}
.pg_rapporti_602_202501_portlet > .passwd_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_rapporti_602_202501_portlet > .Portlet13_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:88px;
  left:70px;
  width:810px;
  height:auto;
  min-height:128px;
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
 String def="[{\"h\":\"700\",\"pages_names\":\"Abbina Rapporti 6.02 con Rapporti 2.02\\u002f5.01\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"951\"},{\"anchor\":\"\",\"h\":\"422\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"951\",\"x\":\"0\",\"y\":\"246\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"3\",\"y\":\"93\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"469\",\"x\":\"482\",\"y\":\"226\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"464\",\"x\":\"18\",\"y\":\"226\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"25\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"953\",\"x\":\"-1\",\"y\":\"-1\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"329\",\"x\":\"86\",\"y\":\"45\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"73\",\"x\":\"3\",\"y\":\"48\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"73\",\"x\":\"454\",\"y\":\"49\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"65\",\"x\":\"669\",\"y\":\"45\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"75\",\"x\":\"870\",\"y\":\"45\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"130\",\"x\":\"529\",\"y\":\"45\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"908\",\"y\":\"186\"},{\"anchor\":\"\",\"h\":\"128\",\"page\":\"1\",\"type\":\"Portlet\",\"w\":\"810\",\"x\":\"70\",\"y\":\"88\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"906\",\"y\":\"137\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"3\",\"y\":\"678\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_rapporti_602_202501","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_rapporti_602_202501_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_rapporti_602_202501','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_rapporti_602_202501_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String label2= "Rapporti 2.02 / 5.01";
String label2_Copy= "Rapporti 6.02";
String label2_Copy_Copy= "Abbina Rapporti 6.02 con Rapporti 2.02/5.01";
String accuratezza= "";
String label7= "Accuratezza:";
String label7_Copy= "Password:";
String passwd= "";
if(request.getAttribute("pg_rapporti_602_202501_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String selectedValues= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_rapporti_602_202501_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_rapporti_602_202501_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_rapporti_602_202501','<%=idPortlet%>',false,' ');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("Rapporti 2.02 / 5.01")%></div></span>
<span id='<%=idPortlet%>_label2_Copy'  formid='<%=idPortlet%>' ps-name='label2_Copy'    class='label label2_Copy_ctrl'><div id='<%=idPortlet%>_label2_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Rapporti 6.02")%></div></span>
<span id='<%=idPortlet%>_label2_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label2_Copy_Copy'    class='label label2_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label2_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Abbina Rapporti 6.02 con Rapporti 2.02/5.01")%></div></span>
<select id='<%=idPortlet%>_accuratezza' name='accuratezza' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
<span id='<%=idPortlet%>_label7'  formid='<%=idPortlet%>' ps-name='label7'    class='label label7_ctrl'><div id='<%=idPortlet%>_label7tbl' style='width:100%;'><%=JSPLib.ToHTML("Accuratezza:")%></div></span>
<span id='<%=idPortlet%>_label7_Copy'  formid='<%=idPortlet%>' ps-name='label7_Copy'    class='label label7_Copy_ctrl'><div id='<%=idPortlet%>_label7_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Password:")%></div></span>
<input id='<%=idPortlet%>_button12' type='button' class='button button12_ctrl'/>
<input id='<%=idPortlet%>_Conferma' type='button' class='button Conferma_ctrl'/>
<span class='textbox-container'id='<%=idPortlet%>_passwd_wrp'><input id='<%=idPortlet%>_passwd' name='passwd' type='password' class='TxtObl' formid='<%=idPortlet%>' autocomplete='off' ps-name='passwd' /></span>
<div id='<%=idPortlet%>_Portlet13'><% request.setAttribute("SPParentObjId",idPortlet);
 out.flush(); 
Library.includeResource(request,response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+idPortlet+"_1fs45mk",false);%></div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_rapporti_602_202501');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CHANGE_MARK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CHANGE_MARK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_INSERT_2ND_OP",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_INSERT_2ND_OP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_TITLE"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_rapporti_602_202501',["951"],["700"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"951","h":"700","title":"Abbina Rapporti 6.02 con Rapporti 2.02\u002f5.01","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"true","checkbox_fields":"NUMRIGA,FLGSEL","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":422,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{},"line_color":"#FFFFFF","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"black","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":" ","row_color":"#CCCCCC","row_color_odd":"#999999","scroll_bars":"false","show_btn_delete":" ","show_btn_update":"false","show_filters":"false","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":" ","w":951,"x":0,"y":246});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":17,"colProperties":[{"disable_fields_conditions":"","maxwidth":"175","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#CCCCFF","newline":false,"field":"AGERAPPORTO","isEditable":true,"fg_color":"","width":"175","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"70","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Inizio","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#CCCCFF","newline":false,"field":"AGEDATAOPE","fg_color":"","width":"70","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"70","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Fine","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#CCCCFF","newline":false,"field":"AGEDATACHIU","fg_color":"","width":"70","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"112","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Intestatario","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#CCCCFF","newline":false,"field":"AGECONNESCLI","fg_color":"","width":"112","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"175","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#66CCCC","newline":false,"field":"AUIRAPPORTO","fg_color":"","width":"175","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"70","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Inizio","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#66CCCC","newline":false,"field":"AUIDATAOPE","fg_color":"","width":"70","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"70","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Fine","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#66CCCC","newline":false,"field":"AUIDATACHIU","fg_color":"","width":"70","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"112","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Intestatario","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"#66CCCC","newline":false,"field":"AUICONNESCLI","fg_color":"","width":"112","RowSpan":0,"extensible":false}]});
PrepareJsCalendar(false);
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_rapporti_202501","cmdHash":"<%=JSPLib.cmdHash("qbe_rapporti_202501",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"1000","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":3,"y":93});
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":469,"x":482,"y":226,"zindex":"1"});
this.label2_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2_Copy","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2_Copy,false,true)%>","type":"Label","w":464,"x":18,"y":226,"zindex":"1"});
this.label2_Copy_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2_Copy_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2_Copy_Copy","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2_Copy_Copy,false,true)%>","type":"Label","w":953,"x":-1,"y":-1,"zindex":"1"});
this.accuratezza=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":" ","class_Css":"combobox","create_undercond":" ","ctrlid":"<%=idPortlet%>_accuratezza","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":true,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=accuratezza%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"accuratezza","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":"Uguali: Intestatario + Data inizio + Data fine + Tipo Rapporto,Uguali: Intestatario + Data inizio + Data fine,Uguali: Intestatario + Data inizio","type":"Combobox","typevar":"character","valuelist":"'A','B','C'","visible":true,"w":329,"x":86,"y":45});
this.label7=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label7","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label7","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label7,false,true)%>","type":"Label","w":73,"x":3,"y":48,"zindex":"1"});
this.label7_Copy=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label7_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label7_Copy","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label7_Copy,false,true)%>","type":"Label","w":73,"x":454,"y":49,"zindex":"1"});
this.button12=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button button12_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_button12","edit_undercond":"Eq(Upper(LRTrim(this.passwd.Value())),'ABBINAMIT')","font":"Verdana","font_color":"#000000","font_size":"7pt","h":20,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"button12","page":1,"tabindex":" ","text":"Recupera","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":669,"y":45});
this.Conferma=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button Conferma_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_Conferma","edit_undercond":"Eq(Upper(LRTrim(this.passwd.Value())),'ABBINAMIT')","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":20,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"Conferma","page":1,"tabindex":" ","text":"Conferma","type":"Button","type_submit":"false","type_wizard":"","w":75,"x":870,"y":45});
this.passwd=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_passwd","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"passwd","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(passwd,false,true)%>","w":130,"x":529,"y":45,"zerofilling":false,"zindex":"1","zoom":""});
this.splinker10=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker10","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"splinker10","offline":false,"page":1,"parms":"pOper=accuratezza","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":"false","servlet":"arrt_abbina_602_202501","target":" ","type":"SPLinker","w":30,"x":908,"y":186});
this.splinker10.m_cID='<%=JSPLib.cmdHash("routine,arrt_abbina_602_202501",request.getSession())%>';
if(this.Portlet13=ZtVWeb.getPortletInc('<%=idPortlet%>_Portlet13')){
this.Portlet13.setContainer(this,'Portlet13')
this.Portlet13_ctrl=new ZtVWeb.PortletCtrl(this,{"anchor":"top-left","ctrlid":"<%=idPortlet%>_Portlet13","h":128,"hide":"false","layer":false,"layout_steps_values":{},"name":"Portlet13","page":1,"portlet_id":"<%=idPortlet%>_1fs45mk","type":"Portlet","w":810,"x":70,"y":88});
} else {
document.getElementById('<%=idPortlet%>_Portlet13').style.display='none';
}
this.RTConferma=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTConferma","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RTConferma","offline":false,"page":1,"parms":"mcValues=selectedValues","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arrt_abbina_602_202501_save","target":" ","type":"SPLinker","w":30,"x":906,"y":137});
this.RTConferma.m_cID='<%=JSPLib.cmdHash("routine,arrt_abbina_602_202501_save",request.getSession())%>';
this.selectedValues=new ZtVWeb._VC(this,'selectedValues',null,'character','<%=JSPLib.ToJSValue(selectedValues,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_rapporti_602_202501_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_rapporti_602_202501_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_rapporti_602_202501_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Query1.firstQuery('true');
window.<%=idPortlet%>.accuratezza.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_rapporti_602_202501',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_rapporti_602_202501');
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
sp.endPage("pg_rapporti_602_202501");
}%>
<%! public String getJSPUID() { return "3388917431"; } %>