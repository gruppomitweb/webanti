/* exported doLoad Help draggingHandler beginDragHandler border moveVLine ItemEventInput
    editItemEvent EditManifest Copy saving savingpic save Paste loadNewObj loadNewObjDone
    alignItems insertImage closeDialogs GetCurrentName GetResourceName GetRequestParams
    toggleLogicView unSelectItem
/*
Funzioni sotto sono nel file PortalCommonJS.js:
- function dragToolbar(e,obj)
- function beginDragSelection(e)
- function noDefaultDrag(e)
- function findDragItems(e,y,x,w,h)
- function removeAllHandlers()
- function addHandlers(itmIdx)
- function selectItem(itm)
- function cancelEvent(e)
- function clickShadow(e)
- function moveItems()
*/
var currentname="" //nome del portlet corrente
var folder_path=''
var WinOpener // dialog windows handler
var standalone=false;
var skin
var sequence_c=0
var changeselectshadow = true;
var m_nFrontendPort=null;
var toolbars = {};
var request_parms={}; //Oggetto nome -> [{description, type, len, dec} | tipo ]
function doLoad(e, id, skinName, frontendport){
  initPainter();
  AppletTag("Batch")
  skin=skinName;
  canAlign = true;
  BatchApplet().documentloc=Strtran(location.toString(),"visualweb/editor.jsp","servlet/dummy")
  document.body.style.cursor="default"
  //DrawAlignToolbar();
  //DrawObjectsToolbar();
  document.body.onhelp=CancelHelp

  toolbars.ctrl = new SPToolbar(ZTObjects.PSToolbarCtrl, 'sptoolbar_ctrl', {
    elementToShow: 'all'
  });

  toolbars.align = new SPToolbar(ZTObjects.PSToolbarAlign, 'sptoolbar_align', {
    elementToShow: 'all'
  });
  toolbars.action = new SPToolbar(ZTObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  });

  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0){
    standalone=true;
    toolbars.action.addElement({ 'isSeparator': true },2)
  }else{
    toolbars.action.removeElement('open')
    toolbars.action.removeElement('save')
    toolbars.action.removeElement('input_action_open')
  }
  //var GET_DATA=LibJavascript.ReadGetData();
  //if('id' in GET_DATA){
  if(!Empty(id)){
    currentname=id
    reload(e)
    if(Ctrl("srcform")) Ctrl("srcform").value=currentname
    if(standalone) document.title=currentname+" - Portlet Editor";
    old_name=currentname;
  }
  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }
  /*
  if(Empty(currentname)){
    document.getElementById('btn_preview').setStyle('opacity',0.2);
    document.getElementById('btn_preview').href='javascript:void(0)';
  }else{
    document.getElementById('btn_preview').setStyle('opacity',1);
    document.getElementById('btn_preview').href='javascript:togglePreview();';
  }*/
  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }
}

function Help(the_property){
  var i;
  var prop='';
  if(typeof(anchorToFeature)!='undefined'){
    if(typeof(the_property)!='undefined')
      prop+="portleteditor_"+the_property.toLowerCase();
    if(prop!='' && prop in anchorToFeature)
      i=anchorToFeature[prop];
    else if(index!=null && "portleteditor_"+itemsHTML[index].type.toLowerCase() in anchorToFeature)
      i=anchorToFeature["portleteditor_"+itemsHTML[index].type.toLowerCase()];
    else
      i=anchorToFeature["portleteditor"];
    windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?'+URLenc(i+(prop!=""?'||'+prop+"":"")),'','toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
  }
}
// seleziona l'item se cliccato
function clickItem(e,elem){
  multipleSelection = false;
  var str="",element;
  if(elem==null)
    element=GetEventSrcElement(e);
  else
    element=elem;
  if(!element.id){
    while(element.parentNode && element.parentNode.id==""){
      element=element.parentNode
    }
    element=element.parentNode
  }
  if(element.id.indexOf('_')>-1) element=Ctrl(element.id.substr(0,element.id.indexOf('_')))
  if(e==null || e.shiftKey==false){
    removeAllHandlers()
  }
  for(var i=0; i<itemsHTML.length; i++){
    if(itemsHTML[i].id==element.id){
      itemsHTML[i].shadow="shadow"+element.id.substr(4);
	  if(container_selection.e.indexOf(i)<0)
		container_selection.e.push(i);
    }
  }
  str=addHandlers(element.id.substr(4))
  Ctrl("canvashandlers").innerHTML=Ctrl("canvashandlers").innerHTML+str
  selectItem(Ctrl("shadow"+element.id.substr(4)))
  //Ctrl("backcanvas").focus()
}

var draggingHandler
var draggingHandlerCorner
var draggedItemIdx
function beginDragHandler(e,itmIdx,corner){
  //if(typeof(hideProperties)!='undefined') hideProperties('properties')
  var handler=GetEventSrcElement(e);
  // memorizza che cosa sta' muovendo
  selectItem(Ctrl("shadow"+itmIdx));
  draggingHandler=handler;
  draggedItemIdx=itmIdx;
  draggingHandlerCorner=corner;
  undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj('item'+itmIdx,'resize',null,null,itemsHTML[index].x,itemsHTML[index].y,itemsHTML[index],null,null,itemsHTML[index].w,itemsHTML[index].h);
  //undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj('item'+itmIdx,'move',null,null,itemsHTML[index].x,itemsHTML[index].y,itemsHTML[index],null,null,null,null);
  // fa in modo che il canvas risponda al movimento del mouse
  if(Empty(e.targetTouches)){
	  Ctrl("canvas").onmousemove=continueDragHandler;
	  Ctrl("canvas").onmouseup=endDragHandler;
  }
  else{
	  handler.addEventListener("touchmove",continueDragHandler);
	  handler.addEventListener("touchend",endDragHandler);
  }
  // blocca la propagazione
  e.cancelBubble=true;
  e.returnValue=false;
}

function beginDragSelection(e){ //REDEFINED
	disableItemButtons();
	removeClassFromItems("highlightField");
	removeClassFromItems("highlightLabel");
	if(ismobile){
		cancelEvent(e);
		return;
	}
  if(typeof(hideProperties)!='undefined') hideProperties('properties')
  if(window.closeEditInput) window.closeEditInput(e);
  var dragstyle=Ctrl("drag").style
  var canvas=Ctrl("canvas")
  e = (e) ? e : window.event;
  var x = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
  var y = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
  x += window.pageXOffset; y += window.pageYOffset;
  x = x - (parseInt(Ctrl("backcanvas").offsetLeft) + parseInt(Ctrl("canvas").offsetLeft)) + parseInt(Ctrl("backcanvas").scrollLeft+parseInt(Ctrl('canvas').scrollLeft))
  y = y - (parseInt(Ctrl("backcanvas").offsetTop) + parseInt(Ctrl("canvas").offsetTop)) + parseInt(Ctrl("backcanvas").scrollTop+parseInt(Ctrl('canvas').scrollTop))
  dragstartx=x
  dragstarty=y
  // mostra il rettangolo di drag
  document.getElementById('drag').set('tween', {duration: '100'});
  document.getElementById('dragcontent').set('tween', {duration: '100'});
  document.getElementById('drag').tween('opacity', 0, 1);
  document.getElementById('dragcontent').tween('opacity',0, 0.3);
  //document.getElementById('drag').setStyle('opacity', 1);
  //document.getElementById('dragcontent').setStyle('opacity',0.3);
  dragstyle.visibility="";
  dragstyle.top=y+'px';
  dragstyle.left=x+'px';
  dragstyle.width=0
  dragstyle.height=0

  container_selection.e = new Array();

  // installa il gestore del mousemove
  canvas.onmousemove=continueDragSelection
  canvas.onmouseup=endDragSelection
  // blocca la propagazione
  cancelEvent(e)
}
function endDragSelection(e){ //REDEFINED
	removeClassFromItems("highlightField");
	removeClassFromItems("highlightLabel");
  var drag=Ctrl("drag")
  // if (drag.offsetWidth <= 2 && drag.offsetHeight <= 2 || Empty(drag)){
    // selectForm()
  // } else {
    findDragItems(e,drag.offsetTop,drag.offsetLeft,drag.offsetWidth-2,drag.offsetHeight-2)
  //}
  //seleziona l elemento se ci sono elementi nell'area scelta
  for (var i=0;i<itemsHTML.length;i++){
    if(itemsHTML[i].shadow!=""){
		if(Ctrl(itemsHTML[i].shadow)){
			selectItem(Ctrl(itemsHTML[i].shadow))
		}
      break
    }
  }
  // nasconde il rettangolo di drag
  document.getElementById('drag').set('tween', {duration: '100'});
  document.getElementById('dragcontent').set('tween', {duration: '100'});
  document.getElementById('drag').tween('opacity', 1, 0);
  document.getElementById('dragcontent').tween('opacity', 0.3, 0);
  //document.getElementById('drag').setStyle('opacity',0);
  //document.getElementById('dragcontent').setStyle('opacity',0);
  drag.style.visibility="hidden";
  Ctrl("canvas").onmousemove=null
  Ctrl("canvas").onmouseup=null
  if(typeof(showProperties)!='undefined') showProperties('properties')
  //refreshToolTips();
}

function continueDragHandler(e){
  var itm=Ctrl('item'+draggedItemIdx)
  var shadow=Ctrl('shadow'+draggedItemIdx)
  var x,y,w,h
  var mainItem=itemsHTML[index]
  var delta = [];   //array che conterr� la dimensione dello spostamento che viene effettuato sulla shadow
    /*delta[0] = dleft
        delta[1] = dtop
        delta[2] =dright
        delta[3] =dbottom
     */
  //GM
  var xfunction
  var yfunction
  if(mainItem.objClass.newProperties){
	var c = 0;
	for(var i in mainItem.objClass.newProperties){
		var tab = mainItem.objClass.newProperties[i];
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
  //GM
  	var borders = (viewMode!=designView)?0:0;
  	y=getY(itm)-Ctrl('backcanvas').offsetTop+borders;
  	x=getX(itm)-Ctrl('backcanvas').offsetLeft+borders;
   //x=itm.offsetLeft
   //y=itm.offsetTop
   w=itm.offsetWidth
   h=itm.offsetHeight
   var hgap = h - itm.clientHeight //dimensione  bordi margin e padding
   var wgap = w - itm.clientWidth//dimensione minima senza bordi margin e padding
  //
  e = (e) ? e : window.event;
  if(Empty(e.targetTouches)){
	  newx = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
	  newy = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
  }
  else{
	  newx = (e.targetTouches[0].pageX)? e.targetTouches[0].pageX: (e.targetTouches[0].clientX)? e.targetTouches[0].clientX: 0;
	  newy = (e.targetTouches[0].pageY)? e.targetTouches[0].pageY: (e.targetTouches[0].clientY)? e.targetTouches[0].clientY: 0;
  }

  newx = parseInt(newx) - (Ctrl("backcanvas").offsetLeft + Ctrl("canvas").offsetLeft) + Ctrl("backcanvas").scrollLeft
  newy = parseInt(newy) - (Ctrl("backcanvas").offsetTop+ Ctrl("canvas").offsetTop) + Ctrl("backcanvas").scrollTop
  //
  var dh=0;
  var dw=0;
  switch (draggingHandlerCorner) {
    case  0:
      // Angolo sinistro sopra
      if (newx<x+w-wgap && newy<y+h-hgap) { //controllo che non possa essere collassato il componente a una dimensione minore alle sue dimensioni minime
         delta[0] = newx-shadow.offsetLeft
         delta[1] = newy-shadow.offsetTop
         delta[2] = 0
         delta[3] = 0
         if(canAlign)delta = drawSnap(delta,true)
        dw = - delta[0]
        dh = -delta[1]
      }
    break
    case  1:
      // Angolo destro sopra
      if (newx>x+wgap && newy<y+h-hgap) {
        // sposta l' handler
         delta[0] = 0
         delta[1] = newy-shadow.offsetTop
         delta[2] = newx-(shadow.offsetLeft+getOffset(shadow).w)
         delta[3] = 0
         if(canAlign)delta = drawSnap(delta,true)
        dw = delta[2]
        dh  = - delta[1]
      }
    break
    // Angolo destro sotto
    case 2:
      if (newx>x+wgap && newy>y+hgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = 0
        delta[2] = newx-(shadow.offsetLeft+getOffset(shadow).w)
        delta[3] = newy-(shadow.offsetTop+getOffset(shadow).h)
        if(canAlign)delta = drawSnap(delta,true)
        dw = delta[2]
        dh = delta[3]
      }
    break
    // Angolo sinistro sotto
    case 3:
      if (newy>y+hgap && newx<x+w-wgap) {
        // sposta l' handler
        delta[0] = newx-shadow.offsetLeft
        delta[1] = 0
        delta[2] = 0
        delta[3] = newy-(shadow.offsetTop+getOffset(shadow).h)
        if(canAlign)delta = drawSnap(delta,true)
        dw = - delta[0]
        dh = delta[3]
      }
    break
    // Lato sotto
    case 6:
      if (newy>y+hgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = 0
        delta[2] = 0
        delta[3] = newy-(shadow.offsetTop+getOffset(shadow).h)
        if(canAlign)delta = drawSnap(delta,true)
        dw = 0;
        dh = delta[3]
      }
    break
    // Lato sopra
    case 4:
      if (newy<y+h-hgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = newy-shadow.offsetTop
        delta[2] = 0
        delta[3] = 0
        if(canAlign)delta = drawSnap(delta,true)
        dw = 0;
        dh = - delta[1]
      }
     break
    // Lato sx
    case 7:
      if(newx<x+w-wgap) {
        // sposta l' handler
        delta[0] = newx-shadow.offsetLeft
        delta[1] = 0
        delta[2] = 0
        delta[3] = 0
        if(canAlign)delta = drawSnap(delta,true)
        dw =  -delta[0]
        dh = 0;
      }
    break
    // Lato dx
    case 5:
      if (newx>x + wgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = 0
        delta[2] = newx-(shadow.offsetLeft+getOffset(shadow).w)
        delta[3] = 0
        if(canAlign)delta = drawSnap(delta,true)
        dw = delta[2]
        dh = 0;
      }
    break
  }
  //Spostamento e ridimensionamento
    //
    var xs=shadow.offsetLeft
    var ys=shadow.offsetTop
    var ws = getOffset(shadow).w
    var hs= getOffset(shadow).h

	//MG 20120305 beg
	var ret = true;
	if(window.ValidMove) {
		ret = window.ValidMove(shadow.offsetLeft+delta[0], shadow.offsetTop+delta[1], ws+dw, hs+dh, itm.id, mainItem, draggingHandlerCorner)
	}
	if(ret==false)
		return;
	//MG 20120305 beg

    w = itm.offsetWidth
    h= itm.offsetHeight
    var xi = itm.offsetLeft
    var yi = itm.offsetTop
    var hi = getOffset(itm).h
    var wi = getOffset(itm).w
    //
    xs = x + (delta[0] ? delta[0]: 0);
    ys = y + (delta[1] ? delta[1] : 0);
    xi = xi + (delta[0] ? delta[0]: 0);
    yi = yi + (delta[1] ? delta[1] : 0);
    //
    hs = (hs+dh) >=0 ? (hs +dh): 0;
    ws = (ws+dw)>=0 ? (ws+dw): 0;
    hi = (hi+dh) >=0 ? (hi +dh): 0;
    wi = (wi+dw)>=0 ? (wi+dw): 0;
    // h= shadow.offsetHeight
    // w= shadow.offsetWidth
    h = (h+dh) >=0 ? (h +dh): 0;
    w = (w+dw)>=0 ? (w+dw): 0;
    //

	if(window.AdjustItem){
		var tmp = window.AdjustItem(ws,hs,draggedItemIdx);
		ws = tmp.ws;
		hs = tmp.hs;
		wi = tmp.wi;
		hi = tmp.hi;
	}

   // resize della shadow
	shadow.style.width=ws+'px';
	shadow.style.height=hs+'px';
	shadow.style.top=ys+'px';
	shadow.style.left=xs+'px';
  // modifica l' item
	itm.style.width=wi+'px';
	itm.style.height=hi+'px';
	itm.style.top=yi+'px';
	itm.style.left=xi+'px';
  // salvo le proprieta nell oggetto item
	mainItem.w=shadow.offsetWidth
	mainItem.h=shadow.offsetHeight
	mainItem.x=xi
	mainItem.y=yi
  if(viewMode && viewMode!=designView)
    mainItem.yRel=yi

    // var w=shadow.offsetWidth
    // var h=shadow.offsetHeight

	var shadowH = (hs>0 ? hs: 0 ) +8;  //tolgo i due pixel dei bordi
	var shadowW = (ws>0 ? ws : 0 ) +8;  //tolgo i 2 pixel dei bordi

	Ctrl("handlersWrapper"+draggedItemIdx).style.top = (shadow.offsetTop-9) +'px';
	Ctrl("handlersWrapper"+draggedItemIdx).style.left = (shadow.offsetLeft-9)+'px';
	Ctrl("handlersWrapper"+draggedItemIdx).style.height = (shadowH+12)+'px'
	Ctrl("handlersWrapper"+draggedItemIdx).style.width = (shadowW+12)+'px'
	Ctrl("handler"+draggedItemIdx+"_5").style.top = ((shadowH+4)/2)+'px'; //bordi
	if(Ctrl("handler"+draggedItemIdx+"_6"))
		Ctrl("handler"+draggedItemIdx+"_6").style.top = ((shadowH+12)-16)+'px'; //posizionamento relativo  (16 = (size+2)*2)
	if(Ctrl("handler"+draggedItemIdx+"_7"))
		Ctrl("handler"+draggedItemIdx+"_7").style.top = ((shadowH+4)/2)+'px';
	// document.getElementById('bn').value +=   '\n 5-7:'+(shadowH/2 -7 )+' 6:'+(shadowH- 18)+' T:'+shadowH

	var calcw=parseInt(shadow.offsetWidth);
	var calch=parseInt(shadow.offsetHeight);
	if(typeof(xfunction)!='undefined')
		eval("calcw="+xfunction+"(calcw)")
	if(typeof(yfunction)!='undefined')
		eval("calch="+yfunction+"(calch)")
	var strp = "w="+(calcw)+"&nbsp;"+"h="+(calch)
	shadow.innerHTML="<div style='position:relative;left:5px;top:-12px' ondragstart='noDefaultDrag(event)' onselectstart='noDefaultDrag(event)'>"+strp+"</div>"
    EmptyRefLines();
    addRulersLines();
}

function endDragHandler(){
  //tolgo gli allineamenti e le selected_shadow
  resetAlign();
  var shadow=Ctrl('shadow'+draggedItemIdx);
  shadow.innerHTML="";

  //if(window.pushToHistory) window.pushToHistory();
  if(window.AdjustMove) window.AdjustMove(itemsHTML[draggedItemIdx]);
  if(window.pushToHistory) window.pushToHistory();

  //salvo le proprieta nell oggetto item
  Properties();
  Ctrl("canvas").onmousemove=null;
  Ctrl("canvas").onmouseup=null;
  m_bUpdated=true;
  if(undoItemsMoved.length>0 && index){
    //Necessari per il Redo
    undoItemsMoved[undoItemsMoved.length-1].x = itemsHTML[index].x;
    undoItemsMoved[undoItemsMoved.length-1].y = itemsHTML[index].y;
    undoItemsMoved[undoItemsMoved.length-1].w = itemsHTML[index].w;
    undoItemsMoved[undoItemsMoved.length-1].h = itemsHTML[index].h;
    indexUndo++;
    undoSequence[indexUndo]=undoItemsMoved;
    CheckUndoSize();
    undoItemsMoved=[];
  }
  if(typeof(showProperties)!='undefined') showProperties('properties');
}


function addHandlers(itmIdx){ //REDEFINED
  var itm=document.getElementById("item"+itmIdx),itmobj;
  var yi=itm.offsetTop
  var xi=itm.offsetLeft
  var wi=itm.offsetWidth
  var hi=itm.offsetHeight
  var str=""

  var shadowH = ((hi-2)>0 ? hi-2 : 0 );  //tolgo i due pixel dei bordi
  var shadowW = ((wi-2 )>0 ? wi-2 : 0 );  //tolgo i 2 pixel dei bordi
  var wrapperH = shadowH +8; //dimensioni del wrapper che contiene gli handler
  var wrapperW = shadowW +8; //dimensioni del wrapper che contiene gli handler

  /*
                0-----4-----1
                |                  |
               7                 5
                |                  |
               3-----6------2
  */
  // aggiunge il div shadow+n della grandezza dell item per lo spostamento
  str += "<div id='handlersWrapper"+itmIdx+"' style='margin:0;z-index:2;position:absolute;overflow:hidden;height:"+wrapperH+"px;width:"+wrapperW+"px;top:"+(yi-3)+"px;left:"+(xi-3)+"px;background:transparent;'>"

  str+=addHandler (0                       ,itmIdx,0)//su-sin
  str+=addHandler (0                       ,itmIdx,1)//su-dx
  str+=addHandler (wrapperH       ,itmIdx,2)//gi�-dx
  str+=addHandler (0                       ,itmIdx,3)//gi�-sx
  str+=addHandler (0                       ,itmIdx,4)
  str+=addHandler (wrapperH/2     ,itmIdx,5)
  str+=addHandler (wrapperH        ,itmIdx,6)
  str+=addHandler (wrapperH/2     ,itmIdx,7)
  str+="</div><div  id='shadow"+itmIdx+"' class='shadow " + viewMode + "' style='margin:0;position:absolute;top:"+yi+"px;left:"+xi+"px;width:"+shadowW+"px;height:"+shadowH+"px;' onmousedown='dragShadow(event);' ondblclick='editItemEvent(event,this)'>"
      str+="&nbsp;";
  str+="</div>";
    //configuro le dimensioni per gli allineamenti seguendo le caratteristiche della shadow
  if(!multipleSelection){
     not_selected = [];
     container_selection.t = yi;
     container_selection.l=xi;
     container_selection.w=shadowW +2;
     container_selection.h=shadowH +2;
     container_selection.b=yi+shadowH +2;
     container_selection.r=xi+shadowW +2;
    for(var i=0; i<itemsHTML.length; i++){
      itmobj=itemsHTML[i];
      itm = document.getElementById(itemsHTML[i].id);
      if(itm && Empty(itemsHTML[i].shadow) && itm.style.display!='none' && !itmobj.hidden) not_selected.push(i);
    }
  }
  return str;

}
function addHandler(y,itmIdx,corner){ //REDEFINED
  var cursorStyle = ""
  var moveControl = ""
  var margin = "";
  var position =""
  var floating =""
  var left= ""
  var top= ""
  var right =""
  var bottom=""
  var size = 6;
  //itemresizable = (itemsHTML[index].type != "SPLinker" && itemsHTML[index].type != "SQLDataobj")
	switch(corner){
		case 0:
			position = "absolute";
			floating='left'
			top = 0
			left = 0
			break;
		case 1:
			position = "absolute";
			floating='left'
			top = 0
			right = 0
			break;
		case 2:
			position = "absolute";
			floating='left'
			bottom = 0
			right = 0
			break;
		case 3:
			position = "absolute";
			floating='left'
			bottom= 0;
			left = 0
			break;
		case 4:
			position='relative'
			margin = '0 auto';
			top = 0;
			break;
		case 5:
			position = "absolute";
			floating='right'
			right = 0
			top = y-((size+2)/2);
			break;
		case 6:
			position = "relative";
			margin= '0 auto';
			top = y-((size+2)*2);
			break;
		case 7:
			position = "absolute";
			floating ='left'
			top = y-((size+2)/2);
			break;
	}
  var handlerc = "handlerclass"
  var f = false;
  if (corner == 0 || corner == 2)
    cursorStyle = "cursor:nw-resize"
  else if(corner==4 || corner==6) {
    cursorStyle = "cursor:n-resize"
    if(corner==4)
      handlerc = "handlerclasstp htop";
    else
      handlerc = "handlerclasstp hbottom";
    f = true;
  }
  else if(corner==5 || corner==7) {
     cursorStyle = "cursor:w-resize"
    if(corner==5)
      handlerc = "handlerclasslr hright";
    else
      handlerc = "handlerclasslr hleft";
    f = true;
  }
  else
    cursorStyle = "cursor:ne-resize"

    moveControl = " onmousedown='beginDragHandler(event,"+itmIdx+","+corner+")'";
    moveControl += " ontouchstart='beginDragHandler(event,"+itmIdx+","+corner+")'";

  var v;
  //controllo che  l'item abbia dimensioni sufficienti per avere gli handler
  if(!f) {
    v = "<div class='" + handlerc + "' id='handler"+itmIdx+"_"+corner+"' style='float:"+floating+"; "+cursorStyle+"; z-index:5; position:"+position+"; top:"+top+"px;  bottom:"+bottom+"px;"+ " left:"+left+"; right:"+right+"; margin:"+margin+";' "+ moveControl + ">&nbsp</div>"
    return v
  }
  else {
    v = "<div class='" + handlerc + "' id='handler"+itmIdx+"_"+corner+"' style='top:"+ top + "px;' " + moveControl + ">&nbsp</div>";
    return v;
  }
}
function selectItem(itm){ // REDEFINED
  SetOnEditProp(false);
  var selecteditem,n
  mainitem=itm;
  selecteditem=mainitem.id.substr(6);

  if(index==selecteditem) return;

  for(var i=0;i<itemsHTML.length;i++){
    if (itemsHTML[i].shadow==mainitem.id)
      index=i
  }

  if(changeselectshadow==true)
	document.getElementById("shadow"+selecteditem).className = 'shadow ' + viewMode;//setStyle('opacity',1);
  for (var p=0;p<itemsHTML.length;p++){
    if(itemsHTML[p].shadow!=mainitem.id && itemsHTML[p].shadow!="" && Ctrl(itemsHTML[p].shadow)){
      // elemento ennesimo nell'array
      n=Ctrl(itemsHTML[p].shadow).id.substr(6)
	  if(changeselectshadow==true && !ismobile)
		document.getElementById("shadow"+n).className = 'shadowother ' + viewMode;//.setStyle('opacity',0);
		if(container_selection.e.indexOf(p)<0) container_selection.e.push(p)
    }
  }

  Properties()
  EmptyRefLines();
  addRulersLines();
}

// Funzioni di inserimento nuovo item
var type="";
function addItem(item) {
  type=item;
  document.body.style.cursor="crosshair";
  selectForm();
  Ctrl("canvas").onmousedown=putItem;
}

var xxpos // for insert image dialog
var yypos

function putItem(e,b_reload,paste){
  if(Empty(type) || type=='Form') return;
  var xpos=0;
  var ypos=0 ;
  // var wait=false;
  e = (e) ? e : window.event;
  if(e!=null){
    xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
    xpos = parseInt(xpos) - (Ctrl("backcanvas").offsetLeft + Ctrl("canvas").offsetLeft)
    ypos = parseInt(ypos) - (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop)
  }
  var html;
  var divContainer = document.createElement('div');
  switch(type){
    case "Box":
      html='<div id=\'item'+nitem+'\' style=\'margin:0;position:absolute;top:'+ypos+'px;left:'+xpos+'px;width:120px;height:120px;background-color:white;\' onselectstart=\'noDefaultDrag(event)\' onclick=\'clickItem(event)\' onmousedown=\'putItem();\'><img src="images/trasparent.gif" width="100%" height="100%"/></div>'
      itemsHTML[countindex]=new ZTObjects.boxObj("item"+nitem,"Box"+nitem,"Box",html," ","",xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Textbox":
      itemsHTML[countindex]=new ZTObjects.inputObj('item'+nitem,'Textbox'+nitem,'Textbox','<input type=text readonly=\'true\' value=\'Textbox'+nitem+'_______________\' id=\'item'+nitem+'\' style=\'margin:0;border:1px solid #454545;padding:2px;overflow:hidden;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;\' onselectstart=\'noDefaultDrag(event)\' onclick=\'clickItem(event)\'/>',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Variable":
      itemsHTML[countindex]=new ZTObjects.variableObj('item'+nitem,'Variable'+nitem,'Variable','<input type=text readonly=\'true\' value=\'Variable'+nitem+'_______________\' id=\'item'+nitem+'\'  style=\'margin:0;border:1px solid #454545;padding:2px;overflow:hidden;z-index:1;background-Color:buttonface;position:absolute;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' />',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Button":
      itemsHTML[countindex]=new ZTObjects.buttonObj('item'+nitem,'button'+nitem,'Button',"<input type=\'button\' value=\'Button\' id=\'item"+nitem+"\' onselectstart=\'noDefaultDrag(event)\' style=\'margin:0;border:0;height:20px;width:65px;overflow:hidden;z-index:1;position:absolute;top:"+ypos+"px;left:"+xpos+"px;\' onclick='clickItem(event)'\ />",'Button','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Label":
      itemsHTML[countindex]=new ZTObjects.labelObj('item'+nitem,'label'+nitem,'Label','<div id=\'item'+nitem+'\' onselectstart=\'noDefaultDrag(event)\' style=\'margin:0;overflow:hidden;z-index:1;textAlign:right;position:absolute;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\'><div id=\'item'+nitem+'_int\'>Label text</div></div>','Label text','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Note":
      itemsHTML[countindex]=new ZTObjects.noteObj('item'+nitem,'note'+nitem,'Note','<textarea readonly=\'true\' id=\'item'+nitem+'\' style=\'margin:0;border:1px solid #E08018;font-family:monospace;background-color:#F8E44F;color:#232323;box-shadow:rgba(255,255,255,.3) 0px 2px 8px;padding:2px;overflow:hidden;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;\' onselectstart=\'noDefaultDrag(event)\' onclick=\'clickItem(event)\'></textarea>',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
    break
    case "Image":
      //var localsrc=""
      // wait=true
      // if(!b_reload && !paste){
        // var WinOpener=OpenWindow("../servlet/SPImagePicker?RootDir=images&CanInsert=S&imgnew=true&retTo=src",580,620,xpos,ypos,'Images');
        // xxpos=xpos;
        // yypos=ypos;
      // } else {
        //if(localsrc!=null){
          itemsHTML[countindex]=new ZTObjects.imageObj('item'+nitem,'image'+nitem,'Image','<img id=\'item'+nitem+'\' src=\'\' style=\'margin:0;z-index:1;position:absolute;width:10px;height:10px;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' title=\'\' alt=\'Image not found\' />',' ','',xpos,ypos);
          nitem++
          countindex++
          divContainer.innerHTML=itemsHTML[countindex-1].html;
          Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
          divContainer=null;
          itemsHTML[countindex-1].h=(Empty(Ctrl("item"+(nitem-1)).offsetHeight)?30:Ctrl("item"+(nitem-1)).offsetHeight);
          itemsHTML[countindex-1].w=(Empty(Ctrl("item"+(nitem-1)).offsetWidth)?30:Ctrl("item"+(nitem-1)).offsetWidth);
          //itemsHTML[countindex-1].localsrc=localsrc;
        //}
        // wait=false
      // }
    break
    case "SQLDataobj":
      itemsHTML[countindex]=new ZTObjects.dataObj('item'+nitem,'dataobj'+nitem,'SQLDataobj','<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/desk_dataobj_sql.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;height:30px;width:30px;\' onclick=\'clickItem(event)\' />',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "XMLDataobj":
      itemsHTML[countindex]=new ZTObjects.xmlObj('item'+nitem,'xmlobj'+nitem,'XMLDataobj','<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/desk_dataobj_xml.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;height:30px;width:30px;\' onclick=\'clickItem(event)\' />',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "SPLinker":
      itemsHTML[countindex]=new ZTObjects.splinkerObj('item'+nitem,'splinker'+nitem,'SPLinker','<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/desk_splink.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;height:30px;width:30px;\' onclick=\'clickItem(event)\' />',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Chart":
      itemsHTML[countindex]=new ZTObjects.chartObj('item'+nitem,'chart'+nitem,'Chart','<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/desk_graphics.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;height:40px;width:40px;\' onclick=\'clickItem(event)\' />',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Grid":
      html='<div id=\'item'+nitem+'\' style="margin:0;overflow:hidden;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;height:160px;width:120px;" onselectstart=\'noDefaultDrag(event)\' onclick=\'clickItem(event)\'><table  id=\'item'+nitem+'_table\' border=1 bordercolor=gray bgcolor=white cellspacing=0 cellpadding=0 width=\'100%\' height=\'100%\'><tr align=center valign=top onClick=\'clickItem(event)\'>'
      html+='<td bgcolor="white" onclick=\'clickItem(event)\'></td>'
      html+='</tr></table></div>'
      //itemsHTML[countindex]=new gridObj('item'+nitem,'Grid'+nitem,'Grid','<img id=\'item'+nitem+'\' src=\'grid.bmp\' style=\'margin:0;position:absolute;top:'+ypos+';left:'+xpos+';height:30;width:30\' onClick=\'clickItem(event)\'>',' ','',xpos,ypos);
      itemsHTML[countindex]=new ZTObjects.gridObj('item'+nitem,'Grid'+nitem,'Grid',html,' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Tabs":
      html='<div id=\'item'+nitem+'\' style="margin:0;overflow:hidden;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;width:60px;" onclick=\'clickItem(event)\'>'
      html+='<table id=\'item'+nitem+'_tab\' border="0" cellspacing="2" cellpadding="1" width="100%" height="100%"><tr height="10" align="center">'
      html+='<td bgcolor="white" onclick=\'clickItem(event)\'>---</td>'
      html+='</tr></table></div>'
      itemsHTML[countindex]=new ZTObjects.tabsObj('item'+nitem,'Tabs'+nitem,'Tabs',html,' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Iframe":
      html='<div id=\'item'+nitem+'\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;width:120px;height:120px;background-color:transparent;border:1px solid black;\' onclick=\'clickItem(event)\'><img src="images/trasparent.gif" width="100%" height="100%"></div>'
      itemsHTML[countindex]=new ZTObjects.iframeObj('item'+nitem,'Iframe'+nitem,'Iframe',html,' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Portlet":
      html='<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/portlet.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;height:40px;width:40px;\' onclick=\'clickItem(event)\' />'
      itemsHTML[countindex]=new ZTObjects.portletObj('item'+nitem,'Portlet'+nitem,'Portlet',html,' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Checkbox":
      html='<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/checkbox.gif\' style=\'margin:0;z-index:1;position:absolute;width:13px;height:13px;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' />'
      itemsHTML[countindex]=new ZTObjects.checkboxObj('item'+nitem,'Checkbox'+nitem,'Checkbox',html,' ','',xpos,ypos,13,13);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Combobox":
      html='<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/select.gif\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;width:73px;height:20px;\' onclick=\'clickItem(event)\' />'
      itemsHTML[countindex]=new ZTObjects.comboboxObj('item'+nitem,'Combobox'+nitem,'Combobox',html,' ','',xpos,ypos,98,228);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "DataMasher":
      html='<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/DataMasher.png\' style=\'margin:0;z-index:1;position:absolute;width:30px;height:30px;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' />'
      itemsHTML[countindex]=new ZTObjects.datamasherObj('item'+nitem,'Datamasher'+nitem,'DataMasher',html,' ','',xpos,ypos,98,228);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "StdTreeView":
      html='<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/TreeView.gif\' style=\'margin:0;z-index:1;position:absolute;width:130px;height:194px;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' />'
      itemsHTML[countindex]=new ZTObjects.stdtreeviewObj('item'+nitem,'StdTreeView'+nitem,'StdTreeView',html,' ','',xpos,ypos,98,228);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "Radio":
      html='<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/radio.gif\' style=\'margin:0;z-index:1;position:absolute;width:164px;height:83px;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' />'
      itemsHTML[countindex]=new ZTObjects.radioObj('item'+nitem,'Radio'+nitem,'Radio',html,' ','',xpos,ypos,98,228);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    case "EventReceiver":
      html='<img id=\'item'+nitem+'\' alt="EventReceiver" src=\'../portalstudio/images/component/EventReceiver.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' />';
      itemsHTML[countindex]=new ZTObjects.EventReceiverObj('item'+nitem,'EventReceiver'+nitem,'EventReceiver',html,' ','',xpos,ypos,22,20);
      nitem++;
      countindex++;
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
    break;
    case "EventEmitter":
      html='<img id=\'item'+nitem+'\' alt="EventEmitter" src=\'../portalstudio/images/component/EventEmitter.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\' />';
      itemsHTML[countindex]=new ZTObjects.EventEmitterObj('item'+nitem,'EventEmitter'+nitem,'EventEmitter',html,' ','',xpos,ypos,22,20);
      nitem++;
      countindex++;
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
    break;
    case "SQLTotalizer":
      itemsHTML[countindex]=new ZTObjects.SQLTotalizer('item'+nitem,'SQLTotalizer'+nitem,'SQLTotalizer','<img id=\'item'+nitem+'\' src=\'../portalstudio/images/component/desk_dataobj_tot.png\' style=\'margin:0;z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;height:30px;width:30px;\' onclick=\'clickItem(event)\' />',' ','',xpos,ypos);
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=Ctrl("item"+(nitem-1)).offsetHeight
      itemsHTML[countindex-1].w=Ctrl("item"+(nitem-1)).offsetWidth
    break
    default:
      var src // eslint-disable-line no-unused-vars
      eval("src=ZTObjects."+type+"Class.names[1]")
      // new custom item
      eval("itemsHTML[countindex]=new ZTObjects."+type+"('item'+nitem,'"+type+"'+nitem,'"+type+"','<img id=item'+nitem+' src='+String.fromCharCode(39)+src+String.fromCharCode(39)+' style='+String.fromCharCode(39)+'position:absolute;z-index:1;top:'+ypos+'px;left:'+xpos+'px;'+String.fromCharCode(39)+' alt='+String.fromCharCode(39)+'"+type+"'+String.fromCharCode(39)+' onclick='+String.fromCharCode(39)+'clickItem(event)'+String.fromCharCode(39)+' />',' ','',xpos,ypos)")
      nitem++
      countindex++
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=(Empty(Ctrl("item"+(nitem-1)).offsetHeight)?30:Ctrl("item"+(nitem-1)).offsetHeight);
      itemsHTML[countindex-1].w=(Empty(Ctrl("item"+(nitem-1)).offsetWidth)?30:Ctrl("item"+(nitem-1)).offsetWidth);
    break
  }
  itemsHTML[countindex-1].page=formProp.page; //imposta la pagina corrente
  if(!b_reload && Empty(itemsHTML[countindex-1].sequence)) itemsHTML[countindex-1].sequence=++sequence_c;
  document.body.style.cursor="default";
  Ctrl("canvas").onmousedown=beginDragSelection;
  if (!b_reload) {
    index = countindex-1;
    writeHTML(paste);
    index=null;
    clickItem(null,document.getElementById("item"+(nitem-1)));
    m_bUpdated=true;
  }
  if(type!='Image' || b_reload)
    type='Form';
}

function InsertImageDone(localsrc,imgnew,retTo){
  if(localsrc!=null){
    if(imgnew=='true'){
      var xpos = xxpos;
      var ypos = yypos;
      itemsHTML[countindex]=new ZTObjects.imageObj('item'+nitem,'image'+nitem,'Image','<img id=\'item'+nitem+'\' src=\'\' style=\'z-index:1;position:absolute;top:'+ypos+'px;left:'+xpos+'px;\' onclick=\'clickItem(event)\'>',' ','',xpos,ypos);
      nitem++
      countindex++
      var divContainer = document.createElement('div');
      divContainer.innerHTML=itemsHTML[countindex-1].html;
      Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
      divContainer=null;
      itemsHTML[countindex-1].h=(Empty(Ctrl("item"+(nitem-1)).offsetHeight)?30:Ctrl("item"+(nitem-1)).offsetHeight);
      itemsHTML[countindex-1].w=(Empty(Ctrl("item"+(nitem-1)).offsetWidth)?30:Ctrl("item"+(nitem-1)).offsetWidth);
      itemsHTML[countindex-1][retTo]=localsrc
      index = countindex-1;
    }else
      itemsHTML[index][retTo]=localsrc
  }
  if(type!='Form'){
    itemsHTML[countindex-1].page=formProp.page //imposta la pagina corrente
    itemsHTML[countindex-1].sequence=++sequence_c;
  }
  writeHTML()
  document.body.onfocus = null
  type="Form";
}

//riscrive l'HTML e reimposta tutte le propriet� di tutti gli items
function writeHTML(reset) {
  if(Empty(reset)) reset=false;
  var form=Ctrl("backcanvas")
  if(!EmptyString(formProp.color)){
    try {
      form.style.backgroundColor=formProp.color;
      if(formProp.color=='transparent')
        document.getElementById('backcanvasBorder').style.backgroundColor='transparent';
      else
        document.getElementById('backcanvasBorder').style.backgroundColor='#383';
    } catch (e) {}
  }else{
    form.style.backgroundColor='';
    document.getElementById('backcanvasBorder').style.backgroundColor='transparent';
  }
  if(!EmptyString(formProp.bg_image))
    form.style.backgroundImage='url('+formProp.bg_image+')'
  else
    form.style.backgroundImage=''
  if(formProp.w.indexOf('%')>0 && EmptyString(formProp.v_line)) {formProp.v_line='400';Ctrl("v_line").style.display='block';}
  if(formProp.v_line>0){
    Ctrl("v_line").style.display='block'
    v_line=formProp.v_line
    Ctrl("v_line").style.left=((formProp.v_line-0)+form.offsetLeft+Ctrl("canvas").offsetLeft)+'px';
    Ctrl("v_line").style.height = Ctrl('canvas').offsetHeight-Ctrl('h_ruler').offsetTop+'px';
  }else{
    v_line=formProp.v_line
    Ctrl("v_line").style.display='none'
  }
  if(Ctrl("v_line").style.display=='block' && formProp.w.indexOf('%')>0){
    form.style.width=(Ctrl("v_line").offsetLeft-Ctrl("canvas").offsetLeft-form.offsetLeft)*(Strtran(formProp.w,'%','')/100)+'px';
  }else{
    form.style.width=formProp.w+'px'
  }
  form.style.height=formProp.h+'px'
  document.getElementById('backcanvasBorder').style.width=document.getElementById('backcanvas').getSize().x+'px'
  document.getElementById('backcanvasBorder').style.height=document.getElementById('backcanvas').getSize().y+'px'
  if(clVRRulersLib)clVRRulersLib.DrawVertical(document.getElementById('backcanvas').getSize().y);
  if(clHRRulersLib)clHRRulersLib.DrawHorizontal(document.getElementById('backcanvas').getSize().x);
  if(formProp['lock_items']=='true')
    lockItems=true;
  else
   lockItems=false;
  if(reset){
    Ctrl("canvasitems").innerHTML="";
    Ctrl("canvasitems").style.height="0px"
    removeAllHandlers()
  }
  //Aggiunge l'HTML ai controls
  var ctrl,ctrlS,currObj;
  if(reset){
    var s=Ctrl("canvasitems").innerHTML
    for (var i=0;i<itemsHTML.length;i++){
      s+=itemsHTML[i].html
    }
    Ctrl("canvasitems").innerHTML=s
  }
  i=0;
  if(!reset && index!=null){//c'� un item selezionato
    ctrlS=Ctrl('shadow'+itemsHTML[index].id.substr(4));
    i=index;
  }
  if(formProp.hsl=='true')
    canAlign=false;// Disabilita le SnapLines
  else
    canAlign=true;
  var tbl, t, columns;
  for(;i<itemsHTML.length;i++){
    if(!reset && index!=null && i>index) break;// Aggiorno solo il selezionato
    currObj=itemsHTML[i];
    ctrl=Ctrl(currObj.id);
    ctrl.style.display="none"
    if(currObj.page==formProp.page){
      ctrl.style.display="block"
      //Posizionamenti - muovo la shadow se l'item � selected
      if(ctrlS!=null && i==index){
        ctrlS.style.left=currObj.x+'px';
        ctrlS.style.top=currObj.y+'px';
        ctrlS.style.width=(currObj.w-getOffset(ctrlS).gapw)+'px';
        ctrlS.style.height=(currObj.h-getOffset(ctrlS).gaph)+'px';
      }
      ctrl.style.left=currObj.x+'px';
      ctrl.style.top=currObj.y+'px';
      ctrl.style.width=(currObj.w-getOffset(ctrl).gapw)+'px';
      ctrl.style.height=(currObj.h-getOffset(ctrl).gapw)+'px';
      if(currObj.type=="Textbox" || currObj.type=="Variable"){
        ctrl.value=currObj.name+"_________________"
        ctrl.readOnly=true
        if(currObj.visible=="false") ctrl.style.backgroundColor="buttonface"
        if(!EmptyString(currObj.zindex)) ctrl.style.zIndex=currObj.zindex
        ctrl.style.fontFamily=Trim(currObj.font);
        try{ctrl.style.color=Trim(currObj.font_color);}catch(e){}
        ctrl.style.fontSize=Trim(currObj.font_size);
        if(!EmptyString(currObj.class_Css)) ctrl.className=currObj.class_Css;
      }
      if(currObj.type=="Box"){
        ctrl.style.backgroundColor=Trim(currObj.bg_color);
        if(!Empty(currObj.border_color)){
          if(!Empty(currObj.border_weight)){ try{ctrl.style.border=currObj.border_weight+'px solid '+currObj.border_color;}catch(e){};}
        }
        if(!EmptyString(currObj.zindex)) ctrl.style.zIndex=currObj.zindex
        if(!EmptyString(currObj.class_Css)) ctrl.className=currObj.class_Css;else ctrl.className='';
        ctrl.style.width=(currObj.w-getOffset(ctrl).gapw)+'px';
        ctrl.style.height=(currObj.h-getOffset(ctrl).gapw)+'px';
      }
      if(!Empty(currObj.value) && currObj.type=="Label"){
        var ctrl2=Ctrl(currObj.id+'_int')
        if(currObj.value.indexOf('request:')>-1)
          ctrl2.innerHTML=currObj.name
        else
          ctrl2.innerHTML=currObj.value
        ctrl2.style.fontFamily=Trim(currObj.font);
        try{ctrl2.style.color=Trim(currObj.font_color);}catch(e){}
        ctrl2.style.fontSize=Trim(currObj.font_size);
        ctrl2.style.fontWeight= Trim(currObj.font_weight);
        ctrl.style.backgroundColor=Trim(currObj.bg_color);
        if(!EmptyString(currObj.align)) ctrl2.align=currObj.align;
        if(!EmptyString(currObj.class_Css)) ctrl2.className=currObj.class_Css;
        if(!EmptyString(currObj.zindex)) ctrl.style.zIndex=currObj.zindex;
      }
      if(!Empty(currObj.value) && currObj.type=="Note"){
        ctrl.value=currObj.value
        ctrl.readOnly=true
        try{ctrl.style.color=Trim(currObj.font_color);}catch(e){}
        ctrl.style.backgroundColor=Trim(currObj.bg_color);
      }
      if(!Empty(currObj.value) && currObj.type=="Button"){
        ctrl.value=currObj.value;
        ctrl.style.fontFamily=Trim(currObj.font);
        ctrl.style.fontSize=Trim(currObj.font_size);
        try{ctrl.style.color=Trim(currObj.font_color);}catch(e){}
        ctrl.style.backgroundColor=Trim(currObj.bg_color);
        ctrl.style.borderColor=Trim(currObj.border_color);
        ctrl.style.borderWeight=Trim(currObj.border_weight);
        if(!EmptyString(currObj.class_Css)) ctrl.className=currObj.class_Css;
      }
      if( currObj.type=="Image" && (!Empty(currObj.src) || currObj.img_type=="font icon")){
        if(currObj.src.indexOf('request:')>-1 || currObj.src.indexOf('%')>-1 || !EmptyString(currObj.field) || currObj.img_type=="font icon")
          ctrl.src='images/imageghost.gif';
        else{
          if(currObj.path_type=='skin')
            ctrl.src="../"+skin+"/"+Strtran(currObj.src,"../","");
          else
            ctrl.src=currObj.src;
        }
        if(!EmptyString(currObj.zindex)) ctrl.style.zIndex=currObj.zindex
      }
      if(currObj.type=="Grid"){ //costruzione dinamica della tabella
        var div_grid=Ctrl(currObj.id);
        tbl=Ctrl(currObj.id+'_table');
        tbl.border='0px';
        tbl.cellSpacing=Trim(currObj.cellspacing);
        tbl.cellPadding=Trim(currObj.cellpadding);
        try{tbl.style.color=Trim(currObj.font_color);}catch(e){}
        tbl.style.fontSize=Trim(currObj.font_size);
        tbl.borderColor=Trim(currObj.line_color);
        if(!EmptyString(currObj.css_class_grid)) {
          div_grid.className=currObj.css_class_grid;
          tbl.className="grid_table";
        }
        columns=currObj.columntitles.split(",");
        while(tbl.rows.length>0) {
          while(tbl.rows[tbl.rows.length-1].cells.length>0) {
            tbl.rows[tbl.rows.length-1].deleteCell(tbl.rows[tbl.rows.length-1].cells.length-1);
          }
          tbl.deleteRow(tbl.rows.length-1);
        }
        tbl.insertRow(0);
        if(!EmptyString(currObj.align)) tbl.style.textAlign=currObj.align;
        tbl.rows[0].style.backgroundColor=Trim(currObj.title_color);
        if(!EmptyString(currObj.css_class_grid))
          tbl.rows[0].className='grid_cell_title';
        for(t=0;t<columns.length;t++){
          cell=tbl.rows[0].insertCell(t)
          if(!EmptyString(currObj.css_class_grid))
            cell.className='grid_cell_title';
          cell.style.height=0
          cell.innerHTML="<b>"+columns[t]+"</b>"
        }
        //creazione righe
        var nrows=currObj.rows-0 //converto in numero
        if (nrows==0) nrows=1

        for(var ccc=1;ccc<nrows+1;ccc++){
          tbl.insertRow(ccc)
          tbl.rows[ccc].style.backgroundColor=Trim(currObj.row_color);
          if(!EmptyString(currObj.css_class_grid))
            tbl.rows[ccc].className='grid_row';
          for(t=0;t<columns.length;t++){
            var cell2=tbl.rows[ccc].insertCell(t);
            cell2.innerHTML="<center><img src='images/trasparent.gif'></center>";
            if(!EmptyString(currObj.css_class_grid))
              cell2.className='grid_row';
          }
        }
      }
      if(currObj.type=="Tabs"){ //costruzione dinamica della tabella
        var cell;
        tbl=Ctrl(currObj.id+'_tab');
        tbl.style.fontFamily=Trim(currObj.font);
        try{tbl.style.color=Trim(currObj.font_color);}catch(e){}
        tbl.style.fontSize=Trim(currObj.font_size);
        if(!EmptyString(currObj.class_Css)) tbl.className=currObj.class_Css;
        tbl.style.textAlign='center';
        columns=currObj.links.split(",");
        while(tbl.rows.length>0) {
          while(tbl.rows[tbl.rows.length-1].cells.length>0) {
            tbl.rows[tbl.rows.length-1].deleteCell(tbl.rows[tbl.rows.length-1].cells.length-1);
          }
          tbl.deleteRow(tbl.rows.length-1);
        }
        tbl.insertRow(0);
        if(currObj.vertical=="false"){
          tbl.rows[0].style.backgroundColor=Trim(currObj.bg_color);
          var fw=EmptyString(currObj.font_weight) ? '' : currObj.font_weight;
          var w=currObj.cell_distr=='none' ? '' : (100/columns.length)+'%';
          for(t=0;t<columns.length;t++){
            cell=tbl.rows[0].insertCell(t)
            cell.style.fontWeight=fw;
            cell.style.width=w;
            if(columns[t].indexOf('javascript:')>-1)
              cell.innerHTML="Dynamic tabs"
            else
              cell.innerHTML=columns[t]
          }
        }else{
          for(t=0;t<columns.length;t++){
            tbl.insertRow(tbl.rows.length)
            tbl.rows[t].style.backgroundColor=Trim(currObj.bg_color);
            tbl.rows[t].align="center";
            tbl.rows[t].height=null;
            cell=tbl.rows[t].insertCell(0);
            cell.valign="center";
            cell.style.fontWeight=Trim(currObj.font_weight);
            if(columns[t].indexOf('javascript:')>-1)
              cell.innerHTML="Dynamic tabs"
            else
              cell.innerHTML=columns[t]
          }
        }
      }
    }
  }
  setShadow();
}
function moveVLine(){
  var form=Ctrl("backcanvas");
  v_line=formProp.v_line;
  Ctrl("v_line").style.left=((formProp.v_line-0)+form.offsetLeft+Ctrl("canvas").offsetLeft)+'px';
  Ctrl("v_line").style.height =Ctrl('canvas').offsetHeight-Ctrl('h_ruler').offsetTop+'px';
}
function deleteItem(){
  if(index!=null){
    var tmp=new Array()
    var tmpn=0
    var mainItem=itemsHTML[index];
    for (var i=0;i<itemsHTML.length;i++){
      var itm_tmp=itemsHTML[i];
      if(itm_tmp.shadow==""){ // sposta gli elementi non selezionati  in tmp
        tmp[tmpn++]=itm_tmp;
      }else{
        undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj(null,'delete',null,null,null,null,itm_tmp) // salvo gli oggetti cancellati per UNdo
      }
      //Cancello le propriet� collegate all'elemento cancellato
      if(mainItem.objClass.connector && itm_tmp.objClass.connector){
        for (var ii=0;ii<itm_tmp.objClass.connector.length;ii++){
          for (var iii=0;iii<mainItem.objClass.connector.length;iii++){
            if(itm_tmp['name']!=mainItem['name'] && itm_tmp.objClass.connector[ii]['type']  ==  mainItem.objClass.connector[iii]['type'] && itm_tmp.objClass.connector[ii]['propID'] && itm_tmp[itm_tmp.objClass.connector[ii]['propID']]==mainItem['name'] && itm_tmp.objClass.connector[ii]['versus']!=mainItem.objClass.connector[iii]['versus'])
              itm_tmp[itm_tmp.objClass.connector[ii]['propID']]=''; //Svuoto la propriet� che fa riferimento all'elemento cancellato
          }
        }
      }
    }
    indexUndo++
    undoSequence[indexUndo]=undoItemsMoved
    CheckUndoSize()
    undoItemsMoved=[]
    countindex=tmpn
    itemsHTML=tmp
    index=null
    last_index=null
    writeHTML(true)
    Properties();
    newPropObj.HideProperties();
  }
}
var codeevents=""
var ItemEventInput
var ActionCodeLayer;
var codeOpen=false;
function editItemEvent() {
  ItemEventInput = [itemsHTML,index,codeevents,formProp];
  //var dialogValue
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style)&&!Empty(ac_style.height)?ac_style.height:600)
  ac_style.width = (!Empty(ac_style)&&!Empty(ac_style.width)?ac_style.width:880)
  ac_style.maximized = (!Empty(ac_style)&&typeof(ac_style.maximized)!='undefined'?ac_style.maximized:false)
  localStorage.setItem('zucchetti_ac_style',JSON.encode(ac_style));
  ActionCodeLayer=new spModalLayer('editItemEvent.htm',{'in_iframe':true,
    'draggable':true,
    // 'top':40,
    // 'left':20,
    'width':ac_style.width,
    'height':ac_style.height,
    'resizable' :true,
    'border_color':'#CCCCCC',
    'border_width':1,
    'dragger_height':12,
    'dragger_image':'images/ps-editor-drag.png',
    'mask_opacity':0.4,
    'mask_color':'#CCCCCC',
    'show_scrollbars':false,
    'close_on_click_mask':'',
    'iframe_padding':0,
    'hide_close_btn':true,
    'maximize':true,
    'maximized':ac_style.maximized
  });
  ActionCodeLayer.open();
  codeOpen=true;
}
var codeManifest='';
//var ManifestCodeLayer;
function EditManifest(id){
    //var dialogValue
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style)&&!Empty(ac_style.height)?ac_style.height:600)
  ac_style.width = (!Empty(ac_style)&&!Empty(ac_style.width)?ac_style.width:880)
  ac_style.maximized = (!Empty(ac_style)&&typeof(ac_style.maximized)!='undefined'?ac_style.maximized:false)
  localStorage.setItem('zucchetti_ac_style',JSON.encode(ac_style));
  ActionCodeLayer=new spModalLayer('editManifest.htm?name='+document.getElementById(id).value,{'in_iframe':true,
    'draggable':true,
    // 'top':40,
    // 'left':20,
    'width':ac_style.width,
    'height':ac_style.height,
    'resizable' :true,
    'border_color':'#CCCCCC',
    'border_width':1,
    'dragger_height':12,
    'dragger_image':'images/ps-editor-drag.png',
    'mask_opacity':0.4,
    'mask_color':'#CCCCCC',
    'show_scrollbars':false,
    'close_on_click_mask':'',
    'iframe_padding':0,
    'hide_close_btn':true,
    'maximize':true,
    'maximized':ac_style.maximized
  });
  ActionCodeLayer.open();
  codeOpen=true;
}
function Copy(cut){
  var deftmp=""
  for (var i=0;i<itemsHTML.length;i++){
    if(itemsHTML[i].shadow!=""){
    //if(itemsHTML[i]==itemsHTML[index]){
      setPropertiesID(itemsHTML[i]);
      deftmp+='type||'+itemsHTML[i].type
      for(var u=0;u<itemsHTML[i].objClass.properties.length;u++){
        eval('valuetosave=itemsHTML[i].'+itemsHTML[i].objClass.properties[u])
        if(typeof(valuetosave)!='number'){
          if(typeof(valuetosave)=='undefined' || valuetosave=="") valuetosave=' ' // se la prop � undefined allora la salvo come ' '
        }
        eval('deftmp+="||'+itemsHTML[i].objClass.properties[u]+'||"+valuetosave')
      }
      deftmp+='|||'
    }
  }
  if(cut) deleteItem();
  return deftmp
}
// funzioni di che interagiscono con il server ######################
function sortSequence(a, b){
  var a_seq=a.sequence;if(Empty(a_seq)) a_seq=null;
  var b_seq=b.sequence;if(Empty(b_seq)) b_seq=null;
  if (a_seq!=null && b_seq==null) return -1;
  if (a_seq==null && b_seq!=null) return 1;
  if (parseInt(a_seq) > parseInt(b_seq)) return 1;
  if (parseInt(a_seq) < parseInt(b_seq)) return -1;
  if(a_seq==b_seq){
    if(parseInt(a.id.substring(4))>parseInt(b.id.substring(4)))
      return 1;
    else
      return -1
  }
}
var saving
var savingpic
var old_name;
var AfterSave
function save(then) {
  if(codeOpen) {
    if(ActionCodeLayer)
      ActionCodeLayer.getContainer().getElement('iframe').contentWindow.fireEvent('save');
  }
  if (then=='close') AfterSave='close';
  else if( !Empty(then)){ //then � un oggetto che contiene una funzione che deve essere eseguita dopo il salvataggio
   AfterSave = then;
  }
  if(document.activeElement.tagName=='INPUT'){
    var activeE=document.activeElement;
    activeE.blur();
    activeE.focus();
  }
  if(parent) parent.is_Saving=true;
  if(currentname!=""){
	  notimooManager = new Notimoo({});
	  notimooManager.show({
	    title:'Notification message',
	    message: 'saving portlet...',
	    sticky : true,
	    width:200,
	    height:40
	  });
	  save2.delay(100);
    //var evalStr = "Ctrl(\"savingpic\").style.display=\"block\";setTimeout(\"save2()\",500)";
    //fade(0.5,0.9,0.2,1,"saving",true,evalStr);
  } else {
    //if(parent) parent.is_Saving=false;
    window.parent.saveAsTool()
  }
}
function setPropertiesID(obj){ //ricreo properties per compatibilit� con il vecchio array
  if(obj.objClass.newProperties){
		var mainObject=obj;
    mainObject.objClass.properties=new Array();
		for(var i in mainObject.objClass.newProperties){
			var tab = mainObject.objClass.newProperties[i];
			for(var ii = 0; ii<tab.length; ii++){
				mainObject.objClass.properties.push(tab[ii].propID)
			}
		}
  }
}
function save2() {
  var output;
  var valuetosave,typevar;
  request_parms={};
  itemsHTML.sort(sortSequence)
  setPropertiesID(formProp);
  //Formato JSON
  var JSONItems=[];
  var JsonFormItem={type:'Form',title:''}
  var strsave='type||Form||title|| ';

  //Legge il Form
  for(var u=0, prop, props=formProp.objClass.properties;u<props.length;u++){
    prop=props[u];
    valuetosave=formProp[prop];
    //if(typeof(valuetosave)=='string'){
    if(typeof(valuetosave)=='undefined' || valuetosave=="") valuetosave=' ';
    //}
    if(prop!='page'){
      strsave+="||"+prop+"||"+valuetosave;
      if(typeof(valuetosave)=='string')
        JsonFormItem[prop]=Trim(valuetosave);
      else
        JsonFormItem[prop]=valuetosave;
    }
  }
  if(formProp['offline']=='true'){
    strsave+="||codemanifest||"+JSON.stringify({codemanifest:codeManifest});
    JsonFormItem['codemanifest']=JSON.stringify({codemanifest:codeManifest});
  }
  JSONItems.push(JsonFormItem);
  strsave+='|||';
  //Legge i Ctrls
  for (var i=0;i<itemsHTML.length;i++){
    var ctrl=itemsHTML[i];
    var ctrl_name=ctrl.name
    strsave+='type||'+ctrl.type;
    var JsonItem={type:ctrl.type};
    setPropertiesID(ctrl);
    for(u=0, prop, props=ctrl.objClass.properties; u<props.length;u++){
      prop=props[u];
      valuetosave=ctrl[prop];
      typevar=ctrl['typevar'];
      if(!Empty(valuetosave) && LRTrim(valuetosave.toString())=='request'){
        request_parms[ctrl_name]=(!Empty(typevar)?(typevar=='datetime')?'T':Left(typevar,1).toUpperCase():'C');
      }else if(!Empty(valuetosave) && valuetosave.toString().indexOf('request:')>-1){
        request_parms[LRTrim(Strtran(valuetosave,'request:',''))]=(!Empty(typevar)?(typevar=='datetime')?'T':Left(typevar,1).toUpperCase():'C');
      }
      if(typeof(valuetosave)=='string' && valuetosave.indexOf('|')>-1) valuetosave=Strtran(valuetosave,'|','$|$');
      if(typeof(valuetosave)=='undefined' || (typeof(valuetosave)=='string' && valuetosave=="")) valuetosave=' ';
      //in caso di || all interno del valore lo coverto per non rompere il def
      strsave+="||"+prop+"||"+valuetosave;
      if(typeof(valuetosave)=='string')
        JsonItem[prop]=Trim(valuetosave);
      else
        JsonItem[prop]=valuetosave;
    }
    if('spuid' in ctrl){
      strsave+='||spuid||'+ctrl.spuid;
      JsonItem['spuid']=ctrl.spuid;
    }
    if('page' in ctrl){
      strsave+='||page||'+ctrl.page;
      JsonItem['page']=ctrl.page;
    }
    strsave+='|||';
    JSONItems.push(JsonItem);
  }
  strsave+=codeevents;
  JsonFormItem['actioncode']=codeevents;

  /*In questo modo salva il def in JSON*/
  strsave=JSON.stringify(JSONItems,function(s,v){if(typeof(v)!='object') return v.toString(); else return v;});
  var portlet_name=''
  currentname=Strtran(currentname,'\\',"/")
  if(currentname.indexOf('/')>-1){
    folder_path=currentname.substring(0,currentname.lastIndexOf("/"))
    portlet_name=currentname.substring(currentname.lastIndexOf("/")+1)

  }else{
    portlet_name=currentname
  }
  if(folder_path.indexOf('jsp-decorators')>-1){
    folder_path=(Left(currentname,1)!='/'?'/':'')+currentname.substring(0,currentname.lastIndexOf("/"))
    portlet_name=currentname.substring(currentname.lastIndexOf("/")+1)
   }
  var url = new JSURL("../servlet/JSPSave?type=portlet"+
    "&name="+portlet_name+(m_nFrontendPort?"&frontendport="+m_nFrontendPort:"")+
    "&folder_path="+folder_path+
    "&def="+URLenc(strsave)+
    "&offline="+formProp['offline']+
    (!Empty(codeManifest)?"&customManifest="+URLenc(formProp['manifest']):"") +
    "&m_cID=" + cmdhash, true);
  output=url.Response()
  if(window.parent.changeName) window.parent.changeName(portlet_name,folder_path,Strtran(window.frameElement.id,'portalstudioframe',''))
  if (output==null) output=""
  switch(output) {
    case "true":
      for(i=0 ;i<notimooManager.elements.length;i++){
        notimooManager.close(notimooManager.elements[i]);
      }
      notimooManager.show({
      title:'Notification message',
      message: 'portlet saved!',
      visibleTime: 2000,
      width:200
		  });
      if(Empty(old_name) || old_name!=currentname)
        window.location.href=SPWebRootURL+'/visualweb/editor.jsp?id='+currentname;
      m_bUpdated=false
      if(typeof(window.opener)!="undefined"){
        try {
          window.opener.document.getElementById('zones_Id').submit()
        } catch(e) {}
      }
      if(AfterSave=="close") window.parent.closeCurrentObj();
      else if(!Empty(AfterSave)){
        AfterSave();
        AfterSave=null;
      }
    break;
    case "ACCESS DENIED":
		  notimooManager.close(notimooManager.elements[0]);
      alert("Access Denied.")
      break;
    case "LICENSE LIMIT":
		  notimooManager.close(notimooManager.elements[0]);
      alert("Licensed User Limit Reached.")
      break;
    default:
		  notimooManager.close(notimooManager.elements[0]);
      alert("Save routine failed.")
      break;
  }
  if(parent) parent.is_Saving=false;
}

function reload(e) {
  var url
  var GET_DATA=LibJavascript.ReadGetData();
  if(GET_DATA.servlet)
    url = new JSURL("../servlet/"+GET_DATA.id+"?m_cAction=createportlet");
  else
    url = new JSURL("../servlet/JSPLoad?type=portlet&name="+currentname,true);
  //var strreload=url.Response();
  var strreload=Strtran(url.Response(),'\u0080','\u20AC');
  strreload=Strtran(strreload,'$>','%>');
  strreload=Strtran(strreload,'<$','<%');
  return reload_(e,strreload,false);
}

function Paste(strpaste){
  if(strpaste!='')  return reload_(null,strpaste,true)
}

function reload_(e,strreload,paste) {
  var arrayreload, arrayreload2;
  var valore,nomeprop, ffieldtype;
  var imagename, currentItem;
  var i, t, b, bb, p, imm;
  if(Left(strreload,1)=='['){ // Def in formato JSON
    var JsonItems=JSON.parse(strreload);
    if(!paste){
      codeevents="";
      itemsHTML=[]
      nitem=0
      countindex=0
    }else
      strreload+=codeevents
    Ctrl("canvasitems").innerHTML=""
    ffieldtype=false
    //var type;
    request_parms={};
    arrayreload=JsonItems;
    for(i=0;i<arrayreload.length;i++){
      var found=false
      arrayreload2=arrayreload[i]
      type=arrayreload2['type'];
      //controllo se l'item � Added e lo aggiunge alla toolbar e inserisce il codice del nuovo oggetto
      if(type !='Label' && type!='Textbox' && type!='Button' && type!='SQLDataobj' && type!='Grid' && type!='Image' &&
         type!='Form' && type!='Tabs' && type!='Iframe' && type!='Box' && type!='SPLinker' && type!='Chart' && type!='XMLDataobj' &&
         type!='Variable' && type!='Portlet' && type!='Checkbox' && type!='Combobox' && type!='EventEmitter' && type!='EventReceiver' &&
         type!='Radio' && type!='DataMasher' && type!='StdTreeView' && type !='Manifest' && type!='Note'){
      //controllo se l'item � gi� stato aggiunto
        for(t=0;t<itemsHTML.length;t++){
          if(itemsHTML[t].type==type)
            found=true
        }
        if(!found){
          imagename=""
          if(!getobj(type+'.edtdef')){b_reload=false;return;}
          imagename=ZTObjects[type+"Class"].names[0];
          imm = new Element('img',{'src':imagename}).setStyles({'opacity':0}).inject(document.body,'before');
          imm.type= type;
          imm.imagename= imagename;
          imm.addEvent('load',function(){
            var type = this.type;
            toolbars.ctrl.addElement ({ 'id': 'right_align'
            , 'class_name': 'btn'
            , 'action': function(){ addItem(type) }
            , 'image': this.imagename
            , 'title': type
            }, toolbars.ctrl.items.length - 2)
            this.destroy();
          });
        }
      }
      e = (e) ? e : window.event;
      putItem(e, b_reload,paste)
      currentItem=itemsHTML[countindex-1];
      var resetGlobalVars=true;
      //for(var b=0;b<arrayreload2.length;b++){
      for(b in arrayreload2){
        nomeprop=b;
        valore=arrayreload2[b];
        //Riconversione per i | presenti nei valore per non rompere il Def
        if(valore.indexOf('$|$')>-1) valore=Strtran(valore,'$|$','|');
        if(arrayreload2['type']=='Form' && !paste){  // propriet� generiche del form
          if (resetGlobalVars) {
            codeevents='';
            codeManifest='';
            resetGlobalVars=false;
          }
          formProp[nomeprop]=valore;
          //=JSON.parse(arrayreload2['codemanifest']).codemanifest
          if(nomeprop == 'actioncode' ){
            codeevents=valore
          }
          if(nomeprop == 'codemanifest' ){
            codeManifest=JSON.parse(valore).codemanifest;
          }
        }else{
          if(paste && (nomeprop=='x' || nomeprop=='y')){
            valore=(valore-0)+10;
          }
          if(paste && nomeprop=='name'){
            for(bb=0;bb<itemsHTML.length;bb++){
              if(itemsHTML[bb].name==valore)
                valore+='_Copy'
            }
          }
          if(type=="SQLDataobj" && ffieldtype==false){
            currentItem.return_fields_type='false';
            ffieldtype=true;
          }
          if(type=='Image' && nomeprop=='themed_image') {
            nomeprop='path_type';
            if(valore=='true') valore='themed';
          }
          if(nomeprop=='page'){
            formProp.npages=Math.max(formProp.npages,valore);
          }
          if(nomeprop=="sequence" && !Empty(valore)) sequence_c=valore;
          if(nomeprop=="sequence" && Empty(valore))  valore=++sequence_c;
          currentItem[nomeprop]=valore;
        }
      }
      //Ciclo per recuperare le variabili in request
      for(p in currentItem){
        if(!Empty(p) && currentItem[p] && LRTrim(currentItem[p].toString())=='request')
          request_parms[currentItem['name']]=(!Empty(currentItem['typevar'])?(currentItem['typevar']=='datetime')?'T':Left(currentItem['typevar'],1).toUpperCase():'C');
        else if(!Empty(p) && currentItem[p] && currentItem[p].toString().indexOf('request:')>-1)
          request_parms[LRTrim(Strtran(currentItem[p],'request:',''))]=(!Empty(currentItem['typevar'])?(currentItem['typevar']=='datetime')?'T':Left(currentItem['typevar'],1).toUpperCase():'C');
      }
    }
    if(formProp['offline']=='true' && !Empty(formProp['manifest']) && formProp['manifest'] != 'Custom manifest'){ // Carica il custom manifest
      codeManifest=new JSURL("../servlet/JSPReader?action=manifest&name="+formProp['manifest'],true).Response();
      formProp['manifest'] = 'Custom manifest';
    }
    writeHTML(true);
    FormProperties(true,false);

  }else if(strreload!=' ' && strreload.substring(0,4)=='type'){ // Vecchio def
    if(!paste){
      codeevents=""
      itemsHTML=[]
      nitem=0
      countindex=0
    }else
      strreload+=codeevents
    Ctrl("canvasitems").innerHTML=""
    ffieldtype=false
    request_parms={};
    //while(Ctrl("toolbar_tbl").rows.length!=0 && !paste)
    //  Ctrl("toolbar_tbl").deleteRow()
    arrayreload=strreload.split('|||')
    for(i=0;i<arrayreload.length-1;i++){
      found=false
      arrayreload2=arrayreload[i].split('||')
      type=arrayreload2[1]
      //controllo se l'item � Added e lo aggiunge alla toolbar e inserisce il codice del nuovo oggetto
      if(type !='Label' && type!='Textbox' && type!='Button' && type!='SQLDataobj' && type!='Grid' && type!='Image' &&
         type!='Form' && type!='Tabs' && type!='Iframe' && type!='Box' && type!='SPLinker' && type!='Chart' && type!='XMLDataobj' &&
         type!='Variable' && type!='Portlet' && type!='Checkbox' && type!='Combobox' && type!='EventEmitter' && type!='EventReceiver' &&
         type!='Radio' && type!='DataMasher' && type!='StdTreeView' && type!='Manifest' && type!='Note'){
      //controllo se l'item � gi� stato aggiunto
        for(t=0;t<itemsHTML.length;t++){
          if(itemsHTML[t].type==type)
            found=true
        }
        if(!found){
          if(!getobj(type+'.edtdef')){b_reload=false;return;}
          imagename=ZTObjects[type+"Class"].names[0];
          imm = new Element('img',{'src':imagename}).setStyles({'opacity':0}).inject(document.body,'before');
          imm.type= type;
          imm.imagename= imagename;
          imm.addEvent('load',function(){
            var type = this.type;
            toolbars.ctrl.addElement ({ 'id': 'right_align'
            , 'class_name': 'btn'
            , 'action': function(){ addItem(type) }
            , 'image': this.imagename
            , 'title': type
            }, toolbars.ctrl.items.length - 2)
            this.destroy();
          });
        }
      }
      e = (e) ? e : window.event;
      putItem(e, b_reload,paste)
      currentItem=itemsHTML[countindex-1];
      for(b=0;b<arrayreload2.length;b++){
        nomeprop=arrayreload2[b];
        valore=LRTrim(arrayreload2[b+1]);
        //Riconversione per i | presenti nei valore per non rompere il Def
        if(valore.indexOf('$|$')>-1) valore=Strtran(valore,'$|$','|');
        if(i==0 && !paste){  // propriet� generiche del form
          if(nomeprop == "codemanifest"){
            valore = JSON.parse(valore).codemanifest;
            codeManifest = valore;
          }
          formProp[nomeprop]=valore;
          b++
        }else{
          if(paste && (nomeprop=='x' || nomeprop=='y')){
            valore=(valore-0)+10;
          }
          if(paste && nomeprop=='name'){
            for(bb=0;bb<itemsHTML.length;bb++){
              if(itemsHTML[bb].name==valore)
                valore+='_Copy'
            }
          }
          if(type=="SQLDataobj" && ffieldtype==false){
            currentItem.return_fields_type='false';
            ffieldtype=true;
          }
          if(type=='Image' && nomeprop=='themed_image') {
            nomeprop='path_type';
            if(valore=='true') valore='themed';
          }
          if(nomeprop=='page'){
            formProp.npages=Math.max(formProp.npages,valore);
          }
          if(nomeprop=="sequence" && !Empty(valore)) sequence_c=valore;
          if(nomeprop=="sequence" && Empty(valore))  valore=++sequence_c;
          currentItem[nomeprop]=valore;
          b++;
        }
      }
      //Ciclo per recuperare le variabili in request
      for(p in currentItem){
        if(!Empty(p) && currentItem[p] && LRTrim(currentItem[p].toString())=='request')
          request_parms[currentItem['name']]=(!Empty(currentItem['typevar'])?(currentItem['typevar']=='datetime')?'T':Left(currentItem['typevar'],1).toUpperCase():'C');
        else if(!Empty(p) && currentItem[p] && currentItem[p].toString().indexOf('request:')>-1)
          request_parms[LRTrim(Strtran(currentItem[p],'request:',''))]=(!Empty(currentItem['typevar'])?(currentItem['typevar']=='datetime')?'T':Left(currentItem['typevar'],1).toUpperCase():'C');
      }
    }
    codeevents=arrayreload[arrayreload.length-1] // codice delle funzioni editat
    if(formProp['offline']=='true' && !Empty(formProp['manifest']) && formProp['manifest'] != 'Custom manifest'){ // Carica il custom manifest
      codeManifest=new JSURL("../servlet/JSPReader?action=manifest&name="+formProp['manifest'],true).Response();
      formProp['manifest'] = 'Custom manifest';
    }
    writeHTML(true);
    FormProperties(true,false);

  } else if(strreload=='') {
    alert('utente non loggato')
  } else {
    alert('Errore in caricamento del def')
  }
  b_reload=false;
}
 //carica un nuovo oggetto
function loadNewObj(){
  WinOpener=OpenWindow("openEdtDef.htm",350,250,200,200,'resizable=yes')
}
function loadNewObjDone(objsrc){
  var imagename
  var objname
  if(objsrc!=null){
    objname=objsrc.substring(0,objsrc.indexOf('.'))
    if(objsrc!=null && eval("ZTObjects."+objname)==null){
      getobj(objsrc) // eval del nuovo oggetto
      //prende il nome del nuovo oggetto
      eval("imagename=ZTObjects."+objname+"Class.names[0]")
      /*Trovo la dimensione dell'immagine */
      var imm = new Element('img',{'src':imagename}).setStyles({'opacity':0}).inject(document.body,'before');
      imm.type= objname;
      imm.imagename= imagename;
      imm.addEvent('load',function(){
        var type = this.type;
        toolbars.ctrl.addElement ({ 'id': 'right_align'
        , 'class_name': 'btn'
        , 'action': function(){ addItem(type) }
        , 'image': this.imagename
        , 'title': type
        }, toolbars.ctrl.items.length - 2)
        // var objCont =  new Element('div',{'id':type,'class':'btn','title':type}).inject(document.getElementById('newObj'),'before');
        // if( this.offsetHeight == 24 &&  this.offsetWidth == 48){
          // var newObj = new Element('div').setStyles({
            // 'background-image': 'url('+this.imagename+')'
          // }).inject(objCont);
        // }else{
           // var newObj  = new Element('img',{'src':this.imagename,'border':0,'alt':this.type,'title':this.type}).setStyles({
            // 'height':24,
            // 'width':24
          // }).inject(objCont);
        // }
        // newObj.type = this.type;
        // newObj.addEvent('click',function(){
          // addItem(this.type);
        // });
        /*Aggiorno le dimensioni della toolbar*/
        // var evt = document.createEvent('HTMLEvents');
        // evt.initEvent('SPToolbarRefresh',true,true);
        // objCont.dispatchEvent(evt);
        this.destroy();

        // document.fireEvent('SPToolbarRefresh',);
        // new DOMEvent('onSPToolbarRefresh')
      });
    }
  }
  document.body.onfocus = null
}
// Funzioni di trascinamento items ####################################
function sortY(a, b){
  if (parseInt(a.y) > parseInt(b.y)) return 1;
  if (parseInt(a.y) < parseInt(b.y)) return -1;
  return 0;
}
function sortX(a, b){
  if (parseInt(a.x) > parseInt(b.x)) return 1;
  if (parseInt(a.x) < parseInt(b.x)) return -1;
  return 0;
}

//Funzioni di allineamento

function alignItems(side){
  var delta,aa,bb, cc;
  if(mainitem==null) return;
  switch(side){
    case 'y_delta':
    cc=0;
    itemsHTML.sort(sortY);
    for (var p=0;p<itemsHTML.length;p++) {
      if(itemsHTML[p].shadow != ""){
        cc++;
        if(cc==1) aa=p;
        if(cc==2){
         bb=p;
         delta=itemsHTML[bb].y-itemsHTML[aa].y-itemsHTML[aa].h;
         break
        }
      }
    }
    aa=0;
    for (p=0;p<itemsHTML.length;p++) {
      if(itemsHTML[p].shadow != ""){
        if(aa>0){
          Ctrl(itemsHTML[p].shadow).style.top=(parseInt(delta)+parseInt(prevItem.y)+parseInt(prevItem.h))+'px';
          itemsHTML[p].y=parseInt(delta)+parseInt(prevItem.y)+parseInt(prevItem.h);
        }
        prevItem=itemsHTML[p];
        aa++;
      }
    }
    moveItems();
    break
    case 'x_delta':
    cc=0;
    itemsHTML.sort(sortX);
    for (p=0;p<itemsHTML.length;p++) {
      if(itemsHTML[p].shadow != ""){
        cc++;
        if(cc==1) aa=p;
        if(cc==2){
         bb=p;
         delta=itemsHTML[bb].x-itemsHTML[aa].x-itemsHTML[aa].w;
         break
        }
      }
    }
    aa=0;
    for (p=0;p<itemsHTML.length;p++) {
      if(itemsHTML[p].shadow != ""){
        if(aa>0){
          Ctrl(itemsHTML[p].shadow).style.left=(parseInt(delta)+parseInt(prevItem.x)+parseInt(prevItem.w))+'px';
          itemsHTML[p].x=parseInt(delta)+parseInt(prevItem.x)+parseInt(prevItem.w);
        }
        prevItem=itemsHTML[p];
        aa++;
      }
    }
    moveItems();
    break
    case 'left':
      for (p=0;p<itemsHTML.length;p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != ""){
          Ctrl(itemsHTML[p].shadow).style.left = mainitem.offsetLeft+'px';
          itemsHTML[p].x=itemsHTML[index].x;
        }
      }
    moveItems();
    break
    case 'top':
      for (p=0;p<itemsHTML.length;p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != ""){
          Ctrl(itemsHTML[p].shadow).style.top = mainitem.offsetTop+'px';
          itemsHTML[p].y=itemsHTML[index].y;
        }
      }
    moveItems();
    break
    case 'right':
      for (p=0;p<itemsHTML.length;p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != ""){
          Ctrl(itemsHTML[p].shadow).style.left = (mainitem.offsetLeft+mainitem.offsetWidth-Ctrl(itemsHTML[p].shadow).offsetWidth)+'px';
          itemsHTML[p].x=itemsHTML[index].x+itemsHTML[index].w-itemsHTML[p].w;//mainitem.offsetLeft+mainitem.offsetWidth-Ctrl(itemsHTML[p].shadow).offsetWidth
        }
      }
    moveItems();
    break
    case 'bottom':
      for (p=0;p<itemsHTML.length;p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != ""){
          Ctrl(itemsHTML[p].shadow).style.top = (mainitem.offsetTop+mainitem.offsetHeight-Ctrl(itemsHTML[p].shadow).offsetHeight)+'px';
          itemsHTML[p].x=itemsHTML[index].y+itemsHTML[index].h-itemsHTML[p].h;     //mainitem.offsetTop+mainitem.offsetHeight-Ctrl(itemsHTML[p].shadow).offsetHeight
        }
      }
    moveItems();
    break
    case 'resizex':
      for (p=0;p<itemsHTML.length;p++) {
        if(itemsHTML[p].shadow != mainitem.id && !Empty(itemsHTML[p].shadow)){
          var n=Ctrl(itemsHTML[p].shadow).id.substr(6);
          undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj('item'+n,'resize',null,null,null,null,itemsHTML[p],mainitem.offsetWidth,mainitem.offsetHeight,itemsHTML[p].w,itemsHTML[p].h);
          Ctrl(itemsHTML[p].shadow).style.width = (mainitem.offsetWidth-2)+'px';
          Ctrl("handlersWrapper"+n).style.width = (mainitem.offsetWidth+6)+'px';
          Ctrl("item"+n).style.width = (mainitem.offsetWidth-getOffset(Ctrl("item"+n)).gapw)+'px';
          itemsHTML[p].w=itemsHTML[index].w;
        }

      }
      if(undoItemsMoved.length>0){
        indexUndo++;
        undoSequence[indexUndo]=undoItemsMoved;
        CheckUndoSize();
        undoItemsMoved=[];
      }
    break
    case 'resizey':
      for (p=0;p<itemsHTML.length;p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != ""){
          n=Ctrl(itemsHTML[p].shadow).id.substr(6)
          undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj('item'+n,'resize',null,null,null,null,itemsHTML[p],mainitem.offsetWidth,mainitem.offsetHeight,itemsHTML[p].w,itemsHTML[p].h);
          Ctrl(itemsHTML[p].shadow).style.height = (mainitem.offsetHeight-2)+'px';
          Ctrl("handlersWrapper"+n).style.height = (mainitem.offsetHeight+6)+'px';
          Ctrl("handler"+n+"_5").style.top = ((Ctrl("handlersWrapper"+n).offsetHeight)/2 - 4 )+'px'; //bordi
          Ctrl("handler"+n+"_6").style.top = ((Ctrl("handlersWrapper"+n).offsetHeight) -18)+'px'; //posizionamento relativo  (10)
          Ctrl("handler"+n+"_7").style.top = ((Ctrl("handlersWrapper"+n).offsetHeight)/2 - 4)+'px';
          Ctrl("item"+n).style.height = (mainitem.offsetHeight-getOffset(Ctrl("item"+n)).gaph)+'px';
          itemsHTML[p].h=itemsHTML[index].h;
        }
      }
      if(undoItemsMoved.length>0){
        indexUndo++;
        undoSequence[indexUndo]=undoItemsMoved;
        CheckUndoSize();
        undoItemsMoved=[];
      }
    break
    case 'resizexy':
      for (p=0;p<itemsHTML.length;p++) {
        if(itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != ""){
          n=Ctrl(itemsHTML[p].shadow).id.substr(6);
          undoItemsMoved[undoItemsMoved.length]=new ZTObjects.undoObj('item'+n,'resize',null,null,null,null,itemsHTML[p],mainitem.offsetWidth,mainitem.offsetHeight,itemsHTML[p].w,itemsHTML[p].h);
          itemsHTML[p].w=itemsHTML[index].w;
          itemsHTML[p].h=itemsHTML[index].h;
          Ctrl(itemsHTML[p].shadow).style.height = mainitem.offsetHeight+'px';
          Ctrl(itemsHTML[p].shadow).style.width = (mainitem.offsetWidth-2)+'px';
          Ctrl("handlersWrapper"+n).style.width = (mainitem.offsetWidth+6)+'px';
          Ctrl("item"+n).style.width = (mainitem.offsetWidth-getOffset(Ctrl("item"+n)).gapw)+'px';
          Ctrl("handlersWrapper"+n).style.height = (mainitem.offsetHeight+6)+'px';
          Ctrl("handler"+n+"_5").style.top = ((Ctrl("handlersWrapper"+n).offsetHeight)/2 - 4 )+'px'; //bordi
          Ctrl("handler"+n+"_6").style.top = ((Ctrl("handlersWrapper"+n).offsetHeight) -18)+'px'; //posizionamento relativo  (10)
          Ctrl("handler"+n+"_7").style.top = ((Ctrl("handlersWrapper"+n).offsetHeight)/2 - 4)+'px';
          Ctrl("item"+n).style.height = (mainitem.offsetHeight-getOffset(Ctrl("item"+n)).gaph)+'px';

        }
      }
      if(undoItemsMoved.length>0){
        indexUndo++;
        undoSequence[indexUndo]=undoItemsMoved;
        CheckUndoSize();
        undoItemsMoved=[];
      }
    break
  }
}

function insertImage(url,imgnew,retTo){
  InsertImageDone("../"+url,imgnew,retTo);
}

function closeDialogs(){
  if (WinOpener) WinOpener.close();
  document.body.onfocus = null;
}

function GetCurrentName() {
  return currentname;
}

function GetResourceName() {
  return '../jsp/'+currentname+'_portlet.jsp?m_NoCache='+LibJavascript.AlfaKeyGen(10);
}

function GetRequestParams() {
  return request_parms;
}
/*Apertura e chiusura della LogicView*/
var logicview_opened=false;
function toggleLogicView(){
  //if(newPropObj)newPropObj.HideProperties();
  var i_logicview=document.getElementById('i_logicview');
  var i_logicview_wrapper=document.getElementById('i_logicview_wrapper');
  // var btn_logicview=document.getElementById('btn_logicview');
  var morphP= new Fx.Morph(i_logicview_wrapper,{ 'duration':'400',transition:Fx.Transitions.easeOut});
  document.getElementById('formproperties').set('morph')
  if(!logicview_opened){
    i_logicview_wrapper.setStyles({'width': window.getSize().x,'height':window.getSize().y,'left':window.getSize().x,'top':0});
    i_logicview.setStyles({'height': window.getSize().y,'top':0});
    i_logicview_wrapper.setStyle('display','block');
    i_logicview_wrapper.setStyle('top', 0); //document.getElementById('toolbar').offsetHeight
    i_logicview.src='logicView.html';
    // btn_logicview.getFirst().setStyle('background-image','url(../portalstudio/images/icon/btn_logicview_off.png)');
    // btn_logicview.title='Back to Edit';
    morphP.start({'left':0});
    logicview_opened=true;
    document.getElementById('formproperties').morph({'opacity':0.2})
  }else{
    // btn_logicview.getFirst().setStyle('background-image','url(../portalstudio/images/icon/btn_logicview.png)');
    morphP.start({'left': window.getSize().x}).chain(function (){i_logicview_wrapper.setStyle('display','none');});
    // btn_logicview.title='Go to Logic View';
    logicview_opened=false;
    document.getElementById('formproperties').morph({'opacity':1})
  }
}

function unSelectItem(itm){ //REFIFINED
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

  if(indexz>=0){
	itm.style.display='none';
	itemsHTML[indexz].shadow='';
	Ctrl("handler" + unselecteditem + "_0").style.display='none';
	Ctrl("handler" + unselecteditem + "_1").style.display='none';
	Ctrl("handler" + unselecteditem + "_2").style.display='none';
	Ctrl("handler" + unselecteditem + "_3").style.display='none';
	Ctrl("handler" + unselecteditem + "_4").style.display='none';
	Ctrl("handler" + unselecteditem + "_5").style.display='none';
	Ctrl("handler" + unselecteditem + "_6").style.display='none';
	Ctrl("handler" + unselecteditem + "_7").style.display='none';
	Ctrl("handlersWrapper"+unselecteditem).style.display='none';
	Ctrl("canvashandlers").removeChild(itm);
	Ctrl("canvashandlers").removeChild(Ctrl("handlersWrapper"+unselecteditem));
	if(container_selection.e.indexOf(indexz)>=0) container_selection.e.splice(container_selection.e.indexOf(indexz),1);
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
