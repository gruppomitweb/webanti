<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%Sitepainter sp=Sitepainter.getSitepainter(request);%>
<%sp.setSkin("Infinity");%>
<%response.sendRedirect("index.jsp");%>
