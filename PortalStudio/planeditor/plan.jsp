<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
%>
<html>
<head>
  <title>Plan Editor - Sitepainter Infinity Portalstudio</title>
  <link rel="stylesheet" href="../filewindow.css" type="text/css">
  <link rel="stylesheet" href="../portalstudio/editor.css" type="text/css">
  <link rel="stylesheet" href="../properties.css" type="text/css">
  <link rel="stylesheet" href="planeditor.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
  <script>
    var isCMS = <%=sp.getParameter("cms",false)%>;
    var previewCMS = <%=sp.getParameter("cmspreview",false)%>;
    var dnsCMS = '<%=JSPLib.ToJSValue(sp.getParameter("dns",""))%>';
    var SPWebRoot = '<%=JSPLib.SPWebRootURL(request)%>';
    var companies = '';
    var cmdhash = '<%=getCmdHash("plan", request)%>';

    <%
      boolean rewriteId=false;
      if(request.getQueryString()!=null && request.getQueryString().indexOf("id=")==-1)
        rewriteId=true;
      if("true".equals(sp.getParameter("cms","false"))){
        RSConnection conn_company = new RSConnection("start_login_companies",100,sp,false);
        conn_company.SetPage(sp.getParameter("page_company" ,"1"));
        String companies = "";
        while (!conn_company.Eop()) {
          companies += conn_company.GetString("codazi").trim()+",";
          conn_company.Next();
        }
        //Elimino ultima virgola
        if(!JSPLib.Empty(companies))
          companies = companies.substring(0,companies.length()-1);
    %>

    companies = '<%=companies%>';
    <%conn_company.Close();%>
    <%}%>
    var planlockdelete_str = "<%=sp.translate("PLAN_CMS_DELETELOCK")%>";
    if(<%=rewriteId%>) {
      window.location.href+="&id="+'<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>';
    }
  </script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("canvasLib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("raphael.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("planeditor/itemsObj.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("planeditor/properties.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("planeditor/plan.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>"></script>
  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link rel="shortcut icon" href="../portalstudio/images/sp.ico" />
</head>

<body onLoad="window.doLoad(event,'<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("mode",""))%>',<%=sp.getParameter("frontendport",0)%>)" onkeydown="window.manageItems(event,true)"  onkeyup="window.setProperties(event)" class='planEditor'>
	<div id="toolbar" class="droppable horizontal"></div>
	<div id='properties' class="properties" ondragstart="noDefaultDrag(event)"></div>
	<div id="backcanvas" class="backcanvas" onselectstart="noDefaultDrag(event)" >
		<div id="handler" class="handler" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)"><p></p></div>
		<div id="canvas" class="canvas" ondragstart="noDefaultDrag(event)" >
			<div id="loading" class="loading"></div>
			<div id="mask" class="tipz" title="Click to add a new page"></div>
			<div id="canvasitems" class="canvasitems"></div>
			<div id="canvashandlers" class="canvashandlers"></div>
			<div id="canvaslinks" class="canvaslinks" onMouseDown="beginDragSelection(event)"></div>
			<div id="canvas_showlink" class="canvas_showlink"></div>
			<div id="drag" class="drag"><div id="dragcontent" class="dragcontent"></div></div>
		</div>
	</div>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</body>

</html>
