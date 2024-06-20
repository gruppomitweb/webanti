<%/*Type:Pagelet*/%>
<%/*Template*/%>
<%/*Def:type||pagelet||id||pagelet||name||default_tpl||template||0||width||100%||height||100%||css|| ||css_class|| ||color|| ||align||left||security||none||on_security_failure||login||sp_theme||true|||type||column||id||header||name||header||width|| ||color|| ||align||left||valign||top||css_class|| ||height||1%||padding|| ||collapsable||false|||type||column||id||col1||name||column1||width||170||color|| ||align||left||valign||top||css_class|| ||height||100%||padding|| ||collapsable||false|||type||column||id||col2||name||column2||width||100%||color|| ||align||left||valign||top||css_class|| ||height||100%||padding|| ||collapsable||false|||type||column||id||col3||name||column3||width||1||color|| ||align||left||valign||top||css_class|| ||height||100%||padding|| ||collapsable||false|||type||column||id||footer||name||footer||width|| ||color|| ||align||center||valign||top||css_class|| ||height||0%||padding|| ||collapsable||false|||type||portlet||id||start_page_menu_orizz_portlet.jsp0||name||start_page_menu_orizz_portlet.jsp||parameters|| ||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||condition|| ||toremove|| ||container||header||position||0||margin_bottom||10px||draggable||false|||type||group||id||sx1||name||sx||titled||false||title|| ||open||false||tabs||none||container||col1||position||0||margin_bottom||10px||draggable||false|||type||zone||id||main2||name||main||titled||false||title|| ||open||false||in_iframe||true||iframe_height|| ||container||col2||position||0||margin_bottom||10px||draggable||false|||type||portlet||id||start_page_footer_portlet.jsp3||name||start_page_footer_portlet.jsp||parameters|| ||titled||false||title|| ||open||false||in_iframe||false||iframe_height|| ||condition|| ||toremove|| ||container||footer||position||0||margin_bottom||10px||draggable||false|||*/%>
<%/*Template_type:0*/%>
<%/*Encoding:UTF-8*/%>
<%/*Description:*/%>
<%@page import="java.util.*" %><%@page import="com.zucchetti.SPBridge.*" %><%@page import="com.zucchetti.PortalStudio.*" %>
<%@page import="com.zucchetti.sitepainter.Library" %><%@page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%Sitepainter sp=Sitepainter.getSitepainter(request);
String PageletId= (request.getAttribute("forcePageletId")!= null ? (String)request.getAttribute("forcePageletId") : JSPLib.NewCPCCCHK());
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
request.setAttribute("forcePageletId",null);
String includerPageletId= (request.getAttribute("PageletId")!= null ? (String)request.getAttribute("PageletId") : "");%>
<!-- PageletName=default_tpl -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"default_tpl","UTF-8")) {return; }
 %><%request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".default_tpl","default_tpl");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","default_tpl");
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/default_tpl.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<% sp.WritePortalStudioCSS(request, out); 
if(!server_side_included && !client_side_included){
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
  ZtVWeb.POM.addObj('<%=PageletId%>','default_tpl','pageletObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<div id="<%=PageletId%>_table_cont" class="ps_table_cont"><table class='pagelet_body' width='100%' height='100%' cellpadding='0' cellspacing='0'><tr><td align='left' valign='top'>
<%
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map<String,String> main_box=null;
Map sx_group_box=null;
if (ht!=null){
  sx_group_box=(Map)ht.get("sx_group");
  main_box=(Map)ht.get("main");
  if(sx_group_box!=null) sx_group_box.remove("main");
}
%>
<table class='pagelet' width='100%' height='100%' style='' align='left' border='0' cellspacing='0' cellpadding='0'>
<tr><%String droplet_header=PageletId+"_pagelet_header";%>
<td class='header'  id='<%=PageletId%>_pagelet_header' width=' ' height='1%'  valign='top' align='left'>
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
uid= PageletId+ID_SEP+"start_page_menu_orizz_portlet";
resource="start_page_menu_orizz_portlet";
container_id=uid + ID_SEP + resource + ID_SEP + CONTAINER_SUFFIX;
content_name=uid + ID_SEP + "start_page_menu_orizz";
content_id=uid + ID_SEP + resource + ID_SEP + CONTENT_SUFFIX;
content_title="";
request.setAttribute("SPParentObjId",container_id);
res_url="start_page_menu_orizz_portlet.jsp"+((("start_page_menu_orizz_portlet.jsp").indexOf("?")==-1) ? "?" : "&")+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','start_page_menu_orizz_portlet.jsp','staticObj','<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("start_page_menu_orizz_portlet.jsp")%> style='margin-bottom:10px;' >
<div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=PageletId%>_start_page_menu_orizz_portlet']={'loaded': false, 'type': 'portlet', 'name': 'start_page_menu_orizz_portlet','containerId':'<%=JSPLib.ToJSValue(container_id)%>', 'contentId':'<%=JSPLib.ToJSValue(content_id)%>', 'url': 'start_page_menu_orizz', 'inIframe': false};
/*JS_MARKER_END*/
</script>
<%res_url += "&"+queryString; %>

<%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/start_page_menu_orizz_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/start_page_menu_orizz_portlet.jsp",true))
    com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/start_page_menu_orizz_portlet.jsp",false);
%>
</div>
</div>
<script type='text/javascript'>
/*JS_MARKER_START*/
window.portlet_list.push('start_page_menu_orizz');
/*JS_MARKER_END*/
</script>
</td>
</tr>
<tr><td valign='top' height='100%' width='100%'>
<table width='100%' height='100%' cellpadding='0' cellspacing='0'><tr>
<%String droplet_column1=PageletId+"_pagelet_column1";%>
<td class='columnleft'  id='<%=PageletId%>_pagelet_column1' width='170' height='100%'  valign='top' align='left'>
<div id='<%=PageletId%>_column1_sizer' style='width:170;'>
<%droplet_column1=PageletId+"_column1_sizer";

if(sx_group_box!=null){
String GROUP_ID_SEP="_";
String GROUP_CONTAINER_SUFFIX="container";
String GROUP_CONTENT_SUFFIX="content";
String GroupId= PageletId+"_sx1";
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=PageletId+"_sx_container"%>','sx','groupObj','<%=PageletId%>');
	<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>']={'loaded':[], 'type': 'group', 'urls': [],'resources': [], 'name': 'sx', 'Ids': [], 'containerIds' : [], 'contentIds' : [],'inIframe':[], 'title_portlet_ids': [], 'titleIds': [], 'containerId': '<%=PageletId%>_sx_container', 'contentId': '<%=PageletId%>_sx_container'};
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(PageletId+"_sx_container")%> title_as_portlet='default_title_portlet_portlet.jsp'>
<%
{int i=0;
for (Iterator<String> it = sx_group_box.keySet().iterator(); it.hasNext();i++){
String resource_name=it.next();
if (sx_group_box.get(resource_name)!=null){
request.setAttribute("PageletId",PageletId);
String GROUP_element_url=(String)((Map)sx_group_box.get(resource_name)).get("url");
String GROUP_element_resource=(String)((Map)sx_group_box.get(resource_name)).get("name");
String GROUP_element_caption=(String)((Map)sx_group_box.get(resource_name)).get("title");
String GROUP_element_opened=(String)((Map)sx_group_box.get(resource_name)).get("opened");
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
GROUP_queryString+=((GROUP_res_url.indexOf("?")==-1)? "?" : "&")+"SPParentObjId="+PageletId+"_sx_container&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>','<%=JSPLib.ToJSValue(GROUP_element_content_title)%>','resourceObj', '<%=PageletId+"_sx_container"%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(GROUP_element_container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue(GROUP_element_resource)%> style='margin-bottom:10px;' >
<%GROUP_queryString+="&"+queryString;%>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>'].resources.push('<%=GROUP_element_resource%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>'].urls.push('<%=JSPLib.ToJSValue(GROUP_element_resource_url)%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>'].loaded.push(<%=(GROUP_element_url.indexOf("_portlet.jsp")>-1?false:true)%>);
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>'].containerIds.push('<%=GROUP_element_container_id%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>'].contentIds.push('<%=GROUP_element_content_id%>');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>'].Ids.push('');
<%=PageletId%>_pagelet_structure['<%=PageletId + GROUP_ID_SEP +"sx1"%>'].inIframe.push(<%=GROUP_in_iframe%>);
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(GROUP_element_content_id)%> style='display:<%if("true".equals(GROUP_element_opened)){ out.print("block");}else if("false".equals(GROUP_element_opened)){ out.print("none");}else{ out.print("block");}%>;'><%if(GROUP_in_iframe){
GROUP_iframe_id=GROUP_element_content_name;
GROUP_iframe_src=GROUP_res_url+GROUP_queryString;
GROUP_onload="resizeIframe(this);";
%>
<iframe id=<%=JSPLib.ToHTMLValue(GROUP_iframe_id)%> name=<%=JSPLib.ToHTMLValue(GROUP_element_resource)%> src=<%=JSPLib.ToHTMLValue(!com.zucchetti.sitepainter.Library.Empty(GROUP_iframe_src)?GROUP_iframe_src:"")%> onload=<%=JSPLib.ToHTMLValue(GROUP_onload)%>  marginwidth="0" marginheight="0" style="width:100%;height:0px;" allowtransparency="true" frameborder="0" spparentobjid=<%=JSPLib.ToHTMLValue(GROUP_element_container_id)%>></iframe>
<%}else{
if(Library.Empty(GROUP_element_opened) || "true".equals(GROUP_element_opened)){ 
  out.flush();
  Library.includeResource(request,response,"/jsp/"+GROUP_res_url,false);
}
GROUP_onExpandTab="ZtVWeb.AdjustContainer";

}%>
</div>
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
<%String droplet_column2=PageletId+"_pagelet_column2";%>
<td class='columncentral'  id='<%=PageletId%>_pagelet_column2' width='100%' height='100%'  valign='top' align='left'>
<%
if(main_box!=null){
request.setAttribute("PageletId",PageletId);
String ZONE_ID_SEP="_";
String ZONE_CONTAINER_SUFFIX="container";
String ZONE_CONTENT_SUFFIX="content";
String ZONE_resource=(String)main_box.get("name");
String ZONE_url=(String)main_box.get("url");

boolean ZONE_iframed_by_plan=ZONE_url.charAt(0)=='!';
ZONE_url= ZONE_iframed_by_plan ? ZONE_url.substring(1, ZONE_url.length()) : ZONE_url ;
String ZONE_container_id=PageletId + ZONE_ID_SEP + ZONE_resource + ZONE_ID_SEP + ZONE_CONTAINER_SUFFIX;
String ZONE_content_name=PageletId + ZONE_ID_SEP + ZONE_resource;
String ZONE_content_id=PageletId + ZONE_ID_SEP + ZONE_resource + ZONE_ID_SEP + ZONE_CONTENT_SUFFIX;
String ZONE_content_title=(String)main_box.get("title");
request.setAttribute("SPParentObjId",ZONE_container_id);
String ZONE_res_url=ZONE_url +((ZONE_url.indexOf("?")==-1) ? "?" : "&") + "SPParentObjId=" +ZONE_container_id +"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=ZONE_container_id%>','main','resourceObj','<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(ZONE_container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("main")%> style='margin-bottom:10px;' >
<div id=<%=JSPLib.ToHTMLValue(ZONE_content_id)%> style='display:block;'><%
boolean ZONE_is_servlet=ZONE_url.startsWith("../servlet/");
boolean ZONE_in_iframe=ZONE_iframed_by_plan||ZONE_is_servlet;
String ZONE_iframe_id, ZONE_iframe_src, ZONE_onload;
ZONE_iframe_id=ZONE_iframe_src=ZONE_onload="";
%>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=JSPLib.ToJSValue(PageletId + ZONE_ID_SEP +"main2")%>']={'loaded': 'false', 'type':'resource','name':'main','url':'<%=JSPLib.ToJSValue(ZONE_url)%>','containerId':'<%=JSPLib.ToJSValue(ZONE_container_id)%>', 'contentId':'<%=JSPLib.ToJSValue(ZONE_content_id)%>', 'Id': ''}
/*JS_MARKER_END*/
</script>
<%
ZONE_res_url+="&"+queryString;
ZONE_iframe_id=ZONE_content_name;
ZONE_iframe_src=ZONE_res_url;
ZONE_onload="resizeIframe(this);";
%>
<iframe id=<%=JSPLib.ToHTMLValue(ZONE_iframe_id)%> name='main' onload=<%=JSPLib.ToHTMLValue(ZONE_onload)%> marginwidth='0' marginheight='0' style='width:100%;height:0px;' allowtransparency='true' frameborder='0' spparentobjid=<%=JSPLib.ToHTMLValue(ZONE_container_id)%>></iframe>
<%if (!Library.Empty(ZONE_iframe_src)) {%><script>window.show.setFrameSrc(frames[<%=Library.ToJSValue("main","C",0,0)%>].frameElement,<%=Library.ToJSValue(JSPLib.SPWebRootURL(request)+"/jsp/"+ZONE_iframe_src,"C",0,0)%>)</script><%}%>
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
<tr>
<%String droplet_footer=PageletId+"_pagelet_footer";%>
<td class='footer'  id='<%=PageletId%>_pagelet_footer' width=' ' height='0%'  valign='top' align='center'>
<%
request.setAttribute("PageletId",PageletId);


ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId+ID_SEP+"start_page_footer_portlet";
resource="start_page_footer_portlet";
container_id=uid + ID_SEP + resource + ID_SEP + CONTAINER_SUFFIX;
content_name=uid + ID_SEP + "start_page_footer";
content_id=uid + ID_SEP + resource + ID_SEP + CONTENT_SUFFIX;
content_title="";
request.setAttribute("SPParentObjId",container_id);
res_url="start_page_footer_portlet.jsp"+((("start_page_footer_portlet.jsp").indexOf("?")==-1) ? "?" : "&")+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','start_page_footer_portlet.jsp','staticObj','<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("start_page_footer_portlet.jsp")%> style='margin-bottom:10px;' >
<div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'>
<script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=PageletId%>_start_page_footer_portlet']={'loaded': false, 'type': 'portlet', 'name': 'start_page_footer_portlet','containerId':'<%=JSPLib.ToJSValue(container_id)%>', 'contentId':'<%=JSPLib.ToJSValue(content_id)%>', 'url': 'start_page_footer', 'inIframe': false};
/*JS_MARKER_END*/
</script>
<%res_url += "&"+queryString; %>

<%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/start_page_footer_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/start_page_footer_portlet.jsp",true))
    com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/start_page_footer_portlet.jsp",false);
%>
</div>
</div>
<script type='text/javascript'>
/*JS_MARKER_START*/
window.portlet_list.push('start_page_footer');
/*JS_MARKER_END*/
</script>
</td>
</tr></table>
</td></tr></table></div>
<script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this,{id:'<%=PageletId%>',stretch:'true'});
	this['start_page_menu_orizz_portlet']= new ZtVWeb.StaticCtrl(this,{ "name":"start_page_menu_orizz_portlet","id":"start_page_menu_orizz_portlet", "src":"start_page_menu_orizz_portlet.jsp", "in_iframe":"false"});
<%if(sx_group_box!=null){%>
	this.sx= new ZtVWeb.GroupCtrl(this, {"name":"sx", "id": "sx1", "layout": "none"});
<%}
 if(main_box!=null){%>
	this.main= new ZtVWeb.ResourceCtrl(this,{ "name": "main", "id":"main2", "in_iframe":"true"});
<%}%>
	this['start_page_footer_portlet']= new ZtVWeb.StaticCtrl(this,{ "name":"start_page_footer_portlet","id":"start_page_footer_portlet", "src":"start_page_footer_portlet.jsp", "in_iframe":"false"});
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
<% if(main_box!=null){%>
window.<%=PageletId%>.main.setSrc();
<%}
if(!pagelet_yet_included && !client_side_included){%>
function getPagelet(){return window.<%=PageletId%>;}
<%}%>
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'default_tpl','<%=includerPageletId%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html><%}%>
