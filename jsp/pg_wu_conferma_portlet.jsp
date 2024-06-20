<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  this.chkOpex.Hide();\n  this.lblOpex.Hide();\n}\n\nfunction rdDest2_onChange(){\n  \n  if (this.rdDest2.Value()=='D') {\n    this.chkOpex.Show();\n    this.lblOpex.Show();\n  } else {\n    this.chkOpex.Hide();\n    this.lblOpex.Hide();     \n    this.chkOpex.Value('N');\n  }  \n}\n\nfunction BtnUscita_Click(){\n  if (confirm(\"Confermi l'uscita?\")) {\n    this.RTUscita.Link()\n  }    \n}\n","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#FFFFFF","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":"default","form_target":" ","form_type":"false","h":"600","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"1024","version":"37","w":"100%"},{"auto_exec":"true","count":"true","localDBName":" ","n_records":"10000","name":"SQLOperazioni","offline":"false","page":"1","parms":" ","parms_source":" ","query":"qbe_wu_conferma","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","x":"8","y":"-32"},{"align":"left","anchor":"top-left-right","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"true-selectAll","checkbox_fields":"WUCODICE","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUCODICE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"MTCN\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WURIFMTCN\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUTIPOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Network\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUCODMAGE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Agenzia\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUCODDIP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUDATOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Importo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUIMPORTO\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Stato Destinazione WU\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUSTADES\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Codice Fiscale\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUCODFIS\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Cognome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUCOGCLI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUNOMCLI\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"WUOPETYPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"SQLOperazioni","disable_fields_conditions":" ","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"N,C,C,C,C,D,N,C,C,C,C,C","filters":"true-by-example","floatRows":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","group_repeated":"false","h":"479","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"true","line_color":" ","link_underlined":" ","name":"grdOperazioni","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":" ","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":"true","recMark":" ","render_totals":" ","resizablecolumns":"false","row_color":" ","row_color_odd":" ","rows":"20","scroll_bars":"false","sequence":"3","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":"top","w":"1022","x":"1","y":"78"},{"align":"center","anchor":"top-left-right","assoc_input":" ","bg_color":"#030BFF","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblTitolo","nowrap":"false","page":"1","picture":" ","sequence":"4","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"CONFERMA OPERAZIONI SCARTATE","w":"1024","x":"0","y":"0","zindex":"1"},{"anchor":" ","calculate":"'O'","class_Css":"radio","create_undercond":" ","disabled":"false","edit_undercond":" ","font":"verdana","font_size":"7pt","h":"43","hide_undercond":" ","init":"true","init_par":" ","name":"rdDest1","orientation":"vertical","page":"1","picture":" ","sequence":"5","tabindex":" ","textlist":"Operazioni,Frazionate","type":"Radio","typevar":"character","valuelist":"O,F","visible":"true","w":"133","x":"103","y":"26"},{"anchor":" ","calculate":"'P'","class_Css":"radio","create_undercond":" ","disabled":"false","edit_undercond":" ","font":"verdana","font_size":"7pt","h":"43","hide_undercond":" ","init":"true","init_par":" ","name":"rdDest2","orientation":"vertical","page":"1","picture":" ","sequence":"5","tabindex":" ","textlist":"Definitive,Provvisorie","type":"Radio","typevar":"character","valuelist":"D,P","visible":"true","w":"164","x":"236","y":"26"},{"align":"right","anchor":" ","assoc_input":" ","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"bold","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblFlag","nowrap":"false","page":"1","picture":" ","sequence":"6","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Destinazione","w":"93","x":"6","y":"40","zindex":"1"},{"anchor":" ","calculate":"'N'","checked_value":"S","create_undercond":" ","edit_undercond":" ","h":"13","help_tips":" ","hide_undercond":" ","init":"true","init_par":" ","name":"chkOpex","page":"1","sequence":"7","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"N","w":"13","x":"401","y":"41"},{"align":"left","anchor":" ","assoc_input":"chkOpex","bg_color":"transparent","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblOpex","nowrap":"false","page":"1","picture":" ","sequence":"8","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Crea operazioni Extra Conto","w":"151","x":"419","y":"45","zindex":"1"},{"alt":" ","anchor":"top-right","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":" ","hide_undercond":" ","href":" ","img_type":"default","name":"BtnUscita","page":"1","path_type":" ","sequence":"9","server_side":" ","src":"..\u002fimages\u002fexit.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"973","y":"31","zindex":"1"},{"alt":" ","anchor":"top-right","class_Css":"image","create_undercond":" ","dataobj":" ","field":" ","font_color":" ","font_color_hover":" ","font_image":" ","font_image_hover":" ","font_name":" ","font_path":" ","h":"30","help_tips":" ","hide_undercond":" ","href":" ","img_type":"default","name":"Elabora","page":"1","path_type":" ","sequence":"10","server_side":" ","src":"..\u002fimages\u002felaborazione.gif","srchover":" ","tabindex":" ","target":" ","type":"Image","type_submit":"false","w":"40","x":"923","y":"31","zindex":"1"},{"async":"false","entity_type":" ","h":"30","m_cAction":" ","m_cAltInterface":" ","name":"RTUscita","offline":"false","page":"1","parms":" ","popup":"false","popup_height":" ","popup_scroll":"false","popup_style":"by skin","popup_width":" ","refresh":" ","sequence":"11","servlet":"..\u002fjsp\u002fstart_page_logo_portlet.jsp","target":" ","type":"SPLinker","w":"30","x":"69","y":"-40"}]%>
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
window.pg_wu_conferma_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof rdDest2_onChange !='undefined')this.rdDest2_onChange=rdDest2_onChange;
if(typeof BtnUscita_Click !='undefined')this.BtnUscita_Click=BtnUscita_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl('O',this.rdDest1);
ZtVWeb.InitCtrl('P',this.rdDest2);
ZtVWeb.InitCtrl('N',this.chkOpex);
this.SQLOperazioni.addRowConsumer(this.grdOperazioni);
function this_Loaded(){
  this.chkOpex.Hide();
  this.lblOpex.Hide();
}
function rdDest2_onChange(){
  
  if (this.rdDest2.Value()=='D') {
    this.chkOpex.Show();
    this.lblOpex.Show();
  } else {
    this.chkOpex.Hide();
    this.lblOpex.Hide();     
    this.chkOpex.Value('N');
  }  
}
function BtnUscita_Click(){
  if (confirm("Confermi l'uscita?")) {
    this.RTUscita.Link()
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
.pg_wu_conferma_container {
}
.pg_wu_conferma_portlet{
  position:relative;
  width:100%;
  min-width:1024px;
  height:600px;
  background-color:#FFFFFF;
}
.pg_wu_conferma_portlet[Data-page="1"]{
  height:600px;
  width:100%;
}
.pg_wu_conferma_portlet > .grdOperazioni_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:78px;
  left:1px;
  right:1px;
  width:auto;
  height:auto;
  min-height:479px;
}
.pg_wu_conferma_portlet > .lblTitolo_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:19px;
}
.pg_wu_conferma_portlet > .lblTitolo_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_conferma_portlet > .lblTitolo_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:10pt;
  font-weight:bold;
  color:#EFF702;
  text-align:center;
  background-color:#030BFF;
}
.pg_wu_conferma_portlet > .rdDest1_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:103px;
  width:133px;
  height:43px;
  height:auto;
  min-height:43px;
}
.pg_wu_conferma_portlet > .rdDest2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:26px;
  left:236px;
  width:164px;
  height:43px;
  height:auto;
  min-height:43px;
}
.pg_wu_conferma_portlet > .lblFlag_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:40px;
  left:6px;
  width:93px;
  height:auto;
  min-height:19px;
}
.pg_wu_conferma_portlet > .lblFlag_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_conferma_portlet > .lblFlag_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#000000;
  text-align:right;
  background-color:transparent;
}
.pg_wu_conferma_portlet > .chkOpex_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:41px;
  left:401px;
  width:13px;
  height:13px;
}
.pg_wu_conferma_portlet > .lblOpex_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:45px;
  left:419px;
  width:151px;
  height:auto;
  min-height:19px;
}
.pg_wu_conferma_portlet > .lblOpex_ctrl {
  height:auto;
  min-height:19px;
}
.pg_wu_conferma_portlet > .lblOpex_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:7pt;
  font-weight:normal;
  color:#000000;
  text-align:left;
  background-color:transparent;
}
.pg_wu_conferma_portlet > .BtnUscita_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:31px;
  right:11px;
  width:40px;
  height:30px;
}
.pg_wu_conferma_portlet > .BtnUscita_ctrl {
}
.pg_wu_conferma_portlet > .BtnUscita_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
}
.pg_wu_conferma_portlet > .Elabora_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:31px;
  right:61px;
  width:40px;
  height:30px;
}
.pg_wu_conferma_portlet > .Elabora_ctrl {
}
.pg_wu_conferma_portlet > .Elabora_ctrl > img{
  width:100%;
  vertical-align:top;
  height:30px;
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
 String def="[{\"h\":\"600\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"1024\",\"w\":\"100%\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"8\",\"y\":\"-32\"},{\"anchor\":\"top-left-right\",\"h\":\"479\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"1022\",\"x\":\"1\",\"y\":\"78\"},{\"anchor\":\"top-left-right\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"1024\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"43\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"133\",\"x\":\"103\",\"y\":\"26\"},{\"anchor\":\"\",\"h\":\"43\",\"page\":\"1\",\"type\":\"Radio\",\"w\":\"164\",\"x\":\"236\",\"y\":\"26\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"93\",\"x\":\"6\",\"y\":\"40\",\"zindex\":\"1\"},{\"anchor\":\"\",\"h\":\"13\",\"page\":\"1\",\"type\":\"Checkbox\",\"w\":\"13\",\"x\":\"401\",\"y\":\"41\"},{\"anchor\":\"\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"151\",\"x\":\"419\",\"y\":\"45\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"973\",\"y\":\"31\",\"zindex\":\"1\"},{\"anchor\":\"top-right\",\"h\":\"30\",\"page\":\"1\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"923\",\"y\":\"31\",\"zindex\":\"1\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"30\",\"x\":\"69\",\"y\":\"-40\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_wu_conferma","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_wu_conferma_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_wu_conferma','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_wu_conferma_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String lblTitolo= "CONFERMA OPERAZIONI SCARTATE";
String rdDest1= "";
String rdDest2= "";
String lblFlag= "Destinazione";
String chkOpex= "";
String lblOpex= "Crea operazioni Extra Conto";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_wu_conferma_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_wu_conferma_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_wu_conferma','<%=idPortlet%>',false,' ');
</script><%}}%>
<div id='<%=idPortlet%>_grdOperazioni' formid='<%=idPortlet%>' ps-name='grdOperazioni'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_lblTitolo'  formid='<%=idPortlet%>' ps-name='lblTitolo'    class='label lblTitolo_ctrl'><div id='<%=idPortlet%>_lblTitolotbl' style='width:100%;'><%=JSPLib.ToHTML("CONFERMA OPERAZIONI SCARTATE")%></div></span>
<div id='<%=idPortlet%>_rdDest1' class='radio' style='z-index:1;font-family:verdana;font-size:7pt;'></div>
<div id='<%=idPortlet%>_rdDest2' class='radio' style='z-index:1;font-family:verdana;font-size:7pt;'></div>
<span id='<%=idPortlet%>_lblFlag'  formid='<%=idPortlet%>' ps-name='lblFlag'    class='label lblFlag_ctrl'><div id='<%=idPortlet%>_lblFlagtbl' style='width:100%;'><%=JSPLib.ToHTML("Destinazione")%></div></span>
<input id='<%=idPortlet%>_chkOpex' name='chkOpex' class='checkbox' type='checkbox' style=''/>
<label id='<%=idPortlet%>_lblOpex' for='<%=idPortlet%>_chkOpex' formid='<%=idPortlet%>' ps-name='lblOpex'    class='label lblOpex_ctrl'><div id='<%=idPortlet%>_lblOpextbl' style='width:100%;'><%=JSPLib.ToHTML("Crea operazioni Extra Conto")%></div></label>
<div id='<%=idPortlet%>_BtnUscita'>
<img id='<%=idPortlet%>_BtnUscita_img' class='image BtnUscita_ctrl' src="../images/exit.gif" >
</div>
<div id='<%=idPortlet%>_Elabora'>
<img id='<%=idPortlet%>_Elabora_img' class='image Elabora_ctrl' src="../images/elaborazione.gif" >
</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_wu_conferma');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_wu_conferma',["1024"],["600"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"1024","h":"600","title":" ","layer":"false","npage":"1"}]);
this.SQLOperazioni=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_wu_conferma","cmdHash":"<%=JSPLib.cmdHash("qbe_wu_conferma",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLOperazioni","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLOperazioni","nrows":"10000","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":8,"y":-32});
this.grdOperazioni=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"true-selectAll","checkbox_fields":"WUCODICE","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdOperazioni","dataobj":"SQLOperazioni","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":479,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":" ","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":" ","name":"grdOperazioni","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":true,"print_size":"","print_title":"","print_totals":false,"recMark":" ","render_totals":" ","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"true-by-example","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":"top","w":1022,"x":1,"y":78});
this.grdOperazioni.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Progressivo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUCODICE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"MTCN","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WURIFMTCN","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUTIPOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Network","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUCODMAGE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Agenzia","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUCODDIP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUDATOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Importo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUIMPORTO","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Stato Destinazione WU","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUSTADES","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Codice Fiscale","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUCODFIS","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Cognome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUCOGCLI","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUNOMCLI","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"WUOPETYPE","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.lblTitolo=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left-right","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblTitolo","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#EFF702","font_size":"10pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblTitolo","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblTitolo,false,true)%>","type":"Label","w":1024,"x":0,"y":0,"zindex":"1"});
this.rdDest1=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"'O'","captionsList":"Operazioni,Frazionate","class_Css":"radio","create_undercond":" ","ctrlid":"<%=idPortlet%>_rdDest1","decrypt":false,"disabled":false,"edit_undercond":" ","encrypt":false,"font":"verdana","font_size":"7pt","h":43,"helptipsList":"","hide":"false","hide_undercond":" ","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"rdDest1","orientation":"vertical","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","type":"Radio","typevar":"character","valuesList":"O,F","visible":true,"w":133,"x":103,"y":26});
this.rdDest2=new ZtVWeb.RadioCtrl(this,{"anchor":"top-left","calculate":"'P'","captionsList":"Definitive,Provvisorie","class_Css":"radio","create_undercond":" ","ctrlid":"<%=idPortlet%>_rdDest2","decrypt":false,"disabled":false,"edit_undercond":" ","encrypt":false,"font":"verdana","font_size":"7pt","h":43,"helptipsList":"","hide":"false","hide_undercond":" ","init":"true","init_par":"","layer":false,"layout_steps_values":{},"name":"rdDest2","orientation":"vertical","page":1,"picture":" ","reactive":false,"server_side":"","tabindex":" ","type":"Radio","typevar":"character","valuesList":"D,P","visible":true,"w":164,"x":236,"y":26});
this.lblFlag=new ZtVWeb._LC(this,{"align":"right","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblFlag","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"bold","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblFlag","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblFlag,false,true)%>","type":"Label","w":93,"x":6,"y":40,"zindex":"1"});
this.chkOpex=new ZtVWeb.CheckboxCtrl(this,{"anchor":"top-left","calculate":"'N'","checked_value":"S","create_undercond":" ","css_class":"label","css_class_input":"checkbox","ctrlid":"<%=idPortlet%>_chkOpex","decrypt":false,"edit_undercond":" ","encrypt":false,"h":13,"hide":"false","hide_undercond":" ","init":"true","init_par":"","label_text":"","layer":false,"layout_steps_values":{},"name":"chkOpex","page":1,"reactive":false,"server_side":"","tabindex":" ","type":"Checkbox","typevar":"character","unchecked_value":"N","w":13,"x":401,"y":41});
this.lblOpex=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"chkOpex","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_lblOpex","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#000000","font_size":"7pt","font_weight":"normal","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblOpex","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblOpex,false,true)%>","type":"Label","w":151,"x":419,"y":45,"zindex":"1"});
this.BtnUscita=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-right","boundedPosition":"","class_Css":"image BtnUscita_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_BtnUscita","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"BtnUscita","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002fexit.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":973,"y":31,"zindex":"1"});
this.Elabora=new ZtVWeb._IC(this,{"alt":" ","anchor":"top-right","boundedPosition":"","class_Css":"image Elabora_ctrl","create_undercond":" ","ctrlid":"<%=idPortlet%>_Elabora","edit_undercond":"","field":" ","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue(" ",false,true)%>","hide":"false","hide_undercond":" ","href":"","img_type":"default","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Elabora","page":1,"path_type":"","server_side":"","src":"..\u002fimages\u002felaborazione.gif","srchover":"","tabindex":" ","target":"","type":"Image","type_submit":"false","w":40,"x":923,"y":31,"zindex":"1"});
this.RTUscita=new ZtVWeb.SPLinkerCtrl(this,{"action":" ","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTUscita","decrypted_parms":"","entity_type":" ","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":" ","name":"RTUscita","offline":false,"page":1,"parms":" ","popup":"false","popup_height":" ","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":" ","progressbar":false,"refresh":" ","servlet":"..\u002fjsp\u002fstart_page_logo_portlet.jsp","target":" ","type":"SPLinker","w":30,"x":69,"y":-40});
this.RTUscita.m_cID='<%=JSPLib.cmdHash("entity,../jsp/start_page_logo_portlet.jsp",request.getSession())%>';
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
<%if(request.getAttribute("pg_wu_conferma_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_wu_conferma_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_wu_conferma_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLOperazioni.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_wu_conferma',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_wu_conferma');
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
sp.endPage("pg_wu_conferma");
}%>
<%! public String getJSPUID() { return "1825239687"; } %>