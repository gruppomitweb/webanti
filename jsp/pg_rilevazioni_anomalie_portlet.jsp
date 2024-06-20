<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  if(Empty(this.status.Value())){\n    this.Image5.Hide()\n  } else {  \n    this.Image5.Show()\n  }  \n}\n\nfunction Image5_Click(){\n  if(confirm(\"Confermi di voler inserire una nuova rilevazione?\")) {\n    this.Rilevazione.Link()\n  }   \n}\n\nfunction Aggiorna(evt) {\n  this.SQLRilevazioni.Query()\n}  \n\nfunction Cancella() {\n  if(confirm(\"Confermi la cancellazione della rilevazione?\")) {\n    this.DelRilevazione.Link()    \n  }     \n}  \n\nfunction DelRilevazione_Executed(result,cError){\n  this.SQLRilevazioni.Query()\n}\n\nfunction Calculate(val1,val2) {\n if(Empty(val2)){\n   this.Image5.Hide()\n } else {  \n   this.Image5.Show()\n }  \n}  ","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"450","hsl":"","htmlcode":" \n{{ @Image5 }} \n \n \n{{ @Grid2 }} \n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"900","wizard":""},{"allowedqueries":"qbe_rilevazioni_anomalie","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"15","name":"SQLRilevazioni","offline":"false","page":"1","parms":"pCONNES=connes","parms_source":"","query":"qbe_rilevazioni_anomalie","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"924","y":"-17"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"connes","page":"1","reactive":"","sequence":"2","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"926","y":"9"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"DTRIL\",\"title\":\"Data rilevazione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"SPLink:ModRilevazione\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"D\",\"title_align\":\"\"},{\"field\":\"IDMOD\",\"title\":\"ID del modello\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"DESCRI\",\"title\":\"Descrizione\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"},{\"field\":\"CANCELLA\",\"title\":\"Cancella\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"#F80303\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"height\":\"\",\"fixedwidth\":\"2%\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"function:Cancella()\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"title_align\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQLRilevazioni","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"368","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid2","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"true","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"3","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"900","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"39","zindex":"3"},{"alt":"Nuovo","anchor":"","bounded_position":"","class_Css":"image-default","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe912;","font_image_hover":"&#xe913;","font_name":"ZucchettiDevelopement","font_size":"","h":"30","help_tips":"Inserire una nuova rilevazione","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keep_proportions":"false","layer":"false","layout_steps_values":"{}","name":"Image5","page":"1","path_type":"","sequence":"4","server_side":"","spuid":"","src":"","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"36","wireframe_props":"","x":"859","y":"5","zindex":"4"},{"allowedentities":"aosdt_rilevazioni","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"detail","h":"20","m_cAction":"new","name":"Rilevazione","offline":"false","page":"1","parms":"CONNES=connes","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"aosdt_rilevazioni","target":"","type":"SPLinker","w":"120","x":"929","y":"36"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"20","included":"false","name":"aosdt_rilevazioni_savedEntity","objsValues":"this.Aggiorna(evt)","page":"1","parmsNames":"","sequence":"6","type":"EventReceiver","w":"120","x":"924","y":"171"},{"allowedentities":"aosdt_rilevazioni","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"detail","h":"20","m_cAction":"edit","name":"ModRilevazione","offline":"false","page":"1","parms":"CONNES=connes,DTRIL=dtril,IDMOD=idmod","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"7","servlet":"aosdt_rilevazioni","target":"","type":"SPLinker","w":"120","x":"925","y":"61"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLRilevazioni","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"IDMOD","h":"20","init":"","init_par":"","name":"idmod","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"927","y":"197"},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLRilevazioni","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"DTRIL","h":"20","init":"","init_par":"","name":"dtril","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"date","w":"120","x":"929","y":"220"},{"allowedentities":"aosrt_salva_rilevazioni","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"20","m_cAction":"function","name":"DelRilevazione","offline":"false","page":"1","parms":"pConnes=connes,pData=dtril,pModello=idmod,pTipo=D","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"10","servlet":"aosrt_salva_rilevazioni","target":"","type":"SPLinker","w":"120","x":"927","y":"82"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"request","name":"status","page":"1","reactive":"","sequence":"11","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"928","y":"107"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:connes,status*/%>
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
window.pg_rilevazioni_anomalie_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Image5_Click !='undefined')this.Image5_Click=Image5_Click;
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof Cancella !='undefined')this.Cancella=Cancella;
if(typeof DelRilevazione_Executed !='undefined')this.DelRilevazione_Executed=DelRilevazione_Executed;
if(typeof Calculate !='undefined')this.Calculate=Calculate;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLRilevazioni.addRowConsumer(this.Grid2);
this.SQLRilevazioni.addDataConsumer(this.idmod,<%=JSPLib.ToJSValue("IDMOD",true)%>);
this.SQLRilevazioni.addDataConsumer(this.dtril,<%=JSPLib.ToJSValue("DTRIL",true)%>);
function this_Loaded(){
  if(Empty(this.status.Value())){
    this.Image5.Hide()
  } else {  
    this.Image5.Show()
  }  
}
function Image5_Click(){
  if(confirm("Confermi di voler inserire una nuova rilevazione?")) {
    this.Rilevazione.Link()
  }   
}
function Aggiorna(evt) {
  this.SQLRilevazioni.Query()
}  
function Cancella() {
  if(confirm("Confermi la cancellazione della rilevazione?")) {
    this.DelRilevazione.Link()    
  }     
}  
function DelRilevazione_Executed(result,cError){
  this.SQLRilevazioni.Query()
}
function Calculate(val1,val2) {
 if(Empty(val2)){
   this.Image5.Hide()
 } else {  
   this.Image5.Show()
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
.pg_rilevazioni_anomalie_container {
}
.pg_rilevazioni_anomalie_title_container {
  margin: auto;
}
.pg_rilevazioni_anomalie_portlet{
  position:relative;
  margin: auto;
  width:900px;
  min-width:900px;
  height:450px;
}
.pg_rilevazioni_anomalie_portlet[Data-page="1"]{
  height:450px;
  width:900px;
}
.pg_rilevazioni_anomalie_portlet > .Grid2_ctrl {
  box-sizing:border-box;
  z-index:3;
  position:absolute;
  display:inline-block;
  top:39px;
  left:0px;
  width:900px;
  height:auto;
  min-height:368px;
}
.pg_rilevazioni_anomalie_portlet > .Image5_ctrl {
  box-sizing:border-box;
  z-index:4;
  position:absolute;
  display:inline-block;
  top:5px;
  left:859px;
  width:36px;
  height:30px;
}
.pg_rilevazioni_anomalie_portlet > .Image5_ctrl {
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
 String def="[{\"h\":\"450\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"900\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"924\",\"y\":\"-17\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"926\",\"y\":\"9\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Data rilevazione\"},{\"title\":\"ID del modello\"},{\"title\":\"Descrizione\"},{\"title\":\"Cancella\"}],\"h\":\"368\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"900\",\"x\":\"0\",\"y\":\"39\",\"zindex\":\"3\"},{\"anchor\":\"\",\"h\":\"30\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"36\",\"x\":\"859\",\"y\":\"5\",\"zindex\":\"4\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"929\",\"y\":\"36\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"120\",\"x\":\"924\",\"y\":\"171\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"925\",\"y\":\"61\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"927\",\"y\":\"197\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"929\",\"y\":\"220\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"120\",\"x\":\"927\",\"y\":\"82\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"928\",\"y\":\"107\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"pg_rilevazioni_anomalie","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/pg_rilevazioni_anomalie_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','pg_rilevazioni_anomalie','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String connes=JSPLib.translateXSS(sp.getParameter("connes",""));
if(request.getAttribute("pg_rilevazioni_anomalie_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String idmod= "";
java.sql.Date dtril= JSPLib.NullDate();
String status=JSPLib.translateXSS(sp.getParameter("status",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='pg_rilevazioni_anomalie_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='pg_rilevazioni_anomalie_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('pg_rilevazioni_anomalie','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid2' formid='<%=idPortlet%>' ps-name='Grid2'   class='grid' style=''>&nbsp;</div>
<a id='<%=idPortlet%>_Image5' class='image-default Image5_ctrl'   target=''>&#xe912;</a>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','pg_rilevazioni_anomalie');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','pg_rilevazioni_anomalie',["900"],["450"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"900","h":"450","title":"","layer":"false","npage":"1"}]);
this.SQLRilevazioni=new ZtVWeb._SQP(this,{"allowedcmds":"<%=JSPLib.encrypt("qbe_rilevazioni_anomalie",request,"xxxx")%>","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_rilevazioni_anomalie","cmdHash":"<%=JSPLib.cmdHash("qbe_rilevazioni_anomalie",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLRilevazioni","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLRilevazioni","nrows":"15","page":1,"parms":"pCONNES=connes","parms_source":"","type":"SQLDataobj","w":120,"x":924,"y":-17});
this.connes=new ZtVWeb._VC(this,'connes',null,'character','<%=JSPLib.ToJSValue(connes,false,true)%>',false,false);
this.Grid2=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid2","dataobj":"SQLRilevazioni","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":368,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid2","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"true","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":900,"x":0,"y":39,"zindex":"3"});
this.Grid2.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"SPLink:ModRilevazione","fixedwidth":"","title":"Data rilevazione","align":"","type":"D","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DTRIL","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"ID del modello","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"IDMOD","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","title":"Descrizione","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"DESCRI","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"2%","title":"Cancella","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":false,"onclick":"function:Cancella()","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"CANCELLA","droppable_name":"","fg_color":"#F80303","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"}]});
this.Image5=new ZtVWeb._IC(this,{"alt":"Nuovo","anchor":"top-left","boundedPosition":"","class_Css":"image-default Image5_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_Image5","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"&#xe912;","font_image_hover":"&#xe913;","font_name":"ZucchettiDevelopement","font_path":"","font_size":"","h":30,"help_tips":"<%=JSPLib.ToJSValue("Inserire una nuova rilevazione",false,true)%>","hide":"false","hide_undercond":"","href":"","img_type":"font icon","keepProportions":"false","layer":false,"layout_steps_values":{},"name":"Image5","page":1,"path_type":"","server_side":"","spuid":"","src":"&#xe912;","srchover":"&#xe913;","tabindex":"","target":"","type":"Image","type_submit":"false","w":36,"x":859,"y":5,"zindex":"4"});
 ZtVWeb.RequireFont("ZucchettiDevelopement","");
this.Rilevazione=new ZtVWeb.SPLinkerCtrl(this,{"action":"new","allowedEntities":"<%=JSPLib.encrypt("aosdt_rilevazioni",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_Rilevazione","decrypted_parms":"","entity_type":"detail","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"Rilevazione","offline":false,"page":1,"parms":"CONNES=connes","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"aosdt_rilevazioni","target":"","type":"SPLinker","w":120,"x":929,"y":36});
this.Rilevazione.m_cID='<%=JSPLib.cmdHash("entity,aosdt_rilevazioni",request.getSession())%>';
this.aosdt_rilevazioni_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_aosdt_rilevazioni_savedEntity","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"aosdt_rilevazioni_savedEntity","objsValues":"this.Aggiorna(evt)","page":1,"parmsNames":"","type":"EventReceiver","w":120,"x":924,"y":171});
this.ModRilevazione=new ZtVWeb.SPLinkerCtrl(this,{"action":"edit","allowedEntities":"<%=JSPLib.encrypt("aosdt_rilevazioni",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_ModRilevazione","decrypted_parms":"","entity_type":"detail","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"ModRilevazione","offline":false,"page":1,"parms":"CONNES=connes,DTRIL=dtril,IDMOD=idmod","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"aosdt_rilevazioni","target":"","type":"SPLinker","w":120,"x":925,"y":61});
this.ModRilevazione.m_cID='<%=JSPLib.cmdHash("entity,aosdt_rilevazioni",request.getSession())%>';
this.idmod=new ZtVWeb._VC(this,'idmod',null,'character','<%=JSPLib.ToJSValue(idmod,false,true)%>',false,false);
this.dtril=new ZtVWeb._VC(this,'dtril',null,'date','<%=dtril%>',false,false);
this.DelRilevazione=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("aosrt_salva_rilevazioni",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_DelRilevazione","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"DelRilevazione","offline":false,"page":1,"parms":"pConnes=connes,pData=dtril,pModello=idmod,pTipo=D","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"aosrt_salva_rilevazioni","target":"","type":"SPLinker","w":120,"x":927,"y":82});
this.DelRilevazione.m_cID='<%=JSPLib.cmdHash("routine,aosrt_salva_rilevazioni",request.getSession())%>';
this.status=new ZtVWeb._VC(this,'status',null,'character','<%=JSPLib.ToJSValue(status,false,true)%>',false,false);
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
<%if(request.getAttribute("pg_rilevazioni_anomalie_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("pg_rilevazioni_anomalie_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.pg_rilevazioni_anomalie_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.Image5.dispatchEvent('OnLoad');
window.<%=idPortlet%>.on_aosdt_rilevazioni_savedEntity=function(parmsObj){<%=idPortlet%>.aosdt_rilevazioni_savedEntity.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SQLRilevazioni.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','pg_rilevazioni_anomalie',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'pg_rilevazioni_anomalie');
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
sp.endPage("pg_rilevazioni_anomalie");
}%>
<%! public String getJSPUID() { return "1328297162"; } %>