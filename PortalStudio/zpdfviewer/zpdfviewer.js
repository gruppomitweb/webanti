/*  exported def xxpos yypos saveas isLoading ctrls lviewerNumPage searchingStatus notimooManager
    doLoad Help resizeWindowX beginScroll ZoomIn ZoomOut changeViewMode checkError
    ValidMove getPdfFileName clickItem onEvtBlurEmpty onEvtBlur handlecheckz continueDragHandler
    rgbPattern toHex Formproperties convertItemUnitZoom convertUnit convertUnitZoom
    reconvertUnit reconvertUnitZoom ReloadDoc RemoveDoc RemovePage EnablePage EnableToolbar
    KeyPress KeyPressValidFrom KeyPressValidTo closePrintPane SaveCompilation DownloadPrint
    setCheck closelayer PrevSearch NextSearch KeyPressz KeyPressSearch ZViewerUpdateToolbar
    EditBO DeleteBO SaveBO CancelBO SetZBOViewerWindow ScanDoc SignMarkDoc RemSignMarkDoc
    changeViewMode4 zoomDrag zoomFit rotateLeft rotateRight SignDoc getMinWidth GetCanAddStamp removeSignMark
    addStamp drawCanceledPage Preview elementInViewport elementInViewport2 ZViewerEnableAddSignMark ZViewerEnableRemoveSignMark
    ZViewerSetSignImage ZViewerSetSignGroupImage ZViewerPreviousSignMark ZViewerNextSignMark ExecGoToPage
    ZViewerCurrentSignMark KeyPressSign onClickPrint onClickDownload onClickSearch onEvtRadio PS_GetNumberOfPages PS_Save PS_UpdatePDF
    NextField EnableAssistant onEvtFocus _goToField PS_IsEditable PS_GetData ZBORemoveBackButton ZBOAddBackButton PS_HasAcrofields
    onEvtKeyPress onScroll openCloseFooter nextScrollPages prevScrollPages ZoomFitIn ZoomFitOut SearchOpt SearchOptClose SearchCase SearchWhole 
    editItemEvent Paste moveShadow CopyPaste selectForm zZoneNames zManageItems SetSignMarkInfo EvEditSignMark CheckUniqueSignMarkKey
    SelectSignMark onEvtCombo PS_GetSignMarksUpdated EvDeleteSignMark setShadow
 */
/*
    global Ctrl signkey signgroup mversion modebook gotoPage modecatalog scafile mrpfile
    izoom canaddstamp canupload itemsHTMLArray imgHTML compiledXML canprint minimalMode canremove
    modelight canmodpages boviewer cansave candownload downloadname PluginDetect mkey
    draggedItemIdx draggingHandlerCorner printdownall Hammer cansearch canchangeviewmode
    PPortletID PCtrlName UsePTitle TranslatePicture lastDateIsOk
    file title ignoreInnerMrp ZtAssistant MSG_ZPDF_TRANSLATE
    CheckNumWithPict GetModDecPict ApplyPictureToDate ApplyPictureToDateTime ValidNum WtH
    m_cAssistant m_cDecoration m_cAssistantAutoExec signdesc datePattern dateTimePattern
    fileCss timestamp jsep fieldgroup signgrouplistkeys signgrouplist confirmstamp
  */
var currentName = ''; // Nome del modello corrente
var def = '';
var xxpos; // for insert image dialog
var yypos;
var saveas = false;
var isLoading = false;
var w_init = 0;
var h_init = 0;
var pdfFile = '';
var page0 = -1;
var page1 = -1;
var page2 = -1;
var page3 = -1;
var maxPages = -1;
var workAreaWidth = 0,
  workAreaHeight = 0;
var currentPage = 0;
var errMsg = MSG_ZPDF_TRANSLATE['MSG_ZPDF_ERROR_LOADING'];
var rotation = 0;
var ctrls = []; // Serve per aggiunta IFrameCtrl in download del pdf.
var xmlobj1 = null;
var drawHL = false;
var nrPagesToView = 2;
var lviewerNumPage = 2;
var isSecureDoc = -1;
var isPdfA = false;
var hasAcrofields = false;
var searchingStatus = false;
var zoomindex = -1; //100
var dpMode = -1; //0 print 1 download
var Iframe0 = null;
var fileName;
var clCanvasLib = null;
var isMrpLoad = false;
var isStamp = false;
var fieldsListXml = '';
var keywords = '';
var formProp = new ZTObjects.formObj();
var workUnit = 'pt';
var newPropObj = null;
var docpageindex = 0;
var countindex = [];
countindex[docpageindex] = 0;
var myZBoViewWindow = null;
var rempages = [];
var divanglerad = 54.75 * Math.PI / 180;
var isIE = false;
var isValidDocument = false;
var nAllItems = 0;
var width = 1,
  height = 1;
var fileSignMarks;
var fileMrpDef;
var signMarksKey = [];
var signMarksGroupArray = [];
var modeInsertSign = false;
var modeSignSelect = false;
var imgcountindex = 0,
 nitem = 0;
var zTitlePortlet;
var zSPToolbar;
var zTitlePortletItems = [];
var zTitleToolBar1 = [], zTitleToolBar2 = [];
var PSCtrl = null;
var PSPortlet = null;
var jsCompileObj;
var jsUpdSignmarksObj;
var zTAssistant;
var groupChecks = {};
var groupInputs = {};
var loadScrollPage = false;
var defZoom = 100;
var _signMarks = [];
var signmarksupd = false;
var form = {};
form.class_name = '';
form.portletname = 'zpdfviewer';
form.formid = 'zpdfviewer';
form.ctrls = [];

var deftmpZ = '';
var notimooManagerZ;
var zZoneNames = null;
var calcAcrofieldsOrder;
var zAcrofieldCalculations = [];
var zAcrofieldEvents = [];
var zAcrofieldFields = [];
//var signMarksEditTimeOuts = {};
var signMarkWidth = 225;
var signMarkHeight = 80;
var signgrouplistmap = [];
var _isEditable = false;

function preDoLoad() {
  //window.addEvent('domready', function() {
    if (window.addEventListener){
      window.addEventListener("dragover", function(e){
        e = e || event;
        e.dataTransfer.effectAllowed = "none";
        e.preventDefault();
      }, false);
      window.addEventListener("drop", function(e){
        e = e || event;
        e.dataTransfer.effectAllowed = "none";
        e.preventDefault();
        try{
          notimooManagerZ.show({
            title: MSG_ZPDF_TRANSLATE['MSG_ZPDF_NOTIFICATION_TITLE'],
            message: MSG_ZPDF_TRANSLATE['MSG_ZPDF_NOTIFICATION_DROP'],
            width:200,
            height:40,
            visibleTime: 500
          });
        }
        catch(e) {}
      }, false);
    }
    if( window.attachEvent){
      window.attachEvent("ondragover",function(e){
        e = e || event;
        e.dataTransfer.effectAllowed = "none";
        e.preventDefault();
      },false);
      window.attachEvent("ondrop",function(e){
        e = e || event;
        e.dataTransfer.effectAllowed = "none";
        e.preventDefault();
      },false);
    }

    if(Ctrl("backBtn")) Ctrl("backBtn").innerHTML = MSG_ZPDF_TRANSLATE['MSG_ZPDF_BACK'];
    $('dragcontent').setStyle('opacity','0.2');
    $('dragcontent').set('tween',{
      duration: 500,
      link: 'cancel'
    });
    $('drag').set('tween',{
      duration: 500,
      link: 'cancel'
    });

    initCanvas();
    $('gadgets_pane').opened = false;

    var resizenano = function(){
      $('contentslist').nanoScrollerMT();
    };
    $('contentslist').addEvents({'mouseover':resizenano});

    var togglePane = function(){
      var gadgets_pane_width = $('gadgets_pane').offsetWidth,
        gadgets_panerightbar_width = 0;

      if($('gadgets_pane').opened){
        document.body.setStyle('padding-left', gadgets_panerightbar_width);
        $('gadgets_pane').setStyle('left', -gadgets_pane_width);
        $('gadgets_pane').opened = false;
        $('gadgets_panerightbar').setStyle('left', 0) ;
        $('gadgets_panerightbar').classList.remove("opened");
      } else{
        document.body.setStyle('padding-left', gadgets_pane_width + gadgets_panerightbar_width);
        $('gadgets_pane').setStyle('left', 0);
        $('contentslist').classList.remove("hide");
        $('gadgets_pane').opened = true;
        $('gadgets_panerightbar').setStyle('left', gadgets_pane_width);
        $('gadgets_panerightbar').classList.add("opened");
      }
    };

    $('gadgets_panerightbar').addEvents({'click':togglePane});
    $('printlink').store('printlink-opened',false);
    $('downloadlink').store('downloadlink-opened',false);

    document.getElementById('objList').getChildren().each(function(el){
      el.title = _TranslateMsgTooltip(el.title);
    });
    document.getElementById('objList2').getChildren().each(function(el){
      el.title = _TranslateMsgTooltip(el.title);
    });
    document.getElementById('gadgets_footer_pages').getChildren().each(function(el){
      el.title = _TranslateMsgTooltip(el.title);
    });
    document.getElementById('gadgets_footer_zoom').getChildren().each(function(el){
      el.title = _TranslateMsgTooltip(el.title);
    });
    document.getElementById('gadgets_footer_panel_search').getChildren().each(function(el){
      el.title = _TranslateMsgTooltip(el.title);
    });
    document.getElementById('gadgets_footer_panel_search_container').getChildren().each(function(el){
      el.title = _TranslateMsgTooltip(el.title);
    });
    var el = document.getElementById('IAssistant');
    el.title = _TranslateMsgTooltip(el.title);
    el = document.getElementById('searchTxt');
    el.placeholder = _TranslateMsgTooltip(el.placeholder);
}

function doLoad(e)  {
  if( Empty(fileCss) ){
    _doLoad(e);
    return;
  }
  var src = fileCss;
  if(ZtVWeb) {
    ZtVWeb.RequireCSS (src,  _doLoad);
  }
  else {
      var l = document.createElement('link');
      l.rel = 'StyleSheet';
      l.type = 'text/css';
      l.onload = function() {
      requestAnimationFrame ( function () {
        _doLoad();
      });
      }
      l.onerror = function() {
      requestAnimationFrame ( function () {
        _doLoad();
      });
      }
      l.href = '../' + src;
      document.getElementsByTagName('head')[0].appendChild(l);
  }
}

function _doLoad(e) {
  showLoadingDiv();
  preDoLoad();
  initPainter();
  form.Ctrl = document.body;
  window[form.portletname] = form;
  notimooManagerZ = new Notimoo({
    locationVBase :  70
  });

  var s = signgrouplist.split(",");
  var v = signgrouplistkeys.split(",");
  for(var i=0; i<s.length && i<v.length; i++) {
    if( !Empty(v[i]) )
      signgrouplistmap[v[i]] = s[i];
  }

  printdownall = true; //al momento viene forzata ... finche implementazione jsp di selezione

  var mc = new Hammer.Manager(Ctrl('canvas'));
  var pan = new Hammer.Pan();
  mc.add([pan]);
  mc.on("panstart", function(e) {
    beginScroll(e);
  });
  mc.on("panend", function(e) {
    endScroll(e);
  });
  mc.on("panmove", function(e) {
    continueScroll(e);
  }); 
  
  if( window.frameElement ) {
    if ( !Empty(PPortletID) && !Empty(PCtrlName)  ) {
      if( window.parent[PPortletID] && window.parent[PPortletID][PCtrlName] ) {
         PSPortlet = window.parent[PPortletID]; 
         PSCtrl = window.parent[PPortletID][PCtrlName];
      }
    }
    window.SPTheme = window.parent.SPTheme;
  }

  index = 0;
  Ctrl('backcanvas').fade(0);

  if(!Empty(minimalMode))
    canremove = (minimalMode === 'false');
  if(!Empty(modelight))
    canchangeviewmode = (modelight === 'false');

  currentName = file;
  currentName = Strtran(currentName, '\\', '/');
  if (currentName.indexOf('/') > -1) {
    fileName = currentName.substring(currentName.lastIndexOf('/') + 1);
  } else {
    fileName = currentName;
  }

  //title
  if(Empty(title)) title = fileName;
  if (zTitlePortlet && zTitlePortlet.SetTitle)
    zTitlePortlet.SetTitle(title, true);
  else
  {
    document.title = title;
    if (Ctrl('srcform')) {
      Ctrl('srcform').value = title;
    }
  }

  //notimoo
  notimooManagerZ = new Notimoo({
    locationVBase :  (zTitlePortlet ? zTitlePortlet.height+5 : 100)
  });
  
  standalone = true;
  pdfFile = file;

  document.body.style.cursor = 'default';
  document.body.onhelp = CancelHelp;

  if(!Empty(signkey) || (!Empty(signgroup) && (signgroup != 'none'))) {
    modeInsertSign = true;
    canaddstamp = false;
    lockItems = true; //PortalCommonJS
  }

  if(!canaddstamp) {
    lockItems = true; //PortalCommonJS
  }

  Ctrl('backcanvas').setStyle('display', 'block');
  Ctrl('mversion').innerHTML = 'zPdfViewer v' + mversion;

  var viewModeIcon = document.querySelector('#viewMode span');
  if (modebook == false) {
    nrPagesToView = 1;
    viewModeIcon.classList.remove('onepage');
    viewModeIcon.classList.add('twopages');
  } else {
    viewModeIcon.classList.remove('twopages');
    viewModeIcon.classList.add('onepage');
  }

  var ctrl = Ctrl('gadgets_pane');
  if (ctrl) {
    if (modecatalog == true) {
      ctrl.classList.remove('hide');
      Ctrl('gadgets_panerightbar').classList.remove('hide');
      Ctrl('gadgets_panerightbar').fireEvent('click');
    }
  }

  setFile(file);
  w_init = parseInt(Ctrl('backcanvas').style.width);
  h_init = parseInt(Ctrl('backcanvas').style.height);
  if (maxPages > 0) {
    w_init = workAreaWidth;
    h_init = workAreaHeight;
    if (modebook == true) {
      w_init = w_init * 2;
    }
  }

  if (gotoPage > 1) {
    GoToPage('' + gotoPage);
  }

  //_innerMrp = Empty(scafile) && Empty(mrpfile) && !Empty(fileMrpDef);

  Ctrl('backcanvas').fade(1);
  if (!Empty(scafile)) {
    isMrpLoad = false;
    loadSca(scafile);
    writeHTML();
  } else if (!Empty(mrpfile)) {
    isMrpLoad = true;
    loadSca(mrpfile);
    writeHTML();
  } else if (!Empty(fileMrpDef)) {
	  width = workAreaWidth;
	  height = workAreaHeight;  
    isMrpLoad = true;
    fileMrpDef = Strtran(fileMrpDef, '\u0080', '\u20AC');
    var JSONItems = JSON.parse(fileMrpDef);
    var zoneNames = {};
    loadJson_sca(JSONItems, zoneNames);
    sortScaFields();
    complete_load(zoneNames);
    AformCompile();
    writeHTML();
  }

  if( /*Empty(fileSignMarks) &&*/ _signMarks.length > 0 ) {
		var _signJson = [];
		var _jsO, _jsL;
		for(var l=0; l<_signMarks.length; l++) {
			_jsO = _signMarks[l];
			_jsL = {};
			_jsL.x = _jsO.x;
			_jsL.y = _jsO.y;
			_jsL.width = _jsO.w;
			_jsL.height = _jsO.h;
			_jsL.page = parseInt(_jsO.page)+1;
      _jsL.signKey = _jsO.signKey;
      _jsL.group = _jsO.group;
      _jsL.title = _jsO.title;
      _jsL.signed = _jsO.signed;
      _jsL.signType = _jsO.signType;
      _jsL.obligatory = ((_jsO.brequired+'') === "true") || ((_jsO.brequired+'') === "TRUE");//_jsO.brequired;
			_signJson.push(_jsL);
		}
		fileSignMarks = JSON.stringify(_signJson)
	}

  document.html.style.height = '100%';
  document.body.style.height = '100%';
  resizeWindow(e, true);
  if (izoom != 999) {
    var cz = parseInt(izoom / 25, 0);
    izoom = cz*25;
    defZoom = izoom;
    zoom(izoom);
  }

  //toolbar
  initToolbarBtn();
  if ( zSPToolbar ) {
    if ( (zTitleToolBar1.length + zTitleToolBar2.length) > 0 ) {
      if( zTAssistant && !zTAssistant.IsEmpty() && (zTitleToolBar1.length + zTitleToolBar2.length)==1) {
        LibJavascript.CssClassNameUtils.removeClass(Ctrl('gadgets_header'), 'hide');
        LibJavascript.CssClassNameUtils.removeClass(Ctrl('IAssistant'), 'hide');
      }
      else {
        LibJavascript.CssClassNameUtils.removeClass(Ctrl('gadgets_header'), 'hide');
        LibJavascript.CssClassNameUtils.removeClass(Ctrl('IMenu'), 'hide');
      }
    }
  }
  
  Ctrl('properties').style.display = 'none';

  //portlet toolbar
  LoadPortletToolbar();
  
  controlFile();
  loadSignMarks();
  

  //pdf plugin
  var $$ = PluginDetect;
  $$.isMinVersion('PDFjs', '0', 'PDFjs.pdf');
  if (navigator.appName == 'Microsoft Internet Explorer') {
    isIE = true;
  }

  //assistant
  if( m_cAssistantAutoExec && zTAssistant && (canaddstamp || !zTAssistant.IsEmpty()) ){
    zTAssistant.EnableAssistant();
  }

  //can search
  if (cansearch){
   var ctrls = Ctrl('gadgets_footer_search');
   LibJavascript.CssClassNameUtils.removeClass(ctrls, 'hide');
   ctrls = Ctrl('gadgets_footer_searchSep');
   LibJavascript.CssClassNameUtils.removeClass(ctrls, 'hide');
  }

  hideLoadingDiv();
  if (PSCtrl) {
    if ( PSCtrl.dispatchEvent ) {
        PSCtrl.dispatchEvent('Rendered');
    }
  }
  eventPage();
}

function _calcScale(_cval) {
  _cval = parseInt(_cval / 25, 0);
  _cval = _cval * 25;
  if (_cval < 50 ) {
    _cval = 50;
  }
  if (_cval > 250 ) {
    _cval = 250;
  }
  return _cval;
}

/*function _ApplyPictureToDate(str,format,ctrl){ //contols.js
  //ctrl e' l' UID del control
  var dayString='',monthString='',yearString='';
  var hasFormat=Len(str)>8 || At('-',str)>0 || At('/',str)>0 || At(':',str)>0 || At('.',str)
  var res,picture,tmpPict;
  lastDateIsOk=true
 
  if(format=='D' || format=='')
    picture=datePattern
  else if(format=='N')
    picture=datePattern.replace(/[^DMY]/g,'')
  else
    picture=format;
 
  if(hasFormat){
   tmpPict=picture
  }else{
   tmpPict=picture.replace(/[^DMY]/g,'')
  }
  dayString=str.substr(tmpPict.indexOf("DD"),2)
  monthString=str.substr(tmpPict.indexOf("MM"),2);
  yearString=str.substr(tmpPict.indexOf("YY"),4);
  if(Len(yearString)==2){
   yearString=iif(Val(yearString)>50,'19','20')+yearString;
  }
  res=CheckDate(Val(dayString),Val(monthString),Val(yearString));
 
  if(res)
   str=_PictDS(dayString,monthString,yearString,picture);
  else{
   if((dayString+monthString+yearString)!='' && ctrl!=null){
    lastDateIsOk=false;
    //alert(Translate('MSG_WRONG_DATE'));
    str='';
    SetControlFocus(ctrl);
   }
  }
  return str;
 }

 function _ApplyPictureToDateTime(str,format,ctrl){ //contols.js
  var dayString='',monthString='',yearString='',hourString='',minuteString='',secondString='';
  var hasFormat=Len(str)>14 || At('-',str)>0 || At('/',str)>0 || At(':',str)>0 || At('.',str)
  var res,picture,tmpPict;
  lastDateIsOk=true;
 
  if(format=='D' || format=='')
   picture=dateTimePattern
  else if(format=='N')
   picture=dateTimePattern.replace(/[^DMYhms]/g,'')
  else
   picture=format;
 
  if(!Empty(str)){
   if(hasFormat){
    tmpPict=picture
   }else{
    tmpPict=picture.replace(/[^DMYhms]/g,'')
   }
   dayString=str.substr(tmpPict.indexOf("DD"),2)
   monthString=str.substr(tmpPict.indexOf("MM"),2);
   yearString=str.substr(tmpPict.indexOf("YYYY"),4);
   hourString=str.substr(tmpPict.indexOf("hh"),2) || '00';
   minuteString=str.substr(tmpPict.indexOf("mm"),2) || '00';
   secondString=str.substr(tmpPict.indexOf("ss"),2) || '00';
   if(Len(yearString)<4){
    if(Len(yearString)==2)
     yearString=iif(Val(yearString)>50,'19','20')+yearString;
    else
     yearString=ZeroPad(yearString,4);
   }
   res=CheckDateTime(Val(dayString),Val(monthString),Val(yearString),Val(hourString),Val(minuteString),Val(secondString));
 
   if(res)
    str=_PictTS(dayString,monthString,yearString,hourString,minuteString,secondString,picture);
   else{
    if((dayString+monthString+yearString+hourString+secondString+minuteString)!='' && ctrl!=null){
     lastDateIsOk=false;
     //alert(Translate('MSG_WRONG_DATE'));
     str='';
     SetControlFocus(ctrl);
    }
   }
  }
  return str;
 }
 */

function eventPage() {
  var mpage;
  if (modebook == true && nrPagesToView == 2) {
    mpage = page1;
  } else if (modebook == true && nrPagesToView == 4) {
    mpage = page3;
  } else if (currentPage == 1) {
    mpage = page1;
  } else if (currentPage == 0) {
    mpage = page0;
  }
  if ( mpage == maxPages && maxPages > 0 ) {
    if ( window.parent.ZtVWeb ) {
      var portlets = window.parent.ZtVWeb.getPortlet();
      var names = window.parent.ZtVWeb.getPortletName();
      var i, j, name, portlet, ctrl;
      for ( i = 0; i < names.length; i++ ) {
        name = names[i];
        portlet = portlets[name];
        if ( portlet && portlet.ctrls ) {
          for ( j = 0; j < portlet.ctrls.length; j++ ) {
            ctrl = portlet.ctrls[j];
            if (ctrl.type == 'Iframe' && ctrl.iframe && ctrl.iframe.contentWindow == window ) {
							 if ( ctrl.dispatchEvent ) {
								 ctrl.dispatchEvent('zPdfViewer_LastPage');
							 }
							 j = portlet.ctrls.length;
							 i = names.length;
            }
          }
        }
      }
    }
  }

  if(zTitlePortlet && zTitlePortlet.SetSubTitle)
    zTitlePortlet.SetSubTitle(mpage + "/" + maxPages, true);
  if (PSCtrl) {
    if ( PSCtrl.dispatchEvent && maxPages > 0 ) {
      if ( mpage == 1 ) {
        PSCtrl.dispatchEvent('FirstPage');
      }
      else {
        PSCtrl.dispatchEvent('Page', mpage);
      }
      if ( mpage == maxPages ) {
        PSCtrl.dispatchEvent('LastPage');
      }
    }
  }
}

function Help() {}

function RemoveSignMarks(signMarks, toBo) {
  var del = false;
  var boWindow = getBOWindow();
  for(var i=0; i<signMarks.length; i++ ) {
    var key = signMarks[i];
    if( signMarksKey[key] ) {
      signMarksKey[key].shadow = 'delete';
      if(toBo && boWindow && boWindow.zbo_beforeremoveSignMark) {
        boWindow.zbo_beforeremoveSignMark(signMarksKey[key].key, signMarksKey[key].group);
      }
      if(toBo && boWindow && boWindow.zbo_removeSignMark) {
        boWindow.zbo_removeSignMark(signMarksKey[key].key, signMarksKey[key].group);
      }
      if( signMarksGroupArray[signMarksKey[key].group] ) {
        var ind = signMarksGroupArray[signMarksKey[key].group].indexOf(key);
        if ( ind >= 0 ) {
          signMarksGroupArray[signMarksKey[key].group].splice(ind, 1);
      }
      }
      delete signMarksKey[key];
      del = true;
    }
  }
  if( del ) {
    m_bUpdated = true;
    deleteItem();
  }
}

/* *** Gestione del Load *** */
function LoadPdf(file, upload) {
  if(!Empty(file)) {
    showLoadingDiv();
  } else {
    hideLoadingDiv();
  }
  //updateToolbar();
  if (upload && !Empty(file) && !Empty(pdfFile) && pdfFile.toLowerCase().match('.pdf$') && maxPages > 0) {
    if (myZBoViewWindow && myZBoViewWindow.MergePdf) {
      if (confirm('Merge new file with the precedent?')) {
        myZBoViewWindow.MergePdf(file, pdfFile); //deve richiamare il metodo BoViewerLoadPdf per ricaricare il nuovo file nel viewer
        return;
      }
    }
  }

  itemsHTML = [];
  signMarksKey = [];
  signMarksGroupArray = [];
  zTAssistant = null;

  if (Ctrl('imask_uploadframe')) {
    Ctrl('imask_uploadframe').style.display = 'none';
  }

  setFile(file);
  
  w_init = parseInt(Ctrl('backcanvas').style.width);
  h_init = parseInt(Ctrl('backcanvas').style.height);
  width = 1;
  height = 1;
  if (maxPages > 0) {
    w_init = workAreaWidth;
    h_init = workAreaHeight;
    width = workAreaWidth;
	  height = workAreaHeight;
    if (modebook == true) {
      w_init = w_init * 2;
    }
  }
  resizeWindow(null, true);
  if (izoom != 999) {
    zoom(izoom);
  }
  EnableToolbarPdfState();
  //SetCanAddStamp(true);
  isStamp = false;
  //_innerMrp = false;

  if (!Empty(fileMrpDef)) {
    //_innerMrp = true;
    isMrpLoad = true;
    var JSONItems = JSON.parse(fileMrpDef);
    var zoneNames = {};
    loadJson_sca(JSONItems, zoneNames);
    sortScaFields();
    complete_load(zoneNames);
    AformCompile();
    writeHTML();
  }
  if( /*Empty(fileSignMarks) &&*/ _signMarks.length > 0 ) {
		var _signJson = [];
		var _jsO, _jsL;
		for(var l=0; l<_signMarks.length; l++) {
			_jsO = _signMarks[l];
			_jsL = {};
			_jsL.x = _jsO.x;
			_jsL.y = _jsO.y;
			_jsL.width = _jsO.w;
			_jsL.height = _jsO.h;
      _jsL.signKey = _jsO.signKey;
      _jsL.group = _jsO.group;
      _jsL.title = _jsO.title;
			_jsL.page = parseInt(_jsO.page)+1;
      _jsL.signed = _jsO.signed;
      _jsL.signType = _jsO.signType;
      _jsL.obligatory = ((_jsO.brequired+'') === "true") || ((_jsO.brequired+'') === "TRUE");//_jsO.brequired;
			_signJson.push(_jsL);
		}
		fileSignMarks = JSON.stringify(_signJson)
	}

  LoadPortletToolbar();

  controlFile();
  loadSignMarks();
  eventPage();

  
  loadScrollPage = false;
  if (myZBoViewWindow && myZBoViewWindow.SetUploadDoc) {
    var signMarksA = Object.values(signMarksKey);
    myZBoViewWindow.SetUploadDoc(file, signMarksA, upload);
  }
  if( m_cAssistantAutoExec && zTAssistant && (canaddstamp || !zTAssistant.IsEmpty()) ){
    zTAssistant.EnableAssistant();
  }
}

function setFile(file) {
  pdfFile = file;
  maxPages = -1;
  fileSignMarks = null;
  fileMrpDef = null;
  calcAcrofieldsOrder = null;
  if (!Empty(LRTrim(file))) {
    var url = new JSURL('../servlet/IcePdfNumberOfPages?file=' + file, true);
    var output = url.Response();

    maxPages = -1;
    workAreaWidth = -1;
    workAreaHeight = -1;
    try {
      output = JSON.parse(output);
    } catch (e) {
	  try {
		  output = output.replace(/\\\\/g, '\\');
		  output = JSON.parse(output);
	  }
	  catch(e) {
		  PSAlert.alert("Error on loading pdf file '" + file + "'");
	  }
    }
  
    if (!output.error) {
      maxPages = parseInt(output.numPages);
      workAreaWidth = PtToPx(output.pageWidth);
      workAreaHeight = PtToPx(output.pageHeight);
      isSecureDoc = parseInt(output.isSecureDoc);
      hasAcrofields = output.hasAcrofields;
      isPdfA = output.pdfA;
      if (output.signMarks) {
        fileSignMarks = output.signMarks;
      }
      if (output.mrpDef) {
        fileMrpDef = output.mrpDef;
      }
      if (output.calcAcrofieldsOrder) {
        calcAcrofieldsOrder = output.calcAcrofieldsOrder;
      }
    } else {
      PSAlert.alert("Error on loading pdf file '" + file + "'");
    }
    page0 = -1;
    page1 = -1;
    page2 = -1;
    page3 = -1;
    if (maxPages > 0 && modebook == true && nrPagesToView == 2) {
      page0 = 0;
      page1 = 1;
    } else if (maxPages > 0 && modebook == true && nrPagesToView == 4) {
      page0 = 1;
      page1 = 2;
      page2 = 3;
      page3 = 4;
    } else if (maxPages > 0 && modebook == false) { // nrPagesToView==1
      page0 = 1;
      page1 = 1;
    }

    if (maxPages > 0) {
      if (isIE == false) {
        var divrotate = 'rotate(54.75deg)';
        var divtranslate = '0px 0px 0px';
        var mtan = workAreaHeight / workAreaWidth;
        divanglerad = Math.atan(mtan);
        divrotate = 'rotate(' + divanglerad * (180 / Math.PI) + 'deg)';
        Ctrl('dcancelpage0').style.transform = divrotate;
        Ctrl('dcancelpage0').style.webkitTransform = divrotate;
        Ctrl('dcancelpage0').style.mozTransform = divrotate;
        Ctrl('dcancelpage0').style.msTransform = divrotate + ' translate(0px,0px)';
        Ctrl('dcancelpage0').style.oTransform = divrotate;
        Ctrl('dcancelpage1').style.transform = divrotate;
        Ctrl('dcancelpage1').style.webkitTransform = divrotate;
        Ctrl('dcancelpage1').style.mozTransform = divrotate;
        Ctrl('dcancelpage1').style.msTransform = divrotate + ' translate(0px,0px)';
        Ctrl('dcancelpage1').style.oTransform = divrotate;
        Ctrl('dcancelpage0').style.transformOrigin = divtranslate;
        Ctrl('dcancelpage0').style.webkitTransformOrigin = divtranslate;
        Ctrl('dcancelpage0').style.mozTransformOrigin = divtranslate;
        Ctrl('dcancelpage0').style.oTransformOrigin = divtranslate;
        Ctrl('dcancelpage1').style.transformOrigin = divtranslate;
        Ctrl('dcancelpage1').style.webkitTransformOrigin = divtranslate;
        Ctrl('dcancelpage1').style.mozTransformOrigin = divtranslate;
        Ctrl('dcancelpage1').style.oTransformOrigin = divtranslate;
      }
    }
  }
  rempages = [];
  var ctrl = Ctrl('pagenumber');
  if (ctrl) {
    ctrl.value = '0';
    updatePageSpan();
  }
  Ctrl('pagenumberMax').set('text', maxPages); // TODO CHECK
  m_bUpdated = false;
}

/*function SetCanAddStamp(canadd) {
  canaddstamp = canadd;
  isStamp = false;
}*/

function controlFile() {
  Ctrl('mask').innerHTML = '';
  if (maxPages < 0) {
    if (izoom != 999) {
      zoom(izoom);
    } else {
      zoom(100);
    }

    initCanvas();
    Ctrl('backcanvas').scrollLeft = 0;
    Ctrl('backcanvas').scrollTop = 0;
    Ctrl('backcanvas').style.overflow = 'hidden';

    Ctrl('mask').setStyle('display', 'block');
    Ctrl('canvasline0').setStyle('display', 'none');
    Ctrl('canvasline1').setStyle('display', 'none');

    var missingFile =  MSG_ZPDF_TRANSLATE['MSG_ZPDF_NO_DOCUMENT'];
    if (Empty(pdfFile)) {
      if(canupload) {
        Ctrl('mask').innerHTML = '<iframe id="imask_uploadframe" class="imask_uploadframe" src="../jsp-system/SPZviewer_upload_portlet.jsp" allowtransparency="true" scrolling="no" frameborder="0" toResize="no" name="imask_uploadframe"></iframe>';
      } else {
        Ctrl('mask').innerHTML = '<div id="zmaskfile" style="text-align:center;z-index:3000;overflow:hidden;position:absolute;top:50%;border:0;width:100%;height:42px">' + missingFile + '</div>';
      }
    } else {
      var ix = pdfFile.lastIndexOf('/');
      if (ix > 0) {
        missingFile = pdfFile.substring(ix + 1);
      } else {
        missingFile = pdfFile;
    }
      Ctrl('mask').innerHTML = '<div id="zmaskfile" style="text-align:center;z-index:3000;overflow:hidden;position:absolute;top:50%;border:0;width:100%;height:42px">' + missingFile + '</div>';
    }
  } else {
    Ctrl('mask').setStyle('display', 'none');
    Ctrl('canvasline0').setStyle('display', 'block');
    Ctrl('canvasline1').setStyle('display', 'block');
  }
}

function checkMargins() {
  drawImage();
}

function loadSignMarks(paste) {
  if (Empty(fileSignMarks)) {
    return;
  }
  if(!paste && signmarksupd == true) {
    return;
  }
  var signArr = JSON.parse(fileSignMarks);
  for(var i=0; i<signArr.length; i++) {
    if(!paste && signArr[i].page) {
      signArr[i].page = parseInt(signArr[i].page + '') - 1;
      if (signArr[i].x) {
        signArr[i].x = PtToPx(signArr[i].x);
      }
      if (signArr[i].y) {
        signArr[i].y = PtToPx(signArr[i].y);
      }
      if (signArr[i].width) {
        signArr[i].width = PtToPx(signArr[i].width);
      }
      if (signArr[i].height) {
        signArr[i].height = PtToPx(signArr[i].height);
      }
    }
    if( paste ) {
      if( signArr[i].page == page0-1 ) {
        signArr[i].x += 5;
        signArr[i].y += 5;
      }
      else {
        signArr[i].page = page0-1;
      } 
    }
    addSignMark(signArr[i], false, false);
  }
  /*var fnToDelayG = function () {
    var sign;
    if(!Empty(signkey) && signMarksKey[signkey]) {
      sign = {};
      sign.signKey = signMarksKey[signkey].key;
      sign.group = signMarksKey[signkey].group;
      selectSignMark(sign, true);
    } else if ((!Empty(signgroup) && (signgroup != 'none')) && signMarksGroupArray[signgroup] && signMarksGroupArray[signgroup].length > 0) {
      signNavSelect = true;
      var key = signMarksGroupArray[signgroup][0];
      sign = {};
      sign.signKey = signMarksKey[key].key;
      sign.group = signMarksKey[key].group;
      selectSignMark(sign, true);
    }
  };
  fnToDelayG.delay(750);*/
}

/* *** Fine Gestione del Load *** */

/* *** Lettura Sca o Mrp *** */
function loadSca(scafile) {
  var url;
  if (isMrpLoad == true) {
    url = new JSURL('../servlet/JSPLoad?type=module&name=' + mrpfile, true);
  } else {
    url = new JSURL('../servlet/JSPLoad?type=scandoc&name=' + scafile, true);
  }
  var strreload = Strtran(url.Response(), '\u0080', '\u20AC');
  reload_sca(strreload);
}

function sortScaFields() {
  var i, j;
  groupChecks = {};
  for ( i=0; i<itemsHTMLArray.length; i++ ) {
    if ( itemsHTMLArray[i] == null) itemsHTMLArray[i] = [];
    itemsHTMLArray[i].sort ( function (a, b){
      if ( a.y != b.y )
        return a.y - b.y;
      return a.x - b.x;
    });
  }
  var _opts = {};
  _opts.GoToPage = GoToPage;
  if ( m_cAssistant ) 
    zTAssistant = new ZtAssistant(_opts);
  for ( i=0; i<itemsHTMLArray.length; i++ ) {
    var arr = itemsHTMLArray[i];
    for ( j=0; j<arr.length; j++ ) {
      var o = itemsHTMLArray[i][j];
      if( !Empty(o.defaultvalue) ){
        o.isEdited = true;
      } 
      if( o.datatype == 'number' ) {
        //len, dec -> picture ... not global
        o.globalpic = false;
        if(Empty(o.datapic)){
          if(Empty(o.len)) o.len = 10;
          var l = parseInt(o.len)- parseInt(o.dec)-1;
          var l3 = l/3;
          var l33 = l%3;
          var c;
          o.datapic = Replicate('9', l33);
          for(c=0; c<l3; c++)
          o.datapic+="," + Replicate('9', 3);
          if (parseInt(o.dec) > 0)
            o.datapic += "." + Replicate('9', parseInt(o.dec));
        }
      }
      if( fieldgroup != 'none' ) {
        if( fieldgroup == 'readonly' ) {
          o.editfield = false;
        }
        else {
          var sp = o.name.split("#");
          if( !Empty(fieldgroup) ) {
            if ( sp.length == 2 ) {
              var prefix = sp[0].split("$");
              if( prefix.indexOf(fieldgroup) < 0 ) {
                o.editfield = false;
              }
            }
            else {
              o.editfield = false;
            }
          }
          else {
            if ( sp.length == 2 ) {
              o.editfield = false;
            }
          }
        }
      }
      if ( !_isEditable && (o.editfield + '' == 'true') ) {
        _isEditable = true;
      }
      //o.editfield = false;//per test---da rimuovere
      if ( zTAssistant && o.editfield + '' == 'true' ) {
        if (o.type_exp == 'checkbox' || o.type_exp == 'radio')
          zTAssistant.Register(o.id, o.comment, o.note, i)
        else
          zTAssistant.Register(o.id+'_input', o.comment, o.note, i)
      }
      if (o.type_exp == 'checkbox' || o.type_exp == 'radio') {
        if (!Empty(o.groupCheck)) {
          if ( !groupChecks[o.groupCheck] ){
            groupChecks[o.groupCheck] = [];
          }
          groupChecks[o.groupCheck].push(o);
        }
        else {
          if ( !groupChecks[o.name] ){
            groupChecks[o.name] = [];
          }
          groupChecks[o.name].push(o);
        }
      }
      else {
        if ( !groupInputs[o.name] ){
          groupInputs[o.name] = [];
        }
        if( !Empty(o.datatype) ){
          for( var ld=0; ld<groupInputs[o.name].length; ld++ )
           if(Empty(groupInputs[o.name][ld].datatype)) groupInputs[o.name][ld].datatype = o.datatype;
        } 
        groupInputs[o.name].push(o);
      }
    }
  }
}

function loadJson_sca(JSONItems, zoneNames) {
  itemsHTMLArray = [];
  imgHTML = [];

  var i;
  var type, propName, valueToLoad;
  var JSONItem; 
  _signMarks = [];

  for (i = 0; i < JSONItems.length; i++) {
    JSONItem = JSONItems[i];
    type = JSONItem.type;
    if( JSONItem.editfield == undefined) 
      JSONItem.editfield = false;
    if ( JSONItem.ishidden == true )
      continue;
    if( ignoreInnerMrp ) {
      if ( (JSONItem.editfield+'' == 'true') )
        continue;
    }
    if( type == 'SignMark') {
	  	if(signmarksupd == false) _signMarks.push(JSONItem);
		  continue;
	  }

    if (type == 'DocPage') {
      if (itemsHTMLArray[imgcountindex] == null) {
        itemsHTMLArray[imgcountindex] = [];
        countindex[imgcountindex] = 0;
        imgHTML[imgcountindex] = new ZTObjects.imgObj('item' + nitem, 'DocPage' + nitem, 'DocPage', '', '', '', 1, 0, 0);
        imgcountindex++;
        nitem++;
      }
    }
    if ( JSONItem.page != undefined ) {
      propName = 'page';
      valueToLoad = typeof JSONItem[propName] == 'string' ? Trim(JSONItem[propName]) : JSONItem[propName];
      valueToLoad = typeof JSONItem[propName] == 'string' ? Strtran(valueToLoad, '##x2d;##x2d;', '--') : valueToLoad;
      var p = parseInt(valueToLoad);
      if (itemsHTMLArray[p] == null) {
        itemsHTMLArray[p] = [];
        countindex[p] = 0;
        imgHTML[p] = new ZTObjects.imgObj('item' + nitem, 'DocPage' + nitem, 'DocPage', '', '', '', 1, 0, 0);
        imgcountindex++;
        nitem++;
      }
      readDef(type, 'page', valueToLoad, zoneNames);
    } 
    for (propName in JSONItem) {
      if ( propName != 'page' ){
        valueToLoad = typeof JSONItem[propName] == 'string' ? Trim(JSONItem[propName]).replace(/\\\\/g, '\\').replace(/\\"/g, '"') : JSONItem[propName];
        valueToLoad = typeof JSONItem[propName] == 'string' ? Strtran(valueToLoad, '##x2d;##x2d;', '--') : valueToLoad;
        if (typeof valueToLoad == 'undefined') {
          valueToLoad = ' ';
        }
        readDef(type, propName, valueToLoad, zoneNames);
      }
    }
  }
}

function reload_sca(strReload) {
  itemsHTMLArray = [];
  imgHTML = [];
  var i;
  var itemsDef, itemProperties;
  var type, propName, valueToLoad;
  var zoneNames = {};
  if (LRTrim(strReload) != '') {
    if (!(Left(strReload, 6) == 'type||')) { // Def in formato JSON
      var JSONItems = JSON.parse(strReload);
      loadJson_sca(JSONItems, zoneNames);
    } else { // Def in formato |||
      itemsDef = strReload.split('|||');
      for (i = 0; i < itemsDef.length - 1; i++) {
        itemProperties = itemsDef[i].split('||');
        type = itemProperties[1];
        if (type == 'DocPage') {
          if (itemsHTMLArray[imgcountindex] == null) {
            itemsHTMLArray[imgcountindex] = [];
            countindex[imgcountindex] = 0;
          }
          imgHTML[imgcountindex] = new ZTObjects.imgObj('item' + nitem, 'DocPage' + nitem, 'DocPage', '', '', '', 1, 0, 0);
          imgcountindex++;
          nitem++;
        }
        for (var b = 0; b < itemProperties.length; b++) {
          propName = itemProperties[b];
          valueToLoad = Trim(itemProperties[b + 1]);
          readDef(type, propName, valueToLoad, zoneNames);
          b++;
        }
      }
    }
    sortScaFields();
  }
  complete_load(zoneNames);
  AformCompile();
}

function complete_load(zoneNames) {
  var i, imgcountindex;
  if (itemsHTMLArray.length > 0 && imgHTML.length == 0) {
    imgcountindex = 0;
    for (i = 0; i < itemsHTMLArray.length; i++) {
      imgHTML[imgcountindex] = new ZTObjects.imgObj('item' + nitem, 'DocPage' + nitem, 'DocPage', '', '', '', 1, 0, 0);
      imgcountindex++;
      nitem++;
      imgHTML[imgcountindex - 1].w = width;
      imgHTML[imgcountindex - 1].h = height;
    }
  }

  for (i = 0; i < itemsHTMLArray.length; i++) {
    for (var j = 0; j < itemsHTMLArray[i].length; j++) {
      if (!Empty(itemsHTMLArray[i][j].oblcondition)) {
        for (var obj in zoneNames) {
          if (zoneNames[obj] != itemsHTMLArray[i][j]) {
            if (itemsHTMLArray[i][j].oblcondition.indexOf(zoneNames[obj].name) >= 0) {
              itemsHTMLArray[i][j].oblcondition = Strtran(itemsHTMLArray[i][j].oblcondition, zoneNames[obj].name, "Ctrl('" + zoneNames[obj].id + '_input' + "').value");
            }
          }
        }
      }
      var itm = itemsHTMLArray[i][j];
      if(itm.type == 'Zone') {
        var valuee = itm.checkdefault ? itm.checkdefault.toLowerCase() : '';
        if (valuee == 'on' || valuee == 'true' || valuee == 's' || valuee == 'yes' || valuee == '1') {
          itm.defaultvalue = true;
        }
        else if(!Empty(valuee)){
          itm.defaultvalue = false;
        }
      }
    }
  }

  var _mrpData = null;
  var _mrpSignmarks = null;
  var z, o;
  if(PSCtrl && PSCtrl.ZGetMRPData) {
    _mrpData = PSCtrl.ZGetMRPData();
    if( _mrpData != null ) {
      var keys = Object.keys(_mrpData);
      var k, key, vk;
      for ( k=0; k<keys.length; k++ ) {
        key = keys[k];
        vk =  _mrpData[key];
        if (zoneNames[key]) {
          if ( groupChecks[key] ) {
            for ( z=0; z<groupChecks[key].length; z++) {
              o = groupChecks[key][z];
              if (Empty(o.checktruevalue)) {
                o.checkdefault = vk+'';
                o.defaultvalue = vk+'';
              }
              else {
                if ( vk == o.checktruevalue ) {
                  o.checkdefault = 'true';
                  o.defaultvalue = 'true';
                }
                else {
                  o.checkdefault = 'false';
                  o.defaultvalue = 'false';
                }
              }
              o.isEdited = true;
            }
          }
          else if ( groupInputs[key] ) {
            for ( z=0; z<groupInputs[key].length; z++) {
              groupInputs[key][z].defaultvalue = vk;
              groupInputs[key][z].isEdited = true;
            }
          }
          else {
            zoneNames[key].defaultvalue = vk;
            zoneNames[key].isEdited = true;
          }
        }
      }
    }
  }

  if(PSCtrl && PSCtrl.ZGetMRPSignmarks) {
    _mrpSignmarks = PSCtrl.ZGetMRPSignmarks();
    if( (_mrpSignmarks != undefined) && (_mrpSignmarks.length>0)) {
      signmarksupd = true;
      //reload signmarks
      for(var l=0; l<_mrpSignmarks.length; l++) {
        addSignMark( _mrpSignmarks[l]);
      }
    }
  }
  if ( _mrpData!=null && _mrpData!=undefined)  {
    
  }
  else if (compiledXML.length > 0) {
    var xmlobjc = new ZtVWeb.XMLDataProvider(form, 'xmlobjc', '', '/COMPILEDTEXT/RECORD', ' ', ' ', ' ', false);
    form[xmlobjc.name] = xmlobjc;
    xmlobjc.RenderQuery(compiledXML);
    var n = xmlobjc.FirstPage();
    var name, value;
    while (n == true) {
      name = xmlobjc.rs.NAME;
      value = xmlobjc.rs.VALUE;
      if (zoneNames[name]) {
        if ( groupChecks[name] ) {
          for ( z=0; z<groupChecks[name].length; z++) {
            o = groupChecks[name][z];
            if (Empty(o.checktruevalue)) {
              o.checkdefault = value+'';
              o.defaultvalue = value+'';
            }
            else {
              if ( value == o.checktruevalue ) {
                o.checkdefault = 'true';
                o.defaultvalue = 'true';
              }
              else {
                o.checkdefault = 'false';
                o.defaultvalue = 'false';
              }
            }
          }
        }
        else if ( groupInputs[key] ) {
          for ( z=0; z<groupInputs[key].length; z++) {
            groupInputs[key][z].defaultvalue = vk;
          }
        }
        else {
          zoneNames[key].defaultvalue = vk;
        }
      }
      n = xmlobjc.Next();
    }
  }
  nAllItems = nitem++;
  zZoneNames = zoneNames;
}

function readDef(type, propName, valueToLoad, zoneNames) {
  if (propName == 'color') {
    if (Trim(valueToLoad) != '') {
      var c_hex = rgbToHex(valueToLoad);
      if (!Empty(c_hex)) {
        valueToLoad = c_hex;
      }
    }
  }
  if (type == 'scandoc' || type == 'module') {
    if (propName == 'width') {
      width = valueToLoad;
    }
    if (propName == 'height') {
      height = valueToLoad;
    }
    formProp[propName] = valueToLoad;
  } else if (type == 'Zone' && propName == 'page') {
    docpageindex = parseInt(valueToLoad);
    if (itemsHTMLArray[docpageindex] == null) {
      itemsHTMLArray[docpageindex] = [];
      countindex[docpageindex] = 0;
    }
    if (isMrpLoad == true) {
      itemsHTMLArray[docpageindex][countindex[docpageindex]] = new ZTObjects.ZoneObj('item' + nitem, 'Zone' + nitem, 'Zone', '<div id=\'item' + nitem + '\' class="transparentsca" onselectstart=\'cancelEvent(event)\' style=\'z-index:1;border:0px solid;width:' + 60 * clCanvasLib.scale / 100 + 'px;height:' + 30 * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + 0 + 'px;left:' + 0 + 'px;\'><div id=\'item' + nitem + 'Title\' class="transparentscatitle" style="border:0px solid;position:relative;top:0px;height:20px;text-align:center;line-height:20px"></div><textarea onkeypress=\' return onEvtKeyPress(event,"' + 'item' + nitem + '",' + docpageindex + ');\' id=\'item' + nitem + '_input\' onfocus=\'onEvtFocus("' + 'item' + nitem + '");\' onblur=\'onEvtBlur(event,"' + 'item' + nitem + '",' + docpageindex + ');\' style="resize: none;"></textarea></div>', 'character', '', 0, 0);
    } else {
      itemsHTMLArray[docpageindex][countindex[docpageindex]] = new ZTObjects.ZoneObj('item' + nitem, 'Zone' + nitem, 'Zone', '<div id=\'item' + nitem + '\' class="transparentsca" onselectstart=\'cancelEvent(event)\' style=\'z-index:1;border:0px solid;width:' + 60 * clCanvasLib.scale / 100 + 'px;height:' + 30 * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + 0 + 'px;left:' + 0 + 'px;\'><div id=\'item' + nitem + 'Title\' class="transparentscatitle" style="border:0px solid;position:relative;top:0px;height:20px;text-align:center;line-height:20px"></div></div>', 'character', '', 0, 0);
    }
    nitem++;
    countindex[docpageindex]++;
  } else if (type == 'Zone' && propName == 'type_exp') {
    if (valueToLoad == 'text') {
    } else if (valueToLoad == 'checkbox') {
      itemsHTMLArray[docpageindex][countindex[docpageindex]-1].html = '<div class="transparentscaCheckbox" id=\'item' + (nitem - 1) + '\' onselectstart=\'cancelEvent(event)\' style=\'z-index:1;border:0px solid;width:' + 60 * clCanvasLib.scale / 100 + 'px;height:' + 30 * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + 0 + 'px;left:' + 0 + 'px;\'><div class="transparentscatitle" style="border:0px solid;position:relative;top:0px;height:20px;text-align:center;line-height:20px" id=\'item' + (nitem - 1) + 'Title\'></div><input type="checkbox" onclick="onEvtRadio(this,' + docpageindex + ' )" id=\'item' + (nitem - 1) + '_input\' onfocus=\'onEvtFocus("' + 'item' + (nitem -1) + '");\'></input><label style="font-family:Arial Unicode MS;" onclick=\'handlecheckz("' + 'item' + (nitem - 1)+'",this,' + docpageindex+');\' id=\'item' + (nitem - 1) + '_inputlabel\' onblur=\'onEvtBlurEmpty(event,"' + 'item' + (nitem - 1) + '",' + docpageindex + ');\' for=\'item' + (nitem - 1) + '_input\'></label></div>';
    } else if (valueToLoad == 'radio') {
      itemsHTMLArray[docpageindex][countindex[docpageindex]-1].html = '<div class="transparentscaCheckbox" id=\'item' + (nitem - 1) + '\' onselectstart=\'cancelEvent(event)\' style=\'z-index:1;border:0px solid;width:' + 60 * clCanvasLib.scale / 100 + 'px;height:' + 30 * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + 0 + 'px;left:'+ 0 + 'px;\'><div class="transparentscatitle" style="border:0px solid;position:relative;top:0px;height:20px;text-align:center;line-height:20px" id=\'item' + (nitem - 1) + 'Title\'></div><input type="radio" onclick="onEvtRadio(this,' + docpageindex + ' )" id=\'item' + (nitem - 1) + '_input\' onfocus=\'onEvtFocus("' + 'item' + (nitem -1) + '");\'></input><label style="font-family:Arial Unicode MS;" onclick=\'handlecheckz("'+'item' + (nitem - 1) + '",this,' + docpageindex + ');\'  id=\'item' + (nitem - 1) + '_inputlabel\' onblur=\'onEvtBlurEmpty(event,"' + 'item' + (nitem - 1) + '",' + docpageindex + ');\' for=\'item' + (nitem - 1) + '_input\'></label></div>';
    } else if (valueToLoad == 'combo') {
      var htm = '<div class="transparentsca" id=\'item' + (nitem - 1) + '\' onselectstart=\'cancelEvent(event)\' style=\'z-index:1;border:0px solid;width:' + 60 * clCanvasLib.scale / 100 + 'px;height:' + 30 * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + 0 + 'px;left:'+ 0 + 'px;\'><div class="transparentscatitle" style="border:0px solid;position:relative;top:0px;height:20px;text-align:center;line-height:20px" id=\'item' + (nitem - 1) + 'Title\'></div>';
      htm+='<select onchange="onEvtCombo(this,' + docpageindex + ' )" id=\'item' + (nitem - 1) + '_input\' onfocus=\'onEvtFocus("' + 'item' + (nitem -1) + '");\'   onblur=\'onEvtBlur(event,"' + 'item' + (nitem -1) + '",' + docpageindex + ');\'></input>';
      htm+='</div>';
      itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].html = htm;
    }
    itemsHTMLArray[docpageindex][countindex[docpageindex] - 1][propName] = valueToLoad;
  } /*else if (type == 'Zone' && propName == 'multiline') {
    if (isMrpLoad == true && itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].type_exp == 'text') {
      if (valueToLoad == 'true') {
      } else {
        //itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].html = '<div id=\'item' + (nitem - 1) + '\' class="transparentsca" onselectstart=\'cancelEvent(event)\' style=\'z-index:1;border:0px solid;width:' + 60 * clCanvasLib.scale / 100 + 'px;height:' + 30 * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + 0 + 'px;left:' + 0 + 'px;\'><div id=\'item' + (nitem - 1) + 'Title\' class="transparentscatitle" style="border:0px solid;position:relative;top:0px;height:20px;text-align:center;line-height:20px"></div><input id=\'item' + (nitem - 1) + '_input\' onfocus=\'onEvtFocus("' + 'item' + (nitem - 1) + '");\' onblur=\'onEvtBlur(event,"' + 'item' + (nitem - 1) + '",' + docpageindex + ');\' ></input></div>';
      }
    }
    itemsHTMLArray[docpageindex][countindex[docpageindex] - 1][propName] = valueToLoad;
  }*/ else if (type == 'DocPage') {
    imgHTML[imgcountindex - 1][propName] = valueToLoad;
  } else if (type == 'Zone' && propName != 'type') {
    itemsHTMLArray[docpageindex][countindex[docpageindex] - 1][propName] = valueToLoad;
    if (propName == 'name') {
      zoneNames[valueToLoad] = itemsHTMLArray[docpageindex][countindex[docpageindex]-1];
    }
  }
}
/* *** Fine Lettura Sca o Mrp *** */

/* *** Scrittura Sca o Mrp *** */
function PxToPt( v ) {
  return v;
  //return parseFloat( parseFloat(v) * 72 / 96); //mrp sca mappano 1 a 1 pt e px
}

function PtToPx( v ) {
  return v;
  //return parseInt( parseFloat(v) * 96 / 72); //mrp sca mappano 1 a 1 pt e px
}

function getdef() {
  var i = 0,
    j = 0,
    u = 0;
  var propName, valueToSave,
    strsave = '';
  isValidDocument = ValidDocument();
  keywords = '';
  fieldsListXml = '<COMPILEDTEXT>';
  jsCompileObj = {};
  jsCompileObj.all = {};
  jsCompileObj.edited = {}; 
  var JSONItems = [];
  var JSONTmpItem = {type : formProp.type};
  //JSONTmpItem["version"] = version;
  formProp.file = pdfFile;
  setPropertiesID(formProp);

  function saveToJSON(item) {
    var _lname = item.name;
    var valueToSave = item.defaultvalue;
    if( item.isEdited ) {
      jsCompileObj.edited[_lname] = valueToSave;
    }
    if ( (item.editfield + '' == 'true') ) {
      if (item.obligatory + '' == 'true') {
        if (!jsCompileObj.required){
          jsCompileObj.required = {}
        }
        jsCompileObj.required[_lname] = valueToSave;
        jsCompileObj.all[_lname] = valueToSave;
      }
      else {
        if (!jsCompileObj.notrequired){
          jsCompileObj.notrequired = {}
        }
        jsCompileObj.notrequired[_lname] = valueToSave;
        jsCompileObj.all[_lname] = valueToSave;
      }
   }
   else {
      if (!jsCompileObj.noteditable){
        jsCompileObj.noteditable = {}
      }
      jsCompileObj.noteditable[_lname] = valueToSave;
      jsCompileObj.all[_lname] = valueToSave;
   }
  }
  /* Module or ScanDoc Properties */
  for (i = 0; i < formProp.objClass.properties.length; i++) {
    propName = formProp.objClass.properties[i];
    valueToSave = formProp[propName];
    //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
    if (typeof valueToSave != 'number' && typeof valueToSave != 'boolean') {
      if (typeof valueToSave == 'undefined' || valueToSave == '') {
        // Se la prop e' undefined allora si salva come " "
        valueToSave = ' ';
      }
      if (propName == 'color') {
        if (Trim(valueToSave) == '') {
          valueToSave = '#000000';
      }
    }
    } else if (propName == 'height') {
        valueToSave = PxToPt(workAreaHeight) ;
    } else if (propName == 'width') {
        valueToSave = PxToPt(workAreaWidth) ;
      }
    if (typeof valueToSave == 'string') {
      valueToSave = Strtran(valueToSave, '--', '##x2d;##x2d;');
    }
    JSONTmpItem[propName] = valueToSave;
  }
  JSONTmpItem.maxcount = nAllItems;
  JSONItems.push(JSONTmpItem);
  JSONTmpItem = {};

  /* Page Properties */
  for (i = 0; i < imgHTML.length; i++) {
    if( !imgHTML[i] )
      continue;
    JSONTmpItem = {type : imgHTML[i].type};
    setPropertiesID(imgHTML[i]);
    for (u = 0; u < imgHTML[i].objClass.properties.length; u++) {
      propName = imgHTML[i].objClass.properties[u];
      valueToSave = imgHTML[i][propName];
      //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
      if (typeof valueToSave != 'number' && typeof valueToSave != 'boolean') {
        if (typeof valueToSave == 'undefined' || valueToSave == '') {
          // Se la prop e' undefined allora si salva come " "
          valueToSave = ' ';
        }
      }
      if (imgHTML[i].objClass.properties[u] == 'h') {
        valueToSave = PxToPt(workAreaHeight);
      } else if (imgHTML[i].objClass.properties[u] == 'w') {
        valueToSave = PxToPt(workAreaWidth);
      }
      if (LRTrim(valueToSave.toString()) != '') {
        JSONTmpItem[propName] = valueToSave;
      }
    }
    JSONItems.push(JSONTmpItem);
    JSONTmpItem = {};
  }

  /* Items Properties */
  for (i = 0; i < countindex.length; i++) {
    for (j = 0; itemsHTMLArray[i] && j < itemsHTMLArray[i].length; j++) {
      JSONTmpItem = {type : itemsHTMLArray[i][j].type};
      JSONTmpItem.page = i;
      setPropertiesID(itemsHTMLArray[i][j]);
      //var _lname;
      for (u = 0; u < itemsHTMLArray[i][j].objClass.properties.length; u++) {
        if(u == 0) saveToJSON(itemsHTMLArray[i][j]);
        propName = itemsHTMLArray[i][j].objClass.properties[u];
        valueToSave = itemsHTMLArray[i][j][propName];
        if ((propName == 'x' || propName == 'y') && valueToSave < 0) {
          PSAlert.alert('Attention item with position < 0!');
          itemsHTMLArray[i][j][propName] = 0;
          valueToSave = 0;
        }
        // Se valueToSave e' booelan e uguale a false, il test (valueToSave=="") restituisce true
        if (typeof valueToSave != 'number' && typeof valueToSave != 'boolean') {
          if (typeof valueToSave == 'undefined' || valueToSave == '') {
            // Se la prop e' undefined allora si salva come " "
            valueToSave = ' ';
          }
        }
        if (propName == 'x' || propName == 'y' || propName == 'w' || propName == 'h') {
          valueToSave = PxToPt(valueToSave * 100 / itemsHTMLArray[i][j].scale);
        } else if (propName == 'color') {
          if (Trim(valueToSave) == '') {
            valueToSave = '#000000';
          }
        }
        // Alleggerimento del def: il valore della proprieta' dell'item e' la stringa vuota, e' inutile salvarla nel def.
        if (LRTrim(valueToSave.toString()) != '') {
          if (typeof valueToSave == 'string') {
            valueToSave = Strtran(valueToSave, '--', '##x2d;##x2d;');
          }
        }
        JSONTmpItem[propName] = valueToSave;
      }
      JSONItems.push(JSONTmpItem);
      JSONTmpItem = {};
    }
  }

  //checkbox e radio
  var keys = Object.keys(jsCompileObj.all);
  for ( i=0; i<keys.length; i++) {
    var key = keys[i];
    if( groupChecks[key] ) {
      var k;
      for ( k=0; k<groupChecks[key].length; k++ ) {
        var o = groupChecks[key][k];
        if ( o.defaultvalue+'' == 'true' && !Empty(o.checktruevalue) ) {
          jsCompileObj.all[key] = o.checktruevalue;
          if( jsCompileObj.edited && jsCompileObj.edited[key]!= null ) jsCompileObj.edited[key] = o.checktruevalue;
          if( jsCompileObj.required && jsCompileObj.required[key]!= null) jsCompileObj.required[key] = o.checktruevalue;
          if( jsCompileObj.notrequired && jsCompileObj.notrequired[key]!= null) jsCompileObj.notrequired[key] = o.checktruevalue;
          if( jsCompileObj.noteditable && jsCompileObj.noteditable[key]!= null) jsCompileObj.noteditable[key] = o.checktruevalue;
        }
      }
    }
    fieldsListXml += '<RECORD><NAME>' + xml_encode(key) + '</NAME>';
    fieldsListXml += '<VALUE>' + xml_encode(jsCompileObj.all[key]) + '</VALUE></RECORD>';
  }

  for (i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].type == 'Stamp') {
      JSONTmpItem = {type : 'Zone'};
    } else {
      JSONTmpItem = {type : itemsHTML[i].type};
    }

    updateItem(itemsHTML[i]);
    setPropertiesID(itemsHTML[i]);
    for (u = 0; u < itemsHTML[i].objClass.properties.length; u++) {
      propName = itemsHTML[i].objClass.properties[u];
      valueToSave = itemsHTML[i][propName];
      if ((propName == 'x' || propName == 'y') && valueToSave < 0) {
        PSAlert.alert('Attention item with position < 0!');
        itemsHTMLArray[i][j][propName] = 0;
        valueToSave = 0;
      }
      //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
      if (typeof valueToSave != 'number' && typeof valueToSave != 'boolean') {
        if (typeof valueToSave == 'undefined' || valueToSave == '') {
          // Se la prop e' undefined allora si salva come " "
          valueToSave = ' ';
        }
      }
      if (propName == 'x' || propName == 'w') {
        valueToSave = PxToPt(valueToSave * 100 / itemsHTML[i].scale);
      } else if (propName == 'y' || propName == 'h') {
        valueToSave = PxToPt(valueToSave * 100 / itemsHTML[i].scale);
      } else if (propName == 'size') {
        valueToSave += 'pt';
      } else if (propName == 'color') {
        if (Trim(valueToSave) != '') {
          valueToSave = toRgb(valueToSave);
        }
      } else if (propName == 'value') {
        propName = 'defaultvalue';
        if (keywords.length > 0) {
          keywords += ';';
        }
        keywords += valueToSave;
      }
      JSONTmpItem[propName] = valueToSave;
    }
    JSONItems.push(JSONTmpItem);
    JSONTmpItem = {};
  }
  fieldsListXml += '<VALIDDOCUMENT>' + isValidDocument + '</VALIDDOCUMENT>';
  fieldsListXml += '</COMPILEDTEXT>';
  jsCompileObj.mrpdef = JSONItems;
  jsCompileObj.valid = isValidDocument;

  jsUpdSignmarksObj = [];
  for( var l=0; l<itemsHTML.length; l++ ){
    var lo = itemsHTML[l];
    var s = {};
    s.bgeoposition = lo.bgeoposition;
    s.bhideextra = lo.bhideextra;
    s.brequired = lo.brequired + ''; //brequired as string
    s.dateformat = lo.dateformat;
    s.group = lo.group;
    s.h = lo.h;
    s.signKey = lo.signKey || lo.key;
    s.timeformat = lo.timeformat;
    s.title = lo.title;
    s.type = lo.type;
    s.w = lo.w;
    s.x = lo.x;
    s.y = lo.y;
    s.page = lo.page;
    s.signType = lo.signtype;
    s.signChecked = lo.signChecked;
    jsUpdSignmarksObj.push(s);
  }

  strsave = JSON.stringify(JSONItems, function(s, v) {
    if (typeof v != 'object') {
      return v.toString();
    } 
    return v;
  });
  return strsave;
}

function ValidDocument() {
  var ret = true;
  var field, value, rc;
  var _groupChecksValid = {};
  for (var i = 0; ret && i < itemsHTMLArray.length; i++) {
    for (var j = 0; ret && j < itemsHTMLArray[i].length; j++) {
      field = itemsHTMLArray[i][j];
      if ((field.editfield + '' == 'true') && (field.obligatory + '' == 'true')) {
        if (Ctrl(field.id + '_input')) {
          value = Ctrl(field.id + '_input').value + '';
        } else {
          value = field.defaultvalue;
        }
        if (field.type_exp == 'checkbox' || field.type_exp == 'radio') {
          value = field.checkdefault;
        }
        var _ret = false;
        if (field.type_exp == 'checkbox' || field.type_exp == 'radio') {
          var gcheck = field.name;
          if(!Empty(field.groupCheck)) {
            gcheck = field.groupCheck;
          }
          if ( _groupChecksValid[gcheck] != undefined )
              _ret = _groupChecksValid[gcheck];
          else {
              var _l = groupChecks[gcheck];
              for (var k=0; k<_l.length; k++) {
                _ret = _ret || ValidField(_l[k], _l[k].checkdefault);
              }
              _groupChecksValid[gcheck] = _ret;
          }
          _ret = _ret && field.isEdited;
        }
        else {
          _ret = ValidField(field, value);
        }
        ret = _ret && ret;
        if (!_ret) {
          _alertRequired (field, i);
          _goToField(field.id, i);
          /*if(Ctrl(field.id + '_input')){
            Ctrl(field.id + '_input').focus();
            LibJavascript.CssClassNameUtils.addClass(Ctrl(field.id + '_input'), 'classError');
          }*/
        }
        else {
          rc = checkValue(field, value);
          ret = rc.ok && ret;
          if (!rc.ok){
            //_alertRequired (field, i)
            if(Ctrl(field.id + '_input')){
              Ctrl(field.id + '_input').focus();
              LibJavascript.CssClassNameUtils.addClass(Ctrl(field.id + '_input'), 'classError');
            }
          }
        }
      }
      else if ((field.editfield + '' == 'false')) {
        //in teoria, non editato dunque nessun check va fatto
      }
      else {
        if (Ctrl(field.id + '_input')) {
          value = Ctrl(field.id + '_input').value + '';
        } else {
          value = field.defaultvalue;
        }
        if (field.type_exp == 'checkbox' || field.type_exp == 'radio') {
          value = field.checkdefault;
        }
        rc = checkValue(field, value);
        ret = rc.ok && ret;
        if (!rc.ok){
          //_alertRequired (field, i)
          if(Ctrl(field.id + '_input')){
            Ctrl(field.id + '_input').focus();
            LibJavascript.CssClassNameUtils.addClass(Ctrl(field.id + '_input'), 'classError');
          }
        }
      }
    }
  }
  return ret;
}

function ValidField(field, value) {
  if (Ctrl(field.id + '_input')) {
    LibJavascript.CssClassNameUtils.removeClass(Ctrl(field.id + '_input'), 'classError');
  }
  if ((field.editfield + '' == 'true') && (field.obligatory + '' == 'true')) {
    if (field.oblcondition && field.oblcondition.length > 0) {
        var ch;
        eval('ch=' + field.oblcondition);
        if (ch != true) {
          return true;
        } else if (Empty(value)) {
        return false;
      }
    } 
    else if (field.datatype == 'number' ) {
      var num = ValidNum(Strtran(value,',','.'), field.datapic);
      if (Empty(num) || isNaN(num))
        return false;
    }
    else if (Empty(value)) {
      return false;
    }
  }
  return true;
}
/* *** Fine Scrittura Sca o Mrp *** */

/* *** Gestione writeHTML *** */
function writeHTML() {
  var ctrlCanvasHandlers = Ctrl('canvashandlers');
  if (ctrlCanvasHandlers) {
    removeAllHandlers();
    if (signNavSelect == false) {
      HideOnToolbar('TSignBtn');
    }
    ctrlCanvasHandlers.parentElement.removeChild(ctrlCanvasHandlers);
  }
  writeHTMLPages();
  var ctrl = Ctrl('properties');
  if (ctrl) {
    ctrl.style.display = 'none';
  }

  if(zTAssistant && zTAssistant.IsActive())
    zTAssistant.ContinueAssistant(null,  parseInt(Ctrl('pagenumber').value)-1);
  else
    postfocus();
}

function isHidden(el) {
  return (el.offsetParent === null) 
}

function postfocus(){
  var fields = Ctrl('canvasitems0').querySelectorAll('input,textarea');
  var i;
  if( fields.length > 0 ){
    for ( i=0; i<fields.length; i++ ) {
      if(!isHidden(fields[i]) && !fields[i].disabled){
        fields[i].focus();
        return;
      }
    }
  }
  fields = Ctrl('canvasitems1').querySelectorAll('input,textarea');
  if( fields.length > 0 ){
    for ( i=0; i<fields.length; i++ ) {
      if(!isHidden(fields[i]) && !fields[i].disabled){
        fields[i].focus();
        return;
      }
    }
  }
  Ctrl('canvas').scrollTop = 0;
  Ctrl('canvas').scrollLeft = 0;
}

function writeHTMLPages() {
  Ctrl('canvasitems0').innerHTML = '';
  Ctrl('canvasitems1').innerHTML = '';
  Ctrl('canvasitems2').innerHTML = '';
  Ctrl('canvasitems3').innerHTML = '';

  var mIndex;

  if (modebook == true && maxPages > 0 && nrPagesToView == 2) {
    if (page0 != page1 && page0 > 0 && page0 <= maxPages) {
      mIndex = page0 - 1;
      drawSca(mIndex, 0);
      if (page1 <= maxPages) {
        mIndex = page1 - 1;
        drawSca(mIndex, 1);
      }
    } else if (page0 == 0) {
      mIndex = page0;
      drawSca(mIndex, 1);
    } else if (page0 <= maxPages) {
      mIndex = page0 - 1;
      drawSca(mIndex, 0);
    }
  } else if (modebook == true && maxPages > 0 && nrPagesToView == 4) {
    if (page0 <= maxPages) {
      mIndex = page0 - 1;
      drawSca(mIndex, mIndex);
    }
    if (page1 <= maxPages) {
      mIndex = page1 - 1;
      drawSca(mIndex, mIndex);
    }
    if (page2 <= maxPages) {
      mIndex = page2 - 1;
      drawSca(mIndex, mIndex);
    }
    if (page3 <= maxPages) {
      mIndex = page3 - 1;
      drawSca(mIndex, mIndex);
    }
  } else { // nrPagesToView==1
    if (page0 <= maxPages && maxPages > 0) {
      mIndex = page0 - 1;
      drawSca(mIndex, 1);
    }
  }
}

function drawSca(mIndex, page) {

  function drawSign() {
    var v1, v2;
    var evtid = [];
    for (var k = 0; k < itemsHTML.length; k++) {
      itm = itemsHTML[k];
      if (itm.page == mIndex) {
        Ctrl('canvasitems' + page).innerHTML = Ctrl('canvasitems' + page).innerHTML + itm.html;
        updateItem(itm);
        if (nrPagesToView == 4) {
          // eslint-disable-next-line max-len
          drawHighlightz(itm.x, workAreaHeight - parseFloat(itm.y), itm.w, itm.h, workAreaWidth, workAreaHeight, 0, canvasLinksWidth / 2, canvasLinksHeight / 2, itm.id, false);
        } else if (nrPagesToView == 2 && modebook == true) {
          drawHighlightz(itm.x, workAreaHeight - parseFloat(itm.y), itm.w, itm.h, workAreaWidth, workAreaHeight, 0, canvasLinksWidth, canvasLinksHeight, itm.id, false);
        } else { // nrPagesToView==1
          drawHighlightz(itm.x, workAreaHeight - parseFloat(itm.y), itm.w, itm.h, workAreaWidth, workAreaHeight, 0, canvasLinksWidth * 2, canvasLinksHeight, itm.id, false);
        }

        ctrl = Ctrl(itm.id);
        if (ctrl) {
          applyFont(itm, ctrl, false, mIndex + 1);
          if (Ctrl(itm.id + '_inputlabel')) {
            applyFont(itm, Ctrl(itm.id + '_inputlabel'), true, mIndex + 1);
          }
          var v;
          if ( !Empty(itm.value) ) {
            if( itm.value.indexOf("#") > 0 ) {
              var sp = itm.value.split("#")[0];
              if( sp.indexOf('$') > 0 ) sp = sp.split("$")[0];
              var signgroupd = signgrouplistmap[sp];
              if( signgroupd != undefined ) {
                v = signgroupd;
              }
              else {
                v = itm.value;
              }
            }
            else {
              v = signdesc; //nome o valore irrelevante - zona di firma generica perche non ha gruppo
              //ctrl.style.lineHeight = ctrl.offsetHeight - 2 + "px";
            }
          }
          else {
            v = signdesc;
            //ctrl.style.lineHeight = ctrl.offsetHeight - 2 + "px";
          }

          if( confirmstamp && !canaddstamp ) {
            if( itm.signChecked == undefined  || !itm.signChecked ) {
              if(Empty(signgroup) || (!Empty(signgroup) && signgroup==itm.group))
              v = MSG_ZPDF_TRANSLATE['MSG_ZPDF_CONFIRM_SIGNMARK'];
            }
          }
          v = ToHTML(v);
          v = Strtran(v, ' ', '&nbsp;');
          v = Strtran(v, '&#10;', '<br>');
          ctrl.innerHTML = v;
          ctrl.title = itm.comment? itm.comment : itm.value;
          /*ctrl.style.width = "100%";
          ctrl.style.height = "100%";*/
          //itm.size is real at 100% on workAreaWidth
          if (nrPagesToView == 4) {
            v1 = itm.size * (canvasLinksWidth / 4 / workAreaWidth) + 'px';
            v2 = itm.size * (canvasLinksHeight / 2 / workAreaHeight) + 'px';
            ctrl.style.fontSize = v1;
            if(Empty(ctrl.style.lineHeight)) ctrl.style.lineHeight = v2;
          } else if (nrPagesToView == 2 && modebook == true) {
            v1 = itm.size * (canvasLinksWidth / 2 / workAreaWidth) + 'px';
            v2 = itm.size * (canvasLinksHeight / workAreaHeight) + 'px';
            ctrl.style.fontSize = v1;
            if(Empty(ctrl.style.lineHeight)) ctrl.style.lineHeight = v2;
          } else {
            v1 = itm.size * (canvasLinksWidth / workAreaWidth) + 'px';
            v2 = itm.size * (canvasLinksHeight / workAreaHeight) + 'px';
            ctrl.style.fontSize = v1;
            if(Empty(ctrl.style.lineHeight)) ctrl.style.lineHeight = v2;
          }
          if(itm.type == 'SignMark') {
            evtid.push(itm);
          }
        }
      }
    }
    for( var l=0; l<evtid.length; l++) {
      itm = evtid[l];
      ApplySignMarkEffect(itm);
    }
  } 
  
  var w = parseInt(width);
  var h = parseInt(height);

  var ctrlCanvasLinks = Ctrl('canvaslinks');
  var canvasLinksWidth = ctrlCanvasLinks.offsetWidth;
  var canvasLinksHeight = ctrlCanvasLinks.offsetHeight;

  var hzz = 20;
  if (isMrpLoad == true) {
    hzz = 0;
  }
  var hz = hzz * clCanvasLib.scale / 100;

  Ctrl('dcancelpage0').style.display = 'none';
  Ctrl('dcancelpage1').style.display = 'none';

  if (rempages.contains(mIndex + 1 + '')) {
    Ctrl('dcancelpage' + page).style.display = 'inline-block';
  }

  var itm, ctrl, i;
  if (itemsHTMLArray[mIndex] != null) {
    for (i = 0; i < itemsHTMLArray[mIndex].length; i++) {
      itm = itemsHTMLArray[mIndex][i];
      Ctrl('canvasitems' + page).innerHTML = Ctrl('canvasitems' + page).innerHTML + itm.html;
      if (nrPagesToView == 4) {
        drawHighlightz(itm.x, h - parseFloat(itm.y) + hzz, itm.w, parseFloat(itm.h) + hzz, w, h, clCanvasLib.rotation, canvasLinksWidth / 2, canvasLinksHeight / 2, itm.id, false);
      } else if (nrPagesToView == 2 && modebook == true) {
        drawHighlightz(itm.x, h - parseFloat(itm.y) + hzz, itm.w, parseFloat(itm.h) + hzz, w, h, clCanvasLib.rotation, canvasLinksWidth, canvasLinksHeight, itm.id, false);
      } else { // nrPagesToView==1
        drawHighlightz(itm.x, h - parseFloat(itm.y) + hzz, itm.w, parseFloat(itm.h) + hzz, w, h, clCanvasLib.rotation, canvasLinksWidth * 2, canvasLinksHeight, itm.id, false);
      }
      ctrl = Ctrl(itm.id + 'Title');
      if (ctrl) {
        if (itm.edtname + '' == 'true') {
          ctrl.innerHTML = itm.name2;
        } else {
          ctrl.innerHTML = itm.name;
        }

        if (nrPagesToView == 4) {
          ctrl.style.height = hz / 2 + 'px';
          ctrl.style.lineHeight = hz / 2 + 'px';
          ctrl.style.fontSize = 6 * clCanvasLib.scale / 100 + 'px';
        } else {
          ctrl.style.height = hz + 'px';
          ctrl.style.lineHeight = hz + 'px';
          ctrl.style.fontSize = 9 * clCanvasLib.scale / 100 + 'px';
        }
        /*if(itm.type == 'SignMark') {
           ApplySignMarkEffect(itm);
        }*/
      }

      if (isMrpLoad == true && itm.type == 'Zone') {
        ctrl = Ctrl(itm.id + 'Title');
        if (ctrl) {
          ctrl.style.display = 'none';
        }        
        if (itm.editfield + '' == 'true') {
          applyFont(itm, Ctrl(itm.id + '_input'), false, mIndex + 1);
          if (Ctrl(itm.id + '_inputlabel')) {
            applyFont(itm, Ctrl(itm.id + '_inputlabel'), true, mIndex + 1);
          }
        } else if(!Empty(itm.defaultvalue) || !Empty(itm.checkdefault)) {
          ctrl = Ctrl(itm.id + '_input');
          if (ctrl)  {
            ctrl.disabled = true;
          }
          applyFont(itm, Ctrl(itm.id + '_input'), false, mIndex + 1);
          if (Ctrl(itm.id + '_inputlabel')) {
            applyFont(itm, Ctrl(itm.id + '_inputlabel'), true, mIndex + 1);
          }
        } else {
          ctrl = Ctrl(itm.id + '_input');
          if (ctrl)  {
            ctrl.disabled = true;
          }
          applyFont(itm, Ctrl(itm.id + '_input'), false, mIndex + 1);
          if (Ctrl(itm.id + '_inputlabel')) {
            applyFont(itm, Ctrl(itm.id + '_inputlabel'), true, mIndex + 1);
          }
        }
      }
    }

    drawSign();

    // Bisogna fare due cicli se non vengono ricaricati gli input e i valori anche se rimangono settati non sono piu' visibili
    for (i = 0; i < itemsHTMLArray[mIndex].length; i++) {
      itm = itemsHTMLArray[mIndex][i];
      ctrl = Ctrl(itm.id);
      if (ctrl && !isHidden(ctrl) && itm.type == 'Zone') {
        ctrl = Ctrl(itm.id + '_input');
        if (ctrl) {
          if (ctrl.tagName == 'INPUT') {
            ctrl.value = itm.defaultvalue;
            if (ctrl.type == 'checkbox' || ctrl.type == 'radio') {
                ctrl.value = itm.checkdefault ? itm.checkdefault.toLowerCase() : '';
                if (ctrl.value == 'on' || ctrl.value == 'true' || ctrl.value == 's' || ctrl.value == 'yes' || ctrl.value == '1') {
                  ctrl.checked = true;
                  itm.defaultvalue = true;
                  if (Ctrl(itm.id + '_inputlabel')) {
                    Ctrl(itm.id + '_inputlabel').innerHTML = '&#x2714;';
                  }
                } else {
                  ctrl.checked = false;
                  itm.defaultvalue = false;
                  if (Ctrl(itm.id + '_inputlabel')) {
                    Ctrl(itm.id + '_inputlabel').innerHTML = ' ';
                }
              }
            }
          } else if (ctrl.tagName == 'SELECT') {
            var v;
            var d;
            if( !Empty(itm.displaylist) ){
              d = LRTrim(itm.displaylist);
              if(d.indexOf("[") == 0) d = d.substring(1);
              if(d.indexOf("]") == d.length-1) d = d.substring(0, d.length-1);
              d = d.split(',');
            } 
            if( !Empty(itm.exportlist) ){
              v = LRTrim(itm.exportlist);
              if(v.indexOf("[") == 0) v = v.substring(1);
              if(v.indexOf("]") == v.length-1) v = v.substring(0, v.length-1);
              v = v.split(',');
            }
            if( v!=undefined && d!=undefined)
              for( var x=0; x<v.length; x++ ) {
                var opt = document.createElement('option');
                opt.value = LRTrim(v[x]);
                opt.innerHTML = LRTrim(d[x]);
                ctrl.appendChild(opt);
              }
            if( !Empty( itm.defaultvalue ))
              ctrl.value = itm.defaultvalue;
          }
          else {
            ctrl.innerHTML = itm.defaultvalue;
          }
          /*if(itm.type == 'SignMark') {
            ApplySignMarkEffect(itm);
          }*/
        }
      }
    }
  }
  else
    drawSign();
}

function onEvtRadio(e, docpageindex) {
  handlecheckz(Strtran(e.id,'_input',''), null, docpageindex);
}

function onEvtCombo(e, docindex) {
  var itemid = Strtran(e.id,'_input','');
  var f = false;
  var itm;
  for (var i = 0; i < itemsHTMLArray[docindex].length && !f; i++) {
    itm = itemsHTMLArray[docindex][i];
    if (itm.id == itemid) {
      f = true;
    }
  }
  if( f ) {
    var c = Ctrl(e.id);
    if( c ) itm.defaultvalue = c.value;
    itm.isEdited = true;
    AformExecute(itm.name);
  }
}

function onEvtFocus(itemid) {
  if (Ctrl(itemid)) {
    if (Ctrl(itemid + '_input')) {
      LibJavascript.CssClassNameUtils.removeClass(Ctrl(itemid + '_input'), 'classError');
    }
    var ctrl = Ctrl(itemid + '_input');
    if(zTAssistant && ctrl){
      if (ctrl.type == 'checkbox' || ctrl.type == 'radio') 
        zTAssistant.ContinueAssistant(itemid);
      else
        zTAssistant.ContinueAssistant(itemid + '_input');
    }
  }
}

function zManageItems(event) {
  var field=GetEventSrcElement(event);
  if(field.type != 'textarea') {
    return manageItems(event);
  }
}

function onEvtKeyPress(event, itemid, docindex) {
  var f = false;
  var itm;
  for (var i = 0; i < itemsHTMLArray[docindex].length && !f; i++) {
    itm = itemsHTMLArray[docindex][i];
    if (itm.id == itemid) {
      f = true;
    }
  }

  if ( f  && itm.datatype == 'number' ) {
    f = CheckNumWithPict(event, GetModDecPict(itm.datapic))
  }
  if( f == true ) itm.isEdited = true;
  return f;
}

function applyFont(itm, ctrlx, ischeckbox, page) {
  //apply font
  var pt;
  if (ischeckbox) {
    ctrlx.style.fontSize = ctrlx.offsetHeight + 'px';
	  ctrlx.style.lineHeight = ctrlx.offsetHeight + 'px';
    if (itm.globalfont + '' == 'true') {
      ctrlx.style.color = formProp.color;
    } else {
      ctrlx.style.color = itm.color;
    }
    ctrlx.style.borderColor = ctrlx.style.color;
  } else if (itm.globalfont + '' == 'true') {
    ctrlx.style.fontFamily = formProp.font;
    ctrlx.style.color = formProp.color;
    ctrlx.style.textAlign = itm.align;
    pt = false;
    if (('' + formProp.size).indexOf('pt') > 0) {
      pt = true;
    }
    if (pt == true) {
      ctrlx.style.fontSize = (parseInt(formProp.size) * clCanvasLib.scale / 100) + 'px';
    } else {
      ctrlx.style.fontSize = (0.75*parseInt(formProp.size) * clCanvasLib.scale / 100) + 'px';
    }
  } else {
    ctrlx.style.fontFamily = itm.font;
    ctrlx.style.color = itm.color;
    ctrlx.style.textAlign = itm.align;
    pt = false;
    if (('' + itm.size).indexOf('pt') > 0) {
      pt = true;
    }
    if (pt == true) {
      ctrlx.style.fontSize = (parseInt(itm.size) * clCanvasLib.scale / 100) + 'px';
    } else {
      ctrlx.style.fontSize = (0.75*parseInt(itm.size) * clCanvasLib.scale / 100) + 'px';
    }
    //altro
    if( itm.type_exp !='combo' && !ischeckbox && !itm.multiline) {
      ctrlx.style.lineHeight = parseInt(ctrlx.style.height) + 'px';
      ctrlx.style.overflow = 'hidden';
      ctrlx.wrap = 'off';
    }
  }

  var fontStyle = '';
  var fontEffect = '';

  if (itm.globalfont + '' == 'true') {
    fontStyle = formProp.style;
    fontEffect = Trim(formProp.effects);
  } else {
    fontStyle = itm.style;
    fontEffect = Trim(itm.effects);
  }

  if (fontStyle == 'normal') {
    ctrlx.style.fontWeight = 'normal';
    ctrlx.style.fontStyle = 'normal';
  } else if (fontStyle == 'bold') {
    ctrlx.style.fontWeight = 'bold';
    ctrlx.style.fontStyle = 'normal';
  } else if (fontStyle == 'italic') {
    ctrlx.style.fontWeight = 'normal';
    ctrlx.style.fontStyle = 'italic';
  } else if (fontStyle == 'bold italic') {
    ctrlx.style.fontWeight = 'bold';
    ctrlx.style.fontStyle = 'italic';
  } else {
    ctrlx.style.fontWeight = 'normal';
    ctrlx.style.fontStyle = 'normal';
  }
  if (fontEffect == '') {
    ctrlx.style.textDecoration = 'none';
  } else if (fontEffect == 'underline') {
    ctrlx.style.textDecoration = 'underline';
  } else if (fontEffect == 'strikeout') {
    ctrlx.style.textDecoration = 'line-through';
  } else {
    ctrlx.style.textDecoration = 'underline line-through';
  }
  if(itm.datatype == 'number') {
    ctrlx.maxLength = parseInt(itm.len);
  }
  else if(itm.datatype == 'date') {
    ctrlx.maxLength = 19; //date as also datetime
  }
  else if(itm.datatype == 'time') {
    ctrlx.maxLength = 19; // to remove as type?
  }
  else if (/*itm.datatype == 'text' &&*/ parseInt(itm.maxchar) > 0) {
    ctrlx.maxLength = itm.maxchar;
  }
  if ( !Empty(itm.comment ) )
    ctrlx.title = getNameNewPage(itm.comment, page);
  else
    ctrlx.title = getNameNewPage(itm.name, page);

  ctrlx.style.margin = "0px";
  ctrlx.style.padding = "0px";

  if (itm.obligatory + '' == 'true')
    LibJavascript.CssClassNameUtils.addClass(ctrlx, 'required');
  else
    LibJavascript.CssClassNameUtils.addClass(ctrlx, 'notrequired');
  if (itm.editfield + '' == 'false')
    LibJavascript.CssClassNameUtils.addClass(ctrlx, 'noteditable');
  else
    LibJavascript.CssClassNameUtils.addClass(ctrlx, 'editable');
}

function SelectSignMark(itemid){
  if( Ctrl(itemid) ) Ctrl(itemid).click();
}

function EvDeleteSignMark(itemid){
  if( Ctrl(itemid) ) {
    Ctrl(itemid).click();
    RemSignMarkDoc();
  }
}

function EvEditSignMark(itemid){
  var vSignMarkID = itemid;
  var itm = null;
  var f=false;
  for (var i = 0; i < itemsHTML.length && !f; i++) {
    itm = itemsHTML[i];
    if (itm.id == itemid) {
      f = true;
    }
  }
  if ( itm != null ) {
    var tSignMarkName;
    if( !Empty(itm.title) && itm.title.contains("#"+itm.name))
      tSignMarkName = itm.name;
    else if( !Empty(itm.signKey) && itm.signKey.contains("#"+itm.name))
      tSignMarkName = itm.name;
    else
      tSignMarkName = itm.title || itm.signKey || itm.name || itm.key;
    var vSignMarkGroup = itm.group;
    windowOpenForeground('../jsp-system/zpdfviewer_signmark_portlet.jsp?vGroupsList=' + URLenc(signgrouplist) + '&vGroupsListKeys='+ URLenc(signgrouplistkeys) + '&vSignMarkID='+ URLenc(vSignMarkID) + '&tSignMarkName='+ URLenc(tSignMarkName) + '&vSignMarkType=' + URLenc(itm.signtype) + '&vSignMarkGroup=' + URLenc(vSignMarkGroup) + '&bSignMarkRequired=' + URLenc(itm.brequired+''), '','toolbar=0,menubar=0,directories=0,width=300,height=150,resizable=0');
  }
}

function CheckUniqueSignMarkKey(itemid, name, group) {
  var key = "";
  if( !Empty(group) ) key = group+"#";
  key += name;
  for (var i = 0; i < itemsHTML.length; i++) {
    var itm = itemsHTML[i];
    if (itm.id != itemid) {
      if (!Empty(group) && (itm.key == key)) {
        return false;
      }
      if (Empty(group) && (itm.name == key)) {
        return false;
      }
    }
  }
  return true;
}

function SetSignMarkInfo(itemid, name, group, signtype, brequired) {
  var itm = null;
  var f=false;
  for (var i = 0; i < itemsHTML.length && !f; i++) {
    itm = itemsHTML[i];
    if (itm.id == itemid) {
      f = true;
    }
  }
  if ( itm != null ) {
    delete signMarksKey[itm.key];
    if( signMarksGroupArray[itm.group] ) {
      var ind = signMarksGroupArray[itm.group].indexOf(itm.key);
      if ( ind >= 0 ) {
        signMarksGroupArray[itm.group].splice(ind, 1);
      }
    }
    itm.group = group;
    itm.name = name;
    itm.value = "";
    itm.title = "";
    itm.signtype = signtype;
    itm.brequired = brequired + '';
    if( !Empty(group) ) itm.value = group;
    if( !Empty(signtype) ) {
      if( signtype == 'signPrivacy')
        itm.value += '$'+'prv';
      else if( signtype == 'signUnfair')
        itm.value += '$'+'unf';
      else
        itm.value += '$'+ signtype;
    }
    if( !Empty(itm.value) ) itm.value += "#";
    itm.value += name;   
    itm.key = itm.value;
    signMarksKey[itm.key] = itm;
    if (!signMarksGroupArray[itm.group]) {
      signMarksGroupArray[itm.group] = [];
    }
    signMarksGroupArray[itm.group].push(itm.key);
    updateSignMark(null, itm, true);
    signmarksupd = true;
  }
} 

function ApplySignMarkEffect(item) {
  if (!$(item.id)) {
    return;
  }
  $(item.id).removeClass('signchecked');
  $(item.id).removeClass('signnotchecked');
  $(item.id).removeClass('cursel');
  if( (!Empty(signkey) && item.key==signkey) || (!Empty(signgroup) && item.group == signgroup)) {
  if( confirmstamp && !canaddstamp ) {
    if (item.signChecked == true) {
      $(item.id).addClass('signchecked');
    } else {
      $(item.id).addClass('signnotchecked');
    }
  }
    else {
      $(item.id).addClass('cursel');
    }
  }
  $(item.id).removeClass('required');
  $(item.id).removeClass('notrequired');
  //if( (!Empty(signkey) && item.key==signkey) || (!Empty(signgroup) && item.group == signgroup)) {
  if (item.brequired + '' == 'true') {
    $(item.id).addClass('required');
  } else {
    $(item.id).addClass('notrequired');
  }
  //}

  if(!Empty(signkey) && item.key!=signkey) {
    Ctrl(item.id).style.cursor = 'default';
  } else if (!Empty(signgroup) && signgroup == 'none') {
    Ctrl(item.id).style.display = 'none';
  } else if (!Empty(signgroup) && item.group != signgroup) {
    Ctrl(item.id).style.cursor = 'default';
  }

  if( item.signed ){
    Ctrl(item.id).style.display = 'none';
  }

  if( !Empty(item.image) ){
    var img = new Image ();
		img.onload = function () {
      Ctrl(item.id).style.backgroundImage = "url('" + this.src + "')";
    };
    img.src = item.image;
    Ctrl(item.id).style.backgroundRepeat = 'no-repeat';
    Ctrl(item.id).style.backgroundSize = '100% 100%';
  } else {
    Ctrl(item.id).style.backgroundImage = '';
  }

  var text = item.text;
  if( !Empty(text) ) {
    var v = ToHTML(text);
    v = Strtran(v, ' ', '&nbsp;');
    v = Strtran(v, '&#10;', '<br>');
    var innerDiv = "<div id='" + item.id+'info' +"' style='position:absolute;bottom:0px;left:0px;width:100%'>" + v + '</div>';
    Ctrl(item.id).innerHTML = innerDiv;
    Ctrl(item.id).title = text;
  }

  /*if( canaddstamp ) {
    Ctrl(item.id).onmouseover = function(){
      if( signMarksEditTimeOuts[item.id] ){
        clearTimeout(signMarksEditTimeOuts[item.id]);
      }
      if( !Ctrl(item.id+'info') && !Ctrl(item.id+'edit')){
        var innerDiv = "<div class='editsignmark' title='" + MSG_ZPDF_TRANSLATE['MSG_ZPDF_EDIT_SIGNMARK'] + "' onclick=EvEditSignMark('" + item.id + "') id='" + item.id+'edit' +"' style='color:white;cursor:pointer;border:0px solid red;position:absolute;top:0px;right:22px;width:10%;line-height:20px'></div>";
        Ctrl(item.id).innerHTML += innerDiv;
      }
      if( !Ctrl(item.id+'info') && !Ctrl(item.id+'delete')){
         var innerDivd = "<div class='delsignmark' title='" + MSG_ZPDF_TRANSLATE['MSG_ZPDF_REMOVE_SIGNATUREMARK'] + "' onclick=EvDeleteSignMark('" + item.id + "') id='" + item.id+'delete' +"' style='color:white;cursor:pointer;border:0px solid yellow;position:absolute;top:0px;right:0px;width:10%;line-height:20px'></div>";
        Ctrl(item.id).innerHTML += innerDivd;
      }
    }
    Ctrl(item.id).onmouseout = function(){
      var timeOut = null;
      if( !Ctrl(item.id+'info') && (Ctrl(item.id+'edit') || Ctrl(item.id+'delete'))){
        timeOut = setTimeout(function(id){
           if(Ctrl(id+'edit')) Ctrl(id+'edit').remove()
           if(Ctrl(id+'delete')) Ctrl(id+'delete').remove()
           }, 2000, item.id);
        signMarksEditTimeOuts[item.id] = timeOut;
      }
    }
  }*/
}

function drawImage() {
  if (clCanvasLib.container != null) {
    clCanvasLib.container.innerHTML = '';
  }

  var ctrl = Ctrl('canvaslinks');
  var w = parseInt(ctrl.style.width);
  var h = parseInt(ctrl.style.height);
  var src = '';

  ctrl = Ctrl('backcanvas');

  setCanvasScroll();

  var url, output;
  if (modebook == true && maxPages > 0 && nrPagesToView == 2) {
    if (page0 != page1 && page0 > 0 && page0 <= maxPages) {
      url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page0 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
      output = url.Response();

      if (output != 'Error' && page0 <= maxPages) {
        if (clCanvasLib.scale > 601) {
          src = output + '_' + '7' + '_' + page0 + '.png';
        } else if (clCanvasLib.scale > 301) {
          src = output + '_' + '5' + '_' + page0 + '.png';
        } else if (clCanvasLib.scale > 101) {
          src = output + '_' + '3' + '_' + page0 + '.png';
        } else {
          src = output + '_' + page0 + '.png';
        }
        clCanvasLib.DrawRectImage(src, 0, 0, w / 2, h, rotation + '', 'hideLoadingDiv');
        clCanvasLib.rotation = rotation;
      } else if (output == 'Error') {
        alert(errMsg);
      }

      url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page1 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
      output = url.Response();
      if (output != 'Error' && page1 <= maxPages) {
        if (clCanvasLib.scale > 601) {
          src = output + '_' + '7' + '_' + page1 + '.png';
        } else if (clCanvasLib.scale > 301) {
          src = output + '_' + '5' + '_' + page1 + '.png';
        } else if (clCanvasLib.scale > 101) {
          src = output + '_' + '3' + '_' + page0 + '.png';
        } else {
          src = output + '_' + page1 + '.png';
        }
        clCanvasLib.DrawRectImage(src, w / 2, 0, w / 2, h, rotation + '', 'hideLoadingDiv');
        clCanvasLib.rotation = rotation;
      } else if (output == 'Error') {
        alert(errMsg);
      }
    } else if (page0 == 0) {
      url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page1 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
        output = url.Response();
        currentPage = 1;
      if (output != 'Error' && page1 <= maxPages) {
          if (clCanvasLib.scale > 601) {
          src = output + '_' + '7' + '_' + page1 + '.png';
        } else if (clCanvasLib.scale > 301) {
          src = output + '_' + '5' + '_' + page1 + '.png';
        } else if (clCanvasLib.scale > 101) {
          src = output + '_' + '3' + '_' + page0 + '.png';
        } else {
          src = output + '_' + page1 + '.png';
          }
        clCanvasLib.DrawRectImage(src, w / 2, 0, w / 2, h, rotation + '', 'hideLoadingDiv');
          clCanvasLib.rotation = rotation;
      } else if (output == 'Error') {
          alert(errMsg);
        }
    } else if (page0 <= maxPages) {
      url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page0 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
        output = url.Response();
        currentPage = 0;
      if (output != 'Error' && page0 <= maxPages) {
          if (clCanvasLib.scale > 601) {
          src = output + '_' + '7' + '_' + page0 + '.png';
        } else if (clCanvasLib.scale > 301) {
          src = output + '_' + '5' + '_' + page0 + '.png';
        } else if (clCanvasLib.scale > 101) {
          src = output + '_' + '3' + '_' + page0 + '.png';
        } else {
          src = output + '_' + page0 + '.png';
          }
        clCanvasLib.DrawRectImage(src, 0, 0, w / 2, h, rotation + '', 'hideLoadingDiv');
          clCanvasLib.rotation = rotation;
      } else if (output == 'Error') {
          alert(errMsg);
        }
      }
  } else if (modebook == true && maxPages > 0 && nrPagesToView == 4) {
    url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page0 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
    output = url.Response();
    if (output != 'Error' && page0 <= maxPages) {
      if (clCanvasLib.scale > 601) {
        src = output + '_' + '7' + '_' + page0 + '.png';
      } else if (clCanvasLib.scale > 301) {
        src = output + '_' + '5' + '_' + page0 + '.png';
      } else if (clCanvasLib.scale > 101) {
        src = output + '_' + '3' + '_' + page0 + '.png';
      } else {
        src = output + '_' + page0 + '.png';
      }
      clCanvasLib.DrawRectImage(src, w / 4, 0, w / 4, h / 2, rotation + '', 'hideLoadingDiv');
      clCanvasLib.rotation = rotation;
    } else if (output == 'Error') {
      alert(errMsg);
    }

    url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page1 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
    output = url.Response();
    if (output != 'Error' && page1 <= maxPages) {
      if (clCanvasLib.scale > 601) {
        src = output + '_' + '7' + '_' + page1 + '.png';
      } else if (clCanvasLib.scale > 301) {
        src = output + '_' + '5' + '_' + page1 + '.png';
      } else if (clCanvasLib.scale > 101) {
        src = output + '_' + '3' + '_' + page0 + '.png';
      } else {
        src = output + '_' + page1 + '.png';
      }
      clCanvasLib.DrawRectImage(src, w / 2, 0, w / 4, h / 2, rotation + '', 'hideLoadingDiv');
      clCanvasLib.rotation = rotation;
    } else if (output == 'Error') {
      alert(errMsg);
    }

    url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page2 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
    output = url.Response();
    if (output != 'Error' && page2 <= maxPages) {
      if (clCanvasLib.scale > 601) {
        src = output + '_' + '7' + '_' + page2 + '.png';
      } else if (clCanvasLib.scale > 301) {
        src = output + '_' + '5' + '_' + page2 + '.png';
      } else if (clCanvasLib.scale > 101) {
        src = output + '_' + '3' + '_' + page0 + '.png';
      } else {
        src = output + '_' + page2 + '.png';
      }
      clCanvasLib.DrawRectImage(src, w / 4, h / 2, w / 4, h / 2, rotation + '', 'hideLoadingDiv');
      clCanvasLib.rotation = rotation;
    } else if (output == 'Error') {
      alert(errMsg);
    }

    url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page3 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
    output = url.Response();
    if (output != 'Error' && page3 <= maxPages) {
      if (clCanvasLib.scale > 601) {
        src = output + '_' + '7' + '_' + page3 + '.png';
      } else if (clCanvasLib.scale > 301) {
        src = output + '_' + '5' + '_' + page3 + '.png';
      } else if (clCanvasLib.scale > 101) {
        src = output + '_' + '3' + '_' + page0 + '.png';
      } else {
        src = output + '_' + page3 + '.png';
      }
      clCanvasLib.DrawRectImage(src, w / 2, h / 2, w / 4, h / 2, rotation + '', 'hideLoadingDiv');
      clCanvasLib.rotation = rotation;
    } else if (output == 'Error') {
      alert(errMsg);
    }
  } else { // nrPagesToView==1
    if (page0 <= maxPages && maxPages > 0) {
      url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + page0 + '&scale=' + clCanvasLib.scale + '&maxPages=' + maxPages, true);
      output = url.Response();
      if (output != 'Error' && page0 <= maxPages) {
        if (clCanvasLib.scale > 601) {
          src = output + '_' + '7' + '_' + page0 + '.png';
        } else if (clCanvasLib.scale > 301) {
          src = output + '_' + '5' + '_' + page0 + '.png';
        } else if (clCanvasLib.scale > 101) {
          src = output + '_' + '3' + '_' + page0 + '.png';
        } else {
          src = output + '_' + page0 + '.png';
        }
        clCanvasLib.DrawRectImage(src, 0, 0, w, h, rotation + '', 'hideLoadingDiv');
        clCanvasLib.rotation = rotation;
      } else if (output == 'Error') {
        alert(errMsg);
      }
    }
  }

  if (Ctrl('canvashandlers')) {
    removeAllHandlers();
    if (signNavSelect == false) {
      HideOnToolbar('TSignBtn');
    }
  }
  setCanvasLine(w, h);

  removeHighlight();
  if (drawHL) {
    if (xmlobj1 != null) {
      var x = xmlobj1.rs.X;
      var y = xmlobj1.rs.Y;
      w = xmlobj1.rs.W;
      h = xmlobj1.rs.H;
      var pw = xmlobj1.rs.PageW;
      var ph = xmlobj1.rs.PageH;
      drawHighlight(x, y, w, h, pw, ph, xmlobj1.rs.Page, rotation);
    }
  }
  writeHTML();
  enableNextPrev();
}
/* *** Fine Gestione writeHTML *** */

/* *** Gestione Canvas *** */
function initCanvas() {
  var h, w;
  Ctrl('canvaslinks').innerHTML = '';
  Ctrl('canvaslinks').style.left = '0px';
  Ctrl('canvaslinks').style.top = '0px';

  w = w_init;
  h = h_init;

  /*if (flagrotate) {
    var t = w;
    w = h * 2;
    h = t / 2;
    w_init = w;
    h_init = h;
  }*/

  if (clCanvasLib == null) {
    clCanvasLib = CanvasLib.Init('canvaslinks', w * CanvasLib.scale / 100, h * CanvasLib.scale / 100);
  } else {
    clCanvasLib = CanvasLib.Init('canvaslinks', w * clCanvasLib.scale / 100, h * clCanvasLib.scale / 100);
  }
  clCanvasLib.SetAttrib('#FFFFFF', 0.8);
  checkMargins();
}

function resetScroll(val) {
  if (val <= 100) {
    Ctrl('backcanvas').scrollLeft = 0;
    Ctrl('backcanvas').scrollTop = 0;
  }
}

function setCanvasScroll() {
  if (Ctrl('imask_uploadframe') && Ctrl('imask_uploadframe').style.display == 'block') {
    return;
  }
  if (Ctrl('zmaskfile') && Ctrl('zmaskfile').style.display == 'block') {
    return;
  }
  var w_c = Ctrl('canvaslinks').offsetWidth;
  var h_c = Ctrl('canvaslinks').offsetHeight;
  var w = Ctrl('backcanvas').offsetWidth;
  var h = Ctrl('backcanvas').offsetHeight;
  if (w_c > w || h_c > h) {
    Ctrl('backcanvas').style.overflowX = 'auto';
    Ctrl('backcanvas').style.overflowY = 'auto';
  } else {
    Ctrl('backcanvas').scrollLeft = 0;
    Ctrl('backcanvas').scrollTop = 0;
    Ctrl('backcanvas').style.overflow = 'hidden';
  }
}

function setCanvasLine(w, h) {
  if (maxPages > 0) {
    Ctrl('canvasline0').style.display = 'block';
    Ctrl('canvasline1').style.display = 'block';
  }
  if (nrPagesToView == 2 || nrPagesToView == 1) {
    var ctrl = Ctrl('pagenumber');
    if (currentPage == 0) {
      if (ctrl) {
        ctrl.value = '' + page0;
        updatePageSpan();
      }
      ctrl = Ctrl('canvasline0');
      if (ctrl && w / 2 - 4 >= 0 && h - 4 >= 0) {
        ctrl.style.width = w / 2 - 4 + 'px';
        ctrl.style.height = h - 4 + -1 + 'px';
        //ctrl.style.left = 0 + "px";
      }
      ctrl = Ctrl('canvasline1');
      if (ctrl && w / 2 - 4 >= 0 && h - 4 >= 0) {
        ctrl.style.width = w / 2 - 4 + 'px';
        ctrl.style.height = h - 4 + -1 + 'px';
        //ctrl.style.left = w/2 + "px";
      }

      if (modebook == true && page0 > 0) {
        ctrl = Ctrl('canvasline0');
        if (ctrl) {
          ctrl.style.borderWidth = '2px';
        }

        ctrl = Ctrl('canvasline1');
        if (ctrl) {
          ctrl.style.borderWidth = '0px';
      }
      } else if (modebook == false) { // nrPagesToView==1
        ctrl = Ctrl('canvasline1');
        /*if (ctrl) {
          ctrl.style.left = w/4 + (-1) +"px"; //ctrl.style.left = w/2 + (-1) +"px";
        }*/
        if (ctrl) {
          //ctrl.style.left = 0 + "px";
          ctrl.style.width = w + 'px';
        }
      }
    } else {
      if (ctrl) {
        ctrl.value = '' + page1;
    }
      ctrl = Ctrl('canvasline1');
      if (ctrl && w / 2 - 4 >= 0 && h - 4 >= 0) {
        ctrl.style.width = w / 2 - 4 + -1 + 'px';
        ctrl.style.height = h - 4 + -1 + 'px';
        //ctrl.style.left = w/2 + "px";
      }
      ctrl = Ctrl('canvasline0');
      if (ctrl && w / 2 - 4 >= 0 && h - 4 >= 0) {
        ctrl.style.width = w / 2 - 4 + -1 + 'px';
        ctrl.style.height = h - 4 + -1 + 'px';
        //ctrl.style.left = 0 + "px";
      }

      if (modebook == true) {
        ctrl = Ctrl('canvasline1');
        if (ctrl) {
          ctrl.style.borderWidth = '2px';
        }
        ctrl = Ctrl('canvasline0');
        if (ctrl) {
          ctrl.style.borderWidth = '0px';
        }
      }
    }

    ctrl = Ctrl('canvasline2');
    if (ctrl) {
      ctrl.style.width = 0 + 'px';
      ctrl.style.height = 0 + 'px';
      //ctrl.style.left = 0 + "px";
      ctrl.style.borderWidth = '0px';
    }
    ctrl = Ctrl('canvasline3');
    if (ctrl) {
      ctrl.style.width = 0 + 'px';
      ctrl.style.height = 0 + 'px';
      //ctrl.style.left = 0 + "px";
      ctrl.style.borderWidth = '0px';
    }
    resizeCanvas();
  } else if (nrPagesToView == 4) {
    setCanvasLine4(w, h);
  }
}

function setCanvasLine4(w, h) {
  var ctrlz = Ctrl('pagenumber');
  if (ctrlz) {
    eval('ctrlz.value=page' + currentPage);
    updatePageSpan();
  }
  for (var i = 0; i < nrPagesToView; i++) {
    var ctrl = Ctrl('canvasline' + i);
    if (ctrl && w / 4 - 4 >= 0 && h / 2 - 4 >= 0) {
      ctrl.style.width = w / 4 - 4 + -1 + 'px';
      ctrl.style.height = h / 2 - 4 + -1 + 'px';
      //ctrl.style.left = (i%2)*w/4 + w/4 + "px";
      ctrl.style.top = parseInt(i / 2) * h / 2 + 'px';
      if (currentPage == i) {
        ctrl.style.borderWidth = '2px';
      } else {
        ctrl.style.borderWidth = '0px';
      }
    }
  }
}

function resizeCanvas() {
  var wb, wc, hb, hc;
  if (modebook == true) {
    wb = Ctrl('backcanvas').offsetWidth;
    wc = Ctrl('canvasline1').offsetWidth + Ctrl('canvasline0').offsetWidth;
    if (wb > wc) {
      Ctrl('canvasline0').style.left = (wb - wc) / 2 + 'px';
      Ctrl('canvasline1').style.left = (wb - wc) / 2 + Ctrl('canvasline0').offsetWidth + getOffset(Ctrl('canvasline1')).gapw + 'px';
      Ctrl('canvaslinks').style.left = (wb - wc) / 2 + 'px';
    } else {
      Ctrl('canvasline0').style.left = 0 + 'px';
      Ctrl('canvasline1').style.left = Ctrl('canvasline0').offsetWidth + getOffset(Ctrl('canvasline1')).gapw + 'px';
      Ctrl('canvaslinks').style.left = 0 + 'px';
    }

    hb = Ctrl('backcanvas').offsetHeight;
    hc = Ctrl('canvasline1').offsetHeight;
    if (hb > hc) {
      Ctrl('canvasline0').style.top = (hb - hc) / 2 + 'px';
      Ctrl('canvasline1').style.top = (hb - hc) / 2 + 'px';
      Ctrl('canvaslinks').style.top = (hb - hc) / 2 + 'px';
    } else {
      Ctrl('canvasline0').style.top = 0 + 'px';
      Ctrl('canvasline1').style.top = 0 + 'px';
      Ctrl('canvaslinks').style.top = 0 + 'px';
    }
  } else {
    wb = Ctrl('backcanvas').offsetWidth;
    wc = Ctrl('canvasline1').offsetWidth;
    if (wb > wc) {
      Ctrl('canvasline1').style.left = (wb - wc) / 2 + 'px';
      Ctrl('canvaslinks').style.left = (wb - wc) / 2 + 'px';
    } else {
      Ctrl('canvasline1').style.left = 0 + 'px';
      Ctrl('canvaslinks').style.left = 0 + 'px';
    }

    hb = Ctrl('backcanvas').offsetHeight;
    hc = Ctrl('canvasline1').offsetHeight;
    if (hb > hc) {
      Ctrl('canvasline0').style.top = (hb - hc) / 2 + 'px';
      Ctrl('canvasline1').style.top = (hb - hc) / 2 + 'px';
      Ctrl('canvaslinks').style.top = (hb - hc) / 2 + 'px';
    } else {
      Ctrl('canvasline0').style.top = 0 + 'px';
      Ctrl('canvasline1').style.top = 0 + 'px';
      Ctrl('canvaslinks').style.top = 0 + 'px';
    }
  }

  Ctrl('dcancelpage0').style.width = Ctrl('canvasline0').offsetHeight / Math.sin(divanglerad) + Math.sin(divanglerad) * 20 + 'px';
  Ctrl('dcancelpage1').style.width = Ctrl('canvasline1').offsetHeight / Math.sin(divanglerad) + Math.sin(divanglerad) * 20 + 'px';
}

function resizeWindow(/*event, res*/) {
  //updateToolbar();
  setzoom();
  scrollToCurImg();
}

function resizeWindowX(event, res) {
  resizeWindow(event, res);
}

function getSelectedCanvas() {
  var cId, ctrl;
  for (var i = 0; i < 4; i++) {
    cId = 'canvasline' + i;
    ctrl = Ctrl(cId);
    if (ctrl && !isHidden(ctrl)) {
      if (parseInt(ctrl.style.borderWidth) > 0) {
        return cId;
      }
    }
  }
  return 'canvasline1';
}

function beginScroll(e) {
  e = e ? e : window.event;
  if( Ctrl("canvashandlers")){
    cancelEvent(e);
    return;
  }
  
  Ctrl('backcanvas').setStyle('cursor', 'move');
  var x, y;
  if ( e.center ) {
    x = e.center.x;
    y = e.center.y;
  }
  else  {
    x = e.pageX ? e.pageX : e.clientX ? e.clientX : 0;
    y = e.pageY ? e.pageY : e.clientY ? e.clientY : 0;
  }
  if (document.all) {
    x += window.pageXOffset;
    y += window.pageYOffset;
  }
  x = x - Ctrl('canvas').offsetLeft + Ctrl('canvas').scrollLeft;
  y = y -  Ctrl('canvas').offsetTop + Ctrl('canvas').scrollTop;
  dragstartx = x;
  dragstarty = y;
  // blocca la propagazione
  cancelEvent(e);
}

function continueScroll(e) {
  e = e ? e : window.event;
  if( Ctrl("canvashandlers")){
    cancelEvent(e);
    return;
  }

  var x, y;
  if ( e.center ) {
    x = e.center.x;
    y = e.center.y;
  }
  else  {
    x = e.pageX ? e.pageX : e.clientX ? e.clientX : 0;
    y = e.pageY ? e.pageY : e.clientY ? e.clientY : 0;
  } 
  
  if (document.all) {
    x += window.pageXOffset;
    y += window.pageYOffset;
  }
  x = x - Ctrl('canvas').offsetLeft + Ctrl('canvas').scrollLeft;
  y = y -  Ctrl('canvas').offsetTop + Ctrl('canvas').scrollTop;
  // scroll
  Ctrl('canvas').scrollLeft += dragstartx - x;
  Ctrl('canvas').scrollTop += dragstarty - y;
  // blocca la propagazione
  cancelEvent(e);
}

function endScroll(e) {
  if( Ctrl("canvashandlers")){
    cancelEvent(e);
    return;
  }
  Ctrl('backcanvas').setStyle('cursor', 'default');
}
/* *** Fine Gestione Canvas *** */

/* *** Gestione Zoom *** */
function ZoomIn() {
  zoomGetNextValue();
  var zz = GetZoomValue();
  if (zz > 0) {
    resetScroll(parseInt(zz));
  }
  var fnToDelayG = function () {
    var z = GetZoomValue();
    z = parseInt(z);
    if (z > 0) {
      clCanvasLib.zoom(z);
      selectedZoombox();
      initCanvas();
      if( zTAssistant ) {
        var element = Ctrl('canvas');
        zTAssistant.SetScroll(element.scrollTop, element.scrollLeft)
      }
    }
  };
  fnToDelayG.delay(100);
}

function ZoomOut() {
  zoomGetPrevValue();
  var zz = GetZoomValue();
  if (zz > 0) {
    resetScroll(parseInt(zz));
  }
  var fnToDelayG = function () {
    var z = GetZoomValue();
    z = parseInt(z);
    if (z > 0) {
      clCanvasLib.zoom(z);
      selectedZoombox();
      initCanvas();
      if( zTAssistant ) {
        var element = Ctrl('canvas');
        zTAssistant.SetScroll(element.scrollTop, element.scrollLeft)
      }
    }
  };
  fnToDelayG.delay(100);
}

function ZoomFitIn() {
  var w = window.innerWidth
    || document.documentElement.clientWidth
    || document.body.clientWidth;
  if ( workAreaWidth > 0 )  {
    var zzoom = 100 * (w/(workAreaWidth));
    var cz = parseInt(zzoom/25);
    zoom(25*cz);
  }
}

function ZoomFitOut() {
  zoom(defZoom);
}

function zoom(val, xpos, ypos) {
  var element;
  val = _calcScale(val);
  if (clCanvasLib && clCanvasLib.container != null) {
    if(zoomindex >=0 && clCanvasLib.scale == val){
      resizezElements();
      initCanvas();
      if( zTAssistant ) {
        element = Ctrl('canvas');
        zTAssistant.SetScroll(element.scrollTop, element.scrollLeft)
      }
      setCanvasScroll();
      if (xpos && ypos) {
        Ctrl('backcanvas').scrollLeft = xpos;
        Ctrl('backcanvas').scrollTop = ypos;
      }
      return;
    }
    resetScroll(parseInt(val));
    clCanvasLib.zoom(val);
    selectedZoombox();
    resizezElements();
    initCanvas();
    if( zTAssistant ) {
      element = Ctrl('canvas');
      zTAssistant.SetScroll(element.scrollTop, element.scrollLeft)
    }
    setCanvasScroll();
    if (xpos && ypos) {
      Ctrl('backcanvas').scrollLeft = xpos;
      Ctrl('backcanvas').scrollTop = ypos;
    }
  }
}

function selectedZoombox() {
  var zoombox = document.getElementById('zoombox');
  if (zoombox != null) {
    for (var i = 0; i < zoombox.options.length; i++) {
      if (zoombox.options[i].value == clCanvasLib.scale) {
        zoombox.options[i].selected = true;
        izoom = clCanvasLib.scale;
        zoomindex = i;
      }
    }
    var ctrln = Ctrl('zoominBtn');
    var ctrlp = Ctrl('zoomoutBtn');
    LibJavascript.CssClassNameUtils.removeClass(ctrlp, 'disable_element');
    LibJavascript.CssClassNameUtils.removeClass(ctrln, 'disable_element');
    if ( zoomindex == 0 )
      LibJavascript.CssClassNameUtils.addClass(ctrlp, 'disable_element');
    if ( zoomindex == zoombox.options.length -1  )
      LibJavascript.CssClassNameUtils.addClass(ctrln, 'disable_element');
    
    var ctrli = Ctrl('zoomfitinBtn');
    var ctrlo = Ctrl('zoomfitoutBtn');
    if ( izoom == defZoom ) {
      LibJavascript.CssClassNameUtils.removeClass(ctrli, 'hide');
      LibJavascript.CssClassNameUtils.addClass(ctrlo, 'hide');
    }
    else {
      LibJavascript.CssClassNameUtils.removeClass(ctrlo, 'hide');
      LibJavascript.CssClassNameUtils.addClass(ctrli, 'hide');
    }
  }
}

function GetZoomValue() {
  var zoombox = document.getElementById('zoombox');
  if (zoombox != null) {
    return zoombox.options[zoomindex].value;
  }
  return -1;
}

function zoomGetNextValue() {
  var zoombox = document.getElementById('zoombox');
  if (zoombox != null) {
    if (zoomindex + 1 < zoombox.options.length) {
      zoomindex++;
    }
  }
}

function zoomGetPrevValue() {
  var zoombox = document.getElementById('zoombox');
  if (zoombox != null) {
    if (zoomindex - 1 >= 0) {
      zoomindex--;
    }
  }
}

function setzoom() {
  //var ctrl = Ctrl('backcanvas');
  zoom(izoom);
  /*if (w_init > 0) {
    var c = ctrl.offsetWidth / w_init * 100;
    var c2 = ctrl.offsetHeight / h_init * 100;
    if (c2 > c) {
      c = c2;
    }
    var cz = parseInt(c / 25, 0);
    zoom(cz * 25);
  }*/
}

function resizezElements() {
}
/* *** Fine Gestione Zoom *** */

/* *** Gestione modalita' di visualizzazione *** */
function changeViewMode() {
  var viewModeIcon = document.querySelector('#viewMode span');
  if (modebook == true && nrPagesToView == 2) {
    changeViewMode1();
    viewModeIcon.classList.remove('onepage');
    viewModeIcon.classList.add('twopages');
  } else { //nrPagesToView==1
    changeViewMode2();
    viewModeIcon.classList.remove('twopages');
    viewModeIcon.classList.add('onepage');
  }
}

function changeViewMode1() {
  modebook = false;
  w_init = w_init / 2;
  if (nrPagesToView == 4) {
    eval('page0=page' + currentPage);
  } else if (currentPage == 1) {
      page0 = page1;
    }
  lviewerNumPage = nrPagesToView;
  nrPagesToView = 1; //nrPagesToView=2;
  currentPage = 0;
  if (page0 == 0) {
    page0 = 1;
  }
  page1 = page0;
  if (Ctrl('canvasline1')) {
    Ctrl('canvasline1').style.borderWidth = '0px';
  }
  if (Ctrl('canvasline0')) {
    Ctrl('canvasline0').style.borderWidth = '0px';
  }
  GoToPage('' + page0);
  resizeCanvas();
}

function changeViewMode2() {
  modebook = true;
  lviewerNumPage = nrPagesToView;
  nrPagesToView = 2;
  eval('page0=page' + currentPage);
  w_init = w_init * 2;
  GoToPage('' + page0);
  resizeCanvas();
}
/* *** Fine gestione modalita' di visualizzazione *** */

/* *** Varie gestione disegnatore *** */
function checkError() {
  return maxPages <= 0;
}

function ValidMove(x, y, w, h/*, id*/) {
  var c = Ctrl(getSelectedCanvas());
  x = parseInt(x);
  y = parseInt(y);
  h = parseInt(h);
  w = parseInt(w);
  if (x < 0 || y < 0) {
    return false;
  }
  if (x + w >= c.offsetWidth) {
    return false;
  }
  if (y + h >= c.offsetHeight) {
    return false;
  }
  signmarksupd = true; // da ottimizzare ... review
  var itm = itemsHTML[index];
  itm.isMoved = true;
  itm.nrPagesToView = nrPagesToView;
  var ctrl2 = Ctrl('canvaslinks');
  var w2 = ctrl2.offsetWidth;
  var h2 = ctrl2.offsetHeight;
  itm.canvasw = w2;
  itm.canvash = h2;
  return true;
}

function getPdfFileName() {
  return pdfFile;
}
/* *** Fine Varie gestione disegnatore *** */

/* *** Gestione Item *** */
function clickItem(e) {
  //if( !canaddstamp ) return;
  SetOnEditProp(false);
  multipleSelection = false;
  canAlign = false;
  var xpos = 0,
    ypos = 0;
  var element;
  if (!e || e==null) {
    e = window.event;
  }
  element = GetEventSrcElement(e);
  ypos = getY(element);
  xpos = getX(element);

  var ctrlCanvasLinks = Ctrl('canvaslinks');
  var ctrlCanvasLinksWidth = parseInt(ctrlCanvasLinks.style.width); // *clCanvasLib.scale/100;
  var ctrlCanvasLinksHeight = parseInt(ctrlCanvasLinks.style.height); // *clCanvasLib.scale/100;

  if (nrPagesToView == 4) {
    if (ctrlCanvasLinks) {
      var lastCurrent = currentPage;
      if (xpos > ctrlCanvasLinksWidth / 2) {
        currentPage = 1;
      } else {
        currentPage = 0;
      }
      if (ypos > ctrlCanvasLinksHeight / 2) {
        currentPage += 2;
      }

      var p;
      eval('p = page' + currentPage);
      if (p <= 0 || p > maxPages) {
        currentPage = lastCurrent;
      }
    }
  } else if (nrPagesToView == 1) {
  } else if (ctrlCanvasLinks && page0 > 0 && page1 <= maxPages) {
    if (xpos > ctrlCanvasLinksWidth / 2) {
      currentPage = 1;
    } else {
      currentPage = 0;
    }
  }

  var ctrlCanvasHandlers = Ctrl('canvashandlers');
  if (ctrlCanvasHandlers) {
    removeAllHandlers();
    if (signNavSelect == false) {
      HideOnToolbar('TSignBtn');
    }
    ctrlCanvasHandlers.parentElement.removeChild(ctrlCanvasHandlers);
  }

  setCanvasLine(ctrlCanvasLinksWidth, ctrlCanvasLinksHeight);

  var itm, canvHandlers, n;
  var bo = getBOWindow();
  
  for (var k = 0; k < itemsHTML.length; k++) {
    itm = itemsHTML[k];
    if (itm.id == element.id || (('shadow' + itm.id.substr(4)) == element.id) ) {
      if (itm.type == 'SignMark' && bo != undefined) {
        if ( !bo.m_cFunction || bo.m_cFunction != 'edit' && bo.m_cFunction != 'new' ) {
          continue;
        }
        if(bo.zbo_isRowKey) {
          if (!bo.zbo_isRowKey( itm.key, itm.group )) {
            continue;
          }
        }
        if(bo.zbo_performClick && !itm.fromBO) {
          bo.zbo_performClick( itm.key, itm.group );
        }
        delete itm.fromBO;
      }
      if (itm.type == 'SignMark') {
        if(!Empty(signgroup) && (signgroup=='none'))
          continue;
        if(!Empty(signgroup) && (signgroup!=itm.group))
          continue;
      }

      //add canvashandlers
      canvHandlers = new Element('div', {
        html : '',
        id : 'canvashandlers',
        left : Ctrl(getSelectedCanvas()).offsetLeft,
        border : '2px solid black'
      });

      document.getElementById(getSelectedCanvas()).adopt(canvHandlers);
      index = k;
      itemsHTML[k].shadow = 'shadow' + itm.id.substr(4);
      var str = addHandlers(itm.id.substr(4));
      Ctrl('canvashandlers').innerHTML = Ctrl('canvashandlers').innerHTML + str;
      selectItem(Ctrl('shadow' + itm.id.substr(4)));
      k = itemsHTML.length;
      n = itm.id.substr(4);
      if ( modeInsertSign || !canaddstamp ) {
        Ctrl('handler' + n + '_0').style.display = 'none';
        Ctrl('handler' + n + '_1').style.display = 'none';
        Ctrl('handler' + n + '_2').style.display = 'none';
        Ctrl('handler' + n + '_3').style.display = 'none';
        Ctrl('handler' + n + '_4').style.display = 'none';
        Ctrl('handler' + n + '_5').style.display = 'none';
        Ctrl('handler' + n + '_6').style.display = 'none';
        Ctrl('handler' + n + '_7').style.display = 'none';
        Ctrl('shadow' + itm.id.substr(4)).style.background = 'none';

        k = itemsHTML.length;
        if( modeInsertSign && !modeSignSelect ) {
          // Tento di lanciare la funzione nella action code del portlet di partenza
          if( window.GetOpener() && window.GetOpener().ZtVWeb && window.GetOpener().ZtVWeb.getPortlet){
            var portletsList = window.GetOpener().ZtVWeb.getPortlet();
            var ptl;
            for (var x in portletsList) {
              ptl = portletsList[x];
              if (window.GetOpener().ZtVWeb.getPortlet(ptl.portletname).zPdfViewer_SelectSignMarkImage) {
                window.GetOpener().ZtVWeb.getPortlet(ptl.portletname).zPdfViewer_SelectSignMarkImage(itm.key, itm.group, window);
              }
            }
          }
          modeSignSelect = true;
        } else {
          modeSignSelect = false;
        }
      }
      updateSignMarkPrevNext(itm.group, itm.key);
      checkSignMark(itm);
      if(zTAssistant && zTAssistant.IsActive())
        zTAssistant.ContinueAssistant(itm.id);
      return;
    }
  }
  HideOnToolbar('TSignBtn');
}

function updateSignMarkPrevNext(group, key) {
  //signMark next prev
  if(signMarksGroupArray[group] && signMarksGroupArray[group].length > 0) {
    var ind = signMarksGroupArray[group].indexOf(key) + 1;
    Ctrl('signnumber').value = ind;
    Ctrl('signnumber').key = group;
    Ctrl('signnumberMax').innerHTML = signMarksGroupArray[group].length;
    ShowOnToolbar('TSignBtn');
  } else {
    HideOnToolbar('TSignBtn');
  }
}

function deleteItem() {
  var undeletedItems = [];
  var nrOfUndeletedItems = 0;
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow == '') { // sposta gli elementi non selezionati in undeletedItems
      undeletedItems[nrOfUndeletedItems++] = itemsHTML[i];
    } else {
      if( zTAssistant ) {
        zTAssistant.Remove(itemsHTML[i].id);
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, 'delete', null, null, null, null, itemsHTML[i]); // Salvo gli oggetti cancellati per Undo
    }
  }
  indexUndo++;
  undoSequence[indexUndo] = undoItemsMoved;
  CheckUndoSize();
  undoItemsMoved = [];
  countindex = nrOfUndeletedItems;
  itemsHTML = undeletedItems;
  index = null;
  last_index = null;
  writeHTML(true);
  Properties();
  m_bUpdated = true;
  if (!Empty(newPropObj)) {
    newPropObj.HideProperties();
  }
  if (myZBoViewWindow && myZBoViewWindow.RemoveStamp) {
    myZBoViewWindow.RemoveStamp();
  }
}

function updateItem(itm) {
  if (itm.isMoved == true) {
    if (itm.nrPagesToView == 2) {
      itm.x = Round(itm.x * workAreaWidth * 2 / itm.canvasw, 0);
      itm.y = Round(workAreaHeight - (itm.canvash - itm.y) * workAreaHeight / itm.canvash, 0);
    } else if (itm.nrPagesToView == 1) {
      itm.x = Round(itm.x * workAreaWidth * 2 / (itm.canvasw * 2), 0);
      itm.y = Round(workAreaHeight - (itm.canvash - itm.y) * workAreaHeight / itm.canvash, 0);
    } else if (itm.nrPagesToView == 4) {
      itm.x = Round(itm.x * workAreaWidth * 2 / (itm.canvasw / 2), 0);
      itm.y = Round(workAreaHeight - (itm.canvash / 2 - itm.y) * workAreaHeight / (itm.canvash / 2), 0);
    }
    itm.h = itm.h * 100 / itm.scale;
    itm.w = itm.w * 100 / itm.scale;
    itm.nrPagesToView = 0;
    itm.scale = 100;
    itm.isMoved = false;
  }
}

function onScroll(event) {
  var element = GetEventSrcElement(event);
  if( zTAssistant ) {
    zTAssistant.Scroll(element.scrollTop, element.scrollLeft)
  }
}

function onEvtBlurEmpty(/*event, itemid, docindex*/) {
}

function checkValue(itm, value){
  var ret = {}
  ret.ok = true;
  if (itm.datatype == 'date') { //date
   if( value!=null && value.length <= 8 ) {
      if( Ctrl(itm.id + '_input')){
        value = ApplyPictureToDate(Ctrl(itm.id + '_input').value,TranslatePicture(datePattern),itm.id + '_input');
      }
      else {
        value = ApplyPictureToDate(value,TranslatePicture(datePattern),itm.id + '_input');
      }
    }
    else if( value!=null && value.length > 8 ) {
      if( Ctrl(itm.id + '_input')){
        value = ApplyPictureToDateTime(Ctrl(itm.id + '_input').value,TranslatePicture(dateTimePattern),itm.id + '_input');
      }
      else {
        value = ApplyPictureToDateTime(value,TranslatePicture(dateTimePattern),itm.id + '_input');
      }
    }
    else {
      if( Ctrl(itm.id + '_input')){
        value = ApplyPictureToDate(Ctrl(itm.id + '_input').value,TranslatePicture(datePattern),itm.id + '_input');
      }
      else {
        value = ApplyPictureToDate(value,TranslatePicture(datePattern),itm.id + '_input');
      }
    }
    ret.ok = lastDateIsOk;
  }
  else if (itm.datatype == 'time') { //datetime
    if( Ctrl(itm.id + '_input')){
      value = ApplyPictureToDateTime(Ctrl(itm.id + '_input').value,TranslatePicture(dateTimePattern),itm.id + '_input');
    }
    else {
      value = ApplyPictureToDateTime(value,TranslatePicture(dateTimePattern),itm.id + '_input');
    }
    ret.ok = lastDateIsOk;
  }
  else if (itm.datatype == 'number') {
    if( Ctrl(itm.id + '_input')){
      var num = ValidNum(Strtran(Ctrl(itm.id + '_input').value,',','.'), itm.datapic);
      value = WtH(num,'N',itm.len,itm.dec,itm.datapic);
    }
    ret.ok = true;
  }
  ret.value = value;
  return ret;
}

function _alertRequired( field, page ) {
  if ( isLoading )
    return;
  var _msg, mymessage;
  if (!Empty(field.comment))
    _msg = getNameNewPage(field.comment, page + 1);
  else
    _msg = getNameNewPage(field.name, page + 1);
  mymessage = MSG_ZPDF_TRANSLATE['MSG_ZPDF_FIELD'] + ' ' + _msg +  ' ' + MSG_ZPDF_TRANSLATE['MSG_ZPDF_ONPAGE'] + ' ' + (page + 1) + ' ' + MSG_ZPDF_TRANSLATE['MSG_ZPDF_ERROR_REQUIRED'];
  alert(mymessage);
  
}

function _goToField( id, page ) {
  if ( isLoading )
    return;
  GoToPage(page+1, null, id);
}

function onEvtBlur(event, itemid, docindex) {
  var value = LRTrim(GetEventSrcElement(event).value);
  if( Empty(value) )
    return;
  var f = false;
  var itm;
  var isEdited = false;
  for (var i = 0; i < itemsHTMLArray[docindex].length && !f; i++) {
    itm = itemsHTMLArray[docindex][i];
    if (itm.id == itemid) {
      if( itm.defaultvalue != value ) {
        isEdited = true;
      }
      itm.defaultvalue = value;
      f = true;
    }
  }
  if( f ){
    if (Ctrl(itm.id + '_input')) {
        var ret = checkValue(itm, value); //with alert
        Ctrl(itm.id + '_input').value = ret.value;
        if (!ret.ok){
          LibJavascript.CssClassNameUtils.addClass(Ctrl(itm.id + '_input'), 'classError');
        }
        itm.defaultvalue = ret.value;
    }
    if( !itm.isEdited ) itm.isEdited = isEdited;
    if( groupInputs[itm.name] && groupInputs[itm.name].length > 1) {
      for (var j = 0; j < groupInputs[itm.name].length; j++) {
        if(  groupInputs[itm.name][j].id == itm.id )
          continue;
        groupInputs[itm.name][j].defaultvalue = itm.defaultvalue;
        if( !groupInputs[itm.name][j].isEdited ) groupInputs[itm.name][j].isEdited = isEdited;
        if (Ctrl(groupInputs[itm.name][j].id + '_input')) {
          Ctrl(groupInputs[itm.name][j].id + '_input').value = itm.defaultvalue;
          if (!ret.ok){
            LibJavascript.CssClassNameUtils.addClass(Ctrl(groupInputs[itm.name][j].id + '_input'), 'classError');
          }
        }
      }
    }
    AformExecute(itm.name);
 }
}

function handlecheckz(itemid, label, docindex) {
  function handlecheckGroup(field, value) {
    field.defaultvalue = value;
    field.checkdefault = value + '';
    field.isEdited = true;
    if (Ctrl(field.id + '_inputlabel')) {
      if ('' + value == 'true') {
        Ctrl(field.id + '_inputlabel').innerHTML = '&#x2714;';
        Ctrl(field.id + '_input').checked = true;
        Ctrl(field.id + '_input').value = '' + Ctrl(field.id + '_input').checked;
      } else {
        Ctrl(field.id + '_inputlabel').innerHTML = ' ';
        Ctrl(field.id + '_input').checked = false;
        Ctrl(field.id + '_input').value = '' + Ctrl(field.id + '_input').checked;
      }
    }
  }

  var c = Ctrl(itemid + '_input');
  if (c.value == 'true' || c.value == 'on') {
    c.checked = false;
  } else {
    c.checked = true;
  }
  c.value = '' + c.checked;
  LibJavascript.CssClassNameUtils.removeClass(Ctrl(itemid + '_input'), 'classError');
  var itm = handlecheck(itemid, c.checked, docindex);
  if( itm!=null) {
    itm.isEdited = true;
    var gcheck = itm.name;
    if(!Empty(itm.groupCheck))
      gcheck = itm.groupCheck;
    var _l = groupChecks[gcheck];
    if( _l && _l.length > 1 ) {
      for ( var k=0; k<_l.length; k++ ) {
        if ( _l[k].id != itemid ) {
          handlecheckGroup(_l[k], !c.checked)
        }
      }
    }
    AformExecute(itm.name);
  } 
  if(zTAssistant){
    zTAssistant.ContinueAssistant(itemid);
  }
}

function handlecheck(itemid, value, docindex) {
  var f = false;
  var itm;
  for (var i = 0; i < itemsHTMLArray[docindex].length && !f; i++) {
    itm = itemsHTMLArray[docindex][i];
    if (itm.id == itemid) {
      itm.defaultvalue = value;
      itm.checkdefault = value + '';
      f = true;
    }
  }
  if (Ctrl(itemid + '_inputlabel')) {
    if ('' + value == 'true') {
      Ctrl(itemid + '_inputlabel').innerHTML = '&#x2714;';
    } else {
      Ctrl(itemid + '_inputlabel').innerHTML = '';
    }
  }
  return itm;
}
/* *** Fine Gestione Item *** */

/* *** Gestione Drag Item *** */
function moveShadow(e){ //REDEFINED
  var elementShadow
  e = (e) ? e : window.event;
  newx = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
  newy = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
  newx = newx - parseInt(Ctrl("backcanvas").offsetLeft) + Ctrl("backcanvas").scrollLeft
  newy = newy - parseInt(Ctrl("backcanvas").offsetTop) + Ctrl("backcanvas").scrollTop
  
  var mainItem = itemsHTML[index];
  if ( !mainItem ) {
    return;
  }
  var dx=newx-deltax-mainitem.offsetLeft
  var dy=newy-deltay-mainitem.offsetTop
  var delta = new Array();
  delta[0] = dx;
  delta[1] = dy;
  delta[2] = dx;
  delta[3] = dy;
  if(canAlign &&  Date.now() - timestamp > 1000 )
    delta = drawSnap(delta,false);
  for (var p=0;p<itemsHTML.length;p++) {
    if(itemsHTML[p].shadow != "" && Ctrl(itemsHTML[p].shadow)){
      elementShadow=Ctrl(itemsHTML[p].shadow)
      //MG 20120302 beg
      var ret = true;
      if(window.ValidMove) {
        ret = window.ValidMove(elementShadow.offsetLeft+delta[0], elementShadow.offsetTop+delta[1], elementShadow.offsetWidth, elementShadow.offsetHeight,itemsHTML[p].id)
      }
      if(ret==true){
        elementShadow.style.left = (elementShadow.offsetLeft+delta[0])+'px';
        elementShadow.style.top = (elementShadow.offsetTop+delta[1])+'px';
      }
      addRulersLines();
    }
  }
}

function continueDragHandler(e) { //REDEFINED
  var itm = Ctrl('item' + draggedItemIdx);
  var shadow = Ctrl('shadow' + draggedItemIdx);
	itm.style.transition = '';
  var x, y, w, h;
  var mainItem = itemsHTML[index];
  var delta = []; // array che conterr? la dimensione dello spostamento che viene effettuato sulla shadow
  if ( !mainItem ) {
      return;
  }

  x = itm.offsetLeft;
  y = itm.offsetTop;
  w = itm.offsetWidth;
  h = itm.offsetHeight;
  var hgap = h - itm.clientHeight; // dimensione  bordi margin e padding
  var wgap = w - itm.clientWidth; // dimensione minima senza bordi margin e padding
  e = e ? e : window.event;
  newx = e.pageX ? e.pageX : e.clientX ? e.clientX : 0;
  newy = e.pageY ? e.pageY : e.clientY ? e.clientY : 0;
  newx = parseInt(newx) - Ctrl('canvaslinks').offsetLeft + Ctrl('canvas').scrollLeft;
  newy = parseInt(newy) - getY(Ctrl('canvaslinks')) + Ctrl('canvas').scrollTop;
		//
  var dh = 0;
  var dw = 0;
  switch (draggingHandlerCorner) {
    case 0:
      // Angolo sinistro sopra
      if (newx < x + w - wgap && newy < y + h - hgap) { //controllo che non possa essere collassato il componente a una dimensione minore alle sue dimensioni minime
        delta[0] = newx - shadow.offsetLeft;
        delta[1] = newy - shadow.offsetTop;
        delta[2] = 0;
        delta[3] = 0;
        if (canAlign) {
          delta = drawSnap(delta, true);
        }
        dw = -delta[0];
        dh = -delta[1];
      }
  break;
  case 1:
      // Angolo destro sopra
      if (newx > x + wgap && newy < y + h - hgap) {
        // sposta l' handler
        delta[0] = 0;
        delta[1] = newy - shadow.offsetTop;
        delta[2] = newx - (shadow.offsetLeft + getOffset(shadow).w);
        delta[3] = 0;
        if (canAlign) {
          delta = drawSnap(delta, true);
        }
        dw = delta[2];
        dh = -delta[1];
      }
  break;
      // Angolo destro sotto
  case 2:
      if (newx > x + wgap && newy > y + hgap) {
        // sposta l' handler
        delta[0] = 0;
        delta[1] = 0;
        delta[2] = newx - (shadow.offsetLeft + getOffset(shadow).w);
        delta[3] = newy - (shadow.offsetTop + getOffset(shadow).h);
        if (canAlign) {
          delta = drawSnap(delta, true);
        }
        dw = delta[2];
        dh = delta[3];
      }
  break;
      // Angolo sinistro sotto
  case 3:
      if (newy > y + hgap && newx < x + w - wgap) {
        // sposta l' handler
        delta[0] = newx - shadow.offsetLeft;
        delta[1] = 0;
        delta[2] = 0;
        delta[3] = newy - (shadow.offsetTop + getOffset(shadow).h);
        if (canAlign) {
          delta = drawSnap(delta, true);
          }
        dw = -delta[0];
        dh = delta[3];
      }
  break;
      // Lato sotto
  case 6:
      if (newy > y + hgap) {
        // sposta l' handler
        delta[0] = 0;
        delta[1] = 0;
        delta[2] = 0;
        delta[3] = newy - (shadow.offsetTop + getOffset(shadow).h);
        if (canAlign) {
          delta = drawSnap(delta, true);
        }
        dw = 0;
        dh = delta[3];
      }
  break;
      // Lato sopra
  case 4:
      if (newy < y + h - hgap) {
        // sposta l' handler
        delta[0] = 0;
        delta[1] = newy - shadow.offsetTop;
        delta[2] = 0;
        delta[3] = 0;
        if (canAlign) {
          delta = drawSnap(delta, true);
        }
        dw = 0;
        dh = -delta[1];
      }
  break;
      // Lato sx
  case 7:
      if (newx < x + w - wgap) {
        // sposta l' handler
        delta[0] = newx - shadow.offsetLeft;
        delta[1] = 0;
        delta[2] = 0;
        delta[3] = 0;
        if (canAlign) {
          delta = drawSnap(delta, true);
        }
        dw = -delta[0];
        dh = 0;
      }
  break;
      // Lato dx
  case 5:
      if (newx > x + wgap) {
        // sposta l' handler
        delta[0] = 0;
        delta[1] = 0;
        delta[2] = newx - (shadow.offsetLeft + getOffset(shadow).w);
        delta[3] = 0;
        if (canAlign) {
          delta = drawSnap(delta, true);
        }
        dw = delta[2];
        dh = 0;
      }
  break;
  }

  //Spostamento e ridimensionamento
  //
  var xs = shadow.offsetLeft,
  ys = shadow.offsetTop,
  ws = getOffset(shadow).w,
  hs = getOffset(shadow).h;

  var ret = true;
  if (window.ValidMove) {
    ret = window.ValidMove(shadow.offsetLeft + delta[0], shadow.offsetTop + delta[1], shadow.offsetWidth, shadow.offsetHeight, itm.id);
  }
  if (ret == false) {
      return;
  }

  w = itm.offsetWidth;
  h = itm.offsetHeight;
  var xi = itm.offsetLeft,
  yi = itm.offsetTop,
  itemo = getOffset(itm),
  hi = itemo.h,
  wi = itemo.w;
  //
  xs = x + (delta[0] ? delta[0] : 0);
  ys = y + (delta[1] ? delta[1] : 0);
  xi = xi + (delta[0] ? delta[0] : 0);
  yi = yi + (delta[1] ? delta[1] : 0);
  //
  hs = hs + dh >= 0 ? hs + dh : 0;
  ws = ws + dw >= 0 ? ws + dw : 0;
  hi = hi + dh >= 0 ? hi + dh : 0;
  wi = wi + dw >= 0 ? wi + dw : 0;
  h = h + dh >= 0 ? h + dh : 0;
  w = w + dw >= 0 ? w + dw : 0;
  //
  // resize della shadow
  shadow.style.width = ws + 'px';
  shadow.style.height = hs + 'px';
  shadow.style.top = ys + 'px';
  shadow.style.left = xs + 'px';
  // modifica l' item
  itm.style.width = wi + 'px';
  itm.style.height = hi + 'px';
  itm.style.top = yi + 'px';
  itm.style.left = xi + 'px';
  // salvo le proprieta nell oggetto item
  mainItem.w = shadow.offsetWidth;
  mainItem.h = shadow.offsetHeight;
  mainItem.x = xi + itemo.gapw / 2;
  mainItem.y = yi + itemo.gaph / 2;
  mainItem.scale = clCanvasLib.scale;

  var z = GetZoomValue();
  signMarkWidth = mainItem.w*100/z;
  signMarkHeight = mainItem.h*100/z;

  var shadowH = (hs > 0 ? hs : 0) + 8; //tolgo i due pixel dei bordi
  var shadowW = (ws > 0 ? ws : 0) + 8; //tolgo i 2 pixel dei bordi

  Ctrl('handlersWrapper' + draggedItemIdx).style.top = shadow.offsetTop - 3 + 'px';
  Ctrl('handlersWrapper' + draggedItemIdx).style.left = shadow.offsetLeft - 3 + 'px';
  Ctrl('handlersWrapper' + draggedItemIdx).style.height = shadowH + 'px';
  Ctrl('handlersWrapper' + draggedItemIdx).style.width = shadowW + 'px';
  Ctrl('handler' + draggedItemIdx + '_5').style.top = shadowH / 2 - 4 + 'px'; // bordi
  Ctrl('handler' + draggedItemIdx + '_6').style.top = shadowH - 18 + 'px'; // posizionamento relativo  (18 = size*2 + bordi)
  Ctrl('handler' + draggedItemIdx + '_7').style.top = shadowH / 2 - 4 + 'px';

  EmptyRefLines();
  addRulersLines();
}

function setShadow() { //REDIFINED
  if(!Empty(mainitem)){
    resetAlign()
    Ctrl("canvas").onmousemove=null
    mainitem.onmouseup=null
    moveItems()
    for (var p=0;p<itemsHTML.length;p++) {
      if(itemsHTML[p].shadow != ""){
        var elementShadow=Ctrl(itemsHTML[p].shadow)
        if(elementShadow)
          elementShadow.innerHTML="";
      }
    }
    if( zTAssistant ) {
      var element = Ctrl('canvas');
      zTAssistant.Scroll(element.scrollTop, element.scrollLeft)
    }
    Properties()
    if(typeof(showProperties)!='undefined') showProperties('properties')
  }
}
/* *** Fine gestione Drag item *** */

/* *** Gestione Highlight *** */
function drawHighlight(x, y, w, h, pw, ph, page, rotation) {
  var ctrl2 = Ctrl('canvaslinks');
  var canvasLinksWidth = parseInt(ctrl2.style.width);
  var canvasLinksHeight = parseInt(ctrl2.style.height);
  var ctrl = Ctrl('pagenumber');
  if (ctrl && parseInt(ctrl.value) == page) {
    if (nrPagesToView == 4) {
      drawHighlightz(x, y, w, h, pw, ph, rotation, canvasLinksWidth / 2, canvasLinksHeight / 2, 'itemSearch' + currentPage, true);
    } else if (nrPagesToView == 2) {
      drawHighlightz(x, y, w, h, pw, ph, rotation, canvasLinksWidth, canvasLinksHeight, 'itemSearch' + currentPage, true);
    } else if (nrPagesToView == 1) {
      drawHighlightz(x, y, w, h, pw, ph, rotation, canvasLinksWidth * 2, canvasLinksHeight, 'itemSearch1', true);
    }
  } else {
    drawHL = false;
  }
}

function drawHighlightz(x, y, w, h, pw, ph, rotation, w2, h2, id, font) {
  var ctrl = Ctrl(id);
  if (ctrl) {
    x = parseFloat(x);
    y = parseFloat(y);
    w = parseFloat(w);
    h = parseFloat(h);
    pw = parseFloat(pw);
    ph = parseFloat(ph);
    w2 = parseFloat(w2);
    h2 = parseFloat(h2);
    var lh = parseInt(ctrl.style.lineHeight);
    y = y - h;
    rotation = rotation + '';
    if (font == true) {
      h = h + 2 * h; //font campi search
    }
    var nx, ny, nw, nh, nlh;

    if (rotation == '0') {
      nx = x * (w2 / 2) / pw;
      ny = h2 - (y + h) * h2 / ph;
      nw = w * (w2 / 2) / pw;
      nh = h * h2 / ph;
      nlh = lh * h2 / ph;
    } else if (rotation == '90') {
      nx = y * (w2 / 2) / ph;
      ny = x * h2 / pw;
      nw = h * (w2 / 2) / ph;
      nh = w * h2 / pw;
      nlh = lh;
    } else if (rotation == '180') {
      nx = w2 / 2 - (x + w) * (w2 / 2) / pw;
      ny = y * h2 / ph;
      nw = w * (w2 / 2) / pw;
      nh = h * h2 / ph;
      nlh = lh * h2 / ph;
    } else if (rotation == '270') {
      nx = w2 / 2 - (y + h) * (w2 / 2) / ph;
      ny = h2 - (x + w) * h2 / pw;
      nw = h * (w2 / 2) / ph;
      nh = w * h2 / pw;
      nlh = lh;
    }

    ctrl.style.width = (nw-2) + 'px';//2 px border by css o browser
    ctrl.style.height = (nh-2) + 'px';//2 px border by css o browser
    ctrl.style.left = nx + 'px';
    ctrl.style.top = ny + 'px';
    ctrl.style.lineHeight = nlh + 'px';

    if (isMrpLoad == true) {
      var ctrlz = Ctrl(id + '_input');
      if (ctrlz) {
        ctrlz.style.left = '0px';
        ctrlz.style.top = '0px';
        ctrlz.style.position = 'relative';
        if( ctrlz.tagName != 'SELECT' ){
          ctrlz.style.width = (nw-2) + 'px';
          ctrlz.style.height = (nh-2) + 'px';
        }
        else {
        ctrlz.style.width = (nw-2) + 'px';
        ctrlz.style.height = (nh) + 'px';
        }
      }
      
      ctrlz = Ctrl(id + '_inputlabel');
      if (ctrlz) {
        ctrlz.style.width = (nw-2) + 'px';
        ctrlz.style.height = (nh-2) + 'px';
      }
    }

    if (id.indexOf('Search') > 0) {
      ctrl.scrollIntoView(false);
    }
  }
}

function removeHighlight() {
  var ctrl;
  for (var i = 0; i < 4; i++) {
    ctrl = Ctrl('itemSearch' + i);
    if (ctrl) {
      ctrl.style.width = 0;
      ctrl.style.height = 0;
      ctrl.style.left = 0;
      ctrl.style.top = 0;
    }
  }
}
/* *** Fine gestione Highlight *** */

/* *** Gestione Xml *** */
function xml_encode(input) {
  if (typeof input == 'undefined') {
    alert('error in xml_encode: input undefined');
    return;
  }
  input = Trim(input.toString());

  var replace_with = '&amp;';
  /* The 'g' in the first argument is used to tell the function 'replace' that all occurences (g = global)
     of the character in between slashes have to be replaced.*/
  input = input.replace(/&/g, replace_with);

  replace_with = '&lt;';
  input = input.replace(/</g, replace_with);

  replace_with = '&gt;';
  input = input.replace(/>/g, replace_with);

  replace_with = '&apos;';
  input = input.replace(/'/g, replace_with);

  replace_with = '&quot;';
  input = input.replace(/"/g, replace_with);

  replace_with = '&#10;';
  input = input.replace(/\\n/g, replace_with);

  return input;
}

function sendDataToOpener() {
  fieldsListXml = Strtran(Strtran(fieldsListXml, '\u0080', '\u20AC'), '\u000A', '&#10;');
  if( PSCtrl && PSCtrl.dispatchEvent) {
    if ( dpMode == 0 ) { //print
      PSCtrl.dispatchEvent('Print', jsCompileObj, jsUpdSignmarksObj);
    }
    else if ( dpMode == 1 ) { //download
      PSCtrl.dispatchEvent('Download', jsCompileObj, jsUpdSignmarksObj);
    }
    else if ( dpMode == 2 ) { //save
      PSCtrl.dispatchEvent('Save', jsCompileObj, jsUpdSignmarksObj);
    }
  }
  else if (window.GetOpener() != null && isMrpLoad == true) {
    if (window.GetOpener().getFieldsXML) {
      window.GetOpener().getFieldsXML(mrpfile, window, fieldsListXml, mkey, dpMode, isValidDocument);
    } else {
      // Tento di lanciare la funzione nella action code del portlet di partenza
      var portletsList = window.GetOpener().ZtVWeb.getPortlet();
      var ptl;
      for (var x in portletsList) {
        ptl = portletsList[x];
        if (window.GetOpener().ZtVWeb.getPortlet(ptl.portletname).getFieldsXML) {
          window.GetOpener().ZtVWeb.getPortlet(ptl.portletname).getFieldsXML(mrpfile, window, fieldsListXml, mkey, dpMode, isValidDocument);
        }
      }
    }
  }
}

function SearchGoto() {
  var ctrl = Ctrl('searchnumber');
  if (xmlobj1 != null) {
    var num = parseInt(ctrl.value);

    if (num <= 0 || num > xmlobj1.nrec) {
      alert('Value out of range...');
    } else if (xmlobj1.nrec > 0) {
      var n = xmlobj1.FirstPage();
      for (var z = 1; z < num; z++) {
        n = xmlobj1.Next();
      }

      if (n == true) {
        removeHighlight();
        drawHL = true;
        GoToPage(xmlobj1.rs.Page);
      } else {
        //alert('No more search result...');
      }
    }

    if (xmlobj1.nrec > 0) {
      if (ctrl) {
        ctrl.innerHTML = '' + xmlobj1.curRec;
      } else if (ctrl) {
        ctrl.innerHTML = '0';
      }
    }
  } else if (ctrl) {
    ctrl.innerHTML = '0';
  }
  updateWordSpan(xmlobj1.nrec)
}
/* *** Fine gestione Xml *** */

/* *** Gestione Properties *** */
function setPropertiesID(obj) { //ricreo properties per compatibilita' con il vecchio array
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    var tab, ii;
    mainObject.objClass.properties = [];
    for (var i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        mainObject.objClass.properties.push(tab[ii].propID);
      }
    }
  }
}

function Properties() {
}

function Formproperties() {
}
/* *** Fine Gestione Properties *** */

/* *** Gestione dei colori *** */
var rgbPattern = /\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*/i;
function rgbToHex(color) {
  if (color.substr(0, 1) === '#') {
    return color;
  }
  if (color.substr(0, 3) === 'rgb') {} else {
    color = 'rgb(' + color + ')';
  }
  try {
    var digits = /(.*?)rgb\((\d+),(\d+),(\d+)\)/.exec(color);
    var red = parseInt(digits[2]);
    var green = parseInt(digits[3]);
    var blue = parseInt(digits[4]);

    var rgb = blue | green << 8 | red << 16;
    var tmp = '000000' + rgb.toString(16);
    tmp = tmp.substring(tmp.length - 6);
    return digits[1] + '#' + tmp;
  } catch (e) {
    return '#000000';
  }
}

function toHex(dec) {
  var result = parseInt(dec).toString(16);
  if (result.length == 1) {
    result = '0' + result;
  }
  return result.toUpperCase();
}

function toRgb(hex) {
  var r, g, b;
  if (hex == '') {
    return '';
  }
  hex = hex.substring(1);
  if (hex.length == 3) {
    hex = hex[0] + hex[0] + hex[1] + hex[1] + hex[2] + hex[2];
  }
  r = parseInt(hex.substring(0, 2), 16);
  g = parseInt(hex.substring(2, 4), 16);
  b = parseInt(hex.substring(4, 6), 16);
  return r + ',' + g + ',' + b;
}
/* *** Fine Gestione dei colori *** */

/* *** Gestione Unita' di misura *** */
function convertItemUnitZoom(value, scale) {
  value = parseFloat(value);
  return Round(convertFromPoints(value) * (100 / scale), 2);
}

function convertUnitZoom(value) {
  value = parseFloat(value);
  return Round(convertFromPoints(value) * (100 / clCanvasLib.scale), 2);
}

function convertUnit(value) {
  value = parseFloat(value);
  return Round(convertFromPoints(value), 2);
}

function reconvertUnitZoom(value) {
  value = parseFloat(value);
  return convertInPoints(value) * (clCanvasLib.scale / 100);
}

function reconvertUnit(value) {
  value = parseFloat(value);
  return convertInPoints(value);
}

function convertInPoints(ab) {
  if (workUnit == 'mm') {
    return ab * 2.834;
  } else if (workUnit == 'cm') {
    return ab * 28.34;
  } else if (workUnit == 'pc') {
    return ab * 12;
  } else if (workUnit == 'inch') {
    return ab * 72;
  }

    return ab;
  }

function convertFromPoints(ab) {
  if (workUnit == 'mm') {
    return ab / 2.834;
  } else if (workUnit == 'cm') {
    return ab / 28.34;
  } else if (workUnit == 'pc') {
    return ab / 12;
  } else if (workUnit == 'inch') {
    return ab / 72;
  }

    return ab;
  }
/* *** Fine Gestione Unita' di misura *** */

/* *** Gestione Documento *** */
function ReloadDoc() {
  if (canaddstamp == true && itemsHTML.length > 0) { //remove stamp form viewer
    if (index == null) {
      index = 0;
      if (itemsHTML.length > 0) {
        itemsHTML[0].shadow = 'todelete';
      }
    }
    deleteItem();
  } else if (myZBoViewWindow && myZBoViewWindow.ReloadDoc) {
    myZBoViewWindow.ReloadDoc();
  }
}

function RemoveDoc() {
  if (confirm('Confirm removing current document?')) {
    LoadPdf(null, false);
    if (myZBoViewWindow && myZBoViewWindow.RemoveDoc) {
      myZBoViewWindow.RemoveDoc();
    }
  }
}
/* *** Fine Gestione Documento *** */

/* *** Gestione Pagine *** */
function enableNextPrev() {
  //Ctrl('prevBtn').setStyle('display', 'inline-block');
  //Ctrl('nextBtn').setStyle('display', 'inline-block');
  //Ctrl('prevBtn').setStyle('opacity', '0.3');
  //Ctrl('nextBtn').setStyle('opacity', '0.3');
  Ctrl('prvBtn').onclick = function () {
    Previous();
  };
  Ctrl('nxtBtn').onclick = function () {
    Next();
  };
  Ctrl('prevBtn').onclick = function () {
    Previous();
  };
  Ctrl('nextBtn').onclick = function () {
    Next();
  };

  if (maxPages <= 1) {
    //Ctrl('prevBtn').setStyle('display', 'none');
    //Ctrl('nextBtn').setStyle('display', 'none');
    Ctrl('prvBtn').onclick = function () {
      return false;
    };
    Ctrl('nxtBtn').onclick = function () {
      return false;
    };
  } else if (nrPagesToView == 1) {
      if (page0 <= 1) {
        Ctrl('prevBtn').onclick = function () {
          return false;
        };
        Ctrl('prvBtn').onclick = function () {
          return false;
        };
      }
      if (page0 >= maxPages) {
        Ctrl('nextBtn').onclick = function () {
          return false;
        };
        Ctrl('nxtBtn').onclick = function () {
          return false;
        };
      }
  } else if (nrPagesToView == 2) {
      if (page0 <= 1) {
        Ctrl('prevBtn').onclick = function () {
          return false;
        };
        Ctrl('prvBtn').onclick = function () {
          return false;
        };
      }
      if (page1 >= maxPages) {
        Ctrl('nextBtn').onclick = function () {
          return false;
        };
        Ctrl('nxtBtn').onclick = function () {
          return false;
        };
      }
  } else if (nrPagesToView == 4) {
      if (page0 <= 1) {
        Ctrl('prevBtn').onclick = function () {
          return false;
        };
        Ctrl('prvBtn').onclick = function () {
          return false;
        };
      }
      if (page3 >= maxPages) {
        Ctrl('nextBtn').onclick = function () {
          return false;
        };
        Ctrl('nxtBtn').onclick = function () {
          return false;
        };
    }
  }
}

function getNameNewPage(name, page) {
  var nName = name;
  var pn = nName.lastIndexOf('.' + page);
  if (pn > 0) {
    nName = nName.substring(0, pn);
  }
  return nName;
}

function RemovePage() {
  var p = Ctrl('pagenumber').value;
  rempages.push(p);
  if (modebook == true) {
    Ctrl('dcancelpage' + currentPage).style.display = 'inline-block';
  } else {
    Ctrl('dcancelpage1').style.display = 'inline-block';
  }
  if (myZBoViewWindow && myZBoViewWindow.RemovePage) {
    myZBoViewWindow.RemovePage(p);
  }
  EnableOnToolbar('bapage');
  DisableOnToolbar('bcpage');
}

function EnablePage() {
  var p = Ctrl('pagenumber').value;
  var ix = rempages.indexOf(p);
  rempages.splice(ix, 1);
  if (modebook == true) {
    Ctrl('dcancelpage' + currentPage).style.display = 'none';
  } else {
    Ctrl('dcancelpage1').style.display = 'none';
  }
  if (myZBoViewWindow && myZBoViewWindow.unRemovePage) {
    myZBoViewWindow.unRemovePage(p);
  }
  if (EnablePagesButtons()) {
    EnableOnToolbar('bcpage');
    DisableOnToolbar('bapage');
  }
}
/* *** Fine Gestione Pagine *** */

/* *** Toolbar *** */
function EnableToolbarPdfState() {
  if (maxPages <= 0) {
    DisableOnToolbar('PrintBtn');
    DisableOnToolbar('DownloadBtn');
    DisableOnToolbar('TSearchBtn');
    DisableOnToolbar('TPrevBtn');
    DisableOnToolbar('TNextBtn');
    DisableOnToolbar('TPageBtn');
    DisableOnToolbar('TOfBtn');
    DisableOnToolbar('SaveBtn');
    DisableOnToolbar('bcdoc');
    DisableOnToolbar('bcpage');
    DisableOnToolbar('bapage');
    return;
  }
  if (isSecureDoc == 1 ) {
    DisableOnToolbar('PrintBtn');
  } else if (canprint == true) {
    EnableOnToolbar('PrintBtn');
  }
  EnableOnToolbar('bcdoc');
  if (canremove == false) {
    DisableOnToolbar('bcdoc');
  }
  EnableOnToolbar('TPrevBtn');
  EnableOnToolbar('TNextBtn');
  EnableOnToolbar('TPageBtn');
  EnableOnToolbar('PrintBtn');
  EnableOnToolbar('DownloadBtn');
  EnableOnToolbar('TSearchBtn');
  EnableOnToolbar('TOfBtn');
}

function EnableOnToolbar(id) {
  if (!Ctrl(id)) {
    return;
  }
  if (Ctrl(id) && Ctrl(id).style.opacity == 0.2) {
    Ctrl(id).style.opacity = 1;
    EnableAllDIVLinks(id);
  }
  var i;
  for (i=0; i<zTitleToolBar1.length; i++) {
    if (zTitleToolBar1[i].id == id) {
      if( zTitlePortlet ) zTitlePortlet.UpdateButton(id, {"image":zTitleToolBar1[i].image, "action": zTitleToolBar1[i].action})
      else zSPToolbar.UpdateItem(id, {"image":zTitleToolBar1[i].image, "action": zTitleToolBar1[i].action})
      return;
    } 
  }
  for (i=0; i<zTitleToolBar2.length; i++) {
    if (zTitleToolBar2[i].id == id) {
      if( zTitlePortlet ) zTitlePortlet.UpdateButton(id, {"image":zTitleToolBar2[i].image, "action": zTitleToolBar2[i].action})
      else zSPToolbar.UpdateItem(id, {"image":zTitleToolBar2[i].image, "action": zTitleToolBar2[i].action})
      return;
    } 
  }
}

function DisableOnToolbar(id) {
  if (Ctrl(id) && Ctrl(id).style.opacity != 0.2) {
    Ctrl(id).style.opacity = 0.2;
    DisableAllDIVLinks(id);
  }
  var i;
  for (i=0; i<zTitleToolBar1.length; i++) {
    if (zTitleToolBar1[i].id == id) {
      //zTitleToolBar1[i].image.Color = 'rgba(0,0,0,.2)'
      if( zTitlePortlet ) zTitlePortlet.UpdateButton(id, {"image":zTitleToolBar1[i].image, "action": null})
      else zSPToolbar.UpdateItem(id, {"image":zTitleToolBar1[i].image, "action": null})
      return;
    } 
  }
  for (i=0; i<zTitleToolBar2.length; i++) {
    if (zTitleToolBar2[i].id == id) {
      //zTitleToolBar2[i].image.Color = 'rgba(0,0,0,.2)'
      if( zTitlePortlet ) zTitlePortlet.UpdateButton(id, {"image":zTitleToolBar2[i].image, "action": null})
      else zSPToolbar.UpdateItem(id, {"image":zTitleToolBar2[i].image, "action": null})
      return;
    } 
  }
}

function ZBORemoveBackButton()  {
  if( zTitlePortlet ) zTitlePortlet.RemoveButton('bcloselayer');
  else zSPToolbar.Remove('bcloselayer')
}

function ZBOAddBackButton()  {
  if( zTitlePortlet ) zTitlePortlet.AppendButton(zTitleToolBar1[0], 0);
  else zSPToolbar.Append(zTitleToolBar1[0], 0);
}

function HideOnToolbar(id) {
  if (Ctrl(id)) {
    Ctrl(id).style.display = 'none';
  }
  var i;
  for (i=0; i<zTitleToolBar1.length; i++) {
    if (zTitleToolBar1[i].id == id) {
      zTitleToolBar1.splice(i, 1);
      return;
    } 
  }
  for (i=0; i<zTitleToolBar2.length; i++) {
    if (zTitleToolBar2[i].id == id) {
      zTitleToolBar2.splice(i, 1);
      return;
    } 
  }
}

function ShowOnToolbar(id) {
  if (Ctrl(id)) {
    Ctrl(id).style.display = 'inline-block';
  }
}

function DisableAllDIVLinks(DivId) {
  var div = document.getElementById(DivId);
  var anchorList = div.getElementsByTagName('span');
  for (var i = 0; i < anchorList.length; i++) {
    anchorList[i].disabled = true;
    anchorList[i].setAttribute('backup_onclick', anchorList[i].getAttribute('onclick'));
    anchorList[i].removeAttribute('onclick');
    anchorList[i].addClass('cursorDefault');
  }
}

function EnableAllDIVLinks(DivId) {
  var div = document.getElementById(DivId);
  var anchorList = div.getElementsByTagName('span');
  for (var i = 0; i < anchorList.length; i++) {
    anchorList[i].disabled = false;
    anchorList[i].setAttribute('onclick', anchorList[i].getAttribute('backup_onclick'));
    anchorList[i].removeAttribute('backup_onclick');
    anchorList[i].removeClass('cursorDefault');
  }
}

function EnablePagesButtons() {
  var id = 'bcdoc';
  if (Ctrl(id)) {
    if (Ctrl(id).style.opacity == 0.2) { //enable
      return false;
    }
      return true;
    }
  return false;
}

function _TranslateMsgTooltip(text)  {
  if ( MSG_ZPDF_TRANSLATE[text+'_TOOLTIP'] )
    return MSG_ZPDF_TRANSLATE[text+'_TOOLTIP'];
  return _TranslateMsg(text);
}

function _TranslateMsg(text)  {
  if ( MSG_ZPDF_TRANSLATE[text] )
    return MSG_ZPDF_TRANSLATE[text];
  return text;
}

function PreLoadToolbar() {
  zTitleToolBar1 = [];
  zTitleToolBar2 = [];
  function _getStyleImage(id) {
    var ret = {
     "FontName":"icons8_win10","FontWeight":"normal","Size":"20"
    };
    switch(id){
      case "bcloselayer":
        ret.Char = '60635';
        break;
      case "viewMode":
        ret.Char = '60480';
        break;
      case "bsign":
        ret.Char = '59946';
        break;
      case "brsign":
        ret.Char = '61670';
        break;
      case "bscan":
        ret.Char = '59882';
        break;
      case "bcdoc":
        ret.value = '&#xf041';
        break;
      case "bcpage":
        ret.Char = '61509';
        break;
      case "bapage":
        ret.Char = '59669';
        break;
      case "SaveBtn":
        ret.Char = '60595';
        break;
      case "zoomview":
        break;
      case "TPrevBtn":
        ret.Char = '61764';
        break;
      case "TPageBtn":
        break;
      case "TOfBtn":
        break;
      case "TNextBtn":
        ret.Char = '61765';
        break;
      case "PrintBtn":
        ret.Char = '60427';
        break;
      case "DownloadBtn":
        ret.Char = '61598';
        break;
      case "TSearchBtn":
        ret.Char = '59899';
        break;
      case "TSignBtn":
        ret.Char = '62136';
        break;
      case "TZoomIn":
        ret.value = '&#xe9e8';
        break;
      case "TZoomOut":
        ret.value = '&#xe9e9';
        break;
      case "TGoToPageBtn":
        ret.value = '&#xeeb6';
        break;
      case "AssistantBtn":
        ret.value = '&#xf47b';
        break;
      default:
        break;
    }
    return ret;
  }
  function _load( ll , ztool) {
      var i, j, l, o, els;
      for ( i=0; i<ll.length; i++) {
        l = ll[i];
        o = {};
        o.title = _TranslateMsg(l.title);
        o.tooltip = _TranslateMsgTooltip(l.title);
        o.id = l.id;
        o.image = _getStyleImage(l.id);
        if ( l.onclick ) {
            o.action = l.onclick;
        }
        else {
          els = l.childNodes;
          for ( j= 0; j<els.length; j++) {
            if ( els[j].onclick ) {
                o.action = els[j].onclick;
            }
          }
        }
        if( o.action ) {
          zTitlePortletItems[o.id] = o;
          ztool.push(o);
        }
      }
  }
  var ll = document.getElementById("objList").getElementsByTagName("li");
  var ll2 = document.getElementById("objList2").getElementsByTagName("li");
  _load(ll, zTitleToolBar1);
  _load(ll2, zTitleToolBar2);
}

function EnableAssistant() {
  if( zTAssistant )
    zTAssistant.EnableAssistant();
}
/*function NextField(){
  var i, j, page;
  for ( i=page0; i<maxPages; i++ ) {
    for ( j=0; itemsHTMLArray[i] && j<itemsHTMLArray[i].length; j++ ) {
      if (itemsHTMLArray[i][j].editfield + '' == 'true') {
        page = i;
        j = itemsHTMLArray[i].length;
        i = maxPages-1;
      }
    }
  }
  if( page != undefined ) {
    GotoPage(page);
    return;
  }
  for ( i=0; i<=page0; i++ ) {
    for ( j=0; itemsHTMLArray[i] && j<itemsHTMLArray[i].length; j++ ) {
      if (itemsHTMLArray[i][j].editfield + '' == 'true') {
        page = i;
        j = itemsHTMLArray[i].length;
        i = page0-1;
      }
    }
  }
  if( page != undefined ) {
    GotoPage(page);
    return;
  }
}*/

function onClickPrint(){
  if(maxPages > 0 && isSecureDoc == 0 && canprint == true){
    if(printdownall==true){
      $('printAllz').checked=true;
      $('zprintAllz').checked=false;
      setCheck($('printAllz'), 'printF', 'printT');
      dpMode = 0;
      DownloadPrint();
      return;
    }
    if(this.retrieve('printlink-opened')){
      closePrintPane();
    }
    else{
      $('DownloadBtn').setStyle('background','none');
      //$('searchPane').classList.add("hide");
      //$('signPane').classList.add("hide");
      $('printAllz').checked=false;
      setCheck($('printAllz'), 'printF', 'printT');
      setFromTo("printF", "printT");
      $('printPane').classList.remove("hide");
      $('downloadPane').classList.add("hide");
      dpMode = 0;
      this.store('printlink-opened',true);
      $('downloadlink').store('downloadlink-opened',false);
      $('searchOpClz').store('searchOpCl-opened',false);
    }
  }
  else {
    alert('Option not available for this document');
  }
} 

function onClickDownload(){
  if (maxPages > 0 && isSecureDoc == 0 && candownload == true){
    if (printdownall == true){
      $('zprintAllz').checked=true;
      $('printAllz').checked=false;
      setCheck($('zprintAllz'), 'zprintF', 'zprintT');
      dpMode = 1;
      DownloadPrint();
      return;
    }
    if (this.retrieve('downloadlink-opened')){
      closePrintPane();
    }
    else{
      $('PrintBtn').setStyle('background','none');
      $('zprintAllz').checked=false;
      setCheck($('zprintAllz'), 'zprintF', 'zprintT');
      setFromTo("zprintF", "zprintT");
      $('printPane').classList.add("hide");
      //$('searchPane').classList.add("hide");
      //$('signPane').classList.add("hide");
      $('downloadPane').classList.remove("hide");
      dpMode = 1;
      this.store('downloadlink-opened',true);
      $('printlink').store('printlink-opened',false);
      $('searchOpClz').store('searchOpCl-opened',false);
    }
  }
  else {
    alert('Option not available for this document');
  }
} 

function LoadPortletToolbar() {
  var i;
  if ( zTitlePortlet ) {
    zTitlePortlet.Clean();
    for (i=0; i<zTitleToolBar1.length; i++)  {
      zTitlePortlet.AppendButton(Object.assign({}, zTitleToolBar1[i]));
      /*if (  zTitleToolBar1[i].image.Color == 'rgba(0,0,0,.2)' )  {
        zTitlePortlet.UpdateButton(zTitleToolBar1[i].id, {"action":null});
      }*/
    }
    for (i=0; i<zTitleToolBar2.length; i++)  {
      zTitlePortlet.AppendButton(Object.assign({}, zTitleToolBar2[i]));
      /*if (  zTitleToolBar2[i].image.Color == 'rgba(0,0,0,.2)' )  {
        zTitlePortlet.UpdateButton(zTitleToolBar2[i].id, {"action":null});
      }*/
    }
  }
  else {
    zSPToolbar.Clean();
    for (i=0; i<zTitleToolBar1.length; i++)  {
        zSPToolbar.Append(Object.assign({}, zTitleToolBar1[i]));
      /*if (  zTitleToolBar1[i].image.Color == 'rgba(0,0,0,.2)' )  {
        zSPToolbar.UpdateItem(zTitleToolBar1[i].id, {"action":null});
      }*/
    }
    for (i=0; i<zTitleToolBar2.length; i++)  {
        zSPToolbar.Append(Object.assign({}, zTitleToolBar2[i]));
      /*if (  zTitleToolBar2[i].image.Color == 'rgba(0,0,0,.2)' )  {
        zSPToolbar.UpdateItem(zTitleToolBar2[i].id, {"action":null});
      }*/
    }
  }
}

function initToolbarBtn() {
  PreLoadToolbar();
  if ( m_cDecoration == true ) {
    if ( PSPortlet && UsePTitle) {
        Ctrl('PortletTitle').style.display = 'none';
        zTitlePortlet =  PSPortlet.getTitlePortlet();
    }
    else if( window.ZtVWeb ) {
      Ctrl('PortletTitle').style.display = 'block';
      var tportlet = window.ZtVWeb.getPortletWindow('zpdfviewer_title');
      if (  tportlet ) {
        zTitlePortlet = tportlet.getTitlePortlet();
      }
    }
  }
  if (!zTitlePortlet)  {
    zSPToolbar = new ZtVWeb.SPToolbarCtrl(form,{"FAB":"","anchor":"top-left(%)-right(%)","bg_color":"","cssClass":"sptoolbar","ctrlid":"IMenu_SPToolbar","h":40,"hide":"false","iconWidth":30,"layer":false,"maxToolbarItem":0,"menu_bg_color":"","name":"SPToolbarZ","page":1,"toolbarAlign":"left","type":"SPToolbar","w":40,"x":732,"y":9,"zindex":"999999999"});
    form[zSPToolbar.name] = zSPToolbar;
  }
  HideOnToolbar('bscan');
  
 if (canchangeviewmode == true) {
    ShowOnToolbar('viewMode');
    EnableOnToolbar('viewMode');
  }
  else  {
    HideOnToolbar('viewMode');
  }
  if (boviewer == true) {
    ShowOnToolbar('bcloselayer');
    EnableOnToolbar('bcloselayer');
  }
  else  {
    HideOnToolbar('bcloselayer');
  }
  if (canaddstamp == true) {
    ShowOnToolbar('bsign');
    DisableOnToolbar('bsign');
    //ShowOnToolbar('brsign');
    //DisableOnToolbar('brsign');
    HideOnToolbar('brsign');
  }
  else  {
    HideOnToolbar('bsign');
    HideOnToolbar('brsign');
  }
  if (canmodpages == true) {
    ShowOnToolbar('bcpage');
    EnableOnToolbar('bcpage');
    ShowOnToolbar('bapage');
    DisableOnToolbar('bapage');
  }
  else  {
    HideOnToolbar('bcpage');
    HideOnToolbar('bapage');
  }
  ShowOnToolbar('zoomview');
  EnableOnToolbar('zoomview');
  
  if (cansave == true) {
    ShowOnToolbar('SaveBtn');
    EnableOnToolbar('SaveBtn');
  }
  else  {
    HideOnToolbar('SaveBtn');
  }
  if(canprint == true){
    ShowOnToolbar('PrintBtn');
    EnableOnToolbar('PrintBtn');
  } else {
    HideOnToolbar('PrintBtn');
    DisableOnToolbar('PrintBtn');
  }
  if(candownload == true){
    ShowOnToolbar('DownloadBtn');
    EnableOnToolbar('DownloadBtn');
  } else {
    HideOnToolbar('DownloadBtn');
    DisableOnToolbar('DownloadBtn');
  }
  if ( canremove == true ) {
    ShowOnToolbar('bcdoc');
    EnableOnToolbar('bcdoc');
  }
  else  {
    HideOnToolbar('bcdoc');
  }
  if (cansearch){
    ShowOnToolbar('TSearchBtn');
    EnableOnToolbar('TSearchBtn');
  } else {
    HideOnToolbar('TSearchBtn');
    DisableOnToolbar('TSearchBtn');
  }
  ShowOnToolbar('TZoomIn');
  EnableOnToolbar('TZoomIn');
  ShowOnToolbar('TZoomOut');
  EnableOnToolbar('TZoomOut');
  ShowOnToolbar('TSeparator1');
  EnableOnToolbar('TSeparator1');
  ShowOnToolbar('TPrevBtn');
  EnableOnToolbar('TPrevBtn');
  ShowOnToolbar('TPageBtn');
  EnableOnToolbar('TPageBtn');
  ShowOnToolbar('TOfBtn');
  EnableOnToolbar('TOfBtn');
  ShowOnToolbar('TGoToPageBtn');
  EnableOnToolbar('TGoToPageBtn');
  ShowOnToolbar('TNextBtn');
  EnableOnToolbar('TNextBtn');
  ShowOnToolbar('TSeparator2');
  EnableOnToolbar('TSeparator2');

  if( !zTAssistant || (zTAssistant && (zTAssistant.IsEmpty() && !canaddstamp)) ){
    HideOnToolbar('AssistantBtn');
    DisableOnToolbar('AssistantBtn');
  }
}

function EnableToolbar(m_cAction) {
  if(m_cAction == 'edit' || m_cAction == 'new') {
    EnableOnToolbar('bcdoc');
  } else {
    DisableOnToolbar('bcdoc');
  }
}
/* *** Fine Toolbar *** */

/* *** Toolbar a fine pagina *** */
function KeyPress(val, e) {
  var keycode;
  if (window.event) {
    keycode = window.event.keyCode;
  } else if (e) {
    keycode = e.which;
  } else {
    return;
  }

  if (keycode == 13 || keycode == 9) {
    if (isNaN(val.value)) {
      alert('Invalid number format');
    } else {
      removeHighlight();
      drawHL = false;
      GoToPage(val.value);
    }
  } else {

  }
}

function KeyPressValidFrom(val, e) {
  var keycode;
  if (window.event) {
    keycode = window.event.keyCode;
  } else if (e) {
    keycode = e.which;
  } else {
    return;
  }
  if (keycode == 13 || keycode == 9) {
    ValidTo(val);
  } else {

  }
}

function KeyPressValidTo(val, e, sFrom) {
  var keycode;
  if (window.event) {
    keycode = window.event.keyCode;
  } else if (e) {
    keycode = e.which;
  } else {
    return;
  }
  if (keycode == 13 || keycode == 9) {
    ValidTo(val);
    var ctrl = Ctrl(sFrom);
    if (ctrl) {
      ValidFromTo(parseInt(ctrl.value), parseInt(val.value));
    }
  } else {

  }
}

function ValidTo(inputval) {
  if (isNaN(inputval.value)) {
    alert('Invalid number format');
    return false;
  }

    var v = parseInt(inputval.value);
    if (v <= 0) {
    alert('Value out of range...');
      return false;
    }
    if (v > maxPages) {
    alert('Value out of range...');
      return false;
    }

  return true;
}

function ValidFromTo(intfrom, intto) {
  if (intfrom > intto) {
    alert('Value To must be greater than Value From...');
    return false;
  }
  return true;
}

function setFromTo(sfrom, sto) {
  var fr = 1;
  var to = page1;
  if (nrPagesToView == 4 && modebook == true) {
    to = page3;
  }
  if (to > maxPages) {
    to = maxPages;
  }
  if (page0 > 0) {
    fr = page0;
  }

  var ctrl = Ctrl(sfrom);
  if (ctrl) {
    ctrl.value = '' + fr;
  }
  ctrl = Ctrl(sto);
  if (ctrl) {
    ctrl.value = '' + to;
  }

}

function closePrintPane() {
  Ctrl('printPane').addClass('hide');
  Ctrl('downloadPane').addClass('hide');
  Ctrl('DownloadBtn').setStyle('background', 'none');
  Ctrl('PrintBtn').setStyle('background', 'none');
  Ctrl('downloadlink').store('downloadlink-opened', false);
  Ctrl('printlink').store('printlink-opened', false);
}

function GoToPage(pageNumber, currPage, fieldId) {
  currentPage = 0;
  removeHighlight();
  if (maxPages <= 0) {
    return;
  }
  showLoadingDiv();
  var fnToDelayG = function () {
    pageNumber = parseInt('' + pageNumber);
    var pair;
    if (modebook == true && nrPagesToView == 2) {
      if (pageNumber < 0) {
        page0 = 0;
        page1 = 1;
      } else if (pageNumber >= maxPages) {
        pair = maxPages % 2;
        if (pair == 0) {
          page0 = maxPages;
          page1 = maxPages + 1;
          currentPage = 0;
        } else {
          page0 = maxPages - 1;
          page1 = maxPages;
          currentPage = 1;
        }
      } else {
        pair = pageNumber % 2;
        if (pair == 0) {
          page0 = pageNumber;
          page1 = pageNumber + 1;
          currentPage = 0;
        } else {
          page0 = pageNumber - 1;
          page1 = pageNumber;
          currentPage = 1;
        }
      }
    } else if (modebook == true && nrPagesToView == 4) {
      pair = 0;
      if (pageNumber < 0) {
        page0 = 1;
      } else {
        if (pageNumber >= maxPages) {
          pageNumber = maxPages;
        }
        pair = pageNumber % 4;
        if (pair == 0) {
          pair = 4;
        }
        page0 = pageNumber - pair + 1;
        if (page0 <= 0) {
          page0 = 1;
        }
      }
      currentPage = pair - 1;
      page1 = page0 + 1;
      page2 = page1 + 1;
      page3 = page2 + 1;
    } else { // nrPagesToView==1
      if (pageNumber <= 1) {
        page0 = 1;
      } else if (pageNumber >= maxPages) {
        page0 = maxPages;
      } else {
        page0 = pageNumber;
      }
      page1 = page0;
    }
    if (currPage && typeof currPage != 'undefined') {
      currentPage = currPage;
    }
    initCanvas();
    resizeCanvas();
    hideLoadingDiv();
    eventPage();
    scrollToCurImg();
 
    if ( fieldId != undefined ) {
      var ctrl = Ctrl(fieldId+'_input');
      if( ctrl && !isHidden(ctrl) && !ctrl.disabled ) {
        ctrl.focus();
      }
    }

  };
  fnToDelayG.delay(750);
}

function Previous() {
  removeHighlight();
  drawHL = false;
  var currP = 0;
  GoToPage(page0 - 1, currP);
}

function Next() {
  removeHighlight();
  drawHL = false;
  var currP = 0;
  if (nrPagesToView == 4 && modebook == true) {
    GoToPage(page3 + 1, currP);
  } else {
    GoToPage(page1 + 1, currP);
  }
}

function SaveCompilation(overwriteFile, editFields, signmarksToAcroFields) {
  dpMode = 2;
  DownloadPrint(overwriteFile, editFields, signmarksToAcroFields);//sendDataToOpener();
}

function DownloadPrint(overwriteFile, editfields, signmarksToAcroFields) {
  if( overwriteFile == undefined || overwriteFile == null )
    overwriteFile = true;
  if( editfields == undefined || editfields == null )
    editfields = false;
  if( signmarksToAcroFields == undefined || signmarksToAcroFields == null )
    signmarksToAcroFields = false;
    
  var $$ = PluginDetect;
  var AnyPDFreader = !!($$.isMinVersion('PDFjs', '0', 'PDFjs.pdf') >= 0 || $$.isMinVersion('AdobeReader', '0') >= 0 || $$.hasMimeType('application/pdf'));
  if ( dpMode ==  2 )
    AnyPDFreader = true;
  if (AnyPDFreader == false) {
    if (confirm('No Pdf Reader Plugin available on the current browser, continue?')) {
      AnyPDFreader = true;
    }
  }
  
  var strsave = getdef();
  var editedjson = JSON.stringify(jsCompileObj.edited, function(s, v) {
    if (typeof v != 'object') {
      return v.toString();
    } 
    return v;
  });
  
  if (!isValidDocument) {
      if( PSCtrl && PSCtrl.dispatchEvent) {
        if ( dpMode == 0 ) { //print
          PSCtrl.dispatchEvent('ErrorPrint');
        }
        else if ( dpMode == 1 ) { //download
          PSCtrl.dispatchEvent('ErrorDownload');
        }
        else if ( dpMode == 2 ) { //save
          PSCtrl.dispatchEvent('ErrorSave');
        }
    }
    return;
  }


  if( overwriteFile == false ) {
    sendDataToOpener();
    return;
  }

  if (Iframe0 == null) {
    Iframe0 = new ZtVWeb.IframeCtrl(form, 'Iframe0', 'Iframe0', 0, 0, 1, 1, 'name_Iframe0', 'false', ' ', ' ', ' ');
    form[Iframe0.name] = Iframe0;
    Iframe0.iframe.onload = function() {
      var urlz = '../jsp-system/SPReportMaskMessage_portlet.jsp?msgBox=ERROR ON PROCESSING PDF ELABORATION!!!'
      hideLoadingDiv();
      if ( dpMode == 2 ){
        if( this.contentDocument.body.innerHTML.indexOf('OVERWRITE ') < 0 ) {
          jsCompileObj.result = false;
          windowOpenForeground(urlz); //
        }
        else {
          jsCompileObj.result = true;
        }
      }
      else if ( dpMode == 0 ){
        if( this.contentDocument.body.innerHTML.indexOf('application/pdf') < 0 ) {
          jsCompileObj.result = false;
          windowOpenForeground(urlz); //
        }
        else {
          jsCompileObj.result = true;
        }
      }
      sendDataToOpener();
    }
  }
  if (AnyPDFreader == true) {
    var _action = 'download';
    var url;
    if ( dpMode == 0 ){
      _action = 'print';
    }
    if ( dpMode == 2 ){
      _action = 'overwrite';
    }
    if ((printdownall ==true ) || (Ctrl('zprintAllz').checked == true) || (dpMode == 2)) {
      if ( dpMode == 0 || dpMode == 2){
        Ctrl('Iframe0').style.display = 'block';
        showLoadingDiv();
        if (isIE == true) {
          PostBlog('../servlet/IcePdfCompleteDownload?action=' + _action, pdfFile, strsave, mrpfile, 'name_Iframe0', keywords, downloadname, isPdfA, editedjson, fieldgroup, editfields, signmarksupd, signmarksToAcroFields);
        } else {
          url = '../servlet/IcePdfCompleteDownload?action=' + _action + '&file=' + pdfFile;
          if (isMrpLoad == true || isStamp == true) {
            url = url + '&mrp=' + mrpfile + '&def=' + URLenc(strsave) + '&keywords=' + URLenc(keywords) + '&downloadname=' + URLenc(downloadname) + '&pdfa=' + isPdfA;
          }
          url = url + "&editedjson=" + URLenc(editedjson);
          url = url + "&fieldgroup=" + URLenc(fieldgroup);
          url = url + "&editfields=" + URLenc(editfields);
          url = url + "&signmarksupd=" + URLenc(signmarksupd);
          url = url + "&signmarkstoacrofields=" + URLenc(signmarksToAcroFields);
          windowOpenForeground(url, 'name_Iframe0');
        }
      }
      else {
        if (isIE == true) {
          PostBlog('../servlet/IcePdfCompleteDownload?action=' + _action, pdfFile, strsave, mrpfile, 'name_Iframe0', keywords, downloadname, isPdfA, editedjson, fieldgroup, editfields, signmarksupd, signmarksToAcroFields);
        } else {
          url = '../servlet/IcePdfCompleteDownload?action=' + _action + '&file=' + pdfFile;
          if (isMrpLoad == true || isStamp == true) {
            url = url + '&mrp=' + mrpfile + '&def=' + URLenc(strsave) + '&keywords=' + URLenc(keywords) + '&downloadname=' + URLenc(downloadname) + '&pdfa=' + isPdfA;
          }
          url = url + "&editedjson=" + URLenc(editedjson);
          url = url + "&fieldgroup=" + URLenc(fieldgroup);
          url = url + "&editfields=" + URLenc(editfields);
          url = url + "&signmarksupd=" + URLenc(signmarksupd);
          url = url + "&signmarkstoacrofields=" + URLenc(signmarksToAcroFields);
          // force popup
          windowOpenForeground(url, '', 'height=150,width=450,status=no,toolbar=no,menubar=no,location=no,resizable=no', null, null, null, 1); //
        }
      }
     // sendDataToOpener(); //sembra che non viene scatenato onsave su ps
    } else {
      var isValidSelection, pageFrom, pageTo;
      if (dpMode == 0) {
        isValidSelection = ValidTo(Ctrl('printF'));
        if (isValidSelection == true) {
          isValidSelection = ValidTo(Ctrl('printT'));
        }
        if (isValidSelection == true) {
          isValidSelection = ValidFromTo(parseInt(Ctrl('printF').value), parseInt(Ctrl('printT').value));
        }
        pageFrom = Ctrl('printF').value;
        pageTo = Ctrl('printT').value;
      } else {
        isValidSelection = ValidTo(Ctrl('zprintF'));
        if (isValidSelection == true) {
          isValidSelection = ValidTo(Ctrl('zprintT'));
        }
        if (isValidSelection == true) {
          isValidSelection = ValidFromTo(parseInt(Ctrl('zprintF').value), parseInt(Ctrl('zprintT').value));
        }
        pageFrom = Ctrl('zprintF').value;
        pageTo = Ctrl('zprintT').value;
      }
      if (isValidSelection == true) {
        if ( dpMode == 0 ){
          Ctrl('Iframe0').style.display = 'block';
          if (isIE == true) {
            url = '../servlet/IcePdfCompleteDownload?action=' + _action + '&page0=' + pageFrom + '&page1=' + pageTo;
              PostBlog(url, pdfFile, strsave, mrpfile, 'print', 'name_Iframe0', downloadname, isPdfA, editedjson, fieldgroup, editfields, signmarksupd, signmarksToAcroFields);
          } else {
            url = '../servlet/IcePdfCompleteDownload?action=' + _action +'&file=' + pdfFile + '&page0=' + pageFrom + '&page1=' + pageTo;
            if (isMrpLoad == true) {
              url = url + '&def=' + URLenc(strsave) + '&mrp=' + mrpfile;
            }
            url = url + '&downloadname=' + downloadname;
            url = url + "&editedjson=" + URLenc(editedjson);
            url = url + "&fieldgroup=" + URLenc(fieldgroup);
            url = url + "&editfields=" + URLenc(editfields);
            url = url + "&signmarksupd=" + URLenc(signmarksupd);
            url = url + "&signmarkstoacrofields=" + URLenc(signmarksToAcroFields);
            windowOpenForeground(url, 'name_Iframe0');
          }
        }
        else {
          if (isIE == true) {
            url = '../servlet/IcePdfCompleteDownload?action=' + _action + '&page0=' + pageFrom + '&page1=' + pageTo;
            PostBlog(url, pdfFile, strsave, mrpfile, '', 'name_Iframe0', downloadname, isPdfA, editedjson, fieldgroup, editfields, signmarksupd, signmarksToAcroFields);
          } else {
            url = '../servlet/IcePdfCompleteDownload?action=' + _action +'&file=' + pdfFile + '&page0=' + pageFrom + '&page1=' + pageTo;
            if (isMrpLoad == true) {
              url = url + '&def=' + URLenc(strsave) + '&mrp=' + mrpfile;
            }
            url = url + '&downloadname=' + downloadname;
            url = url + "&editedjson=" + URLenc(editedjson);
            url = url + "&fieldgroup=" + URLenc(fieldgroup);
            url = url + "&editfields=" + URLenc(editfields);
            url = url + "&signmarksupd=" + URLenc(signmarksupd);
            url = url + "&signmarkstoacrofields=" + URLenc(signmarksToAcroFields);
            windowOpenForeground(url);
          }
        }
        sendDataToOpener();
      }
    }
  }
}

function PostBlog(url, file, def, mrp, target, keywords, downloadname, pdfa, editjson, fieldgroup, editfields, signmarksupd, signmarkstoacrofields) {
  var f = document.getElementById('postForm' + target);
  f.file.value = file;
  f.mrp.value = mrp;
  f.def.value = def;
  f.keywords.value = keywords;
  f.downloadname.value = downloadname;
  f.pdfa.value = pdfa;
  f.editjson = editjson;
  f.fieldgroup = fieldgroup;
  f.editfields = editfields;
  f.signmarksupd = signmarksupd;
  f.signmarkstoacrofields = signmarkstoacrofields;
  f.action = url;
  windowOpenForeground('', target, 'height=150,width=450,status=no,toolbar=no,menubar=no,location=no,resizable=no');
  f.submit();
}

function setCheck(val, from, to) {
  var v = val.checked;
  var c1 = Ctrl(from);
  var c2 = Ctrl(to);
  if (v == true) {
    if (c1) {
      c1.value = '1';
      c1.disabled = true;
    }
    if (c2) {
      c2.value = '' + maxPages;
      c2.disabled = true;
    }
  } else {
    if (c1) {
      c1.disabled = false;
    }
    if (c2) {
      c2.disabled = false;
    }
    setFromTo(from, to);
  }
}

function closelayer() {
  if (myZBoViewWindow && myZBoViewWindow.ToogleClick) {
    myZBoViewWindow.ToogleClick();
  }
}
/* *** Fine Toolbar a fine pagina *** */

function search() {
  var fnToDelayG = function () {
    drawHL = false;
    removeHighlight();
    var vz = Ctrl('searchTxt').value;
   
    if(zTAssistant && zTAssistant.IsActive())
      zTAssistant.EnableAssistant();

    if (vz.length > 0) {
      var urlz = 'IcePdfSearch?file=' + pdfFile + '&search=' + vz;
      var caseSensitive = Ctrl('searchCase') ? Ctrl('searchCase').checked : false;
      var wholeWord = Ctrl('searchWhole') ? Ctrl('searchWhole').checked : false;
      urlz = urlz + '&caseSensitive=' + caseSensitive;
      urlz = urlz + '&wholeWord=' + wholeWord;

      xmlobj1 = new ZtVWeb.XMLDataProvider(form, 'xmlobj1', urlz, '/Search/Record', ' ', ' ', ' ', false);
      form[xmlobj1.name] = xmlobj1;
      xmlobj1.Query();

      if (xmlobj1.nrec > 0) {
        firstSearch();
        searchingStatus = true;
        Ctrl('searchnumberMax').set('text', xmlobj1.nrec);
      } else {
        alert(MSG_ZPDF_TRANSLATE['MSG_ZPDF_SEARCH_NO_WORDS']);
        Ctrl('searchnumberMax').set('text', 0);
        Ctrl('searchnumber').set('text', 0);
        searchingStatus = false;
        updateWordSpan();
      }
    } else {
      xmlobj1 = null;
      searchingStatus = false;
      Ctrl('searchnumberMax').set('text', 0);
      Ctrl('searchnumber').set('text', 0);
      updateWordSpan();
    }
    hideLoadingDiv();
  };
  fnToDelayG.delay(500);
}

function PrevSearch() {
  var ctrl = Ctrl('searchnumber');
  if (xmlobj1 != null) {
    var n, p;
    if (drawHL == false) {
      var pz = page0;
      if (pz == 0) {
        pz = 1;
      }
      if (xmlobj1 != null && xmlobj1.nrec > 0) {
        n = true;
        xmlobj1.curRec = xmlobj1.nrec;
        xmlobj1.refreshConsumers(false);
        p = xmlobj1.rs.Page;
        while (p >= pz && n == true) {
          n = xmlobj1.Prev();
          p = xmlobj1.rs.Page;
        }

        if (n == true) {
          removeHighlight();
          drawHL = true;
          GoToPage(xmlobj1.rs.Page);
        } else {
          //alert('No more search result...');
        }
        }
    } else if (xmlobj1.nrec > 0) {
      n = xmlobj1.Prev();
      p = xmlobj1.rs.Page;

      if (n == true) {
        removeHighlight();
        drawHL = true;
        GoToPage(xmlobj1.rs.Page);
      } else {
        //alert('No more search result...');
      }
    }

    if (xmlobj1.nrec > 0) {
      if (ctrl) {
        ctrl.innerHTML = '' + xmlobj1.curRec;
      } else if (ctrl) {
        ctrl.innerHTML = '0';
      }
    }
  } else if (ctrl) {
    ctrl.innerHTML = '0';
  }
}

function firstSearch() {
  var ctrl = Ctrl('searchnumber');
  if (xmlobj1 != null) {
    xmlobj1.FirstPage();
    if (xmlobj1.nrec > 0) {
      var page = xmlobj1.rs.Page;
      var n = false;
      var p;
      if (modebook == true) {
        p = 1;
      } else {
        p = page0;
      }
      while (page != p && !n) {
        n = xmlobj1.Next();
        page = xmlobj1.rs.Page;
      }
      drawHL = true;
      GoToPage(xmlobj1.rs.Page);
      if (ctrl) {
        ctrl.innerHTML = '' + xmlobj1.curRec;
    }
    } else if (ctrl) {
      ctrl.innerHTML = '0';
  }
  } else if (ctrl) {
    ctrl.innerHTML = '0';
  }
  updateWordSpan(xmlobj1.nrec)
}

function NextSearch() {
  var ctrl = Ctrl('searchnumber');
  if (xmlobj1 != null) {
    var n, p;
    if (drawHL == false) {
      var pz = page0;
      if (pz == 0) {
        pz = 1;
      }
      if (xmlobj1 != null && xmlobj1.nrec > 0) {
        n = xmlobj1.FirstPage();
        p = xmlobj1.rs.Page;
        while (p < pz && n == true) {
          n = xmlobj1.Next();
          p = xmlobj1.rs.Page;
        }
        if (n == true) {
          removeHighlight();
          drawHL = true;
          GoToPage(xmlobj1.rs.Page);
        } else {
          //alert('No more search result...');
      }
    }
    } else if (xmlobj1.nrec > 0) {
      n = xmlobj1.Next();
      p = xmlobj1.rs.Page;
      if (n == true) {
        removeHighlight();
        drawHL = true;
        GoToPage(xmlobj1.rs.Page);
      } else {
        //alert('No more search result...');
      }
    }

    if (xmlobj1.nrec > 0) {
      if (ctrl) {
        ctrl.innerHTML = '' + xmlobj1.curRec;
      } else if (ctrl) {
        ctrl.innerHTML = '0';
      }
    }
  } else if (ctrl) {
    ctrl.innerHTML = '0';
  }
  updateWordSpan(xmlobj1.nrec)
}

function KeyPressz(val, e) {
  var keycode;
  if (window.event) {
    keycode = window.event.keyCode;
  } else if (e) {
    keycode = e.which;
  } else {
    return;
  }
  if (keycode == 13 || keycode == 9) {
    showLoadingDiv();
    search();
  }
}

function KeyPressSearch(val, e) {
  var keycode;
  if (window.event) {
    keycode = window.event.keyCode;
  } else if (e) {
    keycode = e.which;
  } else {
    return;
  }
  if (keycode == 13 || keycode == 9) {
    if (isNaN(val.value)) {
      alert('Invalid number format');
    } else {
      SearchGoto();
    }
  }
}

function SearchCase() {
  var ctrl = Ctrl('searchCase');
  ctrl.checked = !ctrl.checked;
  if ( ctrl.checked )
    LibJavascript.CssClassNameUtils.removeClass(Ctrl('searchcaseBtn'), 'disable_element')
  else
    LibJavascript.CssClassNameUtils.addClass(Ctrl('searchcaseBtn'), 'disable_element')
  
  showLoadingDiv();
  search();
}

function SearchWhole() {
  var ctrl = Ctrl('searchWhole');
  ctrl.checked = !ctrl.checked;
  if ( ctrl.checked )
    LibJavascript.CssClassNameUtils.removeClass(Ctrl('searchwholeBtn'), 'disable_element')
  else
    LibJavascript.CssClassNameUtils.addClass(Ctrl('searchwholeBtn'), 'disable_element')
  
  showLoadingDiv();
  search();
}
/* *** Fine Ricerca *** */

/* *** Codice BOViewer *** */
//var _savePortletTitle = null;
function ZViewerUpdateToolbar ( /*portletTitle*/ ) {
  /*if ( portletTitle ) {
    _savePortletTitle = portletTitle;
  }
  updateToolbar();*/
}

/*function updateToolbar() {
  var portletTitle = _savePortletTitle;
  if( portletTitle && portletTitle.Ctrl) {
    var oh = Ctrl('toolbar').offsetHeight;
    var style = window.getComputedStyle ? getComputedStyle(Ctrl('toolbar'), null) : Ctrl('toolbar').currentStyle;
    var borderWidths = ( parseInt(style.borderBottomWidth) || 0 ) + ( parseInt(style.borderTopWidth) || 0 );
    var nh = portletTitle.Ctrl.offsetHeight;
    if (oh < nh) {
      Ctrl('toolbar').style.height = nh - (nh - oh) / 2 - borderWidths + 'px';
      Ctrl('toolbar').style.paddingTop = (nh - oh) / 2 + 'px';
    }
  }
}*/


function ZViewerSaveStampToDoc() {
  var strsave = getdef();
  if (isStamp == true && canaddstamp == true) {
    var url = '../servlet/IcePdfCompleteDownload?action=overwrite&file=' + pdfFile;
    url = url + '&mrp=' + mrpfile + '&def=' + URLenc(strsave) + '&keywords=' + URLenc(keywords) + '&pdfa=' + isPdfA;
    var jurl = new JSURL(url, true);
    var output = jurl.Response();
    if (output.indexOf('ERROR') >= 0) {
      alert('Error on saving document ...');
    } else {
      m_bUpdated = false;
      if( modeInsertSign ) {
        signkey = '';
        signgroup = '';
        itemsHTML = [];
      }
      initCanvas();
      writeHTML();
    }
  }
}

function EditBO() {
}

function DeleteBO() {
}

function SaveBO() {
  ZViewerSaveStampToDoc();
}

function CancelBO() {
}

function SetZBOViewerWindow(wind) {
  myZBoViewWindow = wind;
}

function ScanDoc() {
  if (myZBoViewWindow && myZBoViewWindow.ScanDoc) {
    myZBoViewWindow.ScanDoc();
  }
}

function SignMarkDoc() {
  var boWindow = getBOWindow();
  signmarksupd = true;
  if (boWindow && boWindow.zbo_getNewRowSign) {
      var rowsign = boWindow.zbo_getNewRowSign(true);
      addSignMark(rowsign);
      selectSignMark(rowsign);
      if (boWindow && boWindow.zbo_beforeaddSignMark) {
        boWindow.zbo_beforeaddSignMark (rowsign.signKey, rowsign.group);
      }
      if (boWindow && boWindow.zbo_addSignMark) {
        boWindow.zbo_addSignMark (rowsign.signKey, rowsign.group);
      }
  }
  else {
    var rowsignR = {}
    rowsignR.signKey = 'zFirm'+LibJavascript.AlfaKeyGen(10);
    addSignMark(rowsignR);
    selectSignMark(rowsignR);
  }
}

function RemSignMarkDoc() {
  var boWindow = getBOWindow();
  if (index != null) {
    signmarksupd = true;
    var itm = itemsHTML[index];
    deleteItem();
    delete signMarksKey[itm.key];
    if( signMarksGroupArray[itm.group] ) {
      var ind = signMarksGroupArray[itm.group].indexOf(itm.key);
      if ( ind >= 0 ) {
        signMarksGroupArray[itm.group].splice(ind, 1);
      }
    }
    if (boWindow && boWindow.zbo_beforeremoveSignMark) {
      boWindow.zbo_beforeremoveSignMark (itm.key, itm.group);
    }
    if (boWindow && boWindow.zbo_removeSignMark) {
      boWindow.zbo_removeSignMark (itm.key, itm.group);
    }
  }
}

function getBOWindow() {
  if (myZBoViewWindow) {
    return myZBoViewWindow.frames.i_canvasframe.window;
  }
  return null;
}
/* *** Fine Codice BOViewer *** */

function changeViewMode4() {
  modebook = true;
  lviewerNumPage = nrPagesToView;
  nrPagesToView = 4;
  eval('page0=page' + currentPage);
  if (page0 == 0) {
    page0 = 1;
  }
  page1 = page0 + 1;
  page2 = page1 + 1;
  page3 = page2 + 1;
  GoToPage('' + page0);
}

function zoomDrag() {
  Ctrl('canvas').setStyle('cursor', 'default');
  Ctrl('canvas').onmousedown = function (event) {
    beginDragSelection(event);
  };
}

function zoomFit() {
  var e = e || window.event;
  resizeWindow(e, true);
  zoom(100);
}

function getY(oElement) {
  var iReturnValue = 0;
  while (oElement != null) {
    iReturnValue += oElement.offsetTop;
    oElement = oElement.offsetParent;
  }
  return iReturnValue;
}

function getX(oElement) {
  var iReturnValue = 0;
  while (oElement != null) {
    iReturnValue += oElement.offsetLeft;
    oElement = oElement.offsetParent;
  }
  return iReturnValue;
}

function rotateLeft() {
  rotation = rotation - 90;
  if (rotation < 0) {
    rotation = 360 + rotation;
  }
  initCanvas(true);
}

function rotateRight() {
  rotation = rotation + 90;
  if (rotation >= 360) {
    rotation = rotation - 360;
  }
  initCanvas(true);
}

function GotoPage(num) {
  num = parseInt('' + num);
  num = num + 1;
  drawHL = false;
  GoToPage('' + num);
}

function ExecGoToPage(){
  var ctrlz = Ctrl('pagenumber');
  windowOpenForeground('../jsp-system/zpdfviewer_goto_portlet.jsp?tNum='+ URLenc(ctrlz.value) +'&vTot='+ URLenc(maxPages), '','toolbar=0,menubar=0,directories=0,width=300,height=150,resizable=0');
}

function SignDoc(/*bodata*/) {
}

function getMinWidth() {
  return 435;
}

function GetCanAddStamp() {
  return canaddstamp;
}

/*oggetto json rowjson - dati per la firma
  "signIdx": Proposto per indicare l'indice di presentazione delle firme
  "page" : pagina in cui si trova la firma [0..n],
  "title": titolo da mostrare sull'header di firma (Esempio: "Firma del cliente")
  "requirePosition": boolean, se true la firma richiede che il servizio di geolocalizzazione rilevi la posizione di firma
  "dateFormat": se specificato la data di firma
  "timeFormat": se specificato la data di firma
  "hideExtraText": se true la data di firma e la geolocalizzazione non vengono renderizzati nel pdf, ma solamente scritti nel catalogo
  "obligatory": true se la firma ? obbligatoria per procedere al salvataggio
  "group" : gruppo
  "signKey" : chiave
  "signType" : tipo

  parametro update : se vale true, solo aggiornamento, se non esiste la firma non si aggiunge
  parametro updateviewer : se vale true, aggiornare m_bUpdated
*/
function addSignMark(rowjson, update, updateviewer) {
  if (!rowjson) {
    return;
  }
  if (typeof updateviewer == 'undefined') {
    updateviewer = true;
  }
  var page;
  eval('var p=page' + currentPage);
  // eslint-disable-next-line no-undef
  page = p - 1; // p viene dato dal valore di 'eval'
  if ( page < 0 ) {
    page = 0;
  }
  if (!rowjson.page) {
    rowjson.page = page;
  }
  if (rowjson.page < 0) {
    return;
  }
  if (!rowjson.title) {
    rowjson.title = '';
  }
  if (!rowjson.obligatory) {
    if( rowjson.brequired != undefined )
      rowjson.obligatory = ((rowjson.brequired+'') === "true") || ((rowjson.brequired+'') === "TRUE");
    else
      rowjson.obligatory = false;
  }
  if (!rowjson.requirePosition) {
    rowjson.requirePosition = false;
  }
  if (!rowjson.dateformat) {
    rowjson.dateformat = 'None';
  }
  if (!rowjson.timeformat) {
    rowjson.timeformat = 'None';
  }
  if (!rowjson.bhideextra) {
    rowjson.bhideextra = false;
  }
  if (!rowjson.signIdx) {
    rowjson.signIdx = 1;
  }
  if (!rowjson.x) {
    rowjson.x = 25;
  }
  if (!rowjson.y) {
    rowjson.y = 25;
  }
  if (!rowjson.width) {
    if( rowjson.w )
      rowjson.width = rowjson.w;
    else
      rowjson.width = signMarkWidth;
  }
  if (!rowjson.height) {
    if( rowjson.h )
      rowjson.height = rowjson.h;
    else
      rowjson.height = signMarkHeight;
  }

  if (!rowjson.signType) {
    rowjson.signType = '';
  }

  if(rowjson.signKey && signMarksKey[rowjson.signKey]) {
    updateSignMark(rowjson, signMarksKey[rowjson.signKey], updateviewer);
    return;
  }

  if( update ) {
    if ( rowjson.group && signMarksGroupArray[rowjson.group]) {
      var signMarksA = signMarksGroupArray[rowjson.group];
      for ( var k = 0; k < signMarksA.length; k++) {
          updateSignMark(rowjson, signMarksKey[signMarksA[k]], updateviewer);
      }
    }
    return;
  }
  var value = rowjson.title;
  var name = 'zFirm'+LibJavascript.AlfaKeyGen(10);
  if( Empty(value) && !Empty(rowjson.signKey) && !rowjson.signKey.startsWith('zFirm')) value = rowjson.signKey;
  if( !Empty(rowjson.signKey) && rowjson.signKey.indexOf("#")>0)  {
    var sp = rowjson.signKey.split("#");
    name = sp[1];
    rowjson.group = sp[0];
    if( !Empty(rowjson.group) && rowjson.group.indexOf("$")>0)  {
      var sg = rowjson.group.split("$");
      rowjson.group = sg[0];
      if( sg[1] == 'unf') rowjson.signType = 'signUnfair';
      else if( sg[1] == 'prv') rowjson.signType = 'signPrivacy';
      else rowjson.signType = sg[1];
    }
    if( Empty(value) )
      value = rowjson.signKey;
  }

  itemsHTML[itemsHTML.length] = new ZTObjects.signMarkObj('item' + nitem, name, 'SignMark', rowjson.x, rowjson.y, rowjson.width, rowjson.height, rowjson.page, value, rowjson.signKey, rowjson.signIdx, rowjson.group, rowjson.signType);
  itemsHTML[itemsHTML.length-1].isMoved = rowjson.isMoved;
  itemsHTML[itemsHTML.length-1].brequired = rowjson.obligatory + '';
  itemsHTML[itemsHTML.length-1].signed =  (rowjson.signed === 'true');
  nitem++;
  if (!m_bUpdated && updateviewer) {
    m_bUpdated = true;
  }
  if (rowjson.signKey) {
    signMarksKey[rowjson.signKey] = itemsHTML[itemsHTML.length - 1];
  }

  if(rowjson.group) {
    if (!signMarksGroupArray[rowjson.group]) {
      signMarksGroupArray[rowjson.group] = [];
    }
    signMarksGroupArray[rowjson.group].push(rowjson.signKey);
  }

  var itemid = itemsHTML[itemsHTML.length-1].id;
  var iname = itemsHTML[itemsHTML.length-1].name;
  if( PSPortlet && PSPortlet.ZPdfV_GetObjSignMark ) {
    var op = PSPortlet.ZPdfV_GetObjSignMark();
    if( op!=null ) {
      var n, g;
      if( op.name == undefined ) n = iname;
      if( op.group == undefined ) g = '';
      else g = op.group;
      SetSignMarkInfo(itemid, n, g)
      writeHTML();
    }
    else {
      writeHTML();
      updateSignMark(rowjson, itemsHTML[itemsHTML.length - 1], updateviewer);
    }
  }
  else {
    writeHTML();
    updateSignMark(rowjson, itemsHTML[itemsHTML.length - 1], updateviewer);
  }
  //if( canaddstamp ) {
  var itm = itemsHTML[itemsHTML.length - 1];
  var signgroupd = signgrouplistmap[itm.group];
  var v;
  if( signgroupd != undefined ) {
    v = signgroupd;
  }
  else if( itm.value.indexOf("#") > 0 ) {
    v = itm.value;
  }
  else {
    v = signdesc; 
  }
    
  if( zTAssistant ) {
    var canreg = true;
    if(!Empty(signkey) && itm.key !=signkey)
      canreg = false;
    else if(!Empty(signgroup) && (signgroup=='none'))
      canreg = false;
    else if(!Empty(signgroup) && (signgroup!=itm.group))
      canreg = false;
    if(canreg) {
      if( canaddstamp ) {
        var jsActions = [];
        var jedit = {};
        jedit.title = MSG_ZPDF_TRANSLATE['MSG_ZPDF_EDIT_SIGNMARK'];
        jedit.func = "EvEditSignMark('" + itm.id + "')"
        jedit.class = 'editsignmark'
        jsActions.push(jedit);
        var jdel = {};
        jdel.title = MSG_ZPDF_TRANSLATE['MSG_ZPDF_REMOVE_SIGNATUREMARK'];
        jdel.func = "EvDeleteSignMark('" + itm.id + "')"
        jdel.class = 'delsignmark'
        jsActions.push(jdel);
        zTAssistant.Register(itm.id, v, '', itm.page, undefined, jsActions);
      }
      else {
        zTAssistant.Register(itm.id, v, '', itm.page, '');
      }
      zTAssistant.ContinueAssistant(itm.id);
    }
  }
  //}
  isStamp = true; //simulate mrp load
}

function selectSignMark(rowjson, ignoreBO, fromBO) {
  if (signNavSelect == false) {
    HideOnToolbar('TSignBtn');
  }
  if (!rowjson) {
    return;
  }
  if ( typeof ignoreBO == 'undefined') {
    ignoreBO = false;
  }
  if ( typeof fromBO == 'undefined') {
    fromBO = false;
  }
  var signk = rowjson.signKey;
  removeAllHandlers();

  if(!rowjson){
    return;
  }

  function checkrow() {
    if( Empty(signk) ) {
      if ( !rowjson.group ) {
        return false;
      }
      var arr = signMarksGroupArray[rowjson.group];
      var f = false;
      for( var i = 0; !f && arr && i < arr.length; i++) {
        signk = arr[i];
        f = true;
      }
      return f;
    }
    if(!signMarksKey[signk]) {
      return false;
    }
    return true;
  }

  var bo = getBOWindow();
  if ( !ignoreBO && (!bo || !bo.m_cFunction || bo.m_cFunction != 'edit' && bo.m_cFunction != 'new' ) ) {
    if (!checkrow()) {
      return;
  }
  } else if (!checkrow()) {
      return;
  }
  var page;
  eval('var p=page' + currentPage);
  // eslint-disable-next-line no-undef
  page = p - 1;
  if ( page < 0 ) {
    page = 0;
  }
  var item = signMarksKey[signk];
  var fnToDelayG = function () {
    signNavSelect = false;
    var ctrl = Ctrl(item.id);
    if( ctrl ) {
      ctrl.title = item.value;
      item.fromBO = fromBO;
      $(item.id).click();
      if (!isLoading)
        $(item.id).scrollIntoView(false);
    }
    updateSignMark(null, item, true)
  };
  if(page != item.page){
    GotoPage(item.page);
    fnToDelayG.delay(1200);
  } else {
    fnToDelayG.delay(0);
  }
}

function removeSignMark(rowjson) {
  if (!rowjson || !rowjson.group) {
    return;
  }
  if (!signMarksKey) {
    return;
  }
  var signMarks = [];
  var signMarksA = Object.values(signMarksKey);
  for ( var k = 0; k < signMarksA.length; k++) {
    if(signMarksA[k].group == rowjson.group) {
      signMarks.push(signMarksA[k].key);
    }
  }
  RemoveSignMarks(signMarks, true);
}

function updateSignMark(rowjson, item, updateviewer) {
  if (typeof updateviewer == 'undefined') {
    updateviewer = true;
  }
  var fnToDelayG = function () {
    var jsonstr1 = JSON.stringify(item);
    if( rowjson ) {
      if(!Empty(rowjson.title)) item.title = rowjson.title;
      item.obligatory = rowjson.obligatory;
      item.bgeoposition = rowjson.requirePosition;
      item.dateformat = rowjson.dateformat;
      item.timeformat = rowjson.timeformat;
      item.bhideextra = rowjson.hideExtraText;
      item.sequence = rowjson.signIdx;
      item.value = item.title;
      item.image = rowjson.signImage;
      item.text = rowjson.signText;
      item.group = rowjson.group;
      if(!Empty(rowjson.signtype)) item.signtype = rowjson.signtype;
      if(!Empty(rowjson.signChecked)) item.signChecked = rowjson.signChecked;
    }
    var jsonstr2 = JSON.stringify(item);
    if (!m_bUpdated && updateviewer) {
      m_bUpdated = !(jsonstr1 == jsonstr2);
    }
    var ctrl = Ctrl(item.id);
    if( ctrl ) {
      var v;
      if ( !Empty(item.value) ) {
        if( item.value.indexOf("#") > 0 ) {
          var sp = item.value.split("#")[0];
          if( sp.indexOf('$') > 0 ) sp = sp.split("$")[0];
          var signgroupd = signgrouplistmap[sp];
          if( signgroupd != undefined ) {
            v = signgroupd;
          }
          else {
            v = item.value;
          }
        }
        else {
          v = signdesc; //nome o valore irrelevante - zona di firma generica perche non ha gruppo
          ctrl.style.lineHeight = ctrl.offsetHeight - 2 + "px";
        }
      }
      else {
        v = signdesc;
        //ctrl.style.lineHeight = ctrl.offsetHeight - 2 + "px";
      }
      if( confirmstamp && !canaddstamp ) {
        if( item.signChecked == undefined  || !item.signChecked ) {
          if(Empty(signgroup) || (!Empty(signgroup) && signgroup==item.group))
          v = MSG_ZPDF_TRANSLATE['MSG_ZPDF_CONFIRM_SIGNMARK'];
        }
      }
      if( zTAssistant ) zTAssistant.Update(item.id, v);
      v = ToHTML(v);
      v = Strtran(v, ' ', '&nbsp;');
      v = Strtran(v, '&#10;', '<br>');
      ctrl.innerHTML = v;
      ctrl.title = item.value;
      ApplySignMarkEffect(item);
    }
  };
  fnToDelayG.delay(0);
}

function addStamp(value, fontname, fontsize, fontstyle, fonteffects) {
  if (canaddstamp == false) {
    return;
  }
  if (itemsHTML.length > 0) { //aggiornare
  } else {
    var page;
    eval('var p=page' + currentPage);
    // eslint-disable-next-line no-undef
    page = p - 1;
    if ( page < 0 ) {
      page = 0;
    }
    itemsHTML[itemsHTML.length] = new ZTObjects.stampObj('item' + nitem, 'Stamp' + nitem, 'Stamp', '', value, '', 25, 25, 30, 30, page);
    nitem++;
  }
  itemsHTML[itemsHTML.length - 1].font = fontname;
  itemsHTML[itemsHTML.length - 1].size = parseInt(fontsize);
  itemsHTML[itemsHTML.length - 1].style = fontstyle;
  itemsHTML[itemsHTML.length - 1].effects = fonteffects;
  itemsHTML[itemsHTML.length - 1].value = value;

  writeHTML();
  //simulate mrp load
  isStamp = true;
  //mrpfile = '_simulate_mrp_';
}

function drawCanceledPage(/*pagenumber, drawc*/) {
}

function Preview() {
}

function checkSignMark(item) {
  if( !canaddstamp ) {
    if( item.signChecked == true ) {
      item.signChecked = false;
    }
    else {
      item.signChecked = true;
    }
    updateSignMark(null, item, true);
    if (PSCtrl) {
      if ( confirmstamp && !canaddstamp && PSCtrl.dispatchEvent ) {
          var lo = item;
          var s = {};
          s.bgeoposition = lo.bgeoposition;
          s.bhideextra = lo.bhideextra;
          s.brequired = lo.brequired + '';//brequired as string
          s.dateformat = lo.dateformat;
          s.group = lo.group;
          s.h = lo.h;
          s.signKey = lo.signKey || lo.key;
          s.timeformat = lo.timeformat;
          s.title = lo.title;
          s.type = lo.type;
          s.w = lo.w;
          s.x = lo.x;
          s.y = lo.y;
          s.page = lo.page;
          s.signType = lo.signtype;
          s.signChecked = lo.signChecked;
          PSCtrl.dispatchEvent('ConfirmSignature', s);
      }
    }
  }
}

function elementInViewport(el) {
  var top = el.offsetTop;
  var left = el.offsetLeft;
  var width = el.offsetWidth;
  var height = el.offsetHeight;

  while(el.offsetParent) {
    el = el.offsetParent;
    top += el.offsetTop;
    left += el.offsetLeft;
  }

  return (
    top >= window.pageYOffset &&
    left >= window.pageXOffset &&
    top + height <= window.pageYOffset + window.innerHeight &&
    left + width <= window.pageXOffset + window.innerWidth
  );
}

function elementInViewport2(el) {
  var top = el.offsetTop;
  var left = el.offsetLeft;
  var width = el.offsetWidth;
  var height = el.offsetHeight;

  while(el.offsetParent) {
    el = el.offsetParent;
    top += el.offsetTop;
    left += el.offsetLeft;
  }

  return (
    top < window.pageYOffset + window.innerHeight &&
    left < window.pageXOffset + window.innerWidth &&
    top + height > window.pageYOffset &&
    left + width > window.pageXOffset
  );
}

function ZViewerEnableAddSignMark ( enable ) {
  if ( enable ) {
    EnableOnToolbar('bsign');
  } else {
    DisableOnToolbar('bsign');
}
}

function ZViewerEnableRemoveSignMark ( enable ) {
  if ( enable ) {
    EnableOnToolbar('brsign');
  } else {
    DisableOnToolbar('brsign');
  }
}

function ZViewerSetSignImage( psignkey, imageurl, text ) {
  if (Empty(fileSignMarks)) {
    return;
  }
  if (!Empty(signkey) && psignkey != signkey) {
    return;
  }
  var signArr = JSON.parse(fileSignMarks);
  for(var i=0; i<signArr.length; i++) {
    if(signArr[i].signKey == psignkey){
      if(signArr[i].page) {
        signArr[i].page = parseInt(signArr[i].page + '') - 1;
        if (signArr[i].x) {
          signArr[i].x = PtToPx(signArr[i].x);
        }
        if (signArr[i].y) {
          signArr[i].y = PtToPx(signArr[i].y);
        }
        if (signArr[i].width) {
          signArr[i].width = PtToPx(signArr[i].width);
        }
        if (signArr[i].height) {
          signArr[i].height = PtToPx(signArr[i].height);
        }
      }
      signArr[i].signImage = imageurl;
      signArr[i].signText = text;
      addSignMark(signArr[i], true, false);
      selectSignMark(signArr[i], true);
      return;
    }
  }
}

function ZViewerSetSignGroupImage( psigngroup, imageurl, text ) {
  if (Empty(fileSignMarks)) {
    return;
  }
  if (!Empty(signgroup) && signgroup == 'none') {
    return;
  }
  if (!Empty(signgroup) && psigngroup != signgroup) {
    return;
  }
  var signArr = JSON.parse(fileSignMarks);
  var selectindex = -1;
  for(var i=0; i<signArr.length; i++) {
    if(signArr[i].group == psigngroup){
      if(signArr[i].page) {
        signArr[i].page = parseInt(signArr[i].page + '') - 1;
        if (signArr[i].x) {
          signArr[i].x = PtToPx(signArr[i].x);
        }
        if (signArr[i].y) {
          signArr[i].y = PtToPx(signArr[i].y);
        }
        if (signArr[i].width) {
          signArr[i].width = PtToPx(signArr[i].width);
        }
        if (signArr[i].height) {
          signArr[i].height = PtToPx(signArr[i].height);
        }
      }
      signArr[i].signImage = imageurl;
      signArr[i].signText = text;
      addSignMark(signArr[i], true, false);
      if (selectindex < 0) {
        selectindex = i;
    }
  }
  }
  if (selectindex >= 0 ) {
    selectSignMark(signArr[selectindex], true);
  }
}

function ZViewerPreviousSignMark() {
  var ind = parseInt(Ctrl('signnumber').value);
  ind = ind - 1;
  var ret = '';
  var key = Ctrl('signnumber').key;
  if(key && signMarksGroupArray[key] ) {
    ind = ind - 1;
    if ( ind >= 0 && signMarksGroupArray[key][ind]) {
      ret = signMarksGroupArray[key][ind];
    }
  }
  PreviousSign();
  return ret;
}

function ZViewerNextSignMark() {
  var ind = parseInt(Ctrl('signnumber').value);
  ind = ind - 1;
  var ret = '';
  var key = Ctrl('signnumber').key;
  if(key && signMarksGroupArray[key] ) {
    ind = ind + 1;
    if ( ind >= 0 && ind < signMarksGroupArray[key].length && signMarksGroupArray[key][ind] ) {
      ret = signMarksGroupArray[key][ind];
    }
  }
  NextSign();
  return ret;
}

function ZViewerCurrentSignMark() {
  var ind = parseInt(Ctrl('signnumber').value);
  ind = ind - 1;
  var key = Ctrl('signnumber').key;
  if(ind >= 0 && key && signMarksGroupArray[key] ) {
    return signMarksGroupArray[key][ind];
  }
  return '';
}

var signNavSelect = false;
function PreviousSign() {
  var ind = parseInt(Ctrl('signnumber').value);
  ind = ind - 1;
  var key = Ctrl('signnumber').key;
  if(key && signMarksGroupArray[key] ) {
    ind = ind - 1;
    if ( ind >= 0 && signMarksGroupArray[key][ind]) {
      var rowsign = {};
      rowsign.group = key;
      rowsign.signKey = signMarksGroupArray[key][ind];
      signNavSelect = true;
      selectSignMark(rowsign);
    }
  }
}

function NextSign() {
  var ind = parseInt(Ctrl('signnumber').value);
  ind = ind - 1;
  var key = Ctrl('signnumber').key;
  if(key && signMarksGroupArray[key] ) {
    ind = ind + 1;
    if ( ind >= 0 && ind < signMarksGroupArray[key].length && signMarksGroupArray[key][ind] ) {
      var rowsign = {};
      rowsign.group = key;
      rowsign.signKey = signMarksGroupArray[key][ind];
      signNavSelect = true;
      selectSignMark(rowsign);
    }
  }
}

function KeyPressSign(val, e) {
  var keycode;
  if (window.event) {
    keycode = window.event.keyCode;
  } else if (e) {
    keycode = e.which;
  } else {
    return;
  }
  if (keycode == 13 || keycode == 9) {
    if (isNaN(val.value)) {
      alert('Invalid number format');
    } else {
      var ind = parseInt(Ctrl('signnumber').value);
      ind = ind - 1;
      var key = Ctrl('signnumber').key;
      if(key && signMarksGroupArray[key] ) {
        if ( !(ind >= 0 && ind < signMarksGroupArray[key].length && signMarksGroupArray[key][ind]) ) {
          ind = signMarksGroupArray[key].length - 1;
        }
        if ( ind >= 0 && ind < signMarksGroupArray[key].length && signMarksGroupArray[key][ind] ) {
          var rowsign = {};
          rowsign.group = key;
          rowsign.signKey = signMarksGroupArray[key][ind];
          signNavSelect = true;
          selectSignMark(rowsign);
        }
      }
    }
  } else {

  }
}

function hideLoadingDiv() {
  isLoading = false;
  Ctrl('loading').style.display = 'none';
}

function showLoadingDiv() {
  isLoading = true;
  Ctrl('loading').style.display = 'block';
}

function openCloseFooter() {
  var el =  Ctrl('gadgets_footer_inner')
  var eld =  Ctrl('gadgets_footer_open_close')
  if ( isHidden(el) ) {
    el.style.display = 'block';
    if ( loadScrollPage == false )  {
      drawScrollImg();
      loadScrollPage = true;
    }
    else
      scrollToCurImg();
    LibJavascript.CssClassNameUtils.removeClass(eld, 'opendiv')
    LibJavascript.CssClassNameUtils.addClass(eld, 'closediv')
  }
  else {
    el.style.display = 'none';
    LibJavascript.CssClassNameUtils.removeClass(eld, 'closediv')
    LibJavascript.CssClassNameUtils.addClass(eld, 'opendiv')
  }
}

function scrollToCurImg() {
  var ctrlz = Ctrl('pagenumber');
  if ( !ctrlz )
    return;
  var sels = document.getElementsByClassName('imgSelect');
  var i;
  for ( i=0; i<sels.length; i++)
    LibJavascript.CssClassNameUtils.removeClass(sels[i], 'imgSelect');

  var ctrl = Ctrl('imgPage' + ctrlz.value);
  if( ctrl ) {
    LibJavascript.CssClassNameUtils.addClass(ctrl, 'imgSelect');
    ctrl.scrollIntoView(false);
  }
  _enableScrollImg();
}

function _enableScrollImg() {
  var ctrl = Ctrl('gadgets_footer_content');
  var ctrln = Ctrl('gadgets_footer_next');
  var ctrlp = Ctrl('gadgets_footer_prev');
  LibJavascript.CssClassNameUtils.removeClass(ctrlp, 'disable_element');
  LibJavascript.CssClassNameUtils.removeClass(ctrln, 'disable_element');
  if (  Math.floor(ctrl.scrollLeft) == 0 )
    LibJavascript.CssClassNameUtils.addClass(ctrlp, 'disable_element');
  var maxScrollLeft =ctrl.scrollWidth - ctrl.clientWidth;
  if (  Math.ceil(ctrl.scrollLeft) >= maxScrollLeft )
    LibJavascript.CssClassNameUtils.addClass(ctrln, 'disable_element');
}

function drawScrollImg() {
  var _p = [];
  function setNumMargin() {
    requestAnimationFrame(function() {
      for( var k=_p.length-1; k>=0; k--){
        var cx = _p[k];
        cx.firstChild.style.marginLeft = cx.offsetWidth + (-1 * cx.firstChild.offsetWidth) + 'px';
      }
      scrollToCurImg();
    });
  }
  var el =  Ctrl('gadgets_footer_content');
  el.innerHTML = '';
  if (maxPages > 0) {
    var i, j;
    for (i=1; i<=maxPages; i=i+2) {
      var url = new JSURL('../servlet/IcePdfRenderer?file=' + pdfFile + '&page=' + i + '&scale=' + '100' + '&maxPages=' + maxPages, true);
      var output = url.Response();
      var elh = el.offsetHeight ? el.offsetHeight: 72;
      elh = elh - 6;
      var elw = elh;
      if ( workAreaHeight > 0 ) {
        elw = parseInt(workAreaWidth * elh / workAreaHeight);
      }
      for (j=i; j<=maxPages && j<i+2; j++) {
        var divimg = document.createElement('div');
        divimg.id = 'imgPage' + j;
        divimg.classList.add('imgPage');
        var divimgP = document.createElement('div');
        divimgP.classList.add('imgPageNum');
        divimgP.innerHTML = j;
        divimg.appendChild(divimgP)
        el.appendChild(divimg);
        var c = divimg;
        var iurl = Strtran(output, '\\', '/');
        var img = new Image ();
        img.onload = (function (c) {
          return  function ()  {
            c.style.backgroundImage = "url('" + this.src + "')";
          }
        })(c);
        img.src = iurl + '_' + j + '.png';
        c.style.backgroundRepeat = 'no-repeat';
        c.style.backgroundSize = elw + "px " + elh + "px"
        c.style.width = elw + "px";
        c.style.height = elh + "px";
        c.onclick = function(e) {
          var element = GetEventSrcElement(e);
          var p = parseInt(Strtran(element.id, 'imgPage', ''));
          GoToPage(p);
        }
        _p.push(c);
      }
    }
    setNumMargin();
  }
}

function prevScrollPages() {
  var el =  Ctrl('gadgets_footer_content');
  el.scrollLeft -= el.offsetWidth;
  _enableScrollImg();
}

function nextScrollPages() {
  var el =  Ctrl('gadgets_footer_content');
  el.scrollLeft += el.offsetWidth;
  _enableScrollImg();
}

function updatePageSpan() {
  var el =  Ctrl('pagenumberSpan');
  if( el ) {
    var elp =  Ctrl('pagenumber');
    el.innerHTML = elp.value;
  }
  var p = parseInt(elp.value);
  var ctrln = Ctrl('nextBtn');
  var ctrlp = Ctrl('prevBtn');
  LibJavascript.CssClassNameUtils.removeClass(ctrlp, 'disable_element');
  LibJavascript.CssClassNameUtils.removeClass(ctrln, 'disable_element');
  if ( p <= 1 || maxPages <= 0 )
    LibJavascript.CssClassNameUtils.addClass(ctrlp, 'disable_element');
  if ( p >= maxPages || maxPages <= 0 )
    LibJavascript.CssClassNameUtils.addClass(ctrln, 'disable_element');
}

function updateWordSpan(nrec) {
  var el =  Ctrl('searchnumber');
  var p = parseInt(el.innerHTML);
  var ctrln = Ctrl('searchnextBtn');
  var ctrlp = Ctrl('searchprevBtn');
  if ( nrec == undefined )
    nrec = 0;
  LibJavascript.CssClassNameUtils.removeClass(ctrlp, 'disable_element');
  LibJavascript.CssClassNameUtils.removeClass(ctrln, 'disable_element');
  if ( p <= 1 || nrec <= 0 )
    LibJavascript.CssClassNameUtils.addClass(ctrlp, 'disable_element');
  if ( p >= nrec || nrec <= 0 )
    LibJavascript.CssClassNameUtils.addClass(ctrln, 'disable_element');
}

function SearchOpt() {
  var ctrls = Ctrl('searchBtn');
  var ctrlp = Ctrl('gadgets_footer_panel_search');
  LibJavascript.CssClassNameUtils.addClass(ctrls, 'disable_element');
  LibJavascript.CssClassNameUtils.removeClass(ctrlp, 'hide');
  Ctrl('searchTxt').focus();
}

function SearchOptClose() {
  var ctrls = Ctrl('searchBtn');
  var ctrlp = Ctrl('gadgets_footer_panel_search');
  LibJavascript.CssClassNameUtils.removeClass(ctrls, 'disable_element');
  LibJavascript.CssClassNameUtils.addClass(ctrlp, 'hide');
  drawHL = false;
  removeHighlight();
}

/* Acrofields calculation Functions */

function AformCompile() {
  zAcrofieldCalculations = [];
  zAcrofieldEvents = [];
  zAcrofieldFields = [];
  var security = true;

  function _AformSecurity(js) {
    function _AformJsepCheck(js) {
      function _AJsepRecursive(obj, retArray) {
        if( obj.type == 'Literal')
          return;
        if( obj.operator && retArray.indexOf(obj.operator) < 0 )
          retArray.push(obj.operator);
        if( obj.type == 'Identifier' && retArray.indexOf(obj.name) < 0 )
          retArray.push(obj.name);
        if( obj.left )
          _AJsepRecursive(obj.left, retArray);
        if( obj.object )
          _AJsepRecursive(obj.object, retArray);
        if( obj.right )
          _AJsepRecursive(obj.right, retArray);
        if( obj.callee )
          _AJsepRecursive(obj.callee, retArray);
        if( obj.arguments ) {
          for(var k=0; k<obj.arguments.length; k++)
          _AJsepRecursive(obj.arguments[k], retArray);
        }  
      }
      var security = true;
      var zAcrofieldSecurityJsep = ['*', '-', '+', '%', '/', 'getField', 'new', 'Array', 'AFSimple_Calculate', 'AFMakeNumber'];
      try{
        var jsepO = jsep(js);
        var _arr = [];
        _AJsepRecursive(jsepO, _arr);
        if(_arr.length == 0) security = false;
        for( var y=0; security && y<_arr.length; y++ ) {
          var s = _arr[y];
          if( zAcrofieldSecurityJsep.indexOf(s) < 0 ) {
            security = false;
          }
        }
      }
      catch(e) {
        security = false;
      }
      return security;
    }
    return _AformJsepCheck(js);
  }


  if( calcAcrofieldsOrder != null ) {
    for( var k=0; security && k<calcAcrofieldsOrder.length; k++) {
      var field = calcAcrofieldsOrder[k];
      if( zZoneNames[field] != null) {
        var jsfield = zZoneNames[field];
        if( jsfield.jscalculation != null && !Empty(jsfield.jscalculation) ) {
          zAcrofieldFields.push(jsfield);
          var js = jsfield.jscalculation;
          if( js.indexOf("event.value=") > 0) {
            js = js.substring(js.indexOf("event.value=")+"event.value=".length);
          }
          security = _AformSecurity(js);
          var jse = js.split("'");
          for(var l=0; security && l<jse.length; l++)  {
            if( zZoneNames[jse[l]] != null && zAcrofieldEvents.indexOf(jse[l])<0) {
              zAcrofieldEvents.push(jse[l]);
            }
          }
          zAcrofieldCalculations.push(js);
        }
      }
    }
    if( !security ){
      zAcrofieldCalculations = [];
      zAcrofieldEvents = [];
      zAcrofieldFields = [];
    }
  }
}

function AformExecute(fieldEvtName) {
  if( zAcrofieldEvents.indexOf(fieldEvtName) >= 0) {
    for(var k=0; k<zAcrofieldFields.length; k++) {
      var itm = zAcrofieldFields[k];
      var calc = zAcrofieldCalculations[k];
      var c;
      var ev = 'c = ' + calc;
      eval(ev);
      var ret;
      if (Ctrl(itm.id + '_input')) {
        Ctrl(itm.id + '_input').value = c;
        ret = checkValue(itm, c); //with alert
        Ctrl(itm.id + '_input').value = ret.value;
        if (!ret.ok){
          LibJavascript.CssClassNameUtils.addClass(Ctrl(itm.id + '_input'), 'classError');
        }
        itm.defaultvalue = ret.value;
        itm.isEdited = true;
      }
      else {
        ret = checkValue(itm, c);
        itm.defaultvalue = ret.value;
        itm.isEdited = true;
      } 
      
    }
  } 
}

/* PS Component Functions */

function PS_GetNumberOfPages() {
  return maxPages;
}

function PS_Save(overwriteFile, editField, signmarksToAcroFields) {
  SaveCompilation(overwriteFile, editField, signmarksToAcroFields);
}

function PS_UpdatePDF(filename) {
  LoadPdf(filename);
}

function PS_IsEditable() {
  return _isEditable;
}

function PS_GetData() {
  isLoading = true;
  getdef();
  isLoading = false;
  return jsCompileObj;
}

function PS_GetSignMarksUpdated() {
  isLoading = true;
  getdef();
  isLoading = false;
  return jsUpdSignmarksObj;
}

function PS_HasAcrofields() {
  return hasAcrofields;
}

/* REDEFINED Functions */

function editItemEvent() { //overwrite visualwe/editor.js
}

function Paste(strpaste) { //REDEFINED
  fileSignMarks = strpaste;
  loadSignMarks(true);
}

function selectForm(){ //REDEFINED
  removeAllHandlers()
}

function CopyPaste(a,b) { //REDEFINED //Usata in disegnatore standalone
  var _message = null;
  if( b )
    _message = 'Item/s has been cutted';
  else if( !a && !Empty(deftmpZ) )
    _message = 'Item/s has been pasted';
  else if( a && !b )
  _message = 'Item/s has been copied';
  if( _message != null ){
    notimooManager.show({
      title:'Notification message',
      message:  _message,
      sticky : false,
      visibleTime:1000,
      width:200,
      height:40
    });
  }
  if(a){
    if (window.Copy) deftmpZ=Copy(b);
  }else{
    if (window.Paste) Paste(deftmpZ);
  }
}