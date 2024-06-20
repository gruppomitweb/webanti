/* exported
    doLoad openedPageletName Help editItemEvent clickItem beginDragHandler noDefaultDrag PreviewCheck addItem
    ShowResources saveAsModel checkLinkable startSelectLink
    alignItems setShadow selectItemByName togglepagetbar openRes selectLink findItem updateLinksName deleteLink
    Copy Paste
  */

/* exported
    openedPagelet openedPageletName links deltax deltay dx dy
  */

var currentname = ""; //nome del portlet corrente
var InitialPagesList = []; //Lista degli Item iniziali al load
var linking = false; //var per vedere se sono in modalita add link
var m_nFrontendPort = null;
var nitem = 0;
var openedPagelet = false;
var openedPageletName = '';
var plan_resize;

function checkMargins(setPropDiv) {
  var plan_min_height = 30;
  var plan_min_width = 250;
  for(var i = 0; i < itemsHTML.length; i++) {
    var elem = itemsHTML[i];
    var itmX = parseInt(elem.x) + 110;
    var itmY = parseInt(elem.y) + parseInt(document.getElementById(elem.id).offsetHeight) + 30;
    plan_min_height = (itmY > plan_min_height) ? itmY : plan_min_height;
    plan_min_width = (itmX > plan_min_width) ? itmX : plan_min_width;
  }
  if(Empty(plan_resize)) {
    plan_resize = document.getElementById('backcanvas').makeResizable({
      handle: document.getElementById('handler'),
      //limit: {x: [800], y: [600]},
      onComplete: function () {
        formProp.height = document.getElementById('backcanvas').offsetHeight;
        formProp.width = document.getElementById('backcanvas').offsetWidth;
        if(!Empty(document.getElementById('properties').getElement('.form_width')) && !Empty(document.getElementById('properties').getElement('.form_height'))) {
          document.getElementById('properties').getElement('.form_width').set('value', formProp.width);
          document.getElementById('properties').getElement('.form_height').set('value', formProp.height);
        }

        document.getElementById('canvaslinks').setStyles({
          'height': document.getElementById('canvas').offsetHeight,
          'width': document.getElementById('canvas').offsetWidth
        });
        document.getElementById('canvas_showlink').setStyles({
          'height': document.getElementById('canvas').offsetHeight,
          'width': document.getElementById('canvas').offsetWidth
        });
      }
    });
  }
  if(setPropDiv)
    document.getElementById('properties').setStyle('left', parseInt(plan_min_width + 30));
  plan_resize.setOptions({
    limit: {
      x: [plan_min_width],
      y: [plan_min_height]
    }
  });
}

function doLoad(e, id, mode, frontendport) {
  initPainter();
  if(!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }
  var toolbars = {};
  toolbars.align = new SPToolbar(ZTPlanObjects.PSToolbarAlign, 'sptoolbar_align', {
    elementToShow: 'all'
  });
  toolbars.action = new SPToolbar(ZTPlanObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  });

  var fnToDelay = function () {
    AppletTag("Batch");
    BatchApplet().documentloc = Strtran(location.toString(), "visualweb/editor.jsp", "servlet/dummy");
    document.body.style.cursor = "default";
    document.body.onhelp = CancelHelp;
    if(!Empty(id)) {
      currentname = id;
      reload(e);
      if(Ctrl("srcform")) Ctrl("srcform").value = currentname;
    }
    try {
      parent.setTitle(this);
    } catch(e) {
      document.title = currentname + " - Plan Editor";
      //do nothing
    }
    if(mode == 'tosave') currentname = '';
    document.getElementById('loading').fade(0);
    try {
      if(window.frameElement != null && typeof(parent.resizeIframe) != "undefined") {
        parent.resizeIframe(window.frameElement);
      }
    } catch (e) {}
  };
  fnToDelay.delay(2000);
}

function Help(the_property) {
  var i;
  var prop = '';
  if(typeof (anchorToFeature) != 'undefined') {
    if(typeof (the_property) != 'undefined')
      prop += "planeditor_" + the_property.toLowerCase();
    if(prop in anchorToFeature && prop != '')
      i = anchorToFeature[prop];
    else if(index != null && "planeditor_" + itemsHTML[index].type.toLowerCase() in anchorToFeature)
      i = anchorToFeature["planeditor_" + itemsHTML[index].type.toLowerCase()];
    else
      i = anchorToFeature.planeditor;
    windowOpenForeground(m_cHelpUrl + 'help/portalstudio/ps_urg_navigator.htm?' + URLenc( i + (prop != "" ? '||' + prop : "")), '', 'toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
  }
}

var ActionCodeLayer;
var codeOpen = false;

function editItemEvent() {
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style) && !Empty(ac_style.height) ? ac_style.height : 600);
  ac_style.width = (!Empty(ac_style) && !Empty(ac_style.width) ? ac_style.width : 880);
  ac_style.maximized = (!Empty(ac_style) && typeof (ac_style.maximized) != 'undefined' ? ac_style.maximized : false);
  localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
  ActionCodeLayer = new spModalLayer('editItemEvent.htm', {
    'in_iframe': true,
    'draggable': true,
    'width': ac_style.width,
    'height': ac_style.height,
    'resizable': true,
    'border_color': '#CCCCCC',
    'border_width': 1,
    'dragger_height': 12,
    'dragger_image': 'images/ps-editor-drag.png',
    'mask_opacity': 0.4,
    'mask_color': '#CCCCCC',
    'show_scrollbars': false,
    'close_on_click_mask': '',
    'iframe_padding': 0,
    'hide_close_btn': true,
    'maximize': true,
    'maximized': ac_style.maximized,
    'opener':window
  });
  ActionCodeLayer.open();
  codeOpen = true;
}

function beginDragHandler() {}

function noDefaultDrag() {
  //blocca la propagazione
  event.cancelBubble = true;
  event.returnValue = false;
}

function beginDragSelection(e) { //REDEFINED
  if(typeof (hideProperties) != 'undefined') hideProperties('properties');
  var dragstyle = Ctrl("drag").style;
  var canvas = Ctrl("canvas");
  e = (e) ? e : window.event;
  var x = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  var y = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;

  if(document.all) {
    x += window.pageXOffset;
    y += window.pageYOffset;
  }
  x = x - parseInt(Ctrl("backcanvas").style.left);
  y = y - parseInt(Ctrl("backcanvas").style.top);
  dragstartx = x;
  dragstarty = y;
  // mostra il rettangolo di drag
  // document.getElementById('drag').set('tween', {duration: '100'});
  // document.getElementById('dragcontent').set('tween', {duration: '100'});
  // document.getElementById('drag').tween('opacity', 0, 0.6);
  // document.getElementById('dragcontent').tween('opacity', 0, 0.2);
  dragstyle.visibility = "";
  dragstyle.top = y + 'px';
  dragstyle.left = x + 'px';
  dragstyle.width = 0;
  dragstyle.height = 0;
  // installa il gestore del mousemove
  canvas.onmousemove = continueDragSelection;
  canvas.onmouseup = endDragSelection;
  // blocca la propagazione
  cancelEvent(e);
}

function endDragSelection(e) { //REDEFINED
  var drag = Ctrl("drag");
  if(drag.offsetWidth <= 2 && drag.offsetHeight <= 2) {
    selectForm();
  } else {
    findDragItems(e, drag.offsetTop, drag.offsetLeft, drag.offsetWidth, drag.offsetHeight);
  }
  //seleziona l elemento se ci sono elementi nell'area scelta
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].shadow != "") {
      selectItem(Ctrl(itemsHTML[i].shadow));
      break;
    }
  }
  // nasconde il rettangolo di drag
  // document.getElementById('drag').set('tween', {
  //   duration: '200'
  // });
  // document.getElementById('dragcontent').set('tween', {
  //   duration: '200'
  // });
  document.getElementById('drag').tween('opacity', document.getElementById('drag').getStyle('opacity'), 0);
  document.getElementById('dragcontent').tween('opacity', document.getElementById('dragcontent').getStyle('opacity'), 0);
  drag.setStyle('visibility', 'hidden');
  Ctrl("canvas").onmousemove = null;
  Ctrl("canvas").onmouseup = null;
  if(typeof (showProperties) != 'undefined') showProperties('properties');
  //refreshToolTips();
}

function addHandler(x, y, itmIdx, corner, fixed) {
  var cursorStyle = "";
  var moveControl = "";
  if(!fixed) {
    if(corner == 0 || corner == 2)
      cursorStyle = "cursor:nw-resize;";
    else
      cursorStyle = "cursor:ne-resize;";
    moveControl = " onmousedown='beginDragHandler(event," + itmIdx + "," + corner + ")'";
  }
  return "<div id='handler" + itmIdx + "_" + corner + "' style='" + cursorStyle + "z-index:120;display:none;position:absolute;top:" + y + "px;left:" + x + "px;width:7px;height:7px;background:url(../visualweb/images/handler_on.png);'" + moveControl + "><p></p></div>";
}

//REDEFINED
function addHandlers(itmIdx) {
  var itm = Ctrl("item" + itmIdx);
  var itmtitle = '';
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].id == "item" + itmIdx) {
      itmtitle = itemsHTML[i].title;
      mainitem = itemsHTML[i];
    }
  }
  var y = itm.offsetTop;
  var x = itm.offsetLeft;
  var w = itm.offsetWidth;
  var h = itm.offsetHeight;
  var str = "";
  str += addHandler(x - 3, y - 3, itmIdx, 0, true);
  str += addHandler(x - 3 + w, y - 3, itmIdx, 1, true);
  str += addHandler(x - 3 + w, y - 3 + h, itmIdx, 2, true);
  str += addHandler(x - 3, y - 3 + h, itmIdx, 3, true);
  if(mainitem.type != 'Link') {
    document.getElementById("item" + itmIdx).addClass('selected');
    document.getElementById("item" + itmIdx).setAttribute("selected", "");
  }
  // aggiunge il div shadow+n della grandezza dell item per lo spostamento
  str += "<div id='shadow" + itmIdx + "' tabindex='-1' class='shadow' title='" +  itmtitle + ' [' + itm.name + ']' + "' style='" + ((mainitem.type == 'Link' ? "display:none;" : "")) + "top:" + y + "px;left:" + x + "px;'" +
    "onmousedown='this.focus();dragShadow(event);' ondblclick='cancelEvent(event);openResource(event," + itmIdx + ",\"" + itm.id + "\",\"" + itm.title + "\")'>";
  str += "&nbsp;";
  str += "</div>";
  return str;
}

//seleziona l'item se cliccato
function clickItem(e, id_container) {
  var itmNr = id_container.substr(4),itm;
  if(index != null && mainitem && (mainitem.id == "shadow" + itmNr)) {
    return;
  } else {
    if(!linking) {
      var selectedItems = document.querySelectorAll(".item.selected");
      resetItems();
      document.getElementById(id_container).addClass('selected');
      document.getElementById(id_container).setAttribute("selected", "");
      var i, str = "";
      var element = GetEventSrcElement(e);
      if(e.ctrlKey == false) {
        removeAllHandlers();
      } else {
        for (i = 0; i < selectedItems.length; i++) {
          selectedItems[i].addClass('selected');
          selectedItems[i].setAttribute("selected", "");
        }
      }
      if(element.id != id_container || !element.id) {
        while(element.parentNode.id != id_container) {
          element = element.parentNode;
        }
        element = element.parentNode;
      }
      str = addHandlers(element.id.substr(4));
      for(i = 0; i < itemsHTML.length; i++) {
        if(itemsHTML[i].id == element.id) {
          itemsHTML[i].shadow = "shadow" + element.id.substr(4);
        }
      }
      Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str;
      selectItem(Ctrl("shadow" + element.id.substr(4)));
      itm = itemsHTML[index];
    } else {
      setLink(id_container);
    }
  }
  for(var p = 0; p < itemsHTML.length; p++) {
    // rendo visibili le icone dei link figli
    if(itemsHTML[p].type=='Link' && (itemsHTML[p].from == itm.name || itemsHTML[p].from == itm.alias)) {
      document.getElementById(itemsHTML[p].id).classList.add("visible");
    }
  }
}

function PreviewCheck(e/*, id_container*/) {
  e.cancelBubble = true;
  //clickItem(e,id_container)
  if(m_bUpdated == true) {
    if(confirm("Do you want to save " + currentname + "?")) {
      save('true', 'preview');
      return;
    }
  }
  Preview();
}

function Preview() {
  if(itemsHTML[index].type == 'Page') {
    if(isCMS) {
      var context;
      if(Empty(dnsCMS))
        context = window.location.host.split(':')[0];
      else
        context = Trim(dnsCMS);
      var host = window.location.protocol + "//" + context + (!Empty(window.location.port) ? ":" + window.location.port : "") + Strtran(window.location.pathname, "/planeditor/plan.jsp", "");
      windowOpenForeground(host + '/cms/' + itemsHTML[index].alias + '.html', '', 'toolbar=1,menubar=1,location=1,status=1,directories=0,width=800px,height=600px,top=0,left=0,resizable=1,scrollbars=1');
    } else
      windowOpenForeground('../jsp/' + itemsHTML[index].name + '.jsp', '', 'toolbar=1,menubar=1,location=1,status=1,directories=0,width=800px,height=600px,top=0,left=0,resizable=1,scrollbars=1');
  } else
    windowOpenForeground(itemsHTML[index].url, '', 'toolbar=1,menubar=1,location=1,status=1,directories=0,width=800px,height=600px,top=0,left=0,resizable=1,scrollbars=1');
}

function openResource(e, i, id_container, name) {
  e.cancelBubble = true;
  SelectContents(id_container, name);
}

// Funzioni di inserimento nuovo item
var type;

function addItem(item) {
  type = item;
  document.getElementById('mask').setStyle('display', 'block');
  // document.getElementById("mask").fx.start('opacity','0.7').chain(function(){
  document.getElementById('canvasitems').setStyle('cursor', 'crosshair');
  Ctrl("canvas").onmousedown = function (event) {
    // document.getElementById("mask").fx.start('opacity','0').chain(function(){
    document.getElementById("mask").setStyle('display', 'none');
    // });
    // tipz.detach('.tipz');
    putItem(event);
    writeHTML();
    /*
    $$('.tipz').each(function(element,index) {
      element.store('tip:title', ' ');
      element.store('tip:text', element.get('title'));
    });
    tipz.attach('.tipz');
    */
  };
  // });
}

function setLinkables(reset) {
  var itm_main = itemsHTML[index];
  for(var i = 0; i < itemsHTML.length; i++) {
    var itm_temp = itemsHTML[i];
    if(itm_temp.id != itm_main.id && itm_temp.type != "Link") {
      if(reset) {
        document.getElementById(itm_temp.id).removeClass("linkable");
        document.getElementById(itm_temp.id + "_target").setStyles({
          'display': 'none'
        });
      } else {
        var faths = itm_temp.father.split(",");
        var father_found = false;
        for(var j = 0; j < faths.length && !father_found; j++) {
          //CUSTOM CMS PER LINK
          if(isCMS) {
            if(itm_main.alias == faths[j]) {
              father_found = true;
            }
          } else {
            if(itm_main.name == faths[j]) {
              father_found = true;
            }
          }
          //END CUSTOM CMS PER LINK
        }
        if(!father_found) {
          document.getElementById(itm_temp.id + "_target").setStyles({
            'display': 'block'
          });
        }
      }
    }
  }
}

function checkLinkable(elem, out) {
  if(linking) {
    item_main = itemsHTML[index];
    var id_target = elem.id;
    var trovato = false;
    var linked = false;
    for(var i = 0; i < itemsHTML.length && !trovato; i++) {
      item_temp = itemsHTML[i];
      if(item_temp.id == id_target && id_target != item_main.id) {
        trovato = true;
        var faths = item_temp.father.split(",");
        for(var j = 0; j < faths.length; j++) {
          //CUSTOM CMS PER LINK
          if(isCMS) {
            if(item_main.alias == faths[j]) {
              //Already linked
              linked = true;
            }
          } else {
            if(item_main.name == faths[j]) {
              //Already linked
              linked = true;
            }
          }
          //END CUSTOM CMS PER LINK
        }
      }
    }
    if(!linked && item_main.id != id_target)
      if(out) {
        document.getElementById("canvasitems").setStyle('cursor', 'crosshair');
        document.getElementById(elem.id).removeClass('linkable');
      }
    else {
      document.getElementById("canvasitems").setStyle('cursor', 'pointer');
      document.getElementById(elem.id).addClass('linkable');
    }
  }
}

function putItem(e, reload) {
  var xpos = 0;
  var ypos = 0;
  if(!e) e = window.event;
  if(e != null) {
    xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
    if(document.all) {
      xpos += window.pageXOffset;
      ypos += window.pageYOffset;
    }
    xpos = xpos - parseInt(Ctrl("backcanvas").offsetLeft);
    ypos = ypos - parseInt(Ctrl("backcanvas").offsetTop);
  }
  switch(type) {
  case 'Page':
    var html =  '<div onmouseover="checkLinkable(this)" onmouseout="checkLinkable(this,true)" id="item' + nitem + '" name="item' + nitem + '" class="item" style="top:' + (ypos) + 'px;left:' + (xpos) + 'px;" onmousedown="cancelEvent(event);" onClick="cancelEvent(event);clickItem(event,\'item' + nitem + '\')">';
      html += '<div class="icons target" title="Add link" id="item' + nitem + '_target"></div>';
      html += '<div id="item' + nitem + '_header" class="item_header">';
      html += '  <p id="item' + nitem + '_title" class="title"></p>';
      html += '  <p id="item' + nitem + '_subtitle" class="subtitle"></p>';
      html += '</div>';
      html += '<div id="item' + nitem + '_content" class="content">';
      html += '  <div class="pageimage-container"></div>';
      html += '  <div id="item' + nitem + '_itemicons" class="icons-container">';
      html += '    <span class="icons hidden menuflag" title="Page in menu"></span>';
      html += '    <span class="icons hidden modelflag" title="Page is a model"></span>';
      html += '    <span class="icons hidden info" id="item' + nitem + '_description"></span>';
      html += '  </div>';
      html += '</div>';
      html += '    <div id=\'item' + nitem + '_pagetbar\' class="pagetbar">';
      html += '      <div class="tipz contents" id="item' + nitem + '_contents" title="Open contents popup" onclick="cancelEvent(event);clickItem(event,\'item' + nitem + '\');openResource(event,' + nitem + ',\'item' + nitem + '\',\'\');" ></div>';
      if(isCMS) {
        html += '    <div class="tipz cms_template" id="item' + nitem + '_template" title="Edit page layout"  onclick="clickItem(event,\'item' + nitem + '\');EditTemplate(event);"></div>';
      } else {
        html += '    <div class="tipz template" id="item' + nitem + '_template2" title="Edit pagelet"  onclick="clickItem(event,\'item' + nitem + '\');editPagelet(event);"></div>';
      }
      if(isCMS && !previewCMS) {
        html += '    <div class="tipz disabled preview" style="color:#eeeeee" id="item' + nitem + '_preview" title="Not available" ></div>';
      }else{
        html += '    <div class="tipz preview" id="item' + nitem + '_preview" title="Open preview popup" onclick="cancelEvent(event);clickItem(event,\'item' + nitem + '\');PreviewCheck(event,\'item' + nitem + '\');" ></div>';
      }
      html += '      <div class="tipz link" id="item' + nitem + '_addlink" title="Link to another page" onclick="cancelEvent(event);clickItem(event,\'item' + nitem + '\');startSelectLink(this.id,event);" ></div>';
      html += '      <div class="tipz ac" id="item' + nitem + '_code" title="Open action code" onclick="cancelEvent(event);clickItem(event,\'item' + nitem + '\');editItemEvent();" ></div>';
      html += '    </div>';
      html += '</div>';
    itemsHTML[countindex] = new ZTPlanObjects.pageObj('item' + nitem, 'item' + nitem, 'Page', html, '', '', xpos, ypos);
    if(!reload) itemsHTML[countindex].neww = true;
    nitem++;
    countindex++;
    var itm = itemsHTML[countindex - 1];
    Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itm.html;

    //CUSTOM CMS PER LINK
    if(isCMS) {
      Ctrl(itm.id + "_title").innerHTML += itm.alias;
    } else {
      Ctrl(itm.id + "_title").innerHTML += itm.name;
    }
    //END CUSTOM CMS PER LINK

    break;
  case 'Link':
    var htmlLink = '<div id="item' + nitem + '" name="item' + nitem + '" class="link_tools" style="top:' + ypos + 'px;left:' + xpos + 'px;">';
    htmlLink += '<div class="tipz infolink" title="Link Info" onClick="cancelEvent(event);selectLink(\'item' + nitem + '\');" onmousedown="cancelEvent(event);"></div>';
    htmlLink += '<div class="tipz deletelink" title="Delete link" onmousedown="cancelEvent(event);" onClick="cancelEvent(event);deleteLink(\'item' + nitem + '\');"></div>';
    htmlLink += '</div>';
    itemsHTML[countindex] = new ZTPlanObjects.linkObj('item' + nitem, 'item' + nitem, 'Link', htmlLink, '', '', xpos, ypos, '', '');
    nitem++;
    countindex++;
    Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[countindex - 1].html;
    break;
  }
  for(var i = 0; i < itemsHTML.length; i++) {
    var res = document.getElementById(itemsHTML[i].id + "_wrapper");
    if(!Empty(res)) {
      res.style.display = "none";
    }
  }
  document.getElementById('canvasitems').setStyle('cursor', 'default');
  Ctrl("canvas").onmousedown = function (event) {
    beginDragSelection(event);
    resetItems();
  };
}

function resetItems() {
  var i, oldVisible = document.querySelectorAll(".link_tools.visible");
  for (i = 0;  i < oldVisible.length; i++) {
    // rendo non visibili tutti le icone dei vecchi link
    oldVisible[i].classList.remove("visible");
  }

  for(i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].type != "Link") {
      document.getElementById(itemsHTML[i].id).removeClass('selected');
      document.getElementById(itemsHTML[i].id).removeAttribute('selected');
    }
  }
  drawLinks(false);
  mainitem = null;
  //refreshToolTips();
}

function openRes(id, iX, iY, fX, fY, iW, iH, step, tot) {
  //alert("iX: "+iX + " "+"iY: "+iY+" -- "+"fX: "+fX+" fY: "+fY);
  var elem = document.getElementById(id);
  if(step > tot) {
    elem.style.top = "-20px";
    elem.style.left = "-20px";
    elem.style.width = "190px";
    elem.style.height = "155px";
    elem.style.border = "0";
    var closeres = document.getElementById(Strtran(id, "_wrapper", "") + "_closeres");
    //closeres.onclick = function(){eval("closeRes('"+id+"',-20,-20,"+fX+","+fY+",190,155,1,10)")};
    closeres.onclick = function () {
      closeRes(id, -20, -20, fX, fY, 190, 155, 1, 10);
    };
    //alert("iX: "+iX + " "+"iY: "+iY+" -- "+"fX: "+fX+" fY: "+fY);
    return;
  }
  var fWidth = parseInt(190 / 10);
  var fHeight = parseInt(155 / 10);
  elem.style.left = iX + "px";
  elem.style.top = iY + "px";
  step++;
  setTimeout("openRes('" + id + "'," + parseInt(iX - fX) + "," + parseInt(iY - fY) + "," + fX + "," + fY + "," + parseInt(iW + fWidth) + "," + parseInt(iH + fHeight) + "," + step + "," + tot + ")", 10);
}

function closeRes(id, iX, iY, fX, fY, iW, iH, step, tot) {
  //alert("iX: "+iX + " "+"iY: "+iY+" -- "+"fX: "+fX+" fY: "+fY);
  var elem = document.getElementById(id);
  if(step > tot) {
    elem.style.display = "none";
    var idx = Strtran(id, "_wrapper", "").substr(4);
    if(!Empty(document.getElementById("shadow" + idx))) {
      document.getElementById("shadow" + idx).style.display = "block";
      document.getElementById("handler" + idx + "_0").style.display = "block";
      document.getElementById("handler" + idx + "_1").style.display = "block";
      document.getElementById("handler" + idx + "_2").style.display = "block";
      document.getElementById("handler" + idx + "_3").style.display = "block";
    }
    //alert("iX: "+iX + " "+"iY: "+iY+" -- "+"fX: "+fX+" fY: "+fY);
    return;
  }
  var fWidth = parseInt(190 / 10);
  var fHeight = parseInt(155 / 10);
  elem.style.left = iX + "px";
  elem.style.top = iY + "px";
  step++;
  setTimeout("closeRes('" + id + "'," + parseInt(iX + fX) + "," + parseInt(iY + fY) + "," + fX + "," + fY + "," + parseInt(iW - fWidth) + "," + parseInt(iH - fHeight) + "," + step + "," + tot + ")", 10);
}

function ShowResources(e, itm) {
  if(!linking) {
    document.getElementById("shadow" + itm.substr(4)).style.display = "none";
    document.getElementById("handler" + itm.substr(4) + "_0").style.display = "none";
    document.getElementById("handler" + itm.substr(4) + "_1").style.display = "none";
    document.getElementById("handler" + itm.substr(4) + "_2").style.display = "none";
    document.getElementById("handler" + itm.substr(4) + "_3").style.display = "none";
    openResource(e, 0, itemsHTML[index].id, itemsHTML[index].title);
  }
}

// riscrive l'HTML dopo la cancellazione degli items
function writeHTML(reset) {
  if(reset == null) reset = false;
  var itm, itm_html;
  formProp.height = (Empty(formProp.height) ?  Ctrl("canvas").clientHeight : formProp.height);
  formProp.width = (Empty(formProp.width) ?  Ctrl("canvas").clientWidth : formProp.width);
  if(reset) {
    Ctrl("canvasitems").innerHTML = '';
    removeAllHandlers();
  }
  Ctrl('backcanvas').style.height = formProp.height + 'px';
  Ctrl('backcanvas').style.width = formProp.width + 'px';
  var i;
  if(reset)
    for(i = 0; i < itemsHTML.length; i++)
      Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[i].html;
  for(i = 0; i < itemsHTML.length; i++) {
    itm = itemsHTML[i];
    itm_html = Ctrl(itm.id);
    itm_html.name = itm.name;
    itm_html.style.left = itm.x + 'px';
    itm_html.style.top = itm.y + 'px';

    if(itm.type == 'Page') {
      //Check length of title, description, template name
      document.getElementById(itm.id).className = '';
      LibJavascript.CssClassNameUtils.addClass(document.getElementById(itm.id), "item");
      if(!Empty(itm.type_category)) {
        LibJavascript.CssClassNameUtils.addClass(document.getElementById(itm.id), itm.type_category);
      }
      if(!Empty(itm.page_image)) {
        document.querySelector('#' + itm.id + ' .pageimage-container' ).style.backgroundImage = "url('./images/plan_" + itm.page_image + ".jpg')";
      }
      if(!Empty(itm.importance)) {
        LibJavascript.CssClassNameUtils.addClass(document.getElementById(itm.id), itm.importance);
        var shadowRef = document.getElementById("shadow"+itm.id.charAt(itm.id.length-1));
        if(!Empty(shadowRef)) {
          shadowRef.className = "shadow " + itm.importance;
        }
      }
      // newTitle = newTitle.substr(0, 1).toUpperCase() + newTitle.substr(1, newTitle.length).toLowerCase();
      Ctrl(itm.id + "_title").innerHTML = itm.title;

      if(itm.name.toLowerCase() != itm.title.toLowerCase()) {
        Ctrl(itm.id + "_subtitle").classList.remove('hidden');
        Ctrl(itm.id + "_subtitle").innerHTML = itm.name;
      } else {
        Ctrl(itm.id + "_subtitle").classList.add('hidden');
      }

      if(itm.description.toLowerCase() != itm.title.toLowerCase()) {
        Ctrl(itm.id + "_description").classList.remove('hidden');
        Ctrl(itm.id + "_description").title = itm.description;
      } else {
        Ctrl(itm.id + "_description").classList.add('hidden');
      }

      if(itm.model == 'true') {
        document.querySelector("#" + itm.id + "_itemicons .modelflag").classList.remove('hidden');
      } else {
        document.querySelector("#" + itm.id + "_itemicons .modelflag").classList.add('hidden');
      }
      if(isCMS) {
        if(itm.published != 'true') {
          document.getElementById(itm.id).classList.add("notpublished");
        }

        if(itm.menu == 'true') {
          document.querySelector("#" + itm.id + "_itemicons .menuflag").classList.remove('hidden');
        } else {
          document.querySelector("#" + itm.id + "_itemicons .menuflag").classList.add('hidden');
        }
      }
    }
  }
  if(reset) checkMargins(true);
  //refreshToolTips();
}

// viengono eliminati gli elementi selezionati  dall'array
function deleteItem() {
  if((mainitem != null) && confirm('Are you sure?')) {
    var tmp = [];
    var tmpn = 0;
    var deletedlink;
    var itemsToDelete = [];
    var i, m, n, tmp_links, tmp_father;
    for(i = 0; i < itemsHTML.length; i++) {
      itemsHTML[i].aliasLocked = false;
      // cancello i links
      if(itemsHTML[i].shadow != '') {
        if(isCMS && itemsHTML[i].alias != null && (itemsHTML[i].alias.toLowerCase() == "category" || itemsHTML[i].alias.toLowerCase() == "content")) {
          alert(itemsHTML[i].alias + " " + planlockdelete_str);
          itemsHTML[i].aliasLocked = true;
        } else {
          //CUSTOM CMS PER LINK
          if(isCMS) {
            deletedlink = itemsHTML[i].alias;
          } else {
            deletedlink = itemsHTML[i].name;
          }
          //END CUSTOM CMS PER LINK
          for(m = 0; m < itemsHTML.length; m++) {
            if(itemsHTML[m].type == 'Page' && typeof (itemsHTML[m].links) != '') {
              tmp_links = itemsHTML[m].links.split(',');
              for(n = 0; n < tmp_links.length; n++) {
                if(tmp_links[n] == deletedlink) LibJavascript.Array.remove(tmp_links, n);
              }
              itemsHTML[m].links = tmp_links.join(',');
            }
            if(itemsHTML[m].type == 'Page' && typeof (itemsHTML[m].father) != '') {
              tmp_father = itemsHTML[m].father.split(',');
              for(n = 0; n < tmp_father.length; n++) {
                if(tmp_father[n] == deletedlink) LibJavascript.Array.remove(tmp_father, n);
              }
              itemsHTML[m].father = tmp_father.join(',');
            }
            if(itemsHTML[m].type == 'Link') {
              if(itemsHTML[m].to == deletedlink || itemsHTML[m].from == deletedlink)
                itemsHTML[m].toDelete = true;
            }
          }
        }
      }
      if(itemsHTML[i].aliasLocked || (itemsHTML[i].shadow == '' && !itemsHTML[i].toDelete)) { // sposta gli elementi non selezionati  in tmp
        tmp[tmpn] = itemsHTML[i];
        tmpn++;
      } else {
        var itmToDel = itemsHTML[i];
        itemsToDelete.push(itmToDel);
      }
    }
    countindex = tmpn;
    itemsHTML = tmp;
    for(i = 0; i < itemsToDelete.length; i++) {
      if(itemsToDelete[i].type != "Link") {
        var iToDel = document.getElementById(itemsToDelete[i].id);
        var IDnum = itemsToDelete[i].id.substr(4);
        var itm_shadow = document.getElementById("shadow" + IDnum);
        itm_shadow.setStyle('background-color', '#FFFFFF');
        itm_shadow.setStyle('height', '100%');
        iToDel.setStyle('background-color', '#B0B0B0');
        iToDel.fade(0);
        itm_shadow.fade(0);
      }
    }
    var toDelay = function () {
      writeHTML(true);
      index = null;
      Properties();
    };
    drawLinks(true);
    toDelay.delay(500);
  }
}

function saveAsModel() {
  currentname = "";
  save('asModel', null);
}

var notimooManager;

function save(mode, act) {
  if(codeOpen) {
    if(ActionCodeLayer)
      ActionCodeLayer.getContainer().getElement('iframe').contentWindow.fireEvent('save');
  }
  if(!Empty(mode) && Array.isArray(mode) && mode.length == 2) {
    act = mode[1];
    mode = mode[0];
  }
  if(Empty(mode)) mode = 'false';
  if(EmptyString(act)) act = "";
  if(parent) parent.is_Saving = true;
  if(currentname != "") {
    notimooManager = new Notimoo({});
    notimooManager.show({
      title: 'Notification message',
      message: 'saving plan...',
      sticky: true,
      width: 200,
      height: 40
    });
    save2.delay(100, this, [mode, act]);
  } else {
    //CUSTOM CMS
    if(!isCMS)
      window.parent.saveAsTool([mode, act]);
    else
      window.parent.open('../portalstudio/saveas.jsp?isCMS=true&tool=plan&mode=' + mode, null, 'height=400,width=520,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes');
  }
}

function buildLinksObj() {
  var LinksObj = []; // array di oggetti e ogni oggetto definisce un tree
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].father == '') { //roots
      var tree_tmp = {
        caption: itemsHTML[i].name,
        link: '../jsp/' + itemsHTML[i].name + '.jsp',
        target: '_self',
        uid: AlfaKeyGen(10),
        MenuItem: [],
        elements: 0
      };
      LinksObj.push(buildLinksChildsObj(tree_tmp, itemsHTML[i]));
    }
  }
  return toJSONString({
    SPVMNMenu: {
      MenuItem: LinksObj
    }
  });
}

function buildLinksChildsObj(tree_tmp, item) {
  if(item.links != '') {
    var links_array = item.links.split(',');
    for(var l = 0; l < links_array.length; l++) {
      for(var i = 0; i < itemsHTML.length; i++) {
        //CUSTOM CMS PER LINK
        if(isCMS) {
          if(links_array[l] == itemsHTML[i].alias) {
            tree_tmp.MenuItem.push(buildLinksChildsObj({
              caption: links_array[l],
              url: '../jsp/' + links_array[l] + '.jsp',
              target: '_self',
              uid: AlfaKeyGen(10),
              MenuItem: [],
              elements: 0
            }, itemsHTML[i]));
          }
        } else {
          if(links_array[l] == itemsHTML[i].name) {
            tree_tmp.MenuItem.push(buildLinksChildsObj({
              caption: links_array[l],
              url: '../jsp/' + links_array[l] + '.jsp',
              target: '_self',
              uid: AlfaKeyGen(10),
              MenuItem: [],
              elements: 0
            }, itemsHTML[i]));
          }
        }
        //END CUSTOM CMS PER LINK
      }
    }
    tree_tmp.elements = links_array.length;
  }
  return tree_tmp;
}

function setPropertiesID(obj) { //ricreo properties per compatibilita con il vecchio array
  if(obj.objClass.newProperties) {
    var mainObject = obj;
    mainObject.objClass.properties = [];
    for(var i in mainObject.objClass.newProperties) {
      var tab = mainObject.objClass.newProperties[i];
      for(var ii = 0; ii < tab.length; ii++) {
        mainObject.objClass.properties.push(tab[ii].propID);
      }
    }
  }
}

function setPropertiesObj(obj) { //ricreo un oggetto per compatibilità con il vecchio array properties
  var i;
  var PropObj = [];
  var mainObject = obj;
  if(obj.objClass.newProperties) {
    for(i in mainObject.objClass.newProperties) {
      var tab = mainObject.objClass.newProperties[i];
      for(var ii = 0; ii < tab.length; ii++) {
        PropObj.push(tab[ii]);
      }
    }
  } else { //compatibilità con Properties vecchie
    for(i = 0; i < mainObject.objClass.properties.length; i++) {
      PropObj.push({
        'propID': mainObject.objClass.properties[i]
      });
    }
  }
  return PropObj;
}

function save2(mode, act) {
  var strsave = '';
  var valuetosave;
  var prop, check, url, output;
  var save = true;
  var delList = (typeof (act) == 'number' ? "" : UpdateDeletedPages());

  //----Formato JSON
  var JSONItems = [];
  var JsonFormItem = {
    type: 'Plan'
  };
  //--------
  strsave += 'type||Plan';
  //setPropertiesID(formProp);
  // creo un Array di oggetti con le prop vecchie e nuove
  var PropObj = setPropertiesObj(formProp);
  for(var u = 0; u < PropObj.length; u++) {
    prop = PropObj[u].propID;
    valuetosave = formProp[prop];
    if(typeof (valuetosave) != 'number') {
      if(typeof (valuetosave) == 'undefined' || valuetosave == "") valuetosave = ' '; // se la prop e' undefined allora la salvo come ' '
    }
    strsave += "||" + prop + "||" + valuetosave;
    if(typeof (valuetosave) == 'string')
      JsonFormItem[prop] = Trim(valuetosave);
    else
      JsonFormItem[prop] = valuetosave;
  }
  strsave += '|||';
  JSONItems.push(JsonFormItem);
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].type == "Page") {
      InitialPagesList = [];
      InitialPagesList.push(itemsHTML[i]);
    }
    if(itemsHTML[i].neww && !isCMS) {
      check = new JSURL("../servlet/JSPReader?name=" + itemsHTML[i].name + ".jsp&check=true", true).Response();
      if(check == 'found')
        if(!confirm("File " + itemsHTML[i].name + ".jsp already existing proceed ?")) {
          save = false;
          break;
        }
      itemsHTML[i].neww = false;
    }
    //CUSTOM CMS PER LINK
    /* Verifico se esistono Link non validi da escludere nella stringa da salvare */
    var writeItem;
    if(isCMS && itemsHTML[i].type == 'Link') {
      writeItem = false;
      var checkFrom = false;
      var checkTo = false;
      for(var j = 0; j < itemsHTML.length; j++) {
        if(itemsHTML[j].type == 'Page') {
          if((itemsHTML[i].from == itemsHTML[j].name) || (itemsHTML[i].from == itemsHTML[j].alias)) {
            var fromNew = itemsHTML[j].alias;
            checkFrom = true;
          }
          if((itemsHTML[i].to == itemsHTML[j].name) || (itemsHTML[i].to == itemsHTML[j].alias)) {
            var toNew = itemsHTML[j].alias;
            checkTo = true;
          }
          // se trovo pagina con name o alias =from e name o alias=to aggiorno from e to del link con alias
          if(checkFrom && checkTo) {
            var linkFinded = false;
            // verifico che non ci sia gia un link costruito con alias tra gli item di tipo link restanti (k=i+1)
            for(var k = i + 1; k < itemsHTML.length; k++) {
              if(itemsHTML[k].type == 'Link') {
                if(fromNew == itemsHTML[k].from && toNew == itemsHTML[k].to) {
                  linkFinded = true;
                  break;
                }
              }
            }
            // se non ho trovato già il link fatto con alias, scrivo quello attuale con valori di from e to con i rispettivi alias
            if(!linkFinded) {
              itemsHTML[i].from = fromNew;
              itemsHTML[i].to = toNew;
              writeItem = true;
              break;
            }
          }
        }
      }
    } else {
      writeItem = true;
    }
    if((isCMS && writeItem) || (!isCMS)) {
      //setPropertiesID(itemsHTML[i]);
      PropObj = setPropertiesObj(itemsHTML[i]);

      strsave += 'type||' + itemsHTML[i].type;
      var JsonItem = {};
      JsonItem.type = itemsHTML[i].type;

      for(u = 0; u < PropObj.length; u++) {
        //prop=itemsHTML[i].objClass.properties[u];
        //valuetosave=itemsHTML[i][prop];
        prop = PropObj[u].propID;
        valuetosave = itemsHTML[i][prop];
        if(typeof (valuetosave) == 'undefined' || valuetosave == "") valuetosave = ' '; // se la prop è undefined allora la salvo come ' '
        strsave += "||" + prop + "||" + valuetosave;
        if(typeof (valuetosave) == 'string')
          JsonItem[prop] = Trim(valuetosave);
        else
          JsonItem[prop] = valuetosave;
      }
      strsave += '|||';
      JSONItems.push(JsonItem);
    }
    //END CUSTOM CMS PER LINK
  }
  /*In questo modo salva il def in JSON*/
  var JDef = JSON.stringify(JSONItems, function (s, v) {
    if(typeof (v) != 'object') return v.toString();
    else return v;
  });
  let path = ""
  if(!isCMS) {
    path = "../servlet/JSPSave?type=plan&name=" + currentname +
      (m_nFrontendPort ? "&frontendport=" + m_nFrontendPort : "") +
      "&dellist=" + delList +
      "&def=" +     URLenc(JDef) +
      "&planmode=" + mode +
      (typeof (act) == 'number' ? '&index=' + act : '') + '&linksObj=' + encodeURIComponent(buildLinksObj());
  } else {
    if(mode == 'asModel'){
      path = "../servlet/JSPSave?type=plan&name=" + currentname + (m_nFrontendPort ? "&frontendport=" + m_nFrontendPort : "") +
        "&def=" + URLenc(strsave) +
        "&planmode=asModel&linksObj=" + encodeURIComponent(buildLinksObj());
    } else {
      path = "../servlet/gscs_be_generate?type=plan&name=" + currentname +
        "&dellist=" + delList +
        "&def=" + URLenc(strsave) +
        "&planmode=" + mode +
        '&linksObj=' + encodeURIComponent(buildLinksObj());
    }
  }
  url = new JSURL(path + "&m_cID=" + cmdhash, true);
  if(save) output = url.Response();
  if(window.parent.changeName && !isCMS) window.parent.changeName(currentname, '', Strtran(window.frameElement.id, 'portalstudioframe', ''));
  if(output == null) output = "";
  notimooManager.close(notimooManager.elements[0]);
  switch(output) {
  case "true":
    notimooManager.show({
      title: 'Notification message',
      message: 'plan saved!',
      visibleTime: 2000,
      width: 200
    });
    m_bUpdated = false;
    if(typeof (window.opener) != "undefined") {
      try {
        window.opener.document.getElementById('zones_Id').submit();
      } catch(e) {}
    }
    if(arguments.length > 0 && arguments[0] == "close") window.parent.closeCurrentObj();
    if(act == 'preview') Preview();
    if(parent) parent.is_Saving = false;
    break;
  case "ACCESS DENIED":
    alert("Access Denied.");
    break;
    // CUSTOM CMS
    //case "DNS_EMPTY":
    // alert("One DNS is required for this site at least.")
    //break;
    //case "DNS_EXISTS":
    // alert("One of DNS is used by another site.")
    //break;
  case "TEMPLATE_EMPTY":
    alert("Template is required for this site.");
    break;
  case "PROPERTIES_EMPTY":
    alert("Some pages properties are empty. Name, Alias and Page Type required.\nThe alias only accepts Latin characters.");
    break;
  case "PROPERTIES_LANG_EMPTY":
    alert("Alias required.\nThe alias only accepts Latin characters.");
    break;
  case "Home_EXISTS":
    alert("You must declare only one Home page for this site.");
    break;
  case "Login_EXISTS":
    alert("You must declare only one Login page for this site.");
    break;
  case "404_EXISTS":
    alert("You must declare only one 404 page for this site.");
    break;
  case "403_EXISTS":
    alert("You must declare only one 403 page for this site.");
    break;
    // END CUSTOM
  default:
    alert("Plan generation failed.");
    break;
  }
}

function UpdateDeletedPages() {
  var a = [];
  for(var i = 0; i < InitialPagesList.length; i++) {
    if(LibJavascript.Array.indexOf(itemsHTML, InitialPagesList[i]) == -1) { // la page e' stata cancellata
      if(!Empty(InitialPagesList[i].user_agent)) {
        var user_agents = InitialPagesList[i].user_agent.split(',');
        var genIndex = true;
        for(var ii = 0; ii < user_agents.length; ii++) {
          if(ii == 0 && genIndex) {
            a.push(InitialPagesList[i].name);
            genIndex = false;
            ii--;
          } else if(user_agents.length > 1)
            a.push(InitialPagesList[i].name + "_" + user_agents);
        }
      }
    }
  }
  return a.join(',');
}

function Copy(cut) {
  var deftmp = "";
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].shadow != "") {
      //if(itemsHTML[i]==itemsHTML[index]){
      setPropertiesID(itemsHTML[i]);
      deftmp += 'type||' + itemsHTML[i].type;
      for(var u = 0; u < itemsHTML[i].objClass.properties.length; u++) {
        var valuetosave = itemsHTML[i][itemsHTML[i].objClass.properties[u]];
        if(typeof (valuetosave) != 'number') {
          if(typeof (valuetosave) == 'undefined' || valuetosave == "") valuetosave = ' '; // se la prop e' undefined allora la salvo come ' '
        }
        deftmp += "||" + itemsHTML[i].objClass.properties[u] + "||" + valuetosave;
      }
      deftmp += '|||';
    }
  }
  if(cut) deleteItem();
  return deftmp;
}

function reload(e) {
  var url;
  if(!isCMS)
    url = new JSURL("../servlet/JSPLoad?type=plan&name=" + currentname, true);
  else
    url = new JSURL("../servlet/JSPLoad?type=plan&cms=true&name=" + currentname, true);
  var strreload = Strtran(url.Response(), '\u0080', '\u20AC');
  // strreload=Strtran(strreload,'$>','%>');
  // strreload=Strtran(strreload,'<$','<%');
  return reload_(e, strreload, false);
}

function Paste(strpaste) {
  if(strpaste != '') return reload_(null, strpaste, true);
}

function reload_(e, strreload, paste) {
  if(!paste) {
    itemsHTML = [];
    nitem = 0;
    countindex = 0;
  }
  Ctrl("canvasitems").innerHTML = '';
  var reload;
  var arrayreload;
  var arrayreload2;
  var i, b, bb, valore, nomeprop;
  var newTool = false;
  if(Left(strreload, 1) == '[') { //----------------------- Def in formato JSON
    var JsonItems = JSON.parse(strreload);
    arrayreload = JsonItems;
    for(i = 0; i < arrayreload.length; i++) {
      arrayreload2 = arrayreload[i];
      type = arrayreload2.type;
      reload = true;
      putItem(e, reload);
      for(b in arrayreload2) {
        nomeprop = b;
        valore = arrayreload2[b];
        if(valore == 'undefined') valore = ' ';
        if(type == 'Plan' && !paste) { // proprietà generiche del form
          formProp[nomeprop] = valore;
        } else {
          // Nel Paste svuoto i link
          if(paste && (nomeprop == 'father' || nomeprop == 'links')) {
            valore = '';
          }
          if(paste && (nomeprop == 'x' || nomeprop == 'y')) {
            valore = (valore - 0) + 10;
          }
          if(paste && nomeprop == 'name') {
            for(bb = 0; bb < itemsHTML.length; bb++) {
              if(itemsHTML[bb].name == valore) {
                valore += '_copy';
              }
            }
          }
          if(paste && nomeprop == 'pname') {
            for(bb = 0; bb < itemsHTML.length; bb++) {
              if(itemsHTML[bb].pname == valore) {
                valore += '_copy';
              }
            }
          }
          if(paste && nomeprop == 'alias') {
            for(bb = 0; bb < itemsHTML.length; bb++) {
              if(itemsHTML[bb].alias == valore) {
                valore += '_copy';
              }
            }
          }
          itemsHTML[countindex - 1][nomeprop] = valore;
        }
        b++;
      }
      if(!paste)
        InitialPagesList[countindex - 1] = itemsHTML[countindex - 1];
    }
    writeHTML(true);
    if(!paste) drawLinks(true);
  } else if(strreload != ' ' && strreload.substring(0, 4) == 'type') { //-----Vecchi Def con ||
    //cerco se ci sono oggetti link per cpmpatibilita plan vecchi
    if(strreload.indexOf("type||Link") > -1) newTool = true;
    arrayreload = strreload.split('|||');
    for(i = 0; i < arrayreload.length - 1; i++) {
      arrayreload2 = arrayreload[i].split('||');
      type = arrayreload2[1];
      reload = true;
      putItem(e, reload);
      for(b = 0; b < arrayreload2.length; b++) {
        valore = Trim(arrayreload2[b + 1]);
        nomeprop = arrayreload2[b];
        if(valore == 'undefined') valore = ' ';
        if(i == 0 && !paste) { // proprietà generiche del form
          formProp[nomeprop] = valore;
        } else {
          // Nel Paste svuoto i link
          if(paste && (nomeprop == 'father' || nomeprop == 'links')) {
            valore = '';
          }
          if(paste && (nomeprop == 'x' || nomeprop == 'y')) {
            valore = (valore - 0) + 10;
          }
          if(paste && nomeprop == 'name') {
            for(bb = 0; bb < itemsHTML.length; bb++) {
              if(itemsHTML[bb].name == valore) {
                valore += '_copy';
              }
            }
          }
          if(paste && nomeprop == 'pname') {
            for(bb = 0; bb < itemsHTML.length; bb++) {
              if(itemsHTML[bb].pname == valore) {
                valore += '_copy';
              }
            }
          }
          if(paste && nomeprop == 'alias') {
            for(bb = 0; bb < itemsHTML.length; bb++) {
              if(itemsHTML[bb].alias == valore) {
                valore += '_copy';
              }
            }
          }
          itemsHTML[countindex - 1][nomeprop] = valore;
        }
        b++;
      }
      if(!paste)
        InitialPagesList[countindex - 1] = itemsHTML[countindex - 1];
    }
    //creo gli item link per i def vecchi
    if(!newTool && !paste) {
      for(i = 0; i < arrayreload.length - 1; i++) {
        arrayreload2 = arrayreload[i].split('||');
        type = arrayreload2[1];
        for(b = 0; b < arrayreload2.length; b++) {
          valore = Trim(arrayreload2[b + 1]);
          nomeprop = arrayreload2[b];
          if(nomeprop == 'name')
            var name = valore;
          if(nomeprop == 'links' && !Empty(valore)) {
            var links_array = valore.split(',');
            for(var m = 0; m < links_array.length; m++) {
              var htmlLink = '<div id="item' + nitem + '" name="item' + nitem + '" style="top:' + 50 + 'px;left:' + 50 + 'px;">';
              htmlLink += '<div class="tipz infolink" title="Link Info" onmousedown="cancelEvent(event);" onClick="cancelEvent(event);selectLink(\'item' + nitem + '\');"></div>';
              htmlLink += '<div class="tipz deletelink" title="Delete link" onmousedown="cancelEvent(event);" onClick="cancelEvent(event);deleteLink(\'item' + nitem + '\');"></div>';
              htmlLink += '</div>';
              itemsHTML[countindex] = new ZTPlanObjects.linkObj('item' + nitem, 'item' + nitem, 'Link', htmlLink, '', '', 50, 50, name, links_array[m]);
              nitem++;
              countindex++;
              Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[countindex - 1].html;
            }
          }
        }
      }
      // if(!paste) moveLinks();
    }
    writeHTML(true);
    if(!paste) drawLinks(true);
  } else {
    alert('Errore in caricamento del def');
  }
};

function showLink(e) {
  e = (e) ? e : window.event;
  var tX = e.clientX;
  var tY = e.clientY;
  tX = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  tY = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  tX = tX - parseInt(Ctrl("backcanvas").style.left);
  tY = tY - parseInt(Ctrl("backcanvas").style.top);
  var main_Item = itemsHTML[index];
  var itm = Ctrl(main_Item.id);
  Ctrl("canvas_showlink").innerHTML = '';
  var cl = CanvasLib.Init("canvas_showlink", Ctrl("canvas_showlink").offsetWidth, Ctrl("canvas_showlink").offsetHeight);
  // cl.SetAttrib('#36679D',0.5);
  cl.SetAttrib('#00A0BD', 1);
  //alert(mX+ " " +mY+ " " +parseInt(main_Item.offsetLeft+parseInt(main_Item.offsetWidth/2))+ " " +parseInt(main_Item.offsetTop+parseInt(main_Item.offsetHeight/2)));
  cl.DrawLine(tX, tY, itm.offsetLeft + parseInt(itm.offsetWidth / 2), itm.offsetTop + parseInt(itm.offsetHeight / 2), true);
  //Ctrl('debug').innerHTML = tX+ " " +tY;
  //Ctrl('debug').style.display = "none"
}

function resetLinkingStatus() {
  Ctrl("canvas_showlink").innerHTML = '';
  linking = false;
  Ctrl("canvas").onmousedown = function (event) {
    beginDragSelection(event);
    resetItems();
    setTimeout('FormProperties()', 100);
  };
  Ctrl("canvasitems").onmousemove = null;
  Ctrl("canvasitems").setStyle('cursor', 'default');
  setLinkables(true);
}

function startSelectLink(/*id, e*/) {
  //clickItem(e,Strtran(id,"_addlink",''));
  linking = true;
  document.getElementById("canvasitems").setStyle('cursor', 'crosshair');
  Ctrl("canvas").onmousedown = resetLinkingStatus;
  Ctrl("canvasitems").onmousemove = showLink;
  setLinkables();
}

function setLink(id_target) {
  var i, j;
  item_main = itemsHTML[index];
  var trovato = false;
  for(i = 0; i < itemsHTML.length && !trovato; i++) {
    item_temp = itemsHTML[i];
    if(item_temp.id == id_target && id_target != item_main.id) {
      trovato = true;
      var faths = item_temp.father.split(",");
      //CUSTOM CMS PER LINK
      if(isCMS) {
        if(typeof (item_temp.alias) != 'undefined' && item_temp.alias != "") {
          for(j = 0; j < faths.length; j++) {
            if(item_main.alias == faths[j]) {
              //Already linked
              resetLinkingStatus();
              return;
            }
          }
          if(Trim(item_temp.father) != "") {
            item_temp.father += "," + item_main.alias;
          } else {
            item_temp.father = item_main.alias;
          }
          if(Trim(item_main.links) != "") {
            item_main.links += "," + item_temp.alias;
          } else {
            item_main.links += item_temp.alias;
          }
        } else {
          alert("Alias required.\nThe alias only accepts Latin characters.");
          resetLinkingStatus();
          return;
        }
      }
      if(Trim(item_main.links) != "") {
        item_main.links += "," + item_temp.name;
      } else {
        item_main.links += item_temp.name;
      }
      if(Trim(item_temp.father) != "") {
        item_temp.father += "," + item_main.name;
      } else {
        for(j = 0; j < faths.length; j++) {
          if(item_main.name == faths[j]) {
            //Already linked
            resetLinkingStatus();
            return;
          }
        }
        // if(Trim(item_temp.father) != ""){
        // item_temp.father += ","+item_main.name;
        // }else{
        item_temp.father = item_main.name;
        //}
      }
      //END CUSTOM CMS PER LINK
      resetLinkingStatus();
    }
  }
  var htmlLink = '<div id="item' + nitem + '" name="item' + nitem + '"  class="link_tools visible">';
  htmlLink += '<div class="tipz infolink" title="Link Info" onmousedown="cancelEvent(event);" onClick="cancelEvent(event);selectLink(\'item' + nitem + '\');"></div>';
  htmlLink += '<div class="tipz deletelink" title="Delete link" onmousedown="cancelEvent(event);" onClick="cancelEvent(event);deleteLink(\'item' + nitem + '\');"></div>';
  htmlLink += '</div>';

  //CUSTOM CMS PER LINK
  if(isCMS) {
    itemsHTML[countindex] = new ZTPlanObjects.linkObj('item' + nitem, 'item' + nitem, 'Link', htmlLink, '', '', 0, 0, item_main.alias, item_temp.alias);
  } else {
    itemsHTML[countindex] = new ZTPlanObjects.linkObj('item' + nitem, 'item' + nitem, 'Link', htmlLink, '', '', 0, 0, item_main.name, item_temp.name);
  }
  //END CUSTOM CMS PER LINK

  nitem++;
  countindex++;
  Ctrl("canvasitems").innerHTML = Ctrl("canvasitems").innerHTML + itemsHTML[countindex - 1].html;
  drawLinks(false);
}

function selectLink(itm) {
  mainitem = itm;
  //if(typeof(itemsHTML[index])!='undefined') selected=true
  // trova lindice del mainitem
  removeAllHandlers();
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].id == mainitem)
      index = i;
  }
  Properties();
}

function findItem(name) {
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].name == name) return itemsHTML[i];
  }
  return null;
}

function updateLinksName(item, new_name) {
  //CUSTOM CMS PER LINK
  var i, j, tmp_links, tmp_father;
  if(isCMS) {
    for(i = 0; i < itemsHTML.length; i++) {
      if(itemsHTML[i].type == 'Link' && item.alias == itemsHTML[i].from)
        itemsHTML[i].from = new_name;
      if(itemsHTML[i].type == 'Link' && item.alias == itemsHTML[i].to)
        itemsHTML[i].to = new_name;
      if(itemsHTML[i].type == 'Page' && itemsHTML[i].links.indexOf(item.alias) > -1) {
        tmp_links = itemsHTML[i].links.split(',');
        for(j = 0; j < tmp_links.length; j++) {
          if(tmp_links[j] == item.alias) tmp_links[j] = new_name;
        }
        itemsHTML[i].links = tmp_links.join(',');
      }
      if(itemsHTML[i].type == 'Page' && itemsHTML[i].father.indexOf(item.alias) > -1) {
        tmp_father = itemsHTML[i].father.split(',');
        for(j = 0; j < tmp_father.length; j++) {
          if(tmp_father[j] == item.alias) tmp_father[j] = new_name;
        }
        itemsHTML[i].father = tmp_father.join(',');
      }
    }
  } else {
    for(i = 0; i < itemsHTML.length; i++) {
      if(itemsHTML[i].type == 'Link' && item.name == itemsHTML[i].from)
        itemsHTML[i].from = new_name;
      if(itemsHTML[i].type == 'Link' && item.name == itemsHTML[i].to)
        itemsHTML[i].to = new_name;
      if(itemsHTML[i].type == 'Page' && itemsHTML[i].links.indexOf(item.name) > -1) {
        tmp_links = itemsHTML[i].links.split(',');
        for(j = 0; j < tmp_links.length; j++) {
          if(tmp_links[j] == item.name) tmp_links[j] = new_name;
        }
        itemsHTML[i].links = tmp_links.join(',');
      }
      if(itemsHTML[i].type == 'Page' && itemsHTML[i].father.indexOf(item.name) > -1) {
        tmp_father = itemsHTML[i].father.split(',');
        for(j = 0; j < tmp_father.length; j++) {
          if(tmp_father[j] == item.name) tmp_father[j] = new_name;
        }
        itemsHTML[i].father = tmp_father.join(',');
      }
    }
  }
  //END CUSTOM CMS PER LINK
}

function deleteLink(itm) {
  if(!confirm('Delete this Link ?')) return;
  var tmp = [];
  var tmpn = 0;
  var toLink, fromLink;
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].id == itm) {
      item_main = itemsHTML[i].id;
      toLink = itemsHTML[i].to;
      fromLink = itemsHTML[i].from;
    } else {
      tmp[tmpn] = itemsHTML[i];
      tmpn++;
    }
  }
  //CUSTOM CMS PER LINK
  var m, n, tmp_links, tmp_father;
  if(isCMS) {
    for(m = 0; m < itemsHTML.length; m++) {
      if(typeof (itemsHTML[m].links) != '' && itemsHTML[m].alias == fromLink) {
        tmp_links = itemsHTML[m].links.split(',');
        for(n = 0; n < tmp_links.length; n++) {
          if(tmp_links[n] == toLink) LibJavascript.Array.remove(tmp_links, n);
        }
        itemsHTML[m].links = tmp_links.join(',');
      }
      if(typeof (itemsHTML[m].father) != '' && itemsHTML[m].alias == toLink) {
        tmp_father = itemsHTML[m].father.split(',');
        for(n = 0; n < tmp_father.length; n++) {
          if(tmp_father[n] == fromLink) LibJavascript.Array.remove(tmp_father, n);
        }
        itemsHTML[m].father = tmp_father.join(',');
      }
    }
  } else {
    for(m = 0; m < itemsHTML.length; m++) {
      if(typeof (itemsHTML[m].links) != '' && itemsHTML[m].name == fromLink) {

        tmp_links = itemsHTML[m].links.split(',');
        for(n = 0; n < tmp_links.length; n++) {
          if(tmp_links[n] == toLink) LibJavascript.Array.remove(tmp_links, n);
        }
        itemsHTML[m].links = tmp_links.join(',');
      }
      if(typeof (itemsHTML[m].father) != '' && itemsHTML[m].name == toLink) {
        tmp_father = itemsHTML[m].father.split(',');
        for(n = 0; n < tmp_father.length; n++) {
          if(tmp_father[n] == fromLink) LibJavascript.Array.remove(tmp_father, n);
        }
        itemsHTML[m].father = tmp_father.join(',');
      }
    }
  }
  //END CUSTOM CMS PER LINK

  countindex = tmpn;
  itemsHTML = tmp;
  index = null;
  Properties();
  writeHTML(true);
  drawLinks(true);
  document.body.style.cursor = 'default';
  Ctrl("canvasitems").onmousedown = null;
}
// disegna le linee link
var links = '';

function drawLinks(flag) {
  if(flag)
    links = '';
  var ss, item_p;
  var bcolor = '#AAAAAA';
  var idtmp;
  var idtmp_Obj;
  var main_Item;
  Ctrl("canvaslinks").innerHTML = '';
  var cl = CanvasLib.Init("canvaslinks", Ctrl("canvaslinks").offsetWidth, Ctrl("canvaslinks").offsetHeight);
  cl.SetAttrib(bcolor, 0.5);
  /*
  for(var n=0;n<itemsHTML.length;n++){
    main_Item=itemsHTML[n]
    if(main_Item.type=='Link'){
    }
  }
  */
  for(var n = 0; n < itemsHTML.length; n++) {
    main_Item = itemsHTML[n];
    var name_from, name_to;

    if(typeof (main_Item.links) != 'undefined' && Trim(main_Item.links) != '') {

      //CUSTOM CMS PER LINK
      if(isCMS) {
        name_from = main_Item.alias;
      } else {
        name_from = main_Item.name;
      }
      //END CUSTOM CMS PER LINK

      ss = main_Item.links.split(","); //multi link divisi da ','
      for(var x = 0; x < ss.length; x++) {
        for(var p = 0; p < itemsHTML.length; p++) {
          item_p = itemsHTML[p];
          //CUSTOM CMS PER LINK
          if(isCMS) {
            if(ss[x] == item_p.alias) { //collega il nome all id
              idtmp = item_p.id;
              name_to = item_p.alias;
              break;
            }
          } else {
            if(ss[x] == item_p.name) { //collega il nome all id
              idtmp = item_p.id;
              name_to = item_p.name;
              break;
            }
          }
          //FINE CUSTOM PER LINK
        }
        idtmp_Obj = Ctrl(idtmp);
        main_Item = Ctrl(main_Item.id);
        if(idtmp_Obj != null) {
          var obj_from = main_Item;
          var obj_to = idtmp_Obj;
          var fX = obj_from.offsetLeft + obj_from.offsetWidth / 2;
          var fY = obj_from.offsetTop + obj_from.offsetHeight / 2;
          var rangeX1 = obj_to.offsetLeft - 100;
          var rangeX2 = obj_to.offsetLeft + obj_to.offsetWidth + 100;
          var tX = obj_to.offsetLeft + obj_to.offsetWidth / 2;
          var tY = obj_to.offsetTop - 13;
          var pos = "";
          if(obj_from.offsetLeft < rangeX2 && obj_from.offsetLeft > rangeX1) { //bottom-top
            if(obj_from.offsetTop < obj_to.offsetTop) { //top
              tX = obj_to.offsetLeft + parseInt(obj_to.offsetWidth / 2) - 2;
              tY = obj_to.offsetTop - 15;
              pos = "top";
            } else { //bottom
              tX = obj_to.offsetLeft + parseInt(obj_to.offsetWidth / 2) + 3;
              tY = obj_to.offsetTop + obj_to.offsetHeight;
              pos = "bottom";
            }
          } else { //left-right
            if(obj_from.offsetLeft < rangeX1) { //left
              tX = obj_to.offsetLeft - 5;
              tY = obj_to.offsetTop + 18;
              pos = "left";
            } else { //right
              tX = obj_to.offsetLeft + obj_to.offsetWidth + 5;
              tY = obj_to.offsetTop + 18;
              pos = "right";
            }
          }
          cl.DrawLine(fX, fY, tX, tY, true);
          var lArrow = 0;
          var tArrow = 0;
          switch(pos) {
          case "top":
            lArrow = obj_to.offsetLeft + parseInt(obj_to.offsetWidth / 2) - 5;
            tArrow = obj_to.offsetTop - 14;
            break;
          case "bottom":
            lArrow = obj_to.offsetLeft + parseInt(obj_to.offsetWidth / 2);
            tArrow = obj_to.offsetTop + obj_to.offsetHeight - 4;
            break;
          case "left":
            lArrow = obj_to.offsetLeft - 6;
            tArrow = obj_to.offsetTop + 15;
            break;
          case "right":
            lArrow = obj_to.offsetLeft + obj_to.offsetWidth - 1;
            tArrow = obj_to.offsetTop + 15;
            break;
          }
          cl.SetAttrib(bcolor, 0.5);
          // if(IsIE()){
          // lArrow=parseInt(lArrow/2);
          // tArrow=parseInt(tArrow/2);
          // }
          cl.DrawArrow(6, 6, lArrow, tArrow, pos);
          var linkPropY, linkPropX;
          for(var j = 0; j < itemsHTML.length; j++) {
            if(itemsHTML[j].type == 'Link') {
              if(itemsHTML[j].to == name_to && itemsHTML[j].from == name_from) {
                switch(pos) {
                case "top":
                  linkPropX = lArrow + 12;
                  linkPropY = tArrow - 12;
                  break;
                case "bottom":
                  linkPropX = lArrow + 15;
                  linkPropY = tArrow;
                  break;
                case "left":
                  linkPropX = lArrow - 40;
                  linkPropY = tArrow - 4;
                  break;
                case "right":
                  linkPropX = lArrow + 15;
                  linkPropY = tArrow;
                  break;
                }
                Ctrl(itemsHTML[j].id).style.top = linkPropY + 'px';
                Ctrl(itemsHTML[j].id).style.left = linkPropX + 'px';
                itemsHTML[j].x = linkPropX;
                itemsHTML[j].y = linkPropY;
              }
            }
          }

        }
      }
    }
  }
  checkMargins();
}

cancelEvent = function (e) {
  // blocca la propagazione
  e = (e) ? e : window.event;
  //e.cancelBubble = true;
  if(window.event)
    window.event.cancelBubble = true;
  else
    e.cancelBubble = true;
  if(e.stopPropagation) e.stopPropagation();
  //e.returnValue=false
};

// Funzioni di trascinamento items ####################################
var deltax = 0,
  deltay = 0,
  dx, dy; // distanze del punto di click dall origine dell item
function setShadow() {
  Ctrl("canvas").onmousemove = null;
  if(!Empty(mainitem)) mainitem.onmouseup = null;
  moveItems();
  // moveLinks();
  //GM
  for(var p = 0; p < itemsHTML.length; p++) {
    if(itemsHTML[p].shadow != "") {
      var elementShadow = Ctrl(itemsHTML[p].shadow);
      elementShadow.innerHTML = "";
    }
    if(itemsHTML[p].from == "item"+mainitem.id.substr(6)) {
      document.getElementById(itemsHTML[p].id).classList.add("visible");
    }
  }

  //GM
  Properties();
  drawLinks(true);
}

//Funzioni di allineamento
function alignItems(side) {
  var p;
  if(!Empty(mainitem)) {
    switch(side) {
    case 'left':
      for(p = 0; p < itemsHTML.length; p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != '') {
          Ctrl(itemsHTML[p].shadow).style.left = mainitem.offsetLeft + 'px';
          itemsHTML[p].x = mainitem.offsetLeft;
        }
      }
      moveItems();
      break;
    case 'top':
      for(p = 0; p < itemsHTML.length; p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != '') {
          Ctrl(itemsHTML[p].shadow).style.top = mainitem.offsetTop + 'px';
          itemsHTML[p].y = mainitem.offsetTop;
        }
      }
      moveItems();
      break;
    case 'right':
      for(p = 0; p < itemsHTML.length; p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != '') {
          Ctrl(itemsHTML[p].shadow).style.left = (mainitem.offsetLeft + mainitem.offsetWidth - Ctrl(itemsHTML[p].shadow).offsetWidth) + 'px';
          itemsHTML[p].x = mainitem.offsetLeft + mainitem.offsetWidth - Ctrl(itemsHTML[p].shadow).offsetWidth;
        }
      }
      moveItems();
      break;
    case 'bottom':
      for(p = 0; p < itemsHTML.length; p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != '') {
          Ctrl(itemsHTML[p].shadow).style.top = (mainitem.offsetTop + mainitem.offsetHeight - Ctrl(itemsHTML[p].shadow).offsetHeight) + 'px';
          itemsHTML[p].x = mainitem.offsetTop + mainitem.offsetHeight - Ctrl(itemsHTML[p].shadow).offsetHeight;
        }
      }
      moveItems();
      break;
    }
    drawLinks(true);
  } else {
    alert('No page selected');
  }
}

function selectItem(itm) {
  SetOnEditProp(false);
  var selecteditem;
  mainitem = itm;
  selecteditem = mainitem.id.substr(6);
  if(index == selecteditem) return;
  // trova lindice del mainitem
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].shadow == mainitem.id)
      index = i;
  }
  Properties();
  EmptyRefLines();
  addRulersLines();
}

function selectItemByName(name) {
  for(var i = 0; i < itemsHTML.length; i++) {
    if(itemsHTML[i].name == name) {
      if(i == index) return;
      else selectedItem(itemsHTML[i]);
      break;
    }
  }
}
