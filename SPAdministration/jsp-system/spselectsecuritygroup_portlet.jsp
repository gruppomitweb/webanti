<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"function this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AddButton('\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n                      'javascript:Help()','','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e');\n  if(Substr(this.progname.Value(),1,4)=='vqr\u002f' ||\n     Substr(this.progname.Value(),1,3)=='ps\u002f' ||\n     Substr(this.progname.Value(),1,4)=='vrp\u002f' ){\n    this.backto.Value('..\u002fjsp-system\u002fspquerysecurity_portlet.jsp');\n    customToolbar.AddButton('\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n                             '..\u002fjsp-system\u002fspquerysecurity_portlet.jsp?progname='+this.progname.Value(),'','\u003c%=sp.translate(\"MSG_BACK\")%\u003e','\u003c%=sp.translate(\"MSG_BACK\")%\u003e') ;\n  } else {\n    this.backto.Value('..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp');\n    customToolbar.AddButton('\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n                             '..\u002fjsp-system\u002fspproceduresecurity_portlet.jsp?progname='+this.progname.Value(),'','\u003c%=sp.translate(\"MSG_BACK\")%\u003e','\u003c%=sp.translate(\"MSG_BACK\")%\u003e') ;\n  }\n  customToolbar.SetTitle('\u003c%=sp.translate(\"ADMIN_SELECT_GROUP\")%\u003e');\n  customToolbar.RearrangeAll();\n}\nvar cSkin='\u003c%=sp.getSkin()%\u003e'\nm_cProgName='aggiungiutente';\n\nfunction select_grpname(){\n  this.splinker_spaddsecurityrecord.Link();\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"#FFFFFF","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"display\":\"block\",\"size\":\"\",\"weight\":\"normal\",\"align\":\"center\",\"code\":\"\"},\"hover\":{},\":before\":{\"display\":\"inline-block\",\"content\":\"\\\\ec69\",\"size\":\"20px\",\"weight\":\"normal\",\"font_color\":\"rgba(0, 0, 0, 0.93)\",\"code\":\"font-family: icons8_win10;\"},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"grid_report_link\",\"selector\":\".grid_report_link\",\"id\":\"form\",\"code\":\".grid_report_link {\\n  display: block;\\n  font-weight: normal;\\n  text-align: center;\\n}\\n\\n.grid_report_link::before {\\n  display: inline-block;\\n  font-family: icons8_win10;\\n  color: rgba(0, 0, 0, 0.93);\\n  font-weight: normal;\\n  font-size: 20px;\\n  content: '\\\\ec69';\\n}\\n\"}]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"600","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"true","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"administrator","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","stretch_height":"","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"true","count":"false","h":"21","localDBName":"","n_records":"22","name":"dataobj_groups_available_for_security","offline":"false","page":"1","parms":"progname,filter_roles","parms_source":"","query":"spquery_groups_available_for_security","query_async":"false","return_fields_type":"true","sequence":"15","type":"SQLDataobj","w":"200","x":"433","y":"51"},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"image:\u003c%=sp.getThemedImage(\\\"..\u002fvisualweb\u002fimages\u002fgrid_report_link.png\\\")%\u003e\",\"align\":\"center\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"html:\u003cspan class=\\\"grid_report_link\\\"\u003e\u003c\u002fspan\u003e\",\"maxwidth\":\"\",\"title\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:select_grpname()\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"100px\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_CODE\",\"align\":\"center\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"N\",\"picture\":\"\",\"field\":\"code\",\"maxwidth\":\"\",\"title\":\"ADMIN_CODE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"100px\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_NAME\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"name\",\"maxwidth\":\"\",\"title\":\"ADMIN_NAME\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"orderby_field\":\"\",\"extensible\":false,\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataobj_groups_available_for_security","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":",N,C","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"600","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Users","nav_bar":"always","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_result":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"22","scroll_bars":"false","sequence":"16","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"","splinker_pos":"left","title_color":"","type":"Grid","valign":"top","w":"400","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":""},{"calculate":"","dataobj":"","field":"","h":"20","init":"false","init_par":"request","name":"progname","page":"1","sequence":"18","server_side":"false","type":"Variable","typevar":"character","w":"125","x":"433","y":"74"},{"async":"false","entity_type":"routine","h":"21","m_cAction":"start","m_cAltInterface":"","name":"splinker_spaddsecurityrecord","offline":"false","page":"1","parms":"type,code=c_code,progname,backto","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"19","servlet":"spadministration_addsecurity_record","target":"","type":"SPLinker","w":"200","x":"433","y":"28"},{"calculate":"","dataobj":"dataobj_groups_available_for_security","field":"code","h":"20","init":"","init_par":"","name":"c_code","page":"1","sequence":"20","server_side":"false","type":"Variable","typevar":"character","w":"125","x":"433","y":"96"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"backto","page":"1","sequence":"21","server_side":"false","type":"Variable","typevar":"character","w":"125","x":"433","y":"118"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"filter_roles","page":"1","sequence":"22","server_side":"false","type":"Variable","typevar":"character","w":"125","x":"433","y":"162"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"'G'","name":"type","page":"1","sequence":"24","server_side":"false","type":"Variable","typevar":"character","w":"125","x":"433","y":"140"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:progname,backto,filter_roles*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();
String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
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
.spselectsecuritygroup_container .grid_report_link{  display: block;
  font-weight: normal;
  text-align: center;
}
.spselectsecuritygroup_container .grid_report_link::before{
  display: inline-block;
  font-family: icons8_win10;
  color: rgba(0, 0, 0, 0.93);
  font-weight: normal;
  font-size: 20px;
  content: '\ec69';
}
.spselectsecuritygroup_container {
}
.spselectsecuritygroup_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:600px;
  background-color:#FFFFFF;
}
.spselectsecuritygroup_portlet[Data-page="1"]{
  height:600px;
  width:100%;
}
.spselectsecuritygroup_portlet > .Grid_Users_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:600px;
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
 String def="[{\"h\":\"600\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"200\",\"x\":\"433\",\"y\":\"51\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"\"},{\"title\":\"ADMIN_CODE\"},{\"title\":\"ADMIN_NAME\"}],\"h\":\"600\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"22\",\"type\":\"Grid\",\"w\":\"400\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"125\",\"x\":\"433\",\"y\":\"74\"},{\"h\":\"21\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"200\",\"x\":\"433\",\"y\":\"28\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"125\",\"x\":\"433\",\"y\":\"96\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"125\",\"x\":\"433\",\"y\":\"118\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"125\",\"x\":\"433\",\"y\":\"162\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"125\",\"x\":\"433\",\"y\":\"140\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spselectsecuritygroup","UTF-8")) {return; }
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spselectsecuritygroup_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
<script src="../<%=SPPrxycizer.proxycizedPath("spadministration_help.js")%>"></script>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spselectsecuritygroup','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spselectsecuritygroup_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String progname=JSPLib.translateXSS(sp.getParameter("progname",""));
String c_code= "";
String backto=JSPLib.translateXSS(sp.getParameter("backto",""));
String filter_roles=JSPLib.translateXSS(sp.getParameter("filter_roles",""));
String type="G";
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spselectsecuritygroup_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spselectsecuritygroup_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spselectsecuritygroup_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spselectsecuritygroup','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid_Users' formid='<%=idPortlet%>' ps-name='Grid_Users'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spselectsecuritygroup');
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spselectsecuritygroup',["400"],["600"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"600","title":"","layer":"false","npage":"1"}]);
this.dataobj_groups_available_for_security=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"true","cmd":"spquery_groups_available_for_security","cmdHash":"<%=JSPLib.cmdHash("spquery_groups_available_for_security",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_groups_available_for_security","fieldstype":"true","h":21,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_groups_available_for_security","nrows":"22","page":1,"parms":"progname,filter_roles","parms_source":"","type":"SQLDataobj","w":200,"x":433,"y":51});
this.Grid_Users=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Users","dataobj":"dataobj_groups_available_for_security","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":600,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Users","nav_bar":"always","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"left","title_color":"","type":"Grid","valign":"top","w":400,"x":0,"y":0,"zindex":""});
this.Grid_Users.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":22,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"100px","align":"center","type":"C","title":"","layer":"","ColSpan":0,"newline":false,"alias":"image:<%=sp.getThemedImage("../visualweb/images/grid_report_link.png")%>","extensible":false,"title_align":"","enable_HTML":false,"onclick":"function:select_grpname()","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"html:\u003cspan class=\"grid_report_link\"\u003e\u003c\u002fspan\u003e","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"100px","align":"center","type":"N","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CODE"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"ADMIN_CODE","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"code","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_NAME"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"ADMIN_NAME","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"name","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.progname=new ZtVWeb._VC(this,'progname',null,'character','<%=JSPLib.ToJSValue(progname,false,true)%>',false,false);
this.splinker_spaddsecurityrecord=new ZtVWeb.SPLinkerCtrl(this,{"action":"start","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_spaddsecurityrecord","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":21,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_spaddsecurityrecord","offline":false,"page":1,"parms":"type,code=c_code,progname,backto","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_addsecurity_record","target":"","type":"SPLinker","w":200,"x":433,"y":28});
this.splinker_spaddsecurityrecord.m_cID='<%=JSPLib.cmdHash("routine,spadministration_addsecurity_record",request.getSession())%>';
this.c_code=new ZtVWeb._VC(this,'c_code',null,'character','<%=JSPLib.ToJSValue(c_code,false,true)%>',false,false);
this.backto=new ZtVWeb._VC(this,'backto',null,'character','<%=JSPLib.ToJSValue(backto,false,true)%>',false,false);
this.filter_roles=new ZtVWeb._VC(this,'filter_roles',null,'character','<%=JSPLib.ToJSValue(filter_roles,false,true)%>',false,false);
this.type=new ZtVWeb._VC(this,'type',null,'character','<%=JSPLib.ToJSValue(type,false,true)%>',false,false);
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
<%request.setAttribute("spselectsecuritygroup_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spselectsecuritygroup_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof select_grpname !='undefined')this.select_grpname=select_grpname;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj_groups_available_for_security.addRowConsumer(this.Grid_Users);
this.dataobj_groups_available_for_security.addDataConsumer(this.c_code,<%=JSPLib.ToJSValue("code",true)%>);
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  customToolbar.AddButton('<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
                      'javascript:Help()','','<%=sp.translate("ADMIN_HELP")%>','<%=sp.translate("ADMIN_HELP")%>');
  if(Substr(this.progname.Value(),1,4)=='vqr/' ||
     Substr(this.progname.Value(),1,3)=='ps/' ||
     Substr(this.progname.Value(),1,4)=='vrp/' ){
    this.backto.Value('../jsp-system/spquerysecurity_portlet.jsp');
    customToolbar.AddButton('<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
                             '../jsp-system/spquerysecurity_portlet.jsp?progname='+this.progname.Value(),'','<%=sp.translate("MSG_BACK")%>','<%=sp.translate("MSG_BACK")%>') ;
  } else {
    this.backto.Value('../jsp-system/spproceduresecurity_portlet.jsp');
    customToolbar.AddButton('<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
                             '../jsp-system/spproceduresecurity_portlet.jsp?progname='+this.progname.Value(),'','<%=sp.translate("MSG_BACK")%>','<%=sp.translate("MSG_BACK")%>') ;
  }
  customToolbar.SetTitle('<%=sp.translate("ADMIN_SELECT_GROUP")%>');
  customToolbar.RearrangeAll();
}
var cSkin='<%=sp.getSkin()%>'
m_cProgName='aggiungiutente';
function select_grpname(){
  this.splinker_spaddsecurityrecord.Link();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spselectsecuritygroup_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.dataobj_groups_available_for_security.firstQuery('true');
ZtVWeb.addPortletObj('<%=idPortlet%>','spselectsecuritygroup',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spselectsecuritygroup');
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
sp.endPage("spselectsecuritygroup");
}%>
<%! public String getJSPUID() { return "1083005893"; } %>