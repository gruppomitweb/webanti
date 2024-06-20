<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@page import="com.zucchetti.PortalStudio.*" %>
<%Sitepainter sp=new Sitepainter(request);%>

<html>
<head>
	<title>Gadget Explorer</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
	<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("templateeditor/gadget_explorer.js")%>'></script>
  <link type="text/css" rel="stylesheet" href="editor.css">
  <link type="text/css" rel="stylesheet" href="gadget_explorer.css">

	<script>
		var SPWebRootURL = "<%=JSPLib.SPWebRootURL(request)%>";
		var curr_zone = '<%=JSPLib.ToJSValue(sp.getParameter("curr_zone",""))%>';
	</script>
</head>

<body>
  <div id="loader"><span></span></div>

	<div class="flexbox-parent">

	    <header class="header" id="toolbar-top">Gadget Explorer - <strong id="title"></strong></header>

	    <div class="fill-area flexbox-item-grow">
	      <div class="flexbox-item-grow wrapper">

	        <aside class="properties-aside">
	          <div id="folder_pane" class="child-scrollable"></div>
	        </aside>

	        <main class="main">
	          <div class="child-scrollable" id="main_zone"></div>
	        </main>

	      </div>
	    </div>
	</div>

</body>
</html>
