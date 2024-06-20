<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.Sitepainter" %><%@ page import="com.zucchetti.PortalStudio.JSPLib" %><%@ page import="com.zucchetti.spofflineapp.Library" %><%@ page import="com.zucchetti.spofflineapp.SPManifestEntry" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer"%><%
Sitepainter sp=Sitepainter.getSitepainter(request);
Library.CSSManager cssManager= new Library.CSSManager();
String getType=sp.getParameter("getType","");
String m_cEntryPoint=sp.getParameter("m_cSPOfflineApp",(sp.getGlobal("i_lOfflineApplicationMode" , false ) ?  sp.getGlobal("i_cEntryPoint","") : "spofflineapp" ));
String m_cJSPUID = "3878143797";
String VERSION = "3878143797";
String PageletId=sp.getParameter("PageletId","");
if(getType.equals("version")){
  out.print(VERSION);
  return;
}
if(Library.Empty(getType)){
response.setHeader("content-type","text/cache-manifest");
if ( !Library.FillBodyResponse( request, m_cEntryPoint, VERSION ) ) {
  response.setStatus(javax.servlet.http.HttpServletResponse.SC_NOT_MODIFIED);
  return;
}
response.setHeader("ETag","\""+VERSION+"\"");
%>CACHE MANIFEST
# version <%=VERSION%>
<%}%>
<%if(Library.Empty(getType)){%>
NETWORK:
<%}%>
<%if(getType.equals("network") || Library.Empty(getType)){%>
# SPSelectVersion_portlet NETWORK
<%}%>
<%if(Library.Empty(getType)){%>
CACHE:
<%}%>
<%if(getType.equals("cache") || Library.Empty(getType)){%>
# SPSelectVersion_portlet CACHE
#IMAGES 
<%=cssManager.GetCSSResources("../../"+sp.getTheme()+"/portalstudio.css","combobox")%>
<%=cssManager.GetCSSVariantResources(sp,out,"combobox")%>
<%=cssManager.GetCSSResources("../../"+sp.getTheme()+"/portalstudio.css","label")%>
<%=cssManager.GetCSSVariantResources(sp,out,"label")%>
<%=cssManager.GetCSSResources("../../"+sp.getTheme()+"/portalstudio.css","textbox")%>
<%=cssManager.GetCSSVariantResources(sp,out,"textbox")%>
../../favicon.ico
#STYLESHEET 
<%=sp.GetSkinVariantFileForManifest()%>
#JAVASCRIPT 
../../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>
../../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>
../../controls.js
../../<%=SPPrxycizer.proxycizedPath("suggesterlib.js")%>
../../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>
#OTHER 
<%=JSPLib.SPWebRootURL(request)%>/jsp-system/SPSelectVersion_portlet.jsp?m_cSPOfflineApp=<%=sp.getParameter("m_cSPOfflineApp",(sp.getGlobal("i_lOfflineApplicationMode" , false ) ?  sp.getGlobal("i_cEntryPoint","") : "spofflineapp" ))%><%=(!Library.Empty(request.getQueryString())?"&"+request.getQueryString():"")%>
<%=sp.GetPortletJSLibrariesManifest()%>
../../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/portalstudio.css", SPPrxycizer.Mode.QUERYSTRING)%>
../../jsp-system/SPSelectVersion_portlet.jsp?SpCssCode=<%=m_cJSPUID%>
<%}%>
<%if(Library.Empty(getType)){%>
FALLBACK:
<%}%>
<%if(getType.equals("fallback") || Library.Empty(getType)){%>
<%}%>
