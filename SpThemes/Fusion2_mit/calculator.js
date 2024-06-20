var bShowCalc=false
var ctrlCalc="empty"
var modCalc,decCalc
var operand
var field

var imgDir='../'+(typeof(ZtVWeb)!='undefined' ? ZtVWeb.theme : (window['m_cThemePath'] ? m_cThemePath : 'SpTheme_2'))+'/formPage/';
var calculatorWidth = SPTheme.calculatorWidth||250;
var calculatorColor = SPTheme.CalculatorFontColor||"#FFFFFF";
var calcTitle  = Translate("MSG_CALC_TITLE");
var calcClose  = Translate("MSG_CALC_CLOSE");
var calcMark   = Translate("MSG_CALC_CHANGE_MARK");
var calcInsert = Translate("MSG_CALC_INSERT_2ND_OP");

if (calcTitle==="MSG_CALC_TITLE") {
  if(typeof(m_cLanguage)!='undefined'){
    switch(m_cLanguage){
      case 'ita':
      case 'default':
        calcTitle  = 'Calcolatrice Base';
        calcClose  = 'Chiudi la calcolatrice';
        calcMark   = 'Cambia il segno';
        calcInsert = 'Inserisci il secondo operando';
        break;
      case 'eng':
        calcTitle  = "Basic Calculator";
        calcClose  = "Close the Calculator";
        calcMark   = "Change the mark";
        calcInsert = "Insert the second operand of the operation";
        break;
    }
  }
}

function ShowPopUpCalculator(fieldFrom,keyCode,modPict,decPict) {

  bShowCalc=true
  documentAddClick(hideCalc)
  modCalc=modPict
  decCalc=decPict
  operand=String.fromCharCode(keyCode)
  field=fieldFrom
  var imgclse=SPTheme.calculatorClose||imgDir+"close.gif";
  var imgChgMrk=SPTheme.calculatorCalculation||imgDir+"changemark.gif";
  if (imgclse.substr(0,1)=='{') {
    imgclse = JSON.parse(imgclse);
    var closeimg="<span title='"+calcClose+"' style='cursor:pointer;font-family:"+imgclse.FontName+";"+(imgclse.Size?"font-size:"+imgclse.Size+"px;":"")+
                  (imgclse.FontWeight?"font-weight:"+imgclse.FontWeight+";":"")+(imgclse.Color?"color:"+imgclse.Color+";":"")+
                  "' onclick=CloseCalc()>"+String.fromCharCode(imgclse.Char)+"</span>";
  } else
    var closeimg="<IMG SRC='"+imgclse+"' BORDER='0' ALT='"+calcClose+"' title='"+calcClose+"' style='cursor:pointer' onclick=CloseCalc()>";

  if (imgChgMrk.substr(0,1)=='{') {
    imgChgMrk = JSON.parse(imgChgMrk);
    var chgMark="<span title='"+calcMark+"' style='cursor:pointer;font-family:"+imgChgMrk.FontName+";"+(imgChgMrk.Size?"font-size:"+imgChgMrk.Size+"px;":"")+
                  (imgChgMrk.FontWeight?"font-weight:"+imgChgMrk.FontWeight+";":"")+(imgChgMrk.Color?"color:"+imgChgMrk.Color+";":"")+
                  "' onclick=\"ChangeMarkField(Ctrl(field.id+'_CALC'));Ctrl(field.id+'_CALC').focus();\">"+String.fromCharCode(imgChgMrk.Char)+"</span>";
  } else 
    var chgMark="<IMG SRC='"+imgChgMrk+"'  BORDER='0' ALT='"+calcMark+"' title='"+calcMark+"' style='cursor:pointer' onclick=\"ChangeMarkField(Ctrl(field.id+'_CALC'));Ctrl(field.id+'_CALC').focus();\">"
  var head="<table cellspacing='0' cellpadding='0' style='width:100%;padding:4px;' class='CalculatorHeaderAll'>" +
  			"<tr>" +
  				"<td class='CalculatorHeader' nowrap='nowrap' id='head' align='left' valign='middle'><span>"+calcTitle+"</span></td>" +
  				"<td class='CalculatorDragger' valign='middle' style='width:100%;cursor:move;' onmousedown=dragCalculator(event,'calculatorDiv',this)>&nbsp</td>" +
  				"<td align='right' valign='middle'>"+closeimg+"</td>" +
  			"</tr>" +
  			"</table>";
  var text=field.value
  var input="<input id='"+field.id+"_CALC' class='Field' type=text title='"+calcInsert+"' value='' maxlength="+field.maxLength+" style='height:"+field.offsetHeight+"px;width:100%;text-align:right;box-sizing:border-box;'>"
  var result="<div onclick=ProcessEqual() style='cursor:pointer;'><span style='color:"+calculatorColor+"'>&nbsp;=</span></div>"
  var OperationTbl="<table cellspacing='0' cellpadding='0' class='CalculatorContent' style='padding:5px;padding-right:10px;width:"+calculatorWidth+"px;'>" +
	  		"<tr>" +
		  		"<td colspan='3' align='right'><span style='color:"+calculatorColor+"'>"+text+" "+operand+"</span></td>" +
	  		"</tr>"+
	        "<tr>" +
	        	"<td align='center'>"+chgMark+"</td>" +
	        	"<td align='right' width='80%'>"+input+"</td>" +
	        	"<td align='right'>"+result+"</td>" +
	        "</tr>" +
        "</table>";
  var MainTbl="<table id='calculator' cellspacing='0' cellpadding='0' style='width:"+calculatorWidth+"px;' onmouseover='PrepareToDoNotHideCalc()' onmouseout='PrepareToHideCalc()'>"+
              	"<tr>" +
              		"<td align=center>"+head+"</td>" +
              	"</tr>" +
              	"<tr>" +
              		"<td>"+OperationTbl+"</td>" +
              	"</tr>" +
              	"<tr>" +
              		"<td class='CalculatorFooter' style='width=100%;'>&nbsp</td>" +
              	"</tr>" +
              "</table>";
  ctrlCalc=="empty" ? ctrlCalc=document.createElement("div") : ctrlCalc.style.display='block'
  ctrlCalc.id='calculatorDiv'
  ctrlCalc.style.position="absolute"
  ctrlCalc.style.width=calculatorWidth+"px";
  ctrlCalc.style.zIndex="999";
  var aTag = field
  var leftpos=0,toppos=0
  do {
    aTag = aTag.offsetParent
    leftpos += aTag.offsetLeft
    toppos += aTag.offsetTop
  } while(aTag.tagName!="BODY")

  ctrlCalc.className='Calculator'
  ctrlCalc.innerHTML=MainTbl
  aTag.appendChild(ctrlCalc)

  if(document.body.offsetLeft+document.body.offsetWidth - 1 < (field.offsetLeft+leftpos)+Ctrl("calculatorDiv").offsetWidth){
    if ((field.offsetLeft - Ctrl("calculatorDiv").offsetWidth + field.offsetWidth)<0) // non ci sta nè allineato a destra nè a sinistra
      ctrlCalc.style.left=0;
    else //allineo a destra con field
      ctrlCalc.style.left = (field.offsetLeft - Ctrl("calculatorDiv").offsetWidth + field.offsetWidth)+'px'; //- (IsIE()||IsIE_Mac?42:0))+'px'
  }
  else //allineo a sinistra con field
    ctrlCalc.style.left=(field.offsetLeft+leftpos)+'px'

  if ((document.body.offsetTop+document.body.offsetHeight) < (field.offsetTop+toppos+field.offsetHeight + 2 + Ctrl("calculatorDiv").offsetHeight))
    ctrlCalc.style.top=(field.offsetTop - ctrlCalc.offsetHeight +toppos )+'px'
  else
    ctrlCalc.style.top=(field.offsetTop+toppos+field.offsetHeight + 2)+'px'


  Ctrl(field.id+"_CALC").onkeypress=ApplyPictCalc
  Ctrl(field.id+"_CALC").onkeydown=EscReturnCalc
  try {
    Ctrl(field.id+"_CALC").focus()
    last_focused_comp=Ctrl(field.id+"_CALC")
  } catch(e) {}



}
function CalcAndClose() {
  DoCalc() ? CloseCalc() : SetControlFocus(field.id+'_CALC')
}
function PercentageCalc() {
  var x=HtW(field.value,'N')
  var y=HtW(Ctrl(field.id+'_CALC').value,'N')
  Ctrl(field.id+'_CALC').value=WtH(x*y/100,'N',0,0)
}
function DoCalc() {
  var x=HtW(field.value,'N')
  var y=HtW(Ctrl(field.id+'_CALC').value,'N')
  var calculatedVal
  if (y==0 && operand=='/') {
    alert("Cannot divide by zero")
    return false
  }
  calculatedVal=eval(x+operand+"("+y+")")
  var maxVal=parseFloat(Replicate('9',modCalc)+'.'+Replicate('9',decCalc))
  if (Math.abs(calculatedVal) > maxVal) {
    alert("Picture overflow")
    return false
  }
  window["Set_"+field.name](calculatedVal);
  return true
}
function CloseCalc() {
  ctrlCalc.style.display='none'
  SetControlFocus(field.id)
  documentRemoveClick(hideCalc)
}
function ApplyPictCalc(e) {
  var keyCode=KeyCodeCalc(e)
  if (keyCode==42 || keyCode==43 || keyCode==47 || keyCode==45) {
    if (!Empty(Ctrl(field.id+'_CALC').value)) {
      if (DoCalc()) {
        ctrlCalc.style.display='none'
        ShowPopUpCalculator(field,keyCode==95?45:keyCode,modCalc,decCalc)
      } else
        SetControlFocus(field.id+'_CALC')
    } else {
      ctrlCalc.style.display='none'
      ShowPopUpCalculator(field,keyCode==95?45:keyCode,modCalc,decCalc)
    }
    return false
  } else if (keyCode==61)
    Empty(Ctrl(field.id+'_CALC').value) ? CloseCalc() : CalcAndClose()
  else if(keyCode==37 && !Empty(Ctrl(field.id+'_CALC').value))
    PercentageCalc()
  else if(keyCode==95)
    ChangeMarkField(Ctrl(field.id+'_CALC'))
  return CheckNumWithPict(e,[modCalc,decCalc,''])
}
function EscReturnCalc(e) {
  var keyCode=KeyCodeCalc(e)
  if(typeof(e)=='undefined')
    e=window.event
  if (keyCode == 27) {
    CloseCalc()
    IsIE() || IsIE_Mac() ? e.keyCode = null : e.preventDefault()
  } else if (keyCode == 13) {
    ProcessEqual()
    IsIE() || IsIE_Mac() ? e.keyCode = null : e.preventDefault()
  }
}
function ProcessEqual(){
  Empty(Ctrl(field.id+'_CALC').value) ? CloseCalc() : CalcAndClose()
}
function KeyCodeCalc(e) {
  var keyCode
  if (typeof(e)!='undefined' && typeof(e.rootEvent) != 'undefined') {
    keyCode = e.keyCode
    e = e.rootEvent
  } else if(typeof(e)=='undefined' && (IsIE() || IsIE_Mac()))
      e=window.event
  if (typeof(keyCode)=='undefined')
    keyCode = GetKeyCode(e)
  return keyCode
}
function hideCalc() {

  if (!bShowCalc && ctrlCalc!="empty")
    CloseCalc()

}
function PrepareToDoNotHideCalc(){
  bShowCalc = true
}
function PrepareToHideCalc(){
  bShowCalc = false
}

function dragCalculator(event,obj,dragger){
  dragToolbar(event,obj,dragger.offsetLeft);
}
