/* exported
    initPainter dragToolbar initialCap SetOnEditProp CopyPaste manageItems setProperties setProperties_ beginDragSelection
    noDefaultDrag dragShadow editPortlet CloseDialogs fade disableSelect enableSelect addRulersLine togglePreview previewConfirmParms
    disableAnchor getDocHeight checkChartDef checkChartType LoadFieldsConfigurator LoadSeriesConfigurator restoreClassFromFile NewChartDef
    EditChartDef PickItems ExpressionBuilderReturn SelectCss selectClass newClass allClass editClass selectImage SelectIcons SelectFont
    NewVdmMask EditVdmMask SelectVdmMask renderApi getRenderApiObjClass resizePreview getComponentSamples setComponentSamples renderApiForm readLibrary
    GetFieldsForChart getChartMacroType
    standalone multipleSelection LoadClassificationConfigurator selectedProp SetSelectedProp StartChartWizard
  */

/* global setPropertyValue */

//Movimento Tool bar
var container_selection = new Object(); //oggetto che circonda tutti gli elementi selezionati
var not_selected = new Array(); //array di itemHTML non selezionati (� l'array dei loro indici)
var undoSequence=new Array(); //array contenente tutti gli oggetti di Undo
var dragObj=new Object();
dragObj.zOrder=1000;
var standalone=false;
var tool=null;
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

var container_align_h1,container_align_h2,container_align_v1,container_align_v2,container_align_mh,container_align_mv,distance_align_h1,distance_align_h2,
  distance_align_v1,distance_align_v2,container_distance_v1,container_distance_v2,container_distance_h1,container_distance_h2,shadow_selection;
//LibJavascript.Events.addEvent(window,'load',function(){
  // container_selection = new Element ('div',{id:'container_selection'});
  // notimooManager = new Notimoo({});
  // container_align_h1 =  new Element ('div',{id:'container_align_h1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  // container_align_h2 =  new Element ('div',{id:'container_align_h2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  // container_align_v1= new Element ('div',{id:'container_align_v1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  // container_align_v2 = new Element ('div',{id:'container_align_v2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  // container_align_mh = new Element ('div',{id:'container_align_mh'}).setStyles({'position':'absolute','z-index':4,'background':'transparent url(../portalstudio/images/align_h_dotted.png) repeat-y','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  // container_align_mv = new Element ('div',{id:'container_align_mv'}).setStyles({'position':'absolute','z-index':4,'background':'transparent url(../portalstudio/images/align_v_dotted.png) repeat-x','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  // distance_align_h1 =  new Element ('div',{id:'distance_align_h1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  // distance_align_h2 =  new Element ('div',{id:'distance_align_h2'}).setStyles({'position':'absolute','z-index':4, 'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  // distance_align_v1= new Element ('div',{id:'distance_align_v1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  // distance_align_v2 = new Element ('div',{id:'distance_align_v2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  // container_distance_v1 = new Element('div',{id:'container_distance_v1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  // container_distance_v2 = new Element('div',{id:'container_distance_v2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'0px','width':'1px'}).grab(new Element('p')).inject(container_selection);
  // container_distance_h1 = new Element('div',{id:'container_distance_h1'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  // container_distance_h2 = new Element('div',{id:'container_distance_h2'}).setStyles({'position':'absolute','z-index':4,'background-color':'#588644','height':'1px','width':'0px'}).grab(new Element('p')).inject(container_selection);
  // shadow_selection = new Element ('div',{id:'shadow_selection'}).setStyles({'z-index':4}).grab(new Element('p')).inject(container_selection);
  // if(Ctrl('backcanvas'))
    // container_selection.inject(Ctrl('backcanvas'))
  // else
    // setTimeout(function(){container_selection.inject(Ctrl('backcanvas'))},300)
 //})

 var availableChartTypes = {
                              category: [ "HBAR","HBAR3D","PYRAMID","LAYEREDBARH",
                                "PIE","PIE3D","RING","RINGPERC",
                                /*"TREEMAP","TREEMAPBAR","TREEMAPBARH",*/"WORDCLOUD",
                                "HSTACKBAR","HSTACKBAR3D","VSTACKBAR","VSTACKBAR3D",
                                "LINES","AREA","STACKEDAREA","RADARLINE","RADARAREA",
                                "VBAR","VBAR3D","PARETO","WATERF","LAYEREDBAR",
                                "PCOORDS", "CAL"
                              ],
                              measure: [
                                "ARCDIAL","THERMO",
                                "LIGHTS","IMAGES",
                                "DISPLAY","COUNTER","PADDLE"
                              ],
                              xyz: ["SCATTER", "BUBBLE", "ASTER", "AREABAR", "VORONOI"],
                              geo: ["GEOMAP"],
                              hie: ["SUNB", "SUNBSTR", "TREE", "TREESTR", "CPACK", "CPACKSTR", "FORCE", "TREEMAP","TREEMAPBAR","TREEMAPBARH","MARIMEKKO"],
                              dep: ["MATRIX", "CHORD", "FORCESTR", "SANKEY"],
                              classif: ["BCMATRIX"]
                            };

function initialCap(txt) {
  if (txt.substr) {
    return txt.substr(0, 1).toUpperCase() + txt.substr(1);
  }
  return '';
}

function GetAvailableChartTypes() {
	return availableChartTypes;
}
function initPainter(){
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
}
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

function dragEnd(/* e */) {
  //Stop capturing mousemove and mouseup events.
  document.id(document).removeEvent("mousemove",dragStart,true);
  document.id(document).removeEvent("mouseup",dragEnd,true)
}
var OnEditProp=false;
function SetOnEditProp(b){
  OnEditProp=b;
}
var selectedProp={};
function SetSelectedProp(itemIdx,propTab,propId){
  selectedProp={
    'itemIdx' : itemIdx,
    'propTab' : propTab,
    'propId' : propId
  };
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
    if (domevt.code==8) managed=true;
    else if(domevt.code==27) //ESC
      resetFormOperation();
    else if (domevt.control && domevt.code==83 && domevt.shift ) { if(tool == 'plan' ){ (parent.saveTool?parent.saveTool([true,index]):(window.save?save(true,index):void(0))); managed=true;} }//CTRL-SHIFT-S
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
            deleteItem();
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
        case 38 : case 39 : case 40 :  case 37 :
          setTimeout("setProperties_("+i_i+")",200)
        break
      }
  }
}
function setProperties_(i){
  if(i==i_i){
    Properties()
    if(typeof(drawLinks)!='undefined'){drawLinks(true);}
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
  if(e.shiftKey==false){
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
            if(itm.offsetTop>y &&  itm.offsetLeft>x && itm.offsetTop+itm.offsetHeight<y+h && itm.offsetLeft+itm.offsetWidth<x+w){
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
                not_selected.push(i);
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
  if(Ctrl("canvashandlers")) Ctrl("canvashandlers").innerHTML=""
  if(!Empty(newPropObj))newPropObj.HideProperties();
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
  str+="<div  id='shadow"+itmIdx+"' tabindex='-1' class='shadow' style='position:absolute;top:"+y+"px;left:"+x+"px;width:"+w+"px;height:"+h+"px;' onmousedown='this.focus();dragShadow(event);' ondblclick='editItemEvent(event,this)'>";
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
  var selecteditem,n
  mainitem=itm
  selecteditem=mainitem.id.substr(6);
  if(index==selecteditem)return;
  // trova lindice del mainitem
  for(var i=0;i<itemsHTML.length;i++){
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
var timestamp = 0;
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
	deltax = (e.pageX)? e.pageX: (e.clientX)? e.clientX: 0;
	deltay = (e.pageY)? e.pageY: (e.clientY)? e.clientY: 0;
	deltax = deltax - parseInt(Ctrl("backcanvas").offsetLeft) - mainitem.offsetLeft + Ctrl("backcanvas").scrollLeft
	deltay = deltay - parseInt(Ctrl("backcanvas").offsetTop) - mainitem.offsetTop + Ctrl("backcanvas").scrollTop
	// l'id � shadown+n e quello dell item � item+n
	mainitem.onmouseup=function(){Ctrl("canvas").onmousemove=null;mainitem.onmouseup=null;if(typeof(showProperties)!='undefined') showProperties('properties')}
  timestamp = Date.now();
	Ctrl("canvas").onmousemove = moveShadow
	Ctrl("canvas").onmouseup=setShadow
  }
  m_bUpdated=true
  e.cancelBubble = true;
  if (e.stopPropagation) e.stopPropagation();
  e.returnValue=false
}

function moveShadow(e){
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
  if(canAlign &&  Date.now() - timestamp > 1000 )
    delta = drawSnap(delta,false);
  for (var p=0;p<itemsHTML.length;p++) {
    if(itemsHTML[p].shadow != "" && Ctrl(itemsHTML[p].shadow)){
      elementShadow=Ctrl(itemsHTML[p].shadow)
      //MG 20120302 beg
      var ret = true;
      if(window.ValidMove) {
        ret = window.ValidMove(elementShadow.offsetLeft+delta[0], elementShadow.offsetTop+delta[1], elementShadow.offsetWidth, elementShadow.offsetHeight,itemsHTML[p].id)
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
      elementShadow.innerHTML="<div class=\"shadow_pos\" ondragstart='noDefaultDrag(event)' onselectstart='noDefaultDrag(event)'>"+strp+"</div>"
    }
  }
}
//funzione che disegna gli allineamenti e le ombre degli oggetti selezionati e ritorna un array con le posizioni ricalcolate
function drawSnap(delta,resizeMode){
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
  var v1_mod = false,v2_mod =false,h1_mod =false,h2_mod =false,dv1_mod =false,dv2_mod =false,dh1_mod =false,dh2_mod =false,mh_mod =false,mv_mod= false;
  var isAlignWidth = false;
  var isNearWidth = false;
  var isResizeMode = resizeMode;
  var  tmp_sel,l_o,t_o,r_o,b_o,h_o,w_o,ddl,ddt,ddr,ddb;
  for(var i=0;i<not_selected.length;i++){
    tmp_sel = itemsHTML[not_selected[i]]
    l_o = parseInt(tmp_sel.x)
    t_o = parseInt(tmp_sel.y)
    h_o = parseInt(tmp_sel.h)
    w_o = parseInt(tmp_sel.w)
    r_o = parseInt(tmp_sel.x) + w_o
    b_o = parseInt(tmp_sel.y) + h_o
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
    if( Math.abs(mh_c -mh_o) < align_delta &&  (!isResizeMode)) { //se c'� una corrispondenza tra i due assi centrali verticali
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
    if( Math.abs(mv_c -mv_o) < align_delta &&  (!isResizeMode )) { //se c'� una corrispondenza tra i due assi centrali orizzontali
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
function setShadow() {
  if(!Empty(mainitem)){
    resetAlign()
    Ctrl("canvas").onmousemove=null
    mainitem.onmouseup=null
    moveItems()
    for (var p=0;p<itemsHTML.length;p++) {
      if(itemsHTML[p].shadow != ""){
        var elementShadow=Ctrl(itemsHTML[p].shadow)
        if(elementShadow)
          elementShadow.innerHTML="";
      }
    }
    Properties()
    if(typeof(showProperties)!='undefined') showProperties('properties')
  }

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
  for (var p=0;p<itemsHTML.length;p++){
    element_tmp=itemsHTML[p];
    elementShadow=Ctrl(element_tmp.shadow);
    if(element_tmp.shadow !="" && elementShadow){
      // elemento ennesimo nell'array
      n=elementShadow.id.substr(6)
      elementtomove=Ctrl("item"+n);
      elementtomove.style.transition='';
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
        ret = window.ValidMove(elementShadow.offsetLeft+dx, elementShadow.offsetTop+dy, elementShadow.offsetWidth, elementShadow.offsetHeight, "item"+n)
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

      elementtomove.style.width=(getOffset(elementtomove).w +dw)+'px';
      elementtomove.style.height=(getOffset(elementtomove).h +dh)+'px';
      elementtomove.style.top=(elementShadow.offsetTop)+'px'; //Spostamento dell'elemento che segue la shadow
      elementtomove.style.left=(elementShadow.offsetLeft)+'px';//Spostamento dell'elemento che segue la shadow
      if(elementtomove.value && !Empty(elementtomove.value)){
        var tmp = elementtomove.value;
        elementtomove.value='';
        elementtomove.value=tmp;
      }
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
      if(Ctrl("handlersWrapper"+n)){
        var w=elementShadow.offsetWidth
        var h=elementShadow.offsetHeight
        var shadowH = ((h-2)>0 ? h-2 : 0 ) +8;  //tolgo i due pixel dei bordi
        var shadowW = ((w-2 )>0 ? w-2 : 0 ) +8;  //tolgo i 2 pixel dei bordi
        Ctrl("handlersWrapper"+n).style.top = (elementShadow.offsetTop -3) +'px';
        Ctrl("handlersWrapper"+n).style.left = (elementShadow.offsetLeft -3)+'px';
        Ctrl("handlersWrapper"+n).style.height = (shadowH)+'px'
        Ctrl("handlersWrapper"+n).style.width = (shadowW)+'px'
        if(Ctrl("handler"+n+"_4")){
          Ctrl("handler"+n+"_5").style.top = (shadowH/2 - 4 )+'px'; //bordi
          Ctrl("handler"+n+"_6").style.top = (shadowH- 18)+'px'; //posizionamento relativo  (18 = size*2 + bordi)
          Ctrl("handler"+n+"_7").style.top = (shadowH/2 - 4)+'px';
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
}
var indexUndo=-1;
var indexRedo=-1;
function Undo() {
  var l,p,ll,idx;
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
  var l,p,ll,idx;
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
        idx = LibJavascript.Array.indexOf(itemsHTML,seqRedo[ll].obj);
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
    url=Strtran(url,"_portlet.jsp","");
    if(url.indexOf("?")>-1){
      url = url.substring(0,url.indexOf("?"));
    }
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
//funzioni cambiamento opacit� div
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
function getOffset(itm){
  var bl =  parseFloat(LibJavascript.DOM.getComputedStyle( itm, "border-left-width" )),
  	br = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "border-right-width" )),
  	bb = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "border-top-width" )),
  	bt = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "border-bottom-width" )),
    ml = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "margin-left" )),
    mr = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "margin-right" )),
    mt = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "margin-top" )),
    mb = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "margin-bottom" )),
    pl = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "padding-left" )),
    pr = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "padding-right" )),
    pt = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "padding-top" )),
    pb = parseFloat(LibJavascript.DOM.getComputedStyle( itm, "padding-bottom" )),
  	gapw = bl+br+ml+mr+pl+pr,
  	gaph =  bb+bt+mt+mb+pt+pb,
  	w= parseFloat(LibJavascript.DOM.getComputedStyle( itm, "width" )),
  	h= parseFloat(LibJavascript.DOM.getComputedStyle( itm, "height" ));

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
    clHRRulersLib.AddHorizontalLine("shadowHLL"+mainitem.id,mainitem.offsetLeft/*-Ctrl("backcanvas").scrollLeft*/, Ctrl("h_ruler").offsetTop, mainitem.id);
    clHRRulersLib.AddHorizontalLine("shadowHLR"+mainitem.id, mainitem.offsetLeft+mainitem.offsetWidth/*-Ctrl("backcanvas").scrollLeft*/, Ctrl("h_ruler").offsetTop ,mainitem.id);
    clVRRulersLib.AddVerticalLine("shadowVLL"+mainitem.id, Ctrl("v_ruler").offsetLeft, mainitem.offsetTop/*-Ctrl("backcanvas").scrollTop*/, mainitem.id);
    clVRRulersLib.AddVerticalLine("shadowVLR"+mainitem.id, Ctrl("v_ruler").offsetLeft, mainitem.offsetTop+mainitem.offsetHeight/*-Ctrl("backcanvas").scrollTop*/, mainitem.id);
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
  clHRRulersLib.AddHorizontalLine("h_ruler_mouse", xpos, parseInt(Ctrl("h_ruler").style.top));
  clVRRulersLib.AddVerticalLine("v_ruler_mouse", parseInt(Ctrl("v_ruler").style.left), ypos);
}

/*Apertura e chiusura della preview*/
var preview_opened=false;
var rsz_prev=null;
function togglePreview(){
  removeAllHandlers();
  EmptyRefLines();
  var i_preview=document.getElementById('i_preview');
  var i_preview_wrapper=document.getElementById('i_preview_wrapper');
  var btn_preview=document.getElementById('btn_preview');
  var morphP= new Fx.Morph(i_preview_wrapper,{ 'duration':'400',transition:Fx.Transitions.easeOut});
  document.getElementById('formproperties').set('morph');
  var i_preview_width =window.getSize().x-(window.getWrapperLeft?window.getWrapperLeft():0);
  // if(tool!='portlet' && !preview_opened && formProp.layout_step && getPreviewLayoutStep){
    // var w = getPreviewLayoutStep()
    // if(w)
      // i_preview.style.width = w+'px';
    // else
      // i_preview.style.width = '';
  // }
  if(!preview_opened){
	  // if(autopreview){
		  // i_preview_wrapper.setStyles({'width':screen.width-10,'height':screen.height-10});
	  // }else{
      i_preview_wrapper.setStyles({'width': i_preview_width,'height':window.getSize().y,'left':window.getSize().x});
	  //}
    if(!i_preview.getAttribute("fixed-height"))
      i_preview.setStyles({'height': window.getSize().y-parseInt(LibJavascript.DOM.getComputedStyle(i_preview, 'margin-top'))});

    if(m_bUpdated){
      var message = this.currentname ? "Do you want to save " + this.currentname + "?" : "Do you want to save?";
      if(confirm(message)) {
      save(function(){
        togglePreview()
      });
      }
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
      case 'report':
        if(reportPreview) reportPreview();
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
  //if(window.setToolbars) window.setToolbars()
  LibJavascript.Events.addEvent(window, 'resize', function() {
    queueResizePreview();
  });
}
function queueResizePreview() {
      clearTimeout(rsz_prev);
      rsz_prev = setTimeout('resizePreview()', 10);
    };
function resizePreview(){
  var i_preview=document.id('i_preview');
  var i_preview_wrapper=document.id('i_preview_wrapper');
  var i_preview_width =window.getSize().x-(window.getWrapperLeft?window.getWrapperLeft():0);
  i_preview_wrapper.setStyles({'width': i_preview_width,'height':window.getSize().y});
  if(!i_preview.getAttribute("fixed-height"))
    i_preview.setStyles({'height': window.getSize().y-parseInt(LibJavascript.DOM.getComputedStyle(i_preview, 'margin-top'))});
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
    if (typeof(curr_request_parms)=='string' && Lower(Right(curr_request_parms,4))=='.vdm'){
      var projectUrl = new JSURL("../servlet/SPVDMProxy?m_cAction=load&m_cConfigName="+Left(curr_request_parms,Len(curr_request_parms)-4), true);
      var myResponse = projectUrl.Response();
      pObj = JSON.parse(myResponse);
      pObj.onOkResource=GetResourceName('');
      if (skinList){
        var found=false;
        for (var i=0; i<pObj.fields.length && !found; i++){
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
    ZtVWeb.Include("../jsp/SPMaskParameters_portlet.jsp?EmitterName=parametersList&ConfigObject="+escape(JSON.encode(pObj))+"&SkinName=PortalStudio"+vdmParams,parameters_wrapper,true);
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

function openNewWindow(url, additionalUrl, height, width, top, left, title){
	left = (left > -1 ? left : ((screen.width) ? (screen.width - width) / 2 : 100));
	top = (top > -1 ? top : ((screen.height) ? (screen.height - height - (height / 4)) / 2 : 100));
	if (IsNetscape() || IsMozilla()) {
		//Per Netscape e Mozilla, il width e height sono leggermente diversi
		width += 5;
		height += 4;
	}

	if (IsIE() && getInternetExplorerVersion() <= 8) {
		OpenWindow(url, width, height, left, top, "toolbar=no,menubar=no,location=no,resizable=yes", title);
		//window.open(url, "expression", "height=" + height + ",width=" + width + ",left=" + left + ",top=" + top + ",resizable=yes");
	}
	else {
		url += additionalUrl;
		openSPModalLayer(url, top, left, width, height, true, 1, false, false);
	}
}

function getChartDefType(def) {
  var cat = "category",
  type = "";
  if (!Empty(def)) {
    var projectUrl = new JSURL("../servlet/SPCHTProxy?m_cAction=load&m_cConfigName=" + def, true),
    myResponse = projectUrl.Response(),
    obj = JSON.parse(myResponse);
    if (obj.graphSettings) {
      type = obj.graphSettings.chartType;
      cat = getChartMacroType(type);
    }
    else if (obj.error)
      cat = "error";
  }
  return { category: cat, type: type };
}

function getChartMacroType(type) {
  var mtypes = GetAvailableChartTypes(),
      mkeys = Object.keys(mtypes),
      found = false,
      rt = "";
  for (var t = 0; !found && t < mkeys.length; t++) {
    if (mtypes[mkeys[t]].indexOf(type) >= 0) {
      rt = mkeys[t];
      found = true;
    }
  }
  return rt;
}

function checkChartDef(chartName) {
  if (Empty(chartName))
    return true;
  if (chartName.indexOf("type:") == 0) {
    SetSmartChartdef(chartName);
    return true;
  }
  var chartdef = getChartDefType(chartName),
    mcat = chartdef.category,
    chartType = formProp.chart_type || itemsHTML[index].chart_type;
  if (mcat != "error") {
    if (chartdef.type == "PCOORDS" || chartdef.type == "VORONOI" || chartdef.type == "RINGPERC" || chartdef.type == "ASTER") {
      mcat = chartdef.type;
    }
    if (!Empty(chartdef.type) && index != null) {
      itemsHTML[index].ctype = chartdef.type;
      setPropertyValue(false, "generic", "ctype", chartdef.type);
    }

    if (mcat != chartType) {
      //PSAlert.alert("The selected def is a " + mcat + " chart")
      if (!Empty(tool) && formProp.chart_type){
        formProp.chart_type=mcat;
        formProp.chartDef=chartName;
        FormProperties()
        propertyChangeNotifier.bind(formProp.objClass.newProperties.ChartOptions[1])(mcat,true,true);
      }
      else {
        itemsHTML[index].chart_type = mcat;
        itemsHTML[index].def = chartName;
        Properties(true);
      }
    }
  }
  else {
    PSAlert.alert("Chart Definition not Found");
    return false;
  }
  return true;
}

function checkChartType(chartType) {
  if(Empty(chartType))
    return true;
  var chartDef=formProp.chartDef||itemsHTML[index].def;
    if(Empty(chartDef))
      return true;
    var mcat = getChartDefType(chartDef).category;
    if(mcat=="error")
      return false;
   /* if(mcat!=chartType)
      PSAlert.alert("Chart Definition type doesn't match with "+chartType+" type");*/
  return true;
}
function LoadFieldsConfigurator() {
  if (!Empty(arguments)) {
    var propid = arguments[0].refPropId;
    viewFieldsConfigurator(propid);
  }
}

function viewFieldsConfigurator(/*isForm,pChartDef,chartType*/propid, isForm, query) {
  if (index != null || isForm) {
		var width = 655, //1150,
    height = 655,
    pQuery = query;

    if (!pQuery){
      var isServerSide = CharToBool(itemsHTML[index].gendataset);
      if (isServerSide)
        pQuery = itemsHTML[index].query;
      else {
        if (!Empty(tool) && tool=="portlet") {
          var found = false;
          for(var i=0; i<itemsHTML.length && !found; i++){
            if(i!=index && itemsHTML[i].name == itemsHTML[index].dataobj){
              pQuery = itemsHTML[i].query;
              found = true;
            }
          }
        }
        else
          pQuery = itemsHTML[index].query;
          //pQuery = getPropertyValue(false,'dataset','query');
      }
    }

    // caso fields non vuoti
    var pValues = "";
    if (isForm)
      pValues = formProp[propid]; //getPropertyValue(true, "ChartOptions", propid);
    else
      pValues = getPropertyValue(false, "fields", propid);
		var url = "../jsp-system/SPChartFieldsConfigurator_portlet.jsp";
    url += "?vqr=" + pQuery;
    url += "&key=" + propid;
    url += "&values=" + pValues;
    url += "&isdataobj=true";
    var additionalUrl = "&SPModalLayerId=chartFieldsSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1);
	}
}

function GetFieldsForChart(pQuery) {
  var ok = false,
  isPortlet = (!Empty(tool) && tool=="portlet"),
  isPZoom = (!Empty(tool) && tool == "portalzoom");
  if (isPZoom) {
    if (getIsForm)
      ok = getIsForm(pQuery);
  }
  if (index != null || ok) {
    var dataobj_index = -1;
    if (isPortlet) {
      var found = false;
      for(var i=0; i<itemsHTML.length && !found; i++){
        if (i != index && itemsHTML[i].name == itemsHTML[index].dataobj) {
          dataobj_index = i;
          found = true;
        }
      }
    }

    var fields_array = [];
    if (dataobj_index >= 0) {
      var recheck = true;
      if (itemsHTML[dataobj_index].GetQueryFields) {
        fields_array = itemsHTML[dataobj_index].GetQueryFields(pQuery, true);
        recheck = Empty(fields_array);
      }
      if (pQuery && recheck)
        fields_array = GetQueryFields(pQuery, true);
    }
    else if (pQuery) {
      if (isPZoom && !Empty(vqrfields)) {
        fields_array[0] = []; //alias
        fields_array[1] = []; //desc
        fields_array[2] = []; //type
        for (var j = 0; j < vqrfields.length; j++) {
          // trasformo array di oggetti in matrice compatibile con dprovider
          fields_array[0].push(vqrfields[j].alias);
          fields_array[1].push(vqrfields[j].desc);
          fields_array[2].push(vqrfields[j].type);
        }
      }
      else
        fields_array = GetQueryFields(pQuery, true);
    }

    return fields_array;
  }
}

function LoadSeriesConfigurator(isForm, chartType, fields, series) {
  if (index != null || isForm) {
		var width = 1150,
    height = 655;

    chartType = chartType || itemsHTML[index].chart_type

    if (chartType != "category") {
      PSAlert.alert("The selected properties is valid only for category charts");
      return;
    }

    fields = fields || itemsHTML[index].value_fields;
    series = series || itemsHTML[index].label_series;

    var mapS = itemsHTML[index].mapSeries || "";

		var url = "../jsp-system/SPChartSeriesConfigurator_portlet.jsp";
    url += "?pagetype=1";
    url += "&fields=" + fields;
    url += "&series=" + series;
    url += "&prop=" + mapS;
    url += "&index=" + index;
    url += "&callerFunction=receiveConfigSeries";
		var additionalUrl = "&SPModalLayerId=chartSeriesSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1);
	}
}

// ripristina le classi come oggetto JSON da un file .ce.css
function restoreClassFromFile(file) {
  var url, res;
  if(file && file != 'undefined') {
    file = file.replace(".ce.css","");
    url = new JSURL("../servlet/JSPReader?type=classeditor&all=true&withPath=true",true);
    var availFile = (url.Response()).split(',');
    var found = false;
    for(var i = 0; i < availFile.length && !found; i++) {
      // uniformo i nomi file
      if(availFile[i].split("\\").join("/").replace(".ce.css","") == file) found = true;
    }

    if(found) {
      url = new JSURL("../servlet/JSPLoad?type=cssdef&name="+file,true);
      try {
        res = JSON.parse(url.Response());
      } catch (e) {
        console.error("Error reading JSON def of file: " + file + ".ce.css");
        res = new Array();
      }
    }
    return res;
  }
}

/*
function SelectChartDef(PortletItemIndex, isForm, ctrlid) {
  if (IsIE() && getInternetExplorerVersion() <= 8) {
    var PortletItemName = itemsHTML[PortletItemIndex].name;
    var PortletItemDef = itemsHTML[PortletItemIndex].def;
    var TempArray2 = new JSURL("../servlet/SPChartServlet");
    TempArray2 = TempArray2.Response();
    TempArray2 = TempArray2.split(",");
    TempArray = [];
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
*/
function NewChartDef(/*index*/) {
  if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    parent.newCurrentObj('New','chart',{});
}
function EditChartDef(index) {
  var chartDef = "";
  if ((tool == 'portalzoom') || (tool == 'visualpivot') )
    chartDef = formProp.chartDef;
  else
    chartDef = itemsHTML[index].def
  if (LRTrim(chartDef) == "")
    PSAlert.alert("No chart selected.");
  else if (chartDef.indexOf("type:") == 0)
    PSAlert.alert("Cannot edit chartdef.");
  else if (checkChartDef(chartDef)) {
    if (parent.newCurrentObj != null && parent.portalStudioContainer)
      parent.newCurrentObj(chartDef, "chart", {});
    else
      window.open("../chart/index.jsp?onpopup=true&filename=" + chartDef, "Chartdef", "height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}
function PickItems(tool,retTo,top, left, width, height){
  var offlinemode='';
  var ind=(GetOpener()? GetOpener().index : index);
  var itemsH=(GetOpener()?GetOpener().itemsHTML : itemsHTML);
  if(ind!=null && itemsH[ind].offline=='true') offlinemode="&offlinemode=true";
  if(typeof tool === 'object') {
    let queryString = '';
    for(let arg in tool) {
      if(arg!='dimensions') {
        queryString += queryString === '' ? '?' : '&'
        queryString += arg + '=' + tool[arg];
      }
    }
    queryString+='&onetool=true&callerFunction=ExpressionBuilderReturn&SPModalLayerId='+LibJavascript.AlfaKeyGen()+offlinemode+"&close-sidebar=true";
    window.layerOpenForeground("../portalstudio/open.jsp" + queryString, 'Select ' + tool.tool,'', tool.dimensions.width, tool.dimensions.height, true, 1);
  } else {
  //openSPModalLayer("../portalstudio/open.jsp?tool="+tool+"&onetool=true&ExpressionID="+retTo+"&callerFunction=ExpressionBuilderReturn&SPModalLayerId=querySPModalLayer"+offlinemode, t, l, width, height, true, 1, false, false);
      window.layerOpenForeground("../portalstudio/open.jsp?tool="+tool+"&onetool=true&ExpressionID="+retTo+"&callerFunction=ExpressionBuilderReturn&SPModalLayerId="+tool+"SPModalLayer"+offlinemode+"&close-sidebar=true","Select "+tool,'',width,height,true,1);
    }
  }
function ExpressionBuilderReturn(id,value,pars,toolList){
  if (id) {
    //var el = (GetOpener()?GetOpener().Ctrl(id) : Ctrl(id));
    var el = Ctrl(id);
    if (el) {
      if(toolList=='portlet')
        value=value+'_portlet.jsp';
      if( el.getAttribute("list")=='true' ){
        el.value = (!Empty(el.value)?el.value+','+value:value);
      }else{
        el.value = value;
      }
      el.focus();
      el.blur();//In questo modo fa Updateproperties
      el.focus();
    }
  }
}
PSAlert.init(window, '');

function SelectCss(retTo){
  pickerObj = [];
  pickerObj[0] = new Array();
  pickerObj[0].title = "CSS list available";
  var url = new JSURL("../servlet/JSPReader?type=allcss", true);
  var tmp_list = url.Response();
  pickerObj[0].list = tmp_list.split(',');
  window.layerOpenForeground("../portalstudio/picker.jsp?for="+retTo+"&type=css&mode=multiple","SelectCSSFile",'',300,500,true,1);
}

function selectClass(retTo,typeObj){
  window.layerOpenForeground("../classeditor/classPicker.jsp?for="+retTo+"&type="+typeObj+"&mode=insert","SelectCSSFile",'',300,500,true,1);
}
function newClass(retTo,typeObj) {
  var mar_left = 50, width = ((window.frameElement && window.frameElement.clientWidth) ? (window.frameElement.clientWidth - mar_left*2) : 1124);
  var mar_top = 25, height = ((window.frameElement && window.frameElement.clientHeight) ? (window.frameElement.clientHeight - mar_top*2) : 720);
  var valto = Ctrl(retTo).value.split(" ");
  var url = "../classeditor/editor.jsp?name=" + ((valto.length == 1) ? encodeURIComponent(valto[0]) : "") + "&type=" + typeObj + "&&css=portlet";
  openSPModalLayer(url, mar_top, mar_left, width, height, true, 1, false, true);
}
function allClass(typeObj) {
  window.layerOpenForeground("../classeditor/classPicker.jsp?mode=all&type="+typeObj,"SelectCSSFile",'',300,500,true,1);
}
function editClass(retTo,typeObj,file) {
  if(!file){
    window.layerOpenForeground("../classeditor/classPicker.jsp?for="+retTo+"&mode=edit&type="+typeObj,"SelectCSSFile",'',300,500,true,1);
    return;
  }
  var files = file.split(',');
  for(var i=0;i<files.length;i++){
    file = files[i];
    if(file.indexOf('styles/')>-1 && file.indexOf('.ce.') == -1 ){
      parent.newCurrentObj(Strtran(Strtran(file,'.css',''),'styles/',''), 'css');
    }else{
      window.layerOpenForeground("../classeditor/classPicker.jsp?for="+retTo+"&mode=edit&type="+typeObj,"SelectCSSFile",'',300,500,true,1);
    }
  }
}
function selectImage(retTo){
  var mar_left = 50, width = ((window.frameElement && window.frameElement.clientWidth) ? (window.frameElement.clientWidth - mar_left*2) : 1124);
  var height = 565, mar_top = ((window.frameElement && window.frameElement.clientHeight) ? (window.frameElement.clientHeight - height)/2 : 35);
  var url = "../jsp-system/SPImagesReader_portlet.jsp?retTo="+retTo;
  window.openSPModalLayer(url, mar_top, mar_left, width, height, true, 1, false, true);
}

function SelectIcons( obj ) {
  var url = "../visualweb/select_icons.html?for=" +obj.index+"&rtrnobj="+obj.refPropId;
  if (obj.multiple)
    url += "&multiple="+URLenc(obj.multiple);
  if (obj.font_path)
    url += "&font_path="+URLenc(obj.font_path);
    if (obj.font_name)
    url += "&font_name="+URLenc(obj.font_name);
  window.layerOpenForeground(url,"SelectField",'',350,500,true,1);
}

function SelectFont( retTo ) {
  pickerObj = [];
  pickerObj[0] = new Array();
  pickerObj[0].title = "Fonts list available";
  var url = new JSURL("../servlet/JSPReader?type=fontIcon", true);
  var tmp_list = url.Response();
  pickerObj[0].list = tmp_list.split(',');
  window.layerOpenForeground("../portalstudio/picker.jsp?for="+retTo+"&type=fontIcon","SelectFontIcon",'',350,500,true,1);
}


/* ========================================================================
 * PSTooltip v1.0.0
 * ========================================================================
 * Tooltip used to display a small "hover box" with information about the
 * item being hovered over.
 * ======================================================================== */
PSTooltip.ELEMENT = null
PSTooltip.ARROW = null
PSTooltip.DEFAULTS = {
  placement: 'auto',
  class: '',
  html: false,
  text: 'No text for this tooltip',
  vertical_margin: 8,
  arrow_size: 5,
  width:null
}

function PSTooltip(container, options) {
  return new PSTooltip._innerClass(container, options);
}
PSTooltip._innerClass = function(container, options) {
  this.positions  = {
    arrow: 0,
    left: 0,
    top: 0
  }
  this.container   = container;
  this.options     = PSTooltip._innerClass.getOptions(options);

  /* associa ascoltatori */
  container.addEventListener("mouseenter", this, false);
  container.addEventListener("mouseout", this, false);

  /* crea subito DOM per evitare primo rallentamento */
  PSTooltip._innerClass.create();
}

/**
 * [getOptions]
 * @param  {[Object]} options [Oggetto contenente le opzioni utente]
 * @return {[Object]}         [Opzioni utente + opzioni default]
 */
PSTooltip._innerClass.getOptions = function (options) {
  var res = {};
  for(var p in PSTooltip.DEFAULTS)
    res[p] = (options[p] == null) ? PSTooltip.DEFAULTS[p] : options[p];
  return res
}

/**
 * [applyPlacement posiziona il tooltip e la relativa freccia con le giuste cordinate in assoluto]
 */
PSTooltip._innerClass.prototype.applyPlacement = function() {
  var autoPlace = (this.options.placement == 'auto') ? true : false;

  // posizione tooltip di default (centrata)
  this.positions.top = this.container.getBoundingClientRect().top + this.container.clientHeight/2 - PSTooltip.ELEMENT.clientHeight/2;

  // posizione freccia di default (centrata al tooltip)
  this.positions.arrow = PSTooltip.ELEMENT.clientHeight/2 - this.container.clientHeight/2;

  if(autoPlace) {
    // controllo se nella parte sinistra (true) o destra (false) della finsetra
    var autoPosition = (this.container.getBoundingClientRect().left < window.innerWidth/2) ? 'right' : 'left';

    if(this.container.getBoundingClientRect().top < window.innerHeight/2) { // controllo se nella parte superiore (true) o inferiore (false) della finestra
      this.positions.top = this.container.getBoundingClientRect().top - this.options.vertical_margin; // sposto il tooltip verso il basso
      this.positions.arrow = this.options.vertical_margin; // posiziono la freccia nella parte superiore del tooltip
    } else {
      this.positions.top = this.container.getBoundingClientRect().top - PSTooltip.ELEMENT.clientHeight + this.container.clientHeight + this.options.vertical_margin
        + document.getScrollTop(); // sposto il tooltip verso l'alto
      this.positions.arrow = PSTooltip.ELEMENT.clientHeight - this.container.clientHeight - this.options.vertical_margin; // posiziono la freccia nella parte inferiore del tooltip
    }
  }

  // riposiziono il tooltip in base alla posizione dell'icona
  if(this.options.placement == 'left' || autoPosition == 'left') {
    this.positions.left = this.container.getBoundingClientRect().left - PSTooltip.ELEMENT.clientWidth - this.options.arrow_size;
    PSTooltip.ELEMENT.classList.add('left');
    PSTooltip.ELEMENT.classList.remove('right');
  } else if(this.options.placement == 'right' || autoPosition == 'right') {
    this.positions.left = this.container.getBoundingClientRect().left + this.container.clientWidth + this.options.arrow_size;
    PSTooltip.ELEMENT.classList.add('right');
    PSTooltip.ELEMENT.classList.remove('left');
  }
  PSTooltip.ELEMENT.style.top  = Math.round(this.positions.top) + "px";
  PSTooltip.ELEMENT.style.left = Math.round(this.positions.left) + "px";
  PSTooltip.ARROW.style.top    = Math.round(this.positions.arrow) + "px";
  //forzo la width per tooltip particolari
  if(this.options.width != null){
    PSTooltip.ELEMENT.style.maxWidth = this.options.width+'px';
  }else{
    PSTooltip.ELEMENT.style.maxWidth = '';
  }
}


/**
 * [show viene mostrato il tooltip, se non ancora creato, al primo hover viene anche costruito con create()]
 */
PSTooltip._innerClass.prototype.show = function() {
  var span = PSTooltip.ELEMENT.querySelector("span");
  if(this.options.html) {
    span.innerHTML = this.options.text;
  } else {
    span.innerHTML = '';
    span.appendChild(document.createTextNode(this.options.text));
  }

  PSTooltip.ELEMENT.className = "pstooltip " + this.options.class;
  this.applyPlacement();
  PSTooltip.ELEMENT.style.opacity = 1;
  PSTooltip.ELEMENT.style.visibility = 'visible';
}

PSTooltip._innerClass.hide = function() {
  PSTooltip.ELEMENT.style.opacity = 0;
  PSTooltip.ELEMENT.style.visibility = 'hidden';
}

PSTooltip._innerClass.prototype.handleEvent = function(e) {
  if(e.type == 'mouseenter') {
    this.show();
  } else if(e.type == 'mouseout') {
    PSTooltip._innerClass.hide();
  }
}

/**
 * [create funzione che crea il tooltip e la freccia che indica da dove � partito]
 */
PSTooltip._innerClass.create = function() {
  if(PSTooltip.ELEMENT == null) {
    PSTooltip.ELEMENT = document.createElement("div");
    PSTooltip.ELEMENT.className = "pstooltip";
    PSTooltip._innerClass.hide(); // parte nascosto, poi viene mostrato in modo da avere la transizione
    PSTooltip.ELEMENT.appendChild(document.createElement("span"));
    document.body.appendChild(PSTooltip.ELEMENT);
  }

  if(PSTooltip.ARROW == null) {
    PSTooltip.ARROW = document.createElement("i");
    PSTooltip.ARROW.className = "icon arrow";
    PSTooltip.ELEMENT.appendChild(PSTooltip.ARROW);
  }
}

function NewVdmMask(/*index, isForm*/) {
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj("New", "maskparameters",{} );
  }
  else {
    window.open("../maskparameters/maskparameters.jsp", "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function EditVdmMask(index, isForm, name) {
  var vdmFile='';
  if (isForm)
    vdmFile = formProp[name];
  else vdmFile = itemsHTML[index][name]
  if (LRTrim(vdmFile) == "") {
    PSAlert.alert("No mask file selected.");
    return;
  }
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj(vdmFile, "maskparameters");
  }
  else {
    window.open("../maskparameters/maskparameters.jsp?filename=" + vdmFile, "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function SelectVdmMask(index, isForm, ctrlid) {
  var width = 1000;
  var height = 600;
  var url = "../portalstudio/open.jsp?tool=maskparameters&onetool=true&ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionBuilderReturn";
  var additionalUrl = "&SPModalLayerId=vdmSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1);
}

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
  return { apiType : currentAPIType, apiObj : currentAPIClass};
}

var apiSamples = {};
function getComponentSamples(apiType) {
  return apiSamples[apiType];
}

function setComponentSamples(apiType, samples) {
  return apiSamples[apiType] = samples;
}

function renderApiForm() {
  if(formProp) renderApi(formProp);
}

function LoadClassificationConfigurator(isForm, chartType) {
  if (index != null || isForm) {
		var width = 1150,
    height = 655;

    chartType = chartType || itemsHTML[index].chart_type

    if (chartType != "dep") {
      PSAlert.alert("The selected properties is valid only for dependencies charts");
      return;
    }

    var dclass = itemsHTML[index].depclass || "";

    var url = "../jsp-system/SPChartSeriesConfigurator_portlet.jsp";
    url += "?pagetype=2";
    url += "&prop=" + URLenc(dclass);
    url += "&index=" + index;
    url += "&callerFunction=receiveConfigClassSeries";
		var additionalUrl = "&SPModalLayerId=chartSeriesSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1);
	}
}

function StartChartWizard(/*index*/) {
  var width = 1150,
    height = 655,
    left = window.innerWidth > 0 ? ((window.innerWidth - width) / 2) : -1,
    top = window.innerHeight > 0 ? ((window.innerHeight - height) / 2) : -1,
    url = "../jsp-system/SPChartWizard_portlet.jsp?tool=" + tool;
  openSPModalLayer(url, top, left, width, height, true, 1, true);
}

/* *** Lettura delle librerie *** */
function readLibrary(name, arr) {
  var str, node, fun, desc, params, pName, pDesc;
  loadDocumentXML(name);
  if (xmlDoc != null) {
    node = getNodesXML(xmlDoc, "function");
    var n, n1;
    for (n = 0; n < node.length; n++) {
      fun = getTagValue(node[n], "name");
      desc = getTagValue(node[n], "description");
      params = getNodesXML(node[n], "parameter");
      str = '';
      if (params.length > 0) {
        str = "(";
        for (n1 = 0; n1 < params.length; n1++) {
          pName = getTagValue(params[n1], "name");
          //pType = getTagValue(params[n1], "type");
          pDesc = getTagValue(params[n1], "description");
          str += pName + ",";
          if (typeof(pDesc) != 'undefined' && pDesc != "") {
            desc += "<br>   <b>" + pName + ":</b> " + pDesc;
          }
        }
        str = str.substr(0, str.length - 1);
        str += ")";
      }
      arr.push([fun, str, desc]);
    }
    //ordina in base alla descrizione
    arr.sort(function (e1, e2) {
      return (e1[0] <= e2[0] ? -1 : 1);
    });
  }
}
/* *** Fine lettura delle librerie *** */
