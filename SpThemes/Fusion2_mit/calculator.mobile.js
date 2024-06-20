(function (win,doc,currentWin) {
  var the_calculator
    , hasTouch = 'ontouchstart' in window /* ios8 webapps won't pass touchevents through iframe. Fallback to click */ && !(
                   win.frameElement && win.navigator.standalone && win.navigator.userAgent.match( /iPad.* OS 8_/ )
                   /*
                      http://www.mobilexweb.com/blog/safari-ios8-iphone6-web-developers-designers
                      "Touch events inside iframes on home-screen apps are not being reported"
                   */
                 )
    , actionEvt = hasTouch ? 'touchstart' : 'click'
    , activator = 'on' + actionEvt
    , html = '' +
      '<div id="SPCalc" class="calc-cinema" style="position:fixed;" tabindex="1">'+
        '<div class="calc-main">'+
          '<div class="pin" style="display:none;"></div>'+
          '<div class="calc-header">'+
            '<div class="calc-description"></div>'+
            '<div class="calc-pinnable" '+activator+'="SPCalculator_Pin(event,this)"></div>'+
          '</div>'+
          '<div class="calc" tabindex="1">'+
            '<p class="calc-display">'+
              '<input class="calc-display-input" readonly>'+
            '</p>'+
            '<p class="calc-row">'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'1\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>1</div>'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'2\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>2</div>'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'3\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>3</div>'+
              '<div class="mobileIco calc-button calc-button-blue calc-button-big SPCalc_Del" '+activator+'="SPCalculator_Del(event,this)"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div></div>'+
            '</p>'+
            '<p class="calc-row">'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'4\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>4</div>'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'5\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>5</div>'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'6\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>6</div>'+
              '<div class="mobileIco calc-button calc-button-blue calc-button-big SPCalc_Increase" '+activator+'="SPCalculator_Increase(event,this)"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div></div>'+
            '</p>'+
            '<p class="calc-row">'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'7\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>7</div>'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'8\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>8</div>'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'9\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>9</div>'+
              '<div class="mobileIco calc-button calc-button-blue calc-button-big SPCalc_Decrease" '+activator+'="SPCalculator_Decrease(event,this)"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div></div>'+
            '</p>'+
            '<p class="calc-row">'+
              '<div class="mobileIco calc-button calc-button-blue calc-button-big SPCalc_Flip" '+activator+'="SPCalculator_Flip(event,this)"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div></div>'+
              '<div class="mobileIco calc-button calc-append" '+activator+'="SPCalculator_Append(event,this,\'0\')"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div>0</div>'+
              '<div class="mobileIco calc-button calc-button-blue calc-button-big SPCalc_DecSep" '+activator+'="SPCalculator_DecSep(event,this)"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div></div>'+
              '<div class="mobileIco calc-button calc-button-blue calc-button-big SPCalc_Confirm" '+activator+'="SPCalculator_Confirm(event,this)"><div class="touchEffect_off" '+
                  'ontouchstart=" this.className = \'touchEffect_on\'; "'+
                  'ontouchend=" this.className = \'touchEffect_off touchEffect_delay\' " '+
                '></div></div>'+
            '</p>'+
          '</div>'+
        '</div>'+
      '</div>'
    ;

  /* Calculator constructor */
  function Calculator () {
    var _this = this
      , dummyContainer = doc.createElement( 'div' )
      ;
    dummyContainer.innerHTML = html;
    this.calcCinema = dummyContainer.getElementsByClassName( 'calc-cinema' )[0];
    this.calcCinema.style.display = 'none';
    var maxZindex = 999;
    [].forEach.call( doc.querySelectorAll('.spModalLayer'), function( it ){
      maxZindex = Math.max( parseInt(it.getComputedStyle('z-index')) || 0, maxZindex );
    });
    this.calcCinema.style.zIndex = ++maxZindex;
    this.calcMain = dummyContainer.getElementsByClassName( 'calc-main' )[0];
    this.input = null;
    this.display = dummyContainer.getElementsByClassName( 'calc-display-input' )[0];

    this.description = dummyContainer.getElementsByClassName( 'calc-description' )[0];
    this.pin = dummyContainer.getElementsByClassName( 'calc-pinnable' )[0];

    // this.display.addEventListener( ( hasTouch ) ? 'touchstart' : 'mousedown', StartDragNDrop, false);
    // this.display.addEventListener( ( hasTouch ) ? 'touchmove' : 'mousemove', Drag, false);
    // this.display.addEventListener( 'mouseup', Drop, false);


    var StartDragNDrop= function(e){
      e.preventDefault();
        this.drag = true;
      this.lastX = ( hasTouch ) ? parseInt((e.changedTouches[0]).clientX) : parseInt(e.clientX);
      this.lastY = ( hasTouch ) ? parseInt((e.changedTouches[0]).clientY) : parseInt(e.clientY);
      // this.calcMain = document.getElementsByClassName('calc-main')[0]; //lo ridefinisco perché sono collegato come evento ad un oggetto diverso dal calculator
    }.bind(this);

    var Drag = function(e){
      e.preventDefault();
        if( this.drag == true ){
          var cX = ( hasTouch ) ? parseInt((e.changedTouches[0]).clientX) : parseInt(e.clientX);
          var cY = ( hasTouch ) ? parseInt((e.changedTouches[0]).clientY) : parseInt(e.clientY);
        this.calcMain.style.left = parseInt( this.calcMain.style.left ) + cX - this.lastX + 'px';
        this.calcMain.style.top = parseInt( this.calcMain.style.top ) + cY - this.lastY + 'px';
          this.lastX = cX;
          this.lastY = cY;
      }
    }.bind(this);

    var Drop = function (e){
        e.preventDefault();
        this.drag = false;
    }.bind(this);

    this.description.addEventListener( ( hasTouch ) ? 'touchstart' : 'mousedown', StartDragNDrop, false);
    this.description.addEventListener( ( hasTouch ) ? 'touchmove' : 'mousemove', Drag, false);
    this.description.addEventListener( 'mouseup', Drop, false);

    doc.body.appendChild( dummyContainer.removeChild( dummyContainer.firstChild ) );

    this.eventsHandler = (
      { calculator : _this
      , handleEvent : function (evt) {
          switch ( evt.type ) {
            case 'keydown' :
              if ( evt.key.match( /^[0-9]$/ ) ) {
                // manage numbers
                this.calculator.Append( parseInt( evt.key, 10 ) );
              } else {
                switch (evt.key) {
                  case 'Backspace': // preventing backspace
                    evt.preventDefault();
                    evt.stopPropagation();
                    // routing to delete action
                    this.calculator.Del();
                    break;
                  case 'Escape': // Esc to Discard
                    this.calculator.Discard();
                    break;
                  case 'Enter': // Return to Confirm
                    this.calculator.Confirm();
                    break;
                  case 'ArrowUp': // Up to Increase
                    this.calculator.Increase();
                    break;
                  case 'ArrowDown': // Down to Decrease
                    this.calculator.Decrease();
                    break;
                  case '+': // + to Flip (if negative)
                    if ( this.calculator.ValueNum() < 0 ) {
                      this.calculator.Flip();
                    }
                    break;
                  case '-': // - to Flip (if negative)
                    if ( this.calculator.ValueNum() > 0 ) {
                      this.calculator.Flip();
                    }
                    break;
                  case '.': // decimalSeparator
                  case this.calculator.decimalSeparator:
                    this.calculator.Append( this.calculator.decimalSeparator );
                    break;
                  default:
                }
              }
              break;
            case actionEvt :
              if ( evt.currentTarget == this.calculator.calcMain ) {
                evt.stopPropagation();
              } else {
                this.calculator.UnbindFromInput();
              }
              break;
          }
          evt.preventDefault();
        }
      , Handle : function () {
          this.calculator.calcCinema.addEventListener( actionEvt, this, false );
          this.calculator.calcMain.addEventListener( actionEvt, this, false );
          doc.body.addEventListener( 'keydown', this, false );
        }
      , Unhandle : function () {
          this.calculator.calcCinema.removeEventListener( actionEvt, this, false );
          this.calculator.calcMain.removeEventListener( actionEvt, this, false );
          doc.body.removeEventListener( 'keydown', this, false );
        }
      }
    );
  }


  /* Calculator properties */
  Calculator.prototype = new Object;
  Calculator.prototype.constructor = Calculator;
  Calculator.prototype.decimalSeparator = '.';
  Calculator.prototype.triadSeparator = '';


  /* Calculator functions */
  Calculator.prototype.IsVisible = function () {
    return this.calcCinema.style.display != 'none';
  };
  Calculator.prototype.Show = function () {
    if ( !this.IsVisible() ) {
      this.calcCinema.style.display = '';
      this.calcCinema.focus();
      SetTopWindowFunctions();
      this.eventsHandler.Handle();

      if( !this.IsPinned() ){
        var posTop=0, posLeft=0;
        // posizionamento rispetto alla window corrente
        var w = this.localWin;
        while( w !== win ) {
          var iframe = w.frameElement;
          posTop += iframe.getBoundingClientRect().top;
          posLeft += iframe.getBoundingClientRect().left;
          w = w.parent;
        }
        var inputGeo = this.input.getBoundingClientRect();
        var calcGeo = this.calcMain.getBoundingClientRect();
        if( win.document.documentElement.clientHeight - (posTop + inputGeo.bottom + calcGeo.height) >= 0 ){ //posiziona bottom
          posTop = posTop + inputGeo.top + inputGeo.height + 'px';
        } else if( ( posTop + inputGeo.top - calcGeo.height ) >= 0 ){ // sta' sopra
          posTop = Math.max( posTop + (inputGeo.top - calcGeo.height ), 0) + 'px';
        } else { //posiziona centrato
          posTop = posTop + (inputGeo.top - ( calcGeo.height / 2) ) + 'px';
        }
      }
      posLeft = Math.max( posLeft + ( inputGeo.left - ( ( calcGeo.width - inputGeo.width ) / 2 ) ), 0);
      posLeft = Math.max(0, Math.min(posLeft, win.document.documentElement.clientWidth - calcGeo.width));

      this.calcMain.style.top = posTop;
      this.calcMain.style.left = posLeft + 'px';
    }
  };

  Calculator.prototype.Hide = function () {
    if ( this.IsVisible() ) {
      this.eventsHandler.Unhandle();
      this.calcCinema.style.display = 'none';
      ResetTopWindowFunctions();
    }
  };
  Calculator.prototype.GetPicture = function () {
    return this.input.getAttribute('data-sp-item-get-picture') || '';
  };
  Calculator.prototype.SayPicture = function () {
    return this.input.getAttribute('data-sp-item-say-picture') || '';
  };
  Calculator.prototype.Len = function () {
    return parseInt( this.input.getAttribute('data-sp-item-len') || '20', 10 ) ;
  };
  Calculator.prototype.CurrLen = function () {
    return this.ValueStr().replace('-','').length;
  };
  Calculator.prototype.Dec = function () {
    return parseInt( this.input.getAttribute('data-sp-item-dec') || '5', 10 );
  };
  Calculator.prototype.CurrDec = function () {
    var value = this.ValueStr()
      , decimalSeparatorIdx = value.indexOf( this.decimalSeparator )
      ;
    if ( decimalSeparatorIdx != -1 ) {
      return value.length - ( decimalSeparatorIdx + 1 );
    } else {
      return 0;
    }
  };
  Calculator.prototype.Int = function () {
    return this.Dec()==0 ? this.Len() : this.Len() - this.Dec() - 1;
  };
  Calculator.prototype.CurrInt = function () {
    return this.CurrLen() - this.CurrDec() - ( this.HasDecSep() ? 1 : 0 );
  };
  Calculator.prototype.BindToInput = function ( numberInput ) {
    if( this.input ){
      this.input.style.backgroundColor = 'transparent';
    }
    this.input = numberInput.tagName ? numberInput : doc.getElementById( numberInput );
    if ( this.input ) {
      this.SetValueStr( this.HtWNumeric( this.input.value ).toString().replace('.', this.decimalSeparator) );
      this.SetDefaultDescription();
      this.input.style.backgroundColor = 'rgb(232, 232, 232)';
      this.Show();
    } else {
      throw new Error( 'Unable to bind calculator to input ' + numberInput + ': ' + (this.input) + ' is not a valid HTMLInupt element.');
    }
  };
  Calculator.prototype.UnbindFromInput = function () {
    // Se esiste una funzione definita come OnCalculatorConfirm nella pagina allora la esegue
    if(this.localWin.OnCalculatorUnbind){
      this.localWin.OnCalculatorUnbind(this.input, this.ValueStr());
    }
    this.input.style.backgroundColor = 'transparent';
    this.Hide();
    if (this.localWin.last_focused_comp === this.input) {
      this.localWin.last_focused_comp = null;
    }
    this.input = null;
  };
  Calculator.prototype.FocusedInput = function (/*e*/) {
    this.UnbindFromInput();
  };
  Calculator.prototype.ValueStr = function () {
    return window.Trim( this.display.value ) || '0';
  };
  Calculator.prototype.SetUI = function () {
    var decSepBtn = this.calcMain.getElementsByClassName( 'SPCalc_DecSep' )[0];
    decSepBtn.style.visibility = this.Dec()==0 || this.HasDecSep() ? 'hidden' : '' ;
  };
  Calculator.prototype.SetValueStr = function ( new_value ) {
    this.display.value = new_value;
    this.SetUI();
  };
  Calculator.prototype.ValueNum = function () {
    return this.HtWNumeric( this.display.value );
  };
  Calculator.prototype.SetValueNum = function ( new_value ) {
    this.SetValueStr( (new_value||0).toFixed( this.Dec() ).replace( '.', this.decimalSeparator ) );
  };
  Calculator.prototype.Flip = function () {
    var new_value
      , curr_value = this.ValueStr()
      ;
    if ( curr_value[0]==='-' ) {
      new_value = curr_value.substring(1);
    } else {
      new_value = '-' + curr_value;
    }
    this.SetValueStr( new_value );
  };

  Calculator.prototype.Sum = function () {
    // to do
  };
  Calculator.prototype.Subtract = function () {
    // to do
  };
  Calculator.prototype.Mul = function () {
    // to do
  };
  Calculator.prototype.Div = function () {
    // to do
  };

  Calculator.prototype.Append = function ( value ) {
    var new_value
      , curr_value = this.ValueStr()
      ;

    if ( this.CurrLen() < this.Len() ) {
      if ( this.HasDecSep() ) {
        if ( value != this.decimalSeparator && this.CurrDec() < this.Dec() ) {
          new_value = curr_value + value;
        }
      } else {
        if ( this.ValueNum() == 0 && value != this.decimalSeparator ) {
          if ( curr_value[0]=='-' ) {
            new_value = '-' + value ;
          } else {
            new_value = value ;
          }
        } else {
          new_value = curr_value + value;
          if ( new SPNumber(new_value).Int() > this.Int() ) {
            return;
          }
        }
      }
      if ( new_value ) {
        this.SetValueStr( new_value );
      }
    }
  };
  Calculator.prototype.Increase = function () {
    var new_value = new SPNumber( this.ValueNum() + 1 );
    if ( !new_value.IsInteger() ) {
      if ( new_value.ToFixed( this.Dec() ).replace('-','').length <= this.Len() ) {
        this.SetValueNum( new_value.Val() );
      }
    } else if ( new_value.Int() <= this.Int() ) {
      this.SetValueNum( new_value.Val() );
    }
  };
  Calculator.prototype.Decrease = function () {
    var new_value = new SPNumber( this.ValueNum() - 1 );
    if ( !new_value.IsInteger() ) {
      if ( new_value.ToFixed( this.Dec() ).replace('-','').length <= this.Len() ) {
        this.SetValueNum( new_value.Val() );
      }
    } else if ( new_value.Int() <= this.Int() ) {
      this.SetValueNum( new_value.Val() );
    }
  };
  Calculator.prototype.HasDecSep = function () {
    return this.ValueStr().indexOf( this.decimalSeparator ) != -1;
  };
  Calculator.prototype.DecSep = function () {
    if ( !this.HasDecSep() && this.Dec() > 0 ) {
      this.Append( this.decimalSeparator );
    }
  };
  Calculator.prototype.HtWNumeric = function(workvar) {
    return this.localWin.Val(this.localWin.Strtran(this.localWin.Strtran(workvar, this.localWin.milSep, ''), this.localWin.decSep, '.'));
  };
  Calculator.prototype.Confirm = function () {
    var result
      , self = this
      , value = this.ValueStr()
      , input = this.input
      , setFnc = this.localWin['Set_'+input.name]
      ;
    if ( setFnc ) {
      if ( 'SPOfflineLib' in window ) { /* offline => async*/
        var localWin = this.localWin;
        function callbackSet( res ) {
          return atSetEnd( res, localWin );
        }
        setFnc( this.HtWNumeric( value ), null, {} /*fix for GetEventSrcElement(null) => window.event.target*/, callbackSet /* callback */ );
      } else {
        result = setFnc( this.HtWNumeric( value ), null, {} /*fix for GetEventSrcElement(null) => window.event.target*/ );
        return atSetEnd( result, this.localWin );
      }
    } else {
      input.value=value;
      //input.focus();
      var _blur = input.onblur.bind(input);
      input.onblur=null;
      //_blur();
      _blur.call(input);
      input.onblur=_blur;
      result=true;
      return atSetEnd( result, this.localWin );
    }

    function atSetEnd( res, wnd ) {
      // Se esiste una funzione definita come OnCalculatorConfirm nella pagina allora la esegue
      if(wnd.OnCalculatorConfirm){
        wnd.OnCalculatorConfirm(input, value);
      }
      // Rimane il bind se e' Pinnato
      if(self.IsPinned() == false){
        if ( res ) {
          self.UnbindFromInput();
        } else if ( input != self.input ) {
          setTimeout( function () {
            self.BindToInput( input );
            self.SetValueStr( value );
          }, 200);
        }
      }
    }
  };
  Calculator.prototype.Discard = function () {
    return this.UnbindFromInput();
  };
  Calculator.prototype.Del = function () {
    var curr_value_str
      , curr_value_num = this.ValueNum()
      ;
    if ( curr_value_num ) {
      curr_value_str = this.ValueStr();
      if ( curr_value_str.length == 1 ) {
        this.SetValueStr( '0' );
      } else {
        this.SetValueStr( curr_value_str.substr( 0, curr_value_str.length-1 ) );
      }
    } else {
      this.SetValueStr( '0' );
    }
  };

  Calculator.prototype.SetDescription = function ( value ) {
     this.description.innerHTML = value;
  };

  Calculator.prototype.SetDefaultDescription = function () {
     // Di default prende la descrizione della label Associata
    var labels = document.getElementsByTagName('label');
    for(var x in labels){
      if( labels[x].tagName && ( labels[x].getAttribute('for') == this.input.id ) ){
        this.SetDescription( labels[x].innerHTML );
      }
    }
    if(window.Empty(this.GetDescription())){
      this.SetDescription('');
    }
  };

  Calculator.prototype.GetDescription = function () {
    return this.description.innerHTML;
  };

  Calculator.prototype.IsPinned = function () {
    return this.calcMain.className.indexOf('pinned') != -1;
  };

  Calculator.prototype.Pin = function () {
    if(this.IsPinned()){
      window.LibJavascript.CssClassNameUtils.removeClass(this.calcMain,'pinned');
      this.calcCinema.style.width='100%';
      this.calcCinema.style.height= '100%';
    } else {
      window.LibJavascript.CssClassNameUtils.addClass(this.calcMain,'pinned');
      this.calcCinema.style.width= this.calcMain.offsetWidth +'px';
      this.calcCinema.style.height= this.calcMain.offsetHeight +'px';
    }
  };

  /* Utility functions */
  function SPNumber ( valOrStr ) {
    var isNum = !!valOrStr.toFixed
      , isStr = !!valOrStr.substr
      , _num = isNum ? valOrStr : isStr ? parseFloat( valOrStr, 10 ) : NaN
      , _str = isStr ? valOrStr : isNum ? valOrStr.toString() : ''+NaN
    ;
    return (
      { Val : function () {
          return _num;
        }
      , Str : function () {
          return _str;
        }
      , Len : function () {
          return this.Str().replace('-','').length;
        }
      , Int : function () {
          return parseInt( this.Str().replace('-',''), 10 ).toString().length;
        }
      , Dec : function () {
          var str = this.Str()
             , decimalSeparatorIdx = str.indexOf( '.' )
             ;
          if ( decimalSeparatorIdx != -1 ) {
            return str.length - ( decimalSeparatorIdx + 1 );
          } else {
             return 0;
          }
        }
      , IsInteger : function () {
          var value = this.Val();
          if ( Number.isInteger ) {
            return Number.isInteger( value );
          } else {
            return isFinite( value ) && Math.floor( value ) === value;
          }
        }
      , ToFixed : function (digits) {
          return this.Val().toFixed( digits || 0 );
        }
      }
    );
  }


  /* Brige functions */
  function ShowPopUpCalculator ( numberInput, keyCode, triadSeparator, decimalSeparator, localWin ) {
    if ( !the_calculator ) {
      the_calculator = new Calculator();
    }
    var calculator = the_calculator;
    calculator.localWin = localWin;
    if ( !numberInput.tagName ) {
      numberInput = localWin.document.getElementById( numberInput );
    }
    if ( numberInput == calculator.input ) {
      if(!calculator.IsPinned()){
        return calculator.Discard();
      }
    } else {
      if ( calculator.input ) {
        if(!calculator.IsPinned()){
          calculator.Discard();
        } else {
        // Se esiste una funzione definita come OnCalculatorConfirm definita nella pagina allora la esegue
          if(localWin.OnCalculatorConfirm && ( numberInput.name != calculator.input.name ) ){
            localWin.OnCalculatorConfirm(calculator.input, calculator.input.value);
          }
        }
      } else {
        if( localWin.SPMobileLib )
          localWin.SPMobileLib.hideKeyboard();
      }
      calculator.triadSeparator = triadSeparator || calculator.triadSeparator;
      calculator.decimalSeparator = decimalSeparator || calculator.decimalSeparator;
      calculator.BindToInput( numberInput );
    }
  }
  function SPCalculator_Append (event, btn, value) {
    the_calculator.Append( value );
  }
  function SPCalculator_Flip (/*event, btn*/) {
    the_calculator.Flip();
  }
  function SPCalculator_Increase (/*event, btn*/) {
    the_calculator.Increase();
  }
  function SPCalculator_Decrease (/*event, btn*/) {
    the_calculator.Decrease();
  }
  function SPCalculator_DecSep (/*event, btn*/) {
    the_calculator.DecSep();
  }
  function SPCalculator_Del (/*event, btn*/) {
    the_calculator.Del();
  }
  function SPCalculator_Confirm (event/*, btn*/) {
    event.preventDefault();
    the_calculator.Confirm();
  }
  function SPCalculator_Discard (/*event, btn*/) {
    the_calculator.Discard();
  }
  function SPCalculator_SetDescription (value) {
    the_calculator.SetDescription( value );
  }

  function SPCalculator_SetDefaultDescription () {
    the_calculator.SetDefaultDescription();
  }

  function SPCalculator_GetDescription () {
    return the_calculator.GetDescription();
  }
  function SPCalculator_Pin (/*event, btn*/) {
    return the_calculator.Pin();
  }
  /* Globals */
  function SetTopWindowFunctions() {
    win.SPCalculator_Append = SPCalculator_Append;
    win.SPCalculator_Flip = SPCalculator_Flip;
    win.SPCalculator_Increase = SPCalculator_Increase;
    win.SPCalculator_Decrease = SPCalculator_Decrease;
    win.SPCalculator_DecSep = SPCalculator_DecSep;
    win.SPCalculator_Del = SPCalculator_Del;
    win.SPCalculator_Confirm = SPCalculator_Confirm;
    win.SPCalculator_Discard = SPCalculator_Discard;

    win.SPCalculator_SetDescription = SPCalculator_SetDescription;
    win.SPCalculator_SetDefaultDescription = SPCalculator_SetDefaultDescription;
    win.SPCalculator_GetDescription = SPCalculator_GetDescription;
    win.SPCalculator_Pin = SPCalculator_Pin;
  }
  function ResetTopWindowFunctions() {
    win.SPCalculator_Append = win.SPCalculator_Flip = win.SPCalculator_Increase = win.SPCalculator_Decrease = null;
    win.SPCalculator_DecSep = win.SPCalculator_Del = win.SPCalculator_Confirm = win.SPCalculator_Discard = null ;

    win.SPCalculator_SetDescription = win.SPCalculator_SetDefaultDescription = win.SPCalculator_GetDescription = win.SPCalculator_Pin = null;
  }
  currentWin.SPCalculator_Show = ShowPopUpCalculator;
    currentWin.ShowPopUpCalculator = ShowPopUpCalculator;

} )( window, window.document, window );
