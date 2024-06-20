/**
 * [DEFAULTS opzioni di default della SPToolbar]
 * @type {Object}
 */
SPToolbar.DEFAULTS = {
  containerId: 'toolbar',
  dropElement: null,
  elementToShow: 1,
  inMultiToolbar: false,
  isOpened: true,
  title: ''
}

/**
 * [SPToolbar toolbar contenente azioni che permettono di interagire con l'editor]
 * @param       {[object]} items    [oggetti da inserire nella toolbar]
 * @param       {[string]} id       [id della toolbar da creare]
 * @param       {[object]} options  [opzioni dell'elemento, non obbligatorio]
 * @constructor
 */
function SPToolbar(items, id, options) {
  this.items = items.slice(0);
  this.id = id;
  // inizializzo le opzioni utilizzando i default se non sono presenti
  this.options = SPToolbar.getOptions(options || {}, SPToolbar.DEFAULTS);

  var container = document.getElementById(this.options.containerId);
  if(container != null) {
    container.classList.remove('droppable');
    container.classList.remove('horizontal');
    container.classList.add('PSToolbar');
  } else {
    throw new Error('Unable to find the toolbar container with id ' + this.options.containerId);
  }

  if(this.options.inMultiToolbar) {
    var sectionsContainer = document.querySelector('.PSMultiToolbar #' + this.options.containerId + ' .sections-container')

    var section = document.createElement('section');
    if(sectionsContainer == null) {
      sectionsContainer = document.createElement('div');
      sectionsContainer.classList.add('sections-container');
      container.appendChild(sectionsContainer);
    }
    sectionsContainer.appendChild(section);
    if(this.options.title != '') {
      // controllo isOpened e aggiungo relativa classe
      if(this.options.isOpened) {
        section.classList.add('opened');
      }
      // creo il titolo per la sezione
      var sectionTitle = document.createElement('h2');
      sectionTitle.innerHTML = this.options.title;
      sectionTitle.addEventListener('click', function() {
        // al click del titolo apro/choudo la sezione
        this.classList.toggle('opened');
      }.bind(section));
      section.appendChild(sectionTitle);
    } else {
      section.classList.add('noTitle');
      // la sezione � senza titolo, la apro di default
      section.classList.add('opened');
    }
    this.createToolbar(section);
  } else {
    this.createToolbar(container);
  }

}

/**
 * [getOptions]
 * @param  {[object]} options [Oggetto contenente le opzioni utente]
 * @return {[object]}         [Opzioni utente + opzioni default]
 */
SPToolbar.getOptions = function (options, defaults) {
  var res = {};
  for(var p in defaults)
    res[p] = (options[p] == null) ? defaults[p] : options[p];
  return res
}

/**
 * [createToolbar]
 * @param  {[type]} container [elemento nel quale inserire la toolbar]
 */
SPToolbar.prototype.createToolbar = function(container) {
  var singleToolbarContainter = document.createElement('ul');
  singleToolbarContainter.id = this.id;
  if(!this.options.inMultiToolbar) {
    singleToolbarContainter.classList.add('element-to-show-' + this.options.elementToShow);
  }
  this.items.forEach(function(item) {
    singleToolbarContainter.appendChild(this.createElement(item));
  }.bind(this));

  container.appendChild(singleToolbarContainter);

  if(this.options.dropElement != null) {
    // aggiungo eventi drop nel caso in cui ci sia una drop area da usare
    this.createDropElement();
  }
}

/**
 * [createElement crea l'elemento da aggiungere alla toolbar]
 * @param  {[object]}   item    [oggetto contenente le informazioni dell'elemento]
 * @return {[element]}          [elemento creato]
 */
SPToolbar.prototype.createElement = function(item) {
  var element = document.createElement('li');

  if(item.isSeparator) {
    element.classList.add('separator');
  } else {
    var innerSpan, innerImg;
    element.id = item.id;
    element.title = item.title;

    if(item.image) {
      innerImg = document.createElement('span');
      innerImg.style.backgroundImage = 'url(\'' + item.image + '\')';
      innerImg.classList.add('icon-image');
      if (!Empty(item.class_name)) innerImg.classList.add(item.class_name);
      element.appendChild(innerImg);
    }

    if(item.innerHTML) {
      innerSpan = document.createElement('span');
      innerSpan.innerHTML = item.innerHTML;
      if (!Empty(item.class_name)) innerSpan.classList.add(item.class_name);
      element.appendChild(innerSpan);
    }

    if(this.options.inMultiToolbar || item.withTitle) {
      innerSpan = document.createElement('span');
      innerSpan.innerHTML = item.title;
      if (!Empty(item.class_name)) innerSpan.classList.add(item.class_name);
      element.appendChild(innerSpan);
    }

    if(item.draggable){
      // abilito il drag su tutto l'elemento
      element.setAttribute('draggable', 'true');
      element.addEventListener('dragstart', function(item, event) {
        event.dataTransfer.effectAllowed = 'copyMove';
        event.dataTransfer.setData('Text', JSON.stringify(item.action));
      }.bind(this, item));
    }

    element.addEventListener('click', item.draggable ?
      function(item, event){
        window[item.action.func].apply(item, ([event]).concat(item.action.par.split(',')));
      }.bind(this, item)
      : item.action
    );
  }
  return element;
}

/**
 * [addElement crea un nuovo elemento e lo aggiunge alla toolbar where]
 * @param  {[object]}  item  [oggetto contenente le informazioni dell'elemento]
 * @param  {[int]}     item  [opzionale: posizione in cui inserire l'elemento]
 */
SPToolbar.prototype.addElement = function(item, index) {
  var element = this.createElement(item);
  if(index == null) {
    this.items.push(item);
    document.getElementById(this.id).appendChild(element);
  } else {
    this.items.splice(index, 0, item);
    var parentElement = document.getElementById(this.id);
    parentElement.insertBefore(element, parentElement.children[index]);
  }
}

/**
 * [removeElement rimuove l'elemento con id uguale a id]
 * @param  {[string]}   id  [id dell'elemento da rimuovere]
 * @return {[boolean]}      [booleano che indica se l'elemento � stato rimosso]
 */
SPToolbar.prototype.removeElement = function(id) {
  var removed = false;
  for (var i = 0; !removed && i < this.items.length; i++) {
    if(this.items[i].id == id) {
      this.items.splice(i, 1);
      removed = true;
      var elem = document.getElementById(id);
      elem.parentNode.removeChild(elem);
    }
  }
  return removed;
}

/**
 * [addElement crea un nuovo elemento e lo aggiunge alla toolbar where]
 * @param  {[object]}  item  [oggetto contenente le informazioni dell'elemento]
 * @param  {[int]}     item  [opzionale: posizione in cui sostituire l'elemento]
 */
SPToolbar.prototype.replaceElement = function(item, index) {
  var element = this.createElement(item);
  this.items.splice(index, 1, item);
  var parentElement = document.getElementById(this.id);
  parentElement.removeChild(parentElement.children[index])
  parentElement.insertBefore(element, parentElement.children[index]);
}

/**
 * [addElement crea un nuovo elemento e lo aggiunge alla toolbar where]
 * @param  {[string]}   id  [id dell'elemento da cercare]
 * @return {[object]}  [oggetto richiesto oppure undefined se non presente]
 */
SPToolbar.prototype.getElement = function(id) {
  return this.items.find( e => e.id == id )
}

/**
 * [doNothing previene la propagazione degli eventi di default]
 * @param  {[event]} event [evento in questione]
 */
SPToolbar.doNothing = function(event) {
  if(event.stopPropagation) {
    event.preventDefault();
  } else {
    event.returnValue=false;
  }
}

/**
 * [createDropElement assegno gli eventi di drop al canvas]
 */
SPToolbar.prototype.createDropElement = function() {
  // Test se ho gi� assegnato un evento drop all'elemento
  var dropElement = document.getElementById(this.options.dropElement);
  if (!dropElement._HasDropEvent) {
    dropElement.addEventListener('drop', function(event) {
       SPToolbar.doNothing(event);
       var action = JSON.parse(event.dataTransfer.getData('Text'));
       window[action['func']].call(this, event, action['par']);
    });
    dropElement._HasDropEvent = true;
  }

  // Test se ho gi� assegnato un evento dragover all'elemento
  if (!dropElement._HasDragOverEvent) {
    dropElement.addEventListener('dragover', function(event) {
      event.dataTransfer.dropEffect = 'copy';
      SPToolbar.doNothing(event);
    });
    dropElement._HasDragOverEvent = true;
  }
}

/**
 * [disable disabilita un elemento]
 * @param  {[type]}     id  [id dell'elemento]
 * @return {[boolean]}      [indica se l'elemento � stato disabilitato]
 */
SPToolbar.prototype.disable = function(id) {
  var disabled = false;
  var element = document.getElementById(id || this.id);
  if(element) {
    disabled = true;
    element.classList.add('disabled');
  }
  return disabled;
}

/**
 * [enable abilita un elemento che � stato precedentemente disabilitato]
 * @param  {[type]}     id  [id dell'elemento]
 * @return {[boolean]}      [indica se l'elemento � stato abilitato]
 */
SPToolbar.prototype.enable = function(id) {
  var enabled = false;
  var element = document.getElementById(id || this.id);
  if(element && element.classList.contains('disabled')) {
    enabled = true;
    element.classList.remove('disabled');
  }
  return enabled;
}


/**
 * [DEFAULTS propriet� di default della SPMultiToolbar]
 * @type {Object}
 */
SPMultiToolbar.DEFAULTS = {
  containerId: 'toolbar',
  title: ''
}

/**
 * [SPMultiToolbar contenitore di SPToolbar, sviluppato a sezioni e in modo verticale]
 * @param       {[string]} id       [id della toolbar da creare]
 * @param       {[object]} options  [opzioni dell'elemento, non obbligatorio]
 * @constructor
 */
function SPMultiToolbar(id, options) {
  this.id = id;
  this.options = SPToolbar.getOptions(options || {}, SPMultiToolbar.DEFAULTS);

  var container = document.getElementById(this.options.containerId);
  if(container != null) {
    container.classList.add('PSMultiToolbar');
  } else {
    throw new Error('Unable to find the toolbar container with id ' + this.options.containerId);
  }

  var spMultiToolbar = document.createElement('div');
  spMultiToolbar.id = this.id;

  var spMultiToolbarTitle = document.createElement('h1');
  spMultiToolbarTitle.innerHTML = this.options.title;
  spMultiToolbar.appendChild(spMultiToolbarTitle);

  container.appendChild(spMultiToolbar);
}

SPMultiToolbar.prototype.setOption = function( option, value ){
  let spMultiToolbar = document.getElementById(this.id);
  let title = spMultiToolbar.querySelector("h1");
  switch(option){
    case "title":
      title.innerHTML = value;
      break;
  }
}

/**
 * [disable disabilita la toolbar]
 * @return {[boolean]}      [indica se l'elemento � stato disabilitato]
 */
SPMultiToolbar.prototype.disable = function() {
  var disabled = false;
  var element = document.getElementById(this.id);
  if(element) {
    disabled = true;
    element.classList.add('disabled');
  }
  return disabled;
}

/**
 * [enable abilita la toolbar che e' stata precedentemente disabilitata]
 * @return {[boolean]}      [indica se l'elemento � stato abilitato]
 */
SPMultiToolbar.prototype.enable = function() {
  var enabled = false;
  var element = document.getElementById(this.id);
  if(element && element.classList.contains('disabled')) {
    enabled = true;
    element.classList.remove('disabled');
  }
  return enabled;
}
