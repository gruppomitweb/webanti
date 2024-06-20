/* exported resultFormPropObj last_open resizeWindow DblClickCanvas setScroll setPropertiesID
    PropertiesVar initPropertiesDefaultValue updatePropertiesSelected
    GetFunctionsForExpBuilder GetVariablesForExpBuilder getFieldsOfTables
    getParametersOfQueries ExpressionBuilderReturn LoadRemoveOutput removeOutputReturn
    GetAcceptedOutputFormat NewQuery EditQuery SelectQuery AddBO LoadBO getkeyslist
    NewVdmMask EditVdmMask SelectVdmMask SelectDef SelectImage EditImage TranslateRulers
    ApplyUnit convertToPixels convertFromPixels convertToPixels2 convertFromPixels2
    convertToPixelsNoScale convertFromPixelsNoScale convertFromPointsNoScale
    convertToPointsNoScale convertToMillimeters ZoomIn ZoomOut setzoom ApplyPdf
    validSetFont validVdmMask validQuery ApplyMovingHandle validPageHF validReportHF
    validVariableName validVariableComment validQueryIndex validBOIndex validGroupOptions
    getgroupuid getcalconuid getresetonuid TranslateGroupUid ApplyGroupUidG ApplyGroupUidC
    ApplyGroupUidR validText validCoordinate LoadAttributesNV SetAttributesNamesValues
    LoadRV setRolesValues LoadKV SetBOKeysValues LoadQP SetQPValues LoadHY SetHYKeysValues
    LoadChartVF SetChartVFKeysValues Redo hightlightElementsO ReplaceAllElementsO KeyReplace
    resetSearchReplace editDesc EditUNotes EditTNotes EditEUNotes EditETNotes
    ExpressionNotesReturn checkAddGroup checkAddPageBreak checkAddDataSection
    checkHideSection checkBarsPosition designToolbar setToolbars validPrivacy validImageOptions
    validDataDangerLevel validIdentifier updateHtmlCode updateHtmlCode LoadQL setQueriesList LoadFV setCheckValues
*/
var scale = 100;
var zoomindex = 2;
var newFormPropObj = null;
var searchFormPropObj = null;
var resultFormPropObj = null;
var fieldsFormPropObj = null;
var last_index;
var last_open = true;

var search_accordion = null;

// Elenco dei formati di stampa per i quali si puo' scegliere di non stampare un'expression o una label calcolata.
var acceptedOutputFormat = [
                    ["CSV", "CSV Italian format File"],
                    ["CSVS", "CSV Standard format File"],
                    ["CSV2", "SDF format File"],
                    ["XML", "XML File"],
                    ["XMLS", "XML Structured file"],
                    ["XLS", "Excel format File (97-2003)"],
                    ["XLSX", "Excel Open XML"]
                   ];

/* *** Gestione del canvas e dei righelli *** */
function resizeWindow(/*event, res*/) {
  var ctrl = Ctrl("backcanvas");
  if (ctrl == null) {
    return;
  }

  if (document.getSize().y - ctrl.offsetTop > 0) {
    ctrl.style.height = (document.getSize().y - ctrl.offsetTop) + "px";
  }
  if (Ctrl("toolbar") != null && ctrl.offsetHeight > 20) {
    ctrl.style.height = (ctrl.offsetHeight - 20) + "px"; //altezza toolbar
  }
  if (document.body.clientWidth - $('gadgets_pane').offsetWidth > 80) {
    ctrl.style.width = (document.body.clientWidth - (($('gadgets_pane').opened ? $('gadgets_pane').offsetWidth : 0) + 60)) + "px"; //margine di 30
  }

  setCanvasScroll();
  generateRulers(reportProp.workunit);

  document.id('toolbar').setStyle('width',window.getSize().x - document.id('gadgets_pane').getSize().x - document.id('gadgets_panerightbar').getSize().x);
  document.id('toolbar').fireEvent('SPToolbarRefresh');
}

/*************************************************/
function generateRulers(workunit, maxWidth, maxHeight) {
  var ctrl = Ctrl("backcanvas");
  var ctrlC = Ctrl("canvas");

  var rapw = (getOffset(ctrlC).w * 100 / scale) / (getOffset(ctrl).w);
  var raph = (getOffset(ctrlC).h * 100 / scale) / (getOffset(ctrl).h);
  if (raph < 1) { raph = 1; }
  if (rapw < 1) { rapw = 1; }

  var ctrlz = Ctrl("h_ruler");
  if (ctrlz) {
    ctrlz.style.width = (getOffset(ctrl).w - 2) + "px";
  }
  ctrlz = Ctrl("v_ruler");
  if (ctrlz) {
    ctrlz.style.height = (getOffset(ctrl).h - 2) + "px";
  }

  //margine 30 px perche' il backcanvas ha un offset che non si spiega.

  var maxv = Math.max(raph, rapw);
  //adjustVerticalLines();
  ValidVerticalReference(formProp.pformat);
  if (maxHeight) {
    generateRulerCanvasV("v_rulerc", maxHeight + 30, workunit);
  }
  else {
    generateRulerCanvasV("v_rulerc", getOffset(Ctrl("v_ruler")).h * maxv + 30, workunit);
  }
  if (maxWidth) {
    generateRulerCanvasH("h_rulerc", maxWidth + 30, workunit);
  }
  else {
    generateRulerCanvasH("h_rulerc", getOffset(Ctrl("h_ruler")).w * maxv + 30, workunit);
  }
}

function generateRulerCanvasV(div, len, workunit) {
  if (clVRRulersLib == null) {
    clVRRulersLib = new RulersLib();
  }
  if (typeof(workunit) == "undefined") {
    workunit = reportProp.workunit;
  }
  clVRRulersLib.Init(div, workunit); // div-canvas del righello
  clVRRulersLib.SetScale(scale); //eventuale zoom
  clVRRulersLib.DrawVertical(len);
}

function generateRulerCanvasH(div, len, workunit) {
  if (clHRRulersLib == null) {
    clHRRulersLib = new RulersLib();
  }
  if (typeof(workunit) == "undefined") {
    workunit = reportProp.workunit;
  }
  clHRRulersLib.Init(div, workunit); // div-canvas del righello
  clHRRulersLib.SetScale(scale); //eventuale zoom
  clHRRulersLib.DrawHorizontal(len);
}

function initCanvas() {
  var h, w;
  Ctrl("canvaslinks").innerHTML = "";

  if (dwidth > 0) {
    w = dwidth;
    h = dheight;
  }
  else {
    return;
  }

  var propDiv = $('properties');
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

function DblClickCanvas(e) {
  e = (e) ? e : window.event;
  var downX = (e.offsetX) ? e.offsetX : (e.layerX) ? e.layerX : 0;
  var downY = (e.offsetY) ? e.offsetY : (e.layerY) ? e.layerY : 0;
  Ctrl("gridcanvas").innerHTML += '<div style="top: ' + (downY - 7) + 'px;left:' + (downX - 3) + 'px;position:absolute;">+ (' + downX + ',' + downY + ')</div>';
}

function resizecanvas() {
  var mw = Math.max(Ctrl("canvas").offsetWidth, Ctrl("canvaslinks").offsetWidth);
  var mh = Math.max(Ctrl("canvas").offsetHeight, Ctrl("canvaslinks").offsetHeight);
  if (Ctrl("canvas").offsetWidth < mw) {
    Ctrl("canvas").style.width = mw + "px";
  }
  if (Ctrl("canvas").offsetHeight < mh) {
    Ctrl("canvas").style.height = mh + "px";
  }
}

function checkMargins() {
  if (reportProp.page == 1) {
    drawImage();
  }
}

function drawImage() {
  if (clCanvasLib.container != null) {
    clCanvasLib.container.innerHTML = "";
  }
  if (dwidth > 0) {
    var w = dwidth * clCanvasLib.scale / 100;
    var h = dheight * clCanvasLib.scale / 100;
    setCanvasScroll();
    if (pdfimagesrc.length > 0) {
      clCanvasLib.DrawRectImage(pdfimagesrc, 0, 0, w, h, 0);
    }
  }
  else {
    setCanvasScroll();
  }
}

function setScroll(/*e, elem*/) {
  if (Ctrl("h_ruler")) {
    Ctrl("h_ruler").scrollLeft = Ctrl("backcanvas").scrollLeft;
  }
  if (Ctrl("v_ruler")) {
    Ctrl("v_ruler").scrollTop = Ctrl("backcanvas").scrollTop;
  }
}

function setCanvasScroll() {
  resizecanvas();
  var w_c = Math.max(Ctrl("canvas").offsetWidth, Ctrl("canvaslinks").offsetWidth);
  var h_c = Math.max(Ctrl("canvas").offsetHeight, Ctrl("canvaslinks").offsetHeight);
  var w = Ctrl("backcanvas").offsetWidth;
  var h = Ctrl("backcanvas").offsetHeight;

  if (w_c > w || h_c > h) {
    if (w_c > w) {
      Ctrl("backcanvas").style.overflowX = "auto";
    }
    else {
      Ctrl("backcanvas").scrollLeft = 0;
      Ctrl("backcanvas").style.overflowX = "hidden";
    }

    if (h_c > h) {
      Ctrl("backcanvas").style.overflowY = "auto";
    }
    else {
      Ctrl("backcanvas").scrollTop = 0;
      Ctrl("backcanvas").style.overflowY = "hidden";
    }
  }
  else {
    Ctrl("backcanvas").scrollLeft = 0;
    Ctrl("backcanvas").scrollTop = 0;
    Ctrl("backcanvas").style.overflow = "hidden";
  }
}

function adjustVerticalLines(value) {
  if (value == "A3") { // A3
    Ctrl("v_line1").style.left = Ctrl("canvas").offsetLeft + (1122 / 100) * scale + "px";
    Ctrl("v_line2").style.left = Ctrl("canvas").offsetLeft + (1587 / 100) * scale + "px";
    Ctrl("v_lineA3PortraitRef").style.left = Ctrl("v_line1").style.left;
    Ctrl("v_lineA3LandscapeRef").style.left = Ctrl("v_line2").style.left;
  }
  else if (value == "letter") { // Letter
    Ctrl("v_line1").style.left = Ctrl("canvas").offsetLeft + (812 / 100) * scale + "px";
    Ctrl("v_line2").style.left = Ctrl("canvas").offsetLeft + (1054 / 100) * scale + "px";
    Ctrl("v_lineLetterPortraitRef").style.left = Ctrl("v_line1").style.left;
    Ctrl("v_lineLetterLandscapeRef").style.left = Ctrl("v_line2").style.left;
  }
  else if (value == "legal") { // Legal
    Ctrl("v_line1").style.left = Ctrl("canvas").offsetLeft + (812 / 100) * scale + "px";
    Ctrl("v_line2").style.left = Ctrl("canvas").offsetLeft + (1345 / 100) * scale + "px";
    Ctrl("v_lineLegalPortraitRef").style.left = Ctrl("v_line1").style.left;
    Ctrl("v_lineLegalLandscapeRef").style.left = Ctrl("v_line2").style.left;
  }
  else { // A4
    Ctrl("v_line1").style.left = Ctrl("canvas").offsetLeft + (793 / 100) * scale + "px";
    Ctrl("v_line2").style.left = Ctrl("canvas").offsetLeft + (1122 / 100) * scale + "px";
    Ctrl("v_lineA4PortraitRef").style.left = Ctrl("v_line1").style.left;
    Ctrl("v_lineA4LandscapeRef").style.left = Ctrl("v_line2").style.left;
  }

  Ctrl("v_line1").style.height = Ctrl("canvas").offsetHeight + 'px';
  Ctrl("v_line2").style.height = Ctrl("canvas").offsetHeight + 'px';
  Ctrl("z_line").style.left = ((formProp.v_line * (reportProp.scale / 100)) + Ctrl("canvas").offsetLeft) + 'px';
  Ctrl("z_line").style.height = Ctrl("canvas").offsetHeight + 'px';
  Ctrl("z_lineref").style.left = Ctrl("z_line").style.left;
}
/* *** Fine Gestione del canvas e dei righelli *** */

/* *** Gestione delle proprieta' *** */
function setPropertiesID(obj) { //ricreo properties per compatibilita' con il vecchio array
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    mainObject.objClass.properties = [];
    var tab, i, ii;
    for (i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        if (typeof(tab[ii].defaultValue) == "undefined") {
          mainObject.objClass.properties.push(tab[ii].propID);
        }
        else if (((tab[ii].defaultValue + "").trim() != (mainObject[tab[ii].propID] + "").trim())) {
          if ((mainObject[tab[ii].propID] + "").trim() != "") {
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
  if (Empty(fieldsFormPropObj)) {
    fieldsFormPropObj = new propertiesObj({
      m_obj : fieldsProp,
      isForm : false,
      canExpandToColumn : false,
      divcontainer : 'fieldsproperties',
      moveDiv : false,
      afterRender : resizeGadgetsPane
    });
  }
  else {
    fieldsFormPropObj.updatePropertiesFromPaint(fieldsProp);
  }

  if (force_open && ps_props.form_closed == true) {
    togglePane();
  }
}

function Properties() {
  if (index != null) {
    var mainobj = itemsHTML[index];
    if (mainobj.name.indexOf("_Page") >= 0 || mainobj.name.indexOf("_Report") >= 0) {
      if (newPropObj != null) {
        newPropObj.HideProperties();
      }
      return;
    }
    if (checkPrintOptItem(index)) {
      var tab, i, ii;
      for (i in mainobj.objClass.newProperties) {
        tab = mainobj.objClass.newProperties[i];
        for (ii = 0; ii < tab.length; ii++) {
          if (tab[ii].propID == "print_when_change_groupuid") {
            tab[ii].type = printgroupuid;
          }
          else if (tab[ii].propID == "calculate_onuid") {
            tab[ii].type = calconuid;
          }
          else if (tab[ii].propID == "resetuid") {
            tab[ii].type = resetonuid;
          }
          else if (tab[ii].propID == "into_variable") {
            tab[ii].type = into_variable_combo;
          }
        }
      }
    }
    if (newPropObj && last_index != null && last_index == index) {
      if (mainobj.type == "Box") {
        var ctrl = Ctrl(mainobj.id);
        if (getOffset(ctrl).w - getOffset(ctrl).gapw < 0) {
          mainobj.w = getOffset(ctrl).w;
        }
        if (getOffset(ctrl).h - getOffset(ctrl).gaph < 0) {
          mainobj.h = getOffset(ctrl).h;
        }
      }
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
    }
    if (showProperties) {
      showProperties("properties");
    }
    else {
      newPropObj.ShowProperties();
    }
    last_index = index;
  }
  //SetOnEditProp(false);
}

function PropertiesVar(vobj, pos) {
  var mainobj = vobj;
  index = itemsHTML.length + pos;
  newPropObj = new propertiesObj({
    m_obj : mainobj,
    canExpandToColumn : true,
    tabindex : 100
  });

  newPropObj.re_openColumn();
  if (showProperties) {
    showProperties("properties");
  }
  else {
    newPropObj.ShowProperties();
  }

  SetOnEditProp(false);
  index = null;
}

function initPropertiesDefaultValue(obj) {
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    mainObject.objClass.properties = [];
    var tab, ii, i;
    for (i in mainObject.objClass.newProperties) {
      tab = mainObject.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        mainObject[tab[ii].propID] = tab[ii].defaultValue;
      }
    }
  }
}

function updatePropertiesSelected(the_property, isForm, value/*, updateHTML*/) {
  if (isForm) { return; }
  var i, str;
  var cxindex = index;
  var nSelectedItems;
  if (cxindex != null) {
    if (IsIE() && getInternetExplorerVersion() <= 8) {
      nSelectedItems = document.querySelectorAll(".shadow").length;
    }
    else {
      nSelectedItems = $("canvashandlers").getElementsByClassName("shadow").length;
    }
    if (nSelectedItems > 1) {
      if (!confirm("Do you want to change all selected items property?")) {
        return;
      }

      for (i = 0; i < itemsHTML.length; i++) {
        if (i != cxindex && itemsHTML[i].shadow.length > 0 && Ctrl(itemsHTML[i].shadow) != null) {
          if (typeof(itemsHTML[i][the_property]) != "undefined") {
            itemsHTML[i][the_property] = value;
            writeHTMLItemObj(itemsHTML[i]);
            if (the_property == "x" || the_property == "y" || the_property == "w" || the_property == "h") {
              unSelectItem(Ctrl(itemsHTML[i].shadow));
              str = addHandlers(itemsHTML[i].id.substr(4));
              itemsHTML[i].shadow = "shadow" + itemsHTML[i].id.substr(4);
              Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str;
              selectItem(Ctrl(itemsHTML[i].shadow));
            }
          }
        }
      }
    }
    if (itemsHTML[cxindex].id.indexOf("bar_") < 0) {
      selectItem(Ctrl(itemsHTML[cxindex].shadow));
    }
    else {
      selectBand(itemsHTML[cxindex].name);
    }
  }
}

function checkPrintOptItem(index) {
  var result = false;
  if (index != null) {
    switch(itemsHTML[index].type) {
      case "Label":
      case "Expr":
      case "Image":
      case "Barcode":
      case "Barcode2D":
      case "SignSVG":
      case "TinyHTML":
      result = true;
      break;
      default:
      result = false;
    }
  }
  return result;
}

/* *** Fine della gestione delle proprieta' *** */

/* *** Gestione dell'Expression Builder *** */
// Apertura dell'Expression Builder
function ExpressionBuilder(id) {
  var height = 400;
  var width = 600;
  var url = "../portalstudio/expression_builder.jsp?ExpressionID=" + URLenc(id) + "&callerFunction=ExpressionBuilderReturn&tool=report";
  var additionalUrl = "&expression&SPModalLayerId=expBuildSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "expression");
}

function GetFunctionsForExpBuilder() {
  //[{name:"sitepainterSqlFunctions",desc:"SitePAINTER SQL Functions",prefix:"[",postfix:"()]",functions:[["nome","parametri","descrizione lunga"],["nome2","parametri2","descrizione lunga"]]}]
  var functions = [];
  functions.push({
    name : "Functions",
    desc : "Functions",
    prefix : "",
    postfix : "()",
    functions : FuncList
  });
  return functions;
}

function GetVariablesForExpBuilder() {
  var variablesToView = [];
  var SysVariables = [];
  var ReportVariables = [];
  for (var i = 0; i < reportVariables.length; i++) {
    ReportVariables.push([reportVariables[i].name, reportVariables[i].comment, getVariablesDesc("w_" + reportVariables[i].name)]);
  }
  SysVariables = GetSystemVariablesForExpBuilder();
  variablesToView.push({
    name : "Variables",
    desc : "User Variables",
    prefix : "w_",
    postfix : "",
    functions : ReportVariables
  });
  variablesToView.push({
    name : "SysVariables",
    desc : "Report Variables",
    prefix : "",
    postfix : "",
    functions : SysVariables
  });
  return variablesToView;
}

function getFieldsOfTables() {
  //[{name:"tabella",desc:"tabellina",prefix:"tabella.",postfix:"",fields:[["nome","descrizione"],["nome2","descrizione2"]]}}]
  var fieldsOfTable = [];
  var row, fieldsArr, k;
  //query principale
  if (Trim(reportProp.query) != "") {
    fieldsArr = cachedQuery(reportProp.query);
    row = popolateRow(reportProp.query, reportProp.query, fieldsArr);
    fieldsOfTable.push(row);
  }
  for (k = 0; k < queryList.length; k++) {
    fieldsArr = cachedQuery(queryList[k]);
    row = popolateRow(queryList[k], queryList[k], fieldsArr);
    fieldsOfTable.push(row);
  }
  for (k = 0; k < boList.length; k++) {
    fieldsArr = cachedQuery(boList[k]);
    row = popolateRow(boList[k], boList[k], fieldsArr);
    fieldsOfTable.push(row);
  }
  //ordina in base alla descrizione
  //fieldsOfTable.sort(function(e1,e2) {return(e1.desc<=e2.desc?-1:1);});
  return fieldsOfTable;
}

function getParametersOfQueries() {
  //[{name:"tabella",desc:"tabellina",prefix:"tabella.",postfix:"",fields:[["nome","descrizione"],["nome2","descrizione2"]]}}]
  var parametersOfQueries = [];
  var fieldsArr, row, k;
  //query principale
  if (Trim(reportProp.query) != "") {
    fieldsArr = GetQueryParameters(reportProp.query, true);
    row = popolateRow(reportProp.query, reportProp.query, fieldsArr);
    parametersOfQueries.push(row);
  }
  for (k = 0; k < queryList.length; k++) {
    fieldsArr = GetQueryParameters(queryList[k], true);
    row = popolateRow(queryList[k], queryList[k], fieldsArr);
    parametersOfQueries.push(row);
  }
  /* I BO non hanno parametri.
     Bisogna comunque aggiungere l'array vuoto per evitare degli errori javascript nell'Expression Builder.
  */
  for (k = 0; k < boList.length; k++) {
    row = popolateRow(boList[k], boList[k], [[], [], [], [], [], []]);
    parametersOfQueries.push(row);
  }
  return parametersOfQueries;
}

function BuildExpression(index, the_property, ctrlid) { //REDIFINED
  ExpressionBuilder(ctrlid);
}

function ExpressionBuilderReturn(id, value) { //REWRITE SPReportMsk.js Method
  if (id) {
    var el = Ctrl(id);
    if (el) {
      el.value = value;
      el.focus();
    }
  }
  SetUpdated();

  if (index != null && itemsHTML[index].type == "Expr") {
    var pos = value.indexOf(".");
    if (pos > 1) {
      var fieldName = value.substr(pos + 1);
      var queryName = value.substr(0, pos);
      var fieldsArr, i;

      if (LibJavascript.Array.indexOf(queryList, queryName) >= 0 || queryName == reportProp.query) {
        fieldsArr = cachedQuery(queryName);
        for (i = 0; i < fieldsArr[0].length; i++) {
          if (fieldsArr[0][i] == fieldName.substr(2)) {
            itemsHTML[index].type_exp = decodeType(fieldsArr[2][i]);
            itemsHTML[index].len = fieldsArr[3][i];
            itemsHTML[index].dec = fieldsArr[4][i];
            i = fieldsArr[0].length;
          }
        }
      }
      else if (LibJavascript.Array.indexOf(boList, "BO:" + queryName) >= 0) {
        fieldsArr = cachedQuery("BO:" + queryName);
        for (i = 0; i < fieldsArr[0].length; i++) {
          if (fieldsArr[0][i] == fieldName.substr(2)) {
            itemsHTML[index].type_exp = decodeType(fieldsArr[2][i]);
            itemsHTML[index].len = fieldsArr[3][i];
            itemsHTML[index].dec = fieldsArr[4][i];
            i = fieldsArr[0].length;
          }
        }
      }
    }
    else if (value.indexOf("w_") == 0) { // user variables
      for (i = 0; i < reportVariables.length; i++) {
        if (("w_" + reportVariables[i].name) == value) {
          itemsHTML[index].type_exp = reportVariables[i].type_value;
          itemsHTML[index].len = reportVariables[i].len;
          itemsHTML[index].dec = reportVariables[i].dec;
          i = reportVariables.length;
        }
      }
    }
    else {
      for (i = 0; i < systemVariables.length; i++) {
        if (systemVariables[i][0] == value) {
          itemsHTML[index].type_exp = systemVariables[i][2];
          itemsHTML[index].len = systemVariables[i][3];
          itemsHTML[index].dec = systemVariables[i][4];
          i = systemVariables.length;
        }
      }
    }
  }
}
/* *** Fine Gestione dell'Expression Builder *** */

/* *** Gestione RemoveOutput *** */
function LoadRemoveOutput() {
  if (index != null) {
    var width = 200;
    var height = 200;
    var url = "../reporteditor/remove_output.jsp?objIdx=" + index + "&ExpressionValue=" + itemsHTML[index].removefromout;
    var additionalUrl = "&SPModalLayerId=removeOutputSPModalLayer";
    openNewWindow(url, additionalUrl, height, width, -1, -1);
  }
}

function removeOutputReturn(id, value) {
  SetUpdated();
  if (id != null) {
    itemsHTML[id].removefromout = value;
    Properties();
  }
  return;
}

function GetAcceptedOutputFormat() {
  return acceptedOutputFormat;
}
/* *** Fine Gestione RemoveOutput *** * /

/* *** Gestione della selezione della query *** */
function NewQuery() { //REDIFINED
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj("New", "visualquery", {});
  }
  else {
    window.open("../visualquery/index.jsp", "visualquery", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function EditQuery(index, isForm, qname) { //REDIFINED
  var query_name;
  if (!qname || Empty(qname)) {
    if (index == null || isForm == true) {
      query_name = reportProp.query;
    }
    else {
      query_name = itemsHTML[index].query;
    }
  }
  else {
    query_name = qname;
  }
  if (LRTrim(query_name) == "") {
    PSAlert.alert("No query selected.");
    return;
  }
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj(query_name, "visualquery", {});
  }
  else {
    window.open("../visualquery/index.jsp?filename=" + query_name, "visualquery", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function SelectQuery(index, isForm, ctrlid) { //REDIFINED
  SelectReportQuery(index, isForm, ctrlid);
}
/* *** Fine Gestione della selezione della query *** */

/* *** Gestione del'item BO *** */
function AddBO(BO/*, module*/) {
  if (index != null) {
    RemoveFromBOList("BO:" + itemsHTML[index].busobj);
    itemsHTML[index].busobj = BO.substring(3);
    itemsHTML[itemsHTML[index].child].busobj = BO.substring(3);
    AddToBOList(itemsHTML[index].busobj, index);
    navBO();
    resizeGadgetsPane();
    m_bUpdated = true;
    clickBand2(itemsHTML[index].id);
  }
}

function LoadBO() {
  if (index != null) {
    var height = 510;
    var width = 450;
    var url = "../jsp-system/SPVQREditorSelectBO_portlet.jsp?callerFunction=AddBO&hideLinkedTables=true";
    var additionalUrl = "&filelist&SPModalLayerId=boSPModalLayer";
    openNewWindow(url, additionalUrl, height, width, -1, -1, "filelist");
  }
}

/* Restituisce le chiavi primarie del BO. */
function getkeyslist(ind) {
  var ret = [], AllField;
  if (ind != null) {
    if (itemsHTML[ind].type.indexOf("SectBo_") == 0) {
      AllField = new JSURL("../servlet/SPReportGet?action=variableskeys&filename=BO:" + itemsHTML[ind].busobj, true);
      AllField = AllField.Response();
      if (AllField == "SECURITY_ERROR") {
        return ret;
      }
      var l_oFields = new TrsJavascript();
      l_oFields.reset();
      l_oFields.SetRow(0);
      l_oFields.BuildProperties(AllField);
      var rows = GetProperty(l_oFields, "Rows", "N");
      for (var i = 0; i < rows; i++) {
        l_oFields.SetRow(i);
        if (GetProperty(l_oFields, "desc", "C").length > 0) {
          ret.push(GetProperty(l_oFields, "alias", "C") + ":" + GetProperty(l_oFields, "desc", "C"));
        }
        else {
          ret.push(GetProperty(l_oFields, "alias", "C"));
        }
      }
    }
    else if (itemsHTML[ind].type.indexOf("AltQuery_") == 0) {
      AllField = GetQueryParameters(itemsHTML[ind].query, true);
      for (var nav_i = 0; nav_i < AllField[0].length; nav_i++) {
        if (AllField[1][nav_i].length > 0) {
          ret.push(AllField[0][nav_i] + ":" + AllField[1][nav_i]);
        }
        else {
          ret.push(AllField[0][nav_i]);
        }
      }
    }
  }
  return ret;
}
/* *** Fine della gestione della selezione del BO *** */

/* *** Gestione della selezione della vdmMask *** */
function NewVdmMask(index, isForm) { //REDIFINED
  var queryName = "";
  if (index == null || isForm == true) {
    queryName = (LRTrim(reportProp.query) != "" ? ("?queryName=" + LRTrim(reportProp.query)) : "");
  }
  else {
    queryName = (LRTrim(itemsHTML[index].query) != "" ? ("?queryName=" + LRTrim(itemsHTML[index].query)) : "");
  }
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj("New", "maskparameters", queryName == "" ? {} : {queryName:queryName});
  }
  else {
    window.open("../maskparameters/maskparameters.jsp" + queryName, "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function EditVdmMask(index, isForm) { //REDIFINED
  var vdmFile = "", queryName = "";
  if (index == null || isForm == true) {
    vdmFile = reportProp.vdmfile;
    queryName = (LRTrim(reportProp.query) != "" ? ("queryName=" + LRTrim(reportProp.query)) : "");
  }
  else {
    vdmFile = itemsHTML[index].vdmfile;
    queryName = (LRTrim(itemsHTML[index].query) != "" ? ("queryName=" + LRTrim(itemsHTML[index].query)) : "");
  }
  if (LRTrim(vdmFile) == "") {
    PSAlert.alert("No mask file selected.");
    return;
  }
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj(vdmFile, "maskparameters", queryName == "" ? {} : {queryName:queryName});
  }
  else {
    window.open("../maskparameters/maskparameters.jsp?filename=" + vdmFile + "&" + queryName, "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function SelectVdmMask(index, isForm, ctrlid) { //REDIFINED
  var width = 800;
  var height = 600;
  var url = "../portalstudio/open.jsp?tool=maskparameters&onetool=true&ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionBuilderReturn";
  var additionalUrl = "&SPModalLayerId=vdmSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1);
}
/* *** Fine Gestione della selezione della vdmMask *** */

/* *** Gestione della selezione del ChartDef *** */
function SelectDef(PortletItemIndex, isForm, ctrlid) { //REDIFINED
  if (IsIE() && getInternetExplorerVersion() <= 8) {
    var TempArray2 = new JSURL("../servlet/SPChartServlet");
    TempArray2 = TempArray2.Response();
    TempArray2 = TempArray2.split(",");
    var TempArray = [];
    for (var i = 0; i < TempArray2.length; i++) {
      if (TempArray2[i].indexOf("__temp") < 0) {
        TempArray.push(TempArray2[i]);
      }
      window.open("../visualweb/select_fields.html?rtrnobj=def&for=" + PortletItemIndex, "SelectField", "height=250,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
    }
  }
  else {
    var width = 800;
    var height = 600;
    var left = (screen.width) ? (screen.width - width) / 2 : 100;
    var top = (screen.height) ? (screen.height - height - (height / 4)) / 2 : 100;
    var url = "../portalstudio/open.jsp?tool=chart&onetool=true&ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionBuilderReturn&SPModalLayerId=chartBuildSPModalLayer";
    openSPModalLayer(url, top, left, width, height, true, 1, false, false);
  }
}
/* *** Fine della gestione della selezione del ChartDef *** */

/* *** Gestione della selezione delle immagini *** */
function SelectImage(obj) {
  //WinOpener = OpenWindow("../servlet/SPImagePicker?RootDir=images&CanInsert=S&imgnew=false&retTo=" + obj.refPropId, 550, 470, 200, 100);
  selectImage(obj.refId);
}

function EditImage(obj) {
  BuildExpression(obj.index, obj.refPropId, obj.refId);
}
/* *** Fine della gestione della selezione delle immagini *** */

/* *** Gestione dei righelli e delle unita' di misura *** */
function TranslateRulers(value) {
  if (value == "pt" || value == "px") {
    return "Points";
  }
  if (value == "mm") {
    return "Millimeters";
  }
  if (value == "cm") {
    return "Centimeters";
  }
  if (value == "pc") {
    return "Picas";
  }
  if (value == "inch") {
    return "Inches";
  }
}

function ApplyUnit(value) {
  generateRulers(value);
  reportProp.workunit = value;
  FormProperties();
  Properties();
  HightlightSelectedSpaceBar(dragBars.index);
  return true;
}

function convertToPixels(value) {
  if (reportProp.workunit == "px" || reportProp.workunit == "mm" || reportProp.workunit == "cm") {
    value = parseFloat(value) * 96 / 72;
  }
  return Round(convertToPixel(reportProp.workunit, value) * (scale / 100), 0);
}

function convertFromPixels(value) {
  if (reportProp.workunit == "px" || reportProp.workunit == "mm" || reportProp.workunit == "cm") {
    value = parseFloat(value) * 72 / 96;
  }
  return Round(convertFromPixel(reportProp.workunit, value) * (100 / scale), 0);
}

function convertToPixels2(value) {
  if (reportProp.workunit == "px" || reportProp.workunit == "mm" || reportProp.workunit == "cm") {
    value = parseFloat(value) * 96 / 72;
  }
  return Round(convertToPixel(reportProp.workunit, value) * (scale / 100), 2);
}

function convertFromPixels2(value) {
  if (reportProp.workunit == "px" || reportProp.workunit == "mm" || reportProp.workunit == "cm") {
    value = parseFloat(value) * 72 / 96;
  }
  return Round(convertFromPixel(reportProp.workunit, value) * (100 / scale), 2);
}

function convertToPixelsNoScale(value) {
  if (reportProp.workunit == "px" || reportProp.workunit == "mm" || reportProp.workunit == "cm") {
    value = parseFloat(value) * 96 / 72;
  }
  return Round(convertToPixel(reportProp.workunit, value), 2);
}

function convertFromPixelsNoScale(value) {
  if (reportProp.workunit == "px" || reportProp.workunit == "mm" || reportProp.workunit == "cm") {
    value = parseFloat(value) * 72 / 96;
  }
  return Round(convertFromPixel(reportProp.workunit, value), 2);
}

function convertFromPointsNoScale(ab) {
  if (reportProp.workunit == "mm") {
    return Round(ab / 2.834, 3);
  }
  else if (reportProp.workunit == "cm") {
    return Round(ab / 28.34, 3);
  }
  else if (reportProp.workunit == "pc") {
    return Round(ab / 12, 3);
  }
  else if (reportProp.workunit == "inch") {
    return Round(ab / 72, 3);
  }
  else {
    return ab;
  }
}

function convertToPointsNoScale(ab) {
  if (reportProp.workunit == "mm") {
    return Round(ab * 2.834, 3);
  }
  else if (reportProp.workunit == "cm") {
    return Round(ab * 28.34, 3);
  }
  else if (reportProp.workunit == "pc") {
    return Round(ab * 12, 3);
  }
  else if (reportProp.workunit == "inch") {
    return Round(ab * 72, 3);
  }
  else {
    return ab;
  }
}
/* Converte i point in millimetri. E" usata solo per la preview del report. */
function convertToMillimeters(ab) {
  var result = 0;
  result = Round((ab * 25.4 / 72), 3);
  return result;
}
/* *** Fine Gestione dei righelli e delle unita' di misura *** */

function resizezElements() {
  var itm, ctrl;
  index = null;
  selectForm();
  for (var i = 0; i < itemsHTML.length; i++) {
    itm = itemsHTML[i];
    ctrl = null;
    if (itm.id.indexOf("bar_") < 0) {
      itm.w = (itm.w * 100 / itm.scale) * (scale / 100);
      itm.h = (itm.h * 100 / itm.scale) * (scale / 100);
      itm.x = (itm.x * 100 / itm.scale) * (scale / 100);
      itm.y = (itm.y * 100 / itm.scale) * (scale / 100);
      itm.scale = scale;
      ctrl = Ctrl(itm.id);
      if (ctrl != null) {
        ctrl.style.display = "block";
        ctrl.style.left = itm.x + "px";
        ctrl.style.top = itm.y + "px";
        ctrl.style.width = itm.w + "px";
        ctrl.style.height = itm.h + "px";
      }
    }
    else {
      itm.y = (itm.y * 100 / itm.scale) * (scale / 100);
      ctrl = Ctrl(itm.id);
      if (ctrl != null) {
        ctrl.style.display = "block";
        ctrl.style.top = itm.y + "px";
      }
      itm.scale = scale;
    }
  }
}

/* *** Gestione dello zoom *** */
function GetZoomValue() {
  var zoombox = document.getElementById("zoombox_toolbar");
  if (zoombox == null) {
    zoombox = document.getElementById("zoombox");
  }
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

function ZoomIn() {
  zoomGetNextValue("zoombox");
  var fz = function () {
    var z = GetZoomValue();
    if (z > 0 && z != scale) {
      zoom(z);
    }
  }
  fz.delay(100);
}

function ZoomOut() {
  zoomGetPrevValue("zoombox");
  var fz = function () {
    var z = GetZoomValue();
    if (z > 0 && z != scale) {
      zoom(z);
    }
  }
  fz.delay(100);
}

function selectedZoombox(zoomboxid) {
  var zoombox = document.getElementById(zoomboxid);
  if (zoombox != null) {
    for (var i = 0; i < zoombox.options.length; i++) {
      if (zoombox.options[i].value == scale) {
        zoombox.options[i].selected = true;
        zoomindex = zoombox.selectedIndex;
        i = zoombox.options.length;
      }
    }
  }
}

function zoom(val) {
  scale = parseInt(val);
  resizezElements();
  Ctrl("canvas").style.width = parseInt((Ctrl("canvas").offsetWidth / reportProp.scale) * scale) + "px";
  Ctrl("canvas").style.height = parseInt((Ctrl("canvas").offsetHeight / reportProp.scale) * scale) + "px";
  generateRulers(reportProp.workunit);
  reportProp.scale = scale;
  selectedZoombox("zoombox");
  reorganizeBandList = true;
  initCanvas(false);
  if (clCanvasLib != null) {
    clCanvasLib.zoom(val);
  }
  index = null;
  writeHTML(true);
}

function setzoom() {
  var ctrl = Ctrl("backcanvas");
  if (dwidth > 0) {
    var c = (ctrl.offsetWidth / dwidth) * 100;
    var c2 = (ctrl.offsetHeight / dheight) * 100;
    if (c2 > c) {
      c = c2;
    }
    if (c > 100 && c <= 400) { //min e max zoom
      var cz = Round(c / 25, 0);
      zoom(cz * 25);
    }
  }
}
/* *** Fine functions zoom *** */

/* *** Funzioni di validazione delle singole proprieta' degli item *** */

/* Lanciata al momento del cambio del valore della proprieta' Name di un item.
   Ridefinita vuota per evitare errori.. */
function updateHtmlCode() {
}

/* Lanciata al cambiamento delle proprieta' 'Pdf File' delle ReportProperties.
   Carica il pdf selezionato come sfondo.
*/
function ApplyPdf(value) {
  reportProp.pdffile = value;
  if (LRTrim(reportProp.pdffile).length > 0) {
    LoadPdfz(reportProp.pdffile);
  }
  else {
    pdfimagesrc = "";
    initCanvas();
    forcePreviewReload = true;
  }
  return true;
}

/* Lanciata al cambiamento delle proprieta' 'Font', 'Font Size', 'Font Effect' e 'Font Style' delle ReportProperties.
   Modifica tali proprieta' per gli item in cui l'opzione Global Font e' selezionata.
*/
function validSetFont(value, prop) { //set default font to items
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i][prop] != undefined) {
      if (itemsHTML[i].global_font + "" == "true") {
        itemsHTML[i][prop] = value;
      }
      if (itemsHTML[i].page == reportProp.page) {
        refreshArray.push(itemsHTML[i]);
      }
    }
  }
  return true;
}

/* Lanciata al cambiamento della proprieta' vdmMask delle ReportProperties.
   Forza l'aggiornamento della preview.
*/
function validVdmMask(/*value*/) {
  forcePreviewReload = true;
  return true;
}

/* Lanciata al cambiamento della proprieta' query delle ReportProperties.
   Forza il ridisegno della zona navQueries del navigator.
*/
function validQuery(value) {
  if (Trim(value).length > 0) {
    reportProp.query = value;
  }
  else {
    reportProp.query = " ";
  }
  navQueries();
  resizeGadgetsPane();
  m_bUpdated = true;
  return true;
}

/* Lanciata alla selezione/deselezione della proprieta' show_movinghandle delle ReportProperties.
   Abilita o disabilita la manina.
*/
function ApplyMovingHandle(value) {
  if (value == true || value == "true") {
    reportProp.show_movinghandle = "true";
    if (index) {
      if (itemsHTML[index].type.indexOf("_top") > -1 || itemsHTML[index].type.indexOf("_bottom") > -1 || itemsHTML[index].type.indexOf("BreakPage") > -1 || itemsHTML[index].type.indexOf("AutoCover") > -1 || itemsHTML[index].type.indexOf("HtmlSection") > -1) {
        HightlightSelectedSpaceBar(index);
      }
    }
  }
  else {
    Ctrl("moveBarImg1_hand").style.display = "none";
    reportProp.show_movinghandle = "false";
    if (index) {
      if (itemsHTML[index].type.indexOf("_top") > -1 || itemsHTML[index].type.indexOf("_bottom") > -1 || itemsHTML[index].type.indexOf("BreakPage") > -1 || itemsHTML[index].type.indexOf("AutoCover") > -1 || itemsHTML[index].type.indexOf("HtmlSection") > -1) {
        HightlightSelectedSpaceBar(index);
      }
    }
  }
  return true;
}

/* Lanciata alla selezione/deselezione della proprieta' pageheadfoot delle ReportProperties.
   Aggiunge o toglie il Page Header/Footer.
*/
function validPageHF(value) {
  var i = 0;
  if (indexUndo>-1) {
    var prevUndo = undoSequence[indexUndo];
    if (prevUndo[0].obj.id.indexOf("PageHeader") > -1 && (prevUndo[0].action == "add" || prevUndo[0].action == "delete")) {
      reportProp.pageheadfoot = value;
      Undo();
      return;
    }
  }
  if (value == true || value == "true") { //PageHeader non presente
    var PageHeadExists = false;
    var cpage, y = 0;
    //Verifico se il PageHeader e' presente comunque.
    for (i = 0; i < bandList.length; i++) {
      if (bandList[i].type == "HeaderBar_top") {
        PageHeadExists = true;
        i = bandList.length;
      }
    }
    if (!PageHeadExists) {
      reportProp.pageheadfoot = true;
      // Non e' presente il Report Header.
      if ((reportProp.reportheadfoot + "" == "false")) {
        cpage = reportProp.page;
        reportProp.page = 1;
        // Sposto tutti gli item presenti nel report piu' in basso.
        shiftBar(y);
        // Aggiungo il Page Header
        type = "HeaderBar_top";
        putItem(null, true);
        // putItem esegue la calcPosition(e), quindi si deve cambiare la coordinata y del Page Header "a mano" e solo poi inserire l'add del Page Header in undoItemsMoved
        y = 35;
        itemsHTML[countindex - 1].y = y;
        // Per evitare di cambiare l'algoritmo di Undo, si inserisce l'add del Page Header in prima posizione di undoItemsMoved
        undoItemsMoved.splice(0, 0, new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h));
        // Aggiungo il Page Footer
        type = "HeaderBar_bottom";
        putItem(null, true);
        y = seekLastY() + 15;
        itemsHTML[countindex - 1].y = y;
        undoItemsMoved.push(new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h));
        reportProp.page = cpage;
        insertIntoUndoSequence();
        removeAllHandlers();
        reorganizeBandList = true;
        writeHTML();
      }
      else {
        var foundReportHeader = false;
        for (i = 0; i < bandList.length && !foundReportHeader; i++) {
          if (bandList[i].id == "bar_ReportHeader_start") {
            cpage = reportProp.page;
            reportProp.page = 1;
            y = parseInt(bandList[i].y);
            // Sposto tutti gli item presenti nel report piu' in basso.
            shiftBar(y + 1);
            // Aggiungo il Page Header
            type = "HeaderBar_top";
            putItem(null, true);
            // putItem esegue la calcPosition(e), quindi si deve cambiare la coordinata y del Page Header "a mano" e solo poi inserire l'add del Page Header in undoItemsMoved
            itemsHTML[countindex - 1].y = y + 20;
            // Per evitare di cambiare l'algoritmo di Undo, si inserisce l'add del Page Header in prima posizione di undoItemsMoved
            undoItemsMoved.splice(0, 0, new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h));
            y = itemsHTML[bandList[i].child].y;
            shiftBar(y - 1);
            //Aggiungo il Page Footer
            type = "HeaderBar_bottom";
            putItem(null, true);
            itemsHTML[countindex - 1].y = y;
            undoItemsMoved.push(new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h));
            reportProp.page = cpage;
            insertIntoUndoSequence();
            foundReportHeader = true;
          }
        }
        removeAllHandlers();
        reorganizeBandList = true;
        writeHTML();
      }
    }
  }
  else { //PageHeader presente
    for (i = 0; i < bandList.length; i++) {
      if (bandList[i].type == "HeaderBar_top" || bandList[i].type == "HeaderBar_bottom") {
        bandList[i].shadow = "todelete";
      }
      if (bandList[i].type == "ReportBar_top" || bandList[i].type == "ReportBar_bottom") {
        bandList[i].shadow = "";
      }
    }
    reportProp.pageheadfoot = false;
    deleteItem(true);
  }
  type = null;
  return true;
}

/* Lanciata alla selezione/deselezione della proprieta' reportheadfoot delle ReportProperties.
   Aggiunge o toglie il Report Header/Footer.
*/
function validReportHF(value) {
  var i = 0;
  if (indexUndo>-1) {
    var prevUndo = undoSequence[indexUndo];
    if (prevUndo[0].obj.id.indexOf("ReportHeader") > -1 && (prevUndo[0].action == "add" || prevUndo[0].action == "delete")) {
      reportProp.reportheadfoot = value;
      Undo();
      return;
    }
  }
  if (value == true || value == "true") { //ReportHeader non presente
    var ReportHeadExists = false;
    var cpage, y = 0;
    //Verifico se il ReportHeader e' presente comunque.
    for (i = 0; i < bandList.length; i++) {
      if (bandList[i].type == "ReportBar_top") {
        ReportHeadExists = true;
        i = bandList.length;
      }
    }
    if (!ReportHeadExists) {
      cpage = reportProp.page;
      reportProp.page = 1;
      reportProp.reportheadfoot = true;
      // Sposto tutti gli item presenti nel report piu' in basso.
      shiftBar(y);
      // Aggiungo il Report Header
      type = "ReportBar_top";
      y = 35;
      putItem(null, true);
      // putItem esegue la calcPosition(e), quindi si deve cambiare la coordinata y del Report Header "a mano" e solo poi inserire l'add del Report Header in undoItemsMoved
      itemsHTML[countindex - 1].y = y;
      // Per evitare di cambiare l'algoritmo di Undo, si inserisce l'add del Report Header in prima posizione di undoItemsMoved
      undoItemsMoved.splice(0, 0, new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h));
      // Aggiungo il Report Footer
      type = "ReportBar_bottom";
      putItem(null, true);
      y = seekLastY() + 15;
      itemsHTML[countindex - 1].y = y;
      undoItemsMoved.push(new ZTObjects.undoObj(itemsHTML[countindex - 1].id, "add", itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1].x, itemsHTML[countindex - 1].y, itemsHTML[countindex - 1], itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h, itemsHTML[countindex - 1].w, itemsHTML[countindex - 1].h));
      reportProp.page = cpage;
      insertIntoUndoSequence();
    }
    removeAllHandlers();
    writeHTML();
  }
  else {
    for (i = 0; i < bandList.length; i++) {
      if (bandList[i].type == "ReportBar_top" || bandList[i].type == "ReportBar_bottom") {
        bandList[i].shadow = "todelete";
      }
      if (bandList[i].type == "HeaderBar_top" || bandList[i].type == "HeaderBar_bottom") {
        bandList[i].shadow = "";
      }
    }
    reportProp.reportheadfoot = false;
    deleteItem(true);
  }
  type = null;
  return true;
}

/* Lanciata al cambiamento della proprieta' pformat delle ReportProperties.
   Visualizza le vertical reference del formato di stampa selezionato.
*/
function ValidVerticalReference(value) {
  if (value == "A3") {
    Ctrl("v_lineA4PortraitRef").hide();
    Ctrl("v_lineA4LandscapeRef").hide();
    Ctrl("v_lineLetterPortraitRef").hide();
    Ctrl("v_lineLetterLandscapeRef").hide();
    Ctrl("v_lineLegalPortraitRef").hide();
    Ctrl("v_lineLegalLandscapeRef").hide();
    Ctrl("v_lineA3PortraitRef").show();
    Ctrl("v_lineA3LandscapeRef").show();
  }
  else if (value == "letter") {
    Ctrl("v_lineA4PortraitRef").hide();
    Ctrl("v_lineA4LandscapeRef").hide();
    Ctrl("v_lineLetterPortraitRef").show();
    Ctrl("v_lineLetterLandscapeRef").show();
    Ctrl("v_lineLegalPortraitRef").hide();
    Ctrl("v_lineLegalLandscapeRef").hide();
    Ctrl("v_lineA3PortraitRef").hide();
    Ctrl("v_lineA3LandscapeRef").hide();
  }
  else if (value == "legal") {
    Ctrl("v_lineA4PortraitRef").hide();
    Ctrl("v_lineA4LandscapeRef").hide();
    Ctrl("v_lineLetterPortraitRef").hide();
    Ctrl("v_lineLetterLandscapeRef").hide();
    Ctrl("v_lineLegalPortraitRef").show();
    Ctrl("v_lineLegalLandscapeRef").show();
    Ctrl("v_lineA3PortraitRef").hide();
    Ctrl("v_lineA3LandscapeRef").hide();
  }
  else {
    Ctrl("v_lineA4PortraitRef").show();
    Ctrl("v_lineA4LandscapeRef").show();
    Ctrl("v_lineLetterPortraitRef").hide();
    Ctrl("v_lineLetterLandscapeRef").hide();
    Ctrl("v_lineLegalPortraitRef").hide();
    Ctrl("v_lineLegalLandscapeRef").hide();
    Ctrl("v_lineA3PortraitRef").hide();
    Ctrl("v_lineA3LandscapeRef").hide();
  }
  adjustVerticalLines(value);
  return true;
}

/* Lanciata al cambiamento della proprieta' name di una variabile.
   Verifica che non esistano altre variabili con quel nome e la crea. Altrimenti restituisce un avviso.
*/
function validVariableName(value) {
  if (currVar != null) {
    //Verifica se la variabile e' gia' presente nell'array delle variabili
    var found = false;
    for (var i = 0; i < reportVariables.length && !found; i++) {
      if (i != currVar) {
        if (LRTrim(value) == LRTrim(reportVariables[i].name)) {
          found = true;
        }
      }
    }
    //Se la variabile non esiste, la crea.
    if (!found) {
      updateVariable(reportVariables[currVar].name, value);
      reportVariables[currVar].name = value;
      var selectedField = Ctrl("variableList").childNodes[currVar].firstChild.childNodes;
      selectedField[1].set('html', htmlVariable(reportVariables[currVar]));
      selectedField[1].set('title', tooltipVariable(reportVariables[currVar]));
      remapIntoVariableCombo();
      return true;
    }
    else {
      PSAlert.alert("Variable already defined!!!");
    }
  }
  return false;
}

/* Lanciata al cambiamento della proprieta' comment di una variabile.
   Cambia il tooltip e il nome della variabile in UserVariables.
*/
function validVariableComment(value) {
  if (currVar != null) {
    reportVariables[currVar].comment = value;
    var selectedField = Ctrl("variableList").childNodes[currVar].firstChild.childNodes;
    selectedField[1].set('html', htmlVariable(reportVariables[currVar]));
    selectedField[1].set('title', tooltipVariable(reportVariables[currVar]));
  }
  return true;
}

/* Lanciata al cambiamento della proprieta' query di chart e Alternative Query.
   Forza il ridisegno della zona navQueries del navigator.
*/
function validQueryIndex(value) {
  if (index == null) {
    return true;
  }
  if (Trim(value).length > 0) {
    RemoveFromQueryList(itemsHTML[index].query);
    itemsHTML[index].query = value;
    if (typeof(itemsHTML[index].child) != 'undefined') {
      itemsHTML[itemsHTML[index].child].query = value;
    }
    AddToQueryList(itemsHTML[index].query, index);
  }
  else {
    RemoveFromQueryList(itemsHTML[index].query);
    itemsHTML[index].query = "";
    if (typeof(itemsHTML[index].child) != 'undefined') {
      itemsHTML[itemsHTML[index].child].query = "";
    }
  }
  navQueries();
  resizeGadgetsPane();
  m_bUpdated = true;
  return true;
}

/* Lanciata al cambiamento della proprieta' busobj del BO.
   Forza il ridisegno della zona navBO del navigator.
*/
function validBOIndex(value) {
  if (index == null) {
    return true;
  }
  if (Trim(value).length > 0) {
    RemoveFromBOList("BO:" + itemsHTML[index].busobj);
    itemsHTML[index].busobj = value;
    itemsHTML[itemsHTML[index].child].busobj = value;
    AddToBOList(itemsHTML[index].busobj,index);
  }
  else {
    RemoveFromBOList("BO:" + itemsHTML[index].busobj);
    itemsHTML[index].busobj = "";
    itemsHTML[itemsHTML[index].child].busobj = "";
  }
  navBO();
  resizeGadgetsPane();
  m_bUpdated = true;
  return true;
}

/* Lanciata al cambiamento di una proprieta' di un elemento di tipo barra.
   Applica la modifica del valore della proprieta' anche alla chiusura.
*/
function validBarProperty(value, prop) {
  if (index != null) {
    var result = true;
    if (prop == "output_name") {
      result = validXMLName(value);
    }
    if (result) {
      itemsHTML[index][prop] = value; // non settare - poi verra' settato nella updateproperties
      itemsHTML[itemsHTML[index].child][prop] = value;
      //reorganizeBandList = true; // non settare - non serve disegnare di nuovo tutte le barre
      m_bUpdated = true;
    }
    else {
      return false;
    }
  }
  return true;
}

/* Lanciata al cambiamento delle proprieta' 'Options' del gruppo.
   Evita che siano selezionate delle opzioni in contrasto tra loro.
   In particolare:
    * se e' selezionato 'As Page Header', non puo' essere selezionato 'Reprint Header'
    * se e' selezionato 'Reprint Header', non puo' essere selezionato 'As Page Header'
    * se e' selezionato 'As Page Footer', non puo' essere selezionato 'Reprint Footer'
    * se e' selezionato 'Reprint Footer', non puo' essere selezionato 'As Page Footer'
    * se non e' selezionato 'Start each group on a new page', non possono essere selezionati 'Reprint Header' e 'As Page Header'
    * se non e' selezionato 'Print group footer', non possono essere selezionati 'Reprint Footer' e 'As Page Footer'
    * se e' selezionato 'Print group footer', deve essere selezionato 'Start each group on a new page'
*/
function validGroupOptions(value, prop) {
  if (index != null) {
    validBarProperty(value, prop);
    switch(prop) {
      case 'start_each_on_page':
        if (value == false) {
          validBarProperty(false, 'as_page_header');
          validBarProperty(false, 'print_group_footer');
          validBarProperty(false, 'as_page_footer');
        }
        break;
      case 'as_page_header':
        if (value == true) {
          validBarProperty(true, 'start_each_on_page');
          validBarProperty(false, 'reprint_header');
        }
        break;
      case 'reprint_header':
        if (value == true) {
          validBarProperty(false, 'as_page_header');
        }
        break;
      case 'print_group_footer':
        if (value == false) {
          validBarProperty(false, 'as_page_footer');
        }
        else {
          validBarProperty(true, 'start_each_on_page');
        }
        break;
      case 'as_page_footer':
        if (value == true) {
          validBarProperty(true, 'print_group_footer');
          validBarProperty(false, 'reprint_footer');
        }
        break;
      case 'reprint_footer':
        if (value == true) {
          validBarProperty(false, 'as_page_footer');
        }
        break;
    }
    Properties();
    return true;
  }
  return false;
}

function getgroupuid() {
  return printgroupuid;
}

function getcalconuid() {
  return calconuid;
}

function getresetonuid() {
  return resetonuid;
}

/* Visualizza il name o il comment di un gruppo nella proprieta' 'Print when this group change', 'Reset on', 'Calculate on' di label ed expression.
*/
function TranslateGroupUid(value) {
  if (value == '' || value == 'each record' || value == 'end of report' || value == 'end of page') {
    return value;
  }
  var obj;
  for (var i = 0; i < bandList.length; i++) {
    obj = bandList[i];
    if (obj.type == 'Group_top') {
      if (obj.uid == value) {
        return getDescBand(obj, 15, false);
      }
    }
  }
  return value;
}

/* Lanciata al cambiamento della proprieta' 'Print when change group' di un'espressione o di una label.
   Salva nella proprieta' 'print_when_change_group' l'espressione del gruppo selezionato.
*/
function ApplyGroupUidG(value) {
  return ApplyGroupUid(value, "print_when_change_group");
}
/* Lanciata al cambiamento della proprieta' 'Calculate On' di un'espressione.
   Salva nella proprieta' 'calculate_on' l'espressione del gruppo selezionato.
*/
function ApplyGroupUidC(value) {
  return ApplyGroupUid(value, "calculate_on");
}

/* Lanciata al cambiamento della proprieta' 'Reset' di un'espressione.
   Salva nella proprieta' 'reset' l'espressione del gruppo selezionato.
*/
function ApplyGroupUidR(value) {
  return ApplyGroupUid(value, "reset");
}

/* Riceve come parametro l'uid del gruppo selezionato, cerca la sua espressione e la inserisce nella proprieta' dell'item selezionato che arriva come parametro. */
function ApplyGroupUid(value, property_name) {
  if (index != null) {
    if (value == '' || value == 'each record' || value == 'end of report' || value == 'end of page') {
      itemsHTML[index][property_name] = value;
    }
    else {
      var obj;
      for (var i = 0; i < bandList.length; i++) {
        obj = bandList[i];
        if (obj.type == 'Group_top') {
          if (obj.uid == value) {
            itemsHTML[index][property_name] = obj.exp;
            i = itemsHTML.length;
          }
        }
      }
    }
  }
  return true;
}

/* Lanciata al cambiamento della proprieta' value di una label.
   Allarga la label di tipo costante.
*/
function validText(value) {
  if (index != null && itemsHTML[index].type=='Label' && itemsHTML[index].text_type=='constant') {
    enlargeItem(itemsHTML[index], value);
  }
  return true;
}

/* Lanciata al cambiamento della proprieta' x,y,w,h degli item.
   Se il valore e' negativo, non lascia procedere.
*/
function validCoordinate(value) {
  if (value < 0) {
    return false;
  }
  return true;
}

/* Lanciata al cambiamento della proprieta' outputName degli item.
   Verifica che il valore sia accettabile in xml. Altrimenti non lascia procedere.
*/
function validXMLName(XMLString) {
  var ret = true;
  if (LRTrim(XMLString) == "") { return true; }
  ret = /^[a-zA-Z0-9_ ]+$/.test(XMLString);
  if (ret == false) {
    PSAlert.alert(FormatMsg('Invalid outputName!'));
    return false;
  }
  return true;
}

/* Lanciata al cambiamento delle proprieta' 'Style' dell'immagine.
   Evita che siano selezionate delle opzioni in contrasto tra loro.
   In particolare:
    * se e' selezionato 'Scale image to frame size', non puo' essere selezionato 'Clip image to frame size'
    * se e' selezionato 'Clip image to frame size', non puo' essere selezionato 'Scale image to frame size'
*/
function validImageOptions(value, prop) {
  if (index != null) {
    switch(prop) {
      case 'scale_to_frame_size':
        if (value == true) {
          itemsHTML[index]['clip_to_frame_size'] = false;
        }
        break;
      case 'clip_to_frame_size':
        if (value == true) {
          itemsHTML[index]['scale_to_frame_size'] = false;
          itemsHTML[index]['keep_proportions'] = false;
          itemsHTML[index]['circle_to_frame_size'] = false;
        }
        break;
    }
    Properties();
    return true;
  }
  return false;
}

/* Lanciata al cambiamento della proprieta' privacy degli item.
   Verifica che il valore sia accettabile in xml. Altrimenti non lascia procedere.
*/
function validPrivacy( value ) {
  if (index != null) {
    itemsHTML[index].privacy = value;
  }
  if ( value > 0 ) {
    reportProp.contentprivacy++;
  }
  else {
    reportProp.contentprivacy--;
  }
  return true;
}

function validDataDangerLevel(value) {
  if (index != null) {
    itemsHTML[index].data_danger_level = value;
  }
  if ( value > 0 ) {
    reportProp.contentprivacy++;
  }
  else {
    reportProp.contentprivacy--;
  }
  return true;
}

function validIdentifier(value) {
  if (index != null) {
    itemsHTML[index].identifier = value;
  }
  if ( !Empty(value)) {
    reportProp.contentprivacy++;
  }
  else {
    reportProp.contentprivacy--;
  }
  return true;
}

/* *** Fine delle funzioni di validazione delle singole proprieta' degli item *** */

/* *** Gestione del Attributi-Valori del Report *** */
function LoadAttributesNV() {
  var height = 500;
  var width = 600;
  var url = "../portalstudio/keysvalues_edit.html?keyFunc=getAttributesKeys&valFunc=getAttributesValues&callerFunction=SetAttributesNamesValues&separator=,&objIdx=" + "null" + "";
  var additionalUrl = "&Attributes_Values_Edit&SPModalLayerId=attrSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "Attributes_Values_Edit");
}

function SetAttributesNamesValues(objindex, keys, values) {
  if (objindex == null) {
    reportProp.attributes_name = keys;
    reportProp.attributes_value = values;
    FormProperties();
  }
}
/* *** Fine della gestione del Attributi-Valori del Report *** */

/* *** Gestione dei Queries list *** */
function LoadQL() {
  var height = 500;
  var width = 600;
  var url = "../portalstudio/listvalues_edit.html?valFunc=getQueriesList&callerFunction=setQueriesList&separator=;&objIdx=null";
  var additionalUrl = "&Keys_Values_Edit&SPModalLayerId=klSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "Keys_Values_Edit");
}

function setQueriesList(index, str) {
  reportProp.queries_list = str;
  FormProperties();
}

/* *** Gestione dei Ruoli *** */
function LoadRV() {
  var height = 500;
  var width = 600;
  var url = "../portalstudio/listvalues_edit.html?valFunc=getRolesValues&callerFunction=setRolesValues&separator=,&objIdx=null";
  var additionalUrl = "&Keys_Values_Edit&SPModalLayerId=kvSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "Keys_Values_Edit");
}

function setRolesValues(index, str) {
  reportProp.security_roles = str;
  FormProperties();
}

/* *** Gestione Check *** */
function LoadFV() {
  var height = 500;
  var width = 600;
  var url = "../portalstudio/listvalues_edit.html?valFunc=getCheckValues&callerFunction=setCheckValues&separator=;&objIdx=null";
  var additionalUrl = "&editExpression=true&SPModalLayerId=lvSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "Values_Edit");
}

function setCheckValues(index, str) {
  reportProp.check_values = str;
  FormProperties();
}

/* *** Fine della gestione dei Ruoli *** */

/* *** Gestione del Keys-Values del BO *** */
function LoadKV() {
  if (index != null) {
    var height = 500;
    var width = 600;
    var url = "../portalstudio/keysvalues_edit.html?keyFunc=getKeys&valFunc=getValues&callerFunction=SetBOKeysValues&separator=#&objIdx=" + index + "";
    var additionalUrl = "&Keys_Values_Edit&SPModalLayerId=kvSPModalLayer";
    openNewWindow(url, additionalUrl, height, width, -1, -1, "Keys_Values_Edit");
  }
}

function SetBOKeysValues(objindex, keys, values) {
  if (objindex != null) {
    itemsHTML[objindex].value_key = keys;
    itemsHTML[objindex].value_expr = values;
    itemsHTML[itemsHTML[objindex].child].value_key = keys;
    itemsHTML[itemsHTML[objindex].child].value_expr = values;
    Properties();
  }
}
/* *** Fine della gestione del KeysValue del BO *** */

/* *** Gestione del Parameters-Values delle AltQuery *** */
function LoadQP() {
  if (index != null) {
    var height = 500;
    var width = 600;
    var url = "../portalstudio/keysvalues_edit.html?keyFunc=getQPKeys&valFunc=getQPValues&callerFunction=SetQPValues&separator=#&objIdx=" + index + "";
    var additionalUrl = "&Parameters_Values_Edit&SPModalLayerId=qpSPModalLayer";
    openNewWindow(url, additionalUrl, height, width, -1, -1, "Parameters_Values_Edit");
  }
}

function SetQPValues(objindex, keys, values) {
  if (objindex != null) {
    itemsHTML[objindex].value_params = keys;
    itemsHTML[objindex].value_expr = values;
    Properties();
  }
}
/* *** Fine della gestione Parameters-Values delle AltQuery *** */

/* *** Gestione del link_parameters-link_parameters_value di Expression, Label, Image, Chart *** */
function LoadHY() {
  if (index != null) {
    var height = 420;
    var width = 630;
    var url = "../portalstudio/keysvalues_edit.html?keyFunc=getKeys&valFunc=getValues&callerFunction=SetHYKeysValues&separator=,&objIdx=" + index + "";
    var additionalUrl = "&Parameters_Values_Edit&SPModalLayerId=hySPModalLayer";
    openNewWindow(url, additionalUrl, height, width, -1, -1, "Parameters_Values_Edit");
  }
}

function SetHYKeysValues(objindex, keys, values) {
  if (objindex != null) {
    itemsHTML[objindex].link_parameters = keys;
    itemsHTML[objindex].link_parameters_value = values;
    Properties();
  }
}
/* *** Fine Gestione del link_parameters-link_parameters_value di Expression, Label, Image, Chart *** */

/* *** Fine Gestione del value_labels-value_fields dei Chart *** */
function LoadChartVF() {
  if (index != null) {
    var height = 400;
    var width = 600;
    var url = "../portalstudio/keysvalues_edit.html?keyFunc=getKeysLabels&valFunc=getValuesFields&callerFunction=SetChartVFKeysValues&separator=#&objIdx=" + index + "";
    var additionalUrl = "&resizable=yes&expression&SPModalLayerId=chartSPModalLayer";
    openNewWindow(url, additionalUrl, height, width, -1, -1, "Label_Fields_Edit");
  }
}

function SetChartVFKeysValues(objindex, keys, values) {
  if (objindex != null) {
    itemsHTML[objindex].value_labels = keys;
    itemsHTML[objindex].value_fields = values;
    Properties();
  }
}
/* *** Fine Gestione del value_labels-value_fields dei Chart *** */

function enlargeItem(itm, value) {
  var w = textSize(itm, value) - 5;
  var w2 = (itm.w * 100 / itm.scale);
  if (w > w2) {
    /* Richiesta di Greg: allargare del 10% le label costanti alla modifica del testo.
       Questo senza chiedere nulla all'utente.
    */
    itm.w = (w * 110 / 100 ) * itm.scale / 100;
  }
}

/* *** Gestione dell'Undo e del Redo *** */
function Undo() {
  if (indexUndo > -1) {
    var prevUndo = undoSequence[indexUndo]; // sequenza prev
    var l = 0, idx = 0, obj;
    if (prevUndo[0].action == 'move') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].obj) {
          obj = prevUndo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTML.length; idx++) {
            if (prevUndo[l].id == itemsHTML[idx].id) {
              obj = itemsHTML[idx];
            }
          }
        }
        if (obj) {
          obj.x = (prevUndo[l].x_init / prevUndo[l].scale) * formProp.scale;
          obj.y = (prevUndo[l].y_init / prevUndo[l].scale) * formProp.scale;
          obj.h = (prevUndo[l].h / prevUndo[l].scale) * formProp.scale;
          obj.w = (prevUndo[l].w / prevUndo[l].scale) * formProp.scale;
          obj.scale = formProp.scale;
        }
      }
    }
    else if (prevUndo[0].action == 'resize') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].obj) {
          obj = prevUndo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTML.length; idx++) {
            if (prevUndo[l].id == itemsHTML[idx].id) {
              obj = itemsHTML[idx];
            }
          }
        }
        if (obj) {
          obj.h = (prevUndo[l].h_init / prevUndo[l].scale) * formProp.scale;
          obj.w = (prevUndo[l].w_init / prevUndo[l].scale) * formProp.scale;
          if (!Empty(prevUndo[l].x_init)) { obj.x = (prevUndo[l].x_init / prevUndo[l].scale) * formProp.scale; }
          if (!Empty(prevUndo[l].y_init)) { obj.y = (prevUndo[l].y_init / prevUndo[l].scale) * formProp.scale; }
          obj.scale = formProp.scale;
        }
      }
    }
    else if (prevUndo[0].action == 'delete') {
      for (l = 0; l < prevUndo.length; l++) {
        itemsHTML[itemsHTML.length] = prevUndo[l].obj;
        countindex++;
        itemsHTML[countindex - 1].x = (prevUndo[l].x_init / prevUndo[l].scale) * formProp.scale;
        itemsHTML[countindex - 1].y = (prevUndo[l].y_init / prevUndo[l].scale) * formProp.scale;
        itemsHTML[countindex - 1].h = (prevUndo[l].h / prevUndo[l].scale) * formProp.scale;
        itemsHTML[countindex - 1].w = (prevUndo[l].w / prevUndo[l].scale) * formProp.scale;
        itemsHTML[countindex - 1].scale = formProp.scale;
        if (itemsHTML[countindex - 1].type == 'Chart') {
          AddToQueryList(itemsHTML[countindex - 1].query,(countindex-1));
          navQueries();
        }

        if (itemsHTML[countindex - 1].id.indexOf("bar_") == 0) {
          if (itemsHTML[countindex - 1].id.indexOf("break") < 0 && itemsHTML[countindex - 1].id.indexOf("cover") < 0 && itemsHTML[countindex - 1].id.indexOf("html") < 0) {
            //suppongo top prima di down
            if (itemsHTML[countindex - 1].id.indexOf("_start") >= 0) {
              itemsHTML[countindex - 1].child = countindex;
            }
            else {
              itemsHTML[countindex - 1].child = countindex - 2;
            }
          }
          //Aggiungo di nuovo le query e i BO nel navigator
          if (itemsHTML[countindex - 1].type == 'AltQuery_top' || itemsHTML[countindex - 1].type == 'AltQuery_down') {
            AddToQueryList(itemsHTML[countindex - 1].query,(countindex-1));
            navQueries();
          }
          if (itemsHTML[countindex - 1].type == 'SectBo_top' || itemsHTML[countindex - 1].type == 'SectBo_down') {
            AddToBOList(itemsHTML[countindex - 1].busobj,(countindex-1));
            navBO();
          }
          if (itemsHTML[countindex - 1].type.indexOf("ReportBar_") > -1) {
            reportProp.reportheadfoot = true;
          }
          else if (itemsHTML[countindex - 1].type.indexOf("HeaderBar_") > -1) {
            reportProp.pageheadfoot = true;
          }
          //Forzo il ridisegno della zona Bands del navigator
          reorganizeBandList = true;
        }
      }
    }
    else if (prevUndo[0].action == 'paste') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].action == 'paste') {
          idx = LibJavascript.Array.indexOf(itemsHTML, prevUndo[l].obj);
          if (idx >= 0) {
            if (itemsHTML[idx].id.indexOf("bar_") == 0) {
              reorganizeBandList = true;
            }
            itemsHTML.splice(idx, 1);
            countindex--;
          }
        }
        else if (prevUndo[l].action == 'moveadd') {
          prevUndo[l].obj.x = (prevUndo[l].x_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.y = (prevUndo[l].y_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.h = (prevUndo[l].h_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.w = (prevUndo[l].w_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.scale = formProp.scale;
        }
      }
    }
    else if (prevUndo[0].action == 'add') {
      for (l = 0; l < prevUndo.length; l++) {
        if (prevUndo[l].action == 'add') {
          idx = LibJavascript.Array.indexOf(itemsHTML, prevUndo[l].obj);
          if (idx >= 0) {
            //Elimino le query e i BO dal navigator
            if (itemsHTML[idx].type == 'Chart') {
              RemoveFromQueryList(itemsHTML[idx].query);
              navQueries();
            }
            if (itemsHTML[idx].id.indexOf("bar_") == 0) {
              if (itemsHTML[idx].type == 'AltQuery_top' || itemsHTML[idx].type == 'AltQuery_down') {
                RemoveFromQueryList(itemsHTML[idx].query);
                navQueries();
              }
              if (itemsHTML[idx].type == 'SectBo_top' || itemsHTML[idx].type == 'SectBo_down') {
                RemoveFromBOList('BO:' + itemsHTML[idx].busobj);
                navBO();
              }
              reorganizeBandList = true;
            }
            itemsHTML.splice(idx, 1);
            countindex--;
          }
        }
        else if (prevUndo[l].action == 'moveadd') {
          prevUndo[l].obj.x = (prevUndo[l].x_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.y = (prevUndo[l].y_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.h = (prevUndo[l].h_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.w = (prevUndo[l].w_init / prevUndo[l].scale) * formProp.scale;
          prevUndo[l].obj.scale = formProp.scale;
        }
      }
    }
    else if (prevUndo[0].action == 'switch') { //Switch: sto scambiando due barre nel navigator.
      for (l = 0; l < prevUndo.length; l++) {
        prevUndo[l].obj.y = (prevUndo[l].y_init / prevUndo[l].scale) * formProp.scale;
        prevUndo[l].obj.scale = formProp.scale;
      }
    }
    indexRedo = indexUndo;
    indexUndo--;
    selectForm();
    index = null;
    if (last_index) { last_index = null; }
    //da ottimizzare
    reorganizeBandList = true;
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
    var seqRedo = undoSequence[indexRedo]; // sequenza prev
    var l = 0, idx = 0;
    var obj;
    if (seqRedo[0].action == 'move') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].obj) {
          obj = seqRedo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTML.length; idx++) {
            if (seqRedo[l].id == itemsHTML[idx].id) {
              obj = itemsHTML[idx];
            }
          }
        }
        if (obj) {
          obj.x = (seqRedo[l].x / seqRedo[l].scale) * formProp.scale;
          obj.y = (seqRedo[l].y / seqRedo[l].scale) * formProp.scale;
          obj.h = (seqRedo[l].h / seqRedo[l].scale) * formProp.scale;
          obj.w = (seqRedo[l].w / seqRedo[l].scale) * formProp.scale;
          obj.scale = formProp.scale;
        }
      }
    }
    else if (seqRedo[0].action == 'resize') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].obj) {
          obj = seqRedo[l].obj;
        }
        else {
          for (idx = 0; idx < itemsHTML.length; idx++) {
            if (seqRedo[l].id == itemsHTML[idx].id) {
              obj = itemsHTML[idx];
            }
          }
        }
        if (obj) {
          obj.w = (seqRedo[l].w / seqRedo[l].scale) * formProp.scale;
          obj.h = (seqRedo[l].h / seqRedo[l].scale) * formProp.scale;
          if (!Empty(seqRedo[l].x)) obj.x = (seqRedo[l].x / seqRedo[l].scale) * formProp.scale;
          if (!Empty(seqRedo[l].y)) obj.y = (seqRedo[l].y / seqRedo[l].scale) * formProp.scale;
          obj.scale = formProp.scale;
        }
      }
    }
    else if (seqRedo[0].action == 'delete') {
      for (l = 0; l < seqRedo.length; l++) {
        idx = LibJavascript.Array.indexOf(itemsHTML, seqRedo[l].obj);
        if (idx >= 0) {
          if (itemsHTML[idx].type == 'Chart') {
            RemoveFromQueryList(itemsHTML[idx].query);
            navQueries();
          }
          if (itemsHTML[idx].id.indexOf("bar_") == 0) {
            if (itemsHTML[idx].type == 'AltQuery_top' || itemsHTML[idx].type == 'AltQuery_down') {
              RemoveFromQueryList(itemsHTML[idx].query);
              navQueries();
            }
            if (itemsHTML[idx].type == 'SectBo_top' || itemsHTML[idx].type == 'SectBo_down') {
              RemoveFromBOList('BO:' + itemsHTML[idx].busobj);
              navBO();
            }
            if (itemsHTML[idx].type.indexOf("ReportBar_") >= -1) {
            reportProp.reportheadfoot = true;
            }
            else if (itemsHTML[countindex - 1].type.indexOf("HeaderBar_") > -1) {
              reportProp.pageheadfoot = true;
            }
            reorganizeBandList = true;
          }
          itemsHTML.splice(idx, 1);
          countindex--;
        }
      }
    }
    else if (seqRedo[0].action == 'paste') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].action == 'paste') {
          itemsHTML[itemsHTML.length] = seqRedo[l].obj;
          countindex++;
          idx = itemsHTML.length - 1;
          itemsHTML[idx].x = (seqRedo[l].x / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].y = (seqRedo[l].y / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].h = (seqRedo[l].h / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].w = (seqRedo[l].w / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].scale = formProp.scale;
          //suppongo top prima di down
          if (itemsHTML[idx].id.indexOf("bar_") == 0) {
            if (itemsHTML[idx].id.indexOf("break") < 0 && itemsHTML[idx].id.indexOf("cover") < 0 && itemsHTML[idx].id.indexOf("html") < 0) {
              if (itemsHTML[idx].id.indexOf("_start") >= 0) {
                itemsHTML[idx].child = idx - 1;
              }
              else {
                itemsHTML[idx].child = idx - 2;
              }
            }
            reorganizeBandList = true;
          }
        }
        else if (seqRedo[l].action == 'moveadd') {
          seqRedo[l].obj.x = (seqRedo[l].x / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.y = (seqRedo[l].y / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.h = (seqRedo[l].h / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.w = (seqRedo[l].w / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.scale = formProp.scale;
        }
      }
    }
    else if (seqRedo[0].action == 'add') {
      for (l = 0; l < seqRedo.length; l++) {
        if (seqRedo[l].action == 'add') {
          itemsHTML[itemsHTML.length] = seqRedo[l].obj;
          countindex++;
          idx = itemsHTML.length - 1;
          itemsHTML[idx].x = (seqRedo[l].x / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].y = (seqRedo[l].y / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].h = (seqRedo[l].h / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].w = (seqRedo[l].w / seqRedo[l].scale) * formProp.scale;
          itemsHTML[idx].scale = formProp.scale;
          if (itemsHTML[idx].type == 'Chart') {
            AddToQueryList(itemsHTML[idx].query,idx);
            navQueries();
          }
          else {
            if (itemsHTML[idx].id.indexOf("bar_") == 0) {
              if (itemsHTML[idx].id.indexOf("break") < 0 && itemsHTML[idx].id.indexOf("cover") < 0 && itemsHTML[idx].id.indexOf("html") < 0) {
                //suppongo top prima di down
                if (itemsHTML[idx].id.indexOf("_start") >= 0) {
                  itemsHTML[idx].child = idx - 1;
                }
                else {
                  itemsHTML[idx].child = idx - 2;
                }
              }
              //Aggiungo di nuovo le query e i BO nel navigator
              if (itemsHTML[idx].type == 'AltQuery_top' || itemsHTML[idx].type == 'AltQuery_down') {
                AddToQueryList(itemsHTML[idx].query,idx);
                navQueries();
              }
              if (itemsHTML[idx].type == 'SectBo_top' || itemsHTML[idx].type == 'SectBo_down') {
                AddToBOList(itemsHTML[idx].busobj,idx);
                navBO();
              }
              //Forzo il ridisegno della zona Bands del navigator
              reorganizeBandList = true;
            }
          }
        }
        else if (seqRedo[l].action == 'moveadd') {
          seqRedo[l].obj.x = (seqRedo[l].x / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.y = (seqRedo[l].y / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.h = (seqRedo[l].h / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.w = (seqRedo[l].w / seqRedo[l].scale) * formProp.scale;
          seqRedo[l].obj.scale = formProp.scale;
        }
      }
    }
    else if (seqRedo[0].action == 'switch') { //Switch: sto scambiando due barre nel navigator.
      for (l = 0; l < seqRedo.length; l++) {
        seqRedo[l].obj.y = (seqRedo[l].y / seqRedo[l].scale) * formProp.scale;
        seqRedo[l].obj.scale = formProp.scale;
      }
    }
    indexUndo = indexRedo;
    indexRedo++;
    selectForm();
    index = null;
    if (last_index) last_index = null;
    //da ottimizzare
    reorganizeBandList = true;
    writeHTML(true);
  }
}

/* Caso: si cerca di aggiungere una Hide Section sopra una label molto grande, cliccando sulla label.
   Il click seleziona la label, impostando index e puntando a un elemento non barra.
   putBarDown richiama al suo interno writeHTML(reset) in cui e' presente il seguente if:

    if (typeof(itemsHTML[index])!='undefined' && (itemsHTML[index].id).indexOf("bar_")!=0) {
      setShadow();
    }
   Nel caso specifico, questo test da' risultato true ed e' richiamata la setShadow(). Questa richiama moveItems(), funzione
   che opera delle modifiche a undoItemsMoved e, alla fine, inserisce il suo contenuto in undoSequence e lo svuota.
   Usciti da putBarDown, undoItemsMoved risulta vuoto e, senza il test sulla sua lunghezza, veniva inserito comunque in undoSequence.
   Se l'utente effettuava l'Undo dell'inserimento, si verificava un errore javascript.

   In breve: Senza il test sulla lunghezza di undoItemsMoved, e' possibile inserire degli elementi vuoti in undoSequence, causando degli errori javascript.
 */
function insertIntoUndoSequence() {
  if (undoItemsMoved.length > 0) {
    indexUndo++;
    indexRedo = indexUndo;
    undoSequence[indexUndo] = undoItemsMoved;
    CheckUndoSize();
  }
  undoItemsMoved = [];
}
/* *** Fine della gestione dell'Undo e del Redo *** */

/* *** Gestione della Search & Replace *** */
var name_prop = [
                 /*"name",*/ "comment", "output_name",
                 /*"align", "font", "font_weight", "font_effect", "color",*/
                 "removefromout", "font", "note", "technote", // Proprieta' Label / Expression
                 "query", "busobj", // Proprieta' AlternateQuery / Proprieta' Business Object
                 "def", "x_label", "y_label", "label_field", "value_labels", "value_fields", // Proprieta' Chart
                 "link_action", "link_parameters", "link_type", "link_target", // Proprieta' Link
                 "note", "technote"
                ];
var expr_prop = [
                 "exp", "hidecond", "text",
                 "picture", "into_variable", "colexp", // Proprieta' Label / Expression
                 "link_enable_cond", "link_parameters_value", // Proprieta' Link
                 "value_params", "value_key", "value_expr", // Proprieta' AlternateQuery / Business Object
                 "src", // Proprieta' Image
                 "bg_colexp", "border_colexp", // Proprieta' Box
                 "display_expr",
                 "ingroup_expr", "outgroup_expr", "numpage_expr", "calculate_when", // Proprieta' Group
                 "breakpagecond" // Proprieta' BreakPage
                ];
var comm_prop = ["link_name", "value"];

var searchResult = []; //Json contenente le opzioni di ricerca, l'indice dei risultati della ricerca selezionati, l'indice dei risultati della ricerca negli array di appartenenza (itemsHTML o reportVariables).

function hightlightElementsO(value) {
  if (value || value == 'true') { value = true; }
  else { value = false; }
  hightlightElements(value);
  return true;
}

function ReplaceAllElementsO(value) {
  if (value || value == 'true') { value = true; }
  else { value = false; }
  ReplaceAllElements(value);
  return true;
}

function hightlightElements(checked) {
  hightlElements = checked;
  HightLight();
}

function HightLight() {
  var cIndex, obj, c;
  var searchResultIndices = searchResult.resultIndices;

  var hg = document.getElementsByClassName('hightlight_elem');
  for (var k = hg.length-1; k >= 0; k--) {
    $(hg[k].id).removeClass("hightlight_elem");
  }
  if (typeof(searchResultIndices) != "undefined") {
    for (var i = 0; i < searchResultIndices.length; i++) {
      obj = null, c = null;
      if (searchResultIndices[i][1] != 'Variable') {
        cIndex = searchResultIndices[i][0];
        obj = itemsHTML[cIndex];
        if (!obj) {
          continue;
        }
        c = Ctrl(obj.id);
        if (obj.id.indexOf("bar_") == 0) {
          continue;
        }
        if (c) {
          if (hightlElements) {
            $(c.id).addClass("hightlight_elem");
          }
          else {
            $(c.id).removeClass("hightlight_elem");
            if (obj.bg_color && LRTrim(obj.bg_color) != "") {
              c.style.backgroundColor = obj.bg_color;
            }
            else {
              c.style.backgroundColor = "";
            }
          }
        }
      }
    }
  }
}

function KeyFind() {
  var strfind = searchProp.sfind;
  searchResult = [];
  /* Ad ogni nuova ricerca:
     * si svuotano i risultati della ricerca precedente
     * si elimina l'evidenziazione dei campi della ricerca precedente
     * si nascondono i check "HightLight" e "Replace All"
  */
  document.id('findList').empty();
  if (hightlElements) {
    hightlElements = false;
    HightLight();
  }
  /*Ctrl("highlightSearchDiv").style.display = "none";
  Ctrl("infosSearch").style.display = "none";*/
  searchProp.chighlight = false;
  searchProp.csubsistute = false;
  FormProperties();

  // Inutile fare la ricerca della stringa vuota.
  if (Empty(strfind)) {
    return;
  }
  // Ricerca per almeno tre caratteri.
  if (strfind.length < 3) {
    PSAlert.alert("Minimum of 3 characters is required for search. Try again.");
    return;
  }

  // Creazione del JSon che contiene tutte le opzioni di ricerca.
  searchResult.inputSearch = strfind; // Stringa da cercare
  searchResult.resultIndices = []; // Array contente l'indice degli elementi che corrispondono ai criteri di ricerca negli array di appartenenza (itemsHTML o reportVariables)
  searchResult.selectedOccurrences = []; //Array contenente l'indice dei risultati della ricerca selezionati
  searchResult.resultProperties = []; // Array contente i nomi delle proprieta' degli elementi il cui valore corrisponde ai criteri di ricerca. Ordinato in base a resultIndices.
  searchResult.nameSearch = searchProp.cconstant; // Boolean che indica se cercare nelle proprieta' di tipo costante
  searchResult.exprSearch = searchProp.cexpression; // Boolean che indica se cercare nelle proprieta' di tipo espressione
  searchResult.wholeWord = searchProp.cwword; // Boolean che indica se si deve cercare la parola intera
  searchResult.caseSensitive = searchProp.ccsensitive; // Boolean che indica se la ricerca deve essere case sensitive

  search_accordion = new Fx.Accordion([], [], {
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

  keyFindArray(itemsHTML, searchResult);
  keyFindArray(reportVariables, searchResult);
  if (searchResult.resultIndices.length < 1) {
    PSAlert.alert(strfind + " not found");
  }
}

/*
   obj: oggetto
   m_arr: array contenente le proprieta' in cui cercare (name_prop/ exp_prop/ comm_prop)
   iindex: indice dell'elemento.

   result[0]: index dell'elemento nell'array m_array ()
   result[1]: obj.type
*/
function CheckArray(obj, m_arr, iindex) {
  for (var j = 0; j < m_arr.length; j++) {
    if (typeof(obj[m_arr[j]]) != "undefined") {
      if (CheckFunc(searchResult.inputSearch, obj[m_arr[j]])) {
        searchResult.resultProperties.push(m_arr[j]);
        searchResult.resultIndices.push([iindex, obj.type]);
      }
    }
  }
}

/* strfind: stringa da cercare
  compvalue: valore della proprieta'
*/
function CheckFunc(strfind, compvalue) {
  if (!searchResult.caseSensitive || searchResult.caseSensitive == 'false') {
    strfind = strfind.toLowerCase();
    compvalue = compvalue.toLowerCase();
  }
  if (searchResult.wholeWord && searchResult.wholeWord != 'false') {
    return strfind == compvalue;
  }
  else {
    return compvalue.contains(strfind);
  }
}

/*
   m_array: array nel quale cercare (itemsHtml o reportVariables)
   searchResult: json contenente le impostazioni di ricerca
*/
function keyFindArray(m_array, searchResult) {
  var initl = searchResult.resultIndices.length;
  var obj, i;
  for (i = 0; i < m_array.length; i++) {
    obj = m_array[i];
    if (obj.type.indexOf("_bottom") > 0) {
      continue;
    }
    if (obj.type.indexOf("_down") > 0) {
      continue;
    }
    if (obj.type.indexOf("HeaderBar_") >= 0 || obj.type.indexOf("ReportBar_") >= 0) {
      continue;
    }
    if (obj.type == "AutoCover") {
      continue;
    }
    if (searchResult.nameSearch || searchResult.nameSearch=='true') {
      CheckArray(obj, name_prop, i);
    }
    if (searchResult.exprSearch || searchResult.exprSearch=='true') {
      CheckArray(obj, expr_prop, i);
    }
    CheckArray(obj, comm_prop, i);
  }
  if (searchResult.resultIndices.length > 0) {
    /*if (Ctrl("highlightSearchDiv").style.display != "block") {
      Ctrl("highlightSearchDiv").style.display = "block";
      Ctrl("infosSearch").style.display = "block";
      //add all checkbox for replace
    }*/
    var cIndex;
    for (i = initl; i < searchResult.resultIndices.length; i++) {
      cIndex = searchResult.resultIndices[i][0];
      obj = m_array[cIndex];
      addSearchResult(i, obj);
    }
    search_accordion.display(0);
    Ctrl("results_tab").click();
    resizeGadgetsPane();
  }
}

/* Aggiunge l'elemento nel div del risultato della ricerca. */
function addSearchResult(pos, obj) {
  var propobj = getPropDescObj(obj, searchResult.resultProperties[pos]);
  var propertyType = obj.type;
  var objName = new Element('div', {
    html : (propertyType=='Form'?"Item: <span class='searchbold'>" + propertyType + "</span><br> Prop: <span class='searchbold'>"+propobj.desc + "</span>" : "Item: <span class='searchbold'>" + obj.name + "</span> ( " + propertyType + " ) " + " <br>Prop: <span class='searchbold'>"+propobj.desc+"</span>"),
    'class' : 'resultName',
    title : obj.name + " ( " + propobj.desc + " )"
  });
  objName.m_id = obj.id;
  objName.m_type = obj.type;
  objName.addEvent('click', function () {
    selectItem3(this.m_id, this.m_type, true, propobj);
  });
  var wrapper, wrapperId, wrapperTitle;
  if (obj.page + '' == "0") {
    wrapperId = "cover_divz";
    wrapperTitle = "Results in [Cover] of '<span style='font-weight: 600;'>"+searchResult.inputSearch+"</span>'";
  }
  else {
    wrapperId = "report_divz";
    wrapperTitle = "Results in [Report] of '<span style='font-weight: 600;'>"+searchResult.inputSearch+"</span>'";
  }

  var chk;
  var idInput = obj.id + "_" + searchResult.resultProperties[pos] + "_chk";
  /* Non e' possibile effettuare la Replace sulla proprieta' Name */
  if (searchResult.resultProperties[pos] != "name" || (searchResult.resultProperties[pos] == "name" && obj.type == "Variable")) {
    chk = new Element('input', {
      'type' : 'checkbox',
      'id' : idInput,
      'name' : idInput,
      'title' : 'Select for replace'
    });
    chk.addEvent('click', function () {
      selectOccurrence(pos, chk.checked);
    });
  }
  else {
    chk = new Element('input', {
      'type' : 'checkbox',
      'id' : idInput,
      'name' : idInput,
      'disabled' : 'disabled'
    });
  }
  var chkdiv = new Element('div', {
    'id' : idInput+'div',
    'style' : 'float:left'
    }
  ).adopt(chk);

  wrapper = Ctrl(wrapperId);
  if (!wrapper) {
    wrapper = new Element('div', {
      'class' : 'fld_wrapper',
      'id' : wrapperId
    }).inject(Ctrl("findList"));
    var title = new Element('div', {
      'class' : 'fld_title'
    }).inject(wrapper);
    new Element('div', {
      'class' : 'fld_title_txt',
      'html' : wrapperTitle
    }).inject(title);
    new Element('div', {
      'class' : 'fld_title_ico'
    }).inject(title);
    var ul = new Element('ul', {
      'class' : 'fld_ul'
    }).inject(wrapper);
    var li = new Element('li', {
      'class' : 'fld_li'
    }).inject(ul);
    li.adopt(chkdiv).adopt(objName);
    search_accordion.addSection(title, ul);
  }
  else {
    ul = wrapper.getElement('ul');
    li = new Element('li', {
      'class' : 'fld_li'
    }).inject(ul);
    li.adopt(chkdiv).adopt(objName);
  }
  /*var objFind = new Element('li', {}).adopt(chk).adopt(img).adopt(objName);
  wrapper.adopt(objFind);*/
}

/*
   Inserisce o elimina dall'array searchResult.selectedOccurrences il singolo risultato della ricerca selezionato.
   Serve per ottimizzare la Replace quando il risultato della ricerca e' molto grande e si selezionano pochi elementi.
   Se value e' uguale a true, si inserisce in selectedOccurrences l'indice dell'elemento selezionato in searchResultIndices.
   Se value e' uguale a false, si elimina da selectedOccurrences l'indice dell'elemento.
*/
function selectOccurrence(pos, value) {
  if (value) {
    searchResult.selectedOccurrences[searchResult.selectedOccurrences.length] = pos;
  }
  else {
    var posArray = LibJavascript.Array.indexOf(searchResult.selectedOccurrences, pos);
    searchResult.selectedOccurrences.splice(posArray, 1);
    /* Se replaceAllSearch era selezionato, si deve togliere la selezione. */
    if (Ctrl("results_csubsistute").checked) {
      Ctrl("results_csubsistute").checked = false;
    }
  }
}

function ReplaceAllElements(check) {
  var cIndex, obj, chk;
  /* Si svuota l'array degli elementi selezionati. */
  searchResult.selectedOccurrences = [];
  for (var i = 0; i < searchResult.resultIndices.length; i++) {
    //cIndex: indice dell'elemento in itemsHTML o reportVariables
    cIndex = searchResult.resultIndices[i][0];
    if (searchResult.resultIndices[i][1] != "Variable") {
      obj = itemsHTML[cIndex];
    }
    else {
      obj = reportVariables[cIndex];
    }
    if (obj) {
      chk = Ctrl(obj.id + "_" + searchResult.resultProperties[i] + "_chk");
      if (chk && !(chk.disabled)) {
        chk.checked = check;
      }
    }
    /* Se si selezionano tutti gli elementi, searchResult.selectedOccurrences deve essere contenere un numero di indici pari a searchResult.resultIndices.length. */
    if (check) {
      searchResult.selectedOccurrences[searchResult.selectedOccurrences.length] = i;
    }
  }
}

function KeyReplace() {
  if (!Empty(newPropObj)) {
    newPropObj.HideProperties();
  }
  var newValue = searchProp.sfind;
  if (newValue != searchResult.inputSearch) {
    /* Se la stringa da cercare e sostituire e' stata cambiata e non e' la stringa di default, rieseguo la ricerca.
       In questo modo, l'array selectedOccurrences viene svuotato. */
    KeyFind();
  }
  else {
    /* Il risultato della ricerca deve cambiare se si modificano i check caseSensitive, wholeWord, nameSearc, ExprSearch */
    var modifiedSearchProperties = false;
    if (searchResult.nameSearch != searchProp.cconstant) {
      modifiedSearchProperties = true;
    }
    if (!modifiedSearchProperties && (searchResult.exprSearch != searchProp.cexpression)) {
      modifiedSearchProperties = true;
    }
    if (!modifiedSearchProperties && (searchResult.wholeWord != searchProp.cwword)) {
      modifiedSearchProperties = true;
    }
    if (!modifiedSearchProperties && (searchResult.caseSensitive != searchProp.ccsensitive)) {
      modifiedSearchProperties = true;
    }

    if (modifiedSearchProperties) {
      KeyFind();
    }
  }

  /* Per evitare un giro inutile nel caso in cui non ci siano occorrenze selezionate, verifico la lunghezza di selectedOccurrences. */
  if (searchResult.selectedOccurrences.length > 0) {
    var strReplace = searchProp.ssubstitute;
    // Se il contenuto di cinputSearch ha la classe css di default, significa che e' la stringa vuota.
    /*if ($("cinputReplace").hasClass("inputSearchDefault")) {
      strReplace = "";
    }*/
    var replace = false;
    if (strReplace.length == 0) {
      // Permetto la sostituzione di qualcosa con la stringa vuota.
      if (confirm("Do you want to replace selected occurences of '" + searchResult.inputSearch + "' with nothing?")) {
        replace = true;
      }
      else {
        return;
      }
    }
    if (!replace) {
      if (confirm("Do you replace selected occurences of '" + searchResult.inputSearch + "' with '" + strReplace + "' ?")) {
        replace = true;
      }
      else {
        return;
      }
    }

    var replacedOccurrence = 0;
    var replacedVariableName = false;
    if (searchResult.resultIndices.length > 0) {
      var srchIndex, cIndex, obj, chk, oldValue, tmpValue, inputStr, resultPosition, nOccurrences;
      var separatorLength = "#||#$".length;
      /* Ottimizzazione: inutile ciclare su searchResult.resultIndices e verificare se un elemento e' stato selezionato.
         searchResult.selectedOccurrences contiene l'indice degli elementi di searchResult.resultIndices selezionati. */
      for (var i = 0; i < searchResult.selectedOccurrences.length; i++) {
        //srchIndex: indice dell'elemento in searchResult.resultIndices
        srchIndex = searchResult.selectedOccurrences[i];
        //cIndex: indice dell'elemento in itemsHTML o reportVariables
        cIndex = searchResult.resultIndices[srchIndex][0];
        if (searchResult.resultIndices[srchIndex][1] != "Variable") {
          obj = itemsHTML[cIndex];
        }
        else {
          obj = reportVariables[cIndex];
        }
        if (obj) {
          chk = Ctrl(obj.id + "_" + searchResult.resultProperties[srchIndex] + "_chk");
          /* Controllo su chk e chk.checked necessario perche' esistono proprieta' su cui puo' effettuare la ricerca, ma che non si possono eliminare.
             Proprieta' in questione: name per item diversi dalla variabile.
          */
          if (chk && chk.checked) {
            oldValue = obj[searchResult.resultProperties[srchIndex]];
            newValue = Strtran(obj[searchResult.resultProperties[srchIndex]], searchResult.inputSearch, strReplace);
            //no case sensitive...
            tmpValue = newValue.toLowerCase();
            inputStr = searchResult.inputSearch.toLowerCase();
            tmpValue = Strtran(tmpValue, inputStr, "#||#$" + inputStr + "#||#$");
            inputStr = "#||#$" + inputStr + "#||#$";
            while (tmpValue.indexOf(inputStr) >= 0) {
              resultPosition = tmpValue.indexOf(inputStr);
              tmpValue = tmpValue.substring(0, resultPosition) + strReplace + tmpValue.substring(resultPosition + inputStr.length + 1);
              newValue = newValue.substring(0, resultPosition) + strReplace + newValue.substring(resultPosition + inputStr.length - 2 * separatorLength + 1);
            }
            obj[searchResult.resultProperties[srchIndex]] = newValue;
            /* Per le Alternate Query, i Bo, i Group e le Hide Section, si deve edffettuare la sostituzione anche nel child. */
            if ((typeof(obj.child) != "undefined") && !(typeof(obj.child) == "number" && obj.child == -1)) {
              itemsHTML[obj.child][searchResult.resultProperties[srchIndex]] = newValue;
            }
            /* Si sta effettuando la sostituzione nel nome di una variabile: si salva l'informazione per il ridisegno di UserVariables */
            if (obj.type == "Variable" && searchResult.resultProperties[srchIndex] == "name") {
              replacedVariableName = true;
            }
            /* Il seguente frammento di codice serve per evitare di contare dei falsi positivi per la Replace.
               Ovvero elementi per cui non e' stata fatta la sostituzione perche' modificati nel frattempo. */
            if (oldValue != newValue) {
              /* Si contano le occorrenze di una stringa dentro l'altra. */
              nOccurrences = countOccurrences(oldValue.toLowerCase(), searchResult.inputSearch.toLowerCase());
              replacedOccurrence += nOccurrences;
              if (obj.page == reportProp.page) {
                refreshArray[refreshArray.length] = obj;
              }
            }
          }
        }
      }
    }

    /* replacedOccurrence viene modificato solo quando viene effettuata veramente almeno una sostituzione. */
    if (replacedOccurrence < 1) {
      PSAlert.alert("No occurrence replaced.");
    }
    else {
      PSAlert.alert(replacedOccurrence + " occurrence replaced.");
      writeHTML();
      /* Nel caso in cui sia stata fatta una sostituzione nel name di una variabile, si deve ridisegnare la zona UserVariables nel navigator. */
      if (replacedVariableName) {
        navUserVariables();
      }
      //KeyFind();
    }
  }
  else {
    PSAlert.alert("No occurrence selected.");
  }
}

/* Conta le occorrenze di una stringa find dentro a un'altra.
   0 significa stringa find non trovata.

   src: stringa in cui cercare.
   find: stringa da cercare.
 */
function countOccurrences(src, find) {
  var result = 0, e;
  if (typeof(src) == "undefined" || typeof(find) == "undefined") {
    return result;
  }
  if (src == "" || find == "") {
    return result;
  }
  if (src.length < find.length) {
    return result;
  }
  e = src.split(find);
  result = e.length - 1;
  return result;
}

/* Effettua il reset completo del Search & Replace */
function resetSearchReplace() {
  searchResult = [];
  document.id("findList").empty();
  searchProp.sfind = "";
  searchProp.ssubstitute = "";
  FormProperties();
}
/* *** Fine gestione ricerca *** */

/* *** Gestione modifica delle note *** */
function editDesc(id, isFormProp) {
  var url = "../portalstudio/insert_desc.html?isFormProp=" + isFormProp + "&id=" + id;
  var width = 400;
  var height = 250;
  var additionalUrl = "&description&SPModalLayerId=descSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "description");
}

function EditUNotes() {
  var id = "Form_" + "notes_" + "note";
  loadEditNotes(id);
}

function EditTNotes() {
  var id = "Form_" + "notes_" + "technote";
  loadEditNotes(id);
}

function EditEUNotes() {
  var id = "notes_" + "note";
  loadEditNotes(id);
}

function EditETNotes() {
  var id = "notes_" + "technote";
  loadEditNotes(id);
}

function loadEditNotes(ctrlid) {
  var url = "../portalstudio/insert_text.html?ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionNotesReturn";
  var width = 400;
  var height = 250;
  var additionalUrl = "&description&SPModalLayerId=notesSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1, "insert_text");
}

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
/* *** Fine Gestione modifica delle note *** */

/* *** Controlli sul posizionamento delle barre *** */

/* Verifica la presenza dell'AutoCover
 */
function checkCoverLinePresence() {
  for (var i = 0; i < bandList.length; i++) {
    if (bandList[i].type == "AutoCover") {
      return true;
    }
  }
  return false;
}

/* Verifica se si puo' aggiungere un Group nel punto dell'area di lavoro su cui si e' cliccato.
 */
function checkAddGroup(e, paste) {
  if (type == "Group_top") {
    calcPosition(e);

    var result = false;
    result = checkGroupTopPosition(ypos, "addGroup");

    if (!result) {
      PSAlert.alert("It's not possible adding Group at this point!!!");
      if (paste && paste == true) {
        type = null;
      }
      return false;
    }
  }
  return true;
}

/* Verifica la posizione di un nuovo Group Header utilizzando la sua coordinata y.
   yCoordinate: coordinata y del Group Header
   caller: chi effettua la chiamata del metodo, ovvero il navigator o il disegnatore.
 */
function checkGroupTopPosition(yCoordinate, caller) {
  //Report senza barre.
  if (bandList.length < 1) {
    return true;
  }

  var result = false; //Variabile per memorizzare i risultati dei test. True e False non bastano.
  var pos = -1; //Posizione della barra contenitrice nell'array bandList.

  //Trova la posizione del top della barra contenitrice nell'array bandList.
  for (var i = 0; i < bandList.length; i++) {
    if (bandList[i].id.indexOf("break") < 0 && bandList[i].id.indexOf("cover") < 0 && bandList[i].id.indexOf("html") < 0) { //PageBreak non sono considerati.
      if (bandList[i].type.indexOf("_top") > 0) { // Si considerano solo i top
        if (caller == "addGroup") {
          if (bandList[i].y < yCoordinate && yCoordinate < itemsHTML[bandList[i].child].y) {
            pos = i;
          }
        }
        else {
          /* L'uguale serve per lo switch tra bande. */
          if (bandList[i].y <= yCoordinate && yCoordinate <= itemsHTML[bandList[i].child].y) {
            pos = i;
          }
        }
      }
    }
  }
  result = verifyEnclosingBar(pos, yCoordinate, caller);
  return result;
}

/* Verifica il tipo della sezione che potrebbe contenere il gruppo.
   idx: indice della barra in bandIndex.
 */
function checkParent(idx) {
  var result = "";
  switch (bandList[idx].type) {
    case "Group_top":
    case "ReportBar_top":
    case "HeaderBar_top":
    case "AltQuery_top":
    case "SectBo_top":
      result = "possible";
      break;
    default:
      result = "error";
      break;
    }
  return result;
}

/* Verifica le barre con lo stesso livello contenute nella stessa sezione.
   idx: indice della barra contenitrice in bandList.
   lvl: livello della barra contenitrice.
   yCoordinate: coordinata in cui si vuole inserire la barra
   caller: chi effettua la chiamata del medoto, ovvero il navigator o il disegnatore.
 */
function checkBarsLevel(idx, lvl, yCoordinate, caller) {
  var result = "";
  var j, nGroups = 0;
  /* Servono le barre contenute nella barra contenitrice, ovvero che hanno un livello maggiore di quello della barra contenitrice. */
  var level;
  /* Solo Report Header/Footer e Page Header/Footer hanno livello 0.
     Il livello delle barre non contenute dal Report Header/Footer e/o Page Header/Footer e' 1.
     Il livello delle barre contenute dal Report Header/Footer e/o Page Header/Footer parte da 2.
   */
  if (lvl == 0) {
    /* Senza questa assegnazione, il for successivo restituiva sempre true perche' cercava le barre a livello 1.
       Sbagliato perche' il parametro lvl indica che la barra contenitrice e' un Report Header/Footer o Page Header/Footer.
     */
    level = lvl + 2;
  }
  else {
    level = lvl + 1;
  }
  /* Posso far partire il test dalla posizione della barra contenitrice che ho trovato nell'array bandList.
     Proseguo fino a quando non verifico che non ci sono altre barre di tipo gruppo contenute in quella zona o fino a quando non la trovo.
   */
  for (j = idx + 1; j < bandList.length && result == ""; j++) {
    if (bandList[j].id.indexOf("break") < 0 && bandList[j].id.indexOf("cover") < 0 && bandList[j].id.indexOf("html") < 0) { //PageBreak non sono considerati.
      if (bandList[j].type.indexOf("_top") > 0) { //Si tratta di un'apertura
        if (bandList[j].level > level) {
          // Sono nel sottoalbero della barra bandList[idx]. Si prosegue.
        }
        else if (bandList[j].level == level) {
          if (bandList[j].type.indexOf("Group") > -1) {
            if (caller == "navigator") {
              /* Il caller e' il navigator, ovvero
                 - sto cercando di posizionare una Hide Section al posto di un altro elemento in modo che contenga un gruppo.
                 - sto cercando di posizionare un gruppo al posto di un altro elemento prima di un altro gruppo.
              */
              result = "error";
            }
            else if (caller == "finalchecks") {
              /* Il caller sono i check finali al salvataggio, ovvero
                 - sto contando quanti gruppi ci sono all'interno della barra contenitrice.
              */
              nGroups++;
              if (nGroups > 1) {
                result = "error";
              }
            }
            else {
              /* Il caller e' il disegnatore, ovvero sto cercando di **aggiungere** un nuovo Group. */
              if (bandList[j].y <= yCoordinate) {
                /* La coordinata y del gruppo che ho trovato si trova prima della posizione in cui sto inserendo il gruppo.
                   Ovvero, sto cercando di mettere un gruppo sotto un altro gruppo. Non si puo' fare.
                   Oppure sto cercando di mettere un gruppo nella stessa posizione di un altro gruppo.
                 */
                result = "error";
              }
              else {
                /* La coordinata y del gruppo che ho trovato si trova dopo della posizione in cui sto inserendo il gruppo.
                   Ovvero, sto cercando di mettere un gruppo che contenga un altro gruppo. Si puo' fare.
                 */
              }
            }
          }
        }
        else {
          /* (bandList[j].level < level): ovvero, sono fuori dal sottoalbero di bandList[idx]. */
          break;
        }
      }
    }
  }

  if (result == "") {
    return "possible";
  }
  else {
    //C'e' un gruppo nello stesso livello.
    return result;
  }
}

function checkAddPageBreak(e, paste) {
  if (type == "BreakPage") {
    calcPosition(e);
    var result = false;
    result = checkPageBreakPosition(ypos);

    if (result) {
      return true;
    }
    else {
      PSAlert.alert("It's not possible adding Page Break at this point!!!");
      if (paste && paste == true) {
        type = null;
      }
      return false;
    }
  }
}

/* Verifica la posizione del Break Page utilizzando la sua coordinata y.
   yCoordinate: coordinata y del Break Page
 */
function checkPageBreakPosition(yCoordinate) {
  if (type == "BreakPage" && reportProp.page == 1) {
    // Caso 0: Report senza barre.
    if (bandList.length < 1) {
      return true;
    }
    // Caso 1: Report senza Page Header/Footer
    if (reportProp.pageheadfoot == false) {
      return true;
    }

    var pHeaderY = (pHIdx == -1 ? -1 : bandList[pHIdx].y); // Variabile per memorizzare la coordinata y del Page Header.
    var rHeaderY = (rHIdx == -1 ? -1 : bandList[rHIdx].y); // Variabile per memorizzare la coordinata y del Report Header.
    var pFooterY = (pHIdx == -1 ? -1 : itemsHTML[bandList[pHIdx].child].y); // Variabile per memorizzare la coordinata y del Page Footer.
    var rFooterY = (rHIdx == -1 ? -1 : itemsHTML[bandList[rHIdx].child].y); // Variabile per memorizzare la coordinata y del Report Footer.

    var result = "";
    // Caso 2: Page Break compreso tra il Page Header e il Page Footer.
    if (bandList[pHIdx].y < yCoordinate && yCoordinate < itemsHTML[bandList[pHIdx].child].y) {
      result = "possible";
    }
    else {
      // Caso 3: Page Break nel Page Header o nel Page Footer e manca il Report Header/Footer.
      if (!reportProp.reportheadfoot) {
        result = "error";
      }
    }

    if (result == "") {
      // Caso 4: Sono presenti Report Header/Footer e Page Header/Footer e sto cercando di inserire il Page Break tra di loro.
      if (rHeaderY != -1) { //Controllo della presenza del Report Header nel report.
        if (rHeaderY < pHeaderY) {
          // Report Header prima di Page Header
          if (yCoordinate > rHeaderY && yCoordinate < pHeaderY) {
            /* Sto cercando di inserire il Page Break nella zona compresa tra la barra del Report Header e la barra del Page Header. */
            result = "error";
          }
        }
        else {
          // Page Header prima di Report Header
          if (yCoordinate < pHeaderY) { // if (yCoordinate < pHeaderY && yCoordinate < rHeaderY) {
            /* Sto cercando di inserire il Page Break nella zona compresa tra l'inizio dell'area di lavoro e la barra del Page Header. */
            result = "error";
          }
        }
        if (rFooterY < pFooterY) {
          // Report Footer prima di Page Footer
          if (yCoordinate > pFooterY) {// if (yCoordinate > rFooterY && yCoordinate > pFooterY) {
            /* Sto cercando di inserire il Page Break nella zona compresa tra la barra del Page Footer e la fine dell'area di lavoro. */
            result = "error";
          }
        }
        else {
          // Page Footer prima di Report Footer
          if (yCoordinate > pFooterY && yCoordinate < rFooterY) {
            /* Sto cercando di inserire il Page Break nella zona compresa tra la barra del Page Footer e la barra del Report Footer. */
            result = "error";
          }
        }
      }
      if (result == "") {
        result = "possible";
      }
    }

    if (result == "possible") {
      return true;
    }
    else {
      return false;
    }
  }
  return true;
}

/* Verifica la posizione di Alternate Query e Section BO utilizzando la sua coordinata y.
 */
function checkAddDataSection(e) {
  calcPosition(e);
  var result = false;
  // Caso 0: Report senza barre.
  if (bandList.length < 1) {
    return true;
  }

  var pHeaderY = (pHIdx == -1 ? -1 : bandList[pHIdx].y); // Variabile per memorizzare la coordinata y del Page Header.
  var rHeaderY = (rHIdx == -1 ? -1 : bandList[rHIdx].y); // Variabile per memorizzare la coordinata y del Report Header.
  var pFooterY = (pHIdx == -1 ? -1 : itemsHTML[bandList[pHIdx].child].y); // Variabile per memorizzare la coordinata y del Page Footer.
  var rFooterY = (rHIdx == -1 ? -1 : itemsHTML[bandList[rHIdx].child].y); // Variabile per memorizzare la coordinata y del Report Footer.

  result = "";
  // Caso 1: Sezione non compresa tra il Page Header e il Page Footer.
  if (pHIdx > -1 && !(bandList[pHIdx].y < ypos && ypos < itemsHTML[bandList[pHIdx].child].y)) {
    // Caso 1-a: Sono presenti Report Header/Footer e Page Header/Footer e sto cercando di inserire la barra tra di loro.
    if (rHeaderY != -1) { // Controllo della presenza del Report Header nel report.
      if (rHeaderY < pHeaderY) {
        // Report Header prima di Page Header
        if (ypos > rHeaderY && ypos < pHeaderY) {
          /* Si sta cercando di inserire la barra nella zona compresa tra la barra del Report Header e la barra del Page Header. */
          result = "warning";
        }
      }
      else {
        // Page Header prima di Report Header
        if (ypos < pHeaderY) { // if (ypos < pHeaderY && ypos < rHeaderY) {
          /* Si sta cercando di inserire la barra nella zona compresa tra l'inizio dell'area di lavoro e la barra del Page Header. */
          result = "warning";
        }
      }
      if (rFooterY < pFooterY) {
        // Report Footer prima di Page Footer
        if (ypos > pFooterY) {// if (ypos > rFooterY && ypos > pFooterY) {
          /* Si sta cercando di inserire la barra nella zona compresa tra la barra del Page Footer e la fine dell'area di lavoro. */
          result = "warning";
        }
      }
      else {
        // Page Footer prima di Report Footer
        if (ypos > pFooterY && ypos < rFooterY) {
          /* Si sta cercando di inserire la barra nella zona compresa tra la barra del Page Footer e la barra del Report Footer. */
          result = "warning";
        }
      }
    }
    else {
      result = "warning";
    }
    if (result == "") {
      result = "possible";
    }
  }
  // Caso 2: Sezione compresa tra il Page Header e il Page Footer.
  else {
    var copyOfBandList = LibJavascript.Array.filter(bandList, function(bandItem){
                          if (bandItem.type.indexOf("ReportBar") > -1 || bandItem.type.indexOf("HeaderBar") > -1 || bandItem.type.indexOf("Section") > -1 || bandItem.type == "BreakPage") {
                            return false;
                          }
                          return true;
                        //return !(bandItem.type.indexOf("ReportBar") > -1 || bandItem.type.indexOf("HeaderBar") > -1 || bandItem.type.indexOf("Section") > -1 || bandItem.type == "BreakPage");
                      });
    if (copyOfBandList.length > 0) {
      var pos = -1;
      for (var i = 0; i < copyOfBandList.length; i++) { // Si calcola la posizione in copyOfBandList.
        if (copyOfBandList[i].y < ypos) {
          pos = i;
        }
      }
      if (pos > -1 && copyOfBandList[pos].type == "Group_down") {
        result = "warning";
      }
      else if (typeof(copyOfBandList[pos + 1]) != "undefined" && copyOfBandList[pos + 1].type == "Group_top") {
        result = "warning";
      }
      else {
        result = "possible";
      }
    }
    else {
      result = "possible";
    }
  }

  if (result == "warning") {
    PSAlert.alert("Attention! Printing more than one record for this item in this position could cause problems.");
  }
  return true;
}

function checkHideSection(idx) {
  var i = idx;
  while (i > -1 && bandList[idx].type.indexOf("Section_") > 0) {
    i--;
  }
  return i;
}

function checkBarsPosition(idx) {
  var item = bandList[idx];
  var result = true;
  switch(item.type) {
    case "HtmlSection":
      result = true;
    break;
    case "BreakPage":
      result = checkPageBreakPosition(item.y);
      if (result == false) {
        PSAlert.alert("PageBreak " + item.name + " inserted in Page Header or Page Footer.");
      }
      break;
    case "Section_top":
    case "SectBO_top":
    case "AltQuery_top":
      result = checkOrderBar(idx);
      break;
    case "ReportBar_top":
      if (rHIdx != -1 && pHIdx != -1) {
        if (itemsHTML[bandList[pHIdx].child].y < bandList[rHIdx].y) {
          PSAlert.alert("Report Header inserted in Page Footer.");
          result = false;
        }
      }
      if (result) {
        result = checkOrderBar(idx);
      }
      break;
    case "HeaderBar_top":
      if (rHIdx != -1 && pHIdx != -1) {
        if (itemsHTML[bandList[rHIdx].child].y < bandList[pHIdx].y) {
          PSAlert.alert("Page Header inserted in Report Footer.");
          result = false;
        }
      }
      if (result) {
        result = checkOrderBar(idx);
      }
      break;
    case "Group_top":
      result = checkOrderBar(idx);
      if (result) {
        result = checkEnclosingBar(idx);
      }
      break;
    default:
      result = true;
      break;
  }
  return result;
}

// Funzioni chiamate al salvataggio del report per verificare la posizione delle barre al suo interno.
function checkOrderBar(idx) {
  var result = true;
  // Se non c'e' il comment, si usa il name della barra.
  var barName = (LRTrim(bandList[idx].comment) != "" ? LRTrim(bandList[idx].comment) : LRTrim(bandList[idx].name));
  var barType = bandList[idx].type.substring(0, bandList[idx].type.indexOf("_"));
  // Verifico il livello delle barre.
  if (bandList[idx].level != itemsHTML[bandList[idx].child].level) {
    result = false;
    PSAlert.alert(barType + " " + barName + " crossed.", 5);
  }
  // Verifico l'ordine di header e footer.
  if (result) {
    if (bandList[idx].y < itemsHTML[bandList[idx].child].y) {
      result = true;
    }
    else {
      if (barName.indexOf("_start") > -1 ) {
        PSAlert.alert(bandList[idx].title + " and " + itemsHTML[bandList[idx].child].title + " inverted.", 5);
      }
      else {
        // Page Header/Footer e Report Header/Footer
        PSAlert.alert(barType +" Header and "+ barType + " Footer " + barName + " inverted.", 5);
      }
      result = false;
    }
  }
  return result;
}

function checkEnclosingBar(idx) {
  var pos = -1; /* Posizione della barra contenitrice nell'array bandList. */
  var result = false;

  // Trova la posizione del top della barra contenitrice nell'array bandList.
  for (var i = idx - 1 ; i > -1; i--) {
    if (bandList[i].id.indexOf("break") < 0 && bandList[i].id.indexOf("cover") < 0 && bandList[i].id.indexOf("html") < 0) { // PageBreak hanno un loro controllo.
      if (bandList[i].type.indexOf("_top") > 0) { // Si considerano solo i top
        if (bandList[i].level < bandList[idx].level) {
          pos = i;
          i = -1;
        }
      }
    }
  }
  result = verifyEnclosingBar(pos, idx, "finalchecks");
  return result;
}

/* Verifica la barra contenitrice.
   pos: posizione della barra contenitrice in bandList
   idx: posizione della barra in bandList se il chiamante e' 'finalchecks', altrimenti coordinata y del Group Header
   caller: chi effettua la chiamata del medoto, ovvero i check finali, il disegnatore all'inserimento di un nuovo gruppo o il navigator allo swap di due barre.
 */
function verifyEnclosingBar(pos, idx, caller) {
  var result = "";
  var yCoordinate = ((LRTrim(caller) == "finalchecks") ? bandList[idx].y : idx);
  var barName = "";
  if (caller == "finalchecks") {
    barName = (LRTrim(bandList[idx].comment) != ""? bandList[idx].comment : bandList[idx].name);
  }

  var pHeaderY = (pHIdx == -1 ? -1 : bandList[pHIdx].y); // Variabile per memorizzare la coordinata y del Page Header.
  var rHeaderY = (rHIdx == -1 ? -1 : bandList[rHIdx].y); // Variabile per memorizzare la coordinata y del Report Header.
  var pFooterY = (pHIdx == -1 ? -1 : itemsHTML[bandList[pHIdx].child].y); // Variabile per memorizzare la coordinata y del Page Footer.
  var rFooterY = (rHIdx == -1 ? -1 : itemsHTML[bandList[rHIdx].child].y); // Variabile per memorizzare la coordinata y del Report Footer.

  // Finito di percorrere l'array e non si e' trovato una barra che contiene.
  if (pos == -1) {
    if (pHeaderY != -1 || rHeaderY != -1) {
      // Sono presenti page o report header, ovvero il gruppo e' fuori dal dettaglio.
      if (caller == "finalchecks") {
        PSAlert.alert("Group " + barName + " outside the detail.");
      }
      result = "error";
    }
    else {
      /* Non sono presenti page o report header.
         Potenzialmente e' possibile mettere la barra in questo punto, ma si devono effettuare altri controlli.*/
      result = "possible";
    }
  }

  if (result == "") {
    /* Si verifica che non si stia cercando di inserire il gruppo:
     * prima del Page Header
     * prima del Report Header
     * tra Page Header e Report Header
     * tra Report Header e Page Header
     */
    if (bandList[pos].level == 0) { //Le uniche barre con level 0 sono Report Header/Footer e Page Header/Footer
      if (pHeaderY != -1) { //Controllo della presenza del Page Header nel report.
        if (yCoordinate < pHeaderY) {
          if (caller == "finalchecks") {
            PSAlert.alert("Group " + barName + " inside the Page Header!");
          }
          result = "error";
        }
      }
      if (rHeaderY != -1) { //Controllo della presenza del Report Header nel report.
        if (yCoordinate < rHeaderY) {
          if (caller == "finalchecks") {
            PSAlert.alert("Group " + barName + " inside the Report Header!");
          }
          result = "error";
        }
      }
      /* Si verifica che non si stia cercando di inserire il gruppo:
       * dopo il Page Header
       * dopo il Report Header
       * tra Page Footer e Report Footer
       * tra Report Footer e Page Footer
       */
      if (pFooterY != -1) { //Controllo della presenza del Page Footer nel report.
        if (yCoordinate > pFooterY) {
          if (caller == "finalchecks") {
            PSAlert.alert("Group " + barName + " inside the Page Footer!");
          }
          result = "error";
        }
      }
      if (rFooterY != -1) { //Controllo della presenza del Report Footer nel report.
        if (yCoordinate > rFooterY) {
          if (caller == "finalchecks") {
            PSAlert.alert("Group " + barName + " inside the Report Footer!");
          }
          result = "error";
        }
      }
    }
  }
  if (result == "") {
    /* Verifica il tipo della sezione che potrebbe contenere il gruppo. */
    result = checkParent(pos);
    if (result == "error") {
      if (caller == "finalchecks") {
        PSAlert.alert("Group " + barName + " inside an Hide Section!");
      }
    }
  }
  if (result == "possible") {
    /* Verifico le barre con lo stesso livello contenute nella stessa sezione. */
    if (pos == -1) {
      /* Caso: Report senza Page Header/Footer e senza Report Header/Footer. */
      result = checkBarsLevel(-1, 1, yCoordinate, "finalchecks");
      if (caller == "finalchecks") {
        result = checkBarsLevel(-1, 1, yCoordinate, "finalchecks");
        if (result == "error") {
          PSAlert.alert("There is another group at the same level of Group " + barName + "!");
        }
      }
      else {
        result = checkBarsLevel(-1, 1, yCoordinate);
      }
    }
    else {
      /* Tutti gli altri casi. */
      if (caller == "finalchecks") {
        result = checkBarsLevel(pos, bandList[pos].level, yCoordinate, "finalchecks");
        if (result == "error") {
          PSAlert.alert("There is another group at the same level of Group " + barName + "!");
        }
      }
      else {
        result = checkBarsLevel(pos, bandList[pos].level, yCoordinate, caller);
      }
    }
  }
  if (LRTrim(result) == "possible") {
    return true;
  }
  else {
    return false;
  }
}
/* *** Fine Controlli sul posizionamento delle barre *** */

/* *** Gestione della Toolbar *** */
// Disegna le toolbar del disegnatore.
function designToolbar() {
  /* Parametri passati al disegnatore.
     modelight: vengono nascosti i bottoni Wizard, New, SaveAs e Open.
     tosave: obbliga a salvare il report
     openas: rinomina il report corrente con il nome passato come valore del parametro.
  */
  if (Ctrl("sptoolbar_ctrl")) { return; }
  /* Per evitare di fare delle hideElements dopo la creazione delle toolbar, si e' creato delle toolbar alternative da caricare. */
  var editToolbar = [], actionToolbar = [], editToolbarFull = [];
  if (window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    editToolbar = ZTObjects.PSToolbarEdit;
    modelight = false;
  }
  else {
    editToolbar = ZTObjects.PSToolbarEdit;
    editToolbarFull = ZTObjects.PSToolbarEditFull;
    if (modelight == true) {
      actionToolbar = ZTObjects.PSToolbarActionLight;
    }
    else {
      actionToolbar = ZTObjects.PSToolbarActionFull;
    }
  }

  /* La proprieta' storage_name e' vuota per un motivo preciso.
     L'utente aprire il disegnatore in piu' modalita' (stand alone, light e all'interno di PortalStudio).
     Salvando il posizionamento delle toolbar nei cookies, se l'utente cambiava modalita' i bottoni venivano posizionati secondo il cookie, lasciando dei buchi.
     Non e' possibile creare un cookie per ogni toolbar per ogni modalita' del disegnatore perche' e' un'operazione troppo pesante.
     Mettendo il valore di storage_name a vuoto, le toolbar vengono posizionate dinamicamente ogni volta che si apre l'editor.
  */

  if (!modelight) {
    toolbars.wizard = new SPToolbar(ZTObjects.PSToolbarWizard, 'sptoolbar_wizard', {
    elementToShow: 'all'
    });
  }

  toolbars.create_ctrl = new SPMultiToolbar('spmultitoolbar_create_ctrl', {
    title: 'Create'
  });

  toolbars.ctrl = new SPToolbar(ZTObjects.PSToolbarCtrl, 'sptoolbar_ctrl', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_create_ctrl',
    inMultiToolbar: true,
    title: "Commons"
  });

  toolbars.ctrlothers = new SPToolbar(ZTObjects.PSToolbarCtrlOthers, 'sptoolbar_ctrlothers', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_create_ctrl',
    inMultiToolbar: true,
    title: "Advanced"
  });

  toolbars.ctrlpredef = new SPToolbar(ZTObjects.PSToolbarPredefined, 'sptoolbar_ctrlpredef', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_create_ctrl',
    inMultiToolbar: true,
    title: "Page numeration"
  });

  toolbars.section_ctrl = new SPMultiToolbar('spmultitoolbar_section', {
    title: 'Sections'
  });
  toolbars.ctrlSections = new SPToolbar(ZTObjects.PSToolbarCtrlSections, 'sptoolbar_ctrl_sections', {
    dropElement: 'canvas',
    containerId: 'spmultitoolbar_section',
    inMultiToolbar: true
  });

  toolbars.align = new SPToolbar(ZTObjects.PSToolbarAlign, 'sptoolbar_align', {
    //elementToShow: 'all'
  });

  toolbars.resize= new SPToolbar(ZTObjects.PSToolbarResize, 'sptoolbar_resize', {
    //elementToShow: 'all'
  });

  if ( editToolbarFull.length > 0 ) {
    toolbars.edit_full = new SPToolbar(editToolbarFull, 'sptoolbar_edit_full', {
      //elementToShow: 'all'
    });
  }

  toolbars.zoom = new SPToolbar(editToolbar, 'sptoolbar_zoom', {
    elementToShow: 'all'
  });

  if ( actionToolbar.length > 0 ) {
    toolbars.action = new SPToolbar(actionToolbar, 'sptoolbar_action', {
      elementToShow: 'all'
    });
  }

  toolbars.preview = new SPToolbar(ZTObjects.PSToolbarPreview, 'sptoolbar_preview', {
    elementToShow: 'all'
  });
}

/* Disabilita la toolbar quando la Preview e' aperta. */
function setToolbars() {
  setToolbarCtrlBtn();
}

function setToolbarCtrlBtn() {
  if (checkCoverLinePresence() || reportProp.page == 1) {
    toolbars.ctrlSections.disable("autocover_ctrl");
    Ctrl("autocover_ctrl").style.opacity = 0.2;
  }
  if (!checkCoverLinePresence() && reportProp.page == 0) {
    toolbars.ctrlSections.enable("autocover_ctrl");
    Ctrl("autocover_ctrl").style.opacity = 1;
  }
  if (reportProp.page == 0) {
    toolbars.ctrlSections.disable("group_top_ctrl");
    toolbars.ctrlSections.disable("query_top_ctrl");
    toolbars.ctrlSections.disable("sectbo_top_ctrl");
  }
  else {
    toolbars.ctrlSections.enable("group_top_ctrl");
    toolbars.ctrlSections.enable("query_top_ctrl");
    toolbars.ctrlSections.enable("sectbo_top_ctrl");
  }
}
/* *** Fine Gestione della Toolbar *** */

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
    layerOpenForeground(url,"wizardSPModalLayer","","","","",1); // openSPModalLayer(url, null, null, null, null, true, 1, false, false);
  }
}
/* *** Fine della gestione dell'apertura dei pop-up del disegnatore *** */

