/*  exported tmpTop tmpBottom tmpLeft tmpRight tmpObj genericColor scrollMap format_select
    orientation_select docSettingsMM addPositionNext SetDatasourceProp enableZone draggingHandler
    draggingHandlerCorner draggedItemIdx dragSelection dragBar dragBarZone dragMargin
    selectReportPageEvent makeDownloadEvent resetTabs HideVisibilityElementsByClass
    selectvqr selectvdm editvqr newvqr editvdm newvdm ExpressionBuilderReturn selectbo
    loadbo ValidMove drawZonesSwitch showReportZone showPageZone showGroupZone setProps
    changeBackgroundButton setTypeView setBarcodeType setBarcodeOffColor setBarcodeOnColor
    setFontFamily setFontSize setFontColor setBiggerSize setSmallerSize setBold setItalic
    setUnderline setStrikeout setAlignLeft setAlignCenter setAlignRight setImagePath
    WinOpener searchImage insertImage setLineColor setLineHeight maximizeLine minimizeLine
    setMeasureTick25 setMeasureTick50 setMeasureTick100 setGridTypeDot setGridTypeSmall
    setGridTypeLong setGridTypePlain setMeasureUnit setSnapToGrid optGrid optRulers
    addToolbarElements updateItemsPositions addHandlers validBody SaveItemStatus
    moveShadow updateMapItems updateAllItemsY updateAllArrays setMapItems addGenericItems
    unSelectItem setRelativeTop plusMargin minusMargin setMargin updateMapFieldCount
    replaceBreakField checkControl getDatasourceFields getItemsMaxWidth getItemsMaxHeight
    replaceItemPositions getCrossZoneItems setStretchRight actionOnField removeFieldConfirm
    getMinYPosition setMenuToolbar editItem enableItemButtons setPageSettings refreshdata
    addFieldDragClass removeFieldDragClass CheckCalculateField removeMissingFields
    getOffsetHeight winitprocess wendprocess wpagegrid waddinzone wupdatehtmlitem
    updateFieldsPane makePdf printInPreview generateReport mindex unittick gridtype
 */
/*  global _allFieldsHTML ptTopx docSettings convertStringToPx setZoneOptions
    repversion drawEditorReportFromModel m_CurrentObj JSRepDrawDocumentView
    uidItemsHTML idItemsHTML showNotimooMissingAlert drawMissingIcon
    getFieldHTMLIndex readJsonItem workunit generateGrid insertElementGrid
    gselectzone fzoneclick fpagemargins drawLimitBars toggleParametersIframe
    isoffline GetBOKeysVariables dataobj clearHTMLZone pushToHistory ismobile
    gwork viewMode designView convertPxToString documentView pdfView tabs pdfViewD
    resetZones decodeReportObj drawFieldLegend loadFields generateRulers SetUpdated
    loadFieldsInput resizeWindow getTranslated generateBarcode rootApp ConvertToView
    unittick gridtype updateDrawGrid drawSeparatorElement addHandler identifyZone
    calcSnapToGrid reportZones mapFieldCount ToStringHTML getFieldInfo gBreakFields
    checks MGetQueryFields makeJsonItem makeJsonItemAllFields fieldHTMLMap updateJsonItemAllFields
    fpagenumber addFieldUsedClass showMessageConfirm removeFieldUsedClass getZoneElementsType
    modifiedZone getFieldType GetQueryParameters
 */
/** VARIABILI GESTIONE AGGANCI **/
var tmpTop = [];
var tmpBottom = [];
var tmpLeft = [];
var tmpRight = [];
var tmpObj = [];

var genericColor = "#555555";
var scrollMap = [];

// mappa sottoelementi x area (report-page-group h/f)
var mapItems = [];
var mindex;
var format_select = "A0,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,letter,legal,tabloid,custom";
var orientation_select = "portrait,landscape";
var defaultPosRef = 40;

PSAlert.init(window, '');

/*var docSettings = {
    A0:{w:"2383pt",h:"3370pt"},
    A1:{w:"1683pt",h:"2383pt"},
    A2:{w:"1190pt",h:"1683pt"},
    A3:{w:"842pt",h:"1190pt"},
    A4:{w:"595pt",h:"842pt"},
    A5:{w:"419pt",h:"595pt"},
    A6:{w:"297pt",h:"419pt"},
    A7:{w:"209pt",h:"297pt"},
    A8:{w:"147pt",h:"209pt"},
    A9:{w:"104pt",h:"147pt"},
    A10:{w:"73pt",h:"104pt"},
    letter:{w:"612pt",h:"792pt"},
    legal:{w:"612pt",h:"1008pt"},
    tabloid:{w:"792pt",h:"1224pt"}
};*/

var docSettingsMM = {
  A4: { w: 210, h: 297 },
  A3: { w: 297, h: 420 },
  A5: { w: 148, h: 210 },
  legal: { w: 215.9, h: 355.6 },
  letter: { w: 215.9, h: 279.4 },
  tabloid: { w: 279.4, h: 431.8 }
};

var catcherSize = 0;

var ctrlsactions = { cdownload: Ctrl("downlpdf_cont") };
ctrlsactions = null;

var maxWidth = 50;
var divLen = 175;
var lenFactor = divLen / maxWidth;  // 175 lunghezza max in px, 50 lunghezza max considerata del campo

var jsPDFPageFormats = { // Size in pt of various paper formats - PORTRAIT w/h
  'a10': [73.70, 104.88], 'c10': [79.37, 113.39], 'b10': [87.87, 124.72], 'a9': [104.88, 147.40],
  'c9': [113.39, 161.57], 'b9': [124.72, 175.75], 'a8': [147.40, 209.76], 'credit-card': [153, 243],
  'c8': [161.57, 229.61], 'b8': [175.75, 249.45], 'a7': [209.76, 297.64], 'c7': [229.61, 323.15],
  'b7': [249.45, 354.33], 'a6': [297.64, 419.53], 'dl': [311.81, 623.62], 'c6': [323.15, 459.21],
  'b6': [354.33, 498.90], 'a5': [419.53, 595.28], 'c5': [459.21, 649.13], 'b5': [498.90, 708.66],
  'junior-legal': [576, 360], 'government-letter': [576, 756], 'a4': [595.28, 841.89], 'letter': [612, 792],
  'legal': [612, 1008], 'c4': [649.13, 918.43], 'b4': [708.66, 1000.63], 'tabloid': [792, 1224],
  'a3': [841.89, 1190.55], 'c3': [918.43, 1298.27], 'b3': [1000.63, 1417.32], 'a2': [1190.55, 1683.78],
  'ledger': [1224, 792], 'c2': [1298.27, 1836.85], 'b2': [1417.32, 2004.09], 'a1': [1683.78, 2383.94],
  'c1': [1836.85, 2599.37], 'b1': [2004.09, 2834.65], 'a0': [2383.94, 3370.39], 'c0': [2599.37, 3676.54],
  'b0': [2834.65, 4008.19]
};

/** fine **/

/** GESTIONE MAP ITEMS **/
function getAreaItems(zone) {
  if (mapItems[zone]) return mapItems[zone];
  else return [];
}

function getItemsHTMLIndex(id) {
  return idItemsHTML.indexOf(id);
}

function getUidItemsHTMLIndex(uid) {
  return uidItemsHTML.indexOf(uid);
}
/** fine **/

/* Gestione validfunc itemsObj */
function SetPrintProp(value, prop, keepMenu) {
  setLoading();
  formProp[prop] = value;
  if (prop == 'pformat') {
    var i;
    updateMCurrentObj("page.format", value);
    var l = document.getElementsByClassName('pcustom');
    if (value == 'custom') {
      for (i = l.length - 1; i >= 0; i--)
        $(l[i].id).removeClass("hiddenAdd");
      if (Ctrl(prop) && Ctrl(prop).parentNode)
        $(Ctrl(prop).parentNode.id).addClass("pfContainerCustom");
      updateMCurrentObj("page.width", formProp.pwidth);
      updateMCurrentObj("page.height", formProp.pheight);
    }
    else {
      for (i = l.length - 1; i >= 0; i--)
        $(l[i].id).addClass("hiddenAdd");
      if (Ctrl(prop) && Ctrl(prop).parentNode)
        $(Ctrl(prop).parentNode.id).removeClass("pfContainerCustom");
    }

  }
  else if (prop == 'pwidth')
    updateMCurrentObj("page.width", value);
  else if (prop == 'pheight')
    updateMCurrentObj("page.height", value);
  else if (prop == 'porientation')
    updateMCurrentObj("page.orientation", value);
  else if (prop == 'mtheight')
    updateMCurrentObj("page.margins.top", value);
  else if (prop == 'mbheight')
    updateMCurrentObj("page.margins.bottom", value);
  else if (prop == 'mlwidth')
    updateMCurrentObj("page.margins.left", value);
  else if (prop == 'mrwidth')
    updateMCurrentObj("page.margins.right", value);
  pushToHistory();
  drawEditor(keepMenu);
  return true;
}

function SetDatasourceProp(/*value, prop*/) {
}
/* fine*/

function enableZone(zone) {
  var obj = Ctrl(zone + "op");
  if (!Empty(obj)) {
    if (obj.className == 'div_toggler') obj.className = 'div_togglerclose';
    else obj.className = 'div_toggler';
  }

  var enablez = "";
  if (Ctrl(zone)) {
    var zc = Ctrl(zone + "content");
    if (zc) {
      if (zc.style.display == 'none') enablez = 'block';
      else enablez = 'none';
      zc.style.display = enablez;
    }
    zc = Ctrl(zone + "limit");
    if (zc) zc.style.display = enablez;
    drawLimitBars();
  }
}

/* *** Gestione Spostamento item *** */
var dragBars = new Object();
dragBars.zOrder = 50;
var draggingHandler;
var draggingHandlerCorner;
var draggedItemIdx;
var dragSelection = false;

function dragBar(e) {
  if (Empty(e.targetTouches) && ismobile) {
    cancelEvent(e);
    return;
  }

  var obj = GetEventSrcElement(e),
    id = "limitbar";
  if (obj.id.indexOf("handler") >= 0)  // mi muovo sugli handler
    id = "limithandler";
  var objcontent = Ctrl(Strtran(obj.id, id, 'content'));
  var objcontentitem = Ctrl(Strtran(obj.id, id, 'contentitems'));
  dragBars.obj = Ctrl(Strtran(obj.id, id, 'limitbar'));
  dragBars.objH = obj;

  dragBars.downY = (e.offsetY) ? e.offsetY : (e.layerY) ? e.layerY : 0;
  dragBars.downY = dragBars.downY + Ctrl("backcanvas").offsetTop - Ctrl("backcanvas").scrollTop;

  dragBars.objcontent = objcontent;
  var allItems = objcontentitem.childNodes;
  var max = 0;
  for (var i = 0; i < allItems.length; i++) {
    max = Math.max(max, allItems[i].offsetTop + allItems[i].offsetHeight);
  }

  dragBars.MaxPossibleTop = Math.max(max, objcontent.offsetTop);
  dragBars.MaxPossibleDown = -1;

  if (!Empty(e.targetTouches)) {
    dragBars.objH.addEventListener("touchmove", dragBarStart);
    dragBars.objH.addEventListener("touchend", dragBarEnd);
  }
  else {
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
  }
}

function dragBarStart(e) {
  e = (e) ? e : window.event;
  var y;
  if (Empty(e.targetTouches))
    y = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY + document.documentElement.scrollTop + document.body.scrollTop : 0;
  else
    y = (e.targetTouches[0].pageY) ? e.targetTouches[0].pageY : (e.targetTouches[0].clientY) ? e.targetTouches[0].clientY + document.documentElement.scrollTop + document.body.scrollTop : 0; // eslint-disable-line max-len
  // Move drag element by the amount the cursor has moved.
  if (window.closeEditInput) window.closeEditInput(e);
  var newY = (y - dragBars.downY);
  if (newY < 0) { newY = 0; }
  if (newY > dragBars.MaxPossibleTop) {
    if (dragBars.MaxPossibleDown > -1) {
      if (newY < dragBars.MaxPossibleDown) {
        dragBars.obj.style.borderTopWidth = "1px";
        dragBars.obj.style.top = newY + "px";
        dragBars.objH.style.top = newY + "px";
      }
    }
    else {
      dragBars.obj.style.borderTopWidth = "1px";
      dragBars.obj.style.top = newY + "px";
      dragBars.objH.style.top = newY + "px";
    }
  }

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
  if (Empty(e.targetTouches)) {
    if (document.removeEventListener) {
      document.removeEventListener("mousemove", dragBarStart, true);
      document.removeEventListener("mouseup", dragBarEnd, true);
    }
    else if (document.detachEvent) {
      document.detachEvent("onmousemove", dragBarStart);
      document.detachEvent("onmouseup", dragBarEnd);
    }
  }
  else {
    dragBars.objH.removeEventListener("touchmove", dragBarStart);
    dragBars.objH.removeEventListener("touchend", dragBarEnd);
  }

  document.body.style.cursor = "default";

  dragBars.obj.style.borderTopWidth = "0px";
  dragBars.objcontent.style.height = (dragBars.obj.offsetTop - dragBars.objcontent.offsetTop) + "px";

  var zone = Strtran(dragBars.objcontent.id.replace(/[0-9]/g, ""), "content", "");
  updateMCurrentObj(zone + ".height", dragBars.objcontent.offsetHeight);
  pushToHistory();
  drawLimitBars();

  Ctrl("canvas").onmousedown = beginDragSelection;
  Ctrl("canvas").onmouseup = endDragSelection;

  SetOnEditProp(false);
  cancelEvent(e);
}


function dragBarZone(e) {
  if (Empty(e.targetTouches) && ismobile) {
    cancelEvent(e);
    return;
  }

  var obj = GetEventSrcElement(e);
  var id = "limitbar";
  var rid = "limitbar";
  var zlimit = false;
  if (obj.id.indexOf("handler") >= 0)  // mi muovo sugli handler
    id = "limithandler";

  if (obj.id.indexOf('zlimit') > 0) {
    zlimit = true;
    rid = 'z' + rid;
    id = 'z' + id;
  }
  var objcontent = Ctrl(Strtran(obj.id, id, ''));
  var objcontentitem = objcontent;
  dragBars.obj = Ctrl(Strtran(obj.id, id, rid));
  dragBars.objH = obj;

  dragBars.downY = (e.offsetY) ? e.offsetY : (e.layerY) ? e.layerY : 0;
  dragBars.downY = dragBars.downY + Ctrl("backcanvas").offsetTop - Ctrl("backcanvas").scrollTop;

  dragBars.objcontent = objcontent;
  var allItems, max, i;
  if (zlimit == false) {
    allItems = objcontentitem.childNodes;
    max = 0;
    for (i = 0; i < allItems.length; i++) {
      max = Math.max(max, getY(allItems[i]) - Ctrl("backcanvas").offsetTop + allItems[i].offsetHeight);
    }
    dragBars.MaxPossibleTop = Math.max(max, objcontent.offsetTop);
    dragBars.MaxPossibleDown = -1;
  }
  else {
    allItems = objcontentitem.childNodes;
    max = getY(objcontent) - Ctrl("backcanvas").offsetTop + objcontent.offsetHeight;
    for (i = 0; i < allItems.length; i++) {
      max = Math.min(max, getY(allItems[i]) - Ctrl("backcanvas").offsetTop);
    }
    dragBars.MaxPossibleTop = 0;
    dragBars.MaxPossibleDown = max;
  }

  if (!Empty(e.targetTouches)) {
    dragBars.objH.addEventListener("touchmove", dragBarZoneStart);
    dragBars.objH.addEventListener("touchend", dragBarZoneEnd);
  }
  else {
    cancelEvent(e);
    if (document.addEventListener) {
      document.addEventListener("mousemove", dragBarZoneStart, true);
      document.addEventListener("mouseup", dragBarZoneEnd, true);
    }
    else if (document.attachEvent) {
      document.attachEvent("onmousemove", dragBarZoneStart);
      document.attachEvent("onmouseup", dragBarZoneEnd);
      return false;
    }
  }
}

function dragBarZoneStart(e) {
  dragBarStart(e);
}

function dragBarZoneEnd(e) {
  // Stop capturing mousemove and mouseup events.
  setLoading();
  if (Empty(e.targetTouches)) {
    if (document.removeEventListener) {
      document.removeEventListener("mousemove", dragBarZoneStart, true);
      document.removeEventListener("mouseup", dragBarZoneEnd, true);
    }
    else if (document.detachEvent) {
      document.detachEvent("onmousemove", dragBarZoneStart);
      document.detachEvent("onmouseup", dragBarZoneEnd);
    }
  }
  else {
    dragBars.objH.removeEventListener("touchmove", dragBarZoneStart);
    dragBars.objH.removeEventListener("touchend", dragBarZoneEnd);
  }

  document.body.style.cursor = "default";
  dragBars.obj.style.borderTopWidth = "0px";
  var newh = (getY(dragBars.obj) - getY(dragBars.objcontent));
  Ctrl("canvas").onmousedown = beginDragSelection;
  Ctrl("canvas").onmouseup = endDragSelection;

  SetOnEditProp(false);
  cancelEvent(e);

  var zone = Strtran(dragBars.objcontent.id.replace(/[0-9]/g, ""), "zpagem", "");
  if (dragBars.obj.id.indexOf('zlimit') >= 0) {
    if (m_CurrentObj != null) {
      updateMCurrentObj(zone + ".height", dragBars.objcontent.offsetHeight - newh);
      zone = m_CurrentObj[zone];
      for (var k = 0; k < zone.items.length; k++) {
        var c = zone.items[k].position.yRelative;
        c = c - newh;
        updateObject(zone.items[k], "position.yRelative", c);
      }
    }
  }
  else {
    updateMCurrentObj(zone + ".height", newh);
  }
  pushToHistory();
  drawEditor();
}


var marginminlimit = 50;
var viewcurrpage = "page1";
function dragMargin(e) {
  if (Empty(e.targetTouches) && ismobile) {
    cancelEvent(e);
    return;
  }
  var obj = GetEventSrcElement(e);
  var cp;
  if (obj.id.indexOf("margintop") >= 0 || obj.id.indexOf("marginbottom") >= 0) {
    dragBars.downY = (e.offsetY) ? e.offsetY : (e.layerY) ? e.layerY : 0;
    dragBars.downY = dragBars.downY + Ctrl("backcanvas").offsetTop - Ctrl("backcanvas").scrollTop;
    cp = getY(Ctrl(viewcurrpage)) - Ctrl("backcanvas").offsetTop;
    dragBars.type = 'y';
  }
  else {
    dragBars.downY = (e.offsetX) ? e.offsetX : (e.layerX) ? e.layerX : 0;
    dragBars.downY = dragBars.downY + Ctrl("backcanvas").offsetLeft - Ctrl("backcanvas").scrollLeft;
    cp = getX(Ctrl(viewcurrpage)) - Ctrl("backcanvas").offsetLeft;
    dragBars.type = 'x';
  }
  if (obj.id.indexOf("margintop") >= 0) {
    dragBars.MaxPossibleTop = cp;
    dragBars.MaxPossibleDown = cp + gwork.hh - gwork.marginb - marginminlimit;
    dragBars.obj = Ctrl("margintop");
    dragBars.p_ref = getY(Ctrl(viewcurrpage)) - Ctrl("backcanvas").offsetTop;
    dragBars.propID = 'mtheight';
  }
  else if (obj.id.indexOf("marginbottom") >= 0) {
    dragBars.MaxPossibleTop = cp + gwork.margint + marginminlimit;
    dragBars.MaxPossibleDown = cp + gwork.hh;
    dragBars.obj = Ctrl("marginbottom");
    dragBars.p_ref = Ctrl(viewcurrpage).offsetTop + Ctrl(viewcurrpage).offsetHeight + 1;
    dragBars.propID = 'mbheight';
  }
  else if (obj.id.indexOf("marginleft") >= 0) {
    dragBars.MaxPossibleTop = cp;
    dragBars.MaxPossibleDown = cp + gwork.ww - gwork.marginr - marginminlimit;
    dragBars.obj = Ctrl("marginleft");
    dragBars.p_ref = getX(Ctrl(viewcurrpage)) - Ctrl("backcanvas").offsetLeft;
    dragBars.propID = 'mlwidth';
  }
  else if (obj.id.indexOf("marginright") >= 0) {
    dragBars.MaxPossibleTop = cp + gwork.marginl + marginminlimit;
    dragBars.MaxPossibleDown = cp + gwork.ww;
    dragBars.obj = Ctrl("marginright");
    dragBars.p_ref = Ctrl(viewcurrpage).offsetLeft + Ctrl(viewcurrpage).offsetWidth + 1;
    dragBars.propID = 'mrwidth';
  }

  if (!Empty(e.targetTouches)) {
    dragBars.obj.addEventListener("touchmove", dragMarginTDStart);
    dragBars.obj.addEventListener("touchend", dragMarginTDEnd);
  }
  else {
    cancelEvent(e);
    if (document.addEventListener) {
      document.addEventListener("mousemove", dragMarginTDStart, true);
      document.addEventListener("mouseup", dragMarginTDEnd, true);
    }
    else if (document.attachEvent) {
      document.attachEvent("onmousemove", dragMarginTDStart);
      document.attachEvent("onmouseup", dragMarginTDEnd);
      return false;
    }
  }

}

function dragMarginTDStart(e) {
  e = (e) ? e : window.event;
  var y;
  if (dragBars.type == 'y') {
    if (Empty(e.targetTouches))
      y = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY + document.documentElement.scrollTop + document.body.scrollTop : 0;
    else
      y = (e.targetTouches[0].pageY) ? e.targetTouches[0].pageY : (e.targetTouches[0].clientY) ? e.targetTouches[0].clientY + document.documentElement.scrollTop + document.body.scrollTop : 0;// eslint-disable-line max-len
  }
  else {
    if (Empty(e.targetTouches))
      y = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX + document.documentElement.scrollLeft + document.body.scrollLeft : 0;
    else
      y = (e.targetTouches[0].pageX) ? e.targetTouches[0].pageX : (e.targetTouches[0].clientX) ? e.targetTouches[0].clientX + document.documentElement.scrollLeft + document.body.scrollLeft : 0;// eslint-disable-line max-len
  }
  if (window.closeEditInput) window.closeEditInput(e);
  var newY = (y - dragBars.downY);
  if (newY < 0) { newY = 0; }
  if (newY >= dragBars.MaxPossibleTop && newY <= dragBars.MaxPossibleDown) {
    if (dragBars.type == 'y')
      dragBars.obj.style.top = newY + "px";
    else
      dragBars.obj.style.left = newY + "px";
    var c = Math.abs(dragBars.p_ref - newY);
    Ctrl(dragBars.obj.id + "_int").innerHTML = convertPxToString(c, workunit);
  }

  if (dragBars.type == 'y') document.body.style.cursor = "n-resize";
  else document.body.style.cursor = "e-resize";
  Ctrl("canvas").onmousedown = null;
  Ctrl("canvas").onmouseup = null;
  if (e.preventDefault) {
    e.preventDefault();
  }
  else {
    return false;
  }
}

function dragMarginTDEnd(e) {
  // Stop capturing mousemove and mouseup events.
  if (Empty(e.targetTouches)) {
    if (document.removeEventListener) {
      document.removeEventListener("mousemove", dragMarginTDStart, true);
      document.removeEventListener("mouseup", dragMarginTDEnd, true);
    }
    else if (document.detachEvent) {
      document.detachEvent("onmousemove", dragMarginTDStart);
      document.detachEvent("onmouseup", dragMarginTDEnd);
    }
  }
  else {
    dragBars.obj.removeEventListener("touchmove", dragMarginTDStart);
    dragBars.obj.removeEventListener("touchend", dragMarginTDEnd);
  }

  document.body.style.cursor = "default";

  var c;
  if (dragBars.type == 'y') c = Math.abs(dragBars.p_ref - dragBars.obj.offsetTop);
  else c = Math.abs(dragBars.p_ref - dragBars.obj.offsetLeft);
  var str = convertPxToString(c, workunit);
  SetPrintProp(str, dragBars.propID);

  Ctrl("canvas").onmousedown = beginDragSelection;
  Ctrl("canvas").onmouseup = endDragSelection;

  SetOnEditProp(false);
  cancelEvent(e);
}

/* *** Gestione dei tab del report *** */
function selectReportPage(pageindex) {
  pageindex = parseInt(pageindex);
  if (Ctrl("docview_combolabel")) Ctrl("docview_combolabel").selectedIndex = pageindex;
  setSelectedTab(pageindex);
  if (formProp.page == pageindex) { return; }
  formProp.page = pageindex;
  index = null;
  setLoading();
  if (formProp.page == 0)
    viewMode = designView;
  else if (formProp.page == 1)
    viewMode = documentView;
  else
    viewMode = pdfView;
  drawEditor();
  writeHTML(true);
}

function selectReportPageEvent(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var op = propCtrl.options[propCtrl.selectedIndex].value;
  selectReportPage(op)
}

function makeDownloadEvent(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var op = propCtrl.options[propCtrl.selectedIndex].value;
  if (op == 'CSVS')
    makeCsv(true);
  else if (op == 'CSV')
    makeCsv(false);
  else if (op == 'SDF')
    makeCsv(false, false);
  else if (op == 'XML')
    makeXml(false);
  else if (op == 'XMLS')
    makeXml(true);
  propCtrl.selectedIndex = 0;
}

function setSelectedTab(index) {
  // solo per due pulsanti
  var btns = formProp.objClass.newProperties.leftToolbar_2;
  for (var i = 0; i < btns.length; i++) {
    Ctrl(btns[i].propID + "_cont").removeClass("menuopen");
    if (!$(btns[i].propID + "_cont").hasClass("hiddenAdd")) {
      if (index == 0)
        $(btns[i].propID + "_cont").addClass("disabledpic");
      else
        $(btns[i].propID + "_cont").removeClass("disabledpic");
    }
  }

  disableItemButtons();
}

// Ridisegna i tabs.
function resetTabs() {
  if (tabs) {
    $('navmenu_tabcontainer').setStyles({
      'left': $('backcanvas').getPosition().x,
      'width': $('backcanvas').getSize().x
    });
    tabs.refresh();
  }
}
/* *** Fine della gestione dei tab del report *** */

function HideElementsByClass(classname, ctrl) {
  var l;
  if (!Empty(ctrl)) l = ctrl.getElementsByClassName(classname);
  else l = document.getElementsByClassName(classname);
  for (var i = 0; i < l.length; i++)
    $(l[i].id).addClass("hiddenAdd");
}

function HideVisibilityElementsByClass(classname, ctrl) {
  var l;
  if (!Empty(ctrl)) l = ctrl.getElementsByClassName(classname);
  else l = document.getElementsByClassName(classname);
  for (var i = 0; i < l.length; i++)
    $(l[i].id).addClass("hiddenVisibilityAdd");
}

function ShowElementsByClass(classname, ctrl) {
  var l;
  if (!Empty(ctrl)) l = ctrl.getElementsByClassName(classname);
  else l = document.getElementsByClassName(classname);
  for (var i = l.length - 1; i >= 0; i--)
    $(l[i].id).removeClass("hiddenAdd");
}

var maskobj = null;
var maskparams;
function drawEditor(keepMenu) {
  Ctrl("toolbarZ").style.visibility = "hidden";
  removeAllHandlers();
  $("tooltip_box").addClass("hiddenAdd");
  if (!keepMenu)
    resetMenuItems();
  var fnToDelayx = function () {
    if (m_CurrentObj == null) {
      m_CurrentObj = getFromDesignObj();
      pushToHistory();
    }
    if (viewMode != pdfView) {
      Ctrl("backcanvas").style.overflow = "auto";
      showToolbarElements(pdfView);
      viewRulersAndGrid("show");
      if (viewMode == designView) {
        mindex = null;
        gwork = {}
        gwork.marginl = 0;
        gwork.margint = 0;
        HideElementsByClass(documentView);
        HideElementsByClass(pdfView);
        HideElementsByClass(pdfViewD);
        ShowElementsByClass(designView);
        Ctrl("canvasdocprev").innerHTML = "";
        selectReportPage(0);
        Ctrl("gadgets_panerightbar").style.visibility = "visible";
        if (!Ctrl("gadgets_pane").opened)
          $("gadgets_panerightbar").click();
        if ($("fieldslist-toggler-document").hasClass("opened")) {
          $("fieldslist-toggler-document").click();
          $("fieldslist-toggler-document").click();
        }
        else
          $("fieldslist-toggler-document").click();

        resetZones();
        countindex = 0;
        itemsHTML = [];
        nitem = 0;
        orderMCurrentItemsByZone();
        decodeReportObj(m_CurrentObj, formProp.repcustom);
        Ctrl("backcanvas").scrollTop = 0;
        Ctrl("backcanvas").scrollLeft = 0;
        viewcurrpage = "page1";
        drawFieldLegend("fieldLegend");
        ShowElementsByClass("fieldDescIcon");
      }
      else if (viewMode == documentView) {
        Ctrl('canvasdocprev').style.height = "";
        mindex = null;
        Ctrl("gadgets_panerightbar").style.visibility = "hidden";
        if (Ctrl("gadgets_pane").opened) {
          $("gadgets_panerightbar").click();
        }
        HideElementsByClass(designView);
        HideElementsByClass(pdfView);
        HideElementsByClass(pdfViewD);
        ShowElementsByClass(documentView);
        Ctrl("toolbarMenu").style.visibility = "visible";
        if (Ctrl("gparam_cont")) Ctrl("gparam_cont").style.display = "block";
        if (maskobj == null) {
          if (Ctrl("gparam_cont"))
            $("gparam_cont").addClass("disabledpic");
        }
        else {
          if (Ctrl("gparam_cont"))
            $("gparam_cont").removeClass("disabledpic");
        }
        resetMenuToolbar();
        resetZones();
        countindex = 0;
        itemsHTML = [];
        nitem = 0;
        clearAllZones();
        loadFields();
        Ctrl("fieldLegend").innerHTML = "";
        if ((!Empty(formProp.datasource) || !Empty(formProp.vdmfile)) && maskobj === null) {
          if (execMaskParameters(formProp.datasource, formProp.vdmfile)) {
            return;
          }
          else {
            JSRepDrawDocumentView(m_CurrentObj, "html", maskparams, Ctrl('canvasdocprev'), null, null, null, maskobj.datasource);
            maskobj = null;
            HideElementsByClass("fieldDescIcon");
          }
        }
        else {
          if (maskobj === null)
            JSRepDrawDocumentView(m_CurrentObj, "html", maskparams, Ctrl('canvasdocprev'), null, null, null, formProp.datasource);
          else
            JSRepDrawDocumentView(m_CurrentObj, "html", maskparams, Ctrl('canvasdocprev'), null, null, null, maskobj.datasource);
          HideElementsByClass("fieldDescIcon");
          //$("pages").removeClass("disabledpic");
        }
      }
      generateRulers(workunit);
      updateFieldSwitch();

      if (Ctrl("toolbarP").offsetHeight != defaultPosRef) { // defaultPosRef default Fusion Site
        var dif = Ctrl("toolbarP").offsetHeight - defaultPosRef;
        defaultPosRef = Ctrl("toolbarP").offsetHeight;
        var divs = ["h_ruler", "gadgets_pane", "rulergridopt", "backcanvas", "v_ruler", "v_ruler_zones"];
        for (var k = 0; k < divs.length; k++) {
          Ctrl(divs[k]).style.top = (Ctrl(divs[k]).offsetTop + dif) + "px";
        }
        if (Ctrl('i_mask_wrapper_parent').offsetHeight == 0) {
          showMask();
          Ctrl('i_mask_wrapper_parent').style.top = (Ctrl('i_mask_wrapper_parent').offsetTop + dif) + "px";
          hideMask()
        }
        else {
          Ctrl('i_mask_wrapper_parent').style.top = (Ctrl('i_mask_wrapper_parent').offsetTop + dif) + "px";
        }
      }
    }
    else {
      var i;
      var lz = document.getElementsByClassName("limitbar");
      for (i = 0; i < lz.length; i++) {
        $(lz[i].id).addClass("hiddenAdd");
      }
      lz = document.getElementsByClassName("limithandler");
      for (i = 0; i < lz.length; i++) {
        $(lz[i].id).addClass("hiddenAdd");
      }
      Ctrl("backcanvas").style.overflow = "hidden";
      mindex = null;
      Ctrl("gadgets_panerightbar").style.visibility = "hidden";
      if (Ctrl("gadgets_pane").opened)
        $("gadgets_panerightbar").click();
      HideElementsByClass(designView);
      HideElementsByClass(documentView);
      setBackCanvasSize(Ctrl("canvasdocprev"));
      Ctrl("canvasdocprev").innerHTML = "";
      $("canvasdocprev").removeClass("hiddenAdd");
      ShowElementsByClass(pdfView);
      HideElementsByClass(pdfViewD);
      if (Ctrl("gparam_cont")) Ctrl("gparam_cont").style.display = "block";
      if (maskobj == null) {
        if (Ctrl("gparam_cont"))
          $("gparam_cont").addClass("disabledpic");
      }
      else {
        if (Ctrl("gparam_cont"))
          $("gparam_cont").removeClass("disabledpic");
      }
      resetMenuToolbar();
      resetZones();
      countindex = 0;
      itemsHTML = [];
      nitem = 0;
      clearAllZones();
      hideToolbarElements(pdfView);
      viewRulersAndGrid("hide");
      if ((!Empty(formProp.datasource) || !Empty(formProp.vdmfile)) && maskobj == null) {
        if (execMaskParameters(formProp.datasource, formProp.vdmfile)) {
          return;
        }
        else {
          JSRepDrawDocumentView(m_CurrentObj, "pdf", maskparams, Ctrl('canvasdocprev'), null, ctrlsactions, null, maskobj.datasource);
          maskobj = null;
        }
      }
      else {
        if (maskobj === null)
          JSRepDrawDocumentView(m_CurrentObj, "pdf", maskparams, Ctrl('canvasdocprev'), null, ctrlsactions, null, formProp.datasource);
        else
          JSRepDrawDocumentView(m_CurrentObj, "pdf", maskparams, Ctrl('canvasdocprev'), null, ctrlsactions, null, maskobj.datasource);
      }
    }
    //Ctrl("toolbarZ").style.marginTop = Ctrl("toolbarP").offsetHeight + "px";
    Ctrl("toolbarZ").style.visibility = "visible";
    Ctrl('loading').style.display = 'none';
  };
  fnToDelayx.delay(100);
}

function setBackCanvasSize(mdiv) {
  //mdiv.style.width = Ctrl("backcanvas").offsetWidth+"px";
  mdiv.style.height = Ctrl("backcanvas").offsetHeight + "px";
}

function hideToolbarElements(c) {
  var btns = Ctrl("toolbarItems").childNodes;
  for (var i = 0; i < btns.length; i++) {
    if (btns[i].id != "gparam_btn") {
      if (!$(btns[i].id).hasClass(c))
        $(btns[i].id).addClass("hiddenAdd");
      else
        $(btns[i].id).removeClass("hiddenAdd");
    }
  }

  if (!$("toolbarMenu").hasClass(c))
    $("toolbarMenu").addClass("hiddenAdd");
}

function showToolbarElements(c) {
  var btns = Ctrl("toolbarItems").childNodes;
  for (var i = 0; i < btns.length; i++) {
    if (btns[i].id != "gparam_btn") {
      if (!$(btns[i].id).hasClass(c))
        $(btns[i].id).removeClass("hiddenAdd");
      else
        $(btns[i].id).addClass("hiddenAdd");
    }
  }

  if (!$("toolbarMenu").hasClass(c))
    $("toolbarMenu").removeClass("hiddenAdd");
}

function viewRulersAndGrid(act) {
  if (act == "show") {
    $("h_ruler").removeClass("hiddenAdd");
    $("v_ruler").removeClass("hiddenAdd");
    $("v_ruler_zones").removeClass("hiddenAdd");
    $("rulergridopt").removeClass("hiddenAdd");
  }
  else {
    $("h_ruler").addClass("hiddenAdd");
    $("v_ruler").addClass("hiddenAdd");
    $("v_ruler_zones").addClass("hiddenAdd");
    $("rulergridopt").addClass("hiddenAdd");
  }
}

function getAbsolutePos(el) {
  for (var lx = 0, ly = 0;
    el != null;
    lx += el.offsetLeft, ly += el.offsetTop, el = el.offsetParent);
  return { x: lx, y: ly };
}

function selectvqr(name) {
  name = Empty(name) ? "fielddatasource" : name;
  PickItems('visualquery', name, null, null, 930, 600);
}

function selectvdm(name) {
  name = Empty(name) ? "vdmfileinput" : name;
  PickItems("maskparameters", name, null, null, 930, 600);
}

function editvqr(/*index*/) {
  if (Lower(Left(formProp.datasource, 3)) == "bo:")
    PSAlert.alert("You cannot edit a BO.");
  else if (LRTrim(formProp.datasource) == "")
    PSAlert.alert("No query selected.");
  else if (parent.newCurrentObj != null)
    parent.newCurrentObj(formProp.datasource, "visualquery", { offlinemode: URLenc(isoffline) });
  else
    window.open("../visualquery/index.jsp?filename=" + formProp.datasource + "&offlinemode=" + URLenc(isoffline), "visualquery", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}

function newvqr() {
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1)
    parent.newCurrentObj('New', 'visualquery', { offlinemode: URLenc(isoffline) });
  else
    window.open("../visualquery/index.jsp", "visualquery", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}

function newvdm() {
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj("New", "maskparameters", {});
  }
  else {
    window.open("../maskparameters/maskparameters.jsp", "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function editvdm() {
  var vdmFile = formProp.vdmfile;
  if (LRTrim(vdmFile) == "") {
    PSAlert.alert("No mask file selected.");
    return;
  }
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj(vdmFile, "maskparameters");
  }
  else {
    window.open("../maskparameters/maskparameters.jsp?filename=" + vdmFile, "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}
//
function ExpressionBuilderReturn(id, value, params) { //REDEFINED
  isoffline = (params.offlinemode) ? true : false;
  if (id) {
    var el = Ctrl(id);
    if (el) {
      el.value = value;
      el.focus();
      el.blur();
    }
  }
  SetUpdated();
}

function selectbo() {
  var url = "selectDatasource.jsp?datasource=bo&offlinemode=" + isoffline + "&callerFunction=loadbo";
  var additionalUrl = "width=800,height=535";
  layerOpenForeground(url, "boSPModalLayer", additionalUrl, "", "", "", 1);  // messo x mobile
}

function loadbo(boname, params) {
  if (params && params.offlinemode)
    isoffline = params.offlinemode;
  Ctrl("fielddatasource").value = boname;
  loadFieldsInput();
}

function ValidMove(x, y, w, h, id, item, moving) {
  var ret = true;
  if (x < 0 || y < 0) {
    ret = false;
  }
  if (viewMode != designView) {
    var borders = 0;
    ret = false;
    var py = getY(Ctrl(item.id).parentNode) - Ctrl("backcanvas").offsetTop;
    var limit = py + Ctrl(item.id).parentNode.offsetHeight; // bordi
    var px = getX(Ctrl(item.id).parentNode) - Ctrl("backcanvas").offsetLeft;
    if ((y >= py && (y + h + borders) <= limit) && x >= px)
      ret = true;
    else
      item.y = y;
  }
  else {
    var ctrl = Ctrl(Strtran(item.zone, "contentitems", ""));
    if (!Empty(ctrl)) {
      var barW = ctrl.offsetWidth;
      var itW = Ctrl(item.shadow).offsetWidth + Ctrl(item.shadow).offsetLeft;
      if (barW < itW) {
        var diff = itW - barW;
        resizeWindow();
        Ctrl("canvas").style.width = (Ctrl("canvas").offsetWidth + diff) + "px";
        drawLimitBars();
      }

      var barY = ctrl.offsetTop;
      if (barY > y && moving == 4) {
        ret = false;
      }
    }
  }
  return ret;
}

/* Gestione e disegno switch on-off con scritta*/
function drawZonesSwitch(zoneBarObj, zoneBarName/*, margin*/) {
  var pobj, pID;
  for (var j = 0; j < zoneBarObj.length; j++) {
    pobj = {};
    if (zoneBarObj[j].propID)
      pobj.propID = zoneBarName + "_" + zoneBarObj[j].propID;
    else
      pobj.propID = zoneBarName + "_" + Strtran(zoneBarObj[j].name, " ", "");

    pID = zoneBarName;
    if (zoneBarName == "groupbreak")
      pID = zoneBarName + "contentswitch";
    pobj.margin = 2;
    pobj.actions = zoneBarObj[j].actions;
    pobj.name = zoneBarObj[j].name;
    pobj.tooltip = getTranslated(zoneBarObj[j].tooltip_code, zoneBarObj[j].tooltip);
    drawSwitch(pobj, pID, zoneBarObj[j].defaultValue);
  }

  removeSpanTag();
}

function manageOnOff(e, src, isfield) {
  e = !e ? window.event : e;
  var btn;
  if (!Empty(src))
    btn = src;
  else
    btn = Ctrl(GetEventSrcElement(e).getAttribute("data-prop"));

  btn.dispatchEvent(new MouseEvent("click"));

  if (Ctrl(btn.id + "onoffswitch")) {
    if (btn.checked)
      Ctrl(btn.id + "onoffswitch").style.right = 2 + "px";
    else
      Ctrl(btn.id + "onoffswitch").style.right = (btn.parentNode.offsetWidth - 20 - 2) + "px";
  }

  var prop = btn.id.substring(btn.id.indexOf("_") + 1, btn.id.length);

  if (formProp[prop] != undefined && !isfield) {
    var value = btn.checked;
    formProp[prop] = value;
    if (prop == 'afterPageHeader')
      updateMCurrentObj("reportheader.options.afterPageHeader", value);
    else if (prop == 'beforePageFooter')
      updateMCurrentObj("reportfooter.options.beforePageFooter", value);
    else if (prop == 'startNewPage')
      updateMCurrentObj("groupbreak.options.startNewPage", value);
    else if (prop == 'atEndOfPage')
      updateMCurrentObj("groupfooter.options.atEndOfPage", value);
    else if (prop == 'freprintOnPage')
      updateMCurrentObj("groupfooter.options.reprintOnPage", value);
    else if (prop == 'printOnGroupBreak')
      updateMCurrentObj("groupfooter.options.printOnGroupBreak", value);
    else if (prop == 'hreprintOnPage')
      updateMCurrentObj("groupheader.options.reprintOnPage", value);
    pushToHistory();
  }
  else if (prop == "repcustom")
    formProp[prop] = btn.checked;
  return;
}
/* fine */

/* Gestione e disegno proprieta' toolbar DESIGN VIEW */
function showZone(type, prop) {
  var idZoneH = type + "header";
  var idZoneF = type + "footer";

  if (formProp[prop]) {
    $(idZoneH).removeClass("hiddenZone");
    $(idZoneH + "content").removeClass("hiddenZone");
    $(idZoneH + "limit").removeClass("hiddenZone");
    $(idZoneF).removeClass("hiddenZone");
    $(idZoneF + "content").removeClass("hiddenZone");
    $(idZoneF + "limit").removeClass("hiddenZone");
  }
  else {
    $(idZoneH).addClass("hiddenZone");
    $(idZoneH + "content").addClass("hiddenZone");
    $(idZoneH + "limit").addClass("hiddenZone");
    $(idZoneF).addClass("hiddenZone");
    $(idZoneF + "content").addClass("hiddenZone");
    $(idZoneF + "limit").addClass("hiddenZone");
  }

  drawLimitBars();
}

function showReportZone(e) {
  var prop = GetEventSrcElement(e).id.substring(GetEventSrcElement(e).id.indexOf("_") + 1, GetEventSrcElement(e).id.length);
  var value = GetEventSrcElement(e).checked;
  formProp[prop] = value;
  updateMCurrentObj("showReportZone", formProp[prop]);
  pushToHistory();
  if (viewMode != designView) drawEditor(true);
  else showZone("report", prop);
  updateMCurrentObj("reportheader.height", Ctrl("reportheadercontent").offsetHeight);
  updateMCurrentObj("reportfooter.height", Ctrl("reportfootercontent").offsetHeight);
}

function showPageZone(e) {
  var prop = GetEventSrcElement(e).id.substring(GetEventSrcElement(e).id.indexOf("_") + 1, GetEventSrcElement(e).id.length);
  var value = GetEventSrcElement(e).checked;
  formProp[prop] = value;
  updateMCurrentObj("showPageZone", formProp[prop]);
  pushToHistory();
  if (viewMode != designView) drawEditor(true);
  showZone("page", prop);
  updateMCurrentObj("pageheader.height", Ctrl("pageheadercontent").offsetHeight);
  updateMCurrentObj("pagefooter.height", Ctrl("pagefootercontent").offsetHeight);
}

function showGroupZone(e) {
  var prop = GetEventSrcElement(e).id.substring(GetEventSrcElement(e).id.indexOf("_") + 1, GetEventSrcElement(e).id.length);
  var value = GetEventSrcElement(e).checked;
  formProp[prop] = value;
  updateMCurrentObj("showGroupZone", formProp[prop]);
  pushToHistory();
  if (viewMode != designView) drawEditor(true);
  showZone("group", prop);
  updateMCurrentObj("groupheader.height", Ctrl("groupheadercontent").offsetHeight);
  updateMCurrentObj("groupfooter.height", Ctrl("groupfootercontent").offsetHeight);
}
/* fine */

/* Gestione e disegno proprieta' FONT */
function drawFontDetail(itemObj, props, contID) {
  var pID = "boxcontainer";
  if (!Empty(contID))
    pID = contID;
  currentItem = itemObj;
  var elem;
  var div = null, create = true;
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
    }
    switch (props[i].propID) {
      case "ffamily":
        div.className = "fontContainer";
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_TEXT", "Text");
        div.appendChild(elem);
        Ctrl(pID).appendChild(div);
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "unselectable comboFontName";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        elem.onchange = window[props[i].actions];

        var sp = ZTObjects.fonts_select.split(",");
        for (var j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.textContent = sp[j];
          Ctrl(props[i].propID).appendChild(elem);
        }

        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = false;
        break;
      case "fsize":
        Ctrl(pID).appendChild(div);
        elem = document.createElement("input");
        elem.id = props[i].propID;
        elem.name = props[i].propID;
        elem.className = "inputFontSize";
        elem.type = "text";
        var t = getTranslated(props[i].tooltip_code, props[i].tooltip);
        elem.title = t.split(";")[0];
        div.appendChild(elem);
        elem.onchange = window[props[i].actions.split(",")[0]];
        elem.onfocus = function () { SetOnEditProp(true); };
        elem.onblur = function () { SetOnEditProp(false); };

        elem = document.createElement("div");
        elem.id = props[i].propID + "big";
        elem.className = "unselectable smartreport-icon-increase iconbtnToolbar activeButton";
        elem.title = t.split(";")[1];
        div.appendChild(elem);
        elem.onclick = window[props[i].actions.split(",")[1]];

        elem = document.createElement("div");
        elem.id = props[i].propID + "small";
        elem.className = "unselectable smartreport-icon-decrease iconbtnToolbar activeButton";
        elem.title = t.split(";")[2];
        div.appendChild(elem);
        elem.onclick = window[props[i].actions.split(",")[2]];

        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = true;
        break;
      case "fcolor":
        drawColorPicker(div, props[i]);
        create = true;
        break;
      case "fbold":
      case "fitalic":
      case "funderline":
      case "fleft":
      case "fcenter":
      case "fright":
        if (create) {
          div.className = "fontContainerButtons";
          elem = document.createElement("span");
          elem.className = "shadowtitlediv";
          if (props[i].propID == "fbold")
            elem.textContent = getTranslated("SMR_STYLE", "Style");
          if (props[i].propID == "fleft")
            elem.textContent = getTranslated("SMR_ALIGNMENT", "Alignment");
          div.appendChild(elem);
          Ctrl(pID).appendChild(div);
        }

        elem = document.createElement("div");
        elem.id = props[i].propID;
        elem.className = "unselectable iconbtnToolbar activeButton";
        if (props[i].addclass)
          elem.className += (" " + props[i].addclass);
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        elem.onclick = window[props[i].actions];

        if (!Empty(itemObj[props[i].propID]) && itemObj[props[i].propID] != "normal")
          changeBackgroundIconButton(Ctrl(props[i].propID), true);

        create = false;
        break;
      case "fstrikeout":
        elem = document.createElement("div");
        elem.id = props[i].propID;
        elem.className = "unselectable iconbtnToolbar activeButton";
        if (props[i].addclass)
          elem.className += (" " + props[i].addclass);
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        elem.onclick = window[props[i].actions];

        if (!Empty(itemObj[props[i].propID]) && itemObj[props[i].propID] != "normal")
          changeBackgroundIconButton(Ctrl(props[i].propID), true);

        create = false;
        break;
    }
  }
}

function openColorPicker(id) {
  Ctrl(Strtran(id, "_btn", "")).focus();
}

var currentItem = null;
function setProps(property) {
  if (!property.actions)
    return;
}

function changeBackgroundButton(btn, checked) {
  if (checked)
    $(btn.id).addClass("checked");
  else
    $(btn.id).removeClass("checked");
  return;
}

function changeBackgroundIconButton(btn, checked) {
  if (checked)
    $(btn.id).addClass("iconChecked");
  else
    $(btn.id).removeClass("iconChecked");
  return;
}

function setTypeView(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    currentItem.typeView = propCtrl.value;
  }
  saveEditInput();
}

function setBarcodeType(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    currentItem.barcodetype = propCtrl.value;
  }
  UpdateDesignObj(currentItem, "barcodetype");
  //saveEditInput();
}

function setBarcodeOffColor(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (!Empty(propCtrl.value))
      currentItem.fcoloroff = propCtrl.value;
    else
      currentItem.fcoloroff = "#ffffff";
    UpdateDesignObj(currentItem, "fcoloroff");
  }
  setTimeout(function () {
    Ctrl("colorPickerUI").style.left = (Ctrl("colorPickerUI").offsetLeft - 6) + "px";
    Ctrl("colorPickerUI").style.opacity = 1;
  }, 0);
}

function setBarcodeOnColor(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (!Empty(propCtrl.value))
      currentItem.fcoloron = propCtrl.value;
    else
      currentItem.fcoloron = "#000000";
    UpdateDesignObj(currentItem, "fcoloron");
  }
  setTimeout(function () {
    Ctrl("colorPickerUI").style.left = (Ctrl("colorPickerUI").offsetLeft - 6) + "px";
    Ctrl("colorPickerUI").style.opacity = 1;
  }, 0);
  //if(viewMode != designView) saveEditInput();
}

function setFontFamily(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      Ctrl(idLabel).style.fontFamily = propCtrl.value;
      currentItem[propCtrl.id] = propCtrl.value;
      UpdateDesignObj(currentItem, "font");
    }
  }
  pushToHistory();
}

function setFontSize(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      if (propCtrl.value.indexOf("px") < 0 && propCtrl.value.indexOf("pt") < 0)
        propCtrl.value = propCtrl.value + "pt";
      Ctrl(idLabel).style.fontSize = propCtrl.value;
      currentItem[propCtrl.id] = propCtrl.value;
      UpdateDesignObj(currentItem, "font");
    }
  }
  pushToHistory();
}

function setFontColor(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      Ctrl("fcolorcolorHEX_btn").style.backgroundColor = propCtrl.value;
    }
    else if (currentItem.typeView == "text") {
      idLabel = currentItem.id + "_int";
      if (!Empty(propCtrl.value))
        currentItem.fcolor = propCtrl.value;
      else
        currentItem.fcolor = "#000000";

      Ctrl("fcolorcolorHEX_btn").style.backgroundColor = currentItem.fcolor;
      Ctrl(idLabel).style.color = currentItem.fcolor;
      UpdateDesignObj(currentItem, "font");
    }
  }

  setTimeout(function () {
    Ctrl("colorPickerUI").style.left = (Ctrl("colorPickerUI").offsetLeft - 6) + "px";
    Ctrl("colorPickerUI").style.opacity = 1;
  }, 0);

  pushToHistory();
}

function setBiggerSize(e) {
  var propCtrl = Ctrl(GetEventSrcElement(e || window.event).id.substring(0, GetEventSrcElement(e || window.event).id.indexOf("big")));
  var idLabel = "";
  var unit = 2;
  var uu = "pt";
  if (propCtrl.value.indexOf("px") >= 0)
    uu = "px";
  propCtrl.value = (parseFloat(propCtrl.value) + unit) + uu;
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      Ctrl(idLabel).style.fontSize = propCtrl.value;
      currentItem[propCtrl.id] = propCtrl.value;
      UpdateDesignObj(currentItem, "font");
    }
  }
  pushToHistory();
}

function setSmallerSize(e) {
  var propCtrl = Ctrl(GetEventSrcElement(e || window.event).id.substring(0, GetEventSrcElement(e || window.event).id.indexOf("small")));
  var idLabel = "";
  var unit = 2;
  var uu = "pt";
  if (propCtrl.value.indexOf("px") >= 0)
    uu = "px";
  propCtrl.value = (parseFloat(propCtrl.value) - unit) + uu;
  if ((parseFloat(propCtrl.value) - unit) < 0)
    propCtrl.value = 0 + uu;

  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      Ctrl(idLabel).style.fontSize = propCtrl.value;
      currentItem[propCtrl.id] = propCtrl.value;
      UpdateDesignObj(currentItem, "font");
    }
  }
  pushToHistory();
}

function setBold(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  var value = 'bold';
  if (index != null) {
    if (itemsHTML[index].fbold == value)
      value = 'normal';
    if (itemsHTML[index].isAllFields)
      itemsHTML[index].fbold = value;
  }
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      changeBackgroundIconButton(propCtrl, (!Empty(value) && (value != 'normal')));
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      setFontStyle(propCtrl, idLabel, "fontWeight", value, currentItem);
    }
  }
  pushToHistory();
}

function setItalic(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  var value = 'italic';
  if (index != null) {
    if (itemsHTML[index].fitalic == value)
      value = 'normal';
    if (itemsHTML[index].isAllFields)
      itemsHTML[index].fitalic = value;
  }
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      changeBackgroundIconButton(propCtrl, (!Empty(value) && (value != 'normal')));
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      setFontStyle(propCtrl, idLabel, "fontStyle", value, currentItem);
    }
  }
  pushToHistory();
}

function setUnderline(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  var value = 'underline';
  if (index != null) {
    if (itemsHTML[index].funderline == value)
      value = 'normal,underline';
    if (itemsHTML[index].isAllFields)
      itemsHTML[index].funderline = value;
  }

  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      changeBackgroundIconButton(propCtrl, (!Empty(value) && (value.indexOf('normal') < 0)));
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      setTextStyle(propCtrl, idLabel, "textDecoration", value, currentItem);
    }
  }
  pushToHistory();
}

function setStrikeout(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  var value = 'line-through';
  if (index != null) {
    if (itemsHTML[index].fstrikeout == value)
      value = 'normal,line-through';
    if (itemsHTML[index].isAllFields)
      itemsHTML[index].fstrikeout = value;
  }

  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      changeBackgroundIconButton(propCtrl, (!Empty(value) && (value.indexOf('normal') < 0)));
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      setTextStyle(propCtrl, idLabel, "textDecoration", value, currentItem);
    }
  }
  pushToHistory();
}

function setAlignLeft(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  var value = 'left';
  if (index != null) {
    if (itemsHTML[index].fleft == value)
      value = 'normal';
    if (itemsHTML[index].isAllFields)
      itemsHTML[index].fleft = value;
  }

  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      changeBackgroundIconButton(propCtrl, (!Empty(value) && (value != 'normal')));
      checkAlign(value, (!Empty(value) && (value != 'normal')));
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      setFontStyle(propCtrl, idLabel, "textAlign", value, currentItem);
    }
  }
  pushToHistory();
}

function setAlignCenter(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  var value = 'center';
  if (index != null) {
    if (itemsHTML[index].fcenter == value)
      value = 'normal';
    if (itemsHTML[index].isAllFields)
      itemsHTML[index].fcenter = value;
  }

  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      changeBackgroundIconButton(propCtrl, (!Empty(value) && (value != 'normal')));
      checkAlign(value, (!Empty(value) && (value != 'normal')));
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      setFontStyle(propCtrl, idLabel, "textAlign", value, currentItem);
    }
  }
  pushToHistory();
}

function setAlignRight(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var idLabel = "";
  var value = 'right';
  if (index != null) {
    if (itemsHTML[index].fright == value)
      value = 'normal';
    if (itemsHTML[index].isAllFields)
      itemsHTML[index].fright = value;
  }

  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.isAllFields) {
      changeBackgroundIconButton(propCtrl, (!Empty(value) && (value != 'normal')));
      checkAlign(value, (!Empty(value) && (value != 'normal')));
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (currentItem.typeView != "line" && currentItem.typeView != "image") {
      idLabel = currentItem.id + "_int";
      setFontStyle(propCtrl, idLabel, "textAlign", value, currentItem);
    }
  }
  pushToHistory();
}

function setFontStyle(propCtrl, idLabel, name, value, currentItem) {
  var isChecked;
  if (Empty(value) || (value == 'normal')) {
    isChecked = false;
  }
  else {
    isChecked = true;
  }

  Ctrl(idLabel).style[name] = value;
  currentItem[propCtrl.id] = Ctrl(idLabel).style[name];
  if (name == "textAlign")
    checkAlign(value, isChecked);

  changeBackgroundIconButton(propCtrl, isChecked);
  UpdateDesignObj(currentItem, "font");
}

function setTextStyle(propCtrl, idLabel, name, value, currentItem) {
  var isChecked;
  if (value.indexOf("normal") >= 0) {
    Ctrl(idLabel).style[name] = Strtran(Ctrl(idLabel).style[name], value.split(",")[1], "");
    currentItem[propCtrl.id] = value.split(",")[0];
    isChecked = false;
  }
  else {
    Ctrl(idLabel).style[name] += (" " + value);
    currentItem[propCtrl.id] = value;
    isChecked = true;
  }

  changeBackgroundIconButton(propCtrl, isChecked);
  UpdateDesignObj(currentItem, "font");
}

function checkAlign(type, check) {
  if (check) {
    switch (type) {
      case "left":
        changeBackgroundIconButton(Ctrl("fcenter"), false);
        changeBackgroundIconButton(Ctrl("fright"), false);
        currentItem.fcenter = "normal";
        currentItem.fright = "normal";
        break;
      case "center":
        changeBackgroundIconButton(Ctrl("fleft"), false);
        changeBackgroundIconButton(Ctrl("fright"), false);
        currentItem.fleft = "normal";
        currentItem.fright = "normal";
        break;
      case "right":
        changeBackgroundIconButton(Ctrl("fleft"), false);
        changeBackgroundIconButton(Ctrl("fcenter"), false);
        currentItem.fleft = "normal";
        currentItem.fcenter = "normal";
        break;
    }
  }
  else {
    currentItem.fleft = "normal";
    currentItem.fcenter = "normal";
    currentItem.fright = "normal";
  }
}

function setItemFont(objitem, stObj, cText) {
  if (stObj.style.font.bold)
    cText.style.fontWeight = "bold";
  else
    cText.style.fontWeight = "normal";
  if (stObj.style.font.italic)
    cText.style.fontStyle = "italic";
  else
    cText.style.fontStyle = "normal";
  cText.style.fontSize = stObj.style.font.fontSize;
  cText.style.fontFamily = stObj.style.font.fontName;

  var tmptext = "";
  if (stObj.style.font.underline)
    tmptext += "underline ";
  if (stObj.style.font.strikeout)
    tmptext += "line-through ";
  cText.style.textDecoration = tmptext;

  if (stObj.style.font.center)
    cText.style.textAlign = "center";
  else if (stObj.style.font.right)
    cText.style.textAlign = "right";
  else
    cText.style.textAlign = "left";

  cText.style.color = stObj.style.font.fontColor;
}

function updateFontProperties(itobj, objitem) {
  if (itobj.typeView == "image" || itobj.typeView == "signmup")
    return;
  objitem.ffamily = itobj.style.font.fontName;
  objitem.fsize = itobj.style.font.fontSize;
  objitem.fcolor = itobj.style.font.fontColor;
  objitem.fbold = (itobj.style.font.bold) ? "bold" : "normal";
  objitem.fitalic = (itobj.style.font.italic) ? "italic" : "normal";
  objitem.funderline = (itobj.style.font.underline) ? "underline" : "normal";
  objitem.fstrikeout = (itobj.style.font.strikeout) ? "line-through" : "normal";
  objitem.fleft = (itobj.style.font.left) ? "left" : "normal";
  objitem.fcenter = (itobj.style.font.center) ? "center" : "normal";
  objitem.fright = (itobj.style.font.right) ? "right" : "normal";
  var cText;
  if (itobj.typeView == "barcode")
    cText = Ctrl(objitem.id + "_barcode");
  else
    cText = Ctrl(objitem.id + "_int");
  if (cText) setItemFont(objitem, itobj, cText);
}

function updateBarcodeProperties(itobj, objitem) {
  var cText = Ctrl(objitem.id + "_barcode");
  if (cText)
    generateBarcode(itobj, cText.getAttribute("data-value"), cText, cText.offsetWidth, cText.offsetHeight);
}
/* fine */

/* Gestione e disegno proprieta' IMAGE */
function drawImageDetail(itemObj, props) {
  var pID = "boxcontainer";
  currentItem = itemObj;
  var div = null, create = true;
  var elem = null;
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
      div.className = "imageSearchContainer";
    }

    switch (props[i].propID) {
      case "imgPath":
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_IMAGESRC", "Image source");
        div.appendChild(elem);
        Ctrl(pID).appendChild(div);
        elem = document.createElement("input");
        elem.id = props[i].propID;
        elem.name = props[i].propID;
        elem.className = "inputSearch";
        elem.type = "text";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        elem.value = itemObj[props[i].propID];
        div.appendChild(elem);
        elem.onchange = window[props[i].actions];
        elem.onfocus = function () { SetOnEditProp(true); };
        elem.onblur = function () { SetOnEditProp(false); };
        create = false;
        break;
      case "imgSearch":
        elem = document.createElement("div");
        elem.id = props[i].propID;
        elem.className = "unselectable buttonSearch smartreport-icon-search";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        elem.onclick = window[props[i].actions];
        create = true;
        break;
    }
  }
}

function setImagePath(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (currentItem.typeView == "image") {
      currentItem[propCtrl.id] = /*rootApp +*/ propCtrl.value;
      updateImageItem(currentItem);
    }
  }
}

function updateImageItem(item) {
  if (Empty(item.imgPath)) {
    $(item.id + "_img").addClass("hiddenZone");
    Ctrl(item.id + "_img").src = item.imgPath;
  }
  else {
    $(item.id + "_img").removeClass("hiddenZone");
    Ctrl(item.id + "_img").src = rootApp + item.imgPath;
  }
  UpdateDesignObj(currentItem, "image");
}

var WinOpener;
function searchImage() {
  var url = "../servlet/SPImagePicker?RootDir=images&CanInsert=S&imgnew=false&retTo=imgPath";
  WinOpener = OpenWindow(url, 550, 470, 0, 0);
}

function insertImage(url, imgnew, retTo) {
  currentItem[retTo] = url;
  Ctrl(retTo).value = currentItem[retTo];
  updateImageItem(currentItem);
}
/* fine */

/* Gestione e disegno proprieta' numeri di pagina */
function drawPageNumDetail(itemObj, props) {
  currentItem = itemObj;
  var elem;
  var pID = "boxcontainer";

  var click = "", tmp = "";
  for (var i = 0; i < props.length; i++) {
    switch (props[i].propID) {
      case "pageN":
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboFontName";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        Ctrl(pID).appendChild(elem);
        click = " onchange='" + props[i].actions + "'";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;

        var sp = ZTObjects.pagenum_select.split(",");
        for (var j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //sp[j];
          elem.value = sp[j];
          //SMR_PAGENUMBER //SMR_TOTALPAGES;
          Ctrl(props[i].propID).appendChild(elem);
        }

        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        break;
    };
  }

  Ctrl("canvas").onmousedown = saveEditInput;
}
/* fine */

/*Disegno e gestione stile della linea */
function drawLineStyleDetail(itemObj, props) {
  var pID = "boxcontainer";
  currentItem = itemObj;
  var elem;
  var div = null, create = true;
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
      div.id = "line_prop";
      div.className = "fontContainer";
    }

    switch (props[i].propID) {
      case "h":
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_LINESTYLE", "Line style");
        div.appendChild(elem);
        Ctrl(pID).appendChild(div);
        elem = document.createElement("span");
        elem.className = "iconDescLabel";
        elem.textContent = getTranslated("SMR_HEIGHT", "Height");
        div.appendChild(elem);
        elem = document.createElement("input");
        elem.id = props[i].propID;
        elem.name = props[i].propID;
        elem.className = "inputFontSize";
        elem.type = "number";
        elem.min = 1;
        var t = getTranslated(props[i].tooltip_code, props[i].tooltip);
        elem.title = t.split(";")[0];
        elem.value = itemObj[props[i].propID];
        div.appendChild(elem);
        elem.onchange = window[props[i].actions];
        create = false;
        break;
      case "lcolor":
        drawColorPicker(div, props[i]);
        break;
      case "lstretchr":
        drawSwitch(props[i], "line_prop", itemObj[props[i].propID]);
        break;
    }
  }
}

function drawColorPicker(div, prop) {
  var id = prop.propID + "colorHEX_btn";
  var elem = document.createElement("input");
  elem.id = prop.propID + "colorHEX";
  elem.className = "unselectable colorinput";
  elem.type = "text";
  elem.value = currentItem[prop.propID];
  div.appendChild(elem);
  elem.onfocus = window[prop.actions];
  elem.onblur = window[prop.actions];

  var pelem = document.createElement("div");
  pelem.id = prop.propID;
  pelem.className = "colorctrl";
  pelem.title = getTranslated(prop.tooltip_code, prop.tooltip);
  div.appendChild(pelem);
  pelem.onclick = function () { openColorPicker(id); };

  elem = document.createElement("div");
  elem.className = "unselectable smartreport-icon-color iconbtnToolbar";
  pelem.appendChild(elem);
  elem.onclick = function () { openColorPicker(id); };

  elem = document.createElement("div");
  elem.id = prop.propID + "colorHEX_btn";
  elem.className = "colorbtn";
  elem.style.backgroundColor = Empty(currentItem[prop.propID]) ? "#000000" : currentItem[prop.propID];
  pelem.appendChild(elem);
  elem.onclick = function () { openColorPicker(id); };

  jsColorPicker("#" + prop.propID + "colorHEX", {
    size: 1,
    expires: 365, // durata del cookie contentente i colori salvati
    noResize: true,
    init: function (elm/*, col*/) {
      var btn = Ctrl(elm.id + "_btn");
      btn.style.backgroundColor = elm.value;
    }
  });
}

function setLineColor(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    if (!Empty(propCtrl.value))
      currentItem.lcolor = propCtrl.value;
    else
      currentItem.lcolor = "#000000";

    Ctrl("lcolorcolorHEX_btn").style.backgroundColor = currentItem.lcolor;
    Ctrl(currentItem.id).style.backgroundColor = currentItem.lcolor;
    UpdateDesignObj(currentItem, "font");
  }

  setTimeout(function () {
    Ctrl("colorPickerUI").style.left = (Ctrl("colorPickerUI").offsetLeft - 6) + "px";
    Ctrl("colorPickerUI").style.opacity = 1;
  }, 0);

  pushToHistory();
}

function setLineHeight(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var myLineW = parseInt(propCtrl.value);
  if (myLineW < 1)
    myLineW = 1;

  for (var i = 0; i < container_selection.e.length; i++) {
    currentItem = itemsHTML[container_selection.e[i]];
    currentItem[propCtrl.id] = myLineW;
    Ctrl(currentItem.id).style.height = myLineW + "px";
    UpdateDesignObj(currentItem, "font");
  }
  pushToHistory();
}

function applyLineStyleProperties(objitem, nl) {
  Ctrl(objitem.id).style.backgroundColor = objitem.lcolor;
  Ctrl(objitem.id).style.height = objitem.h + "px";
  if (objitem.lstretchr)
    Ctrl(objitem.id).style.width = nl + "px";
}

function setLineObj(objitem) {
  objitem.lcolor = Ctrl(objitem.id).style.backgroundColor;
  objitem.h = parseInt(Ctrl(objitem.id).offsetHeight);
  objitem.ltypeplain = true;
}

function maximizeLine(e) {
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  if (ctrl.offsetHeight > 3)
    return;

  ctrl.style.height = "5px";
}

function minimizeLine(e) {
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  ctrl.style.height = itemsHTML[getItemsHTMLIndex(ctrl.id)].h + "px";
}
/* fine */

/* Disegno e gestione data */
function drawDateDetail(itemObj, props, contID) {
  currentItem = itemObj;
  var elem;
  var pID = "boxcontainer";
  var sp;
  var click = "", tmp = "";
  if (!Empty(contID))
    pID = contID;
  for (var i = 0; i < props.length; i++) {
    switch (props[i].propID) {
      case "dateformat":
      case "timeformat":
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboFontName";
        if (itemObj.typeView == "date" && props[i].propID == "timeformat") {
          elem.disabled = true;
          elem.style.backgroundColor = "#F3F3F3";
        }
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        Ctrl(pID).appendChild(elem);
        click = " onchange='" + props[i].actions + "' ";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;

        if (props[i].propID.indexOf("date") >= 0)
          sp = ZTObjects.date_select.split(",");
        else
          sp = ZTObjects.time_select.split(",");
        for (var j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          if (props[i].convertFunc) {
            var t = window[props[i].convertFunc](sp[j]);
            elem.textContent = getTranslated("SMR_" + t, t);
          }
          else
            elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //sp[j]; //SMR_NONE
          elem.value = sp[j];
          Ctrl(props[i].propID).appendChild(elem);
          if (itemObj[props[i].propID] == sp[j]) elem.selected = true;
        }
        break;
    }
  }

  Ctrl("canvas").onmousedown = saveEditInput;
}

function checkDate() {
  var idLabel = currentItem.id + "_int";
  currentItem.dateformat = Ctrl("dateformat").value;
  currentItem.timeformat = Ctrl("timeformat").value;
  Ctrl(idLabel).textContent = "[" + ConvertToView(currentItem, currentItem.isGeneric) + "]";
  UpdateDesignObj(currentItem, "datetime");
}

function setMarkUp() {
  //var idLabel = currentItem.id+"_int";
  currentItem.smdateformat = Ctrl("smdateformat").value;
  currentItem.smtimeformat = Ctrl("smtimeformat").value;
  currentItem.sequence = Ctrl("sequence").value;
  currentItem.brequired = Ctrl("brequired").checked;
  currentItem.bgeoposition = Ctrl("bgeoposition").checked;
  currentItem.bhideextra = Ctrl("bhideextra").checked;
  UpdateDesignObj(currentItem, "signmup");
  pushToHistory();
}

function setBarcode() {
  currentItem.barcodetype = Ctrl("barcodetype").value;
  UpdateDesignObj(currentItem, "barcode");
  drawIconField("barcode", currentItem);
  pushToHistory();
}
/* fine */

/* Disegno e gestione tipo numerico */
function drawNumericDetail(itemObj, props, contID) {
  currentItem = itemObj;
  var elem;
  var pID = "boxcontainer";
  var sp;
  var click, tmp;
  if (!Empty(contID))
    pID = contID;
  for (var i = 0; i < props.length; i++) {
    switch (props[i].propID) {
      case "calculate":
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboFontName";
        elem.style.width = "50%";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        Ctrl(pID).appendChild(elem);
        click = " onchange='" + props[i].actions + "' ";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;

        sp = ZTObjects.calc_select.split(",");
        for (var j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //SMR_NONE //SMR_SUM
          elem.value = sp[j];
          Ctrl(props[i].propID).appendChild(elem);
        }
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        break;
      case "calcbygrp":
        drawSwitch(props[i], pID, itemObj[props[i].propID]);
        Ctrl("switch_" + props[i].propID).style.marginRight = "4px";
        Ctrl("switch_" + props[i].propID).style.marginTop = "4px";
        Ctrl("switch_" + props[i].propID).style.cssFloat = "right";
        break;
    }
  }
  Ctrl("canvas").onmousedown = saveEditInput;
}

function drawSwitch(prop, pID, value, hidetext, field) {
  var check = false,
    appFont = { name: "Open Sans", size: 13, weight: 400 },
    switchW = 20,
    offsetH = 20;

  var propSwitch = document.createElement("div");
  propSwitch.id = "switch_" + prop.propID;
  propSwitch.className = "onoffprop";
  if (viewMode == documentView && field)
    propSwitch.className += " switchDocument";

  prop.name = getTranslated("SMR_" + prop.name, prop.name);
  //SMR_NOTUSED //SMR_USED //SMR_SNAPTOGRID
  propSwitch.style.width = (getOffsetWidth(prop.name, appFont) + switchW + offsetH) + "px";
  if (prop.margin)
    propSwitch.style.marginTop = prop.margin + "px";
  propSwitch.title = getTranslated(prop.tooltip_code, prop.tooltip);
  Ctrl(pID).appendChild(propSwitch);

  var input = document.createElement("INPUT");
  input.id = prop.propID;
  input.className = "onoffprop-checkbox";
  input.type = "checkbox";
  input.name = prop.propID;
  if (value) {
    input.checked = true;
    check = true;
  }
  propSwitch.appendChild(input);
  if (prop.actions)
    input.onclick = window[prop.actions];

  var label = document.createElement("LABEL");
  label.className = "onoffprop-label";
  label.for = prop.propID;
  propSwitch.appendChild(label);
  label.onclick = manageOnOff;
  label.setAttribute("data-prop", prop.propID);

  var div = document.createElement("div");
  div.className = "onoffprop-inner";
  if (hidetext)
    div.className += " hidetextcolor";
  else
    div.className += " whitetextcolor";
  label.appendChild(div);
  div.setAttribute("data-attr", prop.name);
  div.setAttribute("data-prop", prop.propID);

  var span = document.createElement("span");
  span.id = prop.propID + "onoffswitch";
  span.className = "onoffprop-switch";
  if (check)
    span.style.right = 2 + "px";
  else
    span.style.right = (getOffsetWidth(prop.name, appFont) + offsetH - 2) + "px";
  label.appendChild(span);
  span.setAttribute("data-prop", prop.propID);

  removeSpanTag();
}

function setCalculation(currentItem) {
  if (currentItem.type != "field")
    return;
  if (currentItem.calculate == "none") {
    if (Ctrl(currentItem.id + "_span_calc"))
      Ctrl(currentItem.id + "_span_calc").parentNode.removeChild(Ctrl(currentItem.id + "_span_calc"));
    return;
  }
  //Ctrl(currentItem.id+"_int").style.paddingLeft="10px"
  drawIconField("calc", currentItem);
}
/* fine */

/* Disegno e gestione tipo markup -firma */
function drawSignatureMarkupDetail(itemObj, props) {
  currentItem = itemObj;
  var elem;
  var pID = "boxcontainer";
  var sp;
  var click, tmp;
  var create = true;
  var div;
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
    }

    switch (props[i].propID) {
      case "brequired":
      case "bgeoposition":
      case "bhideextra":
        if (create) {
          div.id = "reqmupCont";
          div.className = "fontContainer";
          elem = document.createElement("span");
          elem.className = "shadowtitlediv";
          elem.textContent = getTranslated("SMR_REQUIREMENTS", "Requirements");
          div.appendChild(elem);
          Ctrl(pID).appendChild(div);
        }
        drawSwitch(props[i], "reqmupCont", itemObj[props[i].propID]);
        Ctrl("switch_" + props[i].propID).style.marginRight = "4px";
        Ctrl("switch_" + props[i].propID).style.marginTop = "4px";
        Ctrl("switch_" + props[i].propID).style.marginLeft = "4px";
        Ctrl("switch_" + props[i].propID).style.cssFloat = "left";
        create = false;
        if (props[i].propID == "bgeoposition") {
          Ctrl("switch_" + props[i].propID).style.cssFloat = "right";
        }
        /*if(props[i].propID=="bhideextra")
          create = true;*/
        break;
      case "title":
        div.id = "utitle";
        div.className = "reqdescContainer";
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_TITLE", "Title");
        div.appendChild(elem);
        Ctrl(pID).appendChild(div);
        drawItemContent(itemObj, "utitle", itemObj[props[i].propID], true);
        create = true;
        break;
      case "sequence":
        var e = document.createElement("div");
        e.style.marginLeft = 4 + "px";
        div.appendChild(e);
        elem = document.createElement("span");
        elem.className = "iconDescLabelH";
        elem.textContent = getTranslated("SMR_SEQUENCE", "Sequence");
        elem.style.cssFloat = 'left';
        elem.style.fontSize = "13px";
        elem.style.textAlign = "center";
        elem.style.verticalAlign = "middle";
        elem.style.marginLeft = "6px";
        elem.style.marginTop = "6px";
        e.appendChild(elem);
        elem = document.createElement("input");
        elem.id = props[i].propID;
        elem.name = props[i].propID;
        elem.className = "inputFontSize";
        elem.type = "number";
        elem.style.cssFloat = 'left';
        elem.min = 1;
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        elem.value = itemObj[props[i].propID];
        e.appendChild(elem);
        elem.onchange = window[props[i].actions];
        elem.onfocus = function () { SetOnEditProp(true); };
        elem.onblur = function () { SetOnEditProp(false); };
        create = true;
        break;
      case "smdateformat":
      case "smtimeformat":
        if (create) {
          div.className = "datemupContainer";
          elem = document.createElement("span");
          elem.className = "shadowtitlediv";
          elem.textContent = getTranslated("SMR_DATEFORMAT", "Date format");
          div.appendChild(elem);
          Ctrl(pID).appendChild(div);
        }
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboFontName";
        if (itemObj.typeView == "date" && props[i].propID == "smtimeformat") {
          elem.disabled = true;
          elem.style.backgroundColor = "#F3F3F3";
        }
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        click = " onchange='" + props[i].actions + "' ";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;

        if (props[i].propID.indexOf("date") >= 0)
          sp = ZTObjects.mupdate_select.split(",");
        else
          sp = ZTObjects.muptime_select.split(",");
        for (var j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          if (props[i].convertFunc) {
            var t = window[props[i].convertFunc](sp[j]);
            elem.textContent = getTranslated("SMR_" + Upper(Strtran(t, " ", "")), t);
          }
          else
            elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //sp[j]; //SMR_NONE
          elem.value = sp[j];
          Ctrl(props[i].propID).appendChild(elem);
          if (itemObj[props[i].propID] == sp[j]) elem.selected = true;
        }
        create = false;
        if (props[i].propID == "smtimeformat")
          create = true;
        break;
    }
  }
  Ctrl("canvas").onmousedown = saveEditInput;
}
/* fine */

function drawIconField(ico, item) {
  if (Ctrl(item.id + "_span_" + ico))
    return;
  var elem = document.createElement("span");
  elem.id = item.id + "_span_" + ico;
  switch (ico) {
    case "img":
      elem.className += "fieldGenIcon smartreport-icon-image";
      break;
    case "calc":
      elem.className += "fieldGenIconCalc smartreport-icon-sigma";
      break;
    case "signmup":
      elem.className += "fieldGenIcon smartreport-icon-sign";
      break;
    case "barcode":
      elem.className += "fieldGenIcon smartreport-icon-barcode";
      break;
  }
  if (ico == 'calc') {
    if (Ctrl(item.id + "_int")) {
      var inh = Ctrl(item.id + "_int").innerHTML;
      Ctrl(item.id + "_int").innerHTML = "";
      Ctrl(item.id + "_int").appendChild(elem);
      Ctrl(item.id + "_int").innerHTML += inh;
    }
  }
  else
    Ctrl(item.id).appendChild(elem);
}

String.prototype.splice = function (idx, rem, str) {
  return (this.slice(0, idx) + str + this.slice(idx + Math.abs(rem)));
};

/* Gestione e disegno proprieta' righelli-griglia*/
function drawRulerSettings(itemObj, props) {
  $("shadowmenu").addClass("gridContainer");
  var pID = "boxcontainer";
  var div = null, create = true;
  var divcount = 0;
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
      div.id = "gridopt_" + divcount;
      div.className = "gridOptDiv";
      Ctrl(pID).appendChild(div);
      divcount++;
    }
    switch (props[i].propID) {
      case "measureunit":
        div.style.marginTop = "0px";
        //div.style.height = "25%";
        var elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboUnit";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);

        var click = " onchange='" + props[i].actions + "'";
        var tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;
        var sp = ZTObjects.measure_select.split(",");
        for (var j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //sp[j];
          elem.value = sp[j];
          //SMR_MILLIMETERS //SMR_CENTIMETERS //SMR_POINTS;
          Ctrl(props[i].propID).appendChild(elem);
        }

        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = true;
        break;
      case "showrulers":
      case "showgrid":
        if (create) {
          elem = document.createElement("span");
          elem.id = "shadowtitletext_" + props[i].propID;
          elem.className = "shadowtitlediv";
          elem.textContent = getTranslated("SMR_" + props[i].button, props[i].button); //props[i].button; //SMR_RULERS //SMR_GRID
          div.appendChild(elem);
        }
        drawSwitch(props[i], "gridopt_" + (divcount - 1), itemObj[props[i].propID], true);
        Ctrl("switch_" + props[i].propID).style.marginTop = "3px";
        create = false;
        break;
      case "snapgrid":
        drawSwitch(props[i], "gridopt_" + (divcount - 1), itemObj[props[i].propID], false);
        Ctrl("switch_" + props[i].propID).style.marginTop = "3px";
        create = true;
        break;
      case "tick50":
      case "tick100":
        if (create) {
          elem = document.createElement("span");
          elem.id = "shadowtitletext_" + props[i].propID;
          elem.className = "shadowtitlediv";
          elem.textContent = getTranslated("SMR_TICKSTYLE", "Tick style");
          div.appendChild(elem);
          elem.style.backgroundColor = "transparent";
          create = false;
        }
        elem = document.createElement("div");
        elem.id = props[i].propID;
        elem.className = "unselectable buttonRuler iconbtnToolbar " + props[i].addclass;
        //elem.style.backgroundImage = props[i].image;
        if (props[i].propID == "tick50")
          elem.style.marginLeft = "5px";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        click = " onclick='" + props[i].actions + "'";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></div>"), 0, click);
        elem.outerHTML = tmp;
        if (itemObj[props[i].propID])
          changeBackgroundIconButton(Ctrl(props[i].propID), true);
        if (props[i].propID == "tick100") create = true;
        break;
      case "gtypesmall":
      case "gtypelong":
      case "gtypeplain":
        if (create) {
          elem = document.createElement("span");
          elem.id = "shadowtitletext_" + props[i].propID;
          elem.className = "shadowtitlediv";
          elem.textContent = getTranslated("SMR_DASHSTYLE", "Dash style");
          div.appendChild(elem);
          elem.style.backgroundColor = "transparent";
          create = false;
        }
        elem = document.createElement("div");
        elem.id = props[i].propID;
        elem.className = "unselectable buttonRuler iconbtnToolbar " + props[i].addclass;
        elem.style.backgroundImage = props[i].image;
        if (props[i].propID.indexOf("gtype") >= 0) {
          //elem.style.marginTop = "10px";
          elem.style.marginLeft = "10px";
        }
        if (props[i].propID == "gtypesmall")
          elem.style.marginLeft = "5px";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        click = " onclick='" + props[i].actions + "'";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></div>"), 0, click);
        elem.outerHTML = tmp;
        if (itemObj[props[i].propID])
          changeBackgroundIconButton(Ctrl(props[i].propID), true);
        create = false;
        break;
    }
  }
}

function setMeasureTick25(e) {
  formProp.tick25 = true;
  formProp.tick50 = false;
  formProp.tick100 = false;

  changeBackgroundIconButton(GetEventSrcElement(e || window.event), true);
  checkTickUnit("25", true);
  setMeasureTickUnit();
  updateGrid();
}

function setMeasureTick50(e) {
  formProp.tick50 = true;
  formProp.tick100 = false;
  changeBackgroundIconButton(GetEventSrcElement(e || window.event), true);
  checkTickUnit("50", true);
  setMeasureTickUnit();
  updateGrid();
  updateMCurrentObj("structureGrid.tick", "50");
  pushToHistory();
}

function setMeasureTick100(e) {
  formProp.tick50 = false;
  formProp.tick100 = true;
  changeBackgroundIconButton(GetEventSrcElement(e || window.event), true);
  checkTickUnit("100", true);
  setMeasureTickUnit();
  updateGrid();
  updateMCurrentObj("structureGrid.tick", "100");
  pushToHistory();
}

function setMeasureTickUnit() {
  if (formProp.tick100)
    unittick = "100";
  else
    unittick = "50";
}

function checkTickUnit(type, check) {
  if (check) {
    switch (type) {
      case "50":
        changeBackgroundIconButton(Ctrl("tick100"), false);
        break;
      case "100":
        changeBackgroundIconButton(Ctrl("tick50"), false);
        break;
    }
  }
}

function checkGridType(type, check) {
  if (check) {
    switch (type) {
      case "small-dashed":
        changeBackgroundIconButton(Ctrl("gtypelong"), false);
        changeBackgroundIconButton(Ctrl("gtypeplain"), false);
        break;
      case "long-dashed":
        changeBackgroundIconButton(Ctrl("gtypesmall"), false);
        changeBackgroundIconButton(Ctrl("gtypeplain"), false);
        break;
      case "plain":
        changeBackgroundIconButton(Ctrl("gtypesmall"), false);
        changeBackgroundIconButton(Ctrl("gtypelong"), false);
        break;
    }
  }
}

function setGridTypeDot(e) {
  formProp.gtypesmall = false;
  formProp.gtypelong = false;
  formProp.gtypeplain = false;
  changeBackgroundIconButton(GetEventSrcElement(e || window.event), true);
  checkGridType("dotted", true);
  setMeasureGridType();
  updateGrid();
}

function setGridTypeSmall(e) {
  formProp.gtypesmall = true;
  formProp.gtypelong = false;
  formProp.gtypeplain = false;
  changeBackgroundIconButton(GetEventSrcElement(e || window.event), true);
  checkGridType("small-dashed", true);
  setMeasureGridType();
  updateGrid();

  updateMCurrentObj("structureGrid.type", "small");
  pushToHistory();
}

function setGridTypeLong(e) {
  formProp.gtypesmall = false;
  formProp.gtypelong = true;
  formProp.gtypeplain = false;

  changeBackgroundIconButton(GetEventSrcElement(e || window.event), true);
  checkGridType("long-dashed", true);
  setMeasureGridType();
  updateGrid();

  updateMCurrentObj("structureGrid.type", "long");
  pushToHistory();
}

function setGridTypePlain(e) {
  formProp.gtypesmall = false;
  formProp.gtypelong = false;
  formProp.gtypeplain = true;

  changeBackgroundIconButton(GetEventSrcElement(e || window.event), true);
  checkGridType("plain", true);
  setMeasureGridType();
  updateGrid();

  updateMCurrentObj("structureGrid.type", "plain");
  pushToHistory();
}

function setMeasureGridType() {
  if (formProp.gtypelong)
    gridtype = "long-dashed";
  else if (formProp.gtypeplain)
    gridtype = "plain";
  else
    gridtype = "small-dashed";
}

function setMeasureUnit(e) {
  formProp.measureunit = GetEventSrcElement(e || window.event).value;
  setMeasureWorkUnit();
  updateGrid();

  updateMCurrentObj("structureGrid.unit", formProp.measureunit);
  pushToHistory();
}

function setMeasureWorkUnit() {
  switch (formProp.measureunit) {
    case "centimeters":
      workunit = "cm";
      break;
    case "points":
      workunit = "px";
      break;
    default:  // mm
      workunit = "mm";
      break;
  }
}

function setSnapToGrid(e) {
  if (formProp.snapgrid)
    formProp.snapgrid = false;
  else
    formProp.snapgrid = true;

  changeBackgroundIconButton(GetEventSrcElement(e || window.event), formProp.snapgrid);

  updateMCurrentObj("snap", formProp.snapgrid);
  pushToHistory();
}

function updateGrid() {
  Ctrl("h_rulerc").innerHTML = "";
  // classi grid
  // classi vrulerc
  var grid = document.getElementsByClassName("grid");
  var ruler = document.getElementsByClassName("vRulerC");
  for (var i = 0; i < grid.length; i++) {  // per ogni grid c'e' un ruler
    if (grid[i])
      grid[i].innerHTML = "";
    if (ruler[i])
      ruler[i].innerHTML = "";
  }

  generateRulers(workunit);
  drawLimitBars();
  updateDrawGrid();

  if (!formProp.showrulers)
    hideRulers();
  if (!formProp.showgrid)
    hideGrid();
}

function optGrid(e) {
  var propCtrl = GetEventSrcElement(e || window.event);

  if (propCtrl.checked)
    showGrid();
  else
    hideGrid();

  formProp.showgrid = propCtrl.checked;
  updateMCurrentObj("structureGrid.showGrid", propCtrl.checked);
  pushToHistory();
}

function showGrid() {
  var i;
  var elems = document.getElementsByClassName("grid");
  for (i = 0; i < elems.length; i++) {
    $(elems[i].id).removeClass("hiddenAdd");
  }
  elems = document.getElementsByClassName("contentZone");
  for (i = 0; i < elems.length; i++) {
    $(elems[i].id).removeClass("borderZoneAdd");
  }
}

function hideGrid() {
  var i;
  var elems = document.getElementsByClassName("grid");
  for (i = 0; i < elems.length; i++) {
    $(elems[i].id).addClass("hiddenAdd");
  }
  elems = document.getElementsByClassName("contentZone");
  for (i = 0; i < elems.length; i++) {
    $(elems[i].id).addClass("borderZoneAdd");
  }
}

function optRulers(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  formProp.showrulers = propCtrl.checked;
  updRulers();
}

function updRulers() {
  if (formProp.showrulers)
    showRulers();
  else
    hideRulers();
  if (m_CurrentObj != null) {
    updateMCurrentObj("structureGrid.showRulers", formProp.showrulers);
    pushToHistory();
  }
}

function showRulers() {
  $("h_ruler").removeClass("hiddenAdd");
  $("v_ruler_zones").removeClass("hiddenAdd");
  if (!Empty(Ctrl("measureunit"))) {
    Ctrl("measureunit").disabled = false;
    Ctrl("measureunit").style.cursor = "";
  }
}

function hideRulers() {
  $("h_ruler").addClass("hiddenAdd");
  $("v_ruler_zones").addClass("hiddenAdd");
  if (!Empty(Ctrl("measureunit"))) {
    Ctrl("measureunit").disabled = true;
    Ctrl("measureunit").style.cursor = "default";
  }
}
/* fine */

/* Disegno combobox scelta field testo/image */
function drawFieldChange(itemObj, props, contID) {
  currentItem = itemObj;
  var elem, sp, j;
  var pID = "boxcontainer";
  var click = "", tmp = "";
  var div = null, create = false;
  if (!Empty(contID))
    pID = contID;
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
    }
    switch (props[i].propID) {
      case "typeView":
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboFontName";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        Ctrl(pID).appendChild(elem);
        click = " onchange='" + props[i].actions + "'";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;
        sp = ZTObjects.fldconv_select.split(",");
        for (j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.value = sp[j];
          elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //sp[j]; //SMR_TEXT //SMR_IMAGE //SMR_BARCODE
          Ctrl(props[i].propID).appendChild(elem);
        }
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = true;
        break;
      case "barcodetype":
        div.className = "";
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_BARCODEOPTIONS", "Barcode options");
        div.appendChild(elem);
        Ctrl(pID).appendChild(div);
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboFontName";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        elem.style.width = "75%"
        Ctrl(pID).appendChild(elem);
        click = " onchange='" + props[i].actions + "'";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;
        sp = ZTObjects.barcode_select.split(",");
        for (j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.textContent = sp[j];
          Ctrl(props[i].propID).appendChild(elem);
        }
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = true;
        break;
      case "fcoloroff":
        Ctrl(pID).appendChild(div);
        drawColorPicker(div, props[i]);
        create = false;
        break;
      case "fcoloron":
        drawColorPicker(div, props[i]);
        create = true;
        break;
      case "qrcodecorrection":
        div.className = "";
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_QRCODECORRECTION", "QRCode Error Correction");
        div.appendChild(elem);
        Ctrl(pID).appendChild(div);
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "comboFontName";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        Ctrl(pID).appendChild(elem);
        click = " onchange='" + props[i].actions + "'";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf("></select>"), 0, click);
        elem.outerHTML = tmp;
        sp = ZTObjects.qrcodeselect_select.split(",");
        for (j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.textContent = sp[j];
          Ctrl(props[i].propID).appendChild(elem);
        }
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        break;
    }
  }
  Ctrl("canvas").onmousedown = saveEditInput;
}

function fieldTextToImage() {
  /*if(Ctrl("typeView").value == currentItem.typeView)
    return;*/
  currentItem.typeView = Ctrl("typeView").value;
  updTextToImage(currentItem);
  UpdateDesignObj(currentItem, currentItem.typeView);
}

function updTextToImage(currentItem) {
  var elem, ctrl;
  switch (currentItem.typeView) {
    case "text":  // vuol dire che deriva da una image
      if (!Empty(Ctrl(currentItem.id + "_img")))
        Ctrl(currentItem.id + "_img").parentNode.removeChild(Ctrl(currentItem.id + "_img"));
      if (!Empty(Ctrl(currentItem.id + "_span_img")))
        Ctrl(currentItem.id + "_span_img").parentNode.removeChild(Ctrl(currentItem.id + "_span_img"));
      if (!Empty(Ctrl(currentItem.id + "_signmup")))
        Ctrl(currentItem.id + "_img").parentNode.removeChild(Ctrl(currentItem.id + "_signmup"));
      if (!Empty(Ctrl(currentItem.id + "_span_signmup")))
        Ctrl(currentItem.id + "_span_img").parentNode.removeChild(Ctrl(currentItem.id + "_span_signmup"));
      if (!Empty(Ctrl(currentItem.id + "_barcode")))
        Ctrl(currentItem.id + "_barcode").parentNode.removeChild(Ctrl(currentItem.id + "_barcode"));
      if (!Empty(Ctrl(currentItem.id + "_span_barcode")))
        Ctrl(currentItem.id + "_span_barcode").parentNode.removeChild(Ctrl(currentItem.id + "_span_barcode"));
      if (Ctrl(currentItem.id + "_int"))
        $(currentItem.id + "_int").removeClass("hiddenZone");
      break;
    case "image":
      if (Empty(Ctrl(currentItem.id + "_img"))) {
        elem = document.createElement("img");
        elem.id = currentItem.id + "_img";
        elem.className = "unselectable hiddenZone";
        elem.src = "";
        elem.style.width = "100%";
        elem.style.height = "100%";
        Ctrl(currentItem.id).appendChild(elem);
      }
      ctrl = Ctrl(currentItem.id + "_img");
      $(currentItem.id + "_int").addClass("hiddenZone");
      $(currentItem.id + "_img").removeClass("hiddenZone");
      ctrl.alt = "[" + currentItem.fieldDet.desc + "]";
      drawIconField("img", currentItem);
      break;
    case "barcode":
      if (Empty(Ctrl(currentItem.id + "_barcode"))) {
        elem = document.createElement("img");
        elem.id = currentItem.id + "_barcode";
        elem.className = "unselectable hiddenZone";
        elem.src = "";
        elem.style.width = "100%";
        elem.style.height = "100%";
        Ctrl(currentItem.id).appendChild(elem);
      }
      ctrl = Ctrl(currentItem.id + "_barcode");
      $(currentItem.id + "_int").addClass("hiddenZone");
      $(currentItem.id + "_barcode").removeClass("hiddenZone");
      ctrl.alt = "[" + currentItem.fieldDet.desc + "]";
      drawIconField("barcode", currentItem);
      break;
    case "signmup":
      if (Empty(Ctrl(currentItem.id + "_signmup"))) {
        elem = document.createElement("img");
        elem.id = currentItem.id + "_signmup";
        elem.className = "unselectable hiddenZone";
        elem.src = "";
        elem.style.width = "100%";
        elem.style.height = "100%";
        Ctrl(currentItem.id).appendChild(elem);
      }
      ctrl = Ctrl(currentItem.id + "_signmup");
      $(currentItem.id + "_int").addClass("hiddenZone");
      $(currentItem.id + "_signmup").removeClass("hiddenZone");
      ctrl.alt = "[" + currentItem.fieldDet.desc + "]";
      drawIconField("signmup", currentItem);
      break;
  }
}
/* fine */

/* Disegno toolbar */
function addToolbarElements(toolbar, idtoolbar, separateElements) {
  var elem, tmp, click, pid, i;
  if (separateElements && toolbar.length > 0) {
    var view = toolbar[0].view;
    for (i = 1; i < toolbar.length; i++)
      view = view + " " + toolbar[i].view;
    drawSeparatorElement(idtoolbar, separateElements, view);
  }

  for (i = 0; i < toolbar.length; i++) {
    var pdiv = document.createElement("div");
    pdiv.id = toolbar[i].propID + "_cont";
    pdiv.className = "btncontainer";
    if (toolbar[i].view)
      pdiv.className += (" " + toolbar[i].view);
    Ctrl(idtoolbar).appendChild(pdiv);
    pid = pdiv.id;

    if (toolbar[i].type.indexOf("select[") >= 0) {
      elem = document.createElement("span");
      elem.id = toolbar[i].propID + "_btn";
      elem.className = "unselectable";
      if (toolbar[i].addclass)
        elem.className += (" " + toolbar[i].addclass);
      if (toolbar[i].icon) {
        elem.className += " iconbtnToolbar";
      }
      else
        elem.className += " buttonToolbar";
      if (toolbar[i].view)
        elem.className += (" " + toolbar[i].view);
      elem.title = getTranslated(toolbar[i].tooltip_code, toolbar[i].tooltip);
      elem.style.backgroundImage = toolbar[i].image;
      if (toolbar[i].marginTop)
        elem.style.marginTop = toolbar[i].marginTop + "px";
      if (toolbar[i].marginLeft)
        elem.style.marginLeft = toolbar[i].marginLeft + "px";
      if (toolbar[i].position)
        elem.style.position = toolbar[i].position;
      if (toolbar[i].cursor)
        elem.style.cursor = toolbar[i].cursor;
      Ctrl(pid).appendChild(elem);
      click = " onclick=\"" + toolbar[i].actions + "\"";
      tmp = elem.outerHTML.splice(elem.outerHTML.indexOf(">"), 0, click);
      elem.outerHTML = tmp;


      var ts = toolbar[i].text_select.split(","),
        tv = toolbar[i].type.substring(7, toolbar[i].type.indexOf("]")).split(",");
      elem = document.createElement("SELECT");
      elem.id = toolbar[i].propID + "_combolabel";
      elem.className = "unselectable toolbartext";
      if (toolbar[i].textclass)
        elem.className += (" " + toolbar[i].textclass);
      if (toolbar[i].view)
        elem.className += (" " + toolbar[i].view);
      Ctrl(pid).appendChild(elem);
      for (var j = 0; j < ts.length; j++) {
        var opt = document.createElement("OPTION");
        opt.textContent = getTranslated("SMR_" + ts[j], ts[j]); //ts[j];
        //SMR_DOCUMENTVIEW //SMRDOCUMENTDESIGN //SMR_DOCUMENTPDFVIEW
        //SMR_OTHERSDOWNLOAD SMR_CSVDOCUMENT, SMR_STANDARDCSVDOCUMENT SMR_SDFDOCUMENT, SMR_XMLDOCUMENT, SMR_STRUCTUREDXMLDOCUMENT"
        opt.value = tv[j];
        elem.appendChild(opt);
      }
      elem.onchange = window[toolbar[i].actions];
    }
    else {
      if (toolbar[i].actions)
        pdiv.onclick = window[toolbar[i].actions];
      elem = document.createElement("span");
      elem.id = toolbar[i].propID + "_btn";
      elem.className = "unselectable";
      if (toolbar[i].addclass)
        elem.className += (" " + toolbar[i].addclass);
      if (toolbar[i].icon)
        elem.className += " iconbtnToolbar";
      else
        elem.className += " buttonToolbar";
      if (toolbar[i].view)
        elem.className += (" " + toolbar[i].view);
      elem.title = getTranslated(toolbar[i].tooltip_code, toolbar[i].tooltip);
      elem.style.backgroundImage = toolbar[i].image;
      if (toolbar[i].marginTop)
        elem.style.marginTop = toolbar[i].marginTop + "px";
      if (toolbar[i].marginLeft)
        elem.style.marginLeft = toolbar[i].marginLeft + "px";
      if (toolbar[i].position)
        elem.style.position = toolbar[i].position;
      if (toolbar[i].cursor)
        elem.style.cursor = toolbar[i].cursor;
      Ctrl(pid).appendChild(elem);
      click = " onclick=\"" + toolbar[i].actions + "\"";
      tmp = elem.outerHTML.splice(elem.outerHTML.indexOf(">"), 0, click);
      elem.outerHTML = tmp;

      if (toolbar[i].withtext) {
        elem = document.createElement("span");
        elem.className = "unselectable toolbartext";
        if (toolbar[i].view)
          elem.className += (" " + toolbar[i].view);
        elem.innerHTML = "";
        elem.id = toolbar[i].propID + "_label";
        elem.title = getTranslated(toolbar[i].tooltip_code, toolbar[i].tooltip);
        elem.innerHTML += getTranslated("SMR_" + Upper(Strtran(toolbar[i].name, " ", "")), toolbar[i].name); //toolbar[i].name;
        //SMR_PROPERTIES //SMR_FILTERS //SMR_PAGEOPTIONS
        //SMR_EDIT //SMR_STYLE //SMR_DELETE
        //SMR_SECTIONS //SMR_SECTIONFIELDS //SMR_DOWNLOADPDF
        Ctrl(pid).appendChild(elem);
        click = " onclick=\"" + toolbar[i].actions + "\"";
        tmp = elem.outerHTML.splice(elem.outerHTML.indexOf(">"), 0, click);
        elem.outerHTML = tmp;
      }
    }
  }
}

/* fine */
function updateItemsPositions() {
  for (var i = 0; i < itemsHTML.length; i++) {
    updatePositions(itemsHTML[i]);
  }
}

function updatePositions(item) {
  if (Ctrl(item.id).offsetLeft != item.x)
    item.x = Ctrl(item.id).offsetLeft;
  if (Ctrl(item.id).offsetTop != item.y)
    item.y = Ctrl(item.id).offsetTop;
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

/* REDEFINED HANDLERS */
function addHandlers(itmIdx, isLine) { //REDEFINED
  var itm = document.getElementById("item" + itmIdx), itmobj;
  var borders = (viewMode != designView) ? 0 : 0;
  var yi = getY(itm) - Ctrl('backcanvas').offsetTop + borders;
  var xi = getX(itm) - Ctrl('backcanvas').offsetLeft + borders;
  var wi = itm.offsetWidth;
  var hi = itm.offsetHeight;
  var str = "";

  var shadowH = (hi > 0 ? hi - 2 : 1);  //tolgo i due pixel dei bordi
  var shadowW = (wi > 0 ? wi - 2 : 1);  //tolgo i 2 pixel dei bordi
  var wrapperH = shadowH + 20; //dimensioni del wrapper che contiene gli handler
  var wrapperW = shadowW + 20; //dimensioni del wrapper che contiene gli handler

  var ix = getItemsHTMLIndex("item" + itmIdx);

  /*
                0-----4------1
                |            |
                7            5
                |            |
                3-----6------2
  */
  // aggiunge il div shadow+n della grandezza dell item per lo spostamento
  str += "<div id='handlersWrapper" + itmIdx + "' style='margin:0;z-index:2;position:absolute;overflow:hidden;height:" + wrapperH + "px;width:" + wrapperW + "px;top:" + (yi - 9) + "px;left:" + (xi - 9) + "px;background:transparent;'>";
  str += addHandler(wrapperH / 2, itmIdx, 5);
  if (!isLine) {
    str += addHandler(0, itmIdx, 4);
    str += addHandler(wrapperH, itmIdx, 6);
    str += addHandler(wrapperH / 2, itmIdx, 7);
  }

  str += "</div><div  id='shadow" + itmIdx + "' class='shadow " + viewMode + "' style='top:" + yi + "px;left:" + xi + "px;width:" + shadowW + "px;height:" + shadowH + "px;' ";
  str += "onmousedown='dragShadow(event);' ";
  //str+="ontouchstart='dragShadow(event)' ontouchend='setShadow'";
  str += ">";
  str += "&nbsp;";
  str += "</div>";
  //configuro le dimensioni per gli allineamenti seguendo le caratteristiche della shadow
  if (!multipleSelection) {
    not_selected = [];
    container_selection.t = yi;
    container_selection.l = xi;
    container_selection.w = shadowW + 2;
    container_selection.h = shadowH + 2;
    container_selection.b = yi + shadowH + 2;
    container_selection.r = xi + shadowW + 2;
    validBody = "";
    for (var i = 0; i < itemsHTML.length; i++) {
      itmobj = itemsHTML[i];
      itm = document.getElementById(itemsHTML[i].id);
      if (itm && Empty(itemsHTML[i].shadow) && itm.style.display != 'none' && !itmobj.hidden) {
        if (validNotSelected(itemsHTML[ix], itmobj)) not_selected.push(i);
      }
    }
  }
  return str;
}


function isScrolledIntoView(elem) {
  var docViewTop = Ctrl('backcanvas').offsetTop + Ctrl('backcanvas').scrollTop;
  var docViewBottom = docViewTop + Ctrl('backcanvas').offsetHeight;
  var elemTop = getY(elem);
  var elemBottom = elemTop + elem.offsetHeight;
  return ((elemBottom <= docViewBottom) && (elemTop >= docViewTop));
}

var validBody = "";
function validNotSelected(refitem, item) {
  if (viewMode != designView) {
    var pp1, pp2;
    var p1 = Ctrl(refitem.id);
    while (p1.parentNode && !p1.parentNode.id.indexOf('page') == 0) {
      pp1 = p1;
      p1 = p1.parentNode;
    }
    var p2 = Ctrl(item.id);
    while (p2.parentNode && !p2.parentNode.id.indexOf('page') == 0) {
      pp2 = p2;
      p2 = p2.parentNode;
    }
    if (Empty(p1) || Empty(p2))
      return false;
    var zp1 = p1.id.substring(0, 7);
    var zp2 = p2.id.substring(0, 7);
    if (zp1 != zp2)
      return false;
    //same page
    zp1 = pp1.id.substring(7, pp1.id.length);
    zp2 = zp1.replace(/[0-9]/g, "");
    //same type zone but different / / body
    if (pp2.id.indexOf(zp2) >= 0 && pp2.id.indexOf(zp1) < 0)
      return false;
    if (!isScrolledIntoView(Ctrl(item.id))) //not visible
      return false;
    //header - find first body
    var l;
    if (zp2.indexOf("header") >= 0) {
      l = p1.getElementsByClassName("bodyZoneZ");
      if (l.length > 0) {
        l = l[0];
        zp1 = l.id.substring(7, pp1.id.length);
        zp2 = zp1.replace(/[0-9]/g, "");
        if (pp2.id.indexOf(zp2) >= 0 && pp2.id.indexOf(zp1) < 0)
          return false;
      }
    }
    //footer - find last body
    if (zp2.indexOf("footer") >= 0) {
      l = p1.getElementsByClassName("bodyZoneZ");
      if (l.length > 0) {
        l = l[l.length - 1];
        zp1 = l.id.substring(7, pp1.id.length);
        zp2 = zp1.replace(/[0-9]/g, "");
        if (pp2.id.indexOf(zp2) >= 0 && pp2.id.indexOf(zp1) < 0)
          return false;
      }
    }
  }
  return true;
}


function SaveItemStatus() {
  var idx = -1;

  for (var i = 0; i < container_selection.e.length; i++) {
    idx = container_selection.e[i];
    tmpObj[itemsHTML[idx].uid] = {
      uid: itemsHTML[idx].uid,
      x: itemsHTML[idx].x,
      y: itemsHTML[idx].y,
      yRel: itemsHTML[idx].yRel,
      w: itemsHTML[idx].w,
      h: itemsHTML[idx].h,
      value: itemsHTML[idx].value,
      zone: itemsHTML[idx].zone
    };

    if (itemsHTML[idx].type == "field")
      tmpObj[itemsHTML[idx].uid].fieldDet = { desc: itemsHTML[idx].fieldDet.desc };
  }
}

function moveShadow(e) { //REDEFINED
  isMove = true;
  var elementShadow;
  e = (e) ? e : window.event;
  if (Empty(e.targetTouches)) {
    newx = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    newy = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  }
  else {
    newx = (e.targetTouches[0].pageX) ? e.targetTouches[0].pageX : (e.targetTouches[0].clientX) ? e.targetTouches[0].clientX : 0;
    newy = (e.targetTouches[0].pageY) ? e.targetTouches[0].pageY : (e.targetTouches[0].clientY) ? e.targetTouches[0].clientY : 0;
  }
  newx = newx - parseInt(Ctrl("backcanvas").offsetLeft) + Ctrl("backcanvas").scrollLeft;
  newy = newy - parseInt(Ctrl("backcanvas").offsetTop) + Ctrl("backcanvas").scrollTop;
  if (Empty(mainitem)) return;
  dx = newx - deltax - mainitem.offsetLeft;
  dy = newy - deltay - mainitem.offsetTop;

  var delta = new Array();
  delta[0] = dx;
  delta[1] = dy;
  delta[2] = dx;
  delta[3] = dy;

  if (canAlign) delta = drawSnap(delta, false, true);
  if (dx == 0 && dy == 0) return;
  var idx = -1;
  for (var k = 0; k < container_selection.e.length; k++) {
    idx = container_selection.e[k];
    elementShadow = Ctrl(itemsHTML[idx].shadow);
    var dPos = [];
    dPos[0] = elementShadow.offsetLeft + delta[0];
    dPos[1] = elementShadow.offsetTop + delta[1];

    if (window.calcSnapToGrid && formProp.snapgrid) {
      var z = (viewMode != designView) ? itemsHTML[idx].zone : identifyZone(elementShadow.offsetTop + delta[1]);
      if (!Empty(z)) {
        /*myItems = !Empty(z)?getAreaItems(z):[];
        if(myItems) myItems = myItems.concat(container_selection.e).unique();
        crossItems = getCrossZoneItems(z);
        if(crossItems) myItems = myItems.concat(crossItems).unique();*/
        dPos = calcSnapToGrid(false, dPos[0], dPos[1], Ctrl(z).offsetTop);
      }
    }
    var ret = true;
    if (window.ValidMove) {
      ret = window.ValidMove(dPos[0], dPos[1], elementShadow.offsetWidth, elementShadow.offsetHeight, itemsHTML[idx].id, itemsHTML[idx], "move");
    }
    if (!ret && viewMode != designView) { //fermare i spostamenti
      //indicare elemento che ferma i spostamenti se sono pi� di uno
      if (container_selection.e.length > 1) {
        $(elementShadow.id).addClass('highlightErrorMove');
        setTimeout(function () {
          $(elementShadow.id).removeClass('highlightErrorMove');
        }, 250);
      }
      return;
    }
    if (ret) {
      elementShadow.style.left = dPos[0] + 'px';
      elementShadow.style.top = dPos[1] + 'px';
    }
    addRulersLines();
    if (window.afterMoveShadow)
      window.afterMoveShadow(elementShadow);
  }
}

function updateMapItems() {
  var mypos;
  for (var i = 0; i < itemsHTML.length; i++) {
    mypos = itemsHTML[i].y + itemsHTML[i].h;
    if (mypos > Ctrl(itemsHTML[i].zone).offsetTop + Ctrl(itemsHTML[i].zone).offsetHeight)
      mapItems[reportZones[reportZones.indexOf(itemsHTML[i].zone) + 1]].push(i);
  }
}

/** gestione items (upd e canc) **/
function updateAllItemsY() {
  if (Empty(itemsHTML))
    return;

  var calcY;
  for (var i = 0; i < itemsHTML.length; i++) {
    if ($(itemsHTML[i].zone).hasClass("hiddenZone"))
      continue;
    calcY = Ctrl(itemsHTML[i].zone).offsetTop + itemsHTML[i].yRel;
    if (itemsHTML[i].y != calcY) {
      Ctrl(itemsHTML[i].id).style.top = calcY + "px";
      itemsHTML[i].y = calcY;
      var shadow = Strtran(itemsHTML[i].id, "item", "shadow");
      if (Ctrl(shadow)) Ctrl(shadow).style.top = calcY + "px";
      shadow = Strtran(itemsHTML[i].id, "item", "handlersWrapper");
      if (Ctrl(shadow)) Ctrl(shadow).style.top = (calcY - 3) + "px";
    }
  }
}

function updateAllArrays() {
  resetMapItems();

  if (idItemsHTML.indexOf(itemsHTML[index].id) >= 0)
    idItemsHTML.splice(index, 1);

  if (uidItemsHTML.indexOf(itemsHTML[index].uid) >= 0)
    uidItemsHTML.splice(index, 1);
}

function setMapItems() {
  for (var i = 0; i < itemsHTML.length; i++) {
    mapItems[itemsHTML[i].zone].push(i);
  }
}

function resetMapItems() {
  for (var i = 0; i < reportZones.length - 1; i++) {
    mapItems[reportZones[i]] = [];
  }
}
/** fine **/


/** gadget pane generic items **/
function addGenericItems() {
  var items = ZTObjects.genericItems;
  var parDiv = Ctrl("genericitemprop");

  var div, elem;
  for (var i = 0; i < items.length; i++) {
    div = document.createElement("div");
    div.id = "generic_" + items[i].id;
    div.className = "unselectable genericItem fieldObject";
    parDiv.appendChild(div);

    elem = document.createElement("div");
    elem.className = "unselectable iconGenericItem";
    if (items[i].image)
      elem.className += (" " + items[i].image);
    elem.title = items[i].title;
    div.appendChild(elem);

    elem = document.createElement("div");
    elem.className = "unselectable textGenericItem";
    elem.textContent = getTranslated("SMR_" + items[i].title, items[i].title); //items[i].title;
    //SMR_LABEL //SMR_HORIZONTALLINE //SMR_IMAGE
    //SMR_CURRENTDATETTIME //SMR_PAGENUMERATION
    //SMR_CONTINUE //SMR_SIGNATUREMARKUP
    div.appendChild(elem);

    var met = " onmouseenter='" + items[i].action + "'";
    //met += " ontouchstart='"+items[i].action+"'";
    var tmp = div.outerHTML.splice(div.outerHTML.indexOf(">"), 0, met);
    div.outerHTML = tmp;
  }
}

function unSelectItem(itm) { //REFIFINED
  OnEditProp = false;
  var i;
  var mainitemz = itm;
  var unselecteditem = mainitemz.id.substr(6);
  var indexz = -1;
  //if(index==selecteditem) return; //selecteditem NON indica la posizione nell'array!!!
  for (i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow == mainitemz.id) {
      indexz = i;
    }
  }

  if (indexz >= 0) {
    itm.style.display = 'none';
    itemsHTML[indexz].shadow = '';
    /*Ctrl("handler" + unselecteditem + "_0").style.display='none';
    Ctrl("handler" + unselecteditem + "_1").style.display='none';
    Ctrl("handler" + unselecteditem + "_2").style.display='none';
    Ctrl("handler" + unselecteditem + "_3").style.display='none';*/
    Ctrl("handler" + unselecteditem + "_4").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_5").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_6").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_7").style.display = 'none';
    Ctrl("handlersWrapper" + unselecteditem).style.display = 'none';
    Ctrl("canvashandlers").removeChild(itm);
    Ctrl("canvashandlers").removeChild(Ctrl("handlersWrapper" + unselecteditem));
    if (container_selection.e.indexOf(indexz) >= 0) container_selection.e.splice(container_selection.e.indexOf(indexz), 1);
    if (mainitem && mainitem.id == mainitemz.id) {
      for (i = 0; i < itemsHTML.length; i++) {
        if (itemsHTML[i].shadow && Ctrl(itemsHTML[i].shadow)) {
          return selectItem(Ctrl(itemsHTML[i].shadow));
        }
      }
      removeAllHandlers();
    }
  }
}

function setRelativeTop(element_tmp, elementtomove) {
  if (viewMode != designView) {
    var borders = 0;
    parent = Ctrl(element_tmp.id).parentNode;
    element_tmp.yRel = elementtomove.offsetTop + Ctrl("backcanvas").offsetTop - getY(elementtomove.parentNode);
    elementtomove.style.top = (element_tmp.yRel - borders) + "px";
    element_tmp.x = elementtomove.offsetLeft + Ctrl("backcanvas").offsetLeft - getX(elementtomove.parentNode) - borders;
    elementtomove.style.left = element_tmp.x + "px";
  }
  else
    element_tmp.yRel = element_tmp.y - Ctrl(element_tmp.zone).offsetTop;
}


function plusMargin(marg) {
  var w, h;
  if (formProp.pformat == 'custom') {
    w = formProp.pwidth + "mm";
    h = formProp.pheight + "mm";
  }
  else {
    w = docSettings[formProp.pformat].w;
    h = docSettings[formProp.pformat].h;
  }

  var ww = convertStringToPx(w);
  var hh = convertStringToPx(h);
  if (marg == 'top')
    plus_margin(Ctrl('inp_margin_top'), 'mtheight', hh);
  else if (marg == 'left')
    plus_margin(Ctrl('inp_margin_left'), 'mlwidth', ww);
  else if (marg == 'right')
    plus_margin(Ctrl('inp_margin_right'), 'mrwidth', ww);
  else if (marg == 'bottom')
    plus_margin(Ctrl('inp_margin_bottom'), 'mbheight', hh);
}

function plus_margin(ctrl, prop, limit) {
  var v = ctrl.value;
  var vv = parseFloat(v);
  if (isNaN(vv)) return;
  var u = Strtran(v, vv + "", "");
  if (u == "") u = workunit;
  vv = vv + 1;
  var vc = convertStringToPx(vv + u, limit);
  if (limit && vc > (limit / 2)) return;
  ctrl.value = vv + u;
  SetPrintProp(ctrl.value, prop);
}

function minusMargin(marg) {
  if (marg == 'top')
    minus_margin(Ctrl('inp_margin_top'), 'mtheight');
  else if (marg == 'left')
    minus_margin(Ctrl('inp_margin_left'), 'mlwidth');
  else if (marg == 'right')
    minus_margin(Ctrl('inp_margin_right'), 'mrwidth');
  else if (marg == 'bottom')
    minus_margin(Ctrl('inp_margin_bottom'), 'mbheight');
}

function minus_margin(ctrl, prop) {
  var v = ctrl.value;
  var vv = parseFloat(v);
  if (isNaN(vv)) return;
  var u = Strtran(v, vv + "", "");
  if (u == "") u = workunit;
  vv = vv - 1;
  if (vv < 0) return;
  ctrl.value = vv + u;
  SetPrintProp(ctrl.value, prop);
}

function setMargin(marg) {
  var w = docSettings[formProp.pformat].w;
  var h = docSettings[formProp.pformat].h;
  var ww = convertStringToPx(w);
  var hh = convertStringToPx(h);

  if (marg == 'top') check_margin(Ctrl('inp_margin_top'), 'mtheight', hh);
  else if (marg == 'left') check_margin(Ctrl('inp_margin_left'), 'mlwidth', ww);
  else if (marg == 'right') check_margin(Ctrl('inp_margin_right'), 'mrwidth', ww);
  else if (marg == 'bottom') check_margin(Ctrl('inp_margin_bottom'), 'mbheight', hh);
}

function check_margin(ctrl, prop, limit) {
  var v = ctrl.value;
  var vc = convertStringToPx(v, limit);
  if (vc < 0 || vc > (limit / 2)) {
    Ctrl('inp_margin_top').value = formProp[prop];
  }
  else
    SetPrintProp(ctrl.value, prop);
}

/** fine **/


Array.prototype.unique = function () {
  var a = this.concat();
  for (var i = 0; i < a.length; ++i) {
    for (var j = i + 1; j < a.length; ++j) {
      if (a[i] === a[j])
        a.splice(j--, 1);
    }
  }

  return a;
};

function updateMapFieldCount(alias) {
  mapFieldCount[alias]--;
  setUsedField(alias);
}

function drawFieldList(/*itemObj*/) {
  $("shadowmenu").removeClass("titleContainer");
  $("shadowmenu").addClass("buttonContainer");
  $("shadowmenu").addClass("shadowWidth");
  var elem;
  var pID = "boxcontainer";
  Ctrl(pID).className = "shadowHeight";
  elem = document.createElement("div");
  elem.id = "fieldListCombo";
  elem.className = "unselectable combolist";
  Ctrl(pID).appendChild(elem);
  var mfieldlist = orderFieldListByUsed();
  for (var i = 0; i < mfieldlist.length; i++) {
    elem = document.createElement("span");
    elem.id = "fldopt_" + i;
    elem.className = "unselectable fieldlistopt";
    elem.innerHTML = ToStringHTML(mfieldlist[i].desc);
    Ctrl("fieldListCombo").appendChild(elem);
    Ctrl("fldopt_" + i).onmouseover = highlightFieldOpt;
    Ctrl("fldopt_" + i).onmouseout = removeHighlightFieldOpt;
    Ctrl("fldopt_" + i).onclick = chooseField;
    Ctrl("fldopt_" + i).setAttribute("data-attr", mfieldlist[i].alias);
  }

  elem = document.createElement("div");
  elem.id = "bottomList";
  Ctrl(pID).appendChild(elem);
  elem = document.createElement("span");
  elem.id = "cancelTextBtn";
  elem.className = "cancelItemBtn iconbtnToolbar";
  Ctrl("bottomList").appendChild(elem);
  elem = document.createElement("span");
  elem.id = "saveTextBtn";
  elem.className = "saveItemBtn iconbtnToolbar";
  Ctrl("bottomList").appendChild(elem);

  Ctrl("saveTextBtn").onclick = saveEditInput;
  Ctrl("cancelTextBtn").onclick = exitEditInput;
  Ctrl("canvas").onmousedown = null;
}

function orderFieldListByUsed() {
  var ret = [];
  var retu = [];
  for (var i = 0; i < fieldHTML.length; i++) {
    if (Ctrl("fld_li_" + fieldHTML[i].alias)) {
      if ($("fld_li_" + fieldHTML[i].alias).hasClass("used"))
        retu.push(fieldHTML[i]);
      else
        ret.push(fieldHTML[i]);
    }
  }
  return ret.concat(retu);
}

var ftim;
var prevItem = "";
function chooseField(e) {
  if (!e)
    e = window.event;

  var cItem = GetEventSrcElement(e);

  if (prevItem != cItem.id && !Empty(prevItem)) {
    $(prevItem).removeClass("flistchecked");
    Ctrl(prevItem).onmouseout = removeHighlightFieldOpt;
  }

  if (ftim) {
    clearTimeout(ftim);
    ftim = null;
    // DBLCLICK
    saveEditInput();
  }
  else {
    ftim = setTimeout(function (/*e*/) {
      ftim = null;
      // CLICK
      Ctrl(cItem.id).onmouseout = null;
    }, 250);
  }

  prevItem = cItem.id;
}

function highlightFieldOpt(e) {
  if (!e)
    e = window.event;

  var item = GetEventSrcElement(e);
  if (!item)
    return;

  $(item.id).addClass("flistchecked");
}

function removeHighlightFieldOpt(e) {
  if (!e)
    e = window.event;

  var item = GetEventSrcElement(e);
  if (!item)
    return;

  $(item.id).removeClass("flistchecked");
}

function replaceMissingField(itemObj, field) {
  setLoading();
  var fieldRef = getFieldInfo("itmFld_" + getDataAttr(field));
  setMissingFieldItemObj(itemObj, fieldRef);
  UpdateDesignObj(itemObj, "missing");

  if (!Empty(itemObj.fieldLabel)) {
    var flabel = getItemFieldUid(itemObj.fieldLabel, "label", m_CurrentObj);
    flabel.value = fieldRef.desc;
  }

  if (!Empty(itemObj.fieldTotal)) {
    var ftot = getItemFieldUid(itemObj.fieldTotal, "field", m_CurrentObj);
    ftot.fieldDetail.alias = fieldRef.alias;
    ftot.fieldDetail.desc = fieldRef.desc;
    ftot.fieldDetail.type = fieldRef.type;
    ftot.fieldDetail.len = fieldRef.len;
    ftot.fieldDetail.dec = fieldRef.dec;
    if (fieldRef.type != "N") {
      var zonef = Strtran(getItemZone(ftot), "content", "");
      m_CurrentObj[zonef].items.splice(m_CurrentObj[zonef].items.indexOf(ftot), 1);
    }
  }

  drawEditor();
}

function setMissingFieldItemObj(itemObj, fieldRef) {
  itemObj.fieldDet.alias = fieldRef.alias;
  itemObj.fieldDet.desc = fieldRef.desc;
  itemObj.fieldDet.type = fieldRef.type;
  itemObj.fieldDet.len = fieldRef.len;
  itemObj.fieldDet.dec = fieldRef.dec;
  switch (itemObj.fieldDet.type) {
    case "C":
    case "M":
      itemObj.typeView = "text";
      break;
    case "N":
      itemObj.typeView = "numeric";
      break;
    case "D":
      itemObj.typeView = "date";
      break;
    case "T":
      itemObj.typeView = "datetime";
      break;
    case "I":
      itemObj.typeView = "image";
      break;
    default:
      itemObj.typeView = "text";
      break;
  }
  itemObj.isMissing = false;

  if (Ctrl(itemObj.id + "_missing"))
    Ctrl(itemObj.id).removeChild(Ctrl(itemObj.id + "_missing"));

  Ctrl(itemObj.id + "_int").innerHTML = "[" + ToStringHTML(ConvertToView(itemObj, itemObj.isGeneric)) + "]";
}

function replaceBreakField(itBreak, field) {
  if (!field) return;
  var fieldRef = fieldHTML[parseInt(field.id.substring(field.id.indexOf("_") + 1, field.id.length))];

  if (Ctrl(itBreak + "_missing"))
    Ctrl(itBreak).removeChild(Ctrl(itBreak + "_missing"));

  gBreakFields.splice(gBreakFields.indexOf(itBreak), 1, fieldRef.alias);
  var newID = "groupbreakFIELD_" + fieldRef.alias;
  var ctrlLabel = Ctrl(itBreak).firstChild;
  ctrlLabel.firstChild.id = newID + "_text";
  ctrlLabel.firstChild.innerHTML = ToStringHTML(fieldRef.desc);
  ctrlLabel.lastChild.id = newID + "fieldswitch";
  ctrlLabel.lastChild.title = "Remove (" + fieldRef.alias + ")";
  ctrlLabel.setAttribute("for", newID + "field");
  Ctrl(itBreak).title = fieldRef.desc;
  Ctrl(itBreak).id = newID;
  if (m_CurrentObj == null) m_CurrentObj = getFromDesignObj();
  m_CurrentObj.groupbreak.items = gBreakFields;
  pushToHistory();
}

function drawEditContentArea(div, propID, tooltip, placeholder, notitle, title) {
  var cont = document.createElement("div");
  cont.className = "textcontainer";
  div.appendChild(cont);

  if (!notitle) {
    var elem = document.createElement("span");
    elem.className = "shadowtitlediv shadowtitledivnone";
    elem.textContent = Empty(title) ? "   " : getTranslated("SMR_" + title, title); //SMR_REPORTCOMMENT
    cont.appendChild(elem);
  }

  elem = document.createElement("textarea");
  elem.id = propID;
  elem.className = "propInputDiv";
  elem.title = tooltip;
  if (placeholder)
    elem.placeholder = getTranslated("SMR_" + placeholder, placeholder); //SMR_INSERTCOMMENT //SMR_EDITTEXTCONTENT
  cont.appendChild(elem);
  elem.onfocus = function () {
    var id = this.id;
    $(id + "_ok").removeClass("hiddenAdd");
    $(id + "_cancel").removeClass("hiddenAdd");
  };
  elem.onblur = saveContent;

  elem = document.createElement("span");
  elem.id = propID + "_cancel";
  elem.className = "propInputBtn smartreport-icon-cancel hiddenAdd";
  elem.title = getTranslated("SMR_CANCEL", "Cancel");
  cont.appendChild(elem);
  elem.onmousedown = exitContent;

  elem = document.createElement("span");
  elem.id = propID + "_ok";
  elem.className = "propInputBtn smartreport-icon-confirm hiddenAdd";
  elem.title = getTranslated("SMR_APPLY", "Apply");
  cont.appendChild(elem);
  elem.onmousedown = saveContent;
}

function drawReportComment(itemObj, props/*, refDiv*/) {
  var pID = "boxcontainer";
  for (var i = 0; i < props.length; i++) {
    switch (props[i].propID) {
      case "repcomment":
        var t = getTranslated(props[i].tooltip_code, props[i].tooltip);
        drawEditContentArea(Ctrl(pID), props[i].propID, t, "Insert comment", false, "Report comment");
        Ctrl(props[i].propID).textContent = formProp[props[i].propID];
        break;
    }
  }

}

function saveContent(e) {
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  var id = "";
  if (!$(ctrl.id).hasClass("hiddenZone")) {
    id = Strtran(ctrl.id, "_area", "");
    id = Strtran(id, "_ok", "");
    if (!Ctrl(id))
      return;
    if (id.indexOf("repcomment") >= 0) {
      formProp.repcomment = Ctrl(id).value;
      if (m_CurrentObj)
        m_CurrentObj.comment = formProp.repcomment;
    }
    else {  // label
      var item = itemsHTML[getUidItemsHTMLIndex(id)];
      id = item.uid;
      for (var i = 0; i < container_selection.e.length; i++) {
        item = itemsHTML[container_selection.e[i]];
        item.value = Ctrl(id).value;
        Ctrl(item.id + "_int").textContent = item.value;
        if (item.typeView == 'signmup') {
          item.title = item.value;
          UpdateDesignObj(item, "signmup");
        }
        else
          UpdateDesignObj(item, "value");
      }
    }

    $(id).removeClass("hiddenZone");
    $(id + "_ok").addClass("hiddenAdd");
    $(id + "_cancel").addClass("hiddenAdd");
    Ctrl("canvas").onmousedown = beginDragSelection;
  }
}

function exitContent(e) {
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  var id = ctrl.id;
  id = Strtran(ctrl.id, "_area", "");
  id = Strtran(id, "_cancel", "");
  if (Ctrl(id)) {
    if (id.indexOf("repcomment") >= 0) {
      Ctrl(id).value = formProp.repcomment;
    }
    else {
      var item = itemsHTML[getUidItemsHTMLIndex(id)];
      id = item.uid;
      for (var i = 0; i < container_selection.e.length; i++) {
        item = itemsHTML[container_selection.e[i]];
        if (item.value)
          Ctrl(id).value = item.value;
        else
          Ctrl(id).value = "";
      }
    }

    $(id).removeClass("hiddenZone");
    $(id + "_ok").addClass("hiddenAdd");
    $(id + "_cancel").addClass("hiddenAdd");
  }
  Ctrl("canvas").onmousedown = beginDragSelection;
}

function getSpanTag() {  //span che mi serve per il calcolo margini
  var spanId = "smartreport_myspan";
  var mySpan = document.getElementById(spanId);
  if (Empty(mySpan)) {
    mySpan = document.createElement("span");
    mySpan.id = spanId;
    mySpan.className = "unselectable";
    document.body.appendChild(mySpan);
    mySpan.style.visibility = 'hidden';
    mySpan.style.display = 'inline-block';
    mySpan.style.width = 'max-content';
  }
  return mySpan;
}

function removeSpanTag() {
  var spanId = "smartreport_myspan";
  var mySpan = document.getElementById(spanId);
  if (!Empty(mySpan))
    document.body.removeChild(mySpan);
}

function checkControl(e) {
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  if (!ctrl.checked) {
    if (checks.indexOf(ctrl.id) >= 0)
      checks.splice(checks.indexOf(ctrl.id), 1);
  }
  else {
    if (checks.indexOf(ctrl.id) < 0)
      checks.push(ctrl.id);
  }
}

function getDatasourceFields(ds, isoffl/*, isPS*/) {
  var allFields = [];
  if (!Empty(ds)) {
    if (ds.indexOf("[") >= 0) {
      var p0 = ds.indexOf("[");
      var p1 = ds.indexOf("]");
      if (p0 < 0 || p1 < 0 || (p0 > p1)) return allFields;
      var configname = ds.substring(0, p0);
      var tablename = ds.substring(p0 + 1, p1);
      var custom = false;
      if (configname.indexOf("1/") == 0) {
        custom = true;
        configname = configname.substring(2, configname.length);
      }
      var resp = new JSURL("../servlet/SPVZMProxy?Custom=" + custom + "&action=load&table=" + URLenc(tablename) + "&configname=" + URLenc(configname) /*+ "&Custom="+URLenc(custom)+"&offlinemode="+URLenc(offlinemode)*/, true);
      var jsonconfiguration;
      try {
        jsonconfiguration = JSON.parse(resp.Response());
      } catch (e) {
        PSAlert.alert('Errore in caricamento del file zoom');
        return allFields;
      }
      var qallFields = MGetQueryFields(jsonconfiguration.config.vqrname, true, null, isoffl);
      putInListFromJs(jsonconfiguration.cols, qallFields, allFields, false, false);
      putInListFromJs(jsonconfiguration.rowlayer, qallFields, allFields, false, true);
      verifyHiddenFields(jsonconfiguration.hiddenfields, qallFields, allFields);
    }
    else {
      var fieldList = MGetQueryFields(ds, true, null, isoffl);
      var totF = fieldList[0].length;
      for (var i = 0; i < totF; i++) {
        allFields.push({
          alias: fieldList[0][i],
          desc: Empty(fieldList[1][i]) ? fieldList[0][i] : fieldList[1][i],
          type: fieldList[2][i],
          len: fieldList[3][i],
          dec: fieldList[4][i],
          rowlayer: false,
          collayer: false,
          extfield: false,
          hiddenfield: false
        });
      }
    }
  }
  return allFields;
}

function putInListFromJs(columnsObj, qallFields, allFields, collayer, rowlayer) {
  if (Empty(columnsObj)) return;
  var totF = columnsObj.length;

  var i, lalias = "";
  for (i = 0; i < allFields.length; i++) lalias += "###" + allFields[i].alias + "###";
  for (i = 0; i < totF; i++) {
    var type = 'C';
    var len = 100;
    var dec = 0;
    var find = false;
    for (var j = 0; !find && j < qallFields[0].length; j++) {
      if (qallFields[0][j].toLowerCase() == columnsObj[i].field.toLowerCase()) {
        type = qallFields[2][j];
        len = qallFields[3][j];
        dec = qallFields[4][j];
        find = true;
      }
    }

    if (columnsObj[i].isImage) type = 'I';
    if (columnsObj[i].checkbox) type = 'L';
    if (columnsObj[i].field.indexOf('html:') == 0) { }
    else if (columnsObj[i].enable_HTML == true) { }
    else if (lalias.indexOf("###" + columnsObj[i].field + "###") >= 0) { }
    else {
      allFields.push({
        alias: columnsObj[i].field,
        desc: Empty(columnsObj[i].title) ? columnsObj[i].field : columnsObj[i].title,
        type: type,
        len: len,
        dec: dec,
        rowlayer: rowlayer,
        collayer: collayer,
        extfield: (columnsObj[i].inExtGrid) ? columnsObj[i].inExtGrid : false,
        hiddenfield: false
      });
    }
    putInListFromJs(columnsObj[i].Layer, qallFields, allFields, true, rowlayer);
  }
}

function verifyHiddenFields(aliasObj, qallFields, allFields) {
  var found = false;
  for (var i = 0; i < qallFields[0].length; i++) {
    if (qallFields[0][i] in aliasObj) {
      found = false;
      for (var j = 0; j < allFields.length; j++) {
        if (allFields[j].alias == qallFields[0][i])
          found = true;
      }
      if (!found) {
        allFields.push({
          alias: qallFields[0][i],
          desc: Empty(qallFields[1][i]) ? qallFields[0][i] : qallFields[1][i],
          type: qallFields[2][i],
          len: qallFields[3][i],
          dec: qallFields[4][i],
          rowlayer: false,
          collayer: false,
          extfield: false,
          hiddenfield: true
        });
      }
    }
  }
}

function calculateMaxWidth(fldobj, fromprint) {
  if( maxwidthmap[fldobj.alias] )
    return maxwidthmap[fldobj.alias];
  var fontf = { name: "Helvetica", size: 10 * ptTopx, weight: "normal" },
    fontl = { name: "Helvetica", size: 10 * ptTopx, weight: "normal" };
  if (fromprint) {
    fontf.size = 7 * ptTopx;
    fontl.size = 7 * ptTopx;
    fontl.weight = "bold";
  }
  var lblw = getOffsetWidth(fldobj.desc, fontl),
    flddesc = "",
    flen = (fldobj.type == "M") ? 100 : fldobj.len;
  var i, w = divLen,
    fldw = Math.min(w, (lenFactor * flen));
  if( fldobj.descs ) {
    for (i = 0; i < fldobj.descs.length; i++)
      lblw = Math.max(lblw, getOffsetWidth(fldobj.descs[i], fontl))
  } 
  switch (fldobj.type) {
    case "C":
    case "M":
      for (i = 0; i < parseInt(flen); i++)
        flddesc += "W";
      break;
    case "N":
      for (i = 0; i < parseInt(flen); i++)
        flddesc += "9";
      break;
    case "D":
      flddesc = "YYYY-MM-DD";
      break;
    case "T":
      flddesc = "YYYY-MM-DD HH:MM:SS";
      break;
    default:  // I
      break;
  }
  if (fromprint && (fldobj.type == "I" || !Empty(fldobj.html)))  // per le immagini, solo nel caso di stampa automatica, valuto le vere dimensioni con la desc
    flddesc = fldobj.desc;

  fldw = Math.max(fldw, getOffsetWidth(flddesc, fontf));
  var col_width = Math.min(w, Math.max(lblw, fldw));
  if (!Empty(fldobj.column_width)) {
    col_width = Math.min(col_width, fldobj.column_width);
  }
  return col_width;
}

function addPositionNext(item, pos, arr) {
  if (Empty(item[pos]))
    return arr;
  var idx = getUidItemsHTMLIndex(item[pos]);
  if (arr.indexOf(idx) < 0)
    arr.push(idx);
  addPositionNext(itemsHTML[getUidItemsHTMLIndex(item[pos])], pos, arr);
}

function getItemsMaxWidth(myitems) {
  var w0 = 0;
  for (var i = 0; i < myitems.length; i++) {
    w0 = Math.max(w0, itemsHTML[myitems[i]].w);
  }
  return w0;
}

function getItemsMaxHeight(myitems) {
  var h0 = 0;
  for (var i = 0; i < myitems.length; i++) {
    h0 = Math.max(h0, itemsHTML[myitems[i]].h);
  }
  return h0;
}

function replaceItemPositions(olditem, newitem) {
  newitem.x = olditem.x;
  newitem.y = olditem.y;
  newitem.yRel = olditem.yRel;
  Ctrl(newitem.id).style.left = newitem.x + "px";
  Ctrl(newitem.id).style.top = newitem.y + "px";
}

function getCrossZoneItems(zone) {
  var idx = reportZones.indexOf(zone);
  if (idx < 0)
    return;
  var ret = [];
  var items = getAreaItems(reportZones[idx - 1]);
  var tmpy = 0;
  for (var i = 0; i < items.length; i++) {
    if (Ctrl(itemsHTML[items[i]].id + "_yLine"))
      tmpy = itemsHTML[items[i]].y + Ctrl(itemsHTML[items[i]].id + "_yLine").offsetWidth + catcherSize;
    else
      tmpy = itemsHTML[items[i]].y;
    if (tmpy > Ctrl(zone).offsetTop)
      ret.push(items[i]);
  }
  return ret;
}

function setStretchRight(e) {
  var propCtrl = GetEventSrcElement(e || window.event);
  var isChecked = currentItem[propCtrl.id];

  currentItem[propCtrl.id] = !isChecked;
  isChecked = currentItem[propCtrl.id];
  changeBackgroundIconButton(propCtrl, isChecked);
  UpdateDesignObj(currentItem, "font");
}

function UpdateDesignObj(itemObj, prop, allFldsObj) {
  var j, i, found_item;
  if (!Empty(prop) && prop.indexOf("highlight") >= 0) {
    //itemobj as uid-uidfor
    for (i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].uidfor == itemObj) {
        if (!$(itemsHTML[i].id).hasClass(prop))
          $(itemsHTML[i].id).addClass(prop)
        else
          $(itemsHTML[i].id).removeClass(prop);
      }
    }
  }

  if (!Empty(itemObj.uidfor) && !Empty(m_CurrentObj)) {
    var zone = m_CurrentObj[Strtran(itemObj.zone, 'content', '')],
      mitem, o;
    if (itemObj.prevzone && prop == 'zone') {
      var prevzone = m_CurrentObj[Strtran(itemObj.prevzone, 'content', '')];
      for (j = 0; j < prevzone.items.length; j++) {
        found_item = (prevzone.items[j].uid == itemObj.uidfor);
        if (itemObj.isAllFields)
          found_item = (prevzone.items[j].uidfor == itemObj.uidfor);
        if (found_item) {
          o = prevzone.items[j];
          prevzone.items.splice(j, 1);
          zone.items.push(o);
          if (itemObj.isAllFields) {
            for (var ff = 0; ff < _allFieldsHTML.length; ff++) {
              if (_allFieldsHTML[ff][itemObj.type].uidfor == itemObj.uidfor)
                _allFieldsHTML[ff][itemObj.type].zone = itemObj.zone;
            }
          }
          else
            j = prevzone.items.length + 10;
        }
      }
    }
    if (prop == 'remove') {
      var flabel, zoneflabel;
      if (!Empty(itemObj.fieldLabel)) {
        flabel = getItemFieldUid(itemObj.fieldLabel, "label", m_CurrentObj);
        if (!Empty(flabel)) {
          zoneflabel = Strtran(getItemZone(flabel), "content", "");
          m_CurrentObj[zoneflabel].items.splice(m_CurrentObj[zoneflabel].items.indexOf(flabel), 1);
        }
      }
      removeLabelReferenceFromField(itemObj, "fieldLabel");
      if (itemObj.isMissing) {
        if (!Empty(itemObj.fieldTotal)) {
          flabel = getItemFieldUid(itemObj.fieldTotal, "field", m_CurrentObj);
          if (!Empty(flabel)) {
            zoneflabel = Strtran(getItemZone(flabel), "content", "");
            m_CurrentObj[zoneflabel].items.splice(m_CurrentObj[zoneflabel].items.indexOf(flabel), 1);
          }
        }
        removeLabelReferenceFromField(itemObj, "fieldTotal");
      }

      var toremove = [],
        endFor = false;
      for (j = 0; j < zone.items.length && !endFor; j++) {
        var found = (zone.items[j].uid == itemObj.uidfor ||
          (zone.items[j].isAllFields && itemObj.isAllFields && (zone.items[j].type == itemObj.type))
        );
        if (found) {
          toremove.push(j);
          endFor = !itemObj.isAllFields && found;
        }
      }
      if (!Empty(toremove)) {
        toremove.reverse();
        for (j = 0; j < toremove.length; j++)
          zone.items.splice(toremove[j], 1);
      }
      SetUpdated();
      return;
    }
    if (prop == 'zonecheck') {
      var f = false;
      for (j = 0; j < zone.items.length && !f; j++) {
        if (zone.items[j].uid == itemObj.uidfor) {
          f = true;
        }
      }
      if (!f) {
        if (!itemObj.isAllFields) {
          o = makeJsonItem(itemObj);
          o.uid = itemObj.uidfor;
          zone.items.push(o);
        }
      }
    }
    if (prop == "addallflds")
      zone.items.push(makeJsonItemAllFields(itemObj, allFldsObj));
    for (j = 0; j < zone.items.length; j++) {
      found_item = (zone.items[j].uid == itemObj.uidfor);
      if (itemObj.isAllFields)
        found_item = (zone.items[j].uidfor == itemObj.uidfor);
      if (found_item && prop != "addallflds") {
        if (itemObj.isAllFields) {
          var fldObj = _allFieldsHTML[fieldHTMLMap[zone.items[j].ref_alias]][zone.items[j].type];
          updateJsonItemAllFields(zone.items[j], itemObj, fldObj);
        }
        else {
          zone.items[j] = makeJsonItem(itemObj);
          zone.items[j].uid = itemObj.uidfor;
        }
        if (viewMode != designView) {
          var l = document.getElementsByClassName(itemObj.uidfor);
          for (i = 0; i < l.length; i++) {
            mitem = itemsHTML[getItemsHTMLIndex(l[i].id)];
            switch (prop) {
              case 'position':
                l[i].style.left = itemObj.x + "px";
                l[i].style.top = itemObj.yRel + "px";
                l[i].style.width = itemObj.w + "px";
                l[i].style.height = itemObj.h + "px";
                mitem.x = itemObj.x;
                mitem.yRel = itemObj.yRel;
                mitem.w = itemObj.w;
                mitem.h = itemObj.h;
                setModifiedZone(itemObj.zone);
                break;
              case 'font':
                if (itemObj.type != "line") {
                  updateFontProperties(zone.items[j], mitem);
                }
                else {
                  l[i].style.backgroundColor = Ctrl(itemObj.id).style.backgroundColor;
                  l[i].style.height = Ctrl(itemObj.id).style.offsetHeight + "px";
                  setLineObj(mitem);
                }
                break;
              case 'value':
                if (itemObj.type == "label") {
                  Ctrl(l[i].id + "_int").textContent = itemObj.value;
                  mitem.value = itemObj.value;
                }
                break;
              case "calc":
                mitem.calculate = itemObj.calculate;
                mitem.calcbygrp = itemObj.calcbygrp;
                setCalculation(mitem);
                break;
              case "pagenum":
                mitem.pageN = itemObj.pageN;
                mitem.fieldDet.desc = itemObj.pageN;
                Ctrl(mitem.id + "_int").innerHTML = "[" + ToStringHTML(mitem.fieldDet.desc) + "]";
                if (mitem.pageN == "Total pages") {
                  $(mitem.id).removeClass('pagenumber');
                  $(mitem.id).addClass('totalpages');
                }
                else if (mitem.pageN == "Page number") {
                  $(mitem.id).removeClass('totalpages');
                  $(mitem.id).addClass('pagenumber');
                }
                break;
              case "datetime":
                mitem.dateformat = itemObj.dateformat;
                mitem.timeformat = itemObj.timeformat;
                Ctrl(mitem.id + "_int").textContent = "[" + ConvertToView(mitem, mitem.isGeneric) + "]";
                break;
              case "signmup":
                mitem.typeView = itemObj.typeView;
                mitem.dateformat = itemObj.dateformat;
                mitem.timeformat = itemObj.timeformat;
                mitem.sequence = itemObj.sequence;
                mitem.brequired = itemObj.brequired;
                mitem.bgeoposition = itemObj.bgeoposition;
                mitem.bhideextra = itemObj.bhideextra;
                mitem.title = itemObj.title;
                break;
              case "barcode":
              case "fcoloron":
              case "fcoloroff":
              case "barcodetype":
                mitem.typeView = itemObj.typeView;
                mitem.barcodetype = itemObj.barcodetype;
                mitem.fcoloroff = itemObj.fcoloroff;
                mitem.fcoloron = itemObj.fcoloron;
                mitem.qrcodecorrection = itemObj.qrcodecorrection;
                updateBarcodeProperties(zone.items[j], mitem);
                break;
              case "image":
                mitem.typeView = itemObj.typeView;
                updTextToImage(mitem);
                if (mitem.typeView == "image")
                  mitem.imgPath = itemObj.imgPath;
                break;
              case "missing":
                mitem.uidfor = zone.items[j].uid;
                setMissingFieldItemObj(mitem, itemObj.fieldDet);
                break;
            }
          }
          if (prop == 'pagenum')
            fpagenumber();
        }
        if (!itemObj.isAllFields)
          j = zone.items.length;
      }
    }
    if (prop == "image" || prop == "barcode" || prop == "text") {
      setLoading();
      drawEditor();
    }
    else if (itemObj.split) {
      setLoading();
      drawEditor();
    }
    SetUpdated();
  }
}

function updateFieldSwitch() {
  for (var i = 0; i < fieldHTML.length; i++) {
    if (mapFieldCount[fieldHTML[i].alias] == 0 && Ctrl("switch_" + fieldHTML[i].alias)) {
      Ctrl("switch_" + fieldHTML[i].alias).firstChild.checked = false;
      manageOnOff(null, Ctrl("switch_" + fieldHTML[i].alias).firstChild, true);
    }
  }
}

function filterFields(e, ctrl) {
  e = (e) ? e : window.event;
  ctrl = (ctrl) ? ctrl : GetEventSrcElement(e);
  var idcont = Ctrl(ctrl.name + "_lbl").parentNode.className;
  var fld, id = "";
  var fldspace;
  if (idcont == "fieldLegend")
    id = "li_";
  for (var i = 0; i < fieldHTML.length; i++) {
    fld = Ctrl("fld_" + id + fieldHTML[i].alias);
    fldspace = Ctrl("fld_" + fieldHTML[i].alias + "_space");
    if (!Ctrl("notused").checked && !Ctrl("used").checked) {
      $(fld.id).addClass("hiddenAdd");
      if (!Empty(fldspace))
        $(fldspace.id).addClass("hiddenAdd");
    }
    else if (!Ctrl("notused").checked && $(fld.id).hasClass("notused")) {
      $(fld.id).addClass("hiddenAdd");
      if (!Empty(fldspace))
        $(fldspace.id).addClass("hiddenAdd");
    }
    else if (!Ctrl("used").checked && $(fld.id).hasClass("used")) {
      $(fld.id).addClass("hiddenAdd");
      if (!Empty(fldspace))
        $(fldspace.id).addClass("hiddenAdd");
    }
    else {
      $(fld.id).removeClass("hiddenAdd");
      if (!Empty(fldspace))
        $(fldspace.id).removeClass("hiddenAdd");
    }
  }
}

function updateMCurrentObj(propID, value) {
  if (m_CurrentObj == null)
    return;
  updateObject(m_CurrentObj, propID, value);
  if (propID == 'structureGrid.unit') {
    Ctrl("marginright_int").innerHTML = convertPxToString(gwork.marginr, workunit);
    Ctrl("marginleft_int").innerHTML = convertPxToString(gwork.marginl, workunit);
    Ctrl("margintop_int").innerHTML = convertPxToString(gwork.margint, workunit);
    Ctrl("marginbottom_int").innerHTML = convertPxToString(gwork.marginb, workunit);
  }
  //SetUpdated();
}

function updateObject(object, path, value) {
  var stack = path.split('.');
  while (stack.length > 1) {
    object = object[stack.shift()];
  }
  var s = stack.shift();
  if (object[s] != value) object[s] = value;

}

function actionOnField(e) {
  var ctrl = GetEventSrcElement(e);
  var alias = ctrl.name;
  if (m_CurrentObj == null)
    return;

  var idx = getPosInList(alias);
  var zone = Strtran(gselectzone.replace(/[0-9]/g, ""), "zpagem", "");
  if (Empty(zone)) return;
  if (ctrl.checked) {// aggiungo
    setLoading();
    addDocField(alias, zone);
    addFieldUsedClass(idx + "_" + alias + "_fld");
    $(idx + "_" + alias + "_drag").removeClass("hiddenAdd");
    filterFields(null, Ctrl("used"));
    pushToHistory();
    drawEditor();
  }
  else {// cancello
    var msg = getTranslated("SMR_CONFIRMREMOVE", 'Are you sure to remove elements? Also all others related (visible or hidden) fields and labels will be removed!');
    var objparam = {};
    objparam.idx = idx;
    objparam.alias = alias;
    objparam.zone = zone;
    objparam.id = ctrl.id;
    showMessageConfirm(msg, "remove", objparam);
  }
}

function removeFieldConfirm(remove, objparam) {
  if (objparam == null)
    return;
  if (remove) {
    setLoading();
    removeAllHandlers();
    removeFieldUsedClass(objparam.idx + "_" + objparam.alias + "_fld");
    $(objparam.idx + "_" + objparam.alias + "_drag").addClass("hiddenAdd");
    filterFields(null, Ctrl("notused"));
    removeFields(objparam.alias, objparam.zone);
    pushToHistory();
    drawEditor();
  }
  else {
    Ctrl(objparam.id).checked = true;
    manageOnOff(null, Ctrl(objparam.id), true);
  }
}

function getObjModel(lfield) {
  var ret = {};
  var mmodel = 'list';
  ret.model = 'list';
  if (!Empty(lfield)) {
    var flabel = null;
    if (!Empty(lfield.fieldLabel)) flabel = getItemFieldUid(lfield.fieldLabel, 'label', m_CurrentObj);
    var ftotal = null;
    if (!Empty(lfield.fieldTotal)) ftotal = getItemFieldUid(lfield.fieldTotal, null, m_CurrentObj);
    if (!Empty(flabel)) {
      if (getItemZone(lfield) == getItemZone(flabel)) mmodel = "list";
      else if (flabel.position.y == lfield.position.y) mmodel = "list";
      else if (flabel.position.x == lfield.position.x) mmodel = "table";
    }
    else if (!Empty(ftotal)) {
      if (ftotal.position.x == lfield.position.x) mmodel = "table";
    }
    ret.flabel = flabel;
    ret.ftotal = ftotal;
    ret.model = mmodel;
  }
  return ret;
}

function getLastZoneField(zone) {
  var lfield = null;
  if (m_CurrentObj[zone].items.length > 0) {
    for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
      if (m_CurrentObj[zone].items[i].type == 'field') {
        if (lfield == null) {
          lfield = m_CurrentObj[zone].items[i];
          continue;
        }
        if (lfield.position.y == m_CurrentObj[zone].items[i].position.y) {
          if (m_CurrentObj[zone].items[i].position.x > lfield.position.x)
            lfield = m_CurrentObj[zone].items[i];
        }
        else if (m_CurrentObj[zone].items[i].position.y > lfield.position.y) {
          lfield = m_CurrentObj[zone].items[i];
        }
      }
    }
  }
  return lfield;
}

function getPosZoneField(zone, inposition) {
  if (Empty(inposition + '')) return getLastZoneField(zone);
  var lfield = null;
  var count = -1;
  if (m_CurrentObj[zone].items.length > 0) {
    for (var i = 0; i < m_CurrentObj[zone].items.length && (count < inposition); i++) {
      if (m_CurrentObj[zone].items[i].type == 'field') {
        count++;
        if (lfield == null) {
          lfield = m_CurrentObj[zone].items[i];
          continue;
        }
        if (lfield.position.y == m_CurrentObj[zone].items[i].position.y) {
          if (m_CurrentObj[zone].items[i].position.x > lfield.position.x)
            lfield = m_CurrentObj[zone].items[i];
        }
        else if (m_CurrentObj[zone].items[i].position.y > lfield.position.y) {
          lfield = m_CurrentObj[zone].items[i];
        }
      }
    }
  }
  return lfield;
}

function getFirstZoneElement(zone) {
  var lfield = null;
  if (m_CurrentObj[zone].items.length > 0) {
    for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
      if (lfield == null) {
        lfield = m_CurrentObj[zone].items[i];
        continue;
      }
      if (lfield.position.y == m_CurrentObj[zone].items[i].position.y) {
        if (m_CurrentObj[zone].items[i].position.x < lfield.position.x)
          lfield = m_CurrentObj[zone].items[i];
      }
      else if (m_CurrentObj[zone].items[i].position.y < lfield.position.y) {
        lfield = m_CurrentObj[zone].items[i];
      }
    }
  }
  return lfield;
}

function getZoneElementsAfterY(zone, refY) {
  var ret = [];
  for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
    var o = m_CurrentObj[zone].items[i];
    if (o.position.y > refY)
      ret.push(o);
  }
  return ret;
}

function getZoneElementsAfterX(zone, refX) {
  var ret = [];
  for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
    var o = m_CurrentObj[zone].items[i];
    if (o.position.x > refX)
      ret.push(o);
  }
  return ret;
}

function removeFields(alias, zone) {
  var items = getUidItemsFromAlias(alias);
  var rret = {};
  for (var i = items.length - 1; i >= 0; i--) {
    var lfield = getItemFieldUid(items[i], null, m_CurrentObj);
    var r = getObjModel(lfield);
    var ret, k, o, idx;
    if (r.model == 'table') {
      zone = getItemZone(lfield);
      var rx = lfield.position.x;
      ret = getZoneElementsAfterX(zone, lfield.position.x);
      var rxx = getMinXPosition(ret);
      for (k = 0; k < ret.length; k++) {
        o = ret[k];
        o.position.x -= (rxx - rx);
        var rr = getObjModel(o);
        if (!Empty(rr.ftotal)) rr.ftotal.position.x -= (rxx - rx);
        if (!Empty(rr.flabel)) rr.flabel.position.x -= (rxx - rx);
      }
      idx = m_CurrentObj[zone].items.indexOf(lfield);
      if (idx >= 0) {
        rret.lfield = m_CurrentObj[zone].items[idx];
        m_CurrentObj[zone].items.splice(idx, 1);
      }
      if (!Empty(r.flabel)) {
        zone = getItemZone(r.flabel);
        idx = m_CurrentObj[zone].items.indexOf(r.flabel);
        if (idx >= 0) {
          rret.flabel = m_CurrentObj[zone].items[idx];
          m_CurrentObj[zone].items.splice(idx, 1);
        }
      }
      if (!Empty(r.ftotal)) {
        zone = getItemZone(r.ftotal);
        idx = m_CurrentObj[zone].items.indexOf(r.ftotal);
        if (idx >= 0) {
          rret.ftotal = m_CurrentObj[zone].items[idx];
          m_CurrentObj[zone].items.splice(idx, 1);
        }
      }
    }
    else {
      var rh = lfield.position.height;
      if (!Empty(r.flabel)) rh = Math.max(rh, r.flabel.position.height);
      ret = getZoneElementsAfterY(zone, lfield.position.y + rh);
      for (k = 0; k < ret.length; k++) {
        o = ret[k];
        o.position.y -= rh;
        o.position.yRelative -= rh;
      }
      m_CurrentObj[zone].height -= rh;
      idx = m_CurrentObj[zone].items.indexOf(lfield);
      if (idx >= 0) {
        rret.lfield = m_CurrentObj[zone].items[idx];
        m_CurrentObj[zone].items.splice(idx, 1);
      }
      if (!Empty(r.flabel)) {
        idx = m_CurrentObj[zone].items.indexOf(r.flabel);
        if (idx >= 0) {
          rret.flabel = m_CurrentObj[zone].items[idx];
          m_CurrentObj[zone].items.splice(idx, 1);
        }
      }
    }
  }
  return rret;
}

function addDocField(alias, zone, isLast) {
  var lfield = getLastZoneField(zone);
  var r = getObjModel(lfield);
  var rref = getModelFromZone(zone);
  var fldobj = getFieldInfo("itmFld_" + alias);
  if (rref.model == "table")
    addTableField(fldobj, zone, lfield, r.flabel, r.ftotal, rref);
  else
    addListField(fldobj, zone, lfield, r.flabel, rref);

  var idFld = "fld_" + alias;
  var realposdest = getRealPositionInZone(getPosInList(alias));
  var realposnow = getZoneElementsType(m_CurrentObj, zone, 'field').length - 1;
  if (isLast)
    realposdest = realposnow;
  moveFieldCurrentObj(idFld, realposdest, realposnow);
}

function addTableField(fldobj, zone, lfield, labfield, totfield, rref) {
  var x;
  if (Empty(lfield))
    x = getLastXPosition(m_CurrentObj.groupheader.items);
  else {
    x = lfield.position.x + lfield.position.width;
    if (!Empty(labfield)) x = Math.max(x, labfield.position.x + labfield.position.width);
    if (!Empty(totfield)) x = Math.max(x, totfield.position.x + totfield.position.width);
  }

  x += 5;  // offset cat
  var ho = addTableZoneField(fldobj, x, rref.flabel);
  var bo = addTableZoneField(fldobj, x, lfield);
  var fo = addTableZoneField(fldobj, x, rref.ftotal);
  if (!Empty(bo) && !Empty(ho)) bo.fieldLabel = ho.uid;
  if (!Empty(bo) && !Empty(fo)) bo.fieldTotal = fo.uid;
}

function addTableZoneField(fldobj, x, rfield) {
  var zone = "";
  if (Empty(rfield)) {
    return null;
  }
  else {
    zone = getItemZone(rfield);
    var y = rfield.position.y;
    var yRel = rfield.position.yRelative;
  }
  var itemobj = {};
  if (zone.indexOf("header") >= 0)
    itemobj = addLabel(zone, fldobj, x, y, yRel, calculateMaxWidth(fldobj));
  else
    itemobj = addField(zone, fldobj, x, y, yRel, zone.indexOf("footer") >= 0);
  if (!Empty(itemobj))
    m_CurrentObj[zone].items.push(itemobj);
  return itemobj;
}

function getItemZone(item) {
  var zone;
  for (var j = 0; j < reportZones.length; j++) {
    zone = Strtran(reportZones[j], "content", "");
    if (zone != "groupbreak" && m_CurrentObj[zone]) {
      if (m_CurrentObj[zone].items.indexOf(item) >= 0)
        return zone;
    }
  }
  return "";
}

function addListField(fldobj, zone, lfield, labfield) {
  addListZoneField(zone, fldobj, lfield, labfield);
}

function addListZoneField(zone, fldobj, lfield, labfield) {
  var defh = 22;
  var x = 0;
  var y = 0;
  var yRel = 3;
  var h = defh;
  var os = 0;
  var ret, k, o;
  if (Empty(lfield)) {
    lfield = getFirstZoneElement(zone);
    if (!Empty(lfield)) {
      x = lfield.position.x;
      y = lfield.position.y;
      yRel = lfield.position.yRelative;
      ret = getZoneElementsAfterY(zone, lfield.position.y - 1);
      for (k = 0; k < ret.length; k++) {
        o = ret[k];
        o.position.y += h;
        o.position.yRelative += h;
      }
    }
  }
  else {
    //in fondo
    x = lfield.position.x;
    y = lfield.position.y;
    yRel = lfield.position.yRelative;
    h = lfield.position.height;
    if (!Empty(labfield)) {
      x = Math.min(x, labfield.position.x);
      h = Math.max(h, labfield.position.height);
    }
    os = 5 + h;
    ret = getZoneElementsAfterY(zone, y);
    for (k = 0; k < ret.length; k++) {
      o = ret[k];
      o.position.y += os;
      o.position.yRelative += os;
    }
  }

  var ww = 174;
  var cat = 5;
  var itemobj = {};
  itemobj = addLabel(zone, fldobj, x, y, yRel + os, ww);
  if (!Empty(itemobj))
    m_CurrentObj[zone].items.push(itemobj);
  itemobj = addField(zone, fldobj, x + ww + cat, y, yRel + os, zone.indexOf("footer") >= 0);
  if (!Empty(itemobj))
    m_CurrentObj[zone].items.push(itemobj);

  var mh = getLastYPosition(m_CurrentObj[zone].items, true, false);
  if (mh > m_CurrentObj[zone].height) m_CurrentObj[zone].height += mh - m_CurrentObj[zone].height;
}

function addLabel(zone, fldobj, x, y, yRel, ww) {
  var h = 22;
  var tmpitem = {};
  tmpitem = {};
  tmpitem.uid = "lbl_" + zone + fldobj.alias;
  tmpitem.type = "label";
  tmpitem.typeView = "text";
  tmpitem.value = Empty(fldobj.desc) ? "" : fldobj.desc;
  tmpitem.alias = fldobj.alias;

  tmpitem.position = {};
  tmpitem.position.x = x;
  tmpitem.position.y = y;
  tmpitem.position.yRelative = yRel;
  tmpitem.position.width = ww;
  tmpitem.position.height = h;

  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.italic = true;
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "10pt";
  tmpitem.style.font.fontColor = "#000000";

  if (!Empty(fldobj.align)) {
    switch (fldobj.align) {
      case "right":
        tmpitem.style.font.right = true;
        break;
      case "center":
        tmpitem.style.font.center = true;
        break;
      default:
        tmpitem.style.font.left = true;
        break;
    }
  }

  return tmpitem;
}

function addField(zone, fldobj, x, y, yRel, isfooter, fromprint) {
  var h = 22;
  var tmpitem = {};
  maxwidthmap[fldobj.alias] = calculateMaxWidth(fldobj, fromprint);
  tmpitem = {};
  tmpitem.type = "field";

  switch (fldobj.type) {
    case "C":
    case "M":
      tmpitem.typeView = "text";
      break;
    case "N":
      tmpitem.typeView = "numeric";
      break;
    case "D":
      tmpitem.typeView = "date";
      break;
    case "T":
      tmpitem.typeView = "datetime";
      break;
    case "I":
    // tutela campi visualizzati come checkbox
    case "checkbox":
      tmpitem.typeView = "image";
      break;
    default:
      tmpitem.typeView = "text";
      break;
  }

  tmpitem.fieldDetail = {};
  tmpitem.fieldDetail.alias = fldobj.alias;
  tmpitem.fieldDetail.type = fldobj.type;
  tmpitem.fieldDetail.len = fldobj.len;
  if (fldobj.type == "N")
    tmpitem.fieldDetail.dec = fldobj.dec;
  tmpitem.fieldDetail.desc = fldobj.desc;

  tmpitem.uid = "fld_" + zone + tmpitem.fieldDetail.alias;
  tmpitem.fieldLabel = "lbl_" + zone + tmpitem.fieldDetail.alias;

  tmpitem.position = {};
  tmpitem.position.x = x;
  tmpitem.position.y = y;
  tmpitem.position.yRelative = yRel;
  tmpitem.position.width = maxwidthmap[fldobj.alias];
  tmpitem.position.height = h;

  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "10pt";
  tmpitem.style.font.fontColor = "#000000";

  if (isfooter && fldobj.type == "N") {
    tmpitem.style.font.right = true;
    tmpitem.style.font.bold = true;

    tmpitem.calculation = {};
    tmpitem.calculation.type = "sum";
    tmpitem.calculation.byGroup = true;
  }

  if (fldobj.generic) {
    tmpitem.isGeneric = true;
    tmpitem.fieldDetail.alias = "";
    if (fldobj.type == "I")
      tmpitem.style.imageSrc = fldobj.value;
  }

  var typevz = "";

  if (window.fviewType)
    typevz = window.fviewType[fldobj.alias];

  if (!Empty(fldobj.html) || (!Empty(typevz) && typevz == "html")) {
    tmpitem.typeView = "html";
    tmpitem.style.htmlSrc = fldobj.html;
  }

  if (fldobj.type == "checkbox" || (!Empty(typevz) && typevz == "checkbox")) {
    tmpitem.isGeneric = true;
    tmpitem.fieldDetail.type = "checkbox";
    tmpitem.typeView = "image";
  }

  if (!Empty(typevz) && typevz == "image") {
    tmpitem.fieldDetail.type = "I";
    tmpitem.typeView = "image";
  }

  return tmpitem;
}

function addTotalField(zone, alias, x, y, yRel, value, isLabel) {
  var h = 22,
    tmpitem = {};
  if (isLabel) {
    tmpitem.uid = "lbl_" + zone + alias;
    tmpitem.type = "label";
    tmpitem.typeView = "text";
  }
  else {
    tmpitem.uid = "tot_" + zone + alias;
    tmpitem.type = "field";
    tmpitem.fieldLabel = "lbl_" + zone + alias;
    tmpitem.typeView = "numeric";
    tmpitem.fieldDetail = { alias: alias }
  }
  tmpitem.value = (Empty(value) && value != 0) ? "" : value;

  tmpitem.position = {};
  tmpitem.position.x = x;
  tmpitem.position.y = y;
  tmpitem.position.yRelative = yRel;
  tmpitem.position.width = maxwidthmap[alias];
  tmpitem.position.height = h;

  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "7pt";
  tmpitem.style.font.fontColor = "#000000";
  //tmpitem.style.font.right = true;
  tmpitem.style.font.bold = true;

  return tmpitem;
}

function getLastXPosition(items) {
  var xprogr = 0;
  for (var i = 0; i < items.length; i++) {
    if (items[i].type != "line")
      xprogr = Math.max((items[i].position.x + items[i].position.width), xprogr);
  }
  return xprogr;
}

function getMinXPosition(items) {
  var xprogr = Ctrl("backcanvas").offsetWidth;
  for (var i = 0; i < items.length; i++) {
    //if(items[i].type!="line")
    xprogr = Math.min(items[i].position.x, xprogr);
  }
  return xprogr;
}

function getMinYPosition(items) {
  var xprogr = Ctrl("backcanvas").offsetHeight;
  for (var i = 0; i < items.length; i++) {
    if (items[i].type != "line")
      xprogr = Math.min(items[i].position.y, xprogr);
  }
  return xprogr;
}

function getLastYPosition(items, isrel, noheight) {
  var yprogr = 0;
  var prop = (isrel) ? "yRelative" : "y"
  for (var i = 0; i < items.length; i++) {
    if (noheight)
      yprogr = Math.max(items[i].position[prop], yprogr);
    else
      yprogr = Math.max((items[i].position[prop] + items[i].position.height), yprogr);
  }
  return yprogr;
}

function resetMenuToolbar() {
  $("menumob_cont").addClass("disabledpic");
  //Ctrl("menumob_label").textContent = "";
}

function setMenuToolbar(/*gzone*/) {
  if (!Ctrl("menumob_cont"))
    return;
  $("menumob_cont").removeClass("disabledpic");
}

function editItem(e) {
  e = (e) ? e : window.event;
  var ctrl = GetEventSrcElement(e);
  if (!$(ctrl.id).hasClass("btncontainer"))
    ctrl = ctrl.parentNode;

  if ($(ctrl.id).hasClass("disabledpic"))
    return;
  if (Empty(container_selection.e) && (ctrl.id.indexOf("edit") >= 0 || ctrl.id.indexOf("font") >= 0))
    return;
  if (ctrl.id.indexOf("menumob") >= 0 && Empty(Ctrl("menumob_label").textContent))
    return;
  if (ctrl.id.indexOf("pages") >= 0 && (viewMode == designView))
    return;

  $("shadowmenu").addClass("hiddenAdd");

  var cl = Strtran(ctrl.id, "_cont", "_prop");
  if ($("shadowmenu").hasClass(cl)) {
    $("shadowmenu").removeClass(cl);
    resetMenuItems();
    return;
  }

  resetMenuItems();
  drawShadowMenu();
  $("shadowmenu").addClass(cl);
  $(ctrl.id).addClass("menuopen");

  var msg;
  if (ctrl.id.indexOf("rulergrid") >= 0)
    drawRulerSettings(formProp, formProp.objClass.newProperties.rulersGrid)
  else if (ctrl.id.indexOf("details") >= 0)
    drawMenuProperties(formProp, formProp.objClass.newProperties.leftToolbar_1, ctrl);
  else if (ctrl.id.indexOf("sect") >= 0)
    drawReportSectionMenu(formProp, formProp.objClass.newProperties.designToolbar);
  else if (ctrl.id.indexOf("page") >= 0)
    drawPageSettingsMenu(formProp, formProp.objClass.newProperties.print);
  else if (ctrl.id.indexOf("edit") >= 0)
    drawEditItemContent(e, ctrl, itemsHTML[container_selection.e[0]].uid);
  else if (ctrl.id.indexOf("font") >= 0)
    drawItemStyle(ctrl, itemsHTML[container_selection.e[0]]);
  else if (ctrl.id.indexOf("del") >= 0) {
    resetMenuItems();
    if (itemsHTML[container_selection.e[0]].isMissing) {
      var itm = itemsHTML[container_selection.e[0]];
      var model = getModelFromZone(Strtran(itm.zone, "content", "")).model;
      msg = getTranslated("SMR_CONFIRMREMWHOLE", "Do you want to remove whole")
      msg += " ";
      if (model == "table")
        msg += getTranslated("SMR_CONFIRMCOLUMN", "column");
      else
        msg += getTranslated("SMR_CONFIRMROW", "row");
      msg += "?";
      showMessageConfirm(msg, "deletemissing", { alias: itm.fieldDet.alias, zone: Strtran(itm.zone, "content", "") });
    }
    else {
      msg = getTranslated("SMR_CONFIRMDELETE", 'Are you sure to remove elements? Only selected elements (not others related) will be removed!');
      showMessageConfirm(msg, "delete");
    }
  }
  else  //list field
    drawMenuFields();

  Ctrl("shadowmenu").style.left = ctrl.offsetLeft + "px";
  if (Ctrl("shadowmenu").offsetLeft <= 0)
    Ctrl("shadowmenu").style.left = 2 + "px";
  Ctrl("shadowmenu").style.top = (ctrl.offsetTop + ctrl.offsetHeight) + "px";
  Ctrl("canvas").onmousedown = beginDragSelection;
}

function drawShadowMenu() {
  var pID = "shadowmenu";
  $(pID).removeClass("hiddenAdd");
  $(pID).removeClass("docview_prop");
  $(pID).removeClass("docsect_prop");

  $(pID).removeClass("shadowWidth");
  $(pID).removeClass("titleContainer");
  $(pID).removeClass("buttonContainer");
  $(pID).removeClass("buttonfontContainer");
  $(pID).removeClass("gridContainer");
  $(pID).removeClass("pageContainer");

  pID = "boxcontainer";
  $(pID).removeClass("verticalOverflow");
  $(pID).removeClass("shadowHeight");
  Ctrl(pID).innerHTML = "";
}

function drawItemStyle(ctrl, item, contID) {
  switch (item.typeView) {
    case "text":
    case "date":
    case "datetime":
    case "pagenum":
    case "numeric":
      drawFontDetail(item, item.objClass.newProperties.font, contID);
      break;
  }
}

function getFieldsOrderByZoneList(zoneitems) {
  var mycopy = fieldHTML.slice();
  var mymap = {};
  var i;
  var temp;
  for (i in fieldHTMLMap)
    mymap[i] = fieldHTMLMap[i];
  for (i = 0; i < zoneitems.length; i++) {
    var p = zoneitems[i];
    if (getFieldHTMLIndex("itmFld_" + p.fieldDetail.alias) < 0)
      continue;
    var pi = mymap[p.fieldDetail.alias];
    mycopy[pi].mpos = i;
  }
  for (i = 0; i < mycopy.length; i++)
    if (mycopy[i].mpos == undefined) mycopy[i].mpos = i;

  // replica dell'algoritmo bubble sort in linguaggio C
  for (i = 0; i < mycopy.length - 1; i++) {
    for (var j = 0; j < mycopy.length - 1 - i; j++) {
      if (mycopy[j + 1].mpos < mycopy[j].mpos) {
        temp = mycopy[j + 1];
        mycopy[j + 1] = mycopy[j];
        mycopy[j] = temp;
      }
    }
  }
  return mycopy;
}

function drawMenuFields() {
  orderMCurrentItemsByZone();
  $("shadowmenu").addClass("buttonContainer");
  var pID = "boxcontainer";
  $(pID).addClass("shadowHeight");
  //var ctrl = Ctrl("menumob_label");
  var zone = Strtran(gselectzone.replace(/[0-9]/g, ""), "zpagem", "");
  if (!zone || Empty(zone) || !m_CurrentObj[zone])
    return;
  var items = m_CurrentObj[zone].items;
  var div, div2, elem, elem2;
  div = document.createElement("span");
  div.className = "shadowtitlediv shadowtitledivnone";
  div.textContent = " ";
  Ctrl(pID).appendChild(div);
  div = document.createElement("div");
  div.id = "fLegend";
  Ctrl(pID).appendChild(div);
  drawFieldLegend("fLegend");
  div2 = document.createElement("div");
  div2.id = "fldlistcont";
  div = document.createElement("ul");
  div.className = "fld_ul";
  div.style.cssFloat = "left";
  div.style.width = "100%";
  div2.appendChild(div);
  Ctrl(pID).appendChild(div2);
  var found = false;
  var mycopy = getFieldsOrderByZoneList(getZoneElementsType(m_CurrentObj, zone, 'field'));
  for (var j = 0; j < mycopy.length; j++) {
    elem = document.createElement("li");
    elem.id = j + "_" + mycopy[j].alias + "_space";
    elem2 = document.createElement("div");
    elem2.id = "fld_" + mycopy[j].alias + "_space";
    elem2.className = "unselectable fieldspace";
    elem.appendChild(elem2);
    div.appendChild(elem);
    elem = document.createElement("li");
    elem.id = "fld_" + mycopy[j].alias;
    elem.className = "divFieldList";
    div.appendChild(elem);

    var switchObj = {
      name: "i",
      propID: mycopy[j].alias,
      tooltip: "",
      actions: "actionOnField"
    };
    found = false;
    for (var i = 0; i < items.length && !found; i++) {
      if (items[i].type == "field" && items[i].fieldDetail.alias == mycopy[j].alias)
        found = true;
    }
    drawSwitch(switchObj, "fld_" + mycopy[j].alias, found, true, true);
    Ctrl("switch_" + mycopy[j].alias).style.cssFloat = "right";

    elem2 = document.createElement("span");
    elem2.id = j + "_" + mycopy[j].alias + "_drag";
    elem2.className = "unselectable dragSpan usedField";
    elem.appendChild(elem2);
    addFieldInList(j, mycopy[j], elem);

    if (found)
      addFieldUsedClass(j + "_" + mycopy[j].alias + "_fld");
    else {
      removeFieldUsedClass(j + "_" + mycopy[j].alias + "_fld");
      $(j + "_" + mycopy[j].alias + "_drag").addClass("hiddenAdd");
    }
    Ctrl(j + "_" + mycopy[j].alias + "_fld").style.marginLeft = "20px";
    Ctrl(j + "_" + mycopy[j].alias + "_fldlen").style.marginLeft = "20px";
    Ctrl(j + "_" + mycopy[j].alias + "_drag").onmouseenter = drawShadowField;
    Ctrl(j + "_" + mycopy[j].alias + "_drag").onmousedown = dragShadowField;
    Ctrl("fld_" + mycopy[j].alias + "_space").setAttribute("data-attr", j);

    Ctrl("fld_" + mycopy[j].alias).setAttribute("data-attr", mycopy[j].alias);
    Ctrl("fld_" + mycopy[j].alias).onclick = highlightFields;
  }
  elem = document.createElement("li");
  elem.id = mycopy.length + "_last_space";
  elem2 = document.createElement("div");
  elem2.id = "fld_last_space";
  elem2.className = "unselectable fieldspace";
  elem.appendChild(elem2);
  div.appendChild(elem);
  Ctrl("fld_last_space").setAttribute("data-attr", mycopy.length);

  if (Ctrl("fldlistcont").firstChild.children.length > 7) {
    $("shadowmenu").addClass("shadowWidth");
    $("fldlistcont").addClass("verticalOverflow");
  }

  //Ctrl("notused").click();
  if (Ctrl("notused"))
    manageOnOff(null, Ctrl("notused"));
}

function orderMCurrentItemsByZone() {
  if (m_CurrentObj == null)
    return;
  var zone = "";
  for (var i = 0; i < modifiedZone.length; i++) {
    zone = Strtran(modifiedZone[i], "content", "");
    if (zone != "groupbreak" && m_CurrentObj[zone])
      orderItemsZone(zone);
  }
  modifiedZone = [];
}

function orderItemsZone(zone) {
  var cont = m_CurrentObj[zone];
  var temp;
  for (var i = 0; i < cont.items.length - 1; i++) {
    for (var j = 0; j < cont.items.length - 1 - i; j++) {
      if ((cont.items[j].position.yRelative > cont.items[j + 1].position.yRelative)) {
        temp = cont.items[j + 1];
        cont.items[j + 1] = cont.items[j];
        cont.items[j] = temp;
      }
      else if ((cont.items[j].position.yRelative == cont.items[j + 1].position.yRelative)) {
        if (cont.items[j].position.x >= cont.items[j + 1].position.x) {
          temp = cont.items[j + 1];
          cont.items[j + 1] = cont.items[j];
          cont.items[j] = temp;
        }
      }
    }
  }
}

function enableItemButtons(id) {
  var item = itemsHTML[getItemsHTMLIndex(id)];
  if (!item) {
    return;
  }
  var i,
    disable_edit = (item.typeView == "numeric" && item.zone.indexOf("footer") < 0 && !item.isMissing && !item.isAllFields) ||
      (item.type == "field" && item.fieldDet.type == "L" && !item.isMissing) ||
      (item.type == "label" && item.isContinue && !item.isAllFields)/* ||
                 (item.type == "label" && item.isAllFields);*/;
  var btns = formProp.objClass.newProperties.rightToolbar_2;
  for (i = 0; i < btns.length; i++) {
    if (!$(btns[i].propID + "_cont").hasClass("hiddenAdd")) {
      if (btns[i].propID == "editc") {
        if (!disable_edit)
          $(btns[i].propID + "_cont").removeClass("disabledpic");
      }
      else if (btns[i].propID == "fonts") {
        if (!item.isAllFields &&
          (item.typeView != "image" && item.type != "line" && !item.isMissing && item.typeView != "signmup" && item.typeView != "barcode")
        )
          $(btns[i].propID + "_cont").removeClass("disabledpic");
      }
      if (btns[i].propID == "delitem")
        $(btns[i].propID + "_cont").removeClass("disabledpic");
    }
  }
  btns = formProp.objClass.newProperties.rightToolbar_3;
  for (i = 0; i < btns.length; i++) {
    if (!$(btns[i].propID + "_cont").hasClass("hiddenAdd")) {
      if (btns[i].propID == "editc") {
        if (!disable_edit)
          $(btns[i].propID + "_cont").removeClass("disabledpic");
      }
      else if (btns[i].propID == "fonts") {
        if (!item.isAllFields &&
          (item.typeView != "image" && item.type != "line" && !item.isMissing && item.typeView != "signmup" && item.typeView != "barcode")
        )
          $(btns[i].propID + "_cont").removeClass("disabledpic");
      }
      if (btns[i].propID == "delitem")
        $(btns[i].propID + "_cont").removeClass("disabledpic");
    }
  }
  viewElementAPI(true, item);
}

function resetMenuItems() {
  Ctrl("shadowmenu").className = "";
  $("shadowmenu").addClass("hiddenAdd");
  Ctrl("boxcontainer").innerHTML = "";
  Ctrl("rulergridopt").removeClass("menuopen");
  removeMenuOpenCss();
}

function viewElementAPI(view, item) {
  if (view) {
    if (Ctrl("label_cApi")) {
      Ctrl("label_cApi").textContent = item.type.charAt(0).toUpperCase() + item.type.slice(1);
      if (item.type.toLowerCase() == "field" /*&& item.typeView.toLowerCase() == "allfields"*/)
        Ctrl("label_cApi").textContent += " (" + item.typeView + ")";
    }
    if (Ctrl("lcApi_container")) {
      Ctrl("lcApi_container").removeClass("unselectable");
      Ctrl("lcApi_container").removeClass("disabledpic");
    }
  }
  else {
    if (Ctrl("label_cApi"))
      Ctrl("label_cApi").textContent = "Element API";
    if (Ctrl("lcApi_container")) {
      Ctrl("lcApi_container").addClass("unselectable");
      Ctrl("lcApi_container").addClass("disabledpic");
    }
  }
}

function removeMenuOpenCss() {
  if (Ctrl("details_cont")) Ctrl("details_cont").removeClass("menuopen");
  var i;
  var btns = formProp.objClass.newProperties.rightToolbar_2;
  for (i = 0; i < btns.length; i++) {
    if (Ctrl(btns[i].propID + "_cont")) Ctrl(btns[i].propID + "_cont").removeClass("menuopen");
  }
  btns = formProp.objClass.newProperties.rightToolbar_3;
  for (i = 0; i < btns.length; i++) {
    if (Ctrl(btns[i].propID + "_cont")) Ctrl(btns[i].propID + "_cont").removeClass("menuopen");
  }
  btns = formProp.objClass.newProperties.leftToolbar_1;
  for (i = 0; i < btns.length; i++) {
    if (Ctrl(btns[i].propID + "_cont")) Ctrl(btns[i].propID + "_cont").removeClass("menuopen");
  }
  btns = formProp.objClass.newProperties.leftToolbar_2;
  for (i = 0; i < btns.length; i++) {
    if (Ctrl(btns[i].propID + "_cont")) Ctrl(btns[i].propID + "_cont").removeClass("menuopen");
  }
}

function disableItemButtons() {
  resetMenuItems();
  var i;
  var btns = formProp.objClass.newProperties.rightToolbar_2;
  for (i = 0; i < btns.length; i++) {
    Ctrl(btns[i].propID + "_cont").removeClass("menuopen");
    if (!$(btns[i].propID + "_cont").hasClass("hiddenAdd")) {
      if (btns[i].propID == "editc" || btns[i].propID == "fonts" || btns[i].propID == "delitem" /*|| btns[i].propID == "pages" || btns[i].propID == "menumob"*/)
        $(btns[i].propID + "_cont").addClass("disabledpic");
    }
  }
  btns = formProp.objClass.newProperties.rightToolbar_3;
  for (i = 0; i < btns.length; i++) {
    Ctrl(btns[i].propID + "_cont").removeClass("menuopen");
    if (!$(btns[i].propID + "_cont").hasClass("hiddenAdd")) {
      if (btns[i].propID == "editc" || btns[i].propID == "fonts" || btns[i].propID == "delitem" /*|| btns[i].propID == "pages"*/ || btns[i].propID == "menumob")
        $(btns[i].propID + "_cont").addClass("disabledpic");
    }
  }
  Ctrl("details_cont").removeClass("menuopen");
  viewElementAPI();
}

function addFieldInList(idx, fld, div) {
  var elem, elem2;
  elem = document.createElement("div");
  elem.id = idx + "_" + fld.alias + "_fld";
  elem.className = "unselectable fieldObject fieldObjectList";
  elem.style.cursor = "default";
  elem2 = document.createElement("div");
  elem2.className = "unselectable fieldObjectInside fieldObjectInsideList";
  elem2.innerHTML = ToStringHTML(fld.desc);
  elem2.style.cursor = "pointer";
  elem.appendChild(elem2);
  elem2 = document.createElement("span");
  elem2.className = "unselectable iconFieldType ";
  switch (fld.type) {
    case "C":
      elem2.className += "smartreport-icon-char";
      break;
    case "M":
      elem2.className += "smartreport-icon-memo";
      break;
    case "N":
      elem2.className += "smartreport-icon-num";
      break;
    case "D":
      elem2.className += "smartreport-icon-date";
      break;
    case "T":
      elem2.className += "smartreport-icon-time";
      break;
    case "L":
      elem2.className += "smartreport-icon-logic";
      break;
  }
  elem2.style.cursor = "default";
  elem.appendChild(elem2);
  div.appendChild(elem);
  elem = document.createElement("div");
  elem.id = idx + "_" + fld.alias + "_fldlen";
  elem.className = "unselectable fieldObjectLen fieldObjectLenList";
  elem2 = document.createElement("div");
  elem2.id = idx + "_" + fld.alias + "_fldlenColor";
  elem2.className = "unselectable fieldObjectLenC";
  elem2.style.width = Math.min(divLen, (lenFactor * fld.len)) + "px";
  elem.appendChild(elem2);
  div.appendChild(elem);
}

function drawEditItemContent(e, ctrl, itemObj) {
  //itemObj as uid
  if (!ctrl)
    ctrl = GetEventSrcElement(e);
  if (!itemObj)
    itemObj = itemsHTML[uidItemsHTML.indexOf(ctrl.getAttribute("data-item"))];
  else
    itemObj = itemsHTML[getUidItemsHTMLIndex(itemObj)];

  $("shadowmenu").addClass("hiddenAdd");
  if (itemObj.typeView == "numeric" && itemObj.zone.indexOf("footer") < 0 && !itemObj.isMissing && !itemObj.isAllFields)
    return;
  // PER ORA NON GESTITO IL DBL CLICK SU TIPOLOGIA LOGIC, PERCHE' POTREBBE ESSERE UNA TYPEVIEW CHECKBOX - VALUTARE SE SUPPORTATA
  if (itemObj.type == "field" && itemObj.fieldDet.type == "L" && !itemObj.isMissing)
    return;

  $("shadowmenu").removeClass("hiddenAdd");

  var title = "";
  if (itemObj.isMissing && itemObj.type == "field")
    title = "New data field";
  else if (itemObj.typeView == "pagenum")
    title = "Page numeration type";
  else if (itemObj.typeView.indexOf("date") >= 0)
    title = "Date time format";
  else if (itemObj.typeView == "numeric")
    title = "Calculation";
  else if (itemObj.type != "label")  // field to image
    title = "Field view type";

  title = getTranslated("SMR_" + title, title);
  //SMR_NEWDATAFIELD //SMR_PAGENUMERATIONTYPE //SMR_DATETIMEFORMAT //SMR_CALCULATION //SMR_FIELDVIEWTYPE

  if (itemObj.isAllFields) {
    $("shadowmenu").addClass("editc_allfields");
    drawAllFieldsDetail(itemObj);
  }
  else if (itemObj.typeView == "text" && itemObj.type != "field") {
    drawItemContent(itemObj);
  }
  else if (itemObj.type == "line") {
    $("shadowmenu").addClass("editc_line");
    drawLineStyleDetail(itemObj, itemObj.objClass.newProperties.line);
  }
  else if (itemObj.typeView == "image" && itemObj.isGeneric) {
    $("shadowmenu").addClass("editc_image");
    drawImageDetail(itemObj, itemObj.objClass.newProperties.image);
  }
  else if (itemObj.typeView == "signmup") {
    $("shadowmenu").addClass("editc_signmup");
    drawSignatureMarkupDetail(itemObj, itemObj.objClass.newProperties.signmup);
  }
  else {
    addShadowTitle(title);
    if (itemObj.isMissing && itemObj.type == "field")
      drawFieldList(itemObj);
    else if (itemObj.typeView == "pagenum") {
      $("shadowmenu").addClass("editc_propsmall");
      drawPageNumDetail(itemObj, itemObj.objClass.newProperties["pagenum"]);
    }
    else if (itemObj.typeView.indexOf("date") >= 0)
      drawDateDetail(itemObj, itemObj.objClass.newProperties["date"]);
    else if (itemObj.typeView == "numeric") {
      $("shadowmenu").addClass("editc_propsmall");
      drawNumericDetail(itemObj, itemObj.objClass.newProperties["num"]);
    }
    else { // field to image
      $("shadowmenu").addClass("editc_barcode");
      drawFieldChange(itemObj, itemObj.objClass.newProperties["fConv"]);
    }
  }
}

function addShadowTitle(title) {
  var text = document.createElement("span");
  text.id = "eititle";
  text.className = "shadowtitlediv";
  text.textContent = title;
  Ctrl("boxcontainer").appendChild(text);
}

function saveEditInput() {
  var itm = null;
  for (var i = 0; i < container_selection.e.length; i++) {
    itm = itemsHTML[container_selection.e[i]];
    if (itm.isAllFields) {
      if (container_selection.e.length > 1)
        continue;
      else
        return;
    }
    if (itm.isMissing && itm.type == "field") {
      var field = document.getElementsByClassName("flistchecked")[0];
      if (field)
        replaceMissingField(itm, field);
    }
    else if (itm.typeView == "pagenum") {
      itm.pageN = Ctrl("pageN").value;
      itm.fieldDet.desc = Ctrl("pageN").value;
      var translated = getTranslated("SMR_" + itm.fieldDet.desc, itm.fieldDet.desc);
      Ctrl(itm.id + "_int").innerHTML = "[" + ToStringHTML(translated) + "]";
      UpdateDesignObj(itm, "pagenum");
    }
    else if (itm.typeView == "numeric") {
      itm.calculate = Ctrl("calculate").value;
      itm.calcbygrp = Ctrl("calcbygrp").checked;
      setCalculation(itm);
      UpdateDesignObj(itm, "calc");
    }
    else if (itm.typeView.indexOf("date") >= 0)  //date - datetime
      checkDate();
    else if (itm.typeView == "signmup")
      setMarkUp();
    else if (itm.typeView == "barcode") {
      setBarcode();
    }
    else  // text to image
      fieldTextToImage();
  }
  /*disableItemButtons();
  removeAllHandlers();*/
  pushToHistory();
  Ctrl("canvas").onmousedown = beginDragSelection;
}

function exitEditInput() {
  resetMenuItems();
  disableItemButtons();
  removeAllHandlers();
  Ctrl("canvas").onmousedown = beginDragSelection;
}

function drawItemContent(itemObj, pID, value, notitle) {
  pID = Empty(pID) ? "boxcontainer" : pID;
  if (Empty(itemObj.value) && Empty(value))
    value = "";
  else if (!Empty(itemObj.value))
    value = itemObj.value;
  drawEditContentArea(Ctrl(pID), itemObj.uid, "", "Edit text content", notitle);
  Ctrl(itemObj.uid).innerHTML = value;
}

function highlightFields(e) {
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  if (ctrl.className.indexOf("onoffprop") >= 0)
    return;

  var alias = getDataAttr(ctrl);
  var items = getUidItemsFromAlias(alias);
  var labeluid = "";
  for (var i = 0; i < items.length; i++) {
    UpdateDesignObj(items[i], "highlightField");
    labeluid = getItemFieldUid(items[i], null, m_CurrentObj);
    if (!Empty(labeluid) && !Empty(labeluid.fieldLabel))
      UpdateDesignObj(labeluid.fieldLabel, "highlightLabel");
    if (!Empty(labeluid) && !Empty(labeluid.fieldTotal))
      UpdateDesignObj(labeluid.fieldTotal, "highlightLabel");
  }
}

function getDataAttr(ctrl) {
  var parent = ctrl;
  while (Empty(parent.getAttribute("data-attr"))) {
    parent = parent.parentNode;
  }

  return parent.getAttribute("data-attr");
}

function getUidItemsFromAlias(alias) {
  var itemsuid = [];
  var zone = Strtran(gselectzone.replace(/[0-9]/g, ""), "zpagem", "");
  if (zone != "groupbreak" && m_CurrentObj[zone]) {
    for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
      if (m_CurrentObj[zone].items[i].type == "field" && m_CurrentObj[zone].items[i].fieldDetail.alias == alias) {
        itemsuid.push(m_CurrentObj[zone].items[i].uid);
      }
    }
  }
  return itemsuid;
}

function getItemFieldUid(itemuid, type, obj) {
  if (obj == null)
    return;
  var zone = "";
  if (Empty(type)) type = 'field';
  for (var j = 0; j < reportZones.length; j++) {
    zone = Strtran(reportZones[j], "content", "");
    if (zone != "groupbreak" && obj[zone]) {
      for (var i = 0; i < obj[zone].items.length; i++) {
        if (obj[zone].items[i].type == type && obj[zone].items[i].uid == itemuid) {
          return obj[zone].items[i];
        }
      }
    }
  }
  return null;
}

function removeClassFromItems(cname) {
  var items = document.getElementsByClassName(cname);
  var l = items.length;
  for (var i = l - 1; i >= 0; i--)
    $(items[i].id).removeClass(cname);
}

function drawPageSettingsMenu(itemObj, props) {
  var pID = "boxcontainer";
  currentItem = itemObj;
  var elem, div, create = true;
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
      div.className = "pformatContainer";
      Ctrl(pID).appendChild(div);
    }
    var e, t, j, sp;
    switch (props[i].propID) {
      case "pformat":
        div.id = props[i].propID + "_divc";
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_FORMAT", "Format");
        div.appendChild(elem);
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "unselectable comboFontName";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        elem.onchange = window[props[i].actions];
        sp = ZTObjects.format_select.split(",");
        for (j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.value = sp[j];
          elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //sp[j]; //SMR_CUSTOM
          Ctrl(props[i].propID).appendChild(elem);
        }
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = false;
        break;
      case "pheight":
        e = document.createElement("div");
        e.id = props[i].propID + "_pcustom";
        e.className = "pcustom";
        div.appendChild(e);
        elem = document.createElement("span");
        elem.className = "iconDescLabel";
        elem.textContent = getTranslated("SMR_HEIGHTMM", "Height (mm)");
        e.appendChild(elem);
        elem = document.createElement("input");
        elem.id = props[i].propID;
        elem.name = props[i].propID;
        elem.className = "inputFontSize";
        elem.type = "number";
        elem.min = 100;
        t = getTranslated(props[i].tooltip_code, props[i].tooltip);
        elem.title = t.split(";")[0];
        e.appendChild(elem);
        elem.onchange = window[props[i].actions.split(",")[0]];
        elem.onfocus = function () { SetOnEditProp(true); };
        elem.onblur = function () { SetOnEditProp(false); };
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        break;
      case "pwidth":
        e = document.createElement("div");
        e.id = props[i].propID + "_pcustom";
        e.className = "pcustom";
        div.appendChild(e);
        elem = document.createElement("span");
        elem.className = "iconDescLabel";
        elem.textContent = getTranslated("SMR_WIDTHMM", "Width (mm)");
        e.appendChild(elem);
        elem = document.createElement("input");
        elem.id = props[i].propID;
        elem.name = props[i].propID;
        elem.className = "inputFontSize";
        elem.type = "number";
        elem.min = 100;
        t = getTranslated(props[i].tooltip_code, props[i].tooltip);
        elem.title = t.split(";")[0];
        e.appendChild(elem);
        elem.onchange = window[props[i].actions.split(",")[0]];
        elem.onfocus = function () { SetOnEditProp(true); };
        elem.onblur = function () { SetOnEditProp(false); };
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = true;
        break;
      case "porientation":
        elem = document.createElement("span");
        elem.className = "shadowtitlediv";
        elem.textContent = getTranslated("SMR_ORIENTATION", "Orientation");
        div.appendChild(elem);
        elem = document.createElement("select");
        elem.id = props[i].propID;
        elem.className = "unselectable comboFontName";
        elem.title = getTranslated(props[i].tooltip_code, props[i].tooltip);
        div.appendChild(elem);
        elem.onchange = window[props[i].actions];
        sp = ZTObjects.orientation_select.split(",");
        for (j = 0; j < sp.length; j++) {
          elem = document.createElement("option");
          elem.value = sp[j];
          elem.textContent = getTranslated("SMR_" + sp[j], sp[j]); //sp[j]; //SMR_PORTRAIT //SMR_LANDSCAPE
          Ctrl(props[i].propID).appendChild(elem);
        }
        Ctrl(props[i].propID).value = itemObj[props[i].propID];
        create = true;
        break;
    }
  }
  // messo x tutela nascosti-visibili elementi pwidth e pheight
  SetPrintProp(itemObj.pformat, 'pformat', true);
}

function drawReportSectionMenu(itemObj, props) {
  var pID = "boxcontainer";
  currentItem = itemObj;
  var elem;
  var div = null, create = true;

  elem = document.createElement("span");
  elem.className = "shadowtitlediv shadowtitledivnone";
  elem.textContent = "   ";
  Ctrl(pID).appendChild(elem);
  for (var i = 0; i < props.length; i++) {
    if (create) {
      div = document.createElement("div");
      div.id = "sectiondivcont_" + i;
      div.className = "repsections";
      Ctrl(pID).appendChild(div);
    }
    switch (props[i].propID) {
      case "showreportzone":
      case "showpagezone":
      case "showgroupzone":
        elem = document.createElement("span");
        elem.id = props[i].propID + "_desc";
        elem.className = "unselectable desctext " + Strtran(props[i].propID, "show", "");
        elem.textContent = getTranslated("SMR_" + props[i].name, props[i].name);//props[i].name;
        //SMR_REPORTSECTIONS //SMR_PAGESECTIONS //SMR_GROUPSECTIONS
        div.appendChild(elem);
        create = true;
        break;
    }
    var switchObj = {
      name: "S",
      propID: props[i].propID,
      tooltip: props[i].tooltip,
      actions: props[i].actions
    };
    drawSwitch(switchObj, "sectiondivcont_" + i, formProp[props[i].propID], true, true);
  }
}

function setPageSettings(e) {
  var ctrl = GetEventSrcElement(e || window.event);
  SetPrintProp(ctrl.value, ctrl.id, true);
}

var idFld = "";
var posinlist = -1;
var dx, dy, xpos, ypos;
function drawShadowField(e) {
  e = !e ? window.event : e;
  var ctrl = GetEventSrcElement(e);
  if (!ctrl)
    return;
  idFld = "fld_" + getDataAttr(ctrl);
  ctrl = document.getElementById(idFld);
  posinlist = parseInt(getDataAttr(Ctrl(idFld + "_space")));

  if (idFld.indexOf("_shadow") >= 0) {
    ctrl.onmousedown = null;
    document.body.style.cursor = "auto";
    document.body.onmousemove = null;
    document.body.onmouseup = null;
    document.body.removeChild(ctrl);
    return;
  }

  if (document.getElementsByClassName("dragdropshadow").length > 0) {
    for (var i = 0; i < document.getElementsByClassName("dragdropshadow").length; i++)
      document.body.removeChild(document.getElementsByClassName("dragdropshadow")[i]);
  }

  var shadowDD = document.createElement("div");
  shadowDD.id = idFld + "_shadow";
  shadowDD.className = "unselectable dragdropshadow";

  var abpos = (getAbsolutePos(ctrl));
  shadowDD.style.left = abpos.x + "px";
  shadowDD.style.top = (abpos.y - Ctrl("backcanvas").scrollTop - Ctrl("fldlistcont").scrollTop) + "px";
  shadowDD.style.marginTop = "";
  shadowDD.style.marginLeft = "";
  shadowDD.style.width = (ctrl.offsetWidth - Ctrl("switch_" + getDataAttr(ctrl)).offsetWidth - 5) + "px";
  shadowDD.style.height = ctrl.offsetHeight + "px";
  shadowDD.style.fontSize = "12px";
  document.body.appendChild(shadowDD);
  var elem = document.createElement("div");
  elem.id = idFld + "_shadow_first";
  elem.style.cssFloat = "left";
  elem.style.height = "50%";
  elem.style.width = "97%";
  elem.style.overflow = "hidden";
  elem.style.textOverflow = "ellipsis";
  elem.style.textAlign = "center";
  shadowDD.appendChild(elem);
  elem = document.createElement("div");
  elem.id = idFld + "_shadow_second";
  elem.style.cssFloat = "left";
  elem.style.height = "49%";
  elem.style.width = "100%";
  elem.style.textAlign = "center";
  shadowDD.appendChild(elem);

  shadowDD.onmousedown = dragShadowField;
  shadowDD.onmouseup = putShadowField;
}

function dragShadowField(e) {
  e = (e) ? e : window.event;
  addClassToItems("fieldspace", "fieldspacehigh");
  $(idFld + "_shadow").addClass("dragdropshadowmovefield");
  var fielddesc = "";
  if (Empty(Ctrl(idFld + "_shadow_first").textContent)) {
    fielddesc = getFieldInfo("itmFld_" + Strtran(idFld, "fld_", "")).desc;
    if (fielddesc.length > 6)
      fielddesc = fielddesc.substring(0, 7) + "...";
    Ctrl(idFld + "_shadow_first").textContent = "Dragging [" + fielddesc + "]";
  }

  xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;

  dx = Ctrl(idFld + "_shadow").offsetLeft - xpos;
  dy = Ctrl(idFld + "_shadow").offsetTop - ypos;

  document.body.style.cursor = "move";
  document.body.onmousemove = moveShadowField;
}

var oldmid = -1;
function moveShadowField(e) {
  e = (e) ? e : window.event;
  xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;

  var mx = xpos - (Ctrl("shadowmenu").offsetLeft + Ctrl("boxcontainer").offsetLeft + Ctrl("fldlistcont").offsetLeft);
  var my = ypos - (Ctrl("shadowmenu").offsetTop + Ctrl("boxcontainer").offsetTop) + Ctrl("fldlistcont").scrollTop;

  var mid = highlightFieldSpace(mx, my);
  var zid = -1;
  if (mid >= 0 && mid != posinlist && mid != (posinlist + 1) && mid != oldmid) {
    oldmid = mid;
    var fielddesc, text;
    zid = getRealPositionInZone(mid);
    highlightFieldName(mid);
    if ((zid - 1) < 0) {
      fielddesc = getFieldInfo("itmFld_" + getDataAttr(Ctrl("fldlistcont").firstChild.childNodes[(mid * 2) + 1])).desc;
      if (fielddesc.length > 6)
        fielddesc = fielddesc.substring(0, 7) + "...";
      text = "Before [" + fielddesc + "]";
    }
    else if ((mid * 2) == Ctrl("fldlistcont").firstChild.childNodes.length - 1) {
      /*fielddesc = getFieldInfo("itmFld_"+getDataAttr(Ctrl("fldlistcont").firstChild.childNodes[(mid*2)-1])).desc;
      if(fielddesc.length>6)
        fielddesc = fielddesc.substring(0,7)+"...";*/
      text = "In last position";
    }
    else {
      var previd = getPreviousFieldIdx(mid - 1);
      fielddesc = getFieldInfo("itmFld_" + getDataAttr(Ctrl("fldlistcont").firstChild.childNodes[(previd * 2) + 1])).desc;
      if (fielddesc.length > 6)
        fielddesc = fielddesc.substring(0, 7) + "...";
      text = "Between [" + fielddesc + "] and [";
      fielddesc = getFieldInfo("itmFld_" + getDataAttr(Ctrl("fldlistcont").firstChild.childNodes[(mid * 2) + 1])).desc;
      if (fielddesc.length > 6)
        fielddesc = fielddesc.substring(0, 7) + "...";
      text += (fielddesc + "]");
    }
    Ctrl(idFld + "_shadow_second").textContent = text;
  }
  else if (mid < 0 || mid == posinlist || mid == (posinlist + 1)) {
    highlightFieldName(-1);
    Ctrl(idFld + "_shadow_second").textContent = "";
    oldmid = -1;
  }

  var hp = Ctrl(idFld).offsetHeight;//+Ctrl(Strtran(idFld,"fld_",posinlist+"_")+"_space").offsetHeight;
  var limy = getY(Ctrl("fldlistcont"));
  var limyy = limy + Ctrl("fldlistcont").offsetHeight;
  if (limy < ypos && limyy > ypos) {
    if (ypos + hp > limyy)
      Ctrl("fldlistcont").scrollTop += hp;
    else if (ypos - hp < limy)
      Ctrl("fldlistcont").scrollTop -= hp;
  }
  xpos += dx;
  ypos += dy;
  Ctrl("canvas").onmousedown = null;
  Ctrl("canvas").onmouseup = null;
  document.getElementById(idFld + "_shadow").style.left = xpos + "px";
  document.getElementById(idFld + "_shadow").style.top = ypos + "px";
  document.body.onmouseup = putShadowField;
}

function getPreviousFieldIdx(midx) {
  if (midx < 0)
    return 0;
  var ridx = -1;
  var id = Ctrl("fldlistcont").firstChild.childNodes[(midx * 2) + 1].id;
  if ($(id).hasClass("notused"))
    ridx = getPreviousFieldIdx(midx - 1);
  else
    ridx = midx;
  return ridx;
}

function putShadowField(/*e*/) {
  var dest = document.getElementsByClassName("fieldspacehighlight")[0];
  if (!Empty(dest)) {
    moveField(idFld, posinlist, dest);
    setFieldListPositions("fldlistcont");
  }
  removeClassFromItems("fieldspacehigh");
  removeClassFromItems("fieldspacehighlight");
  removeClassFromItems("fieldObjectDrag");
  removeClassFromItems("fieldObjectLenDrag");
  removeClassFromItems("fieldObjectLenCDrag");
  document.body.removeChild(Ctrl(idFld + "_shadow"));
  document.body.style.cursor = "default";
  document.body.onmousedown = null;
  document.body.onmousemove = null;
  document.body.onmouseup = null;

  idFld = "";
  dx = dy = xpos = ypos = null;
  posinlist = -1;
  Ctrl("canvas").onmousedown = beginDragSelection;
  Ctrl("canvas").onmouseup = endDragSelection;
}

function moveField(idFld, posinlist, dest) {
  var itemtomove = Ctrl(idFld);
  Ctrl("fldlistcont").firstChild.insertBefore(itemtomove, dest.parentNode);
  var itemtomovespace = Ctrl(Strtran(idFld, "fld_", posinlist + "_") + "_space");
  Ctrl("fldlistcont").firstChild.insertBefore(itemtomovespace, itemtomove);
  var realposdest = getRealPositionInZone(parseInt(getDataAttr(dest)));
  var realposnow = getRealPositionInZone(posinlist);
  var isLast = false;
  if (dest.id.indexOf("last") >= 0)
    isLast = true;
  if (Ctrl(getDataAttr(itemtomove)).checked) {
    setLoading();
    moveFieldCurrentObj(idFld, realposdest, realposnow, isLast);
    pushToHistory();
    drawEditor();
  }
}

function getRealPositionInZone(poslist) {
  var items = Ctrl("fldlistcont").firstChild.childNodes;
  var count = 0;
  for (var i = 0; i < items.length && i < poslist * 2; i++) {
    if (items[i].id.indexOf("fld_") >= 0 && $(items[i].id).hasClass("notused"))
      count++;
  }
  return poslist - count;
}

function getModelFromZone(zone) {
  var ret = {};
  ret.model = 'list';
  var r = getFirstItemWithFlabel(zone);
  if (!Empty(r.lfield)) {
    var rr;
    ret.lfield = r.lfield;
    rr = getObjModel(r.lfield);
    ret.model = rr.model;
    ret.flabel = rr.flabel;
    if (Empty(r.ftotal)) {
      rr = getFirstItemWithFtotal(zone);
      ret.ftotal = rr.ftotal;
    }
    else
      ret.ftotal = r.ftotal;
  }
  return ret;
}

function moveFieldCurrentObj(idFld, realposdest, realposnow, isLast) {
  var malias = getDataAttr(Ctrl(idFld));
  var zone = Strtran(gselectzone.replace(/[0-9]/g, ""), "zpagem", "");
  if (isLast) {
    removeFields(malias, zone);
    addDocField(malias, zone, isLast);
  }
  else {
    var rref = getModelFromZone(zone);
    var posbefore = {};
    if (realposdest > realposnow) {
      realposdest = realposdest - 1;
    }
    if (realposdest == realposnow)
      return;
    var lfield = getPosZoneField(zone, realposdest);
    var ret, k, o, delta;
    posbefore.x = lfield.position.x;
    posbefore.y = lfield.position.y;
    posbefore.yRelative = lfield.position.yRelative;
    if (realposdest < 0) realposdest = 0;
    var robj = removeFields(malias, zone);
    if (rref.lfield.uid == robj.lfield.uid) rref = getModelFromZone(zone);
    if (rref.model == "table") {
      delta = 5;
      var mzone;
      var rw = robj.lfield.position.width;
      if (!Empty(robj.flabel)) rw = Math.max(rw, robj.flabel.position.width);
      if (!Empty(robj.ftotal)) rw = Math.max(rw, robj.ftotal.position.width);
      rw += delta;
      robj.lfield.position.x = posbefore.x;
      //sposta
      ret = getZoneElementsAfterX(zone, robj.lfield.position.x - 1);
      for (k = 0; k < ret.length; k++) {
        o = ret[k];
        if (o.type != 'line')
          o.position.x += rw;
      }
      if (!Empty(rref.flabel)) {
        mzone = getItemZone(rref.flabel);
        ret = getZoneElementsAfterX(mzone, robj.lfield.position.x - 1);
        for (k = 0; k < ret.length; k++) {
          o = ret[k];
          if (o.type != 'line')
            o.position.x += rw;
        }
        if (!Empty(robj.flabel)) {
          robj.flabel.position.x = robj.lfield.position.x;
          //inserire
          m_CurrentObj[mzone].items.push(robj.flabel);
        }
      }
      if (!Empty(rref.ftotal)) {
        mzone = getItemZone(rref.ftotal);
        ret = getZoneElementsAfterX(mzone, robj.lfield.position.x - 1);
        for (k = 0; k < ret.length; k++) {
          o = ret[k];
          if (o.type != 'line')
            o.position.x += rw;
        }
        if (!Empty(robj.ftotal)) {
          robj.ftotal.position.x = robj.lfield.position.x;
          //inserire
          m_CurrentObj[mzone].items.push(robj.ftotal);
          // da completare
          //riordinare in base alle position
        }
      }
      //inserire
      m_CurrentObj[zone].items.splice(realposdest, 0, robj.lfield);
    }
    else { // list
      delta = 2;
      var rh = robj.lfield.position.height;
      if (!Empty(robj.flabel)) rw = Math.max(rh, robj.flabel.position.height);
      rh += delta;
      robj.lfield.position.y = posbefore.y;
      robj.lfield.position.yRelative = posbefore.yRelative;
      //sposta
      ret = getZoneElementsAfterY(zone, robj.lfield.position.y - 1);
      for (k = 0; k < ret.length; k++) {
        o = ret[k];
        o.position.y += rh;
        o.position.yRelative += rh;
      }
      if (!Empty(robj.flabel)) {
        robj.flabel.position.y = robj.lfield.position.y;
        robj.flabel.position.yRelative = robj.lfield.position.yRelative;
        //inserire
        m_CurrentObj[zone].items.push(robj.flabel);
      }
      //inserire
      m_CurrentObj[zone].items.splice(realposdest, 0, robj.lfield);
      var mh = getLastYPosition(m_CurrentObj[zone].items, true, false);
      if (mh > m_CurrentObj[zone].height) m_CurrentObj[zone].height += mh - m_CurrentObj[zone].height + delta;
    }
  }
}

function setFieldListPositions(idcont) {
  var listul = Ctrl(idcont).firstChild.children;
  var tid = "";
  var idx = -1;
  for (var i = 0; i < listul.length; i++) {
    idx = Math.floor((i / 2));
    if (listul[i].id.indexOf("_space") >= 0) {
      listul[i].firstChild.setAttribute("data-attr", idx);
      tid = listul[i].id;
      listul[i].id = idx + tid.substring(tid.indexOf("_"));
    }
    else {
      tid = getDataAttr(listul[i]);
      listul[i].childNodes[0].id = idx + "_" + tid + "_drag";
      listul[i].childNodes[1].id = idx + "_" + tid + "_fld";
      listul[i].childNodes[2].firstChild.id = idx + "_" + tid + "_fldlenColor";
      listul[i].childNodes[2].id = idx + "_" + tid + "_fldlen";
    }
  }
}

function highlightFieldSpace(xp, yp) {
  var items = document.getElementsByClassName("fieldspace");
  var l = items.length;
  var idx = -1;
  for (var i = 0; i < l; i++) {
    $(items[i].id).removeClass("fieldspacehighlight");
    if (xp >= items[i].offsetLeft && xp <= (items[i].offsetLeft + items[i].offsetWidth)) {
      if (yp >= items[i].offsetTop && yp <= (items[i].offsetTop + items[i].offsetHeight)) {
        $(items[i].id).addClass("fieldspacehighlight");
        idx = parseInt(getDataAttr(items[i]));
      }
    }
  }
  return idx;
}

function highlightFieldName(idx) {
  var flds = Ctrl("fldlistcont").firstChild.childNodes;
  var mid = "", ipos = -1, prevpos = -1;
  for (var i = 1; i < flds.length; i = i + 2) {
    if ($(flds[i].id).hasClass("used")) {
      ipos = parseInt(getDataAttr(Ctrl("fld_" + getDataAttr(flds[i]) + "_space")));
      mid = ipos + "_" + getDataAttr(flds[i]) + "_fld";
      prevpos = getPreviousFieldIdx(idx - 1);
      if (!Empty(Ctrl(mid)) && ipos != prevpos && ipos != idx) {
        $(mid).addClass("fieldObjectDrag");
        $(mid + "len").addClass("fieldObjectLenDrag");
        $(mid + "lenColor").addClass("fieldObjectLenCDrag");
      }
      else if (!Empty(Ctrl(mid))) {
        $(mid).removeClass("fieldObjectDrag");
        $(mid + "len").removeClass("fieldObjectLenDrag");
        $(mid + "lenColor").removeClass("fieldObjectLenCDrag");
      }
    }
  }
}

function addClassToItems(cname, clname) {
  var items = document.getElementsByClassName(cname);
  var l = items.length;
  for (var i = l - 1; i >= 0; i--)
    $(items[i].id).addClass(clname);
}

function getFirstItemWithFlabel(zone) {
  var r = {};
  if (m_CurrentObj[zone].items.length > 0) {
    for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
      if (m_CurrentObj[zone].items[i].type == 'field') {
        if (m_CurrentObj[zone].items[i].fieldLabel) {
          var f = getItemFieldUid(m_CurrentObj[zone].items[i].fieldLabel, 'label', m_CurrentObj);
          if (Empty(f)) continue;
          r.lfield = m_CurrentObj[zone].items[i];
          r.flabel = f;
          r.ftotal = getItemFieldUid(r.lfield.fieldTotal, 'field', m_CurrentObj);
          i = m_CurrentObj[zone].items.length;
        }
      }
    }
  }
  return r;
}

function getFirstItemWithFtotal(zone) {
  var r = {};
  if (m_CurrentObj[zone].items.length > 0) {
    for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
      if (m_CurrentObj[zone].items[i].type == 'field') {
        if (m_CurrentObj[zone].items[i].fieldTotal) {
          var f = getItemFieldUid(m_CurrentObj[zone].items[i].fieldTotal, 'field', m_CurrentObj);
          if (Empty(f)) continue;
          r.lfield = m_CurrentObj[zone].items[i];
          r.ftotal = f;
          i = m_CurrentObj[zone].items.length;
        }
      }
    }
  }
  return r;
}

function refreshdata() {
  fieldHTML = [];
  loadFields();
  setDocumentUsedFields();
}

function getPosInList(alias) {
  var itms = document.getElementsByClassName("fieldspace");
  var ret = -1;
  for (var i = 0; i < itms.length && ret < 0; i++) {
    if (itms[i].id.indexOf(alias) >= 0)
      ret = getDataAttr(itms[i]);
  }
  return ret;
}

function setLoading() {
  Ctrl("loading").style.opacity = 1;
  Ctrl('loading').style.display = 'block';
  Ctrl("loading").style.left = "0px";
}

function setModifiedZone(zone) {
  if (modifiedZone.indexOf(zone) < 0)
    modifiedZone.push(zone);
}

function removeLabelReferenceFromField(item, relfield) {
  if (relfield == "fieldLabel" && item.type != "label")
    return;
  if (relfield == "fieldTotal" && item.type != "field")
    return;
  var zone = "";
  var found;
  for (var j = 0; j < reportZones.length; j++) {
    zone = Strtran(reportZones[j], "content", "");
    found = false;
    if (zone != "groupbreak" && m_CurrentObj[zone]) {
      for (var i = 0; i < m_CurrentObj[zone].items.length && !found; i++) {
        if (m_CurrentObj[zone].items[i].type == "field" && m_CurrentObj[zone].items[i][relfield] == item.uid) {
          m_CurrentObj[zone].items[i][relfield] = "";
          found = true;
        }
      }
    }
  }
}

function setDocumentUsedFields() {
  if (m_CurrentObj == null)
    return;
  var zone = "";
  for (var j = 0; j < reportZones.length; j++) {
    zone = Strtran(reportZones[j], "content", "");
    if (zone != "groupbreak" && m_CurrentObj[zone]) {
      for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
        if (m_CurrentObj[zone].items[i].type == "field")
          setUsedField(m_CurrentObj[zone].items[i].fieldDetail.alias);
      }
    }
  }
}

function setUsedField(alias) {
  if (mapFieldCount[alias] && mapFieldCount[alias] > 0)
    addFieldUsedClass("itmFld_" + alias);
  else
    removeFieldUsedClass("itmFld_" + alias);
}

function resetMapFieldCount() {
  mapFieldCount = [];
  for (var i = 0; i < fieldHTML.length; i++) {
    mapFieldCount[fieldHTML[i].alias] = 0;
  }
}

function setMapFieldCount(alias) {
  mapFieldCount[alias]++;
}

function addFieldDragClass(id) {
  if (Empty(Ctrl(id))) return;
  $(id).addClass("fieldObjectDrag");
  $(id + "len").addClass("fieldObjectLenDrag");
  $(id + "lenColor").addClass("fieldObjectLenCDrag");
}

function removeFieldDragClass(id) {
  if (Empty(Ctrl(id))) return;
  $(id).removeClass("fieldObjectDrag");
  $(id + "len").removeClass("fieldObjectLenDrag");
  $(id + "lenColor").removeClass("fieldObjectLenCDrag");
}

function CheckCalculateField(refobj, move) {
  var idx = refobj.idx;
  if (idx < 0)
    return;
  if (itemsHTML[idx].type != "field")
    return;
  if (itemsHTML[idx].fieldDet.type != "N")
    return;
  if (move && itemsHTML[idx].calculate != "none" && itemsHTML[idx].zone.indexOf("footer") < 0) {
    itemsHTML[idx].calculate = "none";
    itemsHTML[idx].calcbygrp = false;
    itemsHTML[idx].fbold = "normal";
    Ctrl(itemsHTML[idx].id + "_int").style.fontWeight = itemsHTML[idx].fbold;
    setCalculation(itemsHTML[idx]);
  }
  else if (!move) {
    itemsHTML[idx].x = refobj.x;
    itemsHTML[idx].y = refobj.y;
    itemsHTML[idx].yRel = refobj.yRel;
    Ctrl(itemsHTML[idx].id).style.left = itemsHTML[idx].x + "px";
    Ctrl(itemsHTML[idx].id).style.top = itemsHTML[idx].y + "px";
    if (!Empty(itemsHTML[idx].shadow)) {
      Ctrl(itemsHTML[idx].shadow).style.left = itemsHTML[idx].x + "px";
      Ctrl(itemsHTML[idx].shadow).style.top = itemsHTML[idx].y + "px";
      Ctrl(Strtran(itemsHTML[idx].shadow, "shadow", "handlersWrapper")).style.left = (itemsHTML[idx].x - 9) + "px";
      Ctrl(Strtran(itemsHTML[idx].shadow, "shadow", "handlersWrapper")).style.top = (itemsHTML[idx].y - 9) + "px";
    }
  }
}

function removeMissingFields(alias, zone) {
  setLoading();
  gselectzone = zone;
  removeFields(alias, zone);
  removeAllHandlers();
  drawEditor();
}

/* magari mettere questi metodi sotto PortalCommonsJS */
function getOffsetWidth(labelText, labelFont) {
  var mySpan = getSpanTag();
  if (labelText != "") {
    mySpan.innerHTML = labelText;
    mySpan.style.fontFamily = labelFont.name;
    mySpan.style.fontWeight = labelFont.weight;
    mySpan.style.fontSize = labelFont.size + 'px';
    return mySpan.offsetWidth;
  }
  else
    return 0;
}

function getOffsetHeight(labelText, labelFont) {
  var mySpan = getSpanTag();
  if (labelText != "") {
    mySpan.innerHTML = labelText;
    mySpan.style.fontFamily = labelFont.name;
    mySpan.style.fontStyle = labelFont.style;
    mySpan.style.fontWeight = labelFont.weight;
    mySpan.style.fontSize = labelFont.size + 'px';
    return mySpan.offsetHeight;
  }
  else
    return 0;
}

function hideMask() {
  Ctrl('i_mask_wrapper_parent').style.display = 'none';
  setLoading();
  drawEditor();
}

function cancelMask() {
  setMaskParams(true);
  hideMask();
}

function execMask() {
  setMaskParams();
  hideMask();
}

function setMaskParams(pnull) {
  var parametersValue = Ctrl('i_mask').contentWindow.ZtVWeb.getPortletWindow("SPMaskParameters").getParametersValue();
  var el;
  maskparams = "";
  if (isbo) {
    var type = "";
    for (el in parametersValue) {
      if (maskparams.length > 0)
        maskparams += ' and ';
      if (parametersValue[el] !== null) {
        maskparams += el + '=';
        if (pnull)
          maskparams += "''";
        else {
          type = getFieldType(el);
          maskparams += ZtVWeb.toSQL(parametersValue[el], type);
        }
      }
    }
  }
  else {
    for (el in parametersValue) {
      if (maskparams.length > 0)
        maskparams += ',';
      if (parametersValue[el] !== null)
        maskparams += el + '=' + parametersValue[el];
      else
        maskparams += el + '=';
    }
  }
}

function clearAllZones() {
  clearHTMLZone("reportheader");
  clearHTMLZone("pageheader");
  clearHTMLZone("groupbreak");
  clearHTMLZone("groupheader");
  clearHTMLZone("groupbody");
  clearHTMLZone("groupfooter");
  clearHTMLZone("pagefooter");
  clearHTMLZone("reportfooter");
}

function showMask() {
  Ctrl('i_mask_wrapper_parent').style.display = 'block';
}

var isbo = false;
function execMaskParameters(datasource, vdmfile) {
  if (dataobj) {
    maskobj = {};
    maskobj.datasource = datasource;
    return false;
  }

  if (!Empty(vdmfile)) {
    var existVdm = new JSURL("../servlet/SPVDMProxy?m_cAction=exist&m_cConfigName=" + URLenc(vdmfile), true).Response() == 1;
    if (existVdm) {
      maskobj = eval("(" + new JSURL("../servlet/SPVDMProxy?m_cAction=load&m_cConfigName=" + vdmfile, true).Response() + ")");
      if (maskobj && maskobj.fields.length > 0) {
        maskobj.datasource = datasource;
        Ctrl('loading').style.display = 'none';
        showMask();//Ctrl('i_mask_wrapper_parent').style.display = 'block';
        Ctrl('i_mask').onload = function () {
          var spmaskportlet = Ctrl('i_mask').contentWindow.ZtVWeb.getPortletWindow("SPMaskParameters");
          if (spmaskportlet && spmaskportlet.isPortletTitled() && spmaskportlet.getTitlePortlet()) {
            spmaskportlet.btn_confirm_Click = function () {
              execMask();
            }
            spmaskportlet.btn_discard_Click = function () {
              cancelMask();
            }
          }
        };
        toggleParametersIframe(maskobj, "", "i_mask", null, true);
        return true;
      }
      else
        return loadVdmFromData();
    }
    else
      return loadVdmFromData();
  }
  else
    return loadVdmFromData();

  function loadVdmFromData() {
    var parametersArray;
    var mdatasource = datasource;
    if (mdatasource.indexOf("BO:") >= 0) {
      parametersArray = GetBOKeysVariables(mdatasource, true);
      isbo = true;
    }
    else //query
      parametersArray = GetQueryParameters(mdatasource, true, isoffline);

    maskobj = {};
    maskobj.datasource = mdatasource;
    maskobj.fields = [];
    //maskobj.titleMsg = "Datasource parameters value settings";
    maskobj.maxLabelWidth = 220;
    maskobj.maxFieldWidth = 270;
    var str = new JSURL("../servlet/SPReportGet?action=notes&filename=" + mdatasource);
    str = str.Response();
    if (parametersArray[0].length > 0) {
      for (var nav_j = 0; nav_j < parametersArray[0].length; nav_j++) {
        if (parametersArray[0][nav_j] != "CPROWNUM") {
          maskobj.fields[nav_j] = {};
          maskobj.fields[nav_j].fieldName = parametersArray[0][nav_j];
          maskobj.fields[nav_j].description = parametersArray[1][nav_j];
          maskobj.fields[nav_j].type = parametersArray[2][nav_j];
          maskobj.fields[nav_j].len = parseInt(parametersArray[3][nav_j]);
          maskobj.fields[nav_j].dec = parseInt(parametersArray[4][nav_j]);
          maskobj.fields[nav_j].group = str;
        }
      }

      Ctrl('loading').style.display = 'none';
      showMask();//Ctrl('i_mask_wrapper_parent').style.display='block';

      Ctrl('i_mask').onload = function () {
        var spmaskportlet = Ctrl('i_mask').contentWindow.ZtVWeb.getPortletWindow("SPMaskParameters");
        if (spmaskportlet && spmaskportlet.isPortletTitled() && spmaskportlet.getTitlePortlet()) {
          spmaskportlet.btn_confirm_Click = function () {
            execMask();
          }
          spmaskportlet.btn_discard_Click = function () {
            cancelMask();
          }
        }
      };

      toggleParametersIframe(maskobj, "", "i_mask", null, true);
      return true;
    }
    return false;
  }
}

function winitprocess() {
  countindex = 0;
  itemsHTML = [];
  nitem = 0;
  drawLimitBars();
}

function wendprocess() {
  if (Empty(Ctrl(viewcurrpage)))
    viewcurrpage = "page1";
  fpagemargins(Ctrl(Strtran(viewcurrpage, 'page', 'zpagem')), this.obj);
  if (Ctrl(gselectzone))
    fzoneclick(null, Ctrl(gselectzone));
  else
    gselectzone = "";
  setDocumentUsedFields();
  if (window.generateRulers && workunit)
    window.generateRulers(workunit);
}

function wpagegrid(gwork) {
  insertElementGrid(Ctrl("page" + gwork.pagecounter));
  var page = Ctrl("page" + gwork.pagecounter + "grid");
  page.style.width = gwork.ww + "px";
  page.style.height = gwork.hh + "px";
  generateGrid(Ctrl("page" + gwork.pagecounter), page.id, workunit);
}

function waddinzone(objzoneItem, zoneid, isdoc, split/*,nrow*/) {
  var ritem = readJsonItem(objzoneItem, zoneid, countindex, LibJavascript.AlfaKeyGen(5), isdoc);
  ritem.uidfor = objzoneItem.uid;
  ritem.split = split;
  itemsHTML[countindex] = ritem;
  // verifico se il campo e' stato rimosso dalla fonte dati
  if (itemsHTML[countindex].type == "field" && !Empty(itemsHTML[countindex].fieldDet.alias) && getFieldHTMLIndex("itmFld_" + itemsHTML[countindex].fieldDet.alias) < 0) {
    drawMissingIcon(itemsHTML[countindex]);
    itemsHTML[countindex].isMissing = true;
    var htmlmsg = "<div>";
    htmlmsg += "<span style=\"float:left; margin-top:5px; font-size:13px;\">There are missing fields in datasource on the document.</span>";
    htmlmsg += "<span style=\"float:left; margin-top:8px; font-size:13px;\">You can delete or replace them by using the delete or edit button in toolbar.</span>";
    htmlmsg += "</div>";
    showNotimooMissingAlert(htmlmsg);
  }
  idItemsHTML.push(itemsHTML[countindex].id);
  uidItemsHTML.push(itemsHTML[countindex].uid);
  countindex++;
  nitem++;
  return ritem;
}

function wupdatehtmlitem(objzoneItem, ritem, gwork) {
  // se e' un campo tolgo l'icona field
  HideElementsByClass("fieldDescIcon");

  if (objzoneItem.type != "line")
    updateFontProperties(objzoneItem, ritem);
  else {
    var nl = gwork.ww - gwork.marginl - gwork.marginr - Ctrl(ritem.id).offsetLeft;
    applyLineStyleProperties(ritem, nl);
  }
  updTextToImage(ritem);
  setCalculation(ritem);
}

function resetFieldUsed() {
  for (var i = 0; i < fieldHTML.length; i++)
    setUsedField(fieldHTML[i].alias);
}

function updateFieldsPane() {
  if (m_CurrentObj == null)
    return;
  resetMapFieldCount();
  resetFieldUsed();
  var zone = "";
  for (var j = 0; j < reportZones.length; j++) {
    zone = Strtran(reportZones[j], "content", "");
    if (zone != "groupbreak" && m_CurrentObj[zone]) {
      for (var i = 0; i < m_CurrentObj[zone].items.length; i++) {
        if (m_CurrentObj[zone].items[i].type == "field") {
          setMapFieldCount(m_CurrentObj[zone].items[i].fieldDetail.alias);
          setUsedField(m_CurrentObj[zone].items[i].fieldDetail.alias);
        }
      }
    }
  }
}

function makeCsv(std, sdf) {
  var format = "CSV";
  if (std)
    format += "S";
  else if (sdf)
    format += "2";

  var ifrd = document.createElement("div");
  ifrd.id = "smartreport_downloadiframe_" + format;
  ifrd.style.width = "1px";
  ifrd.style.height = "1px";
  if (Empty(Ctrl("smartreport_downloadiframe_" + format)))
    Ctrl("canvasdocprev").appendChild(ifrd);
  else
    ifrd = Ctrl("smartreport_downloadiframe_" + format);
  ifrd.innerHTML = "";

  if (maskobj === null)
    JSRepDrawDocumentView(m_CurrentObj, format, maskparams, Ctrl("smartreport_downloadiframe_" + format), null, { cdownload: Ctrl("downlpdf_cont") }, null, formProp.datasource, true);
  else
    JSRepDrawDocumentView(m_CurrentObj, format, maskparams, Ctrl("smartreport_downloadiframe_" + format), null, { cdownload: Ctrl("downlpdf_cont") }, null, maskobj.datasource, true);
}

function makeXml(str) {
  var format = "XML";
  if (str)
    format += "S";

  var ifrd = document.createElement("div");
  ifrd.id = "smartreport_downloadiframe_" + format;
  ifrd.style.width = "1px";
  ifrd.style.height = "1px";
  if (Empty(Ctrl("smartreport_downloadiframe_" + format)))
    Ctrl("canvasdocprev").appendChild(ifrd);
  else
    ifrd = Ctrl("smartreport_downloadiframe_" + format);
  ifrd.innerHTML = "";

  if (maskobj === null)
    JSRepDrawDocumentView(m_CurrentObj, format, maskparams, Ctrl("smartreport_downloadiframe_" + format), null, { cdownload: Ctrl("downlpdf_cont") }, null, formProp.datasource, true);
  else
    JSRepDrawDocumentView(m_CurrentObj, format, maskparams, Ctrl("smartreport_downloadiframe_" + format), null, { cdownload: Ctrl("downlpdf_cont") }, null, maskobj.datasource, true);
}

function makePdf() {
  var ifrd = document.createElement("div");
  ifrd.id = "smartreport_downloadiframe_pdf";
  ifrd.style.width = "1px";
  ifrd.style.height = "1px";
  if (Empty(Ctrl("smartreport_downloadiframe_pdf")))
    Ctrl("canvasdocprev").appendChild(ifrd);
  else
    ifrd = Ctrl("smartreport_downloadiframe_pdf");
  ifrd.innerHTML = "";

  if (maskobj === null)
    JSRepDrawDocumentView(m_CurrentObj, "pdf", maskparams, Ctrl("smartreport_downloadiframe_pdf"), null, { cdownload: Ctrl("downlpdf_cont") }, null, formProp.datasource, true);
  else
    JSRepDrawDocumentView(m_CurrentObj, "pdf", maskparams, Ctrl("smartreport_downloadiframe_pdf"), null, { cdownload: Ctrl("downlpdf_cont") }, null, maskobj.datasource, true);
}

function printInPreview(obj, format) {
  if (format == "pdf")
    Ctrl("downlpdf_cont").click();
}

/**************** GENERAZIONE REPORT AUTOMATICO DA MODELLO ****************/
function generateReport(opts_obj) {
  var datasource = opts_obj.datasource,
    title = opts_obj.title,
    reportmodel = opts_obj.reportmodel,
    allFields = opts_obj.allFields,
    reportflds = opts_obj.reportflds,
    breakflds = opts_obj.breakflds,
    headerflds = opts_obj.headerflds,
    footerflds = opts_obj.footerflds,
    filterfooter = opts_obj.filterfooter,
    page = opts_obj.page,
    margins = opts_obj.margins,
    pageswitch = opts_obj.pageswitch,
    offline = opts_obj.offline,
    fromprint = opts_obj.fromprint,
    printprops = opts_obj.printprops,
    totalsA = JSON.parse(opts_obj.totalsA),
    printHeaders = opts_obj.printHeaders,
    obj = getFromDesignObj(fromprint);
  obj.snap = false;
  if (!fromprint && !Empty(formProp.datasource) && Empty(datasource))
    datasource = formProp.datasource;
  obj.datasource = datasource;
  obj.vdmMask = "";
  obj.offline = offline;
  obj.showReportZone = true;
  obj.showPageZone = true;
  obj.reportheader.height = 3;
  obj.reportheader.items = [];
  obj.reportfooter.height = 1;
  obj.reportfooter.items = [];
  obj.pageheader.height = 1;
  obj.pageheader.items = [];
  obj.pagefooter.height = 1;
  obj.pagefooter.items = [];
  obj.groupfooter.height = 3;
  obj.groupfooter.items = [];
  obj.groupheader.height = 3;
  obj.groupheader.items = [];
  obj.groupbody.height = 3;
  obj.groupbody.items = [];
  obj.groupbreak.items = [];
  obj.name = title;

  var maxpagewidth = 0;
  if (fromprint && printprops) {
    if (opts_obj.output != "pdf")
      maxpagewidth = 0; // per i formati non "paginati" non serve ragionare in termini di spazio
    else if (!printprops.m_bStretchGridPage) {
      var pf = printprops.m_cPrintGridPageFormat.toLowerCase();
      if( jsPDFPageFormats[pf] ) {
        maxpagewidth = Math.max(jsPDFPageFormats[pf][0], jsPDFPageFormats[pf][1]) * ptTopx;
      }
      else {
        maxpagewidth = Math.max(jsPDFPageFormats.a0[0], jsPDFPageFormats.a0[1]) * ptTopx;
      }
    }
  }

  obj.page.format = page.format;
  obj.page.orientation = page.orientation;
  obj.page.width = page.width;
  obj.page.height = page.height;

  //workunit = margins.unit;
  obj.page.margins.top = margins.top + margins.unit;
  obj.page.margins.bottom = margins.bottom + margins.unit;
  obj.page.margins.left = margins.left + margins.unit;
  obj.page.margins.right = margins.right + margins.unit;

  var flds = [], hflds = [], fflds = [], bflds = [];

  var filtered = reportflds.filter(function (el) {
    if (headerflds.indexOf(el) < 0 && footerflds.indexOf(el) < 0)
      return true;
  });

  if (filtered.length == 0) filtered = reportflds;

  for (var i = 0; i < filtered.length; i++) {
    flds.push(allFields[filtered[i]]);
  }
  for (i = 0; i < breakflds.length; i++) {
    bflds.push(allFields[breakflds[i]]);
  }
  for (i = 0; i < headerflds.length; i++) {
    hflds.push(allFields[headerflds[i]]);
  }
  for (i = 0; i < footerflds.length; i++) {
    if (filterfooter) {
      if (allFields[footerflds[i]].type == "N")
        fflds.push(allFields[footerflds[i]]);
    }
    else
      fflds.push(allFields[footerflds[i]]);
  }

  if (!Empty(obj.name))
    drawReportHeader(obj, fromprint);

  addBreakingFields(obj, bflds);
  var modelwidth = 0;
  if (reportmodel == "table") {
    listGroupHeader(obj, hflds, printprops);
    tableGroupHeader(obj, flds, maxpagewidth, fromprint, printHeaders);
    modelwidth = tableGroupDetail(obj, flds, maxpagewidth, fromprint, printprops);
    if (!fromprint)
      tableGroupFooter(obj, flds);
    else if (fromprint && !Empty(totalsA))
      totalsGroupFooter(obj, totalsA);
    listGroupFooter(obj, fflds, printprops);
  }
  else {// list
    listGroupHeader(obj, hflds, printprops);
    listGroupDetail(obj, flds, fromprint, printprops);
    listGroupFooter(obj, fflds, printprops);
  }

  if (fromprint && modelwidth > 0) {
    if (modelwidth < jsPDFPageFormats.a4[0] * ptTopx) {
      obj.page.format = "A4";
      obj.page.orientation = "portrait";
    }
    else if (modelwidth < jsPDFPageFormats.a4[1] * ptTopx) {
      obj.page.format = "A4";
      obj.page.orientation = "landscape";
    }
    else if (modelwidth < jsPDFPageFormats.a3[0] * ptTopx) {
      obj.page.format = "A3";
      obj.page.orientation = "portrait";
    }
    else if (modelwidth < jsPDFPageFormats.a3[1] * ptTopx) {
      obj.page.format = "A3";
      obj.page.orientation = "landscape";
    }
    else {
      var fkeys = Object.keys(jsPDFPageFormats);
      fkeys = fkeys.slice(fkeys.indexOf("a3") + 1);
      var found = false;
      for (var fk = 0; !found && fk < fkeys.length; fk++) {
        if (modelwidth < jsPDFPageFormats[fkeys[fk]][0] * ptTopx) {
          obj.page.format = fkeys[fk];
          obj.page.orientation = "portrait";
          found = true;
        }
        if (!found) {
          if (modelwidth < jsPDFPageFormats[fkeys[fk]][1] * ptTopx) {
            obj.page.format = fkeys[fk];
            obj.page.orientation = "landscape";
            found = true;
          }
        }
      }
      if (!found) {
        obj.page.format = "A3";
        obj.page.orientation = "landscape";
      }
    }
  }

  drawPageFooter(obj, fromprint, printprops);
  if (!fromprint)
    drawEditorReportFromModel(obj, pageswitch);

  removeSpanTag();
  return obj;
}

function getFromDesignObj(fromprint) {
  var obj = {};
  obj.page = {};
  obj.page.margins = {};
  obj.reportheader = { items: [], options: {} };
  obj.pageheader = { items: []/*, options: {}*/ };
  obj.groupheader = { items: [], options: {} };
  obj.groupbreak = { items: [], options: {} };
  obj.groupbody = { items: []/*, options: {}*/ };
  obj.groupfooter = { items: [], options: {} };
  obj.pagefooter = { items: []/*, options: {}*/ };
  obj.reportfooter = { items: [], options: {} };
  obj.showReportZone = false;
  obj.showPageZone = false;
  obj.showGroupZone = true;
  if (fromprint)
    return obj;
  obj.name = currentname;
  obj.comment = formProp.repcomment;
  obj.version = repversion;
  obj.viewMode = viewMode;
  obj.datasource = formProp.datasource;
  obj.vdmMask = formProp.vdmfile;
  obj.offline = isoffline;

  obj.page.format = formProp.pformat;
  obj.page.orientation = formProp.porientation;
  obj.page.width = formProp.pwidth ? formProp.pwidth : 210;
  obj.page.height = formProp.pheight ? formProp.pheight : 297;

  obj.page.margins.top = formProp.mtheight;
  obj.page.margins.bottom = formProp.mbheight;
  obj.page.margins.left = formProp.mlwidth;
  obj.page.margins.right = formProp.mrwidth;
  // provvisorio
  obj.snap = formProp.snapgrid;

  obj.showReportZone = formProp.showreportzone;
  obj.showPageZone = formProp.showpagezone;
  obj.showGroupZone = formProp.showgroupzone;

  obj.structureGrid = {};
  obj.structureGrid.showRulers = formProp.showrulers;
  obj.structureGrid.showGrid = formProp.showgrid;

  obj.structureGrid.unit = formProp.measureunit;
  if (formProp.gtypelong)
    obj.structureGrid.type = "long";
  else if (formProp.gtypesmall)
    obj.structureGrid.type = "small";
  else
    obj.structureGrid.type = "plain";

  if (formProp.tick50)
    obj.structureGrid.tick = "50";
  else
    obj.structureGrid.tick = "100";

  var zone = "";
  for (var i = 0; i < itemsHTML.length; i++) {
    zone = Strtran(itemsHTML[i].zone, "content", "");
    if (itemsHTML[i].isAllFields) {
      for (var j = 0; j < _allFieldsHTML.length; j++) {
        obj[zone].items.push(makeJsonItemAllFields(itemsHTML[i], _allFieldsHTML[j]));
      }
    }
    else
      obj[zone].items.push(makeJsonItem(itemsHTML[i]));
  }

  obj.groupbreak = {};
  setZoneOptions(obj, "reportheader");
  setZoneOptions(obj, "pageheader");
  setZoneOptions(obj, "groupbreak");
  setZoneOptions(obj, "groupheader");
  setZoneOptions(obj, "groupbody");
  setZoneOptions(obj, "groupfooter");
  setZoneOptions(obj, "pagefooter");
  setZoneOptions(obj, "reportfooter");

  obj.groupbreak.items = gBreakFields;
  return obj;
}

function drawReportHeader(obj, fromprint) {
  var h = fromprint ? 15 : 36;
  var top = obj.reportheader.height;
  var tos = 20;
  var w = 170;
  var tmpitem;

  // data corrente
  var pagew;
  if (obj.page.orientation == "portrait")
    pagew = parseFloat(docSettings[obj.page.format].w); // in pt
  else
    pagew = parseFloat(docSettings[obj.page.format].h); // in pt

  w = 135;

  // titolo
  w = (pagew * ptTopx) - (convertStringToPx(obj.page.margins.left, pagew) + convertStringToPx(obj.page.margins.right, pagew) + 2);  // 2 di bordi
  tmpitem = {};
  tmpitem.uid = "title";
  tmpitem.type = "label";
  tmpitem.typeView = "text";
  tmpitem.value = obj.name;

  tmpitem.position = {};
  tmpitem.position.x = fromprint ? tos : 0;
  tmpitem.position.y = top;
  tmpitem.position.yRelative = top;
  tmpitem.position.width = w;
  tmpitem.position.height = h;

  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.bold = true;
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontColor = "#000000";
  if (fromprint) {
    tmpitem.style.font.left = true;
    tmpitem.style.font.fontSize = "7pt";
  }
  else {
    tmpitem.style.font.center = true;
    tmpitem.style.font.fontSize = "22pt";
  }

  obj.reportheader.items.push(tmpitem);

  obj.reportheader.height += (h + 2 + top);//(2*top+h+2);
}

function addBreakingFields(obj, flds) {
  for (var i = 0; i < flds.length; i++) {
    if (obj.groupbreak.items.indexOf(flds[i].alias) < 0)
      obj.groupbreak.items.push(flds[i].alias);
  }
}

var maxwidthmap = {},
  noprintfields = [],
  fielduids = [];
function tableGroupHeader(obj, flds, maxpagewidth, fromprint, OprintHeaders) {
  var h = fromprint ? 15 : 22;
  var hz = 15;
  var top = obj.groupheader.height;
  var os = 15;
  var cat = 15;
  var w = 175;
  var tmpitem;
  var linecount = 0;
  var progw = 0;
  var x, y, yRel, i, j, k, l, prow, prowfld, rowpw=0;
  
  
  if( OprintHeaders ) {
    var printHeaders = OprintHeaders.headFieldsDesc;
    var printKeys = OprintHeaders.headFieldsKey;
    var pivotDraw = OprintHeaders.pivotDraw;
    obj.pivot = pivotDraw;
    var lkey = '', xkey;
    for (j = 0; j < printHeaders.length; j++) {
      prow = printHeaders[j];
      progw = 0;
      for (i = 0; i < prow.length; i++) {
        prowfld = {};
        prowfld.alias = flds[i].alias;
        prowfld.desc = prow[i];
        prowfld.align = flds[i].align;
        prowfld.type = flds[i].type;
        prowfld.len = flds[i].len;
        if( !maxwidthmap[prowfld.alias] ) {
          prowfld.descs = [];
          for (k = 0; k < printHeaders.length; k++) {
            for (l = 0; l < printHeaders[k].length; l++) {
              prowfld.descs.push(printHeaders[k][l]);
            }
          }
          maxwidthmap[prowfld.alias] = calculateMaxWidth(prowfld, fromprint);
        }
        cat = 5;
        x = os + progw;
        y = obj.groupheader.height + (j+2)*top + (j+1)*hz;
        yRel = (j+2)*top + (j+1)*hz;
        tmpitem = "";
        if (maxpagewidth == 0 || x + maxwidthmap[prowfld.alias] < maxpagewidth) {
          tmpitem = addLabel("tgroupheader", prowfld, x, y, yRel, maxwidthmap[prowfld.alias]);
          if( (j == 0) && (i < pivotDraw.rows.length) ) rowpw += os+maxwidthmap[prowfld.alias];
          if( (j < (printHeaders.length-1)) && (i < pivotDraw.rows.length) ) {
            tmpitem.value = '';
          }
          else if( (j < (printHeaders.length-1)) && (i >= pivotDraw.rows.length) ) {
            xkey = printKeys[printKeys.length-1][i]
            if( !Empty(lkey) && xkey == lkey ) {
              tmpitem.value = '';
            }
            lkey = xkey;
          }
          if (fromprint) {
            tmpitem.style.font.italic = false;
            tmpitem.style.font.bold = true;
            tmpitem.style.font.fontSize = "7pt";
          }
        }
        else if (x + maxwidthmap[prowfld.alias] >= maxpagewidth) {
          if (noprintfields.indexOf(prowfld.alias) < 0)
            noprintfields.push(prowfld.alias);
        }
  
        if (!Empty(tmpitem) && (noprintfields.indexOf(prowfld.alias) < 0)) {
          tmpitem.titleStretch = true;
          obj.groupheader.items.push(tmpitem);
        }
        progw += (maxwidthmap[prowfld.alias] + cat);
      }
    }
  
    prowfld = {};
    prowfld.alias = 'lbl_columns';
    prowfld.desc = '';
    for( i=0; i<pivotDraw.columns.length; i++ )
      prowfld.desc += pivotDraw.columns[i].desc + ' ';
    prowfld.align = 'center';
    prowfld.type = 'C';
    j = 0;
    y = obj.groupheader.height + (j+1)*top + j*hz;
    yRel = top + j*hz;
    tmpitem = addLabel("tgroupheader", prowfld, rowpw, y, yRel, maxpagewidth-rowpw-(convertStringToPx(obj.page.margins.left, maxpagewidth) + convertStringToPx(obj.page.margins.right, maxpagewidth) + 2));
    if (fromprint) {
      tmpitem.style.font.italic = false;
      tmpitem.style.font.bold = true;
      tmpitem.style.font.fontSize = "7pt";
    }
    obj.groupheader.items.push(tmpitem);
    obj.groupheader.height = obj.groupheader.height + (printHeaders.length)*hz + (printHeaders.length+1)*top;
  }
  else {
    for (i = 0; i < flds.length; i++) {
      maxwidthmap[flds[i].alias] = calculateMaxWidth(flds[i], fromprint);
      cat = flds[i].type == "M" ? 20 : 5;
      x = os + progw;
      y = obj.groupheader.height + top;
      yRel = top;
      tmpitem = "";
      if (maxpagewidth == 0 || x + maxwidthmap[flds[i].alias] < maxpagewidth) {
        tmpitem = addLabel("tgroupheader", flds[i], x, y, yRel, maxwidthmap[flds[i].alias]);
        if (fromprint) {
          tmpitem.style.font.italic = false;
          tmpitem.style.font.bold = true;
          tmpitem.style.font.fontSize = "7pt";
        }
      }
      else if (x + maxwidthmap[flds[i].alias] >= maxpagewidth) {
        if (noprintfields.indexOf(flds[i].alias) < 0)
          noprintfields.push(flds[i].alias);
      }
  
      if (!Empty(tmpitem) && (noprintfields.indexOf(flds[i].alias) < 0)) {
        tmpitem.titleStretch = true;
        obj.groupheader.items.push(tmpitem);
      }
      progw += (maxwidthmap[flds[i].alias] + cat);
    }
  } 
  
  // inserisco linea - ultimi elementi prima del detail
  tmpitem = {};
  tmpitem.uid = "line_" + linecount;
  tmpitem.type = "line";
  tmpitem.typeView = "line";
  tmpitem.position = {};
  tmpitem.position.x = os;
  tmpitem.position.y = obj.groupheader.height + top + h + 3;  // +3 provvisorio (mancano agganci)
  tmpitem.position.yRelative = obj.groupheader.height + top + h + 3;
  tmpitem.position.width = flds.length * (w + 2 + cat);
  tmpitem.position.height = 1;
  tmpitem.style = {};
  tmpitem.style.line = {};
  tmpitem.style.line.height = 1;
  tmpitem.style.line.type = "plain";
  tmpitem.style.line.color = "#000000";
  tmpitem.style.stretchToRight = true;
  obj.groupheader.items.push(tmpitem);

  obj.groupheader.height = obj.groupheader.height + h + top + hz; // +5 provvisorio
  obj.groupheader.options.reprintOnPage = true
}

var xMap = {};
function tableGroupDetail(obj, flds, maxpagewidth, fromprint, printprops) {
  var h = fromprint ? 15 : 22;
  var top = obj.groupbody.height;
  var os = 15;
  var cat = 15;
  var tmpitem;
  var progw = 0;
  var defDateFormat = "YYYY-MM-DD";
  var defTimeFormat = "HH:MM:SS";

  if (printprops && printprops.userLanguage && printprops.userLanguage.toLowerCase() == "ita")
    defDateFormat = "DD-MM-YYYY";

  var x, y, yRel;
  for (var i = 0; i < flds.length; i++) {
    cat = flds[i].type == "M" ? 20 : 5;
    x = os + progw;
    y = obj.groupbody.height + top;
    yRel = top;
    tmpitem = "";
    if (maxpagewidth == 0 || x + maxwidthmap[flds[i].alias] < maxpagewidth) {
      tmpitem = addField("tgroupbody", flds[i], x, y, yRel, false, fromprint);
      tmpitem.fieldLabel = "lbl_tgroupheader" + flds[i].alias;
      tmpitem.alias = flds[i].alias;
      if (!Empty(flds[i].align)) {
        switch (flds[i].align) {
          case "right":
            tmpitem.style.font.right = true;
            break;
          case "center":
            tmpitem.style.font.center = true;
            break;
          default:
            tmpitem.style.font.left = true;
            break;
        }
      }
      if (flds[i].type == 'N' && !fromprint) {
        tmpitem.fieldTotal = "fld_tgroupfooter" + flds[i].alias;
        tmpitem.style.font.right = true;
      }
      if (fromprint)
        tmpitem.style.font.fontSize = "7pt";
      if (tmpitem.typeView.indexOf("date") >= 0) {
        tmpitem.picture = {};
        tmpitem.picture.dateformat = defDateFormat;
        if (flds[i].type == 'T')
          tmpitem.picture.timeformat = defTimeFormat;
      }
    }
    else if (x + maxwidthmap[flds[i].alias] >= maxpagewidth) {
      if (noprintfields.indexOf(flds[i].alias) < 0)
        noprintfields.push(flds[i].alias);
    }
    if (!Empty(tmpitem) && (noprintfields.indexOf(flds[i].alias) < 0)) {
      if (fielduids.indexOf(tmpitem.uid) >= 0)
        tmpitem.uid = tmpitem.uid + LibJavascript.AlfaKeyGen(2);
      fielduids.push(tmpitem.uid);
      xMap[flds[i].alias] = tmpitem.position.x;
      obj.groupbody.items.push(tmpitem);
      progw += (maxwidthmap[flds[i].alias] + cat);
    }
  }

  obj.groupbody.height = h + top + 2;
  return progw > 0 ? progw - cat : progw;
}

function tableGroupFooter(obj, flds) {
  var h = 22;
  var top = obj.groupfooter.height;
  var os = 15;
  var cat = 15;
  var tmpitem;
  var progw = 0;
  var x, y, yRel;
  for (var i = 0; i < flds.length; i++) {
    cat = flds[i].type == "M" ? 20 : 5;
    x = os + progw;
    y = obj.groupfooter.height + top;
    yRel = top;
    tmpitem = addField("tgroupfooter", flds[i], x, y, yRel, true);
    if (!Empty(tmpitem) && flds[i].type == "N")
      obj.groupfooter.items.push(tmpitem);
    progw += (maxwidthmap[flds[i].alias] + cat);
  }
  if (!Empty(flds))
    obj.groupfooter.height = 1 * (h + top + 2 + cat + 0);
}

function totalsGroupFooter(obj, totalsA) {
  var h = 22,
    top = obj.groupfooter.height,
    tmpitem,
    x,
    y = 2 * top,
    flds = Object.keys(totalsA[0]),
    t_flds = totalsA[totalsA.length - 1];

  for (var i = 0; i < flds.length; i++) {
    if (flds[i] in xMap) {
      x = xMap[flds[i]];
      tmpitem = addTotalField("tgroupfooter", flds[i], x, y, top, t_flds[flds[i]], true);
      if (!Empty(tmpitem))
        obj.groupfooter.items.push(tmpitem);
      for (var j = 0; j < totalsA.length - 1; j++) {
        tmpitem = addTotalField("tgroupfooter", flds[i], x, y + h, top + h, totalsA[j][flds[i]], false);
        if (!Empty(tmpitem))
          obj.groupfooter.items.push(tmpitem);
        y = y + h;
        top = top + h;
      }
      top = obj.groupfooter.height;
      y = 2 * top;
    }
  }

  if (!Empty(flds))
    obj.groupfooter.height = h + top + 7; // offset
}

function listGroupHeader(obj, flds, printprops) {
  var h = 22;
  var w = 174;
  var top = obj.groupheader.height;
  var os = 20;
  var cat = 5;//(w*0.1)+catcherSize;
  var caty = (h * 0.1) + catcherSize;
  var tmpitem;
  var progh = 0;
  var defDateFormat = "YYYY-MM-DD";
  var defTimeFormat = "HH:MM:SS";

  if (printprops && printprops.userLanguage && printprops.userLanguage.toLowerCase() == "ita")
    defDateFormat = "DD-MM-YYYY";
  var x, y, yRel;
  for (var i = 0; i < flds.length; i++) {
    // LABEL
    x = os;
    y = obj.groupheader.height + top + progh;
    yRel = top + progh;
    tmpitem = addLabel("groupheader", flds[i], x, y, yRel, w);
    if (!Empty(tmpitem))
      obj.groupheader.items.push(tmpitem);

    // FIELD
    x = os + cat + w;
    y = obj.groupheader.height + top + progh;
    tmpitem = addField("groupheader", flds[i], x, y, yRel);
    tmpitem.position.width = Math.min(w, (lenFactor * flds[i].len));
    if (tmpitem.typeView.indexOf("date") >= 0) {
      tmpitem.picture = {};
      tmpitem.picture.dateformat = defDateFormat;
      if (flds[i].type == 'T')
        tmpitem.picture.timeformat = defTimeFormat;
    }
    if (!Empty(tmpitem))
      obj.groupheader.items.push(tmpitem);
    progh += (caty + h);
  }
  obj.groupheader.height = top + progh;
}

function listGroupDetail(obj, flds, fromprint, printprops) {
  var h = fromprint ? 15 : 22;
  var top = obj.groupbody.height;
  var os = 20;
  var w = 175;
  var cat = 5;
  var caty = 4;
  var tmpitem;
  var linecount = 0;
  var lineH = 7;
  var progh = 0;
  var x, y, yRel;
  var defDateFormat = "YYYY-MM-DD";
  var defTimeFormat = "HH:MM:SS";

  if (printprops && printprops.userLanguage && printprops.userLanguage.toLowerCase() == "ita")
    defDateFormat = "DD-MM-YYYY";

  // inserisco linea nel detail - primo elemento
  tmpitem = {};
  tmpitem.uid = "line_" + linecount + "_body";
  tmpitem.type = "line";
  tmpitem.position = {};
  tmpitem.position.x = os;
  tmpitem.position.y = obj.groupbody.height + top;
  tmpitem.position.yRelative = top;
  tmpitem.position.width = 2 * (w + 2 + cat);
  tmpitem.position.height = 1;
  tmpitem.style = {};
  tmpitem.style.line = {};
  tmpitem.style.line.height = 1;
  tmpitem.style.line.type = "plain";
  tmpitem.style.line.color = "#000000";
  tmpitem.style.stretchToRight = true;
  obj.groupbody.items.push(tmpitem);

  linecount++;

  for (var i = 0; i < flds.length; i++) {
    yRel = top + progh + lineH;
    y = obj.groupbody.height + yRel;

    // LABEL
    x = os;
    tmpitem = addLabel("groupbody", flds[i], x, y, yRel, w);
    if (!Empty(tmpitem))
      obj.groupbody.items.push(tmpitem);

    // FIELD
    x = os + cat + w;
    tmpitem = addField("groupbody", flds[i], x, y, yRel, false, fromprint);
    if (tmpitem.typeView.indexOf("date") >= 0) {
      tmpitem.picture = {};
      tmpitem.picture.dateformat = defDateFormat;
      if (flds[i].type == 'T')
        tmpitem.picture.timeformat = defTimeFormat;
    }
    if (!Empty(tmpitem))
      obj.groupbody.items.push(tmpitem);
    progh += (caty + h);
  }

  obj.groupbody.height = top + progh + 2 * lineH;
}

function listGroupFooter(obj, flds, printprops) {
  var h = 22;
  var top = obj.groupfooter.height;
  var os = 20;
  var w = 174;
  var cat = 5;//(w*0.1)+catcherSize;
  var caty = (h * 0.1) + catcherSize;
  var tmpitem;
  var progh = 0;
  var x, y, yRel;
  var defDateFormat = "YYYY-MM-DD";
  var defTimeFormat = "HH:MM:SS";

  if (printprops && printprops.userLanguage && printprops.userLanguage.toLowerCase() == "ita")
    defDateFormat = "DD-MM-YYYY";

  for (var i = 0; i < flds.length; i++) {
    // LABEL
    x = os;
    y = obj.groupfooter.height + top + progh;
    yRel = top + progh;
    tmpitem = addLabel("groupfooter", flds[i], x, y, yRel, w);
    if (flds[i].type == "N" && flds[i].alias != "CPROWNUM")
      tmpitem.value += " [Total]";
    if (!Empty(tmpitem))
      obj.groupfooter.items.push(tmpitem);

    // FIELD
    x = os + cat + w;
    y = obj.groupfooter.height + top + progh;
    tmpitem = addField("groupfooter", flds[i], x, y, yRel);
    if (tmpitem.typeView.indexOf("date") >= 0) {
      tmpitem.picture = {};
      tmpitem.picture.dateformat = defDateFormat;
      if (flds[i].type == 'T')
        tmpitem.picture.timeformat = defTimeFormat;
    }
    if (!Empty(tmpitem))
      obj.groupfooter.items.push(tmpitem);
    progh += (caty + h);
  }
  obj.groupfooter.height = top + progh;
}

function drawPageFooter(obj, fromprint, printprops) {
  var h = 19;
  var top = obj.pagefooter.height;
  var os = 0;
  var cat = 0;
  var w = 135;
  var pffont = { name: "Helvetica", size: 15, weight: "normal" };
  var defUserLabel = "User";
  var defDateFormat = "YYYY-MM-DD";
  var defTimeFormat = "HH:MM:SS";

  if (printprops && printprops.userLanguage && printprops.userLanguage.toLowerCase() == "ita") {
    defUserLabel = "Utente";
    defDateFormat = "DD-MM-YYYY";
  }
  var pagew;
  if (!fromprint) {
    if (obj.page.orientation == "portrait")
      pagew = parseFloat(docSettings[obj.page.format].w); // in pt
    else
      pagew = parseFloat(docSettings[obj.page.format].h); // in pt
  }
  else {
    if (obj.page.orientation == "portrait")
      pagew = jsPDFPageFormats[obj.page.format.toLowerCase()][0];
    else
      pagew = jsPDFPageFormats[obj.page.format.toLowerCase()][1];
  }

  var tmpitem;
  tmpitem = {};

  var x = 0;
  if (fromprint) {
    var uname = defUserLabel + ": " + printprops.userName;
    tmpitem.uid = "uname_pf";
    tmpitem.type = "label";
    tmpitem.typeView = "text";
    tmpitem.value = uname;
    tmpitem.position = {};
    tmpitem.position.x = x;
    tmpitem.position.y = obj.pagefooter.height + top;
    tmpitem.position.yRelative = top;
    tmpitem.position.width = getOffsetWidth(uname, pffont) + 2; // bordi
    tmpitem.position.height = h;
    tmpitem.style = {};
    tmpitem.style.font = {};
    //tmpitem.style.font.center = true;
    tmpitem.style.font.fontName = "Helvetica";
    tmpitem.style.font.fontSize = "7pt";
    tmpitem.style.font.fontColor = "#000000";
    obj.pagefooter.items.push(tmpitem);
    x = (x + getOffsetWidth(uname, pffont) + 2 + 175);
  }

  tmpitem = {};
  tmpitem.uid = "curdate_pf"; //_rh
  tmpitem.type = "field";
  tmpitem.typeView = "datetime";
  tmpitem.fieldDetail = {};
  tmpitem.fieldDetail.alias = "";
  tmpitem.fieldDetail.desc = "Current datetime";
  tmpitem.fieldDetail.type = "T";
  tmpitem.fieldDetail.len = 14;
  tmpitem.picture = {};
  tmpitem.picture.dateformat = defDateFormat;
  tmpitem.picture.timeformat = defTimeFormat;
  tmpitem.isGeneric = true;
  tmpitem.position = {};
  tmpitem.position.x = x;
  tmpitem.position.y = obj.pagefooter.height + top;
  tmpitem.position.yRelative = top;
  tmpitem.position.width = w;
  tmpitem.position.height = h;
  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "7pt";
  tmpitem.style.font.fontColor = "#000000";
  obj.pagefooter.items.push(tmpitem);

  if (!fromprint) {
    x = ((pagew * ptTopx) - (convertStringToPx(obj.page.margins.left, pagew) + convertStringToPx(obj.page.margins.right, pagew))) / 2;
    x = x - (getOffsetWidth("CONTINUE", pffont) / 2);
    tmpitem = {};
    tmpitem.uid = "curcont_pf";
    tmpitem.type = "label";
    tmpitem.typeView = "text";
    tmpitem.value = "CONTINUE";
    tmpitem.isContinue = true;
    tmpitem.position = {};
    tmpitem.position.x = x;
    tmpitem.position.y = obj.pagefooter.height + top;
    tmpitem.position.yRelative = top;
    tmpitem.position.width = getOffsetWidth("CONTINUE", pffont) + 2; // bordi
    tmpitem.position.height = h;
    tmpitem.style = {};
    tmpitem.style.font = {};
    //tmpitem.style.font.center = true;
    tmpitem.style.font.fontName = "Helvetica";
    tmpitem.style.font.fontSize = "7pt";
    tmpitem.style.font.fontColor = "#000000";
    obj.pagefooter.items.push(tmpitem);
  }

  w = 2 * getOffsetWidth("999", pffont) + getOffsetWidth("/", pffont) + getOffsetWidth("Pag. ", pffont) + 18;
  os = (pagew * ptTopx) - (convertStringToPx(obj.page.margins.left, pagew) + convertStringToPx(obj.page.margins.right, pagew) + w + 2);
  w = getOffsetWidth("Pag. ", pffont);
  tmpitem = {};
  tmpitem.uid = "pagenum_lbl";
  tmpitem.type = "label";
  tmpitem.typeView = "text";
  tmpitem.value = "Pag. ";
  tmpitem.position = {};
  tmpitem.position.x = os;
  tmpitem.position.y = obj.pagefooter.height + top;
  tmpitem.position.yRelative = top;
  tmpitem.position.width = w;
  tmpitem.position.height = h;
  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.right = true;
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "7pt";
  tmpitem.style.font.fontColor = "#000000";
  obj.pagefooter.items.push(tmpitem);

  os += w;
  w = getOffsetWidth("999", pffont);
  tmpitem = {};
  tmpitem.uid = "pagenum_pf";
  tmpitem.type = "field";
  tmpitem.typeView = "pagenum";
  tmpitem.fieldDetail = {};
  tmpitem.fieldDetail.alias = "";
  tmpitem.fieldDetail.desc = "Page number";
  tmpitem.fieldDetail.type = "N";
  tmpitem.fieldDetail.len = 6;
  tmpitem.isGeneric = true;
  tmpitem.position = {};
  tmpitem.position.x = os;
  tmpitem.position.y = obj.pagefooter.height + top;
  tmpitem.position.yRelative = top;
  tmpitem.position.width = w;
  tmpitem.position.height = h;
  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.right = true;
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "7pt";
  tmpitem.style.font.fontColor = "#000000";
  obj.pagefooter.items.push(tmpitem);

  os += w + 6;
  w = getOffsetWidth("/", pffont);
  tmpitem = {};
  tmpitem.uid = "pagenumtot_lbl";
  tmpitem.type = "label";
  tmpitem.typeView = "text";
  tmpitem.value = "/";
  tmpitem.position = {};
  tmpitem.position.x = os;
  tmpitem.position.y = obj.pagefooter.height + top;
  tmpitem.position.yRelative = top;
  tmpitem.position.width = w;
  tmpitem.position.height = h;
  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.center = true;
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "7pt";
  tmpitem.style.font.fontColor = "#000000";
  obj.pagefooter.items.push(tmpitem);

  os += w + 6;
  w = getOffsetWidth("999", pffont);
  tmpitem = {};
  tmpitem.uid = "pagetot_pf";
  tmpitem.type = "field";
  tmpitem.typeView = "pagenum";
  tmpitem.fieldDetail = {};
  tmpitem.fieldDetail.alias = "";
  tmpitem.fieldDetail.desc = "Total pages";
  tmpitem.fieldDetail.type = "N";
  tmpitem.fieldDetail.len = 6;
  tmpitem.isGeneric = true;
  tmpitem.position = {};
  tmpitem.position.x = os;
  tmpitem.position.y = obj.pagefooter.height + top;
  tmpitem.position.yRelative = top;
  tmpitem.position.width = w;
  tmpitem.position.height = h;
  tmpitem.style = {};
  tmpitem.style.font = {};
  tmpitem.style.font.left = true;
  tmpitem.style.font.fontName = "Helvetica";
  tmpitem.style.font.fontSize = "7pt";
  tmpitem.style.font.fontColor = "#000000";
  obj.pagefooter.items.push(tmpitem);

  obj.pagefooter.height += (top + (h + cat + 2));
}

function drawMenuProperties(itemObj, props, ctrl) {
  var pID = "boxcontainer",
    elem,
    div = document.createElement("div");
  div.id = "repcustom_cont";
  Ctrl(pID).appendChild(div);
  elem = document.createElement("span");
  elem.className = "shadowtitlediv shadowtitledivnone";
  elem.textContent = "   ";
  div.appendChild(elem);
  elem = document.createElement("span");
  elem.className = "unselectable desctext";
  elem.textContent = getTranslated("SMR_RPTCUSTOM", "Set if report is custom");
  elem.style.paddingLeft = 3 + "px";
  elem.style.lineHeight = 29 + "px";
  div.appendChild(elem);
  drawSwitch(props[0], div.id, itemObj.repcustom, true);
  // report comment
  drawReportComment(itemObj, [props[1]], ctrl);
}

/* Disegno e gestione tipo allfields */
function drawAllFieldsDetail(itemObj) {
  $("shadowmenu").addClass("buttonContainer");
  var pID = "boxcontainer";
  $(pID).addClass("shadowHeight");

  var div, div2, elem, elem2;
  div = document.createElement("span");
  div.className = "shadowtitlediv shadowtitledivnone";
  div.textContent = " ";
  Ctrl(pID).appendChild(div);

  div2 = document.createElement("div");
  div2.id = "fldlistcont";
  div = document.createElement("ul");
  div.className = "fld_ul";
  div.style.cssFloat = "left";
  div.style.width = "100%";
  div2.appendChild(div);
  Ctrl(pID).appendChild(div2);

  for (var j = 0; j < _allFieldsHTML.length; j++) {
    var fld_item = _allFieldsHTML[j].field.fieldDet;
    elem = document.createElement("li");
    elem.id = j + "_" + fld_item.alias + "_space";
    elem2 = document.createElement("div");
    elem2.id = "fld_" + fld_item.alias + "_space";
    elem2.className = "unselectable fieldspace";
    elem.appendChild(elem2);
    /* tmp */ $(elem2).addClass("hiddenAdd");
    div.appendChild(elem);
    elem = document.createElement("li");
    elem.id = "fld_" + fld_item.alias;
    elem.className = "divFieldList";
    div.appendChild(elem);
    // drag icon
    elem2 = document.createElement("span");
    elem2.id = j + "_" + fld_item.alias + "_drag";
    elem2.className = "unselectable dragSpan usedField";
    elem.appendChild(elem2);
    /* tmp */ $(elem2).addClass("hiddenAdd");
    // list
    addFieldInEdit(j, _allFieldsHTML[j], elem, (itemObj.type == "field"));
    // edit icon
    elem2 = document.createElement("span");
    elem2.className = "unselectable iconFieldTypeEdit smartreport-icon-edit halfopacity";
    if ((itemObj.type == "field") &&
      ((_allFieldsHTML[j].field.typeView == "numeric" && _allFieldsHTML[j].field.zone.indexOf("footer") < 0) || fld_item.type == "L")
    )
      elem2.className += " disabledpicfields";
    elem2.setAttribute("edit-field", fld_item.alias);
    elem2.setAttribute("edit-index", j);
    elem2.setAttribute("edit-type", "edit");
    elem.appendChild(elem2);
    elem2.onclick = editItemField;
    elem2.onmouseover = function () {
      $(this).removeClass("halfopacity");
    }
    elem2.onmouseout = function () {
      $(this).addClass("halfopacity");
    }
    // style icon
    elem2 = document.createElement("span");
    elem2.className = "unselectable iconFieldTypeEdit smartreport-icon-font halfopacity";
    if ((itemObj.type == "field") &&
      (_allFieldsHTML[j].field.typeView == "image" || _allFieldsHTML[j].field.typeView == "barcode")
    )
      elem2.className += " disabledpicfields";
    elem2.setAttribute("edit-field", fld_item.alias);
    elem2.setAttribute("edit-index", j);
    elem2.setAttribute("edit-type", "style");
    elem.appendChild(elem2);
    elem2.onclick = editItemField;
    elem2.onmouseover = function () {
      $(this).removeClass("halfopacity");
    }
    elem2.onmouseout = function () {
      $(this).addClass("halfopacity");
    }

    Ctrl(j + "_" + fld_item.alias + "_drag").onmouseenter = drawShadowField;
    Ctrl(j + "_" + fld_item.alias + "_drag").onmousedown = dragShadowField;
    Ctrl("fld_" + fld_item.alias + "_space").setAttribute("data-attr", j);

    Ctrl("fld_" + fld_item.alias).setAttribute("data-attr", fld_item.alias);
  }
  elem = document.createElement("li");
  elem.id = _allFieldsHTML.length + "_last_space";
  elem2 = document.createElement("div");
  elem2.id = "fld_last_space";
  elem2.className = "unselectable fieldspace";
  elem.appendChild(elem2);
  div.appendChild(elem);
  Ctrl("fld_last_space").setAttribute("data-attr", _allFieldsHTML.length);

  if (Ctrl("fldlistcont").firstChild.children.length > 7) {
    $("shadowmenu").addClass("shadowWidth");
    $("fldlistcont").addClass("verticalOverflow");
  }

  div = document.createElement("div");
  div.id = "fldlistedit";
  div.className = "shadowHeightCont hiddenAdd";
  Ctrl(pID).appendChild(div);

  div = document.createElement("div");
  div.id = "fldliststyle";
  div.className = "shadowHeightCont hiddenAdd";
  Ctrl(pID).appendChild(div);

  div = document.createElement("div");
  div.id = "fldokcancel";
  // cancel
  elem = document.createElement("span");
  elem.className = "propInputBtn smartreport-icon-cancel hiddenAdd";
  elem.title = getTranslated("SMR_CANCEL", "Cancel");
  elem.setAttribute("data-attr", "cancel");
  elem.onclick = cancelEditField;
  div.appendChild(elem);
  // ok
  elem = document.createElement("span");
  elem.className = "propInputBtn smartreport-icon-confirm hiddenAdd";
  elem.title = getTranslated("SMR_APPLY", "Apply");
  elem.setAttribute("data-attr", "ok");
  elem.onclick = saveEditField;
  div.appendChild(elem);
  // ok all
  elem = document.createElement("span");
  elem.className = "propInputBtn smartreport-icon-okall hiddenAdd";
  elem.title = getTranslated("SMR_APPLYALL", "Apply to all");
  elem.setAttribute("data-attr", "okall");
  elem.onclick = saveEditField;
  div.appendChild(elem);
  Ctrl(pID).appendChild(div);

  Ctrl("canvas").onmousedown = beginDragSelection;
}

function addFieldInEdit(idx, obj, div, isField) {
  var lbl_obj = obj.label,
    fld_obj = obj.field,
    fld = fld_obj.fieldDet,
    elem, elem2;
  elem = document.createElement("div");
  elem.id = idx + "_" + fld.alias + "_fld";
  elem.className = "unselectable fieldObject fieldObjectList fieldObjectListEdit";
  elem2 = document.createElement("div");
  elem2.className = "unselectable fieldObjectInside fieldObjectInsideListEdit";
  elem2.innerHTML = ToStringHTML((isField ? fld.desc : lbl_obj.value));
  elem.appendChild(elem2);
  if (isField) {
    elem2 = document.createElement("span");
    elem2.className = "unselectable iconFieldType ";
    if (fld_obj.typeView == "numeric" && fld_obj.calculate != "none")
      elem2.className += "smartreport-icon-sigma";
    else if (fld_obj.typeView == "image")
      elem2.className += "smartreport-icon-image";
    else if (fld_obj.typeView == "barcode")
      elem2.className += "smartreport-icon-barcode";
    else {
      switch (fld.type) {
        case "C":
          elem2.className += "smartreport-icon-char";
          break;
        case "M":
          elem2.className += "smartreport-icon-memo";
          break;
        case "N":
          elem2.className += "smartreport-icon-num";
          break;
        case "D":
          elem2.className += "smartreport-icon-date";
          break;
        case "T":
          elem2.className += "smartreport-icon-time";
          break;
        case "L":
          elem2.className += "smartreport-icon-logic";
          break;
      }
    }
    elem2.style.cursor = "default";
    elem2.setAttribute("data-index", idx);
    elem.appendChild(elem2);
  }
  div.appendChild(elem);
  elem.onmouseover = function () {
    var alias = this.parentNode.getAttribute("data-attr"),
      icons = this.parentNode.querySelectorAll('span[edit-field="' + alias + '"]');
    $(icons[0]).removeClass("halfopacity");
    $(icons[1]).removeClass("halfopacity");
  }
  elem.onmouseout = function () {
    var alias = this.parentNode.getAttribute("data-attr"),
      icons = this.parentNode.querySelectorAll('span[edit-field="' + alias + '"]');
    $(icons[0]).addClass("halfopacity");
    $(icons[1]).addClass("halfopacity");
  }
}

function editItemField(e) {
  e = (e) ? e : window.event;
  var ctrl = GetEventSrcElement(e),
    findex = parseInt(ctrl.getAttribute("edit-index")),
    typeBtn = ctrl.getAttribute("edit-type"),
    contID = "";

  $("fldlistcont").addClass("hiddenAdd");
  $("fldliststyle").addClass("hiddenAdd");
  Ctrl("fldliststyle").innerHTML = "";
  $("fldlistedit").addClass("hiddenAdd");
  Ctrl("fldlistedit").innerHTML = "";
  var btns = Ctrl("boxcontainer").querySelectorAll('span.propInputBtn');
  for (var b = 0; b < btns.length; b++) {
    $(btns[b]).removeClass("hiddenAdd");
    btns[b].setAttribute("data-index", findex);
  }

  if (typeBtn == "style") {
    contID = "fldliststyle";
    $(Ctrl("boxcontainer").querySelectorAll('span.shadowtitlediv')[0]).addClass("hiddenAdd");
    if (index != null) {
      itemsHTML[index].ffamily = _allFieldsHTML[findex][itemsHTML[index].type].ffamily;
      itemsHTML[index].fsize = _allFieldsHTML[findex][itemsHTML[index].type].fsize;
      itemsHTML[index].fcolor = _allFieldsHTML[findex][itemsHTML[index].type].fcolor;
      itemsHTML[index].fbold = _allFieldsHTML[findex][itemsHTML[index].type].fbold;
      itemsHTML[index].fitalic = _allFieldsHTML[findex][itemsHTML[index].type].fitalic;
      itemsHTML[index].funderline = _allFieldsHTML[findex][itemsHTML[index].type].funderline;
      itemsHTML[index].fstrikeout = _allFieldsHTML[findex][itemsHTML[index].type].fstrikeout;
      itemsHTML[index].fleft = _allFieldsHTML[findex][itemsHTML[index].type].fleft;
      itemsHTML[index].fcenter = _allFieldsHTML[findex][itemsHTML[index].type].fcenter;
      itemsHTML[index].fright = _allFieldsHTML[findex][itemsHTML[index].type].fright;
    }
    drawItemStyle(ctrl, _allFieldsHTML[findex][itemsHTML[index].type], contID);
  }
  else {
    contID = "fldlistedit";
    drawEditField(_allFieldsHTML[findex][itemsHTML[index].type], contID);
  }

  $(contID).removeClass("hiddenAdd");
  Ctrl(contID).setAttribute("data-index", findex);

  Ctrl("canvas").onmousedown = beginDragSelection;
}

function drawEditField(itemObj, contID) {
  var title = "";
  if (itemObj.typeView.indexOf("date") >= 0)
    title = "Date time format";
  else if (itemObj.typeView == "numeric")
    title = "Calculation";
  else if (itemObj.type == "field") // field to image
    title = "Field view type";
  title = getTranslated("SMR_" + title, title);
  //SMR_NEWDATAFIELD //SMR_PAGENUMERATIONTYPE //SMR_DATETIMEFORMAT //SMR_CALCULATION //SMR_FIELDVIEWTYPE

  Ctrl("boxcontainer").querySelectorAll('span.shadowtitlediv')[0].textContent = title;

  if (itemObj.type != "field") {
    Ctrl("boxcontainer").querySelectorAll('span.shadowtitlediv')[0].textContent = " ";
    var elem = document.createElement("textarea");
    elem.className = "propInputDiv";
    elem.value = (itemObj.value || "");
    Ctrl("fldlistedit").appendChild(elem);
  }
  else if (itemObj.typeView.indexOf("date") >= 0)
    drawDateDetail(itemObj, itemObj.objClass.newProperties.date, contID);
  else if (itemObj.typeView == "numeric")
    drawNumericDetail(itemObj, itemObj.objClass.newProperties.num, contID);
  else // field to image
    drawFieldChange(itemObj, itemObj.objClass.newProperties.fConv, contID);
}

function saveEditField(e) {
  var btn_ok = GetEventSrcElement(e),
    f_index = parseInt(btn_ok.getAttribute("data-index")),
    o_typeView = _allFieldsHTML[f_index].field.typeView,
    itm_fld,
    elmType_icon,
    item;

  if (btn_ok.getAttribute("data-attr") == "okall") {
    for (var i = 0; i < _allFieldsHTML.length; i++) {
      itm_fld = _allFieldsHTML[i][itemsHTML[index].type];
      if (itemsHTML[index].type == "field")
        elmType_icon = Ctrl("fldlistcont").querySelectorAll('span.iconFieldType[data-index="' + i + '"]')[0];
      else
        elmType_icon = Ctrl(i + "_" + _allFieldsHTML[i].field.fieldDet.alias + "_fld")
          .querySelectorAll('div.fieldObjectInside')[0];
      savePropsInField(itm_fld, elmType_icon, o_typeView);
      item = m_CurrentObj[Strtran(itm_fld.zone, "content", "")].items
        .filter(function (ii) {
          return ((ii.uidfor == itm_fld.uidfor) &&
            (ii.ref_alias == _allFieldsHTML[i].field.fieldDet.alias));
        })[0];
      updateJsonItemAllFields(item, itemsHTML[index], itm_fld);
    }
  }
  else {
    itm_fld = _allFieldsHTML[f_index][itemsHTML[index].type];
    if (itemsHTML[index].type == "field")
      elmType_icon = Ctrl("fldlistcont").querySelectorAll('span.iconFieldType[data-index="' + f_index + '"]')[0];
    else
      elmType_icon = Ctrl(f_index + "_" + _allFieldsHTML[f_index].field.fieldDet.alias + "_fld")
        .querySelectorAll('div.fieldObjectInside')[0];
    savePropsInField(itm_fld, elmType_icon, itm_fld.typeView);
    item = m_CurrentObj[Strtran(itm_fld.zone, "content", "")].items
        .filter(function (ii) {
          return ((ii.uidfor == itm_fld.uidfor) &&
            (ii.ref_alias == _allFieldsHTML[f_index].field.fieldDet.alias));
        })[0];
    updateJsonItemAllFields(item, itemsHTML[index], itm_fld);
  }

  function savePropsInField(itm, elmType, org_typeView) {
    var isField = (itm.type == "field");
    if (isField && (itm.typeView != org_typeView))
      return;
    // edit
    if (!$("fldlistedit").hasClass("hiddenAdd")) {
      if (isField) {
        if (itm.typeView == "numeric") {
          itm.calculate = Ctrl("calculate").value;
          itm.calcbygrp = Ctrl("calcbygrp").checked;
          if (itm.calculate) {
            $(elmType).removeClass("smartreport-icon-num");
            $(elmType).addClass("smartreport-icon-sigma");
          }
          else {
            $(elmType).removeClass("smartreport-icon-sigma");
            $(elmType).addClass("smartreport-icon-num");
          }
        }
        else if (itm.typeView.indexOf("date") >= 0) { //date - datetime
          itm.dateformat = Ctrl("dateformat").value;
          itm.timeformat = Ctrl("timeformat").value;
        }
        else {
          var old_typeView = itm.typeView;
          itm.typeView = Ctrl("typeView").value;
          if (itm.typeView == "barcode") {
            itm.barcodetype = Ctrl("barcodetype").value;
            if (!Empty(Ctrl("fcoloroffcolorHEX").value))
              itm.fcoloroff = Ctrl("fcoloroffcolorHEX").value;
            else
              itm.fcoloroff = "#FFFFFF";

            if (!Empty(Ctrl("fcoloroncolorHEX").value))
              itm.fcoloron = Ctrl("fcoloroncolorHEX").value;
            else
              itm.fcoloron = "#000000";
          }

          if (old_typeView != itm.typeView) {
            $(elmType).removeClass("smartreport-icon-char");
            $(elmType).removeClass("smartreport-icon-barcode");
            $(elmType).removeClass("smartreport-icon-image");
            if (itm.typeView == "barcode")
              $(elmType).addClass("smartreport-icon-barcode");
            else if (itm.typeView == "image")
              $(elmType).addClass("smartreport-icon-image");
            else
              $(elmType).addClass("smartreport-icon-char");
          }
        }
      }
      else {
        var value = Ctrl("fldlistedit").querySelectorAll('textarea.propInputDiv')[0].value;
        itm.value = value;
        elmType.innerHTML = ToStringHTML(value);
      }

    }

    // style
    if (!$("fldliststyle").hasClass("hiddenAdd")) {
      itm.ffamily = Ctrl("ffamily").value;
      if (Ctrl("fsize").value.indexOf("px") < 0 && Ctrl("fsize").value.indexOf("pt") < 0)
        itm.fsize = Ctrl("fsize").value + "pt";
      else
        itm.fsize = Ctrl("fsize").value;
      itm.fcolor = Ctrl("fcolorcolorHEX").value;
      itm.fbold = itemsHTML[index].fbold;
      itm.fitalic = itemsHTML[index].fitalic;
      itm.funderline = itemsHTML[index].funderline;
      itm.fstrikeout = itemsHTML[index].fstrikeout;
      itm.fleft = itemsHTML[index].fleft;
      itm.fcenter = itemsHTML[index].fcenter;
      itm.fright = itemsHTML[index].fright;
    }
  }

  cancelEditField();
}

function cancelEditField() {
  Ctrl("boxcontainer").querySelectorAll('span.shadowtitlediv')[0].textContent = "";
  $(Ctrl("boxcontainer").querySelectorAll('span.shadowtitlediv')[0]).removeClass("hiddenAdd");
  $("fldlistcont").removeClass("hiddenAdd");
  $("fldliststyle").addClass("hiddenAdd");
  $("fldlistedit").addClass("hiddenAdd");
  var btns = Ctrl("boxcontainer").querySelectorAll('span.propInputBtn');
  for (var b = 0; b < btns.length; b++)
    $(btns[b]).addClass("hiddenAdd");
  Ctrl("canvas").onmousedown = beginDragSelection;
}
