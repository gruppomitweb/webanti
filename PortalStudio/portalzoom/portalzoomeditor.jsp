<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="java.util.*" %><%@ page import="org.json.JSONObject" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  //shift online-offline
  boolean off_forshift = sp.IsOfflineTable(request,sp.getParameter("Table",""));
  boolean editableBySmartEditor=true,disablePresetParam=false,hideFiltersBtn=false;
  Class<?> _class;
  try{
    _class=Class.forName("VZMLoader");
    editableBySmartEditor=_class.getField("m_bEditableBySmartEditor").getBoolean(null);
    disablePresetParam=_class.getField("m_bDisablePresetParam").getBoolean(null);
    hideFiltersBtn=_class.getField("m_bHideFiltersButton").getBoolean(null);
  }
  catch (Exception e){
  }
  if (sp.getParameter("offlinemode",false) != off_forshift) {
    String params = JSPLib.getParametersList(request,null,"offlinemode");
    response.sendRedirect(request.getRequestURI()+(!"".equals(params)?"?":"")+JSPLib.getParametersList(request,null,"offlinemode")+(off_forshift?(!"".equals(params)?"&":"?")+"offlinemode=true":""));
  } else {
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VisualZoom Editor - Sitepainter Infinity Portalstudio</title>
  <script>
    var SPWebRootURL = "<%=JSPLib.SPWebRootURL(request)%>";
    var tablename = '<%=JSPLib.ToJSValue(JSPLib.translateXSS(sp.getParameter("Table","")))%>';
    var configname = '<%=JSPLib.ToJSValue(JSPLib.translateXSS(sp.getParameter("ConfigName","")))%>';
    var custom = <%=sp.getParameter("custom",false)%>;
    var offlinemode = <%=sp.getParameter("offlinemode",false)%>;
    var skinList ='<%=sp.getSkinList()%>';
    var currentSkin = '<%=sp.getTheme()%>';
    var frontendport = "<%=sp.getParameter("frontendport",0)%>";
    var editableBySmartEditor = <%=editableBySmartEditor%>;
    var disablePresetParam = <%=disablePresetParam%>;
    var hideFiltersBtn = <%=hideFiltersBtn%>;
    var jsonconfiguration = null;
    var vqrname="";
    var cmdhash = '<%=getCmdHash("VisualZoom", request)%>';
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
  <script src='../<%=SPPrxycizer.proxycizedPath("portalzoom/itemsObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalzoom/properties.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalzoom/portalzoomeditor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>"></script>
  <script>
    //tool e' definita in PortalCommonJS
    tool = 'portalzoom';
  </script>
  <link rel="stylesheet" href="../properties.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/editor.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/portalstudioTheme.css" />
  <link rel="stylesheet" href="portalzoomeditor.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link rel="stylesheet" href="../portalstudio/nanoScrollerMT.css" />

</head>
<body onload="doLoad(event)">
  <span style="z-index:101" id="mversion"></span>
  <div id="toolbar" class="droppable_toolbar horizontal"></div>
  <div id="gadgets_pane" style="display:">
    <div id="gadgets_panerightbar" class="" title="Toggle Module Fields Explorer"><div id="gadgets_openclose"></div></div>
    <!--div id="gadgetlistTitle"-->
    <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
      <div class="text">&nbsp;Zoom properties</div>
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
  <div id="backcanvas" style="">
    <div class="list_container" style="width:40%">
      <div class="tab_wrapper custom_tab_wrapper" id="custom_tab_wrapper" >Query fields</div>
      <div id='refreshfields' class="btn" title="Refresh query fields"></div>
      <div id="list" class="lista" ></div>
    </div>
    <div style="float:left;width:10%;text-align:center;">
      <div id="columns_arrows" style="width:100%;text-align:center;height:300px;vertical-align:middle;">

        <div class="arrow_button right" onclick="AddColumns(GetSelectedFields())"></div>
        <br/>
        <div class="arrow_button left" onclick="DeleteColumn(GetSelectedColId(selectedColumns,columnsObj))"></div>
      </div>
      <div id="rowlayer_arrows" style="width:100%;text-align:center;height:150px;">

        <div class="arrow_button right" onclick="AddRowLayer(GetSelectedFields())"></div>
        <br/>
        <div class="arrow_button left" onclick="DeleteRowLayer(GetSelectedColId(selectedRowLayer,rowLayerObj))"></div>
      </div>
      <div id="hidefields_arrows" style="width:100%;text-align:center;height:150px;">

        <div class="arrow_button right" onclick="AddHideFields(GetSelectedFields())"></div>
        <br/>
        <div class="arrow_button left" onclick="DeleteHidddenField(GetSelectedColId(selectedHideFields,hiddenFieldsObj,'field'))"></div>
      </div>
    </div>
    <div style="float:left;width:40%;height:100%">
      <div style="width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">Grid columns</div>
        <div id='newcolumn' class="btn" title="Add html static column"></div>
        <div id="columns" class="lista"></div>
        <div id="columns_drag" class="drag"></div>
      </div>
      <div style="width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">Row layer</div>
        <div id="rowlayer" class="lista"></div>
        <div id="rowlayer_drag" class="drag"></div>
      </div>
      <div style="width:100%" class="list_container">
        <div class="tab_wrapper custom_tab_wrapper">Hidden columns</div>
        <div id="hidefields" class="lista"></div>
        <div id="hidefields_drag" class="drag"></div>
      </div>
    </div>
  </div>
  <div id="newcolumncontainer">
    <label class="tab_wrapper" for="columntext" style="float:none;">Insert column value</label>
    <div style='text-align:center;padding:10px;'>
    <input style="width:60%" id="columntext" type="text">
    <input type="button" class="portalstudio_button" style="z-index: 1; display: inline-block;width:40px;" value="Ok" title="Confirm column and apply settings" onclick="closeNewColumn(true)">
    <input type="button" class="portalstudio_button black" style=" z-index: 1; display: inline-block;width:50px;" value="Cancel" title="Cancel operation" onclick="closeNewColumn(false)">
    </div>
  </div>
  <div id="newcolumncontainercinema"></div>
  <div id='orderExtraTitle' style='display:none'>
    <div class="tab_wrapper">Secondary bar title</div>
    <div id='extratitle' class='lista'>
    </div>
    <input type='button' class='portalstudio_button black' value='Cancel' onclick='closeOrderExtraTitle()' style='width:50px; float:right; margin-top:6px; margin-right:7px; margin-left:5px;' />
    <input type='button' class='portalstudio_button' value='Ok' onclick='confirmOrderExtraTitle()' style='width:40px; float:right; margin-top:6px;'/>
  </div>
  <div id='manageFilters' style='display:none'>
    <div class="tab_wrapper">Filters</div>
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
</body>
<script type="text/javascript" src="../portalstudio/psHelp.js"></script>
</html>
<%
    } //chiusura if per redirect
%>
