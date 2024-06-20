<%@ page import="com.zucchetti.SPBridge.Sitepainter" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%@ page import="com.zucchetti.spofflineapp.Helpers" %><%@ page import="com.zucchetti.spofflineapp.Library" %><%@ page import="com.zucchetti.spofflineapp.SPManifestEntry" %><%
Sitepainter sp=Sitepainter.getSitepainter(request);
String getType=sp.getParameter("getType","");
 String PRODUCTION_TIME = "20131206122418"; // ETag
if(getType.equals("version")){
  out.print(PRODUCTION_TIME);
  return;
}
if(Library.Empty(getType)){
  response.setHeader("content-type","text/cache-manifest");
  Library.SetDeviceSelected(request.getSession(),"IPAD");
  Library.SetSkin(request.getSession(), "iMobile");
  if ( !Library.FillBodyResponse( request, "plan", PRODUCTION_TIME ) ) {
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
# arfn_view_soct NETWORK
<%=Helpers.GetManifestEntries("arfn_view_soct",SPManifestEntry.ResType.NETWORK, sp.getLanguage()) %>
<%}%>
<%if(Library.Empty(getType)){%>
CACHE:
<%}%>
<%if("cache".equals(getType) || Library.Empty(getType)){%>
# arfn_view_soct CACHE
../../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>
../../<%=SPPrxycizer.proxycizedPath("controls.js")%>
../scripts/AppCacheHandler.js
../scripts/spofflinelib.js
../../mootools.js
../../spmobilelib.js
../../visualweb/mootools-core.js
../../servlet/arfn_view_soct
../../servlet/arfn_view_soct?m_cAction=execute
../../servlet/arfn_view_soct?m_cAction=start

<%=Helpers.GetManifestEntries("arfn_view_soct",SPManifestEntry.ResType.CACHE, sp.getLanguage()) %>

../../<%=sp.getSkin()%>/formPage/loading.gif
../../<%=sp.getSkin()%>/formPage.css

<%}%>
<%if(Library.Empty(getType)){%>
FALLBACK:
<%}%>
<%if("fallback".equals(getType) || Library.Empty(getType)){%>
#
<%}%>
