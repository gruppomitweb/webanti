/* exported
    ps_currTab ps_TabAnimation
    updateProperties HideProperties selectColor BuildExpression Properties ListObj
    rgbToHex editPortlet NewQuery EditQuery NewDef EditDef EditEventEmitter EditEventReceiver
    checkAlpha selectPortlet SelectQuery SelectDef checkVLine IsNumericInput IsObligatory IsColor
    getPreviewLayoutStep editLayoutStep delLayoutStep addLayoutStep editDesc addPage
    PickParameters
  */

//Scrive la properties
var formProp = new ZTPageletObjects.pageletObj();
var v_line=" ";
var ps_currTab = null;
var ps_TabAnimation = false;
var ps_props;
var newPropObj = null;
var newFormPropObj = null;
var last_index;
if(Empty(localStorage.getItem('zucchetti_pageleteditor_properties'))){
	ps_props = {'width':240,'top':150,'left':550,'opened':true,'opacity':1,'expandedToColumn':false,'columnSide':'none','form_closed':false}
	localStorage.setItem('zucchetti_pageleteditor_properties', JSON.stringify(ps_props));
}else{
	ps_props = JSON.parse(localStorage.getItem('zucchetti_pageleteditor_properties'));
}
function FormProperties(force_render,force_open){
  index=null;mainitem=null;
  if(!Empty(newPropObj))newPropObj.HideProperties();
  var mainobj=formProp
  if(Empty(newFormPropObj) || force_render)
    newFormPropObj = new propertiesObj({
      m_obj : mainobj
      , isForm : true
      , canExpandToColumn : false
      , divcontainer : 'formproperties'
      , moveDiv : false
      , afterRender : resizeGadgetsPane
    });
  else
    newFormPropObj.updatePropertiesFromPaint(mainobj);
  if(force_open && ps_props.form_closed == true) {togglePane();}

}
function Properties(){
	if(index!=null){
		var mainobj=itemsHTML[index];
    if(newPropObj && !Empty(last_index) && last_index==index){
        newPropObj.updatePropertiesFromPaint(mainobj);
        if(ShowProperties) ShowProperties('properties');
    }else{
      newPropObj = new propertiesObj({m_obj:mainobj,canExpandToColumn:true,tabindex:100});
      newPropObj.re_openColumn()
    }
    // if(mainobj.objClass.notifications)
      // mainobj.objClass["notifications"](mainobj);
    // if(mainobj.notifications && mainobj.notifications.length>0) {
      // document.getElementById('properties_notifics').addClass('toggler_notifics_on');
      // if(document.getElementById('n_nofitcs'))document.getElementById('properties_notifics').removeChild(document.getElementById('n_nofitcs'));
      // var n_nofitcs=new Element('div',{'id':'n_nofitcs','class':'toggler_notifics_n','text':mainobj.notifications.length}).inject(document.getElementById('properties_notifics'));
      // if(last_index==null || last_index!=index || document.getElementById('NotificsContainer')){
        // hideNotifics();
        // renderNotifics();
      // }
    // }
    // if(mainobj.notifications && mainobj.notifications.length==0){
      // document.getElementById('properties_notifics').removeClass('toggler_notifics_on');
      // if(document.getElementById('n_nofitcs'))document.getElementById('properties_notifics').removeChild(document.getElementById('n_nofitcs'));
    // }
    last_index=index;
  }
}

/* function togglePane(){
  var morphEl= new Fx.Morph($('formproperties'),{ 'duration':'300', link:'cancel',transition:Fx.Transitions.Bounce.easeOut});
  var morphTlb= new Fx.Morph($('toolbar'),{ 'duration':'300', link:'cancel',transition:Fx.Transitions.Bounce.easeOut});
  if(ps_props.form_closed == false){
    morphEl.start({'left': -$('formproperties').offsetWidth});
    morphTlb.start({'padding-left': 0})
    //$('formproperties').opened = false;
    $('formproperties_openclose').setStyle('background-position','center right') ;
    ps_props_hide_left = $('backcanvas').offsetLeft-$('formproperties').offsetWidth;
    $('backcanvas').setStyle('left',$('backcanvas').offsetLeft-$('formproperties').offsetWidth);
    $('backcanvasBorder').setStyle('left',$('backcanvasBorder').offsetLeft-$('formproperties').offsetWidth);
    $('v_line').setStyle('left',$('v_line').offsetLeft-$('formproperties').offsetWidth);
    $('h_ruler').setStyle('left',$('h_ruler').offsetLeft-$('formproperties').offsetWidth);
    $('v_ruler').setStyle('left',$('v_ruler').offsetLeft-$('formproperties').offsetWidth);
    ps_props.form_closed = true;
    $('toolbar').setStyle('width',$('canvas').getSize().x)
  }else{
    morphEl.start({'left': 0}).chain(function(){
    morphTlb.start({'padding-left': $('formproperties').offsetWidth});
    //$('formproperties').opened = true;
    $('formproperties_openclose').setStyle('background-position','center left') ;
    ps_props_hide_left = $('backcanvas').offsetLeft+$('formproperties').offsetWidth;
    $('backcanvas').setStyle('left',$('backcanvas').offsetLeft+$('formproperties').offsetWidth);
    $('backcanvasBorder').setStyle('left',$('backcanvasBorder').offsetLeft+$('formproperties').offsetWidth);
    $('v_line').setStyle('left',$('v_line').offsetLeft+$('formproperties').offsetWidth);
    $('h_ruler').setStyle('left',$('h_ruler').offsetLeft+$('formproperties').offsetWidth);
    $('v_ruler').setStyle('left',$('v_ruler').offsetLeft+$('formproperties').getSize().x);
    $('toolbar').setStyle('width',$('canvas').getSize().x - $('formproperties').getSize().x)
    });
    ps_props.form_closed = false;
  }
  
} */


function updateProperties(input,the_property,propertyType,isForm,value,updateHTML,reconvertFunc,validFunc){
  updateHTML = (typeof(updateHTML) == "undefined") ? true : updateHTML;
  m_bUpdated=true;
  var arrayProp;
  switch(the_property){
    case "x": case "y": case "h":  case "w": case "name":
      if(EmptyString(value)) {PSAlert.alert("Obligatory data input");input.focus();input.select();return;}
  }
  if(reconvertFunc){
	  eval("value="+reconvertFunc+"(value)")
  }
  if(validFunc){
	  eval("var r="+validFunc+"(value)")
	  if(r!=true){ // eslint-disable-line no-undef
      input.focus();
      input.select()
      return;
    }
  }
  if(isForm)
    arrayProp=formProp;
  else
    arrayProp=itemsHTML[index];
  switch(propertyType){
    case 'int': //solo valori numerici
      if(!Empty(value)){
        if(isNaN(value)){
          PSAlert.alert('Not a numeric value !');
          input.focus();
          input.select()
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
      arrayProp[the_property]=value;
    case 'pages':
      arrayProp[the_property]=value;
      if(updateHTML)
		    writeHTML(true);
    break;
    default:
    //case 'str': case 'data': case 'select': case 'xmldata'://valori stringa
      if(the_property=='maxlength' && Trim(value)!='') arrayProp.w=Math.floor(value*7.5)
      arrayProp[the_property]=value;
	  if(updateHTML)
		  writeHTML();
  }
}

function HideProperties(){
  if( newPropObj && newPropObj.divcontainer)
    document.getElementById(newPropObj.divcontainer).hide();
}
function ShowProperties(){
  if( newPropObj && newPropObj.divcontainer)
    document.getElementById(newPropObj.divcontainer).show();
}

function ListObj(obj) {
  if(obj.value!=''){
    removeAllHandlers()
    for(var i=0;i<itemsHTML.length;i++)
      if(itemsHTML[i].id=="item"+obj.value){
        var obk=itemsHTML[i];
        break;
      }
    if(obk){
      var str=addHandlers(obk.id.substr(4))
      obk.shadow='shadow'+obk.id.substr(4)
      Ctrl("canvashandlers").innerHTML=Ctrl("canvashandlers").innerHTML+str
      selectItem(Ctrl(obk.shadow))
    }else{
      FormProperties(false,true)
    }
  }
}

function editDesc(id,isFormProp){
  window.open("../portalstudio/insert_desc.html?isFormProp="+isFormProp+"&id="+id, "description", "height=250,width=400,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
}

function addPage(){
  formProp.npages++;
  formProp.page=formProp.npages;
  FormProperties(true,false);
  index=null;
  mainitem=null;
  writeHTML(true);
}

function toHex(dec){
  var result= (parseInt(dec).toString(16));
  if(result.length ==1) result= ("0" +result);
  return result.toUpperCase();
}
var rgbPattern = /\brgb\(\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*\,\s*([\d]{1,3})\s*\)/i;
// to convert rgb(xx, yy, zz) into #aabbcc (in mozilla/netscape)
function rgbToHex(inp){
  for(var rgb; (rgb=inp.match(rgbPattern))!=null; ){
    var hex="#";
    for(var j=1; j<rgb.length; j++)
      if(isNaN(parseInt(rgb[j])));
      else
        if(j+2<rgb.length && rgb[j+1]=="%")
          hex+=toHex(255 * parseInt(rgb[j])/100);
        else
          hex+=toHex(rgb[j]);
    inp = inp.replace(rgb[0], hex);
  }
  return inp;
}
var TempArray = null;
function GetQueryFields(queryname,retDesc){
  var res=[];
  var types=[];
  var i, row;
  if(retDesc==true)
    var desc=[];
  var AllField = new JSURL("../servlet/SPVQRProxy?action=fields&filename="+queryname, true);
  AllField = AllField.Response();
  if(Left(AllField,9)=="BO_QUERY:"){
    AllField = Substr(AllField,10);
    var CSV_SEP="#!$";
    row, rows = AllField.split(CSV_SEP);
    for (i=0; i<rows.length; i++){
      row=rows[i].split("|");
      res.push(row[0]);
      if(retDesc==true)
        desc.push(row[2]);
    }
  }
  else {
    var l_oFields = new TrsJavascript();
    l_oFields.reset();
    l_oFields.SetRow(0);
    l_oFields.BuildProperties(AllField);
    var rows = GetProperty(l_oFields,'Rows','N');
    for (i=0; i<rows; i++){
      l_oFields.SetRow(i);
      res.push(GetProperty(l_oFields,'alias','C'));
      if(retDesc==true)
        desc.push(GetProperty(l_oFields,'desc','C'));
      types.push(GetProperty(l_oFields,'type','C'));
    }
  }
  return retDesc?[res,desc,types]:[res,types];
}
function BuildExpression(PortletItemIndex,the_property){
  TempArray = [];
  var PortletItemDataObj = itemsHTML[PortletItemIndex].dataobj;
  var PortletItemDataObjQuery = null;
  var PortletItemDataObjAlias = null;//SQLTotalizer
  var PortletItemDataObjGB = null;//SQLTotalizer
  var i=0;
  while (i<itemsHTML.length && PortletItemDataObjQuery == null){
    if (itemsHTML[i].name == PortletItemDataObj) {
      PortletItemDataObjQuery = itemsHTML[i].query;
      PortletItemDataObjAlias = itemsHTML[i]["alias"];
      PortletItemDataObjGB = itemsHTML[i]["groupby_fields"];
    }
    i++;
  }
  if (PortletItemDataObjQuery != null){
    TempArray=GetQueryFields(PortletItemDataObjQuery,the_property!='field');
    if(the_property=='field')
      window.open("select_fields.html?for=" + PortletItemIndex, "SelectField", "height=196,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
    //else if(itemsHTML[PortletItemIndex].columnformat.indexOf(";")==-1)
    // else
    //   window.open("expression_builder.html?for="+PortletItemIndex+"&prop="+the_property, "exp_builder", "height=560,width=670,left=300,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=no");
  }else if(PortletItemDataObjAlias!=null){
    var SQLTotalizer_flds;
    if(PortletItemDataObjGB!=null && Trim(PortletItemDataObjGB)!='')
      SQLTotalizer_flds=PortletItemDataObjGB+','+PortletItemDataObjAlias;
    else
      SQLTotalizer_flds =PortletItemDataObjAlias;
    if(the_property=='field'){
      TempArray=[SQLTotalizer_flds.split(','),[]];
      window.open("select_fields.html?for=" + PortletItemIndex, "SelectField", "height=196,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
    //else if(itemsHTML[PortletItemIndex].columnformat.indexOf(";")==-1)
    }else{
      // TempArray=[SQLTotalizer_flds.split(','),SQLTotalizer_flds.split(','),[]];
      // window.open("expression_builder.html?for="+PortletItemIndex+"&prop="+the_property, "exp_builder", "height=560,width=670,left=300,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=no");
    }
  }else{
    PSAlert.alert("Select a data object");
  }
}

function editPortlet(ref){
  var url=document.getElementById(ref).value;
  if(url&&url.indexOf("_portlet.jsp")>-1){
    url=Strtran(url,"_portlet.jsp","");
    if(url.indexOf("?")>-1){
      url = url.substring(0,url.indexOf("?"));
    }
  if(parent.newCurrentObj!=null)
    window.parent.newCurrentObj(url,"portlet",{});
  else
    window.open("editor.jsp?id="+url, "portleteditor", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}

function selectPortlet(retTo) {
  window.layerOpenForeground('insert.jsp?for=' + retTo, 'SelectPortlet', '', 500, 600, true, 1);
  // window.open("insert.jsp?for="+retTo, "SelectPortlet", "width=350,height=358,top=300,left=300,scroll=no,status=no,toolbar=no,resizable=yes");
}


function SelectQuery(PortletItemIndex){
  //TempArray = new JSURL("../servlet/SPVQRProxy?action=vqr");
  //TempArray = TempArray.Response();
  TempArray = new JSURL("../servlet/SPVQRProxy?action=vqr").Response().replace(/\.vqr/gi, '');
  //if(At("ACCESS DENIED",TempArray)>0){
  if(TempArray.match("ACCESS DENIED")){
    window.open("../servlet/SPVQRProxy?action=vqr", "SelectQuery", "height=100,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
  }
  else {
    //TempArray = Strtran(TempArray, ".vqr", "")
    //TempArray = Strtran(TempArray, ".VQR", "")
    //TempArray = TempArray.split(',')
    eval('TempArray = '+TempArray);
    window.open("select_fields.html?rtrnobj=query&for=" + PortletItemIndex, "SelectQuery", "height=347,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
  }
}
function EditQuery(index) {
  if(LRTrim(itemsHTML[index].query)=="")
    PSAlert.alert("No query selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj(itemsHTML[index].query,"visualquery");
  else
    window.open("../visualquery/index.jsp?filename="+itemsHTML[index].query,"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function NewQuery() {
  if(parent.newCurrentObj!=null)
    parent.newCurrentObj('New','visualquery');
  else
    window.open("../visualquery/index.jsp","visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function SelectDef(PortletItemIndex){
  var TempArray2 = new JSURL("../servlet/SPChartServlet");
  TempArray2 = TempArray2.Response();
  TempArray2 = TempArray2.split(',');
  TempArray = new Array();
  for(var i=0;i<TempArray2.length;i++)
    if (TempArray2[i].indexOf("__temp") < 0) TempArray.push(TempArray2[i])
  window.open("select_fields.html?rtrnobj=def&for="+PortletItemIndex, "SelectField", "height=250,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
}

function NewDef(/*index*/) {
  if(parent.newCurrentObj!=null)
    parent.newCurrentObj('New','chart',{});
}
function EditDef(index) {
  if(LRTrim(itemsHTML[index].def)=="")
    PSAlert.alert("No chart selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj(itemsHTML[index].def,"chart");
  else
    window.open("../chart/index.jsp?onpopup=true&filename="+itemsHTML[index].def,"Chartdef","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function EditEventEmitter(index) {
  window.open("../visualweb/eventemitter_edit.html?objIdx="+index+"", "eventemitter_editor","height=450,width=600,resizable=yes,status=yes,toolbar=no,menubar=no,location=no");
}
function EditEventReceiver(index) {
  window.open("../visualweb/eventreceiver_edit.html?objIdx="+index+"", "eventreceiver_editor","height=450,width=600,resizable=yes,status=yes,toolbar=no,menubar=no,location=no");
}
function checkAlpha(id){
  var ctrl=Ctrl(id)
  var ww;if(v_line!=" ") ww=parseInt(v_line);else ww=formProp.w;
  try{
  if(ctrl.offsetLeft<parseInt(ww)+80 && ctrl.offsetTop<parseInt(formProp.h)+60){
    ctrl.style.MozOpacity=0.4;
    //ctrl.style.filter="alpha(opacity=40)";
  }else{
    ctrl.style.MozOpacity=1;
    //ctrl.style.filter="alpha(opacity=100)";
  }
  }catch(e){}
}
//Alcune Funzioni di controllo
function checkVLine(v){
  if(!Empty(v) && formProp.w.indexOf('%')==-1)
    PSAlert.alert('Width must be in % !');
  return true;
}
function IsNumericInput(v){
if(isNaN(v)){
  PSAlert.alert('Not a numeric value!')
  return false;
}else
  return true;
}
function IsObligatory(v){
if(Empty(v)){
  PSAlert.alert('Obligatory input value!')
  return false;
}else
  return true;
}
function IsColor(v){
  return true;
  if(Empty(v)) return true;
  var Hex=/^(#[A-Fa-f0-9]{6})$/;
  if(!Hex.test(v)){
     PSAlert.alert('Invalid Hex color');
     return false;
  }else
    return true;
}
function getPreviewLayoutStep(){
  // prendo il successivo
  if( formProp.layout_step != '' ){
    var Steps=formProp.steps.split(',');
    var i = Steps.indexOf(formProp.layout_step);
    if( i+1 < Steps.length)
      return Steps[i+1]-1;
    else
      return null;
  }
}
function addLayoutStep(obj){
  if(document.getElementById(obj.refId+'_add')) return;
  var propInput_add = new Element('input',{'id':obj.refId+'_add','name':obj.refId+'_add','class':'properties_input'});
  propInput_add.setStyles(Object.append(Object.subset($(obj.refId).getCoordinates(),['left','width']),{'position':'absolute'}));
  // propInput_add.setStyles({'position':'absolute','width':'70%','left':'13px'});
  propInput_add.inject(document.querySelector("#"+obj.refId).parentNode);
  propInput_add.addEvents({
    'focus': function(){SetOnEditProp(true);},
    'blur':function(){
      if(Empty(this.value)) {
        propInput_add.destroy();
        SetOnEditProp(false);
        return;
      }
      /* Se � il primo step inserisco i segmento 0-layout laout-default */
      if( Empty(formProp.steps) ){ //aggiungo lo 0
        formProp.steps="0,"+this.value;
        updateLayoutSteps("0",this.value);
      } else {
        formProp.steps = formProp.steps + ',' + this.value;
        //ordinamento
        formProp.steps = formProp.steps.split(",").sort(function(a, b){ return parseInt(a) > parseInt(b) ? 1 : -1; }).join(",");
        updateLayoutSteps(formProp.layout_step,this.value);
      }
      formProp.layout_step=this.value;
      SetOnEditProp(false);
      FormProperties(true);
      writeHTML(true);
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
function delLayoutStep(/*obj*/){
  if(Empty(formProp.layout_step)) return;
  var Steps=formProp.steps.split(',');
  var ind = LibJavascript.Array.indexOf(Steps,formProp.layout_step);
  LibJavascript.Array.remove(Steps,ind);
  formProp.steps=Steps.join(',');
  if(ind>0)
    formProp.layout_step=Steps[ind-1];
  else if(Steps.length>0)
    formProp.layout_step=Steps[0];
  else
    formProp.layout_step='';
  updateLayoutSteps(-1,formProp.layout_step);
  FormProperties(true);
  writeHTML(true);
}
function editLayoutStep(obj){
  if(document.getElementById(obj.refId+'_add')) return;
  var propInput_add = new Element('input',{'id':obj.refId+'_add','name':obj.refId+'_add','class':'properties_input'});
  propInput_add.setStyles({'position':'absolute','top':'0','width':'90%','height':'90%','left':'0'});
  propInput_add.inject(document.querySelector("#"+obj.refId).parentNode);
  propInput_add.value=formProp.layout_step;
  var Steps=formProp.steps.split(',');
  var ind = LibJavascript.Array.indexOf(Steps,formProp.layout_step);
  propInput_add.addEvents({
    'focus': function(){SetOnEditProp(true);},
    'blur':function(){
      if(Empty(this.value)) return;
      Steps[ind]=this.value;
      formProp.steps=Steps.join(',');
      updateLayoutSteps('',formProp.layout_step);
      formProp.layout_step=this.value;
      SetOnEditProp(false);
      FormProperties(true);
      writeHTML(true);
      propInput_add.destroy();
    },
    'keydown':function(event){
      if (event.key == 'enter') this.blur();
    }
  });
  propInput_add.focus();
}

function updateLayoutSteps(oldStep,newStep){
  var i;
  if(Empty(newStep) && Empty(oldStep)) {
    for(i=0;i<itemsHTML.length;i++){
      if(itemsHTML[i].layout_steps_values)
        itemsHTML[i].layout_steps_values={};//svuoto tutti gli step eventualmente rimasti
    }
    return;
  }
  if(typeof(oldStep) == 'undefined' || EmptyString(oldStep))
    oldStep=newStep;//nel caso di primo step
  for(i=0;i<itemsHTML.length;i++){
    var ctrl=itemsHTML[i];
    //salvo le prop nell oggetto multiplo
    if(ctrl.layout_steps_values){
      if(oldStep!=-1){
        if(!ctrl.layout_steps_values[oldStep])
          ctrl.layout_steps_values[oldStep]={};
        setStepProp(ctrl, oldStep);
      }
      //Cancello gli step in disuso
      var formSteps=formProp.steps.split(',');
      var ctrlSteps=Object.keys(ctrl.layout_steps_values);
      for(var ii=0;ii<ctrlSteps.length;ii++){
        if(LibJavascript.Array.indexOf(formSteps,ctrlSteps[ii])==-1)
          delete ctrl.layout_steps_values[ctrlSteps[ii]];

      }
      if(typeof(newStep) != 'undefined' && ctrl.layout_steps_values[newStep]){
      //recupero le prop dall'oggetto multiplo
        getStepProp(ctrl, newStep);
      }
    }
  }
  writeHTML();
}

function PickParameters(idx,the_property,idProp) {
  window.layerOpenForeground('../portalstudio/parameter_edit.html?idx=' + idProp + '&filename=' + itemsHTML[index].name, 'parameters', '', 600, 300, true, 1);
}

function setStepProp(ctrl, step){
  for( var i=0; i < ctrl.steppable_prop.length; i++){
    ctrl.layout_steps_values[step][ctrl.steppable_prop[i]] = ctrl[ctrl.steppable_prop[i]];
  }
}

function getStepProp(ctrl, step){
  for( var i=0; i < ctrl.steppable_prop.length; i++){
    ctrl[ctrl.steppable_prop[i]] = ctrl.layout_steps_values[step][ctrl.steppable_prop[i]];
  }
}
