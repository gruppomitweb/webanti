/*  exported newPropObj resizeWindow pdfLoading isSecureDoc infindex imgcountindex
    putalert setScroll convertFromPoints convertInPoints ZoomIn ZoomOut LoadPdf
    enableDocumentSelection reload_ resetTabs Undo Redo insertIntoUndoSequence setPropertiesID
    initPropertiesDefaultValue setToolbars
 */

/*  global workAreaWidth workAreaHeight w_init h_init itemsHTMLArray docpageindex
    imgHTML zoomindex isLoading pdfLoading resetGenericLight pdffile maxpages xxpos
    _original_onselectstart isSecureDoc writemenuTab removeAllImgHandlers addImgHandlers
    addImgHandlers infindex pasted imgcountindex Loadxml Loadvrp rgbToHex putItem putalert
    toolbars setArea searchProp
  */

var clCanvasLib = null;
var workunit = "mm";
var nAllItems = 0;
var tabs;
var newPropObj = null;
var newFormPropObj = null;

function resizeWindow(event, res) {
  var ctrl = Ctrl("backcanvas");
  if (ctrl == null) { return; }

  if (document.getSize().y - ctrl.offsetTop > 0) {
    ctrl.style.height = (document.getSize().y - ctrl.offsetTop) + "px";
  }
  if (Ctrl("toolbar") != null && ctrl.offsetHeight > 20) {
    ctrl.style.height = (ctrl.offsetHeight - 20) + "px"; //altezza toolbar
  }
  if (document.body.clientWidth - Ctrl('gadgets_pane').offsetWidth > 80) {
    ctrl.style.width = (document.body.clientWidth - ((Ctrl('gadgets_pane').opened ? (Ctrl('gadgets_pane').offsetWidth + Ctrl('gadgets_panerightbar').offsetWidth) : Ctrl('gadgets_panerightbar').offsetWidth) + 60) + 2) + "px"; //margine di 30 // 2 bordi
  }

  if (res == true) {
    w_init = parseInt(ctrl.style.width);
    h_init = parseInt(ctrl.style.height);
    initCanvas();
  }

  ctrl = Ctrl("h_ruler");
  if (ctrl) { ctrl.style.width = (getOffset(ctrl).w - 2) + "px"; }
  ctrl = Ctrl("v_ruler");
  if (ctrl) { ctrl.style.height = h_init + "px"; }

  document.getElementById('toolbar').setStyle('width',window.getSize().x - document.getElementById('gadgets_pane').getSize().x - document.getElementById('gadgets_panerightbar').getSize().x);
  document.getElementById('toolbar').fireEvent('SPToolbarRefresh');
  if (clCanvasLib == null) { return; }
  generateRulers();
}

/* *** Gestione del Canvas e delle scrollbars *** */
function initCanvas() {
  var h, w;
  Ctrl("canvaslinks").innerHTML = '';

  if (workAreaWidth > 0) {
    w = workAreaWidth;
    h = workAreaHeight;
  }
  else {
    w = w_init;
    h = h_init;
  }

  var propDiv = Ctrl('properties');
  if (propDiv) {
    propDiv.hide();
  }
  if (clCanvasLib == null) {
    clCanvasLib = CanvasLib.Init("canvaslinks", w * CanvasLib.scale / 100, h * CanvasLib.scale / 100);
  }
  else {
    clCanvasLib = CanvasLib.Init("canvaslinks", w * clCanvasLib.scale / 100, h * clCanvasLib.scale / 100);
  }
  checkMargins();
}

function checkMargins() {
  itemsHTML = itemsHTMLArray[docpageindex];
  drawImage();
}

function drawImage() {
  if (clCanvasLib.container != null) {
    clCanvasLib.container.innerHTML = "";
  }
  if (workAreaWidth > 0) {
    var w = workAreaWidth * clCanvasLib.scale / 100;
    var h = workAreaHeight * clCanvasLib.scale / 100;

    setCanvasScroll();

    if (docpageindex >= 0 && imgHTML[docpageindex] != null) {
      var img = clCanvasLib.DrawRectImage(imgHTML[docpageindex].src, 0, 0, w, h, imgHTML[docpageindex].rotation);
      imgHTML[docpageindex].h = img.height * 100 / 100;
      imgHTML[docpageindex].w = img.width * 100 / 100;
    }
  }
  else {
    setCanvasScroll();
  }
}

function setCanvasScroll() {
  var w_canvaslinks = parseInt(Ctrl("canvaslinks").style.width);
  var h_canvaslinks = parseInt(Ctrl("canvaslinks").style.height);
  var w_backcanvas = parseInt(Ctrl("backcanvas").style.width);
  var h_backcanvas = parseInt(Ctrl("backcanvas").style.height);
  if (w_canvaslinks > w_backcanvas || h_canvaslinks > h_backcanvas) {
    if (w_canvaslinks > w_backcanvas) {
      Ctrl("backcanvas").style.overflowX = 'auto';
    }
    else {
      Ctrl("canvas").scrollLeft = 0;
      Ctrl("backcanvas").style.overflowX = 'hidden';
    }
    if (h_canvaslinks > h_backcanvas) {
      Ctrl("backcanvas").style.overflowY = 'auto';
    }
    else {
      Ctrl("canvas").scrollTop = 0;
      Ctrl("backcanvas").style.overflowY = 'hidden';
    }
  }
  else {
    Ctrl("canvas").scrollLeft = 0;
    Ctrl("canvas").scrollTop = 0;
    Ctrl("backcanvas").style.overflow = 'hidden';
  }
}

function resetscroll(val) {
  if (val <= 100) {
    Ctrl("canvas").scrollLeft = 0;
    Ctrl("canvas").scrollTop = 0;
  }
}

function setScroll(/*e, elem*/) {
  if (Ctrl("h_ruler")) {
    Ctrl("h_ruler").scrollLeft = Ctrl("canvas").scrollLeft;
  }
  if (Ctrl("v_ruler")) {
    Ctrl("v_ruler").scrollTop = Ctrl("canvas").scrollTop;
  }
}
/* *** Fine della gestione del Canvas e delle scrollbars *** */


/* *** Gestione dei righelli *** */
function generateRulers() {
  var ctrl = Ctrl("backcanvas");
  var ctrlz = Ctrl("h_ruler");
  if (ctrlz) { ctrlz.style.width = getOffset(ctrl).w + "px"; }
  ctrlz = Ctrl("v_ruler");
  if (ctrlz) { ctrlz.style.height = getOffset(ctrl).h + "px"; }

  var t = parseInt(ctrl.style.top) + 20;
  ctrlz = Ctrl("z_line");
  if (ctrlz) { ctrlz.style.height = (t + getOffset(ctrl).h) + "px"; }
  ctrlz = Ctrl("v_line1");
  if (ctrlz) { ctrlz.style.height = (t + getOffset(ctrl).h) + "px"; }
  ctrlz = Ctrl("v_line2");
  if (ctrlz) { ctrlz.style.height = (t + getOffset(ctrl).h) + "px"; }

  generateRulerCanvasV("v_rulerc", getOffset(Ctrl("v_ruler")).h, workunit);
  generateRulerCanvasH("h_rulerc", getOffset(Ctrl("h_ruler")).w, workunit);
}

function generateRulerCanvasV(div, len, workunit) {
  if (clVRRulersLib == null) {
    clVRRulersLib = new RulersLib();
  }
  clVRRulersLib.Init(div, workunit); // div-canvas del righello
  clVRRulersLib.SetScale(clCanvasLib.scale); //eventuale zoom
  clVRRulersLib.DrawVertical(len);
}

function generateRulerCanvasH(div, len, workunit) {
  if (clHRRulersLib == null) {
    clHRRulersLib = new RulersLib();
  }
  clHRRulersLib.Init(div, workunit); // div-canvas del righello
  clHRRulersLib.SetScale(clCanvasLib.scale); //eventuale zoom
  clHRRulersLib.DrawHorizontal(len);
}

function updateRulers(str) {
  workunit = str;
  formProp.rulers = str;
  generateRulers();
  if (!isLoading) { FormProperties(true); }
}

function convertInPoints(ab) {
  if (workunit == "mm") { return ab * 2.834; }
  else if (workunit == "cm") { return ab * 28.34; }
  else if (workunit == "pc") { return ab * 12; }
  else if (workunit == "inch") { return ab * 72; }
  else { return ab; }
}

function convertFromPoints(ab) {
  if (workunit == "mm") { return ab / 2.834; }
  else if (workunit == "cm") { return ab / 28.34; }
  else if (workunit == "pc") { return ab / 12; }
  else if (workunit == "inch") { return ab / 72; }
  else { return ab; }
}
/* *** Fine della gestione dei righelli *** */

/* *** Gestione dello Zoom *** */

//function zoom
function ZoomIn() {
  Ctrl('loading').setStyle('opacity', 0.7).innerHTML = "zooming in page...";
  zoomGetNextValue("zoombox");
  var zz = GetZoomValue();
  if (zz > 0) {
    resetscroll(parseInt(zz));
  }
  var fz = function () {
    var z = GetZoomValue();
    if (z > 0) {
      zoom(parseInt(z));
    }
    Ctrl('loading').fade(0);
  }
  fz.delay(100);
}

function ZoomOut() {
  Ctrl('loading').setStyle('opacity', 0.7).innerHTML = "zooming in page...";
  zoomGetPrevValue("zoombox");
  var zz = GetZoomValue();
  if (zz > 0) {
    resetscroll(parseInt(zz));
  }
  var fz = function () {
    var z = GetZoomValue();
    if (z > 0) {
      zoom(parseInt(z));
    }
    Ctrl('loading').fade(0);
  }
  fz.delay(100);
}

function zoom(val) {
  if (clCanvasLib.container != null) {
    clCanvasLib.zoom(val);
    selectedZoombox("zoombox");
    updatezFormProps();
    initCanvas();
	  //InsertIcePdf("false", 0, 0);
    generateRulers();
    writeHTML();
  }
}

function selectedZoombox(zoomboxid) {
  var zoombox = document.getElementById(zoomboxid);
  if (zoombox != null) {
    for (var i = 0; i < zoombox.options.length; i++) {
      if (zoombox.options[i].value == clCanvasLib.scale) {
        zoombox.options[i].selected = true;
        zoomindex = zoombox.selectedIndex;
        i = zoombox.options.length;
      }
    }
}
}

function GetZoomValue() {
  var zoombox = document.getElementById("zoombox");
  if (zoombox != null) {
    return zoombox.options[zoomindex].value;
  }
  return -1;
}

function zoomGetNextValue(zoomboxid) {
  var zoombox = document.getElementById(zoomboxid);
  if (zoombox != null) {
    if ((zoomindex + 1) < zoombox.options.length) {
      zoomindex++;
    }
  }
}

function zoomGetPrevValue(zoomboxid) {
  var zoombox = document.getElementById(zoomboxid);
  if (zoombox != null) {
    if ((zoomindex - 1) >= 0) {
      zoomindex--;
    }
  }
}

function setzoom() {
  var ctrl = Ctrl("backcanvas");
  if (workAreaWidth > 0) {
    var c = (ctrl.offsetWidth / workAreaWidth) * 100;
    var c2 = (ctrl.offsetHeight / workAreaHeight) * 100;
    if (c2 > c) {
      c = c2;
    }
    if (c > 100 && c <= 400) { //min e max zoom
      var cz = Round(c / 25, 0);
      zoom(cz * 25);
    }
  }
}

function updatezFormProps() {
  resizezElements();
}

function resizezElements() {
  var itm, ctrl, i, j;
  removeAllHandlers();
  for (j = 0; j < countindex.length; j++) {
    for (i = 0; i < itemsHTMLArray[j].length; i++) {
      itm = itemsHTMLArray[j][i];
      ctrl = null;
      itm.w = (itm.w * 100 / itm.scale) * (clCanvasLib.scale / 100);
      itm.h = (itm.h * 100 / itm.scale) * (clCanvasLib.scale / 100);
      itm.x = (itm.x * 100 / itm.scale) * (clCanvasLib.scale / 100);
      itm.y = (itm.y * 100 / itm.scale) * (clCanvasLib.scale / 100);
      itm.scale = clCanvasLib.scale;
      ctrl = Ctrl(itm.id);
      if (ctrl != null) {
        ctrl.style.display = "block";
        ctrl.style.left = itm.x + "px";
        ctrl.style.top = itm.y + "px";
        ctrl.style.width = itm.w + "px";
        ctrl.style.height = itm.h + "px";
      }
    }
  }
}
/* *** Fine della gestione dello Zoom *** */

/* *** Gestione del caricamento del pdf *** */
function LoadPdf(/*prop*/) {
  var xpos = 0;
  var ypos = 0;
  pdfLoading = true;
  OpenWindow("../portalstudio/openfile.jsp?tool=pdf&toolenable=false", 620, 600, xpos, ypos, "Modules");
}

function LoadPdfz(url, imgnew, zdwidth/*, zdheight*/) {
  url = unescape(url);
  url = url.replace(/[\\]/gi, '/');
  url = url.replace('//', '/');
  resetGenericLight();
  pdfLoading = false;
  setFile(url);
  formProp.file = pdffile;
  removeAllHandlers();
  InsertIcePdf(imgnew, 0, 0);
  if (!isLoading) { FormProperties(true); }
  if (typeof(zdwidth) != "undefined") {
  }
  else {
    setzoom();
  }
}

function setFile(file) {
  pdffile = file;
  var pdfProperties;
  var url = new JSURL("../servlet/IcePdfNumberOfPages?file=" + file, true);
  maxpages = -1;
  workAreaWidth = -1;
  workAreaHeight = -1;
  try {
    pdfProperties = JSON.parse(url.Response());
  }
  catch (e) {
    PSAlert.alert("Error on loading pdf file '" + file + "'");
  }
  if (!pdfProperties.error) {
    maxpages = parseInt(pdfProperties.numPages);
    workAreaWidth = parseInt(pdfProperties.pageWidth);
    workAreaHeight = parseInt(pdfProperties.pageHeight);
    isSecureDoc = parseInt(pdfProperties.hasSecurity);
    if (maxpages <= 0) {
      PSAlert.alert("Error on loading pdf file '" + file + "'");
      return;
    }
    formProp.width = workAreaWidth;
    formProp.height = workAreaHeight;
  }
  else {
    PSAlert.alert("Error on loading pdf file '" + file + "'");
  }
}

function InsertIcePdf(imgnew, w, h) {
  var output, src, urlx;
  var myurl;
  var wscale = 102;
  for (var currentPage = 1; currentPage <= maxpages; currentPage++) {
    myurl = "../servlet/IcePdfRenderer?file=" + pdffile + "&page=" + currentPage + "&scale=" + wscale + "&maxpages=" + maxpages;
	if(currentPage > 1) {
      myurl = myurl + "&withreturn=true";
    }
    urlx = new JSURL(myurl, true);
    output = urlx.Response();
    if (output != "Error") {
      if (wscale > 601) {
        src = output + "_" + "7" + "_" + currentPage + ".png";
      }
      else if (wscale > 301) {
        src = output + "_" + "5" + "_" + currentPage + ".png";
      }
      else if (wscale > 101) {
        src = output + "_" + "3" + "_" + currentPage + ".png";
      }
      else {
        src = output + "_" + currentPage + ".png";
      }
      InsertImageDone(src, imgnew, currentPage-1);
    }
    else {
      PSAlert.alert("Error on loading document '" + pdffile + "'");
    }
  }

  if (itemsHTMLArray.length > maxpages && maxpages > 0) {
    for (var i = maxpages; i < itemsHTMLArray.length; i++) {
      for (var j = 0; j < itemsHTMLArray[i].length; j++) {
        itemsHTMLArray[i][j].page = maxpages - 1;
        itemsHTMLArray[maxpages - 1][itemsHTMLArray[maxpages - 1].length] = itemsHTMLArray[i][j];
        countindex[maxpages - 1]++;
      }
    }
    itemsHTMLArray.splice(maxpages);
    countindex.splice(maxpages);
  }

  if(imgnew == 'true') writemenuTab();
  docpageindex = 0;
  itemsHTML = itemsHTMLArray[docpageindex];
  if (w > 0 && h > 0) {
    w_init = w;
    h_init = h;
  }

  var tmp = [];
  for (var z = 0; z < maxpages; z++) {
    tmp[z] = countindex[z];
  }

  countindex = tmp;
  writeHTML(true);
}

function InsertImageDone(localsrc, imgnew, index/*, withselect*/) {
  if (localsrc != null) {
    if (imgnew == "true") {
      var xpos = xxpos;
      var htmlObj = '<img id=\'item' + nitem + '\' src=\'file://' + Strtran(localsrc, "\\", "/") + '\' style=\'z-index:1;position:absolute;top:' + ((index + 1) * 30 + index * 40) + 'px;left:' + xpos + 'px;width:' + (90) + 'px;height:' + (60) + 'px\' onclick="cancelEvent(event);clickItem(event,\'item' + nitem + '\')" title=\'\' alt=\'Image not found\'>';
      imgHTML[index] = new ZTObjects.imgObj('item' + nitem, 'DocPage' + nitem, 'DocPage', htmlObj, '', '', 1, xpos, ((index + 1) * 30 + index * 40));
      if (itemsHTMLArray[index] == null) {
        itemsHTMLArray[index] = [];
        countindex[index] = 0;
      }
      nitem++;
      nAllItems++;
      //imgcountindex++;
      imgHTML[index].src = localsrc;
    }
    else {
      imgHTML[index].src = localsrc;
    }
    if (index == 0) {
      docpageindex = -1;
      selectImg(0);
    }
  }
  document.body.onfocus = null;
}

function selectImg(pos/*, resize*/) {
  if (pos < 0) {
    pos = 0;
  }
  if (pos >= itemsHTMLArray.length) {
    pos = 0;
  }
  if (docpageindex != pos) {
    docpageindex = pos;
    formProp.page = docpageindex;
    itemsHTML = itemsHTMLArray[docpageindex];
    removeAllHandlers();
    if (imgHTML.length > 0) {
      imgHTML[pos].shadow = "shadow" + imgHTML[pos].id.substr(4);
      removeAllImgHandlers();
      var str = addImgHandlers(imgHTML[pos].id.substr(4));
      Ctrl("toolbarimghandlers").innerHTML = Ctrl("toolbarimghandlers").innerHTML + str;
      selectItemImg(Ctrl("shadow" + imgHTML[pos].id.substr(4)));
    }
    else if (typeof(itemsHTMLArray[docpageindex]) != "undefined") {
      itemsHTML = itemsHTMLArray[docpageindex];
    }
    else {
      docpageindex = 0;
      formProp.page = docpageindex;
      itemsHTML = itemsHTMLArray[docpageindex];
      if (itemsHTMLArray == null) {
        itemsHTMLArray[docpageindex] = [];
      }
      itemsHTML = itemsHTMLArray[docpageindex];
    }
    index = null;
    initCanvas(); //ok
    writeHTML();
  }

  if (imgHTML.length > 0) {
    infindex = docpageindex;
  }

  if(window.adjustTabHeight) {
    window.adjustTabHeight();
}
}
/* *** Fine della gestione del caricamento del PDF *** */

/* *** Gestione della selezione di un item *** */
function selectItemImg(itm) {
  mainitem = itm;
}

function enableDocumentSelection(enable) {
  if (enable) {
    document.onselectstart = _original_onselectstart;
  }
  else {
    document.onselectstart = function () {
      return false;
    }
  }
}
/* *** Fine della gestione della selezione di un item *** */

/* *** reload *** */
function reload_(e, strreload, paste, mpdfsrc) {
  pasted = [];
  if (!paste) {
    index = null;
    infindex = null;
    nitem = 0; // numero item crescente
    itemsHTML = []; //array contenente tutti gli oggetti item con id,HTML,shadow,ecc
    imgHTML = [];
    countindex = []; //contatore indice array
    imgcountindex = 0;
    docpageindex = 0;
    formProp.page = docpageindex;
    itemsHTMLArray[docpageindex] = [];
    countindex[docpageindex] = 0;
    clCanvasLib.scale = 100;
    zoomindex = 2;
    workAreaHeight = 0;
    workAreaWidth = 0;
  }
  Ctrl("canvasitems").innerHTML = "";

  if (LRTrim(strreload) != "") {
    if (!(Left(strreload, 6) == "type||")) { // Def in formato JSON
      var JSONDef = JSON.parse(strreload);
      var JSONItem, JSONItems;

      /* action serve per sapere quale operazione sta causando la reload_.
         E' stata inserita per ottimizzare il codice:
         * al momento dell'incolla di un elemento tagliato,
      */
      var action = "";
      if (paste) {
        action = JSONDef["action"];
        JSONItems = JSONDef["elements"];
      }
      else {
        JSONItems = JSONDef;
      }
      var propName, valueToLoad;

      for (i = 0; i < JSONItems.length; i++) {
        JSONItem = JSONItems[i];
        type = JSONItem["type"];
        var b_reload = false;
        for (propName in JSONItem) {
          b_reload = true;
          valueToLoad = (typeof(JSONItem[propName]) == "string"? Trim(JSONItem[propName]) : JSONItem[propName]);
          valueToLoad = (typeof(JSONItem[propName]) == "string"? Strtran(valueToLoad, '##x2d;##x2d;', "--") : valueToLoad);

          if (valueToLoad == "undefined") {
            valueToLoad = " ";
          }
          switch (type) {
            // proprieta' generiche del form
            case 'scandoc':
            case 'module':
              switch (propName) {
                case 'type':
                  valueToLoad = tool;
                  break;
                case 'width':
                  if (formProp["width"] > 0) {
                    w_init = valueToLoad;
                  }
                  break;
                case 'height':
                  if (formProp["height"] > 0) {
                    h_init = valueToLoad;
                  }
                  break;
                case 'rulers':
                  updateRulers(valueToLoad);
                  break;
                case 'fldfile':
                  if (valueToLoad.indexOf(".vrp") > 0) {
                    Loadvrp(valueToLoad);
                  }
                  else if (valueToLoad.length > 0) {
                    Loadxml(valueToLoad);
                  }
                  break;
                case 'file':
                  if (!Empty(mpdfsrc)) { valueToLoad = mpdfsrc; }
                  if ((valueToLoad).toLowerCase().indexOf(".pdf") > 0) {
                    LoadPdfz(valueToLoad, 'true', w_init, h_init);
                  }
                  else {
                    initCanvas();
                  }
                  break;
                case 'hls':
                case 'lock_items':
                  if (LRTrim(valueToLoad) == "") {
                    valueToLoad = false;
                  }
                  break;
                case 'color':
                  if (formProp["version"] < "1.1") {
                    if (valueToLoad != "") {
                      valueToLoad = rgbToHex(valueToLoad);
                    }
                  }
                  break;
              }
              formProp[propName] = valueToLoad;
              break;

            case 'Zone':
            case 'Area':
            case 'Omr':
            case 'SignMark':
              switch (propName) {
                case 'page':
                  if (!paste) {
                    docpageindex = valueToLoad;
                    formProp.page = docpageindex;
                    if (typeof(itemsHTMLArray[docpageindex]) == "undefined") {
                      itemsHTMLArray[docpageindex] = [];
                      countindex[docpageindex] = 0;
                    }
                    itemsHTML = itemsHTMLArray[docpageindex];
                    putItem(e, b_reload);
                  }
                  else {
                    putalert = false;
                    putItem(null, true);
                    pasted.push(countindex[docpageindex] - 1);
                    putalert = true;
                  }
                  break;
                case 'name':
                  if (paste) {
                    for (var bb = 0; bb < itemsHTML.length; bb++) {
                      if (itemsHTML[bb].name == valueToLoad) {
                        valueToLoad += "nc"+ nAllItems; //non usare _ in quanto è un marcatore per i gruppi
                      }
                    }
                  }
                  break;
                case 'x':
                  if (paste) {
                    valueToLoad = (valueToLoad - 0) + 10;
                    valueToLoad = valueToLoad * clCanvasLib.scale / 100;
                  }
                  else {
                    if (w_init > 0 && workAreaWidth > 0) {
                      valueToLoad = valueToLoad * workAreaWidth / w_init;
                    }
                  }
                  break;
                case 'y':
                  if (paste) {
                    valueToLoad = (valueToLoad - 0) + 10;
                    valueToLoad = valueToLoad * clCanvasLib.scale / 100;
                  }
                  else {
                    if (h_init > 0 && workAreaHeight > 0) {
                      valueToLoad = valueToLoad * workAreaHeight / h_init;
                    }
                  }
                  break;
                case 'h':
                  if (paste) {
                    valueToLoad = (valueToLoad - 0) * clCanvasLib.scale / 100;
                  }
                  else {
                    if (h_init > 0 && workAreaHeight > 0) {
                      valueToLoad = valueToLoad * workAreaHeight / h_init;
                    }
                  }
                  break;
                case 'w':
                  if (paste) {
                    valueToLoad = (valueToLoad - 0) * clCanvasLib.scale / 100;
                  }
                  else {
                    if (w_init > 0 && workAreaWidth > 0) {
                      valueToLoad = valueToLoad * workAreaWidth / w_init;
                    }
                  }
                  break;
                case 'color':
                  if (formProp["version"] < "1.1") {
                    if (valueToLoad != "") {
                      valueToLoad = rgbToHex(valueToLoad);
                    }
                  }
                  break;
                case 'detail':
                  if (valueToLoad == "0") {
                    valueToLoad = "false";
                  }
                  break;
                case 'hreplicated':
                  if (valueToLoad.toString() == "true") {
                    itemsHTML[countindex[docpageindex] - 1]["fieldsstructure"] = "horizontal";
                  }
                  break;
				case "font":
				  if( valueToLoad.indexOf('fonts/DejaVu') == 0 && valueToLoad!='fonts/DejaVuSans-ExtraLight.ttf' ) {
					  itemsHTML[countindex[docpageindex] - 1]['fontOverwrite'] = true;
					  valueToLoad = valueToLoad.substring('fonts/'.length);
					  valueToLoad = valueToLoad.substring(0, valueToLoad.indexOf('.ttf'));
					  var vs = valueToLoad.split('-');
					  var fcssL = vs[0].split(/(?=[A-Z])/);
					  var fcss='';
					  fcss = fcssL[0]+fcssL[1];//DejaVu
					  for(var k=2; k<fcssL.length; k++) {
						  fcss += ' ' + fcssL[k]
					  }
					  itemsHTML[countindex[docpageindex] - 1][propName] = fcss + ', sans-serif';
					  if (vs[1]) {
						var font_weight = '';
						if(vs[1].toLowerCase().indexOf('bold') >= 0) {
							font_weight = 'bold';
						}
						if(vs[1].toLowerCase().indexOf('italic')>=0 || vs[1].toLowerCase().indexOf('oblique')>=0) {
							font_weight += ' italic';
						}
						font_weight = font_weight.trim();
						if (font_weight.length > 0) {
						  itemsHTML[countindex[docpageindex] - 1]['weight'] = font_weight;
						  itemsHTML[countindex[docpageindex] - 1]['styleOverwrite'] = true;
						}
					  }
				  }
				  else {
					itemsHTML[countindex[docpageindex] - 1][propName] = valueToLoad;
				  }
				break;
				case "style":
        case "weight":
                  if ( itemsHTML[countindex[docpageindex] - 1]['styleOverwrite'] ) {
					  break;
                  }
          var font = itemsHTML[countindex[docpageindex] - 1]['font'];
          propName = 'weight';
				  if( font.indexOf('fonts/DejaVu') == 0 && font!='fonts/DejaVuSans-ExtraLight.ttf' ) {
					  var font_weightz = valueToLoad;
					  valueToLoad = font;
					  valueToLoad = valueToLoad.substring('fonts/'.length);
					  valueToLoad = valueToLoad.substring(0, valueToLoad.indexOf('.ttf'));
					  var vsz = valueToLoad.split('-');
					  var fcssLz = vsz[0].split(/(?=[A-Z])/);
					  var fcssz='';
					  fcssz = fcssLz[0]+fcssLz[1];//DejaVu
					  for(var zk=2; zk<fcssLz.length; zk++) {
						  fcssz += ' ' + fcssLz[zk]
					  }
					  itemsHTML[countindex[docpageindex] - 1]['font'] = fcssz + ', sans-serif'; 
					  itemsHTML[countindex[docpageindex] - 1]['fontOverwrite'] = true;
					  if (vsz[1]) {
                        font_weightz = '';
                        if(vsz[1].toLowerCase().indexOf('bold') >= 0) {
                          font_weightz = 'bold';
                        }
                        if(vsz[1].toLowerCase().indexOf('italic')>=0 || vsz[1].toLowerCase().indexOf('oblique')>=0) {
                          font_weightz += ' italic';
                        }
                        font_weightz = font_weightz.trim();
                        if (font_weightz.length > 0) {
                          itemsHTML[countindex[docpageindex] - 1][propName] = font_weightz;
                          itemsHTML[countindex[docpageindex] - 1]['styleOverwrite'] = true;
                        }
					  }
					  else {
						  itemsHTML[countindex[docpageindex] - 1][propName] = font_weightz;
					  }
				  }
				  else {
					  itemsHTML[countindex[docpageindex] - 1][propName] = valueToLoad;
				  }
				break;
              }
              if (propName != "type") {
                var set = true;
                if ( (propName == 'style' || propName == 'weight') && itemsHTML[countindex[docpageindex] - 1]['styleOverwrite']) {
                  set = false;
                }
                else if ( propName == 'font' && itemsHTML[countindex[docpageindex] - 1]['fontOverwrite']) {
                  set = false;
                }
                if (propName == 'barcode' && (valueToLoad == 'QRCode' || valueToLoad == 'PDF417')) {
                  itemsHTML[countindex[docpageindex] - 1]["type_exp"] = "barcode2d";
                  itemsHTML[countindex[docpageindex] - 1]["barcode2d"] = valueToLoad;
                  set = false;
                }
                if (set) {
                  itemsHTML[countindex[docpageindex] - 1][propName] = valueToLoad;
              }
              }
              break;
            case 'DocPage':
              break;
          }
        }
        if (tool == "module" && formProp.version < "1.3" && type == 'Zone') {
          if ((typeof(itemsHTML[countindex[docpageindex] - 1]["barcode"]) == "undefined" || itemsHTML[countindex[docpageindex] - 1]["barcode"] == "") && itemsHTML[countindex[docpageindex] - 1]["type_exp"] == "barcode") {
            itemsHTML[countindex[docpageindex] - 1]["barcode"] = "QRCode";
          }
        }
        if (tool == "module" && type == 'Zone') {
          if (itemsHTML[countindex[docpageindex] - 1]["type_exp"] != "text") {
            itemsHTML[countindex[docpageindex] - 1]["datatype"] = "none";
          }
        }
      }
    }
    else { // Def in formato |||
      var itemsDef, itemProperties;
      if (strreload.substring(0, 4) == "type") {
        // I moduli precedeti la Build 60 non hanno una versione. Quindi viene assegnata loro la versione 0.0
        if (Empty(action) && At("||version||", strreload) < 1) { formProp["version"] = "0.0"; }

        itemsDef = strreload.split("|||");
        for (var i = 0; i < itemsDef.length - 1; i++) {
          itemProperties = itemsDef[i].split("||");
          type = itemProperties[1];
          b_reload = true;

          if (type != "Zone" && type != "scandoc" && type != "DocPage" && type != "Area" && type != "Omr" && type != "module") {
            putItem(e, b_reload);
          }
          for (var b = 0; b < itemProperties.length; b++) {
            valueToLoad = Trim(itemProperties[b + 1]);
            propName = itemProperties[b];

            if (valueToLoad == "undefined") {
              valueToLoad = " ";
            }
            switch (type) {
              // proprieta' generiche del form
              case 'scandoc':
              case 'module':
                switch (propName) {
                  case 'type':
                    valueToLoad = tool;
                    break;
                  case 'width':
                    if (formProp["width"] > 0) {
                      w_init = valueToLoad;
                    }
                    break;
                  case 'height':
                    if (formProp["height"] > 0) {
                      h_init = valueToLoad;
                    }
                    break;
                  case 'rulers':
                    updateRulers(valueToLoad);
                    break;
                  case 'fldfile':
                    if (valueToLoad.indexOf(".vrp") > 0) {
                      Loadvrp(valueToLoad);
                    }
                    else if (valueToLoad.length > 0) {
                      Loadxml(valueToLoad);
                    }
                    break;
                  case 'file':
                    if (!Empty(mpdfsrc)) { valueToLoad = mpdfsrc; }
                    if (valueToLoad.indexOf(".pdf") > 0) {
                      LoadPdfz(valueToLoad, 'true', w_init, h_init);
                    }
                    else {
                      initCanvas();
                    }
                    break;
                  case 'hls':
                  case 'lock_items':
                    if (LRTrim(valueToLoad) == "") {
                      valueToLoad = false;
                    }
                    break;
                  case 'color':
                    if (formProp["version"] < "1.1") {
                      if (Trim(valueToLoad) != "") {
                        valueToLoad = rgbToHex(valueToLoad);
                      }
                    }
                    break;
                }
                formProp[propName] = valueToLoad;
                break;

              case 'Zone':
              case 'Area':
              case 'Omr':
              case 'SignMark':
                switch (propName) {
                  case 'page':
                    if (!paste) {
                      docpageindex = valueToLoad;
                      formProp.page = docpageindex;
                      if (typeof(itemsHTMLArray[docpageindex]) == "undefined") {
                        itemsHTMLArray[docpageindex] = [];
                        countindex[docpageindex] = 0;
                      }
                      itemsHTML = itemsHTMLArray[docpageindex];
                      putItem(e, b_reload);
                    }
                    else {
                      putalert = false;
                      putItem(null, true);
                      pasted.push(countindex[docpageindex] - 1);
                      putalert = true;
                    }
                    break;
                  case 'name':
                    if (paste) {
                      for (bb = 0; bb < itemsHTML.length; bb++) {
                        if (itemsHTML[bb].name == valueToLoad) {
                          valueToLoad += "_" + nAllItems;
                        }
                      }
                    }
                    break;
                  case 'x':
                    if (paste) {
                      valueToLoad = (valueToLoad - 0) + 10;
                      valueToLoad = valueToLoad * clCanvasLib.scale / 100;
                    }
                    else {
                      if (w_init > 0 && workAreaWidth > 0) {
                        valueToLoad = valueToLoad * workAreaWidth / w_init;
                      }
                    }
                    break;
                  case 'y':
                    if (paste) {
                      valueToLoad = (valueToLoad - 0) + 10;
                      valueToLoad = valueToLoad * clCanvasLib.scale / 100;
                    }
                    else {
                      if (h_init > 0 && workAreaHeight > 0) {
                        valueToLoad = valueToLoad * workAreaHeight / h_init;
                      }
                    }
                    break;
                  case 'h':
                    if (paste) {
                      valueToLoad = (valueToLoad - 0) * clCanvasLib.scale / 100;
                    }
                    else {
                      if (h_init > 0 && workAreaHeight > 0) {
                        valueToLoad = valueToLoad * workAreaHeight / h_init;
                      }
                    }
                    break;
                  case 'w':
                    if (paste) {
                      valueToLoad = (valueToLoad - 0) * clCanvasLib.scale / 100;
                    }
                    else {
                      if (formProp["width"] > 0 && workAreaWidth > 0) {
                        valueToLoad = valueToLoad * workAreaWidth / formProp["width"];
                      }
                    }
                    break;
                  case 'color':
                    if (formProp["version"] < "1.1") {
                      if (Trim(valueToLoad) != "") {
                        valueToLoad = rgbToHex(valueToLoad);
                      }
                    }
                    break;
                  case 'detail':
                    if (Trim(valueToLoad) == "0") {
                      valueToLoad = "false";
                    }
                    break;
                  case 'hreplicated':
                    if (valueToLoad.toString() == "true") {
                      itemsHTML[countindex[docpageindex] - 1]["fieldsstructure"] = "horizontal";
                    }
                    break;
                  case 'barcode':
                    if (valueToLoad == 'QRCode' ||valueToLoad == 'PDF417') {
                      itemsHTML[countindex[docpageindex] - 1]["type_exp"] = "barcode2d";
                      itemsHTML[countindex[docpageindex] - 1]["barcode2d"] = valueToLoad;
                      valueToLoad = "";
                    }
                    break;
                }
                if (propName != "type") {
                  itemsHTML[countindex[docpageindex] - 1][propName] = valueToLoad;
                }
                break;

              case 'DocPage':
                break;
            }
            b++;
          }
        }
      }
    }

    if (!paste) {
      if (formProp.width > 0) {
        w_init = formProp.width;
      }
      else {
        formProp.width = w_init;
      }
      if (formProp.height > 0) {
        h_init = formProp.height;
      }
      else {
        formProp.height = h_init;
      }

      removeAllHandlers();
      docpageindex = 0;
      formProp.page = docpageindex;
      if (formProp.maxcount == undefined) {
        formProp.maxcount = 0;
      }
      nAllItems = Math.max(nAllItems, parseInt(formProp.maxcount));
      nitem = Math.max(nAllItems+1, nitem);
      itemsHTML = itemsHTMLArray[docpageindex];
      initCanvas();
      if (tabs) {
        tabs.reset();
      }
      writemenuTab();
      writeHTML(true);
      setzoom();
      for (i = 0; i < notimooManager.elements.length; i++) {
        notimooManager.close(notimooManager.elements[i]);
      }
      notimooManager.show({
        title : 'Notification message',
        message : tool + ' loaded!',
        visibleTime : 2000,
        width : 200
      });
    }
    else {
      removeAllHandlers();
      itemsHTML = itemsHTMLArray[docpageindex];
      setArea();
      writeHTML(false);
      //select paste objects
      var c, str;
      for (i = 0; i < pasted.length; i++) {
        c = pasted[i];
        index = c;
        itemsHTML[c].shadow = "shadow" + itemsHTML[c].id.substr(4);
        str = addHandlers(itemsHTML[c].id.substr(4));
        Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str;
        selectItem(Ctrl("shadow" + itemsHTML[c].id.substr(4)));
      }
    }

    //setLoadPic(false);
    if (!isLoading) { FormProperties(); }
  }
  else {
    PSAlert.alert("Error loading the "+ tool);
  }
}
/* *** Fine di reload *** */

/* *** Gestione tabs del disegnatore *** */
function resetTabs() {
  if (tabs) {
    Ctrl('navmenu_tabcontainer').setStyles({
      'left' : Ctrl('backcanvas').getPosition().x,
      'width' : Ctrl('backcanvas').getSize().x
    });
    tabs.refresh();
  }
}
/* *** Fine della gestione tabs del disegnatore *** */

/* *** Gestione Undo/Redo *** */
function Undo() {
  if (indexUndo > -1) {
    var scale;
    if (clCanvasLib != null) {
      scale = clCanvasLib.scale;
    }
    else {
      scale = CanvasLib.scale;
    }
    var prevUndo = undoSequence[indexUndo]; // sequenza prev
    var obj, l, idx;
    if (prevUndo[0].action == 'move') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].obj) {
          obj = prevUndo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTMLArray[prevUndo[l].page].length; idx++) {
            if (prevUndo[l].id == itemsHTMLArray[prevUndo[l].page][idx].id) {
              obj = itemsHTMLArray[prevUndo[l].page][idx];
              idx = itemsHTMLArray[prevUndo[l].page].length;
            }
          }
        }
        if (obj) {
          obj.x = (prevUndo[l].x_init / prevUndo[l].scale) * scale;
          obj.y = (prevUndo[l].y_init / prevUndo[l].scale) * scale;
          obj.h = (prevUndo[l].h / prevUndo[l].scale) * scale;
          obj.w = (prevUndo[l].w / prevUndo[l].scale) * scale;
          obj.scale = scale;
        }
      }
    }
    else if (prevUndo[0].action == 'delete') {
      for (l = 0; l < prevUndo.length; l++) {
        itemsHTMLArray[prevUndo[l].page][itemsHTMLArray[prevUndo[l].page].length] = prevUndo[l].obj;
        countindex[prevUndo[l].page]++;
        itemsHTMLArray[prevUndo[l].page][countindex[prevUndo[l].page] - 1].x = (prevUndo[l].x_init / prevUndo[l].scale) * scale;
        itemsHTMLArray[prevUndo[l].page][countindex[prevUndo[l].page] - 1].y = (prevUndo[l].y_init / prevUndo[l].scale) * scale;
        itemsHTMLArray[prevUndo[l].page][countindex[prevUndo[l].page] - 1].h = (prevUndo[l].h / prevUndo[l].scale) * scale;
        itemsHTMLArray[prevUndo[l].page][countindex[prevUndo[l].page] - 1].w = (prevUndo[l].w / prevUndo[l].scale) * scale;
        itemsHTMLArray[prevUndo[l].page][countindex[prevUndo[l].page] - 1].scale = scale;
      }
    }
    else if (prevUndo[0].action == 'resize') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].obj) {
          obj = prevUndo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTMLArray[prevUndo[l].page].length; idx++) {
            if (prevUndo[l].id == itemsHTMLArray[prevUndo[l].page][idx].id) {
              obj = itemsHTMLArray[prevUndo[l].page][idx];
              idx = itemsHTMLArray[prevUndo[l].page].length;
            }
          }
        }
        if (obj) {
          obj.h = (prevUndo[l].h_init / prevUndo[l].scale) * scale;
          obj.w = (prevUndo[l].w_init / prevUndo[l].scale) * scale;
          if (!Empty(prevUndo[l].x_init)) { obj.x = (prevUndo[l].x_init / prevUndo[l].scale) * scale; }
          if (!Empty(prevUndo[l].y_init)) { obj.y = (prevUndo[l].y_init / prevUndo[l].scale) * scale; }
          obj.scale = scale;
        }
      }
    }
    else if (prevUndo[0].action == 'paste') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].action == 'paste') {
          idx = LibJavascript.Array.indexOf(itemsHTMLArray[prevUndo[l].page], prevUndo[l].obj);
          if (idx >= 0) {
            itemsHTMLArray[prevUndo[l].page].splice(idx, 1);
            countindex[prevUndo[l].page]--;
          }
        }
      }
    }
    else if (prevUndo[0].action == 'add') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].action == 'add') {
          idx = LibJavascript.Array.indexOf(itemsHTMLArray[prevUndo[l].page], prevUndo[l].obj);
          if (idx >= 0) {
            itemsHTMLArray[prevUndo[l].page].splice(idx, 1);
            countindex[prevUndo[l].page]--;
          }
        }
      }
    }
    indexRedo = indexUndo;
    indexUndo--;
    selectForm();
    index = null;
    if (last_index) { last_index = null; }
    writeHTML(true);
  }
}

function Redo() {
  /* indexRedo e' uguale a indexUndo fino a quando non si esegue l'operazione Undo().
     In tal caso, indexRedo e' maggiore di indexUndo.
     Il test
      indexRedo!= indexUndo
     serve per quando si esegue un'operazione di Undo(), si effettua un'altra operazione di cui e' possibile fare Undo() e si cerca di eseguire il Redo().
     Senza il test, veniva eseguita un'altra volta l'operazione effettuata dopo l'Undo().
  */
  if ((indexRedo > -1) && ((indexRedo < undoSequence.length) && (indexRedo != indexUndo))) {
    var scale;
    if (clCanvasLib != null) {
      scale = clCanvasLib.scale;
    }
    else {
      scale = CanvasLib.scale;
    }

    var seqRedo = undoSequence[indexRedo]; // sequenza prev
    var l = 0, idx = 0;
    var obj;
    if (seqRedo[0].action == 'move') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].obj) {
          obj = seqRedo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTMLArray[seqRedo[l].page].length; idx++) {
            if (seqRedo[l].id == itemsHTMLArray[seqRedo[l].page][idx].id) {
              obj = itemsHTMLArray[seqRedo[l].page][idx];
              idx = itemsHTMLArray[seqRedo[l].page].length;
            }
          }
        }
        if (obj) {
          obj.x = (seqRedo[l].x / seqRedo[l].scale) * scale;
          obj.y = (seqRedo[l].y / seqRedo[l].scale) * scale;
          obj.h = (seqRedo[l].h / seqRedo[l].scale) * scale;
          obj.w = (seqRedo[l].w / seqRedo[l].scale) * scale;
          obj.scale = scale;
        }
      }
    }
    else if (seqRedo[0].action == 'resize') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].obj) {
          obj = seqRedo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTMLArray[seqRedo[l].page].length; idx++) {
            if (seqRedo[l].id == itemsHTMLArray[seqRedo[l].page][idx].id) {
              obj = itemsHTMLArray[seqRedo[l].page][idx];
              idx = itemsHTMLArray[seqRedo[l].page].length;
            }
          }
        }
        if (obj) {
          obj.w = (seqRedo[l].w / seqRedo[l].scale) * scale;
          obj.h = (seqRedo[l].h / seqRedo[l].scale) * scale;
          if (!Empty(seqRedo[l].x)) { obj.x = (seqRedo[l].x / seqRedo[l].scale) * scale; }
          if (!Empty(seqRedo[l].y)) { obj.y = (seqRedo[l].y / seqRedo[l].scale) * scale; }
          obj.scale = scale;
        }
      }
    }
    else if (seqRedo[0].action == 'delete') {
      for (l = 0; l < seqRedo.length; l++) {
        idx = LibJavascript.Array.indexOf(itemsHTMLArray[seqRedo[l].page], seqRedo[l].obj);
        if (idx >= 0) {
          itemsHTMLArray[seqRedo[l].page].splice(idx, 1);
          countindex[seqRedo[l].page]--;
        }
      }
    }
    else if (seqRedo[0].action == 'paste') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].action == 'paste') {
          itemsHTMLArray[seqRedo[l].page][itemsHTMLArray[seqRedo[l].page].length] = seqRedo[l].obj;
          countindex[seqRedo[l].page]++;
          seqRedo[l].obj.x = (seqRedo[l].x / seqRedo[l].scale) * scale;
          seqRedo[l].obj.y = (seqRedo[l].y / seqRedo[l].scale) * scale;
          seqRedo[l].obj.h = (seqRedo[l].h / seqRedo[l].scale) * scale;
          seqRedo[l].obj.w = (seqRedo[l].w / seqRedo[l].scale) * scale;
          seqRedo[l].obj.scale = scale;
        }
      }
    }
    else if (seqRedo[0].action == 'add') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].action == 'add') {
          itemsHTMLArray[seqRedo[l].page][itemsHTMLArray[seqRedo[l].page].length] = seqRedo[l].obj;
          countindex[seqRedo[l].page]++;
          seqRedo[l].obj.x = (seqRedo[l].x / seqRedo[l].scale) * scale;
          seqRedo[l].obj.y = (seqRedo[l].y / seqRedo[l].scale) * scale;
          seqRedo[l].obj.h = (seqRedo[l].h / seqRedo[l].scale) * scale;
          seqRedo[l].obj.w = (seqRedo[l].w / seqRedo[l].scale) * scale;
          seqRedo[l].obj.scale = scale;
        }
      }
    }
    indexUndo = indexRedo;
    indexRedo++;
    selectForm();
    index = null;
    if (last_index) last_index = null;
    writeHTML(true);
  }
}

function insertIntoUndoSequence() {
  if (undoItemsMoved.length > 0) {
    indexUndo++;
    indexRedo = indexUndo;
    undoSequence[indexUndo] = undoItemsMoved;
    CheckUndoSize();
  }
  undoItemsMoved = [];
}
/* *** Fine della gestione Undo/Redo *** */

/* *** Gestione Properties *** */
function setPropertiesID(obj) { //ricreo properties per compatibilita' con il vecchio array
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    mainObject.objClass.properties = new Array();
    var tab;
    for (var i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (var ii = 0; ii < tab.length; ii++) {
        if (typeof(tab[ii].defaultValue) == 'undefined') {
          mainObject.objClass.properties.push(tab[ii].propID);
        }
        else if (((tab[ii].defaultValue + '').trim() != (mainObject[tab[ii].propID] + '').trim())) {
          if ((mainObject[tab[ii].propID] + '').trim() != '') {
            mainObject.objClass.properties.push(tab[ii].propID);
          }
        }
      }
    }
  }
}

function FormProperties(force_render, force_open) {
  var mainobj = formProp;
  if (Empty(newFormPropObj) || force_render) {
    newFormPropObj = new propertiesObj({
      m_obj : mainobj,
      isForm : true,
      canExpandToColumn : false,
      divcontainer : 'formproperties',
      moveDiv : false,
      afterRender : resizeGadgetsPane
    });
  }
  else {
    newFormPropObj.updatePropertiesFromPaint(mainobj);
  }
  if(searchProp) {
    if (Empty(searchFormPropObj)) {
      searchFormPropObj = new propertiesObj({
        m_obj : searchProp,
        isForm : false,
        canExpandToColumn : false,
        divcontainer : 'searchproperties',
        moveDiv : false,
        afterRender : resizeGadgetsPane
      });
    }
    else {
      searchFormPropObj.updatePropertiesFromPaint(searchProp);
    }
  }
  if (force_open && ps_props.form_closed == true) {
    togglePane();
  }
}

function initPropertiesDefaultValue(obj) {
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    mainObject.objClass.properties = new Array();
    var tab, ii;
    for (var i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        mainObject[tab[ii].propID] = tab[ii].defaultValue;
      }
    }
  }
}
/* *** Fine della gestione Properties *** */

/* *** Gestione Toolbar *** */
function setToolbars() {
  if (preview_opened == true) {
    toolbars.ctrl.disable();
    toolbars.edit.disable();
    if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {
      toolbars.action.disable();
    }
    toolbars.align.disable();
  }
  else {
    toolbars.ctrl.enable();
    toolbars.edit.enable();
    if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {
      toolbars.action.enable();
    }
    toolbars.align.enable();
  }
}
/* *** Fine della gestione Toolbar *** */
