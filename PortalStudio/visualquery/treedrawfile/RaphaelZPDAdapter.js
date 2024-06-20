

/*
Interfaccia per l'implementazione delle funzionalita di zoom e pan
*/
//creo un oggetto di tipo ZPDAdapter
/* exported RaphaelZPDAdapter */
function RaphaelZPDAdapter() {
  var _size,
  outerthis=this,
  _paper,
  viewport,
  _zoom,
  _pan,
  _dim,
  _scroll,
  scrollbarHorizontal,
  scrollbarVertical,
  _nomeId;
	this.init=function(paper,nomeId, isZoom, isPan, isScroll){
    _paper=paper;
    _zoom=isZoom;
    _pan=isPan;
    _nomeId=nomeId;
    _scroll=isScroll;
    this.gelem = document.createElementNS('http://www.w3.org/2000/svg', 'g');
    this.gelem.id = 'viewport';
    _paper.canvas.appendChild(this.gelem);
    viewport=document.getElementById('viewport');

    function overrideElements(paper) {
      var elementTypes = ['circle', 'rect', 'ellipse', 'image', 'text', 'path'];
      for(var i = 0; i < elementTypes.length; i++) {
        overrideElementFunc(paper, elementTypes[i]);
      }
    }

    function overrideElementFunc(paper, elementType) {
      paper[elementType] = function(oldFunc) {
        return function() {
        var element = oldFunc.apply(paper, arguments);
        element.gelem = outerthis.gelem;
        outerthis.gelem.appendChild(element.node);
        return element;
        };
      }(paper[elementType]);
    }

    overrideElements(paper);

    var noZoomBrowser = function (e) {
      var stub;
      if ((GetKeyCode(e) == 187 || GetKeyCode(e) == 107 || (IsOpera() && (GetKeyCode(e)==61 || GetKeyCode(e)==43))) && e.ctrlKey === true) { // + sia tastiera che tastierino numerico
        CancelEvent(e);
        // outerthis.zoom(-5);
        if (navigator.userAgent.toLowerCase().indexOf("webkit") >= 0) {
          stub = {target : {ownerDocument : document},
          clientX : document.width / 2,
          clientY : document.height / 2,
          detail : -5
          };
        }
      else {
        stub = {target : {ownerDocument : document},
          clientX : window.innerWidth / 2,
          clientY : window.innerHeight / 2,
          detail : -5
        };
      }
      outerthis.handleMouseWheel(stub);


      }
      else if ((GetKeyCode(e) == 189 || GetKeyCode(e) == 109 || (IsOpera() && GetKeyCode(e)==45)) && e.ctrlKey === true) { //  - sia tastiera che tastierino numerico
        CancelEvent(e);
        if (navigator.userAgent.toLowerCase().indexOf("webkit") >= 0) {
          stub = {target : {ownerDocument : document},
          clientX : document.width / 2,
          clientY : document.height / 2,
          detail : 5
          };
        }
      else {
        stub = {target : {ownerDocument : document},
          clientX : window.innerWidth / 2,
          clientY : window.innerHeight / 2,
          detail : 5
        };
      }
      outerthis.handleMouseWheel(stub);

      }
    }
    window.document.addEventListener("keydown", noZoomBrowser);

	}

 this.zoom=function(value){
  var stub;
    if (navigator.userAgent.toLowerCase().indexOf("webkit") >= 0) {
      stub = {target : {ownerDocument : document},
        clientX : document.width / 2,
        clientY : document.height / 2,
        detail : value
      };
    }
    else {
      stub = {target : {ownerDocument : document},
        clientX : window.innerWidth / 2,
        clientY : window.innerHeight / 2,
        detail : value
      };
    }
    this.zoomWheel(stub);
 }



  this.zoomWheel=function(evt){
    var delta;

    if (evt.wheelDelta) {
      delta = evt.wheelDelta / 3600; // Chrome/Safari
    }
    else {
      delta = evt.detail / -90; // Mozilla
    }

    this.getCTM();

    /*calcolo il punto del mouse*/
    var p = _paper.canvas.createSVGPoint();

    p.x = evt.clientX;
    p.y = evt.clientY;
    var z = 1 + delta;
    p = p.matrixTransform(this.getCTM().inverse());
    var k = _paper.canvas.createSVGMatrix().translate(p.x, p.y).scale(z).translate(-p.x, -p.y);
    this.setCTM(this.getCTM().multiply(k),true);
  }

  this.getCTM=function(){

    return viewport.getCTM();
  }
  this.setCTM=function(matrix,zoom){

    if (matrix.e>=100)
      matrix.e=99.9;
    if (matrix.f>=100)
      matrix.f=99.9;
    var spost;
    var size=[];
    size[0]=(_size[0]*matrix.a)-_dim[0];
    size[1]=(_size[1]*matrix.a)-_dim[1];
    var s;
    if (size[0]>0){
      if (size[1]>0){
        if (zoom){
          if ((matrix.e)<=(-(100+size[0]))){
            matrix.e=-(100+size[0])+0.1;
          }
          if ((matrix.f)<=(-(100+size[1]))){
            matrix.f=-(100+size[1])+0.1
          }
        }
        if ((matrix.e)>(-(100+size[0])) &&   (matrix.f)>(-(100+size[1]))){

          s = "matrix(" + matrix.a + "," + matrix.b + "," + matrix.c + "," + matrix.d + "," + matrix.e + "," + matrix.f + ")";
          viewport.setAttribute("transform", s);
          return true;
        }
      }
      else {// in altezza ci sta
        if (zoom){
          if (matrix.f>0)
            spost=_dim[1]+(matrix.f);
          else
            spost=_dim[1]-(matrix.f);

          if (-size[1]>spost)
            matrix.f=spost+size[1];
          else
            matrix.f=0;
        }
        if ( matrix.e>(-(100+size[0])) && matrix.f>(-100)){
          s = "matrix(" + matrix.a + "," + matrix.b + "," + matrix.c + "," + matrix.d + "," + matrix.e + "," + matrix.f + ")";
          viewport.setAttribute("transform", s);
          return true;
        }
      }
    }
    else {
      if (size[1]>0){
          if (zoom){
            if (matrix.e>0)
              spost=_dim[0]+(matrix.e);
            else
              spost=_dim[0]-(matrix.e);

            if (-size[0]>spost)
              matrix.e=spost+size[0];
            else
              matrix.e=0;

          }
        if (matrix.e>(-100)&& matrix.f>(-(100+size[1]))){
           s = "matrix(" + matrix.a + "," + matrix.b + "," + matrix.c + "," + matrix.d + "," + matrix.e + "," + matrix.f + ")";
          viewport.setAttribute("transform", s);
          return true;
        }
      }
      else {

        if (zoom){
          if (matrix.e>0)
            spost=_dim[0]+(matrix.e);
          else
            spost=_dim[0]-(matrix.e);

          if (-size[0]>spost)
            matrix.e=spost+size[0];
          else
            matrix.e=0

          if (matrix.f>0)
            spost=_dim[1]+(matrix.f);
          else
            spost=_dim[1]-(matrix.f);

          if (-size[1]>spost)
            matrix.f=spost+size[1];
          else
            matrix.f=0;
        }
        if (matrix.e>(-100) && matrix.f>(-100)){
          s = "matrix(" + matrix.a + "," + matrix.b + "," + matrix.c + "," + matrix.d + "," + matrix.e + "," + matrix.f + ")";
          viewport.setAttribute("transform", s);
          return true;
        }

      }
    }

    return false;
  }

  this.setSizeTree=function(sizeTree,dimCanvas){
    _size=sizeTree;
    _dim=dimCanvas
    if (_scroll){
      //crea scrollbar se necessario
      if (_dim[0]<_size[0]){
        scrollbarHorizontal=new scrollbarSVG();
        scrollbarHorizontal.createScrollbarHorizontal('scrollbarHorizontal',_dim[0]-5,6,_size,outerthis);
      }
      if (_dim[1]<_size[1]){
        scrollbarVertical=new scrollbarSVG();
        scrollbarVertical.createScrollbarVertical('scrollbarVertical',6,_dim[1]-5,_size,outerthis);
      }
    }
    if (_pan){
      panInitialize();
    }
    if (_zoom){
      _paper.canvas.addEventListener('mousewheel', outerthis.handleMouseWheel, false); // Chrome/Safari/IE/Opera
      _paper.canvas.addEventListener('DOMMouseScroll', outerthis.handleMouseWheel, false); // Firefox
    }
  }


  this.handleMouseWheel=function(evt){
    outerthis.zoomWheel(evt);
    var matrix=outerthis.getCTM();
    var dimTree=[];
    dimTree[0]=_size[0]*matrix.a;
    dimTree[1]=_size[1]*matrix.a;
    if (scrollbarHorizontal)
      scrollbarHorizontal.deleteScrollbar();
    if (scrollbarVertical)
      scrollbarVertical.deleteScrollbar();
    if (dimTree[0]>_dim[0]-100){
      scrollbarHorizontal=new scrollbarSVG();
      scrollbarHorizontal.createScrollbarHorizontal('scrollbarHorizontal',_dim[0]-5,6,dimTree,outerthis);
      scrollbarHorizontal.mouseDown();
      scrollbarHorizontal.mouseMoveX(matrix.e);
    }
    if (dimTree[1]>_dim[1]-100){
      scrollbarVertical=new scrollbarSVG();
      scrollbarVertical.createScrollbarVertical('scrollbarVertical',6,_dim[1]-5,dimTree,outerthis);
      scrollbarVertical.mouseDown();
      scrollbarVertical.mouseMoveY(matrix.f);
    }
  }

  function panInitialize(){
    var initialPositionX,
    initialPositionY,
    initialPositionXTree,
    down,
    initialPositionYTree;
    document.getElementById(_nomeId).onmousedown = function(e) {
      if (pan){
        down=true;
        initialPositionX=e.clientX;
        initialPositionY=e.clientY;
        if (scrollbarHorizontal)
          scrollbarHorizontal.mouseDown()
        if (scrollbarVertical)
          scrollbarVertical.mouseDown()
        initialPositionXTree=outerthis.getCTM().e
        initialPositionYTree=outerthis.getCTM().f
      }
    };
    document.getElementById(_nomeId).onmousemove = function(e) {
      var matrix1;
       if (down){
          var matrix=outerthis.getCTM();
            if (initialPositionX>0)
              matrix.e=initialPositionXTree+(e.clientX-initialPositionX);
            else
              matrix.e=initialPositionXTree-(e.clientX-initialPositionX);
          if (outerthis.setCTM(matrix)){
            if (scrollbarHorizontal){
              matrix1=outerthis.getCTM();
              scrollbarHorizontal.mouseMoveX(matrix1.e-initialPositionXTree)
              }
          }
          matrix=outerthis.getCTM();
            if (initialPositionY>0)
              matrix.f=initialPositionYTree+(e.clientY-initialPositionY);
            else
              matrix.f=initialPositionYTree-(e.clientY-initialPositionY);
          if (outerthis.setCTM(matrix)){
            if (scrollbarVertical){
                  matrix1=outerthis.getCTM();
              scrollbarVertical.mouseMoveY(matrix1.f-initialPositionYTree)
            }
          }
        }
    };
    document.getElementById(_nomeId).onmouseup = function(/*e*/) {
      down=false;
    };
  }


  this.movePaper=function(x,y){
    var initialPosition=outerthis.getCTM();
    var matrix=outerthis.getCTM();
    var matrix1;
    matrix.e=matrix.e+x;
    matrix.f=matrix.f+y;
    if (outerthis.setCTM(matrix)){
      if (scrollbarHorizontal){
         scrollbarHorizontal.mouseDown();
         matrix1=outerthis.getCTM();
          scrollbarHorizontal.mouseMoveX(matrix1.e-initialPosition.e)
      }
      if (scrollbarVertical){
       scrollbarVertical.mouseDown();
       matrix1=outerthis.getCTM();
       scrollbarVertical.mouseMoveY(matrix1.f-initialPosition.f);
      }
    }
  }


  this.createScrollbar=function(){
    outerthis.deleteScrollbar();
    var matrix=outerthis.getCTM();
    var dimTree=[];
    dimTree[0]=_size[0]*matrix.a;
    dimTree[1]=_size[1]*matrix.a;

   if (dimTree[0]>_dim[0]-100){
      scrollbarHorizontal=new scrollbarSVG();
      scrollbarHorizontal.createScrollbarHorizontal('scrollbarHorizontal',_dim[0]-5,6,dimTree,outerthis);
      scrollbarHorizontal.mouseDown();
      scrollbarHorizontal.mouseMoveX(matrix.e);
    }
    if (dimTree[1]>_dim[1]-100){
      scrollbarVertical=new scrollbarSVG();
      scrollbarVertical.createScrollbarVertical('scrollbarVertical',6,_dim[1]-5,dimTree,outerthis);
      scrollbarVertical.mouseDown();
      scrollbarVertical.mouseMoveY(matrix.f);
    }

  }


  this.deleteScrollbar=function(){
    if (scrollbarHorizontal)
      scrollbarHorizontal.deleteScrollbar();
    if (scrollbarVertical)
      scrollbarVertical.deleteScrollbar();
  }

};
var pan=true;
