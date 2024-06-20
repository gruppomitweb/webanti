<%/*Type:PageletEditor*/%>
<%//Def:[{"id":"pagelet","name":"pagelet","type":"pagelet","template":"7","cols_n":"20","rows_n":"2","width":"960px","height":"100%","css":"","css_Class":"loginPage ","color":"","security":"none","on_security_failure":"empty","roles":"","cache_time":"0","sp_theme":"true","offline":"false","shared_manifest":"false","manifest":"Custom manifest","action_code":"","description":"","steps":"","layout_step":"","is960":"false","steppable_prop":[],"stretch":"true","css_class":"loginPage","codemanifest":"","css_code":"[{\"version\":1,\"specific_states_value\":{\"normal\":{\"mar_top\":\"0\",\"mar_bottom\":\"0\",\"mar_left\":\"auto\",\"mar_right\":\"auto\",\"border_type\":\"solid\",\"shadow_type\":\"outline\",\"code\":\"width: auto;\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"loginPage\",\"selector\":\".loginPage .item_stretch_container.item_behavior_show\",\"id\":\"form\",\"code\":\".loginPage .item_stretch_container.item_behavior_show {\\n  margin-top: 0px;\\n  margin-right: auto;\\n  margin-bottom: 0px;\\n  margin-left: auto;\\n  width: auto;\\n}\\n\"},{\"version\":1,\"specific_states_value\":{\"normal\":{\"code\":\"\"},\"hover\":{},\":before\":{},\":after\":{}},\"current_state\":\"normal\",\"font_list\":[],\"type\":\"undefined_type\",\"class_name\":\"loginPage\",\"selector\":\".loginPage\",\"id\":\"form\",\"code\":\"\"}]"},{"id":"item_area_3","name":"container_login","type":"area","titled":"false","title":"","open":"true","row":"0","col":"0","height":"1","width":"20","prefx":"0","suffx":"0","inserted":"true","items":[],"z":"0","layout":"false","area_type":"normal","minWidth":"","maxWidth":"","width_perc":"","hidden":"false","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","layoutClass","width_perc","minWidth","maxWidth","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","o_c_routune":"","routineParms":"","caption":"","droppable":"false","curTab":"generic"},{"id":"item_area_6","name":"content_login","type":"area","titled":"false","title":"","open":"true","row":"0","col":"0","height":"1","width":"20","prefx":"0","suffx":"0","inserted":"true","items":[],"z":"0","layout":"row nowrap","area_type":"normal","minWidth":"","maxWidth":"","width_perc":"","hidden":"false","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","layoutClass","width_perc","minWidth","maxWidth","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","o_c_routune":"","routineParms":"","caption":"","droppable":"false","curTab":"generic"},{"id":"item_static_5","type":"static","name":"images","src":"../jsp-decorators/start_page_images_login_portlet.jsp","parameters":"","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"0","col":"0","height":"1","width":"16","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","caption":"","draggable":"false","hidden":"false","curTab":"generic"},{"id":"item_area_7","name":"right_login","type":"area","titled":"false","title":"","open":"true","row":"0","col":"16","height":"1","width":"4","prefx":"0","suffx":"0","inserted":"true","items":[],"z":"0","layout":"false","area_type":"normal","minWidth":"413","maxWidth":"","width_perc":"","hidden":"false","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","layoutClass","width_perc","minWidth","maxWidth","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","o_c_routune":"","routineParms":"","caption":"","droppable":"false","curTab":"advanced"},{"id":"item_static_0","type":"static","name":"login","src":"start_page_login_portlet.jsp","parameters":" ","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"0","col":"16","height":"1","width":"4","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","caption":"","draggable":"false","toremove":"","collapsable":"false","collapser":"","width_close":"18","hidden":"false","curTab":"generic","areaContainer":"eaory","renderWidth":"20"}]%>
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
%><!-- PageletName=index_tpl -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"index_tpl","UTF-8")) {return; }
 %><%response.setHeader("Cache-Control","max-age = 0");
response.setDateHeader("Expires", 0);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".index_tpl","index_tpl");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","index_tpl");
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/index_tpl.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath("styles/pagelet.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<% sp.WritePortalStudioCSS(request, out);
if(!server_side_included && !client_side_included){%>
<link rel='shortcut icon' href='../favicon.ico' />
<% sp.WriteStandardJSLibraries(out); %></head>
<body style='margin:0;'<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<style>.loginPage .item_stretch_container.item_behavior_show {
  margin-top: 0px;
  margin-right: auto;
  margin-bottom: 0px;
  margin-left: auto;
  width: auto;
}
#<%=PageletId%>_container{}#<%=PageletId%>_container #<%=PageletId%>__area_9_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_11_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_10_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>_item_area_3_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_6_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_8_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_7_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>_item_area_6_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_3_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_5_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_4_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>_item_area_7_container{
  vertical-align:top;
  min-width:413px;
}
#<%=PageletId%>_container #<%=PageletId%>__area_0_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_2_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_1_container{
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
var m_cSPParentObjId =   ZtVWeb.POM.addObj('<%=PageletId%>','index_tpl','pageletObj', '<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%SPParentObjId=PageletId;

Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
if (ht!=null){
}
%>
<div class="type_20 pagelet_container loginPage " id="<%=PageletId%>_container"><%
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
uid= PageletId + ID_SEP +"_area_9";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_9" class="pagelet_item item_stretch_container block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_9','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_9','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_9";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_11";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_11" class="pagelet_item item_stretch_row block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_11','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_11','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_11";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_10";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_10" class="pagelet_item item_stretch_cell block_item"><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_10','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_10','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_10";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_area_3";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="container_login" class="pagelet_item item_stretch_container item_stretch block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'container_login','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','container_login','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "item_area_3";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_6";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_6" class="pagelet_item item_stretch_container block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_6','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_6','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_6";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_8";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_8" class="pagelet_item item_stretch_row block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_8','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_8','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_8";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_7";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_7" class="pagelet_item item_stretch_cell block_item"><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_7','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_7','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_7";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_area_6";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="content_login" class="pagelet_item item_stretch_container item_stretch block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'content_login','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','content_login','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "item_area_6";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_3";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_3" class="pagelet_item item_stretch_container flex_item" ps-layout-style='row nowrap'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_3','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_3','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_3";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_5";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_5" class="pagelet_item item_stretch_row flex_item" ps-layout-style='row nowrap'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_5','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_5','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_5";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_4";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_4" class="pagelet_item item_stretch_cell flex_item" ps-layout-style='row nowrap'><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='flexArea row nowrap' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_4','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_4','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_4";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_static_5";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%request.setAttribute("SPParentObjId",container_id);%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','images','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("images")%> name="images" class='pagelet_item  item_stretch flex_item ' ps-layout-style='row nowrap' title_as_portlet='default_title_portlet_portlet.jsp' ps-stretch-height><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
String content_name;
String res_url;
%><%
url="../jsp-decorators/start_page_images_login_portlet.jsp";
content_name= uid + ID_SEP + "../jsp-decorators/start_page_images_login";
parms_joiner = "?";
res_url="../jsp-decorators/start_page_images_login_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'images','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': '../jsp-decorators/start_page_images_login_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/../jsp-decorators/start_page_images_login_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/../jsp-decorators/start_page_images_login_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/../jsp-decorators/start_page_images_login_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/../jsp-decorators/start_page_images_login_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('../jsp-decorators/start_page_images_login');
/*JS_MARKER_END*/
</script></div><%SPParentObjId=PageletId + ID_SEP + "_area_4";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_area_7";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="right_login" class="pagelet_item item_stretch_container item_stretch flex_item" ps-layout-style='row nowrap'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'right_login','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','right_login','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "item_area_7";%><%
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
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_2" class="pagelet_item item_stretch_row block_item"><script>
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
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_1" class="pagelet_item item_stretch_cell block_item"><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_1','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_1','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_1";%><%
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
  ZtVWeb.POM.addObj('<%=container_id%>','login','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("login")%> name="login" class='pagelet_item  item_stretch block_item ' title_as_portlet='default_title_portlet_portlet.jsp' ps-stretch-height><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
%><%
url="start_page_login_portlet.jsp";
content_name= uid + ID_SEP + "start_page_login";
parms_joiner = "?";
res_url="start_page_login_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'login','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': 'start_page_login_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/start_page_login_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/start_page_login_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/start_page_login_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/start_page_login_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('start_page_login');
/*JS_MARKER_END*/
</script></div></div></div></div></div></div></div></div></div></div></div></div></div></div></div></div></div></div></div></div></div><script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this, {id:'<%=PageletId%>', steps:"", stretch:"true", dragAndDroppable: false});
	this._area_9= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_9","name":"_area_9","renderWidth":20,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_11= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_11","name":"_area_11","renderWidth":20,"stretchBehavior":"stretch_row","type":"area","width":20});
	this._area_10= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_10","name":"_area_10","renderWidth":20,"stretchBehavior":"stretch_cell","type":"area","width":20});
	this.container_login= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"item_area_3","layout_steps_values":{},"name":"container_login","open":true,"popupItems":[],"renderWidth":20,"strechStructure":"{\"table\":\"_area_9\", \"row\": \"_area_11\", \"cell\": \"_area_10\"}","stretch":true,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_6= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_6","name":"_area_6","renderWidth":20,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_8= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_8","name":"_area_8","renderWidth":20,"stretchBehavior":"stretch_row","type":"area","width":20});
	this._area_7= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_7","name":"_area_7","renderWidth":20,"stretchBehavior":"stretch_cell","type":"area","width":20});
	this.content_login= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"item_area_6","layout":"row nowrap","layout_steps_values":{},"name":"content_login","open":true,"popupItems":[],"renderWidth":20,"strechStructure":"{\"table\":\"_area_6\", \"row\": \"_area_8\", \"cell\": \"_area_7\"}","stretch":true,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_3= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_3","layout":"row nowrap","layout_item_style":"row nowrap","name":"_area_3","renderWidth":20,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_5= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_5","layout":"row nowrap","layout_item_style":"row nowrap","name":"_area_5","renderWidth":20,"stretchBehavior":"stretch_row","type":"area","width":20});
	this._area_4= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_4","layout":"row nowrap","layout_item_style":"row nowrap","name":"_area_4","renderWidth":20,"stretchBehavior":"stretch_cell","type":"area","width":20});
	this.images= new ZtVWeb.StaticCtrl(this, {"behavior":"show","id":"item_static_5","layout_item_style":"row nowrap","layout_steps_values":{},"name":"images","open":true,"popupItems":[],"renderWidth":16,"strechStructure":"{\"table\":\"_area_3\", \"row\": \"_area_5\", \"cell\": \"_area_4\"}","stretch":true,"type":"static","width":16});
	this.right_login= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":16,"id":"item_area_7","layout_item_style":"row nowrap","layout_steps_values":{},"name":"right_login","open":true,"popupItems":[],"renderWidth":4,"strechStructure":"{\"table\":\"_area_3\", \"row\": \"_area_5\", \"cell\": \"_area_4\"}","stretch":true,"stretchBehavior":"stretch_container","type":"area","width":4});
	this._area_0= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":16,"id":"_area_0","name":"_area_0","renderWidth":20,"stretchBehavior":"stretch_container","type":"area","width":4});
	this._area_2= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":16,"id":"_area_2","name":"_area_2","renderWidth":20,"stretchBehavior":"stretch_row","type":"area","width":4});
	this._area_1= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":16,"id":"_area_1","name":"_area_1","renderWidth":20,"stretchBehavior":"stretch_cell","type":"area","width":4});
	this.login= new ZtVWeb.StaticCtrl(this, {"behavior":"show","col":16,"id":"item_static_0","layout_steps_values":{},"name":"login","open":true,"popupItems":[],"renderWidth":20,"strechStructure":"{\"table\":\"_area_0\", \"row\": \"_area_2\", \"cell\": \"_area_1\"}","stretch":true,"type":"static","width":4});
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
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'index_tpl','<%=JSPLib.ToJSValue(includerPageletId,false,true)%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html>
<%}%>
