/* exported
  SelectReport ReportSelected EditReport NewReport SelectPKFields SelectQuery
  loadValue loadFieldName EditQuery NewQuery updateProperties IsNumericInput
  EmptyOrIsNaturalInput IsObligatory IsLogicInput getIsForm receiveConfigFields
  NewVdmMask EditVdmMask SelectVdmMask getPropertyValue setPropertyValue
  SelectCfg EditCfg
*/
var formProp=new ZTObjects.formObj({});
var ps_props, TempArray=[];
if(Empty(Cookie.read('zucchetti_portleteditor_properties'))){
  ps_props = {'width':200,'top':45,'left':500,'opened':true,'opacity':1,'expandedToColumn':false,'columnSide':'none','form_closed':false};
  Cookie.write('zucchetti_portleteditor_properties', JSON.encode(ps_props), {duration: 365});
}else{
  ps_props = JSON.parse(Cookie.read('zucchetti_portleteditor_properties'));
}


function FormProperties(force_render,force_open){
  var clickChart = !Empty(formProp._fromChartUpdate);
  var mainobj=formProp;
  if(Empty(newFormPropObj) || force_render)
    newFormPropObj = new propertiesObj({m_obj:mainobj,isForm:true,canExpandToColumn:false,divcontainer:'formproperties',moveDiv:false,afterRender : resizeGadgetsPane});
  else
    newFormPropObj.updatePropertiesFromPaint(mainobj);
  if(force_open && ps_props.form_closed == true ) {togglePane();}
  if (clickChart) {
    delete formProp._fromChartUpdate;
    document.getElementById('Form_chart_options_tab').fireEvent('click');
  }
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

function SelectQuery(){
  var top = 100, left = 100;
  openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_list.jsp?action=queryName&parameter="+URLenc(formProp.query)+"&offlinemode="+URLenc(offlinemode)+"&SPModalLayerId=mskSPModalLayer", top, left, 500, 500, false, 1, false,false);
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
}

function loadFieldName(value/*,action*/){
  if (value!=formProp.labelField) {
    formProp.labelField=value;
    FormProperties();
  }
}

function EditQuery(/*index*/) {
  if(LRTrim(formProp.query)=="")
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

function updateProperties(input,the_property,propertyType,isForm,value,updateHTML,reconvertFunc,validFunc,m_obj, alwaysUpdates, setOnBlurFunc){
  //console.log("upd prop", the_property)
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
  if(setOnBlurFunc){
    if(typeof(setOnBlurFunc)=='string')
      window[setOnBlurFunc](value,the_property,input,index);
    else
      //Si puo' scrivere una
      setOnBlurFunc.call(null,value,the_property,input,index);
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

function getPropertyValue(isForm,tab,name){
  return document.getElementById((isForm?'Form_':'')+tab+'_'+name).value;
}
function setPropertyValue(isForm,tab,name,value){
  var el = document.getElementById((isForm?'Form_':'')+tab+'_'+name);
  if (isForm)
    formProp[name] = value;
  else
    itemsHTML[index][name] = value;
  el.value=value;
  el.focus();
  el.blur();
}
/*
function PickParameters(PortletItemIndex,the_property){
  window.layerOpenForeground("../visualweb/parameter_picker.jsp?index=" +PortletItemIndex+"&rtrnobj="+the_property,"SelectParam",'',600,500,true,1);
  //window.open("parameter_picker.jsp?index=" +PortletItemIndex+"&rtrnobj="+the_property, "SelectParam", "height=500,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
}*/

function SelectCfg(/*item*/) {
  var portletFiles
  if( itemsHTML[index].configtype=='zoom')
    portletFiles = new JSURL("../servlet/JSPReader?type=portalzoom");
  else
    portletFiles = new JSURL("../servlet/JSPReader?type=visualpivot");
  portletFiles = portletFiles.Response();
  TempArray = ((portletFiles.replaceAll(".vpv", "")).split(",")).filter((vpv)=> (vpv != configname));
  window.layerOpenForeground("../visualweb/select_fields.html?for=" + index +"&rtrnobj=configname","SelectConfiguration",'',350,500,true,1);
}

function EditCfg(/*item*/){
  if(LRTrim(itemsHTML[index].configname)=="")
    PSAlert.alert("No configuration selected.");
  else if(parent.newCurrentObj!=null) {
    if( itemsHTML[index].configtype=='zoom') {
      var configName=itemsHTML[index].configname.substring(0,itemsHTML[index].configname.indexOf("."));
      var table=itemsHTML[index].configname.substring(itemsHTML[index].configname.indexOf(".")+1,itemsHTML[index].configname.length);
      table = table.substring(0, table.length-4)
      parent.newCurrentObj(configName+'['+table+']',"portalzoom",{offlinemode:offlinemode});
    }
    else
      parent.newCurrentObj(itemsHTML[index].configname,"visualpivot",{offlinemode:offlinemode});
  }
  else {
    if( itemsHTML[index].configtype=='zoom') {
      var configNamex=itemsHTML[index].configname.substring(0,itemsHTML[index].configname.indexOf("."));
      var tablex=itemsHTML[index].configname.substring(itemsHTML[index].configname.indexOf(".")+1,itemsHTML[index].configname.length);
      tablex = table.substring(0, tablex.length-4)
      window.open("'../portalzoom/portalzoomeditor.jsp?&ConfigName="+URLenc(configNamex)+"&Table="+tablex,"portalzoom","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
    }
    else 
      window.open("'../editor.jsp?&ConfigName="+URLenc(itemsHTML[index].configname),"visualpivot","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
    
}