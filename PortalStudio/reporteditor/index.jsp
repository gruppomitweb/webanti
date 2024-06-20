<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  if(sp.CanAccessEditor("PortalStudio") || sp.CanModifyOwnReport()) {
  sp.setContentType(response);
%><!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>Report Editor - Sitepainter Infinity Portalstudio</title>
  <script>
    var mversion = "5.2"
    var modelight = <%=sp.getParameter("modelight",false)%>;
    var openas = '<%=JSPLib.ToJSValue(sp.getParameter("openas",""))%>';
    var defaultEncoding = '<%= com.zucchetti.sitepainter.Library.m_cResponseEncoding %>';
    var nodialog = false;
    var cmdhash = '<%=JSPLib.cmdHash("report", request.getSession())%>';
  </script>
  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("canvasLib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("rulersLib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("codemirror/lib/codemirror.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/editor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/mif.tree.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/parserXML.js")%>'></script>

  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/navigator.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/itemsObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/reportObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/altqueryObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/autocoverObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/barcode2dObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/barcodeObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/breakpageObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/htmlsectionObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/boxObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/chartObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/exprObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/groupObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/headerObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/imageObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/labelObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/sectionObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/sectboObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/variableObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/signmarkObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/signsvgObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/objects/tinyhtmlObj.js")%>'></script>

  <script src='../<%=SPPrxycizer.proxycizedPath("SPReportMask.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/properties.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/TabsMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/editor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("reporteditor/editor_others.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/dragFieldObj.js")%>'></script>

  <link rel="stylesheet" type="text/css" href="../portalstudio/mif-tree.css" />
  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link type="text/css" rel="stylesheet" href="../portalstudio/editor.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link type="text/css" rel="stylesheet" href="../properties.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/TabsMT.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/nanoScrollerMT.css" />
  <link rel="stylesheet" type="text/css" href="../visualweb/portleteditor.css" />
  <link type="text/css" rel="stylesheet" href="../classeditor/fontList.css" />
  <link type="text/css" rel="stylesheet" href='../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>' />

  <link rel="stylesheet" type="text/css" href="reporteditor.css">

  <script type="text/javascript">
    window.addEvent('domready', function() {
      var fxMask = new Fx.Tween($('mask'),{duration: '400'});
      $('mask').fx = fxMask;
      $('mask').setStyle('opacity','0');
      $('dragcontent').setStyle('opacity','0.2');
      $('dragcontent').set('tween',{
        duration: 500,
        link: 'cancel'
      });
      $('drag').set('tween',{
        duration: 500,
        link: 'cancel'
      });

      var plan_resize = null;

      $('backcanvas').addEvents({
        'mouseenter':function(from){
          $$('.ctrlBtn').each(function(el){
            if(from != el)
              el.morphFx.start({'opacity':0.2});
          });
        },
        'mouseleave':function(from){
          $$('.ctrlBtn').each(function(el){
              el.morphFx.start({'opacity':0});
          });
        }
      });
    });
  </script>
</head>

<body onLoad="doLoad(event,'<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("mode",""))%>',<%=sp.getParameter("frontendport","0")%>,'<%=JSPLib.ToJSValue(sp.getParameter("custom",""))%>')" onkeydown="if(!nodialog) manageItems(event)" onkeyup="window.setProperties(event)" onscroll="setScroll(event, this)" onResize="resizeWindow(event,true)">
  <span id="mversion" style="z-index:101"></span>
  <div id="toolbar" class="horizontal droppable"> </div>
  <div id="v_line"></div>
  <div id="h_ruler">
    <div id="h_rulerc"></div>
    <div id="v_lineA4PortraitRef" class="unselectable canvas_linef" style="top:25px;left:793px;position:absolute;">A4/Portrait</div>
    <div id="v_lineLetterPortraitRef" class="unselectable canvas_linef" style="top:25px;left:812px;position:absolute;">Letter/Portrait</div>
    <div id="v_lineLegalPortraitRef" class="unselectable canvas_linef" style="top:25px;left:812px;position:absolute;">Legal/Portrait</div>
    <div id="v_lineLetterLandscapeRef" class="unselectable canvas_linef" style="top:25px;left:1054px;position:absolute">Letter/Landscape</div>
    <div id="v_lineA4LandscapeRef" class="unselectable canvas_linef" style="top:25px;left:1122px;position:absolute">A4/Landscape</div>
    <div id="v_lineA3PortraitRef" class="unselectable canvas_linef" style="top:25px;left:1122px;position:absolute">A3/Portrait</div>
    <div id="v_lineLegalLandscapeRef" class="unselectable canvas_linef" style="top:25px;left:1345px;position:absolute">Legal/Landscape</div>
    <div id="v_lineA3LandscapeRef" class="unselectable canvas_linef" style="top:25px;left:1587px;position:absolute">A3/Landscape</div>
    <div id="z_lineref" class="unselectable canvas_linef" style="display:none;top:25px;left:842px;position:absolute">
      Vertical&nbsp;reference
    </div>
  </div>
  <div id="v_ruler">
    <div id="v_rulerc"></div>
    <div id="spaceBarZ" class="spaceBar" style="background-color:#D5D5D5"></div>
    <div id="spaceBar" class="spaceBar" style="background-color:#00A0BD"></div>
    <div id="spaceBarZM" class="spaceBar" style="background-color:#FFFFFF"></div>
    <div id="spaceBarM" class="spaceBar" style="background-color:red"></div>
    <div id="moveBarImg1_hand" title="click to move bar line" class="moveBarImg" style="top:0px;"></div>
    <div id="moveBarImg2_hand" title="click to move bar line" class="moveBarImg" style="top:25px;"></div>
    <div id="moveBarImg1" class="circlez" title="click to move bar line" style="top:0px;"></div>
    <div id="moveBarImg2" class="circlez" title="click to move bar line" style="top:25px;"></div>
  </div>
  <div id="navmenu_tabcontainer">
    <div class="tab_wrapper">
      <ul id="report_page_list">
      </ul>
    </div>
  </div>
  <!-- div disegnatore -->
  <div id="backcanvas" onselectstart="noDefaultDrag(event)" onscroll="setScroll(event, this)">
    <div id="v_line" style="display:none;"></div>
    <div id="z_line" style="cursor:e-resize" class="unselectable canvas_line canvas_linef" onmousedown="moveLine(event,this)"></div>
    <div id="v_line1" class="unselectable canvas_line canvas_linef"></div>
    <div id="v_line2" class="unselectable canvas_line canvas_linef"></div>
    <div id="canvas" class="unselectable" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)">
      <div id="loading" style="display:none;"></div>
      <div id="bars"></div>
      <div id="report_page_frame"></div>
      <div id="mask"></div>
      <div id="canvaslinks"></div>
      <div id="canvasitems" onMouseDown="cancelEvent(event)"></div>
      <div id="drag" style="overflow:hidden;z-index:102;border:1px solid #9CC58A;position:absolute;visibility:hidden;width:1px;height:1px;top:1px;left:1px;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)">
        <div id="dragcontent" style="width:100%;height:100%;overflow:hidden;background:#FFFFFF;z-index:1999;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)"></div>
      </div>
      <div id="canvashandlers"></div>
    </div>
  </div>

  <div id="properties"></div>
  <div id="gadgets_pane" class="unselectable" style="display:none">
    <div id="gadgets_panerightbar" class="" title="Toggle Report Editor Properties Explorer"><div id="gadgets_openclose"></div></div>
    <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
      <div class="text">&nbsp;Report&nbsp;properties</div>
      <a id="resource-toggler-report" class="gadgets_pane_toggler" title="Toggle Report properties" href="javascript:void(0)"></a>
      <a id="formproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id="formproperties" class="pseditorprop" style="height:100%;"></div>
    </div>

    <div id="formpropertiesTitle1" class="gadgetlistTitle" for="bands_nav">
      <div class="text">&nbsp;Sections&nbsp;navigator</div>
      <a id="resource-toggler-report1" class="gadgets_pane_toggler" title="Toggle" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id="bands_nav" class="pseditorprop" style="height:100%;"></div>
    </div>

    <div id="formpropertiesTitle2" class="gadgetlistTitle" for="fieldsproperties">
      <div class="text">&nbsp;Fields&nbsp;Explorer</div>
      <a id="resource-toggler-report2" class="gadgets_pane_toggler" title="Toggle" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div class="gadgets_pane_item">
      <div id="fieldsproperties" class="pseditorprop" style="display:block;"></div>
    </div>
    <!-- Div Search & Replace -->
    <div id="searchpropertiesTitle" class="gadgetlistTitle" for="searchproperties">
      <div class="text">&nbsp;Search & Substitute</div>
      <a id="resource-toggler-report5" class="gadgets_pane_toggler opened" title="Toggle search" href="javascript:void(0)"></a>
      <div class="list_border"></div>
    </div>
    <div id="searchnav" class="gadgets_pane_item">
      <div id="searchproperties" style="height:100%;" class="pseditorprop"></div>
      <div id="findList"></div>
    </div>
    <div id="highlightSearchDiv" style="display:none">
      <div id="searchnavr" class="gadgets_pane_item">
        <div id="resultproperties" style="height:100%;" class="pseditorprop">
        </div>
        <div id="infosSearch" class="gadgetlistTitle" style="border-top:0px;">
        </div>
      </div>
    </div>
  <div style="display:none">
    <textarea id="translator"></textarea>
  </div>
  <span id="ruler" style="visibility:hidden;width:auto"></span>
  </div>
  <div id='i_preview_wrapper'>
    <div id='i_preview_title'>
      <div id="i_preview_close_button" onclick="togglePreview()"></div>
    </div>
    <iframe allowtransparency="true" frameborder="0" toResize='no' id='i_preview' name='i_preview'></iframe>
  </div>
  <dialog style="display:none" id="modelDialog">
    <form>
    <div>
      <label class='portalstudio_label'>Model Name</label>
      <input class= 'portalstudio_textbox' type="text" name="modelName" id="modelDialogName" tabindex=1>
      </br>
      <input class='checkbox' type="checkbox" name="overwrite" id="modelDialogOverwrite" tabindex=2>
      <label class='portalstudio_label'>Overwrite file if exists</label>
      </br>
      </br>
      <input tabindex=3 class='portalstudio_button' type='button' value='OK' id='id="modelDialogOkButton' onclick='_createModel()''>
      <input tabindex=4 class='portalstudio_button' type='button' value='Cancel' id='id="modelDialogCancelButton' onclick='_abortModel()'>
    </div>
    </form>
    </dialog>
</body>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>'></script>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
