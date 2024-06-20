<%/*Type:PageletEditor*/%>
<%//Def:[{"id":"pagelet","name":"pagelet","type":"pagelet","template":"7","cols_n":"12","rows_n":"3","width":"960px","height":"100%","css":"","css_Class":"","color":"","security":"none","on_security_failure":"login","roles":"","cache_time":"0","sp_theme":" ","offline":"false","shared_manifest":"false","manifest":"Custom manifest","action_code":"","description":"","steps":"","layout_step":"","is960":"true","steppable_prop":[],"codemanifest":"","css_code":"[]"},{"id":"item_resources_0","type":"resource","name":"header_default","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","container":"","row":"0","col":"0","height":"1","width":"12","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","draggable":"false","hidden":"false","curTab":"generic"},{"id":"item_group_1","type":"group","name":"apps","titled":"false","title":"","open":"true","layout":"false","row":"1","col":"0","height":"1","width":"12","prefx":"0","suffx":"0","inserted":"true","content":"","pre_loaded":"false","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","caption":"","draggable":"false","hidden":"false","curTab":"generic"}]%>
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
%><!-- PageletName=spas_papplist_tpl -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"spas_papplist_tpl","UTF-8")) {return; }
 %><%response.setHeader("Cache-Control","max-age = 0");
response.setDateHeader("Expires", 0);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".spas_papplist_tpl","spas_papplist_tpl");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","spas_papplist_tpl");
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spas_papplist_tpl.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath("styles/pagelet.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<%if(!server_side_included && !client_side_included){%>
<link rel='shortcut icon' href='../favicon.ico' />
<% sp.WriteStandardJSLibraries(out); %></head>
<body style='margin:0;'<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<style>#<%=PageletId%>_container{}#<%=PageletId%>_container #<%=PageletId%>__area_0_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_2_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_1_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_4_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_3_container{
  vertical-align:top;
}
</style><script>
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
var m_cSPParentObjId =   ZtVWeb.POM.addObj('<%=PageletId%>','spas_papplist_tpl','pageletObj', '<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%SPParentObjId=PageletId;

Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map<String,String> header_default_box=null;
Map apps_group_box=null;
if (ht!=null){
  apps_group_box=(Map)ht.get("apps_group");
  header_default_box=(Map)ht.get("header_default");
  if(apps_group_box!=null) apps_group_box.remove("header_default");
}
%>
<div class="type_12 pagelet_container" id="<%=PageletId%>_container"><%
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
uid= PageletId + ID_SEP +"_area_0";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_0" class="pagelet_item item_stretch_container block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_0','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_0','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_0";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_2";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_2" class="pagelet_item item_before_stretch_row block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_2','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_2','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_2";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_1";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_1" class="pagelet_item item_before_stretch_cell block_item  _row"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_1','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_1','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_1";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_resources_0";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','header_default','resourceObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><%
if(header_default_box!=null){request.setAttribute("PageletId",PageletId);
request.setAttribute("SPParentObjId",container_id);
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> class='pagelet_item block_item ' ps-resource-name=<%=JSPLib.ToHTMLValue("header_default")%> ><%
title_value=sp.translate((String)header_default_box.get("title"));
url=(String)header_default_box.get("url");
boolean RES_iframed_by_plan=url.charAt(0)=='!';
url= RES_iframed_by_plan ? url.substring(1, url.length()) : url ;
String resource_name= java.util.regex.Pattern.compile("(_portlet.jsp|../jsp/|../servlet/|(\\?.*))").matcher(url).replaceAll("");
String RES_content_name=uid + ID_SEP + resource_name;
%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><%
boolean RES_is_servlet=url.startsWith("../servlet/");
boolean RES_in_iframe=RES_iframed_by_plan||RES_is_servlet;
String RES_iframe_id, RES_res_url, RES_iframe_src, RES_onload;
RES_iframe_id=RES_res_url=RES_iframe_src=RES_onload="";
%><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': 'false', 'type':'url','name':'header_default','url':'<%=JSPLib.ToJSValue(url)%>','containerId':'<%=JSPLib.ToJSValue(container_id)%>', 'Id': '', 'contentId':'<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': <%=RES_in_iframe%>}
/*JS_MARKER_END*/
</script><%if(RES_in_iframe){
RES_iframe_id=RES_content_name;
RES_res_url=url +(url.indexOf("?")>-1? "&" : "?" )+"&PageletId="+PageletId+"&"+queryString;
RES_iframe_src=RES_res_url;
RES_onload="resizeIframe(this);";
%><%out.print("<iframe id="+JSPLib.ToHTMLValue(RES_iframe_id)+" name='header_default' data-sp-src="+JSPLib.ToHTMLValue(!com.zucchetti.sitepainter.Library.Empty(RES_iframe_src)?JSPLib.SPWebRootURL(request)+"/jsp/"+RES_iframe_src:"")+" onload="+JSPLib.ToHTMLValue(RES_onload)+" marginwidth='0' marginheight='0' style='width:100%;height:0px;' allowtransparency='true' frameborder='0' spparentobjid="+JSPLib.ToHTMLValue(container_id)+"></iframe>");
%><%}else{
  out.flush();
  Library.includeResource(request,response,"/jsp/"+url,false);
%><%}%></div><script>
/*JS_MARKER_START*/
<%if(RES_is_servlet){%>
ZtVWeb.addPortlet('<%=JSPLib.ToJSValue(RES_content_name)%>_i','<%=JSPLib.ToJSValue(RES_iframe_id)%>');
window.<%=JSPLib.ToJSValue(RES_content_name)%>_i=new function(){
  ZtVWeb.newForm(this,'<%=JSPLib.ToJSValue(RES_content_name)%>_i','<%=JSPLib.ToJSValue(RES_iframe_id)%>',200,200);
  this.on_<%=JSPLib.ToJSValue(RES_iframe_id)%>_driveEntity=function(parmsObj){
  this.<%=JSPLib.ToJSValue(RES_iframe_id)%>_splinker=new ZtVWeb.SPLinkerCtrl(this,'<%=JSPLib.ToJSValue(RES_iframe_id)%>_splinker','<%=JSPLib.ToJSValue(RES_content_name)%>_i_splinker',169,-29,30,30,'<%=JSPLib.GetValidVarName(resource_name)%>','','','false',' ',' ',' ','<%=JSPLib.GetValidVarName(resource_name)%>');
  this.<%=JSPLib.ToJSValue(RES_iframe_id)%>_splinker.action='view';
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
      this.<%=JSPLib.ToJSValue(RES_iframe_id)%>_splinker.action=parmsObj[prop]
    }
  }
  k_parms=k_parms.substring(0,k_parms.length-1)
  this.<%=JSPLib.ToJSValue(RES_iframe_id)%>_splinker.Parameters(k_parms)
  this.<%=JSPLib.ToJSValue(RES_iframe_id)%>_splinker.Link()
  }
}
ZtVWeb.addPortletObj('<%=JSPLib.ToJSValue(RES_content_name)%>_i', '<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(resource_name))%>', <%=JSPLib.GetValidVarName(RES_content_name)%>_i);
<%
RES_content_name=RES_iframe_id+"_i";
%><%}%>
window.portlet_list.push('<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(resource_name))%>');
/*JS_MARKER_END*/
</script></div><%}%><!--chiude if risorsa header_default--></div></div><%SPParentObjId=PageletId + ID_SEP + "_area_0";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_4";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_4" class="pagelet_item item_stretch_row block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_4','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_4','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_4";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_3";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%if( apps_group_box != null){%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_3" class="pagelet_item item_stretch_cell block_item  _row"><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_3','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_3','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_3";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_group_1";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%
if(apps_group_box!=null){
%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','apps','groupObj','<%=SPParentObjId%>');
	<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded':[], 'type': 'group', 'urls': [], 'resources': [], 'name': 'apps', 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [], 'containerId': '<%=container_id%>', 'contentId': '<%=content_id%>'};
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> data-ps-name="apps" class='pagelet_item item_stretch block_item '  title_as_portlet='default_title_portlet_portlet.jsp' ps-stretch-height ps-group ><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='' style=''><%
{int i=0;
for (Iterator<String> it = apps_group_box.keySet().iterator(); it.hasNext();i++){
String resource_name=it.next();
if (apps_group_box.get(resource_name)!=null){
request.setAttribute("PageletId",PageletId);
url=(String)((Map)apps_group_box.get(resource_name)).get("url");
String resource_i=(String)((Map)apps_group_box.get(resource_name)).get("name");
String resource_i_caption=(String)((Map)apps_group_box.get(resource_name)).get("title");
String resource_i_opened=(String)((Map)apps_group_box.get(resource_name)).get("opened");
boolean resource_i_iframed_by_plan=url.charAt(0)=='!';
url= resource_i_iframed_by_plan ? url.substring(1, url.length()) : url ;
boolean resource_i_is_servlet=url.startsWith("../servlet/");
boolean resource_i_iframed=resource_i_iframed_by_plan||resource_i_is_servlet;
String GROUP_element_resource_url= java.util.regex.Pattern.compile("(_portlet.jsp|../jsp/|../servlet/|(\\?.*))").matcher(url).replaceAll("");
String GROUP_element_container_id=PageletId + ID_SEP + resource_i + ID_SEP + CONTAINER_SUFFIX;
String GROUP_element_content_name=PageletId + ID_SEP + GROUP_element_resource_url;
String GROUP_element_content_id=PageletId + ID_SEP + resource_i + ID_SEP + CONTENT_SUFFIX;
request.setAttribute("SPParentObjId",GROUP_element_container_id);
%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>','<%=JSPLib.ToJSValue(resource_i)%>','resourceObj','<%=JSPLib.ToJSValue(container_id)%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(GROUP_element_container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue(resource_i)%> ps-group-item class="" style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>'].resources.push('<%=JSPLib.ToJSValue(resource_i)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].urls.push('<%=JSPLib.ToJSValue(GROUP_element_resource_url)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].Ids.push('');
<%=PageletId%>_pagelet_structure['<%=uid%>'].containerIds.push('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].contentIds.push('<%=JSPLib.ToJSValue(GROUP_element_content_id)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].inIframe.push(<%=resource_i_iframed%>);
<%=PageletId%>_pagelet_structure['<%=uid%>'].loaded.push(<%=(GROUP_element_resource_url.indexOf("_portlet.jsp")>-1?false:true)%>);
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(GROUP_element_content_id)%> style='display:<%if("true".equals(resource_i_opened)){ out.print("block");}else if("false".equals(resource_i_opened)){ out.print("none");}else{ out.print("block");}%>;'><%
String GROUP_iframe_id, GROUP_queryString, GROUP_res_url, GROUP_iframe_src, GROUP_onload, GROUP_input_id, GROUP_input_value;
GROUP_iframe_id = GROUP_queryString = GROUP_res_url = GROUP_iframe_src = GROUP_onload = GROUP_input_id = GROUP_input_value = "";
GROUP_res_url=url ;
String GROUP_onExpandTab="null";
GROUP_queryString=(GROUP_res_url.indexOf("?")==-1 ? "?" : "&")+"SPParentObjId="+GROUP_element_container_id+"&PageletId="+PageletId+"&"+queryString;
if(resource_i_iframed){
GROUP_iframe_id=GROUP_element_content_name;
GROUP_iframe_src=GROUP_res_url+GROUP_queryString;
GROUP_onload="resizeIframe(this);";
%><%out.print("<iframe id="+JSPLib.ToHTMLValue(GROUP_iframe_id)+" name="+JSPLib.ToHTMLValue(resource_i)+" src="+JSPLib.ToHTMLValue(!com.zucchetti.sitepainter.Library.Empty(GROUP_iframe_src)?JSPLib.SPWebRootURL(request)+"/jsp/"+GROUP_iframe_src:"")+""+(Library.IsMobile(request)? " toResize='no' style='min-width:100%;min-height:100%'":" onload="+JSPLib.ToHTMLValue(GROUP_onload)+" style='width:100%;height:0px'")+" marginwidth='0' marginheight='0' allowtransparency='true' frameborder='0' spparentobjid="+JSPLib.ToHTMLValue(GROUP_element_container_id)+"></iframe>");
%><%
}else{
if(Library.Empty(resource_i_opened) || "true".equals(resource_i_opened)){ 
  out.flush();
  Library.includeResource(request,response,"/jsp/"+GROUP_res_url,false);
}
GROUP_onExpandTab="ZtVWeb.AdjustContainer";
%><%}%></div></div><script>
/*JS_MARKER_START*/
<%if(resource_i_is_servlet){%>
ZtVWeb.addPortlet('<%=GROUP_iframe_id%>_<%=i%>_i','<%=GROUP_iframe_id%>');
window.<%=GROUP_iframe_id%>_<%=i%>_i=new function(){
  ZtVWeb.newForm(this,'<%=GROUP_iframe_id%>_<%=i%>_i','<%=GROUP_iframe_id%>',200,200);
  this.on_<%=GROUP_iframe_id%>_driveEntity=function(parmsObj){
  this.<%=GROUP_iframe_id%>_splinker=new ZtVWeb.SPLinkerCtrl(this,'<%=GROUP_iframe_id%>_splinker','<%=GROUP_iframe_id%>_<%=i%>_i_splinker',169,-29,30,30,'<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>','','','false',' ',' ',' ','<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>');
  this.<%=GROUP_iframe_id%>_splinker.action='view';
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
      this.<%=GROUP_iframe_id%>_splinker.action=parmsObj[prop]
    }
  }
  k_parms=k_parms.substring(0,k_parms.length-1)
  this.<%=GROUP_iframe_id%>_splinker.Parameters(k_parms)
  this.<%=GROUP_iframe_id%>_splinker.Link()
  }
}
ZtVWeb.addPortletObj('<%=JSPLib.ToJSValue(GROUP_iframe_id)%>_<%=i%>_i', '<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>', <%=GROUP_iframe_id%>_<%=i%>_i);
<%
GROUP_element_content_name=GROUP_iframe_id+"_i";
%><%}%>
Pagelet_mapId['<%=JSPLib.ToJSValue(resource_i)%>']='<%=JSPLib.ToJSValue(GROUP_element_content_id)%>';
window.portlet_list.push('<%=JSPLib.ToJSValue(JSPLib.GetValidVarName(GROUP_element_resource_url))%>');
/*JS_MARKER_END*/
</script><%}}}%><div style='clear:both;'></div></div></div><%}%><!--chiude gruppo apps--></div></div><%}%></div></div></div><script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this, {id:'<%=PageletId%>', steps:"", stretch:"true", dragAndDroppable: false});
	this._area_0= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":2,"id":"_area_0","name":"_area_0","renderWidth":12,"stretchBehavior":"stretch_container","type":"area","width":12});
	this._area_2= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_2","name":"_area_2","renderWidth":12,"stretchBehavior":"before_stretch_row","type":"area","width":12});
	this._area_1= new ZtVWeb.AreaCtrl( this,{"behavior":"show","cssClass":" _row","id":"_area_1","name":"_area_1","renderWidth":12,"stretchBehavior":"before_stretch_cell","type":"area","width":12});
<% if(header_default_box!=null){%>
	this.header_default= new ZtVWeb.ResourceCtrl(this,{"behavior":"show","id":"item_resources_0","layout_steps_values":{},"name":"header_default","open":true,"popupItems":[],"renderWidth":12,"type":"resource","width":12});
<%}%>
	this._area_4= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_4","name":"_area_4","renderWidth":12,"row":1,"stretchBehavior":"stretch_row","type":"area","width":12});
	this._area_3= new ZtVWeb.AreaCtrl( this,{"behavior":"show","cssClass":" _row","id":"_area_3","name":"_area_3","renderWidth":12,"row":1,"stretchBehavior":"stretch_cell","type":"area","width":12});
<%if(apps_group_box!=null){%>
	this.apps= new ZtVWeb.GroupCtrl(this, {"behavior":"show","id":"item_group_1","layout_steps_values":{},"name":"apps","open":true,"popupItems":[],"renderWidth":12,"row":1,"strechStructure":"{\"table\":\"_area_0\", \"row\": \"_area_4\", \"cell\": \"_area_3\"}","stretch":true,"type":"group","width":12});
<%}%>
  this.planName='<%=(planName!=null?planName:"")%>';
  this.Calc= function(){
    if(!Empty(this.planName) && window[this.planName] )
      window[this.planName].Calc(this);
  }
  /*ActionCode*/
  
  
  /*End ActionCode*/
};
<% if(header_default_box!=null){%>
window.<%=PageletId%>.header_default.setSrc();
<%}
if(!pagelet_yet_included && !client_side_included){%>
function getPagelet(){return window.<%=PageletId%>;}
<%}%>
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'spas_papplist_tpl','<%=JSPLib.ToJSValue(includerPageletId,false,true)%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html>
<%}%>
