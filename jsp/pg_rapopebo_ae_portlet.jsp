<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n   _cret=this.RTCHKRap.Link();\n  if (_cret!='S') {\n    this.Grid0.SetSPLinkerActions('-d-e-v-n');\n  }\n}\n\nfunction RefreshDati(_evt) {\n  this.Query1.Query()\n  this.Grid0.Refresh()\n}  \n\n\u002f\u002f this.Grid0.SetSPLinkerActions('-n')\n\n\u002f\u002f function Nuovo_Click(){\n\u002f\u002f   _cret=this.chkinfo.Link();\n\u002f\u002f   if (_cret=='S') {\n\u002f\u002f     this.japopebo_new.Link()\n\u002f\u002f   } else {\n\u002f\u002f    alert('Impossibile inserire una nuova informazione su rapporto non ancora salvato');\n\u002f\u002f   }  \n\u002f\u002f }","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"undefined","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"120","hsl":"","htmlcode":"\n{{ @label2 }}\n{{ @w_rapporto }}\n{{ @Grid0 }}\n{{ Grid0 }}\n{{ Query1 }}\n{{ w_rapporto }}\n{{ xperazbo }}\n{{ label2 }}\n{{ japopebo_new }}\n{{ RTCHKRap }}\n{{ Nuovo }}\n{{ armt_informazioni_savedEntity }}\n{{ armt_informazioni_deletedEntity }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"N° Progressivo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"NUMPROG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data Operazione\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAOPE\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Data registrazione\",\"type\":\"D\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DATAREG\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"TIPOOPRAP\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Tipo Rapporto\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"DES1\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false},{\"field\":\"IDBASE\",\"title\":\"idbase\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\",\"hidden\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"Query1","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,D,D,C,C","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"100","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_size":"","print_title":"","print_totals":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"6","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"xperazbo","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"20","zindex":""},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_ae_rapopebo_deletedEntity","objsValues":"this.RefreshDati(evt)","page":"1","parmsNames":"evt","sequence":"2","type":"EventReceiver","w":"209","x":"468","y":"43"},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"true","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"22","localDBName":"","n_records":"100","name":"Query1","offline":"false","page":"1","parms":"w_rapporto","parms_source":"","query":"qbe_viewinfo_ae","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","w":"120","x":"0","y":"-39"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"","font":"verdana","font_color":"","font_size":"7pt","h":"22","help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"attribute","layer":"false","layout_steps_values":"{}","maxlength":"","name":"w_rapporto","page":"1","password":"false","picture":"","placeholder":"","readonly":"false","scroll":"false","sequence":"4","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"false","w":"146","wireframe_props":"name","x":"134","y":"-39","zerofilling":"false","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"22","m_cAction":"","name":"xperazbo","offline":"false","page":"1","parms":"IDBASE=IDBASE,RAPPORTO=w_rapporto","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":"","refresh":"false","sequence":"5","servlet":"armt_ae_rapopebo","target":"_new","type":"SPLinker","w":"91","x":"553","y":"-39"},{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","bg_color":"#829BC6","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":"20","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label2","nowrap":"false","page":"1","picture":"","sanitize":"xssPrevent","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"INFORMAZIONI (AGE)","w":"400","wireframe_props":"align,value,n_col","x":"0","y":"0","zindex":"1"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"22","m_cAction":"new","name":"japopebo_new","offline":"false","page":"1","parms":"RAPPORTO=w_rapporto","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":"","refresh":"false","sequence":"7","servlet":"armt_ae_rapopebo","target":"_new","type":"SPLinker","w":"112","x":"430","y":"-39"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"22","m_cAction":"function","name":"RTCHKRap","offline":"false","page":"1","parms":"cRapporto=w_rapporto,pTipo=A","popup":"false","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"800","progressbar":"","refresh":"false","sequence":"8","servlet":"arrt_newinfo","target":"","type":"SPLinker","w":"93","x":"651","y":"-39"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"armt_ae_rapopebo_savedEntity","objsValues":"this.RefreshDati(evt)","page":"1","parmsNames":"evt","sequence":"10","type":"EventReceiver","w":"203","x":"682","y":"43"}]%>
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
window.pg_rapopebo_ae_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RefreshDati !='undefined')this.RefreshDati=RefreshDati;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.Query1.addRowConsumer(this.Grid0);
function this_Loaded(){
   _cret=this.RTCHKRap.Link();
  if (_cret!='S') {
    this.Grid0.SetSPLinkerActions('-d-e-v-n');
  }
}
function RefreshDati(_evt) {
  this.Query1.Query()
  this.Grid0.Refresh()
}  
// this.Grid0.SetSPLinkerActions('-n')
// function Nuovo_Click(){
//   _cret=this.chkinfo.Link();
//   if (_cret=='S') {
//     this.japopebo_new.Link()
//   } else {
//    alert('Impossibile inserire una nuova informazione su rapporto non ancora salvato');
//   }  
// }
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}

<%}else if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.pg_rapopebo_ae_container {
}
.pg_rapopebo_ae_title_container {
  margin: auto;
}
.pg_rapopebo_ae_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:400px;
  height:120px;
}
.pg_rapopebo_ae_portlet[Data-page="1"]{
  height:120px;
  width:100%;
}
.pg_rapopebo_ae_portlet > .Grid0_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:20px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:100px;
}
.pg_rapopebo_ae_portlet > .w_rapporto_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:400px;
  right:100.0%;
  width:auto;
  height:0px;
}
.pg_rapopebo_ae_portlet > .w_rapporto_ctrl {
  display:none;
}
.pg_rapopebo_ae_portlet > .w_rapporto_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  font-size:7pt;
  width:100%;
  height:100%;
}
.pg_rapopebo_ae_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:20px;
}
.pg_rapopebo_ae_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.pg_rapopebo_ae_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#829BC6;
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
 String def="[{\"h\":\"120\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left(%)-right(%)\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"N° Progressivo\"},{\"title\":\"Data Operazione\"},{\"title\":\"Data registrazione\"},{\"title\":\"Tipo\"},{\"title\":\"Tipo Rapporto\"},{\"title\":\"idbase\"}],\"h\":\"100\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"6\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"0\",\"y\":\"20\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"209\",\"x\":\"468\",\"y\":\"43\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"0\",\"y\":\"-39\"},{\"anchor\":\"\",\"h\":\"22\",\"layout_steps_values\":{},\"name\":\"w_rapporto\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"146\",\"x\":\"134\",\"y\":\"-39\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"xperazbo\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"91\",\"x\":\"553\",\"y\":\"-39\"},{\"align\":\"center\",\"anchor\":\"top-left(%)-right(%)\",\"h\":\"20\",\"layout_steps_values\":{},\"n_col\":\"1\",\"name\":\"label2\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"INFORMAZIONI (AGE)\",\"w\":\"400\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"1\"},{\"h\":\"22\",\"name\":\"japopebo_new\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"112\",\"x\":\"430\",\"y\":\"-39\"},{\"h\":\"22\",\"name\":\"RTCHKRap\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"93\",\"x\":\"651\",\"y\":\"-39\"},{\"h\":\"20\",\"name\":\"armt_ae_rapopebo_savedEntity\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"203\",\"x\":\"682\",\"y\":\"43\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_rapopebo_ae","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_rapopebo_ae_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_rapopebo_ae','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("pg_rapopebo_ae_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String w_rapporto=JSPLib.translateXSS(Library.getAttribute(request,"w_rapporto",""));
if(request.getAttribute("pg_rapopebo_ae_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String label2= "INFORMAZIONI (AGE)";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_rapopebo_ae_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_rapopebo_ae_portlet undefined' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_rapopebo_ae','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid0' formid='<%=idPortlet%>' ps-name='Grid0'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_w_rapporto_wrp'><input id='<%=idPortlet%>_w_rapporto' name='w_rapporto' type='hidden' class='textbox' formid='<%=idPortlet%>' ps-name='w_rapporto' /></span>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("INFORMAZIONI (AGE)")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_rapopebo_ae');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_rapopebo_ae',["400"],["120"],'undefined',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"120","title":"","layer":"false","npage":"1"}]);
this.Grid0=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid0","dataobj":"Query1","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":100,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"true","name":"Grid0","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"xperazbo","splinker_pos":"left","spuid":"","title_color":"","type":"Grid","valign":"","w":400,"x":0,"y":20,"zindex":""});
this.Grid0.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":6,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"N° Progressivo","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"NUMPROG","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data Operazione","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAOPE","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Data registrazione","type":"D","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DATAREG","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"TIPOOPRAP","fg_color":"","width":"","RowSpan":0,"extensible":false},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Tipo Rapporto","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"DES1","fg_color":"","width":"","RowSpan":0,"extensible":false},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"idbase","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"IDBASE","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.armt_ae_rapopebo_deletedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_ae_rapopebo_deletedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_ae_rapopebo_deletedEntity","objsValues":"this.RefreshDati(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":209,"x":468,"y":43});
this.Query1=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_viewinfo_ae","cmdHash":"<%=JSPLib.cmdHash("qbe_viewinfo_ae",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_Query1","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":22,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"Query1","nrows":"100","page":1,"parms":"w_rapporto","parms_source":"","type":"SQLDataobj","w":120,"x":0,"y":-39});
this.w_rapporto=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_w_rapporto","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":false,"h":0,"help_tips":"","hide":"false","hide_undercond":"","init":"","init_par":"attribute","layer":false,"layout_steps_values":{},"maxlength":"","name":"w_rapporto","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(w_rapporto,false,true)%>","w":0,"x":0,"y":0,"zerofilling":false,"zindex":"1","zoom":""});
this.xperazbo=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_xperazbo","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"xperazbo","offline":false,"page":1,"parms":"IDBASE=IDBASE,RAPPORTO=w_rapporto","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_ae_rapopebo","target":"_new","type":"SPLinker","w":91,"x":553,"y":-39});
this.xperazbo.m_cID='<%=JSPLib.cmdHash("entity,armt_ae_rapopebo",request.getSession())%>';
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left(%)-right(%)","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label2","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":1,"picture":"","sanitize":"xssPrevent","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":400,"x":0,"y":0,"zindex":"1"});
this.japopebo_new=new ZtVWeb.SPLinkerCtrl(this,{"action":"new","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_japopebo_new","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"japopebo_new","offline":false,"page":1,"parms":"RAPPORTO=w_rapporto","popup":"true","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"800","progressbar":false,"refresh":"false","servlet":"armt_ae_rapopebo","target":"_new","type":"SPLinker","w":112,"x":430,"y":-39});
this.japopebo_new.m_cID='<%=JSPLib.cmdHash("entity,armt_ae_rapopebo",request.getSession())%>';
this.RTCHKRap=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCHKRap","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":22,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCHKRap","offline":false,"page":1,"parms":"cRapporto=w_rapporto,pTipo=A","popup":"false","popup_height":"600","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"800","progressbar":false,"refresh":"false","servlet":"arrt_newinfo","target":"","type":"SPLinker","w":93,"x":651,"y":-39});
this.RTCHKRap.m_cID='<%=JSPLib.cmdHash("routine,arrt_newinfo",request.getSession())%>';
this.armt_ae_rapopebo_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_armt_ae_rapopebo_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"armt_ae_rapopebo_savedEntity","objsValues":"this.RefreshDati(evt)","page":1,"parmsNames":"evt","type":"EventReceiver","w":203,"x":682,"y":43});
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
<%if(request.getAttribute("pg_rapopebo_ae_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_rapopebo_ae_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_rapopebo_ae_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_armt_ae_rapopebo_deletedEntity=function(parmsObj){<%=idPortlet%>.armt_ae_rapopebo_deletedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.on_armt_ae_rapopebo_savedEntity=function(parmsObj){<%=idPortlet%>.armt_ae_rapopebo_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.Query1.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_rapopebo_ae',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_rapopebo_ae');
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
sp.endPage("pg_rapopebo_ae");
}%>
<%! public String getJSPUID() { return "46410779"; } %>