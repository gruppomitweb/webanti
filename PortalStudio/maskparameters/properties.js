/* exported
    updateProperties IsNumericInput validLinkedField validFixedValue validZoomQryParam
    validLinkedFieldName validFilterValue validDependsOn KeyFind
*/

var formProp=new ZTObjects.formObj({});
var searchProp = ZTObjects.searchObj ? new ZTObjects.searchObj() : null;
var ps_props, searchResult, search_accordion;
if(Empty(localStorage.getItem('zucchetti_portleteditor_properties'))){
  ps_props = {'width':200,'top':45,'left':500,'opened':true,'opacity':1,'expandedToColumn':false,'columnSide':'none','form_closed':false};
  Cookie.write('zucchetti_portleteditor_properties', JSON.encode(ps_props), {duration: 365});
}else{
  ps_props = JSON.parse(localStorage.getItem('zucchetti_portleteditor_properties'));
}

function FormProperties(force_render,force_open){
  var mainobj=formProp
  if(Empty(newFormPropObj) || force_render)
    newFormPropObj = new propertiesObj({
      afterRender : resizeGadgetsPane
      , m_obj : mainobj
      , isForm : true
      , canExpandToColumn : false
      , divcontainer : 'formproperties'
      , moveDiv : false
    });
  else
    newFormPropObj.updatePropertiesFromPaint(mainobj);
  if (Empty(searchFormPropObj)) {
    searchFormPropObj = new propertiesObj({
      m_obj : searchProp,
      isForm : false,
      canExpandToColumn : false,
      divcontainer : 'searchproperties',
      moveDiv : false,
      afterRender : resizeGadgetsPane
    });
  }
  else {
    searchFormPropObj.updatePropertiesFromPaint(searchProp);
  }
  if(force_open && ps_props.form_closed == true) {togglePane();}
}

function updateProperties(input,the_property,propertyType,isForm,value,updateHTML,reconvertFunc,validFunc,m_obj,alwaysUpdates,setOnBlurFunc){
  updateHTML = (typeof(updateHTML) == "undefined") ? true : updateHTML;
  if(m_obj && (typeof(m_obj.updateHTML) != "undefined")) updateHTML = m_obj.updateHTML;
  var arrayProp;
  if(isForm)
    arrayProp=formProp;
  else if(m_obj)
	  arrayProp=m_obj;
  else
    arrayProp=itemsHTML[index];
  if(value==arrayProp[the_property]) return;
  if(reconvertFunc){
    value=window[reconvertFunc](value)
  }
  if(validFunc){
    var r;
    if(typeof(validFunc)=='string')
      r = window[validFunc](value,the_property,input,index);
    else
      //Si pu� scrivere una
      r=validFunc.call(null,value,the_property,input,index);
	  if(r!=true){
      if(input.type=='checkbox'){
        input.checked=false;
      }else{
        input.value=arrayProp[the_property];
        setTimeout("document.id('"+input.id+"').focus();",50);
        setTimeout("document.id('"+input.id+"').select();",50);
      }
      return;
    }
  }
  if(setOnBlurFunc){
    if(typeof(setOnBlurFunc)=='string')
      window[setOnBlurFunc](value,the_property,input,index);
    else
      //Si pu� scrivere una
      setOnBlurFunc.call(null,value,the_property,input,index);
  }
  if(typeof(value)=='boolean' && arrayProp[the_property]==value.toString())return;
  if((typeof(b_reload)!='undefined' && b_reload) || arrayProp[the_property]==value)return;
  if (!alwaysUpdates && Empty(value) && Empty(arrayProp[the_property])) return;
  switch(propertyType){
    case 'int': //solo valori numerici
      if(!Empty(value)){
        if(isNaN(value)){
          PSAlert.alert('Not a numeric value !');
          setTimeout("document.id('"+input.id+"').focus();",50);
          setTimeout("document.id('"+input.id+"').select();",50);
          return;
        }else{
          arrayProp[the_property]=value;
		  if(updateHTML)
			writeHTML();
        }
      }else{
        arrayProp[the_property]=value;
		if(updateHTML)
			writeHTML();
      }
    break;
    case 'checkbox':
      if (typeof(value)=="boolean") value=(value?"true":"false");
      updateHTML=true;
      arrayProp[the_property]=value;
      writeHTML();
      if(the_property=='hsl')//Se si richiamano le snaplines bisogna deselezionare tutto
        if(value!='true'){
          selectForm()
          //return;
        }
    break;
    default:
    //case 'str': case 'data': case 'select': case 'xmldata'://valori stringa
      if(the_property=='maxlength' && Trim(value)!='') arrayProp.w=Math.floor(value*7.5)
      arrayProp[the_property]=value;
      if(isForm  && the_property=='steps'){
         FormProperties(true);
      }
	    if(updateHTML)
		    writeHTML();
  }
  if(window.updatePropertiesSelected) updatePropertiesSelected(the_property,isForm,value,updateHTML);
  m_bUpdated=true;
}

function IsNumericInput(v){
  if(isNaN(v)){
    PSAlert.alert('Not a numeric value!')
    return false;
  }else
    return true;
}

function validLinkedField(v){
  if (index!=null && v!=itemsHTML[index].linkedField)
    existsField(v,'readField')
  return true;
}

function validFixedValue(v){
  if (index!=null && v!=itemsHTML[index].fixedValue)
    existsField(v,'fixedFilter')
  return true;
}

function validZoomQryParam(v){
  if (index!=null && v!=itemsHTML[index].zoomQryParam)
    existsField(v)
  return true;
}

function validLinkedFieldName(v){
  if (index!=null && v!=itemsHTML[index].linkedFieldName)
    existsField(v)
  return true;
}

function validFilterValue(v){
  if (index!=null && v!=itemsHTML[index].filterValue)
    existsField(v,'filterField')
  return true;
}

function validDependsOn(v){
  if (index!=null && v!=itemsHTML[index].dependsOn)
    existsField(v)
  return true;
}

//Metodi di Search -----------------------------------------------------

function KeyFind() {
  var strfind = searchProp.sfind;
  searchResult = [];
  /* Ad ogni nuova ricerca:
     * si svuotano i risultati della ricerca precedente
     * si elimina l'evidenziazione dei campi della ricerca precedente
     * si nascondono i check "HightLight" e "Replace All"
  */
  if (document.id('findList'))
    document.id('findList').empty();
  else if (document.id('results_tab_content')){
    var findList=document.createElement("div");
    findList.id='findList';
    document.id('results_tab_content').appendChild(findList)
  }
  // if (hightlElements) {
    // hightlElements = false;
    // HightLight();
  // }
  // Ctrl("highlightSearchDiv").style.display = "none";
  // Ctrl("infosSearch").style.display = "none";
  // searchProp.chighlight = false;
  // searchProp.csubsistute = false;
  //FormProperties();

  // Inutile fare la ricerca della stringa vuota.
  if (Empty(strfind)) {
    return;
  }
  // Ricerca per almeno tre caratteri.
  if (strfind.length < 3) {
    PSAlert.alert("Minimum of 3 characters is required for search. Try again.");
    return;
  }

  // Creazione del JSon che contiene tutte le opzioni di ricerca.
  searchResult.inputSearch = strfind; // Stringa da cercare
  searchResult.resultIndices = []; // Array contente l'indice degli elementi che corrispondono ai criteri di ricerca negli array di appartenenza (itemsHTML)
  searchResult.selectedOccurrences = []; //Array contenente l'indice dei risultati della ricerca selezionati
  searchResult.resultProperties = []; // Array contente i nomi delle proprieta' degli elementi il cui valore corrisponde ai criteri di ricerca. Ordinato in base a resultIndices.
  // searchResult.nameSearch = searchProp.cconstant; // Boolean che indica se cercare nelle proprieta' di tipo costante
  // searchResult.exprSearch = searchProp.cexpression; // Boolean che indica se cercare nelle proprieta' di tipo espressione
  searchResult.wholeWord = searchProp.cwword; // Boolean che indica se si deve cercare la parola intera
  searchResult.caseSensitive = searchProp.ccsensitive; // Boolean che indica se la ricerca deve essere case sensitive

  search_accordion = new Fx.Accordion([], [], {
    'onComplete' : resizeGadgetsPane,
    'onActive' : function (toggler/*, element*/) {
      toggler.getFirst('.fld_title_ico').setStyle( "border-color", "rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) #000 rgba(0, 0, 0, 0)");
    },
    'onBackground' : function (toggler/*, element*/) {
      toggler.getFirst('.fld_title_ico').setStyle("border-color", "#000 rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) rgba(0, 0, 0, 0)");
    },
    alwaysHide : true,
    display : -1
  });

  keyFindArray(itemsHTML, searchResult);
  if (searchResult.resultIndices.length < 1) {
    PSAlert.alert(strfind + " not found");
  }
}

/*
   m_array: array nel quale cercare (itemsHtml o reportVariables)
   searchResult: json contenente le impostazioni di ricerca
*/
function keyFindArray(m_array, searchResult) {
  var initl = searchResult.resultIndices.length;
  var obj, i, o, oo, propName, propVal, tab;
  //Prop del Form
  for (o in formProp.objClass.newProperties) {
    tab = formProp.objClass.newProperties[o];
    for (oo = 0; oo < tab.length; oo++) {
      if(!tab[oo].disabled || tab[oo].disabled!='true'){
        propName=tab[oo].propID; ;
        propVal=formProp[propName];
        if ( (typeof propVal=='string' || typeof propVal=='number') && CheckFunc(searchResult.inputSearch, propVal)) {
          searchResult.resultProperties.push(propName);
          searchResult.resultIndices.push([-1, 'Form']);
        }
      }
    }
  }
  // for(var o in formProp){
    // var propName=o;
    // var propVal=formProp[o];
    // if ( typeof propVal=='string' && CheckFunc(searchResult.inputSearch, propVal)) {
      // searchResult.resultProperties.push(o);
      // searchResult.resultIndices.push([-1, 'Form']);
    // }
  // }
  //Propriet� degli items
  for (var ii = 0; ii < m_array.length; ii++) {
    var itemObj=m_array[ii];
    for (o in itemObj.objClass.newProperties) {
      tab = itemObj.objClass.newProperties[o];
      for (oo = 0; oo < tab.length; oo++) {
        if(!tab[oo].disabled || tab[oo].disabled!='true'){
          propName=tab[oo].propID; ;
          propVal=itemObj[propName];
          if ( (typeof propVal=='string' || typeof propVal=='number') && CheckFunc(searchResult.inputSearch, propVal)) {
            searchResult.resultProperties.push(propName);
            searchResult.resultIndices.push([ii,itemObj.type ]);
          }
        }
      }
    }
  }
  // for (i = 0; i < m_array.length; i++) {
    // obj = m_array[i];
    // if (obj.type.indexOf("_top") > 0) {
      // continue;
    // }
    // if (obj.type.indexOf("HeaderBar_") >= 0 || obj.type.indexOf("ReportBar_") >= 0) {
      // continue;
    // }
    // if (obj.type == "AutoCover") {
      // continue;
    // }
    // if (searchResult.nameSearch || searchResult.nameSearch=='true') {
      // CheckArray(obj, name_prop, i);
    // }
    // if (searchResult.exprSearch || searchResult.exprSearch=='true') {
      // CheckArray(obj, expr_prop, i);
    // }
    //CheckArray(obj, comm_prop, i);
    //CheckArray(obj,null,i);
  //}

  if (searchResult.resultIndices.length > 0) {
    /*
    if (Ctrl("highlightSearchDiv").style.display != "block") {
      Ctrl("highlightSearchDiv").style.display = "block";
      Ctrl("infosSearch").style.display = "block";
      //add all checkbox for replace
    }*/
    var cIndex;
    for (i = initl; i < searchResult.resultIndices.length; i++) {
      cIndex = searchResult.resultIndices[i][0];
      if(cIndex==-1){//FormProp
        obj = formProp;
      }else{
        obj = m_array[cIndex];
      }
      addSearchResult(i, obj);
    }
    //search_accordion.display(0);
    Ctrl("results_tab").click();
    //Chiudo le form properties per far spazio ai results
    var toggler = document.id("formproperties-toggler");
    if (toggler && toggler.hasClass("opened")) {
      toggler.click();
    }
    toggler = document.id("calculation-toggler");
    if (toggler && toggler.hasClass("opened")) {
      toggler.click();
    }
    toggler = document.id("action-toggler");
    if (toggler && toggler.hasClass("opened")) {
      toggler.click();
    }
    toggler = document.id("field-toggler");
    if (toggler && toggler.hasClass("opened")) {
      toggler.click();
    }
    // resizeGadgetsPane(true);
  }
}
/*
   obj: oggetto
   m_arr: array contenente le proprieta' in cui cercare (name_prop/ exp_prop/ comm_prop)
   iindex: indice dell'elemento.

   result[0]: index dell'elemento nell'array m_array ()
   result[1]: obj.type
*/
// function CheckArray(obj, m_arr, iindex) {
  // for (var j = 0; j < m_arr.length; j++) {
    // if (typeof(obj[m_arr[j]]) != "undefined") {
      // if (CheckFunc(searchResult.inputSearch, obj[m_arr[j]])) {
        // searchResult.resultProperties.push(m_arr[j]);
        // searchResult.resultIndices.push([iindex, obj.type]);
      // }
    // }
  // }
//}

/* strfind: stringa da cercare
  compvalue: valore della proprieta'
*/
function CheckFunc(strfind, compvalue) {
  if(typeof compvalue=='number'){
    return strfind == compvalue;
  }
  if (!searchResult.caseSensitive || searchResult.caseSensitive == 'false') {
    strfind = strfind.toLowerCase();
    compvalue = compvalue.toLowerCase();
  }
  if (searchResult.wholeWord == 'true') {
    return strfind == compvalue;
  }
  else {
    return compvalue.contains(strfind);
  }
}

/* Aggiunge l'elemento nel div del risultato della ricerca. */
function addSearchResult(pos, obj) {
  //var imgurl,objComment, propertyDescription;
  //var tab, tabDesc; /* Tab del report in cui si trova l'elemento. */
  // if (obj.type == 'Box') {
    // if (obj.h == 0) { imgurl = getObjImg('HLine'); }
    // else if (obj.w == 0) { imgurl = getObjImg('VLine'); }
    // else { imgurl = getObjImg(obj.type); }
  // }
  // else {
    // imgurl = getObjImg(obj.type);
  // }
  // objComment = obj.name;
  // if (obj.comment && LRTrim(obj.comment).length > 0) {
    // objComment = obj.comment;
  // }
  var propobj = getPropDescObj(obj, searchResult.resultProperties[pos]);
  var propertyType = obj.type;
  var objName = new Element('div', {
    html : (propertyType=='Form'?"Item: <span class='searchbold'>" + propertyType + "</span><br> Prop: <span class='searchbold'>"+propobj.desc + "</span>" : "Item: <span class='searchbold'>" + obj.name + "</span> ( " + propertyType + " ) " + " <br>Prop: <span class='searchbold'>"+propobj.desc+"</span>"),
    'class' : 'resultName',
    title : (propertyType=='Form'?"Item: <span class='searchbold'>" + propertyType + "</span><br> Prop: <span class='searchbold'>"+propobj.desc + "</span>" : "Item: <span class='searchbold'>" + obj.name + "</span> ( " + propertyType + " ) " + "<br>Prop: <span class='searchbold'>"+propobj.desc+"</span>")
  });
  objName.m_id = obj.id;
  objName.m_type = obj.type;
  objName.addEvent('click', function () {
    //selectItem3(this.m_id, this.m_type, true, obj);
    $$('.resultName').removeClass("selected");
    this.addClass("selected");
    revealProperty(obj,propobj);
  });
  var wrapper, wrapperId;
  wrapperId = "portlet_divz";
  var wrapperTitle =  "Results of '<span style='font-weight: 600;'>"+searchResult.inputSearch+"</span>'";
  wrapperTitle = ToHTag(wrapperTitle,"xssPrevent");
  // var img = new Element('img', {
    // 'class' : 'imgSearch',
    // styles : {
      // 'cursor' : 'default'
    // },
    // src : imgurl
  // });

  //var chk;
  //var idInput = obj.id + "_" + searchResult.resultProperties[pos] + "_chk";
  /* Non e' possibile effettuare la Replace sulla proprieta' Name */
  // if (searchResult.resultProperties[pos] != "name" || (searchResult.resultProperties[pos] == "name" && obj.type == "Variable")) {
    // chk = new Element('input', {
      // 'type' : 'checkbox',
      // 'id' : idInput,
      // 'name' : idInput,
      // 'title' : 'Select for replace'
    // });
    // chk.addEvent('click', function () {
      // selectOccurrence(pos, chk.checked);
    // });
  // }
  // else {
    // chk = new Element('input', {
      // 'type' : 'checkbox',
      // 'id' : idInput,
      // 'name' : idInput,
      // 'disabled' : 'disabled'
    // });
  // }
  wrapper = Ctrl(wrapperId);
  if (!wrapper) {
    wrapper = new Element('div', {
      'class' : 'fld_wrapper',
      'id' : wrapperId
    }).inject(Ctrl("findList"));
    var title = new Element('div', {
      'class' : 'fld_title'
    }).inject(wrapper);
    new Element('div', {
      'class' : 'fld_title_txt',
      'html' : wrapperTitle
    }).inject(title);
    new Element('div', {
      'class' : 'fld_title_ico'
    }).inject(title);
    var ul = new Element('ul', {
      'class' : 'fld_ul'
    }).inject(wrapper);
    var li = new Element('li', {
      'class' : 'fld_li'
    }).inject(ul);
    //li.adopt(chk).adopt(img).adopt(objName);
    li.adopt(objName);
    search_accordion.addSection(title, ul);
  }
  else {
    ul = wrapper.getElement('ul');
    li = new Element('li', {
      'class' : 'fld_li'
    }).inject(ul);
    //li.adopt(chk).adopt(img).adopt(objName);
    li.adopt(objName);
  }
  /*var objFind = new Element('li', {}).adopt(chk).adopt(img).adopt(objName);
  wrapper.adopt(objFind);*/
}
function getPropDescObj(obj, propID) {
  var ret = {};
  ret.desc = propID;
  ret.prop = propID;
  if (obj.objClass.newProperties) {
    var tab, i, ii;
    for (i in obj.objClass.newProperties) {
      tab = obj.objClass.newProperties[i];
      for (ii = 0; ii < tab.length; ii++) {
        if (tab[ii].propID == propID) {
          ret.desc = tab[ii].name;
          ret.tab = i;
          return ret;
        }
      }
    }
  }
  return ret;
}
function revealProperty(obj,propobj){
  var isForm=false;
  if(obj && obj.type!='Form'){
    selectItem(obj)
  }else{
    isForm=true;
    FormProperties(false,true)
    var formToggler = document.id("formproperties-toggler");
    if (formToggler && !formToggler.hasClass("opened")) {
      formToggler.click();
    }
  }
  if (propobj && propobj.tab && propobj.prop) {
    document.id((isForm?"Form_":"") + propobj.tab + '_tab').fireEvent('click');
    document.id((isForm?"Form_":"") +propobj.tab + '_' + propobj.prop).focus();
  }
}
