<%@ page import="com.zucchetti.SPBridge.Sitepainter" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@ page import="com.zucchetti.spofflineapp.Helpers" %><%@ page import="com.zucchetti.spofflineapp.Library" %><%@ page import="com.zucchetti.spofflineapp.SPManifestEntry" %><%
Sitepainter sp=Sitepainter.getSitepainter(request);
String getType=sp.getParameter("getType","");
 String PRODUCTION_TIME = "20210428115357"; // ETag
if(getType.equals("version")){
  out.print(PRODUCTION_TIME);
  return;
}
if(Library.Empty(getType)){
  response.setHeader("content-type","text/cache-manifest");
  String m_cEntryPoint = sp.getParameter( "m_cSPOfflineApp", ( sp.getGlobal( "i_lOfflineApplicationMode" , false ) ?  sp.getGlobal( "i_cEntryPoint", "plan" ) : "plan " ) );
  if ( !Library.FillBodyResponse( request, m_cEntryPoint, PRODUCTION_TIME ) ) {
    response.setStatus(javax.servlet.http.HttpServletResponse.SC_NOT_MODIFIED);
    return;
  }
  response.setHeader("ETag","\""+PRODUCTION_TIME+"\"");
%>CACHE MANIFEST
# version <%=PRODUCTION_TIME%>
<%}%>
<%if(Library.Empty(getType)){%>
NETWORK:
<%}%>
<%if("network".equals(getType) || Library.Empty(getType)){%>
# arrt_chg_create NETWORK
<%=Helpers.GetManifestEntries("arrt_chg_create",SPManifestEntry.ResType.NETWORK, sp.getLanguage()) %>
<%}%>
<%if(Library.Empty(getType)){%>
CACHE:
<%}%>
<%if("cache".equals(getType) || Library.Empty(getType)){%>
# arrt_chg_create CACHE
../../LibJavascript.importCordova.js
../../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>
../../<%=SPPrxycizer.proxycizedPath("controls.js")%>
../../<%=SPPrxycizer.proxycizedPath("LibJavascript.importCordova.js")%>
../../<%=SPPrxycizer.proxycizedPath("splocalstorage.js")%>
../../<%=SPPrxycizer.proxycizedPath("spstatusmanager.js")%>
../../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/spofflinelib.js")%>
../../<%=SPPrxycizer.proxycizedPath("spmobilelib.js")%>
../../servlet/arrt_chg_create
../../servlet/arrt_chg_create?m_cAction=execute
../../servlet/arrt_chg_create?m_cAction=start

<%=Helpers.GetManifestEntries("arrt_chg_create",SPManifestEntry.ResType.CACHE, sp.getLanguage()) %>

../../<%=sp.getSkin()%>/formPage/loading.gif
../../<%=sp.getSkin()%>/formPage.css

<%}%>
<%if(Library.Empty(getType)){%>
FALLBACK:
<%}%>
<%if("fallback".equals(getType) || Library.Empty(getType)){%>
#
<%}%>
