<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
Sitepainter sp=new Sitepainter(request);
if (sp.CanAccessEditor("PortalStudio") || sp.isLogged()) {
  sp.setContentType(response);
%>
<!DOCTYPE html>
<html>
	<head>
		<script src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
 		<script src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>
  	<script src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
		<script src="../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>"></script>
		<script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
    <script src="../<%=SPPrxycizer.proxycizedPath("smartreport/selectDatasource.js")%>"></script>
		
    <link rel="stylesheet" href="../<%=sp.getTheme()%>/portalstudio.css" type="text/css">
    <link rel="stylesheet" type="text/css" media="screen" title="default" href="editor.css"></link>
		<link rel="stylesheet" type="text/css" media="screen" title="default" href="smartreport.css"></link>

		<script>
			var width = null;
			var height = null;
			var callerFunction = null;
			var m_bUpdated = false;
      var offlinemode = null;
      var datasource = null;
			function Init(){
        Ctrl('btnCancel').value = '<%=JSPLib.ToJSValue(sp.translate("SMR_CANCEL"))%>';
        Ctrl('btnConfirm').value = '<%=JSPLib.ToJSValue(sp.translate("SMR_OK"))%>';
				width = '<%=JSPLib.ToJSValue(sp.getParameter("width",""))%>';
				height = '<%=JSPLib.ToJSValue(sp.getParameter("height",""))%>';
				callerFunction = '<%=JSPLib.ToJSValue(sp.getParameter("callerFunction",""))%>';
				datasource = '<%=JSPLib.ToJSValue(sp.getParameter("datasource",""))%>';
				offlinemode = CharToBool('<%=JSPLib.ToJSValue(sp.getParameter("offlinemode",""))%>');
        initIFrame();
        drawSwitch();
        document.body.style.width = width+"px";
        document.body.style.height = height+"px";
			}
	</script>
	</head>

	<body onload="Init()">
    <div id="ifrbocont">
    <iframe id="loadportletbo" frameborder=0></iframe>
    </div>
    <div style="padding-top:5px">
      <div id="mode" style="float:left;"></div>	
      <div id="confirmButtons" style="float:right;margin-right:5px">
        <input id="btnConfirm" type="button" value="OK" class="btn button" onclick="getConfirm(true)"></input>
        <input id="btnCancel" type="button" value="CANCEL" class="btn button" onclick="getConfirm(false)"></input>
      </div>
    </div>
	</body>
</html>
<%
}
else
  response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
%>
