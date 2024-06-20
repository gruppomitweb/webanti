<%/*Type:Page*/%>
<%//Def:{"body_attributes":"","cache_time":"","codeStatus":"","codeevents":"","conditions":"","contents":"","contents_type":"","css":"","custom_url_failure":"","description":"generic mobile app index","father":"","groups":"","importance":"","library":"","links":"","menu_label_father":"","menu_label_links":"","menu_urls_links":"","meta":"","meta_description":"","model":"","modelselected":"","name":"spma_index","offline":"false","on_security_failure":"empty","page_image":"","page_parameters":"","parameters":"","query":"","query_params":"","redirect":",,","roles":"","security":"pagelet","server_cache_time":"","shared_manifest":"false","sp_theme":"false","template":"index_tpl,index_tpl,index_tpl","theme":",,","title":"attribute:m_cTitle","titles":"","type":"Page","type_category":"","ua_priority":"false","urls":"","user_agent":"DEFAULT,SMARTPHONE,TABLET","x":"135","y":"149"}%>
<%/*Description:generic mobile app index*/%>
<%/*PlanName:spma_defaultsplan*/%>
<%@ page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.Library" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%
Sitepainter sp=Sitepainter.getSitepainter(request);
if (JSPLib.checkApplication(request, response, out, sp, 37,"spma_defaultsplan","UTF-8")) {return; }
boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");%><%
String DeviceToGo=(sp.getDeviceSelected()==null?JSPLib.GetUserAgent(request):sp.getDeviceSelected());
if(DeviceToGo.equals("SMARTPHONE")){
  if (server_side_included) pageContext.include("spma_index_DEVICE_SMARTPHONE.jsp");
  else pageContext.forward("spma_index_DEVICE_SMARTPHONE.jsp");
  return;
};
if(DeviceToGo.equals("TABLET")){
  if (server_side_included) pageContext.include("spma_index_DEVICE_TABLET.jsp");
  else pageContext.forward("spma_index_DEVICE_TABLET.jsp");
  return;
};
  sp.setDeviceSelected("DEFAULT");
sp.setContentType(response);%>
<%if(request.getAttribute("javax.servlet.include.request_uri")==null && request.getParameter("clientsideinclusion")==null){%>
<%if (true) return;%>
<%}%>
<%boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean template_yet_called = null!=request.getAttribute("com.zucchetti.pagelet.main_template");
boolean plan_page_yet_called = null!=request.getAttribute("content_boxes");
String queryStringInclude=(String)request.getAttribute("javax.servlet.include.query_string");
if(plan_page_yet_called && !template_yet_called){//merging
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
}else{
if(!server_side_included && !client_side_included){
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/spma_index.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<style type="text/css">
  body {margin:0px}
</style>
<link rel='shortcut icon' href='../favicon.ico' />
<TITLE><%=sp.translate((String)(request.getAttribute("m_cTitle")!=null?request.getAttribute("m_cTitle"):""))%></TITLE>
<%}%>
<!--Plan Editor spma_defaultsplan -->
<%
Hashtable ht=new Hashtable();
request.setAttribute("content_boxes",ht);
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
  ZtVWeb.POM.addObj('<%=PageId%>','spma_index','planObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<%
request.setAttribute("planName",PageId);
request.setAttribute("SPParentObjId",PageId);
String forcePageletId = JSPLib.NewCPCCCHK();
request.setAttribute("forcePageletId",forcePageletId);
String t=request.getParameter("tpl");
if (t==null) t="index_tpl";
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
ZtVWeb.PageCtrl(this,'<%=PageId%>', '<%=forcePageletId%>', 'spma_index');
this.Calc=function(pagelet){
 }

}
ZtVWeb.addPage('<%=PageId%>', <%=PageId%>, 'spma_index','<%=includerPageletId%>' );
<%if(!server_side_included){%>
window.<%=PageId%>.Loaded();
<%}%>
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){
%></BODY>
</HTML><%}
}%>
