<%/*Type:PageletEditor*/%>
<%//Def:[{"id":"pagelet","name":"pagelet","type":"pagelet","template":"7","cols_n":"20","rows_n":"3","width":"960px","height":"100%","css":"","css_Class":"","color":"","security":"none","on_security_failure":"login","roles":"","cache_time":"0","sp_theme":"true","offline":"false","shared_manifest":"false","manifest":"Custom manifest","action_code":"","description":"","steps":"","layout_step":"","is960":"false","steppable_prop":[],"css_class":"","stretch":"false","codemanifest":"","css_code":"[]"},{"id":"item_static_0","type":"static","name":"zoom_title","src":"default_zoom_title_portlet.jsp","parameters":" ","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","condition":"","row":"0","col":"0","height":"1","width":"20","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"false","caption":"","draggable":"false","toremove":"","hidden":"false","curTab":"advanced","renderWidth":"20"},{"id":"item_resources_1","type":"resource","name":"ZoomGrid","titled":"false","title":"","open":"true","in_iframe":"false","iframe_height":"","container":"","row":"1","col":"0","height":"1","width":"20","prefx":"0","suffx":"0","inserted":"true","behavior":"show","layout_steps_values":{},"steppable_prop":["row","col","width","height","behavior","popupItems","prefx","suffx","renderWidth"],"popupItems":[],"stretch":"true","draggable":"false","hidden":"false","curTab":"generic","renderWidth":"20"}]%>
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
%><!-- PageletName=SPPortalZoom_tpl -->
<%
if (JSPLib.checkApplication(request, response, out, sp, 37,"SPPortalZoom_tpl","UTF-8")) {return; }
 %><%response.setHeader("Cache-Control","max-age = 0");
response.setDateHeader("Expires", 0);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+".SPPortalZoom_tpl","SPPortalZoom_tpl");
request.setAttribute("PageletId",PageletId);
String main_template = (String)request.getAttribute("com.zucchetti.pagelet.main_template");
String planName = (String)request.getAttribute("planName");
boolean pagelet_yet_included = null!=main_template;
if(!pagelet_yet_included){
request.setAttribute("com.zucchetti.pagelet.main_template","SPPortalZoom_tpl");
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
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPPortalZoom_tpl.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);
}%>
<link type='text/css' rel='stylesheet' href='../<%=SPPrxycizer.proxycizedPath("styles/pagelet.css", SPPrxycizer.Mode.QUERYSTRING)%>'>
<% sp.WritePortalStudioCSS(request, out);
if(!server_side_included && !client_side_included){%>
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
var m_cSPParentObjId =   ZtVWeb.POM.addObj('<%=PageletId%>','SPPortalZoom_tpl','pageletObj', '<%=JSPLib.ToJSValue(SPParentObjId,false,true)%>');
/*JS_MARKER_END*/
</script>
<%SPParentObjId=PageletId;

Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map<String,String> ZoomGrid_box=null;
if (ht!=null){
  ZoomGrid_box=(Map)ht.get("ZoomGrid");
}
%>
<div class="type_20 pagelet_container" id="<%=PageletId%>_container"><%
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
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_1" class="pagelet_item item_before_stretch_cell block_item"><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_1','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
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
  ZtVWeb.POM.addObj('<%=container_id%>','zoom_title','staticObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><div id=<%=JSPLib.ToHTMLValue(container_id)%> ps-resource-name=<%=JSPLib.ToHTMLValue("zoom_title")%> name="zoom_title" class='pagelet_item  block_item ' title_as_portlet='default_title_portlet_portlet.jsp'><%
request.setAttribute("PageletId",PageletId);
title_value=sp.translate("");
String content_name;
String res_url;
%><%
url="default_zoom_title_portlet.jsp";
content_name= uid + ID_SEP + "default_zoom_title";
parms_joiner = "?";
res_url="default_zoom_title_portlet.jsp"+parms_joiner+"SPParentObjId="+container_id+"&PageletId="+PageletId;
%><%res_url+="&"+queryString;%><div id=<%=JSPLib.ToHTMLValue(content_id)%> style='display:block;'><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': false, 'type': 'static', 'name': 'zoom_title','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'url': 'default_zoom_title_portlet.jsp', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': false};
/*JS_MARKER_END*/
</script><%
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/jsp-decorators/default_zoom_title_portlet.jsp",true))
  if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-decorators/default_zoom_title_portlet.jsp",true))
    if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/default_zoom_title_portlet.jsp",true))
      com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/default_zoom_title_portlet.jsp",false);
%></div><script>
/*JS_MARKER_START*/
window.portlet_list.push('default_zoom_title');
/*JS_MARKER_END*/
</script></div></div></div><%SPParentObjId=PageletId + ID_SEP + "_area_0";%><%
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
%><%if( ZoomGrid_box != null){%><div id=<%=JSPLib.ToHTMLValue(container_id)%> name="_area_3" class="pagelet_item item_stretch_cell block_item"><div id=<%=JSPLib.ToHTMLValue(content_id)%> class='noflex' style=''><script>
/*JS_MARKER_START*/
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': [], 'type':'area','name':'_area_3','containerId': '<%=JSPLib.ToJSValue(container_id)%>', 'contentId': '<%=JSPLib.ToJSValue(content_id)%>', 'tabs':[], 'resources': [], 'urls': [], 'Ids': [], 'containerIds' : [], 'contentIds': [], 'inIframe': [], 'title_portlet_ids': [], 'titleIds': [],}
  ZtVWeb.POM.addObj('<%=uid%>','_area_3','areaObj','<%=JSPLib.ToJSValue(SPParentObjId)%>');
/*JS_MARKER_END*/
</script><%SPParentObjId=PageletId + ID_SEP + "_area_3";%><%
ID_SEP="_";
CONTAINER_SUFFIX="container";
CONTENT_SUFFIX="content";
uid= PageletId + ID_SEP +"item_resources_1";
container_id= uid + ID_SEP + CONTAINER_SUFFIX;
content_id= uid + ID_SEP + CONTENT_SUFFIX;
title_value= "";
url= "";
%><script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=container_id%>','ZoomGrid','resourceObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script><%
if(ZoomGrid_box!=null){request.setAttribute("PageletId",PageletId);
request.setAttribute("SPParentObjId",container_id);
%><div id=<%=JSPLib.ToHTMLValue(container_id)%> class='pagelet_item item_stretch block_item ' ps-stretch-height ps-resource-name=<%=JSPLib.ToHTMLValue("ZoomGrid")%> ><%
title_value=sp.translate((String)ZoomGrid_box.get("title"));
url=(String)ZoomGrid_box.get("url");
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
<%=PageletId%>_pagelet_structure['<%=uid%>']={'loaded': 'false', 'type':'url','name':'ZoomGrid','url':'<%=JSPLib.ToJSValue(url)%>','containerId':'<%=JSPLib.ToJSValue(container_id)%>', 'Id': '', 'contentId':'<%=JSPLib.ToJSValue(content_id)%>', 'inIframe': <%=RES_in_iframe%>}
/*JS_MARKER_END*/
</script><%if(RES_in_iframe){
RES_iframe_id=RES_content_name;
RES_res_url=url +(url.indexOf("?")>-1? "&" : "?" )+"&PageletId="+PageletId+"&"+queryString;
RES_iframe_src=RES_res_url;
RES_onload="resizeIframe(this);";
%><%out.print("<iframe id="+JSPLib.ToHTMLValue(RES_iframe_id)+" name='ZoomGrid' data-sp-src="+JSPLib.ToHTMLValue(!com.zucchetti.sitepainter.Library.Empty(RES_iframe_src)?JSPLib.SPWebRootURL(request)+"/jsp/"+RES_iframe_src:"")+" onload="+JSPLib.ToHTMLValue(RES_onload)+" ps-stretch-height marginwidth='0' marginheight='0' style='width:100%;height:0px;' allowtransparency='true' frameborder='0' spparentobjid="+JSPLib.ToHTMLValue(container_id)+"></iframe>");
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
</script></div><%}%><!--chiude if risorsa ZoomGrid--></div></div><%}%></div></div></div><script>
/*JS_MARKER_START*/
window.<%=PageletId%>=new function(){
  this.id='<%=PageletId%>'
  ZtVWeb.PageletCtrl(this, {id:'<%=PageletId%>', steps:"", stretch:"true", dragAndDroppable: false});
	this._area_0= new ZtVWeb.AreaCtrl( this,{"behavior":"show","height":2,"id":"_area_0","name":"_area_0","renderWidth":20,"stretchBehavior":"stretch_container","type":"area","width":20});
	this._area_2= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_2","name":"_area_2","renderWidth":20,"stretchBehavior":"before_stretch_row","type":"area","width":20});
	this._area_1= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_1","name":"_area_1","renderWidth":20,"stretchBehavior":"before_stretch_cell","type":"area","width":20});
	this.zoom_title= new ZtVWeb.StaticCtrl(this, {"behavior":"show","id":"item_static_0","layout_steps_values":{},"name":"zoom_title","open":true,"popupItems":[],"renderWidth":20,"type":"static","width":20});
	this._area_4= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_4","name":"_area_4","renderWidth":20,"row":1,"stretchBehavior":"stretch_row","type":"area","width":20});
	this._area_3= new ZtVWeb.AreaCtrl( this,{"behavior":"show","id":"_area_3","name":"_area_3","renderWidth":20,"row":1,"stretchBehavior":"stretch_cell","type":"area","width":20});
<% if(ZoomGrid_box!=null){%>
	this.ZoomGrid= new ZtVWeb.ResourceCtrl(this,{"behavior":"show","id":"item_resources_1","layout_steps_values":{},"name":"ZoomGrid","open":true,"popupItems":[],"renderWidth":20,"row":1,"strechStructure":"{\"table\":\"_area_0\", \"row\": \"_area_4\", \"cell\": \"_area_3\"}","stretch":true,"type":"resource","width":20});
<%}%>
  this.planName='<%=(planName!=null?planName:"")%>';
  this.Calc= function(){
    if(!Empty(this.planName) && window[this.planName] )
      window[this.planName].Calc(this);
  }
  /*ActionCode*/
  
  
  /*End ActionCode*/
};
<% if(ZoomGrid_box!=null){%>
window.<%=PageletId%>.ZoomGrid.setSrc();
<%}
if(!pagelet_yet_included && !client_side_included){%>
function getPagelet(){return window.<%=PageletId%>;}
<%}%>
ZtVWeb.addPagelet('<%=PageletId%>',<%=PageletId%>,'SPPortalZoom_tpl','<%=JSPLib.ToJSValue(includerPageletId,false,true)%>');
checkLoaded('<%=PageletId%>');
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){%>
</body>
</html>
<%}%>
