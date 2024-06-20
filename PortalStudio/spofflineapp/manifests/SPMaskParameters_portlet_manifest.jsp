<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.Sitepainter" %><%@ page import="com.zucchetti.PortalStudio.JSPLib" %><%@ page import="com.zucchetti.spofflineapp.Library" %><%@ page import="com.zucchetti.spofflineapp.SPManifestEntry" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer"%><%
Sitepainter sp=Sitepainter.getSitepainter(request);
Library.CSSManager cssManager= new Library.CSSManager();
String getType=sp.getParameter("getType","");
String m_cEntryPoint=sp.getParameter("m_cSPOfflineApp",(sp.getGlobal("i_lOfflineApplicationMode" , false ) ?  sp.getGlobal("i_cEntryPoint","") : "spofflineapp" ));
String m_cJSPUID = "2600266086";
String VERSION = "2600266086";
String PageletId=sp.getParameter("PageletId","");
if(getType.equals("version")){
  Library.SPHttpServletResponseWrapper w;
  w = new Library.SPHttpServletResponseWrapper(response);
  com.zucchetti.sitepainter.Library.includeResource(request,w, "/spofflineapp/manifests/SPSelectVersion_portlet_manifest.jsp?getType=version&m_cSPOfflineApp="+m_cEntryPoint+"&", true);
  try {
    VERSION += w.GetResponseText().toString();
  }catch (NullPointerException npe) {
    // Ignored for 'optional' property
  }

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
# SPMaskParameters_portlet NETWORK
<%out.flush();%>
<%com.zucchetti.sitepainter.Library.includeResource(request,response, "/spofflineapp/manifests/SPSelectVersion_portlet_manifest.jsp?getType=network&m_cSPOfflineApp="+m_cEntryPoint+"&", true);%>
<%}%>
<%if(Library.Empty(getType)){%>
CACHE:
<%}%>
<%if(getType.equals("cache") || Library.Empty(getType)){%>
# SPMaskParameters_portlet CACHE
#IMAGES 
<%=cssManager.GetCSSResources("../../"+sp.getTheme()+"/portalstudio.css","textbox")%>
<%=cssManager.GetCSSVariantResources(sp,out,"textbox")%>
<%=cssManager.GetCSSResources("../../"+sp.getSkin()+"/tabstrip.css","")%>
<%=cssManager.GetCSSVariantResources(sp,out,"")%>
<%=cssManager.GetCSSResources("../../"+sp.getSkin()+"/formPage.css","")%>
<%=cssManager.GetCSSVariantResources(sp,out,"")%>
<%=cssManager.GetCSSResources("../../"+sp.getSkin()+"/portalstudio.css","")%>
<%=cssManager.GetCSSVariantResources(sp,out,"")%>
../../favicon.ico
#STYLESHEET 
<%=sp.GetSkinVariantFileForManifest()%>
#JAVASCRIPT 
../../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calculator.mobile.js")%>
../../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabStrip.js")%>
../../<%=SPPrxycizer.proxycizedPath("controlsBridge.js")%>
../../<%=SPPrxycizer.proxycizedPath("SPMaskParameters.js")%>
../../<%=SPPrxycizer.proxycizedPath("Utilities.js")%>
../../<%=SPPrxycizer.proxycizedPath("LinkZoomObj.js")%>
../../<%=SPPrxycizer.proxycizedPath("HamburgerMenuObj.js")%>
../../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/calendar"+(Library.IsMobile(request)?".mobile":"")+".js")%>
../../<%=SPPrxycizer.proxycizedPath("calendarioObj.js")%>
#OTHER 
../../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/tabstrip.css", SPPrxycizer.Mode.QUERYSTRING)%>
<%=JSPLib.SPWebRootURL(request)%>/jsp/SPMaskParameters_portlet.jsp?m_cSPOfflineApp=<%=sp.getParameter("m_cSPOfflineApp",(sp.getGlobal("i_lOfflineApplicationMode" , false ) ?  sp.getGlobal("i_cEntryPoint","") : "spofflineapp" ))%><%=(!Library.Empty(request.getQueryString())?"&"+request.getQueryString():"")%>
<%=sp.GetPortletJSLibrariesManifest()%>
../../<%=SPPrxycizer.proxycizedPath(sp.getSkin()+"/portalstudio.css", SPPrxycizer.Mode.QUERYSTRING)%>
../../jsp/SPMaskParameters_portlet.jsp?SpCssCode=<%=m_cJSPUID%>
../../<%=sp.isOfflineInstallation(request)?"spofflineapp/scripts/DataBaseConnection.js":""%>
<%out.flush();%>
<%com.zucchetti.sitepainter.Library.includeResource(request,response, "/spofflineapp/manifests/SPSelectVersion_portlet_manifest.jsp?getType=cache&m_cSPOfflineApp="+m_cEntryPoint+"&", true);%>
<%}%>
<%if(Library.Empty(getType)){%>
FALLBACK:
<%}%>
<%if(getType.equals("fallback") || Library.Empty(getType)){%>
<%out.flush();%>
<%com.zucchetti.sitepainter.Library.includeResource(request,response, "/spofflineapp/manifests/SPSelectVersion_portlet_manifest.jsp?getType=fallback&m_cSPOfflineApp="+m_cEntryPoint+"&", true);%>
<%}%>
