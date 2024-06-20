<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@ page import="com.zucchetti.PortalStudio.*" %>
<!DOCTYPE html>
<html>
  <head>
    <script src="../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>" type='text/javascript'></script>
    <script src="../<%=SPPrxycizer.proxycizedPath("controls.js")%>" type='text/javascript'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("mootools.js")%>'></script>
    <script src='../<%=SPPrxycizer.proxycizedPath("mootools_more.js")%>'></script>
    <script src="../<%=SPPrxycizer.proxycizedPath("portalstudio/nanoScrollerMT.js")%>"></script>
    <script type="text/javascript" src="../<%=SPPrxycizer.proxycizedPath("spModalLayer.js")%>"></script>
    <link rel="stylesheet" href="../portalstudio/nanoScrollerMT.css" />
    <link rel="stylesheet" type="text/css" media="screen" title="default" href="../filewindow.css"></link>
    <link rel="stylesheet" type="text/css" media="screen" title="default" href="./SPMaskParametersConfigurator.css"></link>
    <script>
      var maskField,parameter={},fields={};
      function DoLoad(){
        var queryName='<%=JSPLib.ToJSValue(request.getParameter("queryname"))%>'
        // if (Empty(queryName))
          // selectQuery();
        // else {
        var exists=new JSURL("../servlet/SPVQRProxy?action=exists&m_cFilename="+queryName,true).Response();
        if (exists=='1'){
          Ctrl('queryName').value=queryName;
          reset();

        }
          // else selectQuery();
        // }
        document.id('missingParameters').addEvent('click',function(event){changeParameterList(event)})
        document.id('uselessParameters').addEvent('click',function(event){changeParameterList(event)})
        document.id('updatedParameters').addEvent('click',function(event){changeParameterList(event)})
        document.id('missingFields').addEvent('click',function(event){changeParameterList(event)})
        document.id('updatedFields').addEvent('click',function(event){changeParameterList(event)})
      }

      function reset(){
        loadParameter();
        loadField();
      }

      function changeParameterList(event){
        if (event.target.tagName=='P'){
          var parentNode=event.target.parentNode;
          if (parentNode.hasClass('select')){
            parentNode.removeClass('select');
            parentNode.removeClass('selectedField');
          }
          else {
            parentNode.addClass('select');
            parentNode.addClass('selectedField');
          }
        }
      }

      function updateField(type,all){
        if (type=='add'){
          var list;
          if (all)
            list=document.id('missingFields').getChildren()
          else list=document.id('missingFields').getChildren('li.select')
          for (var i=0; i<list.length; i++){
            var fieldName=list[i].getChildren()[0].get('text');
            var field={
              fieldName:fieldName,
              realFieldName:fieldName,
              isFilter:true,
              queryFilter:false,
              description:fields[fieldName].descr,
              type:fields[fieldName].type,
              len:fields[fieldName].len,
              dec:fields[fieldName].dec
            }
            getOpener().addField(field,true)
            // list[i].destroy();
          }
          document.id('missingFields').nanoScrollerMT();
          if (document.id('missingFields').getChildren().length==0){
            document.id('addFields').disabled='true';
            document.id('addFields').className='disabledButton';
            document.id('addAllFields').disabled='true';
            document.id('addAllFields').className='disabledButton';
          }
        }
        else if (type=='refresh'){
          var list;
          if (all)
            list=document.id('updatedFields').getChildren()
          else list=document.id('updatedFields').getChildren('li.select')
          for (var i=0; i<list.length; i++){
            var fieldName=list[i].getChildren()[0].get('text');
            var field={
              realFieldName:fieldName,
              type:fields[fieldName].type,
              len:fields[fieldName].len,
              dec:fields[fieldName].dec
            }
            getOpener().updateField(field)
            list[i].destroy();
          }
          document.id('updatedFields').nanoScrollerMT();
          if (document.id('updatedFields').getChildren().length==0){
            document.id('refreshFields').disabled='true';
            document.id('refreshFields').className='disabledButton';
            document.id('refreshAllFields').disabled='true';
            document.id('refreshAllFields').className='disabledButton';
          }
        }
      }

      function updateParameter(type,all){
        if (type=='add'){
          var list;
          if (all)
            list=document.id('missingParameters').getChildren()
          else list=document.id('missingParameters').getChildren('li.select')
          for (var i=0; i<list.length; i++){
            var fieldName=list[i].getChildren()[0].get('text');
            var field={
              fieldName:fieldName,
              realFieldName:fieldName,
              isFilter:true,
              queryFilter:true,
              description:parameter[fieldName].descr,
              type:parameter[fieldName].type,
              len:parameter[fieldName].len,
              dec:parameter[fieldName].dec
            }
            getOpener().addField(field,true)
            list[i].destroy();
          }
          document.id('missingParameters').nanoScrollerMT();
          if (document.id('missingParameters').getChildren().length==0){
            document.id('add').disabled='true';
            document.id('add').className='disabledButton';
            document.id('addAll').disabled='true';
            document.id('addAll').className='disabledButton';
          }
        }
        else if (type=='remove'){
          var list;
          if (all)
            list=document.id('uselessParameters').getChildren()
          else list=document.id('uselessParameters').getChildren('li.select')
          for (var i=0; i<list.length; i++){
            var fieldName=list[i].getChildren()[0].get('text');
            getOpener().deleteNode(fieldName,false)
            list[i].destroy();
          }
          document.id('uselessParameters').nanoScrollerMT();
          if (document.id('uselessParameters').getChildren().length==0){
            document.id('delete').disabled='true';
            document.id('delete').className='disabledButton';
            document.id('deleteAll').disabled='true';
            document.id('deleteAll').className='disabledButton';
          }
        }
        else if (type=='refresh'){
          var list;
          if (all)
            list=document.id('updatedParameters').getChildren()
          else list=document.id('updatedParameters').getChildren('li.select')
          for (var i=0; i<list.length; i++){
            var fieldName=list[i].getChildren()[0].get('text');
            var field={
              realFieldName:fieldName,
              type:parameter[fieldName].type,
              len:parameter[fieldName].len,
              dec:parameter[fieldName].dec
            }
            getOpener().updateField(field)
            list[i].destroy();
          }
          document.id('updatedParameters').nanoScrollerMT();
          if (document.id('updatedParameters').getChildren().length==0){
            document.id('refresh').disabled='true';
            document.id('refresh').className='disabledButton';
            document.id('refreshAll').disabled='true';
            document.id('refreshAll').className='disabledButton';
          }
        }
        if (document.id('uselessParameters').getChildren().length==0 && document.id('missingParameters').getChildren().length==0 && document.id('updatedParameters').getChildren().length==0){
          alert('The mask is updated');
        }
      }

      // function updateField(type,all){

      // }

      function loadField(){
        maskField=getOpener().getField();
        fields={}
        var queryFields=new JSURL("../servlet/SPVQRProxy?action=fields&filename="+URLenc(Ctrl('queryName').value),true).Response();
        var l_oVqr = new TrsJavascript();
        l_oVqr.reset();
        l_oVqr.SetRow(0);
        l_oVqr.BuildProperties(queryFields);
        var rows=GetProperty(l_oVqr,'Rows','N');
        for (var i=0; i<rows; i++){
          l_oVqr.SetRow(i);
          var fieldName=GetProperty(l_oVqr,'alias','C');
          if (!fields[fieldName]){
            fields[fieldName]={
              descr:GetProperty(l_oVqr,'desc','C'),
              type:GetProperty(l_oVqr,'type','C'),
              len:GetProperty(l_oVqr,'len','N'),
              dec:GetProperty(l_oVqr,'dec','N')
            }
          }
        }
        var missingLi='',refreshLi='';
        for (el in fields){
          if (maskField[el]){
            var type='';
            if (maskField[el].type=='DateTime')
              type='T';
            else type=maskField[el].type.charAt(0);
            if (type!=fields[el].type || maskField[el].len!=fields[el].len || maskField[el].dec!=fields[el].dec)
              refreshLi+="<li><p class='standardRow'>"+el+"</p><p class='standardRow right'>"+maskField[el].descr+'&nbsp;'+"</p></li>"
          }
          else {
            missingLi+="<li><p class='standardRow'>"+el+"</p><p class='standardRow right'>"+fields[el].descr+'&nbsp;'+"</p></li>"
          }
        }
        if (Empty(missingLi)){
          document.id('addFields').disabled='true';
          document.id('addAllFields').className='disabledButton';
          document.id('addFields').className='disabledButton';
          document.id('addAllFields').disabled='true';
        }
        else {
          document.id('addFields').set('disabled',false);
          document.id('addFields').className='bottoni';
          document.id('addAllFields').set('disabled',false);
          document.id('addAllFields').className='bottoni';
        }
        if (Empty(refreshLi)){
          document.id('refreshFields').disabled='true';
          document.id('refreshFields').className='disabledButton';
          document.id('refreshAllFields').disabled='true';
          document.id('refreshAllFields').className='disabledButton';
        }
        else {
          document.id('refreshFields').set('disabled',false);
          document.id('refreshFields').className='bottoni';
          document.id('refreshAllFields').set('disabled',false);
          document.id('refreshAllFields').className='bottoni';
        }
        document.id('missingFields').innerHTML=missingLi;
        document.id('updatedFields').innerHTML=refreshLi;
        document.id('missingFields').nanoScrollerMT();
        document.id('updatedFields').nanoScrollerMT();
      }

      function loadParameter(){
        parameter={};
        maskField=getOpener().getField();
        var queryParameters=new JSURL("../servlet/SPVQRProxy?action=allparameters&filename="+URLenc(Ctrl('queryName').value),true).Response();
        var l_oVqr = new TrsJavascript();
        l_oVqr.reset();
        l_oVqr.SetRow(0);
        l_oVqr.BuildProperties(queryParameters);
        var rows=GetProperty(l_oVqr,'Rows','N');

        for (var i=0; i<rows; i++){
          l_oVqr.SetRow(i);
          var fieldName=GetProperty(l_oVqr,'field','C');
          if (!parameter[fieldName]){
            parameter[fieldName]={
              descr:GetProperty(l_oVqr,'desc','C'),
              type:GetProperty(l_oVqr,'type','C'),
              len:GetProperty(l_oVqr,'len','N'),
              dec:GetProperty(l_oVqr,'dec','N')
            }
          }
        }
        var missingLi='',uselessLi='',refreshLi='';
        for (el in parameter){
          if (maskField[el]){
            var type='';
            if (maskField[el].type=='DateTime')
              type='T';
            else type=maskField[el].type.charAt(0);
            if (type!=parameter[el].type || maskField[el].len!=parameter[el].len || maskField[el].dec!=parameter[el].dec || Lower(maskField[el].typeFilter)!='query parameter')
              refreshLi+="<li><p class='standardRow'>"+el+"</p><p class='standardRow right'>"+maskField[el].descr+'&nbsp;'+"</p></li>"
          }
          else {
            missingLi+="<li><p class='standardRow'>"+el+"</p><p class='standardRow right'>"+parameter[el].descr+'&nbsp;'+"</p></li>"
          }
        }
        for (el in maskField){
          if (maskField[el].typeFilter=='Query parameter' && !parameter[el])
            uselessLi+="<li><p class='standardRow'>"+el+"</p><p class='standardRow right'>"+maskField[el].descr+'&nbsp;'+"</p></li>"
        }
        if (Empty(missingLi)){
          document.id('add').disabled='true';
          document.id('addAll').className='disabledButton';
          document.id('add').className='disabledButton';
          document.id('addAll').disabled='true';
        }
        else {
          document.id('add').set('disabled',false);
          document.id('add').className='bottoni';
          document.id('addAll').set('disabled',false);
          document.id('addAll').className='bottoni';
        }
        if (Empty(uselessLi)){
          document.id('delete').disabled='true';
          document.id('delete').className='disabledButton';
          document.id('deleteAll').disabled='true';
          document.id('deleteAll').className='disabledButton';
        }
        else {
          document.id('delete').set('disabled',false);
          document.id('delete').className='bottoni';
          document.id('deleteAll').set('disabled',false);
          document.id('deleteAll').className='bottoni';
        }
        if (Empty(refreshLi)){
          document.id('refresh').disabled='true';
          document.id('refresh').className='disabledButton';
          document.id('refreshAll').disabled='true';
          document.id('refreshAll').className='disabledButton';
        }
        else {
          document.id('refresh').set('disabled',false);
          document.id('refresh').className='bottoni';
          document.id('refreshAll').set('disabled',false);
          document.id('refreshAll').className='bottoni';
        }
        if (Empty(missingLi) && Empty(uselessLi) && Empty(refreshLi)){
          alert('The mask is updated');
        }
        else {
          document.id('missingParameters').innerHTML=missingLi;
          document.id('uselessParameters').innerHTML=uselessLi;
          document.id('updatedParameters').innerHTML=refreshLi;
        }
        document.id('missingParameters').nanoScrollerMT();
        document.id('uselessParameters').nanoScrollerMT();
        document.id('updatedParameters').nanoScrollerMT();
      }

      function loadValue(action, value){
        Ctrl('queryName').value=value;
        reset();
      }

      function selectQuery(){
        openSPModalLayer("./SPMaskParametersConfigurator_list.jsp?action=queryName&parameter="+Ctrl('queryName').value+"&SPModalLayerId=mskSPModalLayer", 0, 0, 490, 490, false, 1, false,false)
      }

      function editQuery(){
        getOpener().editQuery(Ctrl("queryName").value)
      }

      function getOpener(){
        return (window.opener?window.opener:window.parent)
      }

      function showParameter(){
        document.id('tabFields').className='disabledButton';
        document.id('tabParams').className='bottoni';
        document.id('parameters').style.display='block';
        document.id('fields').style.display='none';
      }

      function showFields(){
        document.id('tabParams').className='disabledButton';
        document.id('tabFields').className='bottoni';
        document.id('parameters').style.display='none';
        document.id('fields').style.display='block';
      }

    </script>

  </head>
  <body onLoad='DoLoad()'>
    <div style='background:#efefef; padding:5px;'>
      <label class='lbl'>Select query:</label>
      <input type='text' style='width:200px;' id='queryName' onChange='reset();'>
      <div id='selectQuery' onClick='selectQuery()'>&#xe6f6;</div>
      <div id='editQuery' onClick='editQuery()'>&#xe603;</div>
    </div>
    <div style='padding:10px;'>
      <input type='button' class='bottoni' value='Parameter' id='tabParams' onClick="showParameter()" >
      <input type='button' class='disabledButton' value='Fields' id='tabFields' onClick="showFields()">
    </div>
    <div id='parameters'>
      <div class='title'>
        Missing parameters
      </div>
      <ul id='missingParameters' class='list'>
      </ul>
      <div class='btn'>
        <input type='button' class='bottoni' value='Add' id='add' onClick="updateParameter('add',false)">
        <input type='button' class='bottoni' value='Add all' id='addAll' onClick="updateParameter('add',true)">
      </div>
      <div class='title' style='margin-top:4px;'>
        Useless parameters
      </div>
      <ul id='uselessParameters' class='list'>
      </ul>
      <div class='btn'>
        <input type='button' class='bottoni' value='Delete' id='delete' onClick="updateParameter('remove',false)">
        <input type='button' class='bottoni' value='Delete all' id='deleteAll' onClick="updateParameter('remove',true)">
      </div>
      <div class='title' style='margin-top:4px;'>
        Parameters to be updated
      </div>
      <ul id='updatedParameters' class='list'>
      </ul>
      <div class='btn'>
        <input type='button' class='bottoni' value='Update' id='refresh' onClick="updateParameter('refresh',false)">
        <input type='button' class='bottoni' value='Update all' id='refreshAll' onClick="updateParameter('refresh',true)">
      </div>
    </div>
    <div id='fields' style='display:none;'>
      <div class='title'>
        Missing fields
      </div>
      <ul id='missingFields' class='list'>
      </ul>
      <div class='btn'>
        <input type='button' class='bottoni' value='Add' id='addFields' onClick="updateField('add',false)">
        <input type='button' class='bottoni' value='Add all' id='addAllFields' onClick="updateField('add',true)">
      </div>
      <div class='title' style='margin-top:4px;'>
        Fields to be updated
      </div>
      <ul id='updatedFields' class='list'>
      </ul>
      <div class='btn'>
        <input type='button' class='bottoni' value='Update' id='refreshFields' onClick="updateField('refresh',false)">
        <input type='button' class='bottoni' value='Update all' id='refreshAllFields' onClick="updateField('refresh',true)">
      </div>
    </div>
  </body>
</html>
