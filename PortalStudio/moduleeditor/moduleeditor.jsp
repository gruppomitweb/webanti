<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%Sitepainter sp=new Sitepainter(request);
  if(sp.CanAccessEditor("SPModuleEditor")) {
    sp.setContentType(response);
%>

<!DOCTYPE html>

<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <title>Module Editor - Sitepainter Infinity Portalstudio</title>
  <script>
    var openas = '<%=JSPLib.ToJSValue(sp.getParameter("openas",""))%>';
    var modefieldtree = <%=sp.getParameter("fieldtree",false)%>;
    var mversion = "5.1"
    var msimplesheet = <%=sp.getParameter("simplesheet",false)%>;
    var modelight = <%=sp.getParameter("modelight",false)%>;
	  var msimplesheetqr = <%=sp.getParameter("simplesheetqr",false)%>;
    var modelightqr = <%=sp.getParameter("modelightqr",false)%>;
    var managebarcodeqr = <%=sp.getParameter("managebarcodeqr",false)%>;
    var cmdhash = '<%=JSPLib.cmdHash("module", request.getSession())%>';
  </script>

  <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("canvasLib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("rulersLib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/jscolor/jscolor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("codemirror/lib/codemirror.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/editor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("moduleeditor/itemsObj.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/properties.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("gadget_pane.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/TabsMT.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("moduleeditor/moduleeditor.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("moduleeditor/propertiesOthers.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/pdfBckCommon.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/SPToolbar.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/dragFieldObj.js")%>'></script>

  <link rel="stylesheet" type="text/css" href="../portalstudio/mif-tree.css" />
  <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
  <link type="text/css" rel="stylesheet" href="../portalstudio/editor.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/SPToolbar.css" />
  <link type="text/css" rel="stylesheet" href="../properties.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/TabsMT.css" />
  <link rel="stylesheet" type="text/css" href="../portalstudio/nanoScrollerMT.css" />
  <link rel="stylesheet" type="text/css" href="../visualweb/portleteditor.css" />
  <link type="text/css" rel="stylesheet" href='../<%=SPPrxycizer.proxycizedPath("portalstudio/portalstudioTheme.css")%>' />
  <link rel="stylesheet" type="text/css" href="moduleeditor.css" />
  <link rel="stylesheet" type="text/css" href="fieldstreeview.css" />

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

      //var plan_resize = null;
      var morphEl = new Fx.Morph($('gadgets_pane'),{ 'duration':'300', link:'cancel', transition:Fx.Transitions.Bounce.easeOut});
      var morphTlb = new Fx.Morph($('toolbar'),{ 'duration':'300', link:'cancel', transition:Fx.Transitions.Bounce.easeOut});

      $$('.ctrlBtn').each(function(el) {
        el.morphFx = new Fx.Morph(el,{'duration':200,'link':'cancel'});
        el.setStyles({'opacity':0});
        el.addEvents({
          'mouseover':function() {
            this.morphFx.start({'opacity':0.6});
            $('backcanvas').fireEvent('mouseenter',this);
          },
          'mouseout':function() {
            this.morphFx.start({'opacity':0.2});
            $('backcanvas').fireEvent('mouseleave',this);
          }
        });
      });
      $('backcanvas').addEvents({
        'mouseenter':function(from) {
          $$('.ctrlBtn').each(function(el) {
            if (from != el) {
              el.morphFx.start({'opacity':0.2});
            }
          });
        },
        'mouseleave':function(from) {
          $$('.ctrlBtn').each(function(el) {
            el.morphFx.start({'opacity':0});
          });
        }
      });
    });
  </script>

  <link rel="shortcut icon" href="../portalstudio/images/sp.ico" />
</head>
<html>
  <body style="overflow:hidden;" topmargin="0" leftmargin="0" onLoad="doLoad(event,'<%=JSPLib.ToJSValue(sp.getParameter("id",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("mode",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("pdfsrc",""))%>','<%=JSPLib.ToJSValue(sp.getParameter("fieldsrc",""))%>')" onkeydown="manageItems(event)" onkeyup="window.setProperties(event)" onResize="resizeWindow(event,true)">
    <span id="mversion" style="z-index:101"></span>
    <div id="toolbar" class="droppable horizontal"></div>

    <div id="toolbarimgz" style="display:none;">
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
        <ul id="module_page_list">
        </ul>
      </div>
    </div>
    <div id="backcanvas" ondragstart="noDefaultDrag(event)" onselectstart="noDefaultDrag(event)">
      <div id="canvas" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)" onscroll="setScroll(event, this)">
        <div id="module_page_frame"></div>
        <div id="loading"></div>
        <div id="mask"></div>
        <div id="canvasitems" onMouseDown="cancelEvent(event)"></div>
        <div id="canvashandlers"></div>
        <div id="canvaslinks"></div>
        <div id="drag" style="overflow:hidden;z-index:102;border:1px solid #9CC58A;position:absolute;visibility:hidden;width:0px;height:0px;top:1px;left:1px;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)">
          <div id="dragcontent" style="width:100%;height:100%;overflow:hidden;background:#FFFFFF;z-index:1999;" onselectstart="noDefaultDrag(event)" ondragstart="noDefaultDrag(event)"></div>
        </div>
      </div>
    </div>
    <div id="gadgets_pane" style="display:none">
      <div id="gadgets_panerightbar" class="" title="Toggle Module Editor Properties Explorer">
        <div id="gadgets_openclose"></div>
      </div>
      <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
        <div class="text">&nbsp;Module properties</div>
        <a id="formproperties-toggler" class="gadgets_pane_toggler" title="Toggle source module properties" href="javascript:void(0)"></a>
        <a id="formproperties_cApi" class="toggler_capi" title="API" href="javascript:void(0)" onclick="renderApiForm()"></a>
        <div class="list_border"></div>
      </div>
      <div class="gadgets_pane_item">
        <div id="formproperties" style="height:100%;"></div>
      </div>
      <div class="list_border"></div>
      <div id="gadgetlistTitle" class="gadgetlistTitle" for="fields_container">
        <div class="text">&nbsp;Fields Explorer</div>
        <a id="resource-toggler" class="gadgets_pane_toggler" title="Toggle Fields explorer" href="javascript:void(0)"></a>
        <div class="list_border"></div>
      </div>
      <div id="gadgetPaneFields" class="gadgets_pane_item">
        <div id="fields_container">
          <div id="toolbarfldz" onscroll="removeAllFieldHandlers()">
            <div id="toolbarfld" style="z-index:101"></div>
            <div id="toolbarfldhandlers" style="z-index:101"></div>
          </div>
          <div id="toolbarfldtree" style="display:none">
            <div class="list_border"></div>
          </div>
        </div>
      </div>
      <!-- Div Search -->
      <div id="gadgetPaneLast" class="gadgetlistTitle" for="searchproperties">
        <div class="text">&nbsp;Search</div>
        <a id="search-toggler" class="gadgets_pane_toggler opened" title="Toggle search" href="javascript:void(0)"></a>
        <div class="list_border"></div>
      </div>
      <div id="searchnav" class="gadgets_pane_item">
        <div id="searchproperties" class="gadgets_pane_properties"></div>
        <div id="findList"></div>
      </div>

    </div>
    <div id="i_preview_wrapper">
    <div id="i_preview_title">
      <div id="i_preview_close_button" onclick="togglePreview()"></div>
      <!-- <div id="i_preview_parameters_button" onclick="toggleFieldsConfiguration()"></div> -->
      <div>&nbsp;&nbsp; Preview &nbsp;&nbsp;</div>
    </div>
    <iframe allowtransparency="true" frameborder="0" toResize="no" id="i_preview" name="i_preview"></iframe>
  <!--<div id='parameters_wrapper'>Parameters List</div>-->
  </div>
  </body>
  <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/psHelp.js")%>'></script>
</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
