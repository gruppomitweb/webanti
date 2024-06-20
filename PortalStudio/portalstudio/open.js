/* global painter */
if(painter == 'pageleteditor') {
  painter = 'pagelet';
}
var parameters = {
  portlet: {title:'Open portlet', hasDescription: true},
  decorators: {title:'Open decorator', hasDescription: false},
  pagelet: {title:'Open pagelet', hasDescription: true},
  pageleteditor: {title:'Open pagelet editor', hasDescription: true},
  plan: {title:'Open plan', hasDescription: true},
  visualquery: {title:'Open portlet', custom: false, offlinemode: false, hasDescription: true },
  portalzoom: {title:'Open portalzoom', custom: false, hasDescription: true},
  chart: {title:'Open chart', custom: false, hasDescription: true},
  manualjsp: {title:'Open manual jsp', hasDescription: true},
  html: {title:'Open html', hasDescription: false},
  templates: {title:'Open templates', hasDescription: false},
  menu: {title:'Open menu file', custom: false, offlinemode: false, hasDescription: false},
  css: {title:'Open css', hasDescription: false},
  cssclass: {title:'Open css class', hasDescription: false},
  module: {title:'Open module', hasDescription: true},
  scandoc: {title:'Open scandoc', hasDescription: false},
  report: {title:'Open report', custom: false, hasDescription: true},
  maskparameters: {title:'Open mask parameter', custom: false, hasDescription: true},
  smartreport: {title:'Open smart report', custom: false, hasDescription: true},
  interfaces: {title:'Open interface', custom: false, hasDescription: false, altInterfaceFor:window.altInterfaceFor},
  css_class: {title:'Open css class', typeObj: window.cssType, hasDescription: false},
  queryParms: {title:'Select query fields',offline: 'false', queryname: window.queryName, hasDescription: true},
  variable_field_picker: {title:'Variable',offline: 'false', hasDescription: false, clientSide:true},
  formstyle: {title:'Select a css file', hasDescription: false},
  procedures: {title: 'Select a procedure', offline: window.isOffline, hasDescription: true},
  getportletctrls: {title: 'Select '+window.ctrlsToBeListed+' from '+window.fromPortletName, ctrlname: window.ctrlsToBeListed, portlet_name: window.fromPortletName, hasDescription: false},
  parametersSources: {title: 'Parameter sources', hasDescription: true, clientSide:true},
  visualpivot: {title:'Open VisualPivot editor', custom: false, hasDescription: true}
};

var wheretofind;

document.onkeydown = function (e) {
  if(e.keyCode === 27) { // ESC: chiudi finestra
    window.close();
  }
};

function getOpener() {
  return(window.opener ? window.opener : (window.caller ? window.caller : window.parent));
}

var skin_selected = "";
var pos_list = 0;

function openFile(name) {
  if(painter == 'planpages') painter = "plan";
  var path_tmp = getPainterPath(parameters[painter].folder_path || '', painter);
  if(painter == 'pagelet') {
    var type = new JSURL('../servlet/JSPReader?action=getType&name=' + name + '&folder_path=' + path_tmp, true, function (response) {
      type = response.Response().toLowerCase();
      getOpener().newCurrentObj(name, type, JSON.stringify(parameters[painter]));
      window.close();
    });
  } else {
    if(painter == 'smartreport')
      getOpener().newCurrentObj(name, painter, JSON.stringify(parameters[painter]), onetool);
    else
      getOpener().newCurrentObj(name, painter, JSON.stringify(parameters[painter]));
    if(!Empty(SPModalLayerId))
      getOpener().closeSPModalLayer();
    else
      window.close();
  }
}

function hideSidebar() {
  document.querySelector('.tools-container')
  .classList
  .add('hide-element');
}

window.addEventListener('DOMContentLoaded', function () {
  if(document.getElementById(painter)) document.getElementById(painter).classList.add('active');
  if(window.closeSidebar) hideSidebar();
  updateList();
  if(onetool == true) {
    document.getElementById('open-default').classList.add('hide-element');
    document.getElementById('open-tag').classList.add('hide-element');
  }
  if(painter != 'portlet') {
    document.getElementById('open-tag').classList.add('hide-element');
    document.getElementById('open-default').classList.add('hide-element');
  }
  if(painter != 'plan') {
    document.getElementById('open-plan').classList.add('hide-element');
    document.getElementById('open-page').classList.add('hide-element');
  }
  if(!parameters[painter].hasDescription) {
    document.getElementById('search-description').classList.add('hide-element');
    document.getElementById('search-title').classList.add('hide-element');
    wheretofind = 'name';
    document.getElementById('search-file').classList.add('only-search');
  }
  document.querySelectorAll('.tab').forEach(function (el) {
    el.addEventListener('click', function () { /*cambio del tab dei painter*/
        if(!this.classList.contains('active') && onetool == false) {
          painter = this.id;
          if(!parameters[painter].hasDescription) {
            document.getElementById('search-description').classList.add('hide-element');
            document.getElementById('search-title').classList.add('hide-element');
            wheretofind = 'name';
            document.getElementById('search-file').classList.add('only-search');
          } else {
            document.getElementById('search-description').classList.remove('hide-element');
            document.getElementById('search-title').classList.remove('hide-element');
            wheretofind = 'name';
            document.getElementById('search-file').classList.remove('only-search');
          }
          var activeEl = document.getElementById('tools').querySelector('.active');
          activeEl.classList.remove('active');
          this.classList.add('active');
          if(painter == 'decorators' || painter == 'css' || painter == "cssclass") {
            if(!Empty(skin_selected)) //Se almeno una skin è attiva
              parameters[painter].folder_path = document.getElementById('skin-list').querySelector('.active').innerText;
            else
              delete parameters[painter].folder_path;
          } else if(painter == 'pagelet' || painter == 'pageleteditor') {
            if(!Empty(skin_selected)) //Se almeno una skin è attiva
              parameters[painter].folder_path = document.getElementById('skin-list').querySelector('.active').innerText;
            else
              delete parameters[painter].folder_path;
          } else if(painter == 'menu' || painter == 'visualquery' || painter == "chart") { /*Passaggio della proprietà di offline tra i painter*/
            if(document.querySelector('#offline input[type=checkbox]').checked == true) {
              parameters[painter].offlinemode = true;
            } else {
              parameters[painter].offlinemode = false;
            }
          } else if(painter == 'menu' || painter == 'portalzoom' || painter == 'visualquery' || painter == 'report' || painter == 'maskparameters' || painter == "chart" || painter == "smartreport" || painter == "interfaces") { /*Passaggio della proprietà di custom tra i painter*/
            if(document.querySelector('#custom input[type=checkbox]').checked == true) {
              parameters[painter].custom = true;
            } else {
              parameters[painter].custom = false;
            }
          }
          if(painter != 'portlet') {
            document.getElementById('open-tag').classList.add('hide-element');
            document.getElementById('open-default').classList.add('hide-element');
          } else {
            document.getElementById('open-tag').classList.remove('hide-element');
            document.getElementById('open-default').classList.remove('hide-element');
          }
          if(painter != 'plan') {
            document.getElementById('open-plan').classList.add('hide-element');
            document.getElementById('open-page').classList.add('hide-element');
          } else {
            document.getElementById('open-plan').classList.remove('hide-element');
            document.getElementById('open-page').classList.remove('hide-element');
            document.getElementById('open-plan').classList.add('active');
            document.getElementById('open-page').classList.remove('active');
          }
          updateList();
        }
      }
    );
  });
  /*Offline value*/
  document.querySelector('#offline input[type=checkbox]').addEventListener('change', function () {
    if(painter == 'visualquery' || painter == 'menu') {
      if(this.checked == true) {
        parameters[painter].offlinemode = true;
      } else {
        parameters[painter].offlinemode = false;
      }
    }
    updateList();
  });
  /*Custom value*/
  document.querySelector('#custom input[type=checkbox]').addEventListener('change', function () {
    if(this.checked == true) {
      parameters[painter].custom = true;
    } else {
      parameters[painter].custom = false;
    }
    if (painter == 'interfaces')
      parameters[painter].folder_path = '';
    updateList();
  });

  search = document.getElementById('search-file');
  search.value = '';
  search.focus();
  var searchTimer = null;
  currValue = "";
  wheretofind = 'name';

  search.addEventListener('keyup', function(){
    if(currValue != search.value) {
      clearTimeout(searchTimer);
      if(search.value.length > 2 || search.value.length == 0)
        searchTimer = setTimeout(searchP, 500);
    }
  });
  search.addEventListener('keydown', function(e){
    if(e.key == 'down') {
      e.preventDefault();
      slideList('down');
    }
    if(e.key == 'up') {
      e.preventDefault();
      slideList('up');
    }
    if(e.key == 'enter') {
      e.preventDefault();
      if(visibleItems[pos_list] != undefined)
        visibleItems[pos_list].dispatchEvent(new Event('dblclick'));
    }
  });

  document.getElementById('list').addEventListener('keydown', function(e/*, fromSearch*/) {
      if(e.key == 'down') {
        e.preventDefault();
        slideList('down');
      }
      if(e.key == 'up') {
        e.preventDefault();
        slideList('up');
      }
      if(e.key == 'enter') {
        e.preventDefault();
        if(visibleItems[pos_list] != undefined)
          visibleItems[pos_list].dispatchEvent(new Event('dblclick'));
      }
  });

  document.getElementById('search-title').addEventListener('click', function () {
    document.getElementById('search-description').classList.remove('active');
    this.classList.add('active');
    wheretofind = 'name';
    searchP();
  });
  document.getElementById('search-description').addEventListener('click', function () {
    document.getElementById('search-title').classList.remove('active');
    this.classList.add('active');
    wheretofind = 'description';
    searchP();
  });
  document.getElementById('clear').addEventListener('click', function () {
    search.value = "";
    search.dispatchEvent(new Event('keyup'));
  });
  var skin;
  for(var i = 0; i < skins.length - 1; i++) {
    skin = document.createElement('div')
    skin.classList.add('skin-tab');
    skin.innerHTML = skins[i];
    if(skins[i] == theme_tmp) {
      skin.classList.add('active');
    }
    var skin_list = document.getElementById('skin-list');
    skin_list.appendChild(skin);
    skin.addEventListener('click', function() {
      skin_list.querySelector('.active').classList.remove('active');
      this.classList.add('active');
      skin_selected = Trim(this.innerText);
      if(painter == 'decorators' || painter == 'css' || painter == "cssclass")
        parameters[painter].folder_path = this.innerText;
      else
        parameters[painter].folder_path = this.innerText;
      updateList();
      // Update list dello skin selezionato
    });
  }
  skin = document.createElement('div');
  skin.classList.add('skin-tab'); //Skin root
  skin.innerHTML = "&nbsp;-&nbsp;";
  skin.classList.add('active');
  skin_list = document.getElementById('skin-list');
  skin_list.appendChild(skin);
  skin.addEventListener('click', function () {
    skin_selected = "";
    skin_list.querySelector('.active').classList.remove('active');
    this.classList.add('active');
    if(painter == 'decorators' || painter == 'css' || painter == "cssclass")
      parameters[painter].folder_path = '';
    else
      parameters[painter].folder_path = '';
    updateList();
  });
  document.getElementById('open-tag').addEventListener('click', function () {
    document.getElementById('open-default').classList.remove('active');
    document.getElementById('tools').parentNode.classList.add('hide-element');
    document.getElementById('search-handler').classList.add('hide-element');
    this.classList.add('active');
    var listelm = document.getElementById('list');
    listelm.classList.add("wrapper-tag");
    listelm.classList.remove("child-scrollable");
    var html = '<div><h2>Available files</h2><div class="child-scrollable" id="listtagmode"></div></div>';
    html += '<div><h2>Selected tags</h2><div class="child-scrollable" id="tagselected"></div></div>';
    html += '<div><h2>Available tags</h2><div class="child-scrollable" id="taglist"></div></div>';
    listelm.innerHTML = html;
    fillTags();
  });
  document.getElementById('open-default').addEventListener('click', function () {
    document.getElementById('open-tag').classList.remove('active');
    document.getElementById('tools').parentNode.classList.remove('hide-element');
    document.getElementById('search-handler').classList.remove('hide-element');
    this.classList.add('active');
    document.getElementById('list').classList.remove("wrapper-tag");
    document.getElementById('list').classList.add("child-scrollable");
    updateList(painter);
  });
  document.getElementById('open-page').addEventListener('click', function () {
    document.getElementById('open-plan').classList.remove('active');
    this.classList.add('active');
    updateList('planpages');
  });
  document.getElementById('open-plan').addEventListener('click', function () {
    document.getElementById('open-page').classList.remove('active');
    this.classList.add('active');
    updateList('plan');
  });
});

var fileList, navBar2;
var activeUrl;
var activeUrlDescr;
var ActiveUrls=[];
function updateList(p) {
  document.getElementById('list').classList.add('loader');
  visibleItems = [];
  if(!p) {
    document.getElementById('tools').querySelectorAll('.active').forEach(function (el) {
      painter = el.id;
    });
  }else{
    painter = p;
  }
  if(painter == "decorators" || painter == "pagelet" || painter == "pageleteditor" || painter == "css" || painter == "cssclass") {
    document.getElementById('skin-list').classList.remove('hide-element');
  } else {
    document.getElementById('skin-list').classList.add('hide-element');
  }
  if(painter == "visualquery" || painter == "menu" || painter == "portalzoom" || painter == "report" || painter == "maskparameters" || painter == "chart" || painter == "smartreport" || painter == "interfaces" || painter == "visualpivot") {
    document.getElementById('filter').classList.remove('hide-element');
    if(painter == "visualquery" || painter == "menu") {
      document.getElementById('offline').classList.remove('hide-element');
      if(offlinemode != '') {
        document.getElementById('offline').querySelector('input').setAttribute('checked', offlinemode == 'true');
        document.getElementById('offline').querySelector('input').disabled = true;
        parameters[painter].offlinemode = offlinemode == 'true';
      }
    } else {
      document.getElementById('offline').classList.add('hide-element');
    }
    document.getElementById('custom').classList.remove('hide-element');
  } else {
    document.getElementById('filter').classList.add('hide-element');
  }

  fileList = document.getElementById('list');
  fileList.replaceChildren();
  navBar2 = document.getElementById('nav2');
  if (painter!='interfaces'){
    parameters.interfaces.folder_path='';
    fileList.classList.remove('listInterfaces');
    navBar2.replaceChildren();
    navBar2.style.display='none';
  }
  var jsUrlStr = getJsUrl(painter, parameters[painter]);
  if(jsUrlStr.length == 0) {
    if(checkNoServerSideSources()) {
      doClientSideText();
    }
  } else {
    activeUrl=jsUrlStr[0];
    if(ActiveUrls.indexOf(activeUrl)==-1){
      ActiveUrls.push(activeUrl);
      //timestamp = new Date().getTime().toString();
      // if(JSURLObj!=null){
        // JSURLObj.Abort();
      // }
      var JSURLObj=new ZtVWeb.JSURL(jsUrlStr[0], true, callbackRender,null,activeUrl);
      JSURLObj.Response();
    }
  }
}

var origStore = {};

function callbackRender(listobj,oldurl){
  LibJavascript.Array.remove(ActiveUrls,ActiveUrls.indexOf(oldurl));
  setTitle();
  origStore = {};
  if(activeUrl!=oldurl){
    return
  }
  var files = getTextFor(painter, listobj)
  var html = '',i,name;
  if (painter!='interfaces' || !Empty(parameters[painter].folder_path)){
    for(i = 0; i < files.length; i++) {
      if(files[i] != "" && files[i].indexOf('[') == -1) { //TODO check cartelle lato servlet
        name = getFileName(files[i], painter)[0];
        let el = getElementWithName(name);
        el.setAttribute('id', 'portlet_'+i);
        fileList.appendChild(el);
        if(fileList.querySelector('.empty-list')) {
          fileList.querySelector('.empty-list').remove();
        }
        origStore['portlet_'+i] = {};
        origStore['portlet_'+i].origName = name;
        origStore['portlet_'+i].descr = '';
      }
    }
  }
  else {
    if (files.length>0){
      for (i = 0; i < files.length; i++){
        if(files[i] != "" && At("custom_",files[i])!=1) {
          name = files[i];
          if(window.altInterfaceFor === '') {
            html += "<div name='" + name + "' class='interfacesFolder' id='interfacesFolder_" + i + "'>";
            html += name;
            html += "</div>";
          } else if(window.altInterfaceFor === files[i]) {
            html += "<div name='" + name + "' class='interfacesFolder' id='interfacesFolder_" + i + "'>";
            html += name;
            html += "</div>";
          }
        }
      }
      navBar2.innerHTML=html;
      navBar2.style.display='inline-block';
      fileList.classList.add('listInterfaces');
      document.querySelectorAll('.interfacesFolder').forEach(function (el) {
        el.addEventListener('click',  function () {
          document.querySelectorAll('.selected-interfacesFolder').forEach(function (elm) {
            elm.classList.remove('selected-interfacesFolder');
          });
          el.classList.add('selected-interfacesFolder');
          parameters[painter].folder_path=el.getAttribute('name');
          updateList(painter);
          }
        )
      });
      if (document.querySelector('.interfacesFolder'))
        document.querySelector('.interfacesFolder').dispatchEvent(new Event('click'));
      // addClass('selected-interfacesFolder')
      // parameters[painter].folder_path=files[0];
      // updateList();
    }
  }

  var jsUrlStr = getJsUrl(painter, parameters[painter]);
  activeUrlDescr=jsUrlStr[1];
  if(activeUrlDescr &&ActiveUrls.indexOf(activeUrlDescr)==-1){
    ActiveUrls.push(activeUrlDescr);
    var JSURLObjDescr=new ZtVWeb.JSURL(activeUrlDescr, false, callbackDescrs,null,[oldurl,activeUrlDescr]);
    JSURLObjDescr.Response();
  }
  document.querySelectorAll('.file-item').forEach(function (el) {
    el.addEventListener('click', function() {
      document.querySelectorAll('.selected-file').forEach(function (elm) {
        elm.classList.remove('selected-file');
      });
      el.classList.add('selected-file');
      pos_list = visibleItems.indexOf(el);
    });
    el.addEventListener('dblclick', function() {
      if((this.getAttribute('name')).toLowerCase() != "access denied") {
        let name = this.getAttribute('name');
        if(painter == 'planpages')
          name = this.PlanName;
        if(painter == 'queryParms') {
          name = name.split(' ')[0];
        }
        if(!Empty(callerFunction) && getOpener()) {
          getOpener()[callerFunction](ReturnObjectId, name, parameters[painter], painter);
          WindowClose();
        } else openFile(name);
      }
    });
    visibleItems.push(el);
  });

  if(visibleItems.length == 0) {
    let emptyListDiv = document.createElement('div')
    emptyListDiv.classList.add('empty-list');
    emptyListDiv.innerHTML = '<span>No file found in ' + painter + '.</span>';
    document.getElementById('list')
      .appendChild(emptyListDiv)
  }
  document.getElementById('list').classList.remove('loader');
  pos_list = 0;
  if(!Empty(document.getElementById('search-file').value))
    searchP();
  slideList('first');
}

function checkNoServerSideSources() {
  return 'clientSide' in parameters[painter];
}

function doClientSideText() {
  setTitle();
  const origStore = {};
  var files = getTextFor(painter)
  var i,name;
  for(i = 0; i < files.length; i++) {
    if(files[i] != "" && files[i].indexOf('[') == -1) { //TODO check cartelle lato servlet
      name = getFileName(files[i], painter)[0];
      let el = getElementWithName(name);
      el.setAttribute('id', 'portlet_'+i);
      fileList.appendChild(el);
      origStore['portlet_'+i] = {};
      origStore['portlet_'+i].origName = name;
      origStore['portlet_'+i].descr = '';
    }
  }
  document.querySelectorAll('.file-item').forEach(function (el) {
    el.addEventListener('click', function() {
      document.querySelectorAll('.selected-file').forEach(function (elm) {
        elm.classList.remove('selected-file');
      });
      el.classList.add('selected-file');
      pos_list = visibleItems.indexOf(el);
    });
    el.addEventListener('dblclick', function() {
      if((this.getAttribute('name')).toLowerCase() != "access denied") {
        let name = this.getAttribute('name');
        if(painter == 'planpages')
          name = this.PlanName;
        if(painter == 'queryParms') {
          name = name.split(' ')[0];
        }
        if(!Empty(callerFunction) && getOpener()) {
          getOpener()[callerFunction](ReturnObjectId, name, parameters[painter], painter);
          WindowClose();
        } else openFile(name);
      }
    });
    visibleItems.push(el);
  });

  if(parameters[painter].hasDescription) {
    doClientSideDescriptions(origStore);
  }

  if(visibleItems.length == 0) {
    let emptyListDiv = document.createElement('div')
    emptyListDiv.classList.add('empty-list');
    emptyListDiv.innerHTML = '<span>No file found in ' + painter + '.</span>';
    document.getElementById('list')
      .appendChild(emptyListDiv)
  }
  document.getElementById('list').classList.remove('loader');
  pos_list = 0;
  if(!Empty(document.getElementById('search-file').value))
    searchP();
  slideList('first');
}

function doClientSideDescriptions(origStore) {
  let descriptions = getDescTextFor(painter);
  document.querySelectorAll('.name').forEach(function (el, index) {
    if(typeof (descriptions[index]) != "undefined" && descriptions[index] != "''" && descriptions[index]) {
      var descr = getDescr(descriptions[index])
      origStore[el.parentElement.id].descr = descriptions[index];
      el.appendChild(descr)
    }
  });
}

var search;
var currValue;
var visibleItems = [];

function searchP() {
  var txtToSearch = (search.value.trim()).toLowerCase();
  currValue = txtToSearch;
  if(txtToSearch != "") visibleItems = [];
  Object.keys(origStore).forEach(function(key){

    const el = document.getElementById(key);

    if(txtToSearch != "") {
      let keyToSearch = wheretofind == 'name' ? origStore[key].origName : origStore[key].descr;
      const txt = keyToSearch.toLowerCase();
      el.classList.add('hide-element');
      el.classList.remove('filtered');
      if(txt != "" && txt.indexOf(txtToSearch) != -1) {

        var re = new RegExp(txtToSearch, "gi");
        var nTxt = keyToSearch.match(re).
          reduce(function(prev, curr){
            return prev.replace(re, "<span class='text-found'>" + curr + "</span>");
          }, keyToSearch);

        if(wheretofind == 'name') {
          let p = el.querySelector('.name');
          el.querySelector('.name').innerHTML = nTxt;
          let descr = getDescr(origStore[key].descr);
          p.appendChild(descr);
        } else {
          el.querySelector('.description').innerHTML = nTxt;
        }

        el.classList.remove('hide-element');
        el.classList.add('filtered');
        visibleItems.push(el);
      }
    } else {
      let targetName = el.querySelector('.name');
      let targetDescr = el.querySelector('.description');
      el.classList.remove('hide-element');
      targetName.innerText =  origStore[el.id].origName;
      if(targetDescr) {
          targetDescr.innerText = origStore[el.id].descr;
          targetName.appendChild(targetDescr);
       }
      visibleItems.push(el);
    }
  });

  slideList('first');
}

function getTextFor(painter, listobj) {
  switch(painter) {
    case 'visualquery':
      return parseDesc(listobj)
    case 'queryParms':
      return getQueryText(GetQueryFields(listobj, false));
    case 'variable_field_picker':
      return getValueText();
    case 'procedures':
      return getProceduresText(listobj);
    case 'css_class':
      return getCssClassText(listobj);
    case 'parametersSources':
        return getParameterSourcesText();
    default:
      return getDefaultText(listobj);
  }
}

function getQueryText(files) {
  const names = files[0];
  const types = files[1];
  const lengths = files[2];
  const concatenatedNames = names.map((name, i)=>{
    return name + ' ' + types[i] + '(' + lengths[i] + ')';
  });
  return concatenatedNames;
}

function GetQueryFields(AllField,retDesc){
  const res=[];
  const types=[];
  const desc=[];
  const length=[];
  if(Left(AllField,9)=="BO_QUERY:"){
    AllField = Substr(AllField,10);
    const CSV_SEP="#!$";
    let row, rows = AllField.split(CSV_SEP);
    for (var i=0; i<rows.length; i++){
      row=rows[i].split("|");
      res.push(row[0]);
      if(retDesc==true)
        desc.push(row[2]);
      types.push(row[1]);
      length.push(row[3]);
    }
  }
  else {
    const l_oFields = new TrsJavascript();
    l_oFields.reset();
    l_oFields.SetRow(0);
    l_oFields.BuildProperties(AllField);
    let rows = GetProperty(l_oFields,'Rows','N');
    for (let ii=0; ii<rows; ii++){
      l_oFields.SetRow(ii);
      res.push(GetProperty(l_oFields,'alias','C'));
      if(retDesc==true)
        desc.push(GetProperty(l_oFields,'desc','C'));
      types.push(GetProperty(l_oFields,'type','C'));
      length.push(GetProperty(l_oFields,'len','C'));
    }
  }
  return retDesc?[res,desc,types,length]:[res,types,length];
}

function getValueText() {
  return ['Value()']
}

function getParameterSourcesText() {
  var ItemList=GetOpener().itemsHTML;
  let sourceList = [];
    for(var elem,i=0;i<ItemList.length;i++){
      elem=ItemList[i];
      if(ItemList[window.ReturnObjectIndex].name == elem.name ){
        continue;
      }
      if(elem.type=='SQLDataobj' || elem.type=='XMLDataobj' || elem.type=='StaticDataProvider' ||
        elem.type=='StdTreeView' || elem.type=='MenuView' || (elem.type=='Variable' && elem.reactive=='true') ||
        elem.type=='JSONDataobj'
        )
      sourceList.push(elem.name);
    }
  return sourceList;
}

function getProceduresText(fileObj) {
  let parsed = JSON.parse(fileObj);
  parsed = parsed.map((el) => {
    return el[0];
  });
  return parsed;
}

function getCssClassText(listobj) {
  let files = [];
  let classes = JSON.parse(listobj);
  var exit = false;
    for(var iii = 0; iii < classes.length && !exit; iii = iii + 2) {
      if(classes[iii].toString().search("TITLE-MARKER-") > -1) {
        exit = true;
      } else {
        files.push(classes[iii])
      }
    }
  return files;
}

function getDefaultText(listobj) {
  return listobj.split(',');
}

function setTitle() {
  let h1 = document.getElementById('open-title');
  if(parameters[painter]) h1.innerText = parameters[painter].title;
  else h1.innerText = 'Open file';
}

function getElementWithName(name) {
  let el = document.createElement('div');
  el.setAttribute('name', name);
  el.classList.add('file-item');
  el.classList.add(painter);
  let p = document.createElement('p');
  p.classList.add('name');
  p.innerText = name;
  el.appendChild(p);
  return el;
}

function callbackDescrs(descrResp,oldUrls){
  LibJavascript.Array.remove(ActiveUrls,ActiveUrls.indexOf(oldUrls[1]));
  if(oldUrls[0]!=activeUrl || activeUrlDescr!=oldUrls[1]){
    return
  }
  if(!Empty(descrResp)){
    let descriptions = getDescTextFor(painter, descrResp);
    let jspObjects, planpages;
    if(painter === 'planpages') {
      jspObjects = JSON.parse(descrResp);
      planpages = jspObjects.planpages;
    }
    document.querySelectorAll('.name').forEach(function (el, index) {
      if(typeof (descriptions[index]) != "undefined" && descriptions[index] != "''" && descriptions[index]) {
        var descr = getDescr(descriptions[index])
        origStore[el.parentElement.id].descr = descriptions[index];
        if(painter == "planpages") {
          el.parentElement.setAttribute("PlanName", planpages[index]);
          let span = document.createElement('span');
          span.innerText = " (" + planpages[index] + ")";
          el.appendChild(span);
        }
        el.appendChild(descr)
      }
    });
  }
}

function getDescTextFor(painter, descrResp) {
  switch(painter) {
    case 'queryParms':
      return getQueryDesc(descrResp);
    case 'procedures':
      return getProceduresDesc(descrResp);
    case 'parametersSources':
      return getParameterSourcesTitle();
    default:
      return getDefaultDesc(descrResp);
  }
}

function getParameterSourcesTitle() {
  var ItemList=GetOpener().itemsHTML;
  let sourceList = [];
    for(var elem,i=0;i<ItemList.length;i++){
      elem=ItemList[i];
      if(ItemList[window.ReturnObjectIndex].name == elem.name ){
        continue;
      }
      if(elem.type=='SQLDataobj' || elem.type=='XMLDataobj' || elem.type=='StaticDataProvider' ||
        elem.type=='StdTreeView' || elem.type=='MenuView' || (elem.type=='Variable' && elem.reactive=='true')
        ) {
        if(elem.query){
          sourceList.push(elem.query);
        } else {
          sourceList.push('');
        }
      }
    }
  return sourceList;
}

function getDescr(descr) {
  let descrP = document.createElement('p');
  if(!descrP) return null;
  descrP.innerText = descr;
  descrP.classList.add('description');
  return descrP;
}

function getDefaultDesc(descrResp) {
  var jspObjects = JSON.parse(descrResp);
  return jspObjects.jspDescr;
}

function parseDesc(fileObj) {
  let files = JSON.parse(fileObj);
  return files;
}

function getQueryDesc(files) {
  return GetQueryFields(files, true)[1];
}

function getProceduresDesc(fileObj) {
  let parsed = JSON.parse(fileObj);
  parsed = parsed.map((el) => {
    return el[1];
  });
  return parsed;
}

function slideList(move) {
  switch(move) {
  case 'down':
    pos_list = (pos_list + 1) < visibleItems.length ? (pos_list + 1) : 0;
    break;
  case 'up':
    pos_list = (pos_list - 1) >= 0 ? (pos_list - 1) : (visibleItems.length - 1);
    break;
  case 'first':
    pos_list = 0;
    break;
  case 'last':
    pos_list = (visibleItems.length - 1) >= 0 ? (visibleItems.length - 1) : 0;
    break;
  }
  //Controllo che l'item sia selezionato sia visibile altrimenti scrollo l'elenco fino a portare l'item in centro
  if(visibleItems[pos_list] != undefined) {
    var list = document.getElementById('list');
    var itm = visibleItems[pos_list];
    if((itm.offsetTop + list.scrollTop) > (list.scrollTop + list.clientHeight)) {
      list.scrollTo(0, ((itm.offsetTop + list.scrollTop) - list.clientHeight / 2));
    }
    if(((itm.offsetTop + list.scrollTop) - 50) < (list.scrollTop)) {
      list.scrollTo(0, (((itm.offsetTop + list.scrollTop) - itm.clientHeight) - list.clientHeight / 2));
    }
    visibleItems[pos_list].dispatchEvent(new Event('click'));
  }
}

/**
 * EX FILE openbytag
 */
var selectedTags = [];
var toolsPaths = {
  'portlet': {
    'openurl': '../visualweb/editor.jsp?id=',
    'jsurl_descr': '../servlet/JSPReaderByTag?type=portlet&folder_path=',
    'jsurl': '../servlet/JSPReader?type=portlet',
    'folder_path': ''
  }
};

function addTag(tag) {
  if(!Empty(tag)) {
    selectedTags.push(tag);
    tag = selectedTags.join(',');
    fillTags(tag);
  }
}

function removeTag(tag) {
  LibJavascript.Array.remove(selectedTags, LibJavascript.Array.indexOf(selectedTags, tag));
  tag = selectedTags.join(',');
  fillTags(tag);
}

function fillTags(tag) {
  if(tag == null) tag = "";
  new JSURL(toolsPaths[painter].jsurl_descr + toolsPaths[painter].folder_path + '&tag=' + tag, true, function (response) {
    var FilesObj = JSON.parse(response.Response());
    fillAllJsp(FilesObj);
    if(Empty(tag)) {
      fillAllTags(FilesObj);
      fillSelectedTags();
    } else { //Sub Tags
      fillAllTags(FilesObj, true);
      fillSelectedTags(tag);
    }
  });
}

function fillAllJsp(FilesObj) {
  var fileList = document.getElementById('listtagmode');
  fileList.replaceChildren();
  var files = FilesObj.jspList;
  var descriptions = FilesObj.jspDescr;

  var html = "";
  for(var i = 0; i < files.length; i++) {
    name = Strtran(files[i], "_portlet.jsp", "");
    html += "<div name='" + name + "' class='file-item " + painter + "' id='portlet_" + i + "'>";
    html += "<p class='name'>" + name + "</p>";
    html += "</div>";
  }
  fileList.innerHTML = html;

  document.querySelectorAll('.name').forEach(function (el, index) {
    if(descriptions[index] != "''" && descriptions[index] && descriptions[index] != "undefined") {
      var descr = document.createElement('descr');
      descr.classList.add('description');
      descr.innerText = descriptions[index];
      el.after(descr);
    }
  });

  document.querySelectorAll('.file-item').forEach(function (el) {
    el.addEventListener('click', function(){
      document.querySelectorAll('.selected-file').forEach(function (elm) {
        elm.classList.remove('selected-file');
      });
      el.classList.add('selected-file');
    })
    el.addEventListener('dblclick', function(){
      if((this.getAttribute('name')).toLowerCase() != "access denied") {
        openFile(this.getAttribute('name'));
      }
    })
  });
}

function fillAllTags(FilesObj, sub) {
  var obj = document.getElementById("taglist");
  obj.replaceChildren();
  var Tags;
  if(sub)
    Tags = FilesObj.tagListSub;
  else
    Tags = FilesObj.tagList;
  var html = "";
  for(var i = 0; i < Tags.length; i++) {
    html += "<div name='" + Tags[i] + "' class='tag-item " + painter + "' id='tag_" + i + "' onselectstart='return false'>";
    html += "<p class='name'>" + Tags[i] + "</p>";
    html += "</div>";
  }
  obj.innerHTML = html;
  document.querySelectorAll('.tag-item').forEach(function (el) {
    el.addEventListener('click', function(){
      document.addEventListener('.selected-file').forEach(function (elm) {
        elm.classList.remove('selected-file');
      });
      el.classList.add('selected-file');
    });
    el.addEventListener('dblclick', function(){
      if((this.getAttribute('name')).toLowerCase() != "access denied") {
        addTag(this.getAttribute('name'));
      }
    });
  });
}

function fillSelectedTags(/*tag*/) {
  var obj = document.getElementById("tagselected");
  obj.replaceChildren();
  var html = "";
  for(var i = 0; i < selectedTags.length; i++) {
    html += "<div name='" + selectedTags[i] + "' class='tagselected-item " + painter + "' id='tag_" + i + "' onselectstart='return false'>";
    html += "<p class='name'>" + selectedTags[i] + "</p>";
    html += "</div>";
  }
  obj.innerHTML = html;
  document.querySelectorAll('.tagselected-item').forEach(function (el) {
    el.addEventListener('click', function(){
      document.querySelectorAll('.selected-file').forEach(function (elm) {
        elm.classList.remove('selected-file');
      });
      el.classList.add('selected-file');
    });
    el.addEventListener('dblclick', function(){
      if((this.getAttribute('name')).toLowerCase() != "access denied") {
        removeTag(this.getAttribute('name'));
      }
    });
  });
}
