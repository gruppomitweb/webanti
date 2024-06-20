/* exported initIFrame setboname drawSwitch manageOnOffOffline setOfflineMode
    m_function SendData
 */
m_bUpdated = false;
var iFrame = null;
var mybo = "";
function getOpener(){
	return (window.opener ? window.opener : (window.caller ? window.caller : window.parent));
}

function CloseWindow(){
	if (window.closeFrame)
		closeFrame();
	else if (!Empty(SPModalLayerId))
		getOpener().closeSPModalLayer();
	else
		window.close();
}

function SetUpdated(){
	m_bUpdated = true;
}

window.onunload = function(){

}

function initIFrame(){
  document.getElementById("ifrbocont").style.width = "100%";
  document.getElementById("ifrbocont").style.height = 500+"px";
  iFrame = document.getElementById("loadportletbo");
  iFrame.style.width = "100%";
  iFrame.style.height = "100%";
  iFrame.style.border = 0;
  iFrame.style.margin = 0;
  fexec();
}

function fexec(){
  if(datasource=="bo")
    iFrame.src = "../jsp-system/SPVQREditorSelectBO_portlet.jsp?callerFunction=setboname&hideLinkedTables=true&filelist&offlinemode="+offlinemode;
}

function setboname(boname){
  mybo = boname;
}

function drawSwitch(){
  var defaultFont = {name:"Open Sans Light,lucida grande,tahoma,verdana,arial,sans-serif",size:14,weight:"normal"};
  var myW = 33;
  var switchW = 14;
  var check = false;

  var propSwitch = document.createElement("div");
  propSwitch.id = "switch_online";
  propSwitch.className = "onoffprop";
  propSwitch.style.width = (getOffsetWidth("online",defaultFont)+2.5*switchW) +"px";
  propSwitch.title = "Choose online or offline entities";
  var str = "<input ";
  str += "type='checkbox' ";
  str += "name='online' ";
  str += "class='onoffprop-checkbox' ";
  str += "id='online' ";
  if(!offlinemode){
    str += "checked ";
    check = true;
  }

  str += "onclick='manageOnOffOffline(event)' ";
  str += "onchange='setOfflineMode(event)'";
  str += ">";

  str += "<label ";
  str += "class='onoffprop-label' ";
  str += "for='online' ";
  str += ">";

  str += "<div ";
  str += "class='onoffprop-inner";
  str += " whitetextcolor";
  str += "' ";
  str += "data-attr='online' ";

  str += "style='height:"+(myW-5)+"px;";
  str += "line-height:"+(myW-5)+"px;'";
  str += ">";
  str += "</div>";

  str += "<span ";
  str += "id='onlineonoffswitch' ";
  str += "class='onoffprop-switch' ";
  str += "style='";
  str += "height:"+(myW-9)+"px;";
  str += "width:"+(myW-9)+"px;";

  if(check)
    str += "right:2%;";
  else
    str += "right:"+(getOffsetWidth("online",defaultFont)+2.5*switchW-(myW-6))+"px;";

  str += "' >";

  str += "<span ";
  str += "id='onlineonofflabel' ";
  str += "class='onoffprop-switch-label' ";
  if(check){
    str += "style='color:#00B159;";
    str += "font-size:"+Math.round((myW-5)/2)+"px;";
    str += "' >";
    str += "on";
  }
  else{
    str += "style='color:#D11141;";
    str += "font-size:"+Math.round((myW-5)/2)+"px;";
    str += "' >";
    str += "off";
  }
  str += "</span>";


  str += "</span>";
  str += "</label>";

  propSwitch.innerHTML = str;
  document.getElementById("mode").appendChild(propSwitch);
  removeSpanTag();
}

function manageOnOffOffline(e,src){
  var btn;
  if(!src)
    btn = GetEventSrcElement(e);
  else
    btn = src;

  if(btn.checked){
    Ctrl(btn.id+"onofflabel").textContent = "on";
    Ctrl(btn.id+"onofflabel").style.color = "#00B159";
    Ctrl(btn.id+"onofflabel").style.top = "0px";
    Ctrl(btn.id+"onofflabel").style.left = "1px";
    Ctrl(btn.id+"onoffswitch").style.right = "2%";
  }
  else{
    Ctrl(btn.id+"onofflabel").textContent = "off";
    Ctrl(btn.id+"onofflabel").style.color = "#D11141";
    Ctrl(btn.id+"onofflabel").style.top = "1px";
    Ctrl(btn.id+"onofflabel").style.left = "0px";
    Ctrl(btn.id+"onoffswitch").style.right = (btn.parentNode.offsetWidth-27)+"px";
  }
}

function setOfflineMode(e){
  e = !e ? window.event : e;
  var btn = GetEventSrcElement(e);
  offlinemode = !btn.checked;
  fexec();
}

function getOffsetWidth(labelText,labelFont){
  var mySpan = getSpanTag();
  if(labelText!=""){
    mySpan.innerHTML = labelText;
    mySpan.style.fontFamily = labelFont.name;
    mySpan.style.fontWeight = labelFont.weight;
    mySpan.style.fontSize = labelFont.size+'px';
    return mySpan.offsetWidth;
  }
  else
    return 0;
}

function getSpanTag(){  //span che mi serve per il calcolo margini
  var spanId = "smartreport_myspan";
  var mySpan = document.getElementById(spanId);
  if(Empty(mySpan)){
    mySpan = document.createElement("span");
    mySpan.id = spanId;
    mySpan.className = "unselectable";
    document.body.appendChild(mySpan);
    mySpan.style.visibility='hidden';
    mySpan.style.display='inline-block';
  }
  return mySpan;
}

function removeSpanTag(){
  var spanId = "smartreport_myspan";
  var mySpan = document.getElementById(spanId);
  if(!Empty(mySpan))
    document.body.removeChild(mySpan);
}

function getConfirm(isOk){
	if(isOk == true)
		applyOK();
	else
		applyCancel();
	SetUpdated();
	CloseWindow();
}

function applyOK(){
	var opener = getOpener();
  if(opener && opener[callerFunction]) opener[callerFunction](mybo,{offlinemode: offlinemode});
}

function applyCancel(){
}

var m_function = 'discard'
function SendData(/*action*/) { //simulate BO - sendData - per chiusura da spmodallayer
  getConfirm(false);
}
