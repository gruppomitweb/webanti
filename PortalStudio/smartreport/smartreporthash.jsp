<%@ page extends="com.zucchetti.PortalStudio.PortalStudioBase"
%><%@ page import="com.zucchetti.SPBridge.*"
%><%@ page import="com.zucchetti.PortalStudio.*"
%><%@ page import="com.zucchetti.sitepainter.SPPrxycizer"
%><%
  Sitepainter sp=new Sitepainter(request);
  if (sp.isLogged()) {
    sp.setContentType(response);
    String table = sp.getParameter("table","");
    String hash = JSPLib.cmdHash(table, request.getSession());
%>
<%=hash%>
<%} else{ response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request)); }%>
