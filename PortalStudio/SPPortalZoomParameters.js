/* global PrepareJsCalendar LaunchCalendar */
var filtersString='',tempFilterHtmlString='',tempFilterScriptString='';

var parameters_main_div=document.createElement('DIV');
parameters_main_div.id=this.formid+'_parameters_main';
parameters_main_div.style.position='relative';
document.getElementById(this.formid).appendChild(parameters_main_div);
if (!('m_IDS' in window)) window.m_IDS={};

this.DrawPortlet=function(){
  this.offsetLeft=0;
  this.htmlCode='';
  this.htmlCode_MainTable='';
  this.scriptCode='';
  this.parametersRowHeight=0;
  this.parametersDivHeight=0;
  this.fixedFiltersCount=0;
  this.tempFiltersCount=0;
  this.tempFiltersNum=0;
  this.tempFiltersFieldTypesString='';
  this.allFilters=[];
  this.tempFilters=[];

  var url = new ZtVWeb.JSURL('../servlet/SPVZMFilters?PortletID='+this.Ctrl.id+'&Table='+this.Table.Value()+'&ConfigName='+this.ConfigName.Value()+'&VQRName='+this.VQRName.Value()+
                        '&ViewMode='+(Empty(this.Mode.Value())?(SPTheme.portalZoomParamDefaultViewMode?SPTheme.portalZoomParamDefaultViewMode:""):this.Mode.Value())+
                        '&ReadFieldNewLine='+(Empty(this.ReadFieldNewLine.Value())?(SPTheme.portalZoomParamReadFieldNewLine?SPTheme.portalZoomParamReadFieldNewLine:"false"):this.ReadFieldNewLine.Value())+
                        '&FormWidth='+(this.Width.Value()==0?this.Ctrl.offsetWidth:this.Width.Value())+
                        '&MaxFieldWidth='+this.MaxFieldWidth.Value()+'&Columns='+this.Columns.Value()+
                        '&AutoZoom='+this.AddAutoZoom.Value()+'&OperationSelect='+this.OperationSelect.Value()+
                        '&EnableEdit='+this.EnableEdit.Value()+'&ResetButton='+this.ResetButton.Value()+'&DynamicFilters='+this.DynamicFilters.Value()+
                        '&UseImages='+this.UseImages.Value()+'&EnablePrint='+!EmptyString(this.ReportName.Value())+
                        '&ToolbarLabels='+this.ToolbarLabels.Value()+'&ToolbarAlign='+this.ToolbarAlign.Value(),true);
  eval(url.Response());

  if(this.cfgBuilder){
    this.cfgBuilder.showSaveBtn.Value(false);
    this.cfgBuilder.btnSave.Hide();
    this.cfgBuilder.lblSaving.Ctrl.style.left=8;
    this.cfgBuilder.lblSaving.Ctrl.style.top=25;
  }
  parameters_main_div.style.height=this.parametersDivHeight+30+'px';
  parameters_main_div.style.top=this.OffsetTop.Value(); //per spostare su o giu
  parameters_main_div.innerHTML=this.htmlCode_MainTable;

  var parameters_filters_div=document.createElement('DIV');
  parameters_filters_div.id=this.formid+'_parameters';
  parameters_filters_div.style.position='relative';
  parameters_filters_div.style.height=this.parametersDivHeight+'px';
  parameters_filters_div.innerHTML=this.htmlCode;

  try{
    document.getElementById(this.formid+"_main").appendChild(parameters_filters_div);
  } catch(e){}

  eval(this.scriptCode);

  this.tempFiltersFieldTypes=this.tempFiltersFieldTypesString.split('|');

  if(this.FilterButtonCaption.Value()!=''){
    this.btn_filter.Ctrl.title=this.FilterButtonCaption.Value();
    if(!this.UseImages.Value()){
      this.btn_filter.Ctrl.value=this.FilterButtonCaption.Value();
    }
    else if(this.ToolbarLabels.Value()){
      this.lbl_filter.Value(this.FilterButtonCaption.Value());
    }
  }
  if(this.FilterAddButtonCaption.Value()!=''){
    this.btn_add.Ctrl.title=this.FilterAddButtonCaption.Value();
    if(!this.UseImages.Value()){
      this.btn_add.Ctrl.value=this.FilterAddButtonCaption.Value();
    }
    else if(this.ToolbarLabels.Value()){
      this.lbl_add.Value(this.FilterAddButtonCaption.Value());
    }
  }
  if(this.FilterRefreshButtonCaption.Value()!=''){
    this.btn_reset.Ctrl.title=this.FilterRefreshButtonCaption.Value();
    if(!this.UseImages.Value()){
      this.btn_reset.Ctrl.value=this.FilterRefreshButtonCaption.Value();
    }
    else if(this.ToolbarLabels.Value()){
      this.lbl_reset.Value(this.FilterRefreshButtonCaption.Value());
    }
  }

  this.SetPortletHeight();
  if(this.Width.Value()==0 && this.Ctrl.offsetWidth==0)
    this.SetPortletWidth();
}

this.SetPortletHeight=function(){
  if(document.getElementById(this.formid+'_main_table').offsetHeight==0)
    window.setTimeout(this.formid+".SetPortletHeight()",50);
  else {
    var h=document.getElementById(this.formid+'_main_table').offsetHeight;
    this.height=h;
    document.getElementById(this.formid).style.height=h+"px";
    try {
      ZtVWeb.ResizeIframe();
    }catch(e){}
  }
}
this.SetPortletWidth=function(){
  if(this.Ctrl.offsetWidth>0){
    this.DrawPortlet();
    if(this.gridFilters)
      this.UpdateTempFilters(this.gridFilters);
  }
  else
    window.setTimeout(this.formid+".SetPortletWidth()",50);
}

try{
  this.DrawPortlet();
} catch(e){}

var emtName=this.EmitterName.Value();
if(EmptyString(emtName)){
  emtName=this.Table.Value()+'_zoomSetFilter';
}
this.$entity$_zoomSetFilter.name=this.$entity$_zoomSetFilter.name.replace('$entity$_zoomSetFilter',emtName);

var rcvName=this.ReceiverName.Value();
if(EmptyString(rcvName)){
  rcvName=this.Table.Value()+'_updateFilters';
}
this.$entity$_updateFilters.name=this.$entity$_updateFilters.name.replace('$entity$_updateFilters',rcvName);
this['on_'+(this.ReceiverName.Value() || this.Table.Value())+"_updateFilters"]=function(parmsObj){
  this.$entity$_updateFilters.receiveFnc(parmsObj);
};
this.$entity$_updateConfiguration.name=this.$entity$_updateConfiguration.name.replace('$entity$',rcvName);
this['on_'+(this.ReceiverName.Value() || this.Table.Value())+"_updateConfiguration"]=function(parmsObj){
  this.$entity$_updateConfiguration.receiveFnc(parmsObj);
};

this.gridFilters;
this.hideFilters=[];
this.UpdateTempFilters=function(filters){
  this.hideFilters=[];
  this.gridFilters=LibJavascript.Array.filter(filters,function(f){ return !f.fixed; });
  this.ClearTempFilters();
  for(var i=0;i<filters.length;i++){
    if(!filters[i].fixed){
      if(filters[i].visible)
        this.addFilter(filters[i]);
      else
        this.hideFilters.push(filters[i]);
    }
  }
  this.SetPortletHeight();
}

this.DoOnKeyDown=function(e){
  e = e ? e : window.event;
  var keyCode = GetKeyCode(e);
  if(keyCode==13){
    if(GetEventSrcElement(e).type=='text'){
      this.btn_filter_Click();
      e.cancelBubble=true;
      e.returnValue=false;
    }
  }
}
this.OpenCalendar=function(id){
  PrepareJsCalendar(false);
  LaunchCalendar(id);
}

this.lbl_filter_Click=function(){
  this.btn_filter_Click();
}
this.btn_filter_Click=function(){
//  this.SetInitialValue();
  this.$entity$_zoomSetFilter.Emit();
}

this.lbl_print_Click=function(){
  this.btn_print_Click();
}
this.btn_print_Click=function(){
  var height=600;
  var width=800;
  var left=(screen.width)?(screen.width-width)/2:100;
  var top=(screen.height)?(screen.height-height-(height/4))/2:100;
  if (IsNetscape() || IsMozilla()) {
    width+=5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
    height+=4;
  }
  window.open("../servlet/Report?ReportName="+this.ReportName.Value()+
                  (EmptyString(this.PrintFormat.Value())?"":"&outputFormat="+this.PrintFormat.Value())+
                  (EmptyString(this.PrintOrientation.Value())?"":"&rotation="+this.PrintOrientation.Value())+
                  "&m_cVZMParamBlock="+URLenc(this.GetParamBlock()),"print","height="+height+",width="+width+",left="+left+",top="+top+",resizable=yes,scrollbars=yes");
}

this.lbl_reset_Click=function(){
  this.btn_reset_Click();
}
this.btn_reset_Click=function(){
  this.DrawPortlet();
  this.btn_filter_Click();
}

this.lbl_save_Click=function(){
  this.btn_save_Click();
}
this.btn_save_Click=function(){
  this.cfgBuilder.Save();
}

this.lbl_add_Click=function(){
  this.btn_add_Click();
}
this.addFilter=function(filter){
  var temp_parameters_table=document.getElementById(this.formid+"_temp");
  if(this.tempFiltersNum==0){
    var temp_parameters_sep=document.createElement('HR');
    temp_parameters_sep.id=this.formid+'_temp_sep';
    var temp_parameters_table_td=document.getElementById(this.formid+"_temp_td");
    temp_parameters_table_td.insertBefore(temp_parameters_sep,temp_parameters_table);
  }
  var temp_parameters_row=temp_parameters_table.insertRow(temp_parameters_table.rows.length);
  temp_parameters_row.id='temp_parameters_'+this.tempFiltersCount;
  var temp_parameters_cell=temp_parameters_row.insertCell(0);
  temp_parameters_cell.innerHTML=Strtran(tempFilterHtmlString,'##INDEX##',this.tempFiltersCount);
  eval(Strtran(tempFilterScriptString,'##INDEX##',this.tempFiltersCount));

  if(filter){
    this.tempFilters[this.tempFiltersCount]=[filter.field,filter.operator,'','','','','','','','','','','','','','','','','','','','','','','','',''];
    this['combobox_temp_fields_'+this.tempFiltersCount].Value(filter.field.toUpperCase());
    this['combobox_temp_operations_'+this.tempFiltersCount].Value(filter.operator);
    this['fld_temp_'+this.tempFiltersCount].Value(filter.expression);
  }
  else {
    this.tempFilters[this.tempFiltersCount]=['','','','','','','','','','','','','','','','','','','','','','','','','','',''];
    this.SetPortletHeight();
  }
  this.tempFiltersCount++;
  this.tempFiltersNum++;
}

this.btn_add_Click=function(/*evt*/){
  this.addFilter();
}

this.btn_edit_Click=function(ctrl,idx,temp){
  var cp_type='';
  if(temp && Empty(this['combobox_temp_fields_'+idx].Value())){
    alert("Select a field for the filter.");
  }
  else {
    var height=490;
    var width=480;
    var windowLeft=(screen.width)?(screen.width-width)/2:100;
    var windowTop=(screen.height)?(screen.height-height-(height/4))/2:100;
    if (IsNetscape() || IsMozilla()) {
      width+=5; //Per Netscape e Mozilla, il width e height sono leggermente diversi
      height+=4;
    }
    if(temp)
      cp_type='&type='+this.tempFiltersFieldTypes[this['combobox_temp_fields_'+idx].Ctrl.selectedIndex-1];
    window.open("../SPPortalZoomParameters_FilterProps.htm?formid="+this.formid+"&action=edit&temp="+temp+"&idx="+idx+cp_type, "field", "height="+height+",width="+width+",left="+windowLeft+",top="+windowTop);
  }
}
this.btn_delete_Click=function(idx,isTemp){
  if(isTemp){
    var temp_parameters_table=document.getElementById(this.formid+"_temp");
    var j=document.getElementById('temp_parameters_'+idx).rowIndex;
    this['combobox_temp_fields_'+idx]=null;
    temp_parameters_table.deleteRow(j);
    this.tempFilters[idx]=null;
    this.tempFiltersNum--;
    if(this.tempFiltersNum==0){ //non ci sono + filtri temp
      var temp_parameters_table_td=document.getElementById(this.formid+"_temp_td");
      temp_parameters_table_td.removeChild(document.getElementById(this.formid+"_temp_sep"));
    }
    this.SetPortletHeight();
  }
  else { //imposto che il filtro non deve essere salvato
    if(!this.allFilters[idx][27]){
      this["lbl_"+this.allFilters[idx][0]+idx].Ctrl.style.fontStyle='italic';
      this["lbl_"+this.allFilters[idx][0]+idx].Ctrl.style.textDecoration='line-through';
      LibJavascript.CssClassNameUtils.replaceClass(this["delete_btn_"+this.allFilters[idx][0]+idx].Ctrl,'PortalZoomParams_DeleteFilter','PortalZoomParams_UnDeleteFilter');
      this.allFilters[idx][27]=true;
    }
    else {
      this["lbl_"+this.allFilters[idx][0]+idx].Ctrl.style.fontStyle='';
      this["lbl_"+this.allFilters[idx][0]+idx].Ctrl.style.textDecoration='';
      LibJavascript.CssClassNameUtils.replaceClass(this["delete_btn_"+this.allFilters[idx][0]+idx].Ctrl,'PortalZoomParams_UnDeleteFilter','PortalZoomParams_DeleteFilter');
      this.allFilters[idx][27]=false;
    }
  }
}

this.ClearTempFilters=function(){
  if(this.tempFiltersNum>0){
    var temp_parameters_table=document.getElementById(this.formid+"_temp");
    var temp_parameters_table_td=document.getElementById(this.formid+"_temp_td");

    while(temp_parameters_table.rows.length>0) {
      temp_parameters_table.deleteRow(0);
    }
    temp_parameters_table_td.removeChild(document.getElementById(this.formid+"_temp_sep"));

    //this.tempFilters=new Array();
    for(var i=0;i<this.tempFilters.length;i++){
      this.tempFilters[i]=null;
    }
    this.tempFiltersNum=0;
  }
}
this.SetConfiguration=function(evt){
  this.ConfigName.Value(evt.Config.ConfigName);
  this.Custom = evt.Config.Custom;
  this.User = evt.Config.User;
  this.Group = evt.Config.Group;
  if (evt.reload) this.DrawPortlet();
}
this.advanced_filters_toggle_Click=function(){
  if(document.getElementById(this.Ctrl.id+'_advanced_filters').style.display=='none'){
    document.getElementById(this.formid+'_main').style.height=document.getElementById(this.formid+'_main').offsetHeight+this.parametersAdvDivHeight+'px';
    try{
      document.getElementById(this.formid+'_parameter_groups_0').style.top=document.getElementById(this.formid+'_parameter_groups_0').offsetTop+this.parametersAdvDivHeight;
    }catch(e){}
    document.getElementById(this.Ctrl.id+'_advanced_filters').style.display='block';
    LibJavascript.CssClassNameUtils.replaceClass(document.getElementById(this.Ctrl.id+'_advanced_filters_toggle'),'PortalZoomParams_Group_Collapsed','PortalZoomParams_Group_Expanded');
    LibJavascript.CssClassNameUtils.replaceClass(document.getElementById(this.Ctrl.id+'_advanced_filters_togglehref'),'PortalZoomParams_Group_Collapsed','PortalZoomParams_Group_Expanded');
  }
  else {
    document.getElementById(this.formid+'_main').style.height=document.getElementById(this.formid+'_main').offsetHeight-this.parametersAdvDivHeight+'px';
    try{
      document.getElementById(this.formid+'_parameter_groups_0').style.top=document.getElementById(this.formid+'_parameter_groups_0').offsetTop-this.parametersAdvDivHeight;
    }catch(e){}
    document.getElementById(this.Ctrl.id+'_advanced_filters').style.display='none';
    LibJavascript.CssClassNameUtils.replaceClass(document.getElementById(this.Ctrl.id+'_advanced_filters_toggle'),'PortalZoomParams_Group_Expanded','PortalZoomParams_Group_Collapsed');
    LibJavascript.CssClassNameUtils.replaceClass(document.getElementById(this.Ctrl.id+'_advanced_filters_togglehref'),'PortalZoomParams_Group_Expanded','PortalZoomParams_Group_Collapsed');
  }
  this.SetPortletHeight();
}

this.GetFilters=function(){
  var j, filters, field_name, field_op, field_visible, filter;
  eval('filters={'+filtersString+'};');
  //I filtri dinamici
  var fields=this.fields.split(",");
  for(var i=0; i<this.tempFiltersCount; i++){
    if(this['combobox_temp_fields_'+i]!=null && this.tempFilters[i]!=null){
      var find=false;
      field_name=this["combobox_temp_fields_"+i].Value();
      for(j=0;j<fields.length;j++){
        if(fields[j].toUpperCase()==field_name.toUpperCase()) {
          find=true;
          break;
        }
      }
      if (find) {
        field_op=field_name+'_op';
        field_visible=field_name+'_visible';
        filter={};
        filter[field_name]=this["fld_temp_"+i].Value();
        filter[field_op]=this["combobox_temp_operations_"+i].Value();
        filter[field_visible]=true;
        filters[i+this.fixedFiltersCount]=filter;
      }
    }
  }
  for (j=0; j<this.hideFilters.length;j++) {
    field_name=this.hideFilters[j].field;
    field_op=field_name+'_op';
    field_visible=field_name+'_visible';
    filter={};
    var field_type=field_name+'_type';
    filter[field_name]=this.hideFilters[j].expression;
    filter[field_op]=this.hideFilters[j].operator;
    filter[field_type]=this.hideFilters[j].type;
    filter[field_visible]=false;
    filters[i+this.fixedFiltersCount+j]=filter;
  }
  filters['removeFixed']=true;
  return filters;
}

this.GetParamBlock=function(){
  var result = [], filterType = "", i;
  for(i=0;i<this.allFilters.length;i++){
    if(this.allFilters[i]!=null && !this.allFilters[i][27]){
      result.push({filter_field: this.allFilters[i][0],
                      filter_type: this.allFilters[i][3],
                      filter_value: this.GetFilterValue(i,false,this.allFilters[i][3]),
                      query_param: this.allFilters[i][21],
                      filter_operation: this.GetFilterOperation(i,false)});
    }
  }
  for(i=0; i<this.tempFilters.length; i++){
    if(this.tempFilters[i]!=null && this["combobox_temp_fields_"+i].Value()!=""){
      filterType = this.GetTempFilterType(i);
      result.push({filter_field: this["combobox_temp_fields_"+i].Value(),
                      filter_type: filterType,
                      filter_value: this.GetFilterValue(i,true,filterType),
                      query_param: this.tempFilters[i][21],
                      filter_operation: this.GetFilterOperation(i,true)});
    }
  }
  return JSON.stringify(result);
}
this.GetFilter=function(idx,temp){
  if(temp)
    return(this.tempFilters[idx]);
  else
    return(this.allFilters[idx]);
}
this.GetFilterOperation=function(idx,temp){
  if(temp)
    return this["combobox_temp_operations_"+idx].Value();
  else
    return this.OperationSelect.Value() ? this["combobox_"+this.allFilters[idx][0]+idx].Value() : this.allFilters[idx][1];
}
this.GetFilterValue=function(idx,temp,filterType){
  var filterValue;
  if(temp)
    filterValue = this["fld_temp_"+idx].Value()==null ? '' : this["fld_temp_"+idx].Value();
  else {
    if(this.allFilters[idx][24]==''){
      filterValue = this["fld_"+this.allFilters[idx][0]+idx].Ctrl_input.value==null ? '' : this["fld_"+this.allFilters[idx][0]+idx].Ctrl_input.value;
    }else{
      filterValue = this["fld_"+this.allFilters[idx][0]+idx].Ctrl.value==null ? '' : this["fld_"+this.allFilters[idx][0]+idx].Ctrl.value;
    }
  }

  if (filterType) {
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
  }
 return filterValue;
}
this.GetTempFilterType=function(idx){
  if(EmptyString(LRTrim(this.tempFilters[idx][3]))) {
    var type = this.tempFiltersFieldTypes[this["combobox_temp_fields_"+idx].Ctrl.selectedIndex-1];
    var pos = type.indexOf("(");
    if (pos > -1) {
      return type.substring(0,pos);
    } else {
      return type;
    }
  }
  else
    return this.tempFilters[idx][3];
}

this.GetDataSave=function(conf){
  var jsonFilters=[];
  var i;
  for(i=0;i<this.allFilters.length;i++){
    if(this.allFilters[i]!=null && this.allFilters[i][27]){
      this.AdaptSequence(999,this.allFilters[i][26]);
    }
  }

  for(i=0;i<this.allFilters.length;i++){
    if(this.allFilters[i]!=null && !this.allFilters[i][27]){
      this.allFilters[i][1]=this.GetFilterOperation(i,false);
      if(this.allFilters[i][3]=='N' && this.allFilters[i][25]==0){
        this.allFilters[i][25]='';
      }
      jsonFilters[jsonFilters.length]=this.allFilters[i];
    }
  }
  for(i=0; i<this.tempFilters.length; i++){
    if(this.tempFilters[i]!=null && this["combobox_temp_fields_"+i].Value()!=""){
      this.tempFilters[i][0]=this["combobox_temp_fields_"+i].Value();
      this.tempFilters[i][1]=this["combobox_temp_operations_"+i].Value();
      this.tempFilters[i][26]=jsonFilters.length+1;
      jsonFilters.push(this.tempFilters[i]);
    }
  }
  conf.Filters=jsonFilters;
  conf.ConfigName = this.ConfigName.Value();
  conf.Custom = this.Custom;
  conf.User = this.User;
  conf.Group = this.Group;
}

this.AdaptSequence=function(sequenceNew,sequenceOld){
  var i=0;
  while(i<this.allFilters.length){
    //Filtro spostato in avanti
    if(this.allFilters[i][26]>=sequenceOld && this.allFilters[i][26]<=sequenceNew){
      this.allFilters[i][26]=this.allFilters[i][26]-1;
    }
    //Filtro spostato indietro
    else if(this.allFilters[i][26]>=sequenceNew && this.allFilters[i][26]<=sequenceOld){
      this.allFilters[i][26]=this.allFilters[i][26]+1;
    }
    i++;
  }
  return sequenceNew;
}

this.SetOperation=function(index){
  if (this.fields.indexOf(this["combobox_temp_fields_"+index].Value())==-1) {
    this["combobox_temp_operations_"+index].Disabled();
    this["combobox_temp_operations_"+index].Value("=");
  } else {
    this["combobox_temp_operations_"+index].Enabled();
  }
}
//funzione globale
var oldReportLinkValue=window.ReportLinkValue;
window.ReportLinkValue=function(varName,value){
  try {
    document.getElementById(varName).value=value;
    window[Left(varName,5)]["zoom_report_"+varName](value);
    return true;
  }
  catch(e){}
  if (oldReportLinkValue) {
    return oldReportLinkValue(varName,value);
  }
  return false;
}

this.SetInitialValue=function(){
  for(var i=0;i<this.allFilters.length;i++){
    var filterValue = this.GetFilterValue(i,false);
    if (EmptyString(filterValue) && !EmptyString(this.allFilters[i][25])){
      if(this.allFilters[i][24]==''){
        this["fld_"+this.allFilters[i][0]+i].Ctrl_input.value=this.allFilters[i][25];
      }else{
        return this["fld_"+this.allFilters[i][0]+i].Ctrl.value=this.allFilters[i][25];
      }
    }
  }
}
