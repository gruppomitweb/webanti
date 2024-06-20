<%@page import="java.util.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %>
<%@ page import="com.zucchetti.sitepainter.Library" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %>
<%
Sitepainter sp=new Sitepainter(request);
sp.setContentType(response);
%>
<!DOCTYPE html>
<html>
<head>
 <title>Select Parameters</title>
 <script src='../<%=SPPrxycizer.proxycizedPath("Base.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("zdnd_commons.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("visualweb/EditableGridCtrl.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/styleVariables.js")%>'></script>
 <link rel="stylesheet" type="text/css" href="../EventEmitter.css">
 <link rel="stylesheet" type="text/css" href="../filewindow.css">
 <style type="text/css">
  html {height:100%;}
  body {margin:0px;height:100%;}
 </style>
 <script type="text/javascript">
  var returnObj='<%=JSPLib.ToJSValue(sp.getParameter("rtrnobj",""))%>';
  var index=<%=sp.getParameter("index",-1)%>;
  var sep=',';
  Z.Dict=function(){
    var newkey=function(){
      var res="";
      for(var i=0; i++<9; res+=String.fromCharCode(Math.floor(Math.random()*26+97)));
      return res;
    }
    var keys={};
    this.Add=function(data){
      var k=newkey();
      while(k in this){
        k=this.newkey();
      }
      this[k]=data;
      keys[k]=null;
      return k;
    }
    this.Remove=function(key){
      return delete this[key] && delete keys[key];
    }
    this.Keys=function(){
      return Z.Merge({}, keys);
    }
  }

  var parametersCtrl;
  var nWidth,nHeight;
  var mainTable;
  var ItemList=GetOpener().itemsHTML;
  var parms=ItemList[index][returnObj];
  var Ctrl_obj=ItemList[index];

  var parametersConfig={id: 'parameters',titles: [ 'Name', 'Value' ],options:[ {type:'textbox',btnEdit:'false'}, {type:'textbox',btnEdit:'true',callFunc:'SelectParameter'}],blank:  [ '' , '']};
  function DoOnload(){
    var configuration={ blnPointToSelect: false };
    var rowsObj=new Z.Dict();
    parametersConfig.rows=rowsObj;
    parametersCtrl=new Z.EditableGrid(configuration, parametersConfig);
    if(Ctrl_obj.type=='SPLinker' && Ctrl_obj.entity_type=='report' && Empty(Ctrl_obj.parms)){
      parametersConfig.rows=rowsObj;
      rowsObj.Add(['ReportName','']);
    }
    if(!EmptyString(parms)){
      parms=parms.split(sep);
      for(var p=0;p<parms.length;p++){
        var parms_vals=parms[p].split('=');
        if(parms_vals.length==1)
          rowsObj.Add(['',decodeURIComponent(parms_vals[0])]);
        else
          rowsObj.Add([parms_vals[0],decodeURIComponent(parms_vals[1])]);
      }
    }
    Ctrl('parametersDiv').insertBefore(parametersCtrl.buildTable(), Ctrl('parametersDiv').firstChild);
    parametersCtrl.init();
    mainTable=Ctrl('mainTable');
    //nWidth=600;
    //nHeight=500;//Max(mainTable.offsetHeight,500);
    //window.resizeTo(nWidth,nHeight);
    //window.moveTo((screen.availWidth-nWidth)/2>0 ? (screen.availWidth-nWidth)/2 : 0, (screen.availHeight-nHeight)/2>0 ? (screen.availHeight-nHeight)/2 : 0);

  }
  function Resize(){
    if(Ctrl("parametersTd").offsetHeight<=Ctrl("parametersDiv").offsetHeight+30){
      window.resizeTo(nWidth,mainTable.scrollHeight+100);
    }
  }

  function onBtnAdd(obj){
    obj.addRow();
    obj.selectLastRow();
    obj.editSelectedRow();
    Resize();
  }


  function onOk(){
    //salva eventuali righe
    if(parametersCtrl.objRowSelected)
      parametersCtrl.saveRow(parametersCtrl.objRowSelected, true);
    //assegna i parametri
    var parms='';
    var row, rows=parametersCtrl.data.rows;
    for(var k_row in rows.Keys()){
      row = rows[k_row];
      if(EmptyString(row[0]) && EmptyString(row[1]))
        continue;
      if(EmptyString(row[0]))
        parms+=URLenc(row[1])+sep;
      else
        parms+=row[0]+'='+URLenc(row[1])+sep;
    }
    parms=parms.substr(0,parms.length-1);
    Ctrl_obj[returnObj]=parms;
    GetOpener().Properties();
    window.close();
  }
  function SelectParameter(retTo){
    if(Ctrl_obj.type=='SPLinker' && Ctrl_obj.entity_type=='report' && Ctrl('input_0').value=='ReportName'){
      SelectReport(retTo);
    }else{
      var input_ctrl=Ctrl(retTo);
      var input_container=input_ctrl.parentNode;
      input_container.style.position='relative';
      var itemslist_cont=document.createElement("DIV");
      var itemslist=document.createElement("SELECT");
      itemslist_cont.style.position='absolute';
      itemslist_cont.style.display='block';
      itemslist_cont.style.width='100%';
      itemslist_cont.id='itemslist_container';
      itemslist.id='itemslist';
      //itemslist.multiple='true';
      itemslist.style.width='100%';
      itemslist.style.height=input_ctrl.offsetHeight+'px';
      LibJavascript.Events.addEvent(itemslist, 'change',function(){input_ctrl.value=itemslist.value; input_container.removeChild(itemslist_cont)} );
      itemslist_cont.style.top=(input_ctrl.offsetTop)+'px';
      itemslist_cont.style.left=input_ctrl.offsetLeft+'px';
      itemslist_cont.appendChild(itemslist);
      input_container.appendChild(itemslist_cont);
      //Parameter Source
      if(!Empty(ItemList[index]['parms_source'])){
        var parms_source_obj=null;
        var curr_parms_source = ItemList[index]['parms_source'];
        var curr_parms_sources = curr_parms_source.split(',');
        for(var p=0;p<curr_parms_sources.length;p++){
          curr_parms_source = curr_parms_sources[p];
          for(var i=0;i<ItemList.length;i++){
            if(ItemList[i].name==curr_parms_source){
              parms_source_obj=ItemList[i];
              break;
            }
          }
          if(itemslist.options.length==0){
            itemslist.options[0]=new Option('-','', false, false);
          }
          if(parms_source_obj.type == 'Variable'){
            itemslist.options[itemslist.options.length]=new Option(parms_source_obj.name,parms_source_obj.name, false, false);
          }else{
            var parms_fields=GetOpener().GetQueryFields(parms_source_obj['query'])
            parms_fields=parms_fields[0];
            for(var i=0;i<parms_fields.length;i++){
              itemslist.options[itemslist.options.length]=new Option(parms_source_obj.name+"."+parms_fields[i],parms_source_obj.name+"."+parms_fields[i], false, false);
            }
          }
        }
      }else{ //Lista parametri normali
        for(var elem,i=0;i<ItemList.length;i++){
          elem=ItemList[i];
          itemslist.options[0]=new Option('-','', false, false);
          itemslist.options[0].selected='selected';
          if(elem.type=='Variable' || elem.type=='Textbox' || elem.type=='Combobox' || elem.type=='Checkbox' || elem.type=='Radio')
              itemslist.options[itemslist.options.length]=new Option(elem.name,elem.name, false, false);
        }
      }
    }
  }
  function SelectReport(retTo){
    window.layerOpenForeground("../portalstudio/open.jsp?tool=report&onetool=true&ExpressionID="+retTo+"&callerFunction=ReturnReport","Select Report",'',860,500,true,1);
  }
  function ReturnReport(retTo,r){
    var input_ctrl=Ctrl(retTo);
    input_ctrl.value=r;
  }
 </script>
</head>
<body style="border:0;overflow:auto;margin:0;background-color:#E4E4E4" onload="DoOnload()">
 <table id="mainTable" class="contorno" style="width:100%;height:100%" valign="top">
  <tr height="22px">
   <td class="titoli" style="width:50%" align="center"><b>Parameters</b></td>
  </tr>
  <tr>
   <td class="tabellainteterna1" id="parametersTd" valign="top"><div id="parametersDiv"></div>
   </td>
  </tr>
  <tr>
   <td class="footer" height="25px">
    <input type="button" class="bottoni" value="+" id="btn_addParameters" title="Add parameter" onclick="onBtnAdd(parametersCtrl);" style="width:25px">
    <input type="button" class="bottoni" value="-" id="btn_deleteParameters" title="Remove selected parameter" onclick="parametersCtrl.deleteRow();" style="width:25px">
   </td>
  </tr>
  <tr>
   <td class="footer" height="25px" align="right" nowrap>
    <button class="bottoni" onclick="onOk();" accesskey="o" style="width:40px"><u>O</u>k</button>&nbsp;
    <button class="bottoni" onclick="window.close();" accesskey="c"><u>C</u>ancel</button>
   </td>
  </tr>
 </table>
</body>
</html>
