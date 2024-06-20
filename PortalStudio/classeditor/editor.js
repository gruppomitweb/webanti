/* exported
    nitem itemsHTML m_bUpdated countindex codeEditor sortUnorderedList
    loadClass deleteClassFromFile refreshClassManager Help clone
  */

var type, className, beforeChangeClassName, selector, cssFile, codeEditor, index, skin, notimooManager;
var nitem = 1,
  itemsHTML = [],
  countindex = 1,
  m_bUpdated = false, // Flag per avviso di salvare
  allStyles = [], // Tutti gli stili del css
  loadedObj = '',
  newObj = '', // Oggetti visualizzati
  w = 480, // width di default dell'oggetto
  h = 240; // height di default dell'oggetto

var font_list = ['',
  'Coustard', 'Antic Slab', 'Quattrocento',
  'Cinzel', 'Josefin Slab', 'Merriweather', 'Lora',
  'Nunito', 'Abel', 'Fjalla One', 'Dosis', 'Economica',
  'Raleway', 'Montserrat', 'Roboto Condensed', 'Oswald',
  'Special Elite', 'Fredoka One', 'Comfortaa', 'Bangers',
  'Righteous', 'Sigmar One', 'Patua One', 'Poiret One', 'Lobster',
  'Nova Mono', 'Inconsolata', 'Source Code Pro', 'Anonymous Pro', 'Roboto Mono',
  'Amatic SC', 'Shadows Into Light', 'Dancing Script', 'Pacifico', 'Indie Flower'
];

/**
 * [newClass creo gli elementi necessari per creare un nuovo file]
 * @param  {[event]}  e        [evento]
 * @param  {[string]} skinName [nome della skin]
 * @param  {[string]} tn       [tipo dell'elemento]
 * @param  {[string]} cn       [nome dell'elemento]
 * @param  {[string]} cf       [file in cui salvare l'elemento]
 */
function newClass(e, skinName, tn, cn, cf) {
  b_reload = false;
  skin = skinName;
  type = tn.toLowerCase();
  className = cn;
  selector = !Empty(cn) ? '.' + cn : '';
  cssFile = cf.replace('.ce.css', ''); // mi assicuro che non ci sia l'estensione
  notimooManager = new Notimoo({});
  document.body.onhelp = CancelHelp;
  newObj = createTypedObj();
  newObj.class_name = className;
  newObj.selector = selector;

  // creo gli elementi dell'editor
  generateProperties();
  generateFileManager();
  addShortcut();
  Ctrl('toolbar-top').innerHTML = generateTitle(true);

  if (!Empty(className)) {
    var portalClasses = eval(new JSURL('../servlet/CssParser?name=portalstudio', true).Response());
    if (portalClasses.indexOf(className) > -1) {
      notimooManager.show({
        title: '<i class="mi mi-alert"></i> Skin class detected!',
        message: "You're trying to modify a skin class. Go to skin editor if you want change it.",
        visibleTime: 4500,
        width: 220
      });
    } else {
      Ctrl('general_class_name').value = className;
    }
  } else if (!Empty(cssFile)) {
    Ctrl('general_class_name').focus();
    notimooManager.show({
      title: 'New class created!',
      message: 'Insert a name and save the class to add it in current position.<br /><br /> Path: <i>' + (cssFile == 'portlet' ? cssFile : cssFile + '.ce.css') + '</i>',
      visibleTime: 4500,
      width: 220
    });
  }

  writeHTML();
}

/**
 * [loadClass carica la classe gia' esistente, se non viene trovata esegue la funzione newClass]
 * @param  {[event]}  e        [evento]
 * @param  {[string]} skinName [nome della skin]
 * @param  {[string]} tn       [tipo dell'elemento]
 * @param  {[string]} cn       [nome dell'elemento]
 * @param  {[string]} sl       [seleettore dell'elemento]
 * @param  {[string]} cf       [file in cui salvare l'elemento]
 */
function loadClass(e, skinName, tn, cn, sl, cf) {
  b_reload = false;
  skin = skinName;
  type = tn.toLowerCase();
  className = cn;
  selector = sl == 'undefined' ? undefined : sl;
  cssFile = cf.replace('.ce.css', ''); // mi assicuro che non ci sia l'estensione
  notimooManager = new Notimoo({});
  document.body.onhelp = CancelHelp;

  // se definito l'indice del GetOpener carico l'intero oggetto del portlet
  if (GetOpener() && GetOpener().index >= 0) {
    loadedObj = GetOpener().itemsHTML[GetOpener().index];
    if (loadedObj) {
      w = loadedObj.w;
      h = loadedObj.h;
    }
  }

  var list;
  if (cssFile != 'portlet') {
    allStyles = restoreClassFromFile(cssFile); // ripristino le classi all'interno del foglio stile caricato
    if (Empty(allStyles)) {
      allStyles = [];
    }
    list = allStyles;
  } else if (Empty(GetOpener().classCssObj)) {
    list = [];
  } else {
    list = GetOpener().classCssObj;
  }

  var found = false;
  // controllo se e' gia' presente
  for (var i = 0; i < list.length && !found; i++) {
    var class_name = Empty(list[i].version) ? list[i].name : list[i].class_name;
    if (class_name == className) {
      if (Empty(selector) || list[i].selector == selector) {
        found = true;
        if (!Empty(list[i].version)) {
          newObj = list[i];
        } else {
          // mantenuto per retrocompatibilita'
          newObj = JSON.parse(list[i].obj);
          newObj.selector = list[i].selector;
        }
      }
    }
  }

  if (found) {
    // creo un oggetto vuoto in base al tipo
    var tmpObj = createTypedObj();
    newObj = merge(tmpObj, newObj); // ricreo newObj con le proprieta' standard
    newObj = merge(newObj, newObj.specific_states_value[newObj.current_state]); // imposto i valori dello stato corrente
    updateStates(newObj.current_state, 'normal'); // apro l'editor nello stile normal
    newObj.current_state = 'normal';
    if (!Empty(tmpObj.value)) {
      newObj.value = tmpObj.value;
    } else if (!Empty(tmpObj.src)) {
      newObj.src = tmpObj.src;
    }
    newObj.font_list = newObj.font_list.concat(font_list).unique();
    if (Empty(selector)) {
      selector = newObj.selector;
    }
  } else {
    newClass('event', skin, type, className, cssFile); // non esiste nessuna classe, ne creo una nuova
  }

  // creo gli elementi dell'editor
  generateProperties();
  generateFileManager();
  addShortcut();
  Ctrl('toolbar-top').innerHTML = generateTitle(found);

  writeHTML();
}

/**
 * [deleteClass cancella la classe corrente]
 * @return {[type]} [true se e' stata trovata la classe da cancellare]
 */
function deleteClass(name, selector) {
  var found = false;
  var list = cssFile != 'portlet' ? allStyles : GetOpener().classCssObj;

  if (Empty(name)) {
    name = newObj.class_name;
    selector = newObj.selector;
  }

  for (var i = 0; list && i < list.length && !found; i++) {
    var class_name = Empty(list[i].version) ? list[i].name : list[i].class_name;
    if (class_name == name && list[i].selector == selector) {
      list.splice(i, 1);
      found = true;
    }
  }

  if (found) {
    if (cssFile != 'portlet') { // rigenero il file se la classe era esterna al file
      saveClass({
        notAddCurrent: true,
        actionType: 'delete'
      });
    }
    if (notimooManager.elements.length > 0) {
      notimooManager.close(notimooManager.elements[0]);
    }
    notimooManager.show({
      title: '<i class="mi mi-success"></i> Operation completed!',
      message: 'Class deleted.',
      visibleTime: 2000,
      width: 220
    });
    newClass('event', skin, type, className, cssFile);
  }
  return found;
}

/**
 * [deleteClassFromFile permette di cancellare una classe da un file .ce.css specificando il nome e il selettore]
 * @param  {[string]} fileName  [nome del file dal quale cancellare la classe]
 * @param  {[string]} className [nome della classe da cancellare]
 * @param  {[string]} selector  [selettore della classe da cancellare]
 * @return {[bool]}           [se la classe viene trovata e cancellata, ritorna true]
 */
function deleteClassFromFile(fileName, className, selector) {
  var found = false,
    classList = restoreClassFromFile(fileName);
  for (var i = 0; classList && i < classList.length && !found; i++) {
    var class_name = Empty(classList[i].version) ? classList[i].name : classList[i].class_name;
    if (class_name == className && classList[i].selector == selector) {
      classList.splice(i, 1);
      found = true;
    }
  }
  if (found) {
    generateCssFile(classList, fileName);
  }
  return found;
}

/**
 * [saveClass salva nella posizione corrente]
 * @param  {[obj]} options  [oggetto contenente la configurazione del metodo saveClass]
 */
function saveClass(options) {
  var removeOld = false;
  if (!Empty(options)) {
    var newPosition = options.newPosition, // nuova posizione in cui salvare la classe
      notAddCurrent = options.notAddCurrent, // a true se nel salvataggio non voglio venga aggiunto l'elemento corrente
      savePortlet = options.savePortlet, // se a true oltre a salvare la classe salva anche il portlet
      actionType = options.actionType; // l'azione che richiama la funzione di salvataggio
  }

  if (Empty(newObj.class_name)) {
    // se nome non presente mostro messaggio
    PSAlert.alert("Name of class can't be empty.");
    Ctrl('general_class_name').focus();
    return;
  }
  if (!checkIfValidName(newObj.class_name) && actionType != 'delete') {
    PSAlert.alert('Name of class not valid.<br /> The class name to be valid it must begin with a char and can contain only:<b> - _ a-z</b>');
    Ctrl('general_class_name').focus();
    return;
  }

  if (Empty(newObj.selector)) {
    // compatibilita' con oggetti senza selettore di vecchie versioni ClassEditor
    newObj.selector = '.' + newObj.class_name;
    removeOld = true;
  }

  var temp_font_list = [];
  for (var i = 0; i < newObj.font_list.length; i++) {
    if (font_list.indexOf(newObj.font_list[i]) == -1) {
      temp_font_list.push(newObj.font_list[i]);
    }
  }
  newObj.font_list = temp_font_list;

  var replace;
  if (newPosition == 'portlet' || cssFile == 'portlet' && Empty(newPosition)) {
    replace = checkIfReplace(GetOpener().classCssObj);
    if (replace === undefined) {
      return;
    }

    GetOpener().classCssObj.push(JSON.parse(createElementForSave(newObj)));
    if (savePortlet) {
      GetOpener().save();
    }
    notimooManager.show({
      title: '<i class="mi mi-success"></i> Operation completed!',
      message: 'Class saved in portlet.',
      visibleTime: 1500,
      width: 220
    });
    if (GetOpener().visualMode) {
      GetOpener().writeHTML();
    }
  } else {
    // se si salva in un file esterno diverso da quello di partenza
    if (newPosition && cssFile != newPosition) {
      allStyles = restoreClassFromFile(newPosition);
      cssFile = newPosition;
    } else if (Empty(allStyles)) {
      // il foglio stile non e' ancora stato salvato una volta
      // apro la maschera di salva con nome
      saveAsLayer();
      return;
    }

    replace = checkIfReplace(allStyles);
    if (replace === undefined) {
      return;
    }

    // Salvo il file senza l'elemento corrente (necessario per l'eliminazione)
    if (Empty(notAddCurrent)) {
      if(typeof allStyles == 'undefined' ) {
        allStyles = [];
      }
      allStyles.push(JSON.parse(createElementForSave(newObj)));
    }

    generateCssFile(allStyles);
    if (loadedObj && Empty(notAddCurrent)) {
      var css_list = GetOpener().formProp.css ? GetOpener().formProp.css.split(',') : [];
      var found = false;
      for(i = 0; i < css_list.length && !found; i++) {
        var patt = new RegExp('.*styles\/(.*)');
        var compare = patt.exec(cssFile); // mantego solo il nome del file senza percorso
        if (compare[1].replace('.ce.css', '') == css_list[i].replace('styles/', '').replace('.ce.css', '')) {
          found = true;
        }
      }
      if (!found) {
        // foglio non e' gia' presente
        css_list.push(cssFile + '.ce.css');
        GetOpener().formProp.css = css_list.join(',');
        GetOpener().Ctrl('Form_style_css').value = GetOpener().formProp.css; // aggiorno l'input a display
      }
    }
  }
  if (removeOld) {
    deleteClass(newObj.class_name, undefined);
  }
  generateFileManager();
  if (className != newObj.class_name || selector != newObj.selector || removeOld) {
    location.href = '../classeditor/editor.jsp?name=' + encodeURIComponent(newObj.class_name) + '&type=' + newObj.type.toLowerCase() +
      '&selector=' + encodeURIComponent(newObj.selector) + '&css=' + encodeURIComponent(cssFile);
  }
  m_bUpdated = false;
}

/**
 * [writeHTML rigenera il codice HTML per l'oggetto corrente]
 */
function writeHTML() {
  //
  var ctrl = Ctrl('container-item');
  ctrl.style.width = w + 'px';
  ctrl.style.height = h + 'px';

  var objClass = newObj[newObj.type + 'Class'] || newObj.objClass;
  if (objClass.wireframe) {
    ctrl.innerHTML = objClass.wireframe(newObj);
  }
}

/**
 * [previewCss apre il layer di visualizzazione di preview del codice generato]
 */
function previewCss() {
  if (Empty(newObj.class_name)) {
    PSAlert.alert('To show properly the preview you must first fill the field of name.');
    Ctrl('general_class_name').focus();
    return;
  }
  window.layerOpenForeground('../classeditor/preview.jsp', '', '', 480, 320, false, 1);
}

/**
 * [refreshClassManager aggiorna il class manager dell'editor]
 */
function refreshClassManager() {
  generateFileManager();
  notimooManager.show({
    title: '<i class="mi mi-success"></i> Operation completed!',
    message: 'Class manager updated.',
    visibleTime: 2500,
    width: 220
  });
}

/**
 * [createTypedObj creo un oggetto vuoto in base al tipo]
 * @return {[obj]} [oggetto di default crerato in base al tipo]
 */
function createTypedObj() {
  var tmpObj, value;
  switch(type.toLowerCase()) {
  case 'box':
    tmpObj = new ZTObjects.boxObj(newObj.class_name, 'box', '240', '120');
    break;
  case 'label':
    value = loadedObj ? loadedObj.value : 'Label text';
    tmpObj = new ZTObjects.labelObj(newObj.class_name, 'label', '200', '480', value);
    break;
  case 'image':
    var src = loadedObj && !Empty(loadedObj.src) ? loadedObj.src : './images/default.jpg';
    tmpObj = new ZTObjects.imageObj(newObj.class_name, 'image', '480', '240', src);
    // Preset delle immagini con stili predefiniti
    if (loadedObj) {
      switch (loadedObj.class_Css) {
      case 'image-circle':
        tmpObj.border_radius_tl = '50';
        tmpObj.border_radius_tr = '50';
        tmpObj.border_radius_br = '50';
        tmpObj.border_radius_bl = '50';
        tmpObj.border_radius_unit = ' %';
        break;
      case 'image-thumbnail':
        tmpObj.border_radius_tl = '5';
        tmpObj.border_radius_tr = '5';
        tmpObj.border_radius_br = '5';
        tmpObj.border_radius_bl = '5';
        tmpObj.pad_top = '5';
        tmpObj.pad_right = '5';
        tmpObj.pad_bottom = '5';
        tmpObj.pad_left = '5';
        tmpObj.bg_color = '#FFFFFF';
        break;
      }
    }
    break;
  case 'textbox':
    value = loadedObj ? loadedObj.value : 'Textbox text';
    tmpObj = new ZTObjects.textboxObj(newObj.class_name, 'textbox', '480', '240', value);
    break;
  case 'button':
    value = loadedObj ? loadedObj.value : 'Button';
    tmpObj = new ZTObjects.buttonObj(newObj.class_name, 'button', '480', '240', value);
    break;
  default:
    tmpObj = new ZTObjects.stdObj(newObj.class_name, 'undefined_type', '480', '240');
    break;
  }
  return tmpObj;
}

/**
 * [generateTitle genero il titolo della barra superiore del ClassEditor]
 * @param  {[bool]}   found [se true e' stata trovata la classe fra quelle gia' presenti]
 * @return {[string]}       [titolo del class editor]
 */
function generateTitle(found) {
  var title_string = 'Class Editor';
  if (found) {
    if (cssFile == 'portlet') {
      title_string = '(portlet) | ' + title_string;
    } else if (cssFile != '') {
      title_string = '(' + cssFile + '.ce.css) | ' + title_string;
    }
    if (newObj.selector) {
      title_string = newObj.selector + ' ' + title_string;
    } else if (className) {
      title_string = '.' + className + ' ' + title_string;
    }
  }
  return title_string;
}

/**
 * [addShortcut aggiungo shortcut rapidi da tastiera]
 */
function addShortcut() {
  document.onkeydown = function (e) {
    if (e.ctrlKey && e.shiftKey && e.keyCode === 83) { // CTRL+SHIFT+S: salva
      e.preventDefault();
      saveClass({
        savePortlet: true
      });
      return false;
    } else if (e.ctrlKey && e.keyCode === 83) { // CTRL+S: salva
      e.preventDefault();
      saveClass();
      return false;
    } else if (e.keyCode === 27) { // ESC: chiudi finestra
      window.close();
    } else if (e.ctrlKey && e.keyCode === 66) { // CTRL+B: anteprima
      previewCss();
    }
  };

  Ctrl('general_class_name').addEvents({ // il nome deve essere sempre presente
    blur: function () {
      if (beforeChangeClassName != this.value) {
        if (Empty(newObj.selector)) { // non c'e' nessun selettore, lo genero in automatico
          newObj.selector = !Empty(this.value) ? '.' + this.value : '';
        } else { // aggiorno il nome della classe presente nel selettore
          newObj.selector = !Empty(this.value) ?
            newObj.selector.replace('.' + beforeChangeClassName, '.' + this.value) : '';
        }
        Ctrl('advanced_selector').value = newObj.selector;
      }
    },
    focus: function () {
      beforeChangeClassName = this.value;
    }
  });

  Ctrl('advanced_selector').addEvents({
    blur: function () {
      if (Empty(this.value)) { // non c'e' nessun selettore, lo genero in automatico
        if (!Empty(newObj.class_name)) { // e' gia' stato scritto il nome della classe
          newObj.selector = '.' + newObj.class_name;
          this.value = newObj.selector;
        }
      } else if (newObj.selector.search('.' + newObj.class_name) == -1) { // nel selettore non e' stato inserito il nome della classe
        PSAlert.alert('There is no class name in selector.');
        this.focus();
      }
    }
  });
}

/**
 * [checkIfReplace controllo se e' gia' presente una classe con il nome scelto]
 * @param  {[obj]}  obj [elemento corrente]
 * @return {[bool]}     [true se si decide di sostituire l'elemento]
 */
function checkIfReplace(obj) {
  var replace = false;
  for (var i = 0; obj && i < obj.length && !replace; i++) {
    var class_name = Empty(obj[i].version) ? obj[i].name : obj[i].class_name;
    if (class_name == newObj.class_name && obj[i].selector == newObj.selector) {
      if (newObj.selector != selector) {
        replace = confirm('There is already a class with this name, do you want to replace it?');
        if (replace) { // l'utente ha confermato che vuole sovrascrivere la classe
          obj.splice(i, 1);
        } else {
          Ctrl('general_class_name').focus();
          return;
        }
      } else {
        obj.splice(i, 1);
      }
    }
  }
  return replace;
}

/**
 * [checkIfValidName controllo che il nome della classe css sia valido]
 * @param  {[string]}  classname [nome della classe da controllare]
 * @return {[bool]}              [true se il nome e' valido]
 */
function checkIfValidName(classname) {
  /* Il nome della classe per essere valido deve cominciare con un [a-z] e
   * puo' contenere solo (-), (_) e a-z.
   **/
  if (!/^([a-z])[a-z\d_-]*$/i.test(classname)) {
    return false;
  }
  return true;
}

/**
 * [generateCssFile genero il foglio stile completo]
 * @param  {[array]}  allStyles [contiene tutti gli elementi che verranno generati nel foglio stile]
 */
function generateCssFile(allStyles, fileName) {
  var file = !Empty(fileName) ? fileName : cssFile,
    folder_path = '';
  folder_path = cssFile.substring(0, cssFile.lastIndexOf("/") + 1);
  file = Strtran(file, folder_path, "");
  var url = new JSURL( '../servlet/JSPSave?type=classeditor'+
    '&name=' + file +
    '&folder_path=' + folder_path +
    '&def=' + URLenc(JSON.stringify(allStyles)) +
    '&m_cID=' + cmdhash
    , true);
  checkOutput(url.Response(), file, folder_path);
}

/**
 * [checkOutput controllo del corretto salvataggio del file]
 * @param  {[string]} output      [risultato del salvataggio]
 * @param  {[string]} file        [file di cui si controlla il corretto salvataggio]
 * @param  {[string]} folder_path [percorso del file di cui si controlla il corretto salvataggio]
 */
function checkOutput(output, file, folder_path) {
  if (Empty(notimooManager)) {
    notimooManager = new Notimoo({});
  }
  if (window.parent.changeName) {
    window.parent.changeName(file, folder_path, Strtran(window.frameElement.id, 'portalstudioframe', ''));
  }
  if (output == null) {
    output = '';
  }
  switch (output) {
  case 'true':
    for (var i = 0; i < notimooManager.elements.length; i++) {
      notimooManager.close(notimooManager.elements[i]);
    }
    notimooManager.show({
      title: '<i class="mi mi-success"></i> Operation completed!',
      message: 'File saved!',
      visibleTime: 2500,
      width: 220
    });
    break;
  case 'ACCESS DENIED':
    notimooManager.close(notimooManager.elements[0]);
    alert('Access Denied.');
    break;
  case 'LICENSE LIMIT':
    notimooManager.close(notimooManager.elements[0]);
    alert('Licensed User Limit Reached.');
    break;
  default:
    notimooManager.close(notimooManager.elements[0]);
    alert('Save routine failed.');
    break;
  }
}

/**
 * [saveAsLayer se nome non presente mostro messaggio, altrimenti mostro finestra di dialogo per il salvataggio su file]
 */
function saveAsLayer() {
  if (Empty(newObj.class_name)) {
    PSAlert.alert("Name of class can't be empty.");
    Ctrl('general_class_name').focus();
    return;
  }
  window.layerOpenForeground('../portalstudio/saveas.jsp?tool=classeditor', 'SaveCSSFile', '', 530, 360, true, 1);
}

/**
 * [Help funzione per la documentazione, apre la pagina relativa alla proprieta' selezionata]
 * @param {[string]} the_property [proprieta' della quale si chiede la documentazione]
 */
function Help(the_property) {
  var i,
    prop = '';
  if (typeof anchorToFeature != 'undefined') {
    if (typeof the_property != 'undefined') {
      prop += 'csseditor_' + the_property.toLowerCase();
    }

    if (prop.indexOf('undefined') > 9) {
      prop = Strtran(prop, 'undefined_type', 'css');
    }

    if (prop != '' && prop in anchorToFeature) {
      i = anchorToFeature[prop];
    } else if (index != null && 'classeditor_' + newObj.type.toLowerCase() in anchorToFeature) {
      i = anchorToFeature['classeditor_' + newObj.type.toLowerCase()];
    } else {
      i = anchorToFeature.csseditor;
    }

    windowOpenForeground(
      m_cHelpUrl + 'help/portalstudio/ps_urg_navigator.htm?' + URLenc(i + (prop != '' ? '||' + prop + '' : '')), '',
      'toolbar=0, menubar=0, directories=0, width=720, height=600, resizable=1, scrollbars=1'
    );
  }
}

/**
 * [clone funzione per la copia profonda di oggetti e array]
 * @param  {[type]} obj [l'oggetto da clonare]
 * @return {[type]}     [l'oggetto clonato]
 */
function clone(obj) {
  var copy;

  // Handle the 3 simple types, and null or undefined
  if (null == obj || "object" != typeof obj) return obj;

  // Handle Date
  if (obj instanceof Date) {
    copy = new Date();
    copy.setTime(obj.getTime());
    return copy;
  }

  // Handle Array
  if (obj instanceof Array) {
    copy = [];
    for (var i = 0, len = obj.length; i < len; i++) {
      copy[i] = clone(obj[i]);
    }
    return copy;
  }

  // Handle Object
  if (obj instanceof Object) {
    copy = {};
    for (var attr in obj) {
      if (obj.hasOwnProperty(attr)) copy[attr] = clone(obj[attr]);
    }
    return copy;
  }

  throw new Error("Unable to copy obj! Its type isn't supported.");
}

/**
 * Sovrascrive i valori di obj1 con quelli di obj2, e se non esistono li aggiunge
 * @param obj1
 * @param obj2
 * @returns obj3 un nuovo oggetto basato su obj1 e obj2
 */
function merge(obj1, obj2){
  var attrname;
  var obj3 = {};
  for (attrname in obj1) { obj3[attrname] = obj1[attrname]; }
  for (attrname in obj2) { obj3[attrname] = obj2[attrname]; }
  return obj3;
}

function compareText(a1, a2) {
  var t1 = a1.innerText,
    t2 = a2.innerText;
  return t1 > t2 ? 1 : (t1 < t2 ? -1 : 0);
}

/**
 * [sortUnorderedList ordina una lista di elementi ul/li]
 * @param  {[Object]} ul              [l'id della lista o la lista stessa]
 * @param  {[bool]} sortDescending    [true per ordinare la lista in ordine decrescente]
 */
function sortUnorderedList(ul, sortDescending) {
  if (typeof ul == "string") {
    ul = document.getElementById(ul);
  }

  var lis = ul.getElementsByTagName("li");
  var vals = [];

  for (var i = 0, l = lis.length; i < l; i++) {
    vals.push(lis[i]);
  }

  vals.sort(compareText);

  if (sortDescending) {
    vals.reverse();
  }

  ul.innerHTML = '';
  for (i = 0, l = vals.length; i < l; i++) {
    ul.appendChild(vals[i]);
  }
}
