/* exported navElemQueries navElemVariables navElemReportVariables navElemBands
    navElemBo NavForm navCom
    refreshQuery setVisibility EndPutShadowField putField
    getVariablesDesc putVar putSystemVar getBands clickTreeBand switchBands
*/

var navValue = "";
var navDim = "";
var navDec = "";
var navIDX = "";
var navType = "";
var navCom = "";
var lastBandSelected;
var navElemQueries = true;
var navElemVariables = false;
var navElemReportVariables = false;
var navElemBands = true;
var navElemBo = true;
var ident = 0;
var cacheItemDataObjQuery = [];

/* *** Gestione del disegno del Navigator *** */
function NavForm() {
  ident = 20;
  // Queries
  navQueries();
  // BO
  navBO();
  // User Variables
  navUserVariables();
  // Report Variables
  navReportVariables();
  // Bands
  navBands();
  selectBand(lastBandSelected);

  resizeGadgetsPane();
  m_bUpdated = true;
}

/* Disegna la zona Queries del Navigator */
function navQueries() {
  fieldHTML["vqr"] = [];
  var tabID = "queries_tab_content";
  Ctrl(tabID).innerHTML = "";
  // Campi e parametri della query principale
  designQuery(reportProp.query,tabID,true);

  // Campi e parametri delle query secondarie (Alternative Queries e Chart)
  for (var nav_i = 0; nav_i < queryList.length; nav_i++) {
    if (!Empty(queryList[nav_i]) && queryList[nav_i] != LRTrim(reportProp.query)) {
      designQuery(queryList[nav_i], tabID);
    }
  }
}

/* Disegna la zona Business Objects del Navigator */
function navBO() {
  fieldHTML["bo"] = [];
  var tabID = "business_objects_tab_content";
  Ctrl(tabID).innerHTML = "";
  for (var nav_i = 0; nav_i < boList.length; nav_i++) {
    if (!Empty(boList[nav_i])) {
      designBo(boList[nav_i],tabID);
    }
  }
}

/* Disegna la zona User Variables del Navigator */
function navUserVariables() {
  var tabID = "variables_tab_content";
  Ctrl(tabID).innerHTML = '<div id="variables_nav" class="nav_variables" style=""><div id="addVariable" class="imgAddVariable" title="Add variable"  onclick="javascript:addVariable();"></div><ul id="variableList"></ul></div>'
  nVar = 0;
  if (Ctrl("variableList")) {
    Ctrl("variableList").innerHTML = "";
  }
  for (var nav_i = 0; nav_i < reportVariables.length; nav_i++) {
    addVariable(reportVariables[nav_i]);
  }
}

/* Disegna la zona System Variables del Navigator */
function navReportVariables() {
}

/* Disegna la zona Bands del Navigator */
var field_tree;
function createTree(root_name,children) {
  var json = [{
    "property": {
        "name": root_name,
        "deleteDenied": true
    },
    "children": children,
    "type": "fieldList",
    "data": {
      "level": 1,
      "itemType": "fieldList"
    }
  }];
  return json;
}
function initTree() {
  Mif.Tree.UID = 1;
  field_tree = new Mif.Tree({
    container: document.id('bands_nav'),// tree container
      initialize: function() {
      new Mif.Tree.Drag(this, {
        onDrag: function() {
          if (this.current && this.current.type[0].indexOf('header') >= 0) {
            if (this.target && this.target.type[0].indexOf('header') < 0) {
              this.where = 'notAllowed';
            }
          }
          if (this.current && this.current.type[0].indexOf('footer') >= 0) {
            if (this.target && this.target.type[0].indexOf('footer') < 0) {
              this.where = 'notAllowed';
            }
          }
        },
        onStart: function() {
        },
        onComplete: function() {
        },
        onDrop: function(current, target/*, where*/) {
          if (current && target) {
            var tmp = current.dropDenied;
            current.dropDenied = target.dropDenied;
            target.dropDenied = tmp;
            moveBand(current.data.ctrlid)
          }
        }
      });
    },
    types: {// node types
      field: {
        openIcon: 'isFilter',//css class open icon
        closeIcon: 'isFilter'// css class close icon
      },
      pageheader : {
        openIcon: 'pageheader',//css class open icon
        closeIcon: 'pageheader'// css class close icon
      },
      pagefooter : {
        openIcon: 'pagefooter',//css class open icon
        closeIcon: 'pagefooter'// css class close icon
      },
      reportheader : {
        openIcon: 'reportheader',//css class open icon
        closeIcon: 'reportheader'// css class close icon
      },
      reportfooter : {
        openIcon: 'reportfooter',//css class open icon
        closeIcon: 'reportfooter'// css class close icon
      },
      group : {
        openIcon: 'group',//css class open icon
        closeIcon: 'group'// css class close icon
      },
      altquery : {
        openIcon: 'altquery',//css class open icon
        closeIcon: 'altquery'// css class close icon
      },
      section : {
        openIcon: 'section',//css class open icon
        closeIcon: 'section'// css class close icon
      },
      sectbo : {
        openIcon: 'sectbo',//css class open icon
        closeIcon: 'sectbo'// css class close icon
      },
      breakpage : {
        openIcon: 'breakpage',//css class open icon
        closeIcon: 'breakpage'// css class close icon
      },
      htmlsection : {
        openIcon: 'htmlsection',//css class open icon
        closeIcon: 'htmlsection'// css class close icon
      },
      autocover : {
        openIcon: 'autocover',//css class open icon
        closeIcon: 'autocover'// css class close icon
      },
      fieldList:{
        openIcon: 'root',//css class open icon
        closeIcon: 'root'// css class close icon
      }
    },
    dfltType: 'field',//default node type
    height: 24, //node height
    onSelect: function(node) {
      if (node.data && node.data.ctrlid && Ctrl(node.data.ctrlid)) {
        clickBand2(node.data.ctrlid);
      }
    },
    propertiesEditable :false,
    deletable : false,
    onBeforeDelete : function(/*node*/) {
    },
    onDelete: function(/*node*/) {
    },
    onToggle: function() {
      resizeGadgetsPane();
    }
  });
}

function addNodeTree(current, ptype, pname, pindex, pid) {
  var position = "inside";
  var newNode = new Mif.Tree.Node({
        parentNode: null,
        tree: field_tree
      }, {
      property: {
        name: pname,
        id : pid
      },
      type: ptype ,
      data : {index:pindex, ctrlid:pid}
  });
  if (ptype != 'pageheader' && ptype != 'pagefooter' && ptype != 'reportheader' && ptype != 'reportfooter') {
    newNode.dragDisabled = true;
    newNode.dropDenied = ['before', 'inside', 'after'];
  }
  else {
    if (ptype.indexOf('header') >= 0) {
      if (ptype == 'pageheader') { phtree = newNode; }
      else { rhtree = newNode; }
    }
    else {
      if (ptype == 'pagefooter') { pftree = newNode; }
      else { rftree = newNode; }
    }
  }
  field_tree.add(newNode, current, position);
}

var rhtree, rftree, phtree, pftree;
function navBands() {
  Ctrl('bands_nav').innerHTML = "";
  initTree();
  field_tree.load({
    json: createTree("",[])
  });
  if (reorganizeBandList) {
    reorganizeBandList = false;
  }
  var current_node = field_tree.root;
  field_tree.root.dragDisabled = true;
  field_tree.root.dropDenied = ['before', 'inside', 'after'];

  rhtree = null;
  rftree = null;
  phtree = null;
  pftree = null;

  for (var nav_i = 0; nav_i < bandList.length; nav_i++) {
    if (bandList[nav_i] != undefined) {
      if (bandList[nav_i].type == "HeaderBar_top") {
        addNodeTree(field_tree.root, 'pageheader', Strtran(getDescBand(bandList[nav_i], 25), " ", "&nbsp;"), 0, bandList[nav_i].id);
      }
      else if (bandList[nav_i].type == "ReportBar_top") {
        addNodeTree(field_tree.root, 'reportheader', Strtran(getDescBand(bandList[nav_i], 25), " ", "&nbsp;"), 0, bandList[nav_i].id);
      }
      else if (bandList[nav_i].type == "HeaderBar_bottom") {
        addNodeTree(field_tree.root, 'pagefooter', Strtran(getDescBand(bandList[nav_i], 25), " ", "&nbsp;"), 0, bandList[nav_i].id);
      }
      else if (bandList[nav_i].type == "ReportBar_bottom") {
        addNodeTree(field_tree.root, 'reportfooter', Strtran(getDescBand(bandList[nav_i], 25), " ", "&nbsp;"), 0, bandList[nav_i].id);
      }
      else if (bandList[nav_i].type.indexOf("_top") > 0) {
        addNodeTree(current_node, Strtran(bandList[nav_i].type,'_top', '').toLowerCase(), Strtran(getDescBand(bandList[nav_i], 25), " ", "&nbsp;"), 0, bandList[nav_i].id);
        current_node = current_node.children[current_node.children.length - 1];
      }
      else if (bandList[nav_i].type.indexOf("_down") > 0) {
        if (current_node.parentNode) {
          current_node = current_node.parentNode;
        }
        else {
          current_node = field_tree.root;
        }
      }
      else {
        addNodeTree(current_node, Strtran(bandList[nav_i].type,'_top','').toLowerCase(), Strtran(getDescBand(bandList[nav_i], 25), " ", "&nbsp;"), 0, bandList[nav_i].id);
      }
    }
  }
  if (phtree && rhtree) {
    if (phtree.UID > rhtree.UID) {
      rhtree.dropDenied = ['inside', 'after'];
      phtree.dropDenied = ['inside', 'before'];
    }
    else {
      phtree.dropDenied = ['inside', 'after'];
      rhtree.dropDenied = ['inside', 'before'];
    }
    //console.log(Mif.Tree.Draw.isUpdatable(phtree))
    phtree.updateProperty('cls', '', 'fldtreemove');
    rhtree.updateProperty('cls', '', 'fldtreemove');
  }
  else if (phtree) {
    phtree.dropDenied = ['inside', 'after', 'before'];
  }
  else if (rhtree) {
    rhtree.dropDenied = ['inside', 'after', 'before'];
  }

  if (pftree && rftree) {
    if (pftree.UID > rftree.UID) {
      rftree.dropDenied = ['inside', 'after'];
      pftree.dropDenied = ['inside', 'before'];
    }
    else {
      pftree.dropDenied = ['inside', 'after'];
      rftree.dropDenied = ['inside', 'before'];
    }
    pftree.updateProperty('cls', '', 'fldtreemove');
    rftree.updateProperty('cls', '', 'fldtreemove');
  }
  else if (pftree) {
    pftree.dropDenied = ['inside', 'after', 'before'];
  }
  else if (rhtree) {
    rftree.dropDenied = ['inside', 'after', 'before'];
  }
}
/* *** Fine gestione del disegno del Navigator *** */

/* *** Gestione dei campi/parametri delle query e del BO nel Navigator *** */

/*
   Disegna il div principale della query, che conterra' tutti i suoi elementi.
   Chiamata da navQueries.
 */
function designQuery(itemDataObjQuery,accID,isPrincipal) {
  designQueryFields(itemDataObjQuery,accID,isPrincipal);
}

function refreshQuery(itemDataObjQuery) {
  removeCachedQuery(itemDataObjQuery);
  if (itemDataObjQuery.indexOf("BO:") == 0) {
    navBO();
  }
  else {
    navQueries();
  }
}

/*
   Disegna il div principale del BO, che conterra' tutti i suoi elementi.
   Chiamata da navBO.
 */
function designBo(itemDataObjQuery,accID) {
  designQueryFields(itemDataObjQuery,accID);
}

/*
   Disegna il div contenente i campi/i parametri del singolo BO o della query.
 */
function designQueryFields(itemDataObjQuery, accID, isPrincipal) {
  // eseguo due volte il metodo per fields e per params
  designQueryComponents(itemDataObjQuery, "queryFields", accID, isPrincipal);
  designQueryComponents(itemDataObjQuery, "queryParameters", accID);
}

/*
   Disegna i campi/i parametri del singolo BO o della query.
 */
function designQueryComponents(itemDataObjQuery, type, accID, isPrincipal) {
  isPrincipal = !isPrincipal ? false : true;
  var elemByGrp = [];
  var dataType = (itemDataObjQuery.indexOf("BO:") >= 0) ? "bo" : "vqr";
  var map = dataType == "vqr" ? mapQueryItems : mapBoItems;
  if (itemDataObjQuery != null && Trim(itemDataObjQuery) != "") {
    var AllField = null;
    if (type == "queryFields") {
      AllField = cachedQuery(itemDataObjQuery);
    }
    else {
      AllField = GetQueryParameters(itemDataObjQuery, true);
    }

    if (itemDataObjQuery.indexOf("BO:") == 0) {
      itemDataObjQuery = itemDataObjQuery.substring(3);
    }

    var param = (type.indexOf("Param") >= 0) ? true : false;
    var mtype = param ? "parameter" : "field";
    var y = 0;
    var drgFldObj, item, bList, aList, actband, desc;
    if (!Ctrl(accID + "_divz")) {
      elemByGrp[itemDataObjQuery] = 0;
    }
    var btnList = ["edit", "reload"];
    for (var nav_i = 0; nav_i < AllField[0].length; nav_i++) {
      y = (elemByGrp[itemDataObjQuery] + 1) * 20;
      desc = Empty(AllField[1][nav_i]) ? AllField[0][nav_i] : AllField[1][nav_i];
      drgFldObj = new ZTObjects.dragFieldObj('field' + fieldcountindex, "Field" + fieldcountindex, mtype, 0, y, 0, 0, AllField[0][nav_i], desc, AllField[2][nav_i], AllField[3][nav_i], AllField[4][nav_i], itemDataObjQuery, itemDataObjQuery, false, param, '', '', true);
      drgFldObj.fieldDetail.idx = elemByGrp[itemDataObjQuery];
      fieldHTML[dataType].push(drgFldObj);
      fieldcountindex++;
      elemByGrp[itemDataObjQuery]++;
      bList = [];
      aList = dataType == "bo" ? [] : ["EditQuery(\'\'," + isPrincipal + ",\'" + itemDataObjQuery + "\')", "refreshQuery(\'" + itemDataObjQuery + "\')"];
      if (!isPrincipal && map[itemDataObjQuery]) {
        item = itemsHTML[map[itemDataObjQuery]];
        type = item.type.toLowerCase().replace(/_top/g, "");
        type = type.replace(/_down/g, "");
        if (dataType == "bo") {
          bList = [type];
        }
        else {
          bList = [type].concat(btnList);
        }
        actband = "";
        if (bandList.indexOf(item)>=0) {
          actband = "clickBand(\'"+item.id+"\')"; //"HightlightSelectedSpaceBar("+map[itemDataObjQuery]+")";
        }
        else {
          actband = "clickItem(event,\'"+item.id+"\')";
        }
        aList = [actband].concat(aList);
      }
      else if (isPrincipal) {
        bList = ["principal"].concat(btnList);
        aList = [""].concat(aList);
      }
      putFieldInAccordion(accID,fieldHTML[dataType][fieldHTML[dataType].length - 1], bList, aList);
    }
  }
}

/*
   Verifica se la query e' presente nella cache delle query/Bo. Se non e' presente, la inserisce in cache.
 */
function cachedQuery(itemDataObjQuery) {
  for (var nav_i = 0; nav_i < cacheItemDataObjQuery.length; nav_i++) {
    if (cacheItemDataObjQuery[nav_i][0] == itemDataObjQuery) {
      return cacheItemDataObjQuery[nav_i][1];
    }
  }

  var AllField = null;
  if (itemDataObjQuery.indexOf("BO:") == 0) {
    AllField = MGetQueryFields(itemDataObjQuery, true, true);
  }
  else {
    AllField = MGetQueryFields(itemDataObjQuery, true, false);
  }

  if (AllField.indexOf("Error" + itemDataObjQuery) < 0 && AllField.indexOf("ERROR" + itemDataObjQuery) < 0) {
    cacheItemDataObjQuery.push(new Array(itemDataObjQuery, AllField));
  }
  return AllField;
}

function removeCachedQuery(itemDataObjQuery) {
  for (var nav_i = 0; nav_i < cacheItemDataObjQuery.length; nav_i++) {
    if (cacheItemDataObjQuery[nav_i][0] == itemDataObjQuery) {
      cacheItemDataObjQuery.splice(nav_i, 1);
      return;
    }
  }
}

/*
   Cambia l'immagine che indica se l'elenco dei campi e' aperto o meno.
 */
function setVisibility(id) {
  var obj = Ctrl(id);
  if (obj) {
    if (obj.style.display == "none") {
      obj.style.display = "block";
      Ctrl("arrow_" + id).src = "images/down.gif";
    }
    else {
      obj.style.display = "none";
      Ctrl("arrow_" + id).src = "images/right.gif";
    }
    resizeGadgetsPane();
  }
}

/*
   Inserisce il campo nell'area di lavoro.
 */
function EndPutShadowField(e, idFld, isVar) {
  if (!isVar) {
    putFieldInReport(e, idFld);
  }
  else {
    putVariableInReport(e, idFld);
  }
}

function putFieldInReport(e,idFld) {
  var fldObj = getFieldHTMLObj(idFld);
  navValue = (fldObj.fieldDetail.isParam) ? fldObj.fieldDetail.alias : (fldObj.groupDetail.name + ".c_" + fldObj.fieldDetail.alias);
  navDim = fldObj.fieldDetail.len;
  navCom = (fldObj.fieldDetail.desc ? fldObj.fieldDetail.desc : "");
  navDec = fldObj.fieldDetail.dec;
  navType = decodeType(fldObj.fieldDetail.type);
  putGenericExpression(e, idFld, true, fldObj.fieldDetail.desc);
}

function putVariableInReport(e,idVar) {
  var vobj;
  for (var i = 0; i < reportVariables.length && !vobj; i++) {
    if (reportVariables[i].id == idVar) {
      vobj = reportVariables[i];
    }
  }

  navValue = "w_" + vobj.name;
  navDim = vobj.len;
  navCom = (vobj.comment ? vobj.comment : "");
  navDec = vobj.dec;
  navType = vobj.type_value.toLowerCase();
  var cc = encodeType(navType);
  if (navDim == 0) {
    if (cc == "N") { navDim = 10; }
    if (cc == "C" || cc == "M") { navDim = 15; }
    if (cc == "D") { navDim = 8; }
    if (cc == "T") { navDim = 14; }
  }
  putGenericExpression(e, idVar);
}

function putGenericExpression(e,id,isField,fcomment) {
  var divContainer = document.createElement("div");
  xpos = Ctrl(id+"_shadow").offsetLeft;
  ypos = Ctrl(id+"_shadow").offsetTop;
  xpos = xpos - Ctrl("backcanvas").offsetLeft + Ctrl("backcanvas").scrollLeft;
  ypos = ypos - Ctrl("backcanvas").offsetTop + Ctrl("backcanvas").scrollTop;
  type = "Expr";
  itemsHTML[countindex] = new ZTObjects.ExprObj('item' + nitem, 'Expr' + nitem, 'Expr', 'Expr', '', xpos, ypos);
  if (isField && !Empty(fcomment)) {
    itemsHTML[countindex].comment = fcomment;
  }
  nitem++;
  countindex++;
  nAllItems++;
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
  putBarDown(e);
  type = null;
  insertIntoUndoSequence();
  removeClassFromElement("selected_var");
}
/* *** Fine della gestione dei campi/parametri delle query e del BO nel Navigator *** */

/* *** Gestione delle variabili nel Navigator *** */
function getVariablesDesc(name) {
  var label = "";
  for (var nav_i = 0; nav_i < reportVariables.length; nav_i++) {
    if ("w_" + reportVariables[nav_i].name == name) {
      label = name;
      if (!(Empty(reportVariables[nav_i].comment))) {
        label += " : " + Strtran(reportVariables[nav_i].comment, "'", "\'");
      }
      label += " - " + encodeType(reportVariables[nav_i].type_value) + "(" + reportVariables[nav_i].len + "," + (LRTrim(reportVariables[nav_i].dec) == '' ? 0 : reportVariables[nav_i].dec) + ")";
      break;
    }
  }
  return label;
}

function decodeType(code) {
  switch (code) {
    case "C":
      return "character";
    case "N":
      return "numeric";
    case "D":
      return "date";
    case "L":
      return "logic";
    case "M":
      return "memo";
    case "T":
      return "datetime";
  }
}

/*
   Inserisce un'espressione contenente la variabile nell'area di lavoro.
 */
function putVar(vobj) {
  navValue = "w_" + vobj.name;
  navDim = vobj.len;
  navCom = ( vobj.comment ? vobj.comment : "" );
  navDec = vobj.dec;
  navType = vobj.type_value.toLowerCase();
  var cc = encodeType(navType);
  if (navDim == 0) {
    if (cc == "N") { navDim = 10; }
    if (cc == "C" || cc == "M") { navDim = 15; }
    if (cc == "D") { navDim = 8; }
    if (cc == "T") { navDim = 14; }
  }
  addItem("Expr");
}

/*
   Inserisce un'espressione contenente la variabile nell'area di lavoro.
 */
function putSystemVar(name) {
  var evtType = "click", e;
  if (arguments[0].type && arguments[0].type == "drop") {
    e = arguments[0];
    name = arguments[1];
    evtType = "drag";
  }
  else if (arguments[0].type && arguments[0].type == "click") {
    name = arguments[1];
  }

  var obj = Ctrl(navIDX);
  if (obj != undefined) {
    obj.removeClass("nav_element_selected");
  }
  navValue = name;
  navIDX = "var_" + name;

  for (var nav_i = 0; nav_i < systemVariables.length; nav_i++) {
    if ((systemVariables[nav_i][0]) == name) {
      navDim = systemVariables[nav_i][3];
      navDec = systemVariables[nav_i][4];
      navCom = systemVariables[nav_i][1];
      if (Empty(navDec)) {
        navDec = 0;
      }
      navType = systemVariables[nav_i][2].toLowerCase();
      break;
    }
  }

  if (evtType == "drag") {
    addItem(e, "Expr");
  }
  else {
    addItem("Expr");
  }
}

function getDim(item) {
  var str = "";
  for (var n = 0; n < navDim; n++) {
    str += "x";
  }
  return textSize(item, str);
}

/* *** Fine della gestione dello spostamento delle barre sul del Navigator *** */

function getBands(item) {
  var result = "";
  if (item.type.indexOf("_down") > 0) {
    return result;
  }

  switch (item.type) {
    case "Group_top":
    case "AltQuery_top":
    case "Section_top":
    case "SectBo_top":
      result = getStandardBands(item);
      break;
    default:
      result = getSpecialBands(item);
      break;
  }
  return result;
}

function getStandardBands(item) {
  var image, str, tooltip;
  if (item.type.indexOf("_down") > 0) {
    return "";
  }

  if (item.id.indexOf("section") < 0) {
    ident = 11;
  }
  else {
    ident = 20;
  }

  str = "<div id='drop_" + item.id + "' class='dropx' style='position:relative;padding-left:" + ident + "px;'>";

  image = "mn_Band_v.gif";
  tooltip = getNavigatorDescBand(item);

  if (item.id.indexOf("altquery") > 0) {
    image = getObjImg("altquery");
  }
  else if (item.id.indexOf("group") > 0) {
    image = getObjImg("group");
  }
  else if (item.id.indexOf("section") > 0) {
    image = getObjImg("section");
  }
  else if (item.id.indexOf("sectbo") > 0) {
    image = getObjImg("sectbo");
  }

  str += "<div id='drag_" + item.id + "' class='dragx' style='position:relative;'>";

  if (item.id.indexOf('section') < 0) {
    str += "<img id='img_cont_" + item.id + "' class='nav_image_element' src='images/collassa.gif' style='padding-right:2px;width:7px;height:7px;cursor:pointer' onclick='clickTreeBand(\"" + item.id + "\")'>";
  }
  str += "<img id='img_" + item.id + "' class='nav_image_element' src='" + image + "'>";
  str += "<div id='band_" + item.id + "' title=\"" + tooltip + "\" class='nav_desc_element' onclick='clickBand(\"" + item.id + "\")'>" + Strtran(getDescBand(item, 15), " ", "&nbsp;") + "</div>";
  str += "</div>";
  str += "<div id = 'cont_" + item.id + "'>";
  return str;
}

function getSpecialBands(item) {
  if (item.type.indexOf("_down") > 0) {
    return "";
  }

  var image, str, tooltip;
  ident = 5;

  str = "<div id='" + item.id + "' style='padding-left:" + ident + "px;'>";

  image = "images/mn_Band_v.gif";
  tooltip = getNavigatorDescBand(item);

  if (item.id.indexOf("break") > 0) {
    image = getObjImg("breakpage");
  }
  else if (item.id.indexOf("htmlsection") > 0) {
    image = getObjImg("htmlsection");
  }
  else if (item.id.indexOf("autocover") > 0) {
    image = getObjImg("autocover");
  }
  else if (item.type.indexOf("ReportBar") > -1) {
    image = "images/mn_Band_o.gif";
  }

  str += "<div>";

  if (item.id.indexOf("PageHeader") > 0 || item.id.indexOf("ReportHeader") > 0) {
    str = "<div id='bandz_" + item.type + "' style='cursor:pointer;clear:both;font-size:8pt;float:left' onclick='moveBand(\"" + item.id + "\")'></div>" + str;
  }
  str += "<img id='img_" + item.id + "' class='nav_image_element' src='" + image + "'>";
  str += "<div><div id='band_" + item.id + "' title=\"" + tooltip + "\" class='nav_desc_element' style='cursor:pointer' onclick='clickBand(\"" + item.id + "\")'>" + Strtran(getDescBand(item, 15), " ", "&nbsp;") + "</div></div>";
  str += "</div>";
  str += "<div id = 'cont_" + item.id + "'>";
  return str;
}

function clickTreeBand(name) {
  var obj = Ctrl("cont_" + name);
  if (obj.style.display == "none") {
    obj.style.display = "block";
    Ctrl("img_cont_" + name).src = "images/collassa.gif";
  }
  else {
    obj.style.display = "none";
    Ctrl("img_cont_" + name).src = "images/espandi.gif";
  }
}

function clickBand2(name) {
  var itmIndex = selectedProp.itemIdx;
  if (newPropObj && last_index != null && last_index == index && !Empty(itmIndex) && last_index == itmIndex) {
    var docElement = document.id('properties').getElement('#'+selectedProp.propTab);
    if (docElement) {
      if (docElement.type == 'checkbox') {
        itemsHTML[itmIndex][selectedProp.propId] = docElement.checked;
      }
      else {
        itemsHTML[itmIndex][selectedProp.propId] = docElement.value;
      }
    }
  }
  unSelectBand(lastBandSelected);
  selectBandCanvans(name);
  selectBand(name);
  dragBars.index = index;
  HightlightSelectedSpaceBar(index);

  if (name.indexOf("_Page") >= 0 || name.indexOf("_Report") >= 0 /*|| name.indexOf("autocover") > -1*/) {
    if (newPropObj != null) {
      newPropObj.HideProperties();
    }
  }
  else {
    /*if (newPropObj != null) {
      newPropObj.HideProperties();
    }*/
    Properties();
  }
  mainitem = itemsHTML[index];
}

function clickBand(name) {
  var node = Mif.id(name);
  if (field_tree && node)
    field_tree.select(node);
  else
    clickBand2(name);
}

function moveBand(fromBandId) {
  var fromPos = -1, toPos = -1, nav_i = 0;
  var toBandId = "";
  for (nav_i = 0; nav_i < bandList.length; nav_i++) {
    if (bandList[nav_i].id == fromBandId) {
      fromPos = nav_i;
      nav_i = bandList.length;
    }
  }
  if (fromPos > -1) {
    if (fromBandId.indexOf("_Page") > -1) {
      toBandId = Strtran(fromBandId, "_Page", "_Report");
    }
    else {
      toBandId = Strtran(fromBandId, "_Report", "_Page");
    }
    for (nav_i = 0; nav_i < bandList.length; nav_i++) {
      if (bandList[nav_i].id == toBandId) {
        toPos = nav_i;
        nav_i = bandList.length;
      }
    }
  }
  if (fromPos > -1 && toPos > -1) {
    var result = false;

    /* Verifica la presenza di PageBreak nel Report Header o nel Report Footer. */
    if (fromBandId.indexOf("_start") > -1) { //Si tratta di un Header
      if (fromBandId.indexOf("_PageHeader_start") > -1) { //Si tratta del PageHeader
        if (fromPos < toPos) {
          //Verifica la presenza di PageBreak tra il PageHeader e il Report Header
          result = checkPageBreakPresence(fromPos, toPos);
        }
        else {
          //Verifica la presenza di PageBreak tra l'inizio della pagina e il Report Header
          result = checkPageBreakPresence(-1, toPos);
        }
      }
      else {
        if (fromPos < toPos) {
          //Verifica la presenza di PageBreak tra l'inizio della pagina e il Report Header
          result = checkPageBreakPresence(-1, fromPos);
        }
        else {
          //Verifica la presenza di PageBreak tra il PageHeader e il Report Header
          result = checkPageBreakPresence(toPos, fromPos);
        }
      }
    }
    else {
      if (fromBandId.indexOf("_PageHeader_end") > -1) { //Si tratta del PageFooter
        if (fromPos < toPos) {
          //Verifica la presenza di PageBreak tra la fine della pagina e il Report Footer
          result = checkPageBreakPresence(toPos, bandList.length);
        }
        else {
          //Verifica la presenza di PageBreak tra il Report Footer e il Page Footer
          result = checkPageBreakPresence(toPos, fromPos);
        }
      }
      else {
        if (fromPos < toPos) {
          //Verifica la presenza di PageBreak tra il Report Footer e il Page Footer
          result = checkPageBreakPresence(fromPos, toPos);
        }
        else {
          //Verifica la presenza di PageBreak tra la fine della pagina e il Report Footer
          result = checkPageBreakPresence(fromPos, bandList.length);
        }
      }
    }

    if (result) {
      var tempY = bandList[fromPos].y;
      bandList[fromPos].y = bandList[toPos].y;
      bandList[toPos].y = tempY;
      reorganizeBandList = true;
      writeHTML();
      clickBand(fromBandId);
      return true;
    }
    else {
      PSAlert.alert("It's not possible moving a " + bandList[fromPos].title + " at this point!!!");
      return false;
    }
  }
}

function unSelectBand(name) {
  var node = Mif.id(name);
  if (field_tree && node) {
    field_tree.unselect(node);
  }

  if ($("band_" + name) == undefined) {
    return;
  }
  $("band_" + name).removeClass("nav_band_selected");
  $("band_" + name).addClass("nav_band_standard");
  lastBandSelected = "";
}

function selectBandCanvans(name) {
  dragBars.oName = name;
  removeAllBarHandlers();
  for (var i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].id == name) {
      index = i;
      itemsHTML[i].shadow = "shadow" + name.substr(4);
      if ((itemsHTML[i].type).toLowerCase().indexOf("break") < 0 && (itemsHTML[i].type).toLowerCase().indexOf("autocover") < 0 && (itemsHTML[i].type).toLowerCase().indexOf("html") < 0) {
        itemsHTML[itemsHTML[i].child].shadow = "noempty";
      }
      i = itemsHTML.length;
    }
  }
  lastBandSelected = name;

  if (Left(itemsHTML[index].type, 5) == "Group" || Left(itemsHTML[index].type, 7) == "Section" || itemsHTML[index].type.indexOf("AltQuery") > -1 || itemsHTML[index].type.indexOf("Break") > -1 || itemsHTML[index].type.indexOf("SectBo") > -1) {
    Properties();
  }
  else {
    FormProperties();
  }
}

function selectBand(name) {
  if ($("band_" + name) == undefined) {
    return;
  }
  $("band_" + name).removeClass("nav_band_standard");
  $("band_" + name).addClass("nav_band_selected");
  lastBandSelected = name;
}

/* Effettua l'inversione di due bande.
   Nel caso una delle due bande sia un gruppo, si deve verificare che si possa inserire in quel punto.
   Nel caso una delle due bande sia una Hide Section, si deve verificare che, spostandola, non contenga gruppi.

   fromBand: id della barra che si sta spostando.
   toBand: id della barra al posto del cui si vuole mettere l'altra.
*/
function switchBands(fromBand, toBand) {
  undoItemsMoved = [];
  unSelectBand(lastBandSelected);
  selectBandCanvans(fromBand);
  selectBand(fromBand);
  var fromIndex_top = index;
  var fromIndex_down = itemsHTML[index].child;

  unSelectBand(lastBandSelected);
  selectBandCanvans(toBand);
  selectBand(toBand);
  var toIndex_top = index;
  var toIndex_down = itemsHTML[index].child;

  var result = true;
  if (reportProp.page != 0) {
    var str = "";
    /* Verifica dello spostamento di barre di tipo gruppo.
       Devo verificare solo nel caso una delle due barre sia un gruppo e l'altra no.
       Questo perche' due gruppi sono sicuramente in posizione corretta.
    */
    if (itemsHTML[fromIndex_top].type == "Group_top" && itemsHTML[toIndex_top].type != "Group_top") {
      result = checkGroupSwitch(fromIndex_top, toIndex_top);
    }
    if (itemsHTML[fromIndex_top].type != "Group_top" && itemsHTML[toIndex_top].type == "Group_top") {
      result = checkGroupSwitch(toIndex_top, fromIndex_top);
    }

    if (!result) {
      PSAlert.alert("It's not possible moving a Group at this point!!!");
      return false;
    }

    /* Verifica dello spostamento di barre di tipo section per evitare che si stia cercando di spostare una Hide Section in modo che possa contenere un gruppo.
       Devo verificare solo nel caso una delle due barre sia una Hide Section e l'altra no.
       Questo perche' due Hide Section sono sicuramente in posizione corretta.
    */
    if (itemsHTML[fromIndex_top].type != "Section_top" && itemsHTML[toIndex_top].type == "Section_top") {
      // Si vuole posizionare un altro item al posto della Hide Section, quindi servono la posizione dell'altro item in bandList, il suo livello e la sua coordinata y.
      str = checkBarsLevel(LibJavascript.Array.indexOf(bandList, itemsHTML[fromIndex_top]), itemsHTML[fromIndex_top].level, itemsHTML[fromIndex_top].y, "navigator");
      if (str == "error") {
        result = false;
      }
    }
    if (itemsHTML[fromIndex_top].type == "Section_top" && itemsHTML[toIndex_top].type != "Section_top") {
      // Si vuole posizionare la Section al posto di un altro item, quindi servono la posizione dell'altro item in bandList, il suo livello e la sua coordinata y.
      str = checkBarsLevel(LibJavascript.Array.indexOf(bandList, itemsHTML[toIndex_top]), itemsHTML[toIndex_top].level, itemsHTML[toIndex_top].y, "navigator");
      if (str == "error") {
        result = false;
      }
    }

    if (!result) {
      PSAlert.alert("It's not possible moving an Hide Section at this point!!!");
      return false;
    }
  }

  var tmpY = itemsHTML[fromIndex_top].y;
  // L'operazione switchBand richiede l'Undo per evitare che, effettuando l'Undo di qualche altra operazione, si creino incroci tra le barre.
  undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[fromIndex_top].id, "switch", itemsHTML[toIndex_top].x, itemsHTML[toIndex_top].y, itemsHTML[fromIndex_top].x, itemsHTML[fromIndex_top].y, itemsHTML[fromIndex_top], itemsHTML[fromIndex_top].w, itemsHTML[fromIndex_top].h, itemsHTML[fromIndex_top].w, itemsHTML[fromIndex_top].h);
  undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[fromIndex_down].id, "switch", itemsHTML[toIndex_down].x, itemsHTML[toIndex_down].y, itemsHTML[fromIndex_down].x, itemsHTML[fromIndex_down].y, itemsHTML[fromIndex_down], itemsHTML[fromIndex_down].w, itemsHTML[fromIndex_down].h, itemsHTML[fromIndex_down].w, itemsHTML[fromIndex_down].h);
  undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[toIndex_top].id, "switch", itemsHTML[fromIndex_top].x, itemsHTML[fromIndex_top].y, itemsHTML[toIndex_top].x, itemsHTML[toIndex_top].y, itemsHTML[toIndex_top], itemsHTML[toIndex_top].w, itemsHTML[toIndex_top].h, itemsHTML[toIndex_top].w, itemsHTML[toIndex_top].h);
  undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(itemsHTML[toIndex_down].id, "switch", itemsHTML[fromIndex_down].x, itemsHTML[fromIndex_down].y, itemsHTML[toIndex_down].x, itemsHTML[toIndex_down].y, itemsHTML[toIndex_down], itemsHTML[toIndex_down].w, itemsHTML[toIndex_down].h, itemsHTML[toIndex_down].w, itemsHTML[toIndex_down].h);

  itemsHTML[fromIndex_top].y = itemsHTML[toIndex_top].y;
  itemsHTML[toIndex_top].y = tmpY;
  tmpY = itemsHTML[fromIndex_down].y;
  itemsHTML[fromIndex_down].y = itemsHTML[toIndex_down].y;
  itemsHTML[toIndex_down].y = tmpY;

  insertIntoUndoSequence();
  return true;
}

/* Verifica se si puo' fare lo switch di un gruppo con un'altra barra.
    groupIndex_top: indice del gruppo in itemsHTML
    otherIndex_top: indice dell'altra barra in itemsHTML
 */
function checkGroupSwitch(groupIndex_top, otherIndex_top) {
  var result = false;
  var tmpOtherY_top = -1, tmpOtherY_down = -1, tmpOtherLvl_top = -1, tmpOtherLvl_down = -1;

  //Indici in bandList.
  var groupPosition_top = LibJavascript.Array.indexOf(bandList, itemsHTML[groupIndex_top]);
  var groupPosition_down = LibJavascript.Array.indexOf(bandList, itemsHTML[itemsHTML[groupIndex_top].child]);
  var otherPosition_top = LibJavascript.Array.indexOf(bandList, itemsHTML[otherIndex_top]);
  var otherPosition_down = LibJavascript.Array.indexOf(bandList, itemsHTML[itemsHTML[otherIndex_top].child]);

  //Si copia l'altro elemento nella posizione del gruppo.
  bandList[groupPosition_top] = bandList[otherPosition_top];
  bandList[groupPosition_down] = bandList[otherPosition_down];

  //Da ora in groupPosition si trova l'altro elemento!!!

  //Si salvano le coordinate e il livello dell'altro elemento per poter tornare alla situazione iniziale.
  tmpOtherY_top = bandList[groupPosition_top].y;
  tmpOtherY_down = bandList[groupPosition_down].y;
  tmpOtherLvl_top = bandList[groupPosition_top].level;
  tmpOtherLvl_down = bandList[groupPosition_down].level;

  //Si aggiustano le coordinate dell'altro elemento.
  bandList[groupPosition_top].y = itemsHTML[groupIndex_top].y;
  bandList[groupPosition_down].y = itemsHTML[itemsHTML[groupIndex_top].child].y;
  //Si aggiusta il livello.
  bandList[groupPosition_top].level = itemsHTML[groupIndex_top].level;
  bandList[groupPosition_down].level = itemsHTML[itemsHTML[groupIndex_top].child].level;

  //Si elimina l'istanza iniziale dell'altro elemento da bandList.
  bandList.splice(otherPosition_down, 1);
  bandList.splice(otherPosition_top, 1);

  result = checkGroupTopPosition(tmpOtherY_top, "navigator");

  /* Si riporta l'array bandList nella situazione iniziale nei seguenti casi:
      - la checkGroupPosition ha dato risultato negativo, ovvero non si puo' spostare il gruppo in quel punto.
      - nel caso l'altra barra sia una Hide Section perche' ci sono dei controlli successivi.
  */
  if (!result || (itemsHTML[otherIndex_top].type.indexOf("Section") > -1)) {
    bandList.splice(otherPosition_top, 0, itemsHTML[otherIndex_top]);
    bandList.splice(otherPosition_down, 0, itemsHTML[itemsHTML[otherIndex_top].child]);
    bandList[groupPosition_top] = itemsHTML[groupIndex_top];
    bandList[groupPosition_down] = itemsHTML[itemsHTML[groupIndex_top].child];
  }

  itemsHTML[otherIndex_top].y = tmpOtherY_top;
  itemsHTML[itemsHTML[otherIndex_top].child].y = tmpOtherY_down;
  itemsHTML[otherIndex_top].level = tmpOtherLvl_top;
  itemsHTML[itemsHTML[otherIndex_top].child].level = tmpOtherLvl_down;

  return result;
}

/* Verifica la presenza di un PageBreak tra due barre.
    startIndex: indice della barra in bandList da cui iniziare la ricerca
    endIndex: indice dell'altra barra in bandList in cui finire la ricerca
*/
function checkPageBreakPresence(startIndex, endIndex) {
  if (startIndex == endIndex + 1) {
    return true;
  }
  var i = startIndex + 1;
  for (; i < endIndex; i++) {
    if (bandList[i].type == "BreakPage" || bandList[i].type == "HtmlSection") {
      return false;
    }
  }
  return true;
}
