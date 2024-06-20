<%/*Type:PageletEditor*/%>
<%//Def:[{"id":"pagelet","name":"pagelet","type":"pagelet","template":"7","cols_n":"12","rows_n":"3","width":"960px","height":"100%","css":"","css_Class":"ApiComponent","color":"","security":"logged","on_security_failure":"login","roles":"","cache_time":"0","sp_theme":" ","offline":"false","shared_manifest":"false","manifest":"Custom manifest","action_code":"","description":"","steps":"","layout_step":"","is960":"true","steppable_prop":[],"codemanifest":"","css_code":"[]"},{"id":"item_static_0","type":"static","name":"APIDescription","src":"../jsp-system/SPAPIHeader_portlet.jsp","parameters":"","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"0","col":"0","height":"1","width":"12","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","caption":"","draggable":"false","hidden":"false","curTab":"generic"},{"id":"item_static_1","type":"static","name":"APIDetails","src":"../jsp-system/SPAPIDetails_portlet.jsp","parameters":"","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"1","col":"0","height":"1","width":"12","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","caption":"","draggable":"false","hidden":"false","curTab":"generic"}]%>
<%/*Encoding:UTF-8*/%>
<%/*Description:*/%>
<%@page import="java.util.*" %><%@page import="com.zucchetti.SPBridge.*" %><%@page import="com.zucchetti.PortalStudio.*" %>
<%@page import="com.zucchetti.sitepainter.Library" %><%@page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String includerPageletId= (request.getAttribute("PageletId")!= null ? (String)request.getAttribute("PageletId") : "");
String PageletId= (request.getAttribute("forcePageletId")!= null ? (String)request.getAttribute("forcePageletId") : JSPLib.NewCPCCCHK());
if(request.getAttribute("forcePageletId")!= null) request.setAttribute("forcePageletId", null);
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
String parms_joiner;
%><!-- PageletName=SPComponentAPI -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPComponentAPI","UTF-8")) {return; }
 %><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;
}%>
<%response.setHeader("Cache-Control","max-age = 0");
response.setDateHeader("Expires", 0);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".SPComponentAPI","SPComponentAPI");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","SPComponentAPI");
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
<html>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp-system/SPComponentAPI.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath("styles/pagelet.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<%if(!server_side_included && !client_side_included){%>
<link rel='shortcut icon' href='../favicon.ico' />
<% sp.WriteStandardJSLibraries(out); %></head>
<body style='margin:0;'<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<style>#<%=PageletId%>_container{}</style><script>
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
var m_cSPParentObjId =   ZtVWeb.POM.addObj('<%=PageletId%>','SPComponentAPI','pageletObj', '<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%SPParentObjId=PageletId;

Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
if (ht!=null){
}
%>
<div class="type_12 pagelet_container ApiComponent" id="<%=PageletId%>_container"><%
String ID_SEP;
String CONTAINER_SUFFIX;
String CONTENT_SUFFIX;
String uid;
String container_id;
String content_id;
String url;
String title_value;
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_static_0";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%request.setAttribute("SPParentObjId",container_id);%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','APIDescription','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("APIDescription")%> name="APIDescription" class='pagelet_item  block_item ' title_as_portlet='default_title_portlet_portlet.jsp'><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
String content_name;
String res_url;
%><%
url="../jsp-system/SPAPIHeader_portlet.jsp";
content_name= uid + ID_SEP + "../jsp-system/SPAPIHeader";
parms_joiner = "?";
res_url="../jsp-system/SPAPIHeader_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'APIDescription','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': '../jsp-system/SPAPIHeader_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/../jsp-system/SPAPIHeader_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/../jsp-system/SPAPIHeader_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/../jsp-system/SPAPIHeader_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/../jsp-system/SPAPIHeader_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('../jsp-system/SPAPIHeader');
/*JS_MARKER_END*/
</script></div><div class="clear"></div><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_static_1";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%request.setAttribute("SPParentObjId",container_id);%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','APIDetails','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("APIDetails")%> name="APIDetails" class='pagelet_item  block_item ' title_as_portlet='default_title_portlet_portlet.jsp'><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
%><%
url="../jsp-system/SPAPIDetails_portlet.jsp";
content_name= uid + ID_SEP + "../jsp-system/SPAPIDetails";
parms_joiner = "?";
res_url="../jsp-system/SPAPIDetails_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'APIDetails','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': '../jsp-system/SPAPIDetails_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/../jsp-system/SPAPIDetails_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/../jsp-system/SPAPIDetails_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/../jsp-system/SPAPIDetails_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/../jsp-system/SPAPIDetails_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('../jsp-system/SPAPIDetails');
/*JS_MARKER_END*/
</script></div></div><script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this, {id:'<%=PageletId%>', steps:"", stretch:"false", dragAndDroppable: false});
	this.APIDescription= new ZtVWeb.StaticCtrl(this, {"behavior":"show","id":"item_static_0","layout_steps_values":{},"name":"APIDescription","open":true,"popupItems":[],"renderWidth":12,"type":"static","width":12});
	this.APIDetails= new ZtVWeb.StaticCtrl(this, {"behavior":"show","id":"item_static_1","layout_steps_values":{},"name":"APIDetails","open":true,"popupItems":[],"renderWidth":12,"row":1,"type":"static","width":12});
  this.planName='<%=(planName!=null?planName:"")%>';
  this.Calc= function(){
    if(!Empty(this.planName) && window[this.planName] )
      window[this.planName].Calc(this);
  }
  /*ActionCode*/
  
  
  /*End ActionCode*/
};
<%if(!pagelet_yet_included && !client_side_included){%>
function getPagelet(){return window.<%=PageletId%>;}
<%}%>
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'SPComponentAPI','<%=JSPLib.ToJSValue(includerPageletId,false,true)%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html>
<%}%>
