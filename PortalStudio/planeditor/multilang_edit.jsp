<html>
<head>
<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="java.util.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.*" %>
<%@ page import="java.util.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  SPJSPBridge.CPResultSet rs;
%>
 <title>Translate</title>
 <script src="../<%=SPPrxycizer.proxycizedPath("Base.js")%>"></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("zdnd_commons.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("visualweb/EditableGridCtrl.js")%>"></script>
 <link rel="stylesheet" type="text/css" href="../EventEmitter.css">
 <link rel="stylesheet" type="text/css" href="../filewindow.css">
 <script type="text/javascript">

  var GET_DATA=function(str){
    var res={};
    var getDataString=str||new String(window.location);
    var questionMarkLocation=getDataString.search(/\?/);
    if (questionMarkLocation!=-1){
      getDataString=getDataString.substr(questionMarkLocation+1);
      var getDataArray=getDataString.split(/&/g);
      var name_val,idx_eq,p_name,p_value;
      for (var i=0;i<getDataArray.length;i++){
        //var nameValuePair=getDataArray[i].split(/=/);
        name_val=getDataArray[i];
        idx_eq=name_val.indexOf('=');
        p_name=name_val.substr(0,idx_eq);
        p_value=unescape(name_val.substr(idx_eq+1,name_val.length));
        res[p_name]=p_value;
      }
    }
    return res;
  }
  <%
  // Make 'ENG','ITA'
  String langs = "";
  int i = 0;
  RSConnection dobj_languages = new RSConnection(sp.query("SPQUERY_VIEW_LANGUAGES"), 0);
  while (!dobj_languages.Eof()) {
	if(i>0) langs += ",";
	langs += "\'" + dobj_languages.GetString("code").trim() + "\'";
	i++;
	dobj_languages.Next();
  }
  dobj_languages.Close();
  %>
  var xxxx = "<%=sp.getLanguage()%>";
  var field='<%=JSPLib.ToJSValue(sp.getParameter("field",""))%>';
  var index = GetOpener().index;
  var returnObj = GetOpener().itemsHTML[index][field + "_translate"];
  var parameters={id: 'parameters',titles: [ 'Language', 'Translation' ],options:[ {type:'combobox',values:[<%=langs%>]}, {type:'textbox'}],blank:  [ '' , '']};

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

  function DoOnload(){
    var configuration={ blnPointToSelect: false };
    parametersCtrl=new Z.EditableGrid(configuration, parameters);
    Ctrl('parametersDiv').insertBefore(parametersCtrl.buildTable(), Ctrl('parametersDiv').firstChild);
    parametersCtrl.init();

    //Window size
    mainTable=Ctrl('mainTable');
    nWidth=Max(mainTable.offsetWidth,400);
    nHeight=Max(mainTable.offsetHeight,300);
    Resize();
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

  //splitta i parametri che vengono letti dall'editor
  parameters.rows=(function(){
    var res=new Z.Dict();
    var parms=returnObj;
    if(EmptyString(parms))
      return res;
    parms=GET_DATA('?'+parms);
    for(var p in parms){
      res.Add([p,parms[p]]);
    }
    return res;
  })();

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
      parms+=row[0]+'='+(row[1])+'&';
	  //URLenc
    }
    parms=parms.substr(0,parms.length-1);
    GetOpener().itemsHTML[index][field + "_translate"] = parms;
    GetOpener().Properties();
    GetOpener().writeHTML();
    GetOpener().drawLinks(true);
    window.close();
  }
 </script>
</head>
<body style="border:0;overflow:auto;margin:0;background-color:#D6D3CE" onload="DoOnload()">
 <table id="mainTable" class="contorno" style="width:100%;height:100%" valign="top">
  <tr class="contornotitolo" height="22">
   <td class="contorno" style="width:50%" align="center"><b>Translations</b></td>
  </tr>
  <tr>
   <td class="tabellainteterna1" id="parametersTd" valign="top"><div id="parametersDiv"></div>
   </td>
  </tr>
  <tr>
   <td class="contorno" height="25">
    <input type="button" class="bottoni" value="+" id="btn_addParameters" title="Add parameter" onclick="onBtnAdd(parametersCtrl);" style="width:25px">
    <input type="button" class="bottoni" value="-" id="btn_deleteParameters" title="Remove selected parameter" onclick="parametersCtrl.deleteRow();" style="width:25px">
   </td>
  </tr>
  <tr>
   <td class="contorno" height="25" align="right" nowrap>
    <button class="bottoni" onclick="onOk();" accesskey="o" style="width:40px"><u>O</u>k</button>&nbsp;
    <button class="bottoni" onclick="window.close();" accesskey="c"><u>C</u>ancel</button>
   </td>
  </tr>
 </table>
</body>
</html>
