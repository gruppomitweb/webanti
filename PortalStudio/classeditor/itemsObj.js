// Proprieta' oggetti
if (typeof ZTObjects == 'undefined') {
  var ZTObjects = new function() {
    this.findProp = function (propID, container) {
      for ( var j = 0; j < container.length; j++) {
        if ( container[j].propID == propID ) {
          return j;
          break;
        }
      }
      return -1;
    };

    // Funzione che permette di estendere le Proprieta' da un altro oggetto
    this.extend = function(objA, objB) {
      var propsA = objA.newProperties,
        propsB = objB.newProperties;
      for ( var prop in propsA ) {
        for ( var i = 0; i < propsA[prop].length; i++ ) {
          if ( typeof propsB[prop] == 'undefined' ) {
            propsB[prop] = propsA[prop];
            break;
          }
          var iB = this.findProp(propsA[prop][i].propID, propsB[prop]);
          if ( iB == -1 ) {
            propsB[prop].splice(i, 0, propsA[prop][i]);
          }
        }
      }
    };

    function merge(objA, objB) {
      for (var attrname in objB) {
        objA[attrname] = objB[attrname];
      }
    }

    this.stdObjClass = {
      newProperties: {
        general: [
          { name: 'class name', propID: 'class_name', type: 'str', section: 'main', tooltip: 'The class name to be valid it must begin with a char and can contain only:<b> - _ a-z</b>' },
          { name: 'element states', propID: 'current_state', type: 'css_prop', section: 'main', extraClass: 'col-3' },
          { name: 'display', propID: 'display', type: 'autocomplete[default:block,none,inline-block,inline]', section: 'main', extraClass: 'col-3' },
          { name: 'width', propID: 'w_content', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'content', extraClass: 'col-3' },
          { name: 'height', propID: 'h_content', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'content', extraClass: 'col-3' },
          { name: 'content', propID: 'content', type: 'textarea', section: 'content' },
          { name: 'top', propID: 'pad_top', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'padding', extraClass: 'col-3' },
          { name: 'bottom', propID: 'pad_bottom', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'padding', extraClass: 'col-3' },
          { name: 'left', propID: 'pad_left', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'padding', extraClass: 'col-3' },
          { name: 'right', propID: 'pad_right', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'padding', extraClass: 'col-3' },
          { name: 'top', propID: 'mar_top', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'margin', extraClass: 'col-3' },
          { name: 'bottom', propID: 'mar_bottom', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'margin', extraClass: 'col-3' },
          { name: 'left', propID: 'mar_left', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'margin', extraClass: 'col-3' },
          { name: 'right', propID: 'mar_right', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'margin', extraClass: 'col-3' },
          { name: 'image', propID: 'bg_img', type: 'image', section: 'background' },
          { name: 'repeat', propID: 'bg_repeat', type: 'select[,no-repeat,repeat,repeat-x,repeat-y,round,space,initial,inherit]', defaultValue: true, section: 'background', extraClass: 'col-3' },
          { name: 'size value', propID: 'bg_size', type: 'int', section: 'background', extraClass: 'col-3' },
          { name: 'size', propID: 'bg_size_pr', type: 'select[,cover,contain,percent]', defaultValue: true, section: 'background', extraClass: 'col-3' },
          { name: 'position', propID: 'bg_pos', type: 'autocomplete[default:left top,left center,left bottom,right top,right center,right bottom,center top,center center,center bottom]', defaultValue: true, section: 'background', extraClass: 'col-3' },
          { name: 'color', propID: 'bg_color', type: 'color', section: 'background' },
          { name: '', propID: 'specific_states_value', type: 'str', disabled: 'true' }
        ],
        style: [
          { name: 'width', propID: 'border_width', type: 'autocomplete[numberExt:px,em,rem,pt]', section: 'border', extraClass: 'col-3' },
          { name: 'type', propID: 'border_type', type: 'select[,solid,dotted,dashed,double,ridge,groove,inset,outset]', defaultValue: true, section: 'border', extraClass: 'col-3' },
          { name: 'color', propID: 'border_color', type: 'color', section: 'border' },
          { name: 'top left', propID: 'border_radius_tl', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'border Radius', extraClass: 'col-3' },
          { name: 'top right', propID: 'border_radius_tr', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'border Radius', extraClass: 'col-3' },
          { name: 'bottom left', propID: 'border_radius_bl', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'border Radius', extraClass: 'col-3' },
          { name: 'bottom right', propID: 'border_radius_br', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'border Radius', extraClass: 'col-3' },
          { name: 'Hor. offset', propID: 'shadow_hl', type: 'autocomplete[number:px,em,rem,pt]', section: 'box Shadows', extraClass: 'col-3' },
          { name: 'Ver. offset', propID: 'shadow_vl', type: 'autocomplete[number:px,em,rem,pt]', section: 'box Shadows', extraClass: 'col-3' },
          { name: 'size', propID: 'shadow_size', type: 'autocomplete[number:px,em,rem,pt]', section: 'box Shadows', extraClass: 'col-3' },
          { name: 'blur', propID: 'shadow_blur', type: 'autocomplete[number:px,em,rem,pt]', section: 'box Shadows', extraClass: 'col-3' },
          { name: 'color', propID: 'shadow_color', type: 'color', section: 'box Shadows' },
          { name: 'type', propID: 'shadow_type', type: 'select[,inset,outline]', defaultValue: true, section: 'box Shadows', extraClass: 'col-3' },
          { name: 'translateX', propID: 'transform_translatex', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'transforms', extraClass: 'col-3' },
          { name: 'translateY', propID: 'transform_translatey', type: 'autocomplete[number:px,%,em,rem,pt]', section: 'transforms', extraClass: 'col-3' },
          { name: 'scaleX', propID: 'transform_scalex', type: 'int', section: 'transforms', extraClass: 'col-3' },
          { name: 'scaleY', propID: 'transform_scaley', type: 'int', section: 'transforms', extraClass: 'col-3' },
          { name: 'rotate', propID: 'transform_rotate', type: 'autocomplete[number:deg]', section: 'transforms', extraClass: 'col-3' },
          { name: 'property', propID: 'transition_property', type: 'autocomplete[default:all,width,height]', section: 'transition', extraClass: 'col-3' },
          { name: 'duration', propID: 'transition_duration', type: 'autocomplete[number:s]', section: 'transition', extraClass: 'col-3' },
          { name: 'delay', propID: 'transition_delay', type: 'autocomplete[number:s]', section: 'transition', extraClass: 'col-3' },
          { name: 'timing function', propID: 'transition_timing', type: 'autocomplete[default:ease,linear,ease-in,ease-out,initial,inherit]', section: 'transition', extraClass: 'col-3' }
        ],
        font: [
          { name: 'font offline', propID: 'font', type: 'advanced-font', section: 'font settings' },
          { name: 'font web online', propID: 'online_font', buttons: 'plus,del', actions: 'addFont(),delFont()', type: 'manual_font', section: 'font settings', tooltip: 'Insert the name of font from Google Font. This font overwrite the offline font selected.' },
          { name: 'font size', propID: 'size', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'font settings', extraClass: 'col-3' },
          { name: 'line height', propID: 'lheight', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'font settings', extraClass: 'col-3' },
          { name: 'weight', propID: 'weight', type: 'autocomplete[default:normal, 300, 500, 600, bold]', defaultValue: true, section: 'font settings', extraClass: 'col-3' },
          { name: 'style', propID: 'style', type: 'select[,normal,italic,oblique]', defaultValue: true, section: 'font settings', extraClass: 'col-3' },
          { name: 'decoration', propID: 'decoration', type: 'select[,none,underline,overline,line-through]', defaultValue: true, section: 'font settings', extraClass: 'col-3' },
          { name: 'transform', propID: 'transform', type: 'select[,none,lowercase,uppercase,capitalize]', defaultValue: true, section: 'font settings', extraClass: 'col-3' },
          { name: 'font color', propID: 'font_color', type: 'color', section: 'font settings' },
          { name: 'align', propID: 'align', type: 'select[,left,center,right,justify]', defaultValue: true, section: 'font settings', extraClass: 'col-3' },
          { name: 'Hor. length', propID: 'tx_shadow_hl', type: 'autocomplete[number:px,em,rem,pt]', section: 'text Shadows', extraClass: 'col-3' },
          { name: 'Ver. length', propID: 'tx_shadow_vl', type: 'autocomplete[number:px,em,rem,pt]', section: 'text Shadows', extraClass: 'col-3' },
          { name: 'color', propID: 'tx_shadow_color', type: 'str', section: 'text Shadows' },
          { name: 'blur', propID: 'tx_shadow_blur', type: 'autocomplete[number:px,em,rem,pt]', section: 'text Shadows', extraClass: 'col-3' },
          { name: 'N. Col.', propID: 'n_col', type: 'int', tooltip: 'Number of columns to display the text', section: 'columns', extraClass: 'col-3' },
          { name: 'width', propID: 'col_width', type: 'autocomplete[numberExt:px,em,rem,pt]', tooltip: 'Specifies a suggested, optimal width for the columns', section: 'columns', extraClass: 'col-3' },
          { name: 'gap', propID: 'col_gap', type: 'autocomplete[numberExt:px,em,rem,pt]', tooltip: 'Gap between the columns', section: 'columns', extraClass: 'col-3' },
          { name: 'rules width', propID: 'col_rules_width', type: 'autocomplete[numberExt:px,em,rem,pt]', tooltip: 'Width of the rule between columns', section: 'columns', extraClass: 'col-3' },
          { name: 'rules color', propID: 'col_rules_color', type: 'color', tooltip: 'Color of the rule between columns', section: 'columns' },
          { name: 'rules style', propID: 'col_rules_style', type: 'select[,solid,dotted,dashed,double,ridge,groove,inset,outset]', section: 'columns', extraClass: 'col-3' }
        ],
        advanced: [
          { name: 'selector', propID: 'selector', type: 'str', section: 'Selector', tooltip: 'In CSS, selectors are patterns used to select the element(s) you want to style. Example: .class, #id, *, div > p, etc' },
          { name: 'code', propID: 'code', type: 'textarea', section: 'CSS manual code property', tooltip: 'Insert only the property with its value, separated by semicolon.' },
          { name: 'cursor', propID: 'cursor', type: 'autocomplete[default:auto,pointer,help,grab,move,text]', section: 'Others', tooltip: 'The cursor property specifies the type of cursor to be displayed when pointing on an element.', extraClass: 'col-3' },
          { name: 'remove outline', propID: 'remove_outline', type: 'checkbox', section: 'Others', tooltip: 'An outline is a line that is drawn around elements (outside the borders) to make the element "stand out".', extraClass: 'col-3' },
          { name: 'position', propID: 'position_type', type: 'autocomplete[default:absolute,fixed,relative,static]', section: 'position' },
          { name: 'top', propID: 'pos_top', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'position', extraClass: 'col-3' },
          { name: 'bottom', propID: 'pos_bottom', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'position', extraClass: 'col-3' },
          { name: 'left', propID: 'pos_left', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'position', extraClass: 'col-3' },
          { name: 'right', propID: 'pos_right', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'position', extraClass: 'col-3' },
          { name: 'min width', propID: 'min_width', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'min and max sizing', extraClass: 'col-3' },
          { name: 'max width', propID: 'max_width', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'min and max sizing', extraClass: 'col-3' },
          { name: 'min height', propID: 'min_height', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'min and max sizing', extraClass: 'col-3' },
          { name: 'max height', propID: 'max_height', type: 'autocomplete[numberExt:px,%,em,rem,pt]', section: 'min and max sizing', extraClass: 'col-3' }
        ]
      },
      wireframe: function(obj) {
        return '<style>' + createBaseCSS(obj, 'default', obj.current_state) + createCSS(obj, obj.current_state, false) + '</style>'
          + "<div class='" + (Empty(obj.class_name) ? 'temp' : obj.class_name) + "'>Test preview.</div>";
      }
    };

    // Proprieta' disponibili per l'oggetto box
    this.boxObjClass = {
      newProperties: {},
      wireframe: function(obj) {
        return '<style>' + createBaseCSS(obj, 'box', obj.current_state) + createCSS(obj, obj.current_state, false) + '</style>'
          + "<div class='" + (Empty(obj.class_name) ? 'temp' : obj.class_name) + "'></div>";
      }
    };
    this.extend(this.stdObjClass, this.boxObjClass);

    // Proprieta' disponibili per l'oggetto immagine
    this.imageObjClass = {
      newProperties: {
        general: [
          { name: 'opacity (%)', propID: 'opacity', type: 'int', section: 'effect', extraClass: 'col-3', tooltip: 'Sets the opacity level for the image. The opacity-level describes the transparency-level, where: <ul><li>0 is completely transparent.</li><li> 100 is default and represents the original image (no transparency).</li></ul>' },
          { name: 'blur (px)', propID: 'blur', type: 'int', section: 'effect', extraClass: 'col-3', tooltip: 'Applies a blur effect to the image. A larger value will create more blur.' },
          { name: 'grayscale (%)', propID: 'grayscale', type: 'int', section: 'effect', extraClass: 'col-3', tooltip: 'Converts the image to grayscale. <ul><li>0% is default and represents the original image. </li><li>100% will make the image completely gray (used for black and white images).</li></ul>' },
          { name: 'sepia (%)', propID: 'sepia', type: 'int', section: 'effect', extraClass: 'col-3', tooltip: '  Converts the image to sepia. <ul><li>0% is default and represents the original image. </li><li>100% will make the image completely sepia.</li></ul>' },
          { name: 'contrast (%)', propID: 'contrast', type: 'int', section: 'effect', extraClass: 'col-3', tooltip: 'Adjusts the contrast of the image. <ul><li>0% will make the image completely black. </li><li>100% is default and represents the original image. </li><li>Values over 100% will provide results with less contrast.</li></ul>' },
          { name: 'saturate (%)', propID: 'saturate', type: 'int', section: 'effect', extraClass: 'col-3', tooltip: 'Saturates the image. <ul><li>0% will make the image completely un-saturated. </li><li>100% is default and represents the original image. </li><li>Values over 100% provides super-saturated results.</li></ul>' },
          { name: 'src (only for preview)', propID: 'src', type: 'image', section: 'src (only for preview)', extraClass: 'hide-title' }
        ]
      },
      wireframe: function(obj) {
        return '<style>' + createBaseCSS(obj, 'image', obj.current_state) + createCSS(obj, obj.current_state, false) + '</style>'
          + "<img class='" + (Empty(obj.class_name) ? 'temp' : obj.class_name) + "' src='" + obj.src + "' />";
      }
    };
    this.extend(this.stdObjClass, this.imageObjClass);

    // Proprieta' disponibili per l'oggetto label
    this.labelObjClass = {
      newProperties: {
        general: [
          { name: 'value (only for preview)', propID: 'value', type: 'textarea', section: 'value (only for preview)', extraClass: 'hide-title' }
        ]
      },
      wireframe: function(obj) {
        return '<style>' + createBaseCSS(obj, 'label', obj.current_state) + createCSS(obj, obj.current_state, false) + '</style>'
          + "<div class='" + (Empty(obj.class_name) ? 'temp' : obj.class_name) + "'>" + obj.value + '</div>';
      }
    };
    this.extend(this.stdObjClass, this.labelObjClass);

    // Proprieta' disponibili per l'oggetto button
    this.buttonObjClass = {
      newProperties: {
        general: [
          { name: 'value (only for preview)', propID: 'value', type: 'textarea', section: 'value (only for preview)', extraClass: 'hide-title' }
        ]
      },
      wireframe: function(obj) {
        return '<style>' + createBaseCSS(obj, 'button', obj.current_state) + createCSS(obj, obj.current_state, false) + '</style>'
          + "<input type='button' class='" + (Empty(obj.class_name) ? 'temp' : obj.class_name) + "' value='" + obj.value + "' />";
      }
    };
    this.extend(this.stdObjClass, this.buttonObjClass);
    // Proprieta' disponibili per l'oggetto input
    this.textboxObjClass = {
      newProperties: {
        general: [
          { name: 'value (only for preview)', propID: 'value', type: 'textarea', section: 'value (only for preview)', extraClass: 'hide-title' }
        ],
        style: [],
        font: [
          { name: 'value (only for preview)', propID: 'ph_value', type: 'str', section: 'placeholder settings' },
          { name: 'font color', propID: 'ph_font_color', type: 'color', section: 'placeholder settings', extraClass: 'col-3' },
          { name: 'opacity', propID: 'ph_opacity', type: 'int', section: 'placeholder settings', extraClass: 'col-3' }
        ]
      },
      wireframe: function(obj) {
        return '<style>' + createBaseCSS(obj, 'textbox', obj.current_state) + createCSS(obj, obj.current_state, false) + '</style>'
          + "<input type='text' placeholder='" + (Empty(obj.ph_value) ? 'placeholder value' : obj.ph_value) + "' class='" + (Empty(obj.class_name) ? 'temp' : obj.class_name) + "' value='" + obj.value + "' />";
      }
    };
    this.extend(this.stdObjClass, this.textboxObjClass);


    // Funzioni per creare gli oggetti disponibili
    this.formObj = function() {
      this.objClass = ZTObjects.formObjClass;
      this.page = 1;
    };

    var commonPropObj = new function() {
      this.states = 'normal,hover,:before,:after';
      this.current_state = 'normal';
      this.specific_states_value = {};
      var arr_states = this.states.split(',');
      for (var i = 0; i < arr_states.length; i++) {
        this.specific_states_value[arr_states[i].toString()] = {};
      }
      this.font_list = ['',
        'Coustard', 'Antic Slab', 'Quattrocento',
        'Cinzel', 'Josefin Slab', 'Merriweather', 'Lora',
        'Nunito', 'Abel', 'Fjalla One', 'Dosis', 'Economica',
        'Raleway', 'Montserrat', 'Roboto Condensed', 'Oswald',
        'Special Elite', 'Fredoka One', 'Comfortaa', 'Bangers',
        'Righteous', 'Sigmar One', 'Patua One', 'Poiret One', 'Lobster',
        'Nova Mono', 'Inconsolata', 'Source Code Pro', 'Anonymous Pro', 'Roboto Mono',
        'Amatic SC', 'Shadows Into Light', 'Dancing Script', 'Pacifico', 'Indie Flower'
      ];
      this.common_properties = ['current_state', 'class_name', 'h', 'w', 'type', 'states', 'specific_states_value', 'common_properties', 'selector'];
    };

    this.stdObj = function(class_name, type, w, h) {
      merge(this, commonPropObj); // aggiungo le Proprieta' standard
      this.objClass = ZTObjects.stdObjClass;
      this.type = type;
      this.class_name = class_name;
      this.selector = !Empty(class_name) ? '.' + class_name : '';
      this.h = h;
      this.w = w;
    };

    this.boxObj = function(class_name, type, w, h) {
      merge(this, commonPropObj); // aggiungo le Proprieta' standard
      this.objClass = ZTObjects.boxObjClass;
      delete this.objClass.newProperties.font;
      this.type = type;
      this.class_name = class_name;
      this.selector = !Empty(class_name) ? '.' + class_name : '';
      this.h = h;
      this.w = w;
    };

    this.imageObj = function(class_name, type, w, h, src) {
      merge(this, commonPropObj); // aggiungo le Proprieta' standard
      this.objClass = ZTObjects.imageObjClass;
      delete this.objClass.newProperties.font;
      this.type = type;
      this.class_name = class_name;
      this.selector = !Empty(class_name) ? '.' + class_name : '';
      this.h = h;
      this.w = w;
      this.src = src;
      this.common_properties.push('src');
    };

    this.labelObj = function(class_name, type, w, h, value) {
      merge(this, commonPropObj); // aggiungo le Proprieta' standard
      this.objClass = ZTObjects.labelObjClass;
      this.type = type;
      this.class_name = class_name;
      this.selector = !Empty(class_name) ? '.' + class_name : '';
      this.value = value;
      this.h = h;
      this.w = w;
      this.class_Css = 'label';
      this.common_properties.push('value');
    };

    this.buttonObj = function(class_name, type, w, h, value) {
      merge(this, commonPropObj); // aggiungo le Proprieta' standard
      this.objClass = ZTObjects.buttonObjClass;
      this.type = type;
      this.class_name = class_name;
      this.selector = !Empty(class_name) ? '.' + class_name : '';
      this.value = value;
      this.h = h;
      this.w = w;
      this.class_Css = 'label';
      this.common_properties.push('value');
    };

    this.textboxObj = function(class_name, type, w, h, value) {
      merge(this, commonPropObj); // aggiungo le Proprieta' standard
      this.objClass = ZTObjects.textboxObjClass;
      this.type = type;
      this.class_name = class_name;
      this.selector = !Empty(class_name) ? '.' + class_name : '';
      this.value = value;
      this.h = h;
      this.w = w;
      this.class_Css = 'label';
      this.common_properties.push('value');
    };
  };
}


function createBaseCSS(obj, type, curr_state) {
  var baseState = ['normal', ':after', ':before'];
  var result = '',
    last_state = curr_state;

  for (var i = 0; i < baseState.length; i++) {
    if (baseState[i] != curr_state) {
      updateStates(last_state, baseState[i]);
      last_state = baseState[i];
      result += createCSS(obj, baseState[i], false);
    }
  }
  updateStates(last_state, curr_state); // ripristino il precedente stato salvato su curr_state
  return result;
}
