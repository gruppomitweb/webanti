<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function recupera_Click(){\n  this.query_cointestari.Query();\n}\n\nfunction COINT_onChange(){\n  if (this.COINT.Value()=='2') {\n    this.Variable10.Value('');\n  } else {\n    this.Variable10.Value('1');\n  }\n}\n\nfunction conferma_Click(){\n  this.selectedValues.Value(this.griglia.GetSelectedDataAsTrsString());\n  var _ritorno= this.RCCheck.Link()\n  if (_ritorno=='') {\n    this.RCUpdate.Link();        \n  } else {\n    alert(_ritorno);\n    if (confirm('Intendi comunque proseguire ?')){\n      _ritorno=this.RCUpdate.Link();                \n      alert(_ritorno);\n    }    \n  }\n  this.query_cointestari.Query();\n}\n\nfunction cTipo(pTipo) {\n  var _cRet\n  alert(pTipo)\n  if(pTipo=='D') {\n    _cRet='Delega'\n  }  \n  if(pTipo=='R') {\n    _cRet='Rapporto'\n  }  \n return _cRet        \n}","bg_image":" ","cache_in_post":"false","cache_time":" ","color":" ","css":" ","css_class":" ","description":"Abbinamento Rapporti \u002fCointestatari \u002f Delegati","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"771","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":"Abbina Cointestatari","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"1100","version":"37","w":"100%"},{"anchor":" ","calculate":" ","class_Css":"textbox","create_undercond":" ","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"password","page":"1","password":"true","picture":" ","readonly":"false","scroll":"false","sequence":"1","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"130","x":"68","y":"50","zerofilling":"false","zindex":"1"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"Password","page":"1","picture":" ","sequence":"2","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Password:","w":"62","x":"6","y":"54","zindex":"1"},{"anchor":" ","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":" ","edit_undercond":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","name":"recupera","page":"1","sequence":"3","tabindex":" ","type":"Button","type_submit":"false","value":"Recupera","w":"65","x":"397","y":"50"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#1306C6","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","h":"25","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2_Copy_Copy","page":"1","picture":" ","sequence":"5","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Abbina Rapporti \u002f Cointestatari \u002f Delegati","w":"975","x":"-1","y":"1","zindex":"1"},{"auto_exec":"false","count":"true","localDBName":" ","n_records":"100000000","name":"query_cointestari","offline":"false","page":"1","parms":"w_COINT=Variable10","parms_source":" ","query":"qbe_ae_abbina_cointestati_1","query_async":"false","return_fields_type":"true","sequence":"6","type":"SQLDataobj","x":"44","y":"-34"},{"anchor":" ","calculate":" ","checked_value":"1","create_undercond":" ","edit_undercond":" ","h":"13","help_tips":" ","hide_undercond":" ","init":"true","init_par":"1","name":"COINT","page":"1","sequence":"9","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"2","w":"13","x":"362","y":"53"},{"align":"left","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"Solo_rapporti_cointestati_l","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Solo rapporti cointestati:","w":"130","x":"234","y":"52","zindex":"1"},{"align":"left","anchor":" ","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"IDBASE,RAPPORTO,TIPO","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"RAPPORTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nuovo Codice\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NEWRAPPORTO\",\"isEditable\":true,\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Apertura\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"ADATA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Chiusura Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CDATA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Ragione Sociale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"RAGSOC\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"SCELTO\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"checkbox:SCELTO\",\"isEditable\":true,\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"query_cointestari","disabled_fld":" ","draggablecolumns":"false","editable_fields":"SCELTO,NEWRAPPORTO","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C,C,D,D,C,C,","filters":"true-by-example","font":" ","font_color":" ","font_size":" ","font_weight":" ","group_repeated":"false","h":"469","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"true","line_color":" ","link_underlined":" ","name":"griglia","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":" ","recMark":" ","render_totals":" ","resizablecolumns":"false","row_color":" ","row_color_odd":" ","rows":"15","scroll_bars":"false","sequence":"11","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":"top","w":"974","x":"-1","y":"94"},{"anchor":" ","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":" ","edit_undercond":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","h":"20","help_tips":" ","hide_undercond":" ","name":"conferma","page":"1","sequence":"14","tabindex":" ","type":"Button","type_submit":"false","value":"Conferma","w":"65","x":"908","y":"50"},{"calculate":"'1'","dataobj":" ","field":" ","h":"20","init":"true","init_par":" ","name":"Variable10","page":"1","sequence":"15","server_side":"false","type":"Variable","typevar":"character","w":"126","x":"6","y":"28"},{"calculate":" ","dataobj":" ","field":" ","h":"20","init":" ","init_par":" ","name":"selectedValues","page":"1","sequence":"16","server_side":"false","type":"Variable","typevar":"character","w":"130","x":"142","y":"28"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"RCCheck","offline":"false","page":"1","parms":"mcValues=selectedValues,pTipo=C,pAgg=Aggiornamenti","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"18","servlet":"arrt_allinea_cointestatari","target":" ","type":"SPLinker","w":"30","x":"497","y":"36"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":" ","name":"RCUpdate","offline":"false","page":"1","parms":"mcValues=selectedValues,pTipo=U,pAgg=Aggiornamenti","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"18","servlet":"arrt_allinea_cointestatari","target":" ","type":"SPLinker","w":"30","x":"541","y":"36"},{"anchor":" ","calculate":" ","class_Css":"combobox","create_undercond":" ","dataobj":" ","disabled":"false","edit_undercond":" ","empty_value":"true","font":"verdana","font_size":"7pt","h":"20","hide_undercond":" ","init":" ","init_par":" ","name":"Aggiornamenti","page":"1","picture":" ","sequence":"19","tabindex":" ","textlist":"AGE + AUI,Solo 2.2,Solo 5.1,Solo 6.2","type":"Combobox","typevar":"character","valuelist":"X,1,2,3","visible":"true","w":"201","x":"676","y":"50"}]%>
<%/*Description:Abbinamento Rapporti /Cointestatari / Delegati*/%>
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
window.pg_abbina_cointestatari_Static=function(){
if(typeof recupera_Click !='undefined')this.recupera_Click=recupera_Click;
if(typeof COINT_onChange !='undefined')this.COINT_onChange=COINT_onChange;
if(typeof conferma_Click !='undefined')this.conferma_Click=conferma_Click;
if(typeof cTipo !='undefined')this.cTipo=cTipo;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('1',this.Variable10);
this.query_cointestari.addRowConsumer(this.griglia);
function recupera_Click(){
  this.query_cointestari.Query();
}
function COINT_onChange(){
  if (this.COINT.Value()=='2') {
    this.Variable10.Value('');
  } else {
    this.Variable10.Value('1');
  }
}
function conferma_Click(){
  this.selectedValues.Value(this.griglia.GetSelectedDataAsTrsString());
  var _ritorno= this.RCCheck.Link()
  if (_ritorno=='') {
    this.RCUpdate.Link();        
  } else {
    alert(_ritorno);
    if (confirm('Intendi comunque proseguire ?')){
      _ritorno=this.RCUpdate.Link();                
      alert(_ritorno);
    }    
  }
  this.query_cointestari.Query();
}
function cTipo(pTipo) {
  var _cRet
  alert(pTipo)
  if(pTipo=='D') {
    _cRet='Delega'
  }  
  if(pTipo=='R') {
    _cRet='Rapporto'
  }  
 return _cRet        
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
.pg_abbina_cointestatari_container {
}
.pg_abbina_cointestatari_portlet{
  position:relative;
  width:100%;
  min-width:1100px;
  height:771px;
}
.pg_abbina_cointestatari_portlet[Data-page="1"]{
  height:771px;
  width:100%;
}
.pg_abbina_cointestatari_portlet > .password_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:50px;
  left:68px;
  width:130px;
  height:20px;
}
.pg_abbina_cointestatari_portlet > .password_ctrl {
}
.pg_abbina_cointestatari_portlet > .password_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_abbina_cointestatari_portlet > .Password_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:54px;
  left:6px;
  width:62px;
  height:auto;
  min-height:19px;
}
.pg_abbina_cointestatari_portlet > .Password_ctrl {
  height:auto;
  min-height:19px;
}
.pg_abbina_cointestatari_portlet > .Password_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_abbina_cointestatari_portlet > .recupera_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:50px;
  left:397px;
  width:65px;
  height:20px;
}
.pg_abbina_cointestatari_portlet > .recupera_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#000000;
  background-color:buttonface;
  border-width:1px;
  border-color:#000000;
}
.pg_abbina_cointestatari_portlet > .label2_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:1px;
  left:-1px;
  width:975px;
  height:auto;
  min-height:25px;
}
.pg_abbina_cointestatari_portlet > .label2_Copy_Copy_ctrl {
  height:auto;
  min-height:25px;
}
.pg_abbina_cointestatari_portlet > .label2_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:13pt;
  font-weight:bold;
  color:#FCFCFC;
  text-align:center;
  background-color:#1306C6;
}
.pg_abbina_cointestatari_portlet > .COINT_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:53px;
  left:362px;
  width:13px;
  height:13px;
}
.pg_abbina_cointestatari_portlet > .Solo_rapporti_cointestati_l_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:52px;
  left:234px;
  width:130px;
  height:auto;
  min-height:19px;
}
.pg_abbina_cointestatari_portlet > .Solo_rapporti_cointestati_l_ctrl {
  height:auto;
  min-height:19px;
}
.pg_abbina_cointestatari_portlet > .Solo_rapporti_cointestati_l_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_abbina_cointestatari_portlet > .griglia_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:94px;
  left:-1px;
  width:974px;
  height:auto;
  min-height:469px;
}
.pg_abbina_cointestatari_portlet > .conferma_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:50px;
  left:908px;
  width:65px;
  height:20px;
}
.pg_abbina_cointestatari_portlet > .conferma_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#000000;
  background-color:#10CE1D;
  border-width:1px;
  border-color:#000000;
}
.pg_abbina_cointestatari_portlet > .Aggiornamenti_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:50px;
  left:676px;
  width:201px;
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
 String def="[{\"h\":\"771\",\"pages_names\":\"Abbina Cointestatari\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"1100\",\"w\":\"100%\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"130\",\"x\":\"68\",\"y\":\"50\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"62\",\"x\":\"6\",\"y\":\"54\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"65\",\"x\":\"397\",\"y\":\"50\"},{\"anchor\":\"\",\"h\":\"25\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"975\",\"x\":\"-1\",\"y\":\"1\",\"zindex\":\"1\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"44\",\"y\":\"-34\"},{\"anchor\":\"\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"362\",\"y\":\"53\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"130\",\"x\":\"234\",\"y\":\"52\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"469\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"974\",\"x\":\"-1\",\"y\":\"94\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"65\",\"x\":\"908\",\"y\":\"50\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"126\",\"x\":\"6\",\"y\":\"28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"130\",\"x\":\"142\",\"y\":\"28\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"497\",\"y\":\"36\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"541\",\"y\":\"36\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Combobox\",\"w\":\"201\",\"x\":\"676\",\"y\":\"50\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_abbina_cointestatari","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_abbina_cointestatari_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_abbina_cointestatari','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String password= "";
if(request.getAttribute("pg_abbina_cointestatari_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String Password= "Password:";
String label2_Copy_Copy= "Abbina Rapporti / Cointestatari / Delegati";
String COINT="1";
String Solo_rapporti_cointestati_l= "Solo rapporti cointestati:";
if(request.getAttribute("pg_abbina_cointestatari_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String Variable10= "";
String selectedValues= "";
String Aggiornamenti= "";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_abbina_cointestatari_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_abbina_cointestatari_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_abbina_cointestatari','<%=idPortlet%>',false,' ');
</script><%}}%>
<span class='textbox-container'id='<%=idPortlet%>_password_wrp'><input id='<%=idPortlet%>_password' name='password' type='password' class='textbox' formid='<%=idPortlet%>' autocomplete='off' ps-name='password' /></span>
<span id='<%=idPortlet%>_Password'  formid='<%=idPortlet%>' ps-name='Password'    class='label Password_ctrl'><div id='<%=idPortlet%>_Passwordtbl' style='width:100%;'><%=JSPLib.ToHTML("Password:")%></div></span>
<input id='<%=idPortlet%>_recupera' type='button' class='button recupera_ctrl'/>
<span id='<%=idPortlet%>_label2_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label2_Copy_Copy'    class='label label2_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label2_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("Abbina Rapporti / Cointestatari / Delegati")%></div></span>
<input id='<%=idPortlet%>_COINT' name='COINT' class='checkbox' type='checkbox' style=''/>
<span id='<%=idPortlet%>_Solo_rapporti_cointestati_l'  formid='<%=idPortlet%>' ps-name='Solo_rapporti_cointestati_l'    class='label Solo_rapporti_cointestati_l_ctrl'><div id='<%=idPortlet%>_Solo_rapporti_cointestati_ltbl' style='width:100%;'><%=JSPLib.ToHTML("Solo rapporti cointestati:")%></div></span>
<div id='<%=idPortlet%>_griglia' formid='<%=idPortlet%>' ps-name='griglia'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<input id='<%=idPortlet%>_conferma' type='button' class='button conferma_ctrl'/>
<select id='<%=idPortlet%>_Aggiornamenti' name='Aggiornamenti' class='combobox' style='font-family:verdana;font-size:7pt;'></select>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_abbina_cointestatari');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_abbina_cointestatari',["1100"],["771"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1100","h":"771","title":"Abbina Cointestatari","layer":"false","npage":"1"}]);
this.password=new ZtVWeb._TC(this,{"anchor":"top-left","autocomplete":"off","calculate":" ","create_undercond":" ","ctrlid":"<%=idPortlet%>_password","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"password","page":1,"picker":"","picture":" ","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(password,false,true)%>","w":130,"x":68,"y":50,"zerofilling":false,"zindex":"1","zoom":""});
this.Password=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_Password","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"Password","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(Password,false,true)%>","type":"Label","w":62,"x":6,"y":54,"zindex":"1"});
this.recupera=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"buttonface","border_color":"#000000","border_weight":"1","class_Css":"button recupera_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_recupera","edit_undercond":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","h":20,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"recupera","page":1,"tabindex":" ","text":"Recupera","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":397,"y":50});
this.label2_Copy_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2_Copy_Copy","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2_Copy_Copy","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2_Copy_Copy,false,true)%>","type":"Label","w":975,"x":-1,"y":1,"zindex":"1"});
this.query_cointestari=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"qbe_ae_abbina_cointestati_1","cmdHash":"<%=JSPLib.cmdHash("qbe_ae_abbina_cointestati_1",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_query_cointestari","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"query_cointestari","nrows":"100000000","page":1,"parms":"w_COINT=Variable10","parms_source":" ","type":"SQLDataobj","w":0,"x":44,"y":-34});
this.COINT=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":" ","checked_value":"1","create_undercond":" ","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_COINT","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"hide":"false","hide_undercond":" ","init":"true","init_par":"1","label_text":"","layer":false,"layout_steps_values":{},"name":"COINT","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"2","w":13,"x":362,"y":53});
this.COINT.Value('<%=COINT%>');
this.Solo_rapporti_cointestati_l=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_Solo_rapporti_cointestati_l","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"Solo_rapporti_cointestati_l","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(Solo_rapporti_cointestati_l,false,true)%>","type":"Label","w":130,"x":234,"y":52,"zindex":"1"});
this.griglia=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"IDBASE,RAPPORTO,TIPO","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_griglia","dataobj":"query_cointestari","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":469,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":" ","name":"griglia","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":" ","render_totals":" ","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"true-by-example","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":"top","w":974,"x":-1,"y":94});
this.griglia.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"RAPPORTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nuovo Codice","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"NEWRAPPORTO","isEditable":true,"fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Apertura","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"ADATA","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Chiusura Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CDATA","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Ragione Sociale","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"RAGSOC","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"SCELTO","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"checkbox:SCELTO","isEditable":true,"fg_color":"","width":"","RowSpan":0,"extensible":false}]});
PrepareJsCalendar(false);
this.conferma=new ZtVWeb._BC(this,{"anchor":"top-left","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button conferma_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_conferma","edit_undercond":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","h":20,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"conferma","page":1,"tabindex":" ","text":"Conferma","type":"Button","type_submit":"false","type_wizard":"","w":65,"x":908,"y":50});
this.Variable10=new ZtVWeb._VC(this,'Variable10',null,'character','<%=JSPLib.ToJSValue(Variable10,false,true)%>',false,false);
this.selectedValues=new ZtVWeb._VC(this,'selectedValues',null,'character','<%=JSPLib.ToJSValue(selectedValues,false,true)%>',false,false);
this.RCCheck=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RCCheck","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RCCheck","offline":false,"page":1,"parms":"mcValues=selectedValues,pTipo=C,pAgg=Aggiornamenti","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arrt_allinea_cointestatari","target":" ","type":"SPLinker","w":30,"x":497,"y":36});
this.RCCheck.m_cID='<%=JSPLib.cmdHash("routine,arrt_allinea_cointestatari",request.getSession())%>';
this.RCUpdate=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RCUpdate","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RCUpdate","offline":false,"page":1,"parms":"mcValues=selectedValues,pTipo=U,pAgg=Aggiornamenti","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"arrt_allinea_cointestatari","target":" ","type":"SPLinker","w":30,"x":541,"y":36});
this.RCUpdate.m_cID='<%=JSPLib.cmdHash("routine,arrt_allinea_cointestatari",request.getSession())%>';
this.Aggiornamenti=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left","calculate":" ","class_Css":"combobox","create_undercond":" ","ctrlid":"<%=idPortlet%>_Aggiornamenti","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":" ","empty_value":true,"encrypt":false,"font":"verdana","font_size":"7pt","h":20,"hide":"false","hide_undercond":" ","init":" ","init_par":"<%=Aggiornamenti%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"Aggiornamenti","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","textlist":"AGE + AUI,Solo 2.2,Solo 5.1,Solo 6.2","type":"Combobox","typevar":"character","valuelist":"X,1,2,3","visible":true,"w":201,"x":676,"y":50});
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
<%if(request.getAttribute("pg_abbina_cointestatari_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_abbina_cointestatari_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_abbina_cointestatari_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Aggiornamenti.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_abbina_cointestatari',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_abbina_cointestatari');
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
sp.endPage("pg_abbina_cointestatari");
}%>
<%! public String getJSPUID() { return "1759261203"; } %>