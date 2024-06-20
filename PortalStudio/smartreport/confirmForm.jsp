<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
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
		<script src="../<%=SPPrxycizer.proxycizedPath("smartreport/confirmForm.js")%>"></script>

    <link rel="stylesheet" href="../<%=sp.getTheme()%>/portalstudio.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="screen" title="default" href="confirmForm.css"></link>

		<script>
			var SPModalLayerId = null;
			var width = null;
			var height = null;
			var msg = null;
			var callerFunction = null;
			var objparam = null;
			var m_bUpdated = false;
			function Init(){
        Ctrl('btnCancel').value = '<%=JSPLib.ToJSValue(sp.translate("SMR_CANCEL"))%>';
        Ctrl('btnConfirm').value = '<%=JSPLib.ToJSValue(sp.translate("SMR_OK"))%>';
				SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
				width = '<%=JSPLib.ToJSValue(sp.getParameter("width",""))%>';
				height = '<%=JSPLib.ToJSValue(sp.getParameter("height",""))%>';
				msg = '<%=JSPLib.ToJSValue(sp.getParameter("msg",""))%>';
				callerFunction = '<%=JSPLib.ToJSValue(sp.getParameter("callerFunction",""))%>';
        var objp_str = '<%=JSPLib.ToJSValue(sp.getParameter("objparam",""))%>';
				objparam = Empty(objp_str) ? {} : JSON.parse(objp_str);
				document.body.firstElementChild.style.width = width+"px";
				document.body.firstElementChild.style.height = height+"px";
				// disegno
				draw(msg);
			}
	</script>
	</head>

	<body onload="Init()">
		<div id=confirmContent">
			<div id="confirmTitle" style="display:none" class="unselectable">ACTION CONFIRM</div>
			<div id="confirmBody"></div>
			<div id="confirmButtons">
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
