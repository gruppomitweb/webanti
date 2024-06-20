<%/*Type:Page*/%>
<%//Def:{"body_attributes":"","cache_time":"","codeStatus":"","codeevents":"","conditions":"if(\"yes\".equals(sp.getGlobal(\"IsSPOfflineSyncInstalled\",\"\")));;","contents":"apps_offline,apps_online,header_default","contents_type":",,","css":"","custom_url_failure":"","description":"Lists offline applications available","father":"","groups":"apps,apps,header","importance":"","library":"","links":"","menu_label_father":"","menu_label_links":"","menu_urls_links":"","meta":"","meta_description":"","model":"","modelselected":"","name":"spas_main","offline":"false","on_security_failure":"empty","page_image":"","page_parameters":"","parameters":"modstore=offline,modstore=online,","query":"","query_params":"","redirect":",,","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"true","template":"spas_papplist_tpl,spas_papplist_tpl,spas_papplist_tpl","theme":"iMobile,iMobile,iMobile","title":"Enterprise App Store","titles":",,","type":"Page","type_category":"","ua_priority":"true","urls":"spas_ptlapplist_portlet.jsp?modstore=offline,spas_ptlapplist_portlet.jsp?modstore=online,spas_pheaderstore_portlet.jsp","user_agent":"DEFAULT,SMARTPHONE,TABLET","x":"195","y":"78"}%>
<%/*Description:Lists offline applications available*/%>
<%/*PlanName:spas_main*/%>
<%@ page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.Library" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%
Sitepainter sp=Sitepainter.getSitepainter(request);
if (JSPLib.checkApplication(request, response, out, sp, 37,"spas_main","UTF-8")) {return; }
boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");%><%
String DeviceToGo;
if((request.getRequestURI()).indexOf(".jsp")>-1){
  DeviceToGo=JSPLib.GetUserAgent(request);
}else{
  DeviceToGo=(sp.getDeviceSelected()==null?JSPLib.GetUserAgent(request):sp.getDeviceSelected());
}
if(DeviceToGo.equals("SMARTPHONE")){
  if (server_side_included) pageContext.include("spas_main_DEVICE_SMARTPHONE.jsp");
  else pageContext.forward("spas_main_DEVICE_SMARTPHONE.jsp");
  return;
};
if(DeviceToGo.equals("TABLET")){
  if (server_side_included) pageContext.include("spas_main_DEVICE_TABLET.jsp");
  else pageContext.forward("spas_main_DEVICE_TABLET.jsp");
  return;
};
  sp.setDeviceSelected("DEFAULT");
sp.setContentType(response);%>
<%sp.setSkin("iMobile");%>
<%boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean template_yet_called = null!=request.getAttribute("com.zucchetti.pagelet.main_template");
boolean plan_page_yet_called = null!=request.getAttribute("content_boxes");
String queryStringInclude=(String)request.getAttribute("javax.servlet.include.query_string");
if(plan_page_yet_called && !template_yet_called){//merging
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map apps_group;//gruppo
if(ht.containsKey("apps_group")){
apps_group=(Map)ht.get("apps_group");
}else{
apps_group=new LinkedHashMap();
ht.put("apps_group",apps_group);
}
if("yes".equals(sp.getGlobal("IsSPOfflineSyncInstalled",""))){
//Inserimento della Risorsa e le sue props
Map apps_offline=new HashMap();
apps_offline.put("name","apps_offline");
apps_offline.put("url","spas_ptlapplist_portlet.jsp?modstore=offline");
apps_offline.put("title","apps_offline");
apps_offline.put("opened","");
ht.put("apps_offline",apps_offline);
apps_group.put("apps_offline",apps_offline);
}
//Inserimento della Risorsa e le sue props
Map apps_online=new HashMap();
apps_online.put("name","apps_online");
apps_online.put("url","spas_ptlapplist_portlet.jsp?modstore=online");
apps_online.put("title","apps_online");
apps_online.put("opened","");
ht.put("apps_online",apps_online);
apps_group.put("apps_online",apps_online);
Map header_group;//gruppo
if(ht.containsKey("header_group")){
header_group=(Map)ht.get("header_group");
}else{
header_group=new LinkedHashMap();
ht.put("header_group",header_group);
}
//Inserimento della Risorsa e le sue props
Map header_default=new HashMap();
header_default.put("name","header_default");
header_default.put("url","spas_pheaderstore_portlet.jsp");
header_default.put("title","header_default");
header_default.put("opened","");
ht.put("header_default",header_default);
header_group.put("header_default",header_default);
}else{
if(!server_side_included && !client_side_included){
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spas_main.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<style type="text/css">
  body {margin:0px}
</style>
<link rel='shortcut icon' href='../favicon.ico' />
<TITLE><%=sp.translate("Enterprise App Store")%></TITLE>
<%}%>
<% sp.WritePortalStudioCSS(request, out); %>
<!--Plan Editor spas_main -->
<%
Hashtable ht=new Hashtable();
request.setAttribute("content_boxes",ht);
Map apps_group;//gruppo
if(ht.containsKey("apps_group")){
apps_group=(Map)ht.get("apps_group");
}else{
apps_group=new LinkedHashMap();
ht.put("apps_group",apps_group);
}
if("yes".equals(sp.getGlobal("IsSPOfflineSyncInstalled",""))){
//Inserimento della Risorsa e le sue props
Map apps_offline=new HashMap();
apps_offline.put("name","apps_offline");
apps_offline.put("url","spas_ptlapplist_portlet.jsp?modstore=offline");
apps_offline.put("title","apps_offline");
apps_offline.put("opened","");
ht.put("apps_offline",apps_offline);
apps_group.put("apps_offline",apps_offline);
}
//Inserimento della Risorsa e le sue props
Map apps_online=new HashMap();
apps_online.put("name","apps_online");
apps_online.put("url","spas_ptlapplist_portlet.jsp?modstore=online");
apps_online.put("title","apps_online");
apps_online.put("opened","");
ht.put("apps_online",apps_online);
apps_group.put("apps_online",apps_online);
Map header_group;//gruppo
if(ht.containsKey("header_group")){
header_group=(Map)ht.get("header_group");
}else{
header_group=new LinkedHashMap();
ht.put("header_group",header_group);
}
//Inserimento della Risorsa e le sue props
Map header_default=new HashMap();
header_default.put("name","header_default");
header_default.put("url","spas_pheaderstore_portlet.jsp");
header_default.put("title","header_default");
header_default.put("opened","");
ht.put("header_default",header_default);
header_group.put("header_default",header_default);
if(!server_side_included && !client_side_included){
%></HEAD>
<BODY <%= sp.GetBodyClassAttribute("") %>>
<%= Sitepainter.GetBodyMobileScript(request) %><%}
String includerPageletId= (request.getAttribute("PageletId")!= null ? (String)request.getAttribute("PageletId"):sp.getParameter("PageletId",""));
String SPParentObjId=(request.getAttribute("SPParentObjId")!=null?(String)request.getAttribute("SPParentObjId"):sp.getParameter("SPParentObjId",""));
String PageId = JSPLib.NewCPCCCHK();
%>
<script>
/*JS_MARKER_START*/
  ZtVWeb.POM.addObj('<%=PageId%>','spas_main','planObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<%
request.setAttribute("planName",PageId);
request.setAttribute("SPParentObjId",PageId);
String forcePageletId = JSPLib.NewCPCCCHK();
request.setAttribute("forcePageletId",forcePageletId);
String t=request.getParameter("tpl");
if (t==null) t="spas_papplist_tpl";
if(Library.Empty(t) && !Library.Empty((String)ht.get("SpLayoutPage")))
  t=(String)ht.get("SpLayoutPage");
out.flush();
if(!com.zucchetti.sitepainter.Library.includeResource(request,response,"/"+sp.getSkin()+"/"+t+".jsp",true))
  com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp/"+t+".jsp"+(queryStringInclude!=null?"?"+queryStringInclude:""),false);
request.setAttribute("com.zucchetti.pagelet.template."+sp.getSkin()+"."+t,null);

%>
<script>
/*JS_MARKER_START*/
window.<%=PageId%>=new function(){
ZtVWeb.PageCtrl(this,'<%=PageId%>', '<%=forcePageletId%>', 'spas_main');
this.Calc=function(pagelet){
  this.pagelet.EnablePageCall('apps');
  this.pagelet.EnablePageCall('header');
 }
this.apps_offline=this.pagelet.apps_offline;
this.apps_online=this.pagelet.apps_online;
this.header_default=this.pagelet.header_default;
this.apps=this.pagelet.apps;
this.header=this.pagelet.header;

}
window['<%=forcePageletId%>'].EnablePageCall('apps');
window['<%=forcePageletId%>'].EnablePageCall('header');
ZtVWeb.addPage('<%=PageId%>', <%=PageId%>, 'spas_main','<%=includerPageletId%>' );
<%if(!server_side_included){%>
window.<%=PageId%>.Loaded();
<%}%>
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){
%></BODY>
</HTML><%}
}%>
