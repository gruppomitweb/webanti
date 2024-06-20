<%/*Type:Pagelet*/%>
<%/*Def:type||pagelet||id||pagelet||name||/../jsp-system/spadministration_pg_groups_users||template||5||width||100%||height||100%||css|| ||css_class||defaultMainContent||color|| ||align||left||security||none||on_security_failure||login||offline||false||shared_manifest|| ||manifest||Custom manifest||description|| ||roles|| |||type||column||id||header||name||header||width|| ||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||false|||type||column||id||col1||name||column1||width||20%||color|| ||align||left||valign||top||css_class||left-border-right||height|| ||padding|| ||collapsable||false|||type||column||id||col2||name||column2||width||80%||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||false|||type||column||id||footer||name||footer||width|| ||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||false|||type||portlet||id||../jsp-system/spadministration_group_treeview_portlet.jsp0||name||../jsp-system/spadministration_group_treeview_portlet.jsp||parameters|| ||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||condition|| ||toremove|| ||container||col1||position||0||margin_bottom||10px||draggable||false||css_class|| |||type||portlet||id||../jsp-system/spadministration_users_portlet.jsp1||name||../jsp-system/spadministration_users_portlet.jsp||parameters|| ||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||condition|| ||toremove|| ||container||col2||position||0||margin_bottom||10px||draggable||false||css_class|| |||*/%>
<%/*Template_type:5*/%>
<%/*Encoding:UTF-8*/%>
<%/*Description: */%>
<%@page import="java.util.*" %><%@page import="com.zucchetti.SPBridge.*" %><%@page import="com.zucchetti.PortalStudio.*" %>
<%@page import="com.zucchetti.sitepainter.Library" %><%@page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String PageletId= (request.getAttribute("forcePageletId")!= null ? (String)request.getAttribute("forcePageletId") : JSPLib.NewCPCCCHK());
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("forcePageletId",null);
String includerPageletId= (request.getAttribute("PageletId")!= null ? (String)request.getAttribute("PageletId") : "");%>
<!-- PageletName=spadministration_pg_groups_users -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"spadministration_pg_groups_users","UTF-8")) {return; }
 %><%request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".spadministration_pg_groups_users","spadministration_pg_groups_users");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","spadministration_pg_groups_users");
}
boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");
boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean tabs_libraries_included = null!=request.getAttribute("com.zucchetti.pagelet.tabs_libraries_included");
boolean titles_libraries_included = null!=request.getAttribute("javax.servlet.include.titles_libraries_included");
String queryString=JSPLib.getParametersList(request);
if(request.getAttribute("javax.servlet.include.query_string")!=null){
  if(request.getQueryString()!=null)
    queryString+="&"+request.getAttribute("javax.servlet.include.query_string");
   else
     queryString+=request.getAttribute("javax.servlet.include.query_string");
}
queryString=JSPLib.translateXSS(queryString);
if(!server_side_included && !client_side_included){%>
<!DOCTYPE html>
<html ps-stretch>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/spadministration_pg_groups_users.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<%if(!server_side_included && !client_side_included){
 sp.WriteStandardJSLibraries(out); %><link rel='shortcut icon' href='../favicon.ico' />
</head>
<body style='margin:0;'<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<script>
/*JS_MARKER_START*/
window.SPHpC=true;
window.<%=PageletId%>_pagelet_loading=true;
window.<%=PageletId%>_pagelet_structure={};
if(!window.portlet_list)	window.portlet_list=[];
if(!window.Pagelet_mapId)	window.Pagelet_mapId={};
var m_cThemePath='<%=sp.getSkin()%>';
/*JS_MARKER_END*/
</script>
<%if(!pagelet_yet_included && !client_side_included){
  String userAgent = sp.getGlobal( "i_cSPMobileDeviceUserAgent", "" );
  if ( Library.Empty( userAgent ) ) {
    userAgent = request.getHeader( "User-Agent" );
  }
  if ( Library.IsIAR( userAgent ) ) {%>
<script src='../<%=SPPrxycizer.proxycizedPath("splocalstorage.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("spstatusmanager.js")%>'></script>
<%}%>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath("styles/pagelet.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<script>
ZtVWeb.SetWebRootURL('<%=JSPLib.SPWebRootURL(request)%>');
ZtVWeb.ViewType(<%=Library.GetViewType(request)%>)
ZtVWeb.SetTheme('<%=sp.getSkin()%>');
ZtVWeb.SetLanguage('<%=sp.getLanguage()%>');
</script>
<script src='../<%=SPPrxycizer.proxycizedPath("PageletLib.js")%>'></script>
<%if(Library.IsMobile(request)){%><script>LibJavascript.RequireLibrary('../<%=SPPrxycizer.proxycizedPath("PageletLib.mobile.js")%>');
LibJavascript.RequireLibrary('../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.mobile.js")%>');
LibJavascript.RequireLibrary('../<%=SPPrxycizer.proxycizedPath("spmobilelib.js")%>');
</script><%}
request.setAttribute("ZtVWeb_included","true");
}%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=PageletId%>','spadministration_pg_groups_users','pageletObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<div id="<%=PageletId%>_table_cont" class="ps_table_cont"><table class='defaultMainContent_body' width='100%' height='100%' cellpadding='0' cellspacing='0'><tr><td align='left' valign='top'>
<table class='defaultMainContent' width='100%' height='100%' style='' align='left' border='0' cellspacing='0' cellpadding='0'>
<tr><td valign='top' width='100%' height='100%'>
<table width='100%' height='100%' cellpadding='0' cellspacing='0'><tr>
<%String droplet_column1=PageletId+"_pagelet_column1";%>
<td class='left-border-right'  id='<%=PageletId%>_pagelet_column1' width='20%' height=' '  valign='top' align='left'>
<%
request.setAttribute("PageletId",PageletId);
String ID_SEP;
String CONTAINER_SUFFIX;
String CONTENT_SUFFIX;
String uid;
String resource;
String container_id;
String content_name;
String content_id;
String content_title;
String res_url;


ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId+ID_SEP+"spadministration_group_treeview_portlet";
resource="spadministration_group_treeview_portlet";
container_id=uid + ID_SEP + resource + ID_SEP + CONTAINER_SUFFIX;
content_name=uid + ID_SEP + "../jsp-system/spadministration_group_treeview";
content_id=uid + ID_SEP + resource + ID_SEP + CONTENT_SUFFIX;
content_title="";
request.setAttribute("SPParentObjId",container_id);
res_url="../jsp-system/spadministration_group_treeview_portlet.jsp"+((("../jsp-system/spadministration_group_treeview_portlet.jsp").indexOf("?")==-1) ? "?" : "&")+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','../jsp-system/spadministration_group_treeview_portlet.jsp','staticObj','<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("../jsp-system/spadministration_group_treeview_portlet.jsp")%> style='margin-bottom:10px;' >
<div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=PageletId%>_spadministration_group_treeview_portlet']={'loaded': false, 'type': 'portlet', 'name': 'spadministration_group_treeview_portlet','containerId':'<%=JSPLib.ToJSValue(container_id)%>', 'contentId':'<%=JSPLib.ToJSValue(content_id)%>', 'url': '../jsp-system/spadministration_group_treeview', 'inIframe': false};
/*JS_MARKER_END*/
</script>
<%res_url += "&"+queryString; %>

<%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/../jsp-system/spadministration_group_treeview_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/../jsp-system/spadministration_group_treeview_portlet.jsp",true))
    com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/../jsp-system/spadministration_group_treeview_portlet.jsp",false);
%>
</div>
</div>
<script type='text/javascript'>
/*JS_MARKER_START*/
window.portlet_list.push('../jsp-system/spadministration_group_treeview');
/*JS_MARKER_END*/
</script>
</td>
<%String droplet_column2=PageletId+"_pagelet_column2";%>
<td class='columnright'  id='<%=PageletId%>_pagelet_column2' width='80%' height=' '  valign='top' align='left'>
<%
request.setAttribute("PageletId",PageletId);


ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId+ID_SEP+"spadministration_users_portlet";
resource="spadministration_users_portlet";
container_id=uid + ID_SEP + resource + ID_SEP + CONTAINER_SUFFIX;
content_name=uid + ID_SEP + "../jsp-system/spadministration_users";
content_id=uid + ID_SEP + resource + ID_SEP + CONTENT_SUFFIX;
content_title="";
request.setAttribute("SPParentObjId",container_id);
res_url="../jsp-system/spadministration_users_portlet.jsp"+((("../jsp-system/spadministration_users_portlet.jsp").indexOf("?")==-1) ? "?" : "&")+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','../jsp-system/spadministration_users_portlet.jsp','staticObj','<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("../jsp-system/spadministration_users_portlet.jsp")%> style='margin-bottom:10px;' >
<div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=PageletId%>_spadministration_users_portlet']={'loaded': false, 'type': 'portlet', 'name': 'spadministration_users_portlet','containerId':'<%=JSPLib.ToJSValue(container_id)%>', 'contentId':'<%=JSPLib.ToJSValue(content_id)%>', 'url': '../jsp-system/spadministration_users', 'inIframe': false};
/*JS_MARKER_END*/
</script>
<%res_url += "&"+queryString; %>

<%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/../jsp-system/spadministration_users_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/../jsp-system/spadministration_users_portlet.jsp",true))
    com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/../jsp-system/spadministration_users_portlet.jsp",false);
%>
</div>
</div>
<script type='text/javascript'>
/*JS_MARKER_START*/
window.portlet_list.push('../jsp-system/spadministration_users');
/*JS_MARKER_END*/
</script>
</td>
</tr></table>
</td></tr>
</table>
</td></tr></table></div>
<script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this,{id:'<%=PageletId%>',stretch:'true'});
	this['spadministration_group_treeview_portlet']= new ZtVWeb.StaticCtrl(this,{ "name":"spadministration_group_treeview_portlet","id":"spadministration_group_treeview_portlet", "src":"../jsp-system/spadministration_group_treeview_portlet.jsp", "in_iframe":"false"});
	this['spadministration_users_portlet']= new ZtVWeb.StaticCtrl(this,{ "name":"spadministration_users_portlet","id":"spadministration_users_portlet", "src":"../jsp-system/spadministration_users_portlet.jsp", "in_iframe":"false"});
  for(var i=0; i<window.portlet_list.length; i++){
    var p = window.portlet_list[i];
    this[p]=ZtVWeb.getPortlet(p)
  }
  this.planName='<%=(Library.Empty(planName)?"":planName)%>';
  this.Calc= function(){
    if(!Empty(this.planName) && window[this.planName])
      window[this.planName].Calc(this);
  }
  /*ActionCode*/
  
  
  /*End ActionCode*/
};
<%if(!pagelet_yet_included && !client_side_included){%>
function getPagelet(){return window.<%=PageletId%>;}
<%}%>
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'spadministration_pg_groups_users','<%=includerPageletId%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html><%}%>
