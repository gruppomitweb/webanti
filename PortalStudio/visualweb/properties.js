/* exported ps_currTab ps_TabAnimation pickerObj contentInfo titleInfo
    updateAllLayoutSteps addLayoutStep delLayoutStep editLayoutStep setAdaptiveSettings
    ListObj editDesc selectDate addPage rgbToHex TempArray BuildExpression loadValue
    editPortlet selectPortlet selectReceiver selectEmitter SelectBO SelectItems
    PickParameters EditQuery NewQuery EditEventEmitter EditEventReceiver hideProperties
    checkAlpha checkVLine IsColor IsValidCheckboxValues IsValidValue LoadFileList
    downloadChartReturn GetAvailableDownloadFormat LoadChartList ShowMoreInfo
    getChartFieldValue renderPreSet fillLayoutStep LoadRangeMask setChartRangeBands
    StartChartWizard SaveChartFieldsConfiguration SetChartWizardConfiguration
    receiveConfigSeries renderWizard KeyFind receiveConfigClassSeries EditClientQuery
    getDataproviders setPropertyValue CreateTemplateConnectors openConfigZoom editZoom
    newZoom openLinkedField openReadField loadFieldName insertPageBefore deletePage pickerBO fillBoItems
    GetObjsForExpBuilder openFields GetExpressionFromId SetReturnVal  openTableFields selectZoneMode
    setCurrentPage setPagesProp updateProperties SetSmartChartdef GetChartWizardInitConf

    GetQueryFields openFields getQueryFieldsFromDataprovider
 */

//Scrive la properties
var formProp=new ZTObjects.formObj('300','400','#F3F3F3')
var searchProp = ZTObjects.searchObj ? new ZTObjects.searchObj() : null;
var v_line=" ";
var ps_currTab = null;
var ps_TabAnimation = false;
var ps_props;
var last_index=null;
var pickerObj, contentInfo, titleInfo;
var search_accordion, searchResult, wrapperTitle;


var availableDownloadFormat = [
								["SVG", "SVG structured document", "all"],
								["SVGF", "SVG structured document with fonts", "all"],
								["PNG", "PNG format image", "all"],
								["JPEG", "JPEG format image", "all"],
								["PDF", "PDF format document", "all"],
								["CSV", "CSV format document", "all"],
								["XML", "XML format document", "all"]
							  ];

if(Empty(localStorage.getItem('zucchetti_portleteditor_properties'))){
	ps_props = {'width':250,'top':45,'left':500,'opened':true,'opacity':1,'expandedToColumn':true,'columnSide':'right','form_closed':false}
	localStorage.setItem('zucchetti_portleteditor_properties', JSON.encode(ps_props));
}else{
	ps_props = JSON.parse(localStorage.getItem('zucchetti_portleteditor_properties'));
}
function FormProperties(force_render,force_open){
  var mainobj=formProp;
  if(Empty(newFormPropObj) || force_render){
    newFormPropObj = new propertiesObj({
      afterRender : resizeGadgetsPane
      , m_obj : mainobj
      , isForm : true
      , canExpandToColumn : false
      , divcontainer : 'formproperties'
      , moveDiv : false
    });
  } else {
    newFormPropObj.updatePropertiesFromPaint(mainobj);
  }
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
    if(document.getElementById('Form_generic_pages')){
      document.getElementById('Form_generic_pages').value = formProp.page;
      document.getElementById('Form_generic_pages').dispatchEvent(new Event('change'));
    }
  }
  if(force_open && ps_props.form_closed == true) {togglePane();}
}

function Properties(forceRender){
	if(index!=null){
    var mainobj=itemsHTML[index];
    if(newPropObj && !forceRender && last_index!=null && last_index==index){
      newPropObj.updatePropertiesFromPaint(mainobj);
    }else if(newPropObj && !newPropObj.pSheetOpened){
    //rimani chiuso
    }else{
      newPropObj = new propertiesObj({m_obj:mainobj,canExpandToColumn:true,tabindex:100});
      newPropObj.re_openColumn();
    }
    if(showProperties) showProperties('properties');
    if(last_index!=index)hidePreSet();
    //Set Notifications
    if(mainobj.objClass.notifications)
      mainobj.objClass["notifications"](mainobj);
    if(mainobj.notifications && mainobj.notifications.length>0) {
      document.getElementById('properties_notifics').addClass('toggler_notifics_on');
      if(document.getElementById('n_nofitcs'))document.getElementById('properties_notifics').removeChild(document.getElementById('n_nofitcs'));
      new Element('div',{'id':'n_nofitcs','class':'toggler_notifics_n','text':mainobj.notifications.length}).inject(document.getElementById('properties_notifics'));
      if(last_index==null || last_index!=index || document.getElementById('NotificsContainer')){
        hideNotifics();
        renderNotifics();
      }
    }
    if(mainobj.notifications && mainobj.notifications.length==0){
      document.getElementById('properties_notifics').removeClass('toggler_notifics_on');
      if(document.getElementById('n_nofitcs'))document.getElementById('properties_notifics').removeChild(document.getElementById('n_nofitcs'));
    }
    if(mainobj.author && document.getElementById("components_author") == null) {
      var title = "The component has been developed by the " + mainobj.author + ".\nFor assistance please contact the department."
      var text = "<p>Component's Author: <span title=\"" + title + "\">" + mainobj.author + "</span></p>";
      var node = document.createElement("div");
      node.innerHTML = text;
      node.id = "components_author";
      document.getElementById("properties").getElementsByClassName("pSheet")[0].appendChild(node);
      document.getElementById("propertiespContainer").classList.add("with_author");
    }
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

function updateProperties(input, the_property, propertyType, isForm, value, updateHTML, reconvertFunc, validFunc, m_obj, alwaysUpdates, setOnBlurFunc) {
  updateHTML = (typeof(updateHTML) == "undefined") ? true : updateHTML;
  // if(window.htmlmode){
    // updateHTML=false;
  // }
  if(m_obj && (typeof(m_obj.updateHTML) != "undefined")) updateHTML = m_obj.updateHTML;
  var arrayProp;
  if(isForm)
    arrayProp=formProp;
  else if(m_obj)
	  arrayProp=m_obj;
  else
    arrayProp=itemsHTML[index];
  if(value==arrayProp[the_property]) return;
  switch(the_property){
    case "x": case "y": case "h":  case "w": case "name":
      if(EmptyString(value)) {
        PSAlert.alert("Obligatory data input");
        setTimeout("document.getElementById('"+input.id+"').focus();",50);
        setTimeout("document.getElementById('"+input.id+"').select();",50);
        return;
      }
    break;
    case "manifest":
      if(!Empty(value) && formProp['manifest']!=value)
        codeManifest=new JSURL("../servlet/JSPReader?action=manifest&name="+value,true).Response();
      if(Empty(value)) codeManifest='';
    break;

  }
  if(reconvertFunc){
    value=window[reconvertFunc](value)
  }
  var r;
  if(validFunc){
    if(typeof(validFunc)=='string')
      r = window[validFunc](value,the_property,input,index);
    else
      //Si può scrivere una
      r=validFunc.call(null,value,the_property,input,index);
	  if(r!=true){
      if(input.type=='checkbox'){
        input.checked=false;
      }else{
        input.value=arrayProp[the_property];
        setTimeout("document.getElementById('"+input.id+"').focus();",50);
        setTimeout("document.getElementById('"+input.id+"').select();",50);
      }
      return;
    }
  }
  if(setOnBlurFunc){
    if(typeof(setOnBlurFunc)=='string')
      window[setOnBlurFunc](value,the_property,input,index);
    else
      //Si può scrivere una
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
          selectForm()
          //return;
        }
    break;
    case 'pages':
      arrayProp[the_property]=value;
      if(updateHTML)
		    writeHTML(true);
    break;
    case 'steps_layout':
      arrayProp[the_property]=value;
      if(updateHTML)
		    writeHTML(true);
    break;
    default:
    //case 'str': case 'data': case 'select': case 'xmldata'://valori stringa
      if (the_property == 'maxlength' && Trim(value) != '') arrayProp.w = Math.floor(value * 7.5)
      /* Conversione dei newline da html a javascript */
      value = Strtran(value, '&#13;', '\r');
      value = Strtran(value, '&#10;', '\n');
      let oldname;
      if (the_property == "name") {
        oldname = arrayProp.name;
      }
      arrayProp[the_property]=value;
      if (the_property == "name") {
        if( window.updateHtmlCode ) {
          updateHtmlCode( oldname, value);
        }
      }
      if(isForm  && the_property=='steps'){
        FormProperties(true);
      }
	    if(updateHTML)
		    writeHTML();
  }
  if(window.updatePropertiesSelected) updatePropertiesSelected(the_property,isForm,value,updateHTML);
  m_bUpdated=true;
}

function updateAllLayoutSteps(){
  var formSteps=formProp.steps.split(',');
  var CurrStep=formProp.layout_step;
  var initialStep=CurrStep;
  //updateLayoutSteps(CurrStep,formSteps[0]);
  for(var i=0;i<formSteps.length;i++){
    updateLayoutSteps(CurrStep,formSteps[i])
    CurrStep=formSteps[i];
  }
  updateLayoutSteps(CurrStep,initialStep)
}

function updateLayoutSteps(oldStep,newStep,oldPage,newPage){
  var formSteps=formProp.steps.split(',');
  var i, ii, ss;
  if(oldPage==null){
    oldPage = formProp.page-1;
    newPage = formProp.page-1;
  }
  var pageProps = formProp.pagesProp[oldPage]; // oggetto page della pagina corrente
  if(Empty(newStep) && Empty(oldStep)) {
    for(i=0;i<itemsHTML.length;i++){
      if(itemsHTML[i].layout_steps_values)
        itemsHTML[i].layout_steps_values={};//svuoto tutti gli step eventualmente rimasti
    }
    return;
  }
  if(Empty(oldStep)) oldStep=newStep;//nel caso di primo step
  var deltaStep=parseInt(newStep)-parseInt(oldStep);
  if(oldStep==newStep && newPage==null)  deltaStep=parseInt(oldStep)-parseInt((pageProps.w.indexOf("%")>-1)?formProp.v_line:pageProps.w);
  //Salvo le prop h,w steppabile del form
  if(pageProps.layout_steps_values){
    if(!pageProps.layout_steps_values[oldStep])
    pageProps.layout_steps_values[oldStep]={};
    pageProps.layout_steps_values[oldStep].h=(formProp.h.split(',')[oldPage]).toString();
    pageProps.layout_steps_values[oldStep].w=(formProp.w.split(',')[oldPage]).toString();
    if(newStep==null){//al salvataggio
      //Cancello gli step in disuso
      var formStepsKeys=Object.keys(pageProps.layout_steps_values);
      for(ii=0;ii<formStepsKeys.length;ii++){
        if(LibJavascript.Array.indexOf(formSteps,formStepsKeys[ii])==-1)
          delete pageProps.layout_steps_values[formStepsKeys[ii]];
      }
      //controllo che tutti gli step siano riempiti almeno con un valore di default
      for(ss=0;ss<formSteps.length;ss++){
        if(LibJavascript.Array.indexOf(formStepsKeys,formSteps[ss])==-1)
        pageProps.layout_steps_values[formSteps[ss]]=pageProps.layout_steps_values[pageProps.layout_step];
      }
    }
    if(newStep && pageProps.layout_steps_values[newStep]){
      //recupero le prop dall'oggetto multiplo
      // let ArrayH = formProp.h.split(',');
      // ArrayH[formProp.page-1] = pageProps.layout_steps_values[newStep].h;
      // formProp.h = ArrayH.join();
      formProp.pagesProp[newPage].h = formProp.pagesProp[newPage].layout_steps_values[newStep].h;
      formProp.pagesProp[newPage].w = formProp.pagesProp[newPage].layout_steps_values[newStep].w;
      if(typeof(pageProps.layout_steps_values[newStep].w)!='undefined'){
        //Aggiorno il formProp.w multiplo dello step corrente
        let ArrayW = [];
        let ArrayH = [];
        for(var iii=0;iii< formProp.pagesProp.length;iii++){
          //Se non c'è lo step lo creo
          ArrayW.push(formProp.pagesProp[iii].layout_steps_values[newStep].w);
          ArrayH.push(formProp.pagesProp[iii].layout_steps_values[newStep].h);
        }
        //let ArrayW = formProp.w.split(',');
        //ArrayW[formProp.page-1] = pageProps.layout_steps_values[newStep].w;
        formProp.w = ArrayW.join();
        formProp.h = ArrayH.join();
        //formProp.w = pageProps.layout_steps_values[newStep].w;
      }
    }
  }

  for(i=0;i<itemsHTML.length;i++){
    var ctrl=itemsHTML[i];
    //salvo le prop dei ctrls nell oggetto multiplo
    if(ctrl.layout_steps_values){
      if(oldStep!=-1){ // dopo la cancellazione di uno step
        if(typeof(ctrl.layout_steps_values)=='boolean')ctrl.layout_steps_values={};
        if(!ctrl.layout_steps_values[oldStep])
          ctrl.layout_steps_values[oldStep]={};
        ctrl.layout_steps_values[oldStep].x=parseInt(ctrl.x);
        ctrl.layout_steps_values[oldStep].y=parseInt(ctrl.y);
        ctrl.layout_steps_values[oldStep].w=ctrl.w;
        ctrl.layout_steps_values[oldStep].h=parseInt(ctrl.h);
        if(typeof(ctrl.anchor)!='undefined')ctrl.layout_steps_values[oldStep].anchor=ctrl.anchor;

        //Proprietà steppabili extra
        if(ctrl.steppable_prop_extra)
          for(ii=0; ii < ctrl.steppable_prop_extra.length; ii++){
            ctrl.layout_steps_values[oldStep][ctrl.steppable_prop_extra[ii]] = ctrl[ctrl.steppable_prop_extra[ii]];
          }
      }
      if(newStep==null){//al salvataggio
        //Cancello gli step in disuso
        var ctrlSteps=Object.keys(ctrl.layout_steps_values);
        for(ii=0;ii<ctrlSteps.length;ii++){
          if(LibJavascript.Array.indexOf(formSteps,ctrlSteps[ii])==-1)
            delete ctrl.layout_steps_values[ctrlSteps[ii]];
        }
        //controllo che tutti gli step siano riempiti almeno con un valore di default
        for(ss=0;ss<formSteps.length;ss++){
          if(LibJavascript.Array.indexOf(ctrlSteps,formSteps[ss])==-1)
            ctrl.layout_steps_values[formSteps[ss]]=ctrl.layout_steps_values[formProp.layout_step];
        }
      }
      if(newStep && oldStep!=newStep && ctrl.layout_steps_values[newStep]){
      //recupero le prop dall'oggetto multiplo
        ctrl.x=ctrl.layout_steps_values[newStep].x;
        ctrl.y=ctrl.layout_steps_values[newStep].y;
        ctrl.w=ctrl.layout_steps_values[newStep].w;
        ctrl.h=ctrl.layout_steps_values[newStep].h;
        if(typeof(ctrl.layout_steps_values[newStep].anchor)!='undefined')
          ctrl.anchor=ctrl.layout_steps_values[newStep].anchor;
        else
          ctrl.anchor='';
        //Proprietà steppabili extra
        if(ctrl.steppable_prop_extra)
          for(ii=0; ii < ctrl.steppable_prop_extra.length; ii++){
            ctrl[ctrl.steppable_prop_extra[ii]] = ctrl.layout_steps_values[newStep][ctrl.steppable_prop_extra[ii]];
          }
      }else if(newStep  && typeof(ctrl.anchor)!='undefined' && (ctrl.anchor.indexOf('right')>-1 || (ctrl.anchor.indexOf('%')>-1 || (formProp.adaptive=='adaptive' && Empty(ctrl.anchor))))){
        //alla creazione di nuovo step vuoto sposto gli elementi ancorati
        var RightPct, LeftPct;
        if(newStep==oldStep) oldStep=formProp.v_line;
        if(!ctrl.layout_steps_values[newStep])
          ctrl.layout_steps_values[newStep]={};
        if(ctrl.anchor.indexOf('right')>-1 && ctrl.anchor.indexOf('left')==-1){ // sposto gli elementi ancorati solo right
          if(ctrl.anchor.indexOf('%')>-1){
            RightPct=(parseInt(oldStep)-(parseInt(ctrl.x)+parseInt(ctrl.w)))*100/parseInt(oldStep);
            ctrl.x=parseInt(ctrl.x)+ (deltaStep-parseInt(deltaStep*RightPct/100)) ;
          }else
            ctrl.x=parseInt(ctrl.x)+deltaStep;
        }else if(ctrl.anchor.indexOf('left(%)')>-1 && ctrl.anchor.indexOf('right')==-1){ // sposto gli elementi ancorati solo left%
          LeftPct=parseInt(ctrl.x)*100/parseInt(oldStep);
          ctrl.x=parseInt(ctrl.x)+ parseInt((deltaStep*LeftPct/100));

        }else if(ctrl.anchor.indexOf('right')>-1 && ctrl.anchor.indexOf('left')>-1 || (formProp.adaptive=='adaptive' && Empty(ctrl.anchor))){ // sposto gli elementi ancorati left-right
          if(ctrl.anchor.indexOf('right(%)')>-1 && ctrl.anchor.indexOf('left(%)')>-1 || (formProp.adaptive=='adaptive' && Empty(ctrl.anchor))){ //tutti in %
            RightPct=(parseInt(oldStep)-(parseInt(ctrl.x)+parseInt(ctrl.w)))*100/parseInt(oldStep);
            LeftPct=parseInt(ctrl.x)*100/parseInt(oldStep);
            ctrl.x=parseInt(ctrl.x)+ parseInt(deltaStep*LeftPct/100);
            ctrl.w=Math.floor(parseInt(ctrl.w)+ (deltaStep-deltaStep*RightPct/100) - (deltaStep*LeftPct/100));
          }else if(ctrl.anchor.indexOf('right(%)')>-1){ //right% e left px
            RightPct=(parseInt(oldStep)-(parseInt(ctrl.x)+parseInt(ctrl.w)))*100/parseInt(oldStep);
            ctrl.w=Math.floor(parseInt(ctrl.w)+ (deltaStep-deltaStep*RightPct/100));
          }else if(ctrl.anchor.indexOf('left(%)')>-1){ //left% e right px
            LeftPct=parseInt(ctrl.x)*100/parseInt(oldStep);
            ctrl.x=parseInt(ctrl.x)+ parseInt(deltaStep*LeftPct/100);
            ctrl.w=Math.floor(parseInt(ctrl.w)+ (deltaStep) - (deltaStep*LeftPct/100));
          }else{ //left-right in px

            ctrl.w=(parseInt(ctrl.w)+ (deltaStep)).toString();
          }

        }
        ctrl.layout_steps_values[newStep].x=parseInt(ctrl.x);
        ctrl.layout_steps_values[newStep].y=parseInt(ctrl.y);
        ctrl.layout_steps_values[newStep].w=parseInt(ctrl.w);
        ctrl.layout_steps_values[newStep].h=parseInt(ctrl.h);
        if(typeof(ctrl.anchor)!='undefined')ctrl.layout_steps_values[newStep].anchor=ctrl.anchor;
        //Proprietà steppabili extra
        if(ctrl.steppable_prop_extra)
          for( ii=0; ii < ctrl.steppable_prop_extra.length; ii++){
            ctrl.layout_steps_values[newStep][ctrl.steppable_prop_extra[ii]] = ctrl[ctrl.steppable_prop_extra[ii]];
          }
      }
    }
  }
  if(newStep){
    formProp.v_line=newStep;
    //formProp.w='100%';
  }
  var currIndex=index;
  removeAllHandlers();
  if(currIndex!=null){
    var _func= function(){
      document.getElementById(itemsHTML[currIndex].id).removeEventListener('transitionend',_func,false);
      selectItem(itemsHTML[currIndex]);
    };
    document.getElementById(itemsHTML[currIndex].id).addEventListener(
      'transitionend',
        _func,
        false
      )
  }
  writeHTML();
}

function addLayoutStep(obj){
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
      //Al primo step controllo la min width e la aggiungo agli step
      if(Empty(formProp.steps)){
        var min_w;
        if(formProp.pagesProp[formProp.page-1].w.indexOf('%')>-1)
          min_w=formProp.v_line;
        else
          min_w=formProp.pagesProp[formProp.page-1].w;
        if(parseInt(this.value)>parseInt(min_w)){
          formProp.steps=min_w; //primo step come min_width
          formProp.layout_step=min_w;
        }
      }
      formProp.steps = (!Empty(formProp.steps) ? formProp.steps + ',' + this.value : this.value);
      /** Ordino lo step appena aggiunto */
      formProp.steps = formProp.steps.split(",").sort((a, b) => { return parseInt(a) > parseInt(b) ? 1 : -1; }).join(",");
      //creo l'oggetto layout step values per ogni pagina
      for(var i=0;i< formProp.pagesProp.length;i++){
        for(var ii=0,Steps=formProp.steps.split(","); ii<Steps.length; ii++){
          if(!formProp.pagesProp[i].layout_steps_values[Steps[ii]]){
            formProp.pagesProp[i].layout_steps_values[Steps[ii]]={};
            formProp.pagesProp[i].layout_steps_values[Steps[ii]]['h'] = formProp.pagesProp[i].h;
            formProp.pagesProp[i].layout_steps_values[Steps[ii]]['w'] = formProp.pagesProp[i].w;
          }
        }
      }
      updateLayoutSteps(formProp.layout_step,this.value)
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
  //Cancello layout step value dalle pagine
  for(var i=0;i< formProp.pagesProp.length;i++){
    delete formProp.pagesProp[i].layout_steps_values[formProp.layout_step];
  }
  if(ind>0)
    formProp.layout_step=Steps[ind-1];
  else if(Steps.length>0)
    formProp.layout_step=Steps[0];
  else
    formProp.layout_step='';
  updateLayoutSteps(null,formProp.layout_step);
  FormProperties(true);
  writeHTML(true);
}
function editLayoutStep(obj){
   if(document.getElementById(obj.refId+'_add')) return;
   var propInput_add = new Element('input',{'id':obj.refId+'_add','name':obj.refId+'_add','class':'properties_input'});
  propInput_add.setStyles({'position':'absolute', 'width':'60%','left':'13px'});
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
      //updateLayoutSteps('',this.value)
      //Aggiorno la key del layout step values delle pagine
      for(var i=0;i< formProp.pagesProp.length;i++){
        formProp.pagesProp[i].layout_steps_values[this.value] = JSON.parse(JSON.stringify(formProp.pagesProp[i].layout_steps_values[formProp.layout_step]));
        delete formProp.pagesProp[i].layout_steps_values[formProp.layout_step];
      }
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

function getPropertyValue(isForm,tab,name){
  var el = document.getElementById((isForm?'Form_':'')+tab+'_'+name);
  if(el.type=='checkbox'){
    return el.checked?"true":"false";
  }else{
    return el.value;
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

function selectZoneMode(v){
  if(!Empty(v)){
    setPropertyValue(true,'advanced','selectZone','true');
    //formProp.selectZone=true;
  }
}
function setAdaptiveSettings(value/*,the_property,input,index*/){
  var v_line,width;
  v_line=getPropertyValue(true,'generic','v_line');
  width=getPropertyValue(true,'generic','w');
  if(value=='adaptive'){
    if(Empty(v_line) && width.indexOf('%')==-1){
      formProp.v_line=width;
      // setPropertyValue(true,'generic','v_line',width);
      // setPropertyValue(true,'generic','w','100%');
      document.getElementById("Form_generic_v_line").value = width;
      document.getElementById("Form_generic_w").value = '100%';
      document.getElementById("Form_generic_w").focus();
      document.getElementById("Form_generic_w").blur();
      writeHTML(true);
    }
  }else{
    if(Empty(formProp.layout_step) && !Empty(v_line) && width.indexOf('%')>-1){
      document.getElementById("Form_generic_w").value = formProp.v_line;
      //setPropertyValue(true,'generic','v_line','');
      document.getElementById("Form_generic_v_line").value = '';
      formProp.v_line='';
      //setPropertyValue(true,'generic','w',formProp.v_line);
      document.getElementById("Form_generic_w").focus();
      document.getElementById("Form_generic_w").blur();
      writeHTML(true);
    }
  }
}
function setCurrentPage(v){
  if(v != formProp.page ){
    updateLayoutSteps(null,formProp.layout_step,formProp.page-1,v-1);
    formProp.page = v;
    newFormPropObj.updatePropertiesFromPaint(formProp);
    // formProp.currH = formProp.pagesProp[formProp.page-1].h;
    // formProp.currW = formProp.pagesProp[formProp.page-1].w;
    writeHTML(true);
  }
}
function setPagesProp( v, the_property, multiple_index){
  var p;
  if(the_property =='pages_names'){
    p='title';
  }else if(the_property == 'page_layer'){
    p='layer';
  }else{
    p=the_property;
  }
  formProp.pagesProp[multiple_index][p] = v; // oggetto che contiene le prop di una pagina
  writeHTML(true);
}
function CreateTemplateConnectors(v){
  var str='';
  var regExp = /\{\{\s*((\w|\W(?!\}}))*.)/gm;
  //var regExp = /(?<=\{{)(.*?)(?=\}})/gm;
  var g = v.match(regExp);
  for(var i=0; i<g.length; i++){
    //var regExpr2 = /(?<=\%)(.*?)(?=\%)/gm;
    var g2 = g[i].split('%');
    //var g2 =  g[i].match(regExpr2);
    for(var ii=1;ii<g2.length;ii++){
      str+=g2[ii]+',';
      ii+=2;
    }
  }
  if(str.lastIndexOf(',')>-1){
    str = str.substring(0,str.lastIndexOf(','));
  }
  setPropertyValue(false,'functional','dataobjs',str);
}
function ListObj(obj) {
  /**
   * Simula la clickitem
   */
  if(obj.value || obj.item ){
    removeAllHandlers()
    var obk = obj.item;
    if(obj.value ) {
      for(var i=0;i<itemsHTML.length;i++) {
      if(itemsHTML[i].id=="item"+obj.value){
        obk=itemsHTML[i];
        break;
      }
      }
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

function editDesc(id,isFormProp,propName){
  var width = 500;
  var height = 300;
  var left = (window.document.getWidth()) ? (window.document.getWidth() - width) / 2 : 100;
  var top = (window.document.getHeight()) ? (window.document.getHeight() - height) / 2 : 100;
  var url = "../portalstudio/insert_desc.html?isFormProp="+isFormProp+"&id="+id+(!Empty(propName)?"&propName="+propName:"");
  openSPModalLayer(url, parseInt(top), parseInt(left), width, height, true, 1, false, true);
}

function selectDate(obj){
  if(window.datePicker)
    window.datePicker.destroy();
  window.datePicker = new Picker.Date(document.getElementById(obj.refId), {
    toggle: obj.button,
    timePicker : (obj.time ? obj.time : false),
    onClose :function(){$(obj.refId).focus();}
  });
  window.datePicker.position(obj.button,'right')
  window.datePicker.fireEvent('attached',[event,obj.button]);
  window.datePicker.show();
}


function addPage(){
  formProp.npages++;
  formProp.page=formProp.npages;
  var pagesArray = formProp.pages.split(',');
  var pagesTitleArray = formProp.pages_names.split(',');
  var pagesLayerArray = formProp.page_layer.split(',');
  var pagesHeightArray = formProp.h.toString().split(',');
  var pagesWidthArray = formProp.w.toString().split(',');
  pagesArray.push(formProp.npages);
  pagesTitleArray.push('');
  pagesLayerArray.push('');
  pagesHeightArray.push(formProp.pagesProp[formProp.page-2].h);
  pagesWidthArray.push(formProp.pagesProp[formProp.page-2].w);
  //Array delle prop di pagina
  formProp.pagesProp.push({
    'title':'',
    'layer':'',
    'h':formProp.pagesProp[formProp.page-2].h,
    'w':formProp.pagesProp[formProp.page-2].w,
    'layout_steps_values' : JSON.parse(JSON.stringify(formProp.pagesProp[formProp.page-2].layout_steps_values?formProp.pagesProp[formProp.page-2].layout_steps_values:{}))
  });
  //--
  formProp.pages = pagesArray.join();
  formProp.pages_names = pagesTitleArray.join();
  formProp.page_layer = pagesLayerArray.join();
  formProp.h = pagesHeightArray.join();
  formProp.w = pagesWidthArray.join();
  FormProperties(true,false);
  index=null;
  mainitem=null;
  writeHTML(true);
}
function insertPageBefore() {
  if (formProp.npages==1) return;
  formProp.npages++;
  for (var i=0;i<itemsHTML.length;i++){
    var l_itm = itemsHTML[i];
    if (parseInt(l_itm.page)>=parseInt(formProp.page)) {
      l_itm.page++;
    }
  }
  //riscrivo le pagine numerate in sequenza corretta
  var pagesArray = [];
  var pagesTitleArray = formProp.pages_names.split(',');
  var pagesLayerArray = formProp.page_layer.split(',');
  for(let i=0;i<formProp.npages;i++){
    pagesArray[i] = i+1;
  }
  pagesTitleArray.splice(formProp.page-1,0,'');
  pagesLayerArray.splice(formProp.page-1,0,'');
  formProp.pagesProp.splice(formProp.page-1,0,{'title':'',
    'layer':'',
    'h':formProp.pagesProp[formProp.page-1].h,
    'w':formProp.pagesProp[formProp.page-1].w,
    'layout_steps_values' : JSON.parse(JSON.stringify(formProp.pagesProp[formProp.page-1].layout_steps_values))
  });
  formProp.pages = pagesArray.join();
  formProp.pages_names = pagesTitleArray.join();
  formProp.page_layer = pagesLayerArray.join();
  FormProperties(true,false);
  index=null;
  mainitem=null;
  writeHTML(true);
}

function deletePage(obj) {
  if (formProp.npages==1) return;
  var conf = confirm("All elements of current page will be deleted. Are you sure?");
  if (!conf) return;
  itemsHTML = itemsHTML.filter(function(itm) {
    if (parseInt(itm.page) == parseInt(formProp.page)) {
      countindex--;
      return false;
    } else if (parseInt(itm.page) > parseInt(formProp.page)) {
      itm.page--;
    }
    return true;
  });
  //rimovo dall'array delle prop di page
  formProp.pagesProp.splice(formProp.page-1,1);
  formProp.npages--;
  if (parseInt(formProp.page)>parseInt(formProp.npages)) {
    formProp.page = formProp.npages;
  }
  window.delMultipleProp(obj,true,true);
  //riscrivo le pagine numerate in sequenza corretta
  var pagesArray = [];
  for(let i=0;i<formProp.npages;i++){
    pagesArray[i] = i+1;
  }
  formProp.pages = pagesArray.join();
  index=null;
  mainitem=null;
  FormProperties(true,false);
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
  var row, rows, i;
  if(retDesc==true)
    var desc=[];
  var AllField = new JSURL("../servlet/SPVQRProxy?action=fields&filename="+queryname, true);
  AllField = AllField.Response();
  if(Left(AllField,9)=="BO_QUERY:"){
    AllField = Substr(AllField,10);
    var CSV_SEP="#!$";
    rows = AllField.split(CSV_SEP);
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
    rows = GetProperty(l_oFields,'Rows','N');
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
var the_Property;
function BuildExpression(PortletItemIndex,the_property,the_propertyId,type,dataobjref){
  TempArray = [];
  the_Property=the_property;
  var PortletItemDataObjName, offlinemode = itemsHTML[index].offline;
  if(dataobjref)
    PortletItemDataObjName = itemsHTML[PortletItemIndex][dataobjref];
  else
    PortletItemDataObjName = itemsHTML[PortletItemIndex].dataobj;
  var PortletItemDataObj = null;
  var i=0;
  while (i<itemsHTML.length && PortletItemDataObj == null){
    if (itemsHTML[i].name == PortletItemDataObjName) {
      PortletItemDataObj = itemsHTML[i]
    }
    i++;
  }
  if(PortletItemDataObj!=null)
    if (PortletItemDataObj.GetQueryFields)
      TempArray=PortletItemDataObj.GetQueryFields(PortletItemDataObj.query,the_property!='field');
    else if (PortletItemDataObj.query)
      TempArray=GetQueryFields(PortletItemDataObj.query,the_property!='field'); //retrocompatibilita', richiamo la globale
  if(the_property=='field' || type=='datafield' ||  type=='singlefield'){
    if(PortletItemDataObj!=null)  {
      window.layerOpenForeground("select_fields.html?for=" + PortletItemIndex+"&rtrnobj="+the_property+"&queryname="+URLenc(PortletItemDataObj.query)+"&offline="+URLenc(PortletItemDataObj.offline)+"&isSingleValue="+(type=='singlefield'?'true':'false'),"SelectField",'',350,500,true,1);
    } else
      PSAlert.alert("Select a data object");
  }else if(type=='table') {
    getTable(the_property,offlinemode);
  }else if(type=='bofield'){
    openSPModalLayer("../jsp-system/SPVQREditorSelectBO_portlet.jsp?callerFunction=SelectBO&hideLinkedTables=true&offlinemode="+offlinemode, 100, 200, 500, 500, false, 1, false,false);
    //window.open("../jsp-system/SPVQREditorSelectBO_portlet.jsp?callerFunction=SelectBO&hideLinkedTables=true", "SelectBO", "height=600,width=500,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
  }else if(type=='exp'){
    window.layerOpenForeground("../portalstudio/expression_builder.jsp?tool=ctrlsExpressions&ExpressionID="+the_propertyId+"&callerFunction=SetReturnVal","exp_builder",'',500,600,true,1);
  }else{
    window.layerOpenForeground("columnBuilder.html?for="+PortletItemIndex+"&prop="+the_property,"exp_builder",'',800,700,false,1);
  }
}
/*
function GetFunctionsForExpBuilder() {
  return [{
      name : "functionsName",
      desc : "Available Options",
      prefix : "",
      postfix : "",
      functions : [
        ["%", "", "Separator for field value Es.:%myVar%, %field%"],
        ["var:", "", "Es.var:myVar"],
        ["html:", "", "Es.:html:"+ToHTML("<b>")+"%myField%"+ToHTML("</b>")],
        ["function:", "", "Es.:function:myFunc(%myField%,..)"],
        ["eval:", "", "Es.:eval:myExpr"],
        ["checkbox:", "", "Es.:checkbox:myField"],
        ["combobox:", "", "Es.:combobox:columnField:myDatobj:value_fld:label_fld:bHasEmptyValue<br>" +
         "Es.:combobox:columnField:[[value1,label1],[value2,label2],..]:bHasEmptyValue"],
        ["image:", "", "Es.:image:myUrl:myTooltip"],
        ["bar:", "", "Es.:bar:Value,Value min,Value max,bg. color,color,css class"],
        ["template:", "", "Es.:template:"+ToHTML("<div>")+"{{ \"%this.myField%\" }} - {{\"%myVariable%\"}}"+ToHTML("</div>")]
      ]
    }
  ]
}
*/
function GetObjsForExpBuilder() {
  var i;
  var FuncList =[];
  readLibrary("../portalstudio/standardfunctions.xml", FuncList);
  var objsAvailable =[
    {
      name : "Functions",
      desc : "System Functions",
      prefix : "",
      postfix : "()",
      functions : FuncList
    },
    {
      name : "functionsName",
      desc : "Available Variables",
      prefix : "",
      postfix : "",
      functions :[]
     }
  ];
  for(i=0;i<itemsHTML.length;i++){
    var type = itemsHTML[i].type;
    var name = itemsHTML[i].name;
    if(type == 'Variable'){
      objsAvailable[1].functions.push([name,"",name]);
    }
  }
  return objsAvailable;
}

function SetReturnVal(ReturnObjectId,val) {
  document.getElementById(ReturnObjectId).value  = val;
  document.getElementById(ReturnObjectId).focus();
  document.getElementById(ReturnObjectId).blur();
  writeHTML();
  Properties();
}

function GetExpressionFromId(id){
  if (id) {
    var el = document.getElementById(id);
    if (el)
      return el.value;
  }
  return "";
}

function openConfigZoom(el){
  var tableProp='table';
  if (itemsHTML[index].type=='XZoom'){
    the_Property='config';
    tableProp='tableName';
  }
  else{
    the_Property='configname';
  }
  if (!Empty(itemsHTML[index][tableProp]))
    openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_list.jsp?action="+the_Property+"&tableName="+itemsHTML[index][tableProp]+"&parameter="+itemsHTML[index][el.refPropId]+"&SPModalLayerId=mskSPModalLayer", 100, 100, 500, 500, false, 1, false,false)
  else PSAlert.alert('No table selected');
}
function pickerBO(the_property,isForm){
  var offlinemode = false;
  if(index!=null){
    offlinemode = itemsHTML[index].offline;
  }
  openSPModalLayer("../jsp-system/SPVQREditorSelectBO_portlet.jsp?hideLinkedTables=true&offlinemode="+offlinemode+'&propRef='+the_property+'&isForm='+isForm, 100, 200, 500, 500, false, 1, false,false);
}

function getTable(prop,offlinemode){
  prop = prop.refPropId || prop;
  offlinemode = offlinemode || formProp.offline;
  openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_list.jsp?action=tableName&parameter="+itemsHTML[index][prop]+"&SPModalLayerId=mskSPModalLayer&offlinemode="+offlinemode, 100, 200, 500, 500, false, 1, false,false)
}

function editZoom(){
  var tableProp='table', configProp="configname";
  if (itemsHTML[index].type=='XZoom'){
    tableProp='tableName';
    configProp="config";
  }
  if(LRTrim(itemsHTML[index][tableProp])=="")
    PSAlert.alert("No table selected.");
  else if(LRTrim(itemsHTML[index][configProp])=="")
    PSAlert.alert("No zoom configuration selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj(itemsHTML[index][configProp]+'['+itemsHTML[index][tableProp]+']',"portalzoom");
  else
    window.open("../portalzoom/portalzoomeditor.jsp?&Table="+itemsHTML[index][tableProp]+"&ConfigName="+URLenc(itemsHTML[index][configProp]),"Zoom","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function newZoom(){
  var tableProp='table';
  if (itemsHTML[index].type=='XZoom'){
    tableProp='tableName';
  }
  if(LRTrim(itemsHTML[index][tableProp])=="")
    PSAlert.alert("No table selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj('['+itemsHTML[index][tableProp]+']',"portalzoom");
  else
    window.open("../portalzoom/portalzoomeditor.jsp?&Table="+itemsHTML[index][tableProp],"Zoom","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}

function openLinkedField(el){
  SPTheme.modalLayerPreferredWidth=500;
  var textAndVar=getTextAndVar().toString();
  openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_filterList.jsp?action="+el.refPropId+"&allField="+textAndVar+"&allFieldDescription="+textAndVar+"&fieldSelected="+itemsHTML[index][el.refPropId]+"&SPModalLayerId=filterMskSPModalLayer", 100, 100, 500, 500, false, 1, false,false);
}

function openTableFields(el){
  SPTheme.modalLayerPreferredWidth=500;
  openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_filterTableList.jsp?multiple=true&action="+el.refPropId+"&fieldSelected="+itemsHTML[index][el.refPropId]+"&SPModalLayerId=filterMskSPModalLayer&tableName="+itemsHTML[index].table+"&configName="+itemsHTML[index].configname+"&offline="+itemsHTML[index].offline, 100, 100, 500, 500, false, 1, false,false);
}

function openReadField(el){
  SPTheme.modalLayerPreferredWidth=500;
  var textAndVar=getTextAndVar().toString();
  openSPModalLayer("../maskparameters/SPMaskParametersConfigurator_list.jsp?action=readfield&parameter="+itemsHTML[index][el.refPropId]+"&tableName="+itemsHTML[index].table+"&allField="+textAndVar+"&allFieldDescription="+textAndVar+"&linkedField="+itemsHTML[index].intovars+"&SPModalLayerId=mskSPModalLayer",100, 100, 500, 500, false, 1, false,false);
}

function loadFieldName(value,action){
  itemsHTML[index][action]=value;
  Properties();
}

function loadValue(action, value,value2) {
  if (action=='readfield'){
    itemsHTML[index].readfields=value;
    itemsHTML[index].intovars=value2;
  }
  else
    itemsHTML[index][the_Property||action]=value;
  Properties();
}

function editPortlet(ref){
  var url=document.getElementById(ref).value;
  if(!Empty(url)){
    url=Strtran(url,"_portlet.jsp","")
    if(url.indexOf("?")>-1){
      url = url.substring(0,url.indexOf("?"));
    }
  if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    window.parent.newCurrentObj(url,"portlet",{});
  else
    window.open("editor.jsp?id="+url, "portleteditor", "resizable=yes,status=no,toolbar=no,menubar=no,location=no");
  }
}
function selectPortlet(retTo){
  var width = 800;
  var height = 600;
  var left = (screen.width) ? (screen.width - width) / 2 : 100;
  var top = (screen.height) ? (screen.height - height - (height / 4)) / 2 : 100;
  openSPModalLayer("../portalstudio/open.jsp?tool=portlet&onetool=true&ExpressionID="+retTo+"&callerFunction=ExpressionBuilderReturn&SPModalLayerId=querySPModalLayer", top, left, width, height, true, 1, false, false);
  //window.layerOpenForeground("insert.jsp?for="+retTo,"SelectPortlet",'',400,600,true,1);
  //window.open("insert.jsp?for="+retTo, "SelectPortlet", "width=350,height=358,top=300,left=300,scroll=no,status=no,toolbar=no,resizable=yes");
}
function selectReceiver(parsObj){
  window.layerOpenForeground("../portalstudio/open.jsp?tool=portlet&onetool=true&ExpressionID="+parsObj.refId+"&callerFunction=listReceiversOfPortlet&SPModalLayerId=SPModalLayer&close-sidebar=true", "SelectReceiver", '', 1000, 600, true, 1);
  //window.open("insert.jsp?for="+retTo, "SelectPortlet", "width=350,height=358,top=300,left=300,scroll=no,status=no,toolbar=no,resizable=yes");
}

function listReceiversOfPortlet(id, name) {
  let argsObj = {
    "tool": 'getportletctrls',
    "ExpressionID": id,
    "dimensions":{
        "top": null,
        "left": null,
        "width": 600,
        "height": 400,
        },
    "fromPortletName": name,
    "ctrlsToBeListed": 'receiver',
  }
  PickItems(argsObj);
}

function selectEmitter(parsObj){
  window.layerOpenForeground("../portalstudio/open.jsp?tool=portlet&onetool=true&ExpressionID="+parsObj.refId+"&callerFunction=listEmittersOfPortlet&SPModalLayerId=SPModalLayer&close-sidebar=true", "SelectEmitter", '', 1000, 600, true, 1);
  //window.open("insert.jsp?for="+retTo, "SelectPortlet", "width=350,height=358,top=300,left=300,scroll=no,status=no,toolbar=no,resizable=yes");
}

function listEmittersOfPortlet(id, name) {
  let argsObj = {
    "tool": 'getportletctrls',
    "ExpressionID": id,
    "dimensions":{
        "top": null,
        "left": null,
        "width": 600,
        "height": 400,
        },
    "fromPortletName": name,
    "ctrlsToBeListed": 'emitter',
  }
  PickItems(argsObj);
}

function SelectBO(boName){
  itemsHTML[index][the_Property]=Strtran(boName,"BO:","");
  Properties();
}
function SelectItems(PortletItemIndex,the_property){
  window.layerOpenForeground("select_items.html?index=" + PortletItemIndex+"&rtrnobj="+the_property,"selectItems",'',350,500,true,1);
 //window.open("select_items.html?index=" + PortletItemIndex+"&rtrnobj="+the_property, "SelectItems", "height=196,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
}
function PickParameters(PortletItemIndex,the_property/*,idProp,type*/){
  window.layerOpenForeground("parameter_picker.jsp?index=" +PortletItemIndex+"&rtrnobj="+the_property,"SelectParam",'',600,500,true,1);
  //window.open("parameter_picker.jsp?index=" +PortletItemIndex+"&rtrnobj="+the_property, "SelectParam", "height=500,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
}
/*
function SelectQuery(PortletItemIndex,isForm,retObjId){
  var PortletItemName = itemsHTML[PortletItemIndex].name;
  var PortletItemDataObj = itemsHTML[PortletItemIndex].dataobj;
  TempArray = new JSURL("../servlet/SPVQRProxy?action=vqr&offlinemode="+(itemsHTML[PortletItemIndex].type=='WebSQLDataProvider' || itemsHTML[PortletItemIndex].offline=='true')).Response().replace(/\.vqr(\.offline)?/gi, '');
  if(TempArray.match("ACCESS DENIED")){
    window.layerOpenForeground("../servlet/SPVQRProxy?action=vqr","Select_Query",'',350,500,true,1);
    //window.open("../servlet/SPVQRProxy?action=vqr", "SelectQuery", "height=100,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
  }else {
    TempArray = JSON.parse(TempArray,true);
    var width = 800;
    var height = 600;
    var left = (screen.width) ? (screen.width - width) / 2 : 100;
    var top = (screen.height) ? (screen.height - height - (height / 4)) / 2 : 100;
    openSPModalLayer("../portalstudio/open.jsp?tool=visualquery&onetool=true&ExpressionID="+retObjId+"&callerFunction=ExpressionBuilderReturn&SPModalLayerId=querySPModalLayer", top, left, width, height, true, 1, false, false);
  }
}
*/
function EditQuery(index) {
  if(LRTrim(itemsHTML[index].query)=="")
    PSAlert.alert("No query selected.");
  else if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    parent.newCurrentObj(itemsHTML[index].query,"visualquery",{offlinemode:(itemsHTML[index].type=='WebSQLDataProvider' || itemsHTML[index].offline=='true')});
  else
    window.open("../visualquery/index.jsp?filename="+itemsHTML[index].query+"&offlinemode="+(itemsHTML[index].type=='WebSQLDataProvider' || itemsHTML[index].offline=='true'),"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function NewQuery(index) {
  if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    parent.newCurrentObj('New','visualquery',{offlinemode:(itemsHTML[index].type=='WebSQLDataProvider' || itemsHTML[index].offline=='true')});
  else
    window.open("../visualquery/index.jsp&offlinemode="+(itemsHTML[index].type=='WebSQLDataProvider' || itemsHTML[index].offline=='true'),"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function EditClientQuery(obj) {
  var index = obj.index;
  //var propId = obj.refId;
  var propInput = obj.refPropId;
  window.layerOpenForeground("../visualquery/index.jsp?simplemode=true&for=" + index + "&prop=" + propInput, "Edit query", "", 600, 450, true, 1, null, null, null, true);
  // url, name, args, opt_width_pref, opt_height_pref, opt_resizable_pref, force, entryPoint, cinema_morph_ms, hide_buttons, maximized
}
ZTObjects.EditQuery = function(obj) {
  editDesc(obj.refId, false, obj.refPropId);
}

function EditEventEmitter(index) {
  window.layerOpenForeground("../visualweb/eventemitter_edit.html?objIdx="+index+"","eventemitter_editor",'',600,450,true,1);
  //window.open("../visualweb/eventemitter_edit.html?objIdx="+index+"", "eventemitter_editor","height=450,width=600,resizable=yes,status=yes,toolbar=no,menubar=no,location=no");
}
function EditEventReceiver(index) {
  window.layerOpenForeground("../visualweb/eventreceiver_edit.html?objIdx="+index+"","eventreceiver_editor",'',600,450,true,1);
  //window.open("../visualweb/eventreceiver_edit.html?objIdx="+index+"", "eventreceiver_editor","height=450,width=600,resizable=yes,status=yes,toolbar=no,menubar=no,location=no");
}
function hideProperties(id) {
  var ctrl = Ctrl(id)
  // var canvas = document.getElementById('backcanvas');
  // var ww;if(v_line!=" ") ww=parseInt(v_line);else ww=formProp.w;
  // if (canvas.offsetWidth == 0 || ctrl.offsetLeft > 0 && ctrl.offsetLeft < (parseInt(ww) + canvas.getPosition().x)
  //     && ctrl.offsetTop < (parseInt(formProp.h) + canvas.getPosition().y)){
  if( ctrl ){
    ctrl.style.display='none';
    jQuery('#'+id +' #ctrlSelectList').select2('close');
  }
  // }
  hidePreSet();

}
function showProperties(id) {
  if(index!=null){
    var ctrl = Ctrl(id)
    // var canvas = document.getElementById('backcanvas');
    // var ww;if(v_line!=" ") ww=parseInt(v_line);else ww=formProp.w;
    // if (canvas.offsetWidth == 0 || ctrl.offsetLeft == 0 || (ctrl.offsetLeft < (parseInt(ww) + canvas.getPosition().x)
    //     && ctrl.offsetTop < parseInt(formProp.h) + canvas.getPosition().y))
    ctrl.style.display='block'
  }
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
function checkVLine(v,prop,input,multiple_index){
  if(!multiple_index){
    multiple_index = formProp.page-1;
  }
  if(!Empty(formProp.layout_step)){ // Se impostati i layout step queste prop non sono editabili
    return true;
    PSAlert.alert('Not Editable if a layout steps is set !');
    return false;
  }
  //Se impostata la v_line la width dev'essere in %
  if(prop.propID =='w'){
    if(getPropertyValue(true,'generic','adaptive') =='adaptive' && v.indexOf('%')==-1){ //la Width dev'essere in %
      PSAlert.alert('If is set adaptive mode the width must be in % !');
      document.getElementById("Form_generic_w").value = formProp.pagesProp[multiple_index].w;
      return false;
    }
    // if(!Empty(formProp.v_line) && v.indexOf('%')==-1) {
      // PSAlert.alert('Width must be in % widh vertical line set !');
    // }
    if(v.indexOf('%')>-1 && Empty(formProp.v_line)){
      formProp.v_line=formProp.pagesProp[multiple_index].w;
      document.getElementById("Form_generic_v_line").value = formProp.pagesProp[multiple_index].w;
    }
  }
  if(prop=='v_line'){
    if(formProp.adaptive=='adaptive' && Empty(v)){
      PSAlert.alert('If is set adaptive mode not empty value allowed for vertical reference !');
      return false;
    }
    if(Empty(v) && formProp.pagesProp[multiple_index].w.indexOf('%')>-1){
      PSAlert.alert('if width is in  % vertical line is obligatory !');
      return false;
    }
    if(!Empty(v) && formProp.pagesProp[multiple_index].w.indexOf('%')==-1) {
      //formProp.w='100%';
      document.getElementById("Form_generic_w").value='100%';
      document.getElementById("Form_generic_w").focus();
      document.getElementById("Form_generic_w").blur();
      //PSAlert.alert('Width must be in % !');
    }
  }
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

function IsValidCheckboxValues(v){
  if (Eq(v,'numeric')){
    if (isNaN(itemsHTML[index].checked_value))
      itemsHTML[index].checked_value=1;
    if (isNaN(itemsHTML[index].unchecked_value))
      itemsHTML[index].unchecked_value=0;
  }
  else if (Eq(v,'logic')){
    if (!((Eq(itemsHTML[index].checked_value,'true'))||(Eq(itemsHTML[index].checked_value,'false'))))
      itemsHTML[index].checked_value='true';
    if (!((Eq(itemsHTML[index].unchecked_value,'true'))||(Eq(itemsHTML[index].unchecked_value,'false'))))
      itemsHTML[index].unchecked_value='false';
  }
  return true;
}

function IsLogicInput(v){
  if (!((Eq(v,'true')||Eq(v,'false')))){
    PSAlert.alert('Not a logic value!')
    return false;
  }
  return true;
}

function IsValidValue(v){
  if (!IsObligatory(v))
    return false;
  if (Eq(itemsHTML[index].typevar,'numeric'))
    return IsNumericInput(v);
  else if (Eq(itemsHTML[index].typevar,'logic'))
    return IsLogicInput(v);
  return true;
}

function LoadFileList(){
	if (index != null) {
		var width = 315;
		var height = 225;
		var isType = false;
		var titleDiv = "Available_Download_File_Format";
    var val = (!itemsHTML[index].downloadlist || Empty(itemsHTML[index].downloadlist)) ? "" : itemsHTML[index].downloadlist;
		var url = "../portalstudio/download_chart.jsp?objIdx=" + index + "&ExpressionValue=" + val + "&titleDiv=" + titleDiv + "&isType=" + isType;
		var additionalUrl = "&SPModalLayerId=downloadChartSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1);
	}
}

function downloadChartReturn(id, value, isType) {
	SetUpdated();
	if (id != null){
		if (CharToBool(isType + ""))
			itemsHTML[id].other_chart = value;
		else
			itemsHTML[id].downloadlist = value;
		Properties();
	}
	return;
}

function GetAvailableDownloadFormat(){
	return availableDownloadFormat;
}

function LoadChartList(){
	if (index != null) {
		var width = 400;
		var height = 400;
		var isType = true;
		var titleDiv = "Available_Chart_Types";
    var val = (!itemsHTML[index].other_chart || Empty(itemsHTML[index].other_chart)) ? "" : itemsHTML[index].other_chart;
		var url = "../portalstudio/download_chart.jsp?objIdx=" + index + "&ExpressionValue=" + val +"&titleDiv=" + titleDiv + "&isType=" + isType + "&chartType=" + itemsHTML[index].chart_type;
		var additionalUrl = "&SPModalLayerId=downloadChartSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1);
	}
}

function SetUpdated(){
	m_bUpdated = true;
}

function ShowMoreInfo(){
	if (index != null) {
		var width = 515;
		var height = 220;
		var propName = GetPropertyName(arguments[0].refId.slice(0,arguments[0].refId.indexOf(arguments[0].refPropId)-1),arguments[0].refPropId);
		var url = "../portalstudio/more_info.jsp?tool=" + tool + "&objName=" +  itemsHTML[index].type + "&propID=" + arguments[0].refPropId + "&propName=" + propName;
		var additionalUrl = "&SPModalLayerId=moreInfoSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1);
	}
}

function GetPropertyName(tabName,prop){
	if(index != null){
		var tabArray = itemsHTML[index].objClass.newProperties[tabName];
		for(var i=0; i<tabArray.length; i++){
			if(tabArray[i].propID == prop)
				return tabArray[i].name;
		}
	}
}

function getChartFieldValue(vtype, ctype/*, qname*/) {
  // valido solo x tool portlet - in altri (report/zoom) viene ridefinito
  var ret = "";
  switch (vtype) {
    case "domain":
      if(ctype=="category")
        ret = getPropertyValue(false,'fields','label_field');
      else if(ctype=="xyz")
        ret = getPropertyValue(false,'fields','x_field');
      else
        ret = getPropertyValue(false,'fields','measure_series_field');
      break;
    case "values":
      if(ctype=="category")
        ret = getPropertyValue(false,'fields','value_fields');
      else if(ctype=="xyz")
        ret = getPropertyValue(false,'fields','y_field')+","+getPropertyValue(false,'fields','z_field');
      else // retrocompatibilita' measure
        ret = getPropertyValue(false,'fields','min_field')+","+getPropertyValue(false,'fields','max_field')+","+getPropertyValue(false,'fields','val_field');
      break;
    case "series":
      if(ctype=="category")
        ret = getPropertyValue(false,'fields','label_series');
      else if(ctype=="xyz")
        ret = getPropertyValue(false,'fields','xyz_series_field');
      else
        ret = "";
      break;
    case "key":
      if(ctype=="category")
        ret = getPropertyValue(false,'fields','labelKey_field');
      else if(ctype=="xyz")
        ret = getPropertyValue(false,'fields','xKey_field');
      else
        ret = getPropertyValue(false,'fields','measureKey_series_field');
      break;
  }
  return ret;
}

function receiveConfigFields(robj) {
  if (index != null) {
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
        setPropertyValue(false, "fields", prop, val);
        itemsHTML[index][prop] = val;
      }
    }
    else {
      var domain = robj.domain,
      values = robj.values,
      z = robj.z,
      series = robj.series || robj.snames,
      key = robj.key;
      switch (Lower(itemsHTML[index].chart_type)) {
        case "category":
        case "measure":
          setPropertyValue(false,'fields','label_field',domain);
          setPropertyValue(false,'fields','value_fields',values);
          setPropertyValue(false,'fields','labelKey_field',key);
          setPropertyValue(false,'fields','label_series',series);
          itemsHTML[index].label_field=domain;
          itemsHTML[index].value_fields=values;
          itemsHTML[index].labelKey_field=key;
          itemsHTML[index].label_series=series;
          break;
        case "xyz":
          setPropertyValue(false,'fields','x_field',domain);
          setPropertyValue(false,'fields','y_field',values);
          setPropertyValue(false,'fields','z_field',z);
          setPropertyValue(false,'fields','xyz_series_field',series);
          setPropertyValue(false,'fields','xKey_field',key);
          itemsHTML[index].x_field=domain;
          itemsHTML[index].y_field=values;
          itemsHTML[index].z_field=z;
          itemsHTML[index].xyz_series_field=series;
          itemsHTML[index].xKey_field=key;
          break;
      }
    }
  }
}

function preSetSet(index,v){
  var obj =v;
  var currObj=itemsHTML[index];
  for(var i in obj){
    if(i!='name' && i!='value' && i!='wire_h' && i!='wire_w' && i!='preset'){
      if(currObj.type=='Grid' && i=='colProperties' && currObj.colProperties && Object.keys(currObj.colProperties).length>0) // non modifico le colonne se sono già impostate
        continue;
      currObj[i]=obj[i];
    }
  }
  writeHTML();
}
function renderPreSet(objclick){
  if(document.getElementById('PreSetContainer')){
    window.document.body.removeChild(document.getElementById('PreSetContainer'));
    return;
  }
  var currObj=itemsHTML[index];
  if(!currObj.objClass.preSet)return;
  var pos=LibJavascript.DOM.getPosFromFirstRel(objclick,window.document.body);
  var PreSetContainer = new Element('ul',{'id':'PreSetContainer','class':'PreSetContainer'}).inject(window.document.body);
  var top,left;
  if(objclick.id=='properties_preSetH'){
    top=pos.y+objclick.offsetHeight;
    left=pos.x;
  }else{
    top=pos.y;
    left=(pos.x+objclick.offsetWidth/2);
  }
  PreSetContainer.setStyles({'top':top+'px','left':left+'px'});
  var PreSetTitle=new Element('li',{'html':'Select a type of '+currObj.type,'class':'PresetTitle'});
  PreSetTitle.inject(PreSetContainer);
  // PreSetContainer.addEvents({
    // 'mouseleave':function(){if(document.getElementById('PreSetContainer'))window.document.body.removeChild(document.getElementById('PreSetContainer'));}
    // });
  for(var r=0;r<currObj.objClass.preSet.length;r++){
    var preset=currObj.objClass.preSet[r];
    //var preSetLi=new Element('li',{'text':itemsHTML[index].objClass.preSet[r]['name']});
    var preSetLi=new Element('li',{'html':currObj.objClass.wireframe(preset),'title':preset.name});
    if(preset.wire_h)preSetLi.setStyle('height',preset['wire_h']);
    if(preset.wire_w)preSetLi.setStyle('width',preset['wire_w']);
    //preSetLi.setStyle('margin','0 auto');
    preSetLi.inject(PreSetContainer);
    preSetLi.addEvents({
      'click':function(index,preset){preSetSet(index,preset);window.document.body.removeChild(document.getElementById('PreSetContainer'));}.pass([index,preset])
    });
  }
  if(PreSetContainer.offsetHeight+PreSetContainer.offsetTop>document.getElementById('canvas').offsetHeight)
   PreSetContainer.setStyle('top',PreSetContainer.offsetTop - ( PreSetContainer.offsetHeight+PreSetContainer.offsetTop-document.getElementById('canvas').offsetHeight));
}
function hidePreSet(){
  if(document.getElementById('PreSetContainer')){
    window.document.body.removeChild(document.getElementById('PreSetContainer'));
    return;
  }
}

function fillLayoutStep(){
//Riempio gli step con valori di default
  if(Empty(formProp.steps)){
    formProp.steps='320,480,768';
    formProp.layout_step='320';
    //formProp.w='100%';
    formProp.pagesProp[formProp.page-1].w = '100%';
    let arrayW = formProp.w.split(',');
    arrayW[formProp.page-1] = formProp.pagesProp[formProp.page-1].w;
    formProp.w = arrayW.join();
    //riempio l'oggetto layout step value per ogni pagina
    for(var i=0;i< formProp.pagesProp.length;i++){
      for(var ii = 0,Steps = formProp.steps.split(','); ii< Steps.length ;ii++){
        if(!formProp.pagesProp[i].layout_steps_values[Steps[ii]]){
          formProp.pagesProp[i].layout_steps_values[Steps[ii]] = {};
          formProp.pagesProp[i].layout_steps_values[Steps[ii]]['h'] = formProp.pagesProp[i].h;
          formProp.pagesProp[i].layout_steps_values[Steps[ii]]['w'] = formProp.pagesProp[i].w;
        }
      }
     }
    updateLayoutSteps(null,'320');
    FormProperties(true);
  }else{
    PSAlert.alert("Delete existing steps !");
  }
}

function fillBoItems(){
  //if(!Empty(formProp.altInterfaceFor)){
    window.layerOpenForeground({
      url: "../jsp-system/SPBOTreeItemsPicker_portlet.jsp?selectedBO="+ (!Empty(formProp.altInterfaceFor)?formProp.altInterfaceFor:'') + (!Empty(window.m_cID)?'&m_cID='+window.m_cID:''),
      name: "BO_Items_Picker",
      opt_width_pref: 1200,
      opt_height_pref: 1200,
      opt_resizable_pref: true,
      force: 1 //,
      // maximized: "true"
    });
  //}
  // else{
  //   PSAlert.alert("First select a BO.");
  // }
}
function LoadRangeMask(){
  if (index != null) {
    var height = 500;
		var width = 600;
    var list = itemsHTML[index].rangebands||"";
		var url = "../portalstudio/trendlines_edit.html?tlList="+list+"&callerFunction=setChartRangeBands&separatorN=_&separatorP=;&separatorTL=|&objIdx="+index;
		var additionalUrl = "&Trendlines_Edit&SPModalLayerId=cgSPModalLayer";
		openNewWindow(url, additionalUrl, height, width, -1, -1);
	}
}

function setChartRangeBands(index,retValue){
  SetUpdated();
  if(index!=null){
    itemsHTML[index].rangebands = retValue;
    Properties();
  }
  return;
}

function SaveChartFieldsConfiguration(ctype,domain,values,series,key){
  if (index != null) {
    switch(itemsHTML[index].chart_type){
      case "category":
        setPropertyValue(false,'fields','label_field',domain);
        setPropertyValue(false,'fields','value_fields',values);
        setPropertyValue(false,'fields','labelKey_field',key);
        //if(!Empty(tool) && tool=="portlet"){
          setPropertyValue(false,'fields','label_series',series);
          itemsHTML[index].label_series = series;
        //}
        /*else if(!Empty(tool) && tool=="report"){
          setPropertyValue(false,'fields','value_labels',series);
          itemsHTML[index].value_labels = series;
        }*/
        itemsHTML[index].label_field = domain;
        itemsHTML[index].value_fields = values;
        itemsHTML[index].labelKey_field = key;
        break;
      case "xyz":
        setPropertyValue(false,'fields','x_field',domain);
        setPropertyValue(false,'fields','y_field',values.split(",")[0]);
        setPropertyValue(false,'fields','z_field',Empty(values.split(",")[1])?"":values.split(",")[1]);
        setPropertyValue(false,'fields','xyz_series_field',series);
        setPropertyValue(false,'fields','xKey_field',key);
        itemsHTML[index].x_field = domain;
        itemsHTML[index].y_field = values.split(",")[0];
        itemsHTML[index].z_field = Empty(values.split(",")[1])?"":values.split(",")[1];
        itemsHTML[index].xyz_series_field = series;
        itemsHTML[index].xKey_field = key;
        break;
      case "measure":
        setPropertyValue(false,'fields','measure_series_field',domain);
        setPropertyValue(false,'fields','min_field',values.split(",")[0]);
        setPropertyValue(false,'fields','max_field',values.split(",")[1]);
        setPropertyValue(false,'fields','val_field',values.split(",")[2]);
        setPropertyValue(false,'fields','measureKey_series_field',key);
        itemsHTML[index].measure_series_field = domain;
        itemsHTML[index].min_field = values.split(",")[0];
        itemsHTML[index].max_field = values.split(",")[1];
        itemsHTML[index].val_field = values.split(",")[2];
        itemsHTML[index].measureKey_series_field = key;
        break;
    }
  }
}

function GetChartWizardInitConf() {
  var conf = null;
  if (index != null) {
    var itm = itemsHTML[index];
    conf = {};
    conf.def = itm.def;
    if (!Empty(itm.dataobj)) {
      conf.dataobj = itm.dataobj;
      conf.fields = {};
      switch (itm.chart_type) {
        case "xyz":
          conf.fields.X = itm.x_field;
          conf.fields.Y = itm.y_field;
          conf.fields.Z = itm.z_field;
          conf.fields.S = itm.xyz_series_field;
          break;
        case "hie":
          conf.fields.allfields = itm.fieldpath;
          conf.fields.V = itm.fieldvalue;
          break;
        case "dep":
          conf.fields.src = itm.depfield_1;
          conf.fields.trg = itm.depfield_2;
          conf.fields.V = itm.depvalue;
          break;
        case "geo":
          conf.fields.src = itm.geo_0_field;
          conf.fields.trg = itm.geo_1_field;
          conf.fields.V = itm.geo_value_field;
          break;
        default:  // category + tipi specifici
          if (itm.ctype == "PIE" || itm.ctype.indexOf("RING") >= 0 || itm.ctype.indexOf("RADAR") >= 0) {
            conf.fields.S = itm.label_field;
            conf.fields.V = itm.value_fields;
          }
          else {
            conf.fields.X = itm.label_field;
            conf.fields.S = itm.sfield;
            conf.fields.Y = itm.value_fields;
          }
          break;
      }
    }
  }
  return conf;
}

function SetChartWizardConfiguration(obj) {
  if (index != null) {
    var itm = itemsHTML[index];
    if (!Empty(obj.def)) {
      setPropertyValue(false, 'generic', 'def', obj.def);
      // setPropertyValue(false, 'generic', 'isDef', true);
    }
    else {
      setPropertyValue(false, 'generic', 'def', "type:" + obj.type);
      // setPropertyValue(false, 'generic', 'isDef', false);
    }
    setPropertyValue(false, 'generic', 'ctype', obj.type);
    var macrotype = getChartMacroType(obj.type);
    if (obj.type == "PCOORDS" || obj.type == "VORONOI" || obj.type == "RINGPERC" || obj.type == "ASTER")
      itm.chart_type = obj.type;
      // setPropertyValue(false, 'dataset', 'chart_type', obj.type);
    else
      itm.chart_type = macrotype;
      // setPropertyValue(false, 'dataset', 'chart_type', macrotype);
    if (!Empty(obj.dataobj)) {
      setPropertyValue(false, 'dataset', 'dataobj', obj.dataobj);
      // campi
      switch (macrotype) {
        case "xyz":
          itm.x_field = obj.fields.X.toString();
          itm.y_field = obj.fields.Y.toString();
          itm.z_field = obj.fields.Z.toString();
          itm.xyz_series_field = obj.fields.S.toString();
          break;
        case "hie":
          itm.fieldpath = obj.fields.allfields.toString();
          itm.fieldvalue = obj.fields.V.toString();
          break;
        case "dep":
          itm.depfield_1 = obj.fields.src.toString();
          itm.depfield_2 = obj.fields.trg.toString();
          itm.depvalue = obj.fields.V.toString();
          break;
        case "geo":
          itm.geo_0_field = obj.fields.src.toString();
          itm.geo_1_field = obj.fields.trg.toString();
          itm.geo_value_field = obj.fields.V.toString();
          break;
        default:  // category + tipi specifici
          if (obj.type == "PIE" || obj.type.indexOf("RING") >= 0 || obj.type.indexOf("RADAR") >= 0) {
            itm.label_field = obj.fields.S.toString();
            itm.value_fields = obj.fields.V.toString();
          }
          else {
            itm.label_field = obj.fields.X.toString();
            itm.sfield = obj.fields.S.toString();
            itm.value_fields = obj.fields.Y.toString();
          }
          break;
      }
    }
    Properties(true);
    document.getElementById("dataset_tab").click();
    document.getElementById("generic_tab").click();
  }
}

function receiveConfigSeries(rindex, rstring) {
  index = parseInt(rindex) || index;
  setPropertyValue(false, 'fields', 'mapSeries', rstring);
  itemsHTML[index].mapSeries = rstring;
}

function receiveConfigClassSeries(rindex, rstring) {
  index = parseInt(rindex) || index;
  setPropertyValue(false, 'fields', 'depclass', rstring);
  itemsHTML[index].depclass = rstring;
}

function renderWizard() {
  var currObj = itemsHTML[index];
  if (!currObj.objClass.wizard || (currObj.objClass.wizard && !currObj.objClass.wizard.hasWizard))
    return;
  window[currObj.objClass.wizard.fncName](index);
}

function SetSmartChartdef(type) {
  if (index != null) {
    var ftype = type;
    if (type.indexOf("type:") == 0) {
      ftype = Strtran(type, "type:", "");
    }
    itemsHTML[index].def = "type:" + ftype;
    itemsHTML[index].ctype = ftype;
    itemsHTML[index].chart_type = getChartMacroType(ftype);
   // itemsHTML[index].isDef = false;
    Properties(true);
  }
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
  document.getElementById('findList').empty();
  // if (hightlElements) {
    // hightlElements = false;
    // HightLight();
  // }
  // Ctrl("highlightSearchDiv").style.display = "none";
  // Ctrl("infosSearch").style.display = "none";
  searchProp.chighlight = false;
  searchProp.csubsistute = false;
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
  searchResult.resultIndices = []; // Array contente l'indice degli elementi che corrispondono ai criteri di ricerca negli array di appartenenza (itemsHTML o reportVariables)
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
  //keyFindArray(reportVariables, searchResult);
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
  var obj, i, tab, oo, propName, propVal;
  //Prop del Form
  for (var o in formProp.objClass.newProperties) {
    tab = formProp.objClass.newProperties[o];
    for (oo = 0; oo < tab.length; oo++) {
      if(!tab[oo].disabled || tab[oo].disabled!='true'){
        propName=tab[oo].propID; ;
        propVal=formProp[propName];
        if ( (typeof propVal=='string' || typeof propVal=='number') && CheckFunc(searchResult.inputSearch, propVal)) {
          //PSAlert.alert(searchResult.inputSearch + " found");
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
  //Proprietà degli items
  for (var ii = 0; ii < m_array.length; ii++) {
    var itemObj=m_array[ii];
    //for(var o in m_array[ii]){
    for (o in itemObj.objClass.newProperties) {
      tab = itemObj.objClass.newProperties[o];
      for (oo = 0; oo < tab.length; oo++) {
        if(!tab[oo].disabled || tab[oo].disabled!='true'){
          propName=tab[oo].propID; ;
          propVal=itemObj[propName];
          if ( (typeof propVal=='string' || typeof propVal=='number') && CheckFunc(searchResult.inputSearch, propVal)) {
            //PSAlert.alert(searchResult.inputSearch + " found");
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
    var formToggler = document.getElementById("formproperties-toggler");
    if (formToggler && formToggler.hasClass("opened")) {
      formToggler.click();
    }
    resizeGadgetsPane(true);
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
  wrapperTitle =  "Results of '<span style='font-weight: 600;'>"+searchResult.inputSearch+"</span>'";
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
    removeAllHandlers();
    selectItem(obj)
  }else{
    isForm=true;
    FormProperties(false,true)
    var formToggler = document.getElementById("formproperties-toggler");
    if (formToggler && !formToggler.hasClass("opened")) {
      formToggler.click();
    }
  }
  if (propobj && propobj.tab && propobj.prop) {
    document.getElementById((isForm?"Form_":"") + propobj.tab + '_tab').fireEvent('click');
    document.getElementById((isForm?"Form_":"") +propobj.tab + '_' + propobj.prop).focus();
  }
}

function getDataproviders() {
  var dataproviders = [];
  for (var mm = 0; mm < itemsHTML.length; mm++) {
    if (itemsHTML[mm].type == 'MLevelDataProvider' || itemsHTML[mm].type == 'SQLDataobj' || itemsHTML[mm].type == 'XMLDataobj' || itemsHTML[mm].type == 'AdvTreeView' || itemsHTML[mm].derivType == 'SQLDataobj' || itemsHTML[mm].type == 'MenuView' || itemsHTML[mm].type == 'JSONDataobj') {
      dataproviders.push(itemsHTML[mm].name);
    }
  }
  return dataproviders;
}

/**
 *  Return Fields list from dataprovider
 * @param {Object} obj
 * @param {int} obj.index
 * @param {string} obj.refPropId
 * @param {string} obj.refId
 * @param {string} obj.dataobjref - Name of dataprovider to get the fields
 * @returns {Array} - Fields list
 */
function getQueryFieldsFromDataprovider(obj) {
  var dataobjref = itemsHTML[obj.index][obj.dataobjref];
  var dataobj = itemsHTML.filter(function (e) {
    return e.name == dataobjref;
  })[0];
  // [res,types]
  if( dataobj.query != undefined )
  return GetQueryFields( dataobj.query, false )[0] ;
  if( dataobj.queries != undefined ) {
    var l, k;
    var ret = [], sp = dataobj.queries.split(',');
    for( l=0; l<sp.length; l++ ) {
      var ll = GetQueryFields( sp[l], false )[0]
      for( k=0; k<ll.length; k++ ) {
        if( ret.indexOf(ll[k]) < 0 )
          ret.push(ll[k]);
      }
    }
    return ret;
  }
}

function getTextAndVar() {
  var textAndVar = [];
  for (var mm = 0; mm < itemsHTML.length; mm++) {
    if (itemsHTML[mm].type == 'Variable' || itemsHTML[mm].type == 'Textbox') {
      textAndVar.push(itemsHTML[mm].name);
    }
  }
  return textAndVar;
}
