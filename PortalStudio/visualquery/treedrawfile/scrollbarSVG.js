/* exported scrollbarSVG */
function scrollbarSVG() {
  var _canvas,_raphaelZPD,_width,_sizeScroll,_initialPositionX,_initialPositionY,_scrollbar,_height;
  var _matrix;
  var margin=100;
  var delta=margin*2;

  this.createScrollbarHorizontal = function(nomeId,w,h,size,raphaelZPD) {
    if(!_canvas) {
      _raphaelZPD=raphaelZPD;
      _canvas = Raphael(nomeId,w,h);
      _width=w;
      _canvas.rect(0, 0, w, h, 0).attr({fill: '#e3e3e3',stroke:''});
      /*calcolo la percentuale visibile nello schermo*/
      _sizeScroll=w*margin/(size[0]+delta);
      _sizeScroll=_sizeScroll*w/margin;
      if (_sizeScroll>w)
        _sizeScroll=w-(margin*margin/delta);
      if (!IsOpera()){
        _scrollbar=_canvas.rect(margin*margin/delta, 0, _sizeScroll, h, 0).attr({fill: '#8f8f8f',stroke:''});
      }
      else _scrollbar=_canvas.rect(margin*margin/delta, 0, _sizeScroll, h, 0).attr({fill: '#8f8f8f',stroke:''});
      associaDragHorizontal(_scrollbar)
    }
  }

  var associaDragHorizontal = function (scrollbar) {
    var start = function () {
      _matrix=_raphaelZPD.getCTM();
      scrollbar.ox=scrollbar.attr("x");
      scrollbar.oy=scrollbar.attr("y");
      _initialPositionX=_matrix.e;
    },
    move = function (dx/*, dy*/) {
      if ((scrollbar.ox+dx)>=0 && (scrollbar.ox+dx+_sizeScroll)<=_width){
        scrollbar.attr({x:scrollbar.ox+dx,y:scrollbar.oy});
        var spostamento=_width*(dx)/_sizeScroll;
        var matrix=_matrix;
        if (dx>0){
          if (scrollbar.ox<(margin*margin/delta)){
            if (_initialPositionX>0)
              matrix.e=_initialPositionX-spostamento;
            else
              matrix.e=_initialPositionX+spostamento; // non dovrebbe mai verificarsi
          }
          else {

            if (_initialPositionX>0)
              matrix.e=_initialPositionX+spostamento; // non dovrebbe mai verificarsi
            else
              matrix.e=_initialPositionX-spostamento;
          }
        }
        else {
          if (scrollbar.ox>=(margin*margin/delta)){
            if (_initialPositionX>0)
              matrix.e=_initialPositionX+spostamento; // non dovrebbe mai verificarsi
            else
              matrix.e=_initialPositionX-spostamento;
          }
          else {
            if (_initialPositionX>0)
              matrix.e=_initialPositionX-spostamento;
            else
              matrix.e=_initialPositionX+spostamento; // non dovrebbe mai verificarsi
          }
        }
        _raphaelZPD.setCTM(matrix)
      }
    },
    end = function() { };

    scrollbar.drag(move, start, end);
  }

  this.createScrollbarVertical = function(nomeId,w,h,size,raphaelZPD) {
    if(!_canvas) {
      _raphaelZPD=raphaelZPD;
      _canvas = Raphael(nomeId,w,h);
      _width=w;
      _height=h-40;
      _canvas.rect(0, 0, _width, _height, 0).attr({fill: '#e3e3e3',stroke:''});
      /*calcolo la percentuale visibile nello schermo*/
      _sizeScroll=_height*margin/(size[1]+delta);
      _sizeScroll=_sizeScroll*_height/margin;
      if (_sizeScroll>_height)
        _sizeScroll=_height-(margin*margin/delta);
      if (!IsOpera()){
        _scrollbar=_canvas.rect(0, margin*margin/delta, w, _sizeScroll, 0).attr({fill: '#8f8f8f',stroke:''});
      }
      else _scrollbar=_canvas.rect(0, margin*margin/delta, w, _sizeScroll, 0).attr({fill: '#8f8f8f',stroke:''});
      associaDragVertical(_scrollbar)
    }
  }

  var associaDragVertical = function (scrollbar) {
    var start = function () {

      _matrix=_raphaelZPD.getCTM();
      scrollbar.ox=scrollbar.attr("x");
      scrollbar.oy=scrollbar.attr("y");
      _initialPositionY=_matrix.f;
    },
    move = function (dx, dy) {
      if ((scrollbar.oy+dy)>=0 && (scrollbar.oy+dy+_sizeScroll)<=_height){
        scrollbar.attr({y:scrollbar.oy+dy});
        var spostamento=_height*(dy)/_sizeScroll;
        var matrix=_matrix;
        if (dy>0){
          if (scrollbar.oy<(margin*margin/delta)){
            if (_initialPositionY>0)
              matrix.f=_initialPositionY-spostamento;
            else
              matrix.f=_initialPositionY+spostamento; // non dovrebbe mai verificarsi
          }
          else {

            if (_initialPositionY>0)
              matrix.f=_initialPositionY+spostamento; // non dovrebbe mai verificarsi
            else
              matrix.f=_initialPositionY-spostamento;
          }
        }
        else {
          if (scrollbar.oy>=(margin*margin/delta)){
            if (_initialPositionY>0)
              matrix.f=_initialPositionY+spostamento; // non dovrebbe mai verificarsi
            else
              matrix.f=_initialPositionY-spostamento;
          }
          else {
            if (_initialPositionY>0)
              matrix.f=_initialPositionY-spostamento;
            else
              matrix.f=_initialPositionY+spostamento; // non dovrebbe mai verificarsi
          }
        }
        _raphaelZPD.setCTM(matrix)

      }
    },
    end = function() { };

    scrollbar.drag(move, start, end);
  }


  this.deleteScrollbar=function(){
    _canvas.clear();
    if (_canvas.canvas.parentNode)
      _canvas.canvas.parentNode.innerHTML="";
  }

  this.mouseDown=function(){
    _initialPositionX=_scrollbar.attr("x");
    _initialPositionY=_scrollbar.attr("y");
  }

  this.mouseMoveX=function(dx){
    var spostamento=_sizeScroll*dx/_width
    if (_initialPositionX-spostamento>=0 && _initialPositionX-spostamento+_sizeScroll<=_width){
      _scrollbar.attr({x:_initialPositionX-spostamento});
      return;
    }
    if (_initialPositionX-spostamento<=0){
      _scrollbar.attr({x:0});
      return;
    }
    if (_initialPositionX-spostamento+_sizeScroll>=_width){
      _scrollbar.attr({x:_width-_sizeScroll});
      return;
    }
  }

   this.mouseMoveY=function(dy){
    var spostamento=_sizeScroll*dy/_height
    if (_initialPositionY-spostamento>=0 && _initialPositionY-spostamento+_sizeScroll<=_height){
      _scrollbar.attr({y:_initialPositionY-spostamento});
      return;
    }
    if (_initialPositionY-spostamento<=0){
      _scrollbar.attr({y:0});
      return;
    }
    if (_initialPositionY-spostamento+_sizeScroll>=_height){
      _scrollbar.attr({y:_height-_sizeScroll});
      return;
    }
  }
}
