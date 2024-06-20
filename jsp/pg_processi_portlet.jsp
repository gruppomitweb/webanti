<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Forza_Click(){\n  this.splinker_forza.Link()\n}\nfunction Aggiorna_Click(){\n  this.SQLProcessi.Query()\n  this.Grid0.Refresh()\n}\n\nfunction PrelevaFile(_esito) {\n  if (Empty(this.nomefile.Value())) {\n    alert('Non esistono file da prelevare!');\n  } else {    \n    if (_esito=='P') {\n      if (this.gBrowser.Value()=='I') {\n        var stile = \"top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no resizable=yes\";  \n      } else {\n        var stile = \"top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no\";  \n      }   \n      this.RTCopia.Link()    \n    }\n  }\n}\n\nfunction Timer8_onTimer(){\n  this.Aggiorna_Click();\n}\n\nfunction Timer11_onTimer(){\n  var d = new Date();\n  var n = d.getMinutes();\n  var m = n%10;\n  var r =\"\";\n  \n  if(m\u003c=5){\n    r=\"I processi schedulati verranno lanciati tra \"+String(5-m)+\" minuti\";\n  }else{\n    r=\"I processi schedulati verranno lanciati tra \"+String(10-m)+\" minuti\";\n  }\n  this.label12.Value(r);  \n}\n\nfunction RTCopia_Result(result){\n  if(result=='OK') {\n    this.downloadURI('..\u002fappo\u002f'+this.gAzienda.Value()+\"\u002f\"+this.nomefile.Value(),this.nomefile.Value())\n  } else {\n    alert(\"Non ci sono file da prelevare\")\n  }  \n}\n\nfunction downloadURI(uri, name) {\n  var link = document.createElement(\"a\");\n  link.download = name;\n  link.href = uri;\n  document.body.appendChild(link);\n  link.click();\n  document.body.removeChild(link);\n  delete link;\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"550","hsl":"","htmlcode":"\n\n{{ @label12 }}\n{{ @Forza }}\n{{ @Aggiorna }}\n{{ @label2_Copy_Copy }}\n{{ @Grid0 }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Visualizza Stato Processi","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"public","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"600","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PR_TIPO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:PrelevaFile('%PRESITO%')\",\"weight\":\"\",\"title\":\"Codice\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRCODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRDESCRI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Inizio\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRDOSTART\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Fine\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRDOSTOP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Esito\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRESITO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Messaggio di stato\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRGMSGSTA\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome File Output\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRFILEOUT\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo File Output\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PTRIPOOUT\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome File senza Path\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRNOMEFILE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQLProcessi","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"C,C,C,T,T,C,C,C,C,C","filters":"true-by-example","floatRows":"","font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":"473","hide":"false","hide_default_titles":"","hide_empty_lines":"false","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layer":"false","layout_steps_values":"{}","line_color":"#FFFFFF","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"#CCCCCC","row_color_odd":"#999999","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":"600","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"25","zindex":""},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"#1306C6","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","fontpct":"","h":"25","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label2_Copy_Copy","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"2","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"PROCESSI DI ELABORAZIONE","w":"600","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1"},{"anchor":"top-right","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"Aggiorna","page":"1","sequence":"3","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Aggiorna","w":"75","wireframe_props":"value","x":"522","y":"2","zindex":"1"},{"anchor":"top-right","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button","create_undercond":"","ctrlOfVariant":"","edit_undercond":"","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":"20","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"Forza","page":"1","sequence":"4","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Forza","w":"75","wireframe_props":"value","x":"445","y":"2","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"start","name":"splinker_forza","offline":"false","page":"1","parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"arrt_pbprocessi","target":"","type":"SPLinker","w":"137","x":"784","y":"15"},{"align":"center","anchor":"top-left-right","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":"19","heading":"h1","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label12","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"","w":"600","wireframe_props":"align,value,n_col","x":"0","y":"516","zindex":"1"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"20","name":"SQLProcessi","offline":"false","page":"1","parms":"","parms_source":"","query":"rows:arfn_processi","query_async":"false","return_fields_type":"true","sequence":"7","type":"SQLDataobj","w":"120","x":"789","y":"51"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gUrlApp","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"952","y":"-33"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gBrowser","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"946","y":"-62"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLProcessi","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"PRFILEOUT","h":"20","init":"","init_par":"","name":"nomezip","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"618","y":"-57"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLProcessi","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"PRNOMEFILE","h":"20","init":"","init_par":"","name":"nomefile","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"622","y":"-27"},{"allowedentities":"arfn_copy_file_appo","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"RTCopia","offline":"false","page":"1","parms":"pNomeFile=nomefile,pCartella=export","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"12","servlet":"arfn_copy_file_appo","target":"","type":"SPLinker","w":"120","x":"791","y":"84"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"13","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"962","y":"-3"},{"delay":"0","duration":"","h":"30","interval":"1000","name":"Timer11","page":"1","repeated":"true","rounds":"","start_activated":"true","type":"Timer","w":"136","x":"788","y":"-29"},{"delay":"0","duration":"","h":"30","interval":"5000","name":"Timer8","page":"1","repeated":"true","rounds":"","start_activated":"true","type":"Timer","w":"142","x":"787","y":"-62"}]%>
<%/*Description:*/%>
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
window.pg_processi_Static=function(){
if(typeof Forza_Click !='undefined')this.Forza_Click=Forza_Click;
if(typeof Aggiorna_Click !='undefined')this.Aggiorna_Click=Aggiorna_Click;
if(typeof PrelevaFile !='undefined')this.PrelevaFile=PrelevaFile;
if(typeof Timer8_onTimer !='undefined')this.Timer8_onTimer=Timer8_onTimer;
if(typeof Timer11_onTimer !='undefined')this.Timer11_onTimer=Timer11_onTimer;
if(typeof RTCopia_Result !='undefined')this.RTCopia_Result=RTCopia_Result;
if(typeof downloadURI !='undefined')this.downloadURI=downloadURI;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLProcessi.addRowConsumer(this.Grid0);
this.SQLProcessi.addDataConsumer(this.nomezip,<%=JSPLib.ToJSValue("PRFILEOUT",true)%>);
this.SQLProcessi.addDataConsumer(this.nomefile,<%=JSPLib.ToJSValue("PRNOMEFILE",true)%>);
function Forza_Click(){
  this.splinker_forza.Link()
}
function Aggiorna_Click(){
  this.SQLProcessi.Query()
  this.Grid0.Refresh()
}
function PrelevaFile(_esito) {
  if (Empty(this.nomefile.Value())) {
    alert('Non esistono file da prelevare!');
  } else {    
    if (_esito=='P') {
      if (this.gBrowser.Value()=='I') {
        var stile = "top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no resizable=yes";  
      } else {
        var stile = "top=10, left=10, width=640, height=480, status=no, menubar=no, toolbar=no scrollbars=no";  
      }   
      this.RTCopia.Link()    
    }
  }
}
function Timer8_onTimer(){
  this.Aggiorna_Click();
}
function Timer11_onTimer(){
  var d = new Date();
  var n = d.getMinutes();
  var m = n%10;
  var r ="";
  
  if(m<=5){
    r="I processi schedulati verranno lanciati tra "+String(5-m)+" minuti";
  }else{
    r="I processi schedulati verranno lanciati tra "+String(10-m)+" minuti";
  }
  this.label12.Value(r);  
}
function RTCopia_Result(result){
  if(result=='OK') {
    this.downloadURI('../appo/'+this.gAzienda.Value()+"/"+this.nomefile.Value(),this.nomefile.Value())
  } else {
    alert("Non ci sono file da prelevare")
  }  
}
function downloadURI(uri, name) {
  var link = document.createElement("a");
  link.download = name;
  link.href = uri;
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
  delete link;
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
.pg_processi_container {
}
.pg_processi_title_container {
  margin: auto;
}
.pg_processi_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:600px;
  height:550px;
}
.pg_processi_portlet[Data-page="1"]{
  height:550px;
  width:100%;
}
.pg_processi_portlet > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:25px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:473px;
}
.pg_processi_portlet > .label2_Copy_Copy_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:25px;
}
.pg_processi_portlet > .label2_Copy_Copy_ctrl {
  height:auto;
  min-height:25px;
}
.pg_processi_portlet > .label2_Copy_Copy_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:13pt;
  font-weight:bold;
  color:#FCFCFC;
  text-align:center;
  background-color:#1306C6;
}
.pg_processi_portlet > .Aggiorna_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:2px;
  right:3px;
  width:75px;
  height:20px;
}
.pg_processi_portlet > .Aggiorna_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#FFFFFF;
  background-color:#10CE1D;
  border-width:1px;
  border-color:#000000;
}
.pg_processi_portlet > .Forza_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:2px;
  right:80px;
  width:75px;
  height:20px;
}
.pg_processi_portlet > .Forza_ctrl {
  font-family:Verdana;
  font-size:7pt;
  color:#FFFFFF;
  background-color:#10CE1D;
  border-width:1px;
  border-color:#000000;
}
.pg_processi_portlet > .label12_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:516px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_processi_portlet > .label12_ctrl {
  height:auto;
  min-height:19px;
}
.pg_processi_portlet > .label12_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:center;
  background-color:transparent;
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
 String def="[{\"h\":\"550\",\"layout_steps_values\":{},\"pages_names\":\"Visualizza Stato Processi\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"600\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Tipo\"},{\"title\":\"Codice\"},{\"title\":\"Descrizione\"},{\"title\":\"Inizio\"},{\"title\":\"Fine\"},{\"title\":\"Esito\"},{\"title\":\"Messaggio di stato\"},{\"title\":\"Nome File Output\"},{\"title\":\"Tipo File Output\"},{\"title\":\"Nome File senza Path\"}],\"h\":\"473\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"600\",\"x\":\"0\",\"y\":\"25\",\"zindex\":\"\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"25\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"PROCESSI DI ELABORAZIONE\",\"w\":\"600\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"Aggiorna\",\"w\":\"75\",\"x\":\"522\",\"y\":\"2\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"20\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"Forza\",\"w\":\"75\",\"x\":\"445\",\"y\":\"2\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"137\",\"x\":\"784\",\"y\":\"15\"},{\"align\":\"center\",\"anchor\":\"top-left-right\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"\",\"w\":\"600\",\"x\":\"0\",\"y\":\"516\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"789\",\"y\":\"51\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"952\",\"y\":\"-33\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"946\",\"y\":\"-62\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"618\",\"y\":\"-57\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"622\",\"y\":\"-27\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"791\",\"y\":\"84\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"962\",\"y\":\"-3\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"136\",\"x\":\"788\",\"y\":\"-29\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"142\",\"x\":\"787\",\"y\":\"-62\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_processi","UTF-8")) {return; }
 %><%if(!sp.isLoggedIgnoreGuest()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&m_bValidateGuest=true&m_cAction=save&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_processi_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_processi','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_processi_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String label2_Copy_Copy= "PROCESSI DI ELABORAZIONE";
String label12= "";
String gUrlApp=sp.getGlobal("gUrlApp","");
String gBrowser=sp.getGlobal("gBrowser","");
String nomezip= "";
String nomefile= "";
String gAzienda=sp.getGlobal("gAzienda","");
if(request.getAttribute("pg_processi_firstinclusion")==null){%>
<script type='text/javascript' src='../<%=SPPrxycizer.proxycizedPath("TimerObj.js")%>'></script>
<%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_processi_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_processi_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_processi','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_label2_Copy_Copy'  formid='<%=idPortlet%>' ps-name='label2_Copy_Copy'    class='label label2_Copy_Copy_ctrl'><div id='<%=idPortlet%>_label2_Copy_Copytbl' style='width:100%;'><%=JSPLib.ToHTML("PROCESSI DI ELABORAZIONE")%></div></span>
<input id='<%=idPortlet%>_Aggiorna' type='button' class='button Aggiorna_ctrl'/>
<input id='<%=idPortlet%>_Forza' type='button' class='button Forza_ctrl'/>
<span id='<%=idPortlet%>_label12'  formid='<%=idPortlet%>' ps-name='label12'    class='label label12_ctrl'><div id='<%=idPortlet%>_label12tbl' style='width:100%;'><h1></h1></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_processi');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_processi',["600"],["550"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"600","h":"550","title":"Visualizza Stato Processi","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"SQLProcessi","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"Tahoma","font_color":"black","font_size":"7pt","font_weight":"normal","group_repeated":"false","h":473,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{},"line_color":"#FFFFFF","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"black","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"#CCCCCC","row_color_odd":"#999999","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"","w":600,"x":0,"y":25,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PR_TIPO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:PrelevaFile('%PRESITO%')","weight":"","title":"Codice","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRCODICE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRDESCRI","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Inizio","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRDOSTART","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Fine","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRDOSTOP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Esito","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRESITO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Messaggio di stato","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRGMSGSTA","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome File Output","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRFILEOUT","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo File Output","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PTRIPOOUT","fg_color":"","width":"","RowSpan":0,"extensible":true},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome File senza Path","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRNOMEFILE","fg_color":"","width":"","RowSpan":0,"extensible":true}]});
this.label2_Copy_Copy=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2_Copy_Copy","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#FCFCFC","font_size":"13pt","font_weight":"bold","fontpct":"","h":25,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2_Copy_Copy","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label2_Copy_Copy,false,true)%>","type":"Label","w":600,"x":0,"y":0,"zindex":"1"});
this.Aggiorna=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button Aggiorna_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Aggiorna","edit_undercond":"","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"Aggiorna","page":1,"spuid":"","tabindex":"","text":"Aggiorna","type":"Button","type_submit":"false","type_wizard":"","w":75,"x":522,"y":2,"zindex":"1"});
this.Forza=new ZtVWeb._BC(this,{"anchor":"top-right","bg_color":"#10CE1D","border_color":"#000000","border_weight":"1","class_Css":"button Forza_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Forza","edit_undercond":"","font":"Verdana","font_color":"#FFFFFF","font_size":"7pt","h":20,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"Forza","page":1,"spuid":"","tabindex":"","text":"Forza","type":"Button","type_submit":"false","type_wizard":"","w":75,"x":445,"y":2,"zindex":"1"});
this.splinker_forza=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_forza","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_forza","offline":false,"page":1,"parms":"","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"","progressbar":false,"refresh":"","servlet":"arrt_pbprocessi","target":"","type":"SPLinker","w":137,"x":784,"y":15});
this.splinker_forza.m_cID='<%=JSPLib.cmdHash("routine,arrt_pbprocessi",request.getSession())%>';
this.label12=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label12","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"h1","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label12","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label12,false,true)%>","type":"Label","w":600,"x":0,"y":516,"zindex":"1"});
this.SQLProcessi=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"rows:arfn_processi","cmdHash":"<%=JSPLib.cmdHash("rows:arfn_processi",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLProcessi","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLProcessi","nrows":"20","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":789,"y":51});
this.gUrlApp=new ZtVWeb._VC(this,'gUrlApp',null,'character','<%=JSPLib.ToJSValue(gUrlApp,false,true)%>',false,false);
this.gBrowser=new ZtVWeb._VC(this,'gBrowser',null,'character','<%=JSPLib.ToJSValue(gBrowser,false,true)%>',false,false);
this.nomezip=new ZtVWeb._VC(this,'nomezip',null,'character','<%=JSPLib.ToJSValue(nomezip,false,true)%>',false,false);
this.nomefile=new ZtVWeb._VC(this,'nomefile',null,'character','<%=JSPLib.ToJSValue(nomefile,false,true)%>',false,false);
this.RTCopia=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_copy_file_appo",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCopia","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCopia","offline":false,"page":1,"parms":"pNomeFile=nomefile,pCartella=export","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_copy_file_appo","target":"","type":"SPLinker","w":120,"x":791,"y":84});
this.RTCopia.m_cID='<%=JSPLib.cmdHash("routine,arfn_copy_file_appo",request.getSession())%>';
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
this.Timer11=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_Timer11","delay":"0","duration":"","h":30,"hide":"false","interval":"1000","layer":false,"layout_steps_values":{},"name":"Timer11","page":1,"repeated":"true","rounds":"","start_activated":"true","type":"Timer","w":136,"x":788,"y":-29});
this.Timer8=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_Timer8","delay":"0","duration":"","h":30,"hide":"false","interval":"5000","layer":false,"layout_steps_values":{},"name":"Timer8","page":1,"repeated":"true","rounds":"","start_activated":"true","type":"Timer","w":142,"x":787,"y":-62});
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
<%if(request.getAttribute("pg_processi_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_processi_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_processi_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLProcessi.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_processi',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_processi');
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
sp.endPage("pg_processi");
}%>
<%! public String getJSPUID() { return "4180646273"; } %>