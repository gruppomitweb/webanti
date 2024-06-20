/* exported doLoad FillData UpdateCurRec writeHTML ToogleClick GadgetPaneClick NewBO
    EditBO SaveBO DeleteBO ScanDoc ReloadDoc RemoveDoc SetUploadDoc RemovePage
    unRemovePage MergePdf MergeMultiPdf NextBO PreviousBO RemoveStamp
    BoViewerInvalidSignMarks BoViewerExpandReduce BoViewerLoadPdf BoViewerSaveDoc
    BoViewerAddSignMark BoViewerRemoveSignMark BoViewerUpdateSignMark BoViewerEnableAddSignMark
    BoViewerEnableRemoveSignMark BoViewerOnLoaded BoViewerOnSaved BoViewerOnDiscarded
    SendData BOViewerHideZPDFLoadingDiv BOViewerShowZPDFLoadingDiv
*/
/* global zoomid gridid mboname mbokeysvalues m_cAction m_cMode
   pdfzoom canmodpages m_cAtExit msgCancel msgCancelTooltip msgExpand
   msgReduce msgPreview mtitle showsignmarks
*/
var delta_space = 0;
var toggleWin = 0;// mode window
var toggleCov = 1;// mode cover
var toggleMod = toggleCov; //cuurent toggle mod;

var loadbo = false;
var loadzo = false;
var myWindow;
var myZoomPortlet;
var minwidth = 700;
var zpdfminwidth = 435;
var lastbowidth = null;
var expandState = false;
var spModal = window.GetOpener().currentSPModalLayer;

function getOpener() {
  return GetOpener();//(window.opener?window.opener:(window.caller?window.caller:window.parent));
}

function setToggleModNoResize(toggle){
  if(toggle!=toggleMod){
		toggleMod = toggle;
		if($('i_gadget_wrapper').opened==false)
			window["togglePaneR"]();
		else if(toggleMod == toggleCov)
			window["togglePaneR"]();
	}
  if(toggleMod==toggleWin){
		$('gadgets_panerightbarR').removeEvent('click',togglePaneR);
		Ctrl('gadgets_opencloseR').style.display='none';
    	BOViewerRemovePreviewOnTitle();
		if(window.frames["i_gadgetframe"].window.ZBORemoveBackButton) window.frames["i_gadgetframe"].window.ZBORemoveBackButton();
	}
	else{
		$('gadgets_panerightbarR').addEvent('click',togglePaneR);
		Ctrl('gadgets_opencloseR').style.display='none';
    	BOViewerAddPreviewOnTitle();
		if(window.frames["i_gadgetframe"].window.ZBOAddBackButton) window.frames["i_gadgetframe"].window.ZBOAddBackButton();
	}
}

function setToggleMod(toggle, bopagew){
	if(toggle!=toggleMod){
		toggleMod = toggle;
		resizeWindow(null,bopagew);
		if($('i_gadget_wrapper').opened==false)
			window["togglePaneR"]();
		else if(toggleMod == toggleCov)
			window["togglePaneR"]();
	}
	if(toggleMod==toggleWin){
		$('gadgets_panerightbarR').removeEvent('click',togglePaneR);
		Ctrl('gadgets_opencloseR').style.display='none';
    	BOViewerRemovePreviewOnTitle();
		if(window.frames["i_gadgetframe"].window.ZBORemoveBackButton) window.frames["i_gadgetframe"].window.ZBORemoveBackButton();
	}
	else{
		$('gadgets_panerightbarR').addEvent('click',togglePaneR);
		Ctrl('gadgets_opencloseR').style.display='none';
    	BOViewerAddPreviewOnTitle();
		if(window.frames["i_gadgetframe"].window.ZBOAddBackButton) window.frames["i_gadgetframe"].window.ZBOAddBackButton();
	}
  remakeIframesPosition();
}

function init(){
	$('backcanvas').setStyle('left', delta_space);
	$('backcanvas').setStyle('width',window.getWidth()/*-$('gadgets_panerightbarR').offsetWidth*/);
  $('gadgets_panerightbarR').setStyle('display','block');
	$('gadgets_panerightbarR').setStyle('left', $('backcanvas').offsetWidth+delta_space-$('gadgets_panerightbarR').offsetWidth);
	document.id('i_gadget_wrapper').setStyles({'width': $('backcanvas').offsetWidth,'top':0, 'height':'100%'});
  document.id('i_gadgetframe').setStyles({'width': $('backcanvas').offsetWidth});
	//$('backcanvas').setStyle('height',$('i_gadget_wrapper').offsetHeight);
}

function getPortalZoomPortlet(){
	if(zoomid.length>0){
		var portletsList=myWindow.ZtVWeb.getPortlet()
		for (var x in portletsList) {
			var ptl = portletsList[x];
			if(ptl.length){
				for(x=0; x<ptl.length; x++)
					if(ptl[x].formid==zoomid)
						return ptl[x];
			}
			else{
				if(ptl.formid==zoomid)
					return ptl;
			}
		}
	}
	else
		return null;
}

function doLoad(/*e*/){
	myWindow = getOpener();
	create_gadget_paneR();
	init();
	myZoomPortlet = getPortalZoomPortlet();
	var boname = '';
	var keysvalue = '';

	if(myZoomPortlet != null){
		if(!Empty(gridid) && !Empty(myZoomPortlet[gridid])){
			if(myZoomPortlet[gridid].datasource)
				myZoomPortlet[gridid].datasource.addRowConsumer(this);
		}
		if (myZoomPortlet.AddRowConsumer) {
			myZoomPortlet.AddRowConsumer(this);
	    }
	}
	else if (myWindow != null) {
        if (myWindow.AddRowConsumer) {
			myWindow.AddRowConsumer(this);
	    }
    }

	if(mboname.length>0){
		boname = mboname;
		keysvalue = mbokeysvalues;
	}
	else if(myZoomPortlet != null){
		if (myZoomPortlet.GetBOName) {
			boname = myZoomPortlet.GetBOName(gridid);
			if (myZoomPortlet.GetBOKeysValues) keysvalue = myZoomPortlet.GetBOKeysValues(gridid);
	    }
	}
	else if (myWindow != null) {
        if (myWindow.GetBOName) {
			boname = myWindow.GetBOName();
			if (myWindow.GetBOKeysValues) keysvalue = myWindow.GetBOKeysValues();
	    }
    }
	keysvalue = decodeURIComponent(mbokeysvalues);
	var url='../servlet/'+LRTrim(boname);
  	keysvalue=Strtran(keysvalue,'|','=');
	keysvalue=Strtran(keysvalue,'$','&');
	if(m_cAction=='view'){
		if(Empty(keysvalue)){
			m_cAction='new';
			url=url+'?m_cAction=' + m_cAction + '&m_cMode=' + m_cMode + '&m_cAtExit='/*+m_cAtExit*//*+'&m_cDecoration=none'*/;
		}else{
			url=url+'?m_cAction=' + m_cAction + '&'+keysvalue+'&m_cMode=' + m_cMode + '&m_cAtExit='/*+m_cAtExit*//*+'&m_cDecoration=none'*/;
		}
	}
  else {
    url=url+'?m_cAction=' + m_cAction + '&'+keysvalue+'&m_cMode=' + m_cMode + '&m_cAtExit='/*+m_cAtExit*//*+'&m_cDecoration=none'*/;
  }

	////////////////////////////////////////////////////////////
	var zoname = '../zpdfviewer/zpdfviewer.jsp';
	//signgroup|none rimosso per fare vedere le zone di firma
	var zokeysvalue = 'enabletoolbar|true,ignoreInnerMrp|true,candownload|false,canprint|false,modebook|false,canupload|false,canprint|true,candownload|true,canaddstamp|false,hideversion|true,modelight|true,boviewer|true'; //default
	if( showsignmarks == false )
		zokeysvalue+=',signgroup|none';
	if(pdfzoom!=999 && pdfzoom>=50 && pdfzoom<=400)
		zokeysvalue+=',zoom|'+pdfzoom;
	zokeysvalue+=',canmodpages|'+canmodpages;
	zokeysvalue+=',title|'+mtitle;
	if(myZoomPortlet != null){
		if (myZoomPortlet.getZPdfSettings) {
		  zokeysvalue = myZoomPortlet.getZPdfSettings();
	    }
	}
	else if (myWindow != null) {
      if (myWindow.getZPdfSettings) {
    zokeysvalue = myWindow.getZPdfSettings();
    }
  }
	var zurl;
	zokeysvalue=Strtran(zokeysvalue,'|','=');
	zokeysvalue=Strtran(zokeysvalue,',','&');
	zurl = zoname+"?"+zokeysvalue;

	////////////////////////////////////
	var zbosettings = '';
	if(myZoomPortlet != null){
		if (myZoomPortlet.getZBOSettings) {
		  zokeysvalue = myZoomPortlet.getZBOSettings();
	    }
	}
	else if (myWindow != null) {
      if (myWindow.getZBOSettings) {
    	zbosettings = myWindow.getZBOSettings();
      }
  }

	var mode=toggleMod;
	if(zbosettings.length>0){
		var arrayreload=zbosettings.split(',')
		var arrayreload2;
		for(var i=0;i<arrayreload.length;i++){
			arrayreload2 = arrayreload[i].split('|');
			var type=arrayreload2[0];
			var value=arrayreload2[1];
			if(type=='mode' && value=='window'){
				mode = toggleWin;
			}
			else if(type=='mode' && value!='window'){
				mode = toggleCov;
			}
		}
	}
  else
    mode = toggleWin;

	if(mode!=toggleMod ){
		setToggleMod(mode);
	}

	/////////////////////////////////////////
  loadzo = false;
  loadbo = false;
	$('i_canvasframe').onload = function() {
		loadbo = true;
		LoadBO(true);
	};
	$('i_gadgetframe').onload = function() {
		loadzo = true;
		LoadBO(true);
	};
	var m_cExtra=JSURL.Extra(url)
  	if (m_cExtra)
   	url+=(At('?',url)>0?'&':'?')+'m_c'+'Check='+URLenc(m_cExtra);
	$('i_canvasframe').src=url;
	$('i_gadgetframe').src=zurl;

	AbilitateNextPrev();
	AbilitateNextPrevMode();

	window.onunload = function() {
		if(myZoomPortlet != null){
			if (myZoomPortlet.RemoveRowConsumer) {
				myZoomPortlet.RemoveRowConsumer(this);
			}
		}
		else if (myWindow != null) {
			if (myWindow.RemoveRowConsumer) {
				myWindow.RemoveRowConsumer(this);
			}
		}
	}
}

function resizeWindow(/*e,bopagew*/){
  var bowidth = minwidth;
  if(lastbowidth!=null) bowidth = lastbowidth;
  var ww = window.getWidth() -2*$('backcanvas').offsetLeft//-$('gadgets_panerightbarR').offsetWidth;
  var ww1 = bowidth;
  var ww2 = ww - ww1;
	if(toggleMod==toggleCov){
		if(ww2>zpdfminwidth){
			setToggleModNoResize(toggleWin);
		}
	}
	else{
		if(ww2<zpdfminwidth){
			setToggleModNoResize(toggleCov);
		}
	}
  remakeIframesPosition();

  if( loadbo && loadzo && !boexpandreduce ) {
    expandState = !expandState;
    BoViewerExpandReduceToolbar()
  }
  boexpandreduce = false;
}

function remakeIframesPosition() {
  var bowidth = minwidth;
  if(lastbowidth!=null) bowidth = lastbowidth;
  var ww = window.getWidth() -2*$('backcanvas').offsetLeft//-$('gadgets_panerightbarR').offsetWidth;
  var ww1 = bowidth;
  var ww2 = ww - ww1;
  var hh = window.getHeight() - $('backcanvas').offsetTop;
  if(toggleMod==toggleCov){
    $('backcanvas').setStyle('width',window.getWidth());
    $('gadgets_panerightbarR').setStyle('display','block') ;
    $('gadgets_panerightbarR').setStyle('left', $('backcanvas').offsetWidth+delta_space-$('gadgets_panerightbarR').offsetWidth);
    $('i_gadget_wrapper').setStyle('left', $('backcanvas').offsetWidth+delta_space);
    $('i_gadget_wrapper').setStyle('width', $('backcanvas').offsetWidth);
    $('i_gadgetframe').setStyle('width', $('backcanvas').offsetWidth);
    $('i_gadget_wrapper').setStyle('height', hh);
    $('i_gadgetframe').setStyle('height', hh);
    $('gadgets_opencloseR').setStyle('display','none');
    BOViewerAddPreviewOnTitle();
  }
  else {
    $('backcanvas').setStyle('width',ww1);
    $('gadgets_panerightbarR').setStyle('display','block') ;
    $('gadgets_panerightbarR').setStyle('left', $('backcanvas').offsetWidth+delta_space-$('gadgets_panerightbarR').offsetWidth);
    $('i_gadget_wrapper').setStyle('left', ww1);
    $('i_gadget_wrapper').setStyle('width', ww2);
    $('i_gadgetframe').setStyle('width', ww2);
    $('i_gadget_wrapper').setStyle('height', hh);
    $('i_gadgetframe').setStyle('height', hh);
    $('gadgets_opencloseR').setStyle('display','none') ;
    BOViewerRemovePreviewOnTitle();
  }
}

function EnableToolbarBtn(mode){
	if(window.frames["i_gadgetframe"].window.EnableToolbar) window.frames["i_gadgetframe"].window.EnableToolbar(mode);
}

function FillData(/*obj*/){
	ReloadBOFrame();
}

function UpdateCurRec(/*obj*/){
	ReloadBOFrame();
}

function writeHTML(/*reset*/) {
}

var togglePaneR = function(){
	var i_gadget_wrapper=document.id('i_gadget_wrapper');
	if(toggleMod==toggleCov){
		if($('i_gadget_wrapper').opened){
      $('i_gadget_wrapper').opened = false;
      i_gadget_wrapper.setStyle('display','none');
      i_gadget_wrapper.setStyle('left',window.getWidth());
      $('gadgets_panerightbarR').setStyle('left',$('backcanvas').offsetWidth+delta_space-$('gadgets_panerightbarR').offsetWidth);
      $('gadgets_opencloseR').setStyle('display','none');
      BOViewerAddPreviewOnTitle();
      $('gadgets_opencloseR').addClass('zPdfIcon');
      $('gadgets_opencloseR').addClass('attach');
		}else{
      $('i_gadget_wrapper').opened = true;
			i_gadget_wrapper.setStyle('display','block');
      i_gadget_wrapper.setStyle('left',$('backcanvas').offsetLeft+delta_space);
			$('gadgets_panerightbarR').setStyle('left',delta_space);
      $('gadgets_opencloseR').setStyle('display','none');
      BOViewerRemovePreviewOnTitle();
      $('gadgets_opencloseR').addClass('zPdfIcon');
      $('gadgets_opencloseR').removeClass('attach');
		}
	}
	else{
		if($('i_gadget_wrapper').opened){
      $('i_gadget_wrapper').opened = false;
      i_gadget_wrapper.setStyle('display','none');
      i_gadget_wrapper.setStyle('left',window.getWidth());
			$('gadgets_panerightbarR').setStyle('left',$('backcanvas').offsetWidth+delta_space-$('gadgets_panerightbarR').offsetWidth) ;
		}else{
      $('i_gadget_wrapper').opened = true;
      i_gadget_wrapper.setStyle('display','block');
      i_gadget_wrapper.setStyle('left',$('backcanvas').offsetLeft+delta_space);
			$('gadgets_panerightbarR').setStyle('left',$('backcanvas').offsetWidth+delta_space-$('gadgets_panerightbarR').offsetWidth) ;
		}
	}
	if(window.frames["i_gadgetframe"].window.zoom) window.frames["i_gadgetframe"].window.zoom(pdfzoom);
}

function create_gadget_paneR(){
	$('gadgets_panerightbarR').addEvent('click',togglePaneR);
	Ctrl('gadgets_opencloseR').style.display='none';
  BOViewerRemovePreviewOnTitle();
	/*all'inizio � chiuso*/
	$('i_gadget_wrapper').opened = false;
	$('i_gadget_wrapper').setStyle('display','block');
	$('i_gadget_wrapper').setStyle('left',window.getWidth());
}

//funzioni da toolbar
function ToogleClick(){
	$('gadgets_panerightbarR').fireEvent('click');
}

function ReloadBOFrame(){
	var boname = '';
	var keysvalue = '';

	if(myZoomPortlet != null){
		if (myZoomPortlet.GetBOName) {
			boname = myZoomPortlet.GetBOName(gridid);
			if (myZoomPortlet.GetBOKeysValues) keysvalue = myZoomPortlet.GetBOKeysValues(gridid);
	    }
	}
	else if (myWindow != null) {
        if (myWindow.GetBOName) {
		  boname = myWindow.GetBOName();
		  if (myWindow.GetBOKeysValues) keysvalue = myWindow.GetBOKeysValues();
	    }
    }

	if(m_cAction=='new'){
		//rimanere in modalita' new
	}
	else{
		var url;
		url='../servlet/'+LRTrim(boname);
		keysvalue=Strtran(keysvalue,'|','=');
		keysvalue=Strtran(keysvalue,'$','&');
		if(Empty(keysvalue)){
			url=url+'?m_cAction=new&'+keysvalue+'&m_cMode=' + m_cMode + '&m_cAtExit='/*+m_cAtExit*//*+'&m_cDecoration=none'*/;
		}else{
		// in stato di view
			url=url+'?m_cAction=view&'+keysvalue+'&m_cMode=' + m_cMode + '&m_cAtExit='/*+m_cAtExit*//*+'&m_cDecoration=none'*/;
		}
		loadbo = false;
		$('i_canvasframe').onload = function() {
			loadbo = true;
			LoadBO();
		};
		$('i_canvasframe').src=url;
	}
	AbilitateNextPrev();
	AbilitateNextPrevMode();
}
///////////////////

function SetToolBarFunctions() {
	if(!Empty($('i_gadgetframe').src) && !Empty($('i_canvasframe').src) && window.frames["i_canvasframe"] && window.frames["i_canvasframe"].ZtVWeb) {
		var titleP = window.frames["i_canvasframe"].ZtVWeb.getPortlet("default_title_form_ui");
		if(titleP && titleP.toolbar) {
		  var t = titleP.toolbar;
		  var expAfter = "query";
		  if( m_cAtExit == 'close' ) {
			t.Remove("query"); //remove query
			var cancelObj = {}; //add cancel
			cancelObj.action = "javascript:window.parent.CancelBO()";
			cancelObj.cssClass = "";
			cancelObj.image = { fontFamily: "icons8_win10", value : "&#xf048"};
			cancelObj.id = "close_bo";
			cancelObj.title = msgCancel;
			cancelObj.tooltip = msgCancelTooltip;
			cancelObj.target = "";
			t.AppendAfter(cancelObj, 'save');
			expAfter = "close_bo";
		  }
		  if ( spModal ) {
			var expObj = {};
			expObj.action = "javascript:window.parent.BoViewerExpandReduce()";
			expObj.cssClass = "";
			expObj.image = { fontFamily: "icons8_win10", value : "&#xee18"/* efd2 */};
			expObj.id = "expandreduce_bo";
			expObj.title = msgExpand;
			expObj.tooltip = msgExpand;
			expObj.target = "";
			t.AppendAfter(expObj, expAfter);
		  }
		  var items = t.GetItems();
		  for( var i = 0; i < items.length; i++) {
			var newaction = "";
			if(items[i].id == 'save') {
			  newaction = "javascript:window.parent.SaveBO()"
			}
			else if(items[i].id == 'edit') {
			  newaction = "javascript:window.parent.EditBO()"
			}
			else if(items[i].id == 'add') {
			  newaction = "javascript:window.parent.NewBO()"
			}
			else if(items[i].id == 'delete') {
			  newaction = "javascript:window.parent.DeleteBO()"
			}
			else if(items[i].id == 'close_ok' || items[i].id == 'close_discard') {
			  newaction = "javascript:window.parent.CancelBO()"
			}
			if(!Empty(newaction)) t.UpdateItem( items[i].id, { action:newaction } );
		  }
		  if( window.frames["i_gadgetframe"].window.ZViewerUpdateToolbar )
			window.frames["i_gadgetframe"].window.ZViewerUpdateToolbar(titleP);
		}
	}
}

function LoadBO(winit){
  if(loadbo && !Empty($('i_canvasframe').src)){
    if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.LibJavascript) window.frames["i_canvasframe"].window.LibJavascript.RequireLibrary(ZtVWeb.SPWebRootURL + "/zboviewer/zbo.js");
  }

  if(!(loadbo && loadzo)) return;

  loadzo = false;
  loadbo = false;

  Ctrl('loading').addClass('hide');
	var bodata='';
	if(!Empty($('i_canvasframe').src)){
    if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_beforegetDocument){
			window.frames["i_canvasframe"].window.zbo_beforegetDocument();
		}
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_getDocument){
			bodata = window.frames["i_canvasframe"].window.zbo_getDocument();
		}
	}

  if(!Empty($('i_gadgetframe').src)){
    if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.SetZBOViewerWindow){
      window.frames["i_gadgetframe"].window.SetZBOViewerWindow(window);
    }
	if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.LoadPdf){
      if(window.frames["i_gadgetframe"].window.getPdfFileName) {
        window.frames["i_gadgetframe"].window.LoadPdf(bodata,false);
        //anche se il nome del file non cambiata, il file in realta' potrebbe essere cambiato in modo significativo
        // per esempuo con la gestione dei cropBox
      }
      else {
        window.frames["i_gadgetframe"].window.LoadPdf(bodata,false);
      }
   	}
  }

  if( window.parent && window.parent.getWidth() <= 1024 )  {
    spModal = null;
  }

  if(winit && !Empty($('i_gadgetframe').src)){
		if(toggleMod==toggleWin && window.frames["i_gadgetframe"].window.ZBORemoveBackButton){
	  		window.frames["i_gadgetframe"].window.ZBORemoveBackButton();
		}
		//load on mode toggleWin
		var page1 = window.frames["i_canvasframe"].window.document.getElementById('page_1');
		if(page1){
			//var ww = window.getWidth() -2*$('backcanvas').offsetLeft-$('gadgets_panerightbarR').offsetWidth;
			var bowidth = parseInt(page1.style.width) + 10;
			lastbowidth = bowidth;
			//var ww1 = bowidth;
			//var ww2 = ww - ww1;
			if(window.frames["i_gadgetframe"].window.getMinWidth) {
				zpdfminwidth = window.frames["i_gadgetframe"].window.getMinWidth();
			}
			Ctrl('gadgets_opencloseR').style.display='none';
			//if(ww2>zpdfminwidth){
				setToggleMod(toggleWin, bowidth);
			//}
			//BOViewerAddPreviewOnTitle();
			expandState = false;
			BoViewerExpandReduceToolbar();
		}
	}

  SetToolBarFunctions();

  if(!Empty($('i_canvasframe').src)){
    if( window.frames["i_canvasframe"].window.zbo_beforeexecEvent ){
      window.frames["i_canvasframe"].window.zbo_beforeexecEvent('After Row Selected');
    }
    if( window.frames["i_canvasframe"].window.zbo_execEvent ){
      window.frames["i_canvasframe"].window.zbo_execEvent('After Row Selected');
    }
    if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_getCurRowSign){
      BoViewerSelectSignMark(window.frames["i_canvasframe"].window.zbo_getCurRowSign());
    }
  }

	checkToolbar();
	EnableToolbarBtn(m_cAction);
	AbilitateNextPrev();
	AbilitateNextPrevMode();
}

function GadgetPaneClick() {
  $('gadgets_panerightbarR').fireEvent('click');
}

function NewBO(){
	m_cAction = 'new';
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.SubmitListenerForm)
			window.frames["i_canvasframe"].window.SubmitListenerForm('new');
	}
	AbilitateNextPrev();
	AbilitateNextPrevMode();
}

function EditBO(){
  Ctrl('loading').removeClass('hide');
  var fnToDelayG = function () {
    m_cAction = 'edit';
    if(!Empty($('i_canvasframe').src)){
      if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.SubmitListenerForm)
        window.frames["i_canvasframe"].window.SubmitListenerForm('edit');
    }
    if(!Empty($('i_gadgetframe').src)){
      if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.EditBO)
        window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.EditBO();
    }
    Ctrl('loading').addClass('hide');
    AbilitateNextPrev();
    AbilitateNextPrevMode();
  }
  fnToDelayG.delay(200);
}

function SaveBO(){
  Ctrl('loading').removeClass('hide');
  var fnToDelayG = function () {
    var bodata='';
	var bocheck=false;
    if(!Empty($('i_gadgetframe').src)){
      if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.m_bUpdated && window.frames["i_gadgetframe"].window.SaveBO)
        window.frames["i_gadgetframe"].window.SaveBO();
      if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.getPdfFileName)
        bodata = window.frames["i_gadgetframe"].window.getPdfFileName();
    }
    if(!Empty($('i_canvasframe').src)){
      if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_beforesetDocument){
        window.frames["i_canvasframe"].window.zbo_beforesetDocument(bodata);
      }
      if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_setDocument){
        window.frames["i_canvasframe"].window.zbo_setDocument(bodata);
      }
      if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.SendData){
        //window.frames["i_canvasframe"].window.m_bUpdated = true; //forzatura
        if(window.frames["i_canvasframe"].window.SaveRow ) {
          bocheck = window.frames["i_canvasframe"].window.SaveRow(true);
        }
          if( bocheck && window.frames["i_canvasframe"].window.Check ) {
          bocheck = window.frames["i_canvasframe"].window.Check();
        }
        if(bocheck) {
			try{
				bocheck = false;///wkin
				window.frames["i_canvasframe"].window.SendData('save');
			}
			catch(e){
				bocheck = false;
			}
        } else {
          window.frames["i_canvasframe"].window.DisplayErrorMessage();
        }
      }
	}
    if(bocheck && !window.frames["i_canvasframe"].window.m_bUpdated && m_cAtExit == 'close') {
      ExitClose();
      return;
    }
    if( !bocheck ){
      Ctrl('loading').addClass('hide');
    }
    /*if(bocheck && m_cAtExit != 'close') { //on saved
      Ctrl('loading').addClass('hide');
      m_cAction = 'view';
      EnableToolbarBtn(m_cAction);
      AbilitateNextPrev();
      AbilitateNextPrevMode();
    }*/
  }
  fnToDelayG.delay(200);
}

function CancelBO(){
  Ctrl('loading').removeClass('hide');
  function InnerOut ( p_bResult ) {
    if (p_bResult && window.frames["i_canvasframe"].window) {
      window.frames["i_canvasframe"].window.SendData('discard');
      /*if(m_cAtExit == 'close') { //on discarded
        ExitClose();
        return;
      }*/
      /*if(m_cAction=='edit'){
        m_cAction = 'view';
        EnableToolbarBtn(m_cAction);
        AbilitateNextPrev();
        AbilitateNextPrevMode();
      }*/
      /*else {
        ExitClose();
        return;
      }*/
    }
    else {
      Ctrl('loading').addClass('hide');
    }
  }

  var fnToDelayG = function () {
    if(!Empty($('i_gadgetframe').src)){
      if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.CancelBO)
        window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.CancelBO();
    }
    if(!Empty($('i_canvasframe').src)){
      if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.SendData && (m_cAction=='new' || m_cAction=='edit')){
        window.frames["i_canvasframe"].window.m_bUpdated = true;
        if( !window.frames["i_canvasframe"].window.m_bUpdated ) {
          InnerOut(true);
        }
        else {
          return window.frames["i_canvasframe"].window.WindowConfirm(window.frames["i_canvasframe"].window.Translate('MSG_LEAVE_MOD'), InnerOut);
        }
      }
    }
    InnerOut(true);
  }
  fnToDelayG.delay(200);
}

function DeleteBO(){
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.SubmitListenerForm)
			window.frames["i_canvasframe"].window.SubmitListenerForm('delete');
	}
	if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.DeleteBO)
			window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.DeleteBO();
	}
  if(m_cAtExit == 'close') {
    ExitClose();
    return;
  }
	AbilitateNextPrev();
	AbilitateNextPrevMode();
}

function ExitClose() {
  WindowClose();
}

function ScanDoc(){
	var bodata='';
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_scanDocument){
			bodata = window.frames["i_canvasframe"].window.zbo_scanDocument();
		}
	}
	if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.LoadPdf){
			/*if(window.frames["i_gadgetframe"].window.getPdfFileName && (bodata != window.frames["i_gadgetframe"].window.getPdfFileName()) && m_cAction!='view'){
				 if(confirm("Load document from BO?")){
					window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.LoadBO(bodata);
				 }
			}
			else*/
			window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.LoadPdf(bodata,false);
		}
	}
}

function ReloadDoc(){
	var bodata='';
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_getOriginalDocument){
			bodata = window.frames["i_canvasframe"].window.zbo_getOriginalDocument();
		}
	}
	if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.LoadPdf){
			window.frames["i_gadgetframe"].window.LoadPdf(bodata,false);
		}
	}
}

function RemoveDoc(){
	if(!Empty($('i_canvasframe').src)){
    if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_beforeremoveDocument){
			window.frames["i_canvasframe"].window.zbo_beforeremoveDocument();
		}
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_removeDocument){
			window.frames["i_canvasframe"].window.zbo_removeDocument();
		}
	}
}

function SetUploadDoc(filepath, signMarksArray, upload){
	if(!Empty($('i_canvasframe').src)){
    if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_beforeuploadDocument){
			window.frames["i_canvasframe"].window.zbo_beforeuploadDocument(filepath, signMarksArray, upload);
		}
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_uploadDocument){
			window.frames["i_canvasframe"].window.zbo_uploadDocument(filepath, signMarksArray, upload);
		}
	}
}

function RemovePage(p){
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_removePage){
			window.frames["i_canvasframe"].window.zbo_removePage(p);
		}
	}
}

function unRemovePage(p){
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_unremovePage){
			window.frames["i_canvasframe"].window.zbo_unremovePage(p);
		}
	}
}

function MergePdf(pdf1,pdf2){
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_mergePdf){
			window.frames["i_canvasframe"].window.zbo_mergePdf(pdf1,pdf2);
		}
	}
}

function MergeMultiPdf(afile,pdf2){
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_mergemultiPdf){
			window.frames["i_canvasframe"].window.zbo_mergemultiPdf(afile,pdf2);
			return;
		}
	}
}

//funzioni da toolbar fine
function NextBO(){
	m_cAction = 'view';
	if(myZoomPortlet != null){
		if(!Empty(gridid) && !Empty(myZoomPortlet[gridid])){
			if (myZoomPortlet[gridid].NextRecord)
					myZoomPortlet[gridid].NextRecord();
		}
		else if (myZoomPortlet.MoveBONext)
			myZoomPortlet.MoveBONext();
	}
    else if(window.frames["i_canvasframe"].window){
		if(window.frames["i_canvasframe"].window.zbo_moveBONext)
			window.frames["i_canvasframe"].window.zbo_moveBONext();
	}
	else if(myWindow != null){
		if (myWindow.MoveBONext)
		myWindow.MoveBONext();
	}
}

function PreviousBO(){
	m_cAction = 'view';
	if(myZoomPortlet != null){
		if(!Empty(gridid) && !Empty(myZoomPortlet[gridid])){
			if (myZoomPortlet[gridid].PrevRecord)
					myZoomPortlet[gridid].PrevRecord();
		}
		else if (myZoomPortlet.MoveBOPrevious)
			myZoomPortlet.MoveBOPrevious();
	}
	else if(window.frames["i_canvasframe"].window){
		if(window.frames["i_canvasframe"].window.zbo_moveBOPrevious)
			window.frames["i_canvasframe"].window.zbo_moveBOPrevious();
	}
	else if(myWindow != null){
		if (myWindow.MoveBOPrevious)
		myWindow.MoveBOPrevious();
	}
}

function RemoveStamp(){
	if(!Empty($('i_canvasframe').src)){
		if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_removeStamp){
			window.frames["i_canvasframe"].window.zbo_removeStamp();
		}
	}
}

function AbilitateNextPrevMode(){
	if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_getBOEof){
    }
    else if(m_cAction=='view'){
	}
	else{
		Ctrl('nextBtn').style.display = 'none';
		Ctrl('prevBtn').style.display = 'none';
	}
}

function AbilitateNextPrev(){
	var n = false;
	var p = false;
	if(myZoomPortlet != null){
		if(!Empty(gridid) && !Empty(myZoomPortlet[gridid])){
			if (myZoomPortlet[gridid].datasource.Eof)
				n = !(myZoomPortlet[gridid].datasource.Eof());
			if (myZoomPortlet[gridid].datasource.Bof)
				p = !(myZoomPortlet[gridid].datasource.Bof() && myZoomPortlet[gridid].datasource.curRec==1);
		}
		else{
			if (myZoomPortlet.GetBOEof)
				n = !(myZoomPortlet.GetBOEof());
			if (myZoomPortlet.GetBOBof)
				p = !(myZoomPortlet.GetBOBof());
		}

	}
	else if(window.frames["i_canvasframe"].window){
		if(window.frames["i_canvasframe"].window.zbo_getBOEof)
			n = !(window.frames["i_canvasframe"].window.zbo_getBOEof());
		if(window.frames["i_canvasframe"].window.zbo_getBOBof)
			p = !(window.frames["i_canvasframe"].window.zbo_getBOBof());
	}
	else if(myWindow != null){
		if (myWindow.GetBOEof)
			n = !(myWindow.GetBOEof());
		if (myWindow.GetBOBof)
			p = !(myWindow.GetBOBof());
	}

	if(n) Ctrl('nextBtn').style.display = 'block';
	else Ctrl('nextBtn').style.display = 'none';

	if(p) Ctrl('prevBtn').style.display = 'block';
	else Ctrl('prevBtn').style.display = 'none';

}

function checkToolbar(){
	/*Ctrl('bnew').style.display='none';
	Ctrl('bnew').style.width='0px';*/
	if(m_cAction=='new' || m_cAction=='edit'){
		Ctrl('bedit').style.display='none';
		Ctrl('bsave').style.display='inline-block';
		Ctrl('bclose').style.display='none';
		Ctrl('bcancel').style.display='inline-block';
		Ctrl('bdelete').style.display='none';
	}
	else if(m_cAction=='view'){
		Ctrl('bsave').style.display='none';
		Ctrl('bedit').style.display='inline-block';
		Ctrl('bcancel').style.display='none';
		Ctrl('bclose').style.display='inline-block';
		Ctrl('bdelete').style.display='inline-block';
	}
}

/************************************************************/

function BoViewerInvalidSignMarks( /*signMarks*/ ) {
	//20211014 non dovrebbe piu farlo
  /*if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.RemoveSignMarks){
			window.frames["i_gadgetframe"].window.RemoveSignMarks(signMarks);
		}
	}*/
}

var boexpandreduce = false;
function BoViewerExpandReduce() {
  boexpandreduce = false;
  if(!spModal) return;
  if(Empty($('i_gadgetframe').src)) return;
  if(!window.frames["i_canvasframe"]) return;
  if(!window.frames["i_canvasframe"].ZtVWeb) return;
  var titleP = window.frames["i_canvasframe"].ZtVWeb.getPortlet("default_title_form_ui");
  var t;
  if(titleP && titleP.toolbar) {
    t = titleP.toolbar;
  }
  if (!t)
    return;

  boexpandreduce = true;
  if(expandState == true) {
    //reduce
    expandState = false;
    spModal.restoreSize();
  }
  else {
    //expand
    expandState = true;
    spModal.maximize();
  }
  BoViewerExpandReduceToolbar();
}

function BoViewerExpandReduceToolbar() {
  if(!spModal) return;
  if(Empty($('i_gadgetframe').src)) return;
  if(!window.frames["i_canvasframe"]) return;
  if(!window.frames["i_canvasframe"].ZtVWeb) return;
  var titleP = window.frames["i_canvasframe"].ZtVWeb.getPortlet("default_title_form_ui");
  var t;
  if(titleP && titleP.toolbar) {
    t = titleP.toolbar;
  }
  if (!t)
    return;
  var expObj = {};
  if(expandState == true) {
    expObj.image = { fontFamily: "icons8_win10", value : "&#xefd2"};
    expObj.title = msgReduce;
    expObj.tooltip = msgReduce;
  }
  else {
    expObj.image = { fontFamily: "icons8_win10", value : "&#xee18"};
    expObj.title = msgExpand;
    expObj.tooltip = msgExpand;
  }
  t.UpdateItem( "expandreduce_bo", expObj );
}

function BoViewerLoadPdf(bodata){
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.LoadPdf){
			window.frames["i_gadgetframe"].window.LoadPdf(bodata,false);
		}
	}
}

function BoViewerSaveDoc() {
  var bodata='';
  if(!Empty($('i_gadgetframe').src)){
    if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.SaveBO)
      window.frames["i_gadgetframe"].window.SaveBO();
    if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.getPdfFileName)
      bodata = window.frames["i_gadgetframe"].window.getPdfFileName();
  }
  if(!Empty($('i_canvasframe').src)){
    if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_beforesetDocument){
        window.frames["i_canvasframe"].window.zbo_beforesetDocument(bodata);
      }
    if(window.frames["i_canvasframe"].window && window.frames["i_canvasframe"].window.zbo_setDocument){
      window.frames["i_canvasframe"].window.zbo_setDocument(bodata);
    }
  }
}

function BoViewerAddSignMark(rowjson) {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.addSignMark){
			window.frames["i_gadgetframe"].window.addSignMark(rowjson);
		}
	}
}

function BoViewerRemoveSignMark(rowjson) {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.removeSignMark){
			window.frames["i_gadgetframe"].window.removeSignMark(rowjson);
		}
	}
}

function BoViewerUpdateSignMark(rowjson) {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.updateSignMark){
			window.frames["i_gadgetframe"].window.addSignMark(rowjson, true);
		}
	}
}

function BoViewerSelectSignMark(rowjson) {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.selectSignMark){
			window.frames["i_gadgetframe"].window.selectSignMark(rowjson, false, true);
		}
	}
}

function BOViewerAddPreviewOnTitle() {
  if( spModal ) return;
  if(Empty($('i_gadgetframe').src)) return;
  if(!window.frames["i_canvasframe"]) return;
  if(!window.frames["i_canvasframe"].ZtVWeb) return;
  var titleP = window.frames["i_canvasframe"].ZtVWeb.getPortlet("default_title_form_ui");
  if(titleP && titleP.toolbar) {
    var t = titleP.toolbar;
    var prevObj = {};
    prevObj.action = "javascript:window.parent.GadgetPaneClick()";
    prevObj.cssClass = "";
    prevObj.image = { fontFamily: "icons8_win10", value : "&#xebb4"};
    prevObj.id = "zpdfviewer";
    prevObj.title = msgPreview;
    prevObj.tooltip = "PDF Preview";
    prevObj.target = "";
    t.Append(prevObj, 1);
  }
}

function BOViewerRemovePreviewOnTitle() {
  if( spModal ) return;
  if(Empty($('i_gadgetframe').src)) return;
  if(!window.frames["i_canvasframe"]) return;
  if(!window.frames["i_canvasframe"].ZtVWeb) return;
  var titleP = window.frames["i_canvasframe"].ZtVWeb.getPortlet("default_title_form_ui");
  if(titleP && titleP.toolbar) {
    var t = titleP.toolbar;
    t.Remove("zpdfviewer");
  }
}

function BoViewerEnableAddSignMark ( enable ) {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.ZViewerEnableAddSignMark){
			window.frames["i_gadgetframe"].window.ZViewerEnableAddSignMark(enable);
		}
	}
}

function BoViewerEnableRemoveSignMark ( enable ) {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.ZViewerEnableRemoveSignMark){
			window.frames["i_gadgetframe"].window.ZViewerEnableRemoveSignMark(enable);
		}
	}
}

function BoViewerOnLoaded() {
	SetToolBarFunctions();
}

function BoViewerOnSaved() {
  if(m_cAtExit == 'close') {
    ExitClose();
    return;
  }
  else {
    Ctrl('loading').addClass('hide');
    m_cAction = 'view';
    EnableToolbarBtn(m_cAction);
    AbilitateNextPrev();
    AbilitateNextPrevMode();
  }
}

function BoViewerOnDiscarded() {
  if(m_cAtExit == 'close') {
    ExitClose();
    return;
  }
  else if(m_cAction=='edit') {
    Ctrl('loading').addClass('hide');
    m_cAction = 'view';
    EnableToolbarBtn(m_cAction);
    AbilitateNextPrev();
    AbilitateNextPrevMode();
  }
}

function SendData(/*m_function*/) { //simulate BO -sendData - per chiusura da spmodallayer
  CancelBO();
}

function BOViewerHideZPDFLoadingDiv() {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.hideLoadingDiv){
			window.frames["i_gadgetframe"].window.hideLoadingDiv();
		}
	}
}

function BOViewerShowZPDFLoadingDiv() {
  if(!Empty($('i_gadgetframe').src)){
		if(window.frames["i_gadgetframe"].window && window.frames["i_gadgetframe"].window.showLoadingDiv){
			window.frames["i_gadgetframe"].window.showLoadingDiv();
		}
	}
}
