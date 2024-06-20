/*  exported PrintProp PrintPropObj ps_props clCanvasLib pdffile maxpages pdfimagesrc pdfimagesrcbck
    dwidth dheight scale views tabs datasource filename repversion defaultFont rmodel
    modifiedZone vmask fviewType old_name canclick

    doLoad setScroll convertStringToPx Properties hideProperties drawPdfPreview writeHTML
    fzoneclick genItemSize addFieldUsedClass removeFieldUsedClass getFieldType loadFieldsInput
    setVdmMask drawFldShadow editItemEvent addRulersLines drawInputArea inputareaToItem
    inputareaKeyUp deleteItem getMaxWordLength openEditArea ModifyShadow removeFieldsSwitch
    insertTooltipItem removeTooltipItem clickItem openReport openReportLayerSave setZoneOptions
    clearHTMLZone makeJsonItem newReport resetReportSave drawGenericShadow drawERWizardHSave drawERWizardH
    closeERWizard ExecAfterCancel drawEditorReportFromModel undoFromHistory redoFromHistory
    closeConfirmForm drawSeparatorElement makeJsonItemAllFields updateJsonItemAllFields
 */

/* global renderApiElement */

var PrintProp = null;
var PrintPropObj = null;

var ps_props = { 'width': 200, 'top': 45, 'left': 500, 'opened': true, 'opacity': 1, 'expandedToColumn': false, 'columnSide': 'none', 'form_closed': false };

var workunit = "mm";
var gridtype = "small-dashed";
var unittick = "25";

var notimooManager, notimooAlert;
var clCanvasLib = null;

var pdffile = "";
var maxpages = -1;
var pdfimagesrc = "";
var pdfimagesrcbck = "";
var dwidth = -1;
var dheight = -1;
var scale = 100;

var designView = "designView";
var documentView = "documentView";
var pdfView = "pdfView";
var pdfViewD = "pdfViewD";
var views = [designView, documentView, pdfView];

var viewMode = designView;
var tabs = null;

var datasource = "";
var fld_accordion = null;

var filename = "";
var blankObj = {};
var repversion = "1.0";
var mapFieldCount = [];
var defaultFont = { name: "Open Sans", size: 14, weight: 400 };
var currentname = "";
var m_CurrentObj = null;
var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));
var rmodel = "";
var custom = false;

tool = 'smartreport';

var modifiedZone = [];
var isoffline = false;
var m_bUpdated = false;

var dataobj = null;
var versionSVRP = "";
var fields = null;
var callbackFnc = null;
var updateFnc = null;
var portletID = null;
var vmask = "";

var fviewType = {};

var isAdmin;

function doLoad(e, loadParms) {
  e = Lower(document.charset || document.characterSet)
  var decodeParameterValue = (e == 'utf-8' ? decodeURIComponent : function (s) { return unescape(Strtran(s, '%80', '%u20AC')); })

  versionSVRP = loadParms.configName;
  callbackFnc = loadParms.cbfnc;
  updateFnc = loadParms.updfnc;
  portletID = loadParms.ptl;
  custom = CharToBool(loadParms.custom);
  vmask = loadParms.vdmMask;
  isAdmin = loadParms.isAdmin;

  Ctrl('fielddatasource').placeholder = getTranslated("SMR_DATASOURCE", "Datasource");
  Ctrl('fielddatasource').title = getTranslated("SMR_DATASOURCE_TOOLTIP", "Select datasource");
  Ctrl('bRefresh').title = getTranslated("SMR_DATASOURCEREFRESH_TOOLTIP", "Refresh datasource");
  Ctrl('bBo').title = getTranslated("SMR_DATASOURCEBOSELECT_TOOLTIP", "Select business object");
  Ctrl('bNewQuery').title = getTranslated("SMR_DATASOURCENEW_TOOLTIP", "New query");
  Ctrl('bEditQuery').title = getTranslated("SMR_DATASOURCEEDIT_TOOLTIP", "Edit query");
  Ctrl('bQuery').title = getTranslated("SMR_DATASOURCESELECT_TOOLTIP", "Select query");

  Ctrl('vdmfileinput').placeholder = getTranslated("SMR_VDMMASK", "Parameters mask");
  Ctrl('vdmfileinput').title = getTranslated("SMR_VDMFILE_TOOLTIP", "Set parameters mask");
  Ctrl('bSelect').title = getTranslated("SMR_VDMSELECT_TOOLTIP", "Select parameters mask");
  Ctrl('bNewVdm').title = getTranslated("SMR_VDMNEW_TOOLTIP", "New parameters mask");
  Ctrl('bEditVdm').title = getTranslated("SMR_VDMEDIT_TOOLTIP", "Edit parameters mask");


  Ctrl('genlistBar').textContent = getTranslated("SMR_GENERICELEMENTS", "Generic elements");
  Ctrl('fieldlistBar').textContent = getTranslated("SMR_DATASOURCEANDFIELDS", "Datasource & fields");

  var defZones = ['reportheader', 'pageheader', 'groupbreak', 'groupheader', 'groupbody', 'groupfooter', 'pagefooter', 'reportfooter']

  for (var i = 0; i < defZones.length; i++) {
    var pID = defZones[i];
    if (Ctrl(pID)) {
      var c = Ctrl(pID);
      var tlabels = c.getElementsByClassName("title_label");
      if (tlabels.length > 0) {
        tlabels[0].textContent = getTranslated("SMR_" + tlabels[0].textContent, tlabels[0].textContent);
      }
      tlabels = c.getElementsByClassName("subtitle_label");
      if (tlabels.length > 0) {
        tlabels[0].textContent = "[" + getTranslated("SMR_" + tlabels[0].textContent, tlabels[0].textContent) + "]";
      }
      //SMR_GROUPING //SMR_DATASOURCESFIELDS
      //SMR_GROUPHEADER //SMR_ONEBANDBYGROUPING
      //SMR_DETAIL //SMR_ONEBANDBYDATASOURCESROW
      //SMR_GROUPFOOTER //SMR_ONEBANDBYGROUPING
      //SMR_REPORTHEADER //SMR_ONEBANDBYREPORT
      //SMR_REPORTFOOTER //SMR_ONEBANDBYREPORT
      //SMR_PAGEHEADER //SMR_ONEBANDBYPAGE
      //SMR_PAGEFOOTER //SMR_ONEBANDBYPAGE
    }
  }

  var fnToDelayx = function () {
    if (Empty(loadParms.fields) && !Empty(portletID) && getOpener() && getOpener()[portletID] && getOpener()[portletID].getFields) {
      var vflds = getOpener()[portletID].getFields();
      fields = JSON.parse(vflds);
    }
    else if (!Empty(loadParms.fields))
      fields = JSON.parse(decodeParameterValue(loadParms.fields));

    if (!Empty(portletID) && getOpener() && getOpener()[portletID]) {
      var ptlobj = getOpener()[portletID];
      if (ptlobj && ptlobj.getFieldsTypeView)
        fviewType = ptlobj.getFieldsTypeView(fields);
    }

    newHistoryStack();
    setWorkUnit();
    create_gadget_pane();
    if (window.parent.location.href.indexOf("portalstudio.jsp") >= 0) {
      /*Ctrl('backcanvas').style.top = (Ctrl('backcanvas').offsetTop - Ctrl("toolbarP").offsetHeight) + "px";
      Ctrl('h_ruler').style.top = (Ctrl('h_ruler').offsetTop - Ctrl("toolbarP").offsetHeight) + "px";
      Ctrl('rulergridopt').style.top = (Ctrl('rulergridopt').offsetTop - Ctrl("toolbarP").offsetHeight) + "px";
      Ctrl('v_ruler').style.top = (Ctrl('v_ruler').offsetTop - Ctrl("toolbarP").offsetHeight) + "px";
      Ctrl('v_ruler_zones').style.top = (Ctrl('v_ruler_zones').offsetTop - Ctrl("toolbarP").offsetHeight) + "px";
      Ctrl('gadgets_pane').style.top = (Ctrl('gadgets_pane').offsetTop - Ctrl("toolbarP").offsetHeight) + "px";*/
      Ctrl("toolbarP").style.display = "none";
      Ctrl("toolbarZ").style.marginTop = "0px";
    }
    resizeWindow(e, true);
    addToolbars();
    addZonesSwitch();
    FormProperties();
    drawLimitBars();
    blankObj = getFromDesignObj();
    canAlign = true;
    HideElementsByClass(documentView);
    ShowElementsByClass(designView);
    resetZones(true);

    /* Inizializzazione del menu accordion per i fields del Fields Explorer */
    if (fld_accordion == null) {
      fld_accordion = new Fx.Accordion([], [], {
        'onComplete': resizeGadgetsPane,
        'onActive': function (/*toggler, element*/) { },
        'onBackground': function (/*toggler, element*/) { },
        alwaysHide: true,
        display: 0
      });
    }

    checkZones();
    addGenericItems();

    Ctrl("canvas").onmousemove = null;
    Ctrl("canvas").onmousedown = beginDragSelection;

    if (!loadParms.isAdmin && !dataobj) {
      window.location = "../jsp-system/SPLogin.jsp?m_cURL=" + uri + (!Empty(uriparms) ? "&" : "") + uriparms;
      return;
    }

    if (!Empty(loadParms.filename)) {
      notimooManager.show({
        title: 'Notification message',
        message: 'loading report ' + loadParms.filename,
        visibleTime: 1000,
        width: 200
      });
      setLoading();
      newCurrentObj(loadParms.filename, "smartreport", { custom: custom });
      if (dataobj && loadParms.datasource) {
        formProp.datasource = loadParms.datasource;
        Ctrl('fielddatasource').value = formProp.datasource;
        disableDatasource();
      }
      setTimeout(function () {
        selectReportPage(1);
      }, 750);
      return;
    }
    else {
      notimooManager.show({
        title: 'Notification message',
        message: 'loading SmartReport Editor!',
        visibleTime: 1000,
        width: 200
      });
      setTitleName();
    }

    m_bUpdated = false;
    HideElementsByClass(pdfViewD);
    if (!Empty(loadParms.datasource) && Empty(loadParms.reportmodel)) {
      drawEditor();
      drawERWizard(loadParms.datasource, fields);
    }
    else if (!Empty(loadParms.datasource) && !Empty(loadParms.reportmodel)) {
      setDatasourceValue(loadParms.datasource);
      applyModel(loadParms.reportmodel, true);
      setTimeout(function () {
        selectReportPage(1);
      }, 750);
    }
    else
      drawEditor();
  };
  fnToDelayx.delay(0);
}

function addToolbars() {
  addToolbarElements(formProp.objClass.newProperties.leftToolbar_0, "toolbarLeft");
  var cc = 1;
  addToolbarElements(formProp.objClass.newProperties.leftToolbar_2, "toolbarLeft", cc);
  cc++;
  addToolbarElements(formProp.objClass.newProperties.rightToolbar_1, "toolbarRight", cc);
  cc++;
  if (window.parent.location.href.indexOf("portalstudio.jsp") >= 0) {
    addToolbarElements(formProp.objClass.newProperties.wizardToolbar, "toolbarRight", cc);
    cc++;
  }
  if (isAdmin) {
    var div = document.createElement("div");
    div.id = "lcApi_container";
    div.className = "cApi_container unselectable disabledpic";
    div.style.float = "left";
    div.onclick = renderApiElement;
    div.style.cursor = "pointer";
    var a = document.createElement("a");
    a.id = "element_cApi";
    a.className = "toggler_capi";
    a.title = "API";
    a.href = "javascript:void(0)";
    var pipediv = document.createElement("div");
    pipediv.className = "toolbarpipe";
    var span = document.createElement("span");
    span.className = "unselectable toolbartext";
    span.id = "label_cApi";
    span.textContent = "Element API";
    div.appendChild(pipediv);
    div.appendChild(a);
    div.appendChild(span);
    document.getElementById("toolbarRight").appendChild(div);
  }
  addToolbarElements(formProp.objClass.newProperties.rightToolbar_2, "toolbarRight", cc);
  cc++;
  addToolbarElements(formProp.objClass.newProperties.rightToolbar_3, "toolbarRight", cc);
}

function setDatasourceValue(value) {
  formProp.datasource = value;
  Ctrl("fielddatasource").value = formProp.datasource;
  // in caso di dataobj, inibisco la modifica della dsource
  if (dataobj)
    disableDatasource();
  loadFields();
  updateMCurrentObj("datasource", value);
  pushToHistory();
}

function disableDatasource() {
  Ctrl("fielddatasource").readOnly = true;
  $("fielddatasource").addClass("disabledpic");
  $("bQuery").addClass("disabledpic");
  $("bEditQuery").addClass("disabledpic");
  $("bNewQuery").addClass("disabledpic");
  $("bBo").addClass("disabledpic");
  $("bRefresh").addClass("disabledpic");
  Ctrl("bQuery").onclick = null;
  Ctrl("bEditQuery").onclick = null;
  Ctrl("bNewQuery").onclick = null;
  Ctrl("bBo").onclick = null;
  Ctrl("bRefresh").onclick = null;
  if (Ctrl("open_cont"))
    $("open_cont").addClass("hiddenAdd");
  if (Ctrl("new_cont")) {
    $("new_cont").addClass("disabledpic");
    Ctrl("new_cont").onclick = null;
  }

  // vdm
  Ctrl("vdmfileinput").readOnly = true;
  $("vdmfileinput").addClass("disabledpic");
  $("bSelect").addClass("disabledpic");
  $("bEditVdm").addClass("disabledpic");
  $("bNewVdm").addClass("disabledpic");
  Ctrl("bSelect").onclick = null;
  Ctrl("bEditVdm").onclick = null;
  Ctrl("bNewVdm").onclick = null;
}

function checkZones() {
  showZone("report", "showreportzone");
  showZone("page", "showpagezone");
  showZone("group", "showgroupzone");
}

function setWorkUnit() {
  setMeasureWorkUnit();
  setMeasureGridType();
  setMeasureTickUnit();
}

function drawLimitBars() {
  var cbars = Ctrl("barslimit");
  if (Empty(cbars)) return;
  cbars.innerHTML = "";
  var hbars = Ctrl("barslimithandlers");
  if (Empty(hbars)) return;
  hbars.innerHTML = "";
  if (viewMode != designView) {
    fzonedrawLimitBars();
    return;
  }
  hbars.style.height = Ctrl("backcanvas").offsetHeight + "px";

  var llimit = document.getElementsByClassName("limit");
  var l, bar, i;
  var classes = {
    reportheaderlimit: "report", pageheaderlimit: "page", groupheaderlimit: "group", groupbodylimit: "detail",
    reportfooterlimit: "report", pagefooterlimit: "page", groupfooterlimit: "group"
  };
  for (i = 0; i < llimit.length; i++) {
    l = llimit[i];
    bar = document.createElement("div");
    bar.id = l.id + "bar";
    bar.className = "unselectable limitbar " + classes[l.id] + "L";
    bar.style.top = l.offsetTop + "px";
    cbars.appendChild(bar);
    bar.onmousedown = dragBar;

    bar = document.createElement("div");
    bar.id = l.id + "handler";
    bar.className = "unselectable limithandler " + classes[l.id] + "Z";
    if ($(l.id).hasClass("hiddenZone"))
      bar.className += " hiddenZone";
    bar.style.top = (l.offsetTop) + "px";
    hbars.appendChild(bar);
    //bar.addEventListener("touchstart",dragBar);
    bar.addEventListener("mousedown", dragBar);
    if (ismobile)
      $(l.id + "handler").addClass("mobilehandlersize");
  }

  resetTabs();

  llimit = document.getElementsByClassName("contentZone");
  for (i = 0; i < llimit.length; i++) {
    l = llimit[i];
    if (reportZones.indexOf(l.id) < 0) {
      reportZones.push(l.id);
      mapItems[l.id] = [];
    }
    if (!document.getElementById(l.id + "items")) {
      bar = document.createElement("div");
      bar.id = l.id + "items";
      l.appendChild(bar);
    }
  }

  updateDrawGrid(llimit);

  if (reportZones.indexOf("groupbreak") < 0)
    reportZones.push("groupbreak");

  for (i = 0; i < reportZones.length; i++) {
    if (Ctrl(Strtran(reportZones[i], "content", "")))
      $(Strtran(reportZones[i], "content", "")).addClass("mobilehandlers");
  }

  if (viewMode == designView)
    resizeZoneRulers();

  updateAllItemsY();
}

function updateDrawGrid(zones) {
  if (Empty(zones))
    zones = document.getElementsByClassName("contentZone");
  for (var i = 0; i < zones.length; i++) {
    var l = zones[i];
    insertElementGrid(l);
    $(l.id + 'grid').addClass("designView");
    generateGrid(Ctrl(l.id), l.id + 'grid', workunit);
  }
}

function insertElementGrid(gparent) {
  var grid;
  if (!document.getElementById(gparent.id + "grid")) {
    grid = document.createElement("div");
    grid.id = gparent.id + "grid";
    grid.className = "grid";
    gparent.appendChild(grid);
  }
}

function resizeWindow(/*event, res*/) {
  var ctrl = Ctrl("backcanvas");
  if (ctrl == null) {
    return;
  }
  if (document.getSize().y - ctrl.offsetTop > 0) {
    ctrl.style.height = (document.getSize().y - ctrl.offsetTop) + "px";
  }
  ctrl.style.height = (ctrl.offsetHeight - 20) + "px";
  if (document.body.clientWidth - $('gadgets_pane').offsetWidth > 80) {
    ctrl.style.width = (document.body.clientWidth - (($('gadgets_pane').opened ? $('gadgets_pane').offsetWidth : 0) + 60)) + "px"; //margine di 30
  }
  setCanvasScroll();
  generateRulers(workunit);
  drawLimitBars();
}

function setCanvasScroll() {
  resizecanvas();
  Ctrl("backcanvas").style.overflowX = "auto";
  Ctrl("backcanvas").style.overflowY = "auto";
}

function resizecanvas() {
  var bw = Ctrl("backcanvas").offsetWidth;
  var cw = Ctrl("canvas").offsetWidth;
  if (bw > cw) Ctrl("canvas").style.width = (bw) + "px";
}

function setScroll(/*e, elem*/) {
  if (Ctrl("h_ruler")) {
    Ctrl("h_ruler").scrollLeft = Ctrl("backcanvas").scrollLeft;
  }
  if (Ctrl("v_ruler")) {
    Ctrl("v_ruler").scrollTop = Ctrl("backcanvas").scrollTop;
  }
  if (Ctrl("v_ruler_zones")) {
    Ctrl("v_ruler_zones").scrollTop = Ctrl("backcanvas").scrollTop;
  }
}

function convertStringToPx(st, dimref) {
  st = st + "";
  if (endsWith(st, '%')) {
    if (dimref)
      return parseFloat(st) * dimref / 100;
    else
      return parseFloat(st);
  }
  else {
    if (endsWith(st, "pt")) return convertToPixel("pt", parseFloat(st)) * ptTopx;
    else if (endsWith(st, "mm")) return convertToPixel("mm", parseFloat(st)) * ptTopx;
    else if (endsWith(st, "cm")) return convertToPixel("cm", parseFloat(st)) * ptTopx;
    else return parseFloat(st);
  }
}

function convertPxToString(ab, wunit) {
  var c = parseFloat(convertFromPixel(wunit, ab / ptTopx)).toFixed(2);
  if (wunit == 'px') return c + "pt";
  return c + wunit;
}

function FormProperties() {
}

function Properties() {
  document.body.style.cursor = "auto";
}

function hideProperties(/*divid*/) {
}

var gwork = {};
var gselectzone = "";
function fpagemargins(gcurrpage/*,obj*/) {
  Ctrl("marginright").style.height = gwork.hh + "px";
  Ctrl("marginright").style.width = "1px";
  Ctrl("marginright").style.top = (getY(gcurrpage.parentNode) - Ctrl("backcanvas").offsetTop) + "px";
  Ctrl("marginright").style.left = (getX(gcurrpage) - Ctrl("backcanvas").offsetLeft + gcurrpage.offsetWidth) + "px";
  Ctrl("marginright_int").innerHTML = convertPxToString(gwork.marginr, workunit);

  Ctrl("marginleft").style.height = gwork.hh + "px";
  Ctrl("marginleft").style.width = "1px";
  Ctrl("marginleft").style.top = (getY(gcurrpage.parentNode) - Ctrl("backcanvas").offsetTop) + "px";
  Ctrl("marginleft").style.left = (getX(gcurrpage) - Ctrl("backcanvas").offsetLeft) + "px";
  Ctrl("marginleft_int").innerHTML = convertPxToString(gwork.marginl, workunit);

  Ctrl("margintop").style.width = gwork.ww + "px";
  Ctrl("margintop").style.top = (getY(gcurrpage) - Ctrl("backcanvas").offsetTop) + "px";
  Ctrl("margintop").style.height = "1px";
  Ctrl("margintop_int").innerHTML = convertPxToString(gwork.margint, workunit);

  Ctrl("marginbottom").style.width = gwork.ww + "px";
  Ctrl("marginbottom").style.top = (getY(gcurrpage) - Ctrl("backcanvas").offsetTop + gcurrpage.offsetHeight) + "px";
  Ctrl("marginbottom").style.height = "1px";
  Ctrl("marginbottom_int").innerHTML = convertPxToString(gwork.marginb, workunit);

  Ctrl("marginright").style.display = 'none';
}

function fzoneclick(e, obji) {
  var obj;
  if (e == undefined) e = window.event;
  if (Empty(obji) || obji == undefined) obj = GetEventSrcElement(e || window.event);
  else obj = obji;
  var lz = document.getElementsByClassName("zoneZ");
  for (var i = 0; i < lz.length; i++) {
    $(lz[i].id).removeClass("reportZ");
    $(lz[i].id).removeClass("pageZ");
    $(lz[i].id).removeClass("groupZ");
    $(lz[i].id).removeClass("detailZ");
    lz[i].style.backgroundColor = "";
    resetMenuToolbar();
  }

  if (obj.id.indexOf('_') > -1)
    obj = Ctrl(obj.id.substr(0, obj.id.indexOf('_')));
  var par = obj.parentNode;
  if (!ffzoneclick(obj)) ffzoneclick(par);
  var p = obj;
  while (p.parentNode && !p.parentNode.id.indexOf('page') == 0) {
    p = p.parentNode;
  }
  p = p.parentNode;
  if (!Empty(p)) {
    viewcurrpage = Strtran(p.id, 'grid', '');
    fpagemargins(Ctrl(Strtran(viewcurrpage, 'page', 'zpagem')), m_CurrentObj);
  }
  drawLimitBars();
}

function ffzoneclick(obj) {
  var ret = false;
  gselectzone = "";
  if (!Empty(obj)) {
    if (obj.id.indexOf('reportheader') > 0 || obj.id.indexOf('reportfooter') > 0) {
      $(obj.id).addClass("reportZ");
      $(obj.id).addClass("zoneZ");
      ret = true;
    }
    if (obj.id.indexOf('pageheader') > 0 || obj.id.indexOf('pagefooter') > 0) {
      $(obj.id).addClass("pageZ");
      $(obj.id).addClass("zoneZ");
      ret = true;
    }
    if (obj.id.indexOf('groupheader') > 0 || obj.id.indexOf('groupfooter') > 0) {
      $(obj.id).addClass("groupZ");
      $(obj.id).addClass("zoneZ");
      ret = true;
    }
    if (obj.id.indexOf('groupbody') > 0) {
      $(obj.id).addClass("detailZ");
      $(obj.id).addClass("zoneZ");
      ret = true;
    }
  }
  if (ret) {
    var col = getComputedStyle(obj).backgroundColor;
    col = Strtran(col, ')', ',0.5)');
    col = Strtran(col, 'rgb', 'rgba');
    obj.style.backgroundColor = col;
    gselectzone = obj.id;
    setMenuToolbar(gselectzone);
  }
  return ret;
}

function fzonedrawLimitBars() {
  var cbars = Ctrl("barslimit");
  var hbars = Ctrl("barslimithandlers");
  var l, bar;
  l = Ctrl(gselectzone);
  if (Empty(gselectzone) || Empty(l)) return;
  //sotto
  bar = document.createElement("div");
  bar.id = l.id + "limitbar";
  bar.className = "unselectable";
  bar.style = l.style;
  bar.style.position = 'absolute';
  bar.style.top = (getY(l) - Ctrl('backcanvas').offsetTop + l.offsetHeight) + "px";
  bar.style.left = (getX(l) - Ctrl('backcanvas').offsetLeft) + "px";
  bar.style.width = l.offsetWidth + "px";
  bar.style.cursor = "n-resize";
  bar.style.zIndex = 3;
  bar.style.borderTop = getComputedStyle(l).backgroundColor;
  bar.style.borderTopStyle = "dashed";
  bar.style.borderTopWidth = 0;
  cbars.appendChild(bar);
  bar.onmousedown = dragBarZone;

  bar = document.createElement("div");
  bar.id = l.id + "limithandler";
  bar.className = "unselectable limithandler";
  if ($(l.id).hasClass("hiddenZone"))
    bar.className += " hiddenZone";
  bar.style.top = (getY(l) - Ctrl('backcanvas').offsetTop + l.offsetHeight) + "px";
  bar.style.backgroundColor = getComputedStyle(l).backgroundColor;
  bar.style.borderColor = getComputedStyle(l).backgroundColor;
  if (l.id.indexOf("groupbody") >= 0) {
    bar.style.borderStyle = getComputedStyle(l).borderStyle;
    bar.style.borderColor = getComputedStyle(l).borderColor;
    bar.style.borderWidth = getComputedStyle(l).borderWidth;
    bar.style.width = 13 + "px";
    bar.style.height = 13 + "px";
  }
  bar.style.zIndex = 4;
  hbars.appendChild(bar);
  if (gwork.marginl - Ctrl(bar.id).offsetWidth >= 0)
    bar.style.left = (gwork.marginl - Ctrl(bar.id).offsetWidth + 2) + "px";
  //bar.addEventListener("touchstart",dragBarZone);
  bar.addEventListener("mousedown", dragBarZone);
  if (ismobile)
    $(l.id + "limithandler").addClass("mobilehandlersize");

  //sopra
  bar = document.createElement("div");
  bar.id = l.id + "zlimitbar";
  bar.className = "unselectable";
  bar.style = l.style;
  bar.style.position = 'absolute';
  bar.style.top = (getY(l) - Ctrl('backcanvas').offsetTop) + "px";
  bar.style.left = (getX(l) - Ctrl('backcanvas').offsetLeft) + "px";
  bar.style.width = l.offsetWidth + "px";
  bar.style.cursor = "n-resize";
  bar.style.zIndex = 3;
  bar.style.borderTop = '#333333';
  bar.style.borderTopStyle = "dashed";
  bar.style.borderTopWidth = 0;
  cbars.appendChild(bar);
  bar.onmousedown = dragBarZone;

  bar = document.createElement("div");
  bar.id = l.id + "zlimithandler";
  bar.className = "unselectable limithandler";
  if ($(l.id).hasClass("hiddenZone"))
    bar.className += " hiddenZone";
  bar.style.top = (getY(l) - Ctrl('backcanvas').offsetTop) + "px";
  bar.style.backgroundColor = getComputedStyle(l).backgroundColor;
  bar.style.borderColor = getComputedStyle(l).backgroundColor;
  if (l.id.indexOf("groupbody") >= 0) {
    bar.style.borderStyle = getComputedStyle(l).borderStyle;
    bar.style.borderColor = getComputedStyle(l).borderColor;
    bar.style.borderWidth = getComputedStyle(l).borderWidth;
    bar.style.width = 13 + "px";
    bar.style.height = 13 + "px";
  }
  bar.style.zIndex = 4;
  hbars.appendChild(bar);
  if (gwork.marginl - Ctrl(bar.id).offsetWidth >= 0)
    bar.style.left = (gwork.marginl - Ctrl(bar.id).offsetWidth + 2) + "px";
  //bar.addEventListener("touchstart",dragBarZone);
  bar.addEventListener("mousedown", dragBarZone);
  if (ismobile)
    $(l.id + "zlimithandler").addClass("mobilehandlersize");
}

function drawPdfPreview() {
}

/* *** Gestione dei righelli *** */
function generateRulers(workunit, maxWidth, maxHeight) {
  var ctrl = Ctrl("backcanvas");
  var ctrlC = Ctrl("canvas");

  /*var rapw = (getOffset(ctrlC).w * 100 / CanvasLib.scale) / (getOffset(ctrl).w);
  var raph = (getOffset(ctrlC).h * 100 / CanvasLib.scale) / (getOffset(ctrl).h);
  if (raph < 1) { raph = 1; }
  if (rapw < 1) { rapw = 1; }*/

  var ctrlz = Ctrl("h_ruler");
  if (ctrlz) {
    ctrlz.style.width = (getOffset(ctrl).w - 2) + "px";
  }
  ctrlz = Ctrl("v_ruler");
  if (ctrlz) {
    ctrlz.style.height = (getOffset(ctrl).h - 2) + "px";
  }
  if (Empty(maxHeight)) maxHeight = 0;
  maxHeight = Math.max(maxHeight, ctrlC.offsetHeight);
  if (Empty(maxWidth)) maxWidth = 0;
  maxWidth = Math.max(maxWidth, ctrlC.offsetWidth);

  //margine 30 px perche' il backcanvas ha un offset che non si spiega.
  Ctrl("v_ruler_zones").style.display = 'block';
  generateZoneRulers();
  resizeZoneRulers();
  generateRulerCanvasV("v_rulerc", maxHeight + 30, workunit);
  generateRulerCanvasVNoview();
  generateRulerCanvasH("h_rulerc", maxWidth + 30, workunit);
  addRulerSettings();
}

function addRulerSettings() {
  Ctrl("rulergridopt").style.top = ((!formProp.showrulers) ? 85 : Ctrl("h_ruler").offsetTop) + "px";
  Ctrl("rulergridopt").style.left = (Ctrl("v_ruler").offsetLeft + 3) + "px";
  var evt = " onclick='editItem(event)'";
  var tmp = Ctrl("rulergridopt").outerHTML.splice(Ctrl("rulergridopt").outerHTML.indexOf("></div>"), 0, evt);
  Ctrl("rulergridopt").outerHTML = tmp;
  Ctrl("rulergridopt").style.display = "block";
}

function generateZoneRulers() {
  Ctrl("v_ruler_zones").innerHTML = '';
  Ctrl("v_ruler_zones").style.height = (getOffset(Ctrl("backcanvas")).h - 20) + "px";
  Ctrl("v_ruler_zones").style.left = Ctrl("v_ruler").style.left;

  var zones = document.getElementsByClassName("contentZone");
  var zid = "", rul;
  for (var i = 0; i < zones.length; i++) {
    zid = zones[i].id;
    if (!document.getElementById(zid + "_ruler")) {
      rul = document.createElement("div");
      rul.id = zid + "_ruler";
      rul.className = "vRuler";
      Ctrl("v_ruler_zones").appendChild(rul);
    }
    if (!document.getElementById(zid + "_rulerc")) {
      rul = document.createElement("div");
      rul.id = zid + "_rulerc";
      rul.className = "vRulerC";
      Ctrl(zid + "_ruler").appendChild(rul);
    }
  }
}

function resizeZoneRulers() {
  var rulers = document.getElementsByClassName("vRuler");
  var zid = "";
  for (var i = 0; i < rulers.length; i++) {
    zid = rulers[i].id.substring(0, rulers[i].id.indexOf("_"));
    rulers[i].style.height = Ctrl(zid).offsetHeight + "px";
    rulers[i].style.top = Ctrl(zid).offsetTop + "px";
    generateRulerCanvasVZone(rulers[i].id + "c", getOffset(Ctrl(zid)).h + 30, workunit);
  }
}

function generateGrid(divparent, div, workunit) {
  var w = Math.max(Ctrl("backcanvas").offsetWidth - 2, divparent.offsetWidth - 2);
  var h = divparent.offsetHeight;
  var clGridLib = new RulersLib();
  clGridLib.alphaChannel = 0;
  clGridLib.Init(div, workunit); // div-canvas del righello
  clGridLib.SetScale(CanvasLib.scale); //eventuale zoom
  clGridLib.DrawGrid(w, h, gridtype, [103, 103, 103], 0.3, unittick);
  calcGridUnit(clGridLib.scale);
}

var stepUnit = 0;
function calcGridUnit(scale) {
  if (!scale)
    scale = 100;  // default

  var unit = 1;
  if (workunit == "mm" || workunit == "cm")
    unit = (96 / 72) * 2.834;

  switch (unittick) {
    case "25":
      stepUnit = (unit * 2) * scale / 100;
      break;
    case "50":
      stepUnit = (unit * 5) * scale / 100;
      break;
    default:  // 100
      stepUnit = (unit * 10) * scale / 100;
      break;
  }
}

function generateRulerCanvasV(div, len, workunit) {
  if (clVRRulersLib == null) {
    clVRRulersLib = new RulersLib();
  }
  clVRRulersLib.Init(div, workunit); // div-canvas del righello
  clVRRulersLib.SetScale(CanvasLib.scale); //eventuale zoom
  clVRRulersLib.DrawVertical(len);
}

function generateRulerCanvasVNoview() {
  Ctrl("v_rulerc").innerHTML = "";
}

function generateRulerCanvasVZone(div, len, workunit) {
  var clVRRulersLibx = new RulersLib();
  clVRRulersLibx.Init(div, workunit); // div-canvas del righello
  clVRRulersLibx.SetScale(CanvasLib.scale); //eventuale zoom
  clVRRulersLibx.DrawVertical(len);
}

function generateRulerCanvasH(div, len, workunit) {
  if (clHRRulersLib == null) {
    clHRRulersLib = new RulersLib();
  }
  clHRRulersLib.Init(div, workunit); // div-canvas del righello
  clHRRulersLib.SetScale(CanvasLib.scale); //eventuale zoom
  clHRRulersLib.DrawHorizontal(len, [103, 103, 103]);
}

function writeHTML(reset) {
  if (reset) {
    Ctrl("canvashandlers").innerHTML = "";
    index = null;
    mainitem = null;
    myItems = [];
  }
  updateRulersGridPosition();
  resetMenuItems();
}

function updateRulersGridPosition() {
  var rleft = Ctrl("v_ruler").offsetLeft;
  if (Ctrl("rulergridopt").offsetLeft != rleft)
    Ctrl("rulergridopt").style.left = rleft + "px";
  if (Ctrl("v_ruler_zones").offsetLeft != rleft)
    Ctrl("v_ruler_zones").style.left = rleft + "px";
}

var xpos, ypos;
var genItemSize = { w: 80, h: 20 };
var reportZones = [];
var gBreakFields = [];

var idItemsHTML = [];
var uidItemsHTML = [];

function drawLabel(isFieldLabel, value, isCont) {
  var zone = identifyZone(ypos),
    ok = true;
  if (validatePosition(zone) && zone != "groupbreak") {
    if (Empty(value) && !Empty(idFld))
      value = getFieldInfo(idFld).desc;

    var pos = {};
    pos.x = xpos;
    pos.y = isFieldLabel ? ypos : ypos - 1; // bordo
    pos.w = Ctrl(idFld + "_shadow").offsetWidth;
    if (isFieldLabel)
      pos.w = 174;
    pos.h = Ctrl(idFld + "_shadow").offsetHeight;

    itemsHTML[countindex] = new ZTObjects.labelObj(nitem, null, pos, value, "", isCont);
    itemsHTML[countindex].zone = zone;
    itemsHTML[countindex].isAllFields = (isFieldLabel && isCont);

    pushToMaps(zone);

    countindex++;
    nitem++;

    Ctrl(zone + "items").innerHTML += itemsHTML[countindex - 1].html;

    itemsHTML[countindex - 1].uidfor = itemsHTML[countindex - 1].uid;
    $(itemsHTML[countindex - 1].id).addClass(itemsHTML[countindex - 1].uidfor);

    itemsHTML[countindex - 1].x = Ctrl(itemsHTML[countindex - 1].id).offsetLeft;
    itemsHTML[countindex - 1].y = Ctrl(itemsHTML[countindex - 1].id).offsetTop;
    itemsHTML[countindex - 1].yRel = itemsHTML[countindex - 1].y - Ctrl(itemsHTML[countindex - 1].zone).offsetTop;

    AdjustMove(itemsHTML[countindex - 1], true);
    if (!isFieldLabel)
      pushToHistory();
  }
  else ok = false;
  if (ok) {
    index = countindex - 1;
    if (!isFieldLabel) {
      updateClassZones();
    }
  }
  index = null;

  document.body.style.cursor = "default";
  Ctrl("canvas").onmousemove = null;
  Ctrl("canvas").onmousedown = beginDragSelection;
  SetUpdated();
}

function updateClassZones() {
  for (var i = 0; i < reportZones.length; i++) {
    $(reportZones[i]).removeClass("contentZoneHighlight");
    $(reportZones[i]).removeClass("availableContentZone");
  }
}

function drawField() {
  var zone = identifyZone(ypos);
  var ok = false;
  var labelw = 174;

  var field = getFieldInfo(idFld);
  if (validatePosition(zone) && zone != "groupbreak") {
    field.tView = "";

    var pos = {};
    pos.x = xpos + labelw + 5;// bordo - old (xpos+descWidth+offset);
    pos.y = ypos; // bordo
    pos.w = calculateMaxWidth(field);//Ctrl(idFld+"_shadow").offsetWidth;
    pos.h = Ctrl(idFld + "_shadow").offsetHeight;
    itemsHTML[countindex] = new ZTObjects.fldObj(nitem, null, pos, field, false);
    itemsHTML[countindex].zone = zone;

    pushToMaps(zone);

    countindex++;
    nitem++;

    Ctrl(zone + "items").innerHTML += itemsHTML[countindex - 1].html;
    updTextToImage(itemsHTML[countindex - 1]);

    itemsHTML[countindex - 1].uidfor = itemsHTML[countindex - 1].uid;
    $(itemsHTML[countindex - 1].id).addClass(itemsHTML[countindex - 1].uidfor);

    itemsHTML[countindex - 1].x = Ctrl(itemsHTML[countindex - 1].id).offsetLeft;
    itemsHTML[countindex - 1].y = Ctrl(itemsHTML[countindex - 1].id).offsetTop;
    itemsHTML[countindex - 1].yRel = itemsHTML[countindex - 1].y - Ctrl(itemsHTML[countindex - 1].zone).offsetTop;
    itemsHTML[countindex - 1].fieldLabel = itemsHTML[countindex - 2].uid;

    AdjustMove(itemsHTML[countindex - 1], true);
    pushToHistory();

    ok = true;
    setMapFieldCount(itemsHTML[countindex - 1].fieldDet.alias);
    setUsedField(itemsHTML[countindex - 1].fieldDet.alias);
  }
  else if (zone == "groupbreak") {
    addFieldsSwitch(field.desc);
    gBreakFields.push(field.alias);
    if (m_CurrentObj == null) m_CurrentObj = getFromDesignObj();
    m_CurrentObj.groupbreak.items = gBreakFields;
    pushToHistory();
  }
  else {
    PSAlert.alert("Not allowed");
  }

  if (ok) {
    index = countindex - 1;
  }

  index = null;

  document.body.style.cursor = "default";
  Ctrl("canvas").onmousemove = null;
  Ctrl("canvas").onmousedown = beginDragSelection;
  SetUpdated();
}

function addFieldUsedClass(id) {
  if (Empty(Ctrl(id))) return;
  $(Ctrl(id).parentNode.id).removeClass("notused");
  $(Ctrl(id).parentNode.id).removeClass("fieldObjectUsed");

  $(Ctrl(id).parentNode.id).addClass("used");
  $(Ctrl(id).parentNode.id).addClass("fieldObjectUsed");
}

function removeFieldUsedClass(id) {
  if (Empty(Ctrl(id))) return;
  $(Ctrl(id).parentNode.id).removeClass("used");
  $(id).removeClass("fieldObjectUsed");
  $(id + "len").removeClass("fieldObjectLenUsed");
  $(id + "lenColor").removeClass("fieldObjectLenCUsed");

  $(Ctrl(id).parentNode.id).addClass("notused");
}

function getFieldInfo(idFld) {
  var ret = {};
  var found = false;
  for (var i = 0; i < fieldHTML.length && !found; i++) {
    if (fieldHTML[i].id == idFld) {
      found = true;
      ret.alias = fieldHTML[i].alias;
      ret.desc = fieldHTML[i].desc;
      ret.type = fieldHTML[i].type;
      ret.len = fieldHTML[i].len;
      ret.dec = fieldHTML[i].dec;
    }
  }
  return ret;
}

function getFieldHTMLIndex(idFld) {
  var ret = -1;
  var found = false;
  for (var i = 0; i < fieldHTML.length && !found; i++) {
    if (fieldHTML[i].id == idFld) {
      found = true;
      ret = i;
    }
  }
  return ret;
}

function getFieldDescription(fldAlias) {
  var ret = "";
  var found = false;
  for (var i = 0; i < fieldHTML.length && !found; i++) {
    if (fieldHTML[i].alias == fldAlias) {
      found = true;
      ret = fieldHTML[i].desc;
    }
  }
  return ret;
}

function getFieldAlias(fldDesc) {
  var ret = "";
  var found = false;
  for (var i = 0; i < fieldHTML.length && !found; i++) {
    if (fieldHTML[i].desc == fldDesc) {
      found = true;
      ret = fieldHTML[i].alias;
    }
  }
  return ret;
}

function getFieldType(fldAlias) {
  var ret = "";
  var found = false;
  for (var i = 0; i < fieldHTML.length && !found; i++) {
    if (fieldHTML[i].alias == fldAlias) {
      found = true;
      ret = fieldHTML[i].type;
    }
  }
  return ret;
}

function validatePosition(zone) {
  if (Empty(zone))
    return false;
  return true;
}

function identifyZone(ypos) {
  var retZ = "";

  for (var i = 0; i < reportZones.length && Empty(retZ); i++) {
    if (Ctrl(reportZones[i]).offsetHeight > 0 && ypos >= Ctrl(reportZones[i]).offsetTop && ypos <= (Ctrl(reportZones[i]).offsetTop + Ctrl(reportZones[i]).offsetHeight))
      retZ = reportZones[i];
  }

  return retZ;
}

function highlightZone(e, pos, elementShadow, xxpos, type, isGeneric) {
  if (!pos) {
    calcPosition(e);
    pos = ypos;
  }

  afterMoveShadow(elementShadow, pos, true, type, isGeneric);

  for (var i = 0; i < reportZones.length; i++) {
    if (reportZones[i] == "groupbreak" && isGeneric)
      continue;
    $(reportZones[i]).removeClass("contentZoneHighlight");
    $(reportZones[i]).addClass("availableContentZone");
    if (xxpos >= 0 && (pos + Ctrl("backcanvas").scrollTop) >= Ctrl(reportZones[i]).offsetTop && (pos + Ctrl("backcanvas").scrollTop) <= (Ctrl(reportZones[i]).offsetTop + Ctrl(reportZones[i]).offsetHeight))
      $(reportZones[i]).addClass("contentZoneHighlight");
  }
}

function calcPosition(e) {
  if (!e)
    e = window.event;
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

var nfld = 0;
var fieldHTMLMap = [];
function loadFields() {
  if (Empty(formProp.datasource) && !Empty(fieldHTML))
    fieldHTML = [];
  if (!Empty(fieldHTML) && m_CurrentObj && m_CurrentObj.datasource == formProp.datasource && m_CurrentObj.offline == isoffline)
    return;

  if (Empty(formProp.datasource)) {
    $("fieldLegend").addClass("hiddenZone");
  }
  else
    drawFieldLegend("fieldLegend");
  Ctrl("toolbarfld").innerHTML = "";
  Ctrl("toolbarfldhandlers").innerHTML = "";
  nfld = 0;
  fieldHTML = [];
  fieldHTMLMap = [];
  fieldcountindex = 0;
  var allFields;
  if (fields && !Empty(fields) && fields.length > 0)
    allFields = fields;
  else
    allFields = getDatasourceFields(formProp.datasource, isoffline);
  var totF = allFields.length;
  for (var i = 0; i < totF; i++) {
    //if(!allFields[i].hiddenfield)
    listField(formProp.datasource, allFields[i].alias, allFields[i].desc, allFields[i].len, allFields[i].type, allFields[i].dec);
  }
  fld_accordion.display(0);
}

function drawFieldLegend(divid) {
  if (Empty(formProp.datasource))
    return;
  $(divid).removeClass("hiddenZone");
  if (!Empty(Ctrl("used")) && !Empty(Ctrl("notused")))
    return;

  var div = document.createElement("div");
  div.className = divid;
  var elem = document.createElement("span")
  elem.id = "notused_lbl";
  div.appendChild(elem);
  elem = document.createElement("span")
  elem.id = "used_lbl";
  div.appendChild(elem);
  Ctrl(divid).appendChild(div);

  var nusedObj = {
    name: "not used",
    propID: "notused",
    tooltip: "Filter not used fields",
    actions: "filterFields"
  };
  var usedObj = {
    name: "used",
    propID: "used",
    tooltip: "Filter used fields",
    actions: "filterFields"
  };
  drawSwitch(nusedObj, "notused_lbl", true);
  drawSwitch(usedObj, "used_lbl", true);
  $("switch_notused").addClass("marginsswitch");
  Ctrl("switch_notused").style.marginRight = "17px";
  $("switch_used").addClass("marginsswitch");
}

function loadFieldsInput() {
  SetOnEditProp(false);
  var str = LRTrim(Ctrl('fielddatasource').value);
  if (str == formProp.datasource) return;
  Ctrl("toolbarfld").innerHTML = "";
  formProp.datasource = str;
  loadFields();
  if (m_CurrentObj == null) m_CurrentObj = getFromDesignObj();
  updateMCurrentObj("datasource", str);
  updateMCurrentObj("offline", isoffline);
  decodeReportObj(m_CurrentObj, formProp.repcustom);
  pushToHistory();
}

function setVdmMask() {
  SetOnEditProp(false);
  var str = LRTrim(Ctrl('vdmfileinput').value);
  if (str == formProp.vdmfile)
    return;
  formProp.vdmfile = str;
  if (m_CurrentObj == null)
    m_CurrentObj = getFromDesignObj();
  updateMCurrentObj("vdmMask", str);
  maskobj = null;
  decodeReportObj(m_CurrentObj, formProp.repcustom);
  pushToHistory();
}

/** DRAG AND DROP FIELDS **/
var idFld = "";
var disableOtherDrag = false;
function drawFldShadow(e, ctrl) {
  if (disableOtherDrag)
    return;

  if (ctrl.id.indexOf("_shadow") >= 0) {
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
  idFld = ctrl.id;
  shadowDD.id = ctrl.id + "_shadow";
  shadowDD.className = "unselectable dragdropshadow";

  var abpos = (getAbsolutePos(ctrl));
  shadowDD.style.left = abpos.x + "px";
  shadowDD.style.top = abpos.y - Ctrl("fieldprop").scrollTop - 1 + "px";
  shadowDD.style.marginTop = "";
  shadowDD.style.marginLeft = "";

  document.body.appendChild(shadowDD);

  /*var shadowlabel = document.createElement("div");
  shadowlabel.id = shadowDD.id+"_shadowlabel";
  shadowlabel.style.marginTop = "";
  shadowlabel.style.marginLeft = "";
  shadowlabel.style.left = 0 + "px";
  shadowlabel.style.top = 0 + "px";
  shadowlabel.style.height = shadowDD.offsetHeight + "px";
  shadowlabel.style.width = descWidth + "px";
  shadowlabel.style.cssFloat = 'left';
  shadowlabel.style.position = "relative";
  shadowlabel.style.overflow = 'hidden';
  shadowlabel.innerHTML = "";
  shadowlabel.className="";
  shadowDD.appendChild(shadowlabel);

  shadowlabel = document.createElement("div");
  shadowlabel.id = shadowDD.id+"_shadowfield";
  shadowlabel.style.marginTop = "";
  shadowlabel.style.marginLeft = "";
  shadowlabel.style.left = offset + "px";
  shadowlabel.style.top = 0 + "px";
  shadowlabel.style.height = shadowDD.offsetHeight + "px";
  shadowlabel.style.position = "relative";
  shadowlabel.style.overflow = 'hidden';
  shadowlabel.style.display = 'none';
  shadowlabel.innerHTML = "";
  shadowlabel.className="";
  shadowDD.appendChild(shadowlabel);*/

  if (Empty(e.targetTouches)) {
    shadowDD.onmousedown = dragField;
    shadowDD.onmouseup = endPutField;
  }
  else {
    ctrlid = ctrl.id;
    dragField(e);
  }
}

var dx, dy;
function dragField(e) {
  removeAllHandlers();
  var descWidth = (lenFactor * maxWidth);
  Ctrl(idFld + "_shadow").style.width = descWidth + "px";
  $(idFld + "_shadow").addClass("dragdropshadowmovefield");
  e = (e) ? e : window.event;
  xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;

  dx = -10;
  dy = -10;

  if (Empty(e.targetTouches)) {
    document.body.style.cursor = "move";
    document.body.onmousemove = putField;
  }
  else
    Ctrl(ctrlid).addEventListener("touchmove", putField);
}

var dPos, myItems = [], myZone;
function putField(e) {
  disableOtherDrag = true;
  dPos = [];
  $(idFld + "_shadow").removeClass("dragdropshadowout");
  $(idFld + "_shadow").addClass("dragdropshadowmovefield");

  e = (e) ? e : window.event;
  if (Empty(e.targetTouches)) {
    xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  }
  else {
    xpos = (e.targetTouches[0].pageX) ? e.targetTouches[0].pageX : (e.targetTouches[0].clientX) ? e.targetTouches[0].clientX : 0;
    ypos = (e.targetTouches[0].pageY) ? e.targetTouches[0].pageY : (e.targetTouches[0].clientY) ? e.targetTouches[0].clientY : 0;
  }

  xpos += dx;

  var findex = getFieldHTMLIndex(idFld);
  Ctrl(idFld + "_shadow").innerHTML = ToStringHTML("[" + fieldHTML[findex].desc + "]");

  var diffX = - (Ctrl("backcanvas").offsetLeft + Ctrl("canvas").offsetLeft) + Ctrl("backcanvas").scrollLeft;
  var diffY = - (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop) + Ctrl("backcanvas").scrollTop;

  var xxpos = parseInt(xpos) + diffX;
  highlightZone(e, ypos - (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop), Ctrl(idFld + "_shadow"), xxpos, "field");

  var mY = (ypos + dy) + diffY;

  myZone = identifyZone(mY);
  myItems = !Empty(myZone) ? getAreaItems(myZone) : [];

  var crossItems = getCrossZoneItems(myZone);
  if (crossItems) myItems = myItems.concat(crossItems).unique();

  // calcolo snap to grid
  var gridPos = [xpos, ypos + dy];
  if (formProp.snapgrid && !Empty(myZone) && xxpos >= 0)
    gridPos = calcSnapToGrid(true, xxpos, mY, Ctrl(myZone).offsetTop);

  Ctrl(idFld + "_shadow").style.left = gridPos[0] + "px";
  Ctrl(idFld + "_shadow").style.top = gridPos[1] + "px";

  // ricalcolo posizioni dello snap
  xxpos = gridPos[0] + diffX;
  mY = gridPos[1] + diffY;

  dPos = [xxpos, mY];

  if (Empty(e.targetTouches))
    document.body.onmouseup = endPutField;
  else
    Ctrl(ctrlid).addEventListener("touchend", endPutField);
}

function endPutField(/*e*/) {
  $("tooltip_box").addClass("hiddenAdd");
  Ctrl("tooltip_box").textContent = "";
  if (Empty(dPos)) return;
  xpos = dPos[0];
  ypos = dPos[1];
  if (xpos >= 0) {
    drawLabel(true);
    drawField();
    setModifiedZone(itemsHTML[itemsHTML.length - 1].zone);
  }

  updateClassZones();
  document.body.removeChild(Ctrl(idFld + "_shadow"));
  document.body.style.cursor = "auto";
  document.body.onmousedown = null;
  document.body.onmousemove = null;
  document.body.onmouseup = null;

  idFld = "";
  dPos = null;
  myItems = [];
  myZone = "";
  ctrlid = "";
  disableOtherDrag = false;
}

function addRulersLines() {
  if (!Empty(clHRRulersLib) && !Empty(mainitem)) {
    clHRRulersLib.AddHorizontalLine("shadowHLL" + mainitem.id, mainitem.offsetLeft, parseInt(Ctrl("h_ruler").style.top), genericColor, mainitem.id);
    clHRRulersLib.AddHorizontalLine("shadowHLR" + mainitem.id, mainitem.offsetLeft + mainitem.offsetWidth, parseInt(Ctrl("h_ruler").style.top), genericColor, mainitem.id);
  }
  if (!Empty(clVRRulersLib) && !Empty(mainitem)) {
    clVRRulersLib.AddVerticalLine("shadowVLL" + mainitem.id, parseInt(Ctrl("v_ruler").style.left), mainitem.offsetTop, genericColor, mainitem.id);
    clVRRulersLib.AddVerticalLine("shadowVLR" + mainitem.id, parseInt(Ctrl("v_ruler").style.left), mainitem.offsetTop + mainitem.offsetHeight, genericColor, mainitem.id);
  }
}

function editItemEvent(/*e,ctrl,itemObj*/) {
}

function drawInputArea(inputarea, value, parent) {
  $(inputarea.id).removeClass("hiddenZone");
  if (parent) {
    inputarea.style.width = parent.offsetWidth + "px";
    inputarea.style.height = parent.offsetHeight + "px";
  }
  inputarea.value = value;
  SetOnEditProp(true);
  inputarea.focus();
}

function inputareaToItem(e) {
  if (!$("inputarea").hasClass("hiddenZone")) {
    var idx = -1;
    for (var i = 0; i < container_selection.e.length; i++) {
      idx = container_selection.e[i];
      if (itemsHTML[idx].type == "label")
        itemsHTML[idx].value = Ctrl("inputarea").value;
      else
        itemsHTML[idx].fieldDet.desc = Ctrl("inputarea").value;
      var arr = Ctrl("inputarea").value.split(/[\n\r]/g);
      Ctrl(itemsHTML[idx].id + "_int").innerHTML = "";
      for (var k = 0; k < arr.length - 1; k++)
        Ctrl(itemsHTML[idx].id + "_int").innerHTML += ToStringHTML(arr[k]) + "<br/>";
      Ctrl(itemsHTML[idx].id + "_int").innerHTML += ToStringHTML(arr[arr.length - 1]);
    }
    closeEditInput(e);
    UpdateDesignObj(itemsHTML[index], "value");
  }
}

function closeEditInput(e) {
  if (index == null || index == undefined)
    return;
  e = !e ? window.event : e;
  $("editinput").addClass("hiddenZone");
  if (GetEventSrcElement(e).id == "editinputclose")
    $("inputarea").addClass("hiddenZone");
  $("inputcombo").addClass("hiddenZone");
  Ctrl("canvas").onmousedown = beginDragSelection;
}

function inputareaKeyUp(/*e*/) {
  /* if (e.keyCode === 13) {
     SetOnEditProp(false)
   var inputarea = Ctrl("inputarea");
   if(index!=null){
     Ctrl(itemsHTML[index].id+"_int").innerHTML = ToHTML(inputarea.value);
     itemsHTML[index].value = inputarea.value;
   }
   //inputarea.style.display='none';
   }*/
  return true;
}

function AdjustMove(elem, noShadow) {
  if (viewMode != designView) {
    UpdateDesignObj(elem, "position");
    return;
  }

  var shadow = noShadow ? Ctrl(elem.id) : Ctrl(elem.shadow);
  var zone = (viewMode != designView) ? elem.zone : identifyZone(shadow.offsetTop);
  if (zone == "groupbreak") zone = "";

  if (Empty(zone) && !noShadow) {
    shadow.style.top = Ctrl(elem.id).style.top;
    shadow.style.left = Ctrl(elem.id).style.left;
    PSAlert.alert("Not allowed");
  }

  if (Ctrl(elem.id).offsetLeft < 0) {
    xpos = 0;
    Ctrl(elem.id).style.left = xpos + "px";
  }

  if (Ctrl(elem.id).offsetTop < 0) {
    ypos = 0;
    Ctrl(elem.id).style.top = ypos + "px";
  }
  var diff;
  if (!Empty(zone) && (shadow.offsetTop + shadow.offsetHeight) > (Ctrl(zone).offsetTop + Ctrl(zone).offsetHeight)) {
    diff = (shadow.offsetTop + shadow.offsetHeight) - (Ctrl(zone).offsetTop + Ctrl(zone).offsetHeight);
    Ctrl(zone).style.height = Ctrl(zone).offsetHeight + diff + "px";
    if (m_CurrentObj !== null) {
      var mzone = Strtran(zone, "content", "");
      m_CurrentObj[mzone].height = Ctrl(zone).offsetHeight;
    }
    drawLimitBars();
  }

  if (!Empty(zone) && zone != elem.zone) {
    Ctrl(zone + "items").appendChild(Ctrl(elem.id));
    elem.prevzone = elem.zone;
    elem.zone = zone;
    UpdateDesignObj(elem, "zone");
    elem.prevzone = null;
  }
  else
    UpdateDesignObj(elem, "zonecheck");

  /*
  if(Ctrl(elem.id+"_missing")){
    Ctrl(elem.id+"_missing").style.width = (elem.w)+"px";
    Ctrl(elem.id+"_missing").style.height = (elem.h)+"px";
    Ctrl(elem.id+"_missing").style.backgroundSize = (elem.h/4)+"px "+elem.h+"px";
  }
  */
  var barW = Ctrl(Strtran(Ctrl(elem.id).parentNode.id, "contentitems", "")).offsetWidth;
  var itW = Ctrl(elem.id).offsetWidth + Ctrl(elem.id).offsetLeft;
  if (barW < itW) {
    diff = itW - barW;
    resizeWindow();
    Ctrl("canvas").style.width = (Ctrl("canvas").offsetWidth + diff) + "px";
    drawLimitBars();
  }

  UpdateDesignObj(elem, "position");

  return;
}

function afterMoveShadow(elementShadow, pos, isFld, type, isGeneric) {
  if (viewMode != designView)
    return;

  var topPos, leftPos;
  if (pos == null)
    topPos = elementShadow.offsetTop - Ctrl("backcanvas").scrollTop;
  else
    topPos = pos;
  if (isFld)
    leftPos = elementShadow.offsetLeft - Ctrl("backcanvas").offsetLeft;
  else
    leftPos = elementShadow.offsetLeft;

  var mzone;
  if (viewMode != designView)
    mzone = "documentview";
  else
    mzone = identifyZone(topPos + Ctrl("backcanvas").scrollTop);

  document.body.style.cursor = "default";
  var ttxt = "";
  if (leftPos < 0) {
    document.body.style.cursor = "not-allowed";
    ttxt = "Dragging " + type;
  }
  else if (Empty(mzone) || ((!isFld || isGeneric) && mzone == "groupbreak")) {
    document.body.style.cursor = "not-allowed";
    if (isFld && !isGeneric) $(elementShadow.id).removeClass("dragdropshadowmovefield");
    else $(elementShadow.id).removeClass("dragdropshadowmove");
    $(elementShadow.id).addClass("dragdropshadowout");
    ttxt = getTranslated("SMR_NOTALLOWED", "Not allowed to add items here");
  }
  else if (isFld && !isGeneric && mzone == "groupbreak") {
    document.body.style.cursor = "default";
    if (isFld && !isGeneric) {
      $(elementShadow.id).removeClass("dragdropshadowmovefield");
      $(elementShadow.id).removeClass("dragdropshadowout");
      $(elementShadow.id).addClass("dragdropshadowbreak");
    }
    ttxt = getTranslated("SMR_ADDTOBREAKGROUP", "Add " + type + " as break group condition");
  }
  else {
    ttxt = getTranslated("SMR_ADDTOSECTION", "Add " + type + " in " + zoneToSection(identifyZone(topPos + Ctrl("backcanvas").scrollTop)) + " section");
    $(elementShadow.id).removeClass("dragdropshadowout");
  }

  if (isFld)
    setTooltipText(ttxt, pos);
  return;
}

function zoneToSection(zone) {
  switch (zone) {
    case "reportheadercontent":
      return "Report Header";
      break;
    case "pageheadercontent":
      return "Page Header";
      break;
    case "groupheadercontent":
      return "Group Header";
      break;
    case "groupbodycontent":
      return "Body Detail";
      break;
    case "groupfootercontent":
      return "Group Footer";
      break;
    case "pagefootercontent":
      return "Page Footer";
      break;
    case "reportfootercontent":
      return "Report Footer";
      break;
  }
}

function deleteItem(/*isreplace*/) {
  setLoading();
  if (!Empty(container_selection.e)) {
    for (var k = 0; k < container_selection.e.length; k++) {
      index = container_selection.e[k];
      var mainItem = itemsHTML[index];
      if (mainItem.type == "field")
        updateMapFieldCount(mainItem.fieldDet.alias);
      setModifiedZone(mainItem.zone);
      UpdateDesignObj(mainItem, "remove");
    }
  }
  container_selection.e = [];
  pushToHistory();
  drawEditor();
}

function addZonesSwitch() {
  for (var i = 0; i < reportZones.length; i++)
    drawZonesSwitch(formProp.objClass.newProperties[Strtran(reportZones[i], "content", "")], Strtran(reportZones[i], "content", ""), true);
}

function updateSwitch(zone, propObj) {
  var pl = propObj;
  if (!pl) pl = formProp.objClass.newProperties[zone];
  if (!pl) return;
  for (var i = 0; i < pl.length; i++) {
    var propID = zone + "_" + pl[i].propID;
    var c = Ctrl(propID);
    if (c) {
      if (c.type == 'checkbox') {
        if (c.checked != formProp[pl[i].propID])
          manageOnOff(c.dispatchEvent(new MouseEvent("click")), c);
      }
    }
    else if (scrollMap[pl[i].propID]) {
      scrollMap[pl[i].propID].toElement(pl[i].propID + "_" + formProp[pl[i].propID]);
    }
  }
}

function getMaxWordLength(myList) {
  //replace "." by W --- because > width
  var myMax = Strtran(LRTrim(myList[0] + ""), ".", "W");
  for (var i = 1; i < myList.length; i++) {
    var m = Strtran(LRTrim(myList[i] + ""), ".", "W");
    if (m.length > myMax.length)
      myMax = m;
  }
  return myMax;
}
/* end */

function addFieldsSwitch(fldText, isMissing) {
  var zone = Ctrl("groupbreakcontentitems");
  zone.className = "unselectable breakZone designView";
  var str, propSwitch, prop;
  if (isMissing)
    prop = "groupbreakFIELD_" + fldText;
  else
    prop = "groupbreakFIELD_" + getFieldAlias(fldText);

  if (document.getElementById(prop)) {
    Ctrl("canvas").onmousemove = null;
    Ctrl("canvas").onmousedown = null;
    return;
  }

  str = "";

  propSwitch = document.createElement("div");
  propSwitch.id = prop;
  propSwitch.className = "fieldprop";
  propSwitch.title = fldText;

  str += "<label ";
  str += "class='fieldprop-label' ";
  str += "for='" + prop + "field' ";
  str += ">";

  str += "<div ";
  str += "id='" + prop + "_text' ";
  str += "class='fieldprop-inner'";
  str += "style='height:" + (zone.offsetHeight - 5) + "px;";
  str += "line-height:" + (zone.offsetHeight - 5) + "px;'";
  str += ">";
  if (fldText.length > 13)
    str += (fldText.substring(0, 12) + "...");
  else
    str += fldText;
  str += "</div>";

  str += "<span ";
  str += "id='" + prop + "fieldswitch' ";
  str += "class='fieldprop-switch smartreport-icon-delete' ";
  str += "style='";
  str += "height:" + (zone.offsetHeight - 9) + "px;";
  str += "width:" + (zone.offsetHeight - 9) + "px;";
  str += "background-size:" + (zone.offsetHeight - 9) + "px;";
  str += "'";
  str += "onclick='removeFieldsSwitch(event)' ";
  str += "title='" + "Remove (" + fldText + ")" + "'";
  str += ">";

  str += "</span>";
  str += "</label>";

  propSwitch.innerHTML = str;

  zone.appendChild(propSwitch);

  removeSpanTag();

  if (isMissing) {
    prop = {};
    prop.id = "groupbreakFIELD_" + fldText;
    prop.w = Ctrl("groupbreakFIELD_" + fldText).offsetWidth - (zone.offsetHeight - 9);
    prop.h = Ctrl("groupbreakFIELD_" + fldText).offsetHeight;
    prop.fleft = "normal";
    prop.fcenter = "center";
    prop.fright = "normal";
    drawMissingIcon(prop);
    //Ctrl("groupbreakFIELD_"+fldText).ondblclick = openEditArea;
  }
}

function openEditArea(e, ctrl) {
  if (!ctrl)
    ctrl = GetEventSrcElement(e);

  // e' sempre lo span
  if (ctrl) {
    Ctrl("eititle").textContent = getTranslated("SMR_NEWDATAFIELD", "Set new data field");
    Ctrl("eititle").style.width = "190px";
    $("editinput").removeClass("hiddenZone");
    Ctrl("editinput").style.top = (ctrl.parentNode.offsetTop + 20) + "px";  // metto +20 perche' cosi' si vede il bottone close
    Ctrl("editinput").style.left = ctrl.parentNode.offsetLeft + "px";
    Ctrl("editinput").style.width = "190px";
    Ctrl("editinput").style.height = "150px";

    //Ctrl("editinputclose").style.marginLeft = Ctrl("editinput").offsetWidth + "px";
  }

  drawFieldList(ctrl.parentNode.id);
}

var elementsNrByGroup = [];
function listField(group, fname, desc, len, type, dec) {
  var fspace = 20;
  xpos = 4;
  if (fieldcountindex == 0) {
    ypos = 0;
  }
  else {
    ypos = 0 + fieldcountindex * fspace;
  }
  var ul, li;
  var wrapper = Ctrl(group + "_divz");
  if (!wrapper) {
    elementsNrByGroup[group] = 0;
  }
  if (desc == null || desc.length == 0) {
    desc = fname;
  }

  var checkbox = "";//"<input type='checkbox' id='"+nfld+"_checkbox' class='fieldcheck' style='float: right;margin-top: 7px;' onclick='checkControl(event)' />";
  //htmlObj = '<div id=\'item' + nfld + '\' class="transparent-detail" title=\'' + desc + '\' onselectstart=\'cancelEvent(event)\' style=\'z-index:1;overflow:hidden;border:1px solid #028433;width:' + fwidth + 'px;height:' + fheight + 'px;top:' + (nFieldsGroup + 1) * fspace + 'px;left:' + xpos + 'px;\' onClick="cancelEvent(event);clickItem(event,\'item' + nfld + '\')"><div id=\'item' + nfld + '_int\' style=\'font-size:7pt\'>' + fname + '</div></div>';
  fieldHTML[fieldcountindex] = new ZTObjects.fieldObj("itemField" + nfld, fname, desc, len, type, dec);
  fieldHTMLMap[fname] = fieldcountindex;
  mapFieldCount[fname] = 0;

  nfld++;

  fieldcountindex++;

  if (!wrapper) {
    wrapper = new Element('div', {
      'class': 'fld_wrapper',
      'id': group + '_divz'
    }).inject(Ctrl("toolbarfld"));
    ul = new Element('ul', {
      'class': 'fld_ul'
    }).inject(wrapper);
    li = new Element('li', {
      'id': 'fld_li_' + fname,
      'class': 'fld_li notused'
    }).inject(ul);
    li.innerHTML = checkbox + fieldHTML[fieldcountindex - 1].html;
    fld_accordion.display(0);
    new Element('div', {
      'class': 'list_border'
    }).inject(wrapper);
  }
  else {
    ul = wrapper.getElement('ul');
    li = new Element('li', {
      'id': 'fld_li_' + fname,
      'class': 'fld_li notused'
    }).inject(ul);

    li.innerHTML = checkbox + fieldHTML[fieldcountindex - 1].html;
  }
  elementsNrByGroup[group] = elementsNrByGroup[group] + 1;

  var switchObj = {
    name: "i",
    propID: fname,
    tooltip: "",
    actions: "actionOnField"
  };
  if (viewMode == documentView)
    drawSwitch(switchObj, 'fld_li_' + fname, true, true, true);
}

function ModifyShadow(selecteditem) {
  document.getElementById("shadow" + selecteditem).setStyle('opacity', 0);
}

function removeFieldsSwitch(e) {
  var elemID = GetEventSrcElement(e).parentNode.parentNode.id;
  gBreakFields.splice(gBreakFields.indexOf(Strtran(elemID, "groupbreakFIELD_", "")), 1);
  Ctrl("groupbreakcontentitems").removeChild(Ctrl(elemID));
  if (m_CurrentObj == null) m_CurrentObj = getFromDesignObj();
  m_CurrentObj.groupbreak.items = gBreakFields;
  pushToHistory();
}

function setTooltipText(text, pos) {
  var tooltipSpan = document.getElementById("tooltip_box");
  tooltipSpan.style.display = 'block';
  var tFont = { name: "Open Sans", size: 13, weight: "normal" };
  var width = getOffsetWidth(text, tFont) + 20;
  var height = getOffsetHeight(text, tFont);
  tooltipSpan.className = "tooltipView";
  tooltipSpan.style.top = (pos - height / 2) + 'px';
  tooltipSpan.style.left = xpos + 'px';
  tooltipSpan.style.width = width + "px";
  tooltipSpan.style.height = height + "px";
  // tooltipSpan.style.lineHeight = height + "px";
  tooltipSpan.textContent = text;
  removeSpanTag();
}

var shadowtimeout = null;
var canclick = true;
function insertTooltipItem(e) {
  var idx = parseInt(GetEventSrcElement(e).id.substring(GetEventSrcElement(e).id.indexOf("item") + 4, GetEventSrcElement(e).id.length)); drawFontDetail(itemsHTML[idx], itemsHTML[idx].objClass.newProperties.font);
  GetEventSrcElement(e).style.zIndex = 5;
  GetEventSrcElement(e).appendChild(Ctrl("shadowmenu"));
  Ctrl("shadowmenu").style.display = "none";
  shadowtimeout = setTimeout(function () {
    Ctrl("shadowmenu").style.display = "block";
    canclick = false;
  }, 1000);
}

function removeTooltipItem(/*e*/) {
  clearTimeout(shadowtimeout);
  shadowtimeout = null;
  canclick = true;
  Ctrl("shadowmenu").parentNode.style.zIndex = 3;
  Ctrl("backcanvas").appendChild(Ctrl("shadowmenu"));
  Ctrl("shadowmenu").style.display = "none";
}

// seleziona l'item se cliccato
function clickItem(e, elem) {
  multipleSelection = false;
  var str = "", element;
  if (elem == null)
    element = GetEventSrcElement(e);
  else
    element = elem;
  if (!element.id) {
    while (element.parentNode && element.parentNode.id == "") {
      element = element.parentNode;
    }
    element = element.parentNode;
  }
  if (element.id.indexOf('_') > -1)
    element = Ctrl(element.id.substr(0, element.id.indexOf('_')));

  if ((e == null || e.shiftKey == false) && !ismobile) {
    removeAllHandlers();
  }

  if ($(element.id).hasClass('noclick')) return;

  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].id == element.id) {
      itemsHTML[i].shadow = "shadow" + element.id.substr(4);
      if (container_selection.e.indexOf(i) < 0)
        container_selection.e.push(i);
    }
  }
  str = addHandlers(element.id.substr(4))
  Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str
  selectItem(Ctrl("shadow" + element.id.substr(4)));
  resetMenuItems();
  enableItemButtons(element.id);
  highlightSelectedFieldsLabels();
}

function highlightSelectedFieldsLabels() {
  var mitem;
  for (var i = 0; i < container_selection.e.length; i++) {
    mitem = itemsHTML[container_selection.e[i]];
    if (mitem.type == "field") {
      UpdateDesignObj(mitem.uidfor, "highlightField");
      if (!Empty(mitem.fieldLabel))
        UpdateDesignObj(mitem.fieldLabel, "highlightLabel");
    }
  }
}

/* INIZIO OPERAZIONI SAVE */
var old_name;
function save(then) {
  if (then == 'close') AfterSave = 'close';
  else if (!Empty(then)) { //then è un oggetto che contiene una funzione che deve essere eseguita dopo il salvataggio
    AfterSave = then;
  }
  if (parent) {
    parent.is_Saving = true;
  }
  index = null;

  selectForm();
  if (!Empty(currentname)) {
    notimooManager = new Notimoo({});
    notimooManager.show({
      title: 'Notification message',
      message: 'saving report ' + currentname,
      sticky: true,
      width: 200,
      height: 40
    });
    save2.delay(100);
  }
  else {
    reportsaveAs();
  }
}

var toUpdateObj = false;
function save2(vname) {
  //if (toUpdateObj)
    m_CurrentObj = getFromDesignObj();
  m_CurrentObj.name = vname || currentname;
  currentname = m_CurrentObj.name;
  var strsave = JSON.encode(m_CurrentObj);
  var url = new JSURL("../servlet/SPSVRPProxy?action=save"+
    "&name=" + m_CurrentObj.name +
    "&custom=" + custom +
    "&obj=" + URLenc(strsave) +
    "&m_cID=" + cmdhash
    , true);
  var output = url.Response();
  if (output == null) { output = ""; }
  for (var i = 0; i < notimooManager.elements.length; i++) {
    notimooManager.close(notimooManager.elements[i]);
  }
  if (window.parent.changeName) {
    window.parent.changeName(currentname, '', Strtran(window.frameElement.id, 'portalstudioframe', ''));
  }
  if (output) {
    switch (output) {
      case "ACCESS DENIED":
        //  if (modenoview == false)
        notimooManager.close(notimooManager.elements[0]);
        //  if (modenoview == false)
        PSAlert.alert("Access Denied.");
        break;
      case "saved":
        setTitleName();
        notimooManager.show({
          title: 'Notification message',
          message: 'report saved!',
          visibleTime: 2000,
          width: 200
        });
        if (AfterSave == "close") window.parent.closeCurrentObj();
        else if (!Empty(AfterSave)) {
          AfterSave();
          AfterSave = null;
        }
        if (arguments.length > 0 && arguments[0] == "close") { window.parent.closeCurrentObj(); }
        if (parent) { parent.is_Saving = false; }
        m_bUpdated = false;
        break;
      default:
        PSAlert.alert('Error saving');
        break;
    }
  }
  else {
    PSAlert.alert('Error saving');
  }
}

function reportsaveAs() {
  custom = formProp.repcustom;
  var url = "../portalstudio/saveas.jsp?&tool=smartreport&custom=" + custom + "&save";
  var additionalUrl = "width=580,height=600";
  if (Empty(versionSVRP))
    layerOpenForeground(url, "saveAsSPModalLayer", additionalUrl, "", "", "", 1); // messo x mobile
  else
    layerOpenForeground('../jsp-system/SPSaveVersions_portlet.jsp?typeEditor=smartreport&fileName=' + URLenc(versionSVRP) + "&custom=" + custom, 'saveVersionModalLayer', additionalUrl, "", "", "", 1);
}

function openReport() {
  selectReportPage(0);
  if (m_bUpdated == true) {
    var msg = getTranslated("SMR_CONFIRMSAVE", 'Do you want to save the last changes on report?');
    AfterSave = function () { openReportLayer(); };
    showMessageConfirm(msg, "openReportLayerSave");
  }
  else
    openReportLayer();
}

var AfterSave;
function openReportLayerSave() {
  AfterSave = function () { openReportLayer(); };
  save();
}

function openReportLayer() {
  //setLoading();
  var url = "../portalstudio/open.jsp?tool=smartreport&onetool=true&open";
  var additionalUrl = "width=580,height=600"
  layerOpenForeground(url, "openSPModalLayer", additionalUrl, "", "", "", 1); // messo x mobile
  m_bUpdated = false;
}

function newCurrentObj(name, type, obj, stalone) {
  if (obj && typeof obj == "string")
    obj = JSON.parse(obj);
  custom = obj.custom;
  formProp.repcustom = obj.custom;
  name = Strtran(name, ".svrp", "");
  var url = new JSURL("../servlet/SPSVRPProxy?action=exist&name=" + name + "&custom=" + custom, true);
  var output = url.Response();
  if (parseInt(LRTrim(output)) > 0) {
    url = new JSURL("../servlet/SPSVRPProxy?action=load&name=" + name + "&custom=" + custom, true);
    var currObj = JSON.parse(url.Response());
    resetZones(true);
    m_CurrentObj = currObj;
    decodeReportObj(currObj, custom);
    newHistoryStack();
    currentname = name;
    setTitleName();
    var zone;
    for (var j = 0; j < reportZones.length; j++) {
      zone = Strtran(reportZones[j], "content", "");
      if (zone != "groupbreak" && m_CurrentObj[zone]) {
        orderItemsZone(zone);
      }
    }
    pushToHistory();
    if (stalone) {
      selectReportPage(0);
      Ctrl('loading').style.display = 'none';
    }
  }
  else {
    for (var i = 0; i < notimooManager.elements.length; i++) {
      notimooManager.close(notimooManager.elements[i]);
    }
    PSAlert.alert("Report not found");
    return;
  }
}

function setTitleName() {
  if (svrpTitle) {
    var n;
    if (currentname == "")
      n = getTranslated('NEW_REPORT', 'New report');
    else
      n = currentname;
    svrpTitle.toolbarP.title.Value("SmartReport" + " <span class='SPPortalZoom_currentversion'>" + n + "</span>");
  }
}

function decodeReportObj(obj, custom) {
  countindex = 0;
  itemsHTML = [];
  nitem = 0;
  filename = obj.name;
  if (!dataobj) {
    formProp.datasource = obj.datasource;
    Ctrl('fielddatasource').value = formProp.datasource;
  }
  formProp.vdmfile = obj.vdmMask;
  if (!Empty(formProp.vdmfile))
    Ctrl('vdmfileinput').value = formProp.vdmfile;
  formProp.repcustom = custom;
  isoffline = obj.offline;
  formProp.repcustom = custom || false;
  loadFields();
  resetMapFieldCount();
  decodeFormProperties(obj);

  clearAllZones();

  updateFieldDescriptions(obj);

  decodeZoneItems(obj, "reportheader");
  decodeZoneItems(obj, "pageheader");
  decodeZoneItems(obj, "groupbreak");
  decodeZoneItems(obj, "groupheader");
  decodeZoneItems(obj, "groupbody");
  decodeZoneItems(obj, "groupfooter");
  decodeZoneItems(obj, "pagefooter");
  decodeZoneItems(obj, "reportfooter");

  updateSwitch("reportheader");
  updateSwitch("pageheader");
  updateSwitch("groupbreak");
  updateSwitch("groupheader");
  updateSwitch("groupbody");
  updateSwitch("groupfooter");
  updateSwitch("pagefooter");
  updateSwitch("reportfooter");
  updateSwitch("titlecontent", formProp.objClass.newProperties.custom);

  setDocumentUsedFields();
  drawLimitBars();
}

function decodeFormProperties(obj) {
  formProp.repcomment = obj.comment;
  formProp.pformat = obj.page.format;
  formProp.pwidth = obj.page.width ? obj.page.width : 210;
  formProp.pheight = obj.page.height ? obj.page.height : 297;
  formProp.porientation = obj.page.orientation;
  formProp.mtheight = obj.page.margins.top;
  formProp.mbheight = obj.page.margins.bottom;
  formProp.mlwidth = obj.page.margins.left;
  formProp.mrwidth = obj.page.margins.right;
  // provvisorio
  formProp.snapgrid = obj.snap;

  formProp.showreportzone = obj.showReportZone;
  formProp.showpagezone = obj.showPageZone;
  formProp.showgroupzone = obj.showGroupZone;

  formProp.measureunit = obj.structureGrid.unit;
  formProp.showrulers = obj.structureGrid.showRulers;
  formProp.showgrid = obj.structureGrid.showGrid;

  if (obj.structureGrid.type == "long") {
    formProp.gtypelong = true;
    formProp.gtypesmall = false;
    formProp.gtypeplain = false;
  }
  else if (obj.structureGrid.type == "small") {
    formProp.gtypelong = false;
    formProp.gtypesmall = true;
    formProp.gtypeplain = false;
  }
  else {
    formProp.gtypelong = false;
    formProp.gtypesmall = false;
    formProp.gtypeplain = true;
  }

  if (obj.structureGrid.tick == "50") {
    formProp.tick50 = true;
    formProp.tick100 = false;
  }
  else {
    formProp.tick50 = false;
    formProp.tick100 = true;
  }

  setWorkUnit();
  updateGrid();
  showZone("report", "showreportzone");
  showZone("page", "showpagezone");
  showZone("group", "showgroupzone");
  updRulers();
}

function setZoneOptions(obj, zone) {
  //formProp
  var ctrl = Ctrl(zone + "content");
  if (ctrl) {
    if (ctrl.offsetHeight > 0)
      obj[zone].height = ctrl.offsetHeight;
    else {
      ctrl.style.visibility = 'hidden';
      ctrl.style.display = 'block';
      obj[zone].height = ctrl.offsetHeight;
      ctrl.style.visibility = '';
      ctrl.style.display = '';
    }
  }
  var pl = formProp.objClass.newProperties[zone];
  if (pl && pl.length > 0) {
    obj[zone].options = {};
    for (var i = 0; i < pl.length; i++) {
      var propID = pl[i].propID;
      if (propID.indexOf("reprintOnPage") >= 0)
        obj[zone].options.reprintOnPage = formProp[propID];
      else
        obj[zone].options[propID] = formProp[propID];
    }
  }
}

function getZoneOptions(obj, zone) {
  var ctrl = Ctrl(zone + "content");
  if (obj[zone].height) ctrl.style.height = obj[zone].height + "px";
  var pl = formProp.objClass.newProperties[zone];
  if (pl) {
    var val = "";
    for (var i = 0; i < pl.length; i++) {
      var propID = pl[i].propID;
      if (propID.indexOf("reprintOnPage") >= 0)
        val = obj[zone].options.reprintOnPage;
      else
        val = obj[zone].options[propID];
      if (val === undefined)
        val = false;
      formProp[propID] = val;
    }
  }
}

function clearHTMLZone(zone) {
  var ctrl = Ctrl(zone + "contentitems");
  if (ctrl) ctrl.innerHTML = "";
}

function decodeZoneItems(obj, zone) {
  getZoneOptions(obj, zone);
  var items = obj[zone].items;
  var ctrl = Ctrl(zone + "contentitems");
  var i;
  if (ctrl) {
    ctrl.innerHTML = "";
    if (Empty(items)) return;
    if (zone != "groupbreak") {
      var addAllItems = false,
        tmp_itemsHTML = { label: null, field: null };
      for (i = 0; i < items.length; i++) {
        if (items[i].isAllFields) {
          readJsonItemAllFields(items[i], zone, tmp_itemsHTML);
          addAllItems = true;
         // toUpdateObj = true;
        }
        else
          addInItemsHTML(items[i]);
      }
      if (addAllItems) {
        if (!Empty(tmp_itemsHTML.label))
          addInItemsHTML(tmp_itemsHTML.label, true);
        if (!Empty(tmp_itemsHTML.field))
          addInItemsHTML(tmp_itemsHTML.field, true);
      }
    }
    else {
      for (i = 0; i < items.length; i++) {
        if (getFieldHTMLIndex("itmFld_" + items[i]) >= 0)
          addFieldsSwitch(getFieldDescription(items[i]));
        else
          addFieldsSwitch(items[i], true);
      }
      gBreakFields = items;
    }
  }

  function addInItemsHTML(item, isAllFields) {
    itemsHTML[countindex] = readJsonItem(item, zone, countindex);
    if (isAllFields)
      itemsHTML[countindex].isAllFields = true;
    ctrl.innerHTML += itemsHTML[countindex].html;
    itemsHTML[countindex].uidfor = itemsHTML[countindex].uid;
    $(itemsHTML[countindex].id).addClass(itemsHTML[countindex].uidfor);

    updTextToImage(itemsHTML[countindex]);
    setCalculation(itemsHTML[countindex]);

    if (!isAllFields) {
      if (item.type != "line")
        updateFontProperties(item, itemsHTML[countindex]);
      else
        applyLineStyleProperties(itemsHTML[countindex]);
    }
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

    pushToMaps(zone);

    if (itemsHTML[countindex].type == "field" && !Empty(itemsHTML[countindex].fieldDet.alias))
      setMapFieldCount(itemsHTML[countindex].fieldDet.alias);

    countindex++;
    nitem++;
  }
}

function readJsonItemAllFields(item, zone, tmp_items) {
  var idx_alias = fieldHTMLMap[item.ref_alias],
    item_field = {},
    field = fieldHTML[idx_alias];

  if (Empty(field))
    return;

  if (Empty(_allFieldsHTML[idx_alias])) {
    item_field.index = idx_alias;
    _allFieldsHTML[idx_alias] = item_field;
  }

  if (!(item.type in _allFieldsHTML[idx_alias])) {
    if (item.type == "label")
      _allFieldsHTML[idx_alias].label = new ZTObjects.af_labelObj(field.desc);
    else // field
      _allFieldsHTML[idx_alias].field = new ZTObjects.af_fldObj(field);
    _allFieldsHTML[idx_alias][item.type].zone = zone + "content";
    _allFieldsHTML[idx_alias][item.type].uidfor = item.uidfor;
    updateFontProperties(item, _allFieldsHTML[idx_alias][item.type]);
    if (item.typeView == 'signmup' && item.signmup) {
      _allFieldsHTML[idx_alias][item.type].smdateformat = item.signmup.dateformat;
      _allFieldsHTML[idx_alias][item.type].smtimeformat = item.signmup.timeformat;
      _allFieldsHTML[idx_alias][item.type].sequence = item.signmup.sequence;
      _allFieldsHTML[idx_alias][item.type].brequired = item.signmup.brequired;
      _allFieldsHTML[idx_alias][item.type].bgeoposition = item.signmup.bgeoposition;
      _allFieldsHTML[idx_alias][item.type].bhideextra = item.signmup.bhideextra;
      _allFieldsHTML[idx_alias][item.type].title = item.signmup.title;
    }
    if (item.barcode) {
      _allFieldsHTML[idx_alias][item.type].barcodetype = item.barcode.type;
      _allFieldsHTML[idx_alias][item.type].fcoloroff = item.barcode.pixeloffcolor;
      _allFieldsHTML[idx_alias][item.type].fcoloron = item.barcode.pixeloncolor;
    }
  }
  // creo x itemsHTML
  if (Empty(tmp_items[item.type])) {
    tmp_items[item.type] = {};
    if (item.type == "field") {
      tmp_items[item.type].fieldDetail = {};
      tmp_items[item.type].fieldDetail.alias = "";
      tmp_items[item.type].fieldDetail.desc = "All fields";
    }
    tmp_items[item.type].style = JSON.parse(JSON.stringify(item.style));
    tmp_items[item.type].position = {};
    tmp_items[item.type].position.x = item.position.x;
    tmp_items[item.type].position.y = item.position.y;
    tmp_items[item.type].position.width = item.position.width;
    tmp_items[item.type].position.height = item.position.height;
    tmp_items[item.type].position.yRelative = item.position.yRelative;
    if (item.type == "label") {
      tmp_items[item.type].value = "All fields labels";
      tmp_items[item.type].isContinue = true;
    }
    tmp_items[item.type].zone = zone;
    tmp_items[item.type].isGeneric = true;
    tmp_items[item.type].typeView = item.typeView;
    tmp_items[item.type].type = item.type;
  }

}

function readJsonItem(item, zone, itID, muid, isdoc) {
  var tmpObj = {};
  var posObj = {};
  posObj.x = item.position.x;
  posObj.y = item.position.y;
  posObj.w = item.position.width;
  posObj.h = item.position.height;

  if (Empty(muid)) muid = item.uid;
  switch (item.type) {
    case "label":
      tmpObj = new ZTObjects.labelObj(itID, muid, posObj, item.value, "", item.isContinue, isdoc);
      tmpObj.fstretchr = item.style.stretchToRight;
      break;
    case "field":
      var fieldD = (JSON.parse(JSON.stringify(item.fieldDetail)));
      fieldD.tView = item.typeView;
      tmpObj = new ZTObjects.fldObj(itID, muid, posObj, fieldD, item.isGeneric, item.picture, item.style.imageSrc, item.calculation, isdoc);
      tmpObj.fieldLabel = item.fieldLabel;
      tmpObj.fieldTotal = item.fieldTotal;
      if (tmpObj.typeView != "image")
        tmpObj.fstretchr = item.style.stretchToRight;
      if (tmpObj.typeView == 'signmup' && item.signmup) {
        tmpObj.smdateformat = item.signmup.dateformat;
        tmpObj.smtimeformat = item.signmup.timeformat;
        tmpObj.sequence = item.signmup.sequence;
        tmpObj.brequired = item.signmup.brequired;
        tmpObj.bgeoposition = item.signmup.bgeoposition;
        tmpObj.bhideextra = item.signmup.bhideextra;
        tmpObj.title = item.signmup.title;
      }
      if (/*tmpObj.typeView == 'barcode' &&*/ item.barcode) {
        tmpObj.barcodetype = item.barcode.type;
        tmpObj.fcoloroff = item.barcode.pixeloffcolor;
        tmpObj.fcoloron = item.barcode.pixeloncolor;
        //tmpObj.qrcodecorrection = item.barcode.qrcodecorrection;
      }
      break;
    case "line":
      tmpObj = new ZTObjects.lineObj(itID, muid, posObj, item.style.line);
      tmpObj.lstretchr = item.style.stretchToRight;
      break;
  }
  tmpObj.yRel = item.position.yRelative;
  tmpObj.zone = zone + "content";
  return tmpObj;
}

function drawMissingIcon(item) {
  if (Empty(Ctrl(item.id + "_missing"))) {
    var elem = document.createElement("span");
    elem.id = item.id + "_missing";
    elem.className = "missingItem";
    elem.style.width = item.w + "px";
    elem.style.height = item.h + "px";
    elem.style.backgroundSize = (item.h / 4) + "px " + item.h + "px";
    if (item.fcenter != "normal")
      elem.style.backgroundPosition = "center";
    else if (item.fright != "normal")
      elem.style.backgroundPosition = "right";
    else
      elem.style.backgroundPosition = "left";
    if (Ctrl(item.id))
      Ctrl(item.id).appendChild(elem);
  }
}

function makeJsonItemAllFields(itm, itm_obj) {
  var tmp_obj = makeJsonItem(itm_obj[itm.type]);
  tmp_obj.isAllFields = true;
  tmp_obj.ref_alias = itm_obj.field.fieldDet.alias;
  tmp_obj.position.x = itm.x;
  tmp_obj.position.y = itm.y;
  tmp_obj.position.yRelative = itm.yRel;
  tmp_obj.position.width = itm.w;
  tmp_obj.position.height = itm.h;
  tmp_obj.uidfor = itm.uidfor;
  return tmp_obj;
}

function updateJsonItemAllFields(item, itemObj, fldObj) {
  // posizioni + misure
  item.position.x = itemObj.x;
  item.position.y = itemObj.y;
  item.position.yRelative = itemObj.yRel;
  item.position.width = itemObj.w;
  item.position.height = itemObj.h;
  // props in editfields
  if (item.type == "field") {
    if (item.typeView == "date")
      item.picture.dateformat = fldObj.dateformat;
    else if (item.typeView == "datetime") {
      item.picture.dateformat = fldObj.dateformat;
      item.picture.timeformat = fldObj.timeformat;
    }
    else if (item.typeView == "signmup") {
      item.signmup.dateformat = fldObj.smdateformat;
      item.signmup.timeformat = fldObj.smtimeformat;
      item.signmup.sequence = fldObj.sequence;
      item.signmup.brequired = fldObj.brequired;
      item.signmup.bgeoposition = fldObj.bgeoposition;
      item.signmup.bhideextra = fldObj.bhideextra;
      item.signmup.title = fldObj.title;
    }
    else if (item.typeView == "numeric" && itemObj.zone.indexOf("footer") >= 0) {
      item.calculation.type = fldObj.calculate;
      item.calculation.byGroup = fldObj.calcbygrp;
    }
  }
  else
    item.value = fldObj.value;

  if (item.typeView != "image" && item.type != "line") {
    item.style.font.bold = (fldObj.fbold == "normal") ? false : true;
    item.style.font.italic = (fldObj.fitalic == "normal") ? false : true;
    item.style.font.underline = (fldObj.funderline == "normal") ? false : true;
    item.style.font.strikeout = (fldObj.fstrikeout == "normal") ? false : true;
    item.style.font.left = (fldObj.fleft == "normal") ? false : true;
    item.style.font.center = (fldObj.fcenter == "normal") ? false : true;
    item.style.font.right = (fldObj.fright == "normal") ? false : true;
    item.style.font.fontName = fldObj.ffamily;
    item.style.font.fontSize = fldObj.fsize;
    item.style.font.fontColor = fldObj.fcolor;
  }
}

function makeJsonItem(item) {
  var tmpObj = blankJsonItem();
  tmpObj.uid = item.uid;
  tmpObj.type = item.type;
  tmpObj.typeView = item.typeView;

  if (item.type == "field") {
    tmpObj.fieldDetail = {};
    tmpObj.fieldDetail.alias = item.fieldDet.alias;
    tmpObj.fieldDetail.type = item.fieldDet.type;
    tmpObj.fieldDetail.len = item.fieldDet.len;
    if (item.fieldDet.type == "N")
      tmpObj.fieldDetail.dec = item.fieldDet.dec;
    tmpObj.fieldDetail.desc = item.fieldDet.desc;

    tmpObj.fieldLabel = item.fieldLabel;
    tmpObj.fieldTotal = item.fieldTotal;

    tmpObj.barcode = {};
    tmpObj.barcode.type = item.barcodetype;
    tmpObj.barcode.pixeloffcolor = item.fcoloroff;
    tmpObj.barcode.pixeloncolor = item.fcoloron;
    //tmpObj.barcode.qrcodecorrection = item.qrcodecorrection;
  }
  else
    tmpObj.value = item.value;

  if (item.typeView == "date") {
    tmpObj.picture = {};
    tmpObj.picture.dateformat = item.dateformat;
  }
  else if (item.typeView == "datetime") {
    tmpObj.picture = {};
    tmpObj.picture.dateformat = item.dateformat;
    tmpObj.picture.timeformat = item.timeformat;
  }
  else if (item.typeView == "signmup") {
    tmpObj.signmup = {};
    tmpObj.signmup.dateformat = item.smdateformat;
    tmpObj.signmup.timeformat = item.smtimeformat;
    tmpObj.signmup.sequence = item.sequence;
    tmpObj.signmup.brequired = item.brequired;
    tmpObj.signmup.bgeoposition = item.bgeoposition;
    tmpObj.signmup.bhideextra = item.bhideextra;
    tmpObj.signmup.title = item.title;
  }

  tmpObj.isGeneric = item.isGeneric;
  tmpObj.isContinue = item.isContinue;

  tmpObj.position = {};
  tmpObj.position.x = item.x;
  tmpObj.position.y = item.y;
  tmpObj.position.yRelative = item.yRel;
  tmpObj.position.width = item.w;
  tmpObj.position.height = item.h;

  tmpObj.style = {};
  if (item.typeView != "image" && item.type != "line") {
    tmpObj.style.font = {};
    tmpObj.style.font.bold = (item.fbold == "normal") ? false : true;
    tmpObj.style.font.italic = (item.fitalic == "normal") ? false : true;
    tmpObj.style.font.underline = (item.funderline == "normal") ? false : true;
    tmpObj.style.font.strikeout = (item.fstrikeout == "normal") ? false : true;
    tmpObj.style.font.left = (item.fleft == "normal") ? false : true;
    tmpObj.style.font.center = (item.fcenter == "normal") ? false : true;
    tmpObj.style.font.right = (item.fright == "normal") ? false : true;
    tmpObj.style.font.fontName = item.ffamily;
    tmpObj.style.font.fontSize = item.fsize;
    tmpObj.style.font.fontColor = item.fcolor;
    tmpObj.style.stretchToRight = item.fstretchr;
  }
  else if (item.typeView == "image")
    tmpObj.style.imageSrc = item.imgPath;
  else { // line
    tmpObj.style.line = {};
    tmpObj.style.line.height = parseInt(item.h);
    tmpObj.style.line.type = "plain";
    tmpObj.style.line.color = item.lcolor;
    tmpObj.style.stretchToRight = item.lstretchr;
  }

  if (item.typeView == "numeric" && item.zone.indexOf("footer") >= 0) {
    tmpObj.calculation = {};
    tmpObj.calculation.type = item.calculate;
    tmpObj.calculation.byGroup = item.calcbygrp;
  }
  return tmpObj;
}

function blankJsonItem() {
  return {
    uid: "",
    type: "",
    typeView: "",
    fieldDetail: {
      alias: "",
      type: "",
      len: 0,
      dec: 0,
      desc: ""
    },
    fieldLabel: "",
    fieldTotal: "",
    barcode: {
      type: "",
      pixeloffcolor: "",
      pixeloncolor: ""
    },
    value: "",
    picture: {
      dateformat: "",
      timeformat: ""
    },
    signmup: {
      dateformat: "",
      timeformat: "",
      sequence: "",
      brequired: "",
      bgeoposition: "",
      bhideextra: "",
      title: ""
    },
    isGeneric: false,
    isContinue: false,
    position: {
      x: 0,
      y: 0,
      yRelative: 0,
      width: 0,
      height: 0
    },
    style: {
      font: {
        bold: false,
        italic: false,
        underline: false,
        strikeout: false,
        left: false,
        center: false,
        right: false,
        fontName: "",
        fontSize: "",
        fontColor: ""
      },
      stretchToRight: false,
      imageSrc: "",
      line: {
        height: 0,
        type: "",
        color: ""
      }
    },
    calculation: {
      type: "",
      byGroup: ""
    },
    isAllFields: false,
    ref_alias: "",
    uidfor: ""
  }
}

function newReport() {
  selectReportPage(0);
  if (m_bUpdated == true) {
    var msg = getTranslated("SMR_CONFIRMSAVE", 'Do you want to save the last changes on report?');
    AfterSave = function () { resetReport(); }
    showMessageConfirm(msg, "resetReportSave");
  }
  else
    resetReport();
}

function resetReportSave() {
  AfterSave = function () { resetReport(); }
  save();
}

function resetReport() {
  newHistoryStack();
  currentname = "";
  index = null;
  itemsHTML = [];
  fieldHTML = [];
  Ctrl("backcanvas").scrollTop = 0;
  Ctrl("backcanvas").scrollLeft = 0;
  resetZones(true);
  showRulers();
  showGrid();
  var mdsource = m_CurrentObj.datasource;
  blankObj = getFromDesignObj();
  //m_CurrentObj = blankObj;
  if (dataobj)
    blankObj.datasource = mdsource;
  m_CurrentObj = null;
  decodeReportObj(blankObj);
  setTitleName();
  pushToHistory();
  m_CurrentObj = blankObj;
}

function resetZones(forced) {
  resetMapItems();
  removeAllHandlers();
  gBreakFields = [];
  idItemsHTML = [];
  uidItemsHTML = [];
  for (var i = 0; i < reportZones.length - 1; i++) {
    if (Ctrl(reportZones[i] + "items") && (forced == true || !$(reportZones[i]).hasClass("hiddenZone")))
      Ctrl(reportZones[i] + "items").innerHTML = "";
  }
}

/******* gestione generic item ********/
var genItemType = "";
var ctrlid = "";
function drawGenericShadow(e, ctrl, type) {
  if (disableOtherDrag)
    return;
  genItemType = type;
  if (ctrl.id.indexOf("_shadow") >= 0) {
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

  var descWidth = (lenFactor * maxWidth);

  var shadowDD = document.createElement("div");
  idFld = ctrl.id;
  shadowDD.id = ctrl.id + "_shadow";
  shadowDD.className = "unselectable dragdropshadow";

  var abpos = (getAbsolutePos(ctrl));
  shadowDD.style.left = abpos.x + "px";
  shadowDD.style.top = abpos.y + "px";
  shadowDD.style.marginTop = "";
  shadowDD.style.marginLeft = "";
  shadowDD.style.width = descWidth + "px";
  shadowDD.style.height = "24px";

  document.body.appendChild(shadowDD);

  if (Empty(e.targetTouches)) {
    shadowDD.onmousedown = dragGeneric;
    shadowDD.onmouseup = endPutGeneric;
  }
  else {
    ctrlid = ctrl.id;
    dragGeneric(e);
  }
}

function dragGeneric(e) {
  removeAllHandlers();
  var descWidth = lenFactor * maxWidth;

  Ctrl(idFld + "_shadow").style.width = descWidth + "px";
  if (genItemType == "line")
    Ctrl(idFld + "_shadow").style.height = "0px";
  else if (genItemType == "image" || genItemType == "signmup")
    Ctrl(idFld + "_shadow").style.height = "80px";
  else
    Ctrl(idFld + "_shadow").style.height = "24px";

  $(idFld + "_shadow").addClass("dragdropshadowmove");

  e = (e) ? e : window.event;
  xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;

  dx = -10;
  dy = -10;

  if (Empty(e.targetTouches)) {
    document.body.style.cursor = "move";
    document.body.onmousemove = putGeneric;
  }
  else
    Ctrl(ctrlid).addEventListener("touchmove", putGeneric);
}

function convertGenericToString(genericType) {
  if (genericType == 'datetime') {
    var d = new Date();
    var str = FormatDate(d, "YYYY-MM-DD");
    str += " " + FormatDateTime(d, "hh:mm");
    return str;
  }
  else if (genericType == 'pagenum')
    return "page numeration";
  else
    return genericType;
}

function putGeneric(e) {
  disableOtherDrag = true;
  dPos = [];
  $(idFld + "_shadow").removeClass("dragdropshadowout");
  $(idFld + "_shadow").addClass("dragdropshadowmove");

  e = (e) ? e : window.event;
  if (Empty(e.targetTouches)) {
    xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  }
  else {
    xpos = (e.targetTouches[0].pageX) ? e.targetTouches[0].pageX : (e.targetTouches[0].clientX) ? e.targetTouches[0].clientX : 0;
    ypos = (e.targetTouches[0].pageY) ? e.targetTouches[0].pageY : (e.targetTouches[0].clientY) ? e.targetTouches[0].clientY : 0;
  }

  xpos += dx;

  Ctrl(idFld + "_shadow").innerHTML = ToStringHTML("[" + convertGenericToString(genItemType) + "]");

  var diffX = - (Ctrl("backcanvas").offsetLeft + Ctrl("canvas").offsetLeft) + Ctrl("backcanvas").scrollLeft;
  var diffY = - (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop) + Ctrl("backcanvas").scrollTop;

  var xxpos = parseInt(xpos) + diffX;
  highlightZone(e, ypos - (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop), Ctrl(idFld + "_shadow"), xxpos, genItemType, true);

  var mY = (ypos + dy) + diffY;

  myZone = identifyZone(mY);
  myItems = !Empty(myZone) ? getAreaItems(myZone) : [];

  var crossItems = getCrossZoneItems(myZone);
  if (crossItems) myItems = myItems.concat(crossItems).unique();
  // calcolo snap to grid
  var gridPos = [xpos, ypos + dy];
  if (formProp.snapgrid && !Empty(myZone) && xxpos >= 0)
    gridPos = calcSnapToGrid(true, xxpos, mY, Ctrl(myZone).offsetTop);

  Ctrl(idFld + "_shadow").style.left = gridPos[0] + "px";
  Ctrl(idFld + "_shadow").style.top = gridPos[1] + "px";

  // ricalcolo posizioni dello snap
  xxpos = gridPos[0] + diffX;
  mY = gridPos[1] + diffY;

  dPos = [xxpos, mY];

  if (Empty(e.targetTouches))
    document.body.onmouseup = endPutGeneric;
  else
    Ctrl(ctrlid).addEventListener("touchend", endPutGeneric);
}

function calcSnapToGrid(isDrag, xp, yp, dy) {
  var sx = !isDrag ? 0 : (Ctrl("backcanvas").offsetLeft + Ctrl("canvas").offsetLeft) - Ctrl("backcanvas").scrollLeft;
  var sy = !isDrag ? 0 : (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop) - Ctrl("backcanvas").scrollTop;

  var factorX = Math.round(xp / stepUnit);
  var factorY = Math.round((yp - dy) / stepUnit);

  var ret = [];
  ret[0] = (stepUnit * factorX) + sx;
  ret[1] = (stepUnit * factorY) + dy + sy;
  return ret;
}

function endPutGeneric(/*e*/) {
  if (Empty(dPos))
    return;
  $("tooltip_box").addClass("hiddenAdd");
  Ctrl("tooltip_box").textContent = "";
  if (genItemType == "allfields" && Empty(fieldHTML)) {
    PSAlert.alert("Empty fields: insert datasource");
  }
  else {
    xpos = dPos[0];
    ypos = dPos[1];
    if (xpos >= 0) {
      switch (genItemType) {
        case "label":
          drawLabel(null, "Label");
          break;
        case "line":
          drawLine();
          break;
        case "image":
        case "datetime":
        case "pagenum":
        case "signmup":
          drawGenericItem(genItemType);
          break;
        case "allfields":
          drawLabel(true, "All fields labels", true);
          drawGenericItem(genItemType);
          afterPutGenericItem();
          break;
        case "continue":
          drawLabel(null, "CONTINUE", true);
          break;
      }
    }
  }

  updateClassZones();
  document.body.removeChild(Ctrl(idFld + "_shadow"));
  document.body.style.cursor = "auto";
  document.body.onmousedown = null;
  document.body.onmousemove = null;
  document.body.onmouseup = null;

  idFld = "";
  genItemType = "";
  ctrlid = "";
  dPos = null;
  disableOtherDrag = false;
}

function drawLine() {
  var zone = identifyZone(ypos);
  if (validatePosition(zone) && zone != "groupbreak") {
    var pos = {};
    pos.x = xpos;
    pos.y = ypos;
    pos.w = 200;
    pos.h = 1;

    itemsHTML[countindex] = new ZTObjects.lineObj(nitem, null, pos);
    itemsHTML[countindex].zone = zone;

    pushToMaps(zone);

    countindex++;
    nitem++;

    Ctrl(zone + "items").innerHTML += itemsHTML[countindex - 1].html;

    itemsHTML[countindex - 1].uidfor = itemsHTML[countindex - 1].uid;
    $(itemsHTML[countindex - 1].id).addClass(itemsHTML[countindex - 1].uidfor);

    itemsHTML[countindex - 1].x = Ctrl(itemsHTML[countindex - 1].id).offsetLeft;
    itemsHTML[countindex - 1].y = Ctrl(itemsHTML[countindex - 1].id).offsetTop;
    itemsHTML[countindex - 1].yRel = itemsHTML[countindex - 1].y - Ctrl(itemsHTML[countindex - 1].zone).offsetTop;

    AdjustMove(itemsHTML[countindex - 1], true);
    pushToHistory();
  }
  else {
    PSAlert.alert("Not allowed");
  }

  index = null;

  document.body.style.cursor = "default";
  Ctrl("canvas").onmousemove = null;
  Ctrl("canvas").onmousedown = beginDragSelection;
  SetUpdated();
}

function drawGenericItem(type) {
  var zone = identifyZone(ypos);
  var ok = true;
  if (validatePosition(zone) && zone != "groupbreak") {
    var labelw = (type == "allfields") ? 179 : 0,
      field = {};
    field.alias = "";
    field.desc = Ctrl("generic_" + type).textContent;
    if (type == "pagenum") {
      field.desc = "Page number";
      field.type = 'N';
      field.len = 6;
    }
    else if (type == "datetime") {
      field.desc = "Current datetime";
      field.type = 'T';
      field.len = 14;
      field.dec = 0;
    }

    field.tView = type;

    var pos = {};
    pos.x = xpos + labelw;
    pos.y = ypos;
    pos.w = Ctrl("generic_" + type + "_shadow").offsetWidth;
    pos.h = Ctrl("generic_" + type + "_shadow").offsetHeight;

    itemsHTML[countindex] = new ZTObjects.fldObj(nitem, null, pos, field, true);
    itemsHTML[countindex].zone = zone;
    itemsHTML[countindex].isAllFields = (type == "allfields");

    if (type == "datetime")
      itemsHTML[countindex].isCurrent = true;

    pushToMaps(zone);

    countindex++;
    nitem++;

    Ctrl(zone + "items").innerHTML += itemsHTML[countindex - 1].html;
    updTextToImage(itemsHTML[countindex - 1]);

    itemsHTML[countindex - 1].uidfor = itemsHTML[countindex - 1].uid;
    $(itemsHTML[countindex - 1].id).addClass(itemsHTML[countindex - 1].uidfor);

    itemsHTML[countindex - 1].x = Ctrl(itemsHTML[countindex - 1].id).offsetLeft;
    itemsHTML[countindex - 1].y = Ctrl(itemsHTML[countindex - 1].id).offsetTop;
    itemsHTML[countindex - 1].yRel = itemsHTML[countindex - 1].y - Ctrl(itemsHTML[countindex - 1].zone).offsetTop;

    AdjustMove(itemsHTML[countindex - 1], true);
    pushToHistory();
  }
  else
    ok = false;

  if (ok) {
    index = countindex - 1;
    updateClassZones();
  }
  index = null;

  document.body.style.cursor = "default";
  Ctrl("canvas").onmousemove = null;
  Ctrl("canvas").onmousedown = beginDragSelection;
  SetUpdated();
}

function drawERWizardHSave() {
  AfterSave = function () { drawERWizard(); }
  save();
}

function ExecAfterCancel() {
  if (!Empty(AfterSave))
    AfterSave();
  AfterSave = null;
}

function drawERWizardH() {
  if (m_bUpdated == true) {
    AfterSave = function () { drawERWizard(); }
    var msg = getTranslated("SMR_CONFIRMSAVE", 'Do you want to save the last changes on report?');
    showMessageConfirm(msg, "drawERWizardHSave");
  }
  else
    drawERWizard();
}

function drawERWizard(ds/*, flds*/) {
  selectReportPage(0);
  Ctrl('loadingopac').style.display = 'block';
  ds = Empty(ds) ? formProp.datasource : ds;
  var url = "../jsp-system/SPSmartReportWizard_portlet.jsp?";
  url += "ds=" + ds;
  if (fields)
    url += "&fields=" + URLenc(JSON.stringify(fields));
  layerOpenForeground(url, "wizardSPModalLayer", "", "", "", "", 1); // messo x mobile
}

function closeERWizard(ds/*, tok*/) {
  if (!Empty(formProp.datasource) && Empty(ds))
    ds = formProp.datasource;
  setDatasourceValue(ds);
  if (m_CurrentObj == null)
    m_CurrentObj = getFromDesignObj();
  pushToHistory();
  Ctrl('loadingopac').style.display = 'none';
  Ctrl('loading').style.display = 'none';
}

function drawEditorReportFromModel(obj, pageswitch) {
  resetZones();
  decodeReportObj(obj);
  m_CurrentObj = null;
  if (pageswitch != undefined)
    setTimeout(function () {
      selectReportPage(pageswitch);
    }, 750);
}

var checks = [];
function applyModel(mod, isparam) {
  var flds = [];
  var i, tid;

  if (!isparam) {
    var cbox = document.getElementsByClassName("fieldcheck");
    for (i = 0; i < cbox.length; i++) {
      if (cbox[i].checked || checks.indexOf(cbox[i].id) >= 0) {
        tid = "";
        tid = parseInt(cbox[i].id.substring(0, cbox[i].id.indexOf("_")));
        flds.push(tid)
      }
    }
  }
  else {
    for (i = 0; i < fieldHTML.length; i++)
      flds.push(i);
  }
  newHistoryStack();
  currentname = "";
  index = null;
  itemsHTML = [];
  Ctrl("backcanvas").scrollTop = 0;
  Ctrl("backcanvas").scrollLeft = 0;
  resetZones();

  var page = {};
  page.format = formProp.pformat;
  page.orientation = formProp.porientation;
  page.width = formProp.pwidth;
  page.height = formProp.pheight;

  var margins = {};
  margins.top = formProp.mtheight;
  margins.bottom = formProp.mbheight;
  margins.left = formProp.mlwidth;
  margins.right = formProp.mrwidth;
  margins.unit = "mm";

  var hflds = [];
  var fflds = [];
  if (formProp.datasource.indexOf("BO:") == 0) {
    for (i = 0; i < fieldHTML.length && i < getFieldHTMLIndex("itmFld_CPROWNUM"); i++) {
      if (fieldHTML[i].type == "N")
        fflds.push(i);
      else
        hflds.push(i);
    }
  }

  var opts_obj = {};
  opts_obj.datasource = formProp.datasource;
  opts_obj.title = currentname;
  opts_obj.reportmodel = mod;
  opts_obj.allFields = fieldHTML;
  opts_obj.reportflds = flds;
  opts_obj.breakflds = [];
  opts_obj.page = page;
  opts_obj.margins = margins;
  opts_obj.pageswitch = null;
  opts_obj.offline = isoffline;
  opts_obj.fromprint = null;
  opts_obj.printprops = null;
  opts_obj.totalsA = JSON.stringify([]);
  if (mod == 'table') {
    opts_obj.headerflds = hflds;
    opts_obj.footerflds = fflds;
    opts_obj.filterfooter = null;
  }
  else {
    opts_obj.headerflds = flds;
    opts_obj.footerflds = flds;
    opts_obj.filterfooter = true;
  }
  generateReport(opts_obj);

  // provvisorio
  for (i = 0; i < checks.length; i++) {
    if (!document.getElementById(checks[i]).checked) {
      document.getElementById(checks[i]).click();//checked = true;
    }
  }
}

function pushToHistory() {
  if (m_CurrentObj != null) {
    historyStack.push(m_CurrentObj);
  }
  updateUndoRedoCtrl();
}

function undoFromHistory() {
  var obj = historyStack.undo();
  updateUndoRedoCtrl();
  if (obj != null) {
    setLoading();
    m_CurrentObj = obj;
    decodeFormProperties(m_CurrentObj);
    drawEditor();
  }
}

function redoFromHistory() {
  var obj = historyStack.redo();
  updateUndoRedoCtrl();
  if (obj != null) {
    m_CurrentObj = obj;
    setLoading();
    decodeFormProperties(m_CurrentObj);
    drawEditor();
  }
}

function updateUndoRedoCtrl() {
  if (Ctrl('undo_cont')) {
    if (historyStack.hasUndo())
      $('undo_cont').removeClass('disabledpic');
    else
      $('undo_cont').addClass('disabledpic');
  }
  if (Ctrl('redo_cont')) {
    if (historyStack.hasRedo())
      $('redo_cont').removeClass('disabledpic');
    else
      $('redo_cont').addClass('disabledpic');
  }
  if (historyStack.hasUndo() || historyStack.hasRedo())
    SetUpdated();
  else
    m_bUpdated = false;
}

function newHistoryStack() {
  if (historyStack == null) {
    historyStack = new History(tool);
  } else {
    historyStack.clear();
  }
  updateUndoRedoCtrl();
}

function showMessageConfirm(msg, fname, objparam) {
  Ctrl('loadingopac').style.display = 'block';
  var width = 400;
  var height = 160;
  var url = "confirmForm.jsp?";
  url += "msg=" + URLenc(msg);
  url += "&callerFunction=" + fname;
  if (objparam)
    url += "&objparam=" + URLenc(JSON.encode(objparam));
  var additionalUrl = "width=" + width;
  additionalUrl += ",height=" + height;
  //  openNewWindow(url, additionalUrl, height, width, -1, -1, "");
  //  SOSTITUZIONE CON METODO openSPModalLayer PERCHE' openNewWindow NON ESISTE PRIMA DELLA PREV.61
  //  openSPModalLayer(url+additionalUrl,top,left,width,height,false,1,false);
  layerOpenForeground(url, "confirmSPModalLayer", additionalUrl, "", "", "", 1);  // messo x mobile
}

function closeConfirmForm() {
  Ctrl('loadingopac').style.display = 'none';
  Ctrl('loading').style.display = 'none';
}

function showNotimooMissingAlert(htmlmsg) {
  if (Empty(notimooAlert)) {
    var mess = "<span style=\"font-size:15px; color:yellow\">" + 'Warning' + "</span>";
    notimooAlert = new Notimoo();
    var width = 600;
    var height = 120;
    var left = (screen.width) ? (screen.width - width) / 2 : 100;
    var top = (screen.height) ? (screen.height - height - (height / 4)) / 2 : 100;
    notimooAlert.initialize({ width: 450, height: height / 2, locationVType: 'top', locationHType: 'left', locationVBase: top, locationHBase: left });
    notimooAlert.show({
      title: mess,
      message: htmlmsg,
      //sticky : true
      visibleTime: 10000
    });
  }
}

function updateFieldDescriptions(obj) {
  var zone = "";
  var itobj;
  var newDesc = "";
  var lbobj;
  for (var i = 0; i < reportZones.length; i++) {
    zone = Strtran(reportZones[i], "content", "");
    if (obj[zone]) {
      for (var j = 0; j < obj[zone].items.length; j++) {
        itobj = obj[zone].items[j];
        if (itobj.type == "field" && !Empty(itobj.fieldDetail.alias) && getFieldHTMLIndex("itmFld_" + itobj.fieldDetail.alias) >= 0) {
          newDesc = getFieldDescription(itobj.fieldDetail.alias);
          if (newDesc == itobj.fieldDetail.desc)
            continue;
          else {
            if (!Empty(itobj.fieldLabel)) {
              lbobj = getItemFieldUid(itobj.fieldLabel, "label", obj);
              if (lbobj && lbobj.value == itobj.fieldDetail.desc)
                lbobj.value = newDesc;
            }
            itobj.fieldDetail.desc = newDesc;
          }
        }
      }
    }
  }
}

var loremipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
function JSRepDrawDocumentView(obj, format, params, container, name, mctrlobj, forcesimulatedata, mdatasource, noPrev) {
  if (Empty(forcesimulatedata)) forcesimulatedata = false;
  if (Empty(mdatasource)) forcesimulatedata = true;
  var alfakey = LibJavascript.AlfaKeyGen(5);
  window[alfakey] = {};
  var mrun = window[alfakey];
  mrun.SdataProvider = null;
  mrun.formid = alfakey;
  if (Empty(params)) params = "";
  var mdataProvider,
    isSimulatedData = false,
    isExec = false,
    parm_obj = {};
  if (forcesimulatedata) {
    //simulazione dati
    parm_obj = JSON.parse(getParmsObject("static"));
    mdataProvider = new ZtVWeb.StaticDataProvider(mrun, parm_obj);
    mdataProvider.SetFields(getAllFieldsArray("alias"), getAllFieldsArray("type"));
    mdataProvider.FillData(setSimulatedData());
    isSimulatedData = true;
  }
  else {
    if (obj.offline) { // vqr
      //simulazione dati
      parm_obj = JSON.parse(getParmsObject("static"));
      mdataProvider = new ZtVWeb.StaticDataProvider(mrun, parm_obj);
      mdataProvider.SetFields(getAllFieldsArray("alias"), getAllFieldsArray("type"));
      mdataProvider.FillData(setSimulatedData());
    }
    else if (dataobj) {
      mdataProvider = dataobj;
      isExec = true;
    }
    else {
      var isBO = mdatasource.indexOf("BO:") >= 0;
      parm_obj = JSON.parse(getParmsObject("sql", mdatasource));
      if (!isBO) // vqr
        parm_obj.parms = params;
      mdataProvider = new ZtVWeb.SQLDataProvider(mrun, parm_obj);
      if (isBO)
        mdataProvider.queryfilter = params;
    }
  }

  function getParmsObject(type, cmd) {
    // type: static sql
    var obj = {};
    obj.__itype = type;
    obj.name = "SdataProvider";
    obj.auto_exec = true;
    if (type == "static") {
      obj.async = false;
      obj.dataproviders = "";
      obj.fieldsString = "";
      obj.fieldstypeString = "";
      obj.parms = "";
      obj.parms_source = "";
      obj.query = "";
      obj.type = "StaticDataProvider";
    }
    else if (type == "sql") {
      obj.cmd = cmd;
      obj.newcmd = "";
      obj.parms = "";
      obj.nrows = 10;
      obj.parms_source = "";
      obj.fieldstype = true;
      obj.count = false;
      obj.async = true;
      obj.appendingData = false;
      obj.type = "SQLDataobj";
    }
    return JSON.stringify(obj);
  }

  if (mdataProvider.__itype == "sql") {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "../smartreport/smartreporthash.jsp", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("table=" + mdatasource);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        var resp = this.responseText;
        mdataProvider.cmdHash = resp.replace(/[\n\r]+/g, '');
        execJSRepDocument();
      }
    }
  }
  else
    execJSRepDocument();

  function execJSRepDocument() {
    delete mdataProvider.__itype;
    mdataProvider.form.SdataProvider = mdataProvider;
    var oldInstance = container.id + "_jsrep",
      mindex = mdataProvider.rowsconsumers.map(function (a) { return a.uid; }).indexOf(oldInstance);
    if (mindex >= 0)
      mdataProvider.rowsconsumers.splice(mindex, 1);
    // tratto obj per ev.allfields
    if (!Empty(_allFieldsHTML))
      normalizeObj(obj, fields)
    if (!forcesimulatedata && !isExec)
      JSRepDrawDocumentViewProvider(obj, format, mdataProvider, container, name, mctrlobj, isSimulatedData, drawDocumentCallBack, !noPrev, false);
    else if (!forcesimulatedata && isExec) {
      var fnc = null;
      if (!Empty(callbackFnc)) {
        if (portletID)
          fnc = getOpener()[portletID][callbackFnc];
        else if (getOpener()[callbackFnc])
          fnc = getOpener()[callbackFnc]
        else  // e' il nome della funzione
          fnc = window[callbackFnc];
      }
      else if (noPrev)
        fnc = printInPreview;
      else
        fnc = drawDocumentCallBack;
      JSRepDrawDocumentViewProvider(obj, format, mdataProvider, container, name, mctrlobj, isSimulatedData, fnc, !noPrev, false);
    }
    else
      JSRepDrawDocumentViewProvider(obj, format, mdataProvider, container, name, mctrlobj, isSimulatedData, null, !noPrev, false);
  }

  function normalizeObj(repobj) {
    var zones = ['reportheader', 'pageheader', 'groupheader', 'groupbody', 'groupfooter', 'pagefooter', 'reportfooter'],
      progrX = -1,
      offset = 20;
    for (var i = 0; i < zones.length; i++) {
      var items = repobj[zones[i]].items;
      progrX = -1;
      for (var j = 0; j < items.length; j++) {
        if (items[j].isAllFields) {
          var f_idx = fieldHTMLMap[items[j].ref_alias];
          if (progrX == -1 || f_idx == 0) // primo campo
            progrX = items[j].position.x;
          items[j].position.x = progrX;
          progrX = progrX + offset + items[j].position.width;
        }
      }
    }
  }
}

function getAllFieldsArray(prop) {
  var ret = [];
  for (var i = 0; i < fieldHTML.length; i++)
    ret.push(fieldHTML[i][prop]);
  return ret;
}

function setSimulatedData() {
  var mtypes = getAllFieldsArray("type");
  var mlen = getAllFieldsArray("len");
  var mdec = getAllFieldsArray("dec");
  var nrec = 10;
  var mdata = [];
  for (var i = 0; i < nrec; i++) {
    mdata[i] = [];
    for (var j = 0; j < mtypes.length; j++) {
      switch (mtypes[j]) {
        case "C":
        case "M":
          var mslen = loremipsum.length - 1 - mlen[j];
          mdata[i].push(LRTrim(loremipsum.substr(Math.floor(Math.random() * mslen), mlen[j])));
          break;
        case "N":
          mdata[i].push(parseFloat(((Math.random() * 100) + 1).toFixed(mdec[j]), 10));
          break;
        case "D":
        case "T":
          var d = new Date();
          d.setDate(Math.floor(Math.random() * 31) + 1);
          mdata[i].push(d);
          break;
        case "L":
          mdata[i].push(false);
          break;
      }
    }
  }
  return mdata;
}

function drawDocumentCallBack(obj, format, SdataProvider, container, dwnlName, actionObj/*, isAsync, simulatedData, fncCallBack, repReference*/) {
  if (SdataProvider.GetQueryCount() == 0) {
    notimooAlert = null;
    var htmlmsg = "<div>";
    htmlmsg += "<span style=\"float:left; margin-top:5px; font-size:13px; width: 100%;\">There is no data available.</span>";
    htmlmsg += "<span style=\"float:left; margin-top:8px; font-size:13px; width: 100%;\">Document is show with simulated data.</span>";
    htmlmsg += "</div>";
    showNotimooMissingAlert(htmlmsg);
    JSRepDrawDocumentView(obj, format, SdataProvider, container, dwnlName, actionObj, true);
  }
}

window.onunload = function () {
  if (!Empty(updateFnc)) {
    if (portletID && getOpener()[portletID] && getOpener()[portletID][updateFnc]) {
      getOpener()[portletID][updateFnc](currentname, custom);
    }
    else if (getOpener()[updateFnc])
      getOpener()[updateFnc](currentname, custom);
    else if (window[updateFnc])
      window[updateFnc](currentname, custom);
  }
}

function drawSeparatorElement(pid, progressive, addclass) {
  var elem = document.createElement("div");
  elem.id = "separator_" + pid + "_" + progressive;
  elem.className = "toolbarpipe";
  if (addclass)
    elem.className += (" " + addclass);
  Ctrl(pid).appendChild(elem);
}

function pushToMaps(zone) {
  if (!zone) return;
  if (zone.indexOf('content') < 0) zone = zone + 'content';
  if (mapItems[zone] && mapItems[zone].indexOf(countindex) < 0) mapItems[zone].push(countindex);
  if (idItemsHTML.indexOf(itemsHTML[countindex].id) < 0) idItemsHTML.push(itemsHTML[countindex].id);
  if (uidItemsHTML.indexOf(itemsHTML[countindex].uid) < 0) uidItemsHTML.push(itemsHTML[countindex].uid);
}

var _allFieldsHTML = [];
function afterPutGenericItem() {
  // allfields
  var zoneField = itemsHTML[itemsHTML.length - 1].zone,
    zoneLabel = itemsHTML[itemsHTML.length - 2].zone;
  for (var i = 0; i < fieldHTML.length; i++) {
    var field = fieldHTML[i],
      item = {};
    item.index = i;
    // label
    item.label = new ZTObjects.af_labelObj(field.desc);
    item.label.zone = zoneLabel;
    item.label.uidfor = itemsHTML[itemsHTML.length - 2].uidfor;
    item.label.iHTML = itemsHTML.length - 2;
    // field
    item.field = new ZTObjects.af_fldObj(field);
    item.field.zone = zoneField;
    item.field.uidfor = itemsHTML[itemsHTML.length - 1].uidfor;
    item.field.iHTML = itemsHTML.length - 1;

    _allFieldsHTML.push(item);

    setMapFieldCount(field.alias);
    setUsedField(field.alias);

    UpdateDesignObj(itemsHTML[itemsHTML.length - 2], "addallflds", item);
    UpdateDesignObj(itemsHTML[itemsHTML.length - 1], "addallflds", item);
  }
  //toUpdateObj = true;
}
