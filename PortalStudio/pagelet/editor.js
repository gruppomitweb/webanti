/* exported delete_portlet doload selectPageletItem selectPortletItem writeCellTabs
    resizeIframes insertportlet changeCursor returnCursor Help saving savingpic
    save editProperties portletList ItemEventInput editItemEvent EditManifest
  */

var type_selected
var m_nFrontendPort=null;

function doload(t,name,frontendport){
  initPainter();
  var standalone=false;
  document.body.onhelp=CancelHelp
  //pmgr = new Z.PageletManager();
  pageletProp[0]=new ZTPageletObjects.pageletObj();
  pageletProp[0].template=t
  formProp=pageletProp[0];
  if (window.parent.location.href.indexOf("portalstudio.jsp") < 0) {standalone=true;}
  if(!Empty(name)){
    currentname=name
    reload()
    if (Ctrl("srcform")) Ctrl("srcform").value=currentname
    if(standalone) document.title=currentname+" - Pagelet Editor";
  }
  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }
  writeHTML()
  create_gadget_pane()
  /*Chiamate per la creazione della grid e delle risorse*/
  PageletProperties(); //inizializzazione del formProp
  index_pgl=1;
  PageletProperties(); //inizializzazione del pageletProp con index_pgl=1
  resizeGadgetsPane();
  /*rimozione del loader*/
  document.id('container').setStyle('opacity','1');
  new Fx.Morph('loader',{}).start({'opacity':0}).chain(function(){
    document.id('loader').setStyle('display','none');
  })
  new SPToolbar(ZTPageletObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  });
  m_bUpdated = false;
  $('pagelet').setStyle('height', $('backcanvas').offsetHeight);
}
window.addEventListener("resize", function(){
  $('pagelet').setStyle('height', $('backcanvas').offsetHeight);
  $('backcanvas').setStyle('width','auto');
  for(var a=0;a<itemsHTML.length;a++){
    if(itemsHTML[a].type == 'portlet'){
      document.getElementById(itemsHTML[a].id+"_render").dispatchEvent(CreateCustomEvent("resizeWireFrameContainer"));
    }
  }
});

function Help(the_property){
  var i;
  var prop='';
  if (the_property.indexOf('column') < 0){
    if(type_selected=='column' && !Empty(the_property))
      the_property="column_"+the_property;
    else if(type_selected=='column')
      the_property="column";
  }

  if(typeof(anchorToFeature)!='undefined'){
    if(typeof(the_property)!='undefined')
      prop+="pageleteditor_"+the_property.toLowerCase();
    if(prop in anchorToFeature && prop!='')
      i=anchorToFeature[prop];
    else if(type_selected!='pagelet' && "pageleteditor_"+type_selected.toLowerCase() in anchorToFeature)
      i=anchorToFeature["pageleteditor_"+type_selected.toLowerCase()]
    else
      i= anchorToFeature["pageleteditor"]
    windowOpenForeground(m_cHelpUrl+'help/portalstudio/ps_urg_navigator.htm?'+URLenc(i+(prop!=""?'||'+prop:"")),'','toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
  }
}
function selectPageletItem(e,id){  //seleziona gli elementi generici della Pagelet
  (id=='pagelet'?type_selected='pagelet':type_selected='column');
  var ctrl_tmp=Ctrl(id)
  e = (e) ? e : window.event
  $$('.cell.selected').removeClass("selected");
  for(var i=0;i<pageletProp.length;i++){
    if (pageletProp[i].id==id)
      index_pgl=i
  }
  //formProp=pageletProp[index_pgl];
  ctrl_tmp.addClass("selected");
  e.cancelBubble=true
  e.returnValue=false
  PageletProperties()
}

function selectPortletItem(e,id){  //seleziona gli elementi generici della Pagelet
  e = (e) ? e : window.event
  for(var i=0;i<itemsHTML.length;i++){
    if (itemsHTML[i].id==id)
      index=i
  }
  type_selected=itemsHTML[index].type;
  e.cancelBubble=true
  e.returnValue=false
  Properties()
}

function writeHTML() {
  var obj_tmp
  var obj_html_tmp
  for (var i=0;i<pageletProp.length;i++){
    obj_tmp=pageletProp[i]
    if(!Empty(obj_tmp.width) && obj_tmp.width.indexOf('%')==-1 && obj_tmp.width.indexOf('px')==-1) obj_tmp.width+='px';
    if(!Empty(obj_tmp.height) && obj_tmp.height.indexOf('%')==-1 && obj_tmp.height.indexOf('px')==-1) obj_tmp.height+='px';
    obj_html_tmp=Ctrl(obj_tmp.id)
    switch (obj_tmp.type){
      case "pagelet":
        if(obj_tmp.width!=' ')
          obj_html_tmp.style.width=obj_tmp.width
        if(obj_tmp.height!=' ') obj_html_tmp.style.height=obj_tmp.height
        if(obj_tmp.color!=' ') obj_html_tmp.style.backgroundColor=obj_tmp.color;else obj_html_tmp.style.backgroundColor='transparent';
      break
      case "column":
        var obj_tmp_fixer=Ctrl(pageletProp[i].id+'_fixer')
        if(obj_tmp.width!=' '){
          if(obj_tmp.width.indexOf('%')==-1)
            obj_tmp_fixer.style.width=obj_tmp.width
          else
            obj_tmp_fixer.style.width=0
          obj_html_tmp.style.width=obj_tmp.width
        }else{
          obj_tmp_fixer.style.width=0
          obj_html_tmp.style.width=0
        }
        if(obj_tmp.height!=' ') obj_html_tmp.style.height=obj_tmp.height
        if(obj_tmp.color!=' ') obj_html_tmp.style.backgroundColor=obj_tmp.color;else obj_html_tmp.style.backgroundColor='transparent';
      break
    }
  }
  for(var a=0;a<itemsHTML.length;a++){
    if(itemsHTML[a].type == 'portlet'){
      document.getElementById(itemsHTML[a].id+"_render").dispatchEvent(CreateCustomEvent("resizeWireFrameContainer"));
    }
  }
}

function writeCellTabs(cellId,hideAdd){
  var str=""
  if(!hideAdd){
    str+="<table id='"+cellId+"_tab' width='' cellpadding='0' cellspacing='0' border='0' align='right'><tr>"//<td align='left'><div style=\"width:100%;background-color:gray;text-align:center\"><a href='#2' onclick=\"selectPageletItem(event,'"+cellId+"')\" style=\"font-family:tahoma;font-size:10px;font-weight:bold;color:white;text-decoration:none;\">Properties</a></div></td>"
    str+="<td><div class='add_button'><a href=\"#2\" onclick=\"insertportlet('"+cellId+"')\">add</a></div></td>"
  str+="</tr></table><br>"
  }
  str+="<div id='"+cellId+"_fixer' style='height:0px;width:0px'><p></p></div>"
  document.write(str)
}

function resizeIframes(id){
  var frame=Ctrl(id)
  frame.style.height=frame.contentWindow.document.body.scrollHeight+'px';
  //frame.style.width=frame.contentWindow.document.body.scrollWidth;
}

function insertportlet(zone){
  window.layerOpenForeground("insert.jsp?zone="+zone,"zones",'',400,600,true,1);
  //window.open("insert.jsp?zone="+zone,null,"height=600,width=400,left=350,top=200,status=no,toolbar=no,menubar=no,location=no,resizable");
}

function changeCursor(){
  document.body.style.cursor="move"
}
function returnCursor(){
  document.body.style.cursor="default"
}

function insertportlet2(portlet_name,zone,type){
  var zone_tmp=Ctrl(zone)
  var container_obj=document.createElement("div")
  container_obj.style.width='100%'
  var portlet_id=portlet_name+countindex;
  container_obj.id=portlet_id+"_container"
  container_obj.countindex=countindex;
  var html_tmp="<div style='width:99%;height:auto;-moz-box-sizing:border-box; position:relative;'><table id='"+portlet_name+"_tabs' border='0' align='center' width='100%' cellpadding='0' cellspacing='0'><tr><td align='center' width='100%'>"
  html_tmp+="<div class='propertiesTableTitle' onmouseover='changeCursor()' onmouseout='returnCursor()'>Move</div>"
  html_tmp+="</td><td align='center' width='70px'> <div  class='propertiesTableTitle button'><a href='#2' onclick='selectPortletItem(event,\""+(portlet_id)+"\")'>Properties</a></div>"
  html_tmp+="</td><td><a href='#2' class='propertiesTableTitleClose' onclick='delete_portlet(\""+portlet_id+"\")'></a></td></tr></table>"
  var obj;
  if(portlet_name.indexOf("[{")>-1 || type=='group'){
    portlet_name=Strtran(portlet_name,"[{","")
    portlet_name=Strtran(portlet_name,"}]","")

    itemsHTML[countindex]=obj=new ZTPageletObjects.groupObj(portlet_id,portlet_name,zone)
    html_tmp+="<div style='width:100%;padding:10px;font-family:tahoma;font-size:10px;font-weight:bold;background-color:#FFF6ED;color:#313131'>"+portlet_name+"<br><img src='images/group.gif'></div>"
  }else if (portlet_name.indexOf("[[")>-1 || type=='zone'){
    portlet_name=Strtran(portlet_name,"[[","")
    portlet_name=Strtran(portlet_name,"]]","")
    itemsHTML[countindex]=obj=new ZTPageletObjects.zoneObj(portlet_id,portlet_name,zone)
    html_tmp+="<div style='width:100%;padding:10px;font-family:tahoma;font-size:10px;font-weight:bold;background-color:#F1F6F8;color:#313131'>"+portlet_name+"<br><img src='images/portlet.gif'></div>"
  }else{
    itemsHTML[countindex]=obj=new ZTPageletObjects.portletObj(portlet_id,portlet_name,zone);
    html_tmp+="<iframe src='../jsp/"+portlet_name+"?SpWireframe=true&containerID="+portlet_id+"_render' scrolling='no' marginheight='0' marginheight='0' frameBorder='0' onLoad='resizeIframes(\""+portlet_id+"_render\")' style='width:100%;margin-bottom:0px;'id='"+portlet_id+"_render' class='wireframe_container'></iframe>"

    // html_tmp+="<div id='"+portlet_id+"_render' class='wireframe_container'></div>";
    // xhr = new JSURL("../servlet/JSPLoad?name="+portlet_name.replace("_portlet.jsp","")+"&type=portlet",true);
  }
  html_tmp+="</div>"
  zone_tmp.appendChild(container_obj);
  container_obj.innerHTML=html_tmp;
  // if( includePortletWireframe && portlet_name.indexOf('_portlet.jsp' > 0 )
    // ZtVWeb.Include("../jsp/"+portlet_name+"?SpWireframe=true&containerID="+"_render",portlet_id+"_render");
  countindex++;
  var dragl = new Z.Draglet(portlet_id+"_container",portlet_id+"_container",obj);
	var relDroplet = Z.Droplet.getInstance(zone_tmp[Z.Droplet.REF_PROP])
	relDroplet.addDraglet(dragl)
	dragl.relDroplet = relDroplet;
  pmgr.registerDraglet(dragl);
	pmgr.updateDropletsUICoord();
  for(var a=0;a<itemsHTML.length;a++){
    if(itemsHTML[a].type == 'portlet'){
      document.getElementById(itemsHTML[a].id+"_render").dispatchEvent(CreateCustomEvent("resizeWireFrameContainer"));
    }
  }
  return obj
}

function delete_portlet(portlet_id){
  var container_obj=Ctrl(portlet_id+"_container");
	var draglet = Z.Draglet.getInstance(container_obj[Z.Draglet.REF_PROP]);
	draglet.relDroplet.remDraglet(draglet);
	draglet.relDroplet.htmlElement.removeChild(container_obj);
  var tmp=[];
  // eslint-disable-next-line no-cond-assign
  for (var i=0, itm; itm=itemsHTML[i++];){
    if(itm.id!=portlet_id) // sposta gli elementi non selezionati  in tmp
      tmp.push(itm);
  }
  countindex=tmp.length;
  itemsHTML=tmp;
  index=null;
  Properties();
}

var saving;
var savingpic;
var old_name;
var notimooManager;
var strTheme = "";
function save(theme) {
  if(codeOpen) {alert('Close Action Code before saving !');return;}
  if(theme==null) theme='';
  if(currentname!=""){
  if(parent) parent.is_Saving=true;
	if(theme != ''){
    strTheme = theme;
	}
	notimooManager = new Notimoo({});
	notimooManager.show({
	   title:'Notification message',
	   message: 'saving pagelet...',
	   sticky : true,
	   width:200,
	   height:40
	});
	save2.delay(100);
	//var evalStr = "Ctrl(\"savingpic\").style.display=\"block\";setTimeout(\"save2("+strTheme+")\",1000)";
	//fade(0.5,0.9,0.1,1,"saving",true,evalStr);
	/*
    saving=Ctrl("saving").style;
    saving.display='block';
    saving.zIndex='2000';
    setTimeout("save2('"+theme+"')",300)
	*/
  } else {
    window.parent.saveAsTool()
  }
}
function save2() {
  var theme = strTheme;
  var output
  var valuetosave
  var strsave=""
  currentname=Strtran(currentname,"#2","")
  old_name=(window.location.href.indexOf("name=")==-1)?"":window.location.href.substring(window.location.href.indexOf("name=")+5,(window.location.href.indexOf("&")!=-1?window.location.href.indexOf("&"):window.location.href.length))
  /*
  if(old_name!=currentname && old_name!='')
    window.location.href=Strtran(window.location.href,old_name,currentname)
  */
  var i, u;
  for (i=0;i<pageletProp.length;i++){
    strsave+='type||'+pageletProp[i].type
    if(pageletProp[i].type=='pagelet') pageletProp[i].name=currentname
    for(u in pageletProp[i]){
      if(u!='objClass' && u!='type'){
        valuetosave=pageletProp[i][u]
        if(u=="codemanifest")
          valuetosave = JSON.stringify({codemanifest:valuetosave});
        if(typeof(valuetosave)!='number'){
          if(typeof(valuetosave)=='undefined' || valuetosave=="") valuetosave=' ' // se la prop � undefined allora la salvo come ' '
        }
        strsave+="||"+u+"||"+valuetosave
       }
    }
    strsave+='|||'
  }
  //costruzione itemsHTML ordinato
  var tmp_items=[],innerDraglets,containerID,currDrop;
  // eslint-disable-next-line no-cond-assign
  for(i=0; currDrop = pmgr.droplets[i++];){
    containerID = currDrop.htmlElement.id;
    innerDraglets = currDrop.getDraglets();
    // eslint-disable-next-line no-cond-assign
    for(var ii=0, itemObj, draglet; draglet=innerDraglets[ii]; ii++){
      itemObj = draglet.itemObj;
      itemObj.container = containerID;
      itemObj.position = ii;
      tmp_items.push(itemObj);
    }
  }
  itemsHTML=tmp_items;
  for (i=0; i<itemsHTML.length; i++){
    strsave+='type||'+itemsHTML[i].type
    for(u in itemsHTML[i]){
      if(u!='objClass' && u!='type'){
        valuetosave=itemsHTML[i][u]
        if(typeof(valuetosave)!='number'){
          if(typeof(valuetosave)=='undefined' || valuetosave=="") valuetosave=' ' // se la prop � undefined allora la salvo come ' '
        }
        strsave+="||"+u+"||"+valuetosave
      }
    }
    strsave+='|||'
  }
  strsave+=codeevents
  var pagelet_name='',
    folder_path='';
  currentname=Strtran(currentname,'\\',"/")
  if(currentname.indexOf('/')>-1){
    folder_path=currentname.substring(0,currentname.lastIndexOf("/"))
    pagelet_name=currentname.substring(currentname.lastIndexOf("/")+1)
  }else{
    pagelet_name=currentname
  }
  if(theme!='' && theme!=null){
    folder_path="/../"+theme
  }
  var url = new JSURL("../servlet/JSPSave?type=pagelet_new"+
    "&name="+pagelet_name+(m_nFrontendPort?"&frontendport="+m_nFrontendPort:"")+
    "&folder_path="+folder_path+
    "&def="+URLenc(strsave)+
    "&offline="+pageletProp[0]['offline']+(!Empty(codeManifest)?"&customManifest="+URLenc(pageletProp[0]['manifest']):"")+
    "&m_cID=" + cmdhash
    ,true)
  output=url.Response()
  if(window.parent.changeName) window.parent.changeName(pagelet_name,theme?{folder_path:theme}:{},Strtran(window.frameElement.id,'portalstudioframe',''))
  if (output==null) output=""

  switch(output) {
    case "true":
		notimooManager.show({
		   title:'Notification message',
		   message: 'pagelet saved!',
		   visibleTime: 2000,
		   width:200
		});
		notimooManager.close(notimooManager.elements[0]);
		 if(parent)
			parent.is_Saving=false;
		if(old_name!=currentname && old_name!="")
			window.location.href=Strtran(window.location.href,old_name,currentname);
      m_bUpdated=false
      if(typeof(GetOpener())!="undefined"){
        try {
          GetOpener().document.getElementById('zones_Id').submit()
        } catch(e) {}
      }
      if (arguments.length > 0 && arguments[0] == "close") window.parent.closeCurrentObj();
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

function reload_old(str) {
  var old_arr=str.split('||')
  var header_list=old_arr[2].split(',')
  var col1_list=old_arr[3].split(',')
  var col2_list=old_arr[4].split(',')
  var col3_list=old_arr[5].split(',')
  var footer_list=old_arr[6].split(',')
  pageletProp[0].width=old_arr[7]  // pagelet width
  pageletProp[1].height=old_arr[8] //header height
  pageletProp[2].width=old_arr[9]   // col1 width
  pageletProp[3].width=old_arr[10]   // col2 width
  pageletProp[4].width=old_arr[11]   // col3 width
  pageletProp[5].height=old_arr[12]   // footer height
  pageletProp[0].color=old_arr[13]  // pagelet color
  pageletProp[0].security=old_arr[14]  // pagelet security
  pageletProp[0].cache_time=old_arr[15]  // pagelet security
  pageletProp[0].header_tabled=old_arr[16]  // pagelet tabled
  codeevents=old_arr[17]
  pageletProp[0].css=old_arr[18]  // pagelet css
  pageletProp[1].css_class=old_arr[19]  // header class
  pageletProp[2].css_class=old_arr[20]  // col1 class
  pageletProp[3].css_class=old_arr[21]  // col2 class
  pageletProp[4].css_class=old_arr[22]  // col3 class
  pageletProp[5].css_class=old_arr[23]  // footer class
  pageletProp[0].sp_theme=old_arr[24]  // pagelet sp_theme
  var tmp, tmp1, tmp2, i, obj;
  for(i=0;i<header_list.length;i++){
    tmp=header_list[i]
    if(tmp.indexOf('?')>-1) {tmp1=tmp.substr(0,tmp.indexOf('?'));tmp2=tmp.substr(tmp.indexOf('?')+1);}else{tmp1=tmp;}
    if(tmp.indexOf('[[')>-1)
      type='zone'
    else if(tmp.indexOf('[{')>-1)
      type='group'
    else
      type='portlet'
    if(tmp!=' ') obj=insertportlet2(tmp1,'header',type);
    if(tmp.indexOf('?')>-1) obj.parameters=tmp2
  }
  for(i=0;i<col1_list.length;i++){
    tmp=col1_list[i]
    if(tmp.indexOf('?')>-1) {tmp1=tmp.substr(0,tmp.indexOf('?'));tmp2=tmp.substr(tmp.indexOf('?')+1);}else{tmp1=tmp;}
    if(tmp.indexOf('[[')>-1)
      type='zone'
    else if(tmp.indexOf('[{')>-1)
      type='group'
    else
      type='portlet'
    if(tmp!=' ') obj=insertportlet2(tmp1,'col1',type);
    if(tmp.indexOf('?')>-1) obj.parameters=tmp2
  }
  for(i=0;i<col2_list.length;i++){
    tmp=col2_list[i]
    if(tmp.indexOf('?')>-1) {tmp1=tmp.substr(0,tmp.indexOf('?'));tmp2=tmp.substr(tmp.indexOf('?')+1);}else{tmp1=tmp;}
    if(tmp.indexOf('[[')>-1)
      type='zone'
    else if(tmp.indexOf('[{')>-1)
      type='group'
    else
      type='portlet'
    if(tmp!=' ') obj=insertportlet2(tmp1,'col2',type);
    if(tmp.indexOf('?')>-1) obj.parameters=tmp2
  }
  for(i=0;i<col3_list.length;i++){
    tmp=col3_list[i]
    if(tmp.indexOf('?')>-1) {tmp1=tmp.substr(0,tmp.indexOf('?'));tmp2=tmp.substr(tmp.indexOf('?')+1);}else{tmp1=tmp;}
    if(tmp.indexOf('[[')>-1)
      type='zone'
    else if(tmp.indexOf('[{')>-1)
      type='group'
    else
      type='portlet'
    if(tmp!=' ') obj=insertportlet2(tmp1,'col3',type);
    if(tmp.indexOf('?')>-1) obj.parameters=tmp2
  }
  for(i=0;i<footer_list.length;i++){
    tmp=footer_list[i]
    if(tmp.indexOf('?')>-1) {tmp1=tmp.substr(0,tmp.indexOf('?'));tmp2=tmp.substr(tmp.indexOf('?')+1);}else{tmp1=tmp;}
    if(tmp.indexOf('[[')>-1)
      type='zone'
    else if(tmp.indexOf('[{')>-1)
      type='group'
    else
      type='portlet'
    if(tmp!=' ') obj=insertportlet2(tmp1,'footer',type);
    if(tmp.indexOf('?')>-1) obj.parameters=tmp2
  }
  writeHTML()
}

function reload() {
  var url = new JSURL("../servlet/JSPLoad?type=pagelet&name="+currentname,true)
  var strreload=url.Response()
  var i, itm, droplet, tmp_item, type, prop_map, prop, val, tmp_toremove;
  if(strreload.indexOf("|||")==-1){
    reload_old(strreload)
    return
  }

  if(strreload!=' ' && strreload.substring(0,4)=='type'){
    strreload=Strtran(strreload,'\u0080','\u20AC')
    codeevents=""
		//rimuove  i draglet di ogni droplet
		// eslint-disable-next-line no-cond-assign
		for(i=0; droplet=pmgr.droplets[i++];)
			droplet.resetDraglets();
		pmgr.draglets=[];
    // eslint-disable-next-line no-cond-assign
    for(i=0; itm=itemsHTML[i++];){
      tmp_toremove=Ctrl(itm.id+'_container');
      tmp_toremove.parentNode.removeChild(tmp_toremove)
    }
    itemsHTML=[];
    nitem=0;
    countindex=0;
    var pg_objects = strreload.split('|||');
    var l=pg_objects.length-1;
    for(i=0; i<l; i++){
      tmp_item = {};
      prop_map = pg_objects[i].split('||');
      type = prop_map[1];
      for(var b=0; b<prop_map.length; b++){
        prop = prop_map[b++];
        val = prop_map[b];
        switch(type) {
          case "pagelet":
            if( prop == "codemanifest" ){
              val = JSON.parse(val).codemanifest;
            }
            if( prop == "manifest" ){
              val = "Custom manifest"
            }
            pageletProp[i][prop] = val;
            break;
          case "column":
            pageletProp[i][prop] = val;
            break;
          default:
            val=Strtran(val,"[{","")
            val=Strtran(val,"[[","")
            val=Strtran(val,"}]","")
            val=Strtran(val,"]]","")
            tmp_item[prop] = val;
        }
      }
      switch(type) {
        case "pagelet":
          break;
        case "column":
          break;
        default:
          var newItm = insertportlet2(tmp_item.name,tmp_item.container,tmp_item.type);
          for(prop in newItm)
            if(prop!='id' && typeof(tmp_item[prop])!='undefined')
              newItm[prop]=tmp_item[prop];
      }
    }
    codeevents=pg_objects[pg_objects.length-1]; // codice delle funzioni editate
    writeHTML()
  } else if(strreload=='') {
    alert('utente non loggato')
  } else {
    alert('Errore in caricamento del def')
  }
}

function editProperties(){
  if (Ctrl("properties_div").style.display == "inline"){
    Ctrl("properties_div").style.display = "none"
    setPageProperties()
  } else
    Ctrl("properties_div").style.display = "inline"
}

var portletList
var codeevents=""
var ItemEventInput
var ActionCodeLayer;
var codeOpen=false;
function editItemEvent() {
  ItemEventInput = [itemsHTML,index,codeevents,formProp];
  //var dialogValue
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style)&&!Empty(ac_style.height)?ac_style.height:600)
  ac_style.width = (!Empty(ac_style)&&!Empty(ac_style.width)?ac_style.width:880)
  ac_style.maximized = (!Empty(ac_style)&&typeof(ac_style.maximized)!='undefined'?ac_style.maximized:false)
  localStorage.setItem('zucchetti_ac_style',JSON.encode(ac_style));
  ActionCodeLayer=new spModalLayer('editItemEvent.htm',{'in_iframe':true,
    'draggable':true,
    // 'top':40,
    // 'left':20,
    'width':ac_style.width,
    'height':ac_style.height,
    'resizable' :true,
    'border_color':'#CCCCCC',
    'border_width':1,
    'dragger_height':12,
    'dragger_image':'images/ps-editor-drag.png',
    'mask_opacity':0.4,
    'mask_color':'#CCCCCC',
    'show_scrollbars':false,
    'close_on_click_mask':'',
    'iframe_padding':0,
    'hide_close_btn':true,
    'maximize':true,
    'maximized':ac_style.maximized,
    'opener':window
  });
  ActionCodeLayer.open();
  codeOpen=true;
}
var codeManifest='';
//var ManifestCodeLayer;
function EditManifest(id){
    //var dialogValue
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style)&&!Empty(ac_style.height)?ac_style.height:600)
  ac_style.width = (!Empty(ac_style)&&!Empty(ac_style.width)?ac_style.width:880)
  ac_style.maximized = (!Empty(ac_style)&&typeof(ac_style.maximized)!='undefined'?ac_style.maximized:false)
  localStorage.setItem('zucchetti_ac_style',JSON.encode(ac_style));
  ActionCodeLayer=new spModalLayer('editManifest.htm?name='+document.id(id).value,{'in_iframe':true,
    'draggable':true,
    // 'top':40,
    // 'left':20,
    'width':ac_style.width,
    'height':ac_style.height,
    'resizable' :true,
    'border_color':'#CCCCCC',
    'border_width':1,
    'dragger_height':12,
    'dragger_image':'images/ps-editor-drag.png',
    'mask_opacity':0.4,
    'mask_color':'#CCCCCC',
    'show_scrollbars':false,
    'close_on_click_mask':'',
    'iframe_padding':0,
    'hide_close_btn':true,
    'maximize':true,
    'maximized':ac_style.maximized,
    'opener':window
  });
  ActionCodeLayer.open();
  codeOpen=true;
}

function CreateCustomEvent(evtName){
  var evt;
  if( navigator.userAgent.indexOf('MSIE')!=-1 ){
    evt = document.createEvent("CustomEvent");
    evt.initCustomEvent(evtName, false, false, {});
  } else {
    evt = new CustomEvent(evtName,{type:'UIEvent'})
  }
  return evt;
}
