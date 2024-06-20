<%/*Type:Pagelet*/%>
<%/*Template*/%>
<%/*Def:type||pagelet||id||pagelet||name||SPPortalZoom_sx_tpl||template||0||width||100%||height|| ||css|| ||css_class|| ||color|| ||align||left||security||none||on_security_failure||login||offline||false||shared_manifest|| ||manifest||Custom manifest||description|| ||sp_theme||false||cache_time|| ||roles|| |||type||column||id||header||name||header||width|| ||color|| ||align||left||valign||top||css_class|| ||height||0px||padding|| ||collapsable||false|||type||column||id||col1||name||column1||width||200px||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||true close|||type||column||id||col2||name||column2||width||95%||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||false|||type||column||id||col3||name||column3||width||400px||color|| ||align||right||valign||top||css_class|| ||height|| ||padding|| ||collapsable||true close|||type||column||id||footer||name||footer||width|| ||color|| ||align||left||valign||top||css_class|| ||height||0px||padding|| ||collapsable||false|||type||zone||id||ZoomParameters0||name||ZoomParameters||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||container||col1||position||0||margin_bottom||10px||draggable||false||css_class|| |||type||zone||id||ZoomGrid1||name||ZoomGrid||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||container||col2||position||0||margin_bottom||10px||draggable||false||css_class|| |||type||group||id||ZoomChildren2||name||ZoomChildren||titled||false||title|| ||open||false||tabs||multiple||container||col3||position||0||margin_bottom||10px||draggable||false||pre_loaded||false||css_class|| |||*/%>
<%/*Template_type:0*/%>
<%/*Encoding:UTF-8*/%>
<%/*Description: */%>
<%@page import="java.util.*" %><%@page import="com.zucchetti.SPBridge.*" %><%@page import="com.zucchetti.PortalStudio.*" %>
<%@page import="com.zucchetti.sitepainter.Library" %><%@page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String PageletId= (request.getAttribute("forcePageletId")!= null ? (String)request.getAttribute("forcePageletId") : JSPLib.NewCPCCCHK());
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("forcePageletId",null);
String includerPageletId= (request.getAttribute("PageletId")!= null ? (String)request.getAttribute("PageletId") : "");%>
<!-- PageletName=SPPortalZoom_sx_tpl -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoom_sx_tpl","UTF-8")) {return; }
 %><%request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".SPPortalZoom_sx_tpl","SPPortalZoom_sx_tpl");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","SPPortalZoom_sx_tpl");
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPPortalZoom_sx_tpl.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<%if(!server_side_included && !client_side_included){
 sp.WriteStandardJSLibraries(out); %><link rel='shortcut icon' href='../favicon.ico' />
</head>
<body style='margin:0;'<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<script>
/*JS_MARKER_START*/
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
  ZtVWeb.POM.addObj('<%=PageletId%>','SPPortalZoom_sx_tpl','pageletObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<%if(!tabs_libraries_included){%>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath( sp.getSkin() +"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<script src='<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>'></script>
<%request.setAttribute("javax.servlet.include.tabs_libraries_included","true");
}%>
<div id="<%=PageletId%>_table_cont" class="ps_table_cont"><table class='pagelet_body' width='100%' height='100%' cellpadding='0' cellspacing='0'><tr><td align='left' valign='top'>
<%
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map<String,String> ZoomParameters_box=null;
Map<String,String> ZoomGrid_box=null;
Map ZoomChildren_group_box=null;
if (ht!=null){
  ZoomChildren_group_box=(Map)ht.get("ZoomChildren_group");
  ZoomParameters_box=(Map)ht.get("ZoomParameters");
  if(ZoomChildren_group_box!=null) ZoomChildren_group_box.remove("ZoomParameters");
  ZoomGrid_box=(Map)ht.get("ZoomGrid");
  if(ZoomChildren_group_box!=null) ZoomChildren_group_box.remove("ZoomGrid");
}
%>
<table class='pagelet' width='100%' height=' ' style='' align='left' border='0' cellspacing='0' cellpadding='0'>
<tr><td valign='top' height='100%' width='100%'>
<table width='100%' height='100%' cellpadding='0' cellspacing='0'><tr>
<%String droplet_column1=PageletId+"_pagelet_column1_container";%>
<td class='columnleft'  id='<%=PageletId%>_pagelet_column1' width='200px' height=' '  valign='top' align='left'>
<div id='<%=PageletId%>_pagelet_column1_openclose' style='margin-bottom:0px;width:18px;overflow:hidden'>
<%out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/default_title_column_portlet.jsp?width_close=18px&open=false&column="+PageletId+"_pagelet_column1",true))
  com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/default_title_column_portlet.jsp?open=false&column="+PageletId+"_pagelet_column1",false);
request.setAttribute("default_title_column",null);
%>
</div>
<div style='width:200px;display:none;' id='<%=PageletId%>_pagelet_column1_container'>
<%
if(ZoomParameters_box!=null){
request.setAttribute("PageletId",PageletId);
String ZONE_ID_SEP="_";
String ZONE_CONTAINER_SUFFIX="container";
String ZONE_CONTENT_SUFFIX="content";
String ZONE_resource=(String)ZoomParameters_box.get("name");
String ZONE_url=(String)ZoomParameters_box.get("url");

boolean ZONE_iframed_by_plan=ZONE_url.charAt(0)=='!';
ZONE_url= ZONE_iframed_by_plan ? ZONE_url.substring(1, ZONE_url.length()) : ZONE_url ;
String ZONE_container_id=PageletId + ZONE_ID_SEP + ZONE_resource + ZONE_ID_SEP + ZONE_CONTAINER_SUFFIX;
String ZONE_content_name=PageletId + ZONE_ID_SEP + ZONE_resource;
String ZONE_content_id=PageletId + ZONE_ID_SEP + ZONE_resource + ZONE_ID_SEP + ZONE_CONTENT_SUFFIX;
String ZONE_content_title=(String)ZoomParameters_box.get("title");
request.setAttribute("SPParentObjId",ZONE_container_id);
String ZONE_res_url=ZONE_url +((ZONE_url.indexOf("?")==-1) ? "?" : "&") + "SPParentObjId=" +ZONE_container_id +"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=ZONE_container_id%>','ZoomParameters','resourceObj','<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(ZONE_container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("ZoomParameters")%> style='margin-bottom:10px;' >
<div id=<%=JSPLib.ToHTMLValue(ZONE_content_id)%> style='display:block;'><%
boolean ZONE_is_servlet=ZONE_url.startsWith("../servlet/");
boolean ZONE_in_iframe=ZONE_iframed_by_plan||ZONE_is_servlet;
String ZONE_iframe_id, ZONE_iframe_src, ZONE_onload;
ZONE_iframe_id=ZONE_iframe_src=ZONE_onload="";
%>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=JSPLib.ToJSValue(PageletId + ZONE_ID_SEP +"ZoomParameters0")%>']={'loaded': 'false', 'type':'resource','name':'ZoomParameters','url':'<%=JSPLib.ToJSValue(ZONE_url)%>','containerId':'<%=JSPLib.ToJSValue(ZONE_container_id)%>', 'contentId':'<%=JSPLib.ToJSValue(ZONE_content_id)%>', 'Id': ''}
/*JS_MARKER_END*/
</script>
<%
ZONE_res_url+="&"+queryString;
if(ZONE_in_iframe){
ZONE_iframe_id=ZONE_content_name;
ZONE_iframe_src=ZONE_res_url;
ZONE_onload="resizeIframe(this);";
%>
<iframe id=<%=JSPLib.ToHTMLValue(ZONE_iframe_id)%> name='ZoomParameters' onload=<%=JSPLib.ToHTMLValue(ZONE_onload)%> marginwidth='0' marginheight='0' style='width:100%;height:0px;' allowtransparency='true' frameborder='0' spparentobjid=<%=JSPLib.ToHTMLValue(ZONE_container_id)%>></iframe>
<%if (!Library.Empty(ZONE_iframe_src)) {%><script>window.show.setFrameSrc(frames[<%=Library.ToJSValue("ZoomParameters","C",0,0)%>].frameElement,<%=Library.ToJSValue(JSPLib.SPWebRootURL(request)+"/jsp/"+ZONE_iframe_src,"C",0,0)%>)</script><%}
}else{
pageContext.include("../jsp/"+ZONE_url);

}%>
</div>
</div>
<script type='text/javascript'>
/*JS_MARKER_START*/
<%if(ZONE_is_servlet){%>
ZtVWeb.addPortlet('<%=JSPLib.ToJSValue(ZONE_content_name)%>_i','<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>');
window.<%=JSPLib.ToJSValue(ZONE_content_name)%>_i=new function(){
  ZtVWeb.newForm(this,'<%=JSPLib.ToJSValue(ZONE_content_name)%>_i','<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>',200,200);
  this.on_<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_driveEntity=function(parmsObj){
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker=new ZtVWeb.SPLinkerCtrl(this,'<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker','<%=JSPLib.ToJSValue(ZONE_content_name)%>_i_splinker',169,-29,30,30,'<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>','','','false',' ',' ',' ','<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>');
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.action='view';
  var buildParms=function(o_parms){
    res='';
    for(var p in o_parms){
      res+=p+'='+o_parms[p]+',';
    };
    return res.substring(0,res.length-1);
  };
  var k_parms='';
  for(var prop in parmsObj) {
    if(IsA(parmsObj[prop],'O')){
      k_parms+=buildParms(parmsObj[prop])+',';
      continue;
    }
    if(prop!='action'){
      k_parms+= prop+'='+parmsObj[prop]+',';
    }else{
      this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.action=parmsObj[prop]
    }
  }
  k_parms=k_parms.substring(0,k_parms.length-1)
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.Parameters(k_parms)
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.Link()
  }
}
ZtVWeb.addPortletObj('<%=ZONE_content_name%>_i', '<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(ZONE_resource+"_p"))%>', <%=ZONE_content_name%>_i);
<%
ZONE_content_name=ZONE_iframe_id+"_i";

}%>
window.portlet_list.push('<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(ZONE_resource+"_p"))%>');
/*JS_MARKER_END*/
</script>
<%}%>
</div>
</td>
<%String droplet_column2=PageletId+"_pagelet_column2";%>
<td class='columncentral'  id='<%=PageletId%>_pagelet_column2' width='95%' height=' '  valign='top' align='left'>
<%
if(ZoomGrid_box!=null){
request.setAttribute("PageletId",PageletId);
String ZONE_ID_SEP="_";
String ZONE_CONTAINER_SUFFIX="container";
String ZONE_CONTENT_SUFFIX="content";
String ZONE_resource=(String)ZoomGrid_box.get("name");
String ZONE_url=(String)ZoomGrid_box.get("url");

boolean ZONE_iframed_by_plan=ZONE_url.charAt(0)=='!';
ZONE_url= ZONE_iframed_by_plan ? ZONE_url.substring(1, ZONE_url.length()) : ZONE_url ;
String ZONE_container_id=PageletId + ZONE_ID_SEP + ZONE_resource + ZONE_ID_SEP + ZONE_CONTAINER_SUFFIX;
String ZONE_content_name=PageletId + ZONE_ID_SEP + ZONE_resource;
String ZONE_content_id=PageletId + ZONE_ID_SEP + ZONE_resource + ZONE_ID_SEP + ZONE_CONTENT_SUFFIX;
String ZONE_content_title=(String)ZoomGrid_box.get("title");
request.setAttribute("SPParentObjId",ZONE_container_id);
String ZONE_res_url=ZONE_url +((ZONE_url.indexOf("?")==-1) ? "?" : "&") + "SPParentObjId=" +ZONE_container_id +"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=ZONE_container_id%>','ZoomGrid','resourceObj','<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(ZONE_container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("ZoomGrid")%> style='margin-bottom:10px;' >
<div id=<%=JSPLib.ToHTMLValue(ZONE_content_id)%> style='display:block;'><%
boolean ZONE_is_servlet=ZONE_url.startsWith("../servlet/");
boolean ZONE_in_iframe=ZONE_iframed_by_plan||ZONE_is_servlet;
String ZONE_iframe_id, ZONE_iframe_src, ZONE_onload;
ZONE_iframe_id=ZONE_iframe_src=ZONE_onload="";
%>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=JSPLib.ToJSValue(PageletId + ZONE_ID_SEP +"ZoomGrid1")%>']={'loaded': 'false', 'type':'resource','name':'ZoomGrid','url':'<%=JSPLib.ToJSValue(ZONE_url)%>','containerId':'<%=JSPLib.ToJSValue(ZONE_container_id)%>', 'contentId':'<%=JSPLib.ToJSValue(ZONE_content_id)%>', 'Id': ''}
/*JS_MARKER_END*/
</script>
<%
ZONE_res_url+="&"+queryString;
if(ZONE_in_iframe){
ZONE_iframe_id=ZONE_content_name;
ZONE_iframe_src=ZONE_res_url;
ZONE_onload="resizeIframe(this);";
%>
<iframe id=<%=JSPLib.ToHTMLValue(ZONE_iframe_id)%> name='ZoomGrid' onload=<%=JSPLib.ToHTMLValue(ZONE_onload)%> marginwidth='0' marginheight='0' style='width:100%;height:0px;' allowtransparency='true' frameborder='0' spparentobjid=<%=JSPLib.ToHTMLValue(ZONE_container_id)%>></iframe>
<%if (!Library.Empty(ZONE_iframe_src)) {%><script>window.show.setFrameSrc(frames[<%=Library.ToJSValue("ZoomGrid","C",0,0)%>].frameElement,<%=Library.ToJSValue(JSPLib.SPWebRootURL(request)+"/jsp/"+ZONE_iframe_src,"C",0,0)%>)</script><%}
}else{
pageContext.include("../jsp/"+ZONE_url);

}%>
</div>
</div>
<script type='text/javascript'>
/*JS_MARKER_START*/
<%if(ZONE_is_servlet){%>
ZtVWeb.addPortlet('<%=JSPLib.ToJSValue(ZONE_content_name)%>_i','<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>');
window.<%=JSPLib.ToJSValue(ZONE_content_name)%>_i=new function(){
  ZtVWeb.newForm(this,'<%=JSPLib.ToJSValue(ZONE_content_name)%>_i','<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>',200,200);
  this.on_<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_driveEntity=function(parmsObj){
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker=new ZtVWeb.SPLinkerCtrl(this,'<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker','<%=JSPLib.ToJSValue(ZONE_content_name)%>_i_splinker',169,-29,30,30,'<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>','','','false',' ',' ',' ','<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>');
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.action='view';
  var buildParms=function(o_parms){
    res='';
    for(var p in o_parms){
      res+=p+'='+o_parms[p]+',';
    };
    return res.substring(0,res.length-1);
  };
  var k_parms='';
  for(var prop in parmsObj) {
    if(IsA(parmsObj[prop],'O')){
      k_parms+=buildParms(parmsObj[prop])+',';
      continue;
    }
    if(prop!='action'){
      k_parms+= prop+'='+parmsObj[prop]+',';
    }else{
      this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.action=parmsObj[prop]
    }
  }
  k_parms=k_parms.substring(0,k_parms.length-1)
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.Parameters(k_parms)
  this.<%=JSPLib.GetValidVarName(ZONE_resource+"_p")%>_splinker.Link()
  }
}
ZtVWeb.addPortletObj('<%=ZONE_content_name%>_i', '<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(ZONE_resource+"_p"))%>', <%=ZONE_content_name%>_i);
<%
ZONE_content_name=ZONE_iframe_id+"_i";

}%>
window.portlet_list.push('<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(ZONE_resource+"_p"))%>');
/*JS_MARKER_END*/
</script>
<%}%>
</td>
<%String droplet_column3=PageletId+"_pagelet_column3_container";%>
<td class='columnright'  id='<%=PageletId%>_pagelet_column3' width='400px' height=' '  valign='top' align='right'>
<div id='<%=PageletId%>_pagelet_column3_openclose' style='margin-bottom:0px;width:18px;overflow:hidden'>
<%out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/default_title_column_portlet.jsp?width_close=18px&open=false&column="+PageletId+"_pagelet_column3",true))
  com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/default_title_column_portlet.jsp?open=false&column="+PageletId+"_pagelet_column3",false);
request.setAttribute("default_title_column",null);
%>
</div>
<div style='width:400px;display:none;' id='<%=PageletId%>_pagelet_column3_container'>
<%
if(ZoomChildren_group_box!=null){
String GROUP_ID_SEP="_";
String GROUP_CONTAINER_SUFFIX="container";
String GROUP_CONTENT_SUFFIX="content";
String GroupId= PageletId+"_ZoomChildren2";
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=PageletId+"_ZoomChildren_container"%>','ZoomChildren','groupObj','<%=PageletId%>');
	<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>']={'loaded':[], 'type': 'group', 'urls': [],'resources': [], 'name': 'ZoomChildren', 'Ids': [], 'containerIds' : [], 'contentIds' : [],'inIframe':[], 'title_portlet_ids': [], 'titleIds': [], 'containerId': '<%=PageletId%>_ZoomChildren_container', 'contentId': '<%=PageletId%>_ZoomChildren_container', 'tabs': [], 'preloaded': false};
/*JS_MARKER_END*/
</script>
<%
String tabs_id=PageletId + GROUP_ID_SEP + "ZoomChildren_tabs";
String tabs_div=tabs_id + GROUP_ID_SEP + GROUP_CONTAINER_SUFFIX;
String tabs_js="window." + tabs_id;
%>
<div id=<%=JSPLib.ToHTMLValue(tabs_div)%>></div>
<script>
/*JS_MARKER_START*/
<%=tabs_js%>=new Z.Tabs({container:'<%=tabs_div%>',useseparator:SPTheme['colTabUseSeparator'],expandcollapse:(typeof(SPTheme['formTabCanCollapse'])!='undefined'?SPTheme['formTabCanCollapse']:true),wizard: false,tabstrip_class: ''});<%=tabs_js%>.tabList=new Array();
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(PageletId+"_ZoomChildren_container")%> title_as_portlet='default_title_portlet_portlet.jsp'>
<%
{int i=0;
for (Iterator<String> it = ZoomChildren_group_box.keySet().iterator(); it.hasNext();i++){
String resource_name=it.next();
if (ZoomChildren_group_box.get(resource_name)!=null){
request.setAttribute("PageletId",PageletId);
String GROUP_element_url=(String)((Map)ZoomChildren_group_box.get(resource_name)).get("url");
String GROUP_element_resource=(String)((Map)ZoomChildren_group_box.get(resource_name)).get("name");
String GROUP_element_caption=(String)((Map)ZoomChildren_group_box.get(resource_name)).get("title");
String GROUP_element_opened=(String)((Map)ZoomChildren_group_box.get(resource_name)).get("opened");
boolean GROUP_iframed_by_plan=GROUP_element_url.charAt(0)=='!';
GROUP_element_url= GROUP_iframed_by_plan ? GROUP_element_url.substring(1, GROUP_element_url.length()) : GROUP_element_url ;
String GROUP_element_resource_url=com.zucchetti.PortalStudio.JSPLib.Strtran(GROUP_element_url,"_portlet.jsp","");
GROUP_element_resource_url=com.zucchetti.PortalStudio.JSPLib.Strtran(GROUP_element_resource_url,"../servlet/","");
GROUP_element_resource_url= GROUP_element_resource_url.indexOf("?")>-1 ? GROUP_element_resource_url.substring(0, GROUP_element_resource_url.indexOf("?")) : GROUP_element_resource_url;
String GROUP_element_container_id=PageletId + GROUP_ID_SEP + GROUP_element_resource + GROUP_ID_SEP + GROUP_CONTAINER_SUFFIX;
String GROUP_element_content_name=PageletId + GROUP_ID_SEP + GROUP_element_resource_url;
String GROUP_element_content_id=PageletId + GROUP_ID_SEP + GROUP_element_resource + GROUP_ID_SEP + GROUP_CONTENT_SUFFIX;
request.setAttribute("SPParentObjId",GROUP_element_container_id);
String GROUP_element_content_title="";
if(GROUP_element_caption.equals("")){GROUP_element_content_title=sp.translate(GROUP_element_resource);}else{GROUP_element_content_title=sp.translate(GROUP_element_caption);}
boolean GROUP_is_servlet=GROUP_element_url.startsWith("../servlet/");
boolean GROUP_in_iframe=GROUP_iframed_by_plan||GROUP_is_servlet;
String GROUP_iframe_id, GROUP_queryString, GROUP_res_url, GROUP_iframe_src, GROUP_onload, GROUP_input_id, GROUP_input_value;
GROUP_iframe_id = GROUP_queryString = GROUP_res_url = GROUP_iframe_src = GROUP_onload = GROUP_input_id = GROUP_input_value = "";
GROUP_res_url=GROUP_element_url ;
String GROUP_onExpandTab="null";
GROUP_queryString+=((GROUP_res_url.indexOf("?")==-1)? "?" : "&")+"SPParentObjId="+GROUP_element_container_id+"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>','<%=JSPLib.ToJSValue(GROUP_element_content_title)%>','resourceObj', '<%=PageletId+"_ZoomChildren_container"%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(GROUP_element_container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue(GROUP_element_resource)%> style='margin-bottom:10px;display:none' >
<%GROUP_queryString+="&"+queryString;%>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].resources.push('<%=GROUP_element_resource%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].urls.push('<%=JSPLib.ToJSValue(GROUP_element_resource_url)%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].tabs.push('<%=GROUP_element_container_id%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].loaded.push(<%=(GROUP_element_url.indexOf("_portlet.jsp")>-1?false:true)%>);
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].containerIds.push('<%=GROUP_element_container_id%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].contentIds.push('<%=GROUP_element_content_id%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].Ids.push('');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"ZoomChildren2"%>'].inIframe.push(<%=GROUP_in_iframe%>);
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(GROUP_element_content_id)%> style='display:<%if("true".equals(GROUP_element_opened)){ out.print("block");}else if("false".equals(GROUP_element_opened)){ out.print("none");}else{ out.print("block");}%>;'><%if(GROUP_in_iframe){
GROUP_iframe_id=GROUP_element_content_name;
if(i==0){
GROUP_iframe_src=GROUP_res_url+GROUP_queryString;
}else{
GROUP_input_id=GROUP_element_content_id + GROUP_ID_SEP +"src";
GROUP_input_value=GROUP_res_url+GROUP_queryString;
GROUP_iframe_src="";
GROUP_onExpandTab="function(){window.resizeIframe('" + GROUP_element_content_name + "',window.document.getElementById('" + GROUP_input_id + "').value);}";
}
GROUP_onload="resizeIframe(this);";
%>
<input type='hidden' id='<%=GROUP_input_id%>' value='<%=GROUP_input_value%>'>
<iframe id=<%=JSPLib.ToHTMLValue(GROUP_iframe_id)%> name=<%=JSPLib.ToHTMLValue(GROUP_element_resource)%> src=<%=JSPLib.ToHTMLValue(!com.zucchetti.sitepainter.Library.Empty(GROUP_iframe_src)?GROUP_iframe_src:"")%> onload=<%=JSPLib.ToHTMLValue(GROUP_onload)%>  marginwidth="0" marginheight="0" style="width:100%;height:0px;" allowtransparency="true" frameborder="0" spparentobjid=<%=JSPLib.ToHTMLValue(GROUP_element_container_id)%>></iframe>
<%}else{
if(i==0){
if(Library.Empty(GROUP_element_opened) || "true".equals(GROUP_element_opened)){ 
  out.flush();
  Library.includeResource(request,response,"/jsp/"+GROUP_res_url,false);
}
GROUP_onExpandTab="ZtVWeb.AdjustContainer";
}else{
GROUP_onExpandTab="function(){"+
  "var d=document.getElementById('"+JSPLib.ToJSValue(GROUP_element_content_id)+"');"+
  "if(d) {"+
    "if (EmptyString(d.innerHTML)){"+
      "ZtVWeb.Include('"+JSPLib.ToJSValue(GROUP_res_url)+JSPLib.ToJSValue(GROUP_queryString)+"','"+JSPLib.ToJSValue(GROUP_element_content_id)+"',true);"+
    "} else {"+
      "ZtVWeb.AdjustContainer()"+
    "}"+
  "}"+
"}";
};
}%>
</div>
<script>
/*JS_MARKER_START*/
<%=tabs_js%>.AddTab({name:'<%=JSPLib.ToJSValue(GROUP_element_container_id)%>',  element:'<%=JSPLib.ToJSValue(GROUP_element_container_id)%>',caption:'<%=JSPLib.ToJSValue(GROUP_element_content_title)%>',onExpand:<%=GROUP_onExpandTab%>});
<%=tabs_js%>.tabList[<%=i%>]= '<%=GROUP_element_container_id%>';
/*JS_MARKER_END*/
</script>
</div>
<script>
/*JS_MARKER_START*/
<%if(GROUP_is_servlet){%>
ZtVWeb.addPortlet('<%=GROUP_iframe_id%>_<%=i%>_i','<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>');
window.<%=GROUP_iframe_id%>_<%=i%>_i=new function(){
  ZtVWeb.newForm(this,'<%=GROUP_iframe_id%>_<%=i%>_i','<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>',200,200);
  this.on_<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>_driveEntity=function(parmsObj){
  this.<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>_splinker=new ZtVWeb.SPLinkerCtrl(this,'<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>_splinker','<%=GROUP_iframe_id%>_<%=i%>_i_splinker',169,-29,30,30,'<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>','','','false',' ',' ',' ','<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>');
  this.<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>_splinker.action='view';
  var buildParms=function(o_parms){
    res='';
    for(var p in o_parms){
      res+=p+'='+o_parms[p]+',';
    };
    return res.substring(0,res.length-1);
  };
  var k_parms='';
  for(var prop in parmsObj) {
    if(IsA(parmsObj[prop],'O')){
      k_parms+=buildParms(parmsObj[prop])+',';
      continue;
    }
    if(prop!='action'){
      k_parms+= prop+'='+parmsObj[prop]+',';
    }else{
      this.<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>_splinker.action=parmsObj[prop]
    }
  }
  k_parms=k_parms.substring(0,k_parms.length-1)
  this.<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>_splinker.Parameters(k_parms)
  this.<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>_splinker.Link()
  }
}
ZtVWeb.addPortletObj('<%=GROUP_iframe_id%>_<%=i%>_i', '<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>', <%=GROUP_iframe_id%>_<%=i%>_i);
<%
GROUP_element_content_name=GROUP_iframe_id+"_i";

}%>
Pagelet_mapId['<%=JSPLib.ToJSValue(GROUP_element_resource)%>']='<%=JSPLib.ToJSValue(GROUP_element_content_id)%>';
window.portlet_list.push('<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>');
/*JS_MARKER_END*/
</script>
<%}}}%>
<div style='clear:both;'></div></div>
<%}%>
</div>
</td>
</tr></table>
</td></tr>
</table>
</td></tr></table></div>
<script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this,{id:'<%=PageletId%>',stretch:'false'});
<% if(ZoomParameters_box!=null){%>
	this.ZoomParameters= new ZtVWeb.ResourceCtrl(this,{ "name": "ZoomParameters", "id":"ZoomParameters0", "in_iframe":"false"});
<%}
 if(ZoomGrid_box!=null){%>
	this.ZoomGrid= new ZtVWeb.ResourceCtrl(this,{ "name": "ZoomGrid", "id":"ZoomGrid1", "in_iframe":"false"});
<%}
if(ZoomChildren_group_box!=null){%>
	this.ZoomChildren= new ZtVWeb.GroupCtrl(this, {"name":"ZoomChildren", "id": "ZoomChildren2", "layout": "multiple"});
<%}%>
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
<% if(ZoomParameters_box!=null){%>
window.<%=PageletId%>.ZoomParameters.setSrc();
<%}
 if(ZoomGrid_box!=null){%>
window.<%=PageletId%>.ZoomGrid.setSrc();
<%}
if(!pagelet_yet_included && !client_side_included){%>
function getPagelet(){return window.<%=PageletId%>;}
<%}%>
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'SPPortalZoom_sx_tpl','<%=includerPageletId%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html><%}%>
