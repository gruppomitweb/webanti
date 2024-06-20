
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
  arrow_size: 5
}

function PSTooltip(container, options, bOnMouseEvent) { //bOnMouseEvent -- boolean // true abilita eventi mouseenter e mouseout
  return new PSTooltip._innerClass(container, options, bOnMouseEvent);
}
PSTooltip._innerClass = function(container, options, onmouse/*, bOnMouseEvent*/) {
  this.positions  = {
    arrow: 0,
    left: 0,
    top: 0
  }
  this.scroll  = {
    left: 0,
    top: 0
  }

  this.container   = container;
  this.options     = PSTooltip._innerClass.getOptions(options);
  /* associa ascoltatori */
  if( onmouse == undefined ) {
    onmouse = true;
  }
  if( onmouse == true ) {
    container.addEventListener("mouseenter", this, false);
    container.addEventListener("mouseout", this, false);
  }
  container.addEventListener("psFocusHelp", this, false);
  container.addEventListener("psLostFocusHelp", this, false);

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
      this.positions.top = this.container.getBoundingClientRect().top - PSTooltip.ELEMENT.clientHeight + this.container.clientHeight + this.options.vertical_margin; // sposto il tooltip verso l'alto
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
  this.positions.top += this.scroll.top;
  this.positions.left += this.scroll.left;
  PSTooltip.ELEMENT.style.top  = Math.round(this.positions.top-this.scroll.top) + "px";
  PSTooltip.ELEMENT.style.left = Math.round(this.positions.left-this.scroll.left) + "px";
  PSTooltip.ARROW.style.top    = Math.round(this.positions.arrow) + "px";
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
  PSTooltip.ELEMENT.style.zIndex = 999999;
  
}

PSTooltip._innerClass.hide = function() {
  PSTooltip.ELEMENT.style.opacity = 0;
  PSTooltip.ELEMENT.style.visibility = 'hidden';
 PSTooltip.ELEMENT.style.zIndex = -1;
}

PSTooltip._innerClass.prototype.handleEvent = function(e) {
  if(e.type == 'mouseenter' || e.type == 'psFocusHelp') {
    this.show();
  } else if(e.type == 'mouseout' || e.type == 'psLostFocusHelp') {
    PSTooltip._innerClass.hide();
  }
}

/**
 * [create funzione che crea il tooltip e la freccia che indica da dove è partito]
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

/*************************************************************************/
PSTooltip._innerClass.prototype.setScroll = function(top, left) {
  this.scroll.top = top;
  this.scroll.left = left;
} 

PSTooltip._innerClass.prototype.scrollPlacement = function(top, left) {
  this.scroll.top = top;
  this.scroll.left = left;
  PSTooltip.ELEMENT.style.top  = Math.round(this.positions.top-this.scroll.top) + "px";
  PSTooltip.ELEMENT.style.left = Math.round(this.positions.left-this.scroll.left) + "px";
} 