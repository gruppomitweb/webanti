/* exported
    portletId FillList selectTab confirmSelection addRow requestField getAllField
    getAllFieldDescription requestTableField loadFieldName
*/
var CSV_SEP="#!$";
var iPrec=-1;
var allParameters=[], fieldTableName=[], fieldTableDescription=[], visibleParameters=[];
var portletId,action,tableName,parameter,queryName,allField,allFieldDescription,linkedField,offlinemode;
var parameterSelected=[], valueParameter=[];
var parSelected=-1, keyboard, nRow=0;
var tabSelected="name", oldFilter="";

function getOpener(){
  return (window.opener?window.opener:window.parent)
}

function SelectThisParameter(){
  var i, sep, value;
  if (action=='fixedcombo' || action=='readfield'){
    var valueField1='',valueField2='';
    sep='';
    var field1=action=='readfield'?'fieldName':'name'
    var field2=action=='readfield'?'linkedField':'desc'
    for (i=0; i<nRow; i++){
      if (Ctrl("input_"+field1+i)){
        if (Ctrl("input_"+field1+i).style.display!='none'){
          valueField1+=sep+Strtran(Ctrl("input_"+field1+i).value,',','|')
          valueField2+=sep+Strtran(Ctrl("input_"+field2+i).value,',','|')
        }
        else {
          valueField1+=sep+Strtran((Ctrl(field1+i).innerText||Ctrl(field1+i).textContent),',','|')
          valueField2+=sep+Strtran((Ctrl(field2+i).innerText||Ctrl(field2+i).textContent),',','|')
        }
        sep=',';
      }
    }
    getOpener().loadValue(Ctrl('action').value,valueField1,valueField2);
    closeWindow()
  }
  else if (action=='parameters'){
    value="";
    sep='';
    for (i=0; i<nRow; i++){
      if (Ctrl("input_parameterName"+i)){
        if (Ctrl("input_parameterName"+i).style.display!='none'){
          value+=sep+Ctrl("input_parameterName"+i).value+"="+Ctrl("input_parameterValue"+i).value
        }
        else {
          value+=sep+(Ctrl("parameterName"+i).innerText||Ctrl("parameterName"+i).textContent)+"="+(Ctrl("parameterValue"+i).innerText||Ctrl("parameterValue"+i).textContent)
        }
        sep='&';
      }
    }
    getOpener().loadValue(Ctrl('action').value,value);
    closeWindow()
  }
  else {
    value = Ctrl("result").value;
    if (action=='readfield' || action=='fixedfilter' || action=='filterfield'){
      //controllo che tutti i campi della tabella corrispondano ad un campo della configurazione
      var emptyParameter=false;
      for (i=0; i<valueParameter.length && !emptyParameter; i++){
        if (valueParameter[i]=='')
          emptyParameter=true;
      }
      if (emptyParameter)
        alert('Error: \nNot all the selected table fields were associated with a configuration field');
      else{
        getOpener().loadValue(Ctrl('action').value,parameterSelected,valueParameter);
        closeWindow()
      }
    }
    else{
      getOpener().loadValue(Ctrl('action').value,value);
      closeWindow()
    }
  }
}

function SimpleFilter(){
  var _filter=Lower(Ctrl('search').value);
  if (_filter.length>2 || _filter.length==0 && _filter!=oldFilter){
    var innerHtml="";
    var idx=0;
    visibleParameters=[];
    for (var i=0; i<allParameters.length; i++){
      if (Lower(allParameters[i]).indexOf(_filter)!=-1){
        visibleParameters.push(allParameters[i]);
        innerHtml+="<li><p class='standardRow right' id='name"+idx+"' ondblclick='SelectThisParameter()' onclick='selectRow("+idx+")'>"+allParameters[i]+"</p></li>";
        idx++;
      }
    }
    Ctrl('tableContent').innerHTML=innerHtml;
    document.id('content').nanoScrollerMT();
    iPrec=-1;
    oldFilter=_filter;
  }
}

function DoubleFilter(){
  var _filter=Lower(Ctrl('search').value);
  if (_filter.length>2 || _filter.length==0 && _filter!=oldFilter){
    var innerHtml="";
    var idx=0;
    visibleParameters=[];
    var j=tabSelected=='name'?0:1;
    for (var i=0; i<allParameters.length; i++){
      if (Lower(allParameters[i][j]).indexOf(_filter)!=-1){
        visibleParameters.push(allParameters[i]);
        innerHtml+="<li><p class='standardRow' id='name"+idx+"'  ondblclick='SelectThisParameter()' onclick='selectRow("+idx+")'>"+allParameters[i][0]+"</p><p class='standardRow right' id='desc"+idx+"' ondblclick='SelectThisParameter()' onclick='selectRow("+idx+")'>"+allParameters[i][1]+"</p></li>";
        idx++;
      }
    }
    Ctrl('tableContent').innerHTML=innerHtml;
    document.id('content').nanoScrollerMT();
    iPrec=-1;
    oldFilter=_filter;
  }
}

function selectTab(el){
  if (tabSelected=='name'){
    tabSelected='description';
    el.className='tab tabSelected';
    Ctrl('tabName').className='tab';
  }
  else{
    tabSelected='name';
    el.className='tab tabSelected';
    Ctrl('tabDescription').className='tab';
  }
  DoubleFilter();
}

function closeWindow(){
  if (getOpener().closeSPModalLayer && !Empty(Ctrl('SPModalLayerId').value))
    getOpener().closeSPModalLayer();
  else window.close()
}

function FillList(){
  var i, posPoint;
  portletId=Ctrl("portletId").value;
  action=Lower(Ctrl('action').value);
  tableName=Ctrl('tableName').value;
  offlinemode=(Ctrl('offlinemode').value=='true');
  if (tableName){
    posPoint=tableName.indexOf('.');
    if (posPoint!=-1)
      tableName=Left(tableName,posPoint)
  }
  parameter=(Ctrl('parameter').value).split(',');
  if (action=='linkedtable' && parameter[0]){
    posPoint=parameter[0].indexOf('.');
    if (posPoint!=-1)
      parameter[0]=Left(parameter[0],posPoint)
  }
  queryName=Ctrl('queryName').value;
  allField=(Ctrl('allField').value);
  allFieldDescription=(Ctrl('allFieldDescription').value);
  linkedField=(Ctrl('linkedField').value).split(',');
  var tableContent=Ctrl('content');
  var title=Ctrl('title');
  var label=Ctrl('name');
  var innerHtml="";
  switch (action){
    case 'linkedtable':
    case 'tablename':
      innerHtml="<ul id='tableContent' onselectstart='return false'>";
      GetTables();
      for (i=0; i<allParameters.length; i++){
        innerHtml+="<li><p class='standardRow' id='name"+i+"'  ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i][0]+"</p><p class='standardRow right' id='desc"+i+"' ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i][1]+"</p></li>";
      }
      title.innerHTML="<div class='columnSx'> Select Table </div>";
      label.innerHTML='Table name:';
      innerHtml+="</ul>";
      Ctrl('search').addEvents({
        'keyup':function(){
          DoubleFilter()
        }
      })
      break;
    case 'fixedfilter':
    case 'filterfield':
      if (!Empty(tableName)){
        innerHtml="<table id='tableContent' width='100%' onselectstart='return false' style='border:1px solid #e3e3e3;'>";
        GetParameters();
        for (i=0; i<allParameters.length; i++){//selezione multipla
          innerHtml+="<tr><td width='20px'><input type='checkbox' name='check"+i+"' onchange='multipleSelectRow("+i+")' /></td><td class='standardRow light' id='name"+i+"' onclick='changeCheck("+i+")'> "+allParameters[i][0]+" ("+allParameters[i][1]+")</td><td class='standardRow right light' width='210px' id='desc"+i+"' ><input type='text' disabled='true' id='input"+i+"' onchange='multipleSelectRow("+i+")'/><input disabled='true' type='button' value='?' id='button"+i+"' onclick='requestField("+i+")' class='disabledButton'/></td></tr>";
        }
        title.innerHTML="<div class='columnSx' > Field name </div><div class='columnDx' style='width:225px;'> Linked field </div> ";
        label.innerHTML='Fields name:';
        innerHtml+="</table>";

      }
      Ctrl('maskSearch').style.display='none';
      break;
    case 'keyfield':
    case 'tablekeyfield':
    case 'valuefield':
    case 'orderfield':
      if (!Empty(tableName) && tableName!='null'){
        innerHtml="<ul id='tableContent' onselectstart='return false'>";
        GetParameters();
        for (i=0; i<allParameters.length; i++){
          innerHtml+="<li><p class='standardRow' id='name"+i+"'  ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i][0]+"</p><p class='standardRow right' id='desc"+i+"' ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i][1]+"</p></li>";
        }
        title.innerHTML="<div class='columnSx' > Select Field </div>";
        label.innerHTML='Field name:';
        innerHtml+="</ul>";
        Ctrl('search').addEvents({
          'keyup':function(){
            DoubleFilter()
          }
        })
        break;
      }
    case 'combovalues':
    case 'combolabels':
    // case 'orderfield':
      if (!Empty(queryName)){
        innerHtml="<ul id='tableContent' onselectstart='return false'>";
        GetQueryFields();
        for (i=0; i<allParameters.length; i++){
          innerHtml+="<li><p width='50%' class='standardRow' id='name"+i+"'  ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i][0]+"</p><p width='50%' class='standardRow right' id='desc"+i+"' ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i][1]+"</p></li>";
        }
        title.innerHTML="<div class='columnSx' > Select Field </div>";
        label.innerHTML='Field name:';
        innerHtml+="</ul>";
      }
      Ctrl('search').addEvents({
        'keyup':function(){
          DoubleFilter()
        }
      })
      break;
    case 'queryname':
      innerHtml="<ul id='tableContent' onselectstart='return false'>";
      GetQuery();
      for (i=0; i<allParameters.length; i++){
        innerHtml+="<li><p class='standardRow right' id='name"+i+"'  ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i]+"</p></li>";
      }
      title.innerHTML="<div class='column' > Select Query </div>";
      label.innerHTML='Query name:';
      innerHtml+="</ul>";
      Ctrl('tabName').style.display='none';
      Ctrl('tabDescription').style.display='none';
      Ctrl('search').addEvents({
        'keyup':function(){
          SimpleFilter()
        }
      })
      break;
    case 'zoomconfigname':
    case 'configname':
    case 'config':
      innerHtml="<ul id='tableContent' onselectstart='return false'>";
      GetZoomConfigName();
      for (i=0; i<allParameters.length; i++){
        innerHtml+="<li><p class='standardRow right' id='name"+i+"'  ondblclick='SelectThisParameter()' onclick='selectRow("+i+")'>"+allParameters[i]+"</p></li>";
      }
      title.innerHTML="<div class='column' > Select Zoom </div>";
      label.innerHTML='Zoom name:';
      innerHtml+="</ul>";
      Ctrl('tabName').style.display='none';
      Ctrl('tabDescription').style.display='none';
      Ctrl('search').addEvents({
        'keyup':function(){
          SimpleFilter()
        }
      })
      break;
    case 'queryparameters':
      if (!Empty(queryName)){
        innerHtml="<table id='tableContent' width='100%' onselectstart='return false'>";
        GetQueryParameters();
        if (allParameters.length>0){
          for (i=0; i<allParameters.length; i++){
            innerHtml+="<tr><td class='standardRow queryPar light' id='name"+i+"'>"+allParameters[i][0]+" ("+allParameters[i][1]+")=</td><td class='standardRow right' width='240px'> <input type='text' id='input"+i+"' onchange='InsertParameter("+i+")' style='width:200px'/><input type='button' value='?' id='button"+i+"' onclick='requestField("+i+")' class='bottoni'/></td>";
          }
           title.innerHTML="<div class='columnSx'>Parameter name </div><div class='columnDx' >Value</div>";
        }
        else innerHtml+="No parameters in the selected query";
        label.innerHTML='Parameters:';
        innerHtml+="</table>";
      }
      Ctrl('maskSearch').style.display='none';
      break;

    case 'dependson':
    case 'zoomqryparam':
      innerHtml="<ul id='tableContent' onselectstart='return false'>";
      allField=allField.split(',');
      allFieldDescription=allFieldDescription.split(',');
      allParameters=[]
      for (i=0; i<allField.length; i++){
        allParameters[i]=[allField[i],allFieldDescription[i]]
      }
      allParameters.sort(SortByName);
      for (i=0; i<allParameters.length; i++){//selezione multipla
        innerHtml+="<li><span style='display:inline-block;'><input type='checkbox' name='check"+i+"' onclick='multipleSelectRow("+i+")' style='display:block; margin-bottom:6px;'/></span><div style='display:inline-block; width:464px;' onclick='changeCheck("+i+")'><p class='standardRow' id='name"+i+"'  width='50%'> "+allParameters[i][0]+"</p><p class='standardRow right' id='desc"+i+"' > "+(allParameters[i][1]||allParameters[i][0])+"</p></div></li>";
      }
      title.innerHTML="<div class='columnSx'> Select fields </div>";
      label.innerHTML='List field:';
      innerHtml+="</ul>";
      Ctrl('maskSearch').style.display='none';
      break;
    case 'fixedcombo':
      innerHtml="<table id='tableContent' width='100%' onselectstart='return false'>";
      if (!Empty(allField)){
        allField=allField.split(',')
        allFieldDescription=allFieldDescription.split(',');
        allParameters=[]
        nRow=allField.length;
        for (i=0; i<allField.length; i++){//selezione multipla
          allParameters[i]=[allField[i],allFieldDescription[i]]
          innerHtml+="<tr style='height:21px;'><td class='standardRow light' onclick='selectRow("+i+")' width='50%' ondblclick='editRow("+i+",true)'><span id='name"+i+"'>"+allField[i]+"</span><input id='input_name"+i+"' type='text' value='"+allField[i]+"' style='display:none; margin:0; padding:0; width:95%'/></td><td class='standardRow light'  onclick='selectRow("+i+")' ondblclick='editRow("+i+",true)'><span id='desc"+i+"'>"+allFieldDescription[i]+"</span><input id='input_desc"+i+"' type='text' value='"+allFieldDescription[i]+"' style='display:none; margin:0; padding:0; width:92%'/></td></tr>";
        }
      }
      else{
        allParameters=[]
        nRow=0;
      }
      title.innerHTML="<div class='columnSx' > Combo value </div><div class='columnDx'> Combo label </div> ";
      label.style.display='none';
      Ctrl('addValue').style.display='inline-block';
      Ctrl('removeValue').style.display='inline-block';
      Ctrl("result").style.display='none';
      Ctrl("OperationButton").style.marginLeft='340px';
      innerHtml+="</table>";
      Ctrl('maskSearch').style.display='none';
      break;
    case 'readfield':
      if (!Empty(tableName)){
        innerHtml="<table id='tableContent' width='100%' onselectstart='return false' style='background-color:#f3f3f3; border:1px solid #e3e3e3;'>";
        GetParameters()
        if (!Empty(parameter) && !(parameter.length==1 && parameter[0]=='')){
          nRow=parameter.length;
          for (i=0; i<parameter.length; i++){
            if (linkedField[i]){
              innerHtml+="<tr style='height:21px;'><td class='standardRow light' onclick='selectRow("+i+")' width='50%' ondblclick='editRow("+i+",true)'><span id='fieldName"+i+"'>"+parameter[i]+"</span><input id='input_fieldName"+i+"' type='text' value='"+parameter[i]+"' style='display:none; margin:0; padding:0; width:87%'/><input type='button' value='?' id='btn_fieldName"+i+"' onclick='requestTableField("+i+")' class='bottoni' style='display:none;'/></td><td class='standardRow light'  onclick='selectRow("+i+")' ondblclick='editRow("+i+",true)'><span id='linkedField"+i+"'>"+linkedField[i]+"</span><input id='input_linkedField"+i+"' type='text' value='"+linkedField[i]+"' style='display:none; margin:0; padding:0; width:87%'/><input type='button' value='?' id='btn_linkedField"+i+"' onclick='requestField("+i+")' class='bottoni' style='display:none;'/></td></tr>";
            }
          }
        }
        else{
          parameter=[]
          nRow=0;
        }
        title.innerHTML="<div class='columnSx' > Field name </div><div class='columnDx'> Linked field </div> ";
        label.style.display='none';
        Ctrl('addValue').style.display='inline-block';
        Ctrl('removeValue').style.display='inline-block';
        Ctrl("result").style.display='none';
        Ctrl("OperationButton").style.marginLeft='340px';
        innerHtml+="</table>";
      }
      Ctrl('maskSearch').style.display='none';
      break;
    case 'parameters':
      innerHtml="<table id='tableContent' width='100%' onselectstart='return false' style='background-color:#f3f3f3; border:1px solid #e3e3e3;'>";
      if (!Empty(parameter) && !(parameter.length==1 && parameter[0]=='')){
        nRow=parameter.length;
        for (i=0; i<parameter.length; i++){
            var param=parameter[i].split('=');
            innerHtml+="<tr style='height:21px;'><td class='standardRow light' onclick='selectRow("+i+")' width='50%' ondblclick='editRow("+i+",true)'><span id='parameterName"+i+"'>"+param[0]+"</span><input id='input_parameterName"+i+"' type='text' value='"+param[0]+"' style='display:none; margin:0; padding:0; width:87%'/></td><td class='standardRow light'  onclick='selectRow("+i+")' ondblclick='editRow("+i+",true)'><span id='parameterValue"+i+"'>"+param[1]+"</span><input id='input_parameterValue"+i+"' type='text' value='"+param[1]+"' style='display:none; margin:0; padding:0; width:87%'/><input type='button' value='?' id='btn_parameterValue"+i+"' onclick='requestField("+i+")' class='bottoni' style='display:none;'/></td></tr>";

        }
      }
      else{
        parameter=[]
        nRow=0;
      }
      title.innerHTML="<div class='columnSx' > Parameter name </div><div class='columnDx'> Parameter value </div> ";
      label.style.display='none';
      Ctrl('addValue').style.display='inline-block';
      Ctrl('removeValue').style.display='inline-block';
      Ctrl("result").style.display='none';
      Ctrl("OperationButton").style.marginLeft='340px';
      innerHtml+="</table>";

      Ctrl('maskSearch').style.display='none';
      break;
  }
  tableContent.innerHTML=innerHtml;
  document.id('content').nanoScrollerMT();
  visibleParameters=allParameters;
  var index, j, input;
  if (action=='queryparameters'){
    for (i=0; i<parameter.length; i++){
      var par_valore=parameter[i].split('=');
      index=-1;
      for (j=0; j<allParameters.length && index==-1; j++){
        if (allParameters[j][0]==par_valore[0])
          index=j;
      }
      if (index!=-1){
        input=Ctrl('input'+index);
        input.value=par_valore[1];
        InsertParameter(index);
      }
    }
  }
  else if (action!='fixedcombo'){
    index=-1;
    for (i=0; i<parameter.length; i++){
      for (j=0; j<allParameters.length && index==-1; j++){
        if (parameter[i]==allParameters[j][0] || parameter[i]==allParameters[j])
          index=j;
      }
      if (index!=-1){
        if (action=='readfield' || action=='fixedfilter' || action=='filterfield'){
          if (linkedField[i]){
            input=Ctrl('input'+index);
            if (input)
              input.value=linkedField[i];
          }
          changeCheck(index);
        }
        else if (action=='dependson' || action=='zoomqryparam'){
          changeCheck(index)
        }
        else
          selectRow(index);
      }
      index=-1;
    }
  }

  else index=-1;

  if (action!='queryParameters' && action!='readfield' && action!='fixedfilter' && action!='filterfield' && action!='fixedcombo'){
    keyboard=new Keyboard({activate:true});
    var move=function(e,idx){
      if (e){
        e.preventDefault();
        e.stopPropagation()
      }
      if (iPrec!=-1)
        selectRow(iPrec+idx);
    }

   	keyboard.addEvents({
      'keydown:up': function(e){move(e,-1); },
      'keydown:down': function(e){move(e,1)}
    });
  }
  resize();
}

function confirmSelection(e){
  if (e.keyCode==13)
    SelectThisParameter()
}

function editRow(i,edit){
  var field1=action=='fixedcombo'?'name':action=='parameters'?'parameterName':'fieldName';
  var field2=action=='fixedcombo'?'desc':action=='parameters'?'parameterValue':'linkedField';
  if (parSelected!=null && parSelected!=-1 && i!=parSelected){
    var comboValue=Ctrl("input_"+field1+parSelected).value, comboLabel=Ctrl("input_"+field2+parSelected).value;
    if (comboValue=='' && comboLabel==''){
      deleteRow()
    }
    else{
      Ctrl("input_"+field1+parSelected).style.display='none'
      Ctrl("input_"+field2+parSelected).style.display='none'
      if (action=='readfield'){
        Ctrl("btn_"+field1+parSelected).style.display='none'
        Ctrl("btn_"+field2+parSelected).style.display='none'
      }
      if (action=='parameters')
        Ctrl("btn_"+field2+parSelected).style.display='none'
      Ctrl(field2+parSelected).style.display='inline'
      Ctrl(field2+parSelected).innerHTML=comboLabel;
      Ctrl(field1+parSelected).style.display='inline'
      Ctrl(field1+parSelected).innerHTML=comboValue;
      document.id(field2+parSelected).getParent().className='standardRow light'
      document.id(field1+parSelected).getParent().className='standardRow light'
      Ctrl(field1+parSelected).parentNode.parentNode.className='';
    }
  }
  if (edit){
    Ctrl("input_"+field1+i).style.display='inline-block'
    Ctrl("input_"+field1+i).focus();
    Ctrl("input_"+field2+i).style.display='inline-block'
    if (action=='readfield'){
      Ctrl("btn_"+field1+i).style.display='inline-block'
      Ctrl("btn_"+field2+i).style.display='inline-block'
    }
    if (action=='parameters')
      Ctrl("btn_"+field2+i).style.display='inline-block'
    Ctrl(field2+i).style.display='none'
    Ctrl(field1+i).style.display='none'
    Ctrl(field1+i).parentNode.parentNode.className='selectedTr';
  }
  if (i!=null){
    if (i!=parSelected){
      Ctrl("input_"+field1+i).value=Ctrl(field1+i).innerText||Ctrl(field1+i).textContent;
      Ctrl("input_"+field2+i).value=Ctrl(field2+i).innerText||Ctrl(field2+i).textContent;
    }
    document.id(field1+i).getParent().className='selectedRow light'
    document.id(field2+i).getParent().className='selectedRow light'
    parSelected=i;
  }
}

function deleteRow(){
  if (parSelected!=null && parSelected!=-1){
    if (action=='readfield')
      Ctrl("fieldName"+parSelected).getParent().getParent().destroy();
    else
      Ctrl("name"+parSelected).getParent().getParent().destroy();
    parSelected=-1;
    iPrec=-1;
  }
}

function addRow(){
  editRow()
  parSelected=null;
  if (action=='readfield')
    Ctrl('tableContent').innerHTML+="<tr style='height:21px;'><td class='selectedRow' onclick='selectRow("+nRow+")' width='50%' ondblclick='editRow("+nRow+",true)'><span id='fieldName"+nRow+"'></span><input id='input_fieldName"+nRow+"' type='text' value='' style='display:none; margin:0; padding:0; width:87%'/><input type='button' value='?' id='btn_fieldName"+nRow+"' onclick='requestTableField("+nRow+")' class='bottoni'/></td><td class='selectedRow'  onclick='selectRow("+nRow+")' ondblclick='editRow("+nRow+",true)'><span id='linkedField"+nRow+"'></span><input id='input_linkedField"+nRow+"' type='text' value='' style='display:none; margin:0; padding:0; width:87%'/><input type='button' value='?' id='btn_linkedField"+nRow+"' onclick='requestField("+nRow+")' class='bottoni'/></td></tr>"
  else if (action=='parameters')
    Ctrl('tableContent').innerHTML+="<tr style='height:21px;'><td class='selectedRow' onclick='selectRow("+nRow+")' width='50%' ondblclick='editRow("+nRow+",true)'><span id='parameterName"+nRow+"'></span><input id='input_parameterName"+nRow+"' type='text' value='' style='display:none; margin:0; padding:0; width:87%'/></td><td class='selectedRow'  onclick='selectRow("+nRow+")' ondblclick='editRow("+nRow+",true)'><span id='parameterValue"+nRow+"'></span><input id='input_parameterValue"+nRow+"' type='text' value='' style='display:none; margin:0; padding:0; width:87%'/><input type='button' value='?' id='btn_parameterValue"+nRow+"' onclick='requestField("+nRow+")' class='bottoni'/></td></tr>"
  else
    Ctrl('tableContent').innerHTML+="<tr style='height:21px;'><td class='selectedRow' onclick='selectRow("+nRow+")' width='50%' ondblclick='editRow("+nRow+",true)'><span id='name"+nRow+"'></span><input id='input_name"+nRow+"' type='text' value='' style='display:none; margin:0; padding:0; width:95%'/></td><td class='selectedRow'  onclick='selectRow("+nRow+")' ondblclick='editRow("+nRow+",true)'><span id='desc"+nRow+"'></span><input id='input_desc"+nRow+"' type='text' value='' style='display:none; margin:0; padding:0; width:92%'/></td></tr>"
  editRow(nRow,true)
  nRow++;
}



function requestField(i){
  parSelected=i;
  var field;
  if (action=='parameters')
    field=Ctrl('input_parameterValue'+parSelected).value
  else if (action!='readfield')
    field=Ctrl('input'+parSelected).value;
  else field=Ctrl('input_linkedField'+parSelected).value;
  openSPModalLayer("./SPMaskParametersConfigurator_filterList.jsp?allField="+URLenc(allField)+"&allFieldDescription="+URLenc(allFieldDescription)+"&fieldSelected="+URLenc(field)+"&SPModalLayerId=filterMskSPModalLayer"+(action=='readfield'?'&action=linkedField':action=='parameters'?'&action=parameterValue':''), 0, 0, 495, 400, false, 1, false,false)
}

function getAllField(){

  var allField;
  switch (action){
    case "readfield":
      allField=fieldTableName
      break;
  }
  return allField;
}

function getAllFieldDescription(){
  var allField;
  switch (action){
    case "readfield":
      allField=fieldTableDescription
      break;
  }
  return allField;
}

function requestTableField(i){
  parSelected=i;
  var field=Ctrl('input_fieldName'+parSelected).value;
  openSPModalLayer("./SPMaskParametersConfigurator_filterList.jsp?fieldSelected="+URLenc(field)+"&SPModalLayerId=filterMskSPModalLayer&action=fieldName", 0, 0, 495, 400, false, 1, false,false)
}

function loadFieldName(value,_action){
  if (!_action || _action=='null'){
    var input=Ctrl('input'+parSelected);
    input.value=value;
    if (action=='queryparameters')
      InsertParameter(parSelected);
    else
      multipleSelectRow(parSelected);
  }
  else
    input=Ctrl('input_'+_action+parSelected).value=value;
}

function InsertParameter(i){
  var input=Ctrl('input'+i);
  var index;
  if (input.value==''){ // se svuotato lo tolgo dalla textbox dei parametri
    index=parameterSelected.indexOf(allParameters[i][0]);
    if (index!=-1){
      parameterSelected.splice(index,1);
      valueParameter.splice(index,1);
    }
  }
  else {
    index=parameterSelected.indexOf(allParameters[i][0]);
    if (index!=-1){ //il valore � stato cambiato
      valueParameter[index]=input.value;
    }
    else { //il valore � stato inserito
      parameterSelected.push(allParameters[i][0]);
      valueParameter.push(input.value);
    }
  }
  var str='';
  var sep='';
  for (var j=0; j<parameterSelected.length; j++){
    str+=sep+parameterSelected[j]+'='+valueParameter[j];
    sep=',';
  }
  Ctrl('result').value=str;
}

function selectRow(i){
  if ((i<visibleParameters.length || i<nRow)&& i>=0 && action!='readfield' && action!='parameters'){
    var content=Ctrl('content');
    var name=Ctrl('name'+i);
    var desc=Ctrl('desc'+i);
    if (action=='fixedcombo'){
      name=name.getParent();
      desc=desc.getParent();
    }
    if (action=='fixedcombo')
      name.className='selectedRow light';
    else
      name.className='selectedRow';
    name.parentNode.className='selectedTr';
    if (desc)
      desc.className='selectedRow right';
    if ((name.getPosition().y+name.getSize().y) > (content.getPosition().y+content.getSize().y))
      new Fx.Scroll(content).toElement(name,'y')
    else if ((name.getPosition().y) < (content.getPosition().y))
      new Fx.Scroll(content).toElement(name,'y')
    if (iPrec!=-1){
      name=Ctrl('name'+iPrec);
      desc=Ctrl('desc'+iPrec);
      if (action=='fixedcombo'){
        name=name.getParent();
        desc=desc.getParent();
      }

      name.parentNode.className='';
      if (desc){
        if (action=='fixedcombo')
          name.className='standardRow light';
        else name.className='standardRow';
        desc.className='standardRow right';
      }
      else
        name.className='standardRow right';
    }
    iPrec=i;

    var result=Ctrl('result');
    if (action=='queryname' || action=='queryparameters' || action=='zoomconfigname' || action=='configname' || action=='config')
      result.value=visibleParameters[i];
    else if (action!='fixedcombo')
      result.value=visibleParameters[i][0];
    if (keyboard)
      keyboard.activate()
    if (action=='fixedcombo')
      editRow(i)
  }
}

function multipleSelectRow(i){
  var selected=Ctrl('check'+i);
  var name=Ctrl('name'+i);
  var desc=Ctrl('desc'+i);
  var button=Ctrl('button'+i);
  var input=Ctrl('input'+i);
  var index;
  if (selected.checked){
    name.className='selectedRow';
    desc.className='selectedRow right';
    if (action=='dependson' || action=='zoomqryparam'){
      name.parentNode.parentNode.className='selectedTr';
      index=parameterSelected.indexOf(allParameters[i][0]);
      if (index==-1)
        parameterSelected.push(allParameters[i][0])
    }
    else{
      name.style.padding='6px'
      desc.style.padding='6px';
      name.parentNode.className='selectedTr';
      button.className='bottoni';
      button.disabled=null;
      input.disabled=null;
      index=parameterSelected.indexOf(allParameters[i][0]);
      if (index!=-1)
        valueParameter[index]=input.value;
      else{
        parameterSelected.push(allParameters[i][0]);
        valueParameter.push(input.value);
      }
    }
  }
  else {
    desc.className='standardRow right';
    if (action=='dependson' || action=='zoomqryparam'){
      name.className='standardRow';
      name.parentNode.parentNode.className='';
      index=parameterSelected.indexOf(allParameters[i][0]);
      if (index>-1)
        parameterSelected.splice(index,1);
    }
    else{
      name.className='standardRow light';
      name.parentNode.className='';
      button.className='disabledButton';
      button.disabled='true';
      input.disabled='true';
      index=parameterSelected.indexOf(allParameters[i][0]);
      if (index>-1){
        parameterSelected.splice(index,1);
        valueParameter.splice(index,1);
      }
    }
  }
  var par='', sep='';
  if (action=='dependson' || action=='zoomqryparam'){
    for (i=0; i<parameterSelected.length; i++){
      par+=sep+parameterSelected[i];
      sep=',';
    }
  }
  else {
    for (i=0; i<parameterSelected.length; i++){
      par+=sep+parameterSelected[i]+'->'+valueParameter[i];
      sep=',';
    }
  }
  Ctrl('result').value=par;
}

function changeCheck(i){
  var selected=Ctrl('check'+i);
  if (selected){
    selected.checked=!selected.checked;
    multipleSelectRow(i);
  }
}

 function GetTables(){
  var oTable;
  var tablesCSV = new JSURL("../servlet/SPXDCProxy?action=tables&tmptbl=true&offlinemode="+offlinemode, true);
  tablesCSV = tablesCSV.Response();
  //Se mancano le librerie sul server
  if (At("ACCESS DENIED", tablesCSV)>0){
    alert("Access Denied.");
  }
  else if (At("ClassNotFoundException: SPXDCProxy", tablesCSV)>0){
    alert("Installation incomplete.");
  } else {
    var oTables = tablesCSV.split(CSV_SEP);

    if (oTables[0]=="* --- Visual Query Tables 1.0 ---*") {
      for (var i=1; i<oTables.length; i++){
        oTable = oTables[i].split("|");
        allParameters[i-1] = new Array(oTable[0], oTable[1], null, null, oTable[2]);
      }
      allParameters.sort(SortByDesc);
    }
    else {
      alert("Server Error:\n\n"+tablesCSV);
    }
  }
}

function GetParameters(){
  if ((action=='tablekeyfield' || action=='valuefield' ) && tableName.indexOf('.vqr')!=-1){
    queryName=Left(tableName,4)
    GetQueryFields()
    return;
  }
  var fieldsCSV = new JSURL("../servlet/SPXDCProxy?action=fields&table=" + tableName+'&format=properties', true);
  fieldsCSV = fieldsCSV.Response();
   if (At(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP)==0){
      var oFields = new TrsJavascript();
      oFields.reset();
      oFields.SetRow(0);
      oFields.BuildProperties(Strtran(fieldsCSV,'* --- Visual Query Fields 1.0 ---*'+CSV_SEP,''));
      var rows=GetProperty(oFields,'Rows','N');
      for(var i=0;i<rows;i++){
        oFields.SetRow(i);
        allParameters[i] = new Array(GetProperty(oFields,'alias','C'),GetProperty(oFields,'desc','C'),GetProperty(oFields,'type','C'),GetProperty(oFields,'len','N'),GetProperty(oFields,'dec','N'));
        fieldTableName[i]=GetProperty(oFields,'alias','C')
        fieldTableDescription[i]=GetProperty(oFields,'desc','C')
      }
    }
  else {
    allParameters[0] = new Array ("Server Error", "Server Error", "", "", "");
  }
}

function SortByDesc(a, b){
  var aa = a[1].toLowerCase();
  var bb = b[1].toLowerCase();
  if (aa > bb) return 1;
  if (aa < bb) return -1;
  return 0;
}

function SortByName(a, b){
  var aa = a[0].toLowerCase();
  var bb = b[0].toLowerCase();
  if (aa > bb) return 1;
  if (aa < bb) return -1;
  return 0;
}

function GetQuery(){
  var query=new JSURL("../servlet/SPVQRProxy?action=vqr&offlinemode="+offlinemode,true);
  query=query.Response();
  query=query.replace(/\.vqr(\.offline)?/gi, '');
  allParameters=eval(query);

  // for (var i=0; i<query.length; i++){
    // allParameters[i]=query[i];
  // }
}

function GetZoomConfigName(){
  var zoomFiles = new JSURL("../servlet/JSPReader?type=portalzoom&tablename="+tableName);
  zoomFiles = zoomFiles.Response();
  allParameters=zoomFiles.split(",");
}

function GetQueryParameters(){
  var queryParameters=new JSURL("../servlet/SPVQRProxy?action=allparameters&filename="+queryName,true);
  queryParameters=(queryParameters.Response());
  var l_oVqr = new TrsJavascript();
  l_oVqr.reset();
  l_oVqr.SetRow(0);
  l_oVqr.BuildProperties(queryParameters);
  var rows=GetProperty(l_oVqr,'Rows','N');
  var numParameter=0;
  for (var i=0; i<rows; i++){
    l_oVqr.SetRow(i);
    //controllo che non ci sia gi� lo stesso campo
    var exist=false;
    for (var j=0; j<allParameters.length && !exist; j++){
      if (allParameters[j][0]==GetProperty(l_oVqr,'field','C'))
        exist=true;
    }
    if (!exist){
      allParameters[numParameter]=[];
      allParameters[numParameter][0]=GetProperty(l_oVqr,'field','C');
      allParameters[numParameter][1]=GetProperty(l_oVqr,'desc','C');
      if (allParameters[numParameter][1]=='')
        allParameters[numParameter][1]=allParameters[numParameter][0];
      numParameter++;
    }
  }
}

function GetQueryFields(){
  var queryFields=new JSURL("../servlet/SPVQRProxy?action=fields&filename="+queryName,true);
  queryFields=(queryFields.Response());
  var l_oVqr = new TrsJavascript();
  l_oVqr.reset();
  l_oVqr.SetRow(0);
  l_oVqr.BuildProperties(queryFields);
  var rows=GetProperty(l_oVqr,'Rows','N');
  var errorMsg=GetProperty(l_oVqr,'errorMsg','C')
  if (errorMsg!="")
    alert(errorMsg)
  for (var i=0; i<rows; i++){
    l_oVqr.SetRow(i);
    allParameters[i]=[];
    allParameters[i][0]=GetProperty(l_oVqr,'alias','C');
    if (allParameters[i][0]==''){ //prendo il nome del campo
      var name=GetProperty(l_oVqr,'exp','C').split('.');
      allParameters[i][0]=name[1];
    }
    allParameters[i][1]=GetProperty(l_oVqr,'desc','C');
  }
}

function resize(){
  document.getElementById('content').style.height=(GetWindowSize().h-document.getElementById('title').offsetHeight-document.getElementById('footer').offsetHeight)+'px';
  document.id('content').nanoScrollerMT();
}
