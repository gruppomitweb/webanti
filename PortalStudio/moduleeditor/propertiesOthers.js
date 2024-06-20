/* exported designToolbar convertUnit convertUnitZoom validUnitV reconvertUnit reconvertUnitZoom
   validUnitZoomX validUnitZoomW validUnitZoomY validUnitZoomH changeToComma ApplyUnit
   convertToLowerCase validXMLName validStartNumber validFieldsStructure writemenuTab
   updateHtmlCode validXMLSignName
 */
  /* global msimplesheet convertFromPoints workunit generateRulers clCanvasLib convertInPoints
     workAreaWidth workAreaHeight tabs selectImg maxpages modelight toolbars modelightqr
  */
/* *** Gestione delle Proprieta' *** */
var last_index;
var defH = 24;
function Properties() {
  if (index != null) {
    var mainobj = itemsHTML[index];
    if (newPropObj && last_index != null && last_index == index) {
      newPropObj.updatePropertiesFromPaint(mainobj);
    }
    else if (newPropObj && !newPropObj.pSheetOpened) {
      //rimani chiuso
    }
    else {
      newPropObj = new propertiesObj({
        m_obj : mainobj,
        canExpandToColumn : true,
        tabindex : 100,
        afterRender : resizeGadgetsPane
      });
      newPropObj.re_openColumn();
      last_index = index;
    }
    var tab;
    if (msimplesheet == true) {
      tab = Ctrl("editable_field_tab");
      if (tab) { tab.style.display = 'none'; }
      tab = Ctrl("detail_fields_tab");
      if (tab) { tab.style.display = 'none'; }
      tab = Ctrl("detail_field_tab");
      if (tab) { tab.style.display = 'none'; }
      if(mainobj.type_exp == 'image' || mainobj.type_exp == 'barcode' || mainobj.type_exp == 'barcode2d') {
        tab = Ctrl("functional_tab");
      if (tab) { tab.style.display = 'none'; }
      }
    }
    else {
      tab = Ctrl("functional_tab");
      if (tab) { tab.style.display = 'none'; }
    }
    if (showProperties) {
      showProperties('properties');
    }
    else {
      newPropObj.ShowProperties();
    }
  }
  SetOnEditProp(false);
}

/* *** Gestione della validazione delle proprieta' *** */

/* Lanciata al momento del cambio del valore della proprieta' Name di un item.
   Ridefinita vuota per evitare errori.. */
function updateHtmlCode() {
}

/* Lanciata al momento del caricamento delle properties di un item.
   Calcola il valore nell'unita' di misura del disegnatore. */
function convertUnit(value) {
  value = parseFloat(value);
  return Round(convertFromPoints(value), 2);
}

/* Lanciata al momento del cambiamento di unita' di misura del disegnatore.
   Ridisegna i righelli. */
function ApplyUnit(value) {
  workunit = value;
  formProp.rulers = workunit;
  generateRulers();
  FormProperties();
  return true;
}

/* Lanciata alla visualizzazione delle proprieta' degli item.
   Calcola il valore nell'unita' di misura del disegnatore e in base allo zoom. */
function convertUnitZoom(value) {
  value = parseFloat(value);
  return Round(convertFromPoints(value) * (100 / clCanvasLib.scale), 2);
}

/* Lanciata alla visualizzazione delle proprieta' degli item.
   Calcola il valore in points in base allo zoom. */
function reconvertUnitZoom(value) {
  value = parseFloat(value);
  return convertInPoints(value) * (clCanvasLib.scale / 100);
}

/* Lanciata alla modifica della proprieta' x degli item.
   Verifica che l'item sia posizionato all'interno dell'area di lavoro. */
function validUnitZoomX(value) {
  if (index != null) {
    var item = itemsHTML[index];
    var v = parseFloat(value) + item.w;
    v = v * 100 / clCanvasLib.scale;
    if (v > workAreaWidth && workAreaWidth > 0) {
      return false;
    }
  }
  return true;
}

/* Lanciata alla modifica della proprieta' w degli item.
   Verifica che l'item sia posizionato all'interno dell'area di lavoro. */
function validUnitZoomW(value) {
  if (index != null) {
    var item = itemsHTML[index];
    var v = parseFloat(value) + item.x;
    v = v * 100 / clCanvasLib.scale;
    if (v > workAreaWidth && workAreaWidth > 0) {
      return false;
    }
  }
  return true;
}

/* Lanciata alla modifica della proprieta' y degli item.
   Verifica che l'item sia posizionato all'interno dell'area di lavoro. */
function validUnitZoomY(value) {
  if (index != null) {
    var item = itemsHTML[index];
    var v = parseFloat(value) + item.h;
    v = v * 100 / clCanvasLib.scale;
    if (v > workAreaHeight && workAreaHeight > 0) {
      return false;
    }
  }
  return true;
}

/* Lanciata alla modifica della proprieta' y degli item.
   Verifica che l'item sia posizionato all'interno dell'area di lavoro. */
function validUnitZoomH(value) {
  if (index != null) {
    var item = itemsHTML[index];
    var v = parseFloat(value) + item.y;
    v = v * 100 / clCanvasLib.scale;
    if (v > workAreaHeight && workAreaHeight > 0) {
      return false;
    }
  }
  return true;
}

/* Lanciata alla modifica della proprieta' Vertical Delta degli item Zone. */
function validUnitV(/*value*/) {
  return true;
}

/* Lanciata alla modifica della proprieta' Vertical Delta degli item Zone. */
function reconvertUnit(value) {
  value = parseFloat(value);
  return convertInPoints(value);
}

/* Lanciata alla visualizzazione delle properties di un item Zone.
   Restituisce i valori della combobox Number separator style con la virgola. */
function changeToComma(value) {
  if (typeof(value) != 'undefined') {
    return Strtran(value, ';', ',');
  }
  return '';
}

/* Lanciata alla visualizzazione delle properties di un item Zone.
   Restituisce i valori della combobox Date Format in minuscolo. */
function convertToLowerCase(value) {
  if (typeof(value) != 'undefined') {
    return value.toLowerCase();
  }
  return '';
}

/* Lanciata alla modifica della proprieta' Name degli item.
   Verifica che il valore sia un carattere alfanumerico o il carattere "_". */
function validXMLName(XMLString) {
  var ret = true;
  ret = /^[a-zA-Z0-9_]+$/.test(XMLString);
  if (ret == false) {
    PSAlert.alert(FormatMsg('Invalid name!'));
    return false;
  }
  return true;
}

function validXMLSignName(XMLString) {
  var ret = true;
  if( Empty(XMLString)) return ret;
  ret = /^[a-zA-Z0-9*]+$/.test(XMLString);
  if (ret == false) {
    PSAlert.alert(FormatMsg('Invalid name!'));
          return false;
        }
  return true;
}

/* Lanciata al cambiamento del valore della Start Number dell'Area. */
function validStartNumber(value) {
  var v = parseInt(value);
  if (v < 1) {
    PSAlert.alert("Start Number must be greater than 0.");
    return false;
  }
  return true;
}
/* *** Fine della gestione validazione dell'xml *** */

/* Lanciata al cambiamento delle proprieta' 'Fields Structure' dell'area.
   Evita che siano selezionate delle opzioni in contrasto tra loro.
*/
function validFieldsStructure(value) {
  if (index != null) {
    switch (value) {
      case 'horizontal':
        itemsHTML[index]["vreplicated"] = false;
        itemsHTML[index]["hreplicated"] = true;
        m_bUpdated = true;
        break;
      default:
        itemsHTML[index]["vreplicated"] = true;
        itemsHTML[index]["hreplicated"] = false;
        m_bUpdated = true;
        break;
    }
    Properties();
    return true;
  }
  return false;
}

/* *** Fine della gestione della validazione delle proprieta' *** */

/* *** Gestione tabs del disegnatore *** */
function writemenuTab() {
  if (!tabs) {
    tabs = new TabsMT('module_page_list', 'module_page_frame', {
      clickFunc : function (index) {
        selectImg(index);
      },
      close:false
    });
  }
  var mrpPages = countindex.length;
  var pdfPages = maxpages;
  if (mrpPages > pdfPages) {
    pdfPages = mrpPages;
  }
  var li, span, moduleFrame;
  for (var i = 0; i < pdfPages; i++) {
    moduleFrame = new Element('div', {}).inject($('module_page_frame'));
    li = new Element('li').inject($('module_page_list'));
    span = new Element('span').inject(li);
    span.set('text',('Page ' + (i + 1)));
    tabs.addTabs(li, moduleFrame);
  }
  tabs.setSelectedTab(0);
  adjustTabHeight();
}

function adjustTabHeight() {
  var fz = function() {
    if(Ctrl("module_page_list").offsetHeight != defH) {
      var dif = Ctrl("module_page_list").offsetHeight - defH;
      Ctrl("backcanvas").style.top = (Ctrl("backcanvas").offsetTop + (dif)) + "px";
      Ctrl("v_ruler").style.top = (Ctrl("v_ruler").offsetTop + (dif)) + "px";
    }
    defH = Ctrl("module_page_list").offsetHeight;
  }
  fz.delay(100);
}

/* *** Fine della Gestione tabs del disegnatore *** */

/* *** Gestione Toolbar *** */
function designToolbar() {
  var toolbarCtrl = [], toolbarAction = [], toolbarEdit = [], editToolbarFull = [];
  if (modelight == true) {
    toolbarCtrl = ZTObjects.PSToolbarCtrlEditable;
    ZTObjects.PSToolbarPredefined = [];
    ZTObjects.PSToolbarCtrlNoZone = ZTObjects.PSToolbarCtrlNotEditable;
    ZTObjects.PSToolbarPreview = [];
  }
  else if (modelightqr == true) {
    toolbarCtrl = ZTObjects.PSToolbarCtrlEditable;
    ZTObjects.PSToolbarPredefined = [];
    ZTObjects.PSToolbarCtrlNoZone = ZTObjects.PSToolbarCtrlNotEditable;
    ZTObjects.PSToolbarPreview = [];
    ZTObjects.PSToolbarQR = ZTObjects.PSToolbarLightQR;
  }
  else {
    toolbarCtrl = ZTObjects.PSToolbarCtrl;
  }

  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {
    if (modelight == true) {
      toolbarAction = ZTObjects.PSToolbarActionLight;
      editToolbarFull = ZTObjects.PSToolbarEditLight;
    }
	else if (modelightqr == true) {
      toolbarAction = ZTObjects.PSToolbarActionLightQR;
      editToolbarFull = ZTObjects.PSToolbarEditLightQR;
    }
    else {
      toolbarAction = ZTObjects.PSToolbarAction;
      //editToolbarFull = ZTObjects.PSToolbarEditFull;
    }
    toolbarEdit = ZTObjects.PSToolbarEdit;
    //editToolbarFull = ZTObjects.PSToolbarEditFull;
  }
  else {
    toolbarEdit = ZTObjects.PSToolbarEdit;
  }

  toolbars.create_ctrl = new SPMultiToolbar('spmultitoolbar_create_ctrl', {
    title: 'Create'
  });

  if (modelight == true) {
    toolbars.ctrl = new SPToolbar(toolbarCtrl, 'sptoolbar_ctrl', {
      dropElement: 'canvas',
      draggable: true,
      containerId: 'spmultitoolbar_create_ctrl',
      inMultiToolbar: true,
      title: "Editable"
    });
  }
  else {
    toolbars.ctrl = new SPToolbar(toolbarCtrl, 'sptoolbar_ctrl', {
      dropElement: 'canvas',
      draggable: true,
      containerId: 'spmultitoolbar_create_ctrl',
      inMultiToolbar: true,
      title: "Commons"
    });
  }

  if ( ZTObjects.PSToolbarCtrlNoZone.length > 0)
    if (modelight == true) {
      toolbars.ctrlnozone = new SPToolbar(ZTObjects.PSToolbarCtrlNoZone, 'sptoolbarnozone_ctrl', {
        dropElement: 'canvas',
        draggable: true,
        containerId: 'spmultitoolbar_create_ctrl',
        inMultiToolbar: true,
        title: "Not Editable"
      });
    }
    else  {
      toolbars.ctrlnozone = new SPToolbar(ZTObjects.PSToolbarCtrlNoZone, 'sptoolbarnozone_ctrl', {
        dropElement: 'canvas',
        draggable: true,
        containerId: 'spmultitoolbar_create_ctrl',
        inMultiToolbar: true,
        title: "Advanced"
      });
    }

  if ( ZTObjects.PSToolbarPredefined.length > 0)
    toolbars.ctrlpredef = new SPToolbar(ZTObjects.PSToolbarPredefined, 'sptoolbar_ctrlpredef', {
      dropElement: 'canvas',
      draggable: true,
      containerId: 'spmultitoolbar_create_ctrl',
      inMultiToolbar: true,
      title: "Page numeration"
    });

  toolbars.align = new SPToolbar(ZTObjects.PSToolbarAlign, 'sptoolbar_align', {
    //elementToShow: 'all'
  });
  toolbars.resize = new SPToolbar(ZTObjects.PSToolbarResize, 'sptoolbar_resize', {
    //elementToShow: 'all'
  });
  
  if( editToolbarFull.length > 0 ) {
    toolbars.edit_full = new SPToolbar(editToolbarFull, 'sptoolbar_edit_full', {
      elementToShow: 'all'
    });
  }

  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {
    toolbars.action = new SPToolbar(toolbarAction, 'sptoolbar_action', {
      elementToShow: 'all'
    });
  }

  toolbars.edit = new SPToolbar(toolbarEdit, 'sptoolbar_edit', {
    elementToShow: 'all'
  });

  if ( ZTObjects.PSToolbarPreview.length > 0)
  toolbars.preview = new SPToolbar(ZTObjects.PSToolbarPreview, 'sptoolbar_preview', {
    elementToShow: 'all'
  });
  
  if ( ZTObjects.PSToolbarQR && ZTObjects.PSToolbarQR.length > 0) {
	  toolbars.preview = new SPToolbar(ZTObjects.PSToolbarQR, 'sptoolbar_qr', { elementToShow: 'all'});
  }
}

/* *** Fine della Gestione Toolbar *** */
