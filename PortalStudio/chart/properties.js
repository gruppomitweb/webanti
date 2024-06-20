/* exported
		ps_currTab ps_TabAnimation pickerObj contentInfo titleInfo
    Properties updateProperties hideProperties
  */

// ripresa da visualweb/properties
var formProp=new ZTObjects.formObj('300','400','#F3F3F3')
var v_line=" ";
var ps_currTab = null;
var ps_TabAnimation = false;
var ps_props;
var last_index=null;
var pickerObj, contentInfo, titleInfo;
if(Empty(localStorage.getItem('zucchetti_charteditor_properties'))){
	ps_props = {'width':250,'top':45,'left':500,'opened':true,'opacity':1,'expandedToColumn':true,'columnSide':'right','form_closed':false}
	localStorage.setItem('zucchetti_charteditor_properties', JSON.stringify(ps_props));
}else{
	ps_props = JSON.parse(localStorage.getItem('zucchetti_charteditor_properties'));
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
  switch(the_property){
    case "x": case "y": case "h":  case "w": case "name":
      if(EmptyString(value)) {
        PSAlert.alert("Obligatory data input");
        setTimeout("document.getElementById('"+input.id+"').focus();",50);
        setTimeout("document.getElementById('"+input.id+"').select();",50);
        return;
      }
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

function hideProperties(id) {
  var ctrl=Ctrl(id)
  var ww;if(v_line!=" ") ww=parseInt(v_line);else ww=formProp.w;
  if(ctrl.offsetLeft>0 && ctrl.offsetLeft<(parseInt(ww)+document.getElementById('backcanvas').getPosition().x) && ctrl.offsetTop<(parseInt(formProp.h)+document.getElementById('backcanvas').getPosition().y))
    ctrl.style.display='none';
  hidePreSet();

}
function showProperties(id) {
  if(index!=null){
    var ctrl=Ctrl(id)
    var ww;if(v_line!=" ") ww=parseInt(v_line);else ww=formProp.w;
    if(ctrl.offsetLeft==0 || (ctrl.offsetLeft<(parseInt(ww)+document.getElementById('backcanvas').getPosition().x) && ctrl.offsetTop<parseInt(formProp.h)+document.getElementById('backcanvas').getPosition().y))
    ctrl.style.display='block'
  }
}
