/* exported
    updateProperties SelectContents SelectQuery EditQuery NewQuery ListObj editPagelet openType NewTheme
    SelectTheme SelectLayout EditLanguage EditTemplate SelectJs NewCss EditParameters EditCss editDesc IsObligatory
  */

//Scrive la properties
var formProp=new ZTPlanObjects.formObj()
var pickerObj;
var ps_props;
var newPropObj;
if(Empty(localStorage.getItem('zucchetti_planeditor_properties'))){
  ps_props = {'width':250,'top':45,'left':500,'opened':true,'opacity':1}
  localStorage.setItem('zucchetti_planeditor_properties', JSON.stringify(ps_props));
}else{
  ps_props = JSON.parse(localStorage.getItem('zucchetti_planeditor_properties'))
}
var formPropOpened = false;
function FormProperties(){
  if(!formPropOpened){
    index=null;
    formPropOpened = true;
    var mainobj=formProp;
    ps_currOpener = mainobj.id;
    newPropObj = new propertiesObj({m_obj:mainobj,isForm:true});
  } else {
    formPropOpened = false;
    newPropObj.updatePropertiesFromPaint();
  }
  return;
}
var ps_currOpener = null;
function Properties(force){
  formPropOpened = false;
  if(index!=null){
    var mainitem=itemsHTML[index];
    if(!force && ps_currOpener == mainitem.id){
      if(isCMS) {
        newPropObj.updatePropertiesFromPaint(); // serve solo nel plan del CMS
      }
      return;
    }
    ps_currOpener = mainitem.id;
    newPropObj = new propertiesObj({m_obj:mainitem});
    return;
  }
}
// aggiorna la proprieta modificata dell Item
function updateProperties(e,the_property,propertyType,isForm,value,updateHTML,reconvertFunc,validFunc){
  if(updateHTML==null) updateHTML=true;
  var arrayProp;
  //if (EmptyString(value)) value=" ";
  isForm = (Empty(itemsHTML[index])) ? true : false;
  if(isForm)
    arrayProp=formProp;
  else
    arrayProp=itemsHTML[index];
  if(arrayProp[the_property]==value)return;
  if(reconvertFunc){
    value = window[reconvertFunc](value);
  }
  if(validFunc){
    var r = window[validFunc](value);
    if(r!=true){
      e.focus();
      e.select()
      return;
    }//else

  }
  switch(propertyType){
    case 'int': //solo valori numerici
      value=parseInt(value); //controlla se � un valore numerico valido
      if(isNaN(value)){
        alert('Wrong data input');
      }else{
        arrayProp[the_property]=value;
        //drawLinks(true)
      }
    break;
    case 'checkbox':
      if (typeof(value)=="boolean") value=(value?"true":"false");
    if(value=="undefined") value = "false";
      arrayProp[the_property]=value;
    break
    default:
    //case 'str': case 'data': case 'select': case 'xmldata'://valori stringa
      if(arrayProp.type=='Page' && the_property=='name') {
        arrayProp.neww=true;updateLinksName(arrayProp,value);
      }
      // CUSTOM CMS
	    var svalue;
      if(isCMS && arrayProp.type == 'Page' && the_property == 'alias') {
        if(arrayProp.palias != value){
          svalue = standardize(value);
          updateLinksName(arrayProp,svalue);
          arrayProp.alias = svalue;
          arrayProp.neww=true;
          Properties();
        }
      }
      if(isCMS && arrayProp.type == 'Page' && the_property == 'pname') {
        if(arrayProp.pname != value){
          arrayProp.pname = value;
          arrayProp.name = value;
          svalue = standardize(value);
          updateLinksName(arrayProp,svalue);
          arrayProp.alias = svalue;
          arrayProp.neww=true;
          Properties();
        }
        arrayProp.alias=svalue;
      }
      // END CUSTOM
      arrayProp[the_property]=value;
      m_bUpdated=true;
      // CUSTOM CMS
      if(isCMS && arrayProp.type == 'Page' && the_property == 'page_type'){
        Properties();
      }
    // END CUSTOM
    //drawLinks(true)
  }
  if(updateHTML)
    writeHTML();
  if( newPropObj )
    newPropObj.UpdateListObj("ctrlSelect");
}

function SelectContents(id_container,name){
  // window.open("contents_builder.html?for="+i+"&title="+name, i, "height=270,width=540,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
  window.layerOpenForeground("contents_builder.html?for="+id_container+"&title="+name,"contents_builder",'',700,360,true,1);

}
function SelectQuery(PortletItemIndex){
  var TempArray = new JSURL("../servlet/SPVQRProxy?action=vqr").Response().replace(/\.vqr/gi, '');
  //if(At("ACCESS DENIED",TempArray)>0){
  if(TempArray.match("ACCESS DENIED")){
    window.layerOpenForeground("../servlet/SPVQRProxy?action=vqr","SelectQuery",'',400,600,true,1);
    //window.open("../servlet/SPVQRProxy?action=vqr", "SelectQuery", "height=100,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
  }
  else {
    TempArray = JSON.parse(TempArray,true);
    window.layerOpenForeground("../visualweb/select_fields.html?rtrnobj=query&for=" + PortletItemIndex,"SelectQuery",'',400,600,true,1);
    //window.open("../visualweb/select_fields.html?rtrnobj=query&for=" + PortletItemIndex, "SelectQuery", "height=347,width=350,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
  }
}
function EditQuery(PortletItemIndex) {
  if(LRTrim(itemsHTML[PortletItemIndex].query)=="")
    alert("No query selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj(itemsHTML[PortletItemIndex].query,"visualquery",{});
  else
    window.open("../visualquery/index.jsp?filename="+itemsHTML[PortletItemIndex].query,"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function NewQuery() {
  if(parent.newCurrentObj!=null)
    parent.newCurrentObj('New','visualquery',{});
  else
    window.open("../visualquery/index.jsp","visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function ListObj(obj) {
  if(obj.value!='' && obj.value=='form'){
    FormProperties()
    return
  }
  if(obj.value!=''){
    removeAllHandlers()
    for(var i=0;i<itemsHTML.length;i++)
      if(itemsHTML[i].id=="item"+obj.value){
        var obk=itemsHTML[i];
        break;
      }
    var str=addHandlers(obk.id.substr(4))
    obk.shadow='shadow'+obk.id.substr(4)
    Ctrl("canvashandlers").innerHTML=Ctrl("canvashandlers").innerHTML+str
    selectItem(Ctrl(obk.shadow))
  }
}

function editPagelet(e,url){
  openedPagelet= true;
  e.cancelBubble=true
  if(e.stopPropagation)
    e.stopPropagation();
  if( !url )
    url = itemsHTML[index].template;
  url=url.split(',');
  url=url[0];
  url=Strtran(url,".jsp","")
  var str = "";
  if( url == ""){
     if(!Empty(window.frameElement)){
      str = "?planIframeId="+window.frameElement.id+"&planItemId="+itemsHTML[index].name;
    }
     window.layerOpenForeground("../portalstudio/select_template.jsp"+str,"select_template",'',620,280,true,1);
  }else{
    openedPageletName= url;
    var listSkins = new JSURL("../servlet/JSPReader?type=themes",true).Response().split(",");
    pickerObj = [];
    var type_root = new JSURL('../servlet/JSPReader?action=getType&name='+openedPageletName+'&folder_path=').Response();
    if(type_root != "undefined") {
      pickerObj.push({"path":"jsp","name":openedPageletName});
    }

    for(var j = 0; j < listSkins.length - 1; j++) {
      var type = new JSURL('../servlet/JSPReader?action=getType&name='+openedPageletName+'&folder_path=/../'+listSkins[j]).Response();
      if(type != "undefined") {
        pickerObj.push({"path":listSkins[j],"name":openedPageletName});
      }
    }
    if(pickerObj.length == 0) {
      pickerObj.push({"path":"","name":openedPageletName});
    }
    window.layerOpenForeground("../planeditor/pageletPicker.jsp?returnValue=true","SelectPageletFile",'',350,500,true,1);
  }
}

function openType(url, path) {
  var str = "", painter = "";
  var type = new JSURL('../servlet/JSPReader?action=getType&name='+url+'&folder_path='+path,true,function(response) {
    type = response.Response().toLowerCase();
    // window.opener.newCurrentObj(name,toolsPaths[type]['openurl'](name,path_tmp),path_tmp);
    var parms={}
    path = Strtran(path,"/../","");
    if(path != "jsp") {
      parms.folder_path = path;
    }
    if(type == 'pagelet'){
      painter = "../pagelet/editor.jsp";
      var template_type_url = new JSURL("../servlet/JSPReader?type=template_type&name="+url);
      var template_type=template_type_url.Response()
      parms.template=template_type;
      template_type="&template="+template_type
      str = painter+"?name="+url+template_type
    }else if(type == 'pageleteditor'){
      var planIframeId= planIframeId="";
      if(!Empty(window.frameElement)){
        planIframeId = "&planIframeId="+window.frameElement.id;
        var planItemId = "&planItemId="+itemsHTML[index].name;
        parms.planIframeId=window.frameElement.id;
        parms.planItemId=itemsHTML[index].name;
      }
      painter = "../pageleteditor/pagelet_editor.jsp";
      str = painter +"?name="+url+planIframeId+planItemId;
      /* ridefiniscto la closeCurrentObj per controllare l'effetiva chiusura delle pagelet collegata prima della chiusura del plan */
      if( parent.closeCurrentObj ){
        var oldF = parent.closeCurrentObj;
        parent.closeCurrentObj = function(currentname){
          if(this.opensApl[this.currentIndex]!=null){
            var type = this.opensApl[this.currentIndex].type;
            /* Sto' cercando di chiudere il plan con una pagelet linkata*/
            if( type == 'plan' && this.opensApl[this.currentIndex].name == currentname) {
              if( openedPagelet ){
                if(confirm("Pagelet linked already opened. \nAre you sure to close " + this.opensApl[this.currentIndex].name + " and lose the link?\n\nClick OK to close\nClick Cancel to ignore")){
                  oldF();
                } else {

                }
              }
            } else
            /* sto' cercando di chiudere la pagelet linkata con il plan */
            if( type == 'pageleteditor' && this.opensApl[this.currentIndex].name == openedPageletName) {
              openedPagelet= true;
            }
          }else {
            oldF();
          }
          this.closeCurrentObj = oldF;
        }.bind(parent,currentname);
      }

    }
    if(parent.newCurrentObj)
      // parent.newCurrentObj(url,str);
      parent.newCurrentObj(url,type,parms);
    else
      windowOpenForeground(str,'','status=1,directories=0,width=800px,height=600px,top=0,left=0,resizable=1,scrollbars=1');
  })
}

function NewTheme(/*retTo*/) {
  var str =""
  if(!Empty(window.frameElement)){
    str = "?planIframeId="+window.frameElement.id+"&planItemId="+itemsHTML[index].name
  }
  window.layerOpenForeground("../portalstudio/select_template.jsp"+str,"select_template",'',620,280,true,1);
}

function SelectTheme(retTo/*,isFormProp*/) {
  pickerObj = [];
  pickerObj[0] = new Array();
  pickerObj[0].title = "Theme list available";
  var url;
  if(!isCMS) {
    url = new JSURL("../servlet/JSPReader?type=pagelet");
  } else {
    url = new JSURL("../servlet/JSPReader?type=template_folder");
  }
  var tmp_list = url.Response();
  pickerObj[0].list = tmp_list.split(',');
  window.layerOpenForeground("../portalstudio/picker.jsp?for="+retTo,"SelectThemesFile",'',350,500,true,1);
}

// CUSTOM CMS
function SelectLayout(retTo){
  pickerObj = [];
  pickerObj[0] = new Array();
  pickerObj[0].title = "Theme list available";
  var url = new JSURL("../servlet/JSPReader?type=layout&folder_path="+formProp.template_folder);
  var tmp_list = url.Response();
  pickerObj[0].list = tmp_list.split(',');
  window.layerOpenForeground("../portalstudio/picker.jsp?type=layout&for="+retTo,"Templates",'',350,500,true,1);
}

function EditLanguage(PortletItemIndex,field){
  window.layerOpenForeground("multilang_edit.jsp?index="+PortletItemIndex+"&field="+field,"translate",'',350,500,true,1);
}

function EditTemplate(/*e*/){
  var url = "";
  var layout = itemsHTML[index].layout;

  //CUSTOM CMS
  if(isCMS) {

    // risorse pagina modello
    var contents_model="";
    var urls_model="";
    var groups_model="";
    var contents_type_model="";
    for(var i=0;i<itemsHTML.length;i++){
        if(itemsHTML[i].alias==itemsHTML[index].modelselected){
    contents_model=itemsHTML[i].contents;
    groups_model=itemsHTML[i].groups;
    contents_type_model=itemsHTML[i].contents_type;
    var app_urls = itemsHTML[i].urls.split(",");
    for(var j=0;j<app_urls.length;j++)
      urls_model += app_urls[j] +'&model_resource=true,'
    urls_model=urls_model.substring(0,urls_model.length-1);
    break;
        }
      }

    layout = '../templates/'+formProp.template_folder+'/'+layout;
  }
  var type = new JSURL("../servlet/JSPReader?action=getType&name="+layout).Response();

  if(type == "PageletEditor") {
    url = '../pageleteditor/pagelet_editor.jsp?name=/'+layout;
  } else {
    //aggiungo anche risorse pagina modello
    url = '../templateeditor/index.jsp?editMode=true&tpl='+layout+'.jsp&pageid='+itemsHTML[index].id+"&contents="+itemsHTML[index].contents+","+contents_model+"&urls="+URLenc(itemsHTML[index].urls+","+urls_model)+"&groups="+itemsHTML[index].groups+","+groups_model+"&contents_type="+itemsHTML[index].contents_type+","+contents_type_model;
  }

  var mar_left = 25, width = window.outerWidth - mar_left*2;
  var mar_top = 15, height = window.outerHeight - mar_top*2;
  window.layerOpenForeground(url,"editTemplate",'',width,height,true,1);
}

function SelectJs(retTo) {
  pickerObj = [];
  pickerObj[0] = new Array();
  pickerObj[0].title = "JS list available";
  var url = new JSURL("../servlet/JSPReader?type=js&folder_path="+formProp.template_folder,true);
  var tmp_list = url.Response();
  pickerObj[0].list = tmp_list.split(',');
  window.layerOpenForeground("../portalstudio/picker.jsp?for="+retTo+"&mode=multiple","SelectJSFile",'',350,500,true,1);
}

// END CUSTOM

function NewCss(/*index*/) {
  if(parent.newCurrentObj!=null)
    parent.newCurrentObj('New','css',{});
}
function EditParameters(idx){
  window.layerOpenForeground("../parameter_edit.html?idx="+idx,"parameters",'',400,600,true,1);
  //window.open("../parameter_edit.html?idx="+idx, "parameters", "height=200,width=400,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
}
function EditCss(){
  var css_list= itemsHTML[index].css.split(',')
  for(var i=0;i<css_list.length;i++)
  parent.newCurrentObj(Strtran(css_list[i],".css",""),"css",{});
}
function editDesc(id,isFormProp){
  window.layerOpenForeground("../portalstudio/insert_desc.html?isFormProp="+isFormProp+"&id="+id,"description",'',500,300,true,1);
  //window.open("../portalstudio/insert_desc.html?isFormProp="+isFormProp+"&id="+id, "description", "height=250,width=400,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
}
function IsObligatory(v){
if(Empty(v)){
  PSAlert.alert('Obligatory input value!')
  return false;
}else
  return true;
}
function standardize(pname) {
	var str = Trim(pname);
	str = str.toLowerCase();
	str = str.replace(/[^a-zA-Z0-9 _-]/gi, "");
	str = str.replace(/ +/gi, "-");
    while (str.substring(0,1) == '-')
    str = str.substring(1,str.length);
    while (str.substring(str.length-1, str.length) == '-')
    str = str.substring(0,str.length-1);
  var n = 0;
  var f = false;
  var c = false;
  for(var i in itemsHTML){
    if(i!=index){
      var item = itemsHTML[i];
      if(pname == item.pname){
        f = true;
        var tmp = item.alias.substring(item.alias.length-1,item.alias.length);
        if(!isNaN(tmp) && tmp > n) n = tmp;
      }
      if(str == item.alias)
        c = true;
    }
  }
  if(isNaN(n)) n = 1;
    else n = parseInt(n) + 1;
  if(n>0 && f && c)
    str = str + n;
  return str;
}
