/* exported
    Properties designToolbar updateHtmlCode
  */

  /* global modelight toolbars
*/

/* *** Gestione delle Proprieta' *** */

var last_index;
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
        tabindex : 100
      });
      newPropObj.re_openColumn();
      last_index = index;
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

/* Lanciata al momento del cambio del valore della proprieta' Name di un item.
   Ridefinita vuota per evitare errori. */
function updateHtmlCode() {
}

/* *** Gestione Toolbar *** */
function designToolbar() {
  var toolbarCtrl = [], toolbarAction = [], toolbarEdit = [];
  toolbarCtrl = ZTObjects.PSToolbarCtrl;

  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {
    if (modelight == true) {
      toolbarAction = ZTObjects.PSToolbarActionLight;
    }
    else {
      toolbarAction = ZTObjects.PSToolbarAction;
    }
  }
  toolbarEdit = ZTObjects.PSToolbarEdit;

  toolbars.ctrl = new SPToolbar(toolbarCtrl, 'sptoolbar_ctrl', {
    drop_element: 'canvas',
    elementToShow: 'all'
  });

  toolbars.align = new SPToolbar(ZTObjects.PSToolbarAlign, 'sptoolbar_align', {
    //elementToShow: 'all'
  });
  toolbars.resize = new SPToolbar(ZTObjects.PSToolbarResize, 'sptoolbar_resize', {
    //elementToShow: 'all'
  });

  toolbars.edit = new SPToolbar(toolbarEdit, 'sptoolbar_edit', {
    elementToShow: 'all'
  });
  
  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {
    toolbars.action = new SPToolbar(toolbarAction, 'sptoolbar_action', {
      elementToShow: 'all'
    });
  }
  
  toolbars.preview = new SPToolbar(ZTObjects.PSToolbarPreview, 'sptoolbar_preview', {
    elementToShow: 'all'
  });
}

/* *** Fine della Gestione Toolbar *** */
