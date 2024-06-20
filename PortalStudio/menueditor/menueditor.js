/* exported
    doLoad folder_path selectImageBitmap selectImageBmpOpened selectImageBmp insertImage
    reset openVMN addItem old_name save writeHTML addSource newCurrentObj Help revealProperty
    updateProperties
  */

var currentname=""; //nome del menu corrente
var filename=""
var folder_path='';
var custom_folder=false;
var user_group='';
var user='';
var group='';
var company='';
var source_tabs;
var newPropObj = null;
var source_root_id ; //id della root caricata
var project_root_id ; //id della root caricata
var sources_tree = [];
var current_source_tree = 0; //id della rootHTML
var custom_tree; //id della rootHTML
var offline = false;
var currentBmpProperty;
var form = {};

function doLoad(e,fname,offlinemode,custom){
  try{
    parent.setTitle(this)
  } catch(ec) {}
  offline = offlinemode;
  source_root_id = 'source_root_'+current_source_tree;
  /*Create custom tree*/
  addCustomTree()
  if(!Empty(fname)){
    /*read user/group/custom
    * filename + _UserNumber || _gGroupNumber + _cCompany
    */
    if(custom)
      custom_folder = true;
    var temp = fname.split("_");
    // controllo se ho l'azienda
    currentname=fname;
    if( temp[temp.length-1].substr(0,1) == "c" ){ /*Company*/
      var temp_c = temp[temp.length-1].substring(1);
      for(var j=0;j<avalues.length;j++){
        if( temp_c == avalues[j]){
          company = avalues[j];
          currentname=currentname.substring(0,currentname.length-(company.length+2))
          temp.splice(temp.length-1,1);
        }
      }
    }
    if( !isNaN(temp[temp.length-1])){ /*User*/
      user_group = 'User';
      user = parseInt(temp[temp.length-1]);
      currentname=currentname.substring(0,currentname.length-(temp[temp.length-1].length+1))
    }else if( !isNaN( temp[temp.length-1].substring(1)) && temp[temp.length-1].substr(0,1) == "g"){ /*Group*/
      user_group = 'Group';
      group = parseInt( temp[temp.length-1].substring(1));
      currentname=currentname.substring(0,currentname.length-(temp[temp.length-1].length+1))
    }
    filename = fname;
    if(window.parent.changeName)
      window.parent.changeName(fname,{custom:custom,offlinemode:offlinemode});
    if(Ctrl("srcform")) Ctrl("srcform").value=currentname
    if(standalone) document.title=currentname+" - Menu Editor";
    old_name=currentname;
    project_root_id = Upper(GetCPCCCHK(10))
    reload();
  }else{
    currentname = '';
  /*Init formProp*/
    form = {
      comment:'',
      author:"",
      client:"",
      version:"1.0",
      created:(new Date()).format('db'),
      revision:"",
      note_global:"",
      offline: offline,
      custom: false,
      user_group: "",
      user: "",
      group: "",
      company: ""
    }
    formProp = new ZTObjects.formObj(form)
    custom_tree.load({
      json: createTree("New_Project_Menu",[])
    });
  }
  document.id('backcanvas').setStyle('display','block');
  windowResize();
  FormProperties();
  document.id('loading').setStyle('display','none');
  create_gadget_pane();
  document.id('custom_tab_wrapper').style.width=document.id('custom_frame').offsetWidth+'px'

  source_tabs = new TabsMT('menu_list_source','source_frame',{move:true,close:true})
  current_source_tree = addTree();

  new SPToolbar(ZTObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  });

  //sposto il div dei results della search
  if (Ctrl("results_tab_content") && Ctrl("findList")) {
    Ctrl("results_tab_content").appendChild(Ctrl("findList"));
  }

  /*Creazione del menu di progetto: sortable*/
  resizeGadgetsPane();
  m_bUpdated=false;
  window.addEvent("keydown", function(e) {
    if (e.control && e.key=="s") { //CTRL-S
      e.stop();
      if (parent.saveTool) parent.saveTool();
    }
  });
}

function selectImageBitmap(){
  currentBmpProperty='bitmap'
  selectImage()
}

function selectImageBmpOpened(){
  currentBmpProperty='bitmapOpen'
  selectImage()
}

function selectImageBmp(){
  currentBmpProperty='bmp'
  selectImage()
}

function insertImage(url/*,imgnew,retTo*/){
  var pathImg=url.split('/')
  itemsHTML[index][currentBmpProperty]=pathImg[pathImg.length-1];
  Properties();
}

function reset(){
  if(confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
    currentname = '';
    var form = {
      comment:'',
      author:"",
      client:"",
      version:"1.0",
      created:(new Date()).format('db'),
      revision:"",
      note_global:"",
      offline:false,
      custom: false,
      user_group: "",
      user: "",
      group: "",
      company: ""
    }
    formProp = new ZTObjects.formObj(form)
    // custom_tree.root.recursive(function(){//rimuove gli item dal itemsHTML prima di eliminare la root
      // if(this.data){
        // var ind = itemsHTML.indexOf(this.data)
        // if(ind > -1)
          // itemsHTML.splice(ind,1);
      // }
    // })
    custom_tree.remove(custom_tree.root)
    sources_tree.each(function(st/*,i*/){st.remove(st.root)}) [current_source_tree]
    current_source_tree = 0;
    custom_tree.load({
      json: createTree("New_Project_Menu",[])
    });
    FormProperties();
    document.id('properties').hide();
    setPropertiesTitle("Item");
    itemsHTML = [];
    loadVMN();
    last_index = null;
    index = null;
  }
}

function openVMN(){
  if(m_bUpdated){
    if(!confirm("Changes have not been saved yet.\r\nContinue loosing changes?")){
      return false;
    }
  }
  if(custom_tree.root)
    custom_tree.root.recursive(function(){//rimuove gli item dal itemsHTML prima di eliminare la root
      if(this.data){
        var ind = itemsHTML.indexOf(this.data)
        if(ind > -1)
          itemsHTML.splice(ind,1);
      }
    })
  document.id('properties').hide()
  custom_tree.remove(custom_tree.root)
  window.open("../portalstudio/open.jsp?tool=menu&onetool=true", "Source_VMN_Menu", "height=550,width=860,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
  FormProperties();
}

function addItem(type){
  m_bUpdated = true;
  var current = custom_tree.getSelected();
  if(!current) return;
  var position = "inside";
  var level = current.data.level + 1;

  if(current.type != "submenu" ){
    position = "after";
    level = current.parentNode.data.level + 1;
  }
  var name = (type != 'separator' ? 'NoName' : '' )+ type.capitalize();
  var prop = {};
  prop.id = Upper(GetCPCCCHK(10));
  prop.level = level;
  prop.itemType = type;
  switch(type){
    case 'menu':
      prop.name = name
      prop.submenu = 1;
      prop.type = "Master";
      prop.remove = 'false';
    break;
    case 'submenu':
      prop.name = name
      prop.submenu = 2;
      prop.insertion_action = 'P'
      prop.type = ''
    break;
    case 'separator':
      prop.name = Upper(GetCPCCCHK(10));
      prop.submenu = 4;
    break;
  }

  var newNode = createNode(type, name, prop);
  custom_tree.add(newNode, current,position);
  if( type != 'separator') newNode.rename();
}

function createNode(type, name, prop) {
  var newNode = new Mif.Tree.Node({
        parentNode: null,
        tree: custom_tree
      }, {
      property: {
        name: name
      },
      type: type ,
      data : createItem(type, prop, true)
  });
  return newNode;
}

function addCustomTree(/*filename*/){
  new Element ('div',{id:'custom_tree_wrapper','class':'tree_wrapper'}).inject(document.id('custom_frame'));
  // source_tabs.addTabs(li,source_frame);
  custom_tree = new Mif.Tree.NanoScroll({
    container: document.id('custom_tree_wrapper'),// tree container
    nanoScroll:true,
    initialize: function(){
      // new Mif.Tree.KeyNav(this);
      // this.initSortable();
      new Mif.Tree.Drag(this, {
        onDrag: function(){
          // inject menu inside menu not allowed;
          if(this.target && this.target.type[0] != 'submenu' && this.where == 'inside'){
            this.where = 'notAllowed';
          }
          if(this.current.tree != this.tree){
            this.tree.drag.action = "copy";
          }
        },
        onStart: function(){
        },
        onComplete: function(){
        },
        onDrop: function(current, target/*, where*/){
          m_bUpdated = true;
          var copy = target.tree.copyToSelect; //elemento copiato da un altro tree
          if(copy){
            copy.recursive(function(){
              if(this.data.id) copy.data.id = Upper(GetCPCCCHK(10)); //Crea un nuovo items per itemsHTML editabile
              this.data = createItem(this.type[0],this.data,true);
            })
            current.tree.unselect(current);
            target.tree.copyToSelect = null;
            target.tree.select(copy);
            this.tree.drag.action = "move";
          }
        },
        // action : "copy"//,
        // modifier : "copy"
      });
    },

    types: {// node types
      submenu: {
        openIcon: 'mif-tree-submenu-open-icon',//css class open icon
        closeIcon: 'mif-tree-submenu-close-icon'// css class close icon
      },
      menu : {
        // openIcon: 'mif-tree-menu-selected-icon',//css class open icon
        closeIcon: 'mif-tree-menu-icon'// css class close icon
      },
      separator : {
        // openIcon: 'mif-tree-separator-icon',
        closeIcon: 'mif-tree-separator-icon'
      }
    },
    dfltType: 'menu',//default node type
    height: 24, //node height
    onCopy: function(from, to, where, copy){
      // to.tree.select(copy);
      to.tree.copyToSelect = copy;
      copy.property.editable = true;
      m_bUpdated = true;
      // copy.set({
        // property: {
          // name: 'copya '
        // }
      // })
    },
    onSelect: function(node){sources_tree[current_source_tree].unselect(sources_tree[current_source_tree].getSelected());selectItem(node)},
    onUnSelect : function(){document.id('lostfocus').focus();},
    onAdd : function(node/*,current,where*/){node.tree.select(node);},
    propertiesEditable :true,
    onRename: function(node, newName/*, oldName*/){
      var x= searchNode(itemsHTML,node.data);
      if( x >- 1){
        itemsHTML[x].name = newName;
        newPropObj.updatePropertiesFromPaint(itemsHTML[x]);
      }
    },
    deletable : true,
    onBeforeDelete : function(node){
      node.deleteCondition = confirm("Are you sure to delete "+node.name+" "+(  node.type[0] == 'submenu' ? "and his children" : "" )+"?")
    },
    onDelete: function(node){
      index = null;
      /* cerca l'item e lo rimuove da itemsHTML */
      var idx = itemsHTML.indexOf(node.data)
      if( idx > -1 )
        itemsHTML.splice(idx,1);
      document.id('properties').hide();
      setPropertiesTitle("");
    }
  });
  new Element('span').set('text',"Project").inject(document.id('custom_tab_wrapper'))
}

function addTree(filename,offlinemode,custom){
  m_bUpdated = true;
  /*Create tree wapper and tab for source*/
  var frame = new Element ('div',{id:'source_tree_wrapper_'+sources_tree.length,'class':'tree_wrapper'}).inject(document.id('source_frame'));
  sources_tree[sources_tree.length] = new Mif.Tree.NanoScroll({
    container: document.id('source_tree_wrapper_'+sources_tree.length),// tree container
    nanoScroll:true,
    initialize: function(){
      // new Mif.Tree.KeyNav(this);
      // this.initSortable();
      new Mif.Tree.Drag(this, {
        onDrag: function(){
          // inject menu inside menu not allowed;
          if(this.tree && this.target && this.target.tree === this.tree ){
            this.where = 'notAllowed';
          }
          // if(this.target == this. this.where == "inside"){
            // this.where = 'notAllowed';
          // }
        },
        onStart: function(){
        },
        onComplete: function(){
        },
        allowContainerDrop : false

      });
    },

    types: {// node types
      submenu: {
        openIcon: 'mif-tree-submenu-open-icon',//css class open icon
        closeIcon: 'mif-tree-submenu-close-icon'// css class close icon
      },
      menu : {
        // openIcon: 'mif-tree-menu-selected-icon',//css class open icon
        closeIcon: 'mif-tree-menu-icon'// css class close icon
      },
      separator : {
        // openIcon: 'mif-tree-separator-icon',
        closeIcon: 'mif-tree-separator-icon'
      }
    },
    dfltType: 'menu',//default node type
    height: 24, //node height
    // onCopy: function(from, to, where, copy){
      // if(from.getParent() == copy.getParent()){
        // copy.set({
          // property: {
            // name: 'copy ' + from.name
          // }
        // });
      // }
    // }
    propertiesEditable:false,
    onSelect: function(node){custom_tree.unselect(custom_tree.getSelected());selectItem(node)},
    onUnSelect : function(){document.id('lostfocus').focus();},
    deletable : false

  });
  /*Load source menu*/
  var li = new Element('li').inject(document.id('menu_list_source'))
  var span = new Element('span').inject(li)
  span.set('text',(!Empty(filename) ? filename : 'Plan'));
  source_tabs.addTabs(li,frame);
  source_tabs.addEvent('beforeClose', function (title, contents){
    sources_tree[Strtran(contents.id,'source_tree_wrapper_','')].unselect();
  })
  loadVMN(filename,offlinemode,custom);
  return sources_tree.length-1;
}

function loadVMN(filename,offlinemode,custom){
  var projectUrl;
  if(Empty(filename)) //carico il plan
    projectUrl = new JSURL("../servlet/SPVMNProxy?action=openPlanModule&start_uid="+source_root_id+"&filename=plan"+"&offlinemode="+formProp.offline, true);
  else
    projectUrl = new JSURL("../servlet/SPVMNProxy?action=openFull&start_uid="+project_root_id+"&filename="+filename+"&offlinemode="+offlinemode+"&custom="+custom, true);
  var myResponse = projectUrl.Response();
  var obj = JSON.parse(myResponse);
  var head = obj['head'];
  // if(head.fileName!='plan')
    // document.getElementById('projectMenu').innerHTML='Module Menu';
  var body = obj['body'];
  /*create tree*/
  sources_tree[current_source_tree].load({
    json: createTree(removeSuffix(head.fileName),body)
  });
  createItems(body,false)
}

function createTree(root_name,children){
  var json = [{
    "property": {
        "name": root_name,
        "deleteDenied": true
    },
    "children": children,
    "type": "submenu",
    "data": {
      "level": 1,
      "itemType": "submenu",
      "id": Upper(GetCPCCCHK(10))
    }
  }]
  return json;
}

function reload(){
  var projectUrl = new JSURL("../servlet/SPVMNProxy?action=openFull&start_uid="+project_root_id+"&filename="+filename+"&offlinemode="+offline+"&custom="+custom_folder, true);
  // +"&Custom="+custom_folder+"&saveGroup="+group+"&saveUser="+user+"&saveCompany="+company
  var myResponse = projectUrl.Response();
  if( myResponse != ""){
    var obj = JSON.parse(myResponse);
    var head = obj['head'];
    var body = obj['body'];
    head.offline = offline;
    /*Customization*/
    head.custom = custom_folder;
    head.user_group = user_group;
    head.user = user;
    head.group = group;
    head.company = company;
    formProp = new ZTObjects.formObj(head);
    custom_tree.load({
      json: createTree(removeSuffix(head.fileName),body)
    });
    createItems(body,true)
    m_bUpdated = false;
  } else {
  /*Init formProp*/
    form = {
      comment:'',
      author:"",
      client:"",
      version:"1.0",
      created:(new Date()).format('db'),
      revision:"",
      note_global:"",
      offline: offline,
      custom: false,
      user_group: "",
      user: "",
      group: "",
      company: ""
    }
    formProp = new ZTObjects.formObj(form)
    custom_tree.load({
      json: createTree(filename,[])
    });
  }
}

var notimooManager;
var old_name;
function save() {
  if(parent) parent.is_Saving=true;
  if(!Empty(currentname)){
    notimooManager = new Notimoo({});
    notimooManager.show({
      title:'Notification message',
      message: 'saving menu...',
      sticky : true,
      width:200,
      height:40
    });
    if (document.activeElement.tagName == 'INPUT') {
		  var activeE = document.activeElement;
		  activeE.blur();
		  activeE.focus();
	  }
    save2.delay(100);
  } else {
    saveAs();
  }
}
function saveAs(){
  OpenWindow('../portalstudio/saveas.jsp?tool=menu&offlinemode='+formProp.offline+"&custom="+formProp.custom, 580,600);
}

function searchNode(items,node){
  for(var i =0; i<items.length; i++){
    if(items[i].id == node.id)
      return i;
  }
  return -1;
}

function getJsonToSave(root,itemSave){  /*Funzione ricorsiva che percorre l'abero e crea l'oggeto per il salvataggio*/
  var props = ['uid','title','link','submenu','children','enabled','bitmap','bitmapOpen','insertPoint','usernotes','technotes','type','inExt','sequence','view_type','extended_name','tooltip'];
  num_child ++;
  root.children.each(function(node){
    var index=searchNode(itemsClone,node.data);
    if (index>-1){
      var itemVmn = itemsClone[index];
      if (!Empty(itemVmn.path) && itemVmn.itemType=='submenu') {
        itemVmn.insertPoint='@'+itemVmn.path+'###'+(itemVmn.insertion_action=='T' ? 'I' : itemVmn.insertion_action)+'###'+(itemVmn.insertion_action=='T' ? 'T' : 'F');
      } else if (!Empty(itemVmn.path) && itemVmn.remove=='true' && itemVmn.itemType=='menu') {
        itemVmn.insertPoint='@'+itemVmn.path+'###'+ 'I' +'###'+ 'T';
      } else {
        itemVmn.insertPoint='';
      }
      itemVmn.enabled=!(itemVmn.disabled=='true' || itemVmn.disabled==true);
      // itemVmn.inExt=itemVmn.inExt=='true';
      if (itemVmn.type)
        itemVmn.type=(itemVmn.type=='Routine'?'Batch':itemVmn.type=='Master/Detail'?'MasterDetail':itemVmn.type)

      if(itemVmn.img_type == "font icon") {
        if(!Empty(itemVmn.font_image) && !Empty(itemVmn.font_name)) {
          itemVmn.bitmap = "{\"Char\":\""+ parseInt(itemVmn.font_image.substring(3, 7), 16) +"\",\"FontName\":\""+ itemVmn.font_name +"\"}";
        }
        if(!Empty(itemVmn.font_image_open) && !Empty(itemVmn.font_name_open)) {
          itemVmn.bitmapOpen = "{\"Char\":\""+ parseInt(itemVmn.font_image_open.substring(3, 7), 16) +"\",\"FontName\":\""+ itemVmn.font_name_open +"\"}";
        }
      }

      itemVmn.uid=itemVmn.id;
      itemsClone.splice(index,1);
      itemVmn.link=Strtran(itemVmn.link,'\\','/');
      itemVmn = LibJavascript.JSONUtils.purge(itemVmn, props, true);
      itemSave.push(itemVmn)
      getJsonToSave(node,itemVmn.children)
    }
  })
}

var num_child ;
var itemsClone = [];
var itemsToSave = [];
function save2() {
  var output;
  num_child  = 0;
  formProp.revision = (new Date()).format('db')
  /*creazione del JSON dell'itemsHTML*/
  itemsClone = Array.clone(itemsHTML);

  for(var i = 0 ; i < itemsClone.length; i++){
    var item = itemsClone[i];
    if( item.custom){
      item.objClass = "";
      item.title = item.name;
      item.children = [];
    }else{
      itemsClone.splice(i,1);
      i--;
    }
  }
  itemsToSave=[];
  getJsonToSave(custom_tree.root,itemsToSave)
  // custom_tree.root.recursive(function(){//rimuove gli item dal itemsHTML prima di eliminare la root
    // num_child ++;
    // if(this.data){
      // for(var ind =0; ind < itemsHTML.length; ind++){
        // if( itemsHTMLclone[ind].custom && itemsHTMLclone[ind].id == this.data.id ){
          // var it = itemsHTMLclone[ind];
          // it.children = [];
          // for(var j=0; j < this.children.length;j++){ //inserisco i children
            // var cld = Object.clone(this.children[j].data);
            // cld.objClass = "";
            // cld.title = cld.name;
            // it.children.push(cld);
          // }
          // it.title = it.name;
          // it.objClass="";
          // if(custom_tree.root.children.indexOf(this) > -1)// se sono ancora al primo livello
            // itemsHTMLcustom.push(it);
          // break;
        // }
      // }
    // }
  // })

  /*ricorsione per creare l'array per il salvataggio*/



  /**/
  var filename=currentname.substring(currentname.lastIndexOf("/")+1)

  var customizationParms = "&custom="+formProp.custom;
  if (formProp.user_group=='User')
    customizationParms +=  "&saveUser=" + formProp.user;
  else if (formProp.user_group=='Group')
    customizationParms +=  "&saveGroup=" + formProp.group;
  if (formProp.company != '')
    customizationParms +="&saveCompany=" + formProp.company;
  if(formProp.offline)
    customizationParms +="&offlinemode="+formProp.offline;
  // itemsHTMLcustom.each(function(el){ //semplifica itemsHTML
    // for(prop in el){
      // if((typeof el[prop]) == "object")
        // el[prop]="";
    // }
  // })
  var cloneformProp = Object.clone(formProp);
  /*Sostituisci tutti gli id con uid per compatibilita' con i vmn storici*/
  cloneformProp.objClass = "";
  cloneformProp.num_child = num_child;
  var head = JSON.encode(cloneformProp);
  head = Strtran(head,'"id":','"uid":');
  var body = JSON.encode(itemsToSave);
  // var body = JSON.encode(itemsClone);
  body = Strtran(body,'"id":','"uid":');
  var url = new JSURL("../servlet/SPVMNProxy?action=save"+
    "&filename="+filename+
    "&header="+URLenc(head)+
    "&def="+URLenc(body)+customizationParms +
    "&m_cID=" + cmdhash
    ,true);
  output=url.Response();
  var realName=currentname;
  if (formProp.user_group=='User')
    realName+=(!Empty(formProp.user)&&formProp.user!='0')?'_'+formProp.user:''
  else if (formProp.user_group=='Group')
    realName+=(!Empty(formProp.group)&&formProp.group!='0')?'_g'+formProp.group:''
  realName+=(!Empty(formProp.company)&&formProp.company!='0')?'_c'+formProp.company:''
  var parms={
    custom:formProp.custom,
    offlinemode:formProp.offline
  }
 if(window.parent.changeName) window.parent.changeName(realName,parms,Strtran(window.frameElement.id,'portalstudioframe',''));
  if(window.parent.AddRecentOpen) window.parent.AddRecentOpen("menu",realName,parms)
  if (output==null) output=""
  notimooManager.close(notimooManager.elements[0]);
  switch(output) {
    case "true":
      notimooManager.show({
         title:'Notification message',
         message: 'menu saved!',
         visibleTime: 2000,
         width:200
      });
      // $('custom_tab_wrapper').getFirst().set('text','Project: '+currentname);
      custom_tree.root.set({'name':currentname});
      if(window.opener != "undefined"){
        try {
          window.opener.document.getElementById('zones_Id').submit()
        } catch(e) {}
      }
      if (arguments.length > 0 && arguments[0] == "close") window.parent.closeCurrentObj();
      if(parent) parent.is_Saving=false;
      m_bUpdated = false;
      break;
    case "ACCESS DENIED":
        notimooManager.close(notimooManager.elements[0]);
      alert("Access Denied.")
      break;
    case "LICENSE LIMIT":
        notimooManager.close(notimooManager.elements[0]);
      alert("Licensed User Limit Reached.")
      break;
    default:
        notimooManager.close(notimooManager.elements[0]);
      alert("Save routine failed.")
    break;
  }
}

function addSource(){
  window.open("../portalstudio/open.jsp?tool=menu&onetool=true&offlinemode="+formProp.offline, "Source_VMN_Menu", "height=650,width=860,left=350,top=200,status=no,toolbar=no,menubar=no,location=no");
}

function writeHTML(){
  m_bUpdated = true;
  document.id('navmenu_tabcontainer').setStyles({'left':document.id('backcanvas').getPosition().x,'width':document.id('backcanvas').getSize().x});
  var node_sel;
  if(!Empty(custom_tree)){
    if(index !=null){
      custom_tree.root.recursive(function(){
        if(this.data.id == itemsHTML[index].id)
          node_sel =  this;
      })
      for(var prop in itemsHTML[index])
        node_sel.data[prop] = itemsHTML[index][prop];
      node_sel.set({"name":node_sel.data.name});
      setPropertiesTitle(node_sel.data.name);
    }
  }
}

function setPropertiesTitle(title){
  document.id('propertiesTitleTxt').set('html',"&nbsp;"+title.capitalize()+" properties");
}

function createItems(json,custom) { //json = [children]
  for(var i=0; i<json.length;i++){
    json[i].data = createItem(json[i].type,json[i].data,custom);
    if(json[i].children)
      createItems(json[i].children,custom)
  }
}

function createItem(type,prop,custom) {
  var item = null;
  switch(type){
    case 'menu':
      item = new ZTObjects.menuObj(prop)
    break;
    case 'submenu':
       item = new ZTObjects.submenuObj(prop)
    break;
    case 'separator':
      prop.id= Upper(this.GetCPCCCHK(10));
      item = new ZTObjects.separatorObj(prop)
    break;
  }
  if( custom ) {
  item.custom = custom;
  itemsHTML.push(item)
  }
  return item;
}

function selectItem(node){
  /*Find node in itemsHTML*/
  // if(index > -1){
    // newPropObj.updatePropertiesFromPaint(it);
    // writeHTML();
  // }
  index = null;
  for(var i=0; i<itemsHTML.length; i++){ //aggiorna l'index con l'item selezionato
    if(node.data && itemsHTML[i].id == node.data.id){
      index = i;
      break;
    }
  }
  if(index !=null){
    if(itemsHTML[index].bitmap[0] == "{") {
      var bitmapObj = JSON.parse(itemsHTML[index].bitmap);
      itemsHTML[index].font_name = bitmapObj.FontName;
      itemsHTML[index].font_image = "&#x" + Number(bitmapObj.Char).toString(16) + ";";
      itemsHTML[index].bitmap = "";
      itemsHTML[index].img_type = "font icon";
    }
    if(itemsHTML[index].bitmapOpen[0] == "{") {
      var bitmapOpenObj = JSON.parse(itemsHTML[index].bitmapOpen);
      itemsHTML[index].font_name_open = bitmapOpenObj.FontName;
      itemsHTML[index].font_image_open = "&#x" + Number(bitmapOpenObj.Char).toString(16) + ";";
      itemsHTML[index].bitmapOpen = "";
      itemsHTML[index].img_type = "font icon";
    }
    setPropertiesTitle(node.name);
    var it = itemsHTML[index]
    // if(!node.property.editable){
      var tab, p;
      for(tab in it.objClass.newProperties){
        p = it.objClass.newProperties[tab]
        for(var j=0; j< p.length; j++){
          p[j].noteditable = !node.tree.options.propertiesEditable;
        }
      }
    // }
    if(newPropObj && last_index != null && last_index==index){
      newPropObj.updatePropertiesFromPaint(it);
      // if(showProperties) showProperties('properties');
    }else{
      newPropObj = new propertiesObj({m_obj:it,canExpandToColumn:false,tabindex:100,divcontainer:'properties',moveDiv:false});
      // newPropObj.re_openColumn()
      last_index=index;
      document.id('properties').show()
    }
    resizeGadgetsPane();
  }
}

function windowResize(){
  var ctrl = document.id('backcanvas');
  if(document.body.clientWidth -document.id('gadgets_pane').offsetWidth >80)
		ctrl.style.width = (document.body.clientWidth - ((document.id('gadgets_pane').opened ? document.id('gadgets_pane').offsetWidth : 0) + 40))+"px"; //margine di 30
  if(document.getSize().y - ctrl.offsetTop > 0)
		ctrl.style.height = (document.getSize().y - (ctrl.offsetTop + 20))+"px";
  document.id('custom_tab_wrapper').style.width=document.id('custom_frame').offsetWidth+'px'
}

window.addEvent('resize', windowResize);

function GetCPCCCHK(nLen) {
  var res = '';
  for (var i=0; i<nLen; i++) {
    var nAscii = Int(Math.random()*26+97);
    res = res + String.fromCharCode(nAscii);
  }
  return (res);
}

function newCurrentObj(name,type,parms){
  // var token = url.split("&");
  // for( var i = 0; i < token.length; i++)
    // if(token[i].indexOf("offlinemode=")>-1)
  // formProp.offline = parms.offlinemode
  parms = JSON.parse(parms);
  current_source_tree = sources_tree.length ;
  addTree(name,parms.offlinemode,parms.custom);
}

function removeSuffix( name ) {
  var temp = name.split("_");
  var menuName=name;
  if( temp[temp.length-1].substr(0,1) == "c" ){ /*Company*/
    var temp_c = temp[temp.length-1].substring(1);
    for(var j=0;j<avalues.length;j++){
      if( temp_c == avalues[j]){
        menuName=menuName.substring(0,menuName.length-(temp_c.length+2))
        temp.splice(temp.length-1,1);
      }
    }
  }
  if( !isNaN(temp[temp.length-1])){ /*User*/
    menuName=menuName.substring(0,menuName.length-(temp[temp.length-1].length+1))
  }else if( !isNaN( temp[temp.length-1].substring(1)) && temp[temp.length-1].substr(0,1) == "g"){ /*Group*/
    menuName=menuName.substring(0,menuName.length-(temp[temp.length-1].length+1))
  }
  return menuName;
}

function Help(the_property){
  var i, prop='';
  if(typeof(anchorToFeature)!='undefined'){
    if(typeof(the_property)!='undefined') {
      if (the_property.indexOf('Form')===0) {
        prop = "menueditor_"+the_property.toLowerCase();
      }
      else {
        prop = "menueditor_" + itemsHTML[index].itemType + (the_property.indexOf('_') > -1 ? (the_property.substring(the_property.lastIndexOf('_'), the_property.length)) : '_' + the_property).toLowerCase();
      }
    }
    if(prop!='' && prop in anchorToFeature)
      i=anchorToFeature[prop];
    else if(index!=null && "menueditor_"+itemsHTML[index].itemType.toLowerCase() in anchorToFeature)
      i=anchorToFeature["menueditor_"+itemsHTML[index].itemType.toLowerCase()];
    else if (typeof(i)=='undefined') {
      prop = "menueditor_" + the_property.substring(the_property.indexOf('_'),0).toLowerCase();
      i = anchorToFeature[prop];
    }

    if(typeof(i)=='undefined')
      i=anchorToFeature["menueditor"];
    windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?'+URLenc(i+(prop!=""?'||'+prop+"":"")),'','toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1',null,null,null,true/*force popup*/);
  }
}

/* Ridefinita*/
function revealProperty(obj,propobj){
  var isForm=false;
  var objToggler, formToggler;
  if(obj && obj.itemType!='Form' && obj.itemType!='Separator'){
    var prop = {};
    prop.id = obj.id;
    prop.level = obj.level;
    prop.itemType = obj.itemType;
    prop.name = obj.name
    prop.submenu = obj.submenu;
    switch(obj.itemType){
      case 'menu':
        prop.type = obj.type;
      break;
      case 'submenu':
        prop.insertion_action = obj.insertion_action;
        prop.type = obj.type
      break;
    }
    var searchNode = createNode(obj.itemType, obj.name, prop);
    removeAllHandlers();
    selectItem(searchNode);
    custom_tree.expandTo(searchNode);
  }else{
    isForm=true;
    FormProperties(false,true)
    formToggler = document.id("menuproperties-toggler");
    if (formToggler && !formToggler.hasClass("opened")) {
      formToggler.click();
    }
    // Chiude proprieta' singoli elementi
    objToggler = document.id("menuitem-toggler");
    if (objToggler && objToggler.hasClass("opened")) {
      objToggler.click();
    }
  }
  if (propobj && propobj.tab && propobj.prop) {
    objToggler = document.id("menuitem-toggler");
    if (objToggler && !objToggler.hasClass("opened")) {
      objToggler.click();
    }
    // Chiude proprieta' generiche
    formToggler = document.id("menuproperties-toggler");
    if (formToggler && formToggler.hasClass("opened")) {
      formToggler.click();
    }
  }
  document.id((isForm?"Form_":"") + propobj.tab + '_tab').fireEvent('click');
  document.id((isForm?"Form_":"") +propobj.tab + '_' + propobj.prop).focus();
}

function updateProperties(input, the_property, propertyType, isForm, value, updateHTML, reconvertFunc, validFunc, m_obj, alwaysUpdates, setOnBlurFunc) {
  updateHTML = (typeof (updateHTML) == "undefined") ? true : updateHTML;
  if (window.htmlmode) {
    updateHTML = false;
  }
  if (m_obj && (typeof (m_obj.updateHTML) != "undefined")) updateHTML = m_obj.updateHTML;
  var arrayProp;
  if (isForm)
    arrayProp = formProp;
  else if (m_obj)
    arrayProp = m_obj;
  else
    arrayProp = itemsHTML[index];
  if (value == arrayProp[the_property]) return;
  if (reconvertFunc) {
    value = window[reconvertFunc](value)
  }
  var r;
  if (validFunc) {
    if (typeof (validFunc) == 'string')
      r = window[validFunc](value, the_property, input, index);
    else
      //Si pu� scrivere una
      r = validFunc.call(null, value, the_property, input, index);
    if (r != true) {
      if (input.type == 'checkbox') {
        input.checked = false;
      } else {
        input.value = arrayProp[the_property];
        setTimeout("document.getElementById('" + input.id + "').focus();", 50);
        setTimeout("document.getElementById('" + input.id + "').select();", 50);
      }
      return;
    }
  }
  if (setOnBlurFunc) {
    if (typeof (setOnBlurFunc) == 'string')
      window[setOnBlurFunc](value, the_property, input, index);
    else
      //Si pu� scrivere una
      setOnBlurFunc.call(null, value, the_property, input, index);
  }
  if (typeof (value) == 'boolean' && arrayProp[the_property] == value.toString()) return;
  if ((typeof (b_reload) != 'undefined' && b_reload) || arrayProp[the_property] == value) return;
  if (!alwaysUpdates && Empty(value) && Empty(arrayProp[the_property])) return;
  switch (propertyType) {
    case 'int': //solo valori numerici
      if (!Empty(value)) {
        if (isNaN(value)) {
          PSAlert.alert('Not a numeric value !');
          setTimeout("document.getElementById('" + input.id + "').focus();", 50);
          setTimeout("document.getElementById('" + input.id + "').select();", 50);
          return;
        } else {
          arrayProp[the_property] = value;
          if (updateHTML)
            writeHTML();
        }
      } else {
        arrayProp[the_property] = value;
        if (updateHTML)
          writeHTML();
      }
      break;
    case 'checkbox':
      if (typeof (value) == "boolean") value = (value ? "true" : "false");
      updateHTML = true;
      arrayProp[the_property] = value;
      writeHTML();
      if (the_property == 'hsl')//Se si richiamano le snaplines bisogna deselezionare tutto
        if (value != 'true') {
          selectForm()
          //return;
        }
      break;
    default:
      //case 'str': case 'data': case 'select': case 'xmldata'://valori stringa
      if (the_property == 'maxlength' && Trim(value) != '') arrayProp.w = Math.floor(value * 7.5)
      /* Conversione dei newline da html a javascript */
      value = Strtran(value, '&#13;', '\r');
      value = Strtran(value, '&#10;', '\n');
      arrayProp[the_property] = value;
      if (isForm && the_property == 'steps') {
        FormProperties(true);
      }
      if (updateHTML)
        writeHTML();
  }
  m_bUpdated = true;
}
