/* global FromHTML refreshVdmVariant refreshVdmVariant LaunchCalendar WtH PrepareJsCalendar
    changeVersion
  */

/* exported drawMask */
function drawMask(){
  var portletObj=this;
  var parameters_main_div=document.createElement('DIV');
  parameters_main_div.id=this.formid+'_parameters_main';
  parameters_main_div.style.position='relative';
  parameters_main_div.style.overflow='auto';
  document.getElementById(this.formid).appendChild(parameters_main_div);
  var field_focus="";
  var lastFilterChangedId;
  var response;
  var tempParameters_div, parameters_div, tempParameters_lbl;
  this.tempFields=[];
  this.vzmFields={}
  var selectedField, selectedLabel;
  // eslint-disable-next-line no-unused-vars
  var initValue,blockChangeVdm=false; // utilizzata nel file SPVDMMask.java
  var loadPortlet=true;
  var _showHiddenVariant=this.editMode.Value() || (this.showHiddenVariant.Value());
  var _showAlwaysHidden=this.editorMode.Value() && this.showAlwaysHidden.Value();
  var _extendedMask=this.extended.Value()||this.editMode.Value();
  var existFilterType=false, extendedFields=false, hiddenInVariantFields=false, customToolbar;
  var filterTypeWid=85;
  var labelOperatorWidth=0;
  this.ShowItem=function(item, inExtMask, ignoreMobileStructure){
    if (_extendedMask || !inExtMask){
      if (this.isMobile && !ignoreMobileStructure){
        if (typeof(item)=="string")
          item=Ctrl(this.formid+'_lbl_'+item);
        var prtNode=item.parentNode.parentNode;
        if (LibJavascript.CssClassNameUtils.hasClass(prtNode,'row'))
          prtNode.style.display='';
        else{ // keep on previous row
          prtNode=item.parentNode; // div label
          prtNode.style.display='inline-block';
          var sibling=prtNode.nextSibling; // div del campo
          if (LibJavascript.CssClassNameUtils.hasClass(sibling,'rside'))
            sibling.style.display='inline';
        }
      }
      else {
        if (typeof(item)=="string"){
          var div=Ctrl(this.formid+"_div_"+item)
          if (div){
            div.style.visibility='';
            var allHidden=true;
            var listElements=div.parentNode.parentNode.getElementsByClassName('spMaskParameters_element');
            for (var i=0; i<listElements.length && allHidden; i++){
              if (listElements[i].style.visibility!='hidden')
                allHidden=false;
            }
            if (!allHidden)
              div.parentNode.parentNode.style.display='';
          }
        }
        else if (item){ // filtri temporanei
          item.Ctrl.style.display='inline-block';
          item.Ctrl.style.visibility='';
        }
      }
    }
  }

  this.ShowGroup=function(group,i){
    if (group.visibility!='extMask' || _extendedMask){
      if (!Empty(group.groupSetName)){
        this['tabs_'+group.groupSetName].Hide("parameter_groups_"+i,false);
        this['tabs_'+group.groupSetName].ShowTabsContainer();
      }
      else {
        var g=document.getElementById(this.formid+"_parameter_groups_"+i+"_DIV");
        g.style.display='block';
      }
    }
  }

  this.HideGroup=function(group,idx){
    if (!Empty(group.groupSetName)){
      this['tabs_'+group.groupSetName].Hide("parameter_groups_"+idx,true);
      var allHidden=true;
      for (var i=0; i<this.allGroups.length && allHidden; i++){
        if (this.allGroups[i].groupSetName==group.groupSetName && !this['tabs_'+group.groupSetName].IsHidden("parameter_groups_"+i)){
          allHidden=false;
        }
      }
      if (allHidden)
        this['tabs_'+group.groupSetName].HideTabsContainer();
    }
    else {
      var g=document.getElementById(this.formid+"_parameter_groups_"+idx+"_DIV");
      g.style.display='none';
    }
  }
  this.HideItem=function(item,ignoreMobileStructure){
    if (this.isMobile && !ignoreMobileStructure){
      if (typeof(item)=="string")
        item=Ctrl(this.formid+'_lbl_'+item);
      var prtNode=item.parentNode.parentNode;
      if (LibJavascript.CssClassNameUtils.hasClass(prtNode,'row'))
        prtNode.style.display='none';
      else{ // keep on previous row
        prtNode=item.parentNode; // div label
        prtNode.style.display='none';
        var sibling=prtNode.nextSibling; // div del campo
        if (LibJavascript.CssClassNameUtils.hasClass(sibling,'rside'))
          sibling.style.display='none';
      }
    }
    else {
      if (typeof(item)=="string"){
        var div=Ctrl(this.formid+"_div_"+item)
        if (div){
          div.style.visibility='hidden';
          var allHidden=true;
          var listElements=div.parentNode.parentNode.getElementsByClassName('spMaskParameters_element');
          for (var i=0; i<listElements.length && allHidden; i++){
            if (listElements[i].style.visibility!='hidden')
              allHidden=false;
          }
          if (allHidden)
            div.parentNode.parentNode.style.display='none';
        }
      }
      else if (item){
        item.Ctrl.style.display='none';
        item.Ctrl.style.visibility='hidden';
      }
    }
  }

  this.HideTempFilter=function(id){
    var el=document.getElementById(this.formid+'_div_'+id);
    if (el)
      el.parentNode.parentNode.style.display='none';
  }

  this.btn_confirm_Click=function(){
    if (!this.editMode.Value()){
      if (this.checkField()){
        this.$entity$_confirm.Emit();
        if (!EmptyString(this.splinker.Servlet()))
          this.splinker.Link();
        if (this.formObj.closeOnConfirm)
          WindowClose();
      }
    }
  }

  this.btn_discard_Click=function(){
    if (!this.editMode.Value()){
      this.$entity$_discard.Emit();
      if (!EmptyString(this.splinkerDiscard.Servlet()))
        this.splinkerDiscard.Link();
      else
        WindowClose();
    }
    else
      WindowClose();
  }

  this.saveBO_Click=function(){
    this.saveBOSplinker.Link();
  }
  this.saveBOSplinker_Updated=function(){
    alert(FormatMsg("MSG_SAVED_OK"));
    this.$entity$_savedEntity.Emit();
  }

  this.update=-1;

  this.drawActions=function(){
    for (var i=0; i<this.allActions.length; i++){
      var image;
      if (this.allActions[i].imageSettings=='default' || Empty(this.allActions[i].imageSettings)){
        image=this.allActions[i].imageUrl;
      }
      else {
        image={
          fontFamily:this.allActions[i].imageFont,
          size:this.allActions[i].imageSize,
          value:this.allActions[i].imageChar,
          color:this.allActions[i].imageColor
        }
      }
      customToolbar.AppendButton({
          image:image,
          action : 'javascript:'+this.formid+'.'+this.allActions[i].actionName+'_function()',
          target:this.allActions[i].target,
          title:this.allActions[i].title,
          tooltip:this.allActions[i].tooltip
        },0)
    }
  }

  this.addFilter=function(){
    var id=LibJavascript.AlfaKeyGen(10);
    var obj={
      fieldName:id,
      realFieldName:id,
      description:'',
      initialValue:'',
      type:'C',
      len:100, // da cambiare
      dec:0, // da cambiare
      displayLen:40,
      isFilter:true,
      queryFilter:false,
      viewType:'',
      changeOperation:true,
      initialOperation:'=',
      userFilter:true
    }
    this.tempFields.push(obj);
    this.createFilter(obj);
  }


  this.createFilter=function(obj){
    var listMinLabelW=this.formObj.listMinLabelWidth||[this.formObj.minLabelWidth];
    var div=document.createElement("div");
    var id=obj.fieldName;
    div.innerHTML=this.generateHtmlTempFields(id);
    div.style.marginBottom=this.isMobile?'15px':'4px';
    tempParameters_div.style.display='block';
    if (tempParameters_lbl){
      tempParameters_lbl.style.display='inline-block';
      if (!this.offlineMode.Value() && !this.isMobile){
        this.saveToolbar.Ctrl.style.top=(tempParameters_lbl.offsetTop-20)+'px';
        this.saveToolbar.Show();
        this.saveToolbar._refresh();
      }
    }
    tempParameters_div.appendChild(div);
    this.generateCodeTempFields(obj,id);
    this['lbl_'+id].Ctrl.style.position='relative';
    existFilterType=true;
    adjustMode1(
      [this.tempFields[this.tempFields.length-1]], {
        numColumns:this.numColumns,
        height:0,
        minLabelWid:listMinLabelW[0],
        maxLabelWidth:this.formObj.maxLabelWidth,
        listColumnWidth:this.formObj.listColumnWidth
      },
      true
    );
    this['filterType_'+id+'_Click']();
  }

  this.DrawPortlet=function(){
    this.htmlCode='';
    this.htmlCode_MainTable='';
    this.scriptCode='';
    this.allFields=[];
    this.allGroups=[];
    this.allCalculations=[];
    this.allActions=[];
    this.viewMode=0;
    this.numColumns=0;
    this.listField=[];
    this.heightField=0;
    this.currentCheck=0;
    this.currentname='';
    this.listFieldsName={}
    this.heightGroup=[];
    this.alertErrorMsg=true;
    var _opener=GetOpener();
    if (this.ConfigObject.Value()=='' && _opener){
      if (this.editMode.Value() && _opener.getConfigObj)
        this.ConfigObject.Value(JSON.stringify(_opener.getConfigObj(true)))
      else if (_opener.getConfigObjAsString){
        this.ConfigObject.Value(_opener.getConfigObjAsString())
      }
    }
    // if (this.zoomMode.Value())
    //   this.Mode.Value(1);
    url = new JSURL('../servlet/SPVDMMask?PortletID=__SPRANDOMPORTLET__SPVDMMask__UID__'+
                          (Empty(this.ConfigName.Value())?'':'&ConfigName='+this.ConfigName.Value())+
                          (Empty(this.ConfigObject.Value())?'':'&ConfigObject='+URLenc(this.ConfigObject.Value()))+
                          (Empty(this.QueryName.Value())?'':'&QueryName='+this.QueryName.Value())+
                          '&m_cDecoration='+this.m_cDecoration.Value()+
                          (Empty(this.editMode.Value())?'':'&editMode='+this.editMode.Value())+
                          (Empty(this.hideEditToolbar.Value())?'':'&hideEditToolbar='+this.hideEditToolbar.Value())+
                          (Empty(this.zoomMode.Value()) && Empty(this.detailFilterMode.Value())?'':'&zoomMode='+(this.zoomMode.Value() || this.detailFilterMode.Value()))+
                          '&custom='+this.custom.Value()+
                          (Empty(this.editorMode.Value())?'':'&editorMode='+this.editorMode.Value())+
                          (!_showHiddenVariant?'':'&showHiddenVariant='+_showHiddenVariant)+
                          (Empty(this.showAlwaysHidden.Value())?'':'&showAlwaysHidden='+this.showAlwaysHidden.Value())+
                          '&extendedMask='+_extendedMask+
                          '&offline='+this.offlineMode.Value()+
                          (Empty(this.OkAction.Value())?"":'&OkAction='+this.OkAction.Value())+
                          (Empty(this.OkResource.Value())?"":'&OkResource='+this.OkResource.Value())+
                          (Empty(this.Mode.Value())?"":'&ViewMode='+this.Mode.Value())+
                          (Empty(this.MaxFieldWidth.Value())?"":'&MaxFieldWidth='+this.MaxFieldWidth.Value())+
                          (Empty(this.Columns.Value())?"":'&Columns='+this.Columns.Value())+
                          (Empty(this.TitleMsg.Value())?"":'&TitleMsg='+this.TitleMsg.Value())+
                          (Empty(this.presetParams.Value())?"":"&presetParams="+this.presetParams.Value())+
                          (Empty(this.hideQueryParameters.Value())?"":"&hideQueryParameters="+this.hideQueryParameters.Value())+
                          (Empty(this.disablePresetParams.Value())?"":"&disablePresetParams="+this.disablePresetParams.Value())+
                          '&portletParameters='+URLenc(JSON.stringify(this.objRequest))+
                          '&update='+this.update+
                          (Empty(this.BOMode.Value())?"":("&BOMode=true&BOName="+this.BOName.Value()+
                          "&PKFields="+this.PKFields.Value()+"&PKValues="+this.PKValues.Value()+
                          "&saveBO="+this.saveBO.Value()))
                          ,!this.offlineMode.Value());
    response=url.Response();
    var portletID = this.Ctrl.id;
    response = response.replace( /(__SPRANDOMPORTLET__SPVDMMask__UID__)/g, function() {
      return portletID;
    });
    this.update=-1;
    if (response=="update"){
      this.update=window.WindowConfirm('The version is not aligned. Do you want to update?')?1:0;
      if (this.update==1){
        var url=new JSURL("../servlet/SPVDMProxy?m_cAction=updateMask&m_cConfigName="+this.ConfigName.Value()+"&forceSave=true&custom="+this.custom.Value(),true);
        var output=url.Response();
        if (output.indexOf('Saved')==-1){
          alert(FormatMsg("MSG_ERROR_SAVING_CONFIG")+" "+output);
        }
      }
      if (this.mergeParams)
        this.mergeParams(this.ConfigName.Value());
      this.DrawPortlet();
      if (this.afterChangeVersion)
        this.afterChangeVersion();
      return;
    }
    eval(response);
    parameters_main_div.innerHTML=this.htmlCode_MainTable;
    parameters_div=document.createElement('DIV');
    parameters_div.id=this.formid+'_parameters';
    parameters_div.style.position='relative';
    parameters_div.style.opacity=0;
    parameters_div.style.visibility='hidden';
    parameters_div.style.clear='both';
    parameters_div.style.paddingTop='10px';
    document.body.style.transform='none';
    if (document.getElementById(this.formid+"_main"))
      document.getElementById(this.formid+"_main").appendChild(parameters_div);
    ZtVWeb.IncludeFromString(this.htmlCode,parameters_div)
    if (this.zoomMode.Value() || this.detailFilterMode.Value()){
      if (this.zoomMode.Value()){
        tempParameters_lbl=document.createElement('span');
        tempParameters_lbl.innerHTML=this.tempFieldsLbl;
        tempParameters_lbl.style.marginTop='20px';
        tempParameters_lbl.style.marginLeft='5px';
        tempParameters_lbl.style.display='none';
        tempParameters_lbl.id=this.formid+'_lbl_tempParameters';
        tempParameters_lbl.className='TitleLabel';
      }
      tempParameters_div=document.createElement('DIV')
      tempParameters_div.id=this.formid+'_tempParameters';
      tempParameters_div.style.position='relative';
      tempParameters_div.style.display='none';
      tempParameters_div.style.paddingTop='20px';
      tempParameters_div.style.borderTop='1px solid';
      if (document.getElementById(this.formid+"_main")){
        if (tempParameters_lbl)
          document.getElementById(this.formid+"_main").appendChild(tempParameters_lbl);
        document.getElementById(this.formid+"_main").appendChild(tempParameters_div);
      }
    }
    eval(this.scriptCode);
    if (this.formObj.spuid){
      this.hideEditToolbar.Value(true);
      this.m_cDecoration.Value('none');
    }
    customToolbar=this.getTitlePortlet();
    // this.fillCustomToolbar(extendedFields,hiddenInVariantFields,_showHiddenVariant?'all':_extendedMask?'extended':'reduced');
    this.fillCustomToolbar(extendedFields,hiddenInVariantFields,_extendedMask?'extended':'reduced');
    if (this.editMode.Value()){
      var base_extendedLabel=document.createElement('div');
      base_extendedLabel.id='base_extendedLabel';
      base_extendedLabel.style.marginBottom="-7px";
      base_extendedLabel.innerHTML="<div class='label' style='font-size:70%; margin-left:10px;'>Base</div><div style='height:20px; border-left:1px solid #a6a6a6; width:8px; display:inline-block; margin-left:17px;'></div><div class='label'  style='display:inline-block; font-size:70%;'>Extended</div>"
      if (document.getElementById(portletObj.formid+"_main"))
        document.getElementById(portletObj.formid+"_main").insertBefore(base_extendedLabel,parameters_div);
      // this.portletVersion=ZtVWeb.Include("../jsp-system/SPSelectVersion_portlet.jsp",this.boxVersion.Ctrl,true);
      this.portletVersion=document.getElementById(this.formid+"_selectVersionPortlet");
      this.portletVersion.style.height='auto';
      this.portletVersion.style.width='100%';
      this.portletVersion.style.position='relative';
      this.portletVersion.className='smartEditor version';
      this.portletVersion.style.marginBottom='15px';
    }
    else {
      document.getElementById(this.formid+"_selectVersionPortlet").style.display='none';
      // this.selectVersionPortlet.Ctrl.style.display='none';
    }
    parameters_main_div.style.paddingTop=((!this.hideEditToolbar.Value() && "none"==this.m_cDecoration.Value()?30:0)+(this.OffsetTop.Value()!=0?this.OffsetTop.Value():this.formObj.offsetTop))+'px'; //per spostare su o giu
    this.queueAdjustHeight=function(){this.adjustHeight();}
    this.adjustWidth=function(){return null;}
    this.adjustHeight=function(){
      if(this.Ctrl.style['opacity']==0.001)
        this.Ctrl.style['opacity']=1;
      if (window.ztvwoptrk) {
        window.ztvwoptrk();
      }
      ZtVWeb.AdjustContainer();
    }
    // if(this.Width.Value()==0 && this.Ctrl.offsetWidth==0)
      // this.SetPortletWidth();

    this.SetSPLinkers();
    this.SetEmitter();


    var currentGroupName;
    for (var i=0; i<this.allFields.length; i++){
      var id=Strtran(this.allFields[i].realFieldName," ","");
      if (Empty(id))
        id=Strtran(this.allFields[i].fieldName," ","");
      this.listFieldsName[id]=true;

      if (!((this.allFields[i].hiddenGroup && !(_showAlwaysHidden)) || (this.allFields[i].hiddenInVariant && !(_showHiddenVariant)))){
        if (this.allFields[i].group!=currentGroupName){
          currentGroupName=this.allFields[i].group;
          this.listField.push({groupId:currentGroupName,fields:[]})
        }
        this.listField[this.listField.length-1].visible=true;
        this.listField[this.listField.length-1].fields.push(this.allFields[i]);
        if (!Empty(currentGroupName)){
          var found=false;
          for (var j=0; j<this.allGroups.length && !found; j++){
            if (this.allGroups[j].uid==currentGroupName){
              this.allGroups[j].visible=this.allGroups[j].visibility!='hiddenInVariant';
              // this.listField[this.listField.length-1].groupSetName=this.allGroups[j].groupSetName;
              found=true;
            }
          }
        }
      }
      else {
        if (this.allFields[i].group!=currentGroupName){
          currentGroupName=this.allFields[i].group;
          this.listField.push({groupId:currentGroupName,fields:[]})
        }
        this.listField[this.listField.length-1].fields.push(this.allFields[i]);
      }
    }
    if (!loadPortlet)
      this.this_Loaded();
  }

  this.ValidateCtrlsPage=function(where){
    if (!where || where==1)
      return this.checkField();
    else return true;
  }

  this.adjustMask=function(){
    setTimeout( function () {
      try{
        var i,nGroup=0;
        var _minLabelW=this.formObj.listMinLabelWidth[0]||this.formObj.minLabelWidth;
        var groupMinLabelWid;
        var parentDiv=null,div=parameters_div;
        while (div && div!=document.body){
          div=div.parentNode;
          if (div && div.style.display=='none'){
            parentDiv=div;
            parentDiv.style.display='block';
            div=null;
          }
        }
        for (i=0; i<this.listField.length; i++){
          for (var j=0; j<this.listField[i].fields.length;j++){
            if (!((this.listField[i].fields[j].hiddenGroup && !(_showAlwaysHidden)) || (this.listField[i].fields[j].hiddenInVariant && !(_showHiddenVariant)))){
              var id=Strtran(this.listField[i].fields[j].realFieldName,' ','');
              if (Empty(id))
                id=Strtran(this.listField[i].fields[j].fieldName,' ','');
              var label=portletObj['lbl_'+id]?portletObj['lbl_'+id].Ctrl:null;
              var field=portletObj['fld_'+id]?portletObj['fld_'+id].Ctrl:null;
              if (label){
                if (!this.listField[i].fields[j].hiddenLabel)
                  label.style.display='inline-block';
                label.style.position='relative';
                let container = label.parentNode.parentNode.parentNode;
                if (LibJavascript.CssClassNameUtils.hasClass(container,'rside'))
                  container.style.display='inline';
                else container.style.display='';
                if (field){
                  field.style.display='inline-block';
                  field.style.position='relative';
                }
              }
            }
          }
          this.listField[i].fields[0].keepOnPreviousRow=false;
          if (this.listField[i].visible){
            if (this.listField[i].groupId==''){
              if (this.viewMode==1)
                adjustMode1(
                  this.listField[i].fields, {
                    numColumns:this.numColumns,
                    minLabelWid:_minLabelW,
                    maxLabelWid:this.formObj.maxLabelWidth,
                    listColumnWidth:this.formObj.listColumnWidth
                  }
                );
              else {
                adjustMode2(
                  this.listField[i].fields, {
                    numColumns: (this.viewMode!=3?this.numColumns:this.listField[i].fields.length),
                    minLabelWid: _minLabelW,maxLabelWid:this.formObj.maxLabelWidth,
                    listColumnWidth:this.formObj.listColumnWidth
                  }
                );
              }
            }
            else {
              this.listField[i].groupName=this.allGroups[nGroup].groupName;
              groupMinLabelWid=this.allGroups[nGroup].listMinLabelWidth.length>0?this.allGroups[nGroup].listMinLabelWidth[0]:(this.allGroups[nGroup].minLabelWidth||_minLabelW);
              var nCols=(Empty(this.Columns.Value())?this.allGroups[nGroup].columns:this.Columns.Value())||this.numColumns;
                if (this.allGroups[nGroup].mode==1 || this.zoomMode.Value() || this.detailFilterMode.Value())
                adjustMode1(
                  this.listField[i].fields, {
                    numColumns: nCols,
                    minLabelWid: groupMinLabelWid,
                    maxLabelWid: this.allGroups[nGroup].maxLabelWidth||this.formObj.maxLabelWidth,
                    listColumnWidth:this.allGroups[nGroup].listColumnWidth
                  }
                );
              else {
                adjustMode2(
                  this.listField[i].fields, {
                    numColumns: (this.allGroups[nGroup].mode!=3?nCols:this.listField[i].fields.length),
                    minLabelWid: groupMinLabelWid,
                    maxLabelWid: this.allGroups[nGroup].maxLabelWidth||this.formObj.maxLabelWidth,
                    listColumnWidth:this.allGroups[nGroup].listColumnWidth
                  }
                );
              }
              if (this.editMode.Value()){
                var check=portletObj['check_group_'+nGroup].CtrlDiv;
                check.style.marginLeft='10px';
                check.style.verticalAlign='top'
                var header=Ctrl(this.formid+'_parameter_groups_'+nGroup+'_HEADER');
                if (header){
                  header.style.width=(header.offsetWidth-55)+'px';
                  header.style.marginLeft='4px';
                  header.style.display='inline-block';
                  header.parentNode.style.display='inline-block';
                  check.style.marginTop=(header.offsetHeight-15)/2+'px';
                }
                // for (var j=0; j<this.allGroups.length; j++){
                if (this.allGroups[nGroup].visibility=='hiddenInVariant'){
                  this["check_group_"+nGroup].Value('../portalstudio/images/btn_check_hidden.png');
                  this["check_group_"+nGroup+"_state"]='hidden';
                }
                else if (this.allGroups[nGroup].visibility=='extMask'){
                  this["check_group_"+nGroup].Value('../portalstudio/images/btn_check_extended.png');
                  this["check_group_"+nGroup+"_state"]='extended';
                }
                // }
                // if (this["check_group_"+nGroup+"_verifyOtherField"]){
                  // if (this["check_group_"+nGroup+"_verifyOtherField"]('visible')){
                    // this["check_group_"+nGroup].Value('../portalstudio/images/btn_check_base.png');
                    // this["check_group_"+nGroup+"_state"]='visible';
                  // }
                  // else if (this["check_group_"+nGroup+"_verifyOtherField"]('extended')){
                    // this["check_group_"+nGroup].Value('../portalstudio/images/btn_check_extended.png');
                    // this["check_group_"+nGroup+"_state"]='extended';
                  // }
                  // else {
                    // this["check_group_"+nGroup].Value('../portalstudio/images/btn_check_hidden.png');
                    // this["check_group_"+nGroup+"_state"]='hidden';
                  // }
                // }
              }
              if (this.isMobile){
                document.getElementById(this.formid+"_parameter_groups_"+nGroup+'_DIV').style.height='auto'
                document.getElementById(this.formid+"_parameter_groups_"+nGroup+"_filters").style.height='auto';
              }
              nGroup++;
            }
          }
          else if (this.listField[i].groupId!=''){
            this.heightGroup.push(0)
            nGroup++;
          }
        }

        for (i=0; i<this.allGroups.length; i++){
          if (this.allGroups[i].visible && this.allGroups[i].collapsedGroup){
            if (!Empty(this.allGroups[i].groupSetName))
              this["tabs_"+this.allGroups[i].groupSetName].Collapse("parameter_groups_"+i)
            else if(this["parameter_groups_"+i+"_filters_toggle_Click"])
              this["parameter_groups_"+i+"_filters_toggle_Click"]();
          }
        }

        document.getElementById(portletObj.formid+'_parameters').style.opacity=1;
        document.getElementById(portletObj.formid+'_parameters').style.visibility='visible';
        this.SetPortletHeight();
        if (this.zoomMode.Value())
          this.drawTempFields();
        this.canHide=true;
        if (this.this_HideUnderCondition)
          this.this_HideUnderCondition();
        if (parentDiv)
          parentDiv.style.display="none";
        if (_extendedMask)
          this.extend()
        else this.reduce();
        if (tempParameters_lbl)
          this.saveToolbar.Ctrl.style.top=(tempParameters_lbl.offsetTop-20)+'px';
      }
      catch(e){
        console.log(e.stack)
      }
    }.bind(this),0)
  }

  this.addVersion=function(name){
    var idx=name.indexOf("__");
    this.HamburgerMenu.CloseMenu();
    if (idx!=-1){
      this.vdmVersions.push(name);
      this.vdmVersions.sort();
      changeVersion(this.vdmVersions.indexOf(name));
    }
  }

  this.extend=function(){
    this.extended=true;
    _extendedMask=true;
    _showHiddenVariant=false;
    var i;
    for (i=0; i<this.allFields.length; i++){
      if (this.allFields[i].extMask){
        this.ShowItem(this.allFields[i].realFieldName||this.allFields[i].fieldName)
      }
    }
    for (i=0; i<this.allGroups.length; i++){
      if (this.allGroups[i].visibility=='extMask'){
        this.ShowGroup(this.allGroups[i],i)
      }
    }
    this.this_HideUnderCondition();
    this.updateExtendReduceButton('reduce');
    this.adjustHeight();
  }

  this.reduce=function(){
    this.extended=false;
    _extendedMask=false;
    _showHiddenVariant=false;
    var i;
    for (i=0; i<this.allFields.length; i++){
      if (this.allFields[i].extMask){
        this.HideItem(this.allFields[i].realFieldName||this.allFields[i].fieldName)
      }
    }
    for (i=0; i<this.allGroups.length; i++){
      if (this.allGroups[i].visibility=='extMask'){
        this.HideGroup(this.allGroups[i],i);
      }
    }

    this.updateExtendReduceButton('extend');
    this.adjustHeight();
  }

  this.showAll=function(){
    this.extended=true;
    _extendedMask=true;
    _showHiddenVariant=true;
    this.updateMask();
  }

  this.updateMask=function(){
    this.objRequest={};
    var parmsValue=this.getParametersValue();
    for (var el in parmsValue){
      this.objRequest[el]=parmsValue[el]
    }
    this.deleteGarbage();
    this.DrawPortlet();
  }

  this.generateHtmlTempFields=function(id){
    var html="";
    html+="<div style='display:inline-block; width:100%;'><div class='spMaskParameters_element' id='"+this.formid+"_div_"+id+"'>"
    //campo
    html+="<span id='"+this.formid+"_label_"+id+"' class='"+(this.isMobile?"SPLabel":"label")+" spMaskParameters_label' style='cursor:pointer; text-align:right;width:65px;margin-right:3px;margin-left:3px;'><div id='"+this.formid+"_label_"+id+"tbl' class='spMaskParameters_label_tbl'></div></span>";
    html+="<select id='"+this.formid+"_lbl_"+id+"' name='"+id+"' class='"+(this.isMobile?"Field":"combobox")+" spMaskParameters_combobox' title='' style='margin-right:3px;;margin-left:3px;'></select>";
    //operatore
    html+="<span id='"+this.formid+"_filterType_"+id+"' class='"+(this.isMobile?"SPLabel":"label")+" spMaskParameters_label' style='cursor:pointer; text-align:center; font-weight:800;'><div id='"+this.formid+"_filterType_"+id+"tbl' class='spMaskParameters_label_tbl'></div></span>";
    html+="<select id='"+this.formid+"_selectFilterType_"+id+"' name='"+id+"' class='"+(this.isMobile?"Field":"combobox")+" spMaskParameters_combobox' title='Filter type'></select>";
    //valore
    var length=this.isMobile?50:200
    html+="<span id='"+this.formid+"_fld_"+id+"_wrp' class='spMaskParameters_textbox_wrp' style='width:"+length+"px;'><input id='"+this.formid+"_fld_"+id+"' name='fld_"+id+"' type='text' class='"+(this.isMobile?"Field":"textbox")+" spMaskParameters_textbox'></span>";
    html+="</div></div>";
    return html;
  }

  this.ShowComboFilter=function(id){
    this.HideItem(this['filterType_'+id],true);
    this.ShowItem(this['selectFilterType_'+id],null,true);
    if (labelOperatorWidth && !this.isMobile){
      if (this['label_'+id].IsHidden())
        this['lbl_'+id].Ctrl.style.width=(labelOperatorWidth-this['selectFilterType_'+id].Ctrl.offsetWidth)+'px';
      else
        this['label_'+id].Ctrl.style.width=(labelOperatorWidth-this['selectFilterType_'+id].Ctrl.offsetWidth)+'px';
    }
  }

  this.HideComboFilter=function(id){
    this.ShowItem(this['filterType_'+id],null,true);
    this.HideItem(this['selectFilterType_'+id],true);
    if (labelOperatorWidth && !this.isMobile){
      if (this['label_'+id].IsHidden())
        this['lbl_'+id].Ctrl.style.width=(labelOperatorWidth-this['filterType_'+id].Ctrl.offsetWidth)+'px';
      else this['label_'+id].Ctrl.style.width=(labelOperatorWidth-this['filterType_'+id].Ctrl.offsetWidth)+'px';
    }
  }

  this.generateCodeTempFields=function(fld,id){
    //campo
    this['label_'+id]=new ZtVWeb.LabelCtrl(this,'label_'+id,this.formid+'_label_'+id,'',0,0,65,0,' ',' ',' ',' ',' ',' ',' ',' ',' ',false);
    this.HideItem(this['label_'+id],true);
    this['label_'+id].getRenderHeight=function(){return null};
    if (!this.labelVzmFields && GetOpener().GetRepeatedFields)
      this.SetConfigurationField(GetOpener().GetRepeatedFields());
    var label=this.labelVzmFields;
    var value=this.valueVzmFields;
    var presetParams=this.presetParams.Value().split(',');
    var sep=' ,';
    if (this.vqrParameters && this.vqrParameters.length>0){
      for (var i=0; i<this.vqrParameters.length; i++){
        if (presetParams.indexOf('w_'+this.vqrParameters[i].fieldName)==-1){
          label+=','+sep+(this.vqrParameters[i].description||this.vqrParameters[i].fieldName);
          value+=','+sep+this.vqrParameters[i].fieldName;
          sep='';
        }
      }
    }
    this['lbl_'+id]=new ZtVWeb.ComboboxCtrl(this,this.formid+"_lbl_"+id,'lbl_'+id,0,0,100,0,' ',label,value,false,'C',' ',true,false,false);
    this['lbl_'+id].FillData();
    this['lbl_'+id].Ctrl.style.position='relative';
    this['label_'+id].Ctrl.style.position='relative';
    if (!fld.fixed){
      this['label_'+id+'_Click']=(function(){return function() {
        if (!this.isMobile)
          this['lbl_'+id].Ctrl.style.width=this['label_'+id].Ctrl.offsetWidth+'px';
        else
          this['lbl_'+id].Ctrl.style.width='auto';
        this.HideItem(this['label_'+id],true);
        this.ShowItem(this['lbl_'+id],null,true);
      }})(id,this);
    }
    this['lbl_'+id+'_onChange']=(function(){return function(){
      if (!this.isMobile)
        this['label_'+id].Ctrl.style.width=this['lbl_'+id].Ctrl.offsetWidth+'px';
      else
        this['label_'+id].Ctrl.style.width='auto';
      var value=this['lbl_'+id].Value();
      if (value==' ')
        return;
      this.HideItem(this['lbl_'+id],true);
      value=this['lbl_'+id].testi[this['lbl_'+id].valori.indexOf(value)];
      this['label_'+id].Value(value);
      this.ShowItem(this['label_'+id],null,true);
      var oldFilter=this['filterType_'+id].Value()==':'?':':this['selectFilterType_'+id].Value();
      if (this.valueVzmFields.indexOf(this['lbl_'+id].Value())==-1){ // � un param query
        this['selectFilterType_'+id].Value('=');
        this['filterType_'+id].Value(':');
        this.HideComboFilter(id);
      }
      else{
        let operators = _getFilterTypeOptions(this.vzmFields[Upper(this['lbl_'+id].Value())] ? this.vzmFields[Upper(this['lbl_'+id].Value())].type: 'C');
        this['selectFilterType_'+id].FillDataStatic (operators[0], operators[1]); // aggiorno combo filtri
        if (this.vzmFields[Upper(this['lbl_'+id].Value())] && this.vzmFields[Upper(this['lbl_'+id].Value())].type=='C')
          this['selectFilterType_'+id].Value('contains');
        else this['selectFilterType_'+id].Value('=');
        if (oldFilter!=this['selectFilterType_'+id].Value()){
          this.ShowComboFilter(id);
        }
      }
    }})(id,this);
    this['lbl_'+id].AddListenerToHTMLEvent('onblur', 'Lostfocus');
    this['lbl_'+id+'_Lostfocus']=(function(){return function(){
      if (!this['lbl_'+id].IsHidden()){
        this['lbl_'+id+'_onChange'](id,this);
      }
    }})(id,this);
    // operazione
    this['filterType_'+id]=new ZtVWeb.LabelCtrl(this,'filterType_'+id,this.formid+'_filterType_'+id,'=',0,0,filterTypeWid,0,' ',' ',' ',' ',' ',' ',' ',' ',' ',false);
    this['filterType_'+id].getRenderHeight=function(){return null};
    let listOperator = _getFilterTypeOptions(this.vzmFields[Upper(this['lbl_'+id].Value())]?this.vzmFields[Upper(this['lbl_'+id].Value())].type:'C');
    this['selectFilterType_'+id]=new ZtVWeb.ComboboxCtrl(this,this.formid+'_selectFilterType_'+id,'selectFilterType_'+id,0,0,filterTypeWid,22,' ',listOperator[1],listOperator[0],false,'C',' ',true,false,false);
    this['selectFilterType_'+id].FillData();
    if (this.vzmFields[Upper(this['lbl_'+id].Value())] && this.vzmFields[Upper(this['lbl_'+id].Value())].type=='C')
      this['selectFilterType_'+id].Value('contains');
    else this['selectFilterType_'+id].Value('=');
    labelOperatorWidth=labelOperatorWidth||(this['lbl_'+id].Ctrl.offsetWidth+this['selectFilterType_'+id].Ctrl.offsetWidth);
    this.HideComboFilter(id);
    if (!fld.fixed){
      this['filterType_'+id+'_Click']=(function(){return function() {
        if (this.valueVzmFields.indexOf(this['lbl_'+id].Value())==-1)
          return;
        this.ShowComboFilter(id);
      }})(id,this);
    }
    this['selectFilterType_'+id].AddListenerToHTMLEvent('onblur', 'Lostfocus');
    this['selectFilterType_'+id+'_onChange']=(function(){return function(){
      var value=this['selectFilterType_'+id].Value();
      value=this['selectFilterType_'+id].testi[this['selectFilterType_'+id].valori.indexOf(value)];
      this['filterType_'+id].Value(value);
      this.HideComboFilter(id);
    }})(id,this);
    this['selectFilterType_'+id+'_Lostfocus']=(function(){return function(){
      if (!this['selectFilterType_'+id].IsHidden()){
        this['selectFilterType_'+id+'_onChange'](id,this);
      }
    }})(id,this);
    //valore
    this['fld_'+id]=new ZtVWeb.TextCtrl(this,'fld_'+id,this.formid+'_fld_'+id,0,0,100,22,' ','','character',' ','',false,0);
  }

  function _getFilterTypeOptions(type){
    let listOperator=['',''];
    if (type=='C' || type=='M'){
      listOperator[0]+="contains,like,";
      listOperator[1]+=ZtVWeb.Translate('MSG_CONTAINS')+","+ZtVWeb.Translate("MSG_STARTS_WITH")+",";
    }
    if (type!='M') {
      listOperator[0]+="=,";
      listOperator[1]+="=,";
      if (type!='L'){
        listOperator[0]+="<,<=,>=,>,";
        listOperator[1]+="<,<=,>=,>,";
      }
      listOperator[0]+="<>,";
      listOperator[1]+="<>,";
    }
    if (type!='L'){
      listOperator[0]+="empty,notempty,";
      listOperator[1]+=ZtVWeb.Translate("MSG_EMPTY")+","+ZtVWeb.Translate("MSG_NOTEMPTY")+",";
    }
    if (type=='D' || type=='T'){
      listOperator[0]+="currentmonth,currentyear,lastmonth,lastyear,last30days,last60days,last90days";
      listOperator[1]+=ZtVWeb.Translate("MSG_CURRENTMONTH")+","+ZtVWeb.Translate("MSG_CURRENTYEAR")+","+
      ZtVWeb.Translate("MSG_LASTMONTH")+","+ZtVWeb.Translate("MSG_LASTYEAR")+","+ZtVWeb.Translate("MSG_LAST30DAYS")+","+
      ZtVWeb.Translate("MSG_LAST60DAYS")+","+ZtVWeb.Translate("MSG_LAST90DAYS");
    }
    else {
      listOperator[0] = listOperator[0].substring(0,listOperator[0].length-1);
      listOperator[1] = listOperator[1].substring(0,listOperator[1].length-1);
    }
    return listOperator;
  }

  this.drawTempFields=function(){
    if (tempParameters_div.innerHTML!='')
      return;
    var html='', i, id;
    var listMinLabelW=this.formObj.listMinLabelWidth||[this.formObj.minLabelWidth];
    tempParameters_div.style.display='block';
    if (tempParameters_lbl){
      tempParameters_lbl.style.display='inline-block';
      this.saveToolbar.Ctrl.style.top=(tempParameters_lbl.offsetTop-20)+'px';
      this.saveToolbar.Show();
      this.saveToolbar._refresh();
    }
    for (i=0; i<this.tempFields.length; i++){
      html+="<div style='margin-bottom:"+(this.isMobile?"15":"4")+"px;'>"+this.generateHtmlTempFields(this.tempFields[i].realFieldName)+"</div>";
    }
    tempParameters_div.innerHTML=html;
    if (this.tempFields.length>0){
      for (i=0; i<this.tempFields.length; i++){
        id=this.tempFields[i].realFieldName;
        this.generateCodeTempFields(this.tempFields[i],id);
        this['lbl_'+id].Value(""); // prima lo metto vuoto, altrimenti se assegno il primo valore non parte la onchange
        if (this.tempFields[i].queryFilter)
          this['lbl_'+id].Value(this.tempFields[i].fieldName);
        else
          this['lbl_'+id].Value(Lower(this.tempFields[i].description));
        this.ShowItem(this['lbl_'+id],null,true);
        this['filterType_'+id].Value(this.tempFields[i].initialOperation);
        this['selectFilterType_'+id].Value(this.tempFields[i].initialOperation);
        this['fld_'+id].Value(this.tempFields[i].initialValue);
        if (this.tempFields[i].fixed){
          this['fld_'+id].Disabled();
          this['lbl_'+id].Disabled();
          this['selectFilterType_'+id].Disabled();
        }
      }
      existFilterType=true;
      adjustMode1(this.tempFields,
        {numColumns:this.numColumns,
          height:0,
          minLabelWid:listMinLabelW[0],
          maxLabelWidth:this.formObj.maxLabelWidth,
          listColumnWidth:this.formObj.listColumnWidth
        },true)
      var visibileFilter=false;
      for (i=0; i<this.tempFields.length; i++){
        id=this.tempFields[i].realFieldName;
        if (this.tempFields.hiddenGroup || this.tempFields[i].hiddenInVariant){
          this.HideTempFilter(id);
        }
        else {
          visibileFilter=true;
          this.HideItem(this['lbl_'+id],true);
          this.ShowItem(this['label_'+id],null,true);
          this['selectFilterType_'+id+'_onChange']();
          if (this.tempFields[i].queryFilter)
            this['filterType_'+id].Value(':');
        }
      }
      if (!visibileFilter && !this.hideAddFilterButton.Value())
        this.addFilter();

    }
    else if (this.allFields.length==0 && !this.hideAddFilterButton.Value()){
      this.addFilter();
    }
    else {
      tempParameters_div.style.display='none';
      if (tempParameters_lbl)
        tempParameters_lbl.style.display='none';
      this.saveToolbar.Hide();
    }
    if (this.offlineMode.Value() || this.isMobile)
      this.saveToolbar.Hide();
    this.SetPortletHeight();
  }

  function GetMaxWid(fields,mode,parms){
    var maxWid=[],wid=0,col=0;
    var fieldsDrawn=false;
    var i;
    for (i=0; i<parms.numColumns; i++){
      maxWid[i]={
        label:0,
        field:0,
        tot:0,
        allLabel:0
      }
    }
    var count=0;
    for (i=0; i<fields.length; i++){
      if (!((fields[i].hiddenGroup && !(_showAlwaysHidden)) || (fields[i].hiddenInVariant && !(_showHiddenVariant)))){
        if (!(fields[i].keepOnPreviousRow && fieldsDrawn)){
          col=count%parms.numColumns;
          wid=GetWid(fields[i],mode,parms)
          if ((fields[i].type=='L' || fields[i].viewType=='check') && mode==1 && (!portletObj.zoomMode.Value()))
            wid.field+=wid.label;
          else{
            if (wid.label>maxWid[col].label && (fields[i].itemType!='label' || fields[i].labelAlign=='right'))
              maxWid[col].label=wid.label;
            if (wid.label>maxWid[col].allLabel)
              maxWid[col].allLabel=wid.label;

          }
          wid.tot=Max(wid.field,wid.label);
          for (var j=i+1; j<fields.length; j++){
            if (fields[j].keepOnPreviousRow && !((fields[j].hiddenGroup && !(_showAlwaysHidden)) || (fields[j].hiddenInVariant && !(_showHiddenVariant)))){
              var widKOPR=GetWid(fields[j],mode,parms)
              if (mode==1)
                wid.field+=(widKOPR.label+widKOPR.field)-2//margin
              else if (mode==2){
                wid.tot+=Max(widKOPR.label,widKOPR.field)-2
              }
            }
            else j=fields.length; //esco dal ciclo break??
          }
          wid.tot+=20;
          if (mode==1)
            wid.field+=20;
          if (wid.field>maxWid[col].field)
            maxWid[col].field=wid.field;
          if (wid.tot>maxWid[col].tot)
            maxWid[col].tot=wid.tot;
          count++;
        }
        fieldsDrawn=true;
      }
    }
    if (maxWid[0].label==0)
      maxWid[0].label=parms.minLabelWid+2||0

    return maxWid;
  }

  function GetWid(el,mode,parms){
    var wid={
      label:0,
      field:0
    };
    var id=Strtran(el.realFieldName,' ','');
    if (Empty(id))
      id=Strtran(el.fieldName,' ','');
    var label=portletObj['lbl_'+id]?portletObj['lbl_'+id].Ctrl:null;
    var field=portletObj['fld_'+id]?portletObj['fld_'+id].Ctrl:{};
    if (label){
      label.style.width='';
      wid.label=label.scrollWidth+5;
      if (el.labelWid>0)
        wid.label=el.labelWid;
      if (wid.label>parms.maxLabelWid && parms.maxLabelWid>0 && !el.keepOnPreviousRow)
        wid.label=parms.maxLabelWid;
      if ((portletObj.zoomMode.Value() || portletObj.detailFilterMode.Value()) && el.isFilter && !el.queryFilter)
        wid.label+=filterTypeWid;
      wid.field=(field.offsetWidth||0);
      if (mode==1)
        wid.field+=4;
    }
    var btn=getBtn(id)
    if (btn)
      wid.field+=2+(btn.offsetWidth)
    return wid;
  }

  function adjustMode2(fields,parms){
      var maxWid=GetMaxWid(fields,2,parms);
      var label,col,field;
      var count=0;
      var fieldsDrawn=false;
      var margin=4;
      var marginLeft=portletObj.isMobile?2:18;
      for (var i=0; i<fields.length; i++){
        if (!((fields[i].hiddenGroup && !(_showAlwaysHidden)) || (fields[i].hiddenInVariant && !(_showHiddenVariant)))){
          var id=Strtran(fields[i].realFieldName,' ','');
          if (Empty(id))
            id=Strtran(fields[i].fieldName,' ','');
          label=portletObj['lbl_'+id]?portletObj['lbl_'+id].Ctrl:null;
          field=portletObj['fld_'+id]?portletObj['fld_'+id].Ctrl:null;
          if (label){
            label.style.display='block';
            label.parentNode.parentNode.style.minWidth=(Max(label.offsetWidth,(field?field.offsetWidth:0))+marginLeft)+"px";
            if (!(fields[i].keepOnPreviousRow && fieldsDrawn)){
              col=count%parms.numColumns;
              count++;
              if (parms.listColumnWidth[col]){
                var w=parms.listColumnWidth[col];
                if (parseInt(w)==w)
                  w+='%';
                label.parentNode.parentNode.style.width=w;
              }
              else label.parentNode.parentNode.style.width=(100/parms.numColumns)+"%";
              label.style.marginBottom=margin+'px';
              if (!isNextInKOPR(fields,i+1) && parms.numColumns>1)
                label.parentNode.style.width=(maxWid[col].tot-marginLeft)+'px'
              if (col!=0){
                label.parentNode.style.marginLeft=marginLeft+'px';
              }
              else{
                if (portletObj.editMode.Value()){
                  var check=portletObj['check_'+portletObj.currentCheck].Ctrl;
                  check.style.marginLeft='10px';
                  label.parentNode.style.marginLeft=margin+'px'
                  if (fields[i].hiddenGroup || fields[i].hiddenInVariant){
                    portletObj['check_'+portletObj.currentCheck].Value('../portalstudio/images/btn_check_hidden.png');
                    portletObj['check_'+portletObj.currentCheck+'_state']='hidden';
                  }
                  else if (fields[i].extMask){
                    portletObj['check_'+portletObj.currentCheck].Value('../portalstudio/images/btn_check_extended.png');
                    portletObj['check_'+portletObj.currentCheck+'_state']='extended';
                  }
                  portletObj.currentCheck++;
                }
                else label.parentNode.style.marginLeft=marginLeft+'px';

              }
            }
            else if (fields[i].keepOnPreviousRow){
              label.parentNode.style.marginLeft=margin+'px'
              label.style.marginBottom=margin+'px'
            }
          }
          var btn=getBtn(id);
          if (btn!=null){
            btn.style.position='relative';
            if (fields[i].itemType=='button' && !fields[i].keepOnPreviousRow)
              btn.style.marginLeft=marginLeft+'px';
            else btn.style.marginLeft='2px';
          }
          fieldsDrawn=true;
        }
      }

  }

  function getBtn(id){
    var btn=null;
    if (portletObj['calendar_btn_'+id]){
      btn=portletObj['calendar_btn_'+id].Ctrl;
    }
    else if (portletObj['zoom_btn_'+id]){
      btn=portletObj['zoom_btn_'+id].Ctrl;
    }
    else if (portletObj['btn_'+id]){
      btn=portletObj['btn_'+id].Ctrl;
    }
    return btn;
  }

  function setEmptyCss(fields){
    var formId=portletObj.formid;
    for (var i=0; i<fields.length; i++){
      if (!fields[i].hiddenGroup){
        var id=Strtran(fields[i].realFieldName,' ','');
        if (Empty(id))
          id=Strtran(fields[i].fieldName,' ','');
        var label=document.getElementById(formId+'_lbl_'+id);
        if (label){
          label.setAttribute("style", "");
          label=document.getElementById(formId+'_lbl_'+id+'tbl');
          if (label){
            label.setAttribute("style", "");
            if (fields[i].type=='L' || fields[i].viewType=='check' || fields[i].keepOnPreviousRow){
              label.style.display='inline';
              label.style.marginRight='3px';
            }
          }
          if (fields[i].itemType!='label'){
            var field;
            if ((fields[i].viewType=='' || fields[i].viewType=='link' || fields[i].viewType=='linkedUsing' || fields[i].viewType=='password') && 'L'!=fields[i].type)
              field=document.getElementById(formId+'_fld_'+id+'_wrp');
            else field=document.getElementById(formId+'_fld_'+id);
            field.setAttribute("style", "");
            if (fields[i].type=='N'){
              var img=field.getElementsByTagName('img')[0]
              if (img){
                img.style.display='none';
                img.parentNode.setAttribute("class","CalculatorButtonEnabled")
                img.parentNode.style.display="inline-block";
                img.parentNode.innerHTML+="&nbsp;";
              }
            }
            field=document.getElementById(formId+'_fld_'+id);
            field.setAttribute("style", "");
            field.style.width='auto';
            if (!Empty(fields[i].displayLen))
              field.style.width=(fields[i].displayLen*10)+'px';
            else if (fields[i].type=='M'){
              if (!Empty(fields[i].textWidth))
                field.style.width=fields[i].textWidth+'px';
              if (!Empty(fields[i].textHeight))
                field.style.height=fields[i].textHeight+'px';
            }
            if (fields[i].type=='L' || fields[i].viewType=='check')
              field.style.display='inline-block';
            else field.style.display='block';
          }
        }
        var btn=getBtn(id);
        if (btn){
          var background=btn.style.backgroundImage;
          btn.setAttribute("style", "");
          btn.style.backgroundImage=background;
          btn.style.border='0'
          btn.style.backgroundColor='transparent'
          btn.style.display='inline-block';
          btn.style.textDecoration='none';
        }
      }
    }
  }


  function adjustMode1(fields, parms){
      if (portletObj.isMobile){
        setEmptyCss(fields);
        return;
      }
      var margin=4;
      var marginLeft=portletObj.isMobile?2:18;
      var maxWid=GetMaxWid(fields,1,parms);
      var count=0,isCheckbox;
      var fieldsDrawn=false;
      for (var i=0; i<fields.length; i++){
        if (!((fields[i].hiddenGroup && !(_showAlwaysHidden)) || (fields[i].hiddenInVariant && !(_showHiddenVariant)))){
          var id=Strtran(fields[i].realFieldName,' ','');
          if (Empty(id))
            id=Strtran(fields[i].fieldName,' ','');
          isCheckbox=(fields[i].type=='L' || fields[i].viewType=='check');
          var label=portletObj['lbl_'+id]?portletObj['lbl_'+id].Ctrl:null;
          var field=portletObj['fld_'+id]?portletObj['fld_'+id].Ctrl:null;
          if (label){
            if (!portletObj.editMode.Value())
              label.parentNode.parentNode.style.minWidth=(40+label.offsetWidth+(field?field.offsetWidth:0))+"px";
            if (!(fields[i].keepOnPreviousRow && fieldsDrawn)){
              var col=count%parms.numColumns;
              // if ((fields[i].hiddenGroup && !(_showAlwaysHidden)) || (fields[i].hiddenInVariant && !(_showHiddenVariant))) //???
                // col=0;
              count++;
              if (!portletObj.editMode.Value()){
                if (parms.listColumnWidth[col]){
                  var w=parms.listColumnWidth[col];
                  if (parseInt(w)==w)
                    w+='%';
                  label.parentNode.parentNode.style.width=w;
                }
                else label.parentNode.parentNode.style.width=(100/parms.numColumns)+"%";
              }
              // if (!isNextInKOPR(fields,i+1) && parms.numColumns>1)
                // label.parentNode.style.width=(maxWid[col].label+maxWid[col].field+margin)+'px';
              if (!isCheckbox && (fields[i].itemType!='label' || (fields[i].labelAlign=='right')))
                label.style.width=maxWid[col].label+'px';
              // else label.style.width=GetWid(fields[i],1,parms).label+'px';
              if (portletObj.editMode.Value()){
                var check=portletObj['check_'+portletObj.currentCheck].Ctrl;
                check.style.marginLeft='10px';
                if (fields[i].labelAlign=='left'){
                  label.style.marginLeft=(margin+maxWid[0].label)+'px';
                }
                else label.style.marginLeft=margin+'px'
                if (fields[i].hiddenGroup || fields[i].hiddenInVariant){
                  portletObj['check_'+portletObj.currentCheck].Value('../portalstudio/images/btn_check_hidden.png');
                  portletObj['check_'+portletObj.currentCheck+'_state']='hidden';
                }
                else if (fields[i].extMask){
                  portletObj['check_'+portletObj.currentCheck].Value('../portalstudio/images/btn_check_extended.png');
                  portletObj['check_'+portletObj.currentCheck+'_state']='extended';
                }
                portletObj.currentCheck++
              }
              else if (isCheckbox){
                if (existFilterType)
                  label.style.marginLeft=margin+'px';
                else label.style.marginLeft=margin+'px';
              }
              else if (fields[i].labelAlign=='left'){
                label.style.marginLeft=(marginLeft+margin+maxWid[0].label)+'px';
              }
              else{
                label.style.marginLeft=marginLeft+'px'
              }

              if (!isCheckbox){
                if ((portletObj.zoomMode.Value() || portletObj.detailFilterMode.Value()) && existFilterType){
                  var filterType=portletObj['selectFilterType_'+id];
                  if (filterType){
                    filterType=filterType.Ctrl;
                    filterType.style.position='relative';
                    filterType.style.marginLeft=margin+'px';
                    filterType=portletObj['filterType_'+id].Ctrl
                    filterType.style.marginLeft=margin+'px';
                    field.style.marginLeft=margin+'px';
                    label.style.width=(label.offsetWidth-filterType.offsetWidth-4)+'px'
                  }
                  else if (field){
                    field.style.marginLeft=margin+'px';
                  }
                }
                else if (field)
                  field.style.marginLeft=margin+'px';
              }
              else if (field){
                  field.style.marginLeft=(maxWid[col].label+22)+'px';
              }
              label.style.height='auto';
            }
            else { // keep on prev row
              label.style.marginLeft=margin+'px';
              if (!isCheckbox && (fields[i].itemType!='label' || (fields[i].labelAlign=='right')) && fields[i].labelWid>0)
                label.style.width=fields[i].labelWid+'px';
              // label.style.width=GetWid(fields[i],1,parms).label+'px'; //controllare altezza
              if (!isCheckbox){
                if (portletObj.zoomMode.Value() || portletObj.detailFilterMode.Value()){
                  filterType=portletObj['selectFilterType_'+id];
                  if (filterType){
                    filterType=filterType.Ctrl;
                    filterType.style.position='relative';
                    filterType.style.marginLeft=margin+'px';
                    filterType=portletObj['filterType_'+id].Ctrl;
                    filterType.style.marginLeft=margin+'px';
                    field.style.marginLeft=margin+'px';
                  }
                  else if (field)
                    field.style.marginLeft=margin+'px';
                }
                else if (field)
                  field.style.marginLeft=margin+'px'
              }
              else if (field)
                field.style.marginLeft=margin+'px'
            }
            if ((portletObj.zoomMode.Value() || portletObj.detailFilterMode.Value()) && portletObj['label_'+id]){
              var label2=portletObj['label_'+id].Ctrl;
              label2.style.width=label.offsetWidth+'px';
              label2.style.marginLeft=label.style.marginLeft;
              label2.style.height='auto';
            }
          }
          var btn=getBtn(id);
          if (btn!=null){
            if (fields[i].itemType=='button'){
              if (!fields[i].keepOnPreviousRow)
                btn.style.marginLeft='23px';
              else if (portletObj.editMode.Value())
                btn.style.marginLeft=margin+'px';
              else btn.style.marginLeft='2px'
            }
            else btn.style.marginLeft='2px'
            btn.style.position='relative';
            btn.style.display='inline-block';
          }
          fieldsDrawn=true;
        }
      }
    // }.bind(this),0)
  }

  this.setRequestParameters=function(objRequest){
    objRequest=objRequest||this.objRequest;
    for (var i=0; i<this.allFields.length; i++){
      if (!this.resetAll || this.allFields[i].hiddenInVariant || this.allFields[i].hiddenGroup || this.allFields[i].editUnderCondition=='false' || this.allFields[i].hideUnderCondition=='true'){ // campo nascosto o sempre non editabile quindi non modificabile dall'utente
        var fieldName=this.allFields[i].fieldName;
        if (At("w_",fieldName)==1 && !objRequest[fieldName])
          fieldName=fieldName.substring(2);
        if (objRequest[fieldName]){
          var id=this.allFields[i].realFieldName||this.allFields[i].fieldName;
          this["fld_"+id].Value(objRequest[fieldName]);
        }
      }
    }
  }

  this.SetPortletHeight=function(){
    this.Ctrl.style.height='auto'
  }

  this.SetPortletWidth=function(){
  }

  function getAllParams(){
    var allParams="", sep="";
    for (var i=0; i<portletObj.allFields.length; i++){
      var id = Strtran(portletObj.allFields[i].realFieldName," ","");
      if (Empty(id))
        id = Strtran(portletObj.allFields[i].fieldName," ","");
      allParams+=sep+portletObj.allFields[i].fieldName+"=fld_"+id;
      sep=",";
      allParams+=sep+"w_"+portletObj.allFields[i].fieldName+"=fld_"+id;
    }
    return allParams;
  }

  this.initSplinker_Error=function(error){
    console.log(error)
  }

  this.SetSPLinkers=function(){
    var parms="", allParams="", sep1="",sep2="";;
    for (var i=0; i<this.allFields.length; i++){
      var id = Strtran(this.allFields[i].realFieldName," ","");
      if (Empty(id))
        id = Strtran(this.allFields[i].fieldName," ","");
      if (this.allFields[i].isFilter){
        parms+=sep1+this.allFields[i].fieldName+"=fld_"+id;
        sep1=",";
      }
      allParams+=sep2+this.allFields[i].fieldName+"=fld_"+id;
      sep2=",";
    }
    this.splinker.Parameters(parms);
    this.splinker.Servlet(this.onOkResource);
    this.checkSplinker.Parameters(allParams);
    this.checkSplinker.Servlet(this.checkFunction.Value()||this.formObj.onValidateFunction);
    this.initSplinker.setPrefix("fld_");
    this.initSplinker.Parameters(getAllParams());
    this.initSplinker.Servlet(this.initRoutine);
    this.confirmSplinker.Servlet(this.formObj.confirmRoutine)
    this.confirmSplinker.Parameters(getAllParams())
    this.confirmSplinker.setPrefix("fld_");
    this.splinkerDiscard.Servlet(this.onDiscardResource);
    if (this.target!=""){
      this.splinker.target=this.target;
    }
    if (this.discardTarget!=""){
      this.splinkerDiscard.target=this.discardTarget;
    }
    if (this.onOkAction!="")
      this.splinker.Action(this.onOkAction);
    if (this.onDiscardAction!="")
      this.splinkerDiscard.Action(this.onDiscardAction);
    if ((Empty(this.ProgressBar.Value()) && this.formObj.progressBar) || "true"==this.ProgressBar.Value()){
      this.splinker.progressbar=true;
      this.splinker.force_msg_id=true;
      this.splinker.async=true;
    }
  }

  this.SetEmitter=function(){
    this.$entity$_confirm.name=this.$entity$_confirm.name.replace('$entity$', this.EmitterName.Value());
    this.$entity$_discard.name=this.$entity$_discard.name.replace('$entity$', this.EmitterName.Value());
    this.$entity$_focus.name=this.$entity$_focus.name.replace('$entity$', this.EmitterName.Value());
    this.$entity$_Lights.name=this.$entity$_Lights.name.replace('$entity$', this.EmitterName.Value());
    this.$entity$_filterChanged.name=this.$entity$_filterChanged.name.replace('$entity$', this.EmitterName.Value());
    this['on_'+this.EmitterName.Value()+"_Lights"]=function(parmsObj){
      this.$entity$_Lights.receiveFnc(parmsObj);
    };
    // emitter/receiver per lo zoom
    if (this.EmitterName.Value())
      this.$entity$_zoomSetFilter.name=this.$entity$_zoomSetFilter.name.replace('$entity$_zoomSetFilter', this.EmitterName.Value());
    else this.$entity$_zoomSetFilter.name=this.$entity$_zoomSetFilter.name.replace('$entity$', this.Table.Value());

    var rcvName=this.ReceiverName.Value();
    if(EmptyString(rcvName)){
      rcvName=this.Table.Value();
    }

    this.$entity$_updateFilters.name=this.$entity$_updateFilters.name.replace('$entity$', rcvName);
    this['on_'+rcvName+"_updateFilters"]=function(parmsObj){
      this.$entity$_updateFilters.receiveFnc(parmsObj);
    };

    this.$entity$_GetConfigurationField.name=this.$entity$_GetConfigurationField.name.replace('$entity$', rcvName);
    this['on_'+rcvName+"_GetConfigurationField"]=function(parmsObj){
      this.$entity$_GetConfigurationField.receiveFnc(parmsObj);
    };
  }

  this.addParameterSPLinkerConfirm=function(parms){
    this.splinker.Parameters((this.splinker.Parameters()==''?'':this.splinker.Parameters()+',') +parms);
  }

  this.addParameterSPLinkerDiscard=function(parms){
    this.splinkerDiscard.Parameters((this.splinkerDiscard.Parameters()==''?'':this.splinkerDiscard.Parameters()+',') +parms);
  }

  try{
    this.DrawPortlet();
  }
  catch(e){
    console.log(e.stack)
  }

  this.DoOnKeyDown=function(e){
    e = e ? e : window.event;
    var keyCode = GetKeyCode(e);
    switch ( keyCode ) {
      case 27: // ESC
        portletObj.btn_discard_Click();
        CancelEvent(e);
      break;
      case 121: // F10
        portletObj.btn_confirm_Click();
        CancelEvent(e);
      break;
     default:
      portletObj.DoOnKeyDown2(e);
    }
  }

  this.DoOnKeyDown2=function(e){
    e = e ? e : window.event;
    var keyCode = GetKeyCode(e);
    switch ( keyCode ) {
      case 9: //TAB
        GetEventSrcElement(e);
        //DA RIVEDERE (probabilmente vengono chiamate tutte 2 volte)
        // if (portletObj[el.name+'_onChange'])
          // portletObj[el.name+'_onChange']();
        if (portletObj.this_Calc)
          portletObj.this_Calc();
        if (portletObj.this_EditUnderCondition)
          portletObj.this_EditUnderCondition()
        if (portletObj.this_HideUnderCondition)
          portletObj.this_HideUnderCondition()
      break;
    }
  }

  window.adminKeys=function(e,id){
    e = e ? e : window.event;
    var keyCode = GetKeyCode(e);
    if (id && keyCode==120){
      if (portletObj['zoom_btn_'+id])
        portletObj['zoom_btn_'+id].OpenZoom();
      else if (portletObj['calendar_btn_'+id])
        portletObj['calendar_btn_'+id+'_Click']();
    }
  }

  this.OpenCalendar=function(id){
    PrepareJsCalendar(false);
    LaunchCalendar(id);
  }

  this.execAsyncSpLinker=function(){
    this.splinker.async=true;
    if (!EmptyString(this.splinker.Servlet()))
      this.splinker.Link();
  }



  this.apply=function(){
    var obj=this.getObjConfigFromEditMode();
    if (GetOpener().setConfigObj){
      GetOpener().setConfigObj(obj.configName,JSON.stringify(obj))
      WindowClose();
    }
  }

  if (this.zoomMode.Value()){
    this.saveMask=function(){
      this.currentname=this.zoomConfigName.Value()+'.'+this.Table.Value();
      var obj=this.getObjConfigFromEditMode(true);
      obj.configName=this.currentname;
      obj.maskVersion=6;
      var url=new JSURL("../servlet/SPVDMProxy?m_cAction=save"+
        "&m_cConfigName="+this.currentname+
        "&m_cWv="+URLenc(JSON.stringify(obj))+
        "&forceSave=true"+
        "&custom="+(!this.isAdmin) +
        "&m_cID=" + this.savinghashparameter
        ,true);
      var output=url.Response();
      if (output.indexOf('Saved')==-1){
        alert(FormatMsg("MSG_ERROR_SAVING_CONFIG")+" "+output);
      }
      else {
        alert(FormatMsg("MSG_SAVED_OK"));
        refreshVdmVariant(this.currentname,true);
      }
    }
  }


  if (this.editMode.Value()){

    this.saveMask=function(){
      var versionName=this.selectVersionPortlet.getVersionName();
      var fileName=this.formObj.configName.toLowerCase();
      var idx=fileName.lastIndexOf('__');
      if (idx>-1){
        var v=fileName.substring(idx);
        if (!LibJavascript.String.EndsWith(v, '.'+this.Table.Value())){
          fileName=fileName.substring(0,idx);
        }
      }
      if (!Empty(versionName))
        if(versionName!=this.selectVersionPortlet.getUserGroup())
          fileName=fileName+'__'+versionName;
        else fileName+=versionName;
      this.formObj.originMask=this.formObj.configName;
      this.currentname=fileName;
      var obj=this.getObjConfigFromEditMode(true);
      var refresh=false;
      if (obj.configName==this.currentname)
        refresh=true;
      else obj.configName=this.currentname;
      var custom=this.selectVersionPortlet.getCustom()||!this.isAdmin;
      var url=new JSURL("../servlet/SPVDMProxy?m_cAction=save" +
        "&m_cConfigName=" + this.currentname +
        "&m_cWv=" + URLenc(JSON.stringify(obj)) +
        "&forceSave=true" +
        "&custom=" + custom +
        "&m_cID=" + this.savinghashparameter
        ,true);
      var output=url.Response();
      if (output.indexOf('Saved')==-1){
        alert(FormatMsg("MSG_ERROR_SAVING_CONFIG")+" "+output);
      }
      else {
        if (GetOpener().refreshVdmVariant)
            GetOpener().refreshVdmVariant(this.currentname,refresh)
        WindowClose();
      }

    }
    this.deleteVersion=function(){
      var url=new JSURL("../servlet/SPVDMProxy?m_cAction=deleteVersion&m_cConfigName="+this.formObj.configName+"&custom="+this.custom.Value(),true);
      var deleted=url.Response();
      alert(deleted)
    }
  }

  window.refreshVdmVariant=function(name,refresh){
    if (refresh){
      portletObj.ConfigObject.Value("");
      portletObj.zoomConfigName.Value("");
      portletObj.QueryName.Value("");
      portletObj.ConfigName.Value(name);
      portletObj.resetMask();
    }
    else
      portletObj.addVersion(name);
  }

  this.getFilterValueAndOperator=function(){
    var filters=[],obj,operator,value,id;
    var operatorsWithoutValue = ["empty", "notempty", "currentyear", "lastyear", "currentmonth", "lastmonth", "last30days", "last60days", "last90days"];
    for (var i=0; i<this.allFields.length; i++){

      if ((Empty(this.allFields[i].itemType) || this.allFields[i].itemType=='field') && this.allFields[i].isFilter ){
        id = Strtran(this.allFields[i].realFieldName," ","");
        if (Empty(id))
          id = Strtran(this.allFields[i].fieldName," ","");
        value=this['fld_'+id].Value();
        operator=this['selectFilterType_'+id]?this['selectFilterType_'+id].Value():this.allFields[i].initialOperation;
        if (!Empty(value) || operatorsWithoutValue.indexOf(operator) > -1){
          obj={
            name:this.allFields[i].fieldName,
            operator:operator
          }
          if (this['fld_'+id].type=='D')
            obj.value= FormatDate(value,'YYYY-MM-DD');
          else if (this['fld_'+id].type=='T')
            obj.value= FormatDateTime(value,'YYYY-MM-DD hh:mm:ss');
          else
            obj.value=value;
          filters.push(obj);
        }
      }
    }
    return filters;
  }

  this.findDetail=function(next){
    if (this.checkField()){
      if (this.detailFilterMode.Value() && GetOpener().FindDetail){
        GetOpener().FindDetail(this.getFilterValueAndOperator(),next);
      }
    }
  }

  this.applyFilter=function(blockClose){
    if (this.checkField()){
      this.$entity$_zoomSetFilter.Emit();
      if (this.closeWhenApplyFilter.Value() && !blockClose)
        WindowClose();
    }
  }

  this.refreshZoom=function(){
    this.resetAll=this.formObj.emptyAllParam;
    this.resetMask();
    this.resetAll=false;
    this.applyFilter(true);
  }

  this.print=function(){
    var height=600;
    var width=800;
    var left=(screen.width)?(screen.width-width)/2:100;
    var top=(screen.height)?(screen.height-height-(height/4))/2:100;
    window.open("../servlet/Report?ReportName="+this.ReportName.Value()+
                    (EmptyString(this.PrintFormat.Value())?"":"&outputFormat="+this.PrintFormat.Value())+
                    (EmptyString(this.PrintOrientation.Value())?"":"&rotation="+this.PrintOrientation.Value())+
                    "&m_cVZMParamBlock="+URLenc(this.GetParamBlock()),"print","height="+height+",width="+width+",left="+left+",top="+top+",resizable=yes,scrollbars=yes");
  }

  this.deleteGarbage=function(keepTempFields){ // hide dei gruppi
    var id, i;
    for (i=0; i<this.allFields.length; i++){
      id=this.allFields[i].realFieldName;
      if (Empty(id))
        id=this.allFields[i].fieldName;
      delete this['fld_'+id];
      if (this['fld_'+id+'_onChange'])
        delete this['fld_'+id+'_onChange']
      if (this['fld_'+id+'_Lostfocus'])
        delete this['fld_'+id+'_Lostfocus']
      if (this['fld_'+id+'_Validate'])
        delete this['fld_'+id+'_Validate']
      if (this['fld_'+id+'_Error'])
        delete this['fld_'+id+'_Error']
    }
    for (i=0; i<this.allGroups.length; i++){
      if (this["parameter_groups_"+i+"_filters_toggle_Click"])
        delete this["parameter_groups_"+i+"_filters_toggle_Click"];
      if (!Empty(this.allGroups[i].groupSetName) && this['tabs_'+this.allGroups[i].groupSetName])
        delete this['tabs_'+this.allGroups[i].groupSetName];
    }
    if (!keepTempFields){
      for (i=0; i<this.tempFields.length; i++){
        id=this.tempFields[i].realFieldName||this.allFields[i].fieldName;
        if (this['fld_'+id])
          delete this['fld_'+id];
        if (this['fld_'+id+'_onChange'])
          delete this['fld_'+id+'_onChange']
        if (this['fld_'+id+'_Lostfocus'])
          delete this['fld_'+id+'_Lostfocus']
        if (this['fld_'+id+'_Validate'])
          delete this['fld_'+id+'_Validate']
        if (this['fld_'+id+'_Error'])
          delete this['fld_'+id+'_Error']
      }
      this.tempFields=[];
      if (tempParameters_div)
        tempParameters_div.innerHTML='';
    }
    if (this.this_EditUnderCondition)
      delete this.this_EditUnderCondition
    if (this.this_HideUnderCondition)
      delete this.this_HideUnderCondition
    if (this.this_Loaded)
      delete this.this_Loaded
    if (this.checkField)
      delete this.checkField
    if (this.this_Calc)
      delete this.this_Calc
    if (this.LoadDefaultValues)
      delete this.LoadDefaultValues
  }

  this.resetMask=function(){
    loadPortlet=false;
    customToolbar.RemoveButtons();
    // portletObj.custom.Value(false);
    portletObj.deleteGarbage();
    portletObj.DrawPortlet();
  }

  this.editMask=function(){
    this.HamburgerMenu.CloseMenu();
    windowOpenForeground("../portalstudio/portalstudio.jsp?tool=maskparameters&id="+this.formObj.configName+"&zoomMode="+this.zoomMode.Value(),"superEdit","width="+(window.screen.width-50)+",height="+(window.screen.height-100)+",resizable=yes,top=0,left=0");
  }


  this.quickSettings=function(){
    this.HamburgerMenu.CloseMenu();
    if (Empty(this.formObj.configName) && this.zoomMode.Value())
      this.formObj.configName=this.zoomConfigName.Value()+'.'+this.Table.Value()
    windowOpenForeground("../jsp/SPMaskParameters_portlet.jsp?editMode=true&zoomMode="+this.zoomMode.Value()+"&extendedMask=true"+"&Table="+this.Table.Value(),"speedEdit","width=950,height=650,left="+(window.screen.width/2-475)+",top="+(window.screen.height/2-475));
  }
  if (!window.changeVersion){
    window.changeVersion=function(i){
      portletObj.HamburgerMenu.CloseMenu();
      if (!blockChangeVdm){
        if (portletObj.vdmVersions[i]!=portletObj.formObj.configName){
          portletObj.HamburgerMenu.Clean();
          if ("none"!=portletObj.m_cDecoration.Value()){
            customToolbar.Clean();
          }
          portletObj.ConfigName.Value(portletObj.vdmVersions[i]);
          portletObj.ConfigObject.Value(null);
          portletObj.objRequest={};
          var parmsValue=portletObj.getParametersValue();
          for (var el in parmsValue){
            portletObj.objRequest[el]=parmsValue[el]
          }
          if (portletObj.beforeChangeVersion)
            portletObj.beforeChangeVersion();
          portletObj.resetMask();
          if (portletObj.afterChangeVersion)
            portletObj.afterChangeVersion();
        }
      }
    }
  }

  window.getConfigObj=function(tempFields){
    return portletObj.getObjConfigFromEditMode(tempFields);
  }

  if (!this.hideEditToolbar.Value()){
    window.savedVDMMask=function(obj){
      if (portletObj.mergeParams)
        portletObj.mergeParams(obj.configName);
      portletObj.DrawPortlet();
      if (portletObj.afterChangeVersion)
        portletObj.afterChangeVersion();
      if (GetOpener() && GetOpener().savedVDMMask)
        GetOpener().savedVDMMask();
    }
    window.setConfigObj=function(configName,obj){
      portletObj.deleteGarbage();
      portletObj.ConfigName.Value(configName)
      portletObj.ConfigObject.Value(obj);
      portletObj.DrawPortlet();
      portletObj.ConfigObject.Value(null)
    }
  }

  this.UpdateTempFilters=function(filters){
    this.tempFields=[];
    tempParameters_div.innerHTML='';
    var i;
    if (filters && filters.length>0){
      for (i=0; i<filters.length; i++){
        // prima di inserire il filtro temporaneo controllo che non ce ne sia gi� uno uguale
        var found=false;
        for (var j=0; j<this.allFields.length && !found; j++){
          if ((!this.allFields[j].queryFilter) && Lower(this.allFields[j].fieldName)==Lower(filters[i].field) && this.allFields[j].initialOperation==filters[i].operator){
            var fieldName=this.allFields[j].realFieldName||this.allFields[j].fieldName;
            this['fld_'+fieldName].Value(filters[i].expression);
            found=true;
          }
        }
        if (!found){
          var id=LibJavascript.AlfaKeyGen(10);
          this.tempFields.push({
            fieldName:id,
            realFieldName:id,
            description:filters[i].field,
            initialValue:filters[i].expression,
            type:filters[i].type,
            len:100, // da cambiare
            dec:0, // da cambiare
            displayLen:(filters[i].type=='D')?10:40,
            isFilter:true,
            queryFilter:false,
            viewType:'',
            changeOperation:true,
            initialOperation:filters[i].operator,
            fixed:filters[i].fixed||false,
            userFilter:filters[i].userFilter,
            defaultFilter:filters[i].defaultFilter,
            hiddenInVariant:!filters[i].visible
          });
        }
      }
    }
    if (this.vqrParameters && this.vqrParameters.length>0){
      var presetParams=this.presetParams.Value().split(',');
      for (i=0; i<this.vqrParameters.length; i++){
        if (this.objRequest[this.vqrParameters[i].fieldName] && presetParams.indexOf('w_'+this.vqrParameters[i].fieldName)==-1)
          this.tempFields.push({
            fieldName:this.vqrParameters[i].fieldName,
            realFieldName:this.vqrParameters[i].fieldName,
            description:this.vqrParameters[i].description,
            initialValue:this.objRequest[this.vqrParameters[i].fieldName],
            type:this.vqrParameters[i].type,
            len:this.vqrParameters[i].len, // da cambiare
            dec:this.vqrParameters[i].dec, // da cambiare
            displayLen:(this.vqrParameters[i].type=='D')?10:40,
            isFilter:true,
            queryFilter:true,
            viewType:'',
            changeOperation:false,
            initialOperation:'='
          });
      }
    }
    this.drawTempFields();
  }

  this.Lights=function(fieldName){
    if (selectedField){
      selectedField.style.borderColor='';
      selectedField.style.backgroundColor='';
    }
    if (selectedLabel){
      selectedLabel.style.color='';
    }
    selectedField=Ctrl(portletObj.formid+"_fld_"+fieldName)
    selectedLabel=Ctrl(portletObj.formid+"_lbl_"+fieldName+'tbl')
    if (selectedField){
      selectedField.style.borderColor='#EAC57E';
      selectedField.style.backgroundColor='#F0F4FE';
    }
    if (selectedLabel){
      selectedLabel.style.color='#EAC57E';
    }
  }

  this.GetParamBlock=function(){
    var result = [], filterValue, filterType;
    var i, id, filterOperation;
    for(i=0;i<this.allFields.length;i++){
      id = Strtran(this.allFields[i].realFieldName," ","");
      if (Empty(id))
        id = Strtran(this.allFields[i].fieldName," ","");
      filterValue = this['fld_'+id].Value();
      filterType = this.allFields[i].type;

      // Date e DateTime vanno convertiti in un formato standard.
      if(filterType=="D"){
        filterValue = ZtVWeb.strToValue(filterValue,filterType,ZtVWeb.defaultDatePict);
        filterValue = ZtVWeb.applyPicture(filterValue,'D',0,"YYYYMMDD");
      }
      else if(filterType=="T"){
        filterValue = ZtVWeb.strToValue(filterValue,filterType,ZtVWeb.defaultDateTimePict);
        filterValue = ZtVWeb.applyPicture(filterValue,'T',0,"YYYYMMDDhhmmss");
      }
      else{
        // I valori numerici vanno convertiti in stringhe.
        filterValue = (ZtVWeb.strToValue(filterValue,filterType,"")).toString();
      }

      if(this.allFields[i].isFilter){
        filterOperation = this.allFields[i].queryFilter ? "" : this['selectFilterType_'+id]?this['selectFilterType_'+id].Value():this.allFields[i].initialOperation;
        result.push({filter_field: Strtran(this.allFields[i].fieldName," ",""),
                        filter_type: filterType,
                        filter_value: filterValue,
                        query_param: (this.allFields[i].queryFilter?id:''),
                        filter_operation: filterOperation});
      }
    }
    // Filtri temporanei
    for(i=0;i<this.tempFields.length;i++){
      id = Strtran(this.tempFields[i].realFieldName," ","");
      if (Empty(id))
        id = Strtran(this.tempFields[i].fieldName," ","");
      filterValue = this['fld_'+id].Value();
      filterType = this.tempFields[i].type;

      if(filterType=="D"){
        filterValue = ZtVWeb.strToValue(filterValue,filterType,ZtVWeb.defaultDatePict);
        filterValue = ZtVWeb.applyPicture(filterValue,'D',0,"YYYYMMDD");
      }
      else if(filterType=="T"){
        filterValue = ZtVWeb.strToValue(filterValue,filterType,ZtVWeb.defaultDateTimePict);
        filterValue = ZtVWeb.applyPicture(filterValue,'T',0,"YYYYMMDDhhmmss");
      }
      else{
        filterValue = (ZtVWeb.strToValue(filterValue,filterType,"")).toString();
      }

      if(!Empty(filterValue)){
        filterOperation = this['selectFilterType_'+id]?this['selectFilterType_'+id].Value():this.allFields[i].initialOperation
        result.push({filter_field: Strtran(this['lbl_'+id].Value()," ",""),
                        filter_type: filterType,
                        filter_value: filterValue,
                        query_param: '',
                        filter_operation: filterOperation});
      }
    }
    return JSON.stringify(result);
  }

  this.getZoomParametersValue=function(){
    var parmsValue={}
    var i, id;
    if (this.zoomMode.Value()){
      var fixedFilterCount=0;
      for (i=0; i<this.allFields.length; i++){
        if (this.allFields[i].isFilter && (Empty(this.allFields[i].itemType) || this.allFields[i].itemType=='field')){
          id = Strtran(this.allFields[i].realFieldName," ","");
          if (Empty(id))
            id = Strtran(this.allFields[i].fieldName," ","");
          var name=this.allFields[i].fieldName;
          if (this.allFields[i].queryFilter && At('w_',name)!=1)
            name='w_'+name;
          parmsValue[fixedFilterCount]={}
          // parmsValue[fixedFilterCount][this.allFields[i].fieldName]=this['fld_'+id].Value();
          if (this['fld_'+id].type=='D')
            parmsValue[fixedFilterCount][name]= FormatDate(this['fld_'+id].Value(),'YYYY-MM-DD');
          else if (this['fld_'+id].type=='T')
            parmsValue[fixedFilterCount][name]= FormatDateTime(this['fld_'+id].Value(),'YYYY-MM-DD hh:mm:ss');
          else
            parmsValue[fixedFilterCount][name]= this['fld_'+id].Value();
          // parmsValue[fixedFilterCount][this.allFields[i].fieldName+'_fixed']=true;
          if (!(this.allFields[i].hiddenGroup || this.allFields[i].hiddenInVariant)){
            parmsValue[fixedFilterCount][name+'_op']=this['selectFilterType_'+id]?this['selectFilterType_'+id].Value():this.allFields[i].initialOperation;
          }
          else parmsValue[fixedFilterCount][name+'_op']=this.allFields[i].initialOperation;
          parmsValue[fixedFilterCount][name+'_queryParm']=this.allFields[i].queryFilter?name:'';
          parmsValue[fixedFilterCount][name+'_type']=this['fld_'+id].type;
          parmsValue[fixedFilterCount][name+'_visible']=!(this.allFields[i].hiddenGroup || this.allFields[i].hiddenInVariant);
          parmsValue[fixedFilterCount][name+'_defaultFilter']=true;
          fixedFilterCount++;
        }
      }
      for (i=0; i<this.tempFields.length; i++){
        if (this.tempFields[i].isFilter){
          id = Strtran(this.tempFields[i].realFieldName," ","");
          if (Empty(id))
            id = Strtran(this.tempFields[i].fieldName," ","");
          parmsValue[fixedFilterCount]={}
          var filterName=this['lbl_'+id].Value()||this.tempFields[i].description;
          var queryParms=this.valueVzmFields.indexOf(filterName)==-1 && !(this.tempFields[i].hiddenGroup || this.tempFields[i].hiddenInVariant);
          if (queryParms)
            filterName="w_"+filterName;
          if (this['fld_'+id].type=='D')
            parmsValue[fixedFilterCount][filterName]= FormatDate(this['fld_'+id].Value(),'YYYY-MM-DD');
          else if (this['fld_'+id].type=='T')
            parmsValue[fixedFilterCount][filterName]= FormatDateTime(this['fld_'+id].Value(),'YYYY-MM-DD hh:mm:ss');
          else
            parmsValue[fixedFilterCount][filterName]= this['fld_'+id].Value();
          if (queryParms){
            parmsValue[fixedFilterCount][filterName+'_op']='=';
          }
          else if (!(this.tempFields[i].hiddenGroup || this.tempFields[i].hiddenInVariant)){
            parmsValue[fixedFilterCount][filterName+'_op']=this['selectFilterType_'+id]?this['selectFilterType_'+id].Value():this.tempFields[i].initialOperation;
          }
          else parmsValue[fixedFilterCount][filterName+'_op']=this.tempFields[i].initialOperation;
          if (queryParms){
            parmsValue[fixedFilterCount][filterName+'_queryParm']=filterName;
            parmsValue[fixedFilterCount][filterName+'_type']=this['fld_'+id].type;
          }
          parmsValue[fixedFilterCount][filterName+'_visible']=!(this.tempFields[i].hiddenGroup || this.tempFields[i].hiddenInVariant);
          parmsValue[fixedFilterCount][filterName+'_fixed']=this.tempFields[i].fixed||false;
          parmsValue[fixedFilterCount][filterName+'_userFilter']=this.tempFields[i].userFilter;
          parmsValue[fixedFilterCount][filterName+'_defaultFilter']=this.tempFields[i].defaultFilter;
          fixedFilterCount++;
        }
      }
      parmsValue['removeFixed']=true;
    }
    return parmsValue;
  }

  this.getParametersDescription=function(){
    var parmsDesc={}
    for (var i=0; i<this.allFields.length; i++){
      if ((Empty(this.allFields[i].itemType) || this.allFields[i].itemType=='field')){
        var id = Strtran(this.allFields[i].realFieldName," ","");
        if (Empty(id))
          id = Strtran(this.allFields[i].fieldName," ","");
          parmsDesc[this.allFields[i].fieldName]= this.allFields[i].description;
      }
    }
    return parmsDesc;
  }

  this.getParametersValue=function(onlyFilter,toJsVal){
    var parmsValue={}
    for (var i=0; i<this.allFields.length; i++){
      if ((Empty(this.allFields[i].itemType) || this.allFields[i].itemType=='field') && (!onlyFilter || this.allFields[i].isFilter)){
        var id = Strtran(this.allFields[i].realFieldName," ","");
        if (Empty(id))
          id = Strtran(this.allFields[i].fieldName," ","");
        if (this['fld_'+id].type=='D')
          parmsValue[this.allFields[i].fieldName]= FormatDate(this['fld_'+id].Value(),'YYYY-MM-DD');
        else if (this['fld_'+id].type=='T')
          parmsValue[this.allFields[i].fieldName]= FormatDateTime(this['fld_'+id].Value(),'YYYY-MM-DD hh:mm:ss');
        else if (this['fld_'+id].type=='C' && toJsVal)
          parmsValue[this.allFields[i].fieldName]= LibJavascript.ToJSValue(this['fld_'+id].Value());
        else
          parmsValue[this.allFields[i].fieldName]= this['fld_'+id].Value();
      }
    }
    return parmsValue;
  }

  this.getFieldFocus=function(){
    return field_focus;
  }

  this.getLastFilterChangedValue=function(){
    return this['fld_'+lastFilterChangedId].Value();
  }

  this.getLastFilterChangedOperator=function(){
    if (this['selectFilterType_'+lastFilterChangedId])
      return this['selectFilterType_'+lastFilterChangedId].Value();
    else return "=";
  }

  this.getObjConfigFromEditMode=function(tempFields){
    this.currentCheck=0;
    var fields=[];
    var nGroup=0, i;
    for (i=0; i<this.listField.length; i++){
      if (this.listField[i].groupId==''){
        fields=fields.concat(getFieldFromEditMode(this.listField[i].fields))
      }
      else {
        var nCols=Empty(this.Columns.Value())?this.allGroups[nGroup].columns:this.Columns.Value()
        if (this.allGroups[nGroup].mode==3)
          nCols=this.listField[i].fields.length;
        fields=fields.concat(getFieldFromEditMode(this.listField[i].fields,nCols))
        nGroup++;
      }
    }
    if (tempFields){
      var _fields=getFieldFromEditMode(this.tempFields);
      var vqrParameters={};
      if (_fields.length>0){
        var vzmFields=this.valueVzmFields.split(',');
        var labelVzmFields=this.labelVzmFields.split(',');
        for (i=0; i<_fields.length; i++){
          var fieldName=this['lbl_'+_fields[i].fieldName].Value();
          if (!Empty(fieldName)){
            var idx=vzmFields.indexOf(fieldName);
            if (idx==-1){ // parametro query
              if (!vqrParameters[fieldName]){
                vqrParameters[fieldName]=true;
                _fields[i].fieldName=fieldName;
                 _fields[i].queryFilter=true;
                _fields[i].initialValue=this['fld_'+_fields[i].realFieldName].Value();
                _fields[i].realFieldName=fieldName;
                var found=false;
                for (var j=0; j<this.vqrParameters.length && !found; j++){
                  if (this.vqrParameters[j].fieldName==fieldName){
                    found=true;
                    _fields[i].description=this.vqrParameters[j].description;
                    _fields[i].type=this.vqrParameters[j].type;
                    _fields[i].len=this.vqrParameters[j].len;
                    _fields[i].dec=this.vqrParameters[j].dec;
                  }
                }
                fields=fields.concat(_fields[i]);
              }
            }
            else {
              _fields[i].description=labelVzmFields[idx];
              _fields[i].initialValue=this['fld_'+_fields[i].realFieldName].Value();
              _fields[i].fieldName=this['lbl_'+_fields[i].realFieldName].Value();
              _fields[i].displayLen=10;
              fields=fields.concat(_fields[i]);
            }
          }
        }
      }
    }
    this.formObj.fields=fields;
    this.formObj.groups=getGroups(this.allGroups,this.editMode.Value());
    this.formObj.calculation=this.allCalculations;
    this.formObj.action=this.allActions;
    return this.formObj;
  }

  function getGroups(_groups,editMode){
    var check;
    var groups=[];
    for (var i=0; i<_groups.length;i++){
      groups[i]={};
      for (var el in _groups[i]){
        if (el!='visible')
          groups[i][el]=_groups[i][el];
      }
      if (editMode){
        check=portletObj['check_group_'+i+'_state'];
        groups[i].visibility=check=='extended'?'extMask':check=='hidden'?'hiddenInVariant':'base';
      }
    }
    return groups;
  }

  function getFieldFromEditMode(fields,nCols){
    if (portletObj.editMode.Value())
      nCols=1;
    else
      nCols=nCols||portletObj.numColumns;
    var col=0,count=0;
    var check=null,result=[];
    for (var i=0; i<fields.length;i++){
      if (portletObj.editMode.Value() && (!fields[i].hiddenGroup)){
        if (!fields[i].keepOnPreviousRow){
          col=count%nCols; // sistemare numero colonne
          count++;
        }
        if (fields[i].hiddenInVariant)
          col=0;
        if (col==0 && !fields[i].keepOnPreviousRow){
          check=portletObj['check_'+portletObj.currentCheck+'_state'];
          portletObj.currentCheck++;
        }
        fields[i].hiddenInVariant=(check=='hidden');
        fields[i].extMask=(check=='extended');
      }
      var id = Strtran(fields[i].realFieldName," ","");
      if (Empty(id))
        id = Strtran(fields[i].fieldName," ","");
      if (portletObj['fld_'+id] && portletObj['fld_'+id].changed){
        if (!fields[i].calculateInitialValue)
          fields[i].initialValue=convertToString(portletObj['fld_'+id].Value(),portletObj['fld_'+id].type)
      }
      if (portletObj.zoomMode.Value() || portletObj.detailFilterMode.Value()){
        fields[i].initialOperation=portletObj['selectFilterType_'+id]?portletObj['selectFilterType_'+id].Value():fields[i].initialOperation;
      }
      var obj={}
      for (var el in fields[i]){
        if (el!='fixed' && el!='userFilter')
          obj[el]=fields[i][el];
      }
      result.push(obj)
    }
    return result;
  }

  this.SetConfigurationField=function(fields){
    this.vzmFields=fields;
    this.valueVzmFields="";
    this.labelVzmFields="";
    var sep="";
    for (var el in fields){
      if (!fields[el].hidden){
        this.valueVzmFields+=sep+Lower(el);
        this.labelVzmFields+=sep+fields[el].title;
        sep=",";
      }
    }
  }
  if (this.m_cDecoration.Value()!='none'){
    if ( document.addEventListener ) {
      document.addEventListener("keydown", this.DoOnKeyDown, false);
    } else {
      document.attachEvent("onkeydown", this.DoOnKeyDown);
    }
    window.SendData=function(action) {
      switch(action) {
        case 'save':
        case 'confirm':
          portletObj.btn_confirm_Click();
        break;
        case 'discard':
        case 'moveto':
          portletObj.btn_discard_Click();
      }
    }
  }
  else {
    if ( document.addEventListener ) {
      document.addEventListener("keydown", this.DoOnKeyDown2, false);
    } else {
      document.attachEvent("onkeydown", this.DoOnKeyDown2);
    }
  }


  function convertToString(value,type){
    var result;
    switch (type){
      case 'D':
        result=String(FormatDate(value,'YYYY-MM-DD'));
        break;
      case 'T':
        result=String(FormatDateTime(value,'YYYY-MM-DD hh:mm:ss'));
        break;
      default:
        result=String(value);
        break;
    }
    return result;
  }

  function isNextInKOPR(fields,index){ // per vedere se c'� un campo in Keep On Previous Row
    var keepOnPrevRow=false, id, lbl;
    for (var i=index; i<fields.length; i++){
      keepOnPrevRow=fields[i].keepOnPreviousRow;
      id = Strtran(fields[i].realFieldName||fields[i].fieldName," ","");
      lbl = Ctrl(portletObj.formid+'_label_'+id)||Ctrl(portletObj.formid+'_lbl_'+id);
      if (!(fields[i].hiddenGroup || fields[i].hiddenInVariant || fields[i].itemType=='button' || lbl.parentNode.style.visibility=='hidden'))
        return keepOnPrevRow;
    }
    return false;
  }

  this.getObjectPosition=function(){
    var top=0,nCols,count,col,
    grouptbl,nGroup=0,visibleGroup=false,insertGroup=false,
    fontLabel,fontLabelSize,fontField,fontFieldSize,
    id,label,field,fieldValue,field_wrapper,filterType,
    viewMode,marginBottom=4,tmpObj=[],objectPosition=[],
    listFields=this.listField,isCheckbox;
    if (this.zoomMode.Value())
      listFields=listFields.concat({fields:this.tempFields,visible:true});
    for (var i=0; i<listFields.length; i++){
      visibleGroup=false;
      insertGroup=false;
      tmpObj=[];
      nCols=(Empty(listFields[i].groupId)?this.numColumns:this.allGroups[nGroup].columns)||1;
      count=0;
      if (!Empty(listFields[i].groupId)){
        if (this.allGroups[nGroup].visible && Ctrl(this.formid+'_parameter_groups_'+nGroup+'_DIV').style.display!='none' && Ctrl(this.formid+'_parameter_groups_'+nGroup+'_filters').style.display!='none'){
          visibleGroup=true;
          if (!Empty(this.allGroups[nGroup].groupSetName)){
            grouptbl=Ctrl(this['tabs_'+this.allGroups[nGroup].groupSetName].GetTabstripID("parameter_groups_"+nGroup));
          }
          else {
            grouptbl=Ctrl(this.formid+'_parameter_groups_'+nGroup+'_HEADER_CAPTION');
          }
          tmpObj.push({
            type:'group',
            x:50,
            y:top,
            w:grouptbl?grouptbl.offsetWidth:300,
            h:20,
            value:listFields[i].groupName,
            align:'left'
          })
          top+=tmpObj[0].h+marginBottom;
        }
        nGroup++;
      }
      if (Empty(listFields[i].groupId) || visibleGroup){
        for (var j=0; j<listFields[i].fields.length; j++){
          if (!listFields[i].fields[j].keepOnPreviousRow)
            count++;
          col=(count)%nCols;
          if (!(listFields[i].fields[j].hiddenGroup || listFields[i].fields[j].hiddenInVariant) && listFields[i].fields[j].itemType!='button'){ //campo o label visibile
            id = Strtran(listFields[i].fields[j].realFieldName," ","");
            if (Empty(id))
              id = Strtran(listFields[i].fields[j].fieldName," ","");
            label=Ctrl(portletObj.formid+'_label_'+id)||Ctrl(portletObj.formid+'_lbl_'+id);
            if (label.parentNode.style.visibility!='hidden'){ // campo non nascosto da hide under cond
              isCheckbox=(listFields[i].fields[j].type=='L' || listFields[i].fields[j].viewType=='check');
              field=Ctrl(portletObj.formid+'_fld_'+id)||label;
              if (isCheckbox)
                fieldValue=WtH(field.checked,'L')
              else if (listFields[i].fields[j].viewType=='' || listFields[i].fields[j].viewType=='link' || listFields[i].fields[j].viewType=='linkedUsing' || listFields[i].fields[j].viewType=='password'  || listFields[i].fields[j].viewType=='radio')
                fieldValue=this['fld_'+id]?this['fld_'+id].Value():'';
              else {
                if (field.selectedIndex==-1)
                  fieldValue='';
                else fieldValue=FromHTML(field.options[field.selectedIndex].innerText||field.options[field.selectedIndex].textContent);
              }
              if (listFields[i].fields[j].viewType=='' || listFields[i].fields[j].viewType=='link' || listFields[i].fields[j].viewType=='linkedUsing'){
                fieldValue=WtH(fieldValue,this['fld_'+id]?this['fld_'+id].type:'C')
              }
              field_wrapper=Ctrl(portletObj.formid+'_fld_'+id+'_wrp');
              if (!field_wrapper)
                field_wrapper=field;
              if (!fontLabel){
                fontLabel=Strtran(LibJavascript.DOM.getComputedStyle(label,'font-family').split('/([^"]+)|("(?:[^"\\]|\\.)+")/g')[0],',','') //split ' ' but not between " "
                fontField=Strtran(LibJavascript.DOM.getComputedStyle(field,'font-family').split('/([^"]+)|("(?:[^"\\]|\\.)+")/g')[0],',','') //split ' ' but not between " "
                fontLabelSize=LibJavascript.DOM.getComputedStyle(label,'font-size')
                fontFieldSize=LibJavascript.DOM.getComputedStyle(field,'font-size')
              }
              if (Empty(listFields[i].groupId))
                viewMode=this.viewMode;
              else
                viewMode=this.allGroups[nGroup-1].mode;
              if (this.formObj.cover==1 || (((!Empty(fieldValue)) || listFields[i].fields[j].cover==1) && listFields[i].fields[j].cover!=2) ){ //da aggiungere alla copertina
                insertGroup=true;
                if (viewMode!=1){
                  tmpObj.push({
                    type:'label',
                    x:label.offsetLeft,
                    y:top,
                    w:label.offsetWidth+(isCheckbox?5:0),
                    h:label.offsetHeight,
                    value:this['label_'+id]?FromHTML(this['label_'+id].Value()):FromHTML(this['lbl_'+id].Value()),
                    align:isCheckbox?'left':LibJavascript.DOM.getComputedStyle(label,'textAlign'),
                    font:fontLabel,
                    fontSize:fontLabelSize
                  })
                  if (this['filterType_'+id]){
                    filterType=this['filterType_'+id].Ctrl
                    tmpObj.push({
                      type:'label',
                      x:filterType.offsetLeft,
                      y:top,
                      w:filterType.offsetWidth,
                      h:filterType.offsetHeight,
                      value:FromHTML(this['filterType_'+id].Value()),
                      align:LibJavascript.DOM.getComputedStyle(filterType,'textAlign'),
                      font:fontLabel,
                      fontSize:fontLabelSize
                    })
                  }
                  tmpObj.push({
                    type:isCheckbox?'check':'text',
                    x:field_wrapper.offsetLeft,
                    y:top+marginBottom+label.offsetHeight,
                    w:field.offsetWidth,
                    h:field.offsetHeight,
                    value:fieldValue,align:LibJavascript.DOM.getComputedStyle(field,'textAlign'),
                    font:fontField,
                    fontSize:fontFieldSize
                  })
                  if (j==listFields[i].fields.length-1 || (col==0 && !isNextInKOPR(listFields[i].fields,j+1)))
                    top+=label.offsetHeight+field.offsetHeight+2*marginBottom;
                }
                else {
                  tmpObj.push({
                    type:'label',
                    x:label.offsetLeft,
                    y:top,
                    w:label.offsetWidth+(isCheckbox?5:0),
                    h:label.offsetHeight,
                    value:this['label_'+id]?FromHTML(this['label_'+id].Value()):FromHTML(this['lbl_'+id].Value()),
                    align:isCheckbox?'left':LibJavascript.DOM.getComputedStyle(label,'textAlign'),
                    font:fontLabel,
                    fontSize:fontLabelSize
                  })
                  if (this['filterType_'+id]){
                    filterType=this['filterType_'+id].Ctrl
                    tmpObj.push({
                      type:'label',
                      x:filterType.offsetLeft,
                      y:top,
                      w:filterType.offsetWidth,
                      h:filterType.offsetHeight,
                      value:FromHTML(this['filterType_'+id].Value()),
                      align:LibJavascript.DOM.getComputedStyle(filterType,'textAlign'),
                      font:fontLabel,
                      fontSize:fontLabelSize
                    })
                  }
                  tmpObj.push({
                    type:isCheckbox?'check':'text',
                    x:(field_wrapper==field && portletObj.isMobile?field_wrapper.parentNode.offsetLeft:field_wrapper.offsetLeft),
                    y:top,
                    w:field.offsetWidth,
                    h:field.offsetHeight,
                    value:fieldValue,
                    align:LibJavascript.DOM.getComputedStyle(field,'textAlign'),
                    font:fontField,
                    fontSize:fontFieldSize
                  });
                }
              }
              if (j==listFields[i].fields.length-1 || (col==0 && !isNextInKOPR(listFields[i].fields,j+1)))
                top+=Max(label.offsetHeight,field.offsetHeight)+marginBottom;
            }
          }
        }
        if (insertGroup){
          tmpObj[0].font=fontLabel; // se il primo oggetto � un gruppo
          tmpObj[0].fontSize=fontLabelSize;
          objectPosition=objectPosition.concat(tmpObj)
        }
        else if (!Empty(listFields[i].groupId))
          top=top-tmpObj[0].h-marginBottom; // tolgo l'altezza del gruppo che avevo aggiunto
      }
    }
    return objectPosition;
  }

  this.checkSplinker_Error=function(cCause){
    this.validateError=cCause
  }
  if (!window.ToggleCollapsibleBox){
    window.ToggleCollapsibleBox=function(boxId){
      window[boxId+'_filters_toggle_Click'](boxId);
    }
  }
}
