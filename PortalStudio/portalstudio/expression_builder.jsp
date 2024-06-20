<%@page extends="com.zucchetti.PortalStudio.PortalStudioBaseEditors" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><!doctype html>
<html style="height:100%;">
<head>
 <title>Expression Builder</title>
 <script src="../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-core.js")%>"></script>
 <script src="../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-more.js")%>"></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
 <script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
 <link rel="stylesheet" href="../filewindow.css" type="text/css">
 <%
Sitepainter sp=new Sitepainter(request);
sp.setContentType(response);

String pTable = sp.getParameter("pTable","");
String tool = sp.getParameter("tool","");
%>
 <script type="text/javascript">
  function getOpener() {
    return GetOpener();
    if(!Empty(SPModalLayerId) && SPModalLayerId =='kvBuildSPModalLayer') return window.parent.spModalLayer[window.frameElement.id].getOpenerRef();
    return (window.opener?window.opener:(window.caller?window.caller:window.parent));
  }
  function CloseWindow(){
    if (window.closeFrame) closeFrame();
    else if (!Empty(SPModalLayerId)) getOpener().closeSPModalLayer();
    else window.close()
  }
  var tool = '<%=JSPLib.ToJSValue(tool)%>';
  var ReturnObjectId=null;
  var callerFunction=null;
  var SPModalLayerId=null;
  var functionsToView=[];
  var fieldsOfTable=[];
  var parametersOfQueries=[];
  var variablesToView=[];
  var object_prefix=null;
  var object_postfix=null;
  var m_bUpdated=false;

  function Init() {
    ReturnObjectId = '<%=JSPLib.ToJSValue(sp.getParameter("ExpressionID",""))%>';
    callerFunction = '<%=JSPLib.ToJSValue(sp.getParameter("callerFunction",""))%>';
    SPModalLayerId = '<%=JSPLib.ToJSValue(sp.getParameter("SPModalLayerId",""))%>';
    if(tool=='ctrlsExpressions'){
      functionsToView = getOpener().GetObjsForExpBuilder();
    }else{
      functionsToView = getOpener().GetFunctionsForExpBuilder();
      fieldsOfTable = getOpener().getFieldsOfTables();
      parametersOfQueries = getOpener().getParametersOfQueries();
      variablesToView = getOpener().GetVariablesForExpBuilder();
    }
    document.id("expression").value = getOpener().GetExpressionFromId(ReturnObjectId);
    document.id("description").set('html','');
    window.focus();
    document.id("expression").focus();
    InitCategories();
    document.id("expression").select();
    UpdateCategory();
  }
  function InitCategories() {
    var categorie=document.id("categories");
    //[{name:"functionsName",desc:"Description Functions",prefix:"[",postfix:"()]",functions:[["nome","parametri","descrizione lunga"],["nome2","parametri","descrizione lunga"]]}]
    for (var i=0; functionsToView && i<functionsToView.length;i++) {
      categorie.options[categorie.options.length] = new Option(functionsToView[i].desc,functionsToView[i].name,false,false);
    }
    //[{name:"variablesName",desc:"Description Functions",prefix:"",postfix:"",functions:[["nome","parametri","descrizione lunga"],["nome2","parametri","descrizione lunga"]]}]
    for (var i=0; variablesToView && i<variablesToView.length;i++) {
      categorie.options[categorie.options.length] = new Option(variablesToView[i].desc,variablesToView[i].name,false,false);
    }
    //[{name:"tabella",desc:"tabellina",prefix:"tabella.",postfix:"",fields:[["nome","descrizione"],["nome2","descrizione2"]]}}]
    for (var i=0; fieldsOfTable && i<fieldsOfTable.length; i++) {
      categorie.options[categorie.options.length] = new Option("Fields of "+fieldsOfTable[i].desc,fieldsOfTable[i].name + "_fields",false,false);
      // I parametri vengono visualizzati solo nel Report Editor e nella voce sottostante a quella della query a cui appartengono.
      if (typeof(parametersOfQueries) != 'undefined' && parametersOfQueries[i].fields.length > 0) {
        categorie.options[categorie.options.length] = new Option("Parameters of "+parametersOfQueries[i].desc,parametersOfQueries[i].name + "_parameters",false,false);
      }
    }
    categorie.selectedIndex=0;
  }
  function ReturnExpression() {
    if (m_bUpdated) {
      getOpener()[callerFunction](ReturnObjectId,document.id("expression").value);
      m_bUpdated=false;
    }
    CloseWindow();
  }

  function addObject() {
    if (document.id("objectlist").getSelected().length>0) {
      var object = document.id("objectlist").getSelected()[0].get('value');
      addText(document.id("expression"), object_prefix+object+object_postfix); //Aggiunge il test nella posizione del cursore
      m_bUpdated=true;
    }
  }
  function UpdateCategory() {
    if (document.id("categories").getSelected().length>0) {
      var category = document.id("categories").getSelected()[0].get('value');
      var objlist = document.id("objectlist");
      objlist.set('html','');
      var index,items;
      if ((index=LibJavascript.Array.indexOf(fieldsOfTable,category,function(el){return el.name + "_fields"==category;}))>-1) {
        items=fieldsOfTable[index].fields;
        if (items) {
          document.id("AvailableObjects").set('html','Fields');
          for (var i=0; i<items.length; i++) {
            if(LRTrim(items[i][1]) ==''){
              objlist.options[objlist.options.length] = new Option(items[i][0], items[i][0], false, false);
            } else {
              objlist.options[objlist.options.length] = new Option(items[i][0]+" : "+items[i][1], items[i][0], false, false);
            }
            object_prefix=fieldsOfTable[index].prefix;
            object_postfix=fieldsOfTable[index].postfix;
            if (items.length>0)
              objlist.selectedIndex=0;
          }
        }
      } else if ((index=LibJavascript.Array.indexOf(parametersOfQueries,category,function(el){return el.name + "_parameters"==category;}))>-1) {
        items=parametersOfQueries[index].fields;
        if (items) {
          document.id("AvailableObjects").set('html','Fields');
          for (var i=0; i<items.length; i++) {
            if(LRTrim(items[i][1]) ==''){
              objlist.options[objlist.options.length] = new Option(items[i][0], items[i][0], false, false);
            } else {
              objlist.options[objlist.options.length] = new Option(items[i][0]+" : "+items[i][1], items[i][0], false, false);
            }
            object_prefix="";
            object_postfix=parametersOfQueries[index].postfix;
            if (items.length>0)
              objlist.selectedIndex=0;
          }
        }
      }
      else if ((index=LibJavascript.Array.indexOf(functionsToView,category,function(el){return el.name==category;}))>-1) {
        items=functionsToView[index].functions;
        if (items) {
          document.id("AvailableObjects").set('html','Functions');
          for (var i=0; i<items.length; i++) {
            objlist.options[objlist.options.length] = new Option(items[i][0]+items[i][1], items[i][0], false, false);
          }
          object_prefix=functionsToView[index].prefix;
          object_postfix=functionsToView[index].postfix;
          if (items.length>0)
            objlist.selectedIndex=0;
        }
      } else if ((index=LibJavascript.Array.indexOf(variablesToView,category,function(el){return el.name==category;}))>-1) {
        items=variablesToView[index].functions;
        if (items) {
          document.id("AvailableObjects").set('html','Variables');
          for (var i=0; i<items.length; i++) {
            if(LRTrim(items[i][1]) ==''){
              objlist.options[objlist.options.length] = new Option(items[i][0], items[i][0], false, false);
            } else {
              objlist.options[objlist.options.length] = new Option(items[i][0]+" : "+items[i][1], items[i][0], false, false);
            }
          }
          object_prefix=variablesToView[index].prefix;
          object_postfix=variablesToView[index].postfix;
          if (items.length>0)
            objlist.selectedIndex=0;
        }
      }
      UpdateDescription();
    }
  }
  function UpdateDescription() {
    if(document.id("objectlist").getSelected().length>0) {
      var category = document.id("categories").getSelected()[0].get('value');
      var index;
      var func;
      if ((index=LibJavascript.Array.indexOf(functionsToView,category,function(el){return el.name==category;}))>-1) {
        func = document.id("objectlist").options.selectedIndex;
        document.id("description").set('html',functionsToView[index].functions[func][2]);
      } else if ((index=LibJavascript.Array.indexOf(variablesToView,category,function(el){return el.name==category;}))>-1) {
        func = document.id("objectlist").options.selectedIndex;
        document.id("description").set('html',variablesToView[index].functions[func][2]);
      }
      else if ((index=LibJavascript.Array.indexOf(fieldsOfTable,category,function(el){return el.name + "_fields" == category;}))>-1){
        func = document.id("objectlist").options.selectedIndex;
        var descr=fieldsOfTable[index].fields[func][0]+(LRTrim(fieldsOfTable[index].fields[func][1]) ==''?'':' : '+LRTrim(fieldsOfTable[index].fields[func][1]));
        descr+=' - '+fieldsOfTable[index].fields[func][2]+(Empty(fieldsOfTable[index].fields[func][3])?'':' - Index: '+fieldsOfTable[index].fields[func][3])
        document.id("description").set('html',descr)
      }
      else if ((index=LibJavascript.Array.indexOf(parametersOfQueries,category,function(el){return el.name + "_parameters" == category;}))>-1){
        func = document.id("objectlist").options.selectedIndex;
        var descr=parametersOfQueries[index].fields[func][0]+(LRTrim(parametersOfQueries[index].fields[func][1]) ==''?'':' : '+LRTrim(parametersOfQueries[index].fields[func][1]));
        descr+=' - '+parametersOfQueries[index].fields[func][2]+(Empty(parametersOfQueries[index].fields[func][3])?'':' - Index: '+parametersOfQueries[index].fields[func][3])
        document.id("description").set('html',descr)
      }
    }
    else
      document.id("description").set('html','');
  }  // UpdateDescription
  function SetUpdated() {
    m_bUpdated=true;
  }  // SetUpdated

  function Unload() {
    if ( m_bUpdated ) {
      if ( confirm("Espressione modificata, salvare le modifiche?") ) {
        getOpener()[callerFunction](ReturnObjectId,document.id("expression").value);
      }
    }
  } //Unload
 </script>
</head>

<body style="border:0;overflow:hidden;margin:0;background-color:#E4E4E4; height:100%;" onload="Init()" onunload="Unload()">
<table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0" align="center">
 <tr>
  <td class="titoli" colspan="2" align="center" onselectstart="return false" style="height:15px;">E<u>x</u>pression</td>
 </tr>
 <tr>
  <td class="contenuto" colspan="2" style="height:15%">
   <textarea  class="" id="expression" colspan="2" style="width:100%;height:100%;overflow:hidden" accesskey="x" onchange="SetUpdated()">
   </textarea>
  </td>
 </tr>
 <tr>
  <td class="contenuto" style="width:45%;height:30%">
   <table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
    <tr>
     <td class="titoli" align="center" onselectstart="return false">Ca<u>t</u>egories</td>
    </tr>
    <tr>
     <td style="width:100%;height:100%">
      <select class="" id="categories" size="8" style="width:100%;height:100%" onclick="UpdateCategory()" onchange="UpdateCategory()" accesskey="t">
      </select>
     </td>
    </tr>
   </table>
  </td>
  <td class="contenuto" style="width:55%;height:30%">
   <table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
    <tr>
     <td class="titoli" align="center" onselectstart="return false">A<u>v</u>ailable <span id="AvailableObjects">functions</span></td>
    </tr>
    <tr>
     <td style="width:100%;height:100%">
      <select class="" id="objectlist" size="7" style="width:100%;height:100%" ondblclick="addObject()" onclick="UpdateDescription()" onchange="UpdateDescription()" accesskey="v">
      </select>
     </td>
    </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td class="titoli" colspan="2" align="center" onselectstart="return false" style="height:15px;">D<u>e</u>scription</td>
 </tr>
 <tr>
  <td class="contenuto" colspan="2" style="height:80px">
   <div class="" id="description" style="padding: 2px; height:100%;background-color:white;overflow:auto;" accesskey="e"></div>
  </td>
 </tr>
 <tr>
  <td class="footer" colspan="2" height="20" valign="middle" align="center" nowrap>
   <button onclick="ReturnExpression()" accesskey="i" class="bottoni"><u>I</u>nsert</button>&nbsp;
   <button onclick="CloseWindow()" accesskey="c" class="bottoni2"><u>C</u>ancel</button>
  </td>
 </tr>
</table>
</body>
</html>
