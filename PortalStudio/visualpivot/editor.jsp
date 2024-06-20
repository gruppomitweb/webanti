<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  if (sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples",""))) {
  boolean editableBySmartEditor=true,disablePresetParam=false,hideFiltersBtn=false;
  Class<?> _class;
  try{
    _class=Class.forName("VZMLoader");
    editableBySmartEditor=_class.getField("m_bEditableBySmartEditor").getBoolean(null);
    disablePresetParam=_class.getField("m_bDisablePresetParam").getBoolean(null);
    hideFiltersBtn=_class.getField("m_bHideFiltersButton").getBoolean(null);
  }
  catch (Exception e){  }
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VisualPivot Editor - Sitepainter Infinity Portalstudio</title>
  <script>
    var SPWebRootURL = "<%=JSPLib.SPWebRootURL(request)%>";
    var configname = '<%=JSPLib.ToJSValue(JSPLib.translateXSS(sp.getParameter("ConfigName","")))%>';
    var custom = <%=sp.getParameter("custom",false)%>;
    var offlinemode = <%=sp.getParameter("offlinemode",false)%>;
    var skinList ='<%=sp.getSkinList()%>';
    var currentSkin = '<%=sp.getTheme()%>';
    var cmdhash = '<%=JSPLib.cmdHash("VisualPivot", request.getSession())%>';
   // var frontendport = "<%=sp.getParameter("frontendport",0)%>";
   // var editableBySmartEditor = <%=editableBySmartEditor%>;
   // var disablePresetParam = <%=disablePresetParam%>;
   // var hideFiltersBtn = <%=hideFiltersBtn%>;
    var jsonobj = null;
    var vqrname="";
	</script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-core.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/ZList.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/psEditor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualpivot/itemsObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/properties.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualpivot/properties.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualpivot/editor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>'></script>
  <script>
    //tool e' definita in PortalCommonJS
    tool = 'visualpivot';
  </script>
  <link rel="stylesheet" href="../properties.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/editor.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/portalstudioTheme.css" />
  <link rel="stylesheet" href="visualpivoteditor.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link rel="stylesheet" href="../portalstudio/nanoScrollerMT.css" />

</head>
<body onload="doLoad(event)">
  <span style="z-index:101" id="mversion"></span>
  <div id="toolbar" class="droppable_toolbar horizontal"></div>
  <div id="gadgets_pane">
    <div id="gadgets_panerightbar" class="" title="Toggle Module Fields Explorer"><div id="gadgets_openclose"></div></div>
    <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
      <div class="text">VisualPivot properties</div>
      <a class="gadgets_pane_toggler" title="Toggle source module properties" id="resource-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='formproperties'style="height:100%;" ></div>
    </div>
    <div class="gadgetlistTitle" for="actionListContainer">
      <div class="text">&nbsp;Actions
        <div id="addAction">
          <a title="Add action" href="javascript:addAction()"></a>
        </div>
      </div>
      <a class="gadgets_pane_toggler" title="Toggle action properties" id="resource-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='actionListContainer' >
      <div style="overflow:hidden;" >
        <ol id='actionList'>
        </ol>
      </div>
      </div>
    </div>
    <div class="gadgetlistTitle" for="linkedConfListContainer">
      <div class="text">&nbsp;Linked config
        <div id="addlinkedConf">
          <a title="Add linked configuration" href="javascript:addNewLinkedConf()"></a>
        </div>
      </div>
      <a class="gadgets_pane_toggler" title="Toggle linked properties" id="resource-toggler" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='linkedConfListContainer' >
      <div style="overflow:hidden;" >
        <ol id='linkedConfList'>
        </ol>
      </div>
      </div>
    </div>
  </div>
  <div id='properties'></div>
	<div id="loading" style="display:block"></div>
  <div id="backcanvas">
    <div class="list_container" style="width:40%">
      <div class="tab_wrapper custom_tab_wrapper" id="custom_tab_wrapper" >FIELDS</div>
      <div id='refreshfields' class="btn" title="Refresh query fields"></div>
      <div id="list" class="lista" ></div>
    </div>
    <div style="float:left;margin-left:10%;width:40%;height:100%">
      <div style="width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">ROWS</div>
        <div id="rows" class="lista"></div>
        <div id="rows_drag" class="drag"></div>
      </div>
      <div style="width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">COLUMNS</div>
        <div id="columns" class="lista"></div>
        <div id="columns_drag" class="drag"></div>
      </div>
      <div style="width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">MEASURES</div>
        <div id="measures" class="lista"></div>
        <div id="measures_drag" class="drag"></div>
      </div>
      <div style="background-color:#c3c3c3;width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">OTHER DIMENSIONS</div>
        <div id="odimensions" class="lista"></div>
        <div id="odimensions_drag" class="drag"></div>
      </div>
      <div style="background-color:#c3c3c3;width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">OTHERS MEASURES</div>
        <div id="omeasures" class="lista"></div>
        <div id="omeasures_drag" class="drag"></div>
      </div>
    </div>

  </div>
  <div id="newcolumncontainercinema"></div>
  <div id='manageFilters' style='display:none'>
    <div class="tab_wrapper">FILTERS</div>
    <div id='newfilter' class="btn" title="Add filter"></div>
    <ul id='filters'>
    </ul>
    <input type='button' id='confirmManageFilters' class='portalstudio_button' value='Ok' onclick='confirmManageFilters()' />
    <input type='button' id='closeManageFilters' class='portalstudio_button black' value='Cancel' onclick='closeManageFilters()' />
  </div>
  <div id='i_preview_wrapper'>
    <div id='i_preview_title'>
      <div class="title-box">Preview</div>
      <a href="javascript:toggleParameters()" id="toolbar_ok" title="Settings">Settings<i class="mi mi-settings"></i></a>
    </div>
    <iframe allowtransparency="true" frameborder="0" toResize='no' id='i_preview' name='i_preview' style='position:absolute;top:0;border:0;width:100%;box-sizing:border-box'></iframe>
    <div id='parameters_wrapper'>Parameters List</div>
  </div>
</body>
<script type="text/javascript" src="../portalstudio/psHelp.js"></script>
</html>
<%
  }else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
