/* exported mfactor putFieldInAccordion drawDragShadow */
var maxlen = 219;
var maxchar = 20;
var mfactor = Math.round((maxlen/maxchar))-2; // 2 sono i px di margine tra uno spazio e l'altro - viene 9px in css

if(typeof(ZTObjects)=='undefined')
  var ZTObjects=new function(){};

/*** definizione classe di drag and drop degli elementi fields nel gadgets pane ***/
ZTObjects.dragFieldObjClass={
  newProperties:{
    generic:[
      {name:'name',		propID:'name',		type:'str',			tooltip:'Unique identifier for the Field in the current module',	validFunc:'validXMLName'},
      {name:'x',			propID:'x',			type:'int',			tooltip:'X coordinate'},
      {name:'y',			propID:'y',			type:'int',			tooltip:'Y coordinate'},
      {name:'h',			propID:'h',			type:'int',			tooltip:'Height'},
      {name:'w',			propID:'w',			type:'int',			tooltip:'Width'}
    ]
  }
};

ZTObjects.dragFieldObj = function (id, name, type, x, y, w, h, alias, desc, ftype, len, dec, group, groupDesc, detail, param, value, shadow, fromrepedt) {
  this.objClass = ZTObjects.dragFieldObjClass;
  this.id = id;
  this.name = name;
  this.type = type;

  // Position
  this.x = x;
  this.y = y;
  this.h = h;
  this.w = w;

  // Field def
  this.fieldDetail = {};
  this.fieldDetail.alias = alias;
  this.fieldDetail.desc = desc;
  this.fieldDetail.type = ftype;
  this.fieldDetail.len = len;
  this.fieldDetail.dec = dec;
  this.fieldDetail.isParam = param;
  this.groupDetail = {};
  this.groupDetail.name = group;
  this.groupDetail.desc = groupDesc;
  this.groupDetail.detail = detail;

  var dtitle=this.type.charAt(0).toUpperCase()+this.type.slice(1)+": " + this.fieldDetail.alias + "\n";
  dtitle+="Description: " + this.fieldDetail.desc + "\n";
  dtitle+="Type: " + this.fieldDetail.type + " (" + this.fieldDetail.len + "," + this.fieldDetail.dec + ")\n";
  dtitle+="Group: " + this.groupDetail.desc;

  this.html = '<div';
  this.html+=' id="' + this.id + '"';
  this.html+=' data-attr="' + this.id + '"';
  this.html+=' data-title="' + dtitle + '"';
  this.html+=' class="transparent-';
  if(this.groupDetail.detail || this.fieldDetail.isParam)
    this.html+='detail';
  else
    this.html+='field';
  this.html+='"';
  this.html+=' title="' + dtitle + '"';
  this.html+=' style="z-index:1; overflow:hidden; top:' + this.y + 'px; left:' + this.x + 'px;"';
  this.html+=' onmouseenter="drawDragShadow(event,\'' + this.id + '\')"';
  if (fromrepedt)
    this.html+=' data-redt="true"';
  this.html+=' >';

  // contenitore descrizioni
  this.html+='<div';
  this.html+=' class="intcontainer';
  if(this.groupDetail.detail || this.fieldDetail.isParam)
    this.html+=' intdetail';
  this.html+='"';
  this.html+=' >';

  var maxl = 31;
  if(this.groupDetail.detail || this.fieldDetail.isParam)
    maxl = 25;
  var mname = this.fieldDetail.desc;
  if(this.fieldDetail.desc.length>maxl)
    mname = this.fieldDetail.desc.substring(0,maxl-1)+"...";
  // primo div interno
  this.html+='<div';
  this.html+=' id="' + this.id + '_int"';
  this.html+=' class="fldint"';
  this.html+=' >';
  this.html+=ToHTML(mname);
  this.html+='</div>';
  // secondo div interno
  mname = this.fieldDetail.alias;
  if(this.fieldDetail.alias.length>maxl)
    mname = this.fieldDetail.alias.substring(0,maxl-1)+"...";
  this.html+='<div';
  this.html+=' id="' + this.id + '_int_2"';
  this.html+=' class="fldint2"';
  this.html+=' >';
  this.html+=ToHTML(mname);
  this.html+='</div>';
  this.html+='</div>';
  // immagine tipo
  this.html+='<div';
  this.html+=' class="typecontainer';
  if(this.groupDetail.detail || this.fieldDetail.isParam)
    this.html+=' typedetail';
  this.html+='"';

  this.html+=' icon-data="' + getIconDataFromAction(this.fieldDetail.type);
  if(this.groupDetail.detail)
    this.html+=' ' + getIconDataFromAction("detail");
  if(this.fieldDetail.isParam)
    this.html+=' ' + getIconDataFromAction("parameter");
  this.html+='"';
  this.html+=' >';
  this.html+='</div>';
  // generazione span x lunghezza - se memo o 20+ caratteri metto una linea continua
  if(this.fieldDetail.type == "M" || this.fieldDetail.len>maxchar){
    /*this.html+='<span';
    this.html+=' class="transparent-len"';
    this.html+=' >';
    this.html+='</span>';*/
  }
  else{
    for(var i=0; i<this.fieldDetail.len; i++){
      this.html+='<span';
      this.html+=' class="transparent-len-gap"';
      this.html+=' >';
      this.html+='</span>';
    }
  }

  this.html+='</div>';
}

/*** creazione e disegno dell'accordion  - dev'essere inizializzato nel metodo doLoad PRIMA di chiamare il metodo create_gadgets_pane() ***/
function putFieldInAccordion(accID,fieldObj,btnclass,btnaction){
  var wrapper = Ctrl(fieldObj.groupDetail.name + "_divz");
  var title, ul, li;
  if (!wrapper) {
    wrapper = new Element('div', {
      'class' : 'fld_wrapper',
      'id' : fieldObj.groupDetail.name + "_divz"
    }).inject(Ctrl(accID));
    title = new Element('div', {
      'class' : 'fld_title'
    }).inject(wrapper);
    new Element('div', {
      'class' : 'fld_title_txt',
      'text' : fieldObj.groupDetail.desc
    }).inject(title);
    if(!Empty(btnclass)){ // array di bottoni e btnaction di azioni
      for(var i=0; i<btnclass.length; i++){
        new Element('div', {
          'class' : 'fld_title_'+btnclass[i],
          'icon-data' : getIconDataFromAction(btnclass[i]),
          'onclick': btnaction[i]
        }).inject(title);
      }
    }
    new Element('div', {
      'class' : 'fld_title_ico'
    }).inject(title);
    ul = new Element('ul', {
      'class' : 'fld_ul'
    }).inject(wrapper);
    li = new Element('li', {
      'class' : 'fld_li'
    }).inject(ul);
    li.innerHTML = fieldObj.html;
    /* global fld_accordion */
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
    li.innerHTML = fieldObj.html;
  }
}

/*** metodi a supporto degli eventi drag and drop ***/
function getAbsolutePos(el) {
    for (var lx=0, ly=0;
         el != null;
         lx += el.offsetLeft, ly += el.offsetTop - (el.offsetParent ? el.offsetParent.scrollTop : 0), el = el.offsetParent);
    return {x: lx,y: ly};
}

function getFieldHTMLObj(id){
  var i;
  if(!Empty(fieldHTML["vqr"])){
    for(i=0; i<fieldHTML["vqr"].length; i++){
      if(id == fieldHTML["vqr"][i].id)
        return fieldHTML["vqr"][i];
    }
  }

  if(!Empty(fieldHTML["bo"])){
    for(i=0; i<fieldHTML["bo"].length; i++){
      if(id == fieldHTML["bo"][i].id)
        return fieldHTML["bo"][i];
    }
  }

  for(i=0; i<fieldHTML.length; i++){
    if(id == fieldHTML[i].id)
      return fieldHTML[i];
  }

  return null;
}

function getIconDataFromAction(action){
  var micon = "&#xe";
  switch(action){
    case "C":
      micon+="6e5";
      break;
    case "M":
      micon+="641";
      break;
    case "N":
      micon+="6e4";
      break;
    case "D":
      micon+="64e";
      break;
    case "T":
      micon+="648";
      break;
    case "I":
      micon+="60c";
      break;
    case "L":
      micon+="738";
      break;
    case "detail":
      micon+="71b";
      break;
    case "parameter":
      micon+="6e3";
      break;
    case "reload":
      micon+="67d";
      break;
    case "remove":
      micon+="6fa";
      break;
    case "edit":
      micon+="603";
      break;
    case "center_points":
      micon+="7e0";
      break;
    case "search":
      micon+="67f";
      break;
    case "substitute":
      micon+="7c3";
      break;
    case "left":
      micon+="7d2";
      break;
    case "right":
      micon+="7d3";
      break;
    case "left_points":
      micon+="7e1";
      break;
    case "info":
      micon+="6f7";
      break;
    case "right_points":
      micon+="7e2";
      break;
    case "select":
      micon+="6f6";
      break;
    case "ok":
      micon+="6fe";
      break;
    case "geo":
      micon+="6c2";
      break;
  }
  return String.fromCharCode(parseInt(micon.substring(3,7),16));
}

var idFld = "", noFld = false, disableOtherFields = false;
var xp, yp, dx, dy;
function drawDragShadow(e,id,isVar){
  if(disableOtherFields)
    return;
  e = !e ? window.event : e;
  var ctrl = !id ? GetEventSrcElement(e) : Ctrl(id)
  var isReport = !Empty(ctrl.getAttribute("data-redt"));

  if(ctrl.id.indexOf("_shadow")>=0){  // rimuovo shadow esistente
    ctrl.onmousedown = null;
    document.body.style.cursor = "default";
    document.body.onmousemove = null;
    document.body.onmouseup = null;
    document.body.removeChild(ctrl);
    return;
  }

  if(document.getElementsByClassName("dragdropshadow").length>0){
    for(var i=0; i<document.getElementsByClassName("dragdropshadow").length; i++)
      document.body.removeChild(document.getElementsByClassName("dragdropshadow")[i]);
  }

  idFld = ctrl.id ? ctrl.id : ctrl.getAttribute("data-attr");

  var shadowDD = document.createElement("div");
  shadowDD.id = idFld+"_shadow";
  shadowDD.className = "unselectable dragdropshadow";

  var abpos = getAbsolutePos(ctrl),
  scTop = isReport ? Ctrl("fieldsproperties").scrollTop : 0;
  if(isVar)
    abpos = getAbsolutePos(Ctrl(id+"_drag"));
  shadowDD.style.left = abpos.x + "px";
  shadowDD.style.top = (abpos.y - scTop) + "px";
  var ww;
  if(isVar)
    ww = 110;
  else
    ww = ctrl.offsetWidth;
  shadowDD.style.width = ww + "px";
  shadowDD.style.height = ctrl.offsetHeight + "px";
  document.body.appendChild(shadowDD);
  if(!Empty(ctrl.getAttribute("data-title")))
    shadowDD.title = ctrl.getAttribute("data-title");
  shadowDD.setAttribute("data-attr",ctrl.getAttribute("data-attr"));

  noFld = isVar;

  shadowDD.onmousedown = dragShadowField;
  shadowDD.onmouseup = putShadowField;
  shadowDD.onmouseleave = removeDragShadow;
}

function dragShadowField(e){
  $(idFld+"_shadow").addClass("dragdropshadowmove");

  e = (e) ? e : window.event;
  xp = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
  yp = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;

  dx = -Math.round(Ctrl(idFld+"_shadow").offsetWidth/2);
  dy = -Math.round(Ctrl(idFld+"_shadow").offsetHeight/2);

  document.body.style.cursor = "move";
  document.body.onmousemove = moveShadowField;
}

function moveShadowField(e){
  disableOtherFields = true;
  var mw = 0;
  e = (e) ? e : window.event;
  xp = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
  yp = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;

  if(!noFld){
    var fldObj = getFieldHTMLObj(Ctrl(idFld+"_shadow").getAttribute("data-attr"));
    if(!Empty(fldObj)){
      mw = Math.round((maxlen/maxchar))*parseInt(fldObj.fieldDetail.len);
      if(fldObj.fieldDetail.type=="M" || parseInt(fldObj.fieldDetail.len)>maxchar)
        mw = Math.round((maxlen/maxchar))*maxchar;
      Ctrl(idFld+"_shadow").innerHTML = fldObj.fieldDetail.desc;
    }
  }
  else{
    var cc = 10;
    mw = Math.round((maxlen/maxchar))*cc;
    Ctrl(idFld+"_shadow").innerHTML = Ctrl(idFld+"_shadow").getAttribute("data-attr");
  }
  dx = -Math.round(mw/2);
  Ctrl(idFld+"_shadow").style.width = mw+"px";
  xp+=dx;
  yp+=dy;
  Ctrl(idFld+"_shadow").style.left = xp+"px";
  Ctrl(idFld+"_shadow").style.top = yp+"px";

  Ctrl(idFld+"_shadow").onmouseleave = null;
  document.body.onmouseup = putShadowField;
}

function putShadowField(e){
  document.body.style.cursor = "default";
  if(window.EndPutShadowField && validateShadowMove(idFld))
    window.EndPutShadowField(e,idFld,noFld); // metodo che devono implementare i tools che richiamano l'oggetto dragfield
  document.body.removeChild(Ctrl(idFld+"_shadow"));
  document.body.onmousedown = null;
  document.body.onmouseup = null;
  document.body.onmousemove = null;
  idFld = "";
  noFld = false;
  disableOtherFields = false;
}

function validateShadowMove(idFld){
  var minL = Ctrl("canvas").offsetLeft+Ctrl("backcanvas").offsetLeft;
  var minT = Ctrl("canvas").offsetTop+Ctrl("backcanvas").offsetTop;
  var minW = Ctrl("canvas").offsetWidth;
  var minH = Ctrl("canvas").offsetHeight;
  var x = Ctrl(idFld+"_shadow").offsetLeft;
  var y = Ctrl(idFld+"_shadow").offsetTop;
  if((x>=minL && x<=(minL+minW)) && (y>=minT && y<=(minT+minH)))
    return true;
  return false;
}

function removeDragShadow(e,id){
  e = !e ? window.event : e;
  var ctrl = !id ? GetEventSrcElement(e) : Ctrl(id);
  ctrl.parentNode.removeChild(ctrl);
  return;
}
