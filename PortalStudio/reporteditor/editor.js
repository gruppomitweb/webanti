/* exported def WinOpener changeselectshadow nBarItems rHIdx pHIdx searchProp fieldsProp
    v_line forcePreviewReload tool pdfimagesrc dwidth dheight clCanvasLib hightlElements
    toolbars ItemEventInput offsetBand deltax deltay dx dy offsetdiv Help textSize isSon
    ListObj translateCharacters setLoadPic getGroupUid getGroupExpr sortX openReport
    newdesign newCurrentObj wizard LoadPdf clickItem editItemEvent selectItem3
    removeAllBarHandlers addItem InsertImageDone putItem2 Copy saveresult toolbarPreview
    compareArray reportPreview draggingHandler draggingHandlerCorner draggedItemIdx
    dragSelection moveSection moveLine ValidMove addVariable updateVariable togglerGadget
    getItemsHTML addCommentLabel _createModel generateXLSXModel zoomindex isSecureDoc
    nodialog into_variable_combo printgroupuid calconuid resetonuid
*/
/* global designToolbar openas selectedZoombox resizeWindow readLibrary readSystemVariables
   NavForm printgroupuid calconuid resetonuid clickBand initCanvas removeCachedQuery
   getObjImg getDescBand getDescBand2 unSelectBand lastBandSelected generateRulers
   setCanvasScroll setShadow navBands HightLight setToolbarCtrlBtn zoom zoomindex
   resetSearchReplace putItemNoView ZeroPad nbaritem checkAddGroup checkAddPageBreak
   checkAddDataSection scale isSecureDoc setzoom errMsg checkCoverLinePresence
   insertIntoUndoSequence navValue navDim navDec navType navCom getDim navQueries navBO
   setPropertiesID checkBarsPosition nodialog convertToMillimeters selectBand
   getIconDataFromAction drawDragShadow encodeType PropertiesVar into_variable_combo
*/
/*
Funzioni sotto sono nel file PortalCommonJS.js:
- function dragToolbar(e,obj)
- function noDefaultDrag(e)
- function findDragItems(e,y,x,w,h)
- function removeAllHandlers()
- function addHandlers(itmIdx)
- function selectItem(itm)
- function cancelEvent(e)
- function clickShadow(e)
- function moveItems(align)
 */

var currentname = ""; //nome del report corrente
var isCustom = null; //indica se il report e' custom
var def = "";
var WinOpener; // dialog windows handler
var changeselectshadow = false;
var m_nFrontendPort = null;
var m_itemsHTML = null;

//Conta il numero di elementi totali.
var nAllItems = 0;
var nBarItems = 0; // Numero totale di elementi di tipo barra presenti nel report.
var nVar = 0; // Numero totale di User Variables presenti nel report.
var currVar = 0; // Indica l'indice nell'array reportVariables della User Variabile corrente.

// array per navigatore
var queryList = []; // Lista delle query utilizzate nel report corrente.
var bandList = []; // Lista delle barre del report corrente.
var boList = []; // Lista dei BO utilizzati nel report corrente.
var systemVariables = []; // Lista delle variabili di sistema del Report Editor utilizzabili dall'utente.
var reportVariables = []; // Lista delle User Variables.

var FuncList = []; // Lista delle funzioni di sistema utilizzabili con l'Expression Builder.

var rHIdx = -1, pHIdx = -1; // Indici del Page Header e del Report Header in bandList

// Aggiunta o rimossa una barra (serve ad ottimizzare l'array bandList)
var reorganizeBandList = true;
var reportProp = new ZTObjects.reportObj();
var searchProp = new ZTObjects.searchObj();
var fieldsProp = new ZTObjects.fieldsObj();
var v_line;
var notimooManager;
var forcePreviewReload = false;
var m_bUpdated2 = false;
var gadgetload = false;
var tool = "report";
var tabs = null;

var pdffile = "";
var maxpages = -1;
var pdfimagesrc = "";
var pdfimagesrcbck = "";
var dwidth = -1;
var dheight = -1;
var clCanvasLib = null;
var hightlElements = false;
var modenoview = false;

var refreshArray = [];
var toolbars = {};

var type = ""; // Tipo dell'item da aggiungere
var add_label_comment = "";

var ItemEventInput;

var offsetBand = 0;
var pasted = []; /* Array con l'indice degli elementi copiati. */
var newload = false;

var deltax = 0, deltay = 0, dx, dy; // distanze del punto di click dall origine dell item
var offsetdiv = 18;
var diff = 40;

var fld_accordion = null;
var mapQueryItems = [];
var mapBoItems = [];

function doLoad(e, id, mode, frontendport, custom) {
  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }
  initPainter();
  if (Empty(id)) {
    notimooManager.show({
      title : 'Notification message',
      message : 'loading Report Editor!',
      visibleTime : 1000,
      width : 200
    });
  }
  else {
    notimooManager.show({
      title : 'Notification message',
      message : 'loading report ' + id,
      sticky : true,
      width : 200
    });
  }

  var fnToDelay = function () {
    canAlign = true;
    AppletTag("Batch");
    BatchApplet().documentloc = Strtran(location.toString(), "visualweb/index.htm", "servlet/dummy");
    document.body.style.cursor = "default";
    document.body.onhelp = CancelHelp;

    /* Parametri passati al disegnatore.
       modelight: vengono nascosti i bottoni Wizard, New, SaveAs e Open.
       tosave: obbliga a salvare il report
       openas: rinomina il report corrente con il nome passato come valore del parametro.
    */
    designToolbar();

    if (!Empty(id)) {
      currentname = id;
    }
    if (mode == "tosave") {
      currentname = "";
    }
    if (!Empty(openas)) {
      currentname = openas;
    }

    if (window.parent.portalStudioContainer) {
      parent.setTitle(this);
    }
    else {
      document.title = currentname + " - Report Editor";
      if (Ctrl("srcform")) {
        Ctrl("srcform").value = currentname;
      }
    }

    //Inizio caricamento del report
    selectedZoombox("zoombox");
    reportProp.page = 1;
    isCustom = (Empty(custom) ? null : JSON.parse(custom));
    writemenuTab();
    formProp = reportProp;

    resizeWindow(e, true);
    FuncList = [];
    systemVariables = [];

    readLibrary("../portalstudio/standardfunctions.xml", FuncList);
    readSystemVariables("reportvariables.xml", systemVariables);

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

    if (!Empty(id)) {
      currentname = id;
      if (gadgetload == false) {
        create_gadget_pane();
        gadgetload = true;
      }
      reload(e, false);
      if (Ctrl("srcform")) { Ctrl("srcform").value = currentname; }
    }
    else { //id e' vuoto
      PutMainBars();
      if (gadgetload == false) {
        create_gadget_pane();
        gadgetload = true;
      }
    }

    FormProperties(true, false);
    NavForm();

    m_bUpdated = false;
    changeselectshadow = false;

    var repPropToggler = Ctrl("resource-toggler-report");
    if (repPropToggler) {
      repPropToggler.click();
      repPropToggler.click();
    }

    if (Ctrl("results_tab_content") && Ctrl("findList")) {
      Ctrl("results_tab_content").appendChild(Ctrl("findList"));
    }
  };
  fnToDelay.delay(500);
}

function Help(the_property) {
  var i;
  var prop = "";
  if (typeof(anchorToFeature) != "undefined") {
    if (typeof(the_property) != "undefined") {
      prop = "reporteditor_" + the_property.toLowerCase();
    }
    if (prop in anchorToFeature && prop != "") {
      i = anchorToFeature[prop];
    }
    else if (index != null && "reporteditor_" + itemsHTML[index].type.toLowerCase() in anchorToFeature) {
      i = anchorToFeature["reporteditor_" + itemsHTML[index].type.toLowerCase()];
    }
    else if (typeof(i)=='undefined') {
      prop = "reporteditor_" + the_property.substring(the_property.indexOf('_'),0).toLowerCase();
      i = anchorToFeature[prop];
    }

    if (typeof(i)=='undefined'){
      i = anchorToFeature["reporteditor"];
    }
    windowOpenForeground(m_cHelpUrl + "help/portalstudio/ps_urg_navigator.htm?" + URLenc(i + (prop != "" ? "||" + prop : "")), "", "toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1");
  }
}

/* Calcola la dimensione di un elemento Expression da inserire nell'area di lavoro.
 */
function textSize(item, s) {
  var obj, fontFamily, fontSize;
  var fontWeight = "normal";

  if (item.global_font == "true") {
    fontFamily = reportProp.font;
  }
  else if (LRTrim(item.font) != "") {
    fontFamily = item.font;
  }

  if (item.global_font == "true") {
    fontSize = reportProp.font_size + "pt";
  }
  else if (LRTrim(item.font_size) != "") {
    fontSize = item.font_size + "pt";
  }

  if (item.global_font == "true" && reportProp.font_weight.indexOf("bold") > -1) {
    fontWeight = "bold";
  }
  else if (LRTrim(item.font_weight) != "" && item.font_weight.indexOf("bold") > -1) {
    fontWeight = "bold";
  }

  obj = document.getElementById("ruler");
  obj.style.fontFamily = fontFamily;
  obj.style.fontSize = fontSize;
  obj.style.fontWeight = fontWeight;
  obj.innerHTML = s;
  return obj.offsetWidth + 5;
}

function remapSelectCombo() {
  var obj;
  printgroupuid = "select[";
  calconuid = "select[each record,end of report";
  resetonuid = "select[end of report,end of page";
  for (var i = 0; i < bandList.length; i++) {
    obj = bandList[i];
    if (obj.type == "Group_top") {
      printgroupuid += "," + obj.uid;
      calconuid += "," + obj.uid;
      resetonuid += "," + obj.uid;
    }
  }
  printgroupuid += "]";
  calconuid += "]";
  resetonuid += "]";
  last_index = null;
}

function isSon() {
  var i = 0, j;
  var misure = [];
  var posiz = [];

  for (i = 0; i < bandList.length; i++) {
    if (bandList[i].type == "SectBo_top") {
      misure[misure.length] = bandList[i].y;
      posiz[posiz.length] = i;
    }
    else if (bandList[i].type == "SectBo_down") {
      misure[misure.length] = bandList[i].y;
      posiz[posiz.length] = i;
    }
  }
  for (i = 0; i < misure.length; i++) {
    for (j = i + 2; j < misure.length; j++) {
      if ((misure[j] > misure[i]) && (misure[j + 1] < misure[i + 1]) && (bandList[posiz[j]].ischild)) {
        bandList[posiz[j]].boparent = bandList[posiz[i]].uid;
      }
    }
  }
}

function ListObj(obj) {
  if (obj.value.indexOf("bar_") >= 0) {
    clickBand(obj.value);
  }
  else if (obj.value.indexOf("variable") >= 0) {
    selectVariable(obj.value);
  }
  else if (LRTrim(obj.value) != "") {
    removeAllHandlers();
    var obk;
    for (var i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].id == "item" + obj.value) {
        obk = itemsHTML[i];
        break;
      }
    }
    if (obk) {
      var str = addHandlers(obk.id.substr(4));
      obk.shadow = "shadow" + obk.id.substr(4);
      Ctrl("canvashandlers").innerHTML += str;
      selectItem(Ctrl(obk.shadow));
    }
    else {
      FormProperties(false, true);
    }
  }
}

function ToReportHTML(p_cVar) {
  p_cVar = ToHTML(p_cVar);
  p_cVar = Strtran(p_cVar, " ", "&nbsp;");
  return p_cVar;
}

function translateCharacters(valueToTranslate) {
  valueToTranslate = Strtran(valueToTranslate, '&amp;', '&');
  valueToTranslate = Strtran(valueToTranslate, '&apos;', "'");
  valueToTranslate = Strtran(valueToTranslate, '&#39;', "'");
  valueToTranslate = Strtran(valueToTranslate, '&#x20;', ' ');
  valueToTranslate = Strtran(valueToTranslate, '##x2d;##x2d;', "--");
  valueToTranslate = Strtran(valueToTranslate, '##x7c;##x7c;', "||");
  return valueToTranslate;
}

/* *** Gestione dei tab del report *** */
function writemenuTab() {
  if (!tabs) {
    tabs = new TabsMT('report_page_list', 'report_page_frame', {
      clickFunc : function (index) {
        selectReportPage(index);
      },
      close:false
    });
  }
  var li, span, reportFrame;
  reportFrame = new Element('div', {}).inject($('report_page_frame'));
  li = new Element('li').inject($('report_page_list'));
  span = new Element('span').inject(li);
  span.set('text',('Cover'));
  tabs.addTabs(li,reportFrame);

  reportFrame = new Element('div', {}).inject($('report_page_frame'));
  li = new Element('li').inject($('report_page_list'));
  span = new Element('span').inject(li);
  span.set('text',('Report'));
  tabs.addTabs(li,reportFrame);

  tabs.setSelectedTab(1);
  Ctrl("autocover_ctrl").style.opacity = 0.2;
  Ctrl("autocover_ctrl").removeEvents('click');
}

function selectReportPage(pageindex) {
  if (reportProp.page == pageindex) { return; }
  reportProp.page = pageindex;
  index = null;
  if (newPropObj != null) { newPropObj.HideProperties(); }
  removeAllHandlers();
  pdfimagesrc = (pageindex == 0) ? pdfimagesrc = "" : pdfimagesrc = pdfimagesrcbck;
  initCanvas();
  reorganizeBandList = true;
  writeHTML(true);
}

/* Ridisegna i tabs. */
function resetTabs() {
  if (tabs) {
    $('navmenu_tabcontainer').setStyles({
      'left' : $('backcanvas').getPosition().x,
      'width' : $('backcanvas').getSize().x
    });
    tabs.refresh();
  }
}
/* *** Fine della gestione dei tab del report *** */

/* *** writeHTML *** */
var currentLevel = 0; /* Variabile che memorizza il livello delle barre. Necessaria nei metodi updateBarsLevel e setBarsLevel. */

/* Verifica che il nome della query non sia vuoto o gia' inserito in queryList. In tal caso, lo aggiunge. */
function AddToQueryList(query, index) {
  if (typeof(query) != "undefined" && (LRTrim(query) != "" && LRTrim(query) != ".vqr")) {
    if (LibJavascript.Array.indexOf(queryList, query) < 0) {
      queryList[queryList.length] = LRTrim(query);
      if (!(query in mapQueryItems)) {
        mapQueryItems[query] = index;
      }
    }
    forcePreviewReload = true;
  }
}

/* Verifica che il nome della query non sia vuoto e che sia inserito in queryList. In tal caso, lo elimina. */
function RemoveFromQueryList(query) {
  if (typeof(query) != "undefined" && LRTrim(query) != "") {
    var i = LibJavascript.Array.indexOf(queryList, query);
    if (i > -1) {
      queryList.splice(i, 1);
      removeCachedQuery(query);
      if (query in mapQueryItems) {
        delete mapQueryItems[query];
      }
    }
    forcePreviewReload = true;
  }
}

/* Verifica che il nome del BO non sia vuoto o gia' inserito in boList. In tal caso, lo aggiunge. */
function AddToBOList(busObj, index) {
  if (typeof(busObj) != "undefined" && LRTrim(busObj) != "" && LRTrim(busObj) != "BO:") {
    if (boList.indexOf(LRTrim("BO:" + busObj)) < 0) {
      boList[boList.length] = LRTrim("BO:" + busObj);
      if (!(busObj in mapBoItems)) {
        mapBoItems[busObj] = index;
      }
    }
  }
}

/* Verifica che il nome del BO non sia vuoto e che sia inserito in boList. In tal caso, lo elimina. */
function RemoveFromBOList(busObj) {
  if (typeof(busObj) != "undefined" && LRTrim(busObj) != "") {
    var i = LibJavascript.Array.indexOf(boList, busObj);
    if (i > -1) {
      boList.splice(i, 1);
      removeCachedQuery(busObj);
      if (busObj in mapBoItems) {
        delete mapBoItems[busObj];
      }
    }
    forcePreviewReload = true;
  }
}

function writeHTMLItemObj(item) {
  var ctrl, ctrl2;
  if (typeof(item) == "undefined") { return; }
  if (item.page != reportProp.page) { return; }
  ctrl = document.getElementById(item.id);
  if (!ctrl) { return; }

  if (typeof(item.x) != "undefined") { ctrl.style.left = (item.x) + "px"; }
  if (typeof(item.y) != "undefined") { ctrl.style.top = (item.y) + "px"; }
  if ((item.id).indexOf("bar_") == 0) {}
  else {
    if (typeof(item.w) != "undefined") { ctrl.style.width = (item.w) + "px"; }
    if (typeof(item.h) != "undefined") { ctrl.style.height = (item.h) + "px"; }
  }

  if (item.type == "Box") {
    if (LRTrim(item.bg_color) != "") {
      ctrl.style.backgroundColor = item.bg_color;
    }
    if (LRTrim(item.border_color) != "") {
      if (LRTrim(item.border_width) != "") {
        ctrl.style.border = item.border_width + "px solid " + item.border_color;
      }
    }
    ctrl.style.width = (item.w - 2 * parseInt(item.border_width)) + "px";
    if (item.h - getOffset(ctrl).gaph >= 0) {
      ctrl.style.height = (item.h - getOffset(ctrl).gaph) + "px";
    }
    else {
      ctrl.style.height = item.h + "px";
    }

    if (LRTrim(item.bg_color) == "" || item.bg_color.toLowerCase() == "#ffffff") {
      if (item.border_color.toLowerCase() == "#ffffff" || LRTrim(item.border_width) == "0") {
        ctrl.style.border = "1px dotted #d9d9d9";
      }
    }
  }
  else if (item.type == "Label" || item.type == "Expr") {
    ctrl2 = document.getElementById(item.id + "_int");
    if (item.type == "Label") {
      if (item.w - getOffset(ctrl).gapw >= 0) {
        ctrl2.style.width = (item.w - getOffset(ctrl).gapw) + "px";
      }
      else {
        ctrl2.style.width = item.w + "px";
      }
      if (item.h - getOffset(ctrl).gaph >= 0) {
        ctrl2.style.height = (item.h - getOffset(ctrl).gaph) + "px";
        ctrl.style.height = (item.h - getOffset(ctrl).gaph) + "px";
      }
      else {
        ctrl2.style.height = item.h + "px";
      }

      if (LRTrim(item.comment) != "") {
        ctrl2.innerHTML = ToReportHTML(item.comment);
      }
      else if (LRTrim(item.value) != "") {
        ctrl2.innerHTML = ToReportHTML(item.value);
      }
      else {
        ctrl2.innerHTML = "Lab.___";
      }
    }
    else if (item.type == "Expr") {
      if (item.w - getOffset(ctrl).gapw >= 0) {
        ctrl2.style.width = (item.w - getOffset(ctrl).gapw) + "px";
        ctrl.style.width = (item.w - getOffset(ctrl).gapw) + "px";
      }
      else {
        ctrl2.style.width = item.w + "px";
        ctrl.style.width = item.w + "px";
      }
      if (item.h - getOffset(ctrl).gaph >= 0) {
        ctrl2.style.height = (item.h - getOffset(ctrl).gaph) + "px";
        ctrl.style.height = (item.h - getOffset(ctrl).gaph) + "px";
      }
      else {
        ctrl2.style.height = item.h + "px";
        ctrl.style.height = item.h + "px";
      }
      if (LRTrim(item.comment) != "") {
        ctrl2.innerHTML = ToReportHTML(item.comment);
      }
      else if (LRTrim(item.exp) != "") {
        ctrl2.innerHTML = ToReportHTML(item.exp);
      }
      else {
        ctrl2.innerHTML = "Exp.___";
      }
      ctrl2.style.display = "block";
    }

    var fontStyle = "", fontEffect = "";
    if (item.global_font + "" == "true") {
      ctrl2.style.fontFamily = reportProp.font;
      ctrl2.style.fontSize = (reportProp.font_size * reportProp.scale / 100) + "pt";
      fontStyle = reportProp.font_weight;
      fontEffect = reportProp.font_effect;
    }
    else {
      if (LRTrim(item.font) != "") { ctrl2.style.fontFamily = item.font; }
      if (LRTrim(item.font_size) != "") { ctrl2.style.fontSize = (item.font_size * reportProp.scale / 100) + "pt"; }
      if (LRTrim(item.font_weight) != "") { fontStyle = item.font_weight; }
      if (LRTrim(item.font_effect) != "") { fontEffect = item.font_effect; }
    }

    if (fontStyle == "normal") {
      ctrl2.style.fontWeight = "normal";
      ctrl2.style.fontStyle = "normal";
    }
    else if (fontStyle == "bold") {
      ctrl2.style.fontWeight = "bold";
      ctrl2.style.fontStyle = "normal";
    }
    else if (fontStyle == "italic") {
      ctrl2.style.fontWeight = "normal";
      ctrl2.style.fontStyle = "italic";
    }
    else if (fontStyle == "bold italic") {
      ctrl2.style.fontWeight = "bold";
      ctrl2.style.fontStyle = "italic";
    }
    else {
      ctrl2.style.fontWeight = "normal";
      ctrl2.style.fontStyle = "normal";
    }

    if (fontEffect == "none") {
      ctrl2.style.textDecoration = "none";
    }
    else if (fontEffect == "underline") {
      ctrl2.style.textDecoration = "underline";
    }
    else if (fontEffect == "strikeout") {
      ctrl2.style.textDecoration = "line-through";
    }
    else if (fontEffect == "strikeout underline") {
      ctrl2.style.textDecoration = "underline line-through";
    }
    else {
      ctrl2.style.textDecoration = "none";
    }

    ctrl2.style.textAlign = item.align;
    if (LRTrim(item.font_color) != "") { ctrl2.style.color = item.font_color; }
    if (LRTrim(item.color) != "") { ctrl2.style.color = item.color; }
    if (LRTrim(item.bg_color) != "") { ctrl2.style.backgroundColor = item.bg_color; }
  }
  else if (item.type == "Image") {
    if (item.src_type == "expression") {
      ctrl.src = getObjImg('image');
    }
    else if (!Empty(item.localsrc) && (Trim(ctrl.src = item.localsrc) != "")) {
      ctrl.src = item.localsrc;
    }
    else {
      ctrl.src = item.src;
    }
  }
  else if ((item.id).indexOf("bar_") == 0) {
    ctrl2 = document.getElementById("info_" + item.id);
    ctrl2.innerHTML = Strtran(getDescBand(item, 25, true), " ", "&nbsp;");
    ctrl2.title = getDescBand2(item);
    if ((item.type.indexOf("_down") < 0) && (item.type.indexOf("_bottom") < 0)) {
      ctrl2 = document.getElementById("band_" + item.id);
      if (ctrl2) {
        ctrl2.innerHTML = Strtran(getDescBand(item, 15), " ", "&nbsp;");
        ctrl2.title = getDescBand2(item);
      }
    }
  }

  if (typeof(itemsHTML[index]) != "undefined" && (itemsHTML[index].id).indexOf("bar_") != 0 && itemsHTML[index] == item) {
    ctrl = Ctrl("shadow" + itemsHTML[index].id.substr(4));
    if (ctrl) {
      ctrl.style.left = item.x + "px";
      ctrl.style.top = item.y + "px";
      if (item.w - getOffset(ctrl).gapw >= 0) {
        ctrl.style.width = (item.w - getOffset(ctrl).gapw) + "px";
      }
      else {
        ctrl.style.width = item.w + "px";
      }
      if (item.h - getOffset(ctrl).gaph >= 0) {
        ctrl.style.height = (item.h - getOffset(ctrl).gaph) + "px";
      }
      else {
        ctrl.style.height = item.h + "px";
      }
    }
  }
}

/* Riscrive l'HTML e reimposta tutte le proprieta' di tutti gli items */
function writeHTML(reset) {
  if (Empty(reset)) {
    reset = false;
  }
  //if (itemsHTML.length==0) return;
  if (reset && reorganizeBandList) {
    writeHTMLAll(reset);
    refreshArray = [];
    return;
  }
  var maxHeight = 0, maxWidth = 0;
  var item;
  var nav_i = 0;

  updateCommonVars();
  setVline();

  if (reset) {
    Ctrl("canvasitems").innerHTML = "";
    removeAllHandlers();
    for (nav_i = 0; nav_i < itemsHTML.length; nav_i++) {
      item = itemsHTML[nav_i];
      if (item.page == reportProp.page && (item.id).indexOf("bar_") != 0) {
        Ctrl("canvasitems").innerHTML += itemsHTML[nav_i].html;
        item.show = true;
        if (maxHeight < parseInt(item.y) + parseInt(item.h)) {
          maxHeight = parseInt(item.y) + parseInt(item.h);
        }
        if (maxWidth < parseInt(item.x) + parseInt(item.w)) {
          maxWidth = parseInt(item.x) + parseInt(item.w);
        }
        writeHTMLItemObj(item);
      }
    }
  }
  else {
    nav_i = 0;
    if (index != null) { //c'e' un item selezionato
      nav_i = index;
      for (; nav_i < itemsHTML.length; nav_i++) {
        if (!reset && index != null && nav_i > index) {
          break;
        }
        writeHTMLItemObj(itemsHTML[nav_i]);
      }
    }

    for (nav_i = 0; nav_i < refreshArray.length; nav_i++) {
      writeHTMLItemObj(refreshArray[nav_i]);
    }
  }

  var reporthf = false, pagehf = false;
  if (reorganizeBandList) {
    var BarsBody = "";
    queryList = [];
    boList = [];

    unSelectBand(lastBandSelected);
    HightlightSelectedSpaceBar(null);
    bandList = [];

    var r = 0;
    for (nav_i = 0; nav_i < itemsHTML.length; nav_i++) {
      item = itemsHTML[nav_i];
      if ((item.type).indexOf("Chart") >= 0) {
        if (typeof(item.query) != "undefined" && LRTrim(item.query) != "") {
          AddToQueryList(item.query, nav_i);
        }
      }
      if (item.type == "HeaderBar_top") {
        pagehf = true;
      }
      if (item.type == "ReportBar_top") {
        reporthf = true;
      }
      if ((item.id).indexOf("bar_") == 0) {
        if (item.page == reportProp.page) {
          BarsBody += item.getHtml();
        }
        if (item.type == "AltQuery_top" && typeof(item.query) != "undefined" && LRTrim(item.query) != "") {
          AddToQueryList(item.query, nav_i);
        }
        else if (item.type == "SectBo_top" && typeof(item.busobj) != "undefined" && LRTrim(item.busobj) != "") {
          AddToBOList(item.busobj, nav_i);
        }
        if (item.page == reportProp.page) {
          r = Round(item.y, 0);
          if (typeof(bandList[r]) != "undefined") {
            bandList[r + 1] = item;
          }
          else {
            bandList[r] = item;
          }
        }
        if (item.page == reportProp.page) {
          if (maxHeight < parseInt(item.y) + parseInt(item.h)) {
            maxHeight = parseInt(item.y) + parseInt(item.h);
          }
        }
      }
    }

    bandList = bandList.clean();
    nav_i = 0;
    // Imposta i livelli nelle barre.
    updateBarsLevel(nav_i);

    Ctrl("bars").innerHTML = BarsBody;
    maxWidth = Math.max(maxWidth, (Ctrl("z_line").offsetLeft + 150));
    if (Ctrl("canvas").style.width.trim().length > 0) {
      maxWidth = Math.max(maxWidth, (Ctrl("v_line2").offsetLeft + 150));
    }

    var rigRulers = false;
    if (maxHeight > Ctrl("canvas").offsetHeight) {
      Ctrl("canvas").style.height = (maxHeight + 15) + "px";
      rigRulers = true;
    }
    if (maxWidth > Ctrl("canvas").offsetWidth) {
      Ctrl("canvas").style.width = (maxWidth + 15) + "px";
      rigRulers = true;
    }
    if (rigRulers == true || reorganizeBandList) {
      generateRulers(reportProp.workunit);
    }
  }

  setCanvasScroll();
  refreshArray = [];

  if (typeof(itemsHTML[index]) != "undefined" && (itemsHTML[index].id).indexOf("bar_") != 0) {
    setShadow();
  }

  resetTabs();

  if (reorganizeBandList) {
    adjustBarsWidth();
    navBands();
    resizeGadgetsPane(true);
    remapSelectCombo();
  }

  reorganizeBandList = false;

  if (reset) {
    reportProp.pageheadfoot = pagehf;
    reportProp.reportheadfoot = reporthf;
    FormProperties(true, false);
  }
  HightLight();
  setToolbarCtrlBtn();
}

/* Riscrive l'HTML e reimposta tutte le proprieta' di tutti gli items */
function writeHTMLAll(rewrite) {
  currVar = null;
  //Ctrl("canvasitems").innerHTML = "";
  Ctrl("canvasitems").empty();
  var ReportBody = Ctrl("canvasitems").innerHTML;
  var BarsBody = "";
  var maxHeight = 0, maxWidth = 0;
  queryList = [], boList = [];
  var reporthf = false, pagehf = false;
  var nav_i = 0;

  unSelectBand(lastBandSelected);
  HightlightSelectedSpaceBar(null);
  bandList = [];
  var item = null;
  updateCommonVars();
  setVline();

  var r = 0;
  for (nav_i = 0; nav_i < itemsHTML.length; nav_i++) {
    item = itemsHTML[nav_i];
    if ((item.type).indexOf("Chart") >= 0) {
      if (typeof(item.query) != "undefined" && LRTrim(item.query) != "") {
        AddToQueryList(item.query, nav_i);
      }
    }
    if (item.type == "HeaderBar_top") {
      pagehf = true;
    }
    if (item.type == "ReportBar_top") {
      reporthf = true;
    }

    if ((item.id).indexOf("bar_") == 0) {
      if (item.page == reportProp.page) {
        BarsBody += item.getHtml();
      }
      if (item.type == "AltQuery_top" && typeof(item.query) != "undefined" && LRTrim(item.query) != "") {
        AddToQueryList(item.query, nav_i);
      }
      else if (item.type == "SectBo_top" && typeof(item.busobj) != "undefined" && LRTrim(item.busobj) != "") {
        AddToBOList(item.busobj, nav_i);
      }
      if (reorganizeBandList && item.page == reportProp.page) {
        r = Round(item.y, 0);
        if (typeof(bandList[r]) != "undefined") {
          bandList[r + 1] = item;
        }
        else {
          bandList[r] = item;
        }
      }
      if (item.page == reportProp.page) {
        if (maxHeight < parseInt(item.y) + parseInt(item.h)) {
          maxHeight = parseInt(item.y) + parseInt(item.h);
        }
      }
    }
    else {
      if (item.page == reportProp.page) {
        item.show = true;
        ReportBody += item.html;
        if (maxHeight < parseInt(item.y) + parseInt(item.h)) {
          maxHeight = parseInt(item.y) + parseInt(item.h);
        }
        if (maxWidth < parseInt(item.x) + parseInt(item.w)) {
          maxWidth = parseInt(item.x) + parseInt(item.w);
        }
      }
      else {
        item.show = false;
      }
    }
  }

  //redraw band
  bandList = bandList.clean();
  nav_i = 0;
  // Imposta i livelli nelle barre.
  updateBarsLevel(nav_i);

  Ctrl("canvasitems").innerHTML = ReportBody;
  Ctrl("bars").innerHTML = BarsBody;
  maxWidth = Math.max(maxWidth, (Ctrl("z_line").offsetLeft + 150));
  if (Ctrl("canvas").style.width.trim().length > 0) {
    maxWidth = Math.max(maxWidth, (Ctrl("v_line2").offsetLeft + 150));
  }

  var rigRulers = false;
  if (maxHeight > Ctrl("canvas").offsetHeight) {
    Ctrl("canvas").style.height = (maxHeight + 15) + "px";
    rigRulers = true;
  }
  if (maxWidth > Ctrl("canvas").offsetWidth) {
    Ctrl("canvas").style.width = (maxWidth + 15) + "px";
    rigRulers = true;
  }

  for (var i = 0; i < itemsHTML.length; i++) {
    writeHTMLItemObj(itemsHTML[i]);
  }

  setCanvasScroll();

  if (rigRulers == true || reorganizeBandList) {
    generateRulers(reportProp.workunit);
  }

  if (typeof(itemsHTML[index]) != "undefined" && (itemsHTML[index].id).indexOf("bar_") != 0) {
    setShadow();
  }

  resetTabs();

  if (newload) {
    NavForm();
  }
  else {
    navBands();
  }
  newload = false;
  resizeGadgetsPane(true);
  remapSelectCombo();
  reorganizeBandList = false;

  adjustBarsWidth();

  if (rewrite) {
    reportProp.pageheadfoot = pagehf;
    reportProp.reportheadfoot = reporthf;
  }
  HightLight();
  setToolbarCtrlBtn();
}

/* updateBarsLevel viene chiamata al ridisegno delle barre.
   Si parte dal presupposto che l'array bandList sia ordinato in base alla coordinata y degli elementi di tipo barra.
   Si inizia a percorrere l'array bandList assegnando a ogni barra un livello.
   Il livello aumenta prima di ogni top, mentre diminuisce dopo ogni bottom.
   In questo modo, nel caso bandList sia in una situazione corretta, il top e il bottom della stessa barra hanno lo stesso livello.
 */
function updateBarsLevel(idx) {
  /* Ad ogni ridisegno delle barre, si devono riassegnare i valori di rHIdx e pHIdx.
     Questo perche' PageHeader/Footer e ReportHeader/Footer si possono cancellare e il riferimento deve essere aggiornato.
   */
  rHIdx = -1;
  pHIdx = -1;
  // Imposta i livelli nelle barre.
  while (idx < bandList.length) {
    setBarsLevel(idx);
    idx++;
  }
}

/*
  Page Header/Footer e Report Header/Footer hanno level uguale a 0.
  Le barre non comprese nel dettaglio del report hanno level uguale a 1.
  Le barre comprese nel dettaglio del report hanno level uguale o maggiore di 2.
  Il Page Break non ha level perche' non e' un item di tipo barra.

  Si calcola il livello dei bottom senza assegnargli di default quello del proprio top per controllare al salvataggio eventuali incroci.
 */
function setBarsLevel(idx) {
  // PageBreak e l'Autocover non sono considerati.
  if (bandList[idx].id.indexOf("break") < 0 && bandList[idx].id.indexOf("cover") < 0 & bandList[idx].id.indexOf("html") < 0) {
    // Si tratta di un'apertura
    if (bandList[idx].type.indexOf("_top") > 0) {
      /* Non si tratta di un Page Header o di un Repor Header. */
      if (bandList[idx].type.indexOf("Bar_top") < 0) {
        // Si aumenta il level prima di assegnarlo perche' cosi' top e bottom hanno lo stesso level.
        currentLevel++;
        bandList[idx].level = currentLevel;
      }
      else {
        if (bandList[idx].type.indexOf("ReportBar_top") > -1) {
          rHIdx = idx;
        }
        else {
          pHIdx = idx;
        }
        // Obbligo le barre successive a un Page Header o un Report Header ad avere livello 2 o superiore
        currentLevel = 1;
      }
    }
    // Si tratta di una chiusura
    else {
      /* Non si tratta di un Page Footer o di un Repor Footer. */
      if (bandList[idx].type.indexOf("Bar_bottom") < 0) {
        bandList[idx].level = currentLevel;
        // Si diminuisce il level dopo averlo assegnato perche' cosi' top e bottom hanno lo stesso level.
        currentLevel--;
      }
      else {
        // Obbligo le barre successive a un Page Footer o un Report Footer a partire da livello 1
        currentLevel = 1;
      }
    }
  }
  return;
}

function updateCommonVars() {
  canAlign = (formProp.hsl == "true") ? false : true; // Disabilita/Abilita le snaplines
  lockItems = (formProp["lock_items"] == "true") ? true : false; // Disabilita/Abilita il lock allo spostamento degli elementi del report
}

function setVline() {
  if (formProp.v_line > 0) {
    Ctrl("z_line").style.display = "block";
    v_line = formProp.v_line;
    Ctrl("z_line").style.left = ((formProp.v_line * (reportProp.scale / 100)) + Ctrl("canvas").offsetLeft) + "px";
    Ctrl("z_lineref").style.left = Ctrl("z_line").style.left;
  }
  else {
    v_line = formProp.v_line;
    Ctrl("z_line").style.display = "none";
  }
  Ctrl("z_lineref").style.display = Ctrl("z_line").style.display;
}

function adjustBarsWidth() {
  var maxpos = Math.max(Ctrl("v_line2").offsetLeft, Ctrl("z_line").offsetLeft) + 150;
  var prec, curr;
  var cp, c, id;
  for (var nav_i = 1; nav_i < bandList.length; nav_i++) {
    if (bandList[nav_i - 1] != undefined) {
      prec = bandList[nav_i - 1];
      curr = bandList[nav_i];
      if (Math.abs(prec.y - curr.y) < 10) {
        cp = Ctrl(prec.id);
        c = Ctrl(curr.id);
        if (cp.offsetWidth <= maxpos) {
          maxpos += 15;
        }
        else {
          maxpos = cp.offsetLeft + 15;
        }

        if (c) { c.style.width = (maxpos) + "px"; }
        c = Ctrl("info_" + curr.id);
        if (c) { c.style.width = (maxpos) + "px"; }
        c = Ctrl("c2_" + curr.id);
        if (c) { c.style.left = (maxpos) + "px"; }

        id = curr.id;
        if (id.indexOf("_start") > 0) {
          id = Strtran(id, "_start", "_end");
        }
        else {
          id = Strtran(id, "_end", "_start");
        }

        c = Ctrl(id);
        if (c) { c.style.width = (maxpos) + "px"; }
        c = Ctrl("info_" + id);
        if (c) { c.style.width = (maxpos) + "px"; }
        c = Ctrl("c2_" + id);
        if (c) { c.style.left = (maxpos) + "px"; }
      }
    }
  }
}
/* *** Fine writeHTML *** */

/* *** Load del report *** */
function reload(e, notify) {
  if (notify) {
    //notimooManager = new Notimoo({});
    notimooManager.show({
      title : 'Notification message',
      message : 'loading report ' + currentname,
      sticky : true,
      width : 200,
      height : 40
    });
  }
  startLoad();
}

function startLoad() {
  var strreload = "";
  var url, output;
  reportVariables = [];
  reportProp.attributes = [];

  // Caso isCustom a null: si deve verificare se esiste il file in versione custom e in versione standard.
  if (isCustom == null) {
    url = new JSURL("../servlet/JSPReader?type=webreport&name=" + currentname + "&check=true" + "&custom=true", true);
    output = url.Response();
    reportProp.custom = "true";
    if (LRTrim(output) != "found") {
      url = new JSURL("../servlet/JSPReader?type=webreport&name=" + currentname + "&check=true" + "&custom=false", true);
      output = url.Response();
      reportProp.custom = "false";
    }
  }
  else {
    url = new JSURL("../servlet/JSPReader?type=webreport&name=" + currentname + "&check=true" + "&custom=" + isCustom, true);
    output = url.Response();
    reportProp.custom = ((isCustom == true) ? (output == "found") + "" : "false");
  }
  if (LRTrim(output) == "found") {
    url = new JSURL("../servlet/JSPLoad?type=report&name=" + currentname + "&custom=" + reportProp.custom, true);
    Ctrl("translator").innerHTML = url.Response();
    strreload = Ctrl("translator").value;
    var def = Strtran(strreload, '\u0080', '\u20AC');
    def = Strtran(def, '\n', '');
    def = Strtran(def, '\r', '');
    reorganizeBandList = true;
    zoom(100);
    zoomindex = 2;
    forcePreviewReload = true;
    resetSearchReplace();
    return firstLoad(def);
  }
  else {
    for (var i = 0; i < notimooManager.elements.length; i++) {
      notimooManager.close(notimooManager.elements[i]);
    }
    PSAlert.alert("Report not found");
    return;
  }
}

function setLoadPic(/*status*/) {
}

function firstLoad(strreload) {
  var standard_adjustment = 7;
  var bar_adjustment = 0;
  offsetBand = 0;
  var i = 0;
  var itemAdded;

  if (LRTrim(strreload) != "") {
    pdffile = ""; // Pdf di sfondo
    maxpages = -1; // Numero di pagine del pdf di sfondo
    pdfimagesrc = "";
    pdfimagesrcbck = "";
    reportProp.pdffile = "";

    itemsHTML = [];
    countindex = 0;
    if (modenoview == false) {
      Ctrl("canvasitems").innerHTML = "";
    }

    newload = true;
    var b_reload = true;

    if (Left(strreload,1) == "[") { // Def in formato JSON
      var JsonItems = JSON.parse(strreload);
      var JsonItem;
      itemAdded = false;
      for (i = 0; i < JsonItems.length; i++) {
        JsonItem = JsonItems[i];
        type = JsonItem["type"];
        // Controlla se l'item e' Added e lo aggiunge alla toolbar e inserisce il codice del nuovo oggetto
        if (modenoview == true) {
          itemAdded = putItemNoView(null, b_reload);
        }
        else {
          itemAdded = putItem(null, b_reload); // True se ha inserito elementi, false in caso contrario
        }
        if (itemAdded) {
          switch (type) {
            case "report":
              reportProp.readJsonDef(JsonItem);
              break;
            case "Variable":
              reportVariables[reportVariables.length] = new ZTObjects.variableObj('variable' + nVar, '', 'Variable', '');
              nVar++;
              reportVariables[reportVariables.length - 1].readJsonDef(JsonItem);
              break;
            default:
              itemsHTML[countindex - 1].readJsonDef(JsonItem);
              break;
          }
        }
      }
    }
    else if (strreload.substring(0, 4) == "type") { // Def in formato |||
      strreload = Strtran(strreload, "|||||", "|| |||");
      strreload = Strtran(strreload, "||||", "|| ||");
      var itemDef, itemProperties;
      itemDef = strreload.split("|||");

      itemAdded = false;

      for (i = 0; i < itemDef.length - 1; i++) {
        itemProperties = itemDef[i].split("||");
        type = itemProperties[1];
        // Controlla se l'item e' Added e lo aggiunge alla toolbar e inserisce il codice del nuovo oggetto
        if (modenoview == true) {
          itemAdded = putItemNoView(null, b_reload);
        }
        else {
          itemAdded = putItem(null, b_reload); //true se ha inserito elementi, false in caso contrario
        }
        if (itemAdded) {
          switch (type) {
            case "Field":
              break;
            case "report":
              reportProp.readDef(itemProperties);
              break;
            case "Variable":
              reportVariables[reportVariables.length] = new ZTObjects.variableObj('variable' + nVar, '', 'Variable', '');
              nVar++;
              reportVariables[reportVariables.length - 1].readDef(itemProperties);
              break;
            default:
              itemsHTML[countindex - 1].readDef(itemProperties);
              if (reportProp.version == "4.0") {
                switch (type) {
                  case "HeaderBar_top":
                  case "HeaderBar_bottom":
                  case "ReportBar_top":
                  case "ReportBar_bottom":
                  case "Group_top":
                  case "Group_down":
                  case "Section_top":
                  case "Section_down":
                  case "AltQuery_top":
                  case "AltQuery_down":
                    itemsHTML[countindex - 1]["y"] = itemsHTML[countindex - 1]["y"] - bar_adjustment;
                    break;
                  case "BreakPage":
                    break;
                  default:
                    itemsHTML[countindex - 1]["y"] = itemsHTML[countindex - 1]["y"] - standard_adjustment;
                    break;
                }
              }
              break;
          }
        }
      }

      /* Ci possone essere bar_down con stessa posizione
         e' un tentativo di riposizionamento seguendo l'ordine dei top
         non possiamo garantire che funzioni bene sempre
         meglio rigenerare il vrp da site in questi casi. */
      if (reportProp.version == "4.0") {
        var barArray = [];
        var cc = 0;
        var obj;
        for (i = 0; i < itemsHTML.length; i++) {
          obj = itemsHTML[i];
          switch (obj["type"]) {
            case "HeaderBar_top":
            case "ReportBar_top":
            case "Group_top":
            case "Section_top":
            case "AltQuery_top":
              barArray[cc] = itemsHTML[i];
              barArray[cc].name = ZeroPad("" + i, 9) + "_" + barArray[cc].name;
              itemsHTML[i] = itemsHTML[cc];
              itemsHTML[cc] = barArray[cc];
              cc++;
              break;
            case "HeaderBar_bottom":
            case "ReportBar_bottom":
            case "Group_down":
            case "Section_down":
            case "AltQuery_down":
              barArray[cc] = itemsHTML[i];
              barArray[cc].name = ZeroPad("" + (i - 1), 9) + "_" + barArray[cc].name;
              itemsHTML[i] = itemsHTML[cc];
              itemsHTML[cc] = barArray[cc];
              cc++;
              break;
          }
        }

        barArray.sort(sortGName);
        for (i = 0; i < barArray.length; i++) {
          obj = barArray[i];
          if (obj) {
            obj["name"] = obj["name"].substr(10);
            itemsHTML[i] = obj;
          }
        }

        //adjustare l'altezza di tutti gli elementi di nuovo con le barre prima
        itemsHTML.sort(sortG);
        var barbefore = 0;
        var barsc, out, yy, objx;
        for (i = 0; i < itemsHTML.length; i++) {
          obj = itemsHTML[i];
          obj["y"] = obj["y"] + barbefore;
          switch (obj["type"]) {
            case "HeaderBar_top":
            case "HeaderBar_bottom":
            case "ReportBar_top":
            case "ReportBar_bottom":
            case "Group_top":
            case "Group_down":
            case "Section_top":
            case "Section_down":
            case "AltQuery_top":
            case "AltQuery_down":
              barbefore = barbefore + 1;
              break;
            case "BreakPage":
              break;
            default: //bars after y and before y+h
              barsc = 0;
              out = false;
              yy = obj["y"] + obj["h"] - barbefore;
              for (var j = i; j < itemsHTML.length && (out == false); j++) {
                objx = itemsHTML[j];
                switch (objx["type"]) {
                  case "HeaderBar_top":
                  case "HeaderBar_bottom":
                  case "ReportBar_top":
                  case "ReportBar_bottom":
                  case "Group_top":
                  case "Group_down":
                  case "Section_top":
                  case "Section_down":
                  case "AltQuery_top":
                  case "AltQuery_down":
                    if (objx["y"] <= yy) {
                      barsc = barsc + 1;
                    }
                    else {
                      out = true;
                    }
                    break;
                }
              }
              obj["h"] = obj["h"] + barsc;
              break;
          }
        }
      }
      }
    itemsHTML = resort();

    var tmpComment = "", tmpName = "";
    for (i = 0; i < itemsHTML.length; i++) {
      // if (reportProp.version < "4.2") {
        /* Nelle implementazioni precedenti del report, non veniva riportato l'uid del gruppo nelle proprieta' calculate_on e reset_on delle espressioni.
           Quindi, i valori di quelle proprieta' deve essere calcolato.
         */
        // if (itemsHTML[i].type == "Expr") {
          // if (itemsHTML[i].calculate_on != "each record" && itemsHTML[i].calculate_on != "end of report") {
            // itemsHTML[i].calculate_onuid = getGroupUid(itemsHTML[i].calculate_on);
          // }
          // if (itemsHTML[i].reset != "end of page" && itemsHTML[i].reset != "end of report") {
            // itemsHTML[i].resetuid = getGroupUid(itemsHTML[i].reset);
          // }
        // }
      // }
      if (reportProp.version < "4.2") {
        if (itemsHTML[i].type == "Box") {
          if (itemsHTML[i].w == 1) {
            itemsHTML[i].w = 0;
          }
          if (itemsHTML[i].h == 1) {
            itemsHTML[i].h = 0;
          }
        }
      }
      if (reportProp.version == "4.1") {
        /* Nel caso di report salvati con SitePainter, si deve verificare la sequence nel caso di barre sovrapposte per evitare errori al salvataggio del report.
           Puo' capitare che vi siano degli header con sequence maggiore della sequence del rispettivo footer.
         */
        if (itemsHTML[i].id.indexOf("bar_") == 0) {
          if (itemsHTML[itemsHTML[i].child]) {
            checkBarSequence(itemsHTML[i], itemsHTML[itemsHTML[i].child]);
          }
        }
      }
      if (itemsHTML[i].id.indexOf("bar_") == 0) {
        if (itemsHTML[i].id.indexOf("_Page") < 0 || itemsHTML[i].id.indexOf("_Report") < 0) {
          if (Empty(itemsHTML[i].comment)) {
            itemsHTML[i].comment = itemsHTML[i].name;
          }
          else if (reportProp.version < "4.4" && itemsHTML[i].comment != itemsHTML[i].name) {
          /* Nel caso di report salvati nel periodo dal 17/07/2012 al 07/09/2012,
             il comment delle barre sara' diverso dal name anche quando l'utente non ha scritto nulla in comment.
             Il seguente codice risolve quel problema.
           */
            tmpComment = itemsHTML[i].comment.replace(/[0-9]/g, '');
            tmpName = itemsHTML[i].name.replace(/[0-9]/g, '');
            if (tmpComment == tmpName) {
              itemsHTML[i].comment = itemsHTML[i].name;
            }
          }
          /* Nelle versioni del report precedenti la 4.3 (introduzione delle funzioni che effettuano il bringback del valore delle proprieta' dal top al down delle barre)
             era possibile avere nel report i down con proprieta' con valore diverso dal top.
             Il seguente codice dovrebbe evitare il problema.
          */
          if (reportProp.version < "4.3" || modenoview == true) {
            switch(itemsHTML[i].type) {
              case "Group_top":
                checkBarProperty(i, "comment", itemsHTML[i].comment);
                checkBarProperty(i, "exp", itemsHTML[i].exp);
                checkBarProperty(i, "output_name", itemsHTML[i].output_name);
                checkBarProperty(i, "start_each_on_page", itemsHTML[i].start_each_on_page);
                checkBarProperty(i, "as_page_header", itemsHTML[i].as_page_header);
                checkBarProperty(i, "print_group_footer", itemsHTML[i].print_group_footer);
                checkBarProperty(i, "as_page_footer", itemsHTML[i].as_page_footer);
                checkBarProperty(i, "reprint_header", itemsHTML[i].reprint_header);
                checkBarProperty(i, "reprint_footer", itemsHTML[i].reprint_footer);
                checkBarProperty(i, "printblock", itemsHTML[i].printblock);
                checkBarProperty(i, "rows", itemsHTML[i].rows);
                checkBarProperty(i, "reset_page_number", itemsHTML[i].reset_page_number);
                checkBarProperty(i, "numpage_expr", itemsHTML[i].numpage_expr);
                checkBarProperty(i, "ingroup_expr", itemsHTML[i].ingroup_expr);
                checkBarProperty(i, "outgroup_expr", itemsHTML[i].outgroup_expr);
                break;
              case "Section_top":
                checkBarProperty(i, "comment", itemsHTML[i].comment);
                checkBarProperty(i, "hidecond", itemsHTML[i].hidecond);
                break;
              case "AltQuery_top":
                checkBarProperty(i, "comment", itemsHTML[i].comment);
                checkBarProperty(i, "query", itemsHTML[i].query);
                checkBarProperty(i, "exp", itemsHTML[i].exp);
                checkBarProperty(i, "output_name", itemsHTML[i].output_name);
                break;
              case "SectBo_top":
                checkBarProperty(i, "comment", itemsHTML[i].comment);
                checkBarProperty(i, "busobj", itemsHTML[i].busobj);
                checkBarProperty(i, "output_name", itemsHTML[i].output_name);
                checkBarProperty(i, "ischild", itemsHTML[i].ischild);
                checkBarProperty(i, "value_key", itemsHTML[i].value_key);
                checkBarProperty(i, "value_expr", itemsHTML[i].value_expr);
                break;
            }
          }
        }
      }
    }

    if (reportProp.workunit == "pt") {
      reportProp.workunit = "px";
    }

    nAllItems = Math.max(itemsHTML.length, (nitem + nbaritem));
    nAllItems = Math.max(nAllItems, parseInt(reportProp.maxcount));
    nbaritem = nAllItems + 1;
    nitem = nAllItems + 1;

    if (modenoview == false) {
      if (LRTrim(reportProp.pdffile).length > 0) {
        LoadPdfz(reportProp.pdffile);
      }
      else {
        initCanvas();
      }
      index = null;
      reorganizeBandList = true;
      writeHTML(true);
    }
  }
  else if (LRTrim(strreload) == "") {
    if (modenoview == false) {
      PSAlert.alert("User not logged");
    }
  }
  else {
    if (modenoview == false) {
      PSAlert.alert("Error loading the report");
    }
  }

  if (modenoview == false) {
    for (i = 0; i < notimooManager.elements.length; i++) {
      notimooManager.close(notimooManager.elements[i]);
    }
    notimooManager.show({
      title : 'Notification message',
      message : 'report loaded!',
      visibleTime : 1000,
      width : 200
    });
  }
  if (gadgetload == false && modenoview == false) {
    create_gadget_pane();
    gadgetload = true;
  }
  type = null;

  if (modenoview == false) {
    remapIntoVariableCombo();
  }
  indexUndo = -1;
  indexRedo = -1;
  undoItemsMoved = [];
  undoSequence = [];
}

function getGroupUid(groupexp) {
  if (LRTrim(groupexp) != "") {
    for (var i = 0; i < bandList.length; i++) {
      if (bandList[i].type.indexOf("Group_") > -1 && bandList[i].exp == groupexp) {
        return bandList[i].uid;
      }
    }
  }
  return "";
}

function getGroupExpr(groupuid) {
  if (LRTrim(groupuid) != "") {
    for (var i = 0; i < bandList.length; i++) {
      if (bandList[i].type.indexOf("Group_top") > -1 && bandList[i].uid == groupuid) {
        return bandList[i].exp;
      }
    }
  }
  return "";
}

function reload_(e, strreload, paste) {
  pasted = [];
  if (!paste) {
    offsetBand = 0;
  }

  /* action serve per sapere quale operazione sta causando la reload_.
     E' stata inserita per ottimizzare il codice:
     * al momento dell'incolla di un elemento tagliato,
     * al momento della copia ed evitare di ciclare su tutti gli elementi del report per cercare elementi con lo stesso uid.
  */
  var action = "";
  var JsonItems;

  if (strreload != null && strreload != {}) {
    // Si toglie action dall'inizio di strreload.
    action = strreload["action"];
    JsonItems = strreload["elements"];
    // Si toglie cut||| o copy||| dall'inizio di strreload per non modificare il codice successivo.

    if (JsonItems.length > 0) {
      if (!paste) {
        itemsHTML = [];
        nitem = 0;
        countindex = 0;
      }
      var b_reload = true;
      var propName, valueToLoad, tmpType;
      var JsonItem;
      for (i = 0; i < JsonItems.length; i++) {
        JsonItem = JsonItems[i];
        type = JsonItem["type"];
        tmpType = "";

        if (type.indexOf("_") > -1) {
          tmpType = type.substring(0, type.indexOf("_"));
        }

        e = (e) ? e : window.event;
        if (type == "Group_top") {
          if (!checkAddGroup(e, paste)) {
            return false;
          }
        }
        if (type == "BreakPage") {
          if (!checkAddPageBreak(e, paste)) {
            return false;
          }
        }
        if (type == "AltQuery_top" || type == "SectBo_top") {
          checkAddDataSection(e);
        }

        putItem(e, b_reload);

        if (!paste) {
          switch (type) {
            case "report":
              reportProp.readDef(JsonItem);
              break;
            case "Variable":
              reportVariables[reportVariables.length] = new ZTObjects.variableObj('variable' + nVar, '', 'Variable', '');
              nVar++;
              reportVariables[reportVariables.length - 1].readDef(JsonItem);
              break;
            case "Field":
              break;
            default:
              itemsHTML[countindex - 1].readDef(JsonItem);
              break;
          }
          continue;
        }
        else {
          if (paste && type != "Field") {
            propName = "", valueToLoad = "";
            for (propName in JsonItem) {
              valueToLoad = JsonItem[propName];

              switch (propName) {
                case "x":
                case "y":
                  if (itemsHTML[countindex - 1].id.indexOf("bar_") > -1) {
                    valueToLoad = parseInt(valueToLoad);
                  }
                  else {
                    valueToLoad = (parseInt(valueToLoad) + 10) * scale / pasteProperties.copyscale;
                  }
                  if (valueToLoad < 0) {
                    PSAlert.alert("Attention: item " + itemsHTML[countindex - 1]["name"] + " with position " + propName + " < 0!");
                    valueToLoad = 0;
                  }
                  break;
                case "name":
                case "comment":
                  if (action == "copy") {
                    for (var bb = 0; bb < itemsHTML.length; bb++) {
                      if (itemsHTML[bb][propName] == valueToLoad) {
                        // Item di tipo non barra
                        if (itemsHTML[countindex - 1].id.indexOf("bar_") < 0) {
                          valueToLoad += "_" + nAllItems;
                        }
                        else {
                          // Item di tipo barra
                          if (type.indexOf("_down") < 0 && itemsHTML[bb].type == tmpType + "_top") {
                            // Si tratta di un top
                            valueToLoad += "_" + nAllItems;
                          }
                          else {
                            if (type.indexOf("_down") > -1 && itemsHTML[bb].type == tmpType + "_top") {
                              // Si tratta di un down
                              valueToLoad = itemsHTML[itemsHTML[countindex - 1].child][propName];
                            }
                          }
                        }
                      }
                    }
                  }
                  break;
                case "uid":
                  /* Nel caso di copia di un elemento, l'uid deve essere sempre cambiato. */
                  if (action == "copy") {
                    valueToLoad = Upper(AlfaKeyGen(10));
                  }
                  pasted[pasted.length] = countindex - 1;
                  refreshArray[refreshArray.length] = itemsHTML[countindex - 1];
                  break;
                case "w":
                case "h":
                  if (itemsHTML[countindex - 1].id.indexOf("bar_") < 0) {
                    if (parseInt(valueToLoad) < 0) {
                      PSAlert.alert("Attention: item " + itemsHTML[countindex - 1]["name"] + " with dimension " + propName + " < 0!");
                      valueToLoad = 0;
                    }
                    else {
                      valueToLoad = parseInt(valueToLoad) * scale / pasteProperties.copyscale;
                    }
                  }
                  break;
                case "page":
                  valueToLoad = reportProp.page;
                  break;
                case "privacy":
                case "data_danger_level":
                case "identifier":
                  reportProp.contentprivacy++;
                  break;
              }
              itemsHTML[countindex - 1][propName] = valueToLoad;
            }
          }
        }
      }

      if (paste && pasteProperties.pastebar) {
        removeAllHandlers();
        index = null;
      }
      else {
        removeAllHandlers();
        writeHTML();
        var c, str;
        //select paste objects
        for (var i = 0; i < pasted.length; i++) {
          c = pasted[i];
          index = c;
          itemsHTML[c].shadow = "shadow" + itemsHTML[c].id.substr(4);
          str = addHandlers(itemsHTML[c].id.substr(4));
          Ctrl("canvashandlers").innerHTML += str;
          //selectItem(Ctrl("shadow" + itemsHTML[c].id.substr(4)));
          selectItem(Ctrl(itemsHTML[c].shadow));
        }
      }
      return true;
    }
  }
  else if (strreload == {}) {
    PSAlert.alert("User not logged");
    return false;
  }
  else {
    PSAlert.alert("Error loading the report");
    return false;
  }
}

function sortId(a, b) {
  var sa_id = Strtran(a.id, "_end", "");
  sa_id = Strtran(sa_id, "_start", "");
  var sb_id = Strtran(b.id, "_end", "");
  sb_id = Strtran(sb_id, "_start", "");
  if (sa_id > sb_id) { return 1; }
  else if (sa_id < sb_id) { return -1; }
  else {
    if (a.id > b.id) { return -1; }
    if (a.id < b.id) { return 1; }
    return 0;
  }
}

function sortGName(a, b) {
  if (a.id.indexOf("_end") > 0 || b.id.indexOf("_end") > 0) {
    if (a.y == b.y && (a.id.indexOf("_end") > 0 && b.id.indexOf("_end") > 0)) {
      if (a.name > b.name) return -1;
      if (a.name < b.name) return 1;
      return 0;
    }
    if (a.y == b.y && (a.id.indexOf("_end") > 0 || b.id.indexOf("_end") > 0)) {
      return 0;
    }
    if (a.id.indexOf("_start") > 0 || b.id.indexOf("_start") == 0) {
      return 0;
    }
    return 1;
  }
  return 0;
}

function sortG(a, b) {
  if (parseInt(a.y) > parseInt(b.y)) { return 1; }
  if (parseInt(a.y) < parseInt(b.y)) { return -1; }
  return 0;
}

function sortY(a, b) {
  //if (a.id.indexOf("bar_") == 0 || b.id.indexOf("bar_") == 0) { return 0; }
  if (parseInt(a.y) > parseInt(b.y)) { return 1; }
  if (parseInt(a.y) < parseInt(b.y)) { return -1; }
  return 0;
}

function sortX(a, b) {
  //if (a.id.indexOf("bar_") == 0 || b.id.indexOf("bar_") == 0) { return 0; }
  if (parseInt(a.x) > parseInt(b.x)) { return 1; }
  if (parseInt(a.x) < parseInt(b.x)) { return -1; }
  return 0;
}

/* Verifica la sequence di header e footer collegati.*/
function checkBarSequence(a, b) {
  /* Devo verificare solo il caso di un header e footer dello stesso tipo e con lo stesso nome sovrapposti. */
  if (a.name != b.name) { return; }
  if (a.name == b.name) {
    if (parseInt(a.y) > parseInt(b.y)) { return; }
    if (parseInt(a.y) < parseInt(b.y)) { return; }
    if (parseInt(a.y) == parseInt(b.y)) {
      var tmpSeq, tmpBBSeq;
      if (a.id.indexOf("_start") > 0) {
        /* Se la sequence dell'header e' successiva a quella del footer, devo invertire gli elementi.*/
        if (parseInt(a.sequence) > parseInt(b.sequence)) {
          tmpSeq = b.sequence;
          tmpBBSeq = b.bb_sequence;
          b.sequence = a.sequence;
          b.bb_sequence = a.bb_sequence;
          a.sequence = tmpSeq;
          a.bb_sequence = tmpBBSeq;
        }
      }
    }
  }
  return;
}

/* Verifica che le proprieta' del down della barra abbia lo stesso valore del top. */
function checkBarProperty(idx, prop, value) {
  if (idx != null && itemsHTML[itemsHTML[idx].child] != null) {
    if (itemsHTML[itemsHTML[idx].child][prop] != value) {
      itemsHTML[itemsHTML[idx].child][prop] = value;
    }
  }
}

/* *** Fine Load del report *** */

/* *** Gestione apertura del report *** */
function openReport() {
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
  var url = "../portalstudio/open.jsp?tool=report&onetool=true&SPModalLayerId=openSPModalLayer";
    openSPModalLayer(url, 40, 20, 800, 600, true, 1, false);
}
/* *** Fine Gestione apertura del report *** */

/* *** Gestione creazione nuovo report *** */
function newdesign() {
  if ((m_bUpdated2 || m_bUpdated)) {
    if (confirm("Do you want to save " + currentname + "?")) {
      save(function () {
        newdesignz();
      });
      return;
    }
  }
  m_bUpdated2 = false;
  newdesignz();
}

function newCurrentObj(name, type, parms) {
  var oldname = currentname;
  if (parms && parms.custom && typeof parms.custom == "string") {
    parms.custom = parms.custom == "true" ? true : false;
  }
  isCustom = parms && parms.custom;
  var id = name;
  currentname = id;
  reload(null, true);
  document.title = currentname + " - Report Editor";
  m_bUpdated2 = false;
  if (Ctrl("srcform")) {
    Ctrl("srcform").value = currentname;
  }
  if (window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    var curr = null;
    for (var i = 0; i < window.parent.opensApl.length; i++) {
      if (window.parent.opensApl[i] != null && oldname != "" && oldname == window.parent.opensApl[i].name && window.parent.opensApl[i].src.contains("../reporteditor/index.jsp")) {
        curr = i;
        break;
      }
    }
    if (curr == null) {
      window.parent.changeName(id, {
        custom : isCustom
      });
    }
    else {
      window.parent.changeName2(id, {
        custom : isCustom
      }, curr);
    }
  }
  FormProperties(true, false);
}

function newdesignz() {
  resetGeneric();
  zoom(scale);
  currentname = "";
  removeAllHandlers();
  Ctrl("canvasitems").innerHTML = "";
  Ctrl("bars").innerHTML = "";
  Ctrl("backcanvas").scrollTop = 0;
  Ctrl("backcanvas").scrollLeft = 0;
  pdffile = "";
  maxpages = -1;
  pdfimagesrc = "";
  pdfimagesrcbck = "";
  setCanvasScroll();
  doLoad(null);
  m_bUpdated = true;
  forcePreviewReload = true;
}

function resetGeneric() {
  index = null;
  if (modenoview == false) { resetSearchReplace(); }
  itemsHTML = []; //array contenente tutti gli oggetti item con id ,HTML,shadow,ecc
  zoomindex = 2;
  nAllItems = 0;
  nBarItems = 0;
  countindex = 0;
  nitem = 0;
  nbaritem = 0;
  // array per navigator
  queryList = [];
  bandList = [];
  boList = [];
  // Aggiunta o rimossa una barra (serve ad ottimizzare l'array bandList)
  reorganizeBandList = true;
  reportProp = new ZTObjects.reportObj();
  reportProp.scale = scale;
  forcePreviewReload = false;
  m_bUpdated2 = false;
  m_bUpdated = false;
  scale = 100;
  if (modenoview == false) { zoom(scale); }
}
/* *** Fine Gestione creazione nuovo report *** */

/* *** Gestione Wizard *** */
function wizard() {
  if ((m_bUpdated2 || m_bUpdated)) {
    if (confirm("Do you want to save " + currentname + "?")) {
      save(function () {
        loadWizard();
      });
      return;
    }
  }
  m_bUpdated2 = false;
  loadWizard();
}

function loadWizard() {
  xpos = 0;
  ypos = 0;
  var url = "../jsp-system/SPWebReportWizard_portlet.jsp";
  var additionalUrl = "";
  openNewWindow(url, additionalUrl, 600, 900, xpos, ypos, "Wizard");
}
/* *** Fine Gestione Wizard *** */

/* *** Gestione del Pdf di sfondo *** */
function LoadPdf() {
  xpos = 0;
  ypos = 0;
  var url = "../portalstudio/openfile.jsp?tool=pdf&toolenable=false";
  var additionalUrl = "&Modules";
  openNewWindow(url, additionalUrl, 600, 620, xpos, ypos, "Modules");
}

function setFile(file) {
  pdffile = file;
  var pdfProperties;
  var url = new JSURL("../servlet/IcePdfNumberOfPages?file=" + file, true);
  maxpages = -1;
  dwidth = -1;
  dheight = -1;
  try {
    pdfProperties = JSON.parse(url.Response());
  }
  catch (e) {
    PSAlert.alert("Error on loading pdf file '" + file + "'");
  }
  if (!pdfProperties.error) {
    maxpages = parseInt(pdfProperties.numPages);
    dwidth = parseInt(pdfProperties.pageWidth) * 96 / 72;
    dheight = parseInt(pdfProperties.pageHeight) * 96 / 72;
    isSecureDoc = parseInt(pdfProperties.hasSecurity);
    if (maxpages <= 0) {
      PSAlert.alert("Error on loading pdf file '" + file + "'");
      return;
    }
    maxpages = 1;
  }
  else {
    PSAlert.alert("Error on loading pdf file '" + file + "'");
  }
}

function LoadPdfz(url, imgnew, zdwidth/*, zdheight*/) {
  url = LRTrim(url);
  url = unescape(url);
  url = url.replace(/[\\]/gi, '/');
  url = url.replace('//', '/');
  setFile(url);
  reportProp.pdffile = pdffile;
  removeAllHandlers();
  InsertIcePdf(imgnew, 0, 0);
  FormProperties();
  if (typeof(zdwidth) != "undefined") {
  }
  else {
    setzoom();
  }
  forcePreviewReload = true;
}

function InsertIcePdf(/*imgnew, w, h*/) {
  pdfimagesrc = "";
  pdfimagesrcbck = "";
  var page0, urlx, src;
  for (var i = 1; i <= maxpages; i++) {
    page0 = i;
    urlx = new JSURL("../servlet/IcePdfRenderer?file=" + pdffile + "&page=" + page0 + "&scale=" + reportProp.scale + "&maxpages=" + maxpages, true);
    var output = urlx.Response();
    if (output != "Error") {
      if (reportProp.scale > 601) {
        src = output + "_" + "7" + "_" + page0 + ".png";
      }
      else if (reportProp.scale > 301) {
        src = output + "_" + "5" + "_" + page0 + ".png";
      }
      else {
        src = output + "_" + page0 + ".png";
      }
      pdfimagesrc = src;
      pdfimagesrcbck = src;
    }
    else {
      PSAlert.alert(errMsg + pdffile + "'");
    }
  }
  initCanvas(true);
  writeHTML(true);
}
/* *** Fine Gestione del Pdf di sfondo *** */

/* *** Gestione della selezione degli item *** */

// seleziona l'item se cliccato
function clickItem(e, elementid) {
  multipleSelection = false;
  removeClassFromElement("selected_var");

  function selectedin(e, elementid) {
    if (e != null && e.shiftKey == false) {
      index = null;
      selectForm();
    }
    if (e == null || e.shiftKey == false) {
      removeAllHandlers();
    }
    if (Ctrl("shadow" + elementid.substr(4))) {
      return;
    }
    for (var i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].id == elementid) {
        index = i;
        itemsHTML[i].shadow = "shadow" + elementid.substr(4);
        i = itemsHTML.length;
      }
    }
    str = addHandlers(elementid.substr(4));
    Ctrl("canvashandlers").innerHTML += str;
    selectItem(Ctrl("shadow" + elementid.substr(4)));
  }

  if (!Empty(elementid)) {
    selectedin(e, elementid);
    return;
  }

  var str = "";
  var element = GetEventSrcElement(e);
  SetOnEditProp(false);
  if (element.id != "") {
    var primaryId = "";
    primaryId = Strtran(element.id, "_int", "");
    primaryId = Strtran(primaryId, "_cont", "");
    element = Ctrl(primaryId);
  }
  if (!element.id) {
    while (element.parentNode && element.parentNode.id == "") {
      element = element.parentNode;
    }
    element = element.parentNode;
  }
  //20130522
  if (e != null) {
    var k;
    calcPosition(e); //Calcola xpos, ypos
    xpos = xpos + Ctrl("backcanvas").offsetLeft - Ctrl("backcanvas").scrollLeft;
    ypos = ypos + Ctrl("backcanvas").offsetTop - Ctrl("backcanvas").scrollTop;
    var elementContained = document.elementFromPoint(xpos, ypos);
    var elementsInsideArea = [];
    var selectableElementsInsideArea = [];
    while (elementContained && elementContained.id != "canvas") {
      elementsInsideArea[elementsInsideArea.length] = elementContained;
      elementContained.style.display = "none";
      elementContained = document.elementFromPoint(xpos, ypos);
    }
    xpos = xpos - Ctrl("backcanvas").offsetLeft + Ctrl("backcanvas").scrollLeft;
    ypos = ypos - Ctrl("backcanvas").offsetTop + Ctrl("backcanvas").scrollTop;
    for (k = 0; k < elementsInsideArea.length; k++) {
      elementsInsideArea[k].style.display = "block";
      if (elementsInsideArea[k].id.length > 0 && elementsInsideArea[k].id.indexOf("_cont") < 0 && elementsInsideArea[k].id.indexOf("_int") < 0) {
        selectableElementsInsideArea[selectableElementsInsideArea.length] = elementsInsideArea[k];
      }
    }
    if (selectableElementsInsideArea.length > 1) {
      var mselect = selectableElementsInsideArea[0];
      for (k = 1; k < selectableElementsInsideArea.length; k++) {
        if (isObjFullOnObj(selectableElementsInsideArea[k], mselect)) {
          mselect = selectableElementsInsideArea[k];
        }
      }
      if (element.id != mselect.id) {
        var bgc = element.style.backgroundColor;
        var bgi = element.style.backgroundImage;
        var elt = element.nodeName;
        var askConfirm = false;
        var askChange = true;
        if (bgc != "transparent" && bgc.length > 0) { askConfirm = true; }
        else if (bgi.length > 0) { askConfirm = true; }
        else if (elt.toLowerCase() == "img") { askConfirm = true; }
        if (askConfirm) {askChange = confirm("At this position, there is a hidden element. Select it?"); }
        if (askChange) { element = mselect; }
      }
    }
  }
  selectedin(e, element.id);
}

function editItemEvent(/*e,obje*/) { //double-click
}

function isObjFullOnObj(a,b) {
  var a_left = a.offsetLeft;
  var a_right = a.offsetLeft + a.offsetWidth;
  var b_left = b.offsetLeft;
  var b_right = b.offsetLeft + b.offsetWidth;

  var a_top = a.offsetTop;
  var a_bottom = a.offsetTop + a.offsetHeight;
  var b_top = b.offsetTop;
  var b_bottom = b.offsetTop + b.offsetHeight;

  if (b_left > a_right || b_right < a_left) { return false; } //overlap not possible
  if (b_top > a_bottom || b_bottom < a_top) { return false; } //overlap not possible

  if (b_left < a_left && a_right < b_right && b_top < a_top && a_bottom < b_bottom) { return true; }
  return false;
}

function selectItemBar(itm) {
  removeClassFromElement("selected_var");
  var i;
  mainitem = itm;
  // trova l'indice del mainitem
  for (i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow == mainitem.id) {
      index = i;
    }
  }
  Properties();
}

function selectItem3(objid, objtype, removeHandler, propobj) {
  removeClassFromElement("selected_var");
  var vobj, i;
  if (objtype == "Variable") {
    for (i = 0; i < reportVariables.length && !vobj; i++) {
      if (reportVariables[i].id == objid) {
        vobj = reportVariables[i];
      }
    }

    if (vobj) {
      editVariable(vobj);
    }
    else {
      PSAlert.alert("Variable not found!!!");
    }
  }
  else {
    for (i = 0; i < itemsHTML.length && !vobj; i++) {
      if (itemsHTML[i].id == objid) {
        vobj = itemsHTML[i];
      }
    }

    if (!vobj) {
      PSAlert.alert("Item not found!!!");
      return;
    }
    if (tabs) {
      selectReportPage(parseInt(vobj.page));
      tabs.setSelectedTab(reportProp.page);
    }
    else {
      selectReportPage(parseInt(vobj.page));
    }
    selectItem2(vobj, removeHandler);

    if (propobj && propobj.tab && propobj.prop) {
      document.id(propobj.tab + '_tab').fireEvent('click');
      document.id(propobj.tab + '_' + propobj.prop).focus();
    }
  }
}

function selectItem2(obj, removeHandler) {
  removeClassFromElement("selected_var");
  var str = "";
  SetOnEditProp(false);
  if (removeHandler) {
    index = null;
    selectForm();
  }
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].id == obj.id) {
      index = i;
      itemsHTML[i].shadow = "shadow" + obj.id.substr(4);
      if (itemsHTML[i].id.indexOf("bar_") != 0) {
        str = addHandlers(obj.id.substr(4));
      }
    }
  }

  if (str.length > 0) {
    Ctrl("canvashandlers").innerHTML += str;
    selectItemBar(Ctrl("shadow" + obj.id.substr(4)));
  }
  else if (index != null) {
    if (itemsHTML[index].id.indexOf("bar_") == 0 && itemsHTML[index].id.indexOf("break") < 0 && itemsHTML[index].id.indexOf("cover") < 0 && itemsHTML[index].id.indexOf("html") < 0) {
      if (itemsHTML[index].type.indexOf("_down") > 0) {
        clickBand(itemsHTML[itemsHTML[index].child].id);
      }
      else {
        clickBand(itemsHTML[index].id);
      }
    }
    else if (itemsHTML[index].id.indexOf("bar_") == 0 && (itemsHTML[index].id.indexOf("break") >= 0 || itemsHTML[index].id.indexOf("cover") >= 0 || itemsHTML[index].id.indexOf("html") >= 0)) {
      clickBand(itemsHTML[index].id);
    }
    mainitem = itemsHTML[index];
  }
}

function removeAllBarHandlers() {
  // svuota l'array contenente gli elementi/barre selezionati precedentemente
  index = null;
  mainitem = null;
  for (var i = 0; i < bandList.length; i++) {
    if (bandList[i].id.indexOf("bar_") >= 0) {
      bandList[i].shadow = "";
    }
  }
  if (!Empty(newPropObj)) {
    newPropObj.HideProperties();
  }
}

function removeAllHandlers() {
  // svuota l'array contenente gli elementi selezionati precedentemente
  index = null;
  mainitem = null;
  for (var i = 0; i < itemsHTML.length; i++) {
    itemsHTML[i].shadow = "";
  }
  Ctrl("canvashandlers").innerHTML = "";
  unSelectBand(lastBandSelected);
  HightlightSelectedSpaceBar(null);
  if (!Empty(newPropObj)) {
    newPropObj.HideProperties();
  }
}
/* *** Fine Gestione della selezione degli item *** */

/* *** Gestione AddItems *** */
var xxpos; // for insert image dialog
var yypos;
var xpos = 0;
var ypos = 0;

/* Inserisce il Page Header/Footer in un nuovo report */
function PutMainBars() {
  if (reportProp.page == 1) {
    type = "HeaderBar_top";
    ypos = 25;
    putItem(null, true);
    itemsHTML[countindex - 1].y = 25;

    type = "HeaderBar_bottom";
    ypos = 250;
    putItem(null, true);
    itemsHTML[countindex - 1].y = 250;

    type = null;
  }
}

/* Funzioni di inserimento nuovo item */
function checkCanAdd(barObj) {
  // Non e' possibile inserire Group, AlternateQuery o Section Bo nella pagina di copertina
  if (reportProp.page == 0 && (barObj["type"] == "Group_top" || barObj["type"] == "AltQuery_top" || barObj["type"] == "SectBo_top")) {
    PSAlert.alert("Cannot add this kind of item on report cover");
    return false;
  }
  // Non e' possibile inserire due Autocover nella pagina di copertina
  else if (reportProp.page == 0 && (barObj["type"] == "AutoCover") && checkCoverLinePresence()) {
    PSAlert.alert("Cannot add more than one autocover in cover");
    return false;
  }
  // Non e' possibile inserire l'Autocover se non nella pagina di copertina
  if (reportProp.page == 1 && (barObj["type"] == "AutoCover")) {
    PSAlert.alert("Cannot add this kind of item on report");
    return false;
  }
  return true;
}

function addItem(item) {
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

  if (!checkCanAdd(type)) {
    document.body.style.cursor = "default";
    Ctrl("canvas").onmousedown = null;
    type = null;
    return;
  }
  selectForm();
  if (evtType == "drag") {
    addItem2(arguments[0]);
  }
  else {
    document.body.style.cursor = "crosshair";
    Ctrl("canvas").onmousedown = addItem2;
  }
}

function addItem2(e, b_reload) {
  if (type != null) {
    if (!checkCanAdd(type)) {
      document.body.style.cursor = "default";
      Ctrl("canvas").onmousedown = null;
      type = null;
      return;
    }
    undoItemsMoved = [];
    if (type == "Group_top") {
      if (!checkAddGroup(e)) {
        document.body.style.cursor = "default";
        Ctrl("canvas").onmousedown = null;
        type = null;
        return;
      }
    }
    if (type == "BreakPage") {
      if (!checkAddPageBreak(e)) {
        document.body.style.cursor = "default";
        Ctrl("canvas").onmousedown = null;
        type = null;
        return;
      }
    }
    if (type == "AltQuery_top" || type == "SectBo_top") {
      checkAddDataSection(e);
    }
    putItem(e, b_reload);
    putBarDown(e);
    type = null;
    insertIntoUndoSequence();
    removeClassFromElement("selected_var");
    cancelEvent(e);
  }
}

function removeClassFromElement(cname) {
  var mctrls = document.getElementsByClassName("selected_var");
  for (var i=0; i<mctrls.length; i++) {
    $(mctrls[i].id).removeClass(cname);
  }
}

/* Utilizzata per calcolare la posizione del Report Footer o del PageFooter, aggiunti selezionando il check in Report Properties */
function seekLastY() {
  var lastY = 0;
  var pos = 0;
  for (var i = 0; i < itemsHTML.length; i++) {
    pos = parseInt(itemsHTML[i].y) + parseInt(itemsHTML[i].h);
    if (pos > lastY) {
      lastY = pos;
    }
  }
  return lastY;
}

function calcPosition(e) {
  if (!e) { e = window.event; }
  if (e != null) {
    xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
    if (document.all) {
      xpos += window.pageXOffset;
      ypos += window.pageYOffset;
    }
    xpos = xpos - Ctrl("backcanvas").offsetLeft + Ctrl("backcanvas").scrollLeft;
    ypos = ypos - Ctrl("backcanvas").offsetTop + Ctrl("backcanvas").scrollTop;
  }
}

function putItem(e/*, b_reload*/) {
  calcPosition(e);
  var divContainer = document.createElement("div");
  switch (type) {
    case "report":
      return true;
      break;
    case "Variable":
      return true;
      break;
    case "Box":
    case "VLine":
    case "HLine":
      var wh = 120;
      var hw = 120;
      var bgc = "transparent";
      var bdw = "1";
      if (type == "VLine") {
        wh = 0;
        bgc = "#000000";
        bdw = "1";
      }
      else if (type == "HLine") {
        hw = 0;
        bgc = "#000000";
        bdw = "1";
      }
      itemsHTML[countindex] = new ZTObjects.boxObj("item" + nitem, "Box" + nitem, "Box", " ", "", xpos, ypos, hw, wh, bgc, bdw);
      nitem++;
      countindex++; nAllItems++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = hw * scale / 100;
      itemsHTML[countindex - 1].w = wh * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Expr":
      itemsHTML[countindex] = new ZTObjects.ExprObj('item' + nitem, 'Expr' + nitem, 'Expr', 'Expr', '', xpos, ypos);
      nitem++;
      countindex++; nAllItems++;
      divContainer.innerHTML = itemsHTML[countindex - 1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer = null;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      if (navValue != "") {
        itemsHTML[countindex - 1].exp = navValue;
        itemsHTML[countindex - 1].len = navDim;
        itemsHTML[countindex - 1].dec = navDec;
        itemsHTML[countindex - 1].type_exp = navType;
        itemsHTML[countindex - 1].comment = navCom;
        var wz = getDim(itemsHTML[countindex - 1]);
        itemsHTML[countindex - 1].w = wz * scale / 100;
        navValue = "";
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Label":
      itemsHTML[countindex] = new ZTObjects.labelObj('item' + nitem, 'label' + nitem, 'Label', 'Label text', '', xpos, ypos);
      if (!Empty(add_label_comment)) {
        itemsHTML[countindex].value = add_label_comment;
      }
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Chart":
      itemsHTML[countindex] = new ZTObjects.chartObj('item' + nitem, 'chart' + nitem, 'Chart', ' ', '', xpos, ypos);
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "SignMark":
      itemsHTML[countindex] = new ZTObjects.signMarkObj('item' + nitem, 'signmark' + nitem, 'SignMark', ' ', '', xpos, ypos);
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "SignSVG":
      itemsHTML[countindex] = new ZTObjects.signSVGObj('item' + nitem, 'signsvg' + nitem, 'SignSVG', ' ', '', xpos, ypos);
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "TinyHTML":
      itemsHTML[countindex] = new ZTObjects.tinyHTMLObj('item' + nitem, 'tinyhtml' + nitem, 'TinyHTML', ' ', '', xpos, ypos);
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Barcode":
      itemsHTML[countindex] = new ZTObjects.barcodeObj('item' + nitem, 'barcode' + nitem, 'Barcode', '', '<img id=\'item' + nitem + '\' src=\'' + getObjImg('Barcode') + '\' style=\'border:1px solid #f3f3f3;z-index:2;position:absolute;width:100px;height:100px;top:' + ypos + 'px;left:' + xpos + 'px;\' onclick=\'clickItem(event)\'>', xpos, ypos);
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Barcode2D":
      itemsHTML[countindex] = new ZTObjects.barcode2dObj('item' + nitem, 'barcode2d' + nitem, 'Barcode2D', '', '<img id=\'item' + nitem + '\' src=\'' + getObjImg('Barcode2D') + '\' style=\'border:1px solid #f3f3f3;z-index:2;position:absolute;width:100px;height:100px;top:' + ypos + 'px;left:' + xpos + 'px;\' onclick=\'clickItem(event)\'>', xpos, ypos);
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Image":
      itemsHTML[countindex] = new ZTObjects.imageObj('item' + nitem, 'image' + nitem, 'Image', '<img alt="Image not found" id=\'item' + nitem + '\' src style=\'border:1px solid #f3f3f3;z-index:2;font-size:11px;position:absolute;width:100px;height:100px;top:' + ypos + 'px;left:' + xpos + 'px;\' onclick=\'clickItem(event)\'>', ' ', '', xpos, ypos, 100, 100, '', '');
      nitem++;
      countindex++; nAllItems++;
      Ctrl("canvasitems").innerHTML += itemsHTML[countindex - 1].html;
      itemsHTML[countindex - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight * scale / 100;
      itemsHTML[countindex - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth * scale / 100;
      itemsHTML[countindex - 1].localsrc = '';
      itemsHTML[countindex - 1].scale = scale;
      itemsHTML[countindex - 1].page = reportProp.page;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Group_top":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.groupObj('bar_group' + nbaritem + "_start", 'group' + nbaritem, 'Group_top', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_group" + (nbaritem) + "_start").offsetWidth;
      itemsHTML[countindex].child = countindex + 1;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      if (Ctrl("bar_group" + nbaritem + "_end")) {
        nbaritem++;
      }
      break;
    case "Group_down":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.groupObj('bar_group' + nbaritem + "_end", 'group' + nbaritem, 'Group_down', ' ', '', 0, (ypos + (diff - 10) * scale / 100));
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_group" + (nbaritem) + "_end").offsetWidth;
      itemsHTML[countindex].child = countindex - 1;
      countindex++; nAllItems++;
      if (Ctrl("bar_group" + nbaritem + "_start")) {
        nbaritem++;
      }
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "AltQuery_top":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.altqueryObj('bar_altquery' + nbaritem + "_start", 'altquery' + nbaritem, 'AltQuery_top', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_altquery" + (nbaritem) + "_start").offsetWidth;
      itemsHTML[countindex].child = countindex + 1;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      if (Ctrl("bar_altquery" + nbaritem + "_end")) {
        nbaritem++;
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "AltQuery_down":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.altqueryObj('bar_altquery' + nbaritem + "_end", 'altquery' + nbaritem, 'AltQuery_down', ' ', '', 0, (ypos + (diff - 10) * scale / 100));
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_altquery" + (nbaritem) + "_end").offsetWidth;
      itemsHTML[countindex].child = countindex - 1;
      countindex++; nAllItems++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      if (Ctrl("bar_altquery" + nbaritem + "_start")) {
        nbaritem++;
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Section_top":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.sectionObj('bar_section' + nbaritem + "_start", 'section' + nbaritem, 'Section_top', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_section" + (nbaritem) + "_start").offsetWidth;
      itemsHTML[countindex].child = countindex + 1;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      if (Ctrl("bar_section" + nbaritem + "_end")) {
        nbaritem++;
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "Section_down":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.sectionObj('bar_section' + nbaritem + "_end", 'section' + nbaritem, 'Section_down', ' ', '', 0, (ypos + (diff - 10) * scale / 100));
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_section" + (nbaritem) + "_end").offsetWidth;
      itemsHTML[countindex].child = countindex - 1;
      countindex++; nAllItems++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      if (Ctrl("bar_section" + nbaritem + "_start")) {
        nbaritem++;
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "BreakPage":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.breakpageObj('bar_breakpage' + nbaritem, 'pagebreak' + nbaritem, 'BreakPage', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_breakpage" + nbaritem).offsetWidth;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      nbaritem++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "HtmlSection":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.htmlsectionObj('bar_htmlsection' + nbaritem, 'htmlsection' + nbaritem, 'HtmlSection', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_htmlsection" + nbaritem).offsetWidth;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      nbaritem++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "HeaderBar_top":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.headerObj('bar_PageHeader_start', 'bar_PageHeader_start', 'HeaderBar_top', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_PageHeader_start").offsetWidth;
      itemsHTML[countindex].child = countindex + 1;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      break;
    case "HeaderBar_bottom":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.headerObj('bar_PageHeader_end', 'bar_PageHeader_end', 'HeaderBar_bottom', ' ', '', 0, ypos + 100);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_PageHeader_end").offsetWidth;
      itemsHTML[countindex].child = countindex - 1;
      itemsHTML[countindex].title = "Page Footer";
      countindex++; nAllItems++;
      nbaritem++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      break;
    case "ReportBar_top":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.headerObj('bar_ReportHeader_start', 'bar_ReportHeader_start', 'ReportBar_top', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_ReportHeader_start").offsetWidth;
      itemsHTML[countindex].child = countindex + 1;
      itemsHTML[countindex].title = "Report Header";
      itemsHTML[countindex].bcolor = "orange";
      countindex++; nAllItems++;
      reorganizeBandList = true;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      break;
    case "ReportBar_bottom":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.headerObj('bar_ReportHeader_end', 'bar_ReportHeader_end', 'ReportBar_bottom', ' ', '', 0, ypos + 100);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_ReportHeader_end").offsetWidth;
      itemsHTML[countindex].child = countindex - 1;
      itemsHTML[countindex].title = "Report Footer";
      itemsHTML[countindex].bcolor = "orange";
      countindex++; nAllItems++;
      nbaritem++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      break;
    case "SectBo_top":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.sectboObj('bar_sectbo' + nbaritem + "_start", 'sectbo' + nbaritem, 'SectBo_top', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_sectbo" + (nbaritem) + "_start").offsetWidth;
      itemsHTML[countindex].child = countindex + 1;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      if (Ctrl("bar_sectbo" + nbaritem + "_end")) {
        nbaritem++;
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "SectBo_down":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.sectboObj('bar_sectbo' + nbaritem + "_end", 'sectbo' + nbaritem, 'SectBo_down', ' ', '', 0, (ypos + (diff - 10) * scale / 100));
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_sectbo" + (nbaritem) + "_end").offsetWidth;
      itemsHTML[countindex].child = countindex - 1;
      countindex++; nAllItems++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      if (Ctrl("bar_sectbo" + nbaritem + "_start")) {
        nbaritem++;
      }
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    case "AutoCover":
      nBarItems++;
      itemsHTML[countindex] = new ZTObjects.autocoverObj('bar_autocover' + nbaritem, 'autocover' + nbaritem, 'AutoCover', ' ', '', 0, ypos);
      Ctrl("bars").innerHTML += itemsHTML[countindex].getHtml();
      itemsHTML[countindex].h = 0;
      itemsHTML[countindex].w = Ctrl("bar_autocover" + nbaritem).offsetWidth;
      countindex++; nAllItems++;
      reorganizeBandList = true;
      nbaritem++;
      itemsHTML[countindex - 1].page = reportProp.page;
      itemsHTML[countindex - 1].scale = scale;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h);
      break;
    default:
      return false;
      break;
  }
  m_itemsHTML = null;
  add_label_comment = "";
  document.body.style.cursor = "default";
  Ctrl("canvas").onmousedown = beginDragSelection2;
  m_bUpdated = true;
  return true;
}

function InsertImageDone(localsrc, imgnew, retTo) {
  if (localsrc != null) {
    if (imgnew == 'true') {
      var xpos = xxpos;
      var ypos = yypos;
      itemsHTML[countindex] = new ZTObjects.imageObj('item' + nitem,'image' + nitem, 'Image', '<img id=\'item' + nitem + '\' src=\'\' style=\'z-index:1;position:absolute;top:' + ypos + 'px;left:' + xpos + 'px;\' onclick=\'clickItem(event)\'>', ' ', '', xpos, ypos);
      nitem++;
      countindex++;
      var divContainer = document.createElement('div');
      divContainer.innerHTML = itemsHTML[countindex - 1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer = null;
      itemsHTML[countindex - 1].h = (Empty(Ctrl("item" + (nitem - 1)).offsetHeight) ? 30 : Ctrl("item" + (nitem - 1)).offsetHeight);
      itemsHTML[countindex - 1].w = (Empty(Ctrl("item" + (nitem - 1)).offsetWidth) ? 30 : Ctrl("item" + (nitem - 1)).offsetWidth);
      itemsHTML[countindex - 1][retTo] = localsrc
      index = countindex - 1;
    }
    else {
      itemsHTML[index][retTo] = localsrc;
    }
  }
  writeHTMLItemObj(itemsHTML[index]);
}

function putItem2(e) {
  if (type == null) { return; }
  addItem2(e);
}

function putBarDown(e/*, paste*/) {
  if (type.indexOf("_top") > - 1) {
    itemsHTML[countindex - 1].show = true;
    switch (type) {
      case "Group_top":
        type = "Group_down";
        findEnclosingBar(ypos);
        var zdiff = diff;
        diff = 20;
        var yMove = ypos + zdiff - 10 - 2 * scale / 100;
        /* Caso: si cerca di inserire un gruppo in un gruppo con un'altezza di una decina di pixel.
           Il group footer del nuovo gruppo viene posizionato prima del suo group header a causa della shiftBar(y), perche' il valore del parametro era minore di ypos.
           Il seguente test evita la problematica.
        */
        if (yMove > ypos) {
          shiftBar(yMove);
        }
        else {
          shiftBar(ypos + 1);
        }
        diff = zdiff;
        break;
      case "Section_top":
        itemsHTML[countindex - 1].show = true;
        type = "Section_down";
        shiftBar(ypos);
        break;
      case "AltQuery_top":
        itemsHTML[countindex - 1].show = true;
        type = "AltQuery_down";
        shiftBar(ypos);
        break;
      case "SectBo_top":
        itemsHTML[countindex - 1].show = true;
        type = "SectBo_down";
        shiftBar(ypos);
        break;
    }
    putItem(e);
    itemsHTML[countindex - 1].name = itemsHTML[itemsHTML[countindex - 1].child].name;
    reorganizeBandList = true;
    itemsHTML[countindex - 1].show = false;
  }
  else {
    index = countindex - 1;
  }

  writeHTML();
  selectItem2(itemsHTML[countindex - 1], true);
  diff = 40;
}

function findEnclosingBar(yCoordinate) {
  /* Caso semplificato: si cerca di inserire un gruppo in un report che contiene solo un Page Header e un Page Footer e il Page Header e' in posizione 0.
     Se minY vale 0, il test bandList[ii].y > minY fallisce e questo causa l'inserimento del Group Footer al di sotto del Page Footer.
  */
  var minY = -1; // minY deve partire da -1 per evitare degli incroci nel caso di elementi di tipo barra con coordinata 0.
  var cdiff = 0; //, countg = 0;
  var pos = null;
  var rFooterY = -1, pFooterY = -1;
  var tmpScale;
  /* Caso semplificato: si cerca di inserire un group dentro un altro group quando sono in zoom al 50%.
     Il bottom del group inserito e' posizionato a distanza di 1 px dal bottom del group gia' presente.
     Questo e' dovuto al moltiplicatore 100 / scale usato nel calcolo di diff che provoca lo shiftBar()
     degli elementi a partire da una y maggiore della coordinata y del group esterno (quindi il bottom del group esterno non viene spostato).
     Per evitare l'errore, ho creato una nuova variabile per impostare uno scale temporaneo a 100 quando scale e' minore di 100.
  */
  if (scale < 100) {
    tmpScale = 100;
  }
  else {
    tmpScale = scale;
  }

  for (var ii = 0; ii < bandList.length; ii++) {
    if (bandList[ii].id.indexOf("break") < 0 && bandList[ii].id.indexOf("cover") < 0 && bandList[ii].id.indexOf("html") < 0) {
      if (itemsHTML[bandList[ii].child] && itemsHTML[bandList[ii].child].type == "HeaderBar_bottom") {
        pFooterY = itemsHTML[bandList[ii].child].y;
      }
      if (itemsHTML[bandList[ii].child] && itemsHTML[bandList[ii].child].type == "ReportBar_bottom") {
        rFooterY = itemsHTML[bandList[ii].child].y;
      }
      if (bandList[ii].type.indexOf("_top") > 0 && bandList[ii].type.indexOf("Section_") < 0 && bandList[ii].y < yCoordinate && bandList[ii].y > minY) {
        cdiff = 0;
        if (!(itemsHTML[bandList[ii].child].type == "HeaderBar_bottom" || itemsHTML[bandList[ii].child].type == "ReportBar_bottom")) {
          cdiff = (itemsHTML[bandList[ii].child].y - yCoordinate) * 100 / tmpScale;
        }
        if (cdiff >= 0) {
          minY = bandList[ii].y;
          pos = ii;
        }
      }
    }
  }

  if (pos != null) {
    if (itemsHTML[bandList[pos].child].type == "HeaderBar_bottom" || itemsHTML[bandList[pos].child].type == "ReportBar_bottom") {
      if (rFooterY > -1 && pFooterY > -1) {
        diff = (Math.min(pFooterY, rFooterY) - yCoordinate) * 100 / tmpScale + 10 - 2 * tmpScale / 100;
      }
      else {
        diff = (Math.max(pFooterY, rFooterY) - yCoordinate) * 100 / tmpScale + 10 - 2 * tmpScale / 100;
      }
    }
    else {
      diff = (itemsHTML[bandList[pos].child].y - yCoordinate) * 100 / tmpScale + 10 - 2 * tmpScale / 100;
    }
  }
  else {
    diff = Math.max(diff, (seekLastY() + 20 - yCoordinate) * 100 / tmpScale) + 10 - 2 * tmpScale / 100;
  }
  return;
}
/* *** Fine Gestione AddItems *** */

/* *** Gestione deleteItems *** */
function deleteItem(forbars) {
  var tmp = [];
  var tmpn = 0, i;
  undoItemsMoved = [];
  if (forbars) {
    for (i = 0; i < itemsHTML.length; i++) {
      // Sposta gli elementi non selezionati in tmp
      if (itemsHTML[i].shadow != "todelete") {
        if (itemsHTML[i].type.indexOf("_top") > 0) {
          itemsHTML[i].child = tmpn + 1;
          itemsHTML[i + 1].child = tmpn;
        }
        tmp[tmpn++] = itemsHTML[i];
      }
      else {
        // Si salvano gli oggetti cancellati per Undo
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, "delete", null, null, itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i]);
      }
    }
    insertIntoUndoSequence();
    countindex = tmpn;
    itemsHTML = tmp;
    index = null;
    last_index = null;
    validGdprReport();
    HightlightSelectedSpaceBar(index);
    reorganizeBandList = true;
    writeHTML(true);
    selectForm();
    return;
  }
  if (index != null) {
    var groupuid = "";
    /* Si deve verificare se e' stata selezionata almeno una barra. */
    if (typeof(dragBars.index) != "undefined") {
      /* Nel caso l'ultima barra selezionata sia ancora selezionata, deve essere cancellata.
         Se si tratta di un gruppo, si deve salvare l'uid per cancellare i rifermenti in Expr e Label. */
      if ((itemsHTML[dragBars.index].type.indexOf("Group") > -1) && (LRTrim(itemsHTML[dragBars.index].shadow) != "")) {
        groupuid = itemsHTML[dragBars.index].uid
      }
    }
    for (i = 0; i < itemsHTML.length; i++) {
      // Sposta gli elementi non selezionati in tmp
      if (LRTrim(itemsHTML[i].shadow) === "") {
        //correzione glemic 27-12-2010
        //begin
        if (itemsHTML[i].type.indexOf("_top") > 0) {
          itemsHTML[i].child = tmpn + 1;
          itemsHTML[i + 1].child = tmpn;
        }
        //end
        //azzera riferimenti al gruppo cancellato
        //MG 20120407 beg
        if (groupuid.length > 0) {
          if (itemsHTML[i].type == "Expr") {
            if (itemsHTML[i].print_when_change_groupuid == groupuid) {
              itemsHTML[i].print_when_change_group = "";
              itemsHTML[i].print_when_change_groupuid = "";
            }
            if (itemsHTML[i].resetuid == groupuid) {
              itemsHTML[i].reset = "";
              itemsHTML[i].resetuid = "";
            }
            if (itemsHTML[i].calculate_onuid == groupuid) {
              itemsHTML[i].calculate_on = "";
              itemsHTML[i].calculate_onuid = "";
            }
          }
          else if (itemsHTML[i].type == "Label" || itemsHTML[i].type == "Image" || itemsHTML[i].type == "Barcode" || itemsHTML[i].type == "Barcode2D" || itemsHTML[i].type == "SignSVG" || itemsHTML[i].type == "TinyHTML") {
            if (itemsHTML[i].print_when_change_groupuid == groupuid) {
              itemsHTML[i].print_when_change_group = "";
              itemsHTML[i].print_when_change_groupuid = "";
            }
          }
        }
        //MG 20120407 end
        tmp[tmpn++] = itemsHTML[i];
      }
      else {
        switch (itemsHTML[i].type) {
          case "HeaderBar_top":
            reportProp.pageheadfoot = false;
            break;
          case "ReportBar_top":
            reportProp.reportheadfoot = false;
            break;
          case "Group_top":
            groupuid = itemsHTML[i].uid;
            break;
          case "AltQuery_top":
            RemoveFromQueryList(itemsHTML[i].query);
            navQueries();
            break;
          case "SectBo_top":
            RemoveFromBOList("BO:" + itemsHTML[i].busobj);
            navBO();
            break;
          case "Chart":
            RemoveFromQueryList(itemsHTML[i].query);
            navQueries();
            break;
        }
        // Si salvano gli oggetti cancellati per Undo
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, "delete", null, null, itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i]);
      }
    }
    insertIntoUndoSequence();
    m_itemsHTML = null;
    countindex = tmpn;
    itemsHTML = tmp;
    index = null;
    last_index = null;
    HightlightSelectedSpaceBar(index);
    reorganizeBandList = true;
    writeHTML(true);
    selectForm();
  }
  m_bUpdated = true;
}
/* *** Fine Gestione deleteItems *** */

/* *** Gestione Copia e Incolla *** */
var pasteProperties = [];

function Copy(cut) {
  pasteProperties = [];
  var deftmpbar = [], deftmp = [];
  var selectedItems = [], selectedBar = [];
  var deftmpbardelta = 0, pastepos = 0, pastebarpos = 0;
  var pastebar = false;

  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow != "" && (pastebar == false && itemsHTML[i].id.indexOf("bar_") >= 0) && (itemsHTML[i].id.indexOf("_Page") < 0 && itemsHTML[i].id.indexOf("_Report") < 0) && itemsHTML[i].type != "AutoCover") {
      deftmpbar.push(copyItem(itemsHTML[i]));
      if (itemsHTML[i].type != "BreakPage" && itemsHTML[i].type != "AutoCover") {
        deftmpbar.push(copyItem(itemsHTML[itemsHTML[i].child]));
        deftmpbardelta = Math.abs(itemsHTML[itemsHTML[i].child].y - itemsHTML[i].y);
        pastebarpos = Math.min(itemsHTML[i].y, itemsHTML[itemsHTML[i].child].y);
      }
      else {
        pastebarpos = itemsHTML[i].y;
      }
      pastebar = true;
    }
    if (itemsHTML[i].shadow != "" && (itemsHTML[i].id.indexOf("bar_") < 0)) {
      deftmp.push(copyItem(itemsHTML[i]));
      pastepos = Math.min(pastepos, itemsHTML[i].y);
    }
  }

  if (cut) {
    if (deftmp.length > 0) {
      selectedItems = { "action" : "cut", "elements" : deftmp };
    }
    if (deftmpbar.length > 0) {
      selectedBar = { "action" : "cut", "elements" : deftmpbar };
    }
    deleteItem();
  }
  else {
    if (deftmp.length > 0) {
      selectedItems = { "action" : "copy", "elements" : deftmp };
    }
    if (deftmpbar.length > 0) {
      selectedBar = { "action" : "copy", "elements" : deftmpbar };
    }
  }
  pasteProperties = { "copyscale": scale,
                      //"deftmp": selectedItems,
                      //"deftmpbar": selectedBar,
                      //"deftmpbardelta": deftmpbardelta,
                      "pastebar": pastebar,
                      "pastepos": pastepos
                    };
  if (deftmp.length > 0) {
    pasteProperties["deftmp"] = selectedItems;
  }
  if (deftmpbar.length > 0) {
    pasteProperties["deftmpbar"] = selectedBar;
    pasteProperties["deftmpbardelta"] = deftmpbardelta;
    pasteProperties["pastebarpos"] = pastebarpos;
  }
  return JSON.stringify(pasteProperties);
}

function copyItem(item) {
  var propName, valueToSave = "";
  setPropertiesID(item);
  var JsonItem = {"type" : item.type };
  for (var u = 0; u < item.objClass.properties.length; u++) {
    propName = item.objClass.properties[u];
    valueToSave = item[propName];
    // Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
    if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
      // Se la prop e' undefined allora la salvo come ' '
      if (typeof(valueToSave) == "undefined" || valueToSave == "") {
        valueToSave = " ";
      }
    }
    JsonItem[propName] = valueToSave;
  }
  return JsonItem;
}

function Paste(strpaste) {
  if (LRTrim(strpaste) != "") {
    pasteProperties = JSON.parse(strpaste);
  }
  if (pasteProperties.pastebar == true) {
    document.body.style.cursor = "crosshair";
    Ctrl("canvas").onmousedown = PasteBar;
  }
  else if (pasteProperties.deftmp != null) {
    reload_(null, pasteProperties.deftmp, true);
    undoItemsMoved = [];
    for (var idx = 0; idx < pasted.length; idx++) {
      // Si salvano gli oggetti incollati per Undos;
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, "paste", itemsHTML[pasted[idx]].x, itemsHTML[pasted[idx]].y, itemsHTML[pasted[idx]].x, itemsHTML[pasted[idx]].y, itemsHTML[pasted[idx]]);
    }
    insertIntoUndoSequence();
    type = null;
  }
}

//deftmp - portalcommon variable
function PasteBar(e) {
  var cal = false;
  var result = true;
  if (pasteProperties.deftmpbar != null) {
    /* Verifica che non si stia cercando di incollare un gruppo, un'alternate query o un bo nella copertina. */
    if (!checkCanAdd(pasteProperties.deftmpbar["elements"][0])) {
      document.body.style.cursor = "default";
      Ctrl("canvas").onmousedown = null;
      type = null;
      pasteProperties.deftmpbar = {};
      return;
    }
    if (!cal) {
      calcPosition(e);
    }
    result = reload_(null, pasteProperties.deftmpbar, true);
    /* reload_ crea un nuovo elemento usando la putItem() e assegna il valore delle proprieta' contenute in deftmpbar al nuovo oggetto.
       L'uso di putItem() aggiunge l'evento 'add' nell'array undoItemsMoved, causando dei problemi in fase di Redo.
       Quindi, undoItemsMoved deve essere inizializzato di nuovo dopo la reload_().
     */
    undoItemsMoved = [];
    if (result) {
      if (pasteProperties.deftmpbar["elements"][type] != "BreakPage") {
        diff = 10 + pasteProperties.deftmpbardelta * 100 / pasteProperties.copyscale;
        itemsHTML[countindex - 2].y = ypos;
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, "paste", itemsHTML[countindex - 2].x, itemsHTML[countindex - 2].y, itemsHTML[countindex - 2].x, itemsHTML[countindex - 2].y, itemsHTML[countindex - 2]);
        itemsHTML[countindex - 2].show = true;
        pasteBarDown(countindex - 1);
        type = null;
        reorganizeBandList = true;
        writeHTML();
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, "paste", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1]);
      }
      else {
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, "paste", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1]);
        type = null;
      }
      insertIntoUndoSequence();
      cal = true;
    }
  }
  if (result) {
    if (typeof(pasteProperties.deftmp) != "undefined") {
      if (!cal) { calcPosition(e); }
      pasteProperties.pastebar = false;
      Paste(JSON.stringify(pasteProperties));
      writeHTML(false);
      pasteProperties.pastebar = true;
      cal = true;
    }
    diff = 40;
  }
}

function pasteBarDown(idx) {
  if (itemsHTML[idx].type == "Group_down") {
    itemsHTML[idx].show = true;
    findEnclosingBar(ypos);
    var zdiff = diff;
    diff = 20;
    var yMove = ypos + zdiff - 10 - 2 * scale / 100;
    if (yMove > ypos) {
      shiftBar(yMove);
    }
    else {
      shiftBar(ypos + 1);
    }
    diff = zdiff;
    itemsHTML[idx].y = (ypos + (diff - 10) * scale / 100);
    itemsHTML[idx].show = false;
  }
  else {
    itemsHTML[idx].show = true;
    shiftBar(ypos);
    itemsHTML[idx].y = (ypos + (diff - 10) * scale / 100);
    reorganizeBandList = true;
    itemsHTML[idx].show = false;
  }
  selectItem2(itemsHTML[idx], true);
  diff = 40;
}
/* *** Fine Gestione Copia e Incolla *** */

/* *** Gestione Save *** */
var AfterSave;
var maxWidthPrev = 0;

function saveAs() {
  if (parent) {
    parent.is_Saving = true;
  }
  var url = "../portalstudio/saveas.jsp?tool=report&custom=" + reportProp.custom;
  var width = 580;
  var height = 600;
  if (IsIE() && getInternetExplorerVersion() <= 8) {
    OpenWindow(url, width, height);
  }
  else {
    url += "&SPModalLayerId=saveSPModalLayer";
    openSPModalLayer(url, 40, 20, width, height, true, 1, false);
  }
}

function save(then) {
  if (parent) {
    parent.is_Saving = true;
  }
  index = null;
  selectForm();
  checksBeforeSave();

  if (currentname != "") {
    if (parent) {
      parent.is_Saving = true;
    }
    notimooManager = new Notimoo({});
    notimooManager.show({
      title : 'Notification message',
      message : 'saving report ' + currentname,
      sticky : true,
      width : 200,
      height : 40
    });
    if (then == "close") {
      AfterSave = "close";
    }
    else if (!Empty(then)) {
    //then e' un oggetto che contiene una funzione che deve essere eseguita dopo il salvataggio
      AfterSave = then;
    }
    save2.delay(100);
  }
  else {
    saveAs();
  }
}

/* Lancia i controlli sulla posizione delle barre prima del salvataggio. */
function checksBeforeSave() {
  var result = true;
  for (var i = 0; i < bandList.length && result; i++) {
    result = checkBarsPosition(i);
  }
  return result;
}

/* Crea un array con gli elementi selezionati nel seguente modo:
    * gli item di tipo barra
    * gli altri item
*/
function resort() {
  var n = 0;
  var standardItems = itemsHTML.filter(function (item/*, index*/) {
    return item.id.indexOf("bar_") != 0;
  });
  var bandItems = itemsHTML.filter(function (item/*, index*/) {
    return item.id.indexOf("bar_") == 0;
  });
  standardItems.sort(sortY);
  bandItems.sort(sortId);
  var allItems = [];
  for (n = 0; n < bandItems.length; n++) {
    if (bandItems[n].type.indexOf("_down") > 0 || bandItems[n].type.indexOf("_bottom") > 0 ) {
      if (bandItems[n - 1].child) {
        bandItems[n - 1].child = n;
      }
      if (bandItems[n].child) {
        bandItems[n].child = n - 1;
      }
    }
    allItems.push(bandItems[n]);
  }
  for (n = 0; n < standardItems.length; n++) {
    allItems.push(standardItems[n]);
  }
  return allItems;
}

var saveresult; // Necessaria in questa posizione per procedura di rigenerazione di tutti i report.
function save2() {
  var output, i;
  //Formato JSON

   /* resort() modifica il valore della proprieta' child degli item di tipo barra, ma senza modificare l'array itemsHTML.
     Effettuando un'operazione che utilizzi la proprieta' child di una barra dopo il salvataggio, si verifica un incrocio tra barre.
     Caso di prova:
      - si inserisce un elemento non barra nel report,
      - si inserisce un elemento barra nel report (non pagebreak),
      - si salva il report,
      - si effettua lo switch della barra appena inserita con un'altra utilizzando il navigator.
  */
  itemsHTML = resort();
  if (currentname != "") {
    var strsave = "";
    var JsonItems = [];
    reportProp.maxcount = nAllItems;

    JsonItems.push(reportProp.writeDef());
    for (i = 0; i < reportVariables.length; i++) {
      JsonItems.push(reportVariables[i].writeDef());
    }
    for (i = 0; i < itemsHTML.length; i++) {
      JsonItems.push(itemsHTML[i].writeDef());
      if (itemsHTML[i].id.indexOf("bar_") < 0) {
        if (maxWidthPrev < parseInt(itemsHTML[i].x) + parseInt(itemsHTML[i].w)) {
          maxWidthPrev = (parseInt(itemsHTML[i].x) + parseInt(itemsHTML[i].w)) * 100 / scale;
        }
      }
    }
    var portlet_name = "";
    currentname = Strtran(currentname, '\\', "/");
    if (currentname.indexOf('/') > -1) {
      portlet_name = currentname.substring(currentname.lastIndexOf("/") + 1);
    }
    else {
      portlet_name = currentname;
    }
    /* In questo modo salva il def in JSON */
    strsave = JSON.stringify(JsonItems, function(s,v) {if (typeof(v) != 'object') return v.toString(); else return v;});
    var url = new JSURL("../servlet/JSPSave?type=report"+
      "&encoding=" + reportProp.encoding +
      "&name=" + portlet_name + (m_nFrontendPort ? "&frontendport=" + m_nFrontendPort : "") +
      "&custom=" + reportProp.custom +
      "&def=" + URLenc(strsave) +
      "&m_cID=" + cmdhash, true);
    output = url.Response();
    saveresult = false;
    if (output == null) { output = ""; }
    switch (output) {
      case "true":
        saveresult = true;
        if (!modenoview) {
          for (i = 0; i < notimooManager.elements.length; i++) {
            notimooManager.close(notimooManager.elements[i]);
          }
          var isSavingCustom = (formProp.custom == "true" ? true : false);
          if (window.parent.changeName) {
            window.parent.changeName(portlet_name, {
              custom : isSavingCustom
            }, Strtran(window.frameElement.id, 'portalstudioframe', ''));
          }
          if (window.parent.AddRecentOpen) {
            window.parent.AddRecentOpen("report", portlet_name, {
              custom : isSavingCustom
            });
          }
          notimooManager.show({
            title : 'Notification message',
            message : 'report saved!',
            visibleTime : 2000,
            width : 200
          });
          m_bUpdated = false;
          if (typeof(window.opener) != "undefined") {
            try {
              window.opener.document.getElementById('zones_Id').submit();
            } catch (e) {}
          }
          document.title = currentname + " - Report Editor";
          if (AfterSave == "close") {
            if (window.parent && window.parent.closeCurrentObj) {
              window.parent.closeCurrentObj();
            }
          }
          else if (!Empty(AfterSave)) {
            AfterSave();
          }
          AfterSave = null;
        }
        break;
      case "ACCESS DENIED":
        if (modenoview == false) {
          notimooManager.close(notimooManager.elements[0]);
        }
        if (modenoview == false) {
          PSAlert.alert("Access Denied.");
        }
        break;
      case "LICENSE LIMIT":
        if (modenoview == false) {
          notimooManager.close(notimooManager.elements[0]);
        }
        if (modenoview == false) {
          PSAlert.alert("Licensed User Limit Reached.");
        }
        break;
      default:
        if (modenoview == false) {
          notimooManager.close(notimooManager.elements[0]);
        }
        if (modenoview == false) {
          PSAlert.alert("Save routine failed.");
        }
        break;
    }
    reportProp.modcnt = Str(Val(reportProp.modcnt) + 1);
  }
  else {
    window.parent.saveAsTool();
  }
  if (parent) {
    parent.is_Saving = false;
  }
}
/* *** Fine Gestione Save *** */

/* *** Gestione Preview *** */
var preview_opened = false;
var reportParams = "";

/* saveChanges: indica se si deve salvare il report al momento dell'anteprima. */
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
  /* Se il report e' stato modificato, se il nome del report non e' vuoto e se la preview non e' gia' aperta
     si deve chiedere se l'utente vuole salvare il report.
  */
  if (m_bUpdated == true && currentname != "" && !preview_opened) {
    saveChanges = confirm("Do you want to save " + currentname + "?");
  }
  Preview(saveChanges);
}

function generateXLSXModel() {
  var saveChanges = false;
  /* Se il report e' stato modificato, se il nome del report non e' vuoto e se la preview non e' gia' aperta
     si deve chiedere se l'utente vuole salvare il report.
  */
  if (m_bUpdated == true && currentname != "" && !preview_opened) {
    saveChanges = confirm("Do you want to save " + currentname + "?");
  }
  var tmp_bUpdated = m_bUpdated;
  if (!saveChanges) {
    m_bUpdated = false;
  }
  if(m_bUpdated){
    var message = this.currentname ? "Do you want to save " + this.currentname + "?" : "Do you want to save?";
    if(confirm(message)) {
    save(function(){
      generateXLSXModel()
    });
    }
    return;
  }
  _generateXLSXModel();
  if (!saveChanges) {
    m_bUpdated = tmp_bUpdated;
  }
}

function _generateXLSXModel() {
  var d = document.getElementById("modelDialog");
  if( d ) {
    mainitem = reportProp;
    nodialog = true;
    d.style.display = 'block';
    d.showModal();
    var dt = document.getElementById("modelDialogName")
    dt.focus()
  }
}

function _createModel() {
  var reportName = currentname;
  var type = 'report';
  var modelType = 'XLSX';
  var modelName = document.getElementById("modelDialogName").value;
  var overwrite = document.getElementById("modelDialogOverwrite").checked;

  var url = '../servlet/JSPWRGenerateModel';
  var params = 'type=' + type;
  params += '&' + 'reportName=' + reportName;
  params += '&' + 'modelType=' + modelType;
  params += '&' + 'modelName=' + modelName;
  params += '&' + 'overwrite=' + overwrite;
  params += '&' + 'custom=' + reportProp.custom;
  var request = new XMLHttpRequest();

  function failure(cause) {
    var d = document.getElementById("loading");
    d.style.display = 'none';
    d = document.getElementById("modelDialog");
    if( d ) {
      d.style.display = 'block';
    }
    alert(cause);
  }

	request.addEventListener('readystatechange', function(/*e*/) {
		if(request.readyState == 2 && request.status != 200) {
      return failure("ERROR ON CALLING SERVER");
		}
		if(request.readyState == 2 && request.status == 200) {
		}
		else if(request.readyState == 3) {
			// Download is under progress
		}
		else if(request.readyState == 4) {
			if(request.status != 200) {
				return failure("ERROR ON CALLING SERVER");
			}
			if(request.response.type == 'text/plain') {
				var myReader = new FileReader();
				//handler executed once reading(blob content referenced to a variable) from blob is finished.
				myReader.addEventListener("loadend", function(e){
					var retstr = e.srcElement.result;//prints a string
					if( retstr.indexOf('ERROR') >= 0 ) {
						return failure(retstr)
					}
					else {
            alert('MODEL CREATED WITH SUCCESS');
					  _abortModel();
					}
				});
				//start the reading process.
				myReader.readAsText(request.response);
			}
			else {
				return failure("ERROR ON CALLING SERVER");
			}
		}
	});
	request.addEventListener('progress', function(/*e*/) {
	});
	request.addEventListener('error', failure);
  request.addEventListener('abort', failure);
  request.addEventListener('timeout', failure);

	request.responseType = 'blob';

  var d = document.getElementById("loading");
  d.style.display = 'block';
  d = document.getElementById("modelDialog");
  if( d ) {
    d.style.display = 'none';
  }
	request.open('POST', url);
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send(params);

}

function _abortModel() {
  var d = document.getElementById("loading");
  d.style.display = 'none';
  nodialog = false;
  d = document.getElementById("modelDialog");
  if( d ) {
    d.style.display = 'none';
    d.close()
  }
}

function compareArray(array1, array2) {
  if (array1.length != array2.length) {
    return false;
  }
  return array1.sort().join() == array2.sort().join();
}

function reportPreview() {
  var hy = '95%';
  var i_prview = document.id('i_preview');
  document.id('i_preview_wrapper').setStyles({
    'width' : '100%',
    'height' : hy,
    'left' : 0,
    'top' : 0
  });
  document.id('i_preview').setStyles({
    'height' : '100%',
    'top' : 24
  });

  if (!preview_opened) {
    i_prview.src = createPreviewLink();
  }
  else {
    if (ZtVWeb.getPortlet('SPMaskParameters')) {
      var parametersValue = ZtVWeb.getPortlet('SPMaskParameters').getParametersValue();
      var params = "";
      var dTime = "";
      for (var el in parametersValue) {
        if (typeof(parametersValue[el]) == "object") { //date-datetime
          dTime = FormatDateTime(parametersValue[el], "YYYY-MM-DD hh:mm:ss");
          params += "&" + el + "=" + URLenc(dTime);
        }
        else {
          params += "&" + el + "=" + URLenc(parametersValue[el]);
        }
      }
      reportParams = Right(params, params.length - 1);
    }
  }
}

function createPreviewLink() {
  var str = "../servlet/Report?m_cDecoration=none&canModSettings=true&bPreview=true";
  str += "&ReportName=" + (!Empty(reportProp.custom)?((reportProp.custom == "true") ? "1" : "0") + "/" : "") + currentname;
  str += "&FileName=" + currentname + "_1";
  str += "&vdmMask=" + reportProp.vdmfile;
  str += "&rotation=" + reportProp.rotation.toUpperCase();
  str += "&docModel=" + reportProp.pdffile;
  str += "&pageFormat=" + reportProp.pformat.toUpperCase();
  if (reportProp.pformat == "custom") {
    str += "&pageWidth=" + convertToMillimeters(reportProp.cwidth);
    str += "&pageHeight=" + convertToMillimeters(reportProp.cheight);
  }
  str += "&marginTop=" + convertToMillimeters(reportProp.tmargin);
  str += "&marginBottom=" + convertToMillimeters(reportProp.bmargin);
  str += "&marginLeft=" + convertToMillimeters(reportProp.lmargin);
  str += "&fiscalDoc=" + reportProp.fiscaldoc;
  str += "&m_NoCache=" + LibJavascript.AlfaKeyGen(10);
  str += "&parms=" + URLenc(reportParams);
  return str;
}
/* *** Fine Gestione Preview *** */

/* *** Gestione Spostamento item *** */
var dragBars = new Object();
dragBars.zOrder = 50;
var draggingHandler;
var draggingHandlerCorner;
var draggedItemIdx;
var dragSelection = false;

function beginDragSelection2(event) {
  removeClassFromElement("selected_var");
  dragSelection = true;
  for (var i = 0; i < bandList.length; i++) {
    if (bandList[i].id.indexOf("bar_") == 0) {
      if (Ctrl(bandList[i].id)) {
        Ctrl(bandList[i].id).style.zIndex = 99;
      }
    }
  }
  beginDragSelection(event);
  Ctrl("canvas").onmouseup = endDragSelection2;
}

function endDragSelection2(event) {
  dragSelection = false;
  for (var i = 0; i < bandList.length; i++) {
    if (bandList[i].id.indexOf("bar_") == 0) {
      if (Ctrl(bandList[i].id)) {
        Ctrl(bandList[i].id).style.zIndex = 100;
      }
    }
  }
  endDragSelection(event);

  if (Ctrl("canvashandlers").innerHTML == "") {
    if (index != null) {
      if (event != null && event.shiftKey == false) {
        index = null;
      }
      else if (itemsHTML[index].id.indexOf("bar_") == 0) {
        if (itemsHTML[index].id.indexOf("PageHeader") > -1 || itemsHTML[index].id.indexOf("ReportHeader") > -1) {
          index = null;
        }
      }
      else {
        index = null;
      }
      Properties();
    }
  }
}

function dragBar(e, obj) {
  SetOnEditProp(false);
  e = (e) ? e : window.event;

  if (typeof(obj) == "string") {
    obj = Ctrl(obj);
  }

  if (lockItems) {
    cancelEvent(e);
    if (obj) {
      selectItem2(obj, true);
    }
    return;
  }

  var element = GetEventSrcElement(e);
  if (element && element.id.indexOf("_hand") > -1) {
    dragObj.DragMethod = "LeaveObjects";
    e.cancelBubble = true;
    //obj = document.getElementById(Strtran(obj.id, "_hand", ""));
  }
  else {
    dragObj.DragMethod = "";
  }
  var CurrentObjectY = 0;

  var zlimit = parseInt(reportProp.scale / 100);
  if (zlimit < 1) { zlimit = 1; }
  if (obj == null) { return; }
  if (obj) {
    dragBars.movingObj = obj;
    dragBars.style = obj.style;
    dragBars.oTop = obj.offsetTop;
    CurrentObjectY = obj.offsetTop;
    dragBars.oName = obj.id;
  }

  if (!e || (dragBars.oTop < 0)) { return; }
  // Save mousedown location
  dragBars.downY = (e.offsetY) ? e.offsetY : (e.layerY) ? e.layerY : 0;
  dragBars.downY = dragBars.downY + Ctrl("backcanvas").offsetTop - Ctrl("backcanvas").scrollTop;
  // bring to top of stack
  dragBars.style.zIndex = ++dragBars.zOrder;
  var MaxPossibleTop = 0;
  for (var i = 0; i < itemsHTML.length; i++) { // this loop is to check the max y position the bar can go up...
    if (itemsHTML[i].page != reportProp.page) {
      continue;
    }
    if (itemsHTML[i].id == obj.id) { // these 2 lines take the index [i] of the current bar in the array itemsHTML
      dragBars.index = i;
      itemsHTML[i].shadow = "nonempty";
      mainitem = obj;
    }
    var itemPos = itemsHTML[i].y + itemsHTML[i].h; // itemPos is the location of the bottom of the object
    if (itemPos >= MaxPossibleTop && itemPos < CurrentObjectY) { // if there is an object lower than the current one, take its bottom location
      MaxPossibleTop = itemPos;
    }
  }
  dragBars.MaxPossibleTop = MaxPossibleTop + zlimit;

  Ctrl("canvas").onmousedown = null;
  Ctrl("canvas").onmouseup = null;

  cancelEvent(e);
  if (document.addEventListener) {
    document.addEventListener("mousemove", dragBarStart, true);
    document.addEventListener("mouseup", dragBarEnd, true);
  }
  else if (document.attachEvent) {
    document.attachEvent("onmousemove", dragBarStart);
    document.attachEvent("onmouseup", dragBarEnd);
    return false;
  }
  m_bUpdated = true;
}

function dragBarStart(e) {
  e = (e) ? e : window.event;
  var y = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY + document.documentElement.scrollTop + document.body.scrollTop : 0;
  // Move drag element by the amount the cursor has moved.
  var newY = (y - dragBars.downY);
  if (newY < 0) { newY = 0; }
  if (newY > dragBars.MaxPossibleTop || dragObj.DragMethod != "") {
    dragBars.style.top = newY + "px";
    itemsHTML[dragBars.index].y = newY;
  }
  Ctrl("info_" + itemsHTML[dragBars.index].id).style.display = "none";
  Ctrl("drag").style.display = "none";
  document.body.style.cursor = "n-resize";
  Ctrl("canvas").onmousedown = null;
  Ctrl("canvas").onmouseup = null;
  if (e.preventDefault) {
    e.preventDefault();
  }
  else {
    return false;
  }
}

function dragBarEnd(e) {
  // Stop capturing mousemove and mouseup events.
  if (document.removeEventListener) {
    document.removeEventListener("mousemove", dragBarStart, true);
    document.removeEventListener("mouseup", dragBarEnd, true);
  }
  else if (document.detachEvent) {
    document.detachEvent("onmousemove", dragBarStart);
    document.detachEvent("onmouseup", dragBarEnd);
  }
  document.body.style.cursor = "default";

  var dragProp = new Object();
  dragProp.diff = dragBars.movingObj.offsetTop - dragBars.oTop;
  dragProp.name = dragBars.oName;
  dragProp.method = dragObj.DragMethod;
  Ctrl("info_" + itemsHTML[dragBars.index].id).style.display = "block";
  PostDragChecks(dragProp);
  HightlightSelectedSpaceBar(dragBars.index);
  var drag = Ctrl("drag");
  drag.style.width = "0px";
  drag.style.height = "0px";
  drag.style.display = "block";
  Ctrl("canvas").onmousedown = beginDragSelection2;
  Ctrl("canvas").onmouseup = endDragSelection2;
  SetOnEditProp(false);
  cancelEvent(e);
}

function shiftBar(y) {
  y = parseInt(y);
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].page != reportProp.page) {
      continue;
    }
    if (itemsHTML[i].type == "Box" && parseInt(itemsHTML[i].y) < y && (parseInt(itemsHTML[i].y) + parseInt(itemsHTML[i].h)) > y) {
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[i].id, "moveadd", itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i], itemsHTML[i].w, parseInt(itemsHTML[i].h) + diff * scale / 100, itemsHTML[i].w, itemsHTML[i].h);
      itemsHTML[i].h = parseInt(itemsHTML[i].h) + diff * scale / 100; // for Boxes, if it start above the bar, and end below it, then extent it.
      refreshArray[refreshArray.length] = itemsHTML[i];
    }
    if (parseInt(itemsHTML[i].y) > y) {
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[i].id, "moveadd", itemsHTML[i].x, parseInt(itemsHTML[i].y) + diff * scale / 100, itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i], itemsHTML[i].w, itemsHTML[i].h, itemsHTML[i].w, itemsHTML[i].h);
      itemsHTML[i].y = parseInt(itemsHTML[i].y) + diff * scale / 100; // move all elements below the current bar
      refreshArray[refreshArray.length] = itemsHTML[i];
    }
  }
}

function PostDragChecks(dragProp) {
  undoItemsMoved = [];
  var i;
  if (dragProp.method == "") { // if drag method is "" move the objects below the current one, else (moving using small icon), don't move them
    var DragLimit = itemsHTML[dragBars.index].y - dragProp.diff;
    for (i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].page != reportProp.page) {
        continue;
      }
      if (itemsHTML[i].type == "Box" && parseInt(itemsHTML[i].y) < DragLimit && (parseInt(itemsHTML[i].y) + parseInt(itemsHTML[i].h)) > DragLimit) {
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[i].id, "move", itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i], itemsHTML[i].w, parseInt(itemsHTML[i].h) + dragProp.diff, itemsHTML[i].w, itemsHTML[i].h);
        itemsHTML[i].h = parseInt(itemsHTML[i].h) + dragProp.diff; // for Boxes, if it start above the bar, and end below it, then extent it.
        refreshArray[refreshArray.length] = itemsHTML[i];
      }
      if (itemsHTML[i].id != dragBars.oName && parseInt(itemsHTML[i].y) > DragLimit) {
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[i].id, "move", itemsHTML[i].x, parseInt(itemsHTML[i].y) + dragProp.diff, itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i], itemsHTML[i].w, itemsHTML[i].h, itemsHTML[i].w, itemsHTML[i].h);
        itemsHTML[i].y = parseInt(itemsHTML[i].y) + dragProp.diff; // move all elements below the current bar
        refreshArray[refreshArray.length] = itemsHTML[i];
      }
      if (itemsHTML[i].id == dragBars.oName) {
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[i].id, "move", itemsHTML[i].x, itemsHTML[i].y, itemsHTML[i].x, itemsHTML[i].y - dragProp.diff, itemsHTML[i], itemsHTML[i].w, itemsHTML[i].h, itemsHTML[i].w, itemsHTML[i].h);
      }
    }
  }
  else if (dragProp.method == "LeaveObjects") {
    for (i = 0; i < bandList.length; i++) {
      if (bandList[i].id == dragBars.oName) {
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(bandList[i].id, "move", bandList[i].x, bandList[i].y, bandList[i].x, bandList[i].y - dragProp.diff, bandList[i], bandList[i].w, bandList[i].h, bandList[i].w, bandList[i].h);
      }
    }
  }

  if (dragProp.diff != 0) {
    removeAllHandlers();
    reorganizeBandList = true;
    writeHTML();
  }
  mainitem = Ctrl(dragBars.oName);
  itemsHTML[dragBars.index].shadow = "todelete";

  if (itemsHTML[dragBars.index].id.indexOf("_start") > 0) {
    itemsHTML[dragBars.index + 1].shadow = "todelete";
    index = dragBars.index;
  }
  else if (itemsHTML[dragBars.index].id.indexOf("_end") > 0) {
    itemsHTML[dragBars.index - 1].shadow = "todelete";
    if (itemsHTML[dragBars.index].id.indexOf("_Page") < 0 && itemsHTML[dragBars.index].id.indexOf("_Report") < 0) {
      index = dragBars.index - 1;
    }
    else {
      index = dragBars.index;
    }
  }
  insertIntoUndoSequence();

  if (itemsHTML[dragBars.index].id.indexOf("break") > 0 || itemsHTML[dragBars.index].id.indexOf("cover") > 0 || itemsHTML[dragBars.index].id.indexOf("html") > 0) {
    index = dragBars.index;
  }
  if (Left(itemsHTML[index].type, 9) == "AutoCover" || Left(itemsHTML[index].type, 6) == "Header" || Left(itemsHTML[index].type, 6) == "Report" || Left(itemsHTML[index].type, 5) == "Group" || Left(itemsHTML[index].type, 7) == "Section" || itemsHTML[index].type.indexOf("AltQuery") > -1 || itemsHTML[index].type.indexOf("BreakPage") > -1 || itemsHTML[index].type.indexOf("SectBo") > -1 || itemsHTML[index].type.indexOf("HtmlSection") > -1) {
    clickBand(itemsHTML[index].id);
  }
  else {
    FormProperties();
  }
}

function moveSection(dir, shadow, elementind) {
  if (Empty(shadow) || Empty(dir)) { return; }
  if (shadow == "noempty") { return; }
  if (Ctrl(shadow)) { return; }
  var sc = 0;
  if (dir == "up") {
    sc = -1;
  }
  else if (dir == "down") {
    sc = 1;
  }
  var obj = Ctrl(itemsHTML[elementind].id);
  if (sc != 0) {
    SetOnEditProp(false);
    if (lockItems) {
      if (obj) {
        selectItem2(obj, true);
      }
      return;
    }

    dragObj.DragMethod = "";
    var CurrentObjectY = 0;

    var zlimit = parseInt(reportProp.scale / 100);
    if (zlimit < 1) { zlimit = 1; }
    if (obj == null) { return; }
    if (obj) {
      dragBars.movingObj = obj;
      dragBars.style = obj.style;
      dragBars.oTop = obj.offsetTop;
      CurrentObjectY = obj.offsetTop;
      dragBars.oName = obj.id;
    }
    //if (!dragBars.oTop) { return; }
    if (typeof(dragBars.oTop) != "number") { return; }
    if (dragBars.oTop < 0) { return; }
    // Save location
    if (obj.offsetBottom) {
      dragBars.downY = obj.offsetBottom;
      dragBars.downY = dragBars.downY + Ctrl("backcanvas").offsetTop - Ctrl("backcanvas").scrollTop;
    }
    // bring to top of stack
    dragBars.style.zIndex = ++dragBars.zOrder;
    var MaxPossibleTop = 0;
    for (var i = 0; i < itemsHTML.length; i++) { // this loop is to check the max y position the bar can go up...
      if (itemsHTML[i].page != reportProp.page) {
        continue;
      }
      if (itemsHTML[i].id == obj.id) { // these 2 lines take the index [i] of the current bar in the array itemsHTML
        dragBars.index = i;
        itemsHTML[i].shadow = "nonempty";
        mainitem = obj;
      }
      var itemPos = itemsHTML[i].y + itemsHTML[i].h; // itemPos is the location of the bottom of the object
      if (itemPos >= MaxPossibleTop && itemPos < CurrentObjectY) { // if there is an object lower than the current one, take its bottom location
        MaxPossibleTop = itemPos;
      }
    }
    dragBars.MaxPossibleTop = MaxPossibleTop + zlimit;

    ///////////////////
    var newY = obj.offsetTop + sc;
    if (newY < 0) { newY = 0; }
    if (newY >= dragBars.MaxPossibleTop || dragObj.DragMethod != "") {
      dragBars.style.top = newY + "px";
      itemsHTML[dragBars.index].y = newY;
    }
    ///////////////////
    var dragProp = new Object();
    dragProp.diff = dragBars.movingObj.offsetTop - dragBars.oTop;
    dragProp.name = dragBars.oName;
    dragProp.method = dragObj.DragMethod;
    Ctrl("info_" + itemsHTML[dragBars.index].id).style.display = "block";
    PostDragChecks(dragProp);
    HightlightSelectedSpaceBar(dragBars.index);
  }
}

function moveLine(e, obj) {
  SetOnEditProp(false);
  e = (e) ? e : window.event;
  dragObj.DragMethod = "";
  if (typeof(obj) == "string") {
    obj = Ctrl(obj);
  }
  if (obj == null) { return; }
  if (obj) {
    dragBars.movingObj = obj;
    dragBars.style = obj.style;
    dragBars.oLeft = obj.offsetLeft;
    dragBars.xName = obj.id;
  }

  if (!e || !dragBars.oLeft) { return; }
  if (!e) { return; }
  // Save mousedown location
  dragBars.downX = (e.offsetX) ? e.offsetX : (e.layerX) ? e.layerX : 0;
  dragBars.downX = dragBars.downX + Ctrl("backcanvas").offsetLeft - Ctrl("backcanvas").scrollLeft;
  if (document.all) {
    dragBars.downX = dragBars.downX;
  }
  // bring to top of stack
  //dragBars.style.zIndex = ++dragBars.zOrder;

  Ctrl("canvas").onmousedown = null;
  Ctrl("canvas").onmouseup = null;

  cancelEvent(e);
  if (document.addEventListener) {
    document.addEventListener("mousemove", dragLineStart, true);
    document.addEventListener("mouseup", dragLineEnd, true);
  }
  else if (document.attachEvent) {
    document.attachEvent("onmousemove", dragLineStart);
    document.attachEvent("onmouseup", dragLineEnd);
    return false;
  }
}

function dragLineStart(e) {
  e = (e) ? e : window.event;
  var x = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX + document.documentElement.scrollLeft + document.body.scrollLeft : 0;
  // Move drag element by the amount the cursor has moved.
  var newX = (x - dragBars.downX);
  if (newX < 0) {
    newX = 0;
  }

  dragBars.style.left = newX + "px";
  Ctrl(dragBars.xName + "ref").style.left = newX + "px";

  document.body.style.cursor = "e-resize";
  Ctrl("canvas").onmousedown = null;
  Ctrl("canvas").onmouseup = null;
  if (e.preventDefault) {
    e.preventDefault();
  }
  else {
    return false;
  }
}

function dragLineEnd(e) {
  // Stop capturing mousemove and mouseup events.
  if (document.removeEventListener) {
    document.removeEventListener("mousemove", dragLineStart, true);
    document.removeEventListener("mouseup", dragLineEnd, true);
  }
  else if (document.detachEvent) {
    document.detachEvent("onmousemove", dragLineStart);
    document.detachEvent("onmouseup", dragLineEnd);
  }
  document.body.style.cursor = "default";

  if (dragBars.xName == "z_line") {
    var posx = parseInt(dragBars.style.left);
    posx = posx * 100 / scale;
    reportProp.v_line = posx;
    FormProperties();
  }

  Ctrl("canvas").onmousedown = beginDragSelection2;
  Ctrl("canvas").onmouseup = endDragSelection2;
  SetOnEditProp(false);
  cancelEvent(e);
}

function ValidMove(x, y, w, h/*, id*/) {
  var ret = true;
  if (x < 0 || y < 0) {
    ret = false;
  }
  if (ret == true) {
    var rigRulers = false;
    var maxHeight = y + h;
    var maxWidth = x + w;
    if (maxHeight > Ctrl("canvas").offsetHeight) {
      Ctrl("canvas").style.height = (maxHeight + 15) + "px";
      rigRulers = true;
    }
    if (maxWidth > Ctrl("canvas").offsetWidth) {
      Ctrl("canvas").style.width = (maxWidth + 15) + "px";
      rigRulers = true;
    }

    if (rigRulers == true) {
      setCanvasScroll();
      generateRulers(reportProp.workunit);
    }
  }
  return ret;
}
/* *** Fine Gestione Spostamento item *** */

/* *** Gestione HightLight item *** */
function HightlightSelectedBars(barName) {
  var obj = Ctrl(barName);
  var objTop, objDown;
  if (obj) { // selecting a pair of bars
    if (obj.id.indexOf("_start") > 0) {
      objTop = Ctrl("info_" + obj.id);
      objDown = Ctrl("info_" + Strtran(obj.id, "_start", "_end"));
    }
    else {
      objDown = Ctrl("info_" + obj.id);
      objTop = Ctrl("info_" + Strtran(obj.id, "_end", "_start"));
    }
    if (objTop) {
      $(objTop.id).removeClass("text_shadow_bar");
      $(objTop.id).addClass("text_shadow_bar_selected");
    }
    if (objDown) {
      $(objDown.id).removeClass("text_shadow_bar");
      $(objDown.id).addClass("text_shadow_bar_selected");
    }
  }
}

function HightlightSpaceBar(i, div1, div2) {
  var ctrl, nav_i;
  for (nav_i = 0; nav_i < bandList.length; nav_i++) {
    ctrl = Ctrl("info_" + bandList[nav_i].id);
    if (ctrl) {
      $(ctrl.id).removeClass("text_shadow_bar_selected");
      $(ctrl.id).addClass("text_shadow_bar");
    }
    ctrl = Ctrl(bandList[nav_i].id);
    if (ctrl) {
      $(ctrl.id).removeClass("selected_bar");
      $(ctrl.id).addClass("unselected_bar");
    }
  }

  Ctrl(div2).style.display = "none";

  if (i == null || typeof(i) == "undefined") {
    Ctrl(div1).style.display = "none";
    return;
  }

  if (typeof(itemsHTML[i]) == "undefined") {
    return;
  }

  var barPosition = parseInt(itemsHTML[i].y);

  if (itemsHTML[i].id.indexOf("break") < 0 && itemsHTML[i].id.indexOf("cover") < 0 && itemsHTML[i].id.indexOf("html") < 0) {
    var childPosition = parseInt(itemsHTML[itemsHTML[i].child].y);
    var pos2 = -1;
    if (itemsHTML[i].id.indexOf("_Page") > -1 || itemsHTML[i].id.indexOf("_Report") > -1) {
      var id = itemsHTML[i].id;
      var bandID = "";
      if (id.indexOf("_Page") >= 0) {
        bandID = Strtran(id, "_Page", "_Report");
      }
      else {
        bandID = Strtran(id, "_Report", "_Page");
      }

      itemsHTML[i].y = parseInt(itemsHTML[i].y);
      for (nav_i = 0; nav_i < bandList.length ; nav_i++) {
        if (bandList[nav_i].id == bandID) {
          pos2 = nav_i;
          nav_i = bandList.length;
        }
      }
      if (pos2 > -1) {
        childPosition = parseInt(bandList[pos2].y);
        if (itemsHTML[i].id.indexOf("_start") >= 0) {
          if (barPosition < childPosition) {
            childPosition = 0;
          }
        }
        else { //_end
          if (barPosition > childPosition) {
            childPosition = Ctrl("canvas").offsetHeight;
          }
        }
      }
      else {
        if (itemsHTML[i].id.indexOf("_start") >= 0) {
          childPosition = 0;
        }
        else {
          childPosition = Ctrl("canvas").offsetHeight;
        }
      }
    }
    var topY, bottomY;
    if (barPosition > childPosition) {
      topY = childPosition;
      bottomY = barPosition;
    }
    else {
      topY = barPosition;
      bottomY = childPosition;
    }
    var obj = Ctrl(div1);
    obj.style.top = topY + "px";
    obj.style.height = (bottomY - topY) + "px";
    obj.style.display = "block";

    if (itemsHTML[i].id.indexOf("_group") > -1) {
      var tmpBand;
      var refinedBandID = Strtran(itemsHTML[i].id, "_start", "");
      barPosition = 0;
      childPosition = Ctrl("canvas").offsetHeight;
      refinedBandID = Strtran(refinedBandID, "_end", "");

      for (nav_i = 0; nav_i < itemsHTML.length; nav_i++) {
        tmpBand = itemsHTML[nav_i];
        tmpBand.y = parseInt(tmpBand.y);
        if (tmpBand.id.indexOf(refinedBandID) == 0) {
          continue;
        }

        if (tmpBand.id.indexOf("_section") < 0 && (tmpBand.id.indexOf("bar_") >= 0 || tmpBand.id.indexOf("_Page") >= 0 || tmpBand.id.indexOf("_Report") >= 0)) {
          if (tmpBand.y < itemsHTML[i].y) {
            barPosition = Math.max(barPosition, tmpBand.y);
          }
          else if (tmpBand.y > itemsHTML[itemsHTML[i].child].y) {
            childPosition = Math.min(childPosition, tmpBand.y);
          }
        }
      }
      obj = Ctrl(div2);
      obj.style.top = barPosition + "px";
      obj.style.height = (childPosition - barPosition) + "px";
      obj.style.display = "block";
    }
  }
  else {
    obj = Ctrl(div1);
    obj.style.top = barPosition + "px";
    obj.style.height = 1 + "px";
    obj.style.display = "block";
  }
}

function HightlightSelectedSpaceBar(i) {
  HightlightSpaceBar(i, "spaceBar", "spaceBarZ");
  Ctrl("moveBarImg1_hand").style.display = "none";
  Ctrl("moveBarImg2_hand").style.display = "none";
  Ctrl("moveBarImg1").style.display = "none";
  Ctrl("moveBarImg2").style.display = "none";
  if (typeof(itemsHTML[i]) == "undefined") {
    return;
  }
  var mdelta = 11; //circlez altezza 22px/2
  var suffix = "_hand"
  if (reportProp.show_movinghandle.toString() == "false") {
    mdelta = 8; //circlez altezza 17px/2
    suffix = "";
  }

  var hg = document.getElementsByClassName('selected_bar');
  for (var k = hg.length-1; k >= 0; k--) {
    $(hg[k].id).addClass("unselected_bar");
    $(hg[k].id).removeClass("selected_bar");
  }

  if (Ctrl("spaceBar").style.display == "block") {
    if (reportProp.show_movinghandle.toString() == "false") {
      Ctrl("moveBarImg1" + suffix).style.backgroundColor = itemsHTML[i].bcolor;
      if (itemsHTML[i].type.indexOf("BreakPage") < 0 || itemsHTML[i].type.indexOf("AutoCover") < 0 || itemsHTML[i].type.indexOf("HtmlSection") < 0) {
        Ctrl("moveBarImg2" + suffix).style.backgroundColor = itemsHTML[i].bcolor;
      }
    }
    if (Left(itemsHTML[i].type, 6) == "Header" || Left(itemsHTML[i].type, 6) == "Report") {
      Ctrl("moveBarImg1" + suffix).style.top = Ctrl("spaceBar").offsetTop - mdelta + "px";
      Ctrl("moveBarImg1" + suffix).style.display = "block";
      Ctrl("moveBarImg1" + suffix).onmousedown = function(e) {
        dragBar(e, itemsHTML[i].id);
      }
      Ctrl("moveBarImg2" + suffix).style.top = Ctrl("spaceBar").offsetTop + Ctrl("spaceBar").offsetHeight - mdelta + "px";
      Ctrl("moveBarImg2" + suffix).style.display = "block";
      Ctrl("moveBarImg2" + suffix).onmousedown = function(e) {
        dragBar(e, itemsHTML[i].id);
      }
      if (itemsHTML[i].id.indexOf("_start") > -1) {
        Ctrl("moveBarImg1" + suffix).style.display = "none";
      }
      else {
        Ctrl("moveBarImg2" + suffix).style.display = "none";
      }
      $(itemsHTML[i].id).addClass("selected_bar");
      $(itemsHTML[i].id).removeClass("unselected_bar");
    }
    else {
      Ctrl("moveBarImg1" + suffix).style.top = Ctrl("spaceBar").offsetTop - mdelta + "px";
      Ctrl("moveBarImg1" + suffix).style.display = "block";
      Ctrl("moveBarImg1" + suffix).onmousedown = function(e) {
        dragBar(e, itemsHTML[i].id);
      }
      if (itemsHTML[i].type.indexOf("BreakPage") > -1 || itemsHTML[i].type.indexOf("AutoCover") > -1 || itemsHTML[i].type.indexOf("HtmlSection") > -1) {
        Ctrl("moveBarImg2" + suffix).style.display = "none";
      }
      else {
        Ctrl("moveBarImg2" + suffix).style.top = Ctrl("spaceBar").offsetTop + Ctrl("spaceBar").offsetHeight - mdelta + "px";
        Ctrl("moveBarImg2" + suffix).style.display = "block";
        Ctrl("moveBarImg2" + suffix).onmousedown = function(e) {
          dragBar(e, itemsHTML[itemsHTML[i].child].id);
        }
      }
      $(itemsHTML[i].id).addClass("selected_bar");
      $(itemsHTML[i].id).removeClass("unselected_bar");
      if (itemsHTML[i].type.indexOf("BreakPage") < 0 && itemsHTML[i].type.indexOf("AutoCover") < 0 && itemsHTML[i].type.indexOf("HtmlSection") < 0) {
        $(itemsHTML[itemsHTML[i].child].id).addClass("selected_bar");
        $(itemsHTML[itemsHTML[i].child].id).removeClass("unselected_bar");
      }
    }
  }
  else {
    Ctrl("moveBarImg1" + suffix).style.display = "none";
    Ctrl("moveBarImg2" +suffix).style.display = "none";
  }
  HightlightSelectedBars(itemsHTML[i].id);
  selectBand(itemsHTML[i].id);
}
/* *** Fine Gestione HightLight item *** */

/* *** Gestione delle variabili *** */
function addVariable(variable) {
  var vobj;
  var remap = false;
  m_itemsHTML = null;
  if (!variable) {
    reportVariables[reportVariables.length] = new ZTObjects.variableObj('variable' + nVar, 'variable_name' + nAllItems, 'Variable', '');
    reportVariables[reportVariables.length - 1].len = "10";
    reportVariables[reportVariables.length - 1].dec = "";
    reportVariables[reportVariables.length - 1].value = "";
    reportVariables[reportVariables.length - 1].type_value = "character";
    reportVariables[reportVariables.length - 1].comment = "";
    vobj = reportVariables[reportVariables.length - 1];
    vobj.repArrayIndex = reportVariables.length-1;
    remap = true;
    nAllItems++;
  }
  else {
    vobj = variable;
    var vfound = false;
    if (!vobj.repArrayIndex) {
      for (var v = 0; v < reportVariables.length && !vfound; v++) {
        if (vobj === reportVariables[v]) {
          vfound = true;
          vobj.repArrayIndex = v;
        }
      }
    }
  }
  currVar = reportVariables.length - 1;

  /* Crea l'interfaccia grafica della variabile. */
  var variableName = new Element('span', {
    html : htmlVariable(vobj),
    'class' : 'variableName',
    title : tooltipVariable(vobj)
  });

  var deleteImg = new Element('div', {
    'class' : 'imgDeleteVariable',
    title : 'Delete variable',
    'icon-data' : getIconDataFromAction("remove")
  });

  deleteImg.addEvent('click', function () {
    removeVariable(this.getParent());
  });

  variableName.addEvent('click', function () {
    removeClassFromElement("selected_var");
    $(this.parentNode.id).addClass("selected_var");
    currVar = vobj.repArrayIndex;
    editVariable(vobj, currVar);
  });

  var dragImg = new Element('div', {
      'id' : 'variable' + nVar + "_drag",
      'class' : 'imgDragVariable',
      'icon-data' : getIconDataFromAction("center_points")
  });

  var dragDiv = new Element('div', {
    'class' : 'varcontainerdiv',
    'data-attr' : 'variable' + nVar,
    'id' : 'variable' + nVar
  }).adopt(deleteImg).adopt(variableName).adopt(dragImg);

  dragImg.addEvent('mouseover', function () {
    var id = this.parentNode.id
    drawDragShadow(null,id,true);
  });

  var newVariable = new Element('li', {}).adopt(dragDiv);
  nVar++;
  document.id('variableList').adopt(newVariable);
  if (remap) {
    remapIntoVariableCombo();
    resizeGadgetsPane();
    removeClassFromElement("selected_var");
    $(variableName.parentNode.id).addClass("selected_var");
    currVar = vobj.repArrayIndex;
    editVariable(vobj, currVar);
  }
}

/* Nel caso la variabile abbia un commento, restituisce una stringa composta da
     nome : commento
   Altrimenti restituisce semplicemente il nome della variabile.
*/
function htmlVariable(variable) {
  var str = "";
  str = (LRTrim(variable.comment) != "") ? (variable.name + " : " + variable.comment) : variable.name;
  return str;
}

/* Costruisce il tooltip della variabile nel formato
     nome : descrizione - tipo (lunghezza , decimali)
*/
function tooltipVariable(variable) {
  var str = htmlVariable(variable);
  str += " - " + encodeType(variable.type_value) + "(" + variable.len + "," + (LRTrim(variable.dec) == "" ? 0 : variable.dec) + ")";
  return str;
}

function editVariable(vobj, pos) {
  selectForm();
  last_index = null;
  PropertiesVar(vobj, pos);
  currVar = pos;
}

/* Elimina la variabile da User Variables, dall'array reportVariables e dalla combobox into_variable. */
function removeVariable(el) {
  var elParent = el.getParent();
  var position = elParent.getAllPrevious().length;
  el.destroy();
  elParent.destroy();
  currVar = position;
  if (!Empty(newPropObj)) {
    newPropObj.HideProperties();
  }
  deleteVariable(reportVariables[currVar].name);
  reportVariables.splice(currVar, 1);
  currVar = null;
  resizeGadgetsPane(true);
  remapIntoVariableCombo("deleted");
}

// Ridisegna la combo Into Variable usata nelle espressioni.
function remapIntoVariableCombo(del) {
  if (del == "deleted") { selectForm(); }
  last_index = null;
  var i = 0;
  var orderedVariables = [];
  for (i = 0; i < reportVariables.length; i++) {
    orderedVariables[orderedVariables.length] = reportVariables[i].name;
  }
  into_variable_combo = "select[";
  orderedVariables.sort(function (e1, e2) {
    return (e1 <= e2 ? -1 : 1);
  });
  for (i = 0; i < orderedVariables.length; i++) {
    into_variable_combo += "," + orderedVariables[i];
  }
  into_variable_combo += "]";
}

// Aggiorna il valore della proprieta' Into Variable delle espressioni nel caso si cambi il nome di una variabile.
function updateVariable(varName, newName) {
  if (varName != "") {
    for (var i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].type == "Expr") {
        if (itemsHTML[i].into_variable == varName) {
          itemsHTML[i].into_variable = newName;
        }
      }
    }
  }
}

// Svuota il valore della proprieta' Into Variable delle espressioni nel caso si cancelli una variabile.
function deleteVariable(varName) {
  if (varName != "") {
    for (var i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].type == "Expr") {
        if (itemsHTML[i].into_variable == varName) {
          itemsHTML[i].into_variable = "";
        }
      }
    }
  }
  m_itemsHTML = null;
}
/* *** Fine Gestione delle variabili *** */

function morderCtrlById(a, b) {
  if (a < b) { return -1; }
  if (a > b) { return 1; }
  return 0;
}

function togglerGadget(toggler) {
  if (toggler.hasClass("opened")) {
    var t, tg = document.getElementsByClassName('gadgets_pane_toggler');
    var tgid = [];
    for (t = 0; t < tg.length; t++) {
      tgid[t] = tg[t].id;
    }
    tgid = tgid.sort(morderCtrlById);
    for (t = 0; t < tgid.length; t++) {
      if (tgid[t] != toggler.id && $(tgid[t]).hasClass("opened")) {
        $(tgid[t]).click();
      }
    }
  }
}

/****************************/

function getItemsHTML() {
  //if ( m_itemsHTML == null )
  m_itemsHTML = itemsHTML.concat(reportVariables);
  return m_itemsHTML;
}

function selectVariable(variableid) {
  for (var i=0; i<reportVariables.length; i++) {
    if ( reportVariables[i].id == variableid ) {
      editVariable(reportVariables[i], i);
      i = reportVariables.length;
    }
  }
}

function addCommentLabel(obj) {
  add_label_comment = "";
  if (obj && obj.index && itemsHTML[index] && !Empty(itemsHTML[index].comment)) {
    add_label_comment = itemsHTML[index].comment;
    addItem("Label");
  }
}

function validGdprReport() {
  reportProp.contentprivacy = 0;
  for (var i = 0; i < itemsHTML.length; i++) {
    if( itemsHTML[i].privacy != null && itemsHTML[i].privacy != undefined && !Empty( itemsHTML[i].privacy ) && itemsHTML[i].privacy != '0') {
      reportProp.contentprivacy++;
    }
    if( itemsHTML[i].identifier != null && itemsHTML[i].identifier != undefined && !Empty( itemsHTML[i].identifier ) && itemsHTML[i].identifier != '0') {
      reportProp.contentprivacy++;
    }
    if( itemsHTML[i].data_danger_level != null && itemsHTML[i].data_danger_level != undefined && !Empty( itemsHTML[i].data_danger_level ) && itemsHTML[i].data_danger_level != '0' ) {
      reportProp.contentprivacy++;
    }
  }
}
