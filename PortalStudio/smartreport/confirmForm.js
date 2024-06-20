/*  exported draw m_function SendData conf */
m_bUpdated = false;
var conf = false;

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
	if(getOpener() && getOpener().closeConfirmForm) getOpener().closeConfirmForm();
}

function draw(msg){
	var pdiv = document.getElementById("confirmBody");
	var text = document.createElement("div");
	text.className = "unselectable message";
	text.textContent = msg;
	pdiv.appendChild(text);
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
	if(callerFunction=="delete")
		opener.deleteItem();
	else if(callerFunction=="remove")
		opener.removeFieldConfirm(true,objparam);
	else if(callerFunction=="calc")
		opener.CheckCalculateField(objparam,true);
	else if(callerFunction=="deletemissing")
		opener.removeMissingFields(objparam.alias,objparam.zone);
  else if(opener[callerFunction])
    opener[callerFunction]();
}

function applyCancel(){
	var opener = getOpener();
	if(callerFunction=="remove")
		opener.removeFieldConfirm(false,objparam);
	else if(callerFunction=="calc")
		opener.CheckCalculateField(objparam,false);
	else if(callerFunction=="deletemissing")
		opener.deleteItem();
  else if(opener.ExecAfterCancel)
    opener.ExecAfterCancel();
  //if(callerFunction=="delete"){}
}

var m_function = 'discard'
function SendData(/*action*/) { //simulate BO - sendData - per chiusura da spmodallayer
  getConfirm(false);
}
