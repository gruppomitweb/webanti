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
<title>Mask Parameters - Sitepainter Infinity Portalstudio</title>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("maskparameters/itemsObj.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("maskparameters/properties.js")%>"></script>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>"></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>"></script>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
<script type='text/javascript' src="../<%=SPPrxycizer.proxycizedPath(sp.getTheme()+"/styleVariables.js")%>"></script>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>"></script>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/mif.tree.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("maskparameters/maskparameters.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/mergeVDMObj.js")%>'></script>
<script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>"></script>

<link rel="stylesheet" href="../portalstudio/mif-tree.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../Notimoo.css" />
<link rel="stylesheet" type="text/css" href="../portalstudio/editor.css" />
<link rel="stylesheet" href="../properties.css" type="text/css">
<link rel="stylesheet" href="maskparameters.css" type="text/css">
<link rel="stylesheet" href="../portalstudio/nanoScrollerMT.css" />
<link type='text/css' rel='STYLESHEET' href='<%=JSPLib.SPWebRootURL(request)%>/<%=sp.getTheme()%>/portalstudio.css'>
<link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />


<script type="text/javascript">
	var SPWebRoot = '<%=JSPLib.SPWebRootURL(request)%>';
  ZtVWeb.SetTheme('<%=sp.getSkin()%>');
  var  mainitem = null; //variabile necessaria per il keydown comune in PortalCommonJS
  var cmdhash = '<%=JSPLib.cmdHash("VisualDinamicMask", request.getSession())%>';
</script>

</head>
<body onload="doLoad(event,'<%=JSPLib.ToJSValue(sp.getParameter("filename",""))%>','<%=sp.getParameter("zoomMode",false)%>','<%=JSPLib.ToJSValue(sp.getParameter("queryName",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("custom",""))%>')">
  <span style="z-index:101" id="mversion"></span>
  <div id="toolbar" class="horizontal droppable"> </div>
  <div id="gadgets_pane" >
    <div id="gadgets_panerightbar" class="" title="Toggle form properties"><div id="gadgets_openclose"></div></div>

    <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
      <div class="text">&nbsp;Mask-Parameters properties</div>
      <a class="gadgets_pane_toggler" title="Toggle source module properties" id="formproperties-toggler" href="javascript:void(0)"></a>
       <a id="formproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='formproperties'style="height:100%;" ></div>
    </div>
    <div id="calculationTitle" class="gadgetlistTitle" for="calculationContainer">
      <div class="text" id="calculationTitleTxt">&nbsp;Calculations
        <div id="addCalculation">
          <a title="Add calculation" href="javascript:addCalculation(null,true)"></a>
        </div>
      </div>
      <a class="gadgets_pane_toggler" title="Toggle calculations" id="calculation-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='calculationContainer'  style='height:100%'>
        <div style='overflow:hidden'>
          <ol id='calculationList'>
          </ol>
        </div>
      </div>
    </div>

    <div id="actionTitle" class="gadgetlistTitle" for="actionContainer">
      <div class="text" id="actionTitleTxt">&nbsp;Actions
        <div id="addAction">
          <a title="Add action" href="javascript:addAction(null,true)"></a>
        </div>
      </div>
      <a class="gadgets_pane_toggler" title="Toggle actions" id="action-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='actionContainer'  style='height:100%'>
        <div style='overflow:hidden'>
          <ol id='actionList'>
          </ol>
        </div>
      </div>
    </div>


    <div id="propertiesTitle" class="gadgetlistTitle" for="fieldListContainer">
      <div class="text" id="propertiesTitleTxt">&nbsp;Fields</div>
      <a class="gadgets_pane_toggler" title="Toggle fields" id="field-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='fieldListContainer'  style='height:100%'>
      </div>
    </div>
    <div id="propertiesTitle" class="gadgetlistTitle" for="searchproperties">
      <div class="text" id="searchTitleTxt">&nbsp;Search</div>
      <a class="gadgets_pane_toggler" title="Toggle search" id="search-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='searchproperties'style="height:100%;" ></div>
    </div>
  </div>
  <div id='properties'></div>
	<div id="loading" style="display:block"></div>
   <div id="navmenu_tabcontainer" style='left:270px; width:1000px;'>
		<div class="tab_wrapper" style='width:100%'>
      <span> Preview </span>
    </div>
  </div>
  <div id="backcanvas">
		<div style="float:left;clear:both;height:0px;line-height:5px;min-height:0px;width:100%"></div>
		<div id="previewMask" name="previewMask" > </div>
	</div>
  <div id='canvas' style="display:none; width:0; height:0; opacity:0"></div>
  <div id='canvashandlers' style="display:none; width:0; height:0; opacity:0"></div>
  <!-- Div Preview -->
  <div id="i_preview_wrapper">
    <div id='i_preview_title'>
      <div id='i_preview_close_button' onclick='togglePreview()'></div>
      <div>&nbsp;&nbsp; Preview &nbsp;&nbsp;</div>
    </div>
    <iframe id="i_preview" name="i_preview"></iframe>
  </div>
  <div class="contenuto" id="previewConfigDiv">
  <div class='titoli textClipped' id='previewConfigTitle'>
  Preview configurator
 </div>
<input type='checkbox' class='configCheck' checked id='check_showHiddenVariant'/> <label for='check_showHiddenVariant'> Show "hidden in configuration" </label><br/>
<input type='checkbox' class='configCheck' id='check_showHidden'/> <label for='check_showHidden'> Show "always hidden" </label><br/>
<input type='checkbox' class='configCheck' id='check_showExtended'/> <label for='check_showExtended'> Show "extended fields" </label> <br/>
 <input id='configPreviewButton' type='button' value='Ok'/>
</div>
</body>
<script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</html>
