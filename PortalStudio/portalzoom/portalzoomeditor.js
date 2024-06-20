/*global tablename configname frontendport offlinemode custom jsonconfiguration*/
/* exported
    folder_path num_child itemsClone
    searchNode doLoad Help reset newCurrentObj insertImage ListObj AfterQueryChange ManageQueryChange
    GetRequestParams selectForm GetResourceName saveNewName closeOrderExtraTitle toggleManageFilters
    confirmOrderExtraTitle GetCurrentName DeleteRowLayer DeleteHidddenField EditRowLayer
    SetRowLayer deleteFilter confirmManageFilters closeManageFilters DeleteColumn closeNewColumn
    EditColumn SetColumn getOpener GetSelectedColId _togglePreview toggleRowView toggleSecondaryBarView
  */

var folder_path=''
var newPropObj = null;
var nItem=0;
var notimooManager;
var baseCustomization = {custom:false, user: 0, group:0, user_group:"" };
var nFilter=0;
var mySortables = new Sortables('#actionList,#linkedConfList');
function doLoad(/*e*/){
  try{
    //parent.setTitle(this)
  } catch(ec) {}

  document.getElementById('backcanvas').setStyle('display','block');
  windowResize();
  FormProperties();
  document.getElementById('loading').setStyle('display','none');
  notimooManager = new Notimoo({});
  create_gadget_pane();
  window.addEvent("keydown", function(e) {
    if (e.control && e.key=="s") { //CTRL-S
      if(document.activeElement.tagName=='INPUT'){
        var activeE=document.activeElement;
        activeE.blur();
        activeE.focus();
      }
      e.stop();
      if (parent.saveTool) parent.saveTool();
    }
  });
}

function Help(the_property) {
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

function newCurrentObj(name, type, parms){
  // var params = (parms && Object.getLength(parms)>0 ? "&" + Object.toQueryString(parms) :"");
  window.location.href=getOpenUrl(name,type,parms)
}

function openVZM(){
  if(m_bUpdated){
    if(!confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
      return false;
    }
  }
  var width = 800;
  var height = 600;
  var url = "../portalstudio/open.jsp?tool=portalzoom&onetool=true";
  url += "&SPModalLayerId=vzmSPModalLayer";
  var left = (screen.width)?(screen.width-width)/2:100;
  var top = (screen.height)?(screen.height-height-(height/4))/2:100;
  openSPModalLayer(url,top,left,width,height,true,1,false,false);
  FormProperties();
}

function isExpr(txt){
  return txt.match(/(function|var|image|javascript|checkbox|html|eval):/);
}

function AddColumnLayer(colId,fields, beforeOf) { //beforeOf se non passato si aggiunge in coda
  unSelectItem();
  var col = GetColumnById(colId);
  var arrayToPut=ReturnAddToCol(fields);
  var index = col.Layer.length;
  if (beforeOf) {
    col.Layer.some(function(itm,i) {
      if (itm.id==beforeOf) {
        index = i;
        return true;
      }
      return false;
    });
  }
  col.Layer.splice.apply(col.Layer, [index,0].concat(arrayToPut))
  columnsList.AppendItemsInContainer(colId,arrayToPut,beforeOf);
  ManageFlagImages();
}
function ReturnAddToCol(fields) {
var arrayToPut=[];
  for (var i=0;i<fields.length;i++) {
    if (!fields[i].column) {
      fields[i].column={field:fields[i].alias,title:fields[i].desc};
    }
    fields[i].column = JSON.parse(JSON.encode(fields[i].column),true);
    delete fields[i].column.id;
    delete fields[i].column.orderbyidx;
    delete fields[i].column.orderbystatus;
    fields[i].column = JSON.parse(JSON.encode(LibJavascript.JSONUtils.adjust(fields[i].column, getColSchema())),true);
    arrayToPut.push(fields[i].column)
  }
  return arrayToPut;
}
function AddColumns(fields,beforeOf) { //beforeOf se non passato si aggiunge in coda
  unSelectItem();
  var arrayToPut=ReturnAddToCol(fields);
  var index = columnsObj.length;
  if (beforeOf) {
    columnsObj.some(function(itm,i) {
      if (itm.id==beforeOf) {
        index = i;
        return true;
      }
      return false;
    });
  }
  columnsObj.splice.apply(columnsObj, [index,0].concat(arrayToPut));
  columnsList.AppendItems(arrayToPut,beforeOf);
  ManageFlagImages();
}
function AddRowLayer(fields,beforeOf) { //beforeOf se non passato si aggiunge in coda
  unSelectItem();
  var arrayToPut=ReturnAddToCol(fields);
  var index = rowLayerObj.length;
  if (beforeOf) {
    rowLayerObj.some(function(itm,i) {
      if (itm.id==beforeOf) {
        index = i;
        return true;
      }
      return false;
    });
  }
  rowLayerObj.splice.apply(rowLayerObj, [index,0].concat(arrayToPut));
  rowLayerList.AppendItems(arrayToPut,beforeOf);
  ManageFlagImages();
}
function AddHideFields(fields) {
  unSelectItem();
  function compare(ArrEl, comp) {
    return ArrEl.field==comp;
  }
  var arrayToPut=[];
  var notInserted = [];
  for (var i=0;i<fields.length;i++) {
    if (LibJavascript.Array.indexOf(hiddenFieldsObj, fields[i].alias, compare)==-1 &&
        LibJavascript.Array.indexOf(columnsObj, fields[i].alias, compare)==-1 &&
        LibJavascript.Array.indexOf(rowLayerObj, fields[i].alias, compare)==-1) {
      arrayToPut.push(fields[i].alias);
    } else {
      notInserted.push(fields[i].alias);
    }
  }
  arrayToPut = TransformHiddenFields(arrayToPut);
  hiddenFieldsObj.append(arrayToPut);
  hidefieldsList.AppendItems(arrayToPut);
  if (notInserted.length>0) alert("Any fields not append to hidden fields")
  if (fields.length>notInserted.length) ManageFlagImages();
}

function saveAs() {
  var customizationParms = "&custom="+formProp.custom;
  if (formProp.user_group=='User')
    customizationParms +=  "&filter=_" + formProp.user;
  else if (formProp.user_group=='Group')
    customizationParms +=  "&filter=_g" + formProp.group;
  OpenWindow('../portalstudio/saveas.jsp?tool=portalzoom&tablename='+tablename + customizationParms, 580,600);
}

function IsModifiedCustomization() {
  return formProp.user != baseCustomization.user ||
    formProp.group != baseCustomization.group ||
    formProp.custom != baseCustomization.custom ||
    formProp.name != baseCustomization.name ||
    formProp.user_group != baseCustomization.user_group;
}
function CheckCustomization() {
  var conf = true;
  if ( IsModifiedCustomization() ) {
    // cambiata la parte custom, quindi si sta andando a salvare un nuovo file!! Bisogna chiedere conferma sul salvataggio
    var filter='';
    if (formProp.user_group=='User')
      filter = "_" + formProp.user;
    else if (formProp.user_group=='Group')
      filter = "_g" + formProp.group;

    var url = new JSURL('../servlet/JSPReader?type=portalzoom&filter='+filter+"&custom="+formProp.custom+"&name="+formProp.name+"&tablename="+formProp.table+"&check=true",true);
    var output=url.Response();
    if(output=="found"){
      if(!confirm("You have modified customize options.\nThis custom file already exist, overwrite?"))
        conf = false;
    }
  }
  return conf;
}
var AfterSave
function save(then) {
  if (!CheckCustomization()) return;
  if(viewrowopen) {
    if(RowViewLayer)
      try {
        RowViewLayer.getContainer().getElement('iframe').contentWindow.Save();
      } catch(e) {}
  }
  if (then=='close') AfterSave='close';
  else if( !Empty(then)){ //then � un oggetto che contiene una funzione che deve essere eseguita dopo il salvataggio
   AfterSave = then;
  }
  if(parent) parent.is_Saving=true;
  if(!Empty(tablename) && !Empty(configname)){
    notimooManager.show({
      title:'Notification message',
      message: 'saving vzm...',
      sticky : true,
      width:200,
      height:40
    });
    save2.delay(100);
  } else {
    // window.parent.saveAsTool()
    saveAs();
  }
}

function searchNode(items,node){
  for(var i =0; i<items.length; i++){
    if(items[i].id == node.id)
      return i;
  }
  return -1;
}
var num_child
  , itemsClone = []
  , globalProps = [ "GridRows", "CountRows", "defaultViewMode", "paddingCard", "marginCard"
                  , "Caption", "filters", "titles", "header", "emptyrows", "recordmark", "Autozoom", "PKFields"
                  , "entityType", "Popup", "toolsPosition", "delMessage", "LinkAdd", "LinkAddExposed"
                  , "LinkAccess", "LinkEdit", "LinkDelete", "css_class", "css_class_card_container", "chartDef"
                  , "LinkAccessExposed", "labelField", "valueFields", 'PrintMode', 'ReportName'
                  , "label_series", "labelKey_field", "x_field", "xKey_field", "y_field"
                  , "z_field", "xyz_series_field", "min_field", "max_field", "val_field"
                  , "measure_series_field", "measureKey_series_field", "chart_type",'TotalsPosition'
                  , 'TotalsStarting', 'show_btn_update', 'show_btn_delete','BOSavedOkMsg','confirmBODeleteMsg'
                  , 'description','newAction', 'openVdmBeforeQuery','vdmfile','activateCheckbox', 'disablePresetParam'
                  , 'applyAdvancedFilter', 'css', 'hideFiltersBtn','portlet_in_row','start_in_row','geo_0_field','geo_1_field','geo_level','geo_value_field'
                  , 'geo_dom_field','geo_view','editableBySmartEditor','chartminH','chartmaxH','compactChart','infiniteScroll','row_preview_src'
                  , 'print_option','print_title','print_hideexport','print_hidesettings', 'group_repeated', 'LinkQuery', 'vdmWidth', 'vdmHeight', 'allowedqueries'
                  , 'print_totals','print_size','print_outputf','print_max','print_grep'
                  , 'geo_view_select', 'geo_level_2', 'geo_level_3', 'geo_onlydata'
                  ]
  ;
function saveNewName(newbasename) {
  formProp.name = newbasename;
  FormProperties();
  save2();
}
function save2() {
	var output, i, col;
  var customizationParms = "&Custom="+( formProp.custom ? formProp.custom : 'false');
  if (formProp.user_group=='User')
    customizationParms +=  "&NewUser=" + formProp.user;
  else if (formProp.user_group=='Group')
    customizationParms +=  "&NewGroup=" + formProp.group;
  var setOrderBy = false;
  var colProps = ["id","field","title","link","target","tooltip","title_tooltip","picture","isImage","isInitLetter","isInitLetter2","inExtGrid","Layer","exp","descr","groupby","pict_total","enable_HTML","checkbox","orderbyidx","orderbystatus","width","height","fixedwidth","col_span","row_span","new_line","align","font_size","font_weight","font_color","bg_color","col_class","hidden","tileMode","tileModeGroupBy","tileBackgroundColor","tileVersion",'tileVisibility','editable','title_align',"show_extra_title","extracolidx","onclick","synonyms","sanitize","sanitize_tags","printable"],
  rowLayerProps = ["id","field","title","link","target","tooltip","title_tooltip","picture","isImage","inExtGrid","enable_HTML","checkbox","align","hidden","show_extra_title","extracolidx","onclick","synonyms","sanitize","sanitize_tags"];

  var confToSend = {};
  confToSend.Configuration = LibJavascript.JSONUtils.purge(formProp, globalProps, true);
  confToSend.Configuration.actions = [];
  confToSend.Configuration.linkedConfs = [];
  var actions=document.getElementById("actionList").getChildren();
  var idx=-1;
  for (i=0; i<actions.length; i++){
    itemsHTML.some(function(arr_el,j) {
      if (arr_el.element==actions[i]) {
        idx=j;
        return true;
      } else {
        return false;
      }
    });
    confToSend.Configuration.actions.push({
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
      confirmMessage:itemsHTML[idx].confirmMessage,
      toExpose:itemsHTML[idx].toExpose
    })
  }
  var linkedConf=document.getElementById("linkedConfList").getChildren();
  for (i=0; i<linkedConf.length; i++){
    itemsHTML.some(function(arr_el,j) {
      if (arr_el.element==linkedConf[i]) {
        idx=j;
        return true;
      } else {
        return false;
      }
    });
    confToSend.Configuration.linkedConfs.push({
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
  confToSend.Cols = LibJavascript.JSONUtils.purge(columnsObj, colProps);
  confToSend.RowLayer = LibJavascript.JSONUtils.purge(rowLayerObj, rowLayerProps);
  confToSend.HideFields = PurgeHiddenFields(hiddenFieldsObj);

  //Fields
  var fields_map = {},
      fields = [],
      _;

  // eslint-disable-next-line no-cond-assign
  for(i=0; col=confToSend.Cols[i++]; ){//cicla nelle cols per raccogliere i fields
    var field = col.field;
    var layer = col.Layer;
    if(!isExpr(field) && !(field in fields_map)){
      fields_map[field] = _;
      fields.push(field);
    }
    if (!Empty(col.orderbyidx)) setOrderBy = true;
    if(typeof(col.width)!='undefined'){
      col.width = col.width.indexOf("%")>-1?col.width:((!Empty(col.width) && col.width.indexOf('px')==-1)?col.width+'px':col.width);
    }
    if(typeof(col.fixedwidth)!='undefined'){
      col.fixedwidth = col.fixedwidth.indexOf("%")>-1?col.fixedwidth:((!Empty(col.fixedwidth) && col.fixedwidth.indexOf('px')==-1)?col.fixedwidth+'px':col.fixedwidth);
    }
    if(!EmptyArray(layer)){ //cerca i fields nei layer di colonna
      for(var j=0; col=layer[j++]; ){ // eslint-disable-line no-cond-assign
        field = col.field;
        if(!isExpr(field) && !(field in fields_map)){
          fields_map[field] = _;
          fields.push(field);
        }
      }
    }
  }
  // eslint-disable-next-line no-cond-assign
  for(i=0; col=confToSend.RowLayer[i++]; ){//cicla nelle cols per raccogliere i fields
    field = col.field;
    if(!isExpr(field) && !(field in fields_map)){
      fields_map[field] = _;
      fields.push(field);
    }
  }
  for(col in confToSend.HideFields)
    if (LibJavascript.Array.indexOf(confToSend.Fields,col)==-1) fields.push(col);

  confToSend.Configuration.OrderBy=setOrderBy;
  confToSend.Fields = fields;
  confToSend.ArrayFilters = [];
  for (i=0; i<filtersObj.length; i++){
    var fieldName=filtersObj[i].field;
    var f={};
    f[fieldName+'_visible']=true;
    f[fieldName+'_fixed']=false;
    f[fieldName+'_op']=filtersObj[i].operator;
    f[fieldName]=filtersObj[i].expression;
    confToSend.ArrayFilters.push(f);
  }
  configname=formProp.name;
  var url = new JSURL("../servlet/SPVZMProxy?frontendport="+frontendport+
    "&m_cAction=save" +
    "&table="+formProp.table+
    "&configname="+formProp.name+
    "&vqr="+URLenc(formProp.query)+
    "&config="+ URLenc(JSON.encode(confToSend)) +
    "&offlinemode="+URLenc(offlinemode) + customizationParms+
    "&fromFullEditor=true" +
    "&m_cID=" + cmdhash
    ,true);
  output=url.Response();
  try {
    output = JSON.parse(output);
  } catch (e) {
    output.ERROR=true;
    output.MESSAGE='Error on save';
  }
  notimooManager.close(notimooManager.elements[0]);
  if (output.ERROR) {
    notimooManager.close(notimooManager.elements[0]);
    alert(output.MESSAGE||'Error on save');
  } else if (output.OK) {
    notimooManager.show({
       title:'Notification message',
       message: 'Vzm saved!',
       visibleTime: 2000,
       width:200
    });

    // if(window.opener != "undefined"){
      // try {
        // window.opener.document.getElementById('zones_Id').submit()
      // } catch(e) {}
    // }
    if(parent) parent.is_Saving=false;
    m_bUpdated=false;
    if(AfterSave=="close")
      window.parent.closeCurrentObj();
    else {
      if(window.top.GetOpener() && window.top.GetOpener().ReportZoomConfiguration) window.top.GetOpener().ReportZoomConfiguration();
      if (IsModifiedCustomization()) {
        var newconfigname = formProp.name;
        if (formProp.user_group=='User')
          newconfigname +=  "_" + formProp.user;
        else if (formProp.user_group=='Group')
          newconfigname +=  "_g" + formProp.group;
        if (parent.changeName)
          parent.changeName( newconfigname+"["+formProp.table+"]", {custom:formProp.custom},Strtran(window.frameElement.id,'portalstudioframe',''))
        if(window.parent.AddRecentOpen) window.parent.AddRecentOpen("portalzoom",newconfigname+"["+formProp.table+"]",{custom:formProp.custom})
        if (window.history.pushState) {
          window.history.pushState(1, newconfigname+"["+formProp.table+"] - VisualZoom Editor", "portalzoomeditor.jsp?Table="+formProp.table+"&ConfigName="+newconfigname+(formProp.custom=="true"?"&custom="+formProp.custom:"")+"&offlinemode="+URLenc(offlinemode));
          //reset delle variabili
          baseCustomization.user = formProp.user;
          baseCustomization.group = formProp.group;
          baseCustomization.custom = formProp.custom;
          baseCustomization.name = formProp.name;
          baseCustomization.user_group = formProp.user_group;
        } else
          window.location.href=SPWebRootURL+"/portalzoom/portalzoomeditor.jsp?Table="+formProp.table+"&ConfigName="+newconfigname+(formProp.custom=="true"?"&custom="+formProp.custom:"")+"&offlinemode="+URLenc(offlinemode);
      }
      if(!Empty(AfterSave)){
        AfterSave();
        AfterSave=null;
      }
    }

  } else {
    notimooManager.close(notimooManager.elements[0]);
    alert("Save routine failed.")
  }
}

function selectItem(node){
  /*Find node in itemsHTML*/
  // if(index > -1){
    // newPropObj.updatePropertiesFromPaint(it);
    // writeHTML();
  // }
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
  // if(document.getSize().y - ctrl.offsetTop > 0)
    // ctrl.style.height = (document.getSize().y - (ctrl.offsetTop + 20))+"px";

}

window.addEvent('resize', windowResize);

var columnsObj=[], rowLayerObj = [], hiddenFieldsObj = [], filtersObj = [];
var columnsList, rowLayerList, hidefieldsList, vqrlist, extratitlelist;
function getOpener() {
  return (window.opener?window.opener:(window.caller?window.caller:window.parent));
}

function getColSchema(){
  function mandatoryPropertyError(){
    throw new Error("Mandatory property error");
  }
  return {
        id: function(){ return LibJavascript.AlfaKeyGen(10); },
        field: mandatoryPropertyError,
        type: function(){ return "C"; },
        title: "",
        link: "",
        target: "",
        format: "",
        onclick: "",
        align: "",
        picture: "",
        width: "",
        font: "",
        font_size: "",
        font_color: "",
        bg_color: "",
        font_weight: "",
        bg_color: "",
        col_span: "",
        row_span: "",
        enable_HTML: "",
        Layer: function(){ return []; },
        new_line: false,
        orderbyfld: function(itm){ return isExpr(itm.field) ? '' : itm.field ; },
        orderbystatus: '',
        editable:false,
        orderbyidx: 0,
        title_align:'',
        show_extra_title:false,
        extracolidx:100, // metto un valore alto in modo che quando ne aggiungo uno va in fondo e non alla fine
        printable:true
      };
}

var vqrfields, //[alias , desc, column]
    selectedItems=[],
    selectedColumns=[],
    selectedRowLayer=[],
    selectedHideFields=[],
    selectedExtraTitle=[];

function TransformHiddenFields(hf) {
 var hfs = [];
 for (var i=0; i<hf.length;i++) {
  hfs.push({field:hf[i]});
 }
 return hfs;
}
function PurgeHiddenFields(hf) {
 var hfs = {};
 for (var i=0; i<hf.length;i++) {
  hfs[hf[i].field]='';
 }
 return hfs;
}

function ReturnUsedFields() {
  var result = {col:{},collayer:{},rowlayer:{},hidden:{}}, i, j;
  for (i=0; i<columnsObj.length;i++) {
    result.col[columnsObj[i].field]='';
    for (j=0; j<columnsObj[i].Layer.length;j++) {
    result.collayer[columnsObj[i].Layer[j].field]='';
    }
  }
  for (i=0;i<rowLayerObj.length; i++) {
    result.rowlayer[rowLayerObj[i].field]='';
  }
  for (i=0;i<hiddenFieldsObj.length; i++) {
    result.hidden[hiddenFieldsObj[i].field]='';
  }
  return result;
}

function ManageSanitizeImages(rl){
  document.id(rl?"rowlayer":"columns").getChildren().each(function(el) {
    var colObj=rl?GetRowLayerById(el.get('name')):GetColumnById(el.get('name'));
    ManageSanitizeImg(el,colObj);
    if (colObj.Layer && colObj.Layer.length>0){
      for (var i=0; i<colObj.Layer.length;i++)
        ManageSanitizeImg(document.getElementsByName(colObj.Layer[i].id)[0],colObj.Layer[i]);
    }
  });
}

function ManageSanitizeImg(el,colObj){
  var img = el.getElementById(el.get('id')+'_'+'sanitized');
  if ((colObj.enable_HTML || Left(colObj.field,5)=='html:') && (colObj.sanitize=='none')){
    img.set('class','file-item-notsanitized')
    img.set('title','Not sanitized')
  }
  else {
    img.set('class','file-item-sanitized')
    img.set('title','Sanitized');
  }
}

function ManageOrderByImages() {
  document.getElementById("columns").getChildren().each(function(el) {
    var myid = el.get('name');
    var img = el.getElementById(el.get('id')+'_'+'order');
    var colObj = GetColumnById(myid);
    if (Empty(colObj.orderbystatus)) {
      img.set('src','./images/not_ordered.png');
      img.set('title','not ordered');
    } else {
      img.set('src','./images/orderby_'+colObj.orderbystatus+'_'+colObj.orderbyidx+'.png');
      img.set('title', colObj.orderbystatus +' order, sequence: '+colObj.orderbyidx);
    }
  });
}
function ManageFlagImages() {
  var flds = ReturnUsedFields();
  document.getElementById("list").getChildren().each(function(el) {
    var myname = el.get('name');
    var img = el.getElementById(el.get('id')+'_'+'flag');
    if (myname in flds.col) {
      img.set('src','../visualweb/images/flag_green.png');
      img.set('title','Field in grid');
    } else if (myname in flds.collayer) {
      img.set('src','../visualweb/images/flag_green.png');
      img.set('title','Field in column layer');
    } else if (myname in flds.rowlayer) {
      img.set('src','../visualweb/images/flag_green.png');
      img.set('title','Field in row layer');
    } else if (myname in flds.hidden) {
      img.set('src','../visualweb/images/flag_gray.png');
      img.set('title','Field hidden');
    } else {
      img.set('src','../visualweb/images/flag_red.png');
      img.set('title','Field excluded');
    }
  });
}

function UpdateVqrFields(first_time) {
  new JSURL(SPWebRootURL+"/servlet/SPVZMProxy?action=vqr_fields&table="+URLenc(formProp.table)+"&vqr="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode) ,true,function(response){
    selectedItems=[];
    var res=response.Response()
    if (!Empty(res))
      vqrfields = JSON.parse(res);
    else vqrfields=[]
    if (first_time) {
      vqrlist.UpdateList(vqrfields);
    } else {
      vqrlist.Empty();
      vqrlist.AppendItems(vqrfields);
    }
    // document.getElementById('list').nanoScrollerMT()
    ManageFlagImages();
  });
}

function UpdateField(colObj) {
  for (var j=0;j<colObj.length;j++) {
    var otherCols = colObj[j].Layer;
    colObj[j].Layer = [];
    var i = LibJavascript.Array.indexOf(vqrfields,colObj[j].field,function(elArray, fldName) {
      return elArray.alias==fldName;
    });
    if (i>-1) {
      vqrfields[i].column = colObj[j];
    }
    for (i = 0; i<otherCols.length; i++) {
      UpdateField(otherCols[i]);
    }
  }
}

function _togglePreview() {
  last_index=null;
  if (itemsHTML[index]) {
    itemsHTML[index].element.removeClass('selected');
  }
  togglePreview();
}

var RowViewLayer, viewrowopen=false;
function toggleRowView() {
  if (columnsObj.length>0) {
    RowViewLayer=new spModalLayer('../portalzoom/rowview.jsp',{'in_iframe':true,
       'draggable':true,
      // 'top':40,
      // 'left':20,
      // 'resizable' :true,
      'width': document.body.clientWidth ,
      'height': document.body.clientHeight ,
      'border_color':'#CCCCCC',
      'border_width':1,
      'dragger_height':12,
      'dragger_image':'../portalstudio/images/ps-editor-drag.png',
      'mask_opacity':0.4,
      'mask_color':'#CCCCCC',
      'show_scrollbars':false,
      'close_on_click_mask':'',
      'iframe_padding':0,
      'hide_close_btn':true,
      // 'maximize':true,
      'maximized':true,
      'opener':window
    });
    RowViewLayer.open();
    viewrowopen=true;
  }
}
function toggleSecondaryBarView(){
  var listExtraTitle=[];
  var i, j;
  selectedExtraTitle=[];
  var extratitleDiv=document.getElementById('orderExtraTitle');
  if (extratitleDiv.style.display=='none'){
    for (i=0; i<columnsObj.length; i++){
      if (columnsObj[i].show_extra_title){
        listExtraTitle.push({
          id:columnsObj[i].id,
          title:columnsObj[i].title,
          field:columnsObj[i].field,
          extracolidx:columnsObj[i].extracolidx
        })
      }
      for (j=0; j<columnsObj[i].Layer.length; j++){
        if (columnsObj[i].Layer[j].show_extra_title)
          listExtraTitle.push({
            id:columnsObj[i].Layer[j].id,
            title:columnsObj[i].Layer[j].title,
            field:columnsObj[i].Layer[j].field,
            extracolidx:columnsObj[i].Layer[j].extracolidx
          })
      }
    }
    for (i=0; i<rowLayerObj.length; i++){
      if (rowLayerObj[i].show_extra_title)
        listExtraTitle.push({
          id:rowLayerObj[i].id,
          title:rowLayerObj[i].title,
          field:rowLayerObj[i].field,
          extracolidx:rowLayerObj[i].extracolidx
        })
    }
    if (listExtraTitle.length>0){
      listExtraTitle.sort(function(c1,c2){//ordino l'array temp in base all'idx
        var res=c1.extracolidx-c2.extracolidx;
        return res;
      });
      if (!extratitlelist){
        extratitlelist = new ZList("extratitle",{
          aliasName: "field",
          idName: "id",
          descName: "title",
          cssClassItem: "file-item",
          sortable: true,
          onClick: function(el,evt,container) {
            var oldSel = LibJavascript.CssClassNameUtils.getElementsByClassName('selected-file',container,"div");
            for (var j=0; j<oldSel.length;j++) {
              LibJavascript.CssClassNameUtils.removeClass(oldSel[j],'selected-file');
              selectedExtraTitle.splice(selectedExtraTitle.indexOf(oldSel[j]),1);
            }
            LibJavascript.CssClassNameUtils.addClass(el,'selected-file');
            selectedExtraTitle.push(el);
            unSelectItem();
          }
        });
      }
      extratitlelist.Empty();
      extratitlelist.UpdateList(listExtraTitle);
      extratitleDiv.style.display='block';
      document.getElementById("newcolumncontainercinema").style.display='block';
      extratitleDiv.style.left=window.getSize().x/2-extratitleDiv.getSize().x/2+'px'
      extratitleDiv.style.top=window.getSize().y/2-extratitleDiv.getSize().y/2+'px'
    }
    else PSAlert.alert('There aren\'t titles in secondary bar')
  }
  else{
    document.getElementById("newcolumncontainercinema").style.display='none';
    extratitleDiv.style.display='none';
  }
}

function confirmOrderExtraTitle(){
  document.getElementById('extratitle').getChildren().each(function(el,i) {
    var myid = el.get('name');
    var colObj = GetColumnById(myid)||GetRowLayerById(myid);
    if (colObj){
      colObj.extracolidx=i;
    }
  });
  document.getElementById('orderExtraTitle').style.display='none'
  document.getElementById("newcolumncontainercinema").style.display='none';
}

function closeOrderExtraTitle(){
  document.getElementById('orderExtraTitle').style.display='none'
  document.getElementById("newcolumncontainercinema").style.display='none';
}

function toggleManageFilters(){
  selectedExtraTitle=[];
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
      for (var j=0; j<columnsObj[i].Layer.length; j++){
        listFieldsForFilter+="<option value='"+Lower(columnsObj[i].Layer[j].field)+"'>"+columnsObj[i].Layer[j].title+"</option>";
      }
    }
    for (i=0; i<rowLayerObj.length; i++){
      listFieldsForFilter+="<option value='"+Lower(rowLayerObj[i].field)+"'>"+rowLayerObj[i].title+"</option>";
    }
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
      , 'action': function(){ openVZM(); }
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
  vqrlist = new ZList("list",{
    idName: "alias",
    aliasName: "alias",
    descName: "desc",
    cssClassItem: "file-item",
    images:[{ image:'../visualweb/images/flag_red.png' , title:'Not loaded', id:'flag', cssClass:'flag'}],
    onClick: function(el,evt,container) {
      if (!evt.ctrlKey) {
        var oldSel = LibJavascript.CssClassNameUtils.getElementsByClassName('selected-file',container,"div");
        for (var j=0; j < oldSel.length;j++) {
          LibJavascript.CssClassNameUtils.removeClass(oldSel[j],'selected-file');
          selectedItems.splice(selectedItems.indexOf(oldSel[j]),1);
        }
      }
      if (evt.ctrlKey && LibJavascript.CssClassNameUtils.hasClass(el,'selected-file')) {
        LibJavascript.CssClassNameUtils.removeClass(el,'selected-file');
        selectedItems.splice(selectedItems.indexOf(el),1);
      } else {
        LibJavascript.CssClassNameUtils.addClass(el,'selected-file');
        selectedItems.push(el);
      }
      unSelectItem()
    },
    moverMsg:'Move selected fields to your configuration',
    moverImage:'../visualquery/images/move_to_zone.png',
    onMoverMouseDown:function(handler,el,evt/*,container*/){
      unSelectItem();
      if (LibJavascript.CssClassNameUtils.hasClass(el,'selected-file')) {
        var mooevt = new DOMEvent(evt,window);
        mooevt.stop();
        var pos = document.id(handler).getCoordinates();
        var html="", sep = ""
        for (var i=0; i < selectedItems.length;i++) {
          html+= sep+document.id(selectedItems[i]).get('name');
          sep = "<br/>";
        }
        var clone = new Element('span',{'class':'dragged'}).setStyles({'z-index':999,'top':pos.top,'left':pos.left+10,'cursor':'default'}).set('html',html);
        clone.inject(document.body);
        [document.getElementById('columns'),document.getElementById('rowlayer'),document.getElementById('hidefields')].combine($$('.fieldset-column-layer'));
        var drag = new Drag.Move(clone, {

          onBeforeStart: function() {
            columnsList.MakeDroppableElements();
            rowLayerList.MakeDroppableElements();
            this.droppables = [document.getElementById('hidefields')];
            if (document.getElementById('columns').childNodes.length==0)
              this.droppables.push(document.getElementById('columns'));
            if (document.getElementById('rowlayer').childNodes.length==0)
              this.droppables.push(document.getElementById('rowlayer'));
            this.droppables.combine($$('.droppableItem'))
          },
          onDrop: function(dragging, drop){
            dragging.destroy();
            if (drop != null){
              SetUpdated();
              var selectedFields = GetSelectedFields();
              if (drop.hasClass("column-layer-element")) {
                AddColumnLayer(drop.parentNode.get('name'),selectedFields);
              } else if (drop.hasClass("phantom-span") ) {
                var beforeOf = drop.getNext();
                beforeOf = ( beforeOf ? beforeOf.get("name") : null);
                if (drop.getParent().hasClass('file-item-column-layer') ) { // sottolivello, solo il column layer ha due livelli
                  var containerID = drop.getParent().getParent().getParent().get("name");
                  AddColumnLayer(containerID,selectedFields,beforeOf);
                } else { //livello principale
                  var container = drop.getParent().get('id');
                  if ( container == 'columns' )
                    AddColumns(selectedFields, beforeOf);
                  else if ( container == 'rowlayer' )
                    AddRowLayer(selectedFields, beforeOf);
                }
              } else if (drop.get('id')=='columns') AddColumns(selectedFields);
              else if (drop.get('id')=='rowlayer') AddRowLayer(selectedFields);
              else if (drop.get('id')=='hidefields') AddHideFields(selectedFields);
            }
            columnsList.RemoveDroppableElements();
            rowLayerList.RemoveDroppableElements();
            document.getElementById('columns').removeClass('droppable_container');
            document.getElementById('rowlayer').removeClass('droppable_container');
            document.getElementById('hidefields').removeClass('droppable_container');
          },
          onEnter: function(dragging, droppable){
            if (['columns','rowlayer','hidefields'].indexOf(droppable.get('id'))>-1 ) {
              droppable.addClass('droppable_container');
            } else {
              var parents = droppable.getParents();
              if (parents.indexOf(document.getElementById('columns'))>-1)
                columnsList.ResponsiveViewOnEnter(droppable);
              else if (parents.indexOf(document.getElementById('rowlayer'))>-1)
                rowLayerList.ResponsiveViewOnEnter(droppable);
            }
          },
          onLeave: function(dragging, droppable){
            droppable.removeClass('phantom-span_hover');
            droppable.removeClass('droppable_container');
          },
          onCancel: function (dragging) {
            dragging.destroy();
            columnsList.RemoveDroppableElements();
            rowLayerList.RemoveDroppableElements();
            document.getElementById('columns').removeClass('droppable_container');
            document.getElementById('rowlayer').removeClass('droppable_container');
            document.getElementById('hidefields').removeClass('droppable_container');
          }
        });
        drag.start(mooevt);
      }
    }
  });
  if (!Empty(configname)){
    new JSURL(SPWebRootURL+"/servlet/SPVZMProxy?action=load&table="+URLenc(tablename)+"&configname="+URLenc(configname) + "&Custom="+URLenc(custom)+"&offlinemode="+URLenc(offlinemode),true,function(response){
      try {
        jsonconfiguration = JSON.parse(response.Response());
      } catch (e) {
        alert('Errore in caricamento del def');
        return;
      }
      var i, c;
      columnsObj = jsonconfiguration.cols;
      //Viene rimossa la vecchia prop. maxwidth
      for(c=0;c<columnsObj.length;c++){
        var col=columnsObj[c];
        if(!Empty(col.maxwidth) && col.maxwidth==col.width)
          col.fixedwidth=col.width;
      }
      columnsList.UpdateList(columnsObj);
      ManageOrderByImages();
      ManageSanitizeImages();
      formProp.query = jsonconfiguration.config.vqrname;
      formProp.table = tablename;
      for (i=0;i<globalProps.length;i++) {
        if ( typeof (jsonconfiguration.config[globalProps[i]])!='undefined' && jsonconfiguration.config[globalProps[i]]!='undefined' )
          formProp[globalProps[i]] = jsonconfiguration.config[globalProps[i]];
      }
      baseCustomization.custom = formProp.custom = jsonconfiguration.config.Custom.toString();
      var tmpconfigname = configname;
      if (jsonconfiguration.config.User) {
        baseCustomization.user_group = formProp.user_group = 'User';
        tmpconfigname = Strtran(tmpconfigname,"_"+jsonconfiguration.config.User,"");
        baseCustomization.user = jsonconfiguration.config.User;
      } else if (jsonconfiguration.config.Group) {
        baseCustomization.user_group = formProp.user_group = 'Group';
        tmpconfigname = Strtran(tmpconfigname,"_g"+jsonconfiguration.config.Group,"");
        baseCustomization.group = jsonconfiguration.config.Group;
      } else {
        formProp.user_group = '';
      }

      baseCustomization.name = formProp.name = tmpconfigname;
      formProp.user = jsonconfiguration.config.User;
      formProp.group = jsonconfiguration.config.Group;
      if (jsonconfiguration.config.activateCheckboxAll=='true'){ // vecchia propriet� non + usata
        formProp.activateCheckbox='true-selectAll'
      }
      FormProperties( true );

      rowLayerObj = jsonconfiguration.rowlayer;
      rowLayerList.UpdateList(rowLayerObj);
      ManageSanitizeImages(true);
      hiddenFieldsObj = TransformHiddenFields(Object.keys(jsonconfiguration.hiddenfields));
      hidefieldsList.UpdateList(hiddenFieldsObj);

      UpdateVqrFields(true);
      // document.getElementById('columns').nanoScrollerMT()
      // document.getElementById('hidefields').nanoScrollerMT();
      // document.getElementById('rowlayer').nanoScrollerMT();
      if (jsonconfiguration.config.actions){
        for (i=0; i<jsonconfiguration.config.actions.length; i++){
          addAction(jsonconfiguration.config.actions[i],true);
        }
      }
      if (jsonconfiguration.config.linkedConfs){
        for (i=0; i<jsonconfiguration.config.linkedConfs.length; i++){
          addNewLinkedConf(jsonconfiguration.config.linkedConfs[i],true);
        }
      }
      filtersObj = jsonconfiguration.filters;
    });
  }
  else {
    new JSURL(SPWebRootURL+"/servlet/SPVZMProxy?action=BOName&table="+URLenc(tablename)+"&offlinemode="+URLenc(offlinemode),true,function(response){
      formProp.query=response.Response();
      formProp.table = tablename;
      formProp.GridRows = "30";
      columnsList.UpdateList(columnsObj);
      ManageOrderByImages();
      ManageSanitizeImages();
      rowLayerList.UpdateList(rowLayerObj);
      ManageSanitizeImages(true);
      hidefieldsList.UpdateList(hiddenFieldsObj);
      UpdateVqrFields(true);
      FormProperties()
      // document.getElementById('columns').nanoScrollerMT()
      // document.getElementById('hidefields').nanoScrollerMT();
      // document.getElementById('rowlayer').nanoScrollerMT();
    })
  }

  columnsList = new ZList("columns",{
      idName: "id",
      aliasName: "field",
      descName: "title",
      cssClassItem: "file-item",
      sortable: true,
      itemContainsItem : true,
      cssClassContainerItem: 'column-layer',
      containerTitle: "Column layer's fields",
      subItemsName:"Layer",
      isSortableElement:function(el) {
        return LibJavascript.CssClassNameUtils.hasClass(el,'selected-file');
      },
      images:[{ image:'./images/not_ordered.png' , title:'Not ordered', id:'order', cssClass:'order'},
      { image:{value:'&#xe6fc;'} , title:'Sanitized', id:'sanitized', cssClass:'sanitized'}],
      buttons: [
       {image:'' , title:"Edit"  , functionName:"EditColumn" , cssClass:"edit"}
      ,{image:'', title:"Delete", functionName:"DeleteColumn", cssClass:"delete"}
      ],
      onClick: function(el,evt,container) {
        // if (!evt.ctrlKey) {
        var oldSel = LibJavascript.CssClassNameUtils.getElementsByClassName('selected-file',container,"div");
        for (var j=0; j<oldSel.length;j++) {
          LibJavascript.CssClassNameUtils.removeClass(oldSel[j],'selected-file');
          selectedColumns.splice(selectedColumns.indexOf(oldSel[j]),1);
        }
        // }
        // if (evt.ctrlKey && LibJavascript.CssClassNameUtils.hasClass(el,'selected-file')) {
          // LibJavascript.CssClassNameUtils.removeClass(el,'selected-file');
          // selectedColumns.splice(selectedColumns.indexOf(el),1);
        // } else {
          LibJavascript.CssClassNameUtils.addClass(el,'selected-file');
          selectedColumns.push(el);
        // }
        unSelectItem();
      },
      onMove: function(itmId, oldContId, newContId, elementIdNearTo , mode) {
        var colArray;
        if (!Empty(oldContId)) {
          colArray = columnsObj[GetColIndexById(columnsObj,oldContId)].Layer;
        } else {
          colArray = columnsObj;
        }
        var removed = colArray.splice(GetColIndexById(colArray,itmId),1);
        if (!Empty(newContId)) { //in column layer
          colArray = GetColumnById(newContId).Layer;
        } else { //non in column layer
          colArray = columnsObj;
        }
        if (!Empty(elementIdNearTo)) {
          var indexToPut = GetColIndexById(colArray,elementIdNearTo);
          if (mode=="after") indexToPut++;
          colArray.splice(indexToPut,0,removed[0]);
          if (removed[0].Layer.length>0) {
            removed = removed[0].Layer.splice(0,removed[0].Layer.length);
            Array.prototype.splice.apply(colArray,[indexToPut+1,0].concat(removed));
          }
        } else { //inserisco in coda
          colArray.push(removed[0]);
          if (removed[0].Layer.length>0) {
            removed = removed[0].Layer.splice(0,removed[0].Layer.length);
            colArray.append(removed);
          }
        }
        SetUpdated();
      }
  });
  //LibJavascript.JSONUtils.adjust(columnsObj, getColSchema());
  document.getElementById("columns").makeResizable({handle: "columns_drag", limit: {'y':[0]}, modifiers:{'x':''},
        onDrag: function(el){
          document.getElementById("columns_arrows").style.height= (el.getStyle('height').toInt()+50)+"px";
        }
        // onComplete: function(el){
          // el.nanoScrollerMT()
        // }
  });

  rowLayerList = new ZList("rowlayer",{
      aliasName: "field",
      idName: "id",
      descName: "title",
      cssClassItem: "file-item",
      sortable: true,
      images:[{ image:{value:'&#xe6fc;'} , title:'Sanitized', id:'sanitized', cssClass:'sanitized'}],
      buttons: [
       {image:'' , title:"Edit"  , functionName:"EditRowLayer" , cssClass:"edit"}
      ,{image:'', title:"Delete", functionName:"DeleteRowLayer", cssClass:"delete"}
      ],
      onClick: function(el,evt,container) {
        var oldSel = LibJavascript.CssClassNameUtils.getElementsByClassName('selected-file',container,"div");
        for (var j=0; j<oldSel.length;j++) {
          LibJavascript.CssClassNameUtils.removeClass(oldSel[j],'selected-file');
          selectedRowLayer.splice(selectedRowLayer.indexOf(oldSel[j]),1);
        }
        LibJavascript.CssClassNameUtils.addClass(el,'selected-file');
        selectedRowLayer.push(el);
        unSelectItem();
      },
      onMove: function(itmId, oldContId, newContId, elementIdNearTo , mode) {
        SetUpdated();
        var removed = rowLayerObj.splice(GetColIndexById(rowLayerObj,itmId),1);
        if (!Empty(elementIdNearTo)) {
          var indexToPut = GetColIndexById(rowLayerObj,elementIdNearTo);
          if (mode=="after") indexToPut++;
          rowLayerObj.splice(indexToPut,0,removed[0]);
        } else { //inserisco in coda
          rowLayerObj.push(removed[0]);
        }
        SetUpdated();
      }
  });
  document.getElementById("rowlayer").makeResizable({handle: "rowlayer_drag", limit: {'y':[0]}, modifiers:{'x':''},
        onDrag: function(el){
          document.getElementById("rowlayer_arrows").style.height= (el.getStyle('height').toInt()+50)+"px";
        }
        // onComplete: function(el){
          // el.nanoScrollerMT()
        // }
  });

  hidefieldsList = new ZList("hidefields",{
      aliasName: "field",
      idName: "field",
      cssClassItem: "file-item",
      buttons: [
        {image:'', title:"Delete", functionName:"DeleteHidddenField", cssClass:"delete"}
      ],
      onClick: function(el,evt,container) {
        if (!evt.ctrlKey) {
          var oldSel = LibJavascript.CssClassNameUtils.getElementsByClassName('selected-file',container,"div");
          for (var j=0; j<oldSel.length;j++) {
            LibJavascript.CssClassNameUtils.removeClass(oldSel[j],'selected-file');
            selectedHideFields.splice(selectedHideFields.indexOf(oldSel[j],1));
          }
        }
        if (evt.ctrlKey && LibJavascript.CssClassNameUtils.hasClass(el,'selected-file')) {
          LibJavascript.CssClassNameUtils.removeClass(el,'selected-file');
          selectedHideFields.splice(selectedHideFields.indexOf(el,1));
        } else {
          LibJavascript.CssClassNameUtils.addClass(el,'selected-file');
          selectedHideFields.push(el);
        }
        unSelectItem();
      }
  });
  document.getElementById("hidefields").makeResizable({handle: "hidefields_drag", limit: {'y':[0]}, modifiers:{'x':''},
        onDrag: function(el){
          document.getElementById("hidefields_arrows").style.height= (el.getStyle('height').toInt()+50)+"px";
        }
        // onComplete: function(el){
          // el.nanoScrollerMT()
        // }
  });
  document.getElementById("newcolumn").addEvent('click',function() {
    document.getElementById("newcolumncontainer").style.display='block';
    document.getElementById("newcolumncontainercinema").style.display='block';
    document.getElementById("columntext").value='';
    document.getElementById("newcolumncontainer").style.left=window.getSize().x/2-document.getElementById("newcolumncontainer").getSize().x/2+'px'
    document.getElementById("newcolumncontainer").style.top=window.getSize().y/2-document.getElementById("newcolumncontainer").getSize().y/2+'px'
  });
  document.getElementById("newfilter").addEvent('click',function() {
    addFilter();
  });
  document.getElementById("refreshfields").addEventListener('click', function() {
    UpdateVqrFields(false);
  })
});
function closeNewColumn(save) {
  var bOk=true
  if (save) {
    var val=document.getElementById("columntext").value;
    if (val=="") {
      // alert('insert a value');
      // bOk=false;
      AddColumns([{ alias: '', desc: 'Empty column', title: ''}]);
    } else {
      AddColumns([{alias: 'html:'+val, title: ''}]);
    }
  }
  if (bOk) {
    document.getElementById("newcolumncontainer").style.display='none';
    document.getElementById("newcolumncontainercinema").style.display='none';
  }
}
function SetUpdated() {
  m_bUpdated=true;
}
function GetTableName() {
 return formProp.table;
 }
function GetConfigName() {
 return (formProp.custom=="true"?"1":"0")+"/"+formProp.name+(Lower(formProp.user_group)=='user'?'/'+jsonconfiguration.config.User:(Lower(formProp.user_group)=='group'?'/g'+jsonconfiguration.config.Group:''));
}
function GetSelectedFields() {
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

function GetMaxColumnOrderbyIdx() {
  var orderbyidx=0;
  for (var i=0;i<columnsObj.length;i++) {
    orderbyidx = Max(columnsObj[i].orderbyidx,orderbyidx);
  }
  return orderbyidx;
}

function GetSelectedColId(htmlList,cols,propName) {
  propName=propName || "id";
  for (var j=0;j<htmlList.length;j++) {
    var myname = htmlList[j].get('name');
    var colIdx=-1, layIdx=-1;
    colIdx = LibJavascript.Array.indexOf(cols,myname,function(elArray) {
                if (elArray[propName]==myname) {
                  return true;
                } else if (elArray.Layer && elArray.Layer.length>0){
                  layIdx = LibJavascript.Array.indexOf(elArray.Layer,myname, function(elLay) {
                    return myname==elLay[propName];
                  });
                  if (layIdx>-1) return true;
                }
              });
    if (layIdx>-1) {
      return {contId : cols[colIdx][propName], id :cols[colIdx].Layer[layIdx][propName]}; //selezione singola!!
    } else if (colIdx>-1){
      return cols[colIdx][propName]; //selezione singola!!
    }
  }
}
function GetColIndexById(arr,id) {
  return LibJavascript.Array.indexOf(arr,id,function(el) {
    return id==el.id;
  });
}
function GetColumnById(id, contId) {
  var colArray;
  if (!Empty(contId))
    colArray = columnsObj[GetColIndexById(columnsObj,contId)].Layer;
  else
    colArray = columnsObj;
  var index = GetColIndexById(colArray,id);
  if (index>-1) {
    var myObj = colArray[index];
    if (Empty(contId)) {
      myObj.maxorderbyidx=GetMaxColumnOrderbyIdx()+1;
      myObj.orderbystatus=myObj.orderbystatus||'';
    }
    return myObj;
  } else return null;
}

function SetColumnOrder(id, beforeOtherCols) {
 var cols=[];
 for (var i=0;i<columnsObj.length;i++) {
  if (columnsObj[i].orderbyidx)
    cols.push(columnsObj[i]);
 }
 cols.sort(function (a,b) {
  if (a.orderbyidx==b.orderbyidx) {
    if (a.id==id)
      return (beforeOtherCols?-1:1);
    else if(b.id==id)
      return (beforeOtherCols?1:-1);
    else
      return 0;
  } else
    return a.orderbyidx-b.orderbyidx;
 });
 var last=0;
 for (i=0;i<cols.length;i++) {
  if (cols[i].orderbyidx-1 != last)
    cols[i].orderbyidx = (++last);
  else
    last = cols[i].orderbyidx;
 }
}
function SetColumn(id,obj, contId) {
  SetUpdated();
  var colArray;
  if (!Empty(contId))
    colArray = columnsObj[GetColIndexById(columnsObj,contId)].Layer;
  else
    colArray = columnsObj;

  var index = GetColIndexById(colArray,id);
  delete obj.maxorderbyidx;
  delete colArray[index].maxorderbyidx;
  var beforeOtherCols=false;
  if (index>-1) {
    if (Empty(contId))
      beforeOtherCols = colArray[index].orderbyidx > obj.orderbyidx;
    colArray[index] = LibJavascript.JSONUtils.adjust(obj, colArray[index]);
    columnsList.UpdateItem(id,contId, colArray[index]);
  }
  if (Empty(contId)) {
    SetColumnOrder(id,beforeOtherCols);
    ManageOrderByImages();
  }
  ManageSanitizeImg(document.getElementsByName(id)[0],obj);
}
function EditColumn(idx, contId) {
  unSelectItem();
  openSPModalLayer("../jsp-system/SPPortalZoomColumnSettings_portlet.jsp?columnid="+URLenc(idx)+"&type=Column"+(!Empty(contId)?"&contId="+URLenc(contId):""), 100, 100, 660, 545, false, 1, false,false,null,true)
}
function DeleteColumn(id, contId) {
  unSelectItem();
  SetUpdated();
  if (typeof(id)=='object') {
    contId = id.contId;
    id = id.id;
  }
  var columnArray;
  if (!Empty(contId)) {
    var col = GetColumnById(contId);
    if (col)
      columnArray = col.Layer;
    else //id non presente
      columnArray = columnsObj;
  } else {
    columnArray = columnsObj;
  }
  var index = GetColIndexById(columnArray,id);
  if (index>-1) {
    var oldCol = columnArray.splice(index,1);
    UpdateField(oldCol);
    columnsList.RemoveItems(oldCol, contId);
    SetColumnOrder();
    ManageOrderByImages();
    ManageFlagImages();
  }
  // document.getElementById('columns').nanoScrollerMT();
}

function GetRowLayerById(id) {
  var index = GetColIndexById(rowLayerObj,id);
  if (index>-1) return rowLayerObj[index];
  else return null;
}
function SetRowLayer(id,obj,contId) {
  SetUpdated();
  var index = GetColIndexById(rowLayerObj,id);
  if (index>-1) {
    rowLayerObj[index] = LibJavascript.JSONUtils.adjust(obj, rowLayerObj[index]);
    rowLayerList.UpdateItem(id,contId, rowLayerObj[index]);
    ManageSanitizeImg(document.getElementsByName(id)[0],obj);
  }
}

function EditRowLayer(idx) {
  unSelectItem();
  openSPModalLayer("../jsp-system/SPPortalZoomColumnSettings_portlet.jsp?columnid="+URLenc(idx)+"&type=RowLayer", 100, 100, 640, 515, false, 1, false,false,null,true);
}

function DeleteHidddenField(name) {
  unSelectItem();
  SetUpdated();
  var index = LibJavascript.Array.indexOf(hiddenFieldsObj,name,function(el) {
    return name==el.field;
  });
  if (index>-1) {
    var oldCol = hiddenFieldsObj.splice(index,1);
    hidefieldsList.RemoveItems(oldCol);
    ManageFlagImages();
  }
  // document.getElementById('hidefields').nanoScrollerMT();
}

function DeleteRowLayer(id) {
  unSelectItem();
  SetUpdated();
  var index = GetColIndexById(rowLayerObj,id);
  if (index>-1) {
    var oldCol = rowLayerObj.splice(index,1);
    rowLayerList.RemoveItems(oldCol);
    ManageFlagImages();
  }
  // document.getElementById('rowlayer').nanoScrollerMT();
}

function GetCurrentName() {
  var filename = (formProp.custom=="true"?"CUSTOM_":"")+formProp.name+"_"+formProp.table;
  if (formProp.user_group=='User')
    filename +=  "_" + formProp.user;
  else if (formProp.user_group=='Group')
    filename +=  "_g" + formProp.group;

  return filename;
}

function GetResourceName(parms) {
  return '../jsp/SPPortalZoomBase_portlet.jsp?Table='+URLenc(GetTableName())+'&ConfigName='+URLenc(GetConfigName())+'&m_NoCache='+LibJavascript.AlfaKeyGen(10)+parms;
}

function selectForm(){
  FormProperties();
}

function GetRequestParams() { //Oggetto nome -> [{description, type, len, dec} | tipo ]
  var result = {};
  var url = new JSURL("../servlet/SPVQRProxy?action=vqrparameters&filename="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode),true);
	var output=url.Response();
	output = JSON.parse(output);
  for (var i=0;i<output.length;i++) {
    var nameVar = output[i][0];
    if (Left(nameVar,2)!='w_') nameVar = 'w_'+nameVar;
    result[nameVar]={description: output[i][1], type:output[i][2], len: output[i][3], dec: output[i][4]};
  }
  return result;
}

function ManageQueryChange(oldValue, newValue) {
  if (confirm("Query name changed from \""+oldValue+"\" to \""+newValue+"\". Empty column configuration?")) {
    columnsObj=[];
    rowLayerObj = [];
    hiddenFieldsObj = [];
    selectedColumns=[];
    selectedRowLayer=[];
    selectedHideFields=[];
    /*columnsList.Empty();
    rowLayerList.Empty();
    hidefieldsList.Empty();*/
  }
}
function AfterQueryChange() {
  var output
  if (Left(formProp.query,3).toUpperCase()!='BO:') {
    var url = new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode),true);
    output=url.Response();
  } else {
    output="1";
  }
  if (parseInt(output)<1) {
    alert("ERROR: "+formProp.query+" is not a valid name for a query");
  } else {
    UpdateVqrFields(false);
  }
}

function addNewLinkedConf(linkedConf,dontUpdate){
  var select;
  if (!linkedConf){
    linkedConf={}
    linkedConf.title='Linked Configuration '+nItem;
    linkedConf.linkedConfName='Linked Configuration '+nItem;
    linkedConf.configname='';
    linkedConf.ontoolbar='false';
    linkedConf.ontabs='false';
    linkedConf.imagetoolbar='';
    linkedConf.imagetype='grid';
    select=true;
  }
  linkedConf.linkedConfName = linkedConf.linkedConfName || linkedConf.title || 'Linked Configuration '+nItem;
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
  nItem++;
  mySortables.addItems(newLinkedConf);
  document.getElementById('linkedConfList').adopt(newLinkedConf);
  if (select)
    selectItem(newLinkedConf)
  resizeGadgetsPane();
  if (!dontUpdate)
    SetUpdated();
}
function addAction(action,dontUpdate){
  var select;
  if (!action){
    action={}
    action.title='action'+nItem;
    action.actionName='action'+nItem;
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
    action.toExpose='false';
    select=true;
  }
  action.actionName = action.actionName || action.title || 'action'+nItem;
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
  nItem++;
  mySortables.addItems(newAction);
  document.getElementById('actionList').adopt(newAction);
  if (select)
    selectItem(newAction)
  resizeGadgetsPane();
  if (!dontUpdate)
    SetUpdated();
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
