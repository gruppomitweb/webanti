var delRowSign = null;
var curRowSign = null;
var ignoreEventClick = false;
var rowKeyProgress = [];
var rowClick = null;
var rowSignMarkKeys = [];
var myboname = null;
if (window.parent && window.parent.mboname)
  myboname = window.parent.mboname;

/* exported zbo_beforegetDocument zbo_beforeremoveDocument zbo_beforesetDocument zbo_beforeuploadDocument
    zbo_beforeaddSignMark zbo_beforeremoveSignMark zbo_getCurRowSign zbo_isRowKey
    zbo_beforeexecEvent zbo_GetSignMarksNumber zbo_GetNewRowSign zbo_PerformClick
*/

/****************************************************************************************/
//Metodi chiamati dal zboviewer e dal zpdfviewer
/****************************************************************************************/
function zbo_beforegetDocument() {}

function zbo_beforeremoveDocument() {}

function zbo_beforesetDocument(/* filename */) {}

function zbo_beforeuploadDocument( filename, signMarkArray/*, upload */) { // on upload il viewer ritorna il nome(path) del pdf che ha caricato
  rowSignMarkKeys = [];
  rowKeyProgress = [];
  for (var i = 0; i<signMarkArray.length; i++) {
    var group = signMarkArray[i].group;
    var key = signMarkArray[i].key;
    zbo_beforeaddSignMark ( key, group );
    if( zbo_addSignMark )zbo_addSignMark ( key, group, true );
  }
  bo_validateSignMarks();
}

function zbo_beforeaddSignMark ( key, group ) { //on add sign mark //loading indica se vengono aggiunti in caricamento del pdf
  if (!rowSignMarkKeys[group]) {
    rowSignMarkKeys[group] = [];
  }
  rowSignMarkKeys[group].push(key);
  var counter = parseInt(Strtran(key, group+".", ""));
  if( !rowKeyProgress[group]) {
    rowKeyProgress[group] = 1;
  }
  rowKeyProgress[group] = Math.max(rowKeyProgress[group], counter);
}

function zbo_beforeremoveSignMark ( key, group ) { //on remove sign mark
  if (!rowSignMarkKeys[group]) {
    return;
  }
  var index = rowSignMarkKeys[group].indexOf( key );
  if ( index >= 0) {
    rowSignMarkKeys[group].splice(index, 1);
  }
}

/*oggetto json rowjson - dati per la firma
  "signIdx": Proposto per indicare l'indice di presentazione delle firme
  "page" : pagina in cui si trova la firma [0..n],
  "title": titolo da mostrare sull'header di firma (Esempio: "Firma del cliente")
  "requirePosition": boolean, se true la firma richiede che il servizio di geolocalizzazione rilevi la posizione di firma
  "dateFormat": se specificato la data di firma
  "timeFormat": se specificato la data di firma
  "hideExtraText": se true la data di firma e la geolocalizzazione non vengono renderizzati nel pdf, ma solamnete scritti nel catalogo
  "obligatory": true se la firma è obbligatoria per procedere al salvataggio.
  "signKey...."
*/
function zbo_beforeexecEvent(p_cEvent) {
  //console.log('before' , p_cEvent, w_CPROWNUM, w_DPCODICE, w_DPANNOPR, w_CPROWORD, w_DPCODATT, w_DPPERSONA, w_DPFLGOBB);
  zbo_RemoveOnKeyDownEvent();
  curRowSign = zbo_getNewRowSign(false);
  if (Eq(p_cEvent,'Before row delete')) {
    delRowSign = curRowSign;
    if(ignoreEventClick == true) {
      ignoreEventClick = false;
      rowClick = null;
    }
    return;
  }
  else {
    if (Eq(p_cEvent,'Before Save Row') ) {
      if(window.parent.BoViewerUpdateSignMark) {
        window.parent.BoViewerUpdateSignMark(curRowSign);
      }
      if(ignoreEventClick == true) {
        ignoreEventClick = false;
        if( rowClick && rowClick.group == curRowSign.group)
          rowClick = null;
      }
      return;
    }

    if (Eq(p_cEvent,'Row deleted') ) {
      if(delRowSign != null) {
        if(window.parent.BoViewerRemoveSignMark) {
          window.parent.BoViewerRemoveSignMark(delRowSign);
        }
      }
      if(window.parent.BoViewerSelectSignMark) {
        window.parent.BoViewerSelectSignMark(curRowSign);
      }
    }
    else if (Eq(p_cEvent,'After Row Selected') ) {
      if ( rowClick ) {
        curRowSign.signKey = rowClick.key;
        curRowSign.group = rowClick.group;
      }
      if(window.parent.BoViewerSelectSignMark) {
        window.parent.BoViewerSelectSignMark(curRowSign);
      }
    }

    if(ignoreEventClick == true) {
      ignoreEventClick = false;
      rowClick = null;
      delRowSign = null;
    }
    delRowSign = null;
  }
}

function zbo_getCurRowSign() {
  return curRowSign;
}

function zbo_isRowKey( key, group ) {
  var ret = bo_findFromKey( key, group );
  return ret.result;
}

function zbo_performClick( key, group ) {
  if(ignoreEventClick) {
    ignoreEventClick = false;
    rowClick = null;
    return;
  }
  var ret = bo_findFromKey( key, group );
  if(window.PerformClick && ret.result && ret.rowIndex >=0) {
    ignoreEventClick = true;
    rowClick = {};
    rowClick.key = ret.key;
    rowClick.group = ret.group;
    if(window.CurrentRow && (window.CurrentRow() != ret.rowIndex))
      window.PerformClick(null, ret.rowIndex);
  }
}

function zbo_getNewRowSign(progress) {
  var rowSign = {};
  var rowkey = zbo_MakeRowKey();
  if (window.zbo_getSignMarkTitle)
    rowSign.title = window.zbo_getSignMarkTitle();
  if(window.zbo_getSignMarkObligatory)
    rowSign.obligatory = window.zbo_getSignMarkObligatory();
  if (window.zbo_getSignMarkIdx)
    rowSign.signIdx = window.zbo_getSignMarkIdx();
  if( progress )
    rowSign.signKey = rowkey + "." + bo_getRowProgress(rowkey);
  else
    rowSign.signKey = "";
  rowSign.group = rowkey;
  return rowSign;
}

/****************************************************************************************/
//Metodi ad uso interni del BO
/****************************************************************************************/
function bo_validateSignMarks() {
  if (myboname == null)
    return;
  var keys = [];
  var k;
  for(k=0; k<Rows(); k++) {
    var tr = m_oTrs[k];
    var rkey = myboname;
    for(var i=0; i<m_PrimaryKeys.length; i++) {
      if( typeof(tr[m_PrimaryKeys[i]]) != "undefined" )
        rkey = rkey + "." + tr[m_PrimaryKeys[i]];
      else
        rkey = rkey + "." + window['w_'+m_PrimaryKeys[i]];
    }
    keys.push(rkey);
  }
  var pkeys = Object.keys(rowSignMarkKeys);
  for(k=0; k<pkeys.length; k++) {
    if( keys.indexOf(pkeys[k]) < 0) {
      if(window.parent.BoViewerInvalidSignMarks) {
        window.parent.BoViewerInvalidSignMarks(rowSignMarkKeys[pkeys[k]]);
      }
      delete rowKeyProgress[pkeys[k]];
      delete rowSignMarkKeys[pkeys[k]];
    }
  }
}

function bo_getRowProgress( rowkey ) {
  if( !rowKeyProgress[rowkey]) {
    rowKeyProgress[rowkey] = 1;
  }
  else {
    rowKeyProgress[rowkey] += 1;
  }
  return rowKeyProgress[rowkey];
}

function bo_findFromKey( key , group ) {
  var ret = {};
  ret.result = false;
  ret.rowIndex = -1;
  if (myboname == null)
    return ret;
  var currentRowKey = zbo_MakeRowKey();
  if(currentRowKey == group) {
    ret.rowIndex = m_nCurrentRow;
    ret.result = true;
    ret.key = key;
    ret.group = group;
  }
  for(var k=0; !ret.result && k<Rows(); k++) {
    var tr = m_oTrs[k];
    var rkey = myboname;
    for(var i=0; i<m_PrimaryKeys.length; i++) {
      if( typeof(tr[m_PrimaryKeys[i]]) != "undefined" )
        rkey = rkey + "." + tr[m_PrimaryKeys[i]];
      else
        rkey = rkey + "." + window['w_'+m_PrimaryKeys[i]];
    }
    if(rkey == group) {
      ret.rowIndex = k;
      ret.result = true;
      ret.key = key;
      ret.group = rkey;
    }
  }
  return ret;
}

function getAllDocumentElementsWithAttribute(attribute)
{
  var matchingElements = [];
  var allElements = document.getElementsByTagName('*');
  for (var i = 0, n = allElements.length; i < n; i++)
  {
    if (allElements[i].getAttribute(attribute) !== null)
    {
      matchingElements.push(allElements[i]);
      var inMatching = getAllElementsWithAttribute(allElements[i], attribute);
      for (var j=0; j<inMatching.length; j++)
        matchingElements.push(inMatching[j]);
    }
  }
  return matchingElements;
}

function getAllElementsWithAttribute(parent, attribute)
{
  var matchingElements = [];
  var allElements = parent.childNodes;
  for (var i = 0, n = allElements.length; i < n; i++)
  {
    if (allElements[i][attribute] !== null)
    {
      matchingElements.push(allElements[i]);
      var inMatching = getAllElementsWithAttribute(allElements[i], attribute);
      for (var j=0; j<inMatching.length; j++)
        matchingElements.push(inMatching[j]);
    }
  }
  return matchingElements;
}

/****************************************************************************************/
//Metodi chiamabili dal BO - in manual code
/****************************************************************************************/
function zbo_GetSignMarksNumber ( group ) {
  if (!rowSignMarkKeys[group]) {
    return 0;
  }
  return rowSignMarkKeys[group].length;
}

function zbo_MakeRowKey() {
  if (myboname == null)
    return "";
  var ret = myboname;
  for(var i=0; i<m_PrimaryKeys.length; i++) {
    ret = ret + "." + window['w_'+m_PrimaryKeys[i]];
  }
  return ret;
}

function zbo_GetNewRowSign(progress) {
  return zbo_getNewRowSign(progress);
}

function zbo_PerformClick( key, group ) {
  return zbo_performClick( key, group )
}

function zbo_RemoveOnKeyDownEvent() {
  var htmManageKeys = getAllDocumentElementsWithAttribute("onkeydown");
  for(var i=0; i<htmManageKeys.length; i++) {
    htmManageKeys[i].onkeydown = null;
  }
}
