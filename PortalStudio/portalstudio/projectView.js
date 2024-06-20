/* exported resizeHeight setSearchFocus addRemoveFileInTreeView toggleTree */
var projectTree, userTree, customTree, listFiles={}, loadEditor={}, projectStructure={};

function refreshTreeheight(){
  if (projectTree)
    projectTree.refreshHeight();
  if (userTree)
    userTree.refreshHeight();
}

function resizeHeight(h){
  document.id('tree_container').style.height=(h-40)+'px';
  document.id('userTree_container').style.height=(h-40)+'px';
  document.id('customTree_container').style.height=(h-40)+'px';
  refreshTreeheight();
}

function setSearchFocus(){
  if (document.id("pv_btn").hasClass('tabSelected')){
    projectTree.searchInput.focus();
  }
  else
    userTree.searchInput.focus();
}

function openFile(fileName,type,props){
  if (window.parent && window.parent.newCurrentObj)
    window.parent.newCurrentObj(fileName,type,props);
  else{
    window.open(getOpenUrl(fileName,type,props));
  }
}

var painterList={
  portlet:{nodeName:'Portlet',index:0},
  pagelet:{nodeName:'Pagelet',index:1,skin:true,jsp_system:true},
  plan:{nodeName:'Plan',index:2},
  query:{nodeName:'Query',index:3,on_off:true,custom:true},
  zoom:{nodeName:'Zoom',index:4,custom:true,user_group:true},
  report:{nodeName:'Report',index:5,custom:true},
  smartreport:{nodeName:'SmartReport',index:6,custom:true},
  chart:{nodeName:'Chart',index:7,custom:true,user_group:true},
  module:{nodeName:'Module',index:8},
  scan:{nodeName:'Scan',index:9},
  menu:{nodeName:'Menu',index:10,on_off:true,custom:true,user_group:true,company:true},
  decorators:{nodeName:'Decorators',index:11,skin:true},
  cssclass:{nodeName:'CSS Class',index:12,skin:true},
  maskparameters:{nodeName:'Mask parameters',index:13,custom:true,user_group:true},
  interfaces:{nodeName:'Interfaces',index:14},
  visualpivot:{nodeName:'VisualPivot',index:15,custom:true}
  
}
var userStructure={}

function loadFiles(){
  for (var painter in painterList){
    if (painterList[painter].on_off && painterList[painter].custom){ // menu, query
      var mode=["online","offline"];
      if (!listFiles[painter])
        listFiles[painter]={};
      for (var j=0; j<mode.length; j++){
        if (!listFiles[painter][mode[j]]) {
          listFiles[painter][mode[j]]={}
          getPainterFiles(painter,{offlinemode:mode[j]=='Offline',custom:false},true)
        }
        if (!listFiles[painter][mode[j]].customFiles)
          getPainterFiles(painter,{offlinemode:mode[j]=='Offline',custom:true},true);
      }
    }
    else if (painterList[painter].custom){ //zoom,report,maskparameters,chart,smartReport
      if (!listFiles[painter]){
        listFiles[painter]={}
        getPainterFiles(painter,{custom:false},true);
      }
      if (!listFiles[painter].customFiles)
        getPainterFiles(painter,{custom:true},true);
    }
    else {
      if (!listFiles[painter]){
        listFiles[painter]={}
        getPainterFiles(painter,{},true)
      }
    }
  }
  if (!listFiles.portlet.jspSystemFiles){
    getPainterFiles('portlet',{jsp_system:true},true)
  }
}

function getPainterFiles(type,parameter,async){
  var files=[],jsUrlStr='', jsurl;
  type=Strtran(Lower(type),' ','');
  parameter=parameter||{};
  if (!painterList[type])
    return files;
  else if (painterList[type].custom){
    if (painterList[type].on_off){ //query,menu
      jsUrlStr=getJsUrl(type,parameter)[0]
      var line=parameter.offlinemode?'offline':'online'
      if (async){
        jsurl = new JSURL(jsUrlStr,true, function (response){
          var typeFiles=parameter.custom?'customFiles':'files'
          var myArr=parameter.custom?[]:['Custom']
          if (!listFiles[type][line][typeFiles]){
            if (type=='query')
              eval("files="+response.Response());
            else files=response.Response().split(',');
            listFiles[type][line][typeFiles]=myArr.concat(files);
          }
        })
      }
      else {
        jsurl = new JSURL(jsUrlStr,true)
        if (type=='query')
          eval("files="+jsurl.Response());
        else files=jsurl.Response().split(',');
        if (!parameter.custom)
          files=['Custom'].concat(files)
      }
    }
    else { // maschere, chart, report, smartreport
      jsUrlStr=getJsUrl(type,parameter)[0]
      if (async){
        jsurl = new JSURL(jsUrlStr,true, function (response){
          var typeFiles=parameter.custom?'customFiles':'files'
          var myArr=parameter.custom?[]:['Custom']
          if (!listFiles[type][typeFiles])
            listFiles[type][typeFiles]=myArr.concat(response.Response().split(','));
        });
      }
      else {
        jsurl = new JSURL(jsUrlStr,true);
        files = jsurl.Response().split(',');
        if (!parameter.custom)
          files=['Custom'].concat(files)
      }
    }
  }
  else if (type=='portlet'){
    jsUrlStr=getJsUrl(type,parameter)[0]
    if (async){
      jsurl = new JSURL(jsUrlStr,true, function (response){
        var typeFiles=parameter.jsp_system?'jspSystemFiles':'files'
        var myArr=parameter.jsp_system?[]:showJSPSystem?['jsp-system']:[]
        if (!listFiles[type][typeFiles]){
          listFiles[type][typeFiles]=myArr.concat(response.Response().split(','));
        }
      });
    }
    else {
      jsurl = new JSURL(jsUrlStr,true)
      files = jsurl.Response().split(',');
      if (!parameter.jsp_system && showJSPSystem)
        files=["jsp-system"].concat(files);
    }
  }
  else {
    jsUrlStr=getJsUrl(type,parameter)[0]
    if (async){
      jsurl = new JSURL(jsUrlStr,true, function (response){
        if (!listFiles[type].files){
          listFiles[type].files=response.Response().split(',');
          if (painterList[type].skin)
            listFiles[type].files=getTheme().concat(listFiles[type].files);
          if (painterList[type].jsp_system && showJSPSystem)
            listFiles[type].files=["jsp-system"].concat(listFiles[type].files);
        }
      });
    }
    else {
      jsurl = new JSURL(jsUrlStr,true)
      files = jsurl.Response().split(',');
      if (!parameter.folder_path && painterList[type].skin)
        files=getTheme().concat(files);
      if (!parameter.folder_path && painterList[type].jsp_system && showJSPSystem)
        files=["jsp-system"].concat(files);
    }
  }
  return files;
}

function IsCompany(name){
  return (name.charAt(0)=='c' && parseInt(name.substring(1,name.length),10)==name.substring(1,name.length))
}

function IsGroup(name){
  return (name.charAt(0)=='g' && parseInt(name.substring(1,name.length),10)==name.substring(1,name.length))
}

function IsUser(name){
  return (parseInt(name,10)==name)
}

function getMifTreePropertyObject(name,type,loadable,forceDelete,realName){
  var closeIcon='mif-tree-menu-icon',openIcon='mif-tree-menu-icon';
  type=Lower(type);
  if (type=='company' || type=='group' || type=='user'){
    closeIcon='mif-tree-'+type+'-icon'
    openIcon='mif-tree-'+type+'-icon'
  }
  else if (loadable){
    openIcon='PS-tree-submenu-open-icon'
    closeIcon='PS-tree-submenu-close-icon'
  }
  name=painterList[name]?painterList[name].nodeName:name=='online'?'Online':name=='offline'?'Offline':name;
  return {
    property: {
      name: type=='company'?companyObj[name.substring(1)]||name:type=='user'?userObj[name]||name:type=='group'?groupObj[name.substring(1)]||name:name,
      _name: name,
      $name: realName,
      type: (loadable?[Strtran(type," ",""),'folder']:[Strtran(type," ","")]),
      loadable:loadable,
      forceDelete:true,
      openIcon: openIcon,
      closeIcon: closeIcon
    }
  }
}

function getElementsSorted(object,type){
  if (!object)
    return []
  var keys=Object.keys(object)
  switch (type){
    case "user":
      keys=keys.sort(function (a,b){
        a=userObj[a]||a
        b=userObj[b]||b
        if (a.toLowerCase() < b.toLowerCase()) return -1;
        if (a.toLowerCase() > b.toLowerCase()) return 1;
        return 0;
      });
    break;
    case "group":
      keys=keys.sort(function (a,b){
        a=groupObj[a.substring(1)]||a
        b=groupObj[b.substring(1)]||b
        if (a.toLowerCase() < b.toLowerCase()) return -1;
        if (a.toLowerCase() > b.toLowerCase()) return 1;
        return 0;
      });
    break;
    case "company":
      keys=keys.sort(function (a,b){
        a=companyObj[a.substring(1)]||a
        b=companyObj[b.substring(1)]||b
        if (a.toLowerCase() < b.toLowerCase()) return -1;
        if (a.toLowerCase() > b.toLowerCase()) return 1;
        return 0;
      });
    break;
    default:
      keys=keys.sort(function (a,b){
         if (a.toLowerCase() < b.toLowerCase()) return -1;
          if (a.toLowerCase() > b.toLowerCase()) return 1;
          return 0;
      });
  }
  return keys;
}

function toggleTree(el){
  if (el.id=='uv_btn'){
    document.id('userTree_container').style.display='block';
    document.id('tree_container').style.display='none';
    document.id('customTree_container').style.display='none';
    document.id('pv_btn').removeClass('tabSelected');
    document.id('cv_btn').removeClass('tabSelected');
    document.id('uv_btn').addClass('tabSelected');
    if (!userTree)
      createUserTree();
    userTree.refreshHeight();
    userTree.searchInput.focus();
  }
  else if (el.id=='cv_btn'){
    document.id('customTree_container').style.display='block';
    document.id('tree_container').style.display='none';
    document.id('userTree_container').style.display='none';
    document.id('pv_btn').removeClass('tabSelected');
    document.id('uv_btn').removeClass('tabSelected');
    document.id('cv_btn').addClass('tabSelected');
    if (!customTree)
      createCustomTree();
    customTree.refreshHeight();
    customTree.searchInput.focus();
  }
  else{
    document.id('tree_container').style.display='block';
    document.id('userTree_container').style.display='none';
    document.id('customTree_container').style.display='none';
    document.id('pv_btn').addClass('tabSelected');
    document.id('uv_btn').removeClass('tabSelected');
    document.id('cv_btn').removeClass('tabSelected');
    projectTree.refreshHeight();
    projectTree.refreshNanoScroll();
    projectTree.searchInput.focus();
  }
}

function createTree(container,json){
  var tree = new Mif.Tree.Search({
    container: document.id(container),
    types: {// node types
      folder:{
        openIcon: 'PS-tree-submenu-open-icon',//css class open icon
        closeIcon: 'PS-tree-submenu-close-icon'// css class close icon
      }
    },
    dfltType:'folder',//default node type
    height: 24, //node height,
    nanoScroll:true
  });
  var refreshBtn = new Element('div',{
    'class':'mif-tree-btn-refresh',
    type:'button'
  }).inject(tree.searchBtn,'after');
  refreshBtn.addEvent('click',function(){
    listFiles={};
    tree.searchInput.value='';
    tree.filter(tree.root,"");
    tree.root.toggle(false);
    tree.root.toggle('open');
    tree.refreshNanoScroll();
  })
  tree.load({
    json: json
  });
  tree.root.toggle('open');
  return tree;
}

function addRemoveFileInTreeView(action,obj){
  var name=obj.name
  var type=obj.type
  if (type=='visualquery')
    type='query';
  else if (type=='portalzoom')
    type='zoom'
  else if (type=='scandoc')
    type='scan'
  else if (type=='pageleteditor')
    type='pagelet'
  if (!painterList[type]) return;
  var index=painterList[type].index;
  if (!listFiles[type])
    return;
  function sort(a,b){
     if (a.toLowerCase() < b.toLowerCase()) return -1;
      if (a.toLowerCase() > b.toLowerCase()) return 1;
      return 0;
  }
  function customSort(a,b){
     if (a.name.toLowerCase() < b.name.toLowerCase()) return -1;
      if (a.name.toLowerCase() > b.name.toLowerCase()) return 1;
      return 0;
  }
  function updateTree(tree,node){
    tree.filter(node,filter)
    tree.root.toggle(false)
    tree.root.toggle('open')
    tree.refreshNanoScroll();
  }
  var theme=obj.parms.folder_path || ''
  var custom=obj.parms.custom;
  var line=obj.parms.offlinemode
  var filter=Lower(projectTree.searchInput.get('value'));
  var customFilter=userTree?Lower(userTree.searchInput.get('value')):''
  var fileNameWithExt=getFileNameWithExtension(name,type.toLowerCase(),line)
  var i, ii, update, indexFile, cd, files, updateCustom, ug, fileName;
  var indexTheme;
  if (!Empty(theme)){ // css,pagelet,decorators
    if (listFiles[type][theme]){
      indexFile=LibJavascript.Array.indexOf(listFiles[type][theme].files,fileNameWithExt)
      update=false;
      indexTheme=-1
      if (indexFile==-1 && action=='add'){
        listFiles[type][theme].files.push(fileNameWithExt);
        listFiles[type][theme].files=listFiles[type][theme].files.sort(sort);
        for (i=projectTree.root.children[index].children.length-1;i>=0 && indexTheme==-1; i--){
          if (projectTree.root.children[index].children[i]._name==theme)
            indexTheme=i;
        }
        update=true;
      }
      else if (indexFile!=-1 && action=='remove'){
        listFiles[type][theme].files.splice(indexFile,1);
        update=true;
      }
      if (update && ((filter!='' && Lower(name).indexOf(filter)!=-1) || (indexTheme!=-1 && filter=='' && projectTree.root.children[index].state.loaded && projectTree.root.children[index].children[indexTheme].state.loaded))){
        updateTree(projectTree,projectTree.root.children[index])
      }
    }
  }
  else if (custom!=null){
    if (line==null){ //zoom, maschere, report, chart, smartreport
      cd=custom?'custom':'def'
      files=custom?'customFiles':'files'
      if (listFiles[type][files]){
        indexFile=LibJavascript.Array.indexOf(listFiles[type][files],fileNameWithExt)
        update=false;
        if (indexFile==-1 && action=='add'){
          listFiles[type][files].push(fileNameWithExt)
          listFiles[type][files].sort(sort)
          if (files=='files'){
            i = LibJavascript.Array.indexOf(listFiles[type][files],'Custom')
            if (i!=-1){
              listFiles[type].files.splice(i,1)
              listFiles[type].files=['Custom'].concat(listFiles[type].files)
            }
          }
          update=true;
        }
        else if (indexFile!=-1 && action=='remove'){
          listFiles[type][files].splice(indexFile,1)
          update=true;
        }

        if (update){
          if (painterList[type].user_group){
            fileName=getFileName(name,type)[0]
            var tableName="";
            var isZoom=type=='zoom'
            if (isZoom){
              fileName=name.split('[')[0]
              tableName=name.split('[')[1];
              tableName=tableName.substring(0,tableName.length-1);
            }
            var userOrGroup=fileName.split('_');
            ug='';
            if (userOrGroup.length>1 && (type!='maskparameters' || !Empty(userOrGroup[userOrGroup.length-2]))){ //potrebbe essere la variante di una maschera
              userOrGroup=userOrGroup[userOrGroup.length-1];
              ug=IsUser(userOrGroup)?'user':IsGroup(userOrGroup)?'group':''
              if (!Empty(ug)){
                fileName=fileName.substring(0,(fileName.length-1)-userOrGroup.length)
                updateCustom=false;
                if (action=='add'){
                  if (userTree && userStructure[cd] && userStructure[cd][ug]){
                    initUserStructure(type,cd,null,null,ug,userOrGroup)
                    userStructure[cd][ug][userOrGroup][type].file.push({name:fileName+(isZoom?'['+tableName+']':''),realName:name})
                    userStructure[cd][ug][userOrGroup][type].file.sort(customSort)
                    updateCustom=true;
                  }
                }
                else {
                  projectStructure[type][cd][ug][userOrGroup].splice(LibJavascript.Array.indexOf(projectStructure[type][cd][ug][userOrGroup],fileName+(isZoom?'.'+tableName:'')),1);
                  if (projectStructure[type][cd][ug][userOrGroup].length==0)
                    delete projectStructure[type][cd][ug][userOrGroup]
                  if (userTree && userStructure[cd] && userStructure[cd][ug][userOrGroup]){
                    ii=-1;
                    for (i=0; i<userStructure[cd][ug][userOrGroup][type].file.length && ii==-1; i++){
                      if (userStructure[cd][ug][userOrGroup][type].file[i].name==fileName+(isZoom?'['+tableName+']':''))
                        ii=i
                    }
                    if (ii!=-1){
                      userStructure[cd][ug][userOrGroup][type].file.splice(ii,1)
                      if (userStructure[cd][ug][userOrGroup][type].file.length==0){
                        if (!(userStructure[cd][ug][userOrGroup].Menu) || (userStructure[cd][ug][userOrGroup][isZoom?'maskparameters':'zoom']))
                          delete userStructure[cd][ug][userOrGroup]
                        else delete userStructure[cd][ug][userOrGroup][type];
                      }
                    }
                    updateCustom=true;
                  }
                }
                i=custom?1:0;
                if (updateCustom && ((customFilter=='' && userTree.root.children[i].state.loaded) || (customFilter!='' && Lower(fileName+(isZoom?'.'+tableName:'')).indexOf(customFilter)!=-1)))
                  updateTree(userTree,userTree.root)
              }
            }
          }
          if ((filter=='' && projectTree.root.children[index].state.loaded) || (filter!='' && Lower(name).indexOf(filter)!=-1)){
            if (custom){
              var indexCustom=-1
              for (i=projectTree.root.children[index].children.length-1;i>=0 && indexCustom==-1; i--){
                if (projectTree.root.children[index].children[i]._name=='Custom')
                  indexCustom=i;
              }
              if (filter!='' || projectTree.root.children[index].children[indexCustom].state.loaded)
                updateTree(projectTree,projectTree.root.children[index])
            }
            else updateTree(projectTree,projectTree.root)
          }
        }
      }
    }
    else { //menu, query
      line=line?'offline':'online'
      cd=custom?'custom':'def'
      files=custom?'customFiles':'files'
      if (listFiles[type][line][files]){
        indexFile=LibJavascript.Array.indexOf(listFiles[type][line][files],fileNameWithExt);
        if (indexFile==-1 && action=='add'){
          listFiles[type][line][files].push(fileNameWithExt)
          listFiles[type][line][files].sort(sort)
          if (files=='files'){
            i = LibJavascript.Array.indexOf(listFiles[type][line][files],('Custom'))
            if (i!=-1){
              listFiles[type][line].files.splice(i,1)
              listFiles[type][line].files=['Custom'].concat(listFiles[type][line].files)
            }
          }
          update=true
        }
        else if(indexFile!=-1 && action=='remove'){
          listFiles[type][line][files].splice(indexFile,1)
          update=true;
        }
        if (update){
          if (type=='menu'){
            fileName=getFileName(name,Lower[type])[0];
            var splitName=fileName.split('_');
            if (splitName.length>1){
              var company=splitName[splitName.length-1]
              userOrGroup='';
              if (IsCompany(company)){
                if (splitName.length>2){
                  userOrGroup=splitName[splitName.length-2];
                  ug=IsUser(userOrGroup)?'user':IsGroup(userOrGroup)?'group':''
                }
                else ug='';
              }
              else {
                company='';
                userOrGroup=splitName[splitName.length-1];
                ug=IsUser(userOrGroup)?'user':IsGroup(userOrGroup)?'group':''
              }
              updateCustom=false;
              if (!Empty(company)){
                name=name.substring(0,(name.length-1)-company.length)
                if (action=='add'){
                  initProjectStructure(type,cd,line,company);
                  if (!Empty(ug)){
                    name=name.substring(0,(name.length-1)-userOrGroup.length)
                    if (userTree && userStructure[cd]){
                      initUserStructure('menu',cd,line,company,ug,userOrGroup);
                      userStructure[cd].company[company][ug][userOrGroup].menu[line].file.push({name:name,realName:name+'_'+userOrGroup+'_'+company})
                      userStructure[cd].company[company][ug][userOrGroup].menu[line].file.sort(customSort)
                      updateCustom=true;

                    }
                  }
                  else {
                    if (userTree && userStructure[cd]){
                      initUserStructure('menu',cd,line,company,null,null);
                      userStructure[cd].company[company].menu[line].file.push({name:name,realName:name+'_'+company})
                      userStructure[cd].company[company].menu[line].file.sort(customSort)
                      updateCustom=true;
                    }
                  }
                }
                else { //remove
                  if (Empty(ug)){
                    projectStructure[type][line][cd].company[company].files.splice(LibJavascript.Array.indexOf(projectStructure[type][line][cd].company[company].files,name),1)
                    if (projectStructure[type][line][cd].company[company].files.length==0){
                      delete projectStructure[type][line][cd].company[company].files
                      if (projectStructure[type][line][cd].company[company].user=={} && projectStructure[type][line][cd].company[company].group=={})
                        delete projectStructure[type][line][cd].company[company]
                    }
                    if (userTree && userStructure[cd] && userStructure[cd].company[company]){
                      ii=-1;
                      for (i=0; i<userStructure[cd].company[company].menu[line].file.length && ii==-1; i++){
                        if (userStructure[cd].company[company].menu[line].file[i].name==name)
                          ii=i
                      }
                      if (ii!=-1){
                        userStructure[cd].company[company].menu[line].file.splice(ii,1)
                        if (userStructure[cd].company[company].menu[line].file.length==0){
                          if (!userStructure[cd].company[company].menu[line=='offline'?'online':'offline'] || userStructure[cd].company[company].menu[line=='offline'?'online':'offline'].file.length==0){
                            delete userStructure[cd].company[company].menu
                          }
                          else delete userStructure[cd].company[company].menu[line]
                        }
                      }
                      updateCustom=true;
                    }
                  }
                  else {
                    name=name.substring(0,(name.length-1)-userOrGroup.length)
                    projectStructure[type][line][cd].company[company][ug][userOrGroup].splice(
                      LibJavascript.Array.indexOf(
                        projectStructure[type][line][cd].company[company][ug][userOrGroup], name
                      ),
                    1)
                    if (projectStructure[type][line][cd].company[company][ug][userOrGroup].length==0){
                      delete projectStructure[type][line][cd].company[company][ug][userOrGroup];
                      if (
                        projectStructure[type][line][cd].company[company].files.length==0 &&
                        projectStructure[type][line][cd].company[company].group=={} &&
                        projectStructure[type][line][cd].company[company].user=={}
                      )
                        delete projectStructure[type][line][cd].company[company]
                    }
                    if (userTree && userStructure[cd] && userStructure[cd].company[company] && userStructure[cd].company[company][ug][userOrGroup]){
                      ii=-1;
                      for (i=0; i<userStructure[cd].company[company][ug][userOrGroup].menu[line].file.length && ii==-1; i++){
                        if (userStructure[cd].company[company][ug][userOrGroup].menu[line].file[i].name==name)
                          ii=i
                      }
                      if (ii!=-1){
                        userStructure[cd].company[company][ug][userOrGroup].menu[line].file.splice(ii,1)
                        if (userStructure[cd].company[company][ug][userOrGroup].menu[line].file.length==0){
                          delete userStructure[cd].company[company][ug][userOrGroup].menu[line]
                          if (!userStructure[cd].company[company][ug][userOrGroup].zoom && !userStructure[cd].company[company][ug][userOrGroup].maskparameters && !userStructure[cd].company[company][ug][userOrGroup].Chart && userStructure[cd].company[company][ug][userOrGroup].menu[line=='offline'?'online':'offline']){
                            delete userStructure[cd].company[company][ug][userOrGroup]
                            if (userStructure[cd].company[company].user=={} && userStructure[cd].company[company].group=={} && userStructure[cd].company[company].file.length==0)
                              delete userStructure[cd].company[company]
                          }
                          else delete userStructure[cd].company[company][ug][userOrGroup].menu[line];
                        }
                      }
                      updateCustom=true;
                    }
                  }
                }
              }
              else {
                if (!Empty(ug)){
                  name=name.substring(0,(name.length-1)-userOrGroup.length)
                  if (action=='add'){
                    initProjectStructure(type,cd,line,null,ug,userOrGroup)
                    if (userTree && userStructure[cd] && userStructure[cd][ug]){
                      initUserStructure('menu',cd,line,null,ug,userOrGroup);
                      userStructure[cd][ug][userOrGroup].menu[line].file.push({name:name,realName:name+'_'+userOrGroup})
                      userStructure[cd][ug][userOrGroup].menu[line].file.sort(customSort)
                      updateCustom=true;
                    }
                  }
                  else { // remove
                    if (projectStructure[type][line][cd][ug][userOrGroup]){
                      projectStructure[type][line][cd][ug][userOrGroup].splice(LibJavascript.Array.indexOf(projectStructure[type][line][cd][ug][userOrGroup],name),1)
                      if (projectStructure[type][line][cd][ug][userOrGroup].length==0)
                        delete projectStructure[type][line][cd][ug][userOrGroup];
                      if (userTree && userStructure[cd] && userStructure[cd][ug][userOrGroup]){
                        ii=-1;
                        for (i=0; i<userStructure[cd][ug][userOrGroup].menu[line].file.length && ii==-1; i++){
                          if (userStructure[cd][ug][userOrGroup].menu[line].file[i].name==name)
                            ii=i
                        }
                        if (ii!=-1){
                          userStructure[cd][ug][userOrGroup].menu[line].file.splice(ii,1)
                          if (userStructure[cd][ug][userOrGroup].menu[line].file.length==0){
                            if (!userStructure[cd][ug][userOrGroup].zoom && !userStructure[cd][ug][userOrGroup].maskparameters && !userStructure[cd][ug][userOrGroup].Chart && userStructure[cd][ug][userOrGroup].menu[line=='offline'?'online':'offline'])
                              delete userStructure[cd][ug][userOrGroup]
                            else delete userStructure[cd][ug][userOrGroup].menu[line];
                          }
                        }
                        updateCustom=true;
                      }
                    }
                  }
                }
              }
              if (updateCustom){
                i=custom?1:0
                if ((customFilter=='' && userTree.root.children[i].state.loaded) || (customFilter!='' && Lower(name).indexOf(customFilter)!=-1)){
                  updateTree(userTree,userTree.root)
                }
              }
            }
          }
          var indexLine=line=='online'?0:1
          if ((filter=='' && projectTree.root.children[index].children[indexLine].state.loaded) || (filter!='' && Lower(name).indexOf(filter)!=-1)){
            if (custom){
              indexCustom=-1
              for (i=projectTree.root.children[index].children[indexLine].children.length-1;i>=0 && indexCustom==-1; i--){
                if (projectTree.root.children[index].children[indexLine].children[i]._name=='Custom')
                  indexCustom=i;
              }
              if (filter!='' || projectTree.root.children[index].children[indexLine].children[indexCustom].state.loaded)
                updateTree(projectTree,projectTree.root.children[index].children[indexLine])
            }
            else updateTree(projectTree,projectTree.root.children[index])
          }
        }
      }
    }
  }
  else{
    indexFile=LibJavascript.Array.indexOf(listFiles[type].files,fileNameWithExt)
    update=false;
    if (indexFile==-1 && action=='add'){
      listFiles[type].files.push(fileNameWithExt);
      listFiles[type].files=listFiles[type].files.sort(sort);
      if (painterList[type].skin){
        theme=getTheme();
        indexTheme;
        for (i=0; i<theme.length; i++){
          indexTheme=LibJavascript.Array.indexOf(listFiles[type].files,theme[i])
          if (indexTheme!=-1){
            listFiles[type].files.splice(indexTheme,1)
          }
        }
        listFiles[type].files=theme.concat(listFiles[type].files)
      }
      else if (type=='portlet'){
        var idx=LibJavascript.Array.indexOf(listFiles[type].files,'jsp-system');
        if (idx!=-1){
          listFiles[type].files.splice(idx,1)
          listFiles[type].files=['jsp-system'].concat(listFiles[type].files)
        }

      }
      update=true;
    }
    else if (indexFile!=-1 && action=='remove'){
      listFiles[type].files.splice(indexFile,1);
      update=true;
    }
    if (update && ((filter=='' && projectTree.root.children[index].state.loaded) || (filter!='' && Lower(name).indexOf(filter)!=-1)))
      updateTree(projectTree,projectTree.root)
  }
}

function initProjectStructure(p,cd,l,c,ug,name_ug){
  if (!p){
    projectStructure={
      zoom:{custom:{user:{},group:{},file:[]},def:{user:{},group:{},file:[]}},
      menu:{online:{custom:{company:{},user:{},group:{},file:[]},def:{company:{},user:{},group:{},file:[]}},
            offline:{custom:{company:{},user:{},group:{},file:[]},def:{company:{},user:{},group:{},file:[]}}},
      maskparameters:{custom:{user:{},group:{},file:[]},def:{user:{},group:{},file:[]}},
      chart:{custom:{user:{},group:{},file:[]},def:{user:{},group:{},file:[]}}
    }
    return;
  }
  //cd=default/custom, c=company , ug=user/group, name_ug=name user/group, p=painter, l=Online/Offline
  if (Empty(l)){
    if (!projectStructure[p][cd][ug])
      projectStructure[p][cd][ug]={};
    if (!projectStructure[p][cd][ug][name_ug])
      projectStructure[p][cd][ug][name_ug]=[]
  }
  else   {
    if (!projectStructure[p][l][cd].company)
      projectStructure[p][l][cd].company={};
    if (!Empty(c)){
      if (!projectStructure[p][l][cd].company[c])
        projectStructure[p][l][cd].company[c]={group:{},user:{},files:[]}
      if (!Empty(ug)){
        if (!projectStructure[p][l][cd].company[c][ug][name_ug])
          projectStructure[p][l][cd].company[c][ug][name_ug]=[]
      }
    }
    else {
      if (!projectStructure[p][l][cd][ug])
        projectStructure[p][l][cd][ug]={};
      if (!projectStructure[p][l][cd][ug][name_ug])
        projectStructure[p][l][cd][ug][name_ug]=[]
    }
  }
}

function createProjectTree() {
  var json = [
    {
      "property": {
        "name": "",
        "_name": "",
        "type": "loader"
      },
      "children": [
        {
          "property": {
            "name": "Portlet",
            "_name": "Portlet",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Pagelet",
            "_name": "Pagelet",
            "loadable": true,
            "type": ["loader","folder"]
          }
        },
        {
          "property": {
            "name": "Plan",
            "_name": "Plan",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Query",
            "_name": "Query",
            "type": "loader"
          },
          "children": [
            {
              "property":{
                "name": "Online",
                "_name": "Online",
                "loadable": true
              }
            },
            {
              "property":{
                "name": "Offline",
                "_name": "Offline",
                "loadable": true
              }
            }
          ]
        },
        {
          "property": {
            "name": "Zoom",
            "_name": "Zoom",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Report",
            "_name": "Report",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "SmartReport",
            "_name": "SmartReport",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Chart",
            "_name": "Chart",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Module",
            "_name": "Module",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Scan",
            "_name": "Scan",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Menu",
            "_name": "Menu",
            "type": "loader"
          },
          "children": [
            {
              "property":{
                "name": "Online",
                "_name": "Online",
                "loadable": true
              }
            },
            {
              "property":{
                "name": "Offline",
                "_name": "Offline",
                "loadable": true
              }
            }
          ]
        },
          {
          "property": {
            "name": "Decorators",
            "_name": "Decorators",
            "loadable": true,
            "type": ["loader","folder"]
          }
        },
          {
          "property": {
            "name": "CSS Class",
            "_name": "CSS Class",
            "loadable": true,
            "type": ["loader","folder"]
          }
        },
        {
          "property": {
            "name": "Mask parameters",
            "_name": "Mask parameters",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Interfaces",
            "_name": "Interfaces",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "VisualPivot",
            "_name": "VisualPivot",
            "loadable": true
          }
        }
      ]
    }
  ];
  initProjectStructure();
  projectTree=createTree("tree_container",json);
  projectTree.addEvent('initSearch', function (/*filter*/){
    initProjectStructure();
  });
  projectTree.addEvent('searchComplete', function (filter){
    if (filter==''){
      projectTree.root.toggle('open');
    }
  })
  projectTree.loadOptions = function(node,filter){
    // funzione che in base al nodo dove clicco ritorna gli elementi da caricare
    var _filter=filter||'';
    var cd;
    if (node) {
      var painter=Strtran(Lower(node._name),' ','');
      if (node.parentNode._name=='' && !painterList[painter].on_off){
        if (!listFiles[painter] || !listFiles[painter].files){
          listFiles[painter]={};
          listFiles[painter].files=getPainterFiles(node._name,{custom:false},false);;
        }
        return {
          json: GetList(listFiles[painter].files||[],Lower(node._name),_filter,node)
        };
      }
      else {
        var ancestorsName=[];
        ancestorsName[0]=Strtran(Lower(node._name),' ',''); // array contenente i nomi del nodo,padre,nonno,bisnonno...
        var parentNode=node.parentNode;
        while (parentNode){
          ancestorsName[ancestorsName.length]=Strtran(Lower(parentNode._name),' ','');
          parentNode=parentNode.parentNode;
        }
        if (!listFiles[ancestorsName[1]]) listFiles[ancestorsName[1]]={}
        if (node._name=='Custom'){
          if (painterList[ancestorsName[1]]){
            //ancestorsName[1]=maskparameters|report|zoom|chart|smartreport
            if (!listFiles[ancestorsName[1]].customFiles)
              listFiles[ancestorsName[1]].customFiles=getPainterFiles(ancestorsName[1],{custom:true});
            return {
              json: GetList(listFiles[ancestorsName[1]].customFiles,Lower(ancestorsName[1]),_filter,node)
            };
          }
          else if (painterList[ancestorsName[2]]){
            //ancestorsName[2]=query|menu
            if (!listFiles[ancestorsName[2]][ancestorsName[1]].customFiles){
              listFiles[ancestorsName[2]][ancestorsName[1]].customFiles=getPainterFiles(ancestorsName[2],{offlinemode:ancestorsName[1]=='offline',custom:true})
            }
            return {
              json: GetList(listFiles[ancestorsName[2]][ancestorsName[1]].customFiles,Lower(ancestorsName[2]),_filter,node)
            };
          }
        }
        else if (node._name=='jsp-system' && ancestorsName[1]=='portlet'){
          if (!listFiles.portlet.jspSystemFiles)
            listFiles.portlet.jspSystemFiles=getPainterFiles('portlet',{jsp_system:true})
          return {
            json: GetList(listFiles.portlet.jspSystemFiles,'portlet',_filter,node)
          }
        }
        else if (
          !listFiles[ancestorsName[1]][ancestorsName[0]] ||
          !listFiles[ancestorsName[1]][ancestorsName[0]].files ||
          (ancestorsName.length>3 && painterList[ancestorsName[3]])
        ) {
          if (!listFiles[ancestorsName[1]][ancestorsName[0]])
            listFiles[ancestorsName[1]][ancestorsName[0]]={}
          if (painterList[ancestorsName[1]] && painterList[ancestorsName[1]].on_off){
            // query|menu
            listFiles[ancestorsName[1]][ancestorsName[0]].files=getPainterFiles(ancestorsName[1],{offlinemode:node._name=='Offline',custom:false})
          }
          else if (painterList[ancestorsName[1]] && (painterList[ancestorsName[1]].skin || painterList[ancestorsName[1]].jsp_system || ancestorsName[1]=='interfaces')){
            //pagelet|decorators|cssclass
            listFiles[ancestorsName[1]][ancestorsName[0]].files=getPainterFiles(ancestorsName[1],{folder_path:node._name})
          }
          else if (painterList[ancestorsName[1]] && painterList[ancestorsName[1]].user_group){ // sono su un utente o gruppo
            //maschere|chart|zoom
            return {
              json: GetList(projectStructure[ancestorsName[1]].def.user[node._name]||projectStructure[ancestorsName[1]].def.group[node._name]||[],ancestorsName[1],_filter,node)
            };
          }
          else if (painterList[ancestorsName[2]] && painterList[ancestorsName[2]].user_group && !painterList[ancestorsName[2]].on_off){// sono su un utente o gruppo custom
            //maschere|chart|zoom
            if (ancestorsName[1]=="custom"){
              return {
                json: GetList(
                  projectStructure[ancestorsName[2]].custom.user[node._name] ||
                  projectStructure[ancestorsName[2]].custom.group[node._name] ||
                  [], ancestorsName[2], _filter,node)
              };
            }
          }
          else if (
            (painterList[ancestorsName[2]] && painterList[ancestorsName[2]].company) ||
            (painterList[ancestorsName[3]] && painterList[ancestorsName[3]].company) ||
            (painterList[ancestorsName[4]] && painterList[ancestorsName[4]].company)
          ) {
            // menu
            cd=ancestorsName[1]=='custom'?'custom':'def';
            var line;
            if (ancestorsName[1]=='online' || ancestorsName[1]=='offline')
              line=ancestorsName[1]
            else if (ancestorsName[2]=='online' || ancestorsName[2]=='offline')
              line=ancestorsName[2]
            else line=ancestorsName[3]
            if (node._name.charAt(0)=='c'){
              return {
                json: GetList(projectStructure.menu[line][cd].company[node._name]||[],'menu',_filter,node)
              };
            }
            else {
              if (ancestorsName[1]=='online' || ancestorsName[1]=='offline')
                cd='def'
              if (cd=='custom' || ancestorsName[1]=='online' || ancestorsName[1]=='offline'){
                return {
                  json: GetList(projectStructure.menu[line][cd].user[node._name]||projectStructure.menu[line][cd].group[node._name]||[],'menu',_filter,node)
                };
              }
              else { // figlio di un'azienda
                if (ancestorsName[2]=='custom')
                  cd='custom'
                else cd='def'
                return {
                  json: GetList(projectStructure.menu[line][cd].company[ancestorsName[1]].user[node._name]||projectStructure.menu[line][cd].company[ancestorsName[1]].group[node._name]||[],'menu',_filter,node)
                }
              }
            }
          }
        }
        return {
          json: GetList(listFiles[ancestorsName[1]][ancestorsName[0]].files||[],Lower(ancestorsName[1]),_filter,node)
        };
      }
    }
  };

  document.id("tree_container").addEvent("dblclick", function(evt){
    if (evt.target.tagName=='SPAN'){
      var el=projectTree.getSelected();
      var custom;
      if (el){
        var type=el.type[0]||el.type;
        if (!el.loadable && el._name!=''){
          var parentNodeName=el.parentNode.$name || el.parentNode._name;
          if (!el.parentNode.parentNode)
            return;
          var grandParentNodeName=el.parentNode.parentNode._name
          var path=''
          if (type=='decorators' && parentNodeName!='Decorators')
            path=parentNodeName;
          else if (type=='cssclass' && parentNodeName!='CSS Class')
            path=parentNodeName;
          else if (type=='portlet' && parentNodeName=='jsp-system')
            path='jsp-system';
          else if (type=='interfaces')
            path=parentNodeName;
          if (type=='zoom' || type=='maskparameters' || type=='chart'){
            custom=parentNodeName=='Custom'||grandParentNodeName=='Custom';
            openFile(el.$name,type=='zoom'?'portalzoom':type,{custom:custom})
          }
          else if (type=='pagelet'){
            var pageType = (new JSURL('../servlet/JSPReader?action=getType&name='+el._name+'&folder_path='+(parentNodeName=='Pagelet'?'':getPainterPath(parentNodeName,'pagelet')),true).Response()).toLowerCase();
            openFile(el.$name,pageType,{folder_path:parentNodeName=='Pagelet'?'':parentNodeName})
          }
          else if (type=='menu'){
            if (parentNodeName=='Online' || parentNodeName=='Offline'){
              openFile(el.$name,'menu',{offlinemode:parentNodeName=='Offline',custom:false})
            }
            else {
              var grandParentNode=el.parentNode.parentNode;
              grandParentNodeName=grandParentNode._name;
              while (grandParentNodeName!='Online' && grandParentNodeName!='Offline'){
                parentNodeName=grandParentNodeName;
                grandParentNode=grandParentNode.parentNode;
                grandParentNodeName=grandParentNode._name;
              }
              custom=parentNodeName=='Custom';
              openFile(el.$name,'menu',{offlinemode:grandParentNodeName=='Offline',custom:custom})
            }
          }
          else if (type=="query"){
            if (parentNodeName=='Offline' || parentNodeName=='Online'){
              openFile(el.$name,'visualquery',{offlinemode:parentNodeName=='Offline',custom:false})
            }
            else {
              parentNodeName=el.parentNode.parentNode._name
              openFile(el.$name,'visualquery',{offlinemode:parentNodeName=='Offline',custom:true})
            }
          }
          else if (type=="report" || type=="smartreport"){
            custom=parentNodeName=='Custom';
            openFile(el.$name,type,{custom:custom})
          }
          else{
            if (type=="scan") type='scandoc';
            openFile(el.$name,type,{folder_path:path})
          }
        }
      }
    }
  })
}

function GetList(arr,type,filter,node,onlyCustom) {
  //funzione che riempie la projectStructure e ritorna gli oggetti da mostrare nella treeview
  type=Lower(Strtran(type," ",""));
  filter=Lower(filter)
  var result=[];
  var loadable,name, ug, cd, userOrGroup, realName;
  var i, line, keys;
  for (i=0;i<arr.length;i++) {
    if(arr[i]!="" && arr[i].indexOf('[') == -1 && !((type == "chart" && arr[i].indexOf("__temp")!=-1))){
      var fileName = getFileName(arr[i],type);
      loadable=fileName[1];
      name=fileName[0]; // nome senza estensione
      if (type=='zoom'){
        var zoomName=name.split('[')[0], tableName=name.split('[')[1];
        userOrGroup='';
        if (node._name=='Zoom' || node._name=='Custom'){
          userOrGroup=zoomName.split('_');
          if (userOrGroup.length>1){
            userOrGroup=userOrGroup[userOrGroup.length-1];
            if (IsUser(userOrGroup) || IsGroup(userOrGroup))
              zoomName=zoomName.substring(0,(zoomName.length-1)-userOrGroup.length)
            else userOrGroup='';
          }
          else userOrGroup='';
        }
        if (Lower(zoomName).indexOf(filter)!=-1 || zoomName=='Custom' || Lower(tableName).indexOf(filter)!=-1){
          ug='user'
          if (userOrGroup.charAt(0)=='g')
            ug='group';
          if (userOrGroup!=''){
            cd=onlyCustom?'custom':node._name=='Custom'?'custom':'def';
            initProjectStructure('zoom',cd,null,null,ug,userOrGroup);
            if (projectStructure.zoom[cd][ug][userOrGroup].indexOf(zoomName+'.'+tableName.substring(0,tableName.length-1))==-1)
              projectStructure.zoom[cd][ug][userOrGroup].push(zoomName+'.'+tableName.substring(0,tableName.length-1));
          }
          else {
            realName=''
            if (node._name=='Zoom' || node._name=='Custom')
              realName=name;
            else{
              realName=name.split('[')
              realName=realName[0]+'_'+node._name+'['+realName[1]
            }
            result.push(getMifTreePropertyObject(name,type,loadable,true,realName)); // sistemare
          }
        }
      }
      else if (type=='maskparameters' || type=='chart'){
        userOrGroup=''
        if (node._name=='Mask parameters' || node._name=='Custom' || node._name=='Chart'){
          userOrGroup=name.split('_');
          if (userOrGroup.length>1 && !Empty(userOrGroup[userOrGroup.length-2])){ // devo controllare che non sia una varinate
            userOrGroup=userOrGroup[userOrGroup.length-1];
            if (IsUser(userOrGroup) || IsGroup(userOrGroup))
              name=name.substring(0,(name.length-1)-userOrGroup.length);
            else userOrGroup='';
          }
          else userOrGroup=''
        }
        if (Lower(name).indexOf(filter)!=-1 || name=='Custom'){
          ug='user';
          if (userOrGroup.charAt(0)=='g')
            ug='group';
          if (userOrGroup!=''){
            cd=onlyCustom?'custom':node._name=='Custom'?'custom':'def';
            initProjectStructure(type,cd,null,null,ug,userOrGroup)
            if (projectStructure[type][cd][ug][userOrGroup].indexOf(name)==-1)
              projectStructure[type][cd][ug][userOrGroup].push(name);
          }
          else {
            realName='';
            if (node._name=='Mask parameters' || node._name=='Custom' || node._name=='Chart')
              realName=name;
            else  // utente o gruppo
              realName=name+'_'+node._name

            result.push(getMifTreePropertyObject(name,type,loadable,true,realName));
          }
        }
      }
      else if (type=='menu'){
        userOrGroup='';
        var company='';
        var parentNodeName=node.parentNode._name;
        if (node._name=='Custom' || node._name=='Offline' || node._name=='Online'){
          var tmpArr=name.split('_');
          if (tmpArr.length>1){
            company=tmpArr[tmpArr.length-1]
            if (IsCompany(company)){
              name=name.substring(0,(name.length-1)-company.length)
              if (tmpArr.length>2)
                userOrGroup=tmpArr[tmpArr.length-2]
            }
            else {
              company='';
              userOrGroup=tmpArr[tmpArr.length-1];
            }
          }
          if (userOrGroup!=''){
            if (IsUser(userOrGroup) || IsGroup(userOrGroup))
              name=name.substring(0,(name.length-1)-userOrGroup.length)
            else userOrGroup='';
          }
        }
        if (Lower(name).indexOf(filter)!=-1 || name=='Custom'){
          cd=onlyCustom?'custom':node._name=='Custom'?'custom':'def';
          if (node._name=='Custom')
            line=Lower(node.parentNode._name);
          else line=Lower(node._name);
          ug='user';
          if (userOrGroup!=''){
            if (userOrGroup.charAt(0)=='g')
              ug='group'
            if (company==''){
              initProjectStructure('menu',cd,line,null,ug,userOrGroup)
              if (projectStructure.menu[line][cd][ug][userOrGroup].indexOf(name)==-1)
                projectStructure.menu[line][cd][ug][userOrGroup].push(name);
            }
            else {
              initProjectStructure('menu',cd,line,company,ug,userOrGroup)
              if (projectStructure.menu[line][cd].company[company][ug][userOrGroup].indexOf(name)==-1)
                projectStructure.menu[line][cd].company[company][ug][userOrGroup].push(name)
            }
          }
          else if (company!=''){
            initProjectStructure('menu',cd,line,company,null,null)
            if (projectStructure.menu[line][cd].company[company].files.indexOf(name)==-1)
              projectStructure.menu[line][cd].company[company].files.push(name);
          }
          else {
            realName='';
            if (node._name=='Online' || node._name=='Offline' || node._name=='Custom')
              realName=name;
            else if (parentNodeName=='Online' || parentNodeName=='Offline' || parentNodeName=='Custom') // utente o gruppo o azienda
              realName=name+'_'+node._name
            else  // azienda + utente o gruppo
              realName=name+'_'+node._name+'_'+parentNodeName;
            result.push(getMifTreePropertyObject(name,type,loadable,true,realName));
          }
        }
      }
      else if (type=='query'){
        if (loadable || Lower(name).indexOf(filter)!=-1)
          result.push(getMifTreePropertyObject(name,type,loadable,true,name));
      }
      else {
        if ((loadable) || (!loadable && Lower(name).indexOf(filter)!=-1)){
          result.push(getMifTreePropertyObject(name,type,loadable,false,name));
        }
      }
    }
  }
  if ((type=='zoom' && (node._name=='Zoom' || node._name=='Custom')) || (type=='maskparameters' && (node._name=='Mask parameters' || node._name=='Custom')) || (type=='chart' && (node._name=='Chart' || node._name=='Custom'))){
    cd=onlyCustom?'custom':node._name=='Custom'?'custom':'def';
    var painter=node._name=='Custom'?node.parentNode._name:node._name;
    painter=Strtran(Lower(painter),' ','');
    keys=getElementsSorted(projectStructure[painter][cd].group,'group');
    for (i=0; i<keys.length; i++)
      result.push(getMifTreePropertyObject(keys[i],'group',true,true,keys[i]));
    keys=getElementsSorted(projectStructure[painter][cd].user,'user');
    for (i=0; i<keys.length; i++)
      result.push(getMifTreePropertyObject(keys[i],'user',true,true,keys[i]));
  }
  else if (type=='menu' && (node._name=='Online' || node._name=='Offline' || node._name=='Custom')){
    cd=onlyCustom?'custom':node._name=='Custom'?'custom':'def'
    if (node._name=='Custom')
      line=Lower(node.parentNode._name);
    else line=Lower(node._name)

    keys=getElementsSorted(projectStructure.menu[line][cd].company,'company');
    for (i=0; i<keys.length; i++)
      result.push(getMifTreePropertyObject(keys[i],'company',true,true,keys[i]));

    keys=getElementsSorted(projectStructure.menu[line][cd].group,'group');
    for (i=0; i<keys.length; i++)
      result.push(getMifTreePropertyObject(keys[i],'group',true,true,keys[i]));

    keys=getElementsSorted(projectStructure.menu[line][cd].user,'user');
    for (i=0; i<keys.length; i++)
      result.push(getMifTreePropertyObject(keys[i],'user',true,true,keys[i]));
  }
  else if (type=='menu' && arr.files){
    for (i=0; i<arr.files.length; i++){
      result.push(getMifTreePropertyObject(arr.files[i],type,false,false,arr.files[i]+'_'+node._name));
    }

    keys=getElementsSorted(arr.group,'group');
    for (i=0; i<keys.length; i++)
      result.push(getMifTreePropertyObject(keys[i],'group',true,true,keys[i]));

    keys=getElementsSorted(arr.user,'user');
    for (i=0; i<keys.length; i++)
      result.push(getMifTreePropertyObject(keys[i],'user',true,true,keys[i]));
  }
  loadEditor[type]=true;
  return result;
}

function createCustomTree(){
  var json = [
    {
      "property": {
        "name": "",
        "_name": "",
        "type": "loader"
      },
      "children": [
        {
          "property": {
            "name": "Query",
            "_name": "Query",
            "type": "loader"
          },
          "children": [
            {
              "property":{
                "name": "Online",
                "_name": "Online",
                "loadable": true
              }
            },
            {
              "property":{
                "name": "Offline",
                "_name": "Offline",
                "loadable": true
              }
            }
          ]
        },
        {
          "property": {
            "name": "Zoom",
            "_name": "Zoom",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Report",
            "_name": "Report",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "SmartReport",
            "_name": "SmartReport",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Chart",
            "_name": "Chart",
            "loadable": true
          }
        },
        {
          "property": {
            "name": "Menu",
            "_name": "Menu",
            "type": "loader"
          },
          "children": [
            {
              "property":{
                "name": "Online",
                "_name": "Online",
                "loadable": true
              }
            },
            {
              "property":{
                "name": "Offline",
                "_name": "Offline",
                "loadable": true
              }
            }
          ]
        },
        {
          "property": {
            "name": "Mask parameters",
            "_name": "Mask parameters",
            "loadable": true
          }
        }
      ]
    }
  ];
  customTree=createTree("customTree_container",json);
  customTree.addEvent('searchComplete', function (filter){
    if (filter=='')
      customTree.root.toggle('open')
  })
  customTree.loadOptions = function(node,filter){
    // funzione che in base al nodo dove clicco ritorna gli elementi da caricare
    var _filter=filter||'';
    if (node) {
      var painter=Strtran(Lower(node._name),' ','');
      if (node.parentNode._name=='' && !painterList[painter].on_off){ //query,zoom,report,smartreport,chart,maschere
        if (!listFiles[painter].customFiles){
          listFiles[painter].customFiles=getPainterFiles(node._name,{custom:true},false);
        }
        return {
          json: GetList(listFiles[painter].customFiles||[],Lower(node._name),_filter,node,true)
        };
      }
      else {
        var ancestorsName=[];
        ancestorsName[0]=Strtran(Lower(node._name),' ',''); // array contenente i nomi del nodo,padre,nonno,bisnonno...
        var parentNode=node.parentNode;
        while (parentNode){
          ancestorsName[ancestorsName.length]=Strtran(Lower(parentNode._name),' ','');
          parentNode=parentNode.parentNode;
        }
        if (!listFiles[ancestorsName[1]]) listFiles[ancestorsName[1]]={}
        if (
          !listFiles[ancestorsName[1]][ancestorsName[0]] ||
          !listFiles[ancestorsName[1]][ancestorsName[0]].customFiles ||
          (ancestorsName.length>3 && painterList[ancestorsName[3]])
        ) {
          if (!listFiles[ancestorsName[1]][ancestorsName[0]])
            listFiles[ancestorsName[1]][ancestorsName[0]]={}
          if (painterList[ancestorsName[1]] && painterList[ancestorsName[1]].on_off){
            // query|menu
            listFiles[ancestorsName[1]][ancestorsName[0]].customFiles=getPainterFiles(ancestorsName[1],{offlinemode:node._name=='Offline',custom:true})
          }
          else if (painterList[ancestorsName[1]] && painterList[ancestorsName[1]].user_group){ // sono su un utente o gruppo
            //maschere|chart|zoom
            return {
              json: GetList(
                projectStructure[ancestorsName[1]].custom.user[node._name] ||
                projectStructure[ancestorsName[1]].custom.group[node._name] ||
                [], ancestorsName[1], _filter, node, true)
            };
          }
          else if (
            (painterList[ancestorsName[2]] && painterList[ancestorsName[2]].company) ||
            (painterList[ancestorsName[3]] && painterList[ancestorsName[3]].company) ||
            (painterList[ancestorsName[4]] && painterList[ancestorsName[4]].company) ) {
            // menu
            var line;
            if (ancestorsName[1]=='online' || ancestorsName[1]=='offline')
              line=ancestorsName[1]
            else if (ancestorsName[2]=='online' || ancestorsName[2]=='offline')
              line=ancestorsName[2]
            else line=ancestorsName[3]
            if (node._name.charAt(0)=='c'){
              return {
                json: GetList(projectStructure.menu[line].custom.company[node._name]||[],'menu',_filter,node,true)
              };
            }
            else {
              if (ancestorsName[1]=='online' || ancestorsName[1]=='offline'){
                return {
                  json: GetList(projectStructure.menu[line].custom.user[node._name]||projectStructure.menu[line].custom.group[node._name]||[],'menu',_filter,node,true)
                };
              }
              else { // figlio di un'azienda
                return {
                  json: GetList(projectStructure.menu[line].custom.company[ancestorsName[1]].user[node._name]||projectStructure.menu[line].custom.company[ancestorsName[1]].group[node._name]||[],'menu',_filter,node)
                }
              }
            }
          }
        }
        return {
          json: GetList(listFiles[ancestorsName[1]][ancestorsName[0]].customFiles||[],Lower(ancestorsName[1]),_filter,node,true)
        };
      }
    }
  };
  document.id("customTree_container").addEvent("dblclick", function(evt){
    if (evt.target.tagName=='SPAN'){
      var el=customTree.getSelected();
      if (el){
        var type=el.type[0]||el.type;
        if (!el.loadable && el._name!=''){
          var parentNodeName=el.parentNode.$name || el.parentNode._name;
          if (!el.parentNode.parentNode)
            return;
          var grandParentNodeName=el.parentNode.parentNode._name
          if (type=='zoom' || type=='maskparameters' || type=='chart'){
            openFile(el.$name,type=='zoom'?'portalzoom':type,{custom:true});
          }
          else if (type=='menu'){
            if (parentNodeName=='Online' || parentNodeName=='Offline'){
              openFile(el.$name,'menu',{offlinemode:parentNodeName=='Offline',custom:true})
            }
            else {
              var grandParentNode=el.parentNode.parentNode;
              grandParentNodeName=grandParentNode._name;
              while (grandParentNodeName!='Online' && grandParentNodeName!='Offline'){
                parentNodeName=grandParentNodeName;
                grandParentNode=grandParentNode.parentNode;
                grandParentNodeName=grandParentNode._name;
              }
              openFile(el.$name,'menu',{offlinemode:grandParentNodeName=='Offline',custom:true})
            }
          }
          else if (type=="query"){
            if (parentNodeName=='Offline' || parentNodeName=='Online'){
              openFile(el.$name,'visualquery',{offlinemode:parentNodeName=='Offline',custom:true})
            }
            else {
              parentNodeName=el.parentNode.parentNode._name
              openFile(el.$name,'visualquery',{offlinemode:parentNodeName=='Offline',custom:true})
            }
          }
          else if (type=="report" || type=="smartreport"){
            openFile(el.$name,type,{custom:true})
          }
        }
      }
    }
  })
}

function FillUserStructure(fileName,painter,mode,type,filter){
  var realFileName=fileName;
  filter=Lower(filter)
  var table='';
  if (painter=='zoom'){
    fileName=fileName.split('[');
    table='['+fileName[1];
    fileName=fileName[0];
  }
  var name=fileName.split('_');
  var userOrGroup, _usGr;
  if (name.length>1){
    if (painter=='Mask parameters' && Empty(name[name.length-2])) // � una variante
      return;
    var company=name[name.length-1];
    if (IsCompany(company)){
      fileName=fileName.substring(0,(fileName.length-1)-company.length)
      _usGr='';
      if (name.length>2){
        userOrGroup=name[name.length-2];
        if (IsGroup(userOrGroup))
          _usGr='group';
        else if (IsUser(userOrGroup))
          _usGr='user';
        if (_usGr!=''){
          fileName=fileName.substring(0,(fileName.length-1)-userOrGroup.length)
          if (Lower(fileName).indexOf(filter)!=-1){
            initUserStructure(painter,type,mode,company,_usGr,userOrGroup)
            if (mode!='')
              userStructure[type].company[company][_usGr][userOrGroup][painter][mode].file.push({name:fileName+table,realName:realFileName});
            else
              userStructure[type].company[company][_usGr][userOrGroup][painter].file.push({name:fileName+table,realName:realFileName});
          }
        }
      }
      if ((name.length<=2 || _usGr=='') && Lower(fileName).indexOf(filter)!=-1){
        initUserStructure(painter,type,mode,company,null,null)
        if (mode!='')
          userStructure[type].company[company][painter][mode].file.push({name:fileName+table,realName:realFileName});
        else
          userStructure[type].company[company][painter].file.push({name:fileName+table,realName:realFileName});
      }
    }
    else{
      company='';
      _usGr='';
      userOrGroup=name[name.length-1];
      if (IsGroup(userOrGroup))
        _usGr='group';
      else if (IsUser(userOrGroup))
        _usGr='user';
      if (_usGr!=''){
        fileName=fileName.substring(0,(fileName.length-1)-userOrGroup.length)
        if (Lower(fileName).indexOf(filter)!=-1){
          initUserStructure(painter,type,mode,null,_usGr,userOrGroup)
          if (mode!='')
            userStructure[type][_usGr][userOrGroup][painter][mode].file.push({name:fileName+table,realName:realFileName});
          else
            userStructure[type][_usGr][userOrGroup][painter].file.push({name:fileName+table,realName:realFileName});
        }
      }
    }
  }
}

function initUserStructure(p,cd,l,c,ug,name_ug){
  //cd=default/custom, c=company , ug=user/group, name_ug=name user/group, p=painter, l=Online/Offline
  if (!Empty(c)){
    if (!userStructure[cd].company[c])
      userStructure[cd].company[c]={group:{},user:{}};
    if (!Empty(p)){
      if (Empty(ug)){
        if (!userStructure[cd].company[c][p])
          userStructure[cd].company[c][p]={file:[]}
        if (l!=''){
          if (!userStructure[cd].company[c][p][l])
            userStructure[cd].company[c][p][l]={file:[]}
        }
      }
      else {
        if (!userStructure[cd].company[c][ug][name_ug])
          userStructure[cd].company[c][ug][name_ug]={}
        if (!userStructure[cd].company[c][ug][name_ug][p])
          userStructure[cd].company[c][ug][name_ug][p]={file:[]}
        if (l!=''){
          if (!userStructure[cd].company[c][ug][name_ug][p][l])
            userStructure[cd].company[c][ug][name_ug][p][l]={file:[]}
        }
      }
    }
  }
  else {
    if (!userStructure[cd][ug][name_ug])
      userStructure[cd][ug][name_ug]={};
    if (!userStructure[cd][ug][name_ug][p])
      userStructure[cd][ug][name_ug][p]={file:[]};
    if (l!=''){
      if (!userStructure[cd][ug][name_ug][p][l])
        userStructure[cd][ug][name_ug][p][l]={file:[]};
    }
  }
}

function createUserStructure(custom,filter){
  filter=Lower(filter)
  if (custom)
    userStructure['custom']={company:{},user:{},group:{}}
  else userStructure['def']={company:{},user:{},group:{}}
  var painter=["menu"];
  var mode=["online","offline"]
  var files=[];
  var name='', i, k;
  for (i=0; i<painter.length; i++){
    if (!listFiles[painter[i]])
      listFiles[painter[i]]={}
    for (var j=0; j<mode.length; j++){
      if (!listFiles[painter[i]][mode[j]])
        listFiles[painter[i]][mode[j]]={}
      if (!custom){
        if (!listFiles[painter[i]][mode[j]].files)
          listFiles[painter[i]][mode[j]].files=getPainterFiles(painter[i],{offlinemode:mode[j]=='offline',custom:false},false)
        files=listFiles[painter[i]][mode[j]].files;
        for (k=0; k<files.length; k++){
          name=getFileName(files[k],Lower(painter[i]))[0];
          if (Lower(name).indexOf(filter)!=-1)
            FillUserStructure(name,painter[i],mode[j],'def',filter);
        }
      }
      else {
        if (!listFiles[painter[i]][mode[j]].customFiles)
          listFiles[painter[i]][mode[j]].customFiles=getPainterFiles(painter[i],{offlinemode:mode[j]=='offline',custom:true},false)
        files=listFiles[painter[i]][mode[j]].customFiles;
        for (k=0; k<files.length; k++){
          name=getFileName(files[k],Lower(painter[i]))[0];
          if (Lower(name).indexOf(filter)!=-1)
            FillUserStructure(name,painter[i],mode[j],'custom',filter);
        }
      }
    }
  }
  painter=["zoom","maskparameters","chart"];
  for (i=0; i<painter.length; i++){
    if (!listFiles[painter[i]])
      listFiles[painter[i]]={}
    if (!custom){
      if (!listFiles[painter[i]].files)
        listFiles[painter[i]].files=getPainterFiles(painter[i],{custom:false},false)
      files=listFiles[painter[i]].files;
      for (k=0; k<files.length; k++){
        name=getFileName(files[k],Lower(painter[i]))[0];
        if (Lower(name).indexOf(filter)!=-1)
          FillUserStructure(getFileName(files[k],Lower(painter[i]))[0],painter[i],'','def',filter);
      }
    }
    else {
      if (!listFiles[painter[i]].customFiles)
        listFiles[painter[i]].customFiles=getPainterFiles(painter[i],{custom:true},false)
      files=listFiles[painter[i]].customFiles;
      for (k=0; k<files.length; k++){
        name=getFileName(files[k],Lower(painter[i]))[0];
        if (Lower(name).indexOf(filter)!=-1)
          FillUserStructure(getFileName(files[k],Lower(painter[i]))[0],painter[i],'','custom',filter);
      }
    }
  }
}

function createUserTree(){
  var json=[{
        "property": {
          "name": "",
          "type": "loader"
        },
        "children": [
          {
            "property": {
              "name": "Default",
              "_name": "Default",
              "loadable": true
            }
          },
          {
            "property": {
              "name": "Custom",
              "_name": "Custom",
              "loadable": true
            }
          }
        ]
      }];
  userTree=createTree('userTree_container',json);
  userTree.addEvent('searchComplete', function (filter){
    if (filter==''){
      userTree.root.toggle('open')
      userStructure={}
    }
  })
  userTree.loadOptions = function(node,filter){
    var refreshStructure=filter!=null;
    var _filter=filter||'';
    var result=[];
    var i, j, el;
    var painter, parentNode, list, keys;
    if (node) {
      var ancestorsName=[];
      ancestorsName[0]=Strtran(Lower(node._name),' ',''); // array contenente i nomi del nodo,padre,nonno,bisnonno...
      parentNode=node.parentNode;
      while (parentNode){
        ancestorsName[ancestorsName.length]=Strtran(Lower(parentNode._name),' ','');
        parentNode=parentNode.parentNode;
      }
      var def_custom=(ancestorsName[ancestorsName.length-2]=='default'?'def':'custom');
      if (ancestorsName.length==2){ // devo caricare utenti, gruppi e aziende
        if (refreshStructure)
          userStructure={}
        if (!userStructure[def_custom])
          createUserStructure(def_custom=='custom',_filter)
        list=['company','user','group'],keys
        for (j=0; j<list.length;j++){
          keys=getElementsSorted(userStructure[def_custom][list[j]],list[j]);
          for (i=0; i<keys.length; i++)
            result.push(getMifTreePropertyObject(keys[i],list[j],true,true,keys[i]));
        }
      }
      else if (ancestorsName.length==3){
        if (node.type[0]=='company'){ //sono in un azienda quindi carico utenti|gruppi e file
          list=['group','user']
          for (j=0; j<list.length;j++){
            keys=getElementsSorted(userStructure[def_custom].company[node._name][list[j]],list[j]);
            for (i=0; i<keys.length; i++)
            result.push(getMifTreePropertyObject(keys[i],list[j],true,true,keys[i]));
          }
          for (el in userStructure[def_custom].company[node._name]){
            if (el!='group' && el!='user')
              result.push(getMifTreePropertyObject(el,el,true,true,el));
          }
        }
        else { //sono in un utente o gruppo -> carico i file
          for (el in userStructure[def_custom][node.type[0]][node._name]){
            result.push(getMifTreePropertyObject(el,el,true,true,el));
          }
        }
      }
      else if (ancestorsName.length==4){
        parentNode=node.parentNode;
        if (node.type[0]=='user' || node.type[0]=='group'){ // menu con company + utente|gruppo ancestorsName[1]=company, node=user|group
          for (el in userStructure[def_custom].company[ancestorsName[1]][node.type[0]][node._name]){
            result.push(getMifTreePropertyObject(el,el,true,true,el));
          }
        }
        else { // painter
          painter=Strtran(Lower(node._name),' ','');
          for (el in userStructure[def_custom][parentNode.type[0]][ancestorsName[1]][painter]){
            if (el!='file')
              result.push(getMifTreePropertyObject(el,painter,true,true,el));
          }
          if (userStructure[def_custom][parentNode.type[0]][ancestorsName[1]][painter].file){
            for (i=0; i<userStructure[def_custom][parentNode.type[0]][ancestorsName[1]][painter].file.length; i++){
              el=userStructure[def_custom][parentNode.type[0]][ancestorsName[1]][painter].file[i]
              result.push(getMifTreePropertyObject(el.name,painter,false,true,el.realName));
            }
          }
        }
      }
      else if (ancestorsName.length==5){ //menu sempre
        parentNode=node.parentNode.parentNode;
        if (node._name=='Online' || node._name=='Offline'){ // menu con company|user|group
          painter=Strtran(Lower(ancestorsName[1]),' ','');
          for (i=0; i<userStructure[def_custom][parentNode.type[0]][ancestorsName[2]][ancestorsName[1]][Lower(node._name)].file.length; i++){
            el=userStructure[def_custom][parentNode.type[0]][ancestorsName[2]][painter][Lower(node._name)].file[i]
            result.push(getMifTreePropertyObject(el.name,node.parentNode._name,false,true,el.realName));
          }
        }
        else { // non dovrebbe mai entrare qui
          // menu con azienda e user|group. praticamente carica online|offline
          parentNode=node.parentNode;
          for (el in userStructure[def_custom].company[ancestorsName[2]][parentNode.type[0]][ancestorsName[1]][Lower(node._name)]){
            if (el!='file')
              result.push(getMifTreePropertyObject(el,Lower(node._name),true,true,el));
          }
        }
      }
      else if (ancestorsName.length==6){ //menu con company+user|group+online|offline
        painter=Strtran(Lower(ancestorsName[1]),' ','');
        parentNode=node.parentNode.parentNode;
        for (i=0; i<userStructure[def_custom].company[ancestorsName[3]][parentNode.type[0]][ancestorsName[2]][painter][Lower(node._name)].file.length; i++){
          el=userStructure[def_custom].company[ancestorsName[3]][parentNode.type[0]][ancestorsName[2]][painter][Lower(node._name)].file[i];
          result.push(getMifTreePropertyObject(el.name,Lower(node.parentNode._name),false,true,el.realName));
        }
      }
    }
    return {
      json:result
    }
  }

  document.id("userTree_container").addEvent("dblclick", function(evt){
    if (evt.target.tagName=='SPAN'){
      var el=userTree.getSelected();
      var type=Lower(el.type[0]||el.type);
      if (el && !el.loadable && el._name!=''){
        var ancestorsName=[];
        ancestorsName[0]=el._name; // array contenente i nomi del nodo,padre,nonno,bisnonno...
        var parentNode=el.parentNode;
        while (parentNode){
          ancestorsName[ancestorsName.length]=parentNode._name;
          parentNode=parentNode.parentNode;
        }
        var custom=ancestorsName[ancestorsName.length-2]=='Custom';
        if (type=='zoom'){
          openFile(el.$name,'portalzoom',{custom:custom})
        }
        else if (type=='menu'){
          var offlinemode=ancestorsName[1]=='Offline';
          openFile(el.$name,'menu',{custom:custom,offlinemode:offlinemode})
        }
        else if (type=='maskparameters' || type=='chart')
          openFile(el.$name,type,{custom:custom})
      }
    }
  })
}

window.addEvent('domready',function(){
  if (window.parent && window.parent.ResizePS){
    window.parent.ResizePS();
  }
  else {
    var h=document.id("pv_btn").offsetHeight+document.id("toolbar").offsetHeight+100;
    document.id('tree_container').style.height=(window.parent.GetWindowSize().h-h)+'px';
    document.id('userTree_container').style.height=(window.parent.GetWindowSize().h-h)+'px';
    document.id('customTree_container').style.height=(window.parent.GetWindowSize().h-h)+'px';
  }
  createProjectTree();
  loadFiles();
  projectTree.refreshHeight()
  projectTree.refreshNanoScroll();
});
