<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
Sitepainter sp=new Sitepainter(request);
  if(sp.CanAccessEditor("SPScanEditor")) {
%><!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>Scan Editor - Sitepainter Infinity Portalstudio</title>
  <script>
    var modelight = <%=sp.getParameter("modelight",false)%>; //non pi� mdl
    var mversion = "5.0";
    var avFields = '<%=JSPLib.ToJSValue(sp.getParameter("fieldsList",""))%>';
    var avFieldsbool = false;
    var openas = '<%=JSPLib.ToJSValue(sp.getParameter("openas",""))%>';
    var cmdhash = '<%=JSPLib.cmdHash("scandoc", request.getSession())%>';
    //var scafilename = '<%=sp.getParameter("scafilename","")%>'; //== openas
  </script>

  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("canvasLib.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("rulersLib.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("json.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>"></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("codemirror/lib/codemirror.js")%>'></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("visualweb/editor.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("scaneditor/itemsObj.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("visualweb/properties.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/TabsMT.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("scaneditor/scaneditor.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("scaneditor/propertiesOthers.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/pdfBckCommon.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>"></script>
  <script src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
  <link rel="shortcut icon" href="../portalstudio/images/sp.ico" />

  <link rel="stylesheet" type="text/css" href="../portalstudio/mif-tree.css">
  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link type="text/css" rel="stylesheet" href="../portalstudio/editor.css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link type="text/css" rel="stylesheet" href="../properties.css">
  <link rel="stylesheet" type="text/css" href="../portalstudio/TabsMT.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/nanoScrollerMT.css" />
  <link rel="stylesheet" type="text/css" href="../visualweb/portleteditor.css" />
  <link type="text/css" rel="stylesheet" href="../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>">
  <link rel="stylesheet" type="text/css" href="scaneditor.css" />

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

      var morphEl = new Fx.Morph($('gadgets_pane'), {
        'duration' : '300',
        link : 'cancel',
        transition : Fx.Transitions.Bounce.easeOut
      });
      var morphTlb = new Fx.Morph($('toolbar'), {
          'duration' : '300',
          link : 'cancel',
          transition : Fx.Transitions.Bounce.easeOut
      });

      $('backcanvas').addEvents({
        'mouseenter' : function (from) {
          $$('.ctrlBtn').each(function (el) {
            if (from != el)
              el.morphFx.start({
                'opacity' : 0.2
              });
          });
        },
        'mouseleave' : function (from) {
          $$('.ctrlBtn').each(function (el) {
            el.morphFx.start({
              'opacity' : 0
            });
          });
        }
      });
    });
  </script>
</head>
  <body style='overflow:hidden;' topmargin="0" leftmargin="0" onLoad="doLoad(event,'<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("mode",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("pdfsrc",""))%>')" onkeydown="manageItems(event)" onResize="resizeWindow(event)" >
    <span id="mversion" style="z-index:101"></span>
    <div id="toolbar" class="droppable horizontal"></div>

    <div id="toolbarimgz" style="display:none;width:0px;">
      <div id="toolbarimg" class="toolbarimg"></div>
      <div id="toolbarimghandlers" class="toolbarimg"></div>
    </div>

    <div id="properties"></div>
	<div id="v_line"></div>

    <div id="h_ruler" style="position:absolute;top:32px;left:45px;height:20px;width:595px;overflow:hidden;">
      <div id="h_rulerc" style="position:absolute;width:100%;height:100%"></div>
    </div>
    <div id="v_ruler" style="position:absolute;top:75px;left:10px;width:20px;height:595px;overflow:hidden;">
      <div id="v_rulerc" style="position:absolute;width:100%;height:100%;"></div>
    </div>

    <div id="navmenu_tabcontainer">
      <div class="tab_wrapper">
        <ul id="scan_page_list">
        </ul>
      </div>
    </div>
    <div id="backcanvas" ondragstart="noDefaultDrag(event)" onselectstart="noDefaultDrag(event)" >
      <div id="canvas" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)" onscroll="setScroll(event, this)">
        <div id="loading"></div>
        <div id="scan_page_frame"></div>
        <div id="mask"></div>
        <div id="canvasitems"></div>
        <div id="canvashandlers"></div>
        <div id="canvaslinks"></div>
        <div id="drag" style="overflow:hidden;z-index:102;border:1px solid #9CC58A;position:absolute;visibility:hidden;width:0px;height:0px;top:1px;left:1px;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)" >
        <div id="dragcontent" style="width:100%;height:100%;overflow:hidden;background:#FFFFFF;z-index:1999;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)"></div>
        </div>
      </div>
    </div>

    <div id="gadgets_pane" style="display:none">
      <div id="gadgets_panerightbar" class="" title="Toggle Scan Fields Explorer">
        <div id="gadgets_openclose"></div>
      </div>
      <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
        <div class="text">&nbsp;ScanDoc Properties</div>
        <a id="fomrresource-toggler" class="gadgets_pane_toggler" title="Toggle scandoc explorer" href="javascript:void(0)"></a>
        <a id="formproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()"></a>
        <div class="list_border"></div>
      </div>
      <div class="gadgets_pane_item">
        <div id="formproperties" style="height:100%"></div>
      </div>
      <div class="list_border"></div>
      <div id="legend_title" class="gadgetlistTitle" for="legend_items">
        <div class="text">&nbsp;Legend</div>
        <div class="list_border"></div>
      </div>
      <div class="gadgets_pane_item">
        <div id ="legend_items">
          <div class="legend_container">
            <div class="legend_txt">used</div>
            <div class="transparent-fieldused" style="float:left;width:20px;">&nbsp;</div>
          </div>
          <div class="legend_container">
            <div class="legend_txt">not&nbsp;used</div>
            <div class="transparent-field" style="float:left;width:20px">&nbsp;</div>
          </div>
        </div>
        <br><br>
      </div>
      <div id="gadgetlistTitlePz" class="gadgetlistTitle" for="fields_container">
        <div class="text">&nbsp;Zones Explorer</div>
        <a id="zoneresource-toggler" class="gadgets_pane_toggler" title="Toggle Zones explorer" href="javascript:void(0)"></a>
        <div class="list_border"></div>
      </div>
      <div id="fields_container_items" class="gadgets_pane_item">
        <div id="fields_container" style="height:100%;">
          <div id="toolbarfldz" onscroll="removeAllFieldHandlers()">
            <div id="toolbarfld" style="z-index:101"></div>
            <div id="toolbarfldhandlers" style="z-index:101"></div>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>"></script>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
