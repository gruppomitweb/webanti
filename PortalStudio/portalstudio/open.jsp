<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors"
%><%@ page import="com.zucchetti.SPBridge.*"
%><%@ page import="com.zucchetti.PortalStudio.*"
%><%@ page import="java.util.*"
%><%@ page import="org.json.JSONObject"
%><%@ page import="com.zucchetti.sitepainter.SPPrxycizer"
%><%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  if(! ( sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples","")) )) {
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    return;
  }
%><!DOCTYPE html>
<html>
<head>
<title>Open file Sitepainter Infinity Portalstudio</title>
  <link type="text/css" rel="stylesheet" href="../portalstudio/open.css">
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/psEditor.js")%>'></script>
  <script>
    var SPWebRootURL = "<%=JSPLib.SPWebRootURL(request)%>";
    var painter ='<%=JSPLib.ToJSValue(((request.getParameter("tool")==null || "".equals(request.getParameter("tool")))?"portlet":request.getParameter("tool")))%>';
    var onetool = <%=sp.getParameter("onetool",false)%>;
    var offlinemode = '<%=JSPLib.ToJSValue(sp.getParameter("offlinemode",""))%>';
    var ReturnObjectId = '<%=JSPLib.ToJSValue(sp.getParameter("ExpressionID",""))%>';
    var callerFunction = '<%=JSPLib.ToJSValue(sp.getParameter("callerFunction",""))%>';
    var SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
    var theme_tmp = '<%=JSPLib.ToJSValue(sp.getParameter("theme",""))%>';
    var closeSidebar = '<%=JSPLib.ToJSValue(sp.getParameter("close-sidebar",""))%>';
    var saveAs = '<%=JSPLib.ToJSValue(sp.getParameter("save-mode",""))%>';
    var cssType = '<%=JSPLib.ToJSValue(sp.getParameter("css-type",""))%>';
    var queryName = '<%=JSPLib.ToJSValue(sp.getParameter("query-name",""))%>';
    var isOffline = '<%=JSPLib.ToJSValue(sp.getParameter("offline",""))%>';
    var ReturnObjectIndex = '<%=JSPLib.ToJSValue(sp.getParameter("objIndex",""))%>';
    var ctrlsToBeListed = '<%=JSPLib.ToJSValue(sp.getParameter("ctrlsToBeListed",""))%>';
    var fromPortletName = '<%=JSPLib.ToJSValue(sp.getParameter("fromPortletName",""))%>';
    var altInterfaceFor = '<%=JSPLib.ToJSValue(sp.getParameter("altInterfaceFor",""))%>';
    var skins = getTheme();
  </script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/open.js")%>'></script>
</head>

<body>
  <div class="flexbox-parent">
    <header class="header">
      <h1 id='open-title'>Open File</h1>
      <div class="search">
        <div class="extra-filter">
          <div id="open-page" class="tabright">Pages</div>
          <div id="open-plan" class="tabright active">Plans</div>
          <div id="open-tag" class="tabright">tags</div>
          <div id="open-default" class="tabright active">default</div>
        </div>
        <div id="search-handler">
          <span id="search-description">description</span><!--
       --><span id="search-title" class="active">title</span><!--
       --><div id="search-container">
            <div id="clear"></div>
            <input id="search-file" type="text" value="" placeholder="Search for..." />
          </div>
        </div>
      </div>
    </header>
    <div class="fill-area flexbox-item-grow">
      <div class="flexbox-item-grow wrapper">
        <nav class="tools-container">
          <div class="child-scrollable" id="tools">
            <div class="tab" id="portlet">Portlet</div>
            <div class="tab" id="pagelet">Pagelet</div>
            <div class="tab" id="plan">Plan</div>
            <div class="tab" id="visualquery">Query</div>
            <div class="tab" id="portalzoom">Zoom</div>
            <div class="tab" id="report">Report</div>
            <div class="tab" id="smartreport">SmartReport</div>
            <div class="tab" id="chart">Chart</div>
            <div class="tab" id="module">Module</div>
            <div class="tab" id="scandoc">Scan</div>
            <div class="tab" id="menu">Menu</div>
            <div class="tab" id="decorators">Decorators</div>
            <div class="tab" id="cssclass">CSS Class</div>
            <div class="tab" id="maskparameters">Mask parameters</div>
            <div class="tab" id="manualjsp">Manual JSP</div>
            <div class="tab" id="css">Manual CSS</div>
            <div class="tab" id="interfaces">Interfaces</div>
            <div class="tab" id="visualpivot">VisualPivot</div>
          </div>
        </nav>
        <main class="list-container">
          <div id='nav2'></div>
          <div class="child-scrollable" id="list"></div>
        </main>
      </div>
    </div>
    <footer class="footer">
      <div id="skin-list">
        <span>Select skin:</span>
      </div>
      <div id="filter">
        <div id="custom">
          <span>Custom:</span>
          <input type="checkbox" name="custom" value='custom'/>
        </div>
        <div id="offline">
          <span>Offline:</span>
          <input type="checkbox" name="offline" value='offline' />
        </div>
      </div>
    </footer>
  </div>
</body>

</html>
