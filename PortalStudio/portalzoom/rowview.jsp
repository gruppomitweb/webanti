<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@page import="java.util.*" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
%>
<html>

<head>
  <title>Portlet Editor - Sitepainter Infinity Portalstudio</title>
  <script src='../<%=SPPrxycizer.proxycizedPath("raphael.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalzoom/rowview.js")%>'></script>
  <link rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalzoom/rowview.css")%>">
</head>

<body onload="doLoad(event)">
  <div id="loader"></div>
  <div id='container'>
    <div id="topbar" class="droppable horizontal">
      <div class="title">Row view</div>
      <nav class="toolbar">
        <span id="toolbar_cancel" title='Save and Close'>Save and Close<i class="mi mi-confirm"></i></span>
        <span id="toolbar_ok" title='Close'>Close<i class="mi mi-close"></i></span>
      </nav>
    </div>
    <div class="canvas" id="canvas">
      <div id="backcanvas"></div>
    </div>
  </div>
</body>

</html>
