<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
	Sitepainter sp=new Sitepainter(request);
	sp.setContentType(response);
%>
<!DOCTYPE html>
<html>
  <head>
    <title>Select</title>
    <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>"></script>
    <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
    <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("maskparameters/SPMaskParametersConfigurator_filterList.js")%>"></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
    <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
    <link type="text/css" rel="stylesheet" href="../filewindow.css">
    <link type="text/css" rel="stylesheet" href="./SPMaskParametersConfigurator.css">
    <link type="text/css" rel="stylesheet" href="../portalstudio/nanoScrollerMT.css">
  </head>

  <body onload="FillList()" onResize='resize()'>
    <div id='title' class='titoli'>
      <div class='columnSx'> Select Field </div>
    </div>

    <div id='content'>
    </div>

    <div>
      <input id='allField' type='hidden' value=<%=JSPLib.ToHTMLValue(request.getParameter("allField"))%>>
      <input id='allFieldDescription' type='hidden' value=<%=JSPLib.ToHTMLValue(request.getParameter("allFieldDescription"))%>>
      <input id='fieldSelected' type='hidden' value=<%=JSPLib.ToHTMLValue(request.getParameter("fieldSelected"))%>>
      <input id='action' type='hidden' value=<%=JSPLib.ToHTMLValue(request.getParameter("action"))%>>
      <input id='SPModalLayerId' type='hidden' value=<%=JSPLib.ToHTMLValue(sp.getParameter("SPModalLayerId",""))%>>
    </div>

    <div class='titoli' id='footer'>
      <label> Field selected: </label>
      <div style='display:inline-block;'><input type="text" id="result" style='width:290px; display:inline-block;'/> </div>
      <input id="OperationButton" type="button" value="Ok" onclick="SelectThisParameter()" class="bottoni">
      <input id="CancelButton" type="button" value="Cancel" onclick="closeWindow();" class="bottoni">
    </div>
    <div id="maskSearch" style='height:69px;top:6px;left:297px;position:absolute;z-index:1000;overflow:hidden;max-width:200px;' >
      <div style='margin-top:6px;' onMouseDown="dragToolbar(event,'maskSearch');">
        <label id='searchLabel'>Search:</label>
        <span class='tab' onclick='selectTab(this)' id='tabDescription'>Description</span>
        <span class='tab tabSelected' onclick='selectTab(this)' id='tabName'>Name</span>
      </div>
      <input type='text' id='search' style='width:180px;'/>
    </div>

  </body>
</html>
