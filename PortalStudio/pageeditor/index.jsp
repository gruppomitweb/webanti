<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="java.io.*" %>
<%
  Sitepainter sp=new Sitepainter(request);
  String fileName = sp.getParameter("name","");
  String fileType = sp.getParameter("type","jsp");
  if( !("jsp".equals(fileType) || "css".equals(fileType)) ){
    response.sendError(400, "Type parameter not supported");
    return;
  }
  %>

<!DOCTYPE html>
<html>
<head>
 <title>Jsp Editor - Sitepainter Infinity Portalstudio</title>
 <script type="text/javascript" src="../stdFunctions.js"></script>
 <script type="text/javascript" src="../controls.js"></script>
 <script type="text/javascript" src="../mootools.js"></script>
 <script type="text/javascript" src="../mootools_more.js"></script>
 <link rel="stylesheet" href="editItemEvent.css">
 <link rel="stylesheet" href="../codemirror/lib/codemirror.css">
 <link rel="stylesheet" href="../codemirror/addon/fold/foldgutter.css">
 <link rel="stylesheet" href="../codemirror/addon/dialog/dialog.css">
 <link rel="stylesheet" href="../codemirror/addon/hint/show-hint.css">
 <link rel="stylesheet" href="../codemirror/theme/ambiance.css">
 <link rel="stylesheet" href="../codemirror/theme/blackboard.css">
 <link rel="stylesheet" href="../codemirror/theme/neat.css">
 <link rel="stylesheet" href="../codemirror/theme/elegant.css">
 <link rel="stylesheet" href="../codemirror/theme/erlang-dark.css">
 <link rel="stylesheet" href="../codemirror/theme/lesser-dark.css">
 <link rel="stylesheet" href="../codemirror/theme/night.css">
 <link rel="stylesheet" href="../codemirror/theme/monokai.css">
 <link rel="stylesheet" href="../codemirror/theme/cobalt.css">
 <link rel="stylesheet" href="../codemirror/theme/eclipse.css">
 <link rel="stylesheet" href="../codemirror/theme/midnight.css">
 <link rel="stylesheet" href="../codemirror/theme/solarized.css">
 <link rel="stylesheet" href="../codemirror/theme/rubyblue.css">
 <link rel="stylesheet" href="../codemirror/theme/twilight.css">
 <link rel="stylesheet" href="../codemirror/theme/vibrant-ink.css">
 <link rel="stylesheet" href="../codemirror/theme/xq-dark.css">
 <link rel="stylesheet" href="../codemirror/theme/xq-light.css">
 <link rel="stylesheet" type="text/css" href="../Notimoo.css" />
 <script src="../Notimoo.js"></script>
 <script type='text/javascript' src="../codemirror/lib/codemirror.js"></script>
 <script type='text/javascript' src="../codemirror/mode/javascript/javascript.js"></script>
 <script type='text/javascript' src="../codemirror/mode/css/css.js"></script>
 <script type='text/javascript' src="../codemirror/addon/edit/matchbrackets.js"></script>
 <script type='text/javascript' src="../codemirror/addon/comment/comment.js"></script>
 <script type='text/javascript' src="../codemirror/addon/comment/continuecomment.js"></script>
 <script type='text/javascript' src="../codemirror/addon/dialog/dialog.js"></script>
 <script type='text/javascript' src="../codemirror/addon/hint/show-hint.js"></script>
 <!--script type='text/javascript' src="../codemirror/addon/hint/javascript-hint.js"></script-->
 <script type='text/javascript' src="../codemirror/addon/search/searchcursor.js"></script>
 <script type='text/javascript' src="../codemirror/addon/search/search.js"></script>
 <script type='text/javascript' src="../codemirror/addon/selection/active-line.js"></script>
 <script type='text/javascript' src="../codemirror/addon/selection/mark-selection.js"></script>
 <script type='text/javascript' src="../codemirror/addon/search/match-highlighter.js"></script>
 <script type='text/javascript' src="../codemirror/addon/fold/foldcode.js"></script>
 <script type='text/javascript' src="../codemirror/addon/fold/foldgutter.js"></script>
 <script type='text/javascript' src="../codemirror/addon/fold/brace-fold.js"></script>
 <script type='text/javascript' src="../codemirror/addon/fold/xml-fold.js"></script>
 <style type="text/css">
      .breakpoints { width: 1em; }
      li.CodeMirror-hint {
        max-width: none;
      }
 </style>
</head>
<body>
  <div id='topbar'>
    <!--
    <span class="title">Action Code</span>

    <div class='right'>
      <a id="toolbar_cancel" class="" href="javascript:void(0)" title='Cancel'>CANCEL</a>
    </div>
    <div class='right'>
      <a id="toolbar_ok" class="" href="javascript:void(0)" title='Save and Close'>SAVE</a>
    </div>
    -->
    <div class="action_bar">
      <!--div id='topbar_right' class='topbar_sides right'></div-->

      <!--div id='topbar_left' class='topbar_sides left'></div-->
      <!--
      <div class='left topbar_padding'>
        <label class='small' for="id_item">Items: </label>
        <div id="selectname" class="select" style="display:inline"></div>
      </div>
      <div class='topbar_separator left'></div>
      <div class='left topbar_padding'>
        <label class='small' for="event_item">Events: </label>
        <div id="selectevent" class="select" style="display:inline"></div>
      </div>
      <div class='topbar_separator left'></div>
      <div class='left topbar_padding'>
        <label class='small' for="function_item">Functions: </label>
        <div id="selectfunction" class="select" style="display:inline"></div>
      </div>
      -->

      <div class='float_left topbar_padding' >
        <a id="toolbar_search" class="toolbar_btn" href="javascript:void(0)" title='Search'></a>
      </div>
      <div class='float_right topbar_padding'>
        <a id="toolbar_help" class="toolbar_btn" href="javascript:void(0)" title='Help'>
        </a>
          <div id='helpkeys_content' class='small'>
           <table cellpadding="5" border="0"><tbody>
           <tr><td>Search</td><td align="right" nowrap>Ctrl-F</td></tr>
           <tr><td>Replace</td><td align="right" nowrap>Ctrl-R</td></tr>
           <tr><td>Find Next</td><td align="right" nowrap>F3</td></tr>
           <tr><td>Find Prev</td><td align="right" nowrap>Shift-F3</td></tr>
           <tr><td>Toggle bookmark</td><td align="right" nowrap>Ctrl-F2</td></tr>
           <tr><td>Next bookmark</td><td align="right" nowrap>F2</td></tr>
           <tr><td>Prev bookmark</td><td align="right" nowrap>Shift-F2</td></tr>
           <tr><td>Add/Remove Comment</td><td align="right" nowrap>Ctrl-Q</td></tr>
           <tr><td>Save All</td><td align="right" nowrap>Ctrl-S</td></tr>
           </tbody></table>
        </div>
      </div>
    </div>
  </div>
  <div id='editor'>
      <div id="loader"></div>
  </div>
  <div id="opt_pane_top">
    <div id="opt_pane_top_wrapper">
      <div id='opt_pane_topbar_left' title='Show/Hide style pane' class='left'>
        <div class="toggler"></div><div class="toggler_icon"></div>
      </div>
      <div id="opt_pane_topbar" class='left'>
        <p class='label'>Styles</p>
      </div>
    </div>
  </div>
  <div id="opt_pane">
    <div id="opt_pane_wrapper">
      <div id="opt_pane_content">
        <div id="opt_pane_toggler"></div>
        <div>
          <a class='opt_pane_mode' id="change_style_ambiance" href="javascript:void(0)">Ambiance</a>
          <a class='opt_pane_mode' id="change_style_blackboard" href="javascript:void(0)">Blackboard</a>
          <a class='opt_pane_mode' id="change_style_cobalt" href="javascript:void(0)">Cobalt</a>
          <a class='opt_pane_mode' id="change_style_eclipse" href="javascript:void(0)">Eclipse</a>
          <a class='opt_pane_mode' id="change_style_elegant" href="javascript:void(0)">Elegant</a>
          <a class='opt_pane_mode' id="change_style_erlang-dark" href="javascript:void(0)">Erlang-dark</a>
          <a class='opt_pane_mode' id="change_style_lesser-dark" href="javascript:void(0)">Lesser-dark</a>
          <a class='opt_pane_mode' id="change_style_default" href="javascript:void(0)">Light</a>
          <a class='opt_pane_mode' id="change_style_midnight" href="javascript:void(0)">Midnight</a>
          <a class='opt_pane_mode' id="change_style_monokai" href="javascript:void(0)">Monokai</a>
          <a class='opt_pane_mode' id="change_style_neat" href="javascript:void(0)">Neat</a>
          <a class='opt_pane_mode' id="change_style_night" href="javascript:void(0)">Night</a>
          <a class='opt_pane_mode' id="change_style_rubyblue" href="javascript:void(0)">Rubyblue</a>
          <a class='opt_pane_mode' id="change_style_solarized" href="javascript:void(0)">Solarized</a>
          <a class='opt_pane_mode' id="change_style_twilight" href="javascript:void(0)">Twilight</a>
          <a class='opt_pane_mode' id="change_style_vibrant-ink" href="javascript:void(0)">Vibrant-ink</a>
          <a class='opt_pane_mode' id="change_style_xq-dark" href="javascript:void(0)">Xq-dark</a>
          <a class='opt_pane_mode' id="change_style_xq-light" href="javascript:void(0)">Xq-light</a>
         </div>
        <p id="slider">Font size - px </p>
        <div style="padding:5px;">
          <div id="fontSlider" class="slider">
            <div class="knob">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
<script type="text/javascript">

  var cmdhash = '<%=getCmdHash( fileType, request)%>'
    , fileName
    , fileType='<%=JSPLib.ToJSValue(fileType)%>'
  	//,	index
  	,	code
  	,	codeEditor
  	//,	form
  	,	funct_evt
  	,	RetVal
    , z_ac_style = localStorage.getItem('zucchetti_ac_style')
  	,	ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : { fontSize: "", theme: "" }
    , changed=false
    , codeMirrorOpt={}
    , opt_paneOpened = false
    , opt_paneToggle
    , opt_paneTopToggle
    , resizeTimer;
    var statuss = { folded : {}, breakpoints : {}};
  /****** Gestione del LocalStorage *******/
  localStorage.setItem('zucchetti_ac_style',JSON.encode(ac_style));
  /*******codemirror options*******/
  function thisHints(onlyItems) {
    var toAdd = "";
    if (onlyItems) toAdd = "_";
    var ptlItems=[]
    for (var i=0;i<itemsHTML.length;i++) {
      if (itemsHTML[i].type!='Portlet')
        ptlItems.push({text:itemsHTML[i].name+toAdd,displayText:itemsHTML[i].name});
    }
    ptlItems.sort(function(a, b) {
      return a.displayText.toLowerCase() > b.displayText.toLowerCase() ? 1 : -1;
    });

    if (!onlyItems) {
      ptlItems = ptlItems.concat(itemHints('this'));
    }
    return ptlItems;
  }
  var items=null;
  function itemNames() {
    if (items==null) {
      items = [];
      for (var i=0;i<itemsHTML.length;i++) {
        if (itemsHTML[i].type!='Portlet')
          items.push(itemsHTML[i].name);
        }
    }
    return items;
  }
  function itemHints(itemName) {
    /*
    var objFound = null, list = [];
    if (itemName=='this') {
      objFound = form;
    } else {
      for (var i=0;i<itemsHTML.length;i++) {
        if (itemsHTML[i].name==itemName)
          objFound = itemsHTML[i];
      }
    }
    if (objFound) {
      objFound=objFound.objClass.functions;
      if(objFound){
        var descr,value,long_descr;
        for(var i=0;i<objFound.length;i++){
          if(IsA(objFound[i],'C')) value=descr=objFound[i]
          else{
            descr=objFound[i][0];
            value=objFound[i][1];
            if(!Empty(objFound[i][2])) long_descr=objFound[i][2];
          }
          var txt = value; //Substr(value,1,At("(",value));
          list.push({text:txt,displayText:descr});
        }
      }
    }
    list.sort(function(a, b) {
      return a.displayText.toLowerCase() > b.displayText.toLowerCase() ? 1 : -1;
    });
    return list;
    */
  }
  function itemEvents(itemName) {
    /*
    var objFound = null, list = [];
    if (itemName=='this') {
      objFound = form;
    } else {
      for (var i=0;i<itemsHTML.length;i++) {
        if (itemsHTML[i].name==itemName)
          objFound = itemsHTML[i];
      }
    }
    if (objFound) {
      objFound=objFound.objClass.events;
      if(objFound){
        var value,descr;
        for(i=0;i<objFound.length;i++){
          if(IsA(objFound[i],'C')){
            value=descr=objFound[i];
          }else{
            descr=objFound[i][0];
            value=objFound[i][1];
          }
          var toAdd='';
          if(value.indexOf('(')==-1)
            toAdd+='()';
          if(value.indexOf('{')==-1)
            toAdd+='{';
          toAdd+='\n  ';


          list.push({text:value+toAdd,displayText:descr});
        }
      }
    }
    list.sort(function(a, b) {
      return a.displayText.toLowerCase() > b.displayText.toLowerCase() ? 1 : -1;
    });
    return list;
    */
  }

  var originalList = null;
  var initiator = null;
  function helper(editor, options) {
   /*se l'helper ritorna un array con un elemento non lo seleziona in automatico ma lascia la possibilita' all'utente di scegliere se selezionare il valore*/
    options.completeSingle=false;
    var cur = editor.getCursor(), curLine = editor.getLine(cur.line), prevCur = { line : cur.line, ch : cur.ch-1};
    var start = cur.ch, end = start;
    var currentToken = editor.getTokenAt(cur);
    var prevToken = editor.getTokenAt(prevCur);
    var list = [];
    if (originalList!=null) {
      start = currentToken.start;
      var offset, token;
      if (initiator=='_') {
        offset = currentToken.string.lastIndexOf('_')+1;
        token = currentToken.string.substr(offset);
        start += offset;
      } else {
        offset = 0;
        token = currentToken.string;
      }
      list = originalList.filter(function(el){ return el.displayText.lastIndexOf(token,0)==0 } );
    } else if (currentToken.string=='.') {
      if (prevToken.string=='this') { //variables
        list = thisHints();
      } else if (prevToken.type=='property' && itemNames().indexOf(prevToken.string)>-1 ) {
        list = itemHints(prevToken.string);
      }
      originalList = list;
      initiator = '.';
    } else if (Right(currentToken.string,1)=='_') {
      var item = Substr(prevToken.string,1,Len(prevToken.string)-1);
      prevToken = editor.getTokenAt(CodeMirror.Pos(cur.line, prevToken.start));
      if (prevToken.string==' ') {
        prevToken = editor.getTokenAt(CodeMirror.Pos(cur.line, prevToken.start));
        if (prevToken.string=='function') {
          if (itemNames().indexOf(item) > -1 || item=='this') {
            list = itemEvents(item);
          }
        }
      }
      originalList = list;
      initiator = '_';
    } else if (currentToken.string==' ') {
      if (prevToken.string=='function') { //propongo tutti gli item
        list = thisHints('_');
        list.unshift({text:'this_',displayText:'this'});
      }
      originalList = list;
      initiator = ' ';
      }
    return {list: list, from: CodeMirror.Pos(cur.line, start), to: CodeMirror.Pos(cur.line, end)};
  }
  if( fileType == "css" )
    codeMirrorOpt.mode="text/css";
  else {
    codeMirrorOpt.mode="javascript";
    CodeMirror.extendMode("javascript", {lineComment: "//"});
  }
  //CodeMirror.registerHelper("hint", "javascript", helper);
  codeMirrorOpt.extraKeys= {"Ctrl-R": "replace", "F3": "findNext", "Shift-F3": "findPrev", "Ctrl-Q": "toggleComment","Ctrl-S":function(){
      (parent.parent.saveTool?parent.parent.saveTool():(parent.save?parent.save():void(0)));parent.managed=true
    },
    "F2" : function(cm) {
      var pos = cm.getCursor(),
          found = -1,
          i;
      for (i = pos.line+1; found == -1 && i < cm.lineCount(); i++) { //righe successive
        var info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints ) {
          found = i;
        }
      }
      for (i = 0; found == -1 && i < pos.line; i++) { //righe precedenti
        var info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints ) {
          found = i;
        }
      }
      if (found>-1) {
        cm.setCursor({ line: found, ch: 0} );
      }
    },
    "Shift-F2" : function(cm) {
      var pos = cm.getCursor(),
          found = -1,
          i;
      for (i = pos.line-1; found == -1 && i >= 0; i--) { //righe precedenti inverse
        var info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints ) {
          found = i;
        }
      }
      for (i = cm.lineCount()-1; found == -1 && i > pos.line; i--) { //righe successive inverse
        var info = cm.lineInfo(i);
        if (info.gutterMarkers && info.gutterMarkers.breakpoints ) {
          found = i;
        }
      }
      if (found>-1) {
        cm.setCursor({ line: found, ch: 0} );
      }
    },
    "Ctrl-F2" : function(cm) {
      var pos = cm.getCursor(),
          info = cm.lineInfo(pos.line),
          hadBP = info.gutterMarkers && info.gutterMarkers.breakpoints;
      if (hadBP) {
        delete statuss.breakpoints[pos.line];
      } else {
        statuss.breakpoints[pos.line]=true;
      }
      cm.setGutterMarker(pos.line, "breakpoints", hadBP ? null : makeMarker());
    }
    }
  function makeMarker() {
    var marker = document.createElement("img");
    marker.src = "../portalstudio/images/icon/bookmark.png";
    return marker;
  }
  codeMirrorOpt.tabMode= "shift";
  codeMirrorOpt.theme=  ac_style && ac_style.theme ? ac_style.theme : 'default' ;
  codeMirrorOpt.tabSize = 2;
  codeMirrorOpt.indentUnit =2;
  codeMirrorOpt.statementIndent =2;
  codeMirrorOpt.lineNumbers =true;
  codeMirrorOpt.styleActiveLine= true;
  codeMirrorOpt.highlightSelectionMatches= true;
  codeMirrorOpt.enterMode ='keep';
  codeMirrorOpt.matchBrackets=true;
  codeMirrorOpt.gutters= ["CodeMirror-linenumbers", "breakpoints", "CodeMirror-foldgutter"];
  codeMirrorOpt.onChange=function(){changed=true};
  codeMirrorOpt.foldGutter=true;

  function createCodeArea(){
    if(opt_paneOpened)
      toggleOptPane();
    var h = $('editor').offsetHeight-50;
    codeEditor = CodeMirror($('editor'),codeMirrorOpt);
    codeEditor.on("fold", function(cm, from, to) {
      statuss.folded[from.line]=true;
    });
    codeEditor.on("unfold", function(cm, from, to) {
      delete statuss.folded[from.line];
    });
    codeEditor.on("change", function(cm,changeObj) {
      if (originalList!=null) return; //se autocompletamento gia' in funzione non faccio nulla
      var txt;
      if (changeObj.origin=='+delete') {
        var tk = cm.getTokenAt(changeObj.from);
        txt = Right(tk.string,1)
      } else {
        txt = changeObj.text[0];
      }
      if ([".","_"," "].indexOf(Right(txt,1))>-1) {
        cm.execCommand('autocomplete');
      }
    });
    codeEditor.on("endCompletion",function(cm) {
      originalList = null;
    });
    //codeEditor.getScrollerElement().style.height =h +'px';
    LibJavascript.CssClassNameUtils.addClass(codeEditor,'eventcode')
    codeEditor.getWrapperElement().id='eventcode';
    codeEditor.getWrapperElement().style.height='100%';

    $(codeEditor.getWrapperElement()).setStyle('font-size',ac_style.fontSize)
    codeEditor.getWrapperElement().value = codeEditor.getValue();

    /* Breakpoints */
    codeEditor.on("gutterClick", function(cm, n, type) {
      if ( type == "breakpoints" ) {
     var info = cm.lineInfo(n);
        var hadBP = info.gutterMarkers && info.gutterMarkers.breakpoints;
        if (hadBP) {
          delete statuss.breakpoints[n];
        } else {
          statuss.breakpoints[n]=true;
        }
        cm.setGutterMarker(n, "breakpoints", hadBP ? null : makeMarker());
      } else if ( type == "CodeMirror-linenumbers" ) {
        var info = cm.lineInfo(n);
        cm.setSelection( { line: n, ch : 0 }, {line: n , ch : info.text.length } );
      }
    });

    for (var i in statuss.breakpoints) {
      codeEditor.setGutterMarker(parseInt(i), "breakpoints", makeMarker());
    }
    for (var i in statuss.folded) {
      codeEditor.foldCode(CodeMirror.Pos(parseInt(i), 0));
    }
    codeEditor.refresh();
  }

  function buildSlider(){
    // Create the new slider instance
    var el = $('fontSlider');
    var font = $('eventcode');
    var knob = el.getElement('.knob');
    var val = new Element('p', {'class': 'value'}).inject(knob);
    var slider = new Slider(el, knob, {
      steps: 35,  // There are 35 steps
      range: [12],  // Minimum value is 8
      initialStep :ac_style.fontSize ? ac_style.fontSize : 13,
      onChange: function(value){
        // Everytime the value changes, we change the font of an element
        ac_style.fontSize = value;
        localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
        font.setStyle('font-size', value);
        $(codeEditor.getWrapperElement()).setStyle('font-size',value);
        val.set('text', value);
      }
    }).set(font.getStyle('font-size').toInt());
  }

  function toggleOptPane(){
    var range;
    if(opt_paneOpened){
      range = [0,-155];
      opt_paneToggle.slideOut();
      $('opt_pane_topbar_left').removeClass('open');
      var fnToDelay = function(){
        opt_paneTopToggle.start({
          'right':range
        });
        opt_paneOpened = !opt_paneOpened;
      }
      fnToDelay.delay(301);
    }else{
      range = [-155,0];
      $('opt_pane_topbar_left').addClass('open');
      opt_paneTopToggle.start({
        'right':range
      });
      var fnToDelay = function(){
        opt_paneToggle.slideIn();
        opt_paneOpened = !opt_paneOpened;
      }
      fnToDelay.delay(201);
    }
  }
  // function SaveAndClose(){
    // parent.itemsHTML[index].codeevents = codeEditor.getValue();
    // parent.itemsHTML[index].codestatuss = JSON.stringify(statuss);
    // parent.window.ActionCodeLayer.close();
    // parent.window.codeOpen=false;
  // }
  function save(folder) {
    //var folder_path=folder + '/styles/';
    var folder_path = fileName.substring(0, fileName.lastIndexOf("/"))
    notimooManager = new Notimoo({});
	  notimooManager.show({
	    title:'Notification message',
	    message: 'saving file...',
	    sticky : true,
	    width:200,
	    height:40
	  });
    var url;
    // if( fileName.endsWith(".css") )
    if( fileType == "css" )
      url = new JSURL("../servlet/JSPSave?type=css"+
        "&name="+Strtran(fileName,".css","")+
        "&code="+URLenc(codeEditor.getValue()) +
        "&m_cID=" + cmdhash
        ,true);
    else
      url = new JSURL("../servlet/JSPSave?type=jsp"+
        "&name="+Strtran(fileName,".jsp","")+
        "&code="+URLenc(codeEditor.getValue()) +
        "&m_cID=" + cmdhash
        ,true);
    output=url.Response();
    changed = false;
    if(window.parent.changeName) window.parent.changeName(fileName,folder_path,Strtran(window.frameElement.id,'portalstudioframe',''))
    if (output==null) output="";
    switch(output) {
    case "true":
      for(var i=0 ;i<notimooManager.elements.length;i++){
        notimooManager.close(notimooManager.elements[i]);
      }
      notimooManager.show({
        title:'Notification message',
        message: 'file saved!',
        visibleTime: 2000,
        width:200
		  });
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
  }
  function ResizeEditor(){
    clearTimeout(resizeTimer);
    var size_editor = $('editor').getSize();
    //var size = parent.ActionCodeLayer.getContainer().getSize();
    //ac_style.width = size.x;
    //ac_style.height = size.y;
    codeEditor.getScrollerElement().style.width=size_editor.x+'px';
    codeEditor.getScrollerElement().style.height=size_editor.y+'px';
    localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
  }
  /*********Gestione degli eventi************/
  window.addEvent('domready',function(){
    code = codeMirrorOpt.value = loadCode();
    window.fireEvent('createEditorComponent');
    opt_paneToggle = new Fx.Slide('opt_pane_wrapper',{
      'transition':Fx.Transitions.linear.easeOut,
      'duration':300
    }).hide();
    opt_paneTopToggle = new Fx.Morph('opt_pane_top_wrapper',{
      'duration':200
    });
    $$('.opt_pane_mode').each(function(i){
      i.addEvent('click',function(){
        var theme=Strtran(i.id,'change_style_','');
        codeEditor.setOption('theme',theme);
        ac_style.theme = theme;
        localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
      });
    });
    createCodeArea();
    buildSlider.delay(300);
    setTimeout(function(){codeEditor.getScrollerElement().style.height =$('editor').offsetHeight +'px';},300);
    codeEditor.focus();
  });
  document.id('opt_pane_topbar_left').addEvent('click',toggleOptPane);
  //document.id('toolbar_ok').addEvent('click',SaveAndClose);
  document.id('toolbar_help').addEvent('click',function(){
    document.id('helpkeys_content').toggleClass('visible');
  });
  document.id('toolbar_search').addEvent('click',function() {
    codeEditor.execCommand('find');
  });

  // document.id('toolbar_cancel').addEvent('click',function CheckClosefromX(){
    // if(changed){
        // if (confirm("Do you want to save Actions code ?\n\nClick OK to save\nClick Cancel to ignore changes"))
          // SaveAndClose()
        // else{
          // parent.window.ActionCodeLayer.close();
          // parent.window.codeOpen=false;
        // }
    // }else{
      // parent.window.ActionCodeLayer.close();
      // parent.window.codeOpen=false;
    // }
  // })
  document.body.addEvent('keydown',function(e){
    var domevt = new DOMEvent(e);
    var code = domevt.code;
    if(domevt.control && code==82){ //ctrl+r
      //Annullo il Ctrl-r di default
      if(e.preventDefault)e.preventDefault();
    }
  });
  window.addEvents({
    'restoreSize': function(spmodallayer){
      ac_style.maximized = false;
      localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
    }
  , 'maximized': function(spmodallayer){
      ac_style.maximized = true;
      localStorage.setItem('zucchetti_ac_style', JSON.encode(ac_style));
    }
  , 'resize': function(){ resizeTimer = ResizeEditor.delay(50) }
  , 'save': save
  });

  /**********Gestione dello specifico editor***************/
  function loadCode(){
    fileName='<%=JSPLib.ToJSValue(fileName)%>';
    var strreload='';
    if(!Empty(fileName)){
      var url;
      // if( fileName.endsWith(".css") )
      if( fileType == "css" )
        url = new JSURL("../servlet/JSPLoad?type=css&name="+Strtran(fileName,".css",""),true);
      else
        url = new JSURL("../servlet/JSPLoad?type=jsp&name="+Strtran(fileName,".jsp",""),true);
      strreload=url.Response();
    }
    return strreload;
  }
  window.addEvent('createEditorComponent',selectName);
  function writeCode(name,obj){
    /* effettua una ricerca della funzione nella text area. Se la trova posiziona il cursore, altrimenti la crea*/
    funct_evt=Ctrl("event_item").value;
    if(funct_evt=='-') return;
    var fnc='function '+name+'_';
    var LFidx = (fnc+funct_evt).search(/\n/);
    LFidx = LFidx==-1 ? (fnc+funct_evt).length : LFidx;
    var toFind=(fnc+funct_evt).substr(0, LFidx);//prende solo la prima riga
    var braceIdx=toFind.indexOf('(');
    if(braceIdx!=-1)
      toFind=toFind.substr(0,braceIdx)+'\\(';
    var idx = -1;
    idx = Strtran(codeEditor.getValue(),"\r","").search(new RegExp(toFind,'m'));
    fnc+=funct_evt;
    if(idx!=-1){
      idx+=LFidx+(braceIdx!=-1 ? 1 : ('(){'.length)+1);
      var a = codeEditor.getSearchCursor(toFind)
      if(a.find())
        codeEditor.setSelection(a.from(),a.to())
    } else {
      var toAdd='';
      if(fnc.indexOf('(')==-1)
        fnc+='()';
      if(fnc.indexOf('{')==-1)
        fnc+='{\n\n}';
      fnc+='\n';
      codeEditor.replaceRange(fnc,codeEditor.getCursor(true), codeEditor.getCursor(false))
    }
    obj.blur();
  }
  function option(val,descr,long_descr){
    return '<option title="'+(!Empty(long_descr)?long_descr:(arguments.length==1 ? val : descr))+'" value="'+val+'">'+(arguments.length==1 ? val : descr)+'</option>';
  }

  function selectName(){
    /*
    var name,src, i,
    str='<select id="id_item" tabindex="2" accesskey="t">'+
        '<option value="">-</option><option value="this">this</option>';
    var comboSelectItems=[];
    for(i=0;i<itemsHTML.length;i++){
      comboSelectItems.push(itemsHTML[i]);
    }
    comboSelectItems.sort(function (a,b) {
      var minA = a.name.toLowerCase();
      var minB = b.name.toLowerCase();
      if (minA < minB) { return -1; }
      else {
      if (minA > minB) { return 1; }
        else { return 0; }
      }
    });
    for(i=0;i<comboSelectItems.length;i++){
      var item_tmp=comboSelectItems[i];
      str+='<option ';
      if(item_tmp.type=='Portlet'){
        if(index!=null && item_tmp.name==itemsHTML[index].name){
          str+='selected ';
          name=item_tmp.name;
          src=item_tmp.src;
        }
        str+='value="'+item_tmp.src+'">'+item_tmp.name+'</option>';
      }else{
        if(index!=null && item_tmp.name==itemsHTML[index].name){
          str+='selected ';
          name=item_tmp.name;
        }
        str+='value="'+item_tmp.name+'">'+item_tmp.name+'</option>';
      }
    }

    str+='</select>';
    Ctrl("selectname").innerHTML=str;
    document.id('id_item').addEvent('change', function(){
      var idx=this.selectedIndex
        , txt=this.options[idx].text
        , val=this.options[idx].value
      ;
      selectEvent(txt, val);
      selectFunction(txt, val);
    });
    selectEvent(name,src);
    selectFunction(name,src);
    */
  }

  function selectEvent(name,src){
    /*
    var str='<select id="event_item" tabindex="3" accesskey="e"><option>-</option>',
    es, i, obj, found=false;
    if(name!='this'){
      for(i=0;i<itemsHTML.length;i++){
        obj=itemsHTML[i];
        src=obj.src;
        if(obj.name==name || src==name){
          found=true;
          es=obj;
          break;
        }
      }
    }else{
      found=true;
      // Aggiunta delle informazioni per il wizard
      // copia profonda
      es = {'objClass':{'events': form.objClass.events.slice() }};
      if( form.wizard ){
        for(var i=0;i<form.npages;i++){
          es.objClass.events.push (["Enable page "+(i+1)+", return boolean true if validate, false otherwise","EnablePage"+(i+1)+"()"])
        }
        for(var i=0;i<form.npages;i++){
          es.objClass.events.push (["Validate page "+(i+1)+", return boolean true if validate, false otherwise","ValidatePageChange"+(i+1)+"()"])
        }
      }
    }
    if(found){
      es=es.objClass.events;
      if(es){
        var value,descr;
        for(i=0;i<es.length;i++){
          if(IsA(es[i],'C')){
            value=descr=es[i];
          }else{
            descr=es[i][0];
            value=es[i][1];
          }
          str+=option(value,descr);
        }
      }
      if(obj!=null && obj.type=='Portlet' && src){
        var folder_path='';
        if(src.indexOf('/')>-1){
          folder_path='/'+name.substring(0,src.lastIndexOf('/'));
          src=Strtran(src,src.substring(0,src.lastIndexOf('/')+1),'');
        }
        //legge gli eventi nei portlet
        var url = new JSURL("../servlet/JSPReader?name="+src+"&folder_path="+folder_path+"&type=events",true);
        var eventsList=url.Response().split(',');
        for(var i=0;i<eventsList.length;i++){
          if(Trim(eventsList[i])!='')
            str+=option(eventsList[i]);
        }
      }
    }
    str+='</select>';
    Ctrl("selectevent").innerHTML=str;
    document.id('event_item').addEvent('change',function(){
      writeCode(name,this);
    });
    */
  }

  function selectFunction(name,src){
    /*
    var str='<select id="function_item" tabindex="4" accesskey="f"><option>-</option>'
    var fs;
    var found=false;
    if(name!='this'){
      for(var i=0,obj;i<itemsHTML.length;i++){
        obj=itemsHTML[i];
        src=obj.src;
        if(obj.name==name || src==name){
          found=true;
          fs=obj;
          break;
        }
      }
    }else{
      found=true;
      fs=form;
    }
    if(found){
      fs=fs.objClass.functions;
      if(fs){
        var descr,value,long_descr;
        for(var i=0;i<fs.length;i++){
          if(IsA(fs[i],'C')) value=descr=fs[i]
          else{
            descr=fs[i][0];
            value=fs[i][1];
            if(!Empty(fs[i][2])) long_descr=fs[i][2];
          }
          str+=option(value,descr,long_descr);
        }
      }
      if(obj!=null && obj.type=='Portlet' && src){
      //legge le functions dei portlet inclusi
        var folder_path='';
        if(src.indexOf('/')>-1){
          folder_path='/'+name.substring(0,src.lastIndexOf('/'));
          src=Strtran(src,src.substring(0,src.lastIndexOf('/')+1),'');
        }
        //legge gli eventi nei portlet
        var url = new JSURL("../servlet/JSPReader?name="+src+"&folder_path="+folder_path+"&type=functions",true);
        var eventsList=url.Response().split(',');
        for(var i=0;i<eventsList.length;i++)
          if(Trim(eventsList[i])!='')
            str+=option(eventsList[i]);
      }
    }else if(name=='-'){
      str+=option('Trim(#str#)');
      str+=option('Strtran(#src#,#find#,#repl#)');
      str+=option('Substr(#str#,#pos#,#cnt#)');
      str+=option('Left(#str#,#len#)');
      str+=option('Right(#str#,#len#)');
      str+=option('Str(#p_n#,#len#,#dec#)');
      str+=option('Val(#str#)');
      str+=option('Upper(#str#)');
      str+=option('Lower(#str#)');
      str+=option('At(#p_cStrFind#,#p_cStr#,#cnt#)');
      str+=option('Len(#obj#)');
      str+=option('DateToChar(#obj#)');
      str+=option('CharToDate(#obj#)');
      str+=option('Day(#obj#)');
      str+=option('Month(#obj#)');
      str+=option('Year(#obj#)');
    }
    str+='</select>';
    Ctrl("selectfunction").innerHTML=str;
    document.id('function_item').addEvent('change',function(){
      writeFunction(name,this);
    });
    */
  }

  // function writeFunction(name,obj){
    // var str,func=Ctrl("function_item").value;
    // if(func=='-') return;
    // if(name=='-')
      // str=func+'\n'
    // else if(name=='this')
      // str='this.'+func+'\n'
    // else
      // str='this.'+name+'.'+func+'\n';
    // codeEditor.replaceRange(str,codeEditor.getCursor(true), codeEditor.getCursor(false))
    // obj.blur();
  // }

</script>
