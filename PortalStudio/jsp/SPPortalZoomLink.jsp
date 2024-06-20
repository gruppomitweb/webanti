<%/*Type:Page*/%>
<%//Def:{"body_attributes":"","cache_time":"","codeStatus":"{\"folded\":{},\"breakpoints\":{}}","codeevents":"\u003c%!\n  void setCryptParams(HttpServletRequest request) {\n  \u002f\u002f definisco come parametri potenziali da decrittare tutti quelli reinviati dal form di SPVisualZoom\n  String[] decryptParams = {\"Table\", \"Linkzoomprg\", \"PKFields\", \"m_cDecoration\", \"FillEmptyKey\", \"LinkedField\", \"FieldFilter\", \"SPZTL\", \"HistoryFilterDate\", \"FixedFilter\", \"ConfigGridElements\", \"Popup\", \"FixedFilterURL\", \"DefaultsRoutine\", \"UID\", \"Caption\", \"ConfigName\", \"SelectField\", \"InitEntityFields\", \"Linkzoom\" };\n  for (String pName : decryptParams) {\n    request.setAttribute(\"com.zucchetti.sitepainter.parameters.\"+pName, pName);\n  }\n}\n%\u003e\nfunction this_Loaded() {\n  doLinkZoom.call(this);\n}","conditions":"if (! sp.isOfflineInstallation(request) ) ;if ( sp.isOfflineInstallation(request) )","contents":"ZoomGrid,ZoomGrid","contents_type":",","css":"","custom_url_failure":"","description":"SPPortalZoomLink","father":"","groups":",","importance":"","library":"SPPortalZoomLink.js","links":"","menu_label_father":"","menu_label_links":"","menu_urls_links":"","meta":"","meta_description":"\u003c%setCryptParams(request);%\u003e","model":"","modelselected":"","name":"SPPortalZoomLink","offline":"false","on_security_failure":"login","page_image":"","page_parameters":"","parameters":",","query":"","query_params":"","redirect":"","roles":"","security":"none","server_cache_time":"","shared_manifest":"false","sp_theme":"false","template":"SPPortalZoomLink_tpl","theme":"","title":"Link zoom","titles":"Zoom online,Zoom offline","type":"Page","type_category":"","ua_priority":"false","urls":"SPPortalZoomBase_portlet.jsp,SPPortalZoomBaseOL_portlet.jsp","user_agent":"DEFAULT","x":"126","y":"119"}%>
<%/*Description:SPPortalZoomLink*/%>
<%/*PlanName:zooms*/%>
<%@ page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.Library" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%
Sitepainter sp=Sitepainter.getSitepainter(request);
boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");%><%boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean template_yet_called = null!=request.getAttribute("com.zucchetti.pagelet.main_template");
boolean plan_page_yet_called = null!=request.getAttribute("content_boxes");
String queryStringInclude=(String)request.getAttribute("javax.servlet.include.query_string");
if(plan_page_yet_called && !template_yet_called){//merging
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map empty_group;//gruppo
if(ht.containsKey("empty_group")){
empty_group=(Map)ht.get("empty_group");
}else{
empty_group=new LinkedHashMap();
ht.put("empty_group",empty_group);
}
if (! sp.isOfflineInstallation(request) ) {
//Inserimento della Risorsa e le sue props
Map ZoomGrid=new HashMap();
ZoomGrid.put("name","ZoomGrid");
ZoomGrid.put("url","SPPortalZoomBase_portlet.jsp");
ZoomGrid.put("title","Zoom online");
ZoomGrid.put("opened","");
ht.put("ZoomGrid",ZoomGrid);
empty_group.put("ZoomGrid",ZoomGrid);
}
if ( sp.isOfflineInstallation(request) ){
//Inserimento della Risorsa e le sue props
Map ZoomGrid=new HashMap();
ZoomGrid.put("name","ZoomGrid");
ZoomGrid.put("url","SPPortalZoomBaseOL_portlet.jsp");
ZoomGrid.put("title","Zoom offline");
ZoomGrid.put("opened","");
ht.put("ZoomGrid",ZoomGrid);
empty_group.put("ZoomGrid",ZoomGrid);
}
}else{
if(!server_side_included && !client_side_included){
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/SPPortalZoomLink.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<style type="text/css">
  body {margin:0px}
</style>
<link rel='shortcut icon' href='../favicon.ico' />
<TITLE><%=sp.translate("Link zoom")%></TITLE>
<META name="description" content="<%setCryptParams(request);%>" />
<%}%>
<script src="../<%=SPPrxycizer.proxycizedPath("SPPortalZoomLink.js")%>"></script>
<!--Plan Editor zooms -->
<%
Hashtable ht=new Hashtable();
request.setAttribute("content_boxes",ht);
Map empty_group;//gruppo
if(ht.containsKey("empty_group")){
empty_group=(Map)ht.get("empty_group");
}else{
empty_group=new LinkedHashMap();
ht.put("empty_group",empty_group);
}
if (! sp.isOfflineInstallation(request) ) {
//Inserimento della Risorsa e le sue props
Map ZoomGrid=new HashMap();
ZoomGrid.put("name","ZoomGrid");
ZoomGrid.put("url","SPPortalZoomBase_portlet.jsp");
ZoomGrid.put("title","Zoom online");
ZoomGrid.put("opened","");
ht.put("ZoomGrid",ZoomGrid);
empty_group.put("ZoomGrid",ZoomGrid);
}
if ( sp.isOfflineInstallation(request) ){
//Inserimento della Risorsa e le sue props
Map ZoomGrid=new HashMap();
ZoomGrid.put("name","ZoomGrid");
ZoomGrid.put("url","SPPortalZoomBaseOL_portlet.jsp");
ZoomGrid.put("title","Zoom offline");
ZoomGrid.put("opened","");
ht.put("ZoomGrid",ZoomGrid);
empty_group.put("ZoomGrid",ZoomGrid);
}
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
  ZtVWeb.POM.addObj('<%=PageId%>','SPPortalZoomLink','planObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<%
request.setAttribute("planName",PageId);
request.setAttribute("SPParentObjId",PageId);
String forcePageletId = JSPLib.NewCPCCCHK();
request.setAttribute("forcePageletId",forcePageletId);
String t=request.getParameter("tpl");
if (t==null) t="SPPortalZoomLink_tpl";
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
ZtVWeb.PageCtrl(this,'<%=PageId%>', '<%=forcePageletId%>', 'SPPortalZoomLink');
this.Calc=function(pagelet){
  this.pagelet.EnablePageCall('empty');
 }
this.ZoomGrid=this.pagelet.ZoomGrid;
this.ZoomGrid=this.pagelet.ZoomGrid;
this.empty=this.pagelet.empty;
if(typeof this_Loaded !='undefined')this.this_Loaded=this_Loaded;

<%!
  void setCryptParams(HttpServletRequest request) {
  // definisco come parametri potenziali da decrittare tutti quelli reinviati dal form di SPVisualZoom
  String[] decryptParams = {"Table", "Linkzoomprg", "PKFields", "m_cDecoration", "FillEmptyKey", "LinkedField", "FieldFilter", "SPZTL", "HistoryFilterDate", "FixedFilter", "ConfigGridElements", "Popup", "FixedFilterURL", "DefaultsRoutine", "UID", "Caption", "ConfigName", "SelectField", "InitEntityFields", "Linkzoom" };
  for (String pName : decryptParams) {
    request.setAttribute("com.zucchetti.sitepainter.parameters."+pName, pName);
  }
}
%>
function this_Loaded() {
  doLinkZoom.call(this);
}

}
window['<%=forcePageletId%>'].EnablePageCall('empty');
ZtVWeb.addPage('<%=PageId%>', <%=PageId%>, 'SPPortalZoomLink','<%=includerPageletId%>' );
<%if(!server_side_included){%>
window.<%=PageId%>.Loaded();
<%}%>
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){
%></BODY>
</HTML><%}
}%>
