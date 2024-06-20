/* Questa versione di NanoScroll usa Mootools al posto di jQuery. */
(function(MooTools, window, document) {
  var DOMSCROLL, DOWN, DRAG, MOUSEDOWN, MOUSEMOVE, MOUSEUP, MOUSEWHEEL, NanoScrollMT, PANEDOWN, RESIZE, SCROLL, SCROLLBAR, UP, WHEEL, MOUSEOVER, MOUSEOUT, getScrollbarWidth;
  SCROLLBAR = 'scrollbar';
  SCROLL = 'scroll';
  MOUSEDOWN = 'mousedown';
  MOUSEMOVE = 'mousemove';
  MOUSEWHEEL = 'mousewheel';
  MOUSEUP = 'mouseup';
  RESIZE = 'resize';
  DRAG = 'drag';
  UP = 'up';
  PANEDOWN = 'panedown';
  DOMSCROLL = 'DOMMouseScroll';
  DOWN = 'down';
  WHEEL = 'wheel';
  MOUSEOVER = 'mouseover';
  MOUSEOUT = 'mouseout';
  getScrollbarWidth = function() {
    var noscrollWidth, outer, yesscrollWidth;
    outer = document.createElement('div');
    outer.style.position = 'absolute';
    outer.style.width = '100px';
    outer.style.height = '100px';
    outer.style.overflow = 'scroll';
    document.body.appendChild(outer);
    noscrollWidth = outer.offsetWidth;
    yesscrollWidth = outer.scrollWidth;
    document.body.removeChild(outer);
    return noscrollWidth - yesscrollWidth;
  };
  NanoScrollMT = (function() {
    function NanoScrollMT(content) {
      content.addClass('content');
      // aggiungo un div esterno
      this.el=new Element('div',{'class':'small nano'});
      this.el.replaces(content);
      this.el.adopt(content);
      this.generate();
      this.createEvents();
      this.addEvents();
      this.reset();
    }

    NanoScrollMT.prototype.createEvents = function() {
      var _this = this;
      this.events = {
        down: function(e) {
          _this.isDrag = true;
          _this.offsetY = e.client.y - _this.slider.getPosition().y;
          _this.pane.addClass('active');
          document.id(document).addEvent(MOUSEMOVE, _this.events[DRAG]);
          document.id(document).addEvent(MOUSEUP, _this.events[UP]);
          return false;
        },
        drag: function(e) {
          _this.sliderY = e.client.y - _this.el.getPosition().y - _this.offsetY;
          _this.scroll();
          return false;
        },
        up: function(e) {
          _this.isDrag = false;
          _this.pane.removeClass('active');
          document.id(document).removeEvent(MOUSEMOVE, _this.events[DRAG]);
          document.id(document).removeEvent(MOUSEUP, _this.events[UP]);
          return false;
        },
        resize: function(e) {
          _this.reset();
        },
        panedown: function(e) {
          _this.sliderY = e.client.y - _this.el.getPosition().y - _this.sliderH * 0.5;
          _this.scroll();
          _this.events.down(e);
        },
        scroll: function(e) {
          var content, top;
          if (_this.isDrag === true) return;
          content = _this.content[0];
          top = content.scrollTop / (content.scrollHeight - content.clientHeight) * (_this.paneH - _this.sliderH);
          _this.slider.style.top=top + 'px';
        },
        wheel: function(e) {
          _this.sliderY = (_this.sliderY || 0) - (e.wheel);
          _this.scroll();
          return false;
        },
        mouseover: function(e){
          _this.pane.set('morph', {duration: '100', transition: Fx.Transitions.linear});
          _this.pane.morph({opacity:1})
          _this.slider.morph({opacity:1})
        },
        mouseout: function(e){
          _this.pane.set('morph', {duration: '300', transition: Fx.Transitions.linear});
           _this.pane.morph({opacity:0})
           _this.slider.morph({opacity:0})
        }
      };
    };

    NanoScrollMT.prototype.addEvents = function() {
      var events, pane, content;
      events = this.events;
      pane = this.pane;
      content= this.content[0];
      document.id(window).addEvent(RESIZE, events[RESIZE]);
      this.slider.addEvent(MOUSEDOWN, events[DOWN]);
      pane.addEvent(MOUSEDOWN, events[PANEDOWN]);
      content.addEvent(SCROLL, events[SCROLL]);
      pane.addEvent(MOUSEWHEEL, events[WHEEL]);
      pane.addEvent(DOMSCROLL, events[WHEEL]);
      this.el.addEvent(MOUSEOVER, events[MOUSEOVER]);
      this.el.addEvent(MOUSEOUT, events[MOUSEOUT]);
    };

    NanoScrollMT.prototype.removeEvents = function() {
      var events, pane,content;
      events = this.events;
      pane = this.pane;
      content=this.content[0];
       document.id(window).removeEvent(RESIZE, events[RESIZE]);
      this.slider.removeEvent(MOUSEDOWN, events[DOWN]);
      pane.removeEvent(MOUSEDOWN, events[PANEDOWN]);
      content.removeEvent(SCROLL, events[SCROLL]);
      pane.removeEvent(MOUSEWHEEL, events[WHEEL], false);
      pane.removeEvent(DOMSCROLL, events[WHEEL], false);
    };

    NanoScrollMT.prototype.generate = function() {
      this.pane=new Element('div',{'class':'pane'}).inject(this.el)
      this.slider=new Element('div',{'class':'slider'}).inject(this.pane);
      this.content = this.el.getChildren('.content');
    };

    NanoScrollMT.prototype.reset = function() {
      var content;
      if (this.el.getChildren('.pane').length === 0) {
        this.generate();
        this.stop();
      }
      if (this.isDead === true) {
        this.isDead = false;
        this.pane.show();
        this.slider.show();
        this.addEvents();
      }
      content = this.content[0];
      this.contentH = content.scrollHeight;
      if (this.contentH>0) {
        this.pane.show();
        this.slider.show();
        this.paneH = this.pane.getSize().y;
        this.sliderH = (this.paneH / this.contentH * this.paneH)+2;
        this.sliderH = Math.round(this.sliderH);
        this.scrollH = this.paneH - this.sliderH;
        this.slider.style.height=this.sliderH+'px';
        this.diffH = content.scrollHeight - content.clientHeight;
        if (this.paneH >= this.content[0].scrollHeight){
          this.pane.hide();
          this.slider.hide();
        }
      }
      else{
        this.pane.hide();
        this.slider.hide();
      }

      return this;
    };

    NanoScrollMT.prototype.scroll = function() {
      var scrollValue;
      this.sliderY = Math.max(0, this.sliderY);
      this.sliderY = Math.min(this.scrollH, this.sliderY);
      scrollValue = this.paneH - this.contentH;
      scrollValue = scrollValue * this.sliderY / this.scrollH;
      this.content[0].scrollTop = -scrollValue;
      this.slider.style.top = this.sliderY+'px';
      return this.slider;
    };

    NanoScrollMT.prototype.scrollDelta=function(scrollValue){
      var content=this.content[0];
      this.reset();
      this.sliderY=-(scrollValue*this.scrollH)/(this.paneH-this.contentH);
      content.scrollTop+=scrollValue;
      this.slider.style.top=(content.scrollTop / (content.scrollHeight - content.clientHeight) * (this.paneH - this.sliderH))+'px';
    };

    NanoScrollMT.prototype.scrollBottom = function(offsetY) {
      var diffH, scrollTop;
      diffH = this.diffH;
      scrollTop = this.content[0].scrollTop;
      this.reset();
      if (scrollTop < diffH && scrollTop !== 0) return;
      this.content.scrollTop=this.contentH - this.content.getStyle('height') - offsetY;
    };

    NanoScrollMT.prototype.scrollTop = function(offsetY) {
      this.reset();
      this.content.scrollTop=offsetY + 0;
    };

    NanoScrollMT.prototype.stop = function() {
      this.isDead = true;
      this.removeEvents();
      this.pane.hide();
      this.slider.hide();
    };

    return NanoScrollMT;
  })();

  Elements.prototype.nanoScrollerMT = function(options) {
    options || (options = {});
    if (!(Browser.ie && Browser.version<8)) {
      this.each(function(element) {
        document.id(element).nanoScrollerMT(options);
      });
    }
  };
  (Element.Prototype||Element.prototype).nanoScrollerMT = function(options) {
    options || (options = {});
    if (!(Browser.ie && Browser.version<8)) {
        scrollbar = this.retrieve(SCROLLBAR);
        if (!scrollbar) {
          scrollbar = new NanoScrollMT(this);
          this.store(SCROLLBAR, scrollbar);
        }
        if (options.scrollBottom) {
          return scrollbar.scrollBottom(options.scrollBottom);
        }
        if (options.scrollDelta) return scrollbar.scrollDelta(options.scrollDelta);
        if (options.scrollTop) return scrollbar.scrollTop(options.scrollTop);
        if (options.scroll === 'bottom') return scrollbar.scrollBottom(0);
        if (options.scroll === 'top') return scrollbar.scrollTop(0);
        if (options.stop) return scrollbar.stop();
        return scrollbar.reset();
    }
  };
})(MooTools,window, document);
