/* exported toggleToolbarBig resetPic getInternetExplorerVersion Help toggleProjectView
    changeName showmenu portalStudioContainer Right showBtnText hideBtnText changePic
    m_nPreferredHeight GetWindowPreferredSize manageItems
  */
var deftmp="";                  // usato per il Copy/Paste
var opensApl=new Array(null,null);   //array contenente tutte le applicazioni aperte, init con i 2 frame di partenza
var currentIndex=0;             //Indice applicazione corrente
var is_Saving=false;
// var btnTxtsLengths = {}; //Dizionario delle lunghezze dei caption dei pulsanti
// var openTextTO = null; //Funzione per il timeout dell'apertura caption pulsanti
// var tBarOpened = true; //Flag apertura toolbar grande
var portalStudioContainer = true; //utilizzato per sapere se il frame contiene portalstudio
var webAppName;
var paintersMenu;
window.addEventListener('beforeunload', function(e) {
  e.preventDefault();
  var confirmationMessage = 'Uscire da Portalstudio?';
  for(var i=0;i<opensApl.length;i++){
    if(opensApl[i]!=null){
      if(!Empty(getFrameObj("portalstudioframe"+i).m_bUpdated) && getFrameObj("portalstudioframe"+i).m_bUpdated){
        (e || window.event).returnValue = confirmationMessage;
        return confirmationMessage;
      }
    }
  }
});
function setRecent( recents ) {
  localStorage.setItem(webAppName+'_recents',escape(JSON.stringify(recents)));
  setRecentDiv()
}

function getRecent(){
  return JSON.parse(unescape(localStorage.getItem(webAppName+'_recents'))) || []
}

function RemoveRecent(type,name,parameters){
  var found=-1;
  var recents = getRecent();
  for (var i=0;i<recents.length;i++){
    if (recents[i].type==type && recents[i].name == name) {
      var equals=true;
      for (el in recents[i].parameters){
        if (recents[i].parameters[el]!=parameters[el] && !(Empty(recents[i].parameters[el]) && !parameters[el])){
          equals=false;
          break;
        }
      }
      if (equals){
        for (var el in parameters){
          if (recents[i].parameters[el]!=parameters[el] && !(Empty(recents[i].parameters[el]) && !parameters[el])){
            equals=false;
            break;
          }
        }
        if (equals){
          found=i;
          break;
        }
      }
    }
  }
  if (type && name) {
    if (found!=-1)
      LibJavascript.Array.remove(recents,found);
    setRecent(recents);
  }
}
function getInternetExplorerVersion(){
   var rv = -1; // Return value assumes failure.
   if (navigator.appName == 'Microsoft Internet Explorer')
   {
      var ua = navigator.userAgent;
      var re  = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
      if (re.exec(ua) != null)
         rv = parseFloat( RegExp.$1 );
   }
   return rv;
}
function AddRecentOpen(type,name,parameters){
  var recents = getRecent();
  parameters= parameters ? parameters : {};
  if( type == 'pageleteditor' ) //ripulisco i paramatri passati per collegare il plan alla pagelet
    parameters = parameters.folder_path ? { folder_path: parameters.folder_path } : {};
  var found=-1;
  for (var i=0;i<recents.length;i++){
    if (recents[i].type==type && recents[i].name == name){ // && recents[i].parameters.path == parameters.path) {
      var equals=true;
      for (el in recents[i].parameters){
        if (recents[i].parameters[el]!=parameters[el] && !(Empty(recents[i].parameters[el]) && !parameters[el])){
          equals=false;
          break;
        }
      }
      if (equals){
        for (var el in parameters){
          if (recents[i].parameters[el]!=parameters[el] && !(Empty(recents[i].parameters[el]) && !parameters[el])){
            equals=false;
            break;
          }
        }
        if (equals){
          found=i;
          break;
        }
      }
    }
  }
  if (type && name) {
    if (found==-1) {
      recents.push({
        type:type,
        name:name,
        parameters:parameters
      });
      if (recents.length>10) LibJavascript.Array.remove(recents,0);
    } else {
      recents.push(recents[found]);
      LibJavascript.Array.remove(recents,found);
    }
    setRecent(recents);
  }
}
function setRecentDiv() {
  var recents = getRecent();
  var items = [];
	if (typeof(recents)=='undefined' || recents==null || recents.length==0){
		items.push({ classname: "menu-item first-item", id: "", text: "No recent files", event: function(){}});
  }
	for(var i=recents.length-1;i>=0;i--){
    recents[i].parameters=recents[i].parameters||{};
		var itm = { classname: "menu-item" };
		if(i == recents.length-1)
      itm.classname += ' first-item';
		if(i == 0)
			itm.classname += ' last-item';
    itm.event = function() {
      AddRecentOpen( this.type, (this.name?this.name:""), this.parameters);
      newCurrentObj( this.name, this.type, this.parameters);
    }.bind(recents[i]);
    itm.text = "["+recents[i].type+"]  "+recents[i].name;
    var parms=recents[i].parameters.custom?'custom':'';
    parms+=recents[i].parameters.offlinemode?((Empty(parms)?'':',')+'offline'):''
    parms+=recents[i].parameters.folder_path||''
    parms=Empty(parms)?'':'('+parms+')';
    itm.title = recents[i].type+"/"+recents[i].name+" "+parms;
    items.push(itm);
  }
  paintersMenu.appendActions( items, "recent-picker" );
  paintersMenu.refresh();
}

function Help(){
  openHelp();
}
function ResizePS(){
  if (getFrameObj('project_view_frame').resizeHeight){
    getFrameObj('project_view_frame').resizeHeight(document.id('project_view_container').offsetHeight);
  }
}

function newCurrentObj(name,type,parms){
  if(Empty(name)) name='New';
  var i;
  if (typeof(parms)=='string'){
    if (!Empty(parms)){
      try{
        parms=JSON.parse(parms)
      }
      catch (e){
        parms={'folder_path':parms}
      }
    }
    else parms={}
  }
  else parms=parms||{}
  if (parms.custom && typeof parms.custom == 'string')
    parms.custom=parms.custom=='true'?true:false
  if (parms.offlinemode && typeof parms.offlinemode == 'string')
    parms.offlinemode=parms.offlinemode=='true'?true:false
  if (name!='New'  && type!='html' && type!='templates' && !(type=='portalzoom' && Empty(name.split('[')[0])))
    AddRecentOpen(type,name,parms);

  var curr=null
  for(i=0;i<opensApl.length;i++){
    if(opensApl[i]!=null && name!="New" && name==opensApl[i].name && getOpenUrl(name,type,parms)==opensApl[i].src){
      curr=i;
      break;
    }
  }
  if (curr!=null && !confirm("\""+opensApl[curr].name+"\" is already opened, do you want to open it in another tab?")) { //documento gia' aperto
    selectCurrentObj(i);
    return;
  }
  var created = false
  for(i=0;i<opensApl.length;i++){
    if(opensApl[i]==null){
      opensApl[i]=new aplObj(name,type,parms)
      currentIndex=i
      created = true
      break
    }
  }
  if (!created){
    var newi = opensApl.length
    opensApl.push(new aplObj(name,type,parms))
    var ifrm = document.createElement("iframe");
    ifrm.id   = "portalstudioframe" + newi
    ifrm.name = "portalstudioframe" + newi
    ifrm.className = "portalstudioframes";
    ifrm.setAttribute('toResize','no');
    ifrm.style.display = "none"
    ifrm.frameBorder=0
    document.body.appendChild(ifrm)
    currentIndex = newi
  }
  else {
    document.getElementById("portalstudioframe"+currentIndex).setAttribute('toResize','no')
  }

  document.id('project_view_container').addClass('projectView');

  $("tabwrapper").setStyle('display',"block");
  document.body.classList.add("tabwrapper-opened");
  document.body.classList.remove("toolBig-opened");
  writeAllIframes();
}

function toggleProjectView(){
  var mifTree= document.id("project_view_container");
  if (mifTree.hasClass("opened")){
    document.id('open_pv').set('title','Open Project view');
    mifTree.removeClass("opened");
  }
  else {
    document.id('open_pv').set('title','Close Project view');
    mifTree.addClass("opened");
    if (getFrameObj('project_view_frame').setSearchFocus)
      getFrameObj('project_view_frame').setSearchFocus();
  }
}

//Funzioni per gestire piu' applicazioni aperte
function aplObj(name,type,parms){
  var icon
  this.name = name
  this.src  = getOpenUrl(name,type,parms)
  this.parms  = parms || {}
  this.parms.folder_path=this.parms.folder_path||'';
  this.type = type
  switch (type){
    case 'portlet':
    case 'decorators':
    case 'interfaces':
      icon = "images/icon/attivo_portlet.gif"
    break;
    case 'pagelet':
    case 'pageleteditor':
      icon = "images/icon/attivo_pagelet.gif"
    break;
    case 'plan':
      icon = "images/icon/attivo_plan.gif"
    break;
    case 'visualquery':
      icon = "images/icon/attivo_visualquery.gif"
    break;
    case 'portalzoom':
      icon = "images/icon/attivo_zoom.gif"
    break;
    case 'chart':
      icon = "images/icon/attivo_charteditor.gif"
    break;
    case 'manualjsp':
    case 'html':
    case 'templates':
      icon = "images/icon/attivo_pageeditor.gif"
    break;
    case 'menu':
      icon = "images/icon/attivo_menu.gif"
    break;
    case 'css':
    case 'cssclass':
      icon ="images/icon/attivo_csseditor.gif"
    break;
    case 'module':
      icon = "images/icon/attivo_module.gif"
    break;
    case 'scandoc':
      icon = "images/icon/attivo_sca.gif"
    break;
    case 'report':
    case 'smartreport':
      icon = "images/icon/attivo_report.gif"
    break;
    case 'maskparameters':
      icon = "images/icon/attivo_maskparameters.gif"
    break;
  }
  this.icon = icon
}

window.onunload=function(){
  for (var i=0;i<opensApl.length;i++){
    if(opensApl[i]!=null){
      if(opensApl[i].type=="css"){
        getFrameObj("portalstudioframe"+i).Close();
	    }
    }
  }
}

function closeCurrentObj(){
  // if(opensApl[currentIndex]!=null){
  //   var type = opensApl[currentIndex].type;
  // }
  if (getFrameObj("portalstudioframe"+currentIndex).m_bUpdated==true){
    if(confirm("Do you want to save " + opensApl[currentIndex].name + " ?\n\nClick OK to save\nClick Cancel to ignore changes")){
      saveTool();
      return;
    }
  }
  // if (type=="css"){
    // getFrameObj("portalstudioframe"+currentIndex).Close();
  // }
  Ctrl("portalstudioframe"+currentIndex).style.display="none"
  opensApl[currentIndex]=null
  var existOpen=false
  var n=0, i
  for(i=0;i<opensApl.length;i++){
    if(opensApl[i]!=null){
      existOpen=true
      if(n==0){
        $("tabcontainer").empty();
		tabHTML(i).inject($("tabcontainer"));
	  }
      else
        tabHTML(i).inject($("tabcontainer"));
    n++
    }
  }
  if(existOpen==false) {
    Ctrl("tabcontainer").innerHTML="";
    Ctrl("portalstudioframe0").src="portalstudio.html";
    Ctrl("portalstudioframe0").style.display="block";
    Ctrl("tabwrapper").style.display = "none";
    document.body.classList.add("toolBig-opened");
    document.id("project_view_container").removeClass('projectView').addClass("opened");

    if (getFrameObj('project_view_frame').refreshHeight)
      getFrameObj('project_view_frame').refreshHeight();
    Ctrl("title").innerHTML = "Sitepainter Infinity Portalstudio";
    document.getElementById("title").classList.remove('editor-open');
  } else {
    for (i=currentIndex-1; i>=0;i--)
      if (opensApl[i]!=null) break;
    if (i<0)
      for (i=currentIndex; i<opensApl.length;i++)
        if (opensApl[i]!=null) break;
    selectCurrentObj(i)
  }
}
function saveTool(s,i){
  var saveAction = ""
  var currIndex=(i==null?currentIndex:i);
  if (arguments.length > 0){
    saveAction = arguments[0]
  }
  if(opensApl[currIndex]!=null){
    switch(opensApl[currIndex].type){
      case "portlet":
      case 'decorators':
      case 'interfaces':
          getFrameObj("portalstudioframe"+currIndex).save(saveAction);
          break;
      case "visualquery":
          getFrameObj("portalstudioframe"+currIndex).Save(saveAction);
          break;
      case "pagelet":
      case "pageleteditor":
          if(getFrameObj("portalstudioframe"+currIndex).currentname!="")
            getFrameObj("portalstudioframe"+currIndex).save();
          else
            saveAsTool();
          break;
      case "pageleteditor":
      case "module":
      case "scandoc":
      case "menu":
          if(getFrameObj("portalstudioframe"+currIndex).currentname!="")
            getFrameObj("portalstudioframe"+currIndex).save(false,saveAction);
          else
            saveAsTool();
          break;
      case "cssclass":
          if(!Empty(getFrameObj("portalstudioframe"+currIndex).cssFile))
            getFrameObj("portalstudioframe"+currIndex).saveClass();
          else
            saveAsTool();
          break;
      case "css":
      case "manualjsp":
          if(!Empty(getFrameObj("portalstudioframe"+currIndex).fileName))
            getFrameObj("portalstudioframe"+currIndex).save(saveAction);
          else
            saveAsTool();
          break;
      case "chart":
      case "plan":
      case "report":
      case "smartreport":
          getFrameObj("portalstudioframe"+currIndex).save(saveAction);
          break;
      case "portalzoom":
	  case "visualpivot":
            getFrameObj("portalstudioframe"+currIndex).save();
            break;
      case "maskparameters":
          if(getFrameObj("portalstudioframe"+currIndex).currentname!="")
            getFrameObj("portalstudioframe"+currIndex).save();
          else
            saveAsTool();
          break;
    }
  }
}

function saveAll(){
  for(var i=0;i<opensApl.length;i++){
    if(opensApl[i]!=null){
      if(!Empty(getFrameObj("portalstudioframe"+i).currentname)){
        saveTool(null,i);
      }else{
        alert('The New files must be saved.');
      }
    }
  }
}
function saveAsTool(mode){
  if(opensApl[currentIndex]!=null){
    switch(opensApl[currentIndex].type){
      case "portlet":
      case 'decorators':
      case 'interfaces':
          if(getFrameObj('portalstudioframe'+currentIndex).currentname.indexOf("/jsp-decorators")>-1){
            openWin('../portalstudio/saveas.jsp?tool=decorators');
          } else if(mode == "variant" ) {
            let folder_path = getFrameObj('portalstudioframe'+currentIndex).currentname;
            openWin('../portalstudio/saveas.jsp?tool=variant&folder_path=' + folder_path );
          } else if (mode == "interfaces" || opensApl[currentIndex].type == 'interfaces' || !Empty(getFrameObj('portalstudioframe'+currentIndex).formProp.altInterfaceFor)){
            let folder_path = getFrameObj('portalstudioframe'+currentIndex).formProp.altInterfaceFor;
            let custom = getFrameObj('portalstudioframe'+currentIndex).formProp.custom;
            openWin('../portalstudio/saveas.jsp?tool=interfaces&folder_path=' + folder_path + "&custom=" +  custom);
          } else{
            openWin('../portalstudio/saveas.jsp?tool=portlet');
          }
        break;
      case "visualquery":
          getFrameObj('portalstudioframe'+currentIndex).GetFilename('saveas');
        break;
      case "pagelet":
          openWin('../portalstudio/saveas.jsp?tool=pagelet');
        break;
      case "pageleteditor":
          openWin('../portalstudio/saveas.jsp?tool=pageleteditor');
        break;
      case "manualjsp":
          openWin('../portalstudio/saveas.jsp?tool=manualjsp');
        break;
      case "css":
          openWin('../portalstudio/saveas.jsp?tool=css');
        break;
      case "cssclass":
          getFrameObj('portalstudioframe'+currentIndex).saveAsLayer();
        break;
      case "chart":
        getFrameObj('portalstudioframe'+currentIndex).saveAs();
      break;
      case "plan":
          openWin('../portalstudio/saveas.jsp?tool=plan&mode='+mode);
        break;
      case "report":
          getFrameObj('portalstudioframe'+currentIndex).saveAs()
          break;
      case "scandoc":
          openWin('../portalstudio/saveas.jsp?tool=scandoc');
        break;
      case "smartreport":
        getFrameObj('portalstudioframe'+currentIndex).reportsaveAs();
      break;
      case "module":
          openWin('../portalstudio/saveas.jsp?tool=module');
        break;
      case "menu":
          getFrameObj('portalstudioframe'+currentIndex).saveAs()
        break;
      case "portalzoom":
      case "visualpivot":
         getFrameObj("portalstudioframe"+currentIndex).saveAs();
        break;
      case "maskparameters":
          getFrameObj("portalstudioframe"+currentIndex).saveAs();
        break;
    }
  }
}

function preview(tmp,skinName) {
  if(opensApl[currentIndex]!=null){
    var name=opensApl[currentIndex].name;
    var _path=opensApl[currentIndex].parms.folder_path;
    if(typeof(_path)=='undefined') _path='';
    if(_path.indexOf('/')==0 && _path.length==1) _path='';
    var iframe_tool=getFrameObj('portalstudioframe'+currentIndex);
    var saveChanges=false;
    if(!tmp)
      if(iframe_tool.m_bUpdated==true && iframe_tool.currentname!=''){
        saveChanges=confirm("Do you want to save "+opensApl[currentIndex].name+"?");
        if(saveChanges)
          saveTool();
      }else if(iframe_tool.currentname==''){
        saveAsTool()
        return
      }

    if(is_Saving==true){
       window.setTimeout("preview(true);",200);
       return;
    }
    var url, page;
    switch(opensApl[currentIndex].type){
      case "portlet":
        _path=_path=='jsp-system'?'-system':_path
        url='../jsp'+_path+'/'+name+'_portlet.jsp';
        let param = [];
        skinName ? param.push('forcedSkin='+skinName) : "";
        if( iframe_tool.mode == "HTML" && iframe_tool.current_variant > 0 ) {
          param.push("m_cVariant="+iframe_tool.variants[iframe_tool.current_variant].name);
          if( iframe_tool.variants[iframe_tool.current_variant].folder_path ){
            param.push("m_cVariantFolder=/"+iframe_tool.variants[iframe_tool.current_variant].folder_path);
          }
        }
        if ( param.length ){
          url += "?" + param.join("&");
        }
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(Trim(iframe_tool.formProp.cache_time) != '')  page.history.go();
      break;
      case "pagelet":
        if(!EmptyString(_path)) _path=_path.substring(0,_path.lastIndexOf('/'))
        url='../jsp'+_path+'/'+name+'.jsp';

        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(Trim(iframe_tool.pageletProp[0].cache_time) != '')  page.history.go();
      break;
      case "pageleteditor":
        if(!EmptyString(_path)) _path=_path.substring(0,_path.lastIndexOf('/'))
        url='../jsp'+_path+'/'+name+'.jsp';

        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(Trim(iframe_tool.formProp.cache_time) != '')  page.history.go();
      break;
      case "manualjsp":
        if(name.indexOf('.jsp')>-1 || name.indexOf('.htm')>-1)
          url='../jsp'+_path+'/'+name;
        else
          url='../jsp'+_path+'/'+name+'.jsp';
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(iframe_tool.PageCacheTime != 0) page.history.go();
      break;
      case "cssclass":
        iframe_tool.previewCss();
      break;
      case "visualquery":
        getFrameObj('portalstudioframe'+currentIndex).ExecuteSQL();
      break;
      case "module":
        url='../servlet/JSPModEditorPrev?name='+name+'&m_NoCache='+LibJavascript.AlfaKeyGen(10);
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
      break;
      case "report":
        url=getFrameObj('portalstudioframe'+currentIndex).createPreviewLink();
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
      break;
      case "scandoc":
          getFrameObj('portalstudioframe'+currentIndex).Preview(saveChanges);
      break;
      case "smartreport":
        url='../servlet/Report?ReportName='+name+'&bPreview=true&isSmartReport=true&m_NoCache='+LibJavascript.AlfaKeyGen(10);
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
      break;
      case "maskparameters":
        url='../jsp/SPMaskParameters_portlet.jsp?ConfigName='+name+'&custom='+getFrameObj('portalstudioframe'+currentIndex).formProp.customVdm;
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(Trim(iframe_tool.formProp.cache_time) != '')  page.history.go();
      break;
      case "portalzoom":
        var zoomName=name.split('[')[0], tableName=name.split('[')[1];
        tableName=tableName.substring(0,tableName.length-1);
        var custom=opensApl[currentIndex].parms.custom;
        url='../jsp/SPPortalZoom.jsp?Table='+tableName+'&ConfigName='+(custom?'1/':'0/')+zoomName+'&tpl=SPPortalZoom_tpl';
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(Trim(iframe_tool.formProp.cache_time) != '')  page.history.go();
      break;
      case "interfaces":
        url='../servlet/' + Trim(iframe_tool.formProp.altInterfaceFor) + '?m_cAltInterface=' + (iframe_tool.formProp.custom == 'true' ? 'custom_' + iframe_tool.currentInstance + '/' : '') + 'jsp-interfaces/' + Trim(iframe_tool.formProp.altInterfaceFor) + '/' + name + '_portlet.jsp';
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(Trim(iframe_tool.formProp.cache_time) != '')  page.history.go();
      break;
	  case "visualpivot":
        url='../jsp/SPVisualPivot.jsp?ConfigName='+/*URLenc(*/getFrameObj('portalstudioframe'+currentIndex).GetConfigName()/*)*/+'&tpl=SPVisualPivot_tpl';
        page=window.open(url,'Preview','status=yes,toolbar=no,menubar=yes,location=yes,resizable=yes,scrollbars=yes',true);
        if(Trim(iframe_tool.formProp.cache_time) != '')  page.history.go();
      break;
    }
  }
}

function deleteFile() {
  if(opensApl[currentIndex]!=null){
    var name = opensApl[currentIndex].name;
    var path = getPainterPath(opensApl[currentIndex].parms.folder_path||'',opensApl[currentIndex].type)
    var custom=opensApl[currentIndex].parms.custom
    var offline=opensApl[currentIndex].parms.offlinemode
    if(opensApl[currentIndex].type=="cssclass" && name.indexOf("styles/") > -1) {
      name = name.substring(name.indexOf("styles/")+7);
    }
    if(confirm("Are you sure to delete "+name+" ?")){
      var deleteResponse;
      var typeError=false;
      getFrameObj("portalstudioframe"+currentIndex).m_bUpdated=false
      switch(opensApl[currentIndex].type){
        case "portlet":
        case "decorators":
        case "interfaces":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+path+name+"_portlet.jsp");
          deleteResponse = deleteResponse.Response();
          break;
        case "plan":
          //estrae la lista di .jsp da cancellare
          var Pagelist=getFrameObj("portalstudioframe"+currentIndex).itemsHTML
          var DeletedList=new Array()
          var uu=0
          for(var u=0;u<Pagelist.length;u++){
            if(Pagelist[u].type=='Page'){
              DeletedList[uu]=Pagelist[u].name;uu++;
            }
          }
          var dellist=DeletedList.join(",");
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".plandef&dellist="+dellist);
          deleteResponse = deleteResponse.Response();
          break;
        case "pagelet":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+path+name+".jsp");
          deleteResponse = deleteResponse.Response();
          break;
        case "pageleteditor":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+path+name+".jsp");
          deleteResponse = deleteResponse.Response();
          break;
        case "manualjsp":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+path+name+".jsp");
          deleteResponse = deleteResponse.Response();
          break;
        case "css":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+path+'styles/'+name+".css");
          deleteResponse = deleteResponse.Response();
          break;
        case "cssclass":
          var skins = new JSURL("../servlet/JSPReader?type=themes",true).Response().split(",");
          for (var i = skins.length - 1; i >= 0; i--) { // cancello tutti i fogli stile che trovo all'interno degli skin
            if(!Empty(skins[i])) {
              new JSURL("../servlet/JSPDelete?name="+skins[i]+"/styles/"+name+".ce.css").Response();
            }
          }
          deleteResponse = new JSURL("../servlet/JSPDelete?name=styles/"+name+".ce.css");
          deleteResponse = deleteResponse.Response();
          break;
        case "chart":/*EGhisalberti edited*/
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".chartdef");
          deleteResponse = deleteResponse.Response();
          break;
        case "visualquery":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".vqr&offlinemode="+offline+"&custom="+custom);
          deleteResponse = deleteResponse.Response();
          break;
        case "report":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".vrp&custom="+custom);
          deleteResponse = deleteResponse.Response();
          break;
        case "portalzoom":
          name=Strtran(Strtran(name,"]","_"),"[",".")
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+"vzm&custom="+custom);
          deleteResponse = deleteResponse.Response();
          break;
        case "scandoc":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".sca");
          deleteResponse = deleteResponse.Response();
          break;
        case "smartreport":
          deleteResponse = new JSURL("../servlet/JSPDelete?name=" + name + ".svrp&custom=" + custom);
          deleteResponse = deleteResponse.Response();
          break;
        case "module":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".mrp");
          deleteResponse = deleteResponse.Response();
          break;
        case "maskparameters":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".vdm&custom="+custom);
          deleteResponse = deleteResponse.Response();
          break;
        case "menu":
          deleteResponse = new JSURL("../servlet/JSPDelete?name="+name+".vmn&custom="+custom+"&offlinemode="+offline);
          deleteResponse = deleteResponse.Response();
          break;
        case "visualpivot":
          deleteResponse = new JSURL("../servlet/JSPDelete?name=" + name + ".vpv&custom=" + custom);
          deleteResponse = deleteResponse.Response();
          break;
        default:
          typeError=true;
          break;
      }
      if(!typeError){
        if(deleteResponse=="error")
          alert("Error deleting file...");
        else {
          RemoveRecent(opensApl[currentIndex].type,opensApl[currentIndex],opensApl[currentIndex].parms);
          if (getFrameObj('project_view_frame').addRemoveFileInTreeView)
            getFrameObj('project_view_frame').addRemoveFileInTreeView('remove',opensApl[currentIndex]);
          closeCurrentObj();
        }
      }
    }
  }
}

function securityAdmin() {
  if(opensApl[currentIndex]!=null){
    var name = opensApl[currentIndex].name;
    switch(opensApl[currentIndex].type){
      case "portlet": case "pagelet": case "pageleteditor" :
        var url='../servlet/SPManageProcedureSecurity?progname=ps/'+name;
        window.open(url,null,'width=600,height=600,top=100,left=200,status=no,toolbar=no,menubar=no,location=no');
        break;
      case "visualquery":
        getFrameObj('portalstudioframe'+currentIndex).SetSecurity();
        break;
    }
  }
}
function generatePortlets() {
  var mar_left = 100, width = document.getWidth() - mar_left*2;
  var mar_top = 75, height = document.getHeight() - mar_top*2;
  openSPModalLayer("../servlet/JSPGenerate", mar_top, mar_left, width, height, true, 1, false, true);
}
function setTitle(pageObj){
  var DocTitle = pageObj.document.title;
  if (DocTitle == "") {
    DocTitle = "Sitepainter Infinity PortalStudio"
    Ctrl("title").removeClass('editor-open');
  }else{
    Ctrl("title").addClass('editor-open');
  }
  Ctrl("title").innerHTML = DocTitle;
}

function changeName(name,parms,m_index){
  if(m_index==null)m_index=currentIndex;
  if (typeof(parms)=='string')
    parms={folder_path:parms}
  else parms=parms||{}
  if (parms.custom && typeof parms.custom == 'string')
    parms.custom=parms.custom=='true'?true:false
  if (parms.offlinemode && typeof parms.offlinemode == 'string')
    parms.offlinemode=parms.offlinemode=='true'?true:false
  changeName2(name,parms,m_index)
  if (getFrameObj('project_view_frame').addRemoveFileInTreeView)
    getFrameObj('project_view_frame').addRemoveFileInTreeView('add',opensApl[m_index]);
}

function changeName2(name,parms,m_index){
  if(opensApl[m_index]){
	  opensApl[m_index].name=name;
	  opensApl[m_index].parms=parms;
	  var title, _path;
	  /*if(opensApl[currentIndex].type=='visualquery' || opensApl[currentIndex].type=='chart' || opensApl[currentIndex].type=='css' || opensApl[currentIndex].type=='portalstudio')
		title=name
	  else
		title='jsp'+path+'/'+name*/
	  if(name.indexOf('/')>-1)
      name=name.substring(name.lastIndexOf("/")+1);
	  else if(name.indexOf("\\")>-1)
      name=name.substring(name.lastIndexOf("\\")+1);
    if(typeof(parms.folder_path)=='undefined')
      _path='jsp/';
    else if(opensApl[m_index].type=='visualquery' ||
            opensApl[m_index].type=='chart' /* || opensApl[i].type=='css' */ ||
            opensApl[m_index].type=='maskparameters' ||
            opensApl[m_index].type=='smartreport' ||
            opensApl[m_index].type=='visualpivot' ||
            opensApl[m_index].type=='css')
      _path=parms.folder_path
    else if (opensApl[m_index].type=='portalzoom')
      _path=parms.folder_path.substring(1);
    else
      _path='jsp'+getPainterPath(parms.folder_path,opensApl[m_index].type);
    if(_path.lastIndexOf('/') != _path.length - 1)
      _path += '/'
	  title = _path + name;
	  $("tab_"+m_index).getElement('span').set('text',name);
	  $("tab_"+m_index).getElement('span').set('title',title);
  }
}

function imgAdmin() {
  var height = 565;
  var mar_left = 50, width = window.getWidth() - mar_left*2;
  var url = "../jsp-system/SPImagesReader_portlet.jsp";
  openSPModalLayer(url, null, null, width, height, true, 1, false, true);
}

function CopyPaste(a,b) {
	notimooManager.show({
		title:'Notification message',
		message:  (b) ? 'Item/s has been cutted' : ((!a) ? 'Item/s has been pasted' : 'Item/s has been copied'),
		sticky : false,
		visibleTime:1000,
		width:200,
		height:40
	});
	if(a){
		if(getFrameObj('portalstudioframe'+currentIndex).Copy) deftmp=getFrameObj('portalstudioframe'+currentIndex).Copy(b)
	}else{
		if(getFrameObj('portalstudioframe'+currentIndex).Paste) getFrameObj('portalstudioframe'+currentIndex).Paste(deftmp)
	}
}

function Undo() {
  if(getFrameObj('portalstudioframe'+currentIndex).Undo) getFrameObj('portalstudioframe'+currentIndex).Undo()
  notimooManager.show({
	   title:'Notification message',
	   message: 'Undo action done',
	   sticky : false,
	   visibleTime:1000,
	   width:200,
	   height:40
	});
}

function Redo() {
  if(getFrameObj('portalstudioframe'+currentIndex).Redo) getFrameObj('portalstudioframe'+currentIndex).Redo()
  notimooManager.show({
	   title:'Notification message',
	   message: 'Redo action done',
	   sticky : false,
	   visibleTime:1000,
	   width:200,
	   height:40
	});
}

function openHelp() {
  windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm','','toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
}

function toggleToolbarBig(){
  var bd = document.body;
	if( bd.classList.contains("toolBig-opened")){
      bd.classList.remove("toolBig-opened");
  } else {
	  bd.classList.add("toolBig-opened");
  }
  ResizePS();
}

function searchCurrentObjIndex(name,type){
  for(var i=0;i<opensApl.length;i++){
    if(opensApl[i]!=null && type==opensApl[i].type && name==opensApl[i].name){
      return i;
      break;
    }
  }
  return null;
}

function selectCurrentObj(index,name,type){
  if(!is_Saving){
    if(index!=null)
      currentIndex=index;
    else if(name!=null){
      if(searchCurrentObjIndex(name,type)!=null)
        currentIndex=searchCurrentObjIndex(name,type);
      else{
        newCurrentObj(name,type);
        return;
      }
    }
    $$(".tab.selected").removeClass("selected");
    for(var i=0;i<opensApl.length;i++){
      if(opensApl[i]!=null && i!=currentIndex){
        Ctrl('portalstudioframe'+i).style.display='none'
      } else if(opensApl[i]!=null && i==currentIndex) {
        $('tab_'+i).addClass("selected");
        Ctrl('portalstudioframe'+i).style.display='block'
        if(getFrameObj('portalstudioframe'+i) ) {
          if(getFrameObj('portalstudioframe'+i).document.title!=null){
            setTitle(getFrameObj('portalstudioframe'+i))
          }
          /**
           * Al cambio iframe chiamo una funzione per cambiare il menu
           */
          modifyMenu( opensApl[i].type)
        }
      }
    }
  }
  document.id("project_view_container").removeClass("opened");
  if  (document.id("open_pv")){
    document.id("open_pv").title='Open Project view';
  }
}

var PaintersMenu = function( rootID ){

  this.menu = {};
  var htmlRoot = document.getElementById( rootID );

  this.setDefault = function() {
    this.menu = [
      { id: "file-picker", title: "File", classname: "menu-item menu-picker", accesskey: "f", text: "<u>F</u>ile", items: [
          { classname: "menu-item first-item menu-picker menu-item-parent", id: "tools-picker", text: "New", items: [
              { classname: "menu-item first-item", id: "tool-portlet", text: "Portlet", event: function(){newCurrentObj('New','portlet');} },
              { classname: "menu-item", id: "tool-pagelet", text: "Pagelet", event: function(){selecttemplate('');} },
              { classname: "menu-item", id: "tool-plan", text: "Plan", event: function(){newCurrentObj('New','plan');} },
              { classname: "menu-item", id: "tool-vqr", text: "Visual Query", event: function(){newCurrentObj('New','visualquery');} },
              { classname: "menu-item", id: "tool-pzoom", text: "Portal Zoom", event: function(){openWin('../portalzoom/new.jsp');} },
              { classname: "menu-item", id: "tool-page", text: "Manual jsp", event: function(){newCurrentObj('New','manualjsp');} },
              { classname: "menu-item", id: "tool-report", text: "Report", event: function(){newCurrentObj('New','report');} },
              { classname: "menu-item", id: "tool-smartreport", text: "SmartReport", event: function(){newCurrentObj('New','smartreport');} },
              { classname: "menu-item", id: "tool-chart", text: "Chart", event: function(){newCurrentObj('New','chart');} },
              { classname: "menu-item", id: "tool-module", text: "Module", event: function(){newCurrentObj('New','module');} },
              { classname: "menu-item", id: "tool-menu", text: "Menu", event: function(){newCurrentObj('New','menu');} },
              { classname: "menu-item", id: "tool-sca", text: "ScanDoc", event: function(){newCurrentObj('New','scandoc');} },
              { classname: "menu-item", id: "tool-css", text: "Manual Css", event: function(){newCurrentObj('New','css');} },
              { classname: "menu-item", id: "tool-cssclass", text: "Css Class", event: function(){newCurrentObj('New','cssclass');} },
              { classname: "menu-item", id: "tool-maskparameters", text: "Mask Parameters", event: function(){newCurrentObj('New','maskparameters');} },
              { classname: "menu-item", id: "tool-visualpivot", text: "VisualPivot", event: function(){newCurrentObj('New','visualpivot');} },
              { classname: "menu-item menu-picker last-item menu-item-parent", id: "offline-tools-picker", text: "Offline tools", items: [
                  { classname: "menu-item first-item", id: "tool-vqr-offline", text: "Visual Query", event: function(){newCurrentObj('New','visualquery', {offlinemode: true});} },
                  { classname: "menu-item", id: "tool-pzoom-offline", text: "Portal Zoom", event: function(){openWin('../portalzoom/new.jsp?offlinemode=true');} }
                ]
              }
            ]
          },
          { classname: "menu-item menu-picker menu-item-parent", id: "recent-picker", accesskey: "r", text: "Recent" },
          { classname: "menu-item", id: "open", text: "Open", event: function(){openWin('open.jsp');} },
          { classname: "menu-item", id: "save", text: "Save", event: function(){saveTool();} },
          { classname: "menu-item", id: "saveas", text: "Save As", event: function(){saveAsTool();} },
          { classname: "menu-item", id: "saveall", text: "Save All", event: function(){saveAll();} },
          { classname: "menu-item", id: "delete", text: "Delete", event: function(){deleteFile();} },
          { classname: "menu-item last-item", id: "close", text: "Close", event: function(){closeCurrentObj();
            }
          }
        ]
      },
      { id: "edit-picker", classname: "menu-item menu-picker", accesskey: "e", text: "<u>E</u>dit", items: [
          { classname: "menu-item first-item", id: "cut", text: "Cut", event: function(){CopyPaste(true,true);} },
          { classname: "menu-item", id: "copy", text: "Copy", event: function(){CopyPaste(true,false);} },
          { classname: "menu-item", id: "paste", text: "Paste", event: function(){CopyPaste(false);} },
          { classname: "menu-item", id: "undo", text: "Undo", event: function(){Undo();} },
          { classname: "menu-item last-item", id: "redo", text: "Redo", event: function(){Redo();
            }
          }
        ]
      },
      { id: "advanced-picker", classname: "menu-item menu-picker", accesskey: "a", text: "<u>A</u>dvanced", items: [
          { classname: "menu-item first-item", id: "preview", text: "Preview", event: function(){preview();} },
          { classname: "menu-item", id: "imgadmin", text: "Images administration", event: imgAdmin },
          { classname: "menu-item", id: "security", text: "Security administration", event: securityAdmin },
          { classname: "menu-item last-item", id: "generatejsp", text: "Generate JSP", event:  generatePortlets }
        ]
      },
      { id: "help-picker", classname: "menu-item menu-picker", text: "?", items: [
          { classname: "menu-item first-item", id: "online-help", text: "Online Help", event: openHelp },
          { classname: "menu-item last-item", id: "about", text: "About", event: openAbout }
        ]
      }
    ];
  }

  this.render = function() {
    var level = 0,
      ul = document.createElement("ul");
    ul.setAttribute("level", level);
    function renderItem(item, level) {
      var li = document.createElement("li");
      li.className = item.classname;
      if ( item.accesskey ){
        li.accesskey = item.accesskey;
      }
      li.innerHTML = item.text;
      li.id = item.id;

      li.addEventListener( "click", function( item ){
        if( item.event ) {
          item.event.call();
          /**
           * chiudo tutti tranne il corrente del click
           */
          [].forEach.call( htmlRoot.querySelectorAll(".show") , function(el) {
            el.classList.remove("show");
          })
        }
       }.bind(li, item) );

      li.addEventListener( "mouseenter",  function(){
        var parents = [],
          parent = this.parentElement;
        while( parent != htmlRoot) {
        	parents.push(parent);
        	parent = parent.parentElement;
        }

        [].forEach.call( htmlRoot.querySelectorAll(".show:not([level='0'])"), function(el) {
          if( parents.indexOf(el) == -1 ){
            el.classList.remove("show");
          }
        })
        if( this.querySelector("ul")){
          clearTimeout(this.timer);
          this.querySelector("ul").classList.add("show");
        }
       })
      li.addEventListener( "mouseleave",  function(){
        if( this.querySelector("ul") ){
          this.timer = setTimeout( function() {
            this.querySelector("ul").classList.remove("show");
          }.bind(this), 800)
        }
       })
      if ( typeof(item.items) == "function") {
        /**
         * Caricamento recenti
         */
        item.items = item.items.call();
      }
      if ( Array.isArray(item.items) ) {
        level++;
        var ul = document.createElement("ul");
        ul.setAttribute("level", level);
        item.items.forEach( function(child){ ul.appendChild(renderItem(child,level)); })
        li.appendChild(ul);
      }
      return li;
    }

    this.menu.forEach( function(item) {
      var li = renderItem( item, level);
      ul.appendChild( li );
    })
    htmlRoot.innerHTML = "";
    htmlRoot.appendChild(ul);
  }

  this.getNode = function(id) {
    var found  = null;
    function find(nodes, id){
      if( !found ){
        nodes.forEach( function(item) {
          if( !found && item.id == id){
            found = item;
          } else if( !found && item.items ){
            find(item.items, id);
          }
        })
      }
    }
    find(this.menu, id);
    return found;
  }

  this.setDefault();
  this.render();
}
/**
 * Reset menu to default's values
 */
PaintersMenu.prototype.reset = function() {
  this.setDefault();
  this.render();
}
/**
 * Repaint menu
 */
PaintersMenu.prototype.refresh = function() {
  this.render();
}
/**
 * Append action to menu in parent node
 * @param {Object[]} actions - Nodes to insert in parent node item
 * @param {string} actions[].id - ID of the action
 * @param {string} actions[].text - The caption of the action
 * @param {string} actions[].className - The className for the action
 * @param {function} actions[].event - The action
 * @param {string} parent - Parent node's ID where insert nodes
 */
PaintersMenu.prototype.appendActions = function( actions, parent ) {
  var parentNode = this.getNode( parent );
  if( parentNode ){
    if( !parentNode.items ) {
      parentNode.items = [];
    }
    parentNode.items = parentNode.items.concat( actions );
  }
}


function modifyMenu( type ){
  paintersMenu.reset();
  setRecentDiv();
  switch( type ){
    case 'portlet':
      // paintersMenu.appendActions([
      //   { classname: "menu-item last-item", id: "htmlmode", text: "HTML mode", event:  function(){ getFrameObj('portalstudioframe'+currentIndex).toggleHTMLMode(); } }
      // ], "advanced-picker");
    break;
  }
  paintersMenu.refresh();
}



function tabHTML(i){
  var _path;
  var editorObj= opensApl[i];
  if(typeof(editorObj.parms.folder_path)=='undefined') _path='jsp/'
  else if(editorObj.type=='visualquery' || editorObj.type=='chart' /* || editorObj.type=='css' */ || editorObj.type=='maskparameters' || editorObj.type=='smartreport' || editorObj.type=='visualpivot')
    _path=editorObj.parms.folder_path
  else if (editorObj.type=='portalzoom')
    _path=editorObj.parms.folder_path.substring(1);
  else if(editorObj.type=='css')
   _path=editorObj.parms.folder_path +'/styles/';
  else if(editorObj.type=='interfaces')
   _path=getPainterPath(editorObj.parms.folder_path,editorObj.type);
  else
    _path='jsp'+getPainterPath(editorObj.parms.folder_path,editorObj.type);

  if(_path.lastIndexOf('/') != _path.length - 1)
    _path += '/'

  var name=editorObj.name
  var tab = new Element('div',{'id':'tab_'+i,'class':'tab','tabindex':i})
    .addEvents({'click':function(){
                  selectCurrentObj(this.getAttribute('tabindex'));
                }
    })
    .grab( new Element('div',{'class':'tabflexbox'})
      .grab( new Element('div',{'class': 'type','text': editorObj.type.capitalize()}))
      .grab( new Element('span',{'class': 'tabname','text': name, 'title': _path+name}))
    )
    .grab( new Element('div',{'class':'closetab','title':'close current '+editorObj.type})
          .addEvents({
            'click':function(event){
              event.stopPropagation();
              closeCurrentObj();
            }
          })
    );
	return tab;
}

function writeAllIframes(){
  for(var i=0;i<opensApl.length;i++){
    if(opensApl[i]!=null && i==currentIndex){
      // Ctrl("portalstudioframe"+i).src=opensApl[i].src+(opensApl[i].parms!=null?opensApl[i].parms:"")
      Ctrl("portalstudioframe"+i).src=opensApl[i].src
      tabHTML(i).inject($('tabcontainer'));
    }
  }
  selectCurrentObj()
}

function openWin(url){
  var tool="";
  if(opensApl[0]!=null)
    tool=opensApl[currentIndex].type;
  if(url=='open.jsp'){
    openSPModalLayer(url+"?tool="+tool, null, null, 1000, 650, true, 1, false, false);
  }else{
    openSPModalLayer(url, null, null, 580, 700, true, 1, false, false);
  }
}
// Functions imported from Controls and stdFunctions
function getFrameObj(framename) {
  var i = 0
  var idx = null
  var frm = window.frames
  if (document.all){
    return frm[framename]
  } else {
    while (i<frm.length && idx==null){
      if (frm[i].name == framename) idx = i
      i++;
    }
    if (idx != null) return window.frames[idx]
  }
}

function Right(str,len) {
  if (typeof str=="string") {
    return(str.substr(str.length-len))
  } else {
    return ""
  }
}

function showBtnText(id,w,len){
	var btnTxt = document.getElementById(id);
	w=w+10;
	if(w>len){
		btnTxt.style.width = parseInt(len+10)+"px";
		return;
	}
	btnTxt.style.width = w+"px";
	setTimeout("showBtnText('"+id+"',"+(w)+","+(len)+")",2);
}

function hideBtnText(id,w,len,elemId){
	var btnTxt = document.getElementById(id);
	w=w-10;
	if(w<0){
		btnTxt.style.display = "none";
		btnTxt.style.width = len+"px";
		document.getElementById(elemId).style.backgroundPosition = "left";
		return;
	}
	btnTxt.style.width = w+"px";
	setTimeout("hideBtnText('"+id+"',"+(w)+","+(len)+",'"+elemId+"')",2);
}

function changePic(/*elem*/){
	// elem.style.backgroundPosition = "right";
	// var txtBtn = document.getElementById(elem.id+"Txt");
	// txtBtn.style.display = "block";
	// var len = txtBtn.offsetWidth;
	// if(!(elem.id in btnTxtsLengths)){
		// btnTxtsLengths[elem.id] = len;
	// }
	// document.getElementById(elem.id+"TxtWrapper").style.width = btnTxtsLengths[elem.id] + "px";
	// txtBtn.style.width = "0px";
	// openTextTO = setTimeout("showBtnText('"+txtBtn.id+"',0,"+btnTxtsLengths[elem.id]+")",300);
	//txtBtn.style.width = "100px";
}

function resetPic(/*elem*/){
	// var txtBtn = document.getElementById(elem.id+"Txt");
	// clearTimeout(openTextTO);
	// hideBtnText(txtBtn.id,txtBtn.offsetWidth,txtBtn.offsetWidth,elem.id);
	//txtBtn.style.width = "100px";
}

this.cancelEvent = function (e){
  // blocca la propagazione
  e = (e) ? e : window.event;
//e.cancelBubble = true;
if (window.event)
	window.event.cancelBubble = true;
else
	e.cancelBubble = true;
  if (e.stopPropagation) e.stopPropagation();
  e.returnValue=false
}

function selecttemplate(retTo,frontendport){
  window.layerOpenForeground("../portalstudio/select_template.jsp?frontendport="+frontendport,"select_template",'',620,280,true,1);
}
var m_nPreferredHeight=0;
function GetWindowPreferredSize(){
  return {'h':900,'w':1200}
}


function manageItems(e/*,notResize*/){
  var domevt = new DOMEvent(e);
  var managed = false;

  if(domevt.control && domevt.code==86) { // CTRL-V
    CopyPaste(false);
    managed=true;
  } else if (domevt.control && domevt.code==83) { // CTRL-S
    saveTool();
    managed=true;
  } else if (domevt.control && domevt.code==67) { // CTRL-C
    CopyPaste(true,false);
    managed=true;
  } else if (domevt.control && domevt.code==88) { // CTRL-X
    CopyPaste(true,true);
    managed=true;
  }

  if (managed) {
    domevt.stop();
  }
}

window.addEvent('domready',function(){
	notimooManager = new Notimoo({});
  paintersMenu = new PaintersMenu("paintersMenu");

	setRecentDiv();
  /* Ex doLoad() */
  document.body.onhelp=CancelHelp
  ResizePS();
  PreloadTool();
  /* End Ex doLoad()*/
});
