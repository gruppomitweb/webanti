<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"m_cTarget = '\u003c%= JSPLib.ToJSValue((String) (Class.forName(\"SPControlPanel\").getField(\"m_cTarget\").get(null))) %\u003e';\nfunction this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  if(m_cTarget != \"_blank\") {\n    customToolbar.AppendButton({\n      image:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n      action:'..\u002fservlet\u002fSPControlPanel',\n      title:FormatMsg(\"MSG_BACK\"),\n      tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n    })\n  }\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })\n  customToolbar.SetTitle(FormatMsg(\"CP_MOBAPPSTORE\"));\n  customToolbar.RearrangeAll();\n  this.MC_Grid.Value( this.SPL_Grid.Link() );\n  this.MC_Grid.InToDatasource( this.SDP_Grid )\n}\n\nm_cProgName=\"spadministration_users_list\";\n\nfunction RefreshGrid(){\n  this.system_mobapp_list.Refresh(true);\n}\n\nfunction getStateImage(appName, state, type) {\n  var imageurl;\n  if (state==0 ) { \u002f\u002fa posto o app create lato utenza\n    imageurl = \"..\u002fimages\u002fspadministration_mobapp_ok.png\";\n    return '\u003cimg title=\"'+\u003c%=Library.ToJSValue(sp.translate(\"MOBAPPSTORE_APP_READY\"),\"C\",0,0)%\u003e+'\" src=\"'+imageurl+'\"\u003e\u003c\u002fimg\u003e';\n  } else if (state == 1 || state == 2) { \u002f\u002fmodificata o nuova\n    var title = \u003c%=Library.ToJSValue(sp.translate(\"ADMIN_DATABASE_RUN\"),\"C\",0,0)%\u003e\n    if (state==1)\n    \timageurl = \"..\u002fimages\u002fspadministration_mobapp_gen.png\";\n   \telse\n      imageurl = \"..\u002fimages\u002fspadministration_mobapp_new.png\";\n    return '\u003cimg title=\"'+title+'\" src=\"'+imageurl+'\"\u003e\u003c\u002fimg\u003e';\n  }   \n}\n\nfunction getStateAction(appName, state, type) {\n  if (state == 1 || state == 2) { \u002f\u002fmodificata o nuova\n    this.admin(appName,type);\n  }   \n}\nfunction admin(appName, type) {\n  this.appNames.Value(appName);\n  this.forceCreateFile.Value(false);\n  this.ignoreFile.Value(false);\n  this.admin_app.Link();\n  \n}\nfunction admin_app_Executed(okSave,cError){\n  if (okSave=='true') {\n\t  this.MC_Grid.GoToKey(this.appNames.Value());\n    if (this.MC_Grid.Get('oatoadmin')==2) {\n      this.afterSave();\n    } else {\n  \t\tthis.MC_Grid.Set(\"oatoadmin\",0);\n    \tthis.MC_Grid.InToDatasource(this.SDP_Grid);\n      this.RefreshGrid();\n    }\n  } else if (this.forceCreateFile.Value()!=true){\n    var _this=this;\n    WindowConfirm(cError +'\\nRetry?', function(res){\n      if (res) {\n        _this.forceCreateFile.Value(true);\n        _this.ignoreFile.Value(true);\n        _this.admin_app.Link();\n      }\n    });\n  } else {\n    alert(cError);\n  }\n}\n\nfunction getTypeImage(type){\n  if(type==1) \n\t  return \"\u003cimg title='\"+FormatMsg('MOBAPPSTORE_TYPE_SYSTEM')+\"' src='\u003c%=sp.getThemedImage(\"..\u002fimages\u002fmobapp_sys.png\")%\u003e'\u003e\";\n  if(type==2)\n    return \"\u003cimg title='\"+FormatMsg('MOBAPPSTORE_TYPE_USER')+\"' src='\u003c%=sp.getThemedImage(\"..\u002fimages\u002fmobapp_user.png\")%\u003e'\u003e\";\n  return \"\";  \n}\nfunction afterSave(){\n  this.MC_Grid.Value( this.SPL_Grid.Link() );\n  this.MC_Grid.InToDatasource( this.SDP_Grid )\n\tthis.RefreshGrid();\n}\n\nfunction manage_apps_Deleted(bResult){\n  this.afterSave();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"","css_class":"portlet-white-default","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @system_mobapp_list }}\u003c\u002fbody\u003e","grapesCss":"","h":"100","hsl":"","htmlcode":"{{ @system_mobapp_list }} \n{{ system_mobapp_list }}\n{{ manage_apps }}\n{{ SPManageMobAppStore_savedEntity }}\n{{ admin_app }}\n{{ appNames }}\n{{ SPL_Grid }}\n{{ MC_Grid }}\n{{ SDP_Grid }}\n{{ forceCreateFile }}\n{{ ignoreFile }}\n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"NORMAL","my_library":"spadministration_help.js","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"title\":\"\",\"layer\":\"\",\"h\":\"100\",\"w\":\"100%\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"","positioning":"absolute","roles":"","sec_heredity":"","security":"administrator","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":" 598","version":"37","w":"100%","wizard":""},{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":"3","cellspacing":"0","checkbox":"false","checkbox_fields":"","colProperties":"[{\"field\":\"function:getTypeImage('%oaapptype%')\",\"title\":\"Type\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"maxwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":true,\"orderby_field\":\"oaapptype\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"fixedwidth\":\"60px\",\"title_align\":\"\",\"height\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":true,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"Stato\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"function:getStateImage('%oaappmenu%',%oatoadmin%,%oaapptype%)\",\"maxwidth\":\"\",\"title\":\"Stato\",\"orderby_field\":\"oatoadmin\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"function:getStateAction('%oaappmenu%',%oatoadmin%,%oaapptype%)\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"60px\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"extensible\":false,\"title_tooltip\":\"\",\"height\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"Codice\",\"align\":\"\",\"link\":\"\",\"width\":\"100px\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"oa__code\",\"title\":\"Codice\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"100px\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"extensible\":false,\"title_tooltip\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"Titolo\",\"align\":\"\",\"link\":\"\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"oaapptitle\",\"title\":\"Titolo\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"extensible\":false,\"title_tooltip\":\"\"},{\"field\":\"checkbox:oaapppublished\",\"title\":\"Pubblicato\",\"font_family\":\"\",\"bg_color\":\"\",\"fg_color\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"align\":\"\",\"col_class\":\"\",\"width\":\"\",\"maxwidth\":\"\",\"ColSpan\":0,\"RowSpan\":0,\"picture\":\"\",\"layer\":\"\",\"newline\":false,\"enable_HTML\":false,\"orderby_field\":\"\",\"extensible\":false,\"link\":\"\",\"target\":\"\",\"onclick\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"title_tooltip\":\"\",\"type\":\"C\",\"fixedwidth\":\"80px\",\"title_align\":\"\"},{\"fg_color\":\"\",\"enable_HTML\":false,\"weight\":\"\",\"bg_color\":\"\",\"alias\":\"Menu\",\"align\":\"\",\"link\":\"..\u002fmenueditor\u002fmenueditor.jsp?action=load&filename=%oaappmenu%\",\"width\":\"\",\"layer\":\"\",\"RowSpan\":0,\"ColSpan\":0,\"type\":\"C\",\"picture\":\"\",\"field\":\"oaappmenu\",\"maxwidth\":\"\",\"title\":\"Menu\",\"orderby_field\":\"\",\"newline\":false,\"col_class\":\"\",\"target\":\"_blank\",\"onclick\":\"\",\"font_family\":\"\",\"font_weight\":\"\",\"font_size\":\"\",\"fixedwidth\":\"\",\"title_align\":\"\",\"droppable\":false,\"droppable_name\":\"\",\"disable_fields_conditions\":\"\",\"extensible\":false,\"title_tooltip\":\"\"}]","css_class_card_container":"","css_class_grid":"grid","css_class_nav_bar":"","css_class_row":"","css_class_row_odd":"","css_class_row_over":"","css_class_row_selected":"","css_class_title":"","css_class_title_hover":"","ctrlOfVariant":"","dataobj":"SDP_Grid","disabled_fld":"","draggable_name":"","draggable_row":"","draggablecolumns":"false","empty_rows":"true","extensible":"","fields_type":",,,","filters":"true-by-example","fixed":"","floatRows":"","font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":"100","hide":"false","hide_default_titles":"","hide_empty_lines":"","hide_undercond":"","homogeneityAsFilter":"false","homogeneity_fields":"","keepMemCurs":"","layer":"false","layout_steps_values":"{}","line_color":"","link_underlined":"","name":"system_mobapp_list","nav_bar":"true","nav_bar_addremove":"true","nav_bar_changepage":"true","nav_bar_firstlast":"true","nav_bar_lastpage":"true","nav_bar_pagepanel":"true","orderby":"true","outDataObj":"","over_color":"","page":"1","portlet_in_row":"","preCheckbox_fld":"","print_grep":"","print_hideexport":"","print_hidesettings":"","print_max":"","print_option":"default","print_outputf":"default","print_result":"","print_size":"default","print_title":"","print_totals":"","rapp":"","recMark":"","render_totals":"","resizablecolumns":"false","row_color":"","row_color_odd":"","rows":"15","scroll_bars":"false","sequence":"1","server_side":"false","show_btn_delete":"","show_btn_update":"","shrinkable":"","splinker":"manage_apps","splinker_pos":"left-layer","spuid":"","title_color":"","type":"Grid","valign":"top","w":"598","wireframe_props":"colProperties,checkbox,rows","x":"0","y":"0","zindex":"","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"master","h":"23","m_cAction":"","name":"manage_apps","offline":"false","page":"1","parms":"oa__code","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":"","refresh":"false","sequence":"1","servlet":"SPManageMobAppStore","target":"","type":"SPLinker","w":"160","x":"617","y":"154"},{"actObjs":"","actTypes":"func","broadcast":"all","ctrlOfVariant":"","h":"23","included":"false","name":"SPManageMobAppStore_savedEntity","objsValues":"this.afterSave()","page":"1","parmsNames":"","sequence":"2","type":"EventReceiver","w":"160","x":"617","y":"235"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"23","m_cAction":"function","name":"admin_app","offline":"false","page":"1","parms":"appNames,ignoreFile,forceCreateFile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"3","servlet":"spadministration_mobappadmin","target":"","type":"SPLinker","w":"160","x":"617","y":"127"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"","name":"appNames","page":"1","reactive":"","sequence":"4","server_side":"false","type":"Variable","typevar":"character","w":"145","x":"617","y":"22"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"routine","h":"23","m_cAction":"function","name":"SPL_Grid","offline":"false","page":"1","parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":"","refresh":"","sequence":"5","servlet":"spadministration_mobapplist","target":"","type":"SPLinker","w":"160","x":"617","y":"100"},{"auto_create":"","ctrlOfVariant":"","fields":"","h":"23","layout_steps_values":"{}","name":"MC_Grid","page":"1","sequence":"6","type":"MemoryCursor","types":"","w":"160","x":"617","y":"208"},{"alias":"oa__code,oaapptitle,oaapplogo,oaappmenu,oareserved,oaappchecksum,oatoadmin,oaapptype,oaapppublished","auto_exec":"true","ctrlOfVariant":"","dataproviders":"","fieldsType":"C,C,C,C,C,C,N,N,N","h":"23","man_query":"","name":"SDP_Grid","page":"1","parms":"","parms_source":"","sequence":"7","type":"StaticDataProvider","w":"160","x":"617","y":"181"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"false","name":"forceCreateFile","page":"1","reactive":"","sequence":"8","server_side":"false","type":"Variable","typevar":"logic","w":"145","x":"617","y":"45"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"false","name":"ignoreFile","page":"1","reactive":"","sequence":"9","server_side":"false","type":"Variable","typevar":"logic","w":"145","x":"617","y":"68"}]%>
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
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.spadministration_mobapp_container {
  height:100%;
  overflow:auto;
}
.spadministration_mobapp_portlet{
  position:relative;
  width:100%;
  min-width: 598px;
  height:100%;
}
.spadministration_mobapp_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}
.spadministration_mobapp_portlet > .system_mobapp_list_ctrl {
  box-sizing:border-box;
  z-index:1;
  position:absolute;
  display:inline-block;
  top:0px;
  left:0px;
  right:0px;
  width:auto;
  height:auto;
  min-height:100px;
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
 String def="[{\"h\":\"100\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"598\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left-right\",\"checkbox\":\"false\",\"colProperties\":[{\"title\":\"Type\"},{\"title\":\"Stato\"},{\"title\":\"Codice\"},{\"title\":\"Titolo\"},{\"title\":\"Pubblicato\"},{\"title\":\"Menu\"}],\"h\":\"100\",\"layout_steps_values\":{},\"page\":\"1\",\"rows\":\"15\",\"type\":\"Grid\",\"w\":\"598\",\"x\":\"0\",\"y\":\"0\",\"zindex\":\"\"},{\"h\":\"23\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"617\",\"y\":\"154\"},{\"h\":\"23\",\"page\":\"1\",\"type\":\"EventReceiver\",\"w\":\"160\",\"x\":\"617\",\"y\":\"235\"},{\"h\":\"23\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"617\",\"y\":\"127\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"145\",\"x\":\"617\",\"y\":\"22\"},{\"h\":\"23\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"617\",\"y\":\"100\"},{\"h\":\"23\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"MemoryCursor\",\"w\":\"160\",\"x\":\"617\",\"y\":\"208\"},{\"h\":\"23\",\"page\":\"1\",\"type\":\"StaticDataProvider\",\"w\":\"160\",\"x\":\"617\",\"y\":\"181\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"145\",\"x\":\"617\",\"y\":\"45\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"145\",\"x\":\"617\",\"y\":\"68\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_mobapp","UTF-8")) {return; }
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
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_mobapp_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_mobapp','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%if(request.getAttribute("spadministration_mobapp_firstinclusion")==null){
com.zucchetti.PortalStudio.visualweb.GridControl.GridTranslations(sp,request,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridCtrl.js")%>'></script>
<%if(Library.IsMobile(request)) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
<%}
}%>
<%String appNames= "";
if(request.getAttribute("spadministration_mobapp_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("MemoryCursorObj.js")%>'></script>
<%}
if(request.getAttribute("spadministration_mobapp_firstinclusion")==null){%>
<script src='../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("AlaSQL.js")%>'></script>
<script src='../<%=com.zucchetti.sitepainter.SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("StaticDataProviderObj.js")%>'></script>
<%}
boolean forceCreateFile=false;
boolean ignoreFile=false;
try{
if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_mobapp_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_mobapp_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_mobapp_portlet portlet-white-default' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_mobapp','<%=idPortlet%>',false,'');
</script><%}}%>
<div id='<%=idPortlet%>_system_mobapp_list' formid='<%=idPortlet%>' ps-name='system_mobapp_list'   class='grid' style=''>&nbsp;</div>
</div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_mobapp');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_MOBAPPSTORE",true)+","+JSPLib.ToJSValue(sp.translate("CP_MOBAPPSTORE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MOBAPPSTORE_TYPE_SYSTEM",true)+","+JSPLib.ToJSValue(sp.translate("MOBAPPSTORE_TYPE_SYSTEM"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MOBAPPSTORE_TYPE_USER",true)+","+JSPLib.ToJSValue(sp.translate("MOBAPPSTORE_TYPE_USER"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_BACK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_BACK"),true)+");\n");
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
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_mobapp',["598"],["100"],'portlet-white-default',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'NORMAL',[{"layout_steps_values":{},"w":"598","h":"100","title":"","layer":""}]);
this.system_mobapp_list=new ZtVWeb.GridCtrl(this,{"align":"left","anchor":"top-left-right","business_obj":"","cellpadding":3,"cellspacing":0,"checkbox":"false","checkbox_fields":"","class_nav_bar":"grid_navbar","class_row":"grid_row","class_row_odd":"grid_rowodd","class_row_over":"grid_rowover","class_row_selected":"grid_rowselected","class_table":"grid","class_title":"grid_title","class_title_hover":"grid_titleover","css_class_card_container":"","ctrlid":"<%=idPortlet%>_system_mobapp_list","dataobj":"SDP_Grid","disabled_fld":"","empty_rows":"true","extensible":"","floatRows":false,"font":"","font_color":"","font_size":"","font_weight":"","group_repeated":"false","h":100,"hide":"false","hide_empty_lines":"","hmg_as_filter":"false","homogeneity_fields":"","isorderby":"true","keepMemCurs":"","layer":false,"layout_steps_values":{},"line_color":"","link_underlined":"","name":"system_mobapp_list","nav_bar":"true","navbar_mode":"{\"pagepanel\":true,\"changepage\":true,\"addremove\":true,\"lastpage\":true,\"firstlast\":true}","outDataObj":"","over_color":"","page":1,"portlet_in_row":"","preCheckbox_fld":"","print_grep":false,"print_hideexport":false,"print_hidesettings":false,"print_max":false,"print_option":"default","print_outputf":"default","print_result":false,"print_size":"default","print_title":"<%=JSPLib.ToJSValue(sp.translate(""),false,true)%>","print_totals":false,"recMark":"","render_totals":"","row_color":"","row_color_odd":"","scroll_bars":"false","show_btn_delete":"","show_btn_update":"","show_filters":"true-by-example","shrinkable":"false","splinker":"manage_apps","splinker_pos":"left-layer","spuid":"","title_color":"","type":"Grid","valign":"top","w":598,"x":0,"y":0,"zindex":""});
this.system_mobapp_list.setRowsCols({"draggablecolumns":false,"resizablecolumns":false,"draggable_row":"false","hide_default_titles":false,"rows":15,"colProperties":[{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"oaapptype","col_class":"","font_size":"","link":"","fixedwidth":"60px","title":"<%=JSPLib.ToJSValue(sp.translate("Type"),false,true)%>","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"height":"","title_align":"","enable_HTML":true,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:getTypeImage('%oaapptype%')","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"oatoadmin","col_class":"","font_size":"","link":"","fixedwidth":"60px","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Stato"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"Stato","extensible":false,"height":"","title_align":"","enable_HTML":true,"onclick":"function:getStateAction('%oaappmenu%',%oatoadmin%,%oaapptype%)","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"function:getStateImage('%oaappmenu%',%oatoadmin%,%oaapptype%)","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"100px","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Codice"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"Codice","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"oa__code","droppable_name":"","fg_color":"","width":"100px","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Titolo"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"Titolo","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"oaapptitle","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"","fixedwidth":"80px","title":"<%=JSPLib.ToJSValue(sp.translate("Pubblicato"),false,true)%>","align":"","type":"C","ColSpan":0,"layer":"","newline":false,"extensible":false,"title_align":"","enable_HTML":false,"onclick":"","picture":"","target":"","title_tooltip":"","droppable":false,"bg_color":"","field":"checkbox:oaapppublished","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""},{"font_weight":"","disable_fields_conditions":"","maxwidth":"","orderby_field":"","col_class":"","font_size":"","link":"..\u002fmenueditor\u002fmenueditor.jsp?action=load&filename=%oaappmenu%","fixedwidth":"","align":"","type":"C","title":"<%=JSPLib.ToJSValue(sp.translate("Menu"),false,true)%>","layer":"","ColSpan":0,"newline":false,"alias":"Menu","extensible":false,"title_align":"","enable_HTML":false,"onclick":"","weight":"","picture":"","target":"_blank","title_tooltip":"","droppable":false,"bg_color":"","field":"oaappmenu","droppable_name":"","fg_color":"","width":"","RowSpan":0,"font_family":""}]});
this.manage_apps=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_manage_apps","decrypted_parms":"","entity_type":"master","force_msg_id":false,"h":23,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"manage_apps","offline":false,"page":1,"parms":"oa__code","popup":"true","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"","popup_width":"","progressbar":false,"refresh":"false","servlet":"SPManageMobAppStore","target":"","type":"SPLinker","w":160,"x":617,"y":154});
this.manage_apps.m_cID='<%=JSPLib.cmdHash("entity,SPManageMobAppStore",request.getSession())%>';
this.SPManageMobAppStore_savedEntity=new ZtVWeb.EventReceiverCtrl(this,{"actObjs":"","actTypes":"func","anchor":"","broadcast":"all","ctrlid":"<%=idPortlet%>_SPManageMobAppStore_savedEntity","h":23,"hide":"false","included":"false","layer":false,"layout_steps_values":{},"name":"SPManageMobAppStore_savedEntity","objsValues":"this.afterSave()","page":1,"parmsNames":"","type":"EventReceiver","w":160,"x":617,"y":235});
this.admin_app=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_admin_app","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":23,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"admin_app","offline":false,"page":1,"parms":"appNames,ignoreFile,forceCreateFile","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_mobappadmin","target":"","type":"SPLinker","w":160,"x":617,"y":127});
this.admin_app.m_cID='<%=JSPLib.cmdHash("routine,spadministration_mobappadmin",request.getSession())%>';
this.appNames=new ZtVWeb._VC(this,'appNames',null,'character','<%=JSPLib.ToJSValue(appNames,false,true)%>',false,false);
this.SPL_Grid=new ZtVWeb.SPLinkerCtrl(this,{"action":"function","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_SPL_Grid","decrypted_parms":"","entity_type":"routine","force_msg_id":false,"h":23,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"SPL_Grid","offline":false,"page":1,"parms":"","popup":"false","popup_height":"","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"","progressbar":false,"refresh":"","servlet":"spadministration_mobapplist","target":"","type":"SPLinker","w":160,"x":617,"y":100});
this.SPL_Grid.m_cID='<%=JSPLib.cmdHash("routine,spadministration_mobapplist",request.getSession())%>';
this.MC_Grid=new ZtVWeb.MemoryCursorCtrl(this,'MC_Grid','<%=idPortlet%>_MC_Grid','','','','','false');
this.SDP_Grid=new ZtVWeb.StaticDataProvider(this,{"anchor":"","async":false,"auto_exec":"true","ctrlid":"<%=idPortlet%>_SDP_Grid","dataproviders":"","fieldsString":"oa__code,oaapptitle,oaapplogo,oaappmenu,oareserved,oaappchecksum,oatoadmin,oaapptype,oaapppublished","fieldstypeString":"C,C,C,C,C,C,N,N,N","h":23,"hide":"false","layer":false,"layout_steps_values":{},"name":"SDP_Grid","page":1,"parms":"","parms_source":"","query":"","type":"StaticDataProvider","w":160,"x":617,"y":181});
this.forceCreateFile=new ZtVWeb._VC(this,'forceCreateFile',null,'logic',<%=forceCreateFile%>,false,false);
this.ignoreFile=new ZtVWeb._VC(this,'ignoreFile',null,'logic',<%=ignoreFile%>,false,false);
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
<%request.setAttribute("spadministration_mobapp_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_mobapp_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof RefreshGrid !='undefined')this.RefreshGrid=RefreshGrid;
if(typeof getStateImage !='undefined')this.getStateImage=getStateImage;
if(typeof getStateAction !='undefined')this.getStateAction=getStateAction;
if(typeof admin !='undefined')this.admin=admin;
if(typeof admin_app_Executed !='undefined')this.admin_app_Executed=admin_app_Executed;
if(typeof getTypeImage !='undefined')this.getTypeImage=getTypeImage;
if(typeof afterSave !='undefined')this.afterSave=afterSave;
if(typeof manage_apps_Deleted !='undefined')this.manage_apps_Deleted=manage_apps_Deleted;
<%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>
this.SDP_Grid.addRowConsumer(this.system_mobapp_list);
m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  if(m_cTarget != "_blank") {
    customToolbar.AppendButton({
      image:SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
      action:'../servlet/SPControlPanel',
      title:FormatMsg("MSG_BACK"),
      tooltip:FormatMsg("ADMIN_BACK_TO_CP")
    })
  }
  customToolbar.AppendButton({
  	image:SPTheme.controlPanelHelp || '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
    action:'javascript:Help()',
    title:FormatMsg("ADMIN_HELP_TITLE"),
    tooltip:FormatMsg("ADMIN_HELP_TITLE")
  })
  customToolbar.SetTitle(FormatMsg("CP_MOBAPPSTORE"));
  customToolbar.RearrangeAll();
  this.MC_Grid.Value( this.SPL_Grid.Link() );
  this.MC_Grid.InToDatasource( this.SDP_Grid )
}
m_cProgName="spadministration_users_list";
function RefreshGrid(){
  this.system_mobapp_list.Refresh(true);
}
function getStateImage(appName, state, type) {
  var imageurl;
  if (state==0 ) { //a posto o app create lato utenza
    imageurl = "../images/spadministration_mobapp_ok.png";
    return '<img title="'+<%=Library.ToJSValue(sp.translate("MOBAPPSTORE_APP_READY"),"C",0,0)%>+'" src="'+imageurl+'"></img>';
  } else if (state == 1 || state == 2) { //modificata o nuova
    var title = <%=Library.ToJSValue(sp.translate("ADMIN_DATABASE_RUN"),"C",0,0)%>
    if (state==1)
    	imageurl = "../images/spadministration_mobapp_gen.png";
   	else
      imageurl = "../images/spadministration_mobapp_new.png";
    return '<img title="'+title+'" src="'+imageurl+'"></img>';
  }   
}
function getStateAction(appName, state, type) {
  if (state == 1 || state == 2) { //modificata o nuova
    this.admin(appName,type);
  }   
}
function admin(appName, type) {
  this.appNames.Value(appName);
  this.forceCreateFile.Value(false);
  this.ignoreFile.Value(false);
  this.admin_app.Link();
  
}
function admin_app_Executed(okSave,cError){
  if (okSave=='true') {
	  this.MC_Grid.GoToKey(this.appNames.Value());
    if (this.MC_Grid.Get('oatoadmin')==2) {
      this.afterSave();
    } else {
  		this.MC_Grid.Set("oatoadmin",0);
    	this.MC_Grid.InToDatasource(this.SDP_Grid);
      this.RefreshGrid();
    }
  } else if (this.forceCreateFile.Value()!=true){
    var _this=this;
    WindowConfirm(cError +'\nRetry?', function(res){
      if (res) {
        _this.forceCreateFile.Value(true);
        _this.ignoreFile.Value(true);
        _this.admin_app.Link();
      }
    });
  } else {
    alert(cError);
  }
}
function getTypeImage(type){
  if(type==1) 
	  return "<img title='"+FormatMsg('MOBAPPSTORE_TYPE_SYSTEM')+"' src='<%=sp.getThemedImage("../images/mobapp_sys.png")%>'>";
  if(type==2)
    return "<img title='"+FormatMsg('MOBAPPSTORE_TYPE_USER')+"' src='<%=sp.getThemedImage("../images/mobapp_user.png")%>'>";
  return "";  
}
function afterSave(){
  this.MC_Grid.Value( this.SPL_Grid.Link() );
  this.MC_Grid.InToDatasource( this.SDP_Grid )
	this.RefreshGrid();
}
function manage_apps_Deleted(bResult){
  this.afterSave();
}
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_mobapp_Static.call(window.<%=idPortlet%>);
window.<%=idPortlet%>.on_SPManageMobAppStore_savedEntity=function(parmsObj){<%=idPortlet%>.SPManageMobAppStore_savedEntity.receiveFnc(parmsObj);}
ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_mobapp',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_mobapp');
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
sp.endPage("spadministration_mobapp");
}%>
<%! public String getJSPUID() { return "4239030922"; } %>