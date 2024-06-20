/* exported dragstartx dragstarty m_bUpdated lockItems def skin doLoad Help draggingHandler
    beginDragHandler addItem xxpos yypos moveVLine ItemEventInput unSelectItem
    editItemEvent EditManifest Copy saving savingpic save Paste loadNewObj loadNewObjDone
    alignItems bringToFront sendToBack bringForward sendBackward closeDialogs
    GetCurrentName GetResourceName GetRequestParams toggleMode
    EditTemplate updateHtmlCode has_saved
*/
/*
Funzioni sotto sono nel file PortalCommonJS.js:
- function dragToolbar(e,obj)
- function beginDragSelection(e)
- function noDefaultDrag(e)
- function findDragItems(e,y,x,w,h)
- function removeAllHandlers()
- function addHandlers(itmIdx)
- function selectItem(itm)
- function cancelEvent(e)
- function clickShadow(e)
- function moveItems()
- function CodeMirror()
*/

// Variabili portate da itemsObj.js
var dragstartx,
  dragstarty,
  newx,
  newy,
  mainitem,
  index, // indice corrente del mainitem  nell'Array
  nitem = 0, // numero item crescente
  itemsHTML = [], //array contenente tutti gli oggetti item  con id ,HTML,shadow,ecc
  countindex = 0, //contatore indice array
  m_bUpdated = false, //flag per avviso di salvare
  lockItems = false, //Blocca il move dei ctrls
  mode = "NORMAL",
  classCssObj = {},
  currentname = "", //nome del portlet corrente
  folder_path = '',
  def = "",
  WinOpener, // dialog windows handler
  standalone = false,
  skin,
  sequence_c = 0,
  changeselectshadow = false,
  m_nFrontendPort = null,
  toolbars = {},
  request_parms = {}, //Oggetto nome -> [{description, type, len, dec} | tipo ]
  raphael,
  visualMode = false,
  portalstudioFile = "",
  codeEditor = null,
  z_hm_style = localStorage.getItem('zucchetti_hm_style'),
  hm_style = !Empty(z_hm_style) ? JSON.parse(z_hm_style) : {
    fontSize: 12,
    theme: ""
  },
  grapes,
  variants = [],
  current_variant = 0,
  has_saved = false;



function resizeHTMLEditor() {
  // var editor = grapes.getContainer();
  // editor.style.width = editor.offsetWidth + 'px';
  // editor.style.height = editor.offsetHeight + 'px';
}

function updateHTMLEditor() {
  codeEditor.getWrapperElement().style.fontSize = hm_style.fontSize + 'px';
  codeEditor.setOption('theme', hm_style.theme );
}

function addVariant(name, obj, keepSelected) {

  if( variants.length ) {
    variants.loadVariantProp();
  }
  if( typeof name != "string"){
    name = "New"
  } else {
    name = name; //variants.getNameFromFolderPath(name, obj.folder_path);
  }

  let htmlcode = obj?.htmlcode ?? "" ;
  let ctrls = obj?.ctrls ?? [];
  let ac = obj?.actioncode ?? "";
  let js_libs = obj?.my_library ?? "";
  let css_libs = obj?.css ?? "";
  let css_code = obj?.css_code ?? "[]";
  let css_class = obj?.css_class ?? "";
  let folder_path = obj?.folder_path ?? "";

  let variant = {
    "name": name,
      "htmlcode": htmlcode,
         "ctrls": ctrls,
    "actioncode": ac,
       "js_libs": js_libs,
      "css_libs": css_libs,
      "css_code": JSON.parse(css_code),
     "css_class": css_class,
   "folder_path": folder_path
  }
  variants.push(variant);
  buildVariantSelect(keepSelected);
  jQuery("#variant_container").trigger("change");
  if( !keepSelected ){
    jQuery("#variant_container").trigger("select2:select");
  }
  return variant;
}

function buildVariantSelect(keepSelected){
  let variants_select = document.getElementById("variant_container");
  variants_select.innerHTML = "";
  variants.forEach( (v,i) => {
    let opt = new Option( v.name, i, false, !keepSelected);
    opt.setAttribute( "data-id", i );
    if( v.folder_path ) {
      let group_type = v.folder_path.startsWith("sites") ? "sites" :
        v.folder_path.startsWith("templates") ? "templates" : console.error("variant folder error");
      let group_name = v.folder_path.split("/")[1];
      let group = variants_select.querySelector('optgroup[data-folder="'+group_name+'"]');
      if( !group ) {
        group = document.createElement( 'optgroup' );
        group.setAttribute( "data-folder", group_name );
        group.setAttribute( "label", "[" + group_type.capitalize() + ": " + group_name + "]" );
        variants_select.appendChild( group );
      }
      group.appendChild( opt );
    } else {
      variants_select.appendChild( opt );
    }
    /*
    // let option = {
    //   id: i,
    //   text: v.name,
    //   selected: !keepSelected
    // };
    if( v.folder_path ) {
      if( v.folder_path.startsWith("sites") ){
        let site_name = v.folder_path.split("/")[1];
        let site = a.find( e => e.site == site_name )
        if( !site ){
          site = {
            text: "[Sites: "+site_name+"]",
            site: site_name,
            children: []
          }
          a.push( site );
        }
        site.children.push( o );
      }
      if ( v.folder_path.startsWith("templates") ){
        let template_name = v.folder_path.split("/")[1];
        let template = a.find( e => e.template == template_name )
        if( !template ){
          template = {
            text: "[Template: "+template_name+"]",
            template: template_name,
            children: []
          }
          a.push( template );
        }
        template.children.push( o );
      }
    } else {
      a.push( o )
    }
    return a;*/
  },[])
  jQuery("#variant_container").trigger("change");
}

function removeVariant() {
  if( current_variant > 0){
    // let container = document.getElementById("variant_container");
    let torem = variants[current_variant];
    if( confirm("Are you sure to remove variant "+torem.name+"?")) {
      variants.splice(current_variant,1);
      let current_opt = document.querySelector('#variant_container option[data-id="'+ current_variant +'"]');
      current_opt.parentElement.removeChild( current_opt );
      buildVariantSelect(true);
      let neext_variant = current_variant - 1 > 0 ? current_variant - 1 : 0;
      /**
       * To avoid setValue on variants
       */
      current_variant = -1;
      jQuery("#variant_container").val(neext_variant);
      jQuery("#variant_container").trigger("change");
      jQuery("#variant_container").trigger("select2:select");
      if( currentname != "" && torem.name != "New"){
        let deleteResponse = new JSURL("../servlet/JSPDelete?name=../"+torem.folder_path+"/jsp-variants/" + currentname + "/" +variants.getName(torem.name) +"_variant.jsp");
      deleteResponse = deleteResponse.Response();
      if(deleteResponse=="error") {
        alert("Error deleting file...");
      }
    }
    } else {

    }

  }
}

jQuery.fn.select2.amd.define('select2/data/customAdapter',[
  'select2/data/base',
  'select2/data/select',
  'select2/utils'
],
function (Base, SelectAdapter, Utils) {
  function CustomDataAdapter ($element, options) {
    CustomDataAdapter.__super__.constructor.call(this, $element, options);
  }
  Utils.Extend(CustomDataAdapter, SelectAdapter);
  // CustomDataAdapter.prototype.current = function (callback) {
    // callback();
  // };
  let originaFunction =  SelectAdapter.prototype.item.bind(new SelectAdapter());
  CustomDataAdapter.prototype.item = function($option) {
    let option = $option[0];
    if( option && option.tagName.toLowerCase() == 'option' ||
      option.tagName.toLowerCase() == 'optgroup' ) {
      Utils.RemoveData($option[0], 'data');
    }
    return originaFunction($option);
  }
  return CustomDataAdapter;
}
);

var createHTMLEditor = function () {

  const renderingOption = function (state) {
    if (!state.id) {
      return state.text;
    }
    let css_class = "";
    if( current_variant > 0 &&  parseInt(state.element.dataset.variant) == 0 ) {
      css_class += "ctrl-base"
    }
    let $state = jQuery(
      `<span class="${css_class}"> ${state.text }</span>`
    );
    $state.draggable({
      helper: (e) => {
        let span = document.createElement( "span")
        span.className = "select-draggable-helper";
        span.innerText = e.currentTarget.innerText;
        return span;
      }
    });
    return $state;
  };
  const sort = function( data ){
    data.filter( d => d.children ).forEach( d => d.children.sort( (a,b) => { return a.id.toLowerCase() > b.id.toLowerCase() ? 1 : -1 } ) )
    return data.sort((a,b) => {
      if( !a.children ) {
        return 1;
      } else {
        return a.text > b.text ? 1 : -1;
      }
      // return a.id.toLowerCase() > b.id.toLowerCase() ? 1 : -1;
    })
  }
  var customAdapter=jQuery.fn.select2.amd.require('select2/data/customAdapter');
  const hidden_ctrl_select = jQuery("#hidden_ctrl_combo").select2({
    allowClear: false,
    sorter: sort,
    templateResult: renderingOption,
    dataAdapter: customAdapter,
    width: "element",
    theme: 'bootstrap4'
  });
  const selectCtrl = function ( other, event ) {
    other.val("-").trigger('change')
    if( event.params.data.id == "-") {
      if (typeof (hideProperties) != 'undefined') {
        hideProperties('properties')
    }
      index=null;
    }
    var htmlitem = itemsHTML.find( x => x.name == event.params.data.id );
    if (htmlitem) {
      // setTimeout(function () { clickItem(null, htmlitem); }, 100)
      ListObj({ item : htmlitem })
    }
    /* Blur to enable delete action after combo select
    */
    document.activeElement.blur();
  }
  hidden_ctrl_select.on("select2:open", () => {SetOnEditProp(true)} )
  hidden_ctrl_select.on("select2:close", () => {SetOnEditProp(false)} )


  const visible_ctrl_select = jQuery("#visible_ctrl_combo").select2({
    sorter: sort,
    templateResult: renderingOption,
    dataAdapter: customAdapter,
    width: "element",
    theme: 'bootstrap4'
  });
  visible_ctrl_select.on("select2:open", () => {SetOnEditProp(true)} )
  visible_ctrl_select.on("select2:close", () => {SetOnEditProp(false)} )


  hidden_ctrl_select.on("select2:select", selectCtrl.bind( hidden_ctrl_select, visible_ctrl_select) );
  visible_ctrl_select.on("select2:select", selectCtrl.bind( visible_ctrl_select, hidden_ctrl_select) );

  let variant_select = jQuery("#variant_container").select2({
    allowClear: false,
    minimumResultsForSearch: Infinity,
    width: "element",
    theme: 'bootstrap4',
    dataAdapter: customAdapter
  });

  variant_select.on("select2:open", () => {SetOnEditProp(true)} )
  variant_select.on("select2:close", () => {SetOnEditProp(false)} )
  variant_select.on("select2:select", (e) => {
    last_index = null;
    let prev_variant = current_variant;
    /**
     * Save prev values
     */
    variants.saveVariantProp();
    /**
     * Change current variant
     */
    current_variant = parseInt(e.currentTarget.value);
    /**
     * Read current values
     */
    variants.loadVariantProp();
    /**
     * Filter form properties to remove prop that can't be change on variant mode
     */
    if( current_variant == 0 ){
      document.getElementById("remove_variant").style.display = "none";
      Object.entries( formProp.objClass.newProperties).forEach( tab => { tab[1].forEach ( prop => {
          if( prop.prev_disabled == false){
            delete prop.disabled;
          }
        })
      })
      FormProperties(true);
    } else {
      document.getElementById("remove_variant").style.display = "";
      if( prev_variant == 0 ){
        Object.entries( formProp.objClass.newProperties).forEach( tab => { tab[1].forEach ( prop => {
            if( !prop.propID.match( "^(my_library|css|css_class)$" ) ) {
              if( !prop.disabled ){
                prop.prev_disabled = false;
              }
              prop.disabled = 'true';
            }
          })
        })
        FormProperties(true);
      }
    }
    /**
     * Set items properties readonly if ctrl is'n of this variant
     */
    itemsHTML.forEach( i => {
      if( i.ctrlOfVariant != current_variant && current_variant > 0 && !i.ctrlOfVariant ){
        i.ps_variant_not_editable = true;
      } else {
        i.ps_variant_not_editable = false;
      }
    });
    Properties(true);
  })

  document.getElementById("add_variant").addEventListener("click", () => {
    if( variants.length == 1 && currentname == "" ){
      if( confirm( "Base portlet must be save before add variant. Save portlet?") ){
        save(addVariant);
      }
    } else {
      addVariant();
    }
  });

  document.getElementById("addcopy_variant").addEventListener("click", () => {
    if( variants.length == 1 && currentname == "" ){
      if( confirm( "Base portlet must be save before add variant. Save portlet?") ){
        save(addVariant.bind( null, null, {htmlcode: variants[0].htmlcode} ));
      }
    } else {
      addVariant( null, {htmlcode: variants[0].htmlcode} );
    }
  });
  document.getElementById("remove_variant").addEventListener("click", removeVariant);

  var editor = document.getElementById('htmleditor');
  var i_logicview_wrapper = document.getElementById('i_logicview_wrapper');
  window.addEventListener('gadget-pane-open', (e) => {
    editor.style.left = editor.offsetLeft + e.detail.size + 'px';
    i_logicview_wrapper.style.left = i_logicview_wrapper.offsetLeft + e.detail.size +'px';
    resizeHTMLEditor();
  });
  window.addEventListener('gadget-pane-close', (e) => {
    editor.style.left = editor.offsetLeft - e.detail.size +'px';
    i_logicview_wrapper.style.left = i_logicview_wrapper.offsetLeft - e.detail.size +'px';
    resizeHTMLEditor();
  });

  document.getElementById('toolbar_style').addEventListener('click',function(){
    [].forEach.call(document.querySelectorAll(".visible:not(#opt_pane)"), (other) => { other.classList.remove('visible'); });
    LibJavascript.CssClassNameUtils.toggleClass(document.getElementById('opt_pane'), 'visible');
  });
  document.getElementById('toolbar_help').addEventListener('click',function(){
    [].forEach.call(document.querySelectorAll(".visible:not(#helpkeys_content)"), (other) => { other.classList.remove('visible'); });
    LibJavascript.CssClassNameUtils.toggleClass(document.getElementById('helpkeys_content'), 'visible');
  });
  document.getElementById('toolbar_search').addEventListener('click',function() {
    SetOnEditProp(true);
    codeEditor.execCommand('find');
  });

  var codeMirrorOpt = {};

  codeMirrorOpt.extraKeys = {
    "Ctrl-R": "replace",
    "F3": "findNext",
    "Shift-F3": "findPrev",
    "Ctrl-Q": "toggleComment",
    "F2": function (cm) {
      var pos = cm.getCursor(),
        found = -1,
        i, info ;
      for (i = pos.line + 1; found == -1 && i < cm.lineCount(); i++) { //righe successive
        info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints) {
          found = i;
        }
      }

      for (i = 0; found == -1 && i < pos.line; i++) { //righe precedenti
        info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints) {
          found = i;
        }
      }
      if (found > -1) {
        cm.setCursor({
          line: found,
          ch: 0
        });
      }
    },
    "Shift-F2": function (cm) {
      var pos = cm.getCursor(),
        found = -1,
        i,info;
      for (i = pos.line - 1; found == -1 && i >= 0; i--) { //righe precedenti inverse
        info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints) {
          found = i;
        }
      }
      for (i = cm.lineCount() - 1; found == -1 && i > pos.line; i--) { //righe successive inverse
        info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints) {
          found = i;
        }
      }
      if (found > -1) {
        cm.setCursor({
          line: found,
          ch: 0
        });
      }
    },
    "Ctrl-F2": function (cm) {
      var pos = cm.getCursor(),
        info = cm.lineInfo(pos.line),
        hadBP = info.gutterMarkers && info.gutterMarkers.breakpoints;
      if (hadBP) {
        delete status.breakpoints[pos.line];
      } else {
        status.breakpoints[pos.line] = true;
      }
      cm.setGutterMarker(pos.line, "breakpoints", hadBP ? null : makeMarker());
    }
//     "Delete": manageDelete,
//     "Backspace": manageDelete
  }

  function manageDelete( cm ){
    const regex = /@([A-Za-z_]\w*)/g;
    let selected = cm.getSelection();
    let action = event.key;
    //pos = cm.getCursor();
    let m;
    if( false && selected && (regex.test(selected)) ){
      while ((m = regex.exec(selected)) !== null) {
        if (m.index === regex.lastIndex) {
          regex.lastIndex++;
        }
        let ctrl = m[1];
        if( true || confirm( "Would you remove "+ctrl+ "?" )){
          var htmlitem = document.querySelector("[data-ps-name=" + ctrl + "]")
          if (htmlitem) {
            ListObj({"value": htmlitem.id.substr(4)});
            deleteItem();
          }
          if( action == "Delete") {
            CodeMirror.commands.delWordAfter(codeEditor);
          } else if(action == "Backspace") {
            CodeMirror.commands.delWordBefore(codeEditor);
          }
        } else {

        }
      }
    } else {
      if (selected) {
        if( action == "Delete") {
          CodeMirror.commands.delWordAfter(codeEditor);
        } else if(action == "Backspace") {
          CodeMirror.commands.delWordBefore(codeEditor);
        }
      } else {
        if( action == "Delete") {
          CodeMirror.commands.delCharAfter(codeEditor);
        } else if(action == "Backspace") {
          CodeMirror.commands.delCharBefore(codeEditor);
        }
      }
    }
  }
  manageDelete;

  codeMirrorOpt.theme = hm_style && hm_style.theme ? hm_style.theme : 'default';
  codeMirrorOpt.tabSize = 2;
  codeMirrorOpt.indentUnit = 2;
  codeMirrorOpt.statementIndent = 2;
  codeMirrorOpt.lineNumbers = true;
  codeMirrorOpt.styleActiveLine = true;
  // codeMirrorOpt.highlightSelectionMatches = {showToken: /\{\{\s*(\w+)\s*\}\}/mg, annotateScrollbar: true};
  codeMirrorOpt.matchBrackets = true;

  codeMirrorOpt.showCursorWhenSelecting = true;
  codeMirrorOpt.flattenSpans = false;
  codeMirrorOpt.inputStyle = "contenteditable";
  codeMirrorOpt.selectionPointer = true;
  codeMirrorOpt.autoRefresh = true;

  codeMirrorOpt.gutters = ["CodeMirror-linenumbers", "breakpoints", "CodeMirror-foldgutter"];
  codeMirrorOpt.foldGutter = true;
  codeMirrorOpt.mode = {name: "htmlmode", base: "text/html"};
  // codeMirrorOpt.mode = {name: "htmlmode", base: "htmlmixed"};
  codeMirrorOpt.value = "";
  codeMirrorOpt.styleSelectedText = true;
  codeMirrorOpt.configureMouse = function (doc, repeat, event) {
    doc;repeat;event;
    return {};
  }

  document.getElementById('theme').addEventListener('change', function () {
    var theme = this.value;
    codeEditor.setOption('theme', theme);
    hm_style.theme = theme;
    localStorage.setItem('zucchetti_hm_style', JSON.stringify(hm_style));
  });

  document.getElementById('fontSlider').value = hm_style.fontSize;

  document.getElementById('fontSlider').addEventListener('change', function() {
    hm_style.fontSize = this.value;
    localStorage.setItem('zucchetti_hm_style', JSON.stringify(hm_style));
    codeEditor.getWrapperElement().style.fontSize = this.value + 'px';
  })


  createCodeArea();



  // setTimeout(function () {
  //   codeEditor.getScrollerElement().style.height = document.getElementById('editor').offsetHeight + 'px';
  // }, 300);
  // codeEditor.getInputField().addEventListener('focus', function () {
  //   SetOnEditProp(true);
  // });
  // codeEditor.getInputField().addEventListener('blur', function () {
  //   SetOnEditProp(true);
  // });
  // codeEditor.focus();

  // CodeMirror.extendMode("html", {
  //   lineComment: "//"
  // });

  // CodeMirror.registerHelper("hint", "javascript", helper);
  CodeMirror.registerHelper("hint", "htmlmode", helper);

  function createCodeArea() {

    codeEditor = CodeMirror(document.getElementById('editor'), codeMirrorOpt);

    codeEditor.on("focus", () => SetOnEditProp(true) );
    codeEditor.on("blur", () => SetOnEditProp(false) );

    codeEditor.on("fold", function (from) {
      status.folded[from.line] = true;
    });
    codeEditor.on("unfold", function (from) {
      delete status.folded[from.line];
    });
    codeEditor.on("change", function (cm, changeObj) {
      if (changeObj.origin == "setValue" || originalList != null) return; //se autocompletamento gia' in funzione non faccio nulla
      var txt;
      if (changeObj.origin == '+delete') {
        var tk = cm.getTokenAt(changeObj.from);
        txt = Right(tk.string, 1)
      } else {
        txt = changeObj.text[0];
      }
      if ([".", "_", " "].indexOf(Right(txt, 1)) > -1 || cm.getTokenAt(changeObj.to).type == "open-bracket" ) {
        cm.execCommand('autocomplete');
      }
    });
    codeEditor.on("search-focus", () => { SetOnEditProp(true)})
    codeEditor.on("beforeChange", function(cm, changeObj){
      const regex = /{{\s*@([A-Za-z_]\w*)\s*/g;
      let selected = [];
      let marks = cm.getAllMarks();
      if( cm.somethingSelected() ){
       selected = cm.getSelection();
      } else if( marks.length ) {
        selected = marks.map( m => {
          let f = m.find();
          return cm.getRange(f.from, f.to);
        })
      }
      let action = changeObj.origin;
      //pos = cm.getCursor();
      let m;
      let ctrls = [];
      if( action == '+delete' && selected ){
        /**
         * Stop keyboard delete propagation
         */
        event.stopPropagation();
        while ((m = regex.exec(selected)) !== null) {
          if (m.index === regex.lastIndex) {
            regex.lastIndex++;
          }
          ctrls.push(m[1]);
        }
        if( ctrls.length > 0){
          ctrls.map ( (c, i) => {
            let s = c +" ";
            ctrls[i]  = itemsHTML.find( i => i.name == c) ;
            if ( current_variant == ctrls[i].ctrlOfVariant ){
              s += "(variant's ctrl)"
            } else {
              s += "(base's ctrl)"
            }
            return s;
          });
          if( confirm( "Would you remove "+ctrls.map( c => c.name ).join( ", ")+ "?" )){
            ctrls.forEach( (c) => {
              // select ctrl to delete like current ctrl before delete it
              ListObj({ "item": c });
              deleteItem();
            })
          } else {
            changeObj.cancel();
          }
        }
      }
    });
    codeEditor.on("pick", function(){});
    codeEditor.on("endCompletion", function () {
      originalList = null;
    });
    codeEditor.on("cursorActivity", function (cm) {
      if(  mode != "HTML" ) return;
      let cursor = cm.getCursor();
      // let selection = cm.getSelection();
      //console.log( [JSON.stringify(cursor), selection] );
      let token = cm.getTokenAt(cursor);
      if( token.type == "ctrl" ) {
        let ctrl = getCtrlHTML(token.string);
        var htmlitem = itemsHTML.find( e => e.name == ctrl );
        if ( htmlitem && event && !event.shiftKey) {
          /* selectItem */
          let ctrl_index = htmlitem.id.substr(4);
          if( index == ctrl_index && event && event.key && event.key.match("Arrow(Right|Down|Left|Up)") ){
          // if( index == ctrl_index && event && event.key && event.key.match("Arrow(Right|Down)") ){
            // if( event.key == 'ArrowRight' ){
            // CodeMirror.commands.goCharRight(cm)
            // } else if( event.key == 'ArrowDown' ){
            //   CodeMirror.commands.goCharDown(cm)
            // }
          } else {
            ListObj({"value": ctrl_index });
            let ctrl_combo = document.querySelector(`#visible_ctrl_combo option[value=${htmlitem.name}]`);
            if( ctrl_combo ){
              ctrl_combo.selected = true;
              jQuery('#visible_ctrl_combo').trigger('change');
            }
          }
        }

      } else {
        if (typeof (hideProperties) != 'undefined') {
          hideProperties('properties')
        }
        index=null;
        document.querySelector('#visible_ctrl_combo option:first-child').selected = true;
        jQuery('#visible_ctrl_combo').trigger('change');
      }
      /* reset ctrl selected */
      document.querySelector('#hidden_ctrl_combo option:first-child').selected = true;
      jQuery('#hidden_ctrl_combo').trigger('change');
    })

    codeEditor.getWrapperElement().id = 'htmlcode';
    codeEditor.getWrapperElement().style.fontSize = hm_style.fontSize;

    codeEditor.getWrapperElement().value = codeEditor.getValue();

    /* Breakpoints */
    codeEditor.on("gutterClick", function (cm, n, type) {
      var info;
      if (type == "breakpoints") {
        info = cm.lineInfo(n);
        var hadBP = info.gutterMarkers && info.gutterMarkers.breakpoints;
        if (hadBP) {
          delete status.breakpoints[n];
        } else {
          status.breakpoints[n] = true;
        }
        cm.setGutterMarker(n, "breakpoints", hadBP ? null : makeMarker());
      } else if (type == "CodeMirror-linenumbers") {
        info = cm.lineInfo(n);
        cm.setSelection({
          line: n,
          ch: 0
        }, {
            line: n,
            ch: info.text.length
          });
      }
    });

    for (var i in status.breakpoints) {
      codeEditor.setGutterMarker(parseInt(i), "breakpoints", makeMarker());
    }
    for (i in status.folded) {
      codeEditor.foldCode(CodeMirror.Pos(parseInt(i), 0));
    }
    codeEditor.refresh();
    /* Gestione del drop da toolbar */
    codeEditor.on("drop", function ( editor, event) {
      let data = event.dataTransfer.getData('Text');
      if( JSON.validate(data) ) {
        event.preventDefault();
        var action = JSON.parse(data);
        putItem(event, null, null, {
          type: action.par
        });
      }
    });
    jQuery("#editor").droppable({
      drop: function( event, ui ) {
        let name = ui.helper.text().trim();
        let index = itemsHTML.findIndex( i => i.name == name );
        if( index > -1 ) {
          let item = itemsHTML[index];
          let str = "{{ " + ( !item.hidden ? "@" : "" ) + name + " }} ";

          var cursorPos
          cursorPos = codeEditor.coordsChar({
            top: event.clientY,
            left: event.clientX
          })
          str += " \n";

          codeEditor.replaceRange(str, cursorPos);
          // codeEditor.setCursor({ line: cursorPos.line, ch: cursorPos.ch + 5, sticky: 'after' });
          codeEditor.setCursor(cursorPos);
          // }
        }
      }
    });
  }

  function itemHints() {
    var list = [];
    list = itemsHTML.map( e => (e.hidden ? " " : " @") + e.name + " " );
    list.concat(  itemsHTML.map( e => ""+e.name+"") );
    list.sort(function (a, b) {
      return a.toLowerCase() > b.toLowerCase() ? 1 : -1;
    });
    list.push(" #if ")
    list.push(" #else ")
    list.push(" #endif ")
    list.push(" #each ")
    list.push(" #endeach ")
    return list;
  }


  var originalList = null;
  var initiator = null;

  function helper(editor, options) {
    /*se l'helper ritorna un array con un elemento non lo seleziona in automatico ma lascia la possibilita' all'utente di scegliere se selezionare il valore*/
    options.completeSingle = false;
    var cur = editor.getCursor(),
      //curLine = editor.getLine(cur.line),
      prevCur = {
        line: cur.line,
        ch: cur.ch - 1
      };
    var start = cur.ch,
      end = start;
    var currentToken = editor.getTokenAt(cur);
    var prevToken = editor.getTokenAt(prevCur);
    var list = [];
    if (originalList != null) {
      start = currentToken.start;
      var offset, token;
      if (initiator == '_') {
        offset = currentToken.string.lastIndexOf('_') + 1;
        token = currentToken.string.substr(offset);
        start += offset;
      } else {
        offset = 0;
        token = currentToken.string;
      }
      list = originalList.filter(function (el) {
        return el.displayText.lastIndexOf(token, 0) == 0
      });
    } else if (currentToken.string == '.') {

      if (prevToken.type == 'property' && itemNames().indexOf(prevToken.string) > -1) {
        list = itemHints(prevToken.string);
      }
      originalList = list;
      initiator = '.';
    } else if (Right(currentToken.string, 1) == '_') {
      var item = Substr(prevToken.string, 1, Len(prevToken.string) - 1);
      prevToken = editor.getTokenAt(CodeMirror.Pos(cur.line, prevToken.start));
      if (prevToken.string == ' ') {
        prevToken = editor.getTokenAt(CodeMirror.Pos(cur.line, prevToken.start));
        if (prevToken.string == 'function') {
          if (itemNames().indexOf(item) > -1 || item == 'this') {
            list = itemEvents(item);
          }
        }
      }
      originalList = list;
      initiator = '_';
    } else if (currentToken.string == ' ') {
      if (prevToken.string == 'function') { //propongo tutti gli item
        list = itemHints("_");
        list.unshift({
          text: 'this_',
          displayText: 'this'
        });
      }
      originalList = list;
      initiator = ' ';
    } else if (currentToken.type == "open bracket") {
      list = itemHints();
    }
    return {
      list: list,
      from: CodeMirror.Pos(cur.line, start),
      to: CodeMirror.Pos(cur.line, end)
    };
  }

  helper;

  function makeMarker() {
    var marker = document.createElement("img");
    marker.src = "../portalstudio/images/icon/bookmark.png";
    return marker;
  }
}

/* HTMLMode End */

var images = [];



function myPlugin(editor){

  ZTObjects.PSToolbarCtrl.concat(ZTObjects.PSToolbarViewsCtrl).forEach( function(el) {
    editor.DomComponents.addType(el.action.par, {
      // Make the editor understand when to bind `my-input-type`
      isComponent: (el) => {
        if( el && el.tagName ){
          el.tagName === el.title.toUpperCase();
        } else {
          false;
        }
        // const regex = /\{\{\s*(\w+)\s*\}\}/mg;
        // return el.match(regex);
      },

      // Model definition
      model: {
        // Default properties
        defaults: {
          tagName: "psctrl",
          // draggable: 'form, form *', // Can be dropped only inside `form` elements
          droppable: false, // Can't drop other elements inside
          attributes: {
            // Default attributes
            //   type: 'text',
            //   name: 'default-name',
            type: el.title,
          }
        },
      },
      view: {
        // Be default, the tag of the element is the same of the model
        tagName: "span",
      },
    });

    editor.BlockManager.add( el.title, {
      label: el.title,
      image: el.image,
      content: {
        type: el.action.par , // Built-in 'map' component
        style: {
          height: "50px",
        },
        attributes: {
          type: el.title,
        },
        content: el.title,
        removable: false, // Once inserted it can't be removed
      },
      category: "Ctrls",
      render: ({ model /* , className */ }) => `<div >
          <img src="${model.get("image")}" />
          <div class="gjs-block-label">${model.get("label")}</div>
        </div>`
    });
  });

  ZTObjects.PSToolbarDataCtrl.forEach( function(el){
    editor.BlockManager.add( el.action.par, {
      label: el.title,
      image: el.image,
      content: {
        draggable: false,
        droppable: false,
        type: el.id , // Built-in 'map' component
        style: {
          height: "50px",
        },
        attributes: {
          type: el.title,
        },
        content: el.title,
        removable: false, // Once inserted it can't be removed
      },
      category: "Datas",
      render: ({ model /* , className */ }) => `<div >
          <img src="${model.get("image")}" />
          <div class="gjs-block-label">${model.get("label")}</div>
        </div>`
    });
  });
}



/**
 * Per evitare eslint
 */
myPlugin;

var grapes_options = {
  noticeOnUnload: false,
  avoidInlineStyle: 1,
  height: "",
  width: "",
  container: "#gjs",
  fromElement: 0,
  showOffsets: 1,
  cssIcons : '../styles/font-awesome.min.css',
  assetManager: {
    embedAsBase64: 1,
    assets: images,
  },
  selectorManager: { componentFirst: true },
  styleManager: { clearProperties: 1 },
  plugins: [
    // "grapesjs-lory-slider",
    "grapesjs-tabs",
    // "grapesjs-custom-code",
    // "grapesjs-touch",
    // "grapesjs-parser-postcss",
    // "grapesjs-tooltip",
    // "grapesjs-tui-image-editor",
    // "grapesjs-typed",
    // "grapesjs-style-bg",
    "gjs-preset-webpage",
    "myPlugin"
  ],
  pluginsOpts: {
    "grapesjs-lory-slider": {
      sliderBlock: {
        category: "Extra",
      },
    },
    "grapesjs-tabs": {
      tabsBlock: {
        category: "Extra",
      },
    },
    "grapesjs-typed": {
      block: {
        category: "Extra",
        content: {
          type: "typed",
          "type-speed": 40,
          strings: ["Text row one", "Text row two", "Text row three"],
        },
      },
    },
    "gjs-preset-webpage": {
      modalImportTitle: "Import Template",
      modalImportLabel:
        '<div style="margin-bottom: 10px; font-size: 13px;">Paste here your HTML/CSS and click Import</div>',
      modalImportContent: function (editor) {
        return editor.getHtml() + "<style>" + editor.getCss() + "</style>";
      },
      // filestackOpts: null, //{ key: 'AYmqZc2e8RLGLE7TGkX3Hz' },
      aviaryOpts: false,
      navbarOpts: false,
      formsOpts: false,
      exportOpts: false,
      aviaryOpts: false,
      filestackOpts: false,
      countdownOpts: false,
      blocks: [],
      blocksBasicOpts: {
        flexGrid: 1,
        blocks: ['column1', 'column2', 'column3', 'column3-7'] // ['column1', 'column2', 'column3', 'column3-7', 'text', 'link', 'image', 'video', 'map']
      },
      customStyleManager: [
        {
          name: "General",
          buildProps: [
            "float",
            "display",
            "position",
            "top",
            "right",
            "left",
            "bottom",
          ],
          properties: [
            {
              name: "Alignment",
              property: "float",
              type: "radio",
              defaults: "none",
              list: [
                { value: "none", className: "fa fa-times" },
                { value: "left", className: "fa fa-align-left" },
                { value: "right", className: "fa fa-align-right" },
              ],
            },
            { property: "position", type: "select" },
          ],
        },
        {
          name: "Dimension",
          open: false,
          buildProps: [
            "width",
            "flex-width",
            "height",
            "max-width",
            "min-height",
            "margin",
            "padding",
          ],
          properties: [
            {
              id: "flex-width",
              type: "integer",
              name: "Width",
              units: ["px", "%"],
              property: "flex-basis",
              toRequire: 1,
            },
            {
              property: "margin",
              properties: [
                { name: "Top", property: "margin-top" },
                { name: "Right", property: "margin-right" },
                { name: "Bottom", property: "margin-bottom" },
                { name: "Left", property: "margin-left" },
              ],
            },
            {
              property: "padding",
              properties: [
                { name: "Top", property: "padding-top" },
                { name: "Right", property: "padding-right" },
                { name: "Bottom", property: "padding-bottom" },
                { name: "Left", property: "padding-left" },
              ],
            },
          ],
        },
        {
          name: "Typography",
          open: false,
          buildProps: [
            "font-family",
            "font-size",
            "font-weight",
            "letter-spacing",
            "color",
            "line-height",
            "text-align",
            "text-decoration",
            "text-shadow",
          ],
          properties: [
            { name: "Font", property: "font-family" },
            { name: "Weight", property: "font-weight" },
            { name: "Font color", property: "color" },
            {
              property: "text-align",
              type: "radio",
              defaults: "left",
              list: [
                { value: "left", name: "Left", className: "fa fa-align-left" },
                {
                  value: "center",
                  name: "Center",
                  className: "fa fa-align-center",
                },
                {
                  value: "right",
                  name: "Right",
                  className: "fa fa-align-right",
                },
                {
                  value: "justify",
                  name: "Justify",
                  className: "fa fa-align-justify",
                },
              ],
            },
            {
              property: "text-decoration",
              type: "radio",
              defaults: "none",
              list: [
                { value: "none", name: "None", className: "fa fa-times" },
                {
                  value: "underline",
                  name: "underline",
                  className: "fa fa-underline",
                },
                {
                  value: "line-through",
                  name: "Line-through",
                  className: "fa fa-strikethrough",
                },
              ],
            },
            {
              property: "text-shadow",
              properties: [
                { name: "X position", property: "text-shadow-h" },
                { name: "Y position", property: "text-shadow-v" },
                { name: "Blur", property: "text-shadow-blur" },
                { name: "Color", property: "text-shadow-color" },
              ],
            },
          ],
        },
        {
          name: "Decorations",
          open: false,
          buildProps: [
            "opacity",
            "border-radius",
            "border",
            "box-shadow",
            "background-bg",
          ],
          properties: [
            {
              type: "slider",
              property: "opacity",
              defaults: 1,
              step: 0.01,
              max: 1,
              min: 0,
            },
            {
              property: "border-radius",
              properties: [
                { name: "Top", property: "border-top-left-radius" },
                { name: "Right", property: "border-top-right-radius" },
                { name: "Bottom", property: "border-bottom-left-radius" },
                { name: "Left", property: "border-bottom-right-radius" },
              ],
            },
            {
              property: "box-shadow",
              properties: [
                { name: "X position", property: "box-shadow-h" },
                { name: "Y position", property: "box-shadow-v" },
                { name: "Blur", property: "box-shadow-blur" },
                { name: "Spread", property: "box-shadow-spread" },
                { name: "Color", property: "box-shadow-color" },
                { name: "Shadow type", property: "box-shadow-type" },
              ],
            },
            {
              id: "background-bg",
              property: "background",
              type: "bg",
            },
          ],
        },
        {
          name: "Extra",
          open: false,
          buildProps: ["transition", "perspective", "transform"],
          properties: [
            {
              property: "transition",
              properties: [
                { name: "Property", property: "transition-property" },
                { name: "Duration", property: "transition-duration" },
                { name: "Easing", property: "transition-timing-function" },
              ],
            },
            {
              property: "transform",
              properties: [
                { name: "Rotate X", property: "transform-rotate-x" },
                { name: "Rotate Y", property: "transform-rotate-y" },
                { name: "Rotate Z", property: "transform-rotate-z" },
                { name: "Scale X", property: "transform-scale-x" },
                { name: "Scale Y", property: "transform-scale-y" },
                { name: "Scale Z", property: "transform-scale-z" },
              ],
            },
          ],
        },
        {
          name: "Flex",
          open: false,
          properties: [
            {
              name: "Flex Container",
              property: "display",
              type: "select",
              defaults: "block",
              list: [
                { value: "block", name: "Disable" },
                { value: "flex", name: "Enable" },
              ],
            },
            {
              name: "Flex Parent",
              property: "label-parent-flex",
              type: "integer",
            },
            {
              name: "Direction",
              property: "flex-direction",
              type: "radio",
              defaults: "row",
              list: [
                {
                  value: "row",
                  name: "Row",
                  className: "icons-flex icon-dir-row",
                  title: "Row",
                },
                {
                  value: "row-reverse",
                  name: "Row reverse",
                  className: "icons-flex icon-dir-row-rev",
                  title: "Row reverse",
                },
                {
                  value: "column",
                  name: "Column",
                  title: "Column",
                  className: "icons-flex icon-dir-col",
                },
                {
                  value: "column-reverse",
                  name: "Column reverse",
                  title: "Column reverse",
                  className: "icons-flex icon-dir-col-rev",
                },
              ],
            },
            {
              name: "Justify",
              property: "justify-content",
              type: "radio",
              defaults: "flex-start",
              list: [
                {
                  value: "flex-start",
                  className: "icons-flex icon-just-start",
                  title: "Start",
                },
                {
                  value: "flex-end",
                  title: "End",
                  className: "icons-flex icon-just-end",
                },
                {
                  value: "space-between",
                  title: "Space between",
                  className: "icons-flex icon-just-sp-bet",
                },
                {
                  value: "space-around",
                  title: "Space around",
                  className: "icons-flex icon-just-sp-ar",
                },
                {
                  value: "center",
                  title: "Center",
                  className: "icons-flex icon-just-sp-cent",
                },
              ],
            },
            {
              name: "Align",
              property: "align-items",
              type: "radio",
              defaults: "center",
              list: [
                {
                  value: "flex-start",
                  title: "Start",
                  className: "icons-flex icon-al-start",
                },
                {
                  value: "flex-end",
                  title: "End",
                  className: "icons-flex icon-al-end",
                },
                {
                  value: "stretch",
                  title: "Stretch",
                  className: "icons-flex icon-al-str",
                },
                {
                  value: "center",
                  title: "Center",
                  className: "icons-flex icon-al-center",
                },
              ],
            },
            {
              name: "Flex Children",
              property: "label-parent-flex",
              type: "integer",
            },
            {
              name: "Order",
              property: "order",
              type: "integer",
              defaults: 0,
              min: 0,
            },
            {
              name: "Flex",
              property: "flex",
              type: "composite",
              properties: [
                {
                  name: "Grow",
                  property: "flex-grow",
                  type: "integer",
                  defaults: 0,
                  min: 0,
                },
                {
                  name: "Shrink",
                  property: "flex-shrink",
                  type: "integer",
                  defaults: 0,
                  min: 0,
                },
                {
                  name: "Basis",
                  property: "flex-basis",
                  type: "integer",
                  units: ["px", "%", ""],
                  unit: "",
                  defaults: "auto",
                },
              ],
            },
            {
              name: "Align",
              property: "align-self",
              type: "radio",
              defaults: "auto",
              list: [
                {
                  value: "auto",
                  name: "Auto",
                },
                {
                  value: "flex-start",
                  title: "Start",
                  className: "icons-flex icon-al-start",
                },
                {
                  value: "flex-end",
                  title: "End",
                  className: "icons-flex icon-al-end",
                },
                {
                  value: "stretch",
                  title: "Stretch",
                  className: "icons-flex icon-al-str",
                },
                {
                  value: "center",
                  title: "Center",
                  className: "icons-flex icon-al-center",
                },
              ],
            },
          ],
        },
      ],
    },
  },
  storageManager: {
    autoload: false,
    autosave: false
  }
};

function doLoad(e, id, skinName, frontendport, variant, createAltInterfaceFor, initDim) {
  // var logTime = 0;
  // console.log( logTime );
  // logTime=new Date().getTime();

  CreateGraperJS( () => {

  initPainter();
  tool = 'portlet';
  AppletTag("Batch");
  if(initDim){
    this.formProp.pagesProp = [{ ...initDim, 'title':'', 'layer':'','layout_steps_values':{} }];
  }

  skin = skinName;
  canAlign = true;
  BatchApplet().documentloc = Strtran(location.toString(), "visualweb/editor.jsp", "servlet/dummy")
  document.body.style.cursor = "default"
  document.body.onhelp = CancelHelp

  createHTMLEditor();

  if (!Empty(id)) {
    currentname = id
    reload()

    if (standalone) document.title = currentname + " - Portlet Editor";
    old_name = currentname;
  }
  CreateToolbar();

  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }

  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }

  var tbl = document.getElementById('toolbar');
  ZtVWeb.theme = 'portalstudio';

  window.addEventListener('resize', function () {
      if (timerResize) {
        clearTimeout(timerResize);
      }
      timerResize = resizeWindow.delay(100);
  });
  var timerResize = null;
  var resizeWindow = function () {
    // document.getElementById('toolbar').setStyle('width',window.getSize().x-document.getElementById('gadgets_pane').getSize().x-document.getElementById('gadgets_panerightbar').getSize().x);
    document.getElementById('toolbar').setStyle('width', document.body.getSize().x - document.getElementById('toolbar').offsetLeft)
    tbl.fireEvent('SPToolbarRefresh');
    resizeHTMLEditor();
  }
  resizeWindow();
  /* Rulers */
  var workunit = "pt"; //unita'
  var dheight = document.getElementById('backcanvas').offsetHeight; //lunghezza del div che contiene il righello
  var dwidth = document.getElementById('backcanvas').offsetWidth; //lunghezza del div che contiene il righello
  clVRRulersLib = new RulersLib() //.Init("v_ruler",workunit); // div-canvas del righello
  clHRRulersLib = new RulersLib() //.Init("h_ruler",workunit); // div-canvas del righello
  clVRRulersLib.Init("v_ruler", workunit);
  clHRRulersLib.Init("h_ruler", workunit);
  clVRRulersLib.SetScale(100); //eventuale zoom
  clHRRulersLib.SetScale(100); //eventuale zoom
  clHRRulersLib.DrawHorizontal(dwidth);
  clVRRulersLib.DrawVertical(dheight);
  /* End Rulers*/
  // step di formProp
  document.getElementById('v_line').style.height = document.getElementById('canvas').offsetHeight - document.getElementById('h_ruler').offsetTop + 'px';
  try {
    parent.setTitle(this)
  } catch (e) { }
  FormProperties();
  create_gadget_pane();

  b_reload = false;
  classCssObj = JSON.parse(formProp["css_code"]);
  for (var i = 0; i < document.styleSheets.length; i++) { // cerco il file css di portalstudio
    if (document.styleSheets[i].href && document.styleSheets[i].href.search("/portalstudio.css") > -1)
      portalstudioFile = document.styleSheets[i];
  }
  if (portalstudioFile) portalstudioFile.disabled = true; // se trovato lo disabilito
  writeHTML();
  //Form Handler draggable
  var fnToDelay = function () {
    document.getElementById('dragcontent').setStyle('opacity', '0.3');
    document.getElementById('dragcontent').set('tween', {
      duration: 500,
      link: 'cancel'
    });
    document.getElementById('drag').set('tween', {
      duration: 500,
      link: 'cancel'
    });
    var delta_v_line = 0;
    document.getElementById('backcanvas').makeResizable({
      handle: document.getElementById('handler'),
      limit: {
        y: [0],
        x: [0]
      },
      onStart: function () {
        document.getElementById('backcanvas').style.transition = '';
        document.getElementById('backcanvasBorder').style.transition = '';
        document.getElementById('v_line').style.transition = '';
        delta_v_line = (!Empty(formProp.v_line) ? formProp.v_line - document.getElementById('backcanvas').getSize().x : 0);
      },
      onDrag: function () {
        document.getElementById('backcanvasBorder').setStyle('height', document.getElementById('backcanvas').getSize().y);
        document.getElementById('backcanvasBorder').setStyle('width', document.getElementById('backcanvas').getSize().x);
        document.getElementById('v_line').setStyles({
          'left': document.getElementById('backcanvas').getSize().x + document.getElementById('backcanvas').getPosition().x + delta_v_line,
          'height': document.getElementById('canvas').offsetHeight - document.getElementById('h_ruler').offsetTop
        });
        resizeGrid(document.getElementById('backcanvas').getSize().x, document.getElementById('backcanvas').getSize().y);
      },
      onComplete: function () {
        var w_array = formProp.w.split(',');
        if (w_array[formProp.page-1].indexOf('%') == -1) {
          w_array[formProp.page-1] = parseInt(document.getElementById('backcanvas').getSize().x) ;
          formProp.w = w_array.join();
          formProp.pagesProp[formProp.page-1].w = document.getElementById('backcanvas').getSize().x.toString();
        }
        var h_array= formProp.h.split(',');
        h_array[formProp.page-1] = parseInt(document.getElementById('backcanvas').getSize().y);
        formProp.h = h_array.join();
        formProp.pagesProp[formProp.page-1].h = document.getElementById('backcanvas').getSize().y.toString();
        //formProp.h = "" + parseInt(document.getElementById('backcanvas').getSize().y) + "";
        if (!Empty(formProp.v_line))
          formProp.v_line = "" + document.getElementById('v_line').getPosition().x - document.getElementById('backcanvas').getPosition().x;
        clVRRulersLib.DrawVertical(parseInt(document.getElementById('backcanvas').getSize().y));
        clHRRulersLib.DrawHorizontal(parseInt(document.getElementById('backcanvas').getSize().x));
        if (!Empty(document.getElementById('properties').getElement('.form_w')) && !Empty(document.getElementById('properties').getElement('.form_h'))) {
          if (formProp.pagesProp[formProp.page-1].w.indexOf('%') == -1) document.getElementById('properties').getElement('.form_w').set('value', formProp.pagesProp[formProp.page-1].w);
          document.getElementById('properties').getElement('.form_h').set('value', formProp.pagesProp[formProp.page-1].h);
        }
        m_bUpdated = true;
        newFormPropObj.updateProperties();
      }
    });
  }
  //chiudo il search
  // var searchToggler = Ctrl("search-toggler");
  // if (searchToggler) {
  // searchToggler.click();
  // }
  //sposto il div dei results della search
  if (Ctrl("results_tab_content") && Ctrl("findList")) {
    Ctrl("results_tab_content").appendChild(Ctrl("findList"));
  }
  setVariant( variant );
  if (autopreview) {
    togglePreview(autopreview);
  }
  // if ( mode == "HTML") {
    // toggleMode();
  // } else if ( mode == "GRAPES") {
    toggleMode(mode);
  // }

  fnToDelay.delay(100);

  if(createAltInterfaceFor) {
    let [bo, section] = createAltInterfaceFor.split(':');
    formProp.altInterfaceFor = bo;
    formProp.altInterfaceForSection = section;
    if(Empty(currentname)){
      window.fillBoItems();
    }
  }
  });
}

function setVariant(currentVariant) {
  /**
  * variant
  */
  async function callbackRender(response){
    /**
     * Load variant contents
     */
    response.split(",").filter( i => i ).forEach( (variant) => {
      let url;
      variant = Strtran(variant, "_variant.jsp", "");
      variant = Strtran(variant, "\\", "/");
      let url_split = variant.split("/")
      let name = url_split[url_split.length -1];
      let site = url_split[0] == "sites" ? url_split[1] : null;
      let template = url_split[0] == "templates" ? url_split[1] : null ;
      url = new JSURL("../servlet/JSPLoad?type=variant&name=" + name + "&portlet=" + currentname +
      ( site ? "&sites=" + site : "" ) +
      ( template ? "&templates=" + template : "" ), true);
      let str = Strtran(url.Response(), '\u0080', '\u20AC');
      str = Strtran(str, '$>', '%>');
      str = Strtran(str, '<$', '<%');
      str = Strtran(str, '$\\u003e', '%\\u003e');
      str = Strtran(str, '\\u003c$', '\\u003c%');
      let json_array = JSON.parse(str);
      let obj = json_array[0]; //formProp
      obj.ctrls = json_array.splice(1);
      obj.folder_path = variant.substring( 0, variant.indexOf("/jsp-variants/"))
      // "htmlcode", "ctrls", "actioncode", "js_libs", "css_libs", "css_code"
      addVariant( name, obj, currentVariant != name );
    })
  }
  if( currentname ){
    /**
     * Search variants
     */
    let JSURLObj;
    // if( isCMS ){
    //   JSURLObj=new ZtVWeb.JSURL('../servlet/JSPReader?type=variant&folder_path='+currentname, true, callbackRender.bind(null, path), null);
    // } else {
      JSURLObj=new ZtVWeb.JSURL('../servlet/JSPReader?type=variant&folder_path='+currentname, true, callbackRender, null);
    // }
    JSURLObj.Response();
  }
  addVariant("-", { htmlcode: codeEditor.getValue() }, true);
}

function CreateToolbar(){
  toolbars.create_ctrl = new SPMultiToolbar('spmultitoolbar_create_ctrl', {
    title: 'Create'
  });

  toolbars.ctrl = new SPToolbar(ZTObjects.PSToolbarCtrl, 'sptoolbar_ctrls', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_create_ctrl',
    inMultiToolbar: true,
    title: "Commons"
  });

  toolbars.navigationctrl = new SPToolbar(ZTObjects.PSToolbarNavigationCtrl, 'sptoolbar_ctrl_views', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_create_ctrl',
    inMultiToolbar: true,
    title: "Navigation"
  });

  toolbars.eventsctrl = new SPToolbar(ZTObjects.PSToolbarEventCtrl, 'sptoolbar_ctrl_views', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_create_ctrl',
    inMultiToolbar: true,
    title: "Events"
  });

  toolbars.data_ctrl = new SPMultiToolbar('spmultitoolbar_data_ctrl', {
    title: 'Data'
  });

  toolbars.datactrl = new SPToolbar(ZTObjects.PSToolbarDataCtrl, 'sptoolbar_ctrl_data', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_data_ctrl',
    inMultiToolbar: true,
    title: "Data provider"
  });

  toolbars.viewsctrl = new SPToolbar(ZTObjects.PSToolbarViewsCtrl, 'sptoolbar_ctrl_views', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_data_ctrl',
    inMultiToolbar: true,
    title: "Data visualization"
  });

  toolbars.datapagectrl = new SPToolbar(ZTObjects.PSToolbarDataPageCtrl, 'sptoolbar_datapage_views', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_data_ctrl',
    inMultiToolbar: true,
    title: "Data page"
  });

  toolbars.addon_ctrl = new SPMultiToolbar('spmultitoolbar_addon', {
    title: 'Add on'
  });

  toolbars.extra = new SPToolbar(ZTObjects.PSAddOn, 'sptoolbar_extra', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_addon',
    inMultiToolbar: true
  });

  toolbars.align = new SPToolbar(ZTObjects.PSToolbarAlign, 'sptoolbar_align');

  toolbars.resize = new SPToolbar(ZTObjects.PSToolbarResize, 'sptoolbar_resize');

  toolbars.bring = new SPToolbar(ZTObjects.PSToolbarBring, 'sptoolbar_bring');

  toolbars.tools = new SPToolbar(ZTObjects.PSToolbarTools, 'sptoolbar_tools', {
    elementToShow: 'all'
  });

  toolbars.mode_ctrl = new SPMultiToolbar('spmultitoolbar_mode_ctrl', {
    title: 'Mode'
  });


  toolbars.mode = new SPToolbar(ZTObjects.PSToolbarMode, 'sptoolbar_ctrl_mode', {
    dropElement: 'canvas',
    draggable: true,
    containerId: 'spmultitoolbar_mode_ctrl',
    inMultiToolbar: true
  });

  toolbars.note = new SPToolbar(ZTObjects.PSToolbarNote, 'sptoolbar_note');

  toolbars.action = new SPToolbar(ZTObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  });

  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {
    standalone = true;
    document.getElementById(toolbars.action.id).classList.add("element-to-show-all");
  } else {
    toolbars.action.removeElement('open')
    toolbars.action.removeElement('save')
    toolbars.action.removeElement('input_action_open')
  }
  currentname == "" ?
    toolbars.action.disable('btn_preview') :
    toolbars.action.enable('btn_preview');
  if (Ctrl("srcform")) {
    Ctrl("srcform").value = currentname
    Ctrl("srcform").onfocus = function(){
      SetOnEditProp(true);
    }
    Ctrl("srcform").onblur = function(){
      SetOnEditProp(false);
    }
  }
}

function CreateGraperJS(callback){
  grapes = grapesjs.init( grapes_options );
  grapes.Canvas.getBody().className = "gjs-dashed"
  var link = document.createElement("link");
  link.setAttribute("type", "text/css");
  link.setAttribute("rel", "stylesheet");

  grapes.Canvas.getDocument().head.appendChild(link);
  link.href = "itemsObj.css";

  /**
   * Rimuove il bottone di TraitManager
   */
  grapes.Panels.removeButton("views", "open-tm");

  /**
   * Aggiungo il pannello per i dataproviders
   */
  grapes.Panels.addPanel({
    id: 'data-view-container',
    visible: true,
    buttons: []
  })


  var prop_container = document.createElement('div');
  prop_container.id ="properties_container";
  prop_container.appendChild(
    Backbone.$(`<div class="gjs-prop-cs gjs-one-bg gjs-two-color">
      <div class="gjs-block-categories">
        <div class="gjs-block-category gjs-open">
          <!--div class="gjs-title">
            Properties
          </div-->
          <div class="gjs-prop-c">
          </div>
        </div>
      </div>
      <div class="gjs-prop-no-cat">
        <div class="gjs-prop-c"></div>
      </div>
    </div>`)[0]);

  prop_container.hide();
  grapes.Prop = prop_container;

  grapes.on('load', () => {
    var panel = grapes.Panels.getPanel('views-container');
    panel.set('appendContent', grapes.Prop).trigger('change:appendContent');
    panel.set('appendContent', grapes.Data).trigger('change:appendContent');
    if (callback) callback();
  })


  grapes.Commands.add('show_prop', {
    run: function run(editor, sender) {
      editor;
      this.sender = sender;
      this.toggleDataPanel();
      Properties();
      // let cont = document.getElementById('properties_container');
      // if (cont){
      //   cont.appendChild(document.getElementById('properties'));
      // }
    },
    /**
     * Toggle Properties visibility
     * @private
     */
    toggleDataPanel: function toggleDataPanel() {
      // debugger;
      const sender = this.sender;
      if (sender && sender.get && !sender.get('active')) return;
      grapes.Panels.getPanel('views-container').trigger("change:appendContent");
      grapes.Prop.show()
    },
    stop: function stop() {
      var prop = grapes.Prop;
      prop && (prop.hide());
      if(typeof (hideProperties) != 'undefined') {
        hideProperties('properties')
      }
      // document.body.appendChild(document.getElementById('properties'));
    }
  });


  var data = document.createElement('div');
  data.appendChild(
    Backbone.$(`<div class="gjs-data-cs gjs-one-bg gjs-two-color">
      <div class="gjs-block-categories">
        <div class="gjs-block-category gjs-open">
          <!--div class="gjs-title">
            Datas
          </div-->
          <div class="gjs-data-c">
          </div>
        </div>
      </div>
      <div class="gjs-data-no-cat">
        <div class="gjs-data-c"></div>
      </div>
    </div>`)[0]);
  data.hide();
  grapes.Data = data;


  grapes.Commands.add('show_data_ctrl', {
    run: function run(editor, sender) {
      editor;
      this.sender = sender;
      this.toggleDataPanel();
    },
    /**
     * Toggle Properties visibility
     * @private
     */
    toggleDataPanel: function toggleDataPanel() {
      // debugger;
      const sender = this.sender;
      if (sender && sender.get && !sender.get('active')) return;
      grapes.Panels.getPanel('views-container').trigger("change:appendContent");
      grapes.Data.show()
    },
    stop: function stop() {
      var data = grapes.Data;
      data && (data.hide());
    }
  });

  grapes.Commands.add('close_grapes', {
    run: function run(editor, sender) {
      editor;
      this.sender = sender;
      toggleMode("GRAPES");
    },
    stop: function stop() {
    }
  });

  grapes.addDataItem = function(item) {
    var $ = Backbone.$;
    var item_block = $(
    `<div class="gjs-layer-title-c gjs-one-bg" data-name="${item.name}" data-index="${index}">
      <div class="gjs-layer-title " style="padding-left: 40px" data-toggle-select="">
        <div class="gjs-layer-title-inn">
          <span class="gjs-layer-name gjs-layer-name--no-edit gjs-no-app">${item.name}</span>
        </div>
      </div>
    </div>`)[0];
    item_block.addEventListener("click", function(name){
      index = itemsHTML.findIndex( el => { return el.name == name} );
      grapes.Panels.getPanel("views").buttons.forEach( el => { el.set("active", false)} );
      // apre il tab delle prop
      grapes.Panels.getButton("views", "prop").set('active', true);
    }.bind(null, item.name));
    grapes.Data.querySelector(".gjs-data-c").appendChild(item_block);
    grapes.Panels.getButton('views','data').set("active",true);
  }

  grapes.on("block:drag:stop", function(e, child){
    if(child.attributes.category.id == "Datas") {
      var item = putItem(null, false, false, {
        type: child.id
      });
      if (item){
        grapes.addDataItem(item);
      }
    }
    e;
  })

  grapes.on("component:add", function(e){
    if ( e.attributes.tagName == "psctrl" ){
      if (!b_reload ) {
        if( mode == "GRAPES" ){
          /**
           * Elemento aggiunto con Grapes quindi ancora da aggiungere all'itemsHTML
           */
          if ( !itemsHTML.find( el => { return el.name == e.name} )){
            putItem(null, false, false, {
              type: e.attributes.attributes.type,
              // id: e.ccid
            });
            e.ccid = "item" + index;
            e.addAttributes( {"name": itemsHTML[index].name, "index": index });
          }
        }
      } else {
        /**
         * Aggiungo il dataprovider
         */

        // if( e.attributes.category.id == "Datas") {
        //   var item = itemsHTML.find( el => { return el.name == e.name} );
        //   if ( item ) {
        //     addDataItem(itemsHTML);
        //   }
        // }
      }
    }
  })

  grapes.on("component:selected", function(e){
    if ( e.attributes.tagName == "psctrl" ){
      index = e.props().attributes.index;
      Properties();
      /**
       * Nascono le proprietÃ  incompatibili con grapes
       */
      if( document.getElementById('generic_positions_section') ){
        document.getElementById('generic_positions_section').style.display = "none";
      }
      if (document.getElementById('generic_size_section')) {
        document.getElementById('generic_size_section').style.display = "none";
      }
      // grapes.Panels.getButton("views", "open-tm").set('active', true);
      // chiude tutti i pannelli precedente aperti
      grapes.Panels.getPanel("views").buttons.forEach( el => { el.set("active", false)} );
      // apre il tab delle prop
      grapes.Panels.getButton("views", "prop").set('active', true);

    }
    // if( index != null && typeof (showProperties) != 'undefined'){
    //   showProperties('properties');
    // } else if(typeof (hideProperties) != 'undefined') {
    //   hideProperties('properties')
    // }
  })

  grapes.on("component:deselected", function(e){
    e;
    index = null;
    if( typeof (hideProperties) != 'undefined'){
      hideProperties('properties')
    }
  })

  grapes.Panels.addButton("views",{
    id: 'data',
    className: 'fa fa-database',
    command: 'show_data_ctrl',
    attributes: { title: 'Open data items'},
    active: false,
  });

  grapes.Panels.addButton('devices-c',{
    id: 'close-editor',
    className: 'fa fa-chevron-circle-left grapes-back',
    command: 'close_grapes',
    togglable: false,
    attributes: { title: 'Close Grapes Editor'},
    active: false,
  });

  grapes.Panels.addButton("views",{
    id: 'prop',
    className: 'fa fa-cog',
    command: 'show_prop',
    attributes: { title: 'Open prop items'},
    active: false,
  });

  var editor = grapes.getContainer();

  window.addEventListener('gadget-pane-open', (e) => {
    editor.style.left = editor.offsetLeft + e.detail.size + 'px';
    resizeHTMLEditor();

  });
  window.addEventListener('gadget-pane-close', (e) => {
    editor.style.left = editor.offsetLeft - e.detail.size +'px';
    resizeHTMLEditor();

  });

  grapes.on("core:component-enter", function(e){
    console.log(" "+e)
  })
}

function Help(the_property) {
  var i;
  var prop = '';
  if (typeof (anchorToFeature) != 'undefined') {
    if (typeof (the_property) != 'undefined')
      prop = "portleteditor_" + the_property.toLowerCase();
    if (prop != '' && prop in anchorToFeature)
      i = anchorToFeature[prop];
    else if (index != null && "portleteditor_" + itemsHTML[index].type.toLowerCase() in anchorToFeature)
      i = anchorToFeature["portleteditor_" + itemsHTML[index].type.toLowerCase()];
    else if (typeof (i) == 'undefined') {
      prop = "portleteditor_" + the_property.substring(the_property.indexOf('_'), 0).toLowerCase();
      i = anchorToFeature[prop];
    }

    if (typeof (i) == 'undefined') {
      i = anchorToFeature["portleteditor"];
    }
    windowOpenForeground(m_cHelpUrl + 'help/portalstudio/ps_urg_navigator.htm?' + URLenc(i + (prop != "" ? '||' + prop + "" : "")), '', 'toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
  }
}
// seleziona l'item se cliccato
function clickItem(e, elem) {
  multipleSelection = false;
  var str = "",
  element = elem ? elem : event.currentTarget;
  if (element.id.indexOf('_') > -1) {
    element = Ctrl(element.id.substr(0, element.id.indexOf('_')))
  }
  if (e == null || e.shiftKey == false) {
    removeAllHandlers()
  }
  let item = itemsHTML.find( e => e.id == element.id );
  if( item ) {
    item.shadow = "shadow" + element.id.substr(4);
  }
  str = addHandlers(element.id.substr(4))
  Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + str
  selectItem(Ctrl("shadow" + element.id.substr(4)))
  //Seleziono anche gli item con le stesse microzone
  if(formProp.selectZone == 'true' && e && !e.shiftKey){
    selectZonesItems ();
  }
}

function selectZonesItems (){
  var item = itemsHTML[index];
  for (var ii = 0; ii < itemsHTML.length; ii++) {
    if (item.id != itemsHTML[ii].id && !Empty(item.zone) && item.zone == itemsHTML[ii].zone ) {
      itemsHTML[ii].shadow='shadow' + itemsHTML[ii].id.substr(4);
      Ctrl("canvashandlers").innerHTML=Ctrl("canvashandlers").innerHTML + addHandlers(itemsHTML[ii].id.substr(4));
      selectItem(Ctrl(itemsHTML[ii].shadow)); // se e' stato incluso tra i selezionati
    }
  }
}


var draggingHandler
var draggingHandlerCorner
var draggedItemIdx

function beginDragHandler(e, itmIdx, corner) {
  var handler = GetEventSrcElement(e);
  // memorizza che cosa sta' muovendo
  selectItem(Ctrl("shadow" + itmIdx));
  draggingHandler = handler;
  draggedItemIdx = itmIdx;
  draggingHandlerCorner = corner;
  undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj('item' + itmIdx, 'resize', null, null, itemsHTML[index].x, itemsHTML[index].y, itemsHTML[index], null, null, itemsHTML[index].w, itemsHTML[index].h);
  Ctrl("canvas").onmousemove = continueDragHandler;
  Ctrl("canvas").onmouseup = endDragHandler;
  // blocca la propagazione
  e.cancelBubble = true;
  e.returnValue = false;
}

function beginDragSelection(e) { //REDEFINED
  if (typeof (hideProperties) != 'undefined') hideProperties('properties')
  var dragstyle = Ctrl("drag").style
  var canvas = Ctrl("canvas")
  e = (e) ? e : window.event;
  var x = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  var y = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  x += window.pageXOffset;
  y += window.pageYOffset;
  x = x - (parseInt(Ctrl("backcanvas").offsetLeft) + parseInt(Ctrl("canvas").offsetLeft)) + parseInt(Ctrl("backcanvas").scrollLeft + parseInt(Ctrl('canvas').scrollLeft))
  y = y - (parseInt(Ctrl("backcanvas").offsetTop) + parseInt(Ctrl("canvas").offsetTop)) + parseInt(Ctrl("backcanvas").scrollTop + parseInt(Ctrl('canvas').scrollTop))
  dragstartx = x
  dragstarty = y
  // mostra il rettangolo di drag
  document.getElementById('drag').set('tween', {
    duration: '100'
  });
  document.getElementById('dragcontent').set('tween', {
    duration: '100'
  });
  document.getElementById('drag').tween('opacity', 0, 1);
  document.getElementById('dragcontent').tween('opacity', 0, 0.3);
  //document.getElementById('drag').setStyle('opacity', 1);
  //document.getElementById('dragcontent').setStyle('opacity',0.3);
  dragstyle.visibility = "visible";
  dragstyle.top = y + 'px';
  dragstyle.left = x + 'px';
  dragstyle.width = 0
  dragstyle.height = 0
  // installa il gestore del mousemove
  canvas.onmousemove = continueDragSelection
  canvas.onmouseup = endDragSelection
  // blocca la propagazione
  cancelEvent(e)
}

function endDragSelection(e) { //REDEFINED
  var drag = Ctrl("drag");
  var mainItem = itemsHTML[index];
  findDragItems(e, drag.offsetTop, drag.offsetLeft, drag.offsetWidth, drag.offsetHeight)
  //seleziona l elemento se ci sono elementi nell'area scelta

  if (mainItem && mainItem.shadow != "") {
    selectItem(Ctrl(mainItem.shadow))
  } else {
    for (var i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].shadow != "" && Ctrl(itemsHTML[i].shadow)) {
        selectItem(Ctrl(itemsHTML[i].shadow)); // se e' stato incluso tra i selezionati
        break;
      }
    }
  }
  // nasconde il rettangolo di drag
  document.getElementById('drag').set('tween', {
    duration: '100'
  });
  document.getElementById('dragcontent').set('tween', {
    duration: '100'
  });
  document.getElementById('drag').tween('opacity', 1, 0);
  document.getElementById('dragcontent').tween('opacity', 0.3, 0);
  //document.getElementById('drag').setStyle('opacity',0);
  //document.getElementById('dragcontent').setStyle('opacity',0);
  drag.style.visibility = "hidden";
  Ctrl("canvas").onmousemove = null
  Ctrl("canvas").onmouseup = null
  if (typeof (showProperties) != 'undefined') showProperties('properties')
  //refreshToolTips();
}

function continueDragHandler(e) {
  var itm = Ctrl('item' + draggedItemIdx)
  var shadow = Ctrl('shadow' + draggedItemIdx)
  itm.style.transition = '';
  var x, y, w, h
  var mainItem = itemsHTML[index]
  var delta = []; //array che conterra' la dimensione dello spostamento che viene effettuato sulla shadow
  var xfunction
  var yfunction
  if (mainItem.objClass.newProperties) {
    var c = 0;
    for (var i in mainItem.objClass.newProperties) {
      var tab = mainItem.objClass.newProperties[i];
      for (var ii = 0; ii < tab.length && c < 2; ii++) {
        if (tab[ii].propID == 'x') {
          xfunction = tab[ii].convertFunc;
          c++;
        }
        if (tab[ii].propID == 'y') {
          yfunction = tab[ii].convertFunc;
          c++;
        }
      }
    }
  }
  x = itm.offsetLeft
  y = itm.offsetTop
  w = itm.offsetWidth
  h = itm.offsetHeight
  var hgap = h - itm.clientHeight //dimensione  bordi margin e padding
  var wgap = w - itm.clientWidth //dimensione minima senza bordi margin e padding
  e = (e) ? e : window.event;
  newx = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
  newy = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
  newx = parseInt(newx) - (Ctrl("backcanvas").offsetLeft + Ctrl("canvas").offsetLeft) + Ctrl("backcanvas").scrollLeft + parseInt(Ctrl('canvas').scrollLeft)
  newy = parseInt(newy) - (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop) + Ctrl("backcanvas").scrollTop + parseInt(Ctrl('canvas').scrollTop)
  //
  var dh = 0;
  var dw = 0;
  switch (draggingHandlerCorner) {
    case 0:
      // Angolo sinistro sopra
      if (newx < x + w - wgap && newy < y + h - hgap) { //controllo che non possa essere collassato il componente a una dimensione minore alle sue dimensioni minime
        delta[0] = newx - shadow.offsetLeft
        delta[1] = newy - shadow.offsetTop
        delta[2] = 0
        delta[3] = 0
        if (canAlign) delta = drawSnap(delta, true)
        dw = -delta[0]
        dh = -delta[1]
      }
      break
    case 1:
      // Angolo destro sopra
      if (newx > x + wgap && newy < y + h - hgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = newy - shadow.offsetTop
        delta[2] = newx - (shadow.offsetLeft + getOffset(shadow).w)
        delta[3] = 0
        if (canAlign) delta = drawSnap(delta, true)
        dw = delta[2]
        dh = -delta[1]
      }
      break
    // Angolo destro sotto
    case 2:
      if (newx > x + wgap && newy > y + hgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = 0
        delta[2] = newx - (shadow.offsetLeft + getOffset(shadow).w)
        delta[3] = newy - (shadow.offsetTop + getOffset(shadow).h)
        if (canAlign) delta = drawSnap(delta, true)
        dw = delta[2]
        dh = delta[3]
      }
      break
    // Angolo sinistro sotto
    case 3:
      if (newy > y + hgap && newx < x + w - wgap) {
        // sposta l' handler
        delta[0] = newx - shadow.offsetLeft
        delta[1] = 0
        delta[2] = 0
        delta[3] = newy - (shadow.offsetTop + getOffset(shadow).h)
        if (canAlign) delta = drawSnap(delta, true)
        dw = -delta[0]
        dh = delta[3]
      }
      break
    // Lato sotto
    case 6:
      if (newy > y + hgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = 0
        delta[2] = 0
        delta[3] = newy - (shadow.offsetTop + getOffset(shadow).h)
        if (canAlign) delta = drawSnap(delta, true)
        dw = 0;
        dh = delta[3]
      }
      break
    // Lato sopra
    case 4:
      if (newy < y + h - hgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = newy - shadow.offsetTop
        delta[2] = 0
        delta[3] = 0
        if (canAlign) delta = drawSnap(delta, true)
        dw = 0;
        dh = -delta[1]
      }
      break
    // Lato sx
    case 7:
      if (newx < x + w - wgap) {
        // sposta l' handler
        delta[0] = newx - shadow.offsetLeft
        delta[1] = 0
        delta[2] = 0
        delta[3] = 0
        if (canAlign) delta = drawSnap(delta, true)
        dw = -delta[0]
        dh = 0;
      }
      break
    // Lato dx
    case 5:
      if (newx > x + wgap) {
        // sposta l' handler
        delta[0] = 0
        delta[1] = 0
        delta[2] = newx - (shadow.offsetLeft + getOffset(shadow).w)
        delta[3] = 0
        if (canAlign) delta = drawSnap(delta, true)
        dw = delta[2]
        dh = 0;
      }
      break
  }
  //Spostamento e ridimensionamento
  //
  var xs = shadow.offsetLeft,
    ys = shadow.offsetTop,
    ws = getOffset(shadow).w,
    hs = getOffset(shadow).h;
  //MG 20120305 beg
  var ret = true;
  if (window.ValidMove) {
    ret = window.ValidMove(shadow.offsetLeft + delta[0], shadow.offsetTop + delta[1], shadow.offsetWidth, shadow.offsetHeight, itm.id)
  }
  if (ret == false)
    return;
  //MG 20120305 beg

  w = itm.offsetWidth;
  h = itm.offsetHeight;
  var xi = itm.offsetLeft,
    yi = itm.offsetTop,
    hi = getOffset(itm).h,
    wi = getOffset(itm).w;
  //
  xs = x + (delta[0] ? delta[0] : 0);
  ys = y + (delta[1] ? delta[1] : 0);
  xi = xi + (delta[0] ? delta[0] : 0);
  yi = yi + (delta[1] ? delta[1] : 0);
  //
  hs = (hs + dh) >= 0 ? (hs + dh) : 0;
  ws = (ws + dw) >= 0 ? (ws + dw) : 0;
  hi = (hi + dh) >= 0 ? (hi + dh) : 0;
  wi = (wi + dw) >= 0 ? (wi + dw) : 0;
  // h= shadow.offsetHeight
  // w= shadow.offsetWidth
  h = (h + dh) >= 0 ? (h + dh) : 0;
  w = (w + dw) >= 0 ? (w + dw) : 0;
  //
  // resize della shadow
  shadow.style.width = ws + 'px';
  shadow.style.height = hs + 'px';
  shadow.style.top = ys + 'px';
  shadow.style.left = xs + 'px';
  // modifica l' item
  //itm.style.transition='top 0.3s,left 0.3s';
  itm.style.width = wi + 'px';
  itm.style.height = hi + 'px';
  itm.style.top = yi + 'px';
  itm.style.left = xi + 'px';
  // salvo le proprieta nell oggetto item
  mainItem.w = shadow.offsetWidth
  mainItem.h = shadow.offsetHeight
  mainItem.x = xi
  mainItem.y = yi

  // var w=shadow.offsetWidth
  // var h=shadow.offsetHeight

  var shadowH = (hs > 0 ? hs : 0) + 8; //tolgo i due pixel dei bordi
  var shadowW = (ws > 0 ? ws : 0) + 8; //tolgo i 2 pixel dei bordi

  Ctrl("handlersWrapper" + draggedItemIdx).style.top = (shadow.offsetTop - 3) + 'px';
  Ctrl("handlersWrapper" + draggedItemIdx).style.left = (shadow.offsetLeft - 3) + 'px';
  Ctrl("handlersWrapper" + draggedItemIdx).style.height = (shadowH) + 'px'
  Ctrl("handlersWrapper" + draggedItemIdx).style.width = (shadowW) + 'px'
  Ctrl("handler" + draggedItemIdx + "_5").style.top = (shadowH / 2 - 4) + 'px'; //bordi
  Ctrl("handler" + draggedItemIdx + "_6").style.top = (shadowH - 18) + 'px'; //posizionamento relativo  (18 = size*2 + bordi)
  Ctrl("handler" + draggedItemIdx + "_7").style.top = (shadowH / 2 - 4) + 'px';
  // document.getElementById('bn').value +=   '\n 5-7:'+(shadowH/2 -7 )+' 6:'+(shadowH- 18)+' T:'+shadowH

  var calcw = parseInt(shadow.offsetWidth);
  var calch = parseInt(shadow.offsetHeight);
  if (typeof (xfunction) != 'undefined')
    eval("calcw=" + xfunction + "(calcw)")
  if (typeof (yfunction) != 'undefined')
    eval("calch=" + yfunction + "(calch)")
  var strp = "w=" + (calcw) + "&nbsp;" + "h=" + (calch)
  shadow.innerHTML = "<div style='position:relative;left:5px;top:-12px' ondragstart='noDefaultDrag(event)' onselectstart='noDefaultDrag(event)'>" + strp + "</div>"
  EmptyRefLines();
  addRulersLines();
}

function endDragHandler() {
  //tolgo gli allineamenti e le selected_shadow
  resetAlign();
  var shadow = Ctrl('shadow' + draggedItemIdx);
  shadow.innerHTML = "";
  //salvo le proprieta nell oggetto item
  Properties();
  Ctrl("canvas").onmousemove = null;
  Ctrl("canvas").onmouseup = null;
  m_bUpdated = true;
  if (undoItemsMoved.length > 0) {
    //Necessari per il Redo
    undoItemsMoved[undoItemsMoved.length - 1].x = itemsHTML[index].x;
    undoItemsMoved[undoItemsMoved.length - 1].y = itemsHTML[index].y;
    undoItemsMoved[undoItemsMoved.length - 1].w = itemsHTML[index].w;
    undoItemsMoved[undoItemsMoved.length - 1].h = itemsHTML[index].h;
    indexUndo++;
    undoSequence[indexUndo] = undoItemsMoved;
    CheckUndoSize();
    undoItemsMoved = [];
  }
  if (typeof (showProperties) != 'undefined') showProperties('properties');
  writeHTML();
}

function addHandlers(itmIdx) { //REDEFINED
  var itm = document.getElementById("item" + itmIdx),
    itmobj;
  var yi = itm.offsetTop
  var xi = itm.offsetLeft
  var wi = itm.offsetWidth
  var hi = itm.offsetHeight
  var str = ""

  var shadowH = ((hi - 2) > 0 ? hi - 2 : 0); //tolgo i due pixel dei bordi
  var shadowW = ((wi - 2) > 0 ? wi - 2 : 0); //tolgo i 2 pixel dei bordi
  var wrapperH = shadowH + 8; //dimensioni del wrapper che contiene gli handler
  var wrapperW = shadowW + 8; //dimensioni del wrapper che contiene gli handler

  /*
							0-----4-----1
							|           |
							7           5
							|           |
							3-----6-----2
*/
  // aggiunge il div shadow+n della grandezza dell item per lo spostamento
  str += "<div id='handlersWrapper" + itmIdx + "' style='margin:0;z-index:2;position:absolute;overflow:hidden;height:" + wrapperH + "px;width:" + wrapperW + "px;top:" + (yi - 3) + "px;left:" + (xi - 3) + "px;background:transparent;'>"

  str += addHandler(0, itmIdx, 0) //su-sin
  str += addHandler(0, itmIdx, 1) //su-dx
  str += addHandler(wrapperH, itmIdx, 2) //giu'-dx
  str += addHandler(0, itmIdx, 3) //giu'-sx
  str += addHandler(0, itmIdx, 4)
  str += addHandler(wrapperH / 2, itmIdx, 5)
  str += addHandler(wrapperH, itmIdx, 6)
  str += addHandler(wrapperH / 2, itmIdx, 7)
  str += "</div><div  id='shadow" + itmIdx + "' tabindex='-1' class='shadow' style='top:" + yi + "px;left:" + xi + "px;width:" + shadowW + "px;height:" + shadowH + "px;' onmousedown='dragShadow(event);' ondblclick='editItemEvent(event,this)'>"
  str += "&nbsp;";
  str += "</div>";
  //configuro le dimensioni per gli allineamenti seguendo le caratteristiche della shadow
  if (!multipleSelection) {
    not_selected = [];
    container_selection.t = yi;
    container_selection.l = xi;
    container_selection.w = shadowW + 2;
    container_selection.h = shadowH + 2;
    container_selection.b = yi + shadowH + 2;
    container_selection.r = xi + shadowW + 2;
    for (var i = 0; i < itemsHTML.length; i++) {
      itmobj = itemsHTML[i];
      itm = document.getElementById(itemsHTML[i].id);
      if (itm && Empty(itemsHTML[i].shadow) && itm.style.display != 'none' && !itmobj.hidden) not_selected.push(i);
    }
  }
  return str;

}

function addHandler(y, itmIdx, corner) { //REDEFINED

  var cursorStyle = ""
  var moveControl = ""
  var borderW = "";
  var margin = "";
  var position = ""
  var floating = ""
  var left = ""
  var top = ""
  var right = ""
  var bottom = ""
  var size = 7
  //itemresizable = (itemsHTML[index].type != "SPLinker" && itemsHTML[index].type != "SQLDataobj")
  switch (corner) {
    case 0:
      borderW = "2px 0px 0px 2px;";
      position = "absolute";
      floating = 'left'
      top = 0
      left = 0
      break;
    case 1:
      borderW = "2px 2px 0px 0px;";
      position = "absolute";
      floating = 'left'
      top = 0
      right = 0
      break;
    case 2:
      borderW = "0px 2px 2px 0px;";
      position = "absolute";
      floating = 'left'
      bottom = 0
      right = 0
      break;
    case 3:
      borderW = "0px 0px 2px 2px;";
      position = "absolute";
      floating = 'left'
      bottom = 0;
      left = 0
      break;
    case 4:
      borderW = "2px 0px 0px 0px;";
      position = 'relative'
      margin = '0 auto';
      top = 0;
      break;
    case 5:
      borderW = "0px 2px 0px 0px;";
      position = "absolute";
      floating = 'right'
      right = 0
      top = y - 4; //bordi
      break;
    case 6:
      borderW = "0px 0px 2px 0px;";
      position = "relative";
      margin = '0 auto';
      top = y - (size * 2 + 4); //bordi
      break;
    case 7:
      borderW = "0px 0px 0px 2px;";
      position = "absolute";
      floating = 'left'
      top = y - 4; //bordi
      break;
  }
  if (corner == 0 || corner == 2)
    cursorStyle = "cursor:nw-resize;"
  else if (corner == 4 || corner == 6)
    cursorStyle = "cursor:n-resize;"
  else if (corner == 5 || corner == 7)
    cursorStyle = "cursor:w-resize;"
  else
    cursorStyle = "cursor:ne-resize;"
  moveControl = " onmousedown='beginDragHandler(event," + itmIdx + "," + corner + ")'"
  //controllo che  l'item abbia dimensioni sufficienti per avere gli handler
  var v = "<div id='handler" + itmIdx + "_" + corner + "' class='handler' style='float:" + floating + "; overflow:hidden;border-width:" + borderW + cursorStyle + "; z-index:5;position:" + position + "; top:" + top + "px;  bottom:" + bottom + "px;" +
    "left:" + left + ";  right:" + right + ";   width:" + size + "px;  height:" + size + "px; margin: " + margin + ";' " + moveControl + ">&nbsp</div>"
  return v
}

function selectItem(itm) { // REDEFINED
  SetOnEditProp(false);
  var selecteditem, n, i, p
  mainitem = itm;
  //Se non c'e' la shadow e gli handler ce li metto

  if (mainitem.id.indexOf('shadow') == -1) { // ho passato un item di itemsHtml
    selecteditem = mainitem.id.substr(4);
    if (index == selecteditem) {
      return;
    }
    var handlrs = addHandlers(selecteditem);
    mainitem.shadow = 'shadow' + selecteditem;
    Ctrl("canvashandlers").innerHTML = Ctrl("canvashandlers").innerHTML + handlrs;
    for (i = 0; i < itemsHTML.length; i++) {
      if ( itemsHTML[i].id == mainitem.id ) {
        index = i;
        break;
      }
    }
  } else {
    selecteditem = mainitem.id.substr(6);
    if (index == selecteditem) {
      return;
    }
    for (i = 0; i < itemsHTML.length; i++) {
      if (itemsHTML[i].shadow == mainitem.id){
        index = i
        break;
      }
    }
  }
  if ( mode == "HTML") {
    /**
     * Selezione dell'item nel codice
     */
    let itemName = itemsHTML[index].name;
    codeEditor.getAllMarks().forEach( m => m.clear() );
    if( itemsHTML[index].hidden ) {
      let c = codeEditor.getSearchCursor( getHiddenCtrlHTMLRegex( itemName ) );
      if( codeEditor.state.matchHighlighter ){
        let state = codeEditor.state.matchHighlighter
        codeEditor.removeOverlay( state.overlay );
        state.overlay = null;
        if (state.matchesonscroll) {
          state.matchesonscroll.clear();
          state.matchesonscroll = null;
        }
      }
      while ( c.findNext() ) {
        codeEditor.state.markedSelection.push(codeEditor.markText(c.from(), c.to(), {'className': "cm-matchhighlight"}));
      }
    } else {
      let c = codeEditor.getSearchCursor( getVisibleCtrlHTMLRegex( itemName ) );
      if ( c.findNext() ) {
      var t = codeEditor.getTokenAt(c.to());
      if( t.type == "ctrl" ){
        // codeEditor.setSelection(c.to(),c.from());
          codeEditor.setSelection(c.from(),c.to(),{bias: -1});
          // codeEditor.state.markedSelection.push(codeEditor.markText(c.from(), c.to(), {'className': "cm-matchhighlight"}));
          // codeEditor.setCursor( CodeMirror.Pos(c.to().line, c.to().ch, "before") );
        }
      }
    }
  }
  document.getElementById("shadow" + selecteditem).focus();
  if (changeselectshadow == true)
    document.getElementById("shadow" + selecteditem).setStyle('opacity', 0.5);
  var mainItemSelectedHandlerColor = "#000";
  var secondaryItemSelectedHandlerColor = "#888"
  Ctrl("handler" + selecteditem + "_0").style.borderColor = mainItemSelectedHandlerColor;
  Ctrl("handler" + selecteditem + "_1").style.borderColor = mainItemSelectedHandlerColor;
  Ctrl("handler" + selecteditem + "_2").style.borderColor = mainItemSelectedHandlerColor;
  Ctrl("handler" + selecteditem + "_3").style.borderColor = mainItemSelectedHandlerColor;
  Ctrl("handler" + selecteditem + "_4").style.borderColor = mainItemSelectedHandlerColor;
  Ctrl("handler" + selecteditem + "_5").style.borderColor = mainItemSelectedHandlerColor;
  Ctrl("handler" + selecteditem + "_6").style.borderColor = mainItemSelectedHandlerColor;
  Ctrl("handler" + selecteditem + "_7").style.borderColor = mainItemSelectedHandlerColor;
  for (p = 0; p < itemsHTML.length; p++) {
    if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "" && Ctrl(itemsHTML[p].shadow)) {
      // elemento ennesimo nell'array
      n = Ctrl(itemsHTML[p].shadow).id.substr(6)
      if (changeselectshadow == true)
        document.getElementById("shadow" + n).setStyle('opacity', 0.2);
      Ctrl("handler" + n + "_0").style.borderColor = secondaryItemSelectedHandlerColor;
      Ctrl("handler" + n + "_1").style.borderColor = secondaryItemSelectedHandlerColor;
      Ctrl("handler" + n + "_2").style.borderColor = secondaryItemSelectedHandlerColor;
      Ctrl("handler" + n + "_3").style.borderColor = secondaryItemSelectedHandlerColor;
      Ctrl("handler" + n + "_4").style.borderColor = secondaryItemSelectedHandlerColor;
      Ctrl("handler" + n + "_5").style.borderColor = secondaryItemSelectedHandlerColor;
      Ctrl("handler" + n + "_6").style.borderColor = secondaryItemSelectedHandlerColor;
      Ctrl("handler" + n + "_7").style.borderColor = secondaryItemSelectedHandlerColor;
    }
  }

  Properties();
  if ( mode != "GRAPES" ) {
    if( document.getElementById('generic_positions_section') ){
      document.getElementById('generic_positions_section').display = "";
    }
    if ( document.getElementById('generic_size_section') ){
      document.getElementById('generic_size_section').display = "";
    }
  }
  EmptyRefLines();
  addRulersLines();
}

// Funzioni di inserimento nuovo item da interfaccia
function addItem(event, item) {
  var type = item;
  /**
   * Da controllare grapesmode non dovrebbe avere la addItem
   */
  if (event.type == 'drop' || mode == "HTML"  ) {
    putItem(mode != "NORMAL" ? null : event, null, null, {
      type: type
    });
  } else {
    document.body.style.cursor = "crosshair";
    selectForm();
    Ctrl("canvas").onmousedown = function (event) {
      return putItem(event, null, null, {
        type: type
      });
    };
  }
}

var xxpos // for insert image dialog
var yypos

function putItem(e, b_reload, paste, obj) {
  var type = obj.type;
  var name = obj.name || type + nitem;
  var id = obj.id || 'item' + nitem;
  var xpos = 0;
  var ypos = 0;
  var Ctrl_w = 120,
    Ctrl_h = 90;

  if (e != null) {
    xpos = (e.pageX) ? e.pageX : (e.clientX) ? e.clientX : 0;
    ypos = (e.pageY) ? e.pageY : (e.clientY) ? e.clientY : 0;
    xpos = parseInt(xpos) - (Ctrl("backcanvas").offsetLeft + Ctrl("canvas").offsetLeft) + (Ctrl("backcanvas").scrollLeft + parseInt(Ctrl('canvas').scrollLeft));
    ypos = parseInt(ypos) - (Ctrl("backcanvas").offsetTop + Ctrl("canvas").offsetTop) + (Ctrl("backcanvas").scrollTop + parseInt(Ctrl('canvas').scrollTop));
  } else {
    /**
     * Cerco di posizionare i ctrl in una posizione sensata
     */
    var it = ZTObjects[type + 'Obj'] || ZTObjects[type];
    if ( it ) {
      if( it.hidden || it.prototype.hidden ) {
        /**
         * lo posiziono vicino al backcanvas
         */
        var backcanvas = document.getElementById("backcanvas");
        xpos = backcanvas.offsetWidth + 50;
        ypos = itemsHTML.reduce(function(acc,el){
          if ( el.hidden && (parseInt(el.y) + parseInt(el.h)) > acc) {
            acc = parseInt(el.y) + parseInt(el.h) + 2;
          }
          return acc;
        }, 0) ;
      } else {
        xpos = 50;
        ypos = itemsHTML.reduce(function(acc,el){
          if ( !el.hidden && (parseInt(el.y) + parseInt(el.h)) > acc) {
            acc = parseInt(el.y) + parseInt(el.h) +2 ;
          }
          return acc;
        }, 0);
      }
    } else {
      return null;
    }
  }
  var divContainer = document.createElement('div');
  var zindex = findMaxZIndex(true) + 1;
  var className = '"Ctrl ' + ((visualMode) ? 'Ctrl-disable' : 'Ctrl-background') + '"';
  var html = '<div id=\'' + id + '\' class=' + className + ' style="margin:0;overflow:hidden;z-index:1;position:absolute;top:' + ypos + 'px;left:' + xpos + 'px;height:' + Ctrl_h + 'px;width:' + Ctrl_w + 'px" onselectstart=\'noDefaultDrag(event)\' onclick=\'clickItem(event)\'></div>';

  if (ZTObjects[type + 'Obj']){
    itemsHTML[countindex] = new ZTObjects[type + 'Obj'](id, name, type, html, '', '', xpos, ypos, Ctrl_h, Ctrl_w, def);
  } else if(ZTObjects[type]){
    itemsHTML[countindex] = new ZTObjects[type](id, name, type, html, '', '', xpos, ypos, Ctrl_h, Ctrl_w, def);
  }

  var item = itemsHTML[countindex];
  if( current_variant > 0){
    item.ctrlOfVariant = current_variant;
    if( !paste ){
      variants[current_variant].ctrls.push(item);
    }
  }
  nitem++;
  countindex++;
  divContainer.innerHTML = item.html;
  Ctrl("canvasitems").appendChild(divContainer.childNodes[0]);
  var item_html = Ctrl(item.id);
	/**
	 * Controllo se l'elemento sporge dal portlet
	 */
  var backcanvas_r = Ctrl("backcanvas").getBoundingClientRect();
  var outside = (!item.hidden && (ypos < 0 || xpos < 0 || Ctrl_w + xpos > backcanvas_r.width || Ctrl_h + ypos > backcanvas_r.height));
	if( outside )
		item_html.classList.add('outside')
  divContainer = null;
  if (!Empty(item.h))
    item_html.style.height = item.h + 'px';
  else
    item.h=(Empty(item_html.offsetHeight)?30:item_html.offsetHeight);
  if(!Empty(item.w))
    item_html.style.width=item.w+'px';
  else
    item.w = (Empty(item_html.offsetWidth) ? 30 : item_html.offsetWidth);
  item.page = formProp.page; //imposta la pagina corrente
  if (!b_reload && Empty(item.sequence)) item.sequence = ++sequence_c;
  document.body.style.cursor = "default";
  Ctrl("canvas").onmousedown = beginDragSelection;
  if (!b_reload) {
    index = countindex - 1;
    itemsHTML[index].zindex = zindex;
    writeHTML(paste);
    if ( mode != "NORMAL" ) {
      Properties();
    } else {
      index = null;
      clickItem(null, item_html);
    }

    m_bUpdated = true;
  }
  /**
   * Aggiungo l'item anche in grapes se non provango dalla
   * chiamata di drop di grapes stesso
   */
  if ( mode != "GRAPES" && !b_reload){
    if( item.hidden ) {
      grapes.addDataItem(item);
    } else {
      grapes.addComponents([{
        // tagname: item.type,
        id: "item" + (countindex - 1),
        type: item.type,
        attributes: {
          name: item.name,
          index: countindex - 1,
          type: item.type,
        },
        content: item.name
      }]);
    }

  }
  /**
   * Al reload aggiungo gli item non visuali a GRAPES
   */
  if( b_reload && item.hidden ) {
    grapes.addDataItem(item);
  }

  if ( !itemsHTML[countindex - 1].hidden || ( !b_reload && type == "Variable" && formProp.form_type == "true" ) ) {
    let cursor = codeEditor.getSearchCursor( getVisibleCtrlHTMLRegex( itemsHTML[countindex - 1].name ));
    let str = "{{ @" + itemsHTML[countindex - 1].name + " }}";
    if (  cursor.findNext() ) {
      if (mode == "HTML" && !b_reload )
        codeEditor.setSelection( cursor.from(), cursor.to())
    } else { /** non e' presente */
      var cursorPos
      // if (itemsHTML[countindex - 1].hidden) { /** item non visibile viene inserito in cima */
      // cursorPos = ;
      // } else {
      if( mode == "HTML" ) {
        if (e && !b_reload) {
          cursorPos = codeEditor.coordsChar({
            top: e.clientY,
            left: e.clientX
          })
        } else {
          cursorPos = codeEditor.getCursor("to");
          str += " \n";
        }
      } else {
        cursorPos = codeEditor.getCursor("to");
        str += " \n";
      }
      codeEditor.replaceRange(str, cursorPos);
      // codeEditor.setCursor({ line: cursorPos.line, ch: cursorPos.ch + 5, sticky: 'after' });
      codeEditor.setCursor(codeEditor.lineCount());
    }
    /**
     * Add visible_ctrl to combo (HTMLMode)
     */
    let newOption = new Option(item.name, item.name, false, false);
    newOption.setAttribute("data-variant", current_variant);
    let group = document.querySelector('#visible_ctrl_combo optgroup[type="'+item.type+'"]');
    if( !group ) {
      group = document.createElement("optgroup");
      group.setAttribute("type", item.type);
      group.setAttribute("label", item.type);
      document.getElementById("visible_ctrl_combo").appendChild(group);
    }
    group.appendChild(newOption);
    // if( !item.ctrlOfVariant ) {
    // }
    jQuery('#visible_ctrl_combo').trigger('change');
  } else {
    /**
     * Aggiunge il ctrl nascosto alla combo
     */
    let newOption = new Option(item.name, item.name, false, false);
    newOption.setAttribute("data-variant", current_variant)
    let group = document.querySelector('#hidden_ctrl_combo optgroup[type="'+item.type+'"]');
    if( !group ) {
      group = document.createElement("optgroup");
      group.setAttribute("type", item.type);
      group.setAttribute("label", item.type);
      document.getElementById("hidden_ctrl_combo").appendChild(group);
    }
    group.appendChild(newOption);
    jQuery('#hidden_ctrl_combo').trigger('change');
  }
  if ( mode == "HTML" ){
    codeEditor.focus();
  }
  if (type != 'Image' || b_reload)
    type = 'Form';
  if (index != null && !paste && mode!="GRAPES") renderPreSet(item_html);
  return item;
}

function checkVisibleItemsOutsideCanvas() {
	var backcanvas_r = Ctrl("backcanvas").getBoundingClientRect();
	itemsHTML.forEach(function (el) {
		if (!el.hidden) {
			var ctrl = Ctrl(el.id);
		if( !ctrl)
			return;
      ctrl.classList.remove("outside");
      var size = getOffset(ctrl);
			if (ctrl.offsetLeft < 0 || ctrl.offsetTop < 0 || ctrl.offsetLeft + size.w > backcanvas_r.width ||
        ctrl.offsetTop + size.h > backcanvas_r.height) {
				ctrl.classList.add("outside");
			}
		}
	})
}

var orig = moveItems;

window.moveItems = function () {
	orig.apply(null,arguments);
	checkVisibleItemsOutsideCanvas();
}

function renderLayout_Steps() { // i pallini
  if (raphael == null)
    raphael = Raphael(document.getElementById('layoutSteps'), document.getElementById('backcanvas').getSize().x + 10, 15);
  else
    raphael.clear();
  // document.getElementById('layoutSteps').innerHTML = "";
  if (!Empty(formProp.layout_step)) {
    document.getElementById('layoutSteps').setStyle('width', raphael.width);
    var steps = formProp.steps.split(',');
    var arrowH = 10,
      arrowPunta = 7,
      circleSize = 5,
      arrowColor = "#D5D5D5",
      circleColor = "#484848",
      textColor = "#000000",
      defaultStep = 100;
    steps.forEach(function (item, index, array) {
      array[index] = parseInt(item);
    });
    steps.sort(function (a, b) {
      return parseInt(a) > parseInt(b)
    });

    steps.push(steps[steps.length - 1] + defaultStep);
    if (steps[steps.length - 1] > (raphael.width)) {
      raphael.setSize(steps[steps.length - 1], 15);
      document.getElementById('layoutSteps').setStyle('width', steps[steps.length - 1]);
    }
    if (clHRRulersLib) clHRRulersLib.DrawHorizontal(steps[steps.length - 1]);

    for (var i = 0; i < steps.length; i++) {
      /* variabili per i disegni */

      var A = ((i == 0 ? 0 : steps[i - 1] + circleSize) + arrowPunta) + ",0",
        B = "L" + (steps[i] - arrowPunta - circleSize) + ",0",
        C = "L" + (steps[i] - circleSize) + "," + arrowH / 2,
        D = "L" + (steps[i] - arrowPunta - circleSize) + "," + arrowH,
        E = "L" + ((i == 0 ? 0 : steps[i - 1] + circleSize) + arrowPunta) + "," + arrowH,
        F = "L" + (i == 0 ? 0 : steps[i - 1] + circleSize) + "," + arrowH / 2;


      /* variabili per i disegni */

      var labelPosX = (i == 0 ? 0 : steps[i - 1]) + circleSize + arrowPunta;
      if (i == 0 || parseInt(formProp.layout_step) > steps[i - 1]) { /* Step precedente */
        // arrowColor = "#00BCD4";
        // textColor = "#FFFFFF";
        arrowColor = "#D5D5D5";
        textColor = "#000000";
      } else if (parseInt(formProp.layout_step) == steps[i - 1]) { /* Step successivo*/
        arrowColor = "#00A0BD";
        textColor = "#FFFFFF";
      } else {
        arrowColor = "#D5D5D5";
        textColor = "#000000";
      }
      if (parseInt(formProp.layout_step) == steps[i] /* && i != 0 */) { /* Step corrente */
        // arrowColor = "#00BCD4";
        circleColor = "#00A0BD";
      } else {
        circleColor = "#999999";
      }
      if (i == steps.length - 1) { /* step default */

        B = "L" + (steps[i] - circleSize) + ",0",
          C = "L" + (steps[i] - circleSize) + "," + arrowH / 2,
          D = "L" + (steps[i] - circleSize) + "," + arrowH,

          // arrowColor = arrowColor +"#FFFFFF"
          arrowColor = "0-" + arrowColor + ":60-#FFFFFF:80-#FFFFFF:100"
      }

      raphael.setStart();
      raphael.path("M" + A + B + C + D + E + F + "L" + "z")
        .attr({
          "stroke": "none",
          "fill": arrowColor
        });

      raphael.text(labelPosX, 4, (i == 0 ? 'Min. Width ' + steps[i] : steps[i - 1]))
        .attr({
          "stroke": 'none',
          "fill": textColor,
          'text-anchor': 'start',
          'font-size': '8',
          'font-family': 'Open Sans',
          'font-weight': 600
        }).toFront();
      if (i < steps.length - 1) {
        raphael.circle(steps[i], circleSize, circleSize)
          .attr("fill", circleColor)
          .attr("stroke", "none")
          .attr("title", "Go to " + steps[i] + " layout step");
      }
      if (i != 0) {
        var set = raphael.setFinish()
          .attr("cursor", "pointer");
        set.step_tmp = steps[i - 1];
        set.click(function () { /* click su ogni elemento del set*/
          var oldVal = formProp.layout_step;
          document.getElementById('Form_generic_layout_step').value = this.step_tmp;
          formProp.layout_step = this.step_tmp.toString();
          updateLayoutSteps(oldVal, this.step_tmp);
          FormProperties(true);
          // document.getElementById('Form_generic_layout_step').fireEvent('onchange');
        }.bind(set))
      }
    }
    document.getElementById("handler").setStyle("display", "none")
    /* visualizzazione con iconFont */
    /*
  document.getElementById('layoutSteps').setStyle('width', document.getElementById('backcanvas').getSize().x+10);
  var steps = formProp.steps.split(',');
  steps.sort();
  for(var i=0; i<steps.length;i++ ){
    document.getElementById('layoutSteps').setStyle('width', parseInt(steps[i])+10);
    var span = document.createElement("span");
    span.className = "layoutStepPos";
    span.style.width = (i>0?steps[i]-steps[i-1]:steps[i])+"px";
    span.setAttribute("step_tmp", steps[i]);
    span.addEventListener('click', function(event){
      event.stopPropagation();
      var step = this.getAttribute("step_tmp");
      document.getElementById('Form_generic_layout_step').value=step;
      updateLayoutSteps(formProp.layout_step,step);
      formProp.layout_step=step;
      FormProperties(true);
    });
    document.getElementById('layoutSteps').appendChild(span);
  }
  */
  } else {
    document.getElementById("handler").setStyle("display", "block");
  }
}

function resizeGrid(w, h) {
  var form_grid_svg = Ctrl("canvas-grid");
  var form_grid = Ctrl("grid");
  form_grid_svg.setAttribute('width', '100%');
  form_grid_svg.setAttribute('height', h);
  form_grid.setAttribute('width', '100%');
  form_grid.setAttribute('height', h);
}
//riscrive l'HTML e reimposta tutte le proprieta' di tutti gli items
function writeHTML(reset) {
  if (Empty(reset)) reset = false;
  var form = Ctrl("backcanvas");
  var back_form = Ctrl("canvas");
  var backcanvasBorder = document.getElementById('backcanvasBorder');
  var currH = formProp.pagesProp[formProp.page-1].h;
  var currW = formProp.pagesProp[formProp.page-1].w;
  if (formProp.v_line > 0) {
    Ctrl("v_line").style.display = 'block';
    v_line = formProp.v_line;
    Ctrl("v_line").style.transition = 'left 0.3s';
    Ctrl("v_line").style.left = ((formProp.v_line - 0) + form.offsetLeft + back_form.offsetLeft) + 'px';
    Ctrl("v_line").style.height = back_form.offsetHeight - Ctrl('h_ruler').offsetTop + 'px';
  } else {
    v_line = formProp.v_line
    Ctrl("v_line").style.display = 'none'
  }
  var formWidth = 0;
  if (Ctrl("v_line").style.display == 'block' && currW.toString().indexOf('%') > 0) {
    formWidth = (parseInt(Ctrl("v_line").style.left) - back_form.offsetLeft - form.offsetLeft) * (Strtran(currW, '%', '') / 100);
    form.style.transition = 'width 0.3s,height 0.3s';
    backcanvasBorder.style.transition = 'width 0.3s,height 0.3s';;
    form.style.width = formWidth + 'px';
  } else {
    form.style.width =  currW + 'px';
    formWidth = currW;
  }
  //form.style.height =  formProp.h + 'px';
  form.style.height =  currH + 'px';
  //resizeGrid(formWidth, formProp.h);
  resizeGrid(currW, currH);
  if(grapes.Canvas.getBody()) {
    grapes.Canvas.getBody().style.width = formWidth + 'px';
  }

  if (visualMode) {
    document.getElementById("canvas-grid").setStyles({
      'background-color': formProp.color ? formProp.color : '',
      'background-image': formProp.bg_image ? 'url("' + formProp.bg_image + '")' : '',
      'background-size': formProp.bg_image_size ? formProp.bg_image_size : '',
      'background-position': formProp.bg_image_position ? formProp.bg_image_position : '',
      'background-repeat': formProp.bg_image_repeat ? formProp.bg_image_repeat : ''
    });
  }

  backcanvasBorder.style.width = form.style.width; //document.getElementById('backcanvas').getSize().x+'px'
  backcanvasBorder.style.height = form.style.height; //document.getElementById('backcanvas').getSize().y+'px'
  //if (clVRRulersLib) clVRRulersLib.DrawVertical(formProp.h);
  if (clVRRulersLib) clVRRulersLib.DrawVertical(currH);
  if (clHRRulersLib) clHRRulersLib.DrawHorizontal(formWidth); //spostato nella renderLayout_Steps
  renderLayout_Steps();
  if (formProp['lock_items'] == 'true')
    lockItems = true;
  else
    lockItems = false;
  if (reset) {
    Ctrl("canvasitems").innerHTML = "";
    Ctrl("canvasitems").style.height = "0px"
    removeAllHandlers()
  }
  //Aggiunge l'HTML ai controls
  var ctrl, ctrlS, currObj, i;
  if (reset) {
    var s = Ctrl("canvasitems").innerHTML
    for (i = 0; i < itemsHTML.length; i++) {
      s += itemsHTML[i].html
    }
    Ctrl("canvasitems").innerHTML = s
  }
  i = 0;
  if (!reset && index != null) { //c'e' un item selezionato
    ctrlS = Ctrl('shadow' + itemsHTML[index].id.substr(4));
    i = index;
  }
  if (formProp.hsl == 'true')
    canAlign = false; // Disabilita le SnapLines
  else
    canAlign = true;

  //WireFrame in caso di tabs
  if (document.getElementById('form_tabs'))
    document.getElementById('form_tabs').destroy();
  if (formProp.npages > 1) {
    back_form.classList.add('tabbed');
    var tabC = document.createElement('div');
    tabC.className = "tabstrip" + (formProp.wizard == 'true' ? " wizard" : "");
    tabC.id = 'form_tabs';
    for (var ii = 0; ii < formProp.npages; ii++) {
      var tab = document.createElement('div');
      tab.className = "tab";
      tabC.appendChild(tab);
      if(ii == formProp.page-1){
        tab.setAttribute('data-selected','true');
      }else{
        tab.setAttribute('data-selected','false');
      }
    }
    form.insertBefore(tabC, form.firstChild);
  }
  //Wireframe del titolo
  if (document.getElementById('form_title'))
    document.getElementById('form_title').destroy();
  if (!Empty(formProp.title) && formProp.title != 'none') {
    back_form.classList.add('titled');
    var titleC = document.createElement('div');
    titleC.id = 'form_title';
    titleC.className = 'form_titled';
    titleC.innerText = 'Portlet Title';
    form.insertBefore(titleC, form.firstChild);
  } else {
    back_form.classList.remove('titled');
  }
  for (; i < itemsHTML.length && !itemsHTML[i].variant ; i++) {
    if (!reset && index != null && i > index ) break; // Aggiorno solo il selezionato
    currObj = itemsHTML[i];
    ctrl = Ctrl(currObj.id);
    ctrl.title = currObj.name;
    ctrl.style.display = "none";
    ctrl.offsetHeight;
    if (reset)
      ctrl.style.transition = '';
    else
      ctrl.style.transition = 'all 0.3s';
    if (currObj.page == formProp.page) {
      ctrl.style.display = "block"
      if ( mode != "GRAPES" ) {
        var current_W = (currObj.w - getOffset(ctrl).gapw);
        var current_H = (currObj.h - getOffset(ctrl).gaph);
        if (current_H < 0) current_H = currObj.h;
        if (current_W < 0) current_W = currObj.w;
        var anchor = currObj.anchor;
        if (Empty(anchor)) anchor = 'top-left';
        if (formProp.adaptive == 'true') anchor = 'top-left(%)-right(%)';
        ctrl.style.left = currObj.x + 'px';
        ctrl.style.top = currObj.y + 'px';
        ctrl.style.width = current_W + 'px';
        ctrl.style.height = current_H + 'px';
        ctrl.dataset.psName = currObj.name;
        //muovo la shadow se l'item e' selected
        if (ctrlS != null && i == index) {
          if (!Empty(ctrl.style.left)) ctrlS.style.left = currObj.x + 'px';
          if (!Empty(ctrl.style.right)) ctrlS.style.right = currObj.x + 'px';
          ctrlS.style.top = currObj.y + 'px';
          ctrlS.style.width = (current_W) + 'px' //-getOffset(ctrlS).gapw)+'px';
          ctrlS.style.height = (current_H) + 'px' //-getOffset(ctrlS).gaph)+'px';
        }
        if (typeof (currObj.zindex) != 'undefined') ctrl.style.zIndex = currObj.zindex
      }
      var objClass = currObj[currObj.type + 'Class'] || currObj.objClass;

      //Wireframe specificato nell'oggetto objClass
      var ctrl_src;
      if (objClass.wireframe) {
        ctrl.innerHTML = objClass["wireframe"](currObj, visualMode);
        if( grapes.getSelected() ){
          // if( currObj.value ){
          // grapes.getSelected().set("content", objClass["wireframe"](currObj, visualMode));
        }
      } else if (currObj.hidden) {
        //"<input class='Textbox' type='text' value='"+obj.name+"' disabled/>";
        if (ZTObjects[currObj.type + 'ObjClass']) {
          if (!ZTObjects[currObj.type + "ObjClass"].names) continue;
          ctrl_src = ZTObjects[currObj.type + "ObjClass"].names[1];
        } else {
          ctrl_src = ZTObjects[currObj.type + "Class"].names[1];
          if (!ZTObjects[currObj.type + "Class"].names) continue;
        }
        ctrl.innerHTML = '<div class="labelName"><img class=' + currObj.type + ' src=\'' + ctrl_src + '\' /><span>' + currObj.name + '</span></div>';
      } else {
        //Wireframe di default
        if (ZTObjects[currObj.type + 'ObjClass']) {
          if (!ZTObjects[currObj.type + "ObjClass"].names) continue;
          ctrl_src = ZTObjects[currObj.type + "ObjClass"].names[1];
        } else {
          ctrl_src = ZTObjects[currObj.type + "Class"].names[1];
          if (!ZTObjects[currObj.type + "Class"].names) continue;
        }
        var ctrl_css = '<style>\n' +
          '.' + currObj.type + ' {\n';
        if (currObj.w >= currObj.h) {
          ctrl_css += 'height: 100%;\n' +
            'width: auto;\n' +
            'display:block;margin:0 auto;\n';
        } else {
          ctrl_css += 'width: 100%;\n' +
            'height: auto;\n';
          //'position:absolute;\n'+
          //'top:30%;\n';
        }
        ctrl_css += '}\n' +
          '</style>';
        var ctrl_html = '<img class=' + currObj.type + ' src=\'' + ctrl_src + '\' />';
        ctrl.innerHTML = ctrl_css + ctrl_html;
      }
      if( grapes.getSelected() ){
        grapes.getSelected().set("content", currObj.name);
        grapes.getSelected().attributes.attributes.name = currObj.name;
      }
    }
  }
  setShadow();
}

function moveVLine() {
  var form = Ctrl("backcanvas");
  v_line = formProp.v_line;
  Ctrl("v_line").style.left = ((formProp.v_line - 0) + form.offsetLeft + Ctrl("canvas").offsetLeft) + 'px';
  Ctrl("v_line").style.height = Ctrl('canvas').offsetHeight - Ctrl('h_ruler').offsetTop + 'px';
}

function deleteItem() {
  if (index != null) {
    var tmp = new Array();
    var tmpn = 0;
    var mainItem = itemsHTML[index];
    for (var i = 0; i < itemsHTML.length; i++) {
      var itm_tmp = itemsHTML[i];
      if (itm_tmp.shadow == "") { // sposta gli elementi non selezionati in tmp
        tmp[tmpn++] = itm_tmp;
      } else {
        if( current_variant && itm_tmp.ctrlOfVariant != current_variant ){
          // keep base Ctrl but remove markup
          tmp[tmpn++] = itm_tmp;
        } else {
          undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj(null, 'delete', null, null, null, null, itm_tmp) // salvo gli oggetti cancellati per UNdo
          //lo cancello dall'HTMLMode e dal GrapesMode

          const regex = new RegExp("\\{\\{\\s*(@" + itm_tmp.name + ")\\s*\\}\\}");
          var code = codeEditor.getValue().replace(regex, "");
          codeEditor.setValue(code);
          codeEditor.refresh();
          let to_rem = grapes.getComponents().toArray().find( el => el.getAttributes().name == itm_tmp.name )
          if( to_rem ){
            to_rem.remove();
          }
          /**
           * Rimuove l'item dalla combo
           */
          to_rem = document.querySelector("#hidden_ctrl_combo option[value="+itm_tmp.name+"]");
          if( to_rem ){
            let group = to_rem.parentElement;
            group.removeChild(to_rem);
            if(!group.hasChildNodes()){
              group.parentElement.removeChild(group);
            }
            jQuery("#hidden_ctrl_combo").trigger("change");
          }
          to_rem = document.querySelector("#visible_ctrl_combo option[value="+itm_tmp.name+"]");
          if( to_rem ){
            let group = to_rem.parentElement;
            group.removeChild(to_rem);
            if(!group.hasChildNodes()){
              group.parentElement.removeChild(group);
            }
            jQuery("#visible_ctrl_combo").trigger("change");
          }
        }
      }
      //Cancello le proprieta' collegate all'elemento cancellato
      if (mainItem.objClass.connector && itm_tmp.objClass.connector) {
        for (var ii = 0; ii < itm_tmp.objClass.connector.length; ii++) {
          for (var iii = 0; iii < mainItem.objClass.connector.length; iii++) {
            if (itm_tmp['name'] != mainItem['name'] && itm_tmp.objClass.connector[ii]['type'] == mainItem.objClass.connector[iii]['type'] && itm_tmp.objClass.connector[ii]['propID'] && itm_tmp[itm_tmp.objClass.connector[ii]['propID']] == mainItem['name'] && itm_tmp.objClass.connector[ii]['versus'] != mainItem.objClass.connector[iii]['versus'])
              itm_tmp[itm_tmp.objClass.connector[ii]['propID']] = ''; //Svuoto la proprieta' che fa riferimento all'elemento cancellato
          }
        }
      }

    }
    indexUndo++;
    undoSequence[indexUndo] = undoItemsMoved
    CheckUndoSize()
    undoItemsMoved = []
    countindex = tmpn
    itemsHTML = tmp
    index = null
    last_index = null
    writeHTML(true)
    Properties();
    newPropObj.HideProperties();
  }
}

var actioncode = "";
var ItemEventInput;
var ActionCodeLayer;
var codeOpen = false;
const reactive_name_pattern = /{{\s*#(reactive|browser)\s*(?<template_name>\w*)\s*}}/gm;
function editItemEvent() {
  window.ACitemsHTML = itemsHTML.slice(0);
  ItemEventInput = [itemsHTML, index, actioncode, formProp];
  //var dialogValue
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style) && !Empty(ac_style.height) ? ac_style.height : 600)
  ac_style.width = (!Empty(ac_style) && !Empty(ac_style.width) ? ac_style.width : 880)
  ac_style.maximized = (!Empty(ac_style) && typeof (ac_style.maximized) != 'undefined' ? ac_style.maximized : false)
  localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
  ActionCodeLayer = new spModalLayer('editItemEvent.htm', {
    'in_iframe': true,
    'draggable': false,
    'top':0,
    'left':0,
    'width': ac_style.width,
    'height': ac_style.height,
    'resizable': true,
    'border_color': '#CCCCCC',
    'border_width': 1,
    'dragger_height': 0,
    'dragger_image': 'images/ps-editor-drag.png',
    'mask_opacity': 0.4,
    'mask_color': '#CCCCCC',
    'show_scrollbars': false,
    'close_on_click_mask': '',
    'iframe_padding': 0,
    'hide_close_btn': true,
    'maximize': true,
    'maximized': true,
    'opener': window
  });
  ActionCodeLayer.open();
  codeOpen = true;
  /**
   * Analisi del codice HTML per trovare eventuali tag reactive per definire l'evento rendered
   */
  if( mode == "HTML" ){
    let html = codeEditor.getValue();
    let m;
    while ((m = reactive_name_pattern.exec(html)) !== null) {
      // This is necessary to avoid infinite loops with zero-width matches
      if (m.index === reactive_name_pattern.lastIndex) {
        reactive_name_pattern.lastIndex++;
      }
      if( !Empty(m.groups.template_name) ) {
        ACitemsHTML.push( new ZTObjects['TemplateObj']('', m.groups.template_name, 'Template', '', '', '', 0, 0, 0, 0, ''));
      }
    }
  }
}
var codeManifest = '';
//var ManifestCodeLayer;
function EditManifest(id) {
  //var dialogValue
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style) && !Empty(ac_style.height) ? ac_style.height : 600)
  ac_style.width = (!Empty(ac_style) && !Empty(ac_style.width) ? ac_style.width : 880)
  ac_style.maximized = (!Empty(ac_style) && typeof (ac_style.maximized) != 'undefined' ? ac_style.maximized : false)
  localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
  ActionCodeLayer = new spModalLayer('editManifest.htm?name=' + document.getElementById(id).value, {
    'in_iframe': true,
    'draggable': true,
    // 'top':40,
    // 'left':20,
    'width': ac_style.width,
    'height': ac_style.height,
    'resizable': true,
    'border_color': '#CCCCCC',
    'border_width': 1,
    'dragger_height': 12,
    'dragger_image': 'images/ps-editor-drag.png',
    'mask_opacity': 0.4,
    'mask_color': '#CCCCCC',
    'show_scrollbars': false,
    'close_on_click_mask': '',
    'iframe_padding': 0,
    'hide_close_btn': true,
    'maximize': true,
    'maximized': ac_style.maximized,
    'opener': window
  });
  ActionCodeLayer.open();
  codeOpen = true;
}

function EditTemplate(obj) {
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style) && !Empty(ac_style.height) ? ac_style.height : 600)
  ac_style.width = (!Empty(ac_style) && !Empty(ac_style.width) ? ac_style.width : 880)
  ac_style.maximized = (!Empty(ac_style) && typeof (ac_style.maximized) != 'undefined' ? ac_style.maximized : false)
  localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
  ActionCodeLayer = new spModalLayer('editTemplate.htm?propID=' + obj.refPropId, {
    'in_iframe': true,
    'draggable': true,
    // 'top':40,
    // 'left':20,
    'width': ac_style.width,
    'height': ac_style.height,
    'resizable': true,
    'border_color': '#CCCCCC',
    'border_width': 1,
    'dragger_height': 12,
    'dragger_image': 'images/ps-editor-drag.png',
    'mask_opacity': 0.4,
    'mask_color': '#CCCCCC',
    'show_scrollbars': false,
    'close_on_click_mask': '',
    'iframe_padding': 0,
    'hide_close_btn': true,
    'maximize': true,
    'maximized': ac_style.maximized,
    'opener': window
  });
  ActionCodeLayer.open();
  codeOpen = true;
}

function Copy(cut) {
  var deftmp = [];
  var i, valuetosave;
  for (i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow != "") {
      //if(itemsHTML[i]==itemsHTML[index]){
      // setPropertiesID(itemsHTML[i]);
      var ctrl = itemsHTML[i];
      var PropObj = setPropertiesObj(itemsHTML[i]);
      var JsonItem = {
        type: ctrl.type
      };
      //deftmp+='type||'+ctrl.type
      for (var u = 0; u < PropObj.length; u++) {
        var prop = PropObj[u]['propID'];
        valuetosave = ctrl[prop];
        //for(u=0;u<ctrl.objClass.properties.length;u++){
        if (typeof (valuetosave) != 'number') {
          if (typeof (valuetosave) == 'undefined' || valuetosave == "") valuetosave = ' ' // se la prop e' undefined allora la salvo come ' '
        }
        if (typeof (valuetosave) == 'object')
          valuetosave = JSON.stringify(ctrl[prop]);
        JsonItem[prop] = valuetosave
        //eval('deftmp+="||'+ctrl.objClass.properties[u]+'||"+valuetosave')
      }
      //deftmp+='|||'
      deftmp.push(JsonItem);
    }
  }
  if (cut) deleteItem();
  return JSON.stringify(deftmp);
}
// funzioni di che interagiscono con il server ######################
function sortSequence(a, b) {
  var a_seq = a.sequence;
  if (Empty(a_seq)) a_seq = null;
  var b_seq = b.sequence;
  if (Empty(b_seq)) b_seq = null;
  if (a_seq != null && b_seq == null) return -1;
  if (a_seq == null && b_seq != null) return 1;
  if (parseInt(a_seq) > parseInt(b_seq)) return 1;
  if (parseInt(a_seq) < parseInt(b_seq)) return -1;
  if (a_seq == b_seq) {
    if (parseInt(a.id.substring(4)) > parseInt(b.id.substring(4)))
      return 1;
    else
      return -1
  }
}
var saving
var savingpic
var old_name;
var AfterSave
var newPorlet = false;

function save(then, saveObj ) {
  if (codeOpen) {
    if (ActionCodeLayer)
      ActionCodeLayer.getContainer().getElement('iframe').contentWindow.dispatchEvent(new Event('save'));
  }
  if (then == 'close') AfterSave = 'close';
  else if (!Empty(then)) { //then e' un oggetto che contiene una funzione che deve essere eseguita dopo il salvataggio
    AfterSave = then;
  }
  if (document.activeElement.tagName == 'INPUT') {
    var activeE = document.activeElement;
    activeE.blur();
    activeE.focus();
  }
  if (parent) parent.is_Saving = true;
  if ( saveObj ){
    variants[current_variant].name = saveObj.name; //variants.getNameFromFolderPath(saveObj.name,saveObj.folder_path);
    variants[current_variant].folder_path = saveObj.folder_path;
    buildVariantSelect(false);
    jQuery("#variant_container").val(current_variant);
    jQuery("#variant_container").trigger("change");
  }
  if (currentname == "" ||  (mode == "HTML" && current_variant > 0 && variants[current_variant].name == "New") ) {
    newPorlet = true;
    window.parent.saveAsTool(!Empty(formProp.altInterfaceFor)? "interfaces" : currentname == "" || mode != "HTML" ? null : "variant");
  } else {
    if (!notimooManager) {
      notimooManager = new Notimoo({});
    }
    notimooManager.show({
      title: 'Notification message',
      message: 'saving portlet...',
      sticky: true,
      width: 200,
      height: 40
    });
    //Salva le proprieta' multiple
    updateAllLayoutSteps();
    save2.delay(100);
  }
}

function setPropertiesObj(obj) { //ricreo un oggetto per compatibilita' con il vecchio array properties
  var PropObj = new Array();
  var mainObject = obj;
  var i;
  if (obj.objClass.newProperties) {
    if (obj.type.toLowerCase() == "chart") {
      // quando viene salvato il portlet senza cliccare sul chart, i fields devono essere mappati correttamente
      if (mainObject.objClass._GetChartProps)
        mainObject.objClass._GetChartProps(obj.ctype, obj.chart_type);
    }
    for (i in mainObject.objClass.newProperties) {
      var tab = mainObject.objClass.newProperties[i];
      for (var ii = 0; ii < tab.length; ii++) {
        PropObj.push(tab[ii]);
      }
    }
  } else { //compatibilita' con Properties vecchie
    for (i = 0; i < mainObject.objClass.properties.length; i++) {
      PropObj.push({
        'propID': mainObject.objClass.properties[i]
      });
    }
  }
  return PropObj;
}

function save2() {
  var output;
  var valuetosave, typevar, prop;
  var i, u;
  request_parms = {};
  itemsHTML.sort(sortSequence)
  // creo un Array di oggetti con le prop vecchie e nuove
  var PropObj = setPropertiesObj(formProp);
  //setPropertiesID(formProp);
  //Formato JSON
  var JSONItems = [];
  var JsonFormItem = {
    type: 'Form',
    title: ''
  }
  variants.saveVariantProp();
  if (newPorlet) JsonFormItem['version'] = version;
  //var strsave='type||Form||title|| ';
  var JDef = '';
  //Legge il Form
  for (u = 0; u < PropObj.length; u++) {
    prop = PropObj[u]['propID'];
    valuetosave = formProp[prop];
    //if(typeof(valuetosave)=='string'){
    if (typeof (valuetosave) == 'undefined' || valuetosave == "") {
      valuetosave = ' ';
    }
    //}
    if (prop != 'page') {
      //strsave+="||"+prop+"||"+valuetosave;
      if (typeof (valuetosave) == 'string')
        JsonFormItem[prop] = Trim(valuetosave);
      else
        JsonFormItem[prop] = valuetosave;
    }
    if (prop == 'layout_steps_values') {
      JsonFormItem['layout_steps_values'] = JSON.stringify(valuetosave);
    }
    if (prop == 'pagesProp') {
      JsonFormItem['pagesProp'] = JSON.stringify(valuetosave);
    }
  }

  JsonFormItem['css_code'] = JSON.stringify(classCssObj);
  JsonFormItem['htmlcode'] = codeEditor.getValue();

  /**
   * Modifica del grapesCode con {{ .. }} per avere una generazione condivisa tra html_mode e grapes_mode
  */
  var frag = document.createDocumentFragment(),
    frag_div = document.createElement('div'),
    grapescode = grapes.getHtml();

  frag_div.innerHTML = grapescode;
  frag.appendChild(frag_div);
  [].forEach.call( frag_div.querySelectorAll("psctrl"), function(el) {
    grapescode = grapescode.replace( el.outerHTML, "{{ @" + el.getAttribute("name") + " }}");
  });
  frag.removeChild(frag_div);


  JsonFormItem['grapesCode'] = grapescode;
  /**
   * Ripulisco il css
   */
  grapes.setStyle(grapes.getStyle().map( function(el) {
    if( el.attributes.selectorsAdd == "*" || el.attributes.selectorsAdd == "body") {
      el.attributes.style = {};
      el._changing = true;
    }
    return el;
  }));

  JsonFormItem['grapesCss'] = grapes.getCss({avoidProtected:true});
  if (formProp['offline'] == 'true') {
    //strsave+="||codemanifest||"+JSON.stringify({codemanifest:codeManifest});
    JsonFormItem['codemanifest'] = JSON.stringify({
      codemanifest: codeManifest
    });
  }


  JsonFormItem['included_font'] = JSON.stringify(formProp.included_font);
  //strsave+=actioncode;
  JsonFormItem['actioncode'] = actioncode;
  JsonFormItem['mode'] = mode;
  formProp.included_font = [];
  //strsave+='|||';
  //Legge i Ctrls
  for (i = 0; i < itemsHTML.length; i++) {

    var ctrl = itemsHTML[i];
    /**
     * aggiungo solo i cltr della variante corrente
     */
    if( !!current_variant &&  ctrl.ctrlOfVariant != current_variant ) continue;
    var ctrl_name = ctrl.name
    //strsave+='type||'+ctrl.type;
    var JsonItem = {
      type: ctrl.type
    };
    PropObj = setPropertiesObj(ctrl);
    if (!Empty(ctrl.included_font)) {
      for (var ii = 0; ii < ctrl.included_font.length; ii++) {
        var font_found = false;
        for (var iii = 0; iii < formProp.included_font.length && !font_found; iii++) {
          if (formProp.included_font[iii].name == ctrl.included_font[ii]) font_found = true;
        }
        if (!font_found) {
          formProp.included_font.push(ctrl.included_font[ii]);
        }
      }
    }

    for (u = 0; u < PropObj.length; u++) {
      // if(typeof(PropObj[u].deprecated)!='undefined' && PropObj[u].deprecated==true)
      // continue;
      prop = PropObj[u]['propID'];
      valuetosave = ctrl[prop];
      typevar = ctrl['typevar'];
      if (!Empty(valuetosave) && LRTrim(valuetosave.toString()) == 'request') {
        request_parms[ctrl_name] = (!Empty(typevar) ? (typevar == 'datetime') ? 'T' : Left(typevar, 1).toUpperCase() : 'C');
      } else if (!Empty(valuetosave) && valuetosave.toString().indexOf('request:') > -1) {
        request_parms[LRTrim(Strtran(valuetosave, 'request:', ''))] = (!Empty(typevar) ? (typevar == 'datetime') ? 'T' : Left(typevar, 1).toUpperCase() : 'C');
      }
      if (typeof (valuetosave) == 'string' && valuetosave.indexOf('|') > -1) valuetosave = Strtran(valuetosave, '|', '$|$');
      if (typeof (valuetosave) == 'undefined' || (typeof (valuetosave) == 'string' && valuetosave == "")) valuetosave = ' ';
      //in caso di || all interno del valore lo coverto per non rompere il def
      //strsave+="||"+prop+"||"+valuetosave;
      if (typeof (valuetosave) == 'string')
        JsonItem[prop] = Trim(valuetosave);
      else
        JsonItem[prop] = valuetosave;
    }
    if ('spuid' in ctrl) {
      //strsave+='||spuid||'+ctrl.spuid;
      JsonItem['spuid'] = ctrl.spuid;
    }
    if ('page' in ctrl) {
      //strsave+='||page||'+ctrl.page;
      JsonItem['page'] = ctrl.page;
    }
    //Le proprieta' multiple in String
    if ('layout_steps_values' in ctrl)
      JsonItem['layout_steps_values'] = JSON.stringify(ctrl['layout_steps_values']);
    //strsave+='|||';
    JSONItems.push(JsonItem);
  }
  JsonFormItem['included_font'] = JSON.stringify(formProp.included_font);
  if( mode == "HTML" && current_variant > 0 ){
    JsonFormItem = ['type', 'mode', 'css_code', 'actioncode', 'htmlcode', 'my_library', 'css', 'css_class', 'form_type']
    .reduce(  (acc,k) => {
      acc[k] = JsonFormItem[k];
      return acc;
    }, {});
    JsonFormItem['htmlvariant'] = true;
    JsonFormItem['base'] = currentname.substring(currentname.lastIndexOf("/") + 1);
  }
  JSONItems.unshift(JsonFormItem);
  /*In questo modo salva il def in JSON*/
  JDef = JSON.stringify(JSONItems, function (s, v) {
    if (typeof (v) === 'undefined') return null;
    if (typeof (v) != 'object') return v.toString();
    else return v;
  });

  var portlet_name = currentname.substring(currentname.lastIndexOf("/") + 1);
  currentname = Strtran(currentname, '\\', "/");
  if (currentname.indexOf('/') > -1) {
    folder_path = currentname.substring(0, currentname.lastIndexOf("/"));
  }
  //Quando si aggiunge e si toglie la proprietÃ  altInterfaceFor il portlet diventa una interface e cambia il path
  if(folder_path.indexOf('jsp-interfaces')==-1 && !Empty(formProp['altInterfaceFor'])){
    folder_path = '../jsp-interfaces/'+ formProp['altInterfaceFor']+ '/' ;
  }else if(Empty(formProp['altInterfaceFor']) && folder_path.indexOf('/jsp-decorators') == -1 &&  folder_path.indexOf('/jsp-system') == -1){
    //Ritono a portlet normale
    folder_path = '';
  }

  // if (folder_path.indexOf('jsp-decorators') > -1) {
  //   folder_path = (Left(folder_path, 1) != '/' ? '/' : '') + folder_path.substring(0, folder_path.lastIndexOf("/"))
  // }
  if (formProp['altInterfaceFor'])
    currentname = formProp['altInterfaceFor'] + '/' + portlet_name
  else currentname = (Right(folder_path,1)=='/' ? folder_path : (!Empty(folder_path)?folder_path+'/':'') ) + portlet_name;
  //In modalità stand alone se cambio il nome devo controllare l'esistenza
  if ( standalone && ( Empty(old_name) || old_name != currentname )){
    let url = new JSURL("../servlet/JSPReader?type=interfaces&name="+ portlet_name +"&folder_path="+ ( Strtran(folder_path,'../jsp-interfaces','') ) +"&check=true&&custom="+ formProp['custom'] ,true);
    output=url.Response();
    if(output=="found"){
      if(!confirm("File already existing overwrite?")){
        for (let i = 0; i < notimooManager.elements.length; i++) {
          notimooManager.close(notimooManager.elements[i]);
        }
        return;
      }
    }
  }

  var url = new JSURL("../servlet/JSPSave?type="+ ( mode == "HTML" && current_variant > 0 ? 'variant' : 'portlet' )+
    "&name=" + ( mode == "HTML" && current_variant > 0 ?  variants.getName(variants[current_variant].name) :  (window.saveForGroup.length>0 ? getBaseInterfaceNameFor(portlet_name) +'_g' + window.saveForGroup : portlet_name)) +
      (m_nFrontendPort ? "&frontendport=" + m_nFrontendPort : "") +
      "&folder_path=" + ( mode == "HTML" && current_variant > 0 ?  variants[current_variant].folder_path :  folder_path) +
      "&def=" + URLenc(JDef) +
      "&offline=" + formProp['offline'] +
      (!Empty(formProp['altInterfaceFor']) ? '&altInterfaceFor=' + formProp['altInterfaceFor'] + '&custom=' + formProp['custom'] : '' ) +
      ( mode == "HTML" && current_variant > 0 ? '&variantFor=' + portlet_name : '' ) +
      (!Empty(codeManifest) ? "&customManifest=" + URLenc(formProp['manifest']) : "") +
      "&m_cID=" + ( mode == "HTML" && current_variant > 0 ? cmdhash2 : cmdhash )
      , true);
  output = url.Response();

  if(!standalone){
    if(folder_path.indexOf('jsp-interfaces') > -1){
      parent.opensApl[parent.currentIndex].type ='interfaces';
    }else if(folder_path.indexOf('jsp-decorators') > -1){
      parent.opensApl[parent.currentIndex].type ='decorators';
    }else{
      parent.opensApl[parent.currentIndex].type ='portlet';
    }
  }
  if (window.parent.changeName) window.parent.changeName(portlet_name, folder_path, Strtran(window.frameElement.id, 'portalstudioframe', ''))
  if (output == null) output = ""
  switch (output) {
    case "true":
      for (let i = 0; i < notimooManager.elements.length; i++) {
        notimooManager.close(notimooManager.elements[i]);
      }
      if (formProp.positioning == 'float') {
        notimooManager.show({
          title: 'Notification message',
          message: 'If you select the float position mode is not possible to set the anchors and steps !',
          visibleTime: 12000,
          width: 300
        });
      }
      notimooManager.show({
        title: 'Notification message',
        message: 'portlet saved!',
        visibleTime: 2000,
        width: 200
      });
      if(!Empty(formProp.altInterfaceForSection)) {
        let target = 'target=' + formProp.altInterfaceFor;
        let zone = 'zone=' + formProp.altInterfaceForSection;
        let portlet = 'portlet=' + getBaseInterfaceNameFor(portlet_name) + '_portlet.jsp';
        let group = window.saveForGroup.length>0 ? 'saveForGroup=' + window.saveForGroup : "";
        let useRoot = window.useRoot.length>0 ? 'm_cUseRoot=' + window.useRoot : 'm_cUseRoot=false';
        let saveRequest = new JSURL('../servlet/SPAltInterfaceProxy?action=write&' + [target,zone,portlet, group, useRoot].join('&'));
        let response = JSON.parse(saveRequest.Response());
        notimooManager.show({
          title: 'Notification message',
          message: response.result,
          visibleTime: 2000,
          width: 200
        });
      }
      if(window.saveForGroup.length>0) {
        let target = 'target=' + formProp.altInterfaceFor;
        let zone = 'zone=' + window.zone;
        let portlet = 'portlet=' + getBaseInterfaceNameFor(portlet_name) + '_portlet.jsp';
        let group = window.saveForGroup.length>0 ? 'saveForGroup=' + window.saveForGroup : '';
        let useRoot = window.useRoot.length>0 ? 'm_cUseRoot=' + window.useRoot : 'm_cUseRoot=false';
        let saveRequest = new JSURL('../servlet/SPAltInterfaceProxy?action=write&' + [target,zone,portlet, group, useRoot].join('&'));
        let response = JSON.parse(saveRequest.Response());
        notimooManager.show({
          title: 'Notification message',
          message: response.result,
          visibleTime: 2000,
          width: 200
        });
      }
      if (Empty(old_name) || old_name != currentname)
        window.location.href = SPWebRootURL + '/visualweb/editor.jsp?id=' + (currentname + (mode == "HTML" && current_variant > 0 ? "&variant=" + variants[current_variant].name + "&folder_path=" + variants[current_variant].folder_path: "" ) + (formProp['altInterfaceFor'] ? "&altInterface=true&custom=" + formProp['custom'] : ""));
      m_bUpdated = false
      if (typeof (window.opener) != "undefined") {
        try {
          window.opener.document.getElementById('zones_Id').submit()
        } catch (e) { }
      }
      if (AfterSave == "close") window.parent.closeCurrentObj();
      else if (!Empty(AfterSave)) {
        AfterSave();
        AfterSave = null;
      }
      formProp['version'] = version;
      //FormProperties();
      newPorlet = false;
      break;
    case "ACCESS DENIED":
      notimooManager.close(notimooManager.elements[0]);
      alert("Access Denied.")
      break;
    case "LICENSE LIMIT":
      notimooManager.close(notimooManager.elements[0]);
      alert("Licensed User Limit Reached.")
      break;
    default:
      notimooManager.close(notimooManager.elements[0]);
      alert("Save routine failed.")
      break;
  }
  if (parent) parent.is_Saving = false;
  has_saved = true;
}

function getBaseInterfaceNameFor(name) {
  name = name.replace(/_g[0-9]+$/, "");
  name = name.replace(/_[0-9]+$/, "");
  return name;
}

function reload() {
  var url
  var GET_DATA = LibJavascript.ReadGetData();
  if (GET_DATA.servlet)
    url = new JSURL("../servlet/" + GET_DATA.id + "?m_cAction=createportlet");
  else if (GET_DATA.altInterface)
    url = new JSURL("../servlet/JSPLoad?type=interfaces&name=" + currentname + "&custom=" + GET_DATA.custom, true);
  else
    url = new JSURL("../servlet/JSPLoad?type=portlet&name=" + currentname, true);
  var strreload = Strtran(url.Response(), '\u0080', '\u20AC');
  strreload = Strtran(strreload, '$>', '%>');
  strreload = Strtran(strreload, '<$', '<%');
  strreload = Strtran(strreload, '$\\u003e', '%\\u003e');
  strreload = Strtran(strreload, '\\u003c$', '\\u003c%');
  return reload_(strreload, false);
}

function Paste(strpaste) {
  if (strpaste != '') return reload_(strpaste, true)
}

function reload_(strreload, paste, merge) {
  var arrayreload, arrayreload2,
    valore, nomeprop, ffieldtype,
    i, t, bb, p,
    imm, imagename, currentItem, type, name, item;
  if (Left(strreload, 1) == '[' || typeof strreload == 'object') { // Def in formato JSON
    var JsonItems ;
    if(Left(strreload, 1) == '['){
      JsonItems = JSON.parse(strreload);
    }else{
      JsonItems = strreload;
    }
    if (!paste) {
      itemsHTML = []
      nitem = 0
      countindex = 0
    }
    Ctrl("canvasitems").innerHTML = ""
    // actioncode = '';
    // codeManifest = '';
    request_parms = {};
    arrayreload = JsonItems;
    //if(! paste && !merge){ // creo l'oggetto Form
    if((!paste || merge) && JsonItems[0].type == 'Form'){ // creo l'oggetto Form
      let formDef = JsonItems.shift();
      actioncode = formDef.actioncode || '';
      codeEditor.setValue(!Empty(formDef.htmlcode)?formDef.htmlcode:'');
      codeManifest = LibJavascript.JSONUtils.IsJsonString(formDef.codemanifest) ? JSON.parse(formDef.codemanifest).codemanifest : null;
      formDef.layout_steps_values = LibJavascript.JSONUtils.IsJsonString(formDef.layout_steps_values) ? JSON.parse(formDef.layout_steps_values) : {};
      formDef.pagesProp = LibJavascript.JSONUtils.IsJsonString(formDef.pagesProp) ? JSON.parse(formDef.pagesProp) : [];
      Object.assign(formProp, formDef);
    }
    if( typeof formProp.htmlmode != "undefined" ){
      formProp.mode = (typeof formProp.htmlmode  == "string" && formProp.htmlmode == "false" || !formProp.htmlmode) ? "NORMAL" : "HTML";
      delete formProp.htmlmode;
    }
    mode = formProp.mode;
    for (i = 0; i < JsonItems.length; i++) {
      var found = false
      item = JsonItems[i]
      if (!Empty(item.sequence)) {
        item.sequence = i + 1; // Partenza da sequence 1
      }
      type = item['type'];
      item.name = Strtran(item.name, ' ', '_');
      name = item.name;
      if (type == 'Toolbar')
        type = 'SPToolbar';
      if (!type) {
        continue;
      }
      if (!ZTObjects[type + 'Obj'] && !ZTObjects[type]) {
        //controllo se l'item e' gia' stato aggiunto
        for (t = 0; t < itemsHTML.length; t++) {
          if (itemsHTML[t].type == type)
            found = true
        }
        if (!found) {
          imagename = ""
          if (!getobj(type + '.edtdef')) {
            b_reload = false;
            return;
          }
          imagename = ZTObjects[type + "Class"].names[0];
          imm = new Element('img', {
            'src': imagename
          }).setStyles({
            'opacity': 0
          }).inject(document.body, 'before');
          imm.type = type;
          imm.imagename = imagename;
          imm.addEventListener('load', function () {
            var type = this.type;
            toolbars.extra.addElement({
              'id': 'right_align',
              'action': {
                'func': 'addItem',
                'par': type
              },
              'image': this.imagename,
              'title': type,
              'draggable': true,
            })
            this.destroy();
          });
        }
      }
      if (paste && !merge ) {
        for (bb = 0; bb < itemsHTML.length; bb++) {
          if (itemsHTML[bb].name == name)
          name += '_Copy';
        }
      }

      putItem(null, b_reload, paste, {
        type: type,
        name: name
      })

      currentItem = itemsHTML[countindex - 1];
      //for(var b=0;b<arrayreload2.length;b++){
      for (nomeprop in item) {
        valore = item[nomeprop];
        //Riconversione per i | presenti nei valore per non rompere il Def
        if (typeof (valore) == 'string' && valore.indexOf('$|$') > -1) valore = Strtran(valore, '$|$', '|');
        if (paste && typeof(valore) == 'string' && valore == " ") valore = "";

        if (paste && !merge && (nomeprop == 'x' || nomeprop == 'y')) {
          valore = (valore - 0) + 10;
        }
        if(paste && merge &&  nomeprop == 'y' ){
          valore = (valore - 0) ;
        }
        if (type == 'Image' && nomeprop == 'themed_image') {
          nomeprop = 'path_type';
          if (valore == 'true') valore = 'themed';
        }
        if (nomeprop == 'page') {
          formProp.npages = Math.max(formProp.npages, valore);
        }
        if (nomeprop == "sequence" && !Empty(valore)) sequence_c = valore;
        if (nomeprop == "sequence" && Empty(valore)) valore = ++sequence_c;
        if (nomeprop == "colProperties" && !Empty(valore)) valore = JSON.stringify(JSON.parse(valore)); //La proprieta' e' un JSON
        if (nomeprop == "layout_steps_values" && !Empty(valore)) valore = JSON.parse(valore); //La proprieta' e' un JSON
        if (nomeprop == "wireframe_props") valore = (currentItem.wireframe_props ? currentItem.wireframe_props : ''); //Leggo sempre la prop inizializzata nell'oggetto

        //retrocompatibilita' per portlet salvati dal 17/05/2015 al 24/03/2016
        if (nomeprop == 'type' && valore == 'Toolbar')
          valore = 'SPToolbar';
        if(nomeprop != 'name'){
          currentItem[nomeprop] = valore;
        }
      }
      //Ciclo per recuperare le variabili in request
      for (p in currentItem) {
        if (!Empty(p) && currentItem[p] && LRTrim(currentItem[p].toString()) == 'request')
          request_parms[currentItem['name']] = (!Empty(currentItem['typevar']) ? (currentItem['typevar'] == 'datetime') ? 'T' : Left(currentItem['typevar'], 1).toUpperCase() : 'C');
        else if (!Empty(p) && currentItem[p] && currentItem[p].toString().indexOf('request:') > -1)
          request_parms[LRTrim(Strtran(currentItem[p], 'request:', ''))] = (!Empty(currentItem['typevar']) ? (currentItem['typevar'] == 'datetime') ? 'T' : Left(currentItem['typevar'], 1).toUpperCase() : 'C');
      }
    }

    let regex = /\{\{\s*@(\w+)\s*\}\}/mg;
    let match;
    var html_items_str = [];
    var html_items_name = [];
    while ((match = regex.exec(formProp.grapesCode)) !== null) {
      html_items_name.push( match[1] );
      html_items_str.push( match[0] );
    }
    /**
     * Ricreo la stringa del ctrl per grapes
     */
    // for (var h = 0; h < html_items.length; h++) {
    //   for( let i=0; i< itemsHTML.length; i++) {
    //     var item = itemsHTML[i];
    //     if( item.name == html_items[h][1]) {
    //       formProp.grapesCode = formProp.grapesCode.replace(html_items[h][0],"<psctrl type="+item.type+" name="+item.name+" index="+i+">"+item.name+"</psctrl>");
    //     }
    //   }
    // }
    for( let i=0; i< itemsHTML.length; i++) {
      let item = itemsHTML[i];
      if( !item.hidden ){
        let j = html_items_name.indexOf(item.name);
        if( j > -1 ) { //il ctrl Ã¨ presente nel codice di grapes
          formProp.grapesCode = formProp.grapesCode.replace( html_items_str[j],"<psctrl type="+item.type+" name="+item.name+" index="+i+">"+item.name+"</psctrl>");
        } else { //altrimenti lo metto in coda
          formProp.grapesCode += "<psctrl type="+item.type+" name="+item.name+" index="+i+">"+item.name+"</psctrl>";
        }
      }
    }

    grapes.setComponents(formProp.grapesCode);
    grapes.setStyle(formProp.grapesCss);

    if (formProp['offline'] == 'true' && !Empty(formProp['manifest']) && formProp['manifest'] != 'Custom manifest') { // Carica il custom manifest
      codeManifest = new JSURL("../servlet/JSPReader?action=manifest&name=" + formProp['manifest'], true).Response();
      formProp['manifest'] = 'Custom manifest';
    }
    //creo la proprietà pages del form
    var pagesArray = [];
    var pagesTitleArray = formProp.pages_names.split(',');
    var pagesLayerArray = formProp.page_layer.split(',');
    var pagesHeightArray = formProp.h.toString().split(',');
    var pagesWidthArray = formProp.w.toString().split(',');
    //creo l'elenco delle pagine numerato crescente
    for(let i=0;i<formProp.npages;i++){
      pagesArray[i] = i+1;
      pagesTitleArray[i] = pagesTitleArray[i]==null ? pagesTitleArray[0]:pagesTitleArray[i];
      pagesHeightArray[i] = pagesHeightArray[i]==null ? pagesHeightArray[0]:pagesHeightArray[i];
      pagesWidthArray[i] = pagesWidthArray[i]==null ? pagesWidthArray[0]:pagesWidthArray[i];
      //pagesLayerArray[i] = pagesLayerArray[i]==null ? pagesLayerArray[0]:pagesLayerArray[i];
    }
    //Creo l'oggetto page se nn presente (portlet vecchi)
    if(formProp.pagesProp.length==0 || formProp.pagesProp.length < formProp.npages){
      for(let i=0;i<formProp.npages;i++){
        if(!formProp.pagesProp[i]){
          formProp.pagesProp.push({
            'title':pagesTitleArray[i],
            'layer': !pagesLayerArray[i]?pagesLayerArray[0]:pagesLayerArray[i],
            'h': !pagesHeightArray[i]?pagesHeightArray[0]:pagesHeightArray[i],
            'w': !pagesWidthArray[i]?pagesWidthArray[0]:pagesWidthArray[i],
            'layout_steps_values': JSON.parse(JSON.stringify(formProp.layout_steps_values))
          }); // oggetto che contiene le prop di una pagina
        }
      }
    }
    formProp.pages = pagesArray.join();
    formProp.pages_names = pagesTitleArray.join();
    formProp.page_layer = pagesLayerArray.join();
    formProp.h = pagesHeightArray.join();
    formProp.w = pagesWidthArray.join();

    //Cerco box layer proveninte da BO (solo nel caso di AltInterface)
    if(!Empty(formProp['altInterfaceFor'])){
      var layer_containers =[]; // Array di object con dell'item box di tipo layer e la nuova pagina creata
      //trovo tutti i potenziali box di tipo layer
      for(let i=0;i<itemsHTML.length;i++){
        let item = itemsHTML[i];
        if(item.hasOwnProperty('container')){
          let check = layer_containers.find(k =>{
            return item.container == k.item.spuid;
          });
          let item_box_layer = itemsHTML.find(k => item.container == k.spuid && k['box_type'] == 'layer' );
          if (!check && item_box_layer){
            layer_containers.push({
              page: formProp.npages+1,
              item: item_box_layer
            });
            //Aggiungo una pagina di tipo layer per ogni box layer trovato
            addPage();
            formProp.pagesProp[formProp.npages-1].layer = 'true';
            formProp.pagesProp[formProp.npages-1].title = layer_containers[layer_containers.length-1].item.title_caption;
            formProp.pagesProp[formProp.npages-1].name =  layer_containers[layer_containers.length-1].item.box_name;
            formProp.pagesProp[formProp.npages-1].h = layer_containers[layer_containers.length-1].item.h ;
            formProp.pagesProp[formProp.npages-1].w = layer_containers[layer_containers.length-1].item.w ;
            let AformPropH = formProp.h.split(',');
            AformPropH[formProp.npages-1] = layer_containers[layer_containers.length-1].item.h;
            formProp.h = AformPropH.join();
            let AformPropW = formProp.h.split(',');
            AformPropW[formProp.npages-1] = layer_containers[layer_containers.length-1].item.w;
            formProp.w = AformPropW.join();
            let AformPropLayer = formProp.page_layer.split(',');
            AformPropLayer[formProp.npages-1] = 'true';
            formProp.page_layer = AformPropLayer.join();
            let AformPropTitle = formProp.pages_names.split(',');
            AformPropTitle[formProp.npages-1] = layer_containers[layer_containers.length-1].item.title;
            formProp.pages_names = AformPropTitle.join();

          }
        }
      }
      //Cambio la page degli elementi dei box layer con la nuova page creata
      //Rimuovo il vecchio oggetto box di tipo layer
      for(let i = 0; i < layer_containers.length; i++){
        let miny = Math.min.apply(Math, itemsHTML.reduce( (acc,o) => {
          if( o.hasOwnProperty('container') && o.container == layer_containers[i].item.spuid ){
            acc.push(parseInt(o.y));
          }
          return acc;
        },[]));
        for(let ii=0;ii<itemsHTML.length;ii++){
          if(itemsHTML[ii].hasOwnProperty('container') && itemsHTML[ii].container == layer_containers[i].item.spuid ){
            itemsHTML[ii].page = layer_containers[i].page;
            //riposiziono gli elementi nella nuova pagina
            itemsHTML[ii].y =  itemsHTML[ii].y - miny + 20;
          }
        }
        //rimuovo il box
        itemsHTML.splice(itemsHTML.findIndex(k => {return k.spuid == layer_containers[i].item.spuid }),1) ;
        countindex--;
      }
      //setCurrentPage(1);
    }
    writeHTML(true);
    FormProperties(true, false);
  } else if (strreload != ' ' && strreload.substring(0, 4) == 'type') { // Vecchio def
    if (!paste) {
      actioncode = ""
      itemsHTML = []
      nitem = 0
      countindex = 0
    } else
      strreload += actioncode
    Ctrl("canvasitems").innerHTML = ""
    ffieldtype = false
    request_parms = {};
    arrayreload = strreload.split('|||')
    for (i = 0; i < arrayreload.length - 1; i++) {
      found = false
      arrayreload2 = arrayreload[i].split('||')
      type = arrayreload2[1]
      name = arrayreload2[3]
      //controllo se l'item e' Added e lo aggiunge alla toolbar e inserisce il codice del nuovo oggetto
      if (type != 'Label' && type != 'Textbox' && type != 'Button' && type != 'SQLDataobj' && type != 'Grid' && type != 'Image' &&
        type != 'Form' && type != 'Tabs' && type != 'Iframe' && type != 'Box' && type != 'SPLinker' && type != 'Chart' && type != 'XMLDataobj' &&
        type != 'Variable' && type != 'Portlet' && type != 'Checkbox' && type != 'Combobox' && type != 'EventEmitter' && type != 'EventReceiver' &&
        type != 'Radio' && type != 'DataMasher' && type != 'StdTreeView' && type != 'Manifest' && type != 'Note' && type != 'HamburgerMenu' && type != 'JSONDataobj') {
        //controllo se l'item e' gia' stato aggiunto
        for (t = 0; t < itemsHTML.length; t++) {
          if (itemsHTML[t].type == type)
            found = true
        }
        if (!found) {
          imagename = ""
          if (!getobj(type + '.edtdef')) {
            b_reload = false;
            return;
          }
          imagename = ZTObjects[type + "Class"].names[0];
          imm = new Element('img', {
            'src': imagename
          }).setStyles({
            'opacity': 0
          }).inject(document.body, 'before');
          imm.type = type;
          imm.imagename = imagename;
          imm.addEventListener('load', function () {
            var type = this.type;
            toolbars.extra.addElement({
              'id': 'right_align',
              'action': {
                'func': 'addItem',
                'par': type
              },
              'image': this.imagename,
              'title': type,
              'draggable': true,
            })
            this.destroy();
          });
        }
      }
      putItem(null, b_reload, paste, {
        type: type,
        name: name
      })
      currentItem = itemsHTML[countindex - 1];
      for (var b = 0; b < arrayreload2.length; b++) {
        nomeprop = arrayreload2[b];
        valore = LRTrim(arrayreload2[b + 1]);
        //Riconversione per i | presenti nei valore per non rompere il Def
        if (valore.indexOf('$|$') > -1) valore = Strtran(valore, '$|$', '|');
        if (i == 0 && !paste) { // proprieta' generiche del form
          if (nomeprop == "codemanifest") {
            valore = JSON.parse(valore).codemanifest;
            codeManifest = valore;
          }
          formProp[nomeprop] = valore;
          b++;
        } else {
          if (paste && (nomeprop == 'x' || nomeprop == 'y')) {
            valore = (valore - 0) + 10;
          }
          if (paste && nomeprop == 'name') {
            for (bb = 0; bb < itemsHTML.length; bb++) {
              if (itemsHTML[bb].name == valore)
                valore += '_Copy'
            }
          }
          if (type == "SQLDataobj" && ffieldtype == false) {
            currentItem.return_fields_type = 'false';
            ffieldtype = true;
          }
          if (type == 'Image' && nomeprop == 'themed_image') {
            nomeprop = 'path_type';
            if (valore == 'true') valore = 'themed';
          }
          if (nomeprop == 'page') {
            formProp.npages = Math.max(formProp.npages, valore);
          }
          if (nomeprop == "sequence" && !Empty(valore)) sequence_c = valore;
          if (nomeprop == "sequence" && Empty(valore)) valore = ++sequence_c;
          currentItem[nomeprop] = valore;
          b++;
        }
      }
      //Ciclo per recuperare le variabili in request
      for (p in currentItem) {
        if (!Empty(p) && currentItem[p] && LRTrim(currentItem[p].toString()) == 'request')
          request_parms[currentItem['name']] = (!Empty(currentItem['typevar']) ? (currentItem['typevar'] == 'datetime') ? 'T' : Left(currentItem['typevar'], 1).toUpperCase() : 'C');
        else if (!Empty(p) && currentItem[p] && currentItem[p].toString().indexOf('request:') > -1)
          request_parms[LRTrim(Strtran(currentItem[p], 'request:', ''))] = (!Empty(currentItem['typevar']) ? (currentItem['typevar'] == 'datetime') ? 'T' : Left(currentItem['typevar'], 1).toUpperCase() : 'C');
      }
    }
    actioncode = arrayreload[arrayreload.length - 1] // codice delle funzioni editat
    if (formProp['offline'] == 'true' && !Empty(formProp['manifest']) && formProp['manifest'] != 'Custom manifest') { // Carica il custom manifest
      codeManifest = new JSURL("../servlet/JSPReader?action=manifest&name=" + formProp['manifest'], true).Response();
      formProp['manifest'] = 'Custom manifest';
    }
    writeHTML(true);
    FormProperties(true, false);

  } else if (strreload == '') {
    alert('utente non loggato')
  } else {
    alert('Errore in caricamento del def')
  }
  b_reload = false;
}
//carica un nuovo oggetto
function loadNewObj() {
  window.layerOpenForeground("../visualweb/openEdtDef.htm", "SelectComponent", '', 350, 500, true, 1);
}

function loadNewObjDone(objsrc) {
  var imagename
  var objname
  if (objsrc != null) {
    objname = objsrc.substring(0, objsrc.indexOf('.'))
    if (objsrc != null && eval("ZTObjects." + objname) == null) {
      getobj(objsrc) // eval del nuovo oggetto
      //prende il nome del nuovo oggetto
      eval("imagename=ZTObjects." + objname + "Class.names[0]")
      /*Trovo la dimensione dell'immagine */
      var imm = new Element('img', {
        'src': imagename
      }).setStyles({
        'opacity': 0
      }).inject(document.body, 'before');
      imm.type = objname;
      imm.imagename = imagename;
      imm.addEventListener('load', function () {
        var type = this.type;
        toolbars.extra.addElement({
          'id': 'right_align',
          'action': {
            'func': 'addItem',
            'par': type
          },
          'image': this.imagename,
          'title': type,
          'draggable': true,
        })
        // var objCont =  new Element('div',{'id':type,'class':'btn','title':type}).inject(document.getElementById('newObj'),'before');
        // if( this.offsetHeight == 24 &&  this.offsetWidth == 48){
        // var newObj = new Element('div').setStyles({
        // 'background-image': 'url('+this.imagename+')'
        // }).inject(objCont);
        // }else{
        // var newObj  = new Element('img',{'src':this.imagename,'border':0,'alt':this.type,'title':this.type}).setStyles({
        // 'height':24,
        // 'width':24
        // }).inject(objCont);
        // }
        // newObj.type = this.type;
        // newObj.addEvent('click',function(){
        // addItem(this.type);
        // });
        /*Aggiorno le dimensioni della toolbar*/
        // var evt = document.createEvent('HTMLEvents');
        // evt.initEvent('SPToolbarRefresh',true,true);
        // objCont.dispatchEvent(evt);
        this.destroy();

        // document.fireEvent('SPToolbarRefresh',);
        // new DOMEvent('onSPToolbarRefresh')
      });
    }
  }
  document.body.onfocus = null
}
// Funzioni di trascinamento items ####################################
function sortY(a, b) {
  if (parseInt(a.y) > parseInt(b.y)) return 1;
  if (parseInt(a.y) < parseInt(b.y)) return -1;
  return 0;
}

function sortX(a, b) {
  if (parseInt(a.x) > parseInt(b.x)) return 1;
  if (parseInt(a.x) < parseInt(b.x)) return -1;
  return 0;
}

//Funzioni di allineamento

function alignItems(side) {
  if (mainitem == null) return;
  var delta, aa, bb, cc, p, n;
  var newvalue;
  switch (side) {
    case 'y_delta':
      cc = 0;
      itemsHTML.sort(sortY);
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != "") {
          cc++;
          if (cc == 1) aa = p;
          if (cc == 2) {
            bb = p;
            delta = itemsHTML[bb].y - itemsHTML[aa].y - itemsHTML[aa].h;
            break
          }
        }
      }
      aa = 0;
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != "") {
          if (aa > 0) {
            Ctrl(itemsHTML[p].shadow).style.top = (parseInt(delta) + parseInt(prevItem.y) + parseInt(prevItem.h)) + 'px';
            itemsHTML[p].y = parseInt(delta) + parseInt(prevItem.y) + parseInt(prevItem.h);
          }
          prevItem = itemsHTML[p];
          aa++;
        }
      }
      moveItems();
      break
    case 'x_delta':
      cc = 0;
      itemsHTML.sort(sortX);
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != "") {
          cc++;
          if (cc == 1) aa = p;
          if (cc == 2) {
            bb = p;
            delta = itemsHTML[bb].x - itemsHTML[aa].x - itemsHTML[aa].w;
            break
          }
        }
      }
      aa = 0;
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != "") {
          if (aa > 0) {
            Ctrl(itemsHTML[p].shadow).style.left = (parseInt(delta) + parseInt(prevItem.x) + parseInt(prevItem.w)) + 'px';
            itemsHTML[p].x = parseInt(delta) + parseInt(prevItem.x) + parseInt(prevItem.w);
          }
          prevItem = itemsHTML[p];
          aa++;
        }
      }
      moveItems();
      break
    case 'center':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          newvalue = Math.round(mainitem.offsetLeft + mainitem.offsetWidth / 2 - Ctrl(itemsHTML[p].shadow).offsetWidth / 2);
          Ctrl(itemsHTML[p].shadow).style.left = newvalue + 'px';
          itemsHTML[p].x = newvalue;
        }
      }
      moveItems();
      break
    case 'middle':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          newvalue = Math.round(mainitem.offsetTop + mainitem.offsetHeight / 2 - Ctrl(itemsHTML[p].shadow).offsetHeight / 2);
          Ctrl(itemsHTML[p].shadow).style.top = newvalue + 'px';
          itemsHTML[p].y = newvalue;
        }
      }
      moveItems();
      break
    case 'left':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          Ctrl(itemsHTML[p].shadow).style.left = mainitem.offsetLeft + 'px';
          itemsHTML[p].x = itemsHTML[index].x;
        }
      }
      moveItems();
      break
    case 'top':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          Ctrl(itemsHTML[p].shadow).style.top = mainitem.offsetTop + 'px';
          itemsHTML[p].y = itemsHTML[index].y;
        }
      }
      moveItems();
      break
    case 'right':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          Ctrl(itemsHTML[p].shadow).style.left = (mainitem.offsetLeft + mainitem.offsetWidth - Ctrl(itemsHTML[p].shadow).offsetWidth) + 'px';
          itemsHTML[p].x = itemsHTML[index].x + itemsHTML[index].w - itemsHTML[p].w; //mainitem.offsetLeft+mainitem.offsetWidth-Ctrl(itemsHTML[p].shadow).offsetWidth
        }
      }
      moveItems();
      break
    case 'bottom':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          Ctrl(itemsHTML[p].shadow).style.top = (mainitem.offsetTop + mainitem.offsetHeight - Ctrl(itemsHTML[p].shadow).offsetHeight) + 'px';
          itemsHTML[p].x = itemsHTML[index].y + itemsHTML[index].h - itemsHTML[p].h; //mainitem.offsetTop+mainitem.offsetHeight-Ctrl(itemsHTML[p].shadow).offsetHeight
        }
      }
      moveItems();
      break
    case 'resizex':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && !Empty(itemsHTML[p].shadow)) {
          n = Ctrl(itemsHTML[p].shadow).id.substr(6);
          undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj('item' + n, 'resize', null, null, null, null, itemsHTML[p], mainitem.offsetWidth, mainitem.offsetHeight, itemsHTML[p].w, itemsHTML[p].h);
          Ctrl(itemsHTML[p].shadow).style.width = (mainitem.offsetWidth - 2) + 'px';
          Ctrl("handlersWrapper" + n).style.width = (mainitem.offsetWidth + 6) + 'px';
          Ctrl("item" + n).style.width = (mainitem.offsetWidth - getOffset(Ctrl("item" + n)).gapw) + 'px';
          itemsHTML[p].w = itemsHTML[index].w;
        }

      }
      if (undoItemsMoved.length > 0) {
        indexUndo++;
        undoSequence[indexUndo] = undoItemsMoved;
        CheckUndoSize();
        undoItemsMoved = [];
      }
      break
    case 'resizey':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          n = Ctrl(itemsHTML[p].shadow).id.substr(6)
          undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj('item' + n, 'resize', null, null, null, null, itemsHTML[p], mainitem.offsetWidth, mainitem.offsetHeight, itemsHTML[p].w, itemsHTML[p].h);
          Ctrl(itemsHTML[p].shadow).style.height = (mainitem.offsetHeight - 2) + 'px';
          Ctrl("handlersWrapper" + n).style.height = (mainitem.offsetHeight + 6) + 'px';
          Ctrl("handler" + n + "_5").style.top = ((Ctrl("handlersWrapper" + n).offsetHeight) / 2 - 4) + 'px'; //bordi
          Ctrl("handler" + n + "_6").style.top = ((Ctrl("handlersWrapper" + n).offsetHeight) - 18) + 'px'; //posizionamento relativo  (10)
          Ctrl("handler" + n + "_7").style.top = ((Ctrl("handlersWrapper" + n).offsetHeight) / 2 - 4) + 'px';
          Ctrl("item" + n).style.height = (mainitem.offsetHeight - getOffset(Ctrl("item" + n)).gaph) + 'px';
          itemsHTML[p].h = itemsHTML[index].h;
        }
      }
      if (undoItemsMoved.length > 0) {
        indexUndo++;
        undoSequence[indexUndo] = undoItemsMoved;
        CheckUndoSize();
        undoItemsMoved = [];
      }
      break
    case 'resizexy':
      for (p = 0; p < itemsHTML.length; p++) {
        if (itemsHTML[p].shadow != mainitem.id && itemsHTML[p].shadow != "") {
          n = Ctrl(itemsHTML[p].shadow).id.substr(6);
          undoItemsMoved[undoItemsMoved.length] = new ZTObjects.undoObj('item' + n, 'resize', null, null, null, null, itemsHTML[p], mainitem.offsetWidth, mainitem.offsetHeight, itemsHTML[p].w, itemsHTML[p].h);
          itemsHTML[p].w = itemsHTML[index].w;
          itemsHTML[p].h = itemsHTML[index].h;
          Ctrl(itemsHTML[p].shadow).style.height = mainitem.offsetHeight + 'px';
          Ctrl(itemsHTML[p].shadow).style.width = (mainitem.offsetWidth - 2) + 'px';
          Ctrl("handlersWrapper" + n).style.width = (mainitem.offsetWidth + 6) + 'px';
          Ctrl("item" + n).style.width = (mainitem.offsetWidth - getOffset(Ctrl("item" + n)).gapw) + 'px';
          Ctrl("handlersWrapper" + n).style.height = (mainitem.offsetHeight + 6) + 'px';
          Ctrl("handler" + n + "_5").style.top = ((Ctrl("handlersWrapper" + n).offsetHeight) / 2 - 4) + 'px'; //bordi
          Ctrl("handler" + n + "_6").style.top = ((Ctrl("handlersWrapper" + n).offsetHeight) - 18) + 'px'; //posizionamento relativo  (10)
          Ctrl("handler" + n + "_7").style.top = ((Ctrl("handlersWrapper" + n).offsetHeight) / 2 - 4) + 'px';
          Ctrl("item" + n).style.height = (mainitem.offsetHeight - getOffset(Ctrl("item" + n)).gaph) + 'px';

        }
      }
      if (undoItemsMoved.length > 0) {
        indexUndo++;
        undoSequence[indexUndo] = undoItemsMoved;
        CheckUndoSize();
        undoItemsMoved = [];
      }
      break
  }
}

function findMaxZIndex(all) {
  var maxZindex = 0;
  for (var i = 0; i < itemsHTML.length; i++) {
    if ((all || i != index) && itemsHTML[i].zindex && maxZindex < parseInt(itemsHTML[i].zindex))
      maxZindex = parseInt(itemsHTML[i].zindex);
  }
  return maxZindex;

}

function bringToFront() {
  if (index == null) return;
  var mainobj = itemsHTML[index];
  if (typeof (mainobj.zindex) == 'undefined') mainobj.zindex = 1;
  mainobj.zindex = findMaxZIndex() + 1;
  writeHTML();
}

function sendToBack() {
  if (index == null) return;
  var mainobj = itemsHTML[index];
  var findZero = false;
  var i;
  if (typeof (mainobj.zindex) == 'undefined') mainobj.zindex = 1;
  mainobj.zindex = 0;
  //se trovo un altro a 0 li sposto tutto in su di uno
  for (i = 0; i < itemsHTML.length; i++) {
    if (i != index && typeof (itemsHTML[i].zindex) != 'undefined' && parseInt(itemsHTML[i].zindex) == 0) {
      findZero = true;
    }
  }
  if (findZero) {
    for (i = 0; i < itemsHTML.length; i++) {
      if (i != index && typeof (itemsHTML[i].zindex) != 'undefined') {
        itemsHTML[i].zindex = parseInt(itemsHTML[i].zindex) + 1;
      }
    }
  }
  var ind = index;
  writeHTML(true);
  selectItem(itemsHTML[ind]);
}

function bringForward() {
  if (index == null) return;
  var mainobj = itemsHTML[index];
  if (typeof (mainobj.zindex) == 'undefined') mainobj.zindex = 1;
  var zindex = parseInt(mainobj.zindex);
  if (zindex <= findMaxZIndex()) {
    zindex++;
    mainobj.zindex = zindex;
    writeHTML();
  }
}

function sendBackward() {
  if (index == null) return;
  var mainobj = itemsHTML[index];
  if (typeof (mainobj.zindex) == 'undefined') mainobj.zindex = 1;
  var zindex = parseInt(mainobj.zindex);
  var findZero = false;
  if (zindex > 0) {
    zindex--;
    var i;
    if (zindex == 0) {
      //se trovo un altro a 0 li sposto tutto in su di uno
      for (i = 0; i < itemsHTML.length; i++) {
        if (i != index && typeof (itemsHTML[i].zindex) != 'undefined' && parseInt(itemsHTML[i].zindex) == 0) {
          findZero = true;
        }
      }
      if (findZero) {
        for (i = 0; i < itemsHTML.length; i++) {
          if (i != index && typeof (itemsHTML[i].zindex) != 'undefined') {
            itemsHTML[i].zindex = parseInt(itemsHTML[i].zindex) + 1;
          }
        }
      }
    }
    mainobj.zindex = zindex;
    var ind = index;
    writeHTML(true);
    selectItem(itemsHTML[ind]);
  }
}

// function insertImage(url, imgnew, retTo) {
// InsertImageDone("../" + url, imgnew, retTo);
//}

function closeDialogs() {
  if (WinOpener) WinOpener.close();
  document.body.onfocus = null;
}

function GetCurrentName() {
  return currentname;
}

function GetResourceName() {
  return '../jsp/' + currentname + '_portlet.jsp?m_NoCache=' + LibJavascript.AlfaKeyGen(10);
}

function GetRequestParams() {
  return request_parms;
}

// function toggleVisualMode() {
//   variants.saveVariantProp();
//   last_index = null;
//   document.body.classList.remove("grapesmode");
//   document.body.classList.remove("htmlmode");
//   if (document.body.classList.contains("htmlmode") || document.body.classList.contains("grapesmode")) {

//     /**
//     * Remove all variant's items
//     */
//     // itemsHTML = itemsHTML.filter( item => !item.ctrlOfVariant );
//     countindex = itemsHTML.length;
//     writeHTML(true);
//     mode = "NORMAL";
//     codeEditor.setCursor({line: codeEditor.lastLine(), ch: 0})
//   }
//   removeAllHandlers();
//   toolbars.mode.removeElement('btn_normalmode');
// }

// function toggleGrapesMode() {
//   document.body.classList.remove("htmlmode");
//   if (document.body.classList.contains("grapesmode")) {
//     document.body.classList.remove("grapesmode");
//     mode = "NORMAL";
//     document.body.insertBefore( document.getElementById('properties'), document.getElementById('gadgets_pane'));
//     codeEditor.setCursor({line: codeEditor.lastLine()+1, ch: 0})
//     toolbars.mode.removeElement('btn_normalmode');
//   } else {
//     document.body.classList.add("grapesmode");
//     mode = "GRAPES";
//     grapes.Panels.getButton('devices-c', 'close-editor').set("active", false);
//     document.getElementById('properties_container').appendChild( document.getElementById('properties'));
//     // updateHTMLEditor();
//     resizeHTMLEditor();
//     // codeEditor.focus();
//     toolbars.mode.removeElement('btn_grapesmode');
//   }
//   removeAllHandlers();
// }

// function toggleHTMLMode() {
//   variants.saveVariantProp();
//   last_index = null;
//   document.body.classList.remove("grapesmode");
//   if (document.body.classList.contains("htmlmode")) {
//     document.body.classList.remove("htmlmode");
//     /**
//     * Remove all variant's items
//     */
//     // itemsHTML = itemsHTML.filter( item => !item.ctrlOfVariant );
//     countindex = itemsHTML.length;
//     writeHTML(true);
//     mode = "NORMAL";
//     codeEditor.setCursor({line: codeEditor.lastLine(), ch: 0})
//     toolbars.mode.removeElement('btn_normalmode');
//   } else {
//     document.body.classList.add("htmlmode");
//     mode = "HTML";

//     if( variants[current_variant] ){
//       variants.loadVariantProp()
//     }

//     updateHTMLEditor();
//     resizeHTMLEditor();
//     codeEditor.focus();
//     toolbars.mode.removeElement('btn_htmlmode');
//   }
//   removeAllHandlers();
//   document.body.insertBefore( document.getElementById('properties'), document.getElementById('gadgets_pane'));
// }

function toggleMode( new_mode ) {
  document.body.classList.remove("htmlmode");
  document.body.classList.remove("logicmode");
  document.body.classList.remove("grapesmode");
  variants.saveVariantProp();
  last_index = null;
  countindex = itemsHTML.length;

  document.body.insertBefore( document.getElementById('properties'), document.getElementById('gadgets_pane'));
  codeEditor.setCursor({line: codeEditor.lastLine()+1, ch: 0});
  /**
   * Riprostino le icone delle modalita'
   */
  ZTObjects.PSToolbarMode.forEach( ( m, i ) => {
    if( m.id.indexOf(mode.toLowerCase()) > -1 && !toolbars.mode.getElement(m.id) ){
      toolbars.mode.addElement(m,i);
    }
  })
  toolbars.mode_ctrl
  switch (new_mode){
    case "NORMAL":
      writeHTML(true);
      codeEditor.setCursor({line: codeEditor.lastLine(), ch: 0});
      toolbars.mode.removeElement('btn_normalmode');
      toolbars.mode_ctrl.setOption("title", "Mode <b>Portlet</b>")
      Object.keys(toolbars).forEach( key => toolbars[key].enable());
      // if ( currentname == "" ) {
      //   toolbars.action.disable('btn_preview');
      // }
      break;
    case "HTML":
      document.body.classList.add("htmlmode");
      if( variants[current_variant] ){
        variants.loadVariantProp();
      }
      updateHTMLEditor();
      resizeHTMLEditor();
      codeEditor.focus();
      toolbars.mode.removeElement('btn_htmlmode');
      toolbars.mode_ctrl.setOption("title", "Mode<b> HTML</b>")
      Object.keys(toolbars).forEach( key => toolbars[key].enable());
      toolbars.align.disable();
      toolbars.bring.disable();
      toolbars.resize.disable();
      break;
    case "GRAPES":
      document.body.classList.add("grapesmode");
      grapes.Panels.getButton('devices-c', 'close-editor').set("active", false);
      document.getElementById('properties_container').appendChild( document.getElementById('properties'));
      resizeHTMLEditor();
      toolbars.mode.removeElement('btn_grapesmode');
      toolbars.mode_ctrl.setOption("title", "Mode <b>Graper</b>")
      break;
    case "LOGIC":
      document.body.classList.add("logicmode");
      var i_logicview = document.getElementById('i_logicview');
      i_logicview.src = 'logicView.html';
      toolbars.mode.removeElement('btn_logicmode');
      toolbars.mode_ctrl.setOption("title", "Mode <b>Logic</b>")
      Object.keys(toolbars)
      .filter( key => !key.match(/mode_ctrl/))
      .forEach( key => toolbars[key].disable());
      break;
  }
  removeAllHandlers();
  mode = new_mode;
}

function unSelectItem(itm) { //REFIFINED
  SetOnEditProp(false);
  var i;
  var mainitemz = itm;
  var unselecteditem = mainitemz.id.substr(6);
  var indexz = -1;
  //if(index==selecteditem) return; //selecteditem NON indica la posizione nell'array!!!
  for (i = 0; i < itemsHTML.length; i++) {
    if (itemsHTML[i].shadow == mainitemz.id) {
      indexz = i;
    }
  }

  if (indexz >= 0) {
    itm.style.display = 'none';
    itemsHTML[indexz].shadow = '';
    Ctrl("handler" + unselecteditem + "_0").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_1").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_2").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_3").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_4").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_5").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_6").style.display = 'none';
    Ctrl("handler" + unselecteditem + "_7").style.display = 'none';
    Ctrl("handlersWrapper" + unselecteditem).style.display = 'none';
    Ctrl("canvashandlers").removeChild(itm);
    Ctrl("canvashandlers").removeChild(Ctrl("handlersWrapper" + unselecteditem));
    if (mainitem && mainitem.id == mainitemz.id) {
      for (i = 0; i < itemsHTML.length; i++) {
        if (itemsHTML[i].shadow && Ctrl(itemsHTML[i].shadow)) {
          return selectItem(Ctrl(itemsHTML[i].shadow));
        }
      }
      removeAllHandlers();
    }
  }
}
function updateHtmlCode( oldname, newname ){
  /**
   * Chiamata al cambio di nome dell'item
   */
  let old_opt = document.querySelector(`#hidden_ctrl_combo option[value="${oldname}"]`);
  if( old_opt ) {
    old_opt.parentElement.appendChild( new Option(newname, newname, false, false) );
    old_opt.parentElement.removeChild(old_opt);
     // jQuery("#hidden_ctrl_combo").val(null).trigger('change');
    jQuery("#hidden_ctrl_combo").val(newname).trigger('change');
  } else {
    old_opt = document.querySelector(`#visible_ctrl_combo option[value="${oldname}"]`);
    if( old_opt ){
      old_opt.parentElement.appendChild( new Option(newname, newname, false, true) );
      old_opt.parentElement.removeChild(old_opt);
      jQuery("#visible_ctrl_combo").trigger('change');
      let x = codeEditor.getSearchCursor(getVisibleCtrlHTMLRegex(oldname));
      let find = x.findNext();
      while( find ){
        let from = x.from();
        let s = find[0].indexOf(find[1]);
        codeEditor.replaceRange( newname, {
          ch: from.ch + s,
          line: from.line
        }, {
          line: from.line,
          ch: from.ch + s + find[1].length
        }, oldname );
        codeEditor.setCursor(CodeMirror.Pos(from.line, from.ch + s + newname.length, "before" ));
        find = x.findNext();
      }
    }
  }
}

/**
 * Save old value and reset items situazion
 */
variants.saveVariantProp = function(){
  if( current_variant > -1) {

    variants[current_variant].actioncode = actioncode;
    variants[current_variant].css_libs = formProp.css;
    variants[current_variant].css_class = formProp.css_class;
    variants[current_variant].css_code = classCssObj;
    variants[current_variant].htmlcode = codeEditor.getValue();
    variants[current_variant].js_libs = formProp.my_library;
    /**
    * filter items to set current variant ctrls
    */
    variants[current_variant].ctrls = itemsHTML.filter( c => c.ctrlOfVariant == current_variant );
  }
}
variants.loadVariantProp = function(){
  /**
    * Remove hidden item when change variant
    */
  let container = document.getElementById("hidden_ctrl_combo");
  itemsHTML.filter( item => item.ctrlOfVariant && item.hidden ).forEach( datac => {
    let to_rem = container.querySelector("option[value="+datac.name+"]");
    if( to_rem ){
      to_rem.parentNode.removeChild(to_rem);
    }
  })
  jQuery("#hidden_ctrl_combo").trigger("change");
  /**
   * Remove visible item when change variant
   */
  container = document.getElementById("visible_ctrl_combo");
  itemsHTML.filter( item => item.ctrlOfVariant && !item.hidden ).forEach( datac => {
    let to_rem = container.querySelector("option[value="+datac.name+"]");
    if( to_rem ){
      to_rem.parentNode.removeChild(to_rem);
    }
  })
  jQuery("#visible_ctrl_combo").trigger("change");
  /**
  * Remove all variant's items
  */
  itemsHTML = itemsHTML.filter( item => !item.ctrlOfVariant );
  countindex = itemsHTML.length;
  codeEditor.setValue( variants[current_variant].htmlcode );
  classCssObj = variants[current_variant].css_code;
  actioncode = variants[current_variant].actioncode;
  formProp.my_library = variants[current_variant].js_libs;
  formProp.css = variants[current_variant].css_libs;
  formProp.css_class = variants[current_variant].css_class;
  newFormPropObj.updateProperties();
  /**
   * Add item when select variant different of base
   */
  // itemsHTML = itemsHTML.concat(variants[current_variant].items);
  if ( current_variant > 0 ){
    variants[current_variant].ctrls.forEach( c => {
      let current = putItem(null, true, true, c);
      /**
       * Non deve ridefinire il numero della variante a cui e' associato
       */
      Object.keys(c).filter( k => !k.match("ctrlOfVariant" ) ).forEach( k => current[k] = c[k]);
    });
  }
}

variants.getNameFromFolderPath = function( name, folder_path ) {
  folder_path = folder_path || "";
  return  (folder_path.startsWith("sites") ?  "sites." + folder_path.split("/")[1] + ".":
      (folder_path.startsWith("templates") ?  "templates." + folder_path.split("/")[1] + "." : "" )) +
      name;

}

variants.getSite = function(name){
  return ( name.split(".")[0] == "sites" ? name.split(".")[1] : null );
}

variants.getTemplate = function(name){
  return ( name.split(".")[0] == "templates" ? name.split(".")[1] : null );
}

variants.getName = function(complex_name){
  return complex_name.substr( complex_name.lastIndexOf(".")+1);
}

function getVisibleCtrlHTMLRegex( ctrl ){
  return new RegExp("\\{\\{\\s*@(" + ctrl + ")\\s*\\}\\}");
}

function getHiddenCtrlHTMLRegex( ctrl ){
  return new RegExp("{{.*[^@](" + ctrl + ")[^}}]*}}", "gm");
}

function getCtrlHTML( str ){
  return str.match(/{{\s*@(?<ctrl>[A-Za-z_]\w*)\s*}}/)?.groups.ctrl;
}
