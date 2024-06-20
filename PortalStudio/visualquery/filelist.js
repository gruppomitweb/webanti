/* exported
    w_remote_server w_remote_user w_remote_password w_remote_company w_remote_instance
    w_remote_mode
    EMPTY_MSG SelectFromList DoLoad ToggleRemoteDetails remote_server_blur remote_details_keypress
    allFiles_onkeyup filename_onkeyup filename_onkeydown filename_onkeypress

  */
var w_remote_server = "";
var w_remote_user = "";
var w_remote_password = "";
var w_remote_company = "";
var w_remote_instance = "";
var w_remote_mode = "";
var w_operation = "";
var customQry = "";

function EMPTY_MSG() {
  return "Please specify server address";
}

function SelectFromList(){
  var ctrl   = Ctrl('allFiles'),
      selIdx = ctrl.selectedIndex,
      value;
  if ( selIdx>=0 && (value = ctrl.options[selIdx].value) ) {
    Ctrl("filename").value = value;
    SelectThisFile();
  }
}
function SelectThisFile(){
  var value = Ctrl("filename").value;
  if( !Empty(value) && value!="LICENSE LIMIT" && value!="ACCESS DENIED" ) {
    GetOpener().tempFilename = value;
    if ( w_operation="import" ) {  // eslint-disable-line no-cond-assign
      Params.fromCtrls().toInitValues();
    }
    GetOpener().DoOperation();
  }
  WindowClose();
}

function DoLoad(){
  w_operation = GetOpener().fileDialogOperation;
  customQry=GetOpener().document.getElementById('customQry').checked;
  var buttonText = "";
  window.focus();
  switch (w_operation) {
    case "open" :
      buttonText = "Open";
      break;
    case "saveas" :
      buttonText = "Save As";
      Ctrl("filename").focus();
      break;
    case "testconfiguration" :
    case "union" :
    case "filters" :
    case "temptable" :
    case "listQuery" :
      buttonText = "Select";
      break;
    case "import" :
      Ctrl("server_container").style.display = "";
      Params.fromInitValues().toCtrls();
      buttonText = "Import";
      break;
  }
  FillList();
  Ctrl("OperationButton").value = buttonText;
  document.title = buttonText;
  Ctrl('filename').focus();
}

var OBF_REMOTEUSER = "[ OBFUSCATED USERNAME ]";
function GuessIsObfuscated(str) {
  return str.length>255 && str.match(/%[a-f0-9]{2}/i);
}
function SetRemoteUser(user) {
  var ctrl = Ctrl("remote_user");
  if ( IsA(user, 'C') ) {
    if ( GuessIsObfuscated(user) ) {
      ctrl.value = OBF_REMOTEUSER;
    } else {
      ctrl.value = user;
    }
    ctrl.setAttribute("remote_user", user);
  } else {
    ctrl.value = "";
    ctrl.setAttribute("remote_user", "");
  }
}
function GetRemoteUser(){
  var ctrl = Ctrl("remote_user");
  if ( ctrl.value!=OBF_REMOTEUSER ) {
    return ctrl.value;
  }
  return ctrl.getAttribute("remote_user");
}

var Params = new function(){
  var aParms = [ 'remote_server'
               , 'remote_user'
               , 'remote_password'
               , 'remote_company'
               , 'remote_instance'
               , 'remote_mode'
               ];

  var _initValues = { 'remote_server'  : GetOpener().tempRemote_server
                    , 'remote_user'    : GetOpener().tempRemote_user
                    , 'remote_password': GetOpener().tempRemote_password
                    , 'remote_company' : GetOpener().tempRemote_company
                    , 'remote_instance': GetOpener().tempRemote_instance
                    , 'remote_mode'    : GetOpener().tempRemote_mode
                    };

  var _parms = {
    getUrlString: function() {
      var strRes = '';
      LibJavascript.Array.forEach(aParms, function(parm) {
        if ( parm!='remote_user' ) {
          strRes += '&'+parm+'='+URLenc( this[parm] || '' );
        } else {
          strRes += '&'+parm+'='+URLenc( GetRemoteUser() );
        }
      }, this);
      return strRes;
    }
    , toCtrls: function() {
      LibJavascript.Array.forEach(aParms, function(parm){
        if ( parm!='remote_user' ) {
          Ctrl(parm).value = this[parm];
        } else {
          SetRemoteUser(this[parm]);
        }
      }, this);
      return this;
    }
    , fromCtrls: function() {
      LibJavascript.Array.forEach(aParms, function(parm){
        if ( parm!='remote_user' ) {
          this[parm] = Ctrl(parm).value;
        } else {
          this[parm] = GetRemoteUser(Ctrl(parm).value);
        }
      }, this);
      return this;
    }
    , fromInitValues: function() {
      LibJavascript.Array.forEach(aParms, function(parm){
        this[parm] = _initValues[parm];
      }, this);
      return this;
    }
    , toInitValues: function() {
      GetOpener().tempRemote_server   = this.remote_server;
      GetOpener().tempRemote_user     = GetRemoteUser();
      GetOpener().tempRemote_password = this.remote_password;
      GetOpener().tempRemote_company  = this.remote_company;
      GetOpener().tempRemote_instance = this.remote_instance;
      GetOpener().tempRemote_mode     = this.remote_mode;
      return this;
    }
  };
  return _parms;
};

var FilesList = [];
function FillList(){
  var allFiles = Ctrl("allFiles");
  allFiles.options.length = 0; //vuota la lista
  eval('FilesList = '+
    new JSURL("../servlet/SPVQRProxy?"+
                "action=" +
                (w_operation!="testconfiguration"
                  ?
                    "vqr"
                  :
                  "testconfigurationfile"
                )+
                ( w_operation!="import"
                  ?
                    (GetOpener().offlinemode?"&offlinemode=true":'')
                  :
                    Params.fromCtrls().getUrlString()
                )+
                (w_operation=='saveas'?
                  "&custom="+customQry:""
                )
             ).Response().replace(/\.vqr(\.offline)?/gi, '').replace(/\.json/gi,'')
  );
  for (var i=0,f,o,l=FilesList.length; i<l; ){
    f = FilesList[i++];
    o = new Option(f, f, false, false);
    o.title = f; //per nomi lunghi si vede almeno il tooltip senza allargare il popup
    allFiles.options[allFiles.options.length] = o;
  }
}

function getSelectedIndex() {
  return Ctrl("allFiles").selectedIndex;
}

function SelectFile(){
  var selection = Ctrl("allFiles").options[getSelectedIndex()].value;
  Ctrl("filename").value = selection;
  Ctrl("filename").title = selection;
  Ctrl("filename").select();
}

function select_first(takeBackToInput){
  if ( FilesList.length > 0 ) {
    if ( getSelectedIndex() != -1 )
      Ctrl('allFiles').options[getSelectedIndex()].selected = false;
    Ctrl('allFiles').options[0].selected = true;
    Ctrl('allFiles').scrollTop = 0;
  }
  if ( takeBackToInput )
    SelectFile();
}

function select_prev(takeBackToInput) {
  var selIdx = getSelectedIndex();
  if ( selIdx > 0) {
    Ctrl("allFiles").options[selIdx].selected = false;
    Ctrl("allFiles").options[selIdx-1].selected = true;
    if ( takeBackToInput )
      SelectFile();
  } else {
    select_first(takeBackToInput);
  }
}

function select_next(takeBackToInput) {
  var selIdx = getSelectedIndex(); // -1 = no selection
  if ( selIdx >= 0 && selIdx < FilesList.length-1 ) {
    Ctrl("allFiles").options[selIdx].selected = false;
    Ctrl("allFiles").options[selIdx+1].selected = true;
    if ( takeBackToInput )
      SelectFile();
  } else {
    select_first(takeBackToInput);
  }
}

function ToggleRemoteDetails() {
  var expand = Ctrl('remote_details').style.display == 'none';
  Ctrl('remote_details_toggle').style.backgroundPosition = expand ? 'top' : 'bottom';
  Ctrl('remote_details').style.display = expand ? '' : 'none';
}

function remote_server_blur(){
/*  var remote_server = Ctrl('remote_server').value;
  if ( !Empty(remote_server) && !/^http[s]?:\/\//.match(remote_server)) {
    Ctrl('remote_server').value = 'http://'+remote_server;
  }*/
}

function remote_details_keypress(e){
  var kCode=GetKeyCode(e ? e : window.event);
  switch (kCode){
    case 13://return
      FillList();
    case 27://esc
      Params.toCtrls();
  }
}

function allFiles_onkeyup(e){
  switch (GetKeyCode(e ? e : window.event)){
    case 13://return
      SelectThisFile();
      break;
    case 27://esc
      WindowClose();
      break;
  }
}

function filename_onkeyup(e) {
  switch (GetKeyCode(e ? e : window.event)){
    case 13://return
      SelectThisFile();
      break;
    case 27://esc
      WindowClose();
      break;
    case 46://del
    case 8://backspace
      filterlist();
      break;
  }
}

function filename_onkeydown(e) {
  switch (GetKeyCode(e ? e : window.event)){
    case 38://up
      select_prev(true);
      break;
    case 40://down
      select_next(true);
      break;
  }
}

function filename_onkeypress(/*e*/) {
  if ( Ctrl('filename').value.match(/\w*/) )
    filterlist();
}

var timeoutId;
function filterlist(){
  //tecnica "Debounce"
  //http://unscriptable.com/index.php/2009/03/20/debouncing-javascript-methods/
  if ( timeoutId )
    clearTimeout(timeoutId);
  timeoutId = window.setTimeout(function(){
    search(Ctrl('filename').value);
    timeoutId = null;
  }, 300);
}

function search(term) {
  var o;
  var grp = Ctrl('search_res');
  if ( !grp ) {
    grp = document.createElement('optgroup');
    grp.id = 'search_res';
    grp.setAttribute('label','Search results');
    LibJavascript.DOM.insertNode(Ctrl('allFiles'), 0, grp);
  }

  grp.innerHTML='';
  if ( !term || term=='') {
    LibJavascript.DOM.removeNode(grp);
  } else {
    var error = false;
    try {
      var re = new RegExp(term);
    } catch(err) {
      o = document.createElement('option');
      o.innerHTML = "Search error";
      grp.appendChild(o);
      error = true;
    }
    if( !error ) {
      var someMatch = false
      for (var i=0; i<FilesList.length; i++){
        if ( re.test(FilesList[i]) ) {
          o = document.createElement('option');
          o.innerHTML = FilesList[i];
          o.value = FilesList[i];
          grp.appendChild(o);
          someMatch = true;
        }
      }
      if ( !someMatch ) {
        o = document.createElement('option');
        o.innerHTML = "No results";
        o.value = "";
        grp.appendChild(o);
      }
    }
  }
  select_first(false);
}
