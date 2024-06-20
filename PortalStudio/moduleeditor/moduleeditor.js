/*  exported def tool xxpos yypos rotation pdfLoading xmlLoading vrpLoading pdffile
    _original_onselectstart zoomindex maxpages changeselectshadow toolbars elementShadow dragSelection
    doLoad Help Copy Paste toolbarPreview newCurrentObj newdesign resetGenericLight openModule LoadFieldsVrp
    rgbToHex EditVrp ReloadFields ExpressionLoadVrp addLayer removeLayer addTreeItem resizeDivContainer
    removeAllImgHandlers addImgHandlers EndPutShadowField findDragItems ValidMove
    endDragHandler beginDragSelection2 convertDateTimeLowerCase convertDateTimeUpperCase putSystemVarNumPage
    putSystemVarTotalPages renderApi getRenderApiObjClass EditEUNotes ExpressionNotesReturn openerAddItem
	openerAddFixedElements
 */
/* global designToolbar resizeWindow openas selectedZoombox generateRulers insertIntoUndoSequence
   docpageindex clCanvasLib fieldcountindex checkMargins resetTabs setPropertiesID reload_
   itemsHTMLArray imgHTML tabs initCanvas version folder_path adjustTabHeight
   modefieldtree toHex selectImg selectItemImg enableDocumentSelection draggedItemIdx LoadPdfz modelightqr
   managebarcodeqr
*/
var currentname = ""; // Nome del modello corrente
var def = ""; // Def del modello corrente
var tool = "module"; // Tool utilizzato
var xxpos; // for insert image dialog
var yypos;
var rotation = false;
var saveas = false;
var isLoading = false;
var pdfLoading = false;
var xmlLoading = false;
var vrpLoading = false;
var pdffile = "";
var fieldfile = "";
var w_init = 0;
var h_init = 0;
var _original_onselectstart = document.onselectstart;
var zoomindex = 2;
var maxpages = -1; // Numero di pagine del file pfd

var workAreaWidth = -1;
var workAreaHeight = -1;

var putok = true;
var putalert = true;
var m_bUpdated2 = false;
var notimooManager;

var fld_accordion = null;
var gadgetload = false;
var changeselectshadow = false;
var pasted = [];
var bcList = [];

var toolbars = {};

var type; //Tipo dell'item da aggiungere

var AfterSave;
var deltax = 0, deltay = 0;
var elementsNrByGroup = []; /* Contiene Numero di campi di ogni gruppo del vrp*/
var _pdfsrc;

/* *** Variabili per la gestione spostamento degli item *** */
var elementShadow;
var dragSelection = false; //Variabile per il drag
var alreadyClose = false;

var ufunction = function()  {
  var portlet_name = "";
  currentname = Strtran(currentname, '\\', "/");
  if (currentname.indexOf('/') > -1) {
    portlet_name = currentname.substring(currentname.lastIndexOf("/") + 1);
  } else {
    portlet_name = currentname;
  }
  var opener = GetOpener();
  if( opener == null ) opener = window.parent;

  if(!alreadyClose) {
  if (opener.cbscanedit_close) {
    opener.cbscanedit_close(portlet_name, window);
	} else {
		closePageletPortlet(portlet_name, opener, window);
  }
	alreadyClose = true;
  }
}
LibJavascript.Events.addEvent(window, 'beforeunload', ufunction);

function doLoad(e, id, mode, pdfsrc, fieldsrc) {
  _pdfsrc = pdfsrc;
  initPainter();
  notimooManager.show({
    title : 'Notification message',
    message : 'loading Module Editor!',
    visibleTime : 2000,
    width : 200
  });
  var fnToDelay = function () {
    isLoading = true;
    canAlign = true;
    AppletTag("Batch");
    BatchApplet().documentloc = Strtran(location.toString(), "visualweb/editor.jsp", "servlet/dummy");
    document.body.style.cursor = "default";
    document.body.onhelp = CancelHelp;

    designToolbar();

    if (Ctrl("toolbarimgz")) {
      Ctrl("toolbarimgz").style.width = "0px";
    }

    var ctrl = Ctrl("gadgets_pane");

    if (ctrl && gadgetload == false) {
      ctrl.style.display = "block";
      $('gadgets_panerightbar').fireEvent('click');
    }
    /* Inizializzazione del menu accordion per i fields del Fields Explorer */
    if (fld_accordion == null) {
      fld_accordion = new Fx.Accordion([], [], {
        'onComplete' : resizeGadgetsPane,
        'onActive' : function (toggler/*, element*/) {
          toggler.getFirst('.fld_title_ico').setStyle( "border-color", "rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) #000 rgba(0, 0, 0, 0)");
        },
        'onBackground' : function (toggler/*, element*/) {
          toggler.getFirst('.fld_title_ico').setStyle("border-color", "#000 rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) rgba(0, 0, 0, 0)");
        },
        alwaysHide : true,
        display : -1
      });
    }
    if (gadgetload == false) {
      create_gadget_pane();
      gadgetload = true;
    }

    resizeWindow(e, true);
    if (!Empty(id)) {
      currentname = id;
      reload(null);
    }
    else {
      w_init = parseInt(Ctrl("backcanvas").style.width);
      h_init = parseInt(Ctrl("backcanvas").style.height);
    }

    if (mode == "tosave") {
      currentname = "";
    }

    if (!Empty(openas)) {
      currentname = openas;
    }

    if (window.parent.portalStudioContainer) {
      window.parent.setTitle(this);
    }
    else {
      document.title = currentname + " - Module Editor";
      if (Ctrl("srcform")) {
        Ctrl("srcform").value = currentname;
      }
    }

    if (!Empty(pdfsrc)) {
      LoadPdfz(pdfsrc, "true");
    }
    else {
      formProp.height = h_init;
      formProp.width = w_init;
    }

    if (!Empty(fieldsrc)) {
      if (fieldsrc.indexOf(".vrp") > 0) {
        Loadvrp(fieldsrc);
      }
      else if (fieldsrc.length > 0) {
        Loadxml(fieldsrc);
      }
    }

    selectedZoombox("zoombox");
    isLoading = false;

    $("loading").fade(0);

    generateRulers();
    FormProperties(true);

    m_bUpdated2 = false;
    changeselectshadow = false;

	if( modelightqr == true ) {
		// INIZIO: ************** ENRICO **************
		// Prima di eventuali resize della maschera effettuo degli adattamenti per nascondere oggetti a noi non necessari
		// Rimuovo il primo nodo della tooblbar perch� non necessario
		// Per fare un lavoro pulito occorrerebbe mettere mano al file "propertiesOthers.js"
		// e fare in modo che come primo nodo venga caricato quello a noi necessario
		var oTlb = document.getElementsByClassName("PSMultiToolbar PSToolbar");
		oTlb[0].childNodes[0].remove();

		// Nascondo l'oggetto toggler_capi nell'oggetto gadgets_pane
		var toggApi = document.getElementById("gadgets_pane").getElementsByClassName('toggler_capi');
		if(toggApi != "undefined") toggApi[0].style.display = 'none';

		//Disabilitato in moduleeditor.jsp
		// Nascondo l'oggetto gadgetPaneLast nell'oggetto gadgetlistTitle
		//let lastGdgPane = document.getElementById("gadgetlistTitle");
		//if(lastGdgPane != 'undefined') {
			//for (var nd = 0; nd < lastGdgPane.length; nd++) {
			  //if(lastGdgPane[nd].id === "gadgetPaneLast") lastGdgPane[nd].style.display = 'none';
			//}
		//}

		//Nascondo la matita per la modifica della descrizione della lettera
		var fddc = document.getElementById('Form_Dati_description_container');
		var fddc_tdb = fddc.getElementsByClassName('tdButton');
		fddc_tdb[0].hidden = true;

		var oFgdt = document.getElementById("Form_global_definitions_tab");
		oFgdt.style.display = 'none';

		var oFvt = document.getElementById("Form_view_tab");
		oFvt.style.display = 'none';
		// FINE: ************** ENRICO **************
		//////
		var formT = document.getElementById('formpropertiesTitle');
		formT.children[0].innerHTML = '&nbsp;Propriet&#224; modulo';
		var gadgetT = document.getElementById('gadgetlistTitle');
		gadgetT.children[0].innerHTML = '&nbsp;Dizionario Dati';
		var searchT = document.getElementById('gadgetPaneLast');
		searchT.style.display = 'none';
	}

    if (Ctrl("results_tab_content") && Ctrl("findList")) {
      Ctrl("results_tab_content").appendChild(Ctrl("findList"));
    }
    //Se presenti i 3 campi BARCODE, BARCODE1 e BARCODE2 disegno automaticamente il QRCODE, solo se assente
    if( managebarcodeqr == true ) {
      if(bcList.length == 3) {
        openerAddItem('Barcode2D');
      }
    }

	setArea()
	toolbarUpdateState();

	var toDel = [];
	for (var i = 0; i < countindex.length; i++) {
		for (var j = 0; j < itemsHTMLArray[i].length; j++) {
			var elem = itemsHTMLArray[i][j];
			if( elem.type == 'Area' && !Empty(elem.fAreaKey)) {
				j = itemsHTMLArray[i].length;
				i = countindex.length;
				toDel = [];
			}
			else if( elem.type == 'Zone' && elem.name.indexOf('TMPCAMPO') == 0 ) {
				toDel.push(elem.id);
				elem.shadow = "shadow";
			}
		}
	}
	if( toDel.length > 0 ){
		deleteItem();
		openerAddFixedElements()
	}
  };
  fnToDelay.delay(2000);
}

function Help(the_property) {
  var i;
  var prop = "";
  if (typeof(anchorToFeature) != "undefined") {
    if (typeof(the_property) != "undefined") {
      prop = "moduleeditor_" + the_property.toLowerCase();
    }
    if (prop in anchorToFeature && prop != "") {
      i = anchorToFeature[prop];
    }
    else {
      if (index != null && "moduleeditor_" + itemsHTML[index].type.toLowerCase() in anchorToFeature) {
        i = anchorToFeature["moduleeditor_" + itemsHTML[index].type.toLowerCase()];
      }
      else if (typeof(i)=='undefined') {
        prop = "moduleeditor_" + the_property.substring(the_property.indexOf('_'),0).toLowerCase();
        i = anchorToFeature[prop];
      }
    }

    if(typeof(i)=='undefined') {
      i = anchorToFeature["moduleeditor"];
    }
    windowOpenForeground(m_cHelpUrl+"help/portalstudio/ps_urg_navigator.htm?" + URLenc(i + (prop != "" ? "||" + prop : "")), "", "toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1");
  }
}

function editItemEvent() {
}

/* *** Gestione addItem *** */
// Funzioni di inserimento nuovo item
function addItem(item, itemname) {
  var evtType = "click";
  if (arguments[0].type && arguments[0].type == "drop") {
    type = arguments[1];
    evtType = "drag";
  }
  else if (arguments[0].type && arguments[0].type == "click") {
    type = arguments[1];
  }
  else {
    type = item;
  }
  var itemName = itemname;
  if (type == "DocPage") {
    putItem(null, true);
  }
  else {
    if (evtType == "drag") {
      putItem(arguments[0]);
      if (type == "Area") {
        itemsHTML.sort(sortType);
        setArea();
      }
      insertIntoUndoSequence();
    }
    else {
      $("canvas").setStyle('cursor', 'crosshair');
      Ctrl("canvas").onmousedown = function (event) {
        $("mask").fx.start('opacity', '0').chain(function () {
          $("mask").setStyle('display', 'none');
        });
        var b_reload = false;
        if( type == 'Zone' && (itemName == 'nNumPage' || itemName == 'nTotalPages') ) {
          b_reload = true;
        }
        var ok = putItem(event, b_reload);
        if (type == "Area") {
          itemsHTML.sort(sortType);
          setArea();
        }
        else if( ok && type == 'Zone' && (itemName == 'nNumPage' || itemName == 'nTotalPages')) {
          itemsHTML[countindex[docpageindex] - 1].name = itemName;
          itemsHTML[countindex[docpageindex] - 1].datatype = 'number';
          writeHTML();
          clickItem(null, itemsHTML[countindex[docpageindex] - 1].id);
        }
        insertIntoUndoSequence();
      };
    }
  }
  toolbarUpdateState();
}

function putItemType(type, xpos, ypos, jsonO) {

	function setProp(itemHTML, jsonO) {
		var nkeys = Object.keys(jsonO);
		for ( var i=0; i<nkeys.length; i++ ) {
			var key = nkeys[i];
			if( key == 'x' || key == 'y' || key == 'width' || key == 'height' ) continue;
			itemHTML[key] = jsonO[key];
    }
  }

  var maxWidth, maxHeight;
  maxWidth = parseInt(Ctrl("canvaslinks").offsetWidth);
  maxHeight = parseInt(Ctrl("canvaslinks").offsetHeight);

  if (maxWidth <= 0 || maxHeight <= 0) {
    maxWidth = parseInt(Ctrl("backcanvas").offsetWidth);
    maxHeight = parseInt(Ctrl("backcanvas").offsetHeight);
  }
  if( jsonO == undefined ) {
	jsonO = {};
  }
  var htmlObj = "";
  putok = false;
  switch (type) {
    case 'Area':
      putok = true;
      if (putalert == false) {
        xpos = 0;
        ypos = 0;
      }
	  if( jsonO.width == undefined ) jsonO.width = 150;
	  if( jsonO.height == undefined ) jsonO.height = 100;
      if ((xpos) >= 0 && (ypos) >= 0 && (xpos + jsonO.width * clCanvasLib.scale / 100 < maxWidth) && (ypos + jsonO.height * clCanvasLib.scale / 100 < maxHeight)) {
        if (typeof(countindex[docpageindex]) == "undefined") {
          countindex[docpageindex] = 0;
        }
        htmlObj = '<div id=\'item' + nitem + '\' class="transparent-area" title=\'Area' + nitem + '\' name=\'Area' + nitem + '\' style=\'overflow-y:auto;overflow-x:hidden;z-index:1;width:' + jsonO.width * clCanvasLib.scale / 100 + 'px;height:' + jsonO.height * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + ypos + 'px;left:' + xpos + 'px;\' onClick="cancelEvent(event);clickItem(event,\'item' + nitem + '\')"><div id=\'item' + nitem + '_int\' class="transparent-layer">Layer 1</div></div>';
        itemsHTML[countindex[docpageindex]] = new ZTObjects.AreaObj('item' + nitem, 'Area' + nitem, 'Area', htmlObj, '', '', xpos, ypos);
        nitem++;
        nAllItems++;
        countindex[docpageindex]++;
        Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[countindex[docpageindex] - 1].html;
        itemsHTML[countindex[docpageindex] - 1].h = parseFloat(Ctrl("item" + (nitem - 1)).style.height);
        itemsHTML[countindex[docpageindex] - 1].w = parseFloat(Ctrl("item" + (nitem - 1)).style.width);
		    setProp(itemsHTML[countindex[docpageindex] - 1], jsonO);
        Ctrl("item" + (nitem - 1)).name = itemsHTML[countindex[docpageindex] - 1].name;
        undoItemsMoved.push(new ZTObjects.undoObj(itemsHTML[countindex[docpageindex] - 1].id, 'add', itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1], itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h, itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h));
      }
      else {
        if (putalert == true) {
          PSAlert.alert("Object not created !");
        }
        putok = false;
      }
      break;
    case 'Zone':
    case 'Image':
    case 'Barcode':
    case 'Barcode2D':
    case 'SignSVG':
    case 'Radio':
    case 'Checkbox':
      putok = true;
      if (putalert == false) {
        xpos = 0;
        ypos = 0;
      }
	  if( jsonO.width == undefined ) jsonO.width = 60;
	  if( jsonO.height == undefined ) jsonO.height = 30;
      if ((xpos) >= 0 && (ypos) >= 0 && (xpos + jsonO.width * clCanvasLib.scale / 100 < maxWidth) && (ypos + jsonO.height * clCanvasLib.scale / 100 < maxHeight)) {
        if (typeof(countindex[docpageindex]) == "undefined") {
          countindex[docpageindex] = 0;
        }
        htmlObj = '<div id=\'item' + nitem + '\' class="transparent" title=\'DocField' + nitem + '\' style=\'z-index:2;overflow:hidden;width:' + jsonO.width * clCanvasLib.scale / 100 + 'px;height:' + jsonO.height * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + ypos + 'px;left:' + xpos + 'px;\' onClick="cancelEvent(event);clickItem(event,\'item' + nitem + '\')"><div id=\'item' + nitem + '_int\' class="transparent-int">' + 'DocField' + nitem + '</div></div>';
        itemsHTML[countindex[docpageindex]] = new ZTObjects.ZoneObj('item' + nitem, 'DocField' + nitem, 'Zone', htmlObj, 'character', '', xpos, ypos);
        setProp(itemsHTML[countindex[docpageindex]], jsonO);
        if (type == 'Image') {
          itemsHTML[countindex[docpageindex]].type_exp = 'image';
          itemsHTML[countindex[docpageindex]].datatype = 'none';
        }
        else if (type == 'SignSVG') {
          itemsHTML[countindex[docpageindex]].type_exp = 'signsvg';
          itemsHTML[countindex[docpageindex]].datatype = 'none';
        }
        else if (type == 'Radio') {
          itemsHTML[countindex[docpageindex]].type_exp = 'radio';
          itemsHTML[countindex[docpageindex]].datatype = 'none';
        }
        else if (type == 'Checkbox') {
          itemsHTML[countindex[docpageindex]].type_exp = 'checkbox';
          itemsHTML[countindex[docpageindex]].datatype = 'none';
        }
        else if (type == 'Barcode') {
          itemsHTML[countindex[docpageindex]].type_exp = 'barcode';
          itemsHTML[countindex[docpageindex]].barcode = 'EAN-8';
          itemsHTML[countindex[docpageindex]].datatype = 'none';
        }
        else if (type == 'Barcode2D') {
          itemsHTML[countindex[docpageindex]].type_exp = 'barcode2d';
          itemsHTML[countindex[docpageindex]].barcode2d = 'QRCode';
          itemsHTML[countindex[docpageindex]].pixeloffcolor = '#000000';
          itemsHTML[countindex[docpageindex]].pixeloncolor = '#FFFFFF';
          itemsHTML[countindex[docpageindex]].datatype = 'none';
        }
        nitem++;
        nAllItems++;
        countindex[docpageindex]++;
        Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[countindex[docpageindex] - 1].html;
        itemsHTML[countindex[docpageindex] - 1].h = parseFloat(Ctrl("item" + (nitem - 1)).style.height);
        itemsHTML[countindex[docpageindex] - 1].w = parseFloat(Ctrl("item" + (nitem - 1)).style.width);
        applyFont(itemsHTML[countindex[docpageindex] - 1]);
        setZoneinArea(countindex[docpageindex] - 1);
        updclass(itemsHTML[countindex[docpageindex] - 1]);
        undoItemsMoved.push(new ZTObjects.undoObj(itemsHTML[countindex[docpageindex] - 1].id, 'add', itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1], itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h, itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h));
      }
      else {
        if (putalert == true) {
          PSAlert.alert("Object not created !");
        }
        putok = false;
      }
      break;
    case 'Omr':
      putok = true;
      if (putalert == false) {
        xpos = 0;
        ypos = 0;
      }
	  if( jsonO.width == undefined ) jsonO.width = 50;
	  if( jsonO.height == undefined ) jsonO.height = 50;
      if ((xpos) >= 0 && (ypos) >= 0 && (xpos + jsonO.width * clCanvasLib.scale / 100 < maxWidth) && (ypos + jsonO.height * clCanvasLib.scale / 100 < maxHeight)) {
        if (typeof(countindex[docpageindex]) == "undefined") {
          countindex[docpageindex] = 0;
        }
        itemsHTML[countindex[docpageindex]] = new ZTObjects.OmrObj('item' + nitem, 'Omr' + nitem, 'Omr', '', '', '', xpos, ypos, jsonO.width * clCanvasLib.scale / 100, jsonO.height * clCanvasLib.scale / 100);
        nitem++;
        nAllItems++;
        countindex[docpageindex]++;
        Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[countindex[docpageindex] - 1].html;
        itemsHTML[countindex[docpageindex] - 1].h = parseFloat(Ctrl("item" + (nitem - 1)).style.height);
        itemsHTML[countindex[docpageindex] - 1].w = parseFloat(Ctrl("item" + (nitem - 1)).style.width);
		    setProp(itemsHTML[countindex[docpageindex] - 1], jsonO);
        undoItemsMoved.push(new ZTObjects.undoObj(itemsHTML[countindex[docpageindex] - 1].id, 'add', itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1], itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h, itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h));
        }
        else {
        if (putalert == true) {
          PSAlert.alert("Object not created !");
        }
        putok = false;
      }
	break;
    case 'SignMark':
      putok = true;
      if (putalert == false) {
        xpos = 0;
        ypos = 0;
      }
	  if( jsonO.width == undefined ) jsonO.width = 30;
	  if( jsonO.height == undefined ) jsonO.height = 10;
      if ((xpos) >= 0 && (ypos) >= 0 && (xpos + jsonO.width * clCanvasLib.scale / 100 < maxWidth) && (ypos + jsonO.height * clCanvasLib.scale / 100 < maxHeight)) {
        if (typeof(countindex[docpageindex]) == "undefined") {
          countindex[docpageindex] = 0;
        }
        itemsHTML[countindex[docpageindex]] = new ZTObjects.signMarkObj('item' + nitem, 'SignMark' + nitem, 'SignMark', xpos, ypos, jsonO.width * clCanvasLib.scale / 100, jsonO.height * clCanvasLib.scale / 100);
        nitem++;
        nAllItems++;
        countindex[docpageindex]++;
        Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[countindex[docpageindex] - 1].html;
        itemsHTML[countindex[docpageindex] - 1].h = parseFloat(Ctrl("item" + (nitem - 1)).style.height);
        itemsHTML[countindex[docpageindex] - 1].w = parseFloat(Ctrl("item" + (nitem - 1)).style.width);
		    setProp(itemsHTML[countindex[docpageindex] - 1], jsonO);
        undoItemsMoved.push(new ZTObjects.undoObj(itemsHTML[countindex[docpageindex] - 1].id, 'add', itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1].x, itemsHTML[countindex[docpageindex] - 1].y, itemsHTML[countindex[docpageindex] - 1], itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h, itemsHTML[countindex[docpageindex] - 1].w, itemsHTML[countindex[docpageindex] - 1].h));
      }
      else {
        if (putalert == true) {
          PSAlert.alert("Object not created !");
        }
        putok = false;
      }
      break;
    case 'DocPage':
      break;
  }
}

function putItem(e, b_reload) {
  var xpos = 0, ypos = 0;
  m_bUpdated2 = true;
  if (!e) { e = window.event; }
  if (e != null) {
    xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
    if (document.all) {
      xpos += window.pageXOffset;
      ypos += window.pageYOffset;
    }
    xpos = xpos - parseInt(Ctrl("backcanvas").offsetLeft) + Ctrl("canvas").scrollLeft;
    ypos = ypos - parseInt(Ctrl("backcanvas").offsetTop) + Ctrl("canvas").scrollTop;
  }
  putItemType(type, xpos, ypos);
  $('canvas').setStyle('cursor', 'default');
  Ctrl("canvas").onmousedown = beginDragSelection;

  if (!b_reload) {
    if (putok) {
      clickItem(null, itemsHTML[countindex[docpageindex] - 1].id);
    }
  }
  return putok;
}

function putField(group, groupDesc, fname, desc, detail, type, len, dec, contID) {
  var xpos, ypos, bDetail;
  var fwidth = 180;
  var fheight = 15;
  var fspace = 20;
  xpos = 4;
  if (fieldcountindex == 0) {
    ypos = 0;
  }
  else {
    ypos = 0 + fieldcountindex * fspace;
  }

  if (!Ctrl(group + "_divz")) {
    elementsNrByGroup[group] = 0;
  }
  var nFieldsGroup = elementsNrByGroup[group]; // Numero di campi nel group
  if (desc == null || desc.length == 0) {
    desc = fname;
  }
  if (detail == "1") {
    bDetail = true;
  }
  else {
    bDetail = false;
  }
  ypos = (nFieldsGroup + 1) * fspace;
  var mname = desc;
  if (mname.indexOf(groupDesc + "_") == 0) {
    mname = Strtran(mname, groupDesc + "_", "");
  }
  else {
    mname = mname.substring(mname.indexOf("_") + 1);
  }
  fieldHTML[fieldcountindex] = new ZTObjects.dragFieldObj('item'+nitem, 'Field' + nitem, 'Field', xpos, ypos, fwidth, fheight, fname, mname, type, len, dec, group, groupDesc, bDetail, false, '', '');
  nitem++;
  nAllItems++;
  fieldcountindex++;
  putFieldInAccordion(contID, fieldHTML[fieldcountindex - 1]);
  elementsNrByGroup[group] = elementsNrByGroup[group] + 1;
}

/* Applica il font alla descrizione dell'item Zone nell'area di lavoro. */
function applyFont(itm) {
  var ctrlx = Ctrl(itm.id + "_int");
  if( !Empty(itm.comment)) {
    ctrlx.innerHTML = itm.comment;
  }
  else {
    ctrlx.innerHTML = itm.name;
  }
  //apply font
  if ((itm.globalfont.toString()) == "true") {
    ctrlx.style.fontFamily = formProp.font;
    ctrlx.style.color = formProp.color;
    if (/[^0-9]/.test(LRTrim(formProp.size))) {
      ctrlx.style.fontSize = formProp.size;
    }
    else {
      ctrlx.style.fontSize = LRTrim(formProp.size) + "px";
    }
    ctrlx.style.textAlign = itm.align;
  }
  else {
    ctrlx.style.fontFamily = itm.font;
    ctrlx.style.color = itm.color;
    ctrlx.style.fontSize = itm.size;
    ctrlx.style.textAlign = itm.align;
  }
  var fontStyle = "", fontEffect = "";

  if ((itm.globalfont.toString()) == "true") {
    fontStyle = formProp.weight;
    fontEffect = Trim(formProp.effects);
  }
  else {
    fontStyle = itm.weight;
    fontEffect = Trim(itm.effects);
  }

  if (fontStyle == "normal") {
    ctrlx.style.fontWeight = "normal";
    ctrlx.style.fontStyle = "normal";
  }
  else if (fontStyle == "bold") {
    ctrlx.style.fontWeight = "bold";
    ctrlx.style.fontStyle = "normal";
  }
  else if (fontStyle == "italic") {
    ctrlx.style.fontWeight = "normal";
    ctrlx.style.fontStyle = "italic";
  }
  else if (fontStyle == "bold italic") {
    ctrlx.style.fontWeight = "bold";
    ctrlx.style.fontStyle = "italic";
  }
  else {
    ctrlx.style.fontWeight = "normal";
    ctrlx.style.fontStyle = "normal";
  }

  if (fontEffect == "") {
    ctrlx.style.textDecoration = "none";
  }
  else if (fontEffect == "underline") {
    ctrlx.style.textDecoration = "underline";
  }
  else if (fontEffect == "strikeout") {
    ctrlx.style.textDecoration = "line-through";
  }
  else {
    ctrlx.style.textDecoration = "underline line-through";
  }

  if( modelightqr && !Empty(itm.fAreaParentKey) ) {
	  var ctrl = Ctrl(itm.id);
	  if( ctrl )
		  ctrl.style.border = '1px solid red';
  }
}
/* *** Fine della gestione addItem *** */

/* *** Gestione writeHTML *** */

// riscrive l'HTML dopo la cancellazione degli items
function writeHTML(fromReload) {
  var ctrl, itm;
  Ctrl("canvasitems").innerHTML = "";

  updateCommonVars();

  for (var i = 0; i < itemsHTML.length; i++) {
    writeHTMLItemObj(itemsHTML[i]);
  }

  if (fromReload) {
    checkMargins();
  }

  if (index != null && typeof(itemsHTML[index]) != "undefined") {
    ctrl = Ctrl("shadow" + itemsHTML[index].id.substr(4));
    itm = itemsHTML[index];
    if (ctrl) {
      ctrl.style.left = itm.x + "px";
      ctrl.style.top = itm.y + "px";
      if (itm.w - getOffset(ctrl).gapw >= 0) {
        ctrl.style.width = (itm.w - getOffset(ctrl).gapw) + "px";
      }
      else {
        ctrl.style.width = itm.w + "px";
      }
      if (itm.h - getOffset(ctrl).gaph >= 0) {
        ctrl.style.height = (itm.h - getOffset(ctrl).gaph) + "px";
      }
      else {
        ctrl.style.height = itm.h + "px";
      }
    }
  }
  setShadow();
  resetTabs();
}

function updclass(itm) {
  var ctrl = Ctrl(itm.id);
  if (!ctrl) { return; }
  if (itm.type_exp == 'image') {
    ctrl.className = 'transparent transparent-image';
  }
  else if (itm.type_exp == 'signsvg') {
    ctrl.className = 'transparent transparent-signsvg';
  }
  else if (itm.type_exp == 'radio') {
    ctrl.className = 'transparent transparent-radio';
  }
  else if (itm.type_exp == 'checkbox') {
    ctrl.className = 'transparent transparent-checkbox';
  }
  else if (itm.type_exp == 'barcode') {
      ctrl.className = 'transparent transparent-barcode';
    }
  else if (itm.type_exp == 'barcode2d') {
    ctrl.className = 'transparent transparent-barcode2d';
  }
  else {
    ctrl.className = 'transparent';
  }
}

function writeHTMLItemObj(itm) {
  var j, ctrlArea, arealayer, names;
  if(!document.getElementById(itm.id)) {
  Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itm.html;
  }
  var itm_html = Ctrl(itm.id);
  if (itm_html != null) {
    itm_html.name = itm.name;
    itm_html.style.left = itm.x + "px";
    itm_html.style.top = itm.y + "px";
  }

  var ctrl = Ctrl(itm.id);
  ctrl.style.left = itm.x + "px";
  ctrl.style.top = itm.y + "px";
  ctrl.style.width = itm.w + "px";
  ctrl.style.height = itm.h + "px";

  if (itm.type == "Zone") {
    //Valuto se sono presenti i tre barcode nel modello, in modo da aggiungere il Qrcode automaticamente
    if(managebarcodeqr == true && itm.name) {
      if (itm.name.indexOf("BARCODE") != -1 || (itm.type_exp == 'barcode' &&  itm.barcode == 'QRCode')) {
        if(!bcList.contains(itm.name)) bcList.push(itm.name);
      }
    }
    ctrl.style.display = "none";
    ctrl.title = itm.comment ? itm.comment : getFieldDesc(itm.name);
    var ctrlx = Ctrl(itm.id + "_int");
    applyFont(itm);
    if (Empty(itm.area)) {
      // I nostri barcode (BARCODE, BARCODE1 e BARCODE2) non li devo mai disegnare
      if(managebarcodeqr == true && itm.name.indexOf("BARCODE") != -1) {
        ctrl.style.display = "none";
      } else {
      ctrl.style.display = "block";
    }
    }
    else {
      ctrlArea = document.getElementsByTagName(itm.area);
      arealayer = 0;
      if (ctrlArea) {
        for (j = 0; j < itemsHTML.length && arealayer == 0; j++) {
          if (itemsHTML[j].name == itm.area) {
            arealayer = itemsHTML[j].layer;
          }
        }
        if (arealayer == itm.layer) {
          ctrl.style.display = "block";
        }
      }
    }
    updclass(itm);
  }

  if (itm.type == "Area") {
    ctrl.style.display = "block";
    ctrl.name = itm.name;
    ctrl.setAttribute("name", itm.name);

    ctrlx = Ctrl(itm.id + "_int");
    ctrlx.innerHTML = "Layer " + itm.layer;
    if (Trim(itm.layers_names).length > 0) {
      names = Trim(itm.layers_names).split(",");
      if (names.length >= itm.layer && itm.layer > 0) {
        ctrlx.innerHTML += " - " + names[itm.layer - 1];
      }
    }
    if (itm.comment && itm.comment.length > 0) {
      ctrl.title = itm.comment + "/" + ctrlx.innerHTML;
    }
    else {
      ctrl.title = itm.name + "/" + ctrlx.innerHTML;
    }
  }

  if (itm.type == "Omr") {
    ctrl.style.display = "block";
    ctrl.style.backgroundColor = itm.color;
  }

  if (itm.wireframe) {
    ctrl.innerHTML = itm["wireframe"](itm);
  }
}

function updateCommonVars() {
  if (formProp.hsl == "true" || formProp.hsl == true) {
    // Disabilita le SnapLines
    canAlign = false;
  }
  else {
    canAlign = true;
  }
  if (formProp.lock_items == "true" || formProp.lock_items == true) {
    lockItems = true;
  }
  else {
    lockItems = false;
  }
}
/* *** Fine della gestione writeHTML *** */

/* *** Gestione del Copy/Cut/Paste *** */
function Copy(cut) {
  var deftmp = [], selectedItems = {};
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow != "") {
      deftmp.push(copyItem(itemsHTML[i]));
    }
  }
  if (cut) {
    if (deftmp.length > 0) {
      selectedItems = { "action" : "cut", "elements" : deftmp };
    }
    deleteItem();
  }
  else {
    if (deftmp.length > 0) {
      selectedItems = { "action" : "copy", "elements" : deftmp };
    }
  }
  return JSON.stringify(selectedItems);
}

function copyItem(item) {
  var propName = "", valueToSave = "";
  var v, u;
  var JsonItem = {"type" : item.type, "page" : docpageindex};
  setPropertiesID(item);
  for (u = 0; u < item.objClass.properties.length; u++) {
    propName = item.objClass.properties[u];
    valueToSave = item[propName];
    if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
      if (typeof(valueToSave) == "undefined" || valueToSave == "") {
        // Se il valore della proprieta' e' undefined, allora la salvo come " "
        valueToSave = " ";
      }
    }
    else {
      v = item.objClass.properties[u];
      if (v == "x" || v == "y" || v == "w" || v == "h") {
        valueToSave = valueToSave * 100 / clCanvasLib.scale;
      }
    }
    JsonItem[propName] = valueToSave;
  }
  return JsonItem;
}

function Paste(strpaste) {
  if (strpaste != "") {
    reload_(null, strpaste, true);
	toolbarUpdateState();
    undoItemsMoved = [];
    for (var idx = 0; idx < pasted.length; idx++) {
      // Si salvano gli oggetti incollati per l'Undo
      undoItemsMoved.push(new ZTObjects.undoObj(null, 'paste', itemsHTML[pasted[idx]].x, itemsHTML[pasted[idx]].y, itemsHTML[pasted[idx]].x, itemsHTML[pasted[idx]].y, itemsHTML[pasted[idx]]));
    }
    insertIntoUndoSequence();
    type = null;
  }
}
/* *** Fine della gestione del Copy/Cut/Paste *** */

/* *** Gestione del deleteItem *** */
// vengono eliminati gli elementi selezionati dall'array
function deleteItem() {
  undoItemsMoved = [];
  var tmp = [];
  var tmpn = 0, m = 0;
  var areaName = "";

  index = null;
  last_index = null;
  var propDiv = $("properties");
  if (propDiv) {
    propDiv.hide();
  }

  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow != "") {
      if (itemsHTML[i].type == "Area") {
        areaName = itemsHTML[i].name;
        for (m = 0; m < itemsHTML.length; m++) {
          if (itemsHTML[m].type == "Zone" && itemsHTML[m].area == areaName) {
            if (itemsHTML[m].shadow == "") {
              itemsHTML[m].shadow = " ";
			  itemsHTML[m].arParent = true;
            }
            }
          }
        }
	  else if( modelightqr == true ) {
		  if (!Empty(itemsHTML[i].fAreaParentKey) && !itemsHTML[i].arParent)
			  itemsHTML[i].shadow = "";
		  itemsHTML[i].arParent = false;
      }
    }
    if (itemsHTML[i].shadow == "") {
      // Sposta gli elementi non selezionati in tmp
      tmp[tmpn] = itemsHTML[i];
      tmpn++;
    }
    else {
      // Salvo gli oggetti cancellati per Undo
      undoItemsMoved.push(new ZTObjects.undoObj(null, "delete", null, null, itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i]));
    }
  }
  insertIntoUndoSequence();
  countindex[docpageindex] = tmpn;
  itemsHTML = tmp;
  itemsHTMLArray[docpageindex] = itemsHTML;
  selectForm();

  var toDelay = function () {
    setArea();
    writeHTML();
    Properties();
	toolbarUpdateState();
  };
  toDelay.delay(500);
}
/* *** Fine della gestione del deleteItem *** */

/* *** Gestione della Preview *** */
function Preview(saveChanges) {
  var tmp_bUpdated = m_bUpdated;
  if (!saveChanges) {
    m_bUpdated = false;
  }
  togglePreview();
  if (!saveChanges) {
    m_bUpdated = tmp_bUpdated;
  }
}

function toolbarPreview() {
  var saveChanges = false;
  if (m_bUpdated == true && currentname != "" && !preview_opened) {
    saveChanges = confirm("Do you want to save " + currentname + "?");
  }
  Preview(saveChanges);
}
/* *** Fine della gestione della Preview *** */

/* *** Gestione di New/Open *** */
function newCurrentObj(text_path/*, srcmode, path_tmp*/) {
  resetGeneric();
  currentname = text_path;
  reload(null);
  document.title = currentname + " - Module Editor";
  m_bUpdated2 = false;
  if (Ctrl("srcform")) {
    Ctrl("srcform").value = currentname;
  }
  FormProperties();
  toolbarUpdateState();
}

function newdesign() {
  if (m_bUpdated) {
    if (confirm("Do you want to save " + currentname + "?")) {
      save(function () {
        newMRP();
      });
      return;
    }
    else { newMRP(); }
  }
  else { newMRP(); }
}

function newMRP() {
  var propDiv = $('properties');
  if (propDiv) {
    propDiv.empty();
  }
  resetGeneric();
  resetToolbarFld();
  currentname = '';
  m_bUpdated = false;
  m_bUpdated2 = false;
  formProp = new ZTObjects.formObj();
  formProp.height = h_init;
  formProp.width = w_init;
  removeAllHandlers();
  selectedZoombox("zoombox");
  FormProperties();
  writeHTML();
}

function resetGeneric() {
  index = null;
  itemsHTMLArray = [];
  itemsHTML = []; // Array contenente tutti gli oggetti item con id,HTML,shadow,ecc
  imgHTML = [];
  countindex = []; // Contatore indice array
  docpageindex = 0;
  formProp.page = docpageindex;
  itemsHTMLArray[docpageindex] = [];
  countindex[docpageindex] = 0;
  clCanvasLib.scale = 100;
  zoomindex = 2;
  w_init = 0;
  h_init = 0;
  workAreaWidth = 0;
  workAreaHeight = 0;
  Ctrl("canvasitems").innerHTML = "";
  $("toolbarimg").empty();
  $("toolbarimghandlers").empty();
  generateRulers();
  if (tabs) {
    tabs.reset();
  }
  initCanvas();
  resizeWindow(null, true);
  w_init = parseInt(Ctrl("backcanvas").style.width);
  h_init = parseInt(Ctrl("backcanvas").style.height);
}

function resetGenericLight() {
  index = null;
  imgHTML = [];
  docpageindex = 0;
  formProp.page = docpageindex;
  itemsHTML = itemsHTMLArray[docpageindex];
  if (tabs) {
    tabs.reset();
  }
}

function resetToolbarFld() {
  removeAllFieldHandlers();
  fieldHTML = []; // Array contenente tutti gli oggetti item con id, HTML, shadow, ecc
  fieldcountindex = 0;
  Ctrl("toolbarfld").innerHTML = "";
  Ctrl("toolbarfldtree").innerHTML = "";
}

function openModule() {
  if ((m_bUpdated2 || m_bUpdated)) {
    if (confirm("Do you want to save " + currentname + "?")) {
      save(function () {
        openz();
      });
      return;
    }
  }

  m_bUpdated2 = false;
  openz();
}

function openz() {
  var url = "../portalstudio/open.jsp?tool=module&onetool=true";
  OpenWindow(url, 800, 600);
}
/* *** Fine della gestione di New/Open *** */

/* *** Gestione del save *** */
function save(then) {
  if(managebarcodeqr == true) manageBarcode();

  window.parent.is_Saving = true;
  if (then == "close") {
    AfterSave = "close";
  }
  else if (!Empty(then)) { //then e' un oggetto che contiene una funzione che deve essere eseguita dopo il salvataggio
    AfterSave = then;
  }
  if (currentname != "") {
    window.parent.is_Saving = true;
	if( modelightqr == false ) {
    notimooManager = new Notimoo({});
    notimooManager.show({
      title : 'Notification message',
      message : 'saving module ' + currentname,
      sticky : true,
      width : 200,
      height : 40
    });
	}
    save2.delay(1000);
  }
  else {
    saveAs();
  }
}

function saveAs() {
  saveas = true;
  window.parent.is_Saving = true;
  OpenWindow("../portalstudio/saveas.jsp?tool=module", 580, 600);
}

function getdef() {
  var i = 0, j = 0, u = 0;
  var propName, valueToSave, strsave = "";
  var JSONItems = [];
  var JSONTmpItem = {type : formProp.type};
  JSONTmpItem["version"] = version;
  setPropertiesID(formProp);
  /* Module Properties */
  for (i = 0; i < formProp.objClass.properties.length; i++) {
    propName = formProp.objClass.properties[i];
    valueToSave = formProp[propName];
    //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
    if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
      if (typeof(valueToSave) == "undefined" || valueToSave == "") {
        // Se la prop e' undefined allora si salva come " "
        valueToSave = " ";
      }
    }
    switch (propName) {
      case 'h':
        valueToSave = workAreaHeight;
        break;
      case 'w':
        valueToSave = workAreaWidth;
        break;
    }
    if (typeof(valueToSave) == "string") {
      valueToSave = Strtran(valueToSave, '--', '##x2d;##x2d;');
    }
    JSONTmpItem[propName] = valueToSave;
  }
  JSONTmpItem["maxcount"] = nAllItems;
  JSONItems.push(JSONTmpItem);
  JSONTmpItem = {};

  /* Page Properties */
  for (i = 0; i < imgHTML.length; i++) {
    JSONTmpItem = {type : imgHTML[i].type};
    setPropertiesID(imgHTML[i]);
    for (u = 0; u < imgHTML[i].objClass.properties.length; u++) {
      propName = imgHTML[i].objClass.properties[u];
      valueToSave = imgHTML[i][propName];
      //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
      if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
        if (typeof(valueToSave) == "undefined" || valueToSave == "") {
          // Se la prop e' undefined allora si salva come " "
          valueToSave = " ";
        }
      }
      switch (propName) {
        case 'h':
          valueToSave = workAreaHeight;
          break;
        case 'w':
          valueToSave = workAreaWidth;
          break;
      }
      if (LRTrim(valueToSave.toString()) != "") {
        JSONTmpItem[propName] = valueToSave;
      }
    }
    JSONItems.push(JSONTmpItem);
    JSONTmpItem = {};
  }

  /* Items Properties */
  //var zoneList = {};
  for (i = 0; i < countindex.length; i++) {
    itemsHTMLArray[i].sort(sortType);
    for (j = 0; j < itemsHTMLArray[i].length; j++) {
      JSONTmpItem = {type : itemsHTMLArray[i][j].type};
      JSONTmpItem["page"] = i;
      setPropertiesID(itemsHTMLArray[i][j]);
      for (u = 0; u < itemsHTMLArray[i][j].objClass.properties.length; u++) {
        propName = itemsHTMLArray[i][j].objClass.properties[u];
        valueToSave = itemsHTMLArray[i][j][propName];
        if ((propName == "x" || propName == "y") && valueToSave < 0) {
          PSAlert.alert("Attention item with position < 0!");
          itemsHTMLArray[i][j][propName] = 0;
          valueToSave = 0;
        }
        // Se valueToSave e' booelan e uguale a false, il test (valueToSave=="") restituisce true
        if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
          if (typeof(valueToSave) == "undefined" || valueToSave == "") {
            // Se la prop e' undefined allora si salva come " "
            valueToSave = " ";
          }
        }
        switch (propName) {
          // Alleggerimento del def: se l'item ha globalfont, e' inutile salvare nel def le altre proprieta' relative al font.
          case 'font':
          case 'size':
          case 'style':
          case 'effects':
            if (LRTrim(itemsHTMLArray[i][j].globalfont.toString()) == "true") {
              valueToSave = "";
            }
            break;
          // Alleggerimento del def: se l'item ha globalpic, e' inutile salvare nel def le altre proprieta' relative alla picture.
          case 'datapic':
            if (LRTrim(itemsHTMLArray[i][j].globalpic.toString()) == "true") {
              valueToSave = "";
            }
            break;
          // Alleggerimento del def: se l'item e' in un'area, e' inutile salvare nel def le altre proprieta' relative all'area.
          case 'layer':
            if (LRTrim(itemsHTMLArray[i][j].area) == "") {
              valueToSave = "";
            }
            break;
          // Alleggerimento del def: il valore della proprieta' color dell'item e' la stringa vuota, e' inutile salvarla nel def.
          case 'color':
            if (itemsHTMLArray[i][j].type == 'Zone' && LRTrim(itemsHTMLArray[i][j].globalfont.toString()) == "true") {
              valueToSave = "";
            }
            break;
          // Alleggerimento del def: il valore della proprieta' type_exp dell'item e' diverso da 'barcode', e' inutile salvare le altre proprieta' relative al barcode.
          case 'barcode':
            if (LRTrim(itemsHTMLArray[i][j].type_exp) != "barcode") {
              valueToSave = "";
            }
            break;
          case 'barcode2d':
            if (LRTrim(itemsHTMLArray[i][j].type_exp) != "barcode2d") {
              valueToSave = "";
            }
            break;
          case 'pixeloffcolor':
          case 'pixeloncolor':
            if (LRTrim(itemsHTMLArray[i][j].type_exp) != "barcode" || LRTrim(itemsHTMLArray[i][j].type_exp) != "barcode2d") {
              valueToSave = "";
            }
            break;
          case 'barcodestretch':
            if (LRTrim(itemsHTMLArray[i][j].type_exp) != "barcode" || LRTrim(itemsHTMLArray[i][j].type_exp) != "barcode2d") {
              valueToSave = "";
            }
            break;
          // Alleggerimento del def: il valore della proprieta' type_exp dell'item e' diverso da 'radio' o 'checkbox', e' inutile salvare le altre proprieta' relative al radio/checkbox.
          case 'checkdefault':
            if ((LRTrim(itemsHTMLArray[i][j].type_exp) != "checkbox") & (LRTrim(itemsHTMLArray[i][j].type_exp) != "radio")) {
              valueToSave = "";
            }
            break;
          // Alleggerimento del def: il valore della proprieta' format dell'item e' 'none', e' inutile salvare le altre proprieta' relative al formato.
          case 'numberformatdec':
          case 'numberseperatorStyle':
          case 'numbercurrencyStyle':
          case 'numbernegativeStyle':
          case 'dateformat':
          case 'timeformat':
          case 'specialformat':
          case 'customformat':
            if (LRTrim(itemsHTMLArray[i][j].format) == "none") {
              valueToSave = "";
            }
            break;
          case 'x':
          case 'y':
          case 'w':
          case 'h':
          case 'scale':
            valueToSave = (valueToSave * 100 / clCanvasLib.scale);
            break;
          case 'detailnumber':
            if (itemsHTMLArray[i][j].detail.toString() == "false") {
              valueToSave = "";
            }
            break;
          case 'fieldsstructure':
            valueToSave = "";
            break;
          case 'hreplicatednumber':
            if (itemsHTMLArray[i][j].hreplicated.toString() == "false") {
              valueToSave = "";
            }
            else {
              if (itemsHTMLArray[i][j].hreplicatednumber > 0 && (itemsHTMLArray[i][j].hreplicatednumber * itemsHTMLArray[i][j].w + itemsHTMLArray[i][j].x) > workAreaWidth) {
                PSAlert.alert("Too many columns for Area " + itemsHTMLArray[i][j].name + " in this page format.");
              }
            }
            break;
          case 'vreplicatednumber':
            if (itemsHTMLArray[i][j].vreplicated.toString() == "false") {
              valueToSave = "";
            }
            else {
              if (itemsHTMLArray[i][j].detailnumber > 0 && itemsHTMLArray[i][j].vreplicatednumber > 0) {
                if ((((itemsHTMLArray[i][j].detailnumber % itemsHTMLArray[i][j].vreplicatednumber) + 1) * itemsHTMLArray[i][j].w + itemsHTMLArray[i][j].x) > workAreaHeight) {
                  PSAlert.alert("Too many columns for Area " + itemsHTMLArray[i][j].name + " in this page format.");
                }
              }
            }
            break;
          case 'stretch':
          case 'printblock':
          case 'removeempty':
          case 'plast':
            if (itemsHTMLArray[i][j].type == "Area" && itemsHTMLArray[i][j].overarea.toString() == "true") {
              valueToSave = "";
            }
            break;
        }
        // Alleggerimento del def: il valore della proprieta' dell'item e' la stringa vuota, e' inutile salvarla nel def.
        if (LRTrim(valueToSave.toString()) != "") {
          if (typeof(valueToSave) == "string") {
            valueToSave = Strtran(valueToSave, '--', '##x2d;##x2d;');
          }
          JSONTmpItem[propName] = valueToSave;
        }
      }
      JSONItems.push(JSONTmpItem);
      JSONTmpItem = {};

      /*if (msimplesheet == true) {
        // Solo zone...
        LibJavascript.CssClassNameUtils.removeClass(Ctrl(itemsHTMLArray[i][j].id), "classError");
        if (zoneList[itemsHTMLArray[i][j].name]) {
          var mymessage = FormatMsg("Item") + " <span style=\"font-weight: bold; text-decoration: underline\">" + itemsHTMLArray[i][j].name + "</span> " + FormatMsg("is not unique in the document") + "!";
          var notimooManager = new Notimoo({});
          notimooManager.show({
            title:FormatMsg("Error message"),
            message: mymessage,
            sticky : true,
            width:200,
            height:40,
            customClass:'errMsg'
          });
          LibJavascript.CssClassNameUtils.addClass(Ctrl(itemsHTMLArray[i][j].id), "classError");
          LibJavascript.CssClassNameUtils.addClass(Ctrl(zoneList[itemsHTMLArray[i][j].name].id), "classError");
        }
        else {
          zoneList[itemsHTMLArray[i][j].name] = itemsHTMLArray[i][j];
        }
      }*/
    }
  }
  strsave = JSON.stringify(JSONItems, function(s,v) {if (typeof(v)!='object') return v.toString(); else return v;});
  return strsave;
}

function save2(/*act*/) {
  var strsave = "";
  var url, output;
  var i;
  var opener = GetOpener();
  if( opener == null ) opener = window.parent;
  if (currentname != "") {
    strsave = getdef();
    var portlet_name = "";
    currentname = Strtran(currentname, '\\', "/");
    if (currentname.indexOf('/') > -1) {
      portlet_name = currentname.substring(currentname.lastIndexOf("/") + 1);
    }
    else {
      portlet_name = currentname;
    }
    url = new JSURL("../servlet/JSPSave?type=module"+
      "&name=" + portlet_name +
      "&def=" + URLenc(strsave) +
      "&m_cID=" + cmdhash, true);
    output = url.Response();
    if (opener && opener.changeName) {
      // folder_path definita in visualweb/editor.js
      opener.changeName(portlet_name, folder_path, Strtran(window.frameElement.id, 'portalstudioframe', ''));
    }
    if (output == null) {
      output = "";
    }

    switch (output) {
      case "true":
        for (i = 0; i < notimooManager.elements.length; i++) {
          notimooManager.close(notimooManager.elements[i]);
        }
        m_bUpdated = false;
        m_bUpdated2 = false;
		if( modelightqr == false ) {
        notimooManager.show({
          title : 'Notification message',
          message : 'module saved!',
          visibleTime : 2000,
          width : 200
        });
		}
        document.title = currentname + " - Module Editor";
        var isok = false;
        if (typeof(opener) != "undefined") {
          try {
            if(opener.document &&  opener.document.getElementById('zones_Id'))
              opener.document.getElementById('zones_Id').submit();
          } catch (e) {}

          try {
            if (opener != null) {
              if (saveas == true) {
                if (opener.cbscanedit_saveas) {
                  opener.cbscanedit_saveas(portlet_name, window);
                  isok = true;
                  saveas = false;
                }
              }
              else if (opener.cbscanedit_save) {
                opener.cbscanedit_save(portlet_name, window);
                isok = true;
              }
            }
            if (!isok) {
              isok = savePageletPortlet(portlet_name, opener, window, AfterSave);
            }
          } catch (e) {}
        } else {
          isok = savePageletPortlet(portlet_name, opener, window, AfterSave);
        }

        if(!isok) {
          window.parent.is_Saving = false;
          return;
        }

        saveas = false;

        if ((arguments.length > 0 && arguments[0] == "close") || AfterSave == "close") {
          if (window.parent.is_Saving) {
            window.parent.is_Saving = false;
          }

          if (window.parent && window.parent.closeCurrentObj) {
            window.parent.closeCurrentObj();
          }
          if(closePageletPortlet(portlet_name, opener, window)) {
			window.close();
          }
          return;
        }
        if (!Empty(AfterSave)) {
          AfterSave();
          AfterSave = null;
        }
        AfterSave = null;
        break;
      case "ACCESS DENIED":
        notimooManager.close(notimooManager.elements[0]);
        PSAlert.alert("Access Denied.");
        break;
      case "LICENSE LIMIT":
        notimooManager.close(notimooManager.elements[0]);
        PSAlert.alert("Licensed User Limit Reached.");
        break;
      default:
        notimooManager.close(notimooManager.elements[0]);
        PSAlert.alert("Save routine failed.");
        break;
    }
  }
  else {
    OpenWindow("../portalstudio/saveas.jsp?&tool=module", 580, 600);
  }
  window.parent.is_Saving = false;
}

function closePageletPortlet(portlet_name, win, currwin) {
  var isok = false;
  if (win.ZtVWeb != null && win.ZtVWeb != "undefined") {
    // Pagelet
    if (win.getPagelet) {
      var pagelet_id = win.getPagelet();
      if (pagelet_id != null && pagelet_id != "undefined") {
        if (pagelet_id.cbscanedit_close) {
          pagelet_id.cbscanedit_close(portlet_name, currwin);
          isok = true;
		  alreadyClose = true;
        }
      }
    }
    // Portlet
    if (!isok && win.ZtVWeb.getPortletId) {
      var portlet_id = win.ZtVWeb.getPortletId();
      if (portlet_id != null && portlet_id != "undefined") {
		  for (var p = 0; p <= portlet_id.length; p++) {
		  var portlet_obj = win.ZtVWeb.getPortletById(portlet_id[p]);
          if (portlet_obj != null && portlet_obj != "undefined") {
            if (portlet_obj.cbscanedit_close) {
              portlet_obj.cbscanedit_close(portlet_name, currwin);
              isok = true;
              alreadyClose = true;
            }
          }
		  if(isok) break;
		}
      }
    }
  }
  return isok;
}

function savePageletPortlet(portlet_name, win, currwin, toClose) {
  var isok = false;
  if (win.ZtVWeb != null && win.ZtVWeb != "undefined") {
    // Pagelet
    if (win.getPagelet) {
      var pagelet_id = win.getPagelet();
      if (pagelet_id != null && pagelet_id != "undefined") {
        if (saveas == true) {
          if (pagelet_id.cbscanedit_saveas) {
            isok = pagelet_id.cbscanedit_saveas(portlet_name, currwin);
			//isok = true;
          }
        }
        else if (pagelet_id.cbscanedit_save) {
          isok = pagelet_id.cbscanedit_save(portlet_name, currwin, toClose);
		  //isok = true;
        }
      }
    }
    // Portlet
    if (!isok && win.ZtVWeb.getPortletId) {
      var portlet_id = win.ZtVWeb.getPortletId();
      if (portlet_id != null && portlet_id != "undefined") {
		for (var p = 0; p <= portlet_id.length; p++) {
		  var portlet_obj = win.ZtVWeb.getPortletById(portlet_id[p]);
        if (portlet_obj != null && portlet_obj != "undefined") {
          if (saveas == true) {
            if (portlet_obj.cbscanedit_saveas) {
				isok = portlet_obj.cbscanedit_saveas(portlet_name, currwin);
				//isok = true;
            }
          }
          else if (portlet_obj.cbscanedit_save) {
			  isok = portlet_obj.cbscanedit_save(portlet_name, currwin, toClose);
			  //isok = true;

          }
        }
		  if(isok) break;
		}
      }
    }
  }
  return isok;
}
/* *** Fine della gestione del save *** */

/* *** Gestione di reload *** */
function reload(e) {
  //setLoadPic(false);
  notimooManager = new Notimoo({});
  notimooManager.show({
    title : 'Notification message',
    message : 'loading module ' + currentname,
    visibleTime : 4000,
    width : 200,
    height : 40
  });

  var url = new JSURL("../servlet/JSPReader?type=module&name=" + currentname + "&check=true", true);
  var output = url.Response();

  if (LRTrim(output) == "found") {
    url = new JSURL("../servlet/JSPLoad?type=module&name=" + currentname, true);

    var strreload = Strtran(url.Response(), '\u0080', '\u20AC');
    if (isLoading) {
      reload_(e, strreload, false, _pdfsrc);
      indexUndo = -1;
      indexRedo = -1;
      undoSequence = [];
      undoItemsMoved = [];
      m_bUpdated2 = false;
      selectedZoombox("zoombox");
    }
    else {
      $('loading').setStyle('opacity', 0.7).innerHTML = "Loading <span style='font-weight:bold;font-style:italic;'>" + currentname + "</span>...";
      var fnToDelayx = function () {
        reload_(e, strreload, false);
        indexUndo = -1;
        indexRedo = -1;
        undoSequence = [];
        undoItemsMoved = [];
        selectedZoombox("zoombox");
        $('loading').fade(0);
        m_bUpdated2 = false;
      }
      fnToDelayx.delay(2000);
    }
  }
  else {
    for (var i = 0; i < notimooManager.elements.length; i++) {
      notimooManager.close(notimooManager.elements[i]);
    }
    PSAlert.alert("Module not found");
    return;
  }
}

function afteralign() {
  if (!Empty(mainitem)) {
    setArea();
    writeHTML();
  }
}
/* *** Fine della gestione di reload *** */

/* *** Gestione del caricamento del campi da XML e VRP *** */
function Loadxml(url) {
  if (modefieldtree == false) {
    displayFieldz();
    url = unescape(url);
    url = url.replace(/[\\]/gi, '/');
    url = url.replace('//', '/');
    fieldfile = url;
    formProp.fldfile = url;
    resetToolbarFld();
    xmlLoading = false;
    LoadXMLObj(url);
  }
  else {
    displayFieldTree();
    fieldfile = url;
    formProp.fldfile = url;
    resetToolbarFld();
    var ctrl = Ctrl("toolbarfldtree");
    if (ctrl) {
      ZtVWeb.Include("../jsp-system/SPModFields_portlet.jsp?file=" + URLenc(url), "toolbarfldtree", true);
    }
  }
  if (!isLoading) { FormProperties(); }
  resizeGadgetsPane();
}

function Loadvrp(url) {
  fieldfile = url;
  formProp.fldfile = fieldfile;
  url = url.substring(0, url.indexOf(".vrp"));
  resetToolbarFld();
  vrpLoading = false;
  // Verifico se esiste su disco il vrp di cui voglio i campi.
  var foundVrp = false;
  var existVrp = new JSURL("../servlet/JSPReader?type=webreport&name=" + Trim(url) + "&check=true", true);
  foundVrp = existVrp.Response();
  if (foundVrp != "found") {
    // Vrp non trovato
    PSAlert.alert("File " + url + " not found.");
  }
  else {
    LoadXMLObj("../servlet/Report?ReportName=" + url + "&outputFormat=XMLSFIELDS");
    displayFieldz();
    resizeGadgetsPane();
  }
  if (!isLoading) { FormProperties(); }
}

function LoadXMLObj(url) {
  var group, groupDesc, fname, desc, detail, type, len, dec;
  var xmlobj0 = new ZtVWeb.XMLDataProvider(this, 'xmlobj0', url, '/FIELDS/FIELD', ' ', ' ', ' ', false);
  xmlobj0.Query();
  for (var n = 0; n < xmlobj0.nrec; n++) {
    group = xmlobj0.getStr(n, "GROUP").replace(/ /gi, '');
    groupDesc = xmlobj0.getStr(n, "GROUPDESC");
    fname = xmlobj0.getStr(n, "NAME");
    desc = xmlobj0.getStr(n, "DESCRIPTION");
    detail = xmlobj0.getStr(n, "DETAIL");
    type = xmlobj0.getStr(n, "TYPE");
    len = xmlobj0.getStr(n, "LEN");
    dec = xmlobj0.getStr(n, "DEC");
    putField(group, groupDesc, fname, desc, detail, type, len, dec, "toolbarfld");
  }
}

function LoadFields() {
  var xpos = 0;
  var ypos = 0;
  xmlLoading = true;
  elementsNrByGroup = [];
  OpenWindow("../portalstudio/openfile.jsp?tool=xml&toolenable=true", 600, 600, xpos, ypos, "Xml Fields Source");
}

function LoadFieldsVrp() {
  vrpLoading = true;
  elementsNrByGroup = [];
  if (modefieldtree == false) {
    var ctrlid = "Form_general_fldfile";
    var url = "../portalstudio/open.jsp?tool=report&onetool=true&ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionLoadVrp";
    OpenWindow(url, 800, 600);
  }
  else {
    LoadFields();
  }
}

function EditVrp() {
  if (formProp.fldfile.indexOf(".vrp") > 0) {
    var xpos = 0;
    var ypos = 0;
    if (window.parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
      window.parent.newCurrentObj(formProp.fldfile.substring(0, formProp.fldfile.indexOf(".vrp")), "report", {});
    }
    else {
      var url = "../reporteditor/index.htm?id=" + formProp.fldfile.substring(0, formProp.fldfile.indexOf(".vrp"));
      OpenWindow(url, 800, 600, xpos, ypos, "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
    }
  }
}

function ReloadFields() {
  if (formProp.fldfile.length > 0) {
    if (formProp.fldfile.indexOf(".vrp") > 0) {
      Loadvrp(formProp.fldfile);
    }
    if (formProp.fldfile.indexOf(".xml") > 0) {
      Loadxml(formProp.fldfile);
    }
  }
}

function ExpressionLoadVrp(id, value) {
  if (id) {
    var el = Ctrl(id);
    if (el && !Empty(value)) {
      el.value = value + ".vrp";
      el.focus();
    }
  }
  SetUpdated();
  if (!Empty(value)) { Loadvrp(value + ".vrp"); }
}

function SetUpdated() {
  if (m_bUpdated) {
    m_bUpdated = true;
  }
}
/* *** Fine della gestione del caricamento del campi da XML e VRP *** */

/* *** Gestione dei colori *** */
var rgbPattern = /\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*/i;
function rgbToHex(inp) {
  var hex, j;
  for (var rgb; (rgb = inp.match(rgbPattern)) != null; ) {
    hex = "#";
    for (j = 1; j < rgb.length; j++) {
      if (isNaN(parseInt(rgb[j])));
      else {
        if (j + 2 < rgb.length && rgb[j + 1] == "%") {
          hex += toHex(255 * parseInt(rgb[j]) / 100);
        }
        else {
          hex += toHex(rgb[j]);
        }
      }
    }
    inp = inp.replace(rgb[0], hex);
  }
  return inp;
}

/* *** Fine della gestione dei colori *** */

/* *** Gestione delle Aree *** */
function addLayer(numItem) {
  if (numItem != null) {
    itemsHTML[numItem].nlayers++;
    itemsHTML[numItem].layer = itemsHTML[numItem].nlayers;
    last_index = null;
    Properties();
    writeHTML();
  }
}

function removeLayer(numItem) {
  if (numItem != null && confirm("Do you want to remove the current layer?\nThis operation can not be undone!!!")) {
    if (itemsHTML[numItem].nlayers < 1) {
    }
    else {
      var name = itemsHTML[numItem].name;
      var layer = itemsHTML[numItem].layer;
      var nextlayer;
      if (layer == 1) {
        nextlayer = 1;
      }
      else {
        nextlayer = layer - 1;
      }

      var tmp = [];
      var tmpn = 0;
      var elem;
      for (var i = 0; i < itemsHTML.length; i++) {
        elem = itemsHTML[i];
        if (elem.type == "Zone" && elem.area == name) {
          if (elem.layer == layer) {
            elem.layer = nextlayer;
            tmp[tmpn] = itemsHTML[i];
            tmpn++;
          }
          else {
            if (elem.layer > layer) {
              elem.layer -= 1;
            }
            else if (elem.layer < layer) {
            }
            tmp[tmpn] = itemsHTML[i];
            tmpn++;
          }
        }
        else {
          tmp[tmpn] = itemsHTML[i];
          tmpn++;
        }
      }

      countindex[docpageindex] = tmpn;
      itemsHTML = tmp;

      itemsHTML[numItem].nlayers -= 1;
      itemsHTML[numItem].layer = nextlayer;
      if (itemsHTML[numItem].nlayers <= 0) {
        itemsHTML[numItem].nlayers = 1;
      }

      last_index = null;
      Properties();
      writeHTML();
    }
  }
}

function setArea(hide) {
  var elem;
  for (var i = 0; i < itemsHTML.length; i++) {
    elem = itemsHTML[i];
    if (elem.type == "Zone") {
      setZoneinArea(i, hide);
    }
  }
}

function setZoneinArea(itemindex, hide) {
  var i = 0;
  var ctrl = Ctrl(itemsHTML[itemindex].id);
  var zoneX = itemsHTML[itemindex].x;
  var zoneY = itemsHTML[itemindex].y;
  var elem, areaX, areaY, areaXX, areaYY;
  for (i = 0; i < itemsHTML.length; i++) {
    elem = itemsHTML[i];
    if (elem.type == "Area") {
      areaX = parseInt(elem.x);
      areaY = parseInt(elem.y);
      areaXX = areaX + parseInt(elem.w);
      areaYY = areaY + parseInt(elem.h);
      if (areaX <= zoneX && zoneX <= areaXX && areaY <= zoneY && zoneY <= areaYY) {
		if( !Empty(elem.fAreaKey) ) {
			if(elem.fAreaKey != itemsHTML[itemindex].fAreaParentKey )
				return;
		}
        if (elem.name != itemsHTML[itemindex].area) {
          itemsHTML[itemindex].area = itemsHTML[i].name;
          itemsHTML[itemindex].layer = itemsHTML[i].layer;
        }
        if (hide) {
          if (elem.name == itemsHTML[itemindex].area && elem.layer != itemsHTML[itemindex].layer) {
            ctrl.style.display = "none";
          }
          else {
            ctrl.style.display = "block";
          }
        }
        return;
      }
    }
  }
  itemsHTML[itemindex].area = "";
  itemsHTML[itemindex].layer = 0;
  if(managebarcodeqr == true && itemsHTML[itemindex].name.indexOf("BARCODE") != -1) {
    ctrl.style.display = "none";
  } else {
	if (hide) ctrl.style.display = "block";
  }
}
/* *** Fine della gestione delle Aree *** */

/* *** Gestione dei field dall'xml *** */
function displayFieldz() {
  var ctrl = Ctrl("toolbarfldz");
  var ctrl2 = Ctrl("toolbarfldtree");
  if (ctrl2) {
    ctrl2.style.display = "none";
  }
  if (ctrl) {
    ctrl.style.display = "block";
  }
}

function displayFieldTree() {
  var ctrl = Ctrl("toolbarfldz");
  var ctrl2 = Ctrl("toolbarfldtree");
  if (ctrl) {
    ctrl.style.display = "none";
  }
  if (ctrl2) {
    ctrl2.style.display = "block";
  }
}

function getFieldDesc(name) {
  for (var i = 0; i < fieldHTML.length; i++) {
    if (fieldHTML[i].fieldDetail.alias == name) {
      if (fieldHTML[i].fieldDetail.desc.length > 0) {
        return fieldHTML[i].fieldDetail.desc;
      }
      else {
        return name;
      }
    }
  }

  if (modefieldtree == true) {
    var portlet = ZtVWeb.getPortlet("SPModFields");
    if (portlet && portlet.MenuViewObj) {
      var tmpnode;
      for (i = 0; i < portlet.MenuViewObj.Tree.allnodes.length; i++) {
        tmpnode = portlet.MenuViewObj.Tree.allnodes[i];
        if (tmpnode != null && tmpnode.tooltip == name) {
          if (tmpnode.descr.length > 0) {
            addGenericField(name, tmpnode.descr);
            return tmpnode.descr;
          }
          else {
            addGenericField(name, name);
            return name;
          }
        }
      }
    }
    addGenericField(name, name);
    return name;
  }
  else {
    return name;
  }
}

function addGenericField(name, desc) {
  fieldHTML[fieldcountindex] = new ZTObjects.dragFieldObj('item'+nitem, 'Field'+nitem, 'Field', 0, 0, 0, 0, name, desc, '', 0, 0, '', '', '0', '', ''); // to complete
  nitem++;
  nAllItems++;
  fieldcountindex++;
}

function addTreeItem(name, typef, desc) {
  type = "Zone";
  $("mask").fx.start('opacity', '0.2').chain(function () {
    $("canvas").setStyle('cursor', 'crosshair');
    Ctrl("canvas").onmousedown = function (event) {
      $("mask").fx.start('opacity', '0').chain(function () {
        $("mask").setStyle('display', 'none');
      });
      putItem(event, true);
      if (putok == true) {
        itemsHTML[countindex[docpageindex] - 1].name = name;
        if(desc) itemsHTML[countindex[docpageindex] - 1].comment = desc;
        if (typef) {
          if (typef == "checkbox" || typef == "radio" || typef == "image") {
            itemsHTML[countindex[docpageindex] - 1].type_exp = typef;
          }
        }
        var ctrl = Ctrl(itemsHTML[countindex[docpageindex] - 1].id);
        if (desc) {
          ctrl.title = desc;
        } else {
        ctrl.title = getFieldDesc(name);
		}
        var ctrlx = Ctrl(itemsHTML[countindex[docpageindex] - 1].id + "_int");
        ctrlx.innerHTML = name;
        clickItem(null, itemsHTML[countindex[docpageindex] - 1].id);
      }
    }
  });
}

/* Lanciata dal portlet SPModFields_portlet.jsp. Ridisegna il gadgets_pane. */
function resizeDivContainer() {
  resizeGadgetsPane();
  if( modelightqr == false ) {
  var cg = Ctrl("gadgetPaneLast");
  var cl = Ctrl("gadgets_pane");
  cg.style.height = cl.offsetHeight - cg.offsetTop + "px";
}
}
/* *** Fine della gestione dei field dall'xml *** */

/* *** Gestione dell'ordinamento degli item *** */

/* Inserisce le Aree prima delle zone. */
function sortType(a, b) {
  if (a.type == "Area" && b.type == "Zone") { return -1; }
  if (a.type == "Zone" && b.type == "Area") { return 1; }
    if ( a.y != b.y )
        return a.y - b.y;
      return a.x - b.x;
}
/* *** Fine della gestione dell'ordinamento degli item *** */

// Seleziona l'item se cliccato
function clickItem(e, id_container) {
  var str = "";
  multipleSelection = false;
  var element;
  if (e != null) {
    element = GetEventSrcElement(e);
    if (element.id != "") {
      element = Ctrl(Strtran(element.id, "_int", ""));
    }
    if (!element.id) {
      while (element.parentNode && element.parentNode.id == "") {
        element = element.parentNode;
      }
      element = element.parentNode;
    }
  }

  if (e == null || e.shiftKey == false) {
    removeAllHandlers();
  }

  var zid;
  for (var i = 0; i < itemsHTML.length; i++) {
    zid = null;
    if (itemsHTML[i].id == id_container) {
      zid = id_container;
    }
    else {
      if ((element && itemsHTML[i].id == element.id)) {
        zid = element.id;
      }
    }
    if (zid != null) {
      last_index = null;
      itemsHTML[i].shadow = "shadow" + zid.substr(4);
      str = addHandlers(zid.substr(4));
      Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str;
      selectItem(Ctrl("shadow" + zid.substr(4)));
    }
  }

  if (element != null) {
    zid = element.id;
    if (element.id == "navmenu_tabcontainer") {
      zid = id_container;
      for (i = 0; i < imgHTML.length; i++) {
        if (imgHTML[i].id == zid) {
          selectImg(i);
          //infindex = i;
        }
      }
    }
    else {
      for (i = 0; i < fieldHTML.length; i++) {
        if (fieldHTML[i].id == zid) {
          selectField(i);
          i = fieldHTML.length;
        }
      }
    }
  }
  Properties();
}

function selectField(pos) {
  if (pos < 0) {
    pos = 0;
  }
  if (pos >= fieldcountindex) {
    pos = 0;
  }
  if (fieldHTML.length > 0) {
    fieldHTML[pos].shadow = "shadow" + fieldHTML[pos].id.substr(4);
    removeAllFieldHandlers();
    addfieldHandlers(fieldHTML[pos].id.substr(4));
    selectItemImg(Ctrl("shadow" + fieldHTML[pos].id.substr(4)));
  }
  var propDiv = $("properties");
  if (propDiv) {
    propDiv.hide();
  }
}

function removeAllImgHandlers() {
  // Svuota l'array contenente gli elementi selezionati precedentemente
  for (var i = 0; i < imgHTML.length; i++) {
    imgHTML[i].shadow = "";
  }
  Ctrl("toolbarimghandlers").innerHTML = "";
  removeAllFieldHandlers();
}

function removeAllFieldHandlers() {
  for (var i = 0; i < fieldHTML.length; i++) {
    fieldHTML[i].shadow = "";
    if (Ctrl("shadow" + fieldHTML[i].id.substr(4))) {
      document.body.removeChild(Ctrl("shadow" + fieldHTML[i].id.substr(4)));
    }
  }
  Ctrl("toolbarfldhandlers").innerHTML = "";
}

function addImgHandlers(itmIdx) {
  var itm = Ctrl("item" + itmIdx);
  if (itm == null) {
    return;
  }
  var y = itm.offsetTop;
  var x = itm.offsetLeft;
  var w = itm.offsetWidth;
  var h = itm.offsetHeight;
  var str = "";

  // aggiunge il div shadow+n della grandezza dell item per lo spostamento
  str += "<div id='shadow" + itmIdx + "' class='shadow' style='z-index:5;position:absolute;top:" + y + "px;left:" + x + "px;width:" + w + "px;height:" + h + "px;background:url(../visualweb/images/pixeldrag.png) repeat;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;' ondblclick='editItemEvent()'>";
  if (navigator.appName.indexOf("Microsoft") > -1) {
    str += "<img id='" + itmIdx + "' src='images/trasparent.gif' style='width:100%;height:100%;'>";
  }
  else {
    str += "&nbsp;";
  }
  str += "</div>";
  return str;
}

function addfieldHandlers(itmIdx) {
  var itm = Ctrl("item" + itmIdx);
  var xcontent = Ctrl("fields_container");
  var y = getY(itm) - 1- xcontent.scrollTop;
  var x = itm.offsetLeft + 12;
  var w = itm.offsetWidth + 5;
  var h = itm.offsetHeight + 1;
  var str = "";
  // aggiunge il div shadow+n della grandezza dell item per lo spostamento

  str += "<div id='shadow" + itmIdx + "' class='shadow' style='z-index:125;cursor:move;color:white;position:absolute;top:" + y + "px;left:" + x + "px;width:" + w + "px;height:" + h + "px;background:url(../visualweb/images/pixeldrag.png) repeat;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;' ondblclick='editItemEvent();' onmousedown='dragShadow2(event,this);'>";
  str += "&nbsp;";
  str += "</div>";

  var divT = document.createElement("div");
  divT.setAttribute("id", "shadow" + itmIdx);
  divT.style.zIndex = 1010;
  divT.style.cursor = "move";
  divT.style.position = "absolute";
  divT.style.top = y + "px";
  divT.style.color = "white";
  divT.style.left = x + "px";
  divT.style.width = w + "px";
  divT.style.height = h + "px";
  divT.className = "shadow";
  divT.innerHTML = "&nbsp;";
  divT.style.background = "url(../visualweb/images/pixeldrag.png) repeat";
  divT.ondblclick = editItemEvent;
  divT.onmousedown = dragShadow2;

  document.body.appendChild(divT);
  return str;
}

function getY(oElement) {
  var iReturnValue = 0;
  while (oElement != null) {
    iReturnValue += oElement.offsetTop;
    oElement = oElement.offsetParent;
  }
  return iReturnValue;
}

function dragShadow2(e/*, obj*/) {
  if (typeof(hideProperties) != "undefined") {
    hideProperties("properties");
  }
  // seleziona l'elemento
  e = (e) ? e : window.event;
  var element = GetEventSrcElement(e);
  mainitem = Ctrl(element.id);
  deltax = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  deltay = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  if (document.all) {
    deltax += window.pageXOffset;
    deltay += window.pageYOffset;
  }
  deltax = deltax - parseInt(Ctrl("backcanvas").offsetLeft) - mainitem.offsetLeft + Ctrl("canvas").scrollLeft;
  deltay = deltay - parseInt(Ctrl("backcanvas").offsetTop) - mainitem.offsetTop + Ctrl("canvas").scrollTop;
  // l'id e' shadown+n e quello dell item e' item+n
  mainitem.onmouseup = function () {
    Ctrl("toolbarfldz").onmousemove = null;
    Ctrl("canvas").onmousemove = null;
    mainitem.onmouseup = null;
  }

  Ctrl("toolbarfldz").onmousemove = moveShadow2;
  Ctrl("canvas").onmousemove = moveShadow2;
  enableDocumentSelection(false);
  m_bUpdated = true;
  e.cancelBubble = true;
  if (e.stopPropagation) {
    e.stopPropagation();
  }
  e.returnValue = false;
}

function moveShadow2(e) {
  e = (e) ? e : window.event;
  newx = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  newy = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  if (document.all) {
    newx += window.pageXOffset;
    newy += window.pageYOffset;
  }
  newx = newx - parseInt(Ctrl("backcanvas").offsetLeft) + Ctrl("canvas").scrollLeft;
  newy = newy - parseInt(Ctrl("backcanvas").offsetTop) + Ctrl("canvas").scrollTop;

  /*dx = newx - deltax - mainitem.offsetLeft;
  dy = newy - deltay - mainitem.offsetTop;*/

  var mw = getOffset(Ctrl("canvaslinks")).w + parseInt(Ctrl("v_ruler").style.width) + $("gadgets_pane").offsetWidth;
  var mh = getOffset(Ctrl("canvaslinks")).h;

  // si muove il mainitem
  if (newx - deltax > 0 && newy - deltay > 0 && (newy - deltay + mainitem.offsetHeight) < mh && (mainitem.offsetWidth + newx - deltax) < mw) {
    mainitem.style.left = (newx - deltax) + "px";
    mainitem.style.top = (newy - deltay) + "px";
  }

  mainitem.onmouseup = setShadow2;
  $("canvas").setStyle('cursor', 'move');

  if (parseInt(mainitem.style.left) + parseInt(mainitem.style.width) >= 250) {
    mainitem.style.color = "black";
  }
  else {
    mainitem.style.color = "white";
  }
}

// Funzioni di trascinamento items ####################################
function setShadow() { //REDIFINED
  if (!Empty(mainitem)) {
    var elementShadow;
    resetAlign();
    Ctrl("canvas").onmousemove = null;
    mainitem.onmouseup = null;
    moveItems();
    setArea(true);
    for (var p = 0; p < itemsHTML.length; p++) {
      if (itemsHTML[p].shadow != "") {
        elementShadow = Ctrl(itemsHTML[p].shadow);
        elementShadow.innerHTML = "";
      }
    }
    Properties();
    if (typeof(showProperties) != "undefined") {
      showProperties("properties");
    }
  }
}

function setShadow2(e) {
  Ctrl("toolbarfldz").onmousemove = null;
  Ctrl("canvas").onmousemove = null;
  mainitem.onmouseup = null;
  document.onmouseup = null;
  $("canvas").setStyle('cursor', 'default');
  var v1 = parseInt(mainitem.style.left) + parseInt(mainitem.style.width);
  var v2 = parseInt(Ctrl("backcanvas").offsetLeft);
  var w1 = parseInt(mainitem.style.top);
  var w2 = parseInt(Ctrl("backcanvas").offsetTop) + parseInt(Ctrl("backcanvas").style.height);

  if (v1 > v2 && w2 > w1) {
    type = "Zone";
    putalert = false;
    putItem(e, true);
    putalert = true;
    if (putok == true) {
      itemsHTML[countindex[docpageindex] - 1].h = parseInt(mainitem.style.height) * clCanvasLib.scale / 100;
      itemsHTML[countindex[docpageindex] - 1].w = parseInt(mainitem.style.width) * clCanvasLib.scale / 100;
      itemsHTML[countindex[docpageindex] - 1].x = parseInt(mainitem.style.left) - parseInt(Ctrl("backcanvas").offsetLeft) + Ctrl("canvas").scrollLeft;
      itemsHTML[countindex[docpageindex] - 1].y = parseInt(mainitem.style.top) - parseInt(Ctrl("backcanvas").offsetTop) + Ctrl("canvas").scrollTop;

      if (itemsHTML[countindex[docpageindex] - 1].x < 0) {
        itemsHTML[countindex[docpageindex] - 1].x = 0;
      }

      if (itemsHTML[countindex[docpageindex] - 1].y < 0) {
        itemsHTML[countindex[docpageindex] - 1].y = 0;
      }

      if (parseInt(itemsHTML[countindex[docpageindex] - 1].x) + parseInt(itemsHTML[countindex[docpageindex] - 1].w) > parseInt(Ctrl("backcanvas").style.width) + parseInt(Ctrl("canvas").scrollLeft)) {
        itemsHTML[countindex[docpageindex] - 1].w = parseInt(Ctrl("backcanvas").style.width) - parseInt(itemsHTML[countindex[docpageindex] - 1].x) - 3;
      }
      if (parseInt(itemsHTML[countindex[docpageindex] - 1].y) + parseInt(itemsHTML[countindex[docpageindex] - 1].h) > parseInt(Ctrl("backcanvas").style.height) + parseInt(Ctrl("canvas").scrollTop)) {
        itemsHTML[countindex[docpageindex] - 1].h = parseInt(Ctrl("backcanvas").style.height) - parseInt(itemsHTML[countindex[docpageindex] - 1].y) - 3;
      }

      var itx = "item" + mainitem.id.substr(6);
      for (var n = 0; n < fieldHTML.length; n++) {
        if (itx == fieldHTML[n].id) {
          itemsHTML[countindex[docpageindex] - 1].name = fieldHTML[n].fieldDetail.alias;
          itemsHTML[countindex[docpageindex] - 1].detail = fieldHTML[n].groupDetail.detail;
          if (fieldHTML[n].groupDetail.detail == true) {
            itemsHTML[countindex[docpageindex] - 1].detail = true;
            itemsHTML[countindex[docpageindex] - 1].detailnumber = 1;
          }
        }
      }
    }
  }

  removeAllFieldHandlers();
  enableDocumentSelection(true);
  writeHTML();
  if (putok == true) {
    setZoneinArea(countindex[docpageindex] - 1);
    clickItem(null, itemsHTML[countindex[docpageindex] - 1].id);
  }
}

function EndPutShadowField(e, idFld) {
  Ctrl(idFld + "_shadow").style.height = "15px";
  var v1 = Ctrl(idFld + "_shadow").offsetLeft + Ctrl(idFld + "_shadow").offsetWidth;
  var v2 = Ctrl("backcanvas").offsetLeft;
  var w1 = Ctrl(idFld + "_shadow").offsetTop;
  var w2 = Ctrl("backcanvas").offsetTop + Ctrl("backcanvas").offsetHeight;

  if (v1 > v2 && w2 > w1) {
    type = "Zone";
    putalert = false;
    putItem(e, true);
    putalert = true;
    if (putok == true) {
      itemsHTML[countindex[docpageindex] - 1].h = Ctrl(idFld + "_shadow").offsetHeight * clCanvasLib.scale / 100;
      itemsHTML[countindex[docpageindex] - 1].w = Ctrl(idFld + "_shadow").offsetWidth * clCanvasLib.scale / 100;
      itemsHTML[countindex[docpageindex] - 1].x = Ctrl(idFld + "_shadow").offsetLeft - Ctrl("backcanvas").offsetLeft + Ctrl("canvas").scrollLeft;
      itemsHTML[countindex[docpageindex] - 1].y = Ctrl(idFld + "_shadow").offsetTop - Ctrl("backcanvas").offsetTop + Ctrl("canvas").scrollTop;

      if (itemsHTML[countindex[docpageindex] - 1].x < 0) {
        itemsHTML[countindex[docpageindex] - 1].x = 0;
      }

      if (itemsHTML[countindex[docpageindex] - 1].y < 0) {
        itemsHTML[countindex[docpageindex] - 1].y = 0;
      }

      if (parseInt(itemsHTML[countindex[docpageindex] - 1].x) + parseInt(itemsHTML[countindex[docpageindex] - 1].w) > parseInt(Ctrl("backcanvas").style.width) + parseInt(Ctrl("canvas").scrollLeft)) {
        itemsHTML[countindex[docpageindex] - 1].w = parseInt(Ctrl("backcanvas").style.width) - parseInt(itemsHTML[countindex[docpageindex] - 1].x) - 3;
      }
      if (parseInt(itemsHTML[countindex[docpageindex] - 1].y) + parseInt(itemsHTML[countindex[docpageindex] - 1].h) > parseInt(Ctrl("backcanvas").style.height) + parseInt(Ctrl("canvas").scrollTop)) {
        itemsHTML[countindex[docpageindex] - 1].h = parseInt(Ctrl("backcanvas").style.height) - parseInt(itemsHTML[countindex[docpageindex] - 1].y) - 3;
      }

      var itx = Ctrl(idFld+"_shadow").getAttribute("data-attr");
      for (var n = 0; n < fieldHTML.length; n++) {
        if (itx == fieldHTML[n].id) {
          itemsHTML[countindex[docpageindex] - 1].name = fieldHTML[n].fieldDetail.alias;
          itemsHTML[countindex[docpageindex] - 1].detail = fieldHTML[n].groupDetail.detail;
          if (fieldHTML[n].fieldDetail.type == 'D') {
            itemsHTML[countindex[docpageindex] - 1].datatype = 'date';
          }
          else if (fieldHTML[n].fieldDetail.type == 'T') {
            itemsHTML[countindex[docpageindex] - 1].datatype = 'time';
          }
          else if (fieldHTML[n].fieldDetail.type == 'N') {
            itemsHTML[countindex[docpageindex] - 1].datatype = 'number';

          }
          if (fieldHTML[n].groupDetail.detail == true) {
            itemsHTML[countindex[docpageindex] - 1].detail = true;
            itemsHTML[countindex[docpageindex] - 1].detailnumber = 1;
          }
          n = fieldHTML.length;
        }
      }
    }
  }

  removeAllFieldHandlers();
  enableDocumentSelection(true);
  writeHTML();
  if (putok == true) {
    setZoneinArea(countindex[docpageindex] - 1);
    clickItem(null, itemsHTML[countindex[docpageindex] - 1].id);
  }
}
/* *** Fine della gestione della selezione di un item *** */

/* *** Gestione spostamento degli item *** */
function findDragItems(e, y, x, w, h) { //REDIFINED
  // Trova se un elemento e' nel rettangolo di selezione
  // CREA IL RETANGOLO DI SELEZIONE DI DIMENSIONI MINIME CHE CONTIENE TUTTI GLI OGGETTI SELEZIONATI
  multipleSelection = true;
  e = (e) ? e : window.event;
  var str = "";
  not_selected = [];
  // Se non premuto lo shift
  if (e.shiftKey == false) {
    removeAllHandlers();
  }

  if (itemsHTML.length > 0) {
    // Cerca il primo item attivo
    container_selection.e = [];
    container_selection.l = Ctrl("backcanvas").offsetWidth;
    container_selection.t = Ctrl("backcanvas").offsetHeight;
    container_selection.b = 0;
    container_selection.r = 0;
    var itm, itmobj, j;
    for (var i = 0; i < itemsHTML.length; i++) {
      itm = document.getElementById(itemsHTML[i].id);
      itmobj = itemsHTML[i];
      if (itm && itmobj.id.indexOf("item") >= 0) {
        if (itm.style.display != "none") {
          if (itm.offsetTop > y && itm.offsetLeft > x && itm.offsetTop + itm.offsetHeight < y + h && itm.offsetLeft + itm.offsetWidth < x + w) {
            if (Empty(itemsHTML[i].shadow)) {
              str += addHandlers(itemsHTML[i].id.substr(4));
              // Aggiunge l'item selezionato all'array se non presente
              itemsHTML[i].shadow = "shadow" + itemsHTML[i].id.substr(4);
            }
            // Creazione del rettangolo contenitore
            if (itm.offsetLeft < container_selection.l) {
              container_selection.l = itm.offsetLeft;
            }
            if (itm.offsetTop < container_selection.t) {
              container_selection.t = itm.offsetTop;
            }
            if ((itm.offsetTop + itm.offsetHeight) > container_selection.b) {
              container_selection.b = (itm.offsetTop + itm.offsetHeight);
            }
            if ((itm.offsetLeft + itm.offsetWidth) > container_selection.r) {
              container_selection.r = (itm.offsetLeft + itm.offsetWidth);
            }
            container_selection.e.push(i);

            if (itemsHTML[i].type == "Area") {
              for (j = 0; j < itemsHTML.length; j++) {
                if (itemsHTML[j].area == itemsHTML[i].name) {
                  if (Empty(itemsHTML[j].shadow)) {
                    itm = document.getElementById(itemsHTML[j].id);
                    if (itm.style.display == "none") {
                      itm.style.display = "block";
                      str += addHandlers(itemsHTML[j].id.substr(4));
                      itm.style.display = "none";
                    }
                    else {
                      str += addHandlers(itemsHTML[j].id.substr(4));
                    }
                    // Aggiunge l'item selezionato all'array se non presente
                    itemsHTML[j].shadow = "shadow" + itemsHTML[j].id.substr(4);
                    itm = document.getElementById(itemsHTML[j].id);
                    container_selection.e.push(j);
                  }
                }
              }
            }
          }
          else {
            if (!itmobj.hidden) {
              not_selected.push(i);
            }
          }
        }
      }
    }
    container_selection.w = container_selection.r - container_selection.l;
    container_selection.h = container_selection.b - container_selection.t;
  }
  Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str;
}

function validZoneinArea(x, y, w, h) {
  var i = 0;
  var elem, areaX, areaY, areaXX, areaYY;
  for (i = 0; i < itemsHTML.length; i++) {
    elem = itemsHTML[i];
    if (elem.type == "Area") {
      areaX = parseInt(elem.x);
      areaY = parseInt(elem.y);
      areaXX = areaX + parseInt(elem.w);
      areaYY = areaY + parseInt(elem.h);
      if ( (areaX <= (x+w) && (x+w) <= areaXX && areaY <= (y+h) && (y+h) <= areaYY)
		  || (areaX <= (x) && (x) <= areaXX && areaY <= (y) && (y) <= areaYY)
		  || (areaX <= (x+w) && (x+w) <= areaXX && areaY <= (y) && (y) <= areaYY)
		  || (areaX <= (x) && (x) <= areaXX && areaY <= (y+h) && (y+h) <= areaYY)
	     ) {
        if(!Empty(elem.fAreaKey)) {
          return false;
        }
        return true;
      }
    }
  }
  return true;
}

function ValidMove(x, y, w, h/*, id*/) {
  var ret = true;
  if( index >=0 && itemsHTML[index] != undefined ) {
	  var itm = itemsHTML[index];
	  var isFalseSet = (itm.canMove === 'false');
	  if( (itm.canMove == false) || isFalseSet)
		  return false;
  }
  if (x < 0 || y < 0) {
    ret = false;
  }
  if (ret == true) {
    var yy = y + h;
    var xx = x + w;
    if (document.all) {
      newx += window.pageXOffset;
      newy += window.pageYOffset;
    }
    newx = newx - Ctrl("backcanvas").offsetLeft + Ctrl("canvas").scrollLeft;
    newy = newy - Ctrl("backcanvas").offsetTop + Ctrl("canvas").scrollTop;
    var mw = Ctrl("canvaslinks").offsetWidth;
    var mh = Ctrl("canvaslinks").offsetHeight;
    if (yy < mh && xx < mw) {
	  if( modelightqr == true )
		  return validZoneinArea(x, y, w, h);
	  else
      return true;
    }
    else {
      return false;
    }
  }

  return ret;
}

function endDragHandler() { //REDIFINED
  // Tolgo gli allineamenti e le selected_shadow
  resetAlign();
  var shadow = Ctrl("shadow" + draggedItemIdx);
  shadow.innerHTML = "";
  // Salvo le proprieta' nell'oggetto item
  afteralign();
  Properties();
  Ctrl("canvas").onmousemove = null;
  Ctrl("canvas").onmouseup = null;
  m_bUpdated = true;
  if (typeof(showProperties) != "undefined") {
    showProperties("properties");
  }
}

function beginDragSelection2(event) {
  dragSelection = true;
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].id.indexOf("bar_") == 0) {
      Ctrl(itemsHTML[i].id).style.zIndex = 1;
    }
  }
  beginDragSelection(event);
  Ctrl("canvas").onmouseup = endDragSelection2;
}

function endDragSelection2(event) {
  dragSelection = false;
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].id.indexOf("bar_") == 0) {
      Ctrl(itemsHTML[i].id).style.zIndex = 100;
    }
  }
  endDragSelection(event);
}
/* *** Fine della gestione spostamento degli item *** */

// metodi convertFunc che traduce le date x signature markup in module
// in smartreport e report sono contenute in SPReportMask
function convertDateTimeUpperCase(value) {
  if (value.toLowerCase() == "none") {
    return value;
  }
  return value.toUpperCase();
}

function convertDateTimeLowerCase(value) {
  if (value.toLowerCase() == "none") {
    return value;
  }
  return value.toLowerCase();
}

function putSystemVarNumPage() {
  addItem("Zone", "nNumPage");
}

function putSystemVarTotalPages() {
  addItem("Zone", "nTotalPages");
}

var currentAPITypeExpr = "type_exp";
var currentAPITypeExprValue = "";
var currentAPIClass = null;
var currentAPIType = "";
function renderApi(obj /*itemsHTML object*/) { //overwrite PortalCommonJS.js
  currentAPIClass = null;
  currentAPIType = "";
  if (obj && obj.objClass) {
    currentAPIClass = obj.objClass;
    currentAPIType = obj.type;
    currentAPITypeExprValue = obj[currentAPITypeExpr];
    openSPComponentAPI();
  }
}

function getRenderApiObjClass(withEvaluation) { //overwrite PortalCommonJS.js
  var myCopy;
  var myType;
  var hideObjects = [];
  hideObjects.push(currentAPITypeExpr);
  myCopy = currentAPIClass;
  myType = currentAPIType;
  if (currentAPIType == 'Zone' ) {
    myType = currentAPITypeExprValue;
  }
  if ( !withEvaluation ) {
    myCopy = {};
    myCopy.helper = currentAPIClass.helper;
    if( currentAPIClass.helper && currentAPIClass.helper[currentAPITypeExprValue]) {
      myCopy.helper = currentAPIClass.helper[currentAPITypeExprValue];
    }
  }
  if ( withEvaluation) {
    var itemObj = myCopy;
    var found = false;
    if (itemObj && itemObj.newProperties) {
      var tab, ii, tabh, iii, foundh, mkeys, l, o, tabl;
      var nkeys = Object.keys(itemObj.newProperties);
      for ( var i=0; !found && i<nkeys.length; i++ ) {
        tab = itemObj.newProperties[nkeys[i]];
        for (ii = 0; !found && ii < tab.length; ii++) {
          if ( tab[ii].propID == currentAPITypeExpr ) {
            found = true;
            if ( tab[ii].hide_list ) {
              foundh = false;
              mkeys = Object.keys(tab[ii].hide_list);
              for ( var j=0; !foundh && j<mkeys.length; j++ ) {
                tabh = tab[ii].hide_list[mkeys[j]];
                if ( mkeys[j].indexOf(currentAPITypeExprValue) >=0 ) {
                  foundh = true;
                  for (iii=0; iii < tabh.length; iii++) {
                    l = tabh[iii];
                    o = decodeShowHideList(l);
                    if (Empty(o.prop) && !Empty(o.tab)) {
                      tabl = itemObj.newProperties[o.tab];
                      for (var k=0; tabl && k<tabl.length; k++) {
                        hideObjects.push(tabl[k].propID);
                      }
                    }
                    else {
                      hideObjects.push(o.prop);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  return { apiType : myType, apiObj : myCopy, apiHidden : hideObjects};
}

function EditEUNotes() {
  var id = "notes_" + "note";
  loadEditNotes(id);
}

function loadEditNotes(ctrlid) {
  var url = "../portalstudio/insert_text.html?ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionNotesReturn";
  var width = 400;
  var height = 250;
  var additionalUrl = "&description&SPModalLayerId=notesSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "insert_text");
}

/* *** Gestione dell'apertura dei pop-up del disegnatore *** */
function openNewWindow(url, additionalUrl, height, width, top, left, title) {
  left = (left > -1 ? left : ((screen.width) ? (screen.width - width) / 2 : 100));
  top = (top > -1 ? top : ((screen.height) ? (screen.height - height - (height / 4)) / 2 : 100));
  if (IsNetscape() || IsMozilla()) {
    //Per Netscape e Mozilla, il width e height sono leggermente diversi
    width += 5;
    height += 4;
  }
  url += additionalUrl;
  if (IsIE() && getInternetExplorerVersion() <= 8) {
    OpenWindow(url, width, height, left, top, "toolbar=no,menubar=no,location=no,resizable=yes", title);
  }
  else {
    openSPModalLayer(url, null, null, null, null, true, 1, false, false);
  }
}
/* *** Fine della gestione dell'apertura dei pop-up del disegnatore *** */

function ExpressionNotesReturn(id, value) {
  if (id) {
    var el = document.getElementById(id);
    if (el) {
      el.value = value;
      el.focus();
    }
    SetUpdated();
  }
}

function getAddItemPageletPortlet(portlet_name, win, currwin, itemType, itemName) {
  var isok = false;
  var ret = null;
  if (win.ZtVWeb != null && win.ZtVWeb != "undefined") {
    // Pagelet
    if (win.getPagelet) {
      var pagelet_id = win.getPagelet();
      if (pagelet_id != null && pagelet_id != "undefined") {
        if (pagelet_id.cbscanedit_getItem) {
          ret = pagelet_id.cbscanedit_getItem(portlet_name, currwin, itemType, itemName);
          isok = true;
        }
      }
    }
    // Portlet
    if (!isok && win.ZtVWeb.getPortletId) {
      var portlet_id = win.ZtVWeb.getPortletId();
      if (portlet_id != null && portlet_id != "undefined") {
		  for (var p = 0; p <= portlet_id.length; p++) {
		  var portlet_obj = win.ZtVWeb.getPortletById(portlet_id[p]);
          if (portlet_obj != null && portlet_obj != "undefined") {
            if (portlet_obj.cbscanedit_getItem) {
              ret = portlet_obj.cbscanedit_getItem(portlet_name, currwin, itemType, itemName);
              isok = true;
            }
          }
		  if(isok) break;
		}
      }
    }
  }
  return ret;
}

function getFixedItemsPageletPortlet(portlet_name, win, currwin) {
  var isok = false;
  var ret = null;
  if (win.ZtVWeb != null && win.ZtVWeb != "undefined") {
    // Pagelet
    if (win.getPagelet) {
      var pagelet_id = win.getPagelet();
      if (pagelet_id != null && pagelet_id != "undefined") {
        if (pagelet_id.cbscanedit_getFixedItems) {
          ret = pagelet_id.cbscanedit_getFixedItems(portlet_name, currwin);
          isok = true;
        }
      }
    }
    // Portlet
    if (!isok && win.ZtVWeb.getPortletId) {
      var portlet_id = win.ZtVWeb.getPortletId();
      if (portlet_id != null && portlet_id != "undefined") {
		  for (var p = 0; p <= portlet_id.length; p++) {
		  var portlet_obj = win.ZtVWeb.getPortletById(portlet_id[p]);
          if (portlet_obj != null && portlet_obj != "undefined") {
            if (portlet_obj.cbscanedit_getFixedItems) {
              ret = portlet_obj.cbscanedit_getFixedItems(portlet_name, currwin);
              isok = true;
            }
          }
		  if(isok) break;
		}
      }
    }
  }
  return ret;
}

function hasfAreaFixed() {
	for (var i = 0; i < countindex.length; i++) {
		for (var j = 0; j < itemsHTMLArray[i].length; j++) {
			var elem = itemsHTMLArray[i][j];
			if( elem.type == 'Area' && !Empty(elem.fAreaKey))
				return true;
		}
	}
	return false;
}

function getItemsTypeCount(type) {
	var ret = {};
	ret.tElements = 0;
	ret.tElementsPage = [];
	ret.tTypeElements = 0;
	ret.tTypeElementsPage = [];

	function chBarcode2D(item) {
		if( item.type_exp == 'barcode' &&  item.barcode == 'QRCode') return true;
		return false;
	}

	for (var i = 0; i < countindex.length; i++) {
		ret.tElementsPage[i] = 0;
		ret.tTypeElementsPage[i] = 0;
		for (var j = 0; j < itemsHTMLArray[i].length; j++) {
			ret.tElementsPage[i]++;
			ret.tElements++;
			if( type == 'Barcode2D' &&  chBarcode2D(itemsHTMLArray[i][j])) {
				ret.tTypeElements++;
				ret.tTypeElementsPage[i]++;
			}
			else if( itemsHTMLArray[i][j].type_exp == type ) {
				ret.tTypeElements++;
				ret.tTypeElementsPage[i]++;
			}
		}
	}
	return ret;
}

/*
Funzione di inserimento elementi dal opener o parent
opener deve implementare metodo cbscanedit_getItem(portlet_name, window, type)
dove type � il tipo di oggetto
cbscanedit_getItem deve ritornare un oggetto con le proprieta definite in items.obj
x e y sono necessari
x, y, width, e height vengono intesi con valori al 100% (zoom)
esempio :
ret.page = 2; //numero di pagina (parte da 1)
ret.x = 10;
ret.y = 10;
ret.width = 140;
ret.height = 40;
ret.maxElements = 1; //numero massimo di elementi, se gia raggiunto, il nuovo elemento non viene aggiunto
ret.maxElementsPage = 1; //numero massimo di elementi nella pagina, se gia raggiunto, il nuovo elemento non viene aggiunto
ret.maxTypeElements = 1; //numero massimo di elementi per il tipo specificato, se gia raggiunto, il nuovo elemento non viene aggiunto
ret.maxTypeElementsPage = 1; //numero massimo di elementi per il tipo specificato nella pagina, se gia raggiunto, il nuovo elemento non viene aggiunto
ret.name = 'pippo';  // esempio specifca name dell elemento inserito
*/
function openerAddItem( item, itemname ) {
	if (arguments[0].type && arguments[0].type == "drop") {
		type = arguments[1];
	}
	else if (arguments[0].type && arguments[0].type == "click") {
		type = arguments[1];
	}
	else {
		type = item;
	}
	var portlet_name = "";
	currentname = Strtran(currentname, '\\', "/");
	if (currentname.indexOf('/') > -1) {
		portlet_name = currentname.substring(currentname.lastIndexOf("/") + 1);
	} else {
		portlet_name = currentname;
	}
	var opener = GetOpener();
	if( opener == null ) opener = window.parent;
	var pItem = null;
	if (opener.cbscanedit_getItem) {
		pItem = opener.cbscanedit_getItem(portlet_name, window, type, itemname);
	}
	else {
		pItem = getAddItemPageletPortlet(portlet_name, opener, window, type, itemname);
	}
	if( pItem == null ) {
		addItem(item, itemname);
	}
	else {
		if ( pItem.page != undefined ) {
			var page = parseInt(pItem.page);
			page = page - 1;
			if( page < 0 || page >= maxpages ) {
				return;
			}
			var ret = getItemsTypeCount(type);
			if( (pItem.maxElements != undefined) && (pItem.maxElements <= ret.tElements) ) {
				return;
			}
			if( (pItem.maxElementsPage != undefined) && (pItem.maxElementsPage <= ret.tElementsPage[page]) ) {
				return;
			}
			if( (pItem.maxTypeElements != undefined) && (pItem.maxTypeElements <= ret.tTypeElements) ) {
				return;
			}
			if( (pItem.maxTypeElementsPage != undefined) && (pItem.maxTypeElementsPage <= ret.tTypeElementsPage[page]) ) {
				return;
			}
			pItem.page = page;
			tabs.setSelectedTab(page);
			adjustTabHeight();
			var fnToDelayx = function () {
				if( pItem.x != undefined && pItem.y != undefined ) {
          var xpos = pItem.x * clCanvasLib.scale / 100;
					var ypos = pItem.y;
					if( (managebarcodeqr == true && pItem.name != undefined) && (pItem.name == 'QRCODE' || pItem.name.indexOf("BARCODE") != -1) ) {
						ypos = parseInt(Ctrl("canvaslinks").offsetHeight) - parseInt(Ctrl("canvaslinks").offsetHeight) / 11;
					} else {
						ypos = pItem.y * clCanvasLib.scale / 100;
					}
					putItemType(type, xpos, ypos, pItem);
					toolbarUpdateState();
				}
			}
			fnToDelayx.delay(500);
		}
		else if( pItem.x != undefined && pItem.y != undefined ) {
			var retc = getItemsTypeCount(type);
			if( (pItem.maxElements != undefined) && (pItem.maxElements <= retc.tElements) ) {
				return;
			}
			if( (pItem.maxElementsPage != undefined) && (pItem.maxElementsPage <= retc.tElementsPage[docpageindex]) ) {
				return;
			}
			if( (pItem.maxTypeElements != undefined) && (pItem.maxTypeElements <= retc.tTypeElements) ) {
				return;
			}
			if( (pItem.maxTypeElementsPage != undefined) && (pItem.maxTypeElementsPage <= retc.tTypeElementsPage[docpageindex]) ) {
				return;
			}
			var xpos = pItem.x * clCanvasLib.scale / 100;
      var ypos = pItem.y * clCanvasLib.scale / 100;
			putItemType(type, xpos, ypos, pItem);
			toolbarUpdateState();
		}
	}
}

/*
Funzione di inserimento elementi dal opener o parent
opener deve implementare metodo cbscanedit_getFixedItems(portlet_name, window)
deve ritornare un oggetto json
- x, y, width, e height descrivono la zona delle elementi da inserire
se non specificati, x vale 0, y vale 0, width la larghezza della pagina, height un terzo altezza della pagina
- page la pagina dove inserire gli elementi
se non specificato, si usa la pagina corrente
- items : array di oggetti con le proprieta definite in items.obj
esempio :
ret.page = 2; //numero di pagina (parte da 1)
ret.x = 10;
ret.y = 10;
ret.width = 140;
ret.height = 40;
ret.items = [
	{x:12, y:12, width:20, height:40, type:'zone', name:'codice', comment:'mycomment'}, ....
	//se specificato sugli elementi, l attributo page verra ignorato
]
x, y, width, e height vengono intesi con valori al 100% (zoom)
*/
function openerAddFixedElements() {
	if( hasfAreaFixed() ) return;
	var portlet_name = "";
	currentname = Strtran(currentname, '\\', "/");
	if (currentname.indexOf('/') > -1) {
		portlet_name = currentname.substring(currentname.lastIndexOf("/") + 1);
	} else {
		portlet_name = currentname;
	}
	var opener = GetOpener();
	if( opener == null ) opener = window.parent;
	var pItem = null;
	if (opener.cbscanedit_getFixedItems) {
		pItem = opener.cbscanedit_getFixedItems(portlet_name, window);
	}
	else {
		pItem = getFixedItemsPageletPortlet(portlet_name, opener, window, type);
	}
	if( pItem != null ){
		pItem.canMove = false;
		if ( pItem.page != undefined ) {
			var page = parseInt(pItem.page);
			page = page - 1;
			if( page < 0 || page >= maxpages ) {
				return;
			}
			pItem.page = page;
			tabs.setSelectedTab(page);
			adjustTabHeight();
		}
		var fnToDelayx = function () {

			function checkIfEmptyArea(x, y, width, height, page) {
				if( page < 0 || page >= maxpages ) {
					return false;
				}
				var xx = x + width;
				var yy = y + height;
				for (var j = 0; j < itemsHTMLArray[page].length; j++) {
					var item = itemsHTMLArray[page][j];
					var itx = item.x*100/clCanvasLib.scale;
					var ity = item.y*100/clCanvasLib.scale;
					var itxx = item.x*100/clCanvasLib.scale + item.w*100/clCanvasLib.scale;
					var ityy = item.y*100/clCanvasLib.scale + item.y*100/clCanvasLib.scale;
					if( itx > x && itx < xx  && ity > y && ity < yy) return false;
					if( itxx > x && itxx < xx  && ity > y && ity < yy) return false;
					if( itxx > x && itxx < xx  && ityy > y && ityy < yy) return false;
					if( itx > x && itx < xx  && ityy > y && ityy < yy) return false;
				}
				return true;
			}
			if( pItem.x == undefined ) pItem.x = 0;
			if( pItem.y == undefined ) pItem.y = 0;
			if( pItem.width == undefined ) pItem.width = workAreaWidth-2;
			if( pItem.height == undefined ) pItem.height = (workAreaHeight / 6.3) * 2;

			var xpos = pItem.x * clCanvasLib.scale / 100;
			var ypos = pItem.y * clCanvasLib.scale / 100;
			pItem.fAreaKey = LibJavascript.CharKeyGen(5);

			if( checkIfEmptyArea(pItem.x, pItem.y, pItem.width, pItem.height, docpageindex) == false ) {
				alert('Ci sono altri elementi presenti nella zona riservata!');
				return;
			}

			putItemType('Area', xpos, ypos, pItem);
			toolbarUpdateState();
			if(pItem.items) {
				var k;
				for( k=0; k<pItem.items.length; k++ ) {
					var _pItem = pItem.items[k];
					_pItem.canMove = false;
					var type = _pItem.type;
					if(!type) type = 'Zone';
					xpos = _pItem.x * clCanvasLib.scale / 100;
					ypos = _pItem.y * clCanvasLib.scale / 100;
					_pItem.fAreaParentKey = pItem.fAreaKey;
					putItemType(type, xpos, ypos, _pItem);
				}
			}
		}
		fnToDelayx.delay(500);
	}
}

function toolbarUpdateState() {
	if( modelightqr == true ) {
		var addBarcodeCtrl = Ctrl('addbarc2dpage');
		if( addBarcodeCtrl ) {
			var iCount = getItemsTypeCount('Barcode2D');
			if( iCount.tTypeElements > 0 ) {
				addBarcodeCtrl.style.opacity = 0.2;
			}
			else {
				addBarcodeCtrl.style.opacity = 1;
			}
		}
		var addfixedCtrl = Ctrl('addfixedelempage');
		if( addfixedCtrl ) {
			var b = hasfAreaFixed();
			if( b ) {
				addfixedCtrl.style.opacity = 0.2;
			}
			else {
				addfixedCtrl.style.opacity = 1;
			}
		}
	}
}

function manageBarcode() {
	var qrcExist = false;
	var bcExist = false;
	var bcRemove = [];
	// In fase di salvataggio del pdf, se presente il QRCode devo aggiungere anche i 3 campi BARCODE
	// Viceversa, se assente, verifico la presenza dei 3 Barcode, se presenti li cancello prima che venga creato il file MRP
	if(managebarcodeqr == true) {
		for (var i = 0; i < countindex.length; i++) {
			for (var j = 0; j < itemsHTMLArray[i].length; j++) {
				if( itemsHTMLArray[i][j].type == 'Zone' &&  itemsHTMLArray[i][j].name.indexOf("BARCODE") != -1) {
					bcExist = true;
					bcRemove.push(itemsHTMLArray[i][j].id);
				}
				if(itemsHTMLArray[i][j].barcode == 'QRCode' && itemsHTMLArray[i][j].name == 'QRCODE') {
					qrcExist = true;
				}
			}
		}

		if(qrcExist) {
			if(!bcExist) {
				openerAddItem("Zone", "BARCODE");
				openerAddItem("Zone", "BARCODE1");
				openerAddItem("Zone", "BARCODE2");
			}
		} else {
			if(bcExist && bcRemove.length > 0) {
				for (var k = 0; k < bcRemove.length; k++) {
					// Per cancellare un elemento, prima devo cliccarci sopra poi richiamare la delete
					clickItem(null, bcRemove[k]);
					deleteItem();
				}
			}
		}
	}
}
