<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"var FilesList\nfunction this_Loaded(){\n  this.grd_querylist.LinkValueUid = this.UID.Value();\n  this.grd_querylist.LinkValueField = this.LinkedField.Value();\n  this.grd_querylist.LinkFillEmptyKey = this.FillEmptyKey.Value();\n  this.grd_querylist.LinkPKFields = this.PKFields.Value();\n  var FilesList = JSON.decode(new JSURL(\"..\u002fservlet\u002fSPVQRProxy?\"+ \"action=\" +\n                (this.mode.Value()||\"vqr\") +\n                (this.mode.Value()==\"tables\"?\"&filename=\"+URLenc(this.filename.Value()):\"\")\n             ).Response().replace(\u002f\\.vqr?\u002fgi, '').replace(\u002f\\.json\u002fgi,''),true);\n\n  for (var i=0; i\u003cFilesList.length; i++) {\n    FilesList[i]=[FilesList[i]];\n  }\n  this.dataobj.FillData(FilesList);\n}\n\nfunction SelectQueryName(){\n  this.EventQueryname.Emit();\n  window.close();\n}","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"block\",\"size\":\"\",\"weight\":\"normal\",\"align\":\"center\",\"code\":\"\"},\"hover\":{},\":before\":{\"display\":\"inline-block\",\"content\":\"\\\\ec69\",\"size\":\"20px\",\"weight\":\"normal\",\"font_color\":\"rgba(0, 0, 0, 0.93)\",\"code\":\"font-family: icons8_win10;\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_report_link\",\"selector\":\".grid_report_link\",\"id\":\"form\",\"code\":\".grid_report_link {\\n  display: block;\\n  font-weight: normal;\\n  text-align: center;\\n}\\n\\n.grid_report_link::before {\\n  display: inline-block;\\n  font-family: icons8_win10;\\n  color: rgba(0, 0, 0, 0.93);\\n  font-weight: normal;\\n  font-size: 20px;\\n  content: '\\\\ec69';\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"300","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"mootools.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","security":"administrator","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"alias":"queryname","fieldsType":"C","h":"22","name":"dataobj","page":"1","sequence":"2","type":"StaticDataProvider","w":"120","x":"415","y":"194"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fvisualweb\u002fimages\u002fgrid_report_link.png\\\")%\u003e\",\"align\":\"center\",\"link\":\"\",\"width\":\"5%\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"grid_report_link\\\"\u003e\u003c\u002fspan\u003e\",\"title\":\"\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:SelectQueryName()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"5%\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"title_tooltip\":\"\"},{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"ADMIN_VQR_NAME\",\"align\":\"left\",\"link\":\"\",\"width\":\"95%\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"queryname\",\"title\":\"ADMIN_VQR_NAME\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataobj","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":",C","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"300","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"grd_querylist","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"false","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_result":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"10","scroll_bars":"false","sequence":"3","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":""},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"PKFields","page":"1","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"415","y":"79"},{"calculate":"","dataobj":"dataobj","field":"queryname","h":"22","init":"","init_par":"","name":"queryname","page":"1","sequence":"35","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"415","y":"148"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"UID","page":"1","sequence":"50","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"415","y":"10"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"FillEmptyKey","page":"1","sequence":"54","server_side":"false","type":"Variable","typevar":"logic","w":"120","x":"415","y":"33"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"LinkedField","page":"1","sequence":"57","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"415","y":"56"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"mode","page":"1","sequence":"58","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"415","y":"102"},{"calculate":"","dataobj":"","field":"","h":"22","init":"","init_par":"request","name":"filename","page":"1","sequence":"59","server_side":"false","type":"Variable","typevar":"character","w":"120","x":"415","y":"125"},{"broadcast":"all","eventsNames":"","eventsObjs":"","h":"22","name":"EventQueryname","page":"1","parmsNames":"queryname","parmsTypes":"var","parmsValues":"queryname","persistent":"true","sequence":"60","type":"EventEmitter","w":"120","x":"415","y":"171"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:PKFields,UID,FillEmptyKey,LinkedField,mode,filename*/%>
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
window.gsso_select_vqr_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof SelectQueryName !='undefined')this.SelectQueryName=SelectQueryName;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj.addRowConsumer(this.grd_querylist);
this.dataobj.addDataConsumer(this.queryname,<%=JSPLib.ToJSValue("queryname",true)%>);
var FilesList
function this_Loaded(){
  this.grd_querylist.LinkValueUid = this.UID.Value();
  this.grd_querylist.LinkValueField = this.LinkedField.Value();
  this.grd_querylist.LinkFillEmptyKey = this.FillEmptyKey.Value();
  this.grd_querylist.LinkPKFields = this.PKFields.Value();
  var FilesList = JSON.decode(new JSURL("../servlet/SPVQRProxy?"+ "action=" +
                (this.mode.Value()||"vqr") +
                (this.mode.Value()=="tables"?"&filename="+URLenc(this.filename.Value()):"")
             ).Response().replace(/\.vqr?/gi, '').replace(/\.json/gi,''),true);
  for (var i=0; i<FilesList.length; i++) {
    FilesList[i]=[FilesList[i]];
  }
  this.dataobj.FillData(FilesList);
}
function SelectQueryName(){
  this.EventQueryname.Emit();
  window.close();
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
.gsso_select_vqr_container .grid_report_link{  display: block;
  font-weight: normal;
  text-align: center;
}
.gsso_select_vqr_container .grid_report_link::before{
  display: inline-block;
  font-family: icons8_win10;
  color: rgba(0, 0, 0, 0.93);
  font-weight: normal;
  font-size: 20px;
  content: '\ec69';
}
.gsso_select_vqr_container {
}
.gsso_select_vqr_title_container {
  margin: auto;
}
.gsso_select_vqr_portlet{
  position:relative;
  margin: auto;
  width:100%;
  min-width:400px;
  height:300px;
  background-color:#FFFFFF;
}
.gsso_select_vqr_portlet[Data-page="1"]{
  height:300px;
  width:100%;
}
.gsso_select_vqr_portlet > .grd_querylist_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:300px;
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
 String def="[{\"h\":\"300\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"120\",\"x\":\"415\",\"y\":\"194\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"ADMIN_VQR_NAME\"}],\"h\":\"300\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"10\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"415\",\"y\":\"79\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"415\",\"y\":\"148\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"415\",\"y\":\"10\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"415\",\"y\":\"33\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"415\",\"y\":\"56\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"415\",\"y\":\"102\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"120\",\"x\":\"415\",\"y\":\"125\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"EventEmitter\",\"w\":\"120\",\"x\":\"415\",\"y\":\"171\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"gsso_select_vqr","UTF-8")) {return; }
 %><%if(!sp.isAdministrator() && sp.hasAdministeredUsers()){%>
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/gsso_select_vqr_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','gsso_select_vqr','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("gsso_select_vqr_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
if(request.getAttribute("gsso_select_vqr_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String PKFields=JSPLib.translateXSS(sp.getParameter("PKFields",""));
String queryname= "";
String UID=JSPLib.translateXSS(sp.getParameter("UID",""));
boolean FillEmptyKey=sp.getParameter("FillEmptyKey",false);
String LinkedField=JSPLib.translateXSS(sp.getParameter("LinkedField",""));
String mode=JSPLib.translateXSS(sp.getParameter("mode",""));
String filename=JSPLib.translateXSS(sp.getParameter("filename",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='gsso_select_vqr_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='gsso_select_vqr_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('gsso_select_vqr','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_grd_querylist' formid='<%=idPortlet%>' ps-name='grd_querylist'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','gsso_select_vqr');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','gsso_select_vqr',["400"],["300"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"300","title":"","layer":"false","npage":"1"}]);
this.dataobj=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"ctrlid":"<%=idPortlet%>_dataobj","fieldsString":"queryname","fieldstypeString":"C","h":22,"hide":"false","layer":false,"layout_steps_values":{},"name":"dataobj","page":1,"parms":"","parms_source":"","type":"StaticDataProvider","w":120,"x":415,"y":194});
this.grd_querylist=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grd_querylist","dataobj":"dataobj","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":300,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"grd_querylist","nav_bar":"always","navbar_mode":"{\"pagepanel\":true,\"changepage\":false,\"addremove\":false,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":400,"x":0,"y":0,"zindex":""});
this.grd_querylist.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":10,"colProperties":[{"disable_fields_conditions":"","font_weight":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"5%","align":"center","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"image:<%=sp.getThemedImage("../visualweb/images/grid_report_link.png")%>","extensible":false,"title_align":"","enable_HTML":false,"onclick":"function:SelectQueryName()","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"grid_report_link\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"5%","RowSpan":0,"font_family":""},{"disable_fields_conditions":"","orderby_field":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"left","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_VQR_NAME"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"queryname","fg_color":"","width":"95%","alias":"ADMIN_VQR_NAME","RowSpan":0,"extensible":false}]});
this.PKFields=new ZtVWeb._VC(this,'PKFields',null,'character','<%=JSPLib.ToJSValue(PKFields,false,true)%>',false,false);
this.queryname=new ZtVWeb._VC(this,'queryname',null,'character','<%=JSPLib.ToJSValue(queryname,false,true)%>',false,false);
this.UID=new ZtVWeb._VC(this,'UID',null,'character','<%=JSPLib.ToJSValue(UID,false,true)%>',false,false);
this.FillEmptyKey=new ZtVWeb._VC(this,'FillEmptyKey',null,'logic',<%=FillEmptyKey%>,false,false);
this.LinkedField=new ZtVWeb._VC(this,'LinkedField',null,'character','<%=JSPLib.ToJSValue(LinkedField,false,true)%>',false,false);
this.mode=new ZtVWeb._VC(this,'mode',null,'character','<%=JSPLib.ToJSValue(mode,false,true)%>',false,false);
this.filename=new ZtVWeb._VC(this,'filename',null,'character','<%=JSPLib.ToJSValue(filename,false,true)%>',false,false);
this.EventQueryname=new ZtVWeb.EventEmitterCtrl(this,{"anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_EventQueryname","eventsNames":"","eventsObjs":"","h":22,"hide":"false","layer":false,"layout_steps_values":{},"name":"EventQueryname","page":1,"parmsNames":"queryname","parmsTypes":"var","parmsValues":"queryname","persistent":"true","type":"EventEmitter","w":120,"x":415,"y":171});
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
<%if(request.getAttribute("gsso_select_vqr_firstinclusion")==null){%>
<script src='<%=JSPLib.getJSPSelfPath(request)%>?SpStaticCode=<%=m_cJSPUID%>'></script>
<%request.setAttribute("gsso_select_vqr_firstinclusion",idPortlet);
}%>
<script>
/*JS_MARKER_START*/
window.gsso_select_vqr_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.EventQueryname.setParms();
ZtVWeb.addPortletObj('<%=idPortlet%>','gsso_select_vqr',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'gsso_select_vqr');
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
sp.endPage("gsso_select_vqr");
}%>
<%! public String getJSPUID() { return "1588546288"; } %>