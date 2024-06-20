<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"FormatMsg('ADMIN_SECURITY_ALLOW');\nFormatMsg('ADMIN_SECURITY_DENY');\nFormatMsg('ADMIN_SECURITY_NO_VALUE');\n\nvar cSkin='\u003c%=sp.getSkin()%\u003e'\nm_cProgName='spsecurity'\n\nfunction this_Loaded(){\n  this.Lbl_Role.Value(\"\u003cb\u003e\"+FormatMsg('ADMIN_ENTITY_NAME')+\": \u003c\u002fb\u003e\"+this.progname.Value());\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AddButton('\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n                             'javascript:Help()','','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e','\u003c%=sp.translate(\"ADMIN_HELP\")%\u003e');\n  customToolbar.SetTitle('\u003c%=sp.translate(\"ADMIN_MANAGE_SECURITY\")%\u003e');\n  customToolbar.RearrangeAll();\n  this.Grid_Groups.SetOrderBy('grpname','asc')\n  this.dataobj_security_for_role.Query()\n}\n\nfunction btn_close_Click(){\n\tclose();\n}\n","adaptive":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"transparent","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"","css_code":"[]","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","h":"135","hsl":"","included_font":"[]","included_font_offline":"","included_font_online":"","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","my_library":"","offline":"false","on_security_failure":"login","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","sp_uid":"false","steps":"","tabstrip_class":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"400","version":"37","w":"100%","wizard":""},{"appendingData":"false","auto_exec":"false","count":"false","h":"30","localDBName":"","n_records":"5","name":"dataobj_security_for_role","offline":"false","page":"1","parms":"progname","parms_source":"","query":"spquery_security_for_role","query_async":"false","return_fields_type":"true","sequence":"1","type":"SQLDataobj","w":"30","x":"423","y":"21"},{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":"3","cellspacing":"1","checkbox":"false","checkbox_fields":"progname,grpcode","colProperties":"[{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_ROLE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"grpname\",\"maxwidth\":\"\",\"title\":\"ADMIN_ROLE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_ACCESS\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_ACCESS\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_INSERT\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec2:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_INSERT\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_MODIFY\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec3:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_MODIFY\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"ADMIN_DELETE\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"combobox:sec4:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false\",\"maxwidth\":\"\",\"title\":\"ADMIN_DELETE\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"isEditable\":true}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","dataobj":"dataobj_security_for_role","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"false","fields_type":"C,,,,","filters":"true-by-example","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"58","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"true","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"Grid_Groups","nav_bar":"false","nav_bar_addremove":"false","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"false","nav_bar_pagepanel":"false","orderby":"true","outDataObj":"","over_color":"","page":"1","preCheckbox_fld":"","print_result":"","recMark":"false","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"1","scroll_bars":"false","sequence":"3","server_side":"false","show_btn_delete":"","show_btn_update":"true","shrinkable":"","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":"388","wireframe_props":"colProperties,checkbox,rows","x":"6","y":"36","zindex":""},{"anchor":"bottom-right","bg_color":"","border_color":"#496AA0","border_weight":"1","class_Css":"button","create_undercond":"","edit_undercond":"","font":"","font_color":"","font_size":"","h":"28","help_tips":"","hide":"false","hide_undercond":"","layout_steps_values":"{}","name":"btn_close","page":"1","sequence":"5","tabindex":"","type":"Button","type_submit":"false","type_wizard":"","value":"ADMIN_CLOSE","w":"148","wireframe_props":"value","x":"242","y":"103","zindex":"1"},{"align":"left","anchor":"","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"true","field":"","font":"Arial","font_color":"","font_size":"12pt","font_weight":"","fontpct":"","h":"19","heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layout_steps_values":"{}","n_col":"1","name":"Lbl_Role","nowrap":"false","page":"1","picture":"","sequence":"15","server_side":"","shrinkable":"","tabindex":"","target":"","type":"Label","value":"Role","w":"373","wireframe_props":"align,value,n_col","x":"18","y":"12","zindex":"1"},{"calculate":"","dataobj":"","field":"","h":"20","init":"","init_par":"request","name":"progname","page":"1","sequence":"19","server_side":"false","type":"Variable","typevar":"character","w":"97","x":"423","y":"71"}]%>
<%/*Description:*/%>
<%/*ParamsRequest:progname*/%>
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
.sprolesecurity_container {
}
.sprolesecurity_portlet{
  position:relative;
  width:100%;
  min-width:400px;
  height:135px;
  background-color:transparent;
}
.sprolesecurity_portlet[Data-page="1"]{
  height:135px;
  width:100%;
}
.sprolesecurity_portlet > .Grid_Groups_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:36px;
  left:6px;
  right:6px;
  width:auto;
  height:auto;
  min-height:58px;
}
.sprolesecurity_portlet > .btn_close_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  right:10px;
  bottom:4px;
  width:148px;
  height:28px;
}
.sprolesecurity_portlet > .btn_close_ctrl {
  border-width:1px;
  border-color:#496AA0;
}
.sprolesecurity_portlet > .Lbl_Role_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:12px;
  left:18px;
  width:373px;
  height:auto;
  min-height:19px;
}
.sprolesecurity_portlet > .Lbl_Role_ctrl {
  height:auto;
  min-height:19px;
}
.sprolesecurity_portlet > .Lbl_Role_ctrl {
  overflow:hidden;
  font-family:Arial;
  font-size:12pt;
  text-align:left;
  background-color:transparent;
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
 String def="[{\"h\":\"135\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"400\",\"w\":\"100%\",\"wizard\":\"\"},{\"h\":\"30\",\"page\":\"1\",\"type\":\"SQLDataobj\",\"w\":\"30\",\"x\":\"423\",\"y\":\"21\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"ADMIN_ROLE\"},{\"isEditable\":true,\"title\":\"ADMIN_ACCESS\"},{\"isEditable\":true,\"title\":\"ADMIN_INSERT\"},{\"isEditable\":true,\"title\":\"ADMIN_MODIFY\"},{\"isEditable\":true,\"title\":\"ADMIN_DELETE\"}],\"h\":\"58\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"1\",\"type\":\"Grid\",\"w\":\"388\",\"x\":\"6\",\"y\":\"36\",\"zindex\":\"\"},{\"anchor\":\"bottom-right\",\"h\":\"28\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Button\",\"value\":\"ADMIN_CLOSE\",\"w\":\"148\",\"x\":\"242\",\"y\":\"103\",\"zindex\":\"1\"},{\"align\":\"left\",\"anchor\":\"\",\"h\":\"19\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"Role\",\"w\":\"373\",\"x\":\"18\",\"y\":\"12\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"97\",\"x\":\"423\",\"y\":\"71\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"sprolesecurity","UTF-8")) {return; }
 %><%boolean included=request.getAttribute("javax.servlet.include.request_uri")!=null || "true".equals(request.getParameter("clientsideinclusion"));
Map<String,String> safe_params;
if(!included){%>
<!DOCTYPE html>
<html >
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/sprolesecurity_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','sprolesecurity','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("sprolesecurity_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String Lbl_Role= "Role";
String progname=JSPLib.translateXSS(sp.getParameter("progname",""));
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='sprolesecurity_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='sprolesecurity_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='sprolesecurity_portlet portlet' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('sprolesecurity','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_Grid_Groups' formid='<%=idPortlet%>' ps-name='Grid_Groups'   class='grid' style=''>&nbsp;</div>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>'></script>
<%if(Library.IsMobile(request)){%>
<script src='../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>'></script>
<%}%>
<input id='<%=idPortlet%>_btn_close' type='button' class='button btn_close_ctrl'/>
<span id='<%=idPortlet%>_Lbl_Role'  formid='<%=idPortlet%>' ps-name='Lbl_Role'    class='label Lbl_Role_ctrl'><div id='<%=idPortlet%>_Lbl_Roletbl' style='width:100%;'><%=JSPLib.ToHTML(sp.translate("Role"))%></div></span>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','sprolesecurity');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_ENTITY_NAME",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_ENTITY_NAME"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SECURITY_ALLOW",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SECURITY_ALLOW"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SECURITY_DENY",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SECURITY_DENY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_SECURITY_NO_VALUE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_SECURITY_NO_VALUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CHANGE_MARK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CHANGE_MARK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_INSERT_2ND_OP",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_INSERT_2ND_OP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALC_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALC_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_APRIL",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_APRIL"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_AUGUST",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_AUGUST"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_CLOSE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_CLOSE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_DECEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_DECEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FEBRUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FEBRUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_FRI",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_FRI"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_GOTO_CURRENTMONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_GOTO_CURRENTMONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JANUARY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JANUARY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JULY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JULY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_JUNE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_JUNE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MARCH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MARCH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MAY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MAY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_MON",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_MON"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NEXT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NEXT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_NOVEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_NOVEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_OCTOBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_OCTOBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_PREVIOUS_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_PREVIOUS_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SAT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SAT"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_MONTH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_MONTH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SELECT_YEAR",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SELECT_YEAR"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SEPTEMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SEPTEMBER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_SUN",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_SUN"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_THU",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_THU"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TODAY_IS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TODAY_IS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_TUE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_TUE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WED",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WED"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CALENDAR_WEEK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CALENDAR_WEEK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_CONTAINS",true)+","+JSPLib.ToJSValue(sp.translate("MSG_CONTAINS"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_NOTEMPTY",true)+","+JSPLib.ToJSValue(sp.translate("MSG_NOTEMPTY"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_STARTS_WITH",true)+","+JSPLib.ToJSValue(sp.translate("MSG_STARTS_WITH"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_DATE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_DATE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_WRONG_NUMBER",true)+","+JSPLib.ToJSValue(sp.translate("MSG_WRONG_NUMBER"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','sprolesecurity',["400"],["135"],'portlet',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,false,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"400","h":"135","title":"","layer":"false","npage":"1"}]);
this.dataobj_security_for_role=new ZtVWeb._SQP(this,{"allowedcmds":"","anchor":"","appendingData":false,"async":false,"auto_exec":"false","cmd":"spquery_security_for_role","cmdHash":"<%=JSPLib.cmdHash("spquery_security_for_role",request.getSession())%>","count":"false","ctrlid":"<%=idPortlet%>_dataobj_security_for_role","fieldstype":"true","h":30,"hide":"false","init_time":0,"layer":false,"layout_steps_values":{},"localDBName":"","long_query":false,"name":"dataobj_security_for_role","nrows":"5","page":1,"parms":"progname","parms_source":"","type":"SQLDataobj","w":30,"x":423,"y":21});
this.Grid_Groups=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"SPManageSecurity","cellpadding":3,"cellspacing":1,"checkbox":"false","checkbox_fields":"progname,grpcode","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_Grid_Groups","dataobj":"dataobj_security_for_role","disabled_fld":"","empty_rows":"true","extensible":"false","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":58,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"true","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"Grid_Groups","nav_bar":"false","navbar_mode":"{\"pagepanel\":false,\"changepage\":true,\"addremove\":false,\"lastpage\":false,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"","print_outputf":"","print_result":false,"print_size":"","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"false","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"true","show_filters":"true-by-example","shrinkable":"false","splinker":"","splinker_pos":"","title_color":"","type":"Grid","valign":"top","w":388,"x":6,"y":36,"zindex":""});
this.Grid_Groups.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":1,"colProperties":[{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ROLE"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"grpname","fg_color":"","width":"","alias":"ADMIN_ROLE","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_ACCESS"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"combobox:sec1:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false","isEditable":true,"fg_color":"","width":"","alias":"ADMIN_ACCESS","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_INSERT"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"combobox:sec2:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false","isEditable":true,"fg_color":"","width":"","alias":"ADMIN_INSERT","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_MODIFY"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"combobox:sec3:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false","isEditable":true,"fg_color":"","width":"","alias":"ADMIN_MODIFY","RowSpan":0},{"maxwidth":"","col_class":"","enable_HTML":false,"onclick":"","link":"","weight":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DELETE"),false,true)%>","layer":"","ColSpan":0,"picture":"","target":"","bg_color":"","newline":false,"field":"combobox:sec4:[[0;'ADMIN_SECURITY_NO_VALUE'];[1;'ADMIN_SECURITY_ALLOW'];[-1000;'ADMIN_SECURITY_DENY']]:false","isEditable":true,"fg_color":"","width":"","alias":"ADMIN_DELETE","RowSpan":0}]});
this.Grid_Groups.m_cID='<%=JSPLib.cmdHash("routine,spgridoperation",request.getSession())%>';
PrepareJsCalendar(false);
this.btn_close=new ZtVWeb._BC(this,{"anchor":"bottom-right","bg_color":"","border_color":"#496AA0","border_weight":"1","class_Css":"button btn_close_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_btn_close","edit_undercond":"","font":"","font_color":"","font_size":"","h":28,"help_tips":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","hide":"false","hide_undercond":"","layer":false,"layout_steps_values":{},"name":"btn_close","page":1,"tabindex":"","text":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_CLOSE"),false,true)%>","type":"Button","type_submit":"false","type_wizard":"","w":148,"x":242,"y":103,"zindex":"1"});
this.Lbl_Role=new ZtVWeb._LC(this,{"align":"left","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_Lbl_Role","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":true,"field":"","font":"Arial","font_color":"","font_size":"12pt","font_weight":"","fontpct":"","h":19,"heading":"","help_tips":"","hide":"false","hide_undercond":"","href":"","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"Lbl_Role","nowrap":"false","page":1,"picture":"","sanitize":"none","sanitize_tags":"","server_side":"","shrinkable":"","tabindex":"","target":"","text":"<%=JSPLib.ToJSValue(sp.translate(Lbl_Role),false,true)%>","type":"Label","w":373,"x":18,"y":12,"zindex":"1"});
this.progname=new ZtVWeb._VC(this,'progname',null,'character','<%=JSPLib.ToJSValue(progname,false,true)%>',false,false);
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
<%request.setAttribute("sprolesecurity_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.sprolesecurity_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof btn_close_Click !='undefined')this.btn_close_Click=btn_close_Click;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.dataobj_security_for_role.addRowConsumer(this.Grid_Groups);
FormatMsg('ADMIN_SECURITY_ALLOW');
FormatMsg('ADMIN_SECURITY_DENY');
FormatMsg('ADMIN_SECURITY_NO_VALUE');
var cSkin='<%=sp.getSkin()%>'
m_cProgName='spsecurity'
function this_Loaded(){
  this.Lbl_Role.Value("<b>"+FormatMsg('ADMIN_ENTITY_NAME')+": </b>"+this.progname.Value());
  var customToolbar=this.getTitlePortlet();
  customToolbar.AddButton('<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
                             'javascript:Help()','','<%=sp.translate("ADMIN_HELP")%>','<%=sp.translate("ADMIN_HELP")%>');
  customToolbar.SetTitle('<%=sp.translate("ADMIN_MANAGE_SECURITY")%>');
  customToolbar.RearrangeAll();
  this.Grid_Groups.SetOrderBy('grpname','asc')
  this.dataobj_security_for_role.Query()
}
function btn_close_Click(){
	close();
}

this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.sprolesecurity_Static.call(window.<%=idPortlet%>);
ZtVWeb.addPortletObj('<%=idPortlet%>','sprolesecurity',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'sprolesecurity');
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
sp.endPage("sprolesecurity");
}%>
<%! public String getJSPUID() { return "3171582118"; } %>