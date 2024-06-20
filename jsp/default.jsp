<%/*Type:Page*/%>
<%//Def:{"body_attributes":"","cache_time":"","codeStatus":"","codeevents":"","conditions":"if(!sp.isInGroup(6) && sp.getGlobal(\"gAggTabs\",\"N\")==\"N\");if(sp.isInGroup(6) ## sp.isInGroup(12));if(!sp.isInGroup(6) && sp.getGlobal(\"gAggTabs\",\"N\")==\"S\");;if(!sp.isInGroup(6));if(sp.isInGroup(6))","contents":"main,main,main,dati,ADE,operazioni","contents_type":",,,,,","css":"","custom_url_failure":"","description":"","father":"index","groups":"central,central,central,sx,sx,sx","importance":"","library":"","links":"","menu_label_father":"","menu_label_links":"","menu_urls_links":"","meta":"","meta_description":"","model":"","modelselected":"","name":"default","offline":"false","on_security_failure":"login","page_image":"","page_parameters":"","parameters":",,,,,","query":"","query_params":"","redirect":"","roles":"","security":"logged","server_cache_time":"","shared_manifest":"false","sp_theme":"false","template":"default_tpl","theme":"","title":"..:: WEBANTI :: Gestione Antiriciclaggio per Intermediari Finanziari ::..","titles":",,,Dati Applicativi,,","type":"Page","type_category":"","ua_priority":"true","urls":"!start_page_logo_portlet.jsp,!start_page_logo_agenzie_portlet.jsp,!pg_imp_newtabs_portlet.jsp,start_page_data_portlet.jsp,pg_test_opextrbo_portlet.jsp,pg_operaz_msg_side_portlet.jsp","user_agent":"DEFAULT","x":"317","y":"188"}%>
<%/*Description:*/%>
<%/*PlanName:main*/%>
<%@ page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.Library" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %><%
Sitepainter sp=Sitepainter.getSitepainter(request);
if (JSPLib.checkApplication(request, response, out, sp, 37,"main","UTF-8")) {return; }
boolean server_side_included = null!=request.getAttribute("javax.servlet.include.request_uri");%><%if(!sp.isLogged()){%>
<script>
window.location=<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/servlet/cp_login?m_cURL='+<%=JSPLib.ToJSValue(JSPLib.SPWebRootURL(request),true)%>+'/'+<%=JSPLib.ToJSValue(request.getRequestURI().substring(JSPLib.RAt("/",request.getRequestURI(),2)),true)%>+'&'+<%=JSPLib.ToJSValue(request.getQueryString(),true)%>
</script>
<%if(true) return;%>
<%}%>
<%boolean client_side_included = "true".equals(request.getParameter("clientsideinclusion"));
boolean template_yet_called = null!=request.getAttribute("com.zucchetti.pagelet.main_template");
boolean plan_page_yet_called = null!=request.getAttribute("content_boxes");
String queryStringInclude=(String)request.getAttribute("javax.servlet.include.query_string");
if(plan_page_yet_called && !template_yet_called){//merging
Hashtable ht=(Hashtable)request.getAttribute("content_boxes");
Map central_group;//gruppo
if(ht.containsKey("central_group")){
central_group=(Map)ht.get("central_group");
}else{
central_group=new LinkedHashMap();
ht.put("central_group",central_group);
}
if(!sp.isInGroup(6) && sp.getGlobal("gAggTabs","N")=="N"){
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url","!start_page_logo_portlet.jsp");
main.put("title","main");
main.put("opened","");
ht.put("main",main);
central_group.put("main",main);
}
if(sp.isInGroup(6) || sp.isInGroup(12)){
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url","!start_page_logo_agenzie_portlet.jsp");
main.put("title","main");
main.put("opened","");
ht.put("main",main);
central_group.put("main",main);
}
if(!sp.isInGroup(6) && sp.getGlobal("gAggTabs","N")=="S"){
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url","!pg_imp_newtabs_portlet.jsp");
main.put("title","main");
main.put("opened","");
ht.put("main",main);
central_group.put("main",main);
}
Map sx_group;//gruppo
if(ht.containsKey("sx_group")){
sx_group=(Map)ht.get("sx_group");
}else{
sx_group=new LinkedHashMap();
ht.put("sx_group",sx_group);
}
//Inserimento della Risorsa e le sue props
Map dati=new HashMap();
dati.put("name","dati");
dati.put("url","start_page_data_portlet.jsp");
dati.put("title","Dati Applicativi");
dati.put("opened","");
ht.put("dati",dati);
sx_group.put("dati",dati);
if(!sp.isInGroup(6)){
//Inserimento della Risorsa e le sue props
Map ADE=new HashMap();
ADE.put("name","ADE");
ADE.put("url","pg_test_opextrbo_portlet.jsp");
ADE.put("title","ADE");
ADE.put("opened","");
ht.put("ADE",ADE);
sx_group.put("ADE",ADE);
}
if(sp.isInGroup(6)){
//Inserimento della Risorsa e le sue props
Map operazioni=new HashMap();
operazioni.put("name","operazioni");
operazioni.put("url","pg_operaz_msg_side_portlet.jsp");
operazioni.put("title","operazioni");
operazioni.put("opened","");
ht.put("operazioni",operazioni);
sx_group.put("operazioni",operazioni);
}
}else{
if(!server_side_included && !client_side_included){
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href=<%=JSPLib.ToHTMLValue( JSPLib.SPWebRootURL(request)+"/jsp/default.jsp"+(!Library.Empty(request.getQueryString())?"?"+request.getQueryString():"") )%>/>
<%Library.WriteMetaTags(request,response,out);%>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<style type="text/css">
  body {margin:0px}
</style>
<link rel='shortcut icon' href='../favicon.ico' />
<TITLE><%=sp.translate("..:: WEBANTI :: Gestione Antiriciclaggio per Intermediari Finanziari ::..")%></TITLE>
<%}%>
<!--Plan Editor main -->
<%
Hashtable ht=new Hashtable();
request.setAttribute("content_boxes",ht);
Map central_group;//gruppo
if(ht.containsKey("central_group")){
central_group=(Map)ht.get("central_group");
}else{
central_group=new LinkedHashMap();
ht.put("central_group",central_group);
}
if(!sp.isInGroup(6) && sp.getGlobal("gAggTabs","N")=="N"){
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url","!start_page_logo_portlet.jsp");
main.put("title","main");
main.put("opened","");
ht.put("main",main);
central_group.put("main",main);
}
if(sp.isInGroup(6) || sp.isInGroup(12)){
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url","!start_page_logo_agenzie_portlet.jsp");
main.put("title","main");
main.put("opened","");
ht.put("main",main);
central_group.put("main",main);
}
if(!sp.isInGroup(6) && sp.getGlobal("gAggTabs","N")=="S"){
//Inserimento della Risorsa e le sue props
Map main=new HashMap();
main.put("name","main");
main.put("url","!pg_imp_newtabs_portlet.jsp");
main.put("title","main");
main.put("opened","");
ht.put("main",main);
central_group.put("main",main);
}
Map sx_group;//gruppo
if(ht.containsKey("sx_group")){
sx_group=(Map)ht.get("sx_group");
}else{
sx_group=new LinkedHashMap();
ht.put("sx_group",sx_group);
}
//Inserimento della Risorsa e le sue props
Map dati=new HashMap();
dati.put("name","dati");
dati.put("url","start_page_data_portlet.jsp");
dati.put("title","Dati Applicativi");
dati.put("opened","");
ht.put("dati",dati);
sx_group.put("dati",dati);
if(!sp.isInGroup(6)){
//Inserimento della Risorsa e le sue props
Map ADE=new HashMap();
ADE.put("name","ADE");
ADE.put("url","pg_test_opextrbo_portlet.jsp");
ADE.put("title","ADE");
ADE.put("opened","");
ht.put("ADE",ADE);
sx_group.put("ADE",ADE);
}
if(sp.isInGroup(6)){
//Inserimento della Risorsa e le sue props
Map operazioni=new HashMap();
operazioni.put("name","operazioni");
operazioni.put("url","pg_operaz_msg_side_portlet.jsp");
operazioni.put("title","operazioni");
operazioni.put("opened","");
ht.put("operazioni",operazioni);
sx_group.put("operazioni",operazioni);
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
  ZtVWeb.POM.addObj('<%=PageId%>','default','planObj','<%=SPParentObjId%>');
/*JS_MARKER_END*/
</script>
<%
request.setAttribute("planName",PageId);
request.setAttribute("SPParentObjId",PageId);
String forcePageletId = JSPLib.NewCPCCCHK();
request.setAttribute("forcePageletId",forcePageletId);
String t=request.getParameter("tpl");
if (t==null) t="default_tpl";
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
ZtVWeb.PageCtrl(this,'<%=PageId%>', '<%=forcePageletId%>', 'default');
this.Calc=function(pagelet){
  this.pagelet.EnablePageCall('central');
  this.pagelet.EnablePageCall('sx');
 }
this.main=this.pagelet.main;
this.main=this.pagelet.main;
this.main=this.pagelet.main;
this.dati=this.pagelet.dati;
this.ADE=this.pagelet.ADE;
this.operazioni=this.pagelet.operazioni;
this.central=this.pagelet.central;
this.sx=this.pagelet.sx;

}
window['<%=forcePageletId%>'].EnablePageCall('central');
window['<%=forcePageletId%>'].EnablePageCall('sx');
ZtVWeb.addPage('<%=PageId%>', <%=PageId%>, 'default','<%=includerPageletId%>' );
<%if(!server_side_included){%>
window.<%=PageId%>.Loaded();
<%}%>
/*JS_MARKER_END*/
</script>
<%if(!server_side_included && !client_side_included){
%></BODY>
</HTML><%}
}%>
