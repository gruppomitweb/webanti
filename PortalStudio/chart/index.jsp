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
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>Chart Editor - Sitepainter Infinity Portalstudio</title>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("mootools.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("ZtChartFunctions.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("ZtChartTransDict.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("chart/itemsObj.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("chart/properties.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("ChartObj.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>"></script>
  <jsp:include page="ZtChartLibs.jsp" />
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("ZtChart.js")%>"></script>


  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("chart/demoDataSet.js")%>"></script>
  <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("chart/charteditor.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>

  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/editor.css" />
  <link rel="stylesheet" type="text/css" href="../properties.css" />

  <link rel="stylesheet" type="text/css" href="../portalstudio/nanoScrollerMT.css" />
  <link rel="stylesheet" type="text/css" href="../<%=sp.getTheme()%>/portalstudio.css" />
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link rel="stylesheet" type="text/css" href="charteditor.css" />
  <link rel="stylesheet" type="text/css" href="../classeditor/fontList.css" />

  <script type="text/javascript">
    ZtVWeb.SetTheme('<%=sp.getSkin()%>');
    var SPWebRoot = '<%=JSPLib.SPWebRootURL(request)%>';
    var mainitem = null; //variabile necessaria per il keydown comune in PortalCommonJS
    var skinList ='<%=sp.getSkinList()%>';
    var currentSkin = '<%=sp.getTheme()%>';
    var lightmode = '<%=sp.getParameter("lightmode","default")%>';
    var cmdhash = '<%=getCmdHash("Chart", request)%>';
  </script>
</head>
<body onload="doLoad('<%=JSPLib.ToJSValue(sp.getParameter("filename",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("custom",""))%>')" onResize="resizeWindow(event,false)">
  <div id="toolbar" class="horizontal droppable PSToolbar"></div>
  <div id="gadgets_pane" >
    <div id="gadgets_panerightbar" class="" title="Toggle Explorer"><div id="gadgets_openclose"></div></div>
    <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
      <div class="text">&nbsp;Common Properties</div>
      <a id="common-resource-toggler" class="gadgets_pane_toggler" title="Toggle source properties" href="javascript:void(0)"></a>
      <a id="formproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()" style="visibility:hidden;"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id="formproperties" style="height:100%;"></div>
    </div>
    <div id="propertiesTitle" class="gadgetlistTitle" for="properties">
      <div id="propertiesTitleTxt" class="text">&nbsp;Specific Properties</div>
      <a id="specific-resource-toggler" class="gadgets_pane_toggler opened" title="Toggle source properties" href="javascript:void(0)"></a>
      <a id="specificproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()" style="visibility:hidden;"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id="properties" style="height:100%">
      </div>
    </div>
  </div>

  <div id="charttypes">
  	<span id="ctype_img" class="unselectable typepic" style="background-position:center center;"></span>
  	<span id="ccategorytype_label" class="unselectable typelabel"></span>
  	<span id="ctype_label" class="unselectable typelabel"></span>
  </div>
  <div id="switchers" style="visibility: hidden;">
    <span id="switch-off" onclick="switchConf(this)"></span>
    <span id="switch-on" onclick="switchConf(this)"></span>
    <span class="switch-txt">Advanced configurator</span>
    <div style="padding-left: 26px;">
      <span class="lib-txt">Library:</span>
    <span id="lib-name">D3</span>
    </div>
  </div>
  <div id="backcanvas" style="overflow:auto">
    <div id="previewMask" name="previewMask" style="height:auto;float:left;"></div>
    <div id="chart_notes" style="float:right;width:265px;height:98%;display:none;">
      <span class="iconnote" style="font-family: icons8_win10;float:left;padding-right:3px;font-size:18px;"></span>
      <div style="width:80%;float:left;font-family:Open Sans;font-size:14px;padding-bottom:3px;">Notes</div>
      <textarea id="chart_notes_text" onblur="SaveChartNotes(this)" style="width:95%;height:95%;resize:none;overflow:auto;border-right:none;border-bottom:none;border-top:none;background-color:#f3f3f3;" placeholder="Type your notes here"></textarea>
    </div>
  </div>
  <!-- Div Preview -->
  <div id='i_preview_wrapper'>
    <div id='i_preview_title'>
      <div id="i_preview_close_button" onclick="togglePreview()"></div>
      <div>Preview</div>
    </div>
    <iframe allowtransparency="true" frameborder="0" toResize='no' id='i_preview' name='i_preview'></iframe>
  </div>
</body>
</html>
