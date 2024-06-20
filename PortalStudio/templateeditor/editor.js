/*  exported updateResource getStructure Load checkGroupsEncode */
//Oggetto che tiene tutte le zone del template ed i loro figli(risorse)
var groups = {};
var groups_model = {};

// Variabile che tiene l'encode dell'oggetto groups al caricamento.
// Mi serve per vedere se quando faccio la preview ho modificato qualcosa o meno
var start_groups = "";

function insertResource(r_name, zone, r_parameters, r_type) {
  var isFoundling = ((!Empty($(zone))) && $(zone).hasClass('droppable')) ? false : true;

  var foundling_nodeContent = $(parent.document.getElementById('foundling_nodeContent'));
  if (isFoundling) {
    zone = zone + "_foundlingDiv";
    if (Empty($(zone))) {
      new Element('div', { 'id': zone }).setStyles({
        'display': 'none'
      }).inject(document.body);

      new Element($(parent.document.createElement('div')), {
        'id': zone + '_nodeContent',
        'class': 'foundling_tv_droppable'
      }).inject(foundling_nodeContent);

      openGLN($(foundling_nodeContent));
      $(foundling_nodeContent.parentNode).setStyle(
        'display', 'block'
      );
    }
  }

  var container = $(zone);
  var elemInfo;
  try {
    elemInfo = eval("(" + new JSURL(SPWebRootURL + "/servlet/SPCMSPanel?resourcePath=" + r_type, true).Response() + ")");
  } catch (err) {
    return;
  }

  if (container) {
    var UID = Number.random(1000000, 10000000000);
    var icon_path = elemInfo.img;
    var r_description = new JSURL(SPWebRootURL + "/servlet/JSPReader?action=description&type=portlet&name=" + Strtran(r_name, "_portlet.jsp", ""), true).Response();
    var pName = Strtran(r_name, '_portlet.jsp', '');
    if (!groups[zone]) {
      groups[zone] = { id: zone, childs: [] };
    }

    if (!groups_model[zone]) {
      groups_model[zone] = { id: zone, childs: [] };
    }

    if (!isFoundling) {
      openGLN($(parent.document.getElementById(zone + "_node")));
    }
    var glistNode = $(parent.document.getElementById(zone + "_nodeContent"));
    var icon_small = icon_path.substring(0, icon_path.length - 4) + "_small" + icon_path.substring(icon_path.length - 4, icon_path.length);

    //CUSTOM CMS
    var nodeTreeElement;
    if(r_parameters.indexOf("model_resource=true")<0){
      nodeTreeElement = new Element($(parent.document.createElement('div')), {
        'id': UID + "_treenode",
        'class': 'tv_draggable',
        'title': !Empty(r_description) ? r_description : r_name,
        'events': {
          'mouseover': function() {
            if (this.id.indexOf('_treenode') > -1) {
              var templateid = Strtran(this.id, '_treenode', '') + "_templatenode";
            }
            $(templateid).addClass('active_node');
          },
          'mouseout': function() {
            if (this.id.indexOf('_treenode') > -1) {
              var templateid = Strtran(this.id, '_treenode', '') + "_templatenode";
            }
            $(templateid).removeClass('active_node');
          }
        }
      });
    } else {
      nodeTreeElement = new Element($(parent.document.createElement('div')), {
        'id': UID + "_treenode",
        'class': 'tv_draggable model',
        'title': !Empty(r_description) ? r_description : r_name,
        'events': {
          'mouseover': function() {
            if (this.id.indexOf('_treenode') > -1) {
              var templateid = Strtran(this.id, '_treenode', '') + "_templatenode";
            }
            $(templateid).addClass('active_node');
          },
          'mouseout': function() {
            if (this.id.indexOf('_treenode') > -1) {
              var templateid = Strtran(this.id, '_treenode', '') + "_templatenode";
            }
            $(templateid).removeClass('active_node');
          }
        }
      }).setStyles({
        'backgroundColor':'#ffecc9'
      });
    }

    // nodeTreeImg
    new Element($(parent.document.createElement('div')), {
      'class': 'node_img'
    }).setStyles({
      'background-image': 'url(' + SPWebRootURL + '/' + icon_small + ')'
    }).inject(nodeTreeElement);

    var btnsWrapper = new Element($(parent.document.createElement('div')), {
      'class': 'icon_toolbar'
    }).inject(nodeTreeElement);

    //CUSTOM CMS
    if(r_parameters.indexOf("model_resource=true")<0) {
      // editBtn
      new Element($(parent.document.createElement('div')), {
        'title': 'edit',
        'class': 'icon-edit',
        'events': {
          'mousedown': function(e) {
            e.stopPropagation();
          },
          'click': function(/*e*/) {
            editResource(pName, UID);
          }
        }
      }).inject(btnsWrapper);

      // deleteBtn
      new Element($(parent.document.createElement('div')), {
        'title': 'delete',
        'class': 'icon-delete',
        'events': {
          'mousedown': function(e) {
            e.stopPropagation();
          },
          'click': function(/*e*/) {
            deleteResource(this, 'treeview');
          }
        }
      }).inject(btnsWrapper);
    }

    else{

	// viewBtn
      new Element($(parent.document.createElement('div')), {
        'title': 'view',
        'class': 'icon-view',
        'events': {
          'mousedown': function(e) {
            e.stopPropagation();
          },
          'click': function(e) {
            viewModelResource(pName, UID);
          }
        }
      }).inject(btnsWrapper);


    }

    var nodeTxt = (elemInfo.title != "portlet") ? "" : pName;
    var elWidth = 0,
      elHeight = 0;
    var explPar = (!Empty(r_parameters)) ? r_parameters.split('&') : "";
    var titleFound = false;
    for (var i = 0; i < explPar.length; i++) {
      var token = explPar[i].split("=");
      switch (token[0]) {
        case "title":
          if (elemInfo.title != "portlet") {
            nodeTxt = token[1];
            titleFound = true;
          }
          break;
        case "width":
        case "larghezza":
          elWidth = token[1];
          break;
        case "height":
        case "altezza":
          elHeight = token[1];
          break;
      }
    }
    if (!titleFound) nodeTxt = elemInfo.title;
    nodeTxt = unescape(nodeTxt);
    var nodeTxtTree = (nodeTxt.length > 20) ? nodeTxt.substring(0, 20) + "..." : nodeTxt;
    nodeTxtTree = unescape(nodeTxtTree);

    // nodeTreeElementText
    new Element($(parent.document.createElement('p')), { 'text': nodeTxtTree }).inject(nodeTreeElement);

    nodeTreeElement.inject(glistNode);

    //Setting up Treeview Drag&Drop
    var nodeTreeMarker = new Element($(parent.document.createElement('div')), { 'class': 'tree_maker', 'html': '<p class="drophere">Drop here</p>' });


    //CUSTOM CMS
    if(r_parameters.indexOf("model_resource=true")<0){
      var tv_droppable = $(parent.document.body).getElements('.tv_droppable');
      var tv_draggable = $(parent.document.body).getElements('.tv_draggable');
      // var lastGroup = null;
      // tv_droppable.each(function(elem/*, index*/) {
      //   lastGroup = elem;
      // });

      nodeTreeElement.makeDraggable({
        droppables: tv_droppable,
        handle: nodeTreeElement,
        onBeforeStart: function(el) {
          el.setStyles({ 'position': 'absolute', 'left': 0, 'z-index': 3000, 'top': el.offsetTop + el.getCoordinates().height + 2, 'left': 2 });
          el.setStyles({ 'top': el.offsetTop });
          nodeTreeMarker.setStyles({ 'display': 'block', 'height': el.getCoordinates().height, 'width': '100%' }).inject(el, 'after');
          el.addClass('ondrag');
          $(parent.document.body).getElements('.node_header').each(function(elem/*, index*/) {
            openGLN(elem);
          });
          tv_droppable.each(function(elem/*, index*/) {
            elem.addClass('active_area');
          });
        },
        onDrag: function(el) {
          el.setStyles({ 'left': 0 });
          if (el.offsetTop < 0) el.setStyles({ 'top': 0 });
          var target = null;
          var drop = nodeTreeMarker.getParent();
          if (drop && drop.getChildren().length > 1) {
            var kids = drop.getChildren();
            var mouseY = this.mouse.now.y;
            kids.each(function(k/*, index*/) {
              if (k != el && k != nodeTreeMarker) {
                if (mouseY > (k.getCoordinates().top + Math.round(k.getCoordinates().height / 2))) {
                  target = k;
                } else {}
              }
            });
            if (target == null) {
              if (kids[0] != nodeTreeMarker) nodeTreeMarker.inject(drop, 'top');
            } else {
              if ((target != nodeTreeMarker) && (target != nodeTreeMarker.getPrevious())) nodeTreeMarker.inject(target, 'after');
            }
          }
        },
        onEnter: function(el, drop) {
          drop.adopt(nodeTreeMarker.setStyles({ 'display': 'block', 'height': el.getCoordinates().height, 'width': '100%' }));
        },
        onLeave: function(/*el, drop*/) {
          nodeTreeMarker.dispose();
        },
        onComplete: function(el) {
          var drop = nodeTreeMarker.getParent();
          if (drop) {
            el.setStyles({ 'position': 'relative', 'z-index': 1, 'top': 0 }).replaces(nodeTreeMarker);
            //UPDATING TEMPLATE
            var nextSibling = el.nextSibling;
            var id = el.id.split("_")[0];
            var idSibling = (!Empty(nextSibling)) ? nextSibling.id.split("_")[0] : null;
            var templateElement = $(id + "_templatenode");
            var templateSibling = (!Empty(nextSibling)) ? $(idSibling + "_templatenode") : null;
            var templateContainer = $(Strtran(el.parentNode.id, '_nodeContent', ''));
            if (!Empty(templateSibling)) {
              templateElement.inject(templateSibling, 'before');
            } else if (!Empty(templateContainer)) {
              templateElement.inject(templateContainer, 'bottom');
            }
            if (!Empty($(parent.document.getElementById('foundling_nodeContent')))) {
              var found = false;
              $(parent.document.body).getElements('.foundling_tv_droppable').each(function(el) {
                if (el.getChildren().length >= 1) {
                  found = true;
                } else {
                  el.destroy();
                }
              });
              if (!found) $(parent.document.getElementById('foundling_nodeContent')).nix({ duration: 800 }, true);
            }
            // $$('.droppable').each(function(el) {
            //   el.morph({ 'background-color': '#FFFFFF' });
            // });
            updateStructure();
          } else {
            el.setStyles({ 'position': 'relative', 'z-index': 1, 'top': 0, 'left': 0 });
          }
          nodeTreeMarker.dispose();

          tv_draggable.each(function(elem/*, index*/) {
            if (elem != el) {
              elem.firstChild.setStyles({ 'background-color': '' });
              elem.setStyles({ opacity: 1 });
            }
          });
          tv_droppable.each(function(elem/*, index*/) {
            elem.removeClass('active_area');
          });
          el.removeClass('ondrag');
          // el.setStyles({ 'background-color': '', opacity: 1, 'border-top': 'none', 'border-bottom': 'none' });
        },
        onCancel: function(el) {
          nodeTreeMarker.dispose();
          el.setStyles({ 'position': 'relative', 'z-index': 1, 'top': 0, 'left': 0 });

          tv_draggable.each(function(elem/*, index*/) {
            if (elem != el) {
              elem.firstChild.setStyles({ 'background-color': '' });
              elem.setStyles({ opacity: 1 });
            }
          });
          el.removeClass('ondrag');
          tv_droppable.each(function(elem/*, index*/) {
            elem.removeClass('active_area');
          });
        }
      });
      nodeTreeElement.setStyles({ 'top': 0, 'left': 0 });
    }


    // Inserting into the DOM
    var wrapper = new Element('div', { id: UID + "_templatenode", 'class': 'draggable' }).setStyles({
      'position': 'relative',
      'top': 0
    }).inject(container);

    if (elWidth != 0) {
      wrapper.setStyle('width', elWidth + "px");

      if (elHeight != 0) {
        !Empty(r_description) ?
          r_description += " (Width: " + elWidth + "px - Height: " + elHeight + "px)" :
          r_name += " (Width: " + elWidth + "px - Height: " + elHeight + "px)";
      }
    }
    //CUSTOM CMS
    var resourceDiv ="";

    if(r_parameters.indexOf("model_resource=true")<0){
      resourceDiv = new Element('div', {
        'class': 'item',
        'title': !Empty(r_description) ? r_description : r_name
      }).setStyles({
        'width': '100%'
      }).inject(wrapper);

    }else{
      resourceDiv = new Element('div', {
        'class': 'item',
        'title': !Empty(r_description) ? r_description : r_name
      }).setStyles({
        'width': '100%'
      }).inject(wrapper);

      new Element('div', {
        'title': 'Resource in model',
        'class': 'model_resources',
        'text':'M'
      }).inject(resourceDiv);
    }
    //END CUSTOM CMS
    if (elHeight != 0) {
      wrapper.setStyle('height', elHeight);
      resourceDiv.setStyle('height', elHeight - 2);
    }

    var toolbar, d;
    //CUSTOM CMS
    if(r_parameters.indexOf("model_resource=true")<0){
    //END CUSTOM CMS

      toolbar = new Element('div', { 'class': 'icon_toolbar' }).inject(resourceDiv);

      // editButton
      new Element('span', {
        'title': 'edit',
        'class': 'icon-edit',
        'events': {
          'mousedown': function(e) {
            e.stopPropagation();
          },
          'click': function(/*e*/) {
            editResource(pName, UID);
          }
        }
      }).inject(toolbar);

      // delButton
      new Element('span', {
        'title': 'delete',
        'class': 'icon-delete',
        'events': {
          'mousedown': function(e) {
            e.stopPropagation();
          },
          'click': function(/*e*/) {
            deleteResource(this);
          }
        }
      }).inject(toolbar);

      var res_name = new Element('p', {
        'class': 'res_name',
        'html': nodeTxt
      }).setStyles({
        'background-image': 'url(' + SPWebRootURL + '/' + icon_path + ')',
      }).inject(resourceDiv);

      var elementsDrop = $$('.droppable');

      var marker = new Element('div', { 'class': 'marker' });
      new Element('div').inject(marker);

      d = wrapper;
      d.myzone = zone;
      d.portlet_name = pName;
      d.portlet_url = r_name;
      d.parameters = r_parameters;
      d.type = r_type;
      d.resource_HTML = res_name;
      d.oldIndex = groups[zone].childs.length - 1;
      d.isDropped = false;
      d.isCanceled = false;
      groups[zone].childs.push({ name: pName, url: r_name, parameters: r_parameters, type: r_type, uid: UID, reference: d });
      d.uid = UID;
      d.fixedWidth = (elWidth != 0) ? elWidth : false;
      d.fixedHeight = (elHeight != 0) ? elHeight : false;
      // d.set('morph', { 'duration': '200', link: 'cancel' });
      d.started = false;
      d.makeDraggable({
        droppables: elementsDrop,
        handle: d,
        onBeforeStart: function() {
          if (!d.started) {
            d.started = true;
            d.completed = false;
            if (!Empty(d.getParent().id))
              d.container = d.getParent();
            d.sbl = (!Empty(d.nextSibling)) ? d.nextSibling : null;
            d.isCanceled = false;
            marker.setStyles({ 'display': 'block', 'height': d.getCoordinates().height }).inject(d, 'after');
            marker.firstChild.setStyles({ 'display': 'block', 'height': d.getCoordinates().height, 'width': (d.getCoordinates().width - 5) });
            d.setStyles({ 'position': 'absolute', 'top': (d.getCoordinates().top - d.getStyle('margin-top').toFloat() + 5), 'left': (d.getCoordinates().left - d.getStyle('margin-left').toFloat() + 5), 'width': (d.getCoordinates().width - 20), 'z-index': 999999 });
            d.morph({ 'opacity': '0.7' });
            d.inject(document.body);
            elementsDrop.each(function(elem/*, index*/) {
              elem.addClass('active_area');
            });
          }
        },
        onEnter: function(el, drop) {
          if (el.fixedWidth) {
            marker.firstChild.setStyles({ 'height': el.getCoordinates().height });
          } else {
            marker.firstChild.setStyles({ 'height': el.getCoordinates().height, 'width': drop.getCoordinates().width - 5 });
          }
          drop.adopt(marker.setStyles({ 'display': 'block', 'height': el.getCoordinates().height, 'width': drop.getCoordinates().width }));
        },
        onLeave: function(/*el, drop*/) {
          marker.dispose();
        },
        onDrag: function(el) {
          var target = null;
          var drop = marker.getParent();
          if (drop && drop.getChildren().length > 1) {
            var kids = drop.getChildren();
            var mouseY = this.mouse.now.y;
            kids.each(function(k/*, index*/) {
              if (k != el && k != marker) {
                if (mouseY > (k.getCoordinates().top + Math.round(k.getCoordinates().height / 2))) {
                  target = k;
                } else {}
              }
            });
            if (target == null) {
              if (kids[0] != marker) marker.inject(drop, 'top');
            } else {
              if ((target != marker) && (target != marker.getPrevious())) marker.inject(target, 'after');
            }
          }
        },
        onDrop: function(el, drop) {
          if (!el.isCanceled) {
            if (drop) {
              marker.setStyles({ 'display': 'block' });
              el.isDropped = true;
            } else {
              el.setStyles({ 'position': 'relative', 'top': '0', 'left': '0', 'opacity': 1, 'z-index': 1 });
            }
          }
        },
        onComplete: function(el) {
          elementsDrop.each(function(elem/*, index*/) {
            elem.removeClass('active_area');
          });
          if (el.isDropped) {
            el.completed = true;
            this.detach();
            var toAttach = this;
            el.setStyles({ 'position': 'relative', 'width': (el.fixedWidth) ? el.fixedWidth : '', 'top': '0px', 'left': '0px', 'z-index': 1, 'opacity': '1' }).replaces(marker);
            marker.dispose();
            toAttach.attach();
            //UPDATING TREEVIEW
            var nextSibling = el.nextSibling;
            var id = el.id.split("_")[0];
            var idSibling = (!Empty(nextSibling)) ? nextSibling.id.split("_")[0] : null;
            var treeviewElement = $(parent.document.getElementById(id + "_treenode"));
            var treeviewSibling = (!Empty(nextSibling)) ? $(parent.document.getElementById(idSibling + "_treenode")) : null;
            var tvContainer = parent.document.getElementById(el.parentNode.id + "_nodeContent");
            if (!Empty(treeviewSibling)) {
              treeviewElement.inject(treeviewSibling, 'before');
            } else {
              treeviewElement.inject(tvContainer, 'bottom');
            }
            openGLN(parent.document.getElementById(el.parentNode.id + "_node"));
            updateStructure();
            d.started = false;
            el.isDropped = false;
          } else {
            if (!Empty(d.container)) {
              d.inject(d.container);
            }
            if (!Empty(d.sbl)) {
              d.inject(d.sbl, 'before');
            }
            el.morph({ 'opacity': 1 });
            el.setStyles({ 'position': 'relative', 'width': (el.fixedWidth) ? el.fixedWidth + "px" : '', 'top': '0px', 'left': '0px', 'z-index': 1 });
            marker.dispose();
            updateStructure();
            d.started = false;
          }
        },
        onCancel: function(el) {
          if (!el.completed) {
            elementsDrop.each(function(elem/*, index*/) {
              elem.removeClass('active_area');
            });
            el.isCanceled = true;
            marker.dispose();
            el.morph({ 'opacity': 1 });
            if (!Empty(d.container)) {
              d.inject(d.container);
            }
            if (!Empty(d.sbl)) {
              d.inject(d.sbl, 'before');
            }
            el.setStyles({ 'position': 'relative', 'top': '0', 'left': '0', 'width': (el.fixedWidth) ? el.fixedWidth + "px" : '', 'z-index': 100 });
            d.started = false;
          }
        }
      });
      d.setStyles({ 'top': 0, 'left': 0 });

      //CUSTOM CMS
    }

    else{
	    
      toolbar = new Element('div', { 'class': 'icon_toolbar' , 'style': 'background-color:transparent' }).inject(resourceDiv);
      // editButton
      new Element('span', {
        'title': 'view',
        'class': 'icon-view',
        'events': {
          'mousedown': function(e) {
            e.stopPropagation();
          },
          'click': function(e) {
            viewModelResource(pName, UID);
          }
        }
      }).inject(toolbar);
      
      d = wrapper;
      d.myzone = zone;
      d.portlet_url = r_name;
      d.portlet_name = pName;
      d.parameters = r_parameters;
      d.type = r_type;
      d.resource_HTML = res_name;
      d.oldIndex = groups[zone].childs.length - 1;
      d.isDropped = false;
      d.isCanceled = false;
      groups_model[zone].childs.push({ name: pName, url: r_name, parameters: r_parameters, type: r_type, uid: UID, reference: d });
      d.uid = UID;
      d.fixedWidth = (elWidth != 0) ? elWidth : false;
      d.fixedHeight = (elHeight != 0) ? elHeight : false;
      // d.set('morph', { 'duration': '200', link: 'cancel' });
      d.started = false;

    }

    //END CUSTOM CMS


  }
  WindowClose();
}

function updateResource(UID, params, r_name) {
  var found = false;
  for (var z in groups) {
    for (var t = 0; t < groups[z].childs.length && !found; t++) {
      if (groups[z].childs[t].uid == UID) {
        if (!Empty(r_name)) {
          groups[z].childs[t].name = Strtran(r_name, "_portlet.jsp", "");
          groups[z].childs[t].url = r_name;
          groups[z].childs[t].reference.firstChild.title = groups[z].childs[t].name;
        }
        groups[z].childs[t].parameters = params;

        var nodeTxt = "";
        var explPar = (!Empty(params)) ? params.split('&') : "";
        var elHeight = 0,
          elWidth = 0;
        var titleFound = false;
        for (var i = 0; i < explPar.length; i++) {
          var token = explPar[i].split("=");
          switch (token[0]) {
            case "title":
              nodeTxt = token[1];
              titleFound = true;
              break;
            case "width":
            case "larghezza":
              elWidth = token[1];
              break;
            case "height":
            case "altezza":
              elHeight = token[1];
              break;
          }
        }
        if (elWidth != 0 && elHeight != 0) {
          $(UID + "_templatenode").setStyles({ 'width': elWidth + "px", 'height': (elHeight - 2) + "px" });
          $(UID + "_templatenode").fixedWidth = elWidth;
          $(UID + "_templatenode").fixedHeight = elHeight;
          $(UID + "_templatenode").firstChild.setStyle('height', (elHeight - 4) + "px");
        }
        if (titleFound && nodeTxt != "") {
          var nodeTxtTree = (nodeTxt.length > 20) ? nodeTxt.substring(0, 20) + "..." : nodeTxt;
          nodeTxtTree = unescape(nodeTxtTree);
          nodeTxt = unescape(nodeTxt);
          $(parent.document.getElementById(UID + "_treenode")).getElement('p').set('text', nodeTxtTree);
          $(UID + "_templatenode").getElement('p').set('text', nodeTxt);
          if (elWidth != 0 && elHeight != 0) {
            $(UID + "_templatenode").getElement('p').innerHTML += "<br /><span style='font-size:9px;font-weight:normal;color:#989898'>&nbsp;(Width: " + elWidth + "px - Height: " + elHeight + "px)</span>";
          }
        }
        groups[z].childs[t].reference.parameters = params;
        found = true;
      }
    }
  }
  WindowClose();
}

function updateStructure() {
  for (var zone in groups) {
    if (!Empty($(zone))) {
      groups[zone].childs = [];
      $(zone).getChildren().each(function(el/*, index*/) {
        if(el.parameters.indexOf("model_resource=true") < 0){
          groups[zone].childs.push({ name: el.portlet_name, url: el.portlet_url, parameters: el.parameters, type: el.type, uid: el.uid, reference: el });
        }	
      });
    }
  }
}

function getStructure() {
  for (var zone in groups) {
    if (zone.indexOf('_foundlingDiv') > -1) {
      var nZone = Strtran(zone, '_foundlingDiv', '');
      groups[nZone] = groups[zone];
      groups[nZone].id = Strtran(groups[nZone].id, '_foundlingDiv', '');
      delete groups[zone];
    } else if (!Empty($(zone))) {
      groups[zone].id = Strtran(groups[zone].id, '_foundlingDiv', '');
    }
  }
  return toJSONString(groups);
}

function deleteResource(obj, from) {
  if (confirm("Are you sure?")) {
    var id = ((from == 'treeview') ? obj.parentNode.parentNode.id : obj.parentNode.parentNode.parentNode.id).split("_")[0];
    var treeviewElement = $(parent.document.getElementById(id + "_treenode"));
    var templateElement = $(id + "_templatenode");
    treeviewElement.dispose();
    templateElement.dispose();
    updateStructure();
  }
}


function viewModelResource(name, UID) {
  var parameters = "";
  var type = "";
  var zone = "";
  var found = false;
  for (var z in groups_model) {
    for (var t = 0; t < groups_model[z].childs.length && !found; t++) {
      if (groups_model[z].childs[t].uid == UID) {
        zone = z;
        parameters = groups_model[z].childs[t].parameters;
        type = groups_model[z].childs[t].type;
        found = true;
      }
    }
  }
  parameters = parameters.replace("&model_resource=true","");
  var elemInfo = eval("(" + new JSURL(SPWebRootURL + "/servlet/SPCMSPanel?resourcePath=" + type, true).Response() + ")");

  var params_to_send;
  if (!Empty(parameters)) {
    params_to_send = "{'" + decodeURIComponent(Strtran(Strtran(parameters, "&", "','"), "=", "':'")) + "'}";
  } else {
    params_to_send = "{}";
  }

  var link = SPWebRootURL + "/jsp/gscs_be_gadget_config_tpl.jsp";
  var newlink = elemInfo.link.replace(SPWebRootURL + "/", "../").replace("?", "&");
  link += "?title=" + elemInfo.title + "&portlet=" + newlink;
  link += "&zone=" + zone + "&type=" + type + "&mode=edit&resource_id=" + UID + "&parameters=" + encodeURIComponent(params_to_send);
  link += "&resource_url=" + name + "_portlet.jsp";
  link += "&viewmode=true";
  if (elemInfo.title == "portlet") {
    link += "&portletName=" + name;
  }
  // url, name, args, opt_width_pref, opt_height_pref, opt_resizable_pref,force,entryPoint,cinema_morph_ms
  window.layerOpenForeground(link, elemInfo.title, '', 700, 640, true, 1);
}

function editResource(name, UID) {
  var parameters = "";
  var type = "";
  var zone = "";
  var found = false;
  for (var z in groups) {
    for (var t = 0; t < groups[z].childs.length && !found; t++) {
      if (groups[z].childs[t].uid == UID) {
        zone = z;
        parameters = groups[z].childs[t].parameters;
        type = groups[z].childs[t].type;
        found = true;
      }
    }
  }
  var elemInfo = eval("(" + new JSURL(SPWebRootURL + "/servlet/SPCMSPanel?resourcePath=" + type, true).Response() + ")");

  var params_to_send;
  if (!Empty(parameters)) {
    params_to_send = "{'" + decodeURIComponent(Strtran(Strtran(parameters, "&", "','"), "=", "':'")) + "'}";
  } else {
    params_to_send = "{}";
  }

  var link = SPWebRootURL + "/jsp/gscs_be_gadget_config_tpl.jsp";
  var newlink = elemInfo.link.replace(SPWebRootURL + "/", "../").replace("?", "&");
  link += "?title=" + elemInfo.title + "&portlet=" + newlink;
  link += "&zone=" + zone + "&type=" + type + "&mode=edit&resource_id=" + UID + "&parameters=" + encodeURIComponent(params_to_send);
  link += "&resource_url=" + name + "_portlet.jsp";
  if (elemInfo.title == "portlet") {
    link += "&portletName=" + name;
  }

  // url, name, args, opt_width_pref, opt_height_pref, opt_resizable_pref,force,entryPoint,cinema_morph_ms
  window.layerOpenForeground(link, elemInfo.title, '', 700, 640, true, 1);
}


function addResource(zone) {
  window.layerOpenForeground(SPWebRootURL + "/templateeditor/gadget_explorer.jsp?curr_zone=" + zone, "gadget_explorer", '', 700, 640, true, 1);
}

function Load(c, u, g, p, t) {
  var contents = c;
  var urls = u;
  var groups = g;
  var parameters = p;
  var contents_type = t;
  for (var i = 0; i < contents.length; i++) {
    if (Empty(contents_type[i])) contents_type[i] = 'portlet';
    insertResource(urls[i], groups[i], parameters[i], contents_type[i]);
  }
}

function checkGroupsEncode() {
  return start_groups == toJSONString(groups);
}

function setGroupsEncode() {
  start_groups = toJSONString(groups);
  return;
}

function openGLN(node) {
  node.opened = true;
  node.parentNode.addClass('open');
  node.parentNode.removeClass('close');
}

function closeGLN(node) {
  node.opened = false;
  node.parentNode.addClass('close');
  node.parentNode.removeClass('open');
}

function toggleGadgetListNode(node) {
  (node.opened) ? closeGLN(node): openGLN(node);
}

window.addEvent('domready', function() {
  var glist = $(parent.document.getElementById('gadgetslist'));
  glist.empty();

  //Getting each zone
  var getAll = function() {
    $$('.droppable').each(function(el/*, index*/) {
      groups[el.id] = { id: el.id, childs: [] };

      var nodeGroup = new Element($(parent.document.createElement('div')), {
        'class': 'node_group close'
      });

      var nodeHeader = $(parent.document.createElement('div')).set({
        'id': el.id + '_node',
        'class': 'node_header',
        'events': {
          'click': function(/*event*/) {
            toggleGadgetListNode(this);
          },
          'mouseover': function() {
            $(el.id).parentNode.addClass('active_area');
          },
          'mouseout': function() {
            $(el.id).parentNode.removeClass('active_area');
          }
        }
      });
      nodeHeader.opened = false;

      new Element($(parent.document.createElement('div')), {
        'id': el.id + '_nodeAdd',
        'class': 'node_header_add',
        'title': 'Add resource',
        'events': {
          'click': function(e) {
            e.stopPropagation();
            addResource(el.id);
          }
        }
      }).inject(nodeHeader);

      new Element($(parent.document.createElement('p')), {
        'text': el.id
      }).inject(nodeHeader);

      nodeHeader.inject(nodeGroup);

      new Element($(parent.document.createElement('div')), {
        'id': el.id + '_nodeContent',
        'class': 'tv_droppable',
        'events': {
          'mouseover': function() {
            $(el.id).parentNode.addClass('active_area');
          },
          'mouseout': function() {
            $(el.id).parentNode.removeClass('active_area');
          }
        }
      }).inject(nodeGroup);

      nodeGroup.inject(glist);
    });

    //Costruisco il nodo dei gadget senza gruppo (Se cambio template che ha corrispondenza gruppi diversa)
    var nodeGroupFoundling = new Element($(parent.document.createElement('div')), {
      'class': 'node_group close'
    }).setStyles({
      'display': 'none'
    });

    var nodeHeaderFoundling = $(parent.document.createElement('div')).set({
      'id': 'foundling_node',
      'class': 'node_header node_header_foundling',
      'events': {
        'click': function(/*event*/) {
          toggleGadgetListNode(this);
        }
      }
    });
    nodeHeaderFoundling.opened = false;

    new Element($(parent.document.createElement('p')), {
      'text': "Gadgets without group"
    }).inject(nodeHeaderFoundling);

    nodeHeaderFoundling.inject(nodeGroupFoundling);

    new Element($(parent.document.createElement('div')), {
      'id': 'foundling_nodeContent',
      'class': 'tv_droppable'
    }).inject(nodeGroupFoundling);

    nodeGroupFoundling.inject(glist);

    parent.Load();
    setGroupsEncode();
  };
  getAll.delay(100);
});
