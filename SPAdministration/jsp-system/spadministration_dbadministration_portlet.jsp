<%/*Encoding:UTF-8*/%>
<%/*Type:Portlet*/%>
<%//Def:[{"actioncode":"m_cTarget = '\u003c%= JSPLib.ToJSValue((String) (Class.forName(\"SPControlPanel\").getField(\"m_cTarget\").get(null))) %\u003e';\nfunction this_Loaded(){\n  var customToolbar=this.getTitlePortlet();\n  customToolbar.AppendButton({\n  \timage:SPTheme.controlPanelHelp || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fhelp.png\",pageContext.getServletContext())%\u003e',\n    action:'javascript:Help()',\n    title:FormatMsg(\"ADMIN_HELP_TITLE\"),\n    tooltip:FormatMsg(\"ADMIN_HELP_TITLE\")\n  })  \n  if(m_cTarget != \"_blank\") {\n    customToolbar.AppendButton({\n      image:SPTheme.controlPanelBack || '\u003c%=sp.getThemedImage(\"..\u002fimages\u002fcustom_toolbar\u002fback.png\",pageContext.getServletContext())%\u003e',\n      action:'..\u002fservlet\u002fSPControlPanel',\n      title:FormatMsg(\"MSG_BACK\"),\n      tooltip:FormatMsg(\"ADMIN_BACK_TO_CP\")\n    })\n  }\n  customToolbar.SetTitle(FormatMsg(\"CP_DATABASE\"));\n  customToolbar.RearrangeAll();\n}\nm_cProgName=\"sptables\";\n\nfunction imageExtender_Click(){\n\tthis.splinker_spextender.Link();\n}\n\nfunction label_TableExtender_Click(){\n\tthis.splinker_spextender.Link();\n}\n\nfunction imageRunDBAdmin_Click(){\n\tthis.splinkerDBAdmin.Link();\n}\n\nfunction label_DBAdmin_Click(){\n\tthis.splinkerDBAdmin.Link();\n}\n\nfunction img_database_server_Click(){\n\tthis.splinker_dbserver.Link();\n}\n\nfunction label_database_server_Click(){\n\tthis.splinker_dbserver.Link();\n}","adaptive":"","altInterfaceFor":"","bg_image":"","bg_image_position":"","bg_image_repeat":"","bg_image_size":"","cache_in_post":"false","cache_time":"","color":"","container_bg_color":"","container_bg_image":"","container_bg_pos":"","css":"styles\u002fspadministration_skin.ce.css","css_class":"portlet-white-default","css_code":"[]","custom":"","description":"","fixed_top":"","form_action":"","form_enctype":"default","form_target":"","form_type":"false","grapesCode":"\u003cbody\u003e{{ @img_database_server }}{{ @imageRunDBAdmin }}{{ @imageExtender }}{{ @label_DBAdmin }}{{ @label_TableExtender }}{{ @label_database_server }}{{ @imageRunDBAdmin }}{{ @img_database_server }}{{ @imageExtender }}{{ @label_DBAdmin }}{{ @label_TableExtender }}{{ @label_database_server }}{{ @imageRunDBAdmin_Copy }}{{ @imageRunDBAdmin }}{{ @img_database_server }}{{ @imageExtender }}{{ @label_DBAdmin }}{{ @label_TableExtender }}{{ @label_database_server }}{{ @imageRunDBAdmin }}{{ @img_database_server }}{{ @imageExtender }}{{ @label_DBAdmin }}{{ @label_TableExtender }}{{ @label_database_server }}{{ @imageRunDBAdmin }}{{ @img_database_server }}{{ @imageExtender }}{{ @label_DBAdmin }}{{ @label_TableExtender }}{{ @label_database_server }}{{ @img_database_server_Copy }}\u003c\u002fbody\u003e","grapesCss":"","h":"137","hsl":"","htmlcode":"\n\u003cdiv class=\"DBAdmin-item-container\"\u003e\n\u003cdiv class=\"DBAdmin-item\"\u003e \n  {{ @img_database_server }} \n  {{ @label_database_server }}  \n\u003c\u002fdiv\u003e\n\u003cdiv class=\"DBAdmin-item\" \u003e\n  {{ @imageRunDBAdmin }} \n  {{ @label_DBAdmin }} \n\u003c\u002fdiv\u003e\n\u003cdiv class=\"DBAdmin-item\"\u003e\n  {{ @imageExtender }} \n  {{ @label_TableExtender }} \n\u003c\u002fdiv\u003e\n\u003c\u002fdiv\u003e\n\n","included_font":"[]","language":"true","layout_step":"","layout_steps_values":"{}","lock_items":"","manifest":"Custom manifest","max_w":"","min_w":"","mode":"HTML","my_library":"","offline":"false","on_security_failure":"login","page_layer":"","pages":"1","pagesProp":"[{\"h\":\"137\",\"w\":\"100%\",\"title\":\"\",\"layer\":\"\",\"layout_steps_values\":{}}]","pages_names":"","portlet_position":"align center","positioning":"absolute","roles":"","sec_heredity":"","security":"logged","selectZone":"","server_cache_time":"","shared_manifest":"false","sp_theme":"true","steps":"","stretch_height":"true","tabstrip_class":"","tabstrip_hidden":"","tag":"","title":"default","title_block":"","title_url":"","type":"Form","v_line":"800","version":"37","w":"100%","wizard":""},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"24","help_tips":"ADMIN_DATABASE_ADMINISTRATION","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"imageRunDBAdmin","page":"1","path_type":"themed","rapp":"","sequence":"1","server_side":"","spuid":"","src":"..\u002fimages\u002fdbadmin.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"24","wireframe_props":"","x":"133","y":"57","zindex":"1","zone":""},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"24","help_tips":"ADMIN_DATABASE_SERVER","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"img_database_server","page":"1","path_type":"themed","rapp":"","sequence":"2","server_side":"","spuid":"","src":"..\u002fimages\u002fdbserver.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"24","wireframe_props":"","x":"394","y":"80","zindex":"1","zone":""},{"alt":"","anchor":"top-left","bounded_position":"","class_Css":"image","create_undercond":"","ctrlOfVariant":"","dataobj":"","edit_undercond":"","field":"","fixed":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_size":"","h":"24","help_tips":"ADMIN_DATABASE_TABLE_EXTENDER","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keep_proportions":"true","layer":"false","layout_steps_values":"{}","name":"imageExtender","page":"1","path_type":"themed","rapp":"","sequence":"3","server_side":"","spuid":"","src":"..\u002fimages\u002fextender.png","srchover":"","tabindex":"","target":"","type":"Image","type_submit":"false","w":"24","wireframe_props":"","x":"656","y":"68","zindex":"1","zone":""},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"15","heading":"","help_tips":"ADMIN_DATABASE_ADMINISTRATION","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_DBAdmin","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"4","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ADMIN_DATABASE_ADMINISTRATION","w":"260","wireframe_props":"align,value,n_col","x":"-28","y":"100","zindex":"1","zone":""},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"15","heading":"","help_tips":"ADMIN_DATABASE_TABLE_EXTENDER","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_TableExtender","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"5","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ADMIN_DATABASE_TABLE_EXTENDER","w":"260","wireframe_props":"align,value,n_col","x":"538","y":"91","zindex":"1","zone":""},{"align":"center","anchor":"top-left","assoc_input":"","bg_color":"transparent","calculate":"","class_Css":"label","create_undercond":"","ctrlOfVariant":"","dataobj":"","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":"false","field":"","fixed":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":"15","heading":"","help_tips":"ADMIN_DATABASE_SERVER","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":"false","layout_steps_values":"{}","n_col":"1","name":"label_database_server","nowrap":"false","page":"1","picture":"","rapp":"","sanitize":"","sanitize_tags":"","sequence":"6","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template_code":"","type":"Label","value":"ADMIN_DATABASE_SERVER","w":"260","wireframe_props":"align,value,n_col","x":"271","y":"111","zindex":"1","zone":""},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_spextender","offline":"false","page":"1","parms":"","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"900","progressbar":"","refresh":"","sequence":"7","servlet":"..\u002fspextender","target":"","type":"SPLinker","w":"160","x":"14","y":"241"},{"allowedentities":"..\u002fjsp-system\u002fspadministration_db_tables_portlet.jsp","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinker_dbserver","offline":"false","page":"1","parms":"","popup":"false","popup_height":"350","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":"","refresh":"","sequence":"8","servlet":"..\u002fjsp-system\u002fspadministration_db_tables_portlet.jsp","target":"_self","type":"SPLinker","w":"160","x":"14","y":"266"},{"allowedentities":"","async":"false","check_exp":"","ctrlOfVariant":"","decrypted_parms":"","decrypted_parms_pwd":"","entity_type":"","h":"20","m_cAction":"","name":"splinkerDBAdmin","offline":"false","page":"1","parms":"action","popup":"true","popup_height":"580","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"780","progressbar":"","refresh":"","sequence":"9","servlet":"SPDBAdministration","target":"","type":"SPLinker","w":"160","x":"14","y":"291"},{"calculate":"","ctrlOfVariant":"","dataobj":"","decrypt":"","decrypt_pwd":"","encrypt":"","encrypt_pwd":"","field":"","h":"20","init":"","init_par":"'dbadmin_preview'","name":"action","page":"1","reactive":"","sequence":"10","server_side":"false","type":"Variable","typevar":"character","w":"160","x":"14","y":"341"}]%>
<%/*Description:*/%>
<%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String m_cJSPUID=getJSPUID();%>
<%@ page import="org.json.*" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tlt" prefix="PS" %>
<%String m_cTITLEUID=JSPLib.getPortletTitleUid(m_cJSPUID);
String idPortlet=sp.getPortletId(request,sp.getParameter("ForcedPortletUID",JSPLib.NewCPCCCHK(5)));
String PageletId =        (request.getAttribute("PageletId")        != null ? (String)request.getAttribute("PageletId"       ) : sp.getParameter("PageletId"       ,"") );
String SPPortletTitleId = (request.getAttribute("SPPortletTitleId") != null ? (String)request.getAttribute("SPPortletTitleId") : sp.getParameter("SPPortletTitleId","") );
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
String m_cVariant= sp.getParameter("m_cVariant","");
String m_cVariantFolder= sp.getParameter("m_cVariantFolder","");
request.setAttribute("com.zucchetti.sitepainter.PortalStudio.getCryptPwd",JSPLib.NewCPCCCHK(6));
if(!Library.Empty(m_cVariant)){
	if(Library.Empty(sp.getParameter("SpWireframe","")+sp.getParameter("SpCssCode",""))){
		JSPLib.GenerateVariant("spadministration_dbadministration", m_cVariantFolder, m_cVariant, m_cJSPUID);
	}
	request.setAttribute("com.zucchetti.sitepainter.portalstudio.PortalStudioVariant.JSPUID", "com.zucchetti.sitepainter.portalstudio.PortalStudioVariant.JSPUID");
	Library.Include(request, response, m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp", true);
	m_cJSPUID += (String)request.getAttribute("com.zucchetti.sitepainter.portalstudio.PortalStudioVariant.JSPUID");
}%>

<%if(sp.getParameter("SpCssCode","").equals(m_cJSPUID)){
Library.SetMimeType(response,"text/css");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
%>
.spadministration_dbadministration_container {
  height:100%;
  overflow:auto;
}
.spadministration_dbadministration_title_container {
  margin: auto;
}
.spadministration_dbadministration_portlet{
  position:relative;
  margin: auto;
  min-width:800px;
  height:100%;
}
.spadministration_dbadministration_portlet[Data-page="1"]{
  height:100%;
  width:100%;
}

<%if (!Library.Empty(m_cVariant) ){
	out.flush();
	request.setAttribute("SpVariantCode","style");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%><%}else if(sp.getParameter("SpWireframe","").equals("true")){
String containerId=sp.getParameter("containerID",idPortlet);
Library.SetMimeType(response,"text/html");
response.setDateHeader("Last-Modified",new Date().getTime() - 604800000L);
response.setDateHeader("Expires", new Date().getTime() + 604800000L);
response.setHeader("Cache-Control","public");
PrintWireFrame(containerId,out);
%>
<%!
void PrintWireFrame(String containerId, java.io.Writer out) throws java.lang.Throwable {
 String def="[{\"h\":\"137\",\"layout_steps_values\":{},\"pages_names\":\"\",\"steps\":\"\",\"title\":\"default\",\"type\":\"Form\",\"v_line\":\"800\",\"w\":\"100%\",\"wizard\":\"\"},{\"anchor\":\"top-left\",\"h\":\"24\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"24\",\"x\":\"133\",\"y\":\"57\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"24\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"24\",\"x\":\"394\",\"y\":\"80\",\"zindex\":\"1\"},{\"anchor\":\"top-left\",\"h\":\"24\",\"layout_steps_values\":{},\"page\":\"1\",\"type\":\"Image\",\"w\":\"24\",\"x\":\"656\",\"y\":\"68\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_DATABASE_ADMINISTRATION\",\"w\":\"260\",\"x\":\"-28\",\"y\":\"100\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_DATABASE_TABLE_EXTENDER\",\"w\":\"260\",\"x\":\"538\",\"y\":\"91\",\"zindex\":\"1\"},{\"align\":\"center\",\"anchor\":\"top-left\",\"h\":\"15\",\"layout_steps_values\":{},\"n_col\":\"1\",\"page\":\"1\",\"type\":\"Label\",\"value\":\"ADMIN_DATABASE_SERVER\",\"w\":\"260\",\"x\":\"271\",\"y\":\"111\",\"zindex\":\"1\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"14\",\"y\":\"241\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"14\",\"y\":\"266\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"SPLinker\",\"w\":\"160\",\"x\":\"14\",\"y\":\"291\"},{\"h\":\"20\",\"page\":\"1\",\"type\":\"Variable\",\"w\":\"160\",\"x\":\"14\",\"y\":\"341\"}]";
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
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_dbadministration","UTF-8")) {return; }
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
<html  ps-stretch>
<%}
if(!included){%>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_dbadministration_portlet.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}
 sp.WritePortletJSLibraries(request, out, false,false); %><script>
/*JS_MARKER_START*/
<%PrintTranslations(out, sp, request, response, idPortlet);%>
/*JS_MARKER_END*/
</script>
<% sp.WritePortalStudioCSS(request, out); 
if(Library.IsMobile(request)){%><%}%>
<link id='<%=idPortlet%>_link_css' href='<%=JSPLib.getJSPSelfPath(request)%>?SpCssCode=<%=m_cJSPUID%>&m_cVariant=<%=sp.getParameter("m_cVariant","")%>&m_cVariantFolder=<%=sp.getParameter("m_cVariantFolder","")%>' onload="
  requestAnimationFrame( function() {
    this.setAttribute('css-applied', 'true');
    this.dispatchEvent(new CustomEvent('cssApplied'));
  }.bind(this));"
 rel='stylesheet' type='text/css'/>
<style>

</style>
<script>
/*JS_MARKER_START*/
<%String variant, variantThemed;%><% variant=SPPrxycizer.getVariant("styles/spadministration_skin.ce.min.css");
if(variant != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath("styles/spadministration_skin.ce.min.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}
 variantThemed=SPPrxycizer.getThemedVariant("styles/spadministration_skin.ce.min.css", sp.getSkin());
if(variantThemed != null) { %>ZtVWeb.RequireCSS('<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/styles/spadministration_skin.ce.min.css", SPPrxycizer.Mode.QUERYSTRING)%>');
<%}%>
/*JS_MARKER_END*/
</script>

<%if (!Library.Empty(m_cVariant) ){
	out.flush();
	request.setAttribute("SpVariantCode","css_lib");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}

if (!Library.Empty(m_cVariant) ){
	out.flush();
	request.setAttribute("SpVariantCode","lib");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=idPortlet%>','spadministration_dbadministration','portletObj','<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%String label_DBAdmin= "ADMIN_DATABASE_ADMINISTRATION";
String label_TableExtender= "ADMIN_DATABASE_TABLE_EXTENDER";
String label_database_server= "ADMIN_DATABASE_SERVER";
String action="dbadmin_preview";
try{
request.setAttribute("action",action);%>

<%if (!Library.Empty(m_cVariant) ){
	out.flush();
	request.setAttribute("SpVariantCode","jsp_init");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%><%%>

<%if (!Library.Empty(m_cVariant) ){
	out.flush();
	request.setAttribute("SpVariantCode","local_vars");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%><%if(!included){%>
<link rel='shortcut icon' href='../favicon.ico' />
</head>
<%}
if(!included){%>
<body style="margin:0;background-color:transparent;"<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<div id='<%=idPortlet%>_<%=m_cTITLEUID%>_title_container' class='spadministration_dbadministration_title_container' style='width:100%'>
<%out.flush(); 
 if(!Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 if(!Library.includeResource(request,response,"/jsp-decorators/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",true)) 
 Library.includeResource(request,response,"/jsp/custom_toolbar_portlet.jsp?ForcedPortletUID="+idPortlet+"_"+m_cTITLEUID+"",false);%>
</div>
<div id='<%=idPortlet%>_container' class='spadministration_dbadministration_container'>
<div id='<%=idPortlet%>' portlet_id='<%=idPortlet%>' align='left' class='spadministration_dbadministration_portlet portlet-white-default' style='opacity:0.001'>
<%if(sp.isLogged()){
 if(sp.isInGroup(1) && sp.getGlobal("g_EditPortlet",false)==true){%>
<script>
ZtVWeb.AddPortletToEdit('spadministration_dbadministration','<%=idPortlet%>',false,'');
</script><%}}%>
<c:set var="idPortlet" value="<%=idPortlet%>" scope="page" />

<%if ( Library.Empty(m_cVariant) ){
%>
<div class="DBAdmin-item-container">
<div class="DBAdmin-item"> 
  <div id='<%=idPortlet%>_img_database_server'><a id='<%=idPortlet%>_img_database_serverhref' href='javascript:void(0)' target='_self'><img id='<%=idPortlet%>_img_database_server_img' class='image img_database_server_ctrl' src="<%=sp.getThemedImage("../images/dbserver.png",pageContext.getServletContext())%>" border='0' ></a>
</div> 
  <span id='<%=idPortlet%>_label_database_server'  formid='<%=idPortlet%>' ps-name='label_database_server'    class='label label_database_server_ctrl'><div id='<%=idPortlet%>_label_database_servertbl' style='width:100%;'><a id='<%=idPortlet%>_label_database_serverhref' title='<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_SERVER"),false,true)%>' href='javascript:void(0)'  ><%=JSPLib.ToHTML(sp.translate("ADMIN_DATABASE_SERVER"))%></a></div></span>
  
</div>
<div class="DBAdmin-item" >
  <div id='<%=idPortlet%>_imageRunDBAdmin'><a id='<%=idPortlet%>_imageRunDBAdminhref' href='javascript:void(0)' target='_self'><img id='<%=idPortlet%>_imageRunDBAdmin_img' class='image imageRunDBAdmin_ctrl' src="<%=sp.getThemedImage("../images/dbadmin.png",pageContext.getServletContext())%>" border='0' ></a>
</div> 
  <span id='<%=idPortlet%>_label_DBAdmin'  formid='<%=idPortlet%>' ps-name='label_DBAdmin'    class='label label_DBAdmin_ctrl'><div id='<%=idPortlet%>_label_DBAdmintbl' style='width:100%;'><a id='<%=idPortlet%>_label_DBAdminhref' title='<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_ADMINISTRATION"),false,true)%>' href='javascript:void(0)'  ><%=JSPLib.ToHTML(sp.translate("ADMIN_DATABASE_ADMINISTRATION"))%></a></div></span>
 
</div>
<div class="DBAdmin-item">
  <div id='<%=idPortlet%>_imageExtender'><a id='<%=idPortlet%>_imageExtenderhref' href='javascript:void(0)' target='_self'><img id='<%=idPortlet%>_imageExtender_img' class='image imageExtender_ctrl' src="<%=sp.getThemedImage("../images/extender.png",pageContext.getServletContext())%>" border='0' ></a>
</div> 
  <span id='<%=idPortlet%>_label_TableExtender'  formid='<%=idPortlet%>' ps-name='label_TableExtender'    class='label label_TableExtender_ctrl'><div id='<%=idPortlet%>_label_TableExtendertbl' style='width:100%;'><a id='<%=idPortlet%>_label_TableExtenderhref' title='<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_TABLE_EXTENDER"),false,true)%>' href='javascript:void(0)'  ><%=JSPLib.ToHTML(sp.translate("ADMIN_DATABASE_TABLE_EXTENDER"))%></a></div></span>
 
</div>
</div>


<%}else{
	out.flush();
	request.setAttribute("SpVariantCode","html");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%></div>
</div>
<script>
/*JS_MARKER_START*/
ZtVWeb.addPortlet('<%=idPortlet%>','spadministration_dbadministration');
<%!
void PrintTranslations(java.io.Writer out, Sitepainter sp, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String idPortlet) throws java.lang.Throwable {
	String m_cVariantFolder = request.getAttribute("m_cVariantFolder") != null ? (String)request.getAttribute("m_cVariantFolder") : "";
	String m_cVariant = request.getAttribute("m_cVariant") != null ? (String)request.getAttribute("m_cVariant") : "";
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_BACK_TO_CP",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_BACK_TO_CP"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("ADMIN_HELP_TITLE",true)+","+JSPLib.ToJSValue(sp.translate("ADMIN_HELP_TITLE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("CP_DATABASE",true)+","+JSPLib.ToJSValue(sp.translate("CP_DATABASE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_BACK",true)+","+JSPLib.ToJSValue(sp.translate("MSG_BACK"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_DELETING",true)+","+JSPLib.ToJSValue(sp.translate("MSG_DELETING"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_PROCEED_WITH_DELETE",true)+","+JSPLib.ToJSValue(sp.translate("MSG_PROCEED_WITH_DELETE"),true)+");\n");
out.write("ZtVWeb.AddTranslation("+JSPLib.ToJSValue("MSG_ROUTINE_WAIT",true)+","+JSPLib.ToJSValue(sp.translate("MSG_ROUTINE_WAIT"),true)+");\n");
}/**/%>
window.<%=idPortlet%>=new function(){
var m_cSPPageletId = '<%=JSPLib.ToJSValue(PageletId,false,true)%>';
var m_cSPPortletTitleId = '<%=JSPLib.ToJSValue(SPPortletTitleId,false,true)%>';
ZtVWeb.newForm(this,'<%=idPortlet%>','spadministration_dbadministration',["800"],["137"],'portlet-white-default',<%=sp.isOfflineInstallation()%>,false,m_cSPPageletId,'', '','<%=m_cTITLEUID%>','',{},false,true,1,m_cSPPortletTitleId, 'HTML',[{"layout_steps_values":{},"w":"800","h":"137","title":"","layer":""}]);

<%if ( Library.Empty(m_cVariant) ){
%>this.imageRunDBAdmin=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image imageRunDBAdmin_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imageRunDBAdmin","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_ADMINISTRATION"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"imageRunDBAdmin","page":1,"path_type":"themed","server_side":"","spuid":"","src":"<%=sp.getThemedImage("../images/dbadmin.png",pageContext.getServletContext())%>","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":24,"x":133,"y":57,"zindex":"1"});
this.img_database_server=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image img_database_server_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_img_database_server","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_SERVER"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"img_database_server","page":1,"path_type":"themed","server_side":"","spuid":"","src":"<%=sp.getThemedImage("../images/dbserver.png",pageContext.getServletContext())%>","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":24,"x":394,"y":80,"zindex":"1"});
this.imageExtender=new ZtVWeb._IC(this,{"alt":"","anchor":"top-left","boundedPosition":"","class_Css":"image imageExtender_ctrl","create_undercond":"","ctrlid":"<%=idPortlet%>_imageExtender","edit_undercond":"","field":"","font_color":"","font_color_hover":"","font_image":"","font_image_hover":"","font_name":"","font_path":"","font_size":"","h":24,"help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_TABLE_EXTENDER"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","img_type":"default","keepProportions":"true","layer":false,"layout_steps_values":{},"name":"imageExtender","page":1,"path_type":"themed","server_side":"","spuid":"","src":"<%=sp.getThemedImage("../images/extender.png",pageContext.getServletContext())%>","srchover":"","tabindex":"","target":"_self","type":"Image","type_submit":"false","w":24,"x":656,"y":68,"zindex":"1"});
this.label_DBAdmin=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_DBAdmin","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":15,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_ADMINISTRATION"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_DBAdmin","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_DBAdmin),false,true)%>","type":"Label","w":260,"x":-28,"y":100,"zindex":"1"});
this.label_TableExtender=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_TableExtender","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":15,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_TABLE_EXTENDER"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_TableExtender","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_TableExtender),false,true)%>","type":"Label","w":260,"x":538,"y":91,"zindex":"1"});
this.label_database_server=new ZtVWeb._LC(this,{"align":"center","anchor":"top-left","assoc_input":"","calculate":"","class_Css":"label","create_undercond":"","ctrlid":"<%=idPortlet%>_label_database_server","draggable":"","draggable_name":"","droppable":"","droppable_name":"","edit_undercond":"","enable_HTML":false,"field":"","font":"Verdana","font_color":"#000000","font_size":"9pt","font_weight":"normal","fontpct":"","h":15,"heading":"","help_tips":"<%=JSPLib.ToJSValue(sp.translate("ADMIN_DATABASE_SERVER"),false,true)%>","hide":"false","hide_undercond":"","href":"javascript:void(0)","init":"","layer":false,"layout_steps_values":{},"n_col":1,"name":"label_database_server","nowrap":"false","page":1,"picture":"","sanitize":"","sanitize_tags":"","server_side":"","shrinkable":"","spuid":"","tabindex":"","target":"","template":"","text":"<%=JSPLib.ToJSValue(sp.translate(label_database_server),false,true)%>","type":"Label","w":260,"x":271,"y":111,"zindex":"1"});
this.splinker_spextender=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_spextender","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_spextender","offline":false,"page":1,"parms":"","popup":"true","popup_height":"700","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"900","progressbar":false,"refresh":"","servlet":"..\u002fspextender","target":"","type":"SPLinker","w":160,"x":14,"y":241});
this.splinker_spextender.m_cID='<%=JSPLib.cmdHash("entity,../spextender",request.getSession())%>';
this.splinker_dbserver=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"<%=JSPLib.encrypt("../jsp-system/spadministration_db_tables_portlet.jsp",request,"xxxx")%>","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinker_dbserver","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinker_dbserver","offline":false,"page":1,"parms":"","popup":"false","popup_height":"350","popup_maximized":"false","popup_scroll":"false","popup_style":"layer","popup_width":"600","progressbar":false,"refresh":"","servlet":"..\u002fjsp-system\u002fspadministration_db_tables_portlet.jsp","target":"_self","type":"SPLinker","w":160,"x":14,"y":266});
this.splinker_dbserver.m_cID='<%=JSPLib.cmdHash("entity,../jsp-system/spadministration_db_tables_portlet.jsp",request.getSession())%>';
this.splinkerDBAdmin=new ZtVWeb.SPLinkerCtrl(this,{"action":"","allowedEntities":"","anchor":"","async":false,"check_exp":"","ctrlid":"<%=idPortlet%>_splinkerDBAdmin","decrypted_parms":"","entity_type":"","force_msg_id":false,"h":20,"hide":"false","layer":false,"layout_steps_values":{},"m_cAltInterface":"","name":"splinkerDBAdmin","offline":false,"page":1,"parms":"action","popup":"true","popup_height":"580","popup_maximized":"false","popup_scroll":"false","popup_style":"by skin","popup_width":"780","progressbar":false,"refresh":"","servlet":"SPDBAdministration","target":"","type":"SPLinker","w":160,"x":14,"y":291});
this.splinkerDBAdmin.m_cID='<%=JSPLib.cmdHash("entity,SPDBAdministration",request.getSession())%>';
this.action=new ZtVWeb._VC(this,'action',null,'character','<%=JSPLib.ToJSValue(action,false,true)%>',false,false);

<%}else{
	out.flush();
	request.setAttribute("SpVariantCode","ctrls");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%><%if(!Library.Empty(PageletId) ){%>
this.PageletCalc=function(){
  if(window['<%=JSPLib.ToJSValue(PageletId)%>'] && window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc ) {
  window['<%=JSPLib.ToJSValue(PageletId)%>'].Calc();
};
}
<%}%>

}
/*JS_MARKER_END*/
</script>
<%request.setAttribute("spadministration_dbadministration_firstinclusion",idPortlet);%>
<script>
/*JS_MARKER_START*/
window.spadministration_dbadministration_Static=function(){
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;
if(typeof imageExtender_Click !='undefined')this.imageExtender_Click=imageExtender_Click;
if(typeof label_TableExtender_Click !='undefined')this.label_TableExtender_Click=label_TableExtender_Click;
if(typeof imageRunDBAdmin_Click !='undefined')this.imageRunDBAdmin_Click=imageRunDBAdmin_Click;
if(typeof label_DBAdmin_Click !='undefined')this.label_DBAdmin_Click=label_DBAdmin_Click;
if(typeof img_database_server_Click !='undefined')this.img_database_server_Click=img_database_server_Click;
if(typeof label_database_server_Click !='undefined')this.label_database_server_Click=label_database_server_Click;

<%if ( Library.Empty(m_cVariant) ){
%><%if(!Library.Empty(PageletId) ){%>
this.this_Calc=function(){
  this.PageletCalc();
}
<%}%>

<%}else{
	out.flush();
	request.setAttribute("SpVariantCode","init");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%>m_cTarget = '<%= JSPLib.ToJSValue((String) (Class.forName("SPControlPanel").getField("m_cTarget").get(null))) %>';
function this_Loaded(){
  var customToolbar=this.getTitlePortlet();
  customToolbar.AppendButton({
  	image:SPTheme.controlPanelHelp || '<%=sp.getThemedImage("../images/custom_toolbar/help.png",pageContext.getServletContext())%>',
    action:'javascript:Help()',
    title:FormatMsg("ADMIN_HELP_TITLE"),
    tooltip:FormatMsg("ADMIN_HELP_TITLE")
  })  
  if(m_cTarget != "_blank") {
    customToolbar.AppendButton({
      image:SPTheme.controlPanelBack || '<%=sp.getThemedImage("../images/custom_toolbar/back.png",pageContext.getServletContext())%>',
      action:'../servlet/SPControlPanel',
      title:FormatMsg("MSG_BACK"),
      tooltip:FormatMsg("ADMIN_BACK_TO_CP")
    })
  }
  customToolbar.SetTitle(FormatMsg("CP_DATABASE"));
  customToolbar.RearrangeAll();
}
m_cProgName="sptables";
function imageExtender_Click(){
	this.splinker_spextender.Link();
}
function label_TableExtender_Click(){
	this.splinker_spextender.Link();
}
function imageRunDBAdmin_Click(){
	this.splinkerDBAdmin.Link();
}
function label_DBAdmin_Click(){
	this.splinkerDBAdmin.Link();
}
function img_database_server_Click(){
	this.splinker_dbserver.Link();
}
function label_database_server_Click(){
	this.splinker_dbserver.Link();
}
<%if (!Library.Empty(m_cVariant) ){
	out.flush();
	request.setAttribute("SpVariantCode","actioncode");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%>
this.dispatchEvent('HideUnderCondition');
this.dispatchEvent('EditUnderCondition');
}
/*JS_MARKER_END*/
</script>
<script>
/*JS_MARKER_START*/
window.spadministration_dbadministration_Static.call(window.<%=idPortlet%>);

<%if ( Library.Empty(m_cVariant) ){

}else{
	out.flush();
	request.setAttribute("SpVariantCode","observer");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}

if ( Library.Empty(m_cVariant) ){

}else{
	out.flush();
	request.setAttribute("SpVariantCode","script");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%>ZtVWeb.addPortletObj('<%=idPortlet%>','spadministration_dbadministration',<%=idPortlet%>);
ZtVWeb.portletLoaded(<%=idPortlet%>,'spadministration_dbadministration');
/*JS_MARKER_END*/
</script>
<%if(!included){%>
</body>
<%}
}finally{%>

<%if (!Library.Empty(m_cVariant) ){
	out.flush();
	request.setAttribute("SpVariantCode","finally");
	Library.includeResource(request,response,m_cVariantFolder+"/jsp-variants/spadministration_dbadministration/"+m_cVariant+"_variant.jsp?ForcedPortletUID="+idPortlet+"",false);
	request.removeAttribute("SpVariantCode");
}
%><%}
if(!included){%>
</html>
<%}
sp.endPage("spadministration_dbadministration");
}%>
<%! public String getJSPUID() { return "501108298"; } %>