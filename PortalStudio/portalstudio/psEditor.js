/* exported getFileNameWithExtension getFileName getOpenUrl getJsUrl getTheme */
var themes;

function getFileNameWithExtension(_name,type,offline){
  var name=_name;
  switch (type){
    case 'portlet':
    case 'decorators':
    case 'interfaces':
      name+="_portlet.jsp"
    break;
    case 'pagelet':
    case 'pageleteditor':
      name+=".jsp"
    break;
    case 'plan':
      name+=".plandef"
    break;
    case 'query':
    case 'visualquery':
      name+=".vqr"+(offline?".offline":"")
    break;
    case 'zoom':
    case 'portalzoom':
      var zoomName=name.split('[')[0], tableName=name.split('[')[1];
      tableName=tableName.substring(0,tableName.length-1);
      name=zoomName+'.'+tableName+'_vzm'
    break;
    case 'report':
      name+=".vrp"
    break;
    case 'module':
      name+=".mrp"
    break;
    case 'scan':
    case 'scandoc':
      name+=".sca"
    break;
    case 'menu':
      name+=".vmn"+(offline?".offline":"")
    break;
    case 'mask parameters':
    case 'maskparameters':
      name+=".vdm"
    break;
    case 'css':
      name+=".css"
    break;
    case 'cssclass':
      name+=".ce.css"
    break;
    case 'chart':
      name+=".chartdef"
    break;
    case 'smartreport':
      name+=".svrp"
    break;
    case 'visualpivot':
      name+=".vpv"
    break;
  }
  return name;
}

function getFileName(_name,type){
  var name=''
  var loadable=false;
  switch(type){
    case 'portlet':
      if (_name=='jsp-system'){
        name='jsp-system'
        loadable=true;
      }
      else{
        name = Strtran(_name, "_portlet.jsp","");
      }
    break;
    case 'pagelet':
    case 'pageleteditor':
      if (_name.indexOf('.jsp')==-1){
        loadable=true;
        name=_name;
      }
      else name = Strtran(_name, ".jsp","");
    break;
    case 'plan':
      name = Strtran(_name, ".plandef","");
    break;
    case 'query':
    case 'visualquery':
      if (_name=='Custom'){
        name='Custom'
        loadable=true;
      }
      else name = _name.replace(/\.vqr(\.offline)?/gi, '');
    break;
    case 'zoom':
    case 'portalzoom':
      if (_name=='Custom'){
        name='Custom'
        loadable=true;
      } else {
        var tempName = Strtran(_name,".","[");
        if (Right(tempName, 4)=='_vzm')
          name = Left(tempName, tempName.length-4)+']';
        else name=tempName+']';
      }
    break;
    case 'report':
      if (_name=='Custom'){
        name='Custom'
        loadable=true;
      }
      else{
        name = Strtran(_name, ".vrp","");
        name = Strtran(name, ".VRP","");
      }
    break;
    case 'chart':
      if (_name=='Custom'){
        name='Custom'
        loadable=true;
      }
      else{
        name = Strtran(_name, ".chartdef","");
        name = Strtran(name, ".CHARTDEF","");
      }
    break;
    case 'smartreport':
      if (_name == 'Custom') {
        name = 'Custom';
        loadable = true;
      }
      else {
        name = Strtran(_name, ".svrp", "");
        name = Strtran(name, ".SVRP", "");
      }
    break;
    case 'module':
      name = Strtran(_name, ".mrp","");
      name = Strtran(name, ".MRP","");
    break;
    case 'scan':
    case 'scandoc':
      name = Strtran(_name, ".sca","");
      name = Strtran(name, ".SCA","");
    break;
    case 'menu':
      if (_name=='Custom'){
        name='Custom'
        loadable=true;
      }
      else name= _name.replace(/\.vmn(\.offline)?/gi, '')
    break;
    case 'decorators':
      if (_name.indexOf('.jsp')==-1){
        loadable=true;
        name=_name;
      }
      else name = Strtran(_name, "_portlet.jsp","");
    break;
    case 'mask parameters':
    case 'maskparameters':
      if (_name=='Custom'){
        name='Custom'
        loadable=true;
      }
      else{
        name = Strtran(_name, ".vdm","");
        name = Strtran(name, ".VDM","");
      }
    break;
    case 'manualjsp':
    case 'templates':
    case 'html':
      name = _name;
    break;
    case 'css':
        name = Strtran(_name, ".css","");
        name = Strtran(name, ".CSS","");
    break;
    case 'cssclass':
    case 'css class':
      if (_name.indexOf('.ce.css')==-1){
        loadable=true;
        name=_name;
      }
      else name = Strtran(_name, ".ce.css","");
    break;
    case 'interfaces':
      if (_name.indexOf('.jsp')==-1){
        loadable=true;
        name=_name;
      }
      else name = Strtran(_name, "_portlet.jsp","");
    break;
    case 'visualpivot':
      if (_name == 'Custom') {
        name = 'Custom';
        loadable = true;
      }
      else {
        name = Strtran(_name, ".vpv", "");
        name = Strtran(name, ".VPV", "");
      }
    break;
    default:
      name = Strtran(_name, "_portlet.jsp","");
  }
  return [name,loadable];
}

function getOpenUrl(name,type,parms){
  var openUrl='', path_tmp=parms.folder_path||''
  var cloneParms=Object.clone(parms)
  if (cloneParms.folder_path)
    delete cloneParms.folder_path
  path_tmp=getPainterPath(path_tmp,Lower(type));
  var params = (cloneParms && Object.keys(cloneParms).length>0 ? "&" + Object.toQueryString(cloneParms) :"");
  switch (LRTrim(Lower(type))){
    case 'portlet':
    case 'decorators':
      openUrl='../visualweb/editor.htm?'+(Empty(name)||name=='New'?'':'id='+path_tmp+name)+params;
      break;
    case 'interfaces':
      openUrl='../visualweb/editor.htm?'+(Empty(name)||name=='New'?'':'id='+path_tmp+name)+params;
      if (parms.custom == undefined) {
        openUrl += '&custom=false';
      }
      openUrl += '&altInterface=true';
    break;
    case 'pagelet':
      openUrl='../pagelet/editor.jsp?'+(Empty(name)||name=='New'?'':'name='+path_tmp+name)+params;
    break;
    case 'pageleteditor':
      openUrl='../pageleteditor/pagelet_editor.jsp?'+(Empty(name)||name=='New'?'':'name='+path_tmp+name)+params;
    break;
    case 'plan':
      openUrl='../planeditor/plan.jsp?'+(Empty(name)||name=='New'?'':'id='+path_tmp+name);
    break;
    case 'visualquery':
      openUrl='../visualquery/index.jsp?'+(Empty(name)||name=='New'?'':'filename='+name)+params;
    break;
    case 'portalzoom':
     var configName=name.substring(0,name.indexOf("["));
     var table=name.substring(name.indexOf("[")+1,name.length-1);
      openUrl='../portalzoom/portalzoomeditor.jsp?'+(Empty(name)||name=='New'?'':'Table='+URLenc(table)+"&ConfigName="+URLenc(configName)+params);
    break;
   case 'chart':
      openUrl='../chart/index.jsp?'+(Empty(name)||name=='New'?'':'filename='+name+params);
    break;
    case 'manualjsp':
      openUrl='../pageeditor/index.jsp?'+(Empty(name)||name=='New'?'':'action=load&name='+path_tmp+name);
    break;
    case 'css':
      openUrl='../pageeditor/index.jsp?type=css&'+(Empty(name)||name=='New'?'':'action=load&name='+path_tmp+"styles/"+name);
    break;
    case 'cssclass':
      openUrl='../classeditor/editor.jsp?'+(Empty(name)||name=='New'?'':'css=styles/'+name);
    break;
    case 'html':
      openUrl='../pageeditor/index.jsp?'+(Empty(name)||name=='New'?'':'action=load&type=html&name='+path_tmp+name);
    break;
    case 'templates':
      openUrl='../pageeditor/index.jsp?'+(Empty(name)||name=='New'?'':'action=load&type=template&name='+path_tmp+name);
    break;
    case 'menu':
      openUrl='../menueditor/menueditor.jsp?'+(Empty(name)||name=='New'?'':'action=load&filename='+URLenc(name))+params;
    break;
    case 'module':
      openUrl='../moduleeditor/moduleeditor.jsp?toolbar=false'+(Empty(name)||name=='New'?'':'&id='+path_tmp+name);
    break;
    case 'scandoc':
      openUrl='../scaneditor/scaneditor.jsp?toolbar=false'+(Empty(name)||name=='New'?'':'&id='+path_tmp+name);
    break;
    case 'report':
      if ((!Empty(name)) && name!='New')
        openUrl='../reporteditor/index.jsp?id='+path_tmp+name+params;
      else openUrl='../reporteditor/index.htm';
    break;
    case 'maskparameters':
      openUrl='../maskparameters/maskparameters.jsp?'+(Empty(name)||name=='New'?'':'filename='+name+params);
    break;
    case 'smartreport':
      openUrl = '../smartreport/smartreport.jsp?' + (Empty(name) || name == 'New' ? '' : 'id=' + name + params);
    break;
    case 'visualpivot':
      openUrl = '../visualpivot/editor.jsp?' + (Empty(name) || name == 'New' ? '' : 'ConfigName=' + name + params);
    break;
  }
  return openUrl;
}

function getJsUrl(type,parameters){
  parameters=parameters||{}
  var jsUrl=[];
  switch (Strtran(Lower(type)," ","")){
    case 'portlet':
      jsUrl[0]='../servlet/JSPReader?type=portlet'+(parameters.jsp_system?'&folder_path=-system':'');
      jsUrl[1]='../servlet/JSPReaderByTag?type=portlet';
    break;
    case 'pagelet':
      jsUrl[0]='../servlet/JSPReader?type=pagelet'+(parameters.folder_path?'&folder_path='+getPainterPath(parameters.folder_path,'pagelet'):'');
      jsUrl[1]='../servlet/JSPReaderByTag?type=pagelet';
    break;
    case 'pageleteditor':
      jsUrl[0]='../servlet/JSPReader?type=pageleteditor'+(parameters.folder_path?'&folder_path='+getPainterPath(parameters.folder_path,'pagelet'):'');
      jsUrl[1]='../servlet/JSPReaderByTag?type=pageleteditor';
    break;
    case 'plan':
      jsUrl[0]='../servlet/JSPReader?type=plan';
      jsUrl[1]='../servlet/JSPReaderByTag?type=plan';
    break;
    case 'planpages':
      jsUrl[0]='../servlet/JSPReader?type=planpages';
      jsUrl[1]='../servlet/JSPReaderByTag?type=planpages';
    break;
    case 'zoom':
    case 'portalzoom':
      jsUrl[0]='../servlet/JSPReader?type=portalzoom&custom='+parameters.custom;
      jsUrl[1]='../servlet/JSPReaderByTag?type=portalzoom&custom='+parameters.custom;
    break;
    case 'report':
      jsUrl[0]='../servlet/JSPReader?type=webreport&custom='+parameters.custom;
      jsUrl[1]='../servlet/JSPReaderByTag?type=webreport&custom='+parameters.custom;
    break;
    case 'chart':
      jsUrl[0]='../servlet/JSPReader?type=chart&custom='+parameters.custom;
      jsUrl[1]='../servlet/JSPReaderByTag?type=chart&custom='+parameters.custom;
    break;
	 case 'smartreport':
      jsUrl[0]='../servlet/JSPReader?type=smartreport&custom=' + parameters.custom;
      jsUrl[1]='../servlet/JSPReaderByTag?type=smartreport&custom=' + parameters.custom;
    break;
    case 'module':
      jsUrl[0]='../servlet/JSPReader?type=module';
      jsUrl[1]='../servlet/JSPReaderByTag?type=module';
    break;
    case 'scandoc':
    case 'scan':
      jsUrl[0]='../servlet/JSPReader?type=scandoc';
    break;
    case 'maskparameters':
      jsUrl[0]='../servlet/JSPReader?type=maskparameters&custom='+parameters.custom;
      jsUrl[1]='../servlet/JSPReaderByTag?type=maskparameters&custom='+parameters.custom;
    break;
    case 'decorators':
      jsUrl[0]='../servlet/JSPReader?type=decorators&folder_path=../../jsp-decorators'+(parameters.folder_path?getPainterPath(parameters.folder_path,'decorators'):'');
    break;
    case 'query':
    case 'visualquery':
      jsUrl[0]='../servlet/SPVQRProxy?action=vqr'+(parameters.offlinemode?'&offlinemode=true':'')+'&custom='+parameters.custom;
      jsUrl[1]='../servlet/JSPReaderByTag?type=vqr'+(parameters.offlinemode?'&offlinemode=true':'')+'&custom='+parameters.custom;
    break;
    case 'menu':
      jsUrl[0]='../servlet/JSPReader?type=menu&custom='+parameters.custom+(parameters.offlinemode?'&offlinemode=true':'');
    break;
    case 'portlet':
      jsUrl[0]='../servlet/JSPReader?type=portlet';
    break;
    case 'manualjsp':
      jsUrl[0]='../servlet/JSPReader?folder_path='
      jsUrl[1]='../servlet/JSPReaderByTag?type=jsp';
    break;
    case 'html':
      jsUrl[0]='../servlet/JSPReader?type=html&folder_path='
    break;
    case 'templates':
      jsUrl[0]='../servlet/JSPReader?type=templates'
    break;
    case 'css':
      jsUrl[0]='../servlet/JSPReader?type=css&folder_path='+(parameters.folder_path ? parameters.folder_path : '');
    break;
    case 'cssclass':
      jsUrl[0]='../servlet/JSPReader?type=classeditor&folder_path='+(parameters.folder_path ? parameters.folder_path : '');
    break;
    case 'interfaces':
      jsUrl[0]='../servlet/JSPReader?type=interfaces&folder_path='+(parameters.folder_path?getPainterPath(parameters.folder_path,'interfaces'):'')+'&listFolder='+(Empty(parameters.folder_path)) + "&custom=" + parameters.custom;
    break;
    case 'css_class':
      let txt = parameters.typeObj;
      jsUrl[0]= '../servlet/CssParser?name=portalstudio&item=' + txt.substr(0, 1).toUpperCase() + txt.substr(1);
    break;
    case 'queryparms':
      jsUrl[0] = "../servlet/SPVQRProxy?action=fields&filename="+parameters.queryname+"&offlinemode="+parameters.offline;
      jsUrl[1] = "../servlet/SPVQRProxy?action=fields&filename="+parameters.queryname+"&offlinemode="+parameters.offline;
    break
    case 'formstyle':
      jsUrl[0] = "../servlet/JSPReader?type=allcss";
    break
    case 'procedures':
      jsUrl[0] = '../servlet/SPXDCProxy?action=procedures&offlinemode='+parameters.offline;
      jsUrl[1] = '../servlet/SPXDCProxy?action=procedures&offlinemode='+parameters.offline;
    break
    case 'getportletctrls':
      let whatToGet = parameters.ctrlname === 'emitter' ? 'getEmitters' : 'getReceivers';
      jsUrl[0] = "../servlet/JSPReader?action="+whatToGet+"&type=portlet&action=description&name="+parameters.portlet_name+"&folder_path="
    break
    case 'visualpivot':
      jsUrl[0]='../servlet/JSPReader?type=visualpivot&custom=' + parameters.custom;
      jsUrl[1]='../servlet/JSPReaderByTag?type=visualpivot&custom=' + parameters.custom;
    break;
  }
  return jsUrl;
}

function getPainterPath(path,painter){
  if(path.startsWith('/')){
    path = path.substring(1);
  }
  var exitFolder = '';
  if(path.indexOf('../')==-1){
    exitFolder = '../';
  }
  if (painter=='decorators'){
    if(path.indexOf('jsp-decorators')>-1)
      return '/'+path;
    else if (path!='')
      return '/../'+path+'/jsp-decorators/'
    else
      return '/../jsp-decorators/'
  }else if (painter=='portlet' && !Empty(path)){
    if(path.indexOf('jsp-system')>-1)
      return '/'+exitFolder + path+'/';
    else
      return '/'+path+'/';
  }else if (path!='' && (painter=='pagelet' || painter=='pageleteditor'))
    return '/../'+path+'/'
  else if (painter=='css')
    if(Empty(path))  {
      return '/';
    }else{
      return '/'+ path +'/';
    }
  else if (painter=='interfaces'){
    if(path.indexOf('jsp-interfaces')>-1)
      return '/'+path;
    else if (path!='')
      return path+'/';
  }
  else
    return path;
}

function getTheme(){
  if (!themes){
    var url=new JSURL("../servlet/JSPReader?type=themes",true);
    themes=url.Response().split(',');
  }
  return themes;
}
