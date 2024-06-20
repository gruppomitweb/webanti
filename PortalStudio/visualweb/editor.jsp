<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  boolean rewriteId=false;
  if(request.getQueryString()!=null && request.getQueryString().indexOf("id=")==-1){
    rewriteId=true;
  }
%>
<!DOCTYPE html>
<html>
<head>
 <title>Portlet Editor - Sitepainter Infinity Portalstudio</title>
<!--script>
 var logTime = 0;
  console.log( logTime );
  logTime=new Date().getTime();
</script-->

<script type="text/javascript">
  var b_reload=true;
	var SPWebRootURL='<%=JSPLib.SPWebRootURL(request)%>';
  var skinList ='<%=sp.getSkinList()%>';
  var currentSkin = '<%=sp.getTheme()%>';
  var version=<%=JSPLib.GetPSVersion()%>;
  var autopreview = <%=sp.getParameter("autopreview",false)%>;
  var currentInstance = '<%=sp.getInstance()%>';
  var saveForGroup = '<%=JSPLib.ToJSValue(sp.getParameter("saveForGroup", ""))%>';
  var useRoot = '<%=JSPLib.ToJSValue(sp.getParameter("m_cUseRoot", ""))%>';
  var zone = '<%=JSPLib.ToJSValue(sp.getParameter("zone", ""))%>';
  var initDim = '<%=JSPLib.ToJSValue(sp.getParameter("initDim",""))%>';
  var m_cID = '<%=JSPLib.ToJSValue(sp.getParameter("m_cID",""))%>';
  var cmdhash = '<%=getCmdHash("portlet", request)%>';
  var cmdhash2 = '<%=getCmdHash("variant", request)%>';
  if(<%=rewriteId%>) {
    window.location.href+="&id="+'<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>'+'&variant=<%=JSPLib.ToJSValue(sp.getParameter("variant",""))%>';
  }

</script>
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("canvasLib.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("rulersLib.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/itemsObj.js")%>'></script>

<%-- componenti standard non in itemsObj.js --%>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/ChartDef.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/GridPivotDef.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/MLevelDataProviderDef.js")%>'></script>

<%-- componenti standard non in itemsObj.js --%>

 <script src='../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/properties.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("raphael.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/parserXML.js")%>'></script>

<!-- grapesjs -->
<script src='../<%=SPPrxycizer.proxycizedPath("grapesjs/grapes.min.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("grapesjs/plugin/grapesjs-preset-webpage.min.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("grapesjs/plugin/grapesjs-blocks-flexbox.min.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("grapesjs/plugin/grapesjs-custom-code.min.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("grapesjs/plugin/grapesjs-tabs.min.js")%>'></script>

<!-- grapesjs -->

 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/lib/codemirror.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/mode/xml/xml.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/mode/javascript/javascript.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/mode/css/css.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/mode/htmlmixed/htmlmixed.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/edit/matchbrackets.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/edit/closebrackets.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/comment/comment.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/comment/continuecomment.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/wrap/hardwrap.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/dialog/dialog.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/hint/show-hint.js")%>'></script>
 <!--script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/hint/xml-hint.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/hint/html-hint.js")%>'></script-->
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/search/searchcursor.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/search/search.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/selection/active-line.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/selection/mark-selection.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/selection/selection-pointer.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/search/match-highlighter.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/search/matchesonscrollbar.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/fold/foldcode.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/fold/foldgutter.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/fold/brace-fold.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/fold/xml-fold.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/mode/overlay.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/mode/simple.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/mode/multiplex.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/display/autorefresh.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/addon/scroll/annotatescrollbar.js")%>'></script>
 <script  src='../<%=SPPrxycizer.proxycizedPath("codemirror/keymap/sublime.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("jquery-ui.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/scripts/select2.min.js")%>'></script>

 <script  src='../<%=SPPrxycizer.proxycizedPath("visualweb/htmlMode.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/editor.js")%>'></script>

 <link rel="stylesheet" href="../codemirror/lib/codemirror.css">
 <link rel="stylesheet" href="../codemirror/addon/fold/foldgutter.css">
 <link rel="stylesheet" href="../codemirror/addon/dialog/dialog.css">
 <link rel="stylesheet" href="../codemirror/addon/hint/show-hint.css">
 <link rel="stylesheet" href="../codemirror/addon/search/matchesonscrollbar.css">
 <link rel="stylesheet" href="../codemirror/theme/ambiance.css">
 <link rel="stylesheet" href="../codemirror/theme/blackboard.css">
 <link rel="stylesheet" href="../codemirror/theme/neat.css">
 <link rel="stylesheet" href="../codemirror/theme/elegant.css">
 <link rel="stylesheet" href="../codemirror/theme/erlang-dark.css">
 <link rel="stylesheet" href="../codemirror/theme/lesser-dark.css">
 <link rel="stylesheet" href="../codemirror/theme/night.css">
 <link rel="stylesheet" href="../codemirror/theme/monokai.css">
 <link rel="stylesheet" href="../codemirror/theme/cobalt.css">
 <link rel="stylesheet" href="../codemirror/theme/eclipse.css">
 <link rel="stylesheet" href="../codemirror/theme/midnight.css">
 <link rel="stylesheet" href="../codemirror/theme/solarized.css">
 <link rel="stylesheet" href="../codemirror/theme/rubyblue.css">
 <link rel="stylesheet" href="../codemirror/theme/twilight.css">
 <link rel="stylesheet" href="../codemirror/theme/vibrant-ink.css">
 <link rel="stylesheet" href="../codemirror/theme/xq-dark.css">
 <link rel="stylesheet" href="../codemirror/theme/xq-light.css">

 <link type="text/css" rel="stylesheet" href="../grapesjs/css/grapes.min.css">
 <link type="text/css" rel="stylesheet" href="../portalstudio/editor.css">
 <link rel="stylesheet" href="editItemEvent.css" >
 <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
 <link type="text/css" rel="stylesheet" href="../properties.css">
 <link type="text/css" rel="stylesheet" href="portleteditor.css">
 <link rel="stylesheet" href="../portalstudio/nanoScrollerMT.css" />
 <link type="text/css" rel="stylesheet" href="itemsObj.css">
 <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
 <link type="text/css" rel="stylesheet" href="../<%=sp.getTheme()%>/portalstudio.css">
 <link rel="stylesheet" type="text/css" href="../Notimoo.css" />

 <link rel="shortcut icon" href="../portalstudio/images/sp.ico" />
</head>
<body onLoad="doLoad(event,
   '<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>',
   '<%=sp.getSkin()%>',<%=sp.getParameter("frontendport","0")%>,
   '<%=JSPLib.ToJSValue(sp.getParameter("variant",""))%>',
   '<%=JSPLib.ToJSValue(sp.getParameter("createAltInterfaceFor",""))%>',
   (initDim ? JSON.parse(initDim) : null)
   );" onkeydown="manageItems(event)"  onkeyup="window.setProperties(event);">
  <div id="toolbar" class="droppable horizontal"></div>

	<div id="o_line"><p></p></div>
	<div id="properties"></div>
  <div id="gadgets_pane" style="display:block">
    <div id="gadgets_panerightbar" class="" title="Toggle Form Properties"><div id="gadgets_openclose"></div></div>
    <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
      <div class="text">&nbsp;Form Properties</div>
      <a  title="Toggle Form Properties" id="formproperties-toggler" class="gadgets_pane_toggler opened" href="javascript:void(0)"></a>
      <a id="formproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id='formproperties' ></div>
    </div>

    <!-- Div Search -->
    <div id="searchpropertiesTitle" class="gadgetlistTitle" for="searchproperties">
      <div class="text">&nbsp;Search</div>
      <a id="search-toggler" class="gadgets_pane_toggler opened" title="Toggle search" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div id="searchnav" class="gadgets_pane_item">
      <div id="searchproperties" class="gadgets_pane_properties"></div>
      <div id="findList"></div>
    </div>

 <!--   <div id="highlightSearchDiv" style="display:none">
      <div id="searchnavr" class="gadgets_pane_item">
        <div id="resultproperties" style="height:100%;" class="pseditorprop"></div>
        <div id="infosSearch" class="gadgetlistTitle" style="border-top:0px;"></div>
      </div>
    </div> -->
  </div>
  <!--div disegnatore -->
  <div id="canvas" onMouseDown="beginDragSelection(event)" ondragstart="noDefaultDrag(event)"  onselectstart="noDefaultDrag(event)" >
    <div id="v_line"><p></p></div>
    <div id="layoutSteps" onmousedown='event.stopPropagation()'></div>
    <div id="h_ruler">
      <div id="h_rulerc" onselectstart='noDefaultDrag(event)'></div>
    </div>
    <div id="v_ruler">
      <div id="v_rulerc" onselectstart='noDefaultDrag(event)'></div>
    </div>
    <div id='backcanvasBorder'></div>
    <div id="backcanvas" onselectstart="noDefaultDrag(event)" data-transfer-accept='canvas_item'>
      <svg id="canvas-grid" zoomAndPan="disable" currentscale="1" xmlns="http://www.w3.org/2000/svg" version="1.2" width="1" height="1" style=''>
       <pattern id="grid-pattern" patternUnits="userSpaceOnUse" x="0" y="0" width="100" height="100">
       <g id="sharp" transform="translate(-0.5,-0.5)">
       <line class="lineH" x1="0" x2="100" y1="20" y2="20" stroke="#eee" stroke-width="1"></line>
       <line class="lineH" x1="0" x2="100" y1="40" y2="40" stroke="#eee" stroke-width="1"></line>
       <line class="lineH" x1="0" x2="100" y1="60" y2="60" stroke="#eee" stroke-width="1"></line>
       <line class="lineH" x1="0" x2="100" y1="80" y2="80" stroke="#eee" stroke-width="1"></line>
       <line class="lineV" x1="20" x2="20" y1="0" y2="100" stroke="#eee" stroke-width="1"></line>
       <line class="lineV" x1="40" x2="40" y1="0" y2="100" stroke="#eee" stroke-width="1"></line>
       <line class="lineV" x1="60" x2="60" y1="0" y2="100" stroke="#eee" stroke-width="1"></line>
       <line class="lineV" x1="80" x2="80" y1="0" y2="100" stroke="#eee" stroke-width="1"></line>
       <line class="lineV" x1="100" x2="100" y1="0" y2="100" stroke="#e1e1e1" stroke-width="1"></line>
       <line class="lineH" x1="0" x2="100" y1="100" y2="100" stroke="#e1e1e1" stroke-width="1"></line>
       </g>
       </pattern>
       <rect id="grid" fill="url(#grid-pattern)" width="1" height="1"></rect>
       </svg>
			<div id="handler" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)" onMouseDown="cancelEvent(event)"></div>
			<div id="canvasitems" onMouseDown="cancelEvent(event)"></div>
			<div id="drag" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)" ><div  onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)" id="dragcontent"></div></div>
			<div id="canvashandlers" tabindex="0"></div>
    </div>
  <!-- blocknotes per gli eventi di trascinamento del mouse-->
  <!--<textarea id="bn" rows="10" cols="30" style="top:500px;left:500px;z-index:101;position:absolute;height:600px;width:600px;"></textarea>-->
	</div>
  <div id="htmleditor">
    <div id="html_toolbar">
      <div class='float_left topbar_padding' style='margin-left: 30px; display: flex;'>
        <label for="variant_container">Variants&nbsp;</label>
        <select id="variant_container"></select>
        <div id="add_variant" class="title_btn" icon-data="&#xebeb;" title="Add new empty variant."> </div>
        <div id="addcopy_variant" class="title_btn" icon-data="&#xf629;" title="Add variant with base html code."> </div>
        <div id="remove_variant" class="title_btn" icon-data="&#xf041;" title="Remove current variant.">  </div>
      </div>
      <div class='float_right topbar_padding visible_items_select' >
        <label for="id_label_single">Visible Ctrl</label>
        <select id="visible_ctrl_combo" data-allow-clear="true">
          <option selected>-</option>
        </select>
      </div>
      <div class='float_right topbar_padding hidden_items_select' >
        <label for="id_label_single">Logic Ctrl</label>
        <select id="hidden_ctrl_combo">
        <option selected>-</option>
        </select>
      </div>
      <div class='float_right topbar_padding' >
        <a id="toolbar_style" class="title_btn" href="javascript:void(0)" title='Style'></a>
        <div id="opt_pane">
          <div id="opt_pane_wrapper">
            <div id="opt_pane_content">
              <label for="theme-choise">Style: </label>
              <br />
              <select  id="theme" title="Select favorite theme">
                <option  value="ambiance" label="Ambiance" />
                <option  value="blackboard" label="Blackboard" />
                <option  value="cobalt" label="Cobalt" />
                <option  value="eclipse" label="Eclipse" />
                <option  value="elegant" label="Elegant" />
                <option  value="erlang-dark" label="Erlang-dark" />
                <option  value="lesser-dark" label="Lesser-dark" />
                <option  value="default" label="Light" />
                <option  value="midnight" label="Midnight" />
                <option  value="monokai" label="Monokai" />
                <option  value="neat" label="Neat" />
                <option  value="night" label="Night" />
                <option  value="rubyblue" label="Rubyblue" />
                <option  value="solarized" label="Solarized" />
                <option  value="twilight" label="Twilight" />
                <option  value="vibrant-ink" label="Vibrant-ink" />
                <option  value="xq-dark" label="Xq-dark" />
                <option  value="xq-light" label="Xq-light" />
              </select>
              <br />
              <label id="slider">Font size: </label>
              <br />
              <div style="padding:5px;">
                <input type="range" id="fontSlider" name="volume" min="8" max="35" />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class='float_right topbar_padding'>
        <a id="toolbar_help" class="title_btn" href="javascript:void(0)" title='Help'>
        </a>
          <div id='helpkeys_content' class='small'>
            <table cellpadding="5" border="0"><tbody>
              <tr><td>Search</td><td align="right" class="keys" nowrap>Ctrl-F</td></tr>
              <tr><td>Replace</td><td align="right" class="keys" nowrap>Ctrl-R</td></tr>
              <tr><td>Find Next</td><td align="right" class="keys" nowrap>F3</td></tr>
              <tr><td>Find Prev</td><td align="right" class="keys" nowrap>Shift-F3</td></tr>
              <tr><td>Toggle bookmark</td><td align="right" class="keys" nowrap>Ctrl-F2</td></tr>
              <tr><td>Next bookmark</td><td align="right" class="keys" nowrap>F2</td></tr>
              <tr><td>Prev bookmark</td><td align="right" class="keys" nowrap>Shift-F2</td></tr>
              <tr><td>Add/Remove Comment</td><td align="right" class="keys" nowrap>Ctrl-Q</td></tr>
              <tr><td>Save All</td><td align="right" class="keys" nowrap>Ctrl-S</td></tr>
            </tbody></table>
        </div>
      </div>
      <div class='float_right topbar_padding' >
        <a id="toolbar_search" class="title_btn" href="javascript:void(0)" title='Search'></a>
      </div>
    </div>
    <div id="htmleditor_title"></div>
    <div id='editor'></div>
  </div>

  <div id="gjs"></div>

	<div id="FileToolbar"></div>

  <%@ include file="../portalstudio/preview.html" %>

  <div id='i_logicview_wrapper'> <!--RGBA(20,18,190,0.6)  --->
    <iframe allowtransparency="true" frameborder="0" toResize='no' id='i_logicview' name='i_logicview'></iframe>
  </div>
</body>
 <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</html>
