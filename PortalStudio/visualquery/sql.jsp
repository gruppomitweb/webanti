<%@page extends="com.zucchetti.PortalStudio.PortalStudioBase" %><%@ page import="com.zucchetti.SPBridge.*" %><%@ page import="com.zucchetti.PortalStudio.*" %><%@ page import="com.zucchetti.sitepainter.SPPrxycizer" %><%
  Sitepainter sp=new Sitepainter(request);
  sp.setContentType(response);
  if(sp.CanAccessEditor("PortalStudio") || "S".equals(sp.getGlobal("g_PortalSamples","")) || sp.CanModifyOwnQuery()) {
%><!doctype html>
<html>
<head>
<title></title>
<script src='../<%=SPPrxycizer.proxycizedPath("stdFunctions.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("controls.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("portalstudio/mergeVDMObj.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("json.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js")%>'></script>
<script src='../<%=SPPrxycizer.proxycizedPath("visualweb/mootools-core.js")%>'></script>
<link type='text/css' rel='STYLESHEET' href='<%=JSPLib.SPWebRootURL(request)%>/<%=sp.getTheme()%>/portalstudio.css'>
<script type="text/javascript">
ZtVWeb.SetWebRootURL('<%=JSPLib.SPWebRootURL(request)%>');
ZtVWeb.SetTheme('<%=sp.getTheme()%>');
ZtVWeb.SetLanguage('<%=sp.getLanguage()%>');
var portlet_list=[],
Pagelet_mapId={},
editMode=false,
forceSaveVdm=false;//per forzare il salvataggio di una maschera (non viene controllato il num di versione in caso di sovrascrittura)
function getOpener() {
  return (window.opener?window.opener:(window.caller?window.caller:window.parent));
}

function CloseWindow(){
  if (editMode){
    editMode=false;
    // prepareVdmObj(getOpener().document.getElementById("vdmVariant").getSelected()[0].get("value"));
    showVdmMask();
  }
  else if (window.opener)
    window.close()
  else if (window.parent)
    window.parent.closePreview();
}

var parameters = getOpener().GetParametersArray();
var vdmObject={};
var parametersValue=getOpener().parametersValue;
function ExecuteOffline(objParms) {
  LibJavascript.RequireLibrary("../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/DataBaseConnection.js")%>",true)
  LibJavascript.RequireLibrary("../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/QueryLoader.js")%>",true)
  LibJavascript.RequireLibrary("../<%=SPPrxycizer.proxycizedPath("spofflineapp/scripts/spofflinelib.js")%>",true)
  var paramsQL = { caller: new MyCaller(objParms,"w_") };
  paramsQL.vqrObject = JSON.parse(Ctrl("m_cWv").value,true);
  var ql = new QueryLoader(paramsQL);
  ql.LoadQuery();
  if (Ctrl("m_cAction").value== "sqlPhrase") {
    var sqlRes = ql.GetSqlExp();
    var idx=0;
    var sqlPhrase = sqlRes.sql.replace(/\?/g,function(match){ return "'"+sqlRes.params[idx++]+"'";});
    sqlPhrase = Strtran(sqlPhrase, " ", "&nbsp;");
    sqlPhrase = Strtran(sqlPhrase, "SELECT&nbsp;", "<span class='KeyWord'>SELECT</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;AS&nbsp;", " <span class='KeyWord'>AS</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;FROM&nbsp;", " <span class='KeyWord'>FROM</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;JOIN&nbsp;", " <span class='KeyWord'>JOIN</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;ON&nbsp;", " <span class='KeyWord'>ON</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;WHERE&nbsp;", " <span class='KeyWord'>WHERE</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;HAVING&nbsp;", " <span class='KeyWord'>HAVING</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;AND&nbsp;", " <span class='KeyWord'>AND</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;OR&nbsp;", " <span class='KeyWord'>OR</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;GROUP&nbsp;BY&nbsp;", " <span class='KeyWord'>GROUP BY</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;ORDER&nbsp;BY&nbsp;", " <span class='KeyWord'>ORDER BY</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;UNION&nbsp;ALL&nbsp;", " <span class='KeyWord'>UNION ALL</span> ");
    sqlPhrase = Strtran(sqlPhrase, "&nbsp;UNION&nbsp;", " <span class='KeyWord'>UNION</span> ");
    document.title = "SQL Phrase";
    document.body.set('style','font-family:Open Sans;font-size:14px;background-color:#FFFFFF');
    var st = document.createElement('style');
    st.appendChild(document.createTextNode("@import url(\"../fonts/OpenSans.css\");"));
    st.appendChild(document.createTextNode(".KeyWord {font-weight:bold;color:#43AFC3}"));
    document.head.appendChild(st);
    document.body.set('html',sqlPhrase);
  } else if (Ctrl("m_cAction").value== "sqlQuery") {
    var query = ql.GetSqlExp();
    query.success = function(p_rs) {
      var output;
      var fields = [];
      if (p_rs.rows.length>0) {
        output = "<table cellspacing='1'><tr style='font-size:10pt;font-weight:bold'>";
        for (var fld in p_rs.rows.item(0)) {//ciclo sulla prima riga del resultset
          fields.push(fld);
          output += "<td align='center' class='title'>&nbsp;"+fld+"&nbsp;</td>";
        }
        output += "</tr>";

        var rs = new CPResultSetOffline(p_rs);
        for (var i=0; !rs.Eof() && i<100; i++) {
          output+="<tr>";
          for (var j=0;j<fields.length;j++) {
            output += "<td style='white-space:pre-wrap'>&nbsp;"+LRTrim(rs.GetString(fields[j]))+"&nbsp;</td>";
          }
          output+="</tr>";
          rs.Next();
        }
        output += "</table>";
      } else {
        output = "Empty resultset";
      }
      document.title = "SQL Execute";
      document.body.set('style','font-family:Open Sans;background-color:#FFFFFF; margin:8px;font-size:14px;');

      var st = document.createElement('style');
      st.appendChild(document.createTextNode("@import url(\"../fonts/OpenSans.css\");"));
      st.appendChild(document.createTextNode("td { background-color:#f3f3f3; padding:3px; font-size:12px;}"));
      st.appendChild(document.createTextNode("table { background-color:#b0b0b0; border-collapse:separate; border-spacing:1px; line-height:normal;}"));
      st.appendChild(document.createTextNode(".title {background-color:#000; color:#fff; font-weight:700; padding:6px; font-size:13px;}"));
      document.head.appendChild(st);

      document.body.set('html',output);
    }
    query.error = function(a) {
      alert("It's not possible to execute the query in this test environment. \nError message: "+a.message);
    }
    sessionStorage.setItem( "entryPointName", getOpener().getOfflineModule());
    var app='<%=request.getContextPath()%>';
    sessionStorage.setItem( "webAppName", app.substring(1) );
    // SPOfflineLib.setClientProps("<%=request.getContextPath()%>/spofflineapp/visualquery")
    CPPooler.connect(SPOfflineLib.getDataBaseName(),true,function(){
        CPPooler.singleQuery(query);
    });
  }
}

function MyCaller(jsonObj,prefix) {
  var sget=function(n,d){
    try {
      if (prefix+n in jsonObj){
        return jsonObj[prefix+n];
      }
      else if (Left(n, prefix.length) == prefix && Substr(n, prefix.length + 1) in jsonObj){
        return jsonObj[Substr(n, prefix.length + 1)];
      }
      else if(n in jsonObj){
        return jsonObj[n];
      }
      else{
        return d;
      }
    }catch(ex){
      return d;
    }
  }
  this.GetNumber=function(n){
    return sget(n,0);
  }
  this.GetString=function(n){
    return sget(n,'');
  }
  this.GetDate=function(n){
    return sget(n,NullDate());
  }
  this.GetDateTime=function(n){
    return sget(n,NullDateTime());
  }
  this.GetLogic=function(n){
    return sget(n,false);
  }
}

function DoLoad() {
  Ctrl("m_cWv").value = getOpener().FillVQRVariables('save',null,'json',false);
  Ctrl("m_cAction").value = getOpener().sqlOperation;
  Ctrl("m_lShowAll").value = getOpener().showAll;
  Ctrl("m_cFilename").value = getOpener().m_cFilename;
  Ctrl("m_cConfigurationFileName").value = getOpener().testConfigurationFile;
  Ctrl("m_cQueryToCompare").value = getOpener().m_cQueryToCompare;
  if (Ctrl("m_cAction").value=='sqlAnalyze') Ctrl("FormSender").action="drawtreeexplainquery.jsp"
  if (parameters.length == 0) {
    if (getOpener().offlinemode) {
      ExecuteOffline({});
    } else {
      Ctrl("FormSender").submit();
    }
  }
  else {
    if (Ctrl("m_cAction").value=='sqlQuery' && Ctrl("m_lShowAll").value=="true"){
      Ctrl("m_cParams").value = getOpener().FillParameterProps();
      var parmsObj=getOpener().parametersValue
      for (el in parmsObj){
        new Element('input',{
          type:'hidden',
          name: el,
          value: parmsObj[el]
        }).inject(document.getElementById("FormSender"));
      }
      Ctrl("FormSender").submit();
    }
    else {
      Ctrl("FormDiv").style.display = "block";
      Ctrl("FormDiv").style.height = "98%";
      Ctrl("FormDiv").style.width = "100%";
      if (getOpener().vdmObj)
        vdmObject=mergeObject(vdmObject,eval("("+getOpener().vdmObj+")"));
      else
        prepareVdmObj(Lower(Ctrl("m_cFilename").value));
      showVdmMask();
    }
  }
}

function createInitialObj(){
  vdmObject.configName=Ctrl("m_cFilename").value;
  if (Ctrl("m_cAction").value=='sqlAnalyze') vdmObject.onOkResource='../visualquery/drawtreeexplainquery.jsp';
  else if (!getOpener().offlinemode) vdmObject.onOkResource='SPVQRProxy';
  vdmObject.fields=[];
  vdmObject.titleMsg='Set parameters';
  vdmObject.onOkAction=Ctrl("m_cAction").value;
  vdmObject.mode=1;
  for (var i=0; i<parameters.length; i++){
    vdmObject.fields[i]={}
    vdmObject.fields[i].fieldName=parameters[i][0];
    vdmObject.fields[i].description=parameters[i][1];
    vdmObject.fields[i].type=parameters[i][2];
    vdmObject.fields[i].len=parseInt(parameters[i][3]);
    vdmObject.fields[i].dec=parseInt(parameters[i][4]);
    vdmObject.fields[i].isFilter=true;
    vdmObject.fields[i].queryFilter=true;
  }
}

// function getConfigObj(){
  // if (getOpener().document.getElementById('vdmVariant') && getOpener().document.getElementById('vdmVariant').getSelected()[0].get("value")=='' && getOpener().vdmObj)
    // vdmObject.configName='';
  // return vdmObject;
// }

function getConfigObjAsString(){
  return URLenc(toJSONString(vdmObject));
}

// function savedVDMMask(_vdmObj){
  // if (editMode){
    // editMode=false;
    // if (_vdmObj){
      // getOpener().vdmObj=toJSONString(_vdmObj);
      // vdmObject=_vdmObj;
      // showVdmMask();
    // }
  // }
  // else if (_vdmObj){
    // vdmObject=_vdmObj;
    // showVdmMask();
  // }
// }

function showVdmMask(){
  var params='';
  if (editMode){
    var parmsValue=ZtVWeb.getPortlet('SPMaskParameters').getParametersValue();
    ZtVWeb.removePortlets();
    ZtVWeb.purgeEventsCache();
    for (el in parmsValue)
      params+='&w_'+el+'='+parmsValue[el]
    ZtVWeb.Include("../jsp/SPMaskParameters_portlet.jsp?ConfigObject="+URLenc(toJSONString(vdmObject))+params+"&EmitterName=parametersList&editMode=true&hideEditToolbar=true","paramValues",true);
  }
  else{
    ZtVWeb.removePortlets();
    ZtVWeb.purgeEventsCache();
    for (var i=0; i<vdmObject.fields.length; i++){ // passo solo i parametri non nascosti
      if (!vdmObject.fields[i].hiddenGroup)
        if (parametersValue[vdmObject.fields[i].fieldName] && parametersValue[vdmObject.fields[i].fieldName]!='')
          params+='&w_'+vdmObject.fields[i].fieldName+'='+parametersValue[vdmObject.fields[i].fieldName];
    }
    ZtVWeb.Include("../jsp/SPMaskParameters_portlet.jsp?ConfigObject="+URLenc(toJSONString(vdmObject))+params+"&EmitterName=parametersList"+(Empty(Ctrl("m_cFilename").value)?"&hideEditToolbar=true":""),"paramValues",true);
  }
  Ctrl('paramValues').style.overflow='';
  Ctrl("m_cParams").value = getOpener().FillParameterProps();

  var portlet=ZtVWeb.getPortlet('SPMaskParameters');
  portlet.m_cWv=new ZtVWeb.VariableCtrl(portlet,'m_cWv',null,'character',Ctrl("m_cWv").value)
  portlet.m_cParams=new ZtVWeb.VariableCtrl(portlet,'m_cParams',null,'character',Ctrl("m_cParams").value)
  portlet.m_cConfigurationFileName=new ZtVWeb.VariableCtrl(portlet,'m_cConfigurationFileName',null,'character',Ctrl("m_cConfigurationFileName").value)

  var parms='m_cWv,m_cParams,m_cConfigurationFileName,m_cFileName='+Ctrl("m_cFilename").value+',m_lShowAll='+Ctrl("m_lShowAll").value+',custom='+getOpener().document.getElementById("customQry").checked+',m_cQueryToCompare='+Ctrl("m_cQueryToCompare").value
  portlet.addParameterSPLinkerConfirm(parms);

  portlet.beforeChangeVersion=function(){
    prepareVdmObj(this.ConfigName.Value());
    vdmObject.configName=this.ConfigName.Value();
    this.ConfigObject.Value(toJSONString(vdmObject));
  }

  portlet.afterChangeVersion=function(){
    var parms='m_cWv,m_cParams,m_cConfigurationFileName,m_cFileName='+Ctrl("m_cFilename").value+',m_lShowAll='+Ctrl("m_lShowAll").value+',custom='+getOpener().document.getElementById("customQry").checked+',m_cQueryToCompare='+Ctrl("m_cQueryToCompare").value
    this.addParameterSPLinkerConfirm(parms);
  }

  portlet.mergeParams=function(configName){
    prepareVdmObj(configName);
    vdmObject.configName=configName; // in teoria dovrebbero gi� essere uguali
    this.ConfigObject.Value(toJSONString(vdmObject));
  }

  var portlet_fake=new function(){
    ZtVWeb.newForm(this,'portlet_fake','params_receiver',400,200,'portlet');
    this.parametersList_discard=new ZtVWeb.EventReceiverCtrl(this,'parametersList_discard','parametersObj','CloseWindow()','','func');
    this.parametersList_confirm=new ZtVWeb.EventReceiverCtrl(this,'parametersList_confirm','parametersObj','saveParameter(evt.parametersObj)','','func');
  }
  ZtVWeb.addPortletObj('portlet_fake','params_receiver',portlet_fake);
  portlet_fake.on_parametersList_discard=function(parmsObj){portlet_fake.parametersList_discard.receiveFnc(parmsObj);}
  portlet_fake.on_parametersList_confirm=function(parmsObj){portlet_fake.parametersList_confirm.receiveFnc(parmsObj);}
}



function prepareVdmObj(vdmName){
  createInitialObj();
  if (vdmName==''){
    if (getOpener().vdmObj)
      vdmObject=mergeObject(vdmObject,eval("("+getOpener().vdmObj+")"));
  }
  else {
    var pAction="m_cAction=exist";
    var pConfigName="&m_cConfigName="+vdmName;
    var url="../servlet/SPVDMProxy?"+pAction+pConfigName;
    if (new JSURL(url,true).Response()=="1"){ // se esite la configurazione
      pAction="m_cAction=load";
      url="../servlet/SPVDMProxy?"+pAction+pConfigName;
      var objConfig=eval("("+ new JSURL(url,true).Response() +")");
      // devo fare merge tra i 2 oggetti
      vdmObject=mergeObject(vdmObject,objConfig);
    }
    else if (getOpener().vdmObj)
      vdmObject=mergeObject(vdmObject,eval("("+getOpener().vdmObj+")"));
  }
}

function saveParameter(_obj){
  getOpener().parametersValue=_obj;
  if (!getOpener().offlinemode) {
    if (Ctrl("m_cAction").value=='testConfiguration')
      CloseWindow();
  } else {
    ExecuteOffline(_obj);
  }
}

function KeyDownFunc(evt){
  var keyCode=GetKeyCode(evt)
  if (keyCode==13)
    CancelEvent(evt)
}

</script>
</head>

<body onload="DoLoad()" onkeydown="KeyDownFunc(event)" style="font-family:verdana; background-color:#ffffff; margin:0; padding:0">
  <div id="FormDiv" style="display:none; background-color:#ffffff;">

  <div id="paramValues"></div>
  <form id="FormSender" name="FormSender" style="margin:0" method="post" action="../servlet/SPVQRProxy">
    <input name="m_cWv" type="hidden" value="">
    <input name="m_cParams" type="hidden" value="">
    <input name="m_cAction" type="hidden" value="sqlPhrase">
    <input name="m_lShowAll" type="hidden" value="">
    <input name="m_cFilename" type="hidden" value="">
    <input name='m_cConfigurationFileName' type='hidden' value="">
    <input name='m_cQueryToCompare' type='hidden' value="">
    <input name='custom' type='hidden' value="false">
  </form>
 </div>
 <div id="MaskDynParms" style="display:none; margin:0"></div>

</body>

</html>
<%}else{
    response.sendRedirect("../jsp-system/SPLogin.jsp?m_cURL="+request.getRequestURI()+(!"".equals(JSPLib.getParametersList(request))?"&":"")+JSPLib.getParametersList(request));
  }
%>
