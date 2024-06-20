<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.getTitlePortlet().SetTitle(\"Correzione Rapporti Scartati (CGO)\",true)\n}\n\nfunction CancReg() {\n\u002f\u002f  if (confirm('Confermi la cancellazione della registrazione?')) {\n      alert('Funzione Non Attiva')\n\u002f\u002f  }  \n}  \n\nfunction BtnEsci_Click(){\n  if (confirm('Confermi la chiusura della maschera?')) {  \n    this.Uscita.Link();\n  }\n}  \n\nfunction RefreshView() {\n  this.Query1.Query();\n  this.Grid0.Refresh();\n}  ","adaptive":"adaptive","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"680","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"false","layout_step":"768","layout_steps_values":"{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"Correzione Rapporti Scartati (CGO)","portlet_position":"align center","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"320,480,768","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"768","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"SPLink:RappEdit\",\"weight\":\"\",\"title\":\"ID Errore\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"PRGRAP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"RAPPORTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Descrizione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DESCRAP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Intestatario (Codice Fiscale)\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"CODINTEST\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"A-Apertura - C-Chiusura\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPOMOV\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"function:CancReg()\",\"weight\":\"\",\"title\":\"\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"image:..\u002fimages\u002fgrid_delete.gif:Cancella l'operazione\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"open-reduced","fields_type":"C,C,C,D,C,C,","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"513","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"false","layout_steps_values":"{\"320\":{\"x\":0,\"y\":72,\"w\":320,\"h\":513,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":0,\"y\":72,\"w\":480,\"h\":513,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":0,\"y\":42,\"w\":768,\"h\":513,\"anchor\":\" \",\"hide\":\"false\"}}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"20","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"false","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":"768","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"42","zindex":""},{"appendingData":"false","auto_exec":"true","count":"true","h":"20","localDBName":"","n_records":"20","name":"Query1","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_cgo_rapporti_err","query_async":"false","return_fields_type":"true","sequence":"2","type":"SQLDataobj","w":"120","x":"2","y":"-66"},{"anchor":"","autocapitalize":"on","autofocus":"","calculate":"","class_Css":"","create_undercond":"","dataobj":"Query1","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"PRGRAP","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layout_steps_values":"{\"320\":{\"x\":83,\"y\":-32,\"w\":45,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":124,\"y\":-32,\"w\":67,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":201,\"y\":-68,\"w\":107,\"h\":22,\"anchor\":\" \",\"hide\":\"false\"},\"1024\":{\"x\":263,\"y\":-32,\"w\":\"146\",\"h\":22,\"anchor\":\" \",\"hide\":\"false\"}}","maxlength":"","name":"w_iderr","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"3","tabindex":"","type":"Textbox","typevar":"character","visible":"false","w":"107","wireframe_props":"name","x":"201","y":"-68","zerofilling":"false","zindex":"1"},{"async":"false","entity_type":"master","h":"30","m_cAction":"edit","m_cAltInterface":"","name":"RappEdit","offline":"false","page":"1","parms":"PRGRAP=w_iderr","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":"","refresh":"false","sequence":"4","servlet":"armt_cgo_rapporti_err","target":"","type":"SPLinker","w":"30","x":"52","y":"-66"},{"async":"false","entity_type":"routine","h":"30","m_cAction":"function","m_cAltInterface":"","name":"DelReg","offline":"false","page":"1","parms":"pSNAINUMOPE=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"6","servlet":"arfn_cgo_delreg","target":"","type":"SPLinker","w":"30","x":"90","y":"-66"},{"async":"false","entity_type":"page","h":"30","m_cAction":"","m_cAltInterface":"","name":"Uscita","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":"30","x":"139","y":"-66"},{"alt":"","anchor":"top-right","bounded_position":"","class_Css":"image","create_undercond":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":" &#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Premi il tasto per tornare al menu","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layout_steps_values":"{\"320\":{\"x\":308,\"y\":37,\"w\":9,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"480\":{\"x\":462,\"y\":37,\"w\":13,\"h\":30,\"anchor\":\" \",\"hide\":\"false\"},\"768\":{\"x\":733,\"y\":7,\"w\":30,\"h\":30,\"anchor\":\"top-right\",\"hide\":\"false\"},\"1024\":{\"x\":984,\"y\":37,\"w\":\"30\",\"h\":30,\"anchor\":\" \",\"hide\":\"false\"}}","name":"BtnEsci","page":"1","path_type":"","sequence":"8","server_side":"","src":"..\u002fimages\u002fpng\u002fclose.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"30","wireframe_props":"","x":"733","y":"7","zindex":"1"},{"actObjs":"","actTypes":"func","broadcast":"all","h":"20","included":"false","name":"armt_cgo_rapporti_err_savedEntity","objsValues":"this.RefreshView()","page":"1","parmsNames":"","sequence":"9","type":"EventReceiver","w":"22","x":"1047","y":"49"}]%>
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
window.pg_cgo_rapporti_err_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof CancReg !='undefined')this.CancReg=CancReg;
if(typeof BtnEsci_Click !='undefined')this.BtnEsci_Click=BtnEsci_Click;
if(typeof RefreshView !='undefined')this.RefreshView=RefreshView;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
this.Query1.addDataConsumer(this.w_iderr,<%=JSPLib.ToJSValue("PRGRAP",true)%>);
function this_Loaded(){
  this.getTitlePortlet().SetTitle("Correzione Rapporti Scartati (CGO)",true)
}
function CancReg() {
//  if (confirm('Confermi la cancellazione della registrazione?')) {
      alert('Funzione Non Attiva')
//  }  
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
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_cgo_rapporti_err_container {
}
.pg_cgo_rapporti_err_title_container {
  margin: auto;
}
.pg_cgo_rapporti_err_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:320px;
  height:680px;
}
.pg_cgo_rapporti_err_portlet[Data-page="1"]{
  height:680px;
  width:100%;
}
.pg_cgo_rapporti_err_portlet[Data-step="320"] {
  height:680px;
  width:100%;
}
.pg_cgo_rapporti_err_portlet[Data-step="480"] {
  height:680px;
  width:100%;
}
.pg_cgo_rapporti_err_portlet[Data-step="768"] {
  height:680px;
  width:100%;
}
.pg_cgo_rapporti_err_portlet[Data-step="320"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:72px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:513px;
}
.pg_cgo_rapporti_err_portlet[Data-step="480"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:72px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:513px;
}
.pg_cgo_rapporti_err_portlet[Data-step="768"] > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:42px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:513px;
}
.pg_cgo_rapporti_err_portlet[Data-step="320"] > .w_iderr_ctrl {
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
.pg_cgo_rapporti_err_portlet[Data-step="480"] > .w_iderr_ctrl {
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
.pg_cgo_rapporti_err_portlet[Data-step="768"] > .w_iderr_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-68px;
  left:201px;
  left:26.171875%;
  right:460px;
  right:59.895832%;
  width:auto;
  height:22px;
}
.pg_cgo_rapporti_err_portlet > .w_iderr_ctrl {
  display:none;
}
.pg_cgo_rapporti_err_portlet > .w_iderr_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_cgo_rapporti_err_portlet[Data-step="320"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:308px;
  left:96.25%;
  right:3px;
  right:0.9375%;
  width:auto;
  height:30px;
}
.pg_cgo_rapporti_err_portlet[Data-step="480"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:37px;
  left:462px;
  left:96.25%;
  right:5px;
  right:1.0416666%;
  width:auto;
  height:30px;
}
.pg_cgo_rapporti_err_portlet[Data-step="768"] > .BtnEsci_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:7px;
  right:5px;
  width:30px;
  height:30px;
}
.pg_cgo_rapporti_err_portlet > .BtnEsci_ctrl {
  text-decoration:none;
  font-family:ZucchettiDevelopement;
  text-align:center;
  line-height:30px;
  font-size:30px;
}
.pg_cgo_rapporti_err_portlet[Data-step="1024"] > .BtnEsci_ctrl {
  line-height:30px;
  font-size:30px;
}
.pg_cgo_rapporti_err_portlet[Data-step="320"] > .BtnEsci_ctrl {
  line-height:30px;
  font-size:9px;
}
.pg_cgo_rapporti_err_portlet[Data-step="480"] > .BtnEsci_ctrl {
  line-height:30px;
  font-size:13px;
}
.pg_cgo_rapporti_err_portlet[Data-step="768"] > .BtnEsci_ctrl {
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
 String def="[{\"h\":\"680\",\"layout_steps_values\":{\"320\":{\"h\":\"680\",\"w\":\"100%\"},\"480\":{\"h\":\"680\",\"w\":\"100%\"},\"768\":{\"h\":\"680\",\"w\":\"100%\"}},\"pages_names\":\"Correzione Rapporti Scartati (CGO)\",\"steps\":\"320,480,768\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"768\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ID Errore\"},{\"title\":\"Codice Rapporto\"},{\"title\":\"Descrizione\"},{\"title\":\"Data Operazione\"},{\"title\":\"Codice Intestatario (Codice Fiscale)\"},{\"title\":\"A-Apertura - C-Chiusura\"},{\"title\":\"\"}],\"h\":\"513\",\"layout_steps_values\":{\"320\":{\"anchor\":\" \",\"h\":513,\"hide\":\"false\",\"w\":320,\"x\":0,\"y\":72},\"480\":{\"anchor\":\" \",\"h\":513,\"hide\":\"false\",\"w\":480,\"x\":0,\"y\":72},\"768\":{\"anchor\":\" \",\"h\":513,\"hide\":\"false\",\"w\":768,\"x\":0,\"y\":42}},\"page\":\"1\",\"rows\":\"20\",\"type\":\"Grid\",\"w\":\"768\",\"x\":\"0\",\"y\":\"42\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"2\",\"y\":\"-66\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":\"146\",\"x\":263,\"y\":-32},\"320\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":45,\"x\":83,\"y\":-32},\"480\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":67,\"x\":124,\"y\":-32},\"768\":{\"anchor\":\" \",\"h\":22,\"hide\":\"false\",\"w\":107,\"x\":201,\"y\":-68}},\"name\":\"w_iderr\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"107\",\"x\":\"201\",\"y\":\"-68\",\"zindex\":\"1\"},{\"h\":\"30\",\"name\":\"RappEdit\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"52\",\"y\":\"-66\"},{\"h\":\"30\",\"name\":\"DelReg\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"90\",\"y\":\"-66\"},{\"h\":\"30\",\"name\":\"Uscita\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"139\",\"y\":\"-66\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"layout_steps_values\":{\"1024\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":\"30\",\"x\":984,\"y\":37},\"320\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":9,\"x\":308,\"y\":37},\"480\":{\"anchor\":\" \",\"h\":30,\"hide\":\"false\",\"w\":13,\"x\":462,\"y\":37},\"768\":{\"anchor\":\"top-right\",\"h\":30,\"hide\":\"false\",\"w\":30,\"x\":733,\"y\":7}},\"name\":\"BtnEsci\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"30\",\"x\":\"733\",\"y\":\"7\",\"zindex\":\"1\"},{\"h\":\"20\",\"name\":\"armt_cgo_rapporti_err_savedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"1047\",\"y\":\"49\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_cgo_rapporti_err","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_cgo_rapporti_err_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_cgo_rapporti_err','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_cgo_rapporti_err_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_iderr= "";
if(request.getAttribute("pg_cgo_rapporti_err_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_cgo_rapporti_err_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_cgo_rapporti_err_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_cgo_rapporti_err_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_cgo_rapporti_err','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_w_iderr_wrp'><input id='<%=idPortlet%>_w_iderr' name='w_iderr' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_iderr' /></span>
<a id='<%=idPortlet%>_BtnEsci' class='image BtnEsci_ctrl'   target=''>&#xe9fb;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_cgo_rapporti_err');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_cgo_rapporti_err',["768"],["680"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'320,480,768', 'adaptive','<%=m_cTITLEUID%>','',{"320":{"h":"680","w":"100%"},"480":{"h":"680","w":"100%"},"768":{"h":"680","w":"100%"}},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{"320":{"w":"100%","h":"680"},"768":{"w":"100%","h":"680"},"480":{"w":"100%","h":"680"}},"w":"768","h":"680","title":"Correzione Rapporti Scartati (CGO)","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"open-reduced","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":513,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"false","layer":false,"layout_steps_values":{"320":{"anchor":" ","h":513,"hide":"false","w":320,"x":0,"y":72},"480":{"anchor":" ","h":513,"hide":"false","w":480,"x":0,"y":72},"768":{"anchor":" ","h":513,"hide":"false","w":768,"x":0,"y":42}},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"false","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"","w":768,"x":0,"y":42,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"SPLink:RappEdit","weight":"","title":"ID Errore","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"PRGRAP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"RAPPORTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Descrizione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DESCRAP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Intestatario (Codice Fiscale)","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"CODINTEST","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"A-Apertura - C-Chiusura","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPOMOV","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"function:CancReg()","weight":"","title":"","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"image:..\u002fimages\u002fgrid_delete.gif:Cancella l'operazione","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_cgo_rapporti_err","cmdHash":"<%=JSPLib.cmdHash("qbe_cgo_rapporti_err",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"20","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":2,"y":-66});
this.w_iderr=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_iderr","decrypt":false,"edit_undercond":"","encrypt":false,"field":"PRGRAP","fixed":"false","floating_placeholder":false,"h":22,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":22,"hide":"false","w":"146","x":263,"y":-32},"320":{"anchor":" ","h":22,"hide":"false","w":45,"x":83,"y":-32},"480":{"anchor":" ","h":22,"hide":"false","w":67,"x":124,"y":-32},"768":{"anchor":" ","h":22,"hide":"false","w":107,"x":201,"y":-68}},"maxlength":"","name":"w_iderr","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_iderr,false,true)%>","w":107,"x":201,"y":-68,"zerofilling":false,"zindex":"1","zoom":""});
this.RappEdit=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RappEdit","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RappEdit","offline":false,"page":1,"parms":"PRGRAP=w_iderr","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_cgo_rapporti_err","target":"","type":"SPLinker","w":30,"x":52,"y":-66});
this.RappEdit.m_cID='<%=JSPLib.cmdHash("entity,armt_cgo_rapporti_err",request.getSession())%>';
this.DelReg=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_DelReg","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"DelReg","offline":false,"page":1,"parms":"pSNAINUMOPE=w_snainumope","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_cgo_delreg","target":"","type":"SPLinker","w":30,"x":90,"y":-66});
this.DelReg.m_cID='<%=JSPLib.cmdHash("routine,arfn_cgo_delreg",request.getSession())%>';
this.Uscita=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Uscita","decrypted_parms":"","entity_type":"page","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Uscita","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"start_page_logo_portlet.jsp","target":"","type":"SPLinker","w":30,"x":139,"y":-66});
this.Uscita.m_cID='<%=JSPLib.cmdHash("entity,start_page_logo_portlet.jsp",request.getSession())%>';
this.BtnEsci=new ZtVWeb._IC(this,{"alt":"","anchor":"top-right","boundedPosition":"","class_Css":"image BtnEsci_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_BtnEsci","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe9fb;","font_image_hover":"&#xe9fc;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Premi il tasto per tornare al menu",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{"1024":{"anchor":" ","h":30,"hide":"false","w":"30","x":984,"y":37},"320":{"anchor":" ","h":30,"hide":"false","w":9,"x":308,"y":37},"480":{"anchor":" ","h":30,"hide":"false","w":13,"x":462,"y":37},"768":{"anchor":"top-right","h":30,"hide":"false","w":30,"x":733,"y":7}},"name":"BtnEsci","page":1,"path_type":"","server_side":"","src":"&#xe9fb;","srchover":"&#xe9fc;","tabindex":"","target":"","type":"Image","type_submit":"false","w":30,"x":733,"y":7,"zindex":"1"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.armt_cgo_rapporti_err_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_cgo_rapporti_err_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_cgo_rapporti_err_savedEntity","objsValues":"this.RefreshView()","page":1,"parmsNames":"","type":"EventReceiver","w":22,"x":1047,"y":49});
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
<%if(request.getAttribute("pg_cgo_rapporti_err_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_cgo_rapporti_err_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_cgo_rapporti_err_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.BtnEsci.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_armt_cgo_rapporti_err_savedEntity=function(parmsObj){<%=idPortlet%>.armt_cgo_rapporti_err_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_cgo_rapporti_err',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_cgo_rapporti_err');
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
sp.endPage("pg_cgo_rapporti_err");
}%>
<%! public String getJSPUID() { return "804961195"; } %>