<%/*Type:Page*/%>
<%//Def:{"body_attributes":"","cache_time":"","codeStatus":"","codeevents":"","conditions":"","contents":"main","contents_type":"","css":"","custom_url_failure":"","description":"generic mobile app default","father":"","groups":"group_main","importance":"","library":"","links":"","menu_label_father":"","menu_label_links":"","menu_urls_links":"","meta":"","meta_description":"","model":"","modelselected":"","name":"spma_default","offline":"false","on_security_failure":"empty","page_image":"","page_parameters":"","parameters":"","query":"","query_params":"","redirect":",,","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","template":"tablet_tpl,smartphone_tpl,tablet_tpl","theme":",,","title":"","titles":"","type":"Page","type_category":"","ua_priority":"false","urls":"attribute:m_cLandingPage:start_page_logo_portlet.jsp","user_agent":"DEFAULT,SMARTPHONE,TABLET","x":"375","y":"283"}%>
<%/*Description:generic mobile app default*/%>
<%/*PlanName:spma_defaultsplan*/%>
<%@ page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.Library" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%
Sitepainter sp=Sitepainter.getSitepainter(request);
if (JSPLib.checkApplication(request, response, out, sp, 37,"spma_defaultsplan","UTF-8")) {return; }
boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");%><%
String DeviceToGo=(sp.getDeviceSelected()==null?JSPLib.GetUserAgent(request):sp.getDeviceSelected());
if(DeviceToGo.equals("SMARTPHONE")){
  if (server_side_included) pageContext.include("spma_default_DEVICE_SMARTPHONE.jsp");
  else pageContext.forward("spma_default_DEVICE_SMARTPHONE.jsp");
  return;
};
if(DeviceToGo.equals("TABLET")){
  if (server_side_included) pageContext.include("spma_default_DEVICE_TABLET.jsp");
  else pageContext.forward("spma_default_DEVICE_TABLET.jsp");
  return;
};
  sp.setDeviceSelected("DEFAULT");
sp.setContentType(response);%>
<%boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean template_yet_called = null!=request.getAttribute("com.zucchetti.pagelet.main_template");
boolean plan_page_yet_called = null!=request.getAttribute("content_boxes");
String queryStringInclude=(String)request.getAttribute("javax.servlet.include.query_string");
if(plan_page_yet_called && !template_yet_called){//merging
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map group_main_group;//gruppo
if(ht.containsKey("group_main_group")){
group_main_group=(Map)ht.get("group_main_group");
}else{
group_main_group=new LinkedHashMap();
ht.put("group_main_group",group_main_group);
}
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url",(request.getAttribute("m_cLandingPage")!=null?request.getAttribute("m_cLandingPage"):"start_page_logo_portlet.jsp"));
main.put("title","main");
main.put("opened","");
ht.put("main",main);
group_main_group.put("main",main);
}else{
if(!server_side_included && !client_side_included){
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spma_default.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<style type="text/css">
  body {margin:0px}
</style>
<link rel='shortcut icon' href='../favicon.ico' />
<%}%>
<!--Plan Editor spma_defaultsplan -->
<%
Hashtable ht=new Hashtable();
request.setAttribute("content_boxes",ht);
Map group_main_group;//gruppo
if(ht.containsKey("group_main_group")){
group_main_group=(Map)ht.get("group_main_group");
}else{
group_main_group=new LinkedHashMap();
ht.put("group_main_group",group_main_group);
}
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url",(request.getAttribute("m_cLandingPage")!=null?request.getAttribute("m_cLandingPage"):"start_page_logo_portlet.jsp"));
main.put("title","main");
main.put("opened","");
ht.put("main",main);
group_main_group.put("main",main);
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
  ZtVWeb.POM.addObj('<%=PageId%>','spma_default','planObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<%
request.setAttribute("planName",PageId);
request.setAttribute("SPParentObjId",PageId);
String forcePageletId = JSPLib.NewCPCCCHK();
request.setAttribute("forcePageletId",forcePageletId);
String t=request.getParameter("tpl");
if (t==null) t="tablet_tpl";
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
ZtVWeb.PageCtrl(this,'<%=PageId%>', '<%=forcePageletId%>', 'spma_default');
this.Calc=function(pagelet){
  this.pagelet.EnablePageCall('group_main');
 }
this.main=this.pagelet.main;
this.group_main=this.pagelet.group_main;

}
window['<%=forcePageletId%>'].EnablePageCall('group_main');
ZtVWeb.addPage('<%=PageId%>', <%=PageId%>, 'spma_default','<%=includerPageletId%>' );
<%if(!server_side_included){%>
window.<%=PageId%>.Loaded();
<%}%>
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){
%></BODY>
</HTML><%}
}%>
