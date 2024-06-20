/* exported newPropObj newFormPropObj searchFormPropObj  */
/* exported NewDef propertiesObj extraFont  */
/* exported printFont */

//Support functions
var newPropObj = null;

LibJavascript.RequireLibrary("../jquery.js");
LibJavascript.RequireLibrary("../jquery-ui.js");
$.noConflict();
LibJavascript.RequireLibrary("../portalstudio/scripts/select2.min.js");
LibJavascript.RequireCSS("../portalstudio/styles/select2.min.css")

var newFormPropObj = null;
var searchFormPropObj = null;
var fontWebSafe = ["",
  "Arial, Helvetica, sans-serif", "Arial Black, Gadget, sans-serif",
  "Comic Sans MS, cursive, sans-serif", "Courier New, Courier, monospace",
  "Georgia, serif", "Impact, Charcoal, sans-serif",
  "Lucida Console, Monaco, monospace", "Lucida Sans Unicode, Lucida Grande, sans-serif",
  "Palatino Linotype, Book Antiqua, Palatino, serif", "Tahoma, Geneva, sans-serif",
  "Times New Roman, Times, serif", "Trebuchet MS, Helvetica, sans-serif",
  "Verdana, Geneva, sans-serif"
];
var extraFont = [
  "Open Sans, sans-serif",
  "Roboto, sans-serif",
  "Raleway, sans-serif",
  "Fira Sans, sans-serif",
  "Liquid Crystal, sans-serif",
  "JD LCD Rounded, sans-serif",
  "DejaVu Sans, sans-serif",
  "DejaVu Sans Condensed, sans-serif",
  "DejaVu Sans Mono, sans-serif",
  "DejaVu Serif, serif",
  "DejaVu Serif Condensed, serif",
  "Lets Go Digital, sans-serif",
  "Digital System, sans-serif",
  "Electronic Highway Sign, sans-serif"
].sort();
var printFont = [
  "Open Sans, sans-serif",
  "Roboto, sans-serif",
  "Raleway, sans-serif",
  "Fira Sans, sans-serif",
  "DejaVu Sans, sans-serif",
  "DejaVu Sans Condensed, sans-serif",
  "DejaVu Sans Mono, sans-serif",
  "DejaVu Serif, serif",
  "DejaVu Serif Condensed, serif"
].sort();
var propertiesConverter = function(){
  if (this.mainObject.type.toLowerCase() == "chart" || this.mainObject._objType == "chart") {
    this.mainObject.objClass._GetChartProps(this.mainObject.ctype, this.mainObject.chart_type);
    return this.mainObject.objClass.newProperties;
  }

  //GM
  if(this.mainObject.objClass.newProperties)
    return this.mainObject.objClass.newProperties;
  //GM

  this.mainObject.objClass.newProperties = {}
  var nTabs = Math.ceil(this.mainObject.objClass.properties.length / this.itemsPerPage);

  for(var nTab=0;nTab<nTabs;nTab++){
    var tabCreated = false;
    for(var i=(nTab*this.itemsPerPage); i < ((nTab+1)*this.itemsPerPage) && i < this.mainObject.objClass.properties.length;i++){//ciclo proprietà
      var propId = this.mainObject.objClass.properties[i];
      var propType = this.mainObject.objClass.propertyTypes[i];
      var propLabel = (this.mainObject.objClass.propertiesNames?this.mainObject.objClass.propertiesNames[i]:this.mainObject.objClass.properties[i]);
      var disabled = (Empty(propLabel)) ? true : false;
      if(!tabCreated){
        this.mainObject.objClass.newProperties["page"+parseInt(nTab+1)]=[];
        //eval('this.mainObject.objClass.newProperties.page'+parseInt(nTab+1)+' = []');
        tabCreated = true;
      }
      var propObj = {'name':propLabel,'propID':propId,'type':propType,'disabled':disabled}
      this.mainObject.objClass.newProperties['page'+parseInt(nTab+1)].push(propObj);
    }
  }
  return this.mainObject.objClass.newProperties;
}

function getDefaultValue(obj, prop){
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    for (var i in mainObject.objClass.newProperties) {
      var tab = mainObject.objClass.newProperties[i];
      for (var ii = 0; ii < tab.length; ii++) {
        if(i+"_"+tab[ii].propID == prop){
          if (typeof(tab[ii].defaultValue) == 'undefined')
            return;
          else
            return tab[ii].defaultValue;
        }
      }
    }
  }
}

function getFontListID(obj, propID){
  if (obj.objClass.newProperties) {
    var mainObject = obj;
    for (var i in mainObject.objClass.newProperties) {
      var tab = mainObject.objClass.newProperties[i];
      for (var ii = 0; ii < tab.length; ii++) {
        if(tab[ii].propID == propID){
          if (typeof(tab[ii].fontList) == 'undefined')
            return;
          else
            return tab[ii].fontList;
        }
      }
    }
  }
}

/* verifica la condizione di hide/show e se positiva ritorna
 * l' array delle prop da visualizzare/nascondere
 * o un array vuoto se la condizione non e' verificata
*/

function evaluateObj(obj, valueToFind) {
  for( var value in obj){
    var values = value.split(','); //ci possono essere più valori possibili
    for(var k=0;k<values.length;k++){
      if(typeof(valueToFind) != 'undefined' && (values[k] == valueToFind.toString() || (values[k]=='*' && !Empty(valueToFind.toString())))){
        return obj[value];
      }
    }
  }
  return [];
}

function searchPropByPropID(ctrlProp, tab, propID) {
  if( isPropertiesTab(ctrlProp, tab)) {
    return ctrlProp['objClass']['newProperties'][tab].filter(function(it) {
                                                              if(it.propID == propID)
                                                                return it;
                                                              })[0];
  }
}

function isPropertiesTab(ctrlProp, tab) {
  return !!ctrlProp['objClass']['newProperties'][tab];
}


function decodeShowHideList(str, tab, prop, isForm) {
  var pos;
  if(str.split('.')[0] == "this"){ // vecchia sintassi delle properties show/hide_list: "this.<tab_name>_<propID>"
    str = str.split('.')[1].replace('.','_');
    tab = str.split('_')[0];
    while( !isPropertiesTab(isForm?formProp:getItem(),tab) && tab.length+1 < str.length){
      pos = str.indexOf( '_', tab.length+1);
      tab = str.substring(0, (pos>0?pos:str.length) );
    }
    prop = str.substring(tab.length+1,str.length);
    str = (isForm ? 'Form_': '') + str;
  } else { // Nuova sintassi properties show/hide_list: "<tab_name>.<propID>"
    tab = str.split('.')[0];
    prop = str.split('.')[1];
    str = (isForm ? 'Form_' : '') + str.replace('.','_');
  }
  return {str:str, tab:tab, prop:prop};
}

function propertyChangeNotifier(lastValue,updateHTML,isForm){
  var hide_list = []
    , show_list = []
    , propToHide
    , propToShow
    , forceHide
    , tab
    , prop
    , hideobj
    , name
    , vals
    , attr
    , obj
    , i, j
    , tabContent
  ;
  if( !this.disabled ) {
    hide_list = evaluateObj( this.hide_list, lastValue );
    show_list = evaluateObj( this.show_list, lastValue );
  }
  var _itemsHTML = itemsHTML;
  if ( window.getItemsHTML ) {
    _itemsHTML = window.getItemsHTML(); //Report Editor
  }

  for(j=0; j<hide_list.length; j++){
    propToHide = hide_list[j];
    obj = decodeShowHideList(propToHide, tab, prop, isForm);
    propToHide = obj.str;
    tab = obj.tab;
    prop = obj.prop;

    if( document.getElementById(propToHide) ){
      /* se la properties da nascondere e' un checkbox */
      if( searchPropByPropID(isForm?formProp:getItem(),tab,prop).type == 'checkbox') {
      // if( document.getElementById(propToHide+"_wrapper") ){
        if(isForm)
          document.getElementById(propToHide).checked = getDefaultValue(formProp, propToHide);
        else if(index!=null)
          document.getElementById(propToHide).checked = getDefaultValue(_itemsHTML[index], propToHide);
        else
          document.getElementById(propToHide).checked = false;
        setTimeout(function() {
          if( document.getElementById(propToHide) )
            document.getElementById(propToHide).fireEvent('click',['Event',false]);
        }, 10);
      }else{
        document.getElementById(propToHide).fireEvent('blur',['Event',false]);
        document.getElementById(propToHide).fireEvent('change',['Event',false]);
      }
      document.getElementById(propToHide).fireEvent('hide');
    } else if ( document.getElementById(propToHide+"_tab") ){
      document.getElementById(propToHide+"_tab").style.display='none';
      if(isForm)
        formProp[propToHide]=true;
      else if (index!=null)
        _itemsHTML[index][propToHide]=true;
      else if (tool == 'report' && index==null)
        reportVariables[currVar][propToHide]=true;
      else if(tool=="pagelet" && index==null)
        pageletProp[index_pgl][propToHide]=true;
    }
	if ( document.getElementById(propToHide+"_list") ) document.getElementById(propToHide+"_list").style.display='none';
  }

  for(j = 0; j<show_list.length;j++){
    propToShow = show_list[j];

    obj = decodeShowHideList(propToShow, tab, prop, isForm);
    propToShow = obj.str;
    tab = obj.tab;
    prop = obj.prop;

    forceHide=false;
    /*
    *  -Ricerca l'oggeto hide
    *  -per ogni attributo dell'oggetto hide valuta i valori
    *   degli attributi del cntrl con lo stesso nome,
    *   se sono uguali lascia nascosta la proprieta'
    */
    hideobj = searchPropByPropID(isForm?formProp:getItem(),tab,prop);
    //potrebbe non esserci se viene nascosto un tab intero
    if(hideobj && hideobj.hide){
      hideobj = hideobj.hide;
      for( name in hideobj){
        vals = hideobj[name].split(',');
        for( i=0; i<vals.length; i++){
          attr = isForm ? formProp[name] : _itemsHTML[index][name];
          if( name!=this.propID && attr == vals[i] || name==this.propID && vals[i]==lastValue)
            forceHide = true;
        }
      }
    }
    if( !forceHide){
      if( document.getElementById(propToShow) ){
        document.getElementById(propToShow).fireEvent('show');
      }
      else if( document.getElementById(propToShow+"_tab") ){
        document.getElementById(propToShow+"_tab").style.display='block';
        if(isForm)
          formProp[propToShow]=false;
        else if (index!=null)
          _itemsHTML[index][propToShow]=false;
        else if (tool == 'report' && index==null)
          reportVariables[currVar][propToHide]=false;
        else if(tool=="pagelet" && index==null)
          pageletProp[index_pgl][propToHide]=true;
      }
	  if ( document.getElementById(propToShow+"_list") ) document.getElementById(propToShow+"_list").style.display='block';
    }
  }

  if(tab && !Empty(tab)){
    tabContent = document.getElementById(tab + "_tab_content");
    if(tabContent){
      var listfieldsets = tabContent.getElementsByTagName("fieldset");
      if(listfieldsets && listfieldsets.length>0){
        for(var kk=0; kk<listfieldsets.length; kk++){
          var sectionlegend = listfieldsets[kk].getElementsByTagName("legend");
          if(sectionlegend && sectionlegend.length>0) {
            sectionlegend[0].style.display = 'none';
            var out = false;
            var divs = listfieldsets[kk].getElementsByClassName("properties_container");
            for(var oo=0; !out && oo<divs.length; oo++){
              if(!Empty(divs[oo].id) && divs[oo].style.display !='none') {
                sectionlegend[0].style.display = 'block';
                out = true;
              }
            }
          }
        }
      }
    }
  }
}

function NewDef(/* index */) {
  if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    parent.newCurrentObj('New','chart',{});
}

function getItem(){
  if(index==null){
    if(tool == "report")
      return reportVariables[currVar];
    if(tool == "pagelet")
      return pageletProp[index_pgl];
  }
  else {
    if ( window.getItemsHTML ) { //Report Editor
      return window.getItemsHTML()[index];
    }
    return itemsHTML[index];
  }
}

function renderNotifics(objclick,pSheetWrapper){
  if(!objclick) objclick=document.getElementById('properties_notifics')
  if(!pSheetWrapper) pSheetWrapper=document.getElementById('propertiespropertySheet')
  if(document.getElementById('NotificsContainer')){
    pSheetWrapper.removeChild(document.getElementById('NotificsContainer'));
    return;
  }
  var mainobj=itemsHTML[index];
  var pos=LibJavascript.DOM.getPosFromFirstRel(objclick,pSheetWrapper);
  var NotificsContainer = new Element('ul',{'id':'NotificsContainer','class':'NotificsContainer'}).inject(pSheetWrapper);
  NotificsContainer.setStyles({'top':(pos.y+objclick.offsetHeight+5)+'px'});
  var notificsTitle=new Element('li',{'html':'Help and Notifications','class':'NotificsTitle'});
  notificsTitle.inject(NotificsContainer);
  // NotificsContainer.addEvents({
    // 'mouseleave':function(){if(document.getElementById('NotificsContainer'))window.document.body.removeChild(document.getElementById('NotificsContainer'));}
    // });
  var notificsLi;
  if(!mainobj.notifications || mainobj.notifications.length==0){
    notificsLi=new Element('li',{'html':'No notifications'});
    notificsLi.inject(NotificsContainer);
  }else{
    for(var r=0; r<mainobj.notifications.length;r++){
      notificsLi=new Element('li',{'html':mainobj.notifications[r]['message']});
      var notificsLiLink=new Element('a',{'title':'Go to the property','class':'NotificsLink','html':'&#xe603;'});
      notificsLi.inject(NotificsContainer);
      notificsLiLink.inject(notificsLi);
      notificsLiLink.addEvents({
        'click':function(r){
          document.getElementById(mainobj.notifications[r]['tab']+'_tab').fireEvent('click');
          document.getElementById(mainobj.notifications[r]['tab']+'_'+mainobj.notifications[r]['prop']).focus();
          hideNotifics();
        }.pass(r)
      });
    }
  }
}
function hideNotifics(){
  if(document.getElementById('NotificsContainer')){
    var pSheetWrapper=document.getElementById('propertiespropertySheet')
    pSheetWrapper.removeChild(document.getElementById('NotificsContainer'));
    return;
  }
}

// Properties Object
var propertiesObj = function(options){
  if(typeof(isCMS)=='undefined') isCMS=false;
  this.options = options || {};
  this.mainObject = this.options.m_obj;
  this._index=index;
  this.propertiesConverter = propertiesConverter.bind(this);
  this.itemsPerPage = this.options.itemsPerPage | 12;
  this.isForm = !Empty(options.isForm) ? options.isForm : false;
  this.psTab = !Empty(options.psTab) ? options.psTab : false;
  this.canExpandToColumn = !Empty(options.canExpandToColumn) ? options.canExpandToColumn : false;
  if(typeof(options.listForm)=='undefined')
    this.listForm = true;
  else
    this.listForm=options.listForm;
  this.divcontainer = !Empty(options.divcontainer) ? options.divcontainer : 'properties';
  this.tabList=new Array();
  var toolbar = document.getElementById('toolbar');//la lista di elementi della toolbar
  var canvas = document.getElementById('canvas');
  var _thisRef = this;
  var ps_TabAnimation = false;
  var pOpenClose = null;
  var pSheetWrapper = null;
  //Resetting currtab
  var ps_currTab = null;
  //Properties Container
  var propDiv = document.getElementById(this.divcontainer);
  var move;
  if(typeof(options.moveDiv)=='undefined')
    move = true;
  else
    move = options.moveDiv;
  this.afterRender = options.afterRender;
  this.tabindex = !Empty(options.tabindex) ? options.tabindex : 1;
  //RECUPERO DELLE INFORMAZIONI DAI COOKIES E DALLO STORANGE LOCALE DI MOOTOOLS
  this.isColumn = ( propDiv.retrieve('isColumn') != undefined ? propDiv.retrieve('isColumn') : ps_props.expandedToColumn );
  //AGGIUNTO PER EVITARE IL COMPORTAMENTO A COLONNA NEGLI ALTRI DISEGNATORI
  if(!this.canExpandToColumn)
    this.isColumn = false;
  this.pSheetOpened = (propDiv.retrieve('isOpened') != undefined ? propDiv.retrieve('isOpened') : true) ;

  this.columnExpand ='right'; // (Left_Right ? Left_Right :'right');
  propDiv.store('isColumn',this.isColumn)

  //FINE RECUPERO INFORMAZIONI E CREAZIONE DEI DIV DELLE PROPERTIES
  if(move==true){ //GM 20120210
    propDiv.setStyles({
      'top':ps_props.top,
      'left':ps_props.left,
      'opacity':ps_props.opacity,
      'width': (ps_props.width ? ps_props.width : '250px'),
      'display':'block'
    });
  }

  propDiv.morphEffect = new Fx.Morph(propDiv, {duration: '200','link':'cancel'});
  //Clearing current properties
  propDiv.empty();

  //Getting groups
  var isChart = (!Empty(this.mainObject.type) && this.mainObject.type.toLowerCase() == "chart");
  // check props chart editor
  isChart = isChart || (this.mainObject._objType == "chart");
  this.propertiesList = (this.mainObject.objClass.newProperties && !isChart) ? this.mainObject.objClass.newProperties : this.propertiesConverter();
  var groups = this.propertiesList;
  //Get Current Obj name
  if(typeof(this.mainObject.type)=='undefined') this.mainObject.type='Form';
  this.mainObject.id = (!Empty(this.mainObject.id)) ? this.mainObject.id : "form";

  //Creating resize handler
  var pSheetLeftResize = new Element('div',{'id':this.divcontainer+'propertySheetResizeLeft','class':'propertySheetResize'}).inject(propDiv,'top');
  var pSheetRightResize= new Element('div',{'id':this.divcontainer+'propertySheetResizeRight','class':'propertySheetResize'}).setStyles({'display':'none'}).inject(propDiv);
  var pSheetColumnResizeArrow = new Element('div',{'id':this.divcontainer+'propertySheetResize_Column_Arrow_right','class':'propertySheetResize_Column_Arrow'}).setStyles({display:'none'}).inject(pSheetRightResize)
  pSheetColumnResizeArrow.clone(true,false).setProperty('id',this.divcontainer+'propertySheetResize_Column_Arrow_Left').setStyles({display:'none'}).inject(pSheetLeftResize)

  //CREAZIONE DELLE AZIONI DI RI-APERTURA E DELLE COLONNE
  pSheetLeftResize.addEvents({
    'click': function (){
      _thisRef.re_openColumn()
    }
  });
  pSheetRightResize.addEvents({
    'click': function (){
      _thisRef.re_openColumn()
    }
  });
  this.HideProperties=function(){
    propDiv.hide();
  }
  this.ShowProperties=function(){
    propDiv.show();
  }
  this.UpdateListObj = function (container){

    container = typeof container == "string" ? document.getElementById(container) : container ;

    if(container==null)return;
    var pSelectHTML='';
    pSelectHTML+= '    <p style="margin:0;text-align:center">';
    pSelectHTML+= '      <select id="ctrlSelectList" onchange="ListObj(this)" class="properties_ctrl_select">';
    if(isCMS && tool=='plan')
      pSelectHTML+= '        <option value="form">Site Properties</option>';
    else if(tool=='plan')
      pSelectHTML+= '        <option value="form">Plan Properties</option>';
    else if(tool=='pageleteditor' || tool=='portlet' || tool=='maskparameters' || tool=='report' || tool=='module' || tool=='scandoc'){}
    else
      pSelectHTML+= '        <option value="form">Form Properties</option>';
    var comboSelectItems=new Array();

    var _itemsHTML = itemsHTML;
    if ( window.getItemsHTML ) {
      _itemsHTML = window.getItemsHTML(); //Report Editor
      }

    for(var i=0;i<_itemsHTML.length;i++){
      var add = false;
      if( typeof(_itemsHTML[i].allPages)!='undefined' ){
        if(_itemsHTML[i].allPages==true) {
            comboSelectItems.push(_itemsHTML[i]);
            add = true;
    }
      }
      if( !add && (_itemsHTML[i].page == formProp.page) ){
        if(typeof(_itemsHTML[i].show)!='undefined'){
          if(_itemsHTML[i].show==true)
            comboSelectItems.push(_itemsHTML[i]);
        }else {
          comboSelectItems.push(_itemsHTML[i]);
        }
      }
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
    for(var nv=0;nv<comboSelectItems.length;nv++){
      var selected='';
      if (index!=null && comboSelectItems[nv].name==_itemsHTML[index].name)
        selected='selected ';
      pSelectHTML+='     <option '+selected+'value="'+Strtran(comboSelectItems[nv].id,"item","")+'">'+comboSelectItems[nv].type+': '+ (tool == 'report' ? (Empty(comboSelectItems[nv].comment) ? comboSelectItems[nv].name : comboSelectItems[nv].comment) : comboSelectItems[nv].name)+'</option>';
    }
    pSelectHTML+='     </select>';
    pSelectHTML+='     </p>';

    container.innerHTML= pSelectHTML;
    //  Initialize select2

    var selekt = jQuery("#"+container.id +" #ctrlSelectList").select2();
    selekt.on("select2:open", () => SetOnEditProp(true));
    selekt.on("select2:closing", () => SetOnEditProp(false));

    // // Read selected option
    // jQuery("#"+container.id +' #but_read').click(function(){
    //   var username = jQuery("#"+container.id +' #ctrlSelectList option:selected').text();
    //   var userid = jQuery("#"+container.id +' #ctrlSelectList').val();

    //   jQuery("#"+container.id +' #result').html("id : " + userid + ", name : " + username);

    // });
  }
  this.re_openColumn=function(){
    if(_thisRef.isColumn && !_thisRef.pSheetOpened ){
      var size = parseInt(propDiv.retrieve('propDivDimensionAfterCollapse') ? propDiv.retrieve('propDivDimensionAfterCollapse') : (ps_props.width ? ps_props.width : '250px'));
      document.body.style.overflow = 'hidden';
      var left = window.getSize().x - size;
      document.body.style.overflow = '';
      propDiv.setStyle('width',size);
      pSheetWrapper.setStyles({'display':'block','opacity':1})
      propDiv.morphEffect.start({
        'max-width':500,
        'min-width':200,
        'left': (this.columnExpand == 'left' ? 0 : left)
      })
      if( size > 300){
        propDiv.querySelector(".content").classList.add("side_tab");
      } else {
        propDiv.querySelector(".content").classList.remove("side_tab");
      }
      $$('.propertySheetResize_Column_Arrow').setStyles({'cursor':'e-resize','display':'block','background-position':'center left'});
      pOpenClose.setStyle('background-position','right top');
      pOpenClose.show()
      ps_props.opened = true;
      _thisRef.pSheetOpened = true;
      propDiv.store('isOpened',_thisRef.pSheetOpened)
      if(this._index!=index){
        if(index!=null)
          Properties();
        // else
          // FormProperties();
      }else{
        _thisRef.ResizeToolbar(size)
        if(this.columnExpand == 'left')
          _thisRef.ResizeCanvas(size)
      }
        localStorage.setItem('zucchetti_'+tool+'editor_properties_'+_thisRef.divcontainer, JSON.stringify(ps_props));
    }
    return size;
  }
  //Creating property sheet
  pSheetWrapper = new Element('div',{'id':this.divcontainer+'propertySheet','class':'propertySheet'}).inject(propDiv);
  //Creating top bar (Minimize, itm name, dragger)
  //if formProperties don't display pTopBar

  var pTopBar = new Element('div',{'id':this.divcontainer+'psTopBar','class':'psTopBar'}).inject(pSheetWrapper);
  //pTopBar.setStyles({'display':this.isForm ? 'none' : ''});
  pOpenClose = new Element('div',{'class':'toggler_properties','title':'Toggle property sheet'}).setStyle('display',(this.canExpandToColumn ? 'block' : 'none')).inject(pSheetWrapper);

  var _itemsHTML = itemsHTML;
  if ( window.getItemsHTML ) {
    _itemsHTML = window.getItemsHTML(); //Report Editor
  }

    //Elenco di ctrls pre impostati
  if(index!=null && _itemsHTML[index] && _itemsHTML[index].objClass.preSet){
    var aPreSet= new Element('a',{'id':this.divcontainer+'_preSetH','class':'toggler_preset','title':'Select a preset '+_itemsHTML[index].type}).inject(pSheetWrapper);
    aPreSet.innerHTML='&#xe6b7;';
    aPreSet.addEvents({
       'click':function(){renderPreSet(this);}
     });
  }
    //Notifiche
  if(index!=null && _itemsHTML[index] && _itemsHTML[index].objClass.notifications){
    var Notifics= new Element('a',{'id':this.divcontainer+'_notifics','class':'toggler_notifics','title':'Notifications'}).inject(pSheetWrapper);
    Notifics.innerHTML='&#xe64c;';
    Notifics.addEvents({
       'click':function(){renderNotifics(this,pSheetWrapper);}
     });
  }

  // Wizard configurazione ctrl
  var classname;
  if (index != null && _itemsHTML[index] && _itemsHTML[index].objClass.wizard) {
    classname = 'toggler_cwizard';
    if (index != null && !_itemsHTML[index].objClass.preSet)
      classname = classname + "_before";
    var cWizard = new Element('a',{'id':this.divcontainer+'_cwizard','class':classname,'title':'Wizard'}).inject(pSheetWrapper);
    cWizard.innerHTML='&#xe692;';
    cWizard.addEvents({
       'click':function(){if(window.renderWizard) renderWizard();}
     });
  }

  // api configurazione ctrl
  if (index != null) {
    var cApi = document.getElementById("specificproperties_cApi");
    if ( !cApi ) {
    classname = 'toggler_capi';
    if (!document.getElementById(this.divcontainer+'_cApi')) {
        cApi = new Element('a',{'id':this.divcontainer+'_cApi','class':classname,'title':'API'}).inject(pSheetWrapper);
      cApi.innerHTML='&#xf3d7';
      cApi.addEvents({
        'click':function(){if(window.renderApi) renderApi(_itemsHTML[index]);}
      });
      }
    }
    else {
      cApi.onclick = function(){if(window.renderApi) renderApi(_itemsHTML[index]);};
    }
  }
    //hideNotifics();//la nasconde in caso sia aperta
  //Creating property sheet wrapper
  var pSheet = new Element('div',{'class':'pSheet'}).inject(pSheetWrapper);
  var pSelect = new Element('div',{'id':this.divcontainer+'ctrlSelect','class':'ctrlSelect'})
  //pSelect.setStyles({'display':this.isForm ? 'none' : ''});
  //Creating obj/form combobox
  var pSelectHTML = '';
  pSelectHTML+= '  <div id="ctrlSelect">';

  pSelectHTML+='     </div>';
  pSelect.innerHTML = pSelectHTML;
  // Creating tabs container
  var pTabs = new Element('div',{'class':'pTabs'})
  var pSeparator = new Element('div',{'id':this.divcontainer+'pSeparator1','class':'pSeparator'})
  // pSeparator.setStyles({'display':this.isForm ? 'none' : ''});
// Creating properties container
  var pContainer = new Element('div',{'id':this.divcontainer+'pContainer','class':'pContainer'});
  if(tool!='pagelet'){
    pSeparator.inject(pSheet);
    pSelect.inject(pSheet);
  }
    //Elenco di ctrls pre impostati
    /*
    if(index!=null && _itemsHTML[index] && _itemsHTML[index].objClass.preSet){
      var preSet=new Element('div',{'id':this.divcontainer+'preSet','class':'pContainer'})
      preSet.setStyle('width','100%');
      preSet.setStyle('margin-bottom','10px');
      var preSetSelect=new Element('select',{'id':this.divcontainer+'_preSet_seclect','class':'properties_ctrl_select'})
      var preSetSelectOpt=new Element('option',{'value':'','text':'Select a Label Type'});
      preSetSelectOpt.inject(preSetSelect);
      for(var r=0;r<_itemsHTML[index].objClass.preSet.length;r++){
        preSetSelectOpt=new Element('option',{'value':_itemsHTML[index].objClass.preSet[r]['name'],'text':_itemsHTML[index].objClass.preSet[r]['name']});
        preSetSelectOpt.inject(preSetSelect);
      }
      preSetSelect.addEvents({
        'change':function(){preSetSet(index,this.value);}
      });
      preSetSelect.inject(preSet);
      preSet.inject(pSheet);
    }
    */
    pSeparator = new Element('div',{'id':this.divcontainer+'pSeparator2','class':'pSeparator'})
    //pSeparator.setStyles({'display':this.isForm ? 'none' : ''});
    pSeparator.inject(pSheet);
    var content = new Element('div',{ 'class':'content' + (ps_props.width > 300 ? ' side_tab' : '') });
    content.inject(pSheet);
    pTabs.inject(content);
    // pSeparator = new Element('div',{'id':this.divcontainer+'pSeparator3','class':'pSeparator'})
    // pSeparator.inject(pSheet);
    pContainer.inject(content);
    //-----------------------------------------Funzioni generiche di creazione dei bottoni
    this.CreateBtnEdit=function(tab,propID,PropType){
      var propBtnEdit = new Element('div',{'class':'input_inline_btn' , 'icon-data': String.fromCharCode(parseInt('&#xe603;'.substring(3,7),16))});
      // propBtnEdit.setAttribute("icon-data",String.fromCharCode(parseInt('&#xe603;'.substring(3,7),16)));
      propBtnEdit.refId=tab+"_"+propID;
      propBtnEdit.refPropId=propID;
      propBtnEdit.PropType=PropType;
      return propBtnEdit;
    }
    this.CreateBtnPick=function(tab,propID,PropType){
      var propBtnPick= new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe6f6;'.substring(3,7),16))});
      propBtnPick.refId=tab+"_"+propID;
      propBtnPick.refPropId=propID;
      propBtnPick.PropType=PropType;
      return propBtnPick;
    }

    this.CreateBtnTran=function(tab,propID){
      var propBtnTran= new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe6c2;'.substring(3,7),16))});
      propBtnTran.refId=tab+"_"+propID;
      propBtnTran.refPropId=propID;
      return propBtnTran;
    }
    this.CreateBtnNew=function(tab,propID){
      var propBtnNew = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe626;'.substring(3,7),16))});
      propBtnNew.refId=tab+"_"+propID;
      propBtnNew.refPropId=propID;
      return propBtnNew;
    }
    this.CreateBtnDel=function(tab,propID){
      var propBtnDel = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe6fa;'.substring(3,7),16))});
      propBtnDel.refId=tab+"_"+propID;
      propBtnDel.refPropId=propID;
      return propBtnDel;
    }
    this.CreateBtnPlus=function(tab,propID){
      var propBtnPlus = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe605;'.substring(3,7),16))});
      propBtnPlus.refId=tab+"_"+propID;
      propBtnPlus.refPropId=propID;
      return propBtnPlus;
    }
    this.CreateBtnUp=function(tab,propID){
      var propBtnPlus = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe730;'.substring(3,7),16))});
      propBtnPlus.refId=tab+"_"+propID;
      propBtnPlus.refPropId=propID;
      return propBtnPlus;
    }
    this.CreateBtnDown=function(tab,propID){
      var propBtnPlus = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe734;'.substring(3,7),16))});
      propBtnPlus.refId=tab+"_"+propID;
      propBtnPlus.refPropId=propID;
      return propBtnPlus;
    }
    this.CreateBtnReload=function(tab,propID){
      var propBtnReload = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe67d;'.substring(3,7),16))});
      propBtnReload.refId=tab+"_"+propID;
      propBtnReload.refPropId=propID;
      return propBtnReload;
    }
    this.CreateBtnDate=function(tab,propID){
      var propBtnDate = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe64f;'.substring(3,7),16))});
      propBtnDate.refId=tab+"_"+propID;
      propBtnDate.refPropId=propID;
      return propBtnDate;
    }

    this.CreateBtnInfo=function(tab,propID){
     var propBtnInfo = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe6f7;'.substring(3,7),16))});
      propBtnInfo.refId=tab+"_"+propID;
      propBtnInfo.refPropId=propID;
      return propBtnInfo;
    }

    this.CreateBtnSearch=function(tab,propID){
      var propBtnSearch = new Element('div', {'class':'input_inline_btn', 'icon-data' : String.fromCharCode(parseInt('&#xe67f;'.substring(3,7),16))});
      propBtnSearch.refId = tab + "_" + propID;
      propBtnSearch.refPropId = propID;
      document.getElementById(propBtnSearch.refId).addEvents({
        'keydown':function(event){
          if (event.key == 'enter'){
            this.blur();
            KeyFind.bind(this)();
          }
        }
      })
      return propBtnSearch;
    }

    this.CreateBtnWizard=function(tab,propID,PropType){
      var propBtnWiz = new Element('div', { 'class': 'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe692;'.substring(3, 7), 16)) });
      propBtnWiz.refId = tab + "_" + propID;
      propBtnWiz.refPropId = propID;
      propBtnWiz.PropType = PropType;
      return propBtnWiz;
    }

    this.renderTab = function(tab){
      var _itemsHTML = itemsHTML;
      if ( window.getItemsHTML ) {
        _itemsHTML = window.getItemsHTML(); //Report Editor
      }
      if(!tab.opened){
        tab.opened = true;
        var tabName = tab.retrieve('originalName');
        var tabContent = tab.getParents(".pSheet").getElementById(tab.retrieve('contentName'))[0];
        var tabId=tab.retrieve('tabId');
        var props = groups[tabName];
        var old_section=null;
        for(var i = 0; i<props.length;i++){
          var property=props[i];
          var propertyID = property.propID;
          var propertyType= property.type;
          var propertyMultiple= property.multiple;
          var propertyViewType= property.viewType;
          var propertyButtons = property.buttons;
          var propertyActions = property.actions;
          var propertyScreen = initialCap(property.name);
          var propertylist = property.list && property.list=='true';
          var value = this.mainObject[property.propID];
          if (typeof value == 'string') {
            value = Strtran(value, '\r', '&#13;');
            value = Strtran(value, '\n', '&#10;');
          }
          var steppable = !!property.steppable && ( formProp && formProp.steps && formProp.steps.length ) ; /* step presenti e valore steppable */
          var tooltip_txt = (property.tooltip) ? property.tooltip : '';
          var tooltip_width = (property.tooltip_width) ? property.tooltip_width : null;
          var isDisabled = property.disabled;
          var isNotEditable = property.noteditable || this.mainObject.ps_variant_not_editable;
          var convertFunc= property.convertFunc;
          var reconvertFunc= property.reconvertFunc;
          var validFunc= property.validFunc;
          var setOnBlurFunc= property.setOnBlurFunc;
          var dataobjref= property.dataobjref;
          var alwaysUpdates= property.alwaysUpdates;
          var section= (property.section) ? Strtran(property.section, " ", "-") : '';
          var extra_class = ""
          if(convertFunc){
            eval("value="+convertFunc+"(value)")
          }
          var selectList = '', typeList;
          if(propertyType && propertyType.indexOf('select[')>-1){
            selectList=propertyType.substring(7,propertyType.indexOf(']'));
            if(selectList.indexOf("function:")>-1){
              selectList=selectList.replace(/function:/g,'');
              selectList=eval(selectList);
            }
            selectList=selectList.split(',');
            propertyType=propertyType.substring(0,propertyType.indexOf('['));
          } else if (propertyType && propertyType.indexOf('autocomplete[')>-1){
            typeList=propertyType.substring(13,propertyType.indexOf(':'));
            selectList = propertyType.substring(propertyType.indexOf(':')+1,propertyType.indexOf(']')).split(',');
            propertyType=propertyType.substring(0,propertyType.indexOf('['));
          }

          if(property.extraClass) {
            extra_class += (property.extraClass.search('col-') > -1) ?
              ' ' + property.extraClass :
              ' col-6 ' + property.extraClass;
          } else {
            extra_class += ' col-6';
          }

          var propContainer = new Element('div', {
            'id':tabId+"_"+propertyID+"_container",
            'class':'properties_container' + extra_class,
            // 'title':(Empty(tooltip)?'Set the '+propertyScreen:tooltip),
          });

          //Sezioni
          var sectionContainer;
          var extHtmlSection=false;
          var ZTObjectContainer=null;
          if(typeof(ZTObjects)!='undefined')
            ZTObjectContainer=ZTObjects;
          else if(typeof(ZTPageletObjects)!='undefined')
            ZTObjectContainer=ZTPageletObjects;
          if(ZTObjectContainer!=null && ZTObjectContainer.sections_urls && ZTObjectContainer.sections_urls[section])
            extHtmlSection=true;
          if(section && section!=old_section){//Creo il div della sezione ed inserisco la prima prop
            sectionContainer = new Element('fieldset',{'id':tabId+"_"+section+"_section",'class':'properties_sections'});
            sectionContainer.inject(tabContent);
            if(propertyMultiple!=null && propertyMultiple.type=='combo' && propertyMultiple.listview){
                let propInput = new Element('input',{'value':(value != "undefined" ? value : '')
                  , 'type': 'text'
                  , 'id':tabId+"_"+propertyID+"_list"
                  , 'class':input_class
                  , 'list':(property.list=="true"?"true":"false")
                  , disabled : true
                  });
                  propInput.style.width = '100%';
                  propInput.inject(sectionContainer);
            }
            var section_label= new Element('legend',{'id':tabId+"_"+section+"_label",'text':initialCap(Strtran(property.section, "-", " ")),'class':'properties_label'}).inject(sectionContainer);
            section_label.addEvents({
              'click':function(){
                this.classList.toggle('hide-legend');
                this.getAllNext().each(function(el){
                  el.classList.toggle('hide-element');
                });
              }
            });
            if(extHtmlSection){
              var sectionExtHtmlContainer = new Element('div',{'id':tabId+"_"+section+"_section_html"});
              sectionExtHtmlContainer.inject(sectionContainer);
              ZtVWeb.Include(ZTObjects.sections_urls[section],sectionExtHtmlContainer,true);

            }else {
              propContainer.inject(sectionContainer);
            }
            old_section=section;
          }else if(section && section==old_section){ // inserico le prop della stessa sezione
            if(!extHtmlSection){
              sectionContainer=document.getElementById(tabId+"_"+section+"_section");
              propContainer.inject(sectionContainer);
            }
          }else{ // no sezioni
            propContainer.inject(tabContent);
          }

          //Assegno gli eventi agli input di un eventuale html di section esterno
          if(extHtmlSection){
            document.getElementById(tabId+"_"+propertyID).value=(value != "undefined" ? value : '');
            document.getElementById(tabId+"_"+propertyID).addEvents({
              'blur':function(propertyID,propertyType){
                propertyChangeNotifier.bind(this)(this.value,true,_thisRef.isForm);
                updateProperties(
                  this,propertyID,propertyType,_thisRef.isForm,this.value,true,
                  this.reconvertFunc,this.validFunc,_thisRef.mainObject,
                  this.alwaysUpdates,this.setOnBlurFunc
                );
                SetOnEditProp(false);
                //document.getElementById(this.id+"_container").removeClass('selected');
              }.pass([propertyID,propertyType],document.getElementById(tabId+"_"+propertyID)),
              'focus':function(){
                SetOnEditProp(true);
                //document.getElementById(this.id+"_container").addClass('selected');
              }
            });
            continue;
          }
          var propLabel = new Element('label'
            ,{'id':tabId+"_"+propertyID+"_label"
              ,'for':tabId+"_"+propertyID
              ,'class': 'properties_label' + ( steppable ? " steppable" : "" )
            }
          ).inject(propContainer);
          var propLabelHREF = new Element('a',{'href':'javascript:void(0)'}).inject(propLabel);
          propLabelHREF.set('text',propertyScreen);
          propLabelHREF.store('propertyID',propertyID);
          propLabelHREF.addEvent('click',function(){
            var helpStr = (!Empty(_thisRef.mainObject.type)) ? _thisRef.mainObject.type+"_"+this.retrieve('propertyID') : this.retrieve('propertyID')
            Help(helpStr);
          });
          if(Empty(tooltip_txt)) {
            propLabel.set('title', 'Set the '+propertyScreen);
          } else {
            var icon_tooltip = new Element('i', {
              'class': 'pstooltip-info'
            }).inject(propLabel);
            PSTooltip(icon_tooltip, {'text' : tooltip_txt, 'html' : true, 'width' : tooltip_width });
          }
          //Setting inline buttons (E, ? , N, +)
          //var marginBtnContainer = (Browser.Engine.trident) ? -23 : -23;
          var propBtnContainer = new Element('div',{'class':'input_inline_btn_container'});
          var propBtnTable = new Element('table',{'class':'properties_button_table','cellspacing':'0','cellpadding':'0','border':'0'}).inject(propContainer,'bottom')
          var tbody = new Element('tbody');
          var tr = new Element('tr')
          var tdInput = new Element('td',{'class':'tdInput'});
          var tdButton = new Element('td',{'class':'tdButton'});
          tbody.inject(propBtnTable);
          tr.inject(tbody);

          let propInput,propWrapper, propInputOpt, propBtnEdit, propBtnPick, propBtnNew, idInput, valueselect;
          var v, vv, mm, input_class;

          propertyType = (propertyID.indexOf("color")>=0) ? "color" : propertyType;
          //Proprieta utilizzate dal ModuleEditor
          propertyType = (propertyID.indexOf("dateformat")>=0) ? "dateformat_select" : propertyType;
          propertyType = (propertyID.indexOf("timeformat")>=0) ? "timeformat_select" : propertyType;
          switch(propertyType){
            case 'int':
            case 'str':
              input_class=((propertyType=='int')?'properties_input_numeric':'properties_input');
              value = (EmptyString(value)) ? '' : value;
              //Gestione delle proprieta'� multiple separate da ',' si mostra una combobox in testata per poter navigare tra i valori
              if(propertyMultiple!=null){
                var values=value.toString().split(',');
                if(propertyMultiple.type=='combo'){
                  propInput = new Element('select',{'value':(value != "undefined" ? value : '')
                    , 'type':(propertyType == "int" ? 'number' : 'text')
                    , 'id':tabId+"_"+propertyID
                    , 'name':tabName+"_"+propertyID
                    , 'class':input_class
                  });
                  for(var ii=0;ii<values.length;ii++){
                    v = values[ii];
                    if(!Empty(v)){
                      propInputOpt = new Element('option',{'value':v,'text':v});
                      propInputOpt.inject(propInput);
                    }
                  }
                }else if(propertyMultiple.type=='checkbox') {
                  propWrapper = new Element('div',{'id':tabId+"_"+propertyID+"_wrapper",'class':'properties_checkbox_container'});
                  propInput = new Element('input',{'value':(value != "undefined" ? Strtran(values[0],"|",",") : '')
                  , 'type':'checkbox'
                  , 'id':tabId+"_"+propertyID
                  , 'name':tabName+"_"+propertyID
                  , 'class':'properties_checkbox'
                    ,'checked':((value)?'checked':'')
                  }).setStyles({'border-color':((value)?'#A3C891':'#FFFFFF')});

                }else{
                  propInput = new Element('input',{'value':(value != "undefined" ? Strtran(values[0],"|",",") : '')
                    , 'type':(propertyType == "int" ? 'number' : 'text')
                    , 'id':tabId+"_"+propertyID
                    , 'name':tabName+"_"+propertyID
                    , 'class':input_class
                  });
                  // if(propertyMultiple.type=='combo')
                  //   document.getElementById(tabName+"_"+propertyID+'_label').firstChild.innerText = propertyScreen+' for '+_itemsHTML[index][propertyMultiple.id].split(',')[0];
                }

              //-----Multiple end-------------------------------------------------------------------------------------------------------------------
              }else if((propertyID == 'value' || propertyID == 'description') && propertyType == "str") {
                propInput = new Element('textarea',{'value':(value != "undefined" ? value : '')
                  , 'type': 'text'
                  , 'id':tabId+"_"+propertyID
                  , 'name':tabName+"_"+propertyID
                  , 'class':input_class
                  , 'list':(property.list=="true"?"true":"false")
                });
                propInput.addEvents({
                  'focus' : function () {
                    SetSelectedProp(index,this.id,this.propID)
                  }
                });

              }else if(propertyViewType!=null){
                // const PROPERTY_SEPARATOR = ','
                if(propertyViewType.type == 'stringSeparatedValue') {
                  let stringInput = document.createElement('input');
                  stringInput.setAttribute('id', tabId+"_"+propertyID+'_input');
                  stringInput.setAttribute('type', 'text');
                  var hiddenInput = document.createElement('a');
                  hiddenInput.value = '';
                  hiddenInput.setAttribute('class','hidden_property_input_handler');
                  hiddenInput.setAttribute('id',tabId+"_"+propertyID);
                  let comboDiv = document.createElement('div');
                  comboDiv.setAttribute('id',tabId+"_"+propertyID+'_combo');
                  comboDiv.setAttribute('class','library_container');
                  comboDiv.setAttribute('tabindex','-1');
                  let ulElement = document.createElement('ul');
                  ulElement.setAttribute('class', 'property_list_combo')
                  comboDiv.appendChild(ulElement);
                  document.getElementById(tabId+"_"+propertyID+"_container").appendChild(stringInput);
                  document.getElementById(tabId+"_"+propertyID+"_container").appendChild(comboDiv);
                  document.getElementById(tabId+"_"+propertyID+"_container").appendChild(hiddenInput);
                  let jQueryInput = jQuery('#'+tabId+'_'+propertyID+'_input');
                  const PSEUDO = document.createElement('div');
                  PSEUDO.setAttribute('class','select2_strinput_pseudo');
                  PSEUDO.setAttribute('style','pointer-events:none');
                  stringInput.parentElement.querySelector('label').appendChild(PSEUDO);

                  comboDiv.setAttribute('style','display:none');
                  stringInput.setAttribute('class','Form_property_item');
                  stringInput.setAttribute('placeholder', value);
                  stringInput.setAttribute('style','text-align:center');
                  stringInput.setAttribute('autocomplete','off');

                  const onInputChange = (comboDiv,stringInput,hiddenInput,onSelectUnselect)=>{
                    return ()=>{
                      let values = stringInput.value;
                      values = values.replace(/\s/g,'');
                      while(values.test(/,,/)){
                        values=values.replace(/,,/,',');
                      }
                      values = values.replace(/^,/,'');
                      values = values.replace(/,$/,'');
                      stringInput.value = values;
                      if(values.length === 0) return;
                      let ul = comboDiv.querySelector('ul');
                      ul.empty();
                      stringInput.value = '';
                      values = values.length === 0 ? [] : values.split(',');
                      if(values.length > 0){
                      hiddenInput.value += hiddenInput.value.length>0 ? ','+values.join(',') : values.join(',');
                        for(let value of hiddenInput.value.split(',')){
                          let option  = document.createElement('li');
                          option.setAttribute('class','combo_property');
                          let button = document.createElement('div');
                          button.setAttribute('class', 'comboboxLiButton input_inline_btn')
                          option.appendChild(button);
                          let callback = onSelectUnselect(hiddenInput);
                          const onDeleteClick = (hiddenInput) => {
                            return (e) => {
                              callback(e);
                              hiddenInput.focus();
                              e.target.parentElement.remove();
                            }
                          }
                          button.addEventListener('click',onDeleteClick(hiddenInput));
                          const onLiClick = (hiddenInput,option)=> {
                            return (ev) => {
                              if(ev.target===option.querySelector('span')){
                                return;
                              }
                              if(ev.target===option) {
                                hiddenInput.focus();
                              }
                            }
                          }
                          option.addEventListener('click',onLiClick(hiddenInput,option));
                          let span = document.createElement('span');
                          span.innerText = value;
                          const onSpanClick = (hiddenInput) => {
                            return (ev) => {
                              let span = ev.target;
                              span.setAttribute('style','display:none');
                              let input = document.createElement('input');
                              input.value = span.innerText;
                              span.parentElement.appendChild(input);
                              const eventChange = (span,hiddenInput)=>{
                                return (ev) => {

                                  value = hiddenInput.value.split(',');
                                  span.innerText = ev.target.value;
                                  span.parentElement.setAttribute('title',ev.target.value);
                                  span.setAttribute('style','');
                                  let c = 0;
                                  span.parentElement.parentElement.childNodes.forEach((item)=>{
                                    value[c] = item.innerText;
                                    c++;
                                  });
                                  hiddenInput.value = value.join(',');
                                  SetOnEditProp(false);
                                  ev.target.remove();
                                  if(ev.causeOf != 'blur') {
                                    SetOnEditProp(true);
                                    hiddenInput.focus();
                                  } else {
                                    if(!span.parentElement.parentElement.parentElement.contains(ev.relatedTarget)) {
                                      hiddenInput.focus();
                                      document.activeElement.blur();
                                    }
                                  }
                                }
                              }
                              input.addEventListener('change', eventChange(span,hiddenInput));
                              const onInputBlur = (input) => {
                                return (ev)=>{
                                  ev.preventDefault();
                                  let eventD = new Event('change');
                                  eventD.causeOf = 'blur';
                                  eventD.relatedTarget = ev.relatedTarget;
                                  input.dispatchEvent(eventD);
                                  }
                              }
                              input.addEventListener('blur',onInputBlur(input));
                              const onInputKeyDown = (input) =>{
                                return (ev)=>{
                                  if(ev.code === 'Enter'){
                                    ev.preventDefault();
                                    input.focus();
                                  }
                                }
                              }

                              input.addEventListener('focus', ()=>{
                                  SetOnEditProp(true);
                              })

                              input.addEventListener('keydown',onInputKeyDown(hiddenInput));
                              input.setAttribute('class','input_span_substitute');
                              SetOnEditProp(true);
                              input.focus();
                            }
                          }
                          span.addEventListener('click',onSpanClick(hiddenInput));
                          option.setAttribute('title',value);
                          option.appendChild(span);
                          ul.append(option);
                        }
                        let blurEvent = new Event('blur');
                        hiddenInput.dispatchEvent(blurEvent);
                     }
                    }
                  }

                  const onInputKeyDown = (jQueryInput) => {
                    return (ev) => {
                      if(ev.code == 'Enter'){
                        jQueryInput.trigger('change');
                        SetOnEditProp(true);
                      }
                      if(ev.code == 'Tab') {
                        jQueryInput.trigger('change')
                      }
                      if(ev.code == 'Backspace') {
                        return true;
                      };
                    }
                  }

                  const onSelectUnselect = (hiddenInput)=>{
                    return (evData)=>{
                      let valueString = hiddenInput.value;
                      let li = evData.target.parentElement;
                      const VALUE_TO_REPLACE = li.getAttribute('title');
                      li.remove();
                      valueString = valueString.replace(VALUE_TO_REPLACE,'');
                      valueString = valueString.replace(',,',',');
                      valueString = valueString.replace(/,$/,'');
                      valueString = valueString.replace(/^,/,'');
                      hiddenInput.value = valueString;
                      let blurEvent = new Event('blur');
                      hiddenInput.dispatchEvent(blurEvent);
                    }
                  }

                  const onInputFocus = (tabId,propertyID,stringInput) => {
                    return () => {
                      SetOnEditProp(true);
                      PSEUDO.setAttribute('isOpen','true');
                      if(stringInput.getAttribute('tabindex') === null) {
                        let a = stringInput.parentElement.querySelector('.hidden_property_input_handler');
                        let tab = a.getAttribute('tabindex');
                        a.removeAttribute('tabindex');
                        stringInput.setAttribute('tabindex',tab);

                      }
                      stringInput.setAttribute('style','text-align:left');
                      stringInput.setAttribute('placeholder','');
                      let width = stringInput.clientWidth+2;
                      let height = stringInput.clientHeight+2;
                      let rect = stringInput.getBoundingClientRect();
                      document.querySelector('#'+tabId+'_'+propertyID+'_combo').setAttribute('style','width:'+width+'px; top:'+
                      (rect.top+window.scrollY+height)+'px; left:'+(rect.left+window.scrollX)+'px;');
                    }
                  }
                  const onHiddenFocus = (stringInput) => {
                    return (e) => {
                      let tab = e.target.getAttribute('tabindex');
                      stringInput.setAttribute('tabindex', tab);
                      e.target.removeAttribute('tabindex');
                      stringInput.focus();
                    }
                }
                  hiddenInput.addEventListener('focus',onHiddenFocus(stringInput));

                  const onInputBlur = (tabId,propertyID,stringInput,hiddenInput) => {
                    return (ev) => {
                      SetOnEditProp(false);
                      let tab = stringInput.getAttribute('tabindex');
                      stringInput.removeAttribute('tabindex');
                      hiddenInput.setAttribute('tabindex',tab);
                      stringInput.setAttribute('style','text-align:center');
                      if(hiddenInput.value.length>0){
                        stringInput.setAttribute('placeholder', hiddenInput.value);
                      } else stringInput.setAttribute('placeholder','');
                      let el = document.querySelector('#'+tabId+'_'+propertyID+'_combo');
                      if(ev.relatedTarget == null) el.setAttribute('style','display:none');
                      if(ev.relatedTarget){
                        if(!(el.contains(ev.relatedTarget))){
                            el.setAttribute('style','display:none')
                          };
                      }
                    }
                  }

                  document.querySelector('#'+tabId+'_'+propertyID+'_combo').addEventListener("blur",onInputBlur(tabId,propertyID,stringInput,hiddenInput));
                  document.querySelector('#'+tabId+'_'+propertyID+'_combo').childNodes.forEach((item)=>{
                    item.addEventListener("blur",onInputBlur(tabId,propertyID,stringInput,hiddenInput))
                  });

                  const onSortableStop = (hiddenInput) => {
                    return (ev) => {
                      let ul = ev.target;
                      hiddenInput.value = '';
                      ul.childNodes.forEach((item)=>{
                        const VALUE = item.getAttribute('title');
                        hiddenInput.value += hiddenInput.value === '' ? VALUE : ','+VALUE;
                      });
                      let blurEvent = new Event('blur');
                      hiddenInput.dispatchEvent(blurEvent);
                    }
                  }

                  const onInputClick = (hiddenInput) => {
                    return (ev) => {
                      if(ev.target === document.activeElement) {
                        ev.preventDefault();
                        document.activeElement.blur();
                      } else {
                        hiddenInput.focus();
                      }
                    }
                  }

                  stringInput.addEventListener('mousedown',onInputClick(hiddenInput));

                  jQuery('#'+tabId+'_'+propertyID+'_combo ul').sortable({
                    stop: onSortableStop(hiddenInput),
                  });
                  stringInput.addEventListener("change",onInputChange(comboDiv,stringInput,hiddenInput,onSelectUnselect));
                  stringInput.addEventListener('blur', onInputBlur(tabId,propertyID,stringInput,hiddenInput));
                  stringInput.addEventListener('focus',onInputFocus(tabId,propertyID,stringInput));
                  stringInput.addEventListener('keydown',onInputKeyDown(jQueryInput));
                  let initEv = new Event('change');
                  stringInput.value = value;
                  stringInput.dispatchEvent(initEv);
                  propInput = document.id(tabId+'_'+propertyID);
                }
              }else {
                propInput = new Element('input',{'value':(value != "undefined" ? value : '')
                  , 'type':(propertyType == "int" ? 'number' : 'text')
                  , 'id':tabId+"_"+propertyID
                  , 'name':tabName+"_"+propertyID
                  , 'class':input_class
                  , 'list':(property.list=="true"?"true":"false")
                });
                propInput.addEvents({
                  'focus' : function () {
                    SetSelectedProp(index,this.id,this.propID)
                  }
                });
              }
              //if(false){
              if(propWrapper){
                propInput.inject(propWrapper);
                propWrapper.inject(propContainer);
              }else{
                propInput.inject(propContainer);
              }
              switch(propertyID){
                case "colProperties":
                  if(this.mainObject.type=='Grid' || this.mainObject.type=='StdRecordView' || propertyID == "field"){
                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(){
                        BuildExpression(index,this.refPropId,this.refId);
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                  }
                break;
                case "query":
                  propBtnPick=this.CreateBtnPick(tabId,propertyID);
                  propBtnPick.set('title','Select query');
                  //propBtnPick.inject(propBtnContainer);
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
                  propBtnPick.addEvents({
                    'click':function(){
                      //SelectQuery(index, _thisRef.isForm, this.refId);
                      PickItems('visualquery',this.refId,null,null,930, 600);
                    }
                  });
                  propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                  propBtnEdit.set('title','Edit query');
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                  propBtnEdit.addEvents({
                    'click':function(){
                      EditQuery(index, _thisRef.isForm);
                    }
                  });
                  propBtnNew=this.CreateBtnNew(tabId,propertyID);
                  propBtnNew.set('title','New query');
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnNew).inject(tr);
                  propBtnNew.addEvents({
                    'click':function(){
                      NewQuery(index);
                    }
                  });
                  propBtnContainer.inject(propContainer,'bottom');
                break;
                case "vdmfile":
                  propBtnPick=this.CreateBtnPick(tabId,propertyID);
                  //propBtnPick.inject(propBtnContainer);
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
                  propBtnPick.addEvents({
                    'click':function(){
                      SelectVdmMask(index, _thisRef.isForm, this.refId);
                    }
                  });
                  propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                  propBtnEdit.addEvents({
                    'click':function(){
                      EditVdmMask(index, _thisRef.isForm);
                    }
                  });
                  propBtnNew=this.CreateBtnNew(tabId,propertyID);
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnNew).inject(tr);
                  propBtnNew.addEvents({
                    'click':function(){
                      NewVdmMask(index, _thisRef.isForm);
                    }
                  });
                  propBtnContainer.inject(propContainer,'bottom');
                break;
                case 'parameters':// Deprecated by type "parameters"
                  if(tool=='pagelet'){
                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(){
                        editParameters(this.refId);
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                  }
                break
                case 'description': // Deprecated by type "description"
                case 'value':
                  propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                  tdInput.grab(propInput,'top').inject(tr,'top');
                  tdButton.clone().grab(propBtnEdit).inject(tr);
                  propBtnEdit.addEvents({
                    'click':function(){
                      editDesc(this.refId,_thisRef.isForm,this.refPropId);
                    }
                  });
                  propBtnContainer.inject(propContainer,'bottom');
                break
                case "parms_source":
                  propBtnPick=this.CreateBtnPick(tabId,propertyID);
                  tdInput.grab(propInput,'top').inject(tr,'top');tdButton.clone().grab(propBtnPick).inject(tr);
                  propBtnPick.addEvents({
                    'click':function(){
                      let argsObj = {
                        "tool": 'parametersSources',
                        "ExpressionID": this.refId,
                        "dimensions":{
                            "top": null,
                            "left": null,
                            "width": 500,
                            "height": 300,
                            },
                        "objIndex": index,
                      }
                      PickItems(argsObj);
                    }
                  });
                break
                case "manifest":
                  //propBtnNew=this.CreateBtnNew(tabId,propertyID);
                  //tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnNew).inject(tr);
                  // propBtnNew.addEvents({
                    // 'click':function(){
                      // NewManifest(this.refId);
                    // }
                  // });
                  propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                  propBtnEdit.addEvents({
                    'click':function(){
                      EditManifest(this.refId);
                    }
                  });
                break
                default:
                  if (this.mainObject.objClass['edit'+propertyID+'Property']!=null){
                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(){
                        value=this.mainObject.objClass["edit"+propertyID+"Property"]()
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                  } else if (propertyID.indexOf("font_name")>-1){
                    propBtnPick=this.CreateBtnPick(tabId,propertyID);
                    propBtnPick.set('title','Select Font File');
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
                    propBtnPick.addEvents({
                      'click':function(){
                        SelectFont(this.refId);
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                  } else if (propertyID.indexOf("css")>-1){
                    propBtnPick=this.CreateBtnPick(tabId,propertyID);
                    propBtnPick.set('title','Select Css');
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
                    propBtnPick.addEvents({
                      'click':function(){
                        let argsObj = {
                          "tool": 'formstyle',
                          "ExpressionID": this.refId,
                          "dimensions":{
                              "top": null,
                              "left": null,
                              "width": 500,
                              "height": 300,
                              }
                        }
                        PickItems(argsObj);
                      }
                    });
                    /*
                    if(!isCMS){
                      propBtnNew=this.CreateBtnNew(tabId,propertyID);
                      propBtnNew.set('title','Edit Css');
                      propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                      tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                      propBtnEdit.addEvents({
                        'click':function(){
                          EditCss(index);
                        }
                      });
                      propBtnNew=this.CreateBtnNew(tabId,propertyID);
                      propBtnNew.set('title','New Css');
                      tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnNew).inject(tr);
                      propBtnNew.addEvents({
                        'click':function(){
                          NewCss();
                        }
                      });
                    }*/
                    propBtnContainer.inject(propContainer,'bottom');
                  } else if (propertyID=="sequence"){
                    propInput.addEvents({
                      'change': function() {
                        for (var i = 0; i < _itemsHTML.length; i++) {
                          if(this.value <= _itemsHTML[i].sequence) {
                            _itemsHTML[i].sequence++;
                          }
                        }
                      }
                    });
                  } else if ((this.mainObject.type=='EventEmitter' && propertyID=="parmsNames") || propertyID=="parmsValues" || propertyID=="parmsTypes" || propertyID=="eventsObjs" || propertyID=="eventsNames"){
                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                    propBtnEdit.set('title','Edit Event Emitter');
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(){
                        EditEventEmitter(index);
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                  } else if ((this.mainObject.type=='EventReceiver' && propertyID=="parmsNames") || propertyID=="actTypes" || propertyID=="actObjs" || propertyID=="objsValues"){
                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                    propBtnEdit.set('title','Edit Event Receiver');
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(){
                        EditEventReceiver(index);
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                  } else if ((propertyID=='src' && this.mainObject.type=='Portlet') || propertyID == 'portletsrc'){
                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                    propBtnEdit.set('title','Edit portlet');
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(){
                        editPortlet(this.refId);
                      }
                    });
                    propBtnPick=this.CreateBtnPick(tabId,propertyID);
                    propBtnPick.set('title','Select portlet');
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
                    propBtnPick.addEvents({
                      'click':function(){
                        //selectPortlet(this.refId);
                        PickItems('portlet',this.refId,null, null, 930, 600);
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                  } else if (tool=='pagelet' && propertyID=='name' && this.mainObject.type=='portlet'){
                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                    propBtnEdit.set('title','Edit portlet');
                    tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(){
                        editPortlet(this.refId);
                      }
                    });
                    propBtnContainer.inject(propContainer,'bottom');
                    propInput.disabled='disabled';

                  }else if(propertyID=='template') {
                    propBtnPick=this.CreateBtnPick(tabId,propertyID).set('title','Select layout');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnPick).inject(tr);
                    propBtnPick.addEvents({
                      'click':function(){
                        PickItems('pagelet',this.refId,null, null, 930, 600);
                        //SelectThemes(evt,index,'select');
                      }
                    });

                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID).set('title','Edit layout');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(evt){
                        editPagelet(evt,_thisRef.mainObject[this.refPropId]);
                      }
                    });

                    propBtnNew=this.CreateBtnNew(tabId,propertyID).set('title','New layout');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnNew).inject(tr);
                    propBtnNew.addEvents({
                      'click':function(evt){
                        NewTheme(evt,this.refId,'new');
                      }
                    });

                    propBtnContainer.inject(propContainer,'bottom');

                  }else if(isCMS && propertyID=='library'){ // CMS
                    propBtnPick=this.CreateBtnPick(tabId,propertyID).set('title','Select Js');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnPick).inject(tr);
                    propBtnPick.addEvents({
                      'click':function(){
                        SelectJs(this.refId);
                      }
                    });

                    propBtnContainer.inject(propContainer,'bottom');

                  }else if(isCMS && propertyID=='template_folder'){ // CMS
                    propBtnPick=this.CreateBtnPick(tabId,propertyID).set('title','Select layout');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnPick).inject(tr);
                    propBtnPick.addEvents({
                      'click':function(){
                        SelectTheme(this.refId,'true');
                      }
                    });

                    propBtnContainer.inject(propContainer,'bottom');

                  }else if(isCMS && propertyID=='layout'){ // CMS
                    propBtnPick=this.CreateBtnPick(tabId,propertyID).set('title','Select layout');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnPick).inject(tr);
                    propBtnPick.addEvents({
                      'click':function(){
                        SelectLayout(this.refId);
                      }
                    });

                    propBtnEdit=this.CreateBtnEdit(tabId,propertyID).set('title','Edit layout');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnEdit).inject(tr);
                    propBtnEdit.addEvents({
                      'click':function(evt){
                        EditTemplate(evt);
                      }
                    });

                    propBtnContainer.inject(propContainer,'bottom');

                  }else if(isCMS && (propertyID=="pname" || propertyID=="alias" || propertyID=="title" || propertyID=="meta" || propertyID=="meta_description")){ //CMS
                    var propBtnTran = this.CreateBtnTran(tabId,propertyID).set('title','Translate');
                    tdInput.grab(propInput,'top').inject(tr,'top');
                    tdButton.clone().grab(propBtnTran).inject(tr);
                    propBtnTran.addEvents({
                      'click':function(){
                        EditLanguage(index,this.refPropId);
                      }
                    });

                    propBtnContainer.inject(propContainer,'bottom');
                  }
              }
            break;
            case 'color':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('input',{'value':value,'type':'text','id':idInput,'name':tabName+"_"+propertyID,'class':'properties_input properties_color'});
              tdInput.grab(propInput,'top').inject(tr,'top');

              // il bottone avrà come id lo stesso id dell'input a cui è collegato con l'aggiunta del suffisso "_btn"
              var btn = tdButton.clone();
              var propBtnColor = new Element('div',{'class':'input_inline_btn properties_button_color', 'id':idInput+"_btn"});
              btn.grab(propBtnColor);
              var propBtnColorBg = new Element('div',{'class':'properties_button_color_bg'});
              btn.grab(propBtnColorBg);
              btn.inject(tr);

              jsColorPicker('input.properties_color', {
                size: 1,
                expires: 365, // durata del cookie contentente i colori salvati
                noResize: true,
                init: function(elm/*, col */) {
                  Ctrl(elm.id+"_btn").style.backgroundColor = elm.value;
                }
              });
            break;
            case "srcpagelet":
              idInput = tabId+"_"+propertyID;
              propInput = new Element('input',{'value':value,'type':'text','id':idInput,'name':tabName+"_"+propertyID,'class':'properties_input'});
              tdInput.grab(propInput,'top').inject(tr,'top');

              propBtnPick=this.CreateBtnPick(tabId,propertyID).set('title','Select portlet');
              tdInput.grab(propInput,'top').inject(tr,'top');
              tdButton.clone().grab(propBtnPick).inject(tr);
              propBtnPick.addEvents({
                'click':function(){
                  openWinInsert(this.refId);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');

              propBtnEdit = this.CreateBtnEdit(tabId, propertyID).set('title','Edit portlet');
              tdInput.grab(propInput, 'top').inject(tr, 'top');
              tdButton.clone().grab(propBtnEdit).inject(tr);
              propBtnEdit.addEvents({
                'click' : function () {
                  editPortlet(event, _thisRef.mainObject.src);
                }
              });
              propBtnContainer.inject(propContainer, 'bottom');
            break;
            case "autocomplete":
              propInput = new Element( 'input', {
                'value' : (value != "undefined" ? value : ''),
                'type'  : 'text',
                'id'    : tabId + "_" + propertyID,
                'name'  : tabName + "_" + propertyID,
                'list'  : "autoCompleteValues_" + tabId + "_" + propertyID,
                'class' : 'properties_input'
              });
              propInput.inject(propContainer);

              new Element( 'datalist', {
                'id'    : "autoCompleteValues_" + tabId + "_" + propertyID,
                'class' : 'datalist_input'
              }).inject(propContainer);
            break;

            case 'font-websafe':
              idInput = tabId + "_" + propertyID;
              propInput = new Element('select', {
                'id' : idInput,
                'name' : idInput,
                'class' : 'properties_select'
              });
              valueselect = this.mainObject.font;
              propInput.addEvents({
                'change':function(){
                  this.setStyles({
                    'font-family' : this.value
                  });
                }
              });
              if(!Empty(valueselect)) {
                propInput.setStyles({
                  'font-family' : valueselect.substring(0, valueselect.indexOf(','))
                });
              }
              for (mm = 0; mm < fontWebSafe.length; mm++) {
                var selected = "";
                var valueFont = fontWebSafe[mm];
                var nameFont = fontWebSafe[mm].substring(0, fontWebSafe[mm].indexOf(','));
                if(nameFont == valueselect || valueFont == valueselect) {
                  selected = 'selected';
                }
                propInputOpt = new Element('option', {
                  'value' : valueFont,
                  'text' : nameFont,
                  'selected' : selected
                }).setStyles({
                  'font-family' : nameFont
                });
                propInputOpt.inject(propInput);
              }
              propInput.inject(propContainer);
            break;
            case 'advanced-font':
              idInput = tabId + "_" + propertyID;
              propInput = new Element('select', {
                'id' : idInput,
                'name' : idInput,
                'class' : 'properties_select'
              });

              valueselect = this.mainObject.font || this.mainObject[propertyID];

              propInput.addEvents({
                'change':function(){
                  this.setStyles({
                    'font-family' : this.value
                  });
                  newObj.font = this.value;
				  if(tool=='report' || tool=='module' || tool=='scandoc'){
					  // no-write
				  }
				  else {
					writeHTML(true);
				  }
                }
              });
              if(!Empty(valueselect)) {
                propInput.setStyles({
                  'font-family' : valueselect.substring(0, valueselect.indexOf(','))
                });
              }

              var advancedFont = [];
			  if(tool=='report' || tool=='module' || tool=='scandoc'){
				  if(printFont.length > 0) {
					advancedFont.push("separator, Advanced Fonts")
					advancedFont = advancedFont.concat(printFont);
				  }
			  }
        else if(extraFont.length > 0) {
          advancedFont.push("separator, Advanced Fonts")
          advancedFont = advancedFont.concat(extraFont);
        }
			  var fontList = getFontListID(this.mainObject, propertyID);
			  if( fontList ){
				var selectListF = '';
				if(fontList.indexOf('select[')>-1){
					selectListF=fontList.substring(7,fontList.indexOf(']'));
					if(selectListF.indexOf("function:")>-1){
					  selectListF=selectListF.replace(/function:/g,'');
					  selectListF=eval(selectListF);
					}
					selectListF=selectListF.split(',');
					advancedFont = selectListF.concat(advancedFont);
				}
			  }
			  else {
				  advancedFont = fontWebSafe.concat(advancedFont);
			  }

        for (mm = 0; mm < advancedFont.length; mm++) {
          var valueAdvancedFont = advancedFont[mm];
          var nameAdvancedFont = advancedFont[mm].substring(0, advancedFont[mm].indexOf(','));
				if(nameAdvancedFont == '') {
					if(valueAdvancedFont.indexOf('separator-') == 0) {
						nameAdvancedFont = 'separator';
						valueAdvancedFont = valueAdvancedFont.substring(valueAdvancedFont.indexOf('-')+1);
						advancedFont[mm] = 'separator, ' + valueAdvancedFont;
					}
					else {
						nameAdvancedFont = valueAdvancedFont;
					}
				}
        if(nameAdvancedFont == 'separator') {
          propInputOpt = new Element('optgroup', { 'label' : advancedFont[mm].split(',')[1] });
          propInputOpt.inject(propInput);
          continue;
        }
        propInputOpt = new Element('option', {
          'value' : valueAdvancedFont,
          'text' : nameAdvancedFont,
          'selected' : (valueselect == valueAdvancedFont) ? 'selected' : ''
        }).setStyles({
          'font-family' : nameAdvancedFont
        });
        propInputOpt.inject(propInput);
      }
              propInput.inject(propContainer);
            break;
            case 'manual_font':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'properties_select'});
              valueselect = this.mainObject.online_font || this.mainObject[propertyID];

              propInput.addEvents({
                'change':function(){
                  this.setStyles({
                    'font-family' : this.value
                  });
                  newObj.online_font = this.value;
                  writeHTML(true);
                }
              });
              if(!Empty(valueselect)) {
                propInput.setStyles({
                  'font-family' : valueselect
                });
              }

              var fonts = this.mainObject.font_list.sort();
              for(mm=0; mm < fonts.length ; mm++) {
                propInputOpt = new Element('option',{
                  'value': fonts[mm],
                  'text': fonts[mm],
                  'selected':(valueselect==fonts[mm])?'selected':''
                }).setStyles({
                  'font-family' : fonts[mm]
                });
                if(!Empty(fonts[mm]) && this.mainObject._objType != "chart") {
                  var link = document.createElement('link');
                      link.href = 'https://fonts.googleapis.com/css?family='+Strtran(fonts[mm], " ", "+");
                      link.rel = 'stylesheet';
                      link.type = 'text/css';
                  document.head.appendChild(link);
                }
                propInputOpt.inject(propInput);
              }
              propInput.inject(propContainer);
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'select':

              //Gestione delle proprieta'� multiple separate da ',' si mostra una combobox in testata per poter navigare tra i valori
              if (propertyMultiple != null && propertyMultiple.type == 'combo') {
                selectList = !Empty(value ) ? value.split(',') : [];
              }

              idInput = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'properties_select'});
              valueselect= typeof(this.mainObject[propertyID])!='undefined' ? this.mainObject[propertyID].toString() : null;
              //eval('valueselect=this.mainObject.'+propertyID);
              if(isCMS && (propertyID=='forward' || propertyID=='overlink')){
                propInputOpt = new Element('option',{'value':'','text':''})
                propInputOpt.inject(propInput);
                for(var f=0;f<_itemsHTML.length;f++){
                  if(_itemsHTML[f].type=='Page' && this.mainObject.name != _itemsHTML[f].name){
                    if(propertyID=='forward' || propertyID=='overlink'){
                      propInputOpt = new Element('option',{'value':_itemsHTML[f].alias,'text':initialCap(_itemsHTML[f].title),'selected':(valueselect==_itemsHTML[f].alias)?'selected':''});
                      propInputOpt.inject(propInput);
                      //selectList.push(_itemsHTML[f].name)
                    }

                  }
                }
              }else{
                if( this.mainObject[propertyID+"vSelected"] ) {
                  valueselect = this.mainObject[propertyID+"vSelected"];
                  this.mainObject[propertyID+"vSelected"] = null;
                }
                for(mm=0;mm<selectList.length;mm++){
                  v = selectList[mm];
                  var t_v = v;
                  if(v.indexOf(":")>-1){
                    v = v.split(":");
                    t_v = v[1];
                    v = v[0];
                  }
                  vv = initialCap(v);
                  if(convertFunc){
                    eval("vv="+convertFunc+"(selectList[mm])")
                  }
                  propInputOpt = new Element('option',{'value':(t_v ? t_v : v),'text':vv,'selected':(valueselect==(t_v ? t_v : v))?'selected':''});
                  propInputOpt.inject(propInput);
                }
              }
              //propContainer.inject(tabContent)
              propInput.inject(propContainer);
            break;
            case 'timeformat_select':
            case 'dateformat_select':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'properties_select'});
              valueselect=this.mainObject[propertyID];
              for(mm=0;mm<selectList.length;mm++){
                v = selectList[mm];
                vv = initialCap(v);
                if(convertFunc){
                  eval("vv="+convertFunc+"(selectList[mm])")
                }
                propInputOpt = new Element('option',{'value':v,'text':vv,'selected':(valueselect==v)?'selected':''});
                propInputOpt.inject(propInput);
              }
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
            break;
            case 'pages':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'form_prop_nPages properties_select'});
              valueselect = formProp.page;
              for(mm=1;mm<=this.mainObject.npages;mm++){
                propInputOpt = new Element('option',{'value':mm,'text':mm,'selected':(valueselect==mm)?'selected':''}).setStyles({
                  });
                propInputOpt.inject(propInput);
              }
              // if(this.mainObject.npages>1){
              //   propInput.value = propInput.value.substring(0,propInput.value.length-1);
              // }
              propInput.inject(propContainer);
              var propBtnPlus=this.CreateBtnPlus(tabId,propertyID);
              propBtnPlus.set('title','Add page at the end');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPlus).inject(tr);
              propBtnPlus.addEvents({
                'click':function(){
                  addPage(index);
                }
              });
              var propBtnInsertBefore=this.CreateBtnInsertBefore(tabId,propertyID);
              propBtnInsertBefore.set('title','Insert page before current');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnInsertBefore).inject(tr);
              propBtnInsertBefore.addEvents({
                'click':function(){
                  insertPageBefore(index);
                }
              });
              var propBtnDelete=this.CreateBtnDel(tabId,propertyID);
              propBtnDelete.set('title','Delete page');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnDelete).inject(tr);
              propBtnDelete.addEvents({
                'click':function(){
                  deletePage(index);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'css_class':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('input',{'value':value,'type':'text','id':idInput,'name':tabName+"_"+propertyID,'class':'properties_input'});
              tdInput.grab(propInput,'top').inject(tr,'top');

              propBtnPick=this.CreateBtnPick(tabId,propertyID).set('title','Select css class');
              tdInput.grab(propInput,'top').inject(tr,'top');
              tdButton.clone().grab(propBtnPick).inject(tr);
              propBtnPick.addEvents({
                'click':function(){
                  var typeobj = (_thisRef.mainObject.type == "Form" ? "portlet" : _thisRef.mainObject.type);
                  let argsObj = {
                    "tool": 'css_class',
                    "ExpressionID": this.refId,
                    "dimensions":{
                      "top": null,
                      "left": null,
                      "width": 500,
                      "height": 300,
                      },
                    "css-type": (typeobj).toLowerCase()
                  }
                  PickItems(argsObj);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');

              propBtnPlus = this.CreateBtnPlus(tabId, propertyID).set('title','Create new css class');
              tdInput.grab(propInput, 'top').inject(tr, 'top');
              tdButton.clone().grab(propBtnPlus).inject(tr);
              propBtnPlus.addEvents({
                'click' : function () {
                  newClass(this.refId,(_thisRef.mainObject.type).toLowerCase());
                }
              });
              propBtnContainer.inject(propContainer, 'bottom');

              propBtnEdit = this.CreateBtnEdit(tabId, propertyID).set('title','Edit css class');
              tdInput.grab(propInput, 'top').inject(tr, 'top');
              tdButton.clone().grab(propBtnEdit).inject(tr);
              propBtnEdit.addEvents({
                'click' : function () {
                  editClass(this.refId,(_thisRef.mainObject.type).toLowerCase(),_thisRef.mainObject.css);
                }
              });
              propBtnContainer.inject(propContainer, 'bottom');

              if(_thisRef.isForm && propertyID.toLowerCase() == "css_class") {
                var propBtnFill = new Element('div',{'class':'input_inline_btn', 'title' : 'Manage all css class.', 'icon-data': String.fromCharCode(parseInt('&#xe67f;'.substring(3,7),16))});
                propBtnFill.refId = tabId+"_"+propertyID;
                propBtnFill.refPropId = propertyID;
                tdInput.grab(propInput, 'top').inject(tr, 'top');
                tdButton.clone().grab(propBtnFill).inject(tr);
                propBtnFill.addEvents({
                  'click' : function () {
                    allClass(this.refId);
                  }
                });
                propBtnContainer.inject(propContainer, 'bottom');
              }
            break;
            case 'css_prop':
              idInput = tabId + "_" + propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'properties_select'});
              var elem_state = (newObj.states) ? newObj.states.split(',') : 0;
              for(var index_state = 0; index_state < elem_state.length ; index_state++){
                propInputOpt = new Element('option',{
                  'value': elem_state[index_state].toString(),
                  'text': elem_state[index_state].toString(),
                  'selected': (newObj.current_state == elem_state[index_state].toString()) ? 'selected' : ''});
                propInputOpt.inject(propInput);
              }
              propInput.inject(propContainer);
            break;
            case 'steps_layout':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'properties_select'});
              valueselect = formProp.layout_step;
              var steps=formProp.steps.split(',');
              steps=steps.sort(function(a,b){
               return parseInt(a)>parseInt(b);
              });
              for(mm=0; mm < steps.length ; mm++){
                propInputOpt = new Element('option',{'value':steps[mm].toString(),'text':steps[mm].toString(),'selected':(valueselect==steps[mm].toString())?'selected':''});
                propInputOpt.inject(propInput);
              }
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              if(!Empty(steps[0])){
                if(Empty(formProp.layout_step))formProp.layout_step=steps[0];
                formProp.v_line=(!Empty(valueselect)?valueselect:steps[0].toString());
                //formProp.w='100%';
              }else
                formProp.layout_step='';
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'layers':
              var idInputLayers = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInputLayers,'name':idInputLayers,'class':'form_prop_nPages'}).setStyles({'width':'75%'});
              var propBtnPlusLayers = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe605;'.substring(3,7),16))});
              var propBtnMinusLayers = new Element('div',{'class':'input_inline_btn', 'icon-data': String.fromCharCode(parseInt('&#xe6a8;'.substring(3,7),16))});
              valueselect = this.mainObject.layer;
              for(mm=1;mm<=this.mainObject.nlayers;mm++){
                propInputOpt = new Element('option',{'value':mm,'text':mm,'selected':(valueselect==mm)?'selected':''});
                propInputOpt.inject(propInput);
              }
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtnMinusLayers.set('title','Remove Layer');
              propBtnMinusLayers.inject(propBtnContainer);
              propBtnMinusLayers.addEvents({
                'click':function(){
                removeLayer(index);
                }
              });
              propBtnPlusLayers.set('title','Add Layer');
              propBtnPlusLayers.inject(propBtnContainer);
              propBtnPlusLayers.addEvents({
                'click':function(){
                addLayer(index);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'textarea':
            value = this.mainObject[propertyID];
            idInput = tabId + "_" + propertyID;
            var propInputWrapper = new Element('div', {
              'id' : idInput + "_wrapper",
              'class' : 'properties_textarea_container'
            });
            propInput = new Element('textarea', {
              'class' : 'properties_textarea',
              'rows' : '10',
              'id' : idInput,
              'name' : idInput,
              'value' : value
            });
            propInput.inject(propInputWrapper);
            propInputWrapper.inject(propContainer);
            break;
            case 'checkbox':
              value=this.mainObject[propertyID];
              if (typeof(value)!="boolean")
                value=(value == "true")?true:false;
              idInput = tabId+"_"+propertyID;
              propInputWrapper = new Element('div',{'id':idInput+"_wrapper",'class':'properties_checkbox_container'});
              propInput = new Element('input',{'class':'properties_checkbox',
                'type':'checkbox',
                'id':idInput,
                'name':idInput,
                'checked':((value)?'checked':'')
                }).setStyles({'border-color':((value)?'#A3C891':'#FFFFFF')});
              propInput.inject(propInputWrapper);
              //propContainer.inject(tabContent)
              propInputWrapper.inject(propContainer);
            break;
            case 'image':
              propInput = new Element('input',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID,'name':tabName+"_"+propertyID,'class':'properties_image'/*,'placeholder':propertyScreen*/});
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtnPick=this.CreateBtnPick(tabId,propertyID);
              propBtnPick.set('title','Select image');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
              propBtnPick.addEvents({
                'click':function(){
                  selectImage(tabId+"_"+this.refPropId);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'exp':
              propInput = new Element('input',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID,'name':tabName+"_"+propertyID,'class':'properties_input'/*,'placeholder':propertyScreen*/});
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtnPick=this.CreateBtnPick(tabId,propertyID);
              propBtnPick.set('title','Edit expression');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
              propBtnPick.addEvents({
                'click':function(){
                  BuildExpression(index,this.refPropId,this.refId,"exp");
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
              propInput.addEvents({
                'focus' : function () {
                  SetSelectedProp(index, this.id, this.propID);
                }
              });
            break;
            case 'data':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'properties_data'});
              propInputOpt = new Element('option',{'value':'','text':'None'})
              propInputOpt.inject(propInput);
              for(mm=0;mm<_itemsHTML.length;mm++){
                if(_itemsHTML[mm].type=='MLevelDataProvider' || _itemsHTML[mm].type=='SQLDataobj' || _itemsHTML[mm].type=='XMLDataobj' || _itemsHTML[mm].type=='AdvTreeView' || _itemsHTML[mm].derivType=='SQLDataobj' || _itemsHTML[mm].type=='MenuView' ||
                 (_itemsHTML[mm].type=='Variable' && _itemsHTML[mm].reactive=='true') || _itemsHTML[mm].type=='JSONDataobj') {
                  propInputOpt = new Element('option',{'value':_itemsHTML[mm].name,'text':_itemsHTML[mm].name,'selected':(this.mainObject[propertyID]==_itemsHTML[mm].name)?'selected':''})
                  propInputOpt.inject(propInput);
                }
              }
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
            break;
            case 'xmldata':
              idInput = tabId+"_"+propertyID;
              propInput = new Element('select',{'id':idInput,'name':idInput,'class':'properties_data'});
              propInputOpt = new Element('option',{'value':'','text':'None'})
              propInputOpt.inject(propInput);
              for(mm=0;mm<_itemsHTML.length;mm++){
                if((_itemsHTML[mm].type=='XMLDataobj' || _itemsHTML[mm].derivType=='XMLDataobj') && this.mainObject.name!=_itemsHTML[mm].name) {
                  propInputOpt = new Element('option',{'value':_itemsHTML[mm].name,'text':_itemsHTML[mm].name,'selected':(this.mainObject.xmldataobj==_itemsHTML[mm].name)?'selected':''})
                  propInputOpt.inject(propInput);
                }
              }
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
            break;
            case "querylist":
              value = (EmptyString(value)) ? '' : value;
              propInput = new Element('input',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID
              ,'name':tabName+"_"+propertyID,'class':'properties_input','list':(propertylist?'true':false)})
              propInput.inject(propContainer);
              propBtnPick=this.CreateBtnPick(tabId,propertyID);
              propBtnPick.set('title','Select query');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
              propBtnPick.addEvents({
                'click':function(){
                  //SelectQuery(index, _thisRef.isForm, this.refId);
                  PickItems('visualquery',this.refId,null,null,930, 600);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'datafield':
            case 'singlefield':
            case 'bofield':
              value = (EmptyString(value)) ? '' : value;
              propInput = new Element('input',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID,'name':tabName+"_"+propertyID,'class':'properties_input'/*,'placeholder':propertyScreen*/})
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtnPick=this.CreateBtnPick(tabId,propertyID,propertyType);
              propBtnPick.dataObjRef = dataobjref;
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
              propBtnPick.addEvents({
                'click':function(){
                  if(this.PropType=='bofield'){
                    let argsObj = {
                      "tool": 'procedures',
                      "ExpressionID": this.refId,
                      "dimensions":{
                        "top": null,
                        "left": null,
                        "width": 500,
                        "height": 500,
                        },
                      "is-form": _thisRef.isForm,
                      "offline": itemsHTML[index].offline
                    }
                    PickItems(argsObj);
                    // ../jsp-system/SPVQREditorSelectBO_portlet.jsp?hideLinkedTables=true&offlinemode="+offlinemode+'&propRef='+the_property+'&isForm='+isForm
                    // pickerBO(this.refPropId,_thisRef.isForm);
                  } else  {
                    let dataObjectName = itemsHTML[index][this.dataObjRef];
                    try {
                    const ctrlItem = itemsHTML.filter(item => item.name === dataObjectName)[0];
                    const query_name = ctrlItem.query;
                    let tool;
                    if(ctrlItem.type === 'SQLDataobj') tool = 'queryParms';
                    if(ctrlItem.type === 'Variable') tool = 'variable_field_picker';
                    let argsObj = {
                      "tool": tool,
                      "ExpressionID": this.refId,
                      "dimensions":{
                        "top": null,
                        "left": null,
                        "width": 500,
                        "height": 300,
                        },
                      "query-name": query_name
                    }
                    PickItems(argsObj);
                  } catch {
                    PSAlert.alert("Select a data object");
                  }
                  }
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'parameters':
              value = (EmptyString(value)) ? '' : value;
              propInput = new Element('input',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID,'name':tabName+"_"+propertyID,'class':'properties_input'/*,'placeholder':propertyScreen*/})
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtnPick=this.CreateBtnPick(tabId,propertyID,propertyType);
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
              propBtnPick.addEvents({
                'click':function(){
                  PickParameters(index,this.refPropId,this.refId,this.PropType);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'description':
            case 'value':
              value = (EmptyString(value)) ? '' : value;
              propInput = new Element('textarea',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID,'name':tabName+"_"+propertyID,'class':'properties_input'/*,'placeholder':propertyScreen*/})
              //propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
              tdInput.grab(propInput,'top').inject(tr,'top');
              tdButton.clone().grab(propBtnEdit).inject(tr);
              propBtnEdit.addEvents({
                'click':function(){
                  editDesc(this.refId,_thisRef.isForm,this.refPropId);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case 'table':
              value = (EmptyString(value)) ? '' : value;
              propInput = new Element('input',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID,'name':tabName+"_"+propertyID,'class':'properties_input'/*,'placeholder':propertyScreen*/})
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtn = this.CreateBtnPick(tabId,propertyID,propertyType);
              propBtn.set('title','Pick');
              tdInput.grab(propInput,'top').inject(tr,'top');
              tdButton.clone().grab(propBtn).inject(tr);
              propBtn.addEvents({
                'click':function(){
                  BuildExpression(index,this.refPropId,this.refId,this.PropType);
                }
              });
              propBtnContainer.inject(propContainer,'bottom');

            break;
            case "portlet": case "decorators":
              value = (EmptyString(value)) ? '' : value;
              propInput = new Element('input',{'value':(value != "undefined" ? value : ''),'type':'text','id':tabId+"_"+propertyID,'name':tabName+"_"+propertyID,'class':'properties_input'/*,'placeholder':propertyScreen*/})
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);
              propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
              propBtnEdit.set('title','Edit portlet');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
              propBtnEdit.addEvents({
                'click':function(){
                  editPortlet(this.refId);
                }
              });
              propBtnPick=this.CreateBtnPick(tabId,propertyID);
              propBtnPick.set('title','Select portlet');
              tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
              if(propertyType=='decorators'){
                propBtnPick.addEvents({
                  'click':function(){
                    PickItems('decorators',this.refId,null, null, 930, 600);
                  }
                });
              }else{
                propBtnPick.addEvents({
                  'click':function(){
                    PickItems('portlet',this.refId,null, null, 930, 600);
                  }
                });
              }
              propBtnContainer.inject(propContainer,'bottom');
            break;
            case "chartdef":
              value = (EmptyString(value)) ? '' : value;
              propInput = new Element('input',{
                'value':(value != "undefined" ? value : ''),
                'type':'text','id':tabId+"_"+propertyID,
                'name':tabName+"_"+propertyID,
                'class':'properties_input'
                // 'title':(Empty(tooltip)?'Set the '+propertyScreen:tooltip),
              })
              // propContainer.inject(tabContent)
              propInput.inject(propContainer);

              var propBtnWiz=this.CreateBtnWizard(tabId,propertyID);
                tdInput.grab(propInput,'top').inject(tr,'top');
                tdButton.clone().grab(propBtnWiz).inject(tr);
                propBtnWiz.addEvents({
                  'click':function(){
                    StartChartWizard();
                  }
                });
                propBtnWiz.set('title','Select chart type');

              propBtnPick=this.CreateBtnPick(tabId,propertyID);
                tdInput.grab(propInput,'top').inject(tr,'top');
                tdButton.clone().grab(propBtnPick).inject(tr);
                propBtnPick.addEvents({
                  'click':function(){
                    //SelectChartDef(index, _thisRef.isForm, this.refId);
                    PickItems('chart',this.refId,null, null, 930, 600);
                  }
                });
                propBtnPick.set('title','Select chartdef');

                propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                propBtnEdit.addEvents({
                  'click':function(){
                    EditChartDef(index, _thisRef.isForm);
                  }
                });
                propBtnEdit.set('title','Edit chartdef');

                propBtnNew=this.CreateBtnNew(tabId,propertyID);
                tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnNew).inject(tr);
                propBtnNew.addEvents({
                  'click':function(){
                    NewChartDef();
                  }
                });
                propBtnNew.set('title','New chartdef');

                propBtnContainer.inject(propContainer,'bottom');
            break;
            case "vdmdef":
                input_class='properties_input';
                value = (EmptyString(value)) ? '' : value;
                propInput = new Element('input',{
                  'value':(value != "undefined" ? value : ''),
                  'type':'text','id':tabId+"_"+propertyID,
                  'name':tabName+"_"+propertyID,
                  'class':input_class
                  // 'title':(Empty(tooltip)?'Set the '+propertyScreen:tooltip),
                })
                propBtnPick=this.CreateBtnPick(tabId,propertyID);
                //propBtnPick.inject(propBtnContainer);
                tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnPick).inject(tr);
                propBtnPick.addEvents({
                  'click':function(){
                    SelectVdmMask(index, _thisRef.isForm, this.refId);
                  }
                });
                propBtnEdit=this.CreateBtnEdit(tabId,propertyID);
                tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnEdit).inject(tr);
                propBtnEdit.addEvents({
                  'click':function(){
                    EditVdmMask(index, _thisRef.isForm, this.refPropId);
                  }
                });
                propBtnNew=this.CreateBtnNew(tabId,propertyID);
                tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtnNew).inject(tr);
                propBtnNew.addEvents({
                  'click':function(){
                    NewVdmMask(index, _thisRef.isForm);
                  }
                });
                propBtnContainer.inject(propContainer,'bottom');
                break;
          }


          if(propertyButtons && propertyActions){
                var bts = propertyButtons.split(',');
                propertyActions = Strtran(propertyActions,' ',''); //tolgo gli eventuali spazi dalla stringa contentente i parametri;
                var acts = propertyActions.split('),');
                for(var X=0; X< bts.length;X++){
                  var propBtn = null;
                  switch(bts[X]){
                    case 'edit':
                      propBtn = this.CreateBtnEdit(tabId,propertyID);
                      propBtn.set('title','Edit');
                    break;
                    case 'new':
                      propBtn = this.CreateBtnNew(tabId,propertyID);
                      propBtn.set('title','New');
                    break;
                    case 'del':
                      propBtn = this.CreateBtnDel(tabId,propertyID);
                      propBtn.set('title','Delete');
                    break;
                    case 'tran':
                      propBtn = this.CreateBtnTran(tabId,propertyID);
                      propBtn.set('title','Translate');
                    break;
                    case 'pick':
                      propBtn = this.CreateBtnPick(tabId,propertyID);
                      propBtn.set('title','Pick');
                    break;
                    case 'plus':
                      propBtn = this.CreateBtnPlus(tabId,propertyID);
                      propBtn.set('title','Add');
                    break;
                    case 'up':
                      propBtn = this.CreateBtnUp(tabId,propertyID);
                      propBtn.set('title','Move up');
                    break;
                    case 'down':
                      propBtn = this.CreateBtnDown(tabId,propertyID);
                      propBtn.set('title','Move down');
                    break;
                    case 'reload':
                      propBtn = this.CreateBtnReload(tabId,propertyID);
                      propBtn.set('title','Reload');
                    break;
                    case 'date':
                      propBtn = this.CreateBtnDate(tabId,propertyID);
                      propBtn.set('title','Date');
                    break;
                    case 'info':
                      propBtn = this.CreateBtnInfo(tabId,propertyID);
                      propBtn.set('title','Show additional informations');
                    break;
                    case 'search':
                      propBtn = this.CreateBtnSearch(tabId,propertyID);
                      propBtn.set('title','Search');
                    break;
                    case 'wizard':
                      propBtn = this.CreateBtnWizard(tabId,propertyID);
                      propBtn.set('title','Wizard');
                    break;
                    default:
                      propBtn = ZTObjects['Create'+bts[X]](tabId,propertyID);
                      propBtn.set('title',ZTObjects['Title'+bts[X]]());
                    break;
                  }
                  tdInput.grab(propInput,'top').inject(tr,'top');  tdButton.clone().grab(propBtn).inject(tr);
                  //dovrei chiamare la addEvent e passare anche l'oggetto come parametro nell'array degli arguments
                  propBtn.func = acts[X].substring(0, acts[X].indexOf('('))
                  //propBtn.pars = acts[X].substring(acts[X].indexOf('(')+1,acts[X].indexOf(')'))
                  // propBtn.addEvents({
                    // 'click': function(){
                      // window[this.func](this.refId,(Empty(this.pars) ? '' : this.pars))
                     // }
                  // })
                  var pars = acts[X].substring(acts[X].indexOf('{'),acts[X].indexOf('}')+1) ;
                  propBtn.parsObj = !Empty(pars) ? eval("("+ pars +")") : {};
                  propBtn.addEvents({
                    'click': function(){
                      this.parsObj['index']=index;
                      this.parsObj['refId']=this.refId;
                      this.parsObj['refPropId']=this.refPropId;
                      this.parsObj['button']=this;
                      eval(this.func).call(window, this.parsObj);
                     }
                  })

                }
                propBtnContainer.inject(propContainer,'bottom');
              }



          // propInput.morphEffect = new Fx.Morph(propInput, {duration: '200', 'link':'cancel'});
          propInput.store('myTab', (this.isForm?'Form_':'')+tabName+"_tab");
          propInput.propID = propertyID;
          //Setting class for properties externally changed
          //if(propertyID == "y" || propertyID == "x" || propertyID == "w" || propertyID == "h" || propertyID == "query"){
          propInput.addClass(this.mainObject.id+"_"+propertyID);
          //}
          propInput.propertyType = propertyType;
          propInput.set('tabindex',globalIndex);
          propInput.addClass((this.isForm?'Form_':'')+tabName+"_tab_property");

          propInput.addClass((this.isForm?'Form_':'')+"property_item");
          globalIndex++;
          // propLabel.morphEffect = new Fx.Morph(propLabel, {duration: '100', 'link':'cancel'});
          // propContainer.morphEffect = new Fx.Morph(propLabel, {duration: '100', 'link':'cancel'});

          if(isDisabled){
            // propInput.setStyle('opacity','0');
            // propLabel.setStyle('color','#D8D8D8');
            propContainer.hide();
          }
          if(isNotEditable){
            propInput.setStyle('background-color','#D8D8D8');
            propInput.set('disabled','disabled');
          }
          propInput.hide_list = property.hide_list;
          propInput.show_list = property.show_list;
          propInput.convertFunc = convertFunc;
          propInput.reconvertFunc = reconvertFunc;
          propInput.validFunc = validFunc;
          propInput.setOnBlurFunc = setOnBlurFunc;
          propInput.alwaysUpdates = alwaysUpdates;
          propInput.addEvents({
            //Custom event
            'show' : function(){
              var container = document.getElementById(this.id+"_container");
              var oldStatus = false;
              var tabProps = _thisRef.mainObject.objClass.newProperties[tabName];
              for(var i =0;i<tabProps.length;i++){
                if(tabProps[i].propID == this.propID){
                  oldStatus = tabProps[i].disabled;
                  tabProps[i].disabled = false;
                  // cancella il possibile evento in chain della hide
                  break;
                }
              }
              if(oldStatus){
                // this.morphEffect.cancel();
                container.show();
                // this.morphEffect.start({
                  // 'opacity':1
                // });
                // var label = document.getElementById(this.id+"_label");
                if(/*_thisRef.isForm &&*/ _thisRef.afterRender)
                  _thisRef.afterRender(true);
              }
            },
            //Custom event
            'hide' : function(){
              var container = document.getElementById(this.id+"_container");
              var oldStatus = true;
              var tabProps = _thisRef.mainObject.objClass.newProperties[tabName];
              for(var i =0;i<tabProps.length;i++){
                if(tabProps[i].propID == this.propID){
                  oldStatus = tabProps[i].disabled;
                  tabProps[i].disabled = true;
                  break;
                }
              }
              if(!oldStatus){
                // this.morphEffect.start({
                  // 'opacity':0
                // }).chain(function(){
                  container.hide();
                // })
                if(/*_thisRef.isForm &&*/ _thisRef.afterRender)
                  _thisRef.afterRender(true);
              }
            },
            //Shift+Tab navigation (first => previous tab) - Tab navigation (last => next tab)
            'keydown' : function(event){
              var elTab = document.getElementById(this.retrieve('myTab'));
              var isFirstNotHidden = true;
              var isLastNotHidden = true;
              if(document.getElementById(this.id+"_container").parentElement.type == 'fieldset') {
                document.getElementById(this.id+"_container").getAllPrevious().append(document.getElementById(this.id+"_container").parentElement.getAllPrevious()).each(function(el){
                  if(el.nodeName.toLowerCase() != 'legend' && el.getStyle('display') != "none" )
                    isFirstNotHidden = false;
                });
                document.getElementById(this.id+"_container").getAllNext().append(document.getElementById(this.id+"_container").parentElement.getAllNext()).each(function(el){
                  if(el.nodeName.toLowerCase() != 'legend' && el.getStyle('display') != "none" )
                    isLastNotHidden = false;
                });
              } else {
                document.getElementById(this.id+"_container").getAllPrevious().each(function(el){
                  if(el.getStyle('display') != "none" )
                    isFirstNotHidden = false;
                });
                document.getElementById(this.id+"_container").getAllNext().each(function(el){
                  if(el.getStyle('display') != "none")
                    isLastNotHidden = false;
                });
              }
              var toDelay;

              if (event.key == "tab" && event.shift && isFirstNotHidden && !Empty(elTab) && !Empty(elTab.previousSibling)){ // prev tab
                var find = false;
                while(!find && !Empty(elTab.previousSibling)){
                  if(document.getElementById(elTab.previousSibling.id).getStyle('display')!='none')
                    find = true;
                  else if(!Empty(elTab.previousSibling))
                    elTab = elTab.previousSibling;
                }
                if(Empty(elTab.previousSibling)) return;
                //Firing click event on the previous tab
                elTab.previousSibling.fireEvent('click');
                //Setting focus on the last visible item
                toDelay = function(){
                var nextTabFLastElem = null;
                document.getElementById(elTab.previousSibling.id+"_content").getChildren().each(function(ch){
                  if(ch.getStyle('display') != "none")
                    nextTabFLastElem = ch.getElement("."+elTab.previousSibling.id+"_property");
                });
                nextTabFLastElem.focus();
                }
                toDelay.delay(500);
              }else if(event.key == "tab" && !event.shift && isLastNotHidden && !Empty(elTab) && !Empty(elTab.nextSibling)){ //next tab
              var found = false;
              while(!found && !Empty(elTab.nextSibling)){
                if(document.getElementById(elTab.nextSibling.id).getStyle('display')!='none')
                  found = true;
                else if(!Empty(elTab.nextSibling))
                  elTab = elTab.nextSibling;
              }
              if(Empty(elTab.nextSibling)) return;
                //Firing click event on the next tab
                elTab.nextSibling.fireEvent('click');
                //Setting focus on the first visible item
                 toDelay = function(){
                  var nextTabFirstElem = null;
                  document.getElementById(elTab.nextSibling.id+"_content").getChildren().each(function(ch){
                    if(ch.getStyle('display') != "none" && Empty(nextTabFirstElem))
                      nextTabFirstElem = ch.getElement("."+elTab.nextSibling.id+"_property");
                  });
                  nextTabFirstElem.focus();
                }
                toDelay.delay(500);
              }
            }
          });
          switch(propertyType){
            case "int":
            case "str":
            case "exp":
            case "image":
            case "datafield":
            case "singlefield":
            case 'bofield':
            case 'parameters':
            case 'description':
            case 'portlet':
            default:
              //Cambio la combo testata delle proprietà multiple(separate da ,) collegate
              if( propertyMultiple != null && propertyMultiple.type=='combo'){
                propInput.addEvents({
                  'change': ( function(propertyMultiple, Values,props,tabName, property){ return function(){ //event,propertyMultiple,values,value
                      if(propertyMultiple!=null){
                        //if(propertyMultiple.type!='combo') return;
                        // var values=Values.split(',');
                        if(propertyMultiple.type=='combo'){
                          //for(var m=0;mm<values.length;m++){
                          //  if(this.value==values[m]){
                              property.multiple.multiple_index = this.selectedIndex;
                              updatePropMultiple(this.selectedIndex,propertyMultiple.id,props,tabName,_thisRef.isForm,this.value,property.propID,property.setOnBlurFunc);
                              //break;
                          //  }
                          //}

                        }
                      }
                    }
                  })(propertyMultiple,value,props,tabName,property)
                });
              }else if(propertyMultiple != null && propertyMultiple.type=='input'){
                propInput.addEvents({
                  'blur': (function(propertyMultiple,property,tabName){ return function(){ //Bind javascript
                      //propertyChangeNotifier.bind(this)(this.value,updateHTML,_thisRef.isForm);
                      editPropMultiple(this.value,property,document.getElementById((_thisRef.isForm?'Form_':'') + tabName+'_'+propertyMultiple.id).selectedIndex,_thisRef.isForm,this,property.validFunc);
                      SetOnEditProp(false);
                      document.getElementById(this.id+"_container").removeClass('selected');
                    }
                  })(propertyMultiple,property,tabName),


                  'focus':function(){
                    SetOnEditProp(true);
                    document.getElementById(this.id+"_container").addClass('selected');
                  }
                });
              }else if(propertyMultiple != null && propertyMultiple.type=='checkbox'){
                propInput.addEvents({
                  'change': (function(propertyMultiple,property,tabName){ return function(){ //Bind javascript
                      editPropMultiple(this.checked.toString(),property,document.getElementById((_thisRef.isForm?'Form_':'') + tabName+'_'+propertyMultiple.id).selectedIndex,_thisRef.isForm);
                      SetOnEditProp(false);
                      document.getElementById(this.id+"_container").removeClass('selected');
                    }
                  })(propertyMultiple,property,tabName),
                  'focus':function(){
                    SetOnEditProp(true);
                    document.getElementById(this.id+"_container").addClass('selected');
                  }
                });
              }else{
                propInput.addEvents({
                  'blur':function(event,updateHTML){
                    propertyChangeNotifier.bind(this)(this.value,updateHTML,_thisRef.isForm);
                    updateProperties(
                      this,this.propID,this.propertyType,_thisRef.isForm,this.value,
                      updateHTML,this.reconvertFunc,this.validFunc,_thisRef.mainObject,
                      this.alwaysUpdates,this.setOnBlurFunc
                    );
                    SetOnEditProp(false);
                    document.getElementById(this.id+"_container").removeClass('selected');

                  },
                  'focus':function(){
                    SetOnEditProp(true);
                    document.getElementById(this.id+"_container").addClass('selected');

                  }
                });
              }
            break;
            case "select":
            case "data":
            case "xmldata":
            case 'timeformat_select':
            case 'dateformat_select':
              if( propertyMultiple != null && propertyMultiple.type=='combo'){
                propInput.addEvents({
                  'change': ( function(propertyMultiple, Values,props,tabName){ return function(){ //event,propertyMultiple,values,value
                      if(propertyMultiple!=null){
                        if(propertyMultiple.type!='combo') return;
                        // var values=Values.split(',');
                        if(propertyMultiple.type=='combo'){
                          //for(var m=0;mm<values.length;m++){
                          //  if(this.value==values[m]){
                              updatePropMultiple(this.selectedIndex,propertyMultiple.id,props,tabName);
                              //break;
                          //  }
                          //}

                        }
                      }
                    }
                  })(propertyMultiple,value,props,tabName)
                });
              }else if(propertyMultiple != null && propertyMultiple.type=='input'){
                propInput.addEvents({
                  'blur': (function(propertyMultiple,property,tabName){ return function(){ //Bind javascript
                      //propertyChangeNotifier.bind(this)(this.value,updateHTML,_thisRef.isForm);
                      editPropMultiple(this.value,property,document.getElementById(tabName+'_'+propertyMultiple.id).selectedIndex);
                      SetOnEditProp(false);
                      document.getElementById(this.id+"_container").removeClass('selected');
                    }
                  })(propertyMultiple,property,tabName),


                  'focus':function(){
                    SetOnEditProp(true);
                    document.getElementById(this.id+"_container").addClass('selected');
                  }
                });
              } else {
                propInput.addEvents({
                  'change':function(event,updateHTML){
                    propertyChangeNotifier.bind(this)(this.value,updateHTML,_thisRef.isForm);
                    updateProperties(
                      this,this.propID,this.propertyType,_thisRef.isForm,this.value,
                      updateHTML,this.reconvertFunc,this.validFunc,_thisRef.mainObject,
                      this.alwaysUpdates,this.setOnBlurFunc
                    );
                    //SetOnEditProp(true);
                  },
                  'focus':function(){SetOnEditProp(true);},
                  'blur':function(){ SetOnEditProp(false);}
                });
              }
            break;
            case "pages":
              propInput.addEvents({
                'change':function(){
                  updatePropMultiple(this.selectedIndex,propertyMultiple.id,props,tabName);
                 //updateProperties(this,this.propID,this.propertyType,_thisRef.isForm,this.value,true,this.reconvertFunc,this.validFunc,_thisRef.mainObject,this.alwaysUpdates);
                },
                'focus':function(){SetOnEditProp(true);},
                'blur':function(){ SetOnEditProp(false);}
              });
            break;
            case "css_prop":
              propInput.addEvents({
                'change':function(){
                  var old_val = newObj.current_state;
                  updateProperties(this,this.propID,this.propertyType,_thisRef.isForm,this.value,false,this.reconvertFunc,this.validFunc,_thisRef.mainObject,this.alwaysUpdates);
                  updateStates(old_val, this.value);
                  generateProperties();
                  (this.value != ":before" && this.value != ":after") ?
                    document.getElementById("general_content_section").classList.add('hide-element') :
                    document.getElementById("general_content_section").classList.remove('hide-element');
                  writeHTML();
                },
                'focus':function(){
                  SetOnEditProp(true);
                },
                'blur':function(){
                  SetOnEditProp(false);
                }
              });
            break;
            case "steps_layout":
              propInput.addEvents({
                'change':function(){
                  var old_val=formProp.layout_step;
                  propertyChangeNotifier.bind(this)(this.value,false,_thisRef.isForm);
                  updateProperties(this,this.propID,this.propertyType,_thisRef.isForm,this.value,false,this.reconvertFunc,this.validFunc,_thisRef.mainObject,this.alwaysUpdates);
                  updateLayoutSteps(old_val,this.value);
                  FormProperties(true);
                  var prop=null;
                  for(var ii=0 ;ii < formProp.objClass.newProperties.generic.length; ii++){
                    if( formProp.objClass.newProperties.generic[ii].propID == "v_line" ){
                      prop = formProp.objClass.newProperties.generic[ii];
                      break;
                    }
                  }
                  if( prop )
                    _thisRef.updateProp(formProp, "generic", prop);
                  // FormProperties();
                } ,
                'focus':function(){SetOnEditProp(true);},
                'blur':function(){ SetOnEditProp(false);}
              });
            break;
            case "layers":
            propInput.addEvents({
              'change':function(event){
              updateProperties(event,this.propID,this.propertyType,_thisRef.isForm,this.value,true,this.reconvertFunc,this.validFunc,_thisRef.mainObject,this.alwaysUpdates);
              }
            });
            break;
            case "checkbox":
              propInput.addEvents({
                'click':function(event,updateHTML){
                  var wrp = this.getParent();
                  wrp.setStyle('border-color',((this.checked)?"#A3C891":"#DEDEDE"));
                  var c = this.checked;
                  propertyChangeNotifier.bind(this)((this.checked)?"checked":"unchecked",true,_thisRef.isForm);
                  this.checked = c;
                  updateProperties(
                    this,this.propID,this.propertyType,_thisRef.isForm,this.checked,
                    updateHTML,this.reconvertFunc,this.validFunc,_thisRef.mainObject,
                    this.alwaysUpdates,this.setOnBlurFunc
                  );
                  SetOnEditProp(false);
                },
                'focus':function(){SetSelectedProp(index,this.id,this.propID);SetOnEditProp(true);},
                'blur':function(){ SetOnEditProp(false);}
              });
            break;
            case "autocomplete":
              var number = false, sizeList = selectList.length;

              /**
               * [if controllo a che tipo corrisponde l'autocomplete, sono disponibili 3 varianti]
               * @param  {[string]} typeList [default   : la parola viene completata fra quelle scelte man mano che viene digitata]
               * @param  {[string]} typeList [number    : il numero digitato viene completato aggiungendo l'unità di misura]
               * @param  {[string]} typeList [numberExt : come number, ma con anche initial e inherit come suggerimento]
               */
              if(typeList == 'number') {
                number = true;
              } else if(typeList == 'numberExt') {
                selectList.concat("initial", "inherit");
                number = true;
              }

              if(number) {
                propInput.addEvents({
                  'keyup' : function(units, length, event) {
                    var dataListElement = document.getElementById("autoCompleteValues_"+event.target.id);
                    if( event.key != "up" && event.key != "down" ) { // escludo le frecce in modo da poter selezionare il suggerimento
                      if(!isNaN(event.target.value)) { // se ho scritto un numero senza lettere aggiungo il suggerimento con le unità di misura
                        for(var i = 0; i < length; i++) { // non considero inherit e initial, quindi length - 2
                          dataListElement.childNodes[i].value = (event.target.value + units[i]);
                        }
                      }
                    }
                  }.bind(this, selectList, sizeList) // faccio il bind per passare le unità proprie dell'oggetto corrente
                });
              }

              propInput.addEvents({
                'blur' : function(event, updateHTML){
                  propertyChangeNotifier.bind(this)(this.value,updateHTML,_thisRef.isForm);
                  updateProperties(
                    this,this.propID,this.propertyType,_thisRef.isForm,this.value,
                    updateHTML,this.reconvertFunc,this.validFunc,_thisRef.mainObject,
                    this.alwaysUpdates
                  );
                  SetOnEditProp(false);
                },
                'focus' : function(selectList, event){
                  var dataList = document.getElementById("autoCompleteValues_"+event.target.id);
                  if(dataList.childElementCount == 0) {
                    for(var i = 0; i < selectList.length; i++) {
                      new Element( 'option', { 'value' : selectList[i] }).inject(dataList);
                    }
                  }
                }.bind(this, selectList)
              });
            break;
          }
        }
        $$((_thisRef.isForm?'.Form_property_item':'.property_item')).each(function(el/* ,index */){
          switch(el.propertyType){
            case "int":
            case "str":
            case "color":
            case "select":
              propertyChangeNotifier.bind(el)(el.value,false,_thisRef.isForm);
            break;
            case "checkbox":
              propertyChangeNotifier.bind(el)((el.checked)?"checked":"unchecked",false,_thisRef.isForm);
            break;
          }
        });
      }
      /* Fine renderTab */
    }

  //Creating tabs
    //var date1 = new Date();
    //var milliseconds1 = date1.getTime();
    var indexTabs = 0;
    var globalIndex = _thisRef.tabindex;
    for(var tabName in groups){
      var tabId=(this.isForm?'Form_':"")+tabName;
      var tab = new Element('div',{id:tabId+'_tab', 'class':'prop_tab'})
    // se definisco nome oggetto tab con "_", il render del testo li convertirà in spazi per leggibilita
      var tabNameText = Strtran(tabName,'_',' ');
      tab.store('originalName',tabName)
      tab.store('tabId',tabId)
      tab.set('text',tabNameText);
      tab.inject(pTabs);
      tab.opened = false;
      var tabContent = new Element('div',{id:tabId+'_tab_content'}); //.setStyles({
      tab.store('contentName',tabId+'_tab_content')
      tab.store('nTab',indexTabs);
      tabContent.inject(pContainer);
      tabContent.morphFx = new Fx.Morph(tabContent, {duration: 100,transition: Fx.Transitions.Quint,link:'cancel'});
      if(indexTabs ==0){
        tab.addClass("selected");
        ps_currTab=tabContent;
      }
      this.tabList.push(tab);
      tab.contentFx = new Fx.Morph(tab, {duration: 100,transition: Fx.Transitions.Quint,link:'cancel'});
      tab.addEvents({
        'click':function(){
          var content;
          var _itemsHTML = itemsHTML;
          if ( window.getItemsHTML ) {
            _itemsHTML = window.getItemsHTML(); //Report Editor
          }
          if(index!=null)
            _itemsHTML[index].curTab=Strtran(this.id,'_tab','');
          if(!ps_TabAnimation){
            ps_TabAnimation = true;
            var _this = this;
            this.addClass("selected");
            content = this.getParents(".pSheet").getElementById(this.id+'_content')[0];
            //if(content.id!=ps_currTab.id)
            //  content.setStyles({'display':'none'});// per evitare l'effetto
            _thisRef.renderTab(this);
            if(content.id!=ps_currTab.id){
              var prevTab =this.getParents(".pSheet").getElementById((Strtran(ps_currTab.id,'_content','')))[0];
              prevTab.removeClass("selected");
            }
            if(this.getParents(".pSheet").getElementById((_this.id))[0].retrieve("nTab")==0 || content.id!=ps_currTab.id){
              // content.morphFx.start({'opacity':0}).chain(function(){
              content.setStyles({'display':'block'});
              content.morphFx.start({'opacity':1}).chain(function(){
                var listfieldsets = content.getElementsByTagName("fieldset");
                if(listfieldsets && listfieldsets.length>0){
                  for(var kk=0; kk<listfieldsets.length; kk++){
                    var sectionlegend = listfieldsets[kk].getElementsByTagName("legend");
                    if(sectionlegend && sectionlegend.length>0) {
                      sectionlegend[0].style.display = 'none';
                      var out = false;
                      var divs = listfieldsets[kk].getElementsByClassName("properties_container");
                      for(var oo=0; !out && oo<divs.length; oo++){
                        if(!Empty(divs[oo].id) && divs[oo].style.display !='none') {
                          sectionlegend[0].style.display = 'block';
                          out = true;
                        }
                      }
                    }
                  }
                }

                if(_thisRef.afterRender)
                  _thisRef.afterRender(true);
              });
              if(content.id!=ps_currTab.id)
                ps_currTab.setStyles({'display':'none'});
              ps_currTab=content;
              // });
            }
            ps_TabAnimation = false;
          }
        }
      });
      indexTabs++;
    }
    var currPosition = {x:0,y:0};
    var reOpened = true;
    if(move){
      var resize_left = propDiv.makeResizable({
        handle: pSheetLeftResize,
        modifiers:{x:'width', y:false},
        limit: {x: [200,500]},
        onComplete: function(/*el*/){
          propDiv.morphEffect.start({'opacity':ps_props.opacity});
          if(toolbar)toolbar.setStyle('opacity',1);
          if(canvas)canvas.setStyle('opacity',1);
          var size = propDiv.getSize().x;
          ps_props.width = size;
          if( size > 300){
            propDiv.querySelector(".content").classList.add("side_tab");
          } else {
            propDiv.querySelector(".content").classList.remove("side_tab");
          }
            localStorage.setItem('zucchetti_'+tool+'editor_properties_'+_thisRef.divcontainer, JSON.stringify(ps_props))
        },
        onStart: function(){
          propDiv.setStyle('opacity',0.6);
          if(_thisRef.isColumn){
            if(toolbar)toolbar.setStyle('opacity',0.6);
            if(canvas)canvas.setStyle('opacity',0.6);
          }
        }
      });
      var oldLeft = 0;
      var resize_right = propDiv.makeResizable({
        handle: pSheetRightResize,
        modifiers:{x:'left', y:false},
       // invert: true,
        limit: {x: [window.getSize().x - propDiv.getStyle('max-width').toInt(), window.getSize().x - propDiv.getStyle('min-width').toInt()]},
        onComplete: function(el){
          var size = el.getSize().x.toInt() - ( el.getStyle('left').toInt() - oldLeft );
          if(size < el.getStyle('min-width')){

          }else if( size > el.getStyle('max-width')){

          }
          propDiv.setStyles({'width':size});
          propDiv.morphEffect.start({'opacity':ps_props.opacity });
          toolbar.setStyle('opacity',1);
          canvas.setStyle('opacity',1);
          ps_props.width = size;
          _thisRef.ResizeToolbar(el.getSize().x );
            localStorage.setItem('zucchetti_'+tool+'editor_properties_'+_thisRef.divcontainer, JSON.stringify(ps_props))
        },
        onDrag: function(el){
          var size = el.getSize().x.toInt() - ( el.getStyle('left').toInt() - oldLeft );
          propDiv.setStyles({'width':size});
          oldLeft = el.getStyle('left').toInt();
        },
        onStart: function(el){
          oldLeft = el.getStyle('left').toInt();
          propDiv.setStyles({'opacity':'0.6'});
          toolbar.setStyle('opacity',0.6);
          canvas.setStyle('opacity',0.6);
        }
      });
      var dragger = propDiv.makeDraggable({
        handle:pTopBar,
        style:true,
        modifiers:{x:'left', y:'top'},
        snap:0,
        onStart: function(el){
          el.setStyles({
            'cursor':'move'
          });
          if(_thisRef.pSheetOpened){
            el.setStyles({
              'opacity':'0.7'
            });
          }
        },
        onDrag: function(el) {
          //Snapping properties : aggiunta delle proprieta' di aggancio al bordo e creazione della colonna di properties
          if(_thisRef.canExpandToColumn){
            if(_thisRef.isColumn ){
              _thisRef.CollapseFromColumn.delay(0,_thisRef)
              reOpened = false;
            }else{
              if(el.offsetLeft < 20){
                el.setStyle('left',0);
              }
              else
                if(el.offsetLeft+el.offsetWidth > (window.getWidth()-30)){
                  this.stop('right');
                }
              else if(el.offsetTop < toolbar.getSize().y + 40){
                el.setStyle('top', toolbar.getSize().y);
              }
            }
          }else{
            pSheetLeftResize.setStyle('display','block');
            if(el.offsetLeft < 20){
              propDiv.setStyle('left',0)
            }if(el.offsetTop < (toolbar ? toolbar.getSize().y + 30 : 30 )){
              el.setStyle('top',(toolbar ? toolbar.getSize().y : 0 ));
            }if(el.offsetLeft+el.offsetWidth > (window.getWidth()-30)){
              pSheetLeftResize.setStyle('display','none');
              propDiv.setStyle('left',window.getWidth()-propDiv.getSize().x)
            }
          }
        },
        onComplete: function(el,exp){
          if(_thisRef.canExpandToColumn){
            if(exp != 'left' && exp != 'right'){
              _thisRef.isColumn = false;
              propDiv.store('isColumn',this.isColumn)
              ps_props.expandedToColumn = false;
            }else{
              _thisRef.ExpandToColumn.delay(0,_thisRef,exp);
            }
          }
          ps_props.left = el.getPosition().x;
          ps_props.top = el.getPosition().y;
          currPosition.x = 0;
          currPosition.y = 0;
          el.setStyles({
            'cursor':'default'
          });
          if(_thisRef.pSheetOpened){
            if(ps_props.left >= 0 && ps_props.left <= (document.getElementById('backcanvas').getPosition().x+document.getElementById('backcanvas').getSize().x) && ps_props.top >= 0 && ps_props.top <= (document.getElementById('backcanvas').getPosition().y+document.getElementById('backcanvas').getSize().y)){
              ps_props.opacity = 1;
              el.morphEffect.start({'opacity':1});
            }else{
              el.morphEffect.start({'opacity':1});
              ps_props.opacity = 1;
            }
          }
            localStorage.setItem('zucchetti_'+tool+'editor_properties_'+_thisRef.divcontainer, JSON.stringify(ps_props))
        }
      });
    }
    pSheet.contentFx = new Fx.Slide(pSheet, {
      duration: 200,
      transition: Fx.Transitions.Quint
    });
    propDiv.morphEffect = new Fx.Morph(propDiv, {duration: '200', transition: Fx.Transitions.Quint.easeOut});

    pOpenClose.addEvents({
      'click':function(){
        if(_thisRef.pSheetOpened && _thisRef.canExpandToColumn){ //CHIUSURA
          _thisRef.CollapseToRight();
        }
      }
    });
    //Seleziono l'ultimo tab selezionato
    var i;
    if(index!=null && _itemsHTML[index] && !Empty(_itemsHTML[index].curTab)){
      for(i=0;i<this.tabList.length;i++){
        if(Strtran(this.tabList[i].id,"_tab","").toLowerCase()==_itemsHTML[index].curTab.toLowerCase()){
          this.tabList[i].fireEvent('click');
        }
      }
    }else{
      for(i=0;i<this.tabList.length;i++){
        this.renderTab(this.tabList[i]);
        this.tabList[i].getParents(".pSheet").getElementById(this.tabList[i].id+'_content').setStyle("display","none");
      }
      var fireok = false;
      var c = 0;
      while(fireok==false && c<this.tabList.length){
        if(this.tabList[c].style.display!="none"){
          this.tabList[c].fireEvent('click');
          fireok = true;
        }
        c++;
      }
      //this.tabList[0].fireEvent('click');
    }
    this.updateProperties =function(Obj){ this.updatePropertiesFromPaint(Obj)};
    this.updatePropertiesFromPaint = function(Obj){
      var mainObj=(Obj?Obj:this.mainObject);
      var pList =(mainObj?mainObj.objClass.newProperties:this.propertiesList);
      for(var tabName in pList){
        var props = pList[tabName];
        for(var i = 0; i<props.length;i++){
          this.updateProp(mainObj,tabName,props[i]);
        }
      }
      this.UpdateListObj(this.divcontainer+'ctrlSelect');
    }
    this.updateProp = function(mainObj,tabName,prop){
      var propDomId;
      if(this.isForm)
        propDomId = '#Form_'+tabName+"_"+prop.propID;
      else
        propDomId = '#'+tabName+"_"+prop.propID;
      var propDomElement = document.getElementById(this.divcontainer).getElement(propDomId);
      if(!Empty(propDomElement)){
        var value = mainObj[prop.propID];
        if(prop.multiple && value){
          value=Strtran(value.toString().split(',')[(prop.multiple.multiple_index?prop.multiple.multiple_index:0)],"|",",");
        }
        propertyChangeNotifier.bind(propDomElement)(value, true, this.isForm);
        var convertFunc = prop.convertFunc
        if(convertFunc && propDomElement.tagName!="SELECT"){
          eval("value="+convertFunc+"(value)")
        }
        if (document.id(this.divcontainer).getElement(propDomId).value != value) {
          if (typeof value == 'string') {
              value = Strtran(value, '\r', '&#13;');
              value = Strtran(value, '\n', '&#10;');
          }
          document.id(this.divcontainer).getElement(propDomId).set('value', value);
        }

        if (typeof(value)=="boolean" || (value=='true'||value=='false')){

          if(typeof(document.getElementById(this.divcontainer).getElement(propDomId).checked)!='undefined'){
            var istrue = value+'';
            if(istrue=='true')
              document.getElementById(this.divcontainer).getElement(propDomId).set('checked',true);
            else
              document.getElementById(this.divcontainer).getElement(propDomId).set('checked',false);
          }
        }
      }
    }
    function updatePropMultiple(multiple_index,multiple_id,props,tabName,isForm,value,the_property,setOnBlurFunc){
      for(var i=0;i<props.length;i++){
        if(props[i].multiple && (props[i].multiple.type=='input' || props[i].multiple.type=='checkbox') && props[i].multiple.id==multiple_id){
          var objArr = isForm ? formProp : itemsHTML[index];
          var values=objArr[props[i].propID].toString().split(',');
          var main_values=objArr[multiple_id].toString().split(',');
          props[i].multiple.multiple_index = multiple_index;
          if(props[i].multiple.type=='checkbox'){
            document.getElementById((isForm?'Form_':'') + tabName+'_'+props[i].propID).checked=(values[multiple_index]!=null?Strtran(values[multiple_index],"|",",")=='true':'');
          }else{
            document.getElementById((isForm?'Form_':'') + tabName+'_'+props[i].propID).value=(values[multiple_index]!=null?Strtran(values[multiple_index],"|",","):'');
          }

          document.getElementById((isForm?'Form_':'') + tabName+'_'+props[i].propID+'_label').firstChild.innerText=props[i].name+' for '+main_values[multiple_index];
        }
      }
      if(setOnBlurFunc){
        if(typeof(setOnBlurFunc)=='string')
          window[setOnBlurFunc](value,the_property,multiple_index);
        else
          setOnBlurFunc.call(null,value,the_property,multiple_index);
      }
    }
    function editPropMultiple(v,property,multiple_index,isForm,input, validFunc){
      var objItems;
      if(isForm){
        objItems = formProp;
      }else{
        objItems = _itemsHTML[index];
      }
      var values=objItems[property.propID].toString().split(',');
      var r;
      if(validFunc){
        if(typeof(validFunc)=='string')
          r = window[validFunc](v,property,input,multiple_index);
        else
          //Si può scrivere una
          r=validFunc.call(null,v,property,input,multiple_index);
        if(r!=true){
          if(input.type=='checkbox'){
            input.checked=false;
          }else{
            input.value=values[multiple_index];
            setTimeout("document.getElementById('"+input.id+"').focus();",50);
            setTimeout("document.getElementById('"+input.id+"').select();",50);
          }
          return;
        }
      }
      values[multiple_index]=Strtran(v,",","|");
      objItems[property.propID]=values.join(',');
      if(property.setOnBlurFunc){
        if(typeof(property.setOnBlurFunc)=='string')
          window[property.setOnBlurFunc](v,property.propID,multiple_index);
        else
        property.setOnBlurFunc.call(null,v,property.propID,multiple_index);
      }
    }

        window.downMultipleProp=function(obj){
      var props=obj.props;
      var refId=obj.refId;
      var propID =obj.refPropId;
      var selectedIndex=document.getElementById(refId).selectedIndex;
      if( selectedIndex >= 0 && document.getElementById(refId).options.length > (selectedIndex+1) ) {
        var nIndex = selectedIndex + 1;
        for(var p=0;p<props.length;p++){
          if(props[p].multiple && props[p].multiple.id==propID){
            var valuesz=_itemsHTML[index][props[p].propID].split(',');
            var bz = valuesz[selectedIndex];
            valuesz[selectedIndex] = valuesz[nIndex];
            valuesz[nIndex] = bz;
            _itemsHTML[index][props[p].propID]= valuesz.join(',');
          }
        }
        _itemsHTML[index][propID+"vSelected"] = document.getElementById(refId).options[document.getElementById(refId).selectedIndex].value;
        Properties(true);
        updatePropMultiple(nIndex,propID,props,obj.tabName);
      }
    }
    window.upMultipleProp=function(obj){
      var props=obj.props;
      var refId=obj.refId;
      var propID =obj.refPropId;
      var selectedIndex=document.getElementById(refId).selectedIndex;
      if( selectedIndex > 0 ) {
        var nIndex = selectedIndex - 1;
        for(var p=0;p<props.length;p++){
          if(props[p].multiple   && props[p].multiple.id==propID){
            var valuesz=_itemsHTML[index][props[p].propID].split(',');
            var bz = valuesz[selectedIndex];
            valuesz[selectedIndex] = valuesz[nIndex];
            valuesz[nIndex] = bz;
            _itemsHTML[index][props[p].propID]= valuesz.join(',');
          }
        }
        _itemsHTML[index][propID+"vSelected"] = document.getElementById(refId).options[document.getElementById(refId).selectedIndex].value;
        Properties(true);
        updatePropMultiple(nIndex,propID,props,obj.tabName);
      }
    }
    window.newMultipleProp=function(obj){
      var props=obj.props;
      var propID =obj.refPropId;
      var tabName = obj.tabName;
      var container = document.querySelector("#" + obj.refId).parentNode
      if (document.getElementById(obj.refId + '_add')) return;
      var main_prop = obj.props.filter(function (e) {
        return e.propID == propID;
      })[0];
      var inputType = "input"
      switch (main_prop.type) {
        case "str":
          inputType = 'input'
        break;
        case "select":
          inputType = 'select'
        break;
      }
      var propInput_add = new Element(inputType, {
        'id': obj.refId + '_add',
        'name': obj.refId + '_add',
        'class': 'properties_' + inputType +" property_item",
      });
      if (main_prop.multiple.fillFnc) {
        var func = main_prop.multiple.fillFnc.substring(0, main_prop.multiple.fillFnc.indexOf('('));
        var pars = main_prop.multiple.fillFnc.substring(main_prop.multiple.fillFnc.indexOf('{'),main_prop.multiple.fillFnc.indexOf('}')+1) ;
        var parsObj = !Empty(pars) ? eval("("+ pars +")") : {};

        parsObj['index']=index;
        parsObj['refId']=obj.refId;
        parsObj['refPropId']=obj.refPropId;
        // parsObj['button']=this;
        // window[main_prop.multiple.fillFnc].call().forEach(function (option) {
        var values = eval(func).call(window, parsObj);
        ['-'].concat(values).forEach(function (option) {
          var opt = document.createElement('option');
          opt.value = option;
          opt.text = option;
          propInput_add.appendChild(opt);
        });
      }
      propInput_add.setStyles({ 'position': 'absolute', 'width': 'calc(100% - 10px)', 'left': '0px' });
      container.style.position = "relative";
      propInput_add.inject(container);
      propInput_add.addEvents({
        'focus': function(){SetOnEditProp(true);},
        'blur':function(){
          if(Empty(this.value) || this.value == '-') {
            propInput_add.destroy();
            SetOnEditProp(false);
            return;
          }
          //Imposto una nuova voce su tutte le proprieta'� multiple
          var main_values= [];
          if(!Empty(_itemsHTML[index][propID])){
            main_values = _itemsHTML[index][propID].split(',');
          }
          for(var p=0;p<props.length;p++){
            if(props[p].multiple && props[p].multiple.id==propID){
              var values=_itemsHTML[index][props[p].propID].split(',');
              var delta = main_values.length-values.length;
              if( delta > 0){
                for( var vv=0; vv<delta; vv++)
                  values.push( '' );
              } else if( delta < 0){
                values.splice(delta,Math.abs(delta));
              }
              if(props[p].propID==propID) { //La proprieta'� main con il combo
                main_values.push(this.value);
                _itemsHTML[index][propID]=main_values.join(',');
                var opt=document.createElement('option');
                opt.value=this.value;
                opt.text=this.value;
                document.getElementById(tabName+'_'+propID).appendChild(opt);
                document.getElementById(tabName+'_'+propID).value=this.value;
              }else{
                _itemsHTML[index][props[p].propID]= values.join(',');
              }
            }
          }
          updatePropMultiple(main_values.length-1,propID,props,tabName);
          SetOnEditProp(false);
          propInput_add.destroy();
        },
        'keydown':function(event){
          if (event.key == 'enter') this.blur();
          if (event.key == 'esc') {
            propInput_add.destroy();
            SetOnEditProp(false);
          }
        },
        'change': function() {
          this.blur();
        }
      });
      propInput_add.focus();
    }
    window.editMultipleProp=function(obj){
      var refId=obj.refId;
      var propID =obj.refPropId;
      if(document.getElementById(obj.refId+'_add')) return;
      var propInput_add = new Element('input',{'id':obj.refId+'_add','name':obj.refId+'_add','class':'properties_input'});
      propInput_add.setStyles({'position':'absolute', 'width':'60%','left':'13px'});
      propInput_add.inject(document.querySelector("#"+obj.refId).parentNode);
      propInput_add.addEvents({
        'focus': function(){SetOnEditProp(true);},
        'blur':function(){
          if(Empty(this.value)) {
            propInput_add.destroy();
            SetOnEditProp(false);
            return;
          }
          //modifico la voce della combo
          var main_values=_itemsHTML[index][propID].split(',');
          main_values[document.getElementById(refId).selectedIndex]=this.value;
          _itemsHTML[index][propID]=main_values.join(',');
          //ridisegno la combo
          Properties(true);
          SetOnEditProp(false);
          propInput_add.destroy();
        },
        'keydown':function(event){
          if (event.key == 'enter') this.blur();
          if (event.key == 'esc') {
            propInput_add.destroy();
            SetOnEditProp(false);
          }
        }
      });
      propInput_add.focus();
    }
    window.delMultipleProp=function(obj,notConf,isForm){
      if(notConf || confirm('Are you sure to delete this ?')){
        var props=obj.props;
        var refId=obj.refId;
        var propID =obj.refPropId;
        var propObj =(isForm?formProp:_itemsHTML[index]);
        var selectedIndex=document.getElementById(refId).selectedIndex;
        for(var p=0;p<props.length;p++){
          if(props[p].multiple   && props[p].multiple.id==propID){
            var values=propObj[props[p].propID].split(',');
            //var main_values=_itemsHTML[index][propID].split(',');
            //values.splice(selectedIndex,1);
            LibJavascript.Array.remove(values,selectedIndex);
            //main_values.splice(selectedIndex,1);
            propObj[props[p].propID]= values.join(',');
          }
        }
        Properties(true);
      }
    }

    this.ExpandToColumn = function(position){// FUNZIONE CHE ESPANDE LE PROPERTIES NELLA COLONNA DI PROPERTIES
      reOpened = false;
      this.isColumn = true;
      propDiv.store('isColumn',this.isColumn)
      this.columnExpand = position;
      propDiv.store('ExpandPosition',this.columnExpand)
      var size = propDiv.getSize().x;
      if(size == 0 ){ //Apertura a seguito di una re_openColumn
        size = propDiv.retrieve('propDivDimensionAfterCollapse') ? propDiv.retrieve('propDivDimensionAfterCollapse') : (ps_props.width ? ps_props.width : '250px')
      }
      propDiv.setStyles({
        'top':'0',
        'width':size
      });
      this.ResizeToolbar(size)
      propDiv.addClass('expandedToColumn');
      if(position == 'left' ){
        propDiv.setStyles({'left':0});
        this.ResizeCanvas(size)
        pSheetLeftResize.setStyles({'display':'block','right':'-10px'});
        pSheetLeftResize.addClass('propertySheetResize_Column');
        pSheetRightResize.setStyles({display:'none'})
        // pOpenClose.setStyles({'left':'auto','right': '5px','display':'block'});
        resize_right.detach();
        resize_left.attach();
      }else{ //position == 'right'
        pSheetLeftResize.setStyles({'display':'none'})
        //TOLGO MOMENTANEAMENTE LA SCROLLBAR LATERALE PER EVITARE CALCOLI ERRATI CON IE
        document.body.style.overflow = 'hidden';
        propDiv.setStyles({'left':window.getWidth()- size})
        document.body.style.overflow = '';
        pSheetRightResize.setStyles({'display':'block','left':'-10px'})
        pSheetRightResize.addClass('propertySheetResize_Column')
        // pOpenClose.setStyles({'left':'5px','right':'auto','display':'block'})
        resize_right.attach();
        resize_left.detach();
      }
      $$('.propertySheetResize_Column_Arrow').each(function(el){el.setStyles({'display':'block','background-position':'center left'})});
      pSheetWrapper.addClass('propertySheet_Column');
      ps_props.expandedToColumn = true;
      ps_props.columnSide = position ;
        localStorage.setItem('zucchetti_'+tool+'editor_properties_'+this.divcontainer, JSON.stringify(ps_props));
    }
    this.CollapseToRight=function(){
      _thisRef.pSheetOpened = false;
      propDiv.store('isOpened',_thisRef.pSheetOpened)
      if(!_thisRef.isColumn){
        _thisRef.ExpandToColumn('right');
      }
      propDiv.store('propDivDimensionAfterCollapse',propDiv.getSize().x)
      propDiv.morphEffect.start({
        'width':0,
        'max-width':0,
        'min-width':0
      }).chain(function(){
        if(_thisRef.columnExpand == 'right')
          propDiv.morphEffect.start({'left':window.getSize().x})
      })
      _thisRef.ResizeToolbar(10)
      if(_thisRef.columnExpand == 'left'){
        _thisRef.ResizeCanvas(10)
        $$('.propertySheetResize_Column_Arrow').setStyles({'display':'block','background-position':'-17px center'});
      }else
        $$('.propertySheetResize_Column_Arrow').setStyles({'display':'block','background-position':'-10px center'});
      pSheetWrapper.setStyles({opacity:0,display:'none'})
      $$('.propertySheetResize_Column_Arrow').setStyles({'cursor':'pointer'});
      pOpenClose.hide()
      ps_props.opened = false;
        localStorage.setItem('zucchetti_'+tool+'editor_properties_'+_thisRef.divcontainer, JSON.stringify(ps_props));
    }
    this.CollapseFromColumn = function(){
      if(!reOpened){
        this.columnExpand = 'none';
        propDiv.setStyles({
          // 'height': 'auto',
          // 'border-right':'2px solid #898989',
          // 'border-bottom':'2px solid #898989'
          // 'right':'auto',
          //'left': ''
        });
        //Sposto il propertySheetResize
        pSheetLeftResize.setStyles({'display':'block','right':'-4px'})
        pSheetLeftResize.removeClass('propertySheetResize_Column');
        pSheetRightResize.setStyles({display:'none'})
        pSheetRightResize.removeClass('propertySheetResize_Column')
        $$('.propertySheetResize_Column_Arrow').each(function(el){el.setStyles({'display':'none'})});
        resize_right.detach();
        dragger.attach();
        resize_left.attach();
        //SPOSTAMENTO DELLA TOLLBAR E DEL CANVAS DEL DISEGNATORE
        //pOpenClose.setStyles({'left':'5px','right':'auto'});
        pSheetWrapper.removeClass('propertySheet_Column')
        propDiv.removeClass('expandedToColumn');
      }
    }
    this.ResizeToolbar = function (/* _size */){
      // if(toolbar && this.canExpandToColumn){
        // if(this.isColumn){
          // var size = _size + pSheetRightResize.getSize().x;
          // if(this.columnExpand == 'left'){
            // toolbar.getChildren('#objList')[0].setStyle('margin-left',_size + 10);
          // }else if(this.columnExpand == 'right'){
            // toolbar.getChildren('#objList')[0].setStyle('margin-right',_size + 10);
          // }
        // }
        // else
            // toolbar.getChildren('#objList')[0].setStyles({'margin-right':0,'margin-left':10});
      // }
    }
    this.ResizeCanvas = function(_size){
      if(canvas && this.canExpandToColumn){
        if(this.isColumn && this.columnExpand == 'left'){
          canvas.setStyles({'left':_size+10,width:window.getWidth()-(_size +10)});
        }else
          canvas.setStyles({'left':0,width:window.getWidth()});
      }
      if(typeof(moveVLine)!='undefined') moveVLine();
    }
    if(this.isColumn )
      this.ExpandToColumn(this.columnExpand);
    //Riempie la combobox degli items
    _thisRef.UpdateListObj(_thisRef.divcontainer+'ctrlSelect');
    //GESTIONE DELL'EVENTO DI RESIZE NEL CASO DI PROPERTIES APERTE A COLONNA SUL LATO DESTRO
    this.resizeAfterWResize = function (){
      if( _thisRef.canExpandToColumn && _thisRef.isColumn && _thisRef.columnExpand == 'right'){
        if(_thisRef.pSheetOpened)
          _thisRef.ExpandToColumn.delay(100,_thisRef,'right');
        else
          _thisRef.CollapseToRight.delay(100,_thisRef);
      }
    }
    _thisRef.timerResize=null;
    window.addEvents({
      'resize': function (){
        if(_thisRef.timerResize) clearTimeout(_thisRef.timerResize);
        _thisRef.timerResize=_thisRef.resizeAfterWResize.delay(200);
      }
    });
  }
