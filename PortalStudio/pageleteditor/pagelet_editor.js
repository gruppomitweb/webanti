/* exported
    folder_path tool cols_n row_height newPropObj last_index m_bUpdated ItemEventInput
    resourcesList rows_n td_margin saving savingpic
    moveItems editItemEvent EditManifest deleteItem GetResourceName Help doLoad save
    openWinInsert removeAllHandlers addHandlers ListObj validColumn validRow
    validWidth validHeight ellipsis isItemInArea filterItems
  */

var tool = 'pageleteditor';
var raphael, stepsSVG;
var index=null; // per compatibilita' con gli altri editor (condivide properties.js)
var mainitem=null;
var resources = new Array();
var folder_path= '';
var classCssObj = [];
var dragStartDelta;
var Steps = [];
var working_skin = null;
// formProp.is960 = 'true'; gia inizializzato in itemsObj.js
Array.prototype.GetResourcesById = function( id ) {
  return (this.filter( function ( element/*, index, array */) {
    if( element.id == id )
      return element;
  }, this ))[0] || null;
}
Array.prototype.GetResourcesByName = function( name ) {
  return (this.filter( function ( element/*, index, array */) {
    if( element.name == name )
      return element;
  }, this ))[0] || null;
}
Array.prototype.Complement = function(a,b){
 (b)||(b=a, a=this);
  return (Array.isArray(a) && Array.isArray(b))
    ? a.filter(function(x){return b.indexOf(x)===-1;})
    : undefined;
}
var itemsHTML =[];
var cols =[];
var rows =[];
var rows_n = '0';
var cols_n = '0';
var mode = "select" /*select insert delete edit drag popup */

/* draw var */
var col_width = 0,
  row_height = 0,
  row_start_gap = 25,
  h_ruler_gap = 15,
  td_margin=0;


var newPropObj = null;
var last_index = null;
var m_nFrontendPort=null;
var m_bUpdated = false;
var codeManifest='';
/* variabili per il plan collegato */

function setPlanVar(){
  var r ={};
  r.win= parent.getFrameObj(planIframeId);
  r.item= r.win.itemsHTML[r.win.index];
  this.getPlanVar = function(){
    return r;
  }
}



function isPlanLinkedOn(){
  return openFromPlan && planIframeId && planItemId
}

function beep(){
  document.querySelector('#audio_error').play();
}

/* Resize function */

function moveItems(dir,e/* ,notResize */) {
  m_bUpdated=true;
  // var  canResize = notResize ? notResize : false;
  var action = (e != null && (e.shiftKey ||  e.ctrlKey ) ? 'resize' : 'move');
  if( action == 'move' ){
    switch(dir){
      case 'up':
        if( mainitem.row == 0){
          beep();
        } else {
          mainitem.row = mainitem.row -1 ;
        }
      break;
      case 'down':
        if( mainitem.row + mainitem.height == formProp.rows_n ){
          beep();
        } else {
          mainitem.row = mainitem.row +1 ;
        }
      break;
      case 'left':
        if( mainitem.col == 0){
          beep();
        } else {
          mainitem.col = mainitem.col -1 ;
        }
      break;
      case 'right':
        if( mainitem.col + mainitem.width == formProp.cols_n ){
          beep();
        } else {
          mainitem.col = mainitem.col +1 ;
        }
      break;
    }
  } else {
    if( e.shiftKey && !e.ctrlKey){
      switch(dir){
        case 'up':
          if( mainitem.height == 1){
            beep();
          } else {
            mainitem.height = mainitem.height -1 ;
          }
        break;
        case 'down':
          mainitem.height = mainitem.height +1 ;
        break;
        case 'left':
          if( mainitem.width == 1){
            beep();
          } else {
            mainitem.width = mainitem.width -1 ;
          }
        break;
        case 'right':
          if( mainitem.col + mainitem.width == formProp.cols_n ){
            beep();
          } else {
            mainitem.width = mainitem.width +1 ;
          }
        break;
      }
    }
    if( e.shiftKey && e.ctrlKey ){
      switch(dir){
        case 'up':
          if( mainitem.row == 0){
            beep();
          } else {
            mainitem.height = mainitem.height +1;
            mainitem.row = mainitem.row -1;
          }
        break;
        case 'down':
          if( mainitem.height == 1 ){
            beep();
          } else {
            mainitem.height = mainitem.height -1;
            mainitem.row = mainitem.row +1;
          }
        break;
        case 'left':
          if( mainitem.col == 0){
            beep();
          } else {
            mainitem.width = mainitem.width +1;
            mainitem.col = mainitem.col -1;
          }
        break;
        case 'right':
          if( mainitem.width == 1 ){
            beep();
          } else {
            mainitem.width = mainitem.width -1 ;
            mainitem.col = mainitem.col +1;
          }
        break;
      }
    }
  }
  writeHTML();
}

/* End Resize function*/

function Help(the_property) {
	var i;
	var prop = '';
	if (typeof(anchorToFeature) != 'undefined') {
    if(typeof(the_property)!='undefined')
      prop+="pageleteditor_"+the_property.toLowerCase();
    if(prop!='' && prop in anchorToFeature)
      i=anchorToFeature[prop];
    else if(index!=null && "pageleteditor_"+itemsHTML[index].type.toLowerCase() in anchorToFeature)
      i=anchorToFeature["pageleteditor_"+itemsHTML[index].type.toLowerCase()];
    else
      i=anchorToFeature["pageleteditor"];
		windowOpenForeground(m_cHelpUrl + 'help/portalstudio/ps_urg_navigator.htm?' + URLenc(i + (prop != "" ? '||' + prop + "" : "")), '', 'toolbar=0,menubar=0,directories=0,width=720,height=600,resizable=1,scrollbars=1');
	}
}



/*Domready*/
function doLoad(e,id,frontendport){

  working_skin = skinList.split(",").filter(function (skin) {
    return currentname.indexOf("/"+skin+"/") > -1;
  })[0] || null;

  notimooManager = new Notimoo({});

  if (!Empty(frontendport)) {
    m_nFrontendPort = frontendport;
  }

  /*aggiunta degli eventi agli elementi del dom*/
  LibJavascript.Events.addEvent( document.body, 'keydown', manageItems );
  LibJavascript.Events.addEvent( document.body, 'help', CancelHelp );
  LibJavascript.Events.addEvent( 'backcanvas', 'click', function(event){
    event.stopPropagation();
    switch( mode ){
      case 'select':
      case 'edit':
        document.getElementById('properties').hide();
        deselectCurrentItem();
        writeHTML();
      break;
    }
  });
  LibJavascript.Events.addEvent( 'backcanvas', 'dragover', editor.hightlightCell );
  LibJavascript.Events.addEvent( 'backcanvas', 'drop', editor.dropItem );
  LibJavascript.Events.addEvent( 'backcanvas', 'mouseenter', function(event){
    event.stopPropagation();
    switch( mode ){
      case 'select':
      case 'edit':
        this.style.cursor = "pointer";
      break;
      case 'insert':
        this.style.cursor = "copy";
      break;
    }
  });


  /*creazione dell'elemento per Raphael*/
  raphael = Raphael(Ctrl('backcanvas'), Ctrl('backcanvas').offsetWidth, Ctrl('backcanvas').offsetHeight);



  /* prima della load per poter impostare il contesto is960 */
  FormProperties();

  /* creazione della grid e delle risorse */
  editor.load();
  PlanLinkInit();

  create_gadget_pane();

  resizeGadgetsPane();

  /* creazione toolbar */
  new SPToolbar(ZTPageletObjects.PSToolbarAction, 'sptoolbar_action', {
    elementToShow: 'all'
  });
  new SPToolbar(ZTPageletObjects.PSToolbarItem, 'sptoolbar_item', {
    elementToShow: 'all'
  });

  m_bUpdated = false;

  if(!Empty(formProp["css_code"])) {
    classCssObj = JSON.parse(formProp["css_code"]);
  }

  /*rimozione del loader*/
  document.getElementById('container').setStyle('opacity','1');
  new Fx.Morph('loader',{}).start({'opacity':0}).chain(function(){
    document.getElementById('loader').setStyle('display','none');
  })
};

function PlanLinkInit(){
  /* impostazioni per il plan linkato */

  if(isPlanLinkedOn()){
    setPlanVar();
    document.getElementById('add_resource').addEvent('click', function(){
      if( confirm("You are leave pageletEditor to add Resource to the associated Plan. Are you sure to continue?") ){
        // seleziona l'iframe del plan
        parent.selectCurrentObj(planIframeId.substring(planIframeId.lastIndexOf('frame')+5));
        // leggo le variabili del plan
        var plan  = getPlanVar();
        /* controllo se � selezionata la page corretta */
        if( plan.item ) {
          if( plan.item.name != planItemId ){
            //selezione la page corretta
            plan.win.selectItemByName( planItemId );
          }
          plan.win.SelectContents(plan.win.index,planItemId);
          /* ridefinisco la chiamata a Properties per poter riportare i nuovi dati */
          var oldFunc = plan.win.Properties;
          plan.win.Properties = function(){
            loadFromPlan();
            oldFunc();
            plan.win.Properties = oldFunc;
          }
        } else {

        }
      } else {

      }
    })
    /* caricamento delle risorse del plan */
    loadFromPlan();
  }
}

function loadFromPlan(){
  //caricamento delle risorse dal plan
  var plan = getPlanVar();
  var contents=plan.item.contents.split(',');
  var groups=plan.item.groups.split(',');
  for(var i=0;i<contents.length;i++){
    if(!Empty(contents[i]))
      addResource(contents[i],'resource',groups[i]);
  }
}

function renderLayout_Steps (){ // i pallini
  if(stepsSVG==null)
    stepsSVG = Raphael(document.getElementById('layoutSteps'),document.getElementById('backcanvas').getSize().x,15);
  else
    stepsSVG.clear();
  if(typeof(formProp.layout_step)!='undefined'&&formProp.layout_step!==""){
    var div = document.getElementById('layoutSteps');
    var backcanvas = document.getElementById('backcanvas');
    // div.setStyle('width', backcanvas.offsetWidth - ( div.offsetLeft -backcanvas.offsetLeft ));
    // stepsSVG.setSize(div.offsetWidth,15);
    var steps = formProp.steps.split(',');
    var arrowH = 10,
      arrowPunta = 10,
      circleSize = 5,
      arrowColor = "#D5D5D5",
      circleColor = "#484848",
      textColor = "#000000",
      defaultStep = 100,
      step_ratio = 1;// stepsSVG.width > (defaultStep+parseInt(steps[steps.length-1]))?1:stepsSVG.width/(defaultStep+parseInt(steps[steps.length-1]));
    steps.forEach(function(item,index,array){
      array[index] = parseInt(item);
    });
    steps.sort(function(a,b){return a>b;});
    Steps = steps;
    backcanvas.style.width = Math.max(backcanvas.offsetWidth,steps[steps.length-1]+div.offsetLeft) +"px";
    div.setStyle('width', backcanvas.offsetWidth - ( div.offsetLeft -backcanvas.offsetLeft ));
    stepsSVG.setSize(div.offsetWidth,15);
    // steps.push((defaultStep+steps[steps.length-1]));

    /* disegno lo step */
    for(var i=0; i<steps.length;i++ ){
      /* variabili per i disegni */
      var A = ((i==0?circleSize*2:steps[i]*step_ratio+circleSize)+arrowPunta)+",0",
        B = "L"+(steps[i+1]*step_ratio-arrowPunta-circleSize)+",0",
        C = "L"+(steps[i+1]*step_ratio-circleSize)+","+arrowH/2,
        D = "L"+(steps[i+1]*step_ratio-arrowPunta-circleSize)+","+arrowH,
        E = "L"+((i==0?circleSize*2:steps[i]*step_ratio+circleSize)+arrowPunta)+","+arrowH,
        F = "L"+(i==0?circleSize*2:steps[i]*step_ratio+circleSize)+","+arrowH/2;

      var labelPosX =(i==0?circleSize*2:steps[i]*step_ratio+circleSize)+arrowPunta;
      if( parseInt(formProp.layout_step) == steps[i].toString() ){ /* Step corrente */
        arrowColor = "#00A0BD";
        textColor = "#FFFFFF";
        circleColor = "#00A0BD";
      } else {
        arrowColor = "#D5D5D5";
        textColor = "#000000";
        circleColor = "#999999";
      }

      if( i == steps.length-1 ) {  /* step default */
        B = "L"+((steps[i]+defaultStep)*step_ratio-circleSize)+",0",
        C = "L"+((steps[i]+defaultStep)*step_ratio-circleSize)+","+arrowH/2,
        D = "L"+((steps[i]+defaultStep)*step_ratio-circleSize)+","+arrowH,
        // arrowColor = arrowColor +"#FFFFFF"
        arrowColor = "0-"+arrowColor+":60-#FFFFFF:80-#FFFFFF:100"
      }

      stepsSVG.setStart();

      stepsSVG.path("M"+A+B+C+D+E+F+"L"+"z").attr({"stroke":"none","fill":arrowColor});

      stepsSVG.text(labelPosX,4, steps[i])
        .attr({
          "stroke": 'none',
          "fill" : textColor,
          'text-anchor': 'start',
          'font-size':'8',
          'font-family':'Open Sans',
          'font-weight': '300'
        });

      stepsSVG.circle(steps[i]=='0'?circleSize:steps[i]*step_ratio, circleSize, circleSize)
        .attr("fill", circleColor)
        .attr("stroke", "none")
        .attr("title", "Go to "+steps[i]+" layout step");
      var set = stepsSVG.setFinish()
        .attr("cursor", "pointer");
      set.step_tmp=steps[i].toString();
      set.click(function(){ /* click su ogni elemento del set*/
        var oldVal = formProp.layout_step;
        // document.getElementById('Form_generic_layout_step').value=this.step_tmp;
        formProp.layout_step=this.step_tmp;
        updateLayoutSteps(oldVal,this.step_tmp);
        FormProperties(true);
        // document.getElementById('Form_generic_layout_step').fireEvent('onchange');
        }.bind(set)
      )
    }
  }
}

var saving;
var savingpic;
var old_name='';
var notimooManager;
var strTheme = "";
var codeOpen = false;
var AfterSave;
function save(theme){
  if(codeOpen) {
    if(ActionCodeLayer)
      ActionCodeLayer.getContainer().getElement('iframe').contentWindow.fireEvent('save');
  }
  if(theme==null) theme='';
  if(currentname!=""){
  if(parent) parent.is_Saving=true;
  if(typeof(theme) == 'string' && !Empty(theme) && theme.indexOf("function") == -1){
    strTheme = theme;
  }
  if(typeof(theme) == 'string' && theme == 'close')
    AfterSave == window.parent.closeCurrentObj;
  if(typeof(theme) == 'function')
    AfterSave = theme;
  // notimooManager = new Notimoo({});
  notimooManager.show({
     title:'Notification message',
     message: 'saving pageleteditor...'+currentname,
     sticky : true,
     width:200,
     height:40
  });
  save2.delay(100);
  } else {
    window.parent.saveAsTool()
  }
}

function save2(){
  var jsonObj = []
  formProp.action_code = codeevents;
  formProp.codemanifest = codeManifest;
  for( var prop in formProp)
    formProp[prop] = typeof(formProp[prop]) == 'boolean' ? (formProp[prop] ? 'true' : false ) : formProp[prop];
  formProp['css_code'] = JSON.stringify(classCssObj);
  jsonObj.push(formProp); /*  JSON.stringify(formProp); */

  /* imposto gli step */
  updateLayoutSteps(formProp.layout_step);

  /* creo una copia di lavoro per le risorse inserite */
  var resClone = itemsHTML.slice(0);

  /* ordino le risorse: prima le aree, poi per row e col */
  resClone = sortRes(resClone);
  if( false ) {

    /* creo la struttura di aree inserendo le risorse nelle aree che le contengono da disegnatore */
    for(var i=0;i<resClone.length;i++){
      var t = resClone[i];
      if(t.type=='area' ){
        if( t.area_type=='normal' ||t.area_type=='fixed' ){
          resClone = insertItemsInArea( resClone, i, i+1) ;
          /* le risorse dell'area sono state rimosse da resClone
           * potrebbero essere state rimosse risorse precedenti all'area (non dovrebbe succedere visto l'ordinamento)
          */
          i = resClone.indexOf(t);
        } else if( t.area_type=='structure'){
          /* rimuovo le aree di struttura che potrebbero essere state modificate */
          resClone.splice(i,1);
        }
      }
    }

    /* creo la struttira per un elemento stretch */
    resClone = SetStretchEnvironment( resClone );

    /* creo ulteriori aree per permettere la creazione dell'html */
    resClone = CreateResourcesLogicStructure( resClone );

    /* ordino le risorse: prima le aree, poi per row e col */
    resClone = sortRes(resClone);

    // generazione delle proprieta' per il 960
    // appena fatta la stringify

      /*Ordinamento dell'array in base alla riga/colonna*/
    resClone = valuateStepsItems(resClone);
    // resClone = valuatePrefxSuffix(resClone,0,parseInt(formProp.cols_n));

  }

  jsonObj = jsonObj.concat(resClone); //inserico tutte le risorse inserite
  // jsonObj = jsonObj.concat(resources.Complement(resClone)); //aggiungo le risorse non inserite

  function stringify(key,value){
    if( key == "objClass" || key == "pict" || key =="html_item" || key == "wrapper" )
      return undefined;
    else /* if( key == 'items') */
      return (typeof(value)=='boolean') ? (value?'true':'false') : ( typeof(value)=='number' ? value.toString() : value);
  }

  var jsonStr = JSON.stringify(jsonObj,stringify);
  var pagelet_name='',
    folder_path='';
  currentname=Strtran(currentname,"#2","")
  if(window.location.href.indexOf("name=")>-1){
    old_name=window.location.href.substr(window.location.href.indexOf("name=")+5);
    if(old_name.indexOf("&")>-1)
      old_name=old_name.substring(0,old_name.indexOf("&"));
    }
  currentname=Strtran(currentname,'\\',"/");
  if(currentname.indexOf('/')>-1){
    folder_path=currentname.substring(0,currentname.lastIndexOf("/")+1)
    pagelet_name=currentname.substring(currentname.lastIndexOf("/")+1)
  }else{
    pagelet_name=currentname;
  }
  if(strTheme !='' && strTheme!=null){
    folder_path="/../"+strTheme;
  } else {
    strTheme = folder_path.replace(/\W/g,"");
  }

  /*chiamata per il salvataggio*/
  var url = new JSURL("../servlet/JSPSave?"+
      "type=pageleteditor&"+
      "name="+pagelet_name+(m_nFrontendPort?"&frontendport="+m_nFrontendPort:"")+"&"+
      "folder_path="+folder_path+"&"+
      "def="+URLenc(jsonStr)+"&"+
      "offline="+formProp['offline']+(!Empty(codeManifest)?"&"+
      "customManifest="+URLenc(formProp['manifest']):"")+"&"+
      "m_cID="+cmdhash,
    true)
  var output=url.Response()
  if(window.parent.changeName)
    window.parent.changeName( pagelet_name, folder_path?{folder_path:strTheme}:{},Strtran(window.frameElement.id,'portalstudioframe',''))
  if (output==null) output=""
  switch(output) {
    case "true":
      notimooManager.show({
         title:'Notification message',
         message: 'pageleteditor '+pagelet_name+' saved!',
         visibleTime: 2000,
         width:200
      });
      notimooManager.close(notimooManager.elements[0]);
      if(parent)
        parent.is_Saving=false;
      // currentname=Strtran(currentname,'/','')
      if(Empty(old_name) || old_name!=currentname){
        var planPar = isPlanLinkedOn() ? "&planIframeId="+planIframeId+"&planItemId="+planItemId : "";
        window.location.href=SPWebRootURL+'/pageleteditor/pagelet_editor.jsp?id='+fileName+"&name="+currentname+planPar;
      // if(Empty(old_name) || old_name!=currentname){
        // window.location.href= ((window.location.href.indexOf("name=")==-1)
                               // ? ((window.location.href.indexOf("?") ==-1) ?  window.location.href+"?name="+currentname : window.location.href+"&name="+currentname)
                               // : Strtran(window.location.href,old_name,currentname));
      }
      m_bUpdated=false
      if (arguments.length > 0 && arguments[0] == "close") window.parent.closeCurrentObj();

       /* salvo il nome nel plan se � collegato */
      if( isPlanLinkedOn() ) {
        /* aggiorna l'elenco delle pagelet del plan */
        var plan  = getPlanVar();
        var planTemplates = !Empty(plan.item.template) ? plan.item.template.split(',') : [];
        if(planTemplates.indexOf(pagelet_name)==-1){
          planTemplates.push(pagelet_name);
        }
        plan.item.template= planTemplates.join(',');
        plan.win.Properties();
        plan.win.writeHTML();
        plan.win.m_bUpdated=true;
        plan.win.openedPageletName= pagelet_name;
      }
      if(!Empty(AfterSave)){
        AfterSave();
        AfterSave=null;
      }
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

function valuateStepsItems(res){
  var steps = formProp.steps.split(','),
    stepIndex = 0,
    step = steps[0];
  do{
    step = steps[stepIndex++];
    res = valuatePrefxSuffix(res,step,0,formProp.cols_n);
  }while( stepIndex < steps.length );
  return res;
}

function valuatePrefxSuffix(res,step,startCol,cols_n,container){
  var  props, item, temp, i;
  temp = [];
  for(i=0;i<res.length;i++){ /* ciclo su tutti i ctrl di questo livello */
    item = res[i];
    props = step != null && item.layout_steps_values[step] ? item.layout_steps_values[step]: item;//altrimenti prende i valori di default
    if( item.type == 'area' ){
      if( !Empty(item.stretchBehavior) && item.stretchBehavior.test(/stretch$/) ){ //termina con stretch
        /* se l'item � un area che appartiene all'ambiente stretch before/stretch/after essendo in
         * display table-row non prende le dimenioni di prefx, suffx e width che saranno assegnare al
         * suo contenuto
        */
        // il container e' lo stretch_container
        container = step != null && container.layout_steps_values[step] ? container.layout_steps_values[step]: container;
        valuatePrefxSuffix( item.items, step, parseInt(container.col), parseInt(container.width), item);
      } else {
        valuatePrefxSuffix( item.items, step, parseInt(props.col),parseInt(props.width), item);
      }
    }
    if( Empty(temp[props.row]) ){
      temp[props.row] = [item];
    } else {
      temp[props.row].push(item);
    }
  }
  var prefx=0,suffx=0;
  for(i=0; i<temp.length; i++){  //ogni riga e' un array ordinato
    for(var j=0; temp[i] && j<temp[i].length; j++){
      item = res[res.indexOf(temp[i][j])];
      props = step != null && item.layout_steps_values[step] ? item.layout_steps_values[step] : item;//altrimenti prende i valori di default
      var last = (j == temp[i].length-1)
      if(j==0) { //first
        prefx = parseInt(props.col)-startCol;
      } else {
        var prevItem = res[res.indexOf(temp[i][j-1])];
        var prevProps = step != null && prevItem.layout_steps_values[step] ? prevItem.layout_steps_values[step] : prevItem; //altrimenti prende i valori di default
        prefx =  (parseInt(props.col) - (parseInt(prevProps.col) + parseInt(prevProps.width) ));
        if( prefx < 0 ){
          if( prevProps.behavior != 'show' || props.behavior != 'show' ) {
            prefx = parseInt(props.col)-startCol;
          } else {
            alert("Ci sono 2 elementi che si sovrappongono"+(step ? " allo step "+step: "") +": "+prevItem.name +" e "+item.name);
            prefx = 0;
          }
        }
      }
      if(last){ //last
        suffx = parseInt(cols_n)-( (parseInt(props.col) - startCol) + parseInt(props.width));
      }
      var width = Math.floor(parseInt(props.width)/cols_n*formProp.cols_n);
      props.prefx=prefx;
      props.suffx=suffx;
      props.renderWidth=width;
      prefx=suffx=0;
    }
  }
  return res;
}

function Reload(def){
  itemsHTML = [];
  formProp ={};
  index = null;
  mainitem=null;
  resources = []
  $$('.resource_item').destroy();
  var item = null;
  var defs = JSON.parse(def);
  var defForm,defRes=[];
  for( var i = 0;i< defs.length;i++){
    if(defs[i].type == 'pagelet')
      defForm = defs[i];
    else{
      defRes.push(defs[i]);
    }
  }
  codeevents=defForm.action_code;
  codeManifest = defForm.codemanifest || "" ;
  formProp = new ZTPageletObjects.pageletObj();
  for(var prop in defForm){
    formProp[prop] = (/^(true|false)$/i).test(defForm[prop]) ? (/^(true)$/i).test(defForm[prop]) : defForm[prop];
  }
  /*crea prima i gruppi*/
  defRes.sort(function(a,b){
    if(a.type == 'group')
      return -1;
    if(b.type == 'group')
      return 1;
  })
  for(i=0; i < defRes.length;i++){
    /* passaggio da tabs del gruppo e da flex delle aree a layout*/
    if( !defRes[i].layout ){
      if (defRes[i].type == "group" && defRes[i].tabs != 'none'){
        defRes[i].layout = defRes[i].tabs;
      }
      if( defRes[i].type == "area" && defRes[i].flex != 'false'){
        defRes[i].layout = defRes[i].flex;
      }
    }
    delete defRes[i].flex;
    delete defRes[i].tabs;
    if( defRes[i].type=='area'){
      addAreaRes( defRes[i] );
    } else {
      addResource(defRes[i],defRes[i].type,defRes[i].container)
    }
  }
  for(i=0;i<resources.length;i++){
    if(resources[i].inserted){
      item=resources[i];
      itemsHTML.push(item);
      item.inserted = true;
      if( item.html_item ) {
        item.html_item.classList.add('inserted');
      }
    }
  }
  writeHTML();
  FormProperties(true);
  document.getElementById('properties').hide();
  m_bUpdated = false;
}

function addAreaRes(area){
  var items =  area.items;
  area.items = [];
  /* rimuove le strutture che vengono ricreate al salvataggio  */
  if( area.area_type != 'structure') {
    addResource(area, 'area', area.container);
  }
  if( typeof(items) == 'string' && items.indexOf('[')==0 || typeof(items) == 'object' ){
    if( typeof(items) == 'string' )
      items = JSON.parse(items);
    for(var i=0; i<items.length; i++){
      if( items[i].type == 'area' ){
        addAreaRes(items[i]);
      }
      if( ! ( items[i].type == 'area'  &&  items[i].area_type == 'structure') )
        addResource(items[i], items[i].type, items[i].container);
    }
  }
}

function canInsert( res ) {
  var caninsert=true;
  //se si tratta di una risorsa e questa appartiene ad un gruppo gia' inserito ne inibisco l'inserimento
  if( res.type == 'resource' && !Empty(res.container) ){
    var container = resources.GetResourcesByName( res.container )
    if(  container && container.inserted ){
      notimooManager.show({
         title: 'Warning:',
         message: 'Resource "'+res.name +'", jet inserted with his group "'+ res.container+ '"',
         sticky : true,
         width:200,
         height:40
      });
      // caninsert = true;
    }
  } else if( res.type == 'group' && !Empty(res.content) ){
    var itemsContained = res.content.split(',');
    for( var i=0; i<itemsContained.length ; i++){
      var content = resources.GetResourcesByName( itemsContained[i] );
      if(  content && content.inserted ){
        notimooManager.show({
          title: 'Warning:',
          message: 'Resource "'+content +'" included in this group is already inserted',
          sticky : true,
          width:200,
          height:40
        });
        // caninsert = true;
      }
    }
  }

  return caninsert;
}

function clearInsert(event){
  event.stopPropagation();
  if(event.keyCode == '27') { //Esc
    mode = "select";
    mainitem = null;
    LibJavascript.Events.removeEvent( "backcanvas", 'click', insertItem );
    LibJavascript.Events.removeEvent( document.body, 'click', clearInsert );
  }
}

/* funzione richiamata dalla SPToolbar per la creazione e l'aggiunta dei ctrl */
function addItem( event, type ){
  /* creazione dell'item */
  var item = addResource('',type);
  mode = 'insert';
  mainitem = item;
  /* impostato il click sul backcanvas per l'insertItem */
  if( event.type == "click" ) {
    LibJavascript.Events.addEvent( 'backcanvas', 'click', insertItem );
    LibJavascript.Events.addEvent( document.body, 'keydown', clearInsert );
  }
}

function insertItem(event) {
  /* trova la posizione per l'inserimento dell'item selezionato
    inserimento dell'item nell'array itemsHTML
  */
  event.stopPropagation();
  LibJavascript.Events.removeEvent( document.body, 'keydown', clearInsert );
  LibJavascript.Events.removeEvent( "backcanvas", 'click', insertItem );
  canInsert(mainitem); /* Controllo dell'inserimento della risorsa e del suo gruppo */
  mainitem.inserted = true;
  itemsHTML.push(mainitem);
  // itemsHTML = sortRes(itemsHTML);
  var col, row;
  for( var i=0; i<cols.length; i++) {
    var c = cols[i].getBoundingClientRect();;
    row = 0;
    if( event.clientX < c.right && event.clientX > c.left ) { //COLUMN
      col = i;
      for(var j=0; j<rows.length; j++) {
        var r = rows[j];
        var rr = r.html.getBoundingClientRect();
        if( rr.top < event.clientY && rr.bottom > event.clientY ) {
          row = j;
          break;
        }
      };
      break
    }
  }
  mainitem.row =  row;
  mainitem.col = col;
  mainitem.width = 1;
  mainitem.height = 1;
  drawItem(mainitem);
  if( mainitem.html_item ){
    mainitem.html_item.classList.add('inserted');
  }
  /* Se inserisco nell'ultima riga aggiungo una nuova riga sotto*/
  if(mainitem.row == parseInt(formProp.rows_n)-1 ){
    formProp.rows_n = parseInt(formProp.rows_n)+1;
    writeHTML();
  }

  selectItem(mainitem);
  mode = 'edit';
  m_bUpdated = true;
}

function removeItemsFromPopupPiker(item, popupItemIndex, removedItem){
  var popupItem = item.popupItems[popupItemIndex];
  removedItem.destroy(); //li
  resources.GetResourcesById( popupItem.id).html_item.classList.remove("inserted"); //list
  item.popupItems.splice(popupItemIndex);
}

function drawItem(item){
  var col = item.col = parseInt(item.col);
  var row = item.row = parseInt(item.row);
  var width = item.width = parseInt(item.width);
  var height = item.height = parseInt(item.height);
  var b = document.getElementById('backcanvas').getBoundingClientRect();
  var c_start = cols[col].firstChild.getBoundingClientRect();
  var area_c_start = cols[col].getBoundingClientRect();
  var c_end = cols[col+width-1].firstChild.getBoundingClientRect();
  var area_c_end = cols[col+width-1].getBoundingClientRect();
  var x = (item.type=='area'? area_c_start.left : c_start.left) - b.left;
  var y = 0;
  var w = (item.type=='area'? area_c_end.right : c_end.right) - (item.type=='area'? area_c_start.left : c_start.left);
  var h = 0

  var behavior_class = item.behavior ? ' '+item.behavior : '';
  if(item.hidden)
    behavior_class = ' hide';
  if(item.pict)
    item.pict.parentElement.removeChild(item.pict);
  item.pict = CreateRect( x, y, w, h, "item_rect item_"+item.type+behavior_class+(item==mainitem?" selected":""));

  item.pict.data = item;

  item.pict.setAttribute('title', item.name);
  item.pict.addEventListener('mouseenter', function(){
    if(mode=='insert'){
      if( this.data.type == "area" ){
        item.pict.style.cursor = "copy";
      } else {
        item.pict.style.cursor = "no-drop";
      }
    }
    if(mode=='edit'){
      item.pict.style.cursor = "move";
    }
    if(mode=='select'){
      item.pict.style.cursor = "pointer";
    }
  })

  var span = document.createElement('span');
  span.className = "item_title";
  span.innerText = item.name;

  var render = document.createElement('div');
  render.id = item.name+"_render";
  render.className = "ctrl_render";

  if( item.popupItems.length > 0){
    span.appendChild(createPopupList(item));
  }
  item.pict.appendChild(span);
  item.pict.appendChild(render);


  if( item==mainitem ){
    item.pict.resize_handle = document.createElement('div');
    item.pict.resize_handle.className = "resize_handle";
    item.pict.resize_handle.parent = item.pict;
    item.pict.appendChild( item.pict.resize_handle );
    item.pict.resize_handle.addEventListener('mousedown', initResize, false);
    item.pict.setAttribute("draggable",true);
  }
  // ellipsis(item);
  if( item.type == 'static'){
    if( !Empty(item.src) && item.src.indexOf('_portlet.jsp')>-1){
      var ok=false;
      // if( !Empty(folder_path)){
        // try{
          // ok = (ZtVWeb.Include(".."+folder_path+"/jsp-decorators/"+item.src+"?SpWireframe=true&containerID="+item.name+"_render",item.name+"_render",true)!=404);
        // }catch(err){}
      // }

      if( !ok ){
        try{
          ok = (ZtVWeb.Include("../" + working_skin + "/jsp-decorators/" + item.src + "?SpWireframe=true&containerID=" + item.name + "_render", item.name + "_render", true) != 404);
        }catch(err){}
      }
      if( !ok ){
        try{
          // ok = (ZtVWeb.Include("../jsp/"+item.src+"?SpWireframe=true&containerID="+item.name+"_render",item.name+"_render",true)!=404);
          ok = (ZtVWeb.Include("../jsp/"+item.src+"?SpWireframe=true",item.name+"_render",true)!=404);
        }catch(err){}
      }
      if( !ok ){
        render.innerHTML = "Portlet non trovato";
      }
    }
  }
  /* Controllo di non dover aggiungere righe */
  if(row + height > parseInt(formProp.rows_n)-1 ){
    formProp.rows_n = row + height+1;
    writeHTML();
  }
  // item.pict.graphicSet = raphael.setFinish();
  col = 0;
  row = 0;

  // item.pict[0].addEventListener('dragover', function(event){

  // item.pict[0].addEventListener('drop', function(event){
  // if(item.type == "area"){
    addDropEvent(item);
  // }
  item.pict.addEventListener('dragstart', function(event){
    var br = this.getBoundingClientRect();
    dragStartDelta = {
      x: event.clientX - br.left,
      y: event.clientY - br.top,
      w: this.data.width,
      h: this.data.height
    };
    event.dataTransfer.effectAllowed = "move";
    HideProperties();
    var _this = this;
    setTimeout( function(){_this.classList.add('ondrag');}, 10); //per evitare che di default l'immagine draggata abbia l'opacita'
  });
  item.pict.addEventListener('dragend', function(/*event*/){
    this.classList.remove('ondrag');
    ShowProperties();
  });
  // item.pict.click(function(event){
  item.pict.addEventListener('click', function(event){
    event.stopPropagation();
    if(mode != 'insert'){
      if( itemsHTML.indexOf(item) != index ) {
        deselectCurrentItem();
      }
      selectItem(item);
    } else {
      if( item.type == 'area' ){
        insertItem(event);
      }
    }

  }, false);
}

function addDropEvent(item) {
  item.pict.addEventListener('dragover', function(event){
    if(mode!='popup'){
      event.preventDefault();
      this.classList.add('ondrag');
    }
  });
  item.pict.addEventListener('dragleave', function(/*event*/){
    this.classList.remove('ondrag');
  });
}

function createPopupList(item){
  var popup = document.createElement('a');
  popup.innerText = String.fromCharCode(parseInt('&#xe6db;'.substring(3,7),16));
  popup.className = "popup_picker";
  popup.id = item.id+"popup_picker";
  popup.addEventListener('click', function(event){
    var ul = document.querySelector('#popup_picker_container')
    if(!ul){
      ul = document.createElement('ul');
      ul.id= "popup_picker_container";
      document.querySelector('#backcanvas').appendChild(ul);

      ul.addEventListener("mouseleave", function(){
        this.closeTimer = setTimeout( function(ul){
          return function(){
            ul.classList.add("close");
            document.querySelector("#"+ul.getAttribute("picker-id")).classList.remove("opened");
          }
        }(this) ,1000);
      });
      ul.addEventListener("mouseenter", function(){
        if( this.closeTimer )
          window.clearTimeout(this.closeTimer);
      });
    }
    if( this.classList.contains("opened")){
      this.classList.remove("opened");
      ul.classList.add("close");
    } else {
      ul.classList.remove("close");
      ul.setAttribute("picker-id", this.id);
      ul.innerHTML = "";
      for( var i=0;i<item.popupItems.length;i++){
        var popupItem = resources.GetResourcesById(item.popupItems[i].id);
        var li = document.createElement('li');
        li.innerText = popupItem.name;
        li.addEventListener('click', function(popupItem){ return function(){selectItem(popupItem)}}(popupItem));
        var close = document.createElement('a');
        close.className = "close";
        close.innerText = String.fromCharCode(parseInt('&#xe6fa;'.substring(3,7),16));
        close.addEventListener('click', function(item,popupItemIndex,removedItem){
          return function(){removeItemsFromPopupPiker( item, popupItemIndex, removedItem )}
        }(item,i,li));
        li.appendChild(close);
        ul.appendChild(li);

      }
      event.stopPropagation();
      this.classList.add('opened');

      var br = this.getBoundingClientRect();
      var bbr = document.querySelector('#backcanvas').getBoundingClientRect();
      ul.style.top = (br.top - bbr.top + br.height) + "px";
      ul.style.left = (br.left - bbr.left -ul.offsetWidth +br.width) +"px";
    }
  });
  return popup;
}

function initResize(e){
  e.stopPropagation();
  e.preventDefault();
  this._startX = e.clientX;
  this._startY = e.clientY;
  this._startW = parseInt(window.getComputedStyle(this.parent).getPropertyValue('width'));
  this._startH = parseInt(window.getComputedStyle(this.parent).getPropertyValue('height'));
  var handle = this;
  /* handle to document for precision problem */
  document.addEventListener('mousemove', this, false);
  document.addEventListener('mouseup', this, false);
  this.handleEvent = function(evt){
    switch(evt.type){
      case 'mousemove':
        onResize(evt, handle);
      break;
      case 'mouseup':
        endResize(evt, handle);
      break;
    }
  }
}

function onResize(e, handle){
  /* effetto calamita */
  var x = e.clientX;
  var y = e.clientY;
  var Hsnap = cols.some( function(c/*,index*/){
    var cr = c.getBoundingClientRect();
    if( ( cr.right - cr.width/8) < x && x < ( cr.right + cr.width/8)  ) { /* index == cols.length-1 se e' l'ultimo allora metti la dimensione massima */
      if( handle.parent.data.type != 'area' )
        handle.parentElement.style.width = (handle._startW + c.firstChild.getBoundingClientRect().right - handle._startX) + 'px';
      else
        handle.parentElement.style.width = (handle._startW + cr.right - handle._startX) + 'px';
      return true;
    }
  });
  var Vsnap = rows.some( function(r/*,index*/){
    var rr = r.html.getBoundingClientRect();
    if( ( rr.bottom - rr.height/8) < y && y < ( rr.bottom + rr.height/8)  ) { /* index == cols.length-1 se e' l'ultimo allora metti la dimensione massima */
      if( handle.parent.data.type != 'area' )
        handle.parentElement.style.height = (handle._startH + r.html.firstChild.getBoundingClientRect().bottom - handle._startY) + 'px';
      else
        handle.parentElement.style.height = (handle._startH + rr.bottom - handle._startY) + 'px';
      return true;
    }
  });

  if( !Hsnap )handle.parentElement.style.width = (handle._startW + e.clientX - handle._startX) + 'px';
  if( !Vsnap )handle.parentElement.style.height = (handle._startH + e.clientY - handle._startY) + 'px';
}

function endResize(e, handle){
  /* set new size */
  cols.some( function(c,index){
    var cr = c.getBoundingClientRect();
    var hr = handle.parentElement.getBoundingClientRect();
    if( (cr.left < hr.right && cr.right > hr.right) || index == cols.length-1 ){ /* se e' l'ultimo allora metti la dimensione massima */
      handle.parent.data.width =  index - handle.parent.data.col + 1;
      return true;
    }
  });
  rows.some( function(r,index){
    var rr = r.html.getBoundingClientRect();
    var hr = handle.parentElement.getBoundingClientRect();
    if( rr.top < hr.bottom && rr.bottom > hr.bottom ){
      handle.parent.data.height = index - handle.parent.data.row + 1;
      return true;
    }
  });
  document.removeEventListener('mousemove', handle);
  document.removeEventListener('mouseup', handle);
  if( itemsHTML[index].type == 'static' ){
    document.getElementById(itemsHTML[index].name+"_render").dispatchEvent(new CustomEvent("resizeWireFrameContainer",{type:'UIEvent'}));
  }
}

function moveItem(e,row,col){
  var item = itemsHTML[index];
  /* set new position */
  item.col = col;
  item.row = row;
  if( row + item.height >= formProp.rows_n ){
    formProp.rows_n = Math.max( parseInt(formProp.rows_n) + 1, row + parseInt(item.height));
    writeHTML();
    // item.row = formProp.rows_n - item.height;
  }
  if( col + item.width > formProp.cols_n ){
    item.col = formProp.cols_n - item.width;
  }
  mode = 'edit';
  selectItem(item);
};

function createGrid(){
  var o_line, v_line, column;
  // var tot_width = raphael.width - row_start_gap;
  var tot_width;
  if( !Empty(formProp.layout_step)){
    if( formProp.layout_step!='0' )
      tot_width = formProp.layout_step;
    else{
      var steps = formProp.steps.split(',');
      if( steps.length > 1){
        steps.forEach(function(item,index,array){
          array[index] = parseInt(item);
        });
        steps.sort(function(a,b){return a>b;});
        tot_width = steps[1];
      } else {
        tot_width = raphael.width - row_start_gap;
      }
    }
  } else {
    tot_width = raphael.width - row_start_gap;
  }
  var tot_height = raphael.height;
  var cols_n = parseInt(formProp.cols_n);
    // rows_n = parseInt(formProp.rows_n);
  // var td_width=0, point_top=0;
  // row_height = (tot_height - row_start_gap) /rows_n;

  switch(cols_n){
  case 12 :
    col_width=Math.floor(tot_width*0.0833);
    // td_margin=Math.ceil(col_width*(formProp.is960?0.05:0)); // i margini sono il 5%
    // td_margin=Math.ceil(col_width*0.05); // i margini sono il 5%
    // td_width = col_width -(td_margin*2)
  break
  case 16 :
    col_width=Math.floor(tot_width*0.0625);
    // td_margin=Math.ceil(col_width*0.05); // i margini sono il 5%
    // td_width = col_width -(td_margin*2)
  break
  case 20 :
    col_width=Math.floor(tot_width*0.05);
    // td_margin=Math.ceil(col_width*0.05); // i margini sono il 5%
    // td_width = col_width -(td_margin*2)
  break
  }
  o_line = raphael.path("M"+row_start_gap+","+h_ruler_gap+"H"+raphael.width)
  o_line.attr({'stroke':'#000', 'stroke-width': '1', 'fill': 'none'});
  v_line = raphael.path("M1, "+row_start_gap+"V"+(tot_height))
  v_line.attr({'stroke':'#000','stroke-width': '1', 'fill': 'none'});
  // document.getElementById('grid_container').innerHTML = "<style>"+
      // ".col_item{"+
      // "   padding: 0px "+td_margin+"px;"+
      // "}"+
      // ".row_item{"+
      // "   padding: "+td_margin+"px 0px;"+
      // "}"+
      // "</style>";
  /*for(var i=0; i<rows_n; i++){
    // var row_height = calculateRowHeight( rows, i, (tot_height - row_start_gap));
    raphael.path("M1, "+(row_height*i+row_start_gap)+",0h4");
    raphael.text(8,row_height*i+row_start_gap+row_height/2, i);
    if( !rows[i] )
      rows[i] = {};
    rows[i].items = [];
    rows[i].html = CreateRect(row_start_gap,(col_height * i + row_start_gap),tot_width,col_height, "row_item");
    rows[i].html.innerHTML = "<div class='inner_row'></div>";
    rows[i].height = row_height;
    rows[i].innerHeight = row_height - 8 ; //4px padding
  }*/
  for(var i=0; i<cols_n; i++){
    raphael.path("M"+(col_width*i+row_start_gap)+","+h_ruler_gap+"v4");
    raphael.text(col_width*i+row_start_gap+col_width/2,row_start_gap-5,(i+1));
    column = CreateRect((col_width*i+row_start_gap),row_start_gap,col_width,tot_height - (row_start_gap+5), "col_item");
    column.innerHTML = "<div class='inner_col'></div>";
    cols[i] = column;
  }
}

function calculateRowHeight() {
  /* funzione che calcola le dimensioni di ogni riga in base ai suoi item contenuti */
  var i, j, item;
  var rowsHeight = [],
    emptyRows = [],
    empty = true,
    top = 0,
    minRowHeight = 80,
    rows_n = parseInt(formProp.rows_n),
    totalHeight = raphael.height - row_start_gap;
  /* marco la riga come vuota e in caso di sequenza finale di righe vuote le elimino */
  for(j=0; j<rows_n-1; j++) {
    rowsHeight[j] =  minRowHeight;
    emptyRows[j] = false;
    empty = true;
    for(i=0; i<itemsHTML.length; i++) {
      item = itemsHTML[i];
      /* inner_row correction */
      var h=item.pict.querySelector("div").offsetHeight + 20;
      if(item.height==1 && item.row==j) { //item alto 1 nella riga corrente
        rowsHeight[j] = Math.max(rowsHeight[j],h);
        empty = false;
      } else if(item.row+item.height-1 == j) { //sono nella riga di arrivo
          if(top + rowsHeight[j] < h) {
            for(var k=item.row;k<item.height-1;k++) { //trovo quanta altezza manca per questa riga
              h -= rowsHeight[k];
            }
            rowsHeight[j] = h;
          }
        empty = false;
      }
    }
    emptyRows[j] = empty; //marco la riga come vuota
    top += rowsHeight[j];
  }

  /* rimozione delle righe vuote */
  var stop = false;
  for(j=rows_n-2; !stop && j>0; j-- ) {
    if( emptyRows[j] ) {
      /* controlle che negli altri step non ci sia una risorsa nella riga */
      for(i=0; !stop && i<itemsHTML.length; i++) {
        item = itemsHTML[i];
        for( var s=0; s<Steps.length; s++){
          var step = Steps[s];
          if(  item.layout_steps_values[step] && parseInt(item.layout_steps_values[step].row) + parseInt(item.layout_steps_values[step].height) - 1 >= j ) {
            stop = true;
            break;
          }
        }
      }
      if( !stop ){
        formProp.rows_n = parseInt(formProp.rows_n) - 1;
        top = top - rowsHeight[j];
        rowsHeight.splice(j,1);
      }
    } else {
      break;
    }

  }

  /* gestione dell'ultima riga che non contiene mai item per costruzione */
  rowsHeight[rows_n-1] = minRowHeight;
  if( totalHeight > top) {
    rowsHeight[rows_n-1] = totalHeight - top; //il rimanente
  } else {
    var backcanvas = document.getElementById("backcanvas");
    backcanvas.style.height = top + rowsHeight[rows_n-1] + 'px';
    raphael.setSize(backcanvas.offsetWidth, backcanvas.offsetHeight);
  }
  // console.log(rowsHeight);
  return rowsHeight;
}

function renderRow(){
  var heights = calculateRowHeight();
  var tot_width, i;
  var backcanvas = document.getElementById('backcanvas').getBoundingClientRect();
  if( !Empty(formProp.layout_step)){
    if( formProp.layout_step!='0' )
      tot_width = formProp.layout_step;
    else{
      tot_width = Steps[1];
    }
  } else {
    tot_width = raphael.width - row_start_gap;
  }
  var rows_n = parseInt(formProp.rows_n);
  var top = 0;
  for(i=0; i<rows_n; i++){
    /* creazione dei righelli */
    var row_height = heights[i];
    raphael.path("M1, "+(top+row_start_gap)+",0h4");
    raphael.text(8,top+row_start_gap+row_height/2, i);

    if( !rows[i] )
      rows[i] = {};
    rows[i].items = [];
    rows[i].html = CreateRect(row_start_gap,(top + row_start_gap),tot_width,row_height, "row_item", 'top');
    rows[i].html.innerHTML = "<div class='inner_row'></div>";
    top += row_height;
  }

  /* inserimento degli item nelle righe */
  for(i=0; i<itemsHTML.length; i++) {
    var item = itemsHTML[i];
    var r_start = rows[item.row].html.firstChild.getBoundingClientRect();
    var area_r_start = rows[item.row].html.getBoundingClientRect();
    var r_end = rows[item.row+item.height-1].html.firstChild.getBoundingClientRect();
    var area_r_end = rows[item.row+item.height-1].html.getBoundingClientRect();
    item.pict.style.top = ((item.type=='area'? area_r_start.top : r_start.top) -backcanvas.top ) + 'px';
    item.pict.style.height = (item.type=='area'? area_r_end.bottom : r_end.bottom) - (item.type=='area'? area_r_start.top : r_start.top) + 'px';
  }

}

function writeHTML(){
  /* cancella la griglia e gli step */
  raphael.clear();
  document.getElementById('grid_container').innerHTML = '';

  /* svuoto il content explorer */
  var resource_ul = document.querySelector('#resource_container > ul');
  resource_ul.innerHTML = '';

  /* crea gli step */
  renderLayout_Steps();
  if(document.getElementById('backcanvas').getSize().x != raphael.width)
    raphael.setSize(document.getElementById('backcanvas').getSize().x, document.getElementById('backcanvas').getSize().y);

  /* disegna le righe e le colonne e svuota gli array rows[x].items */
  createGrid();
  resources = sortRes(resources);

  // Aggiorno solo il selezionato
  if( index!=null){
    if( mainitem.html_item ){
      mainitem.html_item.getElement('div.resource_item_text').set('text',mainitem.name);
    }
  }
  /* determino lo stato delle risorse e creo da questo il contents explorer
  *  il problema potrebbe essere rappresentato dalle risorse include in aree
  *  che sono in hide: devo mettere il hidden anche queste (hidden != behavior.hide)
  */
  resources.each(function(item){
    item.hidden = false;
    item.wrapper = null;
  });

  resources.each(function(item,ii){
    /* inserimento in modo innestato per rendere piu' comprensibile la struttura
    *  gli elementi sono ordinati: aree, grouppi, risorse
    *
    */
    addItemInContentExplorer(item);
    if( item.type == 'area'){
      /* valuto il suo contenuto */
      var a = item;
        /* gli item sono ordinati quindi posso partire nella ricerca dall'indice dell'area */
        for(var j=ii+1; j<resources.length; j++){
          var tj=resources[j];
          /* verifico se sia contenuto nell'area*/
          if(
            parseInt(tj.row)>=parseInt(a.row) &&
            (parseInt(tj.row)+parseInt(tj.height)) <= (parseInt(a.row)+parseInt(a.height)) &&
            parseInt(tj.col)>=parseInt(a.col) &&
            (parseInt(tj.col)+parseInt(tj.width)) <= (parseInt(a.col)+parseInt(a.width)) &&
            tj != a
          ) {
            tj.wrapper = a;
            if( item.behavior == 'hide' || item.behavior == 'popup' ){
              tj.hidden = true;
            }
          }
        }
    } else {
      if( item.popupItems.length > 0){
        for( var i=0;i<item.popupItems.length;i++){
          var popupItem = resources.GetResourcesById(item.popupItems[i].id);
          if( !popupItem || popupItem.behavior != 'popup'){
            item.popupItems.splice(i);
            i--;
          }
        }
      }
    }
  });


  /* sistemazione disegno in base alle bande:
  *  tutti gli elementi hanno altezza iniziale 1
  *  se nella banda � presente un'area, gli elementi esterni all area misurano la stessa altezza dell'area
  *  gli elementi all'interno dell'area seguono le stesse regole
  */

  /* l'ordine per la renderizzazione segue la regola:
  *  prima le aree secondo il loro z
  *  poi le risorse
  */

  resources.each(function(item/*, ii*/){
    if( item.pict )
      delete(item.pict);
    drawItem(item);
  });

  /* disegna i righelli e posiziona gli items */
  renderRow();

  Properties();
}

function selectItem(item){
  mainitem = item;
  writeHTML();
  index = itemsHTML.indexOf(item);
  index = index > -1 ? index : null;
  /* potrebbe essere stato selezionato un elemento del resource explorer quindi non presente in itemsHTML */
  if( index!=null ) {
    if( item.pict )
      item.pict.classList.add("selected");
    Properties();
    mode = 'edit';
  } else {
    HideProperties();
  }

  if( !(item.area_type=='fixed') && item.pict && !item.pict.resize_handle){
    item.pict.resize_handle = document.createElement('div');
    item.pict.resize_handle.className = "resize_handle";
    item.pict.resize_handle.parent = item.pict;
    item.pict.appendChild( item.pict.resize_handle );
    item.pict.resize_handle.addEventListener('mousedown', initResize, false);
    item.pict.setAttribute("draggable",true);
  }
  if( document.querySelector("#resourcelist .resource_item.selected") )
    document.querySelector("#resourcelist .resource_item.selected").classList.remove("selected");

  /* selected nel content explorer */
  if( item.html_item ){
    item.html_item.classList.add('selected');
    if( item.behavior != 'hide' ) {
      item.html_item.setAttribute( 'draggable', true );
    }
  }
}


function deselectCurrentItem(){
  if( index ) {
    var item = itemsHTML[index];
    // if( item && item.pict ){
      // item.pict.removeAttribute("draggable");
      // if( item.pict.resize_handle ) {
        // LibJavascript.DOM.removeNode( item.pict.resize_handle );
      // }
    // }
    if( item.html_item ) { /* with item in content explorer */
      item.html_item.classList.remove('selected');
    }
    index = null;
    mainitem =  null;
  }
}

function openWinInsert(id){
  window.layerOpenForeground('insert.jsp?tool=portlet&inputID='+id,"SelectPortlet",'',400,530,true,1);
}

function addResource(name, type, group/*, fromPlan*/){

  /* aggiunta delle risorse provenienti dal def e/o da un plan collegato
  *  resources non e' simmetrico a itemsHTML che sono i ctrl generati e presenti nella
  *  pagelet, resources e' la lista di tutte le risorse
  */
  if(group)
    addResource(group,'group');
  var item = null;
  var ul, res_indx, group_item;
  var indx = 0;
  if( resources.length > 0){
    var max_indx = 0;
    resources.each( function(item/*,i*/){
      res_indx = item.id.substr(item.id.lastIndexOf('_')+1).toInt();
      if( res_indx > max_indx )
        max_indx = res_indx;
    })
    indx = max_indx + 1;
  }
  var already_present= false;
  var obj;
  if( typeof name == 'object'){
    obj= name;
    name = obj.name;
  } else if( Empty(name)) {
    name = type +'_'+ indx;
  }
  for(var i=0; i < resources.length ; i++){
    if(resources[i].name == name){
      already_present = true;
      item = resources[i];
    }
    if(group && resources[i].name == group){
      group_item = resources[i];
      if(group_item.content.indexOf(name) ==-1)
        group_item.content += (Empty(group_item.content) ? name : ','+name)
    }
  }
  if(!already_present){
    switch(type){
      case('group'):
        item = new ZTPageletObjects.groupObj("item_group_"+indx,name,'') /*id,name,container*/
      break;
      case('resource'):
        item = new ZTPageletObjects.resourceObj("item_resources_"+indx,name,(group?group:''))
      break;
      case('static'):
        item = new ZTPageletObjects.staticObj("item_static_"+indx,Strtran(name,".jsp",""),'')
      break;
      case('area'):
        item = new ZTPageletObjects.areaObj("item_area_"+indx,name)
      break;
    }
    if(obj){
      for(prop in obj){
        if( prop == "wireframe_props" || prop == "steppable_prop") continue;
        if(item[prop] != 'undefined' )
          item[prop] = (/^(true|false)$/i).test(obj[prop]) ? (/^(true)$/i).test(obj[prop]) : obj[prop];
      }
    }else{
      for(var prop in item)
        item[prop] = (/^(true|false)$/i).test(item[prop]) ? (/^(true)$/i).test(item[prop]) : item[prop];
      item.inserted = false;
    }
    resources.push(item);
    item.type = type;
    /* Creazione delle risorse nell'elenco del contents explorer */
    if( ul ){
      addItemInContentExplorer(item);
      m_bUpdated = true;
    }
  }
  return item;
}

function addItemInContentExplorer(item){
  var html_item;
  /* generazione del contents explorer:
  *  se l'item ha un conteiner viene inserito in questo
  */

  var ul = item.wrapper ? document.querySelector('#'+item.wrapper.id+' > ul') : document.querySelector('#resource_container > ul');
  if( item.type == 'resource' && !Empty(item.container) )
    ul = document.querySelector('#'+resources.GetResourcesByName( item.container ).id+' > ul');

  if( ul && !ul.querySelector("#"+item.id) ){
    // LibJavascript.DOM.removeNode(document.querySelector("#resource_container #"+item.id));

    html_item = document.createElement('li');
    html_item.id = item.id;
    html_item.className = 'resource_item resource_item_'+item.type +(item.inserted? ' inserted' : '')+ ' ' +item.behavior+(item==mainitem?' selected':'');
    html_item.innerHTML = ' \
        <div id="'+item.id+'_ico" class="resource_item_ico"></div> \
        <div class="resource_item_text">'+item.name+'</div> \
        '+((item.type == "group" || item.type == "area" ) ?  '<ul></<ul>' : '' );
    ul.appendChild( html_item );
    if(item.behavior == 'hide') {
      html_item.addEventListener('click', function(){selectItem(resources.GetResourcesById( this.id ))})
      html_item.classList.add("inserted");
    } else {
      if( item.behavior == 'popup' ) {
        /* verifica se e' presente in qualche item */
        for( var j=0; j<itemsHTML.length;j++){
          if( itemsHTML[j].popupItems.length > 0){
            for( var i=0;i<itemsHTML[j].popupItems.length;i++){
              if( itemsHTML[j].popupItems[i].id == item.id){
                html_item.classList.add("inserted");
                break;
              }
            }
          }
        }
      }
      /* gestore degli eventi del contents explorer:
         il dragstart e' abilitato solo in caso di item selezionato tramite
         l'attributo draggable impostato al momento della selezione
      */

      html_item.addEventListener('dragstart', dragStartHtml_item);
      html_item.addEventListener('dragend', dragEndHtml_item);
    }
    /* selezione attiva su tutti gli elementi */
    html_item.addEventListener( 'click', function( event ) {
      event.stopPropagation();
      // var i = itemsHTML.indexOf(resources.GetResourcesById( this.id ));
      // if( i > -1){
        selectItem(resources.GetResourcesById( this.id ));
      // }
    })
    resizeGadgetsPane();
    item.html_item = html_item;
  }
  return !ul || ul.querySelector("#"+item.id);
}

function dragStartHtml_item(event){
  event.stopPropagation();
  mainitem = resources.GetResourcesById( this.id );
  if( mainitem.behavior == 'popup' ){
    mainitem.dropped = false;
    mode = 'popup';
    highlightPopupTarget();
    HideItem(mainitem);
  } else if(mainitem.behavior == 'show' && !index ) { /* verifica se e' gia presente altrimenti lo inserisco */
    mode = 'insert';
  }
  var crt = this.cloneNode();
  event.dataTransfer.setDragImage(crt, 0, 0);
  event.dataTransfer.effectAllowed = "move";
  HideProperties();
}

function dragEndHtml_item(/*event*/){
  ShowItem(mainitem);
  ShowProperties();
  removeHightlightPopupTarget();
  mode = 'edit';
}

function highlightPopupTarget(){
  var item, found=false;
  for(var i=0; i<itemsHTML.length; i++){
    item = itemsHTML[i];
    if( item.titled && item.titled != 'false' && item.pict ){
      found = true;
      item.pict.classList.add('hightlight');
      item.pict.addEventListener( 'dragover', allowDrag);
      item.pict.addEventListener( 'drop', dropPopup );
    }
  }
  if( !found)
    /* PSAlert. */alert("No titled resources where found. Please set at least one.");
}

function HideItem(item) {
  if( item.pict )
    item.pict.classList.add( 'hidden' );
}

function ShowItem(item) {
  if( item.pict )
    item.pict.classList.remove( 'hidden' );
}

function removeHightlightPopupTarget(){
  var item;
  for(var i=0; i<itemsHTML.length; i++){
    item = itemsHTML[i];
    if( item.titled && item.titled != 'false' && item.pict ){
      item.pict.classList.remove('hightlight');
      item.pict.removeEventListener( 'dragover', allowDrag);
      item.pict.removeEventListener( 'drop', dropPopup );
    }
  }
}

function allowDrag(event){
  event.preventDefault();
}

function dropPopup(event){
  event.stopPropagation();
  mainitem.dropped = true;
  addPopup(this);
}

function addPopup(target){
  mainitem.html_item.classList.add("inserted");
  var targetItem = target.data;/* itemsHTML.GetResourcesById(target.id); */
  targetItem.popupItems.push({'id':mainitem.id,side:'left','name':mainitem.name});
  writeHTML();
}

function ellipsis(item){
  var i = 0;
  var ellipsis = false;
  item.pict.text.attr('text',item.name)
  item.pict.text.attr('x',item.pict.getBBox().x+(item.pict.getBBox().width - item.pict.text.getBBox().width)/2)
  while(item.pict.text.getBBox().width > item.pict.getBBox().width){
    item.pict.text.attr('text',item.name.substring(0,item.name.length-i))
    i++;
    ellipsis = true;
  }
  if(ellipsis){
    item.pict.text.attr('text',item.name.substring(0,item.name.length-(i+2))+"...")
    item.pict.text.attr('x',item.pict.getBBox().x+(item.pict.getBBox().width - item.pict.text.getBBox().width)/2)
  }
}

function removeAllHandlers(){}
function addHandlers(){}
function ListObj(obj) {
  for(var i=0;i<itemsHTML.length;i++){
    if(itemsHTML[i].id=="item"+obj.value){
      selectItem(itemsHTML[i]);
      break;
    }
  }
}

/*Funzione di validazione degli itemsObj*/

function validColumn(value){
  value = parseInt(value)
  if(value< 0){
    // itemsHTML[index].col=0;
    PSAlert.alert('Column number must be > 0')
    return false;
  }
  if(value + parseInt(mainitem.width) > formProp.cols_n){
    // itemsHTML[index].col =  formProp.cols_n-itemsHTML[index].width;
    PSAlert.alert('Column number must be < '+(formProp.cols_n-mainitem.width+1))
    return false;
  }
  return true;
}
function validRow(value){
  value = parseInt(value)
  if(value< 0){
    // itemsHTML[index].row= 0;
    PSAlert.alert('Row number must be > 0')
    return false;
  }
  return true;
}
function validWidth(value){
  value = parseInt(value)
  if(value< 1){
    // itemsHTML[index].width = 1;
    PSAlert.alert('Width number must be > 1')
    return false;
  }
  if(value + parseInt(mainitem.col) > formProp.cols_n){
    // itemsHTML[index].width = formProp.cols_n-itemsHTML[index].col;
    PSAlert.alert('Width number must be < '+(formProp.cols_n-mainitem.col+1))
    return false;
  }
  return true;
}
function validHeight(value){
  value = parseInt(value)
  if(value< 1){
    // itemsHTML[index].height = 1;
    PSAlert.alert('Height number must be > 1')
    return false;
  }
  return true;
}
var resourcesList
var codeevents=""
var ItemEventInput
var ActionCodeLayer;
codeOpen=false;
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

//var ManifestCodeLayer;
function EditManifest(id){
    //var dialogValue
  var z_ac_style = localStorage.getItem('zucchetti_ac_style');
  var ac_style = !Empty(z_ac_style) ? JSON.parse(z_ac_style) : {};
  ac_style.height = (!Empty(ac_style)&&!Empty(ac_style.height)?ac_style.height:600)
  ac_style.width = (!Empty(ac_style)&&!Empty(ac_style.width)?ac_style.width:880)
  ac_style.maximized = (!Empty(ac_style)&&typeof(ac_style.maximized)!='undefined'?ac_style.maximized:false)
  localStorage.setItem('zucchetti_ac_style',JSON.encode(ac_style));
  ActionCodeLayer=new spModalLayer('editManifest.htm?name='+document.getElementById(id).value,{'in_iframe':true,
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
function deleteItem(){
  if(( mode=='edit' || mode=='select' ) && itemsHTML[index] ){
    var item = mainitem;
    item.inserted = false;
    if( item.html_item ){
      item.html_item.classList.remove( 'inserted' );
    }
    itemsHTML.splice(index,1)
    index = null;
    mainitem = null;
    writeHTML()
    document.getElementById('properties').hide()
  }
}
function GetResourceName() {

  /* chimata per la preview */
  var str = ''
  if(isPlanLinkedOn()){ //caricamento delle risorse dal plan
    str = "../jsp/"+getPlanVar().item.name+".jsp";
  }else{
    if(strTheme !='' && strTheme!=null){
      str ="/../"+strTheme+"/"
    }else{
      str = "../jsp/"
    }
    str += currentname+".jsp";
  }
  // var size = document.body.getSize();
  // document.getElementById('i_preview_wrapper').setStyles({'width': size.x,'height':size.y,'left':window.getSize().x,'top':30});
  // document.getElementById('i_preview').setStyles({'height': size.y,'top':0});
  return str;
}

function CreateRect(x,y,w,h,className,position){
  var div = document.createElement('div');
  div.style.left = x+"px";
  div.style.top = y+"px";
  div.style.width = w+"px";
  div.style.height = h+"px";
  div.style.position = "absolute";
  div.className = className;
  var container = document.getElementById('grid_container');
  if( position=='top' ){
    container.insertBefore(div, container.firstElementChild);
  } else {
    container.appendChild(div);
  }
  return div;
}

function SetStretchEnvironment( originalRes ){
  /* crea la nuova area */
  function createArea( area, items ){
    var areaId = LibJavascript.AlfaKeyGen(5);
    var areaItem = new ZTPageletObjects.areaObj( "item_area_"+areaId,"");
    areaItem.name= areaId;
    areaItem.type= "area";
    areaItem.row= area.row;
    areaItem.col= area.col;
    areaItem.height= area.height;
    areaItem.width= area.width;
    areaItem.prefx= "0";
    areaItem.suffx= "0";
    areaItem.inserted= true;
    areaItem.items= items;
    areaItem.z= "0";
    areaItem.curTab= "Generic";
    areaItem.fixed= false;
    areaItem.hidden= true;
    areaItem.area_type= 'structure';
    return areaItem;
  }

  /* divido il livello in parti */


  /* funzione ricorsiva che scorre le risorse */
  /* le risorse sono in ordine top left - bottom right */
  function findStretch(items,parentArea){
    var before = [],
      stretch = [],
      after = [],
      stretchItems = items.filter( function(el){ return typeof(el.stretch) == 'string' ? el.stretch == 'true' : el.stretch }),
      stretchItem,
      item;
    var i, j, ii, iii;
    for( j=0; j>=0 && j<stretchItems.length; j++ ){
      stretchItem = stretchItems[j];
      before = [];
      stretch = [];
      after = [];
      if( stretchItem.behavior != 'show' ){ // se la risorsa � in popup o hide
        stretch.push( stretchItem );
      } else {
        /* se un item � stretch devo controllare tutti gli item del suo livello */
        for( i=0; i<items.length; i++){
          item = items[i];
          if( item.behavior !='show' ){
            continue;
          }
          /* se un elemento e' a cavallo della banda dell'area stretch non posso fare la divisione e segnalo un errore */
          if( item !=stretchItem &&
              intersection( stretchItem.col, stretchItem.row //A
                          , stretchItem.col + stretchItem.width, stretchItem.row + stretchItem.height //B
                          , item.col, item.row //C
                          , item.col+item.width, item.row+item.height) ){
            // PSAlert.alert('There is an intersection between '+stretchItem.name+' and '+item.name+'. The stretch can not be apply.');
            alert('There is an intersection between '+stretchItem.name+' and '+item.name+'. The stretch can not be apply.');
            return false;
          } else {
            if( item.row >= stretchItem.row && item.row + item.height <= stretchItem.row + stretchItem.height ){
              stretch.push( item );
            } else if( item.row < stretchItem.row ){
              before.push( item );
            } else {
              after.push( item );
            }
            if( items[i].type == 'area' ){
              /* area */
              if( typeof(items[i].items) == 'string' )
                items[i].items = JSON.parse(items[i].items);
              if( findStretch(items[i].items, items[i]) ){
                items[i].stretchBehavior = 'stretch_container';
              } else {
                items[i].stretchBehavior = '';
              }
            }
          }
        }
      }
      /* creo una tabella che contiene la zona stretch
      *  stretch_container: table
      *    before: table-row
      *    stretch: table-row
      *      table-cell
      *    after: table-row
      */
      var areaContainer = getAreaContainer( stretch.concat(after).concat(before) );
      var area = createArea( areaContainer, [] );
      area.behavior =  stretchItem.behavior;
      area.stretchBehavior = 'stretch_container';
      if( parentArea ) area.flex = parentArea.flex;
      items.push(area);

      if( before.length > 0 ){
        var beforeContainer = getAreaContainer( before );
        var beforeArea = createArea( beforeContainer, before );
        var beforeAreaRow = createArea( beforeContainer, [beforeArea] );
        beforeAreaRow.stretchBehavior= 'before_stretch_row';
        beforeArea.stretchBehavior= 'before_stretch_cell';
        area.items.push( beforeAreaRow );
        /* rimuovo gli item che sono stati inseriti nella nuova area dalla struttura */
        for( ii=0; ii<beforeArea.items.length; ii++){
          iii = items.indexOf(beforeArea.items[ii]);
          if( iii > -1)
            items.splice(iii,1);

        }
      }
      if( stretch.length > 0 ){
        var stretchContainer = getAreaContainer( stretch );
        var stretchArea = createArea( stretchContainer, stretch );
        var stretchAreaRow = createArea( stretchContainer, [stretchArea] );
        for( i=0;i<stretch.length;i++ ){
          stretch[i].areaContainer = area.name;
          if( stretchItems.contains(stretch[i]) ){
            stretchItems.splice(stretchItems.indexOf(stretch[i]),1);
            j--;
          }
        }
        stretchAreaRow.stretchBehavior = 'stretch_row';
        stretchArea.stretchBehavior = 'stretch_cell';
        if( parentArea ) {
          stretchAreaRow.flex = stretchArea.flex = parentArea.flex;
        }
        area.items.push( stretchAreaRow );
        /* rimuovo gli item che sono stati inseriti nella nuova area dalla struttura */
        for( ii=0; ii<stretchArea.items.length; ii++){
          iii = items.indexOf(stretchArea.items[ii]);
          if( iii > -1)
            items.splice(iii,1);

        }
      }
      if( after.length > 0 ){
        var afterContainer = getAreaContainer( after );
        var afterArea = createArea( afterContainer, after );
        var afterAreaRow = createArea( afterContainer, [afterArea] );
        afterAreaRow.stretchBehavior= 'after_stretch_row';
        afterArea.stretchBehavior= 'after_stretch_cell';
        area.items.push( afterAreaRow );
        /* rimuovo gli item che sono stati inseriti nella nuova area dalla struttura */
        for( ii=0; ii<afterArea.items.length; ii++){
          iii = items.indexOf(afterArea.items[ii]);
          if( iii > -1)
            items.splice(iii,1);

        }
      }
    }
    return !!stretch.length;
  }
  formProp.stretch = "false";
  var isStretched = findStretch(originalRes);
  formProp.stretch = isStretched ? 'true' : 'false';
  return originalRes;
}

function intersection(px1, py1, pxx1, pyy1, px2, py2, pxx2, pyy2){
  if ((px1<=px2 && px2<pxx1) || (px1<pxx2 && pxx2<=pxx1)) {
    return !(pyy1<=py2 || pyy2<=py1)
  } else if ((py1<=py2 && py2<pyy1) || (py1<pyy2 && pyy2<=pyy1)) {
    return !(pxx1<=px2 || pxx2<=px1)
  } else {
    return ((px1>px2 && pxx1<pxx2 && py1<py2 && pyy1>pyy2) || (px1<px2 && pxx1>pxx2 && py1>py2 && pyy1<pyy2))
  }
}

function getAreaContainer(items){
  var x=parseInt(items[0].col)
    , y=parseInt(items[0].row)
    , xx=parseInt(items[0].width) + x
    , yy=parseInt(items[0].height) + y
  ;
  for( var i=1; i<items.length; i++){
    if( parseInt(items[i].col) < x ) x = parseInt(items[i].col); //min x
    if( parseInt(items[i].row) < y ) y = parseInt(items[i].row); //min y
    if( parseInt(items[i].col) + parseInt(items[i].width) > xx ) xx = parseInt(items[i].col) + parseInt(items[i].width);
    if( parseInt(items[i].row) + parseInt(items[i].height) > yy ) yy = parseInt(items[i].row) + parseInt(items[i].height);
  }
  return{ col: x
        , row: y
        , width: xx - x
        , height: yy - y
        };
}

function CreateResourcesLogicStructure( originalRes ){

  // function in_rect(i,col,row,width,height){
  //   return col<=i.col && i.col<=col+width && row<=i.row && i.row<=row+height
  // }

  // function filterItems(items,area){
  //   var res = []
  //   for( var i=0; i<items.length;i++){
  //     if( in_rect(items[i],area.col,area.row,area.width,area.height))
  //       res.push(items[i]);
  //   }
  //   return res;
  // }

  function getAreaContainer(items){
    var x=items[0].col
      , y=items[0].row
      , xx=items[0].width + x
      , yy=items[0].height + y
    ;
    for( var i=1; i<items.length; i++){
      if( items[i].col < x ) x = items[i].col; //min x
      if( items[i].row < y ) y = items[i].row; //min y
      if( items[i].col + items[i].width > xx ) xx = items[i].col + items[i].width;
      if( items[i].row + items[i].height > yy ) yy = items[i].row + items[i].height;
    }
    return{ col: x
          , row: y
          , width: xx - x
          , height: yy - y
          };
  }

  function intersection(px1, py1, pxx1, pyy1, px2, py2, pxx2, pyy2){
    if ((px1<=px2 && px2<pxx1) || (px1<pxx2 && pxx2<=pxx1)) {
      return !(pyy1<=py2 || pyy2<=py1)
    } else if ((py1<=py2 && py2<pyy1) || (py1<pyy2 && pyy2<=pyy1)) {
      return !(pxx1<=px2 || pxx2<=px1)
    } else {
      return ((px1>px2 && pxx1<pxx2 && py1<py2 && pyy1>pyy2) || (px1<px2 && pxx1>pxx2 && py1>py2 && pyy1<pyy2))
    }
  }

  function getAdjacentArea(items,area){
    //crea un area con gli elementi adiacenti e quelli che sono nella loro zona di influenza
    //se ci sono elementi non presenti nell'elenco ma che interseca l'area di influenza allora li aggiungo
    var adj = []
    var it;
    for( var i=0; i<items.length; i++ ){
      it = items[i];
      if( intersection( area.col, area.row //A
                      , area.col + area.width, area.row + area.height //B
                      , it.col, it.row //C
                      , it.col+it.width, it.row+it.height) ){ //D
        adj.push( it );
        if( it.col < area.col || it.row < area.row || it.row + it.height > area.row + area.height || it.col + it.width > area.col + area.width ){
          // aggiornamento dimensione area;
          var oldc = area.col , oldr = area.row;
          area.col = Math.min( it.col, area.col);
          area.row = Math.min( it.row, area.row);
          area.width = Math.max( it.col+it.width, oldc+area.width) - area.col;
          area.height = Math.max( it.row+it.height, oldr+area.height) - area.row;
          // richiamo la funzione con le dimenioni variate
          return getAdjacentArea(items,area)
        }
      }
    }
    var areaId = LibJavascript.AlfaKeyGen(5);
    var areaItem = new ZTPageletObjects.areaObj( "item_area_"+areaId,"");
    areaItem.name= areaId;
    areaItem.type= "area";
    areaItem.row= area.row;
    areaItem.col= area.col;
    areaItem.height= area.height;
    areaItem.width= area.width;
    areaItem.prefx= "0";
    areaItem.suffx= "0";
    areaItem.inserted= true;
    areaItem.items= adj;
    areaItem.z= "0";
    areaItem.curTab= "Generic";
    areaItem.fixed= false;
    areaItem.hidden= true;
    areaItem.area_type= 'structure';
    return areaItem;
  }

  function isAdjacent(it1,it2){
    // cerca se 2 elementi sono adiacenti
    if( it1.row >= it2.row && it1.row < it2.row +it2.height || //top1 in 2
        it1.row+ it1.height > it2.row && it1.row+it1.height <= it2.row + it2.height || //bottom1 in 2
        it2.row >= it1.row && it2.row < it1.row +it1.height || //top2 in 1
        it2.row+ it2.height > it1.row && it2.row+it2.height <= it1.row + it1.height //bottom2 in 1
      )
      return true;
    return false;
  }

  function addStructuralArea(area){
    /* l'area deve essere inserita nel posto adatto e vanno rimossi
     * i suoi contenuti dell'array globale:
     * 1 - trovo il contenitore dell'elemento adiacente
     * 2 - rimuovo gli elementi inclusi nell'area di struttura
    */
    var areaEnv = findItemInStructure(area.items[0],originalRes,{items:originalRes}), // ricreo un ogetto anche per l'array iniziale
      ii;
    if(areaEnv){
      for( var i=0; i<area.items.length; i++){
        // rimuovo gli item che ho inserito nell'area
        ii = areaEnv.items.indexOf(area.items[i]);
        if( ii > -1)
          areaEnv.items.splice(ii,1);
        else
          console.log('Impossibile rimuovere risorsa '+area.items[i].id+' inserita nell \'area '+area.id+'. Possibili doppioni.');
      }
      // if( areaEnv.flex ) area.flex = areaEnv.flex; // propagazione del flex al contenuto
      areaEnv.items.push( area );
    } else {
      console.log('Non trovato contenitore della risorsa '+area.items[0].id);
    }
  }

  function findItemInStructure(item,items,parent){
    var retObj;
    for( var i=0; !retObj && i<items.length; i++){
      if( items[i] == item){
        retObj = parent;
      }else if( items[i].type == 'area'){
        retObj = findItemInStructure(item, items[i].items,items[i]);
      }
    }
    return retObj;
  }

  function makeArea(it,ajdItems,items){
    var area = getAreaContainer(ajdItems);
    var adjArea = getAdjacentArea( items, area );
    if( adjArea.items.indexOf(it) > -1 ){
      // non posso utilizzare quest area

    } else { //non � presente anche se stesso, posso creare l'area
      //creo l'area e passo ad analizzare il suo interno
      // resources.push(adjArea);
      // createArea( adjArea.col, adjArea.row, adjArea.width, adjArea.height );
      addStructuralArea(adjArea);
      return adjArea;
    }
  }

  function findAdjacent(it,itms){
    //cerco tutti gli elementi adiacenti ad un elemento
    var adjSx = [],
      adjDx = [],
      sx,
      dx;
    for( var i=0; i<itms.length; i++){
      if( itms[i] != it && isAdjacent(it, itms[i]) && itms.behavior != 'popup')
        // distinguo tra area a dx e a sx
        if( itms[i].col > it.col )
          adjDx.push( itms[i] );
        else
          adjSx.push( itms[i] );
    }
    //se piu' di un elemento e' adiacente allora creo un area che comprende tutta la zona coinvolta
    //rimuovo gli item che sono nell'area dall'array globale
    if( adjSx.length > 1 )
      sx = makeArea(it,adjSx,itms);
    if( adjDx.length > 1 )
      dx = makeArea(it,adjDx,itms);

    //trovo le adiacenze dentro all'area appena creata
    if( sx )
      findArea(sx.items); //chimata ricorsiva
    if( dx )
      findArea(dx.items);

    //trovo le adiacenze con le aree appena create
    if( sx || dx)
      findArea(originalRes);

  }

  /* funzione ricorsiva che scorre le risorse */
  function findArea(items){
    /* se le risorse sono meno di 3 non ci puo' essere adiacenza */
    for( var i=0; i<items.length; i++){
      if( items[i].type == 'area' ){
        if( typeof(items[i].items) == 'string' )
          items[i].items = JSON.parse(items[i].items);
        findArea(items[i].items);
      }
      /* cerco le risorse adiacenti */
      findAdjacent(items[i], items);
    }
  }

  findArea(originalRes);
  return originalRes;
}

function isItemInArea(area, item) {
  return ( parseInt(item.row)>=parseInt(area.row)
  && (parseInt(item.row)+parseInt(item.height)) <= (parseInt(area.row)+parseInt(area.height))
  && parseInt(item.col)>=parseInt(area.col)
  && (parseInt(item.col)+parseInt(item.width)) <= (parseInt(area.col)+parseInt(area.width))
  && item != area );
}

var editor = {
  hightlightCell : function(event){
    /* Gestione del dragover:
      evidenzio la riga e la colonna di passaggio per facilitare il drop
      dragStartDelta potrebbe non essere definito nel caso di item della toolbar oppure di elementeo
      del contents explorer
    */
    HideProperties();

    /* Il preventDefault e' utilizzato per permettere il drop sub backcanvas,
    *  in caso di drop di una risorsa in stato di popup, e' possibile solo sopra una risorsa con il titolo,
    *  in questo caso disattivo il tracciamento del dragover
    */
    if(mode!='popup') {
      event.preventDefault();
      if( !dragStartDelta ){
        dragStartDelta = {x:0,y:0,w:1,h:1};
      }

      var X = event.clientX - dragStartDelta.x,
        Y = event.clientY - dragStartDelta.y,
        W = dragStartDelta.w,
        H = dragStartDelta.h;

      cols.forEach( function(c/*,ii,array*/){
        c.classList.remove('col_item_left_hover')
        c.classList.remove('col_item_right_hover');
      });

      cols.some( function (c, ii, array) {
        var cr = c.getBoundingClientRect();
        if( cr.left < X && cr.right >= X ) {
          if(array[ii-1])
            array[ii-1].classList.add('col_item_left_hover'); //perche' il bordo e' il sinistro
          else
            c.classList.add('col_item_left_hover');
          if(array[ii+W-1])
            array[ii+W-1].classList.add('col_item_right_hover');
          return true;
        }
      });
      rows.forEach( function(r/*,ii*/){
        r.html.classList.remove('row_item_top_hover')
        r.html.classList.remove('row_item_bottom_hover');
      });
      rows.some( function( r, ii, array) {
        var rr = r.html.getBoundingClientRect();
        if( rr.top < Y && rr.bottom >= Y ){
          r.html.classList.add('row_item_top_hover');
          if( array[ii+H] )
            array[ii+H].html.classList.add('row_item_bottom_hover'); //il bordo top del successivo
          else if( array[ii+H-1] )
            array[ii+H-1].html.classList.add('row_item_bottom_hover');
          return true;
        }
      });
    }
  },

  dropItem: function(event) {
    event.stopPropagation();
    var jobj = event.dataTransfer.getData('text');
    /* tentativo di inserimento con d&d dalla toolbar */
    if( !Empty(jobj) ){
      jobj= JSON.parse(jobj);
      if( jobj && jobj.func == 'addItem' ) {
        /* crea l'elemento da inserire */
        addItem(event,jobj.par);
        /* inserisce l'elemento */
        insertItem(event);
      }
    } else {
      if(mode == 'insert' ){
        /* inserimento di una risorsa dal contents explorer */
        insertItem(event);
      } else if(mode == 'edit' ){
        /* Spostamento della risorsa nella griglia */
        var row = 0;
        var col = 0;
        /* trova la riga e la colonna relative al punto di drag */
        cols.some( function(c,ii){
          var cr = c.getBoundingClientRect();
          if( cr.left < event.clientX - dragStartDelta.x && cr.right > event.clientX -dragStartDelta.x){
            col = ii;
            return true;
            /* si ferma perche' potrebbe essere nell'ultima row e prende le dimensioni massime */
          }
        });
        cols.forEach( function(c){
          c.classList.remove('col_item_left_hover');
          c.classList.remove('col_item_right_hover');
        })
        rows.forEach( function(r,ii){
          var rr = r.html.getBoundingClientRect();
          var Y = ( event.clientY - dragStartDelta.y );
          if(r.items.indexOf( itemsHTML[index] ) != -1){
            r.items.splice( r.items.indexOf( itemsHTML[index] ), 1 );
          }
          if( rr.top < Y && rr.bottom > Y){
            row = ii;
            r.items.push( itemsHTML[index] );
            // console.log([rr.top,rr.bottom,ii]);
          }
          r.html.classList.remove('row_item_top_hover');
          r.html.classList.remove('row_item_bottom_hover');
        });
        moveItem(event,row,col);
        dragStartDelta = {x:0,y:0,w:0,h:0};
      }
    }
  },
  load: function() {
    if(!Empty(currentname)){
      if(currentname.indexOf('/')>-1){
        var liof= currentname.lastIndexOf("/");
        folder_path=currentname.substring(currentname.lastIndexOf("/",liof-1),liof+1)
      }
      var url = new JSURL("../servlet/JSPLoad?type=pageleteditor&name="+currentname,true)
      Reload(url.Response()); //caricamento dal def
    } else {
      formProp.template = template;
      if( formProp.template > 6 ){
        //gestione dei template preconfigurati
      }
      FormProperties(true);
      writeHTML();
    }
  }
};

function insertItemsInArea( resources, areaIndex, startIndex ){
  /* resources e' un array di risorse ordinato */
  var t = resources[areaIndex];

  /* Non serve inserire gli item dell'area perche' sono presi da itemsHTML non dalle risorse */
  /* Inserisco gli elementi contenuti nell'area */

  t['items'] = [];
  for(var j=startIndex; j<resources.length; j++){
    var tj=resources[j];
    /* verifico se sia contenuto nell'area*/
    if(
      parseInt(tj.row)>=parseInt(t.row) &&
      (parseInt(tj.row)+parseInt(tj.height)) <= (parseInt(t.row)+parseInt(t.height)) &&
      parseInt(tj.col)>=parseInt(t.col) &&
      (parseInt(tj.col)+parseInt(tj.width)) <= (parseInt(t.col)+parseInt(t.width)) &&
      tj != t
    ){
      if( tj.type =='area'){
        if( tj.area_type=='structure' ){
          resources.splice(j,1);
          continue;
        }
        tj['items'] = [];
        if( j+1 < resources.length ){
           /* passo la parte rimanente dell'array da analizzare */
          insertItemsInArea( resources, j, j+1 );
        }
        t['items'].push(tj);
        resources.splice(j,1);
        j--;
        tj.prefx=tj.suffx=0;
      } else {
        t['items'].push(tj);
        resources.splice(j,1);
        j--;
        tj.prefx=tj.suffx=0;
      }
    }
  }
  return resources;
}

function sortRes(res){
  res.sort(function(a,b){ /* prima le aree */
    if( !a.inserted || !b.inserted ) return b.inserted ? 1 : -1;
    if( a.type == 'area')
      a.items = sortRes(a.items);
    if( b.type =='area')
      b.items = sortRes(b.items);
    if( a.row == b.row ){
      if( a.col == b.col ){
        if(a.type== 'area' && b.type == 'area') {
          if( parseInt(a.z) - parseInt(b.z) == 0){
            if( b.width - a.width == 0 ){
              return b.height - a.height;
            }else{
              return b.width - a.width;
            }
          }else{
            return parseInt(a.z) - parseInt(b.z);
          }
        } else {
          if(a.type == 'area') {
            return -1
          } else if(b.type == 'area') {
            return 1
          } else if( a.type == 'group') { /* dopo le aree i gruppi */
            return -1
          } else if( b.type == 'group') {
            return 1
          }
        }
      } else {
        return a.col - b.col;
      }
    } else {
      return a.row - b.row;
    }
  })
  return res;
}
