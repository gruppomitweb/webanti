/*  exported standalone multipleSelection dragToolbar SetOnEditProp CopyPaste
    manageItems setProperties setProperties_ beginDragSelection dragShadow noDefaultDrag
    editPortlet OpenWindow CloseDialogs fade setFading disableSelect enableSelect
    addRulersLine togglePreview previewConfirmParms disableAnchor getDocHeight PickItems
 */
//Movimento Tool bar
var container_selection = new Object(); //oggetto che circonda tutti gli elementi selezionati
var not_selected = new Array(); //array di itemHTML non selezionati (� l'array dei loro indici)
var undoSequence=new Array(); //array contenente tutti gli oggetti di Undo
var dragObj=new Object();
dragObj.zOrder=1000;
var standalone=false;
var tool=null;
var historyStack=null;
var multipleSelection = false;
var align_delta = 5; //indica la distanza massima tra due oggetti  per far comparire le linee di allineamento
var distance_delta = 10; //indica la distanza preferita tra gli oggetti del disegnatore (verra' impostata automaticamente dal disegnatore nel caso di vicinanza < di distance_sensor e >= di align delta
var distance_sensor = 20; //indica la distanza entro la quale due oggetii si 'attraggono'
var canAlign = false;
var clVRRulersLib=null;
var clHRRulersLib=null;
var notimooManager;
var undoItemsMoved=new Array();
var lockItems=false;//Blocca il move dei ctrls
container_selection.e = new Array();

var container_align_h1,container_align_h2,container_align_v1,container_align_v2,container_align_mh,container_align_mv,distance_align_h1,distance_align_h2,distance_align_v1,distance_align_v2,container_distance_v1,container_distance_v2,container_distance_h1,container_distance_h2,shadow_selection;// eslint-disable-line max-len
window.addEvent('domready',function(){
  container_selection = new Element ('div',{id:'container_selection'});
  notimooManager = new Notimoo({});
  container_align_h1 =  new Element ('div',{id:'container_align_h1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  container_align_h2 =  new Element ('div',{id:'container_align_h2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  container_align_v1= new Element ('div',{id:'container_align_v1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  container_align_v2 = new Element ('div',{id:'container_align_v2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  container_align_mh = new Element ('div',{id:'container_align_mh'}).setStyles({'position':'absolute','z-index':4,'background':'transparent url(../portalstudio/images/align_h_dotted.png) repeat-y','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  container_align_mv = new Element ('div',{id:'container_align_mv'}).setStyles({'position':'absolute','z-index':4,'background':'transparent url(../portalstudio/images/align_v_dotted.png) repeat-x','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  distance_align_h1 =  new Element ('div',{id:'distance_align_h1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  distance_align_h2 =  new Element ('div',{id:'distance_align_h2'}).setStyles({'position':'absolute','z-index':4, 'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  distance_align_v1= new Element ('div',{id:'distance_align_v1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  distance_align_v2 = new Element ('div',{id:'distance_align_v2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  container_distance_v1 = new Element('div',{id:'container_distance_v1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  container_distance_v2 = new Element('div',{id:'container_distance_v2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  container_distance_h1 = new Element('div',{id:'container_distance_h1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  container_distance_h2 = new Element('div',{id:'container_distance_h2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  shadow_selection = new Element ('div',{id:'shadow_selection'}).setStyles({'z-index':4}).grab(new Element('p')).inject(container_selection);
  if(Ctrl('backcanvas'))
    container_selection.inject(Ctrl('backcanvas'))
  else
    setTimeout(function(){container_selection.inject(Ctrl('backcanvas'))},300)
 })

PSAlert.init(window, '');

function dragToolbar(e,obj) {
  e = (e) ? e : window.event;
  obj = Ctrl(obj);
  if(obj) dragObj.css = obj.style;
  if(!e || !dragObj.css) return;
  //Save mousedown location
  //GM commentato
  /*dragObj.downX = (e.layerX) ? e.layerX : (e.offsetX) ? e.offsetX : 0;
  dragObj.downY = (e.layerY) ? e.layerY : (e.offsetY) ? e.offsetY : 0;*/
  //GM
  //GM - IE9 e.layerY e e.layerX hanno valori non coerenti e spesso negativi - usargli solo se non esiste offsetX e offsetY
  dragObj.downX = (e.offsetX)? e.offsetX: (e.layerX)? e.layerX: 0;//(e.layerX)? e.layerX: (e.offsetX)? e.offsetX: 0;
  dragObj.downY = (e.offsetY)? e.offsetY: (e.layerY)? e.layerY: 0;//(e.layerY)? e.layerY: (e.offsetY)? e.offsetY: 0;
  //GM
  if(arguments.length > 2 && document.all){
    dragObj.downX = dragObj.downX + arguments[2];
    dragObj.downY = dragObj.downY + arguments[2];
  }
  //Bring to top of stack
  dragObj.css.zIndex = ++dragObj.zOrder;
  document.id(document).addEvent("mousemove",dragStart,true);
  document.id(document).addEvent("mouseup",dragEnd,true);
  (new DOMEvent(e)).stop();
  return false;
}

function dragStart(e) {
  e = (e)? e: window.event;
  var x = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX + document.documentElement.scrollLeft + document.body.scrollLeft : 0;
  var y = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY + document.documentElement.scrollTop + document.body.scrollTop : 0;
  //Move drag element by the amount the cursor has moved.
  var newX=(x-dragObj.downX);
  var newY=(y-dragObj.downY);
  if(newX<0) newX=0;
  if(newY<0) newY=0;
  dragObj.css.left=newX+"px";
  dragObj.css.top=newY+"px";
  if(e.preventDefault) e.preventDefault();
  else return false;
}

function dragEnd(/*e*/) {
  //Stop capturing mousemove and mouseup events.
  document.id(document).removeEvent("mousemove",dragStart,true);
  document.id(document).removeEvent("mouseup",dragEnd,true)
}
var OnEditProp=false;
function SetOnEditProp(b){
  OnEditProp=b;
}
var deftmp="";
function CopyPaste(a,b) { //Usata in disegnatore standalone
  notimooManager.show({
    title:'Notification message',
    message:  (b) ? 'Item/s has been cutted' : ((!a) ? 'Item/s has been pasted' : 'Item/s has been copied'),
    sticky : false,
    visibleTime:1000,
    width:200,
    height:40
  });
  if(a){
    if (window.Copy) deftmp=Copy(b);
  }else{
    if (window.Paste) Paste(deftmp);
  }
}
function resetFormOperation(){
  document.body.style.cursor="default";
  type="Form";
  selectForm();
}
function manageItems(e,notResize){
  var domevt = new DOMEvent(e);
  if(!OnEditProp){
    var managed = false;
    var target = GetEventSrcElement(e);
    if (domevt.code==8 && target && target.tagName.toLowerCase() != "textarea") managed=true;
    else if(domevt.code==27) //ESC
      resetFormOperation();
    else if(domevt.control && domevt.code==86) { (parent.CopyPaste?parent.CopyPaste(false):(window.CopyPaste?window.CopyPaste(false):void(0))); managed=true; }//CTRL-V
    else if (domevt.control && domevt.code==90) { Undo(); managed=true; }//CTRL-Z
    else if (domevt.control && domevt.code==89) { Redo(); managed=true; }//CTRL-Y
    else if (domevt.control && domevt.code==83) { (parent.saveTool?parent.saveTool():(window.save?save():void(0))); managed=true; }//CTRL-S
    else if(!Empty(mainitem)){
      if (domevt.control && domevt.code==67) { (parent.CopyPaste?parent.CopyPaste(true,false):(window.CopyPaste?window.CopyPaste(true,false):void(0))); managed=true; }//CTRL-C
      else if (domevt.control && domevt.code==88) { (parent.CopyPaste?parent.CopyPaste(true,true):(window.CopyPaste?window.CopyPaste(true,true):void(0))); managed=true; }//CTRL-X
      else {
        switch(domevt.code){
          case 46 : //DEL
			// gestionce canc su elemento missing
			var itm = itemsHTML[getItemsHTMLIndex(Strtran(mainitem.id,"shadow","item"))];
      var msg;
      if(itm.isMissing){
				var model =	getModelFromZone(Strtran(itm.zone,"content","")).model;
				msg = "Do you want to remove whole "
				if(model=="table")
					msg+="column";
				else
					msg+="row";
				msg+="?";
				showMessageConfirm(msg,"deletemissing",{alias:itm.fieldDet.alias, zone:Strtran(itm.zone,"content","")});
			}
			else{
				msg = 'Are you sure to remove elements? Only selected elements -not others related- will be removed!';
				showMessageConfirm(msg,"delete");
			}
            managed=true;
            break;
          case 38 : // UP
            deltax=0
            deltay=0
            newy=mainitem.offsetTop
            moveItems("up",e,notResize)
            managed=true;
          break
          case 39 : // RIGHT
            deltax=0
            deltay=0
            moveItems("right",e,notResize)
            managed=true;
          break
          case 40 : // DOWN
            deltax=0
            deltay=0
            moveItems("down",e,notResize)
            managed=true;
          break
          case 37 : // LEFT
            deltax=0
            deltay=0
            moveItems("left",e,notResize)
            managed=true;
          break
        }
      }
      EmptyRefLines();
      addRulersLines();
    }
    if (managed) domevt.stop();
  } else { //si puo' salvare sempre anche dentro agli input!!
    if (domevt.control && domevt.code==83) { (parent.saveTool?parent.saveTool():(window.save?save():void(0))); domevt.stop(); }//CTRL-S
  }
}

var i_i=0
function setProperties(e){
  if(!OnEditProp){
    i_i++
    if(index!=null)
      switch(GetKeyCode(e)){
        case 38 : case 39 : case 40 : case 37 :
          setTimeout("setProperties_("+i_i+")",200)
        break
      }
  }
}
function setProperties_(i){
  if(i==i_i){
    Properties()
    if(typeof(drawLinks)!='undefined'){drawLinks(true);moveLinks();}
  }
}
function beginDragSelection(e){
  if(typeof(hideProperties)!='undefined') hideProperties('properties')
  var dragstyle=Ctrl("drag").style
  var canvas=Ctrl("canvas")
  e = (e) ? e : window.event;
  var x = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
  var y = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
  if (document.all) { x += window.pageXOffset; y += window.pageYOffset; }

  x = x - (parseInt(Ctrl("backcanvas").offsetLeft) + parseInt(Ctrl("canvas").offsetLeft)) + parseInt(Ctrl("backcanvas").scrollLeft+document.body.scrollLeft)
  y = y - (parseInt(Ctrl("backcanvas").offsetTop) + parseInt(Ctrl("canvas").offsetTop)) + parseInt(Ctrl("backcanvas").scrollTop+document.body.scrollTop)
  dragstartx=x
  dragstarty=y
  // mostra il rettangolo di drag
  dragstyle.visibility="visible"
  dragstyle.top=y+'px';
  dragstyle.left=x+'px';
  dragstyle.width=0
  dragstyle.height=0
  // installa il gestore del mousemove
  canvas.onmousemove=continueDragSelection
  canvas.onmouseup=endDragSelection
  // blocca la propagazione
  cancelEvent(e)
}
function noDefaultDrag(e){
  // blocca la propagazione
  e = (e) ? e : window.event;
  if(e.preventDefault)e.preventDefault()
  e.cancelBubble = true;
  if (e.stopPropagation) e.stopPropagation();
  e.returnValue=false
}
function continueDragSelection(e){
  var dragstyle=Ctrl("drag").style
  e = (e) ? e : window.event;
  var x = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
  var y = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
  x = parseInt(x) - (parseInt(Ctrl("backcanvas").offsetLeft) + parseInt(Ctrl("canvas").offsetLeft)) + parseInt(Ctrl("backcanvas").scrollLeft+parseInt(Ctrl('canvas').scrollLeft))
  y = parseInt(y) - (parseInt(Ctrl("backcanvas").offsetTop) + parseInt(Ctrl("canvas").offsetTop)) + parseInt(Ctrl("backcanvas").scrollTop+parseInt(Ctrl('canvas').scrollTop))
  // muove il rettangolo di drag
  if (x<dragstartx ){
    dragstyle.left=x+'px';
    dragstyle.width=dragstartx-x+'px';
  }else{
    dragstyle.left=dragstartx+'px';
    dragstyle.width=x-dragstartx+'px';
  }
  if (y<dragstarty){
    dragstyle.top=y+'px';
    dragstyle.height=dragstarty-y+'px';
  } else {
    dragstyle.top=dragstarty+'px';
    dragstyle.height=y-dragstarty+'px';
  }
  // blocca la propagazione
  cancelEvent(e)
}
function endDragSelection(e){
  var drag=Ctrl("drag")
  if (drag.offsetWidth <= 2 && drag.offsetHeight <= 2){
    selectForm()
  } else {
    findDragItems(e,drag.offsetTop,drag.offsetLeft,drag.offsetWidth,drag.offsetHeight)
  }
  //seleziona l elemento se ci sono elementi nell'area scelta

  for (var i=0;i<itemsHTML.length;i++){
    if(itemsHTML[i].shadow!=""){
      selectItem(Ctrl(itemsHTML[i].shadow))
      break
    }
  }
  // nasconde il rettangolo di drag
  drag.style.visibility="hidden"
  Ctrl("canvas").onmousemove=null
  Ctrl("canvas").onmouseup=null
  if(typeof(showProperties)!='undefined') showProperties('properties')
}
function findDragItems(e,y,x,w,h){
  // trova se un elemento e' nel  rettangolo di selezione
  //CREA IL RETANGOLO DI SELEZIONE DI DIMENSIONI MINIME CHE CONTIENE TUTTI GLI OGGETTI SELEZIONATI
  multipleSelection = true;
  e = (e) ? e : window.event;
  var str="",itm,itmobj;
  not_selected = [];
  // se non premuto lo shift
  if(e.shiftKey==false && !ismobile){
    removeAllHandlers()
  }
  if(itemsHTML.length > 0){
    //cerca il primo item attivo
    container_selection.e = new Array();
    container_selection.l = Ctrl("backcanvas").offsetWidth;
    container_selection.t = Ctrl("backcanvas").offsetHeight;
    container_selection.b =0;
    container_selection.r=0;
    for(var i=0; i<itemsHTML.length; i++){
      itmobj=itemsHTML[i];
      itm = document.getElementById(itmobj.id)
        if(itm && itmobj.type!='Link' && itmobj.id.indexOf("item")>=0){
          if(itm.style.display!='none') //esclude gli items di altre pagine
            if(itm.onclick && (itm.offsetTop>y &&  itm.offsetLeft>x && itm.offsetTop+itm.offsetHeight<y+h && itm.offsetLeft+itm.offsetWidth<x+w)){
              if(Empty(itmobj.shadow)){
                str+=addHandlers(itmobj.id.substr(4));
                // aggiunge l'item selezionato all array se non presente
                itmobj.shadow='shadow'+itmobj.id.substr(4);
              }
              //creazione del rettangolo contenitore
              if(itm.offsetLeft < container_selection.l)
                container_selection.l= itm.offsetLeft
              if(itm.offsetTop < container_selection.t)
                container_selection.t= itm.offsetTop
              if((itm.offsetTop+itm.offsetHeight) > container_selection.b)
                container_selection.b= (itm.offsetTop+itm.offsetHeight)
              if((itm.offsetLeft+itm.offsetWidth) > container_selection.r)
                container_selection.r= (itm.offsetLeft+itm.offsetWidth)
              container_selection.e.push(i)
            }else{
              if(!itmobj.hidden){
				if(isScrolledIntoView(Ctrl(itemsHTML[i].id))) not_selected.push(i);
              }
            }
        }
    }
    container_selection.w = container_selection.r - container_selection.l;
    container_selection.h = container_selection.b-container_selection.t;
  }

 Ctrl("canvashandlers").innerHTML=Ctrl("canvashandlers").innerHTML+str;

}
function selectForm(){
  removeAllHandlers()
  FormProperties()
}
function removeAllHandlers(){
  // svuota l'array contenente gli elementi selezionati precedentemente
  index=null;mainitem=null;
  for(var i=0; i<itemsHTML.length; i++){
    itemsHTML[i].shadow=""
  }
  Ctrl("canvashandlers").innerHTML=""
  if(!Empty(newPropObj))newPropObj.HideProperties();
  container_selection.e = [];
  EmptyRefLines();
}
function addHandlers(itmIdx){
  var itm=Ctrl("item"+itmIdx)
  var y=itm.offsetTop
  var x=itm.offsetLeft
  var w=itm.offsetWidth
  var h=itm.offsetHeight
  var str=""
  str+=addHandler(x-3,y-3,itmIdx,0)
  str+=addHandler(x-3+w,y-3,itmIdx,1)
  str+=addHandler(x-3+w,y-3+h,itmIdx,2)
  str+=addHandler(x-3,y-3+h,itmIdx,3)
  // aggiunge il div shadow+n della grandezza dell item per lo spostamento
   // document.getElementById('bn').innerHTML =document.getElementById('bn').innerHTML + ' shadow h '+h+' w  '+w;
  str+="<div  id='shadow"+itmIdx+"' class='shadow' style='position:absolute;top:"+y+"px;left:"+x+"px;width:"+w+"px;height:"+h+"px;' onmousedown='this.focus();dragShadow(event);' ondblclick='editItemEvent(event,this)'>";
  // if(navigator.appName.indexOf("Microsoft")>-1)
    // str+="<img id='"+itmIdx+"' src='images/trasparent.gif' style='width:100%;height:100%;'>";
  // else
    str+="&nbsp;";
  str+="</div>";
  return str;
}

function addHandler(x,y,itmIdx,corner,fixed){
  var cursorStyle = ""
  var moveControl = ""
  //itemresizable = (itemsHTML[index].type != "SPLinker" && itemsHTML[index].type != "SQLDataobj")
  if (!fixed){
    if (corner == 0 || corner == 2)
      cursorStyle = "cursor:nw-resize;"
    else
      cursorStyle = "cursor:ne-resize;"
    moveControl = " onmousedown='beginDragHandler(event,"+itmIdx+","+corner+")'"
  }
  return "<div id='handler"+itmIdx+"_"+corner+"' style='"+cursorStyle+"z-index:5;position:absolute;top:"+y+"px;left:"+x+"px;width:7px;height:7px;background:url(../visualweb/images/handler_on.png) no-repeat;'" + moveControl + "></div>"
}
// Crea la shadow dell'elemento per indicare che � in corso l'allineamento con quell'elemento
function addShadowAlign(x,y,w,h,i,type){
     // document.getElementById('bn').innerHTML =document.getElementById('bn').innerHTML + ' shadow x '+x+' y  '+y+' w '+w+' h '+h;

  var str="<div  id='shadow_selected_"+i+"' class='shadow_selected_"+type+"' style='top:"+y+"px;left:"+x+"px;width:"+w+"px;height:"+h+"px;'></div>"
  return str;
}

// definisce l'elemento principale mainitem
function selectItem(itm){
  SetOnEditProp(false);
  var selecteditem,n,i
  mainitem=itm
  selecteditem=mainitem.id.substr(6);
  if(index==selecteditem)return;
  index=null;
  // trova lindice del mainitem
  for(i=0;i<itemsHTML.length && index==null;i++){
    if (itemsHTML[i].shadow==mainitem.id)
      index=i
  }
  Ctrl("handler"+selecteditem+"_0").style.backgroundImage="url(../visualweb/images/handler_on.png)"
  Ctrl("handler"+selecteditem+"_1").style.backgroundImage="url(../visualweb/images/handler_on.png)"
  Ctrl("handler"+selecteditem+"_2").style.backgroundImage="url(../visualweb/images/handler_on.png)"
  Ctrl("handler"+selecteditem+"_3").style.backgroundImage="url(../visualweb/images/handler_on.png)"
  for (var p=0;p<itemsHTML.length;p++){
    if(itemsHTML[p].shadow!=mainitem.id && itemsHTML[p].shadow!="" && Ctrl(itemsHTML[p].shadow)){
      // elemento ennesimo nell'array
      n=Ctrl(itemsHTML[p].shadow).id.substr(6)
      Ctrl("handler"+n+"_0").style.backgroundImage="url(../visualweb/images/handler_off.png)"
      Ctrl("handler"+n+"_1").style.backgroundImage="url(../visualweb/images/handler_off.png)"
      Ctrl("handler"+n+"_2").style.backgroundImage="url(../visualweb/images/handler_off.png)"
      Ctrl("handler"+n+"_3").style.backgroundImage="url(../visualweb/images/handler_off.png)"
	  if(container_selection.e.indexOf(p)<0) container_selection.e.push(p)
    }
  }

  Properties()
  EmptyRefLines();
  addRulersLines();
}
function cancelEvent(e) {
  e.cancelBubble=true
  if (e.stopPropagation) e.stopPropagation();
  //e.returnValue=false
}

var isMove = false;
function dragShadow(e) { //REDIFINED
  if(typeof(hideProperties)!='undefined') hideProperties('properties')
  // seleziona l'elemento
  e = (e) ? e : window.event;
  if(e!=null && e.shiftKey==true){
	if(GetEventSrcElement(e).id.substr(0,1)=='s'){
		unSelectItem(GetEventSrcElement(e))
	  }else{
		unSelectItem(Ctrl("shadow"+GetEventSrcElement(e).id))
	  }
  }
  else {
	  if(GetEventSrcElement(e).id.substr(0,1)=='s'){
		selectItem(GetEventSrcElement(e))
	  }else{
		selectItem(Ctrl("shadow"+GetEventSrcElement(e).id))
	  }
  }

  if(lockItems){
    e.cancelBubble = true;
    if (e.stopPropagation) e.stopPropagation();
    e.returnValue=false
    return;
  }

  if(mainitem!=null){
	if(Empty(e.targetTouches)){
		deltax = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
		deltay = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
	}
	else{
		deltax = (e.targetTouches[0].pageX)? e.targetTouches[0].pageX: (e.targetTouches[0].clientX)? e.targetTouches[0].clientX: 0;
		deltay = (e.targetTouches[0].pageY)? e.targetTouches[0].pageY: (e.targetTouches[0].clientY)? e.targetTouches[0].clientY: 0;
	}
	deltax = deltax - parseInt(Ctrl("backcanvas").offsetLeft) - mainitem.offsetLeft + Ctrl("backcanvas").scrollLeft
	deltay = deltay - parseInt(Ctrl("backcanvas").offsetTop) - mainitem.offsetTop + Ctrl("backcanvas").scrollTop
	// l'id � shadown+n e quello dell item � item+n
	mainitem.onmouseup=function(){Ctrl("canvas").onmousemove=null;mainitem.onmouseup=null;if(typeof(showProperties)!='undefined') showProperties('properties')}
	if(Empty(e.targetTouches)){
		Ctrl("canvas").onmousemove = moveShadow;
		Ctrl("canvas").onmouseup=setShadow;
	}
	else{
		GetEventSrcElement(e).addEventListener("touchmove",moveShadow);
		GetEventSrcElement(e).addEventListener("touchend",setShadow);
	}
  }
  m_bUpdated=true
  e.cancelBubble = true;
  if (e.stopPropagation) e.stopPropagation();
  e.returnValue=false;
  if(window.SaveItemStatus) window.SaveItemStatus();	// salvo le posizioni iniziali
}

function moveShadow(e){
  isMove = true;
  var elementShadow
  e = (e) ? e : window.event;
  newx = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
  newy = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
  newx = newx - parseInt(Ctrl("backcanvas").offsetLeft) + Ctrl("backcanvas").scrollLeft
  newy = newy - parseInt(Ctrl("backcanvas").offsetTop) + Ctrl("backcanvas").scrollTop
  var dx=newx-deltax-mainitem.offsetLeft
  var dy=newy-deltay-mainitem.offsetTop
  var delta = new Array();
  delta[0] = dx;
  delta[1] = dy;
  delta[2] = dx;
  delta[3] = dy;
  if(canAlign) delta = drawSnap(delta,false);
    for (var p=0;p<itemsHTML.length;p++) {
      if(itemsHTML[p].shadow != "" && Ctrl(itemsHTML[p].shadow)){
        elementShadow=Ctrl(itemsHTML[p].shadow)
        //MG 20120302 beg
        var ret = true;
        if(window.ValidMove) {
          ret = window.ValidMove(elementShadow.offsetLeft+delta[0], elementShadow.offsetTop+delta[1], elementShadow.offsetWidth, elementShadow.offsetHeight,itemsHTML[p].id, itemsHTML[p])// eslint-disable-line max-len
        }
        if(ret==true){
          elementShadow.style.left = (elementShadow.offsetLeft+delta[0])+'px';
          elementShadow.style.top = (elementShadow.offsetTop+delta[1])+'px';
        }
        //MG 20120302 beg
        addRulersLines();
        var xfunction
        var yfunction
        if(itemsHTML[p].objClass.newProperties){
          var c = 0;
          for(var i in itemsHTML[p].objClass.newProperties){
            var tab = itemsHTML[p].objClass.newProperties[i];
            for(var ii = 0; ii<tab.length && c<2; ii++){
              if(tab[ii].propID=='x'){
                xfunction = tab[ii].convertFunc;
                c++;
              }
              if(tab[ii].propID=='y'){
                yfunction = tab[ii].convertFunc;
                c++;
              }
            }
          }
        }
        var calcx=parseInt(elementShadow.offsetLeft);
        var calcy=parseInt(elementShadow.offsetTop);
        if(typeof(xfunction)!='undefined')
          eval("calcx="+xfunction+"(elementShadow.style.left)")
        if(typeof(yfunction)!='undefined')
          eval("calcy="+yfunction+"(calcy)")
        var strp = "x="+(calcx)+"&nbsp;"+"y="+(calcy)
        elementShadow.innerHTML="<div style='position:relative;left:5px;top:-12px;white-space: nowrap;' ondragstart='noDefaultDrag(event)' onselectstart='noDefaultDrag(event)'>"+strp+"</div>"
	  }
    }
}
//funzione che disegna gli allineamenti e le ombre degli oggetti selezionati e ritorna un array con le posizioni ricalcolate
function drawSnap(delta,resizeMode,light){
  var dl = delta[0];  //spostamento del left
  var dt = delta[1]; //spostamento del top
  var dr = delta[2]; //spostamento del right
  var db = delta[3]; //spostamento del bottom
  var shadow_selected = ""
  var l_c = container_selection.l +dl
  var t_c =container_selection.t +dt
  var r_c  = container_selection.r +dr
  var b_c = container_selection.b +db
  var h_c =container_selection.h -  (dt - db)
  var w_c =container_selection.w -(dl - dr)
  var mh_c = l_c  + (Math.round(w_c/2));
  var mv_c = t_c + (Math.round(h_c / 2));
  var v1_mod = false,
    v2_mod = false,
    h1_mod = false,
    h2_mod = false,
    dv1_mod = false,
    dv2_mod = false,
    dh1_mod = false,
    dh2_mod = false,
    mh_mod = false,
    mv_mod= false,
    isAlignWidth = false,
    isNearWidth = false;
  var isResizeMode = resizeMode;
  var  tmp_sel,l_o,t_o,r_o,b_o,h_o,w_o,ddl,ddt,ddr,ddb;
  if(Empty(light)) light = false;
  for(var i=0;i<not_selected.length;i++){
    tmp_sel = itemsHTML[not_selected[i]]
	if(viewMode!=designView){
		l_o = getX(Ctrl(tmp_sel.id))- Ctrl("backcanvas").offsetLeft;
		t_o = getY(Ctrl(tmp_sel.id))- Ctrl("backcanvas").offsetTop;
		h_o = parseInt(tmp_sel.h)
		w_o = parseInt(tmp_sel.w)
	}
	else{
		l_o = parseInt(tmp_sel.x)
		t_o = parseInt(tmp_sel.y)
		h_o = parseInt(tmp_sel.h)
		w_o = parseInt(tmp_sel.w)
	}
    r_o = l_o + w_o;
    b_o = t_o + h_o;
    var mh_o= l_o  + (Math.round(w_o/2));
    var mv_o =t_o + (Math.round(h_o/ 2));
    ddl= 0;
    ddt = 0;
    ddr = 0;
    ddb = 0;
    if(Math.abs( l_c - l_o) < align_delta &&  (!isResizeMode || dl != 0) ){ //se c'� una corrispondenza a sinistra con la sinistra dell'oggetto
      container_align_v1.style.top = (t_c < t_o ? t_c : t_o)+'px';
      container_align_v1.style.left = l_o+'px';
      container_align_v1.style.height = (Math.abs(  t_o - t_c)+h_c)+'px';
      v1_mod = true;
      isAlignWidth =true;
      ddl= ( l_c - l_o)
      l_c = l_c -ddl;
      if(! isResizeMode) r_c = r_c - ddl;
    }else{
      if(!v1_mod)container_align_v1.style.height = 0;
    }
    if(Math.abs( r_c - l_o) < align_delta &&  (!isResizeMode || dr != 0) ){ //se c'� una corrispondenza a destra con la sinistra dell'oggetto
      container_align_v2.style.top = (t_c < t_o ? t_c : t_o)+'px';
      container_align_v2.style.left = l_o +'px';
      container_align_v2.style.height = (Math.abs(  t_o - t_c)+h_c)+'px';
      v2_mod = true;
      isAlignWidth =true;
      ddr=  ( r_c - l_o)
      if(! isResizeMode) l_c = l_c -ddr;
      r_c = r_c -ddr;
    }else{
      if(!v2_mod)container_align_v2.style.height = 0;
    }

    if(Math.abs(t_c - t_o) < align_delta &&  (!isResizeMode || dt != 0)){//se c'� una corrispondenza del vertice con il vertice dell'oggetto
      container_align_h1.style.top = t_o+'px';
      container_align_h1.style.left = (l_c < l_o ? l_c : l_o)+'px';
      container_align_h1.style.width = (Math.abs (l_o - l_c) +w_c)+'px';
      h1_mod = true;
      isAlignWidth =true;
      ddt = (t_c - t_o)
      t_c = t_c -ddt;
      if(! isResizeMode) b_c = b_c -ddt;
    }else{
      if(!h1_mod){container_align_h1.style.width = 0 ;}
    }
    if(Math.abs( b_c - t_o) < align_delta &&  (!isResizeMode || db != 0) ){//se c'� una corrispondenza del fondo  con il vertice  dell'oggetto
      container_align_h2.style.top = t_o+'px';
      container_align_h2.style.left = (l_c < l_o ? l_c : l_o)+'px';
      container_align_h2.style.width = (Math.abs (l_o - l_c) +w_c)+'px';
      h2_mod = true;
      isAlignWidth =true;
      ddb =  (b_c - t_o)
      if(! isResizeMode) t_c = t_c -ddb;
      b_c = b_c -ddb;
    }else{
      if(!h2_mod)container_align_h2.style.width = 0;
    }

    if(Math.abs(r_c - r_o) < align_delta &&  (!isResizeMode || dr != 0)){//se c'� una corrispondenza a destra con la destra dell'oggetto
      container_align_v2.style.top = (t_c < t_o ? t_c : t_o)+'px';
      container_align_v2.style.left = r_o+'px';
      container_align_v2.style.height = (Math.abs(  t_o - t_c) +h_c)+'px';
      isAlignWidth =true;
      if(!v1_mod){
        ddr= ( r_c - r_o)
       if(! isResizeMode)  l_c = l_c -ddr;
        r_c = r_c -ddl;
      }
      v2_mod= true;
    }else {
      if(!v2_mod)container_align_v2.style.height = 0;
    }
    if(Math.abs(l_c - r_o) < align_delta &&  (!isResizeMode || dl != 0)){//se c'� una corrispondenza a sinistra con la destra dell'oggetto
      container_align_v1.style.top = (t_c < t_o ? t_c : t_o)+'px';
      container_align_v1.style.left = r_o+'px';
      container_align_v1.style.height = (Math.abs(  t_o - t_c) +h_c)+'px';
      isAlignWidth =true;
      if(!v1_mod){
        ddl= ( l_c - r_o)
        l_c = l_c -ddl;
       if(! isResizeMode)  r_c = r_c -ddl;
      }
      v1_mod= true;
    }else {
      if(!v1_mod)container_align_v1.style.height = 0;
    }

    if(Math.abs(b_c - b_o) < align_delta &&  (!isResizeMode || db != 0)){ //se c'� una corrispondenza del fondo  con il fondo dell'oggetto
      container_align_h2.style.top = b_o+'px';
      container_align_h2.style.left = (l_c < l_o ? l_c : l_o)+'px';
      container_align_h2.style.width = (Math.abs (l_o - l_c) + w_c)+'px';
      isAlignWidth =true;
      if(!h1_mod){
        ddb =  ( b_c - b_o)
        if(! isResizeMode) t_c = t_c -ddb;
        b_c = b_c -ddb;
      }
      h2_mod=true;
    } else{
      if(!h2_mod)container_align_h2.style.width = 0;
    }

    if( Math.abs(t_c - b_o) < align_delta &&  (!isResizeMode || dt != 0)) { //se c'� una corrispondenza del vertice con il fondo dell'oggetto
      container_align_h1.style.top = b_o+'px';
      container_align_h1.style.left = (l_c < l_o ? l_c : l_o)+'px';
      container_align_h1.style.width = (Math.abs (l_o - l_c) + w_c)+'px';
      isAlignWidth =true;
      if(!h1_mod){
        ddt =  (t_c - b_o)
        t_c = t_c -ddt;
        if(! isResizeMode) b_c = b_c -ddt;
      }
      h1_mod=true;
    } else{
      if(!h1_mod)container_align_h1.style.width = 0;
    }
    //Allineamento al centro del componente
    if( !light && Math.abs(mh_c -mh_o) < align_delta &&  (!isResizeMode)) { //se c'� una corrispondenza tra i due assi centrali verticali
      container_align_mh.style.top = (t_o < t_c ? t_o : t_c )+'px';
      container_align_mh.style.left = (mh_o )+'px';
      container_align_mh.style.height = (Math.max((( b_c > b_o) ? b_c :b_o)  - ((t_c <= t_o)?t_c :t_o)  , h_c))+'px';
      isAlignWidth =true;
      if(!v1_mod && !v2_mod) { //se e' stato spostata la shadow da altri allineamenti
        ddl =  (mh_c - mh_o)
        l_c = l_c -ddl;
        r_c = r_c -ddl;
      }
      mh_mod=true;
    }else{
      if(!mh_mod) container_align_mh.style.height=0;
    }
    if( !light && Math.abs(mv_c -mv_o) < align_delta &&  (!isResizeMode )) { //se c'� una corrispondenza tra i due assi centrali orizzontali
      container_align_mv.style.top = (mv_o)+'px';
      container_align_mv.style.left = (l_c < l_o ? l_c : l_o)+'px';
      container_align_mv.style.width = (Math.max(Math.abs( l_o >  l_c  ? (r_o - l_c) :(r_c - l_o)),w_c))+'px';
      isAlignWidth =true;
      if(! h1_mod && !h2_mod){
        ddt = (mv_c -mv_o)
        t_c = t_c -ddt;
      }
      mv_mod=true;
    }else{
      if(!mv_mod) container_align_mv.style.width = 0;
    }
    //condizioni di avvicinamento
    if( (t_c - b_o) < distance_sensor  && (t_c - b_o) >= align_delta &&  (!isResizeMode || dt != 0)) { //Avvicinamento vertice con il fondo dell'oggetto -|-
       distance_align_h2.style.width =(Math.max(Math.abs( l_o >  l_c  ? (r_o - l_c) :(r_c - l_o)),w_c))+'px';
       distance_align_h2.style.left= (l_o >l_c ? l_c  : l_o)+'px';
       distance_align_h2.style.top=b_o+'px';
       container_distance_v1.style.height =  distance_delta+'px';
       container_distance_v1.style.top = b_o+'px';
       container_distance_v1.style.left =(l_c + (w_c/2))+'px';
       ddt = t_c -(b_o + distance_delta)
      t_c = t_c -ddt
      dv1_mod=true;
      isNearWidth = true;
    }else{
      if(!dv1_mod){
        container_distance_v1.style.height = 0;
        distance_align_h2.style.width = 0;
      }
    }
    if( (  t_o - b_c) < distance_sensor  && ( t_o -b_c) >= align_delta &&  (!isResizeMode || db!= 0)) { //Avvicinamento fondo con il vertice dell'oggetto _|_
      distance_align_h1.style.width =(Math.max(Math.abs( l_o >  l_c  ? (r_o - l_c) :(r_c - l_o)),w_c))+'px';
      distance_align_h1.style.left= (l_o >l_c ? l_c  : l_o)+'px';
      distance_align_h1.style.top=t_o+'px';
      container_distance_v2.style.height =  distance_delta+'px';
      container_distance_v2.style.left =(l_c + (w_c/2))+'px';
      ddb=(( t_o - distance_delta) - (b_c ))*(-1)
      b_c = b_c -ddb
      container_distance_v2.style.top = b_c+'px';
      dv2_mod =true
      isNearWidth = true;
    }else{
      if(!dv2_mod){
        container_distance_v2.style.height = 0;
        distance_align_h1.style.width = 0;
     }
    }
    if((l_o - r_c ) < distance_sensor &&  ( l_o  -  r_c) >= align_delta &&  (!isResizeMode || dr != 0)){  //Avvicinamento destra con sinistra oggetto ->
      distance_align_v1.style.height = (Math.max((( b_c > b_o) ? b_c :b_o)  - ((t_c <= t_o)?t_c :t_o)  , h_c))+'px';
      distance_align_v1.style.left=l_o+'px';
      distance_align_v1.style.top= (t_c > t_o ? t_o : t_c)+'px';
      container_distance_h1.style.width = distance_delta+'px';
      container_distance_h1.style.top = (t_c + (h_c/2))+'px';
      ddr = ( r_c +distance_delta) - l_o
      r_c = r_c -ddr;
      container_distance_h1.style.left = r_c+'px';
      dh1_mod =true
      isNearWidth = true;
    }else{
      if(!dh1_mod){
        container_distance_h1.style.width = 0;
        distance_align_v1.style.height = 0;
      }
    }
    if(( l_c - r_o ) < distance_sensor &&  (  l_c - r_o) >= align_delta &&  (!isResizeMode || dl != 0)){  //Avvicinamento sinistra con destra oggetto  <-
      distance_align_v2.style.height = (Math.max((( b_c > b_o) ? b_c :b_o)  - ((t_c <= t_o)?t_c :t_o)  , h_c))+'px';
      distance_align_v2.style.left=r_o+'px';
      distance_align_v2.style.top= (t_c >= t_o ? t_o : t_c)+'px';
      container_distance_h2.style.width = distance_delta+'px';
      container_distance_h2.style.left = r_o+'px';
      container_distance_h2.style.top = (t_c + (h_c/2))+'px';
      ddl = l_c - (r_o +distance_delta)
      l_c = l_c -ddl;
      dh2_mod =true
      isNearWidth = true;
    }else{
      if(!dh2_mod){
        container_distance_h2.style.width = 0;
        distance_align_v2.style.height = 0;
      }
    }

    dl=dl- (ddl +( isResizeMode ? 0 : ddr));
    dt= dt -(ddt+ ( isResizeMode ? 0 :ddb))
    dr = dr - (ddr +( isResizeMode ? 0 : ddl));
    db = db -( ddb +( isResizeMode ? 0 :ddt))
    if(isAlignWidth || isNearWidth) {
      var type
      if(isNearWidth) type = 'near' // css selected_shadow_near
      else type = 'align'                   //css selected_shadow_align
      shadow_selected += addShadowAlign(l_o,t_o,((w_o-2)>0?w_o-2:0),((h_o-2)>0?h_o-2:0),i,type)
    }
    isAlignWidth =isNearWidth = false;
  }
  container_selection.l += dl;
  container_selection.t += dt;
  container_selection.r += dr;
  container_selection.b += db;
  if(isResizeMode)
    container_selection.h  = ((container_selection.h - (dt - db )) > 0  ? container_selection.h - (dt - db) : 0);
  if(isResizeMode)container_selection.w  =container_selection.w - (dl - dr) > 0 ? container_selection.w - (dl - dr) :0;
  shadow_selection.innerHTML = shadow_selected;
  delta[0] = dl;
  delta[1]= dt;
  delta[2] = dr;
  delta[3] = db;
  return delta; //ritorna l'array con i nuovi spostamenti ricalcolati in base agli allineamenti e le vicinanze
}
function resetAlign(){
  //tolgo gli allineamenti e le selected_shadow
  shadow_selection.innerHTML = ""
  container_align_h1.style.width = 0;
  container_align_h2.style.width = 0;
  container_align_v1.style.height = 0;
  container_align_v2.style.height = 0;
  container_align_mh.style.height=0;
  container_align_mv.style.width=0;
  distance_align_h1.style.width = 0;
  distance_align_h2.style.width = 0;
  distance_align_v1.style.height = 0;
  distance_align_v2.style.height = 0;
  container_distance_v1.style.height=0
  container_distance_v2.style.height=0
  container_distance_h1.style.width = 0;
  container_distance_h2.style.width = 0;
}
// sposta gli items nella posizione finale
function setShadow(/*e*/) {
  if(!Empty(mainitem) && isMove){
    resetAlign()
    Ctrl("canvas").onmousemove=null
    mainitem.onmouseup=null

	var o, kk, objmsg = [];
	for(kk=0; kk<container_selection.e.length; kk++){
		o = itemsHTML[container_selection.e[kk]];
		objmsg.push({idx:container_selection.e[kk], x:o.x, y:o.y, yRel:o.yRel});
	}

    moveItems();

	for(kk=0; kk<container_selection.e.length; kk++){
		if(o.type=="field" && o.fieldDet.type=="N" && o.calculate!="none" && o.zone.indexOf("footer")<0){
			var msg = "You moved a calculated field in a zone that does not include calculated fields. The calculation will be removed. Proceed anyway?";
			showMessageConfirm(msg,"calc",objmsg[kk]);
		}

		if(window.UpdateDesignObj){
			window.UpdateDesignObj(itemsHTML[container_selection.e[kk]], "position");
			if(window.setModifiedZone)
				setModifiedZone(itemsHTML[container_selection.e[kk]].zone);
		}
	}
    if(window.pushToHistory) window.pushToHistory();
    Properties();
    if(typeof(showProperties)!='undefined') showProperties('properties');
  }
  else if(!Empty(mainitem) && !isMove){
	  var mainidx = mainitem.id.substr(6);
	  if(ismobile && container_selection.e.indexOf(parseInt(mainidx))>=0){
		  mainitem.style.display='none';
		  itemsHTML[getItemsHTMLIndex("item"+mainidx)].shadow='';
		  Ctrl("handler" + mainidx + "_4").style.display='none';
		  Ctrl("handler" + mainidx + "_5").style.display='none';
		  Ctrl("handler" + mainidx + "_6").style.display='none';
		  Ctrl("handler" + mainidx + "_7").style.display='none';
		  Ctrl("handlersWrapper"+mainidx).style.display='none';
		  Ctrl("canvashandlers").removeChild(Ctrl("shadow"+mainidx));
		  Ctrl("canvashandlers").removeChild(Ctrl("handlersWrapper"+mainidx));
		  container_selection.e.splice(container_selection.e.indexOf(parseInt(mainidx)),1);
		  return;
	  }
  }
  isMove = false;
  objmsg = [];
  o = null;
}
// si spostano tutti gli elementi selezionati nella posizione finale di unmouseup
//MODIFICA: INSERIMENTO DELLE GUIDE DI ALLINEAMENTO E DELLA VISUALIZZAZIONE DELLA POSIZIONE
function moveItems(dir,e,notResize) {
  m_bUpdated=true;
  var  canResize = notResize ? notResize : false;
  var action = (e != null && (e.shiftKey ||  e.ctrlKey) ? 'resize' : 'move')
  //var isResizing=(e!=null && (e.shiftKey==true || e.ctrlKey==true));
  var n,elementShadow,elementtomove,element_tmp;
  var dx= 0,dy= 0,dw= 0,dh= 0, sc= 1
  //var undoItemsMoved=new Array()
  if(window.pushToHistory) window.pushToHistory();
  for (var p=0;p<itemsHTML.length;p++){
    element_tmp=itemsHTML[p];
    elementShadow=Ctrl(element_tmp.shadow);
    if(element_tmp.shadow !="" && elementShadow){
      // elemento ennesimo nell'array
      n=elementShadow.id.substr(6)
      elementtomove=Ctrl("item"+n)
    if(element_tmp.scale != undefined) sc = Round(element_tmp.scale/100, 0);
      switch (dir){
        case "up" :
          if(e!=null && e.shiftKey==true &&  e.ctrlKey==true&& !canResize){
            dh = 1;
            dy = -1;
          }
          else if(e!=null && e.shiftKey==true&& !canResize)
            dh = -1;
          else dy = -1;
        break
        case "down":
          if(e!=null && e.shiftKey==true &&  e.ctrlKey==true&& !canResize){
            dh = -1;
            dy = 1;
          }else if(e!=null && e.shiftKey==true&& !canResize)
            dh = 1;
         else dy = 1;
        break
        case "right":
          if(e!=null && e.shiftKey==true &&  e.ctrlKey==true&& !canResize){
            dw = -1;
            dx = 1;
          }else if(e!=null && e.shiftKey==true&& !canResize)
            dw = 1;
          else dx = 1;
        break
        case "left":
          if(e!=null && e.shiftKey==true &&  e.ctrlKey==true&& !canResize){
            dw = 1;
            dx = -1;
          }
          else if(e!=null && e.shiftKey==true&& !canResize) dw = -1;
          else   dx = -1;
        default:
      }
      var ret = true;
      if(window.ValidMove)
        ret = window.ValidMove(elementShadow.offsetLeft+dx, elementShadow.offsetTop+dy, elementShadow.offsetWidth, elementShadow.offsetHeight, "item"+n, itemsHTML[p])
      if(ret==false)
        return;
      dw = dw*sc;
      dh = dh*sc;
      dy = dy*sc;
      dx = dx*sc;
      elementShadow.style.width=(getOffset(elementShadow).w +dw)+'px';
      elementShadow.style.height=(getOffset(elementShadow).h +dh)+'px';
      elementShadow.style.top=(elementShadow.offsetTop +dy)+'px';
      elementShadow.style.left=(elementShadow.offsetLeft+dx)+'px';
      //salvo oggetti per operazione Undo non da tasto
	  /*if(historyStack){
		//if(window.pushToHistory) window.pushToHistory();
	  }
	  else{*/
		  if(Empty(dir) && typeof(ZTObjects)!='undefined'){
			if ((elementShadow.offsetLeft==elementtomove.offsetLeft) && (elementShadow.offsetTop==elementtomove.offsetTop)) {}
			else
			  undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj('item'+element_tmp.shadow.substr(6),'move',elementShadow.offsetLeft,elementShadow.offsetTop,elementtomove.offsetLeft,elementtomove.offsetTop, element_tmp);
		  }
		  if( dir && typeof(ZTObjects)!='undefined'){
			var old_action = undoItemsMoved[undoItemsMoved.length-1];
			if( old_action && old_action.action == action && old_action.id == 'item'+element_tmp.shadow.substr(6) &&  old_action.dir == dir /* && old_action.shiftKey == e.shiftKey && old_action.ctrlKey == e.ctrlKey */ ){
			  undoItemsMoved[undoItemsMoved.length-1] = new ZTObjects.undoObj('item'+element_tmp.shadow.substr(6),action,elementShadow.offsetLeft,elementShadow.offsetTop,undoItemsMoved[undoItemsMoved.length-1].x_init,undoItemsMoved[undoItemsMoved.length-1].y_init, element_tmp,elementShadow.offsetWidth,elementShadow.offsetHeight,undoItemsMoved[undoItemsMoved.length-1].w_init,undoItemsMoved[undoItemsMoved.length-1].h_init);
			  undoSequence[indexUndo]=undoItemsMoved
			}else{
			  if(undoItemsMoved.length>0) undoItemsMoved=[];
			  undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj('item'+element_tmp.shadow.substr(6),action,elementShadow.offsetLeft,elementShadow.offsetTop,elementtomove.offsetLeft,elementtomove.offsetTop, element_tmp,elementShadow.offsetWidth,elementShadow.offsetHeight,elementtomove.offsetWidth,elementtomove.offsetHeight);
			  indexUndo++
			  undoSequence[indexUndo]=undoItemsMoved
			  CheckUndoSize()
			}
			undoItemsMoved[undoItemsMoved.length-1].dir = dir ;
			if(e!= null){
			  undoItemsMoved[undoItemsMoved.length-1].shiftKey = e.shiftKey ;
			  undoItemsMoved[undoItemsMoved.length-1].ctrlKey = e.ctrlKey ;
			}
		  }else{
			if(undoItemsMoved && undoItemsMoved[undoItemsMoved.length-1]) undoItemsMoved[undoItemsMoved.length-1].dir = '';
		  }
		  if(Empty(dir) && typeof(ZTPlanObjects)!='undefined') undoItemsMoved[undoItemsMoved.length]=new ZTPlanObjects.undoObj('item'+element_tmp.shadow.substr(6),'move',elementShadow.offsetLeft,elementShadow.offsetTop,elementtomove.offsetLeft,elementtomove.offsetTop, element_tmp);
	 // }
	  if(window.AdjustMove)
		window.AdjustMove(element_tmp);

      elementtomove.style.width=(getOffset(elementtomove).w +dw)+'px';
      elementtomove.style.height=(getOffset(elementtomove).h +dh)+'px';
      elementtomove.style.top=(elementShadow.offsetTop)+'px'; //Spostamento dell'elemento che segue la shadow
      elementtomove.style.left=(elementShadow.offsetLeft)+'px';//Spostamento dell'elemento che segue la shadow
     //salvo nell'oggetto item la posizione corrente
      if(e!=null && e.shiftKey==true  &&  e.ctrlKey==true){
        element_tmp.w=elementShadow.offsetWidth
        element_tmp.h=elementShadow.offsetHeight
        element_tmp.x=elementShadow.offsetLeft
        element_tmp.y=elementShadow.offsetTop
      }else if(e!=null && e.shiftKey==true){
        element_tmp.w=elementShadow.offsetWidth
        element_tmp.h=elementShadow.offsetHeight
      }else{
        element_tmp.x=elementShadow.offsetLeft
        element_tmp.y=elementShadow.offsetTop
      }

	  if(window.setRelativeTop)
		window.setRelativeTop(element_tmp,elementtomove);

      if(Ctrl("handlersWrapper"+n)){
        var w=elementShadow.offsetWidth
        var h=elementShadow.offsetHeight
        var shadowH = ((h-2)>0 ? h-2 : 0 ) +8;  //tolgo i due pixel dei bordi
        var shadowW = ((w-2 )>0 ? w-2 : 0 ) +8;  //tolgo i 2 pixel dei bordi
        Ctrl("handlersWrapper"+n).style.top = (elementShadow.offsetTop-9) +'px';
        Ctrl("handlersWrapper"+n).style.left = (elementShadow.offsetLeft-9)+'px';
        Ctrl("handlersWrapper"+n).style.height = (shadowH+12)+'px'
        Ctrl("handlersWrapper"+n).style.width = (shadowW+12)+'px'
        if(Ctrl("handler"+n+"_4")){
          Ctrl("handler"+n+"_5").style.top = ((shadowH+4)/2)+'px'; //bordi
          Ctrl("handler"+n+"_6").style.top = ((shadowH+12)-16)+'px'; //posizionamento relativo  (16 = (size+2)*2)
          Ctrl("handler"+n+"_7").style.top = ((shadowH+4)/2)+'px';
        }
      }
      //GM compatibilit� vecchio comportamento - reporteditor
      else{
        Ctrl("handler"+n+"_0").style.left = (elementShadow.offsetLeft-3)+'px';
        Ctrl("handler"+n+"_0").style.top = (elementShadow.offsetTop-3)+'px';
        Ctrl("handler"+n+"_1").style.left = (elementShadow.offsetLeft+elementShadow.offsetWidth-6)+'px';
        Ctrl("handler"+n+"_1").style.top = (elementShadow.offsetTop-3)+'px';
        Ctrl("handler"+n+"_2").style.left = (elementShadow.offsetLeft+elementShadow.offsetWidth-6)+'px';
        Ctrl("handler"+n+"_2").style.top = (elementShadow.offsetTop+elementShadow.offsetHeight-6)+'px';
        Ctrl("handler"+n+"_3").style.left =( elementShadow.offsetLeft-3)+'px';
        Ctrl("handler"+n+"_3").style.top = (elementShadow.offsetTop+elementShadow.offsetHeight-6)+'px';
        if(Ctrl("handler"+n+"_4")){
          Ctrl("handler"+n+"_4").style.left = (elementShadow.offsetLeft-3+elementShadow.offsetWidth/2)+'px';
          Ctrl("handler"+n+"_4").style.top = (elementShadow.offsetTop+elementShadow.offsetHeight-6)+'px';
          Ctrl("handler"+n+"_6").style.left = (elementShadow.offsetLeft-3+elementShadow.offsetWidth/2)+'px';
          Ctrl("handler"+n+"_6").style.top = (elementShadow.offsetTop-3)+'px';
          Ctrl("handler"+n+"_5").style.left = (elementShadow.offsetLeft-3)+'px';
          Ctrl("handler"+n+"_5").style.top = (elementShadow.offsetTop+elementShadow.offsetHeight/2-3)+'px';
          Ctrl("handler"+n+"_7").style.left = (elementShadow.offsetLeft+elementShadow.offsetWidth-6)+'px';
          Ctrl("handler"+n+"_7").style.top = (elementShadow.offsetTop+elementShadow.offsetHeight/2-3)+'px';
        }
      }
    }
	else if(element_tmp.shadow !="" && window.moveSection)
		window.moveSection(dir, element_tmp.shadow, p)
  }
  if(Empty(dir) && undoItemsMoved.length>0){
    indexUndo++;
    undoSequence[indexUndo]=undoItemsMoved;
    CheckUndoSize();
    undoItemsMoved=[];
  }
  if(window.pushToHistory) window.pushToHistory();
}
var indexUndo=-1;
var indexRedo=-1;
function Undo() {
  if(historyStack){
    if(historyStack.hasUndo() && window.undoFromHistory)
      window.undoFromHistory();
    if(window.updateFieldsPane)
      window.updateFieldsPane();
    return;
  }

  var l, ll, p, idx;
  if(indexUndo>-1){
    var prevUndo=undoSequence[indexUndo] // sequenza prev
    if(prevUndo[0].action=='move'){
      for (l=0;l<prevUndo.length;l++){
        for (p=0;p<itemsHTML.length;p++){
          if(prevUndo[l].id==itemsHTML[p].id){
            itemsHTML[p].x=prevUndo[l].x_init
            itemsHTML[p].y=prevUndo[l].y_init
          }
        }
      }
    }else if(prevUndo[0].action=='resize'){
      for (l=0;l<prevUndo.length;l++){
        for (p=0;p<itemsHTML.length;p++){
          if(prevUndo[l].id==itemsHTML[p].id){
            itemsHTML[p].w=prevUndo[l].w_init;
            itemsHTML[p].h=prevUndo[l].h_init;
            if(!Empty(prevUndo[l].x_init))itemsHTML[p].x=prevUndo[l].x_init;
            if(!Empty(prevUndo[l].y_init))itemsHTML[p].y=prevUndo[l].y_init;
          }
        }
      }
    }else if(prevUndo[0].action=='delete'){
      //L'Undo del paste nel PortletEditor ha come action delete
      for (ll=0;ll<prevUndo.length;ll++){
        idx = 0;
        for (p=0;p<itemsHTML.length;p++){
          //Serve per controllare se l'elemento e' gia' presente nell'area di lavoro: serve per l'Undo del paste
          if((prevUndo[ll].obj.name==itemsHTML[p].name) && (prevUndo[ll].obj.type==itemsHTML[p].type) && (prevUndo[ll].obj.value==itemsHTML[p].value)) {
            itemsHTML.splice(p,1);
          }
        }
        itemsHTML[itemsHTML.length]=prevUndo[ll].obj;
        countindex++;
      }
    } else if(prevUndo[0].action=='paste'){
      for (ll=0;ll<prevUndo.length;ll++){
        idx = LibJavascript.Array.indexOf(itemsHTML,prevUndo[ll].obj);
        if(idx>=0){
          itemsHTML.splice(idx,1);
        }
      }
    }
    indexRedo=indexUndo;
    indexUndo--;
    writeHTML(true);
  }
}
function Redo() {
  if(historyStack){
	if(historyStack.hasRedo() && window.redoFromHistory)
		window.redoFromHistory();
	return;
  }
  var l, p, ll;
  if((indexRedo>-1) && (indexRedo < undoSequence.length)){
    var seqRedo=undoSequence[indexRedo] // sequenza prev
    if(seqRedo[0].action=='move'){
      for (l=0;l<seqRedo.length;l++){
        for (p=0;p<itemsHTML.length;p++){
          if(seqRedo[l].id==itemsHTML[p].id){
            itemsHTML[p].x=seqRedo[l].x;
            itemsHTML[p].y=seqRedo[l].y;
          }
        }
      }
    }else if(seqRedo[0].action=='resize'){
      for (l=0;l<seqRedo.length;l++){
        for (p=0;p<itemsHTML.length;p++){
          if(seqRedo[l].id==itemsHTML[p].id){
            itemsHTML[p].w=seqRedo[l].w;
            itemsHTML[p].h=seqRedo[l].h;
            if(!Empty(seqRedo[l].x_init))itemsHTML[p].x=seqRedo[l].x;
            if(!Empty(seqRedo[l].y_init))itemsHTML[p].y=seqRedo[l].y;
          }
        }
      }
    }else if(seqRedo[0].action=='delete'){
      for (ll=0;ll<seqRedo.length;ll++){
        var idx = LibJavascript.Array.indexOf(itemsHTML,seqRedo[ll].obj);
        if(idx>=0){
          itemsHTML.splice(idx,1);
          countindex--;
        }
      }
      index=null;
    }
    else if(seqRedo[0].action=='paste'){
      for (ll=0;ll<seqRedo.length;ll++){
        itemsHTML[itemsHTML.length]=seqRedo[ll].obj;
      }
    }
    indexUndo=indexRedo;
    indexRedo++;
    //selectForm();
    //if(last_index) last_index=null;
    writeHTML(true)
  }
}

var maxUndoLength=80;
/*
	numero precedente 8.
	numero assegnato da Michel Glele 29/04/2013 : 80
*/
function CheckUndoSize() {
  if(undoSequence.length>maxUndoLength){
    var tmp=new Array();
    var tmpn=0;
    for (var tt=0;tt<undoSequence.length;tt++){
      if(tt>0){
        tmp[tmpn]=undoSequence[tt];
        tmpn++;
      }
    }
    undoSequence=tmp;
    indexUndo=tmpn-1;
  }
}

function editPortlet(e,url){
  e.cancelBubble=true
  if(url.indexOf("_portlet.jsp")>-1){
    url=Strtran(url,"_portlet.jsp","")
    if(parent.newCurrentObj)
      parent.newCurrentObj(url,"portlet",{});
    else
      windowOpenForeground('../visualweb/editor.htm?id='+url,'','status=1,directories=0,width=800px,height=600px,top=0,left=0,resizable=1,scrollbars=1');
  }
}

function OpenWindow(url,width,height,left,top,features,title){
  window.setTimeout("document.body.onfocus=CloseDialogs",500);
  if(features!=null) features=","+features; else features="";
  return window.open(url,title,"width="+width+",height="+height+",left="+left+",top="+top+",status=yes,help=no"+features);
}
function CloseDialogs(){
  try{
    if(WinOpener) WinOpener.close();
    document.body.onfocus = null;
  }catch(e){
    //
  }
}
//funzioni cambiamento opacita div
var fadestr;
function fadeOut(init,final,id,step,ms,strToEval){
  if(typeof(strToEval)!='undefined') fadestr=strToEval;
  var oDiv = document.getElementById(id);
  if(init<final){
    if(navigator.appName.indexOf("Microsoft")>-1){//MS, quindi alpha filter
      oDiv.style.filter="alpha(opacity='"+parseInt(final*100)+"')";
    }else{
      if(oDiv.style.MozOpacity) oDiv.style.MozOpacity = final;
      oDiv.style.opacity = final;
    }
    oDiv.style.zIndex='102'
    oDiv.style.display="none";
    if(!Empty(fadestr))eval(fadestr);
    return;
  }
  if(navigator.appName.indexOf("Microsoft")>-1){//MS, quindi alpha filter
    oDiv.style.filter="alpha(opacity='"+parseInt(init*100)+"')";
  }else{
    if(oDiv.style.MozOpacity) oDiv.style.MozOpacity = init;
    oDiv.style.opacity = init;
  }
  setTimeout("fadeOut("+parseFloat(init-step)+","+final+",'"+id+"',"+step+","+ms+")",ms);
}

function fadeIn(init,final,id,step,ms,strToEval){
  if(typeof(strToEval)!='undefined') fadestr=strToEval;
  var oDiv = document.getElementById(id);
  if(init>final){
    if(navigator.appName.indexOf("Microsoft")>-1){//MS, quindi alpha filter
      oDiv.style.filter="alpha(opacity='"+parseInt(final*100)+"')";
    }else{
      if(oDiv.style.MozOpacity) oDiv.style.MozOpacity = final;
      oDiv.style.opacity = final;
    }
    if(!Empty(fadestr))eval(fadestr);
    return;
  }
  oDiv.style.visibility="visible";
  if(navigator.appName.indexOf("Microsoft")>-1){//MS, quindi alpha filter
    oDiv.style.filter="alpha(opacity='"+parseInt(init*100)+"')";
  }else{
    if(oDiv.style.MozOpacity) oDiv.style.MozOpacity = init;
    oDiv.style.opacity = init;
  }
  setTimeout("fadeIn("+parseFloat(init+step)+","+final+",'"+id+"',"+step+","+ms+")",ms);
}

function fade(start,end,step,ms,cId,_in,str){
  var oDiv = document.getElementById(cId);
  if(_in){
    oDiv.style.visibility="hidden";
    fadeIn(start,end,cId,step,ms,str);
  }else{
    fadeOut(start,end,cId,step,ms,str);
  }
}
/*var PSAlert=new function(){
  this.t=null;
  return {
    alert:
      function(m,t){ // tempo in secondi
        var w=this.main;
        var d=this.main.document;
        var b;
        if(Ctrl("PSAlert")){
          b = Ctrl("PSAlert");
          b.style.display='block';
          setOpacity(b,0.8);
        }else{
          b=d.createElement('div');
          b.id='PSAlert';
          // insert in to body
          b=d.body.insertBefore(b,d.body.firstChild);
          b.className='notimoo';
          b.style.cssText='position:absolute;';
          b.style.textAlign='center';
          b.style.width='20%';
          b.style.marginLeft='40%';
          b.style.marginRight='40%';
          b.style.top='300px';
          b.style.zIndex='1001';
          setOpacity(b,0.8);
          // classname not passed, set defaults
          if(b.className.length==0){
            b.style.padding='8px 8px';
            b.style.border='1px solid #888888';
            b.style.backgroundColor='#FFFFFF';
            b.style.fontFamily='lucida grande,Verdana,taohma';
            b.style.fontWeight='bold';
            b.style.color='#888888';
            b.style.fontSize='12px';
            b.style.lineHeight='24px';
            b.style.display='block';
          }
        }
        // write HTML fragment to it
        b.innerHTML="<div style='background:URL(../portalstudio/images/warning.png) no-repeat;height:24px;width:24px;margin-left:auto;margin-right:auto'></div> ";
        b.innerHTML+="<div>"+m+"</div>";
        // fadeout block if supported
        this.b=b;
        if(this.t)clearTimeout(this.t);
        if(FadingId)clearInterval(FadingId);
        if (typeof(t)!='number') t = 2000;
        else t = t * 1000;
        this.t=setTimeout("setFading(PSAlert.b,80,0,700,'function(){PSAlert.main.document.body.removeChild(PSAlert.b);}')",t);
      }  ,
    init:
      function(w,s){
        // save window
        this.main=w;
        this.classname=s||'';
      }
    // shutdown Alert object
  };
};*/
// apply a fading effect to an object
// by applying changes to its style
// @o = object style
// @b = begin opacity
// @e = end opacity
// @d = duration (millisec)
// @f = function (optional)
var FadingId=null;
function setFading(o,b,e,d,f){
 //setOpacity(o,0);
  FadingId=setInterval(
    function(){
      b=stepFX(b,e,2);
      setOpacity(o,b/100);
      if(b==e){
        if(FadingId){clearInterval(FadingId);FadingId=null;}
        if(typeof f=='function'){f();}
        o.style.display='none';
      }
    },d/50
  );
}
// set opacity for element
// @e element
// @o opacity
function setOpacity(e,o){
  // for IE
  e.style.filter='alpha(opacity='+o*100+')';
  // for others
  e.style.opacity=o;
}
// increment/decrement value in steps
// checking for begin and end limits
//@b begin
//@e end
//@s step
function stepFX(b,e,s){
  return b>e?b-s>e?b-s:e:b<e?b+s<e?b+s:e:b;
}

function getOffset(itm){
  var bl =  parseInt(LibJavascript.DOM.getComputedStyle( itm, "border-left-width" ));
  //var bl =  parseInt(itm.style.borderLeftWidth!=""?itm.style.borderLeftWidth:0)
  var br = parseInt(LibJavascript.DOM.getComputedStyle( itm, "border-right-width" ));
  //var br = parseInt(itm.style.borderRightWidth!=""?itm.style.borderRightWidth:0)
  var bb = parseInt(LibJavascript.DOM.getComputedStyle( itm, "border-top-width" ))
  //var bb = parseInt(itm.style.borderTopWidth!=""?itm.style.borderTopWidth:0)
  var bt = parseInt(LibJavascript.DOM.getComputedStyle( itm, "border-bottom-width" ))
  //var bt = parseInt(itm.style.borderBottomWidth!=""?itm.style.borderBottomWidth:0)
  var ml =  parseInt(itm.style.marginLeft!=""?itm.style.marginLeft:0)
  var mr = parseInt(itm.style.marginRight!=""?itm.style.marginRight:0)
  var mb = parseInt(itm.style.marginTop!=""?itm.style.marginTop:0)
  var mt = parseInt(itm.style.marginBottom!=""?itm.style.marginBottom:0)
  var pl =  parseInt(itm.style.paddingLeft!=""?itm.style.paddingLeft:0)
  var pr = parseInt(itm.style.paddingRight!=""?itm.style.paddingRight:0)
  var pb = parseInt(itm.style.paddingTop!=""?itm.style.paddingTop:0)
  var pt = parseInt(itm.style.paddingBottom!=""?itm.style.paddingBottom:0)
  var gapw = bl+br+ml+mr+pl+pr
  var gaph =  bb+bt+mt+mb+pt+pb
  var w= itm.offsetWidth - ( gapw)
  var h= itm.offsetHeight - ( gaph )
  return {w:w,h:h,gapw:gapw,gaph:gaph}
}

//Funzioni che permettono di disabilitare la selezione dell'html
function disableSelect(el){
  if(el.attachEvent){
    el.attachEvent("onselectstart",disabler);
  } else {
    el.addEventListener("mousedown",disabler,"false");
  }
}

function enableSelect(el){
  if(el.attachEvent){
    el.detachEvent("onselectstart",disabler);
  } else {
    el.removeEventListener("mousedown",disabler,"false");
  }
}

function disabler(e){
  if(e.preventDefault){ e.preventDefault(); }
  return false;
}
function addRulersLines(){
  if(!Empty(clHRRulersLib) && !Empty(mainitem)){
    clHRRulersLib.AddHorizontalLine("shadowHLL"+mainitem.id,mainitem.offsetLeft/*-Ctrl("backcanvas").scrollLeft*/, parseInt(Ctrl("h_ruler").style.top),"white",mainitem.id);
    clHRRulersLib.AddHorizontalLine("shadowHLR"+mainitem.id, mainitem.offsetLeft+mainitem.offsetWidth/*-Ctrl("backcanvas").scrollLeft*/, parseInt(Ctrl("h_ruler").style.top),"white",mainitem.id);
    clVRRulersLib.AddVerticalLine("shadowVLL"+mainitem.id, parseInt(Ctrl("v_ruler").style.left), mainitem.offsetTop/*-Ctrl("backcanvas").scrollTop*/,"white",mainitem.id);
    clVRRulersLib.AddVerticalLine("shadowVLR"+mainitem.id, parseInt(Ctrl("v_ruler").style.left), mainitem.offsetTop+mainitem.offsetHeight/*-Ctrl("backcanvas").scrollTop*/,"white",mainitem.id);
  }
}
function EmptyRefLines(){
  if(!Empty(clHRRulersLib))clHRRulersLib.EmptyRefLines();
  if(!Empty(clVRRulersLib))clHRRulersLib.EmptyRefLines();
}
function addRulersLine(e){
  if (!e) e = window.event;
  var xpos = 0;
  var ypos = 0;
  if (e != null){
    xpos = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
    ypos = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
  }
  clHRRulersLib.AddHorizontalLine("h_ruler_mouse", xpos, parseInt(Ctrl("h_ruler").style.top), "white");
  clVRRulersLib.AddVerticalLine("v_ruler_mouse", parseInt(Ctrl("v_ruler").style.left), ypos, "white");
}

/*Apertura e chiusura della preview*/
var preview_opened=false;
function togglePreview(){
  var i_preview=document.getElementById('i_preview');
  var i_preview_wrapper=document.getElementById('i_preview_wrapper');
  var btn_preview=document.getElementById('btn_preview');
  var morphP= new Fx.Morph(i_preview_wrapper,{ 'duration':'400',transition:Fx.Transitions.easeOut});
  document.getElementById('formproperties').set('morph')
  if(!preview_opened){
    i_preview_wrapper.setStyles({'width': window.getSize().x,'height':window.getSize().y-30,'left':window.getSize().x,'top':30});
    i_preview.setStyles({'height': window.getSize().y-70,'top':40});
    if(m_bUpdated){
      save(function(){
        togglePreview()
      });
      return;
    }
    i_preview_wrapper.setStyle('display','block');
    switch(tool){
      case 'portlet':
        if(currentname.indexOf('/jsp-decorator')>-1){
          i_preview.src=currentname+'_portlet.jsp?m_NoCache='+LibJavascript.AlfaKeyGen(10)+pUrl;
        }else{
          i_preview.src='../jsp/'+currentname+'_portlet.jsp?m_NoCache='+LibJavascript.AlfaKeyGen(10)+pUrl;
        }
      break;
      case 'report':
      if(reportPreview) reportPreview();
      break;
      case 'module':
        i_preview.src='../servlet/JSPModEditorPrev?name='+currentname+'&m_NoCache='+LibJavascript.AlfaKeyGen(10);
      break;
      case 'scandoc':
      if(scanPreview) scanPreview();
      break;
      case 'portalzoom':
        i_preview.src = GetResourceName(pUrl);
      break;
      case 'pageleteditor':
        i_preview.src = GetResourceName();
      break;
      case 'maskparameters':
        if (maskPreview) maskPreview();
      break;
	  case 'chart':
        if (chartPreview) chartPreview(pUrl);
      break;

    }
    btn_preview.getFirst().setStyle('background-image','url(../portalstudio/images/icon/btn_preview_off.png)');
    btn_preview.title='Back to Edit';
    morphP.start({'left':(window.getWrapperLeft?window.getWrapperLeft():0)});
    preview_opened=true;
    // document.getElementById('objList').getChildren().each(function(el){
      // var a = el.getElement('a');
      // if( !a || (a && a.id != 'btn_preview') ){
        // el.set('morph')
        // el.morph({'opacity':0.2})
        // disableAnchor(a, true);
      // }

    // })
    document.getElementById('formproperties').set('morph')
    document.getElementById('formproperties').morph({'opacity':0.2})
  }else{
    btn_preview.getFirst().setStyle('background-image','url(../portalstudio/images/icon/btn_preview.png)');
    morphP.start({'left': window.getSize().x}).chain(function (){i_preview_wrapper.setStyle('display','none');});
    btn_preview.title='Go to Preview';

    switch(tool){
      case 'scandoc':
        if(scanPreview) scanPreview();
          break;
	  case 'chart':
        if (chartPreview) chartPreview(pUrl);
      break;
    }

    preview_opened=false;
    // document.getElementById('objList').getChildren().each(function(el){
      // var a = el.getElement('a');
      // if( !a || (a && a.id != 'btn_preview') ){
        // el.set('morph')
        // el.morph({'opacity':1})
        // disableAnchor(a, false);
      // }
    // })
    document.getElementById('formproperties').morph({'opacity':1})
  }
  if(window.setToolbars) window.setToolbars()
}

if (typeof(ZtVWeb)!='undefined') {
  var params_opened=false;
  var portlet_fake=new function(){
    ZtVWeb.newForm(this,'portlet_fake','params_receiver',400,200,'portlet');
    this.parametersList_confirm=new ZtVWeb.EventReceiverCtrl(this,'parametersList_confirm','parametersObj','previewConfirmParms(evt.parametersObj)','','func');
    this.parametersList_discard=new ZtVWeb.EventReceiverCtrl(this,'parametersList_discard','parametersObj','toggleParameters()','','func');
  }
  ZtVWeb.addPortletObj('portlet_fake','params_receiver',portlet_fake);
  portlet_fake.on_parametersList_confirm=function(parmsObj){portlet_fake.parametersList_confirm.receiveFnc(parmsObj);}
  portlet_fake.on_parametersList_discard=function(parmsObj){portlet_fake.parametersList_discard.receiveFnc(parmsObj);}


var pObj={};
var pValues=null;
var pUrl='';
function previewConfirmParms(obj){
  pUrl='';
  pValues=obj;
  for(var i in pValues){
    pUrl+='&'+i;
    pUrl+='='+ZtVWeb.valueToStr(pValues[i]);
  }
  toggleParameters();
}
function toggleParameters(){
  var parameters_wrapper=document.getElementById("parameters_wrapper");
  if(!params_opened){
    SetOnEditProp(false);
    parameters_wrapper.setStyle('opacity',0);
    parameters_wrapper.setStyle('display','block');
    parameters_wrapper.set('tween', {duration: '300'});
    parameters_wrapper.tween('opacity', 0, 1);

    var curr_request_parms = GetRequestParams(); //Oggetto nome -> [{description, type, len, dec, group} | tipo ]
    var i;
    if (typeof(curr_request_parms)=='string' && Lower(Right(curr_request_parms,4))=='.vdm'){
      var projectUrl = new JSURL("../servlet/SPVDMProxy?m_cAction=load&m_cConfigName="+Left(curr_request_parms,Len(curr_request_parms)-4), true);
      var myResponse = projectUrl.Response();
      pObj = JSON.parse(myResponse);
      pObj.onOkResource=GetResourceName('');
      if (skinList){
        var found=false;
        for (i=0; i<pObj.fields.length && !found; i++){
          if (pObj.fields[i].fieldName=='forcedSkin'){
            pObj.fields[i].viewType='combo';
            pObj.fields[i].comboLabels=skinList;
            pObj.fields[i].comboValues=skinList;
            pObj.fields[i].initialValue=currentSkin;
            found=true;
          }
        }
      }
    }
    else {
      pObj={}
      pObj.configName=GetCurrentName();
      pObj.onOkResource=GetResourceName('');
      pObj.titleMsg='Set Parameters';
      pObj.target='i_preview';
      pObj.mode=1;
      pObj.fields=[];
      var ii= (skinList?1:0);
      if(skinList){
        pObj.fields[0]={};
        pObj.fields[0].fieldName="forcedSkin";
        pObj.fields[0].viewType='combo';
        pObj.fields[0].description="Select skin";
        pObj.fields[0].comboLabels=skinList;
        pObj.fields[0].comboValues=skinList;
        pObj.fields[0].hideEmptyValue=true;
        pObj.fields[0].initialValue=currentSkin;
      }
      for (i in curr_request_parms){
        var varDesc, varType, varLen, varDec, displayLen, varGroup;
        if (typeof(curr_request_parms[i])=='string') {
          varDesc=i;
          varType=curr_request_parms[i];
          displayLen=15;
          varLen=100;
          varDec=0;
          varGroup='';
        } else {
          varDesc=curr_request_parms[i].description||i;
          varType=curr_request_parms[i].type||'C';
          displayLen=curr_request_parms[i].len||15;
          varLen=curr_request_parms[i].len||100;
          varDec=curr_request_parms[i].dec||0;
          varGroup=curr_request_parms[i].group||'';
        }
        pObj.fields[ii]={};
        pObj.fields[ii].fieldName=i;
        pObj.fields[ii].type=varType;
        pObj.fields[ii].description=varDesc;
        pObj.fields[ii].displayLen=displayLen;
        pObj.fields[ii].len=varLen;
        pObj.fields[ii].dec=varDec;
        pObj.fields[ii].group=varGroup;
        if(!Empty(pValues)) //se non ci sono valori iniziali
          pObj.fields[ii].initialValue=ZtVWeb.valueToStr(pValues[i],varType);
        else
          pObj.fields[ii].initialValue='';
        ii++;
        //obj.fields[i].len=20;
      }
    }
    //var pAction="m_cAction=save";
    //var pConfigName="&m_cConfigName="+getOpener().m_cFilename;
    //var pObj="&m_cWv="+escape(toJSONString(obj));
    //var url="../servlet/SPVDMProxy?"+pAction+pConfigName+pObj;
    //if (new JSURL(url,true,this.saved).Response()=='Saved'){
    var vdmParams=window.getVdmParams?"&"+getVdmParams():"";
    ZtVWeb.Include("../jsp/SPMaskParameters_portlet.jsp?EmitterName=parametersList&ConfigObject="+escape(JSON.encode(pObj))+"&Width=100%"+vdmParams,parameters_wrapper,true);
    //}
    //FillParameterProps();
    //var parms='m_cWv='+Ctrl("m_cWv").value+',m_cParams='+Ctrl("m_cParams").value+',m_lShowAll='+Ctrl("m_lShowAll").value;
    //ZtVWeb.getPortlet('SPMaskParameters').addParameterSPLinker(parms);
    //ZtVWeb.getPortlet('SPMaskParameters').setAction(Ctrl("m_cAction").value);
    params_opened=true;
    selectForm();
  }else{
    var param_m=new Fx.Morph(parameters_wrapper,{duration: '300'});
    // parameters_wrapper.set('tween', {duration: '200'});
    param_m.start({'opacity':0}).chain(function(){parameters_wrapper.setStyle('display','none');ZtVWeb.removePortletObj('SPMaskParameters');ZtVWeb.purgeEventsCache('SPMaskParameters');});
    params_opened=false;
    SetOnEditProp(false);
  }
}

}
function disableAnchor(obj, disable){
  if(!obj)
    return;
  if(disable){
    var href = obj.getAttribute("href");
    if(href && href != "" && href != null){
      obj.setAttribute('href_bak', href);
    }
    obj.removeAttribute('href');
  }
  else{
    obj.setAttribute('href', obj.attributes['href_bak'].nodeValue);
  }
}

function getDocHeight() {
  var D = document;
  return Math.max(
      Math.max(D.body.scrollHeight, D.documentElement.scrollHeight),
      Math.max(D.body.offsetHeight, D.documentElement.offsetHeight),
      Math.max(D.body.clientHeight, D.documentElement.clientHeight)
  );
}

function unSelectItem(itm){
  SetOnEditProp(false);
  var i;
  var mainitemz = itm;
  var unselecteditem = mainitemz.id.substr(6);
  var indexz=-1;
  //if(index==selecteditem) return; //selecteditem NON indica la posizione nell'array!!!
  for (i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow == mainitemz.id){
      indexz = i;
	}
  }
  if(indexz>0){
	itm.style.display='none';
	itemsHTML[indexz].shadow='';
	Ctrl("handler" + unselecteditem + "_0").style.display='none';
	Ctrl("handler" + unselecteditem + "_1").style.display='none';
	Ctrl("handler" + unselecteditem + "_2").style.display='none';
	Ctrl("handler" + unselecteditem + "_3").style.display='none';
	Ctrl("canvashandlers").removeChild(itm);
	if(mainitem && mainitem.id==mainitemz.id){
		for (i = 0; i < itemsHTML.length; i++) {
			if (itemsHTML[i].shadow  && Ctrl(itemsHTML[i].shadow)){
			  return selectItem(Ctrl(itemsHTML[i].shadow));
			}
		}
		removeAllHandlers();
	}
  }
}

function PickItems(tool,retTo,top, left, width, height){
  var offlinemode='';
  var ind=(GetOpener()? GetOpener().index : index);
  var itemsH=(GetOpener()?GetOpener().itemsHTML : itemsHTML);
  if(ind!=null && itemsH[ind].offline=='true') offlinemode="&offlinemode=true";

  //openSPModalLayer("../portalstudio/open.jsp?tool="+tool+"&onetool=true&ExpressionID="+retTo+"&callerFunction=ExpressionBuilderReturn&SPModalLayerId=querySPModalLayer"+offlinemode, t, l, width, height, true, 1, false, false);
  window.layerOpenForeground("../portalstudio/open.jsp?tool="+tool+"&onetool=true&ExpressionID="+retTo+"&callerFunction=ExpressionBuilderReturn&SPModalLayerId="+tool+"SPModalLayer"+offlinemode,"Select "+tool,'',width,height,true,1);
  }

// overwrite PortalCommonsJS
var currentAPIClass = null;
var currentAPIType = "";
function renderApi(obj /*itemsHTML object*/) {
  currentAPIClass = null;
  currentAPIType = "";
  if(obj && obj.objClass) {
    currentAPIClass = obj.objClass;
    currentAPIType = obj.type;
    openSPComponentAPI();
  }
}

function openSPComponentAPI() {
  var pws = window.GetWindowSize();
  window.layerOpenForeground("../jsp-system/SPComponentAPI.jsp", "", "", pws.w, pws.h, true, 1);
}

function getRenderApiObjClass() {
  return { apiType : currentAPIType, apiObj : currentAPIClass, ovr_tabs: true };
}

var apiSamples = {};
function getComponentSamples(apiType) {
  return apiSamples[apiType];
}

function setComponentSamples(apiType, samples) {
  return apiSamples[apiType] = samples;
}

function renderApiForm() {
  if (formProp) {
    var obj = makeAPIobj(formProp, true);
    renderApi(obj);
  }
}

function renderApiElement() {
  if (index != null) {
    var element = itemsHTML[index];
    if (element && element.objClass) {
      console.log(element, element.type, element.typeView)
      var obj = makeAPIobj(element);
      renderApi(obj)
    }
  }
}

function makeAPIobj(org_obj, isForm) {
  var obj = { type: org_obj.type, objClass: { newProperties: {} } },
    general = org_obj.objClass.newProperties,
    props;

  if (org_obj.objClass._api) {
    if (isForm) {
      for (props in org_obj.objClass._api) {
        addProp(props);
      }
    }
    else {
      props = org_obj.typeView;
      addProp(props);
      if (props == "text" || props == "numeric" || props == "datetime" || props == "pagenum")
        obj.objClass.newProperties.font = general.font;
    }
  }
  else
    obj.objClass.newProperties = general;
  return obj;

  function addProp(props) {
    var pobj = org_obj.objClass._api[props];
    if (!pobj && general[props])
      obj.objClass.newProperties[props] = general[props];
    else {
      if (pobj == "all") {
        obj.objClass.newProperties[props] = general[props];
      }
      else {
        if (pobj in general) { // tab con altro nome
          obj.objClass.newProperties[props] = general[pobj];
        }
        else if (pobj.length > 0 && pobj[0].name) { // array con props
          obj.objClass.newProperties[props] = pobj.slice();
        }
        else if (pobj.length > 0) { // array con propID specificati
          obj.objClass.newProperties[props] = [];
          for (var i = 0; i < general[props].length; i++) {
            if (pobj.indexOf(general[props][i].propID) >= 0)
              obj.objClass.newProperties[props].push(general[props][i]);
          }
        }
      }
    }
  }
}