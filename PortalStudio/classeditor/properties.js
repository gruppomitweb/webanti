/* exported
    ps_props generateProperties updateProperties updateStates addFont delFont
  */
var formProp = new ZTObjects.formObj();
var ps_props = {};

function generateProperties() {
  newPropObj = new propertiesObj({
    m_obj: newObj
  });

  document.getElementById('properties').removeAttribute('style');
  // Aggiungo editor css personalizzato
  var textareaCodeEditor = Ctrl('advanced_code');
  codeEditor = CodeMirror.fromTextArea(textareaCodeEditor, { // codeEditor definito all'interno di editor.js
    lineNumbers: true,
    autofocus: true,
    lineWrapping: true,
    showCursorWhenSelecting: true,
    mode: 'text/css'
  });
  codeEditor.on('blur', function() {
    textareaCodeEditor.value = codeEditor.getValue();
    newObj.code = textareaCodeEditor.value;
    writeHTML();
  });

  // aggiungo funzione show/hide per la sezione degli stati
  newObj.current_state != ':before' && newObj.current_state != ':after' ?
    Ctrl('general_content_section').classList.add('hide-element') :
    Ctrl('general_content_section').classList.remove('hide-element');

  // aggiungo evento per aggiornare il codeEditor al click del tab che lo contiene
  Ctrl('advanced_tab').addEvents({
    click: function() {
      codeEditor.refresh();
    }
  });
}

function updateProperties(input, the_property, propertyType, isForm, value, updateHTML, reconvertFunc, validFunc, m_obj, alwaysUpdates, setOnBlurFunc) {
  updateHTML = typeof updateHTML == 'undefined' ? true : updateHTML;
  if (m_obj && typeof m_obj.updateHTML != 'undefined') {
    updateHTML = m_obj.updateHTML;
  }
  var arrayProp;
  if (isForm) {
    arrayProp = formProp;
  } else if (m_obj) {
    arrayProp = m_obj;
  } else {
    arrayProp = newObj;
  }
  if (value == arrayProp[the_property]) {
    return;
  }
  switch (the_property) {
  case 'h':
  case 'w':
  case 'name':
    if (EmptyString(value)) {
      PSAlert.alert('Obligatory data input');
      setTimeout("document.getElementById('" + input.id + "').focus();", 50);
      setTimeout("document.getElementById('" + input.id + "').select();", 50);
      return;
    }
    break;
  }

  if (reconvertFunc) {
    value = window[reconvertFunc](value);
  }

  if (validFunc) {
    var r;
    if (typeof validFunc == 'string') {
      r = window[validFunc](value, the_property, input, index);
    } else {
      r = validFunc.call(null, value, the_property, input, index);
    }

    if (r != true) {
      if (input.type == 'checkbox') {
        input.checked = false;
      } else {
        input.value = arrayProp[the_property];
        setTimeout("document.getElementById('" + input.id + "').focus();", 50);
        setTimeout("document.getElementById('" + input.id + "').select();", 50);
      }
      return;
    }
  }

  if (setOnBlurFunc) {
    if (typeof setOnBlurFunc == 'string') {
      window[setOnBlurFunc](value, the_property, input, index);
    } else {
      setOnBlurFunc.call(null, value, the_property, input, index);
    }
  }

  if (typeof value == 'boolean' && arrayProp[the_property] == value.toString()) {
    return;
  }
  if (typeof b_reload != 'undefined' && b_reload || arrayProp[the_property] == value) {
    return;
  }
  if (!alwaysUpdates && Empty(value) && Empty(arrayProp[the_property])) {
    return;
  }

  switch (propertyType) {
  case 'int': // solo valori numerici
    if (!Empty(value)) {
      if (isNaN(value)) {
        PSAlert.alert('Not a numeric value !');
        setTimeout("document.getElementById('" + input.id + "').focus();", 50);
        setTimeout("document.getElementById('" + input.id + "').select();", 50);
        return;
      }
      arrayProp[the_property] = value;
      if (updateHTML) {
        writeHTML();
      }
    } else {
      arrayProp[the_property] = value;
      if (updateHTML) {
        writeHTML();
      }
    }
    break;

  case 'checkbox':
    if (typeof value == 'boolean') {
      value = value ? 'true' : 'false';
    }
    updateHTML = true;
    arrayProp[the_property] = value;
    writeHTML();
    if (the_property == 'hsl')// Se si richiamano le snaplines bisogna deselezionare tutto
        {
      if (value != 'true') {
        selectForm();
      }
    }
    break;

  default:
    if (the_property == 'maxlength' && Trim(value) != '') {
      arrayProp.w = Math.floor(value * 7.5);
    }
    arrayProp[the_property] = value;
    if (updateHTML) {
      writeHTML();
    }
    break;
  }

  if (window.updatePropertiesSelected) {
    updatePropertiesSelected(the_property, isForm, value, updateHTML);
  }
  m_bUpdated = true;
}

function updateStates(oldState, newState) {
  var category, j, propID;
  // Se lo stato non ha ancora valori specifici creo il nuovo oggetto
  if (!newObj.specific_states_value[oldState]) {
    newObj.specific_states_value[oldState] = {};
  }

  // Copio le proprietà personalizzabili per ogni state sulla variabile specific_states_value
  for (category in newObj.objClass.newProperties) {
    for (j = 0; j < newObj.objClass.newProperties[category].length; j++) {
      propID = newObj.objClass.newProperties[category][j].propID;

      if (newObj.common_properties.indexOf(propID) == -1) {
        newObj.specific_states_value[oldState][propID] = newObj[propID];
      }
    }
  }

  // Svuoto il newObj e nel caso sia presente ripristino il valore del specific_states_value[newState]
  for (category in newObj.objClass.newProperties) {
    for (j = 0; j < newObj.objClass.newProperties[category].length; j++) {
      propID = newObj.objClass.newProperties[category][j].propID;

      if (newObj.common_properties.indexOf(propID) == -1) {
        if (newObj.specific_states_value[newState]) {
          newObj[propID] = newObj.specific_states_value[newState][propID];
        } else {
          delete newObj[propID];
        }
      }
    }
  }
}

function addFont(obj) {
  if (document.getElementById(obj.refId + '_add')) {
    return;
  }
  var propInput_add = new Element('input', { id: obj.refId + '_add', name: obj.refId + '_add', 'class': 'properties_input' });
  propInput_add.setStyles({ position: 'absolute', width: '60%', left: '13px' });
  propInput_add.inject(document.querySelector('#' + obj.refId).parentNode);
  propInput_add.addEvents({
    focus: function() {
      SetOnEditProp(true);
    },
    blur: function() {
      if (Empty(this.value)) {
        propInput_add.destroy();
        SetOnEditProp(false);
        return;
      }
      newObj.font_list.push(this.value);
      newObj.online_font = this.value;

      var selectobject = Ctrl(obj.refId);
      var propInputOptAdd = new Element('option', {
        value: this.value,
        text: this.value,
        selected: 'selected'
      }).setStyles({
        'font-family': this.value
      });
      selectobject.options.add(propInputOptAdd, selectobject.options[1]);

      var link = document.createElement('link');
      link.href = 'https://fonts.googleapis.com/css?family=' + Strtran(this.value, ' ', '+');
      link.rel = 'stylesheet';
      link.type = 'text/css';
      document.head.appendChild(link);

      selectobject.setStyles({
        'font-family': this.value
      });

      writeHTML();
      propInput_add.destroy();
    },
    keydown: function(event) {
      if (event.key == 'enter') {
        this.blur();
      }
      if (event.key == 'esc') {
        propInput_add.destroy();
        SetOnEditProp(false);
      }
    }
  });
  propInput_add.focus();
}

function delFont(obj) {
  if (Empty(newObj.online_font)) {
    return;
  }
  newObj.font_list.splice(newObj.font_list.indexOf(newObj.online_font), 1);
  var selectobject = Ctrl(obj.refId);
  for (var i = 0; i < selectobject.length; i++) {
    if (selectobject.options[i].value == newObj.online_font ) {
      selectobject.remove(i);
    } else if (selectobject.options[i].value == '') {
      selectobject.options[i].selected = true;
    }
  }
  newObj.online_font = '';
  writeHTML();
}

var title, actions;
function generateFileManager() {
  var standalone_app = cssFile != 'portlet' && Empty(GetOpener());
  var ctrl_conteiner = Ctrl('class-manager');
  ctrl_conteiner.innerHTML = '';
  var section, content, i, class_name;
  var count = 0;
  var list = standalone_app ? [] : GetOpener().classCssObj;

  section = new Element('section', { 'class': 'file' });
  content = new Element('ul', { 'class': 'file-content' });
  if (!Empty(list)) {
    for (i = 0; i < list.length; i++) {
      class_name = Empty(list[i].version) ? list[i].name : list[i].class_name;
      // cerco la classe nel portlet
      if (class_name == className) {
        createHTML(list[i], 'portlet').inject(
          new Element('li', {
            id: 'file-' + count++,
            'class': checkCurrent(list[i], 'portlet')
          }).inject(content)
        );
      }
    }
    injectElement('portlet', content, section);
    section.inject(ctrl_conteiner);
  }

  var tmp_list = [];
  if (standalone_app) {
    if (!Empty(cssFile)) {
      tmp_list = [cssFile + '.ce.css'];
    }
  } else if (!Empty(GetOpener().formProp) && !Empty(GetOpener().formProp.css)) {
    tmp_list = GetOpener().formProp.css.split(',');
  }

  for (i = 0; i < tmp_list.length; i++) {
    tmp_list[i] = tmp_list[i].substring(tmp_list[i].indexOf('styles/'), tmp_list[i].lenght);
    if (tmp_list[i].indexOf('.ce.css') == -1) {
      continue;
    } // non è un foglio stile del class editor
    // cerco la classe nei fogli stile
    var allStyles = restoreClassFromFile(tmp_list[i]);
    section = new Element('section', { 'class': 'file' });
    content = new Element('ul', { 'class': 'file-content' });
    for (var ii = 0; allStyles && ii < allStyles.length; ii++) {
      class_name = Empty(allStyles[ii].version) ? allStyles[ii].name : allStyles[ii].class_name;
      if (standalone_app || class_name == className) {
        createHTML(allStyles[ii], tmp_list[i]).inject(
          new Element('li', {
            id: 'file-' + count++,
            'class': checkCurrent(allStyles[ii], tmp_list[i])
          }).inject(content)
        );
      }
    }
    injectElement(tmp_list[i], content, section);

    var listSkins = new JSURL('../servlet/JSPReader?type=themes', true).Response().split(',');
    // cerco la classe nei fogli stile delle varie skin
    for (var j = 0; j < listSkins.length - 1; j++) {
      content = new Element('ul', { 'class': 'file-content' });
      var allStylesThemed = restoreClassFromFile(listSkins[j] + '/' + tmp_list[i]);
      for (var jj = 0; allStylesThemed && jj < allStylesThemed.length; jj++) {
        class_name = Empty(allStylesThemed[jj].version) ? allStylesThemed[jj].name : allStylesThemed[jj].class_name;
        if (standalone_app || class_name == className) {
          createHTML(allStylesThemed[jj], listSkins[j] + '/' + tmp_list[i]).inject(
            new Element('li', {
              id: 'file-' + count++,
              'class': checkCurrent(allStylesThemed[jj], listSkins[j] + '/' + tmp_list[i])
            }).inject(content)
          );
        }
      }
      injectElement(listSkins[j] + '/' + tmp_list[i], content, section);
    }
    section.inject(ctrl_conteiner);
  }
  Ctrl('class-manager-title').innerHTML = count > 0 ? count + ' class(es) found in:' : 'No class found.';

  [].forEach.call(document.querySelectorAll('.file-content'), function(ul) {
    sortUnorderedList(ul, false);
  })
}

/** *** SUPPORT FUNCTIONS *****/

function checkCurrent(obj, file) {
  var isCurrent = '';
  var class_name = Empty(obj.version) ? obj.name : obj.class_name;
  if (className == class_name && selector == obj.selector && cssFile == file.replace('.ce.css', '')) {
    isCurrent = 'current';
  }
  return isCurrent;
}

function createHTML(obj, file) {
  var class_name = Empty(obj.version) ? obj.name : obj.class_name;
  // creo il codice html del singolo oggetto allinterno della lista file
  return new Element('span', {
    html: (obj.selector ? obj.selector : class_name),
    events: {
      click: function () {
        if (!m_bUpdated || confirm('Doing so, you will lose all changes made until now, are you sure you want to continue?')) {
          loadClass('event', skin, obj.type, class_name, obj.selector, file);
        }
      }.bind(this)
    }
  });
}

function injectElement(name, content, section) {
  title = new Element('div', { 'class': 'file-title', html: '<span>' + name + '</span>' });
  actions = new Element('nav', { 'class': 'file-actions' });

  new Element('i', { // aggiungo l'icona per duplicare le classi
    'class': 'mi mi-clone file-title-icon',
    title: 'Clone selected class in current position.',
    name: name,
    events: {
      click: function () {
        saveClass({ newPosition: this.getAttribute('name').replace('.ce.css', '') });
        generateFileManager();
        Ctrl('advanced_tab').click();
        setTimeout("document.getElementById('advanced_selector').focus();", 50);
        setTimeout("document.getElementById('advanced_selector').select();", 50);
        notimooManager.show({
          title: '<i class="mi mi-success"></i> Current class clone successful!',
          message: 'The new class has the same classname and property of old css class, but must have a different selector, change it in Advanced tab.',
          visibleTime: 9500,
          width: 220
        });
      }
    }
  }).inject(actions);

  new Element('i', {  // aggiungo l'icona per la nuova classe
    'class': 'mi mi-add file-title-icon',
    title: 'Add class in current position.',
    name: name,
    events: {
      click: function () {
        newClass('event', skin, type, className, this.getAttribute('name'));
        Ctrl('advanced_tab').click();
        setTimeout("document.getElementById('advanced_selector').focus();", 50);
        setTimeout("document.getElementById('advanced_selector').select();", 50);
        notimooManager.show({
          title: '<i class="mi mi-success"></i> New class created!',
          message: 'The new class has the same classname of old css class, but must have a different selector, change it in Advanced tab.',
          visibleTime: 9500,
          width: 220
        });
      }
    }
  }).inject(actions);

  actions.inject(title);
  title.inject(section);
  content.inject(section);
}
