<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function Aggiorna() {\n  this.ListaFile.Refresh()\n}\n\nfunction Timer0_onTimer(){\n  this.ListaFile.Refresh()\n}\n\nfunction this_Loaded(){\n  this.Timer0.Start()\n}","bg_image":" ","cache_in_post":"false","cache_time":" ","color":"#C0C0C0","css":" ","css_class":" ","description":" ","form_action":" ","form_enctype":" ","form_target":" ","form_type":"false","h":"105","hsl":" ","language":"false","lock_items":" ","manifest":"Custom manifest","my_library":" ","offline":"false","on_security_failure":"login","pages_names":" ","positioning":"absolute","roles":" ","security":"none","server_cache_time":" ","shared_manifest":"false","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":" ","version":"37","w":"754"},{"auto_exec":"true","count":"false","localDBName":" ","n_records":"100","name":"SQLListImp","offline":"false","page":"1","parms":" ","parms_source":" ","query":"rows:arfn_listfile","query_async":"false","return_fields_type":"true","sequence":"3","type":"SQLDataobj","x":"-2","y":"-42"},{"align":"left","anchor":" ","business_obj":" ","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":" ","colProperties":"[{\"disable_fields_conditions\":\"\",\"maxwidth\":\"\",\"orderby_field\":\"\",\"col_class\":\"\",\"enable_HTML\":false,\"onclick\":\"\",\"link\":\"\",\"weight\":\"\",\"title\":\"Nome file da importare\",\"type\":\"C\",\"align\":\"\",\"ColSpan\":0,\"layer\":\"\",\"picture\":\"\",\"target\":\"\",\"bg_color\":\"\",\"newline\":false,\"field\":\"nomefile\",\"fg_color\":\"\",\"width\":\"\",\"RowSpan\":0,\"extensible\":false}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"SQLListImp","disable_fields_conditions":" ","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":"C","filters":"false","floatRows":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","group_repeated":"false","h":"71","hide_empty_lines":" ","hide_undercond":" ","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":"false","line_color":" ","link_underlined":" ","name":"ListaFile","nav_bar":"always","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":" ","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","print_result":" ","recMark":" ","render_totals":" ","resizablecolumns":"false","row_color":" ","row_color_odd":" ","rows":"2","scroll_bars":"false","sequence":"5","server_side":"false","show_btn_delete":" ","show_btn_update":" ","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":"top","w":"713","x":"21","y":"23"},{"actObjs":" ","actTypes":"func","h":"20","included":"false","name":"arpg_import_ListaR","objsValues":"this.Aggiorna()","page":"1","parmsNames":" ","sequence":"9","type":"EventReceiver","w":"22","x":"43","y":"-27"},{"align":"center","anchor":" ","assoc_input":" ","bg_color":"#0335FF","calculate":" ","class_Css":"label","create_undercond":" ","dataobj":" ","enable_HTML":"true","field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","h":"20","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"label2","nowrap":"false","page":"1","picture":" ","sequence":"10","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"ELENCO FILE","w":"756","x":"-1","y":"-1","zindex":"1"},{"delay":" ","duration":" ","h":"34","interval":"5000","name":"Timer0","page":"1","repeated":"true","rounds":"30000","start_activated":"true","type":"Timer","w":"40","x":"75","y":"-45"}]%>
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
window.list_impfile_Static=function(){
if(typeof Aggiorna !='undefined')this.Aggiorna=Aggiorna;
if(typeof Timer0_onTimer !='undefined')this.Timer0_onTimer=Timer0_onTimer;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SQLListImp.addRowConsumer(this.ListaFile);
function Aggiorna() {
  this.ListaFile.Refresh()
}
function Timer0_onTimer(){
  this.ListaFile.Refresh()
}
function this_Loaded(){
  this.Timer0.Start()
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
.list_impfile_container {
}
.list_impfile_portlet{
  position:relative;
  width:754px;
  min-width:754px;
  height:105px;
  background-color:#C0C0C0;
}
.list_impfile_portlet[Data-page="1"]{
  height:105px;
  width:754px;
}
.list_impfile_portlet > .ListaFile_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:23px;
  left:21px;
  width:713px;
  height:auto;
  min-height:71px;
}
.list_impfile_portlet > .label2_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:-1px;
  left:-1px;
  width:756px;
  height:auto;
  min-height:20px;
}
.list_impfile_portlet > .label2_ctrl {
  height:auto;
  min-height:20px;
}
.list_impfile_portlet > .label2_ctrl {
  overflow:hidden;
  font-family:Verdana;
  font-size:9pt;
  font-weight:bold;
  color:#F2F202;
  text-align:center;
  background-color:#0335FF;
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
 String def="[{\"h\":\"105\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"\",\"w\":\"754\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"-2\",\"y\":\"-42\"},{\"anchor\":\"\",\"h\":\"71\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"713\",\"x\":\"21\",\"y\":\"23\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"22\",\"x\":\"43\",\"y\":\"-27\"},{\"anchor\":\"\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"756\",\"x\":\"-1\",\"y\":\"-1\",\"zindex\":\"1\"},{\"h\":\"34\",\"page\":\"1\",\"type\":\"Timer\",\"w\":\"40\",\"x\":\"75\",\"y\":\"-45\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"list_impfile","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/list_impfile_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','list_impfile','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("list_impfile_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String label2= "ELENCO FILE";
if(request.getAttribute("list_impfile_firstinclusion")==null){%>
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
<div id='<%=idPortlet%>_container' class='list_impfile_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='list_impfile_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('list_impfile','<%=idPortlet%>',false,' ');
</script><%}}%>
<div id='<%=idPortlet%>_ListaFile' formid='<%=idPortlet%>' ps-name='ListaFile'   class='grid' style=''>&nbsp;</div>
<span id='<%=idPortlet%>_label2'  formid='<%=idPortlet%>' ps-name='label2'    class='label label2_ctrl'><div id='<%=idPortlet%>_label2tbl' style='width:100%;'><%=JSPLib.ToHTML("ELENCO FILE")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','list_impfile');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','list_impfile',["754"],["105"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"754","h":"105","title":" ","layer":"false","npage":"1"}]);
this.SQLListImp=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"rows:arfn_listfile","cmdHash":"<%=JSPLib.cmdHash("rows:arfn_listfile",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_SQLListImp","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"SQLListImp","nrows":"100","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":-2,"y":-42});
this.ListaFile=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left","business_obj":" ","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":" ","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_ListaFile","dataobj":"SQLListImp","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":71,"hide":"false","hide_empty_lines":" ","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":" ","keepMemCurs":"false","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":" ","name":"ListaFile","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":" ","render_totals":" ","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":" ","show_btn_update":" ","show_filters":"false","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":"top","w":713,"x":21,"y":23});
this.ListaFile.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":2,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","title":"Nome file da importare","type":"C","align":"","ColSpan":0,"layer":"","picture":"","target":"","bg_color":"","newline":false,"field":"nomefile","fg_color":"","width":"","RowSpan":0,"extensible":false}]});
this.arpg_import_ListaR=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":" ","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_arpg_import_ListaR","h":20,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"arpg_import_ListaR","objsValues":"this.Aggiorna()","page":1,"parmsNames":" ","type":"EventReceiver","w":22,"x":43,"y":-27});
this.label2=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":" ","ctrlid":"<%=idPortlet%>_label2","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":"Verdana","font_color":"#F2F202","font_size":"9pt","font_weight":"bold","fontpct":"","h":20,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"label2","nowrap":"false","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(label2,false,true)%>","type":"Label","w":756,"x":-1,"y":-1,"zindex":"1"});
this.Timer0=new ZtVWeb.TimerCtrl(this,{"anchor":"","ctrlid":"<%=idPortlet%>_Timer0","delay":" ","duration":" ","h":34,"hide":"false","interval":"5000","layer":false,"layout_steps_values":{},"name":"Timer0","page":1,"repeated":"true","rounds":"30000","start_activated":"true","type":"Timer","w":40,"x":75,"y":-45});
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
<%if(request.getAttribute("list_impfile_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("list_impfile_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.list_impfile_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_arpg_import_ListaR=function(parmsObj){<%=idPortlet%>.arpg_import_ListaR.receiveFnc(parmsObj);}
window.<%=idPortlet%>.SQLListImp.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','list_impfile',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'list_impfile');
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
sp.endPage("list_impfile");
}%>
<%! public String getJSPUID() { return "2769864836"; } %>