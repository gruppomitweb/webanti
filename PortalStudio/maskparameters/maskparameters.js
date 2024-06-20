/* exported
    folder_path windowOpen tool previewOpen doLoad openPreviewConfig Copy Paste
    updateField deleteNode checkField getField maskPreview setToolbars setLights
    selectItem editQuery newQuery editZoom newZoom reset select_font select_icon
    loadFieldName openMask loadValue save saveAs writeHTML Help old_name ListObj

*/
var CSV_SEP="#!$";
var currentname=""; //nome della configurazione corrente
var folder_path=''
var newPropObj = null;
var nField=0,nGroup=0,nCalculation=0,nLabel=0,nButton=0,nAction=0;
var windowOpen=null;
var currentVersion;
var forceSaveVdm=false;//per forzare il salvataggio (non viene controllato il num di versione in caso di sovrascrittura)
var tool='maskparameters';
var zoomMode=false;
var listFieldName={},listActionName={},listCalcName={},listButtonName={};
var queryName="";
var field_tree;
var emptyGroup=false;
var variant='', maskName;
var focusProperty=true,previewOpen=false;
var toolbars={}
function doLoad(e, filename, _zoomMode, _queryName, custom){
  var form = {};
  zoomMode=_zoomMode||false;
  queryName=_queryName;
  initTree()
  // dividere tra nome, utente/gruppo, codice variante
  var _opener=GetOpener()||window.parent.GetOpener();
  var create=false;
	if(!Empty(filename)){
		currentname=filename;
		if(Ctrl("srcform")) Ctrl("srcform").value=currentname
		if(standalone) document.title=currentname+" - Mask Parameters";
    old_name=currentname;
    form=loadVDM(currentname,custom);
    form=updateUserGroup(form)
    form.configName=currentname;
    if (form!=null && form.fields){
      if (_opener && _opener.getConfigObj){
        form=mergeObject(_opener.getConfigObj(),form)
      }
      FillTree(form);
      create=true;
    }
  }
  if (!create){
    if (_opener && _opener.getConfigObj){
      form=_opener.getConfigObj();
      currentname=form.configName;
      form=updateUserGroup(form)
      FillTree(form)
      if (formProp.customVdm==null)
        formProp.customVdm=false;
    }
    else{
      if (form.error)
        PSAlert.alert(form.error)
      currentname = '';
      form=getDefaultForm();
      formProp = new ZTObjects.formObj(form);
      field_tree.load({
        json: createTree("List fields",[])
      });
    }
  }
  document.id('backcanvas').setStyle('display','block');
  FormProperties();
  document.id('loading').setStyle('display','none');
  create_gadget_pane();
  windowResize();
  window.addEvent("keydown", function(e) {
    if (e.control && e.key=="s") { //CTRL-S
      e.stop();
      if (parent.saveTool) parent.saveTool();
    }
  });
  currentVersion=form.fileVersion||0;
  m_bUpdated=false;
  toolbars.action = new SPToolbar(ZTObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  });
  toolbars.preview = new SPToolbar(ZTObjects.PSToolbarPreview, 'sptoolbar_preview', {
    elementToShow: 'all'
  });
  if ( 'setTitle' in parent){
    parent.setTitle(this);
    toolbars.action.removeElement("new");
    toolbars.action.removeElement("save");
    toolbars.action.removeElement("saveas");
    toolbars.action.removeElement("separator");
  }
  document.id('configPreviewButton').addEvent('click',function(){
    document.id('previewConfigDiv').style.display='none'
  })
}

function openPreviewConfig(/*event*/){
  document.id('previewConfigDiv').style.display='block'
}

function updateUserGroup(_obj){
  var obj=_obj||{}
  currentname=currentname.split('__');
  if (currentname.length>1)
    variant=currentname[1]; // variante + utente/gruppo
  maskName=currentname[0];
  currentname=currentname[currentname.length-1].split('_');
  //controllare se ho un user o group
  var user_group='',u_g='';
  if (currentname.length>1 && !Empty(currentname[0])){
    user_group=currentname[currentname.length-1]
    if (user_group.charAt(0)=='g' && parseInt(user_group.substring(1,user_group.length),10)==user_group.substring(1,user_group.length)){
      u_g='group'
      variant=variant.substring(0,variant.length-(user_group.length+1))
      if (Empty(variant))
        maskName=maskName.substring(0,maskName.length-(user_group.length+1))
    }
    else if (parseInt(user_group,10)==user_group){
      u_g='user'
      variant=variant.substring(0,variant.length-(user_group.length+1))
      if (Empty(variant))
        maskName=maskName.substring(0,maskName.length-(user_group.length+1))
    }
    else user_group='';
  }
  obj.user_group=u_g;
  if (!Empty(u_g))
    obj[u_g]=u_g=='user'?user_group:user_group.substring(1,user_group.length);
  currentname=maskName+(!Empty(variant)?'__'+variant:'')+(!Empty(u_g)?'_'+user_group:'')
  return obj;
}

function initTree(){
  Mif.Tree.UID=1;
  field_tree = new Mif.Tree({
    container: document.id('fieldListContainer'),// tree container
    initialize: function(){
      new Mif.Tree.Drag(this, {
				onDrag: function(){
          if ((this.target && this.target.type[0] != 'group') && this.where == 'inside'){
						this.where = 'notAllowed';
					}
          else if (this.current && this.current.type[0]=='group' && (this.where=='inside' || (this.target && this.target.parentNode && this.target.parentNode.type[0]=='group')))
            this.where = 'notAllowed';
				},
				onStart: function(){
				},
				onComplete: function(){
				},
        onDrop: function(current/*, target, where*/){
          current.tree.select(current);
          if (current.parentNode.type[0]=='group'){
            itemsHTML[index].group=current.parentNode.name;
          }
          else{
            itemsHTML[index].group='';
          }
          updateIcon();
          m_bUpdated = true;
        }
			});
    },
    types: {// node types
      field: {
        openIcon: 'isFilter',//css class open icon
        closeIcon: 'isFilter'// css class close icon
      },
      group : {
        openIcon: 'group',//css class open icon
        closeIcon: 'group'// css class close icon
      },
      fieldList:{
        openIcon: 'root',//css class open icon
        closeIcon: 'root'// css class close icon
      }
    },
    dfltType: 'field',//default node type
    height: 20, //node height
    onSelect: function(node){
      if (node.type[0]=='fieldList')
        selectElement();
      else {
        if (focusProperty)
          Ctrl('Form_generic_titleMsg').focus();
        selectElement();
        if (focusProperty){
          if (node.type[0]=='group'){
            switch (itemsHTML[index].curTab){
              case 'generic':
                Ctrl('generic_groupName').focus();
              break;
              case 'view':
                Ctrl('view_mode').focus();
              break;
            }
          }
          else if (node.type[0]=='field'){
            switch (itemsHTML[index].curTab){
              case 'generic':
                Ctrl('generic_fieldName').focus();
              break;
              case 'functional':
                Ctrl('functional_objType').focus();
              break;
              case 'view':
                Ctrl('view_visibility').focus();
              break;
              case 'advanced':
                Ctrl('advanced_viewType').focus();
              break;
              case 'expression':
                Ctrl('expression_editUnderCondition').focus();
              break;
            }
          }
           else if (node.type[0]=='label'){
            switch (itemsHTML[index].curTab){
              case 'generic':
                Ctrl('generic_fieldName').focus();
              break;
              case 'view':
                Ctrl('view_hiddenGroup').focus();
              break;
              case 'expression':
                Ctrl('expression_hideUnderCondition').focus();
              break;
            }
          }
           else if (node.type[0]=='button'){
            switch (itemsHTML[index].curTab){
              case 'generic':
                Ctrl('generic_fieldName').focus();
              break;
              case 'functional':
                Ctrl('functional_entityType').focus();
              break;
              case 'view':
                Ctrl('view_hiddenGroup').focus();
              break;
              case 'style':
                Ctrl('style_styleButton').focus();
              break;
              case 'expression':
                Ctrl('expression_editUnderCondition').focus();
              break;
            }
          }
        }
      }
    },
    onAdd : function(node/*,current,where*/){node.tree.select(node);},
    propertiesEditable :true,
    deletable : true,
    onBeforeDelete : function(node){
      if (node.type[0]=='group')
        node.deleteCondition = confirm("Are you sure to delete "+node.name+" and all fields within?")
    },
    onDelete: function(node){
      index = null;
      last_index=null;
      removeElement(node)
      var pNode=node.parentNode
      if (pNode.type[0]=='group')
        changeIconGroup(pNode)
      if (node.type[0]=='group'){
        for (var j=0; j<node.children.length; j++)
          removeElement(node.children[j],true)
      }
      updateIcon();
    },
    onToggle: function(){
      updateIcon();
      resizeGadgetsPane();
    }
  });
}

function FillTree(form){
  var i, field;
  var obj=[];
  formProp = new ZTObjects.formObj(form)
  if (!form.groups || form.groups.length==0){ // nessun gruppo o maschere vecchie
    var groups={};
    for (i=0; i<form.fields.length; i++){
      field=form.fields[i];
      if (Empty(field.group)){
        if (form.maskVersion<4)
          field.cover=((field.viewType=='' || field.viewType=='link' || field.viewType=='linkedUsing') && field.type!='L')?0:1;
        if (field.itemType=='field' || Empty(field.itemType)){
          addField(field,false);
          obj.push({property:{name:field.realFieldName||field.fieldName}, type:'field', data:{index:itemsHTML.length-1,viewType:field.viewType}});
        }
        else if (field.itemType=='label'){
          addLabel(field,false);
          obj.push({property:{name:field.fieldName}, type:'label', data:{index:itemsHTML.length-1,viewType:field.viewType}});
        }
        else if (field.itemType=='button'){
          addButton(field,false);
          obj.push({property:{name:field.fieldName}, type:'button', data:{index:itemsHTML.length-1,viewType:field.viewType}});
        }
      }
      else{
        if (!groups[field.group]){
          groups[field.group]=[];
        }
        groups[field.group].push(field)
      }
    }
    for (var el in groups){
      var group={
        groupName:el,
        mode:form.mode,
        columns:form.columns,
        minLabelWidth:form.minLabelWidth,
        maxLabelWidth:form.maxLabelWidth,
        maxFieldWidth:form.maxFieldWidth,
        uid:LibJavascript.AlfaKeyGen(10)
      }
      addGroup(group,false);
      var idxGroup=itemsHTML.length-1;
      // itemsHTML[idxGroup].groupName=el;
      obj.push({property:{name:el,type:['group']},data:{index:idxGroup},children:[]});
      for (i=0; i<groups[el].length; i++){
        if (form.maskVersion<4)
          groups[el][i].cover=((groups[el][i].viewType=='' || groups[el][i].viewType=='link' || groups[el][i].viewType=='linkedUsing') && groups[el][i].type!='L')?0:1;
        groups[el][i].group=group.uid;
        if (field.itemType=='field' || Empty(field.itemType)){
          addField(groups[el][i],false);
          obj[obj.length-1].children.push({property:{name:groups[el][i].realFieldName||groups[el][i].fieldName}, type:['field'], data:{index:itemsHTML.length-1,viewType:groups[el][i].viewType}})
        }
        else if (field.itemType=='label'){
          addLabel(groups[el][i],false);
          obj[obj.length-1].children.push({property:{name:groups[el][i].realFieldName||groups[el][i].fieldName}, type:['label'], data:{index:itemsHTML.length-1,viewType:groups[el][i].viewType}})
        }
        else if (field.itemType=='button'){
          addButton(groups[el][i],false);
          obj[obj.length-1].children.push({property:{name:groups[el][i].realFieldName||groups[el][i].fieldName}, type:['button'], data:{index:itemsHTML.length-1,viewType:groups[el][i].viewType}})
        }

        if (groups[el][i].collapsedGroup)
          itemsHTML[idxGroup].collapsedGroup=true;
      }
    }
  }
  else {
    var insertGroup={};
    idxGroup=0;
    var listGroup={};
    for (i=0; i<form.fields.length; i++){
      field=form.fields[i];
      if (Empty(form.fields[i].group)){
        if (form.maskVersion<4)
          form.fields[i].cover=((form.fields[i].viewType=='' || form.fields[i].viewType=='link' || form.fields[i].viewType=='linkedUsing') && form.fields[i].type!='L')?0:1;
        if (field.itemType=='field' || Empty(field.itemType)){
          addField(form.fields[i],false);
          obj.push({property:{name:form.fields[i].realFieldName||form.fields[i].fieldName}, type:['field'], data:{index:itemsHTML.length-1,viewType:form.fields[i].viewType}});
        }
        else if (field.itemType=='label'){
          addLabel(form.fields[i],false);
          obj.push({property:{name:form.fields[i].realFieldName||form.fields[i].fieldName}, type:['label'], data:{index:itemsHTML.length-1,viewType:form.fields[i].viewType}});
        }
        else if (field.itemType=='button'){
          addButton(form.fields[i],false);
          obj.push({property:{name:form.fields[i].realFieldName||form.fields[i].fieldName}, type:['button'], data:{index:itemsHTML.length-1,viewType:form.fields[i].viewType}});
        }

      }
      else{
        if (!insertGroup[form.fields[i].group]){
          insertGroup[form.fields[i].group]=true;
          if (!form.groups[idxGroup].uid)
            form.groups[idxGroup].uid=LibJavascript.AlfaKeyGen(10);
          addGroup(form.groups[idxGroup],false);
          obj.push({property:{name:form.groups[idxGroup].groupName}, type:['group'], data:{index:itemsHTML.length-1},children:[]});
          listGroup[form.groups[idxGroup].uid]=obj[obj.length-1];
          idxGroup++;
        }
        if (form.maskVersion<4)
          form.fields[i].cover=((form.fields[i].viewType=='' || form.fields[i].viewType=='link' || form.fields[i].viewType=='linkedUsing') && form.fields[i].type!='L')?0:1;
        form.fields[i].group=form.groups[idxGroup-1].uid;
        if (field.itemType=='field' || Empty(field.itemType)){
          addField(form.fields[i],false);
          listGroup[form.fields[i].group].children.push({property:{name:form.fields[i].realFieldName||form.fields[i].fieldName}, type:['field'], data:{index:itemsHTML.length-1,viewType:form.fields[i].viewType}})
        }
        else if (field.itemType=='label'){
          addLabel(form.fields[i],false);
          listGroup[form.fields[i].group].children.push({property:{name:form.fields[i].realFieldName||form.fields[i].fieldName}, type:['label'], data:{index:itemsHTML.length-1,viewType:form.fields[i].viewType}})
        }
        else if (field.itemType=='button'){
          addButton(form.fields[i],false);
          listGroup[form.fields[i].group].children.push({property:{name:form.fields[i].realFieldName||form.fields[i].fieldName}, type:['button'], data:{index:itemsHTML.length-1,viewType:form.fields[i].viewType}})
        }
      }
    }
  }
  for (i=0; i<form.calculation.length; i++){
    addCalculation(form.calculation[i],false);
  }
  for (i=0; i<form.action.length; i++){
    addAction(form.action[i],false);
  }
  if (form.maskVersion<6){
    form.discardTarget=form.target;
    formProp.discardTarget=form.target;
  }
  field_tree.load({
    json: createTree("List fields",obj)
  });
  field_tree.root.toggle('open')
  refreshMask();
}

function createTree(root_name,children){
  var json = [{
    "property": {
        "name": root_name,
        "deleteDenied": true
    },
    "children": children,
    "type": "fieldList",
    "data": {
      "level": 1,
      "itemType": "fieldList"
    }
  }]
  return json;
}

function loadVDM(filename,_custom){
  var custom=_custom;
  if (Empty(custom)){
    if (new JSURL("../servlet/SPVDMProxy?m_cAction=exist&m_cConfigName="+filename+"&custom=true", true).Response()==1)
      custom='true'
    else
      custom='false'
  }
  var projectUrl = new JSURL("../servlet/SPVDMProxy?m_cAction=load&m_cConfigName="+filename+"&custom="+custom, true);
  var myResponse = projectUrl.Response();
  var obj = JSON.parse(myResponse);
  obj.customVdm=custom.toString();
  return obj;
}

function getDefaultField(){
  var obj={}
  for (var i=0; i<fieldProperties.length; i++)
    obj[fieldProperties[i]]=""
  obj.type='C';
  obj.len=10;
  // obj.hiddenGroup=false;
  // obj.hiddenInVariant=false;
  // obj.extMask=false;
  obj.visibility='base'
  obj.collapsedGroup=false;
  obj.obligatory=false;
  obj.changeOperation=false;
  obj.initialOperation='=';
  obj.isFilter=true;
  obj.queryFilter=true;
  obj.keepOnPreviousRow=false;
  obj.openZoom=false;
  obj.hideEmptyValue=false;
  obj.calculateLabel=false;
  obj.calculateInitialValue=false;
  obj.zeroFilling=false;
  obj.nCriteria=1;
  obj.labelEmptyValue='-';
  obj.styleButton='zoom';
  obj.entityType='link';
  obj.looselyLinked=false;
  obj.fillEmptyKeys=false;
  obj.suggest=false;
  obj.row_suggest=10;
  obj.sendAllParams=true;
  obj.popup=false;
  obj.popupScroll=false;
  obj.calculateTooltip=false;
  obj.hiddenLabel=false;
  return obj;
}

function getDefaultForm(){
  var obj={}
  for (var i=0; i<formProperties.length; i++){
    obj[formProperties[i]]="";
  }
  obj.mode=1;
  obj.columns=1;
  obj.customVdm=false;
  return obj;
}

function getDefaultGroup(){
  var obj={};
  for (var i=0; i<groupProperties.length; i++){
    obj[groupProperties[i]]="";
  }
  obj.mode=1;
  obj.columns=1;
  obj.collapsedGroup=false;
  obj.calculateLabel=false;
  obj.visibility='base';
  return obj;
}

function getDefaulCalculation(){
  var obj={};
  for (var i=0; i<calculationProperties.length; i++){
    obj[calculationProperties[i]]="";
  }
  return obj;
}

function getDefaultAction(){
  var obj={};
  for (var i=0; i<actionProperties.length; i++){
    obj[actionProperties[i]]="";
  }
  obj.progressBar=false;
  obj.popup=false;
  obj.sendAllParams=true;
  obj.popupScroll=false;
  return obj;
}

function getDefaultLabel(){
  var obj={};
  for (var i=0; i<labelProperties.length; i++){
    obj[labelProperties[i]]="";
  }
  obj.visibility='base'
  obj.itemType="label";
  obj.calculateLabel=false;
  obj.hiddenGroup=false;
  obj.hiddenInVariant=false;
  obj.keepOnPreviousRow=false;
  obj.extMask=false;
  return obj;
}
function getDefaultButton(){
  var obj={};
  for (var i=0; i<buttonProperties.length; i++){
    obj[buttonProperties[i]]="";
  }
  obj.visibility='base'
  obj.itemType="button";
  obj.hiddenGroup=false;
  obj.hiddenInVariant=false;
  obj.keepOnPreviousRow=false;
  obj.extMask=false;
  obj.styleButton='zoom';
  obj.entityType='link'
  obj.sendAllParams=true;
  obj.popup=false;
  obj.popupScroll=false;
  return obj;
}

function Copy(cut){
  if (index!=null){
    var obj;
    if (itemsHTML[index].type=='group')
      obj=copyGroup(itemsHTML[index]);
    else if (itemsHTML[index].type=='calculation')
      obj=copyCalculation(itemsHTML[index]);
    else if (itemsHTML[index].type=='label')
      obj=copyLabel(itemsHTML[index]);
    else if (itemsHTML[index].type=='button')
      obj=copyButton(itemsHTML[index]);
    else if (itemsHTML[index].type=='action')
      obj=copyAction(itemsHTML[index]);
    else
      obj=copyField(itemsHTML[index]);
    if (cut)
      field_tree.getSelected()._delete();
    return obj;
  }
}

function Paste(obj){
  if (obj){
    if(obj.type=='group' || obj.groupName){
      obj.groupName=obj.groupName+'_Copy';
      addGroup(obj,true)
    }
    else if(obj.type=='calculation' || obj.calculationName){
      obj.calculationName=obj.calculationName+'_Copy';
      addCalculation(obj,true)
    }
    else if(obj.itemType=='label'){
      obj.fieldName=obj.fieldName+'_Copy';
      addLabel(obj,true)
    }
    else if(obj.itemType=='button'){
      obj.fieldName=obj.fieldName+'_Copy';
      addButton(obj,true)
    }
    else if(obj.type=='action' || obj.actionName){
      obj.actionName=obj.actionName+'_Copy';
      addAction(obj,true)
    }
    else{
      obj.fieldName=obj.fieldName+'_Copy';
      obj.realFieldName=obj.fieldName;
      addField(obj,true)
    }
  }
}

function addField(field,updateTree){
  var realFieldName='';
  if (!field){
    field=getDefaultField();
    while (listFieldName['field_name'+nField]){
      nField++;
    }
    realFieldName='field_name'+nField;
    field.fieldName=realFieldName;
  }
  else {
    realFieldName=field.realFieldName;
    if (Empty(realFieldName)){
      realFieldName=field.fieldName;
    }
    var idx=-1;
    while (listFieldName[realFieldName]){
      idx++;
      realFieldName=field.fieldName+'_'+idx;
    }
    field.realFieldName=realFieldName;
    if (field.obligatory && field.obligatoryCondition=='')
      field.obligatoryCondition='true'
    if (field.hiddenInVariant)
      field.visibility='hiddenInVariant'
    else if (field.hiddenGroup)
      field.visibility='hiddenGroup'
    else if (field.extMask)
      field.visibility='extMask'
    else
      field.visibility='base'
  }
  if (Empty(field.uid))
    field.uid=LibJavascript.AlfaKeyGen(10);
  field.index=itemsHTML.length;
  listFieldName[realFieldName]=true;

  if (updateTree){
    var current = field_tree.getSelected();
    if (current && current.type[0]=='group'){
      field.group=itemsHTML[current.data.index].uid;
      changeIconGroup(current)
    }
    else if (current && current.parentNode && current.parentNode.type[0]=='group'){
      current=current.parentNode;
      field.group=itemsHTML[current.data.index].uid;
      changeIconGroup(current)
    }
    else {
      current=field_tree.root;
      field.group='';
    }
    var fieldObj=new ZTObjects.fieldObj(field)
    itemsHTML.push(fieldObj);
    var position = "inside";
    var newNode = new Mif.Tree.Node({
          parentNode: null,
          tree: field_tree
        }, {
        property: {
          name: realFieldName
        },
        type: 'field' ,
        data : {index:field.index,viewType:field.viewType}
    });
    field_tree.add(newNode, current,position);
    updateIcon();
    resizeGadgetsPane();
  }
  else {
    itemsHTML.push(new ZTObjects.fieldObj(field));

  }
  nField++;
  m_bUpdated=true;
}

function addGroup(group,updateTree){
  if (!group){
    group=getDefaultGroup();
    group.groupName='group'+nGroup;
  }
  if (Empty(group.uid))
    group.uid=LibJavascript.AlfaKeyGen(10);
  group.index=itemsHTML.length;
  itemsHTML.push(new ZTObjects.groupObj(group));
  if (updateTree){
    var current = field_tree.root;
    var position = "inside";
    var newNode = new Mif.Tree.Node({
          parentNode: null,
          tree: field_tree
        }, {
        property: {
          name: group.groupName
        },
        type: 'group' ,
        data : {index:group.index}
    });
    field_tree.add(newNode, current,position);
    resizeGadgetsPane();
    updateIcon()
  }
  nGroup++;
  m_bUpdated=true;
}

function addLabel(label,updateTree){
  if (!label){
    label=getDefaultLabel();
    label.fieldName='label'+nLabel;
  }
  else {
    if (label.hiddenInVariant)
      label.visibility='hiddenInVariant'
    else if (label.hiddenGroup)
      label.visibility='hiddenGroup'
    else if (label.extMask)
      label.visibility='extMask'
    else
      label.visibility='base'
  }
  if (Empty(label.uid))
    label.uid=LibJavascript.AlfaKeyGen(10)
  label.index=itemsHTML.length;

  if (updateTree){
    var current = field_tree.getSelected();
    if (current && current.type[0]=='group'){
      label.group=itemsHTML[current.data.index].uid;
      changeIconGroup(current)
    }
    else if (current && current.parentNode && current.parentNode.type[0]=='group'){
      current=current.parentNode;
      label.group=itemsHTML[current.data.index].uid;
      changeIconGroup(current)
    }
    else {
      current=field_tree.root;
      label.group='';
    }
    itemsHTML.push(new ZTObjects.labelObj(label));
    var position = "inside";
    var newNode = new Mif.Tree.Node({
          parentNode: null,
          tree: field_tree
        }, {
        property: {
          name: label.fieldName
        },
        type: 'label' ,
        data : {index:label.index}
    });
    field_tree.add(newNode, current,position);
    updateIcon();
    resizeGadgetsPane();
  }
  else
    itemsHTML.push(new ZTObjects.labelObj(label))
  nLabel++;
  m_bUpdated=true;
}

function addButton(button,updateTree){
  if (!button){
    button=getDefaultButton();
     while (listButtonName['button'+nButton]){
      nButton++;
    }
    button.fieldName='button'+nButton;
  }
  else {
    if (button.hiddenInVariant)
      button.visibility='hiddenInVariant'
    else if (button.hiddenGroup)
      button.visibility='hiddenGroup'
    else if (button.extMask)
      button.visibility='extMask'
    else
      button.visibility='base'
  }
  if (Empty(button.uid))
    button.uid=LibJavascript.AlfaKeyGen(10)
  button.index=itemsHTML.length;

  if (updateTree){
    var current = field_tree.getSelected();
    if (current && current.type[0]=='group'){
      button.group=itemsHTML[current.data.index].uid;
      changeIconGroup(current)
    }
    else if (current && current.parentNode && current.parentNode.type[0]=='group'){
      current=current.parentNode;
      button.group=itemsHTML[current.data.index].uid;
      changeIconGroup(current)
    }
    else {
      current=field_tree.root;
      button.group='';
    }
    itemsHTML.push(new ZTObjects.buttonObj(button));
    var position = "inside";
    var newNode = new Mif.Tree.Node({
          parentNode: null,
          tree: field_tree
        }, {
        property: {
          name: button.fieldName
        },
        type: 'button' ,
        data : {index:button.index}
    });
    field_tree.add(newNode, current,position);
    updateIcon();
    resizeGadgetsPane();
  }
  else
    itemsHTML.push(new ZTObjects.buttonObj(button))
  listButtonName['button'+nButton]=true;
  nButton++;
  m_bUpdated=true;
}

function addCalculation(calculation,update){
   if (!calculation){
    calculation=getDefaulCalculation();
    while (listCalcName['calculation'+nCalculation]){
      nCalculation++;
    }
    calculation.calculationName='calculation'+nCalculation;
  }
  if (Empty(calculation.uid))
    calculation.uid=LibJavascript.AlfaKeyGen(10);
  calculation.index=itemsHTML.length;
  itemsHTML.push(new ZTObjects.calculationObj(calculation));
  var img=new Element ('span',{'class':'delete'});
  var newCalc=new Element('li',{id:calculation.calculationName}).adopt(new Element('span',{text:calculation.calculationName})).adopt(img)
  newCalc.store("index",calculation.index);
  document.id("calculationList").adopt(newCalc)
  newCalc.addEvent("click",function(){selectCalculation(this)})
  img.addEvent("click",function(){index = null;last_index=null;removeElement(this.parentNode,false,true)})
  listCalcName['calculation'+nCalculation]=true;
  nCalculation++;
  m_bUpdated=true;
  if (update){
    resizeGadgetsPane();
    selectCalculation(newCalc);
  }
}


function addAction(action,update){
  if (!action){
    action=getDefaultAction();
    while (listActionName['action'+nAction]){
      nAction++;
    }
    action.name='action'+nAction;
    action.actionName='action'+nAction;
  }
  if (Empty(action.uid))
    action.uid=LibJavascript.AlfaKeyGen(10);
  action.index=itemsHTML.length;
  itemsHTML.push(new ZTObjects.actionObj(action));
  var img=new Element ('span',{'class':'delete'});
  var newAction=new Element('li',{id:action.actionName}).adopt(new Element('span',{text:action.actionName})).adopt(img)
  newAction.store("index",action.index);
  document.id("actionList").adopt(newAction)
  newAction.addEvent("click",function(){selectAction(this)})
  img.addEvent("click",function(){index = null;last_index=null;removeElement(this.parentNode,false,true)})
  listActionName[action.actionName]=true;
  nAction++;
  m_bUpdated=true;
  if (update){
    resizeGadgetsPane();
    selectAction(newAction);
  }
}

function updateField(field){
  if (listFieldName[field.realFieldName]){
    var el=findElement(field.realFieldName,false);
    if (el){
      var position=el.data.index;
      itemsHTML[position].typeFilter='Query parameter';
      itemsHTML[position].objType=field.type;
      itemsHTML[position].len=field.len;
      itemsHTML[position].dec=field.dec;
      selectElement(el)
    }
  }
}

function deleteNode(nodeName,isGroup){
  var el=findElement(nodeName,isGroup)
  if (el)
    el._delete();
}

function removeElement(el,searchField,isCalculation){
  var position, i;
  if (isCalculation){
    position=el.retrieve('index');
    el.destroy();
  }
  else {
    position=el.data.index;
    if (searchField){ // la search field la faccio solo se sto cancellando i field dentro un gruppo dopo averlo cancellato
      var find=false;
      for (i=0; i<itemsHTML.length && !find; i++){
        if (itemsHTML[i].type!='group' && itemsHTML[i].name==el.name){
          position=i;
          find=true;
        }
      }
    }
  }
  if (itemsHTML[position].type=='field')
    listFieldName[itemsHTML[position].realFieldName]=false;
  else if (itemsHTML[position].type=='action')
    listActionName[itemsHTML[position].actionName]=false;
  itemsHTML.splice(position,1)
  for (i=position; i<itemsHTML.length; i++){
    if (itemsHTML[i].type=='calculation' || itemsHTML[i].type=='action'){
      document.id(itemsHTML[i].name).store('index',i)
    }
    else {
      var element=findElement(itemsHTML[i].name,itemsHTML[i].type=='group');
      if (element)
        element.data.index=i;
    }
  }
  if(!Empty(newPropObj))
    newPropObj.HideProperties();
  resizeGadgetsPane()
}

function checkField(){
  var _queryName;
  if (Empty(queryName)){
    _queryName=maskName;
    if (!Empty(_queryName))
      _queryName=_queryName.substring(0,_queryName.indexOf('__'));
  }
  else
    _queryName=queryName;
  SPTheme.modalLayerPreferredWidth=500;
  openSPModalLayer("./checkQueryParam.jsp?queryname="+_queryName+"&SPModalLayerId=mskSPModalLayer", 50, 250, 515, 575, false, 1, false,false)
}

function getField(){
  var jsonObj={};
  for (var i=0; i<itemsHTML.length; i++){
    if (itemsHTML.type!='group'){
      jsonObj[itemsHTML[i].id]={
        typeFilter:itemsHTML[i].typeFilter,
        descr:itemsHTML[i].label,
        type:itemsHTML[i].objType,
        len:itemsHTML[i].len,
        dec:itemsHTML[i].dec
      }
    }
  }
  return jsonObj;
}
var portlet_fake;
function refreshMask(){
  ZtVWeb.removePortlets();
  ZtVWeb.purgeEventsCache();
  setTimeout(function(){
    try{
      ZtVWeb.Include("../jsp/SPMaskParameters_portlet.jsp?ConfigObject="+URLenc(JSON.encode(getCurrentObj()))+"&m_cDecoration=none&zoomMode="+zoomMode+"&EmitterName=maskparameters&Width="+(document.id('previewMask').offsetWidth)+"&hideEditToolbar=true&editorMode=true&showHiddenVariant="+document.id("check_showHiddenVariant").checked+"&showAlwaysHidden="+document.id("check_showHidden").checked+"&extended="+document.id("check_showExtended").checked,'previewMask',true);
     }
     catch (e){
      PSAlert.alert("Error loading the mask. Control the field names in expressions")
     }

     portlet_fake=new function(){
      ZtVWeb.newForm(this,'portlet_fake','focus_receiver',400,200,'portlet');
      this.maskparameters_focus=new ZtVWeb.EventReceiverCtrl(this,'maskparameters_focus','field_focus','selectField(evt.field_focus)','','func');
      this.maskparameters_Lights=new ZtVWeb.EventEmitterCtrl(this,'maskparameters_Lights','fieldName','setLights()','func',' ',' ');
    }
    ZtVWeb.addPortletObj('portlet_fake','focus_receiver',portlet_fake);
    portlet_fake.on_maskparameters_focus=function(fieldFocus){portlet_fake.maskparameters_focus.receiveFnc(fieldFocus);}
    portlet_fake.maskparameters_Lights.setParms();
    portlet_fake.maskparameters_Lights.Emit();
  },0);
 // document.id('previewMask').style.width=0; // x chrome
  // setTimeout(function(){

    // document.id('previewMask').style.width='';
  // },100);
}

function maskPreview(){
  var preview=document.id('i_preview');
  preview.src="../jsp/SPMaskParameters_portlet.jsp?ConfigName="+this.currentname+"&m_cDecoration=none&custom="+formProp.customVdm;
  preview.style.top='35px';
}


function setToolbars(){
  if (preview_opened){
    toolbars.action.disable()
    toolbars.preview.disable('refresh')
    toolbars.preview.disable('showHiddenVariant')
    toolbars.preview.disable('showHidden')
  }
  else {
    toolbars.action.enable()
    toolbars.preview.enable('refresh')
    toolbars.preview.enable('showHiddenVariant')
    toolbars.preview.enable('showHidden')
  }
}

function setLights(){
  if (itemsHTML[index])
    return itemsHTML[index].realFieldName||itemsHTML[index].fieldName
  return ''
}

function selectItem(el){
  switch (el.type){
    case 'calculation':
      selectCalculation(document.id(el.name));
      break;
    case 'action':
      selectAction(document.id(el.name));
      break;
    default:
      selectField(el.id,el.type=='group');
      break;
  }
}

function selectField(id,isGroup){
  var toggler = document.id("field-toggler");
  if (toggler && !toggler.hasClass("opened")) {
    toggler.click();
  }
  focusProperty=false;
  var el=findElement(id,isGroup)
  if (el && !el.state.selected)
    field_tree.select(el)
  focusProperty=true;
}

function selectCalculation(el){
  var toggler = document.id("calculation-toggler");
  if (toggler && !toggler.hasClass("opened")) {
    toggler.click();
  }
  el.addClass('selected');
  last_index=index;
  field_tree.select(field_tree.root);
  index=el.retrieve('index');
  if (last_index!=null && (itemsHTML[last_index].type=='calculation' || itemsHTML[last_index].type=='action')){
    document.id(itemsHTML[last_index].name).removeClass('selected');
  }
  Properties();
}

function selectAction(el){
  var toggler = document.id("action-toggler");
  if (toggler && !toggler.hasClass("opened")) {
    toggler.click();
  }
  el.addClass('selected');
  last_index=index;
  field_tree.select(field_tree.root);
  index=el.retrieve('index');
  if (last_index!=null && (itemsHTML[last_index].type=='calculation' || itemsHTML[last_index].type=='action')){
    document.id(itemsHTML[last_index].name).removeClass('selected');
  }
  Properties();
}

function selectElement(){
  var el=field_tree.getSelected();
   if (el.parentNode && !el.parentNode.state.open)
    el.parentNode.toggle(true);
  var container=document.id('fieldListContainer');
  var node=el.getDOM('node')
  if ((node.getPosition().y+node.getSize().y) > (container.getPosition().y+container.getSize().y))
    new Fx.Scroll(container).toElement(node,'y')
  else if ((node.getPosition().y) < (container.getPosition().y))
    new Fx.Scroll(container).toElement(node,'y')
  if (index!=null && (itemsHTML[index].type=='calculation' || itemsHTML[index].type=='action'))
    document.id(itemsHTML[index].name).removeClass('selected');
  if (el && el.type[0]!='fieldList'){
    index=el.data.index;
    Properties();
  }
  else{
    last_index=null;
    index=null;
    if(!Empty(newPropObj))
      newPropObj.HideProperties();
  }
  if (portlet_fake)
    portlet_fake.maskparameters_Lights.Emit();
  if (itemsHTML[index] && itemsHTML[index].viewType=='textbox' && document.id('advanced_labelEmptyValue')){
    document.id('advanced_labelEmptyValue').fireEvent('hide');
  }
}

function reset(){
  if(!m_bUpdated || (confirm("Changes have not been saved yet.\r\nContinue loosing changes?"))){
    currentname = '';
    maskName='';
    variant='';
    var form=getDefaultForm();

    formProp = new ZTObjects.formObj(form)
    FormProperties();
    var root=field_tree.root;

    for (var i=root.children.length-1; i>=0; i--){
      root.children[i]._delete();
    }
    itemsHTML=[];
    document.id('previewMask').innerHTML="";
    document.id('properties').hide();
    index=null;
    last_index=null
  }
}
function editQuery(queryName) {
  queryName=queryName||itemsHTML[index].queryName;
  if(LRTrim(queryName)=="")
    PSAlert.alert("No query selected.");
  else if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    parent.newCurrentObj(queryName,"visualquery");
  else
    window.open("../visualquery/index.jsp?filename="+queryName,"visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function newQuery() {
  if(parent.newCurrentObj!=null && parent.portalStudioContainer)
    parent.newCurrentObj('New','visualquery');
  else
    window.open("../visualquery/index.jsp","visualquery","resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function editZoom(){
  if(LRTrim(itemsHTML[index].linkedTable)=="")
    PSAlert.alert("No table selected.");
  else if(LRTrim(itemsHTML[index].zoomConfigName)=="")
    PSAlert.alert("No zoom configuration selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj(itemsHTML[index].zoomConfigName+'['+itemsHTML[index].linkedTable+']',"portalzoom");
  else
    window.open("../portalzoom/portalzoomeditor.jsp?&Table="+itemsHTML[index].linkedTable+"&ConfigName="+URLenc(itemsHTML[index].zoomConfigName),"Zoom","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}
function newZoom(){
  if(LRTrim(itemsHTML[index].linkedTable)=="")
    PSAlert.alert("No table selected.");
  else if(parent.newCurrentObj!=null)
    parent.newCurrentObj('['+itemsHTML[index].linkedTable+']',"portalzoom");
  else
    window.open("../portalzoom/portalzoomeditor.jsp?&Table="+itemsHTML[index].linkedTable,"Zoom","height=600,width=780,resizable=yes,status=no,toolbar=no,menubar=no,location=no");
}


function select_font(obj){
  SelectFont(obj.refId);
}

function select_icon(obj){
  itemsHTML[index].font_name=itemsHTML[index].imageFont;
  SelectIcons(obj);
}

function openMask(el){
  SPTheme.modalLayerPreferredWidth=500;
  var left = 100;
  var top = 100;
  var allFieldName, allFieldDescription, i, j;
  switch (el.refPropId){
    case 'linkedTable':
    case 'tableName':
    case 'queryName':
      openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&parameter="+URLenc(itemsHTML[index][el.refPropId])+"&SPModalLayerId=mskSPModalLayer", top, left, 500, 500, false, 1, false,false)
      break;
    case 'keyField':
      openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action=keyField&parameter="+URLenc(itemsHTML[index].keyField)+"&tableName="+URLenc(itemsHTML[index].linkedTable)+"&SPModalLayerId=mskSPModalLayer", top, left, 500, 500, false, 1, false,false)
      break;
    case 'readField':
    case 'fixedFilter':
    case 'queryParameters':
    case 'linkedFieldName':
    case 'dependsOn':
    case 'filterField':
    case 'zoomQryParam':
      allFieldName=[],allFieldDescription=[];
      for (i=0, j=0; i<itemsHTML.length; i++){
        if (i!=index && itemsHTML[i].type=='field'){
          allFieldName[j]=itemsHTML[i].realFieldName||itemsHTML[i].fieldName;
          allFieldDescription[j]=itemsHTML[i].label;
          j++;
        }
      }
      if (el.refPropId=='queryParameters')
        openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action=queryParameters&parameter="+URLenc(itemsHTML[index].queryParameters)+"&queryName="+URLenc(itemsHTML[index].queryName)+"&allField="+URLenc(allFieldName.toString())+"&allFieldDescription="+URLenc(allFieldDescription.toString())+"&SPModalLayerId=mskSPModalLayer", top, left, 500, 500, false, 1, false,false)
      else if (el.refPropId=='linkedFieldName')
        openSPModalLayer("./SPMaskParametersConfigurator_filterList.jsp?action="+el.refPropId+"&allField="+URLenc(allFieldName.toString())+"&allFieldDescription="+URLenc(allFieldDescription.toString())+"&fieldSelected="+URLenc(itemsHTML[index][el.refPropId])+"&SPModalLayerId=filterMskSPModalLayer", top, left, 500, 500, false, 1, false,false)
      else if (el.refPropId=='filterField')
        openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&parameter="+URLenc(itemsHTML[index][el.refPropId])+"&tableName="+URLenc(itemsHTML[index].tableName)+"&allField="+URLenc(allFieldName.toString())+"&allFieldDescription="+URLenc(allFieldDescription.toString())+"&linkedField="+URLenc(itemsHTML[index].filterValue)+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      else
        openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&parameter="+URLenc(itemsHTML[index][el.refPropId])+"&tableName="+URLenc(itemsHTML[index].linkedTable)+"&allField="+URLenc(allFieldName.toString())+"&allFieldDescription="+URLenc(allFieldDescription.toString())+"&linkedField="+URLenc((el.refPropId=='readField'?itemsHTML[index].linkedField:itemsHTML[index].fixedValue))+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      break;

    case 'tableKeyField':
    case 'valueField':
      openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&parameter="+URLenc(itemsHTML[index][el.refPropId])+"&tableName="+URLenc(itemsHTML[index].tableName)+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      break;
    case 'orderField':
      if (itemsHTML[index].viewType=='querycombo')
        openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&parameter="+URLenc(itemsHTML[index][el.refPropId])+"&queryName="+URLenc(itemsHTML[index].queryName)+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      else
        openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&parameter="+URLenc(itemsHTML[index][el.refPropId])+"&tableName="+URLenc(itemsHTML[index].tableName)+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      break;
    case 'comboValues1':
      openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action=comboValues&parameter="+URLenc(itemsHTML[index].comboValues1)+"&queryName="+URLenc(itemsHTML[index].queryName)+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      break;
    case 'comboLabels1':
       openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action=comboLabels&parameter="+URLenc(itemsHTML[index].comboLabels1)+"&queryName="+URLenc(itemsHTML[index].queryName)+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      break;
    case 'comboValues':
      openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action=fixedCombo&allField="+URLenc(itemsHTML[index].comboValues)+"&allFieldDescription="+URLenc(itemsHTML[index].comboLabels)+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
      break;
    case 'zoomConfigName':
      if (!Empty(itemsHTML[index].linkedTable))
        openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&tableName="+URLenc(itemsHTML[index].linkedTable)+"&parameter="+URLenc(itemsHTML[index][el.refPropId])+"&SPModalLayerId=mskSPModalLayer", top, left, 500, 500, false, 1, false,false)
      else PSAlert.alert('No table selected');
      break;
    case 'parameters':
      allFieldName=[],allFieldDescription=[];
      for (i=0, j=0; i<itemsHTML.length; i++){
        if (itemsHTML[i].type=='field'){
          allFieldName[j]=itemsHTML[i].realFieldName||itemsHTML[i].fieldName;
          allFieldDescription[j]=itemsHTML[i].label;
          j++;
        }
      }
      openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action="+el.refPropId+"&parameter="+URLenc(Strtran(itemsHTML[index][el.refPropId],'&',','))+"&allField="+URLenc(allFieldName.toString())+"&allFieldDescription="+URLenc(allFieldDescription.toString())+"&SPModalLayerId=mskSPModalLayer",top, left, 500, 500, false, 1, false,false)
  }
}

function loadValue(action, value, value2){
  switch (action){
    case 'comboLabels':
    case 'comboValues':
      itemsHTML[index][action+"1"]=value;
      break;
    case 'fixedFilter':
    case 'filterField':
      var sep='';
      var code='';
      var val='';
      for (var i=0; i<value.length; i++){
        code+=sep+value[i];
        val+=sep+value2[i];
        sep=',';
      }
      if (action=='filterField'){
        itemsHTML[index].filterField=code;
        itemsHTML[index].filterValue=val;
      }
      else {
        itemsHTML[index].fixedFilter=code;
        itemsHTML[index].fixedValue=val;
      }
      existsField(val,action);
      break;
    case 'fixedCombo':
    case 'radio':
      itemsHTML[index].comboValues=value;
      itemsHTML[index].comboLabels=value2;
      break;
    case 'readField':
      itemsHTML[index].readField=value;
      itemsHTML[index].linkedField=value2;
      existsField(value2,action);
      break;
    default:
      itemsHTML[index][action]=value;
  }
  Properties();
}

function loadFieldName(value,action){
  itemsHTML[index][action]=value;
  Properties();
}

var notimooManager;
var old_name;
function save() {
	if(parent) parent.is_Saving=true;
	if(!Empty(currentname)){
    if (Empty(maskName)){ // maschera nuova
      updateUserGroup();
    }
    var _tmpCurrentName=(!Empty(maskName)?(maskName+(!Empty(variant)?'__'+variant:'')):currentname)+((this.formProp.user_group=='user' && !Empty(this.formProp.user))?'_'+this.formProp.user:((this.formProp.user_group=='group' && !Empty(this.formProp.group))?'_g'+this.formProp.group:''))
    var proceed=true;
    if (_tmpCurrentName!=currentname){ // cambiato il customization
      proceed=false;
      //controllo se esiste gi� e chiedo conferma
      var existConf=new JSURL("../servlet/SPVDMProxy?m_cAction=exist&m_cConfigName="+_tmpCurrentName+"&custom="+formProp.customVdm,true).Response();
      if (existConf!='1' || confirm("You have modified customize options.\nThis custom file already exist, overwrite?")){
        proceed=true;
      }
      currentname=_tmpCurrentName;
    }
    if (proceed){
      notimooManager = new Notimoo({});
      notimooManager.show({
        title:'Notification message',
        message: 'saving mask...',
        sticky : true,
        width:200,
        height:40
      });
      save2.delay(100);
    }
	} else {
    forceSaveVdm=true;
    OpenWindow('../portalstudio/saveas.jsp?&tool=maskparameters&custom='+formProp.customVdm, 580,600);
	}
}

function saveAs(){
  maskName='';
  forceSaveVdm=true;
  OpenWindow('../portalstudio/saveas.jsp?&tool=maskparameters&custom='+formProp.customVdm, 580,600);
}

function copyField(field){
  if (field){
    var obj={};
    for (var j=0; j<fieldProperties.length; j++){
      switch (fieldProperties[j]){
        case 'description':
          obj[fieldProperties[j]]=field.label;
        break;
        case 'dec':
        case 'displayLen':
        case 'maxQueryRow':
        case 'nCriteria':
        case 'cover':
        case 'labelWid':
        case 'linkWidth':
        case 'linkHeight':
        case 'row_suggest':
        case 'textWidth':
        case 'textHeight':
        case 'widthImage':
        case 'heightImage':
          obj[fieldProperties[j]]=isNaN(parseInt(field[fieldProperties[j]]))?0:parseInt(field[fieldProperties[j]])
        break;
        case 'len':
          switch (field.objType){
            case 'D':
              obj.len=8;
              break;
            case 'T':
               obj.len=14;
              break;
            case 'L':
               obj.len=1;
              break;
            default:
            obj.len=isNaN(parseInt(field.len))?10:parseInt(field.len)
          }
        break;
        case 'collapsedGroup':
        case 'keepOnPreviousRow':
        case 'changeOperation':
        case 'openZoom':
        case 'hideEmptyValue':
        case 'calculateLabel':
        case 'calculateInitialValue':
        case 'looselyLinked':
        case 'zeroFilling':
        case 'fillEmptyKeys':
        case 'calculateZoomTitle':
        case 'suggest':
        case 'sendAllParams':
        case 'popup':
        case 'popupScroll':
        case 'calculateTooltip':
        case 'hiddenLabel':
        case 'sendKeyZoomOnZoom':
          obj[fieldProperties[j]]=(field[fieldProperties[j]]=='true' || field[fieldProperties[j]]==true)
        break;
        case 'viewType':
          if (field.viewType=='textbox')
            obj.viewType='';
          else obj.viewType=field.viewType;
        break;
        case 'fixedFilter':
        case 'fixedValue':
          obj[fieldProperties[j]]=field[fieldProperties[j]].split(',');
        break;
        case 'comboValues':
        case 'comboLabels':
          if (field[fieldProperties[j]]=='')
            obj[fieldProperties[j]]=field[fieldProperties[j]+'1'];
          else {
            if (field[fieldProperties[j]+'1']=='')
              obj[fieldProperties[j]]=field[fieldProperties[j]];
            else {
              if (field.viewType=='combo' || field.viewType=='radio')
                obj[fieldProperties[j]]=field[fieldProperties[j]];
              else obj[fieldProperties[j]]=field[fieldProperties[j]+'1'];
            }
          }
        break;
        case 'editUnderCondition':
        case 'hideUnderCondition':
          if (LRTrim(field[fieldProperties[j]])!=''){
            obj[fieldProperties[j]]=field[fieldProperties[j]];
            obj['check_'+fieldProperties[j]]=true;
          }
          else obj[fieldProperties[j]]=''
        break;
        case 'isFilter':
          if (field.typeFilter=='No filter')
            obj.isFilter=false;
          else obj.isFilter=true;
        break;
        case 'queryFilter':
          if (field.typeFilter=='Query parameter')
            obj.queryFilter=true;
          else obj.queryFilter=false;
        break;
        case 'type':
          obj.type=field.objType;
        break;
        default:
          obj[fieldProperties[j]]=field[fieldProperties[j]];
        break;
      }
    }
    obj.extMask=field.visibility=='extMask';
    obj.hiddenGroup=field.visibility=='hiddenGroup';
    obj.hiddenInVariant=field.visibility=='hiddenInVariant';
    obj.fieldName=Strtran(obj.fieldName," ",""); //elimino eventuali spazi che causerebbero errore
    obj.realFieldName=Strtran(field.realFieldName||field.fieldName," ",""); //elimino eventuali spazi che causerebbero errore
    return obj;
  }
  else return getDefaultField();
}

function copyGroup(group){
  if (group){
    var obj={};
    for (var i=0; i<groupProperties.length; i++){
      if (groupProperties[i]=='columns' || groupProperties[i]=='maxFieldWidth' || groupProperties[i]=='maxLabelWidth' || groupProperties[i]=='minLabelWidth' || groupProperties[i]=='mode')
        obj[groupProperties[i]]=isNaN(parseInt(group[groupProperties[i]]))?0:parseInt(group[groupProperties[i]])
      else if (groupProperties[i]=='collapsedGroup' || groupProperties[i]=='calculateLabel')
        obj[groupProperties[i]]=(group[groupProperties[i]]=='true' || group[groupProperties[i]]==true)
      else if (groupProperties[i]=='listMinLabelWidth'){
        obj[groupProperties[i]]=group[groupProperties[i]].split(',')
        for (var j=0; j<obj.listMinLabelWidth.length; j++){
          if (Empty(obj.listMinLabelWidth[j]))
            obj.listMinLabelWidth[j]=0
          else obj.listMinLabelWidth[j]=parseInt(obj.listMinLabelWidth[j],10)
        }
      }
      else if (groupProperties[i]=='listColumnWidth')
        obj[groupProperties[i]]=group[groupProperties[i]].split(',');
      else obj[groupProperties[i]]=group[groupProperties[i]]
    }
    return obj;
  }
  else return getDefaultGroup();
}

function copyLabel(label){
  if (label){
    var obj={};
    for (var i=0; i<labelProperties.length; i++){
      switch (labelProperties[i]){
        case 'calculateLabel':
        case 'keepOnPreviousRow':
          obj[labelProperties[i]]=(label[labelProperties[i]]=='true' || label[labelProperties[i]]==true)
          break;
        case 'cover':
          obj[labelProperties[i]]=isNaN(parseInt(label[labelProperties[i]]))?0:parseInt(label[labelProperties[i]])
          break;
        default:
          obj[labelProperties[i]]=label[labelProperties[i]];
      }
    }
    obj.extMask=label.visibility=='extMask';
    obj.hiddenGroup=label.visibility=='hiddenGroup';
    obj.hiddenInVariant=label.visibility=='hiddenInVariant';
    obj.itemType='label'
    return obj;
  }
  else return getDefaultLabel();
}

function copyButton(button){
  if (button){
    var obj={};
    for (var i=0; i<buttonProperties.length; i++){
      switch (buttonProperties[i]){
        case 'hiddenGroup':
        case 'keepOnPreviousRow':
        case 'hiddenInVariant':
        case 'extMask':
        case 'sendAllParams':
        case 'popup':
        case 'popupScroll':
          obj[buttonProperties[i]]=(button[buttonProperties[i]]=='true' || button[buttonProperties[i]]==true)
          break;
        case 'linkWidth':
        case 'linkHeight':
        case 'widthImage':
        case 'heightImage':
          obj[buttonProperties[i]]=isNaN(parseInt(button[buttonProperties[i]]))?0:parseInt(button[buttonProperties[i]]);
          break;
        default:
          obj[buttonProperties[i]]=button[buttonProperties[i]];
      }
    }
    obj.extMask=button.visibility=='extMask';
    obj.hiddenGroup=button.visibility=='hiddenGroup';
    obj.hiddenInVariant=button.visibility=='hiddenInVariant';
    obj.itemType='button'
    return obj;
  }
  else return getDefaultButton();
}

function copyCalculation(calculation){
  if (calculation){
    var obj={}
    for (var i=0; i<calculationProperties.length; i++){
      obj[calculationProperties[i]]=calculation[calculationProperties[i]]
    }
    return obj;
  }
  else return getDefaulCalculation();
}

function copyAction(action){
  if (action){
    var obj={}
    for (var i=0; i<actionProperties.length; i++){
      obj[actionProperties[i]]=action[actionProperties[i]]
    }
    obj.progressBar=(action.progressBar=='true' || action.progressBar==true);
    obj.popup=(action.popup=='true' || action.popup==true);
    obj.popupScroll=(action.popupScroll=='true' || action.popupScroll==true);
    obj.sendAllParams=(action.sendAllParams=='true' || action.sendAllParams==true);
    return obj;
  }
  else return getDefaultAction();
}

function getCurrentObj(){
  var i, j;
  emptyGroup=false;
  var obj={};
  for (i=0; i<formProperties.length; i++){
    switch (formProperties[i]){
      case 'columns':
      case 'maxFieldWidth':
      case 'maxLabelWidth':
      // case 'minLabelWidth':
      case 'offsetTop':
      case 'mode':
      case 'cover':
        obj[formProperties[i]]=isNaN(parseInt(formProp[formProperties[i]]))?0:parseInt(formProp[formProperties[i]])
      break;
      case 'descriptionMask':
        obj[formProperties[i]]=formProp.description;
      break;
      case 'listMinLabelWidth':
        obj[formProperties[i]]=formProp[formProperties[i]].split(',')
        for (j=0; j<obj.listMinLabelWidth.length; j++){
          if (Empty(obj.listMinLabelWidth[j]))
            obj.listMinLabelWidth[j]=0
          else obj.listMinLabelWidth[j]=parseInt(obj.listMinLabelWidth[j],10)
        }
        break;
      case 'listColumnWidth':
        obj[formProperties[i]]=formProp[formProperties[i]].split(',')
        break;
      case 'filterAtChange':
      case 'progressBar':
      case 'closeOnConfirm':
      case 'spuid':
      case 'emptyAllParam':
        obj[formProperties[i]]=(formProp[formProperties[i]]=='true' || formProp[formProperties[i]]==true)
        break;
      default:
        obj[formProperties[i]]=formProp[formProperties[i]]
    }
  }
  // if (!obj.maskVersion) io passo sempre una maschera aggiornata
  obj.maskVersion=5;
  obj.configName=currentname;
  obj.fields=[];
  obj.groups=[];
  obj.minLabelWidth=0;
  // obj.labels=[];
  var elements=field_tree.root.children
  for (i=0; i<elements.length; i++){
    if (elements[i].type=='group'){
      if (elements[i].children.length>0){ // se un gruppo non ha campi all'interno non viene salvato
        obj.groups.push(copyGroup(itemsHTML[elements[i].data.index]))
        var el=elements[i].children;
        for (j=0; j<el.length; j++){
          if (itemsHTML[el[j].data.index].type=='label')
            obj.fields.push(copyLabel(itemsHTML[el[j].data.index]));
          else if (itemsHTML[el[j].data.index].type=='button')
            obj.fields.push(copyButton(itemsHTML[el[j].data.index]));
          else
            obj.fields.push(copyField(itemsHTML[el[j].data.index]));
          obj.fields[obj.fields.length-1].group=itemsHTML[elements[i].data.index].uid;
        }
      }
      else emptyGroup=true;
    }
    else if (elements[i].type=='label'){
      obj.fields.push(copyLabel(itemsHTML[elements[i].data.index]));
    }
    else if (elements[i].type=='button'){
      obj.fields.push(copyButton(itemsHTML[elements[i].data.index]));
    }
    else {
      obj.fields.push(copyField(itemsHTML[elements[i].data.index]));
    }
  }
  obj.calculation=[];
  elements=document.id("calculationList").getChildren();
  for (i=0; i<elements.length; i++){
    obj.calculation.push(copyCalculation(itemsHTML[elements[i].retrieve('index')]));
  }
  obj.action=[];
  elements=document.id("actionList").getChildren();
  for (i=0; i<elements.length; i++){
    obj.action.push(copyAction(itemsHTML[elements[i].retrieve('index')]));
  }
  return obj;
}

function save2() {
  var obj=getCurrentObj();
  if (emptyGroup)
    PSAlert.alert("Empty groups will not be saved")
  currentVersion++;
  obj.fileVersion=currentVersion;
  obj.configName=currentname;
  var url=new JSURL("../servlet/SPVDMProxy?m_cAction=save" +
    "&m_cConfigName=" + currentname +
    "&m_cWv=" + URLenc(JSON.encode(obj)) +
    "&forceSave=" + forceSaveVdm +
    "&custom=" + formProp.customVdm +
    "&m_cID=" + cmdhash
    ,true);
  var output=url.Response();
  if(window.parent.changeName) window.parent.changeName(currentname,{custom:formProp.customVdm},Strtran(window.frameElement.id,'portalstudioframe',''))
  if(window.parent.AddRecentOpen) window.parent.AddRecentOpen("maskparameters",currentname,{custom:formProp.customVdm=='true'})
  formProp.configName=currentname;
  propertyChangeNotifier.bind(formProp.objClass.newProperties.generic[0])(currentname,true,true)
  FormProperties()
  if (output==null) output=""
  notimooManager.close(notimooManager.elements[0]);
  if (output.indexOf('Saved')!=-1) {
    notimooManager.show({
       title:'Notification message',
       message: 'mask saved!',
       visibleTime: 2000,
       width:200
    });
    var _opener=GetOpener()||window.parent.GetOpener();
    if (_opener && _opener.savedVDMMask)
      _opener.savedVDMMask(obj);
    if (arguments.length > 0 && arguments[0] == "close") window.parent.closeCurrentObj();
    if(parent) parent.is_Saving=false;
    m_bUpdated=false;
    refreshMask();
    currentVersion=parseInt(Right(output,output.length-18))
  }
  else{
    currentVersion--;
    PSAlert.alert(output);
  }
  forceSaveVdm=false;
}

function writeHTML(){
  m_bUpdated=true;
  var ctrl = document.id('backcanvas');
  var tab = document.id('navmenu_tabcontainer');
  tab.style.left = ctrl.style.left;
  tab.style.width = ctrl.style.width;
  if (index!=null){
    if (itemsHTML[index].type=='calculation'){
      if (Empty(itemsHTML[index].calculationName))
        itemsHTML[index].calculationName=document.id(itemsHTML[index].name).getChildren()[0].innerHTML;
      else document.id(itemsHTML[index].name).getChildren()[0].innerHTML=itemsHTML[index].calculationName;
    }
    else if (itemsHTML[index].type=='action'){
      if (Empty(itemsHTML[index].actionName))
        itemsHTML[index].actionName=document.id(itemsHTML[index].name).getChildren()[0].innerHTML;
      else
        document.id(itemsHTML[index].name).getChildren()[0].innerHTML=itemsHTML[index].actionName;
    }
    else{
      var selectedElement=findElement(itemsHTML[index].name,itemsHTML[index].type=='group')
      if( itemsHTML[index].type=='field' && selectedElement){
      // aggiorno la lista dei campi
        if (itemsHTML[index].name!=itemsHTML[index].fieldName){ // ho cambiato il fieldName
          if (Empty(itemsHTML[index].fieldName))
            itemsHTML[index].fieldName=itemsHTML[index].name;
          else {
            listFieldName[itemsHTML[index].realFieldName]=false;
            var realFieldName=itemsHTML[index].fieldName;
            var idx=-1;
            while (listFieldName[realFieldName]){
              idx++;
              realFieldName=itemsHTML[index].fieldName+'_'+idx;
            }
            listFieldName[realFieldName]=true
            selectedElement.set({"name":realFieldName});
            itemsHTML[index].name=itemsHTML[index].fieldName;
            itemsHTML[index].id=realFieldName;
            itemsHTML[index].realFieldName=realFieldName;
          }
        }
        changeIconField(selectedElement);
        if (itemsHTML[index].viewType=='check' && (itemsHTML[index].objType=='D' || itemsHTML[index].objType=='T' || itemsHTML[index].objType=='M')){
          PSAlert.alert('Field can not be viewed as a checkbox');
          itemsHTML[index].viewType='textbox';
          propertyChangeNotifier.bind(itemsHTML[index].objClass.newProperties.advanced[0])('textbox',false,false)
          Properties()
        }
        if (itemsHTML[index].obligatoryCondition=='')
          itemsHTML[index].obligatory=false;
        if (itemsHTML[index].cover==0 && (selectedElement.data.viewType!=itemsHTML[index].viewType)){ // ho cambiato viewType
          if (itemsHTML[index].viewType=='combo' || itemsHTML[index].viewType=='querycombo' || itemsHTML[index].viewType=='tablecombo' || itemsHTML[index].viewType=='check'){
            itemsHTML[index].cover=1;
            propertyChangeNotifier.bind(itemsHTML[index].objClass.newProperties.view[0])('1',false,false)
            Properties()
          }
        }
        selectedElement.data.viewType=itemsHTML[index].viewType;
      }
      else if((itemsHTML[index].type=='label' || itemsHTML[index].type=='button') && selectedElement){
        selectedElement.set({"name":itemsHTML[index].fieldName});
      }
      else if (selectedElement){
        selectedElement.set({"name":itemsHTML[index].groupName});
        for (var i=0; i<selectedElement.children.length; i++){
          itemsHTML[selectedElement.children[i].data.index].group=itemsHTML[index].groupName;
        }
      }
    }
  }
}

function windowResize(){
  var ctrl = document.id('backcanvas');
  if(document.body.offsetWidth -document.id('gadgets_pane').offsetWidth >80)
		ctrl.style.width = (document.body.offsetWidth - ((document.id('gadgets_pane').opened ? document.id('gadgets_pane').offsetWidth : 0) + 40))+"px"; //margine di 30
  document.id('navmenu_tabcontainer').style.width = ctrl.style.width;
  if(document.getSize().y - ctrl.offsetTop > 0)
		ctrl.style.height = (document.getSize().y - (ctrl.offsetTop + 20))+"px";
  resizeGadgetsPane();
}


window.addEvent('resize', windowResize);

function Properties(){
  if (newPropObj && last_index != null && last_index==index){
    newPropObj.updatePropertiesFromPaint(itemsHTML[index]);
  }else{
    newPropObj = new propertiesObj({m_obj:itemsHTML[index],canExpandToColumn:false,tabindex:100,divcontainer:'properties',moveDiv:true});
    last_index=index;
    document.id('properties').show()
  }
}

function Help(the_property){
  var i, prop='';
  if(typeof(anchorToFeature)!='undefined'){
    if(typeof(the_property)!='undefined')
      prop+="maskparameters_"+the_property.toLowerCase();
    if(prop!='' && prop in anchorToFeature)
      i=anchorToFeature[prop];
    else if(index!=null && "maskparameters_"+itemsHTML[index].type.toLowerCase() in anchorToFeature)
      i=anchorToFeature["maskparameters_"+itemsHTML[index].type.toLowerCase()];
    else
      i=anchorToFeature["maskparameters"];
    windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?'+URLenc(i+(prop!=""?'||'+prop+"":"")),'','toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1',null,null,null,true);
  }
}

function findElement(name,isGroup){
  var listField=field_tree.root.children;
  for (var i=0; i<listField.length; i++){
    if (isGroup){
      if (listField[i].type[0]=='group' && listField[i].name==name){
        return listField[i];
      }
    }
    else {
      if (listField[i].type[0]=='group'){
        var listFieldGroup=listField[i].children;
        for (var j=0; j<listFieldGroup.length; j++){
          if (listFieldGroup[j].name==name){
            return listFieldGroup[j];
          }
        }
      }
      else {
        if (listField[i].name==name){
          return listField[i];
        }
      }
    }
  }
}

function ListObj(obj){
  var isGroup=(obj.options[obj.selectedIndex].innerText||obj.options[obj.selectedIndex].textContent).indexOf("group:")==0;
  field_tree.select(findElement(obj.value,isGroup))
}

function existsField(v,type){
  var i, j, find;
  if (v){
    var listField=v.split(',');
    var fieldToAdd=[], field, matchField=[], matchFieldToAdd=[], table='';
    switch (type){
      case 'readField':
        matchField=itemsHTML[index].readField.split(',');
        table=(itemsHTML[index].linkedTable.split('.'))[0];
      break
      case 'filterField':
        matchField=itemsHTML[index].filterField.split(',');
        table=itemsHTML[index].tableName;
      case 'fixedFilter':
        matchField=itemsHTML[index].fixedFilter.split(',');
        table=(itemsHTML[index].linkedTable.split('.'))[0];
      break
    }
    for (i=0; i<listField.length; i++){
      find=false;
      for (j=0; j<itemsHTML.length && !find; j++){
        if (itemsHTML[j].realFieldName==listField[i] && itemsHTML[j].objType!='group')
          find=true;
      }
      if (!find){
        fieldToAdd.push(listField[i])
        if (matchField[i])
          matchFieldToAdd.push(matchField[i])
      }
    }
    if (fieldToAdd.length>0 && confirm("Some fields are not defined. Create them?")){
      var allFields=[];
      if (!Empty(table)){
        var fieldsCSV = new JSURL("../servlet/SPXDCProxy?action=fields&table="+table+'&format=properties', true);
        fieldsCSV = fieldsCSV.Response();
        if (At(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP)==0){
          var oFields = new TrsJavascript();
          oFields.reset();
          oFields.SetRow(0);
          oFields.BuildProperties(Strtran(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP,''));
          var rows=GetProperty(oFields,'Rows','N');
          for(i=0;i<rows;i++){
            oFields.SetRow(i);
            allFields[i] = new Array(GetProperty(oFields,'alias','C'),GetProperty(oFields,'desc','C'),GetProperty(oFields,'type','C'),GetProperty(oFields,'len','N'),GetProperty(oFields,'dec','N'));
          }
        }
      }
      for (i=0; i<fieldToAdd.length; i++){
        field=getDefaultField();
        if (allFields.length>0 && matchFieldToAdd[i]){
          find=false;
          for (j=0; j<allFields.length && !find; j++){
            if (allFields[j][0]==matchFieldToAdd[i]){
              field.type=allFields[j][2];
              field.len=allFields[j][3];
              field.dec=allFields[j][4];
              find=true;
            }
          }
        }
        field.fieldName=fieldToAdd[i];
        addField(field,true)
      }
    }
  }
}

function updateIcon(){
  var list=field_tree.root.children
  for (var i=0; i<list.length; i++){
    if (list[i].type[0]=='group'){
      changeIconGroup(list[i]);
      if (list[i].state.open){
        var listField=list[i].children;
        for (var j=0; j<listField.length; j++){
          changeIconField(listField[j]);
        }
      }
    }
    else {
      changeIconField(list[i])
    }
  }
}

function changeIconField(field){
  var idx=field.data.index;
  if (itemsHTML[idx].typeFilter=='No filter'){
    field.getDOM('icon').removeClass('isFilter')
    field.getDOM('icon').addClass('noFilter')
  }
  else{
    field.getDOM('icon').removeClass('noFilter')
    field.getDOM('icon').addClass('isFilter')
  }
  if (itemsHTML[idx].hiddenGroup==true || itemsHTML[idx].hiddenGroup=="true"){
    field.getDOM('name').addClass('hidden')
    field.getDOM('icon').addClass('hidden')
  }
  else {
    field.getDOM('name').removeClass('hidden')
    field.getDOM('icon').removeClass('hidden')
  }
  if (itemsHTML[idx].hiddenInVariant==true || itemsHTML[idx].hiddenInVariant=="true"){
    field.getDOM('name').addClass('hiddenVariant')
    field.getDOM('icon').addClass('hiddenVariant')
  }
  else {
    field.getDOM('name').removeClass('hiddenVariant')
    field.getDOM('icon').removeClass('hiddenVariant')
  }
}

function changeIconGroup(group){
  if (group.children.length==0){
    group.getDOM('icon').removeClass('group')
    group.getDOM('icon').addClass('emptyGroup')
  }
  else {
    group.getDOM('icon').removeClass('emptyGroup')
    group.getDOM('icon').addClass('group')
  }
}
