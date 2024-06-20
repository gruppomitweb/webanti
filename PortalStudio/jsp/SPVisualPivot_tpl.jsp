<%/*Type:Pagelet*/%>
<%/*Template*/%>
<%/*Def:type||pagelet||id||pagelet||name||/SPVisualPivot_tpl||template||0||width||100%||height|| ||css|| ||css_class|| ||color|| ||align||left||security||none||on_security_failure||login||offline||false||shared_manifest|| ||manifest||Custom manifest||description|| ||sp_theme||false||cache_time|| ||roles|| |||type||column||id||header||name||header||width|| ||color|| ||align||left||valign||top||css_class|| ||height||0px||padding|| ||collapsable||false|||type||column||id||col1||name||column1||width||200px||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||true close|||type||column||id||col2||name||column2||width||95%||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||false|||type||column||id||col3||name||column3||width||0px||color|| ||align||left||valign||top||css_class|| ||height|| ||padding|| ||collapsable||false|||type||column||id||footer||name||footer||width|| ||color|| ||align||left||valign||top||css_class|| ||height||0px||padding|| ||collapsable||false|||type||zone||id||ZoomParameters0||name||ZoomParameters||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||container||col1||position||0||margin_bottom||10px||draggable||false||css_class|| |||type||zone||id||ZoomGrid1||name||ZoomGrid||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||container||col2||position||0||margin_bottom||10px||draggable||false||css_class|| |||*/%>
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
<!-- PageletName=SPVisualPivot_tpl -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPVisualPivot_tpl","UTF-8")) {return; }
 %><%request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".SPVisualPivot_tpl","SPVisualPivot_tpl");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","SPVisualPivot_tpl");
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPVisualPivot_tpl.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
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
  ZtVWeb.POM.addObj('<%=PageletId%>','SPVisualPivot_tpl','pageletObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<div id="<%=PageletId%>_table_cont" class="ps_table_cont"><table class='pagelet_body' width='100%' height='100%' cellpadding='0' cellspacing='0'><tr><td align='left' valign='top'>
<%
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map<String,String> ZoomParameters_box=null;
Map<String,String> ZoomGrid_box=null;
if (ht!=null){
  ZoomParameters_box=(Map)ht.get("ZoomParameters");
  ZoomGrid_box=(Map)ht.get("ZoomGrid");
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
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'SPVisualPivot_tpl','<%=includerPageletId%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html><%}%>
