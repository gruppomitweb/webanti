/* exported
    editPortlet selectPortlet SelectBO SelectReport ReportSelected EditReport loadEntityValue
    NewReport SelectPKFields SelectCfg EditCfg SelectQuery loadBOValue loadFieldName
    EditQuery updateProperties IsNumericInput EmptyOrIsNaturalInput IsObligatory
    IsLogicInput selectChartField getChartFieldValue SaveChartFieldsConfiguration
    LoadChartFieldsConfigurator NewVdmMask EditVdmMask SelectVdmMask NewQuery
    getIsForm receiveConfigFields GetChartWizardInitConf SetChartWizardConfiguration
  */

/*global offlinemode GetTableName configname ManageQueryChange AfterQueryChange
    columnsObj rowLayerObj hiddenFieldsObj viewFieldsConfigurator
*/

var formProp=new ZTObjects.formObj({});
var ps_props, TempArray=[];
if(Empty(localStorage.getItem('zucchetti_portleteditor_properties'))){
  ps_props = {'width':200,'top':45,'left':500,'opened':true,'opacity':1,'expandedToColumn':false,'columnSide':'none','form_closed':false};
  localStorage.setItem('zucchetti_portleteditor_properties', JSON.stringify(ps_props));
}else{
  ps_props = JSON.parse(localStorage.getItem('zucchetti_portleteditor_properties'));
}


function FormProperties(force_render,force_open){
  var mainobj=formProp;
  if(Empty(newFormPropObj) || force_render)
    newFormPropObj = new propertiesObj({m_obj:mainobj,isForm:true,canExpandToColumn:false,divcontainer:'formproperties',moveDiv:false,afterRender : resizeGadgetsPane});
  else
    newFormPropObj.updatePropertiesFromPaint(mainobj);
  if(force_open && ps_props.form_closed == true ) {togglePane();}

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

function selectPortlet(ref){
  PickItems('portlet',ref.refId,null, null, 930, 600);
}

function SelectBO(item) {
  var callerFunction = "loadBOValue";
  if (!item.hideLinkedTables) {
    item.hideLinkedTables = false;
  }
  if (item.hideLinkedTables) {
    callerFunction = "loadEntityValue";
  }
  var top = 100, left = 100;
  openSPModalLayer("../jsp-system/SPVQREditorSelectBO_portlet.jsp?callerFunction="+callerFunction+"&offlinemode="+URLenc(offlinemode)+"&hideLinkedTables="+item.hideLinkedTables, top, left, 500, 500, false, 1, false,false);
}
function SelectReport () {
  var ctrlId = "Form_Generic_ReportName";
  var url = "../portalstudio/open.jsp?tool=smartreport&onetool=true&ExpressionID=" + URLenc( ctrlId ) + "&callerFunction=ReportSelected";
  OpenWindow( url, 850, 600 );
}
function ReportSelected (ctrlId, value) {
  formProp.ReportName = value;
  FormProperties();
}
function EditReport () {
  var reportName = formProp.ReportName
    , extIdx = reportName.indexOf( '.svrp' )
    ;
  if ( extIdx > 0 ) {
    reportName =  reportName.substring( 0, extIdx );
  }
  if ( parent.newCurrentObj && parent.location.href.indexOf( 'portalstudio.jsp') != -1 ) {
    parent.newCurrentObj( reportName, 'smartreport', {} );
  } else {
    OpenWindow( '../smartreport/smartreport.jsp?id=' + reportName, 800, 600, 0, 0, 'resizable=yes,status=no,toolbar=no,menubar=no,location=no' );
  }
}
function NewReport () {
  if ( parent.newCurrentObj && parent.location.href.indexOf( 'portalstudio.jsp') != -1 ) {
    parent.newCurrentObj( 'New', 'smartreport', {} );
  } else {
    OpenWindow( '../smartreport/smartreport.jsp?', 800, 600, 0, 0, 'resizable=yes,status=no,toolbar=no,menubar=no,location=no' );
  }
}

function SelectPKFields() {
  TempArray = [];
  for (var i=0;i<vqrfields.length;i++) {
    TempArray.push(vqrfields[i].alias);
  }
  window.layerOpenForeground("../visualweb/select_fields.html?isForm=true&isMultiple=true&rtrnobj=PKFields&queryname="+URLenc(formProp.query)+"&offline="+URLenc(offlinemode),"SelectConfiguration",'',350,500,true,1);
  // window.layerOpenForeground("../visualweb/select_fields.html?isForm=true&isMultiple=true&rtrnobj=PKFields" ,"SelectConfiguration",'',350,500,true,1);
}
function SelectCfg(/*item*/) {
  var portletFiles
  if( itemsHTML[index].configtype=='pivot')
    portletFiles = new JSURL("../servlet/JSPReader?type=visualpivot");
  else
    portletFiles = new JSURL("../servlet/JSPReader?type=portalzoom&tablename="+GetTableName());
  portletFiles = portletFiles.Response();
  TempArray=portletFiles.replaceAll(".vpv", "").split(",");
  var idx = TempArray.indexOf(configname);
  if (idx>-1) {
    TempArray.splice(idx,1);
  }
  window.layerOpenForeground("../visualweb/select_fields.html?for=" + index +"&rtrnobj=configname","SelectConfiguration",'',350,500,true,1);
}

function EditCfg(/*item*/){
  if(LRTrim(itemsHTML[index].configname)=="")
    PSAlert.alert("No zoom configuration selected.");
  else if(parent.newCurrentObj!=null) {
    if( itemsHTML[index].configtype=='pivot')
      parent.newCurrentObj(itemsHTML[index].configname,"visualpivot",{offlinemode:offlinemode});
    else
      parent.newCurrentObj(itemsHTML[index].configname+'['+GetTableName()+']',"portalzoom",{offlinemode:offlinemode});
  }
  else {
    if( itemsHTML[index].configtype=='pivot')
      window.open("'../visualpivot/editor.jsp?&ConfigName="+URLenc(itemsHTML[index].configname),"visualpivot","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
    else
      window.open("'../portalzoomeditor.jsp?&Table="+GetTableName()+"&ConfigName="+URLenc(itemsHTML[index].configname),"Chartdef","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function SelectQuery(){
  var top = 100, left = 100;
  openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_list.jsp?action=queryName&parameter="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode)+"&SPModalLayerId=mskSPModalLayer", top, left, 500, 500, false, 1, false,false);
}
function loadEntityValue(value,module,entityType) {
  formProp.Autozoom=Substr(value,4);
  formProp.entityType=entityType;
  FormProperties();
}
function loadBOValue(value/*,module*/) {
  loadValue("queryName",value);
}
function loadValue(action,value) {
  if (action=="queryName"){
  if (value!=formProp.query) {
    ManageQueryChange(formProp.query, value);
    formProp.query=value;
    AfterQueryChange();
    FormProperties();
  }
}
  else if (action=="dependsOn"){
    if (value!=formProp.valueFields) {
      formProp.valueFields=value;
      FormProperties();
    }
  }
}

function loadFieldName(value/*,action*/){
  if (value!=formProp.labelField) {
    formProp.labelField=value;
    FormProperties();
  }
}

function EditQuery(/*index*/) {
  if(Lower(Left(formProp.query,3))=="bo:")
    PSAlert.alert("You cannot edit a BO.");
  else if(LRTrim(formProp.query)=="")
    PSAlert.alert("No query selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj(formProp.query,"visualquery",{offlinemode:URLenc(offlinemode)});
  else
    window.open("../visualquery/index.jsp?filename="+formProp.query+"&offlinemode="+URLenc(offlinemode),"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function NewQuery() {
  if(parent.newCurrentObj!=null)
    parent.newCurrentObj('New','visualquery',{offlinemode:URLenc(offlinemode)});
  else
    window.open("../visualquery/index.jsp","visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}

function updateProperties(input,the_property,propertyType,isForm,value,updateHTML,reconvertFunc,validFunc,m_obj){
  updateHTML = (typeof(updateHTML) == "undefined") ? true : updateHTML;
  if(m_obj && (typeof(m_obj.updateHTML) != "undefined")) updateHTML = m_obj.updateHTML;
  var arrayProp;
  switch(the_property){
    case "query":
      if (isForm) {
        if(EmptyString(value)) {
          PSAlert.alert("Obligatory data input");
          setTimeout("document.getElementById('"+input.id+"').focus();",50);
          setTimeout("document.getElementById('"+input.id+"').select();",50);
          return;
        }
      }
  }
  if(reconvertFunc){
    value=window[reconvertFunc](value);
  }
  if(validFunc){
    var r = window[validFunc](value,the_property);
    if(r!=true){
      setTimeout("document.getElementById('"+input.id+"').focus();",50);
      setTimeout("document.getElementById('"+input.id+"').select();",50);
      return;
    }
  }
  if(isForm)
    arrayProp=formProp;
  else if(m_obj)
    arrayProp=m_obj;
  if(arrayProp[the_property]==value)return;

  switch(propertyType){
    case 'int': //solo valori numerici
      if(!Empty(value)){
        if(isNaN(value)){
          PSAlert.alert('Not a numeric value !');
          setTimeout("document.getElementById('"+input.id+"').focus();",50);
          setTimeout("document.getElementById('"+input.id+"').select();",50);
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
          selectForm();
          //return;
        }
    break;
    case 'pages':
      arrayProp[the_property]=value;
      if(updateHTML)
        writeHTML(true);
    break;
    default:
    //case 'str': case 'data': case 'select': case 'xmldata'://valori stringa
      if (isForm && the_property=='query') ManageQueryChange(arrayProp[the_property], value);
      arrayProp[the_property]=value;
      if (isForm && the_property=='query') AfterQueryChange();
      if(updateHTML)
        writeHTML();
  }
  m_bUpdated=true;
}

function IsNumericInput(v){
if(isNaN(v)){
  PSAlert.alert('Not a numeric value!');
  return false;
}else
  return true;
}
function EmptyOrIsNaturalInput(v){
  if (v==='') {
    return true;
  } else {
    return IsNaturalInput(v);
  }
}
function IsNaturalInput(v){
if(isNaN(v)){
  PSAlert.alert('Not a numeric value!');
  return false;
}else if (v <= 0) {
  PSAlert.alert('Not a positive value!');
  return false;
} else if(parseInt(v) != v) {
  PSAlert.alert('Not a natural value!');
  return false;
}else
  return true;
}

function IsObligatory(v){
if(Empty(v)){
  PSAlert.alert('Obligatory input value!');
  return false;
}else
  return true;
}

function IsLogicInput(v){
  if (!((Eq(v,'true')||Eq(v,'false')))){
    PSAlert.alert('Not a logic value!');
    return false;
  }
  return true;
}

function selectChartField(el){
  var listField=[],listDescription=[],columnName;
  var i, j;
  for (i=0; i<columnsObj.length; i++){
    columnName=columnsObj[i].field;
    if (listField.indexOf(columnName)==-1){
      listField.push(columnName);
      listDescription.push(columnsObj[i].title);
    }
    for (j=0; j<columnsObj[i].Layer.length; j++){
      columnName=columnsObj[i].Layer[j].field;
      if (listField.indexOf(columnName)){
        listField.push(columnName);
        listDescription.push(columnsObj[i].Layer[j].title);
      }
    }
  }
  for (i=0; i<rowLayerObj.length; i++){
    columnName=rowLayerObj[i].field;
    if (listField.indexOf(columnName)==-1){
      listField.push(columnName);
      listDescription.push(rowLayerObj[i].title);
    }
  }
  for (i=0; i<hiddenFieldsObj.length; i++){
    columnName=hiddenFieldsObj[i].field;
    if (listField.indexOf(columnName)==-1){
      listField.push(columnName);
      listDescription.push(hiddenFieldsObj[i].title);
    }
  }
  if (el.refPropId=="labelField"){
    openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_filterList.jsp?action=linkedFieldName&allField="+listField.toString()+"&allFieldDescription="+listDescription.toString()+"&fieldSelected="+formProp.labelField+"&SPModalLayerId=filterMskSPModalLayer", 100, 100, 500, 500, false, 1, false,false);
  }
  else {
    openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_list.jsp?action=dependsOn&parameter="+formProp.valueFields+"&allField="+listField.toString()+"&allFieldDescription="+listDescription.toString()+"&SPModalLayerId=mskSPModalLayer",100, 100, 500, 500, false, 1, false,false);
  }
}
function getChartFieldValue(vtype,ctype){
  var ret = "";
  switch(vtype){
    case "domain":
      if(ctype=="category")
        ret = formProp.labelField;
      else if(ctype=="xyz")
        ret = formProp.x_field;
      else
        ret = formProp.measure_series_field;
      break;
    case "values":
      if(ctype=="category")
        ret = formProp.valueFields;
      else if(ctype=="xyz")
        ret = formProp.y_field+","+formProp.z_field;
      else
        ret = formProp.min_field+","+formProp.max_field+","+formProp.val_field;
      break;
    case "series":
      if(ctype=="category")
        ret = formProp.label_series;
      else if(ctype=="xyz")
        ret = formProp.xyz_series_field;
      else
        ret = "";
      break;
    case "key":
      if(ctype=="category")
        ret = formProp.labelKey_field;
      else if(ctype=="xyz")
        ret = formProp.xKey_field;
      else
        ret = formProp.measureKey_series_field;
      break;
  }
  return ret;
}

function SaveChartFieldsConfiguration(ctype,domain,values,series,key){
  switch(Lower(ctype)){
    case "category":
      formProp.labelField=domain;
      formProp.valueFields=values;
      formProp.labelKey_field=key;
      formProp.label_series=series;
      break;
    case "xyz":
      formProp.x_field=domain;
      formProp.y_field=values.split(",")[0];
      formProp.z_field=Empty(values.split(",")[1])?"":values.split(",")[1];
      formProp.xyz_series_field=series;
      formProp.xKey_field=key;
      break;
    case "measure":
      formProp.measure_series_field=domain;
      formProp.min_field=values.split(",")[0];
      formProp.max_field=values.split(",")[1];
      formProp.val_field=values.split(",")[2];
      formProp.measureKey_series_field=key;
      break;
  }
  FormProperties();
}

function LoadChartFieldsConfigurator(){
  //LoadFieldsConfigurator(true,formProp.chartDef,formProp.chart_type,formProp.query);
  if (!Empty(arguments)) {
    var propid = arguments[0].refPropId;
    viewFieldsConfigurator(propid, true, formProp.query);
  }
}

function getIsForm(pQuery) {
  return (pQuery == formProp.query);
}

function receiveConfigFields(robj) {
  if (robj.isdataobj) {
    var msel = robj.Data,
    prop = robj.propid;
    if (msel.length > 1) {  // ultima stringa di check
      var val = "";
      for (var i = 0; i < msel.length - 1; i++) {
        val += (msel[i][0] + ",");
      }
      if (val.endsWith(","))
        val = val.slice(0, val.length - 1);
      formProp[prop] = val;
      FormProperties();
    }
  }
}

function NewVdmMask(/*index, isForm*/) { //REDIFINED
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj("New", "maskparameters",{} );
  }
  else {
    window.open("../maskparameters/maskparameters.jsp", "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function EditVdmMask(/*index, isForm*/) {
  var vdmFile = formProp.vdmfile;
  if (LRTrim(vdmFile) == "") {
    PSAlert.alert("No mask file selected.");
    return;
  }
  if (parent && parent.newCurrentObj != null && window.parent.location.href.indexOf("portalstudio.jsp") != -1) {
    parent.newCurrentObj(vdmFile, "maskparameters");
  }
  else {
    window.open("../maskparameters/maskparameters.jsp?filename=" + vdmFile, "maskparameters", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function SelectVdmMask(index, isForm, ctrlid) { //REDIFINED
  var width = 1000;
  var height = 600;
  var url = "../portalstudio/open.jsp?tool=maskparameters&onetool=true&ExpressionID=" + URLenc(ctrlid) + "&callerFunction=ExpressionBuilderReturn";
  var additionalUrl = "&SPModalLayerId=vdmSPModalLayer";
  openNewWindow(url, additionalUrl, height, width, -1, -1);
}

function GetChartWizardInitConf() {
  var conf = {};
  conf.def = formProp.chartDef;
  // wip - adeguamento campi senza dataprovider
  return conf;
}

function SetChartWizardConfiguration(obj) {
  if (!Empty(obj.def))
    formProp.chartDef = obj.def;
  else
    formProp.chartDef = "type:" + obj.type;
  formProp.ctype = obj.type;
  var macrotype = getChartMacroType(obj.type);
  if (obj.type == "PCOORDS" || obj.type == "VORONOI" || obj.type == "RINGPERC" || obj.type == "ASTER")
    formProp.chart_type = obj.type;
  else
    formProp.chart_type = macrotype;
  FormProperties();
}