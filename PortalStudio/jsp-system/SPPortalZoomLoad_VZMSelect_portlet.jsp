<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"\u003c%int configMode=sp.ZoomConfigMode();%\u003e\nfunction VZMList_RecordChanged(){\nvar conf;\n\u003c%if (configMode==2) {%\u003e\n  conf = this.VZMList.rs.custom+\"\u002f\"+this.VZMList.rs.VZM+ (!Empty(this.VZMList.rs.spec)?\"\u002f\"+this.VZMList.rs.spec:\"\");\n\u003c%} else {%\u003e\n  conf = this.VZMList.rs.VZM;\n\u003c% } %\u003e\nthis.ConfigurationSelected.Value(conf);\n}\n\ndocument.title=\"\u003c%=sp.translate(\"MSG_VZM_SELECT\")%\u003e\"+\" VZM\";\n\nfunction this_Loaded(){\n\u003c% if (configMode==2) { %\u003e\nthis.grdVzms.ColumnFields(\"checkbox:custom,VZM,spec\");\nthis.grdVzms.ColumnTitles(\"Custom,Configuration,Specific\");\n\u003c% } %\u003e\n\n  this.Fill();\n}\nthis.grdVzms.Refresh=function(){\n  this.form.Fill();\n}\nfunction Fill(){\n  new JSURL(\"..\u002fservlet\u002fSPVZMProxy?action=list&table=\"+this.Table.Value(),true,_fill);\n}\n\nvar this_portlet=this;\nvar _fill=function(jsurl){\n  __fill.call(this_portlet,new Function(\"return \"+jsurl.Response()+\";\")());\n}\n\nvar __fill=function(vzms){\n  var vzmList;\n\u003c%  if (configMode==2) {%\u003e\n    vzmList={Fields:['custom','VZM','spec'],Data:[]};\n\u003c%  } else {%\u003e\n    vzmList={Fields:['VZM'],Data:[]};\n\u003c%  } %\u003e\n\n  var find, foundIdx;\n  if(!EmptyString(this.ConfigName.Value())){\n    find=this.ConfigName.Value();\n  }\n  for(var i=0, vzm, re_table_vzm=new RegExp(\".\"+this.Table.Value()+\"_vzm\",\"i\"), l=vzms.length; i\u003cl; i++){\n\u002f\u002f    vzm=vzms[i].replace(re_table_vzm,'');\n    vzm = vzms[i].split(',');\n    vzmList.Data[i]=vzm;\n    if(find && !foundIdx && vzm[0]==find){\n      foundIdx=i+1;\n    }\n  }\n  this.grdVzms.rows=Math.max(vzmList.Data.length,20);\n\u003c%  if (configMode==2) { %\u003e\n    vzmList.Data.push(\"tf,NCC,\"+vzmList.Data.length);\n\u003c%  } else { %\u003e\n    vzmList.Data.push(\"tf,C,\"+vzmList.Data.length);\n\u003c% } %\u003e\n  this.VZMList.firstQuery('true','',vzmList);\n  if(IsAny(foundIdx)){\n    this.grdVzms.SetCurRec(foundIdx);\n  }\n}\n\nfunction Ok(){\n  var openerID=this.openerID.Value();\n  if(!openerID) return;\n  var VZMName=this.ConfigurationSelected.Value();\n  var caller= window.opener||window;\n\u002f\u002fdebugger\n  caller.ZtVWeb.raiseEvent(openerID+\"_ChangeVZMName\", VZMName);\n  this.Cancel(); \n}\n\nfunction Cancel(){\n  var openerID=this.openerID.Value();\n  if(!openerID) return;\n  if(window.opener){\n    window.close();\n  }\n}\n\nfunction btnOk_Click(){\n  this.Ok();\n}\n\nfunction btnCancel_Click(){\n  this.Cancel();\n}","bg_image":" ","cache_time":" ","color":" ","css":" ","css_class":" ","description":" ","form_action":" ","form_type":"false","h":"430","language":"false","my_library":" ","on_security_failure":"login","pages_names":" ","positioning":"absolute","security":"none","sp_theme":"true","sp_uid":"false","tag":" ","title":" ","type":"Form","v_line":"300","version":"37","w":"100%"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"request","name":"ConfigName","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"40","y":"-50"},{"align":"left","anchor":"top-left-right-bottom","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":" ","colProperties":"[{\"disable_fields_conditions\":\"\",\"enable_HTML\":false,\"fg_color\":\"\",\"weight\":\"\",\"bg_color\":\"\",\"extensible\":false,\"alias\":\"Configurations\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"field\":\"VZM\",\"maxwidth\":\"\",\"title\":\"Configurations\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\"}]","css_class_grid":"grid","css_class_nav_bar":" ","css_class_row":" ","css_class_row_odd":" ","css_class_row_over":" ","css_class_row_selected":" ","css_class_title":" ","css_class_title_hover":" ","dataobj":"VZMList","disabled_fld":" ","draggablecolumns":"false","editable_fields":" ","empty_rows":"true","extFields":" ","extensible":"false","fields_type":" ","filters":"false","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"350","homogeneityAsFilter":"false","homogeneity_fields":" ","keepMemCurs":" ","line_color":" ","link_underlined":" ","name":"grdVzms","nav_bar":"true","orderby":" ","orderby_list":" ","outDataObj":" ","over_color":" ","page":"1","preCheckbox_fld":" ","recMark":"true","render_totals":" ","resizablecolumns":"false","row_color":" ","row_color_odd":" ","rows":"20","scroll_bars":"true","sequence":" ","server_side":"false","splinker":" ","splinker_pos":" ","title_color":" ","type":"Grid","valign":"top","w":"280","x":"10","y":"10"},{"auto_exec":"false","count":"true","n_records":"0","name":"VZMList","page":"1","parms":" ","parms_source":" ","query":" ","query_async":"false","return_fields_type":"true","sequence":" ","type":"SQLDataobj","x":"0","y":"-39"},{"anchor":"bottom-left-right","calculate":" ","class_Css":"textbox","dataobj":" ","edit_undercond":" ","field":" ","font":"verdana","font_color":" ","font_size":" ","h":"20","help_tips":" ","hide_undercond":" ","init":" ","init_par":" ","maxlength":" ","name":"ConfigurationSelected","page":"1","password":" ","picture":" ","readonly":"true","scroll":"false","sequence":" ","tabindex":" ","type":"Textbox","typevar":"character","visible":"true","w":"220","x":"70","y":"365","zerofilling":"false","zindex":"1"},{"anchor":"bottom-right","bg_color":" ","class_Css":" ","edit_undercond":" ","font":" ","font_color":" ","font_size":" ","h":"25","help_tips":" ","hide_undercond":" ","name":"btnOk","page":"1","sequence":" ","tabindex":" ","type":"Button","type_submit":"false","value":"Ok","w":"55","x":"175","y":"397"},{"anchor":"bottom-right","bg_color":" ","class_Css":"button","edit_undercond":" ","font":" ","font_color":" ","font_size":" ","h":"25","help_tips":" ","hide_undercond":" ","name":"btnCancel","page":"1","sequence":" ","tabindex":" ","type":"Button","type_submit":"false","value":"Cancel","w":"55","x":"235","y":"397"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"request","name":"openerID","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"40","y":"-26"},{"align":"left","anchor":"bottom-left","assoc_input":" ","bg_color":" ","calculate":" ","class_Css":"label","dataobj":" ","enable_HTML":"true","field":" ","font":" ","font_color":" ","font_size":" ","font_weight":" ","h":"19","heading":" ","help_tips":" ","hide_undercond":" ","href":" ","init":" ","name":"lblSelected","page":"1","picture":" ","sequence":" ","server_side":" ","tabindex":" ","target":" ","type":"Label","value":"Selected:","w":"60","x":"10","y":"365","zindex":"1"},{"calculate":" ","dataobj":" ","field":" ","h":"22","init":" ","init_par":"request","name":"Table","page":"1","sequence":" ","type":"Variable","typevar":"character","w":"146","x":"190","y":"-50"}]%>
<%/*Description: */%>
<%/*ParamsRequest:ConfigName,openerID,Table*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.SPPortalZoomLoad_VZMSelect_container {
}
.SPPortalZoomLoad_VZMSelect_portlet{
  position:relative;
  width:100%;
  min-width:300px;
  height:430px;
}
.SPPortalZoomLoad_VZMSelect_portlet[Data-page="1"]{
  height:430px;
  width:100%;
}
.SPPortalZoomLoad_VZMSelect_portlet > .grdVzms_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:10px;
  left:10px;
  right:10px;
  bottom:70px;
  width:auto;
}
.SPPortalZoomLoad_VZMSelect_portlet > .ConfigurationSelected_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  left:70px;
  right:10px;
  bottom:45px;
  width:auto;
  height:20px;
}
.SPPortalZoomLoad_VZMSelect_portlet > .ConfigurationSelected_ctrl {
}
.SPPortalZoomLoad_VZMSelect_portlet > .ConfigurationSelected_ctrl > input{
  vertical-align:top;
  box-sizing:border-box;
  z-index:1;
  font-family:verdana;
  width:100%;
  height:100%;
}
.SPPortalZoomLoad_VZMSelect_portlet > .btnOk_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  right:70px;
  bottom:8px;
  width:55px;
  height:25px;
}
.SPPortalZoomLoad_VZMSelect_portlet > .btnOk_ctrl {
  border-width:nullpx;
}
.SPPortalZoomLoad_VZMSelect_portlet > .btnCancel_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  right:10px;
  bottom:8px;
  width:55px;
  height:25px;
}
.SPPortalZoomLoad_VZMSelect_portlet > .btnCancel_ctrl {
  border-width:nullpx;
}
.SPPortalZoomLoad_VZMSelect_portlet > .lblSelected_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  left:10px;
  bottom:46px;
  width:60px;
  height:auto;
  min-height:19px;
}
.SPPortalZoomLoad_VZMSelect_portlet > .lblSelected_ctrl {
  height:auto;
  min-height:19px;
}
.SPPortalZoomLoad_VZMSelect_portlet > .lblSelected_ctrl {
  overflow:hidden;
  text-align:left;
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
 String def="[{\"h\":\"430\",\"pages_names\":\"\",\"title\":\"\",\"type\":\"Form\",\"v_line\":\"300\",\"w\":\"100%\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"40\",\"y\":\"-50\"},{\"anchor\":\"top-left-right-bottom\",\"h\":\"350\",\"page\":\"1\",\"type\":\"Grid\",\"w\":\"280\",\"x\":\"10\",\"y\":\"10\"},{\"page\":\"1\",\"type\":\"SQLDataobj\",\"x\":\"0\",\"y\":\"-39\"},{\"anchor\":\"bottom-left-right\",\"h\":\"20\",\"page\":\"1\",\"type\":\"Textbox\",\"w\":\"220\",\"x\":\"70\",\"y\":\"365\",\"zindex\":\"1\"},{\"anchor\":\"bottom-right\",\"h\":\"25\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"55\",\"x\":\"175\",\"y\":\"397\"},{\"anchor\":\"bottom-right\",\"h\":\"25\",\"page\":\"1\",\"type\":\"Button\",\"w\":\"55\",\"x\":\"235\",\"y\":\"397\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"40\",\"y\":\"-26\"},{\"anchor\":\"bottom-left\",\"h\":\"19\",\"page\":\"1\",\"type\":\"Label\",\"w\":\"60\",\"x\":\"10\",\"y\":\"365\",\"zindex\":\"1\"},{\"h\":\"22\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"146\",\"x\":\"190\",\"y\":\"-50\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoomLoad_VZMSelect","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPPortalZoomLoad_VZMSelect_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','SPPortalZoomLoad_VZMSelect','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String ConfigName=JSPLib.translateXSS(sp.getParameter("ConfigName",""));
if(request.getAttribute("SPPortalZoomLoad_VZMSelect_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String ConfigurationSelected= "";
if(request.getAttribute("SPPortalZoomLoad_VZMSelect_firstinclusion")==null){
 if (Library.IsMobile(request)) {%><link rel='prefetch' as='script' id='controls.js' href='../<%=SPPrxycizer.proxycizedPath("controls.js") %>'>
<link rel='prefetch' as='script' id='calculator.mobile.js' href='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js") %>'>
<% } %><%}
String openerID=JSPLib.translateXSS(sp.getParameter("openerID",""));
String lblSelected= "Selected:";
String Table=JSPLib.translateXSS(sp.getParameter("Table",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_container' class='SPPortalZoomLoad_VZMSelect_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='SPPortalZoomLoad_VZMSelect_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('SPPortalZoomLoad_VZMSelect','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_grdVzms' formid='<%=idPortlet%>' ps-name='grdVzms'   class='grid' style=''>&nbsp;</div>
<span class='textbox-container'id='<%=idPortlet%>_ConfigurationSelected_wrp'><input id='<%=idPortlet%>_ConfigurationSelected' name='ConfigurationSelected' type='text' disabled class='textbox' formid='<%=idPortlet%>' ps-name='ConfigurationSelected' /></span>
<input id='<%=idPortlet%>_btnOk' type='button' class='button btnOk_ctrl'/>
<input id='<%=idPortlet%>_btnCancel' type='button' class='button btnCancel_ctrl'/>
<span id='<%=idPortlet%>_lblSelected'  formid='<%=idPortlet%>' ps-name='lblSelected'    class='label lblSelected_ctrl'><div id='<%=idPortlet%>_lblSelectedtbl' style='width:100%;'><%=JSPLib.ToHTML("Selected:")%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','SPPortalZoomLoad_VZMSelect');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','SPPortalZoomLoad_VZMSelect',["300"],["430"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','','false',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"300","h":"430","title":" ","layer":"false","npage":"1"}]);
this.ConfigName=new ZtVWeb._VC(this,'ConfigName',null,'character','<%=JSPLib.ToJSValue(ConfigName,false,true)%>',false,false);
this.grdVzms=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right-bottom","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":" ","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_grdVzms","dataobj":"VZMList","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":350,"hide":"false","hide_empty_lines":"false","hmg_as_filter":"false","homogeneity_fields":" ","isorderby":" ","keepMemCurs":" ","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":" ","name":"grdVzms","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":" ","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"","print_totals":false,"recMark":"true","render_totals":" ","row_color":"","row_color_odd":"","scroll_bars":"true","show_btn_delete":"false","show_btn_update":"false","show_filters":"false","shrinkable":"false","splinker":" ","splinker_pos":" ","title_color":"","type":"Grid","valign":"top","w":280,"x":10,"y":10});
this.grdVzms.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":20,"colProperties":[{"disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","enable_HTML":false,"weight":"","type":"C","title":"Configurations","layer":"","ColSpan":0,"bg_color":"","newline":false,"field":"VZM","fg_color":"","width":"","alias":"Configurations","RowSpan":0,"extensible":false}]});
this.VZMList=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":" ","cmdHash":"<%=JSPLib.cmdHash(" ",request.getSession())%>","count":"true","ctrlid":"<%=idPortlet%>_VZMList","fieldstype":"true","h":0,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"VZMList","nrows":"0","page":1,"parms":" ","parms_source":" ","type":"SQLDataobj","w":0,"x":0,"y":-39});
this.ConfigurationSelected=new ZtVWeb._TC(this,{"anchor":"bottom-left-right","calculate":" ","create_undercond":"","ctrlid":"<%=idPortlet%>_ConfigurationSelected","decrypt":false,"edit_undercond":" ","encrypt":false,"field":" ","fixed":"false","floating_placeholder":false,"h":20,"help_tips":"","hide":"false","hide_undercond":" ","init":" ","init_par":"","layer":false,"layout_steps_values":{},"maxlength":"","name":"ConfigurationSelected","page":1,"picker":"","picture":" ","reactive":false,"readonly":"true","server_side":"","type":"Textbox","typehtml5":"","typevar":"character","value":"<%=JSPLib.ToJSValue(ConfigurationSelected,false,true)%>","w":220,"x":70,"y":365,"zerofilling":false,"zindex":"1","zoom":""});
this.btnOk=new ZtVWeb._BC(this,{"anchor":"bottom-right","bg_color":"","class_Css":"button btnOk_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnOk","edit_undercond":" ","font":"","font_color":"","font_size":"","h":25,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"btnOk","page":1,"tabindex":" ","text":"Ok","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":175,"y":397});
this.btnCancel=new ZtVWeb._BC(this,{"anchor":"bottom-right","bg_color":"","class_Css":"button btnCancel_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btnCancel","edit_undercond":" ","font":"","font_color":"","font_size":"","h":25,"help_tips":" ","hide":"false","hide_undercond":" ","layer":false,"layout_steps_values":{},"name":"btnCancel","page":1,"tabindex":" ","text":"Cancel","type":"Button","type_submit":"false","type_wizard":"","w":55,"x":235,"y":397});
this.openerID=new ZtVWeb._VC(this,'openerID',null,'character','<%=JSPLib.ToJSValue(openerID,false,true)%>',false,false);
this.lblSelected=new ZtVWeb._LC(this,{"align":"left","anchor":"bottom-left","assoc_input":" ","calculate":" ","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_lblSelected","draggable":"false","draggable_name":"","droppable":"false","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":" ","font":" ","font_color":" ","font_size":" ","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":" ","href":" ","init":" ","layer":false,"layout_steps_values":{},"n_col":1,"name":"lblSelected","nowrap":"","page":1,"picture":" ","sanitize":"none","sanitize_tags":"","server_side":" ","shrinkable":"false","tabindex":" ","target":" ","text":"<%=JSPLib.ToJSValue(lblSelected,false,true)%>","type":"Label","w":60,"x":10,"y":365,"zindex":"1"});
this.Table=new ZtVWeb._VC(this,'Table',null,'character','<%=JSPLib.ToJSValue(Table,false,true)%>',false,false);
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
<%request.setAttribute("SPPortalZoomLoad_VZMSelect_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomLoad_VZMSelect_Static=function(){
if(typeof VZMList_RecordChanged !='undefined')this.VZMList_RecordChanged=VZMList_RecordChanged;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof Fill !='undefined')this.Fill=Fill;
if(typeof Ok !='undefined')this.Ok=Ok;
if(typeof Cancel !='undefined')this.Cancel=Cancel;
if(typeof btnOk_Click !='undefined')this.btnOk_Click=btnOk_Click;
if(typeof btnCancel_Click !='undefined')this.btnCancel_Click=btnCancel_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.VZMList.addRowConsumer(this.grdVzms);
<%int configMode=sp.ZoomConfigMode();%>
function VZMList_RecordChanged(){
var conf;
<%if (configMode==2) {%>
  conf = this.VZMList.rs.custom+"/"+this.VZMList.rs.VZM+ (!Empty(this.VZMList.rs.spec)?"/"+this.VZMList.rs.spec:"");
<%} else {%>
  conf = this.VZMList.rs.VZM;
<% } %>
this.ConfigurationSelected.Value(conf);
}
document.title="<%=sp.translate("MSG_VZM_SELECT")%>"+" VZM";
function this_Loaded(){
<% if (configMode==2) { %>
this.grdVzms.ColumnFields("checkbox:custom,VZM,spec");
this.grdVzms.ColumnTitles("Custom,Configuration,Specific");
<% } %>
  this.Fill();
}
this.grdVzms.Refresh=function(){
  this.form.Fill();
}
function Fill(){
  new JSURL("../servlet/SPVZMProxy?action=list&table="+this.Table.Value(),true,_fill);
}
var this_portlet=this;
var _fill=function(jsurl){
  __fill.call(this_portlet,new Function("return "+jsurl.Response()+";")());
}
var __fill=function(vzms){
  var vzmList;
<%  if (configMode==2) {%>
    vzmList={Fields:['custom','VZM','spec'],Data:[]};
<%  } else {%>
    vzmList={Fields:['VZM'],Data:[]};
<%  } %>
  var find, foundIdx;
  if(!EmptyString(this.ConfigName.Value())){
    find=this.ConfigName.Value();
  }
  for(var i=0, vzm, re_table_vzm=new RegExp("."+this.Table.Value()+"_vzm","i"), l=vzms.length; i<l; i++){
//    vzm=vzms[i].replace(re_table_vzm,'');
    vzm = vzms[i].split(',');
    vzmList.Data[i]=vzm;
    if(find && !foundIdx && vzm[0]==find){
      foundIdx=i+1;
    }
  }
  this.grdVzms.rows=Math.max(vzmList.Data.length,20);
<%  if (configMode==2) { %>
    vzmList.Data.push("tf,NCC,"+vzmList.Data.length);
<%  } else { %>
    vzmList.Data.push("tf,C,"+vzmList.Data.length);
<% } %>
  this.VZMList.firstQuery('true','',vzmList);
  if(IsAny(foundIdx)){
    this.grdVzms.SetCurRec(foundIdx);
  }
}
function Ok(){
  var openerID=this.openerID.Value();
  if(!openerID) return;
  var VZMName=this.ConfigurationSelected.Value();
  var caller= window.opener||window;
//debugger
  caller.ZtVWeb.raiseEvent(openerID+"_ChangeVZMName", VZMName);
  this.Cancel(); 
}
function Cancel(){
  var openerID=this.openerID.Value();
  if(!openerID) return;
  if(window.opener){
    window.close();
  }
}
function btnOk_Click(){
  this.Ok();
}
function btnCancel_Click(){
  this.Cancel();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.SPPortalZoomLoad_VZMSelect_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','SPPortalZoomLoad_VZMSelect',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'SPPortalZoomLoad_VZMSelect');
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
sp.endPage("SPPortalZoomLoad_VZMSelect");
}%>
<%! public String getJSPUID() { return "1571695858"; } %>