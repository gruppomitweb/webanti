/* exported ZList */
var ZList = new Class({
  Implements: [Options],
  options:{
    idName:"",
    aliasName:"",
    descName:"",
    cssClassItem:"",
    onClick:null,
    onDblClick:null,
    onMouseOver:null,
    onMouseOut:null,
    sortable:false,
    sortHandlerCssClass:'',
    moverMsg:'',
    moverImage:'',
    onMoverMouseDown:null,
    isSortableElement: function(/*el*/) {return true;},
    buttons:[], //{image , title, functionName, cssClass}
    images:[], //{image , title, cssClass, id}
    itemContainsItem:false,
    cssClassContainerItem:"",
    containerTitle:"",
    subItemsName:"",
    onMove:function(/*itmId, oldContId, newContId, elementIdNearTo , mode*/){}
  },
  _sort:null,
  _innerSort:null,
  autonumber:0,
  initialize:function(container,options){
    this.setOptions(options);
    this.container=document.id(container);
    if (this.options.sortable) {
      // this._sort = new Sortables(this.container,{clone:function(){return new Element('div');},constrain: true,  handle:"span."+this.options.cssClassItem+"-"+(this.options.sortHandlerCssClass?this.options.sortHandlerCssClass:"handler")});
      // this._sort.addEvent('start', function(el,clone) {
        // this.lists.each(function(l) {
          // l.addClass("dropper");
        // });
        // if (!this.list.scroller)
          // this.list.scroller=new Scroller(this.list);
        // this.list.scroller.start();
        // el.addClass("dragging");
      // });
      // this._sort.addEvent('complete', function(el,clone) {
        // this.lists.each(function(l) {
          // l.removeClass("dropper");
        // });
        // if (this.list.scroller)
          // this.list.scroller.stop();
        // el.removeClass("dragging");
      // });
      // this._sort.addEvent('sort', function() {
      // });
      if (this.options.itemContainsItem) {
      }
    }
  },
  _getHTMLStringOfItems:function(newItems, level, contId) {
    if (typeof(level)=='undefined') level=0;
    if (Empty(this.containerId)) this.containerId = this.container.id;
    if (Empty(this.containerId)) this.containerId = LibJavascript.AlfaKeyGen(10);
    var src_array=new LibJavascript.String.Chainer(),img;
    for(var i=0;i<newItems.length;i++, this.autonumber++){
      src_array.concat("<div name='"+(newItems[i][this.options.idName])+"' class='"+this.options.cssClassItem+"' id='"+this.containerId+"_"+this.autonumber+"'>");
      if (this.options.sortable) {
        src_array.concat("<span class='"+this.options.cssClassItem+"-"+(this.options.sortHandlerCssClass?this.options.sortHandlerCssClass:"handler")+"'><span>move</span></span>");
      }
      for (j=this.options.images.length-1;j>=0;j--) { //{image , title, cssClass, id}
        img=this.options.images[j];
       if (typeof img.image == 'string' && img.image.indexOf('{') == -1) {
          src_array.concat("<img id='"+this.containerId+"_"+this.autonumber+"_"+(img.id || "image"+j)+"' class='"+this.options.cssClassItem+"-"+(img.cssClass || "image"+j)+"' src='"+img.image+"'");
          if (img.title)
            src_array.concat(" title="+LibJavascript.ToJSValue(img.title));
          src_array.concat(">")
        } else if (typeof img.image == 'object' || img.image.indexOf('{') > -1 ) {
          if ( typeof img.image == 'string') {
            img.image = JSON.parse(img.image);
          }
          src_array.concat("<span id='"+this.containerId+"_"+this.autonumber+"_"+(img.id || "image"+j)+"' class='"+this.options.cssClassItem+"-"+(img.cssClass || "image"+j)+"' style='"+(img.image.color ? 'color:' + img.image.color + ';' : '') +
          (img.image.font ? 'font-family:' + img.image.font + ';' : '') + (img.image.size ? 'font-size:' + img.image.size + 'px;' : '') + ' ' + (img.image.fontWeight ? 'font-weight:' + img.image.fontWeight + ';' : '')+"'");
          if (img.title)
            src_array.concat(" title="+LibJavascript.ToJSValue(img.title));
          src_array.concat(">"+String.fromCharCode(parseInt(img.image.value.substring(3, 7), 16))+"</span>");
        }
      }
      src_array.concat("<p class='"+this.options.cssClassItem+"-name'>"+newItems[i][this.options.aliasName]+"</p>");
      if (this.options.descName)
        src_array.concat("<p class='"+this.options.cssClassItem+"-description'>"+newItems[i][this.options.descName]+"</p>");
      if (this.options.onMoverMouseDown)
        src_array.concat("<span class='"+this.options.cssClassItem+"-mover' title="+LibJavascript.ToJSValue(this.options.moverMsg)+"></span>");

      for (var j=this.options.buttons.length-1;j>=0;j--) {
        src_array.concat("<a class='"+this.options.cssClassItem+"-"+(this.options.buttons[j].cssClass || "button"+j)+"' href='javascript:void(0)' ");
        if (this.options.buttons[j].title)
          src_array.concat("title="+LibJavascript.ToJSValue(this.options.buttons[j].title));
        if (this.options.buttons[j].functionName)
          src_array.concat(" onClick='"+this.options.buttons[j].functionName+"(\""+newItems[i][this.options.idName]+"\""+(level>0 && !Empty(contId) ? ", \"" + contId +"\"": "")+")'");
        src_array.concat(">")
        if( this.options.buttons[j].image )
          src_array.concat("<img src='"+this.options.buttons[j].image+"'>");
        src_array.concat("</a>");
      }
      if (this.options.itemContainsItem && level==0) {
        src_array.concat("<fieldset title="+LibJavascript.ToJSValue(this.options.containerTitle)+" class='fieldset-"+this.options.cssClassContainerItem +"' style='clear: both;"+(newItems[i][this.options.subItemsName].length==0?"display:none;":"")+"'><legend>"+this.options.containerTitle+"</legend>");
        src_array.concat("<div class='"+this.options.cssClassItem+"-"+this.options.cssClassContainerItem +"'>");
        if (newItems[i][this.options.subItemsName].length>0) {
          this.autonumber++;
          src_array.concat(this._getHTMLStringOfItems(newItems[i][this.options.subItemsName],level+1, newItems[i][this.options.idName]));
        }
        src_array.concat("</div>");
        src_array.concat("</fieldset>");
      }
      src_array.concat("</div>");
    }
    return src_array.toString();
  },
  AppendItems:function(newItems, beforeOf) {
    var myDOM = document.createDocumentFragment();
    var myDiv = document.createElement("div");
    myDOM.appendChild(myDiv);
    myDiv.innerHTML = this._getHTMLStringOfItems(newItems);
    var el, mode
    if (beforeOf) {
      el = this.container.getElement('div[name='+beforeOf+']');
      mode = 'before';
    } else {
      el = this.container;
      mode = 'inside';
    }
    while (myDiv.childNodes.length>0) {
      var curElement = myDiv.childNodes[0];
      curElement.inject(el,mode);
    }
  },
  RemoveItems:function(oldItems, contId) {
    var cont;
    if (!Empty(contId)) {
      cont = this.container.getElement("div[name="+contId+"]").getElement("."+this.options.cssClassItem+"-"+this.options.cssClassContainerItem);
    } else {
      cont = this.container;
    }
    for (var i=cont.childNodes.length-1;i>=0;i--) {
      var curEl = cont.childNodes[i];
      var curId = document.id(curEl).get('name');
      var idName = this.options.idName;
      var curIdx = LibJavascript.Array.indexOf(oldItems,curId,function(el) {
        return el[idName]==curId;
      });
      if (curIdx>=0) {
        document.id(curEl).destroy();
        if (!Empty(contId) && cont.childNodes.length==0) {
          cont.getParent().setStyle("display","none");
        }
      }
    }
  },
  AppendItemsInContainer:function(id,newItems,beforeOf) {
    var myDOM = document.createDocumentFragment();
    var myDiv = document.createElement("div");
    myDOM.appendChild(myDiv);
    myDiv.innerHTML = this._getHTMLStringOfItems(newItems,1,id);
    var element0 = this.container.getElement('div[name='+id+']')
    var myRow = element0.getElement("."+this.options.cssClassItem+"-"+this.options.cssClassContainerItem);
    var el, mode
    if (beforeOf) {
      el = myRow.getElement('div[name='+beforeOf+']');
      mode = 'before';
    } else {
      el = myRow;
      mode = 'inside';
    }
    element0.getElement('fieldset').setStyle('display','');
    while (myDiv.childNodes.length>0) {
      var curElement = myDiv.childNodes[0];
      curElement.inject(el,mode);
      // myRow.appendChild(curElement);
      // this._innerSort.addItems(curElement);
      // this._sort.addItems(curElement);
    }
  },
  ReplaceList:function(newItems) {
    LibJavascript.CssClassNameUtils.addClass(this.container,'loading');
    this.container.innerHTML = "";
    this.container.innerHTML = this._getHTMLStringOfItems(newItems);
    LibJavascript.CssClassNameUtils.removeClass(this.container,'loading');
  },
  UpdateList:function(newItems) {
    var container = this.container;
    LibJavascript.CssClassNameUtils.addClass(container,'loading');
    container.innerHTML="";
    container.innerHTML = this._getHTMLStringOfItems(newItems);
    // if (this.options.sortable && this.options.itemContainsItem)
      // this._innerSort.addLists(container.getElements('.'+this.options.cssClassItem+"-"+this.options.cssClassContainerItem));
      // this._sort.addLists(container.getElements('.'+this.options.cssClassItem+"-"+this.options.cssClassContainerItem));

    var _this = this;
    function OnSelectStart(evt){
     if(evt.preventDefault) evt.preventDefault(true);
      evt.returnValue=false
    }
    LibJavascript.Events.addEvent(container,'selectstart',OnSelectStart);
    function GetListElement(el) {
      if (el==container) return null;
      while(el && !LibJavascript.CssClassNameUtils.hasClass(el,_this.options.cssClassItem)) {
        el=el.parentNode;
      }
      return el;
    }
    function GetListElementFromMover(el,callback) {
      if (el==container) return null;
      while(el && !LibJavascript.CssClassNameUtils.hasClass(el,_this.options.cssClassItem+"-mover")) {
        el=el.parentNode;
      }
      var el2 = GetListElement(el);
      callback(el,el2);
    }
    function GetListElementFromHandler(el,callback) {
      if (el==container) return null;
      while(el && !LibJavascript.CssClassNameUtils.hasClass(el,_this.options.cssClassItem+"-"+_this.options.cssClassContainerItem+"-"+(_this.options.sortHandlerCssClass?_this.options.sortHandlerCssClass:"handler"))
                && !LibJavascript.CssClassNameUtils.hasClass(el,_this.options.cssClassItem+"-"+(_this.options.sortHandlerCssClass?_this.options.sortHandlerCssClass:"handler"))
            ) {
        el=el.parentNode;
      }
      var el2 = GetListElement(el);
      callback(el,el2);
    }


    if (_this.options.onMouseOver || _this.options.onMouseOut) {
      var lastElementFocused;
      function mouseMove(evt) {
        if (_this.options.onMouseOver || _this.options.onMouseOut) {
          var el=GetListElement(evt.srcElement || evt.target);
          if (el && el!=lastElementFocused) {
            if (lastElementFocused && _this.options.onMouseOut)
              _this.options.onMouseOut(lastElementFocused,container);
            lastElementFocused=el;
            if (_this.options.onMouseOver)
              _this.options.onMouseOver(lastElementFocused,container);
          }
        }
      }
      LibJavascript.Events.addEvent(container,'mousemove',mouseMove);
    }
    if (_this.options.onClick) {
      function mouseClick(evt) {
        if (_this.options.onClick) {
          var el=GetListElement(evt.srcElement || evt.target);
          if (el)
            _this.options.onClick(el,evt,container);
        }
      }
      LibJavascript.Events.addEvent(container,'click',mouseClick);
    }
    if (_this.options.onDblClick) {
      function mouseDblClick(evt) {
        if (_this.options.onDblClick) {
          var el=GetListElement(evt.srcElement || evt.target);
          if (el)
            _this.options.onDblClick(el,evt,container);
        }
      }
      LibJavascript.Events.addEvent(container,'dblclick',mouseDblClick);
    }
    if (_this.options.onMoverMouseDown || _this.options.sortable) {
      function moverMouseDown(evt) {
        var handler, el, callback;
        if (_this.options.onMoverMouseDown) {
          callback = function(mover, element) {
            handler=mover;
            el=document.id(element);
          }
          GetListElementFromMover(evt.srcElement || evt.target,callback);
          if (el)
            _this.options.onMoverMouseDown(handler,el,evt,container);
        }
        if (_this.options.sortable) {
          callback = function(mover, element) {
            handler=mover;
            el=document.id(element);
          }
          GetListElementFromHandler(evt.srcElement || evt.target,callback);
          if (!_this.options.isSortableElement(el)) return;
          if (el) {

            var clone = el.clone();
            for (var j=_this.options.buttons.length-1;j>=0;j--) {
              clone.getElement("."+_this.options.cssClassItem+"-"+(_this.options.buttons[j].cssClass || "button"+j)).destroy();
            }
            for (j=_this.options.images.length-1;j>=0;j--) {
              clone.getElement("."+_this.options.cssClassItem+"-"+(_this.options.images[j].cssClass || "image"+j)).destroy();
            }
            var c = clone.getElement(".fieldset-"+_this.options.cssClassContainerItem);
            if (c) c.destroy();
            c = clone.getElement("."+_this.options.cssClassItem+"-"+_this.options.cssClassContainerItem+"-"+(_this.options.sortHandlerCssClass?_this.options.sortHandlerCssClass:"handler"));
            if (c) c.destroy();
            c = clone.getElement("."+_this.options.cssClassItem+"-"+(_this.options.sortHandlerCssClass?_this.options.sortHandlerCssClass:"handler"));
            if (c) c.destroy();

            clone.style.cssText = document.defaultView.getComputedStyle(el, null).cssText;
            clone.getElement("."+_this.options.cssClassItem+"-name").style.cssText = document.defaultView.getComputedStyle(el.getElement("."+_this.options.cssClassItem+"-name"), null).cssText;
            clone.getElement("."+_this.options.cssClassItem+"-description").style.cssText = document.defaultView.getComputedStyle(el.getElement("."+_this.options.cssClassItem+"-description"), null).cssText;
            clone.setStyle("position","absolute");
            clone.setStyle("z-index","1000");
            clone.setStyle("width","");
            clone.setStyle("height","");
            clone.inject(document.body);
          		_this.drag = new Drag.Move(clone).addEvents({
                onCancel: function( clone ){
                  clone.destroy();
                  el.style.display='';
                  _this.RemoveDroppableElements()
                },
                onEnter: function(element, droppable){
                  _this.ResponsiveViewOnEnter(droppable);
                },
                onLeave: function(element, droppable){
                  droppable.removeClass('phantom-span_hover')
                },
                onDrop: function(element, droppable/*, event*/){
                  function GetLevel(itm) {
                    if (itm==null) return -1;
                    var prnt = itm.getParent();
                    if (prnt==_this.container) return 0;
                    else return 1;
                  }
                  function GetContainerId(itm) {
                    if (itm==null) return null;
                    var prnt = itm.getParent();
                    if (prnt==_this.container) return null; //se sono nel livello principale non ho subContenitore
                    else {
                      return prnt.getParent().getParent().get("name");
                    }
                  }
                  element.destroy();
                  var validDrop = droppable && droppable.hasClass('phantom-span') && droppable.hasClass('active'),
                      levelStart = 0,
                      levelStop = 0;
                  if (validDrop) {
                    var elem = (droppable?droppable.getParent():null), mode;
                    if (elem && elem.hasClass(_this.options.cssClassItem)) { //nuovo column layer
                      elem = elem.getElement('.'+_this.options.cssClassItem+"-"+_this.options.cssClassContainerItem);
                      elem.getParent().style.display='';
                      mode = "bottom";
                    } else if (elem && elem.childNodes.length>1) {
                      if (droppable.getPrevious()) {
                        elem = droppable.getPrevious();
                        mode = "after";
                      } else {
                        elem = droppable.getNext();
                        mode = "before";
                      }
                    }
                    levelStart = GetLevel(el);
                    levelStop = GetLevel(droppable);
                  }
                  el.style.display='';
                  _this.RemoveDroppableElements()
                  var btn, myId, contId, j;
                  if (validDrop) {
                    var oldCont = GetContainerId(el);
                    if (levelStart == levelStop) {//stesso livello, basta copiare
                      el.inject(elem, mode);
                      if (levelStop==1) { //bisogna cambiare il contenitore nelle chiamate
                        myId = el.get("name"),
                            contId = GetContainerId(el);
                        for (j=_this.options.buttons.length-1;j>=0;j--) {
                          btn = el.getElement("."+_this.options.cssClassItem+"-"+(_this.options.buttons[j].cssClass || "button"+j));
                          btn.set("onClick", _this.options.buttons[j].functionName+"(\""+ myId +"\",\""+ contId +"\")")
                        }
                      }
                    } else if (levelStart>levelStop) { //bisogna aggiungere subContainer
                      if (_this.options.itemContainsItem) {
                        var newFielset = new Element("fieldset").set("title",_this.options.containerTitle).set("class","fieldset-"+_this.options.cssClassContainerItem).setStyles({"clear":"both","display":"none"});
                        new Element("legend").set("text",_this.options.containerTitle).inject(newFielset);
                        new Element("div").set("class",_this.options.cssClassItem+"-"+_this.options.cssClassContainerItem).inject(newFielset);
                        newFielset.inject(el);
                        el.inject(elem, mode);
                        myId = el.get("name");
                        for (j=_this.options.buttons.length-1;j>=0;j--) {
                          btn = el.getElement("."+_this.options.cssClassItem+"-"+(_this.options.buttons[j].cssClass || "button"+j));
                          btn.set("onClick", _this.options.buttons[j].functionName+"(\""+ myId +"\")")
                        }
                      }
                    } else if (levelStart<levelStop) {// bisogna togliere subContainer e spalmare i contenuti
                      var oldCnt = el.getElement("."+_this.options.cssClassItem+"-"+_this.options.cssClassContainerItem).dispose();
                      el.getElement("fieldset").destroy();
                      el.inject(elem, mode);
                      myId = el.get("name"),
                          contId = GetContainerId(el);
                      for (j=_this.options.buttons.length-1;j>=0;j--) {
                        btn = el.getElement("."+_this.options.cssClassItem+"-"+(_this.options.buttons[j].cssClass || "button"+j));
                        btn.set("onClick", _this.options.buttons[j].functionName+"(\""+ myId +"\",\""+ contId +"\")")
                      }
                      var myel = el;

                      oldCnt.getChildren().each(function(child) {
                        if (myel.nextSibling)
                          child.inject(myel,"after");
                        else
                          myel.parentNode.appendChild(child);
                        var myId = child.get("name");
                        for (var j=_this.options.buttons.length-1;j>=0;j--) {
                          var btn = child.getElement("."+_this.options.cssClassItem+"-"+(_this.options.buttons[j].cssClass || "button"+j));
                          btn.set("onClick", _this.options.buttons[j].functionName+"(\""+ myId +"\",\""+ contId +"\")")
                        }
                        myel = child;
                      });

                    }
                    var newCont = GetContainerId(el);
                    _this.options.onMove(el.get("name"), oldCont, newCont, elem.get("name"),mode);
                  }
                  if (_this.container.scroller)
                    _this.container.scroller.stop();
                  _this.HideEmptyContainers();
                  clone.destroy();
                },
                onBeforeStart : function() {
                  el.style.display='none';
                  _this.MakeDroppableElements(el);
                  _this.drag.droppables = $$(".droppableItem");
                  var mousePos = new DOMEvent(evt).client;
                  clone.setStyles({top:mousePos.y,left:mousePos.x});
                },
                onStart : function() {
                  if (!_this.container.scroller) {
                    _this.container.scroller=new Scroller(_this.container);
                  }
                  _this.container.scroller.start();
               }
              });

              _this.drag.start(new DOMEvent(evt));
         }

        }
      }
      LibJavascript.Events.addEvent(container,'mousedown',moverMouseDown);
    }
    LibJavascript.CssClassNameUtils.removeClass(container,'loading');
  },
  UpdateItem : function (id, contId, obj) {
    var el = this.container.getElement('div[name='+id+']');
    el.getElement("."+this.options.cssClassItem+"-name").set("text", obj[this.options.aliasName]);
    el.getElement("."+this.options.cssClassItem+"-description").set("text", obj[this.options.descName]);
  },
  Empty : function() {
    document.id(this.container).getChildren().each(function(el) {
      el.destroy();
    });
  },
  ShowAllContainers : function(exlcudeParentId) {
    this.container.getElements("fieldset").each(function(fldset) {
      if (Empty(exlcudeParentId) || fldset.getParent().get("name")!=exlcudeParentId)
        fldset.setStyle("display","");
    });
  },
  HideEmptyContainers : function() {
    var _this=this;
    this.container.getElements("fieldset").each(function(fldset) {
      if (fldset.getElement("."+_this.options.cssClassItem+"-"+_this.options.cssClassContainerItem).childNodes.length==0)
        fldset.setStyle("display","none");
    });
  },
  MakeDroppableElements : function(exclude) {
    var _this=this;
    function FillDroppables(cnt, exclude) {
      cnt.getChildren().forEach(function(child) {
        if (!LibJavascript.CssClassNameUtils.hasClass(child,"phantom-span") ) {
          var phantom = new Element("span").addClass("phantom-span").addClass('droppableItem');
          phantom.inject(child,'before');
          if (child!=exclude) {
            child.addClass('droppableItem');
          }
        }
      });
      var lastChild = cnt.getLast();
      if (lastChild &&  lastChild!=exclude && !lastChild.hasClass("phantom-span")) {
        var phantom = new Element("span").addClass("phantom-span").addClass('droppableItem');
        phantom.inject(cnt.childNodes[cnt.childNodes.length-1],'after');
      }
    }
    FillDroppables(this.container, exclude);
    this.container.getElements("."+this.options.cssClassItem+"-"+this.options.cssClassContainerItem).each(function(cnt) {
      var prnts = cnt.getParents()
      if (prnts.indexOf(exclude)==-1) {
        if (cnt.childNodes.length>0) {
          FillDroppables(cnt, exclude);
          cnt.getParent().addClass('droppableItem');
        } else {
          var parentItem = prnts.filter('.'+_this.options.cssClassItem);
          if (parentItem.length==1) {
            var phantom = new Element("span").addClass(_this.options.cssClassContainerItem+"-element").addClass('droppableItem').addClass('phantom-span');
            phantom.set('html', 'Column<br>layer');
            phantom.setStyle('align','center')
            phantom.inject(parentItem[0],'inside');
          }
        }
      }
    });
  },
  RemoveDroppableElements : function() {
    this.container.getElements('.phantom-span').each(function(itm) {
      itm.destroy();
    });
    this.container.getElements('.droppableItem').forEach(function(itm) {
      itm.removeClass('droppableItem');
    });
  },
  ResponsiveViewOnEnter : function(droppable) {
    var phantom;
    if (droppable.hasClass(this.options.cssClassItem)) {
      this.container.getElements('.phantom-span.active').forEach(function(ps) {
        ps.removeClass('active');
      });
      phantom = droppable.getPrevious();
      if (phantom && phantom.hasClass('phantom-span'))
        phantom.addClass('active');
      phantom = droppable.getNext();
      if (phantom && phantom.hasClass('phantom-span'))
        phantom.addClass('active');
      phantom = droppable.getChildren('.phantom-span');
      phantom.each(function(phantom) {
        phantom.addClass('active');
      });
    } else if (droppable.hasClass('phantom-span')) {
      droppable.addClass('phantom-span_hover')
    } else if (droppable.hasClass('fieldset-'+this.options.cssClassContainerItem)) {
      //quando entro in un column layer visibile visualizzo il primo droppable disponibile
      phantom = droppable.getElement('.phantom-span.droppableItem');
      if (phantom) {
        phantom.addClass('active');
      }
    }
  }
});
