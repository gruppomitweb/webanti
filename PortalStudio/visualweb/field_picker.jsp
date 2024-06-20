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
  // var returnObj='<%=JSPLib.ToJSValue(sp.getParameter("rtrnobj",""))%>';
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
  var parmsF=ItemList[index]["fields"];
  var parmsT=ItemList[index]["types"];
  var Ctrl_obj=ItemList[index];

  var parametersConfig={id: 'parameters',titles: [ 'Field', 'Type' ],options:[ {type:'textbox',btnEdit:'false'}, {type:'textbox',btnEdit:'false'}],blank:  [ '' , '']};
  function DoOnload(){
    var configuration={ blnPointToSelect: false };
    var rowsObj=new Z.Dict();
    parametersConfig.rows=rowsObj;
    parametersCtrl=new Z.EditableGrid(configuration, parametersConfig);
    if(!EmptyString(parmsF) && !EmptyString(parmsT)){
      parmsF=parmsF.split(sep);
      parmsT=parmsT.split(sep);
      for(var p=0;p<parmsF.length;p++){
        rowsObj.Add([parmsF[p],parmsT[p]]);
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
    var paramF='';
    var paramT='';
    var row, rows=parametersCtrl.data.rows;
    for(var k_row in rows.Keys()){
      row = rows[k_row];
      if(EmptyString(row[0]) && EmptyString(row[1]))
        continue;
      if(!EmptyString(row[0]) && !EmptyString(row[1])){
        paramF+=row[0]+sep;
        paramT+=row[1]+sep;
      }
    }
    paramF=paramF.substr(0,paramF.length-1);
    paramT=paramT.substr(0,paramT.length-1);
    Ctrl_obj["fields"]=paramF;
    Ctrl_obj["types"]=paramT;
    GetOpener().Properties();
    window.close();
  }
 </script>
</head>
<body style="border:0;overflow:auto;margin:0;background-color:#E4E4E4" onload="DoOnload()">
 <table id="mainTable" class="contorno" style="width:100%;height:100%" valign="top">
  <tr height="22px">
   <td class="titoli" style="width:50%" align="center"><b>Structure MemoryCursor</b></td>
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
