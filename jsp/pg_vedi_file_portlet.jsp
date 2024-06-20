<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle('Ricerca file',true);\n\nfunction Button_esegui_Click(){\n  this.SQLDataobj_fn_fileread.Query()\n}\n\nfunction SQLDataobj_fn_fileread_ConsumersRendered(){\n  this.getTitlePortlet().SetSubTitle('N.: '+this.SQLDataobj_fn_fileread.GetQueryCount(),true)\n}","adaptive":"adaptive","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#F3F3F3","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"","form_target":"","form_type":"false","h":"350","hsl":"","htmlcode":"{{ gPathApp }}{{ dir }}{{ level }}{{ estenzione }}{{ fileName }}{{ SQLDataobj_fn_fileread }}{{ StdTreeView6 }}{{ Grid_fn_fileread }}{{ Button_esegui }}{{ filtro_old }}{{ filtro }}","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"200","version":"37","w":"100%","wizard":""},{"calculate":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gPathApp","page":"1","reactive":"","sequence":"1","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"236","y":"-23"},{"anchor":"","autocapitalize":"on","autocomplete":"on","autofocus":"","calculate":"this.gPathApp.Value()","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"Digitare la cartella di partenza","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"dir","page":"1","password":"","picture":"","placeholder":"Cartella di partenza","readonly":"false","scroll":"false","sequence":"2","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"100","wireframe_props":"name","x":"50","y":"19","zerofilling":"false","zindex":"2"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"-1","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"Definisce di quante sottocartelle si deve scendere (-1 tutte)","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"level","page":"1","password":"","picture":"","placeholder":"livello delle sottocartelle(-1 tutte)","readonly":"false","scroll":"false","sequence":"3","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"numeric","visible":"true","w":"100","wireframe_props":"name","x":"50","y":"60","zerofilling":"false","zindex":"3"},{"anchor":"","calculate":"'A'","class_Css":"combobox","create_undercond":"","dataobj":"","dataobj_value":"","disabled":"false","edit_undercond":"","empty_value":"false","field":"","font":"","font_size":"","h":"20","help_tips":"Tipo di dati ritornati (F lista dei file, D lista delle cartelle, A tutto)","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":"false","layout_steps_values":"{}","name":"filtro","page":"1","picture":"","sequence":"4","spuid":"","tabindex":"","textlist":"Lista dei file,Lista delle cartelle,Tutto","type":"Combobox","typevar":"character","valuelist":"F,D,A","visible":"true","w":"100","wireframe_props":"name,textlist","x":"50","y":"99","zindex":"10"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"Eventuale estensione (non necessaria)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"estenzione","page":"1","password":"","picture":"","placeholder":"estensione del file (non necessaria)","readonly":"false","scroll":"false","sequence":"5","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"100","wireframe_props":"name","x":"50","y":"140","zerofilling":"false","zindex":"4"},{"anchor":"","autocapitalize":"on","autocomplete":"","autofocus":"","calculate":"","class_Css":"textbox","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","field":"","floating_placeholder":"true","font":"","font_color":"","font_size":"","h":"20","help_tips":"Nome del file con esenzione (non necessario)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":"false","layout_steps_values":"{}","maxlength":"","name":"fileName","page":"1","password":"","picture":"","placeholder":"Nome del file con esenzione (non necessario)","readonly":"false","scroll":"false","sequence":"6","spuid":"","tabindex":"","type":"Textbox","typehtml5":"","typevar":"character","visible":"true","w":"100","wireframe_props":"name","x":"50","y":"180","zerofilling":"false","zindex":"5"},{"anchor":"","bg_color":"","border_color":"","border_weight":"","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"25","help_tips":"","hide":"false","hide_undercond":"","layer":"false","layout_steps_values":"{}","name":"Button_esegui","page":"1","sequence":"7","spuid":"","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"Esegui","w":"50","wireframe_props":"value","x":"75","y":"200","zindex":"8"},{"allowedqueries":"rows:fn_fileread","appendingData":"false","auto_exec":"false","clientDB":"","count":"true","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"25","name":"SQLDataobj_fn_fileread","offline":"false","page":"1","parms":"dir,level,estenzione,fileName,filtro","parms_source":"","query":"rows:fn_fileread","query_async":"true","return_fields_type":"true","sequence":"8","type":"SQLDataobj","w":"159","x":"238","y":"15"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"title\":\"Path\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"title_align\":\"\",\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"field\":\"Path\",\"type\":\"C\"},{\"title\":\"File\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"fixedwidth\":\"\",\"height\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"title_align\":\"\",\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"field\":\"File\",\"type\":\"C\"},{\"field\":\"checkbox:Directory\",\"title\":\"Directory\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"center\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"center\"},{\"field\":\"Directory\",\"title\":\"Directory\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"L\",\"title_align\":\"\",\"hidden\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"SQLDataobj_fn_fileread","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"false","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"124","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_fn_fileread","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_title":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"25","scroll_bars":"false","sequence":"9","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"200","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"225","zindex":"7"}]%>
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
window.pg_vedi_file_Static=function(){
if(typeof Button_esegui_Click !='undefined')this.Button_esegui_Click=Button_esegui_Click;
if(typeof SQLDataobj_fn_fileread_ConsumersRendered !='undefined')this.SQLDataobj_fn_fileread_ConsumersRendered=SQLDataobj_fn_fileread_ConsumersRendered;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
ZtVWeb.InitCtrl(this.gPathApp.Value(),this.dir);
ZtVWeb.InitCtrl(-1,this.level);
ZtVWeb.InitCtrl('A',this.filtro);
this.SQLDataobj_fn_fileread.addRowConsumer(this.Grid_fn_fileread);
this.getTitlePortlet().SetTitle('Ricerca file',true);
function Button_esegui_Click(){
  this.SQLDataobj_fn_fileread.Query()
}
function SQLDataobj_fn_fileread_ConsumersRendered(){
  this.getTitlePortlet().SetSubTitle('N.: '+this.SQLDataobj_fn_fileread.GetQueryCount(),true)
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
.pg_vedi_file_container {
}
.pg_vedi_file_title_container {
  margin: auto;
}
.pg_vedi_file_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:200px;
  height:350px;
  background-color:#F3F3F3;
}
.pg_vedi_file_portlet[Data-page="1"]{
  height:350px;
  width:100%;
}
.pg_vedi_file_portlet > .dir_ctrl {
  box-sizing:border-box;
  z-index:2;
  position:absolute;
  display:inline-block;
  top:19px;
  left:50px;
  left:25.0%;
  right:50px;
  right:25.0%;
  width:auto;
  height:20px;
}
.pg_vedi_file_portlet > .dir_ctrl {
}
.pg_vedi_file_portlet > .dir_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_vedi_file_portlet > .level_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:60px;
  left:50px;
  left:25.0%;
  right:50px;
  right:25.0%;
  width:auto;
  height:20px;
}
.pg_vedi_file_portlet > .level_ctrl {
}
.pg_vedi_file_portlet > .level_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_vedi_file_portlet > .filtro_ctrl {
  box-sizing:border-box;
  z-index:10;
  position:absolute;
  display:inline-block;
  top:99px;
  left:50px;
  left:25.0%;
  right:50px;
  right:25.0%;
  width:auto;
  height:20px;
}
.pg_vedi_file_portlet > .estenzione_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:140px;
  left:50px;
  left:25.0%;
  right:50px;
  right:25.0%;
  width:auto;
  height:20px;
}
.pg_vedi_file_portlet > .estenzione_ctrl {
}
.pg_vedi_file_portlet > .estenzione_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_vedi_file_portlet > .fileName_ctrl {
  box-sizing:border-box;
  z-index:5;
  position:absolute;
  display:inline-block;
  top:180px;
  left:50px;
  left:25.0%;
  right:50px;
  right:25.0%;
  width:auto;
  height:20px;
}
.pg_vedi_file_portlet > .fileName_ctrl {
}
.pg_vedi_file_portlet > .fileName_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  width:100%;
  height:100%;
}
.pg_vedi_file_portlet > .Button_esegui_ctrl {
  box-sizing:border-box;
  z-index:8;
  position:absolute;
  display:inline-block;
  top:200px;
  left:75px;
  left:37.5%;
  right:75px;
  right:37.5%;
  width:auto;
  height:25px;
}
.pg_vedi_file_portlet > .Button_esegui_ctrl {
}
.pg_vedi_file_portlet > .Grid_fn_fileread_ctrl {
  box-sizing:border-box;
  z-index:7;
  position:absolute;
  display:inline-block;
  top:225px;
  left:0px;
  left:0.0%;
  right:0px;
  right:0.0%;
  width:auto;
  height:auto;
  min-height:124px;
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
 String def="[{\"h\":\"350\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"200\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"236\",\"y\":\"-23\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"dir\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"100\",\"x\":\"50\",\"y\":\"19\",\"zindex\":\"2\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"level\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"100\",\"x\":\"50\",\"y\":\"60\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"filtro\",\"page\":\"1\",\"textlist\":\"Lista dei file,Lista delle cartelle,Tutto\",\"type\":\"Combobox\",\"w\":\"100\",\"x\":\"50\",\"y\":\"99\",\"zindex\":\"10\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"estenzione\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"100\",\"x\":\"50\",\"y\":\"140\",\"zindex\":\"4\"},{\"anchor\":\"\",\"h\":\"20\",\"layout_steps_values\":{},\"name\":\"fileName\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"100\",\"x\":\"50\",\"y\":\"180\",\"zindex\":\"5\"},{\"anchor\":\"\",\"h\":\"25\",\"layout_steps_values\":{},\"name\":\"Button_esegui\",\"page\":\"1\",\"type\":\"Button\",\"value\":\"Esegui\",\"w\":\"50\",\"x\":\"75\",\"y\":\"200\",\"zindex\":\"8\"},{\"h\":\"20\",\"name\":\"SQLDataobj_fn_fileread\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"159\",\"x\":\"238\",\"y\":\"15\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Path\"},{\"title\":\"File\"},{\"title\":\"Directory\"},{\"title\":\"Directory\"}],\"h\":\"124\",\"layout_steps_values\":{},\"name\":\"Grid_fn_fileread\",\"page\":\"1\",\"rows\":\"25\",\"type\":\"Grid\",\"w\":\"200\",\"x\":\"0\",\"y\":\"225\",\"zindex\":\"7\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_vedi_file","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_vedi_file_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_vedi_file','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String gPathApp=sp.getGlobal("gPathApp","");
String dir= "";
if(request.getAttribute("pg_vedi_file_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
double level= 0;
String filtro= "";
String estenzione= "";
String fileName= "";
if(request.getAttribute("pg_vedi_file_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='pg_vedi_file_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='pg_vedi_file_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_vedi_file_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_vedi_file','<%=idPortlet%>',false,'');
</script><%}}%>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_dir_wrp'><input id='<%=idPortlet%>_dir' name='dir' type='text' class='textbox' formid='<%=idPortlet%>' autocomplete='on' ps-name='dir' placeholder=' '/>
<label for=<%=idPortlet%>_dir>Cartella di partenza</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_level_wrp'><input id='<%=idPortlet%>_level' name='level' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='level' inputmode='numeric' placeholder=' '/>
<label for=<%=idPortlet%>_level>livello delle sottocartelle(-1 tutte)</label></span>
<select id='<%=idPortlet%>_filtro' name='filtro' class='combobox' title=<%=JSPLib.ToHTMLValue("Tipo di dati ritornati (F lista dei file, D lista delle cartelle, A tutto)" )%> style=''></select>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_estenzione_wrp'><input id='<%=idPortlet%>_estenzione' name='estenzione' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='estenzione' placeholder=' '/>
<label for=<%=idPortlet%>_estenzione>estensione del file (non necessaria)</label></span>
<span class='textbox-container floating-placeholder'id='<%=idPortlet%>_fileName_wrp'><input id='<%=idPortlet%>_fileName' name='fileName' type='text' class='textbox' formid='<%=idPortlet%>' ps-name='fileName' placeholder=' '/>
<label for=<%=idPortlet%>_fileName>Nome del file con esenzione (non necessario)</label></span>
<input id='<%=idPortlet%>_Button_esegui' type='button' class='button Button_esegui_ctrl'/>
<div id='<%=idPortlet%>_Grid_fn_fileread' formid='<%=idPortlet%>' ps-name='Grid_fn_fileread'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_vedi_file');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_vedi_file',["200"],["350"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', 'adaptive','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"200","h":"350","title":"","layer":"false","npage":"1"}]);
this.gPathApp=new ZtVWeb._VC(this,'gPathApp',null,'character','<%=JSPLib.ToJSValue(gPathApp,false,true)%>',false,false);
this.dir=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"on","calculate":"this.gPathApp.Value()","create_undercond":"","ctrlid":"<%=idPortlet%>_dir","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"Digitare la cartella di partenza","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"dir","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(dir,false,true)%>","w":100,"x":50,"y":19,"zerofilling":false,"zindex":"2","zoom":""});
this.level=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"-1","create_undercond":"","ctrlid":"<%=idPortlet%>_level","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"Definisce di quante sottocartelle si deve scendere (-1 tutte)","hide":"false","hide_undercond":"","init":"true","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"level","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"numeric","value":"<%=level%>","w":100,"x":50,"y":60,"zerofilling":false,"zindex":"3","zoom":""});
this.filtro=new ZtVWeb.ComboboxCtrl(this,{"anchor":"top-left(%)-right(%)","calculate":"'A'","class_Css":"combobox","create_undercond":"","ctrlid":"<%=idPortlet%>_filtro","dataobj_value":"","decrypt":false,"disabled":false,"edit_undercond":"","empty_value":false,"encrypt":false,"field":"","font":"","font_size":"","h":20,"help_tips":"Tipo di dati ritornati (F lista dei file, D lista delle cartelle, A tutto)","hide":"false","hide_undercond":"","init":"true","init_par":"<%=filtro%>","isdatap":false,"layer":false,"layout_steps_values":{},"name":"filtro","page":1,"picture":"","reactive":false,"server_side":"","spuid":"","tabindex":"","textlist":"Lista dei file,Lista delle cartelle,Tutto","type":"Combobox","typevar":"character","valuelist":"F,D,A","visible":true,"w":100,"x":50,"y":99,"zindex":"10"});
this.estenzione=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_estenzione","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"Eventuale estensione (non necessaria)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"estenzione","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(estenzione,false,true)%>","w":100,"x":50,"y":140,"zerofilling":false,"zindex":"4","zoom":""});
this.fileName=new ZtVWeb._TC(this,{"anchor":"top-left(%)-right(%)","autocomplete":"","calculate":"","create_undercond":"","ctrlid":"<%=idPortlet%>_fileName","decrypt":false,"edit_undercond":"","encrypt":false,"field":"","fixed":"false","floating_placeholder":true,"h":20,"help_tips":"Nome del file con esenzione (non necessario)","hide":"false","hide_undercond":"","init":"","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"fileName","page":1,"picker":"","picture":"","reactive":false,"readonly":"false","server_side":"","spuid":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(fileName,false,true)%>","w":100,"x":50,"y":180,"zerofilling":false,"zindex":"5","zoom":""});
this.Button_esegui=new ZtVWeb._BC(this,{"anchor":"top-left(%)-right(%)","bg_color":"","border_color":"","border_weight":"","class_Css":"button Button_esegui_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Button_esegui","edit_undercond":"","font":"","font_color":"","font_size":"","h":25,"help_tips":"","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"Button_esegui","page":1,"spuid":"","tabindex":"","text":"Esegui","type":"Button","type_submit":"false","type_wizard":"","w":50,"x":75,"y":200,"zindex":"8"});
this.SQLDataobj_fn_fileread=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("rows:fn_fileread",request,"xxxx")%>","anchor":"","appendingData":false,"async":true,"auto_exec":"false","cmd":"rows:fn_fileread","cmdHash":"<%=JSPLib.cmdHash("rows:fn_fileread",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_SQLDataobj_fn_fileread","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLDataobj_fn_fileread","nrows":"25","page":1,"parms":"dir,level,estenzione,fileName,filtro","parms_source":"","type":"SQLDataobj","w":159,"x":238,"y":15});
this.Grid_fn_fileread=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left(%)-right(%)","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_fn_fileread","dataobj":"SQLDataobj_fn_fileread","disabled_fld":"","empty_rows":"false","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":124,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_fn_fileread","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":200,"x":0,"y":225,"zindex":"7"});
this.Grid_fn_fileread.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":25,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Path","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","droppable_name":"","field":"Path","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"File","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","droppable_name":"","field":"File","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Directory","align":"center","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"center","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"checkbox:Directory","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","hidden":true,"col_class":"","font_size":"","link":"","fixedwidth":"","title":"Directory","align":"","type":"L","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"Directory","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
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
<%if(request.getAttribute("pg_vedi_file_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_vedi_file_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_vedi_file_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.filtro.FillData();
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_vedi_file',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_vedi_file');
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
sp.endPage("pg_vedi_file");
}%>
<%! public String getJSPUID() { return "1441866062"; } %>