<%/*Type:PageletEditor*/%>
<%//Def:[{"id":"pagelet","name":"pagelet","type":"pagelet","template":"7","cols_n":"20","rows_n":"5","width":"960px","height":"100%","css":"","css_Class":"defaultPageletContainer","color":"","security":"none","on_security_failure":"login","roles":"","cache_time":"0","sp_theme":" ","offline":"false","shared_manifest":"false","manifest":"Custom manifest","action_code":"function ToggleLeftSide(){\n\tif(this.left_side_area.isHidden()){\n    this.left_side_area.showItem();\n    this.main_area.renderWidth = 16;\n\t} else {\n\t\tthis.left_side_area.hideItem();\n    this.main_area.renderWidth = 20;\n  }\n  this.main_area.setDimension();\n}\n","description":"","steps":"0,1024","layout_step":"1024","is960":"false","steppable_prop":[],"codemanifest":"","css_code":"[]","v_line":"1024"},{"id":"item_static_16","type":"static","name":"header","src":"start_page_menu_orizz_portlet.jsp","parameters":"","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"0","col":"0","height":"1","width":"20","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{"0":{"row":"0","col":"0","width":"20","height":"1","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"},"1024":{"row":"0","col":"0","width":"20","height":"1","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","caption":"","draggable":"false","hidden":"false","curTab":"generic"},{"id":"item_area_11","name":"body_area","type":"area","titled":"false","title":"","open":"true","row":"1","col":"0","height":"2","width":"20","prefx":"0","suffx":"0","inserted":"true","items":[],"z":"0","layout":"row wrap","area_type":"normal","minWidth":"","maxWidth":"","width_perc":"","hidden":"false","behavior":"show","layout_steps_values":{"0":{"row":"1","col":"0","width":"20","height":"2","behavior":"show","width_perc":"","minWidth":"","maxWidth":"","popupItems":[],"prefx":"0","suffx":"0"},"1024":{"row":"1","col":"0","width":"20","height":"2","behavior":"show","width_perc":"","minWidth":"","maxWidth":"","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","layoutClass","width_perc","minWidth","maxWidth","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","o_c_routune":"","routineParms":"","caption":"","droppable":"false","curTab":"advanced"},{"id":"item_area_4","name":"left_side_area","type":"area","titled":"false","title":"","open":"true","row":"1","col":"0","height":"2","width":"6","prefx":"0","suffx":"0","inserted":"true","items":[],"z":"0","layout":"false","area_type":"normal","minWidth":"250","maxWidth":"250","width_perc":"","hidden":"false","behavior":"show","layout_steps_values":{"0":{"row":"1","col":"0","width":"6","height":"2","behavior":"hide","width_perc":"","minWidth":"250","maxWidth":"250","popupItems":[],"prefx":"0","suffx":"0"},"1024":{"row":"1","col":"0","width":"6","height":"2","behavior":"show","width_perc":"","minWidth":"250","maxWidth":"250","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","layoutClass","width_perc","minWidth","maxWidth","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","o_c_routune":"","routineParms":"","caption":"","droppable":"false","curTab":"generic","css_Class":"left-white-shadow"},{"id":"item_static_17","type":"static","name":"calendar","src":"start_page_clock_portlet.jsp","parameters":"","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"1","col":"0","height":"1","width":"6","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{"0":{"row":"1","col":"0","width":"6","height":"1","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"},"1024":{"row":"1","col":"0","width":"6","height":"1","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","caption":"","draggable":"false","hidden":"false","curTab":"generic"},{"id":"item_area_5","name":"main_area","type":"area","titled":"false","title":"","open":"true","row":"1","col":"6","height":"2","width":"14","prefx":"0","suffx":"0","inserted":"true","items":[],"z":"0","layout":"false","area_type":"normal","minWidth":"","maxWidth":"","width_perc":"","hidden":"false","behavior":"show","layout_steps_values":{"0":{"row":"1","col":"6","width":"14","height":"2","behavior":"show","width_perc":"","minWidth":"","maxWidth":"","popupItems":[],"prefx":"0","suffx":"0"},"1024":{"row":"1","col":"6","width":"14","height":"2","behavior":"show","width_perc":"","minWidth":"","maxWidth":"","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","layoutClass","width_perc","minWidth","maxWidth","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","o_c_routune":"","routineParms":"","caption":"","droppable":"false","curTab":"advanced","css_Class":"main-area"},{"id":"item_group_18","type":"group","name":"central","titled":"false","title":"","open":"true","layout":"multiple","row":"1","col":"6","height":"2","width":"14","prefx":"0","suffx":"0","inserted":"true","content":"main","pre_loaded":"false","behavior":"show","layout_steps_values":{"1024":{"row":"1","col":"6","width":"14","height":"2","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","caption":"","draggable":"false","hidden":"false","curTab":"advanced","tabs_target":"tab","tabstrip_class":"mainPageTabstrip"},{"id":"item_group_13","type":"group","name":"sx","titled":"false","title":"","open":"true","layout":"false","row":"2","col":"0","height":"1","width":"6","prefx":"0","suffx":"0","inserted":"true","content":"mypostin","pre_loaded":"false","behavior":"show","layout_steps_values":{"0":{"row":"2","col":"0","width":"6","height":"1","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"},"1024":{"row":"2","col":"0","width":"6","height":"1","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","caption":"","draggable":"false","hidden":"false","curTab":"generic"},{"id":"item_static_19","type":"static","name":"speech_grammar_portletContainer","src":"../jsp-system/grammar_include_lite_portlet.jsp","parameters":"","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"3","col":"0","height":"1","width":"20","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{"1024":{"row":"3","col":"0","width":"20","height":"1","behavior":"show","popupItems":[],"prefx":"0","suffx":"0"}},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","caption":"","draggable":"false","hidden":"false","curTab":"generic"}]%>
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
%><!-- PageletName=default_tpl -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"default_tpl","UTF-8")) {return; }
 %><%response.setHeader("Cache-Control","max-age = 0");
response.setDateHeader("Expires", 0);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".default_tpl","default_tpl");
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
<html>
<head>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/default_tpl.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath("styles/pagelet.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<%if(!server_side_included && !client_side_included){%>
<link rel='shortcut icon' href='../favicon.ico' />
<% sp.WriteStandardJSLibraries(out); %></head>
<body style='margin:0;'<%= sp.GetBodyClassAttribute() %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}%>
<style>#<%=PageletId%>_container{}#<%=PageletId%>_container #<%=PageletId%>__area_6_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_8_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_7_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_10_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_9_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>_item_area_11_container{
  vertical-align:top;
}
#<%=PageletId%>_container[data-step="0"] #<%=PageletId%>_item_area_11_container{
  width:%;
  min-width:px;
  max-width:px;
}
#<%=PageletId%>_container[data-step="1024"] #<%=PageletId%>_item_area_11_container{
  width:%;
  min-width:px;
  max-width:px;
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
#<%=PageletId%>_container #<%=PageletId%>_item_area_4_container{
  vertical-align:top;
  min-width:250px;
  max-width:250px;
}
#<%=PageletId%>_container[data-step="0"] #<%=PageletId%>_item_area_4_container{
  width:%;
  min-width:250px;
  max-width:250px;
}
#<%=PageletId%>_container[data-step="1024"] #<%=PageletId%>_item_area_4_container{
  width:%;
  min-width:250px;
  max-width:250px;
}
#<%=PageletId%>_container #<%=PageletId%>_item_area_5_container{
  vertical-align:top;
}
#<%=PageletId%>_container[data-step="0"] #<%=PageletId%>_item_area_5_container{
  width:%;
  min-width:px;
  max-width:px;
}
#<%=PageletId%>_container[data-step="1024"] #<%=PageletId%>_item_area_5_container{
  width:%;
  min-width:px;
  max-width:px;
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
#<%=PageletId%>_container #<%=PageletId%>__area_12_container{
  vertical-align:top;
}
#<%=PageletId%>_container #<%=PageletId%>__area_11_container{
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
var m_cSPParentObjId =   ZtVWeb.POM.addObj('<%=PageletId%>','default_tpl','pageletObj', '<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%SPParentObjId=PageletId;
if(!tabs_libraries_included){%>
<link type='text/css' rel='stylesheet' href='<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<script src='<%=JSPLib.SPWebRootURL(request)%>/<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>'></script>
<%request.setAttribute("javax.servlet.include.tabs_libraries_included","true");
}%>
<%
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map sx_group_box=null;
Map central_group_box=null;
if (ht!=null){
  sx_group_box=(Map)ht.get("sx_group");
  central_group_box=(Map)ht.get("central_group");
}
%>
<div class="type_20 pagelet_container defaultPageletContainer" id="<%=PageletId%>_container"><%
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
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_8" class="pagelet_item item_before_stretch_row block_item"><script>
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
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_7" class="pagelet_item item_before_stretch_cell block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_7','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_7','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_7";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_static_16";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%request.setAttribute("SPParentObjId",container_id);%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','header','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("header")%> name="header" class='pagelet_item  block_item ' title_as_portlet='default_title_portlet_portlet.jsp'><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
String content_name;
String res_url;
%><%
url="start_page_menu_orizz_portlet.jsp";
content_name= uid + ID_SEP + "start_page_menu_orizz";
parms_joiner = "?";
res_url="start_page_menu_orizz_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'header','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': 'start_page_menu_orizz_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/start_page_menu_orizz_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/start_page_menu_orizz_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/start_page_menu_orizz_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/start_page_menu_orizz_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('start_page_menu_orizz');
/*JS_MARKER_END*/
</script></div></div></div><%SPParentObjId=PageletId + ID_SEP + "_area_6";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_10";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_10" class="pagelet_item item_stretch_row block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_10','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_10','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_10";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_9";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_9" class="pagelet_item item_stretch_cell block_item"><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_9','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_9','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_9";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_area_11";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="body_area" class="pagelet_item item_stretch_container item_stretch block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'body_area','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','body_area','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "item_area_11";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_3";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_3" class="pagelet_item item_stretch_container flex_item" ps-layout-style='row wrap'><script>
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
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_5" class="pagelet_item item_stretch_row flex_item" ps-layout-style='row wrap'><script>
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
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_4" class="pagelet_item item_stretch_cell flex_item   left-white-shadow_row  main-area_row" ps-layout-style='row wrap'><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='flexArea row wrap' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_4','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_4','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_4";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_area_4";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="left_side_area" class="pagelet_item item_stretch flex_item left-white-shadow item_behavior_hide " ps-layout-style='row wrap'><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'left_side_area','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','left_side_area','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "item_area_4";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_static_17";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%request.setAttribute("SPParentObjId",container_id);%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','calendar','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("calendar")%> name="calendar" class='pagelet_item  block_item ' title_as_portlet='default_title_portlet_portlet.jsp'><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
%><%
url="start_page_clock_portlet.jsp";
content_name= uid + ID_SEP + "start_page_clock";
parms_joiner = "?";
res_url="start_page_clock_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'calendar','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': 'start_page_clock_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/start_page_clock_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/start_page_clock_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/start_page_clock_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/start_page_clock_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('start_page_clock');
/*JS_MARKER_END*/
</script></div><%SPParentObjId=PageletId + ID_SEP + "item_area_4";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_group_13";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%
if(sx_group_box!=null){
%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','sx','groupObj','<%=SPParentObjId%>');
	<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded':[], 'type': 'group', 'urls': [], 'resources': [], 'name': 'sx', 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [], 'containerId': '<%=container_id%>', 'contentId': '<%=content_id%>'};
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> data-ps-name="sx" class='pagelet_item block_item '  title_as_portlet='default_title_portlet_portlet.jsp' ps-group ><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='' style=''><%
{int i=0;
for (Iterator<String> it = sx_group_box.keySet().iterator(); it.hasNext();i++){
String resource_name=it.next();
if (sx_group_box.get(resource_name)!=null){
request.setAttribute("PageletId",PageletId);
url=(String)((Map)sx_group_box.get(resource_name)).get("url");
String resource_i=(String)((Map)sx_group_box.get(resource_name)).get("name");
String resource_i_caption=(String)((Map)sx_group_box.get(resource_name)).get("title");
String resource_i_opened=(String)((Map)sx_group_box.get(resource_name)).get("opened");
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
</script><%}}}%><div style='clear:both;'></div></div></div><%}%><!--chiude gruppo sx--></div></div><%SPParentObjId=PageletId + ID_SEP + "_area_4";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_area_5";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="main_area" class="pagelet_item item_stretch_container item_stretch flex_item main-area" ps-layout-style='row wrap'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'main_area','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','main_area','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "item_area_5";%><%
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
%><%if( central_group_box != null){%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_1" class="pagelet_item item_stretch_cell block_item"><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_1','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_1','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_1";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_group_18";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%
if(central_group_box!=null){
%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','central','groupObj','<%=SPParentObjId%>');
	<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded':[], 'type': 'group', 'urls': [], 'resources': [], 'name': 'central', 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [], 'containerId': '<%=container_id%>', 'contentId': '<%=content_id%>', 'tabs': [], 'preloaded': false};
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> data-ps-name="central" class='pagelet_item item_stretch block_item '  title_as_portlet='default_title_portlet_portlet.jsp' ps-stretch-height ps-group ><%
String tabs_id;
String tabs_div;
String tabs_js;
tabs_id=PageletId + ID_SEP + "central_tabs";
tabs_div=tabs_id + ID_SEP + CONTAINER_SUFFIX;
tabs_js="window." + tabs_id;
%><div id=<%=JSPLib.ToHTMLValue(tabs_div)%> tabstrip></div><script>
/*JS_MARKER_START*/
<%=tabs_js%>=new Z.Tabs({container:'<%=JSPLib.ToJSValue(tabs_div)%>',useseparator:SPTheme['colTabUseSeparator'],expandcollapse:(typeof(SPTheme['formTabCanCollapse'])!='undefined'?SPTheme['formTabCanCollapse']:true),wizard: false,tabstrip_class: 'mainPageTabstrip'});<%=tabs_js%>.tabList=new Array();
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='' style='height:calc(100% - <%=Library.GetStyleVariable(sp.getSkin(), "formTabH", "mainPageTabstrip", 0)%>px)'><%
{int i=0;
for (Iterator<String> it = central_group_box.keySet().iterator(); it.hasNext();i++){
String resource_name=it.next();
if (central_group_box.get(resource_name)!=null){
request.setAttribute("PageletId",PageletId);
url=(String)((Map)central_group_box.get(resource_name)).get("url");
String resource_i=(String)((Map)central_group_box.get(resource_name)).get("name");
String resource_i_caption=(String)((Map)central_group_box.get(resource_name)).get("title");
String resource_i_opened=(String)((Map)central_group_box.get(resource_name)).get("opened");
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
  ZtVWeb.POM.addObj('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>_tab_window','<%=JSPLib.ToJSValue(resource_i)%>_tab_window','tabWindowObj','<%=JSPLib.ToJSValue(container_id)%>');
  ZtVWeb.POM.addObj('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>','<%=JSPLib.ToJSValue(resource_i)%>','resourceObj','<%=JSPLib.ToJSValue(GROUP_element_container_id)%>_tab_window');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(GROUP_element_container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue(resource_i)%> ps-group-item class="" style='display:none;height:100%;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>'].resources.push('<%=JSPLib.ToJSValue(resource_i)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].urls.push('<%=JSPLib.ToJSValue(GROUP_element_resource_url)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].Ids.push('');
<%=PageletId%>_pagelet_structure['<%=uid%>'].containerIds.push('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].contentIds.push('<%=JSPLib.ToJSValue(GROUP_element_content_id)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].inIframe.push(<%=resource_i_iframed%>);
<%=PageletId%>_pagelet_structure['<%=uid%>'].tabs.push('<%=JSPLib.ToJSValue(GROUP_element_container_id)%>');
<%=PageletId%>_pagelet_structure['<%=uid%>'].loaded.push(<%=(GROUP_element_resource_url.indexOf("_portlet.jsp")>-1?false:true)%>);
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(GROUP_element_content_id)%> style='display:<%if("true".equals(resource_i_opened)){ out.print("block");}else if("false".equals(resource_i_opened)){ out.print("none");}else{ out.print("block");}%>;height:100%;'><%
String GROUP_iframe_id, GROUP_queryString, GROUP_res_url, GROUP_iframe_src, GROUP_onload, GROUP_input_id, GROUP_input_value;
GROUP_iframe_id = GROUP_queryString = GROUP_res_url = GROUP_iframe_src = GROUP_onload = GROUP_input_id = GROUP_input_value = "";
GROUP_res_url=url ;
String GROUP_onExpandTab="null";
GROUP_queryString=(GROUP_res_url.indexOf("?")==-1 ? "?" : "&")+"SPParentObjId="+GROUP_element_container_id+"&PageletId="+PageletId+"&"+queryString;
if(resource_i_iframed){
GROUP_iframe_id=GROUP_element_content_name;
if(i==0){
GROUP_iframe_src=GROUP_res_url+GROUP_queryString;
}else{
GROUP_input_id=GROUP_element_content_id + ID_SEP +"src";
GROUP_input_value=GROUP_res_url+GROUP_queryString;
GROUP_iframe_src="";
GROUP_onExpandTab="function(){var src=document.getElementById('"+GROUP_iframe_id+"').getAttribute('src');if (EmptyString(src)){window.resizeIframe('" + GROUP_element_content_name + "',window.document.getElementById('" + GROUP_input_id + "').value);}}";
}GROUP_onload="resizeIframe(this);";
%><input type='hidden' id=<%=JSPLib.ToHTMLValue(GROUP_input_id)%> value=<%=JSPLib.ToHTMLValue(GROUP_input_value)%>><%out.print("<iframe id="+JSPLib.ToHTMLValue(GROUP_iframe_id)+" name="+JSPLib.ToHTMLValue(resource_i)+" src="+JSPLib.ToHTMLValue(!com.zucchetti.sitepainter.Library.Empty(GROUP_iframe_src)?JSPLib.SPWebRootURL(request)+"/jsp/"+GROUP_iframe_src:"")+""+(Library.IsMobile(request)? " toResize='no' style='min-width:100%;min-height:100%'":" ps-stretch-height onload="+JSPLib.ToHTMLValue(GROUP_onload)+" style='width:100%;height:0px'")+" marginwidth='0' marginheight='0' allowtransparency='true' frameborder='0' spparentobjid="+JSPLib.ToHTMLValue(GROUP_element_container_id)+"></iframe>");
%><%
}else{
if(i==0){
if(Library.Empty(resource_i_opened) || "true".equals(resource_i_opened)){ 
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
};%><%}%></div><script>
/*JS_MARKER_START*/
<%=tabs_js%>.AddTab({name:'<%=JSPLib.ToJSValue(GROUP_element_container_id)%>', element:'<%=JSPLib.ToJSValue(GROUP_element_container_id)%>',caption:'<%=JSPLib.ToJSValue(sp.translate(resource_i_caption))%>',onExpand:<%=GROUP_onExpandTab%>});
<%=tabs_js%>.tabList[<%=i%>]= '<%=JSPLib.ToJSValue(GROUP_element_container_id)%>';
/*JS_MARKER_END*/
</script></div><script>
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
</script><%}}}%><div style='clear:both;'></div></div></div><%}%><!--chiude gruppo central--></div></div><%}%></div></div></div></div></div></div></div></div></div></div></div><%SPParentObjId=PageletId + ID_SEP + "_area_6";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_12";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_12" class="pagelet_item item_after_stretch_row block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_12','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_12','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_12";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"_area_11";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_11" class="pagelet_item item_after_stretch_cell block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_11','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_11','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_11";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_static_19";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><%request.setAttribute("SPParentObjId",container_id);%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','speech_grammar_portletContainer','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("speech_grammar_portletContainer")%> name="speech_grammar_portletContainer" class='pagelet_item  block_item ' title_as_portlet='default_title_portlet_portlet.jsp'><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
%><%
url="../jsp-system/grammar_include_lite_portlet.jsp";
content_name= uid + ID_SEP + "../jsp-system/grammar_include_lite";
parms_joiner = "?";
res_url="../jsp-system/grammar_include_lite_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'speech_grammar_portletContainer','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': '../jsp-system/grammar_include_lite_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/../jsp-system/grammar_include_lite_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/../jsp-system/grammar_include_lite_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/../jsp-system/grammar_include_lite_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/../jsp-system/grammar_include_lite_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('../jsp-system/grammar_include_lite');
/*JS_MARKER_END*/
</script></div></div></div></div></div><script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this, {id:'<%=PageletId%>', steps:"0,1024", stretch:"true", dragAndDroppable: false});
	this._area_6= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":4,"id":"_area_6","name":"_area_6","renderWidth":20,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_8= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_8","name":"_area_8","renderWidth":20,"stretchBehavior":"before_stretch_row","type":"area","width":20});
	this._area_7= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_7","name":"_area_7","renderWidth":20,"stretchBehavior":"before_stretch_cell","type":"area","width":20});
	this.header= new ZtVWeb.StaticCtrl(this, {"behavior":"show","id":"item_static_16","layout_steps_values":{"0":{"behavior":"show","col":"0","height":"1","popupItems":[],"prefx":0,"renderWidth":20,"row":"0","suffx":0,"width":"20"},"1024":{"behavior":"show","col":"0","height":"1","popupItems":[],"prefx":0,"renderWidth":20,"row":"0","suffx":0,"width":"20"}},"name":"header","open":true,"popupItems":[],"type":"static","width":20});
	this._area_10= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":2,"id":"_area_10","name":"_area_10","renderWidth":20,"row":1,"stretchBehavior":"stretch_row","type":"area","width":20});
	this._area_9= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":2,"id":"_area_9","name":"_area_9","renderWidth":20,"row":1,"stretchBehavior":"stretch_cell","type":"area","width":20});
	this.body_area= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":2,"id":"item_area_11","layout":"row wrap","layout_steps_values":{"0":{"behavior":"show","col":"0","height":"2","maxWidth":"","minWidth":"","popupItems":[],"prefx":0,"renderWidth":20,"row":"1","suffx":0,"width":"20","width_perc":""},"1024":{"behavior":"show","col":"0","height":"2","maxWidth":"","minWidth":"","popupItems":[],"prefx":0,"renderWidth":20,"row":"1","suffx":0,"width":"20","width_perc":""}},"name":"body_area","open":true,"popupItems":[],"row":1,"strechStructure":"{\"table\":\"_area_6\", \"row\": \"_area_10\", \"cell\": \"_area_9\"}","stretch":true,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_3= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":2,"id":"_area_3","layout":"row wrap","layout_item_style":"row wrap","name":"_area_3","renderWidth":20,"row":1,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_5= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":2,"id":"_area_5","layout":"row wrap","layout_item_style":"row wrap","name":"_area_5","renderWidth":20,"row":1,"stretchBehavior":"stretch_row","type":"area","width":20});
	this._area_4= new ZtVWeb.AreaCtrl( this,{"behavior":"show","cssClass":"  left-white-shadow_row  main-area_row","height":2,"id":"_area_4","layout":"row wrap","layout_item_style":"row wrap","name":"_area_4","renderWidth":20,"row":1,"stretchBehavior":"stretch_cell","type":"area","width":20});
	this.left_side_area= new ZtVWeb.AreaCtrl( this,{"behavior":"show","cssClass":"left-white-shadow","height":2,"id":"item_area_4","layout_item_style":"row wrap","layout_steps_values":{"0":{"behavior":"hide","col":"0","height":"2","maxWidth":"250","minWidth":"250","popupItems":[],"prefx":0,"renderWidth":6,"row":"1","suffx":0,"width":"6","width_perc":""},"1024":{"behavior":"show","col":"0","height":"2","maxWidth":"250","minWidth":"250","popupItems":[],"prefx":0,"renderWidth":6,"row":"1","suffx":0,"width":"6","width_perc":""}},"name":"left_side_area","open":true,"popupItems":[],"row":1,"strechStructure":"{\"table\":\"_area_3\", \"row\": \"_area_5\", \"cell\": \"_area_4\"}","stretch":true,"type":"area","width":6});
	this.calendar= new ZtVWeb.StaticCtrl(this, {"behavior":"show","id":"item_static_17","layout_steps_values":{"0":{"behavior":"show","col":"0","height":"1","popupItems":[],"prefx":0,"renderWidth":20,"row":"1","suffx":0,"width":"6"},"1024":{"behavior":"show","col":"0","height":"1","popupItems":[],"prefx":0,"renderWidth":20,"row":"1","suffx":0,"width":"6"}},"name":"calendar","open":true,"popupItems":[],"row":1,"type":"static","width":6});
<%if(sx_group_box!=null){%>
	this.sx= new ZtVWeb.GroupCtrl(this, {"behavior":"show","id":"item_group_13","layout_steps_values":{"0":{"behavior":"show","col":"0","height":"1","popupItems":[],"prefx":0,"renderWidth":20,"row":"2","suffx":0,"width":"6"},"1024":{"behavior":"show","col":"0","height":"1","popupItems":[],"prefx":0,"renderWidth":20,"row":"2","suffx":0,"width":"6"}},"name":"sx","open":true,"popupItems":[],"row":2,"type":"group","width":6});
<%}%>
	this.main_area= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":6,"cssClass":"main-area","height":2,"id":"item_area_5","layout_item_style":"row wrap","layout_steps_values":{"0":{"behavior":"show","col":"6","height":"2","maxWidth":"","minWidth":"","popupItems":[],"prefx":0,"renderWidth":14,"row":"1","suffx":0,"width":"14","width_perc":""},"1024":{"behavior":"show","col":"6","height":"2","maxWidth":"","minWidth":"","popupItems":[],"prefx":0,"renderWidth":14,"row":"1","suffx":0,"width":"14","width_perc":""}},"name":"main_area","open":true,"popupItems":[],"row":1,"strechStructure":"{\"table\":\"_area_3\", \"row\": \"_area_5\", \"cell\": \"_area_4\"}","stretch":true,"stretchBehavior":"stretch_container","type":"area","width":14});
	this._area_0= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":6,"height":2,"id":"_area_0","name":"_area_0","renderWidth":20,"row":1,"stretchBehavior":"stretch_container","type":"area","width":14});
	this._area_2= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":6,"height":2,"id":"_area_2","name":"_area_2","renderWidth":20,"row":1,"stretchBehavior":"stretch_row","type":"area","width":14});
	this._area_1= new ZtVWeb.AreaCtrl( this,{"behavior":"show","col":6,"height":2,"id":"_area_1","name":"_area_1","renderWidth":20,"row":1,"stretchBehavior":"stretch_cell","type":"area","width":14});
<%if(central_group_box!=null){%>
	this.central= new ZtVWeb.GroupCtrl(this, {"behavior":"show","col":6,"height":2,"id":"item_group_18","layout":"multiple","layout_steps_values":{"1024":{"behavior":"show","col":"6","height":"2","popupItems":[],"prefx":0,"renderWidth":20,"row":"1","suffx":0,"width":"14"}},"name":"central","open":true,"popupItems":[],"renderWidth":20,"row":1,"strechStructure":"{\"table\":\"_area_0\", \"row\": \"_area_2\", \"cell\": \"_area_1\"}","stretch":true,"tabs_target":"tab","type":"group","width":14});
<%}%>
	this._area_12= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_12","name":"_area_12","renderWidth":20,"row":3,"stretchBehavior":"after_stretch_row","type":"area","width":20});
	this._area_11= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_11","name":"_area_11","renderWidth":20,"row":3,"stretchBehavior":"after_stretch_cell","type":"area","width":20});
	this.speech_grammar_portletContainer= new ZtVWeb.StaticCtrl(this, {"behavior":"show","id":"item_static_19","layout_steps_values":{"1024":{"behavior":"show","col":"0","height":"1","popupItems":[],"prefx":0,"renderWidth":20,"row":"3","suffx":0,"width":"20"}},"name":"speech_grammar_portletContainer","open":true,"popupItems":[],"renderWidth":20,"row":3,"type":"static","width":20});
  this.planName='<%=(planName!=null?planName:"")%>';
  this.Calc= function(){
    if(!Empty(this.planName) && window[this.planName] )
      window[this.planName].Calc(this);
  }
  /*ActionCode*/
  if(typeof ToggleLeftSide !='undefined')this.ToggleLeftSide=ToggleLeftSide;

  function ToggleLeftSide(){
	if(this.left_side_area.isHidden()){
    this.left_side_area.showItem();
    this.main_area.renderWidth = 16;
	} else {
		this.left_side_area.hideItem();
    this.main_area.renderWidth = 20;
  }
  this.main_area.setDimension();
}

  /*End ActionCode*/
};
<%if(!pagelet_yet_included && !client_side_included){%>
function getPagelet(){return window.<%=PageletId%>;}
<%}%>
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'default_tpl','<%=JSPLib.ToJSValue(includerPageletId,false,true)%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html>
<%}%>
