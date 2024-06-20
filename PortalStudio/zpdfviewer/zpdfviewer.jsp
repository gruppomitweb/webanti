<!DOCTYPE html>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %>
<%@ page import="com.zucchetti.SPBridge.*" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
Sitepainter sp=new Sitepainter(request);
  if(sp.CanAccess("SPPDFViewer")) {
%>

<html class="zPdfViewer">
  <head>
    <title>zPDF Viewer - Sitepainter Infinity Portalstudio</title>
    <style>
      input.noteditable, textarea.noteditable {
        background-color: transparent;
      }
      /* ----------- SCROLLBAR PERSONALIZZATA ----------- */
      ::-webkit-scrollbar-track {
        background-color: #C0C0C0;
      }
      ::-webkit-scrollbar {
        width: 6px;
        background-color: #C0C0C0;
      }
      ::-webkit-scrollbar-thumb {
        background-color: rgba(0,0,0,.7);
      }
    </style>
    <link rel="stylesheet" type="text/css" href="../psTooltip.css">
    <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
    <link rel="stylesheet" type="text/css" href="../<%=sp.getTheme()%>/portalstudio.css" >
    <link rel="stylesheet" type="text/css" href="../<%=sp.getTheme()%>/formPage.css" >
    <link rel="stylesheet" type="text/css" href="../<%=sp.getTheme()%>/zpdfviewer.css" >
    <link rel="stylesheet" type="text/css" href="../ztassistant.css" >

    <link rel="stylesheet" type="text/css" href="../fonts/DejaVuSans.css" >
    <link rel="stylesheet" type="text/css" href="../fonts/DejaVuSansCondensed.css" >
    <link rel="stylesheet" type="text/css" href="../fonts/DejaVuSansMono.css" >
    <link rel="stylesheet" type="text/css" href="../fonts/DejaVuSerif.css" >
    <link rel="stylesheet" type="text/css" href="../fonts/DejaVuSerifCondensed.css" >
    <link rel="stylesheet" type="text/css" href="../fonts/OpenSans.css" >

    <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("canvasLib.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("propertiesObj.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("zpdfviewer/itemsObj.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("PortalCommonJS.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("xmllib.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("zpdfviewer/PluginDetect.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("Notimoo.js")%>'></script>
	  <script src='../<%=SPPrxycizer.proxycizedPath("codemirror/lib/codemirror.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/editor.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("hammer.min.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("psTooltip.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("ZtAssistant.js")%>'></script>


    <script>
      var modebook = <%=sp.getParameter("modebook",true)%>;
      var modecatalog = <%=sp.getParameter("modecatalog",false)%>;
      var gotoPage = <%=sp.getParameter("page",1)%>;
      var canprint = <%=sp.getParameter("canprint",true)%>;
      var candownload = <%=sp.getParameter("candownload",true)%>;
      var scafile = '<%=JSPLib.ToJSValue(sp.getParameter("scafile",""))%>';
      var mrpfile = '<%=JSPLib.ToJSValue(sp.getParameter("mrpfile",""))%>';
      var canaddstamp = <%=sp.getParameter("canaddstamp",false)%>;
      var izoom = <%=sp.getParameter("zoom",100)%>;
      var hideversion = <%=sp.getParameter("hideversion",false)%>;
      var modelight = '<%=JSPLib.ToJSValue(sp.getParameter("modelight",""))%>'; //deprecated --- canchangeviewmode
      var canchangeviewmode = <%=sp.getParameter("canchangeviewmode",false)%>;
      var boviewer = <%=sp.getParameter("boviewer",false)%>;
      var mversion = '7.0.1';
      var canmodpages = <%=sp.getParameter("canmodpages",false)%>;
      var printdownall = <%=sp.getParameter("printdownall",false)%>;
      var mkey = '<%=JSPLib.ToJSValue(sp.getParameter("mkey",""))%>';
      var downloadname = '<%=JSPLib.ToJSValue(sp.getParameter("downloadname",""))%>';
      var compiledXML = '<%=JSPLib.ToJSValue(sp.getParameter("compiledXML",""))%>';
      var minimalMode = '<%=JSPLib.ToJSValue(sp.getParameter("minimalMode",""))%>'; //deprecated --- canremove
      var canremove = <%=sp.getParameter("canremove",false)%>;
      var cansave = <%=sp.getParameter("cansave",false)%>;
      var canupload = <%=sp.getParameter("canupload",true)%>;
      var cansearch = <%=sp.getParameter("cansearch",false)%>;
      var ignoreInnerMrp = <%=sp.getParameter("ignoreInnerMrp",false)%>;
      var signkey = '<%=JSPLib.ToJSValue(sp.getParameter("signkey",""))%>';
      var signgroup = '<%=JSPLib.ToJSValue(sp.getParameter("signgroup",""))%>';
      var fieldgroup = '<%=JSPLib.ToJSValue(sp.getParameter("fieldgroup",""))%>';
      var UsePTitle = <%=sp.getParameter("UsePTitle",false)%>;
      var PCtrlName = '<%=JSPLib.ToJSValue(sp.getParameter("PCtrlName",""))%>';
      var PPortletID = '<%=JSPLib.ToJSValue(sp.getParameter("PPortletID",""))%>';
      var file = '<%=JSPLib.ToJSValue(sp.getParameter("file",""))%>';
      var fileCss = '<%=JSPLib.ToJSValue(sp.getParameter("fileCss",""))%>';
      var title = '<%=JSPLib.ToJSValue(sp.getParameter("title",""))%>';
      var m_cDecoration = <%=sp.getParameter("enabletoolbar", false)%>;
      var m_cAssistant = <%=sp.getParameter("enableassistant",true)%>;
      var m_cAssistantAutoExec = <%=sp.getParameter("assistantautoexec",true)%>;
      var signdesc= '<%=JSPLib.ToJSValue(sp.getParameter("signdesc",""))%>';
      var signgrouplist= '<%=JSPLib.ToJSValue(sp.getParameter("signgrouplist",""))%>';
      var signgrouplistkeys= '<%=JSPLib.ToJSValue(sp.getParameter("signgrouplistkeys",""))%>';
      var confirmstamp = <%=sp.getParameter("confirmstamp",false)%>;

      var m_cLabelAddSignature= '<%=JSPLib.ToJSValue(sp.getParameter("labelAddSignature",""))%>';
      var m_cLabelRemSignature= '<%=JSPLib.ToJSValue(sp.getParameter("labelRemSignature",""))%>';
      var m_cLabelViewMode= '<%=JSPLib.ToJSValue(sp.getParameter("labelViewMode",""))%>';
      var m_cLabelRemDocument= '<%=JSPLib.ToJSValue(sp.getParameter("labelRemDocument",""))%>';

      var MSG_ZPDF_TRANSLATE = {}
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_BACK'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_BACK"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ASSISTANT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ASSISTANT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_VIEWMODE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_VIEWMODE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ADD_SIGNATUREMARK'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ADD_SIGNATUREMARK"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_REMOVE_SIGNATUREMARK'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_REMOVE_SIGNATUREMARK"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_REMOVE_DOCUMENT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_REMOVE_DOCUMENT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_REMOVE_PAGE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_REMOVE_PAGE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_UNDO_REMOVE_PAGE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_UNDO_REMOVE_PAGE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SCAN_DOCUMENT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SCAN_DOCUMENT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SAVE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SAVE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_PREVIOUS_PAGE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_PREVIOUS_PAGE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_GOTOPAGE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_GOTOPAGE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_NEXT_PAGE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_NEXT_PAGE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ZOOM_IN'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ZOOM_IN"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ZOOM_OUT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ZOOM_OUT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_PRINT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_PRINT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_DOWNLOAD'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_DOWNLOAD"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ERROR_TITLE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ERROR_TITLE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_NOTIFICATION_TITLE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_NOTIFICATION_TITLE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_NOTIFICATION_DROP'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_NOTIFICATION_DROP"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ERROR_REQUIRED'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ERROR_REQUIRED"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ERROR_INVALID_FORMAT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ERROR_INVALID_FORMAT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_FIELD'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_FIELD"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ONPAGE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ONPAGE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ERROR_LOADING'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ERROR_LOADING"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_NO_DOCUMENT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_NO_DOCUMENT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_NO_WORDS'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH_NO_WORDS"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ZOOM_FIT_IN'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ZOOM_FIT_IN"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_ZOOM_FIT_OUT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_ZOOM_FIT_OUT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_TEXT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH_TEXT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_CASE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH_CASE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_WHOLE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH_WHOLE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_PREVIOUS'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH_PREVIOUS"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_NEXT'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH_NEXT"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_CLOSE'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SEARCH_CLOSE"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_SIGNMARK_DESC'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_SIGNMARK_DESC"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_EDIT_SIGNMARK'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_EDIT_SIGNMARK"))%>';
      MSG_ZPDF_TRANSLATE['MSG_ZPDF_CONFIRM_SIGNMARK'] = '<%=sp.translate(JSPLib.ToHTML("MSG_ZPDF_CONFIRM_SIGNMARK"))%>';

      if( Empty(signdesc) ) {
        signdesc = MSG_ZPDF_TRANSLATE['MSG_ZPDF_SIGNMARK_DESC'];
      }
      if( !Empty(m_cLabelViewMode) ) {
        MSG_ZPDF_TRANSLATE['MSG_ZPDF_VIEWMODE'] = m_cLabelViewMode;
      }
      if( !Empty(m_cLabelAddSignature) ) {
        MSG_ZPDF_TRANSLATE['MSG_ZPDF_ADD_SIGNATUREMARK'] = m_cLabelAddSignature;
      }
      if( !Empty(m_cLabelRemSignature) ) {
        MSG_ZPDF_TRANSLATE['MSG_ZPDF_REMOVE_SIGNATUREMARK'] = m_cLabelRemSignature;
      }
      if( !Empty(m_cLabelRemDocument) ) {
        MSG_ZPDF_TRANSLATE['MSG_ZPDF_REMOVE_DOCUMENT'] = m_cLabelRemDocument;
      }
    </script>

    <script src='../<%=SPPrxycizer.proxycizedPath("zpdfviewer/jsep.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("zpdfviewer/zAform.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("zpdfviewer/zpdfviewer.js")%>'></script>

  </head>

  <body onLoad="doLoad(event);" onResize="resizeWindowX(event,false)" onkeydown="zManageItems(event)">
    <span id="mversion" class="hide"></span>
    <div id="loading" class="loading spModalLayer" style="z-index: 999998"></div>
    <div id="Iframe0_DIV" style="font-size:1px;line-height:0;left:0px;top:0px;display:none;width:0px;height:0px"></div>
    <div id="gadgets_header" class="hide">
      <div id="IAssistant" class="fbtn hide" onclick="EnableAssistant()" title='MSG_ZPDF_ASSISTANT'></div>
      <div id="IMenu" class="fbtn hide">
        <div id='IMenu_SPToolbar' class='disable-selection ctrl_sptoolbar_container sptoolbar'>
          <div id='IMenu_SPToolbar_listButtons' class='sptoolbar_listButtons'></div>
          <div id='IMenu_SPToolbar_openMenuHandlerDiv' class='sptoolbar_openMenuHandlerDiv'>
          <a id='IMenu_SPToolbar_openMenuHandlerImg' class='sptoolbar_3dots_handler'></a>
          </div>
        </div>
      </div>
    </div>
    <div id="PortletTitle" style="left:0px;top:0px;display:none;position:relative;z-index:999999">
      <%
        if(sp.getParameter("UsePTitle",false) == false){
          out.flush();
          com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-system/zpdfviewer_title_portlet.jsp",true);
        }
      %>
    </div>
    <div id="toolbar" class="toolbar" style="display:none">
      <div class="half-column">
        <ul id="objList" class="objList" style="font-family:inherit;font-size:12px">
          <li class="zPdfIcon" id="bcloselayer" onclick="closelayer()" title="MSG_ZPDF_BACK" style="padding-right:12px">
            <div class="form_title_toolbar_item form_title_toolbar_iconLabel_item" style="margin:0px">
              <span id="backBtn" class="zPdfIcon">Back</span>
              <span class="zPdfIcon left"></span>
            </div>
          </li>
          <li id="AssistantBtn" title="MSG_ZPDF_ASSISTANT" >
            <span  id="bassistant" onclick="EnableAssistant();" class="zPdfIcon assistant"></span>
          </li>
          <li id="viewMode" title="MSG_ZPDF_VIEWMODE">
            <span onclick="changeViewMode();" class="zPdfIcon viewMode onepage"></span>
          </li>
          <li id="bsign" title="MSG_ZPDF_ADD_SIGNATUREMARK">
            <span id="bsigna" onclick="SignMarkDoc();" class="zPdfIcon validate"></span>
          </li>
          <li id="brsign" title="MSG_ZPDF_REMOVE_SIGNATUREMARK">
            <span id="brsigna" onclick="RemSignMarkDoc();" class="zPdfIcon erase"></span>
          </li>
          <li id="bcdoc" title="MSG_ZPDF_REMOVE_DOCUMENT">
            <span id="bcdoca" onclick="RemoveDoc();" class="zPdfIcon delete"></span>
          </li>
          <li id="bcpage" title="MSG_ZPDF_REMOVE_PAGE">
            <span id="bcpagea" onclick="RemovePage();" class="zPdfIcon removepage"></span>
          </li>
          <li id="bapage" title="MES_UNDO_REMOVE_PAGE">
            <span id="bapagea" onclick="AbilitePage();" class="zPdfIcon removepage smallundo"></span>
          </li>
          <li id="bscan" title="MSG_ZPDF_SCAN_DOCUMENT">
            <span id="bscana" onclick="ScanDoc();" class="zPdfIcon scan"></span>
          </li>
          <li id="SaveBtn" title="MSG_ZPDF_SAVE" >
            <span  id="bsavea" onclick="SaveCompilation();" class="zPdfIcon save"></span>
          </li>
          <li id="TSeparator1" class="separator"></li>
        </ul>
      </div>
      <div class="half-column">
        <ul id="objList1" class="objList hide" style="font-family:inherit;font-size:12px">
          <li id="zoomview" title="Select Zoom">
            <select id="zoombox" style="font-family:inherit;font-size:inherit" name="zoombox" onchange="zoomindex=this.selectedIndex;zoom(this.options[this.selectedIndex].value);">
              <option value="50">50%</option>
              <option value="75">75%</option>
              <option value="100" selected>100%</option>
              <option value="125">125%</option>
              <option value="150">150%</option>
              <option value="175">175%</option>
              <option value="200">200%</option>
              <option value="225">225%</option>
              <option value="250">250%</option>
              <!-- <option value="275">275%</option>
              <option value="300">300%</option>
              <option value="325">325%</option>
              <option value="350">350%</option>
              <option value="375">375%</option>
              <option value="400">400%</option> -->
            </select>
          </li>
          <li id="TPrevBtn" title="MSG_ZPDF_PREVIOUS_PAGE">
            <span id="prvBtn" onclick="Previous();" class="zPdfIcon arrowleft"></span>
          </li>
          <!--<li id="TPageBtn" title="Page Number">
            <input id="pagenumber" style="font-family:inherit;font-size:inherit;position:relative;" type="number" min="0" size="3" value="0" maxlength="5" onKeyDown="KeyPress(this,event)" class="pdfTextbox">
          </li>
          <li id="TOfBtn" class="footerText">
            <span>/</span>
            <span id="pagenumberMax" style="font-family:inherit;font-size:inherit;position:relative;"></span>
          </li> -->
          <li id="TGoToPageBtn" title="MSG_ZPDF_GOTOPAGE" onclick="ExecGoToPage()">
          </li>
          <li id="TNextBtn" title="MSG_ZPDF_NEXT_PAGE" >
            <span id="nxtBtn" onclick="Next();" class="zPdfIcon arrowright"></span>
          </li>
          <li id="TZoomIn" title="MSG_ZPDF_ZOOM_IN" >
            <span id="zoomin" onclick="ZoomIn();" class="zPdfIcon arrowright"></span>
          </li>
          <li id="TZoomOut" title="MSG_ZPDF_ZOOM_OUT" >
            <span id="zoomout" onclick="ZoomOut();" class="zPdfIcon arrowright"></span>
          </li>
        </ul>
      </div>

      <div class="half-column">
        <ul id="objList2" class="objList" style="font-family:inherit;font-size:12px">
          <li id="TSeparator2" class="separator"></li>
          <li id="PrintBtn" title="MSG_ZPDF_PRINT">
            <span id="printlink" class="zPdfIcon print" onclick="onClickPrint()"></span>
            <div id="printPane" class="pane hide">
              <div class="checkboxContainer">
                <input style="font-family:inherit;font-size:inherit;vertical-align:text-bottom;margin:2px" id="printAllz" title="Select all pages" type="checkbox" onClick="setCheck(this, 'printF', 'printT')"/>
                <label style="font-family:inherit;font-size:inherit" for="printAllz">Print all</label></span>
              </div>
              <div class="inlineToolbar">
                <label style="font-family:inherit;font-size:inherit;width:40px" for="printF">From</label>
                <input style="font-family:inherit;font-size:inherit" id="printF" title="From page" type="number" min="0" size="3" value="0" maxlength="5" onKeyDown="KeyPressValidFrom(this,event)" class="pdfTextbox">
              </div>
              <div class="inlineToolbar">
                <label style="font-family:inherit;font-size:inherit;width:40px" for="printT">To</label>
                <input style="font-family:inherit;font-size:inherit" id="printT" title="To page" type="number" min="0" size="3" value="0" maxlength="5" onKeyDown="KeyPressValidTo(this,event,'printF')" class="pdfTextbox">
              </div>
              <div class="confirmContainer">
                <span id="printConfa" title="Print" class="zPdfIcon confirm" onclick="DownloadPrint();"></span>
              </div>
            </div>
          </li>
          <li id="DownloadBtn" title="MSG_ZPDF_DOWNLOAD">
            <span id="downloadlink" class="zPdfIcon download" onclick="onClickDownload()"></span>
            <div id="downloadPane" class=" pane hide">
              <div class="checkboxContainer">
                <input style="font-family:inherit;font-size:inherit;vertical-align:text-bottom;margin:2px" id="zprintAllz" title="Select all pages" type="checkbox" onClick="setCheck(this, 'zprintF', 'zprintT')"/>
                <label style="font-family:inherit;font-size:inherit" for="zprintAllz">Download all</label>
              </div>
              <div class="inlineToolbar">
                <label style="font-family:inherit;font-size:inherit;width:40px" for="zprintF">From</label>
                <input style="font-family:inherit;font-size:inherit" id="zprintF" title="From page" type="number" min="0" size="3" value="0" maxlength="5" onKeyDown="KeyPressValidFrom(this,event)" class="pdfTextbox">
              </div>
              <div class="inlineToolbar">
                <label style="font-family:inherit;font-size:inherit;width:40px" for="zprintT">To</label>
                <input style="font-family:inherit;font-size:inherit" id="zprintT" title="To page" type="number" min="0" size="3" value="0" maxlength="5" onKeyDown="KeyPressValidTo(this,event,'zprintF')" class="pdfTextbox">
              </div>
              <div class="confirmContainer">
                <span id="zprintConfa" title="Download" class="zPdfIcon confirm" onclick="DownloadPrint();"></span>
              </div>
            </div>
          </li>
          <li id="TSearchBtn" title="MSG_ZPDF_SEARCH">
          </li>
          <li id="TSignBtn" title="Signatures">
            <span id="signlink" class="zPdfIcon signature"></span>
            <div id="signPane" style="min-width:120px;" class=" pane">
              <div style="text-align:center">
                <span id="prevSign" onclick="PreviousSign();" title="Previous signature" class="zPdfIcon arrowleft"></span>
                <input style="font-family:inherit;font-size:inherit" id="signnumber" type="number" min="0" size="3" value="0" maxlength="5" onKeyDown="KeyPressSign(this,event)" class="pdfTextbox">
                <span>/</span>
                <span style="font-family:inherit;font-size:inherit" id="signnumberMax">0</span>
                <span id="nextSign" onclick="NextSign();" title="Next signature" class="zPdfIcon arrowright"></span>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>

    <div id="toolbarimgz" style="display:none;">
      <div id="toolbarimg" style="z-index:101;position:absolute;width:0px;height:0px;"></div>
      <div id="toolbarimghandlers" style="z-index:101;position:absolute;width:0px;height:0px;"></div>
    </div>
    <div id="toolbarfldz" style="position:absolute;top:80px;left:10px">
      <div id="toolbarfld" style="z-index:101;position:absolute;width:0px;height:0px;"></div>
      <div id="toolbarfldhandlers" style="z-index:101;position:absolute;width:0px;height:0px;"></div>
    </div>
    <div class="wrapper">
      <div id="properties"></div>
      <div id="backcanvas" class="backcanvas" ondragstart="noDefaultDrag(event)" onselectstart="noDefaultDrag(event)">
        <div id="canvas" class="canvas" onscroll="onScroll(event)" ondragstart="noDefaultDrag(event)" onselectstart="noDefaultDrag(event)" onClick="cancelEvent(event);clickItem(event)">
          <div id="mask"></div>

          <div id="canvasline0" style="border:0px solid #BC8080;position:absolute;left:0;width:0px;height:0px">
            <div id="itemSearch0" class="transparent" style="z-index:104;position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
            <div id="canvasitems0" style="border:0px solid;position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
            <div id="dcancelpage0" style="padding:10px;text-align:center;padding:10px;top:0px;left:0px;background-color:red;display:none;position:absolute;overflow:hidden;z-index:104;" >
              <%=sp.translate("Pagina cancellata")%>
            </div>
          </div>
          <div id="canvasline1" style="border:0px solid #BC8080;position:absolute;left:299px;width:0px;height:0px">
            <div id="itemSearch1" class="transparent" style="z-index:104;position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
            <div id="canvasitems1" style="position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
            <div id="dcancelpage1" style="padding:10px;text-align:center;font-size:20px;padding:0px;top:0px;left:0px;background-color:red;display:none;position:absolute;overflow:hidden;z-index:104;" >
              <%=sp.translate("Pagina cancellata")%>
            </div>
          </div>

          <div id="canvasline2" style="z-index:2;border:0px solid #BC8080;position:absolute;left:0;width:0px;height:0px">
            <div id="itemSearch2" class="transparent" style="z-index:104;position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
            <div id="canvasitems2" style="position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
          </div>
          <div id="canvasline3" style="z-index:2;border:0px solid #BC8080;position:absolute;left:299;width:0px;height:0px">
            <div id="itemSearch3" class="transparent" style="z-index:104;position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
            <div id="canvasitems3" style="position:absolute;left:0px;top:0px;width:0px;height:0px;font-size:1px;line-height:0"></div>
          </div>

          <div id="canvaslinks" style="border:0px solid black;position:absolute;width:100%;height:100%;"></div>
          <!-- <div id="canvashandlers" style="z-index:100;top:0px;position:absolute;width:0px;height:0px"></div> -->
          <div id="drag" style="z-index:102;border:1px solid #6FCCFF;position:absolute;visibility:hidden;width:1px;height:1px;top:1px;left:1px;"><div id="dragcontent" style="width:100%;height:100%;background:#FFFFFF;"></div></div>
        </div>
      </div>

      <div id="debug" style="z-index:120;position:absolute; top:10px; left:45px;"></div>
      <div id="saving" style="z-index:102;position:absolute;background:#000000;width:100%;left:0;top:0;display:none;text-align:center"></div>
      <div id="savingpic" style="width:126px; position:absolute;display:none;z-index:103">
          <p style="padding:0;margin:0;font-size:16px;font-weight:bold; font-family:Tahoma,Verdana,Arial;text-align:center; color:#FFFFFF;">Saving...<br /><br />
            <img src="../visualweb/images/saving.gif" alt="Saving...">
          </p>
      </div>
    </div>

    <form id="postFormTheWindow" method="post" action="" target="TheWindow">
      <input type="hidden" name="mrp" value="" />
      <input type="hidden" name="file" value="" />
      <input type="hidden" name="def" value="def" />
      <input type="hidden" name="keywords" value="" />
      <input type="hidden" name="downloadname" value="" />
      <input type="hidden" name="pdfa" value="" />
      <input type="hidden" name="editedjson" value="" />
      <input type="hidden" name="fieldgroup" value="" />
      <input type="hidden" name="editfields" value="" />
      <input type="hidden" name="signmarksupd" value="" />
      <input type="hidden" name="signmarkstoacrofields" value="" />
    </form>

    <form id="postFormname_Iframe0" method="post" action="" target="name_Iframe0">
      <input type="hidden" name="mrp" value="" />
      <input type="hidden" name="file" value="" />
      <input type="hidden" name="def" value="def" />
      <input type="hidden" name="keywords" value="" />
      <input type="hidden" name="downloadname" value="" />
      <input type="hidden" name="pdfa" value="" />
      <input type="hidden" name="editedjson" value="" />
      <input type="hidden" name="fieldgroup" value="" />
      <input type="hidden" name="editfields" value="" />
      <input type="hidden" name="signmarksupd" value="" />
      <input type="hidden" name="signmarkstoacrofields" value="" />
    </form>

    <div id="gadgets_pane" class="hide">
      <div id="formpropertiesTitle" class="gadgetlistTitle" for="formproperties">
        <div>Index Explorer</div>
        <!-- <a id="resource-toggler" class="gadgets_pane_toggler" title="Toggle Index Explorer" href="javascript:void(0)">close</a> -->
        <div class="list_border"></div>
      </div>
      <div id="contentslist" class="hide">
        <%
        if(sp.getParameter("modecatalog",false) == true){
          out.flush();
          com.zucchetti.sitepainter.Library.includeResource(request,response,"/jsp-system/SPIceCatalog_portlet.jsp?file="+sp.getParameter("file",""),true);
        }
        %>
      </div>
    </div>
    <div id="gadgets_panerightbar" class="hide zPdfIcon" title="Toggle Index Explorer"></div>

    <div id="gadgets_footer" class="gadgets_footer">
      <div id="gadgets_footer_panel" class="gadgets_footer_panel">
        <div id="gadgets_footer_pages" class="gadgets_footer_pages">
          <div id="prevBtn" class="fbtn" title="MSG_ZPDF_PREVIOUS_PAGE"></div>
          <input id="pagenumber" class="ftbtn hide" type="number" min="0" size="3" value="0" maxlength="5" onKeyDown="KeyPress(this,event)" disabled>
          <span id="pagenumberSpan" class="ftbtn"></span>
          <span id="pagenumberSep" class="ftbtn">/</span>
          <span id="pagenumberMax" class="ftbtn"></span>
          <div id="nextBtn"  class="fbtn" title="MSG_ZPDF_NEXT_PAGE"></div>
        </div>
        <div id="gadgets_footer_zoomSep" class="sepBtn"></div>
        <div id="gadgets_footer_zoom" class="gadgets_footer_zoom">
          <div id="zoomoutBtn" class="fbtn" onclick="ZoomOut();" title="MSG_ZPDF_ZOOM_OUT"></div>
          <div id="zoomfitinBtn" class="fbtn" onclick="ZoomFitIn();" title="MSG_ZPDF_ZOOM_FIT_IN"></div>
          <div id="zoomfitoutBtn" class="fbtn hide" onclick="ZoomFitOut();" title="MSG_ZPDF_ZOOM_FIT_OUT"></div>
          <div id="zoominBtn" class="fbtn" onclick="ZoomIn();" title="MSG_ZPDF_ZOOM_IN"></div>
        </div>
        <div id="gadgets_footer_searchSep" class="sepBtn hide"></div>
        <div id="gadgets_footer_search" class="gadgets_footer_search hide">
          <div id="searchBtn" class="fbtn" onclick="SearchOpt();" title="MSG_ZPDF_SEARCH"></div>
        </div>
      </div>
      <div id="gadgets_footer_panel_search" class="gadgets_footer_panel hide">
        <div id="gadgets_footer_panel_search_container">
          <input id="searchTxt" class="fmtbtn" title="MSG_ZPDF_SEARCH_TEXT" placeholder="MSG_ZPDF_SEARCH" type="text" onKeyDown="KeyPressz(this,event)" />
          <div id="searchcaseBtn" class="fmbtn disable_element" onclick="SearchCase();" title="MSG_ZPDF_SEARCH_CASE">
            <input class="hide" id="searchCase" title="Case sensitive" type="checkbox"/>
          </div>
          <div id="searchwholeBtn" class="fmbtn disable_element" onclick="SearchWhole();" title="MSG_ZPDF_SEARCH_WHOLE">
            <input class="hide" id="searchWhole" title="Case sensitive" type="checkbox"/>
          </div>
        </div>
        <span id="searchnumber" class="fmtbtn">0</span>
        <span id="searchnumberSep" class="fmtbtn">/</span>
        <span id="searchnumberMax" class="fmtbtn">0</span>
        <div id="searchprevBtn" class="fmbtn disable_element" title="MSG_ZPDF_SEARCH_PREVIOUS" onclick="PrevSearch()"></div>
        <div id="searchnextBtn" class="fmbtn disable_element" title="MSG_ZPDF_SEARCH_NEXT"  onclick="NextSearch()"></div>
        <div id="searchBtnClose" class="fmbtn" onclick="SearchOptClose();" title="MSG_ZPDF_SEARCH_CLOSE"></div>
      </div>
      <div id="gadgets_footer_open_close" class="gadgets_footer_open_close opendiv" onclick="openCloseFooter()"></div>
      <div id="gadgets_footer_inner">
        <div id="gadgets_footer_prev" class="gadgets_footer_prev" onclick="prevScrollPages()"></div>
        <div id="gadgets_footer_content" class="gadgets_footer_content"></div>
        <div id="gadgets_footer_next" class="gadgets_footer_next" onclick="nextScrollPages()" ></div>
      </div>
    </div>
  </body>
</html>

<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
