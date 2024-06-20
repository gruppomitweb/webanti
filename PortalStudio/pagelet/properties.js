/* exported EditCss currentItem mainobj Properties FixIEHTMLObjectBug updateProperties
    selectColor editDesc NewCss PageletProperties updateSample rgbToHex selectPortlet
    TempArray hideProperties showProperties on_off_Alpha editParameters editPortlet
*/
// Scrive la properties
var newFormPropObj = null,
  v_line = ' ',
  alpha_prop = true,
  currentItem = '',
  ps_props,
  globalIndex = 0;

if (Empty(localStorage.getItem('zucchetti_pageleteditor_properties'))) {
  ps_props = { width: 250, top: 45, left: 500, opened: true, opacity: 1 };
  localStorage.setItem('zucchetti_pageleteditor_properties', JSON.stringify(ps_props));
} else {
  ps_props = JSON.parse(localStorage.getItem('zucchetti_pageleteditor_properties'));
}
var formProp = new ZTPageletObjects.pageletObj();
function PageletProperties() {
  index = null;
  var mainobj = pageletProp[index_pgl];
  if ( index_pgl == 0 ) { // formProp
    if (Empty(newFormPropObj)) {
      newFormPropObj = new propertiesObj({
        m_obj: mainobj
        , isForm: 1
        , canExpandToColumn: false
        , divcontainer: 'formproperties'
        , moveDiv: false
        , afterRender: resizeGadgetsPane
        , tabindex: globalIndex
      });
    } else {
      newFormPropObj.updatePropertiesFromPaint(mainobj);
    }
  } else {
    ps_currOpener = mainobj.id;
    newPropObj = new propertiesObj({
      m_obj: mainobj
      , isForm: 2
      , canExpandToColumn: false
      , divcontainer: 'pageletproperties'
      , moveDiv: false
      , afterRender: resizeGadgetsPane
      , tabindex: globalIndex
    });
  }
  if (ps_props.form_closed == true) {
    togglePane();
  }
  for (var prop in mainobj.objClass.newProperties) {
    globalIndex += prop.length;
  }
}

var mainobj = formProp;


var ps_currOpener = null;
function Properties(/*next*/) {
  if (index != null) {
    var mainitem = itemsHTML[index];
    if (ps_currOpener == mainitem.id) {
      newPropObj.updateProperties();
      return;
    }
    ps_currOpener = mainitem.id;
    newPropObj = new propertiesObj({ m_obj: mainitem, isForm: false, tabindex: globalIndex });
  }
}

function FixIEHTMLObjectBug(ctrl) {
  // IEBug:iframe che sta sotto la finestra Properties perche' questa stia sopra a combo e Flash
  if (document.all) {
    var str = "<iframe allowtransparency='true' frameborder='0' style='width:" + Ctrl('properties').offsetWidth + 'px;height:' + Ctrl('properties').offsetHeight + "px;position:absolute;top:0px;left:0px;background:none;z-index:-1;filter:chroma(color=\"#FFFFFF\")'></iframe>";
    ctrl.innerHTML += str;
  }
}


function updateProperties(e, the_property, propertyType, isForm, value/*, updateHTML*/) {
  m_bUpdated = true;
  if (EmptyString(value)) {
    value = ' ';
  }
  var arrayProp;
  if (value == '') {
    value = ' ';
  }
  if (isForm == 1) {
    arrayProp = pageletProp[0];
  } else if ( isForm == 2 ) {
    arrayProp = pageletProp[index_pgl];
  } else {
    arrayProp = itemsHTML[index];
  }
  switch (propertyType) {
  case 'int': // solo valori numerici
    value = parseInt(value); // controlla se � un valore numerico valido
    if (isNaN(value)) {
      alert('Wrong data input');
    } else {
      arrayProp[the_property] = value;
    }
    break;
  case 'checkbox':
    if (typeof value == 'boolean') {
      value = value ? 'true' : 'false';
    }
    arrayProp[the_property] = value;
    break;
  default:
    // case 'str': case 'data': case 'select': case 'xmldata'://valori stringa
    arrayProp[the_property] = value;
  }
  writeHTML();
}

function editDesc(id, isFormProp, propName) {
  window.layerOpenForeground('../portalstudio/insert_desc.html?isFormProp=' + isFormProp + '&id=' + id + (!Empty(propName) ? '&propName=' + propName : ''), 'description', '', 500, 200, true, 1);
}

function NewCss(/*index*/) {
  if (parent.newCurrentObj != null) {
    parent.newCurrentObj('New', 'css', {});
  }
}
function EditCss() {
  var css_list = pageletProp[index_pgl].css.split(',');
  for (var i = 0; i < css_list.length; i++) {
    parent.newCurrentObj(Strtran(css_list[i], '.css', ''), 'css', {});
  }
}
function updateSample(obj) {
  try {
    Ctrl(obj.id + '_sample').style.backgroundColor = obj.value;
  } catch (e) {
    alert('Invalid color');
  }
}

function toHex(dec) {
  var result = parseInt(dec).toString(16);
  if (result.length == 1) {
    result = '0' + result;
  }
  return result.toUpperCase();
}
var rgbPattern = /\brgb\(\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*\)/i;
// to convert rgb(xx, yy, zz) into #aabbcc (in mozilla/netscape)
function rgbToHex(inp) {
  for (var rgb; (rgb = inp.match(rgbPattern)) != null; ) {
    var hex = '#';
    for (var j = 1; j < rgb.length; j++) {
      if (isNaN(parseInt(rgb[j]))) {

      } else
        if (j + 2 < rgb.length && rgb[j + 1] == '%') {
          hex += toHex(255 * parseInt(rgb[j]) / 100);
        } else {
          hex += toHex(rgb[j]);
        }
    }
    inp = inp.replace(rgb[0], hex);
  }
  return inp;
}
var TempArray = null;

function hideProperties(id) {
  var ctrl = Ctrl(id);
  var ww; if (v_line != ' ') {
    ww = parseInt(v_line);
  } else {
    ww = pageletProp[index_pgl].w;
  }
  if (ctrl.offsetLeft < parseInt(ww) + 80 && ctrl.offsetTop < parseInt(pageletProp[index_pgl].h) + 60) {
    ctrl.style.display = 'none';
  }
}
function showProperties(id) {
  var ctrl = Ctrl(id);
  var ww; if (v_line != ' ') {
    ww = parseInt(v_line);
  } else {
    ww = pageletProp[index_pgl].w;
  }
  if (ctrl.offsetLeft < parseInt(ww) + 80 && ctrl.offsetTop < parseInt(pageletProp[index_pgl].h) + 60) {
    ctrl.style.display = 'block';
  }
}
function on_off_Alpha(id) {
  var ctrl = Ctrl(id);
  if (alpha_prop) {
    ctrl.style.opacity = 1; ctrl.style.filter = 'alpha(opacity=100)';
    alpha_prop = false;
  } else {
    alpha_prop = true;
    checkAlpha(id);
  }
}
function checkAlpha(id) {
  var ctrl = Ctrl(id);
  var ww; if (v_line != ' ') {
    ww = parseInt(v_line);
  } else {
    ww = pageletProp[index_pgl].w;
  }
  if (alpha_prop) {
    if (ctrl.offsetLeft < parseInt(ww) + 80 && ctrl.offsetTop < parseInt(pageletProp[index_pgl].h) + 60) {
      ctrl.style.opacity = 0.5;
      ctrl.style.filter = 'progid:DXImageTransform.Microsoft.Iris(irisStyle=star,motion=out,duration=2)';
    } else {
      ctrl.style.filter = 'progid:DXImageTransform.Microsoft.Iris(irisStyle=star,motion=out,duration=2)';
      ctrl.style.opacity = 1;
    }
  }
}
function editParameters(idx) {
  window.layerOpenForeground('../portalstudio/parameter_edit.html?idx=' + idx + '&filename=' + itemsHTML[index].name, 'parameters', '', 600, 300, true, 1);
  // window.open("../parameter_edit.html?idx="+idx+"&filename="+itemsHTML[index].name, "parameters", "height=300,width=400,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
}
function editPortlet(ref) {
  var url = document.getElementById(ref).value;
  if (url && url.indexOf('_portlet.jsp') > -1) {
    url = Strtran(url, '_portlet.jsp', '');
    if(url.indexOf("?")>-1){
      url = url.substring(0,url.indexOf("?"));
    }
    if (parent.newCurrentObj != null) {
      window.parent.newCurrentObj(url, 'portlet', {});
    } else {
      window.open('editor.jsp?id=' + url, 'portleteditor', 'resizable=yes,status=no,toolbar=no,menubar=no,location=no');
    }
  }
}

function selectPortlet(retTo) {
  window.layerOpenForeground('insert.jsp?for=' + retTo, 'SelectPortlet', '', 500, 600, true, 1);
  // window.open("insert.jsp?for="+retTo, "SelectPortlet", "width=350,height=358,top=300,left=300,scroll=no,status=no,toolbar=no,resizable=yes");
}
