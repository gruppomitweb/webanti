/* exported
    toolbars def tool xxpos yypos rotation pdfLoading pdffile w_init h_init zoomindex
    closeAfterSave saving savingpic dx dy
    Help openModule doLoad addItem Paste writemenuTab newCurrentObj createPreview openclosediv
    Copy newdesign resetGenericLight Preview ValidMove addImgHandlers removeAllImgHandlers togglerGadget imgcountindex
 */

 /* global designToolbar avFields resizeWindow initCanvas
    selectedZoombox openas LoadPdfz itemsHTMLArray docpageindex
    insertIntoUndoSequence fieldcountindex setPropertiesID reload_ resetscroll
    setCanvasScroll resetTabs setShadow infindex selectImg tabs imgHTML version imgcountindex
 */

var currentname = ""; //nome dello sca corrente
var def = ""; // Def del modello corrente
var tool = "scandoc"; // Tool utilizzato
var xxpos; // for insert image dialog
var yypos;
var rotation = false;
var saveas = false;
var isLoading = false;
//var imgLoading = false;
var pdfLoading = false;
var pdffile = "";
var w_init = 0;
var h_init = 0;
var _original_onselectstart = document.onselectstart;
var zoomindex = 2;
var maxpages = -1; // Numero di pagine del file pfd
var closeAfterSave = false;
var workAreaWidth = -1;
var workAreaHeight = -1;
var defH = 24;

var putok = false;
var putalert = false;

var fieldsList = [];

var clCanvasLib = null;
var notimooManager;
var fld_accordion = null;

var pasted = [];
var toolbars = {};

var type; // Tipo dell'item da aggiungere
var showFieldsNr = false; // Indica se visualizzare il numero dei campi
var elementsNrByGroup = []; // Utilizzate per disegnare i fields nello Zones Explorer

function openModule() {
  var url = "../portalstudio/open.jsp?tool=scandoc&onetool=true";
  OpenWindow(url, 800, 600);
}

function doLoad(e, id, mode, pdfsrc) {
  initPainter();
  notimooManager.show({
    title : 'Notification message',
    message : 'loading Scan Editor!',
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

    // Gestione Toolbar
    designToolbar();

    /*var ctrl = Ctrl("mversion");
    if (ctrl) {
      ctrl.innerHTML = "Scan Editor v" + mversion;
    }*/

    //before init canvas
    Ctrl("canvasitems").style.width = Ctrl("backcanvas").style.width;
    Ctrl("canvasitems").style.height = Ctrl("backcanvas").style.height;

    if (avFields.length > 0) {
      showFieldsNr = true;
      /* Inizializzazione del menu accordion per i fields del fields explorer */
      if (fld_accordion == null) {
        fld_accordion = new Fx.Accordion([], [], {
          'onComplete' : resizeGadgetsPane,
          'onActive' : function (toggler/*, element*/) {
            removeAllFieldHandlers();
            toggler.getFirst('.fld_title_ico').setStyle( "border-color", "rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) #000 rgba(0, 0, 0, 0)");
          },
          'onBackground' : function (toggler/*, element*/) {
            removeAllFieldHandlers();
            toggler.getFirst('.fld_title_ico').setStyle("border-color", "#000 rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) rgba(0, 0, 0, 0)");
          },
          alwaysHide : true,
          display : -1
        });
      }
    }
    else {
      showFieldsNr = false;
    }

    resizeWindow(e, true);
    if (!Empty(id)) {
      currentname = id;
      reload(null, pdfsrc);
    }
    else {
      resizeWindow(e, true);
      initCanvas();
      selectedZoombox("zoombox");
    }

    /* Per compatibilita' con la versione della Build 59. */
    /*da rimuovere == parametro openas */
    /*if (!Empty(scafilename))
      currentname = scafilename;*/

    /* Parametri del disegnatore:
       - id : nome del file sca da aprire
       - mode :
          - 'tosave' : obbliga a salvare lo sca aperto con un altro nome
       - src : percorso dell'immagine di sfondo.
       - pdfsrc : nome del pdf da applicare come sfondo dello sca (prevale su quanto scritto nelle ScanDoc properties )
       - mdl : permette solo di salvare lo sca corrente. Non si possono aprire altri sca, salvare lo sca corrente con un altro nome o creare un nuovo sca.
       - modelight : permette solo di salvare lo sca corrente. Non si possono aprire altri sca, salvare lo sca corrente con un altro nome o creare un nuovo sca.
       - toolbar :
       - fieldsList : lista di campi da caricare nel Fields Explorer separata dal carattere |
       - openas : apre lo sca aperto con un altro nome.

    */
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
      document.title = currentname + " - Scan Editor";
      if (Ctrl("srcform")) {
        Ctrl("srcform").value = currentname;
      }
    }

    if (!Empty(pdfsrc)) {
      if (LRTrim(formProp.file) == "" || (LRTrim(formProp.file)).toLowerCase() != LRTrim(pdfsrc).toLowerCase()) {
        LoadPdfz(pdfsrc, "true");
      }
    }

    if (Empty(id)) {
      Ctrl("canvasitems").style.width = Ctrl("backcanvas").style.width;
      Ctrl("canvasitems").style.height = Ctrl("backcanvas").style.height;
    }

    w_init = Ctrl("backcanvas").offsetWidth;
    h_init = Ctrl("backcanvas").offsetHeight;

    //selectedZoombox("zoombox");

    writeDocPageHTML(true);

    if (Ctrl("toolbar-wrapper")) {
      Ctrl("toolbar-wrapper").style.display = "block";
    }
    isLoading = false;
    $("loading").fade(0);

    //load fields
    designToolbarFld();

    create_gadget_pane();
    setFieldsExpUsed();
    FormProperties();
  };
  fnToDelay.delay(500);
}

function Help(the_property) {
  var i, prop = "";
  if (typeof(anchorToFeature) != "undefined") {
    if (typeof(the_property) != "undefined") {
      prop = "scaneditor_" + the_property.toLowerCase();
    }
    if (prop in anchorToFeature && prop != "") {
      i = anchorToFeature[prop];
    }
    else if (index != null && "scaneditor_" + itemsHTMLArray[docpageindex][index].type.toLowerCase() in anchorToFeature) {
      i = anchorToFeature["scaneditor_" + itemsHTMLArray[docpageindex][index].type.toLowerCase()];
    }
    else if (typeof(i)=='undefined') {
      prop = "scaneditor_" + the_property.substring(the_property.indexOf('_'),0).toLowerCase();
      i = anchorToFeature[prop];
    }

    if(typeof(i)=='undefined'){
      i = anchorToFeature["scaneditor"];
    }
    windowOpenForeground(m_cHelpUrl+"help/portalstudio/ps_urg_navigator.htm?" + URLenc(i + (prop != "" ? "||" + prop : "")), "", "toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1");
  }
}

/* *** Gestione aggiunta degli item *** */
// Funzioni di inserimento nuovo item
function addItem(item) {
  var evtType = "click";
  if (arguments[0].type && arguments[0].type == "drop") {
    type = arguments[1];
    evtType = "drag";
  }
  else if (arguments[0].type && arguments[0].type == "click")
    type = arguments[1];
  else
    type = item;

  if (type == "DocPage") {
    putItem();
  }
  else {
    putalert = true;
    if (evtType == "drag") {
      putItem(arguments[0]);
      insertIntoUndoSequence();
      if (putok) {
        clickItem(null, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].id);
      }
    }
    else {
      $("canvas").setStyle('cursor', 'crosshair');
      Ctrl("canvas").onmousedown = function (event) {
        putItem(event);
        insertIntoUndoSequence();
        if (putok) {
          clickItem(null, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].id);
        }
      };
    }
  }
}

function canAddZone(zname, mess) {
  var j;
  for (var i = 0; i < countindex.length; i++) {
    for (j = 0; j < itemsHTMLArray[i].length; j++) {
      if (itemsHTMLArray[i][j].name == zname) {
        if (mess == true) {
          PSAlert.alert("Zone " + getFieldDesc(zname) + " already insert in page " + (itemsHTMLArray[i][j].page + 1));
        }
        return false;
      }
    }
  }
  return true;
}

var xpos = 0, ypos = 0;
var maxWidth = 0, maxHeight = 0;
function calcPosition(e) {
  e = (e) ? e : window.event;
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
  maxWidth = parseInt(Ctrl("canvaslinks").offsetWidth);
  maxHeight = parseInt(Ctrl("canvaslinks").offsetHeight);

  if (maxWidth <= 0 || maxHeight <= 0) {
    maxWidth = parseInt(Ctrl("backcanvas").offsetWidth);
    maxHeight = parseInt(Ctrl("backcanvas").offsetHeight);
  }
}

function putItem(e/*, b_reload*/) {
  var htmlObj = "";
  calcPosition(e);
  switch (type) {
    case 'Zone':
      if (putalert == false) {
        xpos = 0;
        ypos = 0;
      }
      putok = false;
      if (xpos >= 0 && ypos >= 0 && (xpos + 60 * clCanvasLib.scale / 100 < maxWidth) && (ypos + 30 * clCanvasLib.scale / 100 < maxHeight)) {
        putok = true;
        htmlObj = '<div id=\'item' + nitem + '\' class="transparent" onselectstart=\'cancelEvent(event)\' style=\'z-index:1;font-size:1px;line-height:0;border:0px solid;width:' + 60 * clCanvasLib.scale / 100 + 'px;height:' + 30 * clCanvasLib.scale / 100 + 'px;position:absolute;top:' + ypos + 'px;left:' + xpos + 'px;\' onClick="cancelEvent(event);clickItem(event,\'item' + nitem + '\')"></div>';
        if (showFieldsNr) {
          htmlObj += '<div id=\'item' + nitem + 'Num\' class="transparentnum" style="position:absolute;"></div>';
        }
        itemsHTMLArray[docpageindex][countindex[docpageindex]] = new ZTObjects.ZoneObj('item' + nitem, 'Zone' + nitem, 'Zone', htmlObj, 'character', '', xpos, ypos);
        nitem++;
        countindex[docpageindex]++;
        Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].html;
        itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].h = Ctrl("item" + (nitem - 1)).offsetHeight;
        itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].w = Ctrl("item" + (nitem - 1)).offsetWidth;
        undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].id, 'add', itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].x, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].y, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].x, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].y, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1], itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].w, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].h, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].w, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].h);
        var ctrl = Ctrl("item" + (nitem-1));
        var ctrln = Ctrl("item" + (nitem-1) + "Num");
        if (ctrln) {
          ctrln.style.width = (ctrln.offsetWidth* clCanvasLib.scale / 100) + "px";
          ctrln.style.height = (ctrln.offsetHeight* clCanvasLib.scale / 100) + "px";
          ctrln.style.left = ctrl.offsetLeft + "px";
          ctrln.style.top = (ctrl.offsetTop - ctrln.offsetHeight) + "px";
          /*ctrln.style.fontSize = (ctrln.offsetHeight-2) + "px";
          ctrln.style.lineHeight = (ctrln.offsetHeight-2) + "px";*/
        }
      }
      else {
        putok = false;
        PSAlert.alert("Object not created !");
      }
      break;
    case 'DocPage':
      break;
  }
  m_bUpdated = true;
  itemsHTML = itemsHTMLArray[docpageindex];
  $('canvas').setStyle('cursor', 'default');
  Ctrl("canvas").onmousedown = beginDragSelection;
}
/* *** Fine della gestione aggiunta degli item *** */

/* *** Gestione dei Field *** */
function designToolbarFld() {
  if (avFields.length > 0) {
    var group, groupDesc, fname, desc;
    var singleField = avFields.split("|");
    var singleFieldProp;
    group = "scaneditor_pgroup";
    groupDesc = "Zones";
    for (var mm = 0; mm < singleField.length; mm++) {
      singleFieldProp = singleField[mm].split(":");
      fname = singleFieldProp[0];
      desc = singleFieldProp[1];
      groupDesc = singleFieldProp[2];
      if (typeof(groupDesc) == "undefined" || desc == "") {
        groupDesc = "Zones";
      }
      group = "scaneditor_pgroup_" + groupDesc;
      if (typeof(desc) == "undefined" || desc == "") {
        desc = fname;
      }
      fieldsList.push({fieldName:fname,fieldDesc:desc});
      putField(group, groupDesc, fname, desc);
    }
  }
  else {
    Ctrl("legend_title").style.display = "none";
    Ctrl("legend_items").style.display = "none";
    Ctrl("gadgetlistTitlePz").style.display = "none";
    Ctrl("fields_container").style.display = "none";
  }
}

function putField(group, groupDesc, fname, desc) {
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
  var wrapper;
  wrapper = Ctrl(group + "_divz");
  if (wrapper == null) {
    elementsNrByGroup[group] = 0;
  }

  var title, ul, li;

  var htmlObj = '<div id=\'item' + nitem + '\' class="transparent-field" title=\'' + fname + '\' onselectstart=\'cancelEvent(event)\' style=\'z-index:1;overflow:hidden;border:0px solid;width:' + fwidth + 'px;\' onClick="cancelEvent(event);clickItem(event,\'item' + nitem + '\')">';
  htmlObj += '<div id=\'item' + nitem + '_num\' class="transparent-fieldnumber" style="display:inline-block">' + (fieldcountindex + 1) + '</div>';
  htmlObj += '<div id=\'item' + nitem + '_int\' style="display:inline-block" class="transparent-fieldlabel">' + "&nbsp;" + desc + '</div>';
  htmlObj += '</div>';

  fieldHTML[fieldcountindex] = new ZTObjects.fieldObj('item' + nitem, 'Field' + nitem, 'Field', htmlObj, '', '', xpos, ypos, fwidth, fheight, group, fname, desc);
  nitem++;
  fieldcountindex++;

  if (!wrapper) {
    wrapper = new Element('div', {
      'class' : 'fld_wrapper',
      'id' : group + '_divz'
    }).inject(Ctrl("toolbarfld"));
    title = new Element('div', {
      'class' : 'fld_title'
    }).inject(wrapper);
    new Element('div', {
      'class' : 'fld_title_txt',
      'text' : groupDesc
    }).inject(title);
    new Element('div', {
      'class' : 'fld_title_ico'
    }).inject(title);
    ul = new Element('ul', {
      'class' : 'fld_ul'
    }).inject(wrapper);
    li = new Element('li', {
      'class' : 'fld_li'
    }).inject(ul);
    li.innerHTML = fieldHTML[fieldcountindex - 1].html;
    fld_accordion.addSection(title, ul);
    fld_accordion.display(-1);
    new Element('div', {
      'class' : 'list_border'
    }).inject(wrapper);
  }
  else {
    ul = wrapper.getElement('ul');
    li = new Element('li', {
      'class' : 'fld_li'
    }).inject(ul);
    li.innerHTML = fieldHTML[fieldcountindex - 1].html;
  }
  elementsNrByGroup[group] = elementsNrByGroup[group] + 1;
}

function resetToolbarFld() {
  removeAllFieldHandlers();
  fieldHTML = []; //array contenente tutti i Field
  fieldcountindex = 0;
  Ctrl("toolbarfld").innerHTML = "";
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
    addFieldHandlers(fieldHTML[pos].id.substr(4));
    selectItemBarField(Ctrl("shadow" + fieldHTML[pos].id.substr(4)));
  }
}

function getFieldDesc(name) {
  for (var i = 0; fieldsList && i < fieldsList.length; i++) {
    if (fieldsList[i].fieldName == name) {
      return fieldsList[i].fieldDesc;
    }
  }
  return name;
}

function setFieldsExpUsed() {
  var b, ctrl, ctrln, i, j;
  for (var k = 0; k < fieldHTML.length; k++) {
    b = false;
    ctrl = Ctrl(fieldHTML[k].id);
    if (ctrl) {
      ctrl.className = "transparent-field";
      for (i = 0; i < countindex.length && !b; i++) {
        for (j = 0; j < itemsHTMLArray[i].length && !b; j++) {
          if (itemsHTMLArray[i][j].name == fieldHTML[k].fname) {
            b = true;
            ctrl.className = "transparent-fieldused";
            ctrln = Ctrl(itemsHTMLArray[i][j].id + "Num");
            if (ctrln) {
              ctrln.innerHTML = (k + 1) + "";
            }
          }
        }
      }
    }
  }
}
/* *** Fine della gestione dei Field *** */

/* *** Gestione cancellazione degli item *** */
// vengono eliminati gli elementi selezionati dall'array
function deleteItem() {
  undoItemsMoved = [];
  var tmp = [], tmpn = 0;
  for (var i = 0; i < itemsHTMLArray[docpageindex].length; i++) {
    if (itemsHTMLArray[docpageindex][i].shadow == "") {
      // Sposta gli elementi non selezionati in tmp
      tmp[tmpn] = itemsHTMLArray[docpageindex][i];
      tmpn++;
    }
    else {
      // Salvo gli oggetti cancellati per Undo
      undoItemsMoved.push(new ZTObjects.undoObj(null, 'delete', null, null, itemsHTMLArray[docpageindex][i].x, itemsHTMLArray[docpageindex][i].y, itemsHTMLArray[docpageindex][i]));
    }
  }
  insertIntoUndoSequence();
  countindex[docpageindex] = tmpn;
  itemsHTMLArray[docpageindex] = tmp;
  selectForm();

  index = null;
  m_bUpdated = true;
  writeHTML();
}
/* *** Fine della gestione cancellazione degli item *** */

/* *** Gestione del Copy/Paste *** */
function Copy(cut) {
  var deftmp = [], selectedItems = {};
  var i;
  for (i = 0; i < itemsHTMLArray[docpageindex].length; i++) {
    if (itemsHTMLArray[docpageindex][i].shadow != "") {
      deftmp.push(copyItem(itemsHTMLArray[docpageindex][i]));
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
  var valueToSave = "";
  setPropertiesID(item);
  var JsonItem = {"type" : item.type, "page" : docpageindex};
  for (var u = 0; u < item.objClass.properties.length; u++) {
    valueToSave = item[item.objClass.properties[u]];
    //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
    if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
      if (typeof(valueToSave) == "undefined" || valueToSave == "") {
        // se la prop e' undefined allora la salvo come " "
        valueToSave = " ";
      }
    }
    JsonItem[item.objClass.properties[u]] = valueToSave;
  }
  return JsonItem;
}

function Paste(strpaste) {
  if (strpaste != "") {
    reload_(null, strpaste, true);
    undoItemsMoved = [];
    for (var idx = 0; idx < pasted.length; idx++) {
      // Si salvano gli oggetti incollati per l'Undo
      undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, 'paste', itemsHTML[pasted[idx]].x, itemsHTML[pasted[idx]].y, itemsHTML[pasted[idx]].x, itemsHTML[pasted[idx]].y, itemsHTML[pasted[idx]]);
    }
    insertIntoUndoSequence();
    type = null;
    writeDocPageHTML(true);
  }
}
/* *** Fine della Gestione del Copy/Paste *** */

/* *** Gestione writeHTML *** */
// riscrive l'HTML dopo la cancellazione degli items
function writeHTML(fromReload) {
  Ctrl("canvasitems").innerHTML = "";
  if (Empty(fromReload)) {
    fromReload = false;
  }

  if (fromReload) {
    var fxForm = new Fx.Morph('backcanvas', {
      duration : '500',
      transition : Fx.Transitions.Bounce.easeOut
    });
    fxForm.start({}).chain(function () {
      resetscroll(clCanvasLib.scale);
      setCanvasScroll();
      resetTabs();
    });
  }

  updateCommonVars();

  for (var i = 0; i < itemsHTMLArray[docpageindex].length; i++) {
    writeHTMLItemObj(itemsHTMLArray[docpageindex][i]);
  }

  if (index != null && typeof(itemsHTML[index]) != "undefined") {
    var ctrl = Ctrl("shadow" + itemsHTML[index].id.substr(4));
    var itm = itemsHTML[index];
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
  setFieldsExpUsed();
}

function writeHTMLItemObj(itm) {
  var ctrl;
  if (typeof(itm) == "undefined") {
    return;
  }
  Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itm.html;
  if (itm.type == "Zone") {
    ctrl = Ctrl(itm.id);
    if (!ctrl) {
      return;
    }
    ctrl.style.display = "block";
    ctrl.title = itm.name;
    if (typeof(itm.x) != "undefined") { ctrl.style.left = itm.x + "px"; }
    if (typeof(itm.y) != "undefined") { ctrl.style.top = itm.y + "px"; }
    if (typeof(itm.w) != "undefined") { ctrl.style.width = itm.w + "px"; }
    if (typeof(itm.h) != "undefined") { ctrl.style.height = itm.h + "px"; }
    ctrl.title = getFieldDesc(itm.name);

    var ctrln = Ctrl(itm.id + "Num");
    if (ctrln) {
      ctrln.style.width = (ctrln.offsetWidth* clCanvasLib.scale / 100) + "px";
      ctrln.style.height = (ctrln.offsetHeight* clCanvasLib.scale / 100) + "px";
      ctrln.style.left = ctrl.offsetLeft + "px";
      ctrln.style.top = (ctrl.offsetTop - ctrln.offsetHeight) + "px";
      /*ctrln.style.fontSize = (ctrln.offsetHeight-2) + "px";
      ctrln.style.lineHeight = (ctrln.offsetHeight-2) + "px";*/
      ctrln.innerHTML = itm.fieldindex;
    }
  }
}

function updateCommonVars() {
  if (formProp.hsl == "true") {
    // Disabilita le SnapLines
    canAlign = false;
  }
  else {
    canAlign = true;
  }

  if (formProp.lock_items == "true") {
    lockItems = true;
  }
  else {
    lockItems = false;
  }
}

function writeDocPageHTML(/*rewrite*/) {
  /*if (rewrite) {
    removeAllImgHandlers();
    Ctrl("toolbarimg").innerHTML = "";
    var ctrl;
    for (var i = 0; i < imgHTML.length; i++) {
      Ctrl("toolbarimg").innerHTML = Ctrl("toolbarimg").innerHTML + imgHTML[i].html;
      imgHTML[i].y = ((i + 1) * 30 + i * 40);
      ctrl = Ctrl(imgHTML[i].id);
      ctrl.style.top = imgHTML[i].y + "px";
      ctrl.src = imgHTML[i].src;
    }
  }*/
  if (infindex != null) {
    docpageindex = -1;
    selectImg(infindex);
  }
  else {
    docpageindex = -1;
    selectImg(0);
  }
}

function writemenuTab() {
  if (!tabs) {
    tabs = new TabsMT('scan_page_list', 'scan_page_frame', {
      clickFunc : function (index) {
        selectImg(index);
      },
      close:false
    });
  }
  var c1 = countindex.length;
  var c2 = maxpages;
  if (c1 > c2) {
    c2 = c1;
  }
  var li, span, scanFrame;
  for (var i = 0; i < c2; i++) {
    scanFrame = new Element('div', {}).inject($('scan_page_frame'));
    li = new Element('li').inject($('scan_page_list'));
    span = new Element('span').inject(li);
    span.set('text',('Page ' + (i + 1)));
    tabs.addTabs(li,scanFrame);
  }
  tabs.setSelectedTab(0);
  adjustTabHeight();
}

function adjustTabHeight() {
  var fz = function() {
    if(Ctrl("scan_page_list").offsetHeight != defH) {
      var dif = Ctrl("scan_page_list").offsetHeight - defH;
      Ctrl("backcanvas").style.top = (Ctrl("backcanvas").offsetTop + (dif)) + "px";
      Ctrl("v_ruler").style.top = (Ctrl("v_ruler").offsetTop + (dif)) + "px";
    }
    defH = Ctrl("scan_page_list").offsetHeight;
  }
  fz.delay(100);
}
/* *** Fine della gestione writeHTML *** */

/* *** Gestione del New *** */
function newCurrentObj(text_path/*, srcmode, path_tmp*/) {
  var id = text_path;
  currentname = id;
  reload(null);
  document.title = currentname + " - Scan Editor";
  if (Ctrl("srcform")) {
    Ctrl("srcform").value = currentname;
  }
}

function newdesign() {
  if (m_bUpdated) {
    if (confirm("Do you want to save " + currentname + "?")) {
      save(function () {
        newdesignz();
      });
      return;
    }
    else { newdesignz(); }
  }
  else { newdesignz(); }
}

function newdesignz() {
  var propDiv = $("properties");
  if (propDiv) {
    propDiv.hide();
  }
  resetGeneric();
  resetToolbarFld();
  currentname = "";
  document.title = currentname + " - Scan Editor";
  if (Ctrl("srcform")) {
    Ctrl("srcform").value = currentname;
  }
}

function resetGeneric() {
  index = null;
  infindex = null;
  itemsHTMLArray = []; //array contenente tutti i Field
  imgHTML = [];
  countindex = []; //contatore indice array
  imgcountindex = 0;
  docpageindex = 0;
  formProp.page = docpageindex;
  itemsHTMLArray[docpageindex] = [];
  itemsHTML = itemsHTMLArray[docpageindex];
  countindex[docpageindex] = 0;
  clCanvasLib.scale = 100;
  zoomindex = 2;
  Ctrl("canvasitems").innerHTML = "";
  if (tabs) { tabs.reset(); }
  formProp.fldfile = "";
  formProp.file = "";
  formProp.description = "";
  writeDocPageHTML(true);
}

function resetGenericLight() {
  index = null;
  infindex = null;
  imgHTML = [];
  imgcountindex = 0;
  docpageindex = 0;
  formProp.page = docpageindex;
  itemsHTML = itemsHTMLArray[docpageindex];
  if (tabs) { tabs.reset(); }
  writeDocPageHTML(true);
}
/* *** Fine della gestione del New *** */

/* *** Gestione del Save *** */
var saving, savingpic;
var AfterSave;
function save(then) {
  if (parent) { parent.is_Saving = true; }
  if (currentname != "") {
    if (parent) { parent.is_Saving = true; }
    notimooManager = new Notimoo({});
    notimooManager.show({
      title : 'Notification message',
      message : 'saving scandoc ' + currentname,
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

function saveAs() {
  if (parent) { parent.is_Saving = true; }
  OpenWindow("../portalstudio/saveas.jsp?tool=scandoc", 580, 600);
}

function getDef() {
  var strsave, propName, valueToSave;
  var u, i, j;
  var JSONItems = [];
  var JSONTmpItem = {type : formProp.type};
  JSONTmpItem["version"] = version;
  setPropertiesID(formProp);
  /* ScanDoc Properties */
  for (u = 0; u < formProp.objClass.properties.length; u++) {
    propName = formProp.objClass.properties[u];
    valueToSave = formProp[propName];
    //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
    if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
      if (typeof(valueToSave) == "undefined" || valueToSave == "") {
        // se la prop e' undefined, allora si salva come " "
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

  /*DocPage Properties */
  for (i = 0; i < imgHTML.length; i++) {
    JSONTmpItem = {type : imgHTML[i].type};
    setPropertiesID(imgHTML[i]);
    for (u = 0; u < imgHTML[i].objClass.properties.length; u++) {
      propName = imgHTML[i].objClass.properties[u];
      valueToSave = imgHTML[i][propName];
      //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
      if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
        if (typeof(valueToSave) == "undefined" || valueToSave == "") {
          // se la prop e' undefined, allora si salva come " "
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
      /*if (propName == "h" && valueToSave == 0) {
        try {
          img = new Image();
          img.src = imgHTML[i].src;
          valueToSave = img.height;
        }
        catch (e) {
          valueToSave = 0;
        }
      }
      else if (propName == "w" && valueToSave == 0) {
        try {
          img = new Image();
          img.src = imgHTML[i].src;
          valueToSave = img.width;
        }
        catch (e) {
          valueToSave = 0;
        }
      }*/
      if (LRTrim(valueToSave.toString()) != "") {
        JSONTmpItem[propName] = valueToSave;
      }
    }
    JSONItems.push(JSONTmpItem);
    JSONTmpItem = {};
  }

  /*Zone Properties */
  for (i = 0; i < countindex.length; i++) {
    for (j = 0; j < itemsHTMLArray[i].length; j++) {
      JSONTmpItem = {type : itemsHTMLArray[i][j].type};
      JSONTmpItem["page"] = i;
      setPropertiesID(itemsHTMLArray[i][j]);
      for (u = 0; u < itemsHTMLArray[i][j].objClass.properties.length; u++) {
        propName = itemsHTMLArray[i][j].objClass.properties[u];
        valueToSave = itemsHTMLArray[i][j][propName];
        //Se valueToSave e' booelan e uguale a false, il test valueToSave=="" restituisce true
        if (typeof(valueToSave) != "number" && typeof(valueToSave) != "boolean") {
          if (typeof(valueToSave) == "undefined" || valueToSave == "") {
            // Se la prop e' undefined allora la salvo come " "
            valueToSave = " ";
          }
        }
        switch(propName) {
          case 'x':
          case 'y':
            if (valueToSave < 0) {
              PSAlert.alert("attention item with position < 0");
              itemsHTMLArray[i][propName] = 0;
              valueToSave = 0;
            }
            valueToSave = valueToSave * 100 / clCanvasLib.scale;
            break;
          case 'w':
          case 'h':
          case 'scale':
            valueToSave = valueToSave * 100 / clCanvasLib.scale;
            break;
        }
        if (LRTrim(valueToSave.toString()) != "") {
          if (typeof(valueToSave) == "string") {
            valueToSave = Strtran(valueToSave, '--', '##x2d;##x2d;');
          }
          JSONTmpItem[propName] = valueToSave;
        }
      }
      JSONItems.push(JSONTmpItem);
      JSONTmpItem = {};
    }
  }
  strsave = JSON.stringify(JSONItems, function(s,v){if(typeof(v)!='object') return v.toString(); else return v;});
  return strsave;
}

function save2() {
  var strsave = "", url, output;
  var i, j;

  if (currentname != "") {
    strsave = getDef();
    var fieldslistname = "";
    for (i = 0; i < countindex.length; i++) {
      for (j = 0; j < itemsHTMLArray[i].length; j++) {
        fieldslistname += "|" + itemsHTMLArray[i][j].name;
      }
    }
    if (fieldslistname.length > 0) {
      fieldslistname = fieldslistname.substring(1);
    }

    var portlet_name = "";
    var folder_path = "";
    currentname = Strtran(currentname, '\\', "/");
    if (currentname.indexOf('/') > -1) {
      folder_path = currentname.substring(0, currentname.lastIndexOf("/"));
      portlet_name = currentname.substring(currentname.lastIndexOf("/") + 1);
    }
    else {
      portlet_name = currentname;
    }
    url = new JSURL("../servlet/JSPSave?type=scandoc"+
      "&name=" + portlet_name +
      "&folder_path=" + folder_path +
      "&def=" + URLenc(strsave) +
      "&m_cID=" + cmdhash, true);
    output = url.Response();
    if (window.parent.changeName) {
      window.parent.changeName(portlet_name, folder_path);
    }
    if (output == null) {
      output = "";
    }

    switch (output) {
      case "true":
        for (i = 0; i < notimooManager.elements.length; i++) {
          notimooManager.close(notimooManager.elements[i]);
        }
        if (window.parent.changeName) window.parent.changeName(portlet_name, folder_path,Strtran(window.frameElement.id,'portalstudioframe',''));
        notimooManager.show({
          title : 'Notification message',
          message : 'scandoc saved!',
          visibleTime : 2000,
          width : 200
        });
        m_bUpdated = false;
        if (typeof(window.opener) != "undefined") {
          try {
            window.opener.document.getElementById('zones_Id').submit();
          }
          catch (e) {}

          try {
            var isok = false;
            if (window.opener != null) {
              if (saveas == true) {
                if (window.opener.cbscanedit_saveas) {
                  window.opener.cbscanedit_saveas(portlet_name, window, fieldslistname);
                  isok = true;
                  saveas = false;
                }
              }
              else if (window.opener.cbscanedit_save) {
                window.opener.cbscanedit_save(portlet_name, window, fieldslistname);
                isok = true;
              }
            }

            if (!isok) {
              savePageletPortlet(portlet_name, window.opener, window);
            }
          }
          catch (e) {}
        }
        else {
          savePageletPortlet(portlet_name, window.parent);
        }
        document.title = currentname + " - Scan Editor";
        if (AfterSave == "close") {
          if (window.parent && window.parent.closeCurrentObj) { window.parent.closeCurrentObj(); }
        }
        else if (!Empty(AfterSave)) {
          AfterSave();
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
    window.parent.saveAsTool();
  }
  if (parent) { parent.is_Saving = false; }
}

function savePageletPortlet(portlet_name, win, currwin) {
  if (win.ZtVWeb != null && win.ZtVWeb != "undefined") {
    // Pagelet
    if (win.getPagelet) {
      var pagelet_id = win.getPagelet();
      if (pagelet_id != null && pagelet_id != "undefined") {
        if (saveas == true) {
          if (pagelet_id.cbscanedit_saveas) {
            pagelet_id.cbscanedit_saveas(portlet_name, currwin);
          }
        }
        else if (pagelet_id.cbscanedit_save) {
          pagelet_id.cbscanedit_save(portlet_name, currwin);
        }
      }
    }
    // Portlet
    else if (win.ZtVWeb.getPortletId) {
      var portlet_id = win.ZtVWeb.getPortletId();
      if (portlet_id != null && portlet_id != "undefined") {
        var portlet_obj = win.ZtVWeb.getPortletById(portlet_id);
        if (portlet_obj != null && portlet_obj != "undefined") {
          if (saveas == true) {
            if (portlet_obj.cbscanedit_saveas) {
              portlet_obj.cbscanedit_saveas(portlet_name, currwin);
            }
          }
          else if (portlet_obj.cbscanedit_save) {
            portlet_obj.cbscanedit_save(portlet_name, currwin);
          }
        }
      }
    }
  }
}
/* *** Fine della gestione del Save *** */

/* *** Gestione della Preview *** */
function Preview() {
  var m_bUpdated_s = m_bUpdated;
  m_bUpdated = false; // dont save before preview
  togglePreview();
  m_bUpdated = m_bUpdated_s;
}

function togglePreview() {
  scanPreview();
}

function scanPreview() {
  if (LRTrim(formProp.file) != "") {
    var url = "scanpreview.jsp";
    url += "?SPModalLayerId=previewSPModalLayer";
    openSPModalLayer(url, 40, window.getSize().w/2, 600, 600, true, 1, true);
  }
  else {
    PSAlert.alert("PDF File needed !");
  }
}

function createPreview() {
  var strsave = getDef();
  var nRec = 0;
  var url = "../servlet/JSPScanEditorPrev?pdffile=" + formProp.file + "&scandef=" + URLenc(strsave);
  var xmlobj1 = new ZtVWeb.XMLDataProvider(this, 'xmlobj1', url, '/ExtractText/zone', ' ', ' ', false);
  try {
    xmlobj1.Query();
    nRec = xmlobj1.getRecCount();
  } catch (e) { }

  var zoneName, zoneValue;
  var result = [];
  for (var n = 0; n < nRec; n++) {
    zoneName = ToHTML(getFieldDesc(xmlobj1.rs.name));
    zoneValue = ToHTML(xmlobj1.rs.field);
    zoneValue = Strtran(zoneValue, "&#10;", "<br>");
    result.push({name:zoneName,value:zoneValue});
    xmlobj1.Next();
  }
  return result;
}
/* *** Fine della gestione della Preview *** */

/* *** Gestione del caricamento dello Sca *** */
function reload(e, pdfsrc) {
  notimooManager = new Notimoo({});
  notimooManager.show({
    title : 'Notification message',
    message : 'loading scandoc ' + currentname,
    sticky : true,
    width : 200,
    height : 40
  });

  var url = new JSURL("../servlet/JSPReader?type=scandoc&name=" + currentname + "&check=true", true);
  var output = url.Response();

  if (LRTrim(output) == "found") {
    url = new JSURL("../servlet/JSPLoad?type=scandoc&name=" + currentname, true);
    var strreload = Strtran(url.Response(), '\u0080', '\u20AC');

    if (isLoading) {
      reload_(e, strreload, false, pdfsrc);
      indexUndo = -1;
      indexRedo = -1;
      undoItemsMoved = [];
      undoSequence = [];
      selectedZoombox("zoombox");
      resizeWindow(e, true);
    }
    else {
      $('loading').setStyle('opacity', 0.7).innerHTML = "Loading <span style='font-weight:bold;font-style:italic;'>" + currentname + "</span>...";
      var fnToDelayx = function () {
        reload_(e, strreload, false, pdfsrc);
        indexUndo = -1;
        indexRedo = -1;
        undoItemsMoved = [];
        undoSequence = [];
        selectedZoombox("zoombox");
        resizeWindow(e, true);
        writeDocPageHTML(true);
        $('loading').fade(0);
      };
      fnToDelayx.delay(2000);
    }
  }
  else {
    for (var i = 0; i < notimooManager.elements.length; i++) {
      notimooManager.close(notimooManager.elements[i]);
    }
    PSAlert.alert('ScanDoc not found');
    return;
  }
}
/* *** Fine della gestione del caricamento dello Sca *** */

// Funzioni di trascinamento items ####################################
var deltax = 0, deltay = 0, dx, dy; // distanze del punto di click dall origine dell item

function selectItemBarImg(itm) {
  mainitem = itm;
}

function selectItemBarField(itm) {
  selectItemBarImg(itm);
}

function editItemEvent() {
}

function openclosediv(dv1, dv2) {
  removeAllFieldHandlers();
  document.getElementById(dv1).style.display = "none";
  document.getElementById(dv2).style.display = "block";
}

function enableDocumentSelection(enable) {
  if (enable) {
    document.onselectstart = _original_onselectstart;
  }
  else {
    document.onselectstart = function () {
      return false;
    };
  }
}

/* *** Gestione della selezione *** */
// Seleziona l'item se cliccato
function clickItem(e, id_container) {
  var str = "", elementID = "", i = 0;
  multipleSelection = false;
  var element;
  if (e != null) {
    element = GetEventSrcElement(e);
    if (element.id != "") {
      elementID = Strtran(element.id, "_int", "");
      element = Ctrl(elementID);
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
  if(Empty(element)) { elementID = id_container; }
  for (i = 0; i < itemsHTMLArray[docpageindex].length; i++) {
    if (itemsHTMLArray[docpageindex][i].id == elementID) {
      last_index = null;
      itemsHTMLArray[docpageindex][i].shadow = "shadow" + elementID.substr(4);
      str = addHandlers(elementID.substr(4));
      Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str;
      selectItem(Ctrl("shadow" + elementID.substr(4)));
    }
  }
  for (i = 0; i < imgHTML.length; i++) {
    if (imgHTML[i].id == elementID) {
      selectImg(i);
      infindex = i;
    }
  }
  if (element != null) {
    if (element.id == "navmenu_tabcontainer") {
      elementID = id_container;
      for (i = 0; i < imgHTML.length; i++) {
        if (imgHTML[i].id == elementID) {
          selectImg(i);
          infindex = i;
          return;
        }
      }
    }
    else {
      for (i = 0; i < fieldHTML.length; i++) {
        if (fieldHTML[i].id == elementID) {
          selectField(i);
          return;
        }
        removeAllFieldHandlers();
      }
    }
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

function addFieldHandlers(itmIdx) {
  var itm = Ctrl("item" + itmIdx);
  var xcontent = Ctrl("fields_container_items");
  var y = getY(itm) - 1 - xcontent.scrollTop;
  var x = itm.offsetLeft + 12;
  var w = itm.offsetWidth + 6;
  var h = itm.offsetHeight + 2;
  var str = "";
  // aggiunge il div shadow+n della grandezza dell item per lo spostamento
  str += "<div id='shadow" + itmIdx + "' class='shadow' style='z-index:1010;cursor:move;color:white;position:absolute;top:" + y + "px;left:" + x + "px;width:" + w + "px;height:" + h + "px;background:url(../visualweb/images/pixeldrag.png) repeat;box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;' ondblclick='editItemEvent();' onmousedown='dragShadow2(event,this);'>";
  str += "&nbsp;";
  str += "</div>";

  var divT = document.createElement("div");
  divT.setAttribute("id", "shadow" + itmIdx);
  divT.style.zIndex = 1010;
  divT.style.cursor = "move";
  divT.style.position = "absolute";
  divT.style.top = y + "px";
  divT.style.color = "#FFFFFF";
  divT.style.left = x + "px";
  divT.style.width = w + "px";
  divT.style.height = h + "px";
  divT.className = "shadow";
  divT.innerHTML = "&nbsp;";

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
/* *** Fine della gestione della selezione *** */

/* *** Gestione dello spostamento *** */

function frem() {
  removeAllFieldHandlers();
  Ctrl("canvas").onmousedown = null;
  Ctrl("toolbarfldz").onmousedown = null;
  Ctrl("toolbarfldz").onmousemove = null;
  Ctrl("canvas").onmousemove = null;
  if(mainitem) {
    mainitem.onmouseup = null;
    mainitem.onmousedown = null;
  }
  document.onmouseup = null;
  document.onmousedown = null;
  $("canvas").setStyle('cursor', 'default');
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
  Ctrl("toolbarfldz").onmousemove = moveShadow2;
  Ctrl("canvas").onmousemove = moveShadow2;
  Ctrl("canvas").onmousedown = frem;
  Ctrl("toolbarfldz").onmousedown = frem;
  mainitem.onmousedown = frem;
  mainitem.onmouseup = frem;
  document.onmouseup = frem;
  document.onmousedown = frem;
  enableDocumentSelection(false);
  m_bUpdated = true;
  cancelEvent(e);
}

function moveShadow2(e) {
  calcPosition(e);
  dx = xpos - deltax - mainitem.offsetLeft;
  dy = ypos - deltay - mainitem.offsetTop;
  maxWidth += $("gadgets_pane").offsetWidth; //20px spazio per v_ruler module editor
  if (xpos - deltax > 0 && ypos - deltay > 0 && (ypos - deltay + mainitem.offsetHeight) < maxHeight && (mainitem.offsetWidth + xpos - deltax) < maxWidth) {
    mainitem.style.left = (xpos - deltax) + "px";
    mainitem.style.top = (ypos - deltay) + "px";
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

function setShadow2(e) {
  frem();
  var v1 = parseInt(mainitem.style.left) + parseInt(mainitem.style.width);
  var v2 = parseInt(Ctrl("backcanvas").offsetLeft);
  var w1 = parseInt(mainitem.style.top);
  var w2 = parseInt(Ctrl("backcanvas").offsetTop) + parseInt(Ctrl("backcanvas").offsetHeight);

  if (v1 > v2 && w2 > w1) {
    var itxx = "item" + mainitem.id.substr(6);
    var zname;
    for (var n = 0; n < fieldHTML.length; n++) {
    // Non ci possono essere zone duplicate
      if (itxx == fieldHTML[n].id) {
        zname = fieldHTML[n].fname;
        if (canAddZone(zname, true) == false) {
          removeAllFieldHandlers();
          enableDocumentSelection(true);
          return;
        }
      }
    }
    type = "Zone";
    putItem(e);

    var insertedItem = itemsHTMLArray[docpageindex][countindex[docpageindex] - 1];
    if (putok == true) {
      insertedItem.h = parseInt(mainitem.style.height) * clCanvasLib.scale / 100;
      insertedItem.w = parseInt(mainitem.style.width) * clCanvasLib.scale / 100;
      insertedItem.x = parseInt(mainitem.style.left) - parseInt(Ctrl("backcanvas").offsetLeft) + parseInt(Ctrl("canvas").scrollLeft);
      insertedItem.y = parseInt(mainitem.style.top) - parseInt(Ctrl("backcanvas").offsetTop) + parseInt(Ctrl("canvas").scrollTop);

      if (insertedItem.x < 0) {
        insertedItem.x = 0;
      }
      if (insertedItem.y < 0) {
        insertedItem.y = 0;
      }

      if (parseInt(insertedItem.x) + parseInt(insertedItem.w) > parseInt(Ctrl("backcanvas").offsetWidth) + parseInt(Ctrl("canvas").scrollLeft)) {
        insertedItem.w = Ctrl("backcanvas").offsetWidth - parseInt(insertedItem.x) - 3;
      }
      if (parseInt(insertedItem.y) + parseInt(insertedItem.h) > parseInt(Ctrl("backcanvas").offsetHeight) + parseInt(Ctrl("canvas").scrollTop)) {
        insertedItem.h = parseInt(Ctrl("backcanvas").offsetHeight) - parseInt(insertedItem.y) - 3;
      }

      var itx = "item" + mainitem.id.substr(6);
      for (n = 0; n < fieldHTML.length; n++) {
        if (itx == fieldHTML[n].id) {
          insertedItem.name = fieldHTML[n].fname;
          insertedItem.fieldindex = "" + (n + 1);
        }
      }
    }
  }

  removeAllFieldHandlers();
  enableDocumentSelection(true);
  writeHTML();

  if (putok) {
    clickItem(null, itemsHTMLArray[docpageindex][countindex[docpageindex] - 1].id);
  }
}

function ValidMove(x, y, w, h, id) {
  x = parseInt(x);
  y = parseInt(y);
  h = parseInt(h);
  w = parseInt(w);
  if (x < 0 || y < 0) {
    return false;
  }
  if (!Empty(id)) {
    var ctrln = Ctrl(id + "Num");
    if (ctrln) {
      ctrln.style.left = x + "px";
      ctrln.style.top = (y - ctrln.offsetHeight) + "px";
    }
  }
  return true;
}
/* *** Fine della gestione dello spostamento *** */

function togglerGadget() {
  removeAllFieldHandlers();
}


window.addEvent('domready', function () {
});
