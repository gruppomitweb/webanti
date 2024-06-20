<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%Sitepainter sp=Sitepainter.getSitepainter(request);%>
<%sp.setSkin("iMobile");%>
<%response.sendRedirect("index.jsp");%>
