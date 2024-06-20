/* exported
  doLoad Help reset newCurrentObj isExpr AfterSave toggleManageFilters
  deleteFilter confirmManageFilters closeManageFilters
  EditField DeleteField SetFieldDetail GetCurrentName
  GetResourceName selectForm GetRequestParams ManageQueryChange
  AfterQueryChange removeItem ListObj insertImage editPortlet selectPortlet
  SetChartWizardConfiguration checkChartDef checkDataSourceLevel SetCacheLevel
  */
  /* global
  SetSmartChartdef getChartDefType
  */
//var folder_path=''
var newPropObj = null;
//var nItem=0;
var notimooManager;
var baseCustomization = {custom:false, user: 0, group:0, user_group:"" };
var nFilter=0;
var mySortables = new Sortables('#actionList,#linkedConfList');
var progrAct = 0, progrLCf = 0;
var deleteMap = [];

function doLoad(/*e*/) {
  document.getElementById('backcanvas').setStyle('display', 'block');
  windowResize();
  FormProperties();
  document.getElementById('loading').setStyle('display', 'none');
  notimooManager = new Notimoo({});
  create_gadget_pane();
  window.addEvent("keydown", function (e) {
    if (e.control && e.key == "s") { //CTRL-S
      if (document.activeElement.tagName == 'INPUT') {
        var activeE = document.activeElement;
        activeE.blur();
        activeE.focus();
      }
      e.stop();
      if (parent.saveTool) parent.saveTool();
    }
  });
}

function Help(the_property) { //wip
  var i;
  var prop = '';
  if (typeof(anchorToFeature) != 'undefined') {
    if (typeof(the_property) != 'undefined') {
      prop += "vzoomeditor_" + the_property.toLowerCase();
    }
    if (prop in anchorToFeature && prop != '') {
      i = anchorToFeature[prop];
    }
    else if (index != null && "vzoomeditor_" + itemsHTML[index].type.toLowerCase() in anchorToFeature) {
      i = anchorToFeature["vzoomeditor_" + itemsHTML[index].type.toLowerCase()];
    }
    else {
      i = anchorToFeature["vzoomeditor"];
    }
    windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?' + URLenc(i + (prop != "" ? '||' + prop : "")), '', 'toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
  }
}

function reset(){
  if(m_bUpdated){
    if(confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
      FormProperties();
    }
  }
}

function newCurrentObj(name, type, parms){  //wip
  window.location.href=getOpenUrl(name,type,parms)
}

function openVPV(){
  if(m_bUpdated){
    if(!confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
      return false;
    }
  }
  var width = 800;
  var height = 600;
  var url = "../portalstudio/open.jsp?tool=visualpivot&onetool=true";
  url += "&SPModalLayerId=vpvSPModalLayer";
  var left = (screen.width)?(screen.width-width)/2:100;
  var top = (screen.height)?(screen.height-height-(height/4))/2:100;
  openSPModalLayer(url,top,left,width,height,true,1,false,false);
  FormProperties();
}

function isExpr(txt){//wip
  return txt.match(/(function|var|image|javascript|checkbox|html|eval):/);
}

function AddFieldToBox(type, mainobj, fieldlist, fields, beforeOf) {
  unSelectItem();
  var arrayToPut = [],
    f_obj, dobj;
    for (var i = 0; i < fields.length; i++) {

    f_obj = {
      field: fields[i].alias,
      title: fields[i].desc,
      f_type: fields[i].type,
      type: type,
      descrs: fields[i].desc
    };
      if( deleteMap[fields[i].alias] != undefined ) {
        dobj = deleteMap[fields[i].alias];
        f_obj.keys = dobj.keys;
        f_obj.pictures = dobj.pictures;
        f_obj.sorts = dobj.sorts;
        f_obj.sortsfields = dobj.sortsfields;
        f_obj.condformats = dobj.condformats;
        delete deleteMap[fields[i].field];
      }
    arrayToPut.push(JSON.parse(JSON.encode(LibJavascript.JSONUtils.adjust(f_obj, getPropsSchema())), true));
  }

  var index = mainobj.length;
  if (beforeOf) {
    mainobj.some(function (itm, i) {
      if (itm.id == beforeOf) {
        index = i;
        return true;
      }
      return false;
    });
  }
  mainobj.splice.apply(mainobj, [index, 0].concat(arrayToPut));
  fieldlist.AppendItems(arrayToPut, beforeOf);
  ManageFlagImages();
}

function AddColumns(fields,beforeOf) { //beforeOf se non passato si aggiunge in coda
  AddFieldToBox('column',columnsObj,columnsList,fields,beforeOf);
}
function AddRow(fields,beforeOf) { //beforeOf se non passato si aggiunge in coda
  AddFieldToBox('row',rowsObj,rowsList,fields,beforeOf);
}
function AddMeasure(fields,beforeOf){
  var i, fz = [];
  for( i=0; i<fields.length; i++) {
    if( fields[i].type == 'N')
      fz.push(fields[i]);
  }
  if( fz.length != fields.length ) alert('Only numeric fields for measures!')
  AddFieldToBox('measure',measuresObj,measuresList,fz,beforeOf);
}
function AddOMeasure(fields,beforeOf){
  var i, fz = [];
  for( i=0; i<fields.length; i++) {
    if( fields[i].type == 'N')
      fz.push(fields[i]);
  }
  if( fz.length != fields.length ) alert('Only numeric fields for measures!')
  AddFieldToBox('omeasure',omeasuresObj,omeasuresList,fz,beforeOf);
}
function AddODimension(fields,beforeOf){
  AddFieldToBox('odimension',odimensionsObj,odimensionsList,fields,beforeOf);
}

function saveAs() {//wip
  var customizationParms = "custom="+formProp.custom;
  if (formProp.user_group=='User')
    customizationParms +=  "&filter=_" + formProp.user;
  else if (formProp.user_group=='Group')
    customizationParms +=  "&filter=_g" + formProp.group;
  OpenWindow('../portalstudio/saveas.jsp?tool=visualpivot&'+customizationParms, 580,600);
}

function IsModifiedCustomization() {
  //console.log("BASE", baseCustomization.user, baseCustomization.group, baseCustomization.custom, baseCustomization.name, baseCustomization.user_group)
  //console.log("CURRENT", formProp.user, formProp.group, formProp.custom, configname, formProp.user_group)
  return formProp.user != baseCustomization.user ||
    formProp.group != baseCustomization.group ||
    formProp.custom != baseCustomization.custom ||
    configname != baseCustomization.name ||
    formProp.user_group != baseCustomization.user_group;
}
function CheckCustomization() {//wip
  var conf = true;
  if ( IsModifiedCustomization() ) {
    // cambiata la parte custom, quindi si sta andando a salvare un nuovo file!! Bisogna chiedere conferma sul salvataggio
    var filter='';
    if (formProp.user_group=='User')
      filter = "_" + formProp.user;
    else if (formProp.user_group=='Group')
      filter = "_g" + formProp.group;

    var url = new JSURL('../servlet/JSPReader?type=visualpivot&filter='+filter+"&custom="+formProp.custom+"&name="+configname+"&check=true",true);
    var output=url.Response();
    if(output=="found"){
      if(!confirm("You have modified customize options.\nThis custom file already exist, overwrite?"))
        conf = false;
    }
  }
  return conf;
}
var AfterSave
function save(then) {//wip
  if (!CheckCustomization()) return;
  if (then=='close') AfterSave='close';
  else if( !Empty(then)){ //then e' un oggetto che contiene una funzione che deve essere eseguita dopo il salvataggio
   AfterSave = then;
  }
  if(parent) parent.is_Saving=true;
  if(!Empty(configname)){
    notimooManager.show({
      title:'Notification message',
      message: 'saving vpv...',
      sticky : true,
      width:200,
      height:40
    });
    save2.delay(100);
  } else {
   saveAs();
  }
}

var globalProps = [
  /* tab generic */
  'description', 'caption', 'query', 'allowedqueries', 'cachelevel', 'cachelevel2', 'vdmfile', 'vdmWidth', 'vdmHeight', 'portletsrc', 'linkparms', 'measuresoncolumn', 'measurestitle', 'hidemeasures',
  /* tab view_options */
  'viewmode', 'header', 'css', 'css_class',
  'canFilter', 'hideFiltersBtn', 'openVdmBeforeQuery', 'applyAdvancedFilter', 'disablePresetParam',
  'exportPivot', 'exportTable',
  /* tab pivot_options */
  'uiDragDrop', 'uiStartOpen', 'othDimMeas', 'rowsort', 'columnsort', 'subtotaltext', 'rowsubtotal', 'columnsubtotal', 'bigtotaltext', 'rowbigtotal', 'columnbigtotal',
  /* tab chart_options */
  'chartDef',
  /*'label_field', 'sfield', 'sfieldlabel', 'value_fields', 'label_series', 'labelKey_field', 'mapSeries', 'manualScale',
  'x_field', 'y_field', 'z_field', 'xyz_series_field', 'xKey_field',
  'min_field', 'max_field',
  'geo_0_field', 'geo_1_field', 'geo_value_field', 'geo_dom_field', 'geo_view', 'geo_level', 'geo_level_2', 'geo_level_3', 'geo_view_select', 'geo_onlydata',
  'markers_desc', 'markers_lat', 'markers_lng', 'markers_key', 'markers_type',
  'fieldpath', 'fieldvalue', 'keyfieldpath',
  'depfield_1', 'depfield_2', 'depvalue', 'depclass', 'depfield_1label', 'depfield_2label', 'depfield_1class', 'depfield_2class',
  'class_label', 'class_key', 'class_xfrom', 'class_xto', 'class_yfrom', 'class_yto', 'class_cat', 'class_xval', 'class_yval', 'class_zval', 'class_keycat',
  'voro_class', 'voro_cat', 'voro_coords',
  'val_field',*/
  /* tab print_options */
  'PrintMode', 'ReportName', 'print_size', 'print_outputf', 'print_max', 'print_option', 'print_title', 'print_totals', 'print_grep', 'print_hideexport', 'print_hidesettings',
  /* customization */
  'custom', 'user_group', 'group', 'user'
];

function save2() {//wip
	var output, i; // col;
  var customizationParms = "&Custom="+( formProp.custom ? formProp.custom : 'false');
  if (formProp.user_group=='User')
    customizationParms +=  "&NewUser=" + formProp.user;
  else if (formProp.user_group=='Group')
    customizationParms +=  "&NewGroup=" + formProp.group;

  var props = ['field', 'descrs', 'keys', 'pictures', 'sorts', 'sortsfields', 'title', 'f_type'],
  mprops = ['field', 'descrs', 'pictures', 'title', 'condformats', 'f_type']


  var confToSend = {};
  confToSend.configuration = LibJavascript.JSONUtils.purge(formProp, globalProps, true);
  confToSend.cols = LibJavascript.JSONUtils.purge(columnsObj, props);
  confToSend.rows = LibJavascript.JSONUtils.purge(rowsObj, props);
  confToSend.odimensions = LibJavascript.JSONUtils.purge(odimensionsObj, props);
  confToSend.measures = LibJavascript.JSONUtils.purge(measuresObj, mprops);
  confToSend.omeasures = LibJavascript.JSONUtils.purge(omeasuresObj, mprops);
  confToSend.configuration.name = configname;

  //console.log(confToSend)

  confToSend.arrayFilters = [];
  for (i=0; i<filtersObj.length; i++){
    var fieldName=filtersObj[i].field;
    var f={};
    f[fieldName+'_visible']=true;
    f[fieldName+'_fixed']=false;
    f[fieldName+'_op']=filtersObj[i].operator;
    f[fieldName]=filtersObj[i].expression;
    confToSend.arrayFilters.push(f);
  }

  var actions=document.getElementById("actionList").getChildren();
  var idx=-1;
  confToSend.actions = [];
  for (i=0; i<actions.length; i++){
    itemsHTML.some(function(arr_el,j) {
      if (arr_el.element==actions[i]) {
        idx=j;
        return true;
      } else {
        return false;
      }
    });
    confToSend.actions.push({
      actionName:itemsHTML[idx].actionName,
      title:itemsHTML[idx].title,
      tooltip:itemsHTML[idx].tooltip,
      url:itemsHTML[idx].url,
      image:itemsHTML[idx].image,
      visibility:itemsHTML[idx].visibility,
      important:itemsHTML[idx].important,
      hideWhen:itemsHTML[idx].hideWhen,
      image_settings:itemsHTML[idx].image_settings,
      font_name:itemsHTML[idx].font_name,
      font_image:itemsHTML[idx].font_image,
      font_size:itemsHTML[idx].font_size,
      font_color:itemsHTML[idx].font_color,
      bg_color:itemsHTML[idx].bg_color,
      entityType:itemsHTML[idx].entityType,
      parameters:itemsHTML[idx].parameters,
      memCursParam:itemsHTML[idx].memCursParam,
      checkAllParam:itemsHTML[idx].checkAllParam,
      queryFilterParam:itemsHTML[idx].queryFilterParam,
      sendMemCurs:itemsHTML[idx].sendMemCurs,
      parameter:itemsHTML[idx].parameter,
      showInMenu:itemsHTML[idx].showInMenu,
      popup_width:itemsHTML[idx].popup_width,
      popup_height:itemsHTML[idx].popup_height,
      doQryAfterRoutine:itemsHTML[idx].doQryAfterRoutine,
      progressBar:itemsHTML[idx].progressBar,
      progressBarPortlet:itemsHTML[idx].progressBarPortlet,
      target:itemsHTML[idx].target,
      popup:itemsHTML[idx].popup,
      popup_style:itemsHTML[idx].popup_style,
      popup_maximized:itemsHTML[idx].popup_maximized,
      confirmMessage:itemsHTML[idx].confirmMessage
    })
  }

  var linkedConf=document.getElementById("linkedConfList").getChildren();
confToSend.linkedConfs = [];
  for (i=0; i<linkedConf.length; i++){
    itemsHTML.some(function(arr_el,j) {
      if (arr_el.element==linkedConf[i]) {
        idx=j;
        return true;
      } else {
        return false;
      }
    });
    confToSend.linkedConfs.push({
      linkedConfName:itemsHTML[idx].linkedConfName,
      title:itemsHTML[idx].title,
      configname:itemsHTML[idx].configname,
      configtype:itemsHTML[idx].configtype,
      imagetype:itemsHTML[idx].imagetype,
      ontoolbar:itemsHTML[idx].ontoolbar,
      ontabs:itemsHTML[idx].ontabs,
      imagetoolbar:itemsHTML[idx].imagetoolbar,
      image_settings:itemsHTML[idx].image_settings,
      font_name:itemsHTML[idx].font_name,
      font_image:itemsHTML[idx].font_image,
      font_size:itemsHTML[idx].font_size,
      font_color:itemsHTML[idx].font_color
    })
  }

  var url = new JSURL("../servlet/SPVPVProxy?m_cAction=save"+
    "&ConfigName="+configname+
    "&vqr="+URLenc(formProp.query)+
    "&obj="+ URLenc(JSON.encode(confToSend)) +
    "&offlinemode="+URLenc(offlinemode) + customizationParms+
    "&fromFullEditor=true" +
    "&m_cID=" + cmdhash
    ,true);
  output=url.Response();
  try {
    //output = JSON.parse(output);
	if( !Empty(output) ) {
    output = JSON.parse(output);
  }
	else {
		output = {};
		output.OK= true;
	}
  }
  catch (e) {
    output.ERROR=true;
    output.MESSAGE='Error on save';
  }
  notimooManager.close(notimooManager.elements[0]);
  if (output.ERROR) {
    notimooManager.close(notimooManager.elements[0]);
    alert(output.MESSAGE||'Error on save');
  }
  else if (output.OK) {
    notimooManager.show({
       title:'Notification message',
       message: 'vpv saved!',
       visibleTime: 2000,
       width:200
    });
    if(parent) parent.is_Saving=false;
    m_bUpdated=false;

    if(AfterSave=="close")
      window.parent.closeCurrentObj();
    else {
      if(window.top.GetOpener() && window.top.GetOpener().ReportPivotConfiguration)
        window.top.GetOpener().ReportPivotConfiguration();
      if (IsModifiedCustomization()) {
          var newconfigname = configname;
          if (formProp.user_group=='User')
            newconfigname +=  "_" + formProp.user;
          else if (formProp.user_group=='Group')
            newconfigname +=  "_g" + formProp.group;

          if (parent.changeName)
            parent.changeName(newconfigname, { custom: formProp.custom }, Strtran(window.frameElement.id, 'portalstudioframe', ''))

          if (parent.AddRecentOpen)
            parent.AddRecentOpen("visualpivot", newconfigname, { custom: formProp.custom })

          if (window.history.pushState) {
            window.history.pushState(1, newconfigname + " - VisualPivot", "editor.jsp?ConfigName="+newconfigname+(formProp.custom=="true"?"&custom="+formProp.custom:"")+"&offlinemode="+URLenc(offlinemode));
            //reset delle variabili
            baseCustomization.user = formProp.user;
            baseCustomization.group = formProp.group;
            baseCustomization.custom = formProp.custom;
            baseCustomization.name = formProp.name
            baseCustomization.user_group = formProp.user_group;
          } else
            window.location.href=SPWebRootURL+"/visualpivot/editor.jsp?ConfigName="+newconfigname+(formProp.custom=="true"?"&custom="+formProp.custom:"")+"&offlinemode="+URLenc(offlinemode);
      }
      if(!Empty(AfterSave)){
        AfterSave();
        AfterSave=null;
      }
    }
  }
  else {
    notimooManager.close(notimooManager.elements[0]);
    alert("Save routine failed.")
  }
}

function selectItem(node){//wip
  /*Find node in itemsHTML*/
  index = -1;
  for(var i=0; i<itemsHTML.length; i++){ //aggiorna l'index con l'item selezionato
    if(node.data && itemsHTML[i].id == node.data.id){
      index = i;
      break;
    }
  }
  if(index > -1){
    // $('propertiesTitleTxt').set('html',"&nbsp;"+node.tree.root.name.capitalize()+" properties")
    var it = itemsHTML[index]
    // if(!node.property.editable){
      var tab, p;
      for(tab in it.objClass.newProperties){
        p = it.objClass.newProperties[tab]
        for(var j=0; j< p.length; j++){
          p[j].noteditable = !node.tree.options.propertiesEditable;
        }
      }
    // }
    if(newPropObj && last_index != null && last_index==index){
      newPropObj.updatePropertiesFromPaint(it);
      // if(showProperties) showProperties('properties');
    }else{
      newPropObj = new propertiesObj({m_obj:it,canExpandToColumn:false,tabindex:100,divcontainer:'properties',moveDiv:false});
      // newPropObj.re_openColumn()
      last_index=index;
      document.getElementById('properties').show()
    }
    resizeGadgetsPane();
  }
}

function windowResize(){
  var ctrl = document.getElementById('backcanvas');
  if(document.body.clientWidth -$('gadgets_pane').offsetWidth >80)
    ctrl.style.width = (document.body.clientWidth - (($('gadgets_pane').opened ? $('gadgets_pane').offsetWidth : 0) + 40))+"px"; //margine di 30
  ctrl.style.height='auto'
}

window.addEvent('resize', windowResize);

var columnsObj=[], rowsObj = [], measuresObj = [], filtersObj = [], odimensionsObj = [], omeasuresObj = [];
var columnsList, rowsList, measuresList, odimensionsList, omeasuresList, vqrlist;

function getPropsSchema(){
  function mandatoryPropertyError(){
    throw new Error("Mandatory property error");
  }
  return {
        id: function(){ return LibJavascript.AlfaKeyGen(10); },
        field: mandatoryPropertyError,
        type: "",
        descrs: "",
        keys: "",
        pictures: "",
        sorts: "",
        sortsfields: "",
        condformats: "",
        position: "",
        col_title: "",
        hidetitle: "",
        f_type: ""
      };
}

var vqrfields, //[alias , desc, column]
    selectedItems=[],
    // eslint-disable-next-line no-unused-vars
    selectedColumns=[], selectedMeasures=[], selectedOMeasures=[], selectedRows=[], selectedODimensions=[];

function ReturnUsedFields() {
  var result = {cols:{}, rows:{},measures:{},omeasures:{}, odimensions:{}}, i;
  for (i=0; i<columnsObj.length;i++) {
    result.cols[columnsObj[i].field]='';
  }
  for (i=0;i<rowsObj.length; i++) {
    result.rows[rowsObj[i].field]='';
  }
  for (i=0;i<measuresObj.length; i++) {
    result.measures[measuresObj[i].field]='';
  }
  for (i=0;i<omeasuresObj.length; i++) {
    result.omeasures[omeasuresObj[i].field]='';
  }
  for (i=0;i<odimensionsObj.length; i++) {
    result.odimensions[odimensionsObj[i].field]='';
  }
  return result;
}

function ManageFlagImages() {
  var flds = ReturnUsedFields();
  var keysr = [], keysc = [], keyso = [];
  var i, o;
  for( i=0; i<columnsObj.length; i++) {
    o = columnsObj[i];
    if( !Empty(o.keys) ) keysc.push(o.keys)
  }
  for( i=0; i<rowsObj.length; i++) {
    o = rowsObj[i];
    if( !Empty(o.keys) ) keysr.push(o.keys)
  }
  for( i=0; i<odimensionsObj.length; i++) {
    o = odimensionsObj[i];
    if( !Empty(o.keys) ) keyso.push(o.keys)
  }
  document.getElementById("list").getChildren().each(function(el) {
    var myname = el.get('name');
    var img = el.getElementById(el.get('id')+'_'+'flag');
    if (myname in flds.cols) {
      img.set('title','Field in columns');
      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    }
    else if (myname in flds.rows) {
      img.set('title','Field in rows');
      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    } else if (myname in flds.measures) {
      img.set('title','Field in measures');
      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    } else if (myname in flds.omeasures) {
      img.set('title','Field in others measures');
      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    }else if (myname in flds.odimensions) {
      img.set('title','Field in others dimensions');

      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    } else if (keysr.indexOf(myname) >= 0) {
      img.set('title','Field as key in rows');
      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    }
    else if (keysc.indexOf(myname) >= 0) {
      img.set('title','Field as key in columns');
      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    }
    else if (keyso.indexOf(myname) >= 0) {
      img.set('title','Field as key in others dimensions');
      img.setStyle('color', '#85bb5c');
      img.classList.add('used')
    }
    else {
      img.set('title','Field excluded');
      img.setStyle('color', '#e52929');
      img.classList.remove('used')
    }
  });
}

function UpdateVqrFields(/*first_time*/) {
 if( !Empty(formProp.query) ) {
  var url = new JSURL("../servlet/SPVPVProxy?action=vqr_fields&vqr="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode),true);
	var output=url.Response();
  try {
    output = JSON.parse(output);
    }
  catch(e){
    alert("ERROR: "+formProp.query+" is not a valid name for a query");
    output=[];
  }
  vqrfields = output;
  vqrlist.Empty();
  vqrlist.UpdateList(vqrfields);
  ManageFlagImages();
  /*new JSURL(SPWebRootURL+"/servlet/SPVPVProxy?action=vqr_fields&vqr="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode) ,true, function(response){
    selectedItems=[];
    var res=response.Response()
    if (!Empty(res)) {
      try {
      vqrfields = JSON.parse(res);
	  }
	  catch(e){
		  alert("ERROR: "+formProp.query+" is not a valid name for a query");
		  vqrfields=[];
	  }
	}
    else
      vqrfields=[]
    debugger
    vqrlist.Empty();
      vqrlist.UpdateList(vqrfields);
    ManageFlagImages();
  });
  }*/
}
}

//var RowViewLayer, viewrowopen=false;

function toggleManageFilters(){
  var filtersDiv=document.getElementById('manageFilters');
  if (filtersDiv.style.display=='none'){
    document.getElementById("filters").innerHTML='';
    filtersDiv.style.display='block';
    document.getElementById("newcolumncontainercinema").style.display='block';
    filtersDiv.style.left=window.getSize().x/2-filtersDiv.getSize().x/2+'px';
    filtersDiv.style.top=window.getSize().y/2-filtersDiv.getSize().y/2+'px';
    nFilter=0;
    for (var i=0; i<filtersObj.length; i++){
      addFilter(filtersObj[i]);
    }
  }
  else{
    document.getElementById("newcolumncontainercinema").style.display='none';
    filtersDiv.style.display='none';
  }
}

function addFilter(filter){
  filter=filter||{};
  var listFieldsForFilter="";
  var i;
    // combo per la selezione del filtro
    for (i=0; i<columnsObj.length; i++){
      listFieldsForFilter+="<option value='"+Lower(columnsObj[i].field)+"'>"+columnsObj[i].title+"</option>";
    }
    for (i=0; i<rowsObj.length; i++){
      listFieldsForFilter+="<option value='"+Lower(rowsObj[i].field)+"'>"+rowsObj[i].title+"</option>";
    }
    /*for (i=0; i<measuresObj.length; i++){
      listFieldsForFilter+="<option value='"+Lower(measuresObj[i].field)+"'>"+measuresObj[i].title+"</option>";
    }*/
    var select="<select id='filterName_"+nFilter+"' class='filterName'>"+listFieldsForFilter+"</select>";
    // combo per la scelta dell'operazione
    select+="<select class='filterType' id='filterType_"+nFilter+"'>"+
    '<option selected value="like">Starts with</option>'+
    '<option value="contains">Contains</option>'+
    '<option value="=">=</option>'+
    '<option value="<"><</option>'+
    '<option value="<="><=</option>'+
    '<option value=">=">>=</option>'+
    '<option value=">">></option>'+
    '<option value="<>"><></option>'+
    '<option value="empty">Empty</option>'+
    '<option value="notempty">Not empty</option>'+
    '<option value="currentmonth">Current month</option>'+
    '<option value="currentyear">Current year</option>'+
    '<option value="lastyear">Last year</option>'+
    '<option value="lastmonth">Last month</option>'+
    '<option value="last30days">Last 30 days</option>'+
    '<option value="last60days">Last 60 days</option>'+
    '<option value="last90days">Last 90 days</option>'+
    "</select>"
    var value="<input type='text' value='"+(filter.expression||'')+"' id='filterValue_"+nFilter+"' class='filterValue'/>";
    var li=document.createElement("li");
    li.className='margin';
    li.setAttribute("idx",nFilter);
    li.innerHTML="<div class='deleteFilter' title='Delete' onclick='deleteFilter(this)'></div>"+select+value+""
    document.getElementById("filters").appendChild(li);
    if (filter.field){
      document.getElementById("filterName_"+nFilter).value=Lower(filter.field);
      document.getElementById("filterType_"+nFilter).value=Lower(filter.operator);
    }
  nFilter++;
}

function deleteFilter(f){
  f.parentNode.destroy();
}

function confirmManageFilters(){
  document.getElementById('manageFilters').style.display='none'
  document.getElementById("newcolumncontainercinema").style.display='none';
  filtersObj=[];
  var filters=document.getElementById("filters").getChildren();
  for (var i=0; i<filters.length; i++){
    var idx=filters[i].getAttribute('idx');
    filtersObj.push({
      field:document.getElementById('filterName_'+idx).value,
      operator:document.getElementById('filterType_'+idx).value,
      expression:document.getElementById('filterValue_'+idx).value
    });
  }
}

function closeManageFilters(){
  document.getElementById('manageFilters').style.display='none'
  document.getElementById("newcolumncontainercinema").style.display='none';
}

function onResize() {
  document.getElementById("list").setStyle("max-height",window.getSize().y-150);
}

window.addEvent('domready',function(){
  var toolbar = new SPToolbar(ZTObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  })

  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0){
    standalone=true;
    /*Add toolbar standalone buttons*/
    toolbar.addElement({ 'id': 'open'
      , 'class_name': 'btn'
      , 'action': function(){ openVPV(); }
      , 'image': '../portalstudio/images/icon/btn_open.png'
      , 'title': 'Open'
    },0)
    toolbar.addElement({ 'id': 'save'
      , 'class_name': 'btn'
      , 'action': function(){ save(); }
      , 'image': '../portalstudio/images/icon/btn_save.png'
      , 'title': 'Save'
    },1)
    toolbar.addElement({ 'id': 'saveas'
      , 'class_name': 'btn'
      , 'action': function(){ saveAs('true'); }
      , 'image': '../portalstudio/images/icon/btn_saveAs.png'
      , 'title': 'Save As'
    },2)
    toolbar.addElement({
      'isSeparator': true
    },3)
  }

  document.getElementById('i_preview_wrapper').setStyles({'width': window.getSize().x,'height':window.getSize().y-30,'left':window.getSize().x,'top':30});
  document.getElementById('i_preview').setStyles({'height': window.getSize().y-70,'top':40});
  document.getElementById("list").setStyle("overflow","auto");
  onResize();
  window.addEvent('resize',onResize);
  vqrlist = new ZList("list", {
    idName: "alias",
    aliasName: "alias",
    descName: "desc",
    cssClassItem: "file-item",
    images: [{ title: 'Not loaded', id: 'flag', cssClass: 'flag', image: { value: "&#xf688", color: "#e52929", font: "icons8_win10", fontWeight: "normal", size: 10 } }],
    onClick: function (el, evt, container) {
      if (!evt.ctrlKey) {
        var oldSel = LibJavascript.CssClassNameUtils.getElementsByClassName('selected-file', container, "div");
        for (var j = 0; j < oldSel.length; j++) {
          LibJavascript.CssClassNameUtils.removeClass(oldSel[j], 'selected-file');
          selectedItems.splice(selectedItems.indexOf(oldSel[j]), 1);
        }
      }
      if (evt.ctrlKey && LibJavascript.CssClassNameUtils.hasClass(el, 'selected-file')) {
        LibJavascript.CssClassNameUtils.removeClass(el, 'selected-file');
        selectedItems.splice(selectedItems.indexOf(el), 1);
      } else {
        if( !el.children[0].hasClass('used') ) {
          LibJavascript.CssClassNameUtils.addClass(el, 'selected-file');
          selectedItems.push(el);
        }

      }
      unSelectItem()
    },
    moverMsg: 'Move selected fields to your configuration',
    //moverImage:'../visualquery/images/move_to_zone.png',
    onMoverMouseDown: function (handler, el, evt/*,container*/) {
      unSelectItem();
      if (LibJavascript.CssClassNameUtils.hasClass(el, 'selected-file')) {
        var mooevt = new DOMEvent(evt, window);
        mooevt.stop();
        var pos = document.id(handler).getCoordinates();
        var html = "", sep = ""
        for (var i = 0; i < selectedItems.length; i++) {
          html += sep + document.id(selectedItems[i]).get('name');
          sep = "<br/>";
        }
        var clone = new Element('span', { 'class': 'dragged' }).setStyles({ 'z-index': 999, 'top': pos.top, 'left': pos.left + 10, 'cursor': 'default' }).set('html', html);
        clone.inject(document.body);
        var drag = new Drag.Move(clone, {
          onBeforeStart: function () {
            columnsList.MakeDroppableElements();
            rowsList.MakeDroppableElements();
            measuresList.MakeDroppableElements();
            omeasuresList.MakeDroppableElements();
            odimensionsList.MakeDroppableElements();
            this.droppables = [document.getElementById('measures')];
            if (document.getElementById('columns').childNodes.length == 0)
              this.droppables.push(document.getElementById('columns'));
            if (document.getElementById('rows').childNodes.length == 0)
              this.droppables.push(document.getElementById('rows'));
            if (document.getElementById('odimensions').childNodes.length == 0)
              this.droppables.push(document.getElementById('odimensions'));
            if (document.getElementById('omeasures').childNodes.length == 0)
              this.droppables.push(document.getElementById('omeasures'));
            this.droppables.combine($$('.droppableItem'))
          },
          onDrop: function (dragging, drop) {
            dragging.destroy();
            if (drop != null) {
              SetUpdated();
              var selectedFields = GetSelectedFields();
              if (drop.hasClass("phantom-span")) {
                var beforeOf = drop.getNext();
                beforeOf = (beforeOf ? beforeOf.get("name") : null);
                //livello principale
                var container = drop.getParent().get('id');
                if (container == 'columns')
                  AddColumns(selectedFields, beforeOf);
                else if (container == 'rows')
                  AddRow(selectedFields, beforeOf);
                else if (container == 'measures')
                  AddMeasure(selectedFields, beforeOf);
                else if (container == 'omeasures')
                  AddOMeasure(selectedFields, beforeOf);
                 else if (container == 'odimensions')
                  AddODimension(selectedFields, beforeOf);

              } else if (drop.get('id') == 'columns') AddColumns(selectedFields);
              else if (drop.get('id') == 'rows') AddRow(selectedFields);
              else if (drop.get('id') == 'measures') AddMeasure(selectedFields);
              else if (drop.get('id') == 'omeasures') AddOMeasure(selectedFields);
              else if (drop.get('id') == 'odimensions') AddODimension(selectedFields);
            }
            columnsList.RemoveDroppableElements();
            rowsList.RemoveDroppableElements();
            measuresList.RemoveDroppableElements();
            omeasuresList.RemoveDroppableElements();
            odimensionsList.RemoveDroppableElements();
            document.getElementById('columns').removeClass('droppable_container');
            document.getElementById('rows').removeClass('droppable_container');
            document.getElementById('measures').removeClass('droppable_container');
            document.getElementById('omeasures').removeClass('droppable_container');
            document.getElementById('odimensions').removeClass('droppable_container');
          },
          onEnter: function (dragging, droppable) {
            if (['columns', 'rows', 'measures', 'odimensions', 'omeasures'].indexOf(droppable.get('id')) > -1) {
              droppable.addClass('droppable_container');
            } else {
              var parents = droppable.getParents();
              if (parents.indexOf(document.getElementById('columns')) > -1)
                columnsList.ResponsiveViewOnEnter(droppable);
              else if (parents.indexOf(document.getElementById('rows')) > -1)
                rowsList.ResponsiveViewOnEnter(droppable);
              else if (parents.indexOf(document.getElementById('measures')) > -1)
                measuresList.ResponsiveViewOnEnter(droppable);
              else if (parents.indexOf(document.getElementById('omeasures')) > -1)
                omeasuresList.ResponsiveViewOnEnter(droppable);
              else if (parents.indexOf(document.getElementById('odimensions')) > -1)
                odimensionsList.ResponsiveViewOnEnter(droppable);
            }
          },
          onLeave: function (dragging, droppable) {
            droppable.removeClass('phantom-span_hover');
            droppable.removeClass('droppable_container');
          },
          onCancel: function (dragging) {
            dragging.destroy();
            columnsList.RemoveDroppableElements();
            rowsList.RemoveDroppableElements();
            measuresList.RemoveDroppableElements();
            omeasuresList.RemoveDroppableElements();
            odimensionsList.RemoveDroppableElements();
            document.getElementById('columns').removeClass('droppable_container');
            document.getElementById('rows').removeClass('droppable_container');
            document.getElementById('measures').removeClass('droppable_container');
            document.getElementById('omeasures').removeClass('droppable_container');
            document.getElementById('odimensions').removeClass('droppable_container');
          }
        });
        drag.start(mooevt);
      }
    }
  });
  var dontupdate = false;
  if (!Empty(configname)){
    dontupdate = true;
    new JSURL(SPWebRootURL+"/servlet/SPVPVProxy?action=load&ConfigName="+URLenc(configname) + "&Custom="+URLenc(custom)+"&offlinemode="+URLenc(offlinemode),true,function(response){
      try {
        jsonobj = JSON.parse(response.Response());
      } catch (e) {
        alert('Errore in caricamento del def');
        return;
      }
      if (jsonobj.ERROR) {
        alert(jsonobj.ERROR);
        return;
      }

      var filters = jsonobj.arrayFilters ? jsonobj.arrayFilters : [];
      filtersObj = [];
      var i, f, j, keys, key, o;  //, c;
      for( i=0; i<filters.length; i++) {
        f = filters[i];
        keys = Object.keys(f);
        o = {};
        for( j=0; j<keys.length; j++) {
          key = keys[j];
          if( key.endsWith('_op') )
            o.operator = f[key];
          else if( !key.endsWith('_visible') && !key.endsWith('_fixed')) {
            o.field = key;
            o.expression = f[key]
          }
        }
        filtersObj.push(o)
      }


      for (i=0;i<globalProps.length;i++) {
        if ( typeof (jsonobj.configuration[globalProps[i]])!='undefined' && jsonobj.configuration[globalProps[i]]!='undefined' )
          formProp[globalProps[i]] = jsonobj.configuration[globalProps[i]];
      }
      //console.log(jsonobj)
      baseCustomization.custom = formProp.custom;
      var tmpconfigname = configname;
      if (!Empty(jsonobj.configuration.user)) {
        baseCustomization.user_group = formProp.user_group = 'User';
        tmpconfigname = Strtran(tmpconfigname,"_"+jsonobj.configuration.user,"");
        baseCustomization.user = jsonobj.configuration.user;
      } else if (!Empty(jsonobj.configuration.group)) {
        baseCustomization.user_group = formProp.user_group = 'Group';
        tmpconfigname = Strtran(tmpconfigname,"_g"+jsonobj.configuration.group+"");
        baseCustomization.group = jsonobj.configuration.group;
      } else {
        formProp.user_group = '';
      }

      configname = tmpconfigname;
      baseCustomization.name = formProp.name = tmpconfigname;
      formProp.user = jsonobj.configuration.user;
      formProp.group = jsonobj.configuration.group;

      FormProperties( true );
      UpdateVqrFields(true);

      columnsObj = jsonobj.cols ? jsonobj.cols : [];
      columnsObj.forEach(function(col) {
        Object.assign(col, { type: "column", id: LibJavascript.AlfaKeyGen(10) })
        var idx = LibJavascript.Array.indexOf(vqrfields,col,function(elArray) {
          return elArray.alias==col.field;
        });
        if( idx >= 0) Object.assign(col, { f_type: vqrfields[idx].type })
      });
      columnsList.UpdateList(columnsObj);

      rowsObj = jsonobj.rows ? jsonobj.rows : [];
      rowsObj.forEach(function(row) {
        Object.assign(row, { type: "row", id: LibJavascript.AlfaKeyGen(10) })
        var idx = LibJavascript.Array.indexOf(vqrfields,row,function(elArray) {
          return elArray.alias==row.field;
      });
        if( idx >= 0) Object.assign(row, { f_type: vqrfields[idx].type })
      });
      rowsList.UpdateList(rowsObj);

      measuresObj = jsonobj.measures ? jsonobj.measures : [];
      measuresObj.forEach(function(measure) {
        Object.assign(measure, { type: "measure", id: LibJavascript.AlfaKeyGen(10) })
        var idx = LibJavascript.Array.indexOf(vqrfields,measure,function(elArray) {
          return elArray.alias==measure.field;
        });
        if( idx >= 0) Object.assign(measure, { f_type: vqrfields[idx].type })
      });
      measuresList.UpdateList(measuresObj);

      odimensionsObj = jsonobj.odimensions ? jsonobj.odimensions : [];
      odimensionsObj.forEach(function(odimensions) {
        Object.assign(odimensions, { type: "odimension", id: LibJavascript.AlfaKeyGen(10) })
        var idx = LibJavascript.Array.indexOf(vqrfields,odimensions,function(elArray) {
          return elArray.alias==odimensions.field;
        });
        if( idx >= 0) Object.assign(odimensions, { f_type: vqrfields[idx].type })
      });
      odimensionsList.UpdateList(odimensionsObj);

      omeasuresObj = jsonobj.omeasures ? jsonobj.omeasures : [];
      omeasuresObj.forEach(function(omeasure) {
        Object.assign(omeasure, { type: "omeasure", id: LibJavascript.AlfaKeyGen(10) })
        var idx = LibJavascript.Array.indexOf(vqrfields,omeasure,function(elArray) {
          return elArray.alias==omeasure.field;
      });
        if( idx >= 0) Object.assign(omeasure, { f_type: vqrfields[idx].type })
      });
      omeasuresList.UpdateList(omeasuresObj);

      ManageFlagImages();

      if (jsonobj.actions){
        for (i=0; i<jsonobj.actions.length; i++){
          addAction(jsonobj.actions[i],true);
        }
      }
      if (jsonobj.linkedConfs){
        for (i=0; i<jsonobj.linkedConfs.length; i++){
          addNewLinkedConf(jsonobj.linkedConfs[i],true);
        }
      }
      // arrayFilters;
    });
  }
  else {
   formProp.query="";
  }

  var zListOpts = {
    idName: "id",
    aliasName: "field",
    descName: "title",
    cssClassItem: "file-item",
    sortable: true,
    isSortableElement: function (el) {
      return LibJavascript.CssClassNameUtils.hasClass(el, 'selected-file');
    },
    buttons: [
      { image: '', title: "Edit", functionName: "EditField", cssClass: "edit" },
      { image: '', title: "Delete", functionName: "DeleteField", cssClass: "delete" }
    ],
    onClick: function (el, evt, container) {
      var oldSel = LibJavascript.CssClassNameUtils.getElementsByClassName('selected-file', container, "div");
      var selarr;
      if (this._type == "columns")
        selarr = selectedColumns;
      else if (this._type == "rows")
        selarr = selectedRows;
      else if (this._type == "measures")
        selarr = selectedMeasures;
      else if (this._type == "omeasures")
        selarr = selectedOMeasures;
      else if (this._type == "odimensions")
        selarr = selectedODimensions;
      for (var j = 0; j < oldSel.length; j++) {
        LibJavascript.CssClassNameUtils.removeClass(oldSel[j], 'selected-file');
        selarr.splice(selarr.indexOf(oldSel[j]), 1);
      }
      LibJavascript.CssClassNameUtils.addClass(el, 'selected-file');
      selarr.push(el);
      unSelectItem();
    },
    onMove: function (itmId, oldContId, newContId, elementIdNearTo, mode) {
      SetUpdated();
      var mainobj;
      if (this._type == "columns")
        mainobj = columnsObj;
      else if (this._type == "rows")
        mainobj = rowsObj;
      else if (this._type == "measures")
        mainobj = measuresObj;
      else if (this._type == "omeasures")
        mainobj = omeasuresObj;
      else if (this._type == "odimensions")
        mainobj = odimensionsObj;
      var removed = mainobj.splice(GetColIndexById(mainobj, itmId), 1);
      if (!Empty(elementIdNearTo)) {
        var indexToPut = GetColIndexById(mainobj, elementIdNearTo);
        if (mode == "after") indexToPut++;
        mainobj.splice(indexToPut, 0, removed[0]);
      }
      else { //inserisco in coda
        mainobj.push(removed[0]);
      }
      SetUpdated();
    }
  };

  columnsList = new ZList("columns", Object.assign({}, zListOpts, { _type: 'columns' }));
  if (!dontupdate) columnsList.UpdateList(columnsObj);
  document.getElementById("columns").makeResizable({ handle: "columns_drag", limit: { 'y': [0] }, modifiers: { 'x': '' } });

  rowsList = new ZList("rows", Object.assign({}, zListOpts, { _type: 'rows' }));
  if (!dontupdate) rowsList.UpdateList(rowsObj);
  document.getElementById("rows").makeResizable({ handle: "rows_drag", limit: { 'y': [0] }, modifiers: { 'x': '' } });

  measuresList = new ZList("measures", Object.assign({}, zListOpts, { _type: 'measures' }));
  if (!dontupdate) measuresList.UpdateList(measuresObj);
  document.getElementById("measures").makeResizable({ handle: "measures_drag", limit: { 'y': [0] }, modifiers: { 'x': '' } });

  odimensionsList = new ZList("odimensions", Object.assign({}, zListOpts, { _type: 'odimensions' }));
  if (!dontupdate) odimensionsList.UpdateList(odimensionsObj);
  document.getElementById("odimensions").makeResizable({ handle: "odimensions_drag", limit: { 'y': [0] }, modifiers: { 'x': '' } });

  omeasuresList = new ZList("omeasures", Object.assign({}, zListOpts, { _type: 'omeasures' }));
  if (!dontupdate) omeasuresList.UpdateList(omeasuresObj);
  document.getElementById("omeasures").makeResizable({ handle: "omeasures_drag", limit: { 'y': [0] }, modifiers: { 'x': '' } });

  UpdateVqrFields(true);
  FormProperties();

  document.getElementById("newfilter").addEvent('click',function() {
    addFilter();
  });
  document.getElementById("refreshfields").addEventListener('click', function() {
    UpdateVqrFields(false);
  })
});

function GetColIndexById(arr,id) {
  return LibJavascript.Array.indexOf(arr,id,function(el) {
    return id==el.id;
  });
}

function SetUpdated() {
  m_bUpdated=true;
}

function GetConfigName() {  //wip
 return (formProp.custom=="true"?"1":"0")+"/"+configname+(Lower(formProp.user_group)=='user'?'/'+jsonobj.configuration.User:(Lower(formProp.user_group)=='group'?'/g'+jsonobj.configuration.Group:''));
}
function GetSelectedFields() {//wip
  var selectedFields = [];
  for (var j=0;j<selectedItems.length;j++) {
    var myname = selectedItems[j].get('name')
    var idx = LibJavascript.Array.indexOf(vqrfields,myname,function(elArray) {
                return elArray.alias==myname;
              });
    if (idx>-1) {
      selectedFields.push(vqrfields[idx]);
    }
  }
  return selectedFields;
}

function EditField(name_field) {
  var c = document.getElementsByName(name_field);
  var isMeasure = false;
  if( c && c.length > 0) {
    if( (c[0].parentNode.id == 'measures') || (c[0].parentNode.id == 'omeasures') )
      isMeasure = true;
  }
  unSelectItem();
  openSPModalLayer("../jsp-system/SPVisualPivotColumns_portlet.jsp?isMeasure=" + isMeasure +"&fname="+URLenc(name_field), 100, 100, 660, 225, false, 1, false,false,null,true);
}

function DeleteField(id) {
  unSelectItem();
  SetUpdated();
  var fobj =  GetFieldDetail(id),
  type = fobj.type + "s",
  mainObj = eval(type + "Obj"),
  index = GetFieldPosition(mainObj, id),
  toRemove = mainObj.splice(index, 1),
  mainList = eval(type + "List");
  mainList.RemoveItems(toRemove);
  deleteMap[toRemove[0].field] = toRemove[0];
  ManageFlagImages();
}

function GetFieldDetail(f_name) {
  var fobj = null,
  elm = document.getElementsByName(f_name);
  if (elm.length > 0) {
    elm = elm[0];
    fobj = GetFieldFromArray(elm.parentElement.id, f_name);
  }
  return fobj;
}

function GetFieldFromArray(type, id) {
  var mainObj = eval(type + "Obj");
  return mainObj[GetFieldPosition(mainObj, id)];
}

function GetFieldPosition(array, id) {
  return LibJavascript.Array.indexOf(array,id,function(el) {
    return el.id == id;
  })
}

function SetFieldDetail(f_name, fobj) {
  SetUpdated();
  var type = fobj.type + "s",
  field = GetFieldFromArray(type, f_name);
  LibJavascript.JSONUtils.fillWith(field, fobj);
  field.title = field.descrs;
  field.condformats = fobj.condformats
  var list = eval(type + "List");
  list.UpdateItem(f_name, null, field);
  ManageFlagImages();
}

function GetCurrentName() {
  var filename = (formProp.custom=="true"?"CUSTOM_":"")+configname;
  if (formProp.user_group=='User')
    filename +=  "_" + formProp.user;
  else if (formProp.user_group=='Group')
    filename +=  "_g" + formProp.group;

  return filename;
}

function GetResourceName(parms) {
  return '../jsp/SPVisualPivot_portlet.jsp?ConfigName='+URLenc(GetConfigName())+'&m_NoCache='+LibJavascript.AlfaKeyGen(10)+parms;
}

function selectForm(){
  FormProperties();
}

function GetRequestParams() { //Oggetto nome -> [{description, type, len, dec} | tipo ]
  var result = {};
  var url = new JSURL("../servlet/SPVQRProxy?action=vqrparameters&filename="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode),true);
	var output=url.Response();
  try {
	output = JSON.parse(output);
  }
  catch(e){
	  alert("ERROR: "+formProp.query+" is not a valid name for a query");
	  output=[];
  }
  for (var i=0;i<output.length;i++) {
    var nameVar = output[i][0];
    if (Left(nameVar,2)!='w_') nameVar = 'w_'+nameVar;
    result[nameVar]={description: output[i][1], type:output[i][2], len: output[i][3], dec: output[i][4]};
  }
  return result;
}

function ManageQueryChange(oldValue, newValue) {
  if (Empty(oldValue)) {
    reset();
  }
  else if (confirm("Query name changed from \""+oldValue+"\" to \""+newValue+"\". Empty fields configurations?")) {
    reset()
  }

  function reset() {
    columnsObj=[];
    rowsObj = [];
    measuresObj = [];
    omeasuresObj = [];
    odimensionsObj = [];
    selectedColumns=[];
    selectedRows=[];
    selectedMeasures=[];
    selectedOMeasures=[];
    selectedODimensions=[];
    columnsList.Empty();
    rowsList.Empty();
    measuresList.Empty();
    omeasuresList.Empty();
    odimensionsList.Empty();
  }
}
function AfterQueryChange() {
  var output
  var url = new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode),true);
  output=url.Response();
  if (parseInt(output)<1) {
    alert("ERROR: "+formProp.query+" is not a valid name for a query");
  } else {
    UpdateVqrFields(false);
  }
}

// eslint-disable-next-line no-redeclare
function selectItem(el){
  if (el){
    if (last_index!=null && last_index>=0){
      itemsHTML[last_index].element.removeClass('selected');
    }
    el.addClass('selected');
    itemsHTML.some(function(arr_el,i) {
      if (arr_el.element==el) {
        index=i;
        return true;
      } else {
        return false;
      }
    });
    Properties()
  }
  else if(!Empty(newPropObj))newPropObj.HideProperties();
}

function unSelectItem(){
  if (index!=null){
    if(!Empty(newPropObj))
      newPropObj.HideProperties();
    itemsHTML[index].element.removeClass('selected');
    index=null;
    last_index=null;
  }
}

function writeHTML(){
  if (index!=null){
    var name=(itemsHTML[index].type=='linkedConfiguration'?itemsHTML[index].linkedConfName:itemsHTML[index].actionName)||itemsHTML[index].title;
    if (itemsHTML[index].name!=name){
      var selectedAction=itemsHTML[index].element.getChildren();
      selectedAction[1].set('html',name)
      itemsHTML[index].name=name;
      itemsHTML[index].id=name;
      selectedAction[1].set('title',itemsHTML[index].title)
    }
  }
}

function Properties(){
  if (newPropObj && last_index != null && last_index==index){
    newPropObj.updatePropertiesFromPaint(itemsHTML[index]);
  }else{
    newPropObj = new propertiesObj({m_obj:itemsHTML[index],canExpandToColumn:false,tabindex:100,divcontainer:'properties',moveDiv:true});
    last_index=index;
    document.getElementById('properties').show()
  }
}

function removeItem(el){
  var position=-1;
  if (el) {
    itemsHTML.some(function(arr_el,i) {
      if (arr_el.element==el) {
        position=i;
        return true;
      } else {
        return false;
      }
    });
  }
  if (position!=-1){
    itemsHTML.splice(position,1)
    el.destroy();
    last_index=null;
    index=null;
    if(!Empty(newPropObj))
      newPropObj.HideProperties();
    resizeGadgetsPane()
  }
}

function ListObj(obj){
  if (!obj || obj.value=='form'){
    unSelectItem();
  }
  else {
    for (var i=0; i<itemsHTML.length; i++){
      if (itemsHTML[i].name==obj.value){
        selectItem(itemsHTML[i].element);
        break;
      }
    }
  }
}

function insertImage(url,imgnew,retTo){
  itemsHTML[index][retTo]=url;
  Properties();
  writeHTML();
}

function addAction(action,dontUpdate){
  var select;
  if (!action){
    action={}
    action.title='action'+progrAct;
    action.actionName='action'+progrAct;
    action.hyperlink='';
    action.url='';
    action.visibility='default';
    action.important='false';
    action.image_settings='default'
    action.font_name='';
    action.font_image='';
    action.font_size='';
    action.font_color='';
    action.entityType='hyperlink';
    action.parameter='';
    action.sendMemCurs='false';
    action.memCursParam='';
    action.checkAllParam='';
    action.queryFilterParam='';
    action.doQryAfterRoutine='false';
    action.image='';
    action.showInMenu='false';
    action.popup_height='';
    action.popup_width='';
    action.progressBar='false';
    action.progressBarPortlet='';
    action.target='_blank';
    action.popup='true';
    action.confirmMessage='';
    select=true;
  }
  action.actionName = action.actionName || action.title || 'action'+progrAct;
  var actionName=new Element('span',{
    html:action.actionName,
    styles:{
      'paddingLeft':'5px'
    },
    title:action.title
  })
  var deleteImg=new Element('div',{
    'class':'imgDelete',
    title:'Delete'
  })
  deleteImg.addEvent('click',function(){
    //si passa l'elemento li
    selectItem(this.getParent());
    removeItem(this.getParent());
  })
  var newAction=new Element('li',{
  }).adopt(deleteImg).adopt(actionName);
  newAction.addEvent('click',function(){
    selectItem(this);
  })
  action.element=newAction;
  itemsHTML.push(new ZTObjects.actionObj(action));
 // nItem++;
  progrAct++
  mySortables.addItems(newAction);
  document.getElementById('actionList').adopt(newAction);
  if (select)
    selectItem(newAction)
  resizeGadgetsPane();
  if (!dontUpdate)
    SetUpdated();
}

function addNewLinkedConf(linkedConf,dontUpdate){
  var select;
  if (!linkedConf){
    linkedConf={}
    linkedConf.title='Linked Configuration '+progrLCf;
    linkedConf.linkedConfName='Linked Configuration '+progrLCf;
    linkedConf.configname='';
    linkedConf.configtype='';
    linkedConf.ontoolbar='false';
    linkedConf.ontabs='false';
    linkedConf.imagetoolbar='';
    linkedConf.imagetype='grid';
    select=true;
  }
  linkedConf.linkedConfName = linkedConf.linkedConfName || linkedConf.title || 'Linked Configuration '+progrLCf;
  var linkedConfName=new Element('span',{
    html:linkedConf.title,
    styles:{
      'paddingLeft':'5px'
    },
    title:linkedConf.title
  });
  var deleteImg=new Element('div',{
    'class':'imgDelete',
    title:'Delete'
  })
  deleteImg.addEvent('click',function(){
    //si passa l'elemento li
    selectItem(this.getParent())
    removeItem(this.getParent())
  })
  var newLinkedConf=new Element('li',{
  }).adopt(deleteImg).adopt(linkedConfName);
  newLinkedConf.addEvent('click',function(){
    selectItem(this);
  })
  linkedConf.element=newLinkedConf;
  itemsHTML.push(new ZTObjects.linkedConfigurationObj(linkedConf));
  //nItem++;
  progrLCf++
  mySortables.addItems(newLinkedConf);
  document.getElementById('linkedConfList').adopt(newLinkedConf);
  if (select)
    selectItem(newLinkedConf)
  resizeGadgetsPane();
  if (!dontUpdate)
    SetUpdated();
}

function editPortlet(ref){
  var url=document.getElementById((typeof ref =='object'?ref.refId:ref)).value;
  if(!Empty(url)){
    url=Strtran(url,"_portlet.jsp","");
    if(url.indexOf("?")>-1){
      url = url.substring(0,url.indexOf("?"));
    }
  if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    window.parent.newCurrentObj(url,"portlet",{});
  else
    window.open("../visualweb/editor.jsp?id="+url, "portleteditor", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function setPropertyValue(isForm,tab,name,value){
  var el = document.getElementById((isForm?'Form_':'')+tab+'_'+name);
  if(isForm){
    formProp[name] = value;
  }else{
    itemsHTML[index][name] = value;
  }
  if(el.type == 'checkbox'){
    el.checked= (value=='true'?'checked':'');
  }else{
    el.value=value;
  }
  el.focus();
  el.blur();
}

function SetChartWizardConfiguration(obj) {
  if (!Empty(obj.def)) {
    setPropertyValue(true, 'chart_options', 'chartDef', obj.def);
  }
  else {
    setPropertyValue(true, 'chart_options', 'chartDef', "type:" + obj.type);
  }
}

function selectPortlet(ref){
  PickItems('portlet',ref.refId,null, null, 930, 600);
}

function checkChartDef(chartName) {
  if (Empty(chartName))
    return true;
  if (chartName.indexOf("type:") == 0) {
    SetSmartChartdef(chartName);
    return true;
  }
  var chartdef = getChartDefType(chartName),
    mcat = chartdef.category;
  if (mcat != "error") {
    //setPropertyValue(true, 'chart_options', 'chartDef', chartName);
  }
  else {
    PSAlert.alert("Chart Definition not Found");
    return false;
  }
  return true;
}

var _clevelObj = null;
function checkDataSourceLevel(obj) {
  _clevelObj = obj;
  openSPModalLayer("../jsp-system/SPVisualPivotPrefetch_portlet.jsp", 100, 100, 660, 225, false, 1, false,false,null,true);
}

function SetCacheLevel(rowIndex, colIndex) {
  if(!_clevelObj) return;
  var inp, str;
  if( _clevelObj.refPropId == 'cachelevel2' ) {
    inp = document.getElementById(_clevelObj.refId)
    this.updateProperties(inp,_clevelObj.refPropId,'str',true,colIndex+"",true)
    inp.value = colIndex+"";
    str = Strtran(_clevelObj.refId, 'cachelevel2', 'cachelevel')
    inp = document.getElementById(str)
    this.updateProperties(inp,'cachelevel','str',true,rowIndex+"",true)
    inp.value = rowIndex+"";
  }
  else {
    inp = document.getElementById(_clevelObj.refId)
    this.updateProperties(inp,_clevelObj.refPropId,'str',true,rowIndex+"",true)
    inp.value = rowIndex+"";
    str = Strtran(_clevelObj.refId, 'cachelevel', 'cachelevel2')
    inp = document.getElementById(str)
    this.updateProperties(inp,'cachelevel2','str',true,colIndex+"",true)
    inp.value = colIndex+"";
  }
}
