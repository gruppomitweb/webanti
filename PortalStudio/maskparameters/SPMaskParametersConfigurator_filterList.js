/* exported
    CSV_SEP SelectThisParameter SortByDescription selectTab FillList
  */
var CSV_SEP="#!$";
var iPrec=-1;
var allField,allFieldDescription,fieldSelected,keyboard,allParameters=[],visibleParameters=[],tabSelected="name";
var oldFilter="";

function getOpener(){
  return (window.opener?window.opener:window.parent)
}

function SelectThisParameter(){
  var value = Ctrl("result").value;
  if (getOpener().loadFieldName)
    getOpener().loadFieldName(value,Ctrl('action').value);
  closeWindow();
}

function closeWindow(){
  if (getOpener().closeSPModalLayer && !Empty(Ctrl('SPModalLayerId').value))
    getOpener().closeSPModalLayer();
  else window.close()
}

function SortByName(a,b){
  var aa = a[0].toLowerCase();
  var bb = b[0].toLowerCase();
  if (aa > bb) return 1;
  if (aa < bb) return -1;
  return 0;
}

function SortByDescription(a,b){
  var aa = a[1].toLowerCase();
  var bb = b[1].toLowerCase();
  if (aa > bb) return 1;
  if (aa < bb) return -1;
  return 0;
}

function Filter(){
  var _filter=Lower(Ctrl('search').value);
  if (_filter.length>2 || _filter.length==0 && _filter!=oldFilter){
    var innerHtml="";
    var idx=0;
    visibleParameters=[];
    var j=tabSelected=='name'?0:1;
    for (var i=0; i<allParameters.length; i++){
      if (Lower(allParameters[i][j]).indexOf(_filter)!=-1){
        visibleParameters.push(allParameters[i]);
        innerHtml+="<li><p id='name"+idx+"' ondblclick='SelectThisParameter()' onclick='selectRow("+idx+")' width='50%' class='standardRow'>"+allParameters[i][0]+"</p><p id='description"+idx+"' ondblclick='SelectThisParameter()' onclick='selectRow("+idx+")' width='50%' class='standardRow right'>"+(allParameters[i][1]||allParameters[i][0])+"</p></li>";
        idx++;
      }
    }
    Ctrl('tableContent').innerHTML=innerHtml;
    document.id('content').nanoScrollerMT();
    iPrec=-1;
    oldFilter=_filter;
  }
}

function selectTab(el){
  if (tabSelected=='name'){
    tabSelected='description';
    el.className='tab tabSelected';
    Ctrl('tabName').className='tab';
  }
  else{
    tabSelected='name';
    el.className='tab tabSelected';
    Ctrl('tabDescription').className='tab';
  }
  Filter();
}

function FillList(){
  allField=(Ctrl('allField').value);
  if ((Empty(allField) || allField=="null") && GetOpener().getAllField)
    allField=GetOpener().getAllField();
  else allField=allField.split(",");
  allFieldDescription=(Ctrl('allFieldDescription').value);
  if ((Empty(allFieldDescription)  || allFieldDescription=="null") && GetOpener().getAllFieldDescription)
    allFieldDescription=GetOpener().getAllFieldDescription()||allField;
  else allFieldDescription=allFieldDescription.split(",");
  fieldSelected=Ctrl('fieldSelected').value;
  var tableContent=Ctrl("content");
  var innerHtml=" <ul id='tableContent'>";
  for (var i=0; i<allField.length; i++){
    allParameters.push([allField[i],allFieldDescription[i]||""]);
  }
  allParameters.sort(SortByName);
  for (i=0; i<allParameters.length; i++){
    innerHtml+="<li><p id='name"+i+"' ondblclick='SelectThisParameter()' onclick='selectRow("+i+")' width='50%' class='standardRow'>"+allParameters[i][0]+"</p><p id='description"+i+"' ondblclick='SelectThisParameter()' onclick='selectRow("+i+")' width='50%' class='standardRow right'>"+(allParameters[i][1]||allParameters[i][0])+"</p></li>";
  }
  innerHtml+='</ul>';
  tableContent.innerHTML=innerHtml;
  var index=-1;
  for (i=0; i<allParameters.length && index==-1; i++){
    if (fieldSelected==allParameters[i][0])
      index=i;
  }
  visibleParameters=allParameters;
  if (index!=-1)
    selectRow(index);
  keyboard=new Keyboard({activate:true});
  var move=function(e,idx){
    if (e){
      e.preventDefault();
      e.stopPropagation()
    }
    if (iPrec!=-1)
      selectRow(iPrec+idx);
  }

  keyboard.addEvents({
    'keydown:up': function(e){move(e,-1); },
    'keydown:down': function(e){move(e,1)}
  });

  Ctrl('search').addEvents({
    'keyup':function(){
      Filter()
    }
  })
  resize();
}


function selectRow(i){
  if (i<visibleParameters.length && i>=0){
    var content=document.id('content'),
    name=document.id('name'+i),
    description=Ctrl('description'+i);
    name.className='selectedRow';
    description.className='selectedRow right';
    name.parentNode.className='selectedTr';
    if ((name.getPosition().y+name.getSize().y) > (content.getPosition().y+content.getSize().y))
      new Fx.Scroll(content).toElement(name,'y')
    else if ((name.getPosition().y) < (content.getPosition().y))
      new Fx.Scroll(content).toElement(name,'y')
    if (iPrec!=-1){
      name=Ctrl('name'+iPrec);
      name.className='standardRow';
      name.parentNode.className=''
      description=Ctrl('description'+iPrec);
      description.className='standardRow right';
    }
    iPrec=i;
    Ctrl('result').value=visibleParameters[i][0];
    if (keyboard)
      keyboard.activate();
  }
}

function resize(){
  document.getElementById('content').style.height=(GetWindowSize().h-document.getElementById('title').offsetHeight-document.getElementById('footer').offsetHeight)+'px';
  if (document.id('content').nanoScrollerMT)
    document.id('content').nanoScrollerMT();
}
