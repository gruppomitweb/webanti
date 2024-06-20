<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"this.getTitlePortlet().SetTitle(\"Elenco File da Inviare (AGE)\",true)\n\nfunction Scarica(){\n  this.RTCopia.Link()\n}  \n\nfunction RTCopia_Result(result){\n  if(result=='OK') {\n    this.downloadURI('..\u002fappo\u002f'+this.gAzienda.Value()+\"\u002f\"+this.filename.Value(),this.filename.Value())\n  } else {\n    alert(\"Non ci sono file da prelevare\")\n  }  \n}\n\nfunction downloadURI(uri, name) {\n  var link = document.createElement(\"a\");\n  link.download = name;\n  link.href = uri;\n  document.body.appendChild(link);\n  link.click();\n  document.body.removeChild(link);\n  delete link;\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#C0C0C0","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"472","hsl":"","htmlcode":"\n{{ @ListaFile }}\n","htmlmode":"false","included_font":"[]","language":"false","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"","version":"37","w":"756","wizard":""},{"allowedqueries":"","appendingData":"false","auto_exec":"true","clientDB":"","count":"false","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","encrypted_fields":"","encrypted_fields_pwd":"","h":"20","localDBName":"","n_records":"50","name":"SQLListImp","offline":"false","page":"1","parms":"","parms_source":"","query":"qbe_listsid","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"120","x":"914","y":"29"},{"allowedentities":"arfn_copy_file_appo","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"30","m_cAction":"function","name":"RTCopia","offline":"false","page":"1","parms":"pNomeFile=filename,pCartella=flussi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"2","servlet":"arfn_copy_file_appo","target":"","type":"SPLinker","w":"127","x":"915","y":"-13"},{"align":"left","anchor":"","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":true,\"onclick\":\"\",\"link\":\"function:Scarica()\",\"weight\":\"\",\"title\":\"Nome file prodotti\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"nomefile\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false,\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\",\"height\":\"\",\"sanitize\":\"xssPrevent\",\"sanitize_tags\":\"\"},{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Seq.\",\"type\":\"N\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"priorita\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SQLListImp","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,N","filters":"false","floatRows":"false","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"416","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"ListaFile","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_hideexport":"","print_hidesettings":"","print_option":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"true","sequence":"3","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":"756","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":""},{"calculate":"","ctrlOfVariant":"","dataobj":"SQLListImp","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"nomefile","h":"20","init":"","init_par":"","name":"filename","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"917","y":"-73"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"global string","name":"gAzienda","page":"1","reactive":"","sequence":"5","server_side":"false","type":"Variable","typevar":"character","w":"149","x":"924","y":"-47"}]%>
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
window.list_filesid_Static=function(){
if(typeof Scarica !='undefined')this.Scarica=Scarica;
if(typeof RTCopia_Result !='undefined')this.RTCopia_Result=RTCopia_Result;
if(typeof downloadURI !='undefined')this.downloadURI=downloadURI;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLListImp.addRowConsumer(this.ListaFile);
this.SQLListImp.addDataConsumer(this.filename,<%=JSPLib.ToJSValue("nomefile",true)%>);
this.getTitlePortlet().SetTitle("Elenco File da Inviare (AGE)",true)
function Scarica(){
  this.RTCopia.Link()
}  
function RTCopia_Result(result){
  if(result=='OK') {
    this.downloadURI('../appo/'+this.gAzienda.Value()+"/"+this.filename.Value(),this.filename.Value())
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
.list_filesid_container {
}
.list_filesid_title_container {
  margin: auto;
}
.list_filesid_portlet{
  position:relative;
  margin: auto;
  width:756px;
  min-width:756px;
  height:472px;
  background-color:#C0C0C0;
}
.list_filesid_portlet[Data-page="1"]{
  height:472px;
  width:756px;
}
.list_filesid_portlet > .ListaFile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  width:756px;
  height:416px;
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
 String def="[{\"h\":\"472\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"756\",\"wizard\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"120\",\"x\":\"914\",\"y\":\"29\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"127\",\"x\":\"915\",\"y\":\"-13\"},{\"anchor\":\"\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Nome file prodotti\"},{\"title\":\"Seq.\"}],\"h\":\"416\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"756\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"917\",\"y\":\"-73\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"149\",\"x\":\"924\",\"y\":\"-47\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"list_filesid","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/list_filesid_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','list_filesid','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("list_filesid_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String filename= "";
String gAzienda=sp.getGlobal("gAzienda","");
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='list_filesid_title_container' style='width:756px'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='list_filesid_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='list_filesid_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('list_filesid','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_ListaFile' formid='<%=idPortlet%>' ps-name='ListaFile'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','list_filesid');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','list_filesid',["756"],["472"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"756","h":"472","title":"","layer":"false","npage":"1"}]);
this.SQLListImp=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"qbe_listsid","cmdHash":"<%=JSPLib.cmdHash("qbe_listsid",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLListImp","decrypted_parms":"","encrypted_fields":"","fieldstype":"true","h":20,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLListImp","nrows":"50","page":1,"parms":"","parms_source":"","type":"SQLDataobj","w":120,"x":914,"y":29});
this.RTCopia=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"<%=JSPLib.encrypt("arfn_copy_file_appo",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_RTCopia","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":30,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"RTCopia","offline":false,"page":1,"parms":"pNomeFile=filename,pCartella=flussi","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"arfn_copy_file_appo","target":"","type":"SPLinker","w":127,"x":915,"y":-13});
this.RTCopia.m_cID='<%=JSPLib.cmdHash("routine,arfn_copy_file_appo",request.getSession())%>';
this.ListaFile=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_ListaFile","dataobj":"SQLListImp","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":416,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"ListaFile","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"","print_result":false,"print_size":"default","print_title":"","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"true","show_btn_delete":"","show_btn_update":"","show_filters":"false","shrinkable":"false","splinker":"","splinker_pos":"","spuid":"","title_color":"","type":"Grid","valign":"top","w":756,"x":0,"y":0,"zindex":""});
this.ListaFile.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"disable_fields_conditions":"","font_weight":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"function:Scarica()","fixedwidth":"","title":"Nome file prodotti","type":"C","align":"","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","sanitize_tags":"","title_align":"","enable_HTML":true,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"nomefile","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":"","sanitize":"xssPrevent"},{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Seq.","type":"N","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"priorita","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.gAzienda=new ZtVWeb._VC(this,'gAzienda',null,'character','<%=JSPLib.ToJSValue(gAzienda,false,true)%>',false,false);
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
<%if(request.getAttribute("list_filesid_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("list_filesid_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.list_filesid_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.SQLListImp.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','list_filesid',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'list_filesid');
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
sp.endPage("list_filesid");
}%>
<%! public String getJSPUID() { return "3958987512"; } %>